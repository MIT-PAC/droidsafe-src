package org.xml.sax;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class SAXParseException extends SAXException {
    private String publicId;
    private String systemId;
    private int lineNumber;
    private int columnNumber;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.427 -0400", hash_original_method = "91659A5F6A3DDFF6C0F2D77A2F2D10D9", hash_generated_method = "F5D0D1EA8802BEDDE8498FE4BC0D32EA")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.427 -0400", hash_original_method = "7445111C75F88435899093DB45466FBB", hash_generated_method = "FF8DF4886FEEFA3C08BF7B60784607B1")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.428 -0400", hash_original_method = "F6A205656E7433FA991BA49A47A0113E", hash_generated_method = "24F1F3EB61DAD1B4EDE481D6C840DD77")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.428 -0400", hash_original_method = "7C92F995098676855E75CD731C6CE956", hash_generated_method = "40D55E38B33AD8842BBEB2EB9B50DE0B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.428 -0400", hash_original_method = "CF8913A55801AA3E419E95D1888FBD68", hash_generated_method = "2302B0CBC7F10302EA2DA9FFC9F449D7")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.428 -0400", hash_original_method = "651ECBF976325F0553967BB40DF656D7", hash_generated_method = "6EC94AC2E69D94E1654CD43A008AFDD5")
    @DSModeled(DSC.SAFE)
    public String getPublicId() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return this.publicId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.428 -0400", hash_original_method = "600C253C44A23EDB0A978A11FA5F90C2", hash_generated_method = "C34F86EA68070620DB462421A5A1E66C")
    @DSModeled(DSC.SAFE)
    public String getSystemId() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return this.systemId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.428 -0400", hash_original_method = "1D6EF9406E829BF96953F811A8A7C017", hash_generated_method = "4222F5D79BFAFC23C06294F7B3CD94DA")
    @DSModeled(DSC.SAFE)
    public int getLineNumber() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return this.lineNumber;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.429 -0400", hash_original_method = "0DEBF9F56751828220A5A7801C031403", hash_generated_method = "26BEBC1F31862B2B691E98B1F1B5E7BB")
    @DSModeled(DSC.SAFE)
    public int getColumnNumber() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return this.columnNumber;
    }

    
}

