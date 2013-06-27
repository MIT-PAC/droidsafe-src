package org.apache.harmony.xml;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.487 -0400", hash_original_field = "578F5B86519FF4351B2665A38DD14BC9", hash_generated_field = "F0B36C97F7B57E341954B85DB9C0C08E")

    ContentHandler contentHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.487 -0400", hash_original_field = "675358325C4A25C582575F3E0D7B3B2E", hash_generated_field = "1DE4F92C3694DD72282E703A9C497860")

    DTDHandler dtdHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.487 -0400", hash_original_field = "EABB965CB8BE873142A4DA0189C06FD8", hash_generated_field = "0F20E0B3BF6506A85F7C0D2D3D40FE9D")

    EntityResolver entityResolver;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.487 -0400", hash_original_field = "F56352FA359A5F4533A25E5F29D527F4", hash_generated_field = "D1E7497C7DFC94EB56211895742439AB")

    ErrorHandler errorHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.487 -0400", hash_original_field = "F8428D0A3B7DA53007818A67088E3DE1", hash_generated_field = "0A9AFAA2B0505C00F2ECAD506C3C72F7")

    LexicalHandler lexicalHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.487 -0400", hash_original_field = "15C4D6DFFA5ABB29F81DE4E99A3807F9", hash_generated_field = "DA06DC238CFD0DC0251460B8E2E7F05F")

    private boolean processNamespaces = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.488 -0400", hash_original_field = "3F43F385BAD88E4D2C207047289F625A", hash_generated_field = "571B94DE5D091BD853A513AE92780624")

    private boolean processNamespacePrefixes = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.488 -0400", hash_original_method = "0527B9275A46E7773519FE6EE020706F", hash_generated_method = "0527B9275A46E7773519FE6EE020706F")
    public ExpatReader ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.488 -0400", hash_original_method = "783B372D10B457C55DE61BCE252421E8", hash_generated_method = "503CAB224AEC122E2F52D2B84E40A517")
    public boolean getFeature(String name) throws SAXNotRecognizedException, SAXNotSupportedException {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("name == null");
        } //End block
        {
            boolean var095945B358BCA21A047D05C123414089_1705569688 = (name.equals(Feature.VALIDATION)
                || name.equals(Feature.EXTERNAL_GENERAL_ENTITIES)
                || name.equals(Feature.EXTERNAL_PARAMETER_ENTITIES));
        } //End collapsed parenthetic
        {
            boolean var7E5F0F821C4C4FD2D442BD87CF4D9B59_1926263767 = (name.equals(Feature.NAMESPACES));
        } //End collapsed parenthetic
        {
            boolean var040850AFC58B9164202E8F2B0801F04F_388913749 = (name.equals(Feature.NAMESPACE_PREFIXES));
        } //End collapsed parenthetic
        {
            boolean varEB31DD0A36316277BB0E215BA2D99F4D_1651510604 = (name.equals(Feature.STRING_INTERNING));
        } //End collapsed parenthetic
        if (DroidSafeAndroidRuntime.control) throw new SAXNotRecognizedException(name);
        addTaint(name.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1465182782 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1465182782;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.501 -0400", hash_original_method = "6C812262457371E1512166CE4A83ADE9", hash_generated_method = "F054956AD8FDF04930EEFF9023BD823D")
    public void setFeature(String name, boolean value) throws SAXNotRecognizedException, SAXNotSupportedException {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("name == null");
        } //End block
        {
            boolean var095945B358BCA21A047D05C123414089_282924286 = (name.equals(Feature.VALIDATION)
                || name.equals(Feature.EXTERNAL_GENERAL_ENTITIES)
                || name.equals(Feature.EXTERNAL_PARAMETER_ENTITIES));
            {
                {
                    if (DroidSafeAndroidRuntime.control) throw new SAXNotSupportedException("Cannot enable " + name);
                } //End block
            } //End block
        } //End collapsed parenthetic
        {
            boolean var7E5F0F821C4C4FD2D442BD87CF4D9B59_1810131598 = (name.equals(Feature.NAMESPACES));
            {
                processNamespaces = value;
            } //End block
        } //End collapsed parenthetic
        {
            boolean var040850AFC58B9164202E8F2B0801F04F_654738463 = (name.equals(Feature.NAMESPACE_PREFIXES));
            {
                processNamespacePrefixes = value;
            } //End block
        } //End collapsed parenthetic
        {
            boolean varEB31DD0A36316277BB0E215BA2D99F4D_273873110 = (name.equals(Feature.STRING_INTERNING));
            {
                {
                    if (DroidSafeAndroidRuntime.control) throw new SAXNotSupportedException("Cannot disable " + name);
                } //End block
            } //End block
        } //End collapsed parenthetic
        if (DroidSafeAndroidRuntime.control) throw new SAXNotRecognizedException(name);
        addTaint(name.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.512 -0400", hash_original_method = "22B8A6F31FF28964E09EDBCB1671EC65", hash_generated_method = "1DCF049935EE0062074DDECA3084A47B")
    public Object getProperty(String name) throws SAXNotRecognizedException, SAXNotSupportedException {
        Object varB4EAC82CA7396A68D541C85D26508E83_781873818 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("name == null");
        } //End block
        {
            boolean var58879761E7B6DA99822BBCF1FE4B3C68_1853488041 = (name.equals(LEXICAL_HANDLER_PROPERTY));
            {
                varB4EAC82CA7396A68D541C85D26508E83_781873818 = lexicalHandler;
            } //End block
        } //End collapsed parenthetic
        if (DroidSafeAndroidRuntime.control) throw new SAXNotRecognizedException(name);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_781873818.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_781873818;
        // ---------- Original Method ----------
        //if (name == null) {
            //throw new NullPointerException("name == null");
        //}
        //if (name.equals(LEXICAL_HANDLER_PROPERTY)) {
            //return lexicalHandler;
        //}
        //throw new SAXNotRecognizedException(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.521 -0400", hash_original_method = "77A0661FD735F31D3304DC28B022498D", hash_generated_method = "DD147FD6910A7BA064AD178168A79CCE")
    public void setProperty(String name, Object value) throws SAXNotRecognizedException, SAXNotSupportedException {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("name == null");
        } //End block
        {
            boolean var58879761E7B6DA99822BBCF1FE4B3C68_1765631032 = (name.equals(LEXICAL_HANDLER_PROPERTY));
            {
                {
                    this.lexicalHandler = (LexicalHandler) value;
                } //End block
                if (DroidSafeAndroidRuntime.control) throw new SAXNotSupportedException("value doesn't implement " +
                    "org.xml.sax.ext.LexicalHandler");
            } //End block
        } //End collapsed parenthetic
        if (DroidSafeAndroidRuntime.control) throw new SAXNotRecognizedException(name);
        addTaint(name.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.522 -0400", hash_original_method = "4AC4E6C4007D28BC651CD7E6B362DD6C", hash_generated_method = "63D835E03E7F509982E0571C1C9770D9")
    public void setEntityResolver(EntityResolver resolver) {
        this.entityResolver = resolver;
        // ---------- Original Method ----------
        //this.entityResolver = resolver;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.523 -0400", hash_original_method = "3D81AADF9B7990F38C11DFC7B847459D", hash_generated_method = "24077D9DAA1B8368013B3DE5DF160A9A")
    public EntityResolver getEntityResolver() {
        EntityResolver varB4EAC82CA7396A68D541C85D26508E83_560444741 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_560444741 = entityResolver;
        varB4EAC82CA7396A68D541C85D26508E83_560444741.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_560444741;
        // ---------- Original Method ----------
        //return entityResolver;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.525 -0400", hash_original_method = "C5C8FE4AAF9C21A7CE3D34FBCBA58D65", hash_generated_method = "8B0F5ED3687EC3A90BA8E74AD080DCEE")
    public void setDTDHandler(DTDHandler dtdHandler) {
        this.dtdHandler = dtdHandler;
        // ---------- Original Method ----------
        //this.dtdHandler = dtdHandler;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.526 -0400", hash_original_method = "0F3DB0A89C47F7E5E68CDAECBE47BDA3", hash_generated_method = "CFED3BF9C6D03D64BBE569B9CD910D8E")
    public DTDHandler getDTDHandler() {
        DTDHandler varB4EAC82CA7396A68D541C85D26508E83_1863718982 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1863718982 = dtdHandler;
        varB4EAC82CA7396A68D541C85D26508E83_1863718982.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1863718982;
        // ---------- Original Method ----------
        //return dtdHandler;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.526 -0400", hash_original_method = "2FAFDB8E70CAAF64BA45E64983BDD69F", hash_generated_method = "A94027FF3EBB8EC2D5A71E5B3D4DF058")
    public void setContentHandler(ContentHandler handler) {
        this.contentHandler = handler;
        // ---------- Original Method ----------
        //this.contentHandler = handler;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.526 -0400", hash_original_method = "E04698427463FF6147E1A918B2D0CE2E", hash_generated_method = "539E3AD8FF8B7F1E41FC60C79CDB0168")
    public ContentHandler getContentHandler() {
        ContentHandler varB4EAC82CA7396A68D541C85D26508E83_1658136455 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1658136455 = this.contentHandler;
        varB4EAC82CA7396A68D541C85D26508E83_1658136455.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1658136455;
        // ---------- Original Method ----------
        //return this.contentHandler;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.527 -0400", hash_original_method = "7B962796A6AC5EDA23D64E3C68EF714F", hash_generated_method = "6F05662BE8FCA118F2F6EF361C757A69")
    public void setErrorHandler(ErrorHandler handler) {
        this.errorHandler = handler;
        // ---------- Original Method ----------
        //this.errorHandler = handler;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.528 -0400", hash_original_method = "96333264931FDEA89262C2A3168E5DDE", hash_generated_method = "FD52BFBD95D735C5A6A75B38D3BF5B18")
    public ErrorHandler getErrorHandler() {
        ErrorHandler varB4EAC82CA7396A68D541C85D26508E83_1173109904 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1173109904 = errorHandler;
        varB4EAC82CA7396A68D541C85D26508E83_1173109904.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1173109904;
        // ---------- Original Method ----------
        //return errorHandler;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.528 -0400", hash_original_method = "6DC1F08FFDA197EBCFE51BBDA6091085", hash_generated_method = "8B7304604130599CDCA2916BACD46439")
    public LexicalHandler getLexicalHandler() {
        LexicalHandler varB4EAC82CA7396A68D541C85D26508E83_599730146 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_599730146 = lexicalHandler;
        varB4EAC82CA7396A68D541C85D26508E83_599730146.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_599730146;
        // ---------- Original Method ----------
        //return lexicalHandler;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.528 -0400", hash_original_method = "46969CCBA4951230BBEE4D65C754FA21", hash_generated_method = "453F77C804B47DFB6BD13C7EAAB6638F")
    public void setLexicalHandler(LexicalHandler lexicalHandler) {
        this.lexicalHandler = lexicalHandler;
        // ---------- Original Method ----------
        //this.lexicalHandler = lexicalHandler;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.529 -0400", hash_original_method = "8B578359B2B86A936D64E613060A616F", hash_generated_method = "A74B0060D3F33F183E51F8D8BFB99C63")
    public boolean isNamespaceProcessingEnabled() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2011602631 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2011602631;
        // ---------- Original Method ----------
        //return processNamespaces;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.529 -0400", hash_original_method = "B86489F53C66FA94BF60F43E844ECD38", hash_generated_method = "7BDAE2666FC1C25E8AEF559C34924293")
    public void setNamespaceProcessingEnabled(boolean processNamespaces) {
        this.processNamespaces = processNamespaces;
        // ---------- Original Method ----------
        //this.processNamespaces = processNamespaces;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.540 -0400", hash_original_method = "685D8DAF72E9C67A08F397F1EDD26DDB", hash_generated_method = "97446BDC3C4BA76F63748D122F4BBA98")
    public void parse(InputSource input) throws IOException, SAXException {
        {
            if (DroidSafeAndroidRuntime.control) throw new SAXNotSupportedException("The 'namespace-prefix' " +
                    "feature is not supported while the 'namespaces' " +
                    "feature is enabled.");
        } //End block
        Reader reader;
        reader = input.getCharacterStream();
        {
            try 
            {
                parse(reader, input.getPublicId(), input.getSystemId());
            } //End block
            finally 
            {
                IoUtils.closeQuietly(reader);
            } //End block
        } //End block
        InputStream in;
        in = input.getByteStream();
        String encoding;
        encoding = input.getEncoding();
        {
            try 
            {
                parse(in, encoding, input.getPublicId(), input.getSystemId());
            } //End block
            finally 
            {
                IoUtils.closeQuietly(in);
            } //End block
        } //End block
        String systemId;
        systemId = input.getSystemId();
        {
            if (DroidSafeAndroidRuntime.control) throw new SAXException("No input specified.");
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
        addTaint(input.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.541 -0400", hash_original_method = "B98792032D9978680A85667A6250DD52", hash_generated_method = "E38110955DE9AF685358A5861B4A9FB8")
    private void parse(Reader in, String publicId, String systemId) throws IOException, SAXException {
        ExpatParser parser;
        parser = new ExpatParser(
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.542 -0400", hash_original_method = "9D71B5A1B65775D1A1A09DC689E8FD0F", hash_generated_method = "9D6FCB536672FEEC39A14167DEFE5A7C")
    private void parse(InputStream in, String encoding, String publicId,
            String systemId) throws IOException, SAXException {
        ExpatParser parser;
        parser = new ExpatParser(
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.542 -0400", hash_original_method = "8AE6DA2951569D3F1B1B45FDE2C61B3C", hash_generated_method = "7C46E33FDC82E8D9EBC2B1667B1FD4B6")
    public void parse(String systemId) throws IOException, SAXException {
        parse(new InputSource(systemId));
        addTaint(systemId.getTaint());
        // ---------- Original Method ----------
        //parse(new InputSource(systemId));
    }

    
    private static class Feature {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.543 -0400", hash_original_method = "0B4D9136485558B251EF1E44EE499FB7", hash_generated_method = "0B4D9136485558B251EF1E44EE499FB7")
        public Feature ()
        {
            //Synthesized constructor
        }


        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.543 -0400", hash_original_field = "078020891DF0C24B4D280CA42D0A1B51", hash_generated_field = "2BDF68445774ACC4129DD340F0BB1E54")

        private static String BASE_URI = "http://xml.org/sax/features/";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.543 -0400", hash_original_field = "4E02D8CE37B4D376299C8703988EC4BB", hash_generated_field = "81229DC5C5B1765E4288A7CE831B065D")

        private static String VALIDATION = BASE_URI + "validation";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.543 -0400", hash_original_field = "2A56C7C2E5B88423FB94BB005534876C", hash_generated_field = "9CB65DB05886AF635E247D399C556050")

        private static String NAMESPACES = BASE_URI + "namespaces";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.543 -0400", hash_original_field = "1C7BFAF20E75F40165A219937214B10E", hash_generated_field = "74D65253C46B26F9AD0B63910C678D36")

        private static String NAMESPACE_PREFIXES = BASE_URI + "namespace-prefixes";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.543 -0400", hash_original_field = "2842465A0CE48D1293B889D70C885B8F", hash_generated_field = "417B570C7E678209CC851F7C9B9FA472")

        private static String STRING_INTERNING = BASE_URI + "string-interning";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.543 -0400", hash_original_field = "48F1521B68116527A98CFA1130B6FF92", hash_generated_field = "993CC576797A5A70E9B35847AE271422")

        private static String EXTERNAL_GENERAL_ENTITIES = BASE_URI + "external-general-entities";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.543 -0400", hash_original_field = "C2BBB19F15E22223BA7D59DCBC646B3E", hash_generated_field = "90337C77035CA2DAA0C29414525D0466")

        private static String EXTERNAL_PARAMETER_ENTITIES = BASE_URI + "external-parameter-entities";
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.543 -0400", hash_original_field = "F338C4248676C2E7E13977787372D419", hash_generated_field = "17E6EC58B4B16225E9A60469FDE56B7C")

    private static String LEXICAL_HANDLER_PROPERTY = "http://xml.org/sax/properties/lexical-handler";
}

