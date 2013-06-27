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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.928 -0400", hash_original_field = "DEB4CF927428CCF05DDA4EF4FEB1005E", hash_generated_field = "72B7909438DD6FEADC92BE27BA79AE37")

    private DataSetObservable mDataSetObservable = new DataSetObservable();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.928 -0400", hash_original_method = "EEED7294B951806F43EBCF63B2A0F4D8", hash_generated_method = "EEED7294B951806F43EBCF63B2A0F4D8")
    public BaseAdapter ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.929 -0400", hash_original_method = "715CB29FF3CEE320E11EC1BD997C9D63", hash_generated_method = "3826B8A607B85AAEEC2DF823C7B5E908")
    public boolean hasStableIds() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_375671838 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_375671838;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.929 -0400", hash_original_method = "5BE178AB760CC925EF7E1111F1B4915D", hash_generated_method = "D80BACDB53770E495497918A52F212CE")
    public void registerDataSetObserver(DataSetObserver observer) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        mDataSetObservable.registerObserver(observer);
        addTaint(observer.getTaint());
        // ---------- Original Method ----------
        //mDataSetObservable.registerObserver(observer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.930 -0400", hash_original_method = "8548074F279CEB9C75C60995B3E76B4B", hash_generated_method = "18957645919BC1B25C95D955828DA072")
    public void unregisterDataSetObserver(DataSetObserver observer) {
        mDataSetObservable.unregisterObserver(observer);
        addTaint(observer.getTaint());
        // ---------- Original Method ----------
        //mDataSetObservable.unregisterObserver(observer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.931 -0400", hash_original_method = "6B5DF5B4CDDD51D923DE488520E93535", hash_generated_method = "3158F3A56E63A128E4489E6003CA7FEA")
    public void notifyDataSetChanged() {
        mDataSetObservable.notifyChanged();
        // ---------- Original Method ----------
        //mDataSetObservable.notifyChanged();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.942 -0400", hash_original_method = "733D96117EC068A88A560CFA24913D79", hash_generated_method = "A7F0E4AF3D0109D819E8AFDA57AB77CC")
    public void notifyDataSetInvalidated() {
        mDataSetObservable.notifyInvalidated();
        // ---------- Original Method ----------
        //mDataSetObservable.notifyInvalidated();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.943 -0400", hash_original_method = "DC1745DFF85763BBC0B3711D531FD60B", hash_generated_method = "681469B68588B9572C05691F0D6B4FEA")
    public boolean areAllItemsEnabled() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1255859616 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1255859616;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.943 -0400", hash_original_method = "C1B9753B52C20D50833727AFD33E53F1", hash_generated_method = "89FA9B1E8058D47D12347427CD616E79")
    public boolean isEnabled(int position) {
        addTaint(position);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_899858574 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_899858574;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.944 -0400", hash_original_method = "CB37ABFEFF70AAB623ABE3C5C5654EBA", hash_generated_method = "FEF814B14D51D2A6B412120FDA3C64FC")
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        View varB4EAC82CA7396A68D541C85D26508E83_2109298121 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2109298121 = getView(position, convertView, parent);
        addTaint(position);
        addTaint(convertView.getTaint());
        addTaint(parent.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2109298121.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2109298121;
        // ---------- Original Method ----------
        //return getView(position, convertView, parent);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.944 -0400", hash_original_method = "EE97D094FF23924861F9B1BB9874462B", hash_generated_method = "B9BAF2D6FEF9868F5AE09CB5F7D79E31")
    public int getItemViewType(int position) {
        addTaint(position);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1109653619 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1109653619;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.944 -0400", hash_original_method = "A6079B88B18082AA3C7D7E460D2C3B87", hash_generated_method = "730B73F5DBE7633F9805EF1E8F269D59")
    public int getViewTypeCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_139392213 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_139392213;
        // ---------- Original Method ----------
        //return 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.955 -0400", hash_original_method = "837A179B327E763126CB6909C28E4F2B", hash_generated_method = "1A2CD3B1038B9635241A5654BEDFCB93")
    public boolean isEmpty() {
        boolean varADA608D398DBF5C72CB16CE000ED04D6_872392138 = (getCount() == 0);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_225733328 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_225733328;
        // ---------- Original Method ----------
        //return getCount() == 0;
    }

    
}

