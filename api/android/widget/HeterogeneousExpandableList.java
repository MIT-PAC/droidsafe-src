package android.widget;

// Droidsafe Imports
import droidsafe.annotations.*;

public interface HeterogeneousExpandableList {
    
    int getGroupType(int groupPosition);

    
    int getChildType(int groupPosition, int childPosition);

    
    int getGroupTypeCount();

    
    int getChildTypeCount();
}
