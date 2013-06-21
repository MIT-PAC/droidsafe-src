package android.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.view.MenuItem.OnActionExpandListener;

public interface CollapsibleActionView {
    
    public void onActionViewExpanded();

    
    public void onActionViewCollapsed();
}
