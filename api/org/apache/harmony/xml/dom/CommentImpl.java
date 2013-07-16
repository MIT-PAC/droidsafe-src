package org.apache.harmony.xml.dom;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import org.w3c.dom.Comment;
import org.w3c.dom.Node;

public final class CommentImpl extends CharacterDataImpl implements Comment {
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.523 -0400", hash_original_method = "73927E77C0FC42AE226BC21B47EED77C", hash_generated_method = "86D6DE47A9846A97B5EBDE80FDEF8B9D")
      CommentImpl(DocumentImpl document, String data) {
        super(document, data);
        addTaint(data.getTaint());
        addTaint(document.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.523 -0400", hash_original_method = "AADC148D3C6535A85098796D78F74F64", hash_generated_method = "2C2A7A3856E5A11DD4E7229FB7488EAB")
    @Override
    public String getNodeName() {
String var0FCA15F9618B56275D1C4A63BF78C539_309308725 =         "#comment";
        var0FCA15F9618B56275D1C4A63BF78C539_309308725.addTaint(taint);
        return var0FCA15F9618B56275D1C4A63BF78C539_309308725;
        // ---------- Original Method ----------
        //return "#comment";
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.523 -0400", hash_original_method = "6EA19FED584EC66A374D4E0A8EF9DBF2", hash_generated_method = "50259F5153F5EC8228E24DECE8FDC179")
    @Override
    public short getNodeType() {
        short varA4E74D70413B819147AD685E420853A7_1172386027 = (Node.COMMENT_NODE);
                short var4F09DAA9D95BCB166A302407A0E0BABE_1806895100 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_1806895100;
        // ---------- Original Method ----------
        //return Node.COMMENT_NODE;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.524 -0400", hash_original_method = "F249C6EFBACF4B954D25B46FE7AAC81B", hash_generated_method = "672C4205D808FEA857686BDEDB190167")
    public boolean containsDashDash() {
        boolean varFCF615543A0352A82B69E2339E044D2C_1342863256 = (buffer.indexOf("--") != -1);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_504060264 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_504060264;
        // ---------- Original Method ----------
        //return buffer.indexOf("--") != -1;
    }

    
}

