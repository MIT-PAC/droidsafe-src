package java.nio.channels;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.431 -0400", hash_original_method = "E5756BC98BED6794F2A2668CF27D9D40", hash_generated_method = "A3FFC3FD46BE47AAF4DAB2140E96D8E8")
    private  Channels() {
        // ---------- Original Method ----------
    }

    
        public static InputStream newInputStream(ReadableByteChannel channel) {
        return new ChannelInputStream(channel);
    }

    
        public static OutputStream newOutputStream(WritableByteChannel channel) {
        return new ChannelOutputStream(channel);
    }

    
        public static ReadableByteChannel newChannel(InputStream inputStream) {
        return new InputStreamChannel(inputStream);
    }

    
        public static WritableByteChannel newChannel(OutputStream outputStream) {
        return new OutputStreamChannel(outputStream);
    }

    
        public static Reader newReader(ReadableByteChannel channel,
            CharsetDecoder decoder, int minBufferCapacity) {
        return new InputStreamReader(new ChannelInputStream(channel), decoder);
    }

    
        public static Reader newReader(ReadableByteChannel channel,
            String charsetName) {
        if (charsetName == null) {
            throw new NullPointerException();
        }
        return newReader(channel, Charset.forName(charsetName).newDecoder(), -1);
    }

    
        public static Writer newWriter(WritableByteChannel channel,
            CharsetEncoder encoder, int minBufferCapacity) {
        return new OutputStreamWriter(new ChannelOutputStream(channel), encoder);
    }

    
        public static Writer newWriter(WritableByteChannel channel,
            String charsetName) {
        if (charsetName == null) {
            throw new NullPointerException();
        }
        return newWriter(channel, Charset.forName(charsetName).newEncoder(), -1);
    }

    
        static void checkBlocking(Channel channel) {
        if (channel instanceof SelectableChannel && !((SelectableChannel) channel).isBlocking()) {
            throw new IllegalBlockingModeException();
        }
    }

    
    private static class ChannelInputStream extends InputStream {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.454 -0400", hash_original_field = "C485D2ED5CC4CE64FCCCCA710C7A0BB7", hash_generated_field = "CAD34F506A7F52021B790F3A2404CE8C")

        private ReadableByteChannel channel;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.456 -0400", hash_original_method = "80B02113EE3067DF952BBE67BFAA654C", hash_generated_method = "894B16270278E671B6A427F7C4C8216D")
          ChannelInputStream(ReadableByteChannel channel) {
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            } //End block
            this.channel = channel;
            // ---------- Original Method ----------
            //if (channel == null) {
                //throw new NullPointerException();
            //}
            //this.channel = channel;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.465 -0400", hash_original_method = "DEBABCFB0D5C81DCE0E37961227F43C9", hash_generated_method = "923B5C8D872CD7C40FE110606599C1FC")
        @Override
        public synchronized int read() throws IOException {
            int var27157AD7296922C5499EDCD13E8A2ED8_651348363 = (Streams.readSingleByte(this));
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_476107549 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_476107549;
            // ---------- Original Method ----------
            //return Streams.readSingleByte(this);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.465 -0400", hash_original_method = "1AE7B72C96392B3D0D4F989CF18659AC", hash_generated_method = "869E711DBBD830FE0450E6D0B3A67F70")
        @Override
        public synchronized int read(byte[] target, int offset, int length) throws IOException {
            ByteBuffer buffer;
            buffer = ByteBuffer.wrap(target, offset, length);
            checkBlocking(channel);
            int varE3E35279DE06D3BF89BF188DDFC075CE_1923469787 = (channel.read(buffer));
            addTaint(target[0]);
            addTaint(offset);
            addTaint(length);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_728070613 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_728070613;
            // ---------- Original Method ----------
            //ByteBuffer buffer = ByteBuffer.wrap(target, offset, length);
            //checkBlocking(channel);
            //return channel.read(buffer);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.479 -0400", hash_original_method = "8AF6429D1717D8D7E12FE07FE6FDB12A", hash_generated_method = "03FDCDC285630187F609C323E31C3C7F")
        @Override
        public int available() throws IOException {
            {
                FileChannel fileChannel;
                fileChannel = (FileChannel) channel;
                long result;
                result = fileChannel.size() - fileChannel.position();
            } //End block
            {
                int var6698ECBC27A3D6C11D735685C1254F7A_2081251769 = (super.available());
            } //End block
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1989675066 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1989675066;
            // ---------- Original Method ----------
            //if (channel instanceof FileChannel) {
                //FileChannel fileChannel = (FileChannel) channel;
                //long result = fileChannel.size() - fileChannel.position();
                //return result > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) result;
            //} else {
                //return super.available();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.479 -0400", hash_original_method = "E57206FE07E33F2E755E86DBBBAE8BDB", hash_generated_method = "51E8E89527ADE3CB15306C89A9368A90")
        @Override
        public synchronized void close() throws IOException {
            channel.close();
            // ---------- Original Method ----------
            //channel.close();
        }

        
    }


    
    private static class ChannelOutputStream extends OutputStream {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.479 -0400", hash_original_field = "C485D2ED5CC4CE64FCCCCA710C7A0BB7", hash_generated_field = "F18845F3B98BBBDA823B047CD34AFB03")

        private WritableByteChannel channel;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.479 -0400", hash_original_method = "1089F5ED21B35830343C54EE52895DB5", hash_generated_method = "C5B31786C2F3F7C51FBE8FCFE55D7F38")
          ChannelOutputStream(WritableByteChannel channel) {
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            } //End block
            this.channel = channel;
            // ---------- Original Method ----------
            //if (channel == null) {
                //throw new NullPointerException();
            //}
            //this.channel = channel;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.479 -0400", hash_original_method = "976097BC4C10B6759034E4B1EDA42187", hash_generated_method = "4E0918702F58C022EEC4E11CA4E9FA8F")
        @Override
        public synchronized void write(int oneByte) throws IOException {
            byte[] wrappedByte;
            write(wrappedByte);
            addTaint(oneByte);
            // ---------- Original Method ----------
            //byte[] wrappedByte = { (byte) oneByte };
            //write(wrappedByte);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.480 -0400", hash_original_method = "BF3010B4A99B9EE523BF774883EC19AF", hash_generated_method = "087E8BAA068D5514CA7D06D0684AFF04")
        @Override
        public synchronized void write(byte[] source, int offset, int length) throws IOException {
            ByteBuffer buffer;
            buffer = ByteBuffer.wrap(source, offset, length);
            checkBlocking(channel);
            int total;
            total = 0;
            {
                total += channel.write(buffer);
            } //End block
            addTaint(source[0]);
            addTaint(offset);
            addTaint(length);
            // ---------- Original Method ----------
            //ByteBuffer buffer = ByteBuffer.wrap(source, offset, length);
            //checkBlocking(channel);
            //int total = 0;
            //while (total < length) {
                //total += channel.write(buffer);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.480 -0400", hash_original_method = "E57206FE07E33F2E755E86DBBBAE8BDB", hash_generated_method = "51E8E89527ADE3CB15306C89A9368A90")
        @Override
        public synchronized void close() throws IOException {
            channel.close();
            // ---------- Original Method ----------
            //channel.close();
        }

        
    }


    
    private static class InputStreamChannel extends AbstractInterruptibleChannel implements ReadableByteChannel {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.480 -0400", hash_original_field = "267171E6BFB2A04E5670F3CE06C59060", hash_generated_field = "92444C781A1F5D159CDAA9528EFB69D8")

        private InputStream inputStream;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.481 -0400", hash_original_method = "A25A8E5B09A21DDDF92BB065F8D65F54", hash_generated_method = "6BD6199EF66E83021E48C7E331D248FD")
          InputStreamChannel(InputStream inputStream) {
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            } //End block
            this.inputStream = inputStream;
            // ---------- Original Method ----------
            //if (inputStream == null) {
                //throw new NullPointerException();
            //}
            //this.inputStream = inputStream;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.484 -0400", hash_original_method = "34EE1F263C45AAE8882B54B20392574C", hash_generated_method = "E3CD8B7D6132E97456C43BF37CE5610C")
        public synchronized int read(ByteBuffer target) throws IOException {
            {
                boolean varC984E2D68DED4A73C5D827F4E91A6961_1714200302 = (!isOpen());
                {
                    if (DroidSafeAndroidRuntime.control) throw new ClosedChannelException();
                } //End block
            } //End collapsed parenthetic
            int bytesRemain;
            bytesRemain = target.remaining();
            byte[] bytes;
            bytes = new byte[bytesRemain];
            int readCount;
            readCount = 0;
            try 
            {
                begin();
                readCount = inputStream.read(bytes);
            } //End block
            finally 
            {
                end(readCount >= 0);
            } //End block
            {
                target.put(bytes, 0, readCount);
            } //End block
            addTaint(target.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_749977851 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_749977851;
            // ---------- Original Method ----------
            //if (!isOpen()) {
                //throw new ClosedChannelException();
            //}
            //int bytesRemain = target.remaining();
            //byte[] bytes = new byte[bytesRemain];
            //int readCount = 0;
            //try {
                //begin();
                //readCount = inputStream.read(bytes);
            //} finally {
                //end(readCount >= 0);
            //}
            //if (readCount > 0) {
                //target.put(bytes, 0, readCount);
            //}
            //return readCount;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.498 -0400", hash_original_method = "1AEDCC092312326A1B846FAEB331BDCE", hash_generated_method = "9DAE26C6AEABA35FBD27E342B3905BDD")
        @Override
        protected void implCloseChannel() throws IOException {
            inputStream.close();
            // ---------- Original Method ----------
            //inputStream.close();
        }

        
    }


    
    private static class OutputStreamChannel extends AbstractInterruptibleChannel implements WritableByteChannel {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.498 -0400", hash_original_field = "BE2DEEC210B01069983CFC5912275FFC", hash_generated_field = "765C7DA707EC84D85188E77508C6D245")

        private OutputStream outputStream;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.499 -0400", hash_original_method = "E7CFE65BD19B3A8BD37EE9992015F72E", hash_generated_method = "3F1F59D48B70CFBBCD68C8E7490C06BD")
          OutputStreamChannel(OutputStream outputStream) {
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            } //End block
            this.outputStream = outputStream;
            // ---------- Original Method ----------
            //if (outputStream == null) {
                //throw new NullPointerException();
            //}
            //this.outputStream = outputStream;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.499 -0400", hash_original_method = "F8CFBFA38C000301E03B217F2F97CA8F", hash_generated_method = "DBFD521D6D71037660BC4FCF1553044E")
        public synchronized int write(ByteBuffer source) throws IOException {
            {
                boolean varC984E2D68DED4A73C5D827F4E91A6961_1599134676 = (!isOpen());
                {
                    if (DroidSafeAndroidRuntime.control) throw new ClosedChannelException();
                } //End block
            } //End collapsed parenthetic
            int bytesRemain;
            bytesRemain = source.remaining();
            byte[] buf;
            buf = new byte[bytesRemain];
            source.get(buf);
            try 
            {
                begin();
                outputStream.write(buf, 0, bytesRemain);
            } //End block
            finally 
            {
                end(bytesRemain >= 0);
            } //End block
            addTaint(source.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_599757501 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_599757501;
            // ---------- Original Method ----------
            //if (!isOpen()) {
                //throw new ClosedChannelException();
            //}
            //int bytesRemain = source.remaining();
            //if (bytesRemain == 0) {
                //return 0;
            //}
            //byte[] buf = new byte[bytesRemain];
            //source.get(buf);
            //try {
                //begin();
                //outputStream.write(buf, 0, bytesRemain);
            //} finally {
                //end(bytesRemain >= 0);
            //}
            //return bytesRemain;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.500 -0400", hash_original_method = "E7378E9CB2C67269427FA20438587EF6", hash_generated_method = "7C4C50F1CA9FCCC92A8A392AB23C46A3")
        @Override
        protected void implCloseChannel() throws IOException {
            outputStream.close();
            // ---------- Original Method ----------
            //outputStream.close();
        }

        
    }


    
}

