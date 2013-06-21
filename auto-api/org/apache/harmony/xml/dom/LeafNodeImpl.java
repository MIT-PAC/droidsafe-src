package org.apache.harmony.xml.dom;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.w3c.dom.Node;

public abstract class LeafNodeImpl extends NodeImpl {
    InnerNodeImpl parent;
    int index;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.339 -0400", hash_original_method = "C37CADF0F64FF24C3BED74AC237BFE15", hash_generated_method = "2C995739AD0255C7AEEF93A90D54512E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     LeafNodeImpl(DocumentImpl document) {
        super(document);
        dsTaint.addTaint(document.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.339 -0400", hash_original_method = "DC63B22231FC6D38D6E19E3A9D1523CF", hash_generated_method = "F6DB0406DA4C6308A955371278ECD21E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Node getNextSibling() {
        {
            boolean var95B22E1313A32C2512A690CDD98132D0_118952416 = (parent == null || index + 1 >= parent.children.size());
        } //End collapsed parenthetic
        Node var002A65CD7D092A52936079C9508E6C2F_537074756 = (parent.children.get(index + 1));
        return (Node)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (parent == null || index + 1 >= parent.children.size()) {
            //return null;
        //}
        //return parent.children.get(index + 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.339 -0400", hash_original_method = "B8A0C756618E449548951ECCC8542C8B", hash_generated_method = "40597A036203234CFF3B51285848BB57")
    @DSModeled(DSC.SAFE)
    public Node getParentNode() {
        return (Node)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return parent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.339 -0400", hash_original_method = "8D9655D90408A316224292865014DAE6", hash_generated_method = "53BF155590B068A588406202E84A9AC6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Node getPreviousSibling() {
        Node var60271E00BFF3D4570AC8C10FD5BDC806_967390965 = (parent.children.get(index - 1));
        return (Node)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (parent == null || index == 0) {
            //return null;
        //}
        //return parent.children.get(index - 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.340 -0400", hash_original_method = "4FE9AF789BEC71BD17F719913A9768F5", hash_generated_method = "4F7A16549A1A5F5201341D05AA8AFEC3")
    @DSModeled(DSC.SAFE)
     boolean isParentOf(Node node) {
        dsTaint.addTaint(node.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
}

