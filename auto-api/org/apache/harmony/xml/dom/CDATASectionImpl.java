package org.apache.harmony.xml.dom;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.w3c.dom.CDATASection;
import org.w3c.dom.Node;

public final class CDATASectionImpl extends TextImpl implements CDATASection {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.471 -0400", hash_original_method = "5E65B479C9B119188AACA9AAF7F8DB49", hash_generated_method = "54F3175018593ACF08C662E302F9DEAF")
    public  CDATASectionImpl(DocumentImpl document, String data) {
        super(document, data);
        addTaint(document.getTaint());
        addTaint(data.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.474 -0400", hash_original_method = "C06D7633E1EEC458B6238549761E1C34", hash_generated_method = "1149161439ECF2937797FF62A33DE302")
    @Override
    public String getNodeName() {
        String varB4EAC82CA7396A68D541C85D26508E83_493334434 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_493334434 = "#cdata-section";
        varB4EAC82CA7396A68D541C85D26508E83_493334434.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_493334434;
        // ---------- Original Method ----------
        //return "#cdata-section";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.475 -0400", hash_original_method = "0AC4013C7F1EC92B6047139E15C869E6", hash_generated_method = "65B4D1BA89A5A0E68CA3F7DDC7855566")
    @Override
    public short getNodeType() {
        short var4F09DAA9D95BCB166A302407A0E0BABE_492259809 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_492259809;
        // ---------- Original Method ----------
        //return Node.CDATA_SECTION_NODE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.475 -0400", hash_original_method = "17E369F2319E43AC424DA68053015181", hash_generated_method = "B26F1763E93DA8A5729EA5A294B11E1C")
    public void split() {
        {
            boolean varB00DB3B45A8833AEC0F6C9057C63EFCC_1767706162 = (!needsSplitting());
        } //End collapsed parenthetic
        Node parent;
        parent = getParentNode();
        String[] parts;
        parts = getData().split("\\]\\]>");
        parent.insertBefore(new CDATASectionImpl(document, parts[0] + "]]"), this);
        {
            int p;
            p = 1;
            {
                parent.insertBefore(new CDATASectionImpl(document, ">" + parts[p] + "]]"), this);
            } //End block
        } //End collapsed parenthetic
        setData(">" + parts[parts.length - 1]);
        // ---------- Original Method ----------
        //if (!needsSplitting()) {
            //return;
        //}
        //Node parent = getParentNode();
        //String[] parts = getData().split("\\]\\]>");
        //parent.insertBefore(new CDATASectionImpl(document, parts[0] + "]]"), this);
        //for (int p = 1; p < parts.length - 1; p++) {
            //parent.insertBefore(new CDATASectionImpl(document, ">" + parts[p] + "]]"), this);
        //}
        //setData(">" + parts[parts.length - 1]);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.476 -0400", hash_original_method = "8ED5C89F0345565DF7EFEC04369CA761", hash_generated_method = "A39E4314DAA7F80320AD46206CA4EB56")
    public boolean needsSplitting() {
        boolean var76922E628753273615C1BB4E85B1DFCB_2144045811 = (buffer.indexOf("]]>") != -1);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1013979571 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1013979571;
        // ---------- Original Method ----------
        //return buffer.indexOf("]]>") != -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.477 -0400", hash_original_method = "431D9E89C59292036E70F8C33A255325", hash_generated_method = "2F0D2005007AA620847EB0CF92BC877F")
    public TextImpl replaceWithText() {
        TextImpl varB4EAC82CA7396A68D541C85D26508E83_225375912 = null; //Variable for return #1
        TextImpl replacement;
        replacement = new TextImpl(document, getData());
        parent.insertBefore(replacement, this);
        parent.removeChild(this);
        varB4EAC82CA7396A68D541C85D26508E83_225375912 = replacement;
        varB4EAC82CA7396A68D541C85D26508E83_225375912.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_225375912;
        // ---------- Original Method ----------
        //TextImpl replacement = new TextImpl(document, getData());
        //parent.insertBefore(replacement, this);
        //parent.removeChild(this);
        //return replacement;
    }

    
}

