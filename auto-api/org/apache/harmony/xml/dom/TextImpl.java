package org.apache.harmony.xml.dom;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import org.w3c.dom.DOMException;
import org.w3c.dom.Node;
import org.w3c.dom.Text;

public class TextImpl extends CharacterDataImpl implements Text {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.447 -0400", hash_original_method = "8FBFCF7E900515A865ACF1E6532A7BB4", hash_generated_method = "778826811E83592E50B2C9B824F4A820")
    public  TextImpl(DocumentImpl document, String data) {
        super(document, data);
        addTaint(document.getTaint());
        addTaint(data.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.447 -0400", hash_original_method = "F5AD87001A4CE84E4D3D0566BEEE7118", hash_generated_method = "D041A02AE7FB0EEA27FDD5E07F6BC031")
    @Override
    public String getNodeName() {
        String varB4EAC82CA7396A68D541C85D26508E83_230994134 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_230994134 = "#text";
        varB4EAC82CA7396A68D541C85D26508E83_230994134.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_230994134;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.447 -0400", hash_original_method = "C38FDDE6CC592E744EE6602E5FF8812E", hash_generated_method = "F06E654BE43BB88EA135C17823D41992")
    @Override
    public short getNodeType() {
        short var4F09DAA9D95BCB166A302407A0E0BABE_1024597682 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_1024597682;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.448 -0400", hash_original_method = "F2223FE614407E591CCAD60B04318A19", hash_generated_method = "8705752203871EE3DC1A9365795E9757")
    public final Text splitText(int offset) throws DOMException {
        Text varB4EAC82CA7396A68D541C85D26508E83_1324771831 = null; 
        Text newText = document.createTextNode(
                substringData(offset, getLength() - offset));
        deleteData(0, offset);
        Node refNode = getNextSibling();
        {
            getParentNode().appendChild(newText);
        } 
        {
            getParentNode().insertBefore(newText, refNode);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1324771831 = this;
        addTaint(offset);
        varB4EAC82CA7396A68D541C85D26508E83_1324771831.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1324771831;
        
        
                
        
        
        
            
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.448 -0400", hash_original_method = "E52052CEEE0E5966B25CAA49C3A5CE28", hash_generated_method = "237C0563ECD2C698472CDA689CE06923")
    public final boolean isElementContentWhitespace() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_601971222 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_601971222;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.449 -0400", hash_original_method = "9EC887BD47A703F2DBB656ECC04AC254", hash_generated_method = "4C73CC4A35D55D676D1DB091304503CF")
    public final String getWholeText() {
        String varB4EAC82CA7396A68D541C85D26508E83_199605365 = null; 
        StringBuilder result = new StringBuilder();
        {
            TextImpl n = firstTextNodeInCurrentRun();
            n = n.nextTextNode();
            {
                n.appendDataTo(result);
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_199605365 = result.toString();
        varB4EAC82CA7396A68D541C85D26508E83_199605365.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_199605365;
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.450 -0400", hash_original_method = "F1D9E0F93EC220C6C7713D2F10A5FC3E", hash_generated_method = "97F6F97319ACAE3C651581A2069F5ADF")
    public final Text replaceWholeText(String content) throws DOMException {
        Text varB4EAC82CA7396A68D541C85D26508E83_2037000444 = null; 
        Node parent = getParentNode();
        Text result = null;
        {
            TextImpl n = firstTextNodeInCurrentRun();
            {
                {
                    boolean var0831F1DFD766B141B2DAE9EBB226A597_754345617 = (n == this && content != null && content.length() > 0);
                    {
                        setData(content);
                        result = this;
                        n = n.nextTextNode();
                    } 
                    {
                        Node toRemove = n;
                        n = n.nextTextNode();
                        parent.removeChild(toRemove);
                    } 
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_2037000444 = result;
        addTaint(content.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2037000444.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2037000444;
        
        
        
        
            
                
                
                
            
                
                
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.452 -0400", hash_original_method = "9928E14A90ED22F7792AF824C555C38E", hash_generated_method = "4C37FE28949DDFF7B6A83AABFE6DF5FD")
    private TextImpl firstTextNodeInCurrentRun() {
        TextImpl varB4EAC82CA7396A68D541C85D26508E83_949136007 = null; 
        TextImpl firstTextInCurrentRun = this;
        {
            Node p = getPreviousSibling();
            p = p.getPreviousSibling();
            {
                short nodeType = p.getNodeType();
                {
                    firstTextInCurrentRun = (TextImpl) p;
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_949136007 = firstTextInCurrentRun;
        varB4EAC82CA7396A68D541C85D26508E83_949136007.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_949136007;
        
        
        
            
            
                
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.455 -0400", hash_original_method = "E11C938286265122BF52D51A5CD9EED3", hash_generated_method = "B6D894B758EF7D04D6879D0F40761325")
    private TextImpl nextTextNode() {
        TextImpl varB4EAC82CA7396A68D541C85D26508E83_1997686941 = null; 
        TextImpl varB4EAC82CA7396A68D541C85D26508E83_912895259 = null; 
        Node nextSibling = getNextSibling();
        {
            varB4EAC82CA7396A68D541C85D26508E83_1997686941 = null;
        } 
        short nodeType = nextSibling.getNodeType();
        varB4EAC82CA7396A68D541C85D26508E83_912895259 = nodeType == Node.TEXT_NODE || nodeType == Node.CDATA_SECTION_NODE
                ? (TextImpl) nextSibling
                : null;
        TextImpl varA7E53CE21691AB073D9660D615818899_10831064; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_10831064 = varB4EAC82CA7396A68D541C85D26508E83_1997686941;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_10831064 = varB4EAC82CA7396A68D541C85D26508E83_912895259;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_10831064.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_10831064;
        
        
        
            
        
        
        
                
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.456 -0400", hash_original_method = "C12D207E9524D7914DF3EC77CD8084EB", hash_generated_method = "A14024B278BB4A8BE21FFC70F1FAB0C3")
    public final TextImpl minimize() {
        TextImpl varB4EAC82CA7396A68D541C85D26508E83_459796419 = null; 
        TextImpl varB4EAC82CA7396A68D541C85D26508E83_1171838611 = null; 
        TextImpl varB4EAC82CA7396A68D541C85D26508E83_219878411 = null; 
        {
            boolean varB0D0CE9333EA8221AF0697B62A1B4A5C_1656153957 = (getLength() == 0);
            {
                parent.removeChild(this);
                varB4EAC82CA7396A68D541C85D26508E83_459796419 = null;
            } 
        } 
        Node previous = getPreviousSibling();
        {
            boolean var4A5BF3CA70F2129AF0CB018F3C4F2317_1662708091 = (previous == null || previous.getNodeType() != Node.TEXT_NODE);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1171838611 = this;
            } 
        } 
        TextImpl previousText = (TextImpl) previous;
        previousText.buffer.append(buffer);
        parent.removeChild(this);
        varB4EAC82CA7396A68D541C85D26508E83_219878411 = previousText;
        TextImpl varA7E53CE21691AB073D9660D615818899_1991082459; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1991082459 = varB4EAC82CA7396A68D541C85D26508E83_459796419;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1991082459 = varB4EAC82CA7396A68D541C85D26508E83_1171838611;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1991082459 = varB4EAC82CA7396A68D541C85D26508E83_219878411;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1991082459.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1991082459;
        
        
            
            
        
        
        
            
        
        
        
        
        
    }

    
}

