package android.media;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.ArrayList;
import java.util.List;

import droidsafe.helpers.DSUtils;

public class DecoderCapabilities {

    /**
     * Returns the list of video decoder types
     * @see android.media.DecoderCapabilities.VideoDecoder
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:26.788 -0500", hash_original_method = "334155FFC3E4A7CB7C7D0CBEA471B4F4", hash_generated_method = "BAEC771B0BCA77724CFD1995660C47BE")
    
public static List<VideoDecoder> getVideoDecoders() {
        List<VideoDecoder> decoderList = new ArrayList<VideoDecoder>();
        int nDecoders = native_get_num_video_decoders();
        for (int i = 0; i < nDecoders; ++i) {
            decoderList.add(VideoDecoder.values()[native_get_video_decoder_type(i)]);
        }
        return decoderList;
    }

    /**
     * Returns the list of audio decoder types
     * @see android.media.DecoderCapabilities.AudioDecoder
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:26.791 -0500", hash_original_method = "9C119221D85202C4EA1DCEF893071B70", hash_generated_method = "B70CA09FCB71C8BFDB0B87116BDF5A45")
    
public static List<AudioDecoder> getAudioDecoders() {
        List<AudioDecoder> decoderList = new ArrayList<AudioDecoder>();
        int nDecoders = native_get_num_audio_decoders();
        for (int i = 0; i < nDecoders; ++i) {
            decoderList.add(AudioDecoder.values()[native_get_audio_decoder_type(i)]);
        }
        return decoderList;
    }
    
    private static final void native_init() {
    }
    
    private static final int native_get_num_video_decoders() {
        return DSUtils.UNKNOWN_INT;
    }
    
    private static final int native_get_video_decoder_type(int index) {
        return DSUtils.UNKNOWN_INT;
    }
    
    private static final int native_get_num_audio_decoders() {
        return DSUtils.UNKNOWN_INT;
    }
    
    private static final int native_get_audio_decoder_type(int index) {
        return DSUtils.UNKNOWN_INT;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:26.793 -0500", hash_original_method = "599AF8A39C7326727CA1A71C57B2EC2D", hash_generated_method = "BFECFE7E67F6E5F2BF2546A8989CB0DE")
    
private DecoderCapabilities() {}
    
    public enum VideoDecoder {
        VIDEO_DECODER_WMV,
    }
    
    public enum AudioDecoder {
        AUDIO_DECODER_WMA,
    }
    
    static {
        System.loadLibrary("media_jni");
        native_init();
    }
    
}

