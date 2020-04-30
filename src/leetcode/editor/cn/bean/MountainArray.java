package leetcode.editor.cn.bean;

import java.util.ArrayList;
import java.util.List;

public class MountainArray {
    private List<Integer> data = new ArrayList<Integer>();
    public Integer get(int index) {
        return data.get(index);
    }
    public int length() {
        return data.size();
    }
}
