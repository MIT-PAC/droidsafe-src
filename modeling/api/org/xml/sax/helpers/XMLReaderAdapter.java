/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package org.xml.sax.helpers;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.util.Locale;

import org.xml.sax.AttributeList;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.DTDHandler;
import org.xml.sax.DocumentHandler;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.Parser;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotSupportedException;
import org.xml.sax.XMLReader;

public class XMLReaderAdapter implements Parser, ContentHandler {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:47.832 -0500", hash_original_field = "44EF69C8F1F45C928EC7CB20788E9F99", hash_generated_field = "EE469AEF45E8094A1D8CC73FFB1E1C99")

    // Internal state.
    ////////////////////////////////////////////////////////////////////

    XMLReader xmlReader;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:47.834 -0500", hash_original_field = "C1D38A44C2BDD7CFC6D4A25FFD145E34", hash_generated_field = "C1D38A44C2BDD7CFC6D4A25FFD145E34")

    DocumentHandler documentHandler;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:47.835 -0500", hash_original_field = "73705B24ED28379A26291F89BCC792AC", hash_generated_field = "73705B24ED28379A26291F89BCC792AC")

    AttributesAdapter qAtts;

    ////////////////////////////////////////////////////////////////////
    // Constructor.
    ////////////////////////////////////////////////////////////////////

    /**
     * Create a new adapter.
     *
     * <p>Use the "org.xml.sax.driver" property to locate the SAX2
     * driver to embed.</p>
     *
     * @exception org.xml.sax.SAXException If the embedded driver
     *            cannot be instantiated or if the
     *            org.xml.sax.driver property is not specified.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:47.782 -0500", hash_original_method = "76BB97F012769A161CBA88EA8A2E4EBA", hash_generated_method = "BF80F476B3ED4C700CD6C964F72A2D1A")
    
public XMLReaderAdapter ()
      throws SAXException
    {
    setup(XMLReaderFactory.createXMLReader());
    }

    /**
     * Create a new adapter.
     *
     * <p>Create a new adapter, wrapped around a SAX2 XMLReader.
     * The adapter will make the XMLReader act like a SAX1
     * Parser.</p>
     *
     * @param xmlReader The SAX2 XMLReader to wrap.
     * @exception java.lang.NullPointerException If the argument is null.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:47.784 -0500", hash_original_method = "8B041FBF651D4DFB0C8BE59922C68E87", hash_generated_method = "70E3A2AE9C28BAEAD11A6A6328DB424F")
    
public XMLReaderAdapter (XMLReader xmlReader)
    {
    setup(xmlReader);
    }

    /**
     * Internal setup.
     *
     * @param xmlReader The embedded XMLReader.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:47.786 -0500", hash_original_method = "E177ACAABE14FBF113725220BFCC127D", hash_generated_method = "9375E1E7CD4678C1EA0E6E2176C05E19")
    
private void setup (XMLReader xmlReader)
    {
    if (xmlReader == null) {
        throw new NullPointerException("XMLReader must not be null");
    }
    this.xmlReader = xmlReader;
    qAtts = new AttributesAdapter();
    }

    ////////////////////////////////////////////////////////////////////
    // Implementation of org.xml.sax.Parser.
    ////////////////////////////////////////////////////////////////////

    /**
     * Set the locale for error reporting.
     *
     * <p>This is not supported in SAX2, and will always throw
     * an exception.</p>
     *
     * @param locale the locale for error reporting.
     * @see org.xml.sax.Parser#setLocale
     * @exception org.xml.sax.SAXException Thrown unless overridden.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:47.789 -0500", hash_original_method = "6F3F2251FC8DF5A2BC76DADBD382AD55", hash_generated_method = "B80CB1626D72D2082ACD2E8D89187B51")
    
public void setLocale (Locale locale)
    throws SAXException
    {
    throw new SAXNotSupportedException("setLocale not supported");
    }

    /**
     * Register the entity resolver.
     *
     * @param resolver The new resolver.
     * @see org.xml.sax.Parser#setEntityResolver
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:47.792 -0500", hash_original_method = "4AE4FF8425B7CD5477DB299D2E768007", hash_generated_method = "98CCCBCA84BC7EA0683562AAD57B36BB")
    
public void setEntityResolver (EntityResolver resolver)
    {
    xmlReader.setEntityResolver(resolver);
    }

    /**
     * Register the DTD event handler.
     *
     * @param handler The new DTD event handler.
     * @see org.xml.sax.Parser#setDTDHandler
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:47.794 -0500", hash_original_method = "88C10864FC45C96400C579FA2D97330E", hash_generated_method = "4ED17EFEA6B3CF324653645D6587A280")
    
public void setDTDHandler (DTDHandler handler)
    {
    xmlReader.setDTDHandler(handler);
    }

    /**
     * Register the SAX1 document event handler.
     *
     * <p>Note that the SAX1 document handler has no Namespace
     * support.</p>
     *
     * @param handler The new SAX1 document event handler.
     * @see org.xml.sax.Parser#setDocumentHandler
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:47.796 -0500", hash_original_method = "066AA0855CEAF16F5A4DD1498A9898AE", hash_generated_method = "961CFEDB55C2CC641C505A6666C86C86")
    
public void setDocumentHandler (DocumentHandler handler)
    {
    documentHandler = handler;
    }

    /**
     * Register the error event handler.
     *
     * @param handler The new error event handler.
     * @see org.xml.sax.Parser#setErrorHandler
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:47.798 -0500", hash_original_method = "72DE679535A20097297B12B846F37162", hash_generated_method = "08C34F58B21BC4A94ABF5B95A26DB367")
    
public void setErrorHandler (ErrorHandler handler)
    {
    xmlReader.setErrorHandler(handler);
    }

    /**
     * Parse the document.
     *
     * <p>This method will throw an exception if the embedded
     * XMLReader does not support the
     * http://xml.org/sax/features/namespace-prefixes property.</p>
     *
     * @param systemId The absolute URL of the document.
     * @exception java.io.IOException If there is a problem reading
     *            the raw content of the document.
     * @exception org.xml.sax.SAXException If there is a problem
     *            processing the document.
     * @see #parse(org.xml.sax.InputSource)
     * @see org.xml.sax.Parser#parse(java.lang.String)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:47.800 -0500", hash_original_method = "8AE6DA2951569D3F1B1B45FDE2C61B3C", hash_generated_method = "10CE462B07C3B7D01E1AC1F092312A2E")
    
public void parse (String systemId)
    throws IOException, SAXException
    {
    parse(new InputSource(systemId));
    }

    /**
     * Parse the document.
     *
     * <p>This method will throw an exception if the embedded
     * XMLReader does not support the
     * http://xml.org/sax/features/namespace-prefixes property.</p>
     *
     * @param input An input source for the document.
     * @exception java.io.IOException If there is a problem reading
     *            the raw content of the document.
     * @exception org.xml.sax.SAXException If there is a problem
     *            processing the document.
     * @see #parse(java.lang.String)
     * @see org.xml.sax.Parser#parse(org.xml.sax.InputSource)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:47.803 -0500", hash_original_method = "16241BDA797C9EF94AA818BE003DDED6", hash_generated_method = "3627C606FA3390E7AA5A9AC834E74418")
    
public void parse (InputSource input)
    throws IOException, SAXException
    {
    setupXMLReader();
    xmlReader.parse(input);
    }

    /**
     * Set up the XML reader.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:47.805 -0500", hash_original_method = "5328954AF535C9E1B60D1AC7D659B95D", hash_generated_method = "C9DB14B53DE5EF391D38012A46FACC0F")
    
private void setupXMLReader ()
    throws SAXException
    {
    xmlReader.setFeature("http://xml.org/sax/features/namespace-prefixes", true);
    try {
        xmlReader.setFeature("http://xml.org/sax/features/namespaces",
                             false);
    } catch (SAXException e) {
        // NO OP: it's just extra information, and we can ignore it
    }
    xmlReader.setContentHandler(this);
    }

    ////////////////////////////////////////////////////////////////////
    // Implementation of org.xml.sax.ContentHandler.
    ////////////////////////////////////////////////////////////////////

    /**
     * Set a document locator.
     *
     * @param locator The document locator.
     * @see org.xml.sax.ContentHandler#setDocumentLocator
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:47.807 -0500", hash_original_method = "3CAE4C302EA4B3C24003E67187B52764", hash_generated_method = "EF09D07DA408392F58589BF66114B0C7")
    
public void setDocumentLocator (Locator locator)
    {
    if (documentHandler != null)
        documentHandler.setDocumentLocator(locator);
    }

    /**
     * Start document event.
     *
     * @exception org.xml.sax.SAXException The client may raise a
     *            processing exception.
     * @see org.xml.sax.ContentHandler#startDocument
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:47.809 -0500", hash_original_method = "32BB697A91610539031004A9D01C7415", hash_generated_method = "C20887799A1024B2412D6C97883B5DAB")
    
public void startDocument ()
    throws SAXException
    {
    if (documentHandler != null)
        documentHandler.startDocument();
    }

    /**
     * End document event.
     *
     * @exception org.xml.sax.SAXException The client may raise a
     *            processing exception.
     * @see org.xml.sax.ContentHandler#endDocument
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:47.812 -0500", hash_original_method = "1ABAE35BE3091AD40FC1FECAC80B863E", hash_generated_method = "C52168ADADDB15DD7003C2A37BAF0E3A")
    
public void endDocument ()
    throws SAXException
    {
    if (documentHandler != null)
        documentHandler.endDocument();
    }

    /**
     * Adapt a SAX2 start prefix mapping event.
     *
     * @param prefix The prefix being mapped.
     * @param uri The Namespace URI being mapped to.
     * @see org.xml.sax.ContentHandler#startPrefixMapping
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:47.814 -0500", hash_original_method = "A4FE8368A0813DB39B9B2D62745BDC50", hash_generated_method = "DF27E5998B6B64FB82406DFB9FBD4191")
    
public void startPrefixMapping (String prefix, String uri)
    {
    }

    /**
     * Adapt a SAX2 end prefix mapping event.
     *
     * @param prefix The prefix being mapped.
     * @see org.xml.sax.ContentHandler#endPrefixMapping
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:47.816 -0500", hash_original_method = "6288457D9104DBA73FF5F77796A5069B", hash_generated_method = "50F86F11A46B0DDB6F874046094C4D23")
    
public void endPrefixMapping (String prefix)
    {
    }

    /**
     * Adapt a SAX2 start element event.
     *
     * @param uri The Namespace URI.
     * @param localName The Namespace local name.
     * @param qName The qualified (prefixed) name.
     * @param atts The SAX2 attributes.
     * @exception org.xml.sax.SAXException The client may raise a
     *            processing exception.
     * @see org.xml.sax.ContentHandler#endDocument
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:47.818 -0500", hash_original_method = "19EEF6F7A6D3ECB16FB052F6607F9998", hash_generated_method = "012BF5070EC1B7DEF02B1136BB9913B4")
    
public void startElement (String uri, String localName,
                  String qName, Attributes atts)
    throws SAXException
    {
    if (documentHandler != null) {
        qAtts.setAttributes(atts);
        documentHandler.startElement(qName, qAtts);
    }
    }

    /**
     * Adapt a SAX2 end element event.
     *
     * @param uri The Namespace URI.
     * @param localName The Namespace local name.
     * @param qName The qualified (prefixed) name.
     * @exception org.xml.sax.SAXException The client may raise a
     *            processing exception.
     * @see org.xml.sax.ContentHandler#endElement
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:47.820 -0500", hash_original_method = "931F7A2FD2648B2A1C28EDF8D67E709D", hash_generated_method = "118C5D145E944EE3252D65136444C4AC")
    
public void endElement (String uri, String localName,
                String qName)
    throws SAXException
    {
    if (documentHandler != null)
        documentHandler.endElement(qName);
    }

    /**
     * Adapt a SAX2 characters event.
     *
     * @param ch An array of characters.
     * @param start The starting position in the array.
     * @param length The number of characters to use.
     * @exception org.xml.sax.SAXException The client may raise a
     *            processing exception.
     * @see org.xml.sax.ContentHandler#characters
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:47.823 -0500", hash_original_method = "1F709B7946BD47BE5374DFAB95B97284", hash_generated_method = "F9E1A00D9D612614A81E70ADE7A2A25C")
    
public void characters (char ch[], int start, int length)
    throws SAXException
    {
    if (documentHandler != null)
        documentHandler.characters(ch, start, length);
    }

    /**
     * Adapt a SAX2 ignorable whitespace event.
     *
     * @param ch An array of characters.
     * @param start The starting position in the array.
     * @param length The number of characters to use.
     * @exception org.xml.sax.SAXException The client may raise a
     *            processing exception.
     * @see org.xml.sax.ContentHandler#ignorableWhitespace
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:47.825 -0500", hash_original_method = "8F77A2CC8A8F4FEA0C562F269098A504", hash_generated_method = "6F9397923729EA05DF2FDDC904142520")
    
public void ignorableWhitespace (char ch[], int start, int length)
    throws SAXException
    {
    if (documentHandler != null)
        documentHandler.ignorableWhitespace(ch, start, length);
    }

    /**
     * Adapt a SAX2 processing instruction event.
     *
     * @param target The processing instruction target.
     * @param data The remainder of the processing instruction
     * @exception org.xml.sax.SAXException The client may raise a
     *            processing exception.
     * @see org.xml.sax.ContentHandler#processingInstruction
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:47.828 -0500", hash_original_method = "01B4469A7119F79BBDA4CF4D6616EEC2", hash_generated_method = "C70CBD95926A226F6C9CF5E1BEC7E5B3")
    
public void processingInstruction (String target, String data)
    throws SAXException
    {
    if (documentHandler != null)
        documentHandler.processingInstruction(target, data);
    }

    /**
     * Adapt a SAX2 skipped entity event.
     *
     * @param name The name of the skipped entity.
     * @see org.xml.sax.ContentHandler#skippedEntity
     * @exception org.xml.sax.SAXException Throwable by subclasses.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:47.830 -0500", hash_original_method = "1616136BE44E483876717F8A446FD8E6", hash_generated_method = "A990924CA217DA9AB88497E28F935EE3")
    
public void skippedEntity (String name)
    throws SAXException
    {
    }
    
    static final class AttributesAdapter implements AttributeList {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:47.858 -0500", hash_original_field = "14CC0F9D3F04FE972837D6018D833138", hash_generated_field = "B58329F5904269DD97B6B42BAA3B838E")

    private Attributes attributes;
    @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:47.838 -0500", hash_original_method = "E50C9A4E371E1BB1DB8AD3C2D41905DA", hash_generated_method = "E50C9A4E371E1BB1DB8AD3C2D41905DA")
        
AttributesAdapter ()
    {
    }

    /**
     * Set the embedded Attributes object.
     *
     * @param The embedded SAX2 Attributes.
     */
    @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:47.841 -0500", hash_original_method = "53FC4E3BB2217D6659CB21AA159A3250", hash_generated_method = "53FC4E3BB2217D6659CB21AA159A3250")
        
void setAttributes (Attributes attributes)
    {
        this.attributes = attributes;
    }

    /**
     * Return the number of attributes.
     *
     * @return The length of the attribute list.
     * @see org.xml.sax.AttributeList#getLength
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:47.843 -0500", hash_original_method = "91D9ED6BC44066DC74ACDFE2397CD717", hash_generated_method = "B7FC2F744134FC098C6833B3AB745676")
        
public int getLength ()
    {
        return attributes.getLength();
    }

    /**
     * Return the qualified (prefixed) name of an attribute by position.
     *
     * @return The qualified name.
     * @see org.xml.sax.AttributeList#getName
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:47.846 -0500", hash_original_method = "ED147CDF790A0CCB36C14BED3C6421FF", hash_generated_method = "6C4EBDE39A1B7BFA91DF750F32FCD2C2")
        
public String getName (int i)
    {
        return attributes.getQName(i);
    }

    /**
     * Return the type of an attribute by position.
     *
     * @return The type.
     * @see org.xml.sax.AttributeList#getType(int)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:47.848 -0500", hash_original_method = "CD7B0B2A6AEED3EE82C9A05E49CD2219", hash_generated_method = "74C8EC2E02CD1ADDC16FACFB066810C9")
        
public String getType (int i)
    {
        return attributes.getType(i);
    }

    /**
     * Return the value of an attribute by position.
     *
     * @return The value.
     * @see org.xml.sax.AttributeList#getValue(int)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:47.851 -0500", hash_original_method = "985A31734C2AABCE7CE9E7B351282D4B", hash_generated_method = "2D081E5F44B1B1B52BF4663224A0B053")
        
public String getValue (int i)
    {
        return attributes.getValue(i);
    }

    /**
     * Return the type of an attribute by qualified (prefixed) name.
     *
     * @return The type.
     * @see org.xml.sax.AttributeList#getType(java.lang.String)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:47.853 -0500", hash_original_method = "8A6442FB647EA21090E4FC03D1B47FA4", hash_generated_method = "CEF56911A88E01E816CF3E7EB77A8062")
        
public String getType (String qName)
    {
        return attributes.getType(qName);
    }

    /**
     * Return the value of an attribute by qualified (prefixed) name.
     *
     * @return The value.
     * @see org.xml.sax.AttributeList#getValue(java.lang.String)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:47.855 -0500", hash_original_method = "4A5F2D731504040B76231CFBA75E49A7", hash_generated_method = "7F28E10AA50BDAC2215E86E78E3F2520")
        
public String getValue (String qName)
    {
        return attributes.getValue(qName);
    }
        
    }
    
}

