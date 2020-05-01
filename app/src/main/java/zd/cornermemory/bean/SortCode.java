package zd.cornermemory.bean;

/**
 * Created by zhud on 2019/9/30.
 * 修改借位顺序的时候，显示 display
 * 存入key
 */

public class SortCode {
    private String display;//
    private String key;

    public SortCode(String display, String key) {
        this.display = display;
        this.key = key;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
