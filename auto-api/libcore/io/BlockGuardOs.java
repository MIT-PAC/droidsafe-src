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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.249 -0400", hash_original_method = "2D0FCA28E55AE009AE62E6973DC0875A", hash_generated_method = "BFBA9034BDD5BE98046722AE218C09AC")
    public  BlockGuardOs(Os os) {
        super(os);
        addTaint(os.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.257 -0400", hash_original_method = "C76A4564374F8B1BE91B3642FF0C847C", hash_generated_method = "54F81A33B7EE29967EDB74C2FB150224")
    private FileDescriptor tagSocket(FileDescriptor fd) throws ErrnoException {
        FileDescriptor varB4EAC82CA7396A68D541C85D26508E83_29707583 = null; //Variable for return #1
        try 
        {
            SocketTagger.get().tag(fd);
            varB4EAC82CA7396A68D541C85D26508E83_29707583 = fd;
        } //End block
        catch (SocketException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new ErrnoException("socket", EINVAL, e);
        } //End block
        addTaint(fd.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_29707583.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_29707583;
        // ---------- Original Method ----------
        //try {
            //SocketTagger.get().tag(fd);
            //return fd;
        //} catch (SocketException e) {
            //throw new ErrnoException("socket", EINVAL, e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.262 -0400", hash_original_method = "94528424D623701A416A9704EA17EE51", hash_generated_method = "978C1CC2F5AAC6B60B752CB87130B28C")
    private void untagSocket(FileDescriptor fd) throws ErrnoException {
        try 
        {
            SocketTagger.get().untag(fd);
        } //End block
        catch (SocketException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new ErrnoException("socket", EINVAL, e);
        } //End block
        addTaint(fd.getTaint());
        // ---------- Original Method ----------
        //try {
            //SocketTagger.get().untag(fd);
        //} catch (SocketException e) {
            //throw new ErrnoException("socket", EINVAL, e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.263 -0400", hash_original_method = "635584284C97FD1E7DC4024F591AB4FA", hash_generated_method = "411BE08DF3882D5BBF0EBD5A5151C54A")
    @Override
    public FileDescriptor accept(FileDescriptor fd, InetSocketAddress peerAddress) throws ErrnoException {
        FileDescriptor varB4EAC82CA7396A68D541C85D26508E83_1880130017 = null; //Variable for return #1
        BlockGuard.getThreadPolicy().onNetwork();
        varB4EAC82CA7396A68D541C85D26508E83_1880130017 = tagSocket(os.accept(fd, peerAddress));
        addTaint(fd.getTaint());
        addTaint(peerAddress.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1880130017.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1880130017;
        // ---------- Original Method ----------
        //BlockGuard.getThreadPolicy().onNetwork();
        //return tagSocket(os.accept(fd, peerAddress));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.269 -0400", hash_original_method = "5D4ED9A04E2D732CC559EB48A60FC49B", hash_generated_method = "22A6E2FA0FB7A3A129DD5F2C9696C9F0")
    @Override
    public void close(FileDescriptor fd) throws ErrnoException {
        try 
        {
            {
                boolean var5BBC6B9EEEC700D6D365E57A098BE4B0_1227977876 = (S_ISSOCK(Libcore.os.fstat(fd).st_mode));
                {
                    {
                        boolean var15CAB83F9C99E6A6B679657FAA8A6045_2040148081 = (isLingerSocket(fd));
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
        addTaint(fd.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.280 -0400", hash_original_method = "524D1337E9F0426B22674071C6D0693B", hash_generated_method = "775DAC4D5B44F68D95D008740F3B0C3A")
    @Override
    public void connect(FileDescriptor fd, InetAddress address, int port) throws ErrnoException {
        BlockGuard.getThreadPolicy().onNetwork();
        os.connect(fd, address, port);
        addTaint(fd.getTaint());
        addTaint(address.getTaint());
        addTaint(port);
        // ---------- Original Method ----------
        //BlockGuard.getThreadPolicy().onNetwork();
        //os.connect(fd, address, port);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.280 -0400", hash_original_method = "651C9D4A8AD9CD60F42C588D20417ED0", hash_generated_method = "F0C0A68B11B96D1DF821AAA224AE4091")
    @Override
    public void fdatasync(FileDescriptor fd) throws ErrnoException {
        BlockGuard.getThreadPolicy().onWriteToDisk();
        os.fdatasync(fd);
        addTaint(fd.getTaint());
        // ---------- Original Method ----------
        //BlockGuard.getThreadPolicy().onWriteToDisk();
        //os.fdatasync(fd);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.280 -0400", hash_original_method = "E0F4576754752430F3173F2FFDEB5F93", hash_generated_method = "CED05022960E42665D75965E83E76840")
    @Override
    public void fsync(FileDescriptor fd) throws ErrnoException {
        BlockGuard.getThreadPolicy().onWriteToDisk();
        os.fsync(fd);
        addTaint(fd.getTaint());
        // ---------- Original Method ----------
        //BlockGuard.getThreadPolicy().onWriteToDisk();
        //os.fsync(fd);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.281 -0400", hash_original_method = "D97DA02F2520733C349FC66FF2A146AF", hash_generated_method = "5A9BC52814B0412735D4CA76E190E020")
    @Override
    public void ftruncate(FileDescriptor fd, long length) throws ErrnoException {
        BlockGuard.getThreadPolicy().onWriteToDisk();
        os.ftruncate(fd, length);
        addTaint(fd.getTaint());
        addTaint(length);
        // ---------- Original Method ----------
        //BlockGuard.getThreadPolicy().onWriteToDisk();
        //os.ftruncate(fd, length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.288 -0400", hash_original_method = "60BB804A04FED2996BE622E8EB3C8C72", hash_generated_method = "6D485B519FA77B3DA9BEDB27CB9EB5D5")
    @Override
    public FileDescriptor open(String path, int flags, int mode) throws ErrnoException {
        FileDescriptor varB4EAC82CA7396A68D541C85D26508E83_1672677316 = null; //Variable for return #1
        BlockGuard.getThreadPolicy().onReadFromDisk();
        {
            BlockGuard.getThreadPolicy().onWriteToDisk();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1672677316 = os.open(path, flags, mode);
        addTaint(path.getTaint());
        addTaint(flags);
        addTaint(mode);
        varB4EAC82CA7396A68D541C85D26508E83_1672677316.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1672677316;
        // ---------- Original Method ----------
        //BlockGuard.getThreadPolicy().onReadFromDisk();
        //if ((mode & O_ACCMODE) != O_RDONLY) {
            //BlockGuard.getThreadPolicy().onWriteToDisk();
        //}
        //return os.open(path, flags, mode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.289 -0400", hash_original_method = "F416944E2BAC8A3A477E3A9DF95661DC", hash_generated_method = "5119AC973559BFAD81113F0A704504EB")
    @Override
    public int poll(StructPollfd[] fds, int timeoutMs) throws ErrnoException {
        {
            BlockGuard.getThreadPolicy().onNetwork();
        } //End block
        int var48722583F516647909DDA26F0FCD9942_1288742856 = (os.poll(fds, timeoutMs));
        addTaint(fds[0].getTaint());
        addTaint(timeoutMs);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_635079301 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_635079301;
        // ---------- Original Method ----------
        //if (timeoutMs != 0) {
            //BlockGuard.getThreadPolicy().onNetwork();
        //}
        //return os.poll(fds, timeoutMs);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.291 -0400", hash_original_method = "B4077B073E0F60ADBED6DEE6A699AD14", hash_generated_method = "7817C04104DFCA99C0FEE60FB6B3731C")
    @Override
    public int pread(FileDescriptor fd, ByteBuffer buffer, long offset) throws ErrnoException {
        BlockGuard.getThreadPolicy().onReadFromDisk();
        int var8E37D63F084AD12D6EF74F78D0F34813_1581808885 = (os.pread(fd, buffer, offset));
        addTaint(fd.getTaint());
        addTaint(buffer.getTaint());
        addTaint(offset);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1913401128 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1913401128;
        // ---------- Original Method ----------
        //BlockGuard.getThreadPolicy().onReadFromDisk();
        //return os.pread(fd, buffer, offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.291 -0400", hash_original_method = "51D119A1C60E3F0FF85DFC4F5BCBEBDF", hash_generated_method = "04D9EFB72C8E7A61FC7B708E13B9C08F")
    @Override
    public int pread(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount, long offset) throws ErrnoException {
        BlockGuard.getThreadPolicy().onReadFromDisk();
        int var9596F97D25F40A8949B0F9D6651550A1_490837808 = (os.pread(fd, bytes, byteOffset, byteCount, offset));
        addTaint(fd.getTaint());
        addTaint(bytes[0]);
        addTaint(byteOffset);
        addTaint(byteCount);
        addTaint(offset);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1846248922 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1846248922;
        // ---------- Original Method ----------
        //BlockGuard.getThreadPolicy().onReadFromDisk();
        //return os.pread(fd, bytes, byteOffset, byteCount, offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.305 -0400", hash_original_method = "0F2134A6426D9EB8374019A9EA67DB6B", hash_generated_method = "8A02317ED9D7F9A2478BAEE6E16787B2")
    @Override
    public int pwrite(FileDescriptor fd, ByteBuffer buffer, long offset) throws ErrnoException {
        BlockGuard.getThreadPolicy().onWriteToDisk();
        int varBEC757109BB880DDBADF6015F3B05B2C_1568505992 = (os.pwrite(fd, buffer, offset));
        addTaint(fd.getTaint());
        addTaint(buffer.getTaint());
        addTaint(offset);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_970249456 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_970249456;
        // ---------- Original Method ----------
        //BlockGuard.getThreadPolicy().onWriteToDisk();
        //return os.pwrite(fd, buffer, offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.305 -0400", hash_original_method = "A4033B69E198E86AF41C6F2BD93A7F05", hash_generated_method = "AAF4D1F8A105C7C4290E3DFDDE7F1B27")
    @Override
    public int pwrite(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount, long offset) throws ErrnoException {
        BlockGuard.getThreadPolicy().onWriteToDisk();
        int var41A08F5DA487149A1F7C1270B58B9089_737953183 = (os.pwrite(fd, bytes, byteOffset, byteCount, offset));
        addTaint(fd.getTaint());
        addTaint(bytes[0]);
        addTaint(byteOffset);
        addTaint(byteCount);
        addTaint(offset);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_255447938 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_255447938;
        // ---------- Original Method ----------
        //BlockGuard.getThreadPolicy().onWriteToDisk();
        //return os.pwrite(fd, bytes, byteOffset, byteCount, offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.306 -0400", hash_original_method = "ED8C50F685094B5680C00B42F9F5F045", hash_generated_method = "5FF3339BE3E913D5C42AE2D5AFE9F374")
    @Override
    public int read(FileDescriptor fd, ByteBuffer buffer) throws ErrnoException {
        BlockGuard.getThreadPolicy().onReadFromDisk();
        int var5B8E7DC5191E81FE70C36AA027AFFCC8_1625124449 = (os.read(fd, buffer));
        addTaint(fd.getTaint());
        addTaint(buffer.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_320668323 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_320668323;
        // ---------- Original Method ----------
        //BlockGuard.getThreadPolicy().onReadFromDisk();
        //return os.read(fd, buffer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.306 -0400", hash_original_method = "2387C0D98FE16C1C4919C1D4A5A4F85D", hash_generated_method = "9E3F9A4494167A081AE84BF1607509AC")
    @Override
    public int read(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount) throws ErrnoException {
        BlockGuard.getThreadPolicy().onReadFromDisk();
        int varE59F1DA0F28FCDF7A959280195F03910_8497852 = (os.read(fd, bytes, byteOffset, byteCount));
        addTaint(fd.getTaint());
        addTaint(bytes[0]);
        addTaint(byteOffset);
        addTaint(byteCount);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_14711749 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_14711749;
        // ---------- Original Method ----------
        //BlockGuard.getThreadPolicy().onReadFromDisk();
        //return os.read(fd, bytes, byteOffset, byteCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.313 -0400", hash_original_method = "418568873B9A73D38D7FF96ACC4F4219", hash_generated_method = "5B115DD7870FC82BAC9B27B5D833498C")
    @Override
    public int readv(FileDescriptor fd, Object[] buffers, int[] offsets, int[] byteCounts) throws ErrnoException {
        BlockGuard.getThreadPolicy().onReadFromDisk();
        int var2494A58C76DD4D861DBB94DFA16C08A6_88965659 = (os.readv(fd, buffers, offsets, byteCounts));
        addTaint(fd.getTaint());
        addTaint(buffers[0].getTaint());
        addTaint(offsets[0]);
        addTaint(byteCounts[0]);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1593209145 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1593209145;
        // ---------- Original Method ----------
        //BlockGuard.getThreadPolicy().onReadFromDisk();
        //return os.readv(fd, buffers, offsets, byteCounts);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.314 -0400", hash_original_method = "E5449C41BDDE69AE1805A14CD8C0DB04", hash_generated_method = "64B006219C5A19D2BD5FD46A7D9AC352")
    @Override
    public int recvfrom(FileDescriptor fd, ByteBuffer buffer, int flags, InetSocketAddress srcAddress) throws ErrnoException {
        BlockGuard.getThreadPolicy().onNetwork();
        int varF25721B896E31A53482415C6A924C22D_91561525 = (os.recvfrom(fd, buffer, flags, srcAddress));
        addTaint(fd.getTaint());
        addTaint(buffer.getTaint());
        addTaint(flags);
        addTaint(srcAddress.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_40103017 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_40103017;
        // ---------- Original Method ----------
        //BlockGuard.getThreadPolicy().onNetwork();
        //return os.recvfrom(fd, buffer, flags, srcAddress);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.314 -0400", hash_original_method = "F697E31CA82538D4CA19A49211FAEDE8", hash_generated_method = "CC782F5035E80329217D182E170FE534")
    @Override
    public int recvfrom(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount, int flags, InetSocketAddress srcAddress) throws ErrnoException {
        BlockGuard.getThreadPolicy().onNetwork();
        int var3A59E5EE9728502FA7AEFF9DA4D0C096_1425576499 = (os.recvfrom(fd, bytes, byteOffset, byteCount, flags, srcAddress));
        addTaint(fd.getTaint());
        addTaint(bytes[0]);
        addTaint(byteOffset);
        addTaint(byteCount);
        addTaint(flags);
        addTaint(srcAddress.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_444092701 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_444092701;
        // ---------- Original Method ----------
        //BlockGuard.getThreadPolicy().onNetwork();
        //return os.recvfrom(fd, bytes, byteOffset, byteCount, flags, srcAddress);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.314 -0400", hash_original_method = "712364CE21E2D97A52399AF047375669", hash_generated_method = "724E257EC4F78052262E4FB5C2D3DD83")
    @Override
    public int sendto(FileDescriptor fd, ByteBuffer buffer, int flags, InetAddress inetAddress, int port) throws ErrnoException {
        BlockGuard.getThreadPolicy().onNetwork();
        int var0B8E7266620C88EB24F8453B4CECD027_425082384 = (os.sendto(fd, buffer, flags, inetAddress, port));
        addTaint(fd.getTaint());
        addTaint(buffer.getTaint());
        addTaint(flags);
        addTaint(inetAddress.getTaint());
        addTaint(port);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1998457822 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1998457822;
        // ---------- Original Method ----------
        //BlockGuard.getThreadPolicy().onNetwork();
        //return os.sendto(fd, buffer, flags, inetAddress, port);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.315 -0400", hash_original_method = "55701E5A28F22D42DFE5E9BDB107BB3B", hash_generated_method = "7BC08DB2C61F526CFBDDEBED87452519")
    @Override
    public int sendto(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount, int flags, InetAddress inetAddress, int port) throws ErrnoException {
        {
            BlockGuard.getThreadPolicy().onNetwork();
        } //End block
        int var8221F6255948EB137094ED72A9C8456A_419122976 = (os.sendto(fd, bytes, byteOffset, byteCount, flags, inetAddress, port));
        addTaint(fd.getTaint());
        addTaint(bytes[0]);
        addTaint(byteOffset);
        addTaint(byteCount);
        addTaint(flags);
        addTaint(inetAddress.getTaint());
        addTaint(port);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_395722694 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_395722694;
        // ---------- Original Method ----------
        //if (inetAddress != null) {
            //BlockGuard.getThreadPolicy().onNetwork();
        //}
        //return os.sendto(fd, bytes, byteOffset, byteCount, flags, inetAddress, port);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.315 -0400", hash_original_method = "3EA6FC55F29379EA1669AB58FC394717", hash_generated_method = "5B004996C8928DB30F401870437BD202")
    @Override
    public FileDescriptor socket(int domain, int type, int protocol) throws ErrnoException {
        FileDescriptor varB4EAC82CA7396A68D541C85D26508E83_1118034366 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1118034366 = tagSocket(os.socket(domain, type, protocol));
        addTaint(domain);
        addTaint(type);
        addTaint(protocol);
        varB4EAC82CA7396A68D541C85D26508E83_1118034366.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1118034366;
        // ---------- Original Method ----------
        //return tagSocket(os.socket(domain, type, protocol));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.319 -0400", hash_original_method = "5EE10271D9A1F133950EEC82FBA5FE84", hash_generated_method = "2DA45CE54F2DB2A4E030F2B8AEAEF651")
    @Override
    public int write(FileDescriptor fd, ByteBuffer buffer) throws ErrnoException {
        BlockGuard.getThreadPolicy().onWriteToDisk();
        int var0626357AF90ACF3FB1D934D119466787_896476392 = (os.write(fd, buffer));
        addTaint(fd.getTaint());
        addTaint(buffer.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_812167446 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_812167446;
        // ---------- Original Method ----------
        //BlockGuard.getThreadPolicy().onWriteToDisk();
        //return os.write(fd, buffer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.325 -0400", hash_original_method = "45958860FE67213CB5E2A0FF79C39AE3", hash_generated_method = "763699C619CFEE1E04BAE02636C603ED")
    @Override
    public int write(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount) throws ErrnoException {
        BlockGuard.getThreadPolicy().onWriteToDisk();
        int varE733C997547CF269F3AB7BAEB4D044AF_1110814198 = (os.write(fd, bytes, byteOffset, byteCount));
        addTaint(fd.getTaint());
        addTaint(bytes[0]);
        addTaint(byteOffset);
        addTaint(byteCount);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1636366831 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1636366831;
        // ---------- Original Method ----------
        //BlockGuard.getThreadPolicy().onWriteToDisk();
        //return os.write(fd, bytes, byteOffset, byteCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.332 -0400", hash_original_method = "5DBA61950559A586673FCC47110213A7", hash_generated_method = "6648E5A565981A85C3970EB46A028CE1")
    @Override
    public int writev(FileDescriptor fd, Object[] buffers, int[] offsets, int[] byteCounts) throws ErrnoException {
        BlockGuard.getThreadPolicy().onWriteToDisk();
        int var32F5E7D906A9F96A2B6412DC92928AD7_621216753 = (os.writev(fd, buffers, offsets, byteCounts));
        addTaint(fd.getTaint());
        addTaint(buffers[0].getTaint());
        addTaint(offsets[0]);
        addTaint(byteCounts[0]);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_326836275 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_326836275;
        // ---------- Original Method ----------
        //BlockGuard.getThreadPolicy().onWriteToDisk();
        //return os.writev(fd, buffers, offsets, byteCounts);
    }

    
}

