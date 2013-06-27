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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.597 -0400", hash_original_method = "B1D1A671578496EB48835D218203CA93", hash_generated_method = "421CBD2E20B1FA2FAC0712CBFADDBED8")
      DocumentFragmentImpl(DocumentImpl document) {
        super(document);
        addTaint(document.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.598 -0400", hash_original_method = "D48C9C65653FE8B5C8C6E3ECCF0B8A68", hash_generated_method = "75670F23BC56A6A7BFA18B1B35F877F3")
    @Override
    public String getNodeName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1331242308 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1331242308 = "#document-fragment";
        varB4EAC82CA7396A68D541C85D26508E83_1331242308.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1331242308;
        // ---------- Original Method ----------
        //return "#document-fragment";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.598 -0400", hash_original_method = "0F2F6CD4C06D66DF39BC0FDC5EEF69E4", hash_generated_method = "90C928F862F1D89BF6C13B86D95816D1")
    @Override
    public short getNodeType() {
        short var4F09DAA9D95BCB166A302407A0E0BABE_2056416871 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_2056416871;
        // ---------- Original Method ----------
        //return Node.DOCUMENT_FRAGMENT_NODE;
    }

    
}

