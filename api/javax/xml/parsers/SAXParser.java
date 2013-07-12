package javax.xml.parsers;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:20.861 -0400", hash_original_method = "60861A80C08610A003AEF9BD086AC67B", hash_generated_method = "D85D3D2B092B8D57ADC303B7697DCEA9")
    protected  SAXParser() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:20.861 -0400", hash_original_method = "EE92C6E107D176D208870C8A6C9502AF", hash_generated_method = "20555AADD39CBBF8CB174247CE7ADF51")
    public void reset() {
        UnsupportedOperationException var7C551673C8356EEBC5D7497F7A95F3F8_1503495508 = new UnsupportedOperationException(
            "This SAXParser, \"" + this.getClass().getName() + "\", does not support the reset functionality."
            + "  Specification \"" + this.getClass().getPackage().getSpecificationTitle() + "\""
            + " version \"" + this.getClass().getPackage().getSpecificationVersion() + "\""
            );
        var7C551673C8356EEBC5D7497F7A95F3F8_1503495508.addTaint(taint);
        throw var7C551673C8356EEBC5D7497F7A95F3F8_1503495508;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException(
            //"This SAXParser, \"" + this.getClass().getName() + "\", does not support the reset functionality."
            //+ "  Specification \"" + this.getClass().getPackage().getSpecificationTitle() + "\""
            //+ " version \"" + this.getClass().getPackage().getSpecificationVersion() + "\""
            //);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:20.862 -0400", hash_original_method = "E0E7EFA387CE9D5F50CEC1024059C3F8", hash_generated_method = "C79C9BC058C624FE7AA6097303D9A7A4")
    public void parse(InputStream is, HandlerBase hb) throws SAXException, IOException {
        addTaint(hb.getTaint());
        addTaint(is.getTaint());
    if(is == null)        
        {
            IllegalArgumentException varC815381FE103054CE280DFD5B97A6E37_2075750969 = new IllegalArgumentException("InputStream cannot be null");
            varC815381FE103054CE280DFD5B97A6E37_2075750969.addTaint(taint);
            throw varC815381FE103054CE280DFD5B97A6E37_2075750969;
        } //End block
        InputSource input = new InputSource(is);
        this.parse(input, hb);
        // ---------- Original Method ----------
        //if (is == null) {
            //throw new IllegalArgumentException("InputStream cannot be null");
        //}
        //InputSource input = new InputSource(is);
        //this.parse(input, hb);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:20.862 -0400", hash_original_method = "E43A55A8544E4B0EB3A11D0317C825F2", hash_generated_method = "3017AC3AF136C0F67B51E4D9C34816ED")
    public void parse(
        InputStream is,
        HandlerBase hb,
        String systemId) throws SAXException, IOException {
        addTaint(systemId.getTaint());
        addTaint(hb.getTaint());
        addTaint(is.getTaint());
    if(is == null)        
        {
            IllegalArgumentException varC815381FE103054CE280DFD5B97A6E37_1688792754 = new IllegalArgumentException("InputStream cannot be null");
            varC815381FE103054CE280DFD5B97A6E37_1688792754.addTaint(taint);
            throw varC815381FE103054CE280DFD5B97A6E37_1688792754;
        } //End block
        InputSource input = new InputSource(is);
        input.setSystemId(systemId);
        this.parse(input, hb);
        // ---------- Original Method ----------
        //if (is == null) {
            //throw new IllegalArgumentException("InputStream cannot be null");
        //}
        //InputSource input = new InputSource(is);
        //input.setSystemId(systemId);
        //this.parse(input, hb);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:20.863 -0400", hash_original_method = "F19248E94372C80DC5D37D9D6B998C8A", hash_generated_method = "DD06C92770FE563DF66508E910664B88")
    public void parse(InputStream is, DefaultHandler dh) throws SAXException, IOException {
        addTaint(dh.getTaint());
        addTaint(is.getTaint());
    if(is == null)        
        {
            IllegalArgumentException varC815381FE103054CE280DFD5B97A6E37_658104498 = new IllegalArgumentException("InputStream cannot be null");
            varC815381FE103054CE280DFD5B97A6E37_658104498.addTaint(taint);
            throw varC815381FE103054CE280DFD5B97A6E37_658104498;
        } //End block
        InputSource input = new InputSource(is);
        this.parse(input, dh);
        // ---------- Original Method ----------
        //if (is == null) {
            //throw new IllegalArgumentException("InputStream cannot be null");
        //}
        //InputSource input = new InputSource(is);
        //this.parse(input, dh);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:20.863 -0400", hash_original_method = "1FC33240EB3C018A09EA92FF8A96D1A8", hash_generated_method = "E78DF7D61CAD7C3DFC0CCB90D12DD9FE")
    public void parse(
        InputStream is,
        DefaultHandler dh,
        String systemId) throws SAXException, IOException {
        addTaint(systemId.getTaint());
        addTaint(dh.getTaint());
        addTaint(is.getTaint());
    if(is == null)        
        {
            IllegalArgumentException varC815381FE103054CE280DFD5B97A6E37_1314825627 = new IllegalArgumentException("InputStream cannot be null");
            varC815381FE103054CE280DFD5B97A6E37_1314825627.addTaint(taint);
            throw varC815381FE103054CE280DFD5B97A6E37_1314825627;
        } //End block
        InputSource input = new InputSource(is);
        input.setSystemId(systemId);
        this.parse(input, dh);
        // ---------- Original Method ----------
        //if (is == null) {
            //throw new IllegalArgumentException("InputStream cannot be null");
        //}
        //InputSource input = new InputSource(is);
        //input.setSystemId(systemId);
        //this.parse(input, dh);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:20.863 -0400", hash_original_method = "67AC143C34CF78ECFB000A375BF6460F", hash_generated_method = "6B1D29210626ECA6ABE46BCADAF64260")
    public void parse(String uri, HandlerBase hb) throws SAXException, IOException {
        addTaint(hb.getTaint());
        addTaint(uri.getTaint());
    if(uri == null)        
        {
            IllegalArgumentException var43E55EBB1529700CC8D575B1A62B12AE_230111906 = new IllegalArgumentException("uri cannot be null");
            var43E55EBB1529700CC8D575B1A62B12AE_230111906.addTaint(taint);
            throw var43E55EBB1529700CC8D575B1A62B12AE_230111906;
        } //End block
        InputSource input = new InputSource(uri);
        this.parse(input, hb);
        // ---------- Original Method ----------
        //if (uri == null) {
            //throw new IllegalArgumentException("uri cannot be null");
        //}
        //InputSource input = new InputSource(uri);
        //this.parse(input, hb);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:20.864 -0400", hash_original_method = "9D1B9B5B338D189F5FEB6183087C0F90", hash_generated_method = "0BCCF7FC7389FCD3389544DFDA81E63C")
    public void parse(String uri, DefaultHandler dh) throws SAXException, IOException {
        addTaint(dh.getTaint());
        addTaint(uri.getTaint());
    if(uri == null)        
        {
            IllegalArgumentException var43E55EBB1529700CC8D575B1A62B12AE_1812973058 = new IllegalArgumentException("uri cannot be null");
            var43E55EBB1529700CC8D575B1A62B12AE_1812973058.addTaint(taint);
            throw var43E55EBB1529700CC8D575B1A62B12AE_1812973058;
        } //End block
        InputSource input = new InputSource(uri);
        this.parse(input, dh);
        // ---------- Original Method ----------
        //if (uri == null) {
            //throw new IllegalArgumentException("uri cannot be null");
        //}
        //InputSource input = new InputSource(uri);
        //this.parse(input, dh);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:20.864 -0400", hash_original_method = "0F0EB1667ABEA41C60E7456F327FDB47", hash_generated_method = "E4455D5817833F974FDBEADDEA05AEC8")
    public void parse(File f, HandlerBase hb) throws SAXException, IOException {
        addTaint(hb.getTaint());
        addTaint(f.getTaint());
    if(f == null)        
        {
            IllegalArgumentException varFEC080412D1250CB64DE25E01D0B1780_471055354 = new IllegalArgumentException("File cannot be null");
            varFEC080412D1250CB64DE25E01D0B1780_471055354.addTaint(taint);
            throw varFEC080412D1250CB64DE25E01D0B1780_471055354;
        } //End block
        String escapedURI = FilePathToURI.filepath2URI(f.getAbsolutePath());
    if(DEBUG)        
        {
            System.out.println("Escaped URI = " + escapedURI);
        } //End block
        InputSource input = new InputSource(escapedURI);
        this.parse(input, hb);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:20.865 -0400", hash_original_method = "4E507AEF2C358B180E5AB169C6F8A741", hash_generated_method = "F6000199E5685B7E346CF08030F5FC63")
    public void parse(File f, DefaultHandler dh) throws SAXException, IOException {
        addTaint(dh.getTaint());
        addTaint(f.getTaint());
    if(f == null)        
        {
            IllegalArgumentException varFEC080412D1250CB64DE25E01D0B1780_286011670 = new IllegalArgumentException("File cannot be null");
            varFEC080412D1250CB64DE25E01D0B1780_286011670.addTaint(taint);
            throw varFEC080412D1250CB64DE25E01D0B1780_286011670;
        } //End block
        String escapedURI = FilePathToURI.filepath2URI(f.getAbsolutePath());
    if(DEBUG)        
        {
            System.out.println("Escaped URI = " + escapedURI);
        } //End block
        InputSource input = new InputSource(escapedURI);
        this.parse(input, dh);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:20.865 -0400", hash_original_method = "07160A7FD95C7E2FA31C88097829A206", hash_generated_method = "25E24BCB13A496B59AE6CF0EDC87D5F1")
    public void parse(InputSource is, HandlerBase hb) throws SAXException, IOException {
        addTaint(hb.getTaint());
        addTaint(is.getTaint());
    if(is == null)        
        {
            IllegalArgumentException varA613319797731CA5E15D0EBCB2C00F66_234066608 = new IllegalArgumentException("InputSource cannot be null");
            varA613319797731CA5E15D0EBCB2C00F66_234066608.addTaint(taint);
            throw varA613319797731CA5E15D0EBCB2C00F66_234066608;
        } //End block
        Parser parser = this.getParser();
    if(hb != null)        
        {
            parser.setDocumentHandler(hb);
            parser.setEntityResolver(hb);
            parser.setErrorHandler(hb);
            parser.setDTDHandler(hb);
        } //End block
        parser.parse(is);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:20.866 -0400", hash_original_method = "8F425B137DCEBCB18BE581A6911D8EA7", hash_generated_method = "19B2C163FD63F510B26BE4ABB492EED1")
    public void parse(InputSource is, DefaultHandler dh) throws SAXException, IOException {
        addTaint(dh.getTaint());
        addTaint(is.getTaint());
    if(is == null)        
        {
            IllegalArgumentException varA613319797731CA5E15D0EBCB2C00F66_386498270 = new IllegalArgumentException("InputSource cannot be null");
            varA613319797731CA5E15D0EBCB2C00F66_386498270.addTaint(taint);
            throw varA613319797731CA5E15D0EBCB2C00F66_386498270;
        } //End block
        XMLReader reader = this.getXMLReader();
    if(dh != null)        
        {
            reader.setContentHandler(dh);
            reader.setEntityResolver(dh);
            reader.setErrorHandler(dh);
            reader.setDTDHandler(dh);
        } //End block
        reader.parse(is);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:20.867 -0400", hash_original_method = "0EC7A1CF3FE0EA75043A7D33C5A41123", hash_generated_method = "92D6F490BE43845ECC0196EDE76F926D")
    public Schema getSchema() {
        UnsupportedOperationException varE9742D55AB47AEF31209978AAE994BE9_1689864285 = new UnsupportedOperationException(
            "This parser does not support specification \""
            + this.getClass().getPackage().getSpecificationTitle()
            + "\" version \""
            + this.getClass().getPackage().getSpecificationVersion()
            + "\""
            );
        varE9742D55AB47AEF31209978AAE994BE9_1689864285.addTaint(taint);
        throw varE9742D55AB47AEF31209978AAE994BE9_1689864285;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException(
            //"This parser does not support specification \""
            //+ this.getClass().getPackage().getSpecificationTitle()
            //+ "\" version \""
            //+ this.getClass().getPackage().getSpecificationVersion()
            //+ "\""
            //);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:20.868 -0400", hash_original_method = "2D701854F0A16C5A4E7C38BB02DF4544", hash_generated_method = "7B2BD95D6F6733EDC72ABB76429B9974")
    public boolean isXIncludeAware() {
        UnsupportedOperationException varE9742D55AB47AEF31209978AAE994BE9_1978241853 = new UnsupportedOperationException(
            "This parser does not support specification \""
            + this.getClass().getPackage().getSpecificationTitle()
            + "\" version \""
            + this.getClass().getPackage().getSpecificationVersion()
            + "\""
            );
        varE9742D55AB47AEF31209978AAE994BE9_1978241853.addTaint(taint);
        throw varE9742D55AB47AEF31209978AAE994BE9_1978241853;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException(
            //"This parser does not support specification \""
            //+ this.getClass().getPackage().getSpecificationTitle()
            //+ "\" version \""
            //+ this.getClass().getPackage().getSpecificationVersion()
            //+ "\""
            //);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:20.868 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "58EDF43BA541A4D47EECFEC3901C7AED")

    private static final boolean DEBUG = false;
}

