package org.xml.sax;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public class SAXParseException extends SAXException {
    private String publicId;
    private String systemId;
    private int lineNumber;
    private int columnNumber;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.167 -0400", hash_original_method = "91659A5F6A3DDFF6C0F2D77A2F2D10D9", hash_generated_method = "D94CA2460260D10912C2E05CEC337952")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SAXParseException(String message, Locator locator) {
        super(message);
        dsTaint.addTaint(message);
        dsTaint.addTaint(locator.dsTaint);
        {
            init(locator.getPublicId(), locator.getSystemId(),
         locator.getLineNumber(), locator.getColumnNumber());
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.167 -0400", hash_original_method = "7445111C75F88435899093DB45466FBB", hash_generated_method = "2DB0C294F4B8948CC3F2379002903BDA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SAXParseException(String message, Locator locator,
                  Exception e) {
        super(message, e);
        dsTaint.addTaint(message);
        dsTaint.addTaint(locator.dsTaint);
        dsTaint.addTaint(e.dsTaint);
        {
            init(locator.getPublicId(), locator.getSystemId(),
         locator.getLineNumber(), locator.getColumnNumber());
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.167 -0400", hash_original_method = "F6A205656E7433FA991BA49A47A0113E", hash_generated_method = "8FA41BFF9CA4C98AEECF996A94643670")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SAXParseException(String message, String publicId, String systemId,
                  int lineNumber, int columnNumber) {
        super(message);
        dsTaint.addTaint(message);
        dsTaint.addTaint(publicId);
        dsTaint.addTaint(lineNumber);
        dsTaint.addTaint(systemId);
        dsTaint.addTaint(columnNumber);
        init(publicId, systemId, lineNumber, columnNumber);
        // ---------- Original Method ----------
        //init(publicId, systemId, lineNumber, columnNumber);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.168 -0400", hash_original_method = "7C92F995098676855E75CD731C6CE956", hash_generated_method = "CE246202D3D54417162228C77AEC87F7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SAXParseException(String message, String publicId, String systemId,
                  int lineNumber, int columnNumber, Exception e) {
        super(message, e);
        dsTaint.addTaint(message);
        dsTaint.addTaint(e.dsTaint);
        dsTaint.addTaint(publicId);
        dsTaint.addTaint(lineNumber);
        dsTaint.addTaint(systemId);
        dsTaint.addTaint(columnNumber);
        init(publicId, systemId, lineNumber, columnNumber);
        // ---------- Original Method ----------
        //init(publicId, systemId, lineNumber, columnNumber);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.168 -0400", hash_original_method = "CF8913A55801AA3E419E95D1888FBD68", hash_generated_method = "F6B8A43E2F2BF24D2F96CF0B84A555B9")
    @DSModeled(DSC.SAFE)
    private void init(String publicId, String systemId,
               int lineNumber, int columnNumber) {
        dsTaint.addTaint(publicId);
        dsTaint.addTaint(lineNumber);
        dsTaint.addTaint(systemId);
        dsTaint.addTaint(columnNumber);
        // ---------- Original Method ----------
        //this.publicId = publicId;
        //this.systemId = systemId;
        //this.lineNumber = lineNumber;
        //this.columnNumber = columnNumber;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.168 -0400", hash_original_method = "651ECBF976325F0553967BB40DF656D7", hash_generated_method = "8BDFF082A6FCDB74666C7D3C4C762D90")
    @DSModeled(DSC.SAFE)
    public String getPublicId() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return this.publicId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.168 -0400", hash_original_method = "600C253C44A23EDB0A978A11FA5F90C2", hash_generated_method = "DB7664D2732A5FADC22E4001B130F0E1")
    @DSModeled(DSC.SAFE)
    public String getSystemId() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return this.systemId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.168 -0400", hash_original_method = "1D6EF9406E829BF96953F811A8A7C017", hash_generated_method = "104146484045AA465F4DFC9DCDD95F10")
    @DSModeled(DSC.SAFE)
    public int getLineNumber() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return this.lineNumber;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.168 -0400", hash_original_method = "0DEBF9F56751828220A5A7801C031403", hash_generated_method = "44142A0C6287B77141D49092B7E9E21D")
    @DSModeled(DSC.SAFE)
    public int getColumnNumber() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return this.columnNumber;
    }

    
}


