package libcore.net.url;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.Locale;

public final class UrlUtils {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.963 -0400", hash_original_method = "F053AECC4082C3B5C824758EB45DBA0C", hash_generated_method = "C53F924364698517C893492550830BCA")
    private  UrlUtils() {
        // ---------- Original Method ----------
    }

    
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

    
    public static String authoritySafePath(String authority, String path) {
        if (authority != null && !authority.isEmpty() && !path.isEmpty() && !path.startsWith("/")) {
            return "/" + path;
        }
        return path;
    }

    
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

    
    public static boolean isValidSchemeChar(int index, char c) {
        if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
            return true;
        }
        if (index > 0 && ((c >= '0' && c <= '9') || c == '+' || c == '-' || c == '.')) {
            return true;
        }
        return false;
    }

    
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

