package android.nfc;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.os.Parcel;
import android.os.Parcelable;

public final class NdefMessage implements Parcelable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:48.048 -0500", hash_original_field = "43AA9F6BBA9861FD41265D3FF45443F3", hash_generated_field = "3835A2DFF1178D58B5296641A8C4E94F")

    private static final byte FLAG_MB = (byte) 0x80;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:48.051 -0500", hash_original_field = "9D7C853084BDC2D70ABF6A4B50AAA3A5", hash_generated_field = "EB576068E134091F49CFF121FA3CF3C3")

    private static final byte FLAG_ME = (byte) 0x40;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.067 -0400", hash_original_field = "127706CA0B98ABA8AC707A7A7B7E3A13", hash_generated_field = "19F680E50E23F4E29F6607B0A7E9E716")

    public static final Parcelable.Creator<NdefMessage> CREATOR =
            new Parcelable.Creator<NdefMessage>() {
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:48.071 -0500", hash_original_method = "2309D164C76EDDEB5F889CEC6615477A", hash_generated_method = "EAE0E4E842B5024260917892E89EB81B")
        
@Override
        public NdefMessage createFromParcel(Parcel in) {
            int recordsLength = in.readInt();
            NdefRecord[] records = new NdefRecord[recordsLength];
            in.readTypedArray(records, NdefRecord.CREATOR);
            return new NdefMessage(records);
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:48.074 -0500", hash_original_method = "05D7C97BB318FFABDF876446819990ED", hash_generated_method = "DCF651288E57B687D9EE34BE40EA6F92")
        
@Override
        public NdefMessage[] newArray(int size) {
            return new NdefMessage[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:48.053 -0500", hash_original_field = "F30AC1B8BF0B03F942659453F390F3D3", hash_generated_field = "E68F4FE3D834F8AC778DFF66AE2BFB1B")

    private  NdefRecord[] mRecords;

    /**
     * Create an NDEF message from raw bytes.
     * <p>
     * Validation is performed to make sure the Record format headers are valid,
     * and the ID + TYPE + PAYLOAD fields are of the correct size.
     * @throws FormatException
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:48.056 -0500", hash_original_method = "745916B1AE6188C8022A7E21DA1360C3", hash_generated_method = "0BCFE0C51BC238C65CB386EEA59890A5")
    
public NdefMessage(byte[] data) throws FormatException {
        mRecords = null;  // stop compiler complaints about final field
        if (parseNdefMessage(data) == -1) {
            throw new FormatException("Error while parsing NDEF message");
        }
    }

    /**
     * Create an NDEF message from NDEF records.
     */
    @DSComment("data structure, except writeToParcel")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:48.058 -0500", hash_original_method = "E87B5EF1F7D5816785326D2A488F5505", hash_generated_method = "869C49A1D3186925B00FD1E1E8A1AABE")
    
public NdefMessage(NdefRecord[] records) {
        mRecords = new NdefRecord[records.length];
        System.arraycopy(records, 0, mRecords, 0, records.length);
    }

    /**
     * Get the NDEF records inside this NDEF message.
     *
     * @return array of zero or more NDEF records.
     */
    @DSComment("data structure, except writeToParcel")
    @DSSpec(DSCat.SPEC_OTHERS)
    @DSSource({DSSourceKind.NFC})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:48.060 -0500", hash_original_method = "482F2AD23FF4C5B364DE9FB97EDDBB64", hash_generated_method = "C7BB5CEF292B3E7C1A8B4DC36219E098")
    
public NdefRecord[] getRecords() {
        return mRecords.clone();
    }

    /**
     * Returns a byte array representation of this entire NDEF message.
     */
    @DSSource({DSSourceKind.NFC})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:48.063 -0500", hash_original_method = "8C1624491EC0DD58CFD007740FE405D8", hash_generated_method = "21C9C13EC9FAEFA5F55B3DC8AAE9AA07")
    
public byte[] toByteArray() {
        //TODO: allocate the byte array once, copy each record once
        //TODO: process MB and ME flags outside loop
        if ((mRecords == null) || (mRecords.length == 0))
            return new byte[0];

        byte[] msg = {};

        for (int i = 0; i < mRecords.length; i++) {
            byte[] record = mRecords[i].toByteArray();
            byte[] tmp = new byte[msg.length + record.length];

            /* Make sure the Message Begin flag is set only for the first record */
            if (i == 0) {
                record[0] |= FLAG_MB;
            } else {
                record[0] &= ~FLAG_MB;
            }

            /* Make sure the Message End flag is set only for the last record */
            if (i == (mRecords.length - 1)) {
                record[0] |= FLAG_ME;
            } else {
                record[0] &= ~FLAG_ME;
            }

            System.arraycopy(msg, 0, tmp, 0, msg.length);
            System.arraycopy(record, 0, tmp, msg.length, record.length);

            msg = tmp;
        }

        return msg;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:48.065 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "8188008AC9C80E87937FE73DCA905200")
    
@Override
    public int describeContents() {
        return 0;
    }

    @DSSink({DSSinkKind.NFC})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:48.068 -0500", hash_original_method = "C32A271878CC7CE5578073C85AE449D6", hash_generated_method = "F8DAC8176BF50F813F7DB70698DD1DD1")
    
@Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mRecords.length);
        dest.writeTypedArray(mRecords, flags);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:48.081 -0500", hash_original_method = "58C82E5C0DBA98ED651A9002B9916229", hash_generated_method = "3B1A556CAF1DDFD06833DB98E1BF0A16")
    
    private int parseNdefMessage(byte[] data){
    	//Formerly a native method
    	addTaint(data[0]);
    	return getTaintInt();
    }

}

