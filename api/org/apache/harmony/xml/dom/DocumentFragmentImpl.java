package org.apache.harmony.xml.dom;

// Droidsafe Imports
import org.w3c.dom.DocumentFragment;
import org.w3c.dom.Node;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class DocumentFragmentImpl extends InnerNodeImpl implements DocumentFragment {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.303 -0400", hash_original_method = "B1D1A671578496EB48835D218203CA93", hash_generated_method = "421CBD2E20B1FA2FAC0712CBFADDBED8")
      DocumentFragmentImpl(DocumentImpl document) {
        super(document);
        addTaint(document.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.304 -0400", hash_original_method = "D48C9C65653FE8B5C8C6E3ECCF0B8A68", hash_generated_method = "81E6D31FFB6C33CAC9C5E73EA0B554D0")
    @Override
    public String getNodeName() {
String varF287D4A7E79E99AB03AE4329BB749CF2_691744218 =         "#document-fragment";
        varF287D4A7E79E99AB03AE4329BB749CF2_691744218.addTaint(taint);
        return varF287D4A7E79E99AB03AE4329BB749CF2_691744218;
        // ---------- Original Method ----------
        //return "#document-fragment";
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.305 -0400", hash_original_method = "0F2F6CD4C06D66DF39BC0FDC5EEF69E4", hash_generated_method = "0C1EC29DF5E6D16D65AA326C485F5FDC")
    @Override
    public short getNodeType() {
        short varD3CACC7C32D0AEAE7DFBBFE5A1C50E78_1243089680 = (Node.DOCUMENT_FRAGMENT_NODE);
                short var4F09DAA9D95BCB166A302407A0E0BABE_1387674340 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_1387674340;
        // ---------- Original Method ----------
        //return Node.DOCUMENT_FRAGMENT_NODE;
    }

    
}

