package org.apache.harmony.xml.dom;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import org.w3c.dom.DOMException;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentType;

public final class DOMImplementationImpl implements DOMImplementation {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.905 -0400", hash_original_method = "E3A87B6F32DA0C6F1234238EE265E85D", hash_generated_method = "9E169770513CF74C2B62B5136465DB92")
      DOMImplementationImpl() {
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.906 -0400", hash_original_method = "A8F6F0126AB1E9E9BF5B76989DE9A32F", hash_generated_method = "6CFCD71CF743EC23511ADF7572C97355")
    public Document createDocument(String namespaceURI, String qualifiedName,
            DocumentType doctype) throws DOMException {
        Document varB4EAC82CA7396A68D541C85D26508E83_1928268484 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1928268484 = new DocumentImpl(this, namespaceURI, qualifiedName, doctype, null);
        addTaint(namespaceURI.getTaint());
        addTaint(qualifiedName.getTaint());
        addTaint(doctype.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1928268484.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1928268484;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.906 -0400", hash_original_method = "9C62B8245777A690BCF019D4FECDC942", hash_generated_method = "16A1824933F8241D825C86A75BE19CCB")
    public DocumentType createDocumentType(String qualifiedName,
            String publicId, String systemId) throws DOMException {
        DocumentType varB4EAC82CA7396A68D541C85D26508E83_1008714850 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1008714850 = new DocumentTypeImpl(null, qualifiedName, publicId, systemId);
        addTaint(qualifiedName.getTaint());
        addTaint(publicId.getTaint());
        addTaint(systemId.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1008714850.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1008714850;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.907 -0400", hash_original_method = "E091A0410E0BC85A7F21C3C96448A760", hash_generated_method = "F8C70AE61396D8A0C351DC4C6ACA5158")
    public boolean hasFeature(String feature, String version) {
        boolean anyVersion = version == null || version.length() == 0;
        {
            boolean var3FB55C20D13D9C6447B191FDEA417A0F_468764172 = (feature.startsWith("+"));
            {
                feature = feature.substring(1);
            } 
        } 
        {
            boolean var730604E68FF8FC79FD767430A18AD5CD_1994687169 = (feature.equalsIgnoreCase("Core"));
            {
                boolean varC4496E69A8C54837EF7A1843B9115379_385331342 = (anyVersion || version.equals("1.0") || version.equals("2.0") || version.equals("3.0"));
            } 
            {
                boolean varEB68FC4EF444757397A9A8D1D9A5D1C0_324402292 = (feature.equalsIgnoreCase("XML"));
                {
                    boolean var0F5E6EF038DF438441723FE7179AE26B_1423661485 = (anyVersion || version.equals("1.0") || version.equals("2.0") || version.equals("3.0"));
                } 
                {
                    boolean varC343A6ACB0CAC969A2E8B3F516C9BCFC_448390017 = (feature.equalsIgnoreCase("XMLVersion"));
                    {
                        boolean var77ECC29B268EC7E4326ED1481BDF1E8E_347821598 = (anyVersion || version.equals("1.0") || version.equals("1.1"));
                    } 
                } 
            } 
        } 
        addTaint(feature.getTaint());
        addTaint(version.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_57693277 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_57693277;
        
        
        
            
        
        
            
        
            
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    public static DOMImplementationImpl getInstance() {
        if (instance == null) {
            instance = new DOMImplementationImpl();
        }
        return instance;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.908 -0400", hash_original_method = "F21DF5440792B1D9F1F89E7A46F56ED2", hash_generated_method = "506FCB94909C62CE3E47EEF56B97E50D")
    public Object getFeature(String feature, String version) {
        Object varB4EAC82CA7396A68D541C85D26508E83_1971614811 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1971614811 = hasFeature(feature, version) ? this : null;
        addTaint(feature.getTaint());
        addTaint(version.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1971614811.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1971614811;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.908 -0400", hash_original_field = "7123A699D77DB6479A1D8ECE2C4F1C16", hash_generated_field = "DC45618DB534832F5989A3B9BE96A158")

    private static DOMImplementationImpl instance;
}

