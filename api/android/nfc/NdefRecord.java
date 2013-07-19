package android.nfc;

// Droidsafe Imports
import java.nio.charset.Charsets;
import java.util.Arrays;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public final class NdefRecord implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.116 -0400", hash_original_field = "9C3CD7D37D3E1E66BE9B3B005FC98B3A", hash_generated_field = "D69A1323403FF74B40E10D9DDFD257AB")

    private byte mFlags;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.116 -0400", hash_original_field = "D9FDE3B8C938C55414D9EA824E4653B4", hash_generated_field = "FC6E9E67F7C574177CE753C7489C4618")

    private short mTnf;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.116 -0400", hash_original_field = "3462A1A18A0EE070E8953CCF1DD788C0", hash_generated_field = "FA16B2C82206522641561377B9DC2980")

    private byte[] mType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.117 -0400", hash_original_field = "6AC7F06B6413A1BE9C136DC7DF0D2B60", hash_generated_field = "5D33188695F224858D1BE9A3A3EAF57E")

    private byte[] mId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.117 -0400", hash_original_field = "A351E8016C1D5077E17E51F859BE177F", hash_generated_field = "BD2E694BF3C185368FEB2F1DFAEB0E21")

    private byte[] mPayload;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.117 -0400", hash_original_method = "FB48E937FC56CBD69B2A6F082227DD21", hash_generated_method = "1F3872BF2970251F0F5AC5E72B4B9976")
    public  NdefRecord(short tnf, byte[] type, byte[] id, byte[] payload) {
        this(tnf, type, id, payload, (byte)(FLAG_MB|FLAG_ME));
        addTaint(payload[0]);
        addTaint(id[0]);
        addTaint(type[0]);
        addTaint(tnf);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.119 -0400", hash_original_method = "EE3B4F476C5F89F900E25765E0C165C3", hash_generated_method = "F7108C0C9FA12024A4B41305F7849566")
      NdefRecord(short tnf, byte[] type, byte[] id, byte[] payload, byte flags) {
        if((type == null) || (id == null) || (payload == null))        
        {
            IllegalArgumentException var7FF1C91B838837AE64E1B1E2BEFAB73D_232126788 = new IllegalArgumentException("Illegal null argument");
            var7FF1C91B838837AE64E1B1E2BEFAB73D_232126788.addTaint(taint);
            throw var7FF1C91B838837AE64E1B1E2BEFAB73D_232126788;
        } //End block
        if(tnf < 0 || tnf > 0x07)        
        {
            IllegalArgumentException var07AF36B75487248256DF457811A5DE76_295212179 = new IllegalArgumentException("TNF out of range " + tnf);
            var07AF36B75487248256DF457811A5DE76_295212179.addTaint(taint);
            throw var07AF36B75487248256DF457811A5DE76_295212179;
        } //End block
        if(payload.length < 0xFF)        
        {
            flags |= FLAG_SR;
        } //End block
        if(id.length != 0)        
        {
            flags |= FLAG_IL;
        } //End block
        mFlags = flags;
        mTnf = tnf;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.119 -0400", hash_original_method = "561B574EC53AB1A329985993E495C9F0", hash_generated_method = "262363E382A66C5B342D5197C8604F19")
    public  NdefRecord(byte[] data) throws FormatException {
        addTaint(data[0]);
        mFlags = 0;
        mTnf = 0;
        mType = null;
        mId = null;
        mPayload = null;
        if(parseNdefRecord(data) == -1)        
        {
            FormatException var70012A4CB2A5B4FFBAEF0843607E6A40_1149765241 = new FormatException("Error while parsing NDEF record");
            var70012A4CB2A5B4FFBAEF0843607E6A40_1149765241.addTaint(taint);
            throw var70012A4CB2A5B4FFBAEF0843607E6A40_1149765241;
        } //End block
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.119 -0400", hash_original_method = "57FC26158D8D678057BEA3A3771FCDE7", hash_generated_method = "5CAD4EB3C10D0681CF9B97A85EF519F3")
    public short getTnf() {
        short varD9FDE3B8C938C55414D9EA824E4653B4_1986206183 = (mTnf);
                short var4F09DAA9D95BCB166A302407A0E0BABE_1995490396 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_1995490396;
        // ---------- Original Method ----------
        //return mTnf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.120 -0400", hash_original_method = "4BBEB3385EB023476A7C83C1132C6B8B", hash_generated_method = "B5BF3D3F488DD400E0639A1544BF6262")
    public byte[] getType() {
        byte[] var9A37959FAA262715140CE0FF3E7088D9_458446376 = (mType.clone());
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_826413713 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_826413713;
        // ---------- Original Method ----------
        //return mType.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.120 -0400", hash_original_method = "9D6A9E4635BF3A5F066D2AADCC504C7A", hash_generated_method = "0F5A2145CEB054D124F580734E6942C8")
    public byte[] getId() {
        byte[] varDAAF137AFDE5E0E74D3870B760B97AD5_486194943 = (mId.clone());
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1671648218 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1671648218;
        // ---------- Original Method ----------
        //return mId.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.120 -0400", hash_original_method = "1327F8BA6EFB58D178B7F3819A329700", hash_generated_method = "CBEB58A96D76E5B3DE692115EC5ECD2D")
    public byte[] getPayload() {
        byte[] varF23B27D6120B4A2F52AD9D01C3A49123_1321820022 = (mPayload.clone());
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1131921607 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1131921607;
        // ---------- Original Method ----------
        //return mPayload.clone();
    }

    
    @DSModeled(DSC.SPEC)
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

    
    @DSModeled(DSC.SPEC)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.121 -0400", hash_original_method = "7310D9773CC55767E043FA59CD9561A6", hash_generated_method = "6518FA58DC672378AFAA5105F8C781B0")
    public byte[] toByteArray() {
        byte[] varC7229ED78C192BDF5980F9E96C84B859_1609812243 = (generate(mFlags, mTnf, mType, mId, mPayload));
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1709664118 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1709664118;
        // ---------- Original Method ----------
        //return generate(mFlags, mTnf, mType, mId, mPayload);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.121 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "3DC53261186808E9929599F640B13F74")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_560325621 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_521230095 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_521230095;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.121 -0400", hash_original_method = "747D030979ABC5D8CF3744986AE0C078", hash_generated_method = "A34753C4BA233A5350488D20307E3953")
    public void writeToParcel(Parcel dest, int flags) {
        addTaint(flags);
        addTaint(dest.getTaint());
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.122 -0400", hash_original_method = "D593336128142C3B83A1F96FE0DB1162", hash_generated_method = "32E9DFF045673DEAFD2CC9CB306BABA7")
    private int parseNdefRecord(byte[] data) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1516787988 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1516787988;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.122 -0400", hash_original_method = "D4618511B086F2DC6D5A6E1B49747B83", hash_generated_method = "601B7C8B41782A51DF739463E77D2D9A")
    private byte[] generate(short flags, short tnf, byte[] type, byte[] id, byte[] data) {
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1143823073 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1143823073;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.122 -0400", hash_original_field = "704043F59701EE1855EF306730A14F0F", hash_generated_field = "C319C6066B73B8E81680E78496926AD2")

    public static final short TNF_EMPTY = 0x00;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.122 -0400", hash_original_field = "BC2175EFAEBBCF766D2F539780F9FFE7", hash_generated_field = "87ACAF44322B08D81632A5BCB7BC5522")

    public static final short TNF_WELL_KNOWN = 0x01;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.122 -0400", hash_original_field = "E0EA569803DD777A0A1D227FB426A095", hash_generated_field = "ECC0A15E356EA90B8CF14EAA5D010D5C")

    public static final short TNF_MIME_MEDIA = 0x02;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.122 -0400", hash_original_field = "D15592854B1DD884E877D2C00A5F9B33", hash_generated_field = "8201DA35FBD7C880CB2369F8965C25C1")

    public static final short TNF_ABSOLUTE_URI = 0x03;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.122 -0400", hash_original_field = "D7ADCBAB05AF1493644CC04CFFDC3B48", hash_generated_field = "1BAA6C6514F376F895A8E3081D5B8028")

    public static final short TNF_EXTERNAL_TYPE = 0x04;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.122 -0400", hash_original_field = "A51966ADC14A45D66550B441F28F105D", hash_generated_field = "806BCF6532B0DEF74C16D65BEDC56AC3")

    public static final short TNF_UNKNOWN = 0x05;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.122 -0400", hash_original_field = "92115C34F63D662CF9DE851AA77E1B87", hash_generated_field = "D5319E5AD331068DCD78A63A547DF111")

    public static final short TNF_UNCHANGED = 0x06;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.122 -0400", hash_original_field = "4986635DDBBC8ECACF5C2E6A68F8B60D", hash_generated_field = "03237D3100E7CD726873CB9AE8D54EBD")

    public static final short TNF_RESERVED = 0x07;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.122 -0400", hash_original_field = "8085E5C729DF9D5B37FAA689B453FFD1", hash_generated_field = "316493B0AE6ED850923D588436E41996")

    public static final byte[] RTD_TEXT = {0x54};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.122 -0400", hash_original_field = "1AEB73A9969BA54F80809A59ECC1FDF6", hash_generated_field = "A934198AF88C4683341ED17F6F0EA392")

    public static final byte[] RTD_URI = {0x55};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.122 -0400", hash_original_field = "24C48F7C800D1B5664EA97CBF56E1D6E", hash_generated_field = "934A332C47F35AB2DFF7B99A1CFE69E3")

    public static final byte[] RTD_SMART_POSTER = {0x53, 0x70};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.122 -0400", hash_original_field = "0794BF2786275B48B7432D71D2ED5BF0", hash_generated_field = "B75B34DE3FE095F81BD11453A7ADBC64")

    public static final byte[] RTD_ALTERNATIVE_CARRIER = {0x61, 0x63};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.122 -0400", hash_original_field = "563C8F68DDE219308156207954B00E5E", hash_generated_field = "98A4615B64911254227046D6E461484E")

    public static final byte[] RTD_HANDOVER_CARRIER = {0x48, 0x63};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.122 -0400", hash_original_field = "22EB22C0F48C3E19477AC700176A8D18", hash_generated_field = "9F62BACF2EA0E21A7A0FFB08B08E7903")

    public static final byte[] RTD_HANDOVER_REQUEST = {0x48, 0x72};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.122 -0400", hash_original_field = "43B3D84A3ABE553A003DA6960B88BC5D", hash_generated_field = "83717750792C647D68570A41C874C025")

    public static final byte[] RTD_HANDOVER_SELECT = {0x48, 0x73};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.123 -0400", hash_original_field = "E6A3DF1352190BAD2771DFCB7F11A4A7", hash_generated_field = "4C2312D1C4BD97A899AF743F6B28AD35")

    public static final byte[] RTD_ANDROID_APP = "android.com:pkg".getBytes();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.123 -0400", hash_original_field = "2567A7778944BAE41EB778C6A0D3FB93", hash_generated_field = "3835A2DFF1178D58B5296641A8C4E94F")

    private static final byte FLAG_MB = (byte) 0x80;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.123 -0400", hash_original_field = "0469070E4DDB8009448612A49A33DD4B", hash_generated_field = "EB576068E134091F49CFF121FA3CF3C3")

    private static final byte FLAG_ME = (byte) 0x40;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.123 -0400", hash_original_field = "19031A4EDC008084C7504596B0BBC84D", hash_generated_field = "69CEEE632374FAE77EE43C39A0291BAA")

    private static final byte FLAG_CF = (byte) 0x20;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.123 -0400", hash_original_field = "F3E054711078C2468B07F614E0E85610", hash_generated_field = "161816364D97BB4F02EAB674D9EBE3C5")

    private static final byte FLAG_SR = (byte) 0x10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.123 -0400", hash_original_field = "C473B529C5531D1ECF74B8A5BEA80622", hash_generated_field = "CFFB9EEA5A13F5E81A2AFA3D735C29B2")

    private static final byte FLAG_IL = (byte) 0x08;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.123 -0400", hash_original_field = "572538B4CE7857C0706DED0A3145BE27", hash_generated_field = "85EFD0575E8122D90A921D9D0E0A48E2")

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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.123 -0400", hash_original_field = "903FDFFF6F7C2A1A68B43214AE73E5A2", hash_generated_field = "CD155D24233CC6FAB3BECDE2E551BAA2")

    public static final Parcelable.Creator<NdefRecord> CREATOR =
            new Parcelable.Creator<NdefRecord>() {
        public NdefRecord createFromParcel(Parcel in) {
            byte flags = (byte)in.readInt();
            short tnf = (short)in.readInt();
            int typeLength = in.readInt();
            byte[] type = new byte[typeLength];
            in.readByteArray(type);
            int idLength = in.readInt();
            byte[] id = new byte[idLength];
            in.readByteArray(id);
            int payloadLength = in.readInt();
            byte[] payload = new byte[payloadLength];
            in.readByteArray(payload);

            return new NdefRecord(tnf, type, id, payload, flags);
        }
        public NdefRecord[] newArray(int size) {
            return new NdefRecord[size];
        }
    };
    // orphaned legacy method
    public NdefRecord createFromParcel(Parcel in) {
            byte flags = (byte)in.readInt();
            short tnf = (short)in.readInt();
            int typeLength = in.readInt();
            byte[] type = new byte[typeLength];
            in.readByteArray(type);
            int idLength = in.readInt();
            byte[] id = new byte[idLength];
            in.readByteArray(id);
            int payloadLength = in.readInt();
            byte[] payload = new byte[payloadLength];
            in.readByteArray(payload);

            return new NdefRecord(tnf, type, id, payload, flags);
        }
    
    // orphaned legacy method
    public NdefRecord[] newArray(int size) {
            return new NdefRecord[size];
        }
    
}

