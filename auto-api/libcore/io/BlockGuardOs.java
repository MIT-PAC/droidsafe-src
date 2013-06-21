package libcore.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import dalvik.system.BlockGuard;
import dalvik.system.SocketTagger;
import java.io.FileDescriptor;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.nio.ByteBuffer;
import static libcore.io.OsConstants.*;

public class BlockGuardOs extends ForwardingOs {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.781 -0400", hash_original_method = "2D0FCA28E55AE009AE62E6973DC0875A", hash_generated_method = "565ECFC8289A210AE2023A09F2EB2819")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BlockGuardOs(Os os) {
        super(os);
        dsTaint.addTaint(os.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.781 -0400", hash_original_method = "C76A4564374F8B1BE91B3642FF0C847C", hash_generated_method = "D16E4AE38B62A34A8FDD053BBC333E5D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private FileDescriptor tagSocket(FileDescriptor fd) throws ErrnoException {
        dsTaint.addTaint(fd.dsTaint);
        try 
        {
            SocketTagger.get().tag(fd);
        } //End block
        catch (SocketException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new ErrnoException("socket", EINVAL, e);
        } //End block
        return (FileDescriptor)dsTaint.getTaint();
        // ---------- Original Method ----------
        //try {
            //SocketTagger.get().tag(fd);
            //return fd;
        //} catch (SocketException e) {
            //throw new ErrnoException("socket", EINVAL, e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.781 -0400", hash_original_method = "94528424D623701A416A9704EA17EE51", hash_generated_method = "9AC31453463548E10A4DAB8BAFE89DBF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void untagSocket(FileDescriptor fd) throws ErrnoException {
        dsTaint.addTaint(fd.dsTaint);
        try 
        {
            SocketTagger.get().untag(fd);
        } //End block
        catch (SocketException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new ErrnoException("socket", EINVAL, e);
        } //End block
        // ---------- Original Method ----------
        //try {
            //SocketTagger.get().untag(fd);
        //} catch (SocketException e) {
            //throw new ErrnoException("socket", EINVAL, e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.781 -0400", hash_original_method = "635584284C97FD1E7DC4024F591AB4FA", hash_generated_method = "90ABD79C77E1763D8444EF639D665271")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public FileDescriptor accept(FileDescriptor fd, InetSocketAddress peerAddress) throws ErrnoException {
        dsTaint.addTaint(peerAddress.dsTaint);
        dsTaint.addTaint(fd.dsTaint);
        BlockGuard.getThreadPolicy().onNetwork();
        FileDescriptor var5AC7700A4071426C39EA8458F9C0E502_1297197219 = (tagSocket(os.accept(fd, peerAddress)));
        return (FileDescriptor)dsTaint.getTaint();
        // ---------- Original Method ----------
        //BlockGuard.getThreadPolicy().onNetwork();
        //return tagSocket(os.accept(fd, peerAddress));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.782 -0400", hash_original_method = "5D4ED9A04E2D732CC559EB48A60FC49B", hash_generated_method = "412D7B3C8F1DDDB66B91FDC7A1C5EE81")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void close(FileDescriptor fd) throws ErrnoException {
        dsTaint.addTaint(fd.dsTaint);
        try 
        {
            {
                boolean var5BBC6B9EEEC700D6D365E57A098BE4B0_1097373327 = (S_ISSOCK(Libcore.os.fstat(fd).st_mode));
                {
                    {
                        boolean var15CAB83F9C99E6A6B679657FAA8A6045_2031874803 = (isLingerSocket(fd));
                        {
                            BlockGuard.getThreadPolicy().onNetwork();
                        } //End block
                    } //End collapsed parenthetic
                    untagSocket(fd);
                } //End block
            } //End collapsed parenthetic
        } //End block
        catch (ErrnoException ignored)
        { }
        os.close(fd);
        // ---------- Original Method ----------
        //try {
            //if (S_ISSOCK(Libcore.os.fstat(fd).st_mode)) {
                //if (isLingerSocket(fd)) {
                    //BlockGuard.getThreadPolicy().onNetwork();
                //}
                //untagSocket(fd);
            //}
        //} catch (ErrnoException ignored) {
        //}
        //os.close(fd);
    }

    
        private static boolean isLingerSocket(FileDescriptor fd) throws ErrnoException {
        StructLinger linger = Libcore.os.getsockoptLinger(fd, SOL_SOCKET, SO_LINGER);
        return linger.isOn() && linger.l_linger > 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.782 -0400", hash_original_method = "524D1337E9F0426B22674071C6D0693B", hash_generated_method = "DFDE4AF7DAE37289B364BA74FD9F16C2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void connect(FileDescriptor fd, InetAddress address, int port) throws ErrnoException {
        dsTaint.addTaint(port);
        dsTaint.addTaint(address.dsTaint);
        dsTaint.addTaint(fd.dsTaint);
        BlockGuard.getThreadPolicy().onNetwork();
        os.connect(fd, address, port);
        // ---------- Original Method ----------
        //BlockGuard.getThreadPolicy().onNetwork();
        //os.connect(fd, address, port);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.782 -0400", hash_original_method = "651C9D4A8AD9CD60F42C588D20417ED0", hash_generated_method = "2B0C5473F6E23D1F0C96A597E2E1BF01")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void fdatasync(FileDescriptor fd) throws ErrnoException {
        dsTaint.addTaint(fd.dsTaint);
        BlockGuard.getThreadPolicy().onWriteToDisk();
        os.fdatasync(fd);
        // ---------- Original Method ----------
        //BlockGuard.getThreadPolicy().onWriteToDisk();
        //os.fdatasync(fd);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.782 -0400", hash_original_method = "E0F4576754752430F3173F2FFDEB5F93", hash_generated_method = "D8DD2DD234DCB61032674CE5C1EF714B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void fsync(FileDescriptor fd) throws ErrnoException {
        dsTaint.addTaint(fd.dsTaint);
        BlockGuard.getThreadPolicy().onWriteToDisk();
        os.fsync(fd);
        // ---------- Original Method ----------
        //BlockGuard.getThreadPolicy().onWriteToDisk();
        //os.fsync(fd);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.783 -0400", hash_original_method = "D97DA02F2520733C349FC66FF2A146AF", hash_generated_method = "F78D1C892081B40BFDE9942A529D40D8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void ftruncate(FileDescriptor fd, long length) throws ErrnoException {
        dsTaint.addTaint(length);
        dsTaint.addTaint(fd.dsTaint);
        BlockGuard.getThreadPolicy().onWriteToDisk();
        os.ftruncate(fd, length);
        // ---------- Original Method ----------
        //BlockGuard.getThreadPolicy().onWriteToDisk();
        //os.ftruncate(fd, length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.783 -0400", hash_original_method = "60BB804A04FED2996BE622E8EB3C8C72", hash_generated_method = "84A4ADBAB18816C207DE2A389536994C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public FileDescriptor open(String path, int flags, int mode) throws ErrnoException {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(path);
        dsTaint.addTaint(mode);
        BlockGuard.getThreadPolicy().onReadFromDisk();
        {
            BlockGuard.getThreadPolicy().onWriteToDisk();
        } //End block
        FileDescriptor varDF813003EF81B33B403133D09C9D4CD0_237374647 = (os.open(path, flags, mode));
        return (FileDescriptor)dsTaint.getTaint();
        // ---------- Original Method ----------
        //BlockGuard.getThreadPolicy().onReadFromDisk();
        //if ((mode & O_ACCMODE) != O_RDONLY) {
            //BlockGuard.getThreadPolicy().onWriteToDisk();
        //}
        //return os.open(path, flags, mode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.783 -0400", hash_original_method = "F416944E2BAC8A3A477E3A9DF95661DC", hash_generated_method = "2C58CB5C08F8664BC5EBB63941FBE707")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int poll(StructPollfd[] fds, int timeoutMs) throws ErrnoException {
        dsTaint.addTaint(timeoutMs);
        dsTaint.addTaint(fds[0].dsTaint);
        {
            BlockGuard.getThreadPolicy().onNetwork();
        } //End block
        int var48722583F516647909DDA26F0FCD9942_470647292 = (os.poll(fds, timeoutMs));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (timeoutMs != 0) {
            //BlockGuard.getThreadPolicy().onNetwork();
        //}
        //return os.poll(fds, timeoutMs);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.784 -0400", hash_original_method = "B4077B073E0F60ADBED6DEE6A699AD14", hash_generated_method = "D6801BB61B258F61B6DD5C7499D5E501")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int pread(FileDescriptor fd, ByteBuffer buffer, long offset) throws ErrnoException {
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(fd.dsTaint);
        BlockGuard.getThreadPolicy().onReadFromDisk();
        int var8E37D63F084AD12D6EF74F78D0F34813_345570005 = (os.pread(fd, buffer, offset));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //BlockGuard.getThreadPolicy().onReadFromDisk();
        //return os.pread(fd, buffer, offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.784 -0400", hash_original_method = "51D119A1C60E3F0FF85DFC4F5BCBEBDF", hash_generated_method = "C3EDB7C9A49BD31F9AF23E9677E21AE9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int pread(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount, long offset) throws ErrnoException {
        dsTaint.addTaint(byteOffset);
        dsTaint.addTaint(bytes[0]);
        dsTaint.addTaint(byteCount);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(fd.dsTaint);
        BlockGuard.getThreadPolicy().onReadFromDisk();
        int var9596F97D25F40A8949B0F9D6651550A1_532225706 = (os.pread(fd, bytes, byteOffset, byteCount, offset));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //BlockGuard.getThreadPolicy().onReadFromDisk();
        //return os.pread(fd, bytes, byteOffset, byteCount, offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.784 -0400", hash_original_method = "0F2134A6426D9EB8374019A9EA67DB6B", hash_generated_method = "015CEEEC108F2E1E0309ABC61682D566")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int pwrite(FileDescriptor fd, ByteBuffer buffer, long offset) throws ErrnoException {
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(fd.dsTaint);
        BlockGuard.getThreadPolicy().onWriteToDisk();
        int varBEC757109BB880DDBADF6015F3B05B2C_368702970 = (os.pwrite(fd, buffer, offset));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //BlockGuard.getThreadPolicy().onWriteToDisk();
        //return os.pwrite(fd, buffer, offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.784 -0400", hash_original_method = "A4033B69E198E86AF41C6F2BD93A7F05", hash_generated_method = "86F1105B981D10BF444A712BAC012BA9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int pwrite(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount, long offset) throws ErrnoException {
        dsTaint.addTaint(byteOffset);
        dsTaint.addTaint(bytes[0]);
        dsTaint.addTaint(byteCount);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(fd.dsTaint);
        BlockGuard.getThreadPolicy().onWriteToDisk();
        int var41A08F5DA487149A1F7C1270B58B9089_53437256 = (os.pwrite(fd, bytes, byteOffset, byteCount, offset));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //BlockGuard.getThreadPolicy().onWriteToDisk();
        //return os.pwrite(fd, bytes, byteOffset, byteCount, offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.785 -0400", hash_original_method = "ED8C50F685094B5680C00B42F9F5F045", hash_generated_method = "55409CC3E9475BADC6206079B4FA7F49")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int read(FileDescriptor fd, ByteBuffer buffer) throws ErrnoException {
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(fd.dsTaint);
        BlockGuard.getThreadPolicy().onReadFromDisk();
        int var5B8E7DC5191E81FE70C36AA027AFFCC8_153753496 = (os.read(fd, buffer));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //BlockGuard.getThreadPolicy().onReadFromDisk();
        //return os.read(fd, buffer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.785 -0400", hash_original_method = "2387C0D98FE16C1C4919C1D4A5A4F85D", hash_generated_method = "1218950AB84DE83B95CBB5B3B9DAD8C6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int read(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount) throws ErrnoException {
        dsTaint.addTaint(byteOffset);
        dsTaint.addTaint(bytes[0]);
        dsTaint.addTaint(byteCount);
        dsTaint.addTaint(fd.dsTaint);
        BlockGuard.getThreadPolicy().onReadFromDisk();
        int varE59F1DA0F28FCDF7A959280195F03910_733743144 = (os.read(fd, bytes, byteOffset, byteCount));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //BlockGuard.getThreadPolicy().onReadFromDisk();
        //return os.read(fd, bytes, byteOffset, byteCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.785 -0400", hash_original_method = "418568873B9A73D38D7FF96ACC4F4219", hash_generated_method = "583477BF7A0C08714A91FF60BD2D07DF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int readv(FileDescriptor fd, Object[] buffers, int[] offsets, int[] byteCounts) throws ErrnoException {
        dsTaint.addTaint(byteCounts[0]);
        dsTaint.addTaint(offsets[0]);
        dsTaint.addTaint(buffers[0].dsTaint);
        dsTaint.addTaint(fd.dsTaint);
        BlockGuard.getThreadPolicy().onReadFromDisk();
        int var2494A58C76DD4D861DBB94DFA16C08A6_2145183055 = (os.readv(fd, buffers, offsets, byteCounts));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //BlockGuard.getThreadPolicy().onReadFromDisk();
        //return os.readv(fd, buffers, offsets, byteCounts);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.785 -0400", hash_original_method = "E5449C41BDDE69AE1805A14CD8C0DB04", hash_generated_method = "783C435B8E0BFEDC93E94FEC2B41FA17")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int recvfrom(FileDescriptor fd, ByteBuffer buffer, int flags, InetSocketAddress srcAddress) throws ErrnoException {
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(flags);
        dsTaint.addTaint(srcAddress.dsTaint);
        dsTaint.addTaint(fd.dsTaint);
        BlockGuard.getThreadPolicy().onNetwork();
        int varF25721B896E31A53482415C6A924C22D_2097818038 = (os.recvfrom(fd, buffer, flags, srcAddress));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //BlockGuard.getThreadPolicy().onNetwork();
        //return os.recvfrom(fd, buffer, flags, srcAddress);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.786 -0400", hash_original_method = "F697E31CA82538D4CA19A49211FAEDE8", hash_generated_method = "BAF87796063225A676AC01BB2D4F99DD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int recvfrom(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount, int flags, InetSocketAddress srcAddress) throws ErrnoException {
        dsTaint.addTaint(byteOffset);
        dsTaint.addTaint(flags);
        dsTaint.addTaint(bytes[0]);
        dsTaint.addTaint(byteCount);
        dsTaint.addTaint(srcAddress.dsTaint);
        dsTaint.addTaint(fd.dsTaint);
        BlockGuard.getThreadPolicy().onNetwork();
        int var3A59E5EE9728502FA7AEFF9DA4D0C096_930753642 = (os.recvfrom(fd, bytes, byteOffset, byteCount, flags, srcAddress));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //BlockGuard.getThreadPolicy().onNetwork();
        //return os.recvfrom(fd, bytes, byteOffset, byteCount, flags, srcAddress);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.786 -0400", hash_original_method = "712364CE21E2D97A52399AF047375669", hash_generated_method = "F2164D599305DB08A8C9F19451A43075")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int sendto(FileDescriptor fd, ByteBuffer buffer, int flags, InetAddress inetAddress, int port) throws ErrnoException {
        dsTaint.addTaint(port);
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(flags);
        dsTaint.addTaint(inetAddress.dsTaint);
        dsTaint.addTaint(fd.dsTaint);
        BlockGuard.getThreadPolicy().onNetwork();
        int var0B8E7266620C88EB24F8453B4CECD027_1804564932 = (os.sendto(fd, buffer, flags, inetAddress, port));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //BlockGuard.getThreadPolicy().onNetwork();
        //return os.sendto(fd, buffer, flags, inetAddress, port);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.786 -0400", hash_original_method = "55701E5A28F22D42DFE5E9BDB107BB3B", hash_generated_method = "A5BA1551767319B5595DB81ADF359410")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int sendto(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount, int flags, InetAddress inetAddress, int port) throws ErrnoException {
        dsTaint.addTaint(port);
        dsTaint.addTaint(byteOffset);
        dsTaint.addTaint(flags);
        dsTaint.addTaint(bytes[0]);
        dsTaint.addTaint(inetAddress.dsTaint);
        dsTaint.addTaint(byteCount);
        dsTaint.addTaint(fd.dsTaint);
        {
            BlockGuard.getThreadPolicy().onNetwork();
        } //End block
        int var8221F6255948EB137094ED72A9C8456A_351513173 = (os.sendto(fd, bytes, byteOffset, byteCount, flags, inetAddress, port));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (inetAddress != null) {
            //BlockGuard.getThreadPolicy().onNetwork();
        //}
        //return os.sendto(fd, bytes, byteOffset, byteCount, flags, inetAddress, port);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.786 -0400", hash_original_method = "3EA6FC55F29379EA1669AB58FC394717", hash_generated_method = "53A1D3C0B5160C2D4D67920B2A096FAA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public FileDescriptor socket(int domain, int type, int protocol) throws ErrnoException {
        dsTaint.addTaint(protocol);
        dsTaint.addTaint(domain);
        dsTaint.addTaint(type);
        FileDescriptor var8C00AB356D691854F47F02C44B1F224B_1921120569 = (tagSocket(os.socket(domain, type, protocol)));
        return (FileDescriptor)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return tagSocket(os.socket(domain, type, protocol));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.786 -0400", hash_original_method = "5EE10271D9A1F133950EEC82FBA5FE84", hash_generated_method = "96EA9D067B46321C0C2D6624F101BEF2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int write(FileDescriptor fd, ByteBuffer buffer) throws ErrnoException {
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(fd.dsTaint);
        BlockGuard.getThreadPolicy().onWriteToDisk();
        int var0626357AF90ACF3FB1D934D119466787_900488976 = (os.write(fd, buffer));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //BlockGuard.getThreadPolicy().onWriteToDisk();
        //return os.write(fd, buffer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.787 -0400", hash_original_method = "45958860FE67213CB5E2A0FF79C39AE3", hash_generated_method = "91804AB11FC2C59496930E3AF451D9AB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int write(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount) throws ErrnoException {
        dsTaint.addTaint(byteOffset);
        dsTaint.addTaint(bytes[0]);
        dsTaint.addTaint(byteCount);
        dsTaint.addTaint(fd.dsTaint);
        BlockGuard.getThreadPolicy().onWriteToDisk();
        int varE733C997547CF269F3AB7BAEB4D044AF_1625548192 = (os.write(fd, bytes, byteOffset, byteCount));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //BlockGuard.getThreadPolicy().onWriteToDisk();
        //return os.write(fd, bytes, byteOffset, byteCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.787 -0400", hash_original_method = "5DBA61950559A586673FCC47110213A7", hash_generated_method = "35E0A537D258B44C7F4AA85E5E6DC2D9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int writev(FileDescriptor fd, Object[] buffers, int[] offsets, int[] byteCounts) throws ErrnoException {
        dsTaint.addTaint(byteCounts[0]);
        dsTaint.addTaint(offsets[0]);
        dsTaint.addTaint(buffers[0].dsTaint);
        dsTaint.addTaint(fd.dsTaint);
        BlockGuard.getThreadPolicy().onWriteToDisk();
        int var32F5E7D906A9F96A2B6412DC92928AD7_5659495 = (os.writev(fd, buffers, offsets, byteCounts));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //BlockGuard.getThreadPolicy().onWriteToDisk();
        //return os.writev(fd, buffers, offsets, byteCounts);
    }

    
}

