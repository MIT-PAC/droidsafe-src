package org.apache.harmony.xml.dom;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import org.w3c.dom.Attr;
import org.w3c.dom.DOMException;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.TypeInfo;

public final class AttrImpl extends NodeImpl implements Attr {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:21.286 -0500", hash_original_field = "76E0E26209E3FD48A5AAFEA346976ED4", hash_generated_field = "76E0E26209E3FD48A5AAFEA346976ED4")

    ElementImpl ownerElement;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:21.288 -0500", hash_original_field = "51C2A9724BD7E8242CDE48AAFEBC7178", hash_generated_field = "51C2A9724BD7E8242CDE48AAFEBC7178")

    boolean isId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:21.291 -0500", hash_original_field = "6DED3D0909D027805E22F95BA58508AE", hash_generated_field = "6DED3D0909D027805E22F95BA58508AE")

    boolean namespaceAware;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:21.293 -0500", hash_original_field = "5B184DBF8D93287A0F0C8BC78758CAB7", hash_generated_field = "5B184DBF8D93287A0F0C8BC78758CAB7")

    String namespaceURI;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:21.295 -0500", hash_original_field = "D07D332701F9B92847141D46D8B2C7CF", hash_generated_field = "D07D332701F9B92847141D46D8B2C7CF")

    String prefix;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:21.297 -0500", hash_original_field = "69F110BF2CAEA76B4D1C533597A16878", hash_generated_field = "69F110BF2CAEA76B4D1C533597A16878")

    String localName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:21.299 -0500", hash_original_field = "DE8E8B4A0967E7C25E50EB8FFACE2AD6", hash_generated_field = "5ACD84A65DA4E81BC72CF65FE413D36D")

    private String value = "";

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:21.301 -0500", hash_original_method = "EF27CA8C1828BF4AC2BE0D84F97E8864", hash_generated_method = "EF27CA8C1828BF4AC2BE0D84F97E8864")
    
AttrImpl(DocumentImpl document, String namespaceURI, String qualifiedName) {
        super(document);
        setNameNS(this, namespaceURI, qualifiedName);
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:21.305 -0500", hash_original_method = "2F6F1C08CF036A2A7F978D7F391927BA", hash_generated_method = "2F6F1C08CF036A2A7F978D7F391927BA")
    
AttrImpl(DocumentImpl document, String name) {
        super(document);
        setName(this, name);
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:21.307 -0500", hash_original_method = "006A1593C2EDDFD80B5C8C9A0B08E49A", hash_generated_method = "F987DC43BC4FDF1130057C0E487D8DB9")
    
@Override
    public String getLocalName() {
        return namespaceAware ? localName : null;
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:21.309 -0500", hash_original_method = "2829D25C85859024022592A3A30C0BDC", hash_generated_method = "0D696AF7AD6FF22C63019EB12F04D2FD")
    
public String getName() {
        return prefix != null
                ? prefix + ":" + localName
                : localName;
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:21.312 -0500", hash_original_method = "1455FE8FE34AF373D39E8278191439A8", hash_generated_method = "5C655AA6CF7D48092CB41BEF30260410")
    
@Override
    public String getNamespaceURI() {
        return namespaceURI;
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:21.314 -0500", hash_original_method = "C003064639FF6BDC59C8E14D85630B7A", hash_generated_method = "115A206A1F732C8CEC34702A43C4249C")
    
@Override
    public String getNodeName() {
        return getName();
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:21.316 -0500", hash_original_method = "66DF12C09699AD1D686D4988F262C066", hash_generated_method = "53AB6ED0A96388D2FB32681408426829")
    
public short getNodeType() {
        return Node.ATTRIBUTE_NODE;
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:21.319 -0500", hash_original_method = "4300CB9DE8CDB8D1025C33AA1D8539DA", hash_generated_method = "8EF622F93A0ABFB7EC07E4CFF256EE69")
    
@Override
    public String getNodeValue() {
        return getValue();
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:21.321 -0500", hash_original_method = "B2B2C7739C0F8FABC1AEF26C1D9AEC3F", hash_generated_method = "1D0AC97A2C4BF0A4881F607EC2893753")
    
public Element getOwnerElement() {
        return ownerElement;
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:21.323 -0500", hash_original_method = "FA5CE5A0FCC0C736D9446FFEBD0CAB9D", hash_generated_method = "C905C4F3356722AF0C0E9CD6FA7F3CCD")
    
@Override
    public String getPrefix() {
        return prefix;
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:21.325 -0500", hash_original_method = "AB2D74F2DBFDF90175205031E5C24288", hash_generated_method = "562096ABAE401A81D25DD9F6830A4690")
    
public boolean getSpecified() {
        return value != null;
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:21.327 -0500", hash_original_method = "CFCF943D36987E569CAB72593E604904", hash_generated_method = "60823E74DAC88C5FAC14BD2BA786CA0E")
    
public String getValue() {
        return value;
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:21.329 -0500", hash_original_method = "3E19055116AC2D87625766EB1DC83913", hash_generated_method = "E839C95B45355A666035B4D9E3A8B013")
    
@Override
    public void setPrefix(String prefix) {
        this.prefix = validatePrefix(prefix, namespaceAware, namespaceURI);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:21.332 -0500", hash_original_method = "32019E33BF64530F6370A7D9E04CDBBC", hash_generated_method = "9328778D6055D02FC0C10452B4D2F54B")
    
public void setValue(String value) throws DOMException {
        this.value = value;
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:21.334 -0500", hash_original_method = "C51D6ACA797563231B3A9D05774313B4", hash_generated_method = "4EB9EC1BDB5787FF00F4421C186C425B")
    
public TypeInfo getSchemaTypeInfo() {
        // TODO: populate this when we support XML Schema
        return NULL_TYPE_INFO;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:21.336 -0500", hash_original_method = "042EF4BE6689EE05C98757A02B7F892C", hash_generated_method = "ABBBA2FC7BB55EE94BC24B220BDE3701")
    
public boolean isId() {
        return isId;
    }
    
}

