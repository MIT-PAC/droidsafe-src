package android.nfc;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.nio.charset.Charsets;
import java.util.Arrays;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

public final class NdefRecord implements Parcelable {

    /**
     * Helper to return the NdefRecord as a URI.
     * TODO: Consider making a member method instead of static
     * TODO: Consider more validation that this is a URI record
     * TODO: Make a public API
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:50.206 -0500", hash_original_method = "91D5DC6D947AF7291A88115C5E64F077", hash_generated_method = "05846FE035FF79F0DDFFC1F9C8966403")
    
public static Uri parseWellKnownUriRecord(NdefRecord record) throws FormatException {
        byte[] payload = record.getPayload();
        if (payload.length < 2) {
            throw new FormatException("Payload is not a valid URI (missing prefix)");
        }

        /*
         * payload[0] contains the URI Identifier Code, per the
         * NFC Forum "URI Record Type Definition" section 3.2.2.
         *
         * payload[1]...payload[payload.length - 1] contains the rest of
         * the URI.
         */
        int prefixIndex = (payload[0] & 0xff);
        if (prefixIndex < 0 || prefixIndex >= URI_PREFIX_MAP.length) {
            throw new FormatException("Payload is not a valid URI (invalid prefix)");
        }
        String prefix = URI_PREFIX_MAP[prefixIndex];
        byte[] fullUri = concat(prefix.getBytes(Charsets.UTF_8),
                Arrays.copyOfRange(payload, 1, payload.length));
        return Uri.parse(new String(fullUri, Charsets.UTF_8));
    }

    /**
     * Creates an Android application NDEF record.
     * <p>
     * This record indicates to other Android devices the package
     * that should be used to handle the rest of the NDEF message.
     * You can embed this record anywhere into your NDEF message
     * to ensure that the intended package receives the message.
     * <p>
     * When an Android device dispatches an {@link NdefMessage}
     * containing one or more Android application records,
     * the applications contained in those records will be the
     * preferred target for the NDEF_DISCOVERED intent, in
     * the order in which they appear in the {@link NdefMessage}.
     * This dispatch behavior was first added to Android in
     * Ice Cream Sandwich.
     * <p>
     * If none of the applications are installed on the device,
     * a Market link will be opened to the first application.
     * <p>
     * Note that Android application records do not overrule
     * applications that have called
     * {@link NfcAdapter#enableForegroundDispatch}.
     *
     * @param packageName Android package name
     * @return Android application NDEF record
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:50.208 -0500", hash_original_method = "1784D2B47354636F4A9B34421704351B", hash_generated_method = "AB33A75128DEC64908633D73456F0F04")
    
public static NdefRecord createApplicationRecord(String packageName) {
        return new NdefRecord(TNF_EXTERNAL_TYPE, RTD_ANDROID_APP, new byte[] {},
                packageName.getBytes(Charsets.US_ASCII));
    }

    /**
     * Creates an NDEF record of well known type URI.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:50.211 -0500", hash_original_method = "EB1882B678B53D1D9D17BF7352F2C601", hash_generated_method = "0E7FC9780B785A6A0C52129E0A129642")
    
public static NdefRecord createUri(Uri uri) {
        return createUri(uri.toString());
    }

    /**
     * Creates an NDEF record of well known type URI.
     */
    @DSSource({DSSourceKind.NFC})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:50.214 -0500", hash_original_method = "3B32FFA1CE722DE38A059403727B8397", hash_generated_method = "72E6470E177C9856FD91B43A85E7016D")
    
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

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:50.216 -0500", hash_original_method = "CF5FE1A1E327C48AD2DDEDA7889688E1", hash_generated_method = "1930952CAAB9A1E09899B921D0A3F7EE")
    
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:50.124 -0500", hash_original_field = "8644E545752F4AAB5438E86D8CEAFB8C", hash_generated_field = "C319C6066B73B8E81680E78496926AD2")

    public static final short TNF_EMPTY = 0x00;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:50.127 -0500", hash_original_field = "D1E949626E8D589F045567EDE74F6D59", hash_generated_field = "87ACAF44322B08D81632A5BCB7BC5522")

    public static final short TNF_WELL_KNOWN = 0x01;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:50.129 -0500", hash_original_field = "55D1F1E89CEAE74EE7B152287B3D4DA6", hash_generated_field = "ECC0A15E356EA90B8CF14EAA5D010D5C")

    public static final short TNF_MIME_MEDIA = 0x02;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:50.131 -0500", hash_original_field = "6E9A458343D0A592DBA62602AFEFC212", hash_generated_field = "8201DA35FBD7C880CB2369F8965C25C1")

    public static final short TNF_ABSOLUTE_URI = 0x03;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:50.134 -0500", hash_original_field = "010CE4CAFE862B8EC999BD70E5B5638A", hash_generated_field = "1BAA6C6514F376F895A8E3081D5B8028")

    public static final short TNF_EXTERNAL_TYPE = 0x04;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:50.136 -0500", hash_original_field = "D29E9E4DEDBF92C397B37475EC6B8751", hash_generated_field = "806BCF6532B0DEF74C16D65BEDC56AC3")

    public static final short TNF_UNKNOWN = 0x05;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:50.139 -0500", hash_original_field = "46B01D76CD2DFB76CF8E6C502E0D07B8", hash_generated_field = "D5319E5AD331068DCD78A63A547DF111")

    public static final short TNF_UNCHANGED = 0x06;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:50.141 -0500", hash_original_field = "4B8815A3428BBEBA01C82E828B691E60", hash_generated_field = "03237D3100E7CD726873CB9AE8D54EBD")

    public static final short TNF_RESERVED = 0x07;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:50.143 -0500", hash_original_field = "546B707984B5A4CAD2CEDF29F721F109", hash_generated_field = "316493B0AE6ED850923D588436E41996")

    public static final byte[] RTD_TEXT = {0x54};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:50.146 -0500", hash_original_field = "20BB0CF51CEED5BF78D38D58C1041985", hash_generated_field = "AF4A01C1B16F5EDA09A440BA1028A73B")

    /**
     * RTD URI type. For use with TNF_WELL_KNOWN.
     */
    public static final byte[] RTD_URI = {0x55};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:50.148 -0500", hash_original_field = "B20519CAF93AA2C57337B2B121E30CB9", hash_generated_field = "BE32D943AE20B02098876544C3EB2E39")

    /**
     * RTD Smart Poster type. For use with TNF_WELL_KNOWN.
     */
    public static final byte[] RTD_SMART_POSTER = {0x53, 0x70};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:50.152 -0500", hash_original_field = "A1FE534799FED5526063CCE84DE3E92B", hash_generated_field = "48162E8DEAA31CA1792DB397558FF513")

    /**
     * RTD Alternative Carrier type. For use with TNF_WELL_KNOWN.
     */
    public static final byte[] RTD_ALTERNATIVE_CARRIER = {0x61, 0x63};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:50.154 -0500", hash_original_field = "0EC2E3503BC0FBE5384BE7EC701D787E", hash_generated_field = "530335AFED67E82469A1884F4129478F")

    /**
     * RTD Handover Carrier type. For use with TNF_WELL_KNOWN.
     */
    public static final byte[] RTD_HANDOVER_CARRIER = {0x48, 0x63};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:50.156 -0500", hash_original_field = "37E1176C6EF16BBA2ABADF3C388FBCFE", hash_generated_field = "D9DD4EC8137EFE280BD7D9AE5FF23609")

    /**
     * RTD Handover Request type. For use with TNF_WELL_KNOWN.
     */
    public static final byte[] RTD_HANDOVER_REQUEST = {0x48, 0x72};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:50.158 -0500", hash_original_field = "119A497A3739EF8CF5C93D223B4E67F6", hash_generated_field = "8C2497FD94764E58F412190F3E8FB78D")

    /**
     * RTD Handover Select type. For use with TNF_WELL_KNOWN.
     */
    public static final byte[] RTD_HANDOVER_SELECT = {0x48, 0x73};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:50.160 -0500", hash_original_field = "234737A1960F721D7BB368F3678DFDB1", hash_generated_field = "8B5244DC38EBD5E1AB0D3160139C10FD")

    /**
     * RTD Android app type. For use with TNF_EXTERNAL.
     * <p>
     * The payload of a record with type RTD_ANDROID_APP
     * should be the package name identifying an application.
     * Multiple RTD_ANDROID_APP records may be included
     * in a single {@link NdefMessage}.
     * <p>
     * Use {@link #createApplicationRecord(String)} to create
     * RTD_ANDROID_APP records.
     * @hide
     */
    public static final byte[] RTD_ANDROID_APP = "android.com:pkg".getBytes();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:50.163 -0500", hash_original_field = "43AA9F6BBA9861FD41265D3FF45443F3", hash_generated_field = "3835A2DFF1178D58B5296641A8C4E94F")

    private static final byte FLAG_MB = (byte) 0x80;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:50.166 -0500", hash_original_field = "9D7C853084BDC2D70ABF6A4B50AAA3A5", hash_generated_field = "EB576068E134091F49CFF121FA3CF3C3")

    private static final byte FLAG_ME = (byte) 0x40;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:50.168 -0500", hash_original_field = "EC21C8442A058B46DC95214A8686E699", hash_generated_field = "69CEEE632374FAE77EE43C39A0291BAA")

    private static final byte FLAG_CF = (byte) 0x20;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:50.170 -0500", hash_original_field = "6C161CF4277FD7EF5CD4F580F8AB08DC", hash_generated_field = "161816364D97BB4F02EAB674D9EBE3C5")

    private static final byte FLAG_SR = (byte) 0x10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:50.173 -0500", hash_original_field = "FFBAF01FEB4099B3657E3F7F1418D611", hash_generated_field = "CFFB9EEA5A13F5E81A2AFA3D735C29B2")

    private static final byte FLAG_IL = (byte) 0x08;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:50.176 -0500", hash_original_field = "8A9B6273D09E250B1BAD231166655C05", hash_generated_field = "686420BA95C5815BB59718FF8B759146")

    private static final String[] URI_PREFIX_MAP = new String[] {
            "", // 0x00
            "http://www.", // 0x01
            "https://www.", // 0x02
            "http://", // 0x03
            "https://", // 0x04
            "tel:", // 0x05
            "mailto:", // 0x06
            "ftp://anonymous:anonymous@", // 0x07
            "ftp://ftp.", // 0x08
            "ftps://", // 0x09
            "sftp://", // 0x0A
            "smb://", // 0x0B
            "nfs://", // 0x0C
            "ftp://", // 0x0D
            "dav://", // 0x0E
            "news:", // 0x0F
            "telnet://", // 0x10
            "imap:", // 0x11
            "rtsp://", // 0x12
            "urn:", // 0x13
            "pop:", // 0x14
            "sip:", // 0x15
            "sips:", // 0x16
            "tftp:", // 0x17
            "btspp://", // 0x18
            "btl2cap://", // 0x19
            "btgoep://", // 0x1A
            "tcpobex://", // 0x1B
            "irdaobex://", // 0x1C
            "file://", // 0x1D
            "urn:epc:id:", // 0x1E
            "urn:epc:tag:", // 0x1F
            "urn:epc:pat:", // 0x20
            "urn:epc:raw:", // 0x21
            "urn:epc:", // 0x22
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.123 -0400", hash_original_field = "903FDFFF6F7C2A1A68B43214AE73E5A2", hash_generated_field = "CD155D24233CC6FAB3BECDE2E551BAA2")

    public static final Parcelable.Creator<NdefRecord> CREATOR =
            new Parcelable.Creator<NdefRecord>() {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:50.227 -0500", hash_original_method = "61F0FE49184683E1DD0D669A65FA9F65", hash_generated_method = "E825ACFCA65124C3B19A053A814992A0")
        
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
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:50.229 -0500", hash_original_method = "17B41DFA84E413C370939C03E7022E45", hash_generated_method = "98DCA863180710EB469B88CF3524C933")
        
public NdefRecord[] newArray(int size) {
            return new NdefRecord[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:50.178 -0500", hash_original_field = "9FDA87992728AC3EBDE5218078A80DC2", hash_generated_field = "D69A1323403FF74B40E10D9DDFD257AB")

    private  byte mFlags;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:50.180 -0500", hash_original_field = "A3C4F2FD36A594F5392ECC6676FB067E", hash_generated_field = "FC6E9E67F7C574177CE753C7489C4618")

    private  short mTnf;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:50.182 -0500", hash_original_field = "02021AF113766BA7259B504B1AEBB664", hash_generated_field = "FA16B2C82206522641561377B9DC2980")

    private  byte[] mType;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:50.184 -0500", hash_original_field = "81204E2516309774DDE98BCC95D4D337", hash_generated_field = "5D33188695F224858D1BE9A3A3EAF57E")

    private  byte[] mId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:50.187 -0500", hash_original_field = "B488518580220CDE77700DD339E32E73", hash_generated_field = "BD2E694BF3C185368FEB2F1DFAEB0E21")

    private  byte[] mPayload;

    /**
     * Construct an NDEF Record.
     * <p>
     * Applications should not attempt to manually chunk NDEF Records - the
     * implementation of android.nfc will automatically chunk an NDEF Record
     * when necessary (and only present a single logical NDEF Record to the
     * application). So applications should not use TNF_UNCHANGED.
     *
     * @param tnf  a 3-bit TNF constant
     * @param type byte array, containing zero to 255 bytes, must not be null
     * @param id   byte array, containing zero to 255 bytes, must not be null
     * @param payload byte array, containing zero to (2 ** 32 - 1) bytes,
     *                must not be null
     */
    @DSComment("data structure")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:50.189 -0500", hash_original_method = "FB48E937FC56CBD69B2A6F082227DD21", hash_generated_method = "DE7D3367A8D67D13F8EFFB1D24B2E12A")
    
public NdefRecord(short tnf, byte[] type, byte[] id, byte[] payload) {
        /* New NDEF records created by applications will have FLAG_MB|FLAG_ME
         * set by default; when multiple records are stored in a
         * {@link NdefMessage}, these flags will be corrected when the {@link NdefMessage}
         * is serialized to bytes.
         */
        this(tnf, type, id, payload, (byte)(FLAG_MB|FLAG_ME));
    }

    /**
     * @hide
     */
    /*package*/ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:50.193 -0500", hash_original_method = "EE3B4F476C5F89F900E25765E0C165C3", hash_generated_method = "961FF791CC666F3AAF3C78B505441DCD")
    
NdefRecord(short tnf, byte[] type, byte[] id, byte[] payload, byte flags) {
        /* check arguments */
        if ((type == null) || (id == null) || (payload == null)) {
            throw new IllegalArgumentException("Illegal null argument");
        }

        if (tnf < 0 || tnf > 0x07) {
            throw new IllegalArgumentException("TNF out of range " + tnf);
        }

        /* Determine if it is a short record */
        if(payload.length < 0xFF) {
            flags |= FLAG_SR;
        }

        /* Determine if an id is present */
        if(id.length != 0) {
            flags |= FLAG_IL;
        }

        mFlags = flags;
        mTnf = tnf;
        mType = type.clone();
        mId = id.clone();
        mPayload = payload.clone();
    }

    /**
     * Construct an NDEF Record from raw bytes.
     * <p>
     * Validation is performed to make sure the header is valid, and that
     * the id, type and payload sizes appear to be valid.
     *
     * @throws FormatException if the data is not a valid NDEF record
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:50.195 -0500", hash_original_method = "561B574EC53AB1A329985993E495C9F0", hash_generated_method = "1DCBA1D03F3F996ED1B58E40CD13370A")
    
public NdefRecord(byte[] data) throws FormatException {
        /* Prevent compiler to complain about unassigned final fields */
        mFlags = 0;
        mTnf = 0;
        mType = null;
        mId = null;
        mPayload = null;
        /* Perform actual parsing */
        if (parseNdefRecord(data) == -1) {
            throw new FormatException("Error while parsing NDEF record");
        }
    }

    /**
     * Returns the 3-bit TNF.
     * <p>
     * TNF is the top-level type.
     */
    @DSComment("data structure")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSource({DSSourceKind.NFC})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:50.198 -0500", hash_original_method = "57FC26158D8D678057BEA3A3771FCDE7", hash_generated_method = "22099949C0FAB7BEF77A26E027911AEC")
    
public short getTnf() {
        return mTnf;
    }

    /**
     * Returns the variable length Type field.
     * <p>
     * This should be used in conjunction with the TNF field to determine the
     * payload format.
     */
    @DSComment("data structure")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSource({DSSourceKind.NFC})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:50.200 -0500", hash_original_method = "4BBEB3385EB023476A7C83C1132C6B8B", hash_generated_method = "D8BB2EC57A2C6F99A2F5BCBDBE2BFCC7")
    
public byte[] getType() {
        return mType.clone();
    }

    /**
     * Returns the variable length ID.
     */
    @DSSource({DSSourceKind.NFC})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:50.202 -0500", hash_original_method = "9D6A9E4635BF3A5F066D2AADCC504C7A", hash_generated_method = "04D08F0620A42926911203A7CA2E323E")
    
public byte[] getId() {
        return mId.clone();
    }

    /**
     * Returns the variable length payload.
     */
    @DSComment("data structure")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSource({DSSourceKind.NFC})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:50.204 -0500", hash_original_method = "1327F8BA6EFB58D178B7F3819A329700", hash_generated_method = "3209572B1428FC77D1ED81F46732F85B")
    
public byte[] getPayload() {
        return mPayload.clone();
    }

    /**
     * Returns this entire NDEF Record as a byte array.
     */
    @DSSource({DSSourceKind.NFC})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:50.219 -0500", hash_original_method = "7310D9773CC55767E043FA59CD9561A6", hash_generated_method = "167F1A71240323606EF2A3640EEF2806")
    
public byte[] toByteArray() {
        return generate(mFlags, mTnf, mType, mId, mPayload);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:50.221 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:50.223 -0500", hash_original_method = "747D030979ABC5D8CF3744986AE0C078", hash_generated_method = "141A004EE98FAF7DF9065F59BF3242C4")
    
public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mFlags);
        dest.writeInt(mTnf);
        dest.writeInt(mType.length);
        dest.writeByteArray(mType);
        dest.writeInt(mId.length);
        dest.writeByteArray(mId);
        dest.writeInt(mPayload.length);
        dest.writeByteArray(mPayload);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:50.235 -0500", hash_original_method = "D593336128142C3B83A1F96FE0DB1162", hash_generated_method = "948BCAA76573AA6593E66D6B93F9CD97")
    
    private int parseNdefRecord(byte[] data){
    	//Formerly a native method
    	addTaint(data[0]);
    	return getTaintInt();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:50.239 -0500", hash_original_method = "D4618511B086F2DC6D5A6E1B49747B83", hash_generated_method = "FC256F17E644931C0DB024D180B055A7")
    
    private byte[] generate(short flags, short tnf, byte[] type, byte[] id, byte[] data){
    	//Formerly a native method
    	addTaint(flags);
    	addTaint(tnf);
    	addTaint(type[0]);
    	addTaint(id[0]);
    	addTaint(data[0]);
    	return new byte[]{getTaintByte(),};
    }

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

