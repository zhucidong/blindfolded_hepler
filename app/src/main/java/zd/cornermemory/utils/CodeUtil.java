package zd.cornermemory.utils;

import android.text.TextUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import zd.cornermemory.bean.Cube;
import zd.cornermemory.bean.FiveTeamCorner;

import static java.util.Collections.max;

/**
 * Created by zhud on 2019/4/29.
 */

public class CodeUtil {
    //记录角块色相
    static List<Integer> hues = new ArrayList<>();
    static int team = 5;
    static FiveTeamCorner disrupt;

    public static void main(String[] r){
        getCode(5);
    }


    static String[][] getCustomCodes() {
        String[][] corner = null;
        Cube cube = new Cube();
        cube.init();

        List<String> up = cube.getUpCornerSource();
        List<String> down = cube.getDownCornerSource();
        List<String> left = cube.getLeftCornerSource();
        List<String> right = cube.getRightCornerSource();
        List<String> front = cube.getFrontCornerSource();
        List<String> back = cube.getBackCornerSource();

        String[] corner0 = {up.get(0),back.get(3),right.get(0)};
        String[] corner1 = {up.get(1),right.get(3),front.get(0)};
        String[] corner2 = {up.get(2),front.get(3),left.get(0)};
        String[] corner3 = {up.get(3),left.get(3),back.get(0)};


        String[] corner4 = {down.get(0),front.get(1),right.get(2)};
        String[] corner5 = {down.get(1),right.get(1),back.get(2)};
        String[] corner6 = {down.get(2),back.get(1),left.get(2)};
        String[] corner7 = {down.get(3),left.get(1),front.get(2)};

        int index = 1; ////默认缓冲UFR
        String cornerBufferStr = SPUtils.getInstance().getString(SpKey.CORNER_BUFFER);
        if(!TextUtils.isEmpty(cornerBufferStr)){
            index = Integer.parseInt(cornerBufferStr);
        }
        switch (index) {
            case 0:
                corner = new String[][]{corner1,corner2,corner3,corner4,corner5,corner6,corner7};
                break;
            case 1:
                corner = new String[][]{corner0,corner2,corner3,corner4,corner5,corner6,corner7};
                break;
            case 2:
                corner = new String[][]{corner1,corner0,corner3,corner4,corner5,corner6,corner7};
                break;
            case 3:
                corner = new String[][]{corner1,corner2,corner0,corner4,corner5,corner6,corner7};
                break;
            case 4:
                corner = new String[][]{corner1,corner2,corner3,corner0,corner5,corner6,corner7};
                break;
            case 5:
                corner = new String[][]{corner1,corner2,corner3,corner4,corner0,corner6,corner7};
                break;
            case 6:
                corner = new String[][]{corner1,corner2,corner3,corner4,corner5,corner0,corner7};
                break;
            case 7:
                corner = new String[][]{corner1,corner2,corner3,corner4,corner5,corner6,corner0};
                break;
        }
        return corner;
    }






    /**
     * 获取角块编码
     * @param teams 组数，最多5组
     * @return 返回编码  例如 QD,OG,AI,TW,ZW,  每一组以逗号隔开
     */
    public static String getCode(int teams){
        if(teams>5){
            return "";
        }
        hues.clear();
        team = teams;
        int count = team*2;
        List<Integer> have = new ArrayList<>();//已经记录的角块位置index
        if(team==5){
            Random random = new Random();
            int type =random.nextInt(3);
            switch (type) {
                case 0:
                    disrupt = FiveTeamCorner.ONE;
                    break;
                case 1:
                    disrupt = FiveTeamCorner.TWO;
                    break;
                case 2:
                    disrupt = FiveTeamCorner.THREE;
                    break;
            }

        }

        for(int i=0;i<count;i++){
            int index = getIndex(have);
            have.add(index);
            hues.add(getIndex2(have));
        }

        StringBuffer sb = new StringBuffer();
        String[][] corner = getCustomCodes();
        for(int i=0;i<have.size();i++){

            sb.append(corner[have.get(i)][hues.get(i)]);
            if(i%2!=0){
                sb.append("  ");
            }
        }
//        System.out.println(have);
//        System.out.print(sb.toString());
        have.clear();
        return sb.toString();
    }


    /**
     * 获取角块位置index
     * @param haves 已存在的index
     * @return
     */
    public static int getIndex(List<Integer> haves){
        Random random = new Random();
        int index = random.nextInt(7);

        if(team==5){
            switch (disrupt) {
                case ONE://334
                    if(haves.size()==2){
                        return haves.get(0);
                    }else if(haves.size()==5){
                        return haves.get(3);
                    }else if(haves.size()==8){
                        if(haves.contains(index)){
                            return getIndex(haves);
                        }
                    }
                    break;
                case TWO://343
                    if(haves.size()==2){
                        return haves.get(0);
                    }else if(haves.size()==5){//控制它不能变成334
                        if(haves.contains(index)){
                            return getIndex(haves);
                        }
                    }else if(haves.size()==6){
                        return haves.get(3);
                    }
                    break;
                case THREE://433
                    if(haves.size()==2){
                        if(haves.contains(index)){
                            return getIndex(haves);
                        }
                    }else if(haves.size()==3){
                        return haves.get(0);
                    }else if(haves.size()==6){
                        return haves.get(4);
                    }
                    break;

            }



        }

        if(!isCorrect(index,haves)){
            return getIndex(haves);
        }
        return index;
    }

    //获取角块色相index  需控制0归位
    static int getIndex2(List<Integer> haves){
        Random random = new Random();
        int index = random.nextInt(3);
        if(isRepeat(haves)){//有小循环，需要保证色相借位
            int max = Collections.max(repeat(haves));
            if(haves.size()-2==max){
                return hues.get(hues.size()-1);
            }
        }
        if(isRepeat(haves)&&haves.size()==team*2){
            return 0;
        }
        return index;
    }

    /**
     * 判断取到的index是否正确
     * 为了模拟角块小循环，这里规定相同的index最多出现两次且不互邻
     * @return
     */
    static boolean isCorrect(int index,List<Integer> haves){
        if(!haves.contains(index)){
            return true;
        }

        //只有两三组的情况，只好不要有小循环
        if(team==3||team==2){
            if(haves.contains(index)){
                return false;
            }
        }

        int count = 0;
        int offset = 0;//记录相同的index
        for(int i = 0;i<haves.size();i++){
            int have = haves.get(i);
            if(have == index){
                count++;
                offset = i;
            }
        }

        if(count>1){
            return false;
        }else{
            //判断是否互邻
            if(haves.size()-1 == offset){
                return false;
            }else{
                //判断是否为 循环套循环 例如[0, 2, 1, 4, 0, 1] 这种借0还0之后，0-0区间里存在1，所以后面不应该再出现1
                List<Integer> indexs = repeat(haves);
                if (indexs.size() == 0) {
                    return true;
                }else{
                    int max = max(indexs);
                    List<Integer> l = haves.subList(0,max);
                    if(l.contains(index)){
                        return false;
                    }else{
                        return true;
                    }
                }


            }
        }
    }

    /**
     * 判断是否有重复数据
     * @param haves
     * @return
     */
    static boolean isRepeat(List<Integer> haves){
        Set<Integer> set = new HashSet<>();
        for (int have : haves) {
            set.add(have);
        }
        if(set.size()!=haves.size()){
            return true;
        }else {
            return false;
        }
    }

    /**
     * 返回相同元素的首次尾次出现的index
     * @param haves
     * @return
     */
    static List<Integer> repeat(List<Integer> haves){
        List<Integer> indexs = new ArrayList<>();

        int i0f = haves.indexOf(0);
        int i0l = haves.lastIndexOf(0);
        if(i0f!=-1&&i0f!=i0l){
//            Integer[] integers = {i0f,i0l};
//            indexs.add(integers);
            indexs.add(i0l);
        }

        int i1f = haves.indexOf(1);
        int i1l = haves.lastIndexOf(1);
        if(i1f!=-1&&i1f!=i1l){
//            Integer[] integers = {i1f,i1l};
//            indexs.add(integers);
            indexs.add(i1l);
        }


        int i2f = haves.indexOf(2);
        int i2l = haves.lastIndexOf(2);
        if(i2f!=-1&&i2f!=i2l){
//            Integer[] integers = {i2f,i2l};
//            indexs.add(integers);
            indexs.add(i2l);
        }

        int i3f = haves.indexOf(3);
        int i3l = haves.lastIndexOf(3);
        if(i3f!=-1&&i3f!=i3l){
//            Integer[] integers = {i3f,i3l};
//            indexs.add(integers);
            indexs.add(i3l);
        }

        int i4f = haves.indexOf(4);
        int i4l = haves.lastIndexOf(4);
        if(i4f!=-1&&i4f!=i4l){
//            Integer[] integers = {i4f,i4l};
//            indexs.add(integers);
            indexs.add(i4l);
        }

        int i5f = haves.indexOf(5);
        int i5l = haves.lastIndexOf(5);
        if(i5f!=-1&&i5f!=i5l){
//            Integer[] integers = {i5f,i5l};
//            indexs.add(integers);
            indexs.add(i5l);
        }

        int i6f = haves.indexOf(6);
        int i6l = haves.lastIndexOf(6);
        if(i6f!=-1&&i6f!=i6l){
//            Integer[] integers = {i6f,i6l};
//            indexs.add(integers);
            indexs.add(i6l);
        }

        return indexs;

    }

}
