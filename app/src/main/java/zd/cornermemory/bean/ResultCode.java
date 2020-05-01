package zd.cornermemory.bean;

/**
 * Created by zhud on 2019/9/30.
 */

public class ResultCode {
    private String code;
    private boolean isjie;
    private boolean isHuang;

    public ResultCode(String code, boolean isjie, boolean isHuang) {
        this.code = code;
        this.isjie = isjie;
        this.isHuang = isHuang;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isjie() {
        return isjie;
    }

    public void setIsjie(boolean isjie) {
        this.isjie = isjie;
    }

    public boolean isHuang() {
        return isHuang;
    }

    public void setHuang(boolean huang) {
        isHuang = huang;
    }
}
