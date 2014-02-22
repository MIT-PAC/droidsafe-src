package java.nio.channels;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.ByteBuffer;
import java.nio.channels.spi.AbstractInterruptibleChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

import libcore.io.Streams;

public final class Channels {

    /**
     * Returns an input stream on the given channel. The resulting stream has
     * the following properties:
     * <ul>
     * <li>If the stream is closed, then the underlying channel is closed as
     * well.</li>
     * <li>It is thread safe.</li>
     * <li>It throws an {@link IllegalBlockingModeException} if the channel is
     * in non-blocking mode and {@code read} is called.</li>
     * <li>Neither {@code mark} nor {@code reset} is supported.</li>
     * <li>It is not buffered.</li>
     * </ul>
     *
     * @param channel
     *            the channel to be wrapped by an InputStream.
     * @return an InputStream that takes bytes from the given byte channel.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:57.584 -0500", hash_original_method = "88F1475DF42BBAD2885353B5129EE8B4", hash_generated_method = "7FE98A0EE099FC5D90AD341ED119B507")
    
public static InputStream newInputStream(ReadableByteChannel channel) {
        return new ChannelInputStream(channel);
    }

    /**
     * Returns an output stream on the given channel. The resulting stream has
     * the following properties:
     * <ul>
     * <li>If the stream is closed, then the underlying channel is closed as
     * well.</li>
     * <li>It is thread safe.</li>
     * <li>It throws an {@link IllegalBlockingModeException} if the channel is
     * in non-blocking mode and {@code write} is called.</li>
     * <li>It is not buffered.</li>
     * </ul>
     *
     * @param channel
     *            the channel to be wrapped by an OutputStream.
     * @return an OutputStream that puts bytes onto the given byte channel.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:57.587 -0500", hash_original_method = "FA0BE2C7D03335AB08651FAD2758394C", hash_generated_method = "73BBD40A18D6035D169AB503DD0453CA")
    
public static OutputStream newOutputStream(WritableByteChannel channel) {
        return new ChannelOutputStream(channel);
    }

    /**
     * Returns a readable channel on the given input stream. The resulting
     * channel has the following properties:
     * <ul>
     * <li>If the channel is closed, then the underlying stream is closed as
     * well.</li>
     * <li>It is not buffered.</li>
     * </ul>
     *
     * @param inputStream
     *            the stream to be wrapped by a byte channel.
     * @return a byte channel that reads bytes from the input stream.
     */
    @DSComment("Method returns IO Object")
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:57.589 -0500", hash_original_method = "10F29762DE0104F8A39064501FA4AE67", hash_generated_method = "AA1E1902CBC1C56C3259D6D39450828D")
    
public static ReadableByteChannel newChannel(InputStream inputStream) {
        return new InputStreamChannel(inputStream);
    }

    /**
     * Returns a writable channel on the given output stream.
     *
     * The resulting channel has following properties:
     * <ul>
     * <li>If the channel is closed, then the underlying stream is closed as
     * well.</li>
     * <li>It is not buffered.</li>
     * </ul>
     *
     * @param outputStream
     *            the stream to be wrapped by a byte channel.
     * @return a byte channel that writes bytes to the output stream.
     */
    @DSComment("Method returns IO Object")
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:57.593 -0500", hash_original_method = "0A26450DD89B99CDCEEC5300E1958D40", hash_generated_method = "4F67C407FEF8F96ABDC5077C62504DCB")
    
public static WritableByteChannel newChannel(OutputStream outputStream) {
        return new OutputStreamChannel(outputStream);
    }

    /**
     * Returns a reader that decodes bytes from a channel.
     *
     * @param channel
     *            the Channel to be read.
     * @param decoder
     *            the Charset decoder to be used.
     * @param minBufferCapacity
     *            The minimum size of the byte buffer, -1 means to use the
     *            default size.
     * @return the reader.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:57.595 -0500", hash_original_method = "8B17794307AD8B81CB01594F41A7E2A7", hash_generated_method = "81847FD0050ED5980F3274ED23B91811")
    
public static Reader newReader(ReadableByteChannel channel,
            CharsetDecoder decoder, int minBufferCapacity) {
        /*
         * This method doesn't honor minBufferCapacity. Ignoring that parameter
         * saves us from having to add a hidden constructor to InputStreamReader.
         */
        return new InputStreamReader(new ChannelInputStream(channel), decoder);
    }

    /**
     * Returns a reader that decodes bytes from a channel. This method creates a
     * reader with a buffer of default size.
     *
     * @param channel
     *            the Channel to be read.
     * @param charsetName
     *            the name of the charset.
     * @return the reader.
     * @throws java.nio.charset.UnsupportedCharsetException
     *             if the given charset name is not supported.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:57.597 -0500", hash_original_method = "2872C03C93E375E914CDE964569312B4", hash_generated_method = "A7D0ACF98BAE1CA91A85DD756277A723")
    
public static Reader newReader(ReadableByteChannel channel,
            String charsetName) {
        if (charsetName == null) {
            throw new NullPointerException();
        }
        return newReader(channel, Charset.forName(charsetName).newDecoder(), -1);
    }

    /**
     * Returns a writer that encodes characters with the specified
     * {@code encoder} and sends the bytes to the specified channel.
     *
     * @param channel
     *            the Channel to write to.
     * @param encoder
     *            the CharsetEncoder to be used.
     * @param minBufferCapacity
     *            the minimum size of the byte buffer, -1 means to use the
     *            default size.
     * @return the writer.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:57.600 -0500", hash_original_method = "FD10973356F78B3E626C8C5B6848E2EE", hash_generated_method = "F6022BB818DCCB86BB00DDCE0C345161")
    
public static Writer newWriter(WritableByteChannel channel,
            CharsetEncoder encoder, int minBufferCapacity) {
        /*
         * This method doesn't honor minBufferCapacity. Ignoring that parameter
         * saves us from having to add a hidden constructor to OutputStreamWriter.
         */
        return new OutputStreamWriter(new ChannelOutputStream(channel), encoder);
    }

    /**
     * Returns a writer that encodes characters with the specified
     * {@code encoder} and sends the bytes to the specified channel. This method
     * creates a writer with a buffer of default size.
     *
     * @param channel
     *            the Channel to be written to.
     * @param charsetName
     *            the name of the charset.
     * @return the writer.
     * @throws java.nio.charset.UnsupportedCharsetException
     *             if the given charset name is not supported.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:57.602 -0500", hash_original_method = "80F939E48DA1586C250E69AEF3051568", hash_generated_method = "716DD37E878FAD6157B52D3DB032FC23")
    
public static Writer newWriter(WritableByteChannel channel,
            String charsetName) {
        if (charsetName == null) {
            throw new NullPointerException();
        }
        return newWriter(channel, Charset.forName(charsetName).newEncoder(), -1);
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:57.644 -0500", hash_original_method = "206E2BE370D5671AA0C46024032F807A", hash_generated_method = "EEEBD9956AB1E83544984AEC538BE617")
    
static void checkBlocking(Channel channel) {
        if (channel instanceof SelectableChannel && !((SelectableChannel) channel).isBlocking()) {
            throw new IllegalBlockingModeException();
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:57.581 -0500", hash_original_method = "E5756BC98BED6794F2A2668CF27D9D40", hash_generated_method = "660D69849027ABCF1F216F5B02F3F5DA")
    
private Channels() {}
    
    private static class ChannelInputStream extends InputStream {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:57.606 -0500", hash_original_field = "55F1DC48D55A0A6FC4EA670FAAD152FE", hash_generated_field = "CAD34F506A7F52021B790F3A2404CE8C")

        private  ReadableByteChannel channel;

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:57.609 -0500", hash_original_method = "80B02113EE3067DF952BBE67BFAA654C", hash_generated_method = "80B02113EE3067DF952BBE67BFAA654C")
        
ChannelInputStream(ReadableByteChannel channel) {
            if (channel == null) {
                throw new NullPointerException();
            }
            this.channel = channel;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:57.612 -0500", hash_original_method = "DEBABCFB0D5C81DCE0E37961227F43C9", hash_generated_method = "EDB147B342555EE99C070665ED7CE828")
        
@Override public synchronized int read() throws IOException {
            return Streams.readSingleByte(this);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:57.614 -0500", hash_original_method = "1AE7B72C96392B3D0D4F989CF18659AC", hash_generated_method = "14D88A8B061C1022E14CA983FBCF856E")
        
@Override public synchronized int read(byte[] target, int offset, int length) throws IOException {
            ByteBuffer buffer = ByteBuffer.wrap(target, offset, length);
            checkBlocking(channel);
            return channel.read(buffer);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:57.617 -0500", hash_original_method = "8AF6429D1717D8D7E12FE07FE6FDB12A", hash_generated_method = "032ACB1B9554E7BFD3B0CAB37D023878")
        
@Override public int available() throws IOException {
            if (channel instanceof FileChannel) {
                FileChannel fileChannel = (FileChannel) channel;
                long result = fileChannel.size() - fileChannel.position();
                return result > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) result;
            } else {
                return super.available();
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:57.623 -0500", hash_original_method = "E57206FE07E33F2E755E86DBBBAE8BDB", hash_generated_method = "6098CAE6D79FEEF35314C7AF3CC52F7E")
        
@Override
        public synchronized void close() throws IOException {
            channel.close();
        }
        
    }
    
    private static class ChannelOutputStream extends OutputStream {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:57.628 -0500", hash_original_field = "4CFEECC14753EB27873B0258AB92EF63", hash_generated_field = "F18845F3B98BBBDA823B047CD34AFB03")

        private  WritableByteChannel channel;

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:57.631 -0500", hash_original_method = "1089F5ED21B35830343C54EE52895DB5", hash_generated_method = "1089F5ED21B35830343C54EE52895DB5")
        
ChannelOutputStream(WritableByteChannel channel) {
            if (channel == null) {
                throw new NullPointerException();
            }
            this.channel = channel;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:57.634 -0500", hash_original_method = "976097BC4C10B6759034E4B1EDA42187", hash_generated_method = "A2DC5F91B490FB6FF0B7BB1EE34B1473")
        
@Override
        public synchronized void write(int oneByte) throws IOException {
            byte[] wrappedByte = { (byte) oneByte };
            write(wrappedByte);
        }

        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:57.637 -0500", hash_original_method = "BF3010B4A99B9EE523BF774883EC19AF", hash_generated_method = "4D16EB7F001ED787EAEAEADF10DB0A28")
        
@Override
        public synchronized void write(byte[] source, int offset, int length) throws IOException {
            ByteBuffer buffer = ByteBuffer.wrap(source, offset, length);
            checkBlocking(channel);
            int total = 0;
            while (total < length) {
                total += channel.write(buffer);
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:57.640 -0500", hash_original_method = "E57206FE07E33F2E755E86DBBBAE8BDB", hash_generated_method = "6098CAE6D79FEEF35314C7AF3CC52F7E")
        
@Override
        public synchronized void close() throws IOException {
            channel.close();
        }
        
    }
    
    private static class InputStreamChannel extends AbstractInterruptibleChannel implements ReadableByteChannel {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:57.647 -0500", hash_original_field = "219F81106B069BE15533E4B7BAC5527C", hash_generated_field = "92444C781A1F5D159CDAA9528EFB69D8")

        private  InputStream inputStream;

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:57.650 -0500", hash_original_method = "A25A8E5B09A21DDDF92BB065F8D65F54", hash_generated_method = "A25A8E5B09A21DDDF92BB065F8D65F54")
        
InputStreamChannel(InputStream inputStream) {
            if (inputStream == null) {
                throw new NullPointerException();
            }
            this.inputStream = inputStream;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:57.653 -0500", hash_original_method = "34EE1F263C45AAE8882B54B20392574C", hash_generated_method = "00C5CF0C247E8A6B8E801896DB58BCCF")
        
public synchronized int read(ByteBuffer target) throws IOException {
            if (!isOpen()) {
                throw new ClosedChannelException();
            }
            int bytesRemain = target.remaining();
            byte[] bytes = new byte[bytesRemain];
            int readCount = 0;
            try {
                begin();
                readCount = inputStream.read(bytes);
            } finally {
                end(readCount >= 0);
            }
            if (readCount > 0) {
                target.put(bytes, 0, readCount);
            }
            return readCount;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:57.655 -0500", hash_original_method = "1AEDCC092312326A1B846FAEB331BDCE", hash_generated_method = "699CD466FF51AF39DE58FAAC85355A3F")
        
@Override
        protected void implCloseChannel() throws IOException {
            inputStream.close();
        }
        
    }
    
    private static class OutputStreamChannel extends AbstractInterruptibleChannel implements WritableByteChannel {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:57.661 -0500", hash_original_field = "661AC26F0CF33AB40D90D727DEB87E17", hash_generated_field = "765C7DA707EC84D85188E77508C6D245")

        private  OutputStream outputStream;

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:57.664 -0500", hash_original_method = "E7CFE65BD19B3A8BD37EE9992015F72E", hash_generated_method = "E7CFE65BD19B3A8BD37EE9992015F72E")
        
OutputStreamChannel(OutputStream outputStream) {
            if (outputStream == null) {
                throw new NullPointerException();
            }
            this.outputStream = outputStream;
        }

        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:57.667 -0500", hash_original_method = "F8CFBFA38C000301E03B217F2F97CA8F", hash_generated_method = "4AF989810D5B85B30F3380D1C2BB8FCA")
        
public synchronized int write(ByteBuffer source) throws IOException {
            if (!isOpen()) {
                throw new ClosedChannelException();
            }
            int bytesRemain = source.remaining();
            if (bytesRemain == 0) {
                return 0;
            }
            byte[] buf = new byte[bytesRemain];
            source.get(buf);
            try {
                begin();
                outputStream.write(buf, 0, bytesRemain);
            } finally {
                end(bytesRemain >= 0);
            }
            return bytesRemain;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:57.669 -0500", hash_original_method = "E7378E9CB2C67269427FA20438587EF6", hash_generated_method = "BD60E6259D7810C44ADBB6E883CA32AB")
        
@Override
        protected void implCloseChannel() throws IOException {
            outputStream.close();
        }
        
    }
    
}

