package java.nio.channels;


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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:57.418 -0400", hash_original_method = "E5756BC98BED6794F2A2668CF27D9D40", hash_generated_method = "A3FFC3FD46BE47AAF4DAB2140E96D8E8")
    private  Channels() {
        
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:57.420 -0400", hash_original_field = "C485D2ED5CC4CE64FCCCCA710C7A0BB7", hash_generated_field = "CAD34F506A7F52021B790F3A2404CE8C")

        private ReadableByteChannel channel;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:57.420 -0400", hash_original_method = "80B02113EE3067DF952BBE67BFAA654C", hash_generated_method = "B36BDE68E9FF3FD72E26D5E566105D56")
          ChannelInputStream(ReadableByteChannel channel) {
    if(channel == null)            
            {
                NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_235038925 = new NullPointerException();
                var7338BC9F48D81FE0BBD6183F4014DCC4_235038925.addTaint(taint);
                throw var7338BC9F48D81FE0BBD6183F4014DCC4_235038925;
            } 
            this.channel = channel;
            
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:57.421 -0400", hash_original_method = "DEBABCFB0D5C81DCE0E37961227F43C9", hash_generated_method = "FE21F7181669E071220121B41734220A")
        @Override
        public synchronized int read() throws IOException {
            int varC29A5AE95A30EE64395CAB97F32FA4B0_704770319 = (Streams.readSingleByte(this));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1804792685 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1804792685;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:57.421 -0400", hash_original_method = "1AE7B72C96392B3D0D4F989CF18659AC", hash_generated_method = "67925BEE2251EA20C13DD6D1F495FAA7")
        @Override
        public synchronized int read(byte[] target, int offset, int length) throws IOException {
            addTaint(length);
            addTaint(offset);
            addTaint(target[0]);
            ByteBuffer buffer = ByteBuffer.wrap(target, offset, length);
            checkBlocking(channel);
            int var05A0862A70F970EF4987A45F5B311658_690341335 = (channel.read(buffer));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1145566064 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1145566064;
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:57.421 -0400", hash_original_method = "8AF6429D1717D8D7E12FE07FE6FDB12A", hash_generated_method = "278460CCC3F954348D7F8FB95010749F")
        @Override
        public int available() throws IOException {
    if(channel instanceof FileChannel)            
            {
                FileChannel fileChannel = (FileChannel) channel;
                long result = fileChannel.size() - fileChannel.position();
                int var10672B7CFD0677E520DF08DA1D5AFB60_336994158 = (result > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) result);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_12841667 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_12841667;
            } 
            else
            {
                int varCCBDC8EC9CFFD338AA68EE17A00D45BD_91615826 = (super.available());
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1211891797 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1211891797;
            } 
            
            
                
                
                
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:57.422 -0400", hash_original_method = "E57206FE07E33F2E755E86DBBBAE8BDB", hash_generated_method = "51E8E89527ADE3CB15306C89A9368A90")
        @Override
        public synchronized void close() throws IOException {
            channel.close();
            
            
        }

        
    }


    
    private static class ChannelOutputStream extends OutputStream {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:57.422 -0400", hash_original_field = "C485D2ED5CC4CE64FCCCCA710C7A0BB7", hash_generated_field = "F18845F3B98BBBDA823B047CD34AFB03")

        private WritableByteChannel channel;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:57.423 -0400", hash_original_method = "1089F5ED21B35830343C54EE52895DB5", hash_generated_method = "E63D9486EF042C641686EE8F6DB86389")
          ChannelOutputStream(WritableByteChannel channel) {
    if(channel == null)            
            {
                NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_626788153 = new NullPointerException();
                var7338BC9F48D81FE0BBD6183F4014DCC4_626788153.addTaint(taint);
                throw var7338BC9F48D81FE0BBD6183F4014DCC4_626788153;
            } 
            this.channel = channel;
            
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:57.423 -0400", hash_original_method = "976097BC4C10B6759034E4B1EDA42187", hash_generated_method = "4C606B80DE4DA46CEAB43170781F703F")
        @Override
        public synchronized void write(int oneByte) throws IOException {
            addTaint(oneByte);
            byte[] wrappedByte = { (byte) oneByte };
            write(wrappedByte);
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:57.424 -0400", hash_original_method = "BF3010B4A99B9EE523BF774883EC19AF", hash_generated_method = "1DAB1B9D53D8EE1B976286C1C07E48AE")
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
            } 
            
            
            
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:57.424 -0400", hash_original_method = "E57206FE07E33F2E755E86DBBBAE8BDB", hash_generated_method = "51E8E89527ADE3CB15306C89A9368A90")
        @Override
        public synchronized void close() throws IOException {
            channel.close();
            
            
        }

        
    }


    
    private static class InputStreamChannel extends AbstractInterruptibleChannel implements ReadableByteChannel {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:57.424 -0400", hash_original_field = "267171E6BFB2A04E5670F3CE06C59060", hash_generated_field = "92444C781A1F5D159CDAA9528EFB69D8")

        private InputStream inputStream;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:57.425 -0400", hash_original_method = "A25A8E5B09A21DDDF92BB065F8D65F54", hash_generated_method = "C1F0E7322465CF12CE85FA7B280F1198")
          InputStreamChannel(InputStream inputStream) {
    if(inputStream == null)            
            {
                NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_267661861 = new NullPointerException();
                var7338BC9F48D81FE0BBD6183F4014DCC4_267661861.addTaint(taint);
                throw var7338BC9F48D81FE0BBD6183F4014DCC4_267661861;
            } 
            this.inputStream = inputStream;
            
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:57.425 -0400", hash_original_method = "34EE1F263C45AAE8882B54B20392574C", hash_generated_method = "B160BB715F0AF3CF84681F4812A86F5D")
        public synchronized int read(ByteBuffer target) throws IOException {
            addTaint(target.getTaint());
    if(!isOpen())            
            {
                ClosedChannelException var553E3C0ED28F94CE76A7A8061DFFDCF3_1091767867 = new ClosedChannelException();
                var553E3C0ED28F94CE76A7A8061DFFDCF3_1091767867.addTaint(taint);
                throw var553E3C0ED28F94CE76A7A8061DFFDCF3_1091767867;
            } 
            int bytesRemain = target.remaining();
            byte[] bytes = new byte[bytesRemain];
            int readCount = 0;
            try 
            {
                begin();
                readCount = inputStream.read(bytes);
            } 
            finally 
            {
                end(readCount >= 0);
            } 
    if(readCount > 0)            
            {
                target.put(bytes, 0, readCount);
            } 
            int varADC9E8D761A52E26BEC5404508AFC000_974317614 = (readCount);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_672242847 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_672242847;
            
            
                
            
            
            
            
            
                
                
            
                
            
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:57.426 -0400", hash_original_method = "1AEDCC092312326A1B846FAEB331BDCE", hash_generated_method = "9DAE26C6AEABA35FBD27E342B3905BDD")
        @Override
        protected void implCloseChannel() throws IOException {
            inputStream.close();
            
            
        }

        
    }


    
    private static class OutputStreamChannel extends AbstractInterruptibleChannel implements WritableByteChannel {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:57.426 -0400", hash_original_field = "BE2DEEC210B01069983CFC5912275FFC", hash_generated_field = "765C7DA707EC84D85188E77508C6D245")

        private OutputStream outputStream;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:57.426 -0400", hash_original_method = "E7CFE65BD19B3A8BD37EE9992015F72E", hash_generated_method = "51DB5396EFDA4DC5E9E53A405B94A5ED")
          OutputStreamChannel(OutputStream outputStream) {
    if(outputStream == null)            
            {
                NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1822450144 = new NullPointerException();
                var7338BC9F48D81FE0BBD6183F4014DCC4_1822450144.addTaint(taint);
                throw var7338BC9F48D81FE0BBD6183F4014DCC4_1822450144;
            } 
            this.outputStream = outputStream;
            
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:57.426 -0400", hash_original_method = "F8CFBFA38C000301E03B217F2F97CA8F", hash_generated_method = "33503661EE90DCEA0AA6DFDDCD1B4779")
        public synchronized int write(ByteBuffer source) throws IOException {
            addTaint(source.getTaint());
    if(!isOpen())            
            {
                ClosedChannelException var553E3C0ED28F94CE76A7A8061DFFDCF3_1063322813 = new ClosedChannelException();
                var553E3C0ED28F94CE76A7A8061DFFDCF3_1063322813.addTaint(taint);
                throw var553E3C0ED28F94CE76A7A8061DFFDCF3_1063322813;
            } 
            int bytesRemain = source.remaining();
    if(bytesRemain == 0)            
            {
                int varCFCD208495D565EF66E7DFF9F98764DA_1920249267 = (0);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_319544271 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_319544271;
            } 
            byte[] buf = new byte[bytesRemain];
            source.get(buf);
            try 
            {
                begin();
                outputStream.write(buf, 0, bytesRemain);
            } 
            finally 
            {
                end(bytesRemain >= 0);
            } 
            int varA1D047EA9354214BE040E1E8C9D69DBC_2002898050 = (bytesRemain);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1436833910 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1436833910;
            
            
                
            
            
            
                
            
            
            
            
                
                
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:57.427 -0400", hash_original_method = "E7378E9CB2C67269427FA20438587EF6", hash_generated_method = "7C4C50F1CA9FCCC92A8A392AB23C46A3")
        @Override
        protected void implCloseChannel() throws IOException {
            outputStream.close();
            
            
        }

        
    }


    
}

