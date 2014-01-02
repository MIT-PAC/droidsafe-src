package org.apache.http.entity;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;






public class BasicHttpEntity extends AbstractHttpEntity {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:45.270 -0500", hash_original_field = "843941CC0104424A71E5291E659CC007", hash_generated_field = "E10265C22C3282384A3FF9B20A322BFE")


    private InputStream content;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:45.272 -0500", hash_original_field = "119C40B1C90EE8408989DFB3E8902B9E", hash_generated_field = "F83D62FF33880A5C9450BAF66AEC5A3C")

    private boolean contentObtained;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:45.274 -0500", hash_original_field = "D634AAE75ADF86F4EAAC1CC85A8379F4", hash_generated_field = "C62D106264E132930C7955708C9A9CDD")

    private long length;

    /**
     * Creates a new basic entity.
     * The content is initially missing, the content length
     * is set to a negative number.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:45.279 -0500", hash_original_method = "6C56C11F8A570F150FD118B6F4CE07D0", hash_generated_method = "BAC7665F566F0E3CFE16276162A7B9FB")
    
public BasicHttpEntity() {
        super();
        this.length = -1;
    }

    // non-javadoc, see interface HttpEntity
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:45.282 -0500", hash_original_method = "120309BFFDD6935F8B30886147626A04", hash_generated_method = "9233A3153FC331D80C5DADB9AF36C94A")
    
public long getContentLength() {
        return this.length;
    }

    /**
     * Obtains the content, once only.
     *
     * @return  the content, if this is the first call to this method
     *          since {@link #setContent setContent} has been called
     *
     * @throws IllegalStateException
     *          if the content has been obtained before, or
     *          has not yet been provided
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:45.285 -0500", hash_original_method = "DD43DF1BE34625633489098C75403E56", hash_generated_method = "7699A858A6F34F95A95A5ED2ACB23D2A")
    
public InputStream getContent()
        throws IllegalStateException {
        if (this.content == null) {
            throw new IllegalStateException("Content has not been provided");
        }
        if (this.contentObtained) {
            throw new IllegalStateException("Content has been consumed");
        }
        this.contentObtained = true;
        return this.content;

    } // getContent

    /**
     * Tells that this entity is not repeatable.
     *
     * @return <code>false</code>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:45.287 -0500", hash_original_method = "731D88F5D8865617BA362DCED4C30896", hash_generated_method = "ED09A364E94A90F3E23A91DCC44E26ED")
    
public boolean isRepeatable() {
        return false;
    }

    /**
     * Specifies the length of the content.
     *
     * @param len       the number of bytes in the content, or
     *                  a negative number to indicate an unknown length
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:45.289 -0500", hash_original_method = "7EB1D34B8B79AC60227ACAB040078324", hash_generated_method = "3D5AD3090F1BED846E401D03345506C8")
    
public void setContentLength(long len) {
        this.length = len;
    }

    /**
     * Specifies the content.
     *
     * @param instream          the stream to return with the next call to
     *                          {@link #getContent getContent}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:45.291 -0500", hash_original_method = "9243F298C9B144B2EDE1C1ED14CD424D", hash_generated_method = "0D95F348D6A917F106467B43DB8F66AF")
    
public void setContent(final InputStream instream) {
        this.content = instream;
        this.contentObtained = false; 
    }

    // non-javadoc, see interface HttpEntity
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:45.293 -0500", hash_original_method = "4D2C7455ACC84C8F2AC9220CC460CB0C", hash_generated_method = "B209F48EC677326409BDAA732C0F6E8F")
    
public void writeTo(final OutputStream outstream) throws IOException {
        if (outstream == null) {
            throw new IllegalArgumentException("Output stream may not be null");
        }
        InputStream instream = getContent();
        int l;
        byte[] tmp = new byte[2048];
        while ((l = instream.read(tmp)) != -1) {
            outstream.write(tmp, 0, l);
        }
    }

    // non-javadoc, see interface HttpEntity
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:45.296 -0500", hash_original_method = "12B60AB15F5876110075CCE154554A33", hash_generated_method = "62D6BCD73FD07EE361228FB277D73AFB")
    
public boolean isStreaming() {
        return !this.contentObtained && this.content != null;
    }

    // non-javadoc, see interface HttpEntity
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:45.298 -0500", hash_original_method = "DCFF80E870BC55BBCCB28CB7928D312B", hash_generated_method = "163C0982C54CF0B305B40E6C89151E83")
    
public void consumeContent() throws IOException {
        if (content != null) {
            content.close(); // reads to the end of the entity
        }
    }

    
}

