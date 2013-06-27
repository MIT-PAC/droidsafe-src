package libcore.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.FileDescriptor;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import libcore.util.MutableInt;
import libcore.util.MutableLong;

public class ForwardingOs implements Os {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.428 -0400", hash_original_field = "DD302F94682DBD2A114D63B0433602E0", hash_generated_field = "AD741EF2B519FC3080D4269DB2BABC3A")

    protected Os os;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.447 -0400", hash_original_method = "EC37328A0FF4DE634029572AA03E9806", hash_generated_method = "C41B14D0DEFEB2ECE4508496A7A2B2B8")
    public  ForwardingOs(Os os) {
        this.os = os;
        // ---------- Original Method ----------
        //this.os = os;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.448 -0400", hash_original_method = "5CF5B545FE52A5A749C69E4804E7DB37", hash_generated_method = "D6E662D3961DE9333C76D04FCD3F1316")
    public FileDescriptor accept(FileDescriptor fd, InetSocketAddress peerAddress) throws ErrnoException {
        FileDescriptor varB4EAC82CA7396A68D541C85D26508E83_1456888657 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1456888657 = os.accept(fd, peerAddress);
        addTaint(fd.getTaint());
        addTaint(peerAddress.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1456888657.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1456888657;
        // ---------- Original Method ----------
        //return os.accept(fd, peerAddress);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.448 -0400", hash_original_method = "FFD94E7AFE1E3B1F76A2D696707B6857", hash_generated_method = "3AC322F8F844074EC18695A8FCCCFEE0")
    public boolean access(String path, int mode) throws ErrnoException {
        boolean var172DEC5DD37258CD490DDB56CA7E2DB8_928813181 = (os.access(path, mode));
        addTaint(path.getTaint());
        addTaint(mode);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_423351823 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_423351823;
        // ---------- Original Method ----------
        //return os.access(path, mode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.449 -0400", hash_original_method = "743422D2EB39F172C4245C8DC993624F", hash_generated_method = "2C4F56DB987DDA5521904DED150E2276")
    public void bind(FileDescriptor fd, InetAddress address, int port) throws ErrnoException {
        os.bind(fd, address, port);
        addTaint(fd.getTaint());
        addTaint(address.getTaint());
        addTaint(port);
        // ---------- Original Method ----------
        //os.bind(fd, address, port);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.449 -0400", hash_original_method = "A92F7B75A5B2B90071388C67FA677A74", hash_generated_method = "25BEC27B5A16271F093E9447FC93F8BE")
    public void chmod(String path, int mode) throws ErrnoException {
        os.chmod(path, mode);
        addTaint(path.getTaint());
        addTaint(mode);
        // ---------- Original Method ----------
        //os.chmod(path, mode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.458 -0400", hash_original_method = "2AF652D8862D637B4A4051CAB7CD62FB", hash_generated_method = "0691BC1EEB0DF53658B22E295E231D1F")
    public void close(FileDescriptor fd) throws ErrnoException {
        os.close(fd);
        addTaint(fd.getTaint());
        // ---------- Original Method ----------
        //os.close(fd);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.478 -0400", hash_original_method = "FADD460EF8DBCF58AF836CFAB2496AF1", hash_generated_method = "15ABDFE7CCF265D5E298BF7816B64D67")
    public void connect(FileDescriptor fd, InetAddress address, int port) throws ErrnoException {
        os.connect(fd, address, port);
        addTaint(fd.getTaint());
        addTaint(address.getTaint());
        addTaint(port);
        // ---------- Original Method ----------
        //os.connect(fd, address, port);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.478 -0400", hash_original_method = "6162F8350974235CF8AA9EBE9F68335F", hash_generated_method = "B47F719AFC6DABC2469D304E82B2712F")
    public FileDescriptor dup(FileDescriptor oldFd) throws ErrnoException {
        FileDescriptor varB4EAC82CA7396A68D541C85D26508E83_1505969772 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1505969772 = os.dup(oldFd);
        addTaint(oldFd.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1505969772.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1505969772;
        // ---------- Original Method ----------
        //return os.dup(oldFd);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.480 -0400", hash_original_method = "E190E2A3CFD75C84461AB90FFE03369B", hash_generated_method = "EB203D2483CCC05129BBAF43BA9F2275")
    public FileDescriptor dup2(FileDescriptor oldFd, int newFd) throws ErrnoException {
        FileDescriptor varB4EAC82CA7396A68D541C85D26508E83_46571245 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_46571245 = os.dup2(oldFd, newFd);
        addTaint(oldFd.getTaint());
        addTaint(newFd);
        varB4EAC82CA7396A68D541C85D26508E83_46571245.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_46571245;
        // ---------- Original Method ----------
        //return os.dup2(oldFd, newFd);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.480 -0400", hash_original_method = "5CF51EBD75B5D23C7F632D7D494380D1", hash_generated_method = "C6B3BDDD55324A74C5D83B118E1EDB5C")
    public String[] environ() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_915357254 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_915357254 = os.environ();
        varB4EAC82CA7396A68D541C85D26508E83_915357254.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_915357254;
        // ---------- Original Method ----------
        //return os.environ();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.483 -0400", hash_original_method = "CA43F47313D11741B7EE5D06954736CB", hash_generated_method = "612CE64EBC30CDA2C9EE99967A4011BB")
    public int fcntlVoid(FileDescriptor fd, int cmd) throws ErrnoException {
        int varBF1653E2CBDC0EBDA030B66FA450FCF0_1751700579 = (os.fcntlVoid(fd, cmd));
        addTaint(fd.getTaint());
        addTaint(cmd);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1757086719 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1757086719;
        // ---------- Original Method ----------
        //return os.fcntlVoid(fd, cmd);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.484 -0400", hash_original_method = "6B248418A1B43AC8597DD680343F17BD", hash_generated_method = "F783C74ABA6D768B540AFBD0BCA7CBEE")
    public int fcntlLong(FileDescriptor fd, int cmd, long arg) throws ErrnoException {
        int var97EF80FEE8D7DCAFEADBFC1210BDC18B_1694291327 = (os.fcntlLong(fd, cmd, arg));
        addTaint(fd.getTaint());
        addTaint(cmd);
        addTaint(arg);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_752408314 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_752408314;
        // ---------- Original Method ----------
        //return os.fcntlLong(fd, cmd, arg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.484 -0400", hash_original_method = "28B6741D270DBCC0BDA43B4FBA76C484", hash_generated_method = "6BCB3525C56C19D0576F14CACC493ADA")
    public int fcntlFlock(FileDescriptor fd, int cmd, StructFlock arg) throws ErrnoException {
        int var2729B8DD99A4FEEBABCEFB3EF912E159_889792846 = (os.fcntlFlock(fd, cmd, arg));
        addTaint(fd.getTaint());
        addTaint(cmd);
        addTaint(arg.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1018564560 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1018564560;
        // ---------- Original Method ----------
        //return os.fcntlFlock(fd, cmd, arg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.484 -0400", hash_original_method = "D2B4800A8551761D0A11CAE1762DA39E", hash_generated_method = "573D02F895F974160BDFA32E6A78A43A")
    public void fdatasync(FileDescriptor fd) throws ErrnoException {
        os.fdatasync(fd);
        addTaint(fd.getTaint());
        // ---------- Original Method ----------
        //os.fdatasync(fd);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.485 -0400", hash_original_method = "0159E8BC0EB89F7B9A8B0DA54E55E46B", hash_generated_method = "32187E8C9156178E1A165C80BA5827BA")
    public StructStat fstat(FileDescriptor fd) throws ErrnoException {
        StructStat varB4EAC82CA7396A68D541C85D26508E83_1229383589 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1229383589 = os.fstat(fd);
        addTaint(fd.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1229383589.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1229383589;
        // ---------- Original Method ----------
        //return os.fstat(fd);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.485 -0400", hash_original_method = "1D4670A49E88E5904763EEFCF378AA9C", hash_generated_method = "83936607D64B3E1459657F47D1292C3A")
    public StructStatFs fstatfs(FileDescriptor fd) throws ErrnoException {
        StructStatFs varB4EAC82CA7396A68D541C85D26508E83_767122155 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_767122155 = os.fstatfs(fd);
        addTaint(fd.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_767122155.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_767122155;
        // ---------- Original Method ----------
        //return os.fstatfs(fd);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.506 -0400", hash_original_method = "5A3103E0191F55AC2413EF7A293382EA", hash_generated_method = "862ACD95EBCD31133FC7E286CD6E9E80")
    public void fsync(FileDescriptor fd) throws ErrnoException {
        os.fsync(fd);
        addTaint(fd.getTaint());
        // ---------- Original Method ----------
        //os.fsync(fd);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.507 -0400", hash_original_method = "B89F13DA07AD88D9E35FDD0F8C706602", hash_generated_method = "551BB12398467F3C8EB23F5C296B7D11")
    public void ftruncate(FileDescriptor fd, long length) throws ErrnoException {
        os.ftruncate(fd, length);
        addTaint(fd.getTaint());
        addTaint(length);
        // ---------- Original Method ----------
        //os.ftruncate(fd, length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.507 -0400", hash_original_method = "4EDF3DB0839BDB5BB59D5BDCF6ED266B", hash_generated_method = "5238BF93B911C7C198BA3660FCF9A88B")
    public String gai_strerror(int error) {
        String varB4EAC82CA7396A68D541C85D26508E83_847643771 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_847643771 = os.gai_strerror(error);
        addTaint(error);
        varB4EAC82CA7396A68D541C85D26508E83_847643771.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_847643771;
        // ---------- Original Method ----------
        //return os.gai_strerror(error);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.508 -0400", hash_original_method = "D134969B79309E2FFE6734562680F40F", hash_generated_method = "95E5DC0A5B23C4CF96BB9F6358090605")
    public InetAddress[] getaddrinfo(String node, StructAddrinfo hints) throws GaiException {
        InetAddress[] varB4EAC82CA7396A68D541C85D26508E83_426996369 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_426996369 = os.getaddrinfo(node, hints);
        addTaint(node.getTaint());
        addTaint(hints.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_426996369.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_426996369;
        // ---------- Original Method ----------
        //return os.getaddrinfo(node, hints);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.509 -0400", hash_original_method = "DA32E4A67BBB878517DC4C1F6AD2DE47", hash_generated_method = "557FC3E6DF9D56E526A1A56F350111E3")
    public int getegid() {
        int varD8065AE9128D4E02D412A3250EE4BEA6_241402627 = (os.getegid());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1727248534 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1727248534;
        // ---------- Original Method ----------
        //return os.getegid();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.509 -0400", hash_original_method = "FAD72A6DE2CC7E2DB1B9B6FC41642D5B", hash_generated_method = "FEDEC38C9D8698CA5B067EBD604A200C")
    public int geteuid() {
        int var56D743784E549DA0B7EA1F9C189A6471_1023723867 = (os.geteuid());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_861045106 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_861045106;
        // ---------- Original Method ----------
        //return os.geteuid();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.521 -0400", hash_original_method = "FADA5B6063E47C208AC2D0843F6EB847", hash_generated_method = "6F51D94F2A4961CD435BE0B381DCA241")
    public int getgid() {
        int var6CADC2A35DC4D6A9A5A15CAB17B4B6E3_1101885197 = (os.getgid());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1266576822 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1266576822;
        // ---------- Original Method ----------
        //return os.getgid();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.521 -0400", hash_original_method = "E4B66B682B354EFDCC2A2307B9973162", hash_generated_method = "89291BC19338CFCB6B506B9B587DF62D")
    public String getenv(String name) {
        String varB4EAC82CA7396A68D541C85D26508E83_1176239552 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1176239552 = os.getenv(name);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1176239552.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1176239552;
        // ---------- Original Method ----------
        //return os.getenv(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.522 -0400", hash_original_method = "95C6CCF446FE941364E9F3FC808640B5", hash_generated_method = "BF59CE5A330F24D12DA49B397036A892")
    public String getnameinfo(InetAddress address, int flags) throws GaiException {
        String varB4EAC82CA7396A68D541C85D26508E83_379998396 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_379998396 = os.getnameinfo(address, flags);
        addTaint(address.getTaint());
        addTaint(flags);
        varB4EAC82CA7396A68D541C85D26508E83_379998396.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_379998396;
        // ---------- Original Method ----------
        //return os.getnameinfo(address, flags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.523 -0400", hash_original_method = "A3B371C9A268817901795576D0A04CF6", hash_generated_method = "9B0886D3FA3B0198E94D5316E24309C7")
    public int getpid() {
        int var38AA61BF3E54239C4504A81A8746FA43_1497431964 = (os.getpid());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1227155964 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1227155964;
        // ---------- Original Method ----------
        //return os.getpid();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.539 -0400", hash_original_method = "878D1FDE3DC9E3A460294EB2A78F5342", hash_generated_method = "503353C2E61C7919A4D2A68A5896CBA6")
    public int getppid() {
        int var1F662189AEACAB508948D811AFEC491B_1347501400 = (os.getppid());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_776619896 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_776619896;
        // ---------- Original Method ----------
        //return os.getppid();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.539 -0400", hash_original_method = "A3C50DDCB01897A6F2E46FE623EA65A2", hash_generated_method = "3E79612E98FE190255A669344F107F62")
    public StructPasswd getpwnam(String name) throws ErrnoException {
        StructPasswd varB4EAC82CA7396A68D541C85D26508E83_118757898 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_118757898 = os.getpwnam(name);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_118757898.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_118757898;
        // ---------- Original Method ----------
        //return os.getpwnam(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.540 -0400", hash_original_method = "F069BDB68A1BE69C49E58A44BE7A4944", hash_generated_method = "CA860D7B931E38B5AD8F903DBD0690DA")
    public StructPasswd getpwuid(int uid) throws ErrnoException {
        StructPasswd varB4EAC82CA7396A68D541C85D26508E83_1533465766 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1533465766 = os.getpwuid(uid);
        addTaint(uid);
        varB4EAC82CA7396A68D541C85D26508E83_1533465766.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1533465766;
        // ---------- Original Method ----------
        //return os.getpwuid(uid);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.555 -0400", hash_original_method = "C71AB83C8CB24831B3B392DF1EFA2A55", hash_generated_method = "14821F7FCC63229868162564627623FC")
    public SocketAddress getsockname(FileDescriptor fd) throws ErrnoException {
        SocketAddress varB4EAC82CA7396A68D541C85D26508E83_917435028 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_917435028 = os.getsockname(fd);
        addTaint(fd.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_917435028.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_917435028;
        // ---------- Original Method ----------
        //return os.getsockname(fd);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.555 -0400", hash_original_method = "E5D66E4A2B17F99E78F6B2E97C4D0018", hash_generated_method = "E31DD39E461C162E81132203B94B230B")
    public int getsockoptByte(FileDescriptor fd, int level, int option) throws ErrnoException {
        int var46B88F2A6E8AFD10C1C2A4CB4FA13847_1367522506 = (os.getsockoptByte(fd, level, option));
        addTaint(fd.getTaint());
        addTaint(level);
        addTaint(option);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1011166164 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1011166164;
        // ---------- Original Method ----------
        //return os.getsockoptByte(fd, level, option);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.556 -0400", hash_original_method = "0CBF6F7E2BE2FF171C45C7BCFC831012", hash_generated_method = "C30FCB783413CA256E26CD91B5C6E212")
    public InetAddress getsockoptInAddr(FileDescriptor fd, int level, int option) throws ErrnoException {
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_1137224279 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1137224279 = os.getsockoptInAddr(fd, level, option);
        addTaint(fd.getTaint());
        addTaint(level);
        addTaint(option);
        varB4EAC82CA7396A68D541C85D26508E83_1137224279.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1137224279;
        // ---------- Original Method ----------
        //return os.getsockoptInAddr(fd, level, option);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.556 -0400", hash_original_method = "946A87B9C2E87F4C961C36C4569A31BA", hash_generated_method = "2E32B54F013BA86CCF86003741ABB3D6")
    public int getsockoptInt(FileDescriptor fd, int level, int option) throws ErrnoException {
        int varE08D816983313FAA61DC4FC565C65ADD_1473660893 = (os.getsockoptInt(fd, level, option));
        addTaint(fd.getTaint());
        addTaint(level);
        addTaint(option);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_496583209 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_496583209;
        // ---------- Original Method ----------
        //return os.getsockoptInt(fd, level, option);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.557 -0400", hash_original_method = "EBD2988D937DD58B5AD9697AEE85A0FB", hash_generated_method = "CF9A11631D62052D3598BEBE2525CAA8")
    public StructLinger getsockoptLinger(FileDescriptor fd, int level, int option) throws ErrnoException {
        StructLinger varB4EAC82CA7396A68D541C85D26508E83_1572671441 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1572671441 = os.getsockoptLinger(fd, level, option);
        addTaint(fd.getTaint());
        addTaint(level);
        addTaint(option);
        varB4EAC82CA7396A68D541C85D26508E83_1572671441.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1572671441;
        // ---------- Original Method ----------
        //return os.getsockoptLinger(fd, level, option);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.558 -0400", hash_original_method = "1C478D9E653EA1E4A0CA2442FA9E2156", hash_generated_method = "1E02B83CC2F80A599EA1556292E98767")
    public StructTimeval getsockoptTimeval(FileDescriptor fd, int level, int option) throws ErrnoException {
        StructTimeval varB4EAC82CA7396A68D541C85D26508E83_1559516632 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1559516632 = os.getsockoptTimeval(fd, level, option);
        addTaint(fd.getTaint());
        addTaint(level);
        addTaint(option);
        varB4EAC82CA7396A68D541C85D26508E83_1559516632.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1559516632;
        // ---------- Original Method ----------
        //return os.getsockoptTimeval(fd, level, option);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.558 -0400", hash_original_method = "2F11239B76600858937301E80656F86F", hash_generated_method = "C7235400EA848D5294819115A69BCBE9")
    public int getuid() {
        int var6E1C401E18C533CAAAF3A5BDCCAC0B20_761832167 = (os.getuid());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1333921161 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1333921161;
        // ---------- Original Method ----------
        //return os.getuid();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.576 -0400", hash_original_method = "FD1CFE447DC743FEF7DD120355028D01", hash_generated_method = "C9130B83E5D089525AC0A8E99E366C88")
    public String if_indextoname(int index) {
        String varB4EAC82CA7396A68D541C85D26508E83_809370592 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_809370592 = os.if_indextoname(index);
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_809370592.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_809370592;
        // ---------- Original Method ----------
        //return os.if_indextoname(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.577 -0400", hash_original_method = "244F6B5FD78AC80358A10468727F943C", hash_generated_method = "85B4A9A41D538869B73FDD46D8EF83D8")
    public InetAddress inet_pton(int family, String address) {
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_1783136026 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1783136026 = os.inet_pton(family, address);
        addTaint(family);
        addTaint(address.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1783136026.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1783136026;
        // ---------- Original Method ----------
        //return os.inet_pton(family, address);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.577 -0400", hash_original_method = "81C548F366545C14DF26B9A5D253BEA5", hash_generated_method = "BC8D8EC351BEA175F20578A870863973")
    public InetAddress ioctlInetAddress(FileDescriptor fd, int cmd, String interfaceName) throws ErrnoException {
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_134128682 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_134128682 = os.ioctlInetAddress(fd, cmd, interfaceName);
        addTaint(fd.getTaint());
        addTaint(cmd);
        addTaint(interfaceName.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_134128682.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_134128682;
        // ---------- Original Method ----------
        //return os.ioctlInetAddress(fd, cmd, interfaceName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.578 -0400", hash_original_method = "B9A716BFE88006BFE54885EB5B40EF6E", hash_generated_method = "0898E61D987B7601D3B75B49FE626716")
    public int ioctlInt(FileDescriptor fd, int cmd, MutableInt arg) throws ErrnoException {
        int varD9D1F852ABD2929B5B4A1DF95D32EC90_247996323 = (os.ioctlInt(fd, cmd, arg));
        addTaint(fd.getTaint());
        addTaint(cmd);
        addTaint(arg.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_9574866 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_9574866;
        // ---------- Original Method ----------
        //return os.ioctlInt(fd, cmd, arg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.579 -0400", hash_original_method = "E622E0FA602C62724E493B1B03996EEA", hash_generated_method = "808CF8051B43E4E0D1F337EA5631F7E3")
    public boolean isatty(FileDescriptor fd) {
        boolean var1BDE8D20FF5CAACE3E2EB14F5484BA59_1599514668 = (os.isatty(fd));
        addTaint(fd.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1092608721 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1092608721;
        // ---------- Original Method ----------
        //return os.isatty(fd);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.579 -0400", hash_original_method = "39C5C221EF1E81F6FE3B9410463D5E57", hash_generated_method = "2A652D0CC61257924637F3B4524AB2ED")
    public void kill(int pid, int signal) throws ErrnoException {
        os.kill(pid, signal);
        addTaint(pid);
        addTaint(signal);
        // ---------- Original Method ----------
        //os.kill(pid, signal);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.579 -0400", hash_original_method = "039EEA76B9DC6E04921BFC5BC270EDD9", hash_generated_method = "EF536F2D00F74E235D928577CD3328A5")
    public void listen(FileDescriptor fd, int backlog) throws ErrnoException {
        os.listen(fd, backlog);
        addTaint(fd.getTaint());
        addTaint(backlog);
        // ---------- Original Method ----------
        //os.listen(fd, backlog);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.579 -0400", hash_original_method = "3005A45BFDFB73561B6BABAEF57B12E1", hash_generated_method = "E4373D7F4C166A6D20DBC3B9E24F664D")
    public long lseek(FileDescriptor fd, long offset, int whence) throws ErrnoException {
        long var00BC20AD4BC3DA29C7F7761FC82BB0E6_1643293642 = (os.lseek(fd, offset, whence));
        addTaint(fd.getTaint());
        addTaint(offset);
        addTaint(whence);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_320443829 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_320443829;
        // ---------- Original Method ----------
        //return os.lseek(fd, offset, whence);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.580 -0400", hash_original_method = "F288030A10BA391FE6D7AD19552493B8", hash_generated_method = "B9A603700B605FB5C13A1CEEF1A54D00")
    public StructStat lstat(String path) throws ErrnoException {
        StructStat varB4EAC82CA7396A68D541C85D26508E83_1775146136 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1775146136 = os.lstat(path);
        addTaint(path.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1775146136.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1775146136;
        // ---------- Original Method ----------
        //return os.lstat(path);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.580 -0400", hash_original_method = "0D8D349CD4EFD867777AD4E59116610D", hash_generated_method = "0A1847CF7EEC8E9DC66F9219B36FE04B")
    public void mincore(long address, long byteCount, byte[] vector) throws ErrnoException {
        os.mincore(address, byteCount, vector);
        addTaint(address);
        addTaint(byteCount);
        addTaint(vector[0]);
        // ---------- Original Method ----------
        //os.mincore(address, byteCount, vector);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.597 -0400", hash_original_method = "689C229BD7F4B7F5308857A16DB04D8E", hash_generated_method = "B3FDA2E6552179AB66F6BBBC382EBDAE")
    public void mkdir(String path, int mode) throws ErrnoException {
        os.mkdir(path, mode);
        addTaint(path.getTaint());
        addTaint(mode);
        // ---------- Original Method ----------
        //os.mkdir(path, mode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.598 -0400", hash_original_method = "419517122697B0628E53EB3E2B0A6370", hash_generated_method = "13BD8890090968567A2F57958022BFE6")
    public void mlock(long address, long byteCount) throws ErrnoException {
        os.mlock(address, byteCount);
        addTaint(address);
        addTaint(byteCount);
        // ---------- Original Method ----------
        //os.mlock(address, byteCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.599 -0400", hash_original_method = "4029BCDA0489C716FD1384F50323A029", hash_generated_method = "3E48C1C79F5A93B03EA06E343D9BE510")
    public long mmap(long address, long byteCount, int prot, int flags, FileDescriptor fd, long offset) throws ErrnoException {
        long var3045E876657A6DFFC0A2A0AFB33818CC_945163697 = (os.mmap(address, byteCount, prot, flags, fd, offset));
        addTaint(address);
        addTaint(byteCount);
        addTaint(prot);
        addTaint(flags);
        addTaint(fd.getTaint());
        addTaint(offset);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_2101233009 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_2101233009;
        // ---------- Original Method ----------
        //return os.mmap(address, byteCount, prot, flags, fd, offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.599 -0400", hash_original_method = "26058ECBCE0A88D4B8D4418B78F705C5", hash_generated_method = "B3FF0C6B6F74DBE6935D16BA8C27125B")
    public void msync(long address, long byteCount, int flags) throws ErrnoException {
        os.msync(address, byteCount, flags);
        addTaint(address);
        addTaint(byteCount);
        addTaint(flags);
        // ---------- Original Method ----------
        //os.msync(address, byteCount, flags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.600 -0400", hash_original_method = "12F3B374B5C7D041381B26987EDF7BE8", hash_generated_method = "F14D84EEE2DC5E8DEA4BB6D495547D30")
    public void munlock(long address, long byteCount) throws ErrnoException {
        os.munlock(address, byteCount);
        addTaint(address);
        addTaint(byteCount);
        // ---------- Original Method ----------
        //os.munlock(address, byteCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.600 -0400", hash_original_method = "93EF25630433342C6922044F58653EDA", hash_generated_method = "356606A69AA5950B9FE2BB3C0E2BB836")
    public void munmap(long address, long byteCount) throws ErrnoException {
        os.munmap(address, byteCount);
        addTaint(address);
        addTaint(byteCount);
        // ---------- Original Method ----------
        //os.munmap(address, byteCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.601 -0400", hash_original_method = "3A1C8AE14DFE6F094F17065084A852DA", hash_generated_method = "DB7D7EF500531417934DE326F721BBFB")
    public FileDescriptor open(String path, int flags, int mode) throws ErrnoException {
        FileDescriptor varB4EAC82CA7396A68D541C85D26508E83_1224680240 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1224680240 = os.open(path, flags, mode);
        addTaint(path.getTaint());
        addTaint(flags);
        addTaint(mode);
        varB4EAC82CA7396A68D541C85D26508E83_1224680240.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1224680240;
        // ---------- Original Method ----------
        //return os.open(path, flags, mode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.612 -0400", hash_original_method = "C44D806183F8681F84B21225E3DD2820", hash_generated_method = "88A70E1768971361862E52292C455E6E")
    public FileDescriptor[] pipe() throws ErrnoException {
        FileDescriptor[] varB4EAC82CA7396A68D541C85D26508E83_1694211042 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1694211042 = os.pipe();
        varB4EAC82CA7396A68D541C85D26508E83_1694211042.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1694211042;
        // ---------- Original Method ----------
        //return os.pipe();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.612 -0400", hash_original_method = "5599B9E106312A6343AFDB459C1296E6", hash_generated_method = "85A1409D4690983E405BAC0D1A8E7794")
    public int poll(StructPollfd[] fds, int timeoutMs) throws ErrnoException {
        int var48722583F516647909DDA26F0FCD9942_472733535 = (os.poll(fds, timeoutMs));
        addTaint(fds[0].getTaint());
        addTaint(timeoutMs);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1403191907 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1403191907;
        // ---------- Original Method ----------
        //return os.poll(fds, timeoutMs);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.613 -0400", hash_original_method = "E02E4577E71F70F2C9CAE7AED1E2F8AC", hash_generated_method = "D1C4FDB790C86D16ED73F5D5088960C9")
    public int pread(FileDescriptor fd, ByteBuffer buffer, long offset) throws ErrnoException {
        int var8E37D63F084AD12D6EF74F78D0F34813_518273193 = (os.pread(fd, buffer, offset));
        addTaint(fd.getTaint());
        addTaint(buffer.getTaint());
        addTaint(offset);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1168774970 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1168774970;
        // ---------- Original Method ----------
        //return os.pread(fd, buffer, offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.613 -0400", hash_original_method = "77B89AD0CF3C5D71E7DD42E992F283EF", hash_generated_method = "B3D3BFB08AB1275193B9057369485CD8")
    public int pread(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount, long offset) throws ErrnoException {
        int var9596F97D25F40A8949B0F9D6651550A1_747078462 = (os.pread(fd, bytes, byteOffset, byteCount, offset));
        addTaint(fd.getTaint());
        addTaint(bytes[0]);
        addTaint(byteOffset);
        addTaint(byteCount);
        addTaint(offset);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_238102711 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_238102711;
        // ---------- Original Method ----------
        //return os.pread(fd, bytes, byteOffset, byteCount, offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.614 -0400", hash_original_method = "1CD5001FEE779ACE9E3DB9100CD609FC", hash_generated_method = "AA3F1C53C8F0700330D564F174E5495E")
    public int pwrite(FileDescriptor fd, ByteBuffer buffer, long offset) throws ErrnoException {
        int varBEC757109BB880DDBADF6015F3B05B2C_1065401751 = (os.pwrite(fd, buffer, offset));
        addTaint(fd.getTaint());
        addTaint(buffer.getTaint());
        addTaint(offset);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1000150488 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1000150488;
        // ---------- Original Method ----------
        //return os.pwrite(fd, buffer, offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.614 -0400", hash_original_method = "F0611566A9565E2DEF97709E6B9B6418", hash_generated_method = "B803F5FB15C2F433EBC300403A64F856")
    public int pwrite(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount, long offset) throws ErrnoException {
        int var41A08F5DA487149A1F7C1270B58B9089_1229595454 = (os.pwrite(fd, bytes, byteOffset, byteCount, offset));
        addTaint(fd.getTaint());
        addTaint(bytes[0]);
        addTaint(byteOffset);
        addTaint(byteCount);
        addTaint(offset);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1289427482 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1289427482;
        // ---------- Original Method ----------
        //return os.pwrite(fd, bytes, byteOffset, byteCount, offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.614 -0400", hash_original_method = "F3C222630BE6E1046A8D40208CD4C60B", hash_generated_method = "8763299A3CB7B21161F11381A6E2C435")
    public int read(FileDescriptor fd, ByteBuffer buffer) throws ErrnoException {
        int var5B8E7DC5191E81FE70C36AA027AFFCC8_1735605670 = (os.read(fd, buffer));
        addTaint(fd.getTaint());
        addTaint(buffer.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_841401026 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_841401026;
        // ---------- Original Method ----------
        //return os.read(fd, buffer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.615 -0400", hash_original_method = "21F8B1ED0ECF46FDBCE6EA979BADF2C3", hash_generated_method = "76D6C16FC9D99B6499F13825289766DC")
    public int read(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount) throws ErrnoException {
        int varE59F1DA0F28FCDF7A959280195F03910_1913628984 = (os.read(fd, bytes, byteOffset, byteCount));
        addTaint(fd.getTaint());
        addTaint(bytes[0]);
        addTaint(byteOffset);
        addTaint(byteCount);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1668810300 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1668810300;
        // ---------- Original Method ----------
        //return os.read(fd, bytes, byteOffset, byteCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.615 -0400", hash_original_method = "E2800F54CC6608A5FBBD1BF36223D806", hash_generated_method = "3B481C6B3DD030D535F80798971FF686")
    public int readv(FileDescriptor fd, Object[] buffers, int[] offsets, int[] byteCounts) throws ErrnoException {
        int var2494A58C76DD4D861DBB94DFA16C08A6_1195494376 = (os.readv(fd, buffers, offsets, byteCounts));
        addTaint(fd.getTaint());
        addTaint(buffers[0].getTaint());
        addTaint(offsets[0]);
        addTaint(byteCounts[0]);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_210165546 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_210165546;
        // ---------- Original Method ----------
        //return os.readv(fd, buffers, offsets, byteCounts);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.631 -0400", hash_original_method = "84F37C132BD33033E9DE4E38A8430067", hash_generated_method = "E24DFB3E8DC4180D20F5DF624F9A7765")
    public int recvfrom(FileDescriptor fd, ByteBuffer buffer, int flags, InetSocketAddress srcAddress) throws ErrnoException {
        int varF25721B896E31A53482415C6A924C22D_1309389673 = (os.recvfrom(fd, buffer, flags, srcAddress));
        addTaint(fd.getTaint());
        addTaint(buffer.getTaint());
        addTaint(flags);
        addTaint(srcAddress.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1709691064 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1709691064;
        // ---------- Original Method ----------
        //return os.recvfrom(fd, buffer, flags, srcAddress);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.632 -0400", hash_original_method = "0394D475125B49320B23E75594B5C434", hash_generated_method = "4407F9ED7D74CC9F6779E08C8676131A")
    public int recvfrom(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount, int flags, InetSocketAddress srcAddress) throws ErrnoException {
        int var3A59E5EE9728502FA7AEFF9DA4D0C096_213914644 = (os.recvfrom(fd, bytes, byteOffset, byteCount, flags, srcAddress));
        addTaint(fd.getTaint());
        addTaint(bytes[0]);
        addTaint(byteOffset);
        addTaint(byteCount);
        addTaint(flags);
        addTaint(srcAddress.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1314595859 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1314595859;
        // ---------- Original Method ----------
        //return os.recvfrom(fd, bytes, byteOffset, byteCount, flags, srcAddress);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.632 -0400", hash_original_method = "B12B5B450AD1F25F30BAE5F7F0558752", hash_generated_method = "B967C63C94D7FFC1BF04F3CB4178010B")
    public void remove(String path) throws ErrnoException {
        os.remove(path);
        addTaint(path.getTaint());
        // ---------- Original Method ----------
        //os.remove(path);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.633 -0400", hash_original_method = "91C997D77FC3A21A4E5692674F9BE11B", hash_generated_method = "9178B74C9305F48F4B3F361B7C836E95")
    public void rename(String oldPath, String newPath) throws ErrnoException {
        os.rename(oldPath, newPath);
        addTaint(oldPath.getTaint());
        addTaint(newPath.getTaint());
        // ---------- Original Method ----------
        //os.rename(oldPath, newPath);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.633 -0400", hash_original_method = "C572D6E07635A5094C687364A5671672", hash_generated_method = "49685DD429533DE30E6D76E7CE4B6843")
    public long sendfile(FileDescriptor outFd, FileDescriptor inFd, MutableLong inOffset, long byteCount) throws ErrnoException {
        long varA7A8691BB87D642123D80A6B9B64BEE0_1581544389 = (os.sendfile(outFd, inFd, inOffset, byteCount));
        addTaint(outFd.getTaint());
        addTaint(inFd.getTaint());
        addTaint(inOffset.getTaint());
        addTaint(byteCount);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1368353262 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1368353262;
        // ---------- Original Method ----------
        //return os.sendfile(outFd, inFd, inOffset, byteCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.633 -0400", hash_original_method = "88066FF66E9BA638CFCEFABD2B423922", hash_generated_method = "B0842858C19A52BD9B2897A0E3F31BFE")
    public int sendto(FileDescriptor fd, ByteBuffer buffer, int flags, InetAddress inetAddress, int port) throws ErrnoException {
        int var0B8E7266620C88EB24F8453B4CECD027_1927873331 = (os.sendto(fd, buffer, flags, inetAddress, port));
        addTaint(fd.getTaint());
        addTaint(buffer.getTaint());
        addTaint(flags);
        addTaint(inetAddress.getTaint());
        addTaint(port);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_922125487 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_922125487;
        // ---------- Original Method ----------
        //return os.sendto(fd, buffer, flags, inetAddress, port);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.638 -0400", hash_original_method = "BC2321A87F2222D5681A88900983F12D", hash_generated_method = "403DDD87C93966643AEA544FD1F45ABB")
    public int sendto(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount, int flags, InetAddress inetAddress, int port) throws ErrnoException {
        int var8221F6255948EB137094ED72A9C8456A_304175282 = (os.sendto(fd, bytes, byteOffset, byteCount, flags, inetAddress, port));
        addTaint(fd.getTaint());
        addTaint(bytes[0]);
        addTaint(byteOffset);
        addTaint(byteCount);
        addTaint(flags);
        addTaint(inetAddress.getTaint());
        addTaint(port);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1822022507 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1822022507;
        // ---------- Original Method ----------
        //return os.sendto(fd, bytes, byteOffset, byteCount, flags, inetAddress, port);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.638 -0400", hash_original_method = "D0978EE2EC25CFB475F603941EE6E321", hash_generated_method = "93A356037B7F8F8A962EFD27155AD531")
    public void setegid(int egid) throws ErrnoException {
        os.setegid(egid);
        addTaint(egid);
        // ---------- Original Method ----------
        //os.setegid(egid);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.638 -0400", hash_original_method = "0B3E20A1D3AFC99676F4A67D4967A4C5", hash_generated_method = "699125BC0719E8B2E50628845CF93B03")
    public void seteuid(int euid) throws ErrnoException {
        os.seteuid(euid);
        addTaint(euid);
        // ---------- Original Method ----------
        //os.seteuid(euid);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.638 -0400", hash_original_method = "5A836F22DA1ADF6236109717B09FFB11", hash_generated_method = "A512CE4B0BD677A24C1BF3C917EFDD1E")
    public void setgid(int gid) throws ErrnoException {
        os.setgid(gid);
        addTaint(gid);
        // ---------- Original Method ----------
        //os.setgid(gid);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.639 -0400", hash_original_method = "02713B5D8B1D9FC1829D645D7EE01360", hash_generated_method = "5ECCD84913650232A3A4D5918E275F5D")
    public void setsockoptByte(FileDescriptor fd, int level, int option, int value) throws ErrnoException {
        os.setsockoptByte(fd, level, option, value);
        addTaint(fd.getTaint());
        addTaint(level);
        addTaint(option);
        addTaint(value);
        // ---------- Original Method ----------
        //os.setsockoptByte(fd, level, option, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.639 -0400", hash_original_method = "859AD73B12F1FCBFB785F9C03E57780C", hash_generated_method = "B75504C71233A1B25169781E78FBEA32")
    public void setsockoptIfreq(FileDescriptor fd, int level, int option, String value) throws ErrnoException {
        os.setsockoptIfreq(fd, level, option, value);
        addTaint(fd.getTaint());
        addTaint(level);
        addTaint(option);
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //os.setsockoptIfreq(fd, level, option, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.639 -0400", hash_original_method = "5882A7C612198E8B1D9CBF2EDBCD6FE7", hash_generated_method = "95BD4E07E874A3C53418A957A1DAFACC")
    public void setsockoptInt(FileDescriptor fd, int level, int option, int value) throws ErrnoException {
        os.setsockoptInt(fd, level, option, value);
        addTaint(fd.getTaint());
        addTaint(level);
        addTaint(option);
        addTaint(value);
        // ---------- Original Method ----------
        //os.setsockoptInt(fd, level, option, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.639 -0400", hash_original_method = "3A8741E8D07270D7E757C05217AEFD39", hash_generated_method = "966031E85B0BB54980D857F07D367B73")
    public void setsockoptIpMreqn(FileDescriptor fd, int level, int option, int value) throws ErrnoException {
        os.setsockoptIpMreqn(fd, level, option, value);
        addTaint(fd.getTaint());
        addTaint(level);
        addTaint(option);
        addTaint(value);
        // ---------- Original Method ----------
        //os.setsockoptIpMreqn(fd, level, option, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.658 -0400", hash_original_method = "4E1D080A99B5B2F06B7A0201A27B3E99", hash_generated_method = "677217554288830723E73088DCBC1BCB")
    public void setsockoptGroupReq(FileDescriptor fd, int level, int option, StructGroupReq value) throws ErrnoException {
        os.setsockoptGroupReq(fd, level, option, value);
        addTaint(fd.getTaint());
        addTaint(level);
        addTaint(option);
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //os.setsockoptGroupReq(fd, level, option, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.658 -0400", hash_original_method = "A1EC25C1EA10D3E94DA65D129945BE62", hash_generated_method = "221A8CF27FEFEF11FD706E6FDC2DC322")
    public void setsockoptLinger(FileDescriptor fd, int level, int option, StructLinger value) throws ErrnoException {
        os.setsockoptLinger(fd, level, option, value);
        addTaint(fd.getTaint());
        addTaint(level);
        addTaint(option);
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //os.setsockoptLinger(fd, level, option, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.658 -0400", hash_original_method = "B0DC8E18521874709C24B9B37D89D87C", hash_generated_method = "8928AD834D902FFB7812753AD3CD467D")
    public void setsockoptTimeval(FileDescriptor fd, int level, int option, StructTimeval value) throws ErrnoException {
        os.setsockoptTimeval(fd, level, option, value);
        addTaint(fd.getTaint());
        addTaint(level);
        addTaint(option);
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //os.setsockoptTimeval(fd, level, option, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.658 -0400", hash_original_method = "554251AE1D031EE7BA07BC4F696C724A", hash_generated_method = "95DD70C53FE71F4300D8A3B4C4BAF7BE")
    public void setuid(int uid) throws ErrnoException {
        os.setuid(uid);
        addTaint(uid);
        // ---------- Original Method ----------
        //os.setuid(uid);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.659 -0400", hash_original_method = "5FEB3BBC8A3C8F5F8A22DE81B35CAE4D", hash_generated_method = "87B92C4EDDB60F330ECC42FB69F744BB")
    public void shutdown(FileDescriptor fd, int how) throws ErrnoException {
        os.shutdown(fd, how);
        addTaint(fd.getTaint());
        addTaint(how);
        // ---------- Original Method ----------
        //os.shutdown(fd, how);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.659 -0400", hash_original_method = "558F533484D6B9C99DDFE653A920693C", hash_generated_method = "1AE91F6BA3A49A35D555502E89013DAC")
    public FileDescriptor socket(int domain, int type, int protocol) throws ErrnoException {
        FileDescriptor varB4EAC82CA7396A68D541C85D26508E83_2114865310 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2114865310 = os.socket(domain, type, protocol);
        addTaint(domain);
        addTaint(type);
        addTaint(protocol);
        varB4EAC82CA7396A68D541C85D26508E83_2114865310.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2114865310;
        // ---------- Original Method ----------
        //return os.socket(domain, type, protocol);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.660 -0400", hash_original_method = "E3FE6B0CE9C868055585C77F475D7F5A", hash_generated_method = "9CC3193627C924CE42FC42E85F6442A0")
    public StructStat stat(String path) throws ErrnoException {
        StructStat varB4EAC82CA7396A68D541C85D26508E83_393365350 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_393365350 = os.stat(path);
        addTaint(path.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_393365350.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_393365350;
        // ---------- Original Method ----------
        //return os.stat(path);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.660 -0400", hash_original_method = "EA8F2D89CBB0B8AF52F0D62C5DA4B5A0", hash_generated_method = "31B0F1D6AFAFF78D81EBE5BB700A2DF1")
    public StructStatFs statfs(String path) throws ErrnoException {
        StructStatFs varB4EAC82CA7396A68D541C85D26508E83_1744524857 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1744524857 = os.statfs(path);
        addTaint(path.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1744524857.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1744524857;
        // ---------- Original Method ----------
        //return os.statfs(path);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.664 -0400", hash_original_method = "FBEAE456B3A3C776553B1F7E912CD6FB", hash_generated_method = "B59577859D05772EDC6DB40E9715B715")
    public String strerror(int errno) {
        String varB4EAC82CA7396A68D541C85D26508E83_278875050 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_278875050 = os.strerror(errno);
        addTaint(errno);
        varB4EAC82CA7396A68D541C85D26508E83_278875050.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_278875050;
        // ---------- Original Method ----------
        //return os.strerror(errno);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.664 -0400", hash_original_method = "FB4E2B29DA5C665C03E887C9C86A36A3", hash_generated_method = "A481904BFAEB009329F86B88C81878BA")
    public void symlink(String oldPath, String newPath) throws ErrnoException {
        os.symlink(oldPath, newPath);
        addTaint(oldPath.getTaint());
        addTaint(newPath.getTaint());
        // ---------- Original Method ----------
        //os.symlink(oldPath, newPath);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.664 -0400", hash_original_method = "9239DE14FB7F01A1D647B884E3411551", hash_generated_method = "29520B6BCFAF7E3A50F4CA0639921B4F")
    public long sysconf(int name) {
        long var6016DF4BB18042E7D98C68C5D480E24E_104842955 = (os.sysconf(name));
        addTaint(name);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_533649380 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_533649380;
        // ---------- Original Method ----------
        //return os.sysconf(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.665 -0400", hash_original_method = "E92B0E3CCB7269FEE37854B5F086E530", hash_generated_method = "285B51843C7058CB14D4A360CEA4604E")
    public StructUtsname uname() {
        StructUtsname varB4EAC82CA7396A68D541C85D26508E83_1826217049 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1826217049 = os.uname();
        varB4EAC82CA7396A68D541C85D26508E83_1826217049.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1826217049;
        // ---------- Original Method ----------
        //return os.uname();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.665 -0400", hash_original_method = "EC4C2322F336992223E3CB1B21022BF9", hash_generated_method = "D89AA4751A618894330C205389CC957C")
    public int waitpid(int pid, MutableInt status, int options) throws ErrnoException {
        int varE8B0A97070670E6FF43AAF48DCCF725E_635706120 = (os.waitpid(pid, status, options));
        addTaint(pid);
        addTaint(status.getTaint());
        addTaint(options);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_967889303 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_967889303;
        // ---------- Original Method ----------
        //return os.waitpid(pid, status, options);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.665 -0400", hash_original_method = "844A22BF74026B79E5C643696D2A0D2B", hash_generated_method = "6205459977DFE21188686567A47C9311")
    public int write(FileDescriptor fd, ByteBuffer buffer) throws ErrnoException {
        int var0626357AF90ACF3FB1D934D119466787_2100067294 = (os.write(fd, buffer));
        addTaint(fd.getTaint());
        addTaint(buffer.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1626794303 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1626794303;
        // ---------- Original Method ----------
        //return os.write(fd, buffer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.675 -0400", hash_original_method = "437BEB04F87A5AE656D8F235B16E36DF", hash_generated_method = "42BD7062487157FE91F7186A487D2871")
    public int write(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount) throws ErrnoException {
        int varE733C997547CF269F3AB7BAEB4D044AF_1820455899 = (os.write(fd, bytes, byteOffset, byteCount));
        addTaint(fd.getTaint());
        addTaint(bytes[0]);
        addTaint(byteOffset);
        addTaint(byteCount);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1832837484 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1832837484;
        // ---------- Original Method ----------
        //return os.write(fd, bytes, byteOffset, byteCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:02.675 -0400", hash_original_method = "8BC1FDC02B601F3DB4DB2A70967C7CDC", hash_generated_method = "14A9CCF1715170CBB345B810C3FB92BC")
    public int writev(FileDescriptor fd, Object[] buffers, int[] offsets, int[] byteCounts) throws ErrnoException {
        int var32F5E7D906A9F96A2B6412DC92928AD7_1598289956 = (os.writev(fd, buffers, offsets, byteCounts));
        addTaint(fd.getTaint());
        addTaint(buffers[0].getTaint());
        addTaint(offsets[0]);
        addTaint(byteCounts[0]);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_98511839 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_98511839;
        // ---------- Original Method ----------
        //return os.writev(fd, buffers, offsets, byteCounts);
    }

    
}

