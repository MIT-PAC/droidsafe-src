package org.xml.sax.helpers;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import org.xml.sax.Locator;






public class LocatorImpl implements Locator {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:03.597 -0500", hash_original_field = "A787D4782D28CB658656F9CEA39140B8", hash_generated_field = "8C20C363CB97A5312B8A9E5F182DBDF4")

    // Internal state.
    ////////////////////////////////////////////////////////////////////

    private String publicId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:03.598 -0500", hash_original_field = "EA33D5D9FADC1DE12A306FAB26B3A5DA", hash_generated_field = "D8573F28EF4599A1790219EF1708D9C9")

    private String systemId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:03.599 -0500", hash_original_field = "330B2760AA91CE77EFBAED3976D7655C", hash_generated_field = "09A4698FFE38FA7794A20A1F94A6867E")

    private int lineNumber;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:03.600 -0500", hash_original_field = "F263E7F3EAE507C61D41B748F7D1E575", hash_generated_field = "26A7E6694FD33EFB482AC4BA7726E9A4")

    private int columnNumber;


    /**
     * Zero-argument constructor.
     *
     * <p>This will not normally be useful, since the main purpose
     * of this class is to make a snapshot of an existing Locator.</p>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:03.589 -0500", hash_original_method = "1944A965405A65742195C130B4EA39CD", hash_generated_method = "218A149222E5E1AB758208A2B8FEE7B9")
    public LocatorImpl ()
    {
    }


    /**
     * Copy constructor.
     *
     * <p>Create a persistent copy of the current state of a locator.
     * When the original locator changes, this copy will still keep
     * the original values (and it can be used outside the scope of
     * DocumentHandler methods).</p>
     *
     * @param locator The locator to copy.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:03.590 -0500", hash_original_method = "5648D7E11C6AEEB11BABA800E96BBFD7", hash_generated_method = "CACBF74C8DE1BC7CBF38FE6C57ED7F90")
    public LocatorImpl (Locator locator)
    {
    setPublicId(locator.getPublicId());
    setSystemId(locator.getSystemId());
    setLineNumber(locator.getLineNumber());
    setColumnNumber(locator.getColumnNumber());
    }



    ////////////////////////////////////////////////////////////////////
    // Implementation of org.xml.sax.Locator
    ////////////////////////////////////////////////////////////////////


    /**
     * Return the saved public identifier.
     *
     * @return The public identifier as a string, or null if none
     *         is available.
     * @see org.xml.sax.Locator#getPublicId
     * @see #setPublicId
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:03.590 -0500", hash_original_method = "C19BBE926A67132A1C6BC386100A3E69", hash_generated_method = "C2B64346C205A83C958059FEF62D1E97")
    public String getPublicId ()
    {
    return publicId;
    }


    /**
     * Return the saved system identifier.
     *
     * @return The system identifier as a string, or null if none
     *         is available.
     * @see org.xml.sax.Locator#getSystemId
     * @see #setSystemId
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:03.591 -0500", hash_original_method = "8088708D8DEEE6054468B7FD77400E50", hash_generated_method = "6A03DC8D49FB90AC37FD320CD622E272")
    public String getSystemId ()
    {
    return systemId;
    }


    /**
     * Return the saved line number (1-based).
     *
     * @return The line number as an integer, or -1 if none is available.
     * @see org.xml.sax.Locator#getLineNumber
     * @see #setLineNumber
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:03.592 -0500", hash_original_method = "0B737233CC5342C14C595BEE1A87604B", hash_generated_method = "CF4B4A3CBEDDB2EC6C0EA97DADAE4C2D")
    public int getLineNumber ()
    {
    return lineNumber;
    }


    /**
     * Return the saved column number (1-based).
     *
     * @return The column number as an integer, or -1 if none is available.
     * @see org.xml.sax.Locator#getColumnNumber
     * @see #setColumnNumber
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:03.592 -0500", hash_original_method = "50401770B079F9FC2B373BD150CB3B15", hash_generated_method = "C1A663BB10572B3946B6C09784A7153B")
    public int getColumnNumber ()
    {
    return columnNumber;
    }



    ////////////////////////////////////////////////////////////////////
    // Setters for the properties (not in org.xml.sax.Locator)
    ////////////////////////////////////////////////////////////////////


    /**
     * Set the public identifier for this locator.
     *
     * @param publicId The new public identifier, or null
     *        if none is available.
     * @see #getPublicId
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:03.593 -0500", hash_original_method = "0C418225BFB03C04E3636F3891B47A3E", hash_generated_method = "3A3E52BAAC3045FB9B9AC7B751166BEE")
    public void setPublicId (String publicId)
    {
    this.publicId = publicId;
    }


    /**
     * Set the system identifier for this locator.
     *
     * @param systemId The new system identifier, or null
     *        if none is available.
     * @see #getSystemId
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:03.594 -0500", hash_original_method = "77F5337B905F22D1C71F7C949FEF5117", hash_generated_method = "D9FED68AD30F5F5E327902500C39300D")
    public void setSystemId (String systemId)
    {
    this.systemId = systemId;
    }


    /**
     * Set the line number for this locator (1-based).
     *
     * @param lineNumber The line number, or -1 if none is available.
     * @see #getLineNumber
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:03.596 -0500", hash_original_method = "57105994EF91DD2584057988497ACBF5", hash_generated_method = "6017253C51FF36A7937C0B03247B0C2E")
    public void setLineNumber (int lineNumber)
    {
    this.lineNumber = lineNumber;
    }


    /**
     * Set the column number for this locator (1-based).
     *
     * @param columnNumber The column number, or -1 if none is available.
     * @see #getColumnNumber
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:03.597 -0500", hash_original_method = "4B7308C11003E2EBA4BF69C9D8266B60", hash_generated_method = "063101AB39D8358FEFB7BEEEFF95E9DB")
    public void setColumnNumber (int columnNumber)
    {
    this.columnNumber = columnNumber;
    }

    
}

