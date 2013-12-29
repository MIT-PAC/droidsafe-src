package org.apache.http.impl.cookie;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:20.811 -0500", hash_original_field = "FB20D70F09B1AA5B72BC385F58A11077", hash_generated_field = "94EFCB742F16A6A619D5679042344819")


    public final static NetscapeDraftHeaderParser DEFAULT = new NetscapeDraftHeaderParser();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:20.811 -0500", hash_original_field = "629B9DCEAACB9F96AFCA1CB0ED0BDE17", hash_generated_field = "D5F52B0DDD543B0DC0444DE5C5A210D6")

    
    private final static char[] DELIMITERS = new char[] { ';' };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:20.812 -0500", hash_original_field = "63BB4DDBEEFACB4F4E91079B4CA5F251", hash_generated_field = "0A4D0DC8AD150348B21035D26D544819")

    
    private  BasicHeaderValueParser nvpParser;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:20.813 -0500", hash_original_method = "5814035B8E0ECDCEC909AB1CD6C37999", hash_generated_method = "ED3A7624C7A9CE509FEDF5C7FD351C1C")
    public NetscapeDraftHeaderParser() {
        super();
        this.nvpParser = BasicHeaderValueParser.DEFAULT;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:20.815 -0500", hash_original_method = "3C830AE22F7AA511AF75147C79DF353D", hash_generated_method = "3F643C5A3DF71092C4C33B2EE0B01F4C")
    public HeaderElement parseHeader(
            final CharArrayBuffer buffer,
            final ParserCursor cursor) throws ParseException {
        if (buffer == null) {
            throw new IllegalArgumentException("Char array buffer may not be null");
        }
        if (cursor == null) {
            throw new IllegalArgumentException("Parser cursor may not be null");
        }
        NameValuePair nvp = this.nvpParser.parseNameValuePair(buffer, cursor, DELIMITERS);
        List<NameValuePair> params = new ArrayList<NameValuePair>(); 
        while (!cursor.atEnd()) {
            NameValuePair param = this.nvpParser.parseNameValuePair(buffer, cursor, DELIMITERS);
            params.add(param);
        }
        return new BasicHeaderElement(
                nvp.getName(), 
                nvp.getValue(), params.toArray(new NameValuePair[params.size()]));
    }
}

