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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.856 -0400", hash_original_field = "82D2A12B58D8FC8C4E67661201BE1287", hash_generated_field = "505E7DC5802BC20F1EF106B5FA0742F4")

    private String qualifiedName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.856 -0400", hash_original_field = "24AB20BFB578F0A89FF4A9C081F21384", hash_generated_field = "60BF385FD0C88E4BC32EFD3E71F5528C")

    private String publicId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.856 -0400", hash_original_field = "089D1A278481B86E821237F8E98E6DE7", hash_generated_field = "D8573F28EF4599A1790219EF1708D9C9")

    private String systemId;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.857 -0400", hash_original_method = "B3AEE891CFF5F13501F03FB795F88BCC", hash_generated_method = "112651EDC63359F53B73623CC637949D")
    public  DocumentTypeImpl(DocumentImpl document, String qualifiedName,
            String publicId, String systemId) {
        super(document);
        {
            boolean var0C83B7F3BEFB36930E7DB0B806A1E4EE_964997809 = (qualifiedName == null || "".equals(qualifiedName));
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
                boolean var9A2B50EBC2A6BBEB86D100CFFFC328E9_1999089628 = (!DocumentImpl.isXMLIdentifier(prefix));
                {
                    if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.NAMESPACE_ERR, qualifiedName);
                } //End block
            } //End collapsed parenthetic
            {
                boolean varBCDB1049C102CF6C1E4726F5706870E3_1676958230 = (!DocumentImpl.isXMLIdentifier(localName));
                {
                    if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.INVALID_CHARACTER_ERR, qualifiedName);
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                boolean varB6AB7106C76BF58C8703F33052A6EF22_116616718 = (!DocumentImpl.isXMLIdentifier(qualifiedName));
                {
                    if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.INVALID_CHARACTER_ERR, qualifiedName);
                } //End block
            } //End collapsed parenthetic
        } //End block
        this.qualifiedName = qualifiedName;
        this.publicId = publicId;
        this.systemId = systemId;
        addTaint(document.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.858 -0400", hash_original_method = "E9049B6D3137F3441BE811CFF59C0D40", hash_generated_method = "F1362F75D178965889CCAF20A8347310")
    @Override
    public String getNodeName() {
        String varB4EAC82CA7396A68D541C85D26508E83_859425688 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_859425688 = qualifiedName;
        varB4EAC82CA7396A68D541C85D26508E83_859425688.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_859425688;
        // ---------- Original Method ----------
        //return qualifiedName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.858 -0400", hash_original_method = "7D99CB31F2E6992AF80C8FC45EE7DFBE", hash_generated_method = "4505653E9778C72A210654A1EE537B3D")
    @Override
    public short getNodeType() {
        short var4F09DAA9D95BCB166A302407A0E0BABE_739000693 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_739000693;
        // ---------- Original Method ----------
        //return Node.DOCUMENT_TYPE_NODE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.862 -0400", hash_original_method = "B18563406FBA7004CBA96EE0AEED3600", hash_generated_method = "28AE2B9F9AFDF61B031571EAD7B58187")
    public NamedNodeMap getEntities() {
        NamedNodeMap varB4EAC82CA7396A68D541C85D26508E83_1363735103 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1363735103 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1363735103.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1363735103;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.878 -0400", hash_original_method = "1ACC60D85C446C7470ADF2E2CD7BECFD", hash_generated_method = "AECE28FDE06B55D353FF9CF93EF5BD3A")
    public String getInternalSubset() {
        String varB4EAC82CA7396A68D541C85D26508E83_1691790480 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1691790480 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1691790480.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1691790480;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.879 -0400", hash_original_method = "4B51CCD327B7473965DE5BE67319C7E7", hash_generated_method = "CE062953D4F0CA16EAA219F4F1D1FA11")
    public String getName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1151668076 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1151668076 = qualifiedName;
        varB4EAC82CA7396A68D541C85D26508E83_1151668076.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1151668076;
        // ---------- Original Method ----------
        //return qualifiedName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.879 -0400", hash_original_method = "521EA3163F33B14ADC5EA4FB49D4CB7E", hash_generated_method = "FEA700C532156B91922ECAA8CFD65456")
    public NamedNodeMap getNotations() {
        NamedNodeMap varB4EAC82CA7396A68D541C85D26508E83_1687743281 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1687743281 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1687743281.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1687743281;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.880 -0400", hash_original_method = "C19BBE926A67132A1C6BC386100A3E69", hash_generated_method = "70A30111BC98CE04A0273AEE86A171B6")
    public String getPublicId() {
        String varB4EAC82CA7396A68D541C85D26508E83_1822795184 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1822795184 = publicId;
        varB4EAC82CA7396A68D541C85D26508E83_1822795184.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1822795184;
        // ---------- Original Method ----------
        //return publicId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.881 -0400", hash_original_method = "8088708D8DEEE6054468B7FD77400E50", hash_generated_method = "BF6E65852077C659FB2873A4A0D72645")
    public String getSystemId() {
        String varB4EAC82CA7396A68D541C85D26508E83_1214157205 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1214157205 = systemId;
        varB4EAC82CA7396A68D541C85D26508E83_1214157205.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1214157205;
        // ---------- Original Method ----------
        //return systemId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.882 -0400", hash_original_method = "76D2ADCA92D33C128096DC8FD3BC4D92", hash_generated_method = "C4A733A734CAE447C554B5E771869783")
    @Override
    public String getTextContent() throws DOMException {
        String varB4EAC82CA7396A68D541C85D26508E83_871513396 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_871513396 = null;
        varB4EAC82CA7396A68D541C85D26508E83_871513396.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_871513396;
        // ---------- Original Method ----------
        //return null;
    }

    
}

