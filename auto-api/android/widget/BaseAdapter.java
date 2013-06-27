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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.400 -0400", hash_original_field = "DEB4CF927428CCF05DDA4EF4FEB1005E", hash_generated_field = "72B7909438DD6FEADC92BE27BA79AE37")

    private DataSetObservable mDataSetObservable = new DataSetObservable();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.401 -0400", hash_original_method = "EEED7294B951806F43EBCF63B2A0F4D8", hash_generated_method = "EEED7294B951806F43EBCF63B2A0F4D8")
    public BaseAdapter ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.401 -0400", hash_original_method = "715CB29FF3CEE320E11EC1BD997C9D63", hash_generated_method = "AAC8A5667538B36E2816A41816E476CE")
    public boolean hasStableIds() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_621989532 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_621989532;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.401 -0400", hash_original_method = "5BE178AB760CC925EF7E1111F1B4915D", hash_generated_method = "D80BACDB53770E495497918A52F212CE")
    public void registerDataSetObserver(DataSetObserver observer) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        mDataSetObservable.registerObserver(observer);
        addTaint(observer.getTaint());
        // ---------- Original Method ----------
        //mDataSetObservable.registerObserver(observer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.409 -0400", hash_original_method = "8548074F279CEB9C75C60995B3E76B4B", hash_generated_method = "18957645919BC1B25C95D955828DA072")
    public void unregisterDataSetObserver(DataSetObserver observer) {
        mDataSetObservable.unregisterObserver(observer);
        addTaint(observer.getTaint());
        // ---------- Original Method ----------
        //mDataSetObservable.unregisterObserver(observer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.416 -0400", hash_original_method = "6B5DF5B4CDDD51D923DE488520E93535", hash_generated_method = "3158F3A56E63A128E4489E6003CA7FEA")
    public void notifyDataSetChanged() {
        mDataSetObservable.notifyChanged();
        // ---------- Original Method ----------
        //mDataSetObservable.notifyChanged();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.417 -0400", hash_original_method = "733D96117EC068A88A560CFA24913D79", hash_generated_method = "A7F0E4AF3D0109D819E8AFDA57AB77CC")
    public void notifyDataSetInvalidated() {
        mDataSetObservable.notifyInvalidated();
        // ---------- Original Method ----------
        //mDataSetObservable.notifyInvalidated();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.417 -0400", hash_original_method = "DC1745DFF85763BBC0B3711D531FD60B", hash_generated_method = "4CEE6F0A1201DA27A8185BB2C1CCF3CF")
    public boolean areAllItemsEnabled() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1213627137 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1213627137;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.417 -0400", hash_original_method = "C1B9753B52C20D50833727AFD33E53F1", hash_generated_method = "9D353626952C2B8DA1B0FA544EDC8517")
    public boolean isEnabled(int position) {
        addTaint(position);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_325701254 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_325701254;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.418 -0400", hash_original_method = "CB37ABFEFF70AAB623ABE3C5C5654EBA", hash_generated_method = "349A9D4AC21B61D2CBD4E987FA3DF340")
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        View varB4EAC82CA7396A68D541C85D26508E83_1860307668 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1860307668 = getView(position, convertView, parent);
        addTaint(position);
        addTaint(convertView.getTaint());
        addTaint(parent.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1860307668.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1860307668;
        // ---------- Original Method ----------
        //return getView(position, convertView, parent);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.418 -0400", hash_original_method = "EE97D094FF23924861F9B1BB9874462B", hash_generated_method = "07AAF04A74597A6C6B6F3E9505A648E3")
    public int getItemViewType(int position) {
        addTaint(position);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1287434352 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1287434352;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.435 -0400", hash_original_method = "A6079B88B18082AA3C7D7E460D2C3B87", hash_generated_method = "029A8544D397492FB671CB760F57B31C")
    public int getViewTypeCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1447383860 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1447383860;
        // ---------- Original Method ----------
        //return 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.436 -0400", hash_original_method = "837A179B327E763126CB6909C28E4F2B", hash_generated_method = "4AA615EF9B58946C26DA7B02187C5D88")
    public boolean isEmpty() {
        boolean varADA608D398DBF5C72CB16CE000ED04D6_3915530 = (getCount() == 0);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_248147501 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_248147501;
        // ---------- Original Method ----------
        //return getCount() == 0;
    }

    
}

