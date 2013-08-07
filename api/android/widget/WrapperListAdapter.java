package android.widget;

// Droidsafe Imports
import droidsafe.annotations.*;

public interface WrapperListAdapter extends ListAdapter {
    
    public ListAdapter getWrappedAdapter();
}
