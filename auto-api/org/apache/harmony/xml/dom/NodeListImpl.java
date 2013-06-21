package org.apache.harmony.xml.dom;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class NodeListImpl implements NodeList {
    private List<NodeImpl> children;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.433 -0400", hash_original_method = "90C695C7BB2C17E5AEDC35249C42B72B", hash_generated_method = "0E4047B11F334542A784CB40C2591858")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     NodeListImpl() {
        children = new ArrayList<NodeImpl>();
        // ---------- Original Method ----------
        //children = new ArrayList<NodeImpl>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.433 -0400", hash_original_method = "769B9507B64DB92B25819A81313D951D", hash_generated_method = "A2577A53254DC188513BADCEC0A0FF37")
    @DSModeled(DSC.SAFE)
     NodeListImpl(List<NodeImpl> list) {
        dsTaint.addTaint(list.dsTaint);
        // ---------- Original Method ----------
        //children = list;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.434 -0400", hash_original_method = "3686ABB43FF3696F10F1056AA01C2579", hash_generated_method = "806FEE5FD23613108B61AE947EE0A797")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void add(NodeImpl node) {
        dsTaint.addTaint(node.dsTaint);
        children.add(node);
        // ---------- Original Method ----------
        //children.add(node);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.434 -0400", hash_original_method = "91DC5DE88E19C57D8C382EFD5B1079BB", hash_generated_method = "5B445132D08D2F2D59F970A3ABD3F408")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getLength() {
        int var491B2FC4AC35162024953FBA897D93CD_1933041020 = (children.size());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return children.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.434 -0400", hash_original_method = "41D1F200C8CAC9D2F8301DE4F00B532B", hash_generated_method = "46BF8EF63F88F50DF97FCB37E7E0EAE4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Node item(int index) {
        dsTaint.addTaint(index);
        {
            boolean varB91815A31D273609574EB28CAF1CE458_1338899842 = (index >= children.size());
            {
                Node var3BDF85F28BF4B79581DACF75F1533995_649564260 = (children.get(index));
            } //End block
        } //End collapsed parenthetic
        return (Node)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (index >= children.size()) {
            //return null;
        //} else {
            //return children.get(index);
        //}
    }

    
}

