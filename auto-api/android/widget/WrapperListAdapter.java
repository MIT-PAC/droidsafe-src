package android.widget;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public interface WrapperListAdapter extends ListAdapter {
    
    public ListAdapter getWrappedAdapter();
}
