package org.apache.harmony.xml.dom;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import org.w3c.dom.Comment;
import org.w3c.dom.Node;





public final class CommentImpl extends CharacterDataImpl implements Comment {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:19.389 -0500", hash_original_method = "73927E77C0FC42AE226BC21B47EED77C", hash_generated_method = "73927E77C0FC42AE226BC21B47EED77C")
    
CommentImpl(DocumentImpl document, String data) {
        super(document, data);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:19.392 -0500", hash_original_method = "AADC148D3C6535A85098796D78F74F64", hash_generated_method = "65E9386289DC6D5E243C8CF492D402D2")
    
@Override
    public String getNodeName() {
        return "#comment";
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:19.394 -0500", hash_original_method = "6EA19FED584EC66A374D4E0A8EF9DBF2", hash_generated_method = "7B8239D5167E5C46B44D979DF3CD3C79")
    
@Override
    public short getNodeType() {
        return Node.COMMENT_NODE;
    }

    /**
     * Returns true if this comment contains the illegal character sequence
     * "--". Such nodes may not be serialized.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:19.396 -0500", hash_original_method = "F249C6EFBACF4B954D25B46FE7AAC81B", hash_generated_method = "0B59CD366EE309AB27F9B51BD9267691")
    
public boolean containsDashDash() {
        return buffer.indexOf("--") != -1;
    }

    
}

