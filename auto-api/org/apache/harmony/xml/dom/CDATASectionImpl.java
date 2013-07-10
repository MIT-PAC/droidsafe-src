package org.apache.harmony.xml.dom;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import org.w3c.dom.CDATASection;
import org.w3c.dom.Node;

public final class CDATASectionImpl extends TextImpl implements CDATASection {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.767 -0400", hash_original_method = "5E65B479C9B119188AACA9AAF7F8DB49", hash_generated_method = "54F3175018593ACF08C662E302F9DEAF")
    public  CDATASectionImpl(DocumentImpl document, String data) {
        super(document, data);
        addTaint(document.getTaint());
        addTaint(data.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.768 -0400", hash_original_method = "C06D7633E1EEC458B6238549761E1C34", hash_generated_method = "782DEACDFC707FF39CAF448C519A31E3")
    @Override
    public String getNodeName() {
        String varB4EAC82CA7396A68D541C85D26508E83_2002045307 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2002045307 = "#cdata-section";
        varB4EAC82CA7396A68D541C85D26508E83_2002045307.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2002045307;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.768 -0400", hash_original_method = "0AC4013C7F1EC92B6047139E15C869E6", hash_generated_method = "8E2047C0A3406B5FB7BA85BB9D668908")
    @Override
    public short getNodeType() {
        short var4F09DAA9D95BCB166A302407A0E0BABE_894544608 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_894544608;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.769 -0400", hash_original_method = "17E369F2319E43AC424DA68053015181", hash_generated_method = "FBC0A4C60C7D5E38939B0B1F47CF56B8")
    public void split() {
        {
            boolean varB00DB3B45A8833AEC0F6C9057C63EFCC_1293156649 = (!needsSplitting());
        } 
        Node parent = getParentNode();
        String[] parts = getData().split("\\]\\]>");
        parent.insertBefore(new CDATASectionImpl(document, parts[0] + "]]"), this);
        {
            int p = 1;
            {
                parent.insertBefore(new CDATASectionImpl(document, ">" + parts[p] + "]]"), this);
            } 
        } 
        setData(">" + parts[parts.length - 1]);
        
        
            
        
        
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.769 -0400", hash_original_method = "8ED5C89F0345565DF7EFEC04369CA761", hash_generated_method = "BEF5AA981D6CEFDE77BDED0DDAF5A8B4")
    public boolean needsSplitting() {
        boolean var76922E628753273615C1BB4E85B1DFCB_1520371250 = (buffer.indexOf("]]>") != -1);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1671605818 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1671605818;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.770 -0400", hash_original_method = "431D9E89C59292036E70F8C33A255325", hash_generated_method = "7EB210D598CB70030A4B1B3EDB031096")
    public TextImpl replaceWithText() {
        TextImpl varB4EAC82CA7396A68D541C85D26508E83_85128786 = null; 
        TextImpl replacement = new TextImpl(document, getData());
        parent.insertBefore(replacement, this);
        parent.removeChild(this);
        varB4EAC82CA7396A68D541C85D26508E83_85128786 = replacement;
        varB4EAC82CA7396A68D541C85D26508E83_85128786.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_85128786;
        
        
        
        
        
    }

    
}

