package javax.xml.parsers;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.runtime.DroidSafeAndroidRuntime;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
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
    private static final boolean DEBUG = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.555 -0400", hash_original_method = "A55CBA234E1648A7F9C09E5B63DC560C", hash_generated_method = "526FE02168B9CECE7039FD149A507CA1")
    @DSModeled(DSC.SAFE)
    protected DocumentBuilder() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.555 -0400", hash_original_method = "B05B5D751774CA5E926948E22CD07EE8", hash_generated_method = "20412B3D4CC26E10B266A208BED910F0")
    @DSModeled(DSC.SAFE)
    public void reset() {
        throw new UnsupportedOperationException(
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.555 -0400", hash_original_method = "95E59CF6F0A1DFE242840282B735E195", hash_generated_method = "97FD263EFFB69A159D4B605918DA9EBD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Document parse(InputStream is) throws SAXException, IOException {
        dsTaint.addTaint(is.dsTaint);
        {
        	if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("InputStream cannot be null");
        } //End block
        InputSource in;
        in = new InputSource(is);
        Document var77102524B9999EEE587AC40FFABF9E40_33959411 = (parse(in));
        return (Document)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (is == null) {
            //throw new IllegalArgumentException("InputStream cannot be null");
        //}
        //InputSource in = new InputSource(is);
        //return parse(in);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.555 -0400", hash_original_method = "EA811CE95A08B04D15381504F667910C", hash_generated_method = "91DB6964958A5BECAFB5FEDBCB8D1859")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Document parse(InputStream is, String systemId) throws SAXException, IOException {
        dsTaint.addTaint(is.dsTaint);
        dsTaint.addTaint(systemId);
        {
        	if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("InputStream cannot be null");
        } //End block
        InputSource in;
        in = new InputSource(is);
        in.setSystemId(systemId);
        Document var77102524B9999EEE587AC40FFABF9E40_1002103810 = (parse(in));
        return (Document)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (is == null) {
            //throw new IllegalArgumentException("InputStream cannot be null");
        //}
        //InputSource in = new InputSource(is);
        //in.setSystemId(systemId);
        //return parse(in);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.555 -0400", hash_original_method = "595BF8AC63AB584AD723E5F0FBAE035E", hash_generated_method = "154A1437937D3A598494DC5B0506E549")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Document parse(String uri) throws SAXException, IOException {
        dsTaint.addTaint(uri);
        {
        	if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("URI cannot be null");
        } //End block
        InputSource in;
        in = new InputSource(uri);
        Document var77102524B9999EEE587AC40FFABF9E40_1496442735 = (parse(in));
        return (Document)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (uri == null) {
            //throw new IllegalArgumentException("URI cannot be null");
        //}
        //InputSource in = new InputSource(uri);
        //return parse(in);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.555 -0400", hash_original_method = "F95298F4448DE156B1C85F49780E514D", hash_generated_method = "0BC77EA166780DDC93735D64DC04A6BC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Document parse(File f) throws SAXException, IOException {
        dsTaint.addTaint(f.dsTaint);
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
        Document var77102524B9999EEE587AC40FFABF9E40_1289780917 = (parse(in));
        return (Document)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.555 -0400", hash_original_method = "0EC7A1CF3FE0EA75043A7D33C5A41123", hash_generated_method = "175DAC667A6680F762C43DB44CC1F188")
    @DSModeled(DSC.SAFE)
    public Schema getSchema() {
    	if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException(
            "This parser does not support specification \""
            + this.getClass().getPackage().getSpecificationTitle()
            + "\" version \""
            + this.getClass().getPackage().getSpecificationVersion()
            + "\""
            );
        return (Schema)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException(
            //"This parser does not support specification \""
            //+ this.getClass().getPackage().getSpecificationTitle()
            //+ "\" version \""
            //+ this.getClass().getPackage().getSpecificationVersion()
            //+ "\""
            //);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.555 -0400", hash_original_method = "2D701854F0A16C5A4E7C38BB02DF4544", hash_generated_method = "309012FE5A9A0E5B29F1F0BC8392628A")
    @DSModeled(DSC.SAFE)
    public boolean isXIncludeAware() {
    	if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException(
            "This parser does not support specification \""
            + this.getClass().getPackage().getSpecificationTitle()
            + "\" version \""
            + this.getClass().getPackage().getSpecificationVersion()
            + "\""
            );
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException(
            //"This parser does not support specification \""
            //+ this.getClass().getPackage().getSpecificationTitle()
            //+ "\" version \""
            //+ this.getClass().getPackage().getSpecificationVersion()
            //+ "\""
            //);
    }

    
}


