package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.os.Parcel;
import android.os.Parcelable;

public class SmsRawData implements Parcelable {
    byte[] data;
    public static final Parcelable.Creator<SmsRawData> CREATOR = new Parcelable.Creator<SmsRawData>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.579 -0400", hash_original_method = "F1422F1901EE9861E97E875C16081393", hash_generated_method = "5C90C9A69201949FC441C1F5CBC4331B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public SmsRawData createFromParcel(Parcel source) {
            dsTaint.addTaint(source.dsTaint);
            int size;
            size = source.readInt();
            byte[] data;
            data = new byte[size];
            source.readByteArray(data);
            return (SmsRawData)dsTaint.getTaint();
            // ---------- Original Method ----------
            //int size;
            //size = source.readInt();
            //byte[] data = new byte[size];
            //source.readByteArray(data);
            //return new SmsRawData(data);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.579 -0400", hash_original_method = "A7CDF66D285B3D1FAFEC746019F799D8", hash_generated_method = "01D5387B2AC49C1A20CE80EA31F9DB4E")
        @DSModeled(DSC.SAFE)
        public SmsRawData[] newArray(int size) {
            dsTaint.addTaint(size);
            return (SmsRawData[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new SmsRawData[size];
        }

        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.579 -0400", hash_original_method = "786E0C6936F82B829DA5B3FF66BF9330", hash_generated_method = "D4A1BFB4ED3E819DC3A4A772EBC8A599")
    @DSModeled(DSC.SAFE)
    public SmsRawData(byte[] data) {
        dsTaint.addTaint(data);
        // ---------- Original Method ----------
        //this.data = data;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.579 -0400", hash_original_method = "A347A6B90A5D4D940F0721005973D58D", hash_generated_method = "9BB273E590C70A9FDD852B03C9B54DAE")
    @DSModeled(DSC.SAFE)
    public byte[] getBytes() {
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //return data;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.579 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "7491C6FB42F78871A3F8EA322AF6B2FC")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.579 -0400", hash_original_method = "D4C3CA886CA029713C39962D7FB3C06B", hash_generated_method = "BFB0898ABEC3A1B3C33C5813A65D5A41")
    @DSModeled(DSC.SAFE)
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(dest.dsTaint);
        dsTaint.addTaint(flags);
        dest.writeInt(data.length);
        dest.writeByteArray(data);
        // ---------- Original Method ----------
        //dest.writeInt(data.length);
        //dest.writeByteArray(data);
    }

    
}


