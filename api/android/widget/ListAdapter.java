package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public interface ListAdapter extends Adapter {

    
    public boolean areAllItemsEnabled();

    
    boolean isEnabled(int position);
}
