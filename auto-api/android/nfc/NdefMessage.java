package android.nfc;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Parcel;
import android.os.Parcelable;

public final class NdefMessage implements Parcelable {
    private NdefRecord[] mRecords;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.934 -0400", hash_original_method = "745916B1AE6188C8022A7E21DA1360C3", hash_generated_method = "AE62B8EA1E7DCDDB5EEF494ED54040B6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public NdefMessage(byte[] data) throws FormatException {
        dsTaint.addTaint(data[0]);
        mRecords = null;
        {
            boolean varAA4C11B4345CE90310CEDDAB0AF4349A_432372615 = (parseNdefMessage(data) == -1);
            {
                if (DroidSafeAndroidRuntime.control) throw new FormatException("Error while parsing NDEF message");
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //mRecords = null;
        //if (parseNdefMessage(data) == -1) {
            //throw new FormatException("Error while parsing NDEF message");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.934 -0400", hash_original_method = "E87B5EF1F7D5816785326D2A488F5505", hash_generated_method = "B9AE5089EB56369AED4D87B9C3AE1233")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public NdefMessage(NdefRecord[] records) {
        dsTaint.addTaint(records[0].dsTaint);
        mRecords = new NdefRecord[records.length];
        System.arraycopy(records, 0, mRecords, 0, records.length);
        // ---------- Original Method ----------
        //mRecords = new NdefRecord[records.length];
        //System.arraycopy(records, 0, mRecords, 0, records.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.935 -0400", hash_original_method = "482F2AD23FF4C5B364DE9FB97EDDBB64", hash_generated_method = "BE89CFD3AD0348667F2969061A460CEA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public NdefRecord[] getRecords() {
        NdefRecord[] var1FDE30C3BDE5EFF8D527547FD4D4D201_841388180 = (mRecords.clone());
        return (NdefRecord[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mRecords.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.935 -0400", hash_original_method = "8C1624491EC0DD58CFD007740FE405D8", hash_generated_method = "9792FE7967EB9DCAFDB34B077D334643")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public byte[] toByteArray() {
        byte[] varCD2B5CAF7811FECE279C6AA98F83010C_892038324 = (new byte[0]);
        byte[] msg;
        {
            int i;
            i = 0;
            {
                byte[] record;
                record = mRecords[i].toByteArray();
                byte[] tmp;
                tmp = new byte[msg.length + record.length];
                {
                    record[0] |= FLAG_MB;
                } //End block
                {
                    record[0] &= ~FLAG_MB;
                } //End block
                {
                    record[0] |= FLAG_ME;
                } //End block
                {
                    record[0] &= ~FLAG_ME;
                } //End block
                System.arraycopy(msg, 0, tmp, 0, msg.length);
                System.arraycopy(record, 0, tmp, msg.length, record.length);
                msg = tmp;
            } //End block
        } //End collapsed parenthetic
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //if ((mRecords == null) || (mRecords.length == 0))
            //return new byte[0];
        //byte[] msg = {};
        //for (int i = 0; i < mRecords.length; i++) {
            //byte[] record = mRecords[i].toByteArray();
            //byte[] tmp = new byte[msg.length + record.length];
            //if (i == 0) {
                //record[0] |= FLAG_MB;
            //} else {
                //record[0] &= ~FLAG_MB;
            //}
            //if (i == (mRecords.length - 1)) {
                //record[0] |= FLAG_ME;
            //} else {
                //record[0] &= ~FLAG_ME;
            //}
            //System.arraycopy(msg, 0, tmp, 0, msg.length);
            //System.arraycopy(record, 0, tmp, msg.length, record.length);
            //msg = tmp;
        //}
        //return msg;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.935 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "0DB50BC0CCE4711867E95DEC1B2117C7")
    @DSModeled(DSC.SAFE)
    @Override
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.936 -0400", hash_original_method = "C32A271878CC7CE5578073C85AE449D6", hash_generated_method = "250923F314780A64AF3C6F175B1BBEAA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(dest.dsTaint);
        dest.writeInt(mRecords.length);
        dest.writeTypedArray(mRecords, flags);
        // ---------- Original Method ----------
        //dest.writeInt(mRecords.length);
        //dest.writeTypedArray(mRecords, flags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.936 -0400", hash_original_method = "58C82E5C0DBA98ED651A9002B9916229", hash_generated_method = "D8EF3BFE72156BF41F5F2E7433F035B0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int parseNdefMessage(byte[] data) {
        dsTaint.addTaint(data[0]);
        return dsTaint.getTaintInt();
    }

    
    private static final byte FLAG_MB = (byte) 0x80;
    private static final byte FLAG_ME = (byte) 0x40;
    public static final Parcelable.Creator<NdefMessage> CREATOR = new Parcelable.Creator<NdefMessage>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.936 -0400", hash_original_method = "2309D164C76EDDEB5F889CEC6615477A", hash_generated_method = "1E445403F810FDCAD6E01F4C110A06F1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public NdefMessage createFromParcel(Parcel in) {
            dsTaint.addTaint(in.dsTaint);
            int recordsLength;
            recordsLength = in.readInt();
            NdefRecord[] records;
            records = new NdefRecord[recordsLength];
            in.readTypedArray(records, NdefRecord.CREATOR);
            NdefMessage var2DAA2CF24F3608E1CE05938B9DB9E014_1517102208 = (new NdefMessage(records));
            return (NdefMessage)dsTaint.getTaint();
            // ---------- Original Method ----------
            //int recordsLength = in.readInt();
            //NdefRecord[] records = new NdefRecord[recordsLength];
            //in.readTypedArray(records, NdefRecord.CREATOR);
            //return new NdefMessage(records);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.936 -0400", hash_original_method = "05D7C97BB318FFABDF876446819990ED", hash_generated_method = "166CE99D854015F60E5E64F4333ECCD5")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public NdefMessage[] newArray(int size) {
            dsTaint.addTaint(size);
            NdefMessage[] var280774CCD4FF2E5BC2A788CAF3316FE3_649996141 = (new NdefMessage[size]);
            return (NdefMessage[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new NdefMessage[size];
        }

        
}; //Transformed anonymous class
}

