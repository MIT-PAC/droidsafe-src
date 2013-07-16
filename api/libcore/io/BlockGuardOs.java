package libcore.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import dalvik.system.BlockGuard;
import dalvik.system.SocketTagger;
import java.io.FileDescriptor;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.nio.ByteBuffer;
import static libcore.io.OsConstants.*;

public class BlockGuardOs extends ForwardingOs {
    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.364 -0400", hash_original_method = "2D0FCA28E55AE009AE62E6973DC0875A", hash_generated_method = "BFBA9034BDD5BE98046722AE218C09AC")
    public  BlockGuardOs(Os os) {
        super(os);
        addTaint(os.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.365 -0400", hash_original_method = "C76A4564374F8B1BE91B3642FF0C847C", hash_generated_method = "7F5834040574372FAD2170D1E310088D")
    private FileDescriptor tagSocket(FileDescriptor fd) throws ErrnoException {
        addTaint(fd.getTaint());
        try 
        {
            SocketTagger.get().tag(fd);
FileDescriptor var020F72FC5D1BB0511CAD11CC0AA674A0_2102775064 =             fd;
            var020F72FC5D1BB0511CAD11CC0AA674A0_2102775064.addTaint(taint);
            return var020F72FC5D1BB0511CAD11CC0AA674A0_2102775064;
        } //End block
        catch (SocketException e)
        {
            ErrnoException var2392F523B8E890DA26455C5AC0279257_1827627619 = new ErrnoException("socket", EINVAL, e);
            var2392F523B8E890DA26455C5AC0279257_1827627619.addTaint(taint);
            throw var2392F523B8E890DA26455C5AC0279257_1827627619;
        } //End block
        // ---------- Original Method ----------
        //try {
            //SocketTagger.get().tag(fd);
            //return fd;
        //} catch (SocketException e) {
            //throw new ErrnoException("socket", EINVAL, e);
        //}
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.365 -0400", hash_original_method = "94528424D623701A416A9704EA17EE51", hash_generated_method = "B48A53956516B65259B5AB6B5D80DD15")
    private void untagSocket(FileDescriptor fd) throws ErrnoException {
        addTaint(fd.getTaint());
        try 
        {
            SocketTagger.get().untag(fd);
        } //End block
        catch (SocketException e)
        {
            ErrnoException var2392F523B8E890DA26455C5AC0279257_1443574617 = new ErrnoException("socket", EINVAL, e);
            var2392F523B8E890DA26455C5AC0279257_1443574617.addTaint(taint);
            throw var2392F523B8E890DA26455C5AC0279257_1443574617;
        } //End block
        // ---------- Original Method ----------
        //try {
            //SocketTagger.get().untag(fd);
        //} catch (SocketException e) {
            //throw new ErrnoException("socket", EINVAL, e);
        //}
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.366 -0400", hash_original_method = "635584284C97FD1E7DC4024F591AB4FA", hash_generated_method = "47E08104407437CA7486B5A12F2DB209")
    @Override
    public FileDescriptor accept(FileDescriptor fd, InetSocketAddress peerAddress) throws ErrnoException {
        addTaint(peerAddress.getTaint());
        addTaint(fd.getTaint());
        BlockGuard.getThreadPolicy().onNetwork();
FileDescriptor varEB739DAEA0779973AFC08C3F032D7A35_477128961 =         tagSocket(os.accept(fd, peerAddress));
        varEB739DAEA0779973AFC08C3F032D7A35_477128961.addTaint(taint);
        return varEB739DAEA0779973AFC08C3F032D7A35_477128961;
        // ---------- Original Method ----------
        //BlockGuard.getThreadPolicy().onNetwork();
        //return tagSocket(os.accept(fd, peerAddress));
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.366 -0400", hash_original_method = "5D4ED9A04E2D732CC559EB48A60FC49B", hash_generated_method = "BA893E72F7BA55EAD0F91D86B35967C5")
    @Override
    public void close(FileDescriptor fd) throws ErrnoException {
        addTaint(fd.getTaint());
        try 
        {
    if(S_ISSOCK(Libcore.os.fstat(fd).st_mode))            
            {
    if(isLingerSocket(fd))                
                {
                    BlockGuard.getThreadPolicy().onNetwork();
                } //End block
                untagSocket(fd);
            } //End block
        } //End block
        catch (ErrnoException ignored)
        {
        } //End block
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

    
        @DSModeled(DSC.SPEC)
    private static boolean isLingerSocket(FileDescriptor fd) throws ErrnoException {
        StructLinger linger = Libcore.os.getsockoptLinger(fd, SOL_SOCKET, SO_LINGER);
        return linger.isOn() && linger.l_linger > 0;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.367 -0400", hash_original_method = "524D1337E9F0426B22674071C6D0693B", hash_generated_method = "7D6F005B384299D55C30D85FEFB441F0")
    @Override
    public void connect(FileDescriptor fd, InetAddress address, int port) throws ErrnoException {
        addTaint(port);
        addTaint(address.getTaint());
        addTaint(fd.getTaint());
        BlockGuard.getThreadPolicy().onNetwork();
        os.connect(fd, address, port);
        // ---------- Original Method ----------
        //BlockGuard.getThreadPolicy().onNetwork();
        //os.connect(fd, address, port);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.367 -0400", hash_original_method = "651C9D4A8AD9CD60F42C588D20417ED0", hash_generated_method = "A4E7315638EA838816D8E2B0416E7448")
    @Override
    public void fdatasync(FileDescriptor fd) throws ErrnoException {
        addTaint(fd.getTaint());
        BlockGuard.getThreadPolicy().onWriteToDisk();
        os.fdatasync(fd);
        // ---------- Original Method ----------
        //BlockGuard.getThreadPolicy().onWriteToDisk();
        //os.fdatasync(fd);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.368 -0400", hash_original_method = "E0F4576754752430F3173F2FFDEB5F93", hash_generated_method = "B44C8DB1DAD7693480E29A2015D68241")
    @Override
    public void fsync(FileDescriptor fd) throws ErrnoException {
        addTaint(fd.getTaint());
        BlockGuard.getThreadPolicy().onWriteToDisk();
        os.fsync(fd);
        // ---------- Original Method ----------
        //BlockGuard.getThreadPolicy().onWriteToDisk();
        //os.fsync(fd);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.368 -0400", hash_original_method = "D97DA02F2520733C349FC66FF2A146AF", hash_generated_method = "1189BDF7C8A95F2D52523B2E7F6EBC98")
    @Override
    public void ftruncate(FileDescriptor fd, long length) throws ErrnoException {
        addTaint(length);
        addTaint(fd.getTaint());
        BlockGuard.getThreadPolicy().onWriteToDisk();
        os.ftruncate(fd, length);
        // ---------- Original Method ----------
        //BlockGuard.getThreadPolicy().onWriteToDisk();
        //os.ftruncate(fd, length);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.368 -0400", hash_original_method = "60BB804A04FED2996BE622E8EB3C8C72", hash_generated_method = "5924FEDA517B29A2E0FB19B05AB2A74D")
    @Override
    public FileDescriptor open(String path, int flags, int mode) throws ErrnoException {
        addTaint(mode);
        addTaint(flags);
        addTaint(path.getTaint());
        BlockGuard.getThreadPolicy().onReadFromDisk();
    if((mode & O_ACCMODE) != O_RDONLY)        
        {
            BlockGuard.getThreadPolicy().onWriteToDisk();
        } //End block
FileDescriptor var39B89F4C81D0661C45D0F28BA8EB3A2E_990831681 =         os.open(path, flags, mode);
        var39B89F4C81D0661C45D0F28BA8EB3A2E_990831681.addTaint(taint);
        return var39B89F4C81D0661C45D0F28BA8EB3A2E_990831681;
        // ---------- Original Method ----------
        //BlockGuard.getThreadPolicy().onReadFromDisk();
        //if ((mode & O_ACCMODE) != O_RDONLY) {
            //BlockGuard.getThreadPolicy().onWriteToDisk();
        //}
        //return os.open(path, flags, mode);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.369 -0400", hash_original_method = "F416944E2BAC8A3A477E3A9DF95661DC", hash_generated_method = "58717BF3B2DF78EB5E0ABDB12B05E463")
    @Override
    public int poll(StructPollfd[] fds, int timeoutMs) throws ErrnoException {
        addTaint(timeoutMs);
        addTaint(fds[0].getTaint());
    if(timeoutMs != 0)        
        {
            BlockGuard.getThreadPolicy().onNetwork();
        } //End block
        int var222980D2507B3788FA6BCF34461C7D94_1289997201 = (os.poll(fds, timeoutMs));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1828439054 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1828439054;
        // ---------- Original Method ----------
        //if (timeoutMs != 0) {
            //BlockGuard.getThreadPolicy().onNetwork();
        //}
        //return os.poll(fds, timeoutMs);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.369 -0400", hash_original_method = "B4077B073E0F60ADBED6DEE6A699AD14", hash_generated_method = "654A8B97782958BCDE29C21D683EBC92")
    @Override
    public int pread(FileDescriptor fd, ByteBuffer buffer, long offset) throws ErrnoException {
        addTaint(offset);
        addTaint(buffer.getTaint());
        addTaint(fd.getTaint());
        BlockGuard.getThreadPolicy().onReadFromDisk();
        int varDE15DBE284FB6126AA45A8BF58915EDD_1780812993 = (os.pread(fd, buffer, offset));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_604631617 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_604631617;
        // ---------- Original Method ----------
        //BlockGuard.getThreadPolicy().onReadFromDisk();
        //return os.pread(fd, buffer, offset);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.370 -0400", hash_original_method = "51D119A1C60E3F0FF85DFC4F5BCBEBDF", hash_generated_method = "85A8EC205A34AAE0564DF212E50F10C3")
    @Override
    public int pread(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount, long offset) throws ErrnoException {
        addTaint(offset);
        addTaint(byteCount);
        addTaint(byteOffset);
        addTaint(bytes[0]);
        addTaint(fd.getTaint());
        BlockGuard.getThreadPolicy().onReadFromDisk();
        int varE3DF49A276F761267024E03A73F20DEB_13888421 = (os.pread(fd, bytes, byteOffset, byteCount, offset));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1893092730 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1893092730;
        // ---------- Original Method ----------
        //BlockGuard.getThreadPolicy().onReadFromDisk();
        //return os.pread(fd, bytes, byteOffset, byteCount, offset);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.370 -0400", hash_original_method = "0F2134A6426D9EB8374019A9EA67DB6B", hash_generated_method = "67B2B3E74F4B8BDA3F929D2E68BE2C1D")
    @Override
    public int pwrite(FileDescriptor fd, ByteBuffer buffer, long offset) throws ErrnoException {
        addTaint(offset);
        addTaint(buffer.getTaint());
        addTaint(fd.getTaint());
        BlockGuard.getThreadPolicy().onWriteToDisk();
        int varFCCAEB3AF4EC4F5C5FFFA4B4BD20FF50_1250717866 = (os.pwrite(fd, buffer, offset));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_163853178 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_163853178;
        // ---------- Original Method ----------
        //BlockGuard.getThreadPolicy().onWriteToDisk();
        //return os.pwrite(fd, buffer, offset);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.371 -0400", hash_original_method = "A4033B69E198E86AF41C6F2BD93A7F05", hash_generated_method = "A8D451C4F83B3D3B948C5B623847840C")
    @Override
    public int pwrite(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount, long offset) throws ErrnoException {
        addTaint(offset);
        addTaint(byteCount);
        addTaint(byteOffset);
        addTaint(bytes[0]);
        addTaint(fd.getTaint());
        BlockGuard.getThreadPolicy().onWriteToDisk();
        int var6074C3BFC1FB418DF49AE75B35C3814B_1486710517 = (os.pwrite(fd, bytes, byteOffset, byteCount, offset));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_202384444 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_202384444;
        // ---------- Original Method ----------
        //BlockGuard.getThreadPolicy().onWriteToDisk();
        //return os.pwrite(fd, bytes, byteOffset, byteCount, offset);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.371 -0400", hash_original_method = "ED8C50F685094B5680C00B42F9F5F045", hash_generated_method = "C4DE8D32B4709C49C02C8D53608529B5")
    @Override
    public int read(FileDescriptor fd, ByteBuffer buffer) throws ErrnoException {
        addTaint(buffer.getTaint());
        addTaint(fd.getTaint());
        BlockGuard.getThreadPolicy().onReadFromDisk();
        int var0150C7D03DEBCE79D9B842076877B65C_682855732 = (os.read(fd, buffer));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_468911073 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_468911073;
        // ---------- Original Method ----------
        //BlockGuard.getThreadPolicy().onReadFromDisk();
        //return os.read(fd, buffer);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.372 -0400", hash_original_method = "2387C0D98FE16C1C4919C1D4A5A4F85D", hash_generated_method = "7E0EDD4BF4232D7F3B450BC964A8373E")
    @Override
    public int read(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount) throws ErrnoException {
        addTaint(byteCount);
        addTaint(byteOffset);
        addTaint(bytes[0]);
        addTaint(fd.getTaint());
        BlockGuard.getThreadPolicy().onReadFromDisk();
        int var1E40651C708F64B04B9DD67336B66EA0_1541281657 = (os.read(fd, bytes, byteOffset, byteCount));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_907019488 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_907019488;
        // ---------- Original Method ----------
        //BlockGuard.getThreadPolicy().onReadFromDisk();
        //return os.read(fd, bytes, byteOffset, byteCount);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.372 -0400", hash_original_method = "418568873B9A73D38D7FF96ACC4F4219", hash_generated_method = "049AFAC20E447563C183E701F2958BA2")
    @Override
    public int readv(FileDescriptor fd, Object[] buffers, int[] offsets, int[] byteCounts) throws ErrnoException {
        addTaint(byteCounts[0]);
        addTaint(offsets[0]);
        addTaint(buffers[0].getTaint());
        addTaint(fd.getTaint());
        BlockGuard.getThreadPolicy().onReadFromDisk();
        int var9267859C7D3D2D2A030DB3D26AF801EF_1559400548 = (os.readv(fd, buffers, offsets, byteCounts));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_764850592 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_764850592;
        // ---------- Original Method ----------
        //BlockGuard.getThreadPolicy().onReadFromDisk();
        //return os.readv(fd, buffers, offsets, byteCounts);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.373 -0400", hash_original_method = "E5449C41BDDE69AE1805A14CD8C0DB04", hash_generated_method = "E7AF7557FDD66E3CA007E8C3362D5D46")
    @Override
    public int recvfrom(FileDescriptor fd, ByteBuffer buffer, int flags, InetSocketAddress srcAddress) throws ErrnoException {
        addTaint(srcAddress.getTaint());
        addTaint(flags);
        addTaint(buffer.getTaint());
        addTaint(fd.getTaint());
        BlockGuard.getThreadPolicy().onNetwork();
        int var148C659D0B6FCF3CBC57A3D34F2DD492_1632603601 = (os.recvfrom(fd, buffer, flags, srcAddress));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_477585227 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_477585227;
        // ---------- Original Method ----------
        //BlockGuard.getThreadPolicy().onNetwork();
        //return os.recvfrom(fd, buffer, flags, srcAddress);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.373 -0400", hash_original_method = "F697E31CA82538D4CA19A49211FAEDE8", hash_generated_method = "44B55C74DDAD0A6B72153E02184FEBF2")
    @Override
    public int recvfrom(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount, int flags, InetSocketAddress srcAddress) throws ErrnoException {
        addTaint(srcAddress.getTaint());
        addTaint(flags);
        addTaint(byteCount);
        addTaint(byteOffset);
        addTaint(bytes[0]);
        addTaint(fd.getTaint());
        BlockGuard.getThreadPolicy().onNetwork();
        int varE1EBC5E4A46203E8474950D1E43CBCA7_204494395 = (os.recvfrom(fd, bytes, byteOffset, byteCount, flags, srcAddress));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_613260502 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_613260502;
        // ---------- Original Method ----------
        //BlockGuard.getThreadPolicy().onNetwork();
        //return os.recvfrom(fd, bytes, byteOffset, byteCount, flags, srcAddress);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.374 -0400", hash_original_method = "712364CE21E2D97A52399AF047375669", hash_generated_method = "0D61AD1E066E8D30758F77FEC76ED418")
    @Override
    public int sendto(FileDescriptor fd, ByteBuffer buffer, int flags, InetAddress inetAddress, int port) throws ErrnoException {
        addTaint(port);
        addTaint(inetAddress.getTaint());
        addTaint(flags);
        addTaint(buffer.getTaint());
        addTaint(fd.getTaint());
        BlockGuard.getThreadPolicy().onNetwork();
        int var74D30D6BF88A4023586B126D875357BC_702174706 = (os.sendto(fd, buffer, flags, inetAddress, port));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1743302401 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1743302401;
        // ---------- Original Method ----------
        //BlockGuard.getThreadPolicy().onNetwork();
        //return os.sendto(fd, buffer, flags, inetAddress, port);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.374 -0400", hash_original_method = "55701E5A28F22D42DFE5E9BDB107BB3B", hash_generated_method = "2ADFD9D18A8F4B034787D15AD6220CAF")
    @Override
    public int sendto(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount, int flags, InetAddress inetAddress, int port) throws ErrnoException {
        addTaint(port);
        addTaint(inetAddress.getTaint());
        addTaint(flags);
        addTaint(byteCount);
        addTaint(byteOffset);
        addTaint(bytes[0]);
        addTaint(fd.getTaint());
    if(inetAddress != null)        
        {
            BlockGuard.getThreadPolicy().onNetwork();
        } //End block
        int var209FD29A1FDDAD7A53690DD257C173A4_1331212708 = (os.sendto(fd, bytes, byteOffset, byteCount, flags, inetAddress, port));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1876150928 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1876150928;
        // ---------- Original Method ----------
        //if (inetAddress != null) {
            //BlockGuard.getThreadPolicy().onNetwork();
        //}
        //return os.sendto(fd, bytes, byteOffset, byteCount, flags, inetAddress, port);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.375 -0400", hash_original_method = "3EA6FC55F29379EA1669AB58FC394717", hash_generated_method = "F0FD203168DCC673F78185756E192AAD")
    @Override
    public FileDescriptor socket(int domain, int type, int protocol) throws ErrnoException {
        addTaint(protocol);
        addTaint(type);
        addTaint(domain);
FileDescriptor var67CBD9833D2D49016EBA64AE77EB089C_1731373955 =         tagSocket(os.socket(domain, type, protocol));
        var67CBD9833D2D49016EBA64AE77EB089C_1731373955.addTaint(taint);
        return var67CBD9833D2D49016EBA64AE77EB089C_1731373955;
        // ---------- Original Method ----------
        //return tagSocket(os.socket(domain, type, protocol));
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.375 -0400", hash_original_method = "5EE10271D9A1F133950EEC82FBA5FE84", hash_generated_method = "6B56DF4B04ED834442D786653000B769")
    @Override
    public int write(FileDescriptor fd, ByteBuffer buffer) throws ErrnoException {
        addTaint(buffer.getTaint());
        addTaint(fd.getTaint());
        BlockGuard.getThreadPolicy().onWriteToDisk();
        int var14D74F75C9BD675ED0875C35081834D8_1550196730 = (os.write(fd, buffer));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1048638660 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1048638660;
        // ---------- Original Method ----------
        //BlockGuard.getThreadPolicy().onWriteToDisk();
        //return os.write(fd, buffer);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.376 -0400", hash_original_method = "45958860FE67213CB5E2A0FF79C39AE3", hash_generated_method = "5630FCC66C591C28EDA8A9381CF1C67C")
    @Override
    public int write(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount) throws ErrnoException {
        addTaint(byteCount);
        addTaint(byteOffset);
        addTaint(bytes[0]);
        addTaint(fd.getTaint());
        BlockGuard.getThreadPolicy().onWriteToDisk();
        int var21A8634C3DEBC7316061A81665E91499_53331437 = (os.write(fd, bytes, byteOffset, byteCount));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1871128720 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1871128720;
        // ---------- Original Method ----------
        //BlockGuard.getThreadPolicy().onWriteToDisk();
        //return os.write(fd, bytes, byteOffset, byteCount);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.376 -0400", hash_original_method = "5DBA61950559A586673FCC47110213A7", hash_generated_method = "8E7FC206DCD0E4F65C21C319399104D7")
    @Override
    public int writev(FileDescriptor fd, Object[] buffers, int[] offsets, int[] byteCounts) throws ErrnoException {
        addTaint(byteCounts[0]);
        addTaint(offsets[0]);
        addTaint(buffers[0].getTaint());
        addTaint(fd.getTaint());
        BlockGuard.getThreadPolicy().onWriteToDisk();
        int varCCE8841716556A5168B85B70CE6AC0C2_1017217307 = (os.writev(fd, buffers, offsets, byteCounts));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1285686802 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1285686802;
        // ---------- Original Method ----------
        //BlockGuard.getThreadPolicy().onWriteToDisk();
        //return os.writev(fd, buffers, offsets, byteCounts);
    }

    
}

