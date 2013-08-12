package libcore.io;

// Droidsafe Imports
import droidsafe.annotations.*;
import static libcore.io.OsConstants.EINVAL;
import static libcore.io.OsConstants.O_ACCMODE;
import static libcore.io.OsConstants.O_RDONLY;
import static libcore.io.OsConstants.SOL_SOCKET;
import static libcore.io.OsConstants.SO_LINGER;
import static libcore.io.OsConstants.S_ISSOCK;

import java.io.FileDescriptor;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.nio.ByteBuffer;

import dalvik.system.BlockGuard;
import dalvik.system.SocketTagger;




public class BlockGuardOs extends ForwardingOs {
    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:23.979 -0400", hash_original_method = "2D0FCA28E55AE009AE62E6973DC0875A", hash_generated_method = "BFBA9034BDD5BE98046722AE218C09AC")
    public  BlockGuardOs(Os os) {
        super(os);
        addTaint(os.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:23.979 -0400", hash_original_method = "C76A4564374F8B1BE91B3642FF0C847C", hash_generated_method = "11A968D6814675D8C628DA0F002E1F08")
    private FileDescriptor tagSocket(FileDescriptor fd) throws ErrnoException {
        addTaint(fd.getTaint());
        try 
        {
            SocketTagger.get().tag(fd);
FileDescriptor var020F72FC5D1BB0511CAD11CC0AA674A0_1473985440 =             fd;
            var020F72FC5D1BB0511CAD11CC0AA674A0_1473985440.addTaint(taint);
            return var020F72FC5D1BB0511CAD11CC0AA674A0_1473985440;
        } //End block
        catch (SocketException e)
        {
            ErrnoException var2392F523B8E890DA26455C5AC0279257_1767524271 = new ErrnoException("socket", EINVAL, e);
            var2392F523B8E890DA26455C5AC0279257_1767524271.addTaint(taint);
            throw var2392F523B8E890DA26455C5AC0279257_1767524271;
        } //End block
        // ---------- Original Method ----------
        //try {
            //SocketTagger.get().tag(fd);
            //return fd;
        //} catch (SocketException e) {
            //throw new ErrnoException("socket", EINVAL, e);
        //}
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:23.980 -0400", hash_original_method = "94528424D623701A416A9704EA17EE51", hash_generated_method = "B178EEC8EFEC59A4ED9724B55DEB2902")
    private void untagSocket(FileDescriptor fd) throws ErrnoException {
        addTaint(fd.getTaint());
        try 
        {
            SocketTagger.get().untag(fd);
        } //End block
        catch (SocketException e)
        {
            ErrnoException var2392F523B8E890DA26455C5AC0279257_991525 = new ErrnoException("socket", EINVAL, e);
            var2392F523B8E890DA26455C5AC0279257_991525.addTaint(taint);
            throw var2392F523B8E890DA26455C5AC0279257_991525;
        } //End block
        // ---------- Original Method ----------
        //try {
            //SocketTagger.get().untag(fd);
        //} catch (SocketException e) {
            //throw new ErrnoException("socket", EINVAL, e);
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:23.980 -0400", hash_original_method = "635584284C97FD1E7DC4024F591AB4FA", hash_generated_method = "869D079428AF2A7243734B4F2E6CCAA8")
    @Override
    public FileDescriptor accept(FileDescriptor fd, InetSocketAddress peerAddress) throws ErrnoException {
        addTaint(peerAddress.getTaint());
        addTaint(fd.getTaint());
        BlockGuard.getThreadPolicy().onNetwork();
FileDescriptor varEB739DAEA0779973AFC08C3F032D7A35_244430921 =         tagSocket(os.accept(fd, peerAddress));
        varEB739DAEA0779973AFC08C3F032D7A35_244430921.addTaint(taint);
        return varEB739DAEA0779973AFC08C3F032D7A35_244430921;
        // ---------- Original Method ----------
        //BlockGuard.getThreadPolicy().onNetwork();
        //return tagSocket(os.accept(fd, peerAddress));
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:23.980 -0400", hash_original_method = "5D4ED9A04E2D732CC559EB48A60FC49B", hash_generated_method = "BA893E72F7BA55EAD0F91D86B35967C5")
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

    
    @DSModeled(DSC.BAN)
    private static boolean isLingerSocket(FileDescriptor fd) throws ErrnoException {
        StructLinger linger = Libcore.os.getsockoptLinger(fd, SOL_SOCKET, SO_LINGER);
        return linger.isOn() && linger.l_linger > 0;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:23.981 -0400", hash_original_method = "524D1337E9F0426B22674071C6D0693B", hash_generated_method = "7D6F005B384299D55C30D85FEFB441F0")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:23.982 -0400", hash_original_method = "651C9D4A8AD9CD60F42C588D20417ED0", hash_generated_method = "A4E7315638EA838816D8E2B0416E7448")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:23.982 -0400", hash_original_method = "E0F4576754752430F3173F2FFDEB5F93", hash_generated_method = "B44C8DB1DAD7693480E29A2015D68241")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:23.982 -0400", hash_original_method = "D97DA02F2520733C349FC66FF2A146AF", hash_generated_method = "1189BDF7C8A95F2D52523B2E7F6EBC98")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:23.983 -0400", hash_original_method = "60BB804A04FED2996BE622E8EB3C8C72", hash_generated_method = "CD216689DF5D389F82E139CFBF520DE5")
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
FileDescriptor var39B89F4C81D0661C45D0F28BA8EB3A2E_258192261 =         os.open(path, flags, mode);
        var39B89F4C81D0661C45D0F28BA8EB3A2E_258192261.addTaint(taint);
        return var39B89F4C81D0661C45D0F28BA8EB3A2E_258192261;
        // ---------- Original Method ----------
        //BlockGuard.getThreadPolicy().onReadFromDisk();
        //if ((mode & O_ACCMODE) != O_RDONLY) {
            //BlockGuard.getThreadPolicy().onWriteToDisk();
        //}
        //return os.open(path, flags, mode);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:23.983 -0400", hash_original_method = "F416944E2BAC8A3A477E3A9DF95661DC", hash_generated_method = "04E6BC9D2C8B249C3C16E5DABD413C53")
    @Override
    public int poll(StructPollfd[] fds, int timeoutMs) throws ErrnoException {
        addTaint(timeoutMs);
        addTaint(fds[0].getTaint());
        if(timeoutMs != 0)        
        {
            BlockGuard.getThreadPolicy().onNetwork();
        } //End block
        int var222980D2507B3788FA6BCF34461C7D94_1355657238 = (os.poll(fds, timeoutMs));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_612519901 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_612519901;
        // ---------- Original Method ----------
        //if (timeoutMs != 0) {
            //BlockGuard.getThreadPolicy().onNetwork();
        //}
        //return os.poll(fds, timeoutMs);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:23.984 -0400", hash_original_method = "B4077B073E0F60ADBED6DEE6A699AD14", hash_generated_method = "78DDF275B227418995719760C0EFBBC2")
    @Override
    public int pread(FileDescriptor fd, ByteBuffer buffer, long offset) throws ErrnoException {
        addTaint(offset);
        addTaint(buffer.getTaint());
        addTaint(fd.getTaint());
        BlockGuard.getThreadPolicy().onReadFromDisk();
        int varDE15DBE284FB6126AA45A8BF58915EDD_1361772823 = (os.pread(fd, buffer, offset));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_476985810 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_476985810;
        // ---------- Original Method ----------
        //BlockGuard.getThreadPolicy().onReadFromDisk();
        //return os.pread(fd, buffer, offset);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:23.984 -0400", hash_original_method = "51D119A1C60E3F0FF85DFC4F5BCBEBDF", hash_generated_method = "D77EF767E7F41F62FD2011270FB95995")
    @Override
    public int pread(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount, long offset) throws ErrnoException {
        addTaint(offset);
        addTaint(byteCount);
        addTaint(byteOffset);
        addTaint(bytes[0]);
        addTaint(fd.getTaint());
        BlockGuard.getThreadPolicy().onReadFromDisk();
        int varE3DF49A276F761267024E03A73F20DEB_25297916 = (os.pread(fd, bytes, byteOffset, byteCount, offset));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_636676047 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_636676047;
        // ---------- Original Method ----------
        //BlockGuard.getThreadPolicy().onReadFromDisk();
        //return os.pread(fd, bytes, byteOffset, byteCount, offset);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:23.985 -0400", hash_original_method = "0F2134A6426D9EB8374019A9EA67DB6B", hash_generated_method = "EC13F4DCD2CFE015DE48D92981772A2C")
    @Override
    public int pwrite(FileDescriptor fd, ByteBuffer buffer, long offset) throws ErrnoException {
        addTaint(offset);
        addTaint(buffer.getTaint());
        addTaint(fd.getTaint());
        BlockGuard.getThreadPolicy().onWriteToDisk();
        int varFCCAEB3AF4EC4F5C5FFFA4B4BD20FF50_1551146282 = (os.pwrite(fd, buffer, offset));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_27015634 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_27015634;
        // ---------- Original Method ----------
        //BlockGuard.getThreadPolicy().onWriteToDisk();
        //return os.pwrite(fd, buffer, offset);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:23.985 -0400", hash_original_method = "A4033B69E198E86AF41C6F2BD93A7F05", hash_generated_method = "75E7D61CCD28690B4953AAA725FDE60C")
    @Override
    public int pwrite(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount, long offset) throws ErrnoException {
        addTaint(offset);
        addTaint(byteCount);
        addTaint(byteOffset);
        addTaint(bytes[0]);
        addTaint(fd.getTaint());
        BlockGuard.getThreadPolicy().onWriteToDisk();
        int var6074C3BFC1FB418DF49AE75B35C3814B_1405589087 = (os.pwrite(fd, bytes, byteOffset, byteCount, offset));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1870060146 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1870060146;
        // ---------- Original Method ----------
        //BlockGuard.getThreadPolicy().onWriteToDisk();
        //return os.pwrite(fd, bytes, byteOffset, byteCount, offset);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:23.985 -0400", hash_original_method = "ED8C50F685094B5680C00B42F9F5F045", hash_generated_method = "B77B54D0F31FBC2B7A6087BEA8D31874")
    @Override
    public int read(FileDescriptor fd, ByteBuffer buffer) throws ErrnoException {
        addTaint(buffer.getTaint());
        addTaint(fd.getTaint());
        BlockGuard.getThreadPolicy().onReadFromDisk();
        int var0150C7D03DEBCE79D9B842076877B65C_100214644 = (os.read(fd, buffer));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_460639075 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_460639075;
        // ---------- Original Method ----------
        //BlockGuard.getThreadPolicy().onReadFromDisk();
        //return os.read(fd, buffer);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:23.986 -0400", hash_original_method = "2387C0D98FE16C1C4919C1D4A5A4F85D", hash_generated_method = "C4943EC6722300E26764417EC5922B17")
    @Override
    public int read(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount) throws ErrnoException {
        addTaint(byteCount);
        addTaint(byteOffset);
        addTaint(bytes[0]);
        addTaint(fd.getTaint());
        BlockGuard.getThreadPolicy().onReadFromDisk();
        int var1E40651C708F64B04B9DD67336B66EA0_973706922 = (os.read(fd, bytes, byteOffset, byteCount));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2146399684 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2146399684;
        // ---------- Original Method ----------
        //BlockGuard.getThreadPolicy().onReadFromDisk();
        //return os.read(fd, bytes, byteOffset, byteCount);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:23.986 -0400", hash_original_method = "418568873B9A73D38D7FF96ACC4F4219", hash_generated_method = "A39F8968164AEAF8CCEEE8DF439D43D9")
    @Override
    public int readv(FileDescriptor fd, Object[] buffers, int[] offsets, int[] byteCounts) throws ErrnoException {
        addTaint(byteCounts[0]);
        addTaint(offsets[0]);
        addTaint(buffers[0].getTaint());
        addTaint(fd.getTaint());
        BlockGuard.getThreadPolicy().onReadFromDisk();
        int var9267859C7D3D2D2A030DB3D26AF801EF_201917721 = (os.readv(fd, buffers, offsets, byteCounts));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_855277575 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_855277575;
        // ---------- Original Method ----------
        //BlockGuard.getThreadPolicy().onReadFromDisk();
        //return os.readv(fd, buffers, offsets, byteCounts);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:23.987 -0400", hash_original_method = "E5449C41BDDE69AE1805A14CD8C0DB04", hash_generated_method = "F29F716FE2D3F124AD0C8648697E0430")
    @Override
    public int recvfrom(FileDescriptor fd, ByteBuffer buffer, int flags, InetSocketAddress srcAddress) throws ErrnoException {
        addTaint(srcAddress.getTaint());
        addTaint(flags);
        addTaint(buffer.getTaint());
        addTaint(fd.getTaint());
        BlockGuard.getThreadPolicy().onNetwork();
        int var148C659D0B6FCF3CBC57A3D34F2DD492_1828805698 = (os.recvfrom(fd, buffer, flags, srcAddress));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_992668959 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_992668959;
        // ---------- Original Method ----------
        //BlockGuard.getThreadPolicy().onNetwork();
        //return os.recvfrom(fd, buffer, flags, srcAddress);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:23.987 -0400", hash_original_method = "F697E31CA82538D4CA19A49211FAEDE8", hash_generated_method = "140C6ABB0CBBC7FF950CB841A1261D56")
    @Override
    public int recvfrom(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount, int flags, InetSocketAddress srcAddress) throws ErrnoException {
        addTaint(srcAddress.getTaint());
        addTaint(flags);
        addTaint(byteCount);
        addTaint(byteOffset);
        addTaint(bytes[0]);
        addTaint(fd.getTaint());
        BlockGuard.getThreadPolicy().onNetwork();
        int varE1EBC5E4A46203E8474950D1E43CBCA7_771849809 = (os.recvfrom(fd, bytes, byteOffset, byteCount, flags, srcAddress));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_995392488 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_995392488;
        // ---------- Original Method ----------
        //BlockGuard.getThreadPolicy().onNetwork();
        //return os.recvfrom(fd, bytes, byteOffset, byteCount, flags, srcAddress);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:23.988 -0400", hash_original_method = "712364CE21E2D97A52399AF047375669", hash_generated_method = "2664609563D0C5D54BD0F377B3EE9CA6")
    @Override
    public int sendto(FileDescriptor fd, ByteBuffer buffer, int flags, InetAddress inetAddress, int port) throws ErrnoException {
        addTaint(port);
        addTaint(inetAddress.getTaint());
        addTaint(flags);
        addTaint(buffer.getTaint());
        addTaint(fd.getTaint());
        BlockGuard.getThreadPolicy().onNetwork();
        int var74D30D6BF88A4023586B126D875357BC_843788870 = (os.sendto(fd, buffer, flags, inetAddress, port));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_73375617 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_73375617;
        // ---------- Original Method ----------
        //BlockGuard.getThreadPolicy().onNetwork();
        //return os.sendto(fd, buffer, flags, inetAddress, port);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:23.988 -0400", hash_original_method = "55701E5A28F22D42DFE5E9BDB107BB3B", hash_generated_method = "4C5CD4D45EBF106183DBE8355E9369EE")
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
        int var209FD29A1FDDAD7A53690DD257C173A4_931031441 = (os.sendto(fd, bytes, byteOffset, byteCount, flags, inetAddress, port));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_184836065 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_184836065;
        // ---------- Original Method ----------
        //if (inetAddress != null) {
            //BlockGuard.getThreadPolicy().onNetwork();
        //}
        //return os.sendto(fd, bytes, byteOffset, byteCount, flags, inetAddress, port);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:23.988 -0400", hash_original_method = "3EA6FC55F29379EA1669AB58FC394717", hash_generated_method = "46A4FA1F692AB9D12DD823676F19EC50")
    @Override
    public FileDescriptor socket(int domain, int type, int protocol) throws ErrnoException {
        addTaint(protocol);
        addTaint(type);
        addTaint(domain);
FileDescriptor var67CBD9833D2D49016EBA64AE77EB089C_1496018121 =         tagSocket(os.socket(domain, type, protocol));
        var67CBD9833D2D49016EBA64AE77EB089C_1496018121.addTaint(taint);
        return var67CBD9833D2D49016EBA64AE77EB089C_1496018121;
        // ---------- Original Method ----------
        //return tagSocket(os.socket(domain, type, protocol));
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:23.988 -0400", hash_original_method = "5EE10271D9A1F133950EEC82FBA5FE84", hash_generated_method = "B9C120290E24E57A5AD9F0E4621315EC")
    @Override
    public int write(FileDescriptor fd, ByteBuffer buffer) throws ErrnoException {
        addTaint(buffer.getTaint());
        addTaint(fd.getTaint());
        BlockGuard.getThreadPolicy().onWriteToDisk();
        int var14D74F75C9BD675ED0875C35081834D8_74122178 = (os.write(fd, buffer));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_939180218 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_939180218;
        // ---------- Original Method ----------
        //BlockGuard.getThreadPolicy().onWriteToDisk();
        //return os.write(fd, buffer);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:23.989 -0400", hash_original_method = "45958860FE67213CB5E2A0FF79C39AE3", hash_generated_method = "888438486540357BFFAB99C6C9A8167A")
    @Override
    public int write(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount) throws ErrnoException {
        addTaint(byteCount);
        addTaint(byteOffset);
        addTaint(bytes[0]);
        addTaint(fd.getTaint());
        BlockGuard.getThreadPolicy().onWriteToDisk();
        int var21A8634C3DEBC7316061A81665E91499_1250870973 = (os.write(fd, bytes, byteOffset, byteCount));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1496745408 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1496745408;
        // ---------- Original Method ----------
        //BlockGuard.getThreadPolicy().onWriteToDisk();
        //return os.write(fd, bytes, byteOffset, byteCount);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:23.989 -0400", hash_original_method = "5DBA61950559A586673FCC47110213A7", hash_generated_method = "B63527CDE0B13C0C51F8D18A76348CED")
    @Override
    public int writev(FileDescriptor fd, Object[] buffers, int[] offsets, int[] byteCounts) throws ErrnoException {
        addTaint(byteCounts[0]);
        addTaint(offsets[0]);
        addTaint(buffers[0].getTaint());
        addTaint(fd.getTaint());
        BlockGuard.getThreadPolicy().onWriteToDisk();
        int varCCE8841716556A5168B85B70CE6AC0C2_2106818465 = (os.writev(fd, buffers, offsets, byteCounts));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_838103782 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_838103782;
        // ---------- Original Method ----------
        //BlockGuard.getThreadPolicy().onWriteToDisk();
        //return os.writev(fd, buffers, offsets, byteCounts);
    }

    
}

