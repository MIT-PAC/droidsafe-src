package droidsafe.analyses.value;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

/**
 * Base class for value analysis object models.
 *
 * @author dpetters
 */
public abstract class VAModel {
    
    public static final String INVALIDATED = "\"INVALIDATED\"";

    /**
     * An object may be invalidated if we cannot soundly resolve it.
     */
    protected boolean invalidated = false;

    /**
     * Invalidate the model - we couldn't soundly resolve everything.
     */
    public void  invalidate(){
        this.invalidated = true;
    }

    /**
     * @returns whether this model was fully resolved
     */
    public boolean invalidated() {
        return this.invalidated;
    }

    /**
     * @returns a simple printout of the results
     */
    public abstract String toStringSimple();

    /**
     * @returns a detailed printout of the results
     */
    public abstract String toStringDetailed();


    /**
     * @returns a well-formatted (pretty!) detailed printout of the results
     */
    public String toStringPretty() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonParser jp = new JsonParser();
        try {
            JsonElement je = jp.parse(this.toStringDetailed());
            // return gson.toJson(je).replace("\"", ""); 
            return unescapeUnicode(gson.toJson(je).replace("\"", "")); 
        } catch (JsonSyntaxException e) {
            System.out.println("Malformed JSON: " + this.toStringDetailed());
            System.out.println(e.toString());
        }
        return null;
    }

    /**
     * @returns a detailed printout of the results
     */
    public String toString() {
        return this.toStringDetailed().replace("\"", "");
    }

    public String unescapeUnicode(String input) {
        StringBuffer buf = new StringBuffer();
        int index = 0;
        while (index < input.length()) {
            if (input.charAt(index) == '\\' && index + 1 < input.length() && input.charAt(index + 1) == 'u') {
                // consume optional additional 'u' chars
                int i = 2;
                while (index + i < input.length() && input.charAt(index + i) == 'u') {
                    i++;
                }

                if (index + i < input.length() && input.charAt(index + i) == '+') {
                    i++;
                }

                if (index + i + 4 <= input.length()) {
                    // Get 4 hex digits
                    CharSequence unicode = input.subSequence(index + i, index + i + 4);

                    try {
                        int value = Integer.parseInt(unicode.toString(), 16);
                        buf.append((char) value);
                    } catch (NumberFormatException nfe) {
                        throw new IllegalArgumentException("Unable to parse unicode value: " + unicode, nfe);
                    }
                    index += i + 4;
                } else {
                    throw new IllegalArgumentException("Less than 4 hex digits in unicode value: '" + input.subSequence(index, input.length())
                        + "' due to end of CharSequence");
                }
            } else {
                buf.append(input.charAt(index));
                index++;
            }
        }
        return buf.toString();
    }
}
