package org.apache.http.impl.cookie;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HeaderElement;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.message.BasicHeaderElement;
import org.apache.http.message.BasicHeaderValueParser;
import org.apache.http.message.ParserCursor;
import org.apache.http.util.CharArrayBuffer;

public class NetscapeDraftHeaderParser {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.200 -0400", hash_original_field = "9FC9846A1C8AD8C7349E760872F36E27", hash_generated_field = "0A4D0DC8AD150348B21035D26D544819")

    private BasicHeaderValueParser nvpParser;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.201 -0400", hash_original_method = "5814035B8E0ECDCEC909AB1CD6C37999", hash_generated_method = "B65FC9AF3C13C4BB2F50EE6BEA98497A")
    public  NetscapeDraftHeaderParser() {
        super();
        this.nvpParser = BasicHeaderValueParser.DEFAULT;
        // ---------- Original Method ----------
        //this.nvpParser = BasicHeaderValueParser.DEFAULT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.201 -0400", hash_original_method = "3C830AE22F7AA511AF75147C79DF353D", hash_generated_method = "157F3B8DD8B68B99B4F258CA3DA1FAD5")
    public HeaderElement parseHeader(
            final CharArrayBuffer buffer,
            final ParserCursor cursor) throws ParseException {
        HeaderElement varB4EAC82CA7396A68D541C85D26508E83_593097374 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Char array buffer may not be null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Parser cursor may not be null");
        } //End block
        NameValuePair nvp = this.nvpParser.parseNameValuePair(buffer, cursor, DELIMITERS);
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        {
            boolean var4BEAEB17B63C1388A85B9C098E9AD4AA_1505937891 = (!cursor.atEnd());
            {
                NameValuePair param = this.nvpParser.parseNameValuePair(buffer, cursor, DELIMITERS);
                params.add(param);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_593097374 = new BasicHeaderElement(
                nvp.getName(), 
                nvp.getValue(), params.toArray(new NameValuePair[params.size()]));
        addTaint(buffer.getTaint());
        addTaint(cursor.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_593097374.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_593097374;
        // ---------- Original Method ----------
        //if (buffer == null) {
            //throw new IllegalArgumentException("Char array buffer may not be null");
        //}
        //if (cursor == null) {
            //throw new IllegalArgumentException("Parser cursor may not be null");
        //}
        //NameValuePair nvp = this.nvpParser.parseNameValuePair(buffer, cursor, DELIMITERS);
        //List<NameValuePair> params = new ArrayList<NameValuePair>();
        //while (!cursor.atEnd()) {
            //NameValuePair param = this.nvpParser.parseNameValuePair(buffer, cursor, DELIMITERS);
            //params.add(param);
        //}
        //return new BasicHeaderElement(
                //nvp.getName(), 
                //nvp.getValue(), params.toArray(new NameValuePair[params.size()]));
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.201 -0400", hash_original_field = "0DB0B283CE0737EF62C13C5C4496970F", hash_generated_field = "94EFCB742F16A6A619D5679042344819")

    public final static NetscapeDraftHeaderParser DEFAULT = new NetscapeDraftHeaderParser();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.201 -0400", hash_original_field = "AE07DFBA7CBB1BC9B0E135FA0EAB7AA0", hash_generated_field = "D5F52B0DDD543B0DC0444DE5C5A210D6")

    private final static char[] DELIMITERS = new char[] { ';' };
}

