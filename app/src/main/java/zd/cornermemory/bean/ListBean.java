package zd.cornermemory.bean;

import java.util.List;

/**
 * Created by zhud on 2019/9/25.
 * 处理魔方旋转过程中需要交换的编码 暂存类
 */

public class ListBean {
    private List<String> list1;
    private List<String> list2;
    private List<String> list3;
    private List<String> list4;

    public ListBean() {
    }

    public ListBean(List<String> list1, List<String> list2, List<String> list3, List<String> list4) {
        this.list1 = list1;
        this.list2 = list2;
        this.list3 = list3;
        this.list4 = list4;
    }

    public List<String> getList1() {
        return list1;
    }

    public void setList1(List<String> list1) {
        this.list1 = list1;
    }

    public List<String> getList2() {
        return list2;
    }

    public void setList2(List<String> list2) {
        this.list2 = list2;
    }

    public List<String> getList3() {
        return list3;
    }

    public void setList3(List<String> list3) {
        this.list3 = list3;
    }

    public List<String> getList4() {
        return list4;
    }

    public void setList4(List<String> list4) {
        this.list4 = list4;
    }
}
