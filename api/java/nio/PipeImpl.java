package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.Closeable;
import java.io.FileDescriptor;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.Pipe;
import java.nio.channels.spi.SelectorProvider;
import libcore.io.ErrnoException;
import libcore.io.IoUtils;
import libcore.io.Libcore;
import static libcore.io.OsConstants.*;

final class PipeImpl extends Pipe {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.908 -0400", hash_original_field = "F6E041176F8CC2998F9465EDE0DFEEB1", hash_generated_field = "4B05C0563C4559C55245EBA97183BE45")

    private PipeSinkChannel sink;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.908 -0400", hash_original_field = "36CD38F49B9AFA08222C0DC9EBFE35EB", hash_generated_field = "5AC7FC0F0A270782C58B430F892F7E4D")

    private PipeSourceChannel source;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.912 -0400", hash_original_method = "9FBC1B65DC8611548C416344C4B3828B", hash_generated_method = "73E553CA20E1CC19244AB94618BFCD6F")
    public  PipeImpl() throws IOException {
        try 
        {
            FileDescriptor[] fds = Libcore.os.pipe();
            this.sink = new PipeSinkChannel(fds[1]);
            this.source = new PipeSourceChannel(fds[0]);
        } //End block
        catch (ErrnoException errnoException)
        {
            java.io.IOException var533DBF3F7D78874DC97ED285C3BC3B22_568702265 = errnoException.rethrowAsIOException();
            var533DBF3F7D78874DC97ED285C3BC3B22_568702265.addTaint(taint);
            throw var533DBF3F7D78874DC97ED285C3BC3B22_568702265;
        } //End block
        // ---------- Original Method ----------
        //try {
            //FileDescriptor[] fds = Libcore.os.pipe();
            //this.sink = new PipeSinkChannel(fds[1]);
            //this.source = new PipeSourceChannel(fds[0]);
        //} catch (ErrnoException errnoException) {
            //throw errnoException.rethrowAsIOException();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.912 -0400", hash_original_method = "C0C603D3286C71D643834A21D35D5621", hash_generated_method = "C030505E16C2988312C0F7B2003250DE")
    @Override
    public SinkChannel sink() {
SinkChannel var9F52798A617E8085E84A971BADA1AE49_4473272 =         sink;
        var9F52798A617E8085E84A971BADA1AE49_4473272.addTaint(taint);
        return var9F52798A617E8085E84A971BADA1AE49_4473272;
        // ---------- Original Method ----------
        //return sink;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.912 -0400", hash_original_method = "06051B335F1A44C7022D361E395E201A", hash_generated_method = "D9627D87D728EB04956F8F4135D9D7AD")
    @Override
    public SourceChannel source() {
SourceChannel var87D92E4D22D3928BDE6A72969186AF86_797869111 =         source;
        var87D92E4D22D3928BDE6A72969186AF86_797869111.addTaint(taint);
        return var87D92E4D22D3928BDE6A72969186AF86_797869111;
        // ---------- Original Method ----------
        //return source;
    }

    
    private static class FdCloser implements Closeable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.913 -0400", hash_original_field = "36EBA1E1E343279857EA7F69A597324E", hash_generated_field = "B11DAE17AB1D35227E8CB61CED7BC01D")

        private FileDescriptor fd;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.913 -0400", hash_original_method = "86C415C3CB1DC768FC064168AEB16626", hash_generated_method = "848D3F377F277155D9207132A062928F")
        private  FdCloser(FileDescriptor fd) {
            this.fd = fd;
            // ---------- Original Method ----------
            //this.fd = fd;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.913 -0400", hash_original_method = "086A2D08812022B74CB094B0E86783F6", hash_generated_method = "6B149A865F845EB3A84DA324127301FE")
        public void close() throws IOException {
            IoUtils.close(fd);
            // ---------- Original Method ----------
            //IoUtils.close(fd);
        }

        
    }


    
    private class PipeSourceChannel extends Pipe.SourceChannel implements FileDescriptorChannel {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.914 -0400", hash_original_field = "36EBA1E1E343279857EA7F69A597324E", hash_generated_field = "B11DAE17AB1D35227E8CB61CED7BC01D")

        private FileDescriptor fd;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.914 -0400", hash_original_field = "C485D2ED5CC4CE64FCCCCA710C7A0BB7", hash_generated_field = "D2F54CF06A6D02676AAD3B9CA4DD4532")

        private FileChannel channel;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.914 -0400", hash_original_method = "33BC96484154D3DFFF55B74BB77FE001", hash_generated_method = "CF2E4873AF17A736C3A570CA5370A831")
        private  PipeSourceChannel(FileDescriptor fd) throws IOException {
            super(SelectorProvider.provider());
            this.fd = fd;
            this.channel = NioUtils.newFileChannel(new FdCloser(fd), fd, O_RDONLY);
            // ---------- Original Method ----------
            //this.fd = fd;
            //this.channel = NioUtils.newFileChannel(new FdCloser(fd), fd, O_RDONLY);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.915 -0400", hash_original_method = "B84D8CC4EB02E889C1B3B1D6BF2530A5", hash_generated_method = "00751ADC217574BA51F539DD32224F97")
        @Override
        protected void implCloseSelectableChannel() throws IOException {
            channel.close();
            // ---------- Original Method ----------
            //channel.close();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.915 -0400", hash_original_method = "0AEB9649341280866AD90F7CB8B3B26D", hash_generated_method = "4F55EBE153A756EFE07A2CC19E53DF71")
        @Override
        protected void implConfigureBlocking(boolean blocking) throws IOException {
            addTaint(blocking);
            IoUtils.setBlocking(getFD(), blocking);
            // ---------- Original Method ----------
            //IoUtils.setBlocking(getFD(), blocking);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.915 -0400", hash_original_method = "330EC47CD6DC6EBB9C85D6C0A0075684", hash_generated_method = "1F22E3E9E511BB1B45EE39624879CC4B")
        public int read(ByteBuffer buffer) throws IOException {
            addTaint(buffer.getTaint());
            int var05A0862A70F970EF4987A45F5B311658_436866789 = (channel.read(buffer));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1200643131 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1200643131;
            // ---------- Original Method ----------
            //return channel.read(buffer);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.916 -0400", hash_original_method = "D5B21F29648A2C207C81CB15F85267EB", hash_generated_method = "056577FF0477EFB537AD2374FFC5D1A2")
        public long read(ByteBuffer[] buffers) throws IOException {
            addTaint(buffers[0].getTaint());
            long var40B4FFD91AB5711EEFB9BF1574CDE1AA_1415283243 = (channel.read(buffers));
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_441164377 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_441164377;
            // ---------- Original Method ----------
            //return channel.read(buffers);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.916 -0400", hash_original_method = "C267B10FDAD89EFE496B4C3C55F1ACFC", hash_generated_method = "B084EFE98B4D7092841BEC352DAF8762")
        public long read(ByteBuffer[] buffers, int offset, int length) throws IOException {
            addTaint(length);
            addTaint(offset);
            addTaint(buffers[0].getTaint());
            long varE3BCE5085F84900FC8E0366F324230C8_1591541790 = (channel.read(buffers, offset, length));
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_653938554 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_653938554;
            // ---------- Original Method ----------
            //return channel.read(buffers, offset, length);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.916 -0400", hash_original_method = "A16D8AC033B12AF5E337D988C94AB7BA", hash_generated_method = "85E864B9C17F6AC90A25753CF70618CD")
        public FileDescriptor getFD() {
FileDescriptor var020F72FC5D1BB0511CAD11CC0AA674A0_1209778611 =             fd;
            var020F72FC5D1BB0511CAD11CC0AA674A0_1209778611.addTaint(taint);
            return var020F72FC5D1BB0511CAD11CC0AA674A0_1209778611;
            // ---------- Original Method ----------
            //return fd;
        }

        
    }


    
    private class PipeSinkChannel extends Pipe.SinkChannel implements FileDescriptorChannel {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.917 -0400", hash_original_field = "36EBA1E1E343279857EA7F69A597324E", hash_generated_field = "B11DAE17AB1D35227E8CB61CED7BC01D")

        private FileDescriptor fd;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.917 -0400", hash_original_field = "C485D2ED5CC4CE64FCCCCA710C7A0BB7", hash_generated_field = "D2F54CF06A6D02676AAD3B9CA4DD4532")

        private FileChannel channel;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.917 -0400", hash_original_method = "5C836BA555A80855D7261ED27E4E73AE", hash_generated_method = "CA76B97680A2E3296B5941EA1C350CBD")
        private  PipeSinkChannel(FileDescriptor fd) throws IOException {
            super(SelectorProvider.provider());
            this.fd = fd;
            this.channel = NioUtils.newFileChannel(new FdCloser(fd), fd, O_WRONLY);
            // ---------- Original Method ----------
            //this.fd = fd;
            //this.channel = NioUtils.newFileChannel(new FdCloser(fd), fd, O_WRONLY);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.918 -0400", hash_original_method = "B84D8CC4EB02E889C1B3B1D6BF2530A5", hash_generated_method = "00751ADC217574BA51F539DD32224F97")
        @Override
        protected void implCloseSelectableChannel() throws IOException {
            channel.close();
            // ---------- Original Method ----------
            //channel.close();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.918 -0400", hash_original_method = "0AEB9649341280866AD90F7CB8B3B26D", hash_generated_method = "4F55EBE153A756EFE07A2CC19E53DF71")
        @Override
        protected void implConfigureBlocking(boolean blocking) throws IOException {
            addTaint(blocking);
            IoUtils.setBlocking(getFD(), blocking);
            // ---------- Original Method ----------
            //IoUtils.setBlocking(getFD(), blocking);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.918 -0400", hash_original_method = "9BC03C30CAC8AF5ED6AA22DAB8C2126F", hash_generated_method = "490CF95F160C1C95C04DC8CB3EC5B730")
        public int write(ByteBuffer buffer) throws IOException {
            addTaint(buffer.getTaint());
            int var183321E7C6DAB489DA3995211076854F_1918782192 = (channel.write(buffer));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_906417691 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_906417691;
            // ---------- Original Method ----------
            //return channel.write(buffer);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.919 -0400", hash_original_method = "E4E8C5CCE7619931C84A953E614C424A", hash_generated_method = "910D19BF5E8CF7FD37D844CC6CBD09BD")
        public long write(ByteBuffer[] buffers) throws IOException {
            addTaint(buffers[0].getTaint());
            long varED54120D0998E94B4D9467E773B48ECD_1847038940 = (channel.write(buffers));
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1811574014 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1811574014;
            // ---------- Original Method ----------
            //return channel.write(buffers);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.919 -0400", hash_original_method = "99500A3AB82F453FF24AFFE3A364E51F", hash_generated_method = "32B5A3DF747689AE8B5CD3AE4CECA8EF")
        public long write(ByteBuffer[] buffers, int offset, int length) throws IOException {
            addTaint(length);
            addTaint(offset);
            addTaint(buffers[0].getTaint());
            long var4F830F751FC09068EA2D97F31096FF76_2080590361 = (channel.write(buffers, offset, length));
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_872382808 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_872382808;
            // ---------- Original Method ----------
            //return channel.write(buffers, offset, length);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.920 -0400", hash_original_method = "A16D8AC033B12AF5E337D988C94AB7BA", hash_generated_method = "442F8A5F1A33A9FFCB3194F446222B4E")
        public FileDescriptor getFD() {
FileDescriptor var020F72FC5D1BB0511CAD11CC0AA674A0_1665417238 =             fd;
            var020F72FC5D1BB0511CAD11CC0AA674A0_1665417238.addTaint(taint);
            return var020F72FC5D1BB0511CAD11CC0AA674A0_1665417238;
            // ---------- Original Method ----------
            //return fd;
        }

        
    }


    
}

