package org.apache.harmony.xml.dom;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.w3c.dom.DOMException;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentType;

public final class DOMImplementationImpl implements DOMImplementation {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.191 -0400", hash_original_method = "E3A87B6F32DA0C6F1234238EE265E85D", hash_generated_method = "9E169770513CF74C2B62B5136465DB92")
    @DSModeled(DSC.SAFE)
     DOMImplementationImpl() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.192 -0400", hash_original_method = "A8F6F0126AB1E9E9BF5B76989DE9A32F", hash_generated_method = "8D2FC95257B42A27C3E7520598D3E3DE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Document createDocument(String namespaceURI, String qualifiedName,
            DocumentType doctype) throws DOMException {
        dsTaint.addTaint(namespaceURI);
        dsTaint.addTaint(qualifiedName);
        dsTaint.addTaint(doctype.dsTaint);
        Document varA8D619FDF1F25975692F81ACA2BD9473_480775986 = (new DocumentImpl(this, namespaceURI, qualifiedName, doctype, null));
        return (Document)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new DocumentImpl(this, namespaceURI, qualifiedName, doctype, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.192 -0400", hash_original_method = "9C62B8245777A690BCF019D4FECDC942", hash_generated_method = "38AB4665D28423360F0B545C25427328")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public DocumentType createDocumentType(String qualifiedName,
            String publicId, String systemId) throws DOMException {
        dsTaint.addTaint(qualifiedName);
        dsTaint.addTaint(publicId);
        dsTaint.addTaint(systemId);
        DocumentType var6988FFB4DDE8CA06AAA1CF4322171F5F_1061763624 = (new DocumentTypeImpl(null, qualifiedName, publicId, systemId));
        return (DocumentType)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new DocumentTypeImpl(null, qualifiedName, publicId, systemId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.192 -0400", hash_original_method = "E091A0410E0BC85A7F21C3C96448A760", hash_generated_method = "ED21E86BA71061458A17E6FDF60127CE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean hasFeature(String feature, String version) {
        dsTaint.addTaint(feature);
        dsTaint.addTaint(version);
        boolean anyVersion;
        anyVersion = version == null || version.length() == 0;
        {
            boolean var3FB55C20D13D9C6447B191FDEA417A0F_3265113 = (feature.startsWith("+"));
            {
                feature = feature.substring(1);
            } //End block
        } //End collapsed parenthetic
        {
            boolean var730604E68FF8FC79FD767430A18AD5CD_2041184989 = (feature.equalsIgnoreCase("Core"));
            {
                boolean varC4496E69A8C54837EF7A1843B9115379_674218064 = (anyVersion || version.equals("1.0") || version.equals("2.0") || version.equals("3.0"));
            } //End block
            {
                boolean varEB68FC4EF444757397A9A8D1D9A5D1C0_357458888 = (feature.equalsIgnoreCase("XML"));
                {
                    boolean var0F5E6EF038DF438441723FE7179AE26B_1875200147 = (anyVersion || version.equals("1.0") || version.equals("2.0") || version.equals("3.0"));
                } //End block
                {
                    boolean varC343A6ACB0CAC969A2E8B3F516C9BCFC_1999214884 = (feature.equalsIgnoreCase("XMLVersion"));
                    {
                        boolean var77ECC29B268EC7E4326ED1481BDF1E8E_874249814 = (anyVersion || version.equals("1.0") || version.equals("1.1"));
                    } //End block
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //boolean anyVersion = version == null || version.length() == 0;
        //if (feature.startsWith("+")) {
            //feature = feature.substring(1);
        //}
        //if (feature.equalsIgnoreCase("Core")) {
            //return anyVersion || version.equals("1.0") || version.equals("2.0") || version.equals("3.0");
        //} else if (feature.equalsIgnoreCase("XML")) {
            //return anyVersion || version.equals("1.0") || version.equals("2.0") || version.equals("3.0");
        //} else if (feature.equalsIgnoreCase("XMLVersion")) {
            //return anyVersion || version.equals("1.0") || version.equals("1.1");
        //} else {
            //return false;
        //}
    }

    
        public static DOMImplementationImpl getInstance() {
        if (instance == null) {
            instance = new DOMImplementationImpl();
        }
        return instance;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.193 -0400", hash_original_method = "F21DF5440792B1D9F1F89E7A46F56ED2", hash_generated_method = "018546EC3CA217E03F0AEFB447446F21")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object getFeature(String feature, String version) {
        dsTaint.addTaint(feature);
        dsTaint.addTaint(version);
        {
            boolean var034CC9559DB05672E2C50B5947F12DE2_1963642380 = (hasFeature(feature, version));
        } //End flattened ternary
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return hasFeature(feature, version) ? this : null;
    }

    
    private static DOMImplementationImpl instance;
}

