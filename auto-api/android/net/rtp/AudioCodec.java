package android.net.rtp;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.util.Arrays;

public class AudioCodec {
    public final int type;
    public final String rtpmap;
    public final String fmtp;
    public static final AudioCodec PCMU = new AudioCodec(0, "PCMU/8000", null);
    public static final AudioCodec PCMA = new AudioCodec(8, "PCMA/8000", null);
    public static final AudioCodec GSM = new AudioCodec(3, "GSM/8000", null);
    public static final AudioCodec GSM_EFR = new AudioCodec(96, "GSM-EFR/8000", null);
    public static final AudioCodec AMR = new AudioCodec(97, "AMR/8000", null);
    private static final AudioCodec[] sCodecs = {GSM_EFR, AMR, GSM, PCMU, PCMA};
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.281 -0400", hash_original_method = "9592639532530D98F97A4B6F44806F64", hash_generated_method = "69FD2C6720C607ADBB46A50FDC728D91")
    @DSModeled(DSC.SAFE)
    private AudioCodec(int type, String rtpmap, String fmtp) {
        dsTaint.addTaint(rtpmap);
        dsTaint.addTaint(fmtp);
        dsTaint.addTaint(type);
        // ---------- Original Method ----------
        //this.type = type;
        //this.rtpmap = rtpmap;
        //this.fmtp = fmtp;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.281 -0400", hash_original_method = "A02F235322CEC49098638CFAA7891025", hash_generated_method = "D78F8061E8F13431B3661F566FE40755")
    public static AudioCodec[] getCodecs() {
        return Arrays.copyOf(sCodecs, sCodecs.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.281 -0400", hash_original_method = "4B34E1AD78FB7AEDA5C9AAEBE5789D37", hash_generated_method = "9CDF3EC00B2A7297DFC9321B0E5924EB")
    public static AudioCodec getCodec(int type, String rtpmap, String fmtp) {
        if (type < 0 || type > 127) {
            return null;
        }
        AudioCodec hint = null;
        if (rtpmap != null) {
            String clue = rtpmap.trim().toUpperCase();
            for (AudioCodec codec : sCodecs) {
                if (clue.startsWith(codec.rtpmap)) {
                    String channels = clue.substring(codec.rtpmap.length());
                    if (channels.length() == 0 || channels.equals("/1")) {
                        hint = codec;
                    }
                    break;
                }
            }
        } else if (type < 96) {
            for (AudioCodec codec : sCodecs) {
                if (type == codec.type) {
                    hint = codec;
                    rtpmap = codec.rtpmap;
                    break;
                }
            }
        }
        if (hint == null) {
            return null;
        }
        if (hint == AMR && fmtp != null) {
            String clue = fmtp.toLowerCase();
            if (clue.contains("crc=1") || clue.contains("robust-sorting=1") ||
                    clue.contains("interleaving=")) {
                return null;
            }
        }
        return new AudioCodec(type, rtpmap, fmtp);
    }

    
}


