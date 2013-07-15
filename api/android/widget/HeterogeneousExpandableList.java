package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.view.View;
import android.view.ViewGroup;

public interface HeterogeneousExpandableList {
    
    int getGroupType(int groupPosition);

    
    int getChildType(int groupPosition, int childPosition);

    
    int getGroupTypeCount();

    
    int getChildTypeCount();
}
