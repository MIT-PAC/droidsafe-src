package org.apache.harmony.xml.dom;

// Droidsafe Imports
import droidsafe.annotations.*;
import org.w3c.dom.Comment;
import org.w3c.dom.Node;





public final class CommentImpl extends CharacterDataImpl implements Comment {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.182 -0400", hash_original_method = "73927E77C0FC42AE226BC21B47EED77C", hash_generated_method = "86D6DE47A9846A97B5EBDE80FDEF8B9D")
      CommentImpl(DocumentImpl document, String data) {
        super(document, data);
        addTaint(data.getTaint());
        addTaint(document.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.182 -0400", hash_original_method = "AADC148D3C6535A85098796D78F74F64", hash_generated_method = "C54BC427D0BCE35222764A109078871F")
    @Override
    public String getNodeName() {
String var0FCA15F9618B56275D1C4A63BF78C539_1256289694 =         "#comment";
        var0FCA15F9618B56275D1C4A63BF78C539_1256289694.addTaint(taint);
        return var0FCA15F9618B56275D1C4A63BF78C539_1256289694;
        // ---------- Original Method ----------
        //return "#comment";
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.183 -0400", hash_original_method = "6EA19FED584EC66A374D4E0A8EF9DBF2", hash_generated_method = "CA327BC99D0389D76D54A3F35FFDF59C")
    @Override
    public short getNodeType() {
        short varA4E74D70413B819147AD685E420853A7_2114033673 = (Node.COMMENT_NODE);
                short var4F09DAA9D95BCB166A302407A0E0BABE_423785582 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_423785582;
        // ---------- Original Method ----------
        //return Node.COMMENT_NODE;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.183 -0400", hash_original_method = "F249C6EFBACF4B954D25B46FE7AAC81B", hash_generated_method = "F73EBE1CDDC44FF9A514BD59CFA8F755")
    public boolean containsDashDash() {
        boolean varFCF615543A0352A82B69E2339E044D2C_1150698941 = (buffer.indexOf("--") != -1);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_401986903 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_401986903;
        // ---------- Original Method ----------
        //return buffer.indexOf("--") != -1;
    }

    
}

