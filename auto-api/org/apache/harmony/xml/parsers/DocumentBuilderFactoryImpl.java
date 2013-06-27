package org.apache.harmony.xml.parsers;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class DocumentBuilderFactoryImpl extends DocumentBuilderFactory {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.155 -0400", hash_original_method = "CAFBFE87DB9B664F26C15EE0CE72FE04", hash_generated_method = "CAFBFE87DB9B664F26C15EE0CE72FE04")
    public DocumentBuilderFactoryImpl ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.156 -0400", hash_original_method = "ACE2451F013C7800286FF5717C2987CD", hash_generated_method = "5386FAD9F60DABB7DEF7B98E81E55317")
    @Override
    public Object getAttribute(String name) throws IllegalArgumentException {
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(name);
        addTaint(name.getTaint());
        // ---------- Original Method ----------
        //throw new IllegalArgumentException(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.198 -0400", hash_original_method = "64128D577B53B34B78055B7B7FC0B66E", hash_generated_method = "C5AC9ECD2B9D3FF0705D4DB8B6472D56")
    @Override
    public boolean getFeature(String name) throws ParserConfigurationException {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        {
            boolean varB5E87EDD66EA46D6734F048A6DF6A6AC_1793818184 = (NAMESPACES.equals(name));
            {
                boolean var54D3A66F242CD80548EC545DE521AD6A_1714014674 = (isNamespaceAware());
            } //End block
            {
                boolean varE960E1648FDF4CDE8F0E33579A8BAC01_643197653 = (VALIDATION.equals(name));
                {
                    boolean var6EA7E2CAE7725614E5D458F15E089661_457094534 = (isValidating());
                } //End block
                {
                    if (DroidSafeAndroidRuntime.control) throw new ParserConfigurationException(name);
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        addTaint(name.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_919191801 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_919191801;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.199 -0400", hash_original_method = "02EA7BC2BA423DC2D4E19D42E2725988", hash_generated_method = "A4504428F4CB4F9A4272EDE5DE77F014")
    @Override
    public DocumentBuilder newDocumentBuilder() throws ParserConfigurationException {
        DocumentBuilder varB4EAC82CA7396A68D541C85D26508E83_1530652174 = null; //Variable for return #1
        {
            boolean var4E297FF2ACA5FE750738C034402DA121_989104806 = (isValidating());
            {
                if (DroidSafeAndroidRuntime.control) throw new ParserConfigurationException(
                    "No validating DocumentBuilder implementation available");
            } //End block
        } //End collapsed parenthetic
        DocumentBuilderImpl builder;
        builder = new DocumentBuilderImpl();
        builder.setCoalescing(isCoalescing());
        builder.setIgnoreComments(isIgnoringComments());
        builder.setIgnoreElementContentWhitespace(isIgnoringElementContentWhitespace());
        builder.setNamespaceAware(isNamespaceAware());
        varB4EAC82CA7396A68D541C85D26508E83_1530652174 = builder;
        varB4EAC82CA7396A68D541C85D26508E83_1530652174.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1530652174;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.199 -0400", hash_original_method = "0A4757F3D6B7A1DEAD03596DF47811E0", hash_generated_method = "3DA9027D0F3310EC249AA7149223FC1E")
    @Override
    public void setAttribute(String name, Object value) throws IllegalArgumentException {
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(name);
        addTaint(name.getTaint());
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //throw new IllegalArgumentException(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.200 -0400", hash_original_method = "C59D3A431C1BE604F6A4E910499EE08A", hash_generated_method = "2B11D6AEAAC3F98C748A28A314F87C15")
    @Override
    public void setFeature(String name, boolean value) throws ParserConfigurationException {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        {
            boolean varB5E87EDD66EA46D6734F048A6DF6A6AC_241744809 = (NAMESPACES.equals(name));
            {
                setNamespaceAware(value);
            } //End block
            {
                boolean varE960E1648FDF4CDE8F0E33579A8BAC01_355805885 = (VALIDATION.equals(name));
                {
                    setValidating(value);
                } //End block
                {
                    if (DroidSafeAndroidRuntime.control) throw new ParserConfigurationException(name);
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        addTaint(name.getTaint());
        addTaint(value);
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.200 -0400", hash_original_field = "57DAABD72ED77A96967246F7788B1447", hash_generated_field = "BCE4439DC294C3DB7FEC2C74272B80EB")

    private static String NAMESPACES = "http://xml.org/sax/features/namespaces";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.201 -0400", hash_original_field = "1A6983F26F9A43F675933304E11A084C", hash_generated_field = "5EA15C53594AC6CC1F8287E14EB07B9A")

    private static String VALIDATION = "http://xml.org/sax/features/validation";
}

