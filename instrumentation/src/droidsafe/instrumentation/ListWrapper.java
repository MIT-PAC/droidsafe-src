package droidsafe.instrumentation;

import java.util.LinkedList;
import java.util.List;

public class ListWrapper {
    
    List<Object> members;
    public ListWrapper() {
        members = new LinkedList<Object>();        
    }

    public void add(Object obj) {
        members.add(obj);
    }
        
    public void add(boolean b) {
        members.add(Boolean.valueOf(b));
    }
    
    public void add(double d) {
        members.add(Double.valueOf(d));
    }
    
    public void add(int i) {
        members.add(i);
    }
    
    public void clear() {
        members.clear();
    }
    
    
    public List<Object> getList() {
        return members;
    }
}
