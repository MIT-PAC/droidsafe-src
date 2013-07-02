package org.apache.harmony.xml.dom;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import org.w3c.dom.DOMException;
import org.w3c.dom.DocumentType;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

public final class DocumentTypeImpl extends LeafNodeImpl implements DocumentType {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.018 -0400", hash_original_field = "82D2A12B58D8FC8C4E67661201BE1287", hash_generated_field = "505E7DC5802BC20F1EF106B5FA0742F4")

    private String qualifiedName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.018 -0400", hash_original_field = "24AB20BFB578F0A89FF4A9C081F21384", hash_generated_field = "60BF385FD0C88E4BC32EFD3E71F5528C")

    private String publicId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.018 -0400", hash_original_field = "089D1A278481B86E821237F8E98E6DE7", hash_generated_field = "D8573F28EF4599A1790219EF1708D9C9")

    private String systemId;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.018 -0400", hash_original_method = "B3AEE891CFF5F13501F03FB795F88BCC", hash_generated_method = "15615B032C0C6674AB14077C45E32116")
    public  DocumentTypeImpl(DocumentImpl document, String qualifiedName,
            String publicId, String systemId) {
        super(document);
        {
            boolean var0C83B7F3BEFB36930E7DB0B806A1E4EE_1790511612 = (qualifiedName == null || "".equals(qualifiedName));
            {
                if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.NAMESPACE_ERR, qualifiedName);
            } 
        } 
        int prefixSeparator = qualifiedName.lastIndexOf(":");
        {
            String prefix = qualifiedName.substring(0, prefixSeparator);
            String localName = qualifiedName.substring(prefixSeparator + 1);
            {
                boolean var9A2B50EBC2A6BBEB86D100CFFFC328E9_877802597 = (!DocumentImpl.isXMLIdentifier(prefix));
                {
                    if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.NAMESPACE_ERR, qualifiedName);
                } 
            } 
            {
                boolean varBCDB1049C102CF6C1E4726F5706870E3_1556402272 = (!DocumentImpl.isXMLIdentifier(localName));
                {
                    if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.INVALID_CHARACTER_ERR, qualifiedName);
                } 
            } 
        } 
        {
            {
                boolean varB6AB7106C76BF58C8703F33052A6EF22_288950147 = (!DocumentImpl.isXMLIdentifier(qualifiedName));
                {
                    if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.INVALID_CHARACTER_ERR, qualifiedName);
                } 
            } 
        } 
        this.qualifiedName = qualifiedName;
        this.publicId = publicId;
        this.systemId = systemId;
        addTaint(document.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.019 -0400", hash_original_method = "E9049B6D3137F3441BE811CFF59C0D40", hash_generated_method = "8C874AF13B774A5BC0F1E3CBF51CF94F")
    @Override
    public String getNodeName() {
        String varB4EAC82CA7396A68D541C85D26508E83_568972274 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_568972274 = qualifiedName;
        varB4EAC82CA7396A68D541C85D26508E83_568972274.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_568972274;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.019 -0400", hash_original_method = "7D99CB31F2E6992AF80C8FC45EE7DFBE", hash_generated_method = "30FDE7FEC8452C43C0934031445EEBF1")
    @Override
    public short getNodeType() {
        short var4F09DAA9D95BCB166A302407A0E0BABE_2026457524 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_2026457524;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.020 -0400", hash_original_method = "B18563406FBA7004CBA96EE0AEED3600", hash_generated_method = "76DFCB8599593A63E9AC0510634ED99D")
    public NamedNodeMap getEntities() {
        NamedNodeMap varB4EAC82CA7396A68D541C85D26508E83_1393750691 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1393750691 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1393750691.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1393750691;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.021 -0400", hash_original_method = "1ACC60D85C446C7470ADF2E2CD7BECFD", hash_generated_method = "F304B333DEA86FA83A311DD8F1885C30")
    public String getInternalSubset() {
        String varB4EAC82CA7396A68D541C85D26508E83_1003687019 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1003687019 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1003687019.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1003687019;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.022 -0400", hash_original_method = "4B51CCD327B7473965DE5BE67319C7E7", hash_generated_method = "943D8758E558EB92ADD76AE189966AC6")
    public String getName() {
        String varB4EAC82CA7396A68D541C85D26508E83_4659300 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_4659300 = qualifiedName;
        varB4EAC82CA7396A68D541C85D26508E83_4659300.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_4659300;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.022 -0400", hash_original_method = "521EA3163F33B14ADC5EA4FB49D4CB7E", hash_generated_method = "684894B499715BBB9312FB8D67DC68F1")
    public NamedNodeMap getNotations() {
        NamedNodeMap varB4EAC82CA7396A68D541C85D26508E83_870185502 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_870185502 = null;
        varB4EAC82CA7396A68D541C85D26508E83_870185502.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_870185502;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.024 -0400", hash_original_method = "C19BBE926A67132A1C6BC386100A3E69", hash_generated_method = "0DBE326AF07AAA32BAA1BF55F105050E")
    public String getPublicId() {
        String varB4EAC82CA7396A68D541C85D26508E83_1445518278 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1445518278 = publicId;
        varB4EAC82CA7396A68D541C85D26508E83_1445518278.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1445518278;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.026 -0400", hash_original_method = "8088708D8DEEE6054468B7FD77400E50", hash_generated_method = "2AEB1EBEFE3DA15ECB49F69E270FAA73")
    public String getSystemId() {
        String varB4EAC82CA7396A68D541C85D26508E83_685603914 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_685603914 = systemId;
        varB4EAC82CA7396A68D541C85D26508E83_685603914.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_685603914;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.027 -0400", hash_original_method = "76D2ADCA92D33C128096DC8FD3BC4D92", hash_generated_method = "206286D64BDEFE2E160E158AE39E1280")
    @Override
    public String getTextContent() throws DOMException {
        String varB4EAC82CA7396A68D541C85D26508E83_1890643684 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1890643684 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1890643684.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1890643684;
        
        
    }

    
}

