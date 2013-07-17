package libcore.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.FileDescriptor;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import libcore.util.MutableInt;
import libcore.util.MutableLong;

public class ForwardingOs implements Os {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.203 -0400", hash_original_field = "DD302F94682DBD2A114D63B0433602E0", hash_generated_field = "AD741EF2B519FC3080D4269DB2BABC3A")

    protected Os os;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.204 -0400", hash_original_method = "EC37328A0FF4DE634029572AA03E9806", hash_generated_method = "C41B14D0DEFEB2ECE4508496A7A2B2B8")
    public  ForwardingOs(Os os) {
        this.os = os;
        // ---------- Original Method ----------
        //this.os = os;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.204 -0400", hash_original_method = "5CF5B545FE52A5A749C69E4804E7DB37", hash_generated_method = "12D095C95349871E9CC765DBCDC76837")
    public FileDescriptor accept(FileDescriptor fd, InetSocketAddress peerAddress) throws ErrnoException {
        addTaint(peerAddress.getTaint());
        addTaint(fd.getTaint());
FileDescriptor varBD3F3A12BED956EC2DBAD6724E131EE4_1074725709 =         os.accept(fd, peerAddress);
        varBD3F3A12BED956EC2DBAD6724E131EE4_1074725709.addTaint(taint);
        return varBD3F3A12BED956EC2DBAD6724E131EE4_1074725709;
        // ---------- Original Method ----------
        //return os.accept(fd, peerAddress);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.205 -0400", hash_original_method = "FFD94E7AFE1E3B1F76A2D696707B6857", hash_generated_method = "442386D116B790F8D0DAD9CEDC212CCE")
    public boolean access(String path, int mode) throws ErrnoException {
        addTaint(mode);
        addTaint(path.getTaint());
        boolean varA84848A4E23C37B75B1B9480406A2F24_876215286 = (os.access(path, mode));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1687961736 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1687961736;
        // ---------- Original Method ----------
        //return os.access(path, mode);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.206 -0400", hash_original_method = "743422D2EB39F172C4245C8DC993624F", hash_generated_method = "3FB6AB800E947D9C97BD913A0E95228A")
    public void bind(FileDescriptor fd, InetAddress address, int port) throws ErrnoException {
        addTaint(port);
        addTaint(address.getTaint());
        addTaint(fd.getTaint());
        os.bind(fd, address, port);
        // ---------- Original Method ----------
        //os.bind(fd, address, port);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.206 -0400", hash_original_method = "A92F7B75A5B2B90071388C67FA677A74", hash_generated_method = "6B4537EA67AC501557BCEB954A023431")
    public void chmod(String path, int mode) throws ErrnoException {
        addTaint(mode);
        addTaint(path.getTaint());
        os.chmod(path, mode);
        // ---------- Original Method ----------
        //os.chmod(path, mode);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.207 -0400", hash_original_method = "2AF652D8862D637B4A4051CAB7CD62FB", hash_generated_method = "2F0112CC8A8D4BE0D6F62358279113A6")
    public void close(FileDescriptor fd) throws ErrnoException {
        addTaint(fd.getTaint());
        os.close(fd);
        // ---------- Original Method ----------
        //os.close(fd);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.207 -0400", hash_original_method = "FADD460EF8DBCF58AF836CFAB2496AF1", hash_generated_method = "1D640A9144AD2F57599B280632714196")
    public void connect(FileDescriptor fd, InetAddress address, int port) throws ErrnoException {
        addTaint(port);
        addTaint(address.getTaint());
        addTaint(fd.getTaint());
        os.connect(fd, address, port);
        // ---------- Original Method ----------
        //os.connect(fd, address, port);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.208 -0400", hash_original_method = "6162F8350974235CF8AA9EBE9F68335F", hash_generated_method = "550A159DB5E29D4E8BB7B152AE1C8FB8")
    public FileDescriptor dup(FileDescriptor oldFd) throws ErrnoException {
        addTaint(oldFd.getTaint());
FileDescriptor var72A67206710ECA9216A66A0C39AFD1CC_841156064 =         os.dup(oldFd);
        var72A67206710ECA9216A66A0C39AFD1CC_841156064.addTaint(taint);
        return var72A67206710ECA9216A66A0C39AFD1CC_841156064;
        // ---------- Original Method ----------
        //return os.dup(oldFd);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.208 -0400", hash_original_method = "E190E2A3CFD75C84461AB90FFE03369B", hash_generated_method = "7600904C98ED256F933E8E0CF67F7DC0")
    public FileDescriptor dup2(FileDescriptor oldFd, int newFd) throws ErrnoException {
        addTaint(newFd);
        addTaint(oldFd.getTaint());
FileDescriptor var092978DB9B00BDE1FF699CE100480620_1633964602 =         os.dup2(oldFd, newFd);
        var092978DB9B00BDE1FF699CE100480620_1633964602.addTaint(taint);
        return var092978DB9B00BDE1FF699CE100480620_1633964602;
        // ---------- Original Method ----------
        //return os.dup2(oldFd, newFd);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.374 -0400", hash_original_method = "5CF51EBD75B5D23C7F632D7D494380D1", hash_generated_method = "93195CDDB03719F912FA0A8180D62535")
    public String[] environ() {
String[] varFE76A844465119D9804B64AE61EA0663_1923812648 =         os.environ();
        varFE76A844465119D9804B64AE61EA0663_1923812648.addTaint(taint);
        return varFE76A844465119D9804B64AE61EA0663_1923812648;
        // ---------- Original Method ----------
        //return os.environ();
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.375 -0400", hash_original_method = "CA43F47313D11741B7EE5D06954736CB", hash_generated_method = "FAA782A5FF0554102280F11A91B9D3F0")
    public int fcntlVoid(FileDescriptor fd, int cmd) throws ErrnoException {
        addTaint(cmd);
        addTaint(fd.getTaint());
        int var7E7FCED175E8A23B2565EDE47A8C8539_1803652230 = (os.fcntlVoid(fd, cmd));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_989204788 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_989204788;
        // ---------- Original Method ----------
        //return os.fcntlVoid(fd, cmd);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.375 -0400", hash_original_method = "6B248418A1B43AC8597DD680343F17BD", hash_generated_method = "44A249B5C7F9E0E3F9BF55BDA428E039")
    public int fcntlLong(FileDescriptor fd, int cmd, long arg) throws ErrnoException {
        addTaint(arg);
        addTaint(cmd);
        addTaint(fd.getTaint());
        int var53D6416246C8B3FFB5D3E0CEC45E8676_384730368 = (os.fcntlLong(fd, cmd, arg));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1430222123 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1430222123;
        // ---------- Original Method ----------
        //return os.fcntlLong(fd, cmd, arg);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.375 -0400", hash_original_method = "28B6741D270DBCC0BDA43B4FBA76C484", hash_generated_method = "92311FE36D42D3B1654F8B86B4836C76")
    public int fcntlFlock(FileDescriptor fd, int cmd, StructFlock arg) throws ErrnoException {
        addTaint(arg.getTaint());
        addTaint(cmd);
        addTaint(fd.getTaint());
        int varC51A438B6A3E80322EBABB17FBA3EE39_1292072972 = (os.fcntlFlock(fd, cmd, arg));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_808266089 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_808266089;
        // ---------- Original Method ----------
        //return os.fcntlFlock(fd, cmd, arg);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.376 -0400", hash_original_method = "D2B4800A8551761D0A11CAE1762DA39E", hash_generated_method = "57861540BC1ED973DA07B22FF0F86AC8")
    public void fdatasync(FileDescriptor fd) throws ErrnoException {
        addTaint(fd.getTaint());
        os.fdatasync(fd);
        // ---------- Original Method ----------
        //os.fdatasync(fd);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.376 -0400", hash_original_method = "0159E8BC0EB89F7B9A8B0DA54E55E46B", hash_generated_method = "5E9475050449C28ECCD8F317326485CD")
    public StructStat fstat(FileDescriptor fd) throws ErrnoException {
        addTaint(fd.getTaint());
StructStat varE56A0E1D81BA813D420E25A118C3BF89_1066485723 =         os.fstat(fd);
        varE56A0E1D81BA813D420E25A118C3BF89_1066485723.addTaint(taint);
        return varE56A0E1D81BA813D420E25A118C3BF89_1066485723;
        // ---------- Original Method ----------
        //return os.fstat(fd);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.376 -0400", hash_original_method = "1D4670A49E88E5904763EEFCF378AA9C", hash_generated_method = "42B37ECE9FFEE00F02FE19CD33FB8771")
    public StructStatFs fstatfs(FileDescriptor fd) throws ErrnoException {
        addTaint(fd.getTaint());
StructStatFs var4852AF1AB60ABCB5F55561CD74B51D75_14997725 =         os.fstatfs(fd);
        var4852AF1AB60ABCB5F55561CD74B51D75_14997725.addTaint(taint);
        return var4852AF1AB60ABCB5F55561CD74B51D75_14997725;
        // ---------- Original Method ----------
        //return os.fstatfs(fd);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.377 -0400", hash_original_method = "5A3103E0191F55AC2413EF7A293382EA", hash_generated_method = "6A2EE843B3FB0419BC5E5D33CCCADFE6")
    public void fsync(FileDescriptor fd) throws ErrnoException {
        addTaint(fd.getTaint());
        os.fsync(fd);
        // ---------- Original Method ----------
        //os.fsync(fd);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.377 -0400", hash_original_method = "B89F13DA07AD88D9E35FDD0F8C706602", hash_generated_method = "D2D3458FE0142CA569C9075ECBF9DD4D")
    public void ftruncate(FileDescriptor fd, long length) throws ErrnoException {
        addTaint(length);
        addTaint(fd.getTaint());
        os.ftruncate(fd, length);
        // ---------- Original Method ----------
        //os.ftruncate(fd, length);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.377 -0400", hash_original_method = "4EDF3DB0839BDB5BB59D5BDCF6ED266B", hash_generated_method = "930A83AB33B776A91C71D7165F29793B")
    public String gai_strerror(int error) {
        addTaint(error);
String var1A676D6EB28C23C605FF41F2AF93787C_1059372021 =         os.gai_strerror(error);
        var1A676D6EB28C23C605FF41F2AF93787C_1059372021.addTaint(taint);
        return var1A676D6EB28C23C605FF41F2AF93787C_1059372021;
        // ---------- Original Method ----------
        //return os.gai_strerror(error);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.377 -0400", hash_original_method = "D134969B79309E2FFE6734562680F40F", hash_generated_method = "82AB756B7DA416F4B9383EB9CA2A465A")
    public InetAddress[] getaddrinfo(String node, StructAddrinfo hints) throws GaiException {
        addTaint(hints.getTaint());
        addTaint(node.getTaint());
InetAddress[] var740CD4C878D078EA073D38DF14180AA4_816725390 =         os.getaddrinfo(node, hints);
        var740CD4C878D078EA073D38DF14180AA4_816725390.addTaint(taint);
        return var740CD4C878D078EA073D38DF14180AA4_816725390;
        // ---------- Original Method ----------
        //return os.getaddrinfo(node, hints);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.378 -0400", hash_original_method = "DA32E4A67BBB878517DC4C1F6AD2DE47", hash_generated_method = "7861FF8620AF09D9132202CA4BEF372B")
    public int getegid() {
        int varD3DDD791E3B9818D6D9AAA818D409680_1422123525 = (os.getegid());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_471455733 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_471455733;
        // ---------- Original Method ----------
        //return os.getegid();
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.378 -0400", hash_original_method = "FAD72A6DE2CC7E2DB1B9B6FC41642D5B", hash_generated_method = "43359785554380742F653E55250B10A9")
    public int geteuid() {
        int var8ACA055E841336581E8124997CB929F0_2086722891 = (os.geteuid());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_981829252 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_981829252;
        // ---------- Original Method ----------
        //return os.geteuid();
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.378 -0400", hash_original_method = "FADA5B6063E47C208AC2D0843F6EB847", hash_generated_method = "CCC6527A5DA88AEE1C9422691FFA2666")
    public int getgid() {
        int varEFFC043516AADF9323B0F00E84602B8A_1727101661 = (os.getgid());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_951184567 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_951184567;
        // ---------- Original Method ----------
        //return os.getgid();
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.379 -0400", hash_original_method = "E4B66B682B354EFDCC2A2307B9973162", hash_generated_method = "F241B21293629B650FC894C21C51EB08")
    public String getenv(String name) {
        addTaint(name.getTaint());
String varB8D29798741A3C7F5BF1B240675D23EC_193183748 =         os.getenv(name);
        varB8D29798741A3C7F5BF1B240675D23EC_193183748.addTaint(taint);
        return varB8D29798741A3C7F5BF1B240675D23EC_193183748;
        // ---------- Original Method ----------
        //return os.getenv(name);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.379 -0400", hash_original_method = "95C6CCF446FE941364E9F3FC808640B5", hash_generated_method = "0C6602F88896116CA210613E6D115EC6")
    public String getnameinfo(InetAddress address, int flags) throws GaiException {
        addTaint(flags);
        addTaint(address.getTaint());
String var5E6BD842B2EC751BA2EFD8A767AF25B0_2035717873 =         os.getnameinfo(address, flags);
        var5E6BD842B2EC751BA2EFD8A767AF25B0_2035717873.addTaint(taint);
        return var5E6BD842B2EC751BA2EFD8A767AF25B0_2035717873;
        // ---------- Original Method ----------
        //return os.getnameinfo(address, flags);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.379 -0400", hash_original_method = "A3B371C9A268817901795576D0A04CF6", hash_generated_method = "DD31FFA70A022AC188FD36B7D704FCE4")
    public int getpid() {
        int varBD652AAA094ADCAFCA34624ADE8B6B42_953395837 = (os.getpid());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_765494199 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_765494199;
        // ---------- Original Method ----------
        //return os.getpid();
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.380 -0400", hash_original_method = "878D1FDE3DC9E3A460294EB2A78F5342", hash_generated_method = "82594A1461A81364F414B9A9C52DC251")
    public int getppid() {
        int varC8821EB47893FD7A2253872918CA61D3_1731027250 = (os.getppid());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_707721170 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_707721170;
        // ---------- Original Method ----------
        //return os.getppid();
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.380 -0400", hash_original_method = "A3C50DDCB01897A6F2E46FE623EA65A2", hash_generated_method = "35A2403A44B3FE1DB874B3CF935FA7FD")
    public StructPasswd getpwnam(String name) throws ErrnoException {
        addTaint(name.getTaint());
StructPasswd var15CF71F6AA18DFA6E0D567A6EB2FF135_977262245 =         os.getpwnam(name);
        var15CF71F6AA18DFA6E0D567A6EB2FF135_977262245.addTaint(taint);
        return var15CF71F6AA18DFA6E0D567A6EB2FF135_977262245;
        // ---------- Original Method ----------
        //return os.getpwnam(name);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.380 -0400", hash_original_method = "F069BDB68A1BE69C49E58A44BE7A4944", hash_generated_method = "56750C35CFFDB2C43AEA2239DF30D3B4")
    public StructPasswd getpwuid(int uid) throws ErrnoException {
        addTaint(uid);
StructPasswd varF1FFADC007699FC5886376B578C443BA_192009488 =         os.getpwuid(uid);
        varF1FFADC007699FC5886376B578C443BA_192009488.addTaint(taint);
        return varF1FFADC007699FC5886376B578C443BA_192009488;
        // ---------- Original Method ----------
        //return os.getpwuid(uid);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.381 -0400", hash_original_method = "C71AB83C8CB24831B3B392DF1EFA2A55", hash_generated_method = "8034E88E7D2B59325375A0B15791CA55")
    public SocketAddress getsockname(FileDescriptor fd) throws ErrnoException {
        addTaint(fd.getTaint());
SocketAddress var9FA8DDD00CD636DC6E093CBFEE8BB7B4_123775842 =         os.getsockname(fd);
        var9FA8DDD00CD636DC6E093CBFEE8BB7B4_123775842.addTaint(taint);
        return var9FA8DDD00CD636DC6E093CBFEE8BB7B4_123775842;
        // ---------- Original Method ----------
        //return os.getsockname(fd);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.381 -0400", hash_original_method = "E5D66E4A2B17F99E78F6B2E97C4D0018", hash_generated_method = "2ADEFED99997DE09DCD617FF4AC7AD0E")
    public int getsockoptByte(FileDescriptor fd, int level, int option) throws ErrnoException {
        addTaint(option);
        addTaint(level);
        addTaint(fd.getTaint());
        int var038C3086A7CE54819B6D4606DE432F88_795710622 = (os.getsockoptByte(fd, level, option));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_626604548 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_626604548;
        // ---------- Original Method ----------
        //return os.getsockoptByte(fd, level, option);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.381 -0400", hash_original_method = "0CBF6F7E2BE2FF171C45C7BCFC831012", hash_generated_method = "4F06B3B5D863C5AD8703A85B60632F25")
    public InetAddress getsockoptInAddr(FileDescriptor fd, int level, int option) throws ErrnoException {
        addTaint(option);
        addTaint(level);
        addTaint(fd.getTaint());
InetAddress var9200B36BD92F4EFF190C70A41427EDDD_1807008060 =         os.getsockoptInAddr(fd, level, option);
        var9200B36BD92F4EFF190C70A41427EDDD_1807008060.addTaint(taint);
        return var9200B36BD92F4EFF190C70A41427EDDD_1807008060;
        // ---------- Original Method ----------
        //return os.getsockoptInAddr(fd, level, option);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.382 -0400", hash_original_method = "946A87B9C2E87F4C961C36C4569A31BA", hash_generated_method = "987D000281310F7DADD0A98ADCACE70E")
    public int getsockoptInt(FileDescriptor fd, int level, int option) throws ErrnoException {
        addTaint(option);
        addTaint(level);
        addTaint(fd.getTaint());
        int var499898D1A8801BCC58E96E5A6C9378FE_1104619343 = (os.getsockoptInt(fd, level, option));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1173475702 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1173475702;
        // ---------- Original Method ----------
        //return os.getsockoptInt(fd, level, option);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.382 -0400", hash_original_method = "EBD2988D937DD58B5AD9697AEE85A0FB", hash_generated_method = "511861C4FB31F0090716061695557C7C")
    public StructLinger getsockoptLinger(FileDescriptor fd, int level, int option) throws ErrnoException {
        addTaint(option);
        addTaint(level);
        addTaint(fd.getTaint());
StructLinger var9B3F6FEEB3CA102B1233EA407FC83A06_736779765 =         os.getsockoptLinger(fd, level, option);
        var9B3F6FEEB3CA102B1233EA407FC83A06_736779765.addTaint(taint);
        return var9B3F6FEEB3CA102B1233EA407FC83A06_736779765;
        // ---------- Original Method ----------
        //return os.getsockoptLinger(fd, level, option);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.383 -0400", hash_original_method = "1C478D9E653EA1E4A0CA2442FA9E2156", hash_generated_method = "73B6DF6BE955C6EFB6B7523ABF9D332E")
    public StructTimeval getsockoptTimeval(FileDescriptor fd, int level, int option) throws ErrnoException {
        addTaint(option);
        addTaint(level);
        addTaint(fd.getTaint());
StructTimeval varE79BC9D50FB7F1E53B90E9D7732394D3_204580152 =         os.getsockoptTimeval(fd, level, option);
        varE79BC9D50FB7F1E53B90E9D7732394D3_204580152.addTaint(taint);
        return varE79BC9D50FB7F1E53B90E9D7732394D3_204580152;
        // ---------- Original Method ----------
        //return os.getsockoptTimeval(fd, level, option);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.383 -0400", hash_original_method = "2F11239B76600858937301E80656F86F", hash_generated_method = "D2F6BE5EAD4A12D06DA38BB0EE008CD0")
    public int getuid() {
        int var83381C94B0E274AEEC790EBC352F8EED_912824210 = (os.getuid());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1586457271 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1586457271;
        // ---------- Original Method ----------
        //return os.getuid();
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.383 -0400", hash_original_method = "FD1CFE447DC743FEF7DD120355028D01", hash_generated_method = "5ADB0DAA91AFE7A8B6125FCAFA32C0D9")
    public String if_indextoname(int index) {
        addTaint(index);
String var04A8D1185ACC1CEA933C80A63F9456B4_1019067080 =         os.if_indextoname(index);
        var04A8D1185ACC1CEA933C80A63F9456B4_1019067080.addTaint(taint);
        return var04A8D1185ACC1CEA933C80A63F9456B4_1019067080;
        // ---------- Original Method ----------
        //return os.if_indextoname(index);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.384 -0400", hash_original_method = "244F6B5FD78AC80358A10468727F943C", hash_generated_method = "536D7CAEF5ABE4A200104CA6176D96E9")
    public InetAddress inet_pton(int family, String address) {
        addTaint(address.getTaint());
        addTaint(family);
InetAddress var8437D7F647FCBE2B3C0CC43AAC1E9824_2107331002 =         os.inet_pton(family, address);
        var8437D7F647FCBE2B3C0CC43AAC1E9824_2107331002.addTaint(taint);
        return var8437D7F647FCBE2B3C0CC43AAC1E9824_2107331002;
        // ---------- Original Method ----------
        //return os.inet_pton(family, address);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.384 -0400", hash_original_method = "81C548F366545C14DF26B9A5D253BEA5", hash_generated_method = "9A273C88EB78AF1966DD32A3695C43CC")
    public InetAddress ioctlInetAddress(FileDescriptor fd, int cmd, String interfaceName) throws ErrnoException {
        addTaint(interfaceName.getTaint());
        addTaint(cmd);
        addTaint(fd.getTaint());
InetAddress var369337E903CB9434A5702027B369AE40_526341555 =         os.ioctlInetAddress(fd, cmd, interfaceName);
        var369337E903CB9434A5702027B369AE40_526341555.addTaint(taint);
        return var369337E903CB9434A5702027B369AE40_526341555;
        // ---------- Original Method ----------
        //return os.ioctlInetAddress(fd, cmd, interfaceName);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.384 -0400", hash_original_method = "B9A716BFE88006BFE54885EB5B40EF6E", hash_generated_method = "12D5A7D652D64413BBAFAF1ECBB85E3B")
    public int ioctlInt(FileDescriptor fd, int cmd, MutableInt arg) throws ErrnoException {
        addTaint(arg.getTaint());
        addTaint(cmd);
        addTaint(fd.getTaint());
        int varA9CCCA2581F530D4B26AA6A54BB354B5_154242829 = (os.ioctlInt(fd, cmd, arg));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2025893421 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2025893421;
        // ---------- Original Method ----------
        //return os.ioctlInt(fd, cmd, arg);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.384 -0400", hash_original_method = "E622E0FA602C62724E493B1B03996EEA", hash_generated_method = "364E497063FE8DCCA46F7442C28477AC")
    public boolean isatty(FileDescriptor fd) {
        addTaint(fd.getTaint());
        boolean var6CBA868D125ACB9BCBBBFF1D9E51A2F9_965554353 = (os.isatty(fd));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1300409063 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1300409063;
        // ---------- Original Method ----------
        //return os.isatty(fd);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.385 -0400", hash_original_method = "39C5C221EF1E81F6FE3B9410463D5E57", hash_generated_method = "DBEAE047D45BD548015B1999EC5BB4F3")
    public void kill(int pid, int signal) throws ErrnoException {
        addTaint(signal);
        addTaint(pid);
        os.kill(pid, signal);
        // ---------- Original Method ----------
        //os.kill(pid, signal);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.385 -0400", hash_original_method = "039EEA76B9DC6E04921BFC5BC270EDD9", hash_generated_method = "E3C17DDBDA40BFB08F346B4FA5DC6FE6")
    public void listen(FileDescriptor fd, int backlog) throws ErrnoException {
        addTaint(backlog);
        addTaint(fd.getTaint());
        os.listen(fd, backlog);
        // ---------- Original Method ----------
        //os.listen(fd, backlog);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.385 -0400", hash_original_method = "3005A45BFDFB73561B6BABAEF57B12E1", hash_generated_method = "6E555C446B7131752017CAF5803EDA6B")
    public long lseek(FileDescriptor fd, long offset, int whence) throws ErrnoException {
        addTaint(whence);
        addTaint(offset);
        addTaint(fd.getTaint());
        long var6DC67B24B81A58F45C38A7900BEDE1D7_1211493837 = (os.lseek(fd, offset, whence));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_777884991 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_777884991;
        // ---------- Original Method ----------
        //return os.lseek(fd, offset, whence);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.385 -0400", hash_original_method = "F288030A10BA391FE6D7AD19552493B8", hash_generated_method = "825DE05CD98C76EE02BA508EB95E14F1")
    public StructStat lstat(String path) throws ErrnoException {
        addTaint(path.getTaint());
StructStat var38A6E6D3DD9B1473AD66E831812A3A1C_861979030 =         os.lstat(path);
        var38A6E6D3DD9B1473AD66E831812A3A1C_861979030.addTaint(taint);
        return var38A6E6D3DD9B1473AD66E831812A3A1C_861979030;
        // ---------- Original Method ----------
        //return os.lstat(path);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.385 -0400", hash_original_method = "0D8D349CD4EFD867777AD4E59116610D", hash_generated_method = "3312DFF07AA3A26C73F78DC853472D9A")
    public void mincore(long address, long byteCount, byte[] vector) throws ErrnoException {
        addTaint(vector[0]);
        addTaint(byteCount);
        addTaint(address);
        os.mincore(address, byteCount, vector);
        // ---------- Original Method ----------
        //os.mincore(address, byteCount, vector);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.385 -0400", hash_original_method = "689C229BD7F4B7F5308857A16DB04D8E", hash_generated_method = "FDE79479BA876DE1900765ED46A43059")
    public void mkdir(String path, int mode) throws ErrnoException {
        addTaint(mode);
        addTaint(path.getTaint());
        os.mkdir(path, mode);
        // ---------- Original Method ----------
        //os.mkdir(path, mode);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.385 -0400", hash_original_method = "419517122697B0628E53EB3E2B0A6370", hash_generated_method = "83C91E3E741A7504E34436A563F7F9AA")
    public void mlock(long address, long byteCount) throws ErrnoException {
        addTaint(byteCount);
        addTaint(address);
        os.mlock(address, byteCount);
        // ---------- Original Method ----------
        //os.mlock(address, byteCount);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.386 -0400", hash_original_method = "4029BCDA0489C716FD1384F50323A029", hash_generated_method = "D165DBDBE625761CB22C218695F3BB36")
    public long mmap(long address, long byteCount, int prot, int flags, FileDescriptor fd, long offset) throws ErrnoException {
        addTaint(offset);
        addTaint(fd.getTaint());
        addTaint(flags);
        addTaint(prot);
        addTaint(byteCount);
        addTaint(address);
        long varAD502B1FF470D8DAF5CA95BC0912EE8E_1467912311 = (os.mmap(address, byteCount, prot, flags, fd, offset));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_969955091 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_969955091;
        // ---------- Original Method ----------
        //return os.mmap(address, byteCount, prot, flags, fd, offset);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.386 -0400", hash_original_method = "26058ECBCE0A88D4B8D4418B78F705C5", hash_generated_method = "849EB539834F4BEBB8F9E7448A639AA4")
    public void msync(long address, long byteCount, int flags) throws ErrnoException {
        addTaint(flags);
        addTaint(byteCount);
        addTaint(address);
        os.msync(address, byteCount, flags);
        // ---------- Original Method ----------
        //os.msync(address, byteCount, flags);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.386 -0400", hash_original_method = "12F3B374B5C7D041381B26987EDF7BE8", hash_generated_method = "4163D5EA3CE24B5E4F1E63F074AD5BC7")
    public void munlock(long address, long byteCount) throws ErrnoException {
        addTaint(byteCount);
        addTaint(address);
        os.munlock(address, byteCount);
        // ---------- Original Method ----------
        //os.munlock(address, byteCount);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.386 -0400", hash_original_method = "93EF25630433342C6922044F58653EDA", hash_generated_method = "3A8128766C72AF23753CEFA003FBBA2A")
    public void munmap(long address, long byteCount) throws ErrnoException {
        addTaint(byteCount);
        addTaint(address);
        os.munmap(address, byteCount);
        // ---------- Original Method ----------
        //os.munmap(address, byteCount);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.386 -0400", hash_original_method = "3A1C8AE14DFE6F094F17065084A852DA", hash_generated_method = "C88427B1DC18F8F0659D2794FA250144")
    public FileDescriptor open(String path, int flags, int mode) throws ErrnoException {
        addTaint(mode);
        addTaint(flags);
        addTaint(path.getTaint());
FileDescriptor var39B89F4C81D0661C45D0F28BA8EB3A2E_1218836585 =         os.open(path, flags, mode);
        var39B89F4C81D0661C45D0F28BA8EB3A2E_1218836585.addTaint(taint);
        return var39B89F4C81D0661C45D0F28BA8EB3A2E_1218836585;
        // ---------- Original Method ----------
        //return os.open(path, flags, mode);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.386 -0400", hash_original_method = "C44D806183F8681F84B21225E3DD2820", hash_generated_method = "492027FE2D4A52EE5F88F5745E760CB8")
    public FileDescriptor[] pipe() throws ErrnoException {
FileDescriptor[] varEC459D4EC842CD610D05C93AF9916DD8_138428626 =         os.pipe();
        varEC459D4EC842CD610D05C93AF9916DD8_138428626.addTaint(taint);
        return varEC459D4EC842CD610D05C93AF9916DD8_138428626;
        // ---------- Original Method ----------
        //return os.pipe();
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.386 -0400", hash_original_method = "5599B9E106312A6343AFDB459C1296E6", hash_generated_method = "DFB4A7FCFCFF8CDFA6B1A7FE8074A2D1")
    public int poll(StructPollfd[] fds, int timeoutMs) throws ErrnoException {
        addTaint(timeoutMs);
        addTaint(fds[0].getTaint());
        int var222980D2507B3788FA6BCF34461C7D94_1658508246 = (os.poll(fds, timeoutMs));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1833019374 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1833019374;
        // ---------- Original Method ----------
        //return os.poll(fds, timeoutMs);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.387 -0400", hash_original_method = "E02E4577E71F70F2C9CAE7AED1E2F8AC", hash_generated_method = "B46718324D291144C06EBC73880921B7")
    public int pread(FileDescriptor fd, ByteBuffer buffer, long offset) throws ErrnoException {
        addTaint(offset);
        addTaint(buffer.getTaint());
        addTaint(fd.getTaint());
        int varDE15DBE284FB6126AA45A8BF58915EDD_1442367590 = (os.pread(fd, buffer, offset));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_208157256 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_208157256;
        // ---------- Original Method ----------
        //return os.pread(fd, buffer, offset);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.387 -0400", hash_original_method = "77B89AD0CF3C5D71E7DD42E992F283EF", hash_generated_method = "F82E1AAAC1361A70A0BF2AAD7445EBDF")
    public int pread(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount, long offset) throws ErrnoException {
        addTaint(offset);
        addTaint(byteCount);
        addTaint(byteOffset);
        addTaint(bytes[0]);
        addTaint(fd.getTaint());
        int varE3DF49A276F761267024E03A73F20DEB_2109868903 = (os.pread(fd, bytes, byteOffset, byteCount, offset));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1805107817 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1805107817;
        // ---------- Original Method ----------
        //return os.pread(fd, bytes, byteOffset, byteCount, offset);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.387 -0400", hash_original_method = "1CD5001FEE779ACE9E3DB9100CD609FC", hash_generated_method = "EB150DCDF76E3096E703BAA1CBD0B9E1")
    public int pwrite(FileDescriptor fd, ByteBuffer buffer, long offset) throws ErrnoException {
        addTaint(offset);
        addTaint(buffer.getTaint());
        addTaint(fd.getTaint());
        int varFCCAEB3AF4EC4F5C5FFFA4B4BD20FF50_192563275 = (os.pwrite(fd, buffer, offset));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1594409350 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1594409350;
        // ---------- Original Method ----------
        //return os.pwrite(fd, buffer, offset);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.387 -0400", hash_original_method = "F0611566A9565E2DEF97709E6B9B6418", hash_generated_method = "D9E6F93EEDA7A8A8DD6689412B17A527")
    public int pwrite(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount, long offset) throws ErrnoException {
        addTaint(offset);
        addTaint(byteCount);
        addTaint(byteOffset);
        addTaint(bytes[0]);
        addTaint(fd.getTaint());
        int var6074C3BFC1FB418DF49AE75B35C3814B_1084566810 = (os.pwrite(fd, bytes, byteOffset, byteCount, offset));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1976499886 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1976499886;
        // ---------- Original Method ----------
        //return os.pwrite(fd, bytes, byteOffset, byteCount, offset);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.387 -0400", hash_original_method = "F3C222630BE6E1046A8D40208CD4C60B", hash_generated_method = "89D27629C9A902809362A157BD941D4B")
    public int read(FileDescriptor fd, ByteBuffer buffer) throws ErrnoException {
        addTaint(buffer.getTaint());
        addTaint(fd.getTaint());
        int var0150C7D03DEBCE79D9B842076877B65C_671641276 = (os.read(fd, buffer));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1526367946 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1526367946;
        // ---------- Original Method ----------
        //return os.read(fd, buffer);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.387 -0400", hash_original_method = "21F8B1ED0ECF46FDBCE6EA979BADF2C3", hash_generated_method = "07B3DE002498B0502DC8ECB7CC73740A")
    public int read(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount) throws ErrnoException {
        addTaint(byteCount);
        addTaint(byteOffset);
        addTaint(bytes[0]);
        addTaint(fd.getTaint());
        int var1E40651C708F64B04B9DD67336B66EA0_1718924518 = (os.read(fd, bytes, byteOffset, byteCount));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_285301228 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_285301228;
        // ---------- Original Method ----------
        //return os.read(fd, bytes, byteOffset, byteCount);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.387 -0400", hash_original_method = "E2800F54CC6608A5FBBD1BF36223D806", hash_generated_method = "BA1AE030E1CE84C29D6611853B0D060A")
    public int readv(FileDescriptor fd, Object[] buffers, int[] offsets, int[] byteCounts) throws ErrnoException {
        addTaint(byteCounts[0]);
        addTaint(offsets[0]);
        addTaint(buffers[0].getTaint());
        addTaint(fd.getTaint());
        int var9267859C7D3D2D2A030DB3D26AF801EF_360829047 = (os.readv(fd, buffers, offsets, byteCounts));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_429253158 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_429253158;
        // ---------- Original Method ----------
        //return os.readv(fd, buffers, offsets, byteCounts);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.389 -0400", hash_original_method = "84F37C132BD33033E9DE4E38A8430067", hash_generated_method = "265D22B72BC57B9345994315E2C188AA")
    public int recvfrom(FileDescriptor fd, ByteBuffer buffer, int flags, InetSocketAddress srcAddress) throws ErrnoException {
        addTaint(srcAddress.getTaint());
        addTaint(flags);
        addTaint(buffer.getTaint());
        addTaint(fd.getTaint());
        int var148C659D0B6FCF3CBC57A3D34F2DD492_279146268 = (os.recvfrom(fd, buffer, flags, srcAddress));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1129735775 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1129735775;
        // ---------- Original Method ----------
        //return os.recvfrom(fd, buffer, flags, srcAddress);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.390 -0400", hash_original_method = "0394D475125B49320B23E75594B5C434", hash_generated_method = "68A8B876C1152BE49CA31B885F2EB81B")
    public int recvfrom(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount, int flags, InetSocketAddress srcAddress) throws ErrnoException {
        addTaint(srcAddress.getTaint());
        addTaint(flags);
        addTaint(byteCount);
        addTaint(byteOffset);
        addTaint(bytes[0]);
        addTaint(fd.getTaint());
        int varE1EBC5E4A46203E8474950D1E43CBCA7_90538392 = (os.recvfrom(fd, bytes, byteOffset, byteCount, flags, srcAddress));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_93358008 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_93358008;
        // ---------- Original Method ----------
        //return os.recvfrom(fd, bytes, byteOffset, byteCount, flags, srcAddress);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.390 -0400", hash_original_method = "B12B5B450AD1F25F30BAE5F7F0558752", hash_generated_method = "A2AF596065F4863638BADA3258FE20FB")
    public void remove(String path) throws ErrnoException {
        addTaint(path.getTaint());
        os.remove(path);
        // ---------- Original Method ----------
        //os.remove(path);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.390 -0400", hash_original_method = "91C997D77FC3A21A4E5692674F9BE11B", hash_generated_method = "A3D78614387CFF476F7AB25C53A394E1")
    public void rename(String oldPath, String newPath) throws ErrnoException {
        addTaint(newPath.getTaint());
        addTaint(oldPath.getTaint());
        os.rename(oldPath, newPath);
        // ---------- Original Method ----------
        //os.rename(oldPath, newPath);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.390 -0400", hash_original_method = "C572D6E07635A5094C687364A5671672", hash_generated_method = "1F1175EB5AC05501EF06D06BDA2CBFBC")
    public long sendfile(FileDescriptor outFd, FileDescriptor inFd, MutableLong inOffset, long byteCount) throws ErrnoException {
        addTaint(byteCount);
        addTaint(inOffset.getTaint());
        addTaint(inFd.getTaint());
        addTaint(outFd.getTaint());
        long var1812BF08C3788EF7F17D6AB478E68882_1594980735 = (os.sendfile(outFd, inFd, inOffset, byteCount));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1688320785 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1688320785;
        // ---------- Original Method ----------
        //return os.sendfile(outFd, inFd, inOffset, byteCount);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.391 -0400", hash_original_method = "88066FF66E9BA638CFCEFABD2B423922", hash_generated_method = "1CA04D30556313214D3DD3EC1AB82A58")
    public int sendto(FileDescriptor fd, ByteBuffer buffer, int flags, InetAddress inetAddress, int port) throws ErrnoException {
        addTaint(port);
        addTaint(inetAddress.getTaint());
        addTaint(flags);
        addTaint(buffer.getTaint());
        addTaint(fd.getTaint());
        int var74D30D6BF88A4023586B126D875357BC_2142848792 = (os.sendto(fd, buffer, flags, inetAddress, port));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2058332142 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2058332142;
        // ---------- Original Method ----------
        //return os.sendto(fd, buffer, flags, inetAddress, port);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.391 -0400", hash_original_method = "BC2321A87F2222D5681A88900983F12D", hash_generated_method = "0A7EB4BC5B20225555B5BAB00CBD02F3")
    public int sendto(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount, int flags, InetAddress inetAddress, int port) throws ErrnoException {
        addTaint(port);
        addTaint(inetAddress.getTaint());
        addTaint(flags);
        addTaint(byteCount);
        addTaint(byteOffset);
        addTaint(bytes[0]);
        addTaint(fd.getTaint());
        int var209FD29A1FDDAD7A53690DD257C173A4_33270181 = (os.sendto(fd, bytes, byteOffset, byteCount, flags, inetAddress, port));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1526007700 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1526007700;
        // ---------- Original Method ----------
        //return os.sendto(fd, bytes, byteOffset, byteCount, flags, inetAddress, port);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.391 -0400", hash_original_method = "D0978EE2EC25CFB475F603941EE6E321", hash_generated_method = "73EB59B4B82964EE5164DA99C4A9AAD9")
    public void setegid(int egid) throws ErrnoException {
        addTaint(egid);
        os.setegid(egid);
        // ---------- Original Method ----------
        //os.setegid(egid);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.391 -0400", hash_original_method = "0B3E20A1D3AFC99676F4A67D4967A4C5", hash_generated_method = "AA89D269A9507B304F7A309D64973CFA")
    public void seteuid(int euid) throws ErrnoException {
        addTaint(euid);
        os.seteuid(euid);
        // ---------- Original Method ----------
        //os.seteuid(euid);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.392 -0400", hash_original_method = "5A836F22DA1ADF6236109717B09FFB11", hash_generated_method = "139B3B462DA900CAEE3A758724971844")
    public void setgid(int gid) throws ErrnoException {
        addTaint(gid);
        os.setgid(gid);
        // ---------- Original Method ----------
        //os.setgid(gid);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.392 -0400", hash_original_method = "02713B5D8B1D9FC1829D645D7EE01360", hash_generated_method = "7F777D07726B5D6D8879F52DDF278D7B")
    public void setsockoptByte(FileDescriptor fd, int level, int option, int value) throws ErrnoException {
        addTaint(value);
        addTaint(option);
        addTaint(level);
        addTaint(fd.getTaint());
        os.setsockoptByte(fd, level, option, value);
        // ---------- Original Method ----------
        //os.setsockoptByte(fd, level, option, value);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.392 -0400", hash_original_method = "859AD73B12F1FCBFB785F9C03E57780C", hash_generated_method = "81FB9024630BF8C9092B1D2283ED099D")
    public void setsockoptIfreq(FileDescriptor fd, int level, int option, String value) throws ErrnoException {
        addTaint(value.getTaint());
        addTaint(option);
        addTaint(level);
        addTaint(fd.getTaint());
        os.setsockoptIfreq(fd, level, option, value);
        // ---------- Original Method ----------
        //os.setsockoptIfreq(fd, level, option, value);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.392 -0400", hash_original_method = "5882A7C612198E8B1D9CBF2EDBCD6FE7", hash_generated_method = "2FE544B7D9BE400A9DFFC169C6E6F679")
    public void setsockoptInt(FileDescriptor fd, int level, int option, int value) throws ErrnoException {
        addTaint(value);
        addTaint(option);
        addTaint(level);
        addTaint(fd.getTaint());
        os.setsockoptInt(fd, level, option, value);
        // ---------- Original Method ----------
        //os.setsockoptInt(fd, level, option, value);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.392 -0400", hash_original_method = "3A8741E8D07270D7E757C05217AEFD39", hash_generated_method = "67B90734BC70B2A457E819F377C35BDB")
    public void setsockoptIpMreqn(FileDescriptor fd, int level, int option, int value) throws ErrnoException {
        addTaint(value);
        addTaint(option);
        addTaint(level);
        addTaint(fd.getTaint());
        os.setsockoptIpMreqn(fd, level, option, value);
        // ---------- Original Method ----------
        //os.setsockoptIpMreqn(fd, level, option, value);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.392 -0400", hash_original_method = "4E1D080A99B5B2F06B7A0201A27B3E99", hash_generated_method = "FC4FA57FD209D765010EA8272F6F05A8")
    public void setsockoptGroupReq(FileDescriptor fd, int level, int option, StructGroupReq value) throws ErrnoException {
        addTaint(value.getTaint());
        addTaint(option);
        addTaint(level);
        addTaint(fd.getTaint());
        os.setsockoptGroupReq(fd, level, option, value);
        // ---------- Original Method ----------
        //os.setsockoptGroupReq(fd, level, option, value);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.393 -0400", hash_original_method = "A1EC25C1EA10D3E94DA65D129945BE62", hash_generated_method = "B8343AC32F7CD518D485EB1CE993C74E")
    public void setsockoptLinger(FileDescriptor fd, int level, int option, StructLinger value) throws ErrnoException {
        addTaint(value.getTaint());
        addTaint(option);
        addTaint(level);
        addTaint(fd.getTaint());
        os.setsockoptLinger(fd, level, option, value);
        // ---------- Original Method ----------
        //os.setsockoptLinger(fd, level, option, value);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.393 -0400", hash_original_method = "B0DC8E18521874709C24B9B37D89D87C", hash_generated_method = "9F838644C701DCC67578DF6678E073CD")
    public void setsockoptTimeval(FileDescriptor fd, int level, int option, StructTimeval value) throws ErrnoException {
        addTaint(value.getTaint());
        addTaint(option);
        addTaint(level);
        addTaint(fd.getTaint());
        os.setsockoptTimeval(fd, level, option, value);
        // ---------- Original Method ----------
        //os.setsockoptTimeval(fd, level, option, value);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.393 -0400", hash_original_method = "554251AE1D031EE7BA07BC4F696C724A", hash_generated_method = "56CBA76A30E42350BA3BE1E4AC7DC5E9")
    public void setuid(int uid) throws ErrnoException {
        addTaint(uid);
        os.setuid(uid);
        // ---------- Original Method ----------
        //os.setuid(uid);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.393 -0400", hash_original_method = "5FEB3BBC8A3C8F5F8A22DE81B35CAE4D", hash_generated_method = "0F1B1EC2C5AD25385828438ADB273DA4")
    public void shutdown(FileDescriptor fd, int how) throws ErrnoException {
        addTaint(how);
        addTaint(fd.getTaint());
        os.shutdown(fd, how);
        // ---------- Original Method ----------
        //os.shutdown(fd, how);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.393 -0400", hash_original_method = "558F533484D6B9C99DDFE653A920693C", hash_generated_method = "99FE1528FBB0A9B914C0D59705593903")
    public FileDescriptor socket(int domain, int type, int protocol) throws ErrnoException {
        addTaint(protocol);
        addTaint(type);
        addTaint(domain);
FileDescriptor varBB6D27D4C0141475D04EE8C4DDC3FDF5_727899286 =         os.socket(domain, type, protocol);
        varBB6D27D4C0141475D04EE8C4DDC3FDF5_727899286.addTaint(taint);
        return varBB6D27D4C0141475D04EE8C4DDC3FDF5_727899286;
        // ---------- Original Method ----------
        //return os.socket(domain, type, protocol);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.393 -0400", hash_original_method = "E3FE6B0CE9C868055585C77F475D7F5A", hash_generated_method = "EF4ABE15DBC837278CBB3842DBE47114")
    public StructStat stat(String path) throws ErrnoException {
        addTaint(path.getTaint());
StructStat var40E24BB1CA1E130E8D0A1C58D44C0F50_1415562650 =         os.stat(path);
        var40E24BB1CA1E130E8D0A1C58D44C0F50_1415562650.addTaint(taint);
        return var40E24BB1CA1E130E8D0A1C58D44C0F50_1415562650;
        // ---------- Original Method ----------
        //return os.stat(path);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.394 -0400", hash_original_method = "EA8F2D89CBB0B8AF52F0D62C5DA4B5A0", hash_generated_method = "1AC512DEC1DE9B4E3B3677CB570AD5AA")
    public StructStatFs statfs(String path) throws ErrnoException {
        addTaint(path.getTaint());
StructStatFs var88B9FED519C4C56BEFB7C111CBFE5FC7_43277800 =         os.statfs(path);
        var88B9FED519C4C56BEFB7C111CBFE5FC7_43277800.addTaint(taint);
        return var88B9FED519C4C56BEFB7C111CBFE5FC7_43277800;
        // ---------- Original Method ----------
        //return os.statfs(path);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.394 -0400", hash_original_method = "FBEAE456B3A3C776553B1F7E912CD6FB", hash_generated_method = "344CCE1CC808B32E86CF7B9A2F1FFAC1")
    public String strerror(int errno) {
        addTaint(errno);
String var732FEF31C0B974955FA12C229A9ECCDE_1289760516 =         os.strerror(errno);
        var732FEF31C0B974955FA12C229A9ECCDE_1289760516.addTaint(taint);
        return var732FEF31C0B974955FA12C229A9ECCDE_1289760516;
        // ---------- Original Method ----------
        //return os.strerror(errno);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.394 -0400", hash_original_method = "FB4E2B29DA5C665C03E887C9C86A36A3", hash_generated_method = "E7853B01626990B5C306CE2B8479DE09")
    public void symlink(String oldPath, String newPath) throws ErrnoException {
        addTaint(newPath.getTaint());
        addTaint(oldPath.getTaint());
        os.symlink(oldPath, newPath);
        // ---------- Original Method ----------
        //os.symlink(oldPath, newPath);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.394 -0400", hash_original_method = "9239DE14FB7F01A1D647B884E3411551", hash_generated_method = "1CC3B99065C885DCB046E9430CC8F634")
    public long sysconf(int name) {
        addTaint(name);
        long varFB026933EA51B070C257890322A8D489_1453937242 = (os.sysconf(name));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1250966564 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1250966564;
        // ---------- Original Method ----------
        //return os.sysconf(name);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.394 -0400", hash_original_method = "E92B0E3CCB7269FEE37854B5F086E530", hash_generated_method = "30EA22B20DFBE66DC59FCA337B8C7326")
    public StructUtsname uname() {
StructUtsname varB5D14CECEAA8EBC755C493954FACA078_25664735 =         os.uname();
        varB5D14CECEAA8EBC755C493954FACA078_25664735.addTaint(taint);
        return varB5D14CECEAA8EBC755C493954FACA078_25664735;
        // ---------- Original Method ----------
        //return os.uname();
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.394 -0400", hash_original_method = "EC4C2322F336992223E3CB1B21022BF9", hash_generated_method = "AF2B5F7EBF7D89BE3E2EB7F14989610B")
    public int waitpid(int pid, MutableInt status, int options) throws ErrnoException {
        addTaint(options);
        addTaint(status.getTaint());
        addTaint(pid);
        int var4A2915882C1189F74F1F05DACCE657B1_1919916003 = (os.waitpid(pid, status, options));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_241158037 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_241158037;
        // ---------- Original Method ----------
        //return os.waitpid(pid, status, options);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.395 -0400", hash_original_method = "844A22BF74026B79E5C643696D2A0D2B", hash_generated_method = "375CFD16F596DFB34AA3519A09CEC4A9")
    public int write(FileDescriptor fd, ByteBuffer buffer) throws ErrnoException {
        addTaint(buffer.getTaint());
        addTaint(fd.getTaint());
        int var14D74F75C9BD675ED0875C35081834D8_403227549 = (os.write(fd, buffer));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_973391505 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_973391505;
        // ---------- Original Method ----------
        //return os.write(fd, buffer);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.395 -0400", hash_original_method = "437BEB04F87A5AE656D8F235B16E36DF", hash_generated_method = "73184B89D41083203DB4EA15F636760B")
    public int write(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount) throws ErrnoException {
        addTaint(byteCount);
        addTaint(byteOffset);
        addTaint(bytes[0]);
        addTaint(fd.getTaint());
        int var21A8634C3DEBC7316061A81665E91499_1921475833 = (os.write(fd, bytes, byteOffset, byteCount));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_579536109 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_579536109;
        // ---------- Original Method ----------
        //return os.write(fd, bytes, byteOffset, byteCount);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.395 -0400", hash_original_method = "8BC1FDC02B601F3DB4DB2A70967C7CDC", hash_generated_method = "9EB3943E14CE6D3464F6C95DC3B0C08F")
    public int writev(FileDescriptor fd, Object[] buffers, int[] offsets, int[] byteCounts) throws ErrnoException {
        addTaint(byteCounts[0]);
        addTaint(offsets[0]);
        addTaint(buffers[0].getTaint());
        addTaint(fd.getTaint());
        int varCCE8841716556A5168B85B70CE6AC0C2_229940677 = (os.writev(fd, buffers, offsets, byteCounts));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1948101827 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1948101827;
        // ---------- Original Method ----------
        //return os.writev(fd, buffers, offsets, byteCounts);
    }

    
}

