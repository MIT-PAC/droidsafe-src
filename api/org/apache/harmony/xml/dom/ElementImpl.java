package org.apache.harmony.xml.dom;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import libcore.util.Objects;
import org.w3c.dom.Attr;
import org.w3c.dom.DOMException;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.TypeInfo;

public class ElementImpl extends InnerNodeImpl implements Element {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.063 -0400", hash_original_field = "CEC00E48144CD3C5B0000055F3D7FF26", hash_generated_field = "6DED3D0909D027805E22F95BA58508AE")

    boolean namespaceAware;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.063 -0400", hash_original_field = "5295F3E9C46315AF1C2132265086FA24", hash_generated_field = "5B184DBF8D93287A0F0C8BC78758CAB7")

    String namespaceURI;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.063 -0400", hash_original_field = "851F5AC9941D720844D143ED9CFCF60A", hash_generated_field = "D07D332701F9B92847141D46D8B2C7CF")

    String prefix;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.063 -0400", hash_original_field = "E62B9ECBD883C26642197A7DC8246D3C", hash_generated_field = "69F110BF2CAEA76B4D1C533597A16878")

    String localName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.063 -0400", hash_original_field = "D7461AFEBA4ED0DC3AB3D12F77C8DA48", hash_generated_field = "370A7E27C76BC902168F8323D6CEB238")

    private List<AttrImpl> attributes = new ArrayList<AttrImpl>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.064 -0400", hash_original_method = "E83037DBBA9A213D892AFBAECFD42006", hash_generated_method = "B4C8F7A3379A1792597209CAFC9B21E5")
      ElementImpl(DocumentImpl document, String namespaceURI, String qualifiedName) {
        super(document);
        setNameNS(this, namespaceURI, qualifiedName);
        addTaint(document.getTaint());
        addTaint(namespaceURI.getTaint());
        addTaint(qualifiedName.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.064 -0400", hash_original_method = "D2CD0310D5C8F85822C82439B7C2ED0A", hash_generated_method = "70C1123D5E98FE030C6FA18966F03C09")
      ElementImpl(DocumentImpl document, String name) {
        super(document);
        setName(this, name);
        addTaint(document.getTaint());
        addTaint(name.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.064 -0400", hash_original_method = "33812125B5F046930FB02168EEB43D40", hash_generated_method = "4F226AC73752C61163427CBDD29C2F81")
    private int indexOfAttribute(String name) {
        {
            int i = 0;
            boolean var4BF9AA01498A302A953E7B72FFE2E6DF_638887387 = (i < attributes.size());
            {
                AttrImpl attr = attributes.get(i);
                {
                    boolean var7BAD3BFC039F765668FE34CB011AC143_639883794 = (Objects.equal(name, attr.getNodeName()));
                } 
            } 
        } 
        addTaint(name.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_660167824 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_660167824;
        
        
            
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.065 -0400", hash_original_method = "7BDB91D541F3C8F5E0B377A9C520D55B", hash_generated_method = "6EE45322C2E23E250367D4D6D7E45DB3")
    private int indexOfAttributeNS(String namespaceURI, String localName) {
        {
            int i = 0;
            boolean var4BF9AA01498A302A953E7B72FFE2E6DF_94534685 = (i < attributes.size());
            {
                AttrImpl attr = attributes.get(i);
                {
                    boolean var862ADD8BB15D0BE1810DD35AF160FA42_1514814250 = (Objects.equal(namespaceURI, attr.getNamespaceURI())
                    && Objects.equal(localName, attr.getLocalName()));
                } 
            } 
        } 
        addTaint(namespaceURI.getTaint());
        addTaint(localName.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1904091900 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1904091900;
        
        
            
            
                    
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.065 -0400", hash_original_method = "813C4DD10F102D6D885192D956222478", hash_generated_method = "7446124BEB7C87EE0054FBBC2C2FD2C9")
    public String getAttribute(String name) {
        String varB4EAC82CA7396A68D541C85D26508E83_65830250 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1663610236 = null; 
        Attr attr = getAttributeNode(name);
        {
            varB4EAC82CA7396A68D541C85D26508E83_65830250 = "";
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1663610236 = attr.getValue();
        addTaint(name.getTaint());
        String varA7E53CE21691AB073D9660D615818899_1325858389; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1325858389 = varB4EAC82CA7396A68D541C85D26508E83_65830250;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1325858389 = varB4EAC82CA7396A68D541C85D26508E83_1663610236;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1325858389.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1325858389;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.066 -0400", hash_original_method = "2AD352ABD4B75CC40A48A87FB5C80EF1", hash_generated_method = "386613B2031D52892EF025FEAE856047")
    public String getAttributeNS(String namespaceURI, String localName) {
        String varB4EAC82CA7396A68D541C85D26508E83_1221681597 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_908870434 = null; 
        Attr attr = getAttributeNodeNS(namespaceURI, localName);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1221681597 = "";
        } 
        varB4EAC82CA7396A68D541C85D26508E83_908870434 = attr.getValue();
        addTaint(namespaceURI.getTaint());
        addTaint(localName.getTaint());
        String varA7E53CE21691AB073D9660D615818899_1713443917; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1713443917 = varB4EAC82CA7396A68D541C85D26508E83_1221681597;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1713443917 = varB4EAC82CA7396A68D541C85D26508E83_908870434;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1713443917.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1713443917;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.067 -0400", hash_original_method = "83D3ED81624F77A7E713E4996ABE0363", hash_generated_method = "C101F4C4D66E9BC5A5E510BF6AEDE27A")
    public AttrImpl getAttributeNode(String name) {
        AttrImpl varB4EAC82CA7396A68D541C85D26508E83_1852759235 = null; 
        AttrImpl varB4EAC82CA7396A68D541C85D26508E83_800957570 = null; 
        int i = indexOfAttribute(name);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1852759235 = null;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_800957570 = attributes.get(i);
        addTaint(name.getTaint());
        AttrImpl varA7E53CE21691AB073D9660D615818899_1132387899; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1132387899 = varB4EAC82CA7396A68D541C85D26508E83_1852759235;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1132387899 = varB4EAC82CA7396A68D541C85D26508E83_800957570;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1132387899.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1132387899;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.068 -0400", hash_original_method = "3B62D6330977637E22606F97FB7DAA33", hash_generated_method = "0A0C4D6D983BB3118F7E026C9BD96C0C")
    public AttrImpl getAttributeNodeNS(String namespaceURI, String localName) {
        AttrImpl varB4EAC82CA7396A68D541C85D26508E83_1495876105 = null; 
        AttrImpl varB4EAC82CA7396A68D541C85D26508E83_1499133881 = null; 
        int i = indexOfAttributeNS(namespaceURI, localName);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1495876105 = null;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1499133881 = attributes.get(i);
        addTaint(namespaceURI.getTaint());
        addTaint(localName.getTaint());
        AttrImpl varA7E53CE21691AB073D9660D615818899_504836798; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_504836798 = varB4EAC82CA7396A68D541C85D26508E83_1495876105;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_504836798 = varB4EAC82CA7396A68D541C85D26508E83_1499133881;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_504836798.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_504836798;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.069 -0400", hash_original_method = "DB6D276ECDED2CB7A7381953F02FE1C2", hash_generated_method = "6C6D4D0A3B8770933A3F99CFE7708F5D")
    @Override
    public NamedNodeMap getAttributes() {
        NamedNodeMap varB4EAC82CA7396A68D541C85D26508E83_1655460091 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1655460091 = new ElementAttrNamedNodeMapImpl();
        varB4EAC82CA7396A68D541C85D26508E83_1655460091.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1655460091;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.074 -0400", hash_original_method = "75972D234B77F7219B8A807D51F2F4BE", hash_generated_method = "D450B03B44E55D25C7556DD2177147BF")
     Element getElementById(String name) {
        Element varB4EAC82CA7396A68D541C85D26508E83_1499400828 = null; 
        Element varB4EAC82CA7396A68D541C85D26508E83_837759612 = null; 
        Element varB4EAC82CA7396A68D541C85D26508E83_405773705 = null; 
        Element varB4EAC82CA7396A68D541C85D26508E83_1138650721 = null; 
        {
            Iterator<AttrImpl> var85569F768AA62BA2E033CE436AD30008_270620055 = (attributes).iterator();
            var85569F768AA62BA2E033CE436AD30008_270620055.hasNext();
            Attr attr = var85569F768AA62BA2E033CE436AD30008_270620055.next();
            {
                {
                    boolean varDE620A923FB4415A0C3EC0AB13170E4C_143384266 = (attr.isId() && name.equals(attr.getValue()));
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1499400828 = this;
                    } 
                } 
            } 
        } 
        {
            boolean varAA388FAC5E10062A184F3A6F89066921_1108200169 = (name.equals(getAttribute("id")));
            {
                varB4EAC82CA7396A68D541C85D26508E83_837759612 = this;
            } 
        } 
        {
            Iterator<LeafNodeImpl> varF58ADF1EBC9DDE72E3BE9125144A2DC8_1460517762 = (children).iterator();
            varF58ADF1EBC9DDE72E3BE9125144A2DC8_1460517762.hasNext();
            NodeImpl node = varF58ADF1EBC9DDE72E3BE9125144A2DC8_1460517762.next();
            {
                {
                    boolean var680B8F21E738349851454831355CAC3D_1729040895 = (node.getNodeType() == Node.ELEMENT_NODE);
                    {
                        Element element = ((ElementImpl) node).getElementById(name);
                        {
                            varB4EAC82CA7396A68D541C85D26508E83_405773705 = element;
                        } 
                    } 
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1138650721 = null;
        addTaint(name.getTaint());
        Element varA7E53CE21691AB073D9660D615818899_229849131; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_229849131 = varB4EAC82CA7396A68D541C85D26508E83_1499400828;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_229849131 = varB4EAC82CA7396A68D541C85D26508E83_837759612;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_229849131 = varB4EAC82CA7396A68D541C85D26508E83_405773705;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_229849131 = varB4EAC82CA7396A68D541C85D26508E83_1138650721;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_229849131.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_229849131;
        
        
            
                
            
        
        
            
        
        
            
                
                
                    
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.074 -0400", hash_original_method = "6E8835CC5AA6D9440E7C33D346671E0B", hash_generated_method = "CAC78B0A46F07165DA2DC923C914FB93")
    public NodeList getElementsByTagName(String name) {
        NodeList varB4EAC82CA7396A68D541C85D26508E83_344173469 = null; 
        NodeListImpl result = new NodeListImpl();
        getElementsByTagName(result, name);
        varB4EAC82CA7396A68D541C85D26508E83_344173469 = result;
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_344173469.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_344173469;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.075 -0400", hash_original_method = "A5BCB04504E6AD1A3895B6FBC1B390B7", hash_generated_method = "6149735D8B1DBE45DD8326F62CCDF225")
    public NodeList getElementsByTagNameNS(String namespaceURI, String localName) {
        NodeList varB4EAC82CA7396A68D541C85D26508E83_611748120 = null; 
        NodeListImpl result = new NodeListImpl();
        getElementsByTagNameNS(result, namespaceURI, localName);
        varB4EAC82CA7396A68D541C85D26508E83_611748120 = result;
        addTaint(namespaceURI.getTaint());
        addTaint(localName.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_611748120.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_611748120;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.076 -0400", hash_original_method = "006A1593C2EDDFD80B5C8C9A0B08E49A", hash_generated_method = "CDDD2B4581B9D0B051DAF736B2AF33AF")
    @Override
    public String getLocalName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1767845484 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1767845484 = namespaceAware ? localName : null;
        varB4EAC82CA7396A68D541C85D26508E83_1767845484.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1767845484;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.076 -0400", hash_original_method = "1455FE8FE34AF373D39E8278191439A8", hash_generated_method = "1A32068F9825023BCBCF731D2FB7C6FE")
    @Override
    public String getNamespaceURI() {
        String varB4EAC82CA7396A68D541C85D26508E83_1832872335 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1832872335 = namespaceURI;
        varB4EAC82CA7396A68D541C85D26508E83_1832872335.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1832872335;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.077 -0400", hash_original_method = "24A50BD0D938263A925A0CD0D8B09D61", hash_generated_method = "6F5A1946FDC6064B1AD5C67F35730964")
    @Override
    public String getNodeName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1226805768 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1226805768 = getTagName();
        varB4EAC82CA7396A68D541C85D26508E83_1226805768.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1226805768;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.077 -0400", hash_original_method = "8EDB6CFF77634EC46F3FE6E39D5C4072", hash_generated_method = "66937C125D3D0BB6BE074299A2B9454C")
    public short getNodeType() {
        short var4F09DAA9D95BCB166A302407A0E0BABE_174434107 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_174434107;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.078 -0400", hash_original_method = "FA5CE5A0FCC0C736D9446FFEBD0CAB9D", hash_generated_method = "D471E703EB4AE1959067A8F3B2F9F963")
    @Override
    public String getPrefix() {
        String varB4EAC82CA7396A68D541C85D26508E83_1428565690 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1428565690 = prefix;
        varB4EAC82CA7396A68D541C85D26508E83_1428565690.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1428565690;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.079 -0400", hash_original_method = "84D6D79E2DD8ACB2C7098589FE413C76", hash_generated_method = "B34EDDD553A94DC27F30BF0F78D38F95")
    public String getTagName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1110366248 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1110366248 = prefix != null
                ? prefix + ":" + localName
                : localName;
        varB4EAC82CA7396A68D541C85D26508E83_1110366248.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1110366248;
        
        
                
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.079 -0400", hash_original_method = "6C8F2E9D9AC7653B36D8183C37FDC271", hash_generated_method = "522A13798DA43BA3D9830D104D14AB5C")
    public boolean hasAttribute(String name) {
        boolean var9A6B46C7A05A149C7FD72F2126229268_363748716 = (indexOfAttribute(name) != -1);
        addTaint(name.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_509021737 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_509021737;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.080 -0400", hash_original_method = "A72242585FC8C818B78134FE05A6EE18", hash_generated_method = "C60452D21273C2EB7B0F5E322E53A673")
    public boolean hasAttributeNS(String namespaceURI, String localName) {
        boolean varFD44CF5CE0E790CFF22EA7E5CF2E4CA0_303932530 = (indexOfAttributeNS(namespaceURI, localName) != -1);
        addTaint(namespaceURI.getTaint());
        addTaint(localName.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1422400468 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1422400468;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.080 -0400", hash_original_method = "F148456BA584CDD324D3AD480B7851B4", hash_generated_method = "285242407C461D38EE1F3913E414F060")
    @Override
    public boolean hasAttributes() {
        boolean varC14277A36C5456E69030CF13195697F1_114861143 = (!attributes.isEmpty());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_665027678 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_665027678;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.080 -0400", hash_original_method = "8DBF320E88520709ECE3A3A8169ED4DA", hash_generated_method = "B4EC2E53C7B022B2F7E8F2E937948B9E")
    public void removeAttribute(String name) throws DOMException {
        int i = indexOfAttribute(name);
        {
            attributes.remove(i);
        } 
        addTaint(name.getTaint());
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.081 -0400", hash_original_method = "DB944C5E777E2AB6A4CA622A526DBBB8", hash_generated_method = "0883AFD8EBC7897115656493B86E49EB")
    public void removeAttributeNS(String namespaceURI, String localName) throws DOMException {
        int i = indexOfAttributeNS(namespaceURI, localName);
        {
            attributes.remove(i);
        } 
        addTaint(namespaceURI.getTaint());
        addTaint(localName.getTaint());
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.082 -0400", hash_original_method = "48A4F4D8663A7BAF5C33913CE98C9411", hash_generated_method = "392003DC9C89719A96F21BB552F6CC83")
    public Attr removeAttributeNode(Attr oldAttr) throws DOMException {
        Attr varB4EAC82CA7396A68D541C85D26508E83_422631817 = null; 
        AttrImpl oldAttrImpl = (AttrImpl) oldAttr;
        {
            boolean var5F8EC0C033C14176F1E7190A783BB3E6_708705071 = (oldAttrImpl.getOwnerElement() != this);
            {
                if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.NOT_FOUND_ERR, null);
            } 
        } 
        attributes.remove(oldAttrImpl);
        oldAttrImpl.ownerElement = null;
        varB4EAC82CA7396A68D541C85D26508E83_422631817 = oldAttrImpl;
        addTaint(oldAttr.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_422631817.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_422631817;
        
        
        
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.082 -0400", hash_original_method = "6DCEAAD8535FDF367A6D4293F8DE36CE", hash_generated_method = "BCB07543338B767C776908376CFA829A")
    public void setAttribute(String name, String value) throws DOMException {
        Attr attr = getAttributeNode(name);
        {
            attr = document.createAttribute(name);
            setAttributeNode(attr);
        } 
        attr.setValue(value);
        addTaint(name.getTaint());
        addTaint(value.getTaint());
        
        
        
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.082 -0400", hash_original_method = "F2270012ECC9DDE7A199A2B08906CDAC", hash_generated_method = "7879CC9049973900E8E24AFA6A84ED95")
    public void setAttributeNS(String namespaceURI, String qualifiedName,
            String value) throws DOMException {
        Attr attr = getAttributeNodeNS(namespaceURI, qualifiedName);
        {
            attr = document.createAttributeNS(namespaceURI, qualifiedName);
            setAttributeNodeNS(attr);
        } 
        attr.setValue(value);
        addTaint(namespaceURI.getTaint());
        addTaint(qualifiedName.getTaint());
        addTaint(value.getTaint());
        
        
        
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.083 -0400", hash_original_method = "2863AD660D70C60FE387E2DF61C003C1", hash_generated_method = "B53EF0AB8274C028F33FBA778EDADACB")
    public Attr setAttributeNode(Attr newAttr) throws DOMException {
        Attr varB4EAC82CA7396A68D541C85D26508E83_256086621 = null; 
        AttrImpl newAttrImpl = (AttrImpl) newAttr;
        {
            if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.WRONG_DOCUMENT_ERR, null);
        } 
        {
            boolean var877A67893D24F6B22E8A0E6DF1EAF1B0_1370552683 = (newAttrImpl.getOwnerElement() != null);
            {
                if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.INUSE_ATTRIBUTE_ERR, null);
            } 
        } 
        AttrImpl oldAttrImpl = null;
        int i = indexOfAttribute(newAttr.getName());
        {
            oldAttrImpl = attributes.get(i);
            attributes.remove(i);
        } 
        attributes.add(newAttrImpl);
        newAttrImpl.ownerElement = this;
        varB4EAC82CA7396A68D541C85D26508E83_256086621 = oldAttrImpl;
        addTaint(newAttr.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_256086621.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_256086621;
        
        
        
            
        
        
            
        
        
        
        
            
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.084 -0400", hash_original_method = "1229E8AF3668CCD52190CAB83AB0EAC8", hash_generated_method = "7C5BEEEE9E6519A95A9BE214B074095B")
    public Attr setAttributeNodeNS(Attr newAttr) throws DOMException {
        Attr varB4EAC82CA7396A68D541C85D26508E83_536113545 = null; 
        AttrImpl newAttrImpl = (AttrImpl) newAttr;
        {
            if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.WRONG_DOCUMENT_ERR, null);
        } 
        {
            boolean var877A67893D24F6B22E8A0E6DF1EAF1B0_1411400792 = (newAttrImpl.getOwnerElement() != null);
            {
                if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.INUSE_ATTRIBUTE_ERR, null);
            } 
        } 
        AttrImpl oldAttrImpl = null;
        int i = indexOfAttributeNS(newAttr.getNamespaceURI(), newAttr.getLocalName());
        {
            oldAttrImpl = attributes.get(i);
            attributes.remove(i);
        } 
        attributes.add(newAttrImpl);
        newAttrImpl.ownerElement = this;
        varB4EAC82CA7396A68D541C85D26508E83_536113545 = oldAttrImpl;
        addTaint(newAttr.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_536113545.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_536113545;
        
        
        
            
        
        
            
        
        
        
        
            
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.084 -0400", hash_original_method = "3E19055116AC2D87625766EB1DC83913", hash_generated_method = "756E644F22A977734EE8F4F9494CEE85")
    @Override
    public void setPrefix(String prefix) {
        this.prefix = validatePrefix(prefix, namespaceAware, namespaceURI);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.084 -0400", hash_original_method = "C51D6ACA797563231B3A9D05774313B4", hash_generated_method = "A19BF1623A20CF1B068DF12D427C17D6")
    public TypeInfo getSchemaTypeInfo() {
        TypeInfo varB4EAC82CA7396A68D541C85D26508E83_2114622202 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2114622202 = NULL_TYPE_INFO;
        varB4EAC82CA7396A68D541C85D26508E83_2114622202.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2114622202;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.085 -0400", hash_original_method = "E2D0D43F42925D6B235314ECDF3F88D2", hash_generated_method = "E677681E0FA9A0D672B3AFBFF69F02D4")
    public void setIdAttribute(String name, boolean isId) throws DOMException {
        AttrImpl attr = getAttributeNode(name);
        {
            if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.NOT_FOUND_ERR,
                    "No such attribute: " + name);
        } 
        attr.isId = isId;
        addTaint(name.getTaint());
        addTaint(isId);
        
        
        
            
                    
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.085 -0400", hash_original_method = "EB4B24B3B95C74A915F87535C0F28019", hash_generated_method = "13EE6B0281B8193051394BFC6A607AF7")
    public void setIdAttributeNS(String namespaceURI, String localName,
            boolean isId) throws DOMException {
        AttrImpl attr = getAttributeNodeNS(namespaceURI, localName);
        {
            if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.NOT_FOUND_ERR,
                    "No such attribute: " + namespaceURI +  " " + localName);
        } 
        attr.isId = isId;
        addTaint(namespaceURI.getTaint());
        addTaint(localName.getTaint());
        addTaint(isId);
        
        
        
            
                    
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.085 -0400", hash_original_method = "D45D107EAB7744EE0777BE918C2E0DD2", hash_generated_method = "E2B7E4981C910FE7A405E777C907172A")
    public void setIdAttributeNode(Attr idAttr, boolean isId) throws DOMException {
        ((AttrImpl) idAttr).isId = isId;
        addTaint(idAttr.getTaint());
        addTaint(isId);
        
        
    }

    
    public class ElementAttrNamedNodeMapImpl implements NamedNodeMap {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.086 -0400", hash_original_method = "4DE56E7A278FE2CED469184A8A1F6E47", hash_generated_method = "4DE56E7A278FE2CED469184A8A1F6E47")
        public ElementAttrNamedNodeMapImpl ()
        {
            
        }


        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.086 -0400", hash_original_method = "FF1F71CDD63994FD93D39F9EA196EECF", hash_generated_method = "004E6F4C99377889749E130CAA37B2F9")
        public int getLength() {
            int var885D16ACBA3AAF937512B6C61A3B731A_792990145 = (ElementImpl.this.attributes.size());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1658655036 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1658655036;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.086 -0400", hash_original_method = "DC316EFAFE6C9719F9A6712C7C0724A1", hash_generated_method = "88EA467D1645F003B60226589C44D167")
        private int indexOfItem(String name) {
            int var4539B068F44D8760B8121FFD1C636043_933916238 = (ElementImpl.this.indexOfAttribute(name));
            addTaint(name.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1179186186 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1179186186;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.087 -0400", hash_original_method = "258D65E063DA88D4950E14323AAE31E6", hash_generated_method = "C146DB95C12BEB0A4889CF0EF7A817E3")
        private int indexOfItemNS(String namespaceURI, String localName) {
            int var6BB86ADC07E7A5ED0C713094AF81B0B0_1769536830 = (ElementImpl.this.indexOfAttributeNS(namespaceURI, localName));
            addTaint(namespaceURI.getTaint());
            addTaint(localName.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1701588092 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1701588092;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.087 -0400", hash_original_method = "5386255E2AB4AB2C7C1C9B01DBB08720", hash_generated_method = "B2EF521ED81576584FA6DE559BBA0E94")
        public Node getNamedItem(String name) {
            Node varB4EAC82CA7396A68D541C85D26508E83_1569445341 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1569445341 = ElementImpl.this.getAttributeNode(name);
            addTaint(name.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1569445341.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1569445341;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.088 -0400", hash_original_method = "4A42E6CB38C61058D8EEC911A360EDF7", hash_generated_method = "73789CD72F816CC1F9242F29E21DB712")
        public Node getNamedItemNS(String namespaceURI, String localName) {
            Node varB4EAC82CA7396A68D541C85D26508E83_1354371259 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1354371259 = ElementImpl.this.getAttributeNodeNS(namespaceURI, localName);
            addTaint(namespaceURI.getTaint());
            addTaint(localName.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1354371259.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1354371259;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.089 -0400", hash_original_method = "F60AE240A182D1B0B5E9071C74F61EEF", hash_generated_method = "06AE0FF3AE21D314B416F2BE543D7F31")
        public Node item(int index) {
            Node varB4EAC82CA7396A68D541C85D26508E83_353434938 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_353434938 = ElementImpl.this.attributes.get(index);
            addTaint(index);
            varB4EAC82CA7396A68D541C85D26508E83_353434938.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_353434938;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.090 -0400", hash_original_method = "92540DEE2EDFF119EB60FC0ECC313E2F", hash_generated_method = "8C9E03D03657C2F6C58E2AF1C9C78C44")
        public Node removeNamedItem(String name) throws DOMException {
            Node varB4EAC82CA7396A68D541C85D26508E83_1754095629 = null; 
            int i = indexOfItem(name);
            {
                if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.NOT_FOUND_ERR, null);
            } 
            varB4EAC82CA7396A68D541C85D26508E83_1754095629 = ElementImpl.this.attributes.remove(i);
            addTaint(name.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1754095629.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1754095629;
            
            
            
                
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.090 -0400", hash_original_method = "5947BF939F7AE1F8A4D4CDE5B6951547", hash_generated_method = "BBB3B3931821BB687E910FF3330F283E")
        public Node removeNamedItemNS(String namespaceURI, String localName) throws DOMException {
            Node varB4EAC82CA7396A68D541C85D26508E83_2092151216 = null; 
            int i = indexOfItemNS(namespaceURI, localName);
            {
                if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.NOT_FOUND_ERR, null);
            } 
            varB4EAC82CA7396A68D541C85D26508E83_2092151216 = ElementImpl.this.attributes.remove(i);
            addTaint(namespaceURI.getTaint());
            addTaint(localName.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_2092151216.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_2092151216;
            
            
            
                
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.091 -0400", hash_original_method = "5D95624F12CAAE730B29BD47EADFC40A", hash_generated_method = "FFA0C9D3C329BC14631C5B6BA63060EF")
        public Node setNamedItem(Node arg) throws DOMException {
            Node varB4EAC82CA7396A68D541C85D26508E83_1316386622 = null; 
            {
                if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.HIERARCHY_REQUEST_ERR, null);
            } 
            varB4EAC82CA7396A68D541C85D26508E83_1316386622 = ElementImpl.this.setAttributeNode((Attr)arg);
            addTaint(arg.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1316386622.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1316386622;
            
            
                
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.091 -0400", hash_original_method = "74F8A255439FFDD82EF1D14936D16522", hash_generated_method = "8F3B47D18CF0C3CE199A482E41B3692F")
        public Node setNamedItemNS(Node arg) throws DOMException {
            Node varB4EAC82CA7396A68D541C85D26508E83_1918293484 = null; 
            {
                if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.HIERARCHY_REQUEST_ERR, null);
            } 
            varB4EAC82CA7396A68D541C85D26508E83_1918293484 = ElementImpl.this.setAttributeNodeNS((Attr)arg);
            addTaint(arg.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1918293484.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1918293484;
            
            
                
            
            
        }

        
    }


    
}

