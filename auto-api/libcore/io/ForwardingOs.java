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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:03.908 -0400", hash_original_field = "DD302F94682DBD2A114D63B0433602E0", hash_generated_field = "AD741EF2B519FC3080D4269DB2BABC3A")

    protected Os os;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:03.911 -0400", hash_original_method = "EC37328A0FF4DE634029572AA03E9806", hash_generated_method = "C41B14D0DEFEB2ECE4508496A7A2B2B8")
    public  ForwardingOs(Os os) {
        this.os = os;
        // ---------- Original Method ----------
        //this.os = os;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:03.919 -0400", hash_original_method = "5CF5B545FE52A5A749C69E4804E7DB37", hash_generated_method = "2921E20DFDFB6B69472886FB1B17ACEB")
    public FileDescriptor accept(FileDescriptor fd, InetSocketAddress peerAddress) throws ErrnoException {
        FileDescriptor varB4EAC82CA7396A68D541C85D26508E83_517326837 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_517326837 = os.accept(fd, peerAddress);
        addTaint(fd.getTaint());
        addTaint(peerAddress.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_517326837.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_517326837;
        // ---------- Original Method ----------
        //return os.accept(fd, peerAddress);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:03.920 -0400", hash_original_method = "FFD94E7AFE1E3B1F76A2D696707B6857", hash_generated_method = "13F59B6762A4570335CD3A939F24D334")
    public boolean access(String path, int mode) throws ErrnoException {
        boolean var172DEC5DD37258CD490DDB56CA7E2DB8_611282236 = (os.access(path, mode));
        addTaint(path.getTaint());
        addTaint(mode);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2028879833 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2028879833;
        // ---------- Original Method ----------
        //return os.access(path, mode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:03.920 -0400", hash_original_method = "743422D2EB39F172C4245C8DC993624F", hash_generated_method = "2C4F56DB987DDA5521904DED150E2276")
    public void bind(FileDescriptor fd, InetAddress address, int port) throws ErrnoException {
        os.bind(fd, address, port);
        addTaint(fd.getTaint());
        addTaint(address.getTaint());
        addTaint(port);
        // ---------- Original Method ----------
        //os.bind(fd, address, port);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:03.921 -0400", hash_original_method = "A92F7B75A5B2B90071388C67FA677A74", hash_generated_method = "25BEC27B5A16271F093E9447FC93F8BE")
    public void chmod(String path, int mode) throws ErrnoException {
        os.chmod(path, mode);
        addTaint(path.getTaint());
        addTaint(mode);
        // ---------- Original Method ----------
        //os.chmod(path, mode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:03.921 -0400", hash_original_method = "2AF652D8862D637B4A4051CAB7CD62FB", hash_generated_method = "0691BC1EEB0DF53658B22E295E231D1F")
    public void close(FileDescriptor fd) throws ErrnoException {
        os.close(fd);
        addTaint(fd.getTaint());
        // ---------- Original Method ----------
        //os.close(fd);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:03.930 -0400", hash_original_method = "FADD460EF8DBCF58AF836CFAB2496AF1", hash_generated_method = "15ABDFE7CCF265D5E298BF7816B64D67")
    public void connect(FileDescriptor fd, InetAddress address, int port) throws ErrnoException {
        os.connect(fd, address, port);
        addTaint(fd.getTaint());
        addTaint(address.getTaint());
        addTaint(port);
        // ---------- Original Method ----------
        //os.connect(fd, address, port);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:03.931 -0400", hash_original_method = "6162F8350974235CF8AA9EBE9F68335F", hash_generated_method = "7B0C7F7F49D96C78BBC770DE74A1705F")
    public FileDescriptor dup(FileDescriptor oldFd) throws ErrnoException {
        FileDescriptor varB4EAC82CA7396A68D541C85D26508E83_1388700799 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1388700799 = os.dup(oldFd);
        addTaint(oldFd.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1388700799.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1388700799;
        // ---------- Original Method ----------
        //return os.dup(oldFd);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:03.932 -0400", hash_original_method = "E190E2A3CFD75C84461AB90FFE03369B", hash_generated_method = "FBF09EEF25D58EC3378939EC85C60D41")
    public FileDescriptor dup2(FileDescriptor oldFd, int newFd) throws ErrnoException {
        FileDescriptor varB4EAC82CA7396A68D541C85D26508E83_739229525 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_739229525 = os.dup2(oldFd, newFd);
        addTaint(oldFd.getTaint());
        addTaint(newFd);
        varB4EAC82CA7396A68D541C85D26508E83_739229525.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_739229525;
        // ---------- Original Method ----------
        //return os.dup2(oldFd, newFd);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:03.932 -0400", hash_original_method = "5CF51EBD75B5D23C7F632D7D494380D1", hash_generated_method = "AA221AF2DE31BE450C408019122BC216")
    public String[] environ() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_1906154976 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1906154976 = os.environ();
        varB4EAC82CA7396A68D541C85D26508E83_1906154976.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1906154976;
        // ---------- Original Method ----------
        //return os.environ();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:03.933 -0400", hash_original_method = "CA43F47313D11741B7EE5D06954736CB", hash_generated_method = "704DC1FA7F000A938F8CEA0968BFB583")
    public int fcntlVoid(FileDescriptor fd, int cmd) throws ErrnoException {
        int varBF1653E2CBDC0EBDA030B66FA450FCF0_193258732 = (os.fcntlVoid(fd, cmd));
        addTaint(fd.getTaint());
        addTaint(cmd);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1452321292 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1452321292;
        // ---------- Original Method ----------
        //return os.fcntlVoid(fd, cmd);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:03.933 -0400", hash_original_method = "6B248418A1B43AC8597DD680343F17BD", hash_generated_method = "1B120726328A740873B176FB693786DB")
    public int fcntlLong(FileDescriptor fd, int cmd, long arg) throws ErrnoException {
        int var97EF80FEE8D7DCAFEADBFC1210BDC18B_1175664576 = (os.fcntlLong(fd, cmd, arg));
        addTaint(fd.getTaint());
        addTaint(cmd);
        addTaint(arg);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_872282717 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_872282717;
        // ---------- Original Method ----------
        //return os.fcntlLong(fd, cmd, arg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:03.937 -0400", hash_original_method = "28B6741D270DBCC0BDA43B4FBA76C484", hash_generated_method = "2EE32DA04CB5D713758869AC9EDEA011")
    public int fcntlFlock(FileDescriptor fd, int cmd, StructFlock arg) throws ErrnoException {
        int var2729B8DD99A4FEEBABCEFB3EF912E159_1340267439 = (os.fcntlFlock(fd, cmd, arg));
        addTaint(fd.getTaint());
        addTaint(cmd);
        addTaint(arg.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_766332078 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_766332078;
        // ---------- Original Method ----------
        //return os.fcntlFlock(fd, cmd, arg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:03.938 -0400", hash_original_method = "D2B4800A8551761D0A11CAE1762DA39E", hash_generated_method = "573D02F895F974160BDFA32E6A78A43A")
    public void fdatasync(FileDescriptor fd) throws ErrnoException {
        os.fdatasync(fd);
        addTaint(fd.getTaint());
        // ---------- Original Method ----------
        //os.fdatasync(fd);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:03.938 -0400", hash_original_method = "0159E8BC0EB89F7B9A8B0DA54E55E46B", hash_generated_method = "82769BA785AD6B0CE772413544053822")
    public StructStat fstat(FileDescriptor fd) throws ErrnoException {
        StructStat varB4EAC82CA7396A68D541C85D26508E83_1968979667 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1968979667 = os.fstat(fd);
        addTaint(fd.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1968979667.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1968979667;
        // ---------- Original Method ----------
        //return os.fstat(fd);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:03.954 -0400", hash_original_method = "1D4670A49E88E5904763EEFCF378AA9C", hash_generated_method = "24539FF98973CBB649A7A84E82BB83BA")
    public StructStatFs fstatfs(FileDescriptor fd) throws ErrnoException {
        StructStatFs varB4EAC82CA7396A68D541C85D26508E83_1534185679 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1534185679 = os.fstatfs(fd);
        addTaint(fd.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1534185679.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1534185679;
        // ---------- Original Method ----------
        //return os.fstatfs(fd);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:03.955 -0400", hash_original_method = "5A3103E0191F55AC2413EF7A293382EA", hash_generated_method = "862ACD95EBCD31133FC7E286CD6E9E80")
    public void fsync(FileDescriptor fd) throws ErrnoException {
        os.fsync(fd);
        addTaint(fd.getTaint());
        // ---------- Original Method ----------
        //os.fsync(fd);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:03.955 -0400", hash_original_method = "B89F13DA07AD88D9E35FDD0F8C706602", hash_generated_method = "551BB12398467F3C8EB23F5C296B7D11")
    public void ftruncate(FileDescriptor fd, long length) throws ErrnoException {
        os.ftruncate(fd, length);
        addTaint(fd.getTaint());
        addTaint(length);
        // ---------- Original Method ----------
        //os.ftruncate(fd, length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:03.955 -0400", hash_original_method = "4EDF3DB0839BDB5BB59D5BDCF6ED266B", hash_generated_method = "FC4E2BDD3C6355EA7D6BFB67B083D5DA")
    public String gai_strerror(int error) {
        String varB4EAC82CA7396A68D541C85D26508E83_1836693905 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1836693905 = os.gai_strerror(error);
        addTaint(error);
        varB4EAC82CA7396A68D541C85D26508E83_1836693905.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1836693905;
        // ---------- Original Method ----------
        //return os.gai_strerror(error);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:03.956 -0400", hash_original_method = "D134969B79309E2FFE6734562680F40F", hash_generated_method = "DC118B51C83FE619CC2D108BADC1F34C")
    public InetAddress[] getaddrinfo(String node, StructAddrinfo hints) throws GaiException {
        InetAddress[] varB4EAC82CA7396A68D541C85D26508E83_294595453 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_294595453 = os.getaddrinfo(node, hints);
        addTaint(node.getTaint());
        addTaint(hints.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_294595453.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_294595453;
        // ---------- Original Method ----------
        //return os.getaddrinfo(node, hints);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:03.956 -0400", hash_original_method = "DA32E4A67BBB878517DC4C1F6AD2DE47", hash_generated_method = "6D900211502BA1F3F5A186E4948659A0")
    public int getegid() {
        int varD8065AE9128D4E02D412A3250EE4BEA6_1014339768 = (os.getegid());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1329602029 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1329602029;
        // ---------- Original Method ----------
        //return os.getegid();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:03.957 -0400", hash_original_method = "FAD72A6DE2CC7E2DB1B9B6FC41642D5B", hash_generated_method = "7D2E1588EE198A98A21682009A29F9B4")
    public int geteuid() {
        int var56D743784E549DA0B7EA1F9C189A6471_14720086 = (os.geteuid());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_519235135 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_519235135;
        // ---------- Original Method ----------
        //return os.geteuid();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:03.957 -0400", hash_original_method = "FADA5B6063E47C208AC2D0843F6EB847", hash_generated_method = "9EBB13F265B7F8936ABFEDC109B9FF68")
    public int getgid() {
        int var6CADC2A35DC4D6A9A5A15CAB17B4B6E3_893537994 = (os.getgid());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1542445340 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1542445340;
        // ---------- Original Method ----------
        //return os.getgid();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:03.960 -0400", hash_original_method = "E4B66B682B354EFDCC2A2307B9973162", hash_generated_method = "FDA175C6F0C135F8012662473820A9B5")
    public String getenv(String name) {
        String varB4EAC82CA7396A68D541C85D26508E83_1960968217 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1960968217 = os.getenv(name);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1960968217.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1960968217;
        // ---------- Original Method ----------
        //return os.getenv(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:03.961 -0400", hash_original_method = "95C6CCF446FE941364E9F3FC808640B5", hash_generated_method = "99068EC2FDE9CB345F07FB898A17ABB7")
    public String getnameinfo(InetAddress address, int flags) throws GaiException {
        String varB4EAC82CA7396A68D541C85D26508E83_337114501 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_337114501 = os.getnameinfo(address, flags);
        addTaint(address.getTaint());
        addTaint(flags);
        varB4EAC82CA7396A68D541C85D26508E83_337114501.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_337114501;
        // ---------- Original Method ----------
        //return os.getnameinfo(address, flags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:03.972 -0400", hash_original_method = "A3B371C9A268817901795576D0A04CF6", hash_generated_method = "32897E118EC27918EE388909AE338DD2")
    public int getpid() {
        int var38AA61BF3E54239C4504A81A8746FA43_1682885798 = (os.getpid());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1656115452 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1656115452;
        // ---------- Original Method ----------
        //return os.getpid();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:03.973 -0400", hash_original_method = "878D1FDE3DC9E3A460294EB2A78F5342", hash_generated_method = "622A1E12BC2FAE0AE29C5CB127FE0995")
    public int getppid() {
        int var1F662189AEACAB508948D811AFEC491B_1435887804 = (os.getppid());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_394687828 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_394687828;
        // ---------- Original Method ----------
        //return os.getppid();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:03.974 -0400", hash_original_method = "A3C50DDCB01897A6F2E46FE623EA65A2", hash_generated_method = "70316741A3354CE1581DD8D77631F765")
    public StructPasswd getpwnam(String name) throws ErrnoException {
        StructPasswd varB4EAC82CA7396A68D541C85D26508E83_1874497420 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1874497420 = os.getpwnam(name);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1874497420.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1874497420;
        // ---------- Original Method ----------
        //return os.getpwnam(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:03.974 -0400", hash_original_method = "F069BDB68A1BE69C49E58A44BE7A4944", hash_generated_method = "2D69314A1CEBEBA59506B4EE49AB65DA")
    public StructPasswd getpwuid(int uid) throws ErrnoException {
        StructPasswd varB4EAC82CA7396A68D541C85D26508E83_2107015625 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2107015625 = os.getpwuid(uid);
        addTaint(uid);
        varB4EAC82CA7396A68D541C85D26508E83_2107015625.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2107015625;
        // ---------- Original Method ----------
        //return os.getpwuid(uid);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:03.975 -0400", hash_original_method = "C71AB83C8CB24831B3B392DF1EFA2A55", hash_generated_method = "674F1E0FC1B0317ECA615472FBAFB3E0")
    public SocketAddress getsockname(FileDescriptor fd) throws ErrnoException {
        SocketAddress varB4EAC82CA7396A68D541C85D26508E83_95702334 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_95702334 = os.getsockname(fd);
        addTaint(fd.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_95702334.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_95702334;
        // ---------- Original Method ----------
        //return os.getsockname(fd);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:03.975 -0400", hash_original_method = "E5D66E4A2B17F99E78F6B2E97C4D0018", hash_generated_method = "B6B1285565D4D76144F6EC7C78F00727")
    public int getsockoptByte(FileDescriptor fd, int level, int option) throws ErrnoException {
        int var46B88F2A6E8AFD10C1C2A4CB4FA13847_596721 = (os.getsockoptByte(fd, level, option));
        addTaint(fd.getTaint());
        addTaint(level);
        addTaint(option);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_33698261 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_33698261;
        // ---------- Original Method ----------
        //return os.getsockoptByte(fd, level, option);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:03.981 -0400", hash_original_method = "0CBF6F7E2BE2FF171C45C7BCFC831012", hash_generated_method = "357FED5718746B946127602D60C559A2")
    public InetAddress getsockoptInAddr(FileDescriptor fd, int level, int option) throws ErrnoException {
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_336836945 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_336836945 = os.getsockoptInAddr(fd, level, option);
        addTaint(fd.getTaint());
        addTaint(level);
        addTaint(option);
        varB4EAC82CA7396A68D541C85D26508E83_336836945.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_336836945;
        // ---------- Original Method ----------
        //return os.getsockoptInAddr(fd, level, option);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:03.985 -0400", hash_original_method = "946A87B9C2E87F4C961C36C4569A31BA", hash_generated_method = "B1C2E6631DA206B599CA78181CDE8A63")
    public int getsockoptInt(FileDescriptor fd, int level, int option) throws ErrnoException {
        int varE08D816983313FAA61DC4FC565C65ADD_2106321511 = (os.getsockoptInt(fd, level, option));
        addTaint(fd.getTaint());
        addTaint(level);
        addTaint(option);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1881775819 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1881775819;
        // ---------- Original Method ----------
        //return os.getsockoptInt(fd, level, option);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:03.992 -0400", hash_original_method = "EBD2988D937DD58B5AD9697AEE85A0FB", hash_generated_method = "2C8A2443A9A1EDDCAFC7AFE108D671F3")
    public StructLinger getsockoptLinger(FileDescriptor fd, int level, int option) throws ErrnoException {
        StructLinger varB4EAC82CA7396A68D541C85D26508E83_1957579042 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1957579042 = os.getsockoptLinger(fd, level, option);
        addTaint(fd.getTaint());
        addTaint(level);
        addTaint(option);
        varB4EAC82CA7396A68D541C85D26508E83_1957579042.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1957579042;
        // ---------- Original Method ----------
        //return os.getsockoptLinger(fd, level, option);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:03.993 -0400", hash_original_method = "1C478D9E653EA1E4A0CA2442FA9E2156", hash_generated_method = "0013573487AD404F6EF5CC0472A2F1D3")
    public StructTimeval getsockoptTimeval(FileDescriptor fd, int level, int option) throws ErrnoException {
        StructTimeval varB4EAC82CA7396A68D541C85D26508E83_1556706053 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1556706053 = os.getsockoptTimeval(fd, level, option);
        addTaint(fd.getTaint());
        addTaint(level);
        addTaint(option);
        varB4EAC82CA7396A68D541C85D26508E83_1556706053.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1556706053;
        // ---------- Original Method ----------
        //return os.getsockoptTimeval(fd, level, option);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:03.993 -0400", hash_original_method = "2F11239B76600858937301E80656F86F", hash_generated_method = "2B00DFF0E10B5CF5AE93753DCC1FB66C")
    public int getuid() {
        int var6E1C401E18C533CAAAF3A5BDCCAC0B20_624391947 = (os.getuid());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1726516479 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1726516479;
        // ---------- Original Method ----------
        //return os.getuid();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:03.993 -0400", hash_original_method = "FD1CFE447DC743FEF7DD120355028D01", hash_generated_method = "F77D2232F0D58CA7693463E5A6CBF3DE")
    public String if_indextoname(int index) {
        String varB4EAC82CA7396A68D541C85D26508E83_2073002349 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2073002349 = os.if_indextoname(index);
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_2073002349.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2073002349;
        // ---------- Original Method ----------
        //return os.if_indextoname(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:03.994 -0400", hash_original_method = "244F6B5FD78AC80358A10468727F943C", hash_generated_method = "907A3E99D5AD07458C2D1EC554F8829E")
    public InetAddress inet_pton(int family, String address) {
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_2106823573 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2106823573 = os.inet_pton(family, address);
        addTaint(family);
        addTaint(address.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2106823573.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2106823573;
        // ---------- Original Method ----------
        //return os.inet_pton(family, address);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.002 -0400", hash_original_method = "81C548F366545C14DF26B9A5D253BEA5", hash_generated_method = "7BCA24C2DDBD119F31D7D40EE98B2428")
    public InetAddress ioctlInetAddress(FileDescriptor fd, int cmd, String interfaceName) throws ErrnoException {
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_450397439 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_450397439 = os.ioctlInetAddress(fd, cmd, interfaceName);
        addTaint(fd.getTaint());
        addTaint(cmd);
        addTaint(interfaceName.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_450397439.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_450397439;
        // ---------- Original Method ----------
        //return os.ioctlInetAddress(fd, cmd, interfaceName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.002 -0400", hash_original_method = "B9A716BFE88006BFE54885EB5B40EF6E", hash_generated_method = "047CE560B8AA79B9B8094870BBCAFA42")
    public int ioctlInt(FileDescriptor fd, int cmd, MutableInt arg) throws ErrnoException {
        int varD9D1F852ABD2929B5B4A1DF95D32EC90_1805934320 = (os.ioctlInt(fd, cmd, arg));
        addTaint(fd.getTaint());
        addTaint(cmd);
        addTaint(arg.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_399048949 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_399048949;
        // ---------- Original Method ----------
        //return os.ioctlInt(fd, cmd, arg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.014 -0400", hash_original_method = "E622E0FA602C62724E493B1B03996EEA", hash_generated_method = "28105FF31088A7F6B2B9EB57729CD5C6")
    public boolean isatty(FileDescriptor fd) {
        boolean var1BDE8D20FF5CAACE3E2EB14F5484BA59_317913972 = (os.isatty(fd));
        addTaint(fd.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1961595473 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1961595473;
        // ---------- Original Method ----------
        //return os.isatty(fd);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.015 -0400", hash_original_method = "39C5C221EF1E81F6FE3B9410463D5E57", hash_generated_method = "2A652D0CC61257924637F3B4524AB2ED")
    public void kill(int pid, int signal) throws ErrnoException {
        os.kill(pid, signal);
        addTaint(pid);
        addTaint(signal);
        // ---------- Original Method ----------
        //os.kill(pid, signal);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.015 -0400", hash_original_method = "039EEA76B9DC6E04921BFC5BC270EDD9", hash_generated_method = "EF536F2D00F74E235D928577CD3328A5")
    public void listen(FileDescriptor fd, int backlog) throws ErrnoException {
        os.listen(fd, backlog);
        addTaint(fd.getTaint());
        addTaint(backlog);
        // ---------- Original Method ----------
        //os.listen(fd, backlog);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.015 -0400", hash_original_method = "3005A45BFDFB73561B6BABAEF57B12E1", hash_generated_method = "E50AA7A4E4800C7356D5B13C6F3884C3")
    public long lseek(FileDescriptor fd, long offset, int whence) throws ErrnoException {
        long var00BC20AD4BC3DA29C7F7761FC82BB0E6_1242497225 = (os.lseek(fd, offset, whence));
        addTaint(fd.getTaint());
        addTaint(offset);
        addTaint(whence);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_105345944 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_105345944;
        // ---------- Original Method ----------
        //return os.lseek(fd, offset, whence);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.016 -0400", hash_original_method = "F288030A10BA391FE6D7AD19552493B8", hash_generated_method = "FD0FF89D667A084348E7562102F01E39")
    public StructStat lstat(String path) throws ErrnoException {
        StructStat varB4EAC82CA7396A68D541C85D26508E83_903719980 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_903719980 = os.lstat(path);
        addTaint(path.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_903719980.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_903719980;
        // ---------- Original Method ----------
        //return os.lstat(path);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.017 -0400", hash_original_method = "0D8D349CD4EFD867777AD4E59116610D", hash_generated_method = "0A1847CF7EEC8E9DC66F9219B36FE04B")
    public void mincore(long address, long byteCount, byte[] vector) throws ErrnoException {
        os.mincore(address, byteCount, vector);
        addTaint(address);
        addTaint(byteCount);
        addTaint(vector[0]);
        // ---------- Original Method ----------
        //os.mincore(address, byteCount, vector);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.017 -0400", hash_original_method = "689C229BD7F4B7F5308857A16DB04D8E", hash_generated_method = "B3FDA2E6552179AB66F6BBBC382EBDAE")
    public void mkdir(String path, int mode) throws ErrnoException {
        os.mkdir(path, mode);
        addTaint(path.getTaint());
        addTaint(mode);
        // ---------- Original Method ----------
        //os.mkdir(path, mode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.017 -0400", hash_original_method = "419517122697B0628E53EB3E2B0A6370", hash_generated_method = "13BD8890090968567A2F57958022BFE6")
    public void mlock(long address, long byteCount) throws ErrnoException {
        os.mlock(address, byteCount);
        addTaint(address);
        addTaint(byteCount);
        // ---------- Original Method ----------
        //os.mlock(address, byteCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.021 -0400", hash_original_method = "4029BCDA0489C716FD1384F50323A029", hash_generated_method = "BC3E3B9280AC3C6E9C137C16817A881C")
    public long mmap(long address, long byteCount, int prot, int flags, FileDescriptor fd, long offset) throws ErrnoException {
        long var3045E876657A6DFFC0A2A0AFB33818CC_1559525004 = (os.mmap(address, byteCount, prot, flags, fd, offset));
        addTaint(address);
        addTaint(byteCount);
        addTaint(prot);
        addTaint(flags);
        addTaint(fd.getTaint());
        addTaint(offset);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_556592658 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_556592658;
        // ---------- Original Method ----------
        //return os.mmap(address, byteCount, prot, flags, fd, offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.025 -0400", hash_original_method = "26058ECBCE0A88D4B8D4418B78F705C5", hash_generated_method = "B3FF0C6B6F74DBE6935D16BA8C27125B")
    public void msync(long address, long byteCount, int flags) throws ErrnoException {
        os.msync(address, byteCount, flags);
        addTaint(address);
        addTaint(byteCount);
        addTaint(flags);
        // ---------- Original Method ----------
        //os.msync(address, byteCount, flags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.026 -0400", hash_original_method = "12F3B374B5C7D041381B26987EDF7BE8", hash_generated_method = "F14D84EEE2DC5E8DEA4BB6D495547D30")
    public void munlock(long address, long byteCount) throws ErrnoException {
        os.munlock(address, byteCount);
        addTaint(address);
        addTaint(byteCount);
        // ---------- Original Method ----------
        //os.munlock(address, byteCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.030 -0400", hash_original_method = "93EF25630433342C6922044F58653EDA", hash_generated_method = "356606A69AA5950B9FE2BB3C0E2BB836")
    public void munmap(long address, long byteCount) throws ErrnoException {
        os.munmap(address, byteCount);
        addTaint(address);
        addTaint(byteCount);
        // ---------- Original Method ----------
        //os.munmap(address, byteCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.031 -0400", hash_original_method = "3A1C8AE14DFE6F094F17065084A852DA", hash_generated_method = "172A25053C4950396C89187EAD9259FC")
    public FileDescriptor open(String path, int flags, int mode) throws ErrnoException {
        FileDescriptor varB4EAC82CA7396A68D541C85D26508E83_1950390387 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1950390387 = os.open(path, flags, mode);
        addTaint(path.getTaint());
        addTaint(flags);
        addTaint(mode);
        varB4EAC82CA7396A68D541C85D26508E83_1950390387.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1950390387;
        // ---------- Original Method ----------
        //return os.open(path, flags, mode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.046 -0400", hash_original_method = "C44D806183F8681F84B21225E3DD2820", hash_generated_method = "D4ADB83E36E1EB15CBAE2F75FF21C11E")
    public FileDescriptor[] pipe() throws ErrnoException {
        FileDescriptor[] varB4EAC82CA7396A68D541C85D26508E83_2115298431 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2115298431 = os.pipe();
        varB4EAC82CA7396A68D541C85D26508E83_2115298431.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2115298431;
        // ---------- Original Method ----------
        //return os.pipe();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.047 -0400", hash_original_method = "5599B9E106312A6343AFDB459C1296E6", hash_generated_method = "90B4916E99079635444A14E84A4656F7")
    public int poll(StructPollfd[] fds, int timeoutMs) throws ErrnoException {
        int var48722583F516647909DDA26F0FCD9942_517729605 = (os.poll(fds, timeoutMs));
        addTaint(fds[0].getTaint());
        addTaint(timeoutMs);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1570263054 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1570263054;
        // ---------- Original Method ----------
        //return os.poll(fds, timeoutMs);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.047 -0400", hash_original_method = "E02E4577E71F70F2C9CAE7AED1E2F8AC", hash_generated_method = "F846C5DA5EB62AEDA0FA93083BCA521E")
    public int pread(FileDescriptor fd, ByteBuffer buffer, long offset) throws ErrnoException {
        int var8E37D63F084AD12D6EF74F78D0F34813_1756279825 = (os.pread(fd, buffer, offset));
        addTaint(fd.getTaint());
        addTaint(buffer.getTaint());
        addTaint(offset);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_145746730 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_145746730;
        // ---------- Original Method ----------
        //return os.pread(fd, buffer, offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.048 -0400", hash_original_method = "77B89AD0CF3C5D71E7DD42E992F283EF", hash_generated_method = "1AC1E12708D2C84CDC0A4C9A2C4EFB59")
    public int pread(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount, long offset) throws ErrnoException {
        int var9596F97D25F40A8949B0F9D6651550A1_855501953 = (os.pread(fd, bytes, byteOffset, byteCount, offset));
        addTaint(fd.getTaint());
        addTaint(bytes[0]);
        addTaint(byteOffset);
        addTaint(byteCount);
        addTaint(offset);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1259306203 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1259306203;
        // ---------- Original Method ----------
        //return os.pread(fd, bytes, byteOffset, byteCount, offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.048 -0400", hash_original_method = "1CD5001FEE779ACE9E3DB9100CD609FC", hash_generated_method = "AF8C085BCC8D7AAC1698E28C372EDEF1")
    public int pwrite(FileDescriptor fd, ByteBuffer buffer, long offset) throws ErrnoException {
        int varBEC757109BB880DDBADF6015F3B05B2C_600597059 = (os.pwrite(fd, buffer, offset));
        addTaint(fd.getTaint());
        addTaint(buffer.getTaint());
        addTaint(offset);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1368601392 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1368601392;
        // ---------- Original Method ----------
        //return os.pwrite(fd, buffer, offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.048 -0400", hash_original_method = "F0611566A9565E2DEF97709E6B9B6418", hash_generated_method = "6AC9CD9C3146D2159E1FAD6BCDE7386C")
    public int pwrite(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount, long offset) throws ErrnoException {
        int var41A08F5DA487149A1F7C1270B58B9089_833817754 = (os.pwrite(fd, bytes, byteOffset, byteCount, offset));
        addTaint(fd.getTaint());
        addTaint(bytes[0]);
        addTaint(byteOffset);
        addTaint(byteCount);
        addTaint(offset);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1774853701 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1774853701;
        // ---------- Original Method ----------
        //return os.pwrite(fd, bytes, byteOffset, byteCount, offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.052 -0400", hash_original_method = "F3C222630BE6E1046A8D40208CD4C60B", hash_generated_method = "25325467BCDD86CCD33DEFC81B86DE21")
    public int read(FileDescriptor fd, ByteBuffer buffer) throws ErrnoException {
        int var5B8E7DC5191E81FE70C36AA027AFFCC8_1662115811 = (os.read(fd, buffer));
        addTaint(fd.getTaint());
        addTaint(buffer.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_431360825 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_431360825;
        // ---------- Original Method ----------
        //return os.read(fd, buffer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.053 -0400", hash_original_method = "21F8B1ED0ECF46FDBCE6EA979BADF2C3", hash_generated_method = "5922B2CE8A53FAD24CBE3F25B2EDAF6A")
    public int read(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount) throws ErrnoException {
        int varE59F1DA0F28FCDF7A959280195F03910_1459017674 = (os.read(fd, bytes, byteOffset, byteCount));
        addTaint(fd.getTaint());
        addTaint(bytes[0]);
        addTaint(byteOffset);
        addTaint(byteCount);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1340183402 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1340183402;
        // ---------- Original Method ----------
        //return os.read(fd, bytes, byteOffset, byteCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.067 -0400", hash_original_method = "E2800F54CC6608A5FBBD1BF36223D806", hash_generated_method = "5425B13B4D9BCC2BCB08CFAE0601707B")
    public int readv(FileDescriptor fd, Object[] buffers, int[] offsets, int[] byteCounts) throws ErrnoException {
        int var2494A58C76DD4D861DBB94DFA16C08A6_568159905 = (os.readv(fd, buffers, offsets, byteCounts));
        addTaint(fd.getTaint());
        addTaint(buffers[0].getTaint());
        addTaint(offsets[0]);
        addTaint(byteCounts[0]);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_468487974 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_468487974;
        // ---------- Original Method ----------
        //return os.readv(fd, buffers, offsets, byteCounts);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.068 -0400", hash_original_method = "84F37C132BD33033E9DE4E38A8430067", hash_generated_method = "D1D3E856109FFB004D8389851A0F821E")
    public int recvfrom(FileDescriptor fd, ByteBuffer buffer, int flags, InetSocketAddress srcAddress) throws ErrnoException {
        int varF25721B896E31A53482415C6A924C22D_1958946710 = (os.recvfrom(fd, buffer, flags, srcAddress));
        addTaint(fd.getTaint());
        addTaint(buffer.getTaint());
        addTaint(flags);
        addTaint(srcAddress.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1961324705 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1961324705;
        // ---------- Original Method ----------
        //return os.recvfrom(fd, buffer, flags, srcAddress);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.068 -0400", hash_original_method = "0394D475125B49320B23E75594B5C434", hash_generated_method = "58D90DA52AE4A22E5EE25FA0EA418BC8")
    public int recvfrom(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount, int flags, InetSocketAddress srcAddress) throws ErrnoException {
        int var3A59E5EE9728502FA7AEFF9DA4D0C096_160759634 = (os.recvfrom(fd, bytes, byteOffset, byteCount, flags, srcAddress));
        addTaint(fd.getTaint());
        addTaint(bytes[0]);
        addTaint(byteOffset);
        addTaint(byteCount);
        addTaint(flags);
        addTaint(srcAddress.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_35918170 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_35918170;
        // ---------- Original Method ----------
        //return os.recvfrom(fd, bytes, byteOffset, byteCount, flags, srcAddress);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.068 -0400", hash_original_method = "B12B5B450AD1F25F30BAE5F7F0558752", hash_generated_method = "B967C63C94D7FFC1BF04F3CB4178010B")
    public void remove(String path) throws ErrnoException {
        os.remove(path);
        addTaint(path.getTaint());
        // ---------- Original Method ----------
        //os.remove(path);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.068 -0400", hash_original_method = "91C997D77FC3A21A4E5692674F9BE11B", hash_generated_method = "9178B74C9305F48F4B3F361B7C836E95")
    public void rename(String oldPath, String newPath) throws ErrnoException {
        os.rename(oldPath, newPath);
        addTaint(oldPath.getTaint());
        addTaint(newPath.getTaint());
        // ---------- Original Method ----------
        //os.rename(oldPath, newPath);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.069 -0400", hash_original_method = "C572D6E07635A5094C687364A5671672", hash_generated_method = "29239583BCBE8E3A0F31D1DE3A023CB9")
    public long sendfile(FileDescriptor outFd, FileDescriptor inFd, MutableLong inOffset, long byteCount) throws ErrnoException {
        long varA7A8691BB87D642123D80A6B9B64BEE0_281179523 = (os.sendfile(outFd, inFd, inOffset, byteCount));
        addTaint(outFd.getTaint());
        addTaint(inFd.getTaint());
        addTaint(inOffset.getTaint());
        addTaint(byteCount);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1454179280 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1454179280;
        // ---------- Original Method ----------
        //return os.sendfile(outFd, inFd, inOffset, byteCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.069 -0400", hash_original_method = "88066FF66E9BA638CFCEFABD2B423922", hash_generated_method = "DB54305C4B0D075F57D117390D48EFFC")
    public int sendto(FileDescriptor fd, ByteBuffer buffer, int flags, InetAddress inetAddress, int port) throws ErrnoException {
        int var0B8E7266620C88EB24F8453B4CECD027_990776091 = (os.sendto(fd, buffer, flags, inetAddress, port));
        addTaint(fd.getTaint());
        addTaint(buffer.getTaint());
        addTaint(flags);
        addTaint(inetAddress.getTaint());
        addTaint(port);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1655863060 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1655863060;
        // ---------- Original Method ----------
        //return os.sendto(fd, buffer, flags, inetAddress, port);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.069 -0400", hash_original_method = "BC2321A87F2222D5681A88900983F12D", hash_generated_method = "6850D59220330613ED8DF3CB86F7605F")
    public int sendto(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount, int flags, InetAddress inetAddress, int port) throws ErrnoException {
        int var8221F6255948EB137094ED72A9C8456A_474580133 = (os.sendto(fd, bytes, byteOffset, byteCount, flags, inetAddress, port));
        addTaint(fd.getTaint());
        addTaint(bytes[0]);
        addTaint(byteOffset);
        addTaint(byteCount);
        addTaint(flags);
        addTaint(inetAddress.getTaint());
        addTaint(port);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_645564964 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_645564964;
        // ---------- Original Method ----------
        //return os.sendto(fd, bytes, byteOffset, byteCount, flags, inetAddress, port);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.077 -0400", hash_original_method = "D0978EE2EC25CFB475F603941EE6E321", hash_generated_method = "93A356037B7F8F8A962EFD27155AD531")
    public void setegid(int egid) throws ErrnoException {
        os.setegid(egid);
        addTaint(egid);
        // ---------- Original Method ----------
        //os.setegid(egid);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.077 -0400", hash_original_method = "0B3E20A1D3AFC99676F4A67D4967A4C5", hash_generated_method = "699125BC0719E8B2E50628845CF93B03")
    public void seteuid(int euid) throws ErrnoException {
        os.seteuid(euid);
        addTaint(euid);
        // ---------- Original Method ----------
        //os.seteuid(euid);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.077 -0400", hash_original_method = "5A836F22DA1ADF6236109717B09FFB11", hash_generated_method = "A512CE4B0BD677A24C1BF3C917EFDD1E")
    public void setgid(int gid) throws ErrnoException {
        os.setgid(gid);
        addTaint(gid);
        // ---------- Original Method ----------
        //os.setgid(gid);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.077 -0400", hash_original_method = "02713B5D8B1D9FC1829D645D7EE01360", hash_generated_method = "5ECCD84913650232A3A4D5918E275F5D")
    public void setsockoptByte(FileDescriptor fd, int level, int option, int value) throws ErrnoException {
        os.setsockoptByte(fd, level, option, value);
        addTaint(fd.getTaint());
        addTaint(level);
        addTaint(option);
        addTaint(value);
        // ---------- Original Method ----------
        //os.setsockoptByte(fd, level, option, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.078 -0400", hash_original_method = "859AD73B12F1FCBFB785F9C03E57780C", hash_generated_method = "B75504C71233A1B25169781E78FBEA32")
    public void setsockoptIfreq(FileDescriptor fd, int level, int option, String value) throws ErrnoException {
        os.setsockoptIfreq(fd, level, option, value);
        addTaint(fd.getTaint());
        addTaint(level);
        addTaint(option);
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //os.setsockoptIfreq(fd, level, option, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.078 -0400", hash_original_method = "5882A7C612198E8B1D9CBF2EDBCD6FE7", hash_generated_method = "95BD4E07E874A3C53418A957A1DAFACC")
    public void setsockoptInt(FileDescriptor fd, int level, int option, int value) throws ErrnoException {
        os.setsockoptInt(fd, level, option, value);
        addTaint(fd.getTaint());
        addTaint(level);
        addTaint(option);
        addTaint(value);
        // ---------- Original Method ----------
        //os.setsockoptInt(fd, level, option, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.082 -0400", hash_original_method = "3A8741E8D07270D7E757C05217AEFD39", hash_generated_method = "966031E85B0BB54980D857F07D367B73")
    public void setsockoptIpMreqn(FileDescriptor fd, int level, int option, int value) throws ErrnoException {
        os.setsockoptIpMreqn(fd, level, option, value);
        addTaint(fd.getTaint());
        addTaint(level);
        addTaint(option);
        addTaint(value);
        // ---------- Original Method ----------
        //os.setsockoptIpMreqn(fd, level, option, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.089 -0400", hash_original_method = "4E1D080A99B5B2F06B7A0201A27B3E99", hash_generated_method = "677217554288830723E73088DCBC1BCB")
    public void setsockoptGroupReq(FileDescriptor fd, int level, int option, StructGroupReq value) throws ErrnoException {
        os.setsockoptGroupReq(fd, level, option, value);
        addTaint(fd.getTaint());
        addTaint(level);
        addTaint(option);
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //os.setsockoptGroupReq(fd, level, option, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.089 -0400", hash_original_method = "A1EC25C1EA10D3E94DA65D129945BE62", hash_generated_method = "221A8CF27FEFEF11FD706E6FDC2DC322")
    public void setsockoptLinger(FileDescriptor fd, int level, int option, StructLinger value) throws ErrnoException {
        os.setsockoptLinger(fd, level, option, value);
        addTaint(fd.getTaint());
        addTaint(level);
        addTaint(option);
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //os.setsockoptLinger(fd, level, option, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.089 -0400", hash_original_method = "B0DC8E18521874709C24B9B37D89D87C", hash_generated_method = "8928AD834D902FFB7812753AD3CD467D")
    public void setsockoptTimeval(FileDescriptor fd, int level, int option, StructTimeval value) throws ErrnoException {
        os.setsockoptTimeval(fd, level, option, value);
        addTaint(fd.getTaint());
        addTaint(level);
        addTaint(option);
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //os.setsockoptTimeval(fd, level, option, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.089 -0400", hash_original_method = "554251AE1D031EE7BA07BC4F696C724A", hash_generated_method = "95DD70C53FE71F4300D8A3B4C4BAF7BE")
    public void setuid(int uid) throws ErrnoException {
        os.setuid(uid);
        addTaint(uid);
        // ---------- Original Method ----------
        //os.setuid(uid);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.090 -0400", hash_original_method = "5FEB3BBC8A3C8F5F8A22DE81B35CAE4D", hash_generated_method = "87B92C4EDDB60F330ECC42FB69F744BB")
    public void shutdown(FileDescriptor fd, int how) throws ErrnoException {
        os.shutdown(fd, how);
        addTaint(fd.getTaint());
        addTaint(how);
        // ---------- Original Method ----------
        //os.shutdown(fd, how);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.090 -0400", hash_original_method = "558F533484D6B9C99DDFE653A920693C", hash_generated_method = "CF702FC2C533247DC0EF034BD2CABD71")
    public FileDescriptor socket(int domain, int type, int protocol) throws ErrnoException {
        FileDescriptor varB4EAC82CA7396A68D541C85D26508E83_1939080392 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1939080392 = os.socket(domain, type, protocol);
        addTaint(domain);
        addTaint(type);
        addTaint(protocol);
        varB4EAC82CA7396A68D541C85D26508E83_1939080392.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1939080392;
        // ---------- Original Method ----------
        //return os.socket(domain, type, protocol);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.093 -0400", hash_original_method = "E3FE6B0CE9C868055585C77F475D7F5A", hash_generated_method = "156E203C5DF58DC7DF056C7D4E4BE76B")
    public StructStat stat(String path) throws ErrnoException {
        StructStat varB4EAC82CA7396A68D541C85D26508E83_1276024360 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1276024360 = os.stat(path);
        addTaint(path.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1276024360.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1276024360;
        // ---------- Original Method ----------
        //return os.stat(path);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.121 -0400", hash_original_method = "EA8F2D89CBB0B8AF52F0D62C5DA4B5A0", hash_generated_method = "8FF08B062286514D080A77D8D4212DCC")
    public StructStatFs statfs(String path) throws ErrnoException {
        StructStatFs varB4EAC82CA7396A68D541C85D26508E83_771119881 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_771119881 = os.statfs(path);
        addTaint(path.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_771119881.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_771119881;
        // ---------- Original Method ----------
        //return os.statfs(path);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.122 -0400", hash_original_method = "FBEAE456B3A3C776553B1F7E912CD6FB", hash_generated_method = "7199CFB27584C486A416D6FE176CB7E3")
    public String strerror(int errno) {
        String varB4EAC82CA7396A68D541C85D26508E83_1166438213 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1166438213 = os.strerror(errno);
        addTaint(errno);
        varB4EAC82CA7396A68D541C85D26508E83_1166438213.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1166438213;
        // ---------- Original Method ----------
        //return os.strerror(errno);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.122 -0400", hash_original_method = "FB4E2B29DA5C665C03E887C9C86A36A3", hash_generated_method = "A481904BFAEB009329F86B88C81878BA")
    public void symlink(String oldPath, String newPath) throws ErrnoException {
        os.symlink(oldPath, newPath);
        addTaint(oldPath.getTaint());
        addTaint(newPath.getTaint());
        // ---------- Original Method ----------
        //os.symlink(oldPath, newPath);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.122 -0400", hash_original_method = "9239DE14FB7F01A1D647B884E3411551", hash_generated_method = "DC3D7A416687739A9B6E1390AE3B06C3")
    public long sysconf(int name) {
        long var6016DF4BB18042E7D98C68C5D480E24E_1004377469 = (os.sysconf(name));
        addTaint(name);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_303417421 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_303417421;
        // ---------- Original Method ----------
        //return os.sysconf(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.123 -0400", hash_original_method = "E92B0E3CCB7269FEE37854B5F086E530", hash_generated_method = "1D1AD205631E66A7760A024FBA2A4B06")
    public StructUtsname uname() {
        StructUtsname varB4EAC82CA7396A68D541C85D26508E83_1779189873 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1779189873 = os.uname();
        varB4EAC82CA7396A68D541C85D26508E83_1779189873.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1779189873;
        // ---------- Original Method ----------
        //return os.uname();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.130 -0400", hash_original_method = "EC4C2322F336992223E3CB1B21022BF9", hash_generated_method = "3551D3E609422C8D819F4C240004FC6A")
    public int waitpid(int pid, MutableInt status, int options) throws ErrnoException {
        int varE8B0A97070670E6FF43AAF48DCCF725E_1597957346 = (os.waitpid(pid, status, options));
        addTaint(pid);
        addTaint(status.getTaint());
        addTaint(options);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1178867252 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1178867252;
        // ---------- Original Method ----------
        //return os.waitpid(pid, status, options);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.130 -0400", hash_original_method = "844A22BF74026B79E5C643696D2A0D2B", hash_generated_method = "B20D0F200477DD484CDD3D2B76AB2ED1")
    public int write(FileDescriptor fd, ByteBuffer buffer) throws ErrnoException {
        int var0626357AF90ACF3FB1D934D119466787_39661041 = (os.write(fd, buffer));
        addTaint(fd.getTaint());
        addTaint(buffer.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_608438531 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_608438531;
        // ---------- Original Method ----------
        //return os.write(fd, buffer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.130 -0400", hash_original_method = "437BEB04F87A5AE656D8F235B16E36DF", hash_generated_method = "0E6CF2DF4C054E52225F67C7BC730175")
    public int write(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount) throws ErrnoException {
        int varE733C997547CF269F3AB7BAEB4D044AF_1647385914 = (os.write(fd, bytes, byteOffset, byteCount));
        addTaint(fd.getTaint());
        addTaint(bytes[0]);
        addTaint(byteOffset);
        addTaint(byteCount);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_360268960 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_360268960;
        // ---------- Original Method ----------
        //return os.write(fd, bytes, byteOffset, byteCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.131 -0400", hash_original_method = "8BC1FDC02B601F3DB4DB2A70967C7CDC", hash_generated_method = "C33FD74BE0E12E4897219EED1B5BEB9A")
    public int writev(FileDescriptor fd, Object[] buffers, int[] offsets, int[] byteCounts) throws ErrnoException {
        int var32F5E7D906A9F96A2B6412DC92928AD7_741166934 = (os.writev(fd, buffers, offsets, byteCounts));
        addTaint(fd.getTaint());
        addTaint(buffers[0].getTaint());
        addTaint(offsets[0]);
        addTaint(byteCounts[0]);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1645543488 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1645543488;
        // ---------- Original Method ----------
        //return os.writev(fd, buffers, offsets, byteCounts);
    }

    
}

