package javax.xml.transform.stream;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.File;
import java.io.OutputStream;
import java.io.Writer;

import javax.xml.transform.Result;

public class StreamResult implements Result {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:00.122 -0500", hash_original_field = "854AAE683B90ED7486002A8649A4844B", hash_generated_field = "07B41A84AEB1C38AEE0632EF7AA4850C")

    public static final String FEATURE =
        "http://javax.xml.transform.stream.StreamResult/feature";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:00.153 -0500", hash_original_field = "EA33D5D9FADC1DE12A306FAB26B3A5DA", hash_generated_field = "A7FC921049A8404661C066AE44CBE100")

    // Internal state.
    //////////////////////////////////////////////////////////////////////

    /**
     * The systemID that may be used in association
     * with the byte or character stream, or, if neither is set, use
     * this value as a writeable URI (probably a file name).
     */
    private String systemId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:00.156 -0500", hash_original_field = "661AC26F0CF33AB40D90D727DEB87E17", hash_generated_field = "765C7DA707EC84D85188E77508C6D245")

    private OutputStream outputStream;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:00.158 -0500", hash_original_field = "2893095D821727F8868345026D6906A1", hash_generated_field = "DB075F4140D7FA00980C54A40F997F59")

    private Writer writer;

    /**
     * Zero-argument default constructor.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:00.125 -0500", hash_original_method = "C19C2736EBF8CAB01BA3786E202D7316", hash_generated_method = "C62C7E08EF665E676AD2CE92B8B97F31")
    
public StreamResult() {
    }

    /**
     * Construct a StreamResult from a byte stream.  Normally,
     * a stream should be used rather than a reader, so that
     * the transformer may use instructions contained in the
     * transformation instructions to control the encoding.
     *
     * @param outputStream A valid OutputStream reference.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:00.127 -0500", hash_original_method = "44ABD7B5C901E57BDC7AEA5540DA591C", hash_generated_method = "90E2E048EB317FFAF4C1EAD650590D36")
    
public StreamResult(OutputStream outputStream) {
        setOutputStream(outputStream);
    }

    /**
     * Construct a StreamResult from a character stream.  Normally,
     * a stream should be used rather than a reader, so that
     * the transformer may use instructions contained in the
     * transformation instructions to control the encoding.  However,
     * there are times when it is useful to write to a character
     * stream, such as when using a StringWriter.
     *
     * @param writer  A valid Writer reference.
     */
    @DSComment("input is io writer")
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:00.130 -0500", hash_original_method = "4C7FF3D19CAA5E8142F763BAEAB400A6", hash_generated_method = "0B6B9AC28E672B3BF921A643134A2BD5")
    
public StreamResult(Writer writer) {
        setWriter(writer);
    }

    /**
     * Construct a StreamResult from a URL.
     *
     * @param systemId Must be a String that conforms to the URI syntax.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:00.132 -0500", hash_original_method = "CE70A50578573A39D0EE1A321E1352B9", hash_generated_method = "4ACBB08C16048E4D345988848A8BFF02")
    
public StreamResult(String systemId) {
        this.systemId = systemId;
    }

    /**
     * Construct a StreamResult from a File.
     *
     * @param f Must a non-null File reference.
     */
    @DSComment("input is file object")
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:00.135 -0500", hash_original_method = "69C6A757CEF52150252713CD9ECC25FB", hash_generated_method = "854C7AC00FFB6637A4C3AEB25C9A248D")
    
public StreamResult(File f) {
        setSystemId(f);
    }

    /**
     * Set the ByteStream that is to be written to.  Normally,
     * a stream should be used rather than a reader, so that
     * the transformer may use instructions contained in the
     * transformation instructions to control the encoding.
     *
     * @param outputStream A valid OutputStream reference.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:00.137 -0500", hash_original_method = "817A5A0ADE99B2865B232C517A9FCF0D", hash_generated_method = "3E7E4DF6D86E17FA87D7D853D8601DEF")
    
public void setOutputStream(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    /**
     * Get the byte stream that was set with setOutputStream.
     *
     * @return The byte stream that was set with setOutputStream, or null
     * if setOutputStream or the ByteStream constructor was not called.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:00.139 -0500", hash_original_method = "05E68097FF3105B2AAABD34E89C7728F", hash_generated_method = "16BC3475A551A12F30701B7E4ECEB25C")
    
public OutputStream getOutputStream() {
        return outputStream;
    }

    /**
     * Set the writer that is to receive the result.  Normally,
     * a stream should be used rather than a writer, so that
     * the transformer may use instructions contained in the
     * transformation instructions to control the encoding.  However,
     * there are times when it is useful to write to a writer,
     * such as when using a StringWriter.
     *
     * @param writer  A valid Writer reference.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:00.142 -0500", hash_original_method = "5911383E76829BA237C0C98FFA879183", hash_generated_method = "6B008385E376357B634194BC74C8DB77")
    
public void setWriter(Writer writer) {
        this.writer = writer;
    }

    /**
     * Get the character stream that was set with setWriter.
     *
     * @return The character stream that was set with setWriter, or null
     * if setWriter or the Writer constructor was not called.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:00.144 -0500", hash_original_method = "F0F74844AEEC9ABE14D7628D5DF26AE9", hash_generated_method = "17E3D143A81FA83DC99B0AF4B9278D54")
    
public Writer getWriter() {
        return writer;
    }

    /**
     * Set the systemID that may be used in association
     * with the byte or character stream, or, if neither is set, use
     * this value as a writeable URI (probably a file name).
     *
     * @param systemId The system identifier as a URI string.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:00.146 -0500", hash_original_method = "77F5337B905F22D1C71F7C949FEF5117", hash_generated_method = "D9FED68AD30F5F5E327902500C39300D")
    
public void setSystemId(String systemId) {
        this.systemId = systemId;
    }

    /**
     * <p>Set the system ID from a <code>File</code> reference.</p>
     *
     * <p>Note the use of {@link File#toURI()} and {@link File#toURL()}.
     * <code>toURI()</code> is preferred and used if possible.
     * To allow JAXP 1.3 to run on J2SE 1.3, <code>toURL()</code>
     * is used if a {@link NoSuchMethodException} is thrown by the attempt
     * to use <code>toURI()</code>.</p>
     *
     * @param f Must a non-null File reference.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:00.149 -0500", hash_original_method = "30231F16AB3AB378740EA121A3BAEA6C", hash_generated_method = "75EFE97E280202884A437785B612EF5B")
    
public void setSystemId(File f) {
        this.systemId = FilePathToURI.filepath2URI(f.getAbsolutePath());
    }

    /**
     * Get the system identifier that was set with setSystemId.
     *
     * @return The system identifier that was set with setSystemId, or null
     * if setSystemId was not called.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:00.151 -0500", hash_original_method = "8088708D8DEEE6054468B7FD77400E50", hash_generated_method = "6A03DC8D49FB90AC37FD320CD622E272")
    
public String getSystemId() {
        return systemId;
    }
}

