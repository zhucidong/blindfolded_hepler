package zd.cornermemory.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import zd.cornermemory.bean.CornerOrEdge;
import zd.cornermemory.bean.Probability;

/**
 * Created by zhud on 2019/10/9.
 * 概率工具类
 */

public class ProbabilityUtil {
    static List<Probability> cornerProbabilities;
    static List<Probability> edgeProbabilities;

    public static void init(){
        cornerProbabilities = new ArrayList<>();
        //无小循环的 概率
        cornerProbabilities.add(new Probability(false,true,0,new int[]{0},0,7));//纯翻色
        cornerProbabilities.add(new Probability(false,true,0,new int[]{0},0,6));//纯翻色
        cornerProbabilities.add(new Probability(false,true,0,new int[]{0},0,5));//纯翻色
        cornerProbabilities.add(new Probability(false,true,0,new int[]{0},0,4));//纯翻色
        cornerProbabilities.add(new Probability(false,true,0,new int[]{0},0,3));//纯翻色
        cornerProbabilities.add(new Probability(false,true,0,new int[]{0},0,2));//纯翻色
        cornerProbabilities.add(new Probability(false,true,0,new int[]{0},0,1));//纯翻色
        cornerProbabilities.add(new Probability(false,false,0,new int[]{3},2,5));
        cornerProbabilities.add(new Probability(false,false,0,new int[]{3},2,4));
        cornerProbabilities.add(new Probability(false,false,0,new int[]{3},2,3));
        cornerProbabilities.add(new Probability(false,false,0,new int[]{3},2,2));
        cornerProbabilities.add(new Probability(false,false,0,new int[]{3},2,1));
        cornerProbabilities.add(new Probability(false,false,0,new int[]{3},2,0));
        cornerProbabilities.add(new Probability(false,false,0,new int[]{5},4,3));
        cornerProbabilities.add(new Probability(false,false,0,new int[]{5},4,2));
        cornerProbabilities.add(new Probability(false,false,0,new int[]{5},4,1));
        cornerProbabilities.add(new Probability(false,false,0,new int[]{5},4,0));
        cornerProbabilities.add(new Probability(false,false,0,new int[]{7},6,1));
        cornerProbabilities.add(new Probability(false,false,0,new int[]{7},6,0));

        cornerProbabilities.add(new Probability(true,false,0,new int[]{2},1,6));
        cornerProbabilities.add(new Probability(true,false,0,new int[]{2},1,5));
        cornerProbabilities.add(new Probability(true,false,0,new int[]{2},1,4));
        cornerProbabilities.add(new Probability(true,false,0,new int[]{2},1,3));
        cornerProbabilities.add(new Probability(true,false,0,new int[]{2},1,2));
        cornerProbabilities.add(new Probability(true,false,0,new int[]{2},1,1));
        cornerProbabilities.add(new Probability(true,false,0,new int[]{2},1,0));

        cornerProbabilities.add(new Probability(true,false,0,new int[]{4},3,4));
        cornerProbabilities.add(new Probability(true,false,0,new int[]{4},3,3));
        cornerProbabilities.add(new Probability(true,false,0,new int[]{4},3,2));
        cornerProbabilities.add(new Probability(true,false,0,new int[]{4},3,1));
        cornerProbabilities.add(new Probability(true,false,0,new int[]{4},3,0));

        cornerProbabilities.add(new Probability(true,false,0,new int[]{6},5,2));
        cornerProbabilities.add(new Probability(true,false,0,new int[]{6},5,1));
        cornerProbabilities.add(new Probability(true,false,0,new int[]{6},5,0));

        cornerProbabilities.add(new Probability(true,false,0,new int[]{8},7,0));



        //1个小循环
        cornerProbabilities.add(new Probability(false,false,1,new int[]{2,2},4,4));
        cornerProbabilities.add(new Probability(false,false,1,new int[]{2,2},4,3));
        cornerProbabilities.add(new Probability(false,false,1,new int[]{2,2},4,2));
        cornerProbabilities.add(new Probability(false,false,1,new int[]{2,2},4,1));
        cornerProbabilities.add(new Probability(false,false,1,new int[]{2,2},4,0));
        cornerProbabilities.add(new Probability(false,false,1,new int[]{2,2},4,4));
        cornerProbabilities.add(new Probability(false,false,1,new int[]{2,2},4,3));
        cornerProbabilities.add(new Probability(false,false,1,new int[]{2,2},4,2));
        cornerProbabilities.add(new Probability(false,false,1,new int[]{2,2},4,1));
        cornerProbabilities.add(new Probability(false,false,1,new int[]{2,2},4,0));
        cornerProbabilities.add(new Probability(false,false,1,new int[]{3,3},6,2));
        cornerProbabilities.add(new Probability(false,false,1,new int[]{3,3},6,1));
        cornerProbabilities.add(new Probability(false,false,1,new int[]{3,3},6,0));
        cornerProbabilities.add(new Probability(false,false,1,new int[]{3,3},6,2));
        cornerProbabilities.add(new Probability(false,false,1,new int[]{3,3},6,1));
        cornerProbabilities.add(new Probability(false,false,1,new int[]{3,3},6,0));

        cornerProbabilities.add(new Probability(true,false,1,new int[]{2,3},5,3));
        cornerProbabilities.add(new Probability(true,false,1,new int[]{2,3},5,2));
        cornerProbabilities.add(new Probability(true,false,1,new int[]{2,3},5,1));
        cornerProbabilities.add(new Probability(true,false,1,new int[]{2,3},5,0));
        cornerProbabilities.add(new Probability(true,false,1,new int[]{3,2},5,3));
        cornerProbabilities.add(new Probability(true,false,1,new int[]{3,2},5,2));
        cornerProbabilities.add(new Probability(true,false,1,new int[]{3,2},5,1));
        cornerProbabilities.add(new Probability(true,false,1,new int[]{3,2},5,0));
        cornerProbabilities.add(new Probability(true,false,1,new int[]{2,5},7,1));
        cornerProbabilities.add(new Probability(true,false,1,new int[]{2,5},7,0));
        cornerProbabilities.add(new Probability(true,false,1,new int[]{5,2},7,1));
        cornerProbabilities.add(new Probability(true,false,1,new int[]{5,2},7,0));
        cornerProbabilities.add(new Probability(true,false,1,new int[]{3,4},7,1));
        cornerProbabilities.add(new Probability(true,false,1,new int[]{3,4},7,0));
        cornerProbabilities.add(new Probability(true,false,1,new int[]{4,3},7,1));
        cornerProbabilities.add(new Probability(true,false,1,new int[]{4,3},7,0));



        cornerProbabilities.add(new Probability(false,true,1,new int[]{1,3},4,4));
        cornerProbabilities.add(new Probability(false,true,1,new int[]{1,3},4,3));
        cornerProbabilities.add(new Probability(false,true,1,new int[]{1,3},4,2));
        cornerProbabilities.add(new Probability(false,true,1,new int[]{1,3},4,1));
        cornerProbabilities.add(new Probability(false,true,1,new int[]{1,3},4,0));
        cornerProbabilities.add(new Probability(false,true,1,new int[]{1,5},6,2));
        cornerProbabilities.add(new Probability(false,true,1,new int[]{1,5},6,1));
        cornerProbabilities.add(new Probability(false,true,1,new int[]{1,5},6,0));
        cornerProbabilities.add(new Probability(false,true,1,new int[]{1,7},8,0));

        cornerProbabilities.add(new Probability(true,true,1,new int[]{1,2},5,5));
        cornerProbabilities.add(new Probability(true,true,1,new int[]{1,2},5,4));
        cornerProbabilities.add(new Probability(true,true,1,new int[]{1,2},5,3));
        cornerProbabilities.add(new Probability(true,true,1,new int[]{1,2},5,2));
        cornerProbabilities.add(new Probability(true,true,1,new int[]{1,2},5,1));
        cornerProbabilities.add(new Probability(true,true,1,new int[]{1,2},5,0));
        cornerProbabilities.add(new Probability(true,true,1,new int[]{1,4},5,3));
        cornerProbabilities.add(new Probability(true,true,1,new int[]{1,4},5,2));
        cornerProbabilities.add(new Probability(true,true,1,new int[]{1,4},5,1));
        cornerProbabilities.add(new Probability(true,true,1,new int[]{1,4},5,0));
        cornerProbabilities.add(new Probability(true,true,1,new int[]{1,6},5,1));
        cornerProbabilities.add(new Probability(true,true,1,new int[]{1,6},5,0));


        //2个小循环
        cornerProbabilities.add(new Probability(false,false,2,new int[]{2,2,3},8,1));
        cornerProbabilities.add(new Probability(false,false,2,new int[]{2,2,3},8,0));
        cornerProbabilities.add(new Probability(false,false,2,new int[]{2,3,2},8,1));
        cornerProbabilities.add(new Probability(false,false,2,new int[]{2,3,2},8,0));
        cornerProbabilities.add(new Probability(false,false,2,new int[]{3,2,2},8,1));
        cornerProbabilities.add(new Probability(false,false,2,new int[]{3,2,2},8,1));
        cornerProbabilities.add(new Probability(false,false,2,new int[]{3,2,2},8,0));

        cornerProbabilities.add(new Probability(true,false,2,new int[]{2,2,4},9,0));
        cornerProbabilities.add(new Probability(true,false,2,new int[]{2,4,2},9,0));
        cornerProbabilities.add(new Probability(true,false,2,new int[]{4,2,2},9,0));

        cornerProbabilities.add(new Probability(false,true,2,new int[]{1,2,2},6,3));
        cornerProbabilities.add(new Probability(false,true,2,new int[]{1,2,2},6,2));
        cornerProbabilities.add(new Probability(false,true,2,new int[]{1,2,2},6,1));
        cornerProbabilities.add(new Probability(false,true,2,new int[]{1,2,2},6,0));
        cornerProbabilities.add(new Probability(false,true,2,new int[]{1,3,3},8,1));
        cornerProbabilities.add(new Probability(false,true,2,new int[]{1,3,3},8,0));

        cornerProbabilities.add(new Probability(true,true,2,new int[]{1,2,3},7,2));
        cornerProbabilities.add(new Probability(true,true,2,new int[]{1,2,3},7,1));
        cornerProbabilities.add(new Probability(true,true,2,new int[]{1,2,3},7,0));
        cornerProbabilities.add(new Probability(true,true,2,new int[]{1,3,2},7,2));
        cornerProbabilities.add(new Probability(true,true,2,new int[]{1,3,2},7,1));
        cornerProbabilities.add(new Probability(true,true,2,new int[]{1,3,2},7,0));

        cornerProbabilities.add(new Probability(true,true,2,new int[]{1,2,5},9,0));
        cornerProbabilities.add(new Probability(true,true,2,new int[]{1,5,2},9,0));


        //3个小循环
        cornerProbabilities.add(new Probability(false,false,3,new int[]{2,2,2,2},10,0));
        cornerProbabilities.add(new Probability(false,true,3,new int[]{1,2,2,3},10,0));
        cornerProbabilities.add(new Probability(false,true,3,new int[]{1,3,2,2},10,0));
        cornerProbabilities.add(new Probability(false,true,3,new int[]{1,2,3,2},10,0));


//--------------------------------------------edge--------------------------------------------------------


        edgeProbabilities = new ArrayList<>();

        //0个小循环
        edgeProbabilities.add(new Probability(false,true,0,new int[]{0},0,11));//纯翻色
        edgeProbabilities.add(new Probability(false,true,0,new int[]{0},0,10));//纯翻色
        edgeProbabilities.add(new Probability(false,true,0,new int[]{0},0,9));//纯翻色
        edgeProbabilities.add(new Probability(false,true,0,new int[]{0},0,8));//纯翻色
        edgeProbabilities.add(new Probability(false,true,0,new int[]{0},0,7));//纯翻色
        edgeProbabilities.add(new Probability(false,true,0,new int[]{0},0,6));//纯翻色
        edgeProbabilities.add(new Probability(false,true,0,new int[]{0},0,5));//纯翻色
        edgeProbabilities.add(new Probability(false,true,0,new int[]{0},0,4));//纯翻色
        edgeProbabilities.add(new Probability(false,true,0,new int[]{0},0,3));//纯翻色
        edgeProbabilities.add(new Probability(false,true,0,new int[]{0},0,2));//纯翻色
        edgeProbabilities.add(new Probability(false,true,0,new int[]{0},0,1));//纯翻色

        edgeProbabilities.add(new Probability(false,false,0,new int[]{3},2,9));
        edgeProbabilities.add(new Probability(false,false,0,new int[]{3},2,8));
        edgeProbabilities.add(new Probability(false,false,0,new int[]{3},2,7));
        edgeProbabilities.add(new Probability(false,false,0,new int[]{3},2,6));
        edgeProbabilities.add(new Probability(false,false,0,new int[]{3},2,5));
        edgeProbabilities.add(new Probability(false,false,0,new int[]{3},2,4));
        edgeProbabilities.add(new Probability(false,false,0,new int[]{3},2,3));
        edgeProbabilities.add(new Probability(false,false,0,new int[]{3},2,2));
        edgeProbabilities.add(new Probability(false,false,0,new int[]{3},2,1));
        edgeProbabilities.add(new Probability(false,false,0,new int[]{3},2,0));
        edgeProbabilities.add(new Probability(false,false,0,new int[]{5},4,7));
        edgeProbabilities.add(new Probability(false,false,0,new int[]{5},4,6));
        edgeProbabilities.add(new Probability(false,false,0,new int[]{5},4,5));
        edgeProbabilities.add(new Probability(false,false,0,new int[]{5},4,4));
        edgeProbabilities.add(new Probability(false,false,0,new int[]{5},4,3));
        edgeProbabilities.add(new Probability(false,false,0,new int[]{5},4,2));
        edgeProbabilities.add(new Probability(false,false,0,new int[]{5},4,1));
        edgeProbabilities.add(new Probability(false,false,0,new int[]{5},4,0));
        edgeProbabilities.add(new Probability(false,false,0,new int[]{7},6,5));
        edgeProbabilities.add(new Probability(false,false,0,new int[]{7},6,4));
        edgeProbabilities.add(new Probability(false,false,0,new int[]{7},6,3));
        edgeProbabilities.add(new Probability(false,false,0,new int[]{7},6,2));
        edgeProbabilities.add(new Probability(false,false,0,new int[]{7},6,1));
        edgeProbabilities.add(new Probability(false,false,0,new int[]{7},6,0));
        edgeProbabilities.add(new Probability(false,false,0,new int[]{9},8,3));
        edgeProbabilities.add(new Probability(false,false,0,new int[]{9},8,2));
        edgeProbabilities.add(new Probability(false,false,0,new int[]{9},8,1));
        edgeProbabilities.add(new Probability(false,false,0,new int[]{9},8,0));
        edgeProbabilities.add(new Probability(false,false,0,new int[]{11},10,1));
        edgeProbabilities.add(new Probability(false,false,0,new int[]{11},10,0));



        edgeProbabilities.add(new Probability(true,false,0,new int[]{2},1,10));
        edgeProbabilities.add(new Probability(true,false,0,new int[]{2},1,9));
        edgeProbabilities.add(new Probability(true,false,0,new int[]{2},1,8));
        edgeProbabilities.add(new Probability(true,false,0,new int[]{2},1,7));
        edgeProbabilities.add(new Probability(true,false,0,new int[]{2},1,6));
        edgeProbabilities.add(new Probability(true,false,0,new int[]{2},1,5));
        edgeProbabilities.add(new Probability(true,false,0,new int[]{2},1,4));
        edgeProbabilities.add(new Probability(true,false,0,new int[]{2},1,3));
        edgeProbabilities.add(new Probability(true,false,0,new int[]{2},1,2));
        edgeProbabilities.add(new Probability(true,false,0,new int[]{2},1,1));
        edgeProbabilities.add(new Probability(true,false,0,new int[]{2},1,0));
        edgeProbabilities.add(new Probability(true,false,0,new int[]{4},3,8));
        edgeProbabilities.add(new Probability(true,false,0,new int[]{4},3,7));
        edgeProbabilities.add(new Probability(true,false,0,new int[]{4},3,6));
        edgeProbabilities.add(new Probability(true,false,0,new int[]{4},3,5));
        edgeProbabilities.add(new Probability(true,false,0,new int[]{4},3,4));
        edgeProbabilities.add(new Probability(true,false,0,new int[]{4},3,3));
        edgeProbabilities.add(new Probability(true,false,0,new int[]{4},3,2));
        edgeProbabilities.add(new Probability(true,false,0,new int[]{4},3,1));
        edgeProbabilities.add(new Probability(true,false,0,new int[]{4},3,0));
        edgeProbabilities.add(new Probability(true,false,0,new int[]{6},5,6));
        edgeProbabilities.add(new Probability(true,false,0,new int[]{6},5,5));
        edgeProbabilities.add(new Probability(true,false,0,new int[]{6},5,4));
        edgeProbabilities.add(new Probability(true,false,0,new int[]{6},5,3));
        edgeProbabilities.add(new Probability(true,false,0,new int[]{6},5,2));
        edgeProbabilities.add(new Probability(true,false,0,new int[]{6},5,1));
        edgeProbabilities.add(new Probability(true,false,0,new int[]{6},5,0));
        edgeProbabilities.add(new Probability(true,false,0,new int[]{8},7,4));
        edgeProbabilities.add(new Probability(true,false,0,new int[]{8},7,3));
        edgeProbabilities.add(new Probability(true,false,0,new int[]{8},7,2));
        edgeProbabilities.add(new Probability(true,false,0,new int[]{8},7,1));
        edgeProbabilities.add(new Probability(true,false,0,new int[]{8},7,0));
        edgeProbabilities.add(new Probability(true,false,0,new int[]{10},9,2));
        edgeProbabilities.add(new Probability(true,false,0,new int[]{10},9,1));
        edgeProbabilities.add(new Probability(true,false,0,new int[]{10},9,0));
        edgeProbabilities.add(new Probability(true,false,0,new int[]{12},11,0));


        //1个小循环
        edgeProbabilities.add(new Probability(false,false,1,new int[]{2,2},4,8));
        edgeProbabilities.add(new Probability(false,false,1,new int[]{2,2},4,7));
        edgeProbabilities.add(new Probability(false,false,1,new int[]{2,2},4,6));
        edgeProbabilities.add(new Probability(false,false,1,new int[]{2,2},4,5));
        edgeProbabilities.add(new Probability(false,false,1,new int[]{2,2},4,4));
        edgeProbabilities.add(new Probability(false,false,1,new int[]{2,2},4,3));
        edgeProbabilities.add(new Probability(false,false,1,new int[]{2,2},4,2));
        edgeProbabilities.add(new Probability(false,false,1,new int[]{2,2},4,1));
        edgeProbabilities.add(new Probability(false,false,1,new int[]{2,2},4,0));
        edgeProbabilities.add(new Probability(false,false,1,new int[]{2,2},4,8));
        edgeProbabilities.add(new Probability(false,false,1,new int[]{2,2},4,7));
        edgeProbabilities.add(new Probability(false,false,1,new int[]{2,2},4,6));
        edgeProbabilities.add(new Probability(false,false,1,new int[]{2,2},4,5));
        edgeProbabilities.add(new Probability(false,false,1,new int[]{2,2},4,4));
        edgeProbabilities.add(new Probability(false,false,1,new int[]{2,2},4,3));
        edgeProbabilities.add(new Probability(false,false,1,new int[]{2,2},4,2));
        edgeProbabilities.add(new Probability(false,false,1,new int[]{2,2},4,1));
        edgeProbabilities.add(new Probability(false,false,1,new int[]{2,2},4,0));
        edgeProbabilities.add(new Probability(false,false,1,new int[]{3,3},6,6));
        edgeProbabilities.add(new Probability(false,false,1,new int[]{3,3},6,5));
        edgeProbabilities.add(new Probability(false,false,1,new int[]{3,3},6,4));
        edgeProbabilities.add(new Probability(false,false,1,new int[]{3,3},6,3));
        edgeProbabilities.add(new Probability(false,false,1,new int[]{3,3},6,2));
        edgeProbabilities.add(new Probability(false,false,1,new int[]{3,3},6,1));
        edgeProbabilities.add(new Probability(false,false,1,new int[]{3,3},6,0));
        edgeProbabilities.add(new Probability(false,false,1,new int[]{3,3},6,6));
        edgeProbabilities.add(new Probability(false,false,1,new int[]{3,3},6,5));
        edgeProbabilities.add(new Probability(false,false,1,new int[]{3,3},6,4));
        edgeProbabilities.add(new Probability(false,false,1,new int[]{3,3},6,3));
        edgeProbabilities.add(new Probability(false,false,1,new int[]{3,3},6,2));
        edgeProbabilities.add(new Probability(false,false,1,new int[]{3,3},6,1));
        edgeProbabilities.add(new Probability(false,false,1,new int[]{3,3},6,0));
        edgeProbabilities.add(new Probability(false,false,1,new int[]{3,5},8,4));
        edgeProbabilities.add(new Probability(false,false,1,new int[]{3,5},8,3));
        edgeProbabilities.add(new Probability(false,false,1,new int[]{3,5},8,2));
        edgeProbabilities.add(new Probability(false,false,1,new int[]{3,5},8,1));
        edgeProbabilities.add(new Probability(false,false,1,new int[]{3,5},8,0));
        edgeProbabilities.add(new Probability(false,false,1,new int[]{5,3},8,4));
        edgeProbabilities.add(new Probability(false,false,1,new int[]{5,3},8,3));
        edgeProbabilities.add(new Probability(false,false,1,new int[]{5,3},8,2));
        edgeProbabilities.add(new Probability(false,false,1,new int[]{5,3},8,1));
        edgeProbabilities.add(new Probability(false,false,1,new int[]{5,3},8,0));
        edgeProbabilities.add(new Probability(false,false,1,new int[]{3,7},10,2));
        edgeProbabilities.add(new Probability(false,false,1,new int[]{3,7},10,1));
        edgeProbabilities.add(new Probability(false,false,1,new int[]{3,7},10,0));
        edgeProbabilities.add(new Probability(false,false,1,new int[]{7,3},10,2));
        edgeProbabilities.add(new Probability(false,false,1,new int[]{7,3},10,1));
        edgeProbabilities.add(new Probability(false,false,1,new int[]{7,3},10,0));
        edgeProbabilities.add(new Probability(false,false,1,new int[]{3,9},12,0));
        edgeProbabilities.add(new Probability(false,false,1,new int[]{9,3},12,0));

        edgeProbabilities.add(new Probability(true,false,1,new int[]{2,3},5,7));
        edgeProbabilities.add(new Probability(true,false,1,new int[]{2,3},5,6));
        edgeProbabilities.add(new Probability(true,false,1,new int[]{2,3},5,5));
        edgeProbabilities.add(new Probability(true,false,1,new int[]{2,3},5,4));
        edgeProbabilities.add(new Probability(true,false,1,new int[]{2,3},5,3));
        edgeProbabilities.add(new Probability(true,false,1,new int[]{2,3},5,2));
        edgeProbabilities.add(new Probability(true,false,1,new int[]{2,3},5,1));
        edgeProbabilities.add(new Probability(true,false,1,new int[]{2,3},5,0));
        edgeProbabilities.add(new Probability(true,false,1,new int[]{3,2},5,7));
        edgeProbabilities.add(new Probability(true,false,1,new int[]{3,2},5,6));
        edgeProbabilities.add(new Probability(true,false,1,new int[]{3,2},5,5));
        edgeProbabilities.add(new Probability(true,false,1,new int[]{3,2},5,4));
        edgeProbabilities.add(new Probability(true,false,1,new int[]{3,2},5,3));
        edgeProbabilities.add(new Probability(true,false,1,new int[]{3,2},5,2));
        edgeProbabilities.add(new Probability(true,false,1,new int[]{3,2},5,1));
        edgeProbabilities.add(new Probability(true,false,1,new int[]{3,2},5,0));
        edgeProbabilities.add(new Probability(true,false,1,new int[]{2,5},7,5));
        edgeProbabilities.add(new Probability(true,false,1,new int[]{2,5},7,4));
        edgeProbabilities.add(new Probability(true,false,1,new int[]{2,5},7,3));
        edgeProbabilities.add(new Probability(true,false,1,new int[]{2,5},7,2));
        edgeProbabilities.add(new Probability(true,false,1,new int[]{2,5},7,1));
        edgeProbabilities.add(new Probability(true,false,1,new int[]{2,5},7,0));
        edgeProbabilities.add(new Probability(true,false,1,new int[]{5,2},7,5));
        edgeProbabilities.add(new Probability(true,false,1,new int[]{5,2},7,4));
        edgeProbabilities.add(new Probability(true,false,1,new int[]{5,2},7,3));
        edgeProbabilities.add(new Probability(true,false,1,new int[]{5,2},7,2));
        edgeProbabilities.add(new Probability(true,false,1,new int[]{5,2},7,1));
        edgeProbabilities.add(new Probability(true,false,1,new int[]{5,2},7,0));
        edgeProbabilities.add(new Probability(true,false,1,new int[]{2,7},9,3));
        edgeProbabilities.add(new Probability(true,false,1,new int[]{2,7},9,2));
        edgeProbabilities.add(new Probability(true,false,1,new int[]{2,7},9,1));
        edgeProbabilities.add(new Probability(true,false,1,new int[]{2,7},9,0));
        edgeProbabilities.add(new Probability(true,false,1,new int[]{7,2},9,3));
        edgeProbabilities.add(new Probability(true,false,1,new int[]{7,2},9,2));
        edgeProbabilities.add(new Probability(true,false,1,new int[]{7,2},9,1));
        edgeProbabilities.add(new Probability(true,false,1,new int[]{7,2},9,0));
        edgeProbabilities.add(new Probability(true,false,1,new int[]{2,9},11,1));
        edgeProbabilities.add(new Probability(true,false,1,new int[]{2,9},11,0));
        edgeProbabilities.add(new Probability(true,false,1,new int[]{9,2},11,1));
        edgeProbabilities.add(new Probability(true,false,1,new int[]{9,2},11,0));
        edgeProbabilities.add(new Probability(true,false,1,new int[]{4,3},7,5));
        edgeProbabilities.add(new Probability(true,false,1,new int[]{4,3},7,4));
        edgeProbabilities.add(new Probability(true,false,1,new int[]{4,3},7,3));
        edgeProbabilities.add(new Probability(true,false,1,new int[]{4,3},7,2));
        edgeProbabilities.add(new Probability(true,false,1,new int[]{4,3},7,1));
        edgeProbabilities.add(new Probability(true,false,1,new int[]{4,3},7,0));
        edgeProbabilities.add(new Probability(true,false,1,new int[]{3,4},7,5));
        edgeProbabilities.add(new Probability(true,false,1,new int[]{3,4},7,4));
        edgeProbabilities.add(new Probability(true,false,1,new int[]{3,4},7,3));
        edgeProbabilities.add(new Probability(true,false,1,new int[]{3,4},7,2));
        edgeProbabilities.add(new Probability(true,false,1,new int[]{3,4},7,1));
        edgeProbabilities.add(new Probability(true,false,1,new int[]{3,4},7,0));

        edgeProbabilities.add(new Probability(true,false,1,new int[]{4,5},9,3));
        edgeProbabilities.add(new Probability(true,false,1,new int[]{4,5},9,2));
        edgeProbabilities.add(new Probability(true,false,1,new int[]{4,5},9,1));
        edgeProbabilities.add(new Probability(true,false,1,new int[]{4,5},9,0));
        edgeProbabilities.add(new Probability(true,false,1,new int[]{5,4},9,3));
        edgeProbabilities.add(new Probability(true,false,1,new int[]{5,4},9,2));
        edgeProbabilities.add(new Probability(true,false,1,new int[]{5,4},9,1));
        edgeProbabilities.add(new Probability(true,false,1,new int[]{5,4},9,0));
        edgeProbabilities.add(new Probability(true,false,1,new int[]{4,7},11,1));
        edgeProbabilities.add(new Probability(true,false,1,new int[]{4,7},11,0));
        edgeProbabilities.add(new Probability(true,false,1,new int[]{7,4},11,1));
        edgeProbabilities.add(new Probability(true,false,1,new int[]{7,4},11,0));
        edgeProbabilities.add(new Probability(true,false,1,new int[]{6,3},9,3));
        edgeProbabilities.add(new Probability(true,false,1,new int[]{6,3},9,2));
        edgeProbabilities.add(new Probability(true,false,1,new int[]{6,3},9,1));
        edgeProbabilities.add(new Probability(true,false,1,new int[]{6,3},9,0));
        edgeProbabilities.add(new Probability(true,false,1,new int[]{3,6},9,3));
        edgeProbabilities.add(new Probability(true,false,1,new int[]{3,6},9,2));
        edgeProbabilities.add(new Probability(true,false,1,new int[]{3,6},9,1));
        edgeProbabilities.add(new Probability(true,false,1,new int[]{3,6},9,0));
        edgeProbabilities.add(new Probability(true,false,1,new int[]{6,5},11,1));
        edgeProbabilities.add(new Probability(true,false,1,new int[]{6,5},11,0));
        edgeProbabilities.add(new Probability(true,false,1,new int[]{5,6},11,1));
        edgeProbabilities.add(new Probability(true,false,1,new int[]{5,6},11,0));
        edgeProbabilities.add(new Probability(true,false,1,new int[]{8,3},11,1));
        edgeProbabilities.add(new Probability(true,false,1,new int[]{8,3},11,0));
        edgeProbabilities.add(new Probability(true,false,1,new int[]{3,8},11,1));
        edgeProbabilities.add(new Probability(true,false,1,new int[]{3,8},11,0));






        edgeProbabilities.add(new Probability(false,true,1,new int[]{1,3},4,8));
        edgeProbabilities.add(new Probability(false,true,1,new int[]{1,3},4,7));
        edgeProbabilities.add(new Probability(false,true,1,new int[]{1,3},4,6));
        edgeProbabilities.add(new Probability(false,true,1,new int[]{1,3},4,5));
        edgeProbabilities.add(new Probability(false,true,1,new int[]{1,3},4,4));
        edgeProbabilities.add(new Probability(false,true,1,new int[]{1,3},4,3));
        edgeProbabilities.add(new Probability(false,true,1,new int[]{1,3},4,2));
        edgeProbabilities.add(new Probability(false,true,1,new int[]{1,3},4,1));
        edgeProbabilities.add(new Probability(false,true,1,new int[]{1,3},4,0));
        edgeProbabilities.add(new Probability(false,true,1,new int[]{1,5},6,6));
        edgeProbabilities.add(new Probability(false,true,1,new int[]{1,5},6,5));
        edgeProbabilities.add(new Probability(false,true,1,new int[]{1,5},6,4));
        edgeProbabilities.add(new Probability(false,true,1,new int[]{1,5},6,3));
        edgeProbabilities.add(new Probability(false,true,1,new int[]{1,5},6,2));
        edgeProbabilities.add(new Probability(false,true,1,new int[]{1,5},6,1));
        edgeProbabilities.add(new Probability(false,true,1,new int[]{1,5},6,0));
        edgeProbabilities.add(new Probability(false,true,1,new int[]{1,7},8,4));
        edgeProbabilities.add(new Probability(false,true,1,new int[]{1,7},8,3));
        edgeProbabilities.add(new Probability(false,true,1,new int[]{1,7},8,2));
        edgeProbabilities.add(new Probability(false,true,1,new int[]{1,7},8,1));
        edgeProbabilities.add(new Probability(false,true,1,new int[]{1,7},8,0));
        edgeProbabilities.add(new Probability(false,true,1,new int[]{1,9},10,2));
        edgeProbabilities.add(new Probability(false,true,1,new int[]{1,9},10,1));
        edgeProbabilities.add(new Probability(false,true,1,new int[]{1,9},10,0));
        edgeProbabilities.add(new Probability(false,true,1,new int[]{1,11},12,0));

        edgeProbabilities.add(new Probability(true,true,1,new int[]{1,2},3,9));
        edgeProbabilities.add(new Probability(true,true,1,new int[]{1,2},3,8));
        edgeProbabilities.add(new Probability(true,true,1,new int[]{1,2},3,7));
        edgeProbabilities.add(new Probability(true,true,1,new int[]{1,2},3,6));
        edgeProbabilities.add(new Probability(true,true,1,new int[]{1,2},3,5));
        edgeProbabilities.add(new Probability(true,true,1,new int[]{1,2},3,4));
        edgeProbabilities.add(new Probability(true,true,1,new int[]{1,2},3,3));
        edgeProbabilities.add(new Probability(true,true,1,new int[]{1,2},3,2));
        edgeProbabilities.add(new Probability(true,true,1,new int[]{1,2},3,1));
        edgeProbabilities.add(new Probability(true,true,1,new int[]{1,2},3,0));
        edgeProbabilities.add(new Probability(true,true,1,new int[]{1,4},5,7));
        edgeProbabilities.add(new Probability(true,true,1,new int[]{1,4},5,6));
        edgeProbabilities.add(new Probability(true,true,1,new int[]{1,4},5,5));
        edgeProbabilities.add(new Probability(true,true,1,new int[]{1,4},5,4));
        edgeProbabilities.add(new Probability(true,true,1,new int[]{1,4},5,3));
        edgeProbabilities.add(new Probability(true,true,1,new int[]{1,4},5,2));
        edgeProbabilities.add(new Probability(true,true,1,new int[]{1,4},5,1));
        edgeProbabilities.add(new Probability(true,true,1,new int[]{1,4},5,0));
        edgeProbabilities.add(new Probability(true,true,1,new int[]{1,6},7,5));
        edgeProbabilities.add(new Probability(true,true,1,new int[]{1,6},7,4));
        edgeProbabilities.add(new Probability(true,true,1,new int[]{1,6},7,3));
        edgeProbabilities.add(new Probability(true,true,1,new int[]{1,6},7,2));
        edgeProbabilities.add(new Probability(true,true,1,new int[]{1,6},7,1));
        edgeProbabilities.add(new Probability(true,true,1,new int[]{1,6},7,0));
        edgeProbabilities.add(new Probability(true,true,1,new int[]{1,8},9,3));
        edgeProbabilities.add(new Probability(true,true,1,new int[]{1,8},9,2));
        edgeProbabilities.add(new Probability(true,true,1,new int[]{1,8},9,1));
        edgeProbabilities.add(new Probability(true,true,1,new int[]{1,8},9,0));
        edgeProbabilities.add(new Probability(true,true,1,new int[]{1,10},11,1));
        edgeProbabilities.add(new Probability(true,true,1,new int[]{1,10},11,0));




        //2个小循环
        edgeProbabilities.add(new Probability(false,false,2,new int[]{2,2,3},8,5));
        edgeProbabilities.add(new Probability(false,false,2,new int[]{2,2,3},8,4));
        edgeProbabilities.add(new Probability(false,false,2,new int[]{2,2,3},8,3));
        edgeProbabilities.add(new Probability(false,false,2,new int[]{2,2,3},8,2));
        edgeProbabilities.add(new Probability(false,false,2,new int[]{2,2,3},8,1));
        edgeProbabilities.add(new Probability(false,false,2,new int[]{2,2,3},8,0));
        edgeProbabilities.add(new Probability(false,false,2,new int[]{2,2,3},8,5));
        edgeProbabilities.add(new Probability(false,false,2,new int[]{2,2,3},8,4));
        edgeProbabilities.add(new Probability(false,false,2,new int[]{2,2,3},8,3));
        edgeProbabilities.add(new Probability(false,false,2,new int[]{2,2,3},8,2));
        edgeProbabilities.add(new Probability(false,false,2,new int[]{2,2,3},8,1));
        edgeProbabilities.add(new Probability(false,false,2,new int[]{2,2,3},8,0));
        edgeProbabilities.add(new Probability(false,false,2,new int[]{2,3,2},8,5));
        edgeProbabilities.add(new Probability(false,false,2,new int[]{2,3,2},8,4));
        edgeProbabilities.add(new Probability(false,false,2,new int[]{2,3,2},8,3));
        edgeProbabilities.add(new Probability(false,false,2,new int[]{2,3,2},8,2));
        edgeProbabilities.add(new Probability(false,false,2,new int[]{2,3,2},8,1));
        edgeProbabilities.add(new Probability(false,false,2,new int[]{2,3,2},8,0));
        edgeProbabilities.add(new Probability(false,false,2,new int[]{2,3,2},8,5));
        edgeProbabilities.add(new Probability(false,false,2,new int[]{2,3,2},8,4));
        edgeProbabilities.add(new Probability(false,false,2,new int[]{2,3,2},8,3));
        edgeProbabilities.add(new Probability(false,false,2,new int[]{2,3,2},8,2));
        edgeProbabilities.add(new Probability(false,false,2,new int[]{2,3,2},8,1));
        edgeProbabilities.add(new Probability(false,false,2,new int[]{2,3,2},8,0));
        edgeProbabilities.add(new Probability(false,false,2,new int[]{3,2,2},8,5));
        edgeProbabilities.add(new Probability(false,false,2,new int[]{3,2,2},8,4));
        edgeProbabilities.add(new Probability(false,false,2,new int[]{3,2,2},8,3));
        edgeProbabilities.add(new Probability(false,false,2,new int[]{3,2,2},8,2));
        edgeProbabilities.add(new Probability(false,false,2,new int[]{3,2,2},8,1));
        edgeProbabilities.add(new Probability(false,false,2,new int[]{3,2,2},8,0));
        edgeProbabilities.add(new Probability(false,false,2,new int[]{3,2,2},8,5));
        edgeProbabilities.add(new Probability(false,false,2,new int[]{3,2,2},8,4));
        edgeProbabilities.add(new Probability(false,false,2,new int[]{3,2,2},8,3));
        edgeProbabilities.add(new Probability(false,false,2,new int[]{3,2,2},8,2));
        edgeProbabilities.add(new Probability(false,false,2,new int[]{3,2,2},8,1));
        edgeProbabilities.add(new Probability(false,false,2,new int[]{3,2,2},8,0));
        edgeProbabilities.add(new Probability(false,false,2,new int[]{2,2,5},10,3));
        edgeProbabilities.add(new Probability(false,false,2,new int[]{2,2,5},10,2));
        edgeProbabilities.add(new Probability(false,false,2,new int[]{2,2,5},10,1));
        edgeProbabilities.add(new Probability(false,false,2,new int[]{2,2,5},10,0));
        edgeProbabilities.add(new Probability(false,false,2,new int[]{2,2,5},10,3));
        edgeProbabilities.add(new Probability(false,false,2,new int[]{2,2,5},10,2));
        edgeProbabilities.add(new Probability(false,false,2,new int[]{2,2,5},10,1));
        edgeProbabilities.add(new Probability(false,false,2,new int[]{2,2,5},10,0));
        edgeProbabilities.add(new Probability(false,false,2,new int[]{2,5,2},10,3));
        edgeProbabilities.add(new Probability(false,false,2,new int[]{2,5,2},10,2));
        edgeProbabilities.add(new Probability(false,false,2,new int[]{2,5,2},10,1));
        edgeProbabilities.add(new Probability(false,false,2,new int[]{2,5,2},10,0));
        edgeProbabilities.add(new Probability(false,false,2,new int[]{2,5,2},10,3));
        edgeProbabilities.add(new Probability(false,false,2,new int[]{2,5,2},10,2));
        edgeProbabilities.add(new Probability(false,false,2,new int[]{2,5,2},10,1));
        edgeProbabilities.add(new Probability(false,false,2,new int[]{2,5,2},10,0));
        edgeProbabilities.add(new Probability(false,false,2,new int[]{5,2,2},10,3));
        edgeProbabilities.add(new Probability(false,false,2,new int[]{5,2,2},10,2));
        edgeProbabilities.add(new Probability(false,false,2,new int[]{5,2,2},10,1));
        edgeProbabilities.add(new Probability(false,false,2,new int[]{5,2,2},10,0));
        edgeProbabilities.add(new Probability(false,false,2,new int[]{5,2,2},10,3));
        edgeProbabilities.add(new Probability(false,false,2,new int[]{5,2,2},10,2));
        edgeProbabilities.add(new Probability(false,false,2,new int[]{5,2,2},10,1));
        edgeProbabilities.add(new Probability(false,false,2,new int[]{5,2,2},10,0));
        edgeProbabilities.add(new Probability(false,false,2,new int[]{2,2,7},12,1));
        edgeProbabilities.add(new Probability(false,false,2,new int[]{2,2,7},12,0));
        edgeProbabilities.add(new Probability(false,false,2,new int[]{2,7,2},12,1));
        edgeProbabilities.add(new Probability(false,false,2,new int[]{2,7,2},12,0));
        edgeProbabilities.add(new Probability(false,false,2,new int[]{2,2,7},12,1));
        edgeProbabilities.add(new Probability(false,false,2,new int[]{2,2,7},12,0));
        edgeProbabilities.add(new Probability(false,false,2,new int[]{2,7,2},12,1));
        edgeProbabilities.add(new Probability(false,false,2,new int[]{2,7,2},12,0));
        edgeProbabilities.add(new Probability(false,false,2,new int[]{7,2,2},12,1));
        edgeProbabilities.add(new Probability(false,false,2,new int[]{7,2,2},12,0));
        edgeProbabilities.add(new Probability(false,false,2,new int[]{7,2,2},12,1));
        edgeProbabilities.add(new Probability(false,false,2,new int[]{7,2,2},12,0));
        edgeProbabilities.add(new Probability(false,false,2,new int[]{3,3,5},12,1));
        edgeProbabilities.add(new Probability(false,false,2,new int[]{3,3,5},12,0));
        edgeProbabilities.add(new Probability(false,false,2,new int[]{3,5,3},12,1));
        edgeProbabilities.add(new Probability(false,false,2,new int[]{3,5,3},12,0));
        edgeProbabilities.add(new Probability(false,false,2,new int[]{3,3,5},12,1));
        edgeProbabilities.add(new Probability(false,false,2,new int[]{3,3,5},12,0));
        edgeProbabilities.add(new Probability(false,false,2,new int[]{3,5,3},12,1));
        edgeProbabilities.add(new Probability(false,false,2,new int[]{3,5,3},12,0));
        edgeProbabilities.add(new Probability(false,false,2,new int[]{5,3,3},12,1));
        edgeProbabilities.add(new Probability(false,false,2,new int[]{5,3,3},12,0));
        edgeProbabilities.add(new Probability(false,false,2,new int[]{5,3,3},12,1));
        edgeProbabilities.add(new Probability(false,false,2,new int[]{5,3,3},12,0));

        edgeProbabilities.add(new Probability(true,false,2,new int[]{2,2,2},7,6));
        edgeProbabilities.add(new Probability(true,false,2,new int[]{2,2,2},7,5));
        edgeProbabilities.add(new Probability(true,false,2,new int[]{2,2,2},7,4));
        edgeProbabilities.add(new Probability(true,false,2,new int[]{2,2,2},7,3));
        edgeProbabilities.add(new Probability(true,false,2,new int[]{2,2,2},7,2));
        edgeProbabilities.add(new Probability(true,false,2,new int[]{2,2,2},7,1));
        edgeProbabilities.add(new Probability(true,false,2,new int[]{2,2,2},7,0));
        edgeProbabilities.add(new Probability(true,false,2,new int[]{2,2,4},9,4));
        edgeProbabilities.add(new Probability(true,false,2,new int[]{2,2,4},9,3));
        edgeProbabilities.add(new Probability(true,false,2,new int[]{2,2,4},9,2));
        edgeProbabilities.add(new Probability(true,false,2,new int[]{2,2,4},9,1));
        edgeProbabilities.add(new Probability(true,false,2,new int[]{2,2,4},9,0));
        edgeProbabilities.add(new Probability(true,false,2,new int[]{4,2,2},9,4));
        edgeProbabilities.add(new Probability(true,false,2,new int[]{4,2,2},9,3));
        edgeProbabilities.add(new Probability(true,false,2,new int[]{4,2,2},9,2));
        edgeProbabilities.add(new Probability(true,false,2,new int[]{4,2,2},9,1));
        edgeProbabilities.add(new Probability(true,false,2,new int[]{4,2,2},9,0));
        edgeProbabilities.add(new Probability(true,false,2,new int[]{2,2,6},11,2));
        edgeProbabilities.add(new Probability(true,false,2,new int[]{2,2,6},11,1));
        edgeProbabilities.add(new Probability(true,false,2,new int[]{2,2,6},11,0));
        edgeProbabilities.add(new Probability(true,false,2,new int[]{6,2,2},11,2));
        edgeProbabilities.add(new Probability(true,false,2,new int[]{6,2,2},11,1));
        edgeProbabilities.add(new Probability(true,false,2,new int[]{6,2,2},11,0));
        edgeProbabilities.add(new Probability(true,false,2,new int[]{2,4,6},13,0));
        edgeProbabilities.add(new Probability(true,false,2,new int[]{4,2,6},13,0));
        edgeProbabilities.add(new Probability(true,false,2,new int[]{6,4,2},13,0));
        edgeProbabilities.add(new Probability(true,false,2,new int[]{3,2,5},11,2));
        edgeProbabilities.add(new Probability(true,false,2,new int[]{3,2,5},11,1));
        edgeProbabilities.add(new Probability(true,false,2,new int[]{3,2,5},11,0));
        edgeProbabilities.add(new Probability(true,false,2,new int[]{2,3,5},11,2));
        edgeProbabilities.add(new Probability(true,false,2,new int[]{2,3,5},11,1));
        edgeProbabilities.add(new Probability(true,false,2,new int[]{2,3,5},11,0));
        edgeProbabilities.add(new Probability(true,false,2,new int[]{5,3,2},11,2));
        edgeProbabilities.add(new Probability(true,false,2,new int[]{5,3,2},11,1));
        edgeProbabilities.add(new Probability(true,false,2,new int[]{5,3,2},11,0));
        edgeProbabilities.add(new Probability(true,false,2,new int[]{3,2,7},13,0));
        edgeProbabilities.add(new Probability(true,false,2,new int[]{2,3,7},13,0));
        edgeProbabilities.add(new Probability(true,false,2,new int[]{7,2,3},13,0));
        edgeProbabilities.add(new Probability(true,false,2,new int[]{3,4,3},11,2));
        edgeProbabilities.add(new Probability(true,false,2,new int[]{3,4,3},11,1));
        edgeProbabilities.add(new Probability(true,false,2,new int[]{3,4,3},11,0));
        edgeProbabilities.add(new Probability(true,false,2,new int[]{4,3,3},11,2));
        edgeProbabilities.add(new Probability(true,false,2,new int[]{4,3,3},11,1));
        edgeProbabilities.add(new Probability(true,false,2,new int[]{4,3,3},11,0));
        edgeProbabilities.add(new Probability(true,false,2,new int[]{3,4,5},13,0));
        edgeProbabilities.add(new Probability(true,false,2,new int[]{4,3,5},13,0));
        edgeProbabilities.add(new Probability(true,false,2,new int[]{5,4,3},13,0));



        edgeProbabilities.add(new Probability(false,true,2,new int[]{1,2,2},6,7));
        edgeProbabilities.add(new Probability(false,true,2,new int[]{1,2,2},6,6));
        edgeProbabilities.add(new Probability(false,true,2,new int[]{1,2,2},6,5));
        edgeProbabilities.add(new Probability(false,true,2,new int[]{1,2,2},6,4));
        edgeProbabilities.add(new Probability(false,true,2,new int[]{1,2,2},6,3));
        edgeProbabilities.add(new Probability(false,true,2,new int[]{1,2,2},6,2));
        edgeProbabilities.add(new Probability(false,true,2,new int[]{1,2,2},6,1));
        edgeProbabilities.add(new Probability(false,true,2,new int[]{1,2,2},6,0));
        edgeProbabilities.add(new Probability(false,true,2,new int[]{1,2,2},6,7));
        edgeProbabilities.add(new Probability(false,true,2,new int[]{1,2,2},6,6));
        edgeProbabilities.add(new Probability(false,true,2,new int[]{1,2,2},6,5));
        edgeProbabilities.add(new Probability(false,true,2,new int[]{1,2,2},6,4));
        edgeProbabilities.add(new Probability(false,true,2,new int[]{1,2,2},6,3));
        edgeProbabilities.add(new Probability(false,true,2,new int[]{1,2,2},6,2));
        edgeProbabilities.add(new Probability(false,true,2,new int[]{1,2,2},6,1));
        edgeProbabilities.add(new Probability(false,true,2,new int[]{1,2,2},6,0));
        edgeProbabilities.add(new Probability(false,true,2,new int[]{1,3,3},8,5));
        edgeProbabilities.add(new Probability(false,true,2,new int[]{1,3,3},8,4));
        edgeProbabilities.add(new Probability(false,true,2,new int[]{1,3,3},8,3));
        edgeProbabilities.add(new Probability(false,true,2,new int[]{1,3,3},8,2));
        edgeProbabilities.add(new Probability(false,true,2,new int[]{1,3,3},8,1));
        edgeProbabilities.add(new Probability(false,true,2,new int[]{1,3,3},8,0));
        edgeProbabilities.add(new Probability(false,true,2,new int[]{1,3,3},8,5));
        edgeProbabilities.add(new Probability(false,true,2,new int[]{1,3,3},8,4));
        edgeProbabilities.add(new Probability(false,true,2,new int[]{1,3,3},8,3));
        edgeProbabilities.add(new Probability(false,true,2,new int[]{1,3,3},8,2));
        edgeProbabilities.add(new Probability(false,true,2,new int[]{1,3,3},8,1));
        edgeProbabilities.add(new Probability(false,true,2,new int[]{1,3,3},8,0));
        edgeProbabilities.add(new Probability(false,true,2,new int[]{1,3,5},10,3));
        edgeProbabilities.add(new Probability(false,true,2,new int[]{1,3,5},10,2));
        edgeProbabilities.add(new Probability(false,true,2,new int[]{1,3,5},10,1));
        edgeProbabilities.add(new Probability(false,true,2,new int[]{1,3,5},10,0));
        edgeProbabilities.add(new Probability(false,true,2,new int[]{1,5,3},10,3));
        edgeProbabilities.add(new Probability(false,true,2,new int[]{1,5,3},10,2));
        edgeProbabilities.add(new Probability(false,true,2,new int[]{1,5,3},10,1));
        edgeProbabilities.add(new Probability(false,true,2,new int[]{1,5,3},10,0));
        edgeProbabilities.add(new Probability(false,true,2,new int[]{1,3,7},12,1));
        edgeProbabilities.add(new Probability(false,true,2,new int[]{1,3,7},12,0));
        edgeProbabilities.add(new Probability(false,true,2,new int[]{1,7,3},12,1));
        edgeProbabilities.add(new Probability(false,true,2,new int[]{1,7,3},12,0));

        edgeProbabilities.add(new Probability(true,true,2,new int[]{1,2,3},7,6));
        edgeProbabilities.add(new Probability(true,true,2,new int[]{1,2,3},7,5));
        edgeProbabilities.add(new Probability(true,true,2,new int[]{1,2,3},7,4));
        edgeProbabilities.add(new Probability(true,true,2,new int[]{1,2,3},7,3));
        edgeProbabilities.add(new Probability(true,true,2,new int[]{1,2,3},7,2));
        edgeProbabilities.add(new Probability(true,true,2,new int[]{1,2,3},7,1));
        edgeProbabilities.add(new Probability(true,true,2,new int[]{1,2,3},7,0));
        edgeProbabilities.add(new Probability(true,true,2,new int[]{1,2,5},9,4));
        edgeProbabilities.add(new Probability(true,true,2,new int[]{1,2,5},9,3));
        edgeProbabilities.add(new Probability(true,true,2,new int[]{1,2,5},9,2));
        edgeProbabilities.add(new Probability(true,true,2,new int[]{1,2,5},9,1));
        edgeProbabilities.add(new Probability(true,true,2,new int[]{1,2,5},9,0));
        edgeProbabilities.add(new Probability(true,true,2,new int[]{1,2,7},11,2));
        edgeProbabilities.add(new Probability(true,true,2,new int[]{1,2,7},11,1));
        edgeProbabilities.add(new Probability(true,true,2,new int[]{1,2,7},11,0));
        edgeProbabilities.add(new Probability(true,true,2,new int[]{1,2,9},13,0));
        edgeProbabilities.add(new Probability(true,true,2,new int[]{1,4,3},9,4));
        edgeProbabilities.add(new Probability(true,true,2,new int[]{1,4,3},9,3));
        edgeProbabilities.add(new Probability(true,true,2,new int[]{1,4,3},9,2));
        edgeProbabilities.add(new Probability(true,true,2,new int[]{1,4,3},9,1));
        edgeProbabilities.add(new Probability(true,true,2,new int[]{1,4,3},9,0));
        edgeProbabilities.add(new Probability(true,true,2,new int[]{1,4,5},11,2));
        edgeProbabilities.add(new Probability(true,true,2,new int[]{1,4,5},11,1));
        edgeProbabilities.add(new Probability(true,true,2,new int[]{1,4,5},11,0));
        edgeProbabilities.add(new Probability(true,true,2,new int[]{1,4,7},13,0));
        edgeProbabilities.add(new Probability(true,true,2,new int[]{1,6,3},11,2));
        edgeProbabilities.add(new Probability(true,true,2,new int[]{1,6,3},11,1));
        edgeProbabilities.add(new Probability(true,true,2,new int[]{1,6,3},11,0));
        edgeProbabilities.add(new Probability(true,true,2,new int[]{1,6,5},13,0));
        edgeProbabilities.add(new Probability(true,true,2,new int[]{1,8,3},13,0));




        //3个小循环
        edgeProbabilities.add(new Probability(false,false,3,new int[]{2,2,2,2},10,4));
        edgeProbabilities.add(new Probability(false,false,3,new int[]{2,2,2,2},10,3));
        edgeProbabilities.add(new Probability(false,false,3,new int[]{2,2,2,2},10,2));
        edgeProbabilities.add(new Probability(false,false,3,new int[]{2,2,2,2},10,1));
        edgeProbabilities.add(new Probability(false,false,3,new int[]{2,2,2,2},10,0));
        edgeProbabilities.add(new Probability(false,false,3,new int[]{2,2,3,3},12,2));
        edgeProbabilities.add(new Probability(false,false,3,new int[]{2,2,3,3},12,1));
        edgeProbabilities.add(new Probability(false,false,3,new int[]{2,2,3,3},12,0));
        edgeProbabilities.add(new Probability(false,false,3,new int[]{2,3,3,2},12,2));
        edgeProbabilities.add(new Probability(false,false,3,new int[]{2,3,3,2},12,1));
        edgeProbabilities.add(new Probability(false,false,3,new int[]{2,3,3,2},12,0));
        edgeProbabilities.add(new Probability(false,false,3,new int[]{3,2,2,3},12,2));
        edgeProbabilities.add(new Probability(false,false,3,new int[]{3,2,2,3},12,1));
        edgeProbabilities.add(new Probability(false,false,3,new int[]{3,2,2,3},12,0));
        edgeProbabilities.add(new Probability(false,false,3,new int[]{3,3,2,2},12,2));
        edgeProbabilities.add(new Probability(false,false,3,new int[]{3,3,2,2},12,1));
        edgeProbabilities.add(new Probability(false,false,3,new int[]{3,3,2,2},12,0));
        edgeProbabilities.add(new Probability(false,false,3,new int[]{3,2,3,2},12,2));
        edgeProbabilities.add(new Probability(false,false,3,new int[]{3,2,3,2},12,1));
        edgeProbabilities.add(new Probability(false,false,3,new int[]{3,2,3,2},12,0));
        edgeProbabilities.add(new Probability(false,false,3,new int[]{2,3,2,3},12,2));
        edgeProbabilities.add(new Probability(false,false,3,new int[]{2,3,2,3},12,1));
        edgeProbabilities.add(new Probability(false,false,3,new int[]{2,3,2,3},12,0));
        edgeProbabilities.add(new Probability(false,false,3,new int[]{2,2,5,3},14,0));
        edgeProbabilities.add(new Probability(false,false,3,new int[]{2,2,3,5},14,0));
        edgeProbabilities.add(new Probability(false,false,3,new int[]{3,2,2,5},14,0));
        edgeProbabilities.add(new Probability(false,false,3,new int[]{3,2,5,2},14,0));
        edgeProbabilities.add(new Probability(false,false,3,new int[]{3,5,2,2},14,0));
        edgeProbabilities.add(new Probability(false,false,3,new int[]{5,2,2,3},14,0));
        edgeProbabilities.add(new Probability(false,false,3,new int[]{5,3,2,2},14,0));
        edgeProbabilities.add(new Probability(false,false,3,new int[]{5,2,3,2},14,0));


        edgeProbabilities.add(new Probability(true,false,3,new int[]{2,2,2,3},11,3));
        edgeProbabilities.add(new Probability(true,false,3,new int[]{2,2,2,3},11,2));
        edgeProbabilities.add(new Probability(true,false,3,new int[]{2,2,2,3},11,1));
        edgeProbabilities.add(new Probability(true,false,3,new int[]{2,2,2,3},11,0));
        edgeProbabilities.add(new Probability(true,false,3,new int[]{3,2,2,2},11,3));
        edgeProbabilities.add(new Probability(true,false,3,new int[]{3,2,2,2},11,2));
        edgeProbabilities.add(new Probability(true,false,3,new int[]{3,2,2,2},11,1));
        edgeProbabilities.add(new Probability(true,false,3,new int[]{3,2,2,2},11,0));


        edgeProbabilities.add(new Probability(true,false,3,new int[]{2,2,2,5},13,1));
        edgeProbabilities.add(new Probability(true,false,3,new int[]{2,2,2,5},13,0));
        edgeProbabilities.add(new Probability(true,false,3,new int[]{5,2,2,2},13,1));
        edgeProbabilities.add(new Probability(true,false,3,new int[]{5,2,2,2},13,0));


        edgeProbabilities.add(new Probability(true,false,3,new int[]{2,2,4,3},13,1));
        edgeProbabilities.add(new Probability(true,false,3,new int[]{2,2,4,3},13,0));
        edgeProbabilities.add(new Probability(true,false,3,new int[]{4,2,2,3},13,1));
        edgeProbabilities.add(new Probability(true,false,3,new int[]{4,2,2,3},13,0));
        edgeProbabilities.add(new Probability(true,false,3,new int[]{3,2,2,4},13,1));
        edgeProbabilities.add(new Probability(true,false,3,new int[]{3,2,2,4},13,0));




        edgeProbabilities.add(new Probability(false,true,3,new int[]{1,2,2,3},10,4));
        edgeProbabilities.add(new Probability(false,true,3,new int[]{1,2,2,3},10,3));
        edgeProbabilities.add(new Probability(false,true,3,new int[]{1,2,2,3},10,2));
        edgeProbabilities.add(new Probability(false,true,3,new int[]{1,2,2,3},10,1));
        edgeProbabilities.add(new Probability(false,true,3,new int[]{1,2,2,3},10,0));
        edgeProbabilities.add(new Probability(false,true,3,new int[]{1,2,3,2},10,4));
        edgeProbabilities.add(new Probability(false,true,3,new int[]{1,2,3,2},10,3));
        edgeProbabilities.add(new Probability(false,true,3,new int[]{1,2,3,2},10,2));
        edgeProbabilities.add(new Probability(false,true,3,new int[]{1,2,3,2},10,1));
        edgeProbabilities.add(new Probability(false,true,3,new int[]{1,2,3,2},10,0));
        edgeProbabilities.add(new Probability(false,true,3,new int[]{1,3,2,2},10,4));
        edgeProbabilities.add(new Probability(false,true,3,new int[]{1,3,2,2},10,3));
        edgeProbabilities.add(new Probability(false,true,3,new int[]{1,3,2,2},10,2));
        edgeProbabilities.add(new Probability(false,true,3,new int[]{1,3,2,2},10,1));
        edgeProbabilities.add(new Probability(false,true,3,new int[]{1,3,2,2},10,0));
        edgeProbabilities.add(new Probability(false,true,3,new int[]{1,2,2,5},12,2));
        edgeProbabilities.add(new Probability(false,true,3,new int[]{1,2,2,5},12,1));
        edgeProbabilities.add(new Probability(false,true,3,new int[]{1,2,2,5},12,0));
        edgeProbabilities.add(new Probability(false,true,3,new int[]{1,2,5,2},12,2));
        edgeProbabilities.add(new Probability(false,true,3,new int[]{1,2,5,2},12,1));
        edgeProbabilities.add(new Probability(false,true,3,new int[]{1,2,5,2},12,0));
        edgeProbabilities.add(new Probability(false,true,3,new int[]{1,5,2,2},12,2));
        edgeProbabilities.add(new Probability(false,true,3,new int[]{1,5,2,2},12,1));
        edgeProbabilities.add(new Probability(false,true,3,new int[]{1,5,2,2},12,0));
        edgeProbabilities.add(new Probability(false,true,3,new int[]{1,2,2,7},14,0));
        edgeProbabilities.add(new Probability(false,true,3,new int[]{1,2,7,3},14,0));
        edgeProbabilities.add(new Probability(false,true,3,new int[]{1,7,2,2},14,0));

        edgeProbabilities.add(new Probability(true,true,3,new int[]{1,2,2,2},9,5));
        edgeProbabilities.add(new Probability(true,true,3,new int[]{1,2,2,2},9,4));
        edgeProbabilities.add(new Probability(true,true,3,new int[]{1,2,2,2},9,3));
        edgeProbabilities.add(new Probability(true,true,3,new int[]{1,2,2,2},9,2));
        edgeProbabilities.add(new Probability(true,true,3,new int[]{1,2,2,2},9,1));
        edgeProbabilities.add(new Probability(true,true,3,new int[]{1,2,2,2},9,0));
        edgeProbabilities.add(new Probability(true,true,3,new int[]{1,2,2,4},11,3));
        edgeProbabilities.add(new Probability(true,true,3,new int[]{1,2,2,4},11,2));
        edgeProbabilities.add(new Probability(true,true,3,new int[]{1,2,2,4},11,1));
        edgeProbabilities.add(new Probability(true,true,3,new int[]{1,2,2,4},11,0));
        edgeProbabilities.add(new Probability(true,true,3,new int[]{1,2,2,6},13,1));
        edgeProbabilities.add(new Probability(true,true,3,new int[]{1,2,2,6},13,0));
        edgeProbabilities.add(new Probability(true,true,3,new int[]{1,3,2,5},13,1));
        edgeProbabilities.add(new Probability(true,true,3,new int[]{1,3,2,5},13,0));
        edgeProbabilities.add(new Probability(true,true,3,new int[]{1,3,4,3},13,1));
        edgeProbabilities.add(new Probability(true,true,3,new int[]{1,3,4,3},13,0));





        //4个小循环
        edgeProbabilities.add(new Probability(false,false,4,new int[]{2,2,2,2,3},14,1));
        edgeProbabilities.add(new Probability(false,false,4,new int[]{2,2,2,2,3},14,0));
        edgeProbabilities.add(new Probability(false,false,4,new int[]{3,2,2,2,2},14,1));
        edgeProbabilities.add(new Probability(false,false,4,new int[]{3,2,2,2,2},14,0));

        edgeProbabilities.add(new Probability(true,false,4,new int[]{2,2,2,2,4},15,0));
        edgeProbabilities.add(new Probability(true,false,4,new int[]{4,2,2,2,2},15,0));

        edgeProbabilities.add(new Probability(false,true,4,new int[]{1,2,2,2,2},12,3));
        edgeProbabilities.add(new Probability(false,true,4,new int[]{1,2,2,2,2},12,2));
        edgeProbabilities.add(new Probability(false,true,4,new int[]{1,2,2,2,2},12,1));
        edgeProbabilities.add(new Probability(false,true,4,new int[]{1,2,2,2,2},12,0));
        edgeProbabilities.add(new Probability(false,true,4,new int[]{1,2,2,3,3},14,1));
        edgeProbabilities.add(new Probability(false,true,4,new int[]{1,2,2,3,3},14,0));

        edgeProbabilities.add(new Probability(true,true,4,new int[]{1,2,2,2,3},13,2));
        edgeProbabilities.add(new Probability(true,true,4,new int[]{1,2,2,2,3},13,1));
        edgeProbabilities.add(new Probability(true,true,4,new int[]{1,2,2,2,3},13,0));
        edgeProbabilities.add(new Probability(true,true,4,new int[]{1,2,2,2,5},15,0));
        edgeProbabilities.add(new Probability(true,true,4,new int[]{1,2,2,4,3},15,0));




        //5个小循环
        edgeProbabilities.add(new Probability(false,false,5,new int[]{2,2,2,2,2,2},16,0));
        edgeProbabilities.add(new Probability(false,true,5,new int[]{1,2,2,2,2,3},16,0));
        edgeProbabilities.add(new Probability(true,true,5,new int[]{1,2,2,2,2,2},15,1));
        edgeProbabilities.add(new Probability(true,true,5,new int[]{1,2,2,2,2,2},15,0));


    }


    /**
     * 获取打乱类型
     * @param cornerOrEdge 角或棱
     * @param isParity 奇偶
     * @param isHoming 缓冲归位
     * @param codeCount 编码数量
     * @param minorCycleCount 小循环数量
     * @param turnOverColorCount 翻色数量
     * @return
     */
    public static List<Probability> getKindByAllParams(CornerOrEdge cornerOrEdge,boolean isParity, boolean isHoming, int codeCount, int minorCycleCount, int turnOverColorCount){
        List<Probability> tempList = new ArrayList<>();
        for(Probability p :(cornerOrEdge==CornerOrEdge.CORNER ? cornerProbabilities : edgeProbabilities) ) {
            if(p.isParity()==isParity
                    &&p.isHoming()==isHoming
                    &&p.getCodeCount()==codeCount
                    &&p.getMinorCycleCount()==minorCycleCount
                    &&p.getTurnOverColorCount()==turnOverColorCount
                    ){

                tempList.add(p);
            }
        }
        return tempList;
    }


    /**
     * 获取打乱类型
     * @param cornerOrEdge 角或棱
     * @param isParity 奇偶
     * @return
     */
    public static List<Probability> getKindByIsParity(CornerOrEdge cornerOrEdge, boolean isParity){
        List<Probability> tempList = new ArrayList<>();
        for(Probability p :(cornerOrEdge==CornerOrEdge.CORNER ? cornerProbabilities : edgeProbabilities) ) {
            if(p.isParity()==isParity){
                tempList.add(p);
            }
        }
        return tempList;
    }

    /**
     * 获取打乱类型
     * @param cornerOrEdge 角或棱
     * @param isHoming 缓冲归位
     * @return
     */
    public static List<Probability> getKindByIsHoming(CornerOrEdge cornerOrEdge,boolean isHoming){
        List<Probability> tempList = new ArrayList<>();
        for(Probability p :(cornerOrEdge==CornerOrEdge.CORNER ? cornerProbabilities : edgeProbabilities) ) {
            if(p.isHoming()==isHoming){
                tempList.add(p);
            }
        }
        return tempList;
    }

    /**
     * 获取打乱类型
     * @param cornerOrEdge 角或棱
     * @param codeCount 编码数量
     * @return
     */
    public static List<Probability> getKindByCodeCount(CornerOrEdge cornerOrEdge,int codeCount){
        List<Probability> tempList = new ArrayList<>();
        for(Probability p :(cornerOrEdge==CornerOrEdge.CORNER ? cornerProbabilities : edgeProbabilities) ) {
            if(p.getCodeCount()==codeCount){
                tempList.add(p);
            }
        }
        return tempList;
    }

    /**
     * 获取打乱类型
     * @param cornerOrEdge 角或棱
     * @param minorCycleCount 小循环数量
     * @return
     */
    public static List<Probability> getKindByMinorCycleCount(CornerOrEdge cornerOrEdge, int minorCycleCount){
        List<Probability> tempList = new ArrayList<>();
        for(Probability p :(cornerOrEdge==CornerOrEdge.CORNER ? cornerProbabilities : edgeProbabilities) ) {
            if(p.getMinorCycleCount()==minorCycleCount){
                tempList.add(p);
            }
        }
        return tempList;
    }

    /**
     * 获取打乱类型
     * @param cornerOrEdge 角或棱
     * @param turnOverColorCount 翻色数量
     * @return
     */
    public static List<Probability> getKindByTurnOverColorCount(CornerOrEdge cornerOrEdge,int turnOverColorCount){
        List<Probability> tempList = new ArrayList<>();
        for(Probability p :(cornerOrEdge==CornerOrEdge.CORNER ? cornerProbabilities : edgeProbabilities) ) {
            if(p.getTurnOverColorCount()==turnOverColorCount){
                tempList.add(p);
            }
        }
        return tempList;
    }

    //随机角  缓冲归位概率 1/7  编码至少3个 翻色数量少于4个
    static Probability getRandomCorner(){
        List<Probability> result = new ArrayList<>();
        boolean[] isHoming = {false,false,true,false,false,false,false};
        boolean isHome = isHoming[new Random().nextInt(isHoming.length)];
        for (Probability p : cornerProbabilities) {
            if(p.getCodeCount()>=3&&p.isHoming()==isHome&&p.getTurnOverColorCount()<4){
                result.add(p);
            }
        }

        Probability probability = result.get(new Random().nextInt(result.size()));
        return probability;
    }

    //随机棱  缓冲归位概率 1/10  编码至少5个 翻色数量少于5个
    static Probability getRandomEdge(boolean isParity){
        List<Probability> result = new ArrayList<>();
        boolean[] isHoming = {false,false,true,false,false,false,false,false,false,false};
        boolean isHome = isHoming[new Random().nextInt(isHoming.length)];
        for (Probability p : edgeProbabilities) {
            if(p.getCodeCount()>=5&&p.isHoming()==isHome&&isParity==p.isParity()&&p.getTurnOverColorCount()<5){
                result.add(p);
            }
        }

        Probability probability = result.get(new Random().nextInt(result.size()));
        return probability;
    }


    /**
     * 随机获取角+棱的打乱
     * @return 0 角  1棱
     */
    public static List<Probability> getRandomType(){
        Probability corner = getRandomCorner();
        Probability edge = getRandomEdge(corner.isParity());
        List<Probability> result = new ArrayList<>();
        result.add(corner);
        result.add(edge);
        return result;
    }




    //角
    static Probability getShenCorner(){
        List<Probability> result = new ArrayList<>();
        for (Probability p : cornerProbabilities) {
            if(p.getCodeCount()>=3&&p.getCodeCount()<=8&&p.getMinorCycleCount()<=1&&p.getTurnOverColorCount()==0){
                result.add(p);
            }
        }

        Probability probability = result.get(new Random().nextInt(result.size()));
        return probability;
    }

    //棱
    static Probability getShenEdge(boolean isParity){
        List<Probability> result = new ArrayList<>();
        for (Probability p : edgeProbabilities) {
            if(p.getCodeCount()>=5&&p.getCodeCount()<=12&&p.getMinorCycleCount()<=2&&isParity==p.isParity()&&p.getTurnOverColorCount()==0){
                result.add(p);
            }
        }

        Probability probability = result.get(new Random().nextInt(result.size()));
        return probability;
    }

    /**
     * 神打
     * @return 0 角  1棱
     */
    public static List<Probability> getShenType(){
        Probability corner = getShenCorner();
        Probability edge = getShenEdge(corner.isParity());
        List<Probability> result = new ArrayList<>();
        result.add(corner);
        result.add(edge);
        return result;
    }














    /**
     * 取相同元素的集合
     * @return 0 角  1棱
     */
    public static List<Probability> getRepeatList(List<Probability> l1,List<Probability> l2){
        List<Probability> result = new ArrayList<>();
        for (Probability p1 : l1) {
            for (Probability p2 : l2) {
                if (p1.equals(p2)) {
                    result.add(p1);
                }
            }
        }

        return result;
    }


    public static List<Probability> getCornerProbabilities() {
        return cornerProbabilities;
    }

    public static List<Probability> getEdgeProbabilities() {
        return edgeProbabilities;
    }
}
