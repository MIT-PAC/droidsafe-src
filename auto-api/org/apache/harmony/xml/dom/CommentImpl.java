package org.apache.harmony.xml.dom;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.w3c.dom.Comment;
import org.w3c.dom.Node;

public final class CommentImpl extends CharacterDataImpl implements Comment {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.674 -0400", hash_original_method = "73927E77C0FC42AE226BC21B47EED77C", hash_generated_method = "E50135C38E8B76B1E75935170D6E4282")
      CommentImpl(DocumentImpl document, String data) {
        super(document, data);
        addTaint(document.getTaint());
        addTaint(data.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.675 -0400", hash_original_method = "AADC148D3C6535A85098796D78F74F64", hash_generated_method = "B3BFB7CFB1274804574A04FC1199E3D8")
    @Override
    public String getNodeName() {
        String varB4EAC82CA7396A68D541C85D26508E83_107295933 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_107295933 = "#comment";
        varB4EAC82CA7396A68D541C85D26508E83_107295933.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_107295933;
        // ---------- Original Method ----------
        //return "#comment";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.675 -0400", hash_original_method = "6EA19FED584EC66A374D4E0A8EF9DBF2", hash_generated_method = "73A30669E83792DB1622C07E47DDA60B")
    @Override
    public short getNodeType() {
        short var4F09DAA9D95BCB166A302407A0E0BABE_877316496 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_877316496;
        // ---------- Original Method ----------
        //return Node.COMMENT_NODE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.676 -0400", hash_original_method = "F249C6EFBACF4B954D25B46FE7AAC81B", hash_generated_method = "6598FFB56F15CEB4DED717709BAA47EA")
    public boolean containsDashDash() {
        boolean var18A4D8D0DC7C2E71026BA16F766FE80C_1615580239 = (buffer.indexOf("--") != -1);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2032892253 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2032892253;
        // ---------- Original Method ----------
        //return buffer.indexOf("--") != -1;
    }

    
}

