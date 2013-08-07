package android.widget;

// Droidsafe Imports
import droidsafe.annotations.*;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;

public interface ExpandableListAdapter {
    
    void registerDataSetObserver(DataSetObserver observer);

    
    void unregisterDataSetObserver(DataSetObserver observer);

    
    int getGroupCount();

    
    int getChildrenCount(int groupPosition);

    
    Object getGroup(int groupPosition);
    
    
    Object getChild(int groupPosition, int childPosition);

    
    long getGroupId(int groupPosition);

    
    long getChildId(int groupPosition, int childPosition);

    
    boolean hasStableIds();

    
    View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent);

    
    View getChildView(int groupPosition, int childPosition, boolean isLastChild,
            View convertView, ViewGroup parent);

    
    boolean isChildSelectable(int groupPosition, int childPosition);

    
    boolean areAllItemsEnabled();
    
    
    boolean isEmpty();

    
    void onGroupExpanded(int groupPosition);
    
    
    void onGroupCollapsed(int groupPosition);
    
    
    long getCombinedChildId(long groupId, long childId);

    
    long getCombinedGroupId(long groupId);
}
