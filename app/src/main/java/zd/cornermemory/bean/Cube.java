package zd.cornermemory.bean;

import android.graphics.Color;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import zd.cornermemory.utils.CoordinateUtil;
import zd.cornermemory.utils.SPUtils;
import zd.cornermemory.utils.SpKey;

/**
 * Created by zhud on 2019/9/25.
 * 描述魔方状态--角块，棱块（中心块也算棱块），角块统一按照从右上角顺时针 0，1，2，3 顺序，
 *
 * 棱块从12点方向开始 顺时针 0，1，2，3 中心块位置为4
 */

public class Cube {
    //U层 角、棱
    private List<String> upCorner;
    private List<String> upEdge;

    //D层 角、棱
    private List<String> downCorner;
    private List<String> downEdge;

    //L层 角、棱
    private List<String> leftCorner;
    private List<String> leftEdge;

    //R层 角、棱
    private List<String> rightCorner;
    private List<String> rightEdge;

    //F层 角、棱
    private List<String> frontCorner;
    private List<String> frontEdge;

    //B层 角、棱
    private List<String> backCorner;
    private List<String> backEdge;

    //魔方贴纸
    private List<CubePaster> pasters;


    //U层 角、棱 原始位置
    private List<String> upCornerSource;
    private List<String> upEdgeSource;

    //D层 角、棱
    private List<String> downCornerSource;
    private List<String> downEdgeSource;

    //L层 角、棱
    private List<String> leftCornerSource;
    private List<String> leftEdgeSource;

    //R层 角、棱
    private List<String> rightCornerSource;
    private List<String> rightEdgeSource;

    //F层 角、棱
    private List<String> frontCornerSource;
    private List<String> frontEdgeSource;

    //B层 角、棱
    private List<String> backCornerSource;
    private List<String> backEdgeSource;

    private boolean isKeepHue = true;//是否保持色相借位 角
    private boolean isKeepHueEdge = true;//是否保持色相借位 棱
    private List<String> cornerJiewei ;//预先设定的借位顺序
    private List<String> edgeJiewei ;//预先设定的借位顺序 棱
    private String currentCornerJie;//当前的借位编码
    private String currentEdgeJie;//当前的借位编码
    private boolean isCornerFinish = false;//是否结束编码
    private boolean isEdgeFinish = false;//是否结束编码
    private List<String> tempResultCodes = new ArrayList<>();//最终输出编码
    private List<String> tempFasnseCodes = new ArrayList<>();//原地翻色编码

    private List<String> tempResultEdgeCodes = new ArrayList<>();//最终输出编码
    private List<String> tempFasnseEdgeCodes = new ArrayList<>();//原地翻色编码

    private List<ResultCode> cornerCodes = new ArrayList<>();
    private List<ResultCode> edgeCodes = new ArrayList<>();

    /**
     * 初始化
     */
    public void init() {
        //初始化编码
        List<CubeCode> codes = CoordinateUtil.getCustomCode();
        initCubeCode(codes);

        //初始化颜色
        List<DyeCubeBean> custom = CoordinateUtil.getCoordinate();
        initCubeColor(custom);

        //初始化某一块对应的编码 例如UFR,[J,K,L]  RFL[A,B,C]
        initLoacationCodes();
        //是否保持色相
        isKeepHue = SPUtils.getInstance().getBoolean(SpKey.KEEP_HUE);
        isKeepHueEdge = SPUtils.getInstance().getBoolean(SpKey.KEEP_HUE_EDGE);
        //借位顺序
        initJieweiSort();
        
        //初始化块信息，用于生成打乱
        initKuai();
    }

    /**
     * 手动转角，转棱
     * @param innerClass
     * @param index 0 不转   1顺  2逆
     */
    private void fanse(InnerClass innerClass,int index){
        switch (innerClass.getCornerOrEdge()) {
            case CORNER:
                if (index != 0) {
                    List<String> edgeList0 = innerClass.getWeizhi().get(0);
                    int edgeIndex0 = innerClass.getIndexs().get(0);

                    List<String> edgeList1 = innerClass.getWeizhi().get(1);
                    int edgeIndex1 = innerClass.getIndexs().get(1);

                    List<String> edgeList2 = innerClass.getWeizhi().get(2);
                    int edgeIndex2 = innerClass.getIndexs().get(2);

                    String edgeCode0 = edgeList0.get(edgeIndex0);
                    String edgeCode1 = edgeList1.get(edgeIndex1);
                    String edgeCode2 = edgeList2.get(edgeIndex2);

                    if(index==1){
                        edgeList0.remove(edgeIndex0);
                        edgeList1.remove(edgeIndex1);
                        edgeList2.remove(edgeIndex2);

                        edgeList0.add(edgeIndex0,edgeCode1);
                        edgeList1.add(edgeIndex1,edgeCode2);
                        edgeList2.add(edgeIndex2,edgeCode0);

                    }else if(index == 2){

                        edgeList0.remove(edgeIndex0);
                        edgeList1.remove(edgeIndex1);
                        edgeList2.remove(edgeIndex2);

                        edgeList0.add(edgeIndex0,edgeCode2);
                        edgeList1.add(edgeIndex1,edgeCode0);
                        edgeList2.add(edgeIndex2,edgeCode1);
                    }

                }
                break;


            case EDGE:
                if (index != 0) {
                    List<String> edgeList0 = innerClass.getWeizhi().get(0);
                    int edgeIndex0 = innerClass.getIndexs().get(0);

                    List<String> edgeList1 = innerClass.getWeizhi().get(1);
                    int edgeIndex1 = innerClass.getIndexs().get(1);

                    String edgeCode1 = edgeList0.get(edgeIndex0);
                    String edgeCode2 = edgeList1.get(edgeIndex1);

                    edgeList0.remove(edgeIndex0);
                    edgeList0.add(edgeIndex0,edgeCode2);

                    edgeList1.remove(edgeIndex1);
                    edgeList1.add(edgeIndex1,edgeCode1);

                }
                break;
        }
    }


    /**
     * 从集合随机取几个数字，取过的不能再次取
     * @param indexs
     * @param count
     * @return 返回取到的数字
     */
    private List<Integer> getRandom(List<Integer> indexs,int count){
        List<Integer> result = new ArrayList<>();
        if (count > indexs.size()) {
            System.out.println("取的数据超过集合长度。。。");
            return result;
        }

        for(int i=0;i<count;i++) {
            int bm = indexs.get(new Random().nextInt(indexs.size()));
            result.add(bm);
            indexs.remove((Integer) bm);
        }

        return result;
    }


    public void cornerRandomStatus(Probability corner){
        List<Integer> cornerLocation = new ArrayList<>();//存入8个角块位置标识
        List<Integer> alreadyList = new ArrayList<>();//存入 已经取过的角块位置
        cornerLocation.add(0);
        cornerLocation.add(1);
        cornerLocation.add(2);
        cornerLocation.add(3);
        cornerLocation.add(4);
        cornerLocation.add(5);
        cornerLocation.add(6);
        cornerLocation.add(7);
        //取当前缓冲块
        int bufferIndex = 1; ////默认缓冲UFR
        String cornerBufferStr = SPUtils.getInstance().getString(SpKey.CORNER_BUFFER);
        if(!TextUtils.isEmpty(cornerBufferStr)){
            bufferIndex = Integer.parseInt(cornerBufferStr);
        }
        int[] conerSe = corner.getSeparator();//3+5   2+2  ....
        boolean isHoming= corner.isHoming();
        int turnOverColorCount = corner.getTurnOverColorCount();

        if (isHoming) {//缓冲归位
            //先取出缓冲块
            cornerLocation.remove((Integer) bufferIndex);
            if (conerSe[0] == 0) {//纯翻色
                handleCornerSx(cornerLocation, bufferIndex, turnOverColorCount);
                return;
            }
            for(int i=1;i<conerSe.length;i++){
                int count = conerSe[i];//每组的长度
                List<Integer> indexs = getRandom(cornerLocation,count);
                alreadyList.addAll(indexs);//存入已经取过的集合中，待翻色
                //取出来之后交换它们的位置
//                for(int j =0;j<indexs.size();j++) {
//                    if (j + 1 < indexs.size()) {
//                        exchange(CornerOrEdge.CORNER,indexs.get(j),indexs.get(j+1));
//                  }
//                }
                move(CornerOrEdge.CORNER,indexs);
            }

            //手动翻色，否则打乱出来的都是0位置的 三循环
            int length = alreadyList.size();
            List<Integer> sexianIndex = new ArrayList<>();
            for(int i=1;i<length;i++) {//从已经编过的码中取出长度-1 个 随机翻色， 剩余一个用来适合正确的色相问题
                int inde = getRandom(alreadyList,1).get(0);
                InnerClass innerClass = cornerK.get(inde);
                int index = new Random().nextInt(3);
                sexianIndex.add(index);
                fanse(innerClass,index);
            }
            InnerClass innerClass = cornerK.get(alreadyList.get(0));//取出已编码中 仅剩下的一个来适配色相问题
            int sexianHe = 0;
            for (int i : sexianIndex) {
                sexianHe+=i;
            }
            switch (sexianHe % 3) {
                case 1:
                    fanse(innerClass,2);
                    break;
                case 2:
                    fanse(innerClass,1);
                    break;
            }
            handleCornerSx(cornerLocation, bufferIndex, turnOverColorCount);


        }else{//缓冲不归位

            //先取出缓冲块
            cornerLocation.remove((Integer) bufferIndex);

            for(int i=0;i<conerSe.length;i++){
                int count = conerSe[i];//每组的长度
                List<Integer> indexs = new ArrayList<>();
                if(i==0){//缓冲块先取出来搭配第一个小循环
                    count = conerSe[i]-1;
                    indexs.add(bufferIndex);
                }
                indexs.addAll(getRandom(cornerLocation,count));

                alreadyList.addAll(indexs);//存入已经取过的集合中，待翻色
                //取出来之后交换它们的位置
//                for(int j =0;j<indexs.size();j++) {
//                    if (j + 1 < indexs.size()) {
//                        exchange(CornerOrEdge.CORNER,indexs.get(j),indexs.get(j+1));
//                    }
//                }
                move(CornerOrEdge.CORNER,indexs);
            }

            //手动翻色，否则打乱出来的都是0位置的 三循环
            int length = alreadyList.size();
            List<Integer> sexianIndex = new ArrayList<>();
            for(int i=1;i<length;i++) {//从已经编过的码中取出长度-1 个 随机翻色， 剩余一个用来适合正确的色相问题
                int inde = getRandom(alreadyList,1).get(0);
                InnerClass innerClass = cornerK.get(inde);
                int index = new Random().nextInt(3);
                sexianIndex.add(index);
                fanse(innerClass,index);
            }
            InnerClass innerClass = cornerK.get(alreadyList.get(0));//取出已编码中 仅剩下的一个来适配色相问题
            int sexianHe = 0;
            for (int i : sexianIndex) {
                sexianHe+=i;
            }
            switch (sexianHe % 3) {
                case 1:
                    fanse(innerClass,2);
                    break;
                case 2:
                    fanse(innerClass,1);
                    break;
            }
            handleCornerSx(cornerLocation, bufferIndex, turnOverColorCount);
        }
    }


    /**
     * 处理角块色相问题
     * @param cornerLocation
     * @param bufferIndex
     * @param turnOverColorCount
     */
    private void handleCornerSx(List<Integer> cornerLocation, int bufferIndex, int turnOverColorCount) {
        //处理用户提供的原地翻色数量
        //根据数量取出需要原地翻色的块
        List<Integer> fase = getRandom(cornerLocation, turnOverColorCount);
        int[] faseArray= {1,2};
        int sexianHeCustom = 0;
        for (int i : fase) {
            InnerClass faseInner = cornerK.get(i);
            int index = new Random().nextInt(faseArray.length);
            fanse(faseInner,faseArray[index]);
            sexianHeCustom+=faseArray[index];
        }
        switch (sexianHeCustom % 3) {//如果色相错误，则搭配缓冲块处理色相
            case 1:
                fanse(cornerK.get(bufferIndex),2);
                break;
            case 2:
                fanse(cornerK.get(bufferIndex),1);
                break;
        }
    }


    /**
     * 处理棱块色相问题
     * @param edgeLocation
     * @param bufferIndex
     * @param turnOverColorCount
     */
    private void handleEdgeSx(List<Integer> edgeLocation, int bufferIndex, int turnOverColorCount) {
        //处理用户提供的原地翻色数量
        //根据数量取出需要原地翻色的块
        List<Integer> fase = getRandom(edgeLocation, turnOverColorCount);
        int[] faseArray= {1};
        int sexianHeCustom = 0;
        for (int i : fase) {
            InnerClass faseInner = edgeK.get(i);
            int index = new Random().nextInt(faseArray.length);
            fanse(faseInner,faseArray[index]);
            sexianHeCustom+=faseArray[index];
        }
        switch (sexianHeCustom % 2) {//如果色相错误，则搭配缓冲块处理色相
            case 1:
                fanse(edgeK.get(bufferIndex),1);
                break;
        }
    }





    public void edgeRandomStatus(Probability edge){
        List<Integer> edgeLocation = new ArrayList<>();//存入12个棱块位置标识
        List<Integer> alreadyList = new ArrayList<>();//存入 已经取过的棱块位置
        edgeLocation.add(0);
        edgeLocation.add(1);
        edgeLocation.add(2);
        edgeLocation.add(3);
        edgeLocation.add(4);
        edgeLocation.add(5);
        edgeLocation.add(6);
        edgeLocation.add(7);
        edgeLocation.add(8);
        edgeLocation.add(9);
        edgeLocation.add(10);
        edgeLocation.add(11);
        //取当前缓冲块
        int bufferIndex = 2; ////默认缓冲UF
        String edgeBufferStr = SPUtils.getInstance().getString(SpKey.EDGE_BUFFER);
        if(!TextUtils.isEmpty(edgeBufferStr)){
            bufferIndex = Integer.parseInt(edgeBufferStr);
        }
        int[] edgeSe = edge.getSeparator();//3+5   2+2  ....
        boolean isHoming= edge.isHoming();
        int turnOverColorCount = edge.getTurnOverColorCount();

        if (isHoming) {//缓冲归位
            //先取出缓冲块
            edgeLocation.remove((Integer) bufferIndex);
            if (edgeSe[0] == 0) {//纯翻色
                handleEdgeSx(edgeLocation, bufferIndex, turnOverColorCount);
                return;
            }
            for(int i=1;i<edgeSe.length;i++){
                int count = edgeSe[i];//每组的长度
                List<Integer> indexs = getRandom(edgeLocation,count);
                alreadyList.addAll(indexs);//存入已经取过的集合中，待翻色
                //取出来之后交换它们的位置
//                for(int j =0;j<indexs.size();j++) {
//                    if (j + 1 < indexs.size()) {
//                        exchange(CornerOrEdge.EDGE,indexs.get(j),indexs.get(j+1));
//                    }
//                }
                move(CornerOrEdge.EDGE,indexs);
            }

            //手动翻色，否则打乱出来的都是0位置的 三循环
            int length = alreadyList.size();
            List<Integer> sexianIndex = new ArrayList<>();
            for(int i=1;i<length;i++) {//从已经编过的码中取出长度-1 个 随机翻色， 剩余一个用来适合正确的色相问题
                int inde = getRandom(alreadyList,1).get(0);
                InnerClass innerClass = edgeK.get(inde);
                int index = new Random().nextInt(2);
                sexianIndex.add(index);
                fanse(innerClass,index);
            }
            InnerClass innerClass = edgeK.get(alreadyList.get(0));//取出已编码中 仅剩下的一个来适配色相问题
            int sexianHe = 0;
            for (int i : sexianIndex) {
                sexianHe+=i;
            }
            switch (sexianHe % 2) {
                case 1:
                    fanse(innerClass,1);
                    break;
            }
            handleEdgeSx(edgeLocation, bufferIndex, turnOverColorCount);

        }else{//缓冲不归位

            //先取出缓冲块
            edgeLocation.remove((Integer) bufferIndex);

            for(int i=0;i<edgeSe.length;i++){
                int count = edgeSe[i];//每组的长度
                List<Integer> indexs = new ArrayList<>();
                if(i==0){//缓冲块先取出来搭配第一个小循环
                    count = edgeSe[i]-1;
                    indexs.add(bufferIndex);
                }
                indexs.addAll(getRandom(edgeLocation,count));

                alreadyList.addAll(indexs);//存入已经取过的集合中，待翻色
                //取出来之后交换它们的位置
//                for(int j =0;j<indexs.size();j++) {
//                    if (j + 1 < indexs.size()) {
//                        exchange(CornerOrEdge.EDGE,indexs.get(j),indexs.get(j+1));
//                    }
//                }
                move(CornerOrEdge.EDGE,indexs);
            }

            //手动翻色，否则打乱出来的都是0位置的 三循环
            int length = alreadyList.size();
            List<Integer> sexianIndex = new ArrayList<>();
            for(int i=1;i<length;i++) {//从已经编过的码中取出长度-1 个 随机翻色， 剩余一个用来适合正确的色相问题
                int inde = getRandom(alreadyList,1).get(0);
                InnerClass innerClass = edgeK.get(inde);
                int index = new Random().nextInt(2);
                sexianIndex.add(index);
                fanse(innerClass,index);
            }
            InnerClass innerClass = edgeK.get(alreadyList.get(0));//取出已编码中 仅剩下的一个来适配色相问题
            int sexianHe = 0;
            for (int i : sexianIndex) {
                sexianHe+=i;
            }
            switch (sexianHe % 2) {
                case 1:
                    fanse(innerClass,1);
                    break;
            }
            handleEdgeSx(edgeLocation, bufferIndex, turnOverColorCount);

        }
    }














    //存储块信息
    class InnerClass{
        CornerOrEdge cornerOrEdge;
        List<List<String>> weizhi;
        List<Integer> indexs;

        public InnerClass(CornerOrEdge cornerOrEdge, List<List<String>> weizhi, List<Integer> indexs) {
            this.cornerOrEdge = cornerOrEdge;
            this.weizhi = weizhi;
            this.indexs = indexs;
        }

        public CornerOrEdge getCornerOrEdge() {
            return cornerOrEdge;
        }

        public List<List<String>> getWeizhi() {
            return weizhi;
        }

        public List<Integer> getIndexs() {
            return indexs;
        }
    }



    private void move(CornerOrEdge cornerOrEdge,List<Integer> indexs){

        for(int i = 1;i<indexs.size();i++) {
            exchange(cornerOrEdge,indexs.get(0),indexs.get(i));
        }


    }

    
    private void exchange(CornerOrEdge cornerOrEdge,int exchange1,int exchange2){
        InnerClass innerClass1 = null;
        InnerClass innerClass2 = null;
        switch (cornerOrEdge) {
            case CORNER:
                innerClass1 = cornerK.get(exchange1);
                innerClass2 = cornerK.get(exchange2);
                break;
            case EDGE:
                innerClass1 = edgeK.get(exchange1);
                innerClass2 = edgeK.get(exchange2);
                break;
        }

        List<List<String>> e1 = innerClass1.getWeizhi();
        List<Integer> eIndex1 = innerClass1.getIndexs();

        List<List<String>> e2 = innerClass2.getWeizhi();
        List<Integer> eIndex2 = innerClass2.getIndexs();

        List<String> e1List1 = e1.get(0);
        List<String> e1List2 = e1.get(1);

        int e1Index1 = eIndex1.get(0);
        int e1Index2 = eIndex1.get(1);

        String e1Str1 = e1List1.get(e1Index1);
        String e1Str2 = e1List2.get(e1Index2);

        List<String> e2List1 = e2.get(0);
        List<String> e2List2 = e2.get(1);


        int e2Index1 = eIndex2.get(0);
        int e2Index2 = eIndex2.get(1);

        String e2Str1 = e2List1.get(e2Index1);
        String e2Str2 = e2List2.get(e2Index2);


        e1List1.remove(e1Index1);
        e1List1.add(e1Index1,e2Str1);

        e1List2.remove(e1Index2);
        e1List2.add(e1Index2,e2Str2);

        e2List1.remove(e2Index1);
        e2List1.add(e2Index1,e1Str1);

        e2List2.remove(e2Index2);
        e2List2.add(e2Index2,e1Str2);


        switch (cornerOrEdge) {
            case CORNER:
                List<String> e1List3 = e1.get(2);
                int e1Index3 = eIndex1.get(2);
                String e1Str3 = e1List3.get(e1Index3);

                List<String> e2List3 = e2.get(2);
                int e2Index3 = eIndex2.get(2);
                String e2Str3 = e2List3.get(e2Index3);

                e1List3.remove(e1Index3);
                e1List3.add(e1Index3,e2Str3);

                e2List3.remove(e2Index3);
                e2List3.add(e2Index3,e1Str3);
                break;

        }
    }

    private List<InnerClass> cornerK;
    private List<InnerClass> edgeK;
    //初始化块信息
    private void initKuai(){

        cornerK = new ArrayList<>();

        //UBR 0
        List<List<String>> loca0 = new ArrayList<>();
        loca0.add(upCorner);
        loca0.add(backCorner);
        loca0.add(rightCorner);
        List<Integer> loca0Indexs = new ArrayList<>();
        loca0Indexs.add(0);
        loca0Indexs.add(3);
        loca0Indexs.add(0);

        //UFR 1

        List<List<String>> loca1 = new ArrayList<>();
        loca1.add(upCorner);
        loca1.add(rightCorner);
        loca1.add(frontCorner);
        List<Integer> loca1Indexs = new ArrayList<>();
        loca1Indexs.add(1);
        loca1Indexs.add(3);
        loca1Indexs.add(0);


        //UFL 2
        List<List<String>> loca2 = new ArrayList<>();
        loca2.add(upCorner);
        loca2.add(frontCorner);
        loca2.add(leftCorner);
        List<Integer> loca2Indexs = new ArrayList<>();
        loca2Indexs.add(2);
        loca2Indexs.add(3);
        loca2Indexs.add(0);


        //UBL 3
        List<List<String>> loca3 = new ArrayList<>();
        loca3.add(upCorner);
        loca3.add(leftCorner);
        loca3.add(backCorner);
        List<Integer> loca3Indexs = new ArrayList<>();
        loca3Indexs.add(3);
        loca3Indexs.add(3);
        loca3Indexs.add(0);

        //DFR 4
        List<List<String>> loca4 = new ArrayList<>();
        loca4.add(downCorner);
        loca4.add(frontCorner);
        loca4.add(rightCorner);
        List<Integer> loca4Indexs = new ArrayList<>();
        loca4Indexs.add(0);
        loca4Indexs.add(1);
        loca4Indexs.add(2);

        //DBR 5
        List<List<String>> loca5 = new ArrayList<>();
        loca5.add(downCorner);
        loca5.add(rightCorner);
        loca5.add(backCorner);
        List<Integer> loca5Indexs = new ArrayList<>();
        loca5Indexs.add(1);
        loca5Indexs.add(1);
        loca5Indexs.add(2);


        //DBL 6
        List<List<String>> loca6 = new ArrayList<>();
        loca6.add(downCorner);
        loca6.add(backCorner);
        loca6.add(leftCorner);
        List<Integer> loca6Indexs = new ArrayList<>();
        loca6Indexs.add(2);
        loca6Indexs.add(1);
        loca6Indexs.add(2);

        //DFL 7
        List<List<String>> loca7 = new ArrayList<>();
        loca7.add(downCorner);
        loca7.add(leftCorner);
        loca7.add(frontCorner);
        List<Integer> loca7Indexs = new ArrayList<>();
        loca7Indexs.add(3);
        loca7Indexs.add(1);
        loca7Indexs.add(2);

        cornerK.add(new InnerClass(CornerOrEdge.CORNER, loca0, loca0Indexs));
        cornerK.add(new InnerClass(CornerOrEdge.CORNER, loca1, loca1Indexs));
        cornerK.add(new InnerClass(CornerOrEdge.CORNER, loca2, loca2Indexs));
        cornerK.add(new InnerClass(CornerOrEdge.CORNER, loca3, loca3Indexs));
        cornerK.add(new InnerClass(CornerOrEdge.CORNER, loca4, loca4Indexs));
        cornerK.add(new InnerClass(CornerOrEdge.CORNER, loca5, loca5Indexs));
        cornerK.add(new InnerClass(CornerOrEdge.CORNER, loca6, loca6Indexs));
        cornerK.add(new InnerClass(CornerOrEdge.CORNER, loca7, loca7Indexs));

//---------------------------------------edge------------------------------------------

        edgeK = new ArrayList<>();
        
        //UB 0
        List<List<String>> edgeloca0 = new ArrayList<>();
        edgeloca0.add(upEdge);
        edgeloca0.add(backEdge);
        List<Integer> edgelocaIndexs0 = new ArrayList<>();
        edgelocaIndexs0.add(0);
        edgelocaIndexs0.add(0);

        //UR 1
        List<List<String>> edgeloca1 = new ArrayList<>();
        edgeloca1.add(upEdge);
        edgeloca1.add(rightEdge);
        List<Integer> edgelocaIndexs1 = new ArrayList<>();
        edgelocaIndexs1.add(1);
        edgelocaIndexs1.add(0);


        //UF 2
        List<List<String>> edgeloca2 = new ArrayList<>();
        edgeloca2.add(upEdge);
        edgeloca2.add(frontEdge);
        List<Integer> edgelocaIndexs2 = new ArrayList<>();
        edgelocaIndexs2.add(2);
        edgelocaIndexs2.add(0);


        //UL 3
        List<List<String>> edgeloca3 = new ArrayList<>();
        edgeloca3.add(upEdge);
        edgeloca3.add(leftEdge);
        List<Integer> edgelocaIndexs3 = new ArrayList<>();
        edgelocaIndexs3.add(3);
        edgelocaIndexs3.add(0);

        //FR 4
        List<List<String>> edgeloca4 = new ArrayList<>();
        edgeloca4.add(frontEdge);
        edgeloca4.add(rightEdge);
        List<Integer> edgelocaIndexs4 = new ArrayList<>();
        edgelocaIndexs4.add(1);
        edgelocaIndexs4.add(3);

        //FL 5
        List<List<String>> edgeloca5 = new ArrayList<>();
        edgeloca5.add(frontEdge);
        edgeloca5.add(leftEdge);
        List<Integer> edgelocaIndexs5 = new ArrayList<>();
        edgelocaIndexs5.add(3);
        edgelocaIndexs5.add(1);
        
        
        //BL 6
        List<List<String>> edgeloca6 = new ArrayList<>();
        edgeloca6.add(backEdge);
        edgeloca6.add(leftEdge);
        List<Integer> edgelocaIndexs6 = new ArrayList<>();
        edgelocaIndexs6.add(1);
        edgelocaIndexs6.add(3);

        //BR 7
        List<List<String>> edgeloca7 = new ArrayList<>();
        edgeloca7.add(backEdge);
        edgeloca7.add(rightEdge);
        List<Integer> edgelocaIndexs7 = new ArrayList<>();
        edgelocaIndexs7.add(3);
        edgelocaIndexs7.add(1);

        //DF 8
        List<List<String>> edgeloca8 = new ArrayList<>();
        edgeloca8.add(downEdge);
        edgeloca8.add(frontEdge);
        List<Integer> edgelocaIndexs8 = new ArrayList<>();
        edgelocaIndexs8.add(0);
        edgelocaIndexs8.add(2);

        //DL 9
        List<List<String>> edgeloca9 = new ArrayList<>();
        edgeloca9.add(downEdge);
        edgeloca9.add(leftEdge);
        List<Integer> edgelocaIndexs9 = new ArrayList<>();
        edgelocaIndexs9.add(3);
        edgelocaIndexs9.add(2);

        //DB 10
        List<List<String>> edgeloca10 = new ArrayList<>();
        edgeloca10.add(downEdge);
        edgeloca10.add(backEdge);
        List<Integer> edgelocaIndexs10 = new ArrayList<>();
        edgelocaIndexs10.add(2);
        edgelocaIndexs10.add(2);

        //DR 11
        List<List<String>> edgeloca11 = new ArrayList<>();
        edgeloca11.add(downEdge);
        edgeloca11.add(rightEdge);
        List<Integer> edgelocaIndexs11 = new ArrayList<>();
        edgelocaIndexs11.add(1);
        edgelocaIndexs11.add(2);
        
        
        edgeK.add(new InnerClass(CornerOrEdge.EDGE, edgeloca0, edgelocaIndexs0));
        edgeK.add(new InnerClass(CornerOrEdge.EDGE, edgeloca1, edgelocaIndexs1));
        edgeK.add(new InnerClass(CornerOrEdge.EDGE, edgeloca2, edgelocaIndexs2));
        edgeK.add(new InnerClass(CornerOrEdge.EDGE, edgeloca3, edgelocaIndexs3));
        edgeK.add(new InnerClass(CornerOrEdge.EDGE, edgeloca4, edgelocaIndexs4));
        edgeK.add(new InnerClass(CornerOrEdge.EDGE, edgeloca5, edgelocaIndexs5));
        edgeK.add(new InnerClass(CornerOrEdge.EDGE, edgeloca6, edgelocaIndexs6));
        edgeK.add(new InnerClass(CornerOrEdge.EDGE, edgeloca7, edgelocaIndexs7));
        edgeK.add(new InnerClass(CornerOrEdge.EDGE, edgeloca8, edgelocaIndexs8));
        edgeK.add(new InnerClass(CornerOrEdge.EDGE, edgeloca9, edgelocaIndexs9));
        edgeK.add(new InnerClass(CornerOrEdge.EDGE, edgeloca10, edgelocaIndexs10));
        edgeK.add(new InnerClass(CornerOrEdge.EDGE, edgeloca11, edgelocaIndexs11));

    }

    /**
     * 获取魔方当前状态，用于求解的格式str
     * @return
     */
    public String get2phaseStr(){
        String str = "";
        String u1 = getPhaseFormat(CornerOrEdge.CORNER,upCorner.get(3));
        String u2 = getPhaseFormat(CornerOrEdge.EDGE,upEdge.get(0));
        String u3 = getPhaseFormat(CornerOrEdge.CORNER,upCorner.get(0));
        String u4 = getPhaseFormat(CornerOrEdge.EDGE,upEdge.get(3));
        String u5 = getPhaseFormat(CornerOrEdge.EDGE,upEdge.get(4));
        String u6 = getPhaseFormat(CornerOrEdge.EDGE,upEdge.get(1));
        String u7 = getPhaseFormat(CornerOrEdge.CORNER,upCorner.get(2));
        String u8 = getPhaseFormat(CornerOrEdge.EDGE,upEdge.get(2));
        String u9 = getPhaseFormat(CornerOrEdge.CORNER,upCorner.get(1));


        String r1 = getPhaseFormat(CornerOrEdge.CORNER,rightCorner.get(3));
        String r2 = getPhaseFormat(CornerOrEdge.EDGE,rightEdge.get(0));
        String r3 = getPhaseFormat(CornerOrEdge.CORNER,rightCorner.get(0));
        String r4 = getPhaseFormat(CornerOrEdge.EDGE,rightEdge.get(3));
        String r5 = getPhaseFormat(CornerOrEdge.EDGE,rightEdge.get(4));
        String r6 = getPhaseFormat(CornerOrEdge.EDGE,rightEdge.get(1));
        String r7 = getPhaseFormat(CornerOrEdge.CORNER,rightCorner.get(2));
        String r8 = getPhaseFormat(CornerOrEdge.EDGE,rightEdge.get(2));
        String r9 = getPhaseFormat(CornerOrEdge.CORNER,rightCorner.get(1));


        String f1 = getPhaseFormat(CornerOrEdge.CORNER,frontCorner.get(3));
        String f2 = getPhaseFormat(CornerOrEdge.EDGE,frontEdge.get(0));
        String f3 = getPhaseFormat(CornerOrEdge.CORNER,frontCorner.get(0));
        String f4 = getPhaseFormat(CornerOrEdge.EDGE,frontEdge.get(3));
        String f5 = getPhaseFormat(CornerOrEdge.EDGE,frontEdge.get(4));
        String f6 = getPhaseFormat(CornerOrEdge.EDGE,frontEdge.get(1));
        String f7 = getPhaseFormat(CornerOrEdge.CORNER,frontCorner.get(2));
        String f8 = getPhaseFormat(CornerOrEdge.EDGE,frontEdge.get(2));
        String f9 = getPhaseFormat(CornerOrEdge.CORNER,frontCorner.get(1));


        String d1 = getPhaseFormat(CornerOrEdge.CORNER,downCorner.get(3));
        String d2 = getPhaseFormat(CornerOrEdge.EDGE,downEdge.get(0));
        String d3 = getPhaseFormat(CornerOrEdge.CORNER,downCorner.get(0));
        String d4 = getPhaseFormat(CornerOrEdge.EDGE,downEdge.get(3));
        String d5 = getPhaseFormat(CornerOrEdge.EDGE,downEdge.get(4));
        String d6 = getPhaseFormat(CornerOrEdge.EDGE,downEdge.get(1));
        String d7 = getPhaseFormat(CornerOrEdge.CORNER,downCorner.get(2));
        String d8 = getPhaseFormat(CornerOrEdge.EDGE,downEdge.get(2));
        String d9 = getPhaseFormat(CornerOrEdge.CORNER,downCorner.get(1));


        String l1 = getPhaseFormat(CornerOrEdge.CORNER,leftCorner.get(3));
        String l2 = getPhaseFormat(CornerOrEdge.EDGE,leftEdge.get(0));
        String l3 = getPhaseFormat(CornerOrEdge.CORNER,leftCorner.get(0));
        String l4 = getPhaseFormat(CornerOrEdge.EDGE,leftEdge.get(3));
        String l5 = getPhaseFormat(CornerOrEdge.EDGE,leftEdge.get(4));
        String l6 = getPhaseFormat(CornerOrEdge.EDGE,leftEdge.get(1));
        String l7 = getPhaseFormat(CornerOrEdge.CORNER,leftCorner.get(2));
        String l8 = getPhaseFormat(CornerOrEdge.EDGE,leftEdge.get(2));
        String l9 = getPhaseFormat(CornerOrEdge.CORNER,leftCorner.get(1));


        String b1 = getPhaseFormat(CornerOrEdge.CORNER,backCorner.get(3));
        String b2 = getPhaseFormat(CornerOrEdge.EDGE,backEdge.get(0));
        String b3 = getPhaseFormat(CornerOrEdge.CORNER,backCorner.get(0));
        String b4 = getPhaseFormat(CornerOrEdge.EDGE,backEdge.get(3));
        String b5 = getPhaseFormat(CornerOrEdge.EDGE,backEdge.get(4));
        String b6 = getPhaseFormat(CornerOrEdge.EDGE,backEdge.get(1));
        String b7 = getPhaseFormat(CornerOrEdge.CORNER,backCorner.get(2));
        String b8 = getPhaseFormat(CornerOrEdge.EDGE,backEdge.get(2));
        String b9 = getPhaseFormat(CornerOrEdge.CORNER,backCorner.get(1));


        str = u1+u2+u3+u4+u5+u6+u7+u8+u9;
        str+= r1+r2+r3+r4+r5+r6+r7+r8+r9;
        str+= f1+f2+f3+f4+f5+f6+f7+f8+f9;
        str+= d1+d2+d3+d4+d5+d6+d7+d8+d9;
        str+= l1+l2+l3+l4+l5+l6+l7+l8+l9;
        str+= b1+b2+b3+b4+b5+b6+b7+b8+b9;

        return str;
    }

    private String getPhaseFormat(CornerOrEdge cornerOrEdge,String code){
        String str = "";
        switch (cornerOrEdge) {
            case CORNER:
                for (String s : upCornerSource) {
                    if (TextUtils.equals(s, code)) {
                        return "U";
                    }
                }

                for (String s : rightCornerSource) {
                    if (TextUtils.equals(s, code)) {
                        return "R";
                    }
                }

                for (String s : frontCornerSource) {
                    if (TextUtils.equals(s, code)) {
                        return "F";
                    }
                }

                for (String s : downCornerSource) {
                    if (TextUtils.equals(s, code)) {
                        return "D";
                    }
                }

                for (String s : leftCornerSource) {
                    if (TextUtils.equals(s, code)) {
                        return "L";
                    }
                }

                for (String s : backCornerSource) {
                    if (TextUtils.equals(s, code)) {
                        return "B";
                    }
                }

                break;

            case EDGE:
                for (String s : upEdgeSource) {
                    if (TextUtils.equals(s, code)) {
                        return "U";
                    }
                }

                for (String s : rightEdgeSource) {
                    if (TextUtils.equals(s, code)) {
                        return "R";
                    }
                }

                for (String s : frontEdgeSource) {
                    if (TextUtils.equals(s, code)) {
                        return "F";
                    }
                }

                for (String s : downEdgeSource) {
                    if (TextUtils.equals(s, code)) {
                        return "D";
                    }
                }

                for (String s : leftEdgeSource) {
                    if (TextUtils.equals(s, code)) {
                        return "L";
                    }
                }

                for (String s : backEdgeSource) {
                    if (TextUtils.equals(s, code)) {
                        return "B";
                    }
                }
                break;
        }
        return str;
    }



    /**
     * 初始化借位顺序
     */
    private void initJieweiSort() {
        cornerJiewei = new ArrayList<>();
        edgeJiewei = new ArrayList<>();
        String cornerSort = SPUtils.getInstance().getString(SpKey.SORT_CORNER_JIE);
        String edgeSort = SPUtils.getInstance().getString(SpKey.SORT_EDGE_JIE);
        if(TextUtils.isEmpty(cornerSort)){
            //没有设置过，用默认
            cornerSort = SpKey.CORNER_JIE_SORT;
            edgeSort = SpKey.EDGE_JIE_SORT;
            SPUtils.getInstance().put(SpKey.SORT_CORNER_JIE,cornerSort);
            SPUtils.getInstance().put(SpKey.SORT_EDGE_JIE,edgeSort);
        }

        for(int i = 0;i<cornerSort.length();i++){
            String cornerKey = cornerSort.substring(i,i+1);
            String display = CoordinateUtil.getDisPlayCode(CornerOrEdge.CORNER, cornerKey,this);
            cornerJiewei.add(display);
        }

        for(int i = 0;i<edgeSort.length();i++){
            String edgeKey = edgeSort.substring(i,i+1);
            String display = CoordinateUtil.getDisPlayCode(CornerOrEdge.EDGE, edgeKey,this);
            edgeJiewei.add(display);
        }

    }



    /**
     * 初始化编码
     * @param codes
     */
    private void initCubeCode(List<CubeCode> codes) {
        for (CubeCode code : codes) {
            switch (code.getDirection()) {
                case UP:
                    upCorner = new ArrayList<>();
                    upEdge = new ArrayList<>();
                    upCorner.addAll(code.getCorners());
                    upEdge.addAll(code.getEdges());

                    upCornerSource = new ArrayList<>();
                    upEdgeSource = new ArrayList<>();
                    upCornerSource.addAll(code.getCorners());
                    upEdgeSource.addAll(code.getEdges());
                    break;
                case DOWN:
                    downCorner = new ArrayList<>();
                    downEdge = new ArrayList<>();
                    downCorner.addAll(code.getCorners());
                    downEdge.addAll(code.getEdges());

                    downCornerSource = new ArrayList<>();
                    downEdgeSource = new ArrayList<>();
                    downCornerSource.addAll(code.getCorners());
                    downEdgeSource.addAll(code.getEdges());
                    break;
                case LEFT:
                    leftCorner = new ArrayList<>();
                    leftEdge = new ArrayList<>();
                    leftCorner.addAll(code.getCorners());
                    leftEdge.addAll(code.getEdges());

                    leftCornerSource = new ArrayList<>();
                    leftEdgeSource = new ArrayList<>();
                    leftCornerSource.addAll(code.getCorners());
                    leftEdgeSource.addAll(code.getEdges());
                    break;
                case RIGHT:
                    rightCorner = new ArrayList<>();
                    rightEdge = new ArrayList<>();
                    rightCorner.addAll(code.getCorners());
                    rightEdge.addAll(code.getEdges());

                    rightCornerSource = new ArrayList<>();
                    rightEdgeSource = new ArrayList<>();
                    rightCornerSource.addAll(code.getCorners());
                    rightEdgeSource.addAll(code.getEdges());
                    break;
                case FRONT:
                    frontCorner = new ArrayList<>();
                    frontEdge = new ArrayList<>();
                    frontCorner.addAll(code.getCorners());
                    frontEdge.addAll(code.getEdges());

                    frontCornerSource = new ArrayList<>();
                    frontEdgeSource = new ArrayList<>();
                    frontCornerSource.addAll(code.getCorners());
                    frontEdgeSource.addAll(code.getEdges());
                    break;
                case BACK:
                    backCorner = new ArrayList<>();
                    backEdge = new ArrayList<>();
                    backCorner.addAll(code.getCorners());
                    backEdge.addAll(code.getEdges());

                    backCornerSource = new ArrayList<>();
                    backEdgeSource = new ArrayList<>();
                    backCornerSource.addAll(code.getCorners());
                    backEdgeSource.addAll(code.getEdges());
                    break;
            }

        }
    }

    /**
     * 初始化颜色
     * @param dyes
     */
    private void initCubeColor(List<DyeCubeBean> dyes){
        pasters = new ArrayList<>();
        for (DyeCubeBean dye : dyes) {
            switch (dye.getDirection()){
                case UP:
                    pasters.add(handleCubePaster(dye.getColorEnum(),upCorner,upEdge));
                    break;
                case DOWN:
                    pasters.add(handleCubePaster(dye.getColorEnum(),downCorner,downEdge));
                    break;
                case LEFT:
                    pasters.add(handleCubePaster(dye.getColorEnum(),leftCorner,leftEdge));
                    break;
                case RIGHT:
                    pasters.add(handleCubePaster(dye.getColorEnum(),rightCorner,rightEdge));
                    break;
                case FRONT:
                    pasters.add(handleCubePaster(dye.getColorEnum(),frontCorner,frontEdge));
                    break;
                case BACK:
                    pasters.add(handleCubePaster(dye.getColorEnum(),backCorner,backEdge));
                    break;
            }
        }
    }

    /**
     * 根据打乱公式str 打乱魔方
     * @param str
     */
    public void disrupt(String str) {
        List<String> codes = getCodes(str);
//        getCornerLocation("");
//        getEdgeLocation("");
        for (String code : codes) {
            switch (code) {
                case "R":
                    rotateR();
                    break;
                case "R'":
                    rotateRs();
                    break;
                case "R2":
                    rotateR2();
                    break;
                case "Rw":
                    rotateRw();
                    break;
                case "Rw'":
                    rotateRws();
                    break;
                case "Rw2":
                    rotateRw2();
                    break;
                case "U":
                    rotateU();
                    break;
                case "U'":
                    rotateUs();
                    break;
                case "U2":
                    rotateU2();
                    break;
                case "Uw":
                    rotateUw();
                    break;
                case "Uw'":
                    rotateUws();
                    break;
                case "Uw2":
                    rotateUw2();
                    break;
                case "D":
                    rotateD();
                    break;
                case "D'":
                    rotateDs();
                    break;
                case "D2":
                    rotateD2();
                    break;
                case "Dw":
                    rotateDw();
                    break;
                case "Dw'":
                    rotateDws();
                    break;
                case "Dw2":
                    rotateDw2();
                    break;
                case "B":
                    rotateB();
                    break;
                case "B'":
                    rotateBs();
                    break;
                case "B2":
                    rotateB2();
                    break;
                case "Bw":
                    rotateBw();
                    break;
                case "Bw'":
                    rotateBws();
                    break;
                case "Bw2":
                    rotateBw2();
                    break;
                case "F":
                    rotateF();
                    break;
                case "F'":
                    rotateFs();
                    break;
                case "F2":
                    rotateF2();
                    break;
                case "Fw":
                    rotateFw();
                    break;
                case "Fw'":
                    rotateFws();
                    break;
                case "Fw2":
                    rotateFw2();
                    break;
                case "L":
                    rotateL();
                    break;
                case "L'":
                    rotateLs();
                    break;
                case "L2":
                    rotateL2();
                    break;
                case "Lw":
                    rotateLw();
                    break;
                case "Lw'":
                    rotateLws();
                    break;
                case "Lw2":
                    rotateLw2();
                    break;
                case "x":
                    rotateX();
                    break;
                case "x'":
                    rotateXs();
                    break;
                case "x2":
                    rotateX2();
                    break;
                case "y":
                    rotateY();
                    break;
                case "y'":
                    rotateYs();
                    break;
                case "y2":
                    rotateY2();
                    break;
                case "z":
                    rotateZ();
                    break;
                case "z'":
                    rotateZs();
                    break;
                case "z2":
                    rotateZ2();
                    break;
            }
        }

    }

    /**
     * 根据打乱公式字符串截取
     * @param str
     * @return
     */
    private List<String> getCodes(String str){
        String regex = "([URFDLBxyz])(w?)(['2]?)";
        str = str.replaceAll("\\s","");
        List<String> list = new ArrayList<>();
        Pattern pa = Pattern.compile(regex);
        Matcher ma = pa.matcher(str);
        while (ma.find()) {
            list.add(ma.group());
        }
        return list;
    }

    /**
     * 获取打乱后的状态(颜色)
     */
    public List<DisplayBean> getCubeColorStatusData(){
        List<DisplayBean> displayBeanList = new ArrayList<>();

        displayBeanList.add(getDisplayBean(upCorner,upEdge,CubeDirection.UP));
        displayBeanList.add(getDisplayBean(downCorner,downEdge,CubeDirection.DOWN));
        displayBeanList.add(getDisplayBean(leftCorner,leftEdge,CubeDirection.LEFT));
        displayBeanList.add(getDisplayBean(rightCorner,rightEdge,CubeDirection.RIGHT));
        displayBeanList.add(getDisplayBean(frontCorner,frontEdge,CubeDirection.FRONT));
        displayBeanList.add(getDisplayBean(backCorner,backEdge,CubeDirection.BACK));

        return displayBeanList;
    }


    private DisplayBean getDisplayBean(List<String> corners, List<String> edges, CubeDirection direction) {
        List<CubeColor> cornerColors = new ArrayList<>();
        List<CubeColor> edgeColors = new ArrayList<>();
        for (String str : corners) {
            CubeColor colorEnum = getPasterColor(CornerOrEdge.CORNER,str);
            cornerColors.add(colorEnum);
        }
        for (String str : edges) {
            CubeColor colorEnum = getPasterColor(CornerOrEdge.EDGE,str);
            edgeColors.add(colorEnum);
        }
        DisplayBean display = new DisplayBean(direction,cornerColors,edgeColors);
        return display;
    }

    /**
     * 获取某一面贴纸颜色
     * @param cornerOrEdge 角或棱
     * @param code 编码位置
     * @return
     */
    private CubeColor getPasterColor(CornerOrEdge cornerOrEdge, String code){
        CubeColor colorEnum = CubeColor.BLUE;
        switch (cornerOrEdge){
            case CORNER:
                for (CubePaster paster:pasters) {
                    List<String> corners = paster.getCornerPasters();
                    for (String str:corners) {
                        if (TextUtils.equals(code, str)) {
                            colorEnum = paster.getColorEnum();
                            break;
                        }
                    }
                }
                break;
            case EDGE:
                for (CubePaster paster:pasters) {
                    List<String> edges = paster.getEdgePasters();
                    for (String str:edges) {
                        if (TextUtils.equals(code, str)) {
                            colorEnum = paster.getColorEnum();
                            break;
                        }
                    }
                }
                break;
        }

        return colorEnum;
    }


    /**
     * 处理贴纸颜色
     * @param colorEnum 颜色
     * @param corners 角块相同颜色贴纸
     * @param edges 棱块相同颜色贴纸
     * @return
     */
    private CubePaster handleCubePaster(CubeColor colorEnum, List<String> corners, List<String> edges) {
        CubePaster up = new CubePaster();
        up.setColorEnum(colorEnum);
        List<String> cornerPasters = new ArrayList<>();
        cornerPasters.addAll(corners);
        List<String> edgePasters = new ArrayList<>();
        edgePasters.addAll(edges);
        up.setCornerPasters(cornerPasters);
        up.setEdgePasters(edgePasters);
        return up;
    }

    /**
     * 角块读码
     * @param bufferCode
     * @param dynamicCode
     * @param index
     */
    private void handleRead(String bufferCode,String dynamicCode,int index){
        //取到编码之后，判断是否属于缓冲块上的码
        if (isTogether(CornerOrEdge.CORNER,bufferCode,dynamicCode)) {
            if(getCornerLocation(dynamicCode)[0]!=index){
                tempResultCodes.add(dynamicCode);//借位归还
                cornerCodes.add(new ResultCode(dynamicCode,false,true));
            }
            //根据用户提供的借位顺序来借位
            jieWeiLuojiCorner(tempResultCodes,getCornerLocation(dynamicCode)[1]);
            if (isCornerFinish) {
                return;
            }

            tempResultCodes.add(currentCornerJie);//借位处
            cornerCodes.add(new ResultCode(currentCornerJie,true,false));
            int[] dir = getDirectIndexByDynamic(CornerOrEdge.CORNER,currentCornerJie);
            String cc = getDynamicCodeByDirectAndIndex(CornerOrEdge.CORNER,dir);
            tempResultCodes.add(cc);
            cornerCodes.add(new ResultCode(cc,false,false));
            int[] dir2 = getDirectIndexByDynamic(CornerOrEdge.CORNER,cc);
            String cc1 = getDynamicCodeByDirectAndIndex(CornerOrEdge.CORNER, dir2);

            handleRead(currentCornerJie,cc1,index);

        }else {

            tempResultCodes.add(dynamicCode);
            cornerCodes.add(new ResultCode(dynamicCode,false,false));
            int[] dir = getDirectIndexByDynamic(CornerOrEdge.CORNER,dynamicCode);
            String nextCode = getDynamicCodeByDirectAndIndex(CornerOrEdge.CORNER,dir);
            handleRead(bufferCode,nextCode,index);

        }
    }

    /**
     *  棱块读码
     * @param bufferCode
     * @param dynamicCode
     * @param index
     */
    private void handleReadEdge(String bufferCode,String dynamicCode,int index){
        //取到编码之后，判断是否属于缓冲块上的码
        if (isTogether(CornerOrEdge.EDGE,bufferCode,dynamicCode)) {
            if(getEdgeLocation(dynamicCode)[0]!=index){
                tempResultEdgeCodes.add(dynamicCode);//借位归还
                edgeCodes.add(new ResultCode(dynamicCode,false,true));
            }
            //根据用户提供的借位顺序来借位
            jieWeiLuojiEdge(tempResultEdgeCodes,getEdgeLocation(dynamicCode)[1]);
            if (isEdgeFinish) {
                return;
            }

            tempResultEdgeCodes.add(currentEdgeJie);//借位处
            edgeCodes.add(new ResultCode(currentEdgeJie,true,false));
            int[] dir = getDirectIndexByDynamic(CornerOrEdge.EDGE,currentEdgeJie);
            String cc = getDynamicCodeByDirectAndIndex(CornerOrEdge.EDGE,dir);
            tempResultEdgeCodes.add(cc);
            edgeCodes.add(new ResultCode(cc,false,false));

            int[] dir2 = getDirectIndexByDynamic(CornerOrEdge.EDGE,cc);
            String cc1 = getDynamicCodeByDirectAndIndex(CornerOrEdge.EDGE, dir2);

            handleReadEdge(currentEdgeJie,cc1,index);

        }else {
            tempResultEdgeCodes.add(dynamicCode);
            edgeCodes.add(new ResultCode(dynamicCode,false,false));
            int[] dir = getDirectIndexByDynamic(CornerOrEdge.EDGE,dynamicCode);
            String nextCode = getDynamicCodeByDirectAndIndex(CornerOrEdge.EDGE,dir);
            handleReadEdge(bufferCode,nextCode,index);
        }
    }


    /**
     * 处理坐标，打乱有可能打乱了坐标，需要调整回来
     */
    public String handlCoordinate(){
        String result = "";
        if(TextUtils.equals(upEdge.get(4),SpKey.UP)&&TextUtils.equals(frontEdge.get(4),SpKey.FRONT)){
//            System.out.println("坐标正确");
        }else {
//            System.out.println("需要调整坐标！！");
            if(TextUtils.equals(SpKey.UP,downEdge.get(4))){
                result+="x2 ";
                rotateRw2();
                rotateL2();
            }else if(TextUtils.equals(SpKey.UP,leftEdge.get(4))){
                result+="z ";
                rotateFw();
                rotateBs();
            }else if(TextUtils.equals(SpKey.UP,rightEdge.get(4))){
                result+="z' ";
                rotateFws();
                rotateB();
            }else if(TextUtils.equals(SpKey.UP,frontEdge.get(4))){
                result+="x ";
                rotateRw();
                rotateLs();
            }else if(TextUtils.equals(SpKey.UP,backEdge.get(4))){
                result+="x' ";
                rotateRws();
                rotateL();
            }

            if(TextUtils.equals(SpKey.FRONT,leftEdge.get(4))){
                result+="y' ";
                rotateUws();
                rotateD();
            }else if(TextUtils.equals(SpKey.FRONT,rightEdge.get(4))){
                result+="y ";
                rotateUw();
                rotateDs();
            }else if(TextUtils.equals(SpKey.FRONT,backEdge.get(4))){
                result+="y2 ";
                rotateUw2();
                rotateD2();
            }

        }
        return result;
    }


    /**
     * 角块读码
     * @return
     */
    public SpannableStringBuilder[] readCorner(){
        //已编的码存入集合
        int index = 1; ////默认缓冲UFR
        String cornerBufferStr = SPUtils.getInstance().getString(SpKey.CORNER_BUFFER);
        if(!TextUtils.isEmpty(cornerBufferStr)){
            index = Integer.parseInt(cornerBufferStr);
        }
        //首先删除借位顺序里，缓冲块的编码
        removeBufferCodes(CornerOrEdge.CORNER,index);
        switch (index) {
            case 0://UBR
                handleRead(upCornerSource.get(0),upCorner.get(0),index);
                break;
            case 1://UFR
                handleRead(upCornerSource.get(1),upCorner.get(1),index);
                break;
            case 2://UFL
                handleRead(upCornerSource.get(2),upCorner.get(2),index);
                break;
            case 3://UBL
                handleRead(upCornerSource.get(3),upCorner.get(3),index);
                break;
            case 4://DFR
                handleRead(downCornerSource.get(0),downCorner.get(0),index);
                break;
            case 5://UBR
                handleRead(downCornerSource.get(1),downCorner.get(1),index);
                break;
            case 6://DBL
                handleRead(downCornerSource.get(2),downCorner.get(2),index);
                break;
            case 7://DFL
                handleRead(downCornerSource.get(3),downCorner.get(3),index);
                break;
        }

        SpannableStringBuilder ssbF = new SpannableStringBuilder();
        ssbF.append("角块翻色： ");
        for(int i = 0;i<tempFasnseCodes.size();i++) {
            ssbF.append(tempFasnseCodes.get(i));
        }

        SpannableStringBuilder ssb = new SpannableStringBuilder();
        ssb.append("角块编码： ");
        for(int i = 0;i<cornerCodes.size();i++) {
            ResultCode resultCode = cornerCodes.get(i);
            SpannableString ss = new SpannableString(resultCode.getCode());
            if (resultCode.isjie()) {
                ForegroundColorSpan span = new ForegroundColorSpan(Color.parseColor("#0099EE"));
                ss.setSpan(span,0,1,Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
            }else if(resultCode.isHuang()){
                ForegroundColorSpan span = new ForegroundColorSpan(Color.parseColor("#00FF33"));
                ss.setSpan(span,0,1,Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
            }else{
                ForegroundColorSpan span = new ForegroundColorSpan(Color.parseColor("#FFFFFF"));
                ss.setSpan(span,0,1,Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
            }
            ssb.append(ss);
            if(i%2==1){
                ssb.append("  ");
            }
        }
        return new SpannableStringBuilder[]{ssb,ssbF};
    }



    /**
     * 棱块读码
     * @return
     */
    public SpannableStringBuilder[] readEdge(){
        //已编的码存入集合
        int index = 2; ////默认缓冲UF
        String edgeBufferStr = SPUtils.getInstance().getString(SpKey.EDGE_BUFFER);
        if(!TextUtils.isEmpty(edgeBufferStr)){
            index = Integer.parseInt(edgeBufferStr);
        }
        //首先删除借位顺序里，缓冲块的编码
        removeBufferCodes(CornerOrEdge.EDGE,index);

        switch (index) {
            case 0://UB
                handleReadEdge(upEdgeSource.get(0),upEdge.get(0),index);
                break;
            case 1://UR
                handleReadEdge(upEdgeSource.get(1),upEdge.get(1),index);
                break;
            case 2://UF
                handleReadEdge(upEdgeSource.get(2),upEdge.get(2),index);
                break;
            case 3://UL
                handleReadEdge(upEdgeSource.get(3),upEdge.get(3),index);
                break;
            case 4://FR
                handleReadEdge(frontEdgeSource.get(1),frontEdge.get(1),index);
                break;
            case 5://FL
                handleReadEdge(frontEdgeSource.get(3),frontEdge.get(3),index);
                break;
            case 6://BL
                handleReadEdge(backEdgeSource.get(1),backEdge.get(1),index);
                break;
            case 7://BR
                handleReadEdge(backEdgeSource.get(3),backEdge.get(3),index);
                break;
            case 8://DF
                handleReadEdge(downEdgeSource.get(0),downEdge.get(0),index);
                break;
            case 9://DL
                handleReadEdge(downEdgeSource.get(3),downEdge.get(3),index);
                break;
            case 10://DB
                handleReadEdge(downEdgeSource.get(2),downEdge.get(2),index);
                break;
            case 11://DR
                handleReadEdge(downEdgeSource.get(1),downEdge.get(1),index);
                break;

        }

        SpannableStringBuilder ssbF = new SpannableStringBuilder();
        SpannableStringBuilder ssb = new SpannableStringBuilder();
        ssbF.append("棱块翻色： ");
        ssb.append("棱块编码： ");
        for(int i = 0;i<tempFasnseEdgeCodes.size();i++) {
            ssbF.append(tempFasnseEdgeCodes.get(i));
        }

        for(int i = 0;i<edgeCodes.size();i++){
            ResultCode resultCode = edgeCodes.get(i);
            SpannableString ss = new SpannableString(resultCode.getCode());
            if (resultCode.isjie()) {
                ForegroundColorSpan span = new ForegroundColorSpan(Color.parseColor("#0099EE"));
                ss.setSpan(span,0,1,Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
            }else if(resultCode.isHuang()){
                ForegroundColorSpan span = new ForegroundColorSpan(Color.parseColor("#00FF33"));
                ss.setSpan(span,0,1,Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
            }else{
                ForegroundColorSpan span = new ForegroundColorSpan(Color.parseColor("#FFFFFF"));
                ss.setSpan(span,0,1,Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
            }
            ssb.append(ss);
            if(i%2==1){
                ssb.append("  ");
            }
        }

        return new SpannableStringBuilder[]{ssb,ssbF};
    }

    /**
     * 删除借位列表中当前缓冲的编码，因为根本用不到
     */
    private void removeBufferCodes(CornerOrEdge cornerOrEdge,int index){
        switch (cornerOrEdge) {
            case CORNER:
                switch (index) {
                    case 0://UBR
                        for(int i = 0;i<cornerLocation0.size();i++){
                            cornerJiewei.remove(cornerLocation0.get(i));
                        }
                        break;
                    case 1://UFR
                        for(int i = 0;i<cornerLocation1.size();i++){
                            cornerJiewei.remove(cornerLocation1.get(i));
                        }
                        break;

                    case 2://UFL
                        for(int i = 0;i<cornerLocation2.size();i++){
                            cornerJiewei.remove(cornerLocation2.get(i));
                        }
                        break;

                    case 3://UBL
                        for(int i = 0;i<cornerLocation3.size();i++){
                            cornerJiewei.remove(cornerLocation3.get(i));
                        }
                        break;

                    case 4://DFR
                        for(int i = 0;i<cornerLocation4.size();i++){
                            cornerJiewei.remove(cornerLocation4.get(i));
                        }
                        break;

                    case 5://UBR
                        for(int i = 0;i<cornerLocation5.size();i++){
                            cornerJiewei.remove(cornerLocation5.get(i));
                        }
                        break;

                    case 6://DBL
                        for(int i = 0;i<cornerLocation6.size();i++){
                            cornerJiewei.remove(cornerLocation6.get(i));
                        }
                        break;

                    case 7://DFL
                        for(int i = 0;i<cornerLocation7.size();i++){
                            cornerJiewei.remove(cornerLocation7.get(i));
                        }
                        break;

                }
                break;

            case EDGE:
                switch (index) {
                    case 0://UB
                        for(int i = 0;i<edgeLocation0.size();i++){
                            edgeJiewei.remove(edgeLocation0.get(i));
                        }
                        break;
                    case 1://UR
                        for(int i = 0;i<edgeLocation1.size();i++){
                            edgeJiewei.remove(edgeLocation1.get(i));
                        }
                        break;
                    case 2://UF
                        for(int i = 0;i<edgeLocation2.size();i++){
                            edgeJiewei.remove(edgeLocation2.get(i));
                        }
                        break;
                    case 3://UL
                        for(int i = 0;i<edgeLocation3.size();i++){
                            edgeJiewei.remove(edgeLocation3.get(i));
                        }
                        break;
                    case 4://FR
                        for(int i = 0;i<edgeLocation4.size();i++){
                            edgeJiewei.remove(edgeLocation4.get(i));
                        }
                        break;
                    case 5://FL
                        for(int i = 0;i<edgeLocation5.size();i++){
                            edgeJiewei.remove(edgeLocation5.get(i));
                        }
                        break;
                    case 6://BL
                        for(int i = 0;i<edgeLocation6.size();i++){
                            edgeJiewei.remove(edgeLocation6.get(i));
                        }
                        break;
                    case 7://BR
                        for(int i = 0;i<edgeLocation7.size();i++){
                            edgeJiewei.remove(edgeLocation7.get(i));
                        }
                        break;
                    case 8://DF
                        for(int i = 0;i<edgeLocation8.size();i++){
                            edgeJiewei.remove(edgeLocation8.get(i));
                        }
                        break;
                    case 9://DL
                        for(int i = 0;i<edgeLocation9.size();i++){
                            edgeJiewei.remove(edgeLocation9.get(i));
                        }
                        break;
                    case 10://DB
                        for(int i = 0;i<edgeLocation10.size();i++){
                            edgeJiewei.remove(edgeLocation10.get(i));
                        }
                        break;
                    case 11://DR
                        for(int i = 0;i<edgeLocation11.size();i++){
                            edgeJiewei.remove(edgeLocation11.get(i));
                        }
                        break;

                }
                break;
        }
    }

    /**
     * 返回需要删除的借位编码list
     */
    public List<String> getBufferList(CornerOrEdge cornerOrEdge,int index){
        switch (cornerOrEdge) {
            case CORNER:
                switch (index) {
                    case 0://UBR
                        return cornerLocation0;
                    case 1://UFR
                        return cornerLocation1;
                    case 2://UFL
                        return cornerLocation2;
                    case 3://UBL
                        return cornerLocation3;
                    case 4://DFR
                        return cornerLocation4;
                    case 5://UBR
                        return cornerLocation5;
                    case 6://DBL
                        return cornerLocation6;
                    case 7://DFL
                        return cornerLocation7;
                }
                break;

            case EDGE:
                switch (index) {
                    case 0://UB
                        return edgeLocation0;
                    case 1://UR
                        return edgeLocation1;
                    case 2://UF
                        return edgeLocation2;
                    case 3://UL
                        return edgeLocation3;
                    case 4://FR
                        return edgeLocation4;
                    case 5://FL
                        return edgeLocation5;
                    case 6://BL
                        return edgeLocation6;
                    case 7://BR
                        return edgeLocation7;
                    case 8://DF
                        return edgeLocation8;
                    case 9://DL
                        return edgeLocation9;
                    case 10://DB
                        return edgeLocation10;
                    case 11://DR
                        return edgeLocation11;
                }
                break;
        }
        return null;
    }

    /**
     * 寻找借位 角块
     * @param resultCodes
     * @param index 借几号位色相
     */
    private void jieWeiLuojiCorner(List<String> resultCodes, int index) {

        //删除预定借位中  编码出现过的
        for(int i=0; i<resultCodes.size();i++){
            String haveCode = resultCodes.get(i);
            for(int j=0;j<cornerJiewei.size();j++){
                String jie = cornerJiewei.get(j);
                if(isTogether(CornerOrEdge.CORNER,haveCode,jie)){
                    cornerJiewei.remove(j);
                    break;
                }
            }
        }

        while (true){
            String jjCode = "";
            for (int i = 0;i<cornerJiewei.size();i++){

                if(!resultCodes.contains(cornerJiewei.get(i))){
                    //借位的编码可用
                    String jieWei = cornerJiewei.get(i);
                    int[] dir = getDirectIndexByDynamic(CornerOrEdge.CORNER,jieWei);
                    String jie = getDynamicCodeByDirectAndIndex(CornerOrEdge.CORNER,dir);
                    if(isTogether(CornerOrEdge.CORNER,jieWei,jie)){//找到一个没有被编过的借位，但是此位置角块正确  例如C没有编过，但是C位置是正确的，或者需要翻色
                        if(getCornerLocation(jieWei)[1]!=getCornerLocation(jie)[1]){
                            int[] dir2 = getDirectIndexByDynamic(CornerOrEdge.CORNER,jie);
                            String nextCode = getDynamicCodeByDirectAndIndex(CornerOrEdge.CORNER,dir2);
                            String nextCode2 = getCodeByCodeAndIndex(CornerOrEdge.CORNER,nextCode,0);

                            tempFasnseCodes.add(nextCode+nextCode2+" ");
                        }
                        //删除借位列表里不可用的编码
                        cornerJiewei.remove(i);
                        break;
                    }else{
                        //找到真正可以用的借位编码
                        jjCode = jieWei;
                        if(isKeepHue){//判断是否保持色相借位
                            jjCode = getCodeByCodeAndIndex(CornerOrEdge.CORNER,jjCode,index);
                        }
                        isCornerFinish = false;
                        break;
                    }
                }
            }
            if (!TextUtils.isEmpty(jjCode)) {
                currentCornerJie = jjCode;
                isCornerFinish = false;
                break;
            }else {
                if(cornerJiewei.size()!=0){
                    //还有可借的编码
                    continue;
                }else{
                    //没有可借的编码
                    isCornerFinish = true;
//                    System.out.println("结束编码");
                    break;
                }
            }
        }

    }

    /**
     * 寻找借位 棱块
     * @param resultCodes
     * @param index 借几号位色相
     */
    private void jieWeiLuojiEdge(List<String> resultCodes, int index) {

        //删除预定借位中  编码出现过的
        for(int i=0; i<resultCodes.size();i++){
            String haveCode = resultCodes.get(i);
            for(int j=0;j<edgeJiewei.size();j++){
                String jie = edgeJiewei.get(j);
                if(isTogether(CornerOrEdge.EDGE,haveCode,jie)){
                    edgeJiewei.remove(j);
                    break;
                }
            }
        }

        while (true){
            String jjCode = "";
            for (int i = 0;i<edgeJiewei.size();i++){

                if(!resultCodes.contains(edgeJiewei.get(i))){
                    //借位的编码可用
                    String jieWei = edgeJiewei.get(i);
                    int[] dir = getDirectIndexByDynamic(CornerOrEdge.EDGE,jieWei);
                    String jie = getDynamicCodeByDirectAndIndex(CornerOrEdge.EDGE,dir);
                    if(isTogether(CornerOrEdge.EDGE,jieWei,jie)){//找到一个没有被编过的借位，但是此位置角块正确  例如C没有编过，但是C位置是正确的，或者需要翻色
                        if(getEdgeLocation(jieWei)[1]!=getEdgeLocation(jie)[1]){
                            int[] dir2 = getDirectIndexByDynamic(CornerOrEdge.EDGE,jie);
                            String nextCode = getDynamicCodeByDirectAndIndex(CornerOrEdge.EDGE,dir2);
                            tempFasnseEdgeCodes.add(jie+nextCode+"  ");
                        }
                        //删除借位列表里不可用的编码
                        edgeJiewei.remove(i);
                        break;
                    }else{
                        //找到真正可以用的借位编码
                        jjCode = jieWei;
                        if(isKeepHueEdge){//判断是否保持色相借位
                            jjCode = getCodeByCodeAndIndex(CornerOrEdge.EDGE,jjCode,index);
                        }
                        isEdgeFinish = false;
                        break;
                    }
                }
            }
            if (!TextUtils.isEmpty(jjCode)) {
                currentEdgeJie = jjCode;
                isEdgeFinish = false;
                break;
            }else {
                if(edgeJiewei.size()!=0){
                    //还有可借的编码
                    continue;
                }else{
                    //没有可借的编码
                    isEdgeFinish = true;
//                    System.out.println("结束编码");
                    break;
                }
            }
        }

    }

    /**
     * 根据方向，下标，获取该位置的动态编码
     * @param cornerOrEdge
     * @param d
     * @return
     */
    private String getDynamicCodeByDirectAndIndex(CornerOrEdge cornerOrEdge, int[] d) {
        switch (cornerOrEdge) {
            case CORNER:
                switch (d[0]){
                    case 1:
                        return upCorner.get(d[1]);
                    case 2:
                        return downCorner.get(d[1]);
                    case 3:
                        return leftCorner.get(d[1]);
                    case 4:
                        return rightCorner.get(d[1]);
                   case 5:
                        return frontCorner.get(d[1]);
                    case 6:
                        return backCorner.get(d[1]);
                }

                break;

            case EDGE:

                switch (d[0]){
                    case 1:
                        return upEdge.get(d[1]);
                    case 2:
                        return downEdge.get(d[1]);
                    case 3:
                        return leftEdge.get(d[1]);
                    case 4:
                        return rightEdge.get(d[1]);
                    case 5:
                        return frontEdge.get(d[1]);
                    case 6:
                        return backEdge.get(d[1]);
                }
                break;
        }
        return "";
    }


    /**
     * 定义list符号表示
     * 1 up
     * 2 down
     * 3 left
     * 4 right
     * 5 front
     * 6 back
     * 根据动态编码找原始位置  返回数组【方向，下标】
     */
    private int[] getDirectIndexByDynamic(CornerOrEdge cornerOrEdge, String dynamicCode){
        int[] d = {0};
        switch (cornerOrEdge) {
            case CORNER:
                for(int i = 0;i<upCornerSource.size();i++){
                    if(TextUtils.equals(dynamicCode,upCornerSource.get(i))){
                        int[] direct = {1,i};
                        return direct;
                    }
                }
                for(int i = 0;i<downCornerSource.size();i++){
                    if(TextUtils.equals(dynamicCode,downCornerSource.get(i))){
                        int[] direct = {2,i};
                        return direct;
                    }
                }
                for(int i = 0;i<leftCornerSource.size();i++){
                    if(TextUtils.equals(dynamicCode,leftCornerSource.get(i))){
                        int[] direct = {3,i};
                        return direct;
                    }
                }
                for(int i = 0;i<rightCornerSource.size();i++){
                    if(TextUtils.equals(dynamicCode,rightCornerSource.get(i))){
                        int[] direct = {4,i};
                        return direct;
                    }
                }
                for(int i = 0;i<frontCornerSource.size();i++){
                    if(TextUtils.equals(dynamicCode,frontCornerSource.get(i))){
                        int[] direct = {5,i};
                        return direct;
                    }
                }
                for(int i = 0;i<backCornerSource.size();i++){
                    if(TextUtils.equals(dynamicCode,backCornerSource.get(i))){
                        int[] direct = {6,i};
                        return direct;
                    }
                }

                break;

           case EDGE:
                for(int i = 0;i< upEdgeSource.size();i++){
                    if(TextUtils.equals(dynamicCode,upEdgeSource.get(i))){
                        int[] direct = {1,i};
                        return direct;
                    }
                }
                for(int i = 0;i<downEdgeSource.size();i++){
                    if(TextUtils.equals(dynamicCode,downEdgeSource.get(i))){
                        int[] direct = {2,i};
                        return direct;
                    }
                }
                for(int i = 0;i<leftEdgeSource.size();i++){
                    if(TextUtils.equals(dynamicCode,leftEdgeSource.get(i))){
                        int[] direct = {3,i};
                        return direct;
                    }
                }
                for(int i = 0;i<rightEdgeSource.size();i++){
                    if(TextUtils.equals(dynamicCode,rightEdgeSource.get(i))){
                        int[] direct = {4,i};
                        return direct;
                    }
                }
                for(int i = 0;i<frontEdgeSource.size();i++){
                    if(TextUtils.equals(dynamicCode,frontEdgeSource.get(i))){
                        int[] direct = {5,i};
                        return direct;
                    }
                }
                for(int i = 0;i<backEdgeSource.size();i++){
                    if(TextUtils.equals(dynamicCode,backEdgeSource.get(i))){
                        int[] direct = {6,i};
                        return direct;
                    }
                }
                break;
        }
        return d;
    }


    /**
     * 根据编码和色相位置
     * 获取角块原始编码
     * 例如传入  "E",2   返回 ”F"
     * 传入 “A",1  返回”B"
     *
     * 获取棱块原始编码
     * 例如传入  "E",1   返回 ”F"
     * 例如传入  "C",1   返回 ”D"
     * @param cornerOrEdge
     * @param code
     * @param index
     * @return
     */
    private String getCodeByCodeAndIndex(CornerOrEdge cornerOrEdge, String code, int index){
        switch (cornerOrEdge) {
            case CORNER:
                switch (getCornerLocation(code)[0]) {
                    case 0:
                        return cornerLocation0.get(index);
                    case 1:
                        return cornerLocation1.get(index);
                    case 2:
                        return cornerLocation2.get(index);
                    case 3:
                        return cornerLocation3.get(index);
                    case 4:
                        return cornerLocation4.get(index);
                    case 5:
                        return cornerLocation5.get(index);
                    case 6:
                        return cornerLocation6.get(index);
                    case 7:
                        return cornerLocation7.get(index);
                }

                break;


            case EDGE:

                switch (getEdgeLocation(code)[0]) {
                   case 0:
                        return  edgeLocation0.get(index);
                   case 1:
                        return  edgeLocation1.get(index);
                   case 2:
                        return  edgeLocation2.get(index);
                   case 3:
                        return  edgeLocation3.get(index);
                   case 4:
                        return  edgeLocation4.get(index);
                   case 5:
                        return  edgeLocation5.get(index);
                   case 6:
                        return  edgeLocation6.get(index);
                   case 7:
                        return  edgeLocation7.get(index);
                   case 8:
                        return  edgeLocation8.get(index);
                   case 9:
                        return  edgeLocation9.get(index);
                   case 10:
                        return  edgeLocation10.get(index);
                   case 11:
                        return  edgeLocation11.get(index);
                }

                break;
        }

        return "";
    }


    /**
     * 检验 角或棱的编码是否在同一个块上
     * @param cornerOrEdge
     * @param sourceCode 原始编码的位置
     * @param targetCode 需要到达的位置
     * @return
     */
    private boolean isTogether(CornerOrEdge cornerOrEdge,String sourceCode,String targetCode){
        switch (cornerOrEdge) {
            case CORNER:
                if(getCornerLocation(sourceCode)[0]==getCornerLocation(targetCode)[0]){
                    return true;
                }
                break;
            case EDGE:
                int sourceIndex = getEdgeLocation(sourceCode)[0];
                int targetIndex = getEdgeLocation(targetCode)[0];
                if(sourceIndex==targetIndex){
                    return true;
                }
                break;
        }

        return false;
    }

    List<String> cornerLocation0;
    List<String> cornerLocation1;
    List<String> cornerLocation2;
    List<String> cornerLocation3;
    List<String> cornerLocation4;
    List<String> cornerLocation5;
    List<String> cornerLocation6;
    List<String> cornerLocation7;

    List<String> edgeLocation0;
    List<String> edgeLocation1;
    List<String> edgeLocation2;
    List<String> edgeLocation3;
    List<String> edgeLocation4;
    List<String> edgeLocation5;
    List<String> edgeLocation6;
    List<String> edgeLocation7;
    List<String> edgeLocation8;
    List<String> edgeLocation9;
    List<String> edgeLocation10;
    List<String> edgeLocation11;

    /**
     * 初始化 编码， 某一块上面的编码，角块3个，棱块2个
     */
    private void initLoacationCodes() {
        //UBR 0
        cornerLocation0 = new ArrayList<>();
        cornerLocation0.add(upCornerSource.get(0));
        cornerLocation0.add(backCornerSource.get(3));
        cornerLocation0.add(rightCornerSource.get(0));

        //UFR 1
        cornerLocation1 = new ArrayList<>();
        cornerLocation1.add(upCornerSource.get(1));
        cornerLocation1.add(rightCornerSource.get(3));
        cornerLocation1.add(frontCornerSource.get(0));

        //UFL 2
        cornerLocation2 = new ArrayList<>();
        cornerLocation2.add(upCornerSource.get(2));
        cornerLocation2.add(frontCornerSource.get(3));
        cornerLocation2.add(leftCornerSource.get(0));

        //UBL 3
        cornerLocation3 = new ArrayList<>();
        cornerLocation3.add(upCornerSource.get(3));
        cornerLocation3.add(leftCornerSource.get(3));
        cornerLocation3.add(backCornerSource.get(0));

        //DFR 4
        cornerLocation4 = new ArrayList<>();
        cornerLocation4.add(downCornerSource.get(0));
        cornerLocation4.add(frontCornerSource.get(1));
        cornerLocation4.add(rightCornerSource.get(2));

        //DBR 5
        cornerLocation5 = new ArrayList<>();
        cornerLocation5.add(downCornerSource.get(1));
        cornerLocation5.add(rightCornerSource.get(1));
        cornerLocation5.add(backCornerSource.get(2));

        //DBL 6
        cornerLocation6 = new ArrayList<>();
        cornerLocation6.add(downCornerSource.get(2));
        cornerLocation6.add(backCornerSource.get(1));
        cornerLocation6.add(leftCornerSource.get(2));

        //DFL 7
        cornerLocation7 = new ArrayList<>();
        cornerLocation7.add(downCornerSource.get(3));
        cornerLocation7.add(leftCornerSource.get(1));
        cornerLocation7.add(frontCornerSource.get(2));


        //UB 0
        edgeLocation0 = new ArrayList<>();
        edgeLocation0.add(upEdgeSource.get(0));
        edgeLocation0.add(backEdgeSource.get(0));

        //UR 1
        edgeLocation1 = new ArrayList<>();
        edgeLocation1.add(upEdgeSource.get(1));
        edgeLocation1.add(rightEdgeSource.get(0));


        //UF 2
        edgeLocation2 = new ArrayList<>();
        edgeLocation2.add(upEdgeSource.get(2));
        edgeLocation2.add(frontEdgeSource.get(0));


        //UL 3
        edgeLocation3 = new ArrayList<>();
        edgeLocation3.add(upEdgeSource.get(3));
        edgeLocation3.add(leftEdgeSource.get(0));


        //FR 4
        edgeLocation4 = new ArrayList<>();
        edgeLocation4.add(frontEdgeSource.get(1));
        edgeLocation4.add(rightEdgeSource.get(3));


        //FL 5
        edgeLocation5 = new ArrayList<>();
        edgeLocation5.add(frontEdgeSource.get(3));
        edgeLocation5.add(leftEdgeSource.get(1));

        //BL 6
        edgeLocation6 = new ArrayList<>();
        edgeLocation6.add(backEdgeSource.get(1));
        edgeLocation6.add(leftEdgeSource.get(3));

        //BR 7
        edgeLocation7 = new ArrayList<>();
        edgeLocation7.add(backEdgeSource.get(3));
        edgeLocation7.add(rightEdgeSource.get(1));

        //DF 8
        edgeLocation8 = new ArrayList<>();
        edgeLocation8.add(downEdgeSource.get(0));
        edgeLocation8.add(frontEdgeSource.get(2));

        //DL 9
        edgeLocation9 = new ArrayList<>();
        edgeLocation9.add(downEdgeSource.get(3));
        edgeLocation9.add(leftEdgeSource.get(2));

        //DB 10
        edgeLocation10 = new ArrayList<>();
        edgeLocation10.add(downEdgeSource.get(2));
        edgeLocation10.add(backEdgeSource.get(2));

        //DR 11
        edgeLocation11 = new ArrayList<>();
        edgeLocation11.add(downEdgeSource.get(1));
        edgeLocation11.add(rightEdgeSource.get(2));
    }




    /**
     * 根据编码 获取角块位置  数组
     *
     * 第一位 位置  0 UBR位置  1 UFR位置   右上角顺时针排序 0-7
     *
     * 第二位  是色相 0 1 2
     *
     *
     * @param cornerCode
     * @return
     */
    private int[] getCornerLocation(String cornerCode){
        for (int i = 0;i<cornerLocation0.size();i++) {
            String s = cornerLocation0.get(i);
            if (TextUtils.equals(s,cornerCode)) {
                return new int[]{0,i};
            }
        }

        for (int i = 0;i<cornerLocation1.size();i++) {
            String s = cornerLocation1.get(i);
            if (TextUtils.equals(s,cornerCode)) {
                return new int[]{1,i};
            }
        }

        for (int i = 0;i<cornerLocation2.size();i++) {
            String s = cornerLocation2.get(i);
            if (TextUtils.equals(s,cornerCode)) {
                return new int[]{2,i};
            }
        }

        for (int i = 0;i<cornerLocation3.size();i++) {
            String s = cornerLocation3.get(i);
            if (TextUtils.equals(s,cornerCode)) {
                return new int[]{3,i};
            }
        }

        for (int i = 0;i<cornerLocation4.size();i++) {
            String s = cornerLocation4.get(i);
            if (TextUtils.equals(s,cornerCode)) {
                return new int[]{4,i};
            }
        }

        for (int i = 0;i<cornerLocation5.size();i++) {
            String s = cornerLocation5.get(i);
            if (TextUtils.equals(s,cornerCode)) {
                return new int[]{5,i};
            }
        }

        for (int i = 0;i<cornerLocation6.size();i++) {
            String s = cornerLocation6.get(i);
            if (TextUtils.equals(s,cornerCode)) {
                return new int[]{6,i};
            }
        }

        for (int i = 0;i<cornerLocation7.size();i++) {
            String s = cornerLocation7.get(i);
            if (TextUtils.equals(s,cornerCode)) {
                return new int[]{7,i};
            }
        }

        return new int[]{-1,-1};
    }



    /**
     * 根据编码 获取棱块位置
     *
     *    第一位  0 UB位置  1 UR位置
     *  * 第二位  是色相 0 1
     * @param edgeCode
     * @return
     */
    private int[] getEdgeLocation(String edgeCode){
        for (int i = 0;i<edgeLocation0.size();i++) {
            String s = edgeLocation0.get(i);
            if (TextUtils.equals(s,edgeCode)) {
                return new int[]{0,i};
            }
        }

        for (int i = 0;i<edgeLocation1.size();i++) {
            String s = edgeLocation1.get(i);
            if (TextUtils.equals(s,edgeCode)) {
                return new int[]{1,i};
            }
        }

        for (int i = 0;i<edgeLocation2.size();i++) {
            String s = edgeLocation2.get(i);
            if (TextUtils.equals(s,edgeCode)) {
                return new int[]{2,i};
            }
        }
        for (int i = 0;i<edgeLocation3.size();i++) {
            String s = edgeLocation3.get(i);
            if (TextUtils.equals(s,edgeCode)) {
                return new int[]{3,i};
            }
        }

        for (int i = 0;i<edgeLocation4.size();i++) {
            String s = edgeLocation4.get(i);
            if (TextUtils.equals(s,edgeCode)) {
                return new int[]{4,i};
            }
        }

        for (int i = 0;i<edgeLocation5.size();i++) {
            String s = edgeLocation5.get(i);
            if (TextUtils.equals(s,edgeCode)) {
                return new int[]{5,i};
            }
        }
        for (int i = 0;i<edgeLocation6.size();i++) {
            String s = edgeLocation6.get(i);
            if (TextUtils.equals(s,edgeCode)) {
                return new int[]{6,i};
            }
        }

        for (int i = 0;i<edgeLocation7.size();i++) {
            String s = edgeLocation7.get(i);
            if (TextUtils.equals(s,edgeCode)) {
                return new int[]{7,i};
            }
        }

        for (int i = 0;i<edgeLocation8.size();i++) {
            String s = edgeLocation8.get(i);
            if (TextUtils.equals(s,edgeCode)) {
                return new int[]{8,i};
            }
        }
        for (int i = 0;i<edgeLocation9.size();i++) {
            String s = edgeLocation9.get(i);
            if (TextUtils.equals(s,edgeCode)) {
                return new int[]{9,i};
            }
        }

        for (int i = 0;i<edgeLocation10.size();i++) {
            String s = edgeLocation10.get(i);
            if (TextUtils.equals(s,edgeCode)) {
                return new int[]{10,i};
            }
        }
        for (int i = 0;i<edgeLocation11.size();i++) {
            String s = edgeLocation11.get(i);
            if (TextUtils.equals(s,edgeCode)) {
                return new int[]{11,i};
            }
        }




        return new int[]{-1,-1};
    }


    private void rotateRw2(){
        rotateRw();
        rotateRw();
    }

    private void rotateRw(){
        rotateR();
        rotateMs();
    }

    private void rotateRws(){
        rotateRs();
        rotateM();
    }

    private void rotateR2() {
        rotateR();
        rotateR();
    }

    private void rotateR() {

        //corner..

        //right 3 ----> right 0
        sortList(rightCorner,3,0);

        //up 0 1 ----> back 2 3
        //back 2 3 ----> down 0 1
        //down 0 1 ----> front 0 1
        //front 0 1 ----> up 0 1
        int[]upCornerIndexs = {0,1};
        int[]backCornerIndexs = {2,3};
        int[]downCornerIndexs = {0,1};
        int[]frontCornerIndexs = {0,1};
        replaceData(upCorner,backCorner,downCorner,frontCorner,upCornerIndexs,backCornerIndexs,downCornerIndexs,frontCornerIndexs);


        //edge..
        //right 3----> right 0
        sortList(rightEdge,3,0);

        //up 1 -----> back 3
        //back 3 ----> down 1
        //down 1 -----> font 1
        //front 1 -----> up 1
        int[]upEdgeIndexs = {1};
        int[]backEdgeIndexs = {3};
        int[]downEdgeIndexs = {1};
        int[]frontEdgeIndexs = {1};
        replaceData(upEdge,backEdge,downEdge,frontEdge,upEdgeIndexs,backEdgeIndexs,downEdgeIndexs,frontEdgeIndexs);
    }

    private void rotateRs(){
        rotateR();
        rotateR();
        rotateR();
    }

    private void rotateU() {

        //corner..
        //up 3  ----> up 0
        sortList(upCorner,3,0);
        //front 0 3 ----> left 0 3
        //left 0 3 ----> back 0 3
        //back 0 3 ----> right 0 3
        //right 0 3 ----> front 0 3
        int[]frontCornerIndexs = {0,3};
        int[]leftCornerIndexs = {0,3};
        int[]backCornerIndexs = {0,3};
        int[]rightCornerIndexs = {0,3};
        replaceData(frontCorner, leftCorner, backCorner, rightCorner, frontCornerIndexs, leftCornerIndexs, backCornerIndexs, rightCornerIndexs);


        //edge..
        //up 3 -----> up 0
        sortList(upEdge, 3, 0);
        //front 0 ----> left 0
        //left 0 -----> back 0
        //back 0 -----> right 0
        //right 0----> front 0
        int[] frontEdgeIndexs = {0};
        int[] leftEdgeIndexs = {0};
        int[] backEdgeIndexs = {0};
        int[] rightEdgeIndexs = {0};
        replaceData(frontEdge, leftEdge, backEdge, rightEdge, frontEdgeIndexs, leftEdgeIndexs, backEdgeIndexs, rightEdgeIndexs);
    }

    private void rotateUs() {
        rotateU();
        rotateU();
        rotateU();
    }

    private void rotateU2(){
        rotateU();
        rotateU();
    }

    private void rotateUw(){
        rotateU();
        rotateEs();
    }

    private void rotateUws(){
        rotateUs();
        rotateE();
    }

    private void rotateUw2(){
        rotateUw();
        rotateUw();
    }

    private void rotateD() {

        //corner..
        //down 3 ----> down 0
        sortList(downCorner, 3, 0);
        //front 1 2 ----> right 1 2
        //right 1 2 ----> back 1 2
        //back 1 2 ----> left 1 2
        //left 1 2 ----> front 1 2
        int[]frontCornerIndexs = {1,2};
        int[]rightCornerIndexs = {1,2};
        int[]backCornerIndexs = {1,2};
        int[]leftCornerIndexs = {1,2};
        replaceData(frontCorner, rightCorner, backCorner, leftCorner, frontCornerIndexs, rightCornerIndexs, backCornerIndexs, leftCornerIndexs);

        //edge..
        //down 3 ----> down 0
        sortList(downEdge, 3, 0);
        //front 2 ----> right 2
        //right 2 ----> back 2
        //back 2 ----> left 2
        //left 2 ----> front 2
        int[] frontEdgeIndexs = {2};
        int[] rightEdgeIndexs = {2};
        int[] backEdgeIndexs = {2};
        int[] leftEdgeIndexs = {2};
        replaceData(frontEdge, rightEdge, backEdge, leftEdge, frontEdgeIndexs, rightEdgeIndexs, backEdgeIndexs, leftEdgeIndexs);
    }

    private void rotateDs() {
        rotateD();
        rotateD();
        rotateD();
    }

    private void rotateD2() {
        rotateD();
        rotateD();
    }

    private void rotateDw() {
        rotateD();
        rotateE();
    }

    private void rotateDws() {
        rotateDs();
        rotateEs();
    }

    private void rotateDw2() {
        rotateDw();
        rotateDw();
    }

    private void rotateF() {

        //corner..
        //front 3 ----> front 0
        sortList(frontCorner, 3, 0);
        //up 1 2 ----> right 2 3
        //right 2 3 ----> down 3 0
        //down 3 0 ----> left 0 1
        //left 0 1 ----> up 1 2
        int[]upCornerIndexs = {1,2};
        int[]rightCornerIndexs = {2,3};
        int[]downCornerIndexs = {3,0};
        int[]leftCornerIndexs = {0,1};
        replaceData(upCorner, rightCorner, downCorner, leftCorner, upCornerIndexs, rightCornerIndexs, downCornerIndexs, leftCornerIndexs);

        //edge..
        //front 3 ----> front 0
        sortList(frontEdge, 3, 0);
        //up  2 ----> right  3
        //right 3 ----> down  0
        //down 0 ----> left  1
        //left 1 ----> up  2
        int[] upEdgeIndexs = {2};
        int[] rightEdgeIndexs = {3};
        int[] downEdgeIndexs = {0};
        int[] leftEdgeIndexs = {1};
        replaceData(upEdge, rightEdge, downEdge, leftEdge, upEdgeIndexs, rightEdgeIndexs, downEdgeIndexs, leftEdgeIndexs);
    }

    private void rotateFs() {
        rotateF();
        rotateF();
        rotateF();
    }

    private void rotateF2() {
        rotateF();
        rotateF();
    }

    private void rotateFw() {
        rotateF();
        rotateS();
    }

    private void rotateFws() {
        rotateFs();
        rotateSs();
    }

    private void rotateFw2() {
        rotateFw();
        rotateFw();
    }

    public void rotateL() {

        //corner..
        //left 3 ----> left 0
        sortList(leftCorner, 3, 0);
        //up 2 3 ----> front 2 3
        //front 2 3 ----> down 2 3
        //down 2 3 ----> back 0 1
        //back 0 1----> up 2 3
        int[]upCornerIndexs = {2,3};
        int[]frontCornerIndexs = {2,3};
        int[]downCornerIndexs = {2,3};
        int[]backCornerIndexs = {0,1};
        replaceData(upCorner, frontCorner, downCorner, backCorner, upCornerIndexs, frontCornerIndexs, downCornerIndexs, backCornerIndexs);
        //edge..
        //left 3 ----> left 0
        sortList(leftEdge, 3, 0);
        //up  3 ----> front 3
        //front  3 ----> down  3
        //down  3 ----> back  1
        //back  1----> up  3
        int[] upEdgeIndexs = {3};
        int[] frontEdgeIndexs = {3};
        int[] downEdgeIndexs = {3};
        int[] backEdgeIndexs = {1};
        replaceData(upEdge, frontEdge, downEdge, backEdge, upEdgeIndexs, frontEdgeIndexs, downEdgeIndexs, backEdgeIndexs);
    }

    public void rotateLs() {
        rotateL();
        rotateL();
        rotateL();
    }

    private void rotateL2() {
        rotateL();
        rotateL();
    }

    private void rotateLw() {
        rotateL();
        rotateM();
    }

    private void rotateLws() {
        rotateLs();
        rotateMs();
    }

    private void rotateLw2() {
        rotateLw();
        rotateLw();
    }
    private void rotateX() {
        rotateRw();
        rotateLs();
    }
    private void rotateXs() {
        rotateX();
        rotateX();
        rotateX();
    }
    private void rotateX2() {
        rotateX();
        rotateX();
    }

    private void rotateY() {
        rotateUw();
        rotateDs();
    }
    private void rotateYs() {
        rotateY();
        rotateY();
        rotateY();
    }
    private void rotateY2() {
        rotateY();
        rotateY();
    }

    private void rotateZ() {
        rotateFw();
        rotateBs();
    }
    private void rotateZs() {
        rotateZ();
        rotateZ();
        rotateZ();
    }
    private void rotateZ2() {
        rotateZ();
        rotateZ();
    }

    private void rotateB() {

        //corner..
        //back 3  ----> back 0
        sortList(backCorner, 3, 0);
        //up 0 3 ----> left 3 2
        //left 3 2 ----> down 2 1
        //down 2 1 ----> right 1 0
        //right 1 0 ----> up 0 3
        int[]upCornerIndexs = {0,3};
        int[]leftCornerIndexs = {3,2};
        int[]downCornerIndexs = {2,1};
        int[]rightCornerIndexs = {1,0};
        replaceData(upCorner, leftCorner, downCorner, rightCorner,upCornerIndexs,leftCornerIndexs,downCornerIndexs,rightCornerIndexs);

        //edge..
        //back 3  ----> back 0
        sortList(backEdge, 3, 0);
        //up 0  ----> left 3
        //left 3  ----> down 2
        //down 2  ----> right 1
        //right 1  ----> up 0
        int[] upEdgeIndexs = {0};
        int[] leftEdgeIndexs = {3};
        int[] downEdgeIndexs = {2};
        int[] rightEdgeIndexs = {1};
        replaceData(upEdge, leftEdge, downEdge, rightEdge, upEdgeIndexs, leftEdgeIndexs, downEdgeIndexs, rightEdgeIndexs);
    }

    private void rotateBs() {
        rotateB();
        rotateB();
        rotateB();
    }

    private void rotateB2() {
        rotateB();
        rotateB();
    }

    private void rotateBw() {
        rotateB();
        rotateSs();
    }

    private void rotateBws() {
        rotateBs();
        rotateS();
    }

    private void rotateBw2() {
        rotateBw();
        rotateBw();
    }

    private void rotateE() {

        //edge..
        //front 1 3 4  ----> right 1 3 4
        //right 1 3 4   ----> back 1 3 4
        //back 1 3 4  ---->  left 1 3 4
        //left 1 3 4   ----> front 1 3 4
        int[] frontEdgeIndexs = {1,3,4};
        int[] rightEdgeIndexs = {1,3,4};
        int[] backEdgeIndexs = {1,3,4};
        int[] leftEdgeIndexs = {1,3,4};
        replaceData(frontEdge, rightEdge, backEdge, leftEdge, frontEdgeIndexs, rightEdgeIndexs, backEdgeIndexs, leftEdgeIndexs);
    }

    private void rotateEs() {
        rotateE();
        rotateE();
        rotateE();
    }

    private void rotateM() {

        //edge..
        //up 0 2 4  ----> front 0 2 4
        //front 0 2 4   ----> down 0 2 4
        //down 0 2 4  ---->  back 2 0 4
        //back 2 0 4   ----> up 0 2 4
        int[] upEdgeIndexs = {0,2,4};
        int[] frontEdgeIndexs = {0,2,4};
        int[] downEdgeIndexs = {0,2,4};
        int[] backEdgeIndexs = {2,0,4};
        replaceData(upEdge, frontEdge, downEdge, backEdge, upEdgeIndexs, frontEdgeIndexs, downEdgeIndexs, backEdgeIndexs);
    }

    private void rotateMs() {
        rotateM();
        rotateM();
        rotateM();
    }

    private void rotateS() {

        //edge..
        //up 1 3 4  ----> right 2 0 4
        //right 2 0 4   ----> down 3 1 4
        //down 3 1 4  ---->  left 0 2 4
        //left 0 2 4   ----> up 1 3 4
        int[] upEdgeIndexs = {1,3,4};
        int[] rightEdgeIndexs = {2,0,4};
        int[] downEdgeIndexs = {3,1,4};
        int[] leftEdgeIndexs = {0,2,4};
        replaceData(upEdge, rightEdge, downEdge, leftEdge, upEdgeIndexs, rightEdgeIndexs, downEdgeIndexs, leftEdgeIndexs);
    }

    private void rotateSs() {
        rotateS();
        rotateS();
        rotateS();
    }

    /**
     *
     * @param list1
     * @param list2
     * @param list3
     * @param list4
     * @param l1 第一个list 需要替换的元素下标 例如 [2,3]
     * @param l2 第二个list 需要替换的元素下标 例如 [0,2]
     * @param l3 第三个list 需要替换的元素下标 例如 [1,2]
     * @param l4 第四个list 需要替换的元素下标 例如 [1,3]
     * @return 返回重新排序的list
     */
    private ListBean replaceData(List<String>list1, List<String>list2, List<String>list3, List<String>list4, int[]l1, int[]l2, int[]l3, int[]l4) {
        List<String> temp1 = new ArrayList<>();
        List<String> temp2 = new ArrayList<>();
        List<String> temp3 = new ArrayList<>();
        List<String> temp4 = new ArrayList<>();

        temp1.addAll(list1);
        temp2.addAll(list2);
        temp3.addAll(list3);
        temp4.addAll(list4);

        String strTemp1_0 = list1.get(l1[0]);

        String strTemp2_0 = list2.get(l2[0]);

        String strTemp3_0 = list3.get(l3[0]);

        String strTemp4_0 = list4.get(l4[0]);


        temp1.remove(l1[0]);
        temp1.add(l1[0],strTemp4_0);

        temp2.remove(l2[0]);
        temp2.add(l2[0],strTemp1_0);

        temp3.remove(l3[0]);
        temp3.add(l3[0],strTemp2_0);

        temp4.remove(l4[0]);
        temp4.add(l4[0],strTemp3_0);

        if(l1.length>=2){
            String strTemp1_1 = list1.get(l1[1]);
            String strTemp2_1 = list2.get(l2[1]);
            String strTemp3_1 = list3.get(l3[1]);
            String strTemp4_1 = list4.get(l4[1]);

            temp1.remove(l1[1]);
            temp1.add(l1[1],strTemp4_1);
            temp2.remove(l2[1]);
            temp2.add(l2[1],strTemp1_1);
            temp3.remove(l3[1]);
            temp3.add(l3[1],strTemp2_1);
            temp4.remove(l4[1]);
            temp4.add(l4[1],strTemp3_1);
            if(l1.length==3){
                String strTemp1_2 = list1.get(l1[2]);
                String strTemp2_2 = list2.get(l2[2]);
                String strTemp3_2 = list3.get(l3[2]);
                String strTemp4_2 = list4.get(l4[2]);

                temp1.remove(l1[2]);
                temp1.add(l1[2],strTemp4_2);
                temp2.remove(l2[2]);
                temp2.add(l2[2],strTemp1_2);
                temp3.remove(l3[2]);
                temp3.add(l3[2],strTemp2_2);
                temp4.remove(l4[2]);
                temp4.add(l4[2],strTemp3_2);
            }
        }


        list1.clear();
        list1.addAll(temp1);

        list2.clear();
        list2.addAll(temp2);

        list3.clear();
        list3.addAll(temp3);

        list4.clear();
        list4.addAll(temp4);

        return new ListBean(temp1,temp2,temp3,temp4);
    }



    /**
     * @param list
     * @param source 源位置
     * @param target 需要到达的位置
     * @return 返回重新排序的list
     */
    private List<String> sortList(List<String> list,int source,int target){
        List<String> tempList = new ArrayList<>();
        tempList.addAll(list);
        String temp = list.get(source);
        tempList.remove(source);
        tempList.add(target,temp);
        list.clear();
        list.addAll(tempList);
        return tempList;
    }

    @Override
    public String toString() {
        upCorner.toString();
        String display =
                "U-Corner=="+upCorner.toString()+"\n"+

                "D-Corner=="+downCorner.toString()+"\n"+""+

                "L-Corner=="+leftCorner.toString()+"\n"+""+

                "R-Corner=="+rightCorner.toString()+"\n"+""+

                "F-Corner=="+frontCorner.toString()+"\n"+""+

                "B-Corner=="+backCorner.toString()+"\n"+""+
                        "\n"+""+
                        "U-Edge=="+upEdge.toString()+"\n"+""+
                        "D-Edge=="+downEdge.toString()+"\n"+""+
                        "L-Edge=="+leftEdge.toString()+"\n"+""+
                        "R-Edge=="+rightEdge.toString()+"\n"+""+
                        "F-Edge=="+frontEdge.toString()+"\n"+""+
                        "B-Edge=="+backEdge.toString()+"\n"+"";
        return display;
    }


    public List<String> getUpEdgeSource() {
        return upEdgeSource;
    }

    public List<String> getDownEdgeSource() {
        return downEdgeSource;
    }

    public List<String> getFrontEdgeSource() {
        return frontEdgeSource;
    }

    public List<String> getBackEdgeSource() {
        return backEdgeSource;
    }

    public List<String> getUpCornerSource() {
        return upCornerSource;
    }

    public List<String> getDownCornerSource() {
        return downCornerSource;
    }

    public List<String> getLeftCornerSource() {
        return leftCornerSource;
    }

    public List<String> getRightCornerSource() {
        return rightCornerSource;
    }

    public List<String> getFrontCornerSource() {
        return frontCornerSource;
    }

    public List<String> getBackCornerSource() {
        return backCornerSource;
    }

}
