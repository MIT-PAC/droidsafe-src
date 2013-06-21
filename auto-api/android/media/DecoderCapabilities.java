package android.media;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class DecoderCapabilities {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.068 -0400", hash_original_method = "599AF8A39C7326727CA1A71C57B2EC2D", hash_generated_method = "CD6D75BD19893A81BF93FAF6BD81BA03")
    @DSModeled(DSC.SAFE)
    private DecoderCapabilities() {
        // ---------- Original Method ----------
    }

    
        public static List<VideoDecoder> getVideoDecoders() {
        List<VideoDecoder> decoderList = new ArrayList<VideoDecoder>();
        int nDecoders = native_get_num_video_decoders();
        for (int i = 0; i < nDecoders; ++i) {
            decoderList.add(VideoDecoder.values()[native_get_video_decoder_type(i)]);
        }
        return decoderList;
    }

    
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

