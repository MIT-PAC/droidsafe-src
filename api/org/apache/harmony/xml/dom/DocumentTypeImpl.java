package org.apache.harmony.xml.dom;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import org.w3c.dom.DOMException;
import org.w3c.dom.DocumentType;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

public final class DocumentTypeImpl extends LeafNodeImpl implements DocumentType {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.685 -0400", hash_original_field = "82D2A12B58D8FC8C4E67661201BE1287", hash_generated_field = "505E7DC5802BC20F1EF106B5FA0742F4")

    private String qualifiedName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.685 -0400", hash_original_field = "24AB20BFB578F0A89FF4A9C081F21384", hash_generated_field = "60BF385FD0C88E4BC32EFD3E71F5528C")

    private String publicId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.685 -0400", hash_original_field = "089D1A278481B86E821237F8E98E6DE7", hash_generated_field = "D8573F28EF4599A1790219EF1708D9C9")

    private String systemId;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.686 -0400", hash_original_method = "B3AEE891CFF5F13501F03FB795F88BCC", hash_generated_method = "94DC658A962803E4C2A3BDE48DF002C4")
    public  DocumentTypeImpl(DocumentImpl document, String qualifiedName,
            String publicId, String systemId) {
        super(document);
        addTaint(document.getTaint());
    if(qualifiedName == null || "".equals(qualifiedName))        
        {
            DOMException varEAAE8BE21121199D1902FAF31A9B641A_816129464 = new DOMException(DOMException.NAMESPACE_ERR, qualifiedName);
            varEAAE8BE21121199D1902FAF31A9B641A_816129464.addTaint(taint);
            throw varEAAE8BE21121199D1902FAF31A9B641A_816129464;
        } //End block
        int prefixSeparator = qualifiedName.lastIndexOf(":");
    if(prefixSeparator != -1)        
        {
            String prefix = qualifiedName.substring(0, prefixSeparator);
            String localName = qualifiedName.substring(prefixSeparator + 1);
    if(!DocumentImpl.isXMLIdentifier(prefix))            
            {
                DOMException varEAAE8BE21121199D1902FAF31A9B641A_428558154 = new DOMException(DOMException.NAMESPACE_ERR, qualifiedName);
                varEAAE8BE21121199D1902FAF31A9B641A_428558154.addTaint(taint);
                throw varEAAE8BE21121199D1902FAF31A9B641A_428558154;
            } //End block
    if(!DocumentImpl.isXMLIdentifier(localName))            
            {
                DOMException varD106CF1F7CB6D35A107B0C19A28BA57E_1888341702 = new DOMException(DOMException.INVALID_CHARACTER_ERR, qualifiedName);
                varD106CF1F7CB6D35A107B0C19A28BA57E_1888341702.addTaint(taint);
                throw varD106CF1F7CB6D35A107B0C19A28BA57E_1888341702;
            } //End block
        } //End block
        else
        {
    if(!DocumentImpl.isXMLIdentifier(qualifiedName))            
            {
                DOMException varD106CF1F7CB6D35A107B0C19A28BA57E_1388816409 = new DOMException(DOMException.INVALID_CHARACTER_ERR, qualifiedName);
                varD106CF1F7CB6D35A107B0C19A28BA57E_1388816409.addTaint(taint);
                throw varD106CF1F7CB6D35A107B0C19A28BA57E_1388816409;
            } //End block
        } //End block
        this.qualifiedName = qualifiedName;
        this.publicId = publicId;
        this.systemId = systemId;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.686 -0400", hash_original_method = "E9049B6D3137F3441BE811CFF59C0D40", hash_generated_method = "C93DF48B1F111F1383A6A999FDD178B2")
    @Override
    public String getNodeName() {
String var094FD20AC4EEFAADAC7ED29B93015D2D_24351218 =         qualifiedName;
        var094FD20AC4EEFAADAC7ED29B93015D2D_24351218.addTaint(taint);
        return var094FD20AC4EEFAADAC7ED29B93015D2D_24351218;
        // ---------- Original Method ----------
        //return qualifiedName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.687 -0400", hash_original_method = "7D99CB31F2E6992AF80C8FC45EE7DFBE", hash_generated_method = "7E2C418CB9343930851279FA51AE9606")
    @Override
    public short getNodeType() {
        short var6A78A533359938F5F86187BF62D05B1A_1418353122 = (Node.DOCUMENT_TYPE_NODE);
                short var4F09DAA9D95BCB166A302407A0E0BABE_830221838 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_830221838;
        // ---------- Original Method ----------
        //return Node.DOCUMENT_TYPE_NODE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.687 -0400", hash_original_method = "B18563406FBA7004CBA96EE0AEED3600", hash_generated_method = "D1ABB8ECB603DAC52D1E60ABDE135859")
    public NamedNodeMap getEntities() {
NamedNodeMap var540C13E9E156B687226421B24F2DF178_2011122165 =         null;
        var540C13E9E156B687226421B24F2DF178_2011122165.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_2011122165;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.687 -0400", hash_original_method = "1ACC60D85C446C7470ADF2E2CD7BECFD", hash_generated_method = "C571D6C15C17142826A898142426A5AB")
    public String getInternalSubset() {
String var540C13E9E156B687226421B24F2DF178_1243182241 =         null;
        var540C13E9E156B687226421B24F2DF178_1243182241.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1243182241;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.687 -0400", hash_original_method = "4B51CCD327B7473965DE5BE67319C7E7", hash_generated_method = "D7958B1064FFD65948386090858BF567")
    public String getName() {
String var094FD20AC4EEFAADAC7ED29B93015D2D_2136805084 =         qualifiedName;
        var094FD20AC4EEFAADAC7ED29B93015D2D_2136805084.addTaint(taint);
        return var094FD20AC4EEFAADAC7ED29B93015D2D_2136805084;
        // ---------- Original Method ----------
        //return qualifiedName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.688 -0400", hash_original_method = "521EA3163F33B14ADC5EA4FB49D4CB7E", hash_generated_method = "998CB3EBA474E8461A71021EA07418A9")
    public NamedNodeMap getNotations() {
NamedNodeMap var540C13E9E156B687226421B24F2DF178_1371397196 =         null;
        var540C13E9E156B687226421B24F2DF178_1371397196.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1371397196;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.688 -0400", hash_original_method = "C19BBE926A67132A1C6BC386100A3E69", hash_generated_method = "4C35CCD7459CBF108086CC78B69AE7CD")
    public String getPublicId() {
String var76991CCBEF027A0871CF61642EBA53AB_1515292021 =         publicId;
        var76991CCBEF027A0871CF61642EBA53AB_1515292021.addTaint(taint);
        return var76991CCBEF027A0871CF61642EBA53AB_1515292021;
        // ---------- Original Method ----------
        //return publicId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.688 -0400", hash_original_method = "8088708D8DEEE6054468B7FD77400E50", hash_generated_method = "792A0E6F22E4008FAAF4D743B3A2C6C9")
    public String getSystemId() {
String varB7D0727ACC7388EA86587212DD1C6E9F_1484164643 =         systemId;
        varB7D0727ACC7388EA86587212DD1C6E9F_1484164643.addTaint(taint);
        return varB7D0727ACC7388EA86587212DD1C6E9F_1484164643;
        // ---------- Original Method ----------
        //return systemId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.688 -0400", hash_original_method = "76D2ADCA92D33C128096DC8FD3BC4D92", hash_generated_method = "61271644990D6E1039ED4A8197563219")
    @Override
    public String getTextContent() throws DOMException {
String var540C13E9E156B687226421B24F2DF178_459089583 =         null;
        var540C13E9E156B687226421B24F2DF178_459089583.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_459089583;
        // ---------- Original Method ----------
        //return null;
    }

    
}

