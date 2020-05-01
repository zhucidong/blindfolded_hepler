package zd.cornermemory.bean;

import java.util.Arrays;

/**
 * Created by zhud on 2019/10/9.
 * 存储概率相关
 */

public class Probability {
    private boolean isParity;//是否有奇偶
    private boolean isHoming;//缓冲是否归位
    private int     minorCycleCount;//小循环数
    private int[]   separator;//分组逻辑
    private int     codeCount;//编码数
    private int     turnOverColorCount;//翻色数


    public Probability() {
    }


    @Override
    public boolean equals(Object obj) {
        if (getClass() != obj.getClass()){
            return false;
        }
        Probability other = (Probability) obj;
        if(this.isParity==other.isParity()&&this.isHoming==other.isHoming()
                &&this.minorCycleCount== other.getMinorCycleCount()
                &&Arrays.equals(this.separator,other.getSeparator())
                &&this.codeCount == other.getCodeCount()
                &&this.turnOverColorCount == other.getTurnOverColorCount()
                ){
            return true;
        }else {
            return false;
        }
    }


    /**
     *
     * @param isParity 奇偶
     * @param isHoming 缓冲归位
     * @param minorCycleCount 小循环数
     * @param separator
     * @param codeCount 编码数
     * @param turnOverColorCount 最大翻色数
     */
    public Probability(boolean isParity, boolean isHoming, int minorCycleCount, int[] separator, int codeCount, int turnOverColorCount) {
        this.isParity = isParity;
        this.isHoming = isHoming;
        this.minorCycleCount = minorCycleCount;
        this.separator = separator;
        this.codeCount = codeCount;
        this.turnOverColorCount = turnOverColorCount;
    }

    public int[] getSeparator() {
        return separator;
    }

    public void setSeparator(int[] separator) {
        this.separator = separator;
    }

    public boolean isParity() {
        return isParity;
    }

    public void setParity(boolean parity) {
        isParity = parity;
    }

    public boolean isHoming() {
        return isHoming;
    }

    public void setHoming(boolean homing) {
        isHoming = homing;
    }

    public int getMinorCycleCount() {
        return minorCycleCount;
    }

    public void setMinorCycleCount(int minorCycleCount) {
        this.minorCycleCount = minorCycleCount;
    }


    public int getCodeCount() {
        return codeCount;
    }

    public void setCodeCount(int codeCount) {
        this.codeCount = codeCount;
    }

    public int getTurnOverColorCount() {
        return turnOverColorCount;
    }

    public void setTurnOverColorCount(int turnOverColorCount) {
        this.turnOverColorCount = turnOverColorCount;
    }


    @Override
    public String toString() {
        return "Probability{" +
                "isParity=" + isParity +
                ", isHoming=" + isHoming +
                ", minorCycleCount=" + minorCycleCount +
                ", separator=" + Arrays.toString(separator) +
                ", codeCount=" + codeCount +
                ", turnOverColorCount=" + turnOverColorCount +
                '}';
    }
}
