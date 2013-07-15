package org.apache.harmony.xml.dom;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import org.w3c.dom.DOMException;
import org.w3c.dom.Node;
import org.w3c.dom.Text;

public class TextImpl extends CharacterDataImpl implements Text {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.961 -0400", hash_original_method = "8FBFCF7E900515A865ACF1E6532A7BB4", hash_generated_method = "DDA698DE5625F3952C79CAC3D7CFF209")
    public  TextImpl(DocumentImpl document, String data) {
        super(document, data);
        addTaint(data.getTaint());
        addTaint(document.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.961 -0400", hash_original_method = "F5AD87001A4CE84E4D3D0566BEEE7118", hash_generated_method = "44743743CA6F6A90DC5D6BAFDEA2589A")
    @Override
    public String getNodeName() {
String var479BE8C6ABF395546FF8B94D5B3DB44D_276893398 =         "#text";
        var479BE8C6ABF395546FF8B94D5B3DB44D_276893398.addTaint(taint);
        return var479BE8C6ABF395546FF8B94D5B3DB44D_276893398;
        // ---------- Original Method ----------
        //return "#text";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.962 -0400", hash_original_method = "C38FDDE6CC592E744EE6602E5FF8812E", hash_generated_method = "73B872AA46B7287007C3E5D1D5DE7B7F")
    @Override
    public short getNodeType() {
        short var342655E618A3A8BC65F7B1BD4EFE2ADE_968947024 = (Node.TEXT_NODE);
                short var4F09DAA9D95BCB166A302407A0E0BABE_552369272 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_552369272;
        // ---------- Original Method ----------
        //return Node.TEXT_NODE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.962 -0400", hash_original_method = "F2223FE614407E591CCAD60B04318A19", hash_generated_method = "BF24CFAC3BB2DB1F8422A0463938B5BC")
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
Text var72A74007B2BE62B849F475C7BDA4658B_2046536736 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_2046536736.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_2046536736;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.962 -0400", hash_original_method = "E52052CEEE0E5966B25CAA49C3A5CE28", hash_generated_method = "16F778D0BC9D9FF5AA8E6699B63691DC")
    public final boolean isElementContentWhitespace() {
        boolean var68934A3E9455FA72420237EB05902327_940384405 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1494299465 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1494299465;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.963 -0400", hash_original_method = "9EC887BD47A703F2DBB656ECC04AC254", hash_generated_method = "362F69279B45AA0E01160579B025E946")
    public final String getWholeText() {
        StringBuilder result = new StringBuilder();
for(TextImpl n = firstTextNodeInCurrentRun();n != null;n = n.nextTextNode())
        {
            n.appendDataTo(result);
        } //End block
String varE65B3A02759122992CB82C0E651AD408_1602729226 =         result.toString();
        varE65B3A02759122992CB82C0E651AD408_1602729226.addTaint(taint);
        return varE65B3A02759122992CB82C0E651AD408_1602729226;
        // ---------- Original Method ----------
        //StringBuilder result = new StringBuilder();
        //for (TextImpl n = firstTextNodeInCurrentRun(); n != null; n = n.nextTextNode()) {
            //n.appendDataTo(result);
        //}
        //return result.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.964 -0400", hash_original_method = "F1D9E0F93EC220C6C7713D2F10A5FC3E", hash_generated_method = "2CE31E619EB2F2AEA9C63E50D6909662")
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
Text varDC838461EE2FA0CA4C9BBB70A15456B0_998910394 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_998910394.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_998910394;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.964 -0400", hash_original_method = "9928E14A90ED22F7792AF824C555C38E", hash_generated_method = "436B1606C96BC16B17B1885505756984")
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
TextImpl var0029222DF1606034C9ECFB713BE58214_1658712362 =         firstTextInCurrentRun;
        var0029222DF1606034C9ECFB713BE58214_1658712362.addTaint(taint);
        return var0029222DF1606034C9ECFB713BE58214_1658712362;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.965 -0400", hash_original_method = "E11C938286265122BF52D51A5CD9EED3", hash_generated_method = "033F89523305485014B3D97BA3CB8EEA")
    private TextImpl nextTextNode() {
        Node nextSibling = getNextSibling();
    if(nextSibling == null)        
        {
TextImpl var540C13E9E156B687226421B24F2DF178_286422226 =             null;
            var540C13E9E156B687226421B24F2DF178_286422226.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_286422226;
        } //End block
        short nodeType = nextSibling.getNodeType();
TextImpl var035B60A3C8E68711360148642E80CAF6_655998355 =         nodeType == Node.TEXT_NODE || nodeType == Node.CDATA_SECTION_NODE
                ? (TextImpl) nextSibling
                : null;
        var035B60A3C8E68711360148642E80CAF6_655998355.addTaint(taint);
        return var035B60A3C8E68711360148642E80CAF6_655998355;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.965 -0400", hash_original_method = "C12D207E9524D7914DF3EC77CD8084EB", hash_generated_method = "ECF9BDE745A04A61C7ABE0C7FF6F4CEA")
    public final TextImpl minimize() {
    if(getLength() == 0)        
        {
            parent.removeChild(this);
TextImpl var540C13E9E156B687226421B24F2DF178_710366427 =             null;
            var540C13E9E156B687226421B24F2DF178_710366427.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_710366427;
        } //End block
        Node previous = getPreviousSibling();
    if(previous == null || previous.getNodeType() != Node.TEXT_NODE)        
        {
TextImpl var72A74007B2BE62B849F475C7BDA4658B_1670977356 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1670977356.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1670977356;
        } //End block
        TextImpl previousText = (TextImpl) previous;
        previousText.buffer.append(buffer);
        parent.removeChild(this);
TextImpl varC48E273F6CD7E4BAAF96F602624F7212_585994815 =         previousText;
        varC48E273F6CD7E4BAAF96F602624F7212_585994815.addTaint(taint);
        return varC48E273F6CD7E4BAAF96F602624F7212_585994815;
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

