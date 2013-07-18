package android.widget;

// Droidsafe Imports
import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSModeled;

public abstract class BaseAdapter implements ListAdapter, SpinnerAdapter {
    private final DataSetObservable mDataSetObservable = new DataSetObservable();
    
@DSModeled(DSC.SAFE)
	public BaseAdapter() {
		//Not in the initial implementation, generated for specdump
	}
    @DSModeled(DSC.SAFE)
    public boolean hasStableIds() {
        return false;
    }

    
    public void registerDataSetObserver(DataSetObserver observer) {
        mDataSetObservable.registerObserver(observer);
    }

    
    public void unregisterDataSetObserver(DataSetObserver observer) {
        mDataSetObservable.unregisterObserver(observer);
    }

    
    public void notifyDataSetChanged() {
        mDataSetObservable.notifyChanged();
    }

    
    public void notifyDataSetInvalidated() {
        mDataSetObservable.notifyInvalidated();
    }

    
    @DSModeled(DSC.SAFE)
    public boolean areAllItemsEnabled() {
        return true;
    }

    
    @DSModeled(DSC.SAFE)
    public boolean isEnabled(int position) {
        return true;
    }

    
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return getView(position, convertView, parent);
    }

    
    @DSModeled(DSC.SAFE)
    public int getItemViewType(int position) {
        return 0;
    }

    
    @DSModeled(DSC.SAFE)
    public int getViewTypeCount() {
        return 1;
    }

    
    public boolean isEmpty() {
        return getCount() == 0;
    }

    
}

