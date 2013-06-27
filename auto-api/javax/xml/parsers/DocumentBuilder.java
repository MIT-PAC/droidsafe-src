package javax.xml.parsers;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import javax.xml.validation.Schema;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public abstract class DocumentBuilder {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:03.435 -0400", hash_original_method = "A55CBA234E1648A7F9C09E5B63DC560C", hash_generated_method = "BA105E34266083D2C63C902BC6535525")
    protected  DocumentBuilder() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:03.445 -0400", hash_original_method = "B05B5D751774CA5E926948E22CD07EE8", hash_generated_method = "2559B266869D76599D38F19052EA5B6F")
    public void reset() {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException(
            "This DocumentBuilder, \"" + this.getClass().getName() + "\", does not support the reset functionality."
            + "  Specification \"" + this.getClass().getPackage().getSpecificationTitle() + "\""
            + " version \"" + this.getClass().getPackage().getSpecificationVersion() + "\""
            );
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException(
            //"This DocumentBuilder, \"" + this.getClass().getName() + "\", does not support the reset functionality."
            //+ "  Specification \"" + this.getClass().getPackage().getSpecificationTitle() + "\""
            //+ " version \"" + this.getClass().getPackage().getSpecificationVersion() + "\""
            //);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:03.446 -0400", hash_original_method = "95E59CF6F0A1DFE242840282B735E195", hash_generated_method = "D637ADFAF281F75AE19157E5734BE760")
    public Document parse(InputStream is) throws SAXException, IOException {
        Document varB4EAC82CA7396A68D541C85D26508E83_177311478 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("InputStream cannot be null");
        } //End block
        InputSource in;
        in = new InputSource(is);
        varB4EAC82CA7396A68D541C85D26508E83_177311478 = parse(in);
        addTaint(is.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_177311478.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_177311478;
        // ---------- Original Method ----------
        //if (is == null) {
            //throw new IllegalArgumentException("InputStream cannot be null");
        //}
        //InputSource in = new InputSource(is);
        //return parse(in);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:03.446 -0400", hash_original_method = "EA811CE95A08B04D15381504F667910C", hash_generated_method = "1648DC26B544D0F2B7B70A113F296AE2")
    public Document parse(InputStream is, String systemId) throws SAXException, IOException {
        Document varB4EAC82CA7396A68D541C85D26508E83_924660814 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("InputStream cannot be null");
        } //End block
        InputSource in;
        in = new InputSource(is);
        in.setSystemId(systemId);
        varB4EAC82CA7396A68D541C85D26508E83_924660814 = parse(in);
        addTaint(is.getTaint());
        addTaint(systemId.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_924660814.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_924660814;
        // ---------- Original Method ----------
        //if (is == null) {
            //throw new IllegalArgumentException("InputStream cannot be null");
        //}
        //InputSource in = new InputSource(is);
        //in.setSystemId(systemId);
        //return parse(in);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:03.448 -0400", hash_original_method = "595BF8AC63AB584AD723E5F0FBAE035E", hash_generated_method = "37AAE53FEA1BD4ED2A5E6B627B4F2938")
    public Document parse(String uri) throws SAXException, IOException {
        Document varB4EAC82CA7396A68D541C85D26508E83_1269604944 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("URI cannot be null");
        } //End block
        InputSource in;
        in = new InputSource(uri);
        varB4EAC82CA7396A68D541C85D26508E83_1269604944 = parse(in);
        addTaint(uri.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1269604944.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1269604944;
        // ---------- Original Method ----------
        //if (uri == null) {
            //throw new IllegalArgumentException("URI cannot be null");
        //}
        //InputSource in = new InputSource(uri);
        //return parse(in);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:03.448 -0400", hash_original_method = "F95298F4448DE156B1C85F49780E514D", hash_generated_method = "E0CF962F12D97BB4516D267D754375B9")
    public Document parse(File f) throws SAXException, IOException {
        Document varB4EAC82CA7396A68D541C85D26508E83_424980683 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("File cannot be null");
        } //End block
        String escapedURI;
        escapedURI = FilePathToURI.filepath2URI(f.getAbsolutePath());
        {
            System.out.println("Escaped URI = " + escapedURI);
        } //End block
        InputSource in;
        in = new InputSource(escapedURI);
        varB4EAC82CA7396A68D541C85D26508E83_424980683 = parse(in);
        addTaint(f.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_424980683.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_424980683;
        // ---------- Original Method ----------
        //if (f == null) {
            //throw new IllegalArgumentException("File cannot be null");
        //}
        //String escapedURI = FilePathToURI.filepath2URI(f.getAbsolutePath());
        //if (DEBUG) {
            //System.out.println("Escaped URI = " + escapedURI);
        //}
        //InputSource in = new InputSource(escapedURI);
        //return parse(in);
    }

    
    public abstract Document parse(InputSource is)
        throws  SAXException, IOException;

    
    public abstract boolean isNamespaceAware();

    
    public abstract boolean isValidating();

    
    public abstract void setEntityResolver(EntityResolver er);

    
    public abstract void setErrorHandler(ErrorHandler eh);

    
    public abstract Document newDocument();

    
    public abstract DOMImplementation getDOMImplementation();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:03.463 -0400", hash_original_method = "0EC7A1CF3FE0EA75043A7D33C5A41123", hash_generated_method = "2E2EBD7A2D5464481CAA84ECE27CE0D0")
    public Schema getSchema() {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException(
            "This parser does not support specification \""
            + this.getClass().getPackage().getSpecificationTitle()
            + "\" version \""
            + this.getClass().getPackage().getSpecificationVersion()
            + "\""
            );
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException(
            //"This parser does not support specification \""
            //+ this.getClass().getPackage().getSpecificationTitle()
            //+ "\" version \""
            //+ this.getClass().getPackage().getSpecificationVersion()
            //+ "\""
            //);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:03.470 -0400", hash_original_method = "2D701854F0A16C5A4E7C38BB02DF4544", hash_generated_method = "3106A7AE946C50A1F0740F8813017E64")
    public boolean isXIncludeAware() {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException(
            "This parser does not support specification \""
            + this.getClass().getPackage().getSpecificationTitle()
            + "\" version \""
            + this.getClass().getPackage().getSpecificationVersion()
            + "\""
            );
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_951325239 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_951325239;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException(
            //"This parser does not support specification \""
            //+ this.getClass().getPackage().getSpecificationTitle()
            //+ "\" version \""
            //+ this.getClass().getPackage().getSpecificationVersion()
            //+ "\""
            //);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:03.471 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "E83DF1E2E661A92B1AFDA8C473D190B2")

    private static boolean DEBUG = false;
}

