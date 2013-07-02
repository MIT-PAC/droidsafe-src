package org.apache.harmony.xml.dom;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import org.w3c.dom.EntityReference;
import org.w3c.dom.Node;

public class EntityReferenceImpl extends LeafNodeImpl implements EntityReference {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.106 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private String name;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.106 -0400", hash_original_method = "0FEA3B6855AA06DD4FD452A95A08D422", hash_generated_method = "FB13DAF3B53ABC6A4613FC12AF0D1BD9")
      EntityReferenceImpl(DocumentImpl document, String name) {
        super(document);
        this.name = name;
        addTaint(document.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.106 -0400", hash_original_method = "5A3E3202FC8B21204CAC945442E54540", hash_generated_method = "D7A67D87E1413E20EF1E00F31097C341")
    @Override
    public String getNodeName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1333555939 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1333555939 = name;
        varB4EAC82CA7396A68D541C85D26508E83_1333555939.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1333555939;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.107 -0400", hash_original_method = "3C28BE11A99788526FD11A7F01EE97F6", hash_generated_method = "CCB9B95A47EE9D0D39BC55E1559562D5")
    @Override
    public short getNodeType() {
        short var4F09DAA9D95BCB166A302407A0E0BABE_1554099572 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_1554099572;
        
        
    }

    
}

