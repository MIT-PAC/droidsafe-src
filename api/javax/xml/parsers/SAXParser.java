package javax.xml.parsers;

// Droidsafe Imports
import droidsafe.annotations.*;
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:18.902 -0400", hash_original_method = "60861A80C08610A003AEF9BD086AC67B", hash_generated_method = "D85D3D2B092B8D57ADC303B7697DCEA9")
    protected  SAXParser() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:18.903 -0400", hash_original_method = "EE92C6E107D176D208870C8A6C9502AF", hash_generated_method = "CB566E473016E1EFF7269AEEE421B370")
    public void reset() {
        UnsupportedOperationException var7C551673C8356EEBC5D7497F7A95F3F8_1971301081 = new UnsupportedOperationException(
            "This SAXParser, \"" + this.getClass().getName() + "\", does not support the reset functionality."
            + "  Specification \"" + this.getClass().getPackage().getSpecificationTitle() + "\""
            + " version \"" + this.getClass().getPackage().getSpecificationVersion() + "\""
            );
        var7C551673C8356EEBC5D7497F7A95F3F8_1971301081.addTaint(taint);
        throw var7C551673C8356EEBC5D7497F7A95F3F8_1971301081;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException(
            //"This SAXParser, \"" + this.getClass().getName() + "\", does not support the reset functionality."
            //+ "  Specification \"" + this.getClass().getPackage().getSpecificationTitle() + "\""
            //+ " version \"" + this.getClass().getPackage().getSpecificationVersion() + "\""
            //);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:18.903 -0400", hash_original_method = "E0E7EFA387CE9D5F50CEC1024059C3F8", hash_generated_method = "F0298980E86D4D6F524EDADFC94B4550")
    public void parse(InputStream is, HandlerBase hb) throws SAXException, IOException {
        addTaint(hb.getTaint());
        addTaint(is.getTaint());
        if(is == null)        
        {
            IllegalArgumentException varC815381FE103054CE280DFD5B97A6E37_2105314147 = new IllegalArgumentException("InputStream cannot be null");
            varC815381FE103054CE280DFD5B97A6E37_2105314147.addTaint(taint);
            throw varC815381FE103054CE280DFD5B97A6E37_2105314147;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:18.903 -0400", hash_original_method = "E43A55A8544E4B0EB3A11D0317C825F2", hash_generated_method = "E0C0538E77C663EB3B9F6DCED6F07B1F")
    public void parse(
        InputStream is,
        HandlerBase hb,
        String systemId) throws SAXException, IOException {
        addTaint(systemId.getTaint());
        addTaint(hb.getTaint());
        addTaint(is.getTaint());
        if(is == null)        
        {
            IllegalArgumentException varC815381FE103054CE280DFD5B97A6E37_2109900756 = new IllegalArgumentException("InputStream cannot be null");
            varC815381FE103054CE280DFD5B97A6E37_2109900756.addTaint(taint);
            throw varC815381FE103054CE280DFD5B97A6E37_2109900756;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:18.904 -0400", hash_original_method = "F19248E94372C80DC5D37D9D6B998C8A", hash_generated_method = "99D5A79E7542FA7561A46378220EA111")
    public void parse(InputStream is, DefaultHandler dh) throws SAXException, IOException {
        addTaint(dh.getTaint());
        addTaint(is.getTaint());
        if(is == null)        
        {
            IllegalArgumentException varC815381FE103054CE280DFD5B97A6E37_577622539 = new IllegalArgumentException("InputStream cannot be null");
            varC815381FE103054CE280DFD5B97A6E37_577622539.addTaint(taint);
            throw varC815381FE103054CE280DFD5B97A6E37_577622539;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:18.904 -0400", hash_original_method = "1FC33240EB3C018A09EA92FF8A96D1A8", hash_generated_method = "8790765D5F396BD9AFCC8B6313CEB6B2")
    public void parse(
        InputStream is,
        DefaultHandler dh,
        String systemId) throws SAXException, IOException {
        addTaint(systemId.getTaint());
        addTaint(dh.getTaint());
        addTaint(is.getTaint());
        if(is == null)        
        {
            IllegalArgumentException varC815381FE103054CE280DFD5B97A6E37_1260568350 = new IllegalArgumentException("InputStream cannot be null");
            varC815381FE103054CE280DFD5B97A6E37_1260568350.addTaint(taint);
            throw varC815381FE103054CE280DFD5B97A6E37_1260568350;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:18.905 -0400", hash_original_method = "67AC143C34CF78ECFB000A375BF6460F", hash_generated_method = "D9931C3583415B47972F1B5B63E02A3E")
    public void parse(String uri, HandlerBase hb) throws SAXException, IOException {
        addTaint(hb.getTaint());
        addTaint(uri.getTaint());
        if(uri == null)        
        {
            IllegalArgumentException var43E55EBB1529700CC8D575B1A62B12AE_190689244 = new IllegalArgumentException("uri cannot be null");
            var43E55EBB1529700CC8D575B1A62B12AE_190689244.addTaint(taint);
            throw var43E55EBB1529700CC8D575B1A62B12AE_190689244;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:18.905 -0400", hash_original_method = "9D1B9B5B338D189F5FEB6183087C0F90", hash_generated_method = "C18F284FBEAAE0E9EF35F9A2ADDD001E")
    public void parse(String uri, DefaultHandler dh) throws SAXException, IOException {
        addTaint(dh.getTaint());
        addTaint(uri.getTaint());
        if(uri == null)        
        {
            IllegalArgumentException var43E55EBB1529700CC8D575B1A62B12AE_2051984665 = new IllegalArgumentException("uri cannot be null");
            var43E55EBB1529700CC8D575B1A62B12AE_2051984665.addTaint(taint);
            throw var43E55EBB1529700CC8D575B1A62B12AE_2051984665;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:18.906 -0400", hash_original_method = "0F0EB1667ABEA41C60E7456F327FDB47", hash_generated_method = "0C81B40E5A8D72C2C4464E89B7250357")
    public void parse(File f, HandlerBase hb) throws SAXException, IOException {
        addTaint(hb.getTaint());
        addTaint(f.getTaint());
        if(f == null)        
        {
            IllegalArgumentException varFEC080412D1250CB64DE25E01D0B1780_1766921495 = new IllegalArgumentException("File cannot be null");
            varFEC080412D1250CB64DE25E01D0B1780_1766921495.addTaint(taint);
            throw varFEC080412D1250CB64DE25E01D0B1780_1766921495;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:18.906 -0400", hash_original_method = "4E507AEF2C358B180E5AB169C6F8A741", hash_generated_method = "961E29C6FD6C74E6CA8C2C0706259465")
    public void parse(File f, DefaultHandler dh) throws SAXException, IOException {
        addTaint(dh.getTaint());
        addTaint(f.getTaint());
        if(f == null)        
        {
            IllegalArgumentException varFEC080412D1250CB64DE25E01D0B1780_95015230 = new IllegalArgumentException("File cannot be null");
            varFEC080412D1250CB64DE25E01D0B1780_95015230.addTaint(taint);
            throw varFEC080412D1250CB64DE25E01D0B1780_95015230;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:18.907 -0400", hash_original_method = "07160A7FD95C7E2FA31C88097829A206", hash_generated_method = "1DA08175DBAEDB9F69A88E34B64BAF28")
    public void parse(InputSource is, HandlerBase hb) throws SAXException, IOException {
        addTaint(hb.getTaint());
        addTaint(is.getTaint());
        if(is == null)        
        {
            IllegalArgumentException varA613319797731CA5E15D0EBCB2C00F66_122429219 = new IllegalArgumentException("InputSource cannot be null");
            varA613319797731CA5E15D0EBCB2C00F66_122429219.addTaint(taint);
            throw varA613319797731CA5E15D0EBCB2C00F66_122429219;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:18.907 -0400", hash_original_method = "8F425B137DCEBCB18BE581A6911D8EA7", hash_generated_method = "D499D8D6B08ED070913A121A9A183429")
    public void parse(InputSource is, DefaultHandler dh) throws SAXException, IOException {
        addTaint(dh.getTaint());
        addTaint(is.getTaint());
        if(is == null)        
        {
            IllegalArgumentException varA613319797731CA5E15D0EBCB2C00F66_2064598094 = new IllegalArgumentException("InputSource cannot be null");
            varA613319797731CA5E15D0EBCB2C00F66_2064598094.addTaint(taint);
            throw varA613319797731CA5E15D0EBCB2C00F66_2064598094;
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

    
    @DSModeled(DSC.SAFE)
    public abstract org.xml.sax.Parser getParser() throws SAXException;

    
    @DSModeled(DSC.SAFE)
    public abstract org.xml.sax.XMLReader getXMLReader() throws SAXException;

    
    @DSModeled(DSC.SAFE)
    public abstract boolean isNamespaceAware();

    
    @DSModeled(DSC.SAFE)
    public abstract boolean isValidating();

    
    @DSModeled(DSC.SAFE)
    public abstract void setProperty(String name, Object value)
        throws SAXNotRecognizedException, SAXNotSupportedException;

    
    @DSModeled(DSC.SAFE)
    public abstract Object getProperty(String name)
        throws SAXNotRecognizedException, SAXNotSupportedException;

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:18.909 -0400", hash_original_method = "0EC7A1CF3FE0EA75043A7D33C5A41123", hash_generated_method = "2D7536F71708D280101A92135D317B02")
    public Schema getSchema() {
        UnsupportedOperationException varE9742D55AB47AEF31209978AAE994BE9_1331589382 = new UnsupportedOperationException(
            "This parser does not support specification \""
            + this.getClass().getPackage().getSpecificationTitle()
            + "\" version \""
            + this.getClass().getPackage().getSpecificationVersion()
            + "\""
            );
        varE9742D55AB47AEF31209978AAE994BE9_1331589382.addTaint(taint);
        throw varE9742D55AB47AEF31209978AAE994BE9_1331589382;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException(
            //"This parser does not support specification \""
            //+ this.getClass().getPackage().getSpecificationTitle()
            //+ "\" version \""
            //+ this.getClass().getPackage().getSpecificationVersion()
            //+ "\""
            //);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:18.909 -0400", hash_original_method = "2D701854F0A16C5A4E7C38BB02DF4544", hash_generated_method = "B2352F9DEBA91D10BE91DC3FE764B23F")
    public boolean isXIncludeAware() {
        UnsupportedOperationException varE9742D55AB47AEF31209978AAE994BE9_1622723895 = new UnsupportedOperationException(
            "This parser does not support specification \""
            + this.getClass().getPackage().getSpecificationTitle()
            + "\" version \""
            + this.getClass().getPackage().getSpecificationVersion()
            + "\""
            );
        varE9742D55AB47AEF31209978AAE994BE9_1622723895.addTaint(taint);
        throw varE9742D55AB47AEF31209978AAE994BE9_1622723895;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException(
            //"This parser does not support specification \""
            //+ this.getClass().getPackage().getSpecificationTitle()
            //+ "\" version \""
            //+ this.getClass().getPackage().getSpecificationVersion()
            //+ "\""
            //);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:18.909 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "58EDF43BA541A4D47EECFEC3901C7AED")

    private static final boolean DEBUG = false;
}

