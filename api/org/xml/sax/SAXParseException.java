package org.xml.sax;

// Droidsafe Imports
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class SAXParseException extends SAXException {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.249 -0400", hash_original_field = "24AB20BFB578F0A89FF4A9C081F21384", hash_generated_field = "60BF385FD0C88E4BC32EFD3E71F5528C")

    private String publicId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.249 -0400", hash_original_field = "089D1A278481B86E821237F8E98E6DE7", hash_generated_field = "D8573F28EF4599A1790219EF1708D9C9")

    private String systemId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.250 -0400", hash_original_field = "BB8A5A0BF5B38F7D371E940DAED92DA6", hash_generated_field = "09A4698FFE38FA7794A20A1F94A6867E")

    private int lineNumber;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.250 -0400", hash_original_field = "9D2C17DB0A32EEAAF3B613AC483AEB6C", hash_generated_field = "26A7E6694FD33EFB482AC4BA7726E9A4")

    private int columnNumber;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.250 -0400", hash_original_method = "91659A5F6A3DDFF6C0F2D77A2F2D10D9", hash_generated_method = "0CE4F9CA6EDEA1A6F020FD6E56E6D6FD")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.251 -0400", hash_original_method = "7445111C75F88435899093DB45466FBB", hash_generated_method = "6B580BAD176A8ED410139B61B858C796")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.252 -0400", hash_original_method = "F6A205656E7433FA991BA49A47A0113E", hash_generated_method = "60D43526F236A32957D2912A94DFC2AC")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.253 -0400", hash_original_method = "7C92F995098676855E75CD731C6CE956", hash_generated_method = "598FD09DC85031B08116D1E6438D66BE")
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.254 -0400", hash_original_method = "CF8913A55801AA3E419E95D1888FBD68", hash_generated_method = "791E854378503806A83FE508B80FB7F1")
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.255 -0400", hash_original_method = "651ECBF976325F0553967BB40DF656D7", hash_generated_method = "171D7BC929094F592784523832DD296D")
    public String getPublicId() {
String var1AC6044011EA8BF87DD1848A6670336D_128080117 =         this.publicId;
        var1AC6044011EA8BF87DD1848A6670336D_128080117.addTaint(taint);
        return var1AC6044011EA8BF87DD1848A6670336D_128080117;
        // ---------- Original Method ----------
        //return this.publicId;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.255 -0400", hash_original_method = "600C253C44A23EDB0A978A11FA5F90C2", hash_generated_method = "809C52CCD9D97B9B7818F1664BE3772D")
    public String getSystemId() {
String varAECD18EE9EA1CBFED723C63E29874344_829681672 =         this.systemId;
        varAECD18EE9EA1CBFED723C63E29874344_829681672.addTaint(taint);
        return varAECD18EE9EA1CBFED723C63E29874344_829681672;
        // ---------- Original Method ----------
        //return this.systemId;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.256 -0400", hash_original_method = "1D6EF9406E829BF96953F811A8A7C017", hash_generated_method = "C3E8C749E3B5061642D3E4E8363D1B01")
    public int getLineNumber() {
        int varA15531C220A3C6DFF396A4178F65880E_1863048142 = (this.lineNumber);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_309753249 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_309753249;
        // ---------- Original Method ----------
        //return this.lineNumber;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.256 -0400", hash_original_method = "0DEBF9F56751828220A5A7801C031403", hash_generated_method = "CDD2E367682175CB5CD03CAF807C481B")
    public int getColumnNumber() {
        int var0227595DA9BA84A7A7B5E14C9F5EB3A9_1497014131 = (this.columnNumber);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1019058270 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1019058270;
        // ---------- Original Method ----------
        //return this.columnNumber;
    }

    
}

