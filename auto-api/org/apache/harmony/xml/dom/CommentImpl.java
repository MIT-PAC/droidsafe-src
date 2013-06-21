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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.128 -0400", hash_original_method = "73927E77C0FC42AE226BC21B47EED77C", hash_generated_method = "BA019A47368D695021B767EEC2099326")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     CommentImpl(DocumentImpl document, String data) {
        super(document, data);
        dsTaint.addTaint(document.dsTaint);
        dsTaint.addTaint(data);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.128 -0400", hash_original_method = "AADC148D3C6535A85098796D78F74F64", hash_generated_method = "38B559FD283F503B2AC280A66B8F5818")
    @DSModeled(DSC.SAFE)
    @Override
    public String getNodeName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "#comment";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.129 -0400", hash_original_method = "6EA19FED584EC66A374D4E0A8EF9DBF2", hash_generated_method = "040204273F1F1AFCDC9CBB382BAC4977")
    @DSModeled(DSC.SAFE)
    @Override
    public short getNodeType() {
        return dsTaint.getTaintShort();
        // ---------- Original Method ----------
        //return Node.COMMENT_NODE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.129 -0400", hash_original_method = "F249C6EFBACF4B954D25B46FE7AAC81B", hash_generated_method = "15C4B4E29FC6CCF3B802D4EE59AE8FA5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean containsDashDash() {
        boolean var18A4D8D0DC7C2E71026BA16F766FE80C_1888383201 = (buffer.indexOf("--") != -1);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return buffer.indexOf("--") != -1;
    }

    
}

