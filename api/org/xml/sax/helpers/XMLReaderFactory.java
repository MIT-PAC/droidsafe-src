package org.xml.sax.helpers;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charsets;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

final public class XMLReaderFactory {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.510 -0400", hash_original_method = "8D0EAA86B78920589D202D1252E83CCD", hash_generated_method = "B01B84B33B0F242545E564D5500CACD5")
    private  XMLReaderFactory() {
        // ---------- Original Method ----------
    }

    
    public static XMLReader createXMLReader() throws SAXException {
        String        className = null;
        ClassLoader    loader = NewInstance.getClassLoader ();
        try { className = System.getProperty (property); }
    catch (RuntimeException e) {  }
        if (className == null) {
        try {
        String        service = "META-INF/services/" + property;
        InputStream    in;
        BufferedReader    reader;
        if (loader == null)
            in = ClassLoader.getSystemResourceAsStream (service);
        else
            in = loader.getResourceAsStream (service);
        if (in != null) {
            reader = new BufferedReader (new InputStreamReader (in, Charsets.UTF_8));
            className = reader.readLine ();
            in.close ();
        }
        } catch (Exception e) {
        }
    }
        if (className == null) {
    }
        if (className != null)
        return loadClass (loader, className);
        try {
        return new ParserAdapter (ParserFactory.makeParser ());
    } catch (Exception e) {
        throw new SAXException ("Can't create default XMLReader; "
            + "is system property org.xml.sax.driver set?");
    }
    }

    
    public static XMLReader createXMLReader(String className) throws SAXException {
        return loadClass (NewInstance.getClassLoader (), className);
    }

    
    @DSModeled(DSC.BAN)
    private static XMLReader loadClass(ClassLoader loader, String className) throws SAXException {
        try {
        return (XMLReader) NewInstance.newInstance (loader, className);
    } catch (ClassNotFoundException e1) {
        throw new SAXException("SAX2 driver class " + className +
                   " not found", e1);
    } catch (IllegalAccessException e2) {
        throw new SAXException("SAX2 driver class " + className +
                   " found but cannot be loaded", e2);
    } catch (InstantiationException e3) {
        throw new SAXException("SAX2 driver class " + className +
       " loaded but cannot be instantiated (no empty public constructor?)",
                   e3);
    } catch (ClassCastException e4) {
        throw new SAXException("SAX2 driver class " + className +
                   " does not implement XMLReader", e4);
    }
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.511 -0400", hash_original_field = "A9E1BFE5D4796BA4F422ABAD85F1E5EE", hash_generated_field = "21C340AAACD5354B279B5877FDAA9460")

    private static final String property = "org.xml.sax.driver";
}

