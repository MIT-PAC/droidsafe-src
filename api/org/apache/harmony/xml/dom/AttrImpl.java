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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.498 -0400", hash_original_field = "1CAC9B8EBA5F808398072B53F245F98F", hash_generated_field = "76E0E26209E3FD48A5AAFEA346976ED4")

    ElementImpl ownerElement;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.498 -0400", hash_original_field = "CC3516B3E43CD7E179D4697F53030A2A", hash_generated_field = "51C2A9724BD7E8242CDE48AAFEBC7178")

    boolean isId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.498 -0400", hash_original_field = "CEC00E48144CD3C5B0000055F3D7FF26", hash_generated_field = "6DED3D0909D027805E22F95BA58508AE")

    boolean namespaceAware;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.498 -0400", hash_original_field = "5295F3E9C46315AF1C2132265086FA24", hash_generated_field = "5B184DBF8D93287A0F0C8BC78758CAB7")

    String namespaceURI;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.498 -0400", hash_original_field = "851F5AC9941D720844D143ED9CFCF60A", hash_generated_field = "D07D332701F9B92847141D46D8B2C7CF")

    String prefix;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.498 -0400", hash_original_field = "E62B9ECBD883C26642197A7DC8246D3C", hash_generated_field = "69F110BF2CAEA76B4D1C533597A16878")

    String localName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.499 -0400", hash_original_field = "4A6115291F4697A52956FCF092552C27", hash_generated_field = "5ACD84A65DA4E81BC72CF65FE413D36D")

    private String value = "";
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.499 -0400", hash_original_method = "EF27CA8C1828BF4AC2BE0D84F97E8864", hash_generated_method = "52BC6CFCF3E571E2CA85B2E9409292BE")
      AttrImpl(DocumentImpl document, String namespaceURI, String qualifiedName) {
        super(document);
        addTaint(qualifiedName.getTaint());
        addTaint(namespaceURI.getTaint());
        addTaint(document.getTaint());
        setNameNS(this, namespaceURI, qualifiedName);
        // ---------- Original Method ----------
        //setNameNS(this, namespaceURI, qualifiedName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.499 -0400", hash_original_method = "2F6F1C08CF036A2A7F978D7F391927BA", hash_generated_method = "1AECBFB595BB1BDB0438AA504D17877B")
      AttrImpl(DocumentImpl document, String name) {
        super(document);
        addTaint(name.getTaint());
        addTaint(document.getTaint());
        setName(this, name);
        // ---------- Original Method ----------
        //setName(this, name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.499 -0400", hash_original_method = "006A1593C2EDDFD80B5C8C9A0B08E49A", hash_generated_method = "69FE226397A351F1CF20A54CBA1E5085")
    @Override
    public String getLocalName() {
String var0C105CFCA4C038265B803794FAF25ADA_193622155 =         namespaceAware ? localName : null;
        var0C105CFCA4C038265B803794FAF25ADA_193622155.addTaint(taint);
        return var0C105CFCA4C038265B803794FAF25ADA_193622155;
        // ---------- Original Method ----------
        //return namespaceAware ? localName : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.500 -0400", hash_original_method = "2829D25C85859024022592A3A30C0BDC", hash_generated_method = "DF0C083A70322BEC851DA48C94F5ECF5")
    public String getName() {
String var9A4D264969BCDE86E704E715F3380D7F_420880508 =         prefix != null
                ? prefix + ":" + localName
                : localName;
        var9A4D264969BCDE86E704E715F3380D7F_420880508.addTaint(taint);
        return var9A4D264969BCDE86E704E715F3380D7F_420880508;
        // ---------- Original Method ----------
        //return prefix != null
                //? prefix + ":" + localName
                //: localName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.500 -0400", hash_original_method = "1455FE8FE34AF373D39E8278191439A8", hash_generated_method = "29A6A75582FA1B67419B626C09C36050")
    @Override
    public String getNamespaceURI() {
String varE1AD3DA9DA5C12A0140EFDB0C207D211_1046255581 =         namespaceURI;
        varE1AD3DA9DA5C12A0140EFDB0C207D211_1046255581.addTaint(taint);
        return varE1AD3DA9DA5C12A0140EFDB0C207D211_1046255581;
        // ---------- Original Method ----------
        //return namespaceURI;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.500 -0400", hash_original_method = "C003064639FF6BDC59C8E14D85630B7A", hash_generated_method = "64828A3C55C6886E183E9A7EE8F6C729")
    @Override
    public String getNodeName() {
String var674CAC8E34E5C6C4D042792BFADA198C_918740100 =         getName();
        var674CAC8E34E5C6C4D042792BFADA198C_918740100.addTaint(taint);
        return var674CAC8E34E5C6C4D042792BFADA198C_918740100;
        // ---------- Original Method ----------
        //return getName();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.501 -0400", hash_original_method = "66DF12C09699AD1D686D4988F262C066", hash_generated_method = "BF69654CAAD3E8F905EF8C08CD9C0B78")
    public short getNodeType() {
        short var81E2408ABA385D0C72BB240BE1072E91_1431476741 = (Node.ATTRIBUTE_NODE);
                short var4F09DAA9D95BCB166A302407A0E0BABE_344477841 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_344477841;
        // ---------- Original Method ----------
        //return Node.ATTRIBUTE_NODE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.501 -0400", hash_original_method = "4300CB9DE8CDB8D1025C33AA1D8539DA", hash_generated_method = "C1635F1EEEBCAF9BEFB66D64B163F761")
    @Override
    public String getNodeValue() {
String var6DBE2853D166F687DF81AB969B11FE23_752673773 =         getValue();
        var6DBE2853D166F687DF81AB969B11FE23_752673773.addTaint(taint);
        return var6DBE2853D166F687DF81AB969B11FE23_752673773;
        // ---------- Original Method ----------
        //return getValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.501 -0400", hash_original_method = "B2B2C7739C0F8FABC1AEF26C1D9AEC3F", hash_generated_method = "A23B28BD925AF20B4D1E5496D435E71B")
    public Element getOwnerElement() {
Element varF2FFFBC50ED5D7DAE2585BB0FEC9DC9F_267250411 =         ownerElement;
        varF2FFFBC50ED5D7DAE2585BB0FEC9DC9F_267250411.addTaint(taint);
        return varF2FFFBC50ED5D7DAE2585BB0FEC9DC9F_267250411;
        // ---------- Original Method ----------
        //return ownerElement;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.502 -0400", hash_original_method = "FA5CE5A0FCC0C736D9446FFEBD0CAB9D", hash_generated_method = "F95DF634C4CA87A1BDBD2AD34C84C6DF")
    @Override
    public String getPrefix() {
String varA4C254BE9F2C23429A8ED0933F20FF43_1398504989 =         prefix;
        varA4C254BE9F2C23429A8ED0933F20FF43_1398504989.addTaint(taint);
        return varA4C254BE9F2C23429A8ED0933F20FF43_1398504989;
        // ---------- Original Method ----------
        //return prefix;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.502 -0400", hash_original_method = "AB2D74F2DBFDF90175205031E5C24288", hash_generated_method = "DC3EB13FB42B7A13446527994FB1CA8C")
    public boolean getSpecified() {
        boolean var5A3052C00A2FA16AC26BF371CC86520C_51012296 = (value != null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1814328529 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1814328529;
        // ---------- Original Method ----------
        //return value != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.502 -0400", hash_original_method = "CFCF943D36987E569CAB72593E604904", hash_generated_method = "86D2E53C56D8AA84587BB7D09561A26E")
    public String getValue() {
String varAF280DA2BC37D8BE783D8499160168DE_576954685 =         value;
        varAF280DA2BC37D8BE783D8499160168DE_576954685.addTaint(taint);
        return varAF280DA2BC37D8BE783D8499160168DE_576954685;
        // ---------- Original Method ----------
        //return value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.503 -0400", hash_original_method = "3E19055116AC2D87625766EB1DC83913", hash_generated_method = "756E644F22A977734EE8F4F9494CEE85")
    @Override
    public void setPrefix(String prefix) {
        this.prefix = validatePrefix(prefix, namespaceAware, namespaceURI);
        // ---------- Original Method ----------
        //this.prefix = validatePrefix(prefix, namespaceAware, namespaceURI);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.503 -0400", hash_original_method = "32019E33BF64530F6370A7D9E04CDBBC", hash_generated_method = "373507266CE99450E905DA9FE496A1CE")
    public void setValue(String value) throws DOMException {
        this.value = value;
        // ---------- Original Method ----------
        //this.value = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.503 -0400", hash_original_method = "C51D6ACA797563231B3A9D05774313B4", hash_generated_method = "24269CF38EB55575BA980B184B39FD11")
    public TypeInfo getSchemaTypeInfo() {
TypeInfo varD8306E17977CA965B5A597153127CF99_643961027 =         NULL_TYPE_INFO;
        varD8306E17977CA965B5A597153127CF99_643961027.addTaint(taint);
        return varD8306E17977CA965B5A597153127CF99_643961027;
        // ---------- Original Method ----------
        //return NULL_TYPE_INFO;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.504 -0400", hash_original_method = "042EF4BE6689EE05C98757A02B7F892C", hash_generated_method = "D067AEC8E728A79C7D6D38F014379DD5")
    public boolean isId() {
        boolean varCC3516B3E43CD7E179D4697F53030A2A_1565569026 = (isId);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_127850805 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_127850805;
        // ---------- Original Method ----------
        //return isId;
    }

    
}

