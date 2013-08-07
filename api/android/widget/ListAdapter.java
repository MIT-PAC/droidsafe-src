package android.widget;

// Droidsafe Imports
import droidsafe.annotations.*;

public interface ListAdapter extends Adapter {

    
    public boolean areAllItemsEnabled();

    
    boolean isEnabled(int position);
}
