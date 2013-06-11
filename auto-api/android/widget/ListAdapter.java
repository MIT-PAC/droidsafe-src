package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public interface ListAdapter extends Adapter {

    
    public boolean areAllItemsEnabled();

    
    boolean isEnabled(int position);
}

