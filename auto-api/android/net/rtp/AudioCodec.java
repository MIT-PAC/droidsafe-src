package android.net.rtp;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.Arrays;

public class AudioCodec {
    public int type;
    public String rtpmap;
    public String fmtp;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.131 -0400", hash_original_method = "9592639532530D98F97A4B6F44806F64", hash_generated_method = "2FBC1C4C5ABE2EAE4BDF9A950BE3C8F1")
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

    
        public static AudioCodec[] getCodecs() {
        return Arrays.copyOf(sCodecs, sCodecs.length);
    }

    
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

    
    public static final AudioCodec PCMU = new AudioCodec(0, "PCMU/8000", null);
    public static final AudioCodec PCMA = new AudioCodec(8, "PCMA/8000", null);
    public static final AudioCodec GSM = new AudioCodec(3, "GSM/8000", null);
    public static final AudioCodec GSM_EFR = new AudioCodec(96, "GSM-EFR/8000", null);
    public static final AudioCodec AMR = new AudioCodec(97, "AMR/8000", null);
    private static final AudioCodec[] sCodecs = {GSM_EFR, AMR, GSM, PCMU, PCMA};
}

