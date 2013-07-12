package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public interface WrapperListAdapter extends ListAdapter {
    
    public ListAdapter getWrappedAdapter();
}
