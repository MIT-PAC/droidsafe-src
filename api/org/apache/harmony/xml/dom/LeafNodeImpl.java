package org.apache.harmony.xml.dom;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import org.w3c.dom.Node;

public abstract class LeafNodeImpl extends NodeImpl {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.777 -0400", hash_original_field = "D0E45878043844FFC41AAC437E86B602", hash_generated_field = "5449DEEA97DBC636B0C94C7706497CE1")

    InnerNodeImpl parent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.777 -0400", hash_original_field = "6A992D5529F459A44FEE58C733255E86", hash_generated_field = "8BD524D6245D998B3BBC44EB9313082E")

    int index;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.777 -0400", hash_original_method = "C37CADF0F64FF24C3BED74AC237BFE15", hash_generated_method = "BD8792B33C5ED85E1BF733B7FAB8E9B4")
      LeafNodeImpl(DocumentImpl document) {
        super(document);
        addTaint(document.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.778 -0400", hash_original_method = "DC63B22231FC6D38D6E19E3A9D1523CF", hash_generated_method = "0B29EB2C23156395444E8FBC201973A1")
    public Node getNextSibling() {
    if(parent == null || index + 1 >= parent.children.size())        
        {
Node var540C13E9E156B687226421B24F2DF178_1641838496 =             null;
            var540C13E9E156B687226421B24F2DF178_1641838496.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1641838496;
        } //End block
Node varCAF2121A40A40843AD59F9E2CDF911E5_1845677900 =         parent.children.get(index + 1);
        varCAF2121A40A40843AD59F9E2CDF911E5_1845677900.addTaint(taint);
        return varCAF2121A40A40843AD59F9E2CDF911E5_1845677900;
        // ---------- Original Method ----------
        //if (parent == null || index + 1 >= parent.children.size()) {
            //return null;
        //}
        //return parent.children.get(index + 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.778 -0400", hash_original_method = "B8A0C756618E449548951ECCC8542C8B", hash_generated_method = "2CDBA2C750C6A536D86B5E373D1CDEE9")
    public Node getParentNode() {
Node var0F49909EA73F8892C338E4DCA6EB9906_497330269 =         parent;
        var0F49909EA73F8892C338E4DCA6EB9906_497330269.addTaint(taint);
        return var0F49909EA73F8892C338E4DCA6EB9906_497330269;
        // ---------- Original Method ----------
        //return parent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.778 -0400", hash_original_method = "8D9655D90408A316224292865014DAE6", hash_generated_method = "9C91A4CB60A3B0AC7CE195A3B72F3957")
    public Node getPreviousSibling() {
    if(parent == null || index == 0)        
        {
Node var540C13E9E156B687226421B24F2DF178_1324676865 =             null;
            var540C13E9E156B687226421B24F2DF178_1324676865.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1324676865;
        } //End block
Node varBCF210482F2AE12B57DFC78EE95A547D_1028086002 =         parent.children.get(index - 1);
        varBCF210482F2AE12B57DFC78EE95A547D_1028086002.addTaint(taint);
        return varBCF210482F2AE12B57DFC78EE95A547D_1028086002;
        // ---------- Original Method ----------
        //if (parent == null || index == 0) {
            //return null;
        //}
        //return parent.children.get(index - 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.779 -0400", hash_original_method = "4FE9AF789BEC71BD17F719913A9768F5", hash_generated_method = "5EC9BFFE940A775D76ABE255CFCDE2BD")
     boolean isParentOf(Node node) {
        addTaint(node.getTaint());
        boolean var68934A3E9455FA72420237EB05902327_1874046671 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_40734335 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_40734335;
        // ---------- Original Method ----------
        //return false;
    }

    
}

