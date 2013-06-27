package org.xml.sax;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class SAXParseException extends SAXException {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.041 -0400", hash_original_field = "24AB20BFB578F0A89FF4A9C081F21384", hash_generated_field = "60BF385FD0C88E4BC32EFD3E71F5528C")

    private String publicId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.041 -0400", hash_original_field = "089D1A278481B86E821237F8E98E6DE7", hash_generated_field = "D8573F28EF4599A1790219EF1708D9C9")

    private String systemId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.041 -0400", hash_original_field = "BB8A5A0BF5B38F7D371E940DAED92DA6", hash_generated_field = "09A4698FFE38FA7794A20A1F94A6867E")

    private int lineNumber;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.041 -0400", hash_original_field = "9D2C17DB0A32EEAAF3B613AC483AEB6C", hash_generated_field = "26A7E6694FD33EFB482AC4BA7726E9A4")

    private int columnNumber;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.042 -0400", hash_original_method = "91659A5F6A3DDFF6C0F2D77A2F2D10D9", hash_generated_method = "C567E291833C401D16606CED8D0E88F9")
    public  SAXParseException(String message, Locator locator) {
        super(message);
        {
            init(locator.getPublicId(), locator.getSystemId(),
         locator.getLineNumber(), locator.getColumnNumber());
        } //End block
        {
            init(null, null, -1, -1);
        } //End block
        addTaint(message.getTaint());
        addTaint(locator.getTaint());
        // ---------- Original Method ----------
        //if (locator != null) {
        //init(locator.getPublicId(), locator.getSystemId(),
         //locator.getLineNumber(), locator.getColumnNumber());
    //} else {
        //init(null, null, -1, -1);
    //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.043 -0400", hash_original_method = "7445111C75F88435899093DB45466FBB", hash_generated_method = "096950722377BE086DFFBE19E58449A1")
    public  SAXParseException(String message, Locator locator,
                  Exception e) {
        super(message, e);
        {
            init(locator.getPublicId(), locator.getSystemId(),
         locator.getLineNumber(), locator.getColumnNumber());
        } //End block
        {
            init(null, null, -1, -1);
        } //End block
        addTaint(message.getTaint());
        addTaint(locator.getTaint());
        addTaint(e.getTaint());
        // ---------- Original Method ----------
        //if (locator != null) {
        //init(locator.getPublicId(), locator.getSystemId(),
         //locator.getLineNumber(), locator.getColumnNumber());
    //} else {
        //init(null, null, -1, -1);
    //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.043 -0400", hash_original_method = "F6A205656E7433FA991BA49A47A0113E", hash_generated_method = "3D3301EB01BFC560F253748254E397D2")
    public  SAXParseException(String message, String publicId, String systemId,
                  int lineNumber, int columnNumber) {
        super(message);
        init(publicId, systemId, lineNumber, columnNumber);
        addTaint(message.getTaint());
        addTaint(publicId.getTaint());
        addTaint(systemId.getTaint());
        addTaint(lineNumber);
        addTaint(columnNumber);
        // ---------- Original Method ----------
        //init(publicId, systemId, lineNumber, columnNumber);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.043 -0400", hash_original_method = "7C92F995098676855E75CD731C6CE956", hash_generated_method = "F50BA0188D8052C2A68D2F4D17AE78D9")
    public  SAXParseException(String message, String publicId, String systemId,
                  int lineNumber, int columnNumber, Exception e) {
        super(message, e);
        init(publicId, systemId, lineNumber, columnNumber);
        addTaint(message.getTaint());
        addTaint(publicId.getTaint());
        addTaint(systemId.getTaint());
        addTaint(lineNumber);
        addTaint(columnNumber);
        addTaint(e.getTaint());
        // ---------- Original Method ----------
        //init(publicId, systemId, lineNumber, columnNumber);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.044 -0400", hash_original_method = "CF8913A55801AA3E419E95D1888FBD68", hash_generated_method = "791E854378503806A83FE508B80FB7F1")
    private void init(String publicId, String systemId,
               int lineNumber, int columnNumber) {
        this.publicId = publicId;
        this.systemId = systemId;
        this.lineNumber = lineNumber;
        this.columnNumber = columnNumber;
        // ---------- Original Method ----------
        //this.publicId = publicId;
        //this.systemId = systemId;
        //this.lineNumber = lineNumber;
        //this.columnNumber = columnNumber;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.055 -0400", hash_original_method = "651ECBF976325F0553967BB40DF656D7", hash_generated_method = "36D53D7D54C3289C9F0EE9F330569185")
    public String getPublicId() {
        String varB4EAC82CA7396A68D541C85D26508E83_185436257 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_185436257 = this.publicId;
        varB4EAC82CA7396A68D541C85D26508E83_185436257.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_185436257;
        // ---------- Original Method ----------
        //return this.publicId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.056 -0400", hash_original_method = "600C253C44A23EDB0A978A11FA5F90C2", hash_generated_method = "2B4C70D1CFE65DB98775747C0EC0115D")
    public String getSystemId() {
        String varB4EAC82CA7396A68D541C85D26508E83_2107339250 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2107339250 = this.systemId;
        varB4EAC82CA7396A68D541C85D26508E83_2107339250.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2107339250;
        // ---------- Original Method ----------
        //return this.systemId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.056 -0400", hash_original_method = "1D6EF9406E829BF96953F811A8A7C017", hash_generated_method = "C86675C7BF1923750E16F7E460DB0E34")
    public int getLineNumber() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_696599930 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_696599930;
        // ---------- Original Method ----------
        //return this.lineNumber;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.056 -0400", hash_original_method = "0DEBF9F56751828220A5A7801C031403", hash_generated_method = "3EAC4AA9F77A5C92F4539D1494E92976")
    public int getColumnNumber() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1869634267 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1869634267;
        // ---------- Original Method ----------
        //return this.columnNumber;
    }

    
}

