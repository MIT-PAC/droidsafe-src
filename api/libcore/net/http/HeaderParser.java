package libcore.net.http;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

final class HeaderParser {

    /**
     * Parse a comma-separated list of cache control header values.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:32.058 -0500", hash_original_method = "0B5EE95A6FBCD7BEA829DC7265109ADB", hash_generated_method = "2C307D577FAAB03BEFFFE54081B87FE6")
    
public static void parseCacheControl(String value, CacheControlHandler handler) {
        int pos = 0;
        while (pos < value.length()) {
            int tokenStart = pos;
            pos = skipUntil(value, pos, "=,");
            String directive = value.substring(tokenStart, pos).trim();

            if (pos == value.length() || value.charAt(pos) == ',') {
                pos++; // consume ',' (if necessary)
                handler.handle(directive, null);
                continue;
            }

            pos++; // consume '='
            pos = skipWhitespace(value, pos);

            String parameter;

            // quoted string
            if (pos < value.length() && value.charAt(pos) == '\"') {
                pos++; // consume '"' open quote
                int parameterStart = pos;
                pos = skipUntil(value, pos, "\"");
                parameter = value.substring(parameterStart, pos);
                pos++; // consume '"' close quote (if necessary)

            // unquoted string
            } else {
                int parameterStart = pos;
                pos = skipUntil(value, pos, ",");
                parameter = value.substring(parameterStart, pos).trim();
            }

            handler.handle(directive, parameter);
        }
    }

    /**
     * Returns the next index in {@code input} at or after {@code pos} that
     * contains a character from {@code characters}. Returns the input length if
     * none of the requested characters can be found.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:32.060 -0500", hash_original_method = "4923F6873F4BEA7DF3A0D9AD1B573176", hash_generated_method = "D292702122C2D9AC3B322821A4D89A57")
    
private static int skipUntil(String input, int pos, String characters) {
        for (; pos < input.length(); pos++) {
            if (characters.indexOf(input.charAt(pos)) != -1) {
                break;
            }
        }
        return pos;
    }

    /**
     * Returns the next non-whitespace character in {@code input} that is white
     * space. Result is undefined if input contains newline characters.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:32.063 -0500", hash_original_method = "8131A22344C2BE8348ABA2995C7F4BF7", hash_generated_method = "68B21CE46F90F77A9809846BC465D929")
    
private static int skipWhitespace(String input, int pos) {
        for (; pos < input.length(); pos++) {
            char c = input.charAt(pos);
            if (c != ' ' && c != '\t') {
                break;
            }
        }
        return pos;
    }

    /**
     * Returns {@code value} as a positive integer, or 0 if it is negative, or
     * -1 if it cannot be parsed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:32.066 -0500", hash_original_method = "5578EB458FBDF9BEA6568845C0193A95", hash_generated_method = "D26447F561E7308EC12220DD09A8C19B")
    
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.993 -0400", hash_original_method = "C3E16CB5840D33E016F8223898DE7315", hash_generated_method = "C3E16CB5840D33E016F8223898DE7315")
    public HeaderParser ()
    {
        //Synthesized constructor
    }
    
    public interface CacheControlHandler {
        void handle(String directive, String parameter);
    }
    
}

