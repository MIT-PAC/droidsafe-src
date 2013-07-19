package android.widget;

// Droidsafe Imports
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;

public interface Adapter {
    
    void registerDataSetObserver(DataSetObserver observer);

    
    void unregisterDataSetObserver(DataSetObserver observer);

    
    int getCount();   
    
    
    Object getItem(int position);
    
    
    long getItemId(int position);
    
    
    boolean hasStableIds();
    
    
    View getView(int position, View convertView, ViewGroup parent);

    
    static final int IGNORE_ITEM_VIEW_TYPE = AdapterView.ITEM_VIEW_TYPE_IGNORE;
    
    
    int getItemViewType(int position);
    
    
    int getViewTypeCount();
    
    static final int NO_SELECTION = Integer.MIN_VALUE;
 
     
     boolean isEmpty();
}
