package org.apache.http.message;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import org.apache.http.FormattedHeader;
import org.apache.http.HeaderElement;
import org.apache.http.ParseException;
import org.apache.http.util.CharArrayBuffer;

public class BufferedHeader implements FormattedHeader, Cloneable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.320 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private String name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.320 -0400", hash_original_field = "7F2DB423A49B305459147332FB01CF87", hash_generated_field = "2D6B54E04F26AA35A63824F1627650C8")

    private CharArrayBuffer buffer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.320 -0400", hash_original_field = "682F56B9CD0D5A5A03591E08BD284CF2", hash_generated_field = "55229766EB15D64D0053C4D4C7254583")

    private int valuePos;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.320 -0400", hash_original_method = "49FE93A821CCACEE6FBD2E0E30BEDB29", hash_generated_method = "160D80F00231C0819E6FA19340817709")
    public  BufferedHeader(final CharArrayBuffer buffer) throws ParseException {
        super();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Char array buffer may not be null");
        } 
        int colon = buffer.indexOf(':');
        {
            if (DroidSafeAndroidRuntime.control) throw new ParseException
                ("Invalid header: " + buffer.toString());
        } 
        String s = buffer.substringTrimmed(0, colon);
        {
            boolean var3DE4AAEFFBD13592EE82FF5C131582CF_1649296799 = (s.length() == 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new ParseException
                ("Invalid header: " + buffer.toString());
            } 
        } 
        this.buffer = buffer;
        this.name = s;
        this.valuePos = colon + 1;
        
        
            
                
        
        
        
            
                
        
        
        
            
                
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.321 -0400", hash_original_method = "6F5A80252F54E883F3837DA0C6833E69", hash_generated_method = "BB18791FF1734488FDD92C45F5F28B1C")
    public String getName() {
        String varB4EAC82CA7396A68D541C85D26508E83_2041003464 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2041003464 = this.name;
        varB4EAC82CA7396A68D541C85D26508E83_2041003464.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2041003464;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.322 -0400", hash_original_method = "832891E6742DCF403246DBD5D871CA11", hash_generated_method = "8219B5E47A3417047B2233FE3867E7D5")
    public String getValue() {
        String varB4EAC82CA7396A68D541C85D26508E83_1065370678 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1065370678 = this.buffer.substringTrimmed(this.valuePos, this.buffer.length());
        varB4EAC82CA7396A68D541C85D26508E83_1065370678.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1065370678;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.322 -0400", hash_original_method = "5721C7259C8939164D56A25B24055244", hash_generated_method = "F3F94BB8B33C86F717255D004D95A0A7")
    public HeaderElement[] getElements() throws ParseException {
        HeaderElement[] varB4EAC82CA7396A68D541C85D26508E83_799546950 = null; 
        ParserCursor cursor = new ParserCursor(0, this.buffer.length());
        cursor.updatePos(this.valuePos);
        varB4EAC82CA7396A68D541C85D26508E83_799546950 = BasicHeaderValueParser.DEFAULT
            .parseElements(this.buffer, cursor);
        varB4EAC82CA7396A68D541C85D26508E83_799546950.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_799546950;
        
        
        
        
            
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.323 -0400", hash_original_method = "E7695A6E14F12AF4805392BEA2D5CE64", hash_generated_method = "6A38FABC3C350722696720B48C4CD66A")
    public int getValuePos() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1457410100 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1457410100;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.323 -0400", hash_original_method = "E316E251CD3E3ED3EEAF4AEFCAA1831D", hash_generated_method = "638037423C8EB873FE60291A798DE3AD")
    public CharArrayBuffer getBuffer() {
        CharArrayBuffer varB4EAC82CA7396A68D541C85D26508E83_658160525 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_658160525 = this.buffer;
        varB4EAC82CA7396A68D541C85D26508E83_658160525.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_658160525;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.324 -0400", hash_original_method = "45FB39B4E67563C5A568E25DDBF414D1", hash_generated_method = "901AFCD33AC6D10095A5A9D813B86B0E")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1570405245 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1570405245 = this.buffer.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1570405245.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1570405245;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.324 -0400", hash_original_method = "66DEBDF0D0405CDDBB7BD5DED76064DF", hash_generated_method = "69685A87EF1D2AE2BFF1160874634A6F")
    public Object clone() throws CloneNotSupportedException {
        Object varB4EAC82CA7396A68D541C85D26508E83_843132616 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_843132616 = super.clone();
        varB4EAC82CA7396A68D541C85D26508E83_843132616.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_843132616;
        
        
    }

    
}

