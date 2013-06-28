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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.987 -0400", hash_original_field = "DEB4CF927428CCF05DDA4EF4FEB1005E", hash_generated_field = "1CDD3690953D684D62F0461546A52041")

    private final DataSetObservable mDataSetObservable = new DataSetObservable();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.987 -0400", hash_original_method = "EEED7294B951806F43EBCF63B2A0F4D8", hash_generated_method = "EEED7294B951806F43EBCF63B2A0F4D8")
    public BaseAdapter ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.988 -0400", hash_original_method = "715CB29FF3CEE320E11EC1BD997C9D63", hash_generated_method = "BC933DFF67DB01C7F5DA9B114DC28300")
    public boolean hasStableIds() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_607704218 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_607704218;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.989 -0400", hash_original_method = "5BE178AB760CC925EF7E1111F1B4915D", hash_generated_method = "D80BACDB53770E495497918A52F212CE")
    public void registerDataSetObserver(DataSetObserver observer) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        mDataSetObservable.registerObserver(observer);
        addTaint(observer.getTaint());
        // ---------- Original Method ----------
        //mDataSetObservable.registerObserver(observer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.989 -0400", hash_original_method = "8548074F279CEB9C75C60995B3E76B4B", hash_generated_method = "18957645919BC1B25C95D955828DA072")
    public void unregisterDataSetObserver(DataSetObserver observer) {
        mDataSetObservable.unregisterObserver(observer);
        addTaint(observer.getTaint());
        // ---------- Original Method ----------
        //mDataSetObservable.unregisterObserver(observer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.990 -0400", hash_original_method = "6B5DF5B4CDDD51D923DE488520E93535", hash_generated_method = "3158F3A56E63A128E4489E6003CA7FEA")
    public void notifyDataSetChanged() {
        mDataSetObservable.notifyChanged();
        // ---------- Original Method ----------
        //mDataSetObservable.notifyChanged();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.990 -0400", hash_original_method = "733D96117EC068A88A560CFA24913D79", hash_generated_method = "A7F0E4AF3D0109D819E8AFDA57AB77CC")
    public void notifyDataSetInvalidated() {
        mDataSetObservable.notifyInvalidated();
        // ---------- Original Method ----------
        //mDataSetObservable.notifyInvalidated();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.990 -0400", hash_original_method = "DC1745DFF85763BBC0B3711D531FD60B", hash_generated_method = "413B321F5B6C77C88D5A2E10BDA15174")
    public boolean areAllItemsEnabled() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1155321079 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1155321079;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.991 -0400", hash_original_method = "C1B9753B52C20D50833727AFD33E53F1", hash_generated_method = "366F74D2B30318BBA7C006EC2F953A8B")
    public boolean isEnabled(int position) {
        addTaint(position);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1718271716 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1718271716;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.991 -0400", hash_original_method = "CB37ABFEFF70AAB623ABE3C5C5654EBA", hash_generated_method = "C0F0085E7ABE4723B160BB6494096250")
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        View varB4EAC82CA7396A68D541C85D26508E83_544784565 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_544784565 = getView(position, convertView, parent);
        addTaint(position);
        addTaint(convertView.getTaint());
        addTaint(parent.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_544784565.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_544784565;
        // ---------- Original Method ----------
        //return getView(position, convertView, parent);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.992 -0400", hash_original_method = "EE97D094FF23924861F9B1BB9874462B", hash_generated_method = "108D8DEC4F6AC7CEFFD634DF2F0A1300")
    public int getItemViewType(int position) {
        addTaint(position);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1452688055 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1452688055;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.992 -0400", hash_original_method = "A6079B88B18082AA3C7D7E460D2C3B87", hash_generated_method = "9F2D699FF1A2CFD3327838592E9CDDC4")
    public int getViewTypeCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1055157175 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1055157175;
        // ---------- Original Method ----------
        //return 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.992 -0400", hash_original_method = "837A179B327E763126CB6909C28E4F2B", hash_generated_method = "E15E29D05C7030A1D9D167C98CF066F3")
    public boolean isEmpty() {
        boolean varADA608D398DBF5C72CB16CE000ED04D6_961479155 = (getCount() == 0);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1262501464 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1262501464;
        // ---------- Original Method ----------
        //return getCount() == 0;
    }

    
}

