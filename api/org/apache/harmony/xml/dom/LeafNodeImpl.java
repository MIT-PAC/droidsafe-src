package org.apache.harmony.xml.dom;

// Droidsafe Imports
import org.w3c.dom.Node;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public abstract class LeafNodeImpl extends NodeImpl {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.515 -0400", hash_original_field = "D0E45878043844FFC41AAC437E86B602", hash_generated_field = "5449DEEA97DBC636B0C94C7706497CE1")

    InnerNodeImpl parent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.515 -0400", hash_original_field = "6A992D5529F459A44FEE58C733255E86", hash_generated_field = "8BD524D6245D998B3BBC44EB9313082E")

    int index;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.516 -0400", hash_original_method = "C37CADF0F64FF24C3BED74AC237BFE15", hash_generated_method = "BD8792B33C5ED85E1BF733B7FAB8E9B4")
      LeafNodeImpl(DocumentImpl document) {
        super(document);
        addTaint(document.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.516 -0400", hash_original_method = "DC63B22231FC6D38D6E19E3A9D1523CF", hash_generated_method = "385CCE813CA04A60F9D59251FADE09B0")
    public Node getNextSibling() {
        if(parent == null || index + 1 >= parent.children.size())        
        {
Node var540C13E9E156B687226421B24F2DF178_1504960488 =             null;
            var540C13E9E156B687226421B24F2DF178_1504960488.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1504960488;
        } //End block
Node varCAF2121A40A40843AD59F9E2CDF911E5_407387989 =         parent.children.get(index + 1);
        varCAF2121A40A40843AD59F9E2CDF911E5_407387989.addTaint(taint);
        return varCAF2121A40A40843AD59F9E2CDF911E5_407387989;
        // ---------- Original Method ----------
        //if (parent == null || index + 1 >= parent.children.size()) {
            //return null;
        //}
        //return parent.children.get(index + 1);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.517 -0400", hash_original_method = "B8A0C756618E449548951ECCC8542C8B", hash_generated_method = "A06543C547F7CB58D749DF977AE1D591")
    public Node getParentNode() {
Node var0F49909EA73F8892C338E4DCA6EB9906_1152770598 =         parent;
        var0F49909EA73F8892C338E4DCA6EB9906_1152770598.addTaint(taint);
        return var0F49909EA73F8892C338E4DCA6EB9906_1152770598;
        // ---------- Original Method ----------
        //return parent;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.518 -0400", hash_original_method = "8D9655D90408A316224292865014DAE6", hash_generated_method = "C16EADB32A6F543E69C964AEACAC5F38")
    public Node getPreviousSibling() {
        if(parent == null || index == 0)        
        {
Node var540C13E9E156B687226421B24F2DF178_1648102386 =             null;
            var540C13E9E156B687226421B24F2DF178_1648102386.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1648102386;
        } //End block
Node varBCF210482F2AE12B57DFC78EE95A547D_496390517 =         parent.children.get(index - 1);
        varBCF210482F2AE12B57DFC78EE95A547D_496390517.addTaint(taint);
        return varBCF210482F2AE12B57DFC78EE95A547D_496390517;
        // ---------- Original Method ----------
        //if (parent == null || index == 0) {
            //return null;
        //}
        //return parent.children.get(index - 1);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.518 -0400", hash_original_method = "4FE9AF789BEC71BD17F719913A9768F5", hash_generated_method = "BBD056B9F7301B776C1B511E9946B5DA")
     boolean isParentOf(Node node) {
        addTaint(node.getTaint());
        boolean var68934A3E9455FA72420237EB05902327_431958194 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1852736771 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1852736771;
        // ---------- Original Method ----------
        //return false;
    }

    
}

