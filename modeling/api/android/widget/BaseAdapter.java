package android.widget;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;

public abstract class BaseAdapter implements ListAdapter, SpinnerAdapter {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:58.475 -0500", hash_original_field = "6D0681B9CC29887CCBA4001347A5783B", hash_generated_field = "1CDD3690953D684D62F0461546A52041")

    private final DataSetObservable mDataSetObservable = new DataSetObservable();

	@DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    public BaseAdapter() {
		//Not in the initial implementation, generated for specdump
	}

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:58.478 -0500", hash_original_method = "715CB29FF3CEE320E11EC1BD997C9D63", hash_generated_method = "A0DC4E380222F91FCE535191E64A1824")
    @DSVerified
    @DSSafe(DSCat.SAFE_LIST)
public boolean hasStableIds() {
        return false;
    }
    
    @DSVerified
    @DSSafe(DSCat.SAFE_LIST)
    public abstract Object getItem(int pos);

    @DSVerified
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:58.481 -0500", hash_original_method = "5BE178AB760CC925EF7E1111F1B4915D", hash_generated_method = "6A22BA8F56D7F69EA0195E58760DC1E9")
public void registerDataSetObserver(DataSetObserver observer) {
        mDataSetObservable.registerObserver(observer);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:58.483 -0500", hash_original_method = "8548074F279CEB9C75C60995B3E76B4B", hash_generated_method = "031B2EC0C55A5BC43BE2C370EF5FFD75")
    
    @DSVerified
    @DSSafe(DSCat.SAFE_OTHERS)
public void unregisterDataSetObserver(DataSetObserver observer) {
        mDataSetObservable.unregisterObserver(observer);
    }
    
    /**
     * Notifies the attached observers that the underlying data has been changed
     * and any View reflecting the data set should refresh itself.
     */
    @DSComment("Binding data, need modeling to be safe")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:58.485 -0500", hash_original_method = "6B5DF5B4CDDD51D923DE488520E93535", hash_generated_method = "782276BFD026F517836F431E691733F0")
    
public void notifyDataSetChanged() {
        mDataSetObservable.notifyChanged();
    }

    /**
     * Notifies the attached observers that the underlying data is no longer valid
     * or available. Once invoked this adapter is no longer valid and should
     * not report further data set changes.
     */
    @DSComment("Binding data, need modeling to be safe")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:58.487 -0500", hash_original_method = "733D96117EC068A88A560CFA24913D79", hash_generated_method = "9039EDC909D1B84EC6F4A43479C7428B")
    
public void notifyDataSetInvalidated() {
        mDataSetObservable.notifyInvalidated();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:58.489 -0500", hash_original_method = "DC1745DFF85763BBC0B3711D531FD60B", hash_generated_method = "9EDAFF54639C3972375E50BCC11C975C")
    
public boolean areAllItemsEnabled() {
        return true;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:58.491 -0500", hash_original_method = "C1B9753B52C20D50833727AFD33E53F1", hash_generated_method = "F46CED3B97A44DE88F852585D2A5CACA")
    
public boolean isEnabled(int position) {
        return true;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:58.493 -0500", hash_original_method = "CB37ABFEFF70AAB623ABE3C5C5654EBA", hash_generated_method = "C130B06C5541CF8B289B8F49334D09CE")
    @DSVerified
    @DSSafe(DSCat.SAFE_OTHERS)
public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return getView(position, convertView, parent);
    }

    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:58.495 -0500", hash_original_method = "EE97D094FF23924861F9B1BB9874462B", hash_generated_method = "3610CA007643502BCB5C59065F70D2D6")
    
public int getItemViewType(int position) {
        return 0;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:58.498 -0500", hash_original_method = "A6079B88B18082AA3C7D7E460D2C3B87", hash_generated_method = "2577B8C4DED14F5EF8C0214DED9A780B")
    
public int getViewTypeCount() {
        return 1;
    }
    
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:58.500 -0500", hash_original_method = "837A179B327E763126CB6909C28E4F2B", hash_generated_method = "CD8A3F59B7B104167347DEF141D26EA8")
    
public boolean isEmpty() {
        return getCount() == 0;
    }
    
}

