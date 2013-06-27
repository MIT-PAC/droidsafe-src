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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.898 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private String name;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.899 -0400", hash_original_method = "0FEA3B6855AA06DD4FD452A95A08D422", hash_generated_method = "FB13DAF3B53ABC6A4613FC12AF0D1BD9")
      EntityReferenceImpl(DocumentImpl document, String name) {
        super(document);
        this.name = name;
        addTaint(document.getTaint());
        // ---------- Original Method ----------
        //this.name = name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.899 -0400", hash_original_method = "5A3E3202FC8B21204CAC945442E54540", hash_generated_method = "34F141D45F9B980D24C6E536A35ACC40")
    @Override
    public String getNodeName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1169100356 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1169100356 = name;
        varB4EAC82CA7396A68D541C85D26508E83_1169100356.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1169100356;
        // ---------- Original Method ----------
        //return name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.899 -0400", hash_original_method = "3C28BE11A99788526FD11A7F01EE97F6", hash_generated_method = "7124CA7422BBCD32296C549B9344E41A")
    @Override
    public short getNodeType() {
        short var4F09DAA9D95BCB166A302407A0E0BABE_804514680 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_804514680;
        // ---------- Original Method ----------
        //return Node.ENTITY_REFERENCE_NODE;
    }

    
}

