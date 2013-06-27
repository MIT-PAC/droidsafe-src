package org.xml.sax.helpers;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.xml.sax.Parser;

public class ParserFactory {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.172 -0400", hash_original_method = "DF02A0380B383E5EEB62CFDB1AB4D130", hash_generated_method = "7139D7C2B3C45021296C696C28AB53E7")
    private  ParserFactory() {
        // ---------- Original Method ----------
    }

    
        public static Parser makeParser() throws ClassNotFoundException,
    IllegalAccessException,
    InstantiationException,
    NullPointerException,
    ClassCastException {
        String className = System.getProperty("org.xml.sax.parser");
        if (className == null) {
        throw new NullPointerException("No value for sax.parser property");
    } else {
        return makeParser(className);
    }
    }

    
        public static Parser makeParser(String className) throws ClassNotFoundException,
    IllegalAccessException,
    InstantiationException,
    ClassCastException {
        return (Parser) NewInstance.newInstance (
        NewInstance.getClassLoader (), className);
    }

    
}

