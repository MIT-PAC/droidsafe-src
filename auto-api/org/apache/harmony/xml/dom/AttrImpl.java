package org.apache.harmony.xml.dom;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.w3c.dom.Attr;
import org.w3c.dom.DOMException;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.TypeInfo;

public final class AttrImpl extends NodeImpl implements Attr {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.409 -0400", hash_original_field = "1CAC9B8EBA5F808398072B53F245F98F", hash_generated_field = "76E0E26209E3FD48A5AAFEA346976ED4")

    ElementImpl ownerElement;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.409 -0400", hash_original_field = "CC3516B3E43CD7E179D4697F53030A2A", hash_generated_field = "51C2A9724BD7E8242CDE48AAFEBC7178")

    boolean isId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.409 -0400", hash_original_field = "CEC00E48144CD3C5B0000055F3D7FF26", hash_generated_field = "6DED3D0909D027805E22F95BA58508AE")

    boolean namespaceAware;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.409 -0400", hash_original_field = "5295F3E9C46315AF1C2132265086FA24", hash_generated_field = "5B184DBF8D93287A0F0C8BC78758CAB7")

    String namespaceURI;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.409 -0400", hash_original_field = "851F5AC9941D720844D143ED9CFCF60A", hash_generated_field = "D07D332701F9B92847141D46D8B2C7CF")

    String prefix;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.409 -0400", hash_original_field = "E62B9ECBD883C26642197A7DC8246D3C", hash_generated_field = "69F110BF2CAEA76B4D1C533597A16878")

    String localName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.409 -0400", hash_original_field = "4A6115291F4697A52956FCF092552C27", hash_generated_field = "5ACD84A65DA4E81BC72CF65FE413D36D")

    private String value = "";
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.413 -0400", hash_original_method = "EF27CA8C1828BF4AC2BE0D84F97E8864", hash_generated_method = "D8D978E3B7D7F4EE10515C46F14D9090")
      AttrImpl(DocumentImpl document, String namespaceURI, String qualifiedName) {
        super(document);
        setNameNS(this, namespaceURI, qualifiedName);
        addTaint(document.getTaint());
        addTaint(namespaceURI.getTaint());
        addTaint(qualifiedName.getTaint());
        // ---------- Original Method ----------
        //setNameNS(this, namespaceURI, qualifiedName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.414 -0400", hash_original_method = "2F6F1C08CF036A2A7F978D7F391927BA", hash_generated_method = "2B237132F5CF54D0353EA9ED4D4207FE")
      AttrImpl(DocumentImpl document, String name) {
        super(document);
        setName(this, name);
        addTaint(document.getTaint());
        addTaint(name.getTaint());
        // ---------- Original Method ----------
        //setName(this, name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.414 -0400", hash_original_method = "006A1593C2EDDFD80B5C8C9A0B08E49A", hash_generated_method = "C3ED92533F1AA1BFD8634E2AC7A88EAC")
    @Override
    public String getLocalName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1536769511 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1536769511 = namespaceAware ? localName : null;
        varB4EAC82CA7396A68D541C85D26508E83_1536769511.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1536769511;
        // ---------- Original Method ----------
        //return namespaceAware ? localName : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.415 -0400", hash_original_method = "2829D25C85859024022592A3A30C0BDC", hash_generated_method = "FE0C08B378E8317AEC4A66D58A907037")
    public String getName() {
        String varB4EAC82CA7396A68D541C85D26508E83_2016825640 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2016825640 = prefix != null
                ? prefix + ":" + localName
                : localName;
        varB4EAC82CA7396A68D541C85D26508E83_2016825640.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2016825640;
        // ---------- Original Method ----------
        //return prefix != null
                //? prefix + ":" + localName
                //: localName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.415 -0400", hash_original_method = "1455FE8FE34AF373D39E8278191439A8", hash_generated_method = "DBFD802F61BD32B65E495EA56C4D9192")
    @Override
    public String getNamespaceURI() {
        String varB4EAC82CA7396A68D541C85D26508E83_1605187625 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1605187625 = namespaceURI;
        varB4EAC82CA7396A68D541C85D26508E83_1605187625.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1605187625;
        // ---------- Original Method ----------
        //return namespaceURI;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.427 -0400", hash_original_method = "C003064639FF6BDC59C8E14D85630B7A", hash_generated_method = "8A6A2B6D6250AE3BAE35D009E5A97893")
    @Override
    public String getNodeName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1127906257 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1127906257 = getName();
        varB4EAC82CA7396A68D541C85D26508E83_1127906257.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1127906257;
        // ---------- Original Method ----------
        //return getName();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.427 -0400", hash_original_method = "66DF12C09699AD1D686D4988F262C066", hash_generated_method = "C29C650EFF659FD33A3626BEBCCD34E7")
    public short getNodeType() {
        short var4F09DAA9D95BCB166A302407A0E0BABE_1845665770 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_1845665770;
        // ---------- Original Method ----------
        //return Node.ATTRIBUTE_NODE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.427 -0400", hash_original_method = "4300CB9DE8CDB8D1025C33AA1D8539DA", hash_generated_method = "A778F239E7DE04722D860D9F0B330C1C")
    @Override
    public String getNodeValue() {
        String varB4EAC82CA7396A68D541C85D26508E83_928758427 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_928758427 = getValue();
        varB4EAC82CA7396A68D541C85D26508E83_928758427.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_928758427;
        // ---------- Original Method ----------
        //return getValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.428 -0400", hash_original_method = "B2B2C7739C0F8FABC1AEF26C1D9AEC3F", hash_generated_method = "5CA7F939450562632C60684DEDF5B562")
    public Element getOwnerElement() {
        Element varB4EAC82CA7396A68D541C85D26508E83_254930657 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_254930657 = ownerElement;
        varB4EAC82CA7396A68D541C85D26508E83_254930657.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_254930657;
        // ---------- Original Method ----------
        //return ownerElement;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.428 -0400", hash_original_method = "FA5CE5A0FCC0C736D9446FFEBD0CAB9D", hash_generated_method = "1DC04EEB557C664414D56EB483C8F13B")
    @Override
    public String getPrefix() {
        String varB4EAC82CA7396A68D541C85D26508E83_74659680 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_74659680 = prefix;
        varB4EAC82CA7396A68D541C85D26508E83_74659680.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_74659680;
        // ---------- Original Method ----------
        //return prefix;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.428 -0400", hash_original_method = "AB2D74F2DBFDF90175205031E5C24288", hash_generated_method = "6C884E5D2783503EC1188D48133B4AC7")
    public boolean getSpecified() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1694001418 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1694001418;
        // ---------- Original Method ----------
        //return value != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.429 -0400", hash_original_method = "CFCF943D36987E569CAB72593E604904", hash_generated_method = "AA4E76474A88591E03CCCFFF817EB609")
    public String getValue() {
        String varB4EAC82CA7396A68D541C85D26508E83_2055773038 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2055773038 = value;
        varB4EAC82CA7396A68D541C85D26508E83_2055773038.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2055773038;
        // ---------- Original Method ----------
        //return value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.429 -0400", hash_original_method = "3E19055116AC2D87625766EB1DC83913", hash_generated_method = "756E644F22A977734EE8F4F9494CEE85")
    @Override
    public void setPrefix(String prefix) {
        this.prefix = validatePrefix(prefix, namespaceAware, namespaceURI);
        // ---------- Original Method ----------
        //this.prefix = validatePrefix(prefix, namespaceAware, namespaceURI);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.429 -0400", hash_original_method = "32019E33BF64530F6370A7D9E04CDBBC", hash_generated_method = "373507266CE99450E905DA9FE496A1CE")
    public void setValue(String value) throws DOMException {
        this.value = value;
        // ---------- Original Method ----------
        //this.value = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.433 -0400", hash_original_method = "C51D6ACA797563231B3A9D05774313B4", hash_generated_method = "BF844F59EBD67CD566C600D24AF3CF1C")
    public TypeInfo getSchemaTypeInfo() {
        TypeInfo varB4EAC82CA7396A68D541C85D26508E83_2038218065 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2038218065 = NULL_TYPE_INFO;
        varB4EAC82CA7396A68D541C85D26508E83_2038218065.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2038218065;
        // ---------- Original Method ----------
        //return NULL_TYPE_INFO;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.434 -0400", hash_original_method = "042EF4BE6689EE05C98757A02B7F892C", hash_generated_method = "A45D084DCA6C33AF88E6DEF2EA0F67CE")
    public boolean isId() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1202467416 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1202467416;
        // ---------- Original Method ----------
        //return isId;
    }

    
}

