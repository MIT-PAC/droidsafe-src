package org.apache.harmony.xml.dom;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import org.w3c.dom.EntityReference;
import org.w3c.dom.Node;

public class EntityReferenceImpl extends LeafNodeImpl implements EntityReference {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:21.233 -0500", hash_original_field = "BF45F7481B8091DE3CBF80E94F7F940B", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private String name;

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:21.235 -0500", hash_original_method = "0FEA3B6855AA06DD4FD452A95A08D422", hash_generated_method = "0FEA3B6855AA06DD4FD452A95A08D422")
    
EntityReferenceImpl(DocumentImpl document, String name) {
        super(document);
        this.name = name;
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:21.237 -0500", hash_original_method = "5A3E3202FC8B21204CAC945442E54540", hash_generated_method = "6DF165B4538EAB87C06FEC6193E077BF")
    
@Override
    public String getNodeName() {
        return name;
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:21.239 -0500", hash_original_method = "3C28BE11A99788526FD11A7F01EE97F6", hash_generated_method = "D769BAF9AF4AAFEACA5E76338B5CC0B0")
    
@Override
    public short getNodeType() {
        return Node.ENTITY_REFERENCE_NODE;
    }
    
}

