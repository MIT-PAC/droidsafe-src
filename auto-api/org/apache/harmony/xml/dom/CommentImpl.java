package org.apache.harmony.xml.dom;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import org.w3c.dom.Comment;
import org.w3c.dom.Node;

public final class CommentImpl extends CharacterDataImpl implements Comment {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.791 -0400", hash_original_method = "73927E77C0FC42AE226BC21B47EED77C", hash_generated_method = "E50135C38E8B76B1E75935170D6E4282")
      CommentImpl(DocumentImpl document, String data) {
        super(document, data);
        addTaint(document.getTaint());
        addTaint(data.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.792 -0400", hash_original_method = "AADC148D3C6535A85098796D78F74F64", hash_generated_method = "93A5FB03C95B63580C433428875C0D9C")
    @Override
    public String getNodeName() {
        String varB4EAC82CA7396A68D541C85D26508E83_668398495 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_668398495 = "#comment";
        varB4EAC82CA7396A68D541C85D26508E83_668398495.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_668398495;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.792 -0400", hash_original_method = "6EA19FED584EC66A374D4E0A8EF9DBF2", hash_generated_method = "934192DF060BD505DCC20422B100FFFB")
    @Override
    public short getNodeType() {
        short var4F09DAA9D95BCB166A302407A0E0BABE_601040645 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_601040645;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.793 -0400", hash_original_method = "F249C6EFBACF4B954D25B46FE7AAC81B", hash_generated_method = "E2AAB83AF405C0D30D2457AFC65A8B6B")
    public boolean containsDashDash() {
        boolean var18A4D8D0DC7C2E71026BA16F766FE80C_1974474029 = (buffer.indexOf("--") != -1);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1795997687 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1795997687;
        
        
    }

    
}

