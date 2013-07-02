package org.xml.sax;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public class SAXParseException extends SAXException {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.806 -0400", hash_original_field = "24AB20BFB578F0A89FF4A9C081F21384", hash_generated_field = "60BF385FD0C88E4BC32EFD3E71F5528C")

    private String publicId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.806 -0400", hash_original_field = "089D1A278481B86E821237F8E98E6DE7", hash_generated_field = "D8573F28EF4599A1790219EF1708D9C9")

    private String systemId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.806 -0400", hash_original_field = "BB8A5A0BF5B38F7D371E940DAED92DA6", hash_generated_field = "09A4698FFE38FA7794A20A1F94A6867E")

    private int lineNumber;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.806 -0400", hash_original_field = "9D2C17DB0A32EEAAF3B613AC483AEB6C", hash_generated_field = "26A7E6694FD33EFB482AC4BA7726E9A4")

    private int columnNumber;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.807 -0400", hash_original_method = "91659A5F6A3DDFF6C0F2D77A2F2D10D9", hash_generated_method = "C567E291833C401D16606CED8D0E88F9")
    public  SAXParseException(String message, Locator locator) {
        super(message);
        {
            init(locator.getPublicId(), locator.getSystemId(),
         locator.getLineNumber(), locator.getColumnNumber());
        } 
        {
            init(null, null, -1, -1);
        } 
        addTaint(message.getTaint());
        addTaint(locator.getTaint());
        
        
        
         
    
        
    
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.808 -0400", hash_original_method = "7445111C75F88435899093DB45466FBB", hash_generated_method = "096950722377BE086DFFBE19E58449A1")
    public  SAXParseException(String message, Locator locator,
                  Exception e) {
        super(message, e);
        {
            init(locator.getPublicId(), locator.getSystemId(),
         locator.getLineNumber(), locator.getColumnNumber());
        } 
        {
            init(null, null, -1, -1);
        } 
        addTaint(message.getTaint());
        addTaint(locator.getTaint());
        addTaint(e.getTaint());
        
        
        
         
    
        
    
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.808 -0400", hash_original_method = "F6A205656E7433FA991BA49A47A0113E", hash_generated_method = "3D3301EB01BFC560F253748254E397D2")
    public  SAXParseException(String message, String publicId, String systemId,
                  int lineNumber, int columnNumber) {
        super(message);
        init(publicId, systemId, lineNumber, columnNumber);
        addTaint(message.getTaint());
        addTaint(publicId.getTaint());
        addTaint(systemId.getTaint());
        addTaint(lineNumber);
        addTaint(columnNumber);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.808 -0400", hash_original_method = "7C92F995098676855E75CD731C6CE956", hash_generated_method = "F50BA0188D8052C2A68D2F4D17AE78D9")
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
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.809 -0400", hash_original_method = "CF8913A55801AA3E419E95D1888FBD68", hash_generated_method = "791E854378503806A83FE508B80FB7F1")
    private void init(String publicId, String systemId,
               int lineNumber, int columnNumber) {
        this.publicId = publicId;
        this.systemId = systemId;
        this.lineNumber = lineNumber;
        this.columnNumber = columnNumber;
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.812 -0400", hash_original_method = "651ECBF976325F0553967BB40DF656D7", hash_generated_method = "153F134DBC1DA212B2F97BE081FB1CD1")
    public String getPublicId() {
        String varB4EAC82CA7396A68D541C85D26508E83_175685833 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_175685833 = this.publicId;
        varB4EAC82CA7396A68D541C85D26508E83_175685833.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_175685833;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.815 -0400", hash_original_method = "600C253C44A23EDB0A978A11FA5F90C2", hash_generated_method = "1AFC64A5F10CB228525292D55C35CE96")
    public String getSystemId() {
        String varB4EAC82CA7396A68D541C85D26508E83_1290196415 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1290196415 = this.systemId;
        varB4EAC82CA7396A68D541C85D26508E83_1290196415.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1290196415;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.816 -0400", hash_original_method = "1D6EF9406E829BF96953F811A8A7C017", hash_generated_method = "869AAA6F6C2C321F03F29C97971EDAC2")
    public int getLineNumber() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_27104787 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_27104787;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.817 -0400", hash_original_method = "0DEBF9F56751828220A5A7801C031403", hash_generated_method = "F2659383993096BC6A932560E27A5ED7")
    public int getColumnNumber() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_545963429 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_545963429;
        
        
    }

    
}

