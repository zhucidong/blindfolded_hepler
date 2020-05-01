package zd.cornermemory.utils;

import android.text.TextUtils;

import java.util.ArrayList;
import java.util.List;

import zd.cornermemory.bean.CoordinateKeyValue;
import zd.cornermemory.bean.CornerOrEdge;
import zd.cornermemory.bean.Cube;
import zd.cornermemory.bean.CubeCode;
import zd.cornermemory.bean.CubeColor;
import zd.cornermemory.bean.CubeDirection;
import zd.cornermemory.bean.DyeCubeBean;
import zd.cornermemory.bean.SortCode;

/**
 * Created by zhud on 2019/9/26.
 * 翻译用户自定义坐标
 */

public class CoordinateUtil {
    /**
     * 黄1  白2  蓝3  绿4  红5  橙6
     *
     * 13 代表黄顶蓝前        41 代表绿顶黄前
     * 14 代表黄顶绿前        42 代表绿顶白前
     * 15 代表黄顶红前        45 代表绿顶红前
     * 16 代表黄顶橙前        46 代表绿顶橙前
     *
     * 23 代表白顶蓝前        51 代表红顶黄前
     * 24 代表白顶绿前        52 代表红顶白前
     * 25 代表白顶红前        53 代表红顶蓝前
     * 26 代表白顶橙前        54 代表红顶绿前
     *
     * 35 代表蓝顶红前        61 代表橙顶黄前
     * 36 代表蓝顶橙前        62 代表橙顶白前
     * 31 代表蓝顶黄前        63 代表橙顶蓝前
     * 32 代表蓝顶白前        64 代表橙顶绿前
     *
     */

    /**
     * 获取 Spinner 对应的坐标关系
     * @return
     */
    public static List<String> getcoordinateFlag(){
        List<String> flags = new ArrayList<>();
        flags.add("13");
        flags.add("14");
        flags.add("15");
        flags.add("16");

        flags.add("23");
        flags.add("24");
        flags.add("25");
        flags.add("26");

        flags.add("35");
        flags.add("36");
        flags.add("31");
        flags.add("32");


        flags.add("41");
        flags.add("42");
        flags.add("45");
        flags.add("46");

        flags.add("51");
        flags.add("52");
        flags.add("53");
        flags.add("54");

        flags.add("61");
        flags.add("62");
        flags.add("63");
        flags.add("64");

        return flags;
    }

    /**
     * 获取用户自定义的编码
     */
    public static List<CubeCode> getCustomCode(){
        List<CubeCode> codes = new ArrayList<>();
        String UP_CORNER = SPUtils.getInstance().getString(SpKey.UP_CORNER);
        String UP_EDGE = SPUtils.getInstance().getString(SpKey.UP_EDGE);
        String DOWN_CORNER = SPUtils.getInstance().getString(SpKey.DOWN_CORNER);
        String DOWN_EDGE = SPUtils.getInstance().getString(SpKey.DOWN_EDGE);
        String LEFT_CORNER = SPUtils.getInstance().getString(SpKey.LEFT_CORNER);
        String LEFT_EDGE = SPUtils.getInstance().getString(SpKey.LEFT_EDGE);
        String RIGHT_CORNER = SPUtils.getInstance().getString(SpKey.RIGHT_CORNER);
        String RIGHT_EDGE = SPUtils.getInstance().getString(SpKey.RIGHT_EDGE);
        String FRONT_CORNER = SPUtils.getInstance().getString(SpKey.FRONT_CORNER);
        String FRONT_EDGE = SPUtils.getInstance().getString(SpKey.FRONT_EDGE);
        String BACK_CORNER = SPUtils.getInstance().getString(SpKey.BACK_CORNER);
        String BACK_EDGE = SPUtils.getInstance().getString(SpKey.BACK_EDGE);

        List<String> upCorner = new ArrayList<>();
        List<String> upEdge = new ArrayList<>();
        List<String> downCorner = new ArrayList<>();
        List<String> downEdge = new ArrayList<>();
        List<String> leftCorner = new ArrayList<>();
        List<String> leftEdge = new ArrayList<>();
        List<String> rightCorner = new ArrayList<>();
        List<String> rightEdge = new ArrayList<>();
        List<String> frontCorner = new ArrayList<>();
        List<String> frontEdge = new ArrayList<>();
        List<String> backCorner = new ArrayList<>();
        List<String> backEdge = new ArrayList<>();

        if (TextUtils.isEmpty(UP_CORNER)) { //没有自定义过，默认彳亍编码
            upCorner.add("G");
            upCorner.add("J");
            upCorner.add("A");
            upCorner.add("D");
            upEdge.add("E");
            upEdge.add("G");
            upEdge.add("A");
            upEdge.add("C");
            upEdge.add(SpKey.UP);

            downCorner.add("X");
            downCorner.add("R");
            downCorner.add("O");
            downCorner.add("W");
            downEdge.add("I");
            downEdge.add("O");
            downEdge.add("M");
            downEdge.add("K");
            downEdge.add(SpKey.DOWN);

            leftCorner.add("C");
            leftCorner.add("M");
            leftCorner.add("Q");
            leftCorner.add("E");
            leftEdge.add("D");
            leftEdge.add("T");
            leftEdge.add("L");
            leftEdge.add("X");
            leftEdge.add(SpKey.LEFT);

            rightCorner.add("I");
            rightCorner.add("S");
            rightCorner.add("Z");
            rightCorner.add("K");
            rightEdge.add("H");
            rightEdge.add("Z");
            rightEdge.add("P");
            rightEdge.add("R");
            rightEdge.add(SpKey.RIGHT);

            frontCorner.add("L");
            frontCorner.add("Y");
            frontCorner.add("N");
            frontCorner.add("B");
            frontEdge.add("B");
            frontEdge.add("Q");
            frontEdge.add("J");
            frontEdge.add("S");
            frontEdge.add(SpKey.FRONT);

            backCorner.add("F");
            backCorner.add("P");
            backCorner.add("T");
            backCorner.add("H");
            backEdge.add("F");
            backEdge.add("W");
            backEdge.add("N");
            backEdge.add("Y");
            backEdge.add(SpKey.BACK);

        }else{

            for(int i=0;i<4;i++){
                upCorner.add(UP_CORNER.substring(i,i+1));
                upEdge.add(UP_EDGE.substring(i,i+1));

                downCorner.add(DOWN_CORNER.substring(i,i+1));
                downEdge.add(DOWN_EDGE.substring(i,i+1));

                leftCorner.add(LEFT_CORNER.substring(i,i+1));
                leftEdge.add(LEFT_EDGE.substring(i,i+1));

                rightCorner.add(RIGHT_CORNER.substring(i,i+1));
                rightEdge.add(RIGHT_EDGE.substring(i,i+1));

                frontCorner.add(FRONT_CORNER.substring(i,i+1));
                frontEdge.add(FRONT_EDGE.substring(i,i+1));

                backCorner.add(BACK_CORNER.substring(i,i+1));
                backEdge.add(BACK_EDGE.substring(i,i+1));

            }

            upEdge.add(SpKey.UP);
            downEdge.add(SpKey.DOWN);
            leftEdge.add(SpKey.LEFT);
            rightEdge.add(SpKey.RIGHT);
            frontEdge.add(SpKey.FRONT);
            backEdge.add(SpKey.BACK);
        }

        codes.add(new CubeCode(CubeDirection.UP, upCorner, upEdge));
        codes.add(new CubeCode(CubeDirection.DOWN, downCorner, downEdge));
        codes.add(new CubeCode(CubeDirection.LEFT, leftCorner, leftEdge));
        codes.add(new CubeCode(CubeDirection.RIGHT, rightCorner, rightEdge));
        codes.add(new CubeCode(CubeDirection.FRONT, frontCorner, frontEdge));
        codes.add(new CubeCode(CubeDirection.BACK, backCorner, backEdge));


        return codes;
    }

    /**
     * 获取坐标对应颜色
     * @return
     */
    public static List<DyeCubeBean> getCoordinate(){
        String str = SPUtils.getInstance().getString(SpKey.COORDINATE);
        List<DyeCubeBean> list = new ArrayList<>();
        if (TextUtils.isEmpty(str)) {
            //没有定义过，默认 黄顶红前
            list.add(new DyeCubeBean(CubeDirection.UP,CubeColor.YELLOW));
            list.add(new DyeCubeBean(CubeDirection.DOWN,CubeColor.WIHTE));
            list.add(new DyeCubeBean(CubeDirection.LEFT,CubeColor.BLUE));
            list.add(new DyeCubeBean(CubeDirection.RIGHT,CubeColor.GREEN));
            list.add(new DyeCubeBean(CubeDirection.FRONT,CubeColor.RED));
            list.add(new DyeCubeBean(CubeDirection.BACK,CubeColor.ORANGE));
            return list;
        }
        switch (str) {
            case "13": //13 代表黄顶蓝前
                list.add(new DyeCubeBean(CubeDirection.UP, CubeColor.YELLOW));
                list.add(new DyeCubeBean(CubeDirection.DOWN, CubeColor.WIHTE));
                list.add(new DyeCubeBean(CubeDirection.LEFT, CubeColor.ORANGE));
                list.add(new DyeCubeBean(CubeDirection.RIGHT, CubeColor.RED));
                list.add(new DyeCubeBean(CubeDirection.FRONT, CubeColor.BLUE));
                list.add(new DyeCubeBean(CubeDirection.BACK, CubeColor.GREEN));
                break;
            case "14"://14 代表黄顶绿前
                list.add(new DyeCubeBean(CubeDirection.UP, CubeColor.YELLOW));
                list.add(new DyeCubeBean(CubeDirection.DOWN, CubeColor.WIHTE));
                list.add(new DyeCubeBean(CubeDirection.LEFT, CubeColor.RED));
                list.add(new DyeCubeBean(CubeDirection.RIGHT, CubeColor.ORANGE));
                list.add(new DyeCubeBean(CubeDirection.FRONT, CubeColor.GREEN));
                list.add(new DyeCubeBean(CubeDirection.BACK, CubeColor.BLUE));
                break;
            case "15"://15 代表黄顶红前
                list.add(new DyeCubeBean(CubeDirection.UP,CubeColor.YELLOW));
                list.add(new DyeCubeBean(CubeDirection.DOWN,CubeColor.WIHTE));
                list.add(new DyeCubeBean(CubeDirection.LEFT,CubeColor.BLUE));
                list.add(new DyeCubeBean(CubeDirection.RIGHT,CubeColor.GREEN));
                list.add(new DyeCubeBean(CubeDirection.FRONT,CubeColor.RED));
                list.add(new DyeCubeBean(CubeDirection.BACK,CubeColor.ORANGE));
                break;
            case "16"://16 代表黄顶橙前
                list.add(new DyeCubeBean(CubeDirection.UP, CubeColor.YELLOW));
                list.add(new DyeCubeBean(CubeDirection.DOWN, CubeColor.WIHTE));
                list.add(new DyeCubeBean(CubeDirection.LEFT, CubeColor.GREEN));
                list.add(new DyeCubeBean(CubeDirection.RIGHT, CubeColor.BLUE));
                list.add(new DyeCubeBean(CubeDirection.FRONT, CubeColor.ORANGE));
                list.add(new DyeCubeBean(CubeDirection.BACK, CubeColor.RED));
                break;
            case "23"://23 代表白顶蓝前
                list.add(new DyeCubeBean(CubeDirection.UP, CubeColor.WIHTE));
                list.add(new DyeCubeBean(CubeDirection.DOWN, CubeColor.YELLOW));
                list.add(new DyeCubeBean(CubeDirection.LEFT, CubeColor.RED));
                list.add(new DyeCubeBean(CubeDirection.RIGHT, CubeColor.ORANGE));
                list.add(new DyeCubeBean(CubeDirection.FRONT, CubeColor.BLUE));
                list.add(new DyeCubeBean(CubeDirection.BACK, CubeColor.GREEN));
                break;
            case "24"://24 代表白顶绿前
                list.add(new DyeCubeBean(CubeDirection.UP, CubeColor.WIHTE));
                list.add(new DyeCubeBean(CubeDirection.DOWN, CubeColor.YELLOW));
                list.add(new DyeCubeBean(CubeDirection.LEFT, CubeColor.ORANGE));
                list.add(new DyeCubeBean(CubeDirection.RIGHT, CubeColor.RED));
                list.add(new DyeCubeBean(CubeDirection.FRONT, CubeColor.GREEN));
                list.add(new DyeCubeBean(CubeDirection.BACK, CubeColor.BLUE));
                break;
            case "25": //25 代表白顶红前
                list.add(new DyeCubeBean(CubeDirection.UP, CubeColor.WIHTE));
                list.add(new DyeCubeBean(CubeDirection.DOWN, CubeColor.YELLOW));
                list.add(new DyeCubeBean(CubeDirection.LEFT, CubeColor.GREEN));
                list.add(new DyeCubeBean(CubeDirection.RIGHT, CubeColor.BLUE));
                list.add(new DyeCubeBean(CubeDirection.FRONT, CubeColor.RED));
                list.add(new DyeCubeBean(CubeDirection.BACK, CubeColor.ORANGE));
                break;
            case "26": //26 代表白顶橙前
                list.add(new DyeCubeBean(CubeDirection.UP, CubeColor.WIHTE));
                list.add(new DyeCubeBean(CubeDirection.DOWN, CubeColor.YELLOW));
                list.add(new DyeCubeBean(CubeDirection.LEFT, CubeColor.BLUE));
                list.add(new DyeCubeBean(CubeDirection.RIGHT, CubeColor.GREEN));
                list.add(new DyeCubeBean(CubeDirection.FRONT, CubeColor.ORANGE));
                list.add(new DyeCubeBean(CubeDirection.BACK, CubeColor.RED));
                break;
            case "35"://35 代表蓝顶红前
                list.add(new DyeCubeBean(CubeDirection.UP, CubeColor.BLUE));
                list.add(new DyeCubeBean(CubeDirection.DOWN, CubeColor.GREEN));
                list.add(new DyeCubeBean(CubeDirection.LEFT, CubeColor.WIHTE));
                list.add(new DyeCubeBean(CubeDirection.RIGHT, CubeColor.YELLOW));
                list.add(new DyeCubeBean(CubeDirection.FRONT, CubeColor.RED));
                list.add(new DyeCubeBean(CubeDirection.BACK, CubeColor.ORANGE));
                break;
            case "36"://代表蓝顶橙前
                list.add(new DyeCubeBean(CubeDirection.UP, CubeColor.BLUE));
                list.add(new DyeCubeBean(CubeDirection.DOWN, CubeColor.GREEN));
                list.add(new DyeCubeBean(CubeDirection.LEFT, CubeColor.YELLOW));
                list.add(new DyeCubeBean(CubeDirection.RIGHT, CubeColor.WIHTE));
                list.add(new DyeCubeBean(CubeDirection.FRONT, CubeColor.ORANGE));
                list.add(new DyeCubeBean(CubeDirection.BACK, CubeColor.RED));
                break;
            case "31"://代表蓝顶黄前
                list.add(new DyeCubeBean(CubeDirection.UP, CubeColor.BLUE));
                list.add(new DyeCubeBean(CubeDirection.DOWN, CubeColor.GREEN));
                list.add(new DyeCubeBean(CubeDirection.LEFT, CubeColor.RED));
                list.add(new DyeCubeBean(CubeDirection.RIGHT, CubeColor.ORANGE));
                list.add(new DyeCubeBean(CubeDirection.FRONT, CubeColor.YELLOW));
                list.add(new DyeCubeBean(CubeDirection.BACK, CubeColor.WIHTE));
                break;
            case "32"://代表蓝顶白前
                list.add(new DyeCubeBean(CubeDirection.UP, CubeColor.BLUE));
                list.add(new DyeCubeBean(CubeDirection.DOWN, CubeColor.GREEN));
                list.add(new DyeCubeBean(CubeDirection.LEFT, CubeColor.ORANGE));
                list.add(new DyeCubeBean(CubeDirection.RIGHT, CubeColor.RED));
                list.add(new DyeCubeBean(CubeDirection.FRONT, CubeColor.WIHTE));
                list.add(new DyeCubeBean(CubeDirection.BACK, CubeColor.YELLOW));
                break;
            case "45"://45 代表绿顶红前
                list.add(new DyeCubeBean(CubeDirection.UP, CubeColor.GREEN));
                list.add(new DyeCubeBean(CubeDirection.DOWN, CubeColor.BLUE));
                list.add(new DyeCubeBean(CubeDirection.LEFT, CubeColor.YELLOW));
                list.add(new DyeCubeBean(CubeDirection.RIGHT, CubeColor.WIHTE));
                list.add(new DyeCubeBean(CubeDirection.FRONT, CubeColor.RED));
                list.add(new DyeCubeBean(CubeDirection.BACK, CubeColor.ORANGE));
                break;
            case "46"://46 代表绿顶橙前
                list.add(new DyeCubeBean(CubeDirection.UP, CubeColor.GREEN));
                list.add(new DyeCubeBean(CubeDirection.DOWN, CubeColor.BLUE));
                list.add(new DyeCubeBean(CubeDirection.LEFT, CubeColor.WIHTE));
                list.add(new DyeCubeBean(CubeDirection.RIGHT, CubeColor.YELLOW));
                list.add(new DyeCubeBean(CubeDirection.FRONT, CubeColor.ORANGE));
                list.add(new DyeCubeBean(CubeDirection.BACK, CubeColor.RED));
                break;
            case "41"://41 代表绿顶黄前
                list.add(new DyeCubeBean(CubeDirection.UP, CubeColor.GREEN));
                list.add(new DyeCubeBean(CubeDirection.DOWN, CubeColor.BLUE));
                list.add(new DyeCubeBean(CubeDirection.LEFT, CubeColor.ORANGE));
                list.add(new DyeCubeBean(CubeDirection.RIGHT, CubeColor.RED));
                list.add(new DyeCubeBean(CubeDirection.FRONT, CubeColor.YELLOW));
                list.add(new DyeCubeBean(CubeDirection.BACK, CubeColor.WIHTE));
                break;
            case "42"://42 代表绿顶白前
                list.add(new DyeCubeBean(CubeDirection.UP, CubeColor.GREEN));
                list.add(new DyeCubeBean(CubeDirection.DOWN, CubeColor.BLUE));
                list.add(new DyeCubeBean(CubeDirection.LEFT, CubeColor.RED));
                list.add(new DyeCubeBean(CubeDirection.RIGHT, CubeColor.ORANGE));
                list.add(new DyeCubeBean(CubeDirection.FRONT, CubeColor.WIHTE));
                list.add(new DyeCubeBean(CubeDirection.BACK, CubeColor.YELLOW));
                break;
            case "51"://51 代表红顶黄前
                list.add(new DyeCubeBean(CubeDirection.UP, CubeColor.RED));
                list.add(new DyeCubeBean(CubeDirection.DOWN, CubeColor.ORANGE));
                list.add(new DyeCubeBean(CubeDirection.LEFT, CubeColor.GREEN));
                list.add(new DyeCubeBean(CubeDirection.RIGHT, CubeColor.BLUE));
                list.add(new DyeCubeBean(CubeDirection.FRONT, CubeColor.YELLOW));
                list.add(new DyeCubeBean(CubeDirection.BACK, CubeColor.WIHTE));
                break;
            case "52"://52 代表红顶白前
                list.add(new DyeCubeBean(CubeDirection.UP, CubeColor.RED));
                list.add(new DyeCubeBean(CubeDirection.DOWN, CubeColor.ORANGE));
                list.add(new DyeCubeBean(CubeDirection.LEFT, CubeColor.BLUE));
                list.add(new DyeCubeBean(CubeDirection.RIGHT, CubeColor.GREEN));
                list.add(new DyeCubeBean(CubeDirection.FRONT, CubeColor.WIHTE));
                list.add(new DyeCubeBean(CubeDirection.BACK, CubeColor.YELLOW));
                break;
            case "53"://53 代表红顶蓝前
                list.add(new DyeCubeBean(CubeDirection.UP, CubeColor.RED));
                list.add(new DyeCubeBean(CubeDirection.DOWN, CubeColor.ORANGE));
                list.add(new DyeCubeBean(CubeDirection.LEFT, CubeColor.YELLOW));
                list.add(new DyeCubeBean(CubeDirection.RIGHT, CubeColor.WIHTE));
                list.add(new DyeCubeBean(CubeDirection.FRONT, CubeColor.BLUE));
                list.add(new DyeCubeBean(CubeDirection.BACK, CubeColor.GREEN));
                break;
            case "54"://54 代表红顶绿前
                list.add(new DyeCubeBean(CubeDirection.UP, CubeColor.RED));
                list.add(new DyeCubeBean(CubeDirection.DOWN, CubeColor.ORANGE));
                list.add(new DyeCubeBean(CubeDirection.LEFT, CubeColor.WIHTE));
                list.add(new DyeCubeBean(CubeDirection.RIGHT, CubeColor.YELLOW));
                list.add(new DyeCubeBean(CubeDirection.FRONT, CubeColor.GREEN));
                list.add(new DyeCubeBean(CubeDirection.BACK, CubeColor.BLUE));
                break;
            case "61"://61 代表橙顶黄前
                list.add(new DyeCubeBean(CubeDirection.UP, CubeColor.ORANGE));
                list.add(new DyeCubeBean(CubeDirection.DOWN, CubeColor.RED));
                list.add(new DyeCubeBean(CubeDirection.LEFT, CubeColor.BLUE));
                list.add(new DyeCubeBean(CubeDirection.RIGHT, CubeColor.GREEN));
                list.add(new DyeCubeBean(CubeDirection.FRONT, CubeColor.YELLOW));
                list.add(new DyeCubeBean(CubeDirection.BACK, CubeColor.WIHTE));
                break;
            case "62"://62 代表橙顶白前
                list.add(new DyeCubeBean(CubeDirection.UP, CubeColor.ORANGE));
                list.add(new DyeCubeBean(CubeDirection.DOWN, CubeColor.RED));
                list.add(new DyeCubeBean(CubeDirection.LEFT, CubeColor.GREEN));
                list.add(new DyeCubeBean(CubeDirection.RIGHT, CubeColor.BLUE));
                list.add(new DyeCubeBean(CubeDirection.FRONT, CubeColor.WIHTE));
                list.add(new DyeCubeBean(CubeDirection.BACK, CubeColor.YELLOW));
                break;
            case "63"://代表橙顶蓝前
                list.add(new DyeCubeBean(CubeDirection.UP, CubeColor.ORANGE));
                list.add(new DyeCubeBean(CubeDirection.DOWN, CubeColor.RED));
                list.add(new DyeCubeBean(CubeDirection.LEFT, CubeColor.WIHTE));
                list.add(new DyeCubeBean(CubeDirection.RIGHT, CubeColor.YELLOW));
                list.add(new DyeCubeBean(CubeDirection.FRONT, CubeColor.BLUE));
                list.add(new DyeCubeBean(CubeDirection.BACK, CubeColor.GREEN));
                break;
            case "64"://64 代表橙顶绿前
                list.add(new DyeCubeBean(CubeDirection.UP, CubeColor.ORANGE));
                list.add(new DyeCubeBean(CubeDirection.DOWN, CubeColor.RED));
                list.add(new DyeCubeBean(CubeDirection.LEFT, CubeColor.YELLOW));
                list.add(new DyeCubeBean(CubeDirection.RIGHT, CubeColor.WIHTE));
                list.add(new DyeCubeBean(CubeDirection.FRONT, CubeColor.GREEN));
                list.add(new DyeCubeBean(CubeDirection.BACK, CubeColor.BLUE));
                break;

        }

        return list;
    }

    /**
     * 根据sp值 获取显示的值  （借位顺序）
     * @param cornerOrEdge
     * @param str
     * @return
     */
    public static String getDisPlayCode(CornerOrEdge cornerOrEdge, String str,Cube cube) {

        switch (cornerOrEdge) {
            case CORNER:
                switch (str) {
                    case "0":
                        return cube.getUpCornerSource().get(0);
                    case "1":
                        return cube.getUpCornerSource().get(1);
                    case "2":
                        return cube.getUpCornerSource().get(2);
                    case "3":
                        return cube.getUpCornerSource().get(3);
                    case "4":
                        return cube.getDownCornerSource().get(0);
                    case "5":
                        return cube.getDownCornerSource().get(1);
                    case "6":
                        return cube.getDownCornerSource().get(2);
                    case "7":
                        return cube.getDownCornerSource().get(3);
                }
                break;
            case EDGE:
                switch (str) {
                    case "0":
                        return cube.getUpEdgeSource().get(0);
                    case "1":
                        return cube.getUpEdgeSource().get(1);
                    case "2":
                        return cube.getUpEdgeSource().get(2);
                    case "3":
                        return cube.getUpEdgeSource().get(3);
                    case "4":
                        return cube.getFrontEdgeSource().get(1);
                    case "5":
                        return cube.getFrontEdgeSource().get(3);
                    case "6":
                        return cube.getBackEdgeSource().get(1);
                    case "7":
                        return cube.getBackEdgeSource().get(3);
                    case "8":
                        return cube.getDownEdgeSource().get(0);
                    case "9":
                        return cube.getDownEdgeSource().get(3);
                    case "A":
                        return cube.getDownEdgeSource().get(2);
                    case "B":
                        return cube.getDownEdgeSource().get(1);
                }
                break;
        }
        return "";
    }

    public static List<CoordinateKeyValue> coordinateKeyValues;

    /**
     * 初始化打乱坐标
     */
    public static void initCoordinateValues() {
        coordinateKeyValues = new ArrayList<>();
        coordinateKeyValues.add(new CoordinateKeyValue("Uw' y", "Uw"));
        coordinateKeyValues.add(new CoordinateKeyValue("Uw y'", "Uw'"));
        coordinateKeyValues.add(new CoordinateKeyValue("Uw2 y2'", "Uw2"));

        coordinateKeyValues.add(new CoordinateKeyValue("Rw' x", "Rw"));
        coordinateKeyValues.add(new CoordinateKeyValue("Rw x'", "Rw'"));
        coordinateKeyValues.add(new CoordinateKeyValue("Rw2 x2'", "Rw2"));

        coordinateKeyValues.add(new CoordinateKeyValue("Fw' z", "Fw"));
        coordinateKeyValues.add(new CoordinateKeyValue("Fw z'", "Fw'"));

        coordinateKeyValues.add(new CoordinateKeyValue("Fw z' Rw' x", "Rw Uw'"));
        coordinateKeyValues.add(new CoordinateKeyValue("Fw' z Rw' x", "Rw Uw"));
        coordinateKeyValues.add(new CoordinateKeyValue("Fw2 z2 Rw' x", "Rw Uw2"));

        coordinateKeyValues.add(new CoordinateKeyValue("Bw z Rw x'", "Rw' Uw'"));
        coordinateKeyValues.add(new CoordinateKeyValue("Bw' z' Rw x'", "Rw' Uw"));
        coordinateKeyValues.add(new CoordinateKeyValue("Bw2 z2 Rw x'", "Rw' Uw2"));
        coordinateKeyValues.add(new CoordinateKeyValue("Dw2 y2 Rw2 x2", "Rw2 Uw2"));

        coordinateKeyValues.add(new CoordinateKeyValue("Lw' x'  Fw' z", "Fw Uw"));
        coordinateKeyValues.add(new CoordinateKeyValue("Lw x  Fw' z", "Fw Uw'"));
        coordinateKeyValues.add(new CoordinateKeyValue("Lw2 x2  Fw' z", "Fw Uw2"));

        coordinateKeyValues.add(new CoordinateKeyValue("Rw' x Fw z'", "Fw' Uw"));
        coordinateKeyValues.add(new CoordinateKeyValue("Rw x' Fw z'", "Fw' Uw'"));
        coordinateKeyValues.add(new CoordinateKeyValue("Rw2 x2 Fw z'", "Fw' Uw2"));
    }


    /**
     * 获取借位顺序 0角  1棱
     * @return
     */
    public static List<SortCode>[] getSortCode(){
        String cornerSort = SPUtils.getInstance().getString(SpKey.SORT_CORNER_JIE);
        String edgeSort = SPUtils.getInstance().getString(SpKey.SORT_EDGE_JIE);
        List<SortCode> list = new ArrayList<>();
        List<SortCode> edgeList = new ArrayList<>();
        Cube cube = new Cube();
        cube.init();
        if (TextUtils.isEmpty(cornerSort)) {
            //没有设置过借位顺序
            cornerSort = SpKey.CORNER_JIE_SORT;
            edgeSort = SpKey.EDGE_JIE_SORT;
            SPUtils.getInstance().put(SpKey.SORT_CORNER_JIE,cornerSort);
            SPUtils.getInstance().put(SpKey.SORT_EDGE_JIE,edgeSort);
        }

        for(int i = 0;i<cornerSort.length();i++){
            String cornerKey = cornerSort.substring(i,i+1);
            String display = CoordinateUtil.getDisPlayCode(CornerOrEdge.CORNER, cornerKey,cube);
            list.add(new SortCode(display,cornerKey));
        }

        for(int i = 0;i<edgeSort.length();i++){
            String edgeKey = edgeSort.substring(i,i+1);
            String display = CoordinateUtil.getDisPlayCode(CornerOrEdge.EDGE, edgeKey,cube);
            edgeList.add(new SortCode(display,edgeKey));
        }

        String cornerBufferStr = SPUtils.getInstance().getString(SpKey.CORNER_BUFFER);
        String edgeBufferStr = SPUtils.getInstance().getString(SpKey.EDGE_BUFFER);
        int cornerIndex=0;
        int edgeIndex = 0;
        if(TextUtils.isEmpty(cornerBufferStr)){
            cornerIndex = 1;
        }else{
            cornerIndex = Integer.parseInt(cornerBufferStr);
        }

        if (TextUtils.isEmpty(edgeBufferStr)) {
            edgeIndex = 2;
        }else {
            edgeIndex = Integer.parseInt(edgeBufferStr);
        }

        List<String> cornerBufferList = cube.getBufferList(CornerOrEdge.CORNER, cornerIndex);
        List<String> edgeBufferList = cube.getBufferList(CornerOrEdge.EDGE, edgeIndex);
        for (String s : cornerBufferList) {
            for (SortCode sc : list) {
                if (sc.getDisplay().equals(s)) {
                    list.remove(sc);
                    break;
                }
            }
        }

        for (String s : edgeBufferList) {
            for (SortCode sc : edgeList) {
                if (sc.getDisplay().equals(s)) {
                    edgeList.remove(sc);
                    break;
                }
            }
        }

        return new List[]{list,edgeList};
    }



}
