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


package org.xml.sax;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.InputStream;
import java.io.Reader;

public class InputSource {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:47.646 -0500", hash_original_field = "A787D4782D28CB658656F9CEA39140B8", hash_generated_field = "8C20C363CB97A5312B8A9E5F182DBDF4")

    // Internal state.
    ////////////////////////////////////////////////////////////////////

    private String publicId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:47.648 -0500", hash_original_field = "EA33D5D9FADC1DE12A306FAB26B3A5DA", hash_generated_field = "D8573F28EF4599A1790219EF1708D9C9")

    private String systemId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:47.650 -0500", hash_original_field = "BA38C079FA1F85CB3FDFDA791B5E38AF", hash_generated_field = "F48D8933D1E0CC3DCA366E513A5A0250")

    private InputStream byteStream;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:47.652 -0500", hash_original_field = "C7941A2E59CC2DF1A97D47295C728725", hash_generated_field = "AA03A19AA54A465901EEA798BB232EAE")

    private String encoding;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:47.655 -0500", hash_original_field = "C80288420C0FBFA7028519B6A3C8A163", hash_generated_field = "063FD46ACCBF055B33EB5A7725463DCE")

    private Reader characterStream;

    /**
     * Zero-argument default constructor.
     *
     * @see #setPublicId
     * @see #setSystemId
     * @see #setByteStream
     * @see #setCharacterStream
     * @see #setEncoding
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:47.614 -0500", hash_original_method = "ECF04DED512C86950B6E52F582DBB4DE", hash_generated_method = "217A98420DCE906E732B6983D19C2476")
    
public InputSource ()
    {
    }

    /**
     * Create a new input source with a system identifier.
     *
     * <p>Applications may use setPublicId to include a
     * public identifier as well, or setEncoding to specify
     * the character encoding, if known.</p>
     *
     * <p>If the system identifier is a URL, it must be fully
     * resolved (it may not be a relative URL).</p>
     *
     * @param systemId The system identifier (URI).
     * @see #setPublicId
     * @see #setSystemId
     * @see #setByteStream
     * @see #setEncoding
     * @see #setCharacterStream
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:47.616 -0500", hash_original_method = "7919F547FCB87899F58CF069384E6AAD", hash_generated_method = "D1835C4469F5A6537AB5B42A8D63DDEC")
    
public InputSource (String systemId)
    {
    setSystemId(systemId);
    }

    /**
     * Create a new input source with a byte stream.
     *
     * <p>Application writers should use setSystemId() to provide a base
     * for resolving relative URIs, may use setPublicId to include a
     * public identifier, and may use setEncoding to specify the object's
     * character encoding.</p>
     *
     * @param byteStream The raw byte stream containing the document.
     * @see #setPublicId
     * @see #setSystemId
     * @see #setEncoding
     * @see #setByteStream
     * @see #setCharacterStream
     */
    @DSComment("parameter is from IO")
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:47.619 -0500", hash_original_method = "7C3B72CDCF95023F438211CC038E601E", hash_generated_method = "B633A9743DD0CC7151290BD357306BDA")
    
public InputSource (InputStream byteStream)
    {
    setByteStream(byteStream);
    }

    /**
     * Create a new input source with a character stream.
     *
     * <p>Application writers should use setSystemId() to provide a base
     * for resolving relative URIs, and may use setPublicId to include a
     * public identifier.</p>
     *
     * <p>The character stream shall not include a byte order mark.</p>
     *
     * @param characterStream The raw character stream containing the document.
     * @see #setPublicId
     * @see #setSystemId
     * @see #setByteStream
     * @see #setCharacterStream
     */
    @DSComment("parameter is from IO")
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:47.621 -0500", hash_original_method = "F589E4069755916CEDC29D447D78E1F5", hash_generated_method = "00DC1AEE141141E3911D24487E76D6D2")
    
public InputSource (Reader characterStream)
    {
    setCharacterStream(characterStream);
    }

    /**
     * Set the public identifier for this input source.
     *
     * <p>The public identifier is always optional: if the application
     * writer includes one, it will be provided as part of the
     * location information.</p>
     *
     * @param publicId The public identifier as a string.
     * @see #getPublicId
     * @see org.xml.sax.Locator#getPublicId
     * @see org.xml.sax.SAXParseException#getPublicId
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:47.623 -0500", hash_original_method = "0C418225BFB03C04E3636F3891B47A3E", hash_generated_method = "3A3E52BAAC3045FB9B9AC7B751166BEE")
    
public void setPublicId (String publicId)
    {
    this.publicId = publicId;
    }

    /**
     * Get the public identifier for this input source.
     *
     * @return The public identifier, or null if none was supplied.
     * @see #setPublicId
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:47.625 -0500", hash_original_method = "C19BBE926A67132A1C6BC386100A3E69", hash_generated_method = "C2B64346C205A83C958059FEF62D1E97")
    
public String getPublicId ()
    {
    return publicId;
    }

    /**
     * Set the system identifier for this input source.
     *
     * <p>The system identifier is optional if there is a byte stream
     * or a character stream, but it is still useful to provide one,
     * since the application can use it to resolve relative URIs
     * and can include it in error messages and warnings (the parser
     * will attempt to open a connection to the URI only if
     * there is no byte stream or character stream specified).</p>
     *
     * <p>If the application knows the character encoding of the
     * object pointed to by the system identifier, it can register
     * the encoding using the setEncoding method.</p>
     *
     * <p>If the system identifier is a URL, it must be fully
     * resolved (it may not be a relative URL).</p>
     *
     * @param systemId The system identifier as a string.
     * @see #setEncoding
     * @see #getSystemId
     * @see org.xml.sax.Locator#getSystemId
     * @see org.xml.sax.SAXParseException#getSystemId
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:47.627 -0500", hash_original_method = "77F5337B905F22D1C71F7C949FEF5117", hash_generated_method = "D9FED68AD30F5F5E327902500C39300D")
    
public void setSystemId (String systemId)
    {
    this.systemId = systemId;
    }

    /**
     * Get the system identifier for this input source.
     *
     * <p>The getEncoding method will return the character encoding
     * of the object pointed to, or null if unknown.</p>
     *
     * <p>If the system ID is a URL, it will be fully resolved.</p>
     *
     * @return The system identifier, or null if none was supplied.
     * @see #setSystemId
     * @see #getEncoding
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:47.630 -0500", hash_original_method = "8088708D8DEEE6054468B7FD77400E50", hash_generated_method = "6A03DC8D49FB90AC37FD320CD622E272")
    
public String getSystemId ()
    {
    return systemId;
    }

    /**
     * Set the byte stream for this input source.
     *
     * <p>The SAX parser will ignore this if there is also a character
     * stream specified, but it will use a byte stream in preference
     * to opening a URI connection itself.</p>
     *
     * <p>If the application knows the character encoding of the
     * byte stream, it should set it with the setEncoding method.</p>
     *
     * @param byteStream A byte stream containing an XML document or
     *        other entity.
     * @see #setEncoding
     * @see #getByteStream
     * @see #getEncoding
     * @see java.io.InputStream
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:47.632 -0500", hash_original_method = "E15E53FA80250CBE7F24584A185B9018", hash_generated_method = "7170255CE17CFBCBB0C9C68C57B03FC2")
    
public void setByteStream (InputStream byteStream)
    {
    this.byteStream = byteStream;
    }

    /**
     * Get the byte stream for this input source.
     *
     * <p>The getEncoding method will return the character
     * encoding for this byte stream, or null if unknown.</p>
     *
     * @return The byte stream, or null if none was supplied.
     * @see #getEncoding
     * @see #setByteStream
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:47.635 -0500", hash_original_method = "831A861201E96F794D74C2B24BAB3555", hash_generated_method = "76EC79038C4C277B48D1CB1A365564C4")
    
public InputStream getByteStream ()
    {
    return byteStream;
    }

    /**
     * Set the character encoding, if known.
     *
     * <p>The encoding must be a string acceptable for an
     * XML encoding declaration (see section 4.3.3 of the XML 1.0
     * recommendation).</p>
     *
     * <p>This method has no effect when the application provides a
     * character stream.</p>
     *
     * @param encoding A string describing the character encoding.
     * @see #setSystemId
     * @see #setByteStream
     * @see #getEncoding
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:47.637 -0500", hash_original_method = "109F4EE072FF4A68A1B686347AFE92DB", hash_generated_method = "F16BDC16289B2D2161EBDE6B982650A4")
    
public void setEncoding (String encoding)
    {
    this.encoding = encoding;
    }

    /**
     * Get the character encoding for a byte stream or URI.
     * This value will be ignored when the application provides a
     * character stream.
     *
     * @return The encoding, or null if none was supplied.
     * @see #setByteStream
     * @see #getSystemId
     * @see #getByteStream
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:47.639 -0500", hash_original_method = "ECC6E581C26F132636CDCE9C9A5E5807", hash_generated_method = "AB48E45DF4593246DCA3A0BE40153818")
    
public String getEncoding ()
    {
    return encoding;
    }

    /**
     * Set the character stream for this input source.
     *
     * <p>If there is a character stream specified, the SAX parser
     * will ignore any byte stream and will not attempt to open
     * a URI connection to the system identifier.</p>
     *
     * @param characterStream The character stream containing the
     *        XML document or other entity.
     * @see #getCharacterStream
     * @see java.io.Reader
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:47.641 -0500", hash_original_method = "079C1AFEC48E7E3C6462740060167438", hash_generated_method = "3E62366D6D0369BEB314A23F18365986")
    
public void setCharacterStream (Reader characterStream)
    {
    this.characterStream = characterStream;
    }

    /**
     * Get the character stream for this input source.
     *
     * @return The character stream, or null if none was supplied.
     * @see #setCharacterStream
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:47.644 -0500", hash_original_method = "420D22C3C623A59BA758E1AC6387B142", hash_generated_method = "EBA0998A74E28C27CEDA0CDD239F6CC3")
    
public Reader getCharacterStream ()
    {
    return characterStream;
    }
    
}

