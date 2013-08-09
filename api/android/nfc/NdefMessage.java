package android.nfc;

// Droidsafe Imports
import droidsafe.annotations.*;
import android.os.Parcel;
import android.os.Parcelable;





public final class NdefMessage implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.060 -0400", hash_original_field = "3B8204E6C5A7D4B4E9A58CC03885B8D6", hash_generated_field = "E68F4FE3D834F8AC778DFF66AE2BFB1B")

    private NdefRecord[] mRecords;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.061 -0400", hash_original_method = "745916B1AE6188C8022A7E21DA1360C3", hash_generated_method = "F90B054C4176D5639F72774EFE325447")
    public  NdefMessage(byte[] data) throws FormatException {
        addTaint(data[0]);
        mRecords = null;
        if(parseNdefMessage(data) == -1)        
        {
            FormatException var909CC158F8D0CD2718467C2758534619_467219049 = new FormatException("Error while parsing NDEF message");
            var909CC158F8D0CD2718467C2758534619_467219049.addTaint(taint);
            throw var909CC158F8D0CD2718467C2758534619_467219049;
        } //End block
        // ---------- Original Method ----------
        //mRecords = null;
        //if (parseNdefMessage(data) == -1) {
            //throw new FormatException("Error while parsing NDEF message");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.062 -0400", hash_original_method = "E87B5EF1F7D5816785326D2A488F5505", hash_generated_method = "CBDC2B7A3B5AEEA31D20F9D68D09A9D5")
    public  NdefMessage(NdefRecord[] records) {
        mRecords = new NdefRecord[records.length];
        System.arraycopy(records, 0, mRecords, 0, records.length);
        // ---------- Original Method ----------
        //mRecords = new NdefRecord[records.length];
        //System.arraycopy(records, 0, mRecords, 0, records.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.062 -0400", hash_original_method = "482F2AD23FF4C5B364DE9FB97EDDBB64", hash_generated_method = "85F105164155F9745EC94702519D6D87")
    public NdefRecord[] getRecords() {
NdefRecord[] varF67461EBF6F3AD62E0D22C61B69D5998_699909323 =         mRecords.clone();
        varF67461EBF6F3AD62E0D22C61B69D5998_699909323.addTaint(taint);
        return varF67461EBF6F3AD62E0D22C61B69D5998_699909323;
        // ---------- Original Method ----------
        //return mRecords.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.064 -0400", hash_original_method = "8C1624491EC0DD58CFD007740FE405D8", hash_generated_method = "3CDABC4599E9DD050610D843D4313351")
    public byte[] toByteArray() {
        if((mRecords == null) || (mRecords.length == 0))        
        {
        byte[] var7B44E8BB9C72EAD38A6BE351B1457003_1287968633 = (new byte[0]);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1239182386 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1239182386;
        }
        byte[] msg = {};
for(int i = 0;i < mRecords.length;i++)
        {
            byte[] record = mRecords[i].toByteArray();
            byte[] tmp = new byte[msg.length + record.length];
            if(i == 0)            
            {
                record[0] |= FLAG_MB;
            } //End block
            else
            {
                record[0] &= ~FLAG_MB;
            } //End block
            if(i == (mRecords.length - 1))            
            {
                record[0] |= FLAG_ME;
            } //End block
            else
            {
                record[0] &= ~FLAG_ME;
            } //End block
            System.arraycopy(msg, 0, tmp, 0, msg.length);
            System.arraycopy(record, 0, tmp, msg.length, record.length);
            msg = tmp;
        } //End block
        byte[] var6E2BAAF3B97DBEEF01C0043275F9A0E7_1053921853 = (msg);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_557849736 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_557849736;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.065 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "CB2F274E1D4A7377ECB5F1E31E394C43")
    @Override
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_196261591 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1836112879 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1836112879;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.066 -0400", hash_original_method = "C32A271878CC7CE5578073C85AE449D6", hash_generated_method = "A9E4C2BFDCA57B53CF9999456C609995")
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        addTaint(flags);
        addTaint(dest.getTaint());
        dest.writeInt(mRecords.length);
        dest.writeTypedArray(mRecords, flags);
        // ---------- Original Method ----------
        //dest.writeInt(mRecords.length);
        //dest.writeTypedArray(mRecords, flags);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.066 -0400", hash_original_method = "58C82E5C0DBA98ED651A9002B9916229", hash_generated_method = "EEFB6592707D41EE078E2C73FBF5548B")
    private int parseNdefMessage(byte[] data) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_209424021 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_209424021;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.066 -0400", hash_original_field = "2567A7778944BAE41EB778C6A0D3FB93", hash_generated_field = "3835A2DFF1178D58B5296641A8C4E94F")

    private static final byte FLAG_MB = (byte) 0x80;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.067 -0400", hash_original_field = "0469070E4DDB8009448612A49A33DD4B", hash_generated_field = "EB576068E134091F49CFF121FA3CF3C3")

    private static final byte FLAG_ME = (byte) 0x40;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.067 -0400", hash_original_field = "127706CA0B98ABA8AC707A7A7B7E3A13", hash_generated_field = "19F680E50E23F4E29F6607B0A7E9E716")

    public static final Parcelable.Creator<NdefMessage> CREATOR =
            new Parcelable.Creator<NdefMessage>() {
        @Override
        public NdefMessage createFromParcel(Parcel in) {
            int recordsLength = in.readInt();
            NdefRecord[] records = new NdefRecord[recordsLength];
            in.readTypedArray(records, NdefRecord.CREATOR);
            return new NdefMessage(records);
        }
        @DSModeled(DSC.SAFE)
        @Override
        public NdefMessage[] newArray(int size) {
            return new NdefMessage[size];
        }
    };
}

