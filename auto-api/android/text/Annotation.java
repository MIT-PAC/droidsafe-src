package android.text;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Parcel;

public class Annotation implements ParcelableSpan {
    private String mKey;
    private String mValue;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.958 -0400", hash_original_method = "5C517E50CA4FB031ECF94CDBC8F3DBD0", hash_generated_method = "B3967F35E68601620DCC70FC7A04545C")
    @DSModeled(DSC.SAFE)
    public Annotation(String key, String value) {
        dsTaint.addTaint(value);
        dsTaint.addTaint(key);
        // ---------- Original Method ----------
        //mKey = key;
        //mValue = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.959 -0400", hash_original_method = "C131D9D20BBD02754AB0621772B33421", hash_generated_method = "7C617DC718892DE887DDE18ADB4AC045")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Annotation(Parcel src) {
        dsTaint.addTaint(src.dsTaint);
        mKey = src.readString();
        mValue = src.readString();
        // ---------- Original Method ----------
        //mKey = src.readString();
        //mValue = src.readString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.960 -0400", hash_original_method = "4B5D387D9B07EBC2B6CC4E1F3474D3AE", hash_generated_method = "ADE107A69302DAE79C35B1168B2F878B")
    @DSModeled(DSC.SAFE)
    public int getSpanTypeId() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return TextUtils.ANNOTATION;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.960 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.960 -0400", hash_original_method = "5E98CA8EC4399E1C3E6F7EE2C72DE36F", hash_generated_method = "91E8B111D8A38B7F5D3C14949CC67901")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(dest.dsTaint);
        dest.writeString(mKey);
        dest.writeString(mValue);
        // ---------- Original Method ----------
        //dest.writeString(mKey);
        //dest.writeString(mValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.960 -0400", hash_original_method = "E0CEA0C6ABDC55C32B991C1D155B5E3E", hash_generated_method = "8C4749A4D45BDEA86424E2138EE82723")
    @DSModeled(DSC.SAFE)
    public String getKey() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mKey;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.961 -0400", hash_original_method = "20F1B7D715A473C2ABE076C27B2A3109", hash_generated_method = "682C7B13FB2DDC74B6EDDACE11A3B1AF")
    @DSModeled(DSC.SAFE)
    public String getValue() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mValue;
    }

    
}

