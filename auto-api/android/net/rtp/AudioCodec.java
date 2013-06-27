package android.net.rtp;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.Arrays;

public class AudioCodec {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.014 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "6AC5CE4BE311ED1283E9BD812937901E")

    public int type;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.014 -0400", hash_original_field = "2249DB5136BDE251B622792BBA796ECE", hash_generated_field = "EFE641ECA835D29854D8EF22918C1848")

    public String rtpmap;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.015 -0400", hash_original_field = "1C205A0162F31DC389303A94CA5C9AD5", hash_generated_field = "514B19E90214DE74BBA4CCC8C3EAAA2D")

    public String fmtp;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.033 -0400", hash_original_method = "9592639532530D98F97A4B6F44806F64", hash_generated_method = "BE4A1A43B4CCD88E252F67215DEEEE0E")
    private  AudioCodec(int type, String rtpmap, String fmtp) {
        this.type = type;
        this.rtpmap = rtpmap;
        this.fmtp = fmtp;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.063 -0400", hash_original_field = "317A74C4851F9CAB28A31C2F3BFA61B9", hash_generated_field = "72C5DB3322A5D181C06BCD1F412B8D8B")

    public static final AudioCodec PCMU = new AudioCodec(0, "PCMU/8000", null);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.063 -0400", hash_original_field = "F38E9896030EE676875A2AFE8AE05139", hash_generated_field = "9573916B7511FAC95B24045A3D38633D")

    public static final AudioCodec PCMA = new AudioCodec(8, "PCMA/8000", null);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.063 -0400", hash_original_field = "E8F4667669F0D863B8B80186E4D44E42", hash_generated_field = "F99C3CCFF7F596754E3D077EB53342B8")

    public static final AudioCodec GSM = new AudioCodec(3, "GSM/8000", null);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.063 -0400", hash_original_field = "0B43D8777F5CF9A5026F2A1AFA9A6B7F", hash_generated_field = "3D824786AF889508B95F1D8BCB909DAC")

    public static final AudioCodec GSM_EFR = new AudioCodec(96, "GSM-EFR/8000", null);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.063 -0400", hash_original_field = "D480AF4DF4BCD764C039F981CA4EFB83", hash_generated_field = "2175889361BE7AC3354D744ED51EF382")

    public static final AudioCodec AMR = new AudioCodec(97, "AMR/8000", null);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:24.064 -0400", hash_original_field = "9DBEA27EDD542EB6548A0FD23AD07116", hash_generated_field = "EDD22609E1F92810725CDE6D0664731B")

    private static AudioCodec[] sCodecs = {GSM_EFR, AMR, GSM, PCMU, PCMA};
}

