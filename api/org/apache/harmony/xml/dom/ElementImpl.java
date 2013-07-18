package org.apache.harmony.xml.dom;

// Droidsafe Imports
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

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class ElementImpl extends InnerNodeImpl implements Element {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.433 -0400", hash_original_field = "CEC00E48144CD3C5B0000055F3D7FF26", hash_generated_field = "6DED3D0909D027805E22F95BA58508AE")

    boolean namespaceAware;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.433 -0400", hash_original_field = "5295F3E9C46315AF1C2132265086FA24", hash_generated_field = "5B184DBF8D93287A0F0C8BC78758CAB7")

    String namespaceURI;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.433 -0400", hash_original_field = "851F5AC9941D720844D143ED9CFCF60A", hash_generated_field = "D07D332701F9B92847141D46D8B2C7CF")

    String prefix;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.433 -0400", hash_original_field = "E62B9ECBD883C26642197A7DC8246D3C", hash_generated_field = "69F110BF2CAEA76B4D1C533597A16878")

    String localName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.433 -0400", hash_original_field = "D7461AFEBA4ED0DC3AB3D12F77C8DA48", hash_generated_field = "370A7E27C76BC902168F8323D6CEB238")

    private List<AttrImpl> attributes = new ArrayList<AttrImpl>();
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.434 -0400", hash_original_method = "E83037DBBA9A213D892AFBAECFD42006", hash_generated_method = "FB62429B0AFFA4514DE2F18DD89625B5")
      ElementImpl(DocumentImpl document, String namespaceURI, String qualifiedName) {
        super(document);
        addTaint(qualifiedName.getTaint());
        addTaint(namespaceURI.getTaint());
        addTaint(document.getTaint());
        setNameNS(this, namespaceURI, qualifiedName);
        // ---------- Original Method ----------
        //setNameNS(this, namespaceURI, qualifiedName);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.434 -0400", hash_original_method = "D2CD0310D5C8F85822C82439B7C2ED0A", hash_generated_method = "E79762F2053F1B3B8BC49C769FD1DFBF")
      ElementImpl(DocumentImpl document, String name) {
        super(document);
        addTaint(name.getTaint());
        addTaint(document.getTaint());
        setName(this, name);
        // ---------- Original Method ----------
        //setName(this, name);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.434 -0400", hash_original_method = "33812125B5F046930FB02168EEB43D40", hash_generated_method = "6727D892520F6F45795C5DAFF3C22C0C")
    private int indexOfAttribute(String name) {
        addTaint(name.getTaint());
for(int i = 0;i < attributes.size();i++)
        {
            AttrImpl attr = attributes.get(i);
            if(Objects.equal(name, attr.getNodeName()))            
            {
                int var865C0C0B4AB0E063E5CAA3387C1A8741_191484433 = (i);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1909184125 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1909184125;
            } //End block
        } //End block
        int var6BB61E3B7BCE0931DA574D19D1D82C88_368842829 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1502055117 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1502055117;
        // ---------- Original Method ----------
        //for (int i = 0; i < attributes.size(); i++) {
            //AttrImpl attr = attributes.get(i);
            //if (Objects.equal(name, attr.getNodeName())) {
                //return i;
            //}
        //}
        //return -1;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.435 -0400", hash_original_method = "7BDB91D541F3C8F5E0B377A9C520D55B", hash_generated_method = "C23587EB85F2C03FFA1AC37642DD2F29")
    private int indexOfAttributeNS(String namespaceURI, String localName) {
        addTaint(localName.getTaint());
        addTaint(namespaceURI.getTaint());
for(int i = 0;i < attributes.size();i++)
        {
            AttrImpl attr = attributes.get(i);
            if(Objects.equal(namespaceURI, attr.getNamespaceURI())
                    && Objects.equal(localName, attr.getLocalName()))            
            {
                int var865C0C0B4AB0E063E5CAA3387C1A8741_1874559018 = (i);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1148370884 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1148370884;
            } //End block
        } //End block
        int var6BB61E3B7BCE0931DA574D19D1D82C88_698516026 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_75716587 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_75716587;
        // ---------- Original Method ----------
        //for (int i = 0; i < attributes.size(); i++) {
            //AttrImpl attr = attributes.get(i);
            //if (Objects.equal(namespaceURI, attr.getNamespaceURI())
                    //&& Objects.equal(localName, attr.getLocalName())) {
                //return i;
            //}
        //}
        //return -1;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.436 -0400", hash_original_method = "813C4DD10F102D6D885192D956222478", hash_generated_method = "1964188F8F3045DE1FBA7EE32C1BA7E7")
    public String getAttribute(String name) {
        addTaint(name.getTaint());
        Attr attr = getAttributeNode(name);
        if(attr == null)        
        {
String var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1749872984 =             "";
            var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1749872984.addTaint(taint);
            return var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1749872984;
        } //End block
String varB8B9307C4FA9D699C8FD1776B5AD3762_195512448 =         attr.getValue();
        varB8B9307C4FA9D699C8FD1776B5AD3762_195512448.addTaint(taint);
        return varB8B9307C4FA9D699C8FD1776B5AD3762_195512448;
        // ---------- Original Method ----------
        //Attr attr = getAttributeNode(name);
        //if (attr == null) {
            //return "";
        //}
        //return attr.getValue();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.436 -0400", hash_original_method = "2AD352ABD4B75CC40A48A87FB5C80EF1", hash_generated_method = "1836484BD5BE5CA2CD7F9B7846E713D7")
    public String getAttributeNS(String namespaceURI, String localName) {
        addTaint(localName.getTaint());
        addTaint(namespaceURI.getTaint());
        Attr attr = getAttributeNodeNS(namespaceURI, localName);
        if(attr == null)        
        {
String var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_2008215748 =             "";
            var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_2008215748.addTaint(taint);
            return var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_2008215748;
        } //End block
String varB8B9307C4FA9D699C8FD1776B5AD3762_1138820150 =         attr.getValue();
        varB8B9307C4FA9D699C8FD1776B5AD3762_1138820150.addTaint(taint);
        return varB8B9307C4FA9D699C8FD1776B5AD3762_1138820150;
        // ---------- Original Method ----------
        //Attr attr = getAttributeNodeNS(namespaceURI, localName);
        //if (attr == null) {
            //return "";
        //}
        //return attr.getValue();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.436 -0400", hash_original_method = "83D3ED81624F77A7E713E4996ABE0363", hash_generated_method = "0396C6927521C3946BCCCFBEE8B2EF84")
    public AttrImpl getAttributeNode(String name) {
        addTaint(name.getTaint());
        int i = indexOfAttribute(name);
        if(i == -1)        
        {
AttrImpl var540C13E9E156B687226421B24F2DF178_1343169361 =             null;
            var540C13E9E156B687226421B24F2DF178_1343169361.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1343169361;
        } //End block
AttrImpl var7C95605C4830717EBBBBB4182924624E_2133751443 =         attributes.get(i);
        var7C95605C4830717EBBBBB4182924624E_2133751443.addTaint(taint);
        return var7C95605C4830717EBBBBB4182924624E_2133751443;
        // ---------- Original Method ----------
        //int i = indexOfAttribute(name);
        //if (i == -1) {
            //return null;
        //}
        //return attributes.get(i);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.437 -0400", hash_original_method = "3B62D6330977637E22606F97FB7DAA33", hash_generated_method = "6855DA5269E0793382EFF6C2E37B7201")
    public AttrImpl getAttributeNodeNS(String namespaceURI, String localName) {
        addTaint(localName.getTaint());
        addTaint(namespaceURI.getTaint());
        int i = indexOfAttributeNS(namespaceURI, localName);
        if(i == -1)        
        {
AttrImpl var540C13E9E156B687226421B24F2DF178_649973800 =             null;
            var540C13E9E156B687226421B24F2DF178_649973800.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_649973800;
        } //End block
AttrImpl var7C95605C4830717EBBBBB4182924624E_9697707 =         attributes.get(i);
        var7C95605C4830717EBBBBB4182924624E_9697707.addTaint(taint);
        return var7C95605C4830717EBBBBB4182924624E_9697707;
        // ---------- Original Method ----------
        //int i = indexOfAttributeNS(namespaceURI, localName);
        //if (i == -1) {
            //return null;
        //}
        //return attributes.get(i);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.437 -0400", hash_original_method = "DB6D276ECDED2CB7A7381953F02FE1C2", hash_generated_method = "F920F84D4531EAA649D9E336856BD377")
    @Override
    public NamedNodeMap getAttributes() {
NamedNodeMap var2F1F25D64FCCE96DAC96F4F317CFC68F_117334526 =         new ElementAttrNamedNodeMapImpl();
        var2F1F25D64FCCE96DAC96F4F317CFC68F_117334526.addTaint(taint);
        return var2F1F25D64FCCE96DAC96F4F317CFC68F_117334526;
        // ---------- Original Method ----------
        //return new ElementAttrNamedNodeMapImpl();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.437 -0400", hash_original_method = "75972D234B77F7219B8A807D51F2F4BE", hash_generated_method = "580BCAF0F2BA2A5D47DEC49D569AA2B8")
     Element getElementById(String name) {
        addTaint(name.getTaint());
for(Attr attr : attributes)
        {
            if(attr.isId() && name.equals(attr.getValue()))            
            {
Element var72A74007B2BE62B849F475C7BDA4658B_1894768380 =                 this;
                var72A74007B2BE62B849F475C7BDA4658B_1894768380.addTaint(taint);
                return var72A74007B2BE62B849F475C7BDA4658B_1894768380;
            } //End block
        } //End block
        if(name.equals(getAttribute("id")))        
        {
Element var72A74007B2BE62B849F475C7BDA4658B_1358226839 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1358226839.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1358226839;
        } //End block
for(NodeImpl node : children)
        {
            if(node.getNodeType() == Node.ELEMENT_NODE)            
            {
                Element element = ((ElementImpl) node).getElementById(name);
                if(element != null)                
                {
Element var24D05606CDD4BC4C89F2F5A15C16F343_985871084 =                     element;
                    var24D05606CDD4BC4C89F2F5A15C16F343_985871084.addTaint(taint);
                    return var24D05606CDD4BC4C89F2F5A15C16F343_985871084;
                } //End block
            } //End block
        } //End block
Element var540C13E9E156B687226421B24F2DF178_1724116370 =         null;
        var540C13E9E156B687226421B24F2DF178_1724116370.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1724116370;
        // ---------- Original Method ----------
        //for (Attr attr : attributes) {
            //if (attr.isId() && name.equals(attr.getValue())) {
                //return this;
            //}
        //}
        //if (name.equals(getAttribute("id"))) {
            //return this;
        //}
        //for (NodeImpl node : children) {
            //if (node.getNodeType() == Node.ELEMENT_NODE) {
                //Element element = ((ElementImpl) node).getElementById(name);
                //if (element != null) {
                    //return element;
                //}
            //}
        //}
        //return null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.438 -0400", hash_original_method = "6E8835CC5AA6D9440E7C33D346671E0B", hash_generated_method = "1501347DC787345C04EB3579223522EF")
    public NodeList getElementsByTagName(String name) {
        addTaint(name.getTaint());
        NodeListImpl result = new NodeListImpl();
        getElementsByTagName(result, name);
NodeList varDC838461EE2FA0CA4C9BBB70A15456B0_696716918 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_696716918.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_696716918;
        // ---------- Original Method ----------
        //NodeListImpl result = new NodeListImpl();
        //getElementsByTagName(result, name);
        //return result;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.447 -0400", hash_original_method = "A5BCB04504E6AD1A3895B6FBC1B390B7", hash_generated_method = "B1EDFA7AD9DCDBF6303BF4131D419D27")
    public NodeList getElementsByTagNameNS(String namespaceURI, String localName) {
        addTaint(localName.getTaint());
        addTaint(namespaceURI.getTaint());
        NodeListImpl result = new NodeListImpl();
        getElementsByTagNameNS(result, namespaceURI, localName);
NodeList varDC838461EE2FA0CA4C9BBB70A15456B0_1451033804 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_1451033804.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_1451033804;
        // ---------- Original Method ----------
        //NodeListImpl result = new NodeListImpl();
        //getElementsByTagNameNS(result, namespaceURI, localName);
        //return result;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.448 -0400", hash_original_method = "006A1593C2EDDFD80B5C8C9A0B08E49A", hash_generated_method = "0C2494E7E0AE1057ADCCE10FED50B105")
    @Override
    public String getLocalName() {
String var0C105CFCA4C038265B803794FAF25ADA_2080180376 =         namespaceAware ? localName : null;
        var0C105CFCA4C038265B803794FAF25ADA_2080180376.addTaint(taint);
        return var0C105CFCA4C038265B803794FAF25ADA_2080180376;
        // ---------- Original Method ----------
        //return namespaceAware ? localName : null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.448 -0400", hash_original_method = "1455FE8FE34AF373D39E8278191439A8", hash_generated_method = "C5FCBEF10A39672AFF39D6C0D3502954")
    @Override
    public String getNamespaceURI() {
String varE1AD3DA9DA5C12A0140EFDB0C207D211_712806946 =         namespaceURI;
        varE1AD3DA9DA5C12A0140EFDB0C207D211_712806946.addTaint(taint);
        return varE1AD3DA9DA5C12A0140EFDB0C207D211_712806946;
        // ---------- Original Method ----------
        //return namespaceURI;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.448 -0400", hash_original_method = "24A50BD0D938263A925A0CD0D8B09D61", hash_generated_method = "7425C03E53EBBC807D44F2780FBDF996")
    @Override
    public String getNodeName() {
String var0185ABA4FAF03BC080B20EB22D240587_599656623 =         getTagName();
        var0185ABA4FAF03BC080B20EB22D240587_599656623.addTaint(taint);
        return var0185ABA4FAF03BC080B20EB22D240587_599656623;
        // ---------- Original Method ----------
        //return getTagName();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.449 -0400", hash_original_method = "8EDB6CFF77634EC46F3FE6E39D5C4072", hash_generated_method = "508E4F4B3F1A0BDE472FF5F8227CDDA5")
    public short getNodeType() {
        short var849E6A4D821FC7EAD7B4F4E8E8D698B4_1773380993 = (Node.ELEMENT_NODE);
                short var4F09DAA9D95BCB166A302407A0E0BABE_1674857032 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_1674857032;
        // ---------- Original Method ----------
        //return Node.ELEMENT_NODE;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.449 -0400", hash_original_method = "FA5CE5A0FCC0C736D9446FFEBD0CAB9D", hash_generated_method = "335F182B090F26C85CAF8F987F73000A")
    @Override
    public String getPrefix() {
String varA4C254BE9F2C23429A8ED0933F20FF43_565954274 =         prefix;
        varA4C254BE9F2C23429A8ED0933F20FF43_565954274.addTaint(taint);
        return varA4C254BE9F2C23429A8ED0933F20FF43_565954274;
        // ---------- Original Method ----------
        //return prefix;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.449 -0400", hash_original_method = "84D6D79E2DD8ACB2C7098589FE413C76", hash_generated_method = "86ED27FDF0DA16B108ECD057D41A8B14")
    public String getTagName() {
String var9A4D264969BCDE86E704E715F3380D7F_18358781 =         prefix != null
                ? prefix + ":" + localName
                : localName;
        var9A4D264969BCDE86E704E715F3380D7F_18358781.addTaint(taint);
        return var9A4D264969BCDE86E704E715F3380D7F_18358781;
        // ---------- Original Method ----------
        //return prefix != null
                //? prefix + ":" + localName
                //: localName;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.449 -0400", hash_original_method = "6C8F2E9D9AC7653B36D8183C37FDC271", hash_generated_method = "DE43093D389AB88616A9A64D9789E4DF")
    public boolean hasAttribute(String name) {
        addTaint(name.getTaint());
        boolean varC50173A9CDC5847E7BD87795DDE64234_1312021540 = (indexOfAttribute(name) != -1);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1680236468 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1680236468;
        // ---------- Original Method ----------
        //return indexOfAttribute(name) != -1;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.449 -0400", hash_original_method = "A72242585FC8C818B78134FE05A6EE18", hash_generated_method = "BFE916D6BE811A675E4B8F5F02F1C38A")
    public boolean hasAttributeNS(String namespaceURI, String localName) {
        addTaint(localName.getTaint());
        addTaint(namespaceURI.getTaint());
        boolean varB3FDC9435A39662CF94B7D396A030223_527949146 = (indexOfAttributeNS(namespaceURI, localName) != -1);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_143529745 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_143529745;
        // ---------- Original Method ----------
        //return indexOfAttributeNS(namespaceURI, localName) != -1;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.449 -0400", hash_original_method = "F148456BA584CDD324D3AD480B7851B4", hash_generated_method = "0505A17CE79270A21E419A88B2BE0084")
    @Override
    public boolean hasAttributes() {
        boolean var023FCC7ACE2EDC882BE5D44FA2618023_1264953802 = (!attributes.isEmpty());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1245114438 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1245114438;
        // ---------- Original Method ----------
        //return !attributes.isEmpty();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.450 -0400", hash_original_method = "8DBF320E88520709ECE3A3A8169ED4DA", hash_generated_method = "6AC75651C06A7E611407FDC0CDF4E6F6")
    public void removeAttribute(String name) throws DOMException {
        addTaint(name.getTaint());
        int i = indexOfAttribute(name);
        if(i != -1)        
        {
            attributes.remove(i);
        } //End block
        // ---------- Original Method ----------
        //int i = indexOfAttribute(name);
        //if (i != -1) {
            //attributes.remove(i);
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.450 -0400", hash_original_method = "DB944C5E777E2AB6A4CA622A526DBBB8", hash_generated_method = "FEA79F59F34902D96B9DAA44A63C7EFE")
    public void removeAttributeNS(String namespaceURI, String localName) throws DOMException {
        addTaint(localName.getTaint());
        addTaint(namespaceURI.getTaint());
        int i = indexOfAttributeNS(namespaceURI, localName);
        if(i != -1)        
        {
            attributes.remove(i);
        } //End block
        // ---------- Original Method ----------
        //int i = indexOfAttributeNS(namespaceURI, localName);
        //if (i != -1) {
            //attributes.remove(i);
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.450 -0400", hash_original_method = "48A4F4D8663A7BAF5C33913CE98C9411", hash_generated_method = "D2F4493217BC9E42BAD7D941F77691A2")
    public Attr removeAttributeNode(Attr oldAttr) throws DOMException {
        addTaint(oldAttr.getTaint());
        AttrImpl oldAttrImpl = (AttrImpl) oldAttr;
        if(oldAttrImpl.getOwnerElement() != this)        
        {
            DOMException var3037D207B3884CE4BA891B1452240016_252134475 = new DOMException(DOMException.NOT_FOUND_ERR, null);
            var3037D207B3884CE4BA891B1452240016_252134475.addTaint(taint);
            throw var3037D207B3884CE4BA891B1452240016_252134475;
        } //End block
        attributes.remove(oldAttrImpl);
        oldAttrImpl.ownerElement = null;
Attr var3775D3B1F75DA32B22BBB9002AEB7B4D_1067557574 =         oldAttrImpl;
        var3775D3B1F75DA32B22BBB9002AEB7B4D_1067557574.addTaint(taint);
        return var3775D3B1F75DA32B22BBB9002AEB7B4D_1067557574;
        // ---------- Original Method ----------
        //AttrImpl oldAttrImpl = (AttrImpl) oldAttr;
        //if (oldAttrImpl.getOwnerElement() != this) {
            //throw new DOMException(DOMException.NOT_FOUND_ERR, null);
        //}
        //attributes.remove(oldAttrImpl);
        //oldAttrImpl.ownerElement = null;
        //return oldAttrImpl;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.450 -0400", hash_original_method = "6DCEAAD8535FDF367A6D4293F8DE36CE", hash_generated_method = "C8CD6756AAF26BF30CAA070A9FA26AE8")
    public void setAttribute(String name, String value) throws DOMException {
        addTaint(value.getTaint());
        addTaint(name.getTaint());
        Attr attr = getAttributeNode(name);
        if(attr == null)        
        {
            attr = document.createAttribute(name);
            setAttributeNode(attr);
        } //End block
        attr.setValue(value);
        // ---------- Original Method ----------
        //Attr attr = getAttributeNode(name);
        //if (attr == null) {
            //attr = document.createAttribute(name);
            //setAttributeNode(attr);
        //}
        //attr.setValue(value);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.450 -0400", hash_original_method = "F2270012ECC9DDE7A199A2B08906CDAC", hash_generated_method = "FBE6A15A6F88FF11A126D70F3D0F070F")
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
        } //End block
        attr.setValue(value);
        // ---------- Original Method ----------
        //Attr attr = getAttributeNodeNS(namespaceURI, qualifiedName);
        //if (attr == null) {
            //attr = document.createAttributeNS(namespaceURI, qualifiedName);
            //setAttributeNodeNS(attr);
        //}
        //attr.setValue(value);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.451 -0400", hash_original_method = "2863AD660D70C60FE387E2DF61C003C1", hash_generated_method = "95CE06188A93881D03DD30738886840D")
    public Attr setAttributeNode(Attr newAttr) throws DOMException {
        addTaint(newAttr.getTaint());
        AttrImpl newAttrImpl = (AttrImpl) newAttr;
        if(newAttrImpl.document != this.document)        
        {
            DOMException varA328C7C3947948BA7A5CD8E93B74AC3F_1600268444 = new DOMException(DOMException.WRONG_DOCUMENT_ERR, null);
            varA328C7C3947948BA7A5CD8E93B74AC3F_1600268444.addTaint(taint);
            throw varA328C7C3947948BA7A5CD8E93B74AC3F_1600268444;
        } //End block
        if(newAttrImpl.getOwnerElement() != null)        
        {
            DOMException var88F1473FE85EA34355EEAC08237D24C9_1500312229 = new DOMException(DOMException.INUSE_ATTRIBUTE_ERR, null);
            var88F1473FE85EA34355EEAC08237D24C9_1500312229.addTaint(taint);
            throw var88F1473FE85EA34355EEAC08237D24C9_1500312229;
        } //End block
        AttrImpl oldAttrImpl = null;
        int i = indexOfAttribute(newAttr.getName());
        if(i != -1)        
        {
            oldAttrImpl = attributes.get(i);
            attributes.remove(i);
        } //End block
        attributes.add(newAttrImpl);
        newAttrImpl.ownerElement = this;
Attr var3775D3B1F75DA32B22BBB9002AEB7B4D_1250133924 =         oldAttrImpl;
        var3775D3B1F75DA32B22BBB9002AEB7B4D_1250133924.addTaint(taint);
        return var3775D3B1F75DA32B22BBB9002AEB7B4D_1250133924;
        // ---------- Original Method ----------
        //AttrImpl newAttrImpl = (AttrImpl) newAttr;
        //if (newAttrImpl.document != this.document) {
            //throw new DOMException(DOMException.WRONG_DOCUMENT_ERR, null);
        //}
        //if (newAttrImpl.getOwnerElement() != null) {
            //throw new DOMException(DOMException.INUSE_ATTRIBUTE_ERR, null);
        //}
        //AttrImpl oldAttrImpl = null;
        //int i = indexOfAttribute(newAttr.getName());
        //if (i != -1) {
            //oldAttrImpl = attributes.get(i);
            //attributes.remove(i);
        //}
        //attributes.add(newAttrImpl);
        //newAttrImpl.ownerElement = this;
        //return oldAttrImpl;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.451 -0400", hash_original_method = "1229E8AF3668CCD52190CAB83AB0EAC8", hash_generated_method = "B2523C8FC7ACE37846042D2672B1E1C9")
    public Attr setAttributeNodeNS(Attr newAttr) throws DOMException {
        addTaint(newAttr.getTaint());
        AttrImpl newAttrImpl = (AttrImpl) newAttr;
        if(newAttrImpl.document != this.document)        
        {
            DOMException varA328C7C3947948BA7A5CD8E93B74AC3F_1707650776 = new DOMException(DOMException.WRONG_DOCUMENT_ERR, null);
            varA328C7C3947948BA7A5CD8E93B74AC3F_1707650776.addTaint(taint);
            throw varA328C7C3947948BA7A5CD8E93B74AC3F_1707650776;
        } //End block
        if(newAttrImpl.getOwnerElement() != null)        
        {
            DOMException var88F1473FE85EA34355EEAC08237D24C9_427569104 = new DOMException(DOMException.INUSE_ATTRIBUTE_ERR, null);
            var88F1473FE85EA34355EEAC08237D24C9_427569104.addTaint(taint);
            throw var88F1473FE85EA34355EEAC08237D24C9_427569104;
        } //End block
        AttrImpl oldAttrImpl = null;
        int i = indexOfAttributeNS(newAttr.getNamespaceURI(), newAttr.getLocalName());
        if(i != -1)        
        {
            oldAttrImpl = attributes.get(i);
            attributes.remove(i);
        } //End block
        attributes.add(newAttrImpl);
        newAttrImpl.ownerElement = this;
Attr var3775D3B1F75DA32B22BBB9002AEB7B4D_1547060134 =         oldAttrImpl;
        var3775D3B1F75DA32B22BBB9002AEB7B4D_1547060134.addTaint(taint);
        return var3775D3B1F75DA32B22BBB9002AEB7B4D_1547060134;
        // ---------- Original Method ----------
        //AttrImpl newAttrImpl = (AttrImpl) newAttr;
        //if (newAttrImpl.document != this.document) {
            //throw new DOMException(DOMException.WRONG_DOCUMENT_ERR, null);
        //}
        //if (newAttrImpl.getOwnerElement() != null) {
            //throw new DOMException(DOMException.INUSE_ATTRIBUTE_ERR, null);
        //}
        //AttrImpl oldAttrImpl = null;
        //int i = indexOfAttributeNS(newAttr.getNamespaceURI(), newAttr.getLocalName());
        //if (i != -1) {
            //oldAttrImpl = attributes.get(i);
            //attributes.remove(i);
        //}
        //attributes.add(newAttrImpl);
        //newAttrImpl.ownerElement = this;
        //return oldAttrImpl;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.451 -0400", hash_original_method = "3E19055116AC2D87625766EB1DC83913", hash_generated_method = "756E644F22A977734EE8F4F9494CEE85")
    @Override
    public void setPrefix(String prefix) {
        this.prefix = validatePrefix(prefix, namespaceAware, namespaceURI);
        // ---------- Original Method ----------
        //this.prefix = validatePrefix(prefix, namespaceAware, namespaceURI);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.451 -0400", hash_original_method = "C51D6ACA797563231B3A9D05774313B4", hash_generated_method = "2814A3F0944D85C40018A5B8A6184D2A")
    public TypeInfo getSchemaTypeInfo() {
TypeInfo varD8306E17977CA965B5A597153127CF99_1344190057 =         NULL_TYPE_INFO;
        varD8306E17977CA965B5A597153127CF99_1344190057.addTaint(taint);
        return varD8306E17977CA965B5A597153127CF99_1344190057;
        // ---------- Original Method ----------
        //return NULL_TYPE_INFO;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.451 -0400", hash_original_method = "E2D0D43F42925D6B235314ECDF3F88D2", hash_generated_method = "C885248AF3480A9158A7695F52B9F929")
    public void setIdAttribute(String name, boolean isId) throws DOMException {
        addTaint(isId);
        addTaint(name.getTaint());
        AttrImpl attr = getAttributeNode(name);
        if(attr == null)        
        {
            DOMException varF520CBE99CED5AE0ABE891BD75BC8253_214754497 = new DOMException(DOMException.NOT_FOUND_ERR,
                    "No such attribute: " + name);
            varF520CBE99CED5AE0ABE891BD75BC8253_214754497.addTaint(taint);
            throw varF520CBE99CED5AE0ABE891BD75BC8253_214754497;
        } //End block
        attr.isId = isId;
        // ---------- Original Method ----------
        //AttrImpl attr = getAttributeNode(name);
        //if (attr == null) {
            //throw new DOMException(DOMException.NOT_FOUND_ERR,
                    //"No such attribute: " + name);
        //}
        //attr.isId = isId;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.451 -0400", hash_original_method = "EB4B24B3B95C74A915F87535C0F28019", hash_generated_method = "2E0CAF020D55D305631F4D74AD2BC390")
    public void setIdAttributeNS(String namespaceURI, String localName,
            boolean isId) throws DOMException {
        addTaint(isId);
        addTaint(localName.getTaint());
        addTaint(namespaceURI.getTaint());
        AttrImpl attr = getAttributeNodeNS(namespaceURI, localName);
        if(attr == null)        
        {
            DOMException varAA76FF2BB95FBA640CA88FB79BF61B55_891932815 = new DOMException(DOMException.NOT_FOUND_ERR,
                    "No such attribute: " + namespaceURI +  " " + localName);
            varAA76FF2BB95FBA640CA88FB79BF61B55_891932815.addTaint(taint);
            throw varAA76FF2BB95FBA640CA88FB79BF61B55_891932815;
        } //End block
        attr.isId = isId;
        // ---------- Original Method ----------
        //AttrImpl attr = getAttributeNodeNS(namespaceURI, localName);
        //if (attr == null) {
            //throw new DOMException(DOMException.NOT_FOUND_ERR,
                    //"No such attribute: " + namespaceURI +  " " + localName);
        //}
        //attr.isId = isId;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.452 -0400", hash_original_method = "D45D107EAB7744EE0777BE918C2E0DD2", hash_generated_method = "533E2E2BBCC05C909A86114E31CA2FE5")
    public void setIdAttributeNode(Attr idAttr, boolean isId) throws DOMException {
        addTaint(isId);
        addTaint(idAttr.getTaint());
        ((AttrImpl) idAttr).isId = isId;
        // ---------- Original Method ----------
        //((AttrImpl) idAttr).isId = isId;
    }

    
    public class ElementAttrNamedNodeMapImpl implements NamedNodeMap {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.452 -0400", hash_original_method = "4DE56E7A278FE2CED469184A8A1F6E47", hash_generated_method = "4DE56E7A278FE2CED469184A8A1F6E47")
        public ElementAttrNamedNodeMapImpl ()
        {
            //Synthesized constructor
        }


                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.452 -0400", hash_original_method = "FF1F71CDD63994FD93D39F9EA196EECF", hash_generated_method = "04338050A372E46B8A56A9C17D90551E")
        public int getLength() {
            int var2BA4DDA632844E61F1A45CEAA31A3058_164551782 = (ElementImpl.this.attributes.size());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_868206550 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_868206550;
            // ---------- Original Method ----------
            //return ElementImpl.this.attributes.size();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.452 -0400", hash_original_method = "DC316EFAFE6C9719F9A6712C7C0724A1", hash_generated_method = "44DDA3BBF423BA5D44B87882CC4DC3BB")
        private int indexOfItem(String name) {
            addTaint(name.getTaint());
            int var290A0D30DB39182CF8030D6E8C485EE1_1920713333 = (ElementImpl.this.indexOfAttribute(name));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2147349857 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2147349857;
            // ---------- Original Method ----------
            //return ElementImpl.this.indexOfAttribute(name);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.452 -0400", hash_original_method = "258D65E063DA88D4950E14323AAE31E6", hash_generated_method = "4F0270995B1607F637F78DDB7282E0FF")
        private int indexOfItemNS(String namespaceURI, String localName) {
            addTaint(localName.getTaint());
            addTaint(namespaceURI.getTaint());
            int var4B7949E0BB8942FDC8AE686E2BE0BF69_1780799179 = (ElementImpl.this.indexOfAttributeNS(namespaceURI, localName));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2092861424 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2092861424;
            // ---------- Original Method ----------
            //return ElementImpl.this.indexOfAttributeNS(namespaceURI, localName);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.452 -0400", hash_original_method = "5386255E2AB4AB2C7C1C9B01DBB08720", hash_generated_method = "38C71251818ACA4967C844F3118515C1")
        public Node getNamedItem(String name) {
            addTaint(name.getTaint());
Node var9ADABF9109EA948045E3287DA63B2172_802264240 =             ElementImpl.this.getAttributeNode(name);
            var9ADABF9109EA948045E3287DA63B2172_802264240.addTaint(taint);
            return var9ADABF9109EA948045E3287DA63B2172_802264240;
            // ---------- Original Method ----------
            //return ElementImpl.this.getAttributeNode(name);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.452 -0400", hash_original_method = "4A42E6CB38C61058D8EEC911A360EDF7", hash_generated_method = "468A5C39E5884B9AACDACF0B8BE96378")
        public Node getNamedItemNS(String namespaceURI, String localName) {
            addTaint(localName.getTaint());
            addTaint(namespaceURI.getTaint());
Node varB35F758FF012FCC2266EB315BF242EEB_1282119526 =             ElementImpl.this.getAttributeNodeNS(namespaceURI, localName);
            varB35F758FF012FCC2266EB315BF242EEB_1282119526.addTaint(taint);
            return varB35F758FF012FCC2266EB315BF242EEB_1282119526;
            // ---------- Original Method ----------
            //return ElementImpl.this.getAttributeNodeNS(namespaceURI, localName);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.452 -0400", hash_original_method = "F60AE240A182D1B0B5E9071C74F61EEF", hash_generated_method = "8B239C261CC1769479BBF6F5AC8B1D9C")
        public Node item(int index) {
            addTaint(index);
Node var6CCA2ADA67582134BC804BD1B87DB50C_2064184411 =             ElementImpl.this.attributes.get(index);
            var6CCA2ADA67582134BC804BD1B87DB50C_2064184411.addTaint(taint);
            return var6CCA2ADA67582134BC804BD1B87DB50C_2064184411;
            // ---------- Original Method ----------
            //return ElementImpl.this.attributes.get(index);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.452 -0400", hash_original_method = "92540DEE2EDFF119EB60FC0ECC313E2F", hash_generated_method = "816B9349ACCBEE44963D77B309C05EF7")
        public Node removeNamedItem(String name) throws DOMException {
            addTaint(name.getTaint());
            int i = indexOfItem(name);
            if(i == -1)            
            {
                DOMException var3037D207B3884CE4BA891B1452240016_575967552 = new DOMException(DOMException.NOT_FOUND_ERR, null);
                var3037D207B3884CE4BA891B1452240016_575967552.addTaint(taint);
                throw var3037D207B3884CE4BA891B1452240016_575967552;
            } //End block
Node var2AEFB529CCC2154CEF677927EA1DFE1E_376966548 =             ElementImpl.this.attributes.remove(i);
            var2AEFB529CCC2154CEF677927EA1DFE1E_376966548.addTaint(taint);
            return var2AEFB529CCC2154CEF677927EA1DFE1E_376966548;
            // ---------- Original Method ----------
            //int i = indexOfItem(name);
            //if (i == -1) {
                //throw new DOMException(DOMException.NOT_FOUND_ERR, null);
            //}
            //return ElementImpl.this.attributes.remove(i);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.452 -0400", hash_original_method = "5947BF939F7AE1F8A4D4CDE5B6951547", hash_generated_method = "D97B8E75208C6641AE856820044B8C0A")
        public Node removeNamedItemNS(String namespaceURI, String localName) throws DOMException {
            addTaint(localName.getTaint());
            addTaint(namespaceURI.getTaint());
            int i = indexOfItemNS(namespaceURI, localName);
            if(i == -1)            
            {
                DOMException var3037D207B3884CE4BA891B1452240016_1917296764 = new DOMException(DOMException.NOT_FOUND_ERR, null);
                var3037D207B3884CE4BA891B1452240016_1917296764.addTaint(taint);
                throw var3037D207B3884CE4BA891B1452240016_1917296764;
            } //End block
Node var2AEFB529CCC2154CEF677927EA1DFE1E_1237118735 =             ElementImpl.this.attributes.remove(i);
            var2AEFB529CCC2154CEF677927EA1DFE1E_1237118735.addTaint(taint);
            return var2AEFB529CCC2154CEF677927EA1DFE1E_1237118735;
            // ---------- Original Method ----------
            //int i = indexOfItemNS(namespaceURI, localName);
            //if (i == -1) {
                //throw new DOMException(DOMException.NOT_FOUND_ERR, null);
            //}
            //return ElementImpl.this.attributes.remove(i);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.453 -0400", hash_original_method = "5D95624F12CAAE730B29BD47EADFC40A", hash_generated_method = "AEE7FAEEB1F04DC48663D2027B5F678C")
        public Node setNamedItem(Node arg) throws DOMException {
            addTaint(arg.getTaint());
            if(!(arg instanceof Attr))            
            {
                DOMException varB08FA5F9049CD84DC42B7238D3D303A7_394204124 = new DOMException(DOMException.HIERARCHY_REQUEST_ERR, null);
                varB08FA5F9049CD84DC42B7238D3D303A7_394204124.addTaint(taint);
                throw varB08FA5F9049CD84DC42B7238D3D303A7_394204124;
            } //End block
Node varDFB5B58B24EDFC6C7E746D19DE1542A0_1903040727 =             ElementImpl.this.setAttributeNode((Attr)arg);
            varDFB5B58B24EDFC6C7E746D19DE1542A0_1903040727.addTaint(taint);
            return varDFB5B58B24EDFC6C7E746D19DE1542A0_1903040727;
            // ---------- Original Method ----------
            //if (!(arg instanceof Attr)) {
                //throw new DOMException(DOMException.HIERARCHY_REQUEST_ERR, null);
            //}
            //return ElementImpl.this.setAttributeNode((Attr)arg);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.453 -0400", hash_original_method = "74F8A255439FFDD82EF1D14936D16522", hash_generated_method = "FB398A2BD2294AEB557B75CD794DA387")
        public Node setNamedItemNS(Node arg) throws DOMException {
            addTaint(arg.getTaint());
            if(!(arg instanceof Attr))            
            {
                DOMException varB08FA5F9049CD84DC42B7238D3D303A7_1539715309 = new DOMException(DOMException.HIERARCHY_REQUEST_ERR, null);
                varB08FA5F9049CD84DC42B7238D3D303A7_1539715309.addTaint(taint);
                throw varB08FA5F9049CD84DC42B7238D3D303A7_1539715309;
            } //End block
Node varE4B6F74CB59D33AAAB6E39C6E793D3E9_1577406235 =             ElementImpl.this.setAttributeNodeNS((Attr)arg);
            varE4B6F74CB59D33AAAB6E39C6E793D3E9_1577406235.addTaint(taint);
            return varE4B6F74CB59D33AAAB6E39C6E793D3E9_1577406235;
            // ---------- Original Method ----------
            //if (!(arg instanceof Attr)) {
                //throw new DOMException(DOMException.HIERARCHY_REQUEST_ERR, null);
            //}
            //return ElementImpl.this.setAttributeNodeNS((Attr)arg);
        }

        
    }


    
}

