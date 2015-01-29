package dk.brics.string;

import dk.brics.automaton.Automaton;

/**
 * Convenience methods.
 */
public class Misc {

    private Misc() {
    }

    /**
     * Escapes special characters in a string.
     */
    public static String escape(String s) {
        if (s == null) {
            return null;
        }
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '"') {
                b.append("\\\"");
            } else if (c == '\\') {
                b.append("\\\\");
            } else if (c == '\n') {
                b.append("\\n");
            } else if (c == '\r') {
                b.append("\\r");
            } else if (c >= 32 && c <= 126) {
                b.append(c);
            } else {
                b.append("\\u").append(Integer.toHexString(0x10000 + c).substring(1));
            }
        }
        return b.toString();
    }
    
    /**
     * Formats a string so it can be printed out friendly. In particular, the empty
     * string "" will be replaced by "<tt>&lt;empty string&gt;</tt>" (without the quotes)
     * to make it more readable. If <tt>null</tt> is passed to the method, the string
     * "<tt>&lt;empty language&gt;</tt>" is returned, to mimic the
     * result of {@link Automaton#getShortestExample(boolean)} on an empty-languaged automaton.
     * @param example an example string from an automaton
     * @return a non-null string of length at least one, without "strange" characters
     */
    public static String formatExample(String example) {
    	if (example == null)
    		return "<empty language>";
    	else if (example.equals(""))
    		return "<empty string>";
    	return escape(example);
    }
}
