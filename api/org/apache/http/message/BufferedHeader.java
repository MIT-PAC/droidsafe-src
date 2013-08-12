package org.apache.http.message;

// Droidsafe Imports
import droidsafe.annotations.*;
import org.apache.http.FormattedHeader;
import org.apache.http.HeaderElement;
import org.apache.http.ParseException;
import org.apache.http.util.CharArrayBuffer;






public class BufferedHeader implements FormattedHeader, Cloneable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.095 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private String name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.095 -0400", hash_original_field = "7F2DB423A49B305459147332FB01CF87", hash_generated_field = "2D6B54E04F26AA35A63824F1627650C8")

    private CharArrayBuffer buffer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.095 -0400", hash_original_field = "682F56B9CD0D5A5A03591E08BD284CF2", hash_generated_field = "55229766EB15D64D0053C4D4C7254583")

    private int valuePos;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.095 -0400", hash_original_method = "49FE93A821CCACEE6FBD2E0E30BEDB29", hash_generated_method = "6A350FCE5C7875C30EE170695FCC4D1D")
    public  BufferedHeader(final CharArrayBuffer buffer) throws ParseException {
        super();
        if(buffer == null)        
        {
            IllegalArgumentException var11B13FD12A76A3F0F811AB9F5E5EE296_1331404517 = new IllegalArgumentException
                ("Char array buffer may not be null");
            var11B13FD12A76A3F0F811AB9F5E5EE296_1331404517.addTaint(taint);
            throw var11B13FD12A76A3F0F811AB9F5E5EE296_1331404517;
        } //End block
        int colon = buffer.indexOf(':');
        if(colon == -1)        
        {
            ParseException var6CD3B9FDB67218CCBB140415D6E38E41_1805955619 = new ParseException
                ("Invalid header: " + buffer.toString());
            var6CD3B9FDB67218CCBB140415D6E38E41_1805955619.addTaint(taint);
            throw var6CD3B9FDB67218CCBB140415D6E38E41_1805955619;
        } //End block
        String s = buffer.substringTrimmed(0, colon);
        if(s.length() == 0)        
        {
            ParseException var6CD3B9FDB67218CCBB140415D6E38E41_1691975904 = new ParseException
                ("Invalid header: " + buffer.toString());
            var6CD3B9FDB67218CCBB140415D6E38E41_1691975904.addTaint(taint);
            throw var6CD3B9FDB67218CCBB140415D6E38E41_1691975904;
        } //End block
        this.buffer = buffer;
        this.name = s;
        this.valuePos = colon + 1;
        // ---------- Original Method ----------
        //if (buffer == null) {
            //throw new IllegalArgumentException
                //("Char array buffer may not be null");
        //}
        //int colon = buffer.indexOf(':');
        //if (colon == -1) {
            //throw new ParseException
                //("Invalid header: " + buffer.toString());
        //}
        //String s = buffer.substringTrimmed(0, colon);
        //if (s.length() == 0) {
            //throw new ParseException
                //("Invalid header: " + buffer.toString());
        //}
        //this.buffer = buffer;
        //this.name = s;
        //this.valuePos = colon + 1;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.096 -0400", hash_original_method = "6F5A80252F54E883F3837DA0C6833E69", hash_generated_method = "C396E46D0D0A50AB93D574F9414DF202")
    public String getName() {
String varDC708CD29829AA84C3F2D9B68CF84B0D_524032773 =         this.name;
        varDC708CD29829AA84C3F2D9B68CF84B0D_524032773.addTaint(taint);
        return varDC708CD29829AA84C3F2D9B68CF84B0D_524032773;
        // ---------- Original Method ----------
        //return this.name;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.096 -0400", hash_original_method = "832891E6742DCF403246DBD5D871CA11", hash_generated_method = "6BD286C01D654F5AEEAF73B454FA46A4")
    public String getValue() {
String varCDE153C7C83987B368C3E568152249DB_777592144 =         this.buffer.substringTrimmed(this.valuePos, this.buffer.length());
        varCDE153C7C83987B368C3E568152249DB_777592144.addTaint(taint);
        return varCDE153C7C83987B368C3E568152249DB_777592144;
        // ---------- Original Method ----------
        //return this.buffer.substringTrimmed(this.valuePos, this.buffer.length());
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.096 -0400", hash_original_method = "5721C7259C8939164D56A25B24055244", hash_generated_method = "1D70F8A323E411CE81792E0857E6F11C")
    public HeaderElement[] getElements() throws ParseException {
        ParserCursor cursor = new ParserCursor(0, this.buffer.length());
        cursor.updatePos(this.valuePos);
HeaderElement[] varA090F3687291CDA6DAF632EEA41ADCCE_970496266 =         BasicHeaderValueParser.DEFAULT
            .parseElements(this.buffer, cursor);
        varA090F3687291CDA6DAF632EEA41ADCCE_970496266.addTaint(taint);
        return varA090F3687291CDA6DAF632EEA41ADCCE_970496266;
        // ---------- Original Method ----------
        //ParserCursor cursor = new ParserCursor(0, this.buffer.length());
        //cursor.updatePos(this.valuePos);
        //return BasicHeaderValueParser.DEFAULT
            //.parseElements(this.buffer, cursor);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.097 -0400", hash_original_method = "E7695A6E14F12AF4805392BEA2D5CE64", hash_generated_method = "26B3C36E8D4F33BBD1D3F9F1DF07F7B6")
    public int getValuePos() {
        int var1747919CF5DB41B03F9FEE684F69A6A5_1607402909 = (this.valuePos);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1889473820 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1889473820;
        // ---------- Original Method ----------
        //return this.valuePos;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.097 -0400", hash_original_method = "E316E251CD3E3ED3EEAF4AEFCAA1831D", hash_generated_method = "B97A7BDCABC10EAA8641E6B074F83CBF")
    public CharArrayBuffer getBuffer() {
CharArrayBuffer var45A7A4931E21905A5463F27B77E1344A_2060802129 =         this.buffer;
        var45A7A4931E21905A5463F27B77E1344A_2060802129.addTaint(taint);
        return var45A7A4931E21905A5463F27B77E1344A_2060802129;
        // ---------- Original Method ----------
        //return this.buffer;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.097 -0400", hash_original_method = "45FB39B4E67563C5A568E25DDBF414D1", hash_generated_method = "A3BACDDDAF86C37D0FD3A31487328290")
    public String toString() {
String var7B8BB72F06E6A8EB72498BA3268BFE1C_1475666670 =         this.buffer.toString();
        var7B8BB72F06E6A8EB72498BA3268BFE1C_1475666670.addTaint(taint);
        return var7B8BB72F06E6A8EB72498BA3268BFE1C_1475666670;
        // ---------- Original Method ----------
        //return this.buffer.toString();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.097 -0400", hash_original_method = "66DEBDF0D0405CDDBB7BD5DED76064DF", hash_generated_method = "B71423223B7F48B4B03AD492B6D06C6D")
    public Object clone() throws CloneNotSupportedException {
Object var46F3A0D86742C1D6E099C2B166941A33_812798915 =         super.clone();
        var46F3A0D86742C1D6E099C2B166941A33_812798915.addTaint(taint);
        return var46F3A0D86742C1D6E099C2B166941A33_812798915;
        // ---------- Original Method ----------
        //return super.clone();
    }

    
}

