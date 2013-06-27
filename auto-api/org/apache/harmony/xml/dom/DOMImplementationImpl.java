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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.815 -0400", hash_original_method = "E3A87B6F32DA0C6F1234238EE265E85D", hash_generated_method = "9E169770513CF74C2B62B5136465DB92")
      DOMImplementationImpl() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.816 -0400", hash_original_method = "A8F6F0126AB1E9E9BF5B76989DE9A32F", hash_generated_method = "29F5B45E5CD031007C09CF7EB1179670")
    public Document createDocument(String namespaceURI, String qualifiedName,
            DocumentType doctype) throws DOMException {
        Document varB4EAC82CA7396A68D541C85D26508E83_2084759179 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2084759179 = new DocumentImpl(this, namespaceURI, qualifiedName, doctype, null);
        addTaint(namespaceURI.getTaint());
        addTaint(qualifiedName.getTaint());
        addTaint(doctype.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2084759179.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2084759179;
        // ---------- Original Method ----------
        //return new DocumentImpl(this, namespaceURI, qualifiedName, doctype, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.817 -0400", hash_original_method = "9C62B8245777A690BCF019D4FECDC942", hash_generated_method = "BD463227FB87034759975688790793FC")
    public DocumentType createDocumentType(String qualifiedName,
            String publicId, String systemId) throws DOMException {
        DocumentType varB4EAC82CA7396A68D541C85D26508E83_568351363 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_568351363 = new DocumentTypeImpl(null, qualifiedName, publicId, systemId);
        addTaint(qualifiedName.getTaint());
        addTaint(publicId.getTaint());
        addTaint(systemId.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_568351363.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_568351363;
        // ---------- Original Method ----------
        //return new DocumentTypeImpl(null, qualifiedName, publicId, systemId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.817 -0400", hash_original_method = "E091A0410E0BC85A7F21C3C96448A760", hash_generated_method = "70A7350FF4B21501F1886A6A5CD128B9")
    public boolean hasFeature(String feature, String version) {
        boolean anyVersion;
        anyVersion = version == null || version.length() == 0;
        {
            boolean var3FB55C20D13D9C6447B191FDEA417A0F_2028297013 = (feature.startsWith("+"));
            {
                feature = feature.substring(1);
            } //End block
        } //End collapsed parenthetic
        {
            boolean var730604E68FF8FC79FD767430A18AD5CD_419252512 = (feature.equalsIgnoreCase("Core"));
            {
                boolean varC4496E69A8C54837EF7A1843B9115379_1336472881 = (anyVersion || version.equals("1.0") || version.equals("2.0") || version.equals("3.0"));
            } //End block
            {
                boolean varEB68FC4EF444757397A9A8D1D9A5D1C0_769961251 = (feature.equalsIgnoreCase("XML"));
                {
                    boolean var0F5E6EF038DF438441723FE7179AE26B_46183236 = (anyVersion || version.equals("1.0") || version.equals("2.0") || version.equals("3.0"));
                } //End block
                {
                    boolean varC343A6ACB0CAC969A2E8B3F516C9BCFC_241526240 = (feature.equalsIgnoreCase("XMLVersion"));
                    {
                        boolean var77ECC29B268EC7E4326ED1481BDF1E8E_1031158337 = (anyVersion || version.equals("1.0") || version.equals("1.1"));
                    } //End block
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        addTaint(feature.getTaint());
        addTaint(version.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1805639386 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1805639386;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.818 -0400", hash_original_method = "F21DF5440792B1D9F1F89E7A46F56ED2", hash_generated_method = "114A8646798F0D9E5DE1D3F3E7F66626")
    public Object getFeature(String feature, String version) {
        Object varB4EAC82CA7396A68D541C85D26508E83_786519170 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_786519170 = hasFeature(feature, version) ? this : null;
        addTaint(feature.getTaint());
        addTaint(version.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_786519170.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_786519170;
        // ---------- Original Method ----------
        //return hasFeature(feature, version) ? this : null;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.818 -0400", hash_original_field = "7123A699D77DB6479A1D8ECE2C4F1C16", hash_generated_field = "DC45618DB534832F5989A3B9BE96A158")

    private static DOMImplementationImpl instance;
}

