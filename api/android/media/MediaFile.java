package android.media;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.content.ContentValues;
import android.provider.MediaStore.Audio;
import android.provider.MediaStore.Images;
import android.provider.MediaStore.Video;
import android.media.DecoderCapabilities;
import android.media.DecoderCapabilities.VideoDecoder;
import android.media.DecoderCapabilities.AudioDecoder;
import android.mtp.MtpConstants;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class MediaFile {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.479 -0400", hash_original_method = "F8094BC7E14C0E050681E430B28230AD", hash_generated_method = "F8094BC7E14C0E050681E430B28230AD")
    public MediaFile ()
    {
        //Synthesized constructor
    }


    static void addFileType(String extension, int fileType, String mimeType) {
        sFileTypeMap.put(extension, new MediaFileType(fileType, mimeType));
        sMimeTypeMap.put(mimeType, Integer.valueOf(fileType));
    }

    
    static void addFileType(String extension, int fileType, String mimeType, int mtpFormatCode) {
        addFileType(extension, fileType, mimeType);
        sFileTypeToFormatMap.put(extension, Integer.valueOf(mtpFormatCode));
        sMimeTypeToFormatMap.put(mimeType, Integer.valueOf(mtpFormatCode));
        sFormatToMimeTypeMap.put(mtpFormatCode, mimeType);
    }

    
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

    
    @DSModeled(DSC.SAFE)
    public static boolean isAudioFileType(int fileType) {
        return ((fileType >= FIRST_AUDIO_FILE_TYPE &&
                fileType <= LAST_AUDIO_FILE_TYPE) ||
                (fileType >= FIRST_MIDI_FILE_TYPE &&
                fileType <= LAST_MIDI_FILE_TYPE));
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean isVideoFileType(int fileType) {
        return (fileType >= FIRST_VIDEO_FILE_TYPE &&
                fileType <= LAST_VIDEO_FILE_TYPE)
            || (fileType >= FIRST_VIDEO_FILE_TYPE2 &&
                fileType <= LAST_VIDEO_FILE_TYPE2);
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean isImageFileType(int fileType) {
        return (fileType >= FIRST_IMAGE_FILE_TYPE &&
                fileType <= LAST_IMAGE_FILE_TYPE);
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean isPlayListFileType(int fileType) {
        return (fileType >= FIRST_PLAYLIST_FILE_TYPE &&
                fileType <= LAST_PLAYLIST_FILE_TYPE);
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean isDrmFileType(int fileType) {
        return (fileType >= FIRST_DRM_FILE_TYPE &&
                fileType <= LAST_DRM_FILE_TYPE);
    }

    
    public static MediaFileType getFileType(String path) {
        int lastDot = path.lastIndexOf(".");
        if (lastDot < 0)
            return null;
        return sFileTypeMap.get(path.substring(lastDot + 1).toUpperCase());
    }

    
    public static boolean isMimeTypeMedia(String mimeType) {
        int fileType = getFileTypeForMimeType(mimeType);
        return isAudioFileType(fileType) || isVideoFileType(fileType)
                || isImageFileType(fileType) || isPlayListFileType(fileType);
    }

    
    public static String getFileTitle(String path) {
        int lastSlash = path.lastIndexOf('/');
        if (lastSlash >= 0) {
            lastSlash++;
            if (lastSlash < path.length()) {
                path = path.substring(lastSlash);
            }
        }
        int lastDot = path.lastIndexOf('.');
        if (lastDot > 0) {
            path = path.substring(0, lastDot);
        }
        return path;
    }

    
    public static int getFileTypeForMimeType(String mimeType) {
        Integer value = sMimeTypeMap.get(mimeType);
        return (value == null ? 0 : value.intValue());
    }

    
    public static String getMimeTypeForFile(String path) {
        MediaFileType mediaFileType = getFileType(path);
        return (mediaFileType == null ? null : mediaFileType.mimeType);
    }

    
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

    
    public static String getMimeTypeForFormatCode(int formatCode) {
        return sFormatToMimeTypeMap.get(formatCode);
    }

    
    public static class MediaFileType {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.497 -0400", hash_original_field = "32B4CE08167921F74401A56B34C2E022", hash_generated_field = "8B71EC67105E5F27E184B46882300AAD")

        public int fileType;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.497 -0400", hash_original_field = "6DAD333C676844FE3B2A53FB6BE02D3A", hash_generated_field = "7392B175222DBFE73444BEBB76802D17")

        public String mimeType;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.501 -0400", hash_original_method = "5DA6BED04674A9B9CD299FCBDC3FDFAE", hash_generated_method = "D07946761458CF842A754E37F4709A88")
          MediaFileType(int fileType, String mimeType) {
            this.fileType = fileType;
            this.mimeType = mimeType;
            // ---------- Original Method ----------
            //this.fileType = fileType;
            //this.mimeType = mimeType;
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.501 -0400", hash_original_field = "1CAC9C6B830B81159023E5AD1F816E0C", hash_generated_field = "0442E65E46FD86EDDDD9D9538674D39B")

    public static final int FILE_TYPE_MP3     = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.501 -0400", hash_original_field = "A10729BDD7886285A9D93145C47BF47A", hash_generated_field = "7D7076EFC4D195B2A48868CCCB0FD5C9")

    public static final int FILE_TYPE_M4A     = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.502 -0400", hash_original_field = "C197709A97F1205D74480002B1845D56", hash_generated_field = "291468B4AB468DE19D9F157B0D3C576B")

    public static final int FILE_TYPE_WAV     = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.502 -0400", hash_original_field = "AC5F85816FE6C2DF62E59B26FE1E6DA6", hash_generated_field = "C74E05E6D4DBEE1D61D79BF0E59AA71D")

    public static final int FILE_TYPE_AMR     = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.502 -0400", hash_original_field = "3AAD87E7C68FDEC7E32E59B82FBF24BC", hash_generated_field = "06F3488C5825D9D185E2D816DC8F2043")

    public static final int FILE_TYPE_AWB     = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.502 -0400", hash_original_field = "DF8B5E91D7D9214AC87A14F5D5797A5D", hash_generated_field = "12C6FFB9120905667F06E399F164BAAB")

    public static final int FILE_TYPE_WMA     = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.502 -0400", hash_original_field = "689DECB8E43C9BFBA33C2B7B991D4450", hash_generated_field = "C92A8F448677A0CEA782842C64F7DE03")

    public static final int FILE_TYPE_OGG     = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.502 -0400", hash_original_field = "A2FF49FA17E692A0DB8A7B9F3C06E100", hash_generated_field = "B2C7DF1BF8EE908ACE7416F2F6A40727")

    public static final int FILE_TYPE_AAC     = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.502 -0400", hash_original_field = "46E19C418ED2A9A3EA9EB9755D1CAD9A", hash_generated_field = "2040CD52637D8751654F13B330A08926")

    public static final int FILE_TYPE_MKA     = 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.502 -0400", hash_original_field = "31314AFA74DBA80BC4A04D4F975FDAB4", hash_generated_field = "26225DC01F53BEAA896EF9B43E79D7A1")

    public static final int FILE_TYPE_FLAC    = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.502 -0400", hash_original_field = "E2654D9163C20F156FFB7D92E168322E", hash_generated_field = "02A902E1D03EF8C697526DBE5DC7AFB8")

    private static final int FIRST_AUDIO_FILE_TYPE = FILE_TYPE_MP3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.502 -0400", hash_original_field = "960A17E665FBAD386F0C583F84899726", hash_generated_field = "C72F6CC0BE8097C7708722B945B0E52D")

    private static final int LAST_AUDIO_FILE_TYPE = FILE_TYPE_FLAC;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.502 -0400", hash_original_field = "BA6FE7CDB1111A001EEF75210BC02E82", hash_generated_field = "6A3BDA1789D25F100BA246937BE256D9")

    public static final int FILE_TYPE_MID     = 11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.503 -0400", hash_original_field = "6BED33530EE83DF78D66235E1DBC4984", hash_generated_field = "63C02284AD93D16052B6F9FD2C6ECE31")

    public static final int FILE_TYPE_SMF     = 12;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.503 -0400", hash_original_field = "E20DC946A1B6C0A056472A7582C22A49", hash_generated_field = "EEF318D7DC411B7A579C29DF5B36BECA")

    public static final int FILE_TYPE_IMY     = 13;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.503 -0400", hash_original_field = "C1056B3DABE3A2A3A9748E1EEFC30D5D", hash_generated_field = "1673E6DE6A43A074F8E9A5F60B434DD4")

    private static final int FIRST_MIDI_FILE_TYPE = FILE_TYPE_MID;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.503 -0400", hash_original_field = "D4BD15BCD1638AB016182DD1B91FC097", hash_generated_field = "52DBE39418E679A1B88B61905CA6269D")

    private static final int LAST_MIDI_FILE_TYPE = FILE_TYPE_IMY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.503 -0400", hash_original_field = "8592A5ECDAC201677C01A97C4D771526", hash_generated_field = "98C569793D1B25B5048191D454FD97BC")

    public static final int FILE_TYPE_MP4     = 21;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.503 -0400", hash_original_field = "3A1FAA3264B9A5CBD2C7EEC7A01A6AF8", hash_generated_field = "B9470B007040FAB89FEE8130C5690F61")

    public static final int FILE_TYPE_M4V     = 22;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.503 -0400", hash_original_field = "417F40AF27C64C4F0647A614E4B43C05", hash_generated_field = "DAE93A7610C370D0D5F787E1AE6A55F9")

    public static final int FILE_TYPE_3GPP    = 23;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.503 -0400", hash_original_field = "F7B8FC4943F2D61D45EACB2EF4CD11DE", hash_generated_field = "1E0076505A468D8B8B7D0774AFE02446")

    public static final int FILE_TYPE_3GPP2   = 24;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.503 -0400", hash_original_field = "E3EEE382717A794856D06BBFF3558FBF", hash_generated_field = "A9AE6B5448099A36D1B9C2741FF70EB7")

    public static final int FILE_TYPE_WMV     = 25;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.503 -0400", hash_original_field = "BC8A396EE516CBF2F5721BF4DFBC11AA", hash_generated_field = "47D07672AA7319468643F12B36928075")

    public static final int FILE_TYPE_ASF     = 26;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.503 -0400", hash_original_field = "9949508199A344A8D119496A77FDBB25", hash_generated_field = "2DAE301C8B949A5966842C777782A31B")

    public static final int FILE_TYPE_MKV     = 27;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.503 -0400", hash_original_field = "D14C53E1384AE22360599E18F7307290", hash_generated_field = "FCB5B6415378DA2CC8B505A21B76117A")

    public static final int FILE_TYPE_MP2TS   = 28;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.503 -0400", hash_original_field = "DDFCDD3C234F5F071711A7C9FD4562FD", hash_generated_field = "2D202A276E4EFDF97274A4E4479A3636")

    public static final int FILE_TYPE_AVI     = 29;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.503 -0400", hash_original_field = "50761FD5CD19BCF56EBF92E7EADFE26F", hash_generated_field = "D932C665929CC4FBA8AA555A5FAE898E")

    public static final int FILE_TYPE_WEBM    = 30;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.503 -0400", hash_original_field = "422EC92C19483899A2AB3E7DA2E418A8", hash_generated_field = "210056D7627BF5525B902A555DFC9BD2")

    private static final int FIRST_VIDEO_FILE_TYPE = FILE_TYPE_MP4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.504 -0400", hash_original_field = "3A50C92E359ADF9DF2D165241F7318F1", hash_generated_field = "391CF64D453710C67D8BB668C8457879")

    private static final int LAST_VIDEO_FILE_TYPE = FILE_TYPE_WEBM;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.504 -0400", hash_original_field = "ADF3DD4262C0FBDA69A03BFEB48A344B", hash_generated_field = "8F85F91EF9DB8FAD6AD68398D6B94909")

    public static final int FILE_TYPE_MP2PS   = 200;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.504 -0400", hash_original_field = "7231577D2AAE7CDDBBA504DA0D47B82E", hash_generated_field = "474C38C4FA7B475152C576B4B77F0AD7")

    private static final int FIRST_VIDEO_FILE_TYPE2 = FILE_TYPE_MP2PS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.504 -0400", hash_original_field = "2CF733B9A7B36CBB3F995E58F0106295", hash_generated_field = "F63189C3B8BAF07F3ED80A76D9F63EA4")

    private static final int LAST_VIDEO_FILE_TYPE2 = FILE_TYPE_MP2PS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.504 -0400", hash_original_field = "3D2DACA680A7F7B888A574B266F1DDB8", hash_generated_field = "35BFDEB5CBD248CD9BA62BD0050DEB41")

    public static final int FILE_TYPE_JPEG    = 31;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.504 -0400", hash_original_field = "D1F2B462E3BCAE8C38483A10B8FDB535", hash_generated_field = "7D7C965FFB7814C503BC32BC343E48F4")

    public static final int FILE_TYPE_GIF     = 32;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.504 -0400", hash_original_field = "F61A2F14F0826914617A7DE26E5FA35B", hash_generated_field = "0F4B3AED252F32771B9A2EE06B15EDE2")

    public static final int FILE_TYPE_PNG     = 33;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.504 -0400", hash_original_field = "B374D6C3370068249D82DCFAD4036B70", hash_generated_field = "FAD52C21D2C4388F5D9EC2511E501540")

    public static final int FILE_TYPE_BMP     = 34;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.504 -0400", hash_original_field = "17753B08ECEE255BFCFBDADE186ECC20", hash_generated_field = "686B0CED1FB06C19641F3A410D73B8E8")

    public static final int FILE_TYPE_WBMP    = 35;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.504 -0400", hash_original_field = "A8D46628A1CF5D3CF22E1E3170E3FEAC", hash_generated_field = "CDED5E43C07F3630E9C02A3D5943DF92")

    public static final int FILE_TYPE_WEBP    = 36;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.505 -0400", hash_original_field = "4A8E46DBF143CAC8CBC6DC30004DBC4E", hash_generated_field = "9C736BD86610B295780441B5F82C841A")

    private static final int FIRST_IMAGE_FILE_TYPE = FILE_TYPE_JPEG;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.505 -0400", hash_original_field = "1DFCD107437B3A3E1F393DF480C76B9D", hash_generated_field = "8A91B464CD8693282C4D91E85D7E87C9")

    private static final int LAST_IMAGE_FILE_TYPE = FILE_TYPE_WEBP;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.505 -0400", hash_original_field = "BEFB8F064F0241454BEAC531F39F119F", hash_generated_field = "028B08F166BAE3CCBDBB741B5BBADDCE")

    public static final int FILE_TYPE_M3U      = 41;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.505 -0400", hash_original_field = "8D28B93AB6CE4523DEAAEAF36E3580DD", hash_generated_field = "5CCDF3FECCC2C087CF1C048C209980F0")

    public static final int FILE_TYPE_PLS      = 42;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.505 -0400", hash_original_field = "96F92BAFA9494A3C7945968A2B8FC9F3", hash_generated_field = "3E0C3847535BB76D39A84F6AD24F8DA4")

    public static final int FILE_TYPE_WPL      = 43;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.505 -0400", hash_original_field = "AC789FBC6EAA271CA2308DA575070F9E", hash_generated_field = "595530343A1136EAC6288BC9C9A6F7D3")

    public static final int FILE_TYPE_HTTPLIVE = 44;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.505 -0400", hash_original_field = "A681EDAEE24E31ABFF01A3200E8DA2B9", hash_generated_field = "47419CF879B57E44118BBD474F41CE76")

    private static final int FIRST_PLAYLIST_FILE_TYPE = FILE_TYPE_M3U;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.506 -0400", hash_original_field = "886B8B00941A2B5176C1B606570D5CF4", hash_generated_field = "871E9297B34DEE916EC288416AE326B4")

    private static final int LAST_PLAYLIST_FILE_TYPE = FILE_TYPE_HTTPLIVE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.506 -0400", hash_original_field = "F14194300161DD6DD80D702C58E86ED1", hash_generated_field = "632C4FAF13C0B5D8D9147F7A664DB7D1")

    public static final int FILE_TYPE_FL      = 51;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.506 -0400", hash_original_field = "0CA708D031A876280646DD53953E927C", hash_generated_field = "19C1E5B6A21E0326E364927399D7DB0D")

    private static final int FIRST_DRM_FILE_TYPE = FILE_TYPE_FL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.506 -0400", hash_original_field = "3E3EC4DA9B3CC1A3FD3C258E6C3548FD", hash_generated_field = "B7DD5F35D70773DC92E5EB001A91953A")

    private static final int LAST_DRM_FILE_TYPE = FILE_TYPE_FL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.507 -0400", hash_original_field = "9293A295BEEA795F85047148A6127171", hash_generated_field = "B8920A29A80BEBD50797956DF850FCD4")

    public static final int FILE_TYPE_TEXT          = 100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.507 -0400", hash_original_field = "9884C2EC7997C548B593FE29972C7B7E", hash_generated_field = "965E54ADA9B34B15F07B94FE033F99C9")

    public static final int FILE_TYPE_HTML          = 101;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.507 -0400", hash_original_field = "24EB78DB8AAC188697601104571A58B5", hash_generated_field = "6FEC78BEB937F178B6ACEEE80EC0C493")

    public static final int FILE_TYPE_PDF           = 102;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.507 -0400", hash_original_field = "AA1A2DA43BE87E9A171494B28F028B05", hash_generated_field = "BB15F8D76D52FA98F08660F693500A43")

    public static final int FILE_TYPE_XML           = 103;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.507 -0400", hash_original_field = "12699B964E73B4CB9755931FB84DCB68", hash_generated_field = "F2E3D950AE0B975B32A3B3028D1A47CE")

    public static final int FILE_TYPE_MS_WORD       = 104;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.507 -0400", hash_original_field = "918F0548CC81C8EB55089C01512033C6", hash_generated_field = "4B16A1F5388806DAEEFA2674044FC650")

    public static final int FILE_TYPE_MS_EXCEL      = 105;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.507 -0400", hash_original_field = "D58517F759562C7A1384023C7E8F4963", hash_generated_field = "3AC0DA031FC78E660C4C5BB8A1B148F0")

    public static final int FILE_TYPE_MS_POWERPOINT = 106;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.508 -0400", hash_original_field = "4AC5B7C007743E8D72189CEF782805DD", hash_generated_field = "D6DDF834CCFF0720CB6A30615317ED15")

    public static final int FILE_TYPE_ZIP           = 107;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.508 -0400", hash_original_field = "08647F7532EF12934DEBDA5D3C3EBFE2", hash_generated_field = "D720C3C8609AEDFC558C093EA691AB44")

    private static HashMap<String, MediaFileType> sFileTypeMap = new HashMap<String, MediaFileType>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.508 -0400", hash_original_field = "C45AEF20940B56DDFFDAE086AB416375", hash_generated_field = "121D1896269E31449FCC6E06CB70794A")

    private static HashMap<String, Integer> sMimeTypeMap = new HashMap<String, Integer>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.508 -0400", hash_original_field = "8FD729F975E982323D2EC44101273CEA", hash_generated_field = "6BFD78FD2E4553732DF9FD5735E4E1E9")

    private static HashMap<String, Integer> sFileTypeToFormatMap = new HashMap<String, Integer>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.508 -0400", hash_original_field = "15E6136C4145665E0CB4EEA550A160BF", hash_generated_field = "3850895C926E2D52750B57F6D22EC73B")

    private static HashMap<String, Integer> sMimeTypeToFormatMap = new HashMap<String, Integer>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.508 -0400", hash_original_field = "C8B461E78DEEEAC92FCC896E05D13272", hash_generated_field = "B87BE1DEB318200F6B54C32ABD4C5651")

    private static HashMap<Integer, String> sFormatToMimeTypeMap = new HashMap<Integer, String>();
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

