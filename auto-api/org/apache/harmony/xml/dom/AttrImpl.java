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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.515 -0400", hash_original_field = "1CAC9B8EBA5F808398072B53F245F98F", hash_generated_field = "76E0E26209E3FD48A5AAFEA346976ED4")

    ElementImpl ownerElement;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.515 -0400", hash_original_field = "CC3516B3E43CD7E179D4697F53030A2A", hash_generated_field = "51C2A9724BD7E8242CDE48AAFEBC7178")

    boolean isId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.515 -0400", hash_original_field = "CEC00E48144CD3C5B0000055F3D7FF26", hash_generated_field = "6DED3D0909D027805E22F95BA58508AE")

    boolean namespaceAware;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.516 -0400", hash_original_field = "5295F3E9C46315AF1C2132265086FA24", hash_generated_field = "5B184DBF8D93287A0F0C8BC78758CAB7")

    String namespaceURI;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.516 -0400", hash_original_field = "851F5AC9941D720844D143ED9CFCF60A", hash_generated_field = "D07D332701F9B92847141D46D8B2C7CF")

    String prefix;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.516 -0400", hash_original_field = "E62B9ECBD883C26642197A7DC8246D3C", hash_generated_field = "69F110BF2CAEA76B4D1C533597A16878")

    String localName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.516 -0400", hash_original_field = "4A6115291F4697A52956FCF092552C27", hash_generated_field = "5ACD84A65DA4E81BC72CF65FE413D36D")

    private String value = "";
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.516 -0400", hash_original_method = "EF27CA8C1828BF4AC2BE0D84F97E8864", hash_generated_method = "D8D978E3B7D7F4EE10515C46F14D9090")
      AttrImpl(DocumentImpl document, String namespaceURI, String qualifiedName) {
        super(document);
        setNameNS(this, namespaceURI, qualifiedName);
        addTaint(document.getTaint());
        addTaint(namespaceURI.getTaint());
        addTaint(qualifiedName.getTaint());
        // ---------- Original Method ----------
        //setNameNS(this, namespaceURI, qualifiedName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.516 -0400", hash_original_method = "2F6F1C08CF036A2A7F978D7F391927BA", hash_generated_method = "2B237132F5CF54D0353EA9ED4D4207FE")
      AttrImpl(DocumentImpl document, String name) {
        super(document);
        setName(this, name);
        addTaint(document.getTaint());
        addTaint(name.getTaint());
        // ---------- Original Method ----------
        //setName(this, name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.517 -0400", hash_original_method = "006A1593C2EDDFD80B5C8C9A0B08E49A", hash_generated_method = "A88467491E491B890CDFB0673C724FBC")
    @Override
    public String getLocalName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1956078203 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1956078203 = namespaceAware ? localName : null;
        varB4EAC82CA7396A68D541C85D26508E83_1956078203.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1956078203;
        // ---------- Original Method ----------
        //return namespaceAware ? localName : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.517 -0400", hash_original_method = "2829D25C85859024022592A3A30C0BDC", hash_generated_method = "C49C6460FF1B0CE12A597A4BD6466566")
    public String getName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1176115548 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1176115548 = prefix != null
                ? prefix + ":" + localName
                : localName;
        varB4EAC82CA7396A68D541C85D26508E83_1176115548.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1176115548;
        // ---------- Original Method ----------
        //return prefix != null
                //? prefix + ":" + localName
                //: localName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.518 -0400", hash_original_method = "1455FE8FE34AF373D39E8278191439A8", hash_generated_method = "BFD7CA2C7DD63E13CE77FDD198DBED33")
    @Override
    public String getNamespaceURI() {
        String varB4EAC82CA7396A68D541C85D26508E83_226632064 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_226632064 = namespaceURI;
        varB4EAC82CA7396A68D541C85D26508E83_226632064.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_226632064;
        // ---------- Original Method ----------
        //return namespaceURI;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.519 -0400", hash_original_method = "C003064639FF6BDC59C8E14D85630B7A", hash_generated_method = "5F41038C80B236BECBF52ED1F2015057")
    @Override
    public String getNodeName() {
        String varB4EAC82CA7396A68D541C85D26508E83_2138005440 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2138005440 = getName();
        varB4EAC82CA7396A68D541C85D26508E83_2138005440.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2138005440;
        // ---------- Original Method ----------
        //return getName();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.519 -0400", hash_original_method = "66DF12C09699AD1D686D4988F262C066", hash_generated_method = "5D9B33F2D625AF5882E2A4EA22547703")
    public short getNodeType() {
        short var4F09DAA9D95BCB166A302407A0E0BABE_227943504 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_227943504;
        // ---------- Original Method ----------
        //return Node.ATTRIBUTE_NODE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.527 -0400", hash_original_method = "4300CB9DE8CDB8D1025C33AA1D8539DA", hash_generated_method = "26B0337D3F3853DA70FE85A336B3B8B4")
    @Override
    public String getNodeValue() {
        String varB4EAC82CA7396A68D541C85D26508E83_697047015 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_697047015 = getValue();
        varB4EAC82CA7396A68D541C85D26508E83_697047015.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_697047015;
        // ---------- Original Method ----------
        //return getValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.532 -0400", hash_original_method = "B2B2C7739C0F8FABC1AEF26C1D9AEC3F", hash_generated_method = "6D883490917B3988D515FE9484846EE1")
    public Element getOwnerElement() {
        Element varB4EAC82CA7396A68D541C85D26508E83_809807055 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_809807055 = ownerElement;
        varB4EAC82CA7396A68D541C85D26508E83_809807055.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_809807055;
        // ---------- Original Method ----------
        //return ownerElement;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.532 -0400", hash_original_method = "FA5CE5A0FCC0C736D9446FFEBD0CAB9D", hash_generated_method = "5867002E5F7EAF990A5EBC737D59D166")
    @Override
    public String getPrefix() {
        String varB4EAC82CA7396A68D541C85D26508E83_725085380 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_725085380 = prefix;
        varB4EAC82CA7396A68D541C85D26508E83_725085380.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_725085380;
        // ---------- Original Method ----------
        //return prefix;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.533 -0400", hash_original_method = "AB2D74F2DBFDF90175205031E5C24288", hash_generated_method = "29A390B410CCB9B0F9B5A6FF81CA8517")
    public boolean getSpecified() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1282180706 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1282180706;
        // ---------- Original Method ----------
        //return value != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.534 -0400", hash_original_method = "CFCF943D36987E569CAB72593E604904", hash_generated_method = "5FC457E544634657B4FF06C49D70DDAF")
    public String getValue() {
        String varB4EAC82CA7396A68D541C85D26508E83_1923663355 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1923663355 = value;
        varB4EAC82CA7396A68D541C85D26508E83_1923663355.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1923663355;
        // ---------- Original Method ----------
        //return value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.534 -0400", hash_original_method = "3E19055116AC2D87625766EB1DC83913", hash_generated_method = "756E644F22A977734EE8F4F9494CEE85")
    @Override
    public void setPrefix(String prefix) {
        this.prefix = validatePrefix(prefix, namespaceAware, namespaceURI);
        // ---------- Original Method ----------
        //this.prefix = validatePrefix(prefix, namespaceAware, namespaceURI);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.534 -0400", hash_original_method = "32019E33BF64530F6370A7D9E04CDBBC", hash_generated_method = "373507266CE99450E905DA9FE496A1CE")
    public void setValue(String value) throws DOMException {
        this.value = value;
        // ---------- Original Method ----------
        //this.value = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.535 -0400", hash_original_method = "C51D6ACA797563231B3A9D05774313B4", hash_generated_method = "D1E60B9D229BA3B271035AE0A7039B2A")
    public TypeInfo getSchemaTypeInfo() {
        TypeInfo varB4EAC82CA7396A68D541C85D26508E83_1629041195 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1629041195 = NULL_TYPE_INFO;
        varB4EAC82CA7396A68D541C85D26508E83_1629041195.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1629041195;
        // ---------- Original Method ----------
        //return NULL_TYPE_INFO;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.536 -0400", hash_original_method = "042EF4BE6689EE05C98757A02B7F892C", hash_generated_method = "1A37E09F3D094C91177189951B577E06")
    public boolean isId() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_88627210 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_88627210;
        // ---------- Original Method ----------
        //return isId;
    }

    
}

