package org.xml.sax;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class SAXParseException extends SAXException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:49.712 -0500", hash_original_field = "A787D4782D28CB658656F9CEA39140B8", hash_generated_field = "9DD9CD005E725BEEDBF254E32B2B5068")

    // Internal state.
    //////////////////////////////////////////////////////////////////////

    /**
     * @serial The public identifier, or null.
     * @see #getPublicId
     */
    private String publicId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:49.714 -0500", hash_original_field = "EA33D5D9FADC1DE12A306FAB26B3A5DA", hash_generated_field = "D8573F28EF4599A1790219EF1708D9C9")

    private String systemId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:49.716 -0500", hash_original_field = "330B2760AA91CE77EFBAED3976D7655C", hash_generated_field = "09A4698FFE38FA7794A20A1F94A6867E")

    private int lineNumber;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:49.719 -0500", hash_original_field = "F263E7F3EAE507C61D41B748F7D1E575", hash_generated_field = "26A7E6694FD33EFB482AC4BA7726E9A4")

    private int columnNumber;
    
    //////////////////////////////////////////////////////////////////////
    // Constructors.
    //////////////////////////////////////////////////////////////////////

    /**
     * Create a new SAXParseException from a message and a Locator.
     *
     * <p>This constructor is especially useful when an application is
     * creating its own exception from within a {@link org.xml.sax.ContentHandler
     * ContentHandler} callback.</p>
     *
     * @param message The error or warning message.
     * @param locator The locator object for the error or warning (may be
     *        null).
     * @see org.xml.sax.Locator
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:49.689 -0500", hash_original_method = "91659A5F6A3DDFF6C0F2D77A2F2D10D9", hash_generated_method = "B1F153522D8C52DED56C97219F498E42")
    
public SAXParseException (String message, Locator locator) {
    super(message);
    if (locator != null) {
        init(locator.getPublicId(), locator.getSystemId(),
         locator.getLineNumber(), locator.getColumnNumber());
    } else {
        init(null, null, -1, -1);
    }
    }

    /**
     * Wrap an existing exception in a SAXParseException.
     *
     * <p>This constructor is especially useful when an application is
     * creating its own exception from within a {@link org.xml.sax.ContentHandler
     * ContentHandler} callback, and needs to wrap an existing exception that is not a
     * subclass of {@link org.xml.sax.SAXException SAXException}.</p>
     *
     * @param message The error or warning message, or null to
     *                use the message from the embedded exception.
     * @param locator The locator object for the error or warning (may be
     *        null).
     * @param e Any exception.
     * @see org.xml.sax.Locator
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:49.692 -0500", hash_original_method = "7445111C75F88435899093DB45466FBB", hash_generated_method = "AF8F7FDECF73C1CBD8B8B1E038D88CC8")
    
public SAXParseException (String message, Locator locator,
                  Exception e) {
    super(message, e);
    if (locator != null) {
        init(locator.getPublicId(), locator.getSystemId(),
         locator.getLineNumber(), locator.getColumnNumber());
    } else {
        init(null, null, -1, -1);
    }
    }

    /**
     * Create a new SAXParseException.
     *
     * <p>This constructor is most useful for parser writers.</p>
     *
     * <p>All parameters except the message are as if
     * they were provided by a {@link Locator}.  For example, if the
     * system identifier is a URL (including relative filename), the
     * caller must resolve it fully before creating the exception.</p>
     *
     *
     * @param message The error or warning message.
     * @param publicId The public identifier of the entity that generated
     *                 the error or warning.
     * @param systemId The system identifier of the entity that generated
     *                 the error or warning.
     * @param lineNumber The line number of the end of the text that
     *                   caused the error or warning.
     * @param columnNumber The column number of the end of the text that
     *                     cause the error or warning.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:49.695 -0500", hash_original_method = "F6A205656E7433FA991BA49A47A0113E", hash_generated_method = "A443696662FA85E4251638A4BC83F847")
    
public SAXParseException (String message, String publicId, String systemId,
                  int lineNumber, int columnNumber)
    {
    super(message);
    init(publicId, systemId, lineNumber, columnNumber);
    }

    /**
     * Create a new SAXParseException with an embedded exception.
     *
     * <p>This constructor is most useful for parser writers who
     * need to wrap an exception that is not a subclass of
     * {@link org.xml.sax.SAXException SAXException}.</p>
     *
     * <p>All parameters except the message and exception are as if
     * they were provided by a {@link Locator}.  For example, if the
     * system identifier is a URL (including relative filename), the
     * caller must resolve it fully before creating the exception.</p>
     *
     * @param message The error or warning message, or null to use
     *                the message from the embedded exception.
     * @param publicId The public identifier of the entity that generated
     *                 the error or warning.
     * @param systemId The system identifier of the entity that generated
     *                 the error or warning.
     * @param lineNumber The line number of the end of the text that
     *                   caused the error or warning.
     * @param columnNumber The column number of the end of the text that
     *                     cause the error or warning.
     * @param e Another exception to embed in this one.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:49.698 -0500", hash_original_method = "7C92F995098676855E75CD731C6CE956", hash_generated_method = "3A4BA0E00B81418F92B54DE11B0C2AE9")
    
public SAXParseException (String message, String publicId, String systemId,
                  int lineNumber, int columnNumber, Exception e)
    {
    super(message, e);
    init(publicId, systemId, lineNumber, columnNumber);
    }

    /**
     * Internal initialization method.
     *
     * @param publicId The public identifier of the entity which generated the exception,
     *        or null.
     * @param systemId The system identifier of the entity which generated the exception,
     *        or null.
     * @param lineNumber The line number of the error, or -1.
     * @param columnNumber The column number of the error, or -1.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:49.701 -0500", hash_original_method = "CF8913A55801AA3E419E95D1888FBD68", hash_generated_method = "410715A9FAC9A509EFEB2FA43EFA347B")
    
private void init (String publicId, String systemId,
               int lineNumber, int columnNumber)
    {
    this.publicId = publicId;
    this.systemId = systemId;
    this.lineNumber = lineNumber;
    this.columnNumber = columnNumber;
    }

    /**
     * Get the public identifier of the entity where the exception occurred.
     *
     * @return A string containing the public identifier, or null
     *         if none is available.
     * @see org.xml.sax.Locator#getPublicId
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:49.703 -0500", hash_original_method = "651ECBF976325F0553967BB40DF656D7", hash_generated_method = "93CEEA8F06811EE984FFEB8045EEB99E")
    
public String getPublicId ()
    {
    return this.publicId;
    }

    /**
     * Get the system identifier of the entity where the exception occurred.
     *
     * <p>If the system identifier is a URL, it will have been resolved
     * fully.</p>
     *
     * @return A string containing the system identifier, or null
     *         if none is available.
     * @see org.xml.sax.Locator#getSystemId
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:49.705 -0500", hash_original_method = "600C253C44A23EDB0A978A11FA5F90C2", hash_generated_method = "665B4042BCE9D5C07F91DFF6CDCAB816")
    
public String getSystemId ()
    {
    return this.systemId;
    }

    /**
     * The line number of the end of the text where the exception occurred.
     *
     * <p>The first line is line 1.</p>
     *
     * @return An integer representing the line number, or -1
     *         if none is available.
     * @see org.xml.sax.Locator#getLineNumber
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:49.707 -0500", hash_original_method = "1D6EF9406E829BF96953F811A8A7C017", hash_generated_method = "C5B2B0FEC1C110E78B13FD01138817F0")
    
public int getLineNumber ()
    {
    return this.lineNumber;
    }

    /**
     * The column number of the end of the text where the exception occurred.
     *
     * <p>The first column in a line is position 1.</p>
     *
     * @return An integer representing the column number, or -1
     *         if none is available.
     * @see org.xml.sax.Locator#getColumnNumber
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:49.709 -0500", hash_original_method = "0DEBF9F56751828220A5A7801C031403", hash_generated_method = "1ADEC4DF9A60350C6C9CDE6811890075")
    
public int getColumnNumber ()
    {
    return this.columnNumber;
    }
    
}

