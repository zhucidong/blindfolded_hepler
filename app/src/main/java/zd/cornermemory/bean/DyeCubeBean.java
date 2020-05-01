package zd.cornermemory.bean;

/**
 * Created by zhud on 2019/9/26.
 * 魔方配色 用于指定坐标
 */

public class DyeCubeBean {
    private CubeDirection direction;
    private CubeColor     colorEnum;

    public DyeCubeBean() {
    }

    public DyeCubeBean(CubeDirection direction, CubeColor colorEnum) {
        this.direction = direction;
        this.colorEnum = colorEnum;
    }

    public CubeDirection getDirection() {
        return direction;
    }

    public void setDirection(CubeDirection direction) {
        this.direction = direction;
    }

    public CubeColor getColorEnum() {
        return colorEnum;
    }

    public void setColorEnum(CubeColor colorEnum) {
        this.colorEnum = colorEnum;
    }
}
