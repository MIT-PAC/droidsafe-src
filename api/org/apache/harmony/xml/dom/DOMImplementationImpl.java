package org.apache.harmony.xml.dom;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import org.w3c.dom.DOMException;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentType;

public final class DOMImplementationImpl implements DOMImplementation {
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.601 -0400", hash_original_method = "E3A87B6F32DA0C6F1234238EE265E85D", hash_generated_method = "9E169770513CF74C2B62B5136465DB92")
      DOMImplementationImpl() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.602 -0400", hash_original_method = "A8F6F0126AB1E9E9BF5B76989DE9A32F", hash_generated_method = "54920E025F7E7197697DBDEBB08CE081")
    public Document createDocument(String namespaceURI, String qualifiedName,
            DocumentType doctype) throws DOMException {
        addTaint(doctype.getTaint());
        addTaint(qualifiedName.getTaint());
        addTaint(namespaceURI.getTaint());
Document var1AFCDC8394B561283EA4137BAAE11034_1558130344 =         new DocumentImpl(this, namespaceURI, qualifiedName, doctype, null);
        var1AFCDC8394B561283EA4137BAAE11034_1558130344.addTaint(taint);
        return var1AFCDC8394B561283EA4137BAAE11034_1558130344;
        // ---------- Original Method ----------
        //return new DocumentImpl(this, namespaceURI, qualifiedName, doctype, null);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.602 -0400", hash_original_method = "9C62B8245777A690BCF019D4FECDC942", hash_generated_method = "428746B385505B247711F2FC8C6BFE42")
    public DocumentType createDocumentType(String qualifiedName,
            String publicId, String systemId) throws DOMException {
        addTaint(systemId.getTaint());
        addTaint(publicId.getTaint());
        addTaint(qualifiedName.getTaint());
DocumentType var641A63204CB54C67EE90D89886D51C3B_1242962996 =         new DocumentTypeImpl(null, qualifiedName, publicId, systemId);
        var641A63204CB54C67EE90D89886D51C3B_1242962996.addTaint(taint);
        return var641A63204CB54C67EE90D89886D51C3B_1242962996;
        // ---------- Original Method ----------
        //return new DocumentTypeImpl(null, qualifiedName, publicId, systemId);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.603 -0400", hash_original_method = "E091A0410E0BC85A7F21C3C96448A760", hash_generated_method = "75D40FD4B7A1F93F1EB7EC254038CD9D")
    public boolean hasFeature(String feature, String version) {
        addTaint(version.getTaint());
        addTaint(feature.getTaint());
        boolean anyVersion = version == null || version.length() == 0;
    if(feature.startsWith("+"))        
        {
            feature = feature.substring(1);
        } //End block
    if(feature.equalsIgnoreCase("Core"))        
        {
            boolean var1A54B3880029072766DF520F9EB48018_675810233 = (anyVersion || version.equals("1.0") || version.equals("2.0") || version.equals("3.0"));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_997112 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_997112;
        } //End block
        else
    if(feature.equalsIgnoreCase("XML"))        
        {
            boolean var1A54B3880029072766DF520F9EB48018_748356819 = (anyVersion || version.equals("1.0") || version.equals("2.0") || version.equals("3.0"));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_304448088 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_304448088;
        } //End block
        else
    if(feature.equalsIgnoreCase("XMLVersion"))        
        {
            boolean var322A4D4EC895B959D74227989356ACB8_2066395760 = (anyVersion || version.equals("1.0") || version.equals("1.1"));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_21686656 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_21686656;
        } //End block
        else
        {
            boolean var68934A3E9455FA72420237EB05902327_1834980222 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_865257736 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_865257736;
        } //End block
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

    
        @DSModeled(DSC.SAFE)
    public static DOMImplementationImpl getInstance() {
        if (instance == null) {
            instance = new DOMImplementationImpl();
        }
        return instance;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.604 -0400", hash_original_method = "F21DF5440792B1D9F1F89E7A46F56ED2", hash_generated_method = "93CFC520D1C7512331CFD95668B1693C")
    public Object getFeature(String feature, String version) {
        addTaint(version.getTaint());
        addTaint(feature.getTaint());
Object var7C9E3B075DA04DB7C5EAF70832447EEF_555486569 =         hasFeature(feature, version) ? this : null;
        var7C9E3B075DA04DB7C5EAF70832447EEF_555486569.addTaint(taint);
        return var7C9E3B075DA04DB7C5EAF70832447EEF_555486569;
        // ---------- Original Method ----------
        //return hasFeature(feature, version) ? this : null;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.604 -0400", hash_original_field = "7123A699D77DB6479A1D8ECE2C4F1C16", hash_generated_field = "DC45618DB534832F5989A3B9BE96A158")

    private static DOMImplementationImpl instance;
}

