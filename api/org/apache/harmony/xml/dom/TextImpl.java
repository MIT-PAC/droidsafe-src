package org.apache.harmony.xml.dom;

// Droidsafe Imports
import droidsafe.annotations.*;
import org.w3c.dom.DOMException;
import org.w3c.dom.Node;
import org.w3c.dom.Text;





public class TextImpl extends CharacterDataImpl implements Text {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.709 -0400", hash_original_method = "8FBFCF7E900515A865ACF1E6532A7BB4", hash_generated_method = "DDA698DE5625F3952C79CAC3D7CFF209")
    public  TextImpl(DocumentImpl document, String data) {
        super(document, data);
        addTaint(data.getTaint());
        addTaint(document.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.709 -0400", hash_original_method = "F5AD87001A4CE84E4D3D0566BEEE7118", hash_generated_method = "0FCE8F29A533432CBD40A892BA2DF32A")
    @Override
    public String getNodeName() {
String var479BE8C6ABF395546FF8B94D5B3DB44D_1371811128 =         "#text";
        var479BE8C6ABF395546FF8B94D5B3DB44D_1371811128.addTaint(taint);
        return var479BE8C6ABF395546FF8B94D5B3DB44D_1371811128;
        // ---------- Original Method ----------
        //return "#text";
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.709 -0400", hash_original_method = "C38FDDE6CC592E744EE6602E5FF8812E", hash_generated_method = "6DD893F6BC32E89F9E52AEC055634CF5")
    @Override
    public short getNodeType() {
        short var342655E618A3A8BC65F7B1BD4EFE2ADE_1930453610 = (Node.TEXT_NODE);
                short var4F09DAA9D95BCB166A302407A0E0BABE_1347621826 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_1347621826;
        // ---------- Original Method ----------
        //return Node.TEXT_NODE;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.710 -0400", hash_original_method = "F2223FE614407E591CCAD60B04318A19", hash_generated_method = "F763414D8F1C4B75B81EC0BF8CF40465")
    public final Text splitText(int offset) throws DOMException {
        addTaint(offset);
        Text newText = document.createTextNode(
                substringData(offset, getLength() - offset));
        deleteData(0, offset);
        Node refNode = getNextSibling();
        if(refNode == null)        
        {
            getParentNode().appendChild(newText);
        } //End block
        else
        {
            getParentNode().insertBefore(newText, refNode);
        } //End block
Text var72A74007B2BE62B849F475C7BDA4658B_605658270 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_605658270.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_605658270;
        // ---------- Original Method ----------
        //Text newText = document.createTextNode(
                //substringData(offset, getLength() - offset));
        //deleteData(0, offset);
        //Node refNode = getNextSibling();
        //if (refNode == null) {
            //getParentNode().appendChild(newText);
        //} else {
            //getParentNode().insertBefore(newText, refNode);
        //}
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.710 -0400", hash_original_method = "E52052CEEE0E5966B25CAA49C3A5CE28", hash_generated_method = "3E081EF5EA560856598576CF1D76FF68")
    public final boolean isElementContentWhitespace() {
        boolean var68934A3E9455FA72420237EB05902327_259650880 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1670233246 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1670233246;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.711 -0400", hash_original_method = "9EC887BD47A703F2DBB656ECC04AC254", hash_generated_method = "D53034338FC964F94B725337A5D57F34")
    public final String getWholeText() {
        StringBuilder result = new StringBuilder();
for(TextImpl n = firstTextNodeInCurrentRun();n != null;n = n.nextTextNode())
        {
            n.appendDataTo(result);
        } //End block
String varE65B3A02759122992CB82C0E651AD408_816196226 =         result.toString();
        varE65B3A02759122992CB82C0E651AD408_816196226.addTaint(taint);
        return varE65B3A02759122992CB82C0E651AD408_816196226;
        // ---------- Original Method ----------
        //StringBuilder result = new StringBuilder();
        //for (TextImpl n = firstTextNodeInCurrentRun(); n != null; n = n.nextTextNode()) {
            //n.appendDataTo(result);
        //}
        //return result.toString();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.711 -0400", hash_original_method = "F1D9E0F93EC220C6C7713D2F10A5FC3E", hash_generated_method = "29C30504B43D70999B0BD14B71A4CE35")
    public final Text replaceWholeText(String content) throws DOMException {
        addTaint(content.getTaint());
        Node parent = getParentNode();
        Text result = null;
for(TextImpl n = firstTextNodeInCurrentRun();n != null;)
        {
            if(n == this && content != null && content.length() > 0)            
            {
                setData(content);
                result = this;
                n = n.nextTextNode();
            } //End block
            else
            {
                Node toRemove = n;
                n = n.nextTextNode();
                parent.removeChild(toRemove);
            } //End block
        } //End block
Text varDC838461EE2FA0CA4C9BBB70A15456B0_768671805 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_768671805.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_768671805;
        // ---------- Original Method ----------
        //Node parent = getParentNode();
        //Text result = null;
        //for (TextImpl n = firstTextNodeInCurrentRun(); n != null; ) {
            //if (n == this && content != null && content.length() > 0) {
                //setData(content);
                //result = this;
                //n = n.nextTextNode();
            //} else {
                //Node toRemove = n; 
                //n = n.nextTextNode();
                //parent.removeChild(toRemove);
            //}
        //}
        //return result;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.712 -0400", hash_original_method = "9928E14A90ED22F7792AF824C555C38E", hash_generated_method = "0CBA2B4799D69800D7690A8E15929938")
    private TextImpl firstTextNodeInCurrentRun() {
        TextImpl firstTextInCurrentRun = this;
for(Node p = getPreviousSibling();p != null;p = p.getPreviousSibling())
        {
            short nodeType = p.getNodeType();
            if(nodeType == Node.TEXT_NODE || nodeType == Node.CDATA_SECTION_NODE)            
            {
                firstTextInCurrentRun = (TextImpl) p;
            } //End block
            else
            {
                break;
            } //End block
        } //End block
TextImpl var0029222DF1606034C9ECFB713BE58214_319112207 =         firstTextInCurrentRun;
        var0029222DF1606034C9ECFB713BE58214_319112207.addTaint(taint);
        return var0029222DF1606034C9ECFB713BE58214_319112207;
        // ---------- Original Method ----------
        //TextImpl firstTextInCurrentRun = this;
        //for (Node p = getPreviousSibling(); p != null; p = p.getPreviousSibling()) {
            //short nodeType = p.getNodeType();
            //if (nodeType == Node.TEXT_NODE || nodeType == Node.CDATA_SECTION_NODE) {
                //firstTextInCurrentRun = (TextImpl) p;
            //} else {
                //break;
            //}
        //}
        //return firstTextInCurrentRun;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.712 -0400", hash_original_method = "E11C938286265122BF52D51A5CD9EED3", hash_generated_method = "53A392CD9624372A3D6D566D252765CB")
    private TextImpl nextTextNode() {
        Node nextSibling = getNextSibling();
        if(nextSibling == null)        
        {
TextImpl var540C13E9E156B687226421B24F2DF178_2111871935 =             null;
            var540C13E9E156B687226421B24F2DF178_2111871935.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_2111871935;
        } //End block
        short nodeType = nextSibling.getNodeType();
TextImpl var035B60A3C8E68711360148642E80CAF6_1466236922 =         nodeType == Node.TEXT_NODE || nodeType == Node.CDATA_SECTION_NODE
                ? (TextImpl) nextSibling
                : null;
        var035B60A3C8E68711360148642E80CAF6_1466236922.addTaint(taint);
        return var035B60A3C8E68711360148642E80CAF6_1466236922;
        // ---------- Original Method ----------
        //Node nextSibling = getNextSibling();
        //if (nextSibling == null) {
            //return null;
        //}
        //short nodeType = nextSibling.getNodeType();
        //return nodeType == Node.TEXT_NODE || nodeType == Node.CDATA_SECTION_NODE
                //? (TextImpl) nextSibling
                //: null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.713 -0400", hash_original_method = "C12D207E9524D7914DF3EC77CD8084EB", hash_generated_method = "74C542C23714AB1FF92D9C0D1EDD5B5D")
    public final TextImpl minimize() {
        if(getLength() == 0)        
        {
            parent.removeChild(this);
TextImpl var540C13E9E156B687226421B24F2DF178_251419619 =             null;
            var540C13E9E156B687226421B24F2DF178_251419619.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_251419619;
        } //End block
        Node previous = getPreviousSibling();
        if(previous == null || previous.getNodeType() != Node.TEXT_NODE)        
        {
TextImpl var72A74007B2BE62B849F475C7BDA4658B_968862086 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_968862086.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_968862086;
        } //End block
        TextImpl previousText = (TextImpl) previous;
        previousText.buffer.append(buffer);
        parent.removeChild(this);
TextImpl varC48E273F6CD7E4BAAF96F602624F7212_193017641 =         previousText;
        varC48E273F6CD7E4BAAF96F602624F7212_193017641.addTaint(taint);
        return varC48E273F6CD7E4BAAF96F602624F7212_193017641;
        // ---------- Original Method ----------
        //if (getLength() == 0) {
            //parent.removeChild(this);
            //return null;
        //}
        //Node previous = getPreviousSibling();
        //if (previous == null || previous.getNodeType() != Node.TEXT_NODE) {
            //return this;
        //}
        //TextImpl previousText = (TextImpl) previous;
        //previousText.buffer.append(buffer);
        //parent.removeChild(this);
        //return previousText;
    }

    
}

