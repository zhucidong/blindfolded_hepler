package zd.cornermemory.bean;

import java.util.List;

/**
 * Created by zhud on 2019/9/25.
 * 描述 魔方某一面的颜色  up, down 等
 */

public class DisplayBean {
    private CubeDirection   cubeDirection;
    private List<CubeColor> cornerColors;//某一面角块颜色 右上角顺时针排序
    private List<CubeColor> edgeColors;//某一面棱块颜色 12点方向顺时针排序，中心块为4

    public DisplayBean(CubeDirection cubeDirection, List<CubeColor> cornerColors, List<CubeColor> edgeColors) {
        this.cubeDirection = cubeDirection;
        this.cornerColors = cornerColors;
        this.edgeColors = edgeColors;
    }

    public DisplayBean() {
    }

    public CubeDirection getCubeDirection() {
        return cubeDirection;
    }

    public void setCubeDirection(CubeDirection cubeDirection) {
        this.cubeDirection = cubeDirection;
    }

    public List<CubeColor> getCornerColors() {
        return cornerColors;
    }

    public void setCornerColors(List<CubeColor> cornerColors) {
        this.cornerColors = cornerColors;
    }

    public List<CubeColor> getEdgeColors() {
        return edgeColors;
    }

    public void setEdgeColors(List<CubeColor> edgeColors) {
        this.edgeColors = edgeColors;
    }
}
