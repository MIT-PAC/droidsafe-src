package org.apache.harmony.xml.parsers;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class DocumentBuilderFactoryImpl extends DocumentBuilderFactory {
    private static final String NAMESPACES =
            "http://xml.org/sax/features/namespaces";
    private static final String VALIDATION =
            "http://xml.org/sax/features/validation";
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.946 -0400", hash_original_method = "ACE2451F013C7800286FF5717C2987CD", hash_generated_method = "7B9EDF5FE8F1A2D9C3701B0026709637")
    @DSModeled(DSC.SAFE)
    @Override
    public Object getAttribute(String name) throws IllegalArgumentException {
        dsTaint.addTaint(name);
        throw new IllegalArgumentException(name);
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new IllegalArgumentException(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.946 -0400", hash_original_method = "64128D577B53B34B78055B7B7FC0B66E", hash_generated_method = "E122F4DD78472C187AF1FEAC92665517")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean getFeature(String name) throws ParserConfigurationException {
        dsTaint.addTaint(name);
        {
            throw new NullPointerException();
        } //End block
        {
            boolean varB5E87EDD66EA46D6734F048A6DF6A6AC_1634928428 = (NAMESPACES.equals(name));
            {
                boolean var54D3A66F242CD80548EC545DE521AD6A_2134879609 = (isNamespaceAware());
            } //End block
            {
                boolean varE960E1648FDF4CDE8F0E33579A8BAC01_1339447272 = (VALIDATION.equals(name));
                {
                    boolean var6EA7E2CAE7725614E5D458F15E089661_627544945 = (isValidating());
                } //End block
                {
                    throw new ParserConfigurationException(name);
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (name == null) {
            //throw new NullPointerException();
        //}
        //if (NAMESPACES.equals(name)) {
            //return isNamespaceAware();
        //} else if (VALIDATION.equals(name)) {
            //return isValidating();
        //} else {
            //throw new ParserConfigurationException(name);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.946 -0400", hash_original_method = "02EA7BC2BA423DC2D4E19D42E2725988", hash_generated_method = "3555619E3A6C22249B9D6108202A982D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public DocumentBuilder newDocumentBuilder() throws ParserConfigurationException {
        {
            boolean var4E297FF2ACA5FE750738C034402DA121_1743692663 = (isValidating());
            {
                throw new ParserConfigurationException(
                    "No validating DocumentBuilder implementation available");
            } //End block
        } //End collapsed parenthetic
        DocumentBuilderImpl builder;
        builder = new DocumentBuilderImpl();
        builder.setCoalescing(isCoalescing());
        builder.setIgnoreComments(isIgnoringComments());
        builder.setIgnoreElementContentWhitespace(isIgnoringElementContentWhitespace());
        builder.setNamespaceAware(isNamespaceAware());
        return (DocumentBuilder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (isValidating()) {
            //throw new ParserConfigurationException(
                    //"No validating DocumentBuilder implementation available");
        //}
        //DocumentBuilderImpl builder = new DocumentBuilderImpl();
        //builder.setCoalescing(isCoalescing());
        //builder.setIgnoreComments(isIgnoringComments());
        //builder.setIgnoreElementContentWhitespace(isIgnoringElementContentWhitespace());
        //builder.setNamespaceAware(isNamespaceAware());
        //return builder;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.946 -0400", hash_original_method = "0A4757F3D6B7A1DEAD03596DF47811E0", hash_generated_method = "16680A3FA2824B929B5F55E36155729A")
    @DSModeled(DSC.SAFE)
    @Override
    public void setAttribute(String name, Object value) throws IllegalArgumentException {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value.dsTaint);
        throw new IllegalArgumentException(name);
        // ---------- Original Method ----------
        //throw new IllegalArgumentException(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.946 -0400", hash_original_method = "C59D3A431C1BE604F6A4E910499EE08A", hash_generated_method = "BA9F964E94C43AD367DF8391F03A5BE3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setFeature(String name, boolean value) throws ParserConfigurationException {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value);
        {
            throw new NullPointerException();
        } //End block
        {
            boolean varB5E87EDD66EA46D6734F048A6DF6A6AC_1049088842 = (NAMESPACES.equals(name));
            {
                setNamespaceAware(value);
            } //End block
            {
                boolean varE960E1648FDF4CDE8F0E33579A8BAC01_1654376448 = (VALIDATION.equals(name));
                {
                    setValidating(value);
                } //End block
                {
                    throw new ParserConfigurationException(name);
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (name == null) {
            //throw new NullPointerException();
        //}
        //if (NAMESPACES.equals(name)) {
            //setNamespaceAware(value);
        //} else if (VALIDATION.equals(name)) {
            //setValidating(value);
        //} else {
            //throw new ParserConfigurationException(name);
        //}
    }

    
}


