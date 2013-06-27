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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.092 -0400", hash_original_method = "8FBFCF7E900515A865ACF1E6532A7BB4", hash_generated_method = "778826811E83592E50B2C9B824F4A820")
    public  TextImpl(DocumentImpl document, String data) {
        super(document, data);
        addTaint(document.getTaint());
        addTaint(data.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.108 -0400", hash_original_method = "F5AD87001A4CE84E4D3D0566BEEE7118", hash_generated_method = "F7763DDAC44777F053CCCD9A1226A897")
    @Override
    public String getNodeName() {
        String varB4EAC82CA7396A68D541C85D26508E83_465453322 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_465453322 = "#text";
        varB4EAC82CA7396A68D541C85D26508E83_465453322.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_465453322;
        // ---------- Original Method ----------
        //return "#text";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.109 -0400", hash_original_method = "C38FDDE6CC592E744EE6602E5FF8812E", hash_generated_method = "5C1B07D7E4B8D1E93F7264D21D0B0E02")
    @Override
    public short getNodeType() {
        short var4F09DAA9D95BCB166A302407A0E0BABE_1998622303 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_1998622303;
        // ---------- Original Method ----------
        //return Node.TEXT_NODE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.109 -0400", hash_original_method = "F2223FE614407E591CCAD60B04318A19", hash_generated_method = "8EBD77D3AC6B4C5A4481DEFA65981B41")
    public final Text splitText(int offset) throws DOMException {
        Text varB4EAC82CA7396A68D541C85D26508E83_1690352770 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_1690352770 = this;
        addTaint(offset);
        varB4EAC82CA7396A68D541C85D26508E83_1690352770.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1690352770;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.110 -0400", hash_original_method = "E52052CEEE0E5966B25CAA49C3A5CE28", hash_generated_method = "39F9C8DE6B13313F53A8650447EA9978")
    public final boolean isElementContentWhitespace() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_62572003 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_62572003;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.115 -0400", hash_original_method = "9EC887BD47A703F2DBB656ECC04AC254", hash_generated_method = "50309C9EE62AAC9B466B6D0FF63BCB94")
    public final String getWholeText() {
        String varB4EAC82CA7396A68D541C85D26508E83_13217543 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_13217543 = result.toString();
        varB4EAC82CA7396A68D541C85D26508E83_13217543.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_13217543;
        // ---------- Original Method ----------
        //StringBuilder result = new StringBuilder();
        //for (TextImpl n = firstTextNodeInCurrentRun(); n != null; n = n.nextTextNode()) {
            //n.appendDataTo(result);
        //}
        //return result.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.116 -0400", hash_original_method = "F1D9E0F93EC220C6C7713D2F10A5FC3E", hash_generated_method = "EF19B481621DD0DE838E93C07EB80549")
    public final Text replaceWholeText(String content) throws DOMException {
        Text varB4EAC82CA7396A68D541C85D26508E83_588494801 = null; //Variable for return #1
        Node parent;
        parent = getParentNode();
        Text result;
        result = null;
        {
            TextImpl n;
            n = firstTextNodeInCurrentRun();
            {
                {
                    boolean var0831F1DFD766B141B2DAE9EBB226A597_877333532 = (n == this && content != null && content.length() > 0);
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
        varB4EAC82CA7396A68D541C85D26508E83_588494801 = result;
        addTaint(content.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_588494801.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_588494801;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.117 -0400", hash_original_method = "9928E14A90ED22F7792AF824C555C38E", hash_generated_method = "56DDB3D41819F79140CFE6A4C1945DA4")
    private TextImpl firstTextNodeInCurrentRun() {
        TextImpl varB4EAC82CA7396A68D541C85D26508E83_783652490 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_783652490 = firstTextInCurrentRun;
        varB4EAC82CA7396A68D541C85D26508E83_783652490.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_783652490;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.132 -0400", hash_original_method = "E11C938286265122BF52D51A5CD9EED3", hash_generated_method = "2C6926548F7B6ECF29CD4BC6215407E6")
    private TextImpl nextTextNode() {
        TextImpl varB4EAC82CA7396A68D541C85D26508E83_847743273 = null; //Variable for return #1
        TextImpl varB4EAC82CA7396A68D541C85D26508E83_882840363 = null; //Variable for return #2
        Node nextSibling;
        nextSibling = getNextSibling();
        {
            varB4EAC82CA7396A68D541C85D26508E83_847743273 = null;
        } //End block
        short nodeType;
        nodeType = nextSibling.getNodeType();
        varB4EAC82CA7396A68D541C85D26508E83_882840363 = nodeType == Node.TEXT_NODE || nodeType == Node.CDATA_SECTION_NODE
                ? (TextImpl) nextSibling
                : null;
        TextImpl varA7E53CE21691AB073D9660D615818899_809749817; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_809749817 = varB4EAC82CA7396A68D541C85D26508E83_847743273;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_809749817 = varB4EAC82CA7396A68D541C85D26508E83_882840363;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_809749817.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_809749817;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.134 -0400", hash_original_method = "C12D207E9524D7914DF3EC77CD8084EB", hash_generated_method = "9A0D609E1C93E20A8EE9B6D4D5FA2E52")
    public final TextImpl minimize() {
        TextImpl varB4EAC82CA7396A68D541C85D26508E83_1689215610 = null; //Variable for return #1
        TextImpl varB4EAC82CA7396A68D541C85D26508E83_928072922 = null; //Variable for return #2
        TextImpl varB4EAC82CA7396A68D541C85D26508E83_2077386019 = null; //Variable for return #3
        {
            boolean varB0D0CE9333EA8221AF0697B62A1B4A5C_810017683 = (getLength() == 0);
            {
                parent.removeChild(this);
                varB4EAC82CA7396A68D541C85D26508E83_1689215610 = null;
            } //End block
        } //End collapsed parenthetic
        Node previous;
        previous = getPreviousSibling();
        {
            boolean var4A5BF3CA70F2129AF0CB018F3C4F2317_492654958 = (previous == null || previous.getNodeType() != Node.TEXT_NODE);
            {
                varB4EAC82CA7396A68D541C85D26508E83_928072922 = this;
            } //End block
        } //End collapsed parenthetic
        TextImpl previousText;
        previousText = (TextImpl) previous;
        previousText.buffer.append(buffer);
        parent.removeChild(this);
        varB4EAC82CA7396A68D541C85D26508E83_2077386019 = previousText;
        TextImpl varA7E53CE21691AB073D9660D615818899_435065093; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_435065093 = varB4EAC82CA7396A68D541C85D26508E83_1689215610;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_435065093 = varB4EAC82CA7396A68D541C85D26508E83_928072922;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_435065093 = varB4EAC82CA7396A68D541C85D26508E83_2077386019;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_435065093.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_435065093;
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

