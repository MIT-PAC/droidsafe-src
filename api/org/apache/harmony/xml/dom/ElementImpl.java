package org.apache.harmony.xml.dom;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.715 -0400", hash_original_field = "CEC00E48144CD3C5B0000055F3D7FF26", hash_generated_field = "6DED3D0909D027805E22F95BA58508AE")

    boolean namespaceAware;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.715 -0400", hash_original_field = "5295F3E9C46315AF1C2132265086FA24", hash_generated_field = "5B184DBF8D93287A0F0C8BC78758CAB7")

    String namespaceURI;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.715 -0400", hash_original_field = "851F5AC9941D720844D143ED9CFCF60A", hash_generated_field = "D07D332701F9B92847141D46D8B2C7CF")

    String prefix;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.715 -0400", hash_original_field = "E62B9ECBD883C26642197A7DC8246D3C", hash_generated_field = "69F110BF2CAEA76B4D1C533597A16878")

    String localName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.715 -0400", hash_original_field = "D7461AFEBA4ED0DC3AB3D12F77C8DA48", hash_generated_field = "370A7E27C76BC902168F8323D6CEB238")

    private List<AttrImpl> attributes = new ArrayList<AttrImpl>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.715 -0400", hash_original_method = "E83037DBBA9A213D892AFBAECFD42006", hash_generated_method = "FB62429B0AFFA4514DE2F18DD89625B5")
      ElementImpl(DocumentImpl document, String namespaceURI, String qualifiedName) {
        super(document);
        addTaint(qualifiedName.getTaint());
        addTaint(namespaceURI.getTaint());
        addTaint(document.getTaint());
        setNameNS(this, namespaceURI, qualifiedName);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.716 -0400", hash_original_method = "D2CD0310D5C8F85822C82439B7C2ED0A", hash_generated_method = "E79762F2053F1B3B8BC49C769FD1DFBF")
      ElementImpl(DocumentImpl document, String name) {
        super(document);
        addTaint(name.getTaint());
        addTaint(document.getTaint());
        setName(this, name);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.716 -0400", hash_original_method = "33812125B5F046930FB02168EEB43D40", hash_generated_method = "9C7A5EFDAC3CEEEECEF7E62B377CAF40")
    private int indexOfAttribute(String name) {
        addTaint(name.getTaint());
for(int i = 0;i < attributes.size();i++)
        {
            AttrImpl attr = attributes.get(i);
    if(Objects.equal(name, attr.getNodeName()))            
            {
                int var865C0C0B4AB0E063E5CAA3387C1A8741_1032383461 = (i);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1668379918 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1668379918;
            } 
        } 
        int var6BB61E3B7BCE0931DA574D19D1D82C88_1425548373 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_330918778 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_330918778;
        
        
            
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.717 -0400", hash_original_method = "7BDB91D541F3C8F5E0B377A9C520D55B", hash_generated_method = "4B174CAB45B07D780BFFE3FDCF9203CB")
    private int indexOfAttributeNS(String namespaceURI, String localName) {
        addTaint(localName.getTaint());
        addTaint(namespaceURI.getTaint());
for(int i = 0;i < attributes.size();i++)
        {
            AttrImpl attr = attributes.get(i);
    if(Objects.equal(namespaceURI, attr.getNamespaceURI())
                    && Objects.equal(localName, attr.getLocalName()))            
            {
                int var865C0C0B4AB0E063E5CAA3387C1A8741_1428866867 = (i);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_33546040 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_33546040;
            } 
        } 
        int var6BB61E3B7BCE0931DA574D19D1D82C88_1664840740 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1272389649 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1272389649;
        
        
            
            
                    
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.717 -0400", hash_original_method = "813C4DD10F102D6D885192D956222478", hash_generated_method = "1EDAE909CA8C4C0650E700FB33481E8F")
    public String getAttribute(String name) {
        addTaint(name.getTaint());
        Attr attr = getAttributeNode(name);
    if(attr == null)        
        {
String var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1597243602 =             "";
            var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1597243602.addTaint(taint);
            return var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1597243602;
        } 
String varB8B9307C4FA9D699C8FD1776B5AD3762_908319327 =         attr.getValue();
        varB8B9307C4FA9D699C8FD1776B5AD3762_908319327.addTaint(taint);
        return varB8B9307C4FA9D699C8FD1776B5AD3762_908319327;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.718 -0400", hash_original_method = "2AD352ABD4B75CC40A48A87FB5C80EF1", hash_generated_method = "F2B71DCFE12B17AF7B98D5C208CF49B3")
    public String getAttributeNS(String namespaceURI, String localName) {
        addTaint(localName.getTaint());
        addTaint(namespaceURI.getTaint());
        Attr attr = getAttributeNodeNS(namespaceURI, localName);
    if(attr == null)        
        {
String var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1324718421 =             "";
            var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1324718421.addTaint(taint);
            return var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1324718421;
        } 
String varB8B9307C4FA9D699C8FD1776B5AD3762_120416655 =         attr.getValue();
        varB8B9307C4FA9D699C8FD1776B5AD3762_120416655.addTaint(taint);
        return varB8B9307C4FA9D699C8FD1776B5AD3762_120416655;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.718 -0400", hash_original_method = "83D3ED81624F77A7E713E4996ABE0363", hash_generated_method = "4160E80A31CCEB615F3080984A1FC6DE")
    public AttrImpl getAttributeNode(String name) {
        addTaint(name.getTaint());
        int i = indexOfAttribute(name);
    if(i == -1)        
        {
AttrImpl var540C13E9E156B687226421B24F2DF178_227692325 =             null;
            var540C13E9E156B687226421B24F2DF178_227692325.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_227692325;
        } 
AttrImpl var7C95605C4830717EBBBBB4182924624E_1453651806 =         attributes.get(i);
        var7C95605C4830717EBBBBB4182924624E_1453651806.addTaint(taint);
        return var7C95605C4830717EBBBBB4182924624E_1453651806;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.718 -0400", hash_original_method = "3B62D6330977637E22606F97FB7DAA33", hash_generated_method = "42CE9548A422EDEA04ACC43F4E317089")
    public AttrImpl getAttributeNodeNS(String namespaceURI, String localName) {
        addTaint(localName.getTaint());
        addTaint(namespaceURI.getTaint());
        int i = indexOfAttributeNS(namespaceURI, localName);
    if(i == -1)        
        {
AttrImpl var540C13E9E156B687226421B24F2DF178_1173405015 =             null;
            var540C13E9E156B687226421B24F2DF178_1173405015.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1173405015;
        } 
AttrImpl var7C95605C4830717EBBBBB4182924624E_1117415959 =         attributes.get(i);
        var7C95605C4830717EBBBBB4182924624E_1117415959.addTaint(taint);
        return var7C95605C4830717EBBBBB4182924624E_1117415959;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.719 -0400", hash_original_method = "DB6D276ECDED2CB7A7381953F02FE1C2", hash_generated_method = "427B624F6E86E57D6ADA0A6D542E5A28")
    @Override
    public NamedNodeMap getAttributes() {
NamedNodeMap var2F1F25D64FCCE96DAC96F4F317CFC68F_1809088924 =         new ElementAttrNamedNodeMapImpl();
        var2F1F25D64FCCE96DAC96F4F317CFC68F_1809088924.addTaint(taint);
        return var2F1F25D64FCCE96DAC96F4F317CFC68F_1809088924;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.719 -0400", hash_original_method = "75972D234B77F7219B8A807D51F2F4BE", hash_generated_method = "882087776F06E845DC9FC4ED6A8EDED2")
     Element getElementById(String name) {
        addTaint(name.getTaint());
for(Attr attr : attributes)
        {
    if(attr.isId() && name.equals(attr.getValue()))            
            {
Element var72A74007B2BE62B849F475C7BDA4658B_249191447 =                 this;
                var72A74007B2BE62B849F475C7BDA4658B_249191447.addTaint(taint);
                return var72A74007B2BE62B849F475C7BDA4658B_249191447;
            } 
        } 
    if(name.equals(getAttribute("id")))        
        {
Element var72A74007B2BE62B849F475C7BDA4658B_689511273 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_689511273.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_689511273;
        } 
for(NodeImpl node : children)
        {
    if(node.getNodeType() == Node.ELEMENT_NODE)            
            {
                Element element = ((ElementImpl) node).getElementById(name);
    if(element != null)                
                {
Element var24D05606CDD4BC4C89F2F5A15C16F343_996604986 =                     element;
                    var24D05606CDD4BC4C89F2F5A15C16F343_996604986.addTaint(taint);
                    return var24D05606CDD4BC4C89F2F5A15C16F343_996604986;
                } 
            } 
        } 
Element var540C13E9E156B687226421B24F2DF178_1266390920 =         null;
        var540C13E9E156B687226421B24F2DF178_1266390920.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1266390920;
        
        
            
                
            
        
        
            
        
        
            
                
                
                    
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.720 -0400", hash_original_method = "6E8835CC5AA6D9440E7C33D346671E0B", hash_generated_method = "83937B48267858B2E34341E7B1809460")
    public NodeList getElementsByTagName(String name) {
        addTaint(name.getTaint());
        NodeListImpl result = new NodeListImpl();
        getElementsByTagName(result, name);
NodeList varDC838461EE2FA0CA4C9BBB70A15456B0_1746188215 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_1746188215.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_1746188215;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.720 -0400", hash_original_method = "A5BCB04504E6AD1A3895B6FBC1B390B7", hash_generated_method = "6AB34098414ED01DC8273640D2219BE7")
    public NodeList getElementsByTagNameNS(String namespaceURI, String localName) {
        addTaint(localName.getTaint());
        addTaint(namespaceURI.getTaint());
        NodeListImpl result = new NodeListImpl();
        getElementsByTagNameNS(result, namespaceURI, localName);
NodeList varDC838461EE2FA0CA4C9BBB70A15456B0_2055768941 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_2055768941.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_2055768941;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.720 -0400", hash_original_method = "006A1593C2EDDFD80B5C8C9A0B08E49A", hash_generated_method = "6337FAC47C5BB55A0FD799A5FBAFDF18")
    @Override
    public String getLocalName() {
String var0C105CFCA4C038265B803794FAF25ADA_907724687 =         namespaceAware ? localName : null;
        var0C105CFCA4C038265B803794FAF25ADA_907724687.addTaint(taint);
        return var0C105CFCA4C038265B803794FAF25ADA_907724687;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.721 -0400", hash_original_method = "1455FE8FE34AF373D39E8278191439A8", hash_generated_method = "444E10CCD2675D3BA6D00AD146302AB0")
    @Override
    public String getNamespaceURI() {
String varE1AD3DA9DA5C12A0140EFDB0C207D211_1016324923 =         namespaceURI;
        varE1AD3DA9DA5C12A0140EFDB0C207D211_1016324923.addTaint(taint);
        return varE1AD3DA9DA5C12A0140EFDB0C207D211_1016324923;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.721 -0400", hash_original_method = "24A50BD0D938263A925A0CD0D8B09D61", hash_generated_method = "08E0009B292C7F5DD7203FB5F85CAA69")
    @Override
    public String getNodeName() {
String var0185ABA4FAF03BC080B20EB22D240587_1351663232 =         getTagName();
        var0185ABA4FAF03BC080B20EB22D240587_1351663232.addTaint(taint);
        return var0185ABA4FAF03BC080B20EB22D240587_1351663232;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.721 -0400", hash_original_method = "8EDB6CFF77634EC46F3FE6E39D5C4072", hash_generated_method = "F7750029622D12C81C6351151DF7CB51")
    public short getNodeType() {
        short var849E6A4D821FC7EAD7B4F4E8E8D698B4_1847137427 = (Node.ELEMENT_NODE);
                short var4F09DAA9D95BCB166A302407A0E0BABE_90202164 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_90202164;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.721 -0400", hash_original_method = "FA5CE5A0FCC0C736D9446FFEBD0CAB9D", hash_generated_method = "3BD580477FD3864B70341DC429DFDD8D")
    @Override
    public String getPrefix() {
String varA4C254BE9F2C23429A8ED0933F20FF43_1049008375 =         prefix;
        varA4C254BE9F2C23429A8ED0933F20FF43_1049008375.addTaint(taint);
        return varA4C254BE9F2C23429A8ED0933F20FF43_1049008375;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.722 -0400", hash_original_method = "84D6D79E2DD8ACB2C7098589FE413C76", hash_generated_method = "969271D895ED3703274444EC1F608A46")
    public String getTagName() {
String var9A4D264969BCDE86E704E715F3380D7F_1640343451 =         prefix != null
                ? prefix + ":" + localName
                : localName;
        var9A4D264969BCDE86E704E715F3380D7F_1640343451.addTaint(taint);
        return var9A4D264969BCDE86E704E715F3380D7F_1640343451;
        
        
                
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.722 -0400", hash_original_method = "6C8F2E9D9AC7653B36D8183C37FDC271", hash_generated_method = "490AB0BDE727CD1AD16EA0C85E5AF677")
    public boolean hasAttribute(String name) {
        addTaint(name.getTaint());
        boolean varC50173A9CDC5847E7BD87795DDE64234_513962702 = (indexOfAttribute(name) != -1);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2016502580 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2016502580;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.722 -0400", hash_original_method = "A72242585FC8C818B78134FE05A6EE18", hash_generated_method = "7B788A26149527FBCE37760D1B98FA24")
    public boolean hasAttributeNS(String namespaceURI, String localName) {
        addTaint(localName.getTaint());
        addTaint(namespaceURI.getTaint());
        boolean varB3FDC9435A39662CF94B7D396A030223_1959332349 = (indexOfAttributeNS(namespaceURI, localName) != -1);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_242333544 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_242333544;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.723 -0400", hash_original_method = "F148456BA584CDD324D3AD480B7851B4", hash_generated_method = "887546AF5EF7462D5EAAF5340A3666ED")
    @Override
    public boolean hasAttributes() {
        boolean var023FCC7ACE2EDC882BE5D44FA2618023_304487994 = (!attributes.isEmpty());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_741815218 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_741815218;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.723 -0400", hash_original_method = "8DBF320E88520709ECE3A3A8169ED4DA", hash_generated_method = "6AC75651C06A7E611407FDC0CDF4E6F6")
    public void removeAttribute(String name) throws DOMException {
        addTaint(name.getTaint());
        int i = indexOfAttribute(name);
    if(i != -1)        
        {
            attributes.remove(i);
        } 
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.723 -0400", hash_original_method = "DB944C5E777E2AB6A4CA622A526DBBB8", hash_generated_method = "FEA79F59F34902D96B9DAA44A63C7EFE")
    public void removeAttributeNS(String namespaceURI, String localName) throws DOMException {
        addTaint(localName.getTaint());
        addTaint(namespaceURI.getTaint());
        int i = indexOfAttributeNS(namespaceURI, localName);
    if(i != -1)        
        {
            attributes.remove(i);
        } 
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.724 -0400", hash_original_method = "48A4F4D8663A7BAF5C33913CE98C9411", hash_generated_method = "06D9A1E706348B07EAE31454BB5CE12D")
    public Attr removeAttributeNode(Attr oldAttr) throws DOMException {
        addTaint(oldAttr.getTaint());
        AttrImpl oldAttrImpl = (AttrImpl) oldAttr;
    if(oldAttrImpl.getOwnerElement() != this)        
        {
            DOMException var3037D207B3884CE4BA891B1452240016_470429461 = new DOMException(DOMException.NOT_FOUND_ERR, null);
            var3037D207B3884CE4BA891B1452240016_470429461.addTaint(taint);
            throw var3037D207B3884CE4BA891B1452240016_470429461;
        } 
        attributes.remove(oldAttrImpl);
        oldAttrImpl.ownerElement = null;
Attr var3775D3B1F75DA32B22BBB9002AEB7B4D_1278454176 =         oldAttrImpl;
        var3775D3B1F75DA32B22BBB9002AEB7B4D_1278454176.addTaint(taint);
        return var3775D3B1F75DA32B22BBB9002AEB7B4D_1278454176;
        
        
        
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.724 -0400", hash_original_method = "6DCEAAD8535FDF367A6D4293F8DE36CE", hash_generated_method = "C8CD6756AAF26BF30CAA070A9FA26AE8")
    public void setAttribute(String name, String value) throws DOMException {
        addTaint(value.getTaint());
        addTaint(name.getTaint());
        Attr attr = getAttributeNode(name);
    if(attr == null)        
        {
            attr = document.createAttribute(name);
            setAttributeNode(attr);
        } 
        attr.setValue(value);
        
        
        
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.725 -0400", hash_original_method = "F2270012ECC9DDE7A199A2B08906CDAC", hash_generated_method = "FBE6A15A6F88FF11A126D70F3D0F070F")
    public void setAttributeNS(String namespaceURI, String qualifiedName,
            String value) throws DOMException {
        addTaint(value.getTaint());
        addTaint(qualifiedName.getTaint());
        addTaint(namespaceURI.getTaint());
        Attr attr = getAttributeNodeNS(namespaceURI, qualifiedName);
    if(attr == null)        
        {
            attr = document.createAttributeNS(namespaceURI, qualifiedName);
            setAttributeNodeNS(attr);
        } 
        attr.setValue(value);
        
        
        
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.726 -0400", hash_original_method = "2863AD660D70C60FE387E2DF61C003C1", hash_generated_method = "AB4538D09B96AFF221A5C3314F8E1519")
    public Attr setAttributeNode(Attr newAttr) throws DOMException {
        addTaint(newAttr.getTaint());
        AttrImpl newAttrImpl = (AttrImpl) newAttr;
    if(newAttrImpl.document != this.document)        
        {
            DOMException varA328C7C3947948BA7A5CD8E93B74AC3F_177302664 = new DOMException(DOMException.WRONG_DOCUMENT_ERR, null);
            varA328C7C3947948BA7A5CD8E93B74AC3F_177302664.addTaint(taint);
            throw varA328C7C3947948BA7A5CD8E93B74AC3F_177302664;
        } 
    if(newAttrImpl.getOwnerElement() != null)        
        {
            DOMException var88F1473FE85EA34355EEAC08237D24C9_1208669481 = new DOMException(DOMException.INUSE_ATTRIBUTE_ERR, null);
            var88F1473FE85EA34355EEAC08237D24C9_1208669481.addTaint(taint);
            throw var88F1473FE85EA34355EEAC08237D24C9_1208669481;
        } 
        AttrImpl oldAttrImpl = null;
        int i = indexOfAttribute(newAttr.getName());
    if(i != -1)        
        {
            oldAttrImpl = attributes.get(i);
            attributes.remove(i);
        } 
        attributes.add(newAttrImpl);
        newAttrImpl.ownerElement = this;
Attr var3775D3B1F75DA32B22BBB9002AEB7B4D_311723304 =         oldAttrImpl;
        var3775D3B1F75DA32B22BBB9002AEB7B4D_311723304.addTaint(taint);
        return var3775D3B1F75DA32B22BBB9002AEB7B4D_311723304;
        
        
        
            
        
        
            
        
        
        
        
            
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.726 -0400", hash_original_method = "1229E8AF3668CCD52190CAB83AB0EAC8", hash_generated_method = "885DC14DA2449D7E43C86EA9F34A6F1F")
    public Attr setAttributeNodeNS(Attr newAttr) throws DOMException {
        addTaint(newAttr.getTaint());
        AttrImpl newAttrImpl = (AttrImpl) newAttr;
    if(newAttrImpl.document != this.document)        
        {
            DOMException varA328C7C3947948BA7A5CD8E93B74AC3F_1772429872 = new DOMException(DOMException.WRONG_DOCUMENT_ERR, null);
            varA328C7C3947948BA7A5CD8E93B74AC3F_1772429872.addTaint(taint);
            throw varA328C7C3947948BA7A5CD8E93B74AC3F_1772429872;
        } 
    if(newAttrImpl.getOwnerElement() != null)        
        {
            DOMException var88F1473FE85EA34355EEAC08237D24C9_4625614 = new DOMException(DOMException.INUSE_ATTRIBUTE_ERR, null);
            var88F1473FE85EA34355EEAC08237D24C9_4625614.addTaint(taint);
            throw var88F1473FE85EA34355EEAC08237D24C9_4625614;
        } 
        AttrImpl oldAttrImpl = null;
        int i = indexOfAttributeNS(newAttr.getNamespaceURI(), newAttr.getLocalName());
    if(i != -1)        
        {
            oldAttrImpl = attributes.get(i);
            attributes.remove(i);
        } 
        attributes.add(newAttrImpl);
        newAttrImpl.ownerElement = this;
Attr var3775D3B1F75DA32B22BBB9002AEB7B4D_1545324552 =         oldAttrImpl;
        var3775D3B1F75DA32B22BBB9002AEB7B4D_1545324552.addTaint(taint);
        return var3775D3B1F75DA32B22BBB9002AEB7B4D_1545324552;
        
        
        
            
        
        
            
        
        
        
        
            
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.727 -0400", hash_original_method = "3E19055116AC2D87625766EB1DC83913", hash_generated_method = "756E644F22A977734EE8F4F9494CEE85")
    @Override
    public void setPrefix(String prefix) {
        this.prefix = validatePrefix(prefix, namespaceAware, namespaceURI);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.727 -0400", hash_original_method = "C51D6ACA797563231B3A9D05774313B4", hash_generated_method = "B161CDFD33A79F24B7CAC24EF1B38EC1")
    public TypeInfo getSchemaTypeInfo() {
TypeInfo varD8306E17977CA965B5A597153127CF99_1024512777 =         NULL_TYPE_INFO;
        varD8306E17977CA965B5A597153127CF99_1024512777.addTaint(taint);
        return varD8306E17977CA965B5A597153127CF99_1024512777;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.728 -0400", hash_original_method = "E2D0D43F42925D6B235314ECDF3F88D2", hash_generated_method = "25DA0ED7751DC34DB8EFA3892F8C9CEA")
    public void setIdAttribute(String name, boolean isId) throws DOMException {
        addTaint(isId);
        addTaint(name.getTaint());
        AttrImpl attr = getAttributeNode(name);
    if(attr == null)        
        {
            DOMException varF520CBE99CED5AE0ABE891BD75BC8253_300369419 = new DOMException(DOMException.NOT_FOUND_ERR,
                    "No such attribute: " + name);
            varF520CBE99CED5AE0ABE891BD75BC8253_300369419.addTaint(taint);
            throw varF520CBE99CED5AE0ABE891BD75BC8253_300369419;
        } 
        attr.isId = isId;
        
        
        
            
                    
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.728 -0400", hash_original_method = "EB4B24B3B95C74A915F87535C0F28019", hash_generated_method = "26064CB6E4268CA795ED1DEFA86AD653")
    public void setIdAttributeNS(String namespaceURI, String localName,
            boolean isId) throws DOMException {
        addTaint(isId);
        addTaint(localName.getTaint());
        addTaint(namespaceURI.getTaint());
        AttrImpl attr = getAttributeNodeNS(namespaceURI, localName);
    if(attr == null)        
        {
            DOMException varAA76FF2BB95FBA640CA88FB79BF61B55_1097423798 = new DOMException(DOMException.NOT_FOUND_ERR,
                    "No such attribute: " + namespaceURI +  " " + localName);
            varAA76FF2BB95FBA640CA88FB79BF61B55_1097423798.addTaint(taint);
            throw varAA76FF2BB95FBA640CA88FB79BF61B55_1097423798;
        } 
        attr.isId = isId;
        
        
        
            
                    
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.729 -0400", hash_original_method = "D45D107EAB7744EE0777BE918C2E0DD2", hash_generated_method = "533E2E2BBCC05C909A86114E31CA2FE5")
    public void setIdAttributeNode(Attr idAttr, boolean isId) throws DOMException {
        addTaint(isId);
        addTaint(idAttr.getTaint());
        ((AttrImpl) idAttr).isId = isId;
        
        
    }

    
    public class ElementAttrNamedNodeMapImpl implements NamedNodeMap {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.729 -0400", hash_original_method = "4DE56E7A278FE2CED469184A8A1F6E47", hash_generated_method = "4DE56E7A278FE2CED469184A8A1F6E47")
        public ElementAttrNamedNodeMapImpl ()
        {
            
        }


        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.729 -0400", hash_original_method = "FF1F71CDD63994FD93D39F9EA196EECF", hash_generated_method = "927E6F6C81F8DBB730453C212380FFAB")
        public int getLength() {
            int var2BA4DDA632844E61F1A45CEAA31A3058_1214875205 = (ElementImpl.this.attributes.size());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_334328654 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_334328654;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.729 -0400", hash_original_method = "DC316EFAFE6C9719F9A6712C7C0724A1", hash_generated_method = "38F2EE32AF6283E70D89E5A6460D3552")
        private int indexOfItem(String name) {
            addTaint(name.getTaint());
            int var290A0D30DB39182CF8030D6E8C485EE1_458615727 = (ElementImpl.this.indexOfAttribute(name));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_815203036 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_815203036;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.730 -0400", hash_original_method = "258D65E063DA88D4950E14323AAE31E6", hash_generated_method = "DEA434E227F86C40E69CA4ACCCEAEE7F")
        private int indexOfItemNS(String namespaceURI, String localName) {
            addTaint(localName.getTaint());
            addTaint(namespaceURI.getTaint());
            int var4B7949E0BB8942FDC8AE686E2BE0BF69_1204688453 = (ElementImpl.this.indexOfAttributeNS(namespaceURI, localName));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_655390380 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_655390380;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.730 -0400", hash_original_method = "5386255E2AB4AB2C7C1C9B01DBB08720", hash_generated_method = "D52B995D4FF976EB997E3DFB4A240260")
        public Node getNamedItem(String name) {
            addTaint(name.getTaint());
Node var9ADABF9109EA948045E3287DA63B2172_559698621 =             ElementImpl.this.getAttributeNode(name);
            var9ADABF9109EA948045E3287DA63B2172_559698621.addTaint(taint);
            return var9ADABF9109EA948045E3287DA63B2172_559698621;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.730 -0400", hash_original_method = "4A42E6CB38C61058D8EEC911A360EDF7", hash_generated_method = "7C43294F497C0FD4699567051222AACB")
        public Node getNamedItemNS(String namespaceURI, String localName) {
            addTaint(localName.getTaint());
            addTaint(namespaceURI.getTaint());
Node varB35F758FF012FCC2266EB315BF242EEB_667936371 =             ElementImpl.this.getAttributeNodeNS(namespaceURI, localName);
            varB35F758FF012FCC2266EB315BF242EEB_667936371.addTaint(taint);
            return varB35F758FF012FCC2266EB315BF242EEB_667936371;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.731 -0400", hash_original_method = "F60AE240A182D1B0B5E9071C74F61EEF", hash_generated_method = "2254DAC01C523A7AAC991C39709EFC44")
        public Node item(int index) {
            addTaint(index);
Node var6CCA2ADA67582134BC804BD1B87DB50C_1481364251 =             ElementImpl.this.attributes.get(index);
            var6CCA2ADA67582134BC804BD1B87DB50C_1481364251.addTaint(taint);
            return var6CCA2ADA67582134BC804BD1B87DB50C_1481364251;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.731 -0400", hash_original_method = "92540DEE2EDFF119EB60FC0ECC313E2F", hash_generated_method = "80981433C1C676BB73F29FDC83B9A64A")
        public Node removeNamedItem(String name) throws DOMException {
            addTaint(name.getTaint());
            int i = indexOfItem(name);
    if(i == -1)            
            {
                DOMException var3037D207B3884CE4BA891B1452240016_111332805 = new DOMException(DOMException.NOT_FOUND_ERR, null);
                var3037D207B3884CE4BA891B1452240016_111332805.addTaint(taint);
                throw var3037D207B3884CE4BA891B1452240016_111332805;
            } 
Node var2AEFB529CCC2154CEF677927EA1DFE1E_1931956850 =             ElementImpl.this.attributes.remove(i);
            var2AEFB529CCC2154CEF677927EA1DFE1E_1931956850.addTaint(taint);
            return var2AEFB529CCC2154CEF677927EA1DFE1E_1931956850;
            
            
            
                
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.732 -0400", hash_original_method = "5947BF939F7AE1F8A4D4CDE5B6951547", hash_generated_method = "70B5FF43A2226F12F0D4437F70D29B45")
        public Node removeNamedItemNS(String namespaceURI, String localName) throws DOMException {
            addTaint(localName.getTaint());
            addTaint(namespaceURI.getTaint());
            int i = indexOfItemNS(namespaceURI, localName);
    if(i == -1)            
            {
                DOMException var3037D207B3884CE4BA891B1452240016_1724582477 = new DOMException(DOMException.NOT_FOUND_ERR, null);
                var3037D207B3884CE4BA891B1452240016_1724582477.addTaint(taint);
                throw var3037D207B3884CE4BA891B1452240016_1724582477;
            } 
Node var2AEFB529CCC2154CEF677927EA1DFE1E_1973176 =             ElementImpl.this.attributes.remove(i);
            var2AEFB529CCC2154CEF677927EA1DFE1E_1973176.addTaint(taint);
            return var2AEFB529CCC2154CEF677927EA1DFE1E_1973176;
            
            
            
                
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.732 -0400", hash_original_method = "5D95624F12CAAE730B29BD47EADFC40A", hash_generated_method = "8E3F8A2C51B9BDF5B475110BCF174CB6")
        public Node setNamedItem(Node arg) throws DOMException {
            addTaint(arg.getTaint());
    if(!(arg instanceof Attr))            
            {
                DOMException varB08FA5F9049CD84DC42B7238D3D303A7_1913644975 = new DOMException(DOMException.HIERARCHY_REQUEST_ERR, null);
                varB08FA5F9049CD84DC42B7238D3D303A7_1913644975.addTaint(taint);
                throw varB08FA5F9049CD84DC42B7238D3D303A7_1913644975;
            } 
Node varDFB5B58B24EDFC6C7E746D19DE1542A0_412246717 =             ElementImpl.this.setAttributeNode((Attr)arg);
            varDFB5B58B24EDFC6C7E746D19DE1542A0_412246717.addTaint(taint);
            return varDFB5B58B24EDFC6C7E746D19DE1542A0_412246717;
            
            
                
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.732 -0400", hash_original_method = "74F8A255439FFDD82EF1D14936D16522", hash_generated_method = "F4546190C8B022D5027AD6897DFA8843")
        public Node setNamedItemNS(Node arg) throws DOMException {
            addTaint(arg.getTaint());
    if(!(arg instanceof Attr))            
            {
                DOMException varB08FA5F9049CD84DC42B7238D3D303A7_932740343 = new DOMException(DOMException.HIERARCHY_REQUEST_ERR, null);
                varB08FA5F9049CD84DC42B7238D3D303A7_932740343.addTaint(taint);
                throw varB08FA5F9049CD84DC42B7238D3D303A7_932740343;
            } 
Node varE4B6F74CB59D33AAAB6E39C6E793D3E9_1607766878 =             ElementImpl.this.setAttributeNodeNS((Attr)arg);
            varE4B6F74CB59D33AAAB6E39C6E793D3E9_1607766878.addTaint(taint);
            return varE4B6F74CB59D33AAAB6E39C6E793D3E9_1607766878;
            
            
                
            
            
        }

        
    }


    
}

