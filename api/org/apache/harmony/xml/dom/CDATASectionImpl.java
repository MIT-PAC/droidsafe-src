package org.apache.harmony.xml.dom;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import org.w3c.dom.CDATASection;
import org.w3c.dom.Node;

public final class CDATASectionImpl extends TextImpl implements CDATASection {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.509 -0400", hash_original_method = "5E65B479C9B119188AACA9AAF7F8DB49", hash_generated_method = "1A78039048C07614470E05E8FED006FB")
    public  CDATASectionImpl(DocumentImpl document, String data) {
        super(document, data);
        addTaint(data.getTaint());
        addTaint(document.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.510 -0400", hash_original_method = "C06D7633E1EEC458B6238549761E1C34", hash_generated_method = "6ECC0879E49582070FD688E0593245A8")
    @Override
    public String getNodeName() {
String varDC702726E92C9EDAE6B41AC7258DBE79_526653206 =         "#cdata-section";
        varDC702726E92C9EDAE6B41AC7258DBE79_526653206.addTaint(taint);
        return varDC702726E92C9EDAE6B41AC7258DBE79_526653206;
        // ---------- Original Method ----------
        //return "#cdata-section";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.510 -0400", hash_original_method = "0AC4013C7F1EC92B6047139E15C869E6", hash_generated_method = "D21A7E977A319879C3D173BA902AF83B")
    @Override
    public short getNodeType() {
        short var7A791F8C11E21A5866817DB050CCE9AA_335377968 = (Node.CDATA_SECTION_NODE);
                short var4F09DAA9D95BCB166A302407A0E0BABE_503209228 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_503209228;
        // ---------- Original Method ----------
        //return Node.CDATA_SECTION_NODE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.511 -0400", hash_original_method = "17E369F2319E43AC424DA68053015181", hash_generated_method = "3145F77D0763E3B4440F781742E6BC2D")
    public void split() {
    if(!needsSplitting())        
        {
            return;
        } //End block
        Node parent = getParentNode();
        String[] parts = getData().split("\\]\\]>");
        parent.insertBefore(new CDATASectionImpl(document, parts[0] + "]]"), this);
for(int p = 1;p < parts.length - 1;p++)
        {
            parent.insertBefore(new CDATASectionImpl(document, ">" + parts[p] + "]]"), this);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.511 -0400", hash_original_method = "8ED5C89F0345565DF7EFEC04369CA761", hash_generated_method = "4A5DFDEBEE1CEF79821860C3CA4DB2F1")
    public boolean needsSplitting() {
        boolean var1B1BFDAA00334AAAA6EC7386E974A758_2080206934 = (buffer.indexOf("]]>") != -1);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1423444641 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1423444641;
        // ---------- Original Method ----------
        //return buffer.indexOf("]]>") != -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.511 -0400", hash_original_method = "431D9E89C59292036E70F8C33A255325", hash_generated_method = "980A703E7FDC1851779C2BC55E8D3B58")
    public TextImpl replaceWithText() {
        TextImpl replacement = new TextImpl(document, getData());
        parent.insertBefore(replacement, this);
        parent.removeChild(this);
TextImpl varFD20299C8CAE1E4FF1821C470444358C_1532300139 =         replacement;
        varFD20299C8CAE1E4FF1821C470444358C_1532300139.addTaint(taint);
        return varFD20299C8CAE1E4FF1821C470444358C_1532300139;
        // ---------- Original Method ----------
        //TextImpl replacement = new TextImpl(document, getData());
        //parent.insertBefore(replacement, this);
        //parent.removeChild(this);
        //return replacement;
    }

    
}

