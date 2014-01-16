package org.apache.harmony.xml.dom;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class NodeListImpl implements NodeList {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:21.447 -0500", hash_original_field = "3571FDEDABBB67C544DB562B84A412E3", hash_generated_field = "01219BC14411B8933603C8E4F4F1DCA8")

    private List<NodeImpl> children;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:21.450 -0500", hash_original_method = "90C695C7BB2C17E5AEDC35249C42B72B", hash_generated_method = "90C695C7BB2C17E5AEDC35249C42B72B")
    
NodeListImpl() {
        children = new ArrayList<NodeImpl>();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:21.452 -0500", hash_original_method = "769B9507B64DB92B25819A81313D951D", hash_generated_method = "769B9507B64DB92B25819A81313D951D")
    
NodeListImpl(List<NodeImpl> list) {
        children = list;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:21.454 -0500", hash_original_method = "3686ABB43FF3696F10F1056AA01C2579", hash_generated_method = "3686ABB43FF3696F10F1056AA01C2579")
    
void add(NodeImpl node) {
        children.add(node);
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:21.457 -0500", hash_original_method = "91DC5DE88E19C57D8C382EFD5B1079BB", hash_generated_method = "C2BBA1299B7523F687324429EBEEAFEA")
    
public int getLength() {
        return children.size();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:21.459 -0500", hash_original_method = "41D1F200C8CAC9D2F8301DE4F00B532B", hash_generated_method = "024D75DC0A1AEA09B314F39F63AC754A")
    
public Node item(int index) {
        if (index >= children.size()) {
            return null;
        } else {
            return children.get(index);
        }
    }
    
}

