package libcore.net.url;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.util.Locale;

public final class UrlUtils {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.536 -0400", hash_original_method = "F053AECC4082C3B5C824758EB45DBA0C", hash_generated_method = "3D28C073A1763BE15A8C63510D21130B")
    @DSModeled(DSC.SAFE)
    private UrlUtils() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.536 -0400", hash_original_method = "9846573335398B4F61F3531E4C57F2B5", hash_generated_method = "CA7E068DE2B4243C05F642146C27F518")
    public static String canonicalizePath(String path, boolean discardRelativePrefix) {
        int segmentStart = 0;
        int deletableSegments = 0;
        for (int i = 0; i <= path.length(); ) {
            int nextSegmentStart;
            if (i == path.length()) {
                nextSegmentStart = i;
            } else if (path.charAt(i) == '/') {
                nextSegmentStart = i + 1;
            } else {
                i++;
                continue;
            }
            if (i == segmentStart + 1 && path.regionMatches(segmentStart, ".", 0, 1)) {
                path = path.substring(0, segmentStart) + path.substring(nextSegmentStart);
                i = segmentStart;
            } else if (i == segmentStart + 2 && path.regionMatches(segmentStart, "..", 0, 2)) {
                if (deletableSegments > 0 || discardRelativePrefix) {
                    deletableSegments--;
                    int prevSegmentStart = path.lastIndexOf('/', segmentStart - 2) + 1;
                    path = path.substring(0, prevSegmentStart) + path.substring(nextSegmentStart);
                    i = segmentStart = prevSegmentStart;
                } else {
                    i++;
                    segmentStart = i;
                }
            } else {
                if (i > 0) {
                    deletableSegments++;
                }
                i++;
                segmentStart = i;
            }
        }
        return path;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.536 -0400", hash_original_method = "8B63B6606F2CF427FC7B99898B25B215", hash_generated_method = "EC1965268AD0D881798AD2CB98574BF6")
    public static String authoritySafePath(String authority, String path) {
        if (authority != null && !authority.isEmpty() && !path.isEmpty() && !path.startsWith("/")) {
            return "/" + path;
        }
        return path;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.536 -0400", hash_original_method = "E2E22956A4F207916457EDE07112F88D", hash_generated_method = "419F2EEDA0825E754A3521196C5AFD60")
    public static String getSchemePrefix(String spec) {
        int colon = spec.indexOf(':');
        if (colon < 1) {
            return null;
        }
        for (int i = 0; i < colon; i++) {
            char c = spec.charAt(i);
            if (!isValidSchemeChar(i, c)) {
                return null;
            }
        }
        return spec.substring(0, colon).toLowerCase(Locale.US);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.536 -0400", hash_original_method = "4943CCAF6D78FBC7B907B31B28241551", hash_generated_method = "79F2BE0BD08A9658B85E5E0865FFDF63")
    public static boolean isValidSchemeChar(int index, char c) {
        if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
            return true;
        }
        if (index > 0 && ((c >= '0' && c <= '9') || c == '+' || c == '-' || c == '.')) {
            return true;
        }
        return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.536 -0400", hash_original_method = "5B71B161212244EE7AB917C7C7C70B93", hash_generated_method = "437128F81BE6DA9B43CEC59DB6054742")
    public static int findFirstOf(String string, String chars, int start, int end) {
        for (int i = start; i < end; i++) {
            char c = string.charAt(i);
            if (chars.indexOf(c) != -1) {
                return i;
            }
        }
        return end;
    }

    
}


