package org.xml.sax.helpers;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.xml.sax.Locator;

public class LocatorImpl implements Locator {
    private String publicId;
    private String systemId;
    private int lineNumber;
    private int columnNumber;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.431 -0400", hash_original_method = "1944A965405A65742195C130B4EA39CD", hash_generated_method = "41C9F2F41F2C736A19B0FB99C5AC7CBE")
    @DSModeled(DSC.SAFE)
    public LocatorImpl() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.431 -0400", hash_original_method = "5648D7E11C6AEEB11BABA800E96BBFD7", hash_generated_method = "A876117BBA645F458EC1CD4EBE6BE935")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public LocatorImpl(Locator locator) {
        dsTaint.addTaint(locator.dsTaint);
        setPublicId(locator.getPublicId());
        setSystemId(locator.getSystemId());
        setLineNumber(locator.getLineNumber());
        setColumnNumber(locator.getColumnNumber());
        // ---------- Original Method ----------
        //setPublicId(locator.getPublicId());
        //setSystemId(locator.getSystemId());
        //setLineNumber(locator.getLineNumber());
        //setColumnNumber(locator.getColumnNumber());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.431 -0400", hash_original_method = "C19BBE926A67132A1C6BC386100A3E69", hash_generated_method = "80E14D34056E183CC70BFA8E6AC62A29")
    @DSModeled(DSC.SAFE)
    public String getPublicId() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return publicId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.431 -0400", hash_original_method = "8088708D8DEEE6054468B7FD77400E50", hash_generated_method = "A23C365E1375B215042F45D99272D5FD")
    @DSModeled(DSC.SAFE)
    public String getSystemId() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return systemId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.431 -0400", hash_original_method = "0B737233CC5342C14C595BEE1A87604B", hash_generated_method = "8FBB8E3CC75CF90102A14D266C28BCCC")
    @DSModeled(DSC.SAFE)
    public int getLineNumber() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return lineNumber;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.431 -0400", hash_original_method = "50401770B079F9FC2B373BD150CB3B15", hash_generated_method = "8BC80F3B08A46F3603DD2CFE3FDCE21A")
    @DSModeled(DSC.SAFE)
    public int getColumnNumber() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return columnNumber;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.431 -0400", hash_original_method = "0C418225BFB03C04E3636F3891B47A3E", hash_generated_method = "A63FB664BFF43757802E46F09831E67B")
    @DSModeled(DSC.SAFE)
    public void setPublicId(String publicId) {
        dsTaint.addTaint(publicId);
        // ---------- Original Method ----------
        //this.publicId = publicId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.432 -0400", hash_original_method = "77F5337B905F22D1C71F7C949FEF5117", hash_generated_method = "CA0D92AF74DF0B83297874E289017F25")
    @DSModeled(DSC.SAFE)
    public void setSystemId(String systemId) {
        dsTaint.addTaint(systemId);
        // ---------- Original Method ----------
        //this.systemId = systemId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.432 -0400", hash_original_method = "57105994EF91DD2584057988497ACBF5", hash_generated_method = "38A7E32CAE3495347CB76793DDDF924C")
    @DSModeled(DSC.SAFE)
    public void setLineNumber(int lineNumber) {
        dsTaint.addTaint(lineNumber);
        // ---------- Original Method ----------
        //this.lineNumber = lineNumber;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.432 -0400", hash_original_method = "4B7308C11003E2EBA4BF69C9D8266B60", hash_generated_method = "C863669FF0380313BAD92213E1749045")
    @DSModeled(DSC.SAFE)
    public void setColumnNumber(int columnNumber) {
        dsTaint.addTaint(columnNumber);
        // ---------- Original Method ----------
        //this.columnNumber = columnNumber;
    }

    
}

