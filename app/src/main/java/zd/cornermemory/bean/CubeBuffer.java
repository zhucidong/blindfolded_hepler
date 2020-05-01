package zd.cornermemory.bean;

/**
 * Created by zhud on 2019/9/27.
 * 描述魔方 缓冲面
 * 某一面，某一个index 为缓冲面
 */

public class CubeBuffer {
    private CubeDirection direction;
    private int bufferIndex;

    @Override
    public boolean equals(Object obj) {
        if (getClass() != obj.getClass()){
            return false;
        }
        CubeBuffer other = (CubeBuffer) obj;
        if(this.direction==other.getDirection()&&this.bufferIndex==other.getBufferIndex()){
            return true;
        }else {
            return false;
        }
    }

    public CubeBuffer() {
    }

    public CubeBuffer(CubeDirection direction, int bufferIndex) {
        this.direction = direction;
        this.bufferIndex = bufferIndex;
    }

    public CubeDirection getDirection() {
        return direction;
    }

    public void setDirection(CubeDirection direction) {
        this.direction = direction;
    }

    public int getBufferIndex() {
        return bufferIndex;
    }

    public void setBufferIndex(int bufferIndex) {
        this.bufferIndex = bufferIndex;
    }
}
