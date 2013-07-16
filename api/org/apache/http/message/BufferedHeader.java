package org.apache.http.message;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import org.apache.http.FormattedHeader;
import org.apache.http.HeaderElement;
import org.apache.http.ParseException;
import org.apache.http.util.CharArrayBuffer;

public class BufferedHeader implements FormattedHeader, Cloneable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.711 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private String name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.711 -0400", hash_original_field = "7F2DB423A49B305459147332FB01CF87", hash_generated_field = "2D6B54E04F26AA35A63824F1627650C8")

    private CharArrayBuffer buffer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.711 -0400", hash_original_field = "682F56B9CD0D5A5A03591E08BD284CF2", hash_generated_field = "55229766EB15D64D0053C4D4C7254583")

    private int valuePos;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.712 -0400", hash_original_method = "49FE93A821CCACEE6FBD2E0E30BEDB29", hash_generated_method = "23F362DA8E6E0BF5A87F5FDE6D8CA89E")
    public  BufferedHeader(final CharArrayBuffer buffer) throws ParseException {
        super();
    if(buffer == null)        
        {
            IllegalArgumentException var11B13FD12A76A3F0F811AB9F5E5EE296_1271235949 = new IllegalArgumentException
                ("Char array buffer may not be null");
            var11B13FD12A76A3F0F811AB9F5E5EE296_1271235949.addTaint(taint);
            throw var11B13FD12A76A3F0F811AB9F5E5EE296_1271235949;
        } //End block
        int colon = buffer.indexOf(':');
    if(colon == -1)        
        {
            ParseException var6CD3B9FDB67218CCBB140415D6E38E41_532588405 = new ParseException
                ("Invalid header: " + buffer.toString());
            var6CD3B9FDB67218CCBB140415D6E38E41_532588405.addTaint(taint);
            throw var6CD3B9FDB67218CCBB140415D6E38E41_532588405;
        } //End block
        String s = buffer.substringTrimmed(0, colon);
    if(s.length() == 0)        
        {
            ParseException var6CD3B9FDB67218CCBB140415D6E38E41_1089364791 = new ParseException
                ("Invalid header: " + buffer.toString());
            var6CD3B9FDB67218CCBB140415D6E38E41_1089364791.addTaint(taint);
            throw var6CD3B9FDB67218CCBB140415D6E38E41_1089364791;
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.713 -0400", hash_original_method = "6F5A80252F54E883F3837DA0C6833E69", hash_generated_method = "78037CBB8BE9FC80A2DE95A780452D01")
    public String getName() {
String varDC708CD29829AA84C3F2D9B68CF84B0D_1945637881 =         this.name;
        varDC708CD29829AA84C3F2D9B68CF84B0D_1945637881.addTaint(taint);
        return varDC708CD29829AA84C3F2D9B68CF84B0D_1945637881;
        // ---------- Original Method ----------
        //return this.name;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.713 -0400", hash_original_method = "832891E6742DCF403246DBD5D871CA11", hash_generated_method = "38AC7D76904F0DE1B753D96B59C6DB42")
    public String getValue() {
String varCDE153C7C83987B368C3E568152249DB_1233022702 =         this.buffer.substringTrimmed(this.valuePos, this.buffer.length());
        varCDE153C7C83987B368C3E568152249DB_1233022702.addTaint(taint);
        return varCDE153C7C83987B368C3E568152249DB_1233022702;
        // ---------- Original Method ----------
        //return this.buffer.substringTrimmed(this.valuePos, this.buffer.length());
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.714 -0400", hash_original_method = "5721C7259C8939164D56A25B24055244", hash_generated_method = "B952E3D79A60F86A2F5B7C64B1242287")
    public HeaderElement[] getElements() throws ParseException {
        ParserCursor cursor = new ParserCursor(0, this.buffer.length());
        cursor.updatePos(this.valuePos);
HeaderElement[] varA090F3687291CDA6DAF632EEA41ADCCE_614256499 =         BasicHeaderValueParser.DEFAULT
            .parseElements(this.buffer, cursor);
        varA090F3687291CDA6DAF632EEA41ADCCE_614256499.addTaint(taint);
        return varA090F3687291CDA6DAF632EEA41ADCCE_614256499;
        // ---------- Original Method ----------
        //ParserCursor cursor = new ParserCursor(0, this.buffer.length());
        //cursor.updatePos(this.valuePos);
        //return BasicHeaderValueParser.DEFAULT
            //.parseElements(this.buffer, cursor);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.714 -0400", hash_original_method = "E7695A6E14F12AF4805392BEA2D5CE64", hash_generated_method = "76D2A5E66295D2EF8CDA3D17579FDDE2")
    public int getValuePos() {
        int var1747919CF5DB41B03F9FEE684F69A6A5_798550243 = (this.valuePos);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2124787103 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2124787103;
        // ---------- Original Method ----------
        //return this.valuePos;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.714 -0400", hash_original_method = "E316E251CD3E3ED3EEAF4AEFCAA1831D", hash_generated_method = "6F96B3C30AF0A906BD7AAC50F06EF0DA")
    public CharArrayBuffer getBuffer() {
CharArrayBuffer var45A7A4931E21905A5463F27B77E1344A_542388146 =         this.buffer;
        var45A7A4931E21905A5463F27B77E1344A_542388146.addTaint(taint);
        return var45A7A4931E21905A5463F27B77E1344A_542388146;
        // ---------- Original Method ----------
        //return this.buffer;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.714 -0400", hash_original_method = "45FB39B4E67563C5A568E25DDBF414D1", hash_generated_method = "4757387818C4EF3729F909F9B7520DB0")
    public String toString() {
String var7B8BB72F06E6A8EB72498BA3268BFE1C_146655686 =         this.buffer.toString();
        var7B8BB72F06E6A8EB72498BA3268BFE1C_146655686.addTaint(taint);
        return var7B8BB72F06E6A8EB72498BA3268BFE1C_146655686;
        // ---------- Original Method ----------
        //return this.buffer.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.715 -0400", hash_original_method = "66DEBDF0D0405CDDBB7BD5DED76064DF", hash_generated_method = "913942748F0CE748FA51BC945A3BB067")
    public Object clone() throws CloneNotSupportedException {
Object var46F3A0D86742C1D6E099C2B166941A33_992817331 =         super.clone();
        var46F3A0D86742C1D6E099C2B166941A33_992817331.addTaint(taint);
        return var46F3A0D86742C1D6E099C2B166941A33_992817331;
        // ---------- Original Method ----------
        //return super.clone();
    }

    
}

