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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.736 -0400", hash_original_field = "82D2A12B58D8FC8C4E67661201BE1287", hash_generated_field = "505E7DC5802BC20F1EF106B5FA0742F4")

    private String qualifiedName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.736 -0400", hash_original_field = "24AB20BFB578F0A89FF4A9C081F21384", hash_generated_field = "60BF385FD0C88E4BC32EFD3E71F5528C")

    private String publicId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.736 -0400", hash_original_field = "089D1A278481B86E821237F8E98E6DE7", hash_generated_field = "D8573F28EF4599A1790219EF1708D9C9")

    private String systemId;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.739 -0400", hash_original_method = "B3AEE891CFF5F13501F03FB795F88BCC", hash_generated_method = "E372C78F4808E87285BCA38D3CB0AAC9")
    public  DocumentTypeImpl(DocumentImpl document, String qualifiedName,
            String publicId, String systemId) {
        super(document);
        {
            boolean var0C83B7F3BEFB36930E7DB0B806A1E4EE_822782034 = (qualifiedName == null || "".equals(qualifiedName));
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
                boolean var9A2B50EBC2A6BBEB86D100CFFFC328E9_1523922421 = (!DocumentImpl.isXMLIdentifier(prefix));
                {
                    if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.NAMESPACE_ERR, qualifiedName);
                } //End block
            } //End collapsed parenthetic
            {
                boolean varBCDB1049C102CF6C1E4726F5706870E3_1145647620 = (!DocumentImpl.isXMLIdentifier(localName));
                {
                    if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.INVALID_CHARACTER_ERR, qualifiedName);
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                boolean varB6AB7106C76BF58C8703F33052A6EF22_1194976143 = (!DocumentImpl.isXMLIdentifier(qualifiedName));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.740 -0400", hash_original_method = "E9049B6D3137F3441BE811CFF59C0D40", hash_generated_method = "B7C688F2650E4FA8D08AF8C0F38C6274")
    @Override
    public String getNodeName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1191802027 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1191802027 = qualifiedName;
        varB4EAC82CA7396A68D541C85D26508E83_1191802027.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1191802027;
        // ---------- Original Method ----------
        //return qualifiedName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.740 -0400", hash_original_method = "7D99CB31F2E6992AF80C8FC45EE7DFBE", hash_generated_method = "523C85A3A3834FB6B5DD2555483B1C02")
    @Override
    public short getNodeType() {
        short var4F09DAA9D95BCB166A302407A0E0BABE_576542993 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_576542993;
        // ---------- Original Method ----------
        //return Node.DOCUMENT_TYPE_NODE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.741 -0400", hash_original_method = "B18563406FBA7004CBA96EE0AEED3600", hash_generated_method = "5F99F8E8844A233B11146314F83FE744")
    public NamedNodeMap getEntities() {
        NamedNodeMap varB4EAC82CA7396A68D541C85D26508E83_1909143774 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1909143774 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1909143774.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1909143774;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.741 -0400", hash_original_method = "1ACC60D85C446C7470ADF2E2CD7BECFD", hash_generated_method = "59E38EB209D14771F4C9B6ACAE05B0F8")
    public String getInternalSubset() {
        String varB4EAC82CA7396A68D541C85D26508E83_1770615727 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1770615727 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1770615727.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1770615727;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.741 -0400", hash_original_method = "4B51CCD327B7473965DE5BE67319C7E7", hash_generated_method = "0E70FA2B107688AC536AEE836EDE36B8")
    public String getName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1385668308 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1385668308 = qualifiedName;
        varB4EAC82CA7396A68D541C85D26508E83_1385668308.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1385668308;
        // ---------- Original Method ----------
        //return qualifiedName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.742 -0400", hash_original_method = "521EA3163F33B14ADC5EA4FB49D4CB7E", hash_generated_method = "AA86E68FD0668EA876E46341D45C44B6")
    public NamedNodeMap getNotations() {
        NamedNodeMap varB4EAC82CA7396A68D541C85D26508E83_802255974 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_802255974 = null;
        varB4EAC82CA7396A68D541C85D26508E83_802255974.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_802255974;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.747 -0400", hash_original_method = "C19BBE926A67132A1C6BC386100A3E69", hash_generated_method = "6FDC1BACC5F35383030DE03525DE0F3A")
    public String getPublicId() {
        String varB4EAC82CA7396A68D541C85D26508E83_374484445 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_374484445 = publicId;
        varB4EAC82CA7396A68D541C85D26508E83_374484445.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_374484445;
        // ---------- Original Method ----------
        //return publicId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.747 -0400", hash_original_method = "8088708D8DEEE6054468B7FD77400E50", hash_generated_method = "E45A08089DC659F5863A649ABDA362B4")
    public String getSystemId() {
        String varB4EAC82CA7396A68D541C85D26508E83_1362815478 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1362815478 = systemId;
        varB4EAC82CA7396A68D541C85D26508E83_1362815478.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1362815478;
        // ---------- Original Method ----------
        //return systemId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.748 -0400", hash_original_method = "76D2ADCA92D33C128096DC8FD3BC4D92", hash_generated_method = "0D89F3CDF130F5990C98534455D7D431")
    @Override
    public String getTextContent() throws DOMException {
        String varB4EAC82CA7396A68D541C85D26508E83_1244526768 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1244526768 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1244526768.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1244526768;
        // ---------- Original Method ----------
        //return null;
    }

    
}

