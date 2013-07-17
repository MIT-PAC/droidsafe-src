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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.713 -0400", hash_original_field = "DEB4CF927428CCF05DDA4EF4FEB1005E", hash_generated_field = "1CDD3690953D684D62F0461546A52041")

    private final DataSetObservable mDataSetObservable = new DataSetObservable();
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.714 -0400", hash_original_method = "EEED7294B951806F43EBCF63B2A0F4D8", hash_generated_method = "EEED7294B951806F43EBCF63B2A0F4D8")
    public BaseAdapter ()
    {
        //Synthesized constructor
    }


        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.714 -0400", hash_original_method = "715CB29FF3CEE320E11EC1BD997C9D63", hash_generated_method = "0F58B52235174BF8C3218345DA3CEDCE")
    public boolean hasStableIds() {
        boolean var68934A3E9455FA72420237EB05902327_920814190 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_683902587 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_683902587;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.714 -0400", hash_original_method = "5BE178AB760CC925EF7E1111F1B4915D", hash_generated_method = "F16E110729CB74D6A482E558D8B8E47B")
    public void registerDataSetObserver(DataSetObserver observer) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(observer.getTaint());
        mDataSetObservable.registerObserver(observer);
        // ---------- Original Method ----------
        //mDataSetObservable.registerObserver(observer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.714 -0400", hash_original_method = "8548074F279CEB9C75C60995B3E76B4B", hash_generated_method = "55A6C9663FBA723DF8786E07BEFE465A")
    public void unregisterDataSetObserver(DataSetObserver observer) {
        addTaint(observer.getTaint());
        mDataSetObservable.unregisterObserver(observer);
        // ---------- Original Method ----------
        //mDataSetObservable.unregisterObserver(observer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.714 -0400", hash_original_method = "6B5DF5B4CDDD51D923DE488520E93535", hash_generated_method = "3158F3A56E63A128E4489E6003CA7FEA")
    public void notifyDataSetChanged() {
        mDataSetObservable.notifyChanged();
        // ---------- Original Method ----------
        //mDataSetObservable.notifyChanged();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.714 -0400", hash_original_method = "733D96117EC068A88A560CFA24913D79", hash_generated_method = "A7F0E4AF3D0109D819E8AFDA57AB77CC")
    public void notifyDataSetInvalidated() {
        mDataSetObservable.notifyInvalidated();
        // ---------- Original Method ----------
        //mDataSetObservable.notifyInvalidated();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.714 -0400", hash_original_method = "DC1745DFF85763BBC0B3711D531FD60B", hash_generated_method = "3A8B5610ED266040EC04E5C10545B8D2")
    public boolean areAllItemsEnabled() {
        boolean varB326B5062B2F0E69046810717534CB09_500319594 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1577985598 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1577985598;
        // ---------- Original Method ----------
        //return true;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.714 -0400", hash_original_method = "C1B9753B52C20D50833727AFD33E53F1", hash_generated_method = "07F8219FFED933B821D1B39152F3F24B")
    public boolean isEnabled(int position) {
        addTaint(position);
        boolean varB326B5062B2F0E69046810717534CB09_2124574576 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2109332642 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2109332642;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.714 -0400", hash_original_method = "CB37ABFEFF70AAB623ABE3C5C5654EBA", hash_generated_method = "E516B6CACEED68042F794339D81FBCE8")
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        addTaint(parent.getTaint());
        addTaint(convertView.getTaint());
        addTaint(position);
View var07BEEB65197AB6DA2760E163F2697E6C_48413631 =         getView(position, convertView, parent);
        var07BEEB65197AB6DA2760E163F2697E6C_48413631.addTaint(taint);
        return var07BEEB65197AB6DA2760E163F2697E6C_48413631;
        // ---------- Original Method ----------
        //return getView(position, convertView, parent);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.714 -0400", hash_original_method = "EE97D094FF23924861F9B1BB9874462B", hash_generated_method = "F8A9F8D761787B060F4968823DD95382")
    public int getItemViewType(int position) {
        addTaint(position);
        int varCFCD208495D565EF66E7DFF9F98764DA_1368457692 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_975049290 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_975049290;
        // ---------- Original Method ----------
        //return 0;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.714 -0400", hash_original_method = "A6079B88B18082AA3C7D7E460D2C3B87", hash_generated_method = "406AFE32BF588F147FB5B4C1329E55B6")
    public int getViewTypeCount() {
        int varC4CA4238A0B923820DCC509A6F75849B_1729528405 = (1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1120417159 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1120417159;
        // ---------- Original Method ----------
        //return 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.715 -0400", hash_original_method = "837A179B327E763126CB6909C28E4F2B", hash_generated_method = "BF0B5091935C02590D9021708A0BD67B")
    public boolean isEmpty() {
        boolean varA8BDE4853B46678F6434AC4599BE04DB_1477259312 = (getCount() == 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1004994424 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1004994424;
        // ---------- Original Method ----------
        //return getCount() == 0;
    }

    
}

