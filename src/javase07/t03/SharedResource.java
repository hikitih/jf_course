package javase07.t03;

import java.util.ArrayList;
import java.util.List;

public class SharedResource {

    private List<Integer> list;
    private boolean needMoreElements = true;

    public SharedResource() {
        list = new ArrayList<Integer>();
    }

    public void setElement(Integer element) {
        list.add(element);
    }

    public Integer getELement() {
        if (list.size() > 0) {
            return list.remove(0);
        }
        return null;
    }

    public boolean isNeedMoreElements() {
        return needMoreElements;
    }

    public void setNeedMoreElements(boolean needMoreElements) {
        this.needMoreElements = needMoreElements;
    }
}