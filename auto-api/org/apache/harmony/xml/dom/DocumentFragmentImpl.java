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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.772 -0400", hash_original_method = "B1D1A671578496EB48835D218203CA93", hash_generated_method = "421CBD2E20B1FA2FAC0712CBFADDBED8")
      DocumentFragmentImpl(DocumentImpl document) {
        super(document);
        addTaint(document.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.773 -0400", hash_original_method = "D48C9C65653FE8B5C8C6E3ECCF0B8A68", hash_generated_method = "042DD391571B450AFE21B63F6A29340F")
    @Override
    public String getNodeName() {
        String varB4EAC82CA7396A68D541C85D26508E83_819069336 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_819069336 = "#document-fragment";
        varB4EAC82CA7396A68D541C85D26508E83_819069336.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_819069336;
        // ---------- Original Method ----------
        //return "#document-fragment";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.773 -0400", hash_original_method = "0F2F6CD4C06D66DF39BC0FDC5EEF69E4", hash_generated_method = "744EC2EF71E5104E39712A411843CA39")
    @Override
    public short getNodeType() {
        short var4F09DAA9D95BCB166A302407A0E0BABE_334160906 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_334160906;
        // ---------- Original Method ----------
        //return Node.DOCUMENT_FRAGMENT_NODE;
    }

    
}

