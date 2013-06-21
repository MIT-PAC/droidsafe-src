package org.apache.harmony.xml.dom;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.w3c.dom.DOMError;
import org.w3c.dom.DOMLocator;
import org.w3c.dom.Node;

public final class DOMErrorImpl implements DOMError {
    private short severity;
    private String type;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.159 -0400", hash_original_method = "D93952774FCD9E5EB0D2AAFF03FA31D6", hash_generated_method = "B070459DBA321D329B43950144EE8A65")
    @DSModeled(DSC.SAFE)
    public DOMErrorImpl(short severity, String type) {
        dsTaint.addTaint(severity);
        dsTaint.addTaint(type);
        // ---------- Original Method ----------
        //this.severity = severity;
        //this.type = type;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.159 -0400", hash_original_method = "486D9FD618449ECBCAAA947A01B6396E", hash_generated_method = "1E9B8B8E9A2B3949EB081D83B4A34AC2")
    @DSModeled(DSC.SAFE)
    public short getSeverity() {
        return dsTaint.getTaintShort();
        // ---------- Original Method ----------
        //return severity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.159 -0400", hash_original_method = "736EB773CAD78737D003DEF14371364B", hash_generated_method = "C6A7AE1436C921C7BAE6B4B3CF3AF492")
    @DSModeled(DSC.SAFE)
    public String getMessage() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return type;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.159 -0400", hash_original_method = "0E0B07C7C3039087C9D268CAF8DACC19", hash_generated_method = "AC38FD6D562C8CFA3E5E586F21D2F37D")
    @DSModeled(DSC.SAFE)
    public String getType() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return type;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.160 -0400", hash_original_method = "69DC7C3C45CF145B81BFA491DBEA3D67", hash_generated_method = "3DD743BD77642A9D4493F06E978B0CEA")
    @DSModeled(DSC.SAFE)
    public Object getRelatedException() {
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.160 -0400", hash_original_method = "2E051F1CC67E124CEB94F15E64801D89", hash_generated_method = "7FD8D8A2E28A2F0FDF146BDAA95FDCD8")
    @DSModeled(DSC.SAFE)
    public Object getRelatedData() {
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.160 -0400", hash_original_method = "5FDC1F3E63CCD7CD3042D9A19CD94FF4", hash_generated_method = "2CBC34CEB2A36F549ACB93F04502526B")
    @DSModeled(DSC.SAFE)
    public DOMLocator getLocation() {
        return (DOMLocator)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return NULL_DOM_LOCATOR;
    }

    
    private static final DOMLocator NULL_DOM_LOCATOR = new DOMLocator() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.160 -0400", hash_original_method = "B226EF391D7A5788D2A6B61A29A598E0", hash_generated_method = "C7AB1C32CBC00CC52E9810FB232C0976")
        @DSModeled(DSC.SAFE)
        public int getLineNumber() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return -1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.160 -0400", hash_original_method = "8861CD3D81AD120598D5847E998DCDDD", hash_generated_method = "D46CF5CF46D8B989B2A4A44717C571DD")
        @DSModeled(DSC.SAFE)
        public int getColumnNumber() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return -1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.160 -0400", hash_original_method = "05B54428E2337843F9A27998024BB4FC", hash_generated_method = "FB305D764C32DE26675E84A5B97B08E4")
        @DSModeled(DSC.SAFE)
        public int getByteOffset() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return -1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.160 -0400", hash_original_method = "971AF81D7B5A736C60DA276A39DEF629", hash_generated_method = "DD7F471FFD037D0FCA34FEC28C0B9023")
        @DSModeled(DSC.SAFE)
        public int getUtf16Offset() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return -1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.161 -0400", hash_original_method = "BD213E5A838EDE8A4D1403172904A1AB", hash_generated_method = "89088B4804E0E13F948F12833423A9AF")
        @DSModeled(DSC.SAFE)
        public Node getRelatedNode() {
            return (Node)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.161 -0400", hash_original_method = "08DC8B98EA7E10D6197A6D233921DA55", hash_generated_method = "EAFC59AB8237E658F58474B5F1C0BE0C")
        @DSModeled(DSC.SAFE)
        public String getUri() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return null;
        }

        
}; //Transformed anonymous class
}

