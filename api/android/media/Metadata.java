package android.media;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;
import java.util.TimeZone;

import android.os.Parcel;

public class Metadata {

    /**
     * @return the last available system metadata id. Ids are
     *         1-indexed.
     * {@hide}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.264 -0500", hash_original_method = "AC3959C23D9D2B833BF205454A7AC37B", hash_generated_method = "DF08164105135FCC1F2F5D33DE9CBC1D")
    
public static int lastSytemId() { return LAST_SYSTEM; }

    /**
     * @return the first available cutom metadata id.
     * {@hide}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.266 -0500", hash_original_method = "A3BB27B058661F9493F9E36DE58FA3AF", hash_generated_method = "FD8919870C4B78DE68C373778DD1C460")
    
public static int firstCustomId() { return FIRST_CUSTOM; }

    /**
     * @return the last value of known type. Types are 1-indexed.
     * {@hide}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.268 -0500", hash_original_method = "052C2B95D491FF5821B86CDE29761657", hash_generated_method = "7737C7C614D1CBB7DAC3856CA594A628")
    
public static int lastType() { return LAST_TYPE; }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.087 -0500", hash_original_field = "C58D69EBC304F6DD885B9BE53DB445AB", hash_generated_field = "715842CB4BE4C305533893ABFD517C77")

    // weight strings. We considered using Bundle to ship the metadata
    // between the native layer and the java layer but dropped that
    // option since keeping in sync a native implementation of Bundle
    // and the java one would be too burdensome. Besides Bundle uses
    // String for its keys.
    // The key range [0 8192) is reserved for the system.
    //
    // We manually serialize the data in Parcels. For large memory
    // blob (bitmaps, raw pictures) we use MemoryFile which allow the
    // client to make the data purge-able once it is done with it.
    //

    /**
     * {@hide}
     */
    public static final int ANY = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.091 -0500", hash_original_field = "C5B06AEE4F0E9FDC630C9F7A447829E1", hash_generated_field = "9D2C8A53DFB58500A5365E0097C601B5")

                                      // Keep in sync with kAny in MediaPlayerService.cpp

    // Playback capabilities.
    /**
     * Indicate whether the media can be paused
     */
    public static final int PAUSE_AVAILABLE         = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.094 -0500", hash_original_field = "4D464F8E3BC3CB2FCFE087597168180A", hash_generated_field = "C072CB2D2A0C57AF457109C96DFDE066")

    /**
     * Indicate whether the media can be backward seeked
     */
    public static final int SEEK_BACKWARD_AVAILABLE = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.097 -0500", hash_original_field = "9D6A337917C54518857F71B9EADD351C", hash_generated_field = "8B1F1E52000B9843FA5E2BD263771900")

    /**
     * Indicate whether the media can be forward seeked
     */
    public static final int SEEK_FORWARD_AVAILABLE  = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.100 -0500", hash_original_field = "752D16F8241FAF73CD7452642B2BD448", hash_generated_field = "F03E1A90D43C711F681C0415A46926E0")

    /**
     * Indicate whether the media can be seeked
     */
    public static final int SEEK_AVAILABLE          = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.103 -0500", hash_original_field = "03DB4E16A8E5C10DEFE74D537CCE5FCD", hash_generated_field = "7A02626DF44C3703D600A5DAC54B3306")

    // TODO: Should we use numbers compatible with the metadata retriever?
    /**
     * {@hide}
     */
    public static final int TITLE                   = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.105 -0500", hash_original_field = "7D3C4BFFEBC035CA15E54B96E8CB3A27", hash_generated_field = "621A1D2306A16DBA98A14B6EF73FFF42")

    /**
     * {@hide}
     */
    public static final int COMMENT                 = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.108 -0500", hash_original_field = "83488BAAF90A8011761A23B1C56A641E", hash_generated_field = "CA47CCC855D21BFFD088F68A8C7F15A8")

    /**
     * {@hide}
     */
    public static final int COPYRIGHT               = 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.111 -0500", hash_original_field = "B30250A4AF5899B8E349586BC9E77F2A", hash_generated_field = "FEE0D41F202489993777102296C8B8B6")

    /**
     * {@hide}
     */
    public static final int ALBUM                   = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.114 -0500", hash_original_field = "1A14CC2D5680E268ECFAE2463CEE84E5", hash_generated_field = "9FEE503F499C1CD1FB51D8270C133FBF")

    /**
     * {@hide}
     */
    public static final int ARTIST                  = 9;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.117 -0500", hash_original_field = "102317E2324000377F4AEB13B73E066F", hash_generated_field = "15512B9247F1587BA0C97381179C6A18")

    /**
     * {@hide}
     */
    public static final int AUTHOR                  = 10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.120 -0500", hash_original_field = "F1AD7142870507DCB2A0984BB922E1FE", hash_generated_field = "6D50E24C997BFD259CF66C8B034EA114")

    /**
     * {@hide}
     */
    public static final int COMPOSER                = 11;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.122 -0500", hash_original_field = "A0C89EADC227DE071CD3B69A63C2FD9F", hash_generated_field = "FE3EDC5D087C51B45360F3C048FFC3A6")

    /**
     * {@hide}
     */
    public static final int GENRE                   = 12;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.125 -0500", hash_original_field = "8DBD7C6821F7CCA38B8F51D0F919649E", hash_generated_field = "2987402C9B1C536E8DA835DD6BB2F7A0")

    /**
     * {@hide}
     */
    public static final int DATE                    = 13;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.127 -0500", hash_original_field = "2131059E0CCF68EE336A9E9447B96CFD", hash_generated_field = "81C9FE110D75DC7667B41DC4B4C0D5A7")

    /**
     * {@hide}
     */
    public static final int DURATION                = 14;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.130 -0500", hash_original_field = "A5B11B0992B137F0797661DEA5CF6D71", hash_generated_field = "39EAA05BD1DE04C4E0E50B476E3F3F12")

    /**
     * {@hide}
     */
    public static final int CD_TRACK_NUM            = 15;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.132 -0500", hash_original_field = "8CCAB9E9A4C624821157ED1533932B9C", hash_generated_field = "1BC02E8972AA502CF1FFE598EAABBD2E")

    /**
     * {@hide}
     */
    public static final int CD_TRACK_MAX            = 16;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.135 -0500", hash_original_field = "D5DF09137DD0FC3DC6C889171A4D63D7", hash_generated_field = "E82EDB457197B958AC5EF9BFEB3A2B88")

    /**
     * {@hide}
     */
    public static final int RATING                  = 17;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.138 -0500", hash_original_field = "61DEA090DF4AB34402460074E5C7163D", hash_generated_field = "F6A6707734E53C21645C27EF5C3274F2")

    /**
     * {@hide}
     */
    public static final int ALBUM_ART               = 18;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.141 -0500", hash_original_field = "9C938CB3BF79146C5DB37D3E6C7EA4EF", hash_generated_field = "0073A892DA400182A294269FE7164E7A")

    /**
     * {@hide}
     */
    public static final int VIDEO_FRAME             = 19;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.144 -0500", hash_original_field = "9C9F73642CE7E0B90158C6F2A9B6607A", hash_generated_field = "55B1D0F0443317AF585FDF5C39AB01AB")

    /**
     * {@hide}
     */
    public static final int BIT_RATE                = 20;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.147 -0500", hash_original_field = "7BF343AEE15011A5BAB453A1890E87AD", hash_generated_field = "C1BAF24E58A97689273CDE98D554BEF5")

                                                          // all the streams in bps.

    /**
     * {@hide}
     */
    public static final int AUDIO_BIT_RATE          = 21;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.150 -0500", hash_original_field = "0279916885F945C4FABD15DD3DE16678", hash_generated_field = "57AA8D0BBC64247446757F95229084D4")

    /**
     * {@hide}
     */
    public static final int VIDEO_BIT_RATE          = 22;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.153 -0500", hash_original_field = "2AB3ED0A69F28CB3C268ABC6F00D2E50", hash_generated_field = "71C5499FDF4689783260587FF30C083D")

    /**
     * {@hide}
     */
    public static final int AUDIO_SAMPLE_RATE       = 23;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.156 -0500", hash_original_field = "1DBAEF1AB431724983D072AF5CDC262B", hash_generated_field = "DE0172E5A8EDFD054595723F3D68F352")

    /**
     * {@hide}
     */
    public static final int VIDEO_FRAME_RATE        = 24;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.159 -0500", hash_original_field = "001C65B122B7D008E7AD382FDC3B1F7E", hash_generated_field = "A2D66E24C3CD37E80BA72AEF9A078284")

    // See RFC2046 and RFC4281.
    /**
     * {@hide}
     */
    public static final int MIME_TYPE               = 25;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.162 -0500", hash_original_field = "FDC56573078EF7C822458C75A167AB4E", hash_generated_field = "6FC1E5075EB36AAD1CEA1B0C91F8EBD6")

    /**
     * {@hide}
     */
    public static final int AUDIO_CODEC             = 26;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.164 -0500", hash_original_field = "E0A7D9DCA2B387FF74CB422FA96E34EA", hash_generated_field = "FAB787B9D27A85D554756C2C369206FC")

    /**
     * {@hide}
     */
    public static final int VIDEO_CODEC             = 27;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.168 -0500", hash_original_field = "9372A4FA403BBF7F7666D04CDAE8CBFF", hash_generated_field = "67AE7CD3998073118897918776C3E96A")

    /**
     * {@hide}
     */
    public static final int VIDEO_HEIGHT            = 28;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.170 -0500", hash_original_field = "F6DE41B9C1597E0498205F326CFEDB7B", hash_generated_field = "43A6C367AA8FEBE5FDA79C4D25286B6A")

    /**
     * {@hide}
     */
    public static final int VIDEO_WIDTH             = 29;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.173 -0500", hash_original_field = "AD2D5EA4A5E3EBC74774E0640FC9545F", hash_generated_field = "D87FA5206A0843E15E8C6C570B614E51")

    /**
     * {@hide}
     */
    public static final int NUM_TRACKS              = 30;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.176 -0500", hash_original_field = "5DB6D35FDA2A51DBAA098E327D6E9802", hash_generated_field = "2A36058E113FEEC1E91DB38DD388FA9B")

    /**
     * {@hide}
     */
    public static final int DRM_CRIPPLED            = 31;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.178 -0500", hash_original_field = "0D74D2C38B69D67FBBBC8DA2632BDCCA", hash_generated_field = "138468D81E8995E87BF04E16A5FD4F56")

    private static final int LAST_SYSTEM = 31;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.181 -0500", hash_original_field = "7CB529FCDE2E5DF87420F8023953DF7F", hash_generated_field = "1293C8B3CCCB6F01014120B141F15535")

    private static final int FIRST_CUSTOM = 8192;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.184 -0500", hash_original_field = "A6992AD1CD0CF6C408C3FB6D1BAC81C1", hash_generated_field = "D4CD99052BE2F1C196D826227FE49F08")

    /**
     * {@hide}
     */
    public static final Set<Integer> MATCH_NONE = Collections.EMPTY_SET;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.186 -0500", hash_original_field = "54585D081C0229987DB2471CCDC0C844", hash_generated_field = "CC8D0ACD77DAAAA0E3403FBFC54E8016")

    public static final Set<Integer> MATCH_ALL = Collections.singleton(ANY);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.189 -0500", hash_original_field = "CAF0B43214F9297799CAE7EC59E26148", hash_generated_field = "A62FB349802C75EDFC168254DBA3EFBF")

    public static final int STRING_VAL     = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.191 -0500", hash_original_field = "35B7260699CF13D3AB2FD387AD9737A2", hash_generated_field = "271E0941B952E3A622F2B9CB332E88D0")

    public static final int INTEGER_VAL    = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.194 -0500", hash_original_field = "A1F1A0540596A9103BBE04A5B31DA969", hash_generated_field = "2C69BCCDD399B6924E68CFAF66290A6E")

    public static final int BOOLEAN_VAL    = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.197 -0500", hash_original_field = "721BBAD6FDC118216A202258D9F049C6", hash_generated_field = "7D1B17D2C9091932A4FDD599FA016B84")

    public static final int LONG_VAL       = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.200 -0500", hash_original_field = "D26271709E2590078DD5744054756D65", hash_generated_field = "3F86594A4E751DC1C92107189E8C1605")

    public static final int DOUBLE_VAL     = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.203 -0500", hash_original_field = "3A780B38180F5EEF45728E245E331844", hash_generated_field = "CB15A3E308CC118919DC8966A9D3476B")

    public static final int DATE_VAL       = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.207 -0500", hash_original_field = "F443C1D4EA309A5A87A4B48489638DBA", hash_generated_field = "4913EDEFCF294DFFCAC4DF9B4D1A7A36")

    public static final int BYTE_ARRAY_VAL = 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.209 -0500", hash_original_field = "D27483C54FE3ED095650401783A34399", hash_generated_field = "9157FC70E8F81740F0D26733FACA7F1B")

    // FIXME: misses a type for bitmaps.
    private static final int LAST_TYPE = 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.213 -0500", hash_original_field = "B567227F9D09314929E33B694C326ABD", hash_generated_field = "EC6F98E58115DB1A9B2DE74236D3700C")

    private static final String TAG = "media.Metadata";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.216 -0500", hash_original_field = "67124C06F23D8612F74902D83443C7E5", hash_generated_field = "B38D3572DBAFFF8AAEA7DDE94DF97406")

    private static final int kInt32Size = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.218 -0500", hash_original_field = "58C961C8DED1362090088870E2B9B18F", hash_generated_field = "FB5073A1654DE2CF650852DC3CFB72C4")

    private static final int kMetaHeaderSize = 2 * kInt32Size;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.222 -0500", hash_original_field = "B5BF7555D65CF00C5A919D426425A78F", hash_generated_field = "C8DFC1C86B7C58B1324649FBB87DF241")

    private static final int kRecordHeaderSize = 3 * kInt32Size;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.224 -0500", hash_original_field = "D097CF27B3F514A0FA142C4E15D9287E", hash_generated_field = "DEB70152C7D87EED0BC5674B9F2A6028")

    private static final int kMetaMarker = 0x4d455441;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.226 -0500", hash_original_field = "A291CB568559F5F870526FB6632A3C7D", hash_generated_field = "0D98F92EEDEB7FCEA0EDE0BDBBD7A022")

    // After a successful parsing, set the parcel with the serialized metadata.
    private Parcel mParcel;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.229 -0500", hash_original_field = "BF763D9F60AB5ED7B77ECFF18A53AA4A", hash_generated_field = "F64E89B944F40963F0668F1CC6C7A42B")

    // the record's payload in the parcel.
    // Used to look up if a key was present too.
    // Key: Metadata ID
    // Value: Offset of the metadata type field in the record.
    private final HashMap<Integer, Integer> mKeyToPosMap =
            new HashMap<Integer, Integer>();

    /**
     * {@hide}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.232 -0500", hash_original_method = "42EB03B7CCF72771EC09BC7329CF6561", hash_generated_method = "CF0B8922A36F31DD9957EECFBC74138D")
    
public Metadata() { }

    /**
     * Go over all the records, collecting metadata keys and records'
     * type field offset in the Parcel. These are stored in
     * mKeyToPosMap for latter retrieval.
     * Format of a metadata record:
     <pre>
                         1                   2                   3
      0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1
      +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
      |                     record size                               |
      +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
      |                     metadata key                              |  // TITLE
      +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
      |                     metadata type                             |  // STRING_VAL
      +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
      |                                                               |
      |                .... metadata payload ....                     |
      |                                                               |
      +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
     </pre>
     * @param parcel With the serialized records.
     * @param bytesLeft How many bytes in the parcel should be processed.
     * @return false if an error occurred during parsing.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.235 -0500", hash_original_method = "AD5931B1126E13DCBE3F825449AFE253", hash_generated_method = "DAAD326DEF66E04DAB4729BFCCE73FC1")
    
private boolean scanAllRecords(Parcel parcel, int bytesLeft) {
        int recCount = 0;
        boolean error = false;

        mKeyToPosMap.clear();
        while (bytesLeft > kRecordHeaderSize) {
            final int start = parcel.dataPosition();
            // Check the size.
            final int size = parcel.readInt();

            if (size <= kRecordHeaderSize) {  // at least 1 byte should be present.
                Log.e(TAG, "Record is too short");
                error = true;
                break;
            }

            // Check the metadata key.
            final int metadataId = parcel.readInt();
            if (!checkMetadataId(metadataId)) {
                error = true;
                break;
            }

            // Store the record offset which points to the type
            // field so we can later on read/unmarshall the record
            // payload.
            if (mKeyToPosMap.containsKey(metadataId)) {
                Log.e(TAG, "Duplicate metadata ID found");
                error = true;
                break;
            }

            mKeyToPosMap.put(metadataId, parcel.dataPosition());

            // Check the metadata type.
            final int metadataType = parcel.readInt();
            if (metadataType <= 0 || metadataType > LAST_TYPE) {
                Log.e(TAG, "Invalid metadata type " + metadataType);
                error = true;
                break;
            }

            // Skip to the next one.
            parcel.setDataPosition(start + size);
            bytesLeft -= size;
            ++recCount;
        }

        if (0 != bytesLeft || error) {
            Log.e(TAG, "Ran out of data or error on record " + recCount);
            mKeyToPosMap.clear();
            return false;
        } else {
            return true;
        }
    }

    /**
     * Check a parcel containing metadata is well formed. The header
     * is checked as well as the individual records format. However, the
     * data inside the record is not checked because we do lazy access
     * (we check/unmarshall only data the user asks for.)
     *
     * Format of a metadata parcel:
     <pre>
                         1                   2                   3
      0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1
      +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
      |                     metadata total size                       |
      +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
      |     'M'       |     'E'       |     'T'       |     'A'       |
      +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
      |                                                               |
      |                .... metadata records ....                     |
      |                                                               |
      +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
     </pre>
     *
     * @param parcel With the serialized data. Metadata keeps a
     *               reference on it to access it later on. The caller
     *               should not modify the parcel after this call (and
     *               not call recycle on it.)
     * @return false if an error occurred.
     * {@hide}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.238 -0500", hash_original_method = "35CAF9C1FD62AB3C548A70E81DF2A0C5", hash_generated_method = "F97479174CA749CD7BA34C28FAF54DE1")
    
public boolean parse(Parcel parcel) {
        if (parcel.dataAvail() < kMetaHeaderSize) {
            Log.e(TAG, "Not enough data " + parcel.dataAvail());
            return false;
        }

        final int pin = parcel.dataPosition();  // to roll back in case of errors.
        final int size = parcel.readInt();

        // The extra kInt32Size below is to account for the int32 'size' just read.
        if (parcel.dataAvail() + kInt32Size < size || size < kMetaHeaderSize) {
            Log.e(TAG, "Bad size " + size + " avail " + parcel.dataAvail() + " position " + pin);
            parcel.setDataPosition(pin);
            return false;
        }

        // Checks if the 'M' 'E' 'T' 'A' marker is present.
        final int kShouldBeMetaMarker = parcel.readInt();
        if (kShouldBeMetaMarker != kMetaMarker ) {
            Log.e(TAG, "Marker missing " + Integer.toHexString(kShouldBeMetaMarker));
            parcel.setDataPosition(pin);
            return false;
        }

        // Scan the records to collect metadata ids and offsets.
        if (!scanAllRecords(parcel, size - kMetaHeaderSize)) {
            parcel.setDataPosition(pin);
            return false;
        }
        mParcel = parcel;
        return true;
    }

    /**
     * @return The set of metadata ID found.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.241 -0500", hash_original_method = "87FE67157845253CBCE0E047F3C9B374", hash_generated_method = "B22EFBDB6372E9DF92492AD09365B351")
    
public Set<Integer> keySet() {
        return mKeyToPosMap.keySet();
    }

    /**
     * @return true if a value is present for the given key.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.243 -0500", hash_original_method = "7767A5018B3458E07A2B7B3389E3B1D0", hash_generated_method = "19F4D11432ED135A2AC39581F8B8138D")
    
public boolean has(final int metadataId) {
        if (!checkMetadataId(metadataId)) {
            throw new IllegalArgumentException("Invalid key: " + metadataId);
        }
        return mKeyToPosMap.containsKey(metadataId);
    }

    // Accessors.
    // Caller must make sure the key is present using the {@code has}
    // method otherwise a RuntimeException will occur.

    /**
     * {@hide}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.245 -0500", hash_original_method = "D07ADABDF4536425A343AFD4015AEABD", hash_generated_method = "24C86143FA15024EF6D44A53318A5DB1")
    
public String getString(final int key) {
        checkType(key, STRING_VAL);
        return mParcel.readString();
    }

    /**
     * {@hide}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.247 -0500", hash_original_method = "2E24F7D1E582CF4592E0FE6ACF6159ED", hash_generated_method = "F2729761DDA99F953AD3ADE92393701E")
    
public int getInt(final int key) {
        checkType(key, INTEGER_VAL);
        return mParcel.readInt();
    }

    /**
     * Get the boolean value indicated by key
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.251 -0500", hash_original_method = "92B2C04C5831BF6FBB547313E4BFF6F1", hash_generated_method = "48644966D0703A3A1FECC682EB5F07EB")
    
public boolean getBoolean(final int key) {
        checkType(key, BOOLEAN_VAL);
        return mParcel.readInt() == 1;
    }

    /**
     * {@hide}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.254 -0500", hash_original_method = "B0F0000F85D960C325C9AE562DB8183E", hash_generated_method = "5234CDAD4CEBA829E2DCD095D6112569")
    
public long getLong(final int key) {
        checkType(key, LONG_VAL);    /**
     * {@hide}
     */
        return mParcel.readLong();
    }

    /**
     * {@hide}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.256 -0500", hash_original_method = "C463F992BA89266506A75490D5B4B789", hash_generated_method = "94DB81D9FA576A5CAC0F3432C921BBC1")
    
public double getDouble(final int key) {
        checkType(key, DOUBLE_VAL);
        return mParcel.readDouble();
    }

    /**
     * {@hide}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.259 -0500", hash_original_method = "7682E02DAB96764259A6698B858B1834", hash_generated_method = "09C98B24B2915D8F4DCA34F2CD8FFB19")
    
public byte[] getByteArray(final int key) {
        checkType(key, BYTE_ARRAY_VAL);
        return mParcel.createByteArray();
    }

    /**
     * {@hide}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.261 -0500", hash_original_method = "AAEF3D01D729AC9D47A3AB4C5693312B", hash_generated_method = "BB35DF3820004B64C5CC490ED47438BB")
    
public Date getDate(final int key) {
        checkType(key, DATE_VAL);
        final long timeSinceEpoch = mParcel.readLong();
        final String timeZone = mParcel.readString();

        if (timeZone.length() == 0) {
            return new Date(timeSinceEpoch);
        } else {
            TimeZone tz = TimeZone.getTimeZone(timeZone);
            Calendar cal = Calendar.getInstance(tz);

            cal.setTimeInMillis(timeSinceEpoch);
            return cal.getTime();
        }
    }

    /**
     * Check val is either a system id or a custom one.
     * @param val Metadata key to test.
     * @return true if it is in a valid range.
     **/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.271 -0500", hash_original_method = "6E38B18258B92FBBE9034AE151B9B0E7", hash_generated_method = "38923C15994EF8EE04FB0B3ECEB1DFC6")
    
private boolean checkMetadataId(final int val) {
        if (val <= ANY || (LAST_SYSTEM < val && val < FIRST_CUSTOM)) {
            Log.e(TAG, "Invalid metadata ID " + val);
            return false;
        }
        return true;
    }

    /**
     * Check the type of the data match what is expected.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:31.274 -0500", hash_original_method = "E71E62CC93A8C30E28BB789565435B56", hash_generated_method = "4F7A5D7FFD60C28EAF0C9AC62631B4C4")
    
private void checkType(final int key, final int expectedType) {
        final int pos = mKeyToPosMap.get(key);

        mParcel.setDataPosition(pos);

        final int type = mParcel.readInt();
        if (type != expectedType) {
            throw new IllegalStateException("Wrong type " + expectedType + " but got " + type);
        }
    }
}

