package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;

public abstract class BaseAdapter implements ListAdapter, SpinnerAdapter {
    private final DataSetObservable mDataSetObservable = new DataSetObservable();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.471 -0400", hash_original_method = "715CB29FF3CEE320E11EC1BD997C9D63", hash_generated_method = "D6F4E42EEB656BF1400ED6F932EF278B")
    @DSModeled(DSC.SAFE)
    public boolean hasStableIds() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.472 -0400", hash_original_method = "5BE178AB760CC925EF7E1111F1B4915D", hash_generated_method = "811252175843CCDF842E079E3B96FACD")
    @DSModeled(DSC.SAFE)
    public void registerDataSetObserver(DataSetObserver observer) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(observer.dsTaint);
        mDataSetObservable.registerObserver(observer);
        // ---------- Original Method ----------
        //mDataSetObservable.registerObserver(observer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.472 -0400", hash_original_method = "8548074F279CEB9C75C60995B3E76B4B", hash_generated_method = "CBB7E927B1F7161B4FF823B366BA6706")
    @DSModeled(DSC.SAFE)
    public void unregisterDataSetObserver(DataSetObserver observer) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(observer.dsTaint);
        mDataSetObservable.unregisterObserver(observer);
        // ---------- Original Method ----------
        //mDataSetObservable.unregisterObserver(observer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.472 -0400", hash_original_method = "6B5DF5B4CDDD51D923DE488520E93535", hash_generated_method = "9FF149D08E5F5B95EA31B96492E2E567")
    @DSModeled(DSC.SAFE)
    public void notifyDataSetChanged() {
        mDataSetObservable.notifyChanged();
        // ---------- Original Method ----------
        //mDataSetObservable.notifyChanged();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.472 -0400", hash_original_method = "733D96117EC068A88A560CFA24913D79", hash_generated_method = "6FB1135D11C710B5252DB785E8C94828")
    @DSModeled(DSC.SAFE)
    public void notifyDataSetInvalidated() {
        mDataSetObservable.notifyInvalidated();
        // ---------- Original Method ----------
        //mDataSetObservable.notifyInvalidated();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.472 -0400", hash_original_method = "DC1745DFF85763BBC0B3711D531FD60B", hash_generated_method = "39502AFDC5AEDE02B1A27CD3CFBFDE29")
    @DSModeled(DSC.SAFE)
    public boolean areAllItemsEnabled() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.472 -0400", hash_original_method = "C1B9753B52C20D50833727AFD33E53F1", hash_generated_method = "C2495ED640EC744687F6A1367D8A9D68")
    @DSModeled(DSC.SAFE)
    public boolean isEnabled(int position) {
        dsTaint.addTaint(position);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.472 -0400", hash_original_method = "CB37ABFEFF70AAB623ABE3C5C5654EBA", hash_generated_method = "79F507EE0F55642E28963860C7350DAC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        dsTaint.addTaint(position);
        dsTaint.addTaint(parent.dsTaint);
        dsTaint.addTaint(convertView.dsTaint);
        View var97492F0E731BBC1717D513B00D6780A5_33199069 = (getView(position, convertView, parent));
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return getView(position, convertView, parent);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.472 -0400", hash_original_method = "EE97D094FF23924861F9B1BB9874462B", hash_generated_method = "B1EE40DAC12DCAF860DB008F9464A426")
    @DSModeled(DSC.SAFE)
    public int getItemViewType(int position) {
        dsTaint.addTaint(position);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.472 -0400", hash_original_method = "A6079B88B18082AA3C7D7E460D2C3B87", hash_generated_method = "62D482665DDDE1A9270E005B7B346B4A")
    @DSModeled(DSC.SAFE)
    public int getViewTypeCount() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.472 -0400", hash_original_method = "837A179B327E763126CB6909C28E4F2B", hash_generated_method = "DBAED46A733D7187DBB4CA3D9808C881")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isEmpty() {
        boolean varADA608D398DBF5C72CB16CE000ED04D6_495902564 = (getCount() == 0);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return getCount() == 0;
    }

    
}


