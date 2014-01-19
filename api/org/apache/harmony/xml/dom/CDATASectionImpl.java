package org.apache.harmony.xml.dom;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import org.w3c.dom.CDATASection;
import org.w3c.dom.Node;

public final class CDATASectionImpl extends TextImpl implements CDATASection {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:21.183 -0500", hash_original_method = "5E65B479C9B119188AACA9AAF7F8DB49", hash_generated_method = "AFD3A50430ED1CA556A0611F53BAAA83")
    
public CDATASectionImpl(DocumentImpl document, String data) {
        super(document, data);
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:21.185 -0500", hash_original_method = "C06D7633E1EEC458B6238549761E1C34", hash_generated_method = "F321466C3A77A64D1617E37B79310E8A")
    
@Override
    public String getNodeName() {
        return "#cdata-section";
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:21.187 -0500", hash_original_method = "0AC4013C7F1EC92B6047139E15C869E6", hash_generated_method = "68DEE771A192EE03BAA5F3628D9AD8DB")
    
@Override
    public short getNodeType() {
        return Node.CDATA_SECTION_NODE;
    }

    /**
     * Splits this CDATA node into parts that do not contain a "]]>" sequence.
     * Any newly created nodes will be inserted before this node.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:21.190 -0500", hash_original_method = "17E369F2319E43AC424DA68053015181", hash_generated_method = "2CD6AE535FF35BFAB0DB87222EE51702")
    
public void split() {
        if (!needsSplitting()) {
            return;
        }

        Node parent = getParentNode();
        String[] parts = getData().split("\\]\\]>");
        parent.insertBefore(new CDATASectionImpl(document, parts[0] + "]]"), this);
        for (int p = 1; p < parts.length - 1; p++) {
            parent.insertBefore(new CDATASectionImpl(document, ">" + parts[p] + "]]"), this);
        }
        setData(">" + parts[parts.length - 1]);
    }

    /**
     * Returns true if this CDATA section contains the illegal character
     * sequence "]]>". Such nodes must be {@link #split} before they are
     * serialized.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:21.192 -0500", hash_original_method = "8ED5C89F0345565DF7EFEC04369CA761", hash_generated_method = "86C9291249D72BBE38FA1638A146F5CC")
    
public boolean needsSplitting() {
        return buffer.indexOf("]]>") != -1;
    }

    /**
     * Replaces this node with a semantically equivalent text node. This node
     * will be removed from the DOM tree and the new node inserted in its place.
     *
     * @return the replacement node.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:21.194 -0500", hash_original_method = "431D9E89C59292036E70F8C33A255325", hash_generated_method = "8840AADEBDBC53A80CA5D6B02730D49F")
    
public TextImpl replaceWithText() {
        TextImpl replacement = new TextImpl(document, getData());
        parent.insertBefore(replacement, this);
        parent.removeChild(this);
        return replacement;
    }
    
}

