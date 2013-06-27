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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.495 -0400", hash_original_method = "73927E77C0FC42AE226BC21B47EED77C", hash_generated_method = "E50135C38E8B76B1E75935170D6E4282")
      CommentImpl(DocumentImpl document, String data) {
        super(document, data);
        addTaint(document.getTaint());
        addTaint(data.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.496 -0400", hash_original_method = "AADC148D3C6535A85098796D78F74F64", hash_generated_method = "D11A6E8E8F631ED9FEE8D2F12B6A98B1")
    @Override
    public String getNodeName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1326514771 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1326514771 = "#comment";
        varB4EAC82CA7396A68D541C85D26508E83_1326514771.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1326514771;
        // ---------- Original Method ----------
        //return "#comment";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.496 -0400", hash_original_method = "6EA19FED584EC66A374D4E0A8EF9DBF2", hash_generated_method = "EC1708A54C92A0FF1A31841AE4C7950A")
    @Override
    public short getNodeType() {
        short var4F09DAA9D95BCB166A302407A0E0BABE_692739606 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_692739606;
        // ---------- Original Method ----------
        //return Node.COMMENT_NODE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.496 -0400", hash_original_method = "F249C6EFBACF4B954D25B46FE7AAC81B", hash_generated_method = "266A97220B805EA8B6A8F22DF0DF0A48")
    public boolean containsDashDash() {
        boolean var18A4D8D0DC7C2E71026BA16F766FE80C_533958128 = (buffer.indexOf("--") != -1);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1512979699 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1512979699;
        // ---------- Original Method ----------
        //return buffer.indexOf("--") != -1;
    }

    
}

