package org.apache.harmony.xml.dom;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import org.w3c.dom.DOMException;
import org.w3c.dom.DocumentType;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

public final class DocumentTypeImpl extends LeafNodeImpl implements DocumentType {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:19.442 -0500", hash_original_field = "E65D188DFAED04B100B50EA93BB58EBB", hash_generated_field = "505E7DC5802BC20F1EF106B5FA0742F4")

    private String qualifiedName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:19.444 -0500", hash_original_field = "A787D4782D28CB658656F9CEA39140B8", hash_generated_field = "60BF385FD0C88E4BC32EFD3E71F5528C")

    private String publicId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:19.447 -0500", hash_original_field = "EA33D5D9FADC1DE12A306FAB26B3A5DA", hash_generated_field = "D8573F28EF4599A1790219EF1708D9C9")

    private String systemId;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:19.450 -0500", hash_original_method = "B3AEE891CFF5F13501F03FB795F88BCC", hash_generated_method = "347D1C7A92FB9A9F181FAE5DEE199445")
    
public DocumentTypeImpl(DocumentImpl document, String qualifiedName,
            String publicId, String systemId) {
        super(document);

        if (qualifiedName == null || "".equals(qualifiedName)) {
            throw new DOMException(DOMException.NAMESPACE_ERR, qualifiedName);
        }

        int prefixSeparator = qualifiedName.lastIndexOf(":");
        if (prefixSeparator != -1) {
            String prefix = qualifiedName.substring(0, prefixSeparator);
            String localName = qualifiedName.substring(prefixSeparator + 1);

            if (!DocumentImpl.isXMLIdentifier(prefix)) {
                throw new DOMException(DOMException.NAMESPACE_ERR, qualifiedName);
            }

            if (!DocumentImpl.isXMLIdentifier(localName)) {
                throw new DOMException(DOMException.INVALID_CHARACTER_ERR, qualifiedName);
            }
        } else {
            if (!DocumentImpl.isXMLIdentifier(qualifiedName)) {
                throw new DOMException(DOMException.INVALID_CHARACTER_ERR, qualifiedName);
            }
        }

        this.qualifiedName = qualifiedName;
        this.publicId = publicId;
        this.systemId = systemId;
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:19.452 -0500", hash_original_method = "E9049B6D3137F3441BE811CFF59C0D40", hash_generated_method = "77B7F9CBADCBFAE3E917F488F2958718")
    
@Override
    public String getNodeName() {
        return qualifiedName;
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:19.454 -0500", hash_original_method = "7D99CB31F2E6992AF80C8FC45EE7DFBE", hash_generated_method = "E5C12D218AC4800C14F55E8B398C8806")
    
@Override
    public short getNodeType() {
        return Node.DOCUMENT_TYPE_NODE;
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:19.456 -0500", hash_original_method = "B18563406FBA7004CBA96EE0AEED3600", hash_generated_method = "112AACF2AD49A6B87A70EE63F04C7328")
    
public NamedNodeMap getEntities() {
        // TODO Dummy. Implement this later, if at all (we're DOM level 2 only).
        return null;
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:19.458 -0500", hash_original_method = "1ACC60D85C446C7470ADF2E2CD7BECFD", hash_generated_method = "CF0B8041BA7C8ACF849723C11A98172B")
    
public String getInternalSubset() {
        // TODO Dummy. Implement this later, if at all (we're DOM level 2 only).
        return null;
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:19.461 -0500", hash_original_method = "4B51CCD327B7473965DE5BE67319C7E7", hash_generated_method = "98E2ABD07AF1DEAD881772D4EC3B11C8")
    
public String getName() {
        return qualifiedName;
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:19.463 -0500", hash_original_method = "521EA3163F33B14ADC5EA4FB49D4CB7E", hash_generated_method = "7FA5ABBEDCB915DCB0D1D503FDD544D2")
    
public NamedNodeMap getNotations() {
        // TODO Dummy. Implement this later, if at all (we're DOM level 2 only).
        return null;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:19.465 -0500", hash_original_method = "C19BBE926A67132A1C6BC386100A3E69", hash_generated_method = "C2B64346C205A83C958059FEF62D1E97")
    
public String getPublicId() {
        return publicId;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:19.467 -0500", hash_original_method = "8088708D8DEEE6054468B7FD77400E50", hash_generated_method = "6A03DC8D49FB90AC37FD320CD622E272")
    
public String getSystemId() {
        return systemId;
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:19.470 -0500", hash_original_method = "76D2ADCA92D33C128096DC8FD3BC4D92", hash_generated_method = "8056B0AC79DB75D9624D967FC259552F")
    
@Override public String getTextContent() throws DOMException {
        return null;
    }
    
}

