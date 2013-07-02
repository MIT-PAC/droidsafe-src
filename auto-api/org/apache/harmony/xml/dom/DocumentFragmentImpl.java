package org.apache.harmony.xml.dom;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import org.w3c.dom.DocumentFragment;
import org.w3c.dom.Node;

public class DocumentFragmentImpl extends InnerNodeImpl implements DocumentFragment {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.912 -0400", hash_original_method = "B1D1A671578496EB48835D218203CA93", hash_generated_method = "421CBD2E20B1FA2FAC0712CBFADDBED8")
      DocumentFragmentImpl(DocumentImpl document) {
        super(document);
        addTaint(document.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.912 -0400", hash_original_method = "D48C9C65653FE8B5C8C6E3ECCF0B8A68", hash_generated_method = "E2CB9124B2F9B148CD814A5742B9BEBC")
    @Override
    public String getNodeName() {
        String varB4EAC82CA7396A68D541C85D26508E83_2011259598 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2011259598 = "#document-fragment";
        varB4EAC82CA7396A68D541C85D26508E83_2011259598.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2011259598;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.913 -0400", hash_original_method = "0F2F6CD4C06D66DF39BC0FDC5EEF69E4", hash_generated_method = "27FBDDA034117697A5D6FB10BF07D511")
    @Override
    public short getNodeType() {
        short var4F09DAA9D95BCB166A302407A0E0BABE_1764310879 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_1764310879;
        
        
    }

    
}

