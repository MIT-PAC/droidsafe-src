package android.text.style;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.os.Parcel;
import android.text.ParcelableSpan;
import android.text.TextPaint;
import android.text.TextUtils;

public class UnderlineSpan extends CharacterStyle implements UpdateAppearance, ParcelableSpan {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.033 -0400", hash_original_method = "0961EBA9EB7C20D52B677528162BDFE2", hash_generated_method = "7390F9D5E0BC1E526CED5304868F9B88")
    public  UnderlineSpan() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.033 -0400", hash_original_method = "2F10E98AFC8F657229593A567035B72B", hash_generated_method = "7760FAFCB018CA151139F1A8E40D2AAC")
    public  UnderlineSpan(Parcel src) {
        addTaint(src.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.034 -0400", hash_original_method = "98FDD0C5C920ADC9B5642E26AAA3CBE6", hash_generated_method = "10F0C8BA65B2DD0B1A00B09FB482ACA9")
    public int getSpanTypeId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_258255344 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_258255344;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.034 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "1BFDCC94E6CFD845F56CE2CE468C7FEF")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_664829520 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_664829520;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.034 -0400", hash_original_method = "36081754C4A09732AEC95BB21FA0BDE7", hash_generated_method = "E7DBC20584A55C26974D54383A48E9F7")
    public void writeToParcel(Parcel dest, int flags) {
        addTaint(dest.getTaint());
        addTaint(flags);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.035 -0400", hash_original_method = "0AB5A88A5517CF0706AB68CD6097189A", hash_generated_method = "B63DA487A3B75D8CFA02C746550EAD94")
    @Override
    public void updateDrawState(TextPaint ds) {
        ds.setUnderlineText(true);
        addTaint(ds.getTaint());
        
        
    }

    
}

