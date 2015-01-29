package java.util.prefs;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.util.ArrayList;
import java.util.Iterator;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

class NodeSet implements NodeList {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.591 -0400", hash_original_field = "948D69B1125F095B7905822439358789", hash_generated_field = "948D69B1125F095B7905822439358789")


    ArrayList<Node> list = new ArrayList<Node>();

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.592 -0400", hash_original_method = "41E209C33C5FF230FA9CE2936163091F", hash_generated_method = "87E1EBAA8720B21CFBB6B441F606B81D")
    
public NodeSet(Iterator<Node> nodes) {
        while(nodes.hasNext()) {
            list.add(nodes.next());
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.592 -0400", hash_original_method = "B19BA94C169FF5EF48005794E2F6BDA4", hash_generated_method = "5632F948B941535E5C21A5E9B29D2325")
    
public int getLength() {
        return list.size();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.592 -0400", hash_original_method = "756CB53FBCAB194F0AF49823E7E4B988", hash_generated_method = "AC57D5730166251D7D4B56C42B4B9ECF")
    
public Node item(int index) {
        Node result = null;
        try {
            result = list.get(index);
        } catch(IndexOutOfBoundsException ioobe) {
            // TODO log this event?
            return null;
        }

        return result;
    }
}
