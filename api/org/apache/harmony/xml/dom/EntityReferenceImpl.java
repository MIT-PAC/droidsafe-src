package org.apache.harmony.xml.dom;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import org.w3c.dom.EntityReference;
import org.w3c.dom.Node;

public class EntityReferenceImpl extends LeafNodeImpl implements EntityReference {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.736 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private String name;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.736 -0400", hash_original_method = "0FEA3B6855AA06DD4FD452A95A08D422", hash_generated_method = "2BD3024BAC177934AA0ABB7953C69198")
      EntityReferenceImpl(DocumentImpl document, String name) {
        super(document);
        addTaint(document.getTaint());
        this.name = name;
        // ---------- Original Method ----------
        //this.name = name;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.736 -0400", hash_original_method = "5A3E3202FC8B21204CAC945442E54540", hash_generated_method = "55B9F9A76D3D92EF423FF27089B491A0")
    @Override
    public String getNodeName() {
String varB017984728AC60AD1F0BF8734F33F15C_2001480160 =         name;
        varB017984728AC60AD1F0BF8734F33F15C_2001480160.addTaint(taint);
        return varB017984728AC60AD1F0BF8734F33F15C_2001480160;
        // ---------- Original Method ----------
        //return name;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.737 -0400", hash_original_method = "3C28BE11A99788526FD11A7F01EE97F6", hash_generated_method = "1224FFBB6FBFC491DFF87A49CEB98FD7")
    @Override
    public short getNodeType() {
        short var12C9614FD65DD16E8E874F285C97B61A_1667356197 = (Node.ENTITY_REFERENCE_NODE);
                short var4F09DAA9D95BCB166A302407A0E0BABE_2080366354 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_2080366354;
        // ---------- Original Method ----------
        //return Node.ENTITY_REFERENCE_NODE;
    }

    
}

