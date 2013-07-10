package android.widget;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public interface ListAdapter extends Adapter {

    
    public boolean areAllItemsEnabled();

    
    boolean isEnabled(int position);
}
