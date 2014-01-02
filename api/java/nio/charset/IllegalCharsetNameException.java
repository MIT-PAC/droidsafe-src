package java.nio.charset;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;





public class IllegalCharsetNameException extends IllegalArgumentException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:01.709 -0500", hash_original_field = "1E943896942E48097DCE197F7EF3347A", hash_generated_field = "410F92043C1AB694FD9D990E16248912")

    private static final long serialVersionUID = 1457525358470002989L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:01.711 -0500", hash_original_field = "5E24356DE8A42080D6D8EE74FC7DBA00", hash_generated_field = "294F0480F54B014FA8831418027DC6AA")

    private String charsetName;

    /**
     * Constructs a new {@code IllegalCharsetNameException} with the supplied
     * charset name.
     *
     * @param charsetName
     *            the encountered illegal charset name.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:01.714 -0500", hash_original_method = "363E701FA2AE5454AC2A0E287832EEC6", hash_generated_method = "BC521BB8EAFCC2337F4E300A0D10A5BF")
    
public IllegalCharsetNameException(String charsetName) {
        super((charsetName != null) ? charsetName : "null");
        this.charsetName = charsetName;
    }

    /**
     * Returns the encountered illegal charset name.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:01.716 -0500", hash_original_method = "62D3F36CA78A6EC4185A2D1A05C169E6", hash_generated_method = "C3E3B8FCC038ED1DFB7C6F3AF5424FEA")
    
public String getCharsetName() {
        return charsetName;
    }
}

