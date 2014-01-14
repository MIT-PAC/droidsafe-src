package org.apache.harmony.xml.parsers;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class DocumentBuilderFactoryImpl extends DocumentBuilderFactory {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:23.843 -0500", hash_original_field = "23D5E90A009660027D8004B0865026CF", hash_generated_field = "BE5F1192FB3C2F3EED9964DA7D958C23")

    private static final String NAMESPACES =
            "http://xml.org/sax/features/namespaces";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:23.845 -0500", hash_original_field = "82AE1762CE90A109938E89B1ADAFE1BF", hash_generated_field = "70ED57CE87CAB83D17A94161FFE3B368")

    private static final String VALIDATION =
            "http://xml.org/sax/features/validation";
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.725 -0400", hash_original_method = "CAFBFE87DB9B664F26C15EE0CE72FE04", hash_generated_method = "CAFBFE87DB9B664F26C15EE0CE72FE04")
    public DocumentBuilderFactoryImpl ()
    {
        //Synthesized constructor
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:23.848 -0500", hash_original_method = "ACE2451F013C7800286FF5717C2987CD", hash_generated_method = "94A100F42D06FDF28D7136E08CEBA4E6")
    
@Override
    public Object getAttribute(String name) throws IllegalArgumentException {
        throw new IllegalArgumentException(name);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:23.850 -0500", hash_original_method = "64128D577B53B34B78055B7B7FC0B66E", hash_generated_method = "3A576862299EFB58E6FD019B8640EDB8")
    
@Override
    public boolean getFeature(String name) throws ParserConfigurationException {
        if (name == null) {
            throw new NullPointerException();
        }

        if (NAMESPACES.equals(name)) {
            return isNamespaceAware();
        } else if (VALIDATION.equals(name)) {
            return isValidating();
        } else {
            throw new ParserConfigurationException(name);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:23.853 -0500", hash_original_method = "02EA7BC2BA423DC2D4E19D42E2725988", hash_generated_method = "F5DD0D2B4B9A17D9FF85169B2B025C14")
    
@Override
    public DocumentBuilder newDocumentBuilder()
            throws ParserConfigurationException {
        if (isValidating()) {
            throw new ParserConfigurationException(
                    "No validating DocumentBuilder implementation available");
        }

        /**
         * TODO If Android is going to support a different DocumentBuilder
         * implementations, this should be wired here. If we wanted to
         * allow different implementations, these could be distinguished by
         * a special feature (like http://www.org.apache.harmony.com/xml/expat)
         * or by throwing the full SPI monty at it.
         */
        DocumentBuilderImpl builder = new DocumentBuilderImpl();
        builder.setCoalescing(isCoalescing());
        builder.setIgnoreComments(isIgnoringComments());
        builder.setIgnoreElementContentWhitespace(isIgnoringElementContentWhitespace());
        builder.setNamespaceAware(isNamespaceAware());

        // TODO What about expandEntityReferences?

        return builder;
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:23.856 -0500", hash_original_method = "0A4757F3D6B7A1DEAD03596DF47811E0", hash_generated_method = "9C5651C53ABB07401270D50D49C77988")
    
@Override
    public void setAttribute(String name, Object value)
            throws IllegalArgumentException {
        throw new IllegalArgumentException(name);
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:23.858 -0500", hash_original_method = "C59D3A431C1BE604F6A4E910499EE08A", hash_generated_method = "43B3009D588EFE907D35B79A85C8E7BE")
    
@Override
    public void setFeature(String name, boolean value)
            throws ParserConfigurationException {
        if (name == null) {
            throw new NullPointerException();
        }

        if (NAMESPACES.equals(name)) {
            setNamespaceAware(value);
        } else if (VALIDATION.equals(name)) {
            setValidating(value);
        } else {
            throw new ParserConfigurationException(name);
        }
    }
}

