package org.apache.harmony.xml.dom;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import org.w3c.dom.DocumentFragment;
import org.w3c.dom.Node;

public class DocumentFragmentImpl extends InnerNodeImpl implements DocumentFragment {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.607 -0400", hash_original_method = "B1D1A671578496EB48835D218203CA93", hash_generated_method = "421CBD2E20B1FA2FAC0712CBFADDBED8")
      DocumentFragmentImpl(DocumentImpl document) {
        super(document);
        addTaint(document.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.607 -0400", hash_original_method = "D48C9C65653FE8B5C8C6E3ECCF0B8A68", hash_generated_method = "E9069870A3175F7F994D9F8D3899935C")
    @Override
    public String getNodeName() {
String varF287D4A7E79E99AB03AE4329BB749CF2_1934392709 =         "#document-fragment";
        varF287D4A7E79E99AB03AE4329BB749CF2_1934392709.addTaint(taint);
        return varF287D4A7E79E99AB03AE4329BB749CF2_1934392709;
        // ---------- Original Method ----------
        //return "#document-fragment";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.607 -0400", hash_original_method = "0F2F6CD4C06D66DF39BC0FDC5EEF69E4", hash_generated_method = "85B6A8069E561CB121FBC793355B11B2")
    @Override
    public short getNodeType() {
        short varD3CACC7C32D0AEAE7DFBBFE5A1C50E78_1446047419 = (Node.DOCUMENT_FRAGMENT_NODE);
                short var4F09DAA9D95BCB166A302407A0E0BABE_1439052599 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_1439052599;
        // ---------- Original Method ----------
        //return Node.DOCUMENT_FRAGMENT_NODE;
    }

    
}

