package org.apache.harmony.xml.dom;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class NodeListImpl implements NodeList {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.935 -0400", hash_original_field = "268184C12DF027F536154D099D497B31", hash_generated_field = "01219BC14411B8933603C8E4F4F1DCA8")

    private List<NodeImpl> children;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.936 -0400", hash_original_method = "90C695C7BB2C17E5AEDC35249C42B72B", hash_generated_method = "0E4047B11F334542A784CB40C2591858")
      NodeListImpl() {
        children = new ArrayList<NodeImpl>();
        // ---------- Original Method ----------
        //children = new ArrayList<NodeImpl>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.936 -0400", hash_original_method = "769B9507B64DB92B25819A81313D951D", hash_generated_method = "7C6AE4C06DED08E678C5A34AF3F9DA08")
      NodeListImpl(List<NodeImpl> list) {
        children = list;
        // ---------- Original Method ----------
        //children = list;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.937 -0400", hash_original_method = "3686ABB43FF3696F10F1056AA01C2579", hash_generated_method = "B91DD2A3E84E4AF0DB8F1F0CC69341AF")
     void add(NodeImpl node) {
        addTaint(node.getTaint());
        children.add(node);
        // ---------- Original Method ----------
        //children.add(node);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.937 -0400", hash_original_method = "91DC5DE88E19C57D8C382EFD5B1079BB", hash_generated_method = "CE9A7A004FE40A85A061547AF553D941")
    public int getLength() {
        int varCA7385CBF53925F741853B4A529FBE32_1261086321 = (children.size());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1701729607 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1701729607;
        // ---------- Original Method ----------
        //return children.size();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.938 -0400", hash_original_method = "41D1F200C8CAC9D2F8301DE4F00B532B", hash_generated_method = "96370D46C02F5E5175A2EBD8D68F8F9D")
    public Node item(int index) {
        addTaint(index);
    if(index >= children.size())        
        {
Node var540C13E9E156B687226421B24F2DF178_154876350 =             null;
            var540C13E9E156B687226421B24F2DF178_154876350.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_154876350;
        } //End block
        else
        {
Node var93C1CBEE247256B795FC4E611626C622_1626821045 =             children.get(index);
            var93C1CBEE247256B795FC4E611626C622_1626821045.addTaint(taint);
            return var93C1CBEE247256B795FC4E611626C622_1626821045;
        } //End block
        // ---------- Original Method ----------
        //if (index >= children.size()) {
            //return null;
        //} else {
            //return children.get(index);
        //}
    }

    
}

