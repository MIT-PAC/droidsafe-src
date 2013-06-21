package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Parcel;
import android.os.Parcelable;

public class SmsRawData implements Parcelable {
    byte[] data;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.504 -0400", hash_original_method = "786E0C6936F82B829DA5B3FF66BF9330", hash_generated_method = "828B5676A7B923BC0F49FA4966EE9AB3")
    @DSModeled(DSC.SAFE)
    public SmsRawData(byte[] data) {
        dsTaint.addTaint(data[0]);
        // ---------- Original Method ----------
        //this.data = data;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.504 -0400", hash_original_method = "A347A6B90A5D4D940F0721005973D58D", hash_generated_method = "8E69EC1BF2858EA7248071FD2E008249")
    @DSModeled(DSC.SAFE)
    public byte[] getBytes() {
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //return data;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.505 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.505 -0400", hash_original_method = "D4C3CA886CA029713C39962D7FB3C06B", hash_generated_method = "D2E4FCFBB037FC8A092D2732086C1141")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(dest.dsTaint);
        dest.writeInt(data.length);
        dest.writeByteArray(data);
        // ---------- Original Method ----------
        //dest.writeInt(data.length);
        //dest.writeByteArray(data);
    }

    
    public static final Parcelable.Creator<SmsRawData> CREATOR = new Parcelable.Creator<SmsRawData>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.505 -0400", hash_original_method = "F1422F1901EE9861E97E875C16081393", hash_generated_method = "F257B9D2BF8027271A72B746FD2E328D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public SmsRawData createFromParcel(Parcel source) {
            dsTaint.addTaint(source.dsTaint);
            int size;
            size = source.readInt();
            byte[] data;
            data = new byte[size];
            source.readByteArray(data);
            SmsRawData var97FDD150E6627C11FC1FB1D3950DF6B9_1169182224 = (new SmsRawData(data));
            return (SmsRawData)dsTaint.getTaint();
            // ---------- Original Method ----------
            //int size;
            //size = source.readInt();
            //byte[] data = new byte[size];
            //source.readByteArray(data);
            //return new SmsRawData(data);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.505 -0400", hash_original_method = "A7CDF66D285B3D1FAFEC746019F799D8", hash_generated_method = "34BF3AC0CB6FAA28D914AE2552CF596B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public SmsRawData[] newArray(int size) {
            dsTaint.addTaint(size);
            SmsRawData[] var7B34D0C8E7A6A8A9C225CBD47E9E3F58_982233116 = (new SmsRawData[size]);
            return (SmsRawData[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new SmsRawData[size];
        }

        
}; //Transformed anonymous class
}

