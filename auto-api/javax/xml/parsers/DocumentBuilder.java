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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.337 -0400", hash_original_method = "A55CBA234E1648A7F9C09E5B63DC560C", hash_generated_method = "BA105E34266083D2C63C902BC6535525")
    @DSModeled(DSC.SAFE)
    protected DocumentBuilder() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.337 -0400", hash_original_method = "B05B5D751774CA5E926948E22CD07EE8", hash_generated_method = "2559B266869D76599D38F19052EA5B6F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.338 -0400", hash_original_method = "95E59CF6F0A1DFE242840282B735E195", hash_generated_method = "931668FE1B43B276D224A58DA484C989")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Document parse(InputStream is) throws SAXException, IOException {
        dsTaint.addTaint(is.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("InputStream cannot be null");
        } //End block
        InputSource in;
        in = new InputSource(is);
        Document var77102524B9999EEE587AC40FFABF9E40_1333784007 = (parse(in));
        return (Document)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (is == null) {
            //throw new IllegalArgumentException("InputStream cannot be null");
        //}
        //InputSource in = new InputSource(is);
        //return parse(in);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.338 -0400", hash_original_method = "EA811CE95A08B04D15381504F667910C", hash_generated_method = "522B6D77AA8D850888DC5E5666166039")
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
        Document var77102524B9999EEE587AC40FFABF9E40_14920522 = (parse(in));
        return (Document)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (is == null) {
            //throw new IllegalArgumentException("InputStream cannot be null");
        //}
        //InputSource in = new InputSource(is);
        //in.setSystemId(systemId);
        //return parse(in);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.338 -0400", hash_original_method = "595BF8AC63AB584AD723E5F0FBAE035E", hash_generated_method = "FC969CBA1A4AA2338DEFBC5BF3859541")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Document parse(String uri) throws SAXException, IOException {
        dsTaint.addTaint(uri);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("URI cannot be null");
        } //End block
        InputSource in;
        in = new InputSource(uri);
        Document var77102524B9999EEE587AC40FFABF9E40_2054436266 = (parse(in));
        return (Document)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (uri == null) {
            //throw new IllegalArgumentException("URI cannot be null");
        //}
        //InputSource in = new InputSource(uri);
        //return parse(in);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.338 -0400", hash_original_method = "F95298F4448DE156B1C85F49780E514D", hash_generated_method = "62B6E93631111C1ECF9FAB92E6637CBD")
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
        Document var77102524B9999EEE587AC40FFABF9E40_259926917 = (parse(in));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.339 -0400", hash_original_method = "0EC7A1CF3FE0EA75043A7D33C5A41123", hash_generated_method = "E8D1CE38DA0AC2EFA5098B140E0195FB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.339 -0400", hash_original_method = "2D701854F0A16C5A4E7C38BB02DF4544", hash_generated_method = "17F9FF8CAAF857E33351A0E36A06B189")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    private static final boolean DEBUG = false;
}

