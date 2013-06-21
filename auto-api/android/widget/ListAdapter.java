package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public interface ListAdapter extends Adapter {

    
    public boolean areAllItemsEnabled();

    
    boolean isEnabled(int position);
}
