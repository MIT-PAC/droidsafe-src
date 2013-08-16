package org.apache.http.impl.cookie;

// Droidsafe Imports
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.919 -0400", hash_original_field = "9FC9846A1C8AD8C7349E760872F36E27", hash_generated_field = "0A4D0DC8AD150348B21035D26D544819")

    private BasicHeaderValueParser nvpParser;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.919 -0400", hash_original_method = "5814035B8E0ECDCEC909AB1CD6C37999", hash_generated_method = "B65FC9AF3C13C4BB2F50EE6BEA98497A")
    public  NetscapeDraftHeaderParser() {
        super();
        this.nvpParser = BasicHeaderValueParser.DEFAULT;
        // ---------- Original Method ----------
        //this.nvpParser = BasicHeaderValueParser.DEFAULT;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.920 -0400", hash_original_method = "3C830AE22F7AA511AF75147C79DF353D", hash_generated_method = "3024AD54CBDA0EE5195A404288D02665")
    public HeaderElement parseHeader(
            final CharArrayBuffer buffer,
            final ParserCursor cursor) throws ParseException {
        addTaint(cursor.getTaint());
        addTaint(buffer.getTaint());
        if(buffer == null)        
        {
            IllegalArgumentException var11B13FD12A76A3F0F811AB9F5E5EE296_1885868260 = new IllegalArgumentException("Char array buffer may not be null");
            var11B13FD12A76A3F0F811AB9F5E5EE296_1885868260.addTaint(taint);
            throw var11B13FD12A76A3F0F811AB9F5E5EE296_1885868260;
        } //End block
        if(cursor == null)        
        {
            IllegalArgumentException var1CF5CFA2B773BDACC8F8C4F50D3A40A5_1022012829 = new IllegalArgumentException("Parser cursor may not be null");
            var1CF5CFA2B773BDACC8F8C4F50D3A40A5_1022012829.addTaint(taint);
            throw var1CF5CFA2B773BDACC8F8C4F50D3A40A5_1022012829;
        } //End block
        NameValuePair nvp = this.nvpParser.parseNameValuePair(buffer, cursor, DELIMITERS);
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        while
(!cursor.atEnd())        
        {
            NameValuePair param = this.nvpParser.parseNameValuePair(buffer, cursor, DELIMITERS);
            params.add(param);
        } //End block
HeaderElement var058FF4A669E46BFA920AF48787C82687_718405585 =         new BasicHeaderElement(
                nvp.getName(), 
                nvp.getValue(), params.toArray(new NameValuePair[params.size()]));
        var058FF4A669E46BFA920AF48787C82687_718405585.addTaint(taint);
        return var058FF4A669E46BFA920AF48787C82687_718405585;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.921 -0400", hash_original_field = "0DB0B283CE0737EF62C13C5C4496970F", hash_generated_field = "94EFCB742F16A6A619D5679042344819")

    public final static NetscapeDraftHeaderParser DEFAULT = new NetscapeDraftHeaderParser();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.921 -0400", hash_original_field = "AE07DFBA7CBB1BC9B0E135FA0EAB7AA0", hash_generated_field = "D5F52B0DDD543B0DC0444DE5C5A210D6")

    private final static char[] DELIMITERS = new char[] { ';' };
}

