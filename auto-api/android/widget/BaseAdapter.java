package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;

public abstract class BaseAdapter implements ListAdapter, SpinnerAdapter {
    private DataSetObservable mDataSetObservable = new DataSetObservable();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.342 -0400", hash_original_method = "DDB5C21DFF26B6AD164019A65A1153B0", hash_generated_method = "DDB5C21DFF26B6AD164019A65A1153B0")
        public BaseAdapter ()
    {
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.343 -0400", hash_original_method = "715CB29FF3CEE320E11EC1BD997C9D63", hash_generated_method = "42DF4E24108D47398EF582C8D3CA5818")
    @DSModeled(DSC.SAFE)
    public boolean hasStableIds() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.343 -0400", hash_original_method = "5BE178AB760CC925EF7E1111F1B4915D", hash_generated_method = "FC77F1E3F279C66541FD7DA4F64358F4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerDataSetObserver(DataSetObserver observer) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(observer.dsTaint);
        mDataSetObservable.registerObserver(observer);
        // ---------- Original Method ----------
        //mDataSetObservable.registerObserver(observer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.343 -0400", hash_original_method = "8548074F279CEB9C75C60995B3E76B4B", hash_generated_method = "C1751D77F2D779318A80DD109F1E6D00")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterDataSetObserver(DataSetObserver observer) {
        dsTaint.addTaint(observer.dsTaint);
        mDataSetObservable.unregisterObserver(observer);
        // ---------- Original Method ----------
        //mDataSetObservable.unregisterObserver(observer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.343 -0400", hash_original_method = "6B5DF5B4CDDD51D923DE488520E93535", hash_generated_method = "3158F3A56E63A128E4489E6003CA7FEA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void notifyDataSetChanged() {
        mDataSetObservable.notifyChanged();
        // ---------- Original Method ----------
        //mDataSetObservable.notifyChanged();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.343 -0400", hash_original_method = "733D96117EC068A88A560CFA24913D79", hash_generated_method = "A7F0E4AF3D0109D819E8AFDA57AB77CC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void notifyDataSetInvalidated() {
        mDataSetObservable.notifyInvalidated();
        // ---------- Original Method ----------
        //mDataSetObservable.notifyInvalidated();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.344 -0400", hash_original_method = "DC1745DFF85763BBC0B3711D531FD60B", hash_generated_method = "786979799784B7532B5AD77542C38CAC")
    @DSModeled(DSC.SAFE)
    public boolean areAllItemsEnabled() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.344 -0400", hash_original_method = "C1B9753B52C20D50833727AFD33E53F1", hash_generated_method = "5205B8D76E719800C7AD4AC21F4F350E")
    @DSModeled(DSC.SAFE)
    public boolean isEnabled(int position) {
        dsTaint.addTaint(position);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.344 -0400", hash_original_method = "CB37ABFEFF70AAB623ABE3C5C5654EBA", hash_generated_method = "6A0C6C27600D67819BF76271578A3A64")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        dsTaint.addTaint(position);
        dsTaint.addTaint(parent.dsTaint);
        dsTaint.addTaint(convertView.dsTaint);
        View var97492F0E731BBC1717D513B00D6780A5_1968968540 = (getView(position, convertView, parent));
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return getView(position, convertView, parent);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.344 -0400", hash_original_method = "EE97D094FF23924861F9B1BB9874462B", hash_generated_method = "882AC502ACA966B0A25E3C5395424311")
    @DSModeled(DSC.SAFE)
    public int getItemViewType(int position) {
        dsTaint.addTaint(position);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.344 -0400", hash_original_method = "A6079B88B18082AA3C7D7E460D2C3B87", hash_generated_method = "53C49EF97DA6F0C93968D7347515DA5D")
    @DSModeled(DSC.SAFE)
    public int getViewTypeCount() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.344 -0400", hash_original_method = "837A179B327E763126CB6909C28E4F2B", hash_generated_method = "3D468448DDCD0D59318109B767B1DAD1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isEmpty() {
        boolean varADA608D398DBF5C72CB16CE000ED04D6_522985392 = (getCount() == 0);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return getCount() == 0;
    }

    
}

