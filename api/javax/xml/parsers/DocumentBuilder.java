package javax.xml.parsers;


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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:10.365 -0400", hash_original_method = "A55CBA234E1648A7F9C09E5B63DC560C", hash_generated_method = "BA105E34266083D2C63C902BC6535525")
    protected  DocumentBuilder() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:10.366 -0400", hash_original_method = "B05B5D751774CA5E926948E22CD07EE8", hash_generated_method = "1427D653FF21B3AA841DF9835282179D")
    public void reset() {
        UnsupportedOperationException varD57A366DA765BBC5B5CB8D1F17AA41CA_257499705 = new UnsupportedOperationException(
            "This DocumentBuilder, \"" + this.getClass().getName() + "\", does not support the reset functionality."
            + "  Specification \"" + this.getClass().getPackage().getSpecificationTitle() + "\""
            + " version \"" + this.getClass().getPackage().getSpecificationVersion() + "\""
            );
        varD57A366DA765BBC5B5CB8D1F17AA41CA_257499705.addTaint(taint);
        throw varD57A366DA765BBC5B5CB8D1F17AA41CA_257499705;
        
        
            
            
            
            
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:10.366 -0400", hash_original_method = "95E59CF6F0A1DFE242840282B735E195", hash_generated_method = "ED2F88E014A0334714F65A529311FDF7")
    public Document parse(InputStream is) throws SAXException, IOException {
        addTaint(is.getTaint());
    if(is == null)        
        {
            IllegalArgumentException varC815381FE103054CE280DFD5B97A6E37_350679484 = new IllegalArgumentException("InputStream cannot be null");
            varC815381FE103054CE280DFD5B97A6E37_350679484.addTaint(taint);
            throw varC815381FE103054CE280DFD5B97A6E37_350679484;
        } 
        InputSource in = new InputSource(is);
Document var8BBF39D47F9CE28DC6E7F629ED464CBB_646125927 =         parse(in);
        var8BBF39D47F9CE28DC6E7F629ED464CBB_646125927.addTaint(taint);
        return var8BBF39D47F9CE28DC6E7F629ED464CBB_646125927;
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:10.367 -0400", hash_original_method = "EA811CE95A08B04D15381504F667910C", hash_generated_method = "FB43D00E07592D6187C5B64709674779")
    public Document parse(InputStream is, String systemId) throws SAXException, IOException {
        addTaint(systemId.getTaint());
        addTaint(is.getTaint());
    if(is == null)        
        {
            IllegalArgumentException varC815381FE103054CE280DFD5B97A6E37_2125217235 = new IllegalArgumentException("InputStream cannot be null");
            varC815381FE103054CE280DFD5B97A6E37_2125217235.addTaint(taint);
            throw varC815381FE103054CE280DFD5B97A6E37_2125217235;
        } 
        InputSource in = new InputSource(is);
        in.setSystemId(systemId);
Document var8BBF39D47F9CE28DC6E7F629ED464CBB_768983779 =         parse(in);
        var8BBF39D47F9CE28DC6E7F629ED464CBB_768983779.addTaint(taint);
        return var8BBF39D47F9CE28DC6E7F629ED464CBB_768983779;
        
        
            
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:10.367 -0400", hash_original_method = "595BF8AC63AB584AD723E5F0FBAE035E", hash_generated_method = "1D6A7FA6A033258C057B1C8A120A3AA7")
    public Document parse(String uri) throws SAXException, IOException {
        addTaint(uri.getTaint());
    if(uri == null)        
        {
            IllegalArgumentException varF6E0E2AFA82B103FC9C391721448DB47_587315946 = new IllegalArgumentException("URI cannot be null");
            varF6E0E2AFA82B103FC9C391721448DB47_587315946.addTaint(taint);
            throw varF6E0E2AFA82B103FC9C391721448DB47_587315946;
        } 
        InputSource in = new InputSource(uri);
Document var8BBF39D47F9CE28DC6E7F629ED464CBB_1737582690 =         parse(in);
        var8BBF39D47F9CE28DC6E7F629ED464CBB_1737582690.addTaint(taint);
        return var8BBF39D47F9CE28DC6E7F629ED464CBB_1737582690;
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:10.368 -0400", hash_original_method = "F95298F4448DE156B1C85F49780E514D", hash_generated_method = "085263CEA736544E2F602A43033F4966")
    public Document parse(File f) throws SAXException, IOException {
        addTaint(f.getTaint());
    if(f == null)        
        {
            IllegalArgumentException varFEC080412D1250CB64DE25E01D0B1780_1359339912 = new IllegalArgumentException("File cannot be null");
            varFEC080412D1250CB64DE25E01D0B1780_1359339912.addTaint(taint);
            throw varFEC080412D1250CB64DE25E01D0B1780_1359339912;
        } 
        String escapedURI = FilePathToURI.filepath2URI(f.getAbsolutePath());
    if(DEBUG)        
        {
            System.out.println("Escaped URI = " + escapedURI);
        } 
        InputSource in = new InputSource(escapedURI);
Document var8BBF39D47F9CE28DC6E7F629ED464CBB_1165156594 =         parse(in);
        var8BBF39D47F9CE28DC6E7F629ED464CBB_1165156594.addTaint(taint);
        return var8BBF39D47F9CE28DC6E7F629ED464CBB_1165156594;
        
        
            
        
        
        
            
        
        
        
    }

    
    public abstract Document parse(InputSource is)
        throws  SAXException, IOException;

    
    public abstract boolean isNamespaceAware();

    
    public abstract boolean isValidating();

    
    public abstract void setEntityResolver(EntityResolver er);

    
    public abstract void setErrorHandler(ErrorHandler eh);

    
    public abstract Document newDocument();

    
    public abstract DOMImplementation getDOMImplementation();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:10.369 -0400", hash_original_method = "0EC7A1CF3FE0EA75043A7D33C5A41123", hash_generated_method = "92F648BFA3AB6E7096F61C163FAB2FDA")
    public Schema getSchema() {
        UnsupportedOperationException varE9742D55AB47AEF31209978AAE994BE9_1156412758 = new UnsupportedOperationException(
            "This parser does not support specification \""
            + this.getClass().getPackage().getSpecificationTitle()
            + "\" version \""
            + this.getClass().getPackage().getSpecificationVersion()
            + "\""
            );
        varE9742D55AB47AEF31209978AAE994BE9_1156412758.addTaint(taint);
        throw varE9742D55AB47AEF31209978AAE994BE9_1156412758;
        
        
            
            
            
            
            
            
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:10.370 -0400", hash_original_method = "2D701854F0A16C5A4E7C38BB02DF4544", hash_generated_method = "FD1912ED403E532783B2E007C3AD5590")
    public boolean isXIncludeAware() {
        UnsupportedOperationException varE9742D55AB47AEF31209978AAE994BE9_433446108 = new UnsupportedOperationException(
            "This parser does not support specification \""
            + this.getClass().getPackage().getSpecificationTitle()
            + "\" version \""
            + this.getClass().getPackage().getSpecificationVersion()
            + "\""
            );
        varE9742D55AB47AEF31209978AAE994BE9_433446108.addTaint(taint);
        throw varE9742D55AB47AEF31209978AAE994BE9_433446108;
        
        
            
            
            
            
            
            
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:10.370 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "58EDF43BA541A4D47EECFEC3901C7AED")

    private static final boolean DEBUG = false;
}

