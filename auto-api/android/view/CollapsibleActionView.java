package android.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.view.MenuItem.OnActionExpandListener;

public interface CollapsibleActionView {
    
    public void onActionViewExpanded();

    
    public void onActionViewCollapsed();
}

