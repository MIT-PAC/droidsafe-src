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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.243 -0400", hash_original_method = "8FBFCF7E900515A865ACF1E6532A7BB4", hash_generated_method = "778826811E83592E50B2C9B824F4A820")
    public  TextImpl(DocumentImpl document, String data) {
        super(document, data);
        addTaint(document.getTaint());
        addTaint(data.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.244 -0400", hash_original_method = "F5AD87001A4CE84E4D3D0566BEEE7118", hash_generated_method = "84FEEDA63A0882C3A76F116A4B204901")
    @Override
    public String getNodeName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1479039209 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1479039209 = "#text";
        varB4EAC82CA7396A68D541C85D26508E83_1479039209.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1479039209;
        // ---------- Original Method ----------
        //return "#text";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.245 -0400", hash_original_method = "C38FDDE6CC592E744EE6602E5FF8812E", hash_generated_method = "8E1ACE4C54508EA6F36E1983F7F0BE38")
    @Override
    public short getNodeType() {
        short var4F09DAA9D95BCB166A302407A0E0BABE_768146939 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_768146939;
        // ---------- Original Method ----------
        //return Node.TEXT_NODE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.249 -0400", hash_original_method = "F2223FE614407E591CCAD60B04318A19", hash_generated_method = "F1AC2429327EC157517377C43B125970")
    public final Text splitText(int offset) throws DOMException {
        Text varB4EAC82CA7396A68D541C85D26508E83_1083247928 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_1083247928 = this;
        addTaint(offset);
        varB4EAC82CA7396A68D541C85D26508E83_1083247928.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1083247928;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.250 -0400", hash_original_method = "E52052CEEE0E5966B25CAA49C3A5CE28", hash_generated_method = "9B60B719ED57DF6A42C9B4C9E7EA3970")
    public final boolean isElementContentWhitespace() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_394826452 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_394826452;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.250 -0400", hash_original_method = "9EC887BD47A703F2DBB656ECC04AC254", hash_generated_method = "21C7C67C761210FDFA1E50C5694B3DB7")
    public final String getWholeText() {
        String varB4EAC82CA7396A68D541C85D26508E83_513633051 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_513633051 = result.toString();
        varB4EAC82CA7396A68D541C85D26508E83_513633051.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_513633051;
        // ---------- Original Method ----------
        //StringBuilder result = new StringBuilder();
        //for (TextImpl n = firstTextNodeInCurrentRun(); n != null; n = n.nextTextNode()) {
            //n.appendDataTo(result);
        //}
        //return result.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.255 -0400", hash_original_method = "F1D9E0F93EC220C6C7713D2F10A5FC3E", hash_generated_method = "6C7EE688B6BCE57B79EFA5C9580FE69D")
    public final Text replaceWholeText(String content) throws DOMException {
        Text varB4EAC82CA7396A68D541C85D26508E83_1789186875 = null; //Variable for return #1
        Node parent;
        parent = getParentNode();
        Text result;
        result = null;
        {
            TextImpl n;
            n = firstTextNodeInCurrentRun();
            {
                {
                    boolean var0831F1DFD766B141B2DAE9EBB226A597_592352241 = (n == this && content != null && content.length() > 0);
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
        varB4EAC82CA7396A68D541C85D26508E83_1789186875 = result;
        addTaint(content.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1789186875.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1789186875;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.255 -0400", hash_original_method = "9928E14A90ED22F7792AF824C555C38E", hash_generated_method = "ECCFABAF41F73EAAB816CBF507FD52A0")
    private TextImpl firstTextNodeInCurrentRun() {
        TextImpl varB4EAC82CA7396A68D541C85D26508E83_615071254 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_615071254 = firstTextInCurrentRun;
        varB4EAC82CA7396A68D541C85D26508E83_615071254.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_615071254;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.272 -0400", hash_original_method = "E11C938286265122BF52D51A5CD9EED3", hash_generated_method = "7D5354439D8F5D93E281C3576207E7EB")
    private TextImpl nextTextNode() {
        TextImpl varB4EAC82CA7396A68D541C85D26508E83_1744060282 = null; //Variable for return #1
        TextImpl varB4EAC82CA7396A68D541C85D26508E83_978459756 = null; //Variable for return #2
        Node nextSibling;
        nextSibling = getNextSibling();
        {
            varB4EAC82CA7396A68D541C85D26508E83_1744060282 = null;
        } //End block
        short nodeType;
        nodeType = nextSibling.getNodeType();
        varB4EAC82CA7396A68D541C85D26508E83_978459756 = nodeType == Node.TEXT_NODE || nodeType == Node.CDATA_SECTION_NODE
                ? (TextImpl) nextSibling
                : null;
        TextImpl varA7E53CE21691AB073D9660D615818899_156115542; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_156115542 = varB4EAC82CA7396A68D541C85D26508E83_1744060282;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_156115542 = varB4EAC82CA7396A68D541C85D26508E83_978459756;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_156115542.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_156115542;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.272 -0400", hash_original_method = "C12D207E9524D7914DF3EC77CD8084EB", hash_generated_method = "B9CC3F89DF7FBD2D937A6207EAD22D1E")
    public final TextImpl minimize() {
        TextImpl varB4EAC82CA7396A68D541C85D26508E83_167687937 = null; //Variable for return #1
        TextImpl varB4EAC82CA7396A68D541C85D26508E83_1400714847 = null; //Variable for return #2
        TextImpl varB4EAC82CA7396A68D541C85D26508E83_1595148394 = null; //Variable for return #3
        {
            boolean varB0D0CE9333EA8221AF0697B62A1B4A5C_1481426917 = (getLength() == 0);
            {
                parent.removeChild(this);
                varB4EAC82CA7396A68D541C85D26508E83_167687937 = null;
            } //End block
        } //End collapsed parenthetic
        Node previous;
        previous = getPreviousSibling();
        {
            boolean var4A5BF3CA70F2129AF0CB018F3C4F2317_481161113 = (previous == null || previous.getNodeType() != Node.TEXT_NODE);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1400714847 = this;
            } //End block
        } //End collapsed parenthetic
        TextImpl previousText;
        previousText = (TextImpl) previous;
        previousText.buffer.append(buffer);
        parent.removeChild(this);
        varB4EAC82CA7396A68D541C85D26508E83_1595148394 = previousText;
        TextImpl varA7E53CE21691AB073D9660D615818899_796964228; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_796964228 = varB4EAC82CA7396A68D541C85D26508E83_167687937;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_796964228 = varB4EAC82CA7396A68D541C85D26508E83_1400714847;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_796964228 = varB4EAC82CA7396A68D541C85D26508E83_1595148394;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_796964228.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_796964228;
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

