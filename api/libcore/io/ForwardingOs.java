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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.545 -0400", hash_original_field = "DD302F94682DBD2A114D63B0433602E0", hash_generated_field = "AD741EF2B519FC3080D4269DB2BABC3A")

    protected Os os;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.546 -0400", hash_original_method = "EC37328A0FF4DE634029572AA03E9806", hash_generated_method = "C41B14D0DEFEB2ECE4508496A7A2B2B8")
    public  ForwardingOs(Os os) {
        this.os = os;
        // ---------- Original Method ----------
        //this.os = os;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.546 -0400", hash_original_method = "5CF5B545FE52A5A749C69E4804E7DB37", hash_generated_method = "F9AD383062D2468D3409B02E01B80DE6")
    public FileDescriptor accept(FileDescriptor fd, InetSocketAddress peerAddress) throws ErrnoException {
        addTaint(peerAddress.getTaint());
        addTaint(fd.getTaint());
FileDescriptor varBD3F3A12BED956EC2DBAD6724E131EE4_1816417314 =         os.accept(fd, peerAddress);
        varBD3F3A12BED956EC2DBAD6724E131EE4_1816417314.addTaint(taint);
        return varBD3F3A12BED956EC2DBAD6724E131EE4_1816417314;
        // ---------- Original Method ----------
        //return os.accept(fd, peerAddress);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.547 -0400", hash_original_method = "FFD94E7AFE1E3B1F76A2D696707B6857", hash_generated_method = "C5C7C09D449FDEC22FA4A70CAA61AAF4")
    public boolean access(String path, int mode) throws ErrnoException {
        addTaint(mode);
        addTaint(path.getTaint());
        boolean varA84848A4E23C37B75B1B9480406A2F24_160967443 = (os.access(path, mode));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1261875627 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1261875627;
        // ---------- Original Method ----------
        //return os.access(path, mode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.547 -0400", hash_original_method = "743422D2EB39F172C4245C8DC993624F", hash_generated_method = "3FB6AB800E947D9C97BD913A0E95228A")
    public void bind(FileDescriptor fd, InetAddress address, int port) throws ErrnoException {
        addTaint(port);
        addTaint(address.getTaint());
        addTaint(fd.getTaint());
        os.bind(fd, address, port);
        // ---------- Original Method ----------
        //os.bind(fd, address, port);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.547 -0400", hash_original_method = "A92F7B75A5B2B90071388C67FA677A74", hash_generated_method = "6B4537EA67AC501557BCEB954A023431")
    public void chmod(String path, int mode) throws ErrnoException {
        addTaint(mode);
        addTaint(path.getTaint());
        os.chmod(path, mode);
        // ---------- Original Method ----------
        //os.chmod(path, mode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.548 -0400", hash_original_method = "2AF652D8862D637B4A4051CAB7CD62FB", hash_generated_method = "2F0112CC8A8D4BE0D6F62358279113A6")
    public void close(FileDescriptor fd) throws ErrnoException {
        addTaint(fd.getTaint());
        os.close(fd);
        // ---------- Original Method ----------
        //os.close(fd);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.548 -0400", hash_original_method = "FADD460EF8DBCF58AF836CFAB2496AF1", hash_generated_method = "1D640A9144AD2F57599B280632714196")
    public void connect(FileDescriptor fd, InetAddress address, int port) throws ErrnoException {
        addTaint(port);
        addTaint(address.getTaint());
        addTaint(fd.getTaint());
        os.connect(fd, address, port);
        // ---------- Original Method ----------
        //os.connect(fd, address, port);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.548 -0400", hash_original_method = "6162F8350974235CF8AA9EBE9F68335F", hash_generated_method = "FD16A2CBCDA4AD3472A7A222A99CCAC7")
    public FileDescriptor dup(FileDescriptor oldFd) throws ErrnoException {
        addTaint(oldFd.getTaint());
FileDescriptor var72A67206710ECA9216A66A0C39AFD1CC_1108519791 =         os.dup(oldFd);
        var72A67206710ECA9216A66A0C39AFD1CC_1108519791.addTaint(taint);
        return var72A67206710ECA9216A66A0C39AFD1CC_1108519791;
        // ---------- Original Method ----------
        //return os.dup(oldFd);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.549 -0400", hash_original_method = "E190E2A3CFD75C84461AB90FFE03369B", hash_generated_method = "05D41E700FF746F6037D303C918FDFFD")
    public FileDescriptor dup2(FileDescriptor oldFd, int newFd) throws ErrnoException {
        addTaint(newFd);
        addTaint(oldFd.getTaint());
FileDescriptor var092978DB9B00BDE1FF699CE100480620_791967014 =         os.dup2(oldFd, newFd);
        var092978DB9B00BDE1FF699CE100480620_791967014.addTaint(taint);
        return var092978DB9B00BDE1FF699CE100480620_791967014;
        // ---------- Original Method ----------
        //return os.dup2(oldFd, newFd);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.549 -0400", hash_original_method = "5CF51EBD75B5D23C7F632D7D494380D1", hash_generated_method = "A087DE312262E77146F484B0766B3E00")
    public String[] environ() {
String[] varFE76A844465119D9804B64AE61EA0663_1286634845 =         os.environ();
        varFE76A844465119D9804B64AE61EA0663_1286634845.addTaint(taint);
        return varFE76A844465119D9804B64AE61EA0663_1286634845;
        // ---------- Original Method ----------
        //return os.environ();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.549 -0400", hash_original_method = "CA43F47313D11741B7EE5D06954736CB", hash_generated_method = "783EE3C4C2F836804D075E0FFC810C31")
    public int fcntlVoid(FileDescriptor fd, int cmd) throws ErrnoException {
        addTaint(cmd);
        addTaint(fd.getTaint());
        int var7E7FCED175E8A23B2565EDE47A8C8539_468026598 = (os.fcntlVoid(fd, cmd));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_986931530 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_986931530;
        // ---------- Original Method ----------
        //return os.fcntlVoid(fd, cmd);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.550 -0400", hash_original_method = "6B248418A1B43AC8597DD680343F17BD", hash_generated_method = "BC9A09ACC24C3B27BABF23995A104BF3")
    public int fcntlLong(FileDescriptor fd, int cmd, long arg) throws ErrnoException {
        addTaint(arg);
        addTaint(cmd);
        addTaint(fd.getTaint());
        int var53D6416246C8B3FFB5D3E0CEC45E8676_617589552 = (os.fcntlLong(fd, cmd, arg));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_403847082 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_403847082;
        // ---------- Original Method ----------
        //return os.fcntlLong(fd, cmd, arg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.550 -0400", hash_original_method = "28B6741D270DBCC0BDA43B4FBA76C484", hash_generated_method = "5500730542940736CF1DB2EB76F498FB")
    public int fcntlFlock(FileDescriptor fd, int cmd, StructFlock arg) throws ErrnoException {
        addTaint(arg.getTaint());
        addTaint(cmd);
        addTaint(fd.getTaint());
        int varC51A438B6A3E80322EBABB17FBA3EE39_1425703385 = (os.fcntlFlock(fd, cmd, arg));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1151184267 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1151184267;
        // ---------- Original Method ----------
        //return os.fcntlFlock(fd, cmd, arg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.550 -0400", hash_original_method = "D2B4800A8551761D0A11CAE1762DA39E", hash_generated_method = "57861540BC1ED973DA07B22FF0F86AC8")
    public void fdatasync(FileDescriptor fd) throws ErrnoException {
        addTaint(fd.getTaint());
        os.fdatasync(fd);
        // ---------- Original Method ----------
        //os.fdatasync(fd);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.551 -0400", hash_original_method = "0159E8BC0EB89F7B9A8B0DA54E55E46B", hash_generated_method = "292C1C51CE23E9013C7403C2BFC8F5F0")
    public StructStat fstat(FileDescriptor fd) throws ErrnoException {
        addTaint(fd.getTaint());
StructStat varE56A0E1D81BA813D420E25A118C3BF89_494424155 =         os.fstat(fd);
        varE56A0E1D81BA813D420E25A118C3BF89_494424155.addTaint(taint);
        return varE56A0E1D81BA813D420E25A118C3BF89_494424155;
        // ---------- Original Method ----------
        //return os.fstat(fd);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.551 -0400", hash_original_method = "1D4670A49E88E5904763EEFCF378AA9C", hash_generated_method = "C099B559487D228C1BC74831C7453DE7")
    public StructStatFs fstatfs(FileDescriptor fd) throws ErrnoException {
        addTaint(fd.getTaint());
StructStatFs var4852AF1AB60ABCB5F55561CD74B51D75_370871861 =         os.fstatfs(fd);
        var4852AF1AB60ABCB5F55561CD74B51D75_370871861.addTaint(taint);
        return var4852AF1AB60ABCB5F55561CD74B51D75_370871861;
        // ---------- Original Method ----------
        //return os.fstatfs(fd);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.551 -0400", hash_original_method = "5A3103E0191F55AC2413EF7A293382EA", hash_generated_method = "6A2EE843B3FB0419BC5E5D33CCCADFE6")
    public void fsync(FileDescriptor fd) throws ErrnoException {
        addTaint(fd.getTaint());
        os.fsync(fd);
        // ---------- Original Method ----------
        //os.fsync(fd);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.552 -0400", hash_original_method = "B89F13DA07AD88D9E35FDD0F8C706602", hash_generated_method = "D2D3458FE0142CA569C9075ECBF9DD4D")
    public void ftruncate(FileDescriptor fd, long length) throws ErrnoException {
        addTaint(length);
        addTaint(fd.getTaint());
        os.ftruncate(fd, length);
        // ---------- Original Method ----------
        //os.ftruncate(fd, length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.552 -0400", hash_original_method = "4EDF3DB0839BDB5BB59D5BDCF6ED266B", hash_generated_method = "0DF3FB4BEB1500ED9E1C9BAB4102069E")
    public String gai_strerror(int error) {
        addTaint(error);
String var1A676D6EB28C23C605FF41F2AF93787C_859219473 =         os.gai_strerror(error);
        var1A676D6EB28C23C605FF41F2AF93787C_859219473.addTaint(taint);
        return var1A676D6EB28C23C605FF41F2AF93787C_859219473;
        // ---------- Original Method ----------
        //return os.gai_strerror(error);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.552 -0400", hash_original_method = "D134969B79309E2FFE6734562680F40F", hash_generated_method = "73FDE96D38327507258953EF1BDB78DB")
    public InetAddress[] getaddrinfo(String node, StructAddrinfo hints) throws GaiException {
        addTaint(hints.getTaint());
        addTaint(node.getTaint());
InetAddress[] var740CD4C878D078EA073D38DF14180AA4_226429426 =         os.getaddrinfo(node, hints);
        var740CD4C878D078EA073D38DF14180AA4_226429426.addTaint(taint);
        return var740CD4C878D078EA073D38DF14180AA4_226429426;
        // ---------- Original Method ----------
        //return os.getaddrinfo(node, hints);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.553 -0400", hash_original_method = "DA32E4A67BBB878517DC4C1F6AD2DE47", hash_generated_method = "DBF30CE346422104AD4A7F910A06A10E")
    public int getegid() {
        int varD3DDD791E3B9818D6D9AAA818D409680_2034603419 = (os.getegid());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1810991687 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1810991687;
        // ---------- Original Method ----------
        //return os.getegid();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.553 -0400", hash_original_method = "FAD72A6DE2CC7E2DB1B9B6FC41642D5B", hash_generated_method = "7F9E85A02B67BDDF18AA6E9469E31590")
    public int geteuid() {
        int var8ACA055E841336581E8124997CB929F0_1511353072 = (os.geteuid());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1125096882 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1125096882;
        // ---------- Original Method ----------
        //return os.geteuid();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.553 -0400", hash_original_method = "FADA5B6063E47C208AC2D0843F6EB847", hash_generated_method = "D08E1E7CE43525834D67F3EC8FB7A3EE")
    public int getgid() {
        int varEFFC043516AADF9323B0F00E84602B8A_250370069 = (os.getgid());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1805651550 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1805651550;
        // ---------- Original Method ----------
        //return os.getgid();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.553 -0400", hash_original_method = "E4B66B682B354EFDCC2A2307B9973162", hash_generated_method = "C55D589200E564666BF66CEECB6B0BE3")
    public String getenv(String name) {
        addTaint(name.getTaint());
String varB8D29798741A3C7F5BF1B240675D23EC_521485375 =         os.getenv(name);
        varB8D29798741A3C7F5BF1B240675D23EC_521485375.addTaint(taint);
        return varB8D29798741A3C7F5BF1B240675D23EC_521485375;
        // ---------- Original Method ----------
        //return os.getenv(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.554 -0400", hash_original_method = "95C6CCF446FE941364E9F3FC808640B5", hash_generated_method = "A93050C3FAC1923F6C043773C921F9E1")
    public String getnameinfo(InetAddress address, int flags) throws GaiException {
        addTaint(flags);
        addTaint(address.getTaint());
String var5E6BD842B2EC751BA2EFD8A767AF25B0_1824235875 =         os.getnameinfo(address, flags);
        var5E6BD842B2EC751BA2EFD8A767AF25B0_1824235875.addTaint(taint);
        return var5E6BD842B2EC751BA2EFD8A767AF25B0_1824235875;
        // ---------- Original Method ----------
        //return os.getnameinfo(address, flags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.554 -0400", hash_original_method = "A3B371C9A268817901795576D0A04CF6", hash_generated_method = "F365DE0A337CC24C30323F815475A6F8")
    public int getpid() {
        int varBD652AAA094ADCAFCA34624ADE8B6B42_1404231723 = (os.getpid());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_865081886 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_865081886;
        // ---------- Original Method ----------
        //return os.getpid();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.554 -0400", hash_original_method = "878D1FDE3DC9E3A460294EB2A78F5342", hash_generated_method = "F6A7E94FE81CB4DF24B39360CEF87EA0")
    public int getppid() {
        int varC8821EB47893FD7A2253872918CA61D3_1580483107 = (os.getppid());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1792022090 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1792022090;
        // ---------- Original Method ----------
        //return os.getppid();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.555 -0400", hash_original_method = "A3C50DDCB01897A6F2E46FE623EA65A2", hash_generated_method = "B446959FBE0F8CB480DBCF0988309D6F")
    public StructPasswd getpwnam(String name) throws ErrnoException {
        addTaint(name.getTaint());
StructPasswd var15CF71F6AA18DFA6E0D567A6EB2FF135_95341413 =         os.getpwnam(name);
        var15CF71F6AA18DFA6E0D567A6EB2FF135_95341413.addTaint(taint);
        return var15CF71F6AA18DFA6E0D567A6EB2FF135_95341413;
        // ---------- Original Method ----------
        //return os.getpwnam(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.555 -0400", hash_original_method = "F069BDB68A1BE69C49E58A44BE7A4944", hash_generated_method = "19E46A8103495FCBD03B3C59DE1BDD2F")
    public StructPasswd getpwuid(int uid) throws ErrnoException {
        addTaint(uid);
StructPasswd varF1FFADC007699FC5886376B578C443BA_1492950450 =         os.getpwuid(uid);
        varF1FFADC007699FC5886376B578C443BA_1492950450.addTaint(taint);
        return varF1FFADC007699FC5886376B578C443BA_1492950450;
        // ---------- Original Method ----------
        //return os.getpwuid(uid);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.555 -0400", hash_original_method = "C71AB83C8CB24831B3B392DF1EFA2A55", hash_generated_method = "698651961DFFE8B544F95AE2A49BAD8D")
    public SocketAddress getsockname(FileDescriptor fd) throws ErrnoException {
        addTaint(fd.getTaint());
SocketAddress var9FA8DDD00CD636DC6E093CBFEE8BB7B4_1974487857 =         os.getsockname(fd);
        var9FA8DDD00CD636DC6E093CBFEE8BB7B4_1974487857.addTaint(taint);
        return var9FA8DDD00CD636DC6E093CBFEE8BB7B4_1974487857;
        // ---------- Original Method ----------
        //return os.getsockname(fd);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.556 -0400", hash_original_method = "E5D66E4A2B17F99E78F6B2E97C4D0018", hash_generated_method = "97B387B86B5E7A9FCA2105ECAC64AC74")
    public int getsockoptByte(FileDescriptor fd, int level, int option) throws ErrnoException {
        addTaint(option);
        addTaint(level);
        addTaint(fd.getTaint());
        int var038C3086A7CE54819B6D4606DE432F88_1080862587 = (os.getsockoptByte(fd, level, option));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1398493762 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1398493762;
        // ---------- Original Method ----------
        //return os.getsockoptByte(fd, level, option);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.556 -0400", hash_original_method = "0CBF6F7E2BE2FF171C45C7BCFC831012", hash_generated_method = "738562D042A884A8E164B4B8B1A539DF")
    public InetAddress getsockoptInAddr(FileDescriptor fd, int level, int option) throws ErrnoException {
        addTaint(option);
        addTaint(level);
        addTaint(fd.getTaint());
InetAddress var9200B36BD92F4EFF190C70A41427EDDD_1325807752 =         os.getsockoptInAddr(fd, level, option);
        var9200B36BD92F4EFF190C70A41427EDDD_1325807752.addTaint(taint);
        return var9200B36BD92F4EFF190C70A41427EDDD_1325807752;
        // ---------- Original Method ----------
        //return os.getsockoptInAddr(fd, level, option);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.556 -0400", hash_original_method = "946A87B9C2E87F4C961C36C4569A31BA", hash_generated_method = "05948FC34A48C205CF9F26224C51291A")
    public int getsockoptInt(FileDescriptor fd, int level, int option) throws ErrnoException {
        addTaint(option);
        addTaint(level);
        addTaint(fd.getTaint());
        int var499898D1A8801BCC58E96E5A6C9378FE_711830425 = (os.getsockoptInt(fd, level, option));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1013949039 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1013949039;
        // ---------- Original Method ----------
        //return os.getsockoptInt(fd, level, option);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.557 -0400", hash_original_method = "EBD2988D937DD58B5AD9697AEE85A0FB", hash_generated_method = "0F4186D27297D756E71A047151416BCA")
    public StructLinger getsockoptLinger(FileDescriptor fd, int level, int option) throws ErrnoException {
        addTaint(option);
        addTaint(level);
        addTaint(fd.getTaint());
StructLinger var9B3F6FEEB3CA102B1233EA407FC83A06_1076478252 =         os.getsockoptLinger(fd, level, option);
        var9B3F6FEEB3CA102B1233EA407FC83A06_1076478252.addTaint(taint);
        return var9B3F6FEEB3CA102B1233EA407FC83A06_1076478252;
        // ---------- Original Method ----------
        //return os.getsockoptLinger(fd, level, option);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.557 -0400", hash_original_method = "1C478D9E653EA1E4A0CA2442FA9E2156", hash_generated_method = "DE19C3DDCBAD2B8C496D4152251E0250")
    public StructTimeval getsockoptTimeval(FileDescriptor fd, int level, int option) throws ErrnoException {
        addTaint(option);
        addTaint(level);
        addTaint(fd.getTaint());
StructTimeval varE79BC9D50FB7F1E53B90E9D7732394D3_674824322 =         os.getsockoptTimeval(fd, level, option);
        varE79BC9D50FB7F1E53B90E9D7732394D3_674824322.addTaint(taint);
        return varE79BC9D50FB7F1E53B90E9D7732394D3_674824322;
        // ---------- Original Method ----------
        //return os.getsockoptTimeval(fd, level, option);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.557 -0400", hash_original_method = "2F11239B76600858937301E80656F86F", hash_generated_method = "1E5743FE9EB69AA80D8A6E4D2D58B6E9")
    public int getuid() {
        int var83381C94B0E274AEEC790EBC352F8EED_87150608 = (os.getuid());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_384518496 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_384518496;
        // ---------- Original Method ----------
        //return os.getuid();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.558 -0400", hash_original_method = "FD1CFE447DC743FEF7DD120355028D01", hash_generated_method = "9A50F9243635F5B770554EC171D61374")
    public String if_indextoname(int index) {
        addTaint(index);
String var04A8D1185ACC1CEA933C80A63F9456B4_2003568038 =         os.if_indextoname(index);
        var04A8D1185ACC1CEA933C80A63F9456B4_2003568038.addTaint(taint);
        return var04A8D1185ACC1CEA933C80A63F9456B4_2003568038;
        // ---------- Original Method ----------
        //return os.if_indextoname(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.558 -0400", hash_original_method = "244F6B5FD78AC80358A10468727F943C", hash_generated_method = "BFDBAFDAA4E24A59D6FD627D41C7FF68")
    public InetAddress inet_pton(int family, String address) {
        addTaint(address.getTaint());
        addTaint(family);
InetAddress var8437D7F647FCBE2B3C0CC43AAC1E9824_664937100 =         os.inet_pton(family, address);
        var8437D7F647FCBE2B3C0CC43AAC1E9824_664937100.addTaint(taint);
        return var8437D7F647FCBE2B3C0CC43AAC1E9824_664937100;
        // ---------- Original Method ----------
        //return os.inet_pton(family, address);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.558 -0400", hash_original_method = "81C548F366545C14DF26B9A5D253BEA5", hash_generated_method = "C4D26E39BA0E8A7E703CC183EE2D1178")
    public InetAddress ioctlInetAddress(FileDescriptor fd, int cmd, String interfaceName) throws ErrnoException {
        addTaint(interfaceName.getTaint());
        addTaint(cmd);
        addTaint(fd.getTaint());
InetAddress var369337E903CB9434A5702027B369AE40_607650349 =         os.ioctlInetAddress(fd, cmd, interfaceName);
        var369337E903CB9434A5702027B369AE40_607650349.addTaint(taint);
        return var369337E903CB9434A5702027B369AE40_607650349;
        // ---------- Original Method ----------
        //return os.ioctlInetAddress(fd, cmd, interfaceName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.559 -0400", hash_original_method = "B9A716BFE88006BFE54885EB5B40EF6E", hash_generated_method = "153EAB20C7BB245104B056B234C39622")
    public int ioctlInt(FileDescriptor fd, int cmd, MutableInt arg) throws ErrnoException {
        addTaint(arg.getTaint());
        addTaint(cmd);
        addTaint(fd.getTaint());
        int varA9CCCA2581F530D4B26AA6A54BB354B5_1818616956 = (os.ioctlInt(fd, cmd, arg));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_270373995 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_270373995;
        // ---------- Original Method ----------
        //return os.ioctlInt(fd, cmd, arg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.559 -0400", hash_original_method = "E622E0FA602C62724E493B1B03996EEA", hash_generated_method = "7563C90AC4390111AC262374FABA9970")
    public boolean isatty(FileDescriptor fd) {
        addTaint(fd.getTaint());
        boolean var6CBA868D125ACB9BCBBBFF1D9E51A2F9_1583046564 = (os.isatty(fd));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_351833031 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_351833031;
        // ---------- Original Method ----------
        //return os.isatty(fd);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.559 -0400", hash_original_method = "39C5C221EF1E81F6FE3B9410463D5E57", hash_generated_method = "DBEAE047D45BD548015B1999EC5BB4F3")
    public void kill(int pid, int signal) throws ErrnoException {
        addTaint(signal);
        addTaint(pid);
        os.kill(pid, signal);
        // ---------- Original Method ----------
        //os.kill(pid, signal);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.560 -0400", hash_original_method = "039EEA76B9DC6E04921BFC5BC270EDD9", hash_generated_method = "E3C17DDBDA40BFB08F346B4FA5DC6FE6")
    public void listen(FileDescriptor fd, int backlog) throws ErrnoException {
        addTaint(backlog);
        addTaint(fd.getTaint());
        os.listen(fd, backlog);
        // ---------- Original Method ----------
        //os.listen(fd, backlog);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.560 -0400", hash_original_method = "3005A45BFDFB73561B6BABAEF57B12E1", hash_generated_method = "842F739D29C0F610AF7A52D54A9E4CE1")
    public long lseek(FileDescriptor fd, long offset, int whence) throws ErrnoException {
        addTaint(whence);
        addTaint(offset);
        addTaint(fd.getTaint());
        long var6DC67B24B81A58F45C38A7900BEDE1D7_1472806780 = (os.lseek(fd, offset, whence));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_640854985 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_640854985;
        // ---------- Original Method ----------
        //return os.lseek(fd, offset, whence);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.560 -0400", hash_original_method = "F288030A10BA391FE6D7AD19552493B8", hash_generated_method = "B38D31E3225D976241701D8B1AD17921")
    public StructStat lstat(String path) throws ErrnoException {
        addTaint(path.getTaint());
StructStat var38A6E6D3DD9B1473AD66E831812A3A1C_715206049 =         os.lstat(path);
        var38A6E6D3DD9B1473AD66E831812A3A1C_715206049.addTaint(taint);
        return var38A6E6D3DD9B1473AD66E831812A3A1C_715206049;
        // ---------- Original Method ----------
        //return os.lstat(path);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.561 -0400", hash_original_method = "0D8D349CD4EFD867777AD4E59116610D", hash_generated_method = "3312DFF07AA3A26C73F78DC853472D9A")
    public void mincore(long address, long byteCount, byte[] vector) throws ErrnoException {
        addTaint(vector[0]);
        addTaint(byteCount);
        addTaint(address);
        os.mincore(address, byteCount, vector);
        // ---------- Original Method ----------
        //os.mincore(address, byteCount, vector);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.561 -0400", hash_original_method = "689C229BD7F4B7F5308857A16DB04D8E", hash_generated_method = "FDE79479BA876DE1900765ED46A43059")
    public void mkdir(String path, int mode) throws ErrnoException {
        addTaint(mode);
        addTaint(path.getTaint());
        os.mkdir(path, mode);
        // ---------- Original Method ----------
        //os.mkdir(path, mode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.561 -0400", hash_original_method = "419517122697B0628E53EB3E2B0A6370", hash_generated_method = "83C91E3E741A7504E34436A563F7F9AA")
    public void mlock(long address, long byteCount) throws ErrnoException {
        addTaint(byteCount);
        addTaint(address);
        os.mlock(address, byteCount);
        // ---------- Original Method ----------
        //os.mlock(address, byteCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.562 -0400", hash_original_method = "4029BCDA0489C716FD1384F50323A029", hash_generated_method = "EEC24F10214F3D06F44A43D42F3F51CA")
    public long mmap(long address, long byteCount, int prot, int flags, FileDescriptor fd, long offset) throws ErrnoException {
        addTaint(offset);
        addTaint(fd.getTaint());
        addTaint(flags);
        addTaint(prot);
        addTaint(byteCount);
        addTaint(address);
        long varAD502B1FF470D8DAF5CA95BC0912EE8E_1426614452 = (os.mmap(address, byteCount, prot, flags, fd, offset));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1867255375 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1867255375;
        // ---------- Original Method ----------
        //return os.mmap(address, byteCount, prot, flags, fd, offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.562 -0400", hash_original_method = "26058ECBCE0A88D4B8D4418B78F705C5", hash_generated_method = "849EB539834F4BEBB8F9E7448A639AA4")
    public void msync(long address, long byteCount, int flags) throws ErrnoException {
        addTaint(flags);
        addTaint(byteCount);
        addTaint(address);
        os.msync(address, byteCount, flags);
        // ---------- Original Method ----------
        //os.msync(address, byteCount, flags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.563 -0400", hash_original_method = "12F3B374B5C7D041381B26987EDF7BE8", hash_generated_method = "4163D5EA3CE24B5E4F1E63F074AD5BC7")
    public void munlock(long address, long byteCount) throws ErrnoException {
        addTaint(byteCount);
        addTaint(address);
        os.munlock(address, byteCount);
        // ---------- Original Method ----------
        //os.munlock(address, byteCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.563 -0400", hash_original_method = "93EF25630433342C6922044F58653EDA", hash_generated_method = "3A8128766C72AF23753CEFA003FBBA2A")
    public void munmap(long address, long byteCount) throws ErrnoException {
        addTaint(byteCount);
        addTaint(address);
        os.munmap(address, byteCount);
        // ---------- Original Method ----------
        //os.munmap(address, byteCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.564 -0400", hash_original_method = "3A1C8AE14DFE6F094F17065084A852DA", hash_generated_method = "02BB6944F8F9B7E45C09C518D5A7F23A")
    public FileDescriptor open(String path, int flags, int mode) throws ErrnoException {
        addTaint(mode);
        addTaint(flags);
        addTaint(path.getTaint());
FileDescriptor var39B89F4C81D0661C45D0F28BA8EB3A2E_948148490 =         os.open(path, flags, mode);
        var39B89F4C81D0661C45D0F28BA8EB3A2E_948148490.addTaint(taint);
        return var39B89F4C81D0661C45D0F28BA8EB3A2E_948148490;
        // ---------- Original Method ----------
        //return os.open(path, flags, mode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.564 -0400", hash_original_method = "C44D806183F8681F84B21225E3DD2820", hash_generated_method = "1B19413A1173559828157FF5D5067A25")
    public FileDescriptor[] pipe() throws ErrnoException {
FileDescriptor[] varEC459D4EC842CD610D05C93AF9916DD8_1433995384 =         os.pipe();
        varEC459D4EC842CD610D05C93AF9916DD8_1433995384.addTaint(taint);
        return varEC459D4EC842CD610D05C93AF9916DD8_1433995384;
        // ---------- Original Method ----------
        //return os.pipe();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.564 -0400", hash_original_method = "5599B9E106312A6343AFDB459C1296E6", hash_generated_method = "3E46FE1C4111E3DA03339A8964709812")
    public int poll(StructPollfd[] fds, int timeoutMs) throws ErrnoException {
        addTaint(timeoutMs);
        addTaint(fds[0].getTaint());
        int var222980D2507B3788FA6BCF34461C7D94_1796678227 = (os.poll(fds, timeoutMs));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1880701820 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1880701820;
        // ---------- Original Method ----------
        //return os.poll(fds, timeoutMs);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.565 -0400", hash_original_method = "E02E4577E71F70F2C9CAE7AED1E2F8AC", hash_generated_method = "C260D4A411D55B02FCEB3D3411063AE1")
    public int pread(FileDescriptor fd, ByteBuffer buffer, long offset) throws ErrnoException {
        addTaint(offset);
        addTaint(buffer.getTaint());
        addTaint(fd.getTaint());
        int varDE15DBE284FB6126AA45A8BF58915EDD_1335271200 = (os.pread(fd, buffer, offset));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1966096065 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1966096065;
        // ---------- Original Method ----------
        //return os.pread(fd, buffer, offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.565 -0400", hash_original_method = "77B89AD0CF3C5D71E7DD42E992F283EF", hash_generated_method = "3A2D7F45EDE451991EB068DAECC99AB6")
    public int pread(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount, long offset) throws ErrnoException {
        addTaint(offset);
        addTaint(byteCount);
        addTaint(byteOffset);
        addTaint(bytes[0]);
        addTaint(fd.getTaint());
        int varE3DF49A276F761267024E03A73F20DEB_745816166 = (os.pread(fd, bytes, byteOffset, byteCount, offset));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2112913400 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2112913400;
        // ---------- Original Method ----------
        //return os.pread(fd, bytes, byteOffset, byteCount, offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.566 -0400", hash_original_method = "1CD5001FEE779ACE9E3DB9100CD609FC", hash_generated_method = "D478AD92B9A5AE2671662F29CAA8B208")
    public int pwrite(FileDescriptor fd, ByteBuffer buffer, long offset) throws ErrnoException {
        addTaint(offset);
        addTaint(buffer.getTaint());
        addTaint(fd.getTaint());
        int varFCCAEB3AF4EC4F5C5FFFA4B4BD20FF50_995472959 = (os.pwrite(fd, buffer, offset));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_632450187 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_632450187;
        // ---------- Original Method ----------
        //return os.pwrite(fd, buffer, offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.566 -0400", hash_original_method = "F0611566A9565E2DEF97709E6B9B6418", hash_generated_method = "A760231C5099AF37B94963E9AEDA7173")
    public int pwrite(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount, long offset) throws ErrnoException {
        addTaint(offset);
        addTaint(byteCount);
        addTaint(byteOffset);
        addTaint(bytes[0]);
        addTaint(fd.getTaint());
        int var6074C3BFC1FB418DF49AE75B35C3814B_862765585 = (os.pwrite(fd, bytes, byteOffset, byteCount, offset));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2138864289 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2138864289;
        // ---------- Original Method ----------
        //return os.pwrite(fd, bytes, byteOffset, byteCount, offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.566 -0400", hash_original_method = "F3C222630BE6E1046A8D40208CD4C60B", hash_generated_method = "74890A06E5FC3CFF6D8ACC0A1C51CAEA")
    public int read(FileDescriptor fd, ByteBuffer buffer) throws ErrnoException {
        addTaint(buffer.getTaint());
        addTaint(fd.getTaint());
        int var0150C7D03DEBCE79D9B842076877B65C_1673979960 = (os.read(fd, buffer));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_531318791 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_531318791;
        // ---------- Original Method ----------
        //return os.read(fd, buffer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.567 -0400", hash_original_method = "21F8B1ED0ECF46FDBCE6EA979BADF2C3", hash_generated_method = "8ECA0674E8FFDEE1CFA74190CF539390")
    public int read(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount) throws ErrnoException {
        addTaint(byteCount);
        addTaint(byteOffset);
        addTaint(bytes[0]);
        addTaint(fd.getTaint());
        int var1E40651C708F64B04B9DD67336B66EA0_1093698925 = (os.read(fd, bytes, byteOffset, byteCount));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_584715189 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_584715189;
        // ---------- Original Method ----------
        //return os.read(fd, bytes, byteOffset, byteCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.567 -0400", hash_original_method = "E2800F54CC6608A5FBBD1BF36223D806", hash_generated_method = "6A0E449CDB5B35FE66C603AF93DA1131")
    public int readv(FileDescriptor fd, Object[] buffers, int[] offsets, int[] byteCounts) throws ErrnoException {
        addTaint(byteCounts[0]);
        addTaint(offsets[0]);
        addTaint(buffers[0].getTaint());
        addTaint(fd.getTaint());
        int var9267859C7D3D2D2A030DB3D26AF801EF_480959637 = (os.readv(fd, buffers, offsets, byteCounts));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1447501221 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1447501221;
        // ---------- Original Method ----------
        //return os.readv(fd, buffers, offsets, byteCounts);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.568 -0400", hash_original_method = "84F37C132BD33033E9DE4E38A8430067", hash_generated_method = "733E296B0545B276B5C5551FD5B6A64F")
    public int recvfrom(FileDescriptor fd, ByteBuffer buffer, int flags, InetSocketAddress srcAddress) throws ErrnoException {
        addTaint(srcAddress.getTaint());
        addTaint(flags);
        addTaint(buffer.getTaint());
        addTaint(fd.getTaint());
        int var148C659D0B6FCF3CBC57A3D34F2DD492_972160595 = (os.recvfrom(fd, buffer, flags, srcAddress));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1159851591 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1159851591;
        // ---------- Original Method ----------
        //return os.recvfrom(fd, buffer, flags, srcAddress);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.568 -0400", hash_original_method = "0394D475125B49320B23E75594B5C434", hash_generated_method = "534B1CE9AC83E9D7095601051FA93FF4")
    public int recvfrom(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount, int flags, InetSocketAddress srcAddress) throws ErrnoException {
        addTaint(srcAddress.getTaint());
        addTaint(flags);
        addTaint(byteCount);
        addTaint(byteOffset);
        addTaint(bytes[0]);
        addTaint(fd.getTaint());
        int varE1EBC5E4A46203E8474950D1E43CBCA7_1107015604 = (os.recvfrom(fd, bytes, byteOffset, byteCount, flags, srcAddress));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_275514330 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_275514330;
        // ---------- Original Method ----------
        //return os.recvfrom(fd, bytes, byteOffset, byteCount, flags, srcAddress);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.569 -0400", hash_original_method = "B12B5B450AD1F25F30BAE5F7F0558752", hash_generated_method = "A2AF596065F4863638BADA3258FE20FB")
    public void remove(String path) throws ErrnoException {
        addTaint(path.getTaint());
        os.remove(path);
        // ---------- Original Method ----------
        //os.remove(path);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.569 -0400", hash_original_method = "91C997D77FC3A21A4E5692674F9BE11B", hash_generated_method = "A3D78614387CFF476F7AB25C53A394E1")
    public void rename(String oldPath, String newPath) throws ErrnoException {
        addTaint(newPath.getTaint());
        addTaint(oldPath.getTaint());
        os.rename(oldPath, newPath);
        // ---------- Original Method ----------
        //os.rename(oldPath, newPath);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.570 -0400", hash_original_method = "C572D6E07635A5094C687364A5671672", hash_generated_method = "1C6304D08B8390D6C8CE72AFF9742EF2")
    public long sendfile(FileDescriptor outFd, FileDescriptor inFd, MutableLong inOffset, long byteCount) throws ErrnoException {
        addTaint(byteCount);
        addTaint(inOffset.getTaint());
        addTaint(inFd.getTaint());
        addTaint(outFd.getTaint());
        long var1812BF08C3788EF7F17D6AB478E68882_1795937456 = (os.sendfile(outFd, inFd, inOffset, byteCount));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1846162467 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1846162467;
        // ---------- Original Method ----------
        //return os.sendfile(outFd, inFd, inOffset, byteCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.570 -0400", hash_original_method = "88066FF66E9BA638CFCEFABD2B423922", hash_generated_method = "98569CB24A8961F715B9352C89ECB8E5")
    public int sendto(FileDescriptor fd, ByteBuffer buffer, int flags, InetAddress inetAddress, int port) throws ErrnoException {
        addTaint(port);
        addTaint(inetAddress.getTaint());
        addTaint(flags);
        addTaint(buffer.getTaint());
        addTaint(fd.getTaint());
        int var74D30D6BF88A4023586B126D875357BC_647179124 = (os.sendto(fd, buffer, flags, inetAddress, port));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2135712683 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2135712683;
        // ---------- Original Method ----------
        //return os.sendto(fd, buffer, flags, inetAddress, port);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.571 -0400", hash_original_method = "BC2321A87F2222D5681A88900983F12D", hash_generated_method = "EB28648ED8BED813E8EDB237E8036975")
    public int sendto(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount, int flags, InetAddress inetAddress, int port) throws ErrnoException {
        addTaint(port);
        addTaint(inetAddress.getTaint());
        addTaint(flags);
        addTaint(byteCount);
        addTaint(byteOffset);
        addTaint(bytes[0]);
        addTaint(fd.getTaint());
        int var209FD29A1FDDAD7A53690DD257C173A4_1043367291 = (os.sendto(fd, bytes, byteOffset, byteCount, flags, inetAddress, port));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2140789915 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2140789915;
        // ---------- Original Method ----------
        //return os.sendto(fd, bytes, byteOffset, byteCount, flags, inetAddress, port);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.571 -0400", hash_original_method = "D0978EE2EC25CFB475F603941EE6E321", hash_generated_method = "73EB59B4B82964EE5164DA99C4A9AAD9")
    public void setegid(int egid) throws ErrnoException {
        addTaint(egid);
        os.setegid(egid);
        // ---------- Original Method ----------
        //os.setegid(egid);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.571 -0400", hash_original_method = "0B3E20A1D3AFC99676F4A67D4967A4C5", hash_generated_method = "AA89D269A9507B304F7A309D64973CFA")
    public void seteuid(int euid) throws ErrnoException {
        addTaint(euid);
        os.seteuid(euid);
        // ---------- Original Method ----------
        //os.seteuid(euid);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.571 -0400", hash_original_method = "5A836F22DA1ADF6236109717B09FFB11", hash_generated_method = "139B3B462DA900CAEE3A758724971844")
    public void setgid(int gid) throws ErrnoException {
        addTaint(gid);
        os.setgid(gid);
        // ---------- Original Method ----------
        //os.setgid(gid);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.572 -0400", hash_original_method = "02713B5D8B1D9FC1829D645D7EE01360", hash_generated_method = "7F777D07726B5D6D8879F52DDF278D7B")
    public void setsockoptByte(FileDescriptor fd, int level, int option, int value) throws ErrnoException {
        addTaint(value);
        addTaint(option);
        addTaint(level);
        addTaint(fd.getTaint());
        os.setsockoptByte(fd, level, option, value);
        // ---------- Original Method ----------
        //os.setsockoptByte(fd, level, option, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.572 -0400", hash_original_method = "859AD73B12F1FCBFB785F9C03E57780C", hash_generated_method = "81FB9024630BF8C9092B1D2283ED099D")
    public void setsockoptIfreq(FileDescriptor fd, int level, int option, String value) throws ErrnoException {
        addTaint(value.getTaint());
        addTaint(option);
        addTaint(level);
        addTaint(fd.getTaint());
        os.setsockoptIfreq(fd, level, option, value);
        // ---------- Original Method ----------
        //os.setsockoptIfreq(fd, level, option, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.573 -0400", hash_original_method = "5882A7C612198E8B1D9CBF2EDBCD6FE7", hash_generated_method = "2FE544B7D9BE400A9DFFC169C6E6F679")
    public void setsockoptInt(FileDescriptor fd, int level, int option, int value) throws ErrnoException {
        addTaint(value);
        addTaint(option);
        addTaint(level);
        addTaint(fd.getTaint());
        os.setsockoptInt(fd, level, option, value);
        // ---------- Original Method ----------
        //os.setsockoptInt(fd, level, option, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.573 -0400", hash_original_method = "3A8741E8D07270D7E757C05217AEFD39", hash_generated_method = "67B90734BC70B2A457E819F377C35BDB")
    public void setsockoptIpMreqn(FileDescriptor fd, int level, int option, int value) throws ErrnoException {
        addTaint(value);
        addTaint(option);
        addTaint(level);
        addTaint(fd.getTaint());
        os.setsockoptIpMreqn(fd, level, option, value);
        // ---------- Original Method ----------
        //os.setsockoptIpMreqn(fd, level, option, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.574 -0400", hash_original_method = "4E1D080A99B5B2F06B7A0201A27B3E99", hash_generated_method = "FC4FA57FD209D765010EA8272F6F05A8")
    public void setsockoptGroupReq(FileDescriptor fd, int level, int option, StructGroupReq value) throws ErrnoException {
        addTaint(value.getTaint());
        addTaint(option);
        addTaint(level);
        addTaint(fd.getTaint());
        os.setsockoptGroupReq(fd, level, option, value);
        // ---------- Original Method ----------
        //os.setsockoptGroupReq(fd, level, option, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.574 -0400", hash_original_method = "A1EC25C1EA10D3E94DA65D129945BE62", hash_generated_method = "B8343AC32F7CD518D485EB1CE993C74E")
    public void setsockoptLinger(FileDescriptor fd, int level, int option, StructLinger value) throws ErrnoException {
        addTaint(value.getTaint());
        addTaint(option);
        addTaint(level);
        addTaint(fd.getTaint());
        os.setsockoptLinger(fd, level, option, value);
        // ---------- Original Method ----------
        //os.setsockoptLinger(fd, level, option, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.574 -0400", hash_original_method = "B0DC8E18521874709C24B9B37D89D87C", hash_generated_method = "9F838644C701DCC67578DF6678E073CD")
    public void setsockoptTimeval(FileDescriptor fd, int level, int option, StructTimeval value) throws ErrnoException {
        addTaint(value.getTaint());
        addTaint(option);
        addTaint(level);
        addTaint(fd.getTaint());
        os.setsockoptTimeval(fd, level, option, value);
        // ---------- Original Method ----------
        //os.setsockoptTimeval(fd, level, option, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.575 -0400", hash_original_method = "554251AE1D031EE7BA07BC4F696C724A", hash_generated_method = "56CBA76A30E42350BA3BE1E4AC7DC5E9")
    public void setuid(int uid) throws ErrnoException {
        addTaint(uid);
        os.setuid(uid);
        // ---------- Original Method ----------
        //os.setuid(uid);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.575 -0400", hash_original_method = "5FEB3BBC8A3C8F5F8A22DE81B35CAE4D", hash_generated_method = "0F1B1EC2C5AD25385828438ADB273DA4")
    public void shutdown(FileDescriptor fd, int how) throws ErrnoException {
        addTaint(how);
        addTaint(fd.getTaint());
        os.shutdown(fd, how);
        // ---------- Original Method ----------
        //os.shutdown(fd, how);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.576 -0400", hash_original_method = "558F533484D6B9C99DDFE653A920693C", hash_generated_method = "DCDB88AB00F62D6D6A45D6B12EC528EF")
    public FileDescriptor socket(int domain, int type, int protocol) throws ErrnoException {
        addTaint(protocol);
        addTaint(type);
        addTaint(domain);
FileDescriptor varBB6D27D4C0141475D04EE8C4DDC3FDF5_6542536 =         os.socket(domain, type, protocol);
        varBB6D27D4C0141475D04EE8C4DDC3FDF5_6542536.addTaint(taint);
        return varBB6D27D4C0141475D04EE8C4DDC3FDF5_6542536;
        // ---------- Original Method ----------
        //return os.socket(domain, type, protocol);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.576 -0400", hash_original_method = "E3FE6B0CE9C868055585C77F475D7F5A", hash_generated_method = "707B30317E562DF68F056CC3351443B4")
    public StructStat stat(String path) throws ErrnoException {
        addTaint(path.getTaint());
StructStat var40E24BB1CA1E130E8D0A1C58D44C0F50_997547526 =         os.stat(path);
        var40E24BB1CA1E130E8D0A1C58D44C0F50_997547526.addTaint(taint);
        return var40E24BB1CA1E130E8D0A1C58D44C0F50_997547526;
        // ---------- Original Method ----------
        //return os.stat(path);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.576 -0400", hash_original_method = "EA8F2D89CBB0B8AF52F0D62C5DA4B5A0", hash_generated_method = "49B1995CA8209EC7C4E2AE5A805A7947")
    public StructStatFs statfs(String path) throws ErrnoException {
        addTaint(path.getTaint());
StructStatFs var88B9FED519C4C56BEFB7C111CBFE5FC7_610958978 =         os.statfs(path);
        var88B9FED519C4C56BEFB7C111CBFE5FC7_610958978.addTaint(taint);
        return var88B9FED519C4C56BEFB7C111CBFE5FC7_610958978;
        // ---------- Original Method ----------
        //return os.statfs(path);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.577 -0400", hash_original_method = "FBEAE456B3A3C776553B1F7E912CD6FB", hash_generated_method = "378FCE19BDE78333A2E06FF902E2CDBB")
    public String strerror(int errno) {
        addTaint(errno);
String var732FEF31C0B974955FA12C229A9ECCDE_2135895592 =         os.strerror(errno);
        var732FEF31C0B974955FA12C229A9ECCDE_2135895592.addTaint(taint);
        return var732FEF31C0B974955FA12C229A9ECCDE_2135895592;
        // ---------- Original Method ----------
        //return os.strerror(errno);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.577 -0400", hash_original_method = "FB4E2B29DA5C665C03E887C9C86A36A3", hash_generated_method = "E7853B01626990B5C306CE2B8479DE09")
    public void symlink(String oldPath, String newPath) throws ErrnoException {
        addTaint(newPath.getTaint());
        addTaint(oldPath.getTaint());
        os.symlink(oldPath, newPath);
        // ---------- Original Method ----------
        //os.symlink(oldPath, newPath);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.577 -0400", hash_original_method = "9239DE14FB7F01A1D647B884E3411551", hash_generated_method = "B0DC52768BF70493F5485481C6051193")
    public long sysconf(int name) {
        addTaint(name);
        long varFB026933EA51B070C257890322A8D489_628108649 = (os.sysconf(name));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1178494766 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1178494766;
        // ---------- Original Method ----------
        //return os.sysconf(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.578 -0400", hash_original_method = "E92B0E3CCB7269FEE37854B5F086E530", hash_generated_method = "69F3D696756EDB280D7E5C607293D6B3")
    public StructUtsname uname() {
StructUtsname varB5D14CECEAA8EBC755C493954FACA078_1648610 =         os.uname();
        varB5D14CECEAA8EBC755C493954FACA078_1648610.addTaint(taint);
        return varB5D14CECEAA8EBC755C493954FACA078_1648610;
        // ---------- Original Method ----------
        //return os.uname();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.578 -0400", hash_original_method = "EC4C2322F336992223E3CB1B21022BF9", hash_generated_method = "0FCB5C5E54336018E6503697FA088269")
    public int waitpid(int pid, MutableInt status, int options) throws ErrnoException {
        addTaint(options);
        addTaint(status.getTaint());
        addTaint(pid);
        int var4A2915882C1189F74F1F05DACCE657B1_1413965297 = (os.waitpid(pid, status, options));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1579066432 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1579066432;
        // ---------- Original Method ----------
        //return os.waitpid(pid, status, options);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.578 -0400", hash_original_method = "844A22BF74026B79E5C643696D2A0D2B", hash_generated_method = "3E9907A7C6958B9500FA8FB37FD2D39A")
    public int write(FileDescriptor fd, ByteBuffer buffer) throws ErrnoException {
        addTaint(buffer.getTaint());
        addTaint(fd.getTaint());
        int var14D74F75C9BD675ED0875C35081834D8_1761624945 = (os.write(fd, buffer));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1401420149 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1401420149;
        // ---------- Original Method ----------
        //return os.write(fd, buffer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.579 -0400", hash_original_method = "437BEB04F87A5AE656D8F235B16E36DF", hash_generated_method = "0BA7EA8789967B2A9CB09BD05C4CA6C3")
    public int write(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount) throws ErrnoException {
        addTaint(byteCount);
        addTaint(byteOffset);
        addTaint(bytes[0]);
        addTaint(fd.getTaint());
        int var21A8634C3DEBC7316061A81665E91499_1119402427 = (os.write(fd, bytes, byteOffset, byteCount));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_798919160 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_798919160;
        // ---------- Original Method ----------
        //return os.write(fd, bytes, byteOffset, byteCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.579 -0400", hash_original_method = "8BC1FDC02B601F3DB4DB2A70967C7CDC", hash_generated_method = "A1DC320144A2426685C03E378D341197")
    public int writev(FileDescriptor fd, Object[] buffers, int[] offsets, int[] byteCounts) throws ErrnoException {
        addTaint(byteCounts[0]);
        addTaint(offsets[0]);
        addTaint(buffers[0].getTaint());
        addTaint(fd.getTaint());
        int varCCE8841716556A5168B85B70CE6AC0C2_1086554735 = (os.writev(fd, buffers, offsets, byteCounts));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1668803616 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1668803616;
        // ---------- Original Method ----------
        //return os.writev(fd, buffers, offsets, byteCounts);
    }

    
}

