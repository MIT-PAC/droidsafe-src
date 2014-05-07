package org.apache.http.conn;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.http.HttpEntity;
import org.apache.http.entity.HttpEntityWrapper;

public class BasicManagedEntity extends HttpEntityWrapper implements ConnectionReleaseTrigger, EofSensorWatcher {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:28.586 -0500", hash_original_field = "ECC1A1A1F3BB31DE20717F98D44EFC60", hash_generated_field = "A39C84F92F3A7EA4C05EE395EC188DAE")

    protected ManagedClientConnection managedConn;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:28.589 -0500", hash_original_field = "F6FDC975DEEC1249FFD0EA5446B40A56", hash_generated_field = "E3C3E883F50FA4994DDE044495909683")

    protected  boolean attemptReuse;

    /**
     * Creates a new managed entity that can release a connection.
     *
     * @param entity    the entity of which to wrap the content.
     *                  Note that the argument entity can no longer be used
     *                  afterwards, since the content will be taken by this
     *                  managed entity.
     * @param conn      the connection to release
     * @param reuse     whether the connection should be re-used
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:28.591 -0500", hash_original_method = "75E41BB014942CF37AED72804C2A632B", hash_generated_method = "10B699F6AD62C54BA3EF01A04EA8563B")
    
public BasicManagedEntity(HttpEntity entity,
                              ManagedClientConnection conn,
                              boolean reuse) {
        super(entity);

        if (conn == null)
            throw new IllegalArgumentException
                ("Connection may not be null.");

        this.managedConn = conn;
        this.attemptReuse = reuse;
    }

    // non-javadoc, see interface HttpEntity
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:28.594 -0500", hash_original_method = "731D88F5D8865617BA362DCED4C30896", hash_generated_method = "47668CDFF1A9B2EE068B1E9BA916D5E5")
    
@Override
    public boolean isRepeatable() {
        return false;
    }

    // non-javadoc, see interface HttpEntity
    @DSSafe(DSCat.NETWORK)
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:28.596 -0500", hash_original_method = "5A535D8BC3EB290E639D312782FBEB37", hash_generated_method = "90F1E79E69DFB56FB823CA4316A9689D")
    
@Override
    public InputStream getContent() throws IOException {

        return new EofSensorInputStream(wrappedEntity.getContent(), this);
    }

    // non-javadoc, see interface HttpEntity
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:28.599 -0500", hash_original_method = "58D11A845FE872643BE2CB7CB3DAF1D5", hash_generated_method = "F15A6B3C510AB5FB5DADA0E286F65EBE")
    
@Override
    public void consumeContent() throws IOException {

        if (managedConn == null)
            return;

        try {
            if (attemptReuse) {
                // this will not trigger a callback from EofSensorInputStream
                wrappedEntity.consumeContent();
                managedConn.markReusable();
            }
        } finally {
            releaseManagedConnection();
        }
    }
    
    // non-javadoc, see interface HttpEntity
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:28.601 -0500", hash_original_method = "7A0C9BF6AEBE62A6A7FD18951D7BE860", hash_generated_method = "11C367E33E31870466F18902685DDE85")
    
@Override
    public void writeTo(final OutputStream outstream) throws IOException {
        super.writeTo(outstream);
        consumeContent();
    }

    // non-javadoc, see interface ConnectionReleaseTrigger
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:28.603 -0500", hash_original_method = "4116E5CDB1EF6E698D2E6ADBA9E28033", hash_generated_method = "9AF32D04EE78CE1862893894E8F33CA9")
    
public void releaseConnection()
        throws IOException {

        this.consumeContent();
    }

    // non-javadoc, see interface ConnectionReleaseTrigger
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:28.605 -0500", hash_original_method = "09E9D1BA9D6B3D57F6131522158659B5", hash_generated_method = "86A1D2DA47C2A83DAA24927F9C4902F8")
    
public void abortConnection()
        throws IOException {

        if (managedConn != null) {
            try {
                managedConn.abortConnection();
            } finally {
                managedConn = null;
            }
        }
    }

    // non-javadoc, see interface EofSensorWatcher
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:28.608 -0500", hash_original_method = "5A64D16D6F2B869D7FBA53B05FD87C82", hash_generated_method = "5F8B1813E47A177890C2FFA6FB13A1BC")
    
public boolean eofDetected(InputStream wrapped)
        throws IOException {

        try {
            if (attemptReuse && (managedConn != null)) {
                // there may be some cleanup required, such as
                // reading trailers after the response body:
                wrapped.close();
                managedConn.markReusable();
            }
        } finally {
            releaseManagedConnection();
        }
        return false;
    }

    // non-javadoc, see interface EofSensorWatcher
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:28.610 -0500", hash_original_method = "317830EACA4241C6C1785BE58FAD1AFA", hash_generated_method = "1B854B0A0646232CE31EB499FA13E306")
    
public boolean streamClosed(InputStream wrapped)
        throws IOException {

        try {
            if (attemptReuse && (managedConn != null)) {
                // this assumes that closing the stream will
                // consume the remainder of the response body:
                wrapped.close();
                managedConn.markReusable();
            }
        } finally {
            releaseManagedConnection();
        }
        return false;
    }

    // non-javadoc, see interface EofSensorWatcher
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:28.613 -0500", hash_original_method = "BAB258C2D5F3651DF9A25667D27EF99D", hash_generated_method = "39E33C173783F5A2873CE6B781025A7A")
    
public boolean streamAbort(InputStream wrapped)
        throws IOException {

        if (managedConn != null) {
            managedConn.abortConnection();
        }
        return false;
    }

    /**
     * Releases the connection gracefully.
     * The connection attribute will be nullified.
     * Subsequent invocations are no-ops.
     *
     * @throws IOException      in case of an IO problem.
     *         The connection attribute will be nullified anyway.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:28.615 -0500", hash_original_method = "713B19D560033B1B50E26BAD17DD5FF2", hash_generated_method = "A5AC41D84F7549396CE8AAD5A06BF8E9")
    
protected void releaseManagedConnection()
        throws IOException {

        if (managedConn != null) {
            try {
                managedConn.releaseConnection();
            } finally {
                managedConn = null;
            }
        }
    }
    
}

