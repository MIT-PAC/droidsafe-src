package org.apache.harmony.xml.dom;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import org.w3c.dom.DOMException;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentType;

public final class DOMImplementationImpl implements DOMImplementation {

    /**
     * Requests the singleton instance of the class. Creates it first, if
     * necessary.
     *
     * @return The singleton Android DOMImplementationImpl instance.
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:23.149 -0500", hash_original_method = "37FEFE6F908BEC1F33DA86D06B31B3D4", hash_generated_method = "FEB95F4D075C0905BCC04B590962FC6B")
    
public static DOMImplementationImpl getInstance() {
        if (instance == null) {
            instance = new DOMImplementationImpl();
        }

        return instance;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:23.137 -0500", hash_original_field = "C4B378DBF48C41695DD4726D8095A6AD", hash_generated_field = "DC45618DB534832F5989A3B9BE96A158")

    private static DOMImplementationImpl instance;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:23.139 -0500", hash_original_method = "E3A87B6F32DA0C6F1234238EE265E85D", hash_generated_method = "E3A87B6F32DA0C6F1234238EE265E85D")
    
DOMImplementationImpl() {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:23.141 -0500", hash_original_method = "A8F6F0126AB1E9E9BF5B76989DE9A32F", hash_generated_method = "DD3EDDC2FC24F4EDB25A4E9EDD570D80")
    
public Document createDocument(String namespaceURI, String qualifiedName,
            DocumentType doctype) throws DOMException {
        return new DocumentImpl(this, namespaceURI, qualifiedName, doctype, null);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:23.144 -0500", hash_original_method = "9C62B8245777A690BCF019D4FECDC942", hash_generated_method = "AFE229D18056B56BC435680BF65B6628")
    
public DocumentType createDocumentType(String qualifiedName,
            String publicId, String systemId) throws DOMException {
        return new DocumentTypeImpl(null, qualifiedName, publicId, systemId);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:23.147 -0500", hash_original_method = "E091A0410E0BC85A7F21C3C96448A760", hash_generated_method = "571A174E7C9A98FFDB8B30B25F6E3B0F")
    
public boolean hasFeature(String feature, String version) {
        boolean anyVersion = version == null || version.length() == 0;
        if (feature.startsWith("+")) {
            feature = feature.substring(1);
        }

        // TODO: fully implement these APIs:
        // "LS" (org.w3c.dom.ls) versions "3.0"
        // "ElementTraversal" (org.w3c.dom.traversal) versions "1.0"

        if (feature.equalsIgnoreCase("Core")) {
            return anyVersion || version.equals("1.0") || version.equals("2.0") || version.equals("3.0");
        } else if (feature.equalsIgnoreCase("XML")) {
            return anyVersion || version.equals("1.0") || version.equals("2.0") || version.equals("3.0");
        } else if (feature.equalsIgnoreCase("XMLVersion")) {
            return anyVersion || version.equals("1.0") || version.equals("1.1");
        } else {
            return false;
        }
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:23.152 -0500", hash_original_method = "F21DF5440792B1D9F1F89E7A46F56ED2", hash_generated_method = "1AEA478582F0F07A4FE8A7CB652A4BE8")
    
public Object getFeature(String feature, String version) {
        return hasFeature(feature, version) ? this : null;
    }
}

