package org.apache.harmony.xml;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import libcore.io.IoUtils;
import org.xml.sax.ContentHandler;
import org.xml.sax.DTDHandler;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;
import org.xml.sax.XMLReader;
import org.xml.sax.ext.LexicalHandler;

public class ExpatReader implements XMLReader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:31.011 -0400", hash_original_field = "578F5B86519FF4351B2665A38DD14BC9", hash_generated_field = "F0B36C97F7B57E341954B85DB9C0C08E")

    ContentHandler contentHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:31.011 -0400", hash_original_field = "675358325C4A25C582575F3E0D7B3B2E", hash_generated_field = "1DE4F92C3694DD72282E703A9C497860")

    DTDHandler dtdHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:31.011 -0400", hash_original_field = "EABB965CB8BE873142A4DA0189C06FD8", hash_generated_field = "0F20E0B3BF6506A85F7C0D2D3D40FE9D")

    EntityResolver entityResolver;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:31.011 -0400", hash_original_field = "F56352FA359A5F4533A25E5F29D527F4", hash_generated_field = "D1E7497C7DFC94EB56211895742439AB")

    ErrorHandler errorHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:31.011 -0400", hash_original_field = "F8428D0A3B7DA53007818A67088E3DE1", hash_generated_field = "0A9AFAA2B0505C00F2ECAD506C3C72F7")

    LexicalHandler lexicalHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:31.011 -0400", hash_original_field = "15C4D6DFFA5ABB29F81DE4E99A3807F9", hash_generated_field = "DA06DC238CFD0DC0251460B8E2E7F05F")

    private boolean processNamespaces = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:31.011 -0400", hash_original_field = "3F43F385BAD88E4D2C207047289F625A", hash_generated_field = "571B94DE5D091BD853A513AE92780624")

    private boolean processNamespacePrefixes = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:31.011 -0400", hash_original_method = "0527B9275A46E7773519FE6EE020706F", hash_generated_method = "0527B9275A46E7773519FE6EE020706F")
    public ExpatReader ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:31.012 -0400", hash_original_method = "783B372D10B457C55DE61BCE252421E8", hash_generated_method = "E6F1A3EEB70C8CA543E1C99AC326B17F")
    public boolean getFeature(String name) throws SAXNotRecognizedException, SAXNotSupportedException {
        addTaint(name.getTaint());
    if(name == null)        
        {
            NullPointerException varA117BA528B11F7D1AC96CABFD5286E5C_593708383 = new NullPointerException("name == null");
            varA117BA528B11F7D1AC96CABFD5286E5C_593708383.addTaint(taint);
            throw varA117BA528B11F7D1AC96CABFD5286E5C_593708383;
        } //End block
    if(name.equals(Feature.VALIDATION)
                || name.equals(Feature.EXTERNAL_GENERAL_ENTITIES)
                || name.equals(Feature.EXTERNAL_PARAMETER_ENTITIES))        
        {
            boolean var68934A3E9455FA72420237EB05902327_2145034625 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_455322978 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_455322978;
        } //End block
    if(name.equals(Feature.NAMESPACES))        
        {
            boolean varA1F90DC0949B964CF3CD56D32EFE56BC_2099184947 = (processNamespaces);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_553683428 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_553683428;
        } //End block
    if(name.equals(Feature.NAMESPACE_PREFIXES))        
        {
            boolean var927838188E10ED01C9B4CBE415401448_1767680685 = (processNamespacePrefixes);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_36509761 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_36509761;
        } //End block
    if(name.equals(Feature.STRING_INTERNING))        
        {
            boolean varB326B5062B2F0E69046810717534CB09_615041569 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_113591089 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_113591089;
        } //End block
        SAXNotRecognizedException var5FC954F6CCADD58BC8498AD6F3DB9EC4_1708840675 = new SAXNotRecognizedException(name);
        var5FC954F6CCADD58BC8498AD6F3DB9EC4_1708840675.addTaint(taint);
        throw var5FC954F6CCADD58BC8498AD6F3DB9EC4_1708840675;
        // ---------- Original Method ----------
        //if (name == null) {
            //throw new NullPointerException("name == null");
        //}
        //if (name.equals(Feature.VALIDATION)
                //|| name.equals(Feature.EXTERNAL_GENERAL_ENTITIES)
                //|| name.equals(Feature.EXTERNAL_PARAMETER_ENTITIES)) {
            //return false;
        //}
        //if (name.equals(Feature.NAMESPACES)) {
            //return processNamespaces;
        //}
        //if (name.equals(Feature.NAMESPACE_PREFIXES)) {
            //return processNamespacePrefixes;
        //}
        //if (name.equals(Feature.STRING_INTERNING)) {
            //return true;
        //}
        //throw new SAXNotRecognizedException(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:31.013 -0400", hash_original_method = "6C812262457371E1512166CE4A83ADE9", hash_generated_method = "7BE8664457B7EAF695EC2E48133B162A")
    public void setFeature(String name, boolean value) throws SAXNotRecognizedException, SAXNotSupportedException {
        addTaint(name.getTaint());
    if(name == null)        
        {
            NullPointerException varA117BA528B11F7D1AC96CABFD5286E5C_94576399 = new NullPointerException("name == null");
            varA117BA528B11F7D1AC96CABFD5286E5C_94576399.addTaint(taint);
            throw varA117BA528B11F7D1AC96CABFD5286E5C_94576399;
        } //End block
    if(name.equals(Feature.VALIDATION)
                || name.equals(Feature.EXTERNAL_GENERAL_ENTITIES)
                || name.equals(Feature.EXTERNAL_PARAMETER_ENTITIES))        
        {
    if(value)            
            {
                SAXNotSupportedException var53E60CACA3362DC1DCF43B01E153E97C_1577493763 = new SAXNotSupportedException("Cannot enable " + name);
                var53E60CACA3362DC1DCF43B01E153E97C_1577493763.addTaint(taint);
                throw var53E60CACA3362DC1DCF43B01E153E97C_1577493763;
            } //End block
            else
            {
                return;
            } //End block
        } //End block
    if(name.equals(Feature.NAMESPACES))        
        {
            processNamespaces = value;
            return;
        } //End block
    if(name.equals(Feature.NAMESPACE_PREFIXES))        
        {
            processNamespacePrefixes = value;
            return;
        } //End block
    if(name.equals(Feature.STRING_INTERNING))        
        {
    if(value)            
            {
                return;
            } //End block
            else
            {
                SAXNotSupportedException var48CABC7DECC68EFB24C707B5924BC004_2041571425 = new SAXNotSupportedException("Cannot disable " + name);
                var48CABC7DECC68EFB24C707B5924BC004_2041571425.addTaint(taint);
                throw var48CABC7DECC68EFB24C707B5924BC004_2041571425;
            } //End block
        } //End block
        SAXNotRecognizedException var5FC954F6CCADD58BC8498AD6F3DB9EC4_1274798315 = new SAXNotRecognizedException(name);
        var5FC954F6CCADD58BC8498AD6F3DB9EC4_1274798315.addTaint(taint);
        throw var5FC954F6CCADD58BC8498AD6F3DB9EC4_1274798315;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:31.014 -0400", hash_original_method = "22B8A6F31FF28964E09EDBCB1671EC65", hash_generated_method = "55407472F47B530FE11A5AF9687B9738")
    public Object getProperty(String name) throws SAXNotRecognizedException, SAXNotSupportedException {
        addTaint(name.getTaint());
    if(name == null)        
        {
            NullPointerException varA117BA528B11F7D1AC96CABFD5286E5C_492066998 = new NullPointerException("name == null");
            varA117BA528B11F7D1AC96CABFD5286E5C_492066998.addTaint(taint);
            throw varA117BA528B11F7D1AC96CABFD5286E5C_492066998;
        } //End block
    if(name.equals(LEXICAL_HANDLER_PROPERTY))        
        {
Object varF24ED8F881B00D87C96DB18E799E5B4E_1684895060 =             lexicalHandler;
            varF24ED8F881B00D87C96DB18E799E5B4E_1684895060.addTaint(taint);
            return varF24ED8F881B00D87C96DB18E799E5B4E_1684895060;
        } //End block
        SAXNotRecognizedException var5FC954F6CCADD58BC8498AD6F3DB9EC4_2090841915 = new SAXNotRecognizedException(name);
        var5FC954F6CCADD58BC8498AD6F3DB9EC4_2090841915.addTaint(taint);
        throw var5FC954F6CCADD58BC8498AD6F3DB9EC4_2090841915;
        // ---------- Original Method ----------
        //if (name == null) {
            //throw new NullPointerException("name == null");
        //}
        //if (name.equals(LEXICAL_HANDLER_PROPERTY)) {
            //return lexicalHandler;
        //}
        //throw new SAXNotRecognizedException(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:31.015 -0400", hash_original_method = "77A0661FD735F31D3304DC28B022498D", hash_generated_method = "37CD9521D2D7AE8696D6BF362D9BE330")
    public void setProperty(String name, Object value) throws SAXNotRecognizedException, SAXNotSupportedException {
        addTaint(name.getTaint());
    if(name == null)        
        {
            NullPointerException varA117BA528B11F7D1AC96CABFD5286E5C_1102521633 = new NullPointerException("name == null");
            varA117BA528B11F7D1AC96CABFD5286E5C_1102521633.addTaint(taint);
            throw varA117BA528B11F7D1AC96CABFD5286E5C_1102521633;
        } //End block
    if(name.equals(LEXICAL_HANDLER_PROPERTY))        
        {
    if(value instanceof LexicalHandler || value == null)            
            {
                this.lexicalHandler = (LexicalHandler) value;
                return;
            } //End block
            SAXNotSupportedException varDD284D957193ADFAF1F18F3E92F263A1_518591071 = new SAXNotSupportedException("value doesn't implement " +
                    "org.xml.sax.ext.LexicalHandler");
            varDD284D957193ADFAF1F18F3E92F263A1_518591071.addTaint(taint);
            throw varDD284D957193ADFAF1F18F3E92F263A1_518591071;
        } //End block
        SAXNotRecognizedException var5FC954F6CCADD58BC8498AD6F3DB9EC4_244770639 = new SAXNotRecognizedException(name);
        var5FC954F6CCADD58BC8498AD6F3DB9EC4_244770639.addTaint(taint);
        throw var5FC954F6CCADD58BC8498AD6F3DB9EC4_244770639;
        // ---------- Original Method ----------
        //if (name == null) {
            //throw new NullPointerException("name == null");
        //}
        //if (name.equals(LEXICAL_HANDLER_PROPERTY)) {
            //if (value instanceof LexicalHandler || value == null) {
                //this.lexicalHandler = (LexicalHandler) value;
                //return;
            //}
            //throw new SAXNotSupportedException("value doesn't implement " +
                    //"org.xml.sax.ext.LexicalHandler");
        //}
        //throw new SAXNotRecognizedException(name);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:31.015 -0400", hash_original_method = "4AC4E6C4007D28BC651CD7E6B362DD6C", hash_generated_method = "63D835E03E7F509982E0571C1C9770D9")
    public void setEntityResolver(EntityResolver resolver) {
        this.entityResolver = resolver;
        // ---------- Original Method ----------
        //this.entityResolver = resolver;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:31.015 -0400", hash_original_method = "3D81AADF9B7990F38C11DFC7B847459D", hash_generated_method = "460900C55F5652C346A398068CE496A1")
    public EntityResolver getEntityResolver() {
EntityResolver varB87C3AFF5DDB8AE3D0CC56605478B984_830015387 =         entityResolver;
        varB87C3AFF5DDB8AE3D0CC56605478B984_830015387.addTaint(taint);
        return varB87C3AFF5DDB8AE3D0CC56605478B984_830015387;
        // ---------- Original Method ----------
        //return entityResolver;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:31.016 -0400", hash_original_method = "C5C8FE4AAF9C21A7CE3D34FBCBA58D65", hash_generated_method = "8B0F5ED3687EC3A90BA8E74AD080DCEE")
    public void setDTDHandler(DTDHandler dtdHandler) {
        this.dtdHandler = dtdHandler;
        // ---------- Original Method ----------
        //this.dtdHandler = dtdHandler;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:31.016 -0400", hash_original_method = "0F3DB0A89C47F7E5E68CDAECBE47BDA3", hash_generated_method = "3C3FF5FAEB1A6BEF84D72357FA4D72D5")
    public DTDHandler getDTDHandler() {
DTDHandler varA6420E370A0D0E7B2C08F2BBD64CCBA1_466222319 =         dtdHandler;
        varA6420E370A0D0E7B2C08F2BBD64CCBA1_466222319.addTaint(taint);
        return varA6420E370A0D0E7B2C08F2BBD64CCBA1_466222319;
        // ---------- Original Method ----------
        //return dtdHandler;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:31.016 -0400", hash_original_method = "2FAFDB8E70CAAF64BA45E64983BDD69F", hash_generated_method = "A94027FF3EBB8EC2D5A71E5B3D4DF058")
    public void setContentHandler(ContentHandler handler) {
        this.contentHandler = handler;
        // ---------- Original Method ----------
        //this.contentHandler = handler;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:31.016 -0400", hash_original_method = "E04698427463FF6147E1A918B2D0CE2E", hash_generated_method = "51AC84000EC4268178BC4317AE4E245B")
    public ContentHandler getContentHandler() {
ContentHandler var3013AD2E73283A2E190EF56C6A56B21E_253131022 =         this.contentHandler;
        var3013AD2E73283A2E190EF56C6A56B21E_253131022.addTaint(taint);
        return var3013AD2E73283A2E190EF56C6A56B21E_253131022;
        // ---------- Original Method ----------
        //return this.contentHandler;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:31.017 -0400", hash_original_method = "7B962796A6AC5EDA23D64E3C68EF714F", hash_generated_method = "6F05662BE8FCA118F2F6EF361C757A69")
    public void setErrorHandler(ErrorHandler handler) {
        this.errorHandler = handler;
        // ---------- Original Method ----------
        //this.errorHandler = handler;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:31.017 -0400", hash_original_method = "96333264931FDEA89262C2A3168E5DDE", hash_generated_method = "150D780AEFDEC21A9287BA77A2E517B3")
    public ErrorHandler getErrorHandler() {
ErrorHandler var814E1CB3DFFE2674E65471BBF7C52ECD_339476575 =         errorHandler;
        var814E1CB3DFFE2674E65471BBF7C52ECD_339476575.addTaint(taint);
        return var814E1CB3DFFE2674E65471BBF7C52ECD_339476575;
        // ---------- Original Method ----------
        //return errorHandler;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:31.017 -0400", hash_original_method = "6DC1F08FFDA197EBCFE51BBDA6091085", hash_generated_method = "64EBCB4E3826189DF08A334F48EFF248")
    public LexicalHandler getLexicalHandler() {
LexicalHandler varF24ED8F881B00D87C96DB18E799E5B4E_767331437 =         lexicalHandler;
        varF24ED8F881B00D87C96DB18E799E5B4E_767331437.addTaint(taint);
        return varF24ED8F881B00D87C96DB18E799E5B4E_767331437;
        // ---------- Original Method ----------
        //return lexicalHandler;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:31.018 -0400", hash_original_method = "46969CCBA4951230BBEE4D65C754FA21", hash_generated_method = "453F77C804B47DFB6BD13C7EAAB6638F")
    public void setLexicalHandler(LexicalHandler lexicalHandler) {
        this.lexicalHandler = lexicalHandler;
        // ---------- Original Method ----------
        //this.lexicalHandler = lexicalHandler;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:31.018 -0400", hash_original_method = "8B578359B2B86A936D64E613060A616F", hash_generated_method = "17FFA7C518350684BC738B6453A4D203")
    public boolean isNamespaceProcessingEnabled() {
        boolean varA1F90DC0949B964CF3CD56D32EFE56BC_1832916148 = (processNamespaces);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2006482292 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2006482292;
        // ---------- Original Method ----------
        //return processNamespaces;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:31.018 -0400", hash_original_method = "B86489F53C66FA94BF60F43E844ECD38", hash_generated_method = "7BDAE2666FC1C25E8AEF559C34924293")
    public void setNamespaceProcessingEnabled(boolean processNamespaces) {
        this.processNamespaces = processNamespaces;
        // ---------- Original Method ----------
        //this.processNamespaces = processNamespaces;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:31.019 -0400", hash_original_method = "685D8DAF72E9C67A08F397F1EDD26DDB", hash_generated_method = "DE0C904C9637504722B41E918B093646")
    public void parse(InputSource input) throws IOException, SAXException {
        addTaint(input.getTaint());
    if(processNamespacePrefixes && processNamespaces)        
        {
            SAXNotSupportedException varFF1A17A1196885D99838768CDEBF7BD9_11538587 = new SAXNotSupportedException("The 'namespace-prefix' " +
                    "feature is not supported while the 'namespaces' " +
                    "feature is enabled.");
            varFF1A17A1196885D99838768CDEBF7BD9_11538587.addTaint(taint);
            throw varFF1A17A1196885D99838768CDEBF7BD9_11538587;
        } //End block
        Reader reader = input.getCharacterStream();
    if(reader != null)        
        {
            try 
            {
                parse(reader, input.getPublicId(), input.getSystemId());
            } //End block
            finally 
            {
                IoUtils.closeQuietly(reader);
            } //End block
            return;
        } //End block
        InputStream in = input.getByteStream();
        String encoding = input.getEncoding();
    if(in != null)        
        {
            try 
            {
                parse(in, encoding, input.getPublicId(), input.getSystemId());
            } //End block
            finally 
            {
                IoUtils.closeQuietly(in);
            } //End block
            return;
        } //End block
        String systemId = input.getSystemId();
    if(systemId == null)        
        {
            SAXException varEB69E75D6AFFEB43170B9CA8B920E515_1395936589 = new SAXException("No input specified.");
            varEB69E75D6AFFEB43170B9CA8B920E515_1395936589.addTaint(taint);
            throw varEB69E75D6AFFEB43170B9CA8B920E515_1395936589;
        } //End block
        in = ExpatParser.openUrl(systemId);
        try 
        {
            parse(in, encoding, input.getPublicId(), systemId);
        } //End block
        finally 
        {
            IoUtils.closeQuietly(in);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:31.019 -0400", hash_original_method = "B98792032D9978680A85667A6250DD52", hash_generated_method = "6B72C28BFDE47C3257FAC5C2568B986B")
    private void parse(Reader in, String publicId, String systemId) throws IOException, SAXException {
        addTaint(systemId.getTaint());
        addTaint(publicId.getTaint());
        addTaint(in.getTaint());
        ExpatParser parser = new ExpatParser(
                ExpatParser.CHARACTER_ENCODING,
                this,
                processNamespaces,
                publicId,
                systemId
        );
        parser.parseDocument(in);
        // ---------- Original Method ----------
        //ExpatParser parser = new ExpatParser(
                //ExpatParser.CHARACTER_ENCODING,
                //this,
                //processNamespaces,
                //publicId,
                //systemId
        //);
        //parser.parseDocument(in);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:31.020 -0400", hash_original_method = "9D71B5A1B65775D1A1A09DC689E8FD0F", hash_generated_method = "B972BF86E748D3E1A70B9A1830F3F3CF")
    private void parse(InputStream in, String encoding, String publicId,
            String systemId) throws IOException, SAXException {
        addTaint(systemId.getTaint());
        addTaint(publicId.getTaint());
        addTaint(encoding.getTaint());
        addTaint(in.getTaint());
        ExpatParser parser = new ExpatParser(
                encoding,
                this,
                processNamespaces,
                publicId,
                systemId
        );
        parser.parseDocument(in);
        // ---------- Original Method ----------
        //ExpatParser parser = new ExpatParser(
                //encoding,
                //this,
                //processNamespaces,
                //publicId,
                //systemId
        //);
        //parser.parseDocument(in);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:31.020 -0400", hash_original_method = "8AE6DA2951569D3F1B1B45FDE2C61B3C", hash_generated_method = "17B1436177E4DE56B91CAF4A0F73B451")
    public void parse(String systemId) throws IOException, SAXException {
        addTaint(systemId.getTaint());
        parse(new InputSource(systemId));
        // ---------- Original Method ----------
        //parse(new InputSource(systemId));
    }

    
    private static class Feature {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:31.020 -0400", hash_original_method = "0B4D9136485558B251EF1E44EE499FB7", hash_generated_method = "0B4D9136485558B251EF1E44EE499FB7")
        public Feature ()
        {
            //Synthesized constructor
        }


        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:31.020 -0400", hash_original_field = "078020891DF0C24B4D280CA42D0A1B51", hash_generated_field = "7A1D48E3BBF987F17CCDC77F6B0FAC95")

        private static final String BASE_URI = "http://xml.org/sax/features/";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:31.020 -0400", hash_original_field = "4E02D8CE37B4D376299C8703988EC4BB", hash_generated_field = "30ED0C9BE4E702F74DA8CD69B4046727")

        private static final String VALIDATION = BASE_URI + "validation";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:31.020 -0400", hash_original_field = "2A56C7C2E5B88423FB94BB005534876C", hash_generated_field = "7AABE7A0A06E4F7FE1E3519E1444EEDF")

        private static final String NAMESPACES = BASE_URI + "namespaces";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:31.020 -0400", hash_original_field = "1C7BFAF20E75F40165A219937214B10E", hash_generated_field = "AA97C004810B26F45B8D0816A31978BF")

        private static final String NAMESPACE_PREFIXES = BASE_URI + "namespace-prefixes";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:31.020 -0400", hash_original_field = "2842465A0CE48D1293B889D70C885B8F", hash_generated_field = "8C00EF5F799529D8A1E2F4DFCBF22CF4")

        private static final String STRING_INTERNING = BASE_URI + "string-interning";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:31.021 -0400", hash_original_field = "48F1521B68116527A98CFA1130B6FF92", hash_generated_field = "E9CAD9275128B3945C2FFA3643A4936A")

        private static final String EXTERNAL_GENERAL_ENTITIES = BASE_URI + "external-general-entities";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:31.021 -0400", hash_original_field = "C2BBB19F15E22223BA7D59DCBC646B3E", hash_generated_field = "AC036A8C71D0772DB976AF5182CABEE3")

        private static final String EXTERNAL_PARAMETER_ENTITIES = BASE_URI + "external-parameter-entities";
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:31.021 -0400", hash_original_field = "F338C4248676C2E7E13977787372D419", hash_generated_field = "76D9E2DC4A0EBE3D6C94DF14707F99DB")

    private static final String LEXICAL_HANDLER_PROPERTY = "http://xml.org/sax/properties/lexical-handler";
}

