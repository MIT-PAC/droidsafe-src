package org.apache.harmony.xml.dom;

// Droidsafe Imports
import droidsafe.annotations.*;
import org.w3c.dom.CDATASection;
import org.w3c.dom.Node;





public final class CDATASectionImpl extends TextImpl implements CDATASection {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.152 -0400", hash_original_method = "5E65B479C9B119188AACA9AAF7F8DB49", hash_generated_method = "1A78039048C07614470E05E8FED006FB")
    public  CDATASectionImpl(DocumentImpl document, String data) {
        super(document, data);
        addTaint(data.getTaint());
        addTaint(document.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.153 -0400", hash_original_method = "C06D7633E1EEC458B6238549761E1C34", hash_generated_method = "9B330AA48A181AB9AFD28AD158680420")
    @Override
    public String getNodeName() {
String varDC702726E92C9EDAE6B41AC7258DBE79_153369498 =         "#cdata-section";
        varDC702726E92C9EDAE6B41AC7258DBE79_153369498.addTaint(taint);
        return varDC702726E92C9EDAE6B41AC7258DBE79_153369498;
        // ---------- Original Method ----------
        //return "#cdata-section";
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.153 -0400", hash_original_method = "0AC4013C7F1EC92B6047139E15C869E6", hash_generated_method = "D193E5C6870F6E722F4EF9DBBAFBE061")
    @Override
    public short getNodeType() {
        short var7A791F8C11E21A5866817DB050CCE9AA_1166681278 = (Node.CDATA_SECTION_NODE);
                short var4F09DAA9D95BCB166A302407A0E0BABE_633644790 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_633644790;
        // ---------- Original Method ----------
        //return Node.CDATA_SECTION_NODE;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.154 -0400", hash_original_method = "17E369F2319E43AC424DA68053015181", hash_generated_method = "3145F77D0763E3B4440F781742E6BC2D")
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.155 -0400", hash_original_method = "8ED5C89F0345565DF7EFEC04369CA761", hash_generated_method = "9B506C6AF1DAA91064B6CCC5AA2B4983")
    public boolean needsSplitting() {
        boolean var1B1BFDAA00334AAAA6EC7386E974A758_2034587419 = (buffer.indexOf("]]>") != -1);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_506528247 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_506528247;
        // ---------- Original Method ----------
        //return buffer.indexOf("]]>") != -1;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.156 -0400", hash_original_method = "431D9E89C59292036E70F8C33A255325", hash_generated_method = "EEEAC75147763B81E058AE2313753179")
    public TextImpl replaceWithText() {
        TextImpl replacement = new TextImpl(document, getData());
        parent.insertBefore(replacement, this);
        parent.removeChild(this);
TextImpl varFD20299C8CAE1E4FF1821C470444358C_283732947 =         replacement;
        varFD20299C8CAE1E4FF1821C470444358C_283732947.addTaint(taint);
        return varFD20299C8CAE1E4FF1821C470444358C_283732947;
        // ---------- Original Method ----------
        //TextImpl replacement = new TextImpl(document, getData());
        //parent.insertBefore(replacement, this);
        //parent.removeChild(this);
        //return replacement;
    }

    
}

