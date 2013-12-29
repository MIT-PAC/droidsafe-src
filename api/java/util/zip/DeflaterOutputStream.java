package java.util.zip;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

import libcore.io.Streams;





public class DeflaterOutputStream extends FilterOutputStream {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:49.526 -0500", hash_original_field = "86AF9D144AB13FC6B685B7332D58DC58", hash_generated_field = "A60956B00A99CF9DF92AF09280C120E9")

    static final int BUF_SIZE = 512;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:49.527 -0500", hash_original_field = "001DD3820C6A6A544AB42831C6F17A05", hash_generated_field = "083037218D1B4F9535944A48D3FD1BCA")

    protected byte[] buf;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:49.528 -0500", hash_original_field = "1BB4DFAD44B3741493C144A3265C33E5", hash_generated_field = "BB50A00575DEBF8BAC8ED22DB8D1D289")

    protected Deflater def;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:49.528 -0500", hash_original_field = "B3F4B9FB7F6E266775B1E500C6C15A46", hash_generated_field = "B3F4B9FB7F6E266775B1E500C6C15A46")


    boolean done = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:49.529 -0500", hash_original_field = "7A3702D094F8E8154BE6F2EF131F2AA3", hash_generated_field = "2E2C89D90D8FD13D5246794A60DDA967")


    private  boolean syncFlush;

    /**
     * This constructor lets you pass the {@code Deflater} specifying the
     * compression algorithm.
     *
     * @param os
     *            is the {@code OutputStream} where to write the compressed data
     *            to.
     * @param def
     *            is the specific {@code Deflater} that is used to compress
     *            data.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:49.530 -0500", hash_original_method = "139234A429000310B925F23DA1712488", hash_generated_method = "9DB9CE5ECB787BAA6F81F82698F6E2B6")
    public DeflaterOutputStream(OutputStream os, Deflater def) {
        this(os, def, BUF_SIZE, false);
    }

    /**
     * This is the most basic constructor. You only need to pass the {@code
     * OutputStream} to which the compressed data shall be written to. The
     * default settings for the {@code Deflater} and internal buffer are used.
     * In particular the {@code Deflater} produces a ZLIB header in the output
     * stream.
     *
     * @param os
     *            is the OutputStream where to write the compressed data to.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:49.531 -0500", hash_original_method = "D833AEB9A421148720E02F65A02537D6", hash_generated_method = "CB7727C149413E86090AB532C121E3D9")
    public DeflaterOutputStream(OutputStream os) {
        this(os, new Deflater(), BUF_SIZE, false);
    }

    /**
     * This constructor lets you specify both the compression algorithm as well
     * as the internal buffer size to be used.
     *
     * @param os
     *            is the {@code OutputStream} where to write the compressed data
     *            to.
     * @param def
     *            is the specific {@code Deflater} that will be used to compress
     *            data.
     * @param bsize
     *            is the size to be used for the internal buffer.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:49.532 -0500", hash_original_method = "4BB74E5E227C5A90579EB5A36914BC95", hash_generated_method = "2122BDA5E53973131B23ACDA569C71A8")
    public DeflaterOutputStream(OutputStream os, Deflater def, int bsize) {
        this(os, def, bsize, false);
    }

    /**
     * @hide
     * @since 1.7
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:49.533 -0500", hash_original_method = "4AB400BD05A544E56EC5FA788A743E49", hash_generated_method = "46AB79C2EB302E4C22C6505D1A63B8A4")
    public DeflaterOutputStream(OutputStream os, boolean syncFlush) {
        this(os, new Deflater(), BUF_SIZE, syncFlush);
    }

    /**
     * @hide
     * @since 1.7
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:49.534 -0500", hash_original_method = "030FC273048345BE6683513E5C823172", hash_generated_method = "58749372C11266470FDE08BF3B841730")
    public DeflaterOutputStream(OutputStream os, Deflater def, boolean syncFlush) {
        this(os, def, BUF_SIZE, syncFlush);
    }

    /**
     * @hide
     * @since 1.7
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:49.535 -0500", hash_original_method = "36641FCF7AB1B4FCCCA71F3379196A62", hash_generated_method = "68B7C36F10AA9DE24A222C4B08CAD7F9")
    public DeflaterOutputStream(OutputStream os, Deflater def, int bsize, boolean syncFlush) {
        super(os);
        if (os == null || def == null) {
            throw new NullPointerException();
        }
        if (bsize <= 0) {
            throw new IllegalArgumentException();
        }
        this.def = def;
        this.syncFlush = syncFlush;
        buf = new byte[bsize];
    }

    /**
     * Compress the data in the input buffer and write it to the underlying
     * stream.
     *
     * @throws IOException
     *             If an error occurs during deflation.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:49.536 -0500", hash_original_method = "5BA084DE43D12B9C920D3018364BFA70", hash_generated_method = "6A078938F9D0B82BA0C58C5BBF2270CD")
    protected void deflate() throws IOException {
        int byteCount;
        while ((byteCount = def.deflate(buf)) != 0) {
            out.write(buf, 0, byteCount);
        }
    }

    /**
     * Writes any unwritten compressed data to the underlying stream, the closes
     * all underlying streams. This stream can no longer be used after close()
     * has been called.
     *
     * @throws IOException
     *             If an error occurs while closing the data compression
     *             process.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:49.536 -0500", hash_original_method = "9BCFE06D96770C193778FD581B5E01A8", hash_generated_method = "16BFD9FBD063C00124000FB057591644")
    @Override
public void close() throws IOException {
        // everything closed here should also be closed in ZipOutputStream.close()
        if (!def.finished()) {
            finish();
        }
        def.end();
        out.close();
    }

    /**
     * Writes any unwritten data to the underlying stream. Does not close the
     * stream.
     *
     * @throws IOException
     *             If an error occurs.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:49.537 -0500", hash_original_method = "1DDC7258E310FE2F6E87FB700766CEAD", hash_generated_method = "C8D2EBF41CF2C3F39FBBA801A5688D9A")
    public void finish() throws IOException {
        if (done) {
            return;
        }
        def.finish();
        while (!def.finished()) {
            int byteCount = def.deflate(buf);
            out.write(buf, 0, byteCount);
        }
        done = true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:49.538 -0500", hash_original_method = "DD8DF91486AFD685531F1A8944310E80", hash_generated_method = "8F716C7D080C02AB7834C5B17E78CDC1")
    @Override
public void write(int i) throws IOException {
        Streams.writeSingleByte(this, i);
    }

    /**
     * Compresses {@code byteCount} bytes of data from {@code buf} starting at
     * {@code offset} and writes it to the underlying stream.
     * @throws IOException
     *             If an error occurs during writing.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:49.539 -0500", hash_original_method = "5BF353787DD4638B35D7C1FA14989FAE", hash_generated_method = "E2034B50C55354120883031999A50019")
    @Override
public void write(byte[] buffer, int offset, int byteCount) throws IOException {
        if (done) {
            throw new IOException("attempt to write after finish");
        }
        Arrays.checkOffsetAndCount(buffer.length, offset, byteCount);
        if (!def.needsInput()) {
            throw new IOException();
        }
        def.setInput(buffer, offset, byteCount);
        deflate();
    }

    /**
     * Flushes the underlying stream. This flushes only the bytes that can be
     * compressed at the highest level.
     *
     * <p>For deflater output streams constructed with Java 7's
     * {@code syncFlush} parameter set to true (not yet available on Android),
     * this first flushes all outstanding data so that it may be immediately
     * read by its recipient. Doing so may degrade compression.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:49.540 -0500", hash_original_method = "FB4F039ED9744680CB15453045EEE574", hash_generated_method = "609D00CE798BDC5D620E1BF70BEE2FD2")
    @Override
public void flush() throws IOException {
        if (syncFlush) {
            int byteCount;
            while ((byteCount = def.deflate(buf, 0, buf.length, Deflater.SYNC_FLUSH)) != 0) {
                out.write(buf, 0, byteCount);
            }
        }
        out.flush();
    }
}

