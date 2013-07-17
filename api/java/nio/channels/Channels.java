package java.nio.channels;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.130 -0400", hash_original_method = "E5756BC98BED6794F2A2668CF27D9D40", hash_generated_method = "A3FFC3FD46BE47AAF4DAB2140E96D8E8")
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    static void checkBlocking(Channel channel) {
        if (channel instanceof SelectableChannel && !((SelectableChannel) channel).isBlocking()) {
            throw new IllegalBlockingModeException();
        }
    }

    
    private static class ChannelInputStream extends InputStream {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.132 -0400", hash_original_field = "C485D2ED5CC4CE64FCCCCA710C7A0BB7", hash_generated_field = "CAD34F506A7F52021B790F3A2404CE8C")

        private ReadableByteChannel channel;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.133 -0400", hash_original_method = "80B02113EE3067DF952BBE67BFAA654C", hash_generated_method = "21C6821F96D8584F022E5D784453F00F")
          ChannelInputStream(ReadableByteChannel channel) {
            if(channel == null)            
            {
                NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_137312700 = new NullPointerException();
                var7338BC9F48D81FE0BBD6183F4014DCC4_137312700.addTaint(taint);
                throw var7338BC9F48D81FE0BBD6183F4014DCC4_137312700;
            } //End block
            this.channel = channel;
            // ---------- Original Method ----------
            //if (channel == null) {
                //throw new NullPointerException();
            //}
            //this.channel = channel;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.133 -0400", hash_original_method = "DEBABCFB0D5C81DCE0E37961227F43C9", hash_generated_method = "7381F115258A431FE75CB8A335779D4F")
        @Override
        public synchronized int read() throws IOException {
            int varC29A5AE95A30EE64395CAB97F32FA4B0_264795878 = (Streams.readSingleByte(this));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1169101728 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1169101728;
            // ---------- Original Method ----------
            //return Streams.readSingleByte(this);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.134 -0400", hash_original_method = "1AE7B72C96392B3D0D4F989CF18659AC", hash_generated_method = "6515E5C4BE07BCA9B429912D88F691E2")
        @Override
        public synchronized int read(byte[] target, int offset, int length) throws IOException {
            addTaint(length);
            addTaint(offset);
            addTaint(target[0]);
            ByteBuffer buffer = ByteBuffer.wrap(target, offset, length);
            checkBlocking(channel);
            int var05A0862A70F970EF4987A45F5B311658_1394470067 = (channel.read(buffer));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1907514214 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1907514214;
            // ---------- Original Method ----------
            //ByteBuffer buffer = ByteBuffer.wrap(target, offset, length);
            //checkBlocking(channel);
            //return channel.read(buffer);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.134 -0400", hash_original_method = "8AF6429D1717D8D7E12FE07FE6FDB12A", hash_generated_method = "17A9E2AD3428BF9C084803EC8335BEAD")
        @Override
        public int available() throws IOException {
            if(channel instanceof FileChannel)            
            {
                FileChannel fileChannel = (FileChannel) channel;
                long result = fileChannel.size() - fileChannel.position();
                int var10672B7CFD0677E520DF08DA1D5AFB60_1979023488 = (result > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) result);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1386163323 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1386163323;
            } //End block
            else
            {
                int varCCBDC8EC9CFFD338AA68EE17A00D45BD_1767414155 = (super.available());
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1578182514 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1578182514;
            } //End block
            // ---------- Original Method ----------
            //if (channel instanceof FileChannel) {
                //FileChannel fileChannel = (FileChannel) channel;
                //long result = fileChannel.size() - fileChannel.position();
                //return result > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) result;
            //} else {
                //return super.available();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.135 -0400", hash_original_method = "E57206FE07E33F2E755E86DBBBAE8BDB", hash_generated_method = "51E8E89527ADE3CB15306C89A9368A90")
        @Override
        public synchronized void close() throws IOException {
            channel.close();
            // ---------- Original Method ----------
            //channel.close();
        }

        
    }


    
    private static class ChannelOutputStream extends OutputStream {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.135 -0400", hash_original_field = "C485D2ED5CC4CE64FCCCCA710C7A0BB7", hash_generated_field = "F18845F3B98BBBDA823B047CD34AFB03")

        private WritableByteChannel channel;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.135 -0400", hash_original_method = "1089F5ED21B35830343C54EE52895DB5", hash_generated_method = "16C5657581E860E4AD03240A0877E313")
          ChannelOutputStream(WritableByteChannel channel) {
            if(channel == null)            
            {
                NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_722007105 = new NullPointerException();
                var7338BC9F48D81FE0BBD6183F4014DCC4_722007105.addTaint(taint);
                throw var7338BC9F48D81FE0BBD6183F4014DCC4_722007105;
            } //End block
            this.channel = channel;
            // ---------- Original Method ----------
            //if (channel == null) {
                //throw new NullPointerException();
            //}
            //this.channel = channel;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.136 -0400", hash_original_method = "976097BC4C10B6759034E4B1EDA42187", hash_generated_method = "4C606B80DE4DA46CEAB43170781F703F")
        @Override
        public synchronized void write(int oneByte) throws IOException {
            addTaint(oneByte);
            byte[] wrappedByte = { (byte) oneByte };
            write(wrappedByte);
            // ---------- Original Method ----------
            //byte[] wrappedByte = { (byte) oneByte };
            //write(wrappedByte);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.136 -0400", hash_original_method = "BF3010B4A99B9EE523BF774883EC19AF", hash_generated_method = "1DAB1B9D53D8EE1B976286C1C07E48AE")
        @Override
        public synchronized void write(byte[] source, int offset, int length) throws IOException {
            addTaint(length);
            addTaint(offset);
            addTaint(source[0]);
            ByteBuffer buffer = ByteBuffer.wrap(source, offset, length);
            checkBlocking(channel);
            int total = 0;
            while
(total < length)            
            {
                total += channel.write(buffer);
            } //End block
            // ---------- Original Method ----------
            //ByteBuffer buffer = ByteBuffer.wrap(source, offset, length);
            //checkBlocking(channel);
            //int total = 0;
            //while (total < length) {
                //total += channel.write(buffer);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.136 -0400", hash_original_method = "E57206FE07E33F2E755E86DBBBAE8BDB", hash_generated_method = "51E8E89527ADE3CB15306C89A9368A90")
        @Override
        public synchronized void close() throws IOException {
            channel.close();
            // ---------- Original Method ----------
            //channel.close();
        }

        
    }


    
    private static class InputStreamChannel extends AbstractInterruptibleChannel implements ReadableByteChannel {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.137 -0400", hash_original_field = "267171E6BFB2A04E5670F3CE06C59060", hash_generated_field = "92444C781A1F5D159CDAA9528EFB69D8")

        private InputStream inputStream;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.137 -0400", hash_original_method = "A25A8E5B09A21DDDF92BB065F8D65F54", hash_generated_method = "9FFAA49C1B856070E26C9E747CBFD297")
          InputStreamChannel(InputStream inputStream) {
            if(inputStream == null)            
            {
                NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1553403567 = new NullPointerException();
                var7338BC9F48D81FE0BBD6183F4014DCC4_1553403567.addTaint(taint);
                throw var7338BC9F48D81FE0BBD6183F4014DCC4_1553403567;
            } //End block
            this.inputStream = inputStream;
            // ---------- Original Method ----------
            //if (inputStream == null) {
                //throw new NullPointerException();
            //}
            //this.inputStream = inputStream;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.138 -0400", hash_original_method = "34EE1F263C45AAE8882B54B20392574C", hash_generated_method = "FECF5BF319814906AC88D51D1A72703E")
        public synchronized int read(ByteBuffer target) throws IOException {
            addTaint(target.getTaint());
            if(!isOpen())            
            {
                ClosedChannelException var553E3C0ED28F94CE76A7A8061DFFDCF3_446428414 = new ClosedChannelException();
                var553E3C0ED28F94CE76A7A8061DFFDCF3_446428414.addTaint(taint);
                throw var553E3C0ED28F94CE76A7A8061DFFDCF3_446428414;
            } //End block
            int bytesRemain = target.remaining();
            byte[] bytes = new byte[bytesRemain];
            int readCount = 0;
            try 
            {
                begin();
                readCount = inputStream.read(bytes);
            } //End block
            finally 
            {
                end(readCount >= 0);
            } //End block
            if(readCount > 0)            
            {
                target.put(bytes, 0, readCount);
            } //End block
            int varADC9E8D761A52E26BEC5404508AFC000_1766191628 = (readCount);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_349939631 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_349939631;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.138 -0400", hash_original_method = "1AEDCC092312326A1B846FAEB331BDCE", hash_generated_method = "9DAE26C6AEABA35FBD27E342B3905BDD")
        @Override
        protected void implCloseChannel() throws IOException {
            inputStream.close();
            // ---------- Original Method ----------
            //inputStream.close();
        }

        
    }


    
    private static class OutputStreamChannel extends AbstractInterruptibleChannel implements WritableByteChannel {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.138 -0400", hash_original_field = "BE2DEEC210B01069983CFC5912275FFC", hash_generated_field = "765C7DA707EC84D85188E77508C6D245")

        private OutputStream outputStream;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.139 -0400", hash_original_method = "E7CFE65BD19B3A8BD37EE9992015F72E", hash_generated_method = "64C29076C503C82C34902C7B775E41CE")
          OutputStreamChannel(OutputStream outputStream) {
            if(outputStream == null)            
            {
                NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_878760987 = new NullPointerException();
                var7338BC9F48D81FE0BBD6183F4014DCC4_878760987.addTaint(taint);
                throw var7338BC9F48D81FE0BBD6183F4014DCC4_878760987;
            } //End block
            this.outputStream = outputStream;
            // ---------- Original Method ----------
            //if (outputStream == null) {
                //throw new NullPointerException();
            //}
            //this.outputStream = outputStream;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.139 -0400", hash_original_method = "F8CFBFA38C000301E03B217F2F97CA8F", hash_generated_method = "4989C022B2FE43C09D64A4FAB3B3531A")
        public synchronized int write(ByteBuffer source) throws IOException {
            addTaint(source.getTaint());
            if(!isOpen())            
            {
                ClosedChannelException var553E3C0ED28F94CE76A7A8061DFFDCF3_693639081 = new ClosedChannelException();
                var553E3C0ED28F94CE76A7A8061DFFDCF3_693639081.addTaint(taint);
                throw var553E3C0ED28F94CE76A7A8061DFFDCF3_693639081;
            } //End block
            int bytesRemain = source.remaining();
            if(bytesRemain == 0)            
            {
                int varCFCD208495D565EF66E7DFF9F98764DA_2144296134 = (0);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1678954938 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1678954938;
            } //End block
            byte[] buf = new byte[bytesRemain];
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
            int varA1D047EA9354214BE040E1E8C9D69DBC_2137405477 = (bytesRemain);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2021437606 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2021437606;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.140 -0400", hash_original_method = "E7378E9CB2C67269427FA20438587EF6", hash_generated_method = "7C4C50F1CA9FCCC92A8A392AB23C46A3")
        @Override
        protected void implCloseChannel() throws IOException {
            outputStream.close();
            // ---------- Original Method ----------
            //outputStream.close();
        }

        
    }


    
}

