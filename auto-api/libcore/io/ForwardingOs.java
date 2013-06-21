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
    protected Os os;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.873 -0400", hash_original_method = "EC37328A0FF4DE634029572AA03E9806", hash_generated_method = "90273C8C6906D8236E966E58DA621F53")
    @DSModeled(DSC.SAFE)
    public ForwardingOs(Os os) {
        dsTaint.addTaint(os.dsTaint);
        // ---------- Original Method ----------
        //this.os = os;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.873 -0400", hash_original_method = "5CF5B545FE52A5A749C69E4804E7DB37", hash_generated_method = "16F14074596A4A0915A2C5AC5D487A86")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public FileDescriptor accept(FileDescriptor fd, InetSocketAddress peerAddress) throws ErrnoException {
        dsTaint.addTaint(peerAddress.dsTaint);
        dsTaint.addTaint(fd.dsTaint);
        FileDescriptor var52381496BF4ACAA1C4A7105000C656C2_1159265915 = (os.accept(fd, peerAddress));
        return (FileDescriptor)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return os.accept(fd, peerAddress);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.873 -0400", hash_original_method = "FFD94E7AFE1E3B1F76A2D696707B6857", hash_generated_method = "DDBD91AD1F5B4A4CC49227FFA264D27F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean access(String path, int mode) throws ErrnoException {
        dsTaint.addTaint(path);
        dsTaint.addTaint(mode);
        boolean var172DEC5DD37258CD490DDB56CA7E2DB8_47593308 = (os.access(path, mode));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return os.access(path, mode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.874 -0400", hash_original_method = "743422D2EB39F172C4245C8DC993624F", hash_generated_method = "C9EE4C78816922C9C185721ED6CCADAD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void bind(FileDescriptor fd, InetAddress address, int port) throws ErrnoException {
        dsTaint.addTaint(port);
        dsTaint.addTaint(address.dsTaint);
        dsTaint.addTaint(fd.dsTaint);
        os.bind(fd, address, port);
        // ---------- Original Method ----------
        //os.bind(fd, address, port);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.874 -0400", hash_original_method = "A92F7B75A5B2B90071388C67FA677A74", hash_generated_method = "760B5AB48771724ADFA90F2D789015D5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void chmod(String path, int mode) throws ErrnoException {
        dsTaint.addTaint(path);
        dsTaint.addTaint(mode);
        os.chmod(path, mode);
        // ---------- Original Method ----------
        //os.chmod(path, mode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.874 -0400", hash_original_method = "2AF652D8862D637B4A4051CAB7CD62FB", hash_generated_method = "4B552659D76179213B0A5249630C8C5C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void close(FileDescriptor fd) throws ErrnoException {
        dsTaint.addTaint(fd.dsTaint);
        os.close(fd);
        // ---------- Original Method ----------
        //os.close(fd);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.874 -0400", hash_original_method = "FADD460EF8DBCF58AF836CFAB2496AF1", hash_generated_method = "BF71CE2406E8F9099EB262FD8CF9E52D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void connect(FileDescriptor fd, InetAddress address, int port) throws ErrnoException {
        dsTaint.addTaint(port);
        dsTaint.addTaint(address.dsTaint);
        dsTaint.addTaint(fd.dsTaint);
        os.connect(fd, address, port);
        // ---------- Original Method ----------
        //os.connect(fd, address, port);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.874 -0400", hash_original_method = "6162F8350974235CF8AA9EBE9F68335F", hash_generated_method = "DE2B2627530D7D84BB8A59F89579A5AE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public FileDescriptor dup(FileDescriptor oldFd) throws ErrnoException {
        dsTaint.addTaint(oldFd.dsTaint);
        FileDescriptor varA51C8E1D925AFE4266599C1C020CB3B5_275670943 = (os.dup(oldFd));
        return (FileDescriptor)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return os.dup(oldFd);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.874 -0400", hash_original_method = "E190E2A3CFD75C84461AB90FFE03369B", hash_generated_method = "272D51A3D71D09AB334326153F71F25A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public FileDescriptor dup2(FileDescriptor oldFd, int newFd) throws ErrnoException {
        dsTaint.addTaint(oldFd.dsTaint);
        dsTaint.addTaint(newFd);
        FileDescriptor varDB21CB8D0A61C622EE2608CF023F0507_1558702857 = (os.dup2(oldFd, newFd));
        return (FileDescriptor)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return os.dup2(oldFd, newFd);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.875 -0400", hash_original_method = "5CF51EBD75B5D23C7F632D7D494380D1", hash_generated_method = "D38D2ECA728FEBC7A4BC9DF44661EDA6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String[] environ() {
        String[] var46090EF2D0706D2557D6EF40064FED64_1548649629 = (os.environ());
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //return os.environ();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.875 -0400", hash_original_method = "CA43F47313D11741B7EE5D06954736CB", hash_generated_method = "DEB874B0C45E6E3011554952E69F0311")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int fcntlVoid(FileDescriptor fd, int cmd) throws ErrnoException {
        dsTaint.addTaint(cmd);
        dsTaint.addTaint(fd.dsTaint);
        int varBF1653E2CBDC0EBDA030B66FA450FCF0_106813793 = (os.fcntlVoid(fd, cmd));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return os.fcntlVoid(fd, cmd);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.875 -0400", hash_original_method = "6B248418A1B43AC8597DD680343F17BD", hash_generated_method = "73D87E60722014FE2346321EBFA53E59")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int fcntlLong(FileDescriptor fd, int cmd, long arg) throws ErrnoException {
        dsTaint.addTaint(arg);
        dsTaint.addTaint(cmd);
        dsTaint.addTaint(fd.dsTaint);
        int var97EF80FEE8D7DCAFEADBFC1210BDC18B_1535096103 = (os.fcntlLong(fd, cmd, arg));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return os.fcntlLong(fd, cmd, arg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.875 -0400", hash_original_method = "28B6741D270DBCC0BDA43B4FBA76C484", hash_generated_method = "0677E81004A9350CEB5945E53064237D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int fcntlFlock(FileDescriptor fd, int cmd, StructFlock arg) throws ErrnoException {
        dsTaint.addTaint(arg.dsTaint);
        dsTaint.addTaint(cmd);
        dsTaint.addTaint(fd.dsTaint);
        int var2729B8DD99A4FEEBABCEFB3EF912E159_1037780220 = (os.fcntlFlock(fd, cmd, arg));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return os.fcntlFlock(fd, cmd, arg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.875 -0400", hash_original_method = "D2B4800A8551761D0A11CAE1762DA39E", hash_generated_method = "9FF269551EF5CD462D8524DC462EEF91")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void fdatasync(FileDescriptor fd) throws ErrnoException {
        dsTaint.addTaint(fd.dsTaint);
        os.fdatasync(fd);
        // ---------- Original Method ----------
        //os.fdatasync(fd);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.875 -0400", hash_original_method = "0159E8BC0EB89F7B9A8B0DA54E55E46B", hash_generated_method = "FC2749DA0AEF8D8FD0981E99B99F0523")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StructStat fstat(FileDescriptor fd) throws ErrnoException {
        dsTaint.addTaint(fd.dsTaint);
        StructStat var2AA6A0BEA15C515AD22BC84FD0B2383F_418896254 = (os.fstat(fd));
        return (StructStat)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return os.fstat(fd);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.876 -0400", hash_original_method = "1D4670A49E88E5904763EEFCF378AA9C", hash_generated_method = "8154D6F7ACAFD3314B0D8B58C1E3CC5C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StructStatFs fstatfs(FileDescriptor fd) throws ErrnoException {
        dsTaint.addTaint(fd.dsTaint);
        StructStatFs var13468AECCFC5088BBD72EB8074FE64CE_1590656693 = (os.fstatfs(fd));
        return (StructStatFs)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return os.fstatfs(fd);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.876 -0400", hash_original_method = "5A3103E0191F55AC2413EF7A293382EA", hash_generated_method = "9F437C06973F31E2E95DC8C7B89D2DCC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void fsync(FileDescriptor fd) throws ErrnoException {
        dsTaint.addTaint(fd.dsTaint);
        os.fsync(fd);
        // ---------- Original Method ----------
        //os.fsync(fd);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.876 -0400", hash_original_method = "B89F13DA07AD88D9E35FDD0F8C706602", hash_generated_method = "8666CBB349187CF0F87405F3B0B21D9B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void ftruncate(FileDescriptor fd, long length) throws ErrnoException {
        dsTaint.addTaint(length);
        dsTaint.addTaint(fd.dsTaint);
        os.ftruncate(fd, length);
        // ---------- Original Method ----------
        //os.ftruncate(fd, length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.876 -0400", hash_original_method = "4EDF3DB0839BDB5BB59D5BDCF6ED266B", hash_generated_method = "F8B534CEA84B923DBD0E123C87906031")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String gai_strerror(int error) {
        dsTaint.addTaint(error);
        String var76E8E04355F1DEB887B45447F9369F00_483019603 = (os.gai_strerror(error));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return os.gai_strerror(error);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.876 -0400", hash_original_method = "D134969B79309E2FFE6734562680F40F", hash_generated_method = "C51377497FD9324FE82B31DBA7C47BA3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public InetAddress[] getaddrinfo(String node, StructAddrinfo hints) throws GaiException {
        dsTaint.addTaint(node);
        dsTaint.addTaint(hints.dsTaint);
        InetAddress[] varE5FA3D8553AFFBEB8FA61ABDC5E35524_1142798584 = (os.getaddrinfo(node, hints));
        return (InetAddress[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //return os.getaddrinfo(node, hints);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.876 -0400", hash_original_method = "DA32E4A67BBB878517DC4C1F6AD2DE47", hash_generated_method = "D9CECA3BD303E15A764313F8B7BC58EF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getegid() {
        int varD8065AE9128D4E02D412A3250EE4BEA6_1326472971 = (os.getegid());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return os.getegid();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.877 -0400", hash_original_method = "FAD72A6DE2CC7E2DB1B9B6FC41642D5B", hash_generated_method = "4E7451762EE0560DBAB83BA458384D56")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int geteuid() {
        int var56D743784E549DA0B7EA1F9C189A6471_149537123 = (os.geteuid());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return os.geteuid();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.877 -0400", hash_original_method = "FADA5B6063E47C208AC2D0843F6EB847", hash_generated_method = "3F3A71E386CD3D58C1863D5E671B486A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getgid() {
        int var6CADC2A35DC4D6A9A5A15CAB17B4B6E3_1258150257 = (os.getgid());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return os.getgid();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.877 -0400", hash_original_method = "E4B66B682B354EFDCC2A2307B9973162", hash_generated_method = "BB51BC3AEA108C988048AF0A7522A6E5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getenv(String name) {
        dsTaint.addTaint(name);
        String varEB458694A5BD2D943F509556171E08D0_1133130312 = (os.getenv(name));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return os.getenv(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.877 -0400", hash_original_method = "95C6CCF446FE941364E9F3FC808640B5", hash_generated_method = "181BAC8461459D0E8733E840D069D808")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getnameinfo(InetAddress address, int flags) throws GaiException {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(address.dsTaint);
        String var87EFA076F3594B726428803EB70EC74A_1110943839 = (os.getnameinfo(address, flags));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return os.getnameinfo(address, flags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.877 -0400", hash_original_method = "A3B371C9A268817901795576D0A04CF6", hash_generated_method = "E1BB3BCBB60663AB0745D10D3CD9E57D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getpid() {
        int var38AA61BF3E54239C4504A81A8746FA43_1277520688 = (os.getpid());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return os.getpid();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.877 -0400", hash_original_method = "878D1FDE3DC9E3A460294EB2A78F5342", hash_generated_method = "8D020997B739BA06D7027DDA55998376")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getppid() {
        int var1F662189AEACAB508948D811AFEC491B_1803669434 = (os.getppid());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return os.getppid();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.878 -0400", hash_original_method = "A3C50DDCB01897A6F2E46FE623EA65A2", hash_generated_method = "018B7A41A30BEED95AB5F29C05356367")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StructPasswd getpwnam(String name) throws ErrnoException {
        dsTaint.addTaint(name);
        StructPasswd var13918668EADC14B057546917C0EFE08E_1640096857 = (os.getpwnam(name));
        return (StructPasswd)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return os.getpwnam(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.878 -0400", hash_original_method = "F069BDB68A1BE69C49E58A44BE7A4944", hash_generated_method = "B6BD68A2B57A2CDF4DB07A9C88BED350")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StructPasswd getpwuid(int uid) throws ErrnoException {
        dsTaint.addTaint(uid);
        StructPasswd var63B521407D5A200B7FFCDF1C2A734596_1298499607 = (os.getpwuid(uid));
        return (StructPasswd)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return os.getpwuid(uid);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.878 -0400", hash_original_method = "C71AB83C8CB24831B3B392DF1EFA2A55", hash_generated_method = "45E4480D3BB3220F7AE0FED9E938BD93")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SocketAddress getsockname(FileDescriptor fd) throws ErrnoException {
        dsTaint.addTaint(fd.dsTaint);
        SocketAddress var3BBDC4612CC5F571D4749D008873BB99_1996623453 = (os.getsockname(fd));
        return (SocketAddress)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return os.getsockname(fd);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.878 -0400", hash_original_method = "E5D66E4A2B17F99E78F6B2E97C4D0018", hash_generated_method = "B462E12B90B35645B1A16CDA8FA718BE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getsockoptByte(FileDescriptor fd, int level, int option) throws ErrnoException {
        dsTaint.addTaint(level);
        dsTaint.addTaint(fd.dsTaint);
        dsTaint.addTaint(option);
        int var46B88F2A6E8AFD10C1C2A4CB4FA13847_1918101489 = (os.getsockoptByte(fd, level, option));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return os.getsockoptByte(fd, level, option);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.878 -0400", hash_original_method = "0CBF6F7E2BE2FF171C45C7BCFC831012", hash_generated_method = "333967812C8D206D8F31C41E16AD46CF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public InetAddress getsockoptInAddr(FileDescriptor fd, int level, int option) throws ErrnoException {
        dsTaint.addTaint(level);
        dsTaint.addTaint(fd.dsTaint);
        dsTaint.addTaint(option);
        InetAddress varB5A52377F61DE7EF503B5E4B4AA209D6_476601008 = (os.getsockoptInAddr(fd, level, option));
        return (InetAddress)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return os.getsockoptInAddr(fd, level, option);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.878 -0400", hash_original_method = "946A87B9C2E87F4C961C36C4569A31BA", hash_generated_method = "FB1686EFA835A036F86361DF947DE0D6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getsockoptInt(FileDescriptor fd, int level, int option) throws ErrnoException {
        dsTaint.addTaint(level);
        dsTaint.addTaint(fd.dsTaint);
        dsTaint.addTaint(option);
        int varE08D816983313FAA61DC4FC565C65ADD_714098479 = (os.getsockoptInt(fd, level, option));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return os.getsockoptInt(fd, level, option);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.879 -0400", hash_original_method = "EBD2988D937DD58B5AD9697AEE85A0FB", hash_generated_method = "2479BCB603C1672FF3798BBDBEFE4CC4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StructLinger getsockoptLinger(FileDescriptor fd, int level, int option) throws ErrnoException {
        dsTaint.addTaint(level);
        dsTaint.addTaint(fd.dsTaint);
        dsTaint.addTaint(option);
        StructLinger var0B1C0C03DE7BF63F72120C0EBCF19382_1870815435 = (os.getsockoptLinger(fd, level, option));
        return (StructLinger)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return os.getsockoptLinger(fd, level, option);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.879 -0400", hash_original_method = "1C478D9E653EA1E4A0CA2442FA9E2156", hash_generated_method = "45BA0D496B81E64982BE2C546CA682A6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StructTimeval getsockoptTimeval(FileDescriptor fd, int level, int option) throws ErrnoException {
        dsTaint.addTaint(level);
        dsTaint.addTaint(fd.dsTaint);
        dsTaint.addTaint(option);
        StructTimeval var8593D33B332C14C925B1899C65560994_1004793190 = (os.getsockoptTimeval(fd, level, option));
        return (StructTimeval)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return os.getsockoptTimeval(fd, level, option);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.879 -0400", hash_original_method = "2F11239B76600858937301E80656F86F", hash_generated_method = "DF2360252792D5D7F545A5702785A9EE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getuid() {
        int var6E1C401E18C533CAAAF3A5BDCCAC0B20_431671903 = (os.getuid());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return os.getuid();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.879 -0400", hash_original_method = "FD1CFE447DC743FEF7DD120355028D01", hash_generated_method = "1BDC3A1E473EDEBEBFFC1BC846DC6D0F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String if_indextoname(int index) {
        dsTaint.addTaint(index);
        String varF27A26B1AA05853C73F22F2DC36E1543_1917108805 = (os.if_indextoname(index));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return os.if_indextoname(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.879 -0400", hash_original_method = "244F6B5FD78AC80358A10468727F943C", hash_generated_method = "7148281B619FCFF5A3E117F6B59E82CC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public InetAddress inet_pton(int family, String address) {
        dsTaint.addTaint(address);
        dsTaint.addTaint(family);
        InetAddress varF0FF0FD195E5651F0B6AFA17E8212459_1915506561 = (os.inet_pton(family, address));
        return (InetAddress)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return os.inet_pton(family, address);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.880 -0400", hash_original_method = "81C548F366545C14DF26B9A5D253BEA5", hash_generated_method = "7F7C0D83079E4B52EC44BC9B868DCE83")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public InetAddress ioctlInetAddress(FileDescriptor fd, int cmd, String interfaceName) throws ErrnoException {
        dsTaint.addTaint(cmd);
        dsTaint.addTaint(interfaceName);
        dsTaint.addTaint(fd.dsTaint);
        InetAddress var929CD5CD4EB0ADA6FF30C96FA8E2EB32_708886391 = (os.ioctlInetAddress(fd, cmd, interfaceName));
        return (InetAddress)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return os.ioctlInetAddress(fd, cmd, interfaceName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.880 -0400", hash_original_method = "B9A716BFE88006BFE54885EB5B40EF6E", hash_generated_method = "98A56BCD5AE39FE5C07A8D39FA1E4819")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int ioctlInt(FileDescriptor fd, int cmd, MutableInt arg) throws ErrnoException {
        dsTaint.addTaint(arg.dsTaint);
        dsTaint.addTaint(cmd);
        dsTaint.addTaint(fd.dsTaint);
        int varD9D1F852ABD2929B5B4A1DF95D32EC90_835473761 = (os.ioctlInt(fd, cmd, arg));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return os.ioctlInt(fd, cmd, arg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.880 -0400", hash_original_method = "E622E0FA602C62724E493B1B03996EEA", hash_generated_method = "F67D536AC13E20F6D4115D4FB86419DD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isatty(FileDescriptor fd) {
        dsTaint.addTaint(fd.dsTaint);
        boolean var1BDE8D20FF5CAACE3E2EB14F5484BA59_1891654943 = (os.isatty(fd));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return os.isatty(fd);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.880 -0400", hash_original_method = "39C5C221EF1E81F6FE3B9410463D5E57", hash_generated_method = "C7F0A8C14C815E7B134EC1D2F5795384")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void kill(int pid, int signal) throws ErrnoException {
        dsTaint.addTaint(signal);
        dsTaint.addTaint(pid);
        os.kill(pid, signal);
        // ---------- Original Method ----------
        //os.kill(pid, signal);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.880 -0400", hash_original_method = "039EEA76B9DC6E04921BFC5BC270EDD9", hash_generated_method = "84B9044C3F78C61948A2D8687B17954C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void listen(FileDescriptor fd, int backlog) throws ErrnoException {
        dsTaint.addTaint(backlog);
        dsTaint.addTaint(fd.dsTaint);
        os.listen(fd, backlog);
        // ---------- Original Method ----------
        //os.listen(fd, backlog);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.880 -0400", hash_original_method = "3005A45BFDFB73561B6BABAEF57B12E1", hash_generated_method = "11EB1B397B03B00545D3FFF22F192EC2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long lseek(FileDescriptor fd, long offset, int whence) throws ErrnoException {
        dsTaint.addTaint(whence);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(fd.dsTaint);
        long var00BC20AD4BC3DA29C7F7761FC82BB0E6_326435688 = (os.lseek(fd, offset, whence));
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return os.lseek(fd, offset, whence);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.881 -0400", hash_original_method = "F288030A10BA391FE6D7AD19552493B8", hash_generated_method = "50FC3EA7C715CF8FCD955914CD2A4B02")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StructStat lstat(String path) throws ErrnoException {
        dsTaint.addTaint(path);
        StructStat varC8233BBC8F2DA53BE97B3DB4596B17EC_1631092671 = (os.lstat(path));
        return (StructStat)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return os.lstat(path);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.881 -0400", hash_original_method = "0D8D349CD4EFD867777AD4E59116610D", hash_generated_method = "01DE2E0EB2336C34793F2E2E9EC6A36D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void mincore(long address, long byteCount, byte[] vector) throws ErrnoException {
        dsTaint.addTaint(address);
        dsTaint.addTaint(vector[0]);
        dsTaint.addTaint(byteCount);
        os.mincore(address, byteCount, vector);
        // ---------- Original Method ----------
        //os.mincore(address, byteCount, vector);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.881 -0400", hash_original_method = "689C229BD7F4B7F5308857A16DB04D8E", hash_generated_method = "34D942B90436D9EC064B9442DFA80BAA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void mkdir(String path, int mode) throws ErrnoException {
        dsTaint.addTaint(path);
        dsTaint.addTaint(mode);
        os.mkdir(path, mode);
        // ---------- Original Method ----------
        //os.mkdir(path, mode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.881 -0400", hash_original_method = "419517122697B0628E53EB3E2B0A6370", hash_generated_method = "FD102CD18116FE36E656C125DD4839D7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void mlock(long address, long byteCount) throws ErrnoException {
        dsTaint.addTaint(address);
        dsTaint.addTaint(byteCount);
        os.mlock(address, byteCount);
        // ---------- Original Method ----------
        //os.mlock(address, byteCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.881 -0400", hash_original_method = "4029BCDA0489C716FD1384F50323A029", hash_generated_method = "33F19B6ECAF90E8078BC81067E24841B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long mmap(long address, long byteCount, int prot, int flags, FileDescriptor fd, long offset) throws ErrnoException {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(address);
        dsTaint.addTaint(byteCount);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(fd.dsTaint);
        dsTaint.addTaint(prot);
        long var3045E876657A6DFFC0A2A0AFB33818CC_516813885 = (os.mmap(address, byteCount, prot, flags, fd, offset));
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return os.mmap(address, byteCount, prot, flags, fd, offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.882 -0400", hash_original_method = "26058ECBCE0A88D4B8D4418B78F705C5", hash_generated_method = "FEE97BD53A1CA5866B639E1FE10E8216")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void msync(long address, long byteCount, int flags) throws ErrnoException {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(address);
        dsTaint.addTaint(byteCount);
        os.msync(address, byteCount, flags);
        // ---------- Original Method ----------
        //os.msync(address, byteCount, flags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.882 -0400", hash_original_method = "12F3B374B5C7D041381B26987EDF7BE8", hash_generated_method = "2EDACC0AAB6E87D87DF9D420D2C5E618")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void munlock(long address, long byteCount) throws ErrnoException {
        dsTaint.addTaint(address);
        dsTaint.addTaint(byteCount);
        os.munlock(address, byteCount);
        // ---------- Original Method ----------
        //os.munlock(address, byteCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.882 -0400", hash_original_method = "93EF25630433342C6922044F58653EDA", hash_generated_method = "6A8D24D37C525521D94413134803C901")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void munmap(long address, long byteCount) throws ErrnoException {
        dsTaint.addTaint(address);
        dsTaint.addTaint(byteCount);
        os.munmap(address, byteCount);
        // ---------- Original Method ----------
        //os.munmap(address, byteCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.882 -0400", hash_original_method = "3A1C8AE14DFE6F094F17065084A852DA", hash_generated_method = "D597919E66B40E48B96C9236B4DAA075")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public FileDescriptor open(String path, int flags, int mode) throws ErrnoException {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(path);
        dsTaint.addTaint(mode);
        FileDescriptor varDF813003EF81B33B403133D09C9D4CD0_1974105654 = (os.open(path, flags, mode));
        return (FileDescriptor)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return os.open(path, flags, mode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.882 -0400", hash_original_method = "C44D806183F8681F84B21225E3DD2820", hash_generated_method = "39F078CE3F6EFEB9D9F2C56F82E852F0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public FileDescriptor[] pipe() throws ErrnoException {
        FileDescriptor[] var7850A048F200CCBE7F6CB8D7B1099EE8_1636481230 = (os.pipe());
        return (FileDescriptor[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //return os.pipe();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.883 -0400", hash_original_method = "5599B9E106312A6343AFDB459C1296E6", hash_generated_method = "AE60DEDE5137D98115461806E694899A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int poll(StructPollfd[] fds, int timeoutMs) throws ErrnoException {
        dsTaint.addTaint(timeoutMs);
        dsTaint.addTaint(fds[0].dsTaint);
        int var48722583F516647909DDA26F0FCD9942_392140424 = (os.poll(fds, timeoutMs));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return os.poll(fds, timeoutMs);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.884 -0400", hash_original_method = "E02E4577E71F70F2C9CAE7AED1E2F8AC", hash_generated_method = "D643D0730C1007D7B91AE744AD654246")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int pread(FileDescriptor fd, ByteBuffer buffer, long offset) throws ErrnoException {
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(fd.dsTaint);
        int var8E37D63F084AD12D6EF74F78D0F34813_699250188 = (os.pread(fd, buffer, offset));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return os.pread(fd, buffer, offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.884 -0400", hash_original_method = "77B89AD0CF3C5D71E7DD42E992F283EF", hash_generated_method = "259D35EBC626FB0FD5D76CC49FD1FAE3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int pread(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount, long offset) throws ErrnoException {
        dsTaint.addTaint(byteOffset);
        dsTaint.addTaint(bytes[0]);
        dsTaint.addTaint(byteCount);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(fd.dsTaint);
        int var9596F97D25F40A8949B0F9D6651550A1_625621660 = (os.pread(fd, bytes, byteOffset, byteCount, offset));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return os.pread(fd, bytes, byteOffset, byteCount, offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.884 -0400", hash_original_method = "1CD5001FEE779ACE9E3DB9100CD609FC", hash_generated_method = "927A7017244D9646C0A72B70CC83F4D0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int pwrite(FileDescriptor fd, ByteBuffer buffer, long offset) throws ErrnoException {
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(fd.dsTaint);
        int varBEC757109BB880DDBADF6015F3B05B2C_882120819 = (os.pwrite(fd, buffer, offset));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return os.pwrite(fd, buffer, offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.884 -0400", hash_original_method = "F0611566A9565E2DEF97709E6B9B6418", hash_generated_method = "E3AFB97F1ADA79A12D413C0F04EDDA86")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int pwrite(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount, long offset) throws ErrnoException {
        dsTaint.addTaint(byteOffset);
        dsTaint.addTaint(bytes[0]);
        dsTaint.addTaint(byteCount);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(fd.dsTaint);
        int var41A08F5DA487149A1F7C1270B58B9089_882750591 = (os.pwrite(fd, bytes, byteOffset, byteCount, offset));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return os.pwrite(fd, bytes, byteOffset, byteCount, offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.884 -0400", hash_original_method = "F3C222630BE6E1046A8D40208CD4C60B", hash_generated_method = "9D015CA5401286E4461BCF2C2AFD34EB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int read(FileDescriptor fd, ByteBuffer buffer) throws ErrnoException {
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(fd.dsTaint);
        int var5B8E7DC5191E81FE70C36AA027AFFCC8_1593150542 = (os.read(fd, buffer));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return os.read(fd, buffer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.885 -0400", hash_original_method = "21F8B1ED0ECF46FDBCE6EA979BADF2C3", hash_generated_method = "678A35BFC27812498E934CA62AE056CD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int read(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount) throws ErrnoException {
        dsTaint.addTaint(byteOffset);
        dsTaint.addTaint(bytes[0]);
        dsTaint.addTaint(byteCount);
        dsTaint.addTaint(fd.dsTaint);
        int varE59F1DA0F28FCDF7A959280195F03910_312814675 = (os.read(fd, bytes, byteOffset, byteCount));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return os.read(fd, bytes, byteOffset, byteCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.885 -0400", hash_original_method = "E2800F54CC6608A5FBBD1BF36223D806", hash_generated_method = "57B77FE538EA485BD17EC0BB0A901B9D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int readv(FileDescriptor fd, Object[] buffers, int[] offsets, int[] byteCounts) throws ErrnoException {
        dsTaint.addTaint(byteCounts[0]);
        dsTaint.addTaint(offsets[0]);
        dsTaint.addTaint(buffers[0].dsTaint);
        dsTaint.addTaint(fd.dsTaint);
        int var2494A58C76DD4D861DBB94DFA16C08A6_1283045012 = (os.readv(fd, buffers, offsets, byteCounts));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return os.readv(fd, buffers, offsets, byteCounts);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.885 -0400", hash_original_method = "84F37C132BD33033E9DE4E38A8430067", hash_generated_method = "BD7D3221E4274B629AAECC262CFB3A0A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int recvfrom(FileDescriptor fd, ByteBuffer buffer, int flags, InetSocketAddress srcAddress) throws ErrnoException {
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(flags);
        dsTaint.addTaint(srcAddress.dsTaint);
        dsTaint.addTaint(fd.dsTaint);
        int varF25721B896E31A53482415C6A924C22D_1482189930 = (os.recvfrom(fd, buffer, flags, srcAddress));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return os.recvfrom(fd, buffer, flags, srcAddress);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.885 -0400", hash_original_method = "0394D475125B49320B23E75594B5C434", hash_generated_method = "1DCBF283C2870343F175BB72EBF60E25")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int recvfrom(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount, int flags, InetSocketAddress srcAddress) throws ErrnoException {
        dsTaint.addTaint(byteOffset);
        dsTaint.addTaint(flags);
        dsTaint.addTaint(bytes[0]);
        dsTaint.addTaint(byteCount);
        dsTaint.addTaint(srcAddress.dsTaint);
        dsTaint.addTaint(fd.dsTaint);
        int var3A59E5EE9728502FA7AEFF9DA4D0C096_1285603686 = (os.recvfrom(fd, bytes, byteOffset, byteCount, flags, srcAddress));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return os.recvfrom(fd, bytes, byteOffset, byteCount, flags, srcAddress);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.885 -0400", hash_original_method = "B12B5B450AD1F25F30BAE5F7F0558752", hash_generated_method = "CCDB6E811E2577B4C3F9E53D29DF96EC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void remove(String path) throws ErrnoException {
        dsTaint.addTaint(path);
        os.remove(path);
        // ---------- Original Method ----------
        //os.remove(path);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.885 -0400", hash_original_method = "91C997D77FC3A21A4E5692674F9BE11B", hash_generated_method = "65D6307FCF9D9F56B1DAC0A45B3F5F47")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void rename(String oldPath, String newPath) throws ErrnoException {
        dsTaint.addTaint(newPath);
        dsTaint.addTaint(oldPath);
        os.rename(oldPath, newPath);
        // ---------- Original Method ----------
        //os.rename(oldPath, newPath);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.886 -0400", hash_original_method = "C572D6E07635A5094C687364A5671672", hash_generated_method = "59CA1D09E45F1F70ABAC2A49E7096948")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long sendfile(FileDescriptor outFd, FileDescriptor inFd, MutableLong inOffset, long byteCount) throws ErrnoException {
        dsTaint.addTaint(outFd.dsTaint);
        dsTaint.addTaint(byteCount);
        dsTaint.addTaint(inFd.dsTaint);
        dsTaint.addTaint(inOffset.dsTaint);
        long varA7A8691BB87D642123D80A6B9B64BEE0_1391869829 = (os.sendfile(outFd, inFd, inOffset, byteCount));
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return os.sendfile(outFd, inFd, inOffset, byteCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.886 -0400", hash_original_method = "88066FF66E9BA638CFCEFABD2B423922", hash_generated_method = "3596AEE1478E6F099B51E63D3100CF09")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int sendto(FileDescriptor fd, ByteBuffer buffer, int flags, InetAddress inetAddress, int port) throws ErrnoException {
        dsTaint.addTaint(port);
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(flags);
        dsTaint.addTaint(inetAddress.dsTaint);
        dsTaint.addTaint(fd.dsTaint);
        int var0B8E7266620C88EB24F8453B4CECD027_992648508 = (os.sendto(fd, buffer, flags, inetAddress, port));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return os.sendto(fd, buffer, flags, inetAddress, port);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.886 -0400", hash_original_method = "BC2321A87F2222D5681A88900983F12D", hash_generated_method = "062E30E869B70A5223EC04E97298FAB6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int sendto(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount, int flags, InetAddress inetAddress, int port) throws ErrnoException {
        dsTaint.addTaint(port);
        dsTaint.addTaint(byteOffset);
        dsTaint.addTaint(flags);
        dsTaint.addTaint(bytes[0]);
        dsTaint.addTaint(inetAddress.dsTaint);
        dsTaint.addTaint(byteCount);
        dsTaint.addTaint(fd.dsTaint);
        int var8221F6255948EB137094ED72A9C8456A_910906683 = (os.sendto(fd, bytes, byteOffset, byteCount, flags, inetAddress, port));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return os.sendto(fd, bytes, byteOffset, byteCount, flags, inetAddress, port);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.886 -0400", hash_original_method = "D0978EE2EC25CFB475F603941EE6E321", hash_generated_method = "724CB9EB9E689B9D6CC1D7EEC3A2DAD2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setegid(int egid) throws ErrnoException {
        dsTaint.addTaint(egid);
        os.setegid(egid);
        // ---------- Original Method ----------
        //os.setegid(egid);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.886 -0400", hash_original_method = "0B3E20A1D3AFC99676F4A67D4967A4C5", hash_generated_method = "D9755F5EC6AA0EBA69851EC6E1BD200E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void seteuid(int euid) throws ErrnoException {
        dsTaint.addTaint(euid);
        os.seteuid(euid);
        // ---------- Original Method ----------
        //os.seteuid(euid);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.886 -0400", hash_original_method = "5A836F22DA1ADF6236109717B09FFB11", hash_generated_method = "278E3752851896E17AECC26170863BAF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setgid(int gid) throws ErrnoException {
        dsTaint.addTaint(gid);
        os.setgid(gid);
        // ---------- Original Method ----------
        //os.setgid(gid);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.887 -0400", hash_original_method = "02713B5D8B1D9FC1829D645D7EE01360", hash_generated_method = "53C281F255854974F731752D8C162FA8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setsockoptByte(FileDescriptor fd, int level, int option, int value) throws ErrnoException {
        dsTaint.addTaint(level);
        dsTaint.addTaint(value);
        dsTaint.addTaint(fd.dsTaint);
        dsTaint.addTaint(option);
        os.setsockoptByte(fd, level, option, value);
        // ---------- Original Method ----------
        //os.setsockoptByte(fd, level, option, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.887 -0400", hash_original_method = "859AD73B12F1FCBFB785F9C03E57780C", hash_generated_method = "698834EFD893F8ABE862EF313E7D056E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setsockoptIfreq(FileDescriptor fd, int level, int option, String value) throws ErrnoException {
        dsTaint.addTaint(level);
        dsTaint.addTaint(value);
        dsTaint.addTaint(fd.dsTaint);
        dsTaint.addTaint(option);
        os.setsockoptIfreq(fd, level, option, value);
        // ---------- Original Method ----------
        //os.setsockoptIfreq(fd, level, option, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.887 -0400", hash_original_method = "5882A7C612198E8B1D9CBF2EDBCD6FE7", hash_generated_method = "F3D5EAC8474DE83309D40293D666CCC8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setsockoptInt(FileDescriptor fd, int level, int option, int value) throws ErrnoException {
        dsTaint.addTaint(level);
        dsTaint.addTaint(value);
        dsTaint.addTaint(fd.dsTaint);
        dsTaint.addTaint(option);
        os.setsockoptInt(fd, level, option, value);
        // ---------- Original Method ----------
        //os.setsockoptInt(fd, level, option, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.887 -0400", hash_original_method = "3A8741E8D07270D7E757C05217AEFD39", hash_generated_method = "3E655A9F84D49D646F2806670B58F325")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setsockoptIpMreqn(FileDescriptor fd, int level, int option, int value) throws ErrnoException {
        dsTaint.addTaint(level);
        dsTaint.addTaint(value);
        dsTaint.addTaint(fd.dsTaint);
        dsTaint.addTaint(option);
        os.setsockoptIpMreqn(fd, level, option, value);
        // ---------- Original Method ----------
        //os.setsockoptIpMreqn(fd, level, option, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.887 -0400", hash_original_method = "4E1D080A99B5B2F06B7A0201A27B3E99", hash_generated_method = "4E2AE48998E503B37D77FABECBF40631")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setsockoptGroupReq(FileDescriptor fd, int level, int option, StructGroupReq value) throws ErrnoException {
        dsTaint.addTaint(level);
        dsTaint.addTaint(value.dsTaint);
        dsTaint.addTaint(fd.dsTaint);
        dsTaint.addTaint(option);
        os.setsockoptGroupReq(fd, level, option, value);
        // ---------- Original Method ----------
        //os.setsockoptGroupReq(fd, level, option, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.887 -0400", hash_original_method = "A1EC25C1EA10D3E94DA65D129945BE62", hash_generated_method = "A1533E24A12E50E87AB7B59F64391E01")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setsockoptLinger(FileDescriptor fd, int level, int option, StructLinger value) throws ErrnoException {
        dsTaint.addTaint(level);
        dsTaint.addTaint(value.dsTaint);
        dsTaint.addTaint(fd.dsTaint);
        dsTaint.addTaint(option);
        os.setsockoptLinger(fd, level, option, value);
        // ---------- Original Method ----------
        //os.setsockoptLinger(fd, level, option, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.887 -0400", hash_original_method = "B0DC8E18521874709C24B9B37D89D87C", hash_generated_method = "53E4CE94B23C4E9067D9B64C49E0EDDA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setsockoptTimeval(FileDescriptor fd, int level, int option, StructTimeval value) throws ErrnoException {
        dsTaint.addTaint(level);
        dsTaint.addTaint(value.dsTaint);
        dsTaint.addTaint(fd.dsTaint);
        dsTaint.addTaint(option);
        os.setsockoptTimeval(fd, level, option, value);
        // ---------- Original Method ----------
        //os.setsockoptTimeval(fd, level, option, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.888 -0400", hash_original_method = "554251AE1D031EE7BA07BC4F696C724A", hash_generated_method = "6F6909BA02FABD584522ADA283CDCDC5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setuid(int uid) throws ErrnoException {
        dsTaint.addTaint(uid);
        os.setuid(uid);
        // ---------- Original Method ----------
        //os.setuid(uid);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.888 -0400", hash_original_method = "5FEB3BBC8A3C8F5F8A22DE81B35CAE4D", hash_generated_method = "160A51480BA4845A4E83D56387B2A7D3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void shutdown(FileDescriptor fd, int how) throws ErrnoException {
        dsTaint.addTaint(how);
        dsTaint.addTaint(fd.dsTaint);
        os.shutdown(fd, how);
        // ---------- Original Method ----------
        //os.shutdown(fd, how);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.888 -0400", hash_original_method = "558F533484D6B9C99DDFE653A920693C", hash_generated_method = "859C420E0A2D552D45D6A8B2921322B5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public FileDescriptor socket(int domain, int type, int protocol) throws ErrnoException {
        dsTaint.addTaint(protocol);
        dsTaint.addTaint(domain);
        dsTaint.addTaint(type);
        FileDescriptor varD7C0BFB58A2C6A982A23A172A0C590FC_1236461652 = (os.socket(domain, type, protocol));
        return (FileDescriptor)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return os.socket(domain, type, protocol);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.888 -0400", hash_original_method = "E3FE6B0CE9C868055585C77F475D7F5A", hash_generated_method = "BE20EC5065CC0D481A2227AC5D6E70BA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StructStat stat(String path) throws ErrnoException {
        dsTaint.addTaint(path);
        StructStat var2C024C392F42BC302E5D75904EA342EC_2066081002 = (os.stat(path));
        return (StructStat)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return os.stat(path);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.888 -0400", hash_original_method = "EA8F2D89CBB0B8AF52F0D62C5DA4B5A0", hash_generated_method = "19899F46AC70B72BEBA3546CF4DAD1D3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StructStatFs statfs(String path) throws ErrnoException {
        dsTaint.addTaint(path);
        StructStatFs var2FFAF2094D0D006AB785E47F6BF4A916_1496419994 = (os.statfs(path));
        return (StructStatFs)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return os.statfs(path);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.888 -0400", hash_original_method = "FBEAE456B3A3C776553B1F7E912CD6FB", hash_generated_method = "9BA09AA52285A5E63951711A47B0DD91")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String strerror(int errno) {
        dsTaint.addTaint(errno);
        String var69A0F0547EC2E1CC57A38635805483D1_786442037 = (os.strerror(errno));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return os.strerror(errno);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.888 -0400", hash_original_method = "FB4E2B29DA5C665C03E887C9C86A36A3", hash_generated_method = "4CC37BC5AB7D207DAFEBFE37F165C9FD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void symlink(String oldPath, String newPath) throws ErrnoException {
        dsTaint.addTaint(newPath);
        dsTaint.addTaint(oldPath);
        os.symlink(oldPath, newPath);
        // ---------- Original Method ----------
        //os.symlink(oldPath, newPath);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.889 -0400", hash_original_method = "9239DE14FB7F01A1D647B884E3411551", hash_generated_method = "76B3F0801A8C66D408B6E762B3BAA839")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long sysconf(int name) {
        dsTaint.addTaint(name);
        long var6016DF4BB18042E7D98C68C5D480E24E_1241062999 = (os.sysconf(name));
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return os.sysconf(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.889 -0400", hash_original_method = "E92B0E3CCB7269FEE37854B5F086E530", hash_generated_method = "611FD50E1A24B21E0712F1161338E816")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StructUtsname uname() {
        StructUtsname varDCD4AA64BF2BD25CA957A8E348D148BF_240046868 = (os.uname());
        return (StructUtsname)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return os.uname();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.889 -0400", hash_original_method = "EC4C2322F336992223E3CB1B21022BF9", hash_generated_method = "B948BA6A1BBEFDC74A62F759ED7829B6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int waitpid(int pid, MutableInt status, int options) throws ErrnoException {
        dsTaint.addTaint(status.dsTaint);
        dsTaint.addTaint(pid);
        dsTaint.addTaint(options);
        int varE8B0A97070670E6FF43AAF48DCCF725E_1998461508 = (os.waitpid(pid, status, options));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return os.waitpid(pid, status, options);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.889 -0400", hash_original_method = "844A22BF74026B79E5C643696D2A0D2B", hash_generated_method = "ECA55FEA71AC2FE2D411F6DC24AAB0F9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int write(FileDescriptor fd, ByteBuffer buffer) throws ErrnoException {
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(fd.dsTaint);
        int var0626357AF90ACF3FB1D934D119466787_286623696 = (os.write(fd, buffer));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return os.write(fd, buffer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.889 -0400", hash_original_method = "437BEB04F87A5AE656D8F235B16E36DF", hash_generated_method = "EF7CE9F4B984E90F9BB9594FDE6FE642")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int write(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount) throws ErrnoException {
        dsTaint.addTaint(byteOffset);
        dsTaint.addTaint(bytes[0]);
        dsTaint.addTaint(byteCount);
        dsTaint.addTaint(fd.dsTaint);
        int varE733C997547CF269F3AB7BAEB4D044AF_1271108011 = (os.write(fd, bytes, byteOffset, byteCount));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return os.write(fd, bytes, byteOffset, byteCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.889 -0400", hash_original_method = "8BC1FDC02B601F3DB4DB2A70967C7CDC", hash_generated_method = "F9F7F45B359E40C7D91895CFB33A9A47")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int writev(FileDescriptor fd, Object[] buffers, int[] offsets, int[] byteCounts) throws ErrnoException {
        dsTaint.addTaint(byteCounts[0]);
        dsTaint.addTaint(offsets[0]);
        dsTaint.addTaint(buffers[0].dsTaint);
        dsTaint.addTaint(fd.dsTaint);
        int var32F5E7D906A9F96A2B6412DC92928AD7_1522899874 = (os.writev(fd, buffers, offsets, byteCounts));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return os.writev(fd, buffers, offsets, byteCounts);
    }

    
}

