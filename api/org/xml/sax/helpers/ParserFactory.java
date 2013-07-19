package org.xml.sax.helpers;

// Droidsafe Imports
import org.xml.sax.Parser;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class ParserFactory {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.485 -0400", hash_original_method = "DF02A0380B383E5EEB62CFDB1AB4D130", hash_generated_method = "7139D7C2B3C45021296C696C28AB53E7")
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

