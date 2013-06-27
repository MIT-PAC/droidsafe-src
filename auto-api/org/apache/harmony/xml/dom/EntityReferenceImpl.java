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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.777 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private String name;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.777 -0400", hash_original_method = "0FEA3B6855AA06DD4FD452A95A08D422", hash_generated_method = "FB13DAF3B53ABC6A4613FC12AF0D1BD9")
      EntityReferenceImpl(DocumentImpl document, String name) {
        super(document);
        this.name = name;
        addTaint(document.getTaint());
        // ---------- Original Method ----------
        //this.name = name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.778 -0400", hash_original_method = "5A3E3202FC8B21204CAC945442E54540", hash_generated_method = "C89A3BD86C716AE951BCAB6902DDC304")
    @Override
    public String getNodeName() {
        String varB4EAC82CA7396A68D541C85D26508E83_867507273 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_867507273 = name;
        varB4EAC82CA7396A68D541C85D26508E83_867507273.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_867507273;
        // ---------- Original Method ----------
        //return name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.778 -0400", hash_original_method = "3C28BE11A99788526FD11A7F01EE97F6", hash_generated_method = "D19C81024D9A779E4FDFC80891384462")
    @Override
    public short getNodeType() {
        short var4F09DAA9D95BCB166A302407A0E0BABE_152727764 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_152727764;
        // ---------- Original Method ----------
        //return Node.ENTITY_REFERENCE_NODE;
    }

    
}

