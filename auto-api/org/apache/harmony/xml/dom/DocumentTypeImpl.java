package org.apache.harmony.xml.dom;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.w3c.dom.DOMException;
import org.w3c.dom.DocumentType;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

public final class DocumentTypeImpl extends LeafNodeImpl implements DocumentType {
    private String qualifiedName;
    private String publicId;
    private String systemId;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.245 -0400", hash_original_method = "B3AEE891CFF5F13501F03FB795F88BCC", hash_generated_method = "C0260BFCDACC1C4279327AB4EDB9EF5B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public DocumentTypeImpl(DocumentImpl document, String qualifiedName,
            String publicId, String systemId) {
        super(document);
        dsTaint.addTaint(document.dsTaint);
        dsTaint.addTaint(qualifiedName);
        dsTaint.addTaint(publicId);
        dsTaint.addTaint(systemId);
        {
            boolean var0C83B7F3BEFB36930E7DB0B806A1E4EE_1383022389 = (qualifiedName == null || "".equals(qualifiedName));
            {
                if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.NAMESPACE_ERR, qualifiedName);
            } //End block
        } //End collapsed parenthetic
        int prefixSeparator;
        prefixSeparator = qualifiedName.lastIndexOf(":");
        {
            String prefix;
            prefix = qualifiedName.substring(0, prefixSeparator);
            String localName;
            localName = qualifiedName.substring(prefixSeparator + 1);
            {
                boolean var9A2B50EBC2A6BBEB86D100CFFFC328E9_1711209413 = (!DocumentImpl.isXMLIdentifier(prefix));
                {
                    if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.NAMESPACE_ERR, qualifiedName);
                } //End block
            } //End collapsed parenthetic
            {
                boolean varBCDB1049C102CF6C1E4726F5706870E3_1445889599 = (!DocumentImpl.isXMLIdentifier(localName));
                {
                    if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.INVALID_CHARACTER_ERR, qualifiedName);
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                boolean varB6AB7106C76BF58C8703F33052A6EF22_181681307 = (!DocumentImpl.isXMLIdentifier(qualifiedName));
                {
                    if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.INVALID_CHARACTER_ERR, qualifiedName);
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.245 -0400", hash_original_method = "E9049B6D3137F3441BE811CFF59C0D40", hash_generated_method = "AC91E2DDEF9A6D401F96CC1252862D05")
    @DSModeled(DSC.SAFE)
    @Override
    public String getNodeName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return qualifiedName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.245 -0400", hash_original_method = "7D99CB31F2E6992AF80C8FC45EE7DFBE", hash_generated_method = "33144E874486A40755E77DEFBB7BB884")
    @DSModeled(DSC.SAFE)
    @Override
    public short getNodeType() {
        return dsTaint.getTaintShort();
        // ---------- Original Method ----------
        //return Node.DOCUMENT_TYPE_NODE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.246 -0400", hash_original_method = "B18563406FBA7004CBA96EE0AEED3600", hash_generated_method = "5D45174863FCFF1A47F238CDE6296D38")
    @DSModeled(DSC.SAFE)
    public NamedNodeMap getEntities() {
        return (NamedNodeMap)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.246 -0400", hash_original_method = "1ACC60D85C446C7470ADF2E2CD7BECFD", hash_generated_method = "A990DC21A9566ECE7D1942BE28CCD27A")
    @DSModeled(DSC.SAFE)
    public String getInternalSubset() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.246 -0400", hash_original_method = "4B51CCD327B7473965DE5BE67319C7E7", hash_generated_method = "DE471D451F9CE7C1DF367E2765743000")
    @DSModeled(DSC.SAFE)
    public String getName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return qualifiedName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.246 -0400", hash_original_method = "521EA3163F33B14ADC5EA4FB49D4CB7E", hash_generated_method = "C649DC0521F47A754501FDAC255FC978")
    @DSModeled(DSC.SAFE)
    public NamedNodeMap getNotations() {
        return (NamedNodeMap)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.246 -0400", hash_original_method = "C19BBE926A67132A1C6BC386100A3E69", hash_generated_method = "80E14D34056E183CC70BFA8E6AC62A29")
    @DSModeled(DSC.SAFE)
    public String getPublicId() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return publicId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.246 -0400", hash_original_method = "8088708D8DEEE6054468B7FD77400E50", hash_generated_method = "A23C365E1375B215042F45D99272D5FD")
    @DSModeled(DSC.SAFE)
    public String getSystemId() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return systemId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.247 -0400", hash_original_method = "76D2ADCA92D33C128096DC8FD3BC4D92", hash_generated_method = "60178648D129723205777A50222806C3")
    @DSModeled(DSC.SAFE)
    @Override
    public String getTextContent() throws DOMException {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return null;
    }

    
}

