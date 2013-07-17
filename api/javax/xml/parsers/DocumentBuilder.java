package javax.xml.parsers;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:18.668 -0400", hash_original_method = "A55CBA234E1648A7F9C09E5B63DC560C", hash_generated_method = "BA105E34266083D2C63C902BC6535525")
    protected  DocumentBuilder() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:18.668 -0400", hash_original_method = "B05B5D751774CA5E926948E22CD07EE8", hash_generated_method = "B93C4366999C08EC6C838DE2538B844B")
    public void reset() {
        UnsupportedOperationException varD57A366DA765BBC5B5CB8D1F17AA41CA_1503439086 = new UnsupportedOperationException(
            "This DocumentBuilder, \"" + this.getClass().getName() + "\", does not support the reset functionality."
            + "  Specification \"" + this.getClass().getPackage().getSpecificationTitle() + "\""
            + " version \"" + this.getClass().getPackage().getSpecificationVersion() + "\""
            );
        varD57A366DA765BBC5B5CB8D1F17AA41CA_1503439086.addTaint(taint);
        throw varD57A366DA765BBC5B5CB8D1F17AA41CA_1503439086;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException(
            //"This DocumentBuilder, \"" + this.getClass().getName() + "\", does not support the reset functionality."
            //+ "  Specification \"" + this.getClass().getPackage().getSpecificationTitle() + "\""
            //+ " version \"" + this.getClass().getPackage().getSpecificationVersion() + "\""
            //);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:18.669 -0400", hash_original_method = "95E59CF6F0A1DFE242840282B735E195", hash_generated_method = "2EF99C1D795AAC3B61D79F7CC4612DFD")
    public Document parse(InputStream is) throws SAXException, IOException {
        addTaint(is.getTaint());
        if(is == null)        
        {
            IllegalArgumentException varC815381FE103054CE280DFD5B97A6E37_424805687 = new IllegalArgumentException("InputStream cannot be null");
            varC815381FE103054CE280DFD5B97A6E37_424805687.addTaint(taint);
            throw varC815381FE103054CE280DFD5B97A6E37_424805687;
        } //End block
        InputSource in = new InputSource(is);
Document var8BBF39D47F9CE28DC6E7F629ED464CBB_1098687120 =         parse(in);
        var8BBF39D47F9CE28DC6E7F629ED464CBB_1098687120.addTaint(taint);
        return var8BBF39D47F9CE28DC6E7F629ED464CBB_1098687120;
        // ---------- Original Method ----------
        //if (is == null) {
            //throw new IllegalArgumentException("InputStream cannot be null");
        //}
        //InputSource in = new InputSource(is);
        //return parse(in);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:18.669 -0400", hash_original_method = "EA811CE95A08B04D15381504F667910C", hash_generated_method = "0BA2CB7D38778C6C1CC5E0BDA5C3DFAE")
    public Document parse(InputStream is, String systemId) throws SAXException, IOException {
        addTaint(systemId.getTaint());
        addTaint(is.getTaint());
        if(is == null)        
        {
            IllegalArgumentException varC815381FE103054CE280DFD5B97A6E37_1836479405 = new IllegalArgumentException("InputStream cannot be null");
            varC815381FE103054CE280DFD5B97A6E37_1836479405.addTaint(taint);
            throw varC815381FE103054CE280DFD5B97A6E37_1836479405;
        } //End block
        InputSource in = new InputSource(is);
        in.setSystemId(systemId);
Document var8BBF39D47F9CE28DC6E7F629ED464CBB_1832750748 =         parse(in);
        var8BBF39D47F9CE28DC6E7F629ED464CBB_1832750748.addTaint(taint);
        return var8BBF39D47F9CE28DC6E7F629ED464CBB_1832750748;
        // ---------- Original Method ----------
        //if (is == null) {
            //throw new IllegalArgumentException("InputStream cannot be null");
        //}
        //InputSource in = new InputSource(is);
        //in.setSystemId(systemId);
        //return parse(in);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:18.669 -0400", hash_original_method = "595BF8AC63AB584AD723E5F0FBAE035E", hash_generated_method = "DC78036C2890191FF461EB4FF61AE232")
    public Document parse(String uri) throws SAXException, IOException {
        addTaint(uri.getTaint());
        if(uri == null)        
        {
            IllegalArgumentException varF6E0E2AFA82B103FC9C391721448DB47_1508082224 = new IllegalArgumentException("URI cannot be null");
            varF6E0E2AFA82B103FC9C391721448DB47_1508082224.addTaint(taint);
            throw varF6E0E2AFA82B103FC9C391721448DB47_1508082224;
        } //End block
        InputSource in = new InputSource(uri);
Document var8BBF39D47F9CE28DC6E7F629ED464CBB_428407042 =         parse(in);
        var8BBF39D47F9CE28DC6E7F629ED464CBB_428407042.addTaint(taint);
        return var8BBF39D47F9CE28DC6E7F629ED464CBB_428407042;
        // ---------- Original Method ----------
        //if (uri == null) {
            //throw new IllegalArgumentException("URI cannot be null");
        //}
        //InputSource in = new InputSource(uri);
        //return parse(in);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:18.670 -0400", hash_original_method = "F95298F4448DE156B1C85F49780E514D", hash_generated_method = "21318756401FDAF740788D1C9C403ACD")
    public Document parse(File f) throws SAXException, IOException {
        addTaint(f.getTaint());
        if(f == null)        
        {
            IllegalArgumentException varFEC080412D1250CB64DE25E01D0B1780_104459582 = new IllegalArgumentException("File cannot be null");
            varFEC080412D1250CB64DE25E01D0B1780_104459582.addTaint(taint);
            throw varFEC080412D1250CB64DE25E01D0B1780_104459582;
        } //End block
        String escapedURI = FilePathToURI.filepath2URI(f.getAbsolutePath());
        if(DEBUG)        
        {
            System.out.println("Escaped URI = " + escapedURI);
        } //End block
        InputSource in = new InputSource(escapedURI);
Document var8BBF39D47F9CE28DC6E7F629ED464CBB_1702325885 =         parse(in);
        var8BBF39D47F9CE28DC6E7F629ED464CBB_1702325885.addTaint(taint);
        return var8BBF39D47F9CE28DC6E7F629ED464CBB_1702325885;
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

    
    @DSModeled(DSC.SAFE)
    public abstract Document parse(InputSource is)
        throws  SAXException, IOException;

    
    @DSModeled(DSC.SAFE)
    public abstract boolean isNamespaceAware();

    
    @DSModeled(DSC.SAFE)
    public abstract boolean isValidating();

    
    @DSModeled(DSC.SAFE)
    public abstract void setEntityResolver(EntityResolver er);

    
    @DSModeled(DSC.SAFE)
    public abstract void setErrorHandler(ErrorHandler eh);

    
    @DSModeled(DSC.SAFE)
    public abstract Document newDocument();

    
    @DSModeled(DSC.SAFE)
    public abstract DOMImplementation getDOMImplementation();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:18.672 -0400", hash_original_method = "0EC7A1CF3FE0EA75043A7D33C5A41123", hash_generated_method = "67782BB5ADC01CDBDE8FEE9AB5E2CEC2")
    public Schema getSchema() {
        UnsupportedOperationException varE9742D55AB47AEF31209978AAE994BE9_1958264661 = new UnsupportedOperationException(
            "This parser does not support specification \""
            + this.getClass().getPackage().getSpecificationTitle()
            + "\" version \""
            + this.getClass().getPackage().getSpecificationVersion()
            + "\""
            );
        varE9742D55AB47AEF31209978AAE994BE9_1958264661.addTaint(taint);
        throw varE9742D55AB47AEF31209978AAE994BE9_1958264661;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException(
            //"This parser does not support specification \""
            //+ this.getClass().getPackage().getSpecificationTitle()
            //+ "\" version \""
            //+ this.getClass().getPackage().getSpecificationVersion()
            //+ "\""
            //);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:18.672 -0400", hash_original_method = "2D701854F0A16C5A4E7C38BB02DF4544", hash_generated_method = "25F8C6E1FC17BC94AB2228F7A124C6A9")
    public boolean isXIncludeAware() {
        UnsupportedOperationException varE9742D55AB47AEF31209978AAE994BE9_1952587041 = new UnsupportedOperationException(
            "This parser does not support specification \""
            + this.getClass().getPackage().getSpecificationTitle()
            + "\" version \""
            + this.getClass().getPackage().getSpecificationVersion()
            + "\""
            );
        varE9742D55AB47AEF31209978AAE994BE9_1952587041.addTaint(taint);
        throw varE9742D55AB47AEF31209978AAE994BE9_1952587041;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException(
            //"This parser does not support specification \""
            //+ this.getClass().getPackage().getSpecificationTitle()
            //+ "\" version \""
            //+ this.getClass().getPackage().getSpecificationVersion()
            //+ "\""
            //);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:18.672 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "58EDF43BA541A4D47EECFEC3901C7AED")

    private static final boolean DEBUG = false;
}

