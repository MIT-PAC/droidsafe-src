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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.123 -0400", hash_original_method = "5E65B479C9B119188AACA9AAF7F8DB49", hash_generated_method = "593B7F66A2414249B1EF3E16B82C15DC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CDATASectionImpl(DocumentImpl document, String data) {
        super(document, data);
        dsTaint.addTaint(document.dsTaint);
        dsTaint.addTaint(data);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.123 -0400", hash_original_method = "C06D7633E1EEC458B6238549761E1C34", hash_generated_method = "8E85BC863CBC71F31E1CDA173F0E3A54")
    @DSModeled(DSC.SAFE)
    @Override
    public String getNodeName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "#cdata-section";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.123 -0400", hash_original_method = "0AC4013C7F1EC92B6047139E15C869E6", hash_generated_method = "458C9548ABC3F8CB5E2B46D96EFD13AF")
    @DSModeled(DSC.SAFE)
    @Override
    public short getNodeType() {
        return dsTaint.getTaintShort();
        // ---------- Original Method ----------
        //return Node.CDATA_SECTION_NODE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.124 -0400", hash_original_method = "17E369F2319E43AC424DA68053015181", hash_generated_method = "9B99D5B07CF08B4057D2E00F83FBEDAE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void split() {
        {
            boolean varB00DB3B45A8833AEC0F6C9057C63EFCC_1572463231 = (!needsSplitting());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.124 -0400", hash_original_method = "8ED5C89F0345565DF7EFEC04369CA761", hash_generated_method = "DE6558FE3BF383B4BBC43A159C63AB00")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean needsSplitting() {
        boolean var76922E628753273615C1BB4E85B1DFCB_1132361323 = (buffer.indexOf("]]>") != -1);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return buffer.indexOf("]]>") != -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.124 -0400", hash_original_method = "431D9E89C59292036E70F8C33A255325", hash_generated_method = "FB3AE32C8274C94D00F31A21A4C0FB8C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public TextImpl replaceWithText() {
        TextImpl replacement;
        replacement = new TextImpl(document, getData());
        parent.insertBefore(replacement, this);
        parent.removeChild(this);
        return (TextImpl)dsTaint.getTaint();
        // ---------- Original Method ----------
        //TextImpl replacement = new TextImpl(document, getData());
        //parent.insertBefore(replacement, this);
        //parent.removeChild(this);
        //return replacement;
    }

    
}

