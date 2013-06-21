package org.apache.harmony.xml.dom;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.w3c.dom.DOMException;
import org.w3c.dom.Node;
import org.w3c.dom.Text;

public class TextImpl extends CharacterDataImpl implements Text {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.454 -0400", hash_original_method = "8FBFCF7E900515A865ACF1E6532A7BB4", hash_generated_method = "1F89A6149E2978006F5FFE5D64D9BB55")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public TextImpl(DocumentImpl document, String data) {
        super(document, data);
        dsTaint.addTaint(document.dsTaint);
        dsTaint.addTaint(data);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.454 -0400", hash_original_method = "F5AD87001A4CE84E4D3D0566BEEE7118", hash_generated_method = "DF2406DC3D2BE362FA8F719FDA3771E8")
    @DSModeled(DSC.SAFE)
    @Override
    public String getNodeName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "#text";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.454 -0400", hash_original_method = "C38FDDE6CC592E744EE6602E5FF8812E", hash_generated_method = "2FC9E0DDFD937E7A9EC45E04D4C28DE9")
    @DSModeled(DSC.SAFE)
    @Override
    public short getNodeType() {
        return dsTaint.getTaintShort();
        // ---------- Original Method ----------
        //return Node.TEXT_NODE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.455 -0400", hash_original_method = "F2223FE614407E591CCAD60B04318A19", hash_generated_method = "F2C2AF3D2F8E9024DB776B641DFB2454")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final Text splitText(int offset) throws DOMException {
        dsTaint.addTaint(offset);
        Text newText;
        newText = document.createTextNode(
                substringData(offset, getLength() - offset));
        deleteData(0, offset);
        Node refNode;
        refNode = getNextSibling();
        {
            getParentNode().appendChild(newText);
        } //End block
        {
            getParentNode().insertBefore(newText, refNode);
        } //End block
        return (Text)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.455 -0400", hash_original_method = "E52052CEEE0E5966B25CAA49C3A5CE28", hash_generated_method = "45364038A9B3972617B9067F9C8F683D")
    @DSModeled(DSC.SAFE)
    public final boolean isElementContentWhitespace() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.457 -0400", hash_original_method = "9EC887BD47A703F2DBB656ECC04AC254", hash_generated_method = "684CA66AD166F26C95967C8C2711FD3F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final String getWholeText() {
        StringBuilder result;
        result = new StringBuilder();
        {
            TextImpl n;
            n = firstTextNodeInCurrentRun();
            n = n.nextTextNode();
            {
                n.appendDataTo(result);
            } //End block
        } //End collapsed parenthetic
        String varEA70154FDA28CC59402440C6317B57EF_26817342 = (result.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //StringBuilder result = new StringBuilder();
        //for (TextImpl n = firstTextNodeInCurrentRun(); n != null; n = n.nextTextNode()) {
            //n.appendDataTo(result);
        //}
        //return result.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.457 -0400", hash_original_method = "F1D9E0F93EC220C6C7713D2F10A5FC3E", hash_generated_method = "68106D89C36E261E528C06FFC7726A55")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final Text replaceWholeText(String content) throws DOMException {
        dsTaint.addTaint(content);
        Node parent;
        parent = getParentNode();
        Text result;
        result = null;
        {
            TextImpl n;
            n = firstTextNodeInCurrentRun();
            {
                {
                    boolean var0831F1DFD766B141B2DAE9EBB226A597_479031292 = (n == this && content != null && content.length() > 0);
                    {
                        setData(content);
                        result = this;
                        n = n.nextTextNode();
                    } //End block
                    {
                        Node toRemove;
                        toRemove = n;
                        n = n.nextTextNode();
                        parent.removeChild(toRemove);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return (Text)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.458 -0400", hash_original_method = "9928E14A90ED22F7792AF824C555C38E", hash_generated_method = "8401097A59BCCA488B5C56168734AFC3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private TextImpl firstTextNodeInCurrentRun() {
        TextImpl firstTextInCurrentRun;
        firstTextInCurrentRun = this;
        {
            Node p;
            p = getPreviousSibling();
            p = p.getPreviousSibling();
            {
                short nodeType;
                nodeType = p.getNodeType();
                {
                    firstTextInCurrentRun = (TextImpl) p;
                } //End block
            } //End block
        } //End collapsed parenthetic
        return (TextImpl)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.458 -0400", hash_original_method = "E11C938286265122BF52D51A5CD9EED3", hash_generated_method = "C26FF70E49DFCFB61156B08F56DE557B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private TextImpl nextTextNode() {
        Node nextSibling;
        nextSibling = getNextSibling();
        short nodeType;
        nodeType = nextSibling.getNodeType();
        return (TextImpl)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.459 -0400", hash_original_method = "C12D207E9524D7914DF3EC77CD8084EB", hash_generated_method = "21DAC9B0B65E7E493CD6E773C314F892")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final TextImpl minimize() {
        {
            boolean varB0D0CE9333EA8221AF0697B62A1B4A5C_713466076 = (getLength() == 0);
            {
                parent.removeChild(this);
            } //End block
        } //End collapsed parenthetic
        Node previous;
        previous = getPreviousSibling();
        {
            boolean var4A5BF3CA70F2129AF0CB018F3C4F2317_701117269 = (previous == null || previous.getNodeType() != Node.TEXT_NODE);
        } //End collapsed parenthetic
        TextImpl previousText;
        previousText = (TextImpl) previous;
        previousText.buffer.append(buffer);
        parent.removeChild(this);
        return (TextImpl)dsTaint.getTaint();
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

