package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
    private PipeSinkChannel sink;
    private PipeSourceChannel source;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.862 -0400", hash_original_method = "9FBC1B65DC8611548C416344C4B3828B", hash_generated_method = "EC59D5A7A6FE1168DB350357A4001730")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PipeImpl() throws IOException {
        try 
        {
            FileDescriptor[] fds;
            fds = Libcore.os.pipe();
            this.sink = new PipeSinkChannel(fds[1]);
            this.source = new PipeSourceChannel(fds[0]);
        } //End block
        catch (ErrnoException errnoException)
        {
            if (DroidSafeAndroidRuntime.control) throw errnoException.rethrowAsIOException();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.862 -0400", hash_original_method = "C0C603D3286C71D643834A21D35D5621", hash_generated_method = "210AE0D3E7602A3A0752F83F0299AF7A")
    @DSModeled(DSC.SAFE)
    @Override
    public SinkChannel sink() {
        return (SinkChannel)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return sink;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.862 -0400", hash_original_method = "06051B335F1A44C7022D361E395E201A", hash_generated_method = "0832A949561AED69804E4BAEC9D1B5DA")
    @DSModeled(DSC.SAFE)
    @Override
    public SourceChannel source() {
        return (SourceChannel)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return source;
    }

    
    private static class FdCloser implements Closeable {
        private FileDescriptor fd;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.862 -0400", hash_original_method = "86C415C3CB1DC768FC064168AEB16626", hash_generated_method = "BFB492161C7CF02D0D50D58355D0D3EE")
        @DSModeled(DSC.SAFE)
        private FdCloser(FileDescriptor fd) {
            dsTaint.addTaint(fd.dsTaint);
            // ---------- Original Method ----------
            //this.fd = fd;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.862 -0400", hash_original_method = "086A2D08812022B74CB094B0E86783F6", hash_generated_method = "6B149A865F845EB3A84DA324127301FE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void close() throws IOException {
            IoUtils.close(fd);
            // ---------- Original Method ----------
            //IoUtils.close(fd);
        }

        
    }


    
    private class PipeSourceChannel extends Pipe.SourceChannel implements FileDescriptorChannel {
        private FileDescriptor fd;
        private FileChannel channel;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.862 -0400", hash_original_method = "33BC96484154D3DFFF55B74BB77FE001", hash_generated_method = "96CFA5F2BBE1E8150E0A36A7BF7C3E31")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private PipeSourceChannel(FileDescriptor fd) throws IOException {
            super(SelectorProvider.provider());
            dsTaint.addTaint(fd.dsTaint);
            this.channel = NioUtils.newFileChannel(new FdCloser(fd), fd, O_RDONLY);
            // ---------- Original Method ----------
            //this.fd = fd;
            //this.channel = NioUtils.newFileChannel(new FdCloser(fd), fd, O_RDONLY);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.863 -0400", hash_original_method = "B84D8CC4EB02E889C1B3B1D6BF2530A5", hash_generated_method = "00751ADC217574BA51F539DD32224F97")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected void implCloseSelectableChannel() throws IOException {
            channel.close();
            // ---------- Original Method ----------
            //channel.close();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.863 -0400", hash_original_method = "0AEB9649341280866AD90F7CB8B3B26D", hash_generated_method = "15A9D5240416D58486A641BFE8CECFF2")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected void implConfigureBlocking(boolean blocking) throws IOException {
            dsTaint.addTaint(blocking);
            IoUtils.setBlocking(getFD(), blocking);
            // ---------- Original Method ----------
            //IoUtils.setBlocking(getFD(), blocking);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.863 -0400", hash_original_method = "330EC47CD6DC6EBB9C85D6C0A0075684", hash_generated_method = "5D328EEFBF8228E0C51FA559E9F61818")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public int read(ByteBuffer buffer) throws IOException {
            dsTaint.addTaint(buffer.dsTaint);
            int varE3E35279DE06D3BF89BF188DDFC075CE_367084474 = (channel.read(buffer));
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return channel.read(buffer);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.863 -0400", hash_original_method = "D5B21F29648A2C207C81CB15F85267EB", hash_generated_method = "60A830EAFF70C85438AC371F91FAA654")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public long read(ByteBuffer[] buffers) throws IOException {
            dsTaint.addTaint(buffers[0].dsTaint);
            long varA77F9A05BBAB362B7AAE3A8BB458A7E0_1266122054 = (channel.read(buffers));
            return dsTaint.getTaintLong();
            // ---------- Original Method ----------
            //return channel.read(buffers);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.863 -0400", hash_original_method = "C267B10FDAD89EFE496B4C3C55F1ACFC", hash_generated_method = "620C9B949DED773E1B6012855B5577D5")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public long read(ByteBuffer[] buffers, int offset, int length) throws IOException {
            dsTaint.addTaint(buffers[0].dsTaint);
            dsTaint.addTaint(length);
            dsTaint.addTaint(offset);
            long var69C5C67BBEF406E6BB2B9DB456FCE818_266607310 = (channel.read(buffers, offset, length));
            return dsTaint.getTaintLong();
            // ---------- Original Method ----------
            //return channel.read(buffers, offset, length);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.863 -0400", hash_original_method = "A16D8AC033B12AF5E337D988C94AB7BA", hash_generated_method = "60A88A21D094E8421E3812E611B5557E")
        @DSModeled(DSC.SAFE)
        public FileDescriptor getFD() {
            return (FileDescriptor)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return fd;
        }

        
    }


    
    private class PipeSinkChannel extends Pipe.SinkChannel implements FileDescriptorChannel {
        private FileDescriptor fd;
        private FileChannel channel;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.864 -0400", hash_original_method = "5C836BA555A80855D7261ED27E4E73AE", hash_generated_method = "C3EF709CD06E95B7D8F5594B184C6344")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private PipeSinkChannel(FileDescriptor fd) throws IOException {
            super(SelectorProvider.provider());
            dsTaint.addTaint(fd.dsTaint);
            this.channel = NioUtils.newFileChannel(new FdCloser(fd), fd, O_WRONLY);
            // ---------- Original Method ----------
            //this.fd = fd;
            //this.channel = NioUtils.newFileChannel(new FdCloser(fd), fd, O_WRONLY);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.864 -0400", hash_original_method = "B84D8CC4EB02E889C1B3B1D6BF2530A5", hash_generated_method = "00751ADC217574BA51F539DD32224F97")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected void implCloseSelectableChannel() throws IOException {
            channel.close();
            // ---------- Original Method ----------
            //channel.close();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.864 -0400", hash_original_method = "0AEB9649341280866AD90F7CB8B3B26D", hash_generated_method = "15A9D5240416D58486A641BFE8CECFF2")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected void implConfigureBlocking(boolean blocking) throws IOException {
            dsTaint.addTaint(blocking);
            IoUtils.setBlocking(getFD(), blocking);
            // ---------- Original Method ----------
            //IoUtils.setBlocking(getFD(), blocking);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.864 -0400", hash_original_method = "9BC03C30CAC8AF5ED6AA22DAB8C2126F", hash_generated_method = "3211CA078CF24CD65A68545FF9C58C0B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public int write(ByteBuffer buffer) throws IOException {
            dsTaint.addTaint(buffer.dsTaint);
            int varD33C625308AE43F89BB8311DD34CF6A5_1793903634 = (channel.write(buffer));
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return channel.write(buffer);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.864 -0400", hash_original_method = "E4E8C5CCE7619931C84A953E614C424A", hash_generated_method = "2B986F107B480C374655BE9488F77620")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public long write(ByteBuffer[] buffers) throws IOException {
            dsTaint.addTaint(buffers[0].dsTaint);
            long var8CC22DCE6BAAE02F2205631F6A2FBFF6_1793115881 = (channel.write(buffers));
            return dsTaint.getTaintLong();
            // ---------- Original Method ----------
            //return channel.write(buffers);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.864 -0400", hash_original_method = "99500A3AB82F453FF24AFFE3A364E51F", hash_generated_method = "19467FB728D4B25641EC6231879671DA")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public long write(ByteBuffer[] buffers, int offset, int length) throws IOException {
            dsTaint.addTaint(buffers[0].dsTaint);
            dsTaint.addTaint(length);
            dsTaint.addTaint(offset);
            long var27867189103625C08564386E99E9E826_241402426 = (channel.write(buffers, offset, length));
            return dsTaint.getTaintLong();
            // ---------- Original Method ----------
            //return channel.write(buffers, offset, length);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.865 -0400", hash_original_method = "A16D8AC033B12AF5E337D988C94AB7BA", hash_generated_method = "60A88A21D094E8421E3812E611B5557E")
        @DSModeled(DSC.SAFE)
        public FileDescriptor getFD() {
            return (FileDescriptor)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return fd;
        }

        
    }


    
}

