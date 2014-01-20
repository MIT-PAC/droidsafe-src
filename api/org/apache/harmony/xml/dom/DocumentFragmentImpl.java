package org.apache.harmony.xml.dom;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import org.w3c.dom.DocumentFragment;
import org.w3c.dom.Node;

public class DocumentFragmentImpl extends InnerNodeImpl implements DocumentFragment {

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:21.569 -0500", hash_original_method = "B1D1A671578496EB48835D218203CA93", hash_generated_method = "B1D1A671578496EB48835D218203CA93")
    
DocumentFragmentImpl(DocumentImpl document) {
        super(document);
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:21.571 -0500", hash_original_method = "D48C9C65653FE8B5C8C6E3ECCF0B8A68", hash_generated_method = "B31F7DA4B5DD9606283D80EA46773CF4")
    
@Override
    public String getNodeName() {
        return "#document-fragment";
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:21.574 -0500", hash_original_method = "0F2F6CD4C06D66DF39BC0FDC5EEF69E4", hash_generated_method = "5BC3A2A53936167A7CB1FF7A9708C8C4")
    
@Override
    public short getNodeType() {
        return Node.DOCUMENT_FRAGMENT_NODE;
    }
    
}

