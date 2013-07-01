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
import org.xml.sax.HandlerBase;
import org.xml.sax.InputSource;
import org.xml.sax.Parser;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

public abstract class SAXParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.800 -0400", hash_original_method = "60861A80C08610A003AEF9BD086AC67B", hash_generated_method = "D85D3D2B092B8D57ADC303B7697DCEA9")
    protected  SAXParser() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.801 -0400", hash_original_method = "EE92C6E107D176D208870C8A6C9502AF", hash_generated_method = "9143287AF68609AEF72DB0E83AD02E5E")
    public void reset() {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException(
            "This SAXParser, \"" + this.getClass().getName() + "\", does not support the reset functionality."
            + "  Specification \"" + this.getClass().getPackage().getSpecificationTitle() + "\""
            + " version \"" + this.getClass().getPackage().getSpecificationVersion() + "\""
            );
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException(
            //"This SAXParser, \"" + this.getClass().getName() + "\", does not support the reset functionality."
            //+ "  Specification \"" + this.getClass().getPackage().getSpecificationTitle() + "\""
            //+ " version \"" + this.getClass().getPackage().getSpecificationVersion() + "\""
            //);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.801 -0400", hash_original_method = "E0E7EFA387CE9D5F50CEC1024059C3F8", hash_generated_method = "4C541BB6BBC21F13B8F44A754FC7CC38")
    public void parse(InputStream is, HandlerBase hb) throws SAXException, IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("InputStream cannot be null");
        } //End block
        InputSource input = new InputSource(is);
        this.parse(input, hb);
        addTaint(is.getTaint());
        addTaint(hb.getTaint());
        // ---------- Original Method ----------
        //if (is == null) {
            //throw new IllegalArgumentException("InputStream cannot be null");
        //}
        //InputSource input = new InputSource(is);
        //this.parse(input, hb);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.801 -0400", hash_original_method = "E43A55A8544E4B0EB3A11D0317C825F2", hash_generated_method = "AA5580127AE113DA41EF8DDA2A235EB8")
    public void parse(
        InputStream is,
        HandlerBase hb,
        String systemId) throws SAXException, IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("InputStream cannot be null");
        } //End block
        InputSource input = new InputSource(is);
        input.setSystemId(systemId);
        this.parse(input, hb);
        addTaint(is.getTaint());
        addTaint(hb.getTaint());
        addTaint(systemId.getTaint());
        // ---------- Original Method ----------
        //if (is == null) {
            //throw new IllegalArgumentException("InputStream cannot be null");
        //}
        //InputSource input = new InputSource(is);
        //input.setSystemId(systemId);
        //this.parse(input, hb);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.801 -0400", hash_original_method = "F19248E94372C80DC5D37D9D6B998C8A", hash_generated_method = "BFE9DFE9186BE48E5230F0E2D5154E0D")
    public void parse(InputStream is, DefaultHandler dh) throws SAXException, IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("InputStream cannot be null");
        } //End block
        InputSource input = new InputSource(is);
        this.parse(input, dh);
        addTaint(is.getTaint());
        addTaint(dh.getTaint());
        // ---------- Original Method ----------
        //if (is == null) {
            //throw new IllegalArgumentException("InputStream cannot be null");
        //}
        //InputSource input = new InputSource(is);
        //this.parse(input, dh);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.802 -0400", hash_original_method = "1FC33240EB3C018A09EA92FF8A96D1A8", hash_generated_method = "DC85B5792C749362B3CE92D34FAAC468")
    public void parse(
        InputStream is,
        DefaultHandler dh,
        String systemId) throws SAXException, IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("InputStream cannot be null");
        } //End block
        InputSource input = new InputSource(is);
        input.setSystemId(systemId);
        this.parse(input, dh);
        addTaint(is.getTaint());
        addTaint(dh.getTaint());
        addTaint(systemId.getTaint());
        // ---------- Original Method ----------
        //if (is == null) {
            //throw new IllegalArgumentException("InputStream cannot be null");
        //}
        //InputSource input = new InputSource(is);
        //input.setSystemId(systemId);
        //this.parse(input, dh);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.802 -0400", hash_original_method = "67AC143C34CF78ECFB000A375BF6460F", hash_generated_method = "927F7E491F5534F183C5F582C3A2C075")
    public void parse(String uri, HandlerBase hb) throws SAXException, IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("uri cannot be null");
        } //End block
        InputSource input = new InputSource(uri);
        this.parse(input, hb);
        addTaint(uri.getTaint());
        addTaint(hb.getTaint());
        // ---------- Original Method ----------
        //if (uri == null) {
            //throw new IllegalArgumentException("uri cannot be null");
        //}
        //InputSource input = new InputSource(uri);
        //this.parse(input, hb);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.802 -0400", hash_original_method = "9D1B9B5B338D189F5FEB6183087C0F90", hash_generated_method = "9C5A76CD421BC4437D871151AC24FDD1")
    public void parse(String uri, DefaultHandler dh) throws SAXException, IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("uri cannot be null");
        } //End block
        InputSource input = new InputSource(uri);
        this.parse(input, dh);
        addTaint(uri.getTaint());
        addTaint(dh.getTaint());
        // ---------- Original Method ----------
        //if (uri == null) {
            //throw new IllegalArgumentException("uri cannot be null");
        //}
        //InputSource input = new InputSource(uri);
        //this.parse(input, dh);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.803 -0400", hash_original_method = "0F0EB1667ABEA41C60E7456F327FDB47", hash_generated_method = "709E1B5F9CC9EC7D83CCA7AC7618EE5D")
    public void parse(File f, HandlerBase hb) throws SAXException, IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("File cannot be null");
        } //End block
        String escapedURI = FilePathToURI.filepath2URI(f.getAbsolutePath());
        {
            System.out.println("Escaped URI = " + escapedURI);
        } //End block
        InputSource input = new InputSource(escapedURI);
        this.parse(input, hb);
        addTaint(f.getTaint());
        addTaint(hb.getTaint());
        // ---------- Original Method ----------
        //if (f == null) {
            //throw new IllegalArgumentException("File cannot be null");
        //}
        //String escapedURI = FilePathToURI.filepath2URI(f.getAbsolutePath());
        //if (DEBUG) {
            //System.out.println("Escaped URI = " + escapedURI);
        //}
        //InputSource input = new InputSource(escapedURI);
        //this.parse(input, hb);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.804 -0400", hash_original_method = "4E507AEF2C358B180E5AB169C6F8A741", hash_generated_method = "E1BF53FE05DDAF79B6AF60F563CC1AA1")
    public void parse(File f, DefaultHandler dh) throws SAXException, IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("File cannot be null");
        } //End block
        String escapedURI = FilePathToURI.filepath2URI(f.getAbsolutePath());
        {
            System.out.println("Escaped URI = " + escapedURI);
        } //End block
        InputSource input = new InputSource(escapedURI);
        this.parse(input, dh);
        addTaint(f.getTaint());
        addTaint(dh.getTaint());
        // ---------- Original Method ----------
        //if (f == null) {
            //throw new IllegalArgumentException("File cannot be null");
        //}
        //String escapedURI = FilePathToURI.filepath2URI(f.getAbsolutePath());
        //if (DEBUG) {
            //System.out.println("Escaped URI = " + escapedURI);
        //}
        //InputSource input = new InputSource(escapedURI);
        //this.parse(input, dh);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.805 -0400", hash_original_method = "07160A7FD95C7E2FA31C88097829A206", hash_generated_method = "503638CF59727D05778EC37CD565B8E3")
    public void parse(InputSource is, HandlerBase hb) throws SAXException, IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("InputSource cannot be null");
        } //End block
        Parser parser = this.getParser();
        {
            parser.setDocumentHandler(hb);
            parser.setEntityResolver(hb);
            parser.setErrorHandler(hb);
            parser.setDTDHandler(hb);
        } //End block
        parser.parse(is);
        addTaint(is.getTaint());
        addTaint(hb.getTaint());
        // ---------- Original Method ----------
        //if (is == null) {
            //throw new IllegalArgumentException("InputSource cannot be null");
        //}
        //Parser parser = this.getParser();
        //if (hb != null) {
            //parser.setDocumentHandler(hb);
            //parser.setEntityResolver(hb);
            //parser.setErrorHandler(hb);
            //parser.setDTDHandler(hb);
        //}
        //parser.parse(is);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.805 -0400", hash_original_method = "8F425B137DCEBCB18BE581A6911D8EA7", hash_generated_method = "9BE57DF412D01C90E2CDC5A181CFD1BE")
    public void parse(InputSource is, DefaultHandler dh) throws SAXException, IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("InputSource cannot be null");
        } //End block
        XMLReader reader = this.getXMLReader();
        {
            reader.setContentHandler(dh);
            reader.setEntityResolver(dh);
            reader.setErrorHandler(dh);
            reader.setDTDHandler(dh);
        } //End block
        reader.parse(is);
        addTaint(is.getTaint());
        addTaint(dh.getTaint());
        // ---------- Original Method ----------
        //if (is == null) {
            //throw new IllegalArgumentException("InputSource cannot be null");
        //}
        //XMLReader reader = this.getXMLReader();
        //if (dh != null) {
            //reader.setContentHandler(dh);
            //reader.setEntityResolver(dh);
            //reader.setErrorHandler(dh);
            //reader.setDTDHandler(dh);
        //}
        //reader.parse(is);
    }

    
    public abstract org.xml.sax.Parser getParser() throws SAXException;

    
    public abstract org.xml.sax.XMLReader getXMLReader() throws SAXException;

    
    public abstract boolean isNamespaceAware();

    
    public abstract boolean isValidating();

    
    public abstract void setProperty(String name, Object value)
        throws SAXNotRecognizedException, SAXNotSupportedException;

    
    public abstract Object getProperty(String name)
        throws SAXNotRecognizedException, SAXNotSupportedException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.806 -0400", hash_original_method = "0EC7A1CF3FE0EA75043A7D33C5A41123", hash_generated_method = "2E2EBD7A2D5464481CAA84ECE27CE0D0")
    public Schema getSchema() {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException(
            "This parser does not support specification \""
            + this.getClass().getPackage().getSpecificationTitle()
            + "\" version \""
            + this.getClass().getPackage().getSpecificationVersion()
            + "\""
            );
        return (Schema)new Object();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException(
            //"This parser does not support specification \""
            //+ this.getClass().getPackage().getSpecificationTitle()
            //+ "\" version \""
            //+ this.getClass().getPackage().getSpecificationVersion()
            //+ "\""
            //);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.807 -0400", hash_original_method = "2D701854F0A16C5A4E7C38BB02DF4544", hash_generated_method = "4129359F22887618CF3FE9596E3EFC31")
    public boolean isXIncludeAware() {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException(
            "This parser does not support specification \""
            + this.getClass().getPackage().getSpecificationTitle()
            + "\" version \""
            + this.getClass().getPackage().getSpecificationVersion()
            + "\""
            );
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1127977425 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1127977425;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException(
            //"This parser does not support specification \""
            //+ this.getClass().getPackage().getSpecificationTitle()
            //+ "\" version \""
            //+ this.getClass().getPackage().getSpecificationVersion()
            //+ "\""
            //);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.807 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "58EDF43BA541A4D47EECFEC3901C7AED")

    private static final boolean DEBUG = false;
}

