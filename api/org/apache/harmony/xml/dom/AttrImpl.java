package org.apache.harmony.xml.dom;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import org.w3c.dom.Attr;
import org.w3c.dom.DOMException;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.TypeInfo;

public final class AttrImpl extends NodeImpl implements Attr {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.133 -0400", hash_original_field = "1CAC9B8EBA5F808398072B53F245F98F", hash_generated_field = "76E0E26209E3FD48A5AAFEA346976ED4")

    ElementImpl ownerElement;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.133 -0400", hash_original_field = "CC3516B3E43CD7E179D4697F53030A2A", hash_generated_field = "51C2A9724BD7E8242CDE48AAFEBC7178")

    boolean isId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.133 -0400", hash_original_field = "CEC00E48144CD3C5B0000055F3D7FF26", hash_generated_field = "6DED3D0909D027805E22F95BA58508AE")

    boolean namespaceAware;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.133 -0400", hash_original_field = "5295F3E9C46315AF1C2132265086FA24", hash_generated_field = "5B184DBF8D93287A0F0C8BC78758CAB7")

    String namespaceURI;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.133 -0400", hash_original_field = "851F5AC9941D720844D143ED9CFCF60A", hash_generated_field = "D07D332701F9B92847141D46D8B2C7CF")

    String prefix;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.133 -0400", hash_original_field = "E62B9ECBD883C26642197A7DC8246D3C", hash_generated_field = "69F110BF2CAEA76B4D1C533597A16878")

    String localName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.133 -0400", hash_original_field = "4A6115291F4697A52956FCF092552C27", hash_generated_field = "5ACD84A65DA4E81BC72CF65FE413D36D")

    private String value = "";
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.133 -0400", hash_original_method = "EF27CA8C1828BF4AC2BE0D84F97E8864", hash_generated_method = "52BC6CFCF3E571E2CA85B2E9409292BE")
      AttrImpl(DocumentImpl document, String namespaceURI, String qualifiedName) {
        super(document);
        addTaint(qualifiedName.getTaint());
        addTaint(namespaceURI.getTaint());
        addTaint(document.getTaint());
        setNameNS(this, namespaceURI, qualifiedName);
        // ---------- Original Method ----------
        //setNameNS(this, namespaceURI, qualifiedName);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.134 -0400", hash_original_method = "2F6F1C08CF036A2A7F978D7F391927BA", hash_generated_method = "1AECBFB595BB1BDB0438AA504D17877B")
      AttrImpl(DocumentImpl document, String name) {
        super(document);
        addTaint(name.getTaint());
        addTaint(document.getTaint());
        setName(this, name);
        // ---------- Original Method ----------
        //setName(this, name);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.134 -0400", hash_original_method = "006A1593C2EDDFD80B5C8C9A0B08E49A", hash_generated_method = "EA79DB6FDC11ECF99C1030CB6FD2E7DC")
    @Override
    public String getLocalName() {
String var0C105CFCA4C038265B803794FAF25ADA_372308552 =         namespaceAware ? localName : null;
        var0C105CFCA4C038265B803794FAF25ADA_372308552.addTaint(taint);
        return var0C105CFCA4C038265B803794FAF25ADA_372308552;
        // ---------- Original Method ----------
        //return namespaceAware ? localName : null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.134 -0400", hash_original_method = "2829D25C85859024022592A3A30C0BDC", hash_generated_method = "CB41D8EC95E6BECC22101D2B010A5AAA")
    public String getName() {
String var9A4D264969BCDE86E704E715F3380D7F_1008977174 =         prefix != null
                ? prefix + ":" + localName
                : localName;
        var9A4D264969BCDE86E704E715F3380D7F_1008977174.addTaint(taint);
        return var9A4D264969BCDE86E704E715F3380D7F_1008977174;
        // ---------- Original Method ----------
        //return prefix != null
                //? prefix + ":" + localName
                //: localName;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.134 -0400", hash_original_method = "1455FE8FE34AF373D39E8278191439A8", hash_generated_method = "AF6656656FA8E8B05EADEBA117B77419")
    @Override
    public String getNamespaceURI() {
String varE1AD3DA9DA5C12A0140EFDB0C207D211_832559486 =         namespaceURI;
        varE1AD3DA9DA5C12A0140EFDB0C207D211_832559486.addTaint(taint);
        return varE1AD3DA9DA5C12A0140EFDB0C207D211_832559486;
        // ---------- Original Method ----------
        //return namespaceURI;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.135 -0400", hash_original_method = "C003064639FF6BDC59C8E14D85630B7A", hash_generated_method = "3D1F792F13CD6EDCCDB6EF001A192D81")
    @Override
    public String getNodeName() {
String var674CAC8E34E5C6C4D042792BFADA198C_1285285389 =         getName();
        var674CAC8E34E5C6C4D042792BFADA198C_1285285389.addTaint(taint);
        return var674CAC8E34E5C6C4D042792BFADA198C_1285285389;
        // ---------- Original Method ----------
        //return getName();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.135 -0400", hash_original_method = "66DF12C09699AD1D686D4988F262C066", hash_generated_method = "C2242CB13FCF072CA9AB8487CA0C8A00")
    public short getNodeType() {
        short var81E2408ABA385D0C72BB240BE1072E91_1244863705 = (Node.ATTRIBUTE_NODE);
                short var4F09DAA9D95BCB166A302407A0E0BABE_808640290 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_808640290;
        // ---------- Original Method ----------
        //return Node.ATTRIBUTE_NODE;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.135 -0400", hash_original_method = "4300CB9DE8CDB8D1025C33AA1D8539DA", hash_generated_method = "BF1E042960E37D2A30CA244E2854EE36")
    @Override
    public String getNodeValue() {
String var6DBE2853D166F687DF81AB969B11FE23_973497631 =         getValue();
        var6DBE2853D166F687DF81AB969B11FE23_973497631.addTaint(taint);
        return var6DBE2853D166F687DF81AB969B11FE23_973497631;
        // ---------- Original Method ----------
        //return getValue();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.135 -0400", hash_original_method = "B2B2C7739C0F8FABC1AEF26C1D9AEC3F", hash_generated_method = "39AE65352F7BF15FCABB58F1BB3F0773")
    public Element getOwnerElement() {
Element varF2FFFBC50ED5D7DAE2585BB0FEC9DC9F_1921625929 =         ownerElement;
        varF2FFFBC50ED5D7DAE2585BB0FEC9DC9F_1921625929.addTaint(taint);
        return varF2FFFBC50ED5D7DAE2585BB0FEC9DC9F_1921625929;
        // ---------- Original Method ----------
        //return ownerElement;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.136 -0400", hash_original_method = "FA5CE5A0FCC0C736D9446FFEBD0CAB9D", hash_generated_method = "B728B328BB84668F7649248F0A8FD703")
    @Override
    public String getPrefix() {
String varA4C254BE9F2C23429A8ED0933F20FF43_1825624175 =         prefix;
        varA4C254BE9F2C23429A8ED0933F20FF43_1825624175.addTaint(taint);
        return varA4C254BE9F2C23429A8ED0933F20FF43_1825624175;
        // ---------- Original Method ----------
        //return prefix;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.136 -0400", hash_original_method = "AB2D74F2DBFDF90175205031E5C24288", hash_generated_method = "290AB9C3C8D79EE9EAEAE96A541B7153")
    public boolean getSpecified() {
        boolean var5A3052C00A2FA16AC26BF371CC86520C_1553993451 = (value != null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_49091509 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_49091509;
        // ---------- Original Method ----------
        //return value != null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.136 -0400", hash_original_method = "CFCF943D36987E569CAB72593E604904", hash_generated_method = "05EAB61AA14335DB133D79CB0776D1C7")
    public String getValue() {
String varAF280DA2BC37D8BE783D8499160168DE_2115271986 =         value;
        varAF280DA2BC37D8BE783D8499160168DE_2115271986.addTaint(taint);
        return varAF280DA2BC37D8BE783D8499160168DE_2115271986;
        // ---------- Original Method ----------
        //return value;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.137 -0400", hash_original_method = "3E19055116AC2D87625766EB1DC83913", hash_generated_method = "756E644F22A977734EE8F4F9494CEE85")
    @Override
    public void setPrefix(String prefix) {
        this.prefix = validatePrefix(prefix, namespaceAware, namespaceURI);
        // ---------- Original Method ----------
        //this.prefix = validatePrefix(prefix, namespaceAware, namespaceURI);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.138 -0400", hash_original_method = "32019E33BF64530F6370A7D9E04CDBBC", hash_generated_method = "373507266CE99450E905DA9FE496A1CE")
    public void setValue(String value) throws DOMException {
        this.value = value;
        // ---------- Original Method ----------
        //this.value = value;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.138 -0400", hash_original_method = "C51D6ACA797563231B3A9D05774313B4", hash_generated_method = "4DED17D72A53D8DCD67CA47E5CBDFA1F")
    public TypeInfo getSchemaTypeInfo() {
TypeInfo varD8306E17977CA965B5A597153127CF99_497075060 =         NULL_TYPE_INFO;
        varD8306E17977CA965B5A597153127CF99_497075060.addTaint(taint);
        return varD8306E17977CA965B5A597153127CF99_497075060;
        // ---------- Original Method ----------
        //return NULL_TYPE_INFO;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.139 -0400", hash_original_method = "042EF4BE6689EE05C98757A02B7F892C", hash_generated_method = "B2DE7798A19DECAF23FFCF300F811A6E")
    public boolean isId() {
        boolean varCC3516B3E43CD7E179D4697F53030A2A_826426865 = (isId);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2075870005 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2075870005;
        // ---------- Original Method ----------
        //return isId;
    }

    
}

