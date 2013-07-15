package org.xml.sax;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class SAXParseException extends SAXException {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.132 -0400", hash_original_field = "24AB20BFB578F0A89FF4A9C081F21384", hash_generated_field = "60BF385FD0C88E4BC32EFD3E71F5528C")

    private String publicId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.132 -0400", hash_original_field = "089D1A278481B86E821237F8E98E6DE7", hash_generated_field = "D8573F28EF4599A1790219EF1708D9C9")

    private String systemId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.132 -0400", hash_original_field = "BB8A5A0BF5B38F7D371E940DAED92DA6", hash_generated_field = "09A4698FFE38FA7794A20A1F94A6867E")

    private int lineNumber;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.132 -0400", hash_original_field = "9D2C17DB0A32EEAAF3B613AC483AEB6C", hash_generated_field = "26A7E6694FD33EFB482AC4BA7726E9A4")

    private int columnNumber;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.132 -0400", hash_original_method = "91659A5F6A3DDFF6C0F2D77A2F2D10D9", hash_generated_method = "0CE4F9CA6EDEA1A6F020FD6E56E6D6FD")
    public  SAXParseException(String message, Locator locator) {
        super(message);
        addTaint(locator.getTaint());
        addTaint(message.getTaint());
    if(locator != null)        
        {
            init(locator.getPublicId(), locator.getSystemId(),
         locator.getLineNumber(), locator.getColumnNumber());
        } //End block
        else
        {
            init(null, null, -1, -1);
        } //End block
        // ---------- Original Method ----------
        //if (locator != null) {
        //init(locator.getPublicId(), locator.getSystemId(),
         //locator.getLineNumber(), locator.getColumnNumber());
    //} else {
        //init(null, null, -1, -1);
    //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.133 -0400", hash_original_method = "7445111C75F88435899093DB45466FBB", hash_generated_method = "6B580BAD176A8ED410139B61B858C796")
    public  SAXParseException(String message, Locator locator,
                  Exception e) {
        super(message, e);
        addTaint(e.getTaint());
        addTaint(locator.getTaint());
        addTaint(message.getTaint());
    if(locator != null)        
        {
            init(locator.getPublicId(), locator.getSystemId(),
         locator.getLineNumber(), locator.getColumnNumber());
        } //End block
        else
        {
            init(null, null, -1, -1);
        } //End block
        // ---------- Original Method ----------
        //if (locator != null) {
        //init(locator.getPublicId(), locator.getSystemId(),
         //locator.getLineNumber(), locator.getColumnNumber());
    //} else {
        //init(null, null, -1, -1);
    //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.133 -0400", hash_original_method = "F6A205656E7433FA991BA49A47A0113E", hash_generated_method = "60D43526F236A32957D2912A94DFC2AC")
    public  SAXParseException(String message, String publicId, String systemId,
                  int lineNumber, int columnNumber) {
        super(message);
        addTaint(columnNumber);
        addTaint(lineNumber);
        addTaint(systemId.getTaint());
        addTaint(publicId.getTaint());
        addTaint(message.getTaint());
        init(publicId, systemId, lineNumber, columnNumber);
        // ---------- Original Method ----------
        //init(publicId, systemId, lineNumber, columnNumber);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.134 -0400", hash_original_method = "7C92F995098676855E75CD731C6CE956", hash_generated_method = "598FD09DC85031B08116D1E6438D66BE")
    public  SAXParseException(String message, String publicId, String systemId,
                  int lineNumber, int columnNumber, Exception e) {
        super(message, e);
        addTaint(e.getTaint());
        addTaint(columnNumber);
        addTaint(lineNumber);
        addTaint(systemId.getTaint());
        addTaint(publicId.getTaint());
        addTaint(message.getTaint());
        init(publicId, systemId, lineNumber, columnNumber);
        // ---------- Original Method ----------
        //init(publicId, systemId, lineNumber, columnNumber);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.135 -0400", hash_original_method = "CF8913A55801AA3E419E95D1888FBD68", hash_generated_method = "791E854378503806A83FE508B80FB7F1")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.135 -0400", hash_original_method = "651ECBF976325F0553967BB40DF656D7", hash_generated_method = "7F58288925ED66D6F3936173B909E7CB")
    public String getPublicId() {
String var1AC6044011EA8BF87DD1848A6670336D_1576123531 =         this.publicId;
        var1AC6044011EA8BF87DD1848A6670336D_1576123531.addTaint(taint);
        return var1AC6044011EA8BF87DD1848A6670336D_1576123531;
        // ---------- Original Method ----------
        //return this.publicId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.135 -0400", hash_original_method = "600C253C44A23EDB0A978A11FA5F90C2", hash_generated_method = "4DD844A56F7574B54C16794D0EDC446F")
    public String getSystemId() {
String varAECD18EE9EA1CBFED723C63E29874344_569789300 =         this.systemId;
        varAECD18EE9EA1CBFED723C63E29874344_569789300.addTaint(taint);
        return varAECD18EE9EA1CBFED723C63E29874344_569789300;
        // ---------- Original Method ----------
        //return this.systemId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.136 -0400", hash_original_method = "1D6EF9406E829BF96953F811A8A7C017", hash_generated_method = "5523F3D2A432D3302A7EDD2C9A0B60EB")
    public int getLineNumber() {
        int varA15531C220A3C6DFF396A4178F65880E_1161960015 = (this.lineNumber);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_799770109 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_799770109;
        // ---------- Original Method ----------
        //return this.lineNumber;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:23.136 -0400", hash_original_method = "0DEBF9F56751828220A5A7801C031403", hash_generated_method = "B5DC2518C3CD24E4CF79887AF08B3FCD")
    public int getColumnNumber() {
        int var0227595DA9BA84A7A7B5E14C9F5EB3A9_24647709 = (this.columnNumber);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_427592444 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_427592444;
        // ---------- Original Method ----------
        //return this.columnNumber;
    }

    
}

