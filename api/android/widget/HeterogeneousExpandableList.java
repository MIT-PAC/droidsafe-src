package android.widget;

// Droidsafe Imports

public interface HeterogeneousExpandableList {
    
    int getGroupType(int groupPosition);

    
    int getChildType(int groupPosition, int childPosition);

    
    int getGroupTypeCount();

    
    int getChildTypeCount();
}
