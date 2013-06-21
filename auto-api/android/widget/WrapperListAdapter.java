package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public interface WrapperListAdapter extends ListAdapter {
    
    public ListAdapter getWrappedAdapter();
}
