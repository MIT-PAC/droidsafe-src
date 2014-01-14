package android.media;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.HashMap;
import java.util.List;

import android.media.DecoderCapabilities.AudioDecoder;
import android.media.DecoderCapabilities.VideoDecoder;
import android.mtp.MtpConstants;

public class MediaFile {

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:27.976 -0500", hash_original_method = "9580D55967DC9BBB4B34535D7F5160BB", hash_generated_method = "D0293C22F3A2D19024F5077248D61EE9")
    
static void addFileType(String extension, int fileType, String mimeType) {
        sFileTypeMap.put(extension, new MediaFileType(fileType, mimeType));
        sMimeTypeMap.put(mimeType, Integer.valueOf(fileType));
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:27.978 -0500", hash_original_method = "5ADC35196E775CC51F3FAECE85209DA3", hash_generated_method = "9EEF8D0441B302ED4AE9AA1B6788FEDA")
    
static void addFileType(String extension, int fileType, String mimeType, int mtpFormatCode) {
        addFileType(extension, fileType, mimeType);
        sFileTypeToFormatMap.put(extension, Integer.valueOf(mtpFormatCode));
        sMimeTypeToFormatMap.put(mimeType, Integer.valueOf(mtpFormatCode));
        sFormatToMimeTypeMap.put(mtpFormatCode, mimeType);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:27.981 -0500", hash_original_method = "EB561C10A3096195B06F44E542693A95", hash_generated_method = "BE7BCD58106946CA1E56AA45B78E1C0C")
    
private static boolean isWMAEnabled() {
        List<AudioDecoder> decoders = DecoderCapabilities.getAudioDecoders();
        int count = decoders.size();
        for (int i = 0; i < count; i++) {
            AudioDecoder decoder = decoders.get(i);
            if (decoder == AudioDecoder.AUDIO_DECODER_WMA) {
                return true;
            }
        }
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:27.984 -0500", hash_original_method = "EF827E9EEC47276564675B91D79934FE", hash_generated_method = "17E0134073FA113A9DD851004C5BB064")
    
private static boolean isWMVEnabled() {
        List<VideoDecoder> decoders = DecoderCapabilities.getVideoDecoders();
        int count = decoders.size();
        for (int i = 0; i < count; i++) {
            VideoDecoder decoder = decoders.get(i);
            if (decoder == VideoDecoder.VIDEO_DECODER_WMV) {
                return true;
            }
        }
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:27.987 -0500", hash_original_method = "DA18F96D371A298D5D2559868787D5B1", hash_generated_method = "F6329ADF0A0274F4B579E01861CCDFD5")
    
public static boolean isAudioFileType(int fileType) {
        return ((fileType >= FIRST_AUDIO_FILE_TYPE &&
                fileType <= LAST_AUDIO_FILE_TYPE) ||
                (fileType >= FIRST_MIDI_FILE_TYPE &&
                fileType <= LAST_MIDI_FILE_TYPE));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:27.989 -0500", hash_original_method = "4284E103143F5BF37CFE3BC757F15B89", hash_generated_method = "3ECBD954B436E41172A590852C7B9033")
    
public static boolean isVideoFileType(int fileType) {
        return (fileType >= FIRST_VIDEO_FILE_TYPE &&
                fileType <= LAST_VIDEO_FILE_TYPE)
            || (fileType >= FIRST_VIDEO_FILE_TYPE2 &&
                fileType <= LAST_VIDEO_FILE_TYPE2);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:27.992 -0500", hash_original_method = "6A87A137C4F44D211B01EBA23582C44A", hash_generated_method = "85A4C6676B593EB9C4CC45ACDFA9E1AC")
    
public static boolean isImageFileType(int fileType) {
        return (fileType >= FIRST_IMAGE_FILE_TYPE &&
                fileType <= LAST_IMAGE_FILE_TYPE);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:27.995 -0500", hash_original_method = "7D8BD015E1AD4A5A5407C25DA5B17526", hash_generated_method = "BB9FAF890CE0F2A4A5D8E62859D84EB1")
    
public static boolean isPlayListFileType(int fileType) {
        return (fileType >= FIRST_PLAYLIST_FILE_TYPE &&
                fileType <= LAST_PLAYLIST_FILE_TYPE);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:27.998 -0500", hash_original_method = "8430DBC8DC8BBD85457A5669BBCC175B", hash_generated_method = "B4FB975485FE27459458B86EB0F926E3")
    
public static boolean isDrmFileType(int fileType) {
        return (fileType >= FIRST_DRM_FILE_TYPE &&
                fileType <= LAST_DRM_FILE_TYPE);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:28.001 -0500", hash_original_method = "997C8E512219C76F5FA2162985EF6563", hash_generated_method = "E83444A2DBFD75769EE28D12F823C5E4")
    
public static MediaFileType getFileType(String path) {
        int lastDot = path.lastIndexOf(".");
        if (lastDot < 0)
            return null;
        return sFileTypeMap.get(path.substring(lastDot + 1).toUpperCase());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:28.004 -0500", hash_original_method = "BC8EB22AE16404BA776834BC8AAECFBB", hash_generated_method = "889D95A05664D1918909A186B31B1B91")
    
public static boolean isMimeTypeMedia(String mimeType) {
        int fileType = getFileTypeForMimeType(mimeType);
        return isAudioFileType(fileType) || isVideoFileType(fileType)
                || isImageFileType(fileType) || isPlayListFileType(fileType);
    }

    // generates a title based on file name
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:28.007 -0500", hash_original_method = "3F19F8DD2C222D6218E9AC3506AA6F51", hash_generated_method = "A9D2E1840AFF4FF6459802D242982C4D")
    
public static String getFileTitle(String path) {
        // extract file name after last slash
        int lastSlash = path.lastIndexOf('/');
        if (lastSlash >= 0) {
            lastSlash++;
            if (lastSlash < path.length()) {
                path = path.substring(lastSlash);
            }
        }
        // truncate the file extension (if any)
        int lastDot = path.lastIndexOf('.');
        if (lastDot > 0) {
            path = path.substring(0, lastDot);
        }
        return path;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:28.009 -0500", hash_original_method = "AE7611CC1A1F6BB85819111B6E8FAA8F", hash_generated_method = "20240E1A1704C4269C8EB08E5EE34545")
    
public static int getFileTypeForMimeType(String mimeType) {
        Integer value = sMimeTypeMap.get(mimeType);
        return (value == null ? 0 : value.intValue());
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:28.013 -0500", hash_original_method = "B740F3517DEF0D033D718183586443F5", hash_generated_method = "E2DA79676DB455181597BC59A9868F6D")
    
public static String getMimeTypeForFile(String path) {
        MediaFileType mediaFileType = getFileType(path);
        return (mediaFileType == null ? null : mediaFileType.mimeType);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:28.016 -0500", hash_original_method = "F784BFEEDA63FFDBB89B9FE90BE1C317", hash_generated_method = "D08C2147C1C4AFC3F67DF62FD5EECDB5")
    
public static int getFormatCode(String fileName, String mimeType) {
        if (mimeType != null) {
            Integer value = sMimeTypeToFormatMap.get(mimeType);
            if (value != null) {
                return value.intValue();
            }
        }
        int lastDot = fileName.lastIndexOf('.');
        if (lastDot > 0) {
            String extension = fileName.substring(lastDot + 1);
            Integer value = sFileTypeToFormatMap.get(extension);
            if (value != null) {
                return value.intValue();
            }
        }
        return MtpConstants.FORMAT_UNDEFINED;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:28.019 -0500", hash_original_method = "774B4347757F4357102FC259B06A2804", hash_generated_method = "0F7D4A858D5392B2441FC5552BAC51E7")
    
public static String getMimeTypeForFormatCode(int formatCode) {
        return sFormatToMimeTypeMap.get(formatCode);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:27.796 -0500", hash_original_field = "20D11ED641233F8E64DC613F7697EFC5", hash_generated_field = "0442E65E46FD86EDDDD9D9538674D39B")

    public static final int FILE_TYPE_MP3     = 1;
    
    public static class MediaFileType {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:27.952 -0500", hash_original_field = "1CEDD8F802C3C43A6F8EE83BD24E353E", hash_generated_field = "8B71EC67105E5F27E184B46882300AAD")

        public  int fileType;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:27.955 -0500", hash_original_field = "199378A118748448CD8C8A5B6EE3C464", hash_generated_field = "7392B175222DBFE73444BEBB76802D17")

        public  String mimeType;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:27.958 -0500", hash_original_method = "5DA6BED04674A9B9CD299FCBDC3FDFAE", hash_generated_method = "5DA6BED04674A9B9CD299FCBDC3FDFAE")
        
MediaFileType(int fileType, String mimeType) {
            this.fileType = fileType;
            this.mimeType = mimeType;
        }
        
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:27.799 -0500", hash_original_field = "52758B25CC40897D0930F30E8C4ADC29", hash_generated_field = "7D7076EFC4D195B2A48868CCCB0FD5C9")

    public static final int FILE_TYPE_M4A     = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:27.802 -0500", hash_original_field = "F13152411A3BFF7D4EDEB6E899E0B003", hash_generated_field = "291468B4AB468DE19D9F157B0D3C576B")

    public static final int FILE_TYPE_WAV     = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:27.804 -0500", hash_original_field = "98A93361EBAA259846FFDC40B5B4AF71", hash_generated_field = "C74E05E6D4DBEE1D61D79BF0E59AA71D")

    public static final int FILE_TYPE_AMR     = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:27.807 -0500", hash_original_field = "D0ED9E041ECB88416F1C05E295F8236B", hash_generated_field = "06F3488C5825D9D185E2D816DC8F2043")

    public static final int FILE_TYPE_AWB     = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:27.809 -0500", hash_original_field = "69B591780E455B16A288E6CCD2775918", hash_generated_field = "12C6FFB9120905667F06E399F164BAAB")

    public static final int FILE_TYPE_WMA     = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:27.812 -0500", hash_original_field = "355E1320359864AE72AFF3FA00AEE7EA", hash_generated_field = "C92A8F448677A0CEA782842C64F7DE03")

    public static final int FILE_TYPE_OGG     = 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:27.815 -0500", hash_original_field = "51153CC06EEDBFFE27BB488BC1A7DCCD", hash_generated_field = "B2C7DF1BF8EE908ACE7416F2F6A40727")

    public static final int FILE_TYPE_AAC     = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:27.818 -0500", hash_original_field = "35BA2E74311F51EE8D0568FA37EFF7AC", hash_generated_field = "2040CD52637D8751654F13B330A08926")

    public static final int FILE_TYPE_MKA     = 9;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:27.821 -0500", hash_original_field = "BC0AE9C8A435728B942536641A0FA33D", hash_generated_field = "26225DC01F53BEAA896EF9B43E79D7A1")

    public static final int FILE_TYPE_FLAC    = 10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:27.823 -0500", hash_original_field = "899C34625B1048785C227633E805C98E", hash_generated_field = "02A902E1D03EF8C697526DBE5DC7AFB8")

    private static final int FIRST_AUDIO_FILE_TYPE = FILE_TYPE_MP3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:27.826 -0500", hash_original_field = "FC58FDC4A453211D8C12A626BFAF5519", hash_generated_field = "C72F6CC0BE8097C7708722B945B0E52D")

    private static final int LAST_AUDIO_FILE_TYPE = FILE_TYPE_FLAC;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:27.829 -0500", hash_original_field = "D64BC8D7DBD02788B4F21370469A1932", hash_generated_field = "6A3BDA1789D25F100BA246937BE256D9")

    public static final int FILE_TYPE_MID     = 11;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:27.832 -0500", hash_original_field = "2ABD865D980617F4083C8EB85A1AAB59", hash_generated_field = "63C02284AD93D16052B6F9FD2C6ECE31")

    public static final int FILE_TYPE_SMF     = 12;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:27.835 -0500", hash_original_field = "45CC736A99DFB7E96FA3813289B732C0", hash_generated_field = "EEF318D7DC411B7A579C29DF5B36BECA")

    public static final int FILE_TYPE_IMY     = 13;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:27.838 -0500", hash_original_field = "057BFF3A89D2E7C1CF42DC2CC9302BFD", hash_generated_field = "1673E6DE6A43A074F8E9A5F60B434DD4")

    private static final int FIRST_MIDI_FILE_TYPE = FILE_TYPE_MID;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:27.840 -0500", hash_original_field = "7B54DC154A29727B86FA5C390B66AB19", hash_generated_field = "52DBE39418E679A1B88B61905CA6269D")

    private static final int LAST_MIDI_FILE_TYPE = FILE_TYPE_IMY;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:27.843 -0500", hash_original_field = "F9BE5E78593485DAFC1284E337B564E6", hash_generated_field = "98C569793D1B25B5048191D454FD97BC")

    public static final int FILE_TYPE_MP4     = 21;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:27.846 -0500", hash_original_field = "709D350116CB72F9E5DFB7D3C7459A54", hash_generated_field = "B9470B007040FAB89FEE8130C5690F61")

    public static final int FILE_TYPE_M4V     = 22;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:27.848 -0500", hash_original_field = "B879936715D91133B6E4602CE16DBAA4", hash_generated_field = "DAE93A7610C370D0D5F787E1AE6A55F9")

    public static final int FILE_TYPE_3GPP    = 23;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:27.851 -0500", hash_original_field = "76CCE773944D725D26278F137AA0A965", hash_generated_field = "1E0076505A468D8B8B7D0774AFE02446")

    public static final int FILE_TYPE_3GPP2   = 24;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:27.854 -0500", hash_original_field = "3C5769865FA4C93F89BA814D5997BB5F", hash_generated_field = "A9AE6B5448099A36D1B9C2741FF70EB7")

    public static final int FILE_TYPE_WMV     = 25;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:27.856 -0500", hash_original_field = "DE9AE642CD611C0EABA50EF6844CADB8", hash_generated_field = "47D07672AA7319468643F12B36928075")

    public static final int FILE_TYPE_ASF     = 26;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:27.859 -0500", hash_original_field = "EA75C84BB9C2EA894C56EB1ECA991564", hash_generated_field = "2DAE301C8B949A5966842C777782A31B")

    public static final int FILE_TYPE_MKV     = 27;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:27.862 -0500", hash_original_field = "69AD3509F467277D59EC89A5C272FF0A", hash_generated_field = "FCB5B6415378DA2CC8B505A21B76117A")

    public static final int FILE_TYPE_MP2TS   = 28;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:27.865 -0500", hash_original_field = "31CE08B2382D81684110890B05B1ACA1", hash_generated_field = "2D202A276E4EFDF97274A4E4479A3636")

    public static final int FILE_TYPE_AVI     = 29;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:27.868 -0500", hash_original_field = "605D9924AC94A211F1CE1526C9604266", hash_generated_field = "D932C665929CC4FBA8AA555A5FAE898E")

    public static final int FILE_TYPE_WEBM    = 30;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:27.871 -0500", hash_original_field = "AAD59C08DD9927E283B20C484831120B", hash_generated_field = "210056D7627BF5525B902A555DFC9BD2")

    private static final int FIRST_VIDEO_FILE_TYPE = FILE_TYPE_MP4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:27.873 -0500", hash_original_field = "7F9AE32074A85F96D48E52EA83CE2B42", hash_generated_field = "391CF64D453710C67D8BB668C8457879")

    private static final int LAST_VIDEO_FILE_TYPE = FILE_TYPE_WEBM;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:27.876 -0500", hash_original_field = "0158A29A5D3E58DC0C1092E2FCA63043", hash_generated_field = "8F85F91EF9DB8FAD6AD68398D6B94909")

    public static final int FILE_TYPE_MP2PS   = 200;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:27.879 -0500", hash_original_field = "A40C99FF9179D570794CA76EDA143B91", hash_generated_field = "474C38C4FA7B475152C576B4B77F0AD7")

    private static final int FIRST_VIDEO_FILE_TYPE2 = FILE_TYPE_MP2PS;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:27.882 -0500", hash_original_field = "098D189F29217EE33C3FE1EA0477BE9E", hash_generated_field = "F63189C3B8BAF07F3ED80A76D9F63EA4")

    private static final int LAST_VIDEO_FILE_TYPE2 = FILE_TYPE_MP2PS;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:27.885 -0500", hash_original_field = "768BB35678D2B8ED1B14B33C6342E8E3", hash_generated_field = "35BFDEB5CBD248CD9BA62BD0050DEB41")

    public static final int FILE_TYPE_JPEG    = 31;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:27.888 -0500", hash_original_field = "85A00BC636BBD9A3BF0B8FB7C36F29B0", hash_generated_field = "7D7C965FFB7814C503BC32BC343E48F4")

    public static final int FILE_TYPE_GIF     = 32;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:27.891 -0500", hash_original_field = "B784FAD2E952F10811F28494D5AB5963", hash_generated_field = "0F4B3AED252F32771B9A2EE06B15EDE2")

    public static final int FILE_TYPE_PNG     = 33;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:27.893 -0500", hash_original_field = "7F4829542812FAC862DAB36D1625CC71", hash_generated_field = "FAD52C21D2C4388F5D9EC2511E501540")

    public static final int FILE_TYPE_BMP     = 34;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:27.896 -0500", hash_original_field = "8C9388289CD55CE684E9B700C9A86095", hash_generated_field = "686B0CED1FB06C19641F3A410D73B8E8")

    public static final int FILE_TYPE_WBMP    = 35;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:27.898 -0500", hash_original_field = "0799F36A36539E60E2D2CF6D9E892E77", hash_generated_field = "CDED5E43C07F3630E9C02A3D5943DF92")

    public static final int FILE_TYPE_WEBP    = 36;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:27.901 -0500", hash_original_field = "8F0476E42D00D58A308A63A5A549E293", hash_generated_field = "9C736BD86610B295780441B5F82C841A")

    private static final int FIRST_IMAGE_FILE_TYPE = FILE_TYPE_JPEG;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:27.903 -0500", hash_original_field = "838E08BB1570557F0BDF43649E59AA75", hash_generated_field = "8A91B464CD8693282C4D91E85D7E87C9")

    private static final int LAST_IMAGE_FILE_TYPE = FILE_TYPE_WEBP;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:27.906 -0500", hash_original_field = "E2BD6F1106F9687030EA0EC035AF0AB7", hash_generated_field = "028B08F166BAE3CCBDBB741B5BBADDCE")

    public static final int FILE_TYPE_M3U      = 41;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:27.909 -0500", hash_original_field = "2B2EA46E700DBA9B94CA90E861BB9D7B", hash_generated_field = "5CCDF3FECCC2C087CF1C048C209980F0")

    public static final int FILE_TYPE_PLS      = 42;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:27.912 -0500", hash_original_field = "38B71B716DB4DA769E749C7D4524D208", hash_generated_field = "3E0C3847535BB76D39A84F6AD24F8DA4")

    public static final int FILE_TYPE_WPL      = 43;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:27.914 -0500", hash_original_field = "98AFEB2C81BE6C57571CBABA6770B427", hash_generated_field = "595530343A1136EAC6288BC9C9A6F7D3")

    public static final int FILE_TYPE_HTTPLIVE = 44;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:27.917 -0500", hash_original_field = "6A96D655D91FDAB77863BE67698A9FEF", hash_generated_field = "47419CF879B57E44118BBD474F41CE76")

    private static final int FIRST_PLAYLIST_FILE_TYPE = FILE_TYPE_M3U;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:27.920 -0500", hash_original_field = "BC3B04D0C2209A958887178834E53160", hash_generated_field = "871E9297B34DEE916EC288416AE326B4")

    private static final int LAST_PLAYLIST_FILE_TYPE = FILE_TYPE_HTTPLIVE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:27.923 -0500", hash_original_field = "2F80EE4B11F0638C78EF974C41E10DC5", hash_generated_field = "632C4FAF13C0B5D8D9147F7A664DB7D1")

    public static final int FILE_TYPE_FL      = 51;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:27.925 -0500", hash_original_field = "CDD8907810CC6964B0B221E3BF71F38E", hash_generated_field = "19C1E5B6A21E0326E364927399D7DB0D")

    private static final int FIRST_DRM_FILE_TYPE = FILE_TYPE_FL;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:27.928 -0500", hash_original_field = "A2937CA872C2734FEBAF81DB7DB4E50E", hash_generated_field = "B7DD5F35D70773DC92E5EB001A91953A")

    private static final int LAST_DRM_FILE_TYPE = FILE_TYPE_FL;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:27.931 -0500", hash_original_field = "8A28CEE0CACF0EEA647BF3B44A32C8B6", hash_generated_field = "B8920A29A80BEBD50797956DF850FCD4")

    public static final int FILE_TYPE_TEXT          = 100;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:27.933 -0500", hash_original_field = "5A9DE68A4474F3ADAF1E0AE1BD375AA9", hash_generated_field = "965E54ADA9B34B15F07B94FE033F99C9")

    public static final int FILE_TYPE_HTML          = 101;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:27.936 -0500", hash_original_field = "6ED047220804924D9B887D58205C1DC6", hash_generated_field = "6FEC78BEB937F178B6ACEEE80EC0C493")

    public static final int FILE_TYPE_PDF           = 102;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:27.939 -0500", hash_original_field = "05A9C9CD0014537238D1AA7E694C95F5", hash_generated_field = "BB15F8D76D52FA98F08660F693500A43")

    public static final int FILE_TYPE_XML           = 103;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:27.941 -0500", hash_original_field = "FB337DD8BA6C99347F09237153B96C55", hash_generated_field = "F2E3D950AE0B975B32A3B3028D1A47CE")

    public static final int FILE_TYPE_MS_WORD       = 104;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:27.943 -0500", hash_original_field = "A1C80A1EA522004EDB36DF34A98FA445", hash_generated_field = "4B16A1F5388806DAEEFA2674044FC650")

    public static final int FILE_TYPE_MS_EXCEL      = 105;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:27.946 -0500", hash_original_field = "821AF32CAD395B0A0B7C66FE58685879", hash_generated_field = "3AC0DA031FC78E660C4C5BB8A1B148F0")

    public static final int FILE_TYPE_MS_POWERPOINT = 106;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:27.948 -0500", hash_original_field = "2DDD806F88AA164B2CE9B74FB9CC1034", hash_generated_field = "D6DDF834CCFF0720CB6A30615317ED15")

    public static final int FILE_TYPE_ZIP           = 107;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:27.962 -0500", hash_original_field = "C314F2FD40406CBF19966826F6B6DFB7", hash_generated_field = "D720C3C8609AEDFC558C093EA691AB44")
    
    private static HashMap<String, MediaFileType> sFileTypeMap
            = new HashMap<String, MediaFileType>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:27.965 -0500", hash_original_field = "5927C13AD6E50F454B458DEE4EAE2E88", hash_generated_field = "121D1896269E31449FCC6E06CB70794A")

    private static HashMap<String, Integer> sMimeTypeMap
            = new HashMap<String, Integer>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:27.968 -0500", hash_original_field = "E7145CFE015A8D65AF8895876651180E", hash_generated_field = "6BFD78FD2E4553732DF9FD5735E4E1E9")

    private static HashMap<String, Integer> sFileTypeToFormatMap
            = new HashMap<String, Integer>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:27.970 -0500", hash_original_field = "F5DD1D0AD43F9A2E363F443ABE30416C", hash_generated_field = "3850895C926E2D52750B57F6D22EC73B")

    private static HashMap<String, Integer> sMimeTypeToFormatMap
            = new HashMap<String, Integer>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:27.973 -0500", hash_original_field = "A8659AD7B73B98352B50C31EE8D36C76", hash_generated_field = "B87BE1DEB318200F6B54C32ABD4C5651")

    private static HashMap<Integer, String> sFormatToMimeTypeMap
            = new HashMap<Integer, String>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.479 -0400", hash_original_method = "F8094BC7E14C0E050681E430B28230AD", hash_generated_method = "F8094BC7E14C0E050681E430B28230AD")
    public MediaFile ()
    {
        //Synthesized constructor
    }
    static {
        addFileType("MP3", FILE_TYPE_MP3, "audio/mpeg", MtpConstants.FORMAT_MP3);
        addFileType("M4A", FILE_TYPE_M4A, "audio/mp4", MtpConstants.FORMAT_MPEG);
        addFileType("WAV", FILE_TYPE_WAV, "audio/x-wav", MtpConstants.FORMAT_WAV);
        addFileType("AMR", FILE_TYPE_AMR, "audio/amr");
        addFileType("AWB", FILE_TYPE_AWB, "audio/amr-wb");
        if (isWMAEnabled()) {
            addFileType("WMA", FILE_TYPE_WMA, "audio/x-ms-wma", MtpConstants.FORMAT_WMA);
        }
        addFileType("OGG", FILE_TYPE_OGG, "application/ogg", MtpConstants.FORMAT_OGG);
        addFileType("OGA", FILE_TYPE_OGG, "application/ogg", MtpConstants.FORMAT_OGG);
        addFileType("AAC", FILE_TYPE_AAC, "audio/aac", MtpConstants.FORMAT_AAC);
        addFileType("AAC", FILE_TYPE_AAC, "audio/aac-adts", MtpConstants.FORMAT_AAC);
        addFileType("MKA", FILE_TYPE_MKA, "audio/x-matroska");
        addFileType("MID", FILE_TYPE_MID, "audio/midi");
        addFileType("MIDI", FILE_TYPE_MID, "audio/midi");
        addFileType("XMF", FILE_TYPE_MID, "audio/midi");
        addFileType("RTTTL", FILE_TYPE_MID, "audio/midi");
        addFileType("SMF", FILE_TYPE_SMF, "audio/sp-midi");
        addFileType("IMY", FILE_TYPE_IMY, "audio/imelody");
        addFileType("RTX", FILE_TYPE_MID, "audio/midi");
        addFileType("OTA", FILE_TYPE_MID, "audio/midi");
        addFileType("MXMF", FILE_TYPE_MID, "audio/midi");
        addFileType("MPEG", FILE_TYPE_MP4, "video/mpeg", MtpConstants.FORMAT_MPEG);
        addFileType("MPG", FILE_TYPE_MP4, "video/mpeg", MtpConstants.FORMAT_MPEG);
        addFileType("MP4", FILE_TYPE_MP4, "video/mp4", MtpConstants.FORMAT_MPEG);
        addFileType("M4V", FILE_TYPE_M4V, "video/mp4", MtpConstants.FORMAT_MPEG);
        addFileType("3GP", FILE_TYPE_3GPP, "video/3gpp",  MtpConstants.FORMAT_3GP_CONTAINER);
        addFileType("3GPP", FILE_TYPE_3GPP, "video/3gpp", MtpConstants.FORMAT_3GP_CONTAINER);
        addFileType("3G2", FILE_TYPE_3GPP2, "video/3gpp2", MtpConstants.FORMAT_3GP_CONTAINER);
        addFileType("3GPP2", FILE_TYPE_3GPP2, "video/3gpp2", MtpConstants.FORMAT_3GP_CONTAINER);
        addFileType("MKV", FILE_TYPE_MKV, "video/x-matroska");
        addFileType("WEBM", FILE_TYPE_WEBM, "video/webm");
        addFileType("TS", FILE_TYPE_MP2TS, "video/mp2ts");
        addFileType("AVI", FILE_TYPE_AVI, "video/avi");
        if (isWMVEnabled()) {
            addFileType("WMV", FILE_TYPE_WMV, "video/x-ms-wmv", MtpConstants.FORMAT_WMV);
            addFileType("ASF", FILE_TYPE_ASF, "video/x-ms-asf");
        }
        addFileType("JPG", FILE_TYPE_JPEG, "image/jpeg", MtpConstants.FORMAT_EXIF_JPEG);
        addFileType("JPEG", FILE_TYPE_JPEG, "image/jpeg", MtpConstants.FORMAT_EXIF_JPEG);
        addFileType("GIF", FILE_TYPE_GIF, "image/gif", MtpConstants.FORMAT_GIF);
        addFileType("PNG", FILE_TYPE_PNG, "image/png", MtpConstants.FORMAT_PNG);
        addFileType("BMP", FILE_TYPE_BMP, "image/x-ms-bmp", MtpConstants.FORMAT_BMP);
        addFileType("WBMP", FILE_TYPE_WBMP, "image/vnd.wap.wbmp");
        addFileType("WEBP", FILE_TYPE_WEBP, "image/webp");
        addFileType("M3U", FILE_TYPE_M3U, "audio/x-mpegurl", MtpConstants.FORMAT_M3U_PLAYLIST);
        addFileType("M3U", FILE_TYPE_M3U, "application/x-mpegurl", MtpConstants.FORMAT_M3U_PLAYLIST);
        addFileType("PLS", FILE_TYPE_PLS, "audio/x-scpls", MtpConstants.FORMAT_PLS_PLAYLIST);
        addFileType("WPL", FILE_TYPE_WPL, "application/vnd.ms-wpl", MtpConstants.FORMAT_WPL_PLAYLIST);
        addFileType("M3U8", FILE_TYPE_HTTPLIVE, "application/vnd.apple.mpegurl");
        addFileType("M3U8", FILE_TYPE_HTTPLIVE, "audio/mpegurl");
        addFileType("M3U8", FILE_TYPE_HTTPLIVE, "audio/x-mpegurl");
        addFileType("FL", FILE_TYPE_FL, "application/x-android-drm-fl");
        addFileType("TXT", FILE_TYPE_TEXT, "text/plain", MtpConstants.FORMAT_TEXT);
        addFileType("HTM", FILE_TYPE_HTML, "text/html", MtpConstants.FORMAT_HTML);
        addFileType("HTML", FILE_TYPE_HTML, "text/html", MtpConstants.FORMAT_HTML);
        addFileType("PDF", FILE_TYPE_PDF, "application/pdf");
        addFileType("DOC", FILE_TYPE_MS_WORD, "application/msword", MtpConstants.FORMAT_MS_WORD_DOCUMENT);
        addFileType("XLS", FILE_TYPE_MS_EXCEL, "application/vnd.ms-excel", MtpConstants.FORMAT_MS_EXCEL_SPREADSHEET);
        addFileType("PPT", FILE_TYPE_MS_POWERPOINT, "application/mspowerpoint", MtpConstants.FORMAT_MS_POWERPOINT_PRESENTATION);
        addFileType("FLAC", FILE_TYPE_FLAC, "audio/flac", MtpConstants.FORMAT_FLAC);
        addFileType("ZIP", FILE_TYPE_ZIP, "application/zip");
        addFileType("MPG", FILE_TYPE_MP2PS, "video/mp2p");
        addFileType("MPEG", FILE_TYPE_MP2PS, "video/mp2p");
    }
    
}

