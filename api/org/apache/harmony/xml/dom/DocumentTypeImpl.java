package org.apache.harmony.xml.dom;

// Droidsafe Imports
import droidsafe.annotations.*;
import org.w3c.dom.DOMException;
import org.w3c.dom.DocumentType;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;






public final class DocumentTypeImpl extends LeafNodeImpl implements DocumentType {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.389 -0400", hash_original_field = "82D2A12B58D8FC8C4E67661201BE1287", hash_generated_field = "505E7DC5802BC20F1EF106B5FA0742F4")

    private String qualifiedName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.390 -0400", hash_original_field = "24AB20BFB578F0A89FF4A9C081F21384", hash_generated_field = "60BF385FD0C88E4BC32EFD3E71F5528C")

    private String publicId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.390 -0400", hash_original_field = "089D1A278481B86E821237F8E98E6DE7", hash_generated_field = "D8573F28EF4599A1790219EF1708D9C9")

    private String systemId;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.391 -0400", hash_original_method = "B3AEE891CFF5F13501F03FB795F88BCC", hash_generated_method = "B34DD8F9FB1F711A249B2AB9948D1036")
    public  DocumentTypeImpl(DocumentImpl document, String qualifiedName,
            String publicId, String systemId) {
        super(document);
        addTaint(document.getTaint());
        if(qualifiedName == null || "".equals(qualifiedName))        
        {
            DOMException varEAAE8BE21121199D1902FAF31A9B641A_778367416 = new DOMException(DOMException.NAMESPACE_ERR, qualifiedName);
            varEAAE8BE21121199D1902FAF31A9B641A_778367416.addTaint(taint);
            throw varEAAE8BE21121199D1902FAF31A9B641A_778367416;
        } //End block
        int prefixSeparator = qualifiedName.lastIndexOf(":");
        if(prefixSeparator != -1)        
        {
            String prefix = qualifiedName.substring(0, prefixSeparator);
            String localName = qualifiedName.substring(prefixSeparator + 1);
            if(!DocumentImpl.isXMLIdentifier(prefix))            
            {
                DOMException varEAAE8BE21121199D1902FAF31A9B641A_414010824 = new DOMException(DOMException.NAMESPACE_ERR, qualifiedName);
                varEAAE8BE21121199D1902FAF31A9B641A_414010824.addTaint(taint);
                throw varEAAE8BE21121199D1902FAF31A9B641A_414010824;
            } //End block
            if(!DocumentImpl.isXMLIdentifier(localName))            
            {
                DOMException varD106CF1F7CB6D35A107B0C19A28BA57E_1070970444 = new DOMException(DOMException.INVALID_CHARACTER_ERR, qualifiedName);
                varD106CF1F7CB6D35A107B0C19A28BA57E_1070970444.addTaint(taint);
                throw varD106CF1F7CB6D35A107B0C19A28BA57E_1070970444;
            } //End block
        } //End block
        else
        {
            if(!DocumentImpl.isXMLIdentifier(qualifiedName))            
            {
                DOMException varD106CF1F7CB6D35A107B0C19A28BA57E_1690268198 = new DOMException(DOMException.INVALID_CHARACTER_ERR, qualifiedName);
                varD106CF1F7CB6D35A107B0C19A28BA57E_1690268198.addTaint(taint);
                throw varD106CF1F7CB6D35A107B0C19A28BA57E_1690268198;
            } //End block
        } //End block
        this.qualifiedName = qualifiedName;
        this.publicId = publicId;
        this.systemId = systemId;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.392 -0400", hash_original_method = "E9049B6D3137F3441BE811CFF59C0D40", hash_generated_method = "9253A7B690B6EBCC50E038557A81909C")
    @Override
    public String getNodeName() {
String var094FD20AC4EEFAADAC7ED29B93015D2D_856521334 =         qualifiedName;
        var094FD20AC4EEFAADAC7ED29B93015D2D_856521334.addTaint(taint);
        return var094FD20AC4EEFAADAC7ED29B93015D2D_856521334;
        // ---------- Original Method ----------
        //return qualifiedName;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.392 -0400", hash_original_method = "7D99CB31F2E6992AF80C8FC45EE7DFBE", hash_generated_method = "5F68CBAD724046757464B304F91C213C")
    @Override
    public short getNodeType() {
        short var6A78A533359938F5F86187BF62D05B1A_1637890962 = (Node.DOCUMENT_TYPE_NODE);
                short var4F09DAA9D95BCB166A302407A0E0BABE_441604193 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_441604193;
        // ---------- Original Method ----------
        //return Node.DOCUMENT_TYPE_NODE;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.392 -0400", hash_original_method = "B18563406FBA7004CBA96EE0AEED3600", hash_generated_method = "232C264CB1F2E703DA2B8BC17965F6C0")
    public NamedNodeMap getEntities() {
NamedNodeMap var540C13E9E156B687226421B24F2DF178_646644876 =         null;
        var540C13E9E156B687226421B24F2DF178_646644876.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_646644876;
        // ---------- Original Method ----------
        //return null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.392 -0400", hash_original_method = "1ACC60D85C446C7470ADF2E2CD7BECFD", hash_generated_method = "470836C38B767196C8FACDDB26108CE1")
    public String getInternalSubset() {
String var540C13E9E156B687226421B24F2DF178_1337357693 =         null;
        var540C13E9E156B687226421B24F2DF178_1337357693.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1337357693;
        // ---------- Original Method ----------
        //return null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.392 -0400", hash_original_method = "4B51CCD327B7473965DE5BE67319C7E7", hash_generated_method = "387ED9EBE3085F0EEB14547F55B03673")
    public String getName() {
String var094FD20AC4EEFAADAC7ED29B93015D2D_303973454 =         qualifiedName;
        var094FD20AC4EEFAADAC7ED29B93015D2D_303973454.addTaint(taint);
        return var094FD20AC4EEFAADAC7ED29B93015D2D_303973454;
        // ---------- Original Method ----------
        //return qualifiedName;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.393 -0400", hash_original_method = "521EA3163F33B14ADC5EA4FB49D4CB7E", hash_generated_method = "B9B0819FC9DFCB7BDA8631F76F8E05FF")
    public NamedNodeMap getNotations() {
NamedNodeMap var540C13E9E156B687226421B24F2DF178_581307066 =         null;
        var540C13E9E156B687226421B24F2DF178_581307066.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_581307066;
        // ---------- Original Method ----------
        //return null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.394 -0400", hash_original_method = "C19BBE926A67132A1C6BC386100A3E69", hash_generated_method = "D69AE949E7025157C6B5D3DF6C4D9640")
    public String getPublicId() {
String var76991CCBEF027A0871CF61642EBA53AB_1785435958 =         publicId;
        var76991CCBEF027A0871CF61642EBA53AB_1785435958.addTaint(taint);
        return var76991CCBEF027A0871CF61642EBA53AB_1785435958;
        // ---------- Original Method ----------
        //return publicId;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.394 -0400", hash_original_method = "8088708D8DEEE6054468B7FD77400E50", hash_generated_method = "AAAAA039819C14CAF3C14D76CCD63A35")
    public String getSystemId() {
String varB7D0727ACC7388EA86587212DD1C6E9F_285670984 =         systemId;
        varB7D0727ACC7388EA86587212DD1C6E9F_285670984.addTaint(taint);
        return varB7D0727ACC7388EA86587212DD1C6E9F_285670984;
        // ---------- Original Method ----------
        //return systemId;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.395 -0400", hash_original_method = "76D2ADCA92D33C128096DC8FD3BC4D92", hash_generated_method = "EA401C40BA7DD09D6452359F9B127F27")
    @Override
    public String getTextContent() throws DOMException {
String var540C13E9E156B687226421B24F2DF178_1606958686 =         null;
        var540C13E9E156B687226421B24F2DF178_1606958686.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1606958686;
        // ---------- Original Method ----------
        //return null;
    }

    
}

