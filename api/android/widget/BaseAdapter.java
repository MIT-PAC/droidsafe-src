package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;

public abstract class BaseAdapter implements ListAdapter, SpinnerAdapter {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.580 -0400", hash_original_field = "DEB4CF927428CCF05DDA4EF4FEB1005E", hash_generated_field = "1CDD3690953D684D62F0461546A52041")

    private final DataSetObservable mDataSetObservable = new DataSetObservable();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.580 -0400", hash_original_method = "EEED7294B951806F43EBCF63B2A0F4D8", hash_generated_method = "EEED7294B951806F43EBCF63B2A0F4D8")
    public BaseAdapter ()
    {
        //Synthesized constructor
    }


    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.581 -0400", hash_original_method = "715CB29FF3CEE320E11EC1BD997C9D63", hash_generated_method = "FDDA96E0F55F07E67D27BBD6CBA22EFC")
    public boolean hasStableIds() {
        boolean var68934A3E9455FA72420237EB05902327_189962843 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_827142264 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_827142264;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.581 -0400", hash_original_method = "5BE178AB760CC925EF7E1111F1B4915D", hash_generated_method = "F16E110729CB74D6A482E558D8B8E47B")
    public void registerDataSetObserver(DataSetObserver observer) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(observer.getTaint());
        mDataSetObservable.registerObserver(observer);
        // ---------- Original Method ----------
        //mDataSetObservable.registerObserver(observer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.581 -0400", hash_original_method = "8548074F279CEB9C75C60995B3E76B4B", hash_generated_method = "55A6C9663FBA723DF8786E07BEFE465A")
    public void unregisterDataSetObserver(DataSetObserver observer) {
        addTaint(observer.getTaint());
        mDataSetObservable.unregisterObserver(observer);
        // ---------- Original Method ----------
        //mDataSetObservable.unregisterObserver(observer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.581 -0400", hash_original_method = "6B5DF5B4CDDD51D923DE488520E93535", hash_generated_method = "3158F3A56E63A128E4489E6003CA7FEA")
    public void notifyDataSetChanged() {
        mDataSetObservable.notifyChanged();
        // ---------- Original Method ----------
        //mDataSetObservable.notifyChanged();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.582 -0400", hash_original_method = "733D96117EC068A88A560CFA24913D79", hash_generated_method = "A7F0E4AF3D0109D819E8AFDA57AB77CC")
    public void notifyDataSetInvalidated() {
        mDataSetObservable.notifyInvalidated();
        // ---------- Original Method ----------
        //mDataSetObservable.notifyInvalidated();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.582 -0400", hash_original_method = "DC1745DFF85763BBC0B3711D531FD60B", hash_generated_method = "D01CD91996E4665D44DA46EA5D07D8F6")
    public boolean areAllItemsEnabled() {
        boolean varB326B5062B2F0E69046810717534CB09_1676371278 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_975585437 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_975585437;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.582 -0400", hash_original_method = "C1B9753B52C20D50833727AFD33E53F1", hash_generated_method = "0F3999A52685FBCFC052C2C369706959")
    public boolean isEnabled(int position) {
        addTaint(position);
        boolean varB326B5062B2F0E69046810717534CB09_2144287307 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_828137809 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_828137809;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.582 -0400", hash_original_method = "CB37ABFEFF70AAB623ABE3C5C5654EBA", hash_generated_method = "D6F1C944898BFCB0CC8573EA6D35093E")
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        addTaint(parent.getTaint());
        addTaint(convertView.getTaint());
        addTaint(position);
View var07BEEB65197AB6DA2760E163F2697E6C_2131329151 =         getView(position, convertView, parent);
        var07BEEB65197AB6DA2760E163F2697E6C_2131329151.addTaint(taint);
        return var07BEEB65197AB6DA2760E163F2697E6C_2131329151;
        // ---------- Original Method ----------
        //return getView(position, convertView, parent);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.583 -0400", hash_original_method = "EE97D094FF23924861F9B1BB9874462B", hash_generated_method = "E37C495FD817E0BD73D4CC0F51E46011")
    public int getItemViewType(int position) {
        addTaint(position);
        int varCFCD208495D565EF66E7DFF9F98764DA_38085126 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1565206014 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1565206014;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.583 -0400", hash_original_method = "A6079B88B18082AA3C7D7E460D2C3B87", hash_generated_method = "8DA8C640AD5D5D6A1B76796E4CA3C48A")
    public int getViewTypeCount() {
        int varC4CA4238A0B923820DCC509A6F75849B_1896896149 = (1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2028098118 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2028098118;
        // ---------- Original Method ----------
        //return 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.583 -0400", hash_original_method = "837A179B327E763126CB6909C28E4F2B", hash_generated_method = "B70D2537B34EFD1773B8C538CA14710D")
    public boolean isEmpty() {
        boolean varA8BDE4853B46678F6434AC4599BE04DB_904159153 = (getCount() == 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2142846844 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2142846844;
        // ---------- Original Method ----------
        //return getCount() == 0;
    }

    
}

