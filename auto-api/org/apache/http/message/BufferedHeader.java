package org.apache.http.message;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.apache.http.FormattedHeader;
import org.apache.http.HeaderElement;
import org.apache.http.ParseException;
import org.apache.http.util.CharArrayBuffer;

public class BufferedHeader implements FormattedHeader, Cloneable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.267 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private String name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.267 -0400", hash_original_field = "7F2DB423A49B305459147332FB01CF87", hash_generated_field = "2D6B54E04F26AA35A63824F1627650C8")

    private CharArrayBuffer buffer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.267 -0400", hash_original_field = "682F56B9CD0D5A5A03591E08BD284CF2", hash_generated_field = "55229766EB15D64D0053C4D4C7254583")

    private int valuePos;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.269 -0400", hash_original_method = "49FE93A821CCACEE6FBD2E0E30BEDB29", hash_generated_method = "CC399B5E2E51E0BE157F9395E5A4A705")
    public  BufferedHeader(final CharArrayBuffer buffer) throws ParseException {
        super();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Char array buffer may not be null");
        } //End block
        int colon;
        colon = buffer.indexOf(':');
        {
            if (DroidSafeAndroidRuntime.control) throw new ParseException
                ("Invalid header: " + buffer.toString());
        } //End block
        String s;
        s = buffer.substringTrimmed(0, colon);
        {
            boolean var3DE4AAEFFBD13592EE82FF5C131582CF_126346645 = (s.length() == 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new ParseException
                ("Invalid header: " + buffer.toString());
            } //End block
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.271 -0400", hash_original_method = "6F5A80252F54E883F3837DA0C6833E69", hash_generated_method = "77B9945E8E57421D83015D76E89D3F32")
    public String getName() {
        String varB4EAC82CA7396A68D541C85D26508E83_337620353 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_337620353 = this.name;
        varB4EAC82CA7396A68D541C85D26508E83_337620353.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_337620353;
        // ---------- Original Method ----------
        //return this.name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.273 -0400", hash_original_method = "832891E6742DCF403246DBD5D871CA11", hash_generated_method = "E9521D00457ED30643C7AB49905C2A25")
    public String getValue() {
        String varB4EAC82CA7396A68D541C85D26508E83_2087398274 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2087398274 = this.buffer.substringTrimmed(this.valuePos, this.buffer.length());
        varB4EAC82CA7396A68D541C85D26508E83_2087398274.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2087398274;
        // ---------- Original Method ----------
        //return this.buffer.substringTrimmed(this.valuePos, this.buffer.length());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.276 -0400", hash_original_method = "5721C7259C8939164D56A25B24055244", hash_generated_method = "FB3F966C53C746D76D3D84AB9BB59B84")
    public HeaderElement[] getElements() throws ParseException {
        HeaderElement[] varB4EAC82CA7396A68D541C85D26508E83_132257615 = null; //Variable for return #1
        ParserCursor cursor;
        cursor = new ParserCursor(0, this.buffer.length());
        cursor.updatePos(this.valuePos);
        varB4EAC82CA7396A68D541C85D26508E83_132257615 = BasicHeaderValueParser.DEFAULT
            .parseElements(this.buffer, cursor);
        varB4EAC82CA7396A68D541C85D26508E83_132257615.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_132257615;
        // ---------- Original Method ----------
        //ParserCursor cursor = new ParserCursor(0, this.buffer.length());
        //cursor.updatePos(this.valuePos);
        //return BasicHeaderValueParser.DEFAULT
            //.parseElements(this.buffer, cursor);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.278 -0400", hash_original_method = "E7695A6E14F12AF4805392BEA2D5CE64", hash_generated_method = "14E1CCFB80AF60C2F3EFA0D8FC0564CE")
    public int getValuePos() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1661410098 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1661410098;
        // ---------- Original Method ----------
        //return this.valuePos;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.280 -0400", hash_original_method = "E316E251CD3E3ED3EEAF4AEFCAA1831D", hash_generated_method = "2AA560D518C4D55A99A9781C14E4E4FF")
    public CharArrayBuffer getBuffer() {
        CharArrayBuffer varB4EAC82CA7396A68D541C85D26508E83_623051561 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_623051561 = this.buffer;
        varB4EAC82CA7396A68D541C85D26508E83_623051561.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_623051561;
        // ---------- Original Method ----------
        //return this.buffer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.283 -0400", hash_original_method = "45FB39B4E67563C5A568E25DDBF414D1", hash_generated_method = "7BE3B844B2E1D76885798097D4F473F1")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_528062139 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_528062139 = this.buffer.toString();
        varB4EAC82CA7396A68D541C85D26508E83_528062139.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_528062139;
        // ---------- Original Method ----------
        //return this.buffer.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.285 -0400", hash_original_method = "66DEBDF0D0405CDDBB7BD5DED76064DF", hash_generated_method = "5D0DD9BE1C28CFE6280442AD1552B9BC")
    public Object clone() throws CloneNotSupportedException {
        Object varB4EAC82CA7396A68D541C85D26508E83_850039724 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_850039724 = super.clone();
        varB4EAC82CA7396A68D541C85D26508E83_850039724.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_850039724;
        // ---------- Original Method ----------
        //return super.clone();
    }

    
}

