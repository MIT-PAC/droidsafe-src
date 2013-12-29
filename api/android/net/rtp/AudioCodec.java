package android.net.rtp;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Arrays;




public class AudioCodec {

    /**
     * Returns system supported audio codecs.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:35.694 -0500", hash_original_method = "A02F235322CEC49098638CFAA7891025", hash_generated_method = "D78F8061E8F13431B3661F566FE40755")
    public static AudioCodec[] getCodecs() {
        return Arrays.copyOf(sCodecs, sCodecs.length);
    }

    /**
     * Creates an AudioCodec according to the given configuration.
     *
     * @param type The payload type of the encoding defined in RTP/AVP.
     * @param rtpmap The encoding parameters specified in the corresponding SDP
     *     attribute, or null if it is not available.
     * @param fmtp The format parameters specified in the corresponding SDP
     *     attribute, or null if it is not available.
     * @return The configured AudioCodec or {@code null} if it is not supported.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:35.695 -0500", hash_original_method = "4B34E1AD78FB7AEDA5C9AAEBE5789D37", hash_generated_method = "9CDF3EC00B2A7297DFC9321B0E5924EB")
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:35.687 -0500", hash_original_field = "483C4612ED814445BE18293248BE8F02", hash_generated_field = "72C5DB3322A5D181C06BCD1F412B8D8B")

    public static final AudioCodec PCMU = new AudioCodec(0, "PCMU/8000", null);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:35.688 -0500", hash_original_field = "33E364CE0CEACEEEB8ED89D09267FD77", hash_generated_field = "9573916B7511FAC95B24045A3D38633D")

    public static final AudioCodec PCMA = new AudioCodec(8, "PCMA/8000", null);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:35.689 -0500", hash_original_field = "E7F63B2B16507394EFAA76DDDBAD007F", hash_generated_field = "F99C3CCFF7F596754E3D077EB53342B8")

    public static final AudioCodec GSM = new AudioCodec(3, "GSM/8000", null);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:35.690 -0500", hash_original_field = "B19E2F7729F8D098683BCC8F27595861", hash_generated_field = "3D824786AF889508B95F1D8BCB909DAC")

    public static final AudioCodec GSM_EFR = new AudioCodec(96, "GSM-EFR/8000", null);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:35.691 -0500", hash_original_field = "BCBF036F8ECFC0BDDBB8F775064124A4", hash_generated_field = "2175889361BE7AC3354D744ED51EF382")

    public static final AudioCodec AMR = new AudioCodec(97, "AMR/8000", null);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:35.692 -0500", hash_original_field = "2D1D7205125A0AC4541043E7654C0C55", hash_generated_field = "C91EA36E4EEB99A1A60AD3DFD8BCE544")


    private static final AudioCodec[] sCodecs = {GSM_EFR, AMR, GSM, PCMU, PCMA};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:35.685 -0500", hash_original_field = "961B4204667A4AE2FF8DD374E6728ADE", hash_generated_field = "6AC5CE4BE311ED1283E9BD812937901E")

    public  int type;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:35.686 -0500", hash_original_field = "5D22ED68ADB5785FC6765D0677500D0B", hash_generated_field = "EFE641ECA835D29854D8EF22918C1848")

    public  String rtpmap;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:35.686 -0500", hash_original_field = "37D0B8FF8614E8D3208E2565283BF5BC", hash_generated_field = "514B19E90214DE74BBA4CCC8C3EAAA2D")

    public  String fmtp;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:35.693 -0500", hash_original_method = "9592639532530D98F97A4B6F44806F64", hash_generated_method = "4A85C7BB46AC6C6020DF699A0BE8FACF")
    private AudioCodec(int type, String rtpmap, String fmtp) {
        this.type = type;
        this.rtpmap = rtpmap;
        this.fmtp = fmtp;
    }
}

