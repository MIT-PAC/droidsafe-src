package java.nio;

// Droidsafe Imports
import static libcore.io.OsConstants.O_RDONLY;
import static libcore.io.OsConstants.O_WRONLY;

import java.io.Closeable;
import java.io.FileDescriptor;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.Pipe;
import java.nio.channels.spi.SelectorProvider;

import libcore.io.ErrnoException;
import libcore.io.IoUtils;
import libcore.io.Libcore;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

final class PipeImpl extends Pipe {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.436 -0400", hash_original_field = "F6E041176F8CC2998F9465EDE0DFEEB1", hash_generated_field = "4B05C0563C4559C55245EBA97183BE45")

    private PipeSinkChannel sink;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.436 -0400", hash_original_field = "36CD38F49B9AFA08222C0DC9EBFE35EB", hash_generated_field = "5AC7FC0F0A270782C58B430F892F7E4D")

    private PipeSourceChannel source;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.443 -0400", hash_original_method = "9FBC1B65DC8611548C416344C4B3828B", hash_generated_method = "E99DD80AAF20558C2BD38B31B9FC6102")
    public  PipeImpl() throws IOException {
        try 
        {
            FileDescriptor[] fds = Libcore.os.pipe();
            this.sink = new PipeSinkChannel(fds[1]);
            this.source = new PipeSourceChannel(fds[0]);
        } //End block
        catch (ErrnoException errnoException)
        {
            java.io.IOException var533DBF3F7D78874DC97ED285C3BC3B22_1823372746 = errnoException.rethrowAsIOException();
            var533DBF3F7D78874DC97ED285C3BC3B22_1823372746.addTaint(taint);
            throw var533DBF3F7D78874DC97ED285C3BC3B22_1823372746;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.444 -0400", hash_original_method = "C0C603D3286C71D643834A21D35D5621", hash_generated_method = "CF72F6BA2A0BF72173B3655809B8BE25")
    @Override
    public SinkChannel sink() {
SinkChannel var9F52798A617E8085E84A971BADA1AE49_1474111156 =         sink;
        var9F52798A617E8085E84A971BADA1AE49_1474111156.addTaint(taint);
        return var9F52798A617E8085E84A971BADA1AE49_1474111156;
        // ---------- Original Method ----------
        //return sink;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.445 -0400", hash_original_method = "06051B335F1A44C7022D361E395E201A", hash_generated_method = "A0517C34124E0805E4CE60EE3DADE587")
    @Override
    public SourceChannel source() {
SourceChannel var87D92E4D22D3928BDE6A72969186AF86_1916345077 =         source;
        var87D92E4D22D3928BDE6A72969186AF86_1916345077.addTaint(taint);
        return var87D92E4D22D3928BDE6A72969186AF86_1916345077;
        // ---------- Original Method ----------
        //return source;
    }

    
    private static class FdCloser implements Closeable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.445 -0400", hash_original_field = "36EBA1E1E343279857EA7F69A597324E", hash_generated_field = "B11DAE17AB1D35227E8CB61CED7BC01D")

        private FileDescriptor fd;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.445 -0400", hash_original_method = "86C415C3CB1DC768FC064168AEB16626", hash_generated_method = "848D3F377F277155D9207132A062928F")
        private  FdCloser(FileDescriptor fd) {
            this.fd = fd;
            // ---------- Original Method ----------
            //this.fd = fd;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.446 -0400", hash_original_method = "086A2D08812022B74CB094B0E86783F6", hash_generated_method = "6B149A865F845EB3A84DA324127301FE")
        public void close() throws IOException {
            IoUtils.close(fd);
            // ---------- Original Method ----------
            //IoUtils.close(fd);
        }

        
    }


    
    private class PipeSourceChannel extends Pipe.SourceChannel implements FileDescriptorChannel {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.446 -0400", hash_original_field = "36EBA1E1E343279857EA7F69A597324E", hash_generated_field = "B11DAE17AB1D35227E8CB61CED7BC01D")

        private FileDescriptor fd;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.446 -0400", hash_original_field = "C485D2ED5CC4CE64FCCCCA710C7A0BB7", hash_generated_field = "D2F54CF06A6D02676AAD3B9CA4DD4532")

        private FileChannel channel;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.447 -0400", hash_original_method = "33BC96484154D3DFFF55B74BB77FE001", hash_generated_method = "CF2E4873AF17A736C3A570CA5370A831")
        private  PipeSourceChannel(FileDescriptor fd) throws IOException {
            super(SelectorProvider.provider());
            this.fd = fd;
            this.channel = NioUtils.newFileChannel(new FdCloser(fd), fd, O_RDONLY);
            // ---------- Original Method ----------
            //this.fd = fd;
            //this.channel = NioUtils.newFileChannel(new FdCloser(fd), fd, O_RDONLY);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.448 -0400", hash_original_method = "B84D8CC4EB02E889C1B3B1D6BF2530A5", hash_generated_method = "00751ADC217574BA51F539DD32224F97")
        @Override
        protected void implCloseSelectableChannel() throws IOException {
            channel.close();
            // ---------- Original Method ----------
            //channel.close();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.448 -0400", hash_original_method = "0AEB9649341280866AD90F7CB8B3B26D", hash_generated_method = "4F55EBE153A756EFE07A2CC19E53DF71")
        @Override
        protected void implConfigureBlocking(boolean blocking) throws IOException {
            addTaint(blocking);
            IoUtils.setBlocking(getFD(), blocking);
            // ---------- Original Method ----------
            //IoUtils.setBlocking(getFD(), blocking);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.449 -0400", hash_original_method = "330EC47CD6DC6EBB9C85D6C0A0075684", hash_generated_method = "9F5544F3D92ED605F0AD1F21F71B8F6B")
        public int read(ByteBuffer buffer) throws IOException {
            addTaint(buffer.getTaint());
            int var05A0862A70F970EF4987A45F5B311658_341955305 = (channel.read(buffer));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_465444974 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_465444974;
            // ---------- Original Method ----------
            //return channel.read(buffer);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.449 -0400", hash_original_method = "D5B21F29648A2C207C81CB15F85267EB", hash_generated_method = "0B22E959F149539B3A31E627A1D4BC58")
        public long read(ByteBuffer[] buffers) throws IOException {
            addTaint(buffers[0].getTaint());
            long var40B4FFD91AB5711EEFB9BF1574CDE1AA_268521091 = (channel.read(buffers));
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_355555603 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_355555603;
            // ---------- Original Method ----------
            //return channel.read(buffers);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.450 -0400", hash_original_method = "C267B10FDAD89EFE496B4C3C55F1ACFC", hash_generated_method = "31C0A9F2D1433EFA189DD929BF64E911")
        public long read(ByteBuffer[] buffers, int offset, int length) throws IOException {
            addTaint(length);
            addTaint(offset);
            addTaint(buffers[0].getTaint());
            long varE3BCE5085F84900FC8E0366F324230C8_2091661718 = (channel.read(buffers, offset, length));
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1965058559 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1965058559;
            // ---------- Original Method ----------
            //return channel.read(buffers, offset, length);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.451 -0400", hash_original_method = "A16D8AC033B12AF5E337D988C94AB7BA", hash_generated_method = "19DDD9AFA4D44AD65B5658D8F9E161BE")
        public FileDescriptor getFD() {
FileDescriptor var020F72FC5D1BB0511CAD11CC0AA674A0_1707183859 =             fd;
            var020F72FC5D1BB0511CAD11CC0AA674A0_1707183859.addTaint(taint);
            return var020F72FC5D1BB0511CAD11CC0AA674A0_1707183859;
            // ---------- Original Method ----------
            //return fd;
        }

        
    }


    
    private class PipeSinkChannel extends Pipe.SinkChannel implements FileDescriptorChannel {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.451 -0400", hash_original_field = "36EBA1E1E343279857EA7F69A597324E", hash_generated_field = "B11DAE17AB1D35227E8CB61CED7BC01D")

        private FileDescriptor fd;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.451 -0400", hash_original_field = "C485D2ED5CC4CE64FCCCCA710C7A0BB7", hash_generated_field = "D2F54CF06A6D02676AAD3B9CA4DD4532")

        private FileChannel channel;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.452 -0400", hash_original_method = "5C836BA555A80855D7261ED27E4E73AE", hash_generated_method = "CA76B97680A2E3296B5941EA1C350CBD")
        private  PipeSinkChannel(FileDescriptor fd) throws IOException {
            super(SelectorProvider.provider());
            this.fd = fd;
            this.channel = NioUtils.newFileChannel(new FdCloser(fd), fd, O_WRONLY);
            // ---------- Original Method ----------
            //this.fd = fd;
            //this.channel = NioUtils.newFileChannel(new FdCloser(fd), fd, O_WRONLY);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.453 -0400", hash_original_method = "B84D8CC4EB02E889C1B3B1D6BF2530A5", hash_generated_method = "00751ADC217574BA51F539DD32224F97")
        @Override
        protected void implCloseSelectableChannel() throws IOException {
            channel.close();
            // ---------- Original Method ----------
            //channel.close();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.453 -0400", hash_original_method = "0AEB9649341280866AD90F7CB8B3B26D", hash_generated_method = "4F55EBE153A756EFE07A2CC19E53DF71")
        @Override
        protected void implConfigureBlocking(boolean blocking) throws IOException {
            addTaint(blocking);
            IoUtils.setBlocking(getFD(), blocking);
            // ---------- Original Method ----------
            //IoUtils.setBlocking(getFD(), blocking);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.453 -0400", hash_original_method = "9BC03C30CAC8AF5ED6AA22DAB8C2126F", hash_generated_method = "235FEA53CB9132077CADF970EE1BA98D")
        public int write(ByteBuffer buffer) throws IOException {
            addTaint(buffer.getTaint());
            int var183321E7C6DAB489DA3995211076854F_871888561 = (channel.write(buffer));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_343676829 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_343676829;
            // ---------- Original Method ----------
            //return channel.write(buffer);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.454 -0400", hash_original_method = "E4E8C5CCE7619931C84A953E614C424A", hash_generated_method = "7B98AC6E3F03C1B5D86ED4A283779457")
        public long write(ByteBuffer[] buffers) throws IOException {
            addTaint(buffers[0].getTaint());
            long varED54120D0998E94B4D9467E773B48ECD_215306731 = (channel.write(buffers));
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1550911173 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1550911173;
            // ---------- Original Method ----------
            //return channel.write(buffers);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.454 -0400", hash_original_method = "99500A3AB82F453FF24AFFE3A364E51F", hash_generated_method = "227E131CEDBF2D7E47F7DF213681A14A")
        public long write(ByteBuffer[] buffers, int offset, int length) throws IOException {
            addTaint(length);
            addTaint(offset);
            addTaint(buffers[0].getTaint());
            long var4F830F751FC09068EA2D97F31096FF76_666234622 = (channel.write(buffers, offset, length));
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1245840243 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1245840243;
            // ---------- Original Method ----------
            //return channel.write(buffers, offset, length);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.454 -0400", hash_original_method = "A16D8AC033B12AF5E337D988C94AB7BA", hash_generated_method = "6BB6A19F0D28E2E44C8FDFB47ADAB589")
        public FileDescriptor getFD() {
FileDescriptor var020F72FC5D1BB0511CAD11CC0AA674A0_986699347 =             fd;
            var020F72FC5D1BB0511CAD11CC0AA674A0_986699347.addTaint(taint);
            return var020F72FC5D1BB0511CAD11CC0AA674A0_986699347;
            // ---------- Original Method ----------
            //return fd;
        }

        
    }


    
}

