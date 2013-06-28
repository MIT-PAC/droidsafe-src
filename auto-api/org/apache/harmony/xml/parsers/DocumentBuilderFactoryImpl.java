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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.460 -0400", hash_original_method = "CAFBFE87DB9B664F26C15EE0CE72FE04", hash_generated_method = "CAFBFE87DB9B664F26C15EE0CE72FE04")
    public DocumentBuilderFactoryImpl ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.461 -0400", hash_original_method = "ACE2451F013C7800286FF5717C2987CD", hash_generated_method = "5386FAD9F60DABB7DEF7B98E81E55317")
    @Override
    public Object getAttribute(String name) throws IllegalArgumentException {
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(name);
        addTaint(name.getTaint());
        // ---------- Original Method ----------
        //throw new IllegalArgumentException(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.461 -0400", hash_original_method = "64128D577B53B34B78055B7B7FC0B66E", hash_generated_method = "6EE86BF35B4E2170348E5C3DE7395964")
    @Override
    public boolean getFeature(String name) throws ParserConfigurationException {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        {
            boolean varB5E87EDD66EA46D6734F048A6DF6A6AC_1306642279 = (NAMESPACES.equals(name));
            {
                boolean var54D3A66F242CD80548EC545DE521AD6A_2021103541 = (isNamespaceAware());
            } //End block
            {
                boolean varE960E1648FDF4CDE8F0E33579A8BAC01_1258283376 = (VALIDATION.equals(name));
                {
                    boolean var6EA7E2CAE7725614E5D458F15E089661_209237511 = (isValidating());
                } //End block
                {
                    if (DroidSafeAndroidRuntime.control) throw new ParserConfigurationException(name);
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        addTaint(name.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1602061363 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1602061363;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.462 -0400", hash_original_method = "02EA7BC2BA423DC2D4E19D42E2725988", hash_generated_method = "E83E50F9AD4B02F291E8B5135DCB6CFC")
    @Override
    public DocumentBuilder newDocumentBuilder() throws ParserConfigurationException {
        DocumentBuilder varB4EAC82CA7396A68D541C85D26508E83_1506191269 = null; //Variable for return #1
        {
            boolean var4E297FF2ACA5FE750738C034402DA121_1651975606 = (isValidating());
            {
                if (DroidSafeAndroidRuntime.control) throw new ParserConfigurationException(
                    "No validating DocumentBuilder implementation available");
            } //End block
        } //End collapsed parenthetic
        DocumentBuilderImpl builder = new DocumentBuilderImpl();
        builder.setCoalescing(isCoalescing());
        builder.setIgnoreComments(isIgnoringComments());
        builder.setIgnoreElementContentWhitespace(isIgnoringElementContentWhitespace());
        builder.setNamespaceAware(isNamespaceAware());
        varB4EAC82CA7396A68D541C85D26508E83_1506191269 = builder;
        varB4EAC82CA7396A68D541C85D26508E83_1506191269.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1506191269;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.462 -0400", hash_original_method = "0A4757F3D6B7A1DEAD03596DF47811E0", hash_generated_method = "3DA9027D0F3310EC249AA7149223FC1E")
    @Override
    public void setAttribute(String name, Object value) throws IllegalArgumentException {
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(name);
        addTaint(name.getTaint());
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //throw new IllegalArgumentException(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.463 -0400", hash_original_method = "C59D3A431C1BE604F6A4E910499EE08A", hash_generated_method = "C351839D7FDA63CFA4A93240FB0E46C6")
    @Override
    public void setFeature(String name, boolean value) throws ParserConfigurationException {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        {
            boolean varB5E87EDD66EA46D6734F048A6DF6A6AC_522373200 = (NAMESPACES.equals(name));
            {
                setNamespaceAware(value);
            } //End block
            {
                boolean varE960E1648FDF4CDE8F0E33579A8BAC01_505450562 = (VALIDATION.equals(name));
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.463 -0400", hash_original_field = "57DAABD72ED77A96967246F7788B1447", hash_generated_field = "BE5F1192FB3C2F3EED9964DA7D958C23")

    private static final String NAMESPACES = "http://xml.org/sax/features/namespaces";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.463 -0400", hash_original_field = "1A6983F26F9A43F675933304E11A084C", hash_generated_field = "70ED57CE87CAB83D17A94161FFE3B368")

    private static final String VALIDATION = "http://xml.org/sax/features/validation";
}

