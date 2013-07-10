package org.apache.harmony.xml;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.712 -0400", hash_original_field = "578F5B86519FF4351B2665A38DD14BC9", hash_generated_field = "F0B36C97F7B57E341954B85DB9C0C08E")

    ContentHandler contentHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.712 -0400", hash_original_field = "675358325C4A25C582575F3E0D7B3B2E", hash_generated_field = "1DE4F92C3694DD72282E703A9C497860")

    DTDHandler dtdHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.712 -0400", hash_original_field = "EABB965CB8BE873142A4DA0189C06FD8", hash_generated_field = "0F20E0B3BF6506A85F7C0D2D3D40FE9D")

    EntityResolver entityResolver;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.712 -0400", hash_original_field = "F56352FA359A5F4533A25E5F29D527F4", hash_generated_field = "D1E7497C7DFC94EB56211895742439AB")

    ErrorHandler errorHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.712 -0400", hash_original_field = "F8428D0A3B7DA53007818A67088E3DE1", hash_generated_field = "0A9AFAA2B0505C00F2ECAD506C3C72F7")

    LexicalHandler lexicalHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.712 -0400", hash_original_field = "15C4D6DFFA5ABB29F81DE4E99A3807F9", hash_generated_field = "DA06DC238CFD0DC0251460B8E2E7F05F")

    private boolean processNamespaces = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.712 -0400", hash_original_field = "3F43F385BAD88E4D2C207047289F625A", hash_generated_field = "571B94DE5D091BD853A513AE92780624")

    private boolean processNamespacePrefixes = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.712 -0400", hash_original_method = "0527B9275A46E7773519FE6EE020706F", hash_generated_method = "0527B9275A46E7773519FE6EE020706F")
    public ExpatReader ()
    {
        
    }


    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.713 -0400", hash_original_method = "783B372D10B457C55DE61BCE252421E8", hash_generated_method = "AC14C0D6E0D84DCD29A55BD5978F6EEC")
    public boolean getFeature(String name) throws SAXNotRecognizedException, SAXNotSupportedException {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("name == null");
        } 
        {
            boolean var095945B358BCA21A047D05C123414089_1296188913 = (name.equals(Feature.VALIDATION)
                || name.equals(Feature.EXTERNAL_GENERAL_ENTITIES)
                || name.equals(Feature.EXTERNAL_PARAMETER_ENTITIES));
        } 
        {
            boolean var7E5F0F821C4C4FD2D442BD87CF4D9B59_1817755522 = (name.equals(Feature.NAMESPACES));
        } 
        {
            boolean var040850AFC58B9164202E8F2B0801F04F_1884271030 = (name.equals(Feature.NAMESPACE_PREFIXES));
        } 
        {
            boolean varEB31DD0A36316277BB0E215BA2D99F4D_2108705066 = (name.equals(Feature.STRING_INTERNING));
        } 
        if (DroidSafeAndroidRuntime.control) throw new SAXNotRecognizedException(name);
        addTaint(name.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1161204056 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1161204056;
        
        
            
        
        
                
                
            
        
        
            
        
        
            
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.714 -0400", hash_original_method = "6C812262457371E1512166CE4A83ADE9", hash_generated_method = "56B4FD1D127E9070424DD5C71A540307")
    public void setFeature(String name, boolean value) throws SAXNotRecognizedException, SAXNotSupportedException {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("name == null");
        } 
        {
            boolean var095945B358BCA21A047D05C123414089_1159254844 = (name.equals(Feature.VALIDATION)
                || name.equals(Feature.EXTERNAL_GENERAL_ENTITIES)
                || name.equals(Feature.EXTERNAL_PARAMETER_ENTITIES));
            {
                {
                    if (DroidSafeAndroidRuntime.control) throw new SAXNotSupportedException("Cannot enable " + name);
                } 
            } 
        } 
        {
            boolean var7E5F0F821C4C4FD2D442BD87CF4D9B59_20341178 = (name.equals(Feature.NAMESPACES));
            {
                processNamespaces = value;
            } 
        } 
        {
            boolean var040850AFC58B9164202E8F2B0801F04F_367271910 = (name.equals(Feature.NAMESPACE_PREFIXES));
            {
                processNamespacePrefixes = value;
            } 
        } 
        {
            boolean varEB31DD0A36316277BB0E215BA2D99F4D_1668963702 = (name.equals(Feature.STRING_INTERNING));
            {
                {
                    if (DroidSafeAndroidRuntime.control) throw new SAXNotSupportedException("Cannot disable " + name);
                } 
            } 
        } 
        if (DroidSafeAndroidRuntime.control) throw new SAXNotRecognizedException(name);
        addTaint(name.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.714 -0400", hash_original_method = "22B8A6F31FF28964E09EDBCB1671EC65", hash_generated_method = "1EBE367AAD3ADD3E0BCAFA46C0B11A6D")
    public Object getProperty(String name) throws SAXNotRecognizedException, SAXNotSupportedException {
        Object varB4EAC82CA7396A68D541C85D26508E83_38713325 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("name == null");
        } 
        {
            boolean var58879761E7B6DA99822BBCF1FE4B3C68_174130586 = (name.equals(LEXICAL_HANDLER_PROPERTY));
            {
                varB4EAC82CA7396A68D541C85D26508E83_38713325 = lexicalHandler;
            } 
        } 
        if (DroidSafeAndroidRuntime.control) throw new SAXNotRecognizedException(name);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_38713325.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_38713325;
        
        
            
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.715 -0400", hash_original_method = "77A0661FD735F31D3304DC28B022498D", hash_generated_method = "63C0D08466AA2348BED357A4EDBD7764")
    public void setProperty(String name, Object value) throws SAXNotRecognizedException, SAXNotSupportedException {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("name == null");
        } 
        {
            boolean var58879761E7B6DA99822BBCF1FE4B3C68_865935305 = (name.equals(LEXICAL_HANDLER_PROPERTY));
            {
                {
                    this.lexicalHandler = (LexicalHandler) value;
                } 
                if (DroidSafeAndroidRuntime.control) throw new SAXNotSupportedException("value doesn't implement " +
                    "org.xml.sax.ext.LexicalHandler");
            } 
        } 
        if (DroidSafeAndroidRuntime.control) throw new SAXNotRecognizedException(name);
        addTaint(name.getTaint());
        
        
            
        
        
            
                
                
            
            
                    
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.716 -0400", hash_original_method = "4AC4E6C4007D28BC651CD7E6B362DD6C", hash_generated_method = "63D835E03E7F509982E0571C1C9770D9")
    public void setEntityResolver(EntityResolver resolver) {
        this.entityResolver = resolver;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.718 -0400", hash_original_method = "3D81AADF9B7990F38C11DFC7B847459D", hash_generated_method = "A3B71CA876C0A6CE56C7E30D4441D069")
    public EntityResolver getEntityResolver() {
        EntityResolver varB4EAC82CA7396A68D541C85D26508E83_1641188363 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1641188363 = entityResolver;
        varB4EAC82CA7396A68D541C85D26508E83_1641188363.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1641188363;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.718 -0400", hash_original_method = "C5C8FE4AAF9C21A7CE3D34FBCBA58D65", hash_generated_method = "8B0F5ED3687EC3A90BA8E74AD080DCEE")
    public void setDTDHandler(DTDHandler dtdHandler) {
        this.dtdHandler = dtdHandler;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.719 -0400", hash_original_method = "0F3DB0A89C47F7E5E68CDAECBE47BDA3", hash_generated_method = "755264D1A858AB5677781ED172934E56")
    public DTDHandler getDTDHandler() {
        DTDHandler varB4EAC82CA7396A68D541C85D26508E83_1217399113 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1217399113 = dtdHandler;
        varB4EAC82CA7396A68D541C85D26508E83_1217399113.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1217399113;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.720 -0400", hash_original_method = "2FAFDB8E70CAAF64BA45E64983BDD69F", hash_generated_method = "A94027FF3EBB8EC2D5A71E5B3D4DF058")
    public void setContentHandler(ContentHandler handler) {
        this.contentHandler = handler;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.721 -0400", hash_original_method = "E04698427463FF6147E1A918B2D0CE2E", hash_generated_method = "C38B33171D7751F1DCC9A5F0C0B92B6C")
    public ContentHandler getContentHandler() {
        ContentHandler varB4EAC82CA7396A68D541C85D26508E83_1989351412 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1989351412 = this.contentHandler;
        varB4EAC82CA7396A68D541C85D26508E83_1989351412.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1989351412;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.722 -0400", hash_original_method = "7B962796A6AC5EDA23D64E3C68EF714F", hash_generated_method = "6F05662BE8FCA118F2F6EF361C757A69")
    public void setErrorHandler(ErrorHandler handler) {
        this.errorHandler = handler;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.722 -0400", hash_original_method = "96333264931FDEA89262C2A3168E5DDE", hash_generated_method = "7542871F71FA59878E635BE3AE25FCD6")
    public ErrorHandler getErrorHandler() {
        ErrorHandler varB4EAC82CA7396A68D541C85D26508E83_1535499726 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1535499726 = errorHandler;
        varB4EAC82CA7396A68D541C85D26508E83_1535499726.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1535499726;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.724 -0400", hash_original_method = "6DC1F08FFDA197EBCFE51BBDA6091085", hash_generated_method = "652FF48FC4B5DE4FD5FD09E2B1E1C3F7")
    public LexicalHandler getLexicalHandler() {
        LexicalHandler varB4EAC82CA7396A68D541C85D26508E83_1198848589 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1198848589 = lexicalHandler;
        varB4EAC82CA7396A68D541C85D26508E83_1198848589.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1198848589;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.726 -0400", hash_original_method = "46969CCBA4951230BBEE4D65C754FA21", hash_generated_method = "453F77C804B47DFB6BD13C7EAAB6638F")
    public void setLexicalHandler(LexicalHandler lexicalHandler) {
        this.lexicalHandler = lexicalHandler;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.727 -0400", hash_original_method = "8B578359B2B86A936D64E613060A616F", hash_generated_method = "BE57FFFDC4607ACCBFAC18228FCC9916")
    public boolean isNamespaceProcessingEnabled() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_126671670 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_126671670;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.728 -0400", hash_original_method = "B86489F53C66FA94BF60F43E844ECD38", hash_generated_method = "7BDAE2666FC1C25E8AEF559C34924293")
    public void setNamespaceProcessingEnabled(boolean processNamespaces) {
        this.processNamespaces = processNamespaces;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.730 -0400", hash_original_method = "685D8DAF72E9C67A08F397F1EDD26DDB", hash_generated_method = "6B6D48A2FB95BA2898153CE8F47847A4")
    public void parse(InputSource input) throws IOException, SAXException {
        {
            if (DroidSafeAndroidRuntime.control) throw new SAXNotSupportedException("The 'namespace-prefix' " +
                    "feature is not supported while the 'namespaces' " +
                    "feature is enabled.");
        } 
        Reader reader = input.getCharacterStream();
        {
            try 
            {
                parse(reader, input.getPublicId(), input.getSystemId());
            } 
            finally 
            {
                IoUtils.closeQuietly(reader);
            } 
        } 
        InputStream in = input.getByteStream();
        String encoding = input.getEncoding();
        {
            try 
            {
                parse(in, encoding, input.getPublicId(), input.getSystemId());
            } 
            finally 
            {
                IoUtils.closeQuietly(in);
            } 
        } 
        String systemId = input.getSystemId();
        {
            if (DroidSafeAndroidRuntime.control) throw new SAXException("No input specified.");
        } 
        in = ExpatParser.openUrl(systemId);
        try 
        {
            parse(in, encoding, input.getPublicId(), systemId);
        } 
        finally 
        {
            IoUtils.closeQuietly(in);
        } 
        addTaint(input.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.731 -0400", hash_original_method = "B98792032D9978680A85667A6250DD52", hash_generated_method = "E7E486002A971326460233D741CD93B8")
    private void parse(Reader in, String publicId, String systemId) throws IOException, SAXException {
        ExpatParser parser = new ExpatParser(
                ExpatParser.CHARACTER_ENCODING,
                this,
                processNamespaces,
                publicId,
                systemId
        );
        parser.parseDocument(in);
        addTaint(in.getTaint());
        addTaint(publicId.getTaint());
        addTaint(systemId.getTaint());
        
        
                
                
                
                
                
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.732 -0400", hash_original_method = "9D71B5A1B65775D1A1A09DC689E8FD0F", hash_generated_method = "F1ED7CB3B9184E71BAA1136BD475A818")
    private void parse(InputStream in, String encoding, String publicId,
            String systemId) throws IOException, SAXException {
        ExpatParser parser = new ExpatParser(
                encoding,
                this,
                processNamespaces,
                publicId,
                systemId
        );
        parser.parseDocument(in);
        addTaint(in.getTaint());
        addTaint(encoding.getTaint());
        addTaint(publicId.getTaint());
        addTaint(systemId.getTaint());
        
        
                
                
                
                
                
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.732 -0400", hash_original_method = "8AE6DA2951569D3F1B1B45FDE2C61B3C", hash_generated_method = "7C46E33FDC82E8D9EBC2B1667B1FD4B6")
    public void parse(String systemId) throws IOException, SAXException {
        parse(new InputSource(systemId));
        addTaint(systemId.getTaint());
        
        
    }

    
    private static class Feature {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.732 -0400", hash_original_method = "0B4D9136485558B251EF1E44EE499FB7", hash_generated_method = "0B4D9136485558B251EF1E44EE499FB7")
        public Feature ()
        {
            
        }


        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.732 -0400", hash_original_field = "078020891DF0C24B4D280CA42D0A1B51", hash_generated_field = "7A1D48E3BBF987F17CCDC77F6B0FAC95")

        private static final String BASE_URI = "http://xml.org/sax/features/";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.732 -0400", hash_original_field = "4E02D8CE37B4D376299C8703988EC4BB", hash_generated_field = "30ED0C9BE4E702F74DA8CD69B4046727")

        private static final String VALIDATION = BASE_URI + "validation";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.733 -0400", hash_original_field = "2A56C7C2E5B88423FB94BB005534876C", hash_generated_field = "7AABE7A0A06E4F7FE1E3519E1444EEDF")

        private static final String NAMESPACES = BASE_URI + "namespaces";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.733 -0400", hash_original_field = "1C7BFAF20E75F40165A219937214B10E", hash_generated_field = "AA97C004810B26F45B8D0816A31978BF")

        private static final String NAMESPACE_PREFIXES = BASE_URI + "namespace-prefixes";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.733 -0400", hash_original_field = "2842465A0CE48D1293B889D70C885B8F", hash_generated_field = "8C00EF5F799529D8A1E2F4DFCBF22CF4")

        private static final String STRING_INTERNING = BASE_URI + "string-interning";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.733 -0400", hash_original_field = "48F1521B68116527A98CFA1130B6FF92", hash_generated_field = "E9CAD9275128B3945C2FFA3643A4936A")

        private static final String EXTERNAL_GENERAL_ENTITIES = BASE_URI + "external-general-entities";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.733 -0400", hash_original_field = "C2BBB19F15E22223BA7D59DCBC646B3E", hash_generated_field = "AC036A8C71D0772DB976AF5182CABEE3")

        private static final String EXTERNAL_PARAMETER_ENTITIES = BASE_URI + "external-parameter-entities";
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.733 -0400", hash_original_field = "F338C4248676C2E7E13977787372D419", hash_generated_field = "76D9E2DC4A0EBE3D6C94DF14707F99DB")

    private static final String LEXICAL_HANDLER_PROPERTY = "http://xml.org/sax/properties/lexical-handler";
}

