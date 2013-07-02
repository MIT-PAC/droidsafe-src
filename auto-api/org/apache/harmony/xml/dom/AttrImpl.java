package org.apache.harmony.xml.dom;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import org.w3c.dom.Attr;
import org.w3c.dom.DOMException;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.TypeInfo;

public final class AttrImpl extends NodeImpl implements Attr {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.743 -0400", hash_original_field = "1CAC9B8EBA5F808398072B53F245F98F", hash_generated_field = "76E0E26209E3FD48A5AAFEA346976ED4")

    ElementImpl ownerElement;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.743 -0400", hash_original_field = "CC3516B3E43CD7E179D4697F53030A2A", hash_generated_field = "51C2A9724BD7E8242CDE48AAFEBC7178")

    boolean isId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.743 -0400", hash_original_field = "CEC00E48144CD3C5B0000055F3D7FF26", hash_generated_field = "6DED3D0909D027805E22F95BA58508AE")

    boolean namespaceAware;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.743 -0400", hash_original_field = "5295F3E9C46315AF1C2132265086FA24", hash_generated_field = "5B184DBF8D93287A0F0C8BC78758CAB7")

    String namespaceURI;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.743 -0400", hash_original_field = "851F5AC9941D720844D143ED9CFCF60A", hash_generated_field = "D07D332701F9B92847141D46D8B2C7CF")

    String prefix;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.743 -0400", hash_original_field = "E62B9ECBD883C26642197A7DC8246D3C", hash_generated_field = "69F110BF2CAEA76B4D1C533597A16878")

    String localName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.743 -0400", hash_original_field = "4A6115291F4697A52956FCF092552C27", hash_generated_field = "5ACD84A65DA4E81BC72CF65FE413D36D")

    private String value = "";
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.744 -0400", hash_original_method = "EF27CA8C1828BF4AC2BE0D84F97E8864", hash_generated_method = "D8D978E3B7D7F4EE10515C46F14D9090")
      AttrImpl(DocumentImpl document, String namespaceURI, String qualifiedName) {
        super(document);
        setNameNS(this, namespaceURI, qualifiedName);
        addTaint(document.getTaint());
        addTaint(namespaceURI.getTaint());
        addTaint(qualifiedName.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.744 -0400", hash_original_method = "2F6F1C08CF036A2A7F978D7F391927BA", hash_generated_method = "2B237132F5CF54D0353EA9ED4D4207FE")
      AttrImpl(DocumentImpl document, String name) {
        super(document);
        setName(this, name);
        addTaint(document.getTaint());
        addTaint(name.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.745 -0400", hash_original_method = "006A1593C2EDDFD80B5C8C9A0B08E49A", hash_generated_method = "1E01ABC335A38BB1B8613AFADB2DF5D6")
    @Override
    public String getLocalName() {
        String varB4EAC82CA7396A68D541C85D26508E83_246750345 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_246750345 = namespaceAware ? localName : null;
        varB4EAC82CA7396A68D541C85D26508E83_246750345.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_246750345;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.746 -0400", hash_original_method = "2829D25C85859024022592A3A30C0BDC", hash_generated_method = "148A27A531028897DCAE315ED21E619F")
    public String getName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1890296795 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1890296795 = prefix != null
                ? prefix + ":" + localName
                : localName;
        varB4EAC82CA7396A68D541C85D26508E83_1890296795.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1890296795;
        
        
                
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.746 -0400", hash_original_method = "1455FE8FE34AF373D39E8278191439A8", hash_generated_method = "E2CF218E93DC664BB3AEB771041DFD0D")
    @Override
    public String getNamespaceURI() {
        String varB4EAC82CA7396A68D541C85D26508E83_617640454 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_617640454 = namespaceURI;
        varB4EAC82CA7396A68D541C85D26508E83_617640454.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_617640454;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.747 -0400", hash_original_method = "C003064639FF6BDC59C8E14D85630B7A", hash_generated_method = "9D067A4EFE63DEF078F137FA4938A99C")
    @Override
    public String getNodeName() {
        String varB4EAC82CA7396A68D541C85D26508E83_2054999899 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2054999899 = getName();
        varB4EAC82CA7396A68D541C85D26508E83_2054999899.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2054999899;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.748 -0400", hash_original_method = "66DF12C09699AD1D686D4988F262C066", hash_generated_method = "E931B9DEDAACC0E944FEE6C846568C1E")
    public short getNodeType() {
        short var4F09DAA9D95BCB166A302407A0E0BABE_1757383734 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_1757383734;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.750 -0400", hash_original_method = "4300CB9DE8CDB8D1025C33AA1D8539DA", hash_generated_method = "60DAC3C613B6089AF98CE49E6BF201C3")
    @Override
    public String getNodeValue() {
        String varB4EAC82CA7396A68D541C85D26508E83_528726325 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_528726325 = getValue();
        varB4EAC82CA7396A68D541C85D26508E83_528726325.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_528726325;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.751 -0400", hash_original_method = "B2B2C7739C0F8FABC1AEF26C1D9AEC3F", hash_generated_method = "417DB5BB201F06A9B2932AB0B4908B43")
    public Element getOwnerElement() {
        Element varB4EAC82CA7396A68D541C85D26508E83_2000169615 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2000169615 = ownerElement;
        varB4EAC82CA7396A68D541C85D26508E83_2000169615.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2000169615;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.753 -0400", hash_original_method = "FA5CE5A0FCC0C736D9446FFEBD0CAB9D", hash_generated_method = "37E42F96331BC1FBF9A9F984A943455C")
    @Override
    public String getPrefix() {
        String varB4EAC82CA7396A68D541C85D26508E83_1317037494 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1317037494 = prefix;
        varB4EAC82CA7396A68D541C85D26508E83_1317037494.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1317037494;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.754 -0400", hash_original_method = "AB2D74F2DBFDF90175205031E5C24288", hash_generated_method = "DB04297237BDE22958229CD94EE8BA3C")
    public boolean getSpecified() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1009867923 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1009867923;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.755 -0400", hash_original_method = "CFCF943D36987E569CAB72593E604904", hash_generated_method = "E0B5563CB9666BA1A07560603A4FD262")
    public String getValue() {
        String varB4EAC82CA7396A68D541C85D26508E83_833999034 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_833999034 = value;
        varB4EAC82CA7396A68D541C85D26508E83_833999034.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_833999034;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.755 -0400", hash_original_method = "3E19055116AC2D87625766EB1DC83913", hash_generated_method = "756E644F22A977734EE8F4F9494CEE85")
    @Override
    public void setPrefix(String prefix) {
        this.prefix = validatePrefix(prefix, namespaceAware, namespaceURI);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.756 -0400", hash_original_method = "32019E33BF64530F6370A7D9E04CDBBC", hash_generated_method = "373507266CE99450E905DA9FE496A1CE")
    public void setValue(String value) throws DOMException {
        this.value = value;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.757 -0400", hash_original_method = "C51D6ACA797563231B3A9D05774313B4", hash_generated_method = "73F290DA2DD0E1A2A95D664D7EF0B005")
    public TypeInfo getSchemaTypeInfo() {
        TypeInfo varB4EAC82CA7396A68D541C85D26508E83_159076141 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_159076141 = NULL_TYPE_INFO;
        varB4EAC82CA7396A68D541C85D26508E83_159076141.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_159076141;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.757 -0400", hash_original_method = "042EF4BE6689EE05C98757A02B7F892C", hash_generated_method = "A0292439D61635F0470F93254BC89ECB")
    public boolean isId() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1728180055 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1728180055;
        
        
    }

    
}

