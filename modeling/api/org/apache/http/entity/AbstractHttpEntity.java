package org.apache.http.entity;

// Droidsafe Imports
import droidsafe.annotations.*;
import droidsafe.helpers.*;

import droidsafe.runtime.*;
import java.io.IOException;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;

public abstract class AbstractHttpEntity implements HttpEntity {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:45.908 -0500", hash_original_field = "2FADA47DC2FC7C4F250B0D9A3B6953BE", hash_generated_field = "7707552268699116A6B81DCAB1E039E0")

    protected Header contentType;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:45.911 -0500", hash_original_field = "770563F888B945C7BCB239CF2A709073", hash_generated_field = "EE4016A6B9EC527F15082EA3FB92CF90")

    protected Header contentEncoding;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:45.913 -0500", hash_original_field = "EF4C7F6B09F0CE41C1BC01CB545F48C3", hash_generated_field = "AC5AAC899B99DDB88A53898F83C297BE")

    protected boolean chunked;
    
	@DSSafe(DSCat.SAFE_OTHERS)
    protected AbstractHttpEntity() {}

    /**
     * Obtains the Content-Type header.
     * The default implementation returns the value of the
     * {@link #contentType contentType} attribute.
     *
     * @return  the Content-Type header, or <code>null</code>
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:45.918 -0500", hash_original_method = "DA5232C01B88DD776A78D6C1E0EF7DB4", hash_generated_method = "33852E0EBCD1B1F03B200DF158C6DE03")
    @DSVerified
    @DSSafe(DSCat.DATA_STRUCTURE)
public Header getContentType() {
        return this.contentType;
    }
    
    /**
     * Obtains the Content-Encoding header.
     * The default implementation returns the value of the
     * {@link #contentEncoding contentEncoding} attribute.
     *
     * @return  the Content-Encoding header, or <code>null</code>
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:45.921 -0500", hash_original_method = "0300179EF34C28254565E1D29B0088D9", hash_generated_method = "0F715B6D0D7D905C0D822E970B6614D5")
    @DSVerified
    @DSSafe(DSCat.DATA_STRUCTURE)
public Header getContentEncoding() {
        return this.contentEncoding;
    }

    /**
     * Obtains the 'chunked' flag.
     * The default implementation returns the value of the
     * {@link #chunked chunked} attribute.
     *
     * @return  the 'chunked' flag
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:45.923 -0500", hash_original_method = "A2E32B99DD6261F3B5CB31D5FA7FC0FC", hash_generated_method = "D46D66383F14F25D695C786209B4FF6E")
    @DSVerified
    @DSSafe(DSCat.DATA_STRUCTURE)
public boolean isChunked() {
        return this.chunked;
    }
    
    /**
     * Specifies the Content-Type header.
     * The default implementation sets the value of the
     * {@link #contentType contentType} attribute.
     *
     * @param contentType       the new Content-Encoding header, or
     *                          <code>null</code> to unset
     */
    @DSSink({DSSinkKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:45.925 -0500", hash_original_method = "2A50843ADF5A0160EFC9E5758FE12891", hash_generated_method = "1874C3317F3410204EFC04FD9299595D")
    @DSVerified
    @DSSafe(DSCat.DATA_STRUCTURE)
public void setContentType(final Header contentType) {
        this.contentType = contentType;
    }

    /**
     * Specifies the Content-Type header, as a string.
     * The default implementation calls
     * {@link #setContentType(Header) setContentType(Header)}.
     *
     * @param ctString     the new Content-Type header, or
     *                     <code>null</code> to unset
     */
    @DSSink({DSSinkKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:45.927 -0500", hash_original_method = "E88DF46252A0D3C2D0E67C1F492FFB2C", hash_generated_method = "3DFC5FA202A5B7D3D2C51A0040367FD0")
    @DSVerified
    @DSSafe(DSCat.DATA_STRUCTURE)
public void setContentType(final String ctString) {
        Header h = null;
        if (ctString != null) {
            h = new BasicHeader(HTTP.CONTENT_TYPE, ctString);
        }
        setContentType(h);
    }

    /**
     * Specifies the Content-Encoding header.
     * The default implementation sets the value of the
     * {@link #contentEncoding contentEncoding} attribute.
     *
     * @param contentEncoding   the new Content-Encoding header, or
     *                          <code>null</code> to unset
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:45.929 -0500", hash_original_method = "DEBEEA900825B0657525159073BC33A3", hash_generated_method = "50544A7BFB2B272F6A1826A6DC648C69")
    @DSVerified
    @DSSafe(DSCat.DATA_STRUCTURE)
public void setContentEncoding(final Header contentEncoding) {
        this.contentEncoding = contentEncoding;
    }

    /**
     * Specifies the Content-Encoding header, as a string.
     * The default implementation calls
     * {@link #setContentEncoding(Header) setContentEncoding(Header)}.
     *
     * @param ceString     the new Content-Encoding header, or
     *                     <code>null</code> to unset
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:45.932 -0500", hash_original_method = "C8D25A66722ADB2A8BE857D43D852F52", hash_generated_method = "D642BC53948088F105FD18B8BE2281A6")
    @DSVerified
    @DSSafe(DSCat.DATA_STRUCTURE)
public void setContentEncoding(final String ceString) {
        Header h = null;
        if (ceString != null) {
            h = new BasicHeader(HTTP.CONTENT_ENCODING, ceString);
        }
        setContentEncoding(h);
    }

    /**
     * Specifies the 'chunked' flag.
     * The default implementation sets the value of the
     * {@link #chunked chunked} attribute.
     *
     * @param b         the new 'chunked' flag
     */
    @DSComment("possibly edits networking data")
    @DSSpec(DSCat.NETWORKING)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:45.936 -0500", hash_original_method = "1B88FA65FDF60169F373F298E33E777E", hash_generated_method = "257FDFC86D61A9133D77F54CD71C658D")
    @DSVerified
    @DSSafe(DSCat.DATA_STRUCTURE)
public void setChunked(boolean b) {
        this.chunked = b;
    }

    /**
     * Does not consume anything.
     * The default implementation does nothing if
     * {@link HttpEntity#isStreaming isStreaming}
     * returns <code>false</code>, and throws an exception
     * if it returns <code>true</code>.
     * This removes the burden of implementing
     * an empty method for non-streaming entities.
     *
     * @throws IOException      in case of an I/O problem
     * @throws UnsupportedOperationException
     *          if a streaming subclass does not override this method
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:45.939 -0500", hash_original_method = "3048E7043703056EA818491E1D9863FC", hash_generated_method = "3ED0DB4C1BFC2781032ABBA2CF53EE80")
    @DSVerified
    @DSSafe(DSCat.SAFE_OTHERS)
public void consumeContent()
        throws IOException, UnsupportedOperationException{
        if (isStreaming()) {
            throw new UnsupportedOperationException
                ("streaming entity does not implement consumeContent()");
        }
    }
    
}

