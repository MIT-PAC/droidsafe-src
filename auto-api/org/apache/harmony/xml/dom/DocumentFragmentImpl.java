package org.apache.harmony.xml.dom;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.w3c.dom.DocumentFragment;
import org.w3c.dom.Node;

public class DocumentFragmentImpl extends InnerNodeImpl implements DocumentFragment {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.194 -0400", hash_original_method = "B1D1A671578496EB48835D218203CA93", hash_generated_method = "7B7553F392DB1969CE84931134268CB0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     DocumentFragmentImpl(DocumentImpl document) {
        super(document);
        dsTaint.addTaint(document.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.194 -0400", hash_original_method = "D48C9C65653FE8B5C8C6E3ECCF0B8A68", hash_generated_method = "B5F16E8921066E9D4B1782E55E4DDA6C")
    @DSModeled(DSC.SAFE)
    @Override
    public String getNodeName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "#document-fragment";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.194 -0400", hash_original_method = "0F2F6CD4C06D66DF39BC0FDC5EEF69E4", hash_generated_method = "ADB63C7C43F373787A49BA03F851A5C5")
    @DSModeled(DSC.SAFE)
    @Override
    public short getNodeType() {
        return dsTaint.getTaintShort();
        // ---------- Original Method ----------
        //return Node.DOCUMENT_FRAGMENT_NODE;
    }

    
}

