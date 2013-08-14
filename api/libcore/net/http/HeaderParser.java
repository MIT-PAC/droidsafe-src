package libcore.net.http;

// Droidsafe Imports
import droidsafe.annotations.*;


final class HeaderParser {
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.993 -0400", hash_original_method = "C3E16CB5840D33E016F8223898DE7315", hash_generated_method = "C3E16CB5840D33E016F8223898DE7315")
    public HeaderParser ()
    {
        //Synthesized constructor
    }


    @DSModeled(DSC.SAFE)
    public static void parseCacheControl(String value, CacheControlHandler handler) {
        int pos = 0;
        while (pos < value.length()) {
            int tokenStart = pos;
            pos = skipUntil(value, pos, "=,");
            String directive = value.substring(tokenStart, pos).trim();
            if (pos == value.length() || value.charAt(pos) == ',') {
                pos++; 
                handler.handle(directive, null);
                continue;
            }
            pos++; 
            pos = skipWhitespace(value, pos);
            String parameter;
            if (pos < value.length() && value.charAt(pos) == '\"') {
                pos++; 
                int parameterStart = pos;
                pos = skipUntil(value, pos, "\"");
                parameter = value.substring(parameterStart, pos);
                pos++; 
            } else {
                int parameterStart = pos;
                pos = skipUntil(value, pos, ",");
                parameter = value.substring(parameterStart, pos).trim();
            }
            handler.handle(directive, parameter);
        }
    }

    
    @DSModeled(DSC.BAN)
    private static int skipUntil(String input, int pos, String characters) {
        for (; pos < input.length(); pos++) {
            if (characters.indexOf(input.charAt(pos)) != -1) {
                break;
            }
        }
        return pos;
    }

    
    @DSModeled(DSC.BAN)
    private static int skipWhitespace(String input, int pos) {
        for (; pos < input.length(); pos++) {
            char c = input.charAt(pos);
            if (c != ' ' && c != '\t') {
                break;
            }
        }
        return pos;
    }

    
    @DSModeled(DSC.SAFE)
    public static int parseSeconds(String value) {
        try {
            long seconds = Long.parseLong(value);
            if (seconds > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else if (seconds < 0) {
                return 0;
            } else {
                return (int) seconds;
            }
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    
    public interface CacheControlHandler {
        void handle(String directive, String parameter);
    }
    
}

