package android.nfc;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import java.lang.UnsupportedOperationException;
import java.nio.charset.Charset;
import java.nio.charset.Charsets;
import java.util.Arrays;

public final class NdefRecord implements Parcelable {
    private byte mFlags;
    private short mTnf;
    private byte[] mType;
    private byte[] mId;
    private byte[] mPayload;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.965 -0400", hash_original_method = "FB48E937FC56CBD69B2A6F082227DD21", hash_generated_method = "8DFBECA220135C88E5ABD3C3427AD5D0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public NdefRecord(short tnf, byte[] type, byte[] id, byte[] payload) {
        this(tnf, type, id, payload, (byte)(FLAG_MB|FLAG_ME));
        dsTaint.addTaint(id[0]);
        dsTaint.addTaint(tnf);
        dsTaint.addTaint(payload[0]);
        dsTaint.addTaint(type[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.966 -0400", hash_original_method = "EE3B4F476C5F89F900E25765E0C165C3", hash_generated_method = "F54928B7243212B7CE2CF50CAF448878")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     NdefRecord(short tnf, byte[] type, byte[] id, byte[] payload, byte flags) {
        dsTaint.addTaint(id[0]);
        dsTaint.addTaint(tnf);
        dsTaint.addTaint(flags);
        dsTaint.addTaint(payload[0]);
        dsTaint.addTaint(type[0]);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Illegal null argument");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("TNF out of range " + tnf);
        } //End block
        {
            flags |= FLAG_SR;
        } //End block
        {
            flags |= FLAG_IL;
        } //End block
        mType = type.clone();
        mId = id.clone();
        mPayload = payload.clone();
        // ---------- Original Method ----------
        //if ((type == null) || (id == null) || (payload == null)) {
            //throw new IllegalArgumentException("Illegal null argument");
        //}
        //if (tnf < 0 || tnf > 0x07) {
            //throw new IllegalArgumentException("TNF out of range " + tnf);
        //}
        //if(payload.length < 0xFF) {
            //flags |= FLAG_SR;
        //}
        //if(id.length != 0) {
            //flags |= FLAG_IL;
        //}
        //mFlags = flags;
        //mTnf = tnf;
        //mType = type.clone();
        //mId = id.clone();
        //mPayload = payload.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.966 -0400", hash_original_method = "561B574EC53AB1A329985993E495C9F0", hash_generated_method = "2A375CE836C9626BE999BC049835D2AC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public NdefRecord(byte[] data) throws FormatException {
        dsTaint.addTaint(data[0]);
        mFlags = 0;
        mTnf = 0;
        mType = null;
        mId = null;
        mPayload = null;
        {
            boolean varC61EB16E3E79362D8FE2544C99C31894_1309819569 = (parseNdefRecord(data) == -1);
            {
                if (DroidSafeAndroidRuntime.control) throw new FormatException("Error while parsing NDEF record");
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //mFlags = 0;
        //mTnf = 0;
        //mType = null;
        //mId = null;
        //mPayload = null;
        //if (parseNdefRecord(data) == -1) {
            //throw new FormatException("Error while parsing NDEF record");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.966 -0400", hash_original_method = "57FC26158D8D678057BEA3A3771FCDE7", hash_generated_method = "4C349B746104D55CF10DDDAB664893EC")
    @DSModeled(DSC.SAFE)
    public short getTnf() {
        return dsTaint.getTaintShort();
        // ---------- Original Method ----------
        //return mTnf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.967 -0400", hash_original_method = "4BBEB3385EB023476A7C83C1132C6B8B", hash_generated_method = "5FF5DAED5C07F9094B1A1ABC9355EF62")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public byte[] getType() {
        byte[] var027F80CF393221629AE54D8CAC4C1A97_1438512645 = (mType.clone());
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //return mType.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.967 -0400", hash_original_method = "9D6A9E4635BF3A5F066D2AADCC504C7A", hash_generated_method = "3EF9C5B2C9A07900EC4A451C6866000B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public byte[] getId() {
        byte[] varF397DE17F60BD4CB210D433F2D9ECA6F_1958067896 = (mId.clone());
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //return mId.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.967 -0400", hash_original_method = "1327F8BA6EFB58D178B7F3819A329700", hash_generated_method = "156E845133A5195069D26A41B737F1AB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public byte[] getPayload() {
        byte[] var0CB1441DE431A65CB70BC3946EBA2304_507140136 = (mPayload.clone());
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //return mPayload.clone();
    }

    
        public static Uri parseWellKnownUriRecord(NdefRecord record) throws FormatException {
        byte[] payload = record.getPayload();
        if (payload.length < 2) {
            throw new FormatException("Payload is not a valid URI (missing prefix)");
        }
        int prefixIndex = (payload[0] & 0xff);
        if (prefixIndex < 0 || prefixIndex >= URI_PREFIX_MAP.length) {
            throw new FormatException("Payload is not a valid URI (invalid prefix)");
        }
        String prefix = URI_PREFIX_MAP[prefixIndex];
        byte[] fullUri = concat(prefix.getBytes(Charsets.UTF_8),
                Arrays.copyOfRange(payload, 1, payload.length));
        return Uri.parse(new String(fullUri, Charsets.UTF_8));
    }

    
        public static NdefRecord createApplicationRecord(String packageName) {
        return new NdefRecord(TNF_EXTERNAL_TYPE, RTD_ANDROID_APP, new byte[] {},
                packageName.getBytes(Charsets.US_ASCII));
    }

    
        public static NdefRecord createUri(Uri uri) {
        return createUri(uri.toString());
    }

    
        public static NdefRecord createUri(String uriString) {
        byte prefix = 0x0;
        for (int i = 1; i < URI_PREFIX_MAP.length; i++) {
            if (uriString.startsWith(URI_PREFIX_MAP[i])) {
                prefix = (byte) i;
                uriString = uriString.substring(URI_PREFIX_MAP[i].length());
                break;
            }
        }
        byte[] uriBytes = uriString.getBytes(Charsets.UTF_8);
        byte[] recordBytes = new byte[uriBytes.length + 1];
        recordBytes[0] = prefix;
        System.arraycopy(uriBytes, 0, recordBytes, 1, uriBytes.length);
        return new NdefRecord(TNF_WELL_KNOWN, RTD_URI, new byte[0], recordBytes);
    }

    
        private static byte[] concat(byte[]... arrays) {
        int length = 0;
        for (byte[] array : arrays) {
            length += array.length;
        }
        byte[] result = new byte[length];
        int pos = 0;
        for (byte[] array : arrays) {
            System.arraycopy(array, 0, result, pos, array.length);
            pos += array.length;
        }
        return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.968 -0400", hash_original_method = "7310D9773CC55767E043FA59CD9561A6", hash_generated_method = "47DDFE07228ECF079422B4CB67BFB144")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public byte[] toByteArray() {
        byte[] var37126315458F290BFAFAAC4419CBB989_1549207339 = (generate(mFlags, mTnf, mType, mId, mPayload));
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //return generate(mFlags, mTnf, mType, mId, mPayload);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.968 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.969 -0400", hash_original_method = "747D030979ABC5D8CF3744986AE0C078", hash_generated_method = "56491D211894C43AA6902186212A5D61")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(dest.dsTaint);
        dest.writeInt(mFlags);
        dest.writeInt(mTnf);
        dest.writeInt(mType.length);
        dest.writeByteArray(mType);
        dest.writeInt(mId.length);
        dest.writeByteArray(mId);
        dest.writeInt(mPayload.length);
        dest.writeByteArray(mPayload);
        // ---------- Original Method ----------
        //dest.writeInt(mFlags);
        //dest.writeInt(mTnf);
        //dest.writeInt(mType.length);
        //dest.writeByteArray(mType);
        //dest.writeInt(mId.length);
        //dest.writeByteArray(mId);
        //dest.writeInt(mPayload.length);
        //dest.writeByteArray(mPayload);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.969 -0400", hash_original_method = "D593336128142C3B83A1F96FE0DB1162", hash_generated_method = "B439264D6B0CCE11DF7056D1B3AF9BCF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int parseNdefRecord(byte[] data) {
        dsTaint.addTaint(data[0]);
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.969 -0400", hash_original_method = "D4618511B086F2DC6D5A6E1B49747B83", hash_generated_method = "D954200C0E8AC1FEE74A7886D3750111")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private byte[] generate(short flags, short tnf, byte[] type, byte[] id, byte[] data) {
        dsTaint.addTaint(id[0]);
        dsTaint.addTaint(tnf);
        dsTaint.addTaint(flags);
        dsTaint.addTaint(data[0]);
        dsTaint.addTaint(type[0]);
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
    }

    
    public static final short TNF_EMPTY = 0x00;
    public static final short TNF_WELL_KNOWN = 0x01;
    public static final short TNF_MIME_MEDIA = 0x02;
    public static final short TNF_ABSOLUTE_URI = 0x03;
    public static final short TNF_EXTERNAL_TYPE = 0x04;
    public static final short TNF_UNKNOWN = 0x05;
    public static final short TNF_UNCHANGED = 0x06;
    public static final short TNF_RESERVED = 0x07;
    public static final byte[] RTD_TEXT = {0x54};
    public static final byte[] RTD_URI = {0x55};
    public static final byte[] RTD_SMART_POSTER = {0x53, 0x70};
    public static final byte[] RTD_ALTERNATIVE_CARRIER = {0x61, 0x63};
    public static final byte[] RTD_HANDOVER_CARRIER = {0x48, 0x63};
    public static final byte[] RTD_HANDOVER_REQUEST = {0x48, 0x72};
    public static final byte[] RTD_HANDOVER_SELECT = {0x48, 0x73};
    public static final byte[] RTD_ANDROID_APP = "android.com:pkg".getBytes();
    private static final byte FLAG_MB = (byte) 0x80;
    private static final byte FLAG_ME = (byte) 0x40;
    private static final byte FLAG_CF = (byte) 0x20;
    private static final byte FLAG_SR = (byte) 0x10;
    private static final byte FLAG_IL = (byte) 0x08;
    private static final String[] URI_PREFIX_MAP = new String[] {
            "", 
            "http://www.", 
            "https://www.", 
            "http://", 
            "https://", 
            "tel:", 
            "mailto:", 
            "ftp://anonymous:anonymous@", 
            "ftp://ftp.", 
            "ftps://", 
            "sftp://", 
            "smb://", 
            "nfs://", 
            "ftp://", 
            "dav://", 
            "news:", 
            "telnet://", 
            "imap:", 
            "rtsp://", 
            "urn:", 
            "pop:", 
            "sip:", 
            "sips:", 
            "tftp:", 
            "btspp://", 
            "btl2cap://", 
            "btgoep://", 
            "tcpobex://", 
            "irdaobex://", 
            "file://", 
            "urn:epc:id:", 
            "urn:epc:tag:", 
            "urn:epc:pat:", 
            "urn:epc:raw:", 
            "urn:epc:", 
    };
    public static final Parcelable.Creator<NdefRecord> CREATOR = new Parcelable.Creator<NdefRecord>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.970 -0400", hash_original_method = "61F0FE49184683E1DD0D669A65FA9F65", hash_generated_method = "69A8C62AC14E1812ADC9E86E34C14209")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public NdefRecord createFromParcel(Parcel in) {
            dsTaint.addTaint(in.dsTaint);
            byte flags;
            flags = (byte)in.readInt();
            short tnf;
            tnf = (short)in.readInt();
            int typeLength;
            typeLength = in.readInt();
            byte[] type;
            type = new byte[typeLength];
            in.readByteArray(type);
            int idLength;
            idLength = in.readInt();
            byte[] id;
            id = new byte[idLength];
            in.readByteArray(id);
            int payloadLength;
            payloadLength = in.readInt();
            byte[] payload;
            payload = new byte[payloadLength];
            in.readByteArray(payload);
            NdefRecord var7A5FF017E1214F2FB039DB077F5EB89D_758968384 = (new NdefRecord(tnf, type, id, payload, flags));
            return (NdefRecord)dsTaint.getTaint();
            // ---------- Original Method ----------
            //byte flags = (byte)in.readInt();
            //short tnf = (short)in.readInt();
            //int typeLength = in.readInt();
            //byte[] type = new byte[typeLength];
            //in.readByteArray(type);
            //int idLength = in.readInt();
            //byte[] id = new byte[idLength];
            //in.readByteArray(id);
            //int payloadLength = in.readInt();
            //byte[] payload = new byte[payloadLength];
            //in.readByteArray(payload);
            //return new NdefRecord(tnf, type, id, payload, flags);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.970 -0400", hash_original_method = "17B41DFA84E413C370939C03E7022E45", hash_generated_method = "485688A898715A1FC8A2616E50B2713A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public NdefRecord[] newArray(int size) {
            dsTaint.addTaint(size);
            NdefRecord[] varAEA8596710F20A2C54E5C99FBEA8F65A_1058514787 = (new NdefRecord[size]);
            return (NdefRecord[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new NdefRecord[size];
        }

        
}; //Transformed anonymous class
}

