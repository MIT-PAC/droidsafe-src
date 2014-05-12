package org.apache.http.conn;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.InputStream;

public class EofSensorInputStream extends InputStream implements ConnectionReleaseTrigger {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:28.212 -0500", hash_original_field = "E9CE5FBAB081267F17B625AD291A8D53", hash_generated_field = "75EE73214070AB1FED136199F98CB7D5")

    protected InputStream wrappedStream;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:28.214 -0500", hash_original_field = "DA270187431DA0D6E4389D04A3E1B5A8", hash_generated_field = "41AE24AA8B5ED51DCEF7DAEC1C441A42")

    private boolean selfClosed;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:28.216 -0500", hash_original_field = "E8DC111D899A245C1B2C406ED53E1859", hash_generated_field = "604EC2A2F6D75D40086FC63DE46C1C59")

    private EofSensorWatcher eofWatcher;

    /**
     * Creates a new EOF sensor.
     * If no watcher is passed, the underlying stream will simply be
     * closed when EOF is detected or {@link #close close} is called.
     * Otherwise, the watcher decides whether the underlying stream
     * should be closed before detaching from it.
     *
     * @param in        the wrapped stream
     * @param watcher   the watcher for events, or <code>null</code> for
     *                  auto-close behavior without notification
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:28.219 -0500", hash_original_method = "9B2B9BBE0E73ACBBC201B99B60B700AE", hash_generated_method = "71C753C0F9AAE30F8CFA2C55D883B32D")
    
public EofSensorInputStream(final InputStream in,
                                final EofSensorWatcher watcher) {
        if (in == null) {
            throw new IllegalArgumentException
                ("Wrapped stream may not be null.");
        }

        wrappedStream = in;
        selfClosed = false;
        eofWatcher = watcher;
    }

    /**
     * Checks whether the underlying stream can be read from.
     *
     * @return  <code>true</code> if the underlying stream is accessible,
     *          <code>false</code> if this stream is in EOF mode and
     *          detached from the underlying stream
     *
     * @throws IOException      if this stream is already closed
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:28.222 -0500", hash_original_method = "7D1410F2491A2101D94AEDEF5E6D4821", hash_generated_method = "D10714ADA056C5D26243F877D5109431")
    
protected boolean isReadAllowed() throws IOException {
        if (selfClosed) {
            throw new IOException("Attempted read on closed stream.");
        }
        return (wrappedStream != null);
    }

    // non-javadoc, see base class InputStream
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:28.224 -0500", hash_original_method = "EEFED13FF9B8A7AEEF5F21DDE66222B5", hash_generated_method = "F6963B5AC1FF9608BE1556EF67FD5BEC")
    
@Override
    public int read() throws IOException {
        int l = -1;

        if (isReadAllowed()) {
            try {
                l = wrappedStream.read();
                checkEOF(l);
            } catch (IOException ex) {
                checkAbort();
                throw ex;
            }
        }

        return l;
    }

    // non-javadoc, see base class InputStream
    @DSSpec(DSCat.IO)
    @DSSource({DSSourceKind.IO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:28.227 -0500", hash_original_method = "140106DCDF4EB864C1587DEC2B46B903", hash_generated_method = "1569190AC85DA6991387237440E7D269")
    
@Override
    public int read(byte[] b, int off, int len) throws IOException {
        int l = -1;

        if (isReadAllowed()) {
            try {
                l = wrappedStream.read(b,  off,  len);
                checkEOF(l);
            } catch (IOException ex) {
                checkAbort();
                throw ex;
            }
        }

        return l;
    }

    // non-javadoc, see base class InputStream
    @DSSpec(DSCat.IO)
    @DSSource({DSSourceKind.IO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:28.230 -0500", hash_original_method = "4F7157F64E168AA9C8D7643824C693E0", hash_generated_method = "26CB21DE6DFA075040FA5A38E66D16CE")
    
@Override
    public int read(byte[] b) throws IOException {
        int l = -1;

        if (isReadAllowed()) {
            try {
                l = wrappedStream.read(b);
                checkEOF(l);
            } catch (IOException ex) {
                checkAbort();
                throw ex;
            }
        }
        return l;
    }

    // non-javadoc, see base class InputStream
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:28.234 -0500", hash_original_method = "4A9A4C62148DEF77484BCFABD0B37515", hash_generated_method = "58A43ADF50A9853C54724443A3D0099A")
    
@Override
    public int available() throws IOException {
        int a = 0; // not -1

        if (isReadAllowed()) {
            try {
                a = wrappedStream.available();
                // no checkEOF() here, available() can't trigger EOF
            } catch (IOException ex) {
                checkAbort();
                throw ex;
            }
        }

        return a;
    }

    // non-javadoc, see base class InputStream
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:28.236 -0500", hash_original_method = "BBB2789F4CB1F09FFDECF0070B286C07", hash_generated_method = "2E17330E15F266C5763B12993D02A116")
    
@Override
    public void close() throws IOException {
        // tolerate multiple calls to close()
        selfClosed = true;
        checkClose();
    }

    /**
     * Detects EOF and notifies the watcher.
     * This method should only be called while the underlying stream is
     * still accessible. Use {@link #isReadAllowed isReadAllowed} to
     * check that condition.
     * <br/>
     * If EOF is detected, the watcher will be notified and this stream
     * is detached from the underlying stream. This prevents multiple
     * notifications from this stream.
     *
     * @param eof       the result of the calling read operation.
     *                  A negative value indicates that EOF is reached.
     *
     * @throws IOException
     *          in case of an IO problem on closing the underlying stream
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:28.239 -0500", hash_original_method = "AE762594E7D7874DF7D34819786C5E24", hash_generated_method = "3C3E978BF9EFC25665A32E02653F7A07")
    
protected void checkEOF(int eof) throws IOException {

        if ((wrappedStream != null) && (eof < 0)) {
            try {
                boolean scws = true; // should close wrapped stream?
                if (eofWatcher != null)
                    scws = eofWatcher.eofDetected(wrappedStream);
                if (scws)
                    wrappedStream.close();
            } finally {
                wrappedStream = null;
            }
        }
    }

    /**
     * Detects stream close and notifies the watcher.
     * There's not much to detect since this is called by {@link #close close}.
     * The watcher will only be notified if this stream is closed
     * for the first time and before EOF has been detected.
     * This stream will be detached from the underlying stream to prevent
     * multiple notifications to the watcher.
     *
     * @throws IOException
     *          in case of an IO problem on closing the underlying stream
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:28.241 -0500", hash_original_method = "5F2207AEF37490FFD8B76672ACFD7F2C", hash_generated_method = "4C8D05811B942D9B1DB6738C58428DAB")
    
protected void checkClose() throws IOException {

        if (wrappedStream != null) {
            try {
                boolean scws = true; // should close wrapped stream?
                if (eofWatcher != null)
                    scws = eofWatcher.streamClosed(wrappedStream);
                if (scws)
                    wrappedStream.close();
            } finally {
                wrappedStream = null;
            }
        }
    }

    /**
     * Detects stream abort and notifies the watcher.
     * There's not much to detect since this is called by
     * {@link #abortConnection abortConnection}.
     * The watcher will only be notified if this stream is aborted
     * for the first time and before EOF has been detected or the
     * stream has been {@link #close closed} gracefully.
     * This stream will be detached from the underlying stream to prevent
     * multiple notifications to the watcher.
     *
     * @throws IOException
     *          in case of an IO problem on closing the underlying stream
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:28.244 -0500", hash_original_method = "85C58A54B3CFDF3144733266DFBF6D58", hash_generated_method = "D8470D6E687B6A99ADC1A35DAB30E12B")
    
protected void checkAbort() throws IOException {

        if (wrappedStream != null) {
            try {
                boolean scws = true; // should close wrapped stream?
                if (eofWatcher != null)
                    scws = eofWatcher.streamAbort(wrappedStream);
                if (scws)
                    wrappedStream.close();
            } finally {
                wrappedStream = null;
            }
        }
    }

    /**
     * Same as {@link #close close()}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:28.247 -0500", hash_original_method = "02046A66B4E60C074CA5E7223CFCAAA0", hash_generated_method = "B1CF909D8AA3C6611D50B55A882E4F28")
    
public void releaseConnection() throws IOException {
        this.close();
    }

    /**
     * Aborts this stream.
     * This is a special version of {@link #close close()} which prevents
     * re-use of the underlying connection, if any. Calling this method
     * indicates that there should be no attempt to read until the end of
     * the stream.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:28.249 -0500", hash_original_method = "0D022924489DD4E5DC4E4B7CC5A41FBA", hash_generated_method = "2F6C2886FAB96527914CC35EE3E007E0")
    
public void abortConnection() throws IOException {
        // tolerate multiple calls
        selfClosed = true;
        checkAbort();
    }
    
}

