package zd.cornermemory.bean;

import java.util.List;

/**
 * Created by zhud on 2019/9/25.
 * 描述 魔方每个贴纸的颜色 精确到某一个编码
 */

public class CubePaster {
    private CubeColor    colorEnum;//颜色
    private List<String> cornerPasters;//角块同颜色的编码
    private List<String> edgePasters;//棱块+中心块 同颜色的编码

    public CubePaster() {
    }

    public CubePaster(CubeColor colorEnum, List<String> cornerPasters, List<String> edgePasters) {
        this.colorEnum = colorEnum;
        this.cornerPasters = cornerPasters;
        this.edgePasters = edgePasters;
    }

    public CubeColor getColorEnum() {
        return colorEnum;
    }

    public void setColorEnum(CubeColor colorEnum) {
        this.colorEnum = colorEnum;
    }

    public List<String> getCornerPasters() {
        return cornerPasters;
    }

    public void setCornerPasters(List<String> cornerPasters) {
        this.cornerPasters = cornerPasters;
    }

    public List<String> getEdgePasters() {
        return edgePasters;
    }

    public void setEdgePasters(List<String> edgePasters) {
        this.edgePasters = edgePasters;
    }
}
