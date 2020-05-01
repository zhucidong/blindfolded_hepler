package zd.cornermemory.bean;

import java.util.List;

/**
 * Created by zhud on 2019/9/26.
 * 保存 魔方编码
 */

public class CubeCode {
    private CubeDirection direction;
    private List<String> corners;
    private List<String> edges;

    public CubeCode() {
    }

    public CubeCode(CubeDirection direction, List<String> corners, List<String> edges) {
        this.direction = direction;
        this.corners = corners;
        this.edges = edges;
    }

    public CubeDirection getDirection() {
        return direction;
    }

    public void setDirection(CubeDirection direction) {
        this.direction = direction;
    }

    public List<String> getCorners() {
        return corners;
    }

    public void setCorners(List<String> corners) {
        this.corners = corners;
    }

    public List<String> getEdges() {
        return edges;
    }

    public void setEdges(List<String> edges) {
        this.edges = edges;
    }
}
