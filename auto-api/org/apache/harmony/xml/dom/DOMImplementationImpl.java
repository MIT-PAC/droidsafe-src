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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.628 -0400", hash_original_method = "E3A87B6F32DA0C6F1234238EE265E85D", hash_generated_method = "9E169770513CF74C2B62B5136465DB92")
      DOMImplementationImpl() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.628 -0400", hash_original_method = "A8F6F0126AB1E9E9BF5B76989DE9A32F", hash_generated_method = "A8300C8EC1A28EBDE0D0990BC3052632")
    public Document createDocument(String namespaceURI, String qualifiedName,
            DocumentType doctype) throws DOMException {
        Document varB4EAC82CA7396A68D541C85D26508E83_1550691531 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1550691531 = new DocumentImpl(this, namespaceURI, qualifiedName, doctype, null);
        addTaint(namespaceURI.getTaint());
        addTaint(qualifiedName.getTaint());
        addTaint(doctype.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1550691531.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1550691531;
        // ---------- Original Method ----------
        //return new DocumentImpl(this, namespaceURI, qualifiedName, doctype, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.629 -0400", hash_original_method = "9C62B8245777A690BCF019D4FECDC942", hash_generated_method = "8761613313133353068BB53D49ACE1DD")
    public DocumentType createDocumentType(String qualifiedName,
            String publicId, String systemId) throws DOMException {
        DocumentType varB4EAC82CA7396A68D541C85D26508E83_1344023800 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1344023800 = new DocumentTypeImpl(null, qualifiedName, publicId, systemId);
        addTaint(qualifiedName.getTaint());
        addTaint(publicId.getTaint());
        addTaint(systemId.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1344023800.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1344023800;
        // ---------- Original Method ----------
        //return new DocumentTypeImpl(null, qualifiedName, publicId, systemId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.629 -0400", hash_original_method = "E091A0410E0BC85A7F21C3C96448A760", hash_generated_method = "A8AC77DF188C69401415DA1E6AF2A577")
    public boolean hasFeature(String feature, String version) {
        boolean anyVersion;
        anyVersion = version == null || version.length() == 0;
        {
            boolean var3FB55C20D13D9C6447B191FDEA417A0F_1903772199 = (feature.startsWith("+"));
            {
                feature = feature.substring(1);
            } //End block
        } //End collapsed parenthetic
        {
            boolean var730604E68FF8FC79FD767430A18AD5CD_741644087 = (feature.equalsIgnoreCase("Core"));
            {
                boolean varC4496E69A8C54837EF7A1843B9115379_432779930 = (anyVersion || version.equals("1.0") || version.equals("2.0") || version.equals("3.0"));
            } //End block
            {
                boolean varEB68FC4EF444757397A9A8D1D9A5D1C0_660243242 = (feature.equalsIgnoreCase("XML"));
                {
                    boolean var0F5E6EF038DF438441723FE7179AE26B_1737785004 = (anyVersion || version.equals("1.0") || version.equals("2.0") || version.equals("3.0"));
                } //End block
                {
                    boolean varC343A6ACB0CAC969A2E8B3F516C9BCFC_1687858410 = (feature.equalsIgnoreCase("XMLVersion"));
                    {
                        boolean var77ECC29B268EC7E4326ED1481BDF1E8E_1139570667 = (anyVersion || version.equals("1.0") || version.equals("1.1"));
                    } //End block
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        addTaint(feature.getTaint());
        addTaint(version.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_297848693 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_297848693;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.630 -0400", hash_original_method = "F21DF5440792B1D9F1F89E7A46F56ED2", hash_generated_method = "C59216747A95C568F5ECBB9AE05B4318")
    public Object getFeature(String feature, String version) {
        Object varB4EAC82CA7396A68D541C85D26508E83_1036132224 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1036132224 = hasFeature(feature, version) ? this : null;
        addTaint(feature.getTaint());
        addTaint(version.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1036132224.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1036132224;
        // ---------- Original Method ----------
        //return hasFeature(feature, version) ? this : null;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.630 -0400", hash_original_field = "7123A699D77DB6479A1D8ECE2C4F1C16", hash_generated_field = "DC45618DB534832F5989A3B9BE96A158")

    private static DOMImplementationImpl instance;
}

