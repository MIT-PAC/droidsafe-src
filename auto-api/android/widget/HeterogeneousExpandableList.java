package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.view.View;
import android.view.ViewGroup;

public interface HeterogeneousExpandableList {
    
    int getGroupType(int groupPosition);

    
    int getChildType(int groupPosition, int childPosition);

    
    int getGroupTypeCount();

    
    int getChildTypeCount();
}
