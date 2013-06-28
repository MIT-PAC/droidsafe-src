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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.034 -0400", hash_original_field = "3B8204E6C5A7D4B4E9A58CC03885B8D6", hash_generated_field = "E68F4FE3D834F8AC778DFF66AE2BFB1B")

    private NdefRecord[] mRecords;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.035 -0400", hash_original_method = "745916B1AE6188C8022A7E21DA1360C3", hash_generated_method = "10D1ABF4C7B3F19673BB8EA8D95BFEDE")
    public  NdefMessage(byte[] data) throws FormatException {
        mRecords = null;
        {
            boolean varAA4C11B4345CE90310CEDDAB0AF4349A_84975223 = (parseNdefMessage(data) == -1);
            {
                if (DroidSafeAndroidRuntime.control) throw new FormatException("Error while parsing NDEF message");
            } //End block
        } //End collapsed parenthetic
        addTaint(data[0]);
        // ---------- Original Method ----------
        //mRecords = null;
        //if (parseNdefMessage(data) == -1) {
            //throw new FormatException("Error while parsing NDEF message");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.035 -0400", hash_original_method = "E87B5EF1F7D5816785326D2A488F5505", hash_generated_method = "CBDC2B7A3B5AEEA31D20F9D68D09A9D5")
    public  NdefMessage(NdefRecord[] records) {
        mRecords = new NdefRecord[records.length];
        System.arraycopy(records, 0, mRecords, 0, records.length);
        // ---------- Original Method ----------
        //mRecords = new NdefRecord[records.length];
        //System.arraycopy(records, 0, mRecords, 0, records.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.036 -0400", hash_original_method = "482F2AD23FF4C5B364DE9FB97EDDBB64", hash_generated_method = "48C2FE502E60FF016C18399F717557CF")
    public NdefRecord[] getRecords() {
        NdefRecord[] varB4EAC82CA7396A68D541C85D26508E83_2018972500 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2018972500 = mRecords.clone();
        varB4EAC82CA7396A68D541C85D26508E83_2018972500.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2018972500;
        // ---------- Original Method ----------
        //return mRecords.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.036 -0400", hash_original_method = "8C1624491EC0DD58CFD007740FE405D8", hash_generated_method = "A70CE2B77B9F4DAEF728468C82D32BCF")
    public byte[] toByteArray() {
        byte[] varCD2B5CAF7811FECE279C6AA98F83010C_886285014 = (new byte[0]);
        byte[] msg = {};
        {
            int i = 0;
            {
                byte[] record = mRecords[i].toByteArray();
                byte[] tmp = new byte[msg.length + record.length];
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
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1345379151 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1345379151;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.037 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "E2B75643688C6C69C5451FFFD9A98C65")
    @Override
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1510719683 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1510719683;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.038 -0400", hash_original_method = "C32A271878CC7CE5578073C85AE449D6", hash_generated_method = "A6DD5C9E8B4550688C96BB8C50ED51D5")
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mRecords.length);
        dest.writeTypedArray(mRecords, flags);
        addTaint(dest.getTaint());
        addTaint(flags);
        // ---------- Original Method ----------
        //dest.writeInt(mRecords.length);
        //dest.writeTypedArray(mRecords, flags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.038 -0400", hash_original_method = "58C82E5C0DBA98ED651A9002B9916229", hash_generated_method = "9398777C439B652B911DB44500CAE8C3")
    private int parseNdefMessage(byte[] data) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2021076147 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2021076147;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.038 -0400", hash_original_field = "2567A7778944BAE41EB778C6A0D3FB93", hash_generated_field = "3835A2DFF1178D58B5296641A8C4E94F")

    private static final byte FLAG_MB = (byte) 0x80;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.038 -0400", hash_original_field = "0469070E4DDB8009448612A49A33DD4B", hash_generated_field = "EB576068E134091F49CFF121FA3CF3C3")

    private static final byte FLAG_ME = (byte) 0x40;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.039 -0400", hash_original_field = "127706CA0B98ABA8AC707A7A7B7E3A13", hash_generated_field = "19F680E50E23F4E29F6607B0A7E9E716")

    public static final Parcelable.Creator<NdefMessage> CREATOR =
            new Parcelable.Creator<NdefMessage>() {
        @Override
        public NdefMessage createFromParcel(Parcel in) {
            int recordsLength = in.readInt();
            NdefRecord[] records = new NdefRecord[recordsLength];
            in.readTypedArray(records, NdefRecord.CREATOR);
            return new NdefMessage(records);
        }
        @Override
        public NdefMessage[] newArray(int size) {
            return new NdefMessage[size];
        }
    };
    // orphaned legacy method
    @Override
        public NdefMessage createFromParcel(Parcel in) {
            int recordsLength = in.readInt();
            NdefRecord[] records = new NdefRecord[recordsLength];
            in.readTypedArray(records, NdefRecord.CREATOR);
            return new NdefMessage(records);
        }
    
    // orphaned legacy method
    @Override
        public NdefMessage[] newArray(int size) {
            return new NdefMessage[size];
        }
    
}

