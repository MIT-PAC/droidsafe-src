package org.apache.harmony.xml.dom;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.w3c.dom.EntityReference;
import org.w3c.dom.Node;

public class EntityReferenceImpl extends LeafNodeImpl implements EntityReference {
    private String name;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.286 -0400", hash_original_method = "0FEA3B6855AA06DD4FD452A95A08D422", hash_generated_method = "B7F3D7815EE71D70A561359AECD5C778")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     EntityReferenceImpl(DocumentImpl document, String name) {
        super(document);
        dsTaint.addTaint(document.dsTaint);
        dsTaint.addTaint(name);
        // ---------- Original Method ----------
        //this.name = name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.286 -0400", hash_original_method = "5A3E3202FC8B21204CAC945442E54540", hash_generated_method = "1FF0730FE34AA9A748FC5C5C713135A1")
    @DSModeled(DSC.SAFE)
    @Override
    public String getNodeName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.286 -0400", hash_original_method = "3C28BE11A99788526FD11A7F01EE97F6", hash_generated_method = "85FAE018FFF4621A13CC79667B44FF79")
    @DSModeled(DSC.SAFE)
    @Override
    public short getNodeType() {
        return dsTaint.getTaintShort();
        // ---------- Original Method ----------
        //return Node.ENTITY_REFERENCE_NODE;
    }

    
}

