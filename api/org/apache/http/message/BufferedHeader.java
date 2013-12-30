package org.apache.http.message;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import org.apache.http.FormattedHeader;
import org.apache.http.HeaderElement;
import org.apache.http.ParseException;
import org.apache.http.util.CharArrayBuffer;






public class BufferedHeader implements FormattedHeader, Cloneable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:48.660 -0500", hash_original_field = "BF45F7481B8091DE3CBF80E94F7F940B", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private  String name;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:48.663 -0500", hash_original_field = "350F4DBD74AB8DD54F1F983317E69056", hash_generated_field = "2D6B54E04F26AA35A63824F1627650C8")

    private  CharArrayBuffer buffer;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:48.665 -0500", hash_original_field = "35C020B0B5335A1F298DED9AA26A8549", hash_generated_field = "55229766EB15D64D0053C4D4C7254583")

    private  int valuePos;


    /**
     * Creates a new header from a buffer.
     * The name of the header will be parsed immediately,
     * the value only if it is accessed.
     *
     * @param buffer    the buffer containing the header to represent
     *
     * @throws ParseException   in case of a parse error
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:48.669 -0500", hash_original_method = "49FE93A821CCACEE6FBD2E0E30BEDB29", hash_generated_method = "070F2E5A32E76C90B92C01E8D3F9080E")
    
public BufferedHeader(final CharArrayBuffer buffer)
        throws ParseException {

        super();
        if (buffer == null) {
            throw new IllegalArgumentException
                ("Char array buffer may not be null");
        }
        int colon = buffer.indexOf(':');
        if (colon == -1) {
            throw new ParseException
                ("Invalid header: " + buffer.toString());
        }
        String s = buffer.substringTrimmed(0, colon);
        if (s.length() == 0) {
            throw new ParseException
                ("Invalid header: " + buffer.toString());
        }
        this.buffer = buffer;
        this.name = s;
        this.valuePos = colon + 1;
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:48.671 -0500", hash_original_method = "6F5A80252F54E883F3837DA0C6833E69", hash_generated_method = "10AFD575EA26BE807F18801FAC02C531")
    
public String getName() {
        return this.name;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:48.673 -0500", hash_original_method = "832891E6742DCF403246DBD5D871CA11", hash_generated_method = "3AE95B711B81DE1E8553892FEC0B797E")
    
public String getValue() {
        return this.buffer.substringTrimmed(this.valuePos, this.buffer.length());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:48.675 -0500", hash_original_method = "5721C7259C8939164D56A25B24055244", hash_generated_method = "311F114A5E3879BBFFD0B2658B1FDD59")
    
public HeaderElement[] getElements() throws ParseException {
        ParserCursor cursor = new ParserCursor(0, this.buffer.length());
        cursor.updatePos(this.valuePos);
        return BasicHeaderValueParser.DEFAULT
            .parseElements(this.buffer, cursor);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:48.677 -0500", hash_original_method = "E7695A6E14F12AF4805392BEA2D5CE64", hash_generated_method = "D852ADD5F30A81C22AA5F5985D655818")
    
public int getValuePos() {
        return this.valuePos;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:48.679 -0500", hash_original_method = "E316E251CD3E3ED3EEAF4AEFCAA1831D", hash_generated_method = "9ED308ADFA5DFDD662AC2CC89157B2E5")
    
public CharArrayBuffer getBuffer() {
        return this.buffer;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:48.682 -0500", hash_original_method = "45FB39B4E67563C5A568E25DDBF414D1", hash_generated_method = "78CB532AFE764110A4E51A23C38737C5")
    
public String toString() {
        return this.buffer.toString();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:48.685 -0500", hash_original_method = "66DEBDF0D0405CDDBB7BD5DED76064DF", hash_generated_method = "0BDC98250A04BDDF2ACC480AFE3C4193")
    
public Object clone() throws CloneNotSupportedException {
        // buffer is considered immutable
        // no need to make a copy of it
        return super.clone();
    }

    
}

