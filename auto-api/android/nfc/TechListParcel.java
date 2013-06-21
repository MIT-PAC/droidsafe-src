package android.nfc;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Parcel;
import android.os.Parcelable;

public class TechListParcel implements Parcelable {
    private String[][] mTechLists;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.125 -0400", hash_original_method = "6AB5FDB623A6EE108E2E4847F2947558", hash_generated_method = "02983D8CBE5D12B89A3EF74F2F6C5F17")
    @DSModeled(DSC.SAFE)
    public TechListParcel(String[]... strings) {
        dsTaint.addTaint(strings[0][0]);
        // ---------- Original Method ----------
        //mTechLists = strings;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.125 -0400", hash_original_method = "6EF67533858F398D5EC0425F1D475F89", hash_generated_method = "A9EEC7B69412C1898874B16AD29DD76B")
    @DSModeled(DSC.SAFE)
    public String[][] getTechLists() {
        return (String[][])dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mTechLists;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.125 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "0DB50BC0CCE4711867E95DEC1B2117C7")
    @DSModeled(DSC.SAFE)
    @Override
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.127 -0400", hash_original_method = "B19E49B45A2ACFBF18675BF33A9FB41F", hash_generated_method = "2DB3A54A5F9A94D81C819E9D18FFAD75")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(dest.dsTaint);
        int count;
        count = mTechLists.length;
        dest.writeInt(count);
        {
            int i;
            i = 0;
            {
                String[] techList;
                techList = mTechLists[i];
                dest.writeStringArray(techList);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //int count = mTechLists.length;
        //dest.writeInt(count);
        //for (int i = 0; i < count; i++) {
            //String[] techList = mTechLists[i];
            //dest.writeStringArray(techList);
        //}
    }

    
    public static final Creator<TechListParcel> CREATOR = new Creator<TechListParcel>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.128 -0400", hash_original_method = "24B5B0F43AE1F40832E0294086D57B0A", hash_generated_method = "E77A3827510153618B9EC85E80A75D65")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public TechListParcel createFromParcel(Parcel source) {
            dsTaint.addTaint(source.dsTaint);
            int count;
            count = source.readInt();
            String[][] techLists;
            techLists = new String[count][];
            {
                int i;
                i = 0;
                {
                    techLists[i] = source.readStringArray();
                } //End block
            } //End collapsed parenthetic
            TechListParcel varB5C4262E7689ACCC2C61AB84B3ADBF8F_1214530238 = (new TechListParcel(techLists));
            return (TechListParcel)dsTaint.getTaint();
            // ---------- Original Method ----------
            //int count = source.readInt();
            //String[][] techLists = new String[count][];
            //for (int i = 0; i < count; i++) {
                //techLists[i] = source.readStringArray();
            //}
            //return new TechListParcel(techLists);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.128 -0400", hash_original_method = "61CA68758CEDCBD410FFB44FD4FB304C", hash_generated_method = "FD1F1BD39801BECD678B414821076327")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public TechListParcel[] newArray(int size) {
            dsTaint.addTaint(size);
            TechListParcel[] varA6B68E78909EB2136E8F5E0BD43675DD_257383530 = (new TechListParcel[size]);
            return (TechListParcel[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new TechListParcel[size];
        }

        
}; //Transformed anonymous class
}

