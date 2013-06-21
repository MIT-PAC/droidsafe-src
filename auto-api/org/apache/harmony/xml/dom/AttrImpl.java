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
    ElementImpl ownerElement;
    boolean isId;
    boolean namespaceAware;
    String namespaceURI;
    String prefix;
    String localName;
    private String value = "";
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.114 -0400", hash_original_method = "EF27CA8C1828BF4AC2BE0D84F97E8864", hash_generated_method = "60FD5533170B92A8D3A6FF34C33E092C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     AttrImpl(DocumentImpl document, String namespaceURI, String qualifiedName) {
        super(document);
        dsTaint.addTaint(namespaceURI);
        dsTaint.addTaint(document.dsTaint);
        dsTaint.addTaint(qualifiedName);
        setNameNS(this, namespaceURI, qualifiedName);
        // ---------- Original Method ----------
        //setNameNS(this, namespaceURI, qualifiedName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.114 -0400", hash_original_method = "2F6F1C08CF036A2A7F978D7F391927BA", hash_generated_method = "BACFD7ED6E7F151AF0D0534FC94D3B7F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     AttrImpl(DocumentImpl document, String name) {
        super(document);
        dsTaint.addTaint(document.dsTaint);
        dsTaint.addTaint(name);
        setName(this, name);
        // ---------- Original Method ----------
        //setName(this, name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.114 -0400", hash_original_method = "006A1593C2EDDFD80B5C8C9A0B08E49A", hash_generated_method = "F1A1D9C71B0FC51F77DD5BAEDAB15A2D")
    @DSModeled(DSC.SAFE)
    @Override
    public String getLocalName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return namespaceAware ? localName : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.115 -0400", hash_original_method = "2829D25C85859024022592A3A30C0BDC", hash_generated_method = "BC75039444D9E4995CFE00AEBBFB8F8F")
    @DSModeled(DSC.SAFE)
    public String getName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return prefix != null
                //? prefix + ":" + localName
                //: localName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.115 -0400", hash_original_method = "1455FE8FE34AF373D39E8278191439A8", hash_generated_method = "5E28B0040100F10E7FA051BB8138BF3A")
    @DSModeled(DSC.SAFE)
    @Override
    public String getNamespaceURI() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return namespaceURI;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.115 -0400", hash_original_method = "C003064639FF6BDC59C8E14D85630B7A", hash_generated_method = "6111F39A29F7C471E7D42F23F8EA3B9F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String getNodeName() {
        String var5032DEC29B552A5D605BC7E38765B26B_1238279571 = (getName());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return getName();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.115 -0400", hash_original_method = "66DF12C09699AD1D686D4988F262C066", hash_generated_method = "AD045BCD6C0F5F67DABE22F95DEE9C67")
    @DSModeled(DSC.SAFE)
    public short getNodeType() {
        return dsTaint.getTaintShort();
        // ---------- Original Method ----------
        //return Node.ATTRIBUTE_NODE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.115 -0400", hash_original_method = "4300CB9DE8CDB8D1025C33AA1D8539DA", hash_generated_method = "31FF81CBEBA79473870A9B30A808B74C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String getNodeValue() {
        String var2462312DD71AEECDC2D8AEAB9A07B9DF_1820252121 = (getValue());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return getValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.116 -0400", hash_original_method = "B2B2C7739C0F8FABC1AEF26C1D9AEC3F", hash_generated_method = "AFCA35F1DE175591E6B47CA60A91EE2F")
    @DSModeled(DSC.SAFE)
    public Element getOwnerElement() {
        return (Element)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return ownerElement;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.116 -0400", hash_original_method = "FA5CE5A0FCC0C736D9446FFEBD0CAB9D", hash_generated_method = "ED5F2F04082C1BA63A051B667FDB20B2")
    @DSModeled(DSC.SAFE)
    @Override
    public String getPrefix() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return prefix;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.116 -0400", hash_original_method = "AB2D74F2DBFDF90175205031E5C24288", hash_generated_method = "1D879E4D83CD85621966E9F5256BBD55")
    @DSModeled(DSC.SAFE)
    public boolean getSpecified() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return value != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.116 -0400", hash_original_method = "CFCF943D36987E569CAB72593E604904", hash_generated_method = "C3D3821C6983F8BDE45CA1D2D809641B")
    @DSModeled(DSC.SAFE)
    public String getValue() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.116 -0400", hash_original_method = "3E19055116AC2D87625766EB1DC83913", hash_generated_method = "0CB7FC42C6CFB8F1AC6AE794166FD516")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setPrefix(String prefix) {
        dsTaint.addTaint(prefix);
        this.prefix = validatePrefix(prefix, namespaceAware, namespaceURI);
        // ---------- Original Method ----------
        //this.prefix = validatePrefix(prefix, namespaceAware, namespaceURI);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.116 -0400", hash_original_method = "32019E33BF64530F6370A7D9E04CDBBC", hash_generated_method = "79C675CD2407433B61523601A5588951")
    @DSModeled(DSC.SAFE)
    public void setValue(String value) throws DOMException {
        dsTaint.addTaint(value);
        // ---------- Original Method ----------
        //this.value = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.117 -0400", hash_original_method = "C51D6ACA797563231B3A9D05774313B4", hash_generated_method = "F627AC6B24CA05AEF1200312D3FA4E96")
    @DSModeled(DSC.SAFE)
    public TypeInfo getSchemaTypeInfo() {
        return (TypeInfo)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return NULL_TYPE_INFO;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.117 -0400", hash_original_method = "042EF4BE6689EE05C98757A02B7F892C", hash_generated_method = "26AF3839E97C78BBAB1EDFFB3867D89A")
    @DSModeled(DSC.SAFE)
    public boolean isId() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return isId;
    }

    
}

