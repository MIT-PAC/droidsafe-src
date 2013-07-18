package org.apache.harmony.xml.dom;

// Droidsafe Imports
import org.w3c.dom.EntityReference;
import org.w3c.dom.Node;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class EntityReferenceImpl extends LeafNodeImpl implements EntityReference {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.457 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private String name;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.457 -0400", hash_original_method = "0FEA3B6855AA06DD4FD452A95A08D422", hash_generated_method = "2BD3024BAC177934AA0ABB7953C69198")
      EntityReferenceImpl(DocumentImpl document, String name) {
        super(document);
        addTaint(document.getTaint());
        this.name = name;
        // ---------- Original Method ----------
        //this.name = name;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.457 -0400", hash_original_method = "5A3E3202FC8B21204CAC945442E54540", hash_generated_method = "D6AD26112DF8A2F3E1740265528D7798")
    @Override
    public String getNodeName() {
String varB017984728AC60AD1F0BF8734F33F15C_1423348378 =         name;
        varB017984728AC60AD1F0BF8734F33F15C_1423348378.addTaint(taint);
        return varB017984728AC60AD1F0BF8734F33F15C_1423348378;
        // ---------- Original Method ----------
        //return name;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.457 -0400", hash_original_method = "3C28BE11A99788526FD11A7F01EE97F6", hash_generated_method = "76AF66DB863019B3058BB3D474B24669")
    @Override
    public short getNodeType() {
        short var12C9614FD65DD16E8E874F285C97B61A_1465024670 = (Node.ENTITY_REFERENCE_NODE);
                short var4F09DAA9D95BCB166A302407A0E0BABE_329516879 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_329516879;
        // ---------- Original Method ----------
        //return Node.ENTITY_REFERENCE_NODE;
    }

    
}

