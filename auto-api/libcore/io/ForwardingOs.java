package libcore.io;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.FileDescriptor;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import libcore.util.MutableInt;
import libcore.util.MutableLong;

public class ForwardingOs implements Os {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.074 -0400", hash_original_field = "DD302F94682DBD2A114D63B0433602E0", hash_generated_field = "AD741EF2B519FC3080D4269DB2BABC3A")

    protected Os os;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.074 -0400", hash_original_method = "EC37328A0FF4DE634029572AA03E9806", hash_generated_method = "C41B14D0DEFEB2ECE4508496A7A2B2B8")
    public  ForwardingOs(Os os) {
        this.os = os;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.075 -0400", hash_original_method = "5CF5B545FE52A5A749C69E4804E7DB37", hash_generated_method = "A45A9BE80FEC4F2835DD937B35706DF6")
    public FileDescriptor accept(FileDescriptor fd, InetSocketAddress peerAddress) throws ErrnoException {
        FileDescriptor varB4EAC82CA7396A68D541C85D26508E83_166332208 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_166332208 = os.accept(fd, peerAddress);
        addTaint(fd.getTaint());
        addTaint(peerAddress.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_166332208.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_166332208;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.075 -0400", hash_original_method = "FFD94E7AFE1E3B1F76A2D696707B6857", hash_generated_method = "E43C45A0E5EDAAF217430940FA96F47E")
    public boolean access(String path, int mode) throws ErrnoException {
        boolean var172DEC5DD37258CD490DDB56CA7E2DB8_326785229 = (os.access(path, mode));
        addTaint(path.getTaint());
        addTaint(mode);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1119367950 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1119367950;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.075 -0400", hash_original_method = "743422D2EB39F172C4245C8DC993624F", hash_generated_method = "2C4F56DB987DDA5521904DED150E2276")
    public void bind(FileDescriptor fd, InetAddress address, int port) throws ErrnoException {
        os.bind(fd, address, port);
        addTaint(fd.getTaint());
        addTaint(address.getTaint());
        addTaint(port);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.075 -0400", hash_original_method = "A92F7B75A5B2B90071388C67FA677A74", hash_generated_method = "25BEC27B5A16271F093E9447FC93F8BE")
    public void chmod(String path, int mode) throws ErrnoException {
        os.chmod(path, mode);
        addTaint(path.getTaint());
        addTaint(mode);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.076 -0400", hash_original_method = "2AF652D8862D637B4A4051CAB7CD62FB", hash_generated_method = "0691BC1EEB0DF53658B22E295E231D1F")
    public void close(FileDescriptor fd) throws ErrnoException {
        os.close(fd);
        addTaint(fd.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.076 -0400", hash_original_method = "FADD460EF8DBCF58AF836CFAB2496AF1", hash_generated_method = "15ABDFE7CCF265D5E298BF7816B64D67")
    public void connect(FileDescriptor fd, InetAddress address, int port) throws ErrnoException {
        os.connect(fd, address, port);
        addTaint(fd.getTaint());
        addTaint(address.getTaint());
        addTaint(port);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.076 -0400", hash_original_method = "6162F8350974235CF8AA9EBE9F68335F", hash_generated_method = "9C83A3B8056CD56D51E938663DFBF087")
    public FileDescriptor dup(FileDescriptor oldFd) throws ErrnoException {
        FileDescriptor varB4EAC82CA7396A68D541C85D26508E83_1679281741 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1679281741 = os.dup(oldFd);
        addTaint(oldFd.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1679281741.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1679281741;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.077 -0400", hash_original_method = "E190E2A3CFD75C84461AB90FFE03369B", hash_generated_method = "5E57CE0D7A157B546579E63850F6E8A7")
    public FileDescriptor dup2(FileDescriptor oldFd, int newFd) throws ErrnoException {
        FileDescriptor varB4EAC82CA7396A68D541C85D26508E83_1860717987 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1860717987 = os.dup2(oldFd, newFd);
        addTaint(oldFd.getTaint());
        addTaint(newFd);
        varB4EAC82CA7396A68D541C85D26508E83_1860717987.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1860717987;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.078 -0400", hash_original_method = "5CF51EBD75B5D23C7F632D7D494380D1", hash_generated_method = "7D04EB182499F7324E87F6B44F5462CB")
    public String[] environ() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_2137419158 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2137419158 = os.environ();
        varB4EAC82CA7396A68D541C85D26508E83_2137419158.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2137419158;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.078 -0400", hash_original_method = "CA43F47313D11741B7EE5D06954736CB", hash_generated_method = "A5E0F8D340CA3B851645597197D4BEE3")
    public int fcntlVoid(FileDescriptor fd, int cmd) throws ErrnoException {
        int varBF1653E2CBDC0EBDA030B66FA450FCF0_1612762232 = (os.fcntlVoid(fd, cmd));
        addTaint(fd.getTaint());
        addTaint(cmd);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2000465755 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2000465755;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.079 -0400", hash_original_method = "6B248418A1B43AC8597DD680343F17BD", hash_generated_method = "DF4A744001CA7B110FCDA537B3CAE863")
    public int fcntlLong(FileDescriptor fd, int cmd, long arg) throws ErrnoException {
        int var97EF80FEE8D7DCAFEADBFC1210BDC18B_744163161 = (os.fcntlLong(fd, cmd, arg));
        addTaint(fd.getTaint());
        addTaint(cmd);
        addTaint(arg);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1515443316 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1515443316;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.079 -0400", hash_original_method = "28B6741D270DBCC0BDA43B4FBA76C484", hash_generated_method = "809CC9E21BC5A2140C15CFE9AD623264")
    public int fcntlFlock(FileDescriptor fd, int cmd, StructFlock arg) throws ErrnoException {
        int var2729B8DD99A4FEEBABCEFB3EF912E159_722331416 = (os.fcntlFlock(fd, cmd, arg));
        addTaint(fd.getTaint());
        addTaint(cmd);
        addTaint(arg.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_57807589 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_57807589;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.079 -0400", hash_original_method = "D2B4800A8551761D0A11CAE1762DA39E", hash_generated_method = "573D02F895F974160BDFA32E6A78A43A")
    public void fdatasync(FileDescriptor fd) throws ErrnoException {
        os.fdatasync(fd);
        addTaint(fd.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.080 -0400", hash_original_method = "0159E8BC0EB89F7B9A8B0DA54E55E46B", hash_generated_method = "AB22600F90752288E81B776D9A6D7649")
    public StructStat fstat(FileDescriptor fd) throws ErrnoException {
        StructStat varB4EAC82CA7396A68D541C85D26508E83_1201309537 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1201309537 = os.fstat(fd);
        addTaint(fd.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1201309537.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1201309537;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.080 -0400", hash_original_method = "1D4670A49E88E5904763EEFCF378AA9C", hash_generated_method = "DB3FED93ECA6FA972DBF21199C4D96AA")
    public StructStatFs fstatfs(FileDescriptor fd) throws ErrnoException {
        StructStatFs varB4EAC82CA7396A68D541C85D26508E83_1359306609 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1359306609 = os.fstatfs(fd);
        addTaint(fd.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1359306609.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1359306609;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.080 -0400", hash_original_method = "5A3103E0191F55AC2413EF7A293382EA", hash_generated_method = "862ACD95EBCD31133FC7E286CD6E9E80")
    public void fsync(FileDescriptor fd) throws ErrnoException {
        os.fsync(fd);
        addTaint(fd.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.080 -0400", hash_original_method = "B89F13DA07AD88D9E35FDD0F8C706602", hash_generated_method = "551BB12398467F3C8EB23F5C296B7D11")
    public void ftruncate(FileDescriptor fd, long length) throws ErrnoException {
        os.ftruncate(fd, length);
        addTaint(fd.getTaint());
        addTaint(length);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.081 -0400", hash_original_method = "4EDF3DB0839BDB5BB59D5BDCF6ED266B", hash_generated_method = "EC3FE5E20192DAEDE93564B63CB9D384")
    public String gai_strerror(int error) {
        String varB4EAC82CA7396A68D541C85D26508E83_1166001094 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1166001094 = os.gai_strerror(error);
        addTaint(error);
        varB4EAC82CA7396A68D541C85D26508E83_1166001094.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1166001094;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.081 -0400", hash_original_method = "D134969B79309E2FFE6734562680F40F", hash_generated_method = "969F22864987EEDE8FC6C4044C80C917")
    public InetAddress[] getaddrinfo(String node, StructAddrinfo hints) throws GaiException {
        InetAddress[] varB4EAC82CA7396A68D541C85D26508E83_1911287558 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1911287558 = os.getaddrinfo(node, hints);
        addTaint(node.getTaint());
        addTaint(hints.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1911287558.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1911287558;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.081 -0400", hash_original_method = "DA32E4A67BBB878517DC4C1F6AD2DE47", hash_generated_method = "4340E676D17D2978645D3CE00DA1A1AF")
    public int getegid() {
        int varD8065AE9128D4E02D412A3250EE4BEA6_1823021178 = (os.getegid());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1594585218 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1594585218;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.081 -0400", hash_original_method = "FAD72A6DE2CC7E2DB1B9B6FC41642D5B", hash_generated_method = "1E5D0CEF56A4C94928E17D817F13C863")
    public int geteuid() {
        int var56D743784E549DA0B7EA1F9C189A6471_1812636981 = (os.geteuid());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1338345123 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1338345123;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.082 -0400", hash_original_method = "FADA5B6063E47C208AC2D0843F6EB847", hash_generated_method = "44BA29C50FFF178C6F88937CA5B6D665")
    public int getgid() {
        int var6CADC2A35DC4D6A9A5A15CAB17B4B6E3_2083240528 = (os.getgid());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_913505507 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_913505507;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.082 -0400", hash_original_method = "E4B66B682B354EFDCC2A2307B9973162", hash_generated_method = "0505360FE231D125B6CAEAA4CCF04F92")
    public String getenv(String name) {
        String varB4EAC82CA7396A68D541C85D26508E83_1197781696 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1197781696 = os.getenv(name);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1197781696.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1197781696;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.082 -0400", hash_original_method = "95C6CCF446FE941364E9F3FC808640B5", hash_generated_method = "C30D86239FB45015481391C8B3A1044A")
    public String getnameinfo(InetAddress address, int flags) throws GaiException {
        String varB4EAC82CA7396A68D541C85D26508E83_1403642071 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1403642071 = os.getnameinfo(address, flags);
        addTaint(address.getTaint());
        addTaint(flags);
        varB4EAC82CA7396A68D541C85D26508E83_1403642071.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1403642071;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.083 -0400", hash_original_method = "A3B371C9A268817901795576D0A04CF6", hash_generated_method = "37B3B4AE211EFE983D40740FEBCD2087")
    public int getpid() {
        int var38AA61BF3E54239C4504A81A8746FA43_119317403 = (os.getpid());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_761316593 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_761316593;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.083 -0400", hash_original_method = "878D1FDE3DC9E3A460294EB2A78F5342", hash_generated_method = "F99234E8B56584328207229D409D0273")
    public int getppid() {
        int var1F662189AEACAB508948D811AFEC491B_794485210 = (os.getppid());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1288774280 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1288774280;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.083 -0400", hash_original_method = "A3C50DDCB01897A6F2E46FE623EA65A2", hash_generated_method = "A94DF5441F3594C318AB4DC0950D90F0")
    public StructPasswd getpwnam(String name) throws ErrnoException {
        StructPasswd varB4EAC82CA7396A68D541C85D26508E83_1974141448 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1974141448 = os.getpwnam(name);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1974141448.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1974141448;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.084 -0400", hash_original_method = "F069BDB68A1BE69C49E58A44BE7A4944", hash_generated_method = "52E175D7892DEDDCCEC5B1755D587C55")
    public StructPasswd getpwuid(int uid) throws ErrnoException {
        StructPasswd varB4EAC82CA7396A68D541C85D26508E83_948341899 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_948341899 = os.getpwuid(uid);
        addTaint(uid);
        varB4EAC82CA7396A68D541C85D26508E83_948341899.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_948341899;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.084 -0400", hash_original_method = "C71AB83C8CB24831B3B392DF1EFA2A55", hash_generated_method = "888F2ED8D4EEF2E54FE50CC28ADB7DCE")
    public SocketAddress getsockname(FileDescriptor fd) throws ErrnoException {
        SocketAddress varB4EAC82CA7396A68D541C85D26508E83_134722347 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_134722347 = os.getsockname(fd);
        addTaint(fd.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_134722347.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_134722347;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.084 -0400", hash_original_method = "E5D66E4A2B17F99E78F6B2E97C4D0018", hash_generated_method = "CE8594D1872AB43F85DCB29D08CB2E07")
    public int getsockoptByte(FileDescriptor fd, int level, int option) throws ErrnoException {
        int var46B88F2A6E8AFD10C1C2A4CB4FA13847_2132476386 = (os.getsockoptByte(fd, level, option));
        addTaint(fd.getTaint());
        addTaint(level);
        addTaint(option);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2090808465 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2090808465;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.085 -0400", hash_original_method = "0CBF6F7E2BE2FF171C45C7BCFC831012", hash_generated_method = "CE596286291284871FAC653FA98F63FA")
    public InetAddress getsockoptInAddr(FileDescriptor fd, int level, int option) throws ErrnoException {
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_106549637 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_106549637 = os.getsockoptInAddr(fd, level, option);
        addTaint(fd.getTaint());
        addTaint(level);
        addTaint(option);
        varB4EAC82CA7396A68D541C85D26508E83_106549637.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_106549637;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.085 -0400", hash_original_method = "946A87B9C2E87F4C961C36C4569A31BA", hash_generated_method = "D9CC96F0DF0A1B2A3B66BABC14312BEB")
    public int getsockoptInt(FileDescriptor fd, int level, int option) throws ErrnoException {
        int varE08D816983313FAA61DC4FC565C65ADD_929674457 = (os.getsockoptInt(fd, level, option));
        addTaint(fd.getTaint());
        addTaint(level);
        addTaint(option);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_608885960 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_608885960;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.086 -0400", hash_original_method = "EBD2988D937DD58B5AD9697AEE85A0FB", hash_generated_method = "5381088771D774A5DAC32DCF19000187")
    public StructLinger getsockoptLinger(FileDescriptor fd, int level, int option) throws ErrnoException {
        StructLinger varB4EAC82CA7396A68D541C85D26508E83_1014652608 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1014652608 = os.getsockoptLinger(fd, level, option);
        addTaint(fd.getTaint());
        addTaint(level);
        addTaint(option);
        varB4EAC82CA7396A68D541C85D26508E83_1014652608.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1014652608;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.086 -0400", hash_original_method = "1C478D9E653EA1E4A0CA2442FA9E2156", hash_generated_method = "30835983C40C3F4BD96FD911D6B51A8A")
    public StructTimeval getsockoptTimeval(FileDescriptor fd, int level, int option) throws ErrnoException {
        StructTimeval varB4EAC82CA7396A68D541C85D26508E83_1439637440 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1439637440 = os.getsockoptTimeval(fd, level, option);
        addTaint(fd.getTaint());
        addTaint(level);
        addTaint(option);
        varB4EAC82CA7396A68D541C85D26508E83_1439637440.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1439637440;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.087 -0400", hash_original_method = "2F11239B76600858937301E80656F86F", hash_generated_method = "9D50C76236CCE56096162139262537F2")
    public int getuid() {
        int var6E1C401E18C533CAAAF3A5BDCCAC0B20_214714530 = (os.getuid());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_283999988 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_283999988;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.087 -0400", hash_original_method = "FD1CFE447DC743FEF7DD120355028D01", hash_generated_method = "2037EAD1CD667A25F5B78B46E932DB06")
    public String if_indextoname(int index) {
        String varB4EAC82CA7396A68D541C85D26508E83_1877444243 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1877444243 = os.if_indextoname(index);
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_1877444243.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1877444243;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.088 -0400", hash_original_method = "244F6B5FD78AC80358A10468727F943C", hash_generated_method = "27C7A857AB6A783639BAB3B343F12425")
    public InetAddress inet_pton(int family, String address) {
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_1703769894 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1703769894 = os.inet_pton(family, address);
        addTaint(family);
        addTaint(address.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1703769894.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1703769894;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.089 -0400", hash_original_method = "81C548F366545C14DF26B9A5D253BEA5", hash_generated_method = "4F3CE1C942FFD54D11F1B746A0DFA2BE")
    public InetAddress ioctlInetAddress(FileDescriptor fd, int cmd, String interfaceName) throws ErrnoException {
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_1845813344 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1845813344 = os.ioctlInetAddress(fd, cmd, interfaceName);
        addTaint(fd.getTaint());
        addTaint(cmd);
        addTaint(interfaceName.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1845813344.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1845813344;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.089 -0400", hash_original_method = "B9A716BFE88006BFE54885EB5B40EF6E", hash_generated_method = "F780460B7BC3B2EAF8DDF8038DB6FE48")
    public int ioctlInt(FileDescriptor fd, int cmd, MutableInt arg) throws ErrnoException {
        int varD9D1F852ABD2929B5B4A1DF95D32EC90_757885461 = (os.ioctlInt(fd, cmd, arg));
        addTaint(fd.getTaint());
        addTaint(cmd);
        addTaint(arg.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_475617835 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_475617835;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.089 -0400", hash_original_method = "E622E0FA602C62724E493B1B03996EEA", hash_generated_method = "CB53DEC1AC0182E20AE3D719B19AAC2B")
    public boolean isatty(FileDescriptor fd) {
        boolean var1BDE8D20FF5CAACE3E2EB14F5484BA59_934899241 = (os.isatty(fd));
        addTaint(fd.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_374696909 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_374696909;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.089 -0400", hash_original_method = "39C5C221EF1E81F6FE3B9410463D5E57", hash_generated_method = "2A652D0CC61257924637F3B4524AB2ED")
    public void kill(int pid, int signal) throws ErrnoException {
        os.kill(pid, signal);
        addTaint(pid);
        addTaint(signal);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.090 -0400", hash_original_method = "039EEA76B9DC6E04921BFC5BC270EDD9", hash_generated_method = "EF536F2D00F74E235D928577CD3328A5")
    public void listen(FileDescriptor fd, int backlog) throws ErrnoException {
        os.listen(fd, backlog);
        addTaint(fd.getTaint());
        addTaint(backlog);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.090 -0400", hash_original_method = "3005A45BFDFB73561B6BABAEF57B12E1", hash_generated_method = "5E4EFF285FC3322B2C985F07DD7E73AF")
    public long lseek(FileDescriptor fd, long offset, int whence) throws ErrnoException {
        long var00BC20AD4BC3DA29C7F7761FC82BB0E6_1579799570 = (os.lseek(fd, offset, whence));
        addTaint(fd.getTaint());
        addTaint(offset);
        addTaint(whence);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_947664913 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_947664913;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.091 -0400", hash_original_method = "F288030A10BA391FE6D7AD19552493B8", hash_generated_method = "77BD31EE231E0AFA2B5E68CCEEE432B8")
    public StructStat lstat(String path) throws ErrnoException {
        StructStat varB4EAC82CA7396A68D541C85D26508E83_439057283 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_439057283 = os.lstat(path);
        addTaint(path.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_439057283.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_439057283;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.091 -0400", hash_original_method = "0D8D349CD4EFD867777AD4E59116610D", hash_generated_method = "0A1847CF7EEC8E9DC66F9219B36FE04B")
    public void mincore(long address, long byteCount, byte[] vector) throws ErrnoException {
        os.mincore(address, byteCount, vector);
        addTaint(address);
        addTaint(byteCount);
        addTaint(vector[0]);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.092 -0400", hash_original_method = "689C229BD7F4B7F5308857A16DB04D8E", hash_generated_method = "B3FDA2E6552179AB66F6BBBC382EBDAE")
    public void mkdir(String path, int mode) throws ErrnoException {
        os.mkdir(path, mode);
        addTaint(path.getTaint());
        addTaint(mode);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.092 -0400", hash_original_method = "419517122697B0628E53EB3E2B0A6370", hash_generated_method = "13BD8890090968567A2F57958022BFE6")
    public void mlock(long address, long byteCount) throws ErrnoException {
        os.mlock(address, byteCount);
        addTaint(address);
        addTaint(byteCount);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.092 -0400", hash_original_method = "4029BCDA0489C716FD1384F50323A029", hash_generated_method = "DC96697C1E68E3895FBB14D7B77E6E27")
    public long mmap(long address, long byteCount, int prot, int flags, FileDescriptor fd, long offset) throws ErrnoException {
        long var3045E876657A6DFFC0A2A0AFB33818CC_1763976648 = (os.mmap(address, byteCount, prot, flags, fd, offset));
        addTaint(address);
        addTaint(byteCount);
        addTaint(prot);
        addTaint(flags);
        addTaint(fd.getTaint());
        addTaint(offset);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_62550191 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_62550191;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.092 -0400", hash_original_method = "26058ECBCE0A88D4B8D4418B78F705C5", hash_generated_method = "B3FF0C6B6F74DBE6935D16BA8C27125B")
    public void msync(long address, long byteCount, int flags) throws ErrnoException {
        os.msync(address, byteCount, flags);
        addTaint(address);
        addTaint(byteCount);
        addTaint(flags);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.093 -0400", hash_original_method = "12F3B374B5C7D041381B26987EDF7BE8", hash_generated_method = "F14D84EEE2DC5E8DEA4BB6D495547D30")
    public void munlock(long address, long byteCount) throws ErrnoException {
        os.munlock(address, byteCount);
        addTaint(address);
        addTaint(byteCount);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.093 -0400", hash_original_method = "93EF25630433342C6922044F58653EDA", hash_generated_method = "356606A69AA5950B9FE2BB3C0E2BB836")
    public void munmap(long address, long byteCount) throws ErrnoException {
        os.munmap(address, byteCount);
        addTaint(address);
        addTaint(byteCount);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.093 -0400", hash_original_method = "3A1C8AE14DFE6F094F17065084A852DA", hash_generated_method = "3F73D3BB230D59CD02F514057E7E4B8B")
    public FileDescriptor open(String path, int flags, int mode) throws ErrnoException {
        FileDescriptor varB4EAC82CA7396A68D541C85D26508E83_1467783590 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1467783590 = os.open(path, flags, mode);
        addTaint(path.getTaint());
        addTaint(flags);
        addTaint(mode);
        varB4EAC82CA7396A68D541C85D26508E83_1467783590.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1467783590;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.094 -0400", hash_original_method = "C44D806183F8681F84B21225E3DD2820", hash_generated_method = "8B00AF26402579883B44A2D87008899B")
    public FileDescriptor[] pipe() throws ErrnoException {
        FileDescriptor[] varB4EAC82CA7396A68D541C85D26508E83_353710716 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_353710716 = os.pipe();
        varB4EAC82CA7396A68D541C85D26508E83_353710716.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_353710716;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.094 -0400", hash_original_method = "5599B9E106312A6343AFDB459C1296E6", hash_generated_method = "911FAF5989F8BA555E9F9B51C0A37FA5")
    public int poll(StructPollfd[] fds, int timeoutMs) throws ErrnoException {
        int var48722583F516647909DDA26F0FCD9942_689411368 = (os.poll(fds, timeoutMs));
        addTaint(fds[0].getTaint());
        addTaint(timeoutMs);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_850876674 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_850876674;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.094 -0400", hash_original_method = "E02E4577E71F70F2C9CAE7AED1E2F8AC", hash_generated_method = "880468370E21FE1C2D88BAB9B6DEAB13")
    public int pread(FileDescriptor fd, ByteBuffer buffer, long offset) throws ErrnoException {
        int var8E37D63F084AD12D6EF74F78D0F34813_1763468100 = (os.pread(fd, buffer, offset));
        addTaint(fd.getTaint());
        addTaint(buffer.getTaint());
        addTaint(offset);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1653477114 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1653477114;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.095 -0400", hash_original_method = "77B89AD0CF3C5D71E7DD42E992F283EF", hash_generated_method = "2F6B4E98F5D89D42C63C9021F13E9073")
    public int pread(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount, long offset) throws ErrnoException {
        int var9596F97D25F40A8949B0F9D6651550A1_354629425 = (os.pread(fd, bytes, byteOffset, byteCount, offset));
        addTaint(fd.getTaint());
        addTaint(bytes[0]);
        addTaint(byteOffset);
        addTaint(byteCount);
        addTaint(offset);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1584855596 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1584855596;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.095 -0400", hash_original_method = "1CD5001FEE779ACE9E3DB9100CD609FC", hash_generated_method = "F0639AEA7F4686E0A797BB44E6FB4593")
    public int pwrite(FileDescriptor fd, ByteBuffer buffer, long offset) throws ErrnoException {
        int varBEC757109BB880DDBADF6015F3B05B2C_1758587272 = (os.pwrite(fd, buffer, offset));
        addTaint(fd.getTaint());
        addTaint(buffer.getTaint());
        addTaint(offset);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_608178319 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_608178319;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.095 -0400", hash_original_method = "F0611566A9565E2DEF97709E6B9B6418", hash_generated_method = "B88B2FEC9C431E8BFE90F76A608A34AE")
    public int pwrite(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount, long offset) throws ErrnoException {
        int var41A08F5DA487149A1F7C1270B58B9089_1469579146 = (os.pwrite(fd, bytes, byteOffset, byteCount, offset));
        addTaint(fd.getTaint());
        addTaint(bytes[0]);
        addTaint(byteOffset);
        addTaint(byteCount);
        addTaint(offset);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_299837019 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_299837019;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.095 -0400", hash_original_method = "F3C222630BE6E1046A8D40208CD4C60B", hash_generated_method = "E1EA9798D742AE0D82C9281C236F5AD9")
    public int read(FileDescriptor fd, ByteBuffer buffer) throws ErrnoException {
        int var5B8E7DC5191E81FE70C36AA027AFFCC8_1696147846 = (os.read(fd, buffer));
        addTaint(fd.getTaint());
        addTaint(buffer.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_589935465 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_589935465;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.095 -0400", hash_original_method = "21F8B1ED0ECF46FDBCE6EA979BADF2C3", hash_generated_method = "A0B16523A1E698DECE027639A542AFE3")
    public int read(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount) throws ErrnoException {
        int varE59F1DA0F28FCDF7A959280195F03910_2107634815 = (os.read(fd, bytes, byteOffset, byteCount));
        addTaint(fd.getTaint());
        addTaint(bytes[0]);
        addTaint(byteOffset);
        addTaint(byteCount);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_353552783 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_353552783;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.096 -0400", hash_original_method = "E2800F54CC6608A5FBBD1BF36223D806", hash_generated_method = "E20BA8ACA69B1ABAD88448A4CD655487")
    public int readv(FileDescriptor fd, Object[] buffers, int[] offsets, int[] byteCounts) throws ErrnoException {
        int var2494A58C76DD4D861DBB94DFA16C08A6_577658482 = (os.readv(fd, buffers, offsets, byteCounts));
        addTaint(fd.getTaint());
        addTaint(buffers[0].getTaint());
        addTaint(offsets[0]);
        addTaint(byteCounts[0]);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_238583668 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_238583668;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.096 -0400", hash_original_method = "84F37C132BD33033E9DE4E38A8430067", hash_generated_method = "9335E20CA043848919EB4B636C6AC970")
    public int recvfrom(FileDescriptor fd, ByteBuffer buffer, int flags, InetSocketAddress srcAddress) throws ErrnoException {
        int varF25721B896E31A53482415C6A924C22D_243539877 = (os.recvfrom(fd, buffer, flags, srcAddress));
        addTaint(fd.getTaint());
        addTaint(buffer.getTaint());
        addTaint(flags);
        addTaint(srcAddress.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_52210984 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_52210984;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.096 -0400", hash_original_method = "0394D475125B49320B23E75594B5C434", hash_generated_method = "E43831BF53C777AD0B3BC46568BD7682")
    public int recvfrom(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount, int flags, InetSocketAddress srcAddress) throws ErrnoException {
        int var3A59E5EE9728502FA7AEFF9DA4D0C096_1021515238 = (os.recvfrom(fd, bytes, byteOffset, byteCount, flags, srcAddress));
        addTaint(fd.getTaint());
        addTaint(bytes[0]);
        addTaint(byteOffset);
        addTaint(byteCount);
        addTaint(flags);
        addTaint(srcAddress.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1664007741 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1664007741;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.096 -0400", hash_original_method = "B12B5B450AD1F25F30BAE5F7F0558752", hash_generated_method = "B967C63C94D7FFC1BF04F3CB4178010B")
    public void remove(String path) throws ErrnoException {
        os.remove(path);
        addTaint(path.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.097 -0400", hash_original_method = "91C997D77FC3A21A4E5692674F9BE11B", hash_generated_method = "9178B74C9305F48F4B3F361B7C836E95")
    public void rename(String oldPath, String newPath) throws ErrnoException {
        os.rename(oldPath, newPath);
        addTaint(oldPath.getTaint());
        addTaint(newPath.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.097 -0400", hash_original_method = "C572D6E07635A5094C687364A5671672", hash_generated_method = "CA7E59C74B3797351A4E08171C5B275D")
    public long sendfile(FileDescriptor outFd, FileDescriptor inFd, MutableLong inOffset, long byteCount) throws ErrnoException {
        long varA7A8691BB87D642123D80A6B9B64BEE0_611255192 = (os.sendfile(outFd, inFd, inOffset, byteCount));
        addTaint(outFd.getTaint());
        addTaint(inFd.getTaint());
        addTaint(inOffset.getTaint());
        addTaint(byteCount);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1312717304 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1312717304;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.097 -0400", hash_original_method = "88066FF66E9BA638CFCEFABD2B423922", hash_generated_method = "ACFB45F74EFB44E6B112C23DE634756A")
    public int sendto(FileDescriptor fd, ByteBuffer buffer, int flags, InetAddress inetAddress, int port) throws ErrnoException {
        int var0B8E7266620C88EB24F8453B4CECD027_1092388001 = (os.sendto(fd, buffer, flags, inetAddress, port));
        addTaint(fd.getTaint());
        addTaint(buffer.getTaint());
        addTaint(flags);
        addTaint(inetAddress.getTaint());
        addTaint(port);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_254895799 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_254895799;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.097 -0400", hash_original_method = "BC2321A87F2222D5681A88900983F12D", hash_generated_method = "DD5281D003CFD246DC6C8B0D524E0D5D")
    public int sendto(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount, int flags, InetAddress inetAddress, int port) throws ErrnoException {
        int var8221F6255948EB137094ED72A9C8456A_1905437759 = (os.sendto(fd, bytes, byteOffset, byteCount, flags, inetAddress, port));
        addTaint(fd.getTaint());
        addTaint(bytes[0]);
        addTaint(byteOffset);
        addTaint(byteCount);
        addTaint(flags);
        addTaint(inetAddress.getTaint());
        addTaint(port);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1093328522 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1093328522;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.098 -0400", hash_original_method = "D0978EE2EC25CFB475F603941EE6E321", hash_generated_method = "93A356037B7F8F8A962EFD27155AD531")
    public void setegid(int egid) throws ErrnoException {
        os.setegid(egid);
        addTaint(egid);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.098 -0400", hash_original_method = "0B3E20A1D3AFC99676F4A67D4967A4C5", hash_generated_method = "699125BC0719E8B2E50628845CF93B03")
    public void seteuid(int euid) throws ErrnoException {
        os.seteuid(euid);
        addTaint(euid);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.098 -0400", hash_original_method = "5A836F22DA1ADF6236109717B09FFB11", hash_generated_method = "A512CE4B0BD677A24C1BF3C917EFDD1E")
    public void setgid(int gid) throws ErrnoException {
        os.setgid(gid);
        addTaint(gid);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.099 -0400", hash_original_method = "02713B5D8B1D9FC1829D645D7EE01360", hash_generated_method = "5ECCD84913650232A3A4D5918E275F5D")
    public void setsockoptByte(FileDescriptor fd, int level, int option, int value) throws ErrnoException {
        os.setsockoptByte(fd, level, option, value);
        addTaint(fd.getTaint());
        addTaint(level);
        addTaint(option);
        addTaint(value);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.099 -0400", hash_original_method = "859AD73B12F1FCBFB785F9C03E57780C", hash_generated_method = "B75504C71233A1B25169781E78FBEA32")
    public void setsockoptIfreq(FileDescriptor fd, int level, int option, String value) throws ErrnoException {
        os.setsockoptIfreq(fd, level, option, value);
        addTaint(fd.getTaint());
        addTaint(level);
        addTaint(option);
        addTaint(value.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.099 -0400", hash_original_method = "5882A7C612198E8B1D9CBF2EDBCD6FE7", hash_generated_method = "95BD4E07E874A3C53418A957A1DAFACC")
    public void setsockoptInt(FileDescriptor fd, int level, int option, int value) throws ErrnoException {
        os.setsockoptInt(fd, level, option, value);
        addTaint(fd.getTaint());
        addTaint(level);
        addTaint(option);
        addTaint(value);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.100 -0400", hash_original_method = "3A8741E8D07270D7E757C05217AEFD39", hash_generated_method = "966031E85B0BB54980D857F07D367B73")
    public void setsockoptIpMreqn(FileDescriptor fd, int level, int option, int value) throws ErrnoException {
        os.setsockoptIpMreqn(fd, level, option, value);
        addTaint(fd.getTaint());
        addTaint(level);
        addTaint(option);
        addTaint(value);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.100 -0400", hash_original_method = "4E1D080A99B5B2F06B7A0201A27B3E99", hash_generated_method = "677217554288830723E73088DCBC1BCB")
    public void setsockoptGroupReq(FileDescriptor fd, int level, int option, StructGroupReq value) throws ErrnoException {
        os.setsockoptGroupReq(fd, level, option, value);
        addTaint(fd.getTaint());
        addTaint(level);
        addTaint(option);
        addTaint(value.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.100 -0400", hash_original_method = "A1EC25C1EA10D3E94DA65D129945BE62", hash_generated_method = "221A8CF27FEFEF11FD706E6FDC2DC322")
    public void setsockoptLinger(FileDescriptor fd, int level, int option, StructLinger value) throws ErrnoException {
        os.setsockoptLinger(fd, level, option, value);
        addTaint(fd.getTaint());
        addTaint(level);
        addTaint(option);
        addTaint(value.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.100 -0400", hash_original_method = "B0DC8E18521874709C24B9B37D89D87C", hash_generated_method = "8928AD834D902FFB7812753AD3CD467D")
    public void setsockoptTimeval(FileDescriptor fd, int level, int option, StructTimeval value) throws ErrnoException {
        os.setsockoptTimeval(fd, level, option, value);
        addTaint(fd.getTaint());
        addTaint(level);
        addTaint(option);
        addTaint(value.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.101 -0400", hash_original_method = "554251AE1D031EE7BA07BC4F696C724A", hash_generated_method = "95DD70C53FE71F4300D8A3B4C4BAF7BE")
    public void setuid(int uid) throws ErrnoException {
        os.setuid(uid);
        addTaint(uid);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.101 -0400", hash_original_method = "5FEB3BBC8A3C8F5F8A22DE81B35CAE4D", hash_generated_method = "87B92C4EDDB60F330ECC42FB69F744BB")
    public void shutdown(FileDescriptor fd, int how) throws ErrnoException {
        os.shutdown(fd, how);
        addTaint(fd.getTaint());
        addTaint(how);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.101 -0400", hash_original_method = "558F533484D6B9C99DDFE653A920693C", hash_generated_method = "747397D53F0C5410FAFAF338FC3DF751")
    public FileDescriptor socket(int domain, int type, int protocol) throws ErrnoException {
        FileDescriptor varB4EAC82CA7396A68D541C85D26508E83_1198136878 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1198136878 = os.socket(domain, type, protocol);
        addTaint(domain);
        addTaint(type);
        addTaint(protocol);
        varB4EAC82CA7396A68D541C85D26508E83_1198136878.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1198136878;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.102 -0400", hash_original_method = "E3FE6B0CE9C868055585C77F475D7F5A", hash_generated_method = "0F6CCA0BF7AFD552963C3546504BDE6B")
    public StructStat stat(String path) throws ErrnoException {
        StructStat varB4EAC82CA7396A68D541C85D26508E83_1111282533 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1111282533 = os.stat(path);
        addTaint(path.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1111282533.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1111282533;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.102 -0400", hash_original_method = "EA8F2D89CBB0B8AF52F0D62C5DA4B5A0", hash_generated_method = "AD2D5B3E405CAED962EA67AA867D073B")
    public StructStatFs statfs(String path) throws ErrnoException {
        StructStatFs varB4EAC82CA7396A68D541C85D26508E83_1615590439 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1615590439 = os.statfs(path);
        addTaint(path.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1615590439.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1615590439;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.102 -0400", hash_original_method = "FBEAE456B3A3C776553B1F7E912CD6FB", hash_generated_method = "5FEA0DFC272745AAEF800CD55634BEF2")
    public String strerror(int errno) {
        String varB4EAC82CA7396A68D541C85D26508E83_1611048412 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1611048412 = os.strerror(errno);
        addTaint(errno);
        varB4EAC82CA7396A68D541C85D26508E83_1611048412.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1611048412;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.103 -0400", hash_original_method = "FB4E2B29DA5C665C03E887C9C86A36A3", hash_generated_method = "A481904BFAEB009329F86B88C81878BA")
    public void symlink(String oldPath, String newPath) throws ErrnoException {
        os.symlink(oldPath, newPath);
        addTaint(oldPath.getTaint());
        addTaint(newPath.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.103 -0400", hash_original_method = "9239DE14FB7F01A1D647B884E3411551", hash_generated_method = "FDEE93DFB9BCB0440AFDED2F80FED01D")
    public long sysconf(int name) {
        long var6016DF4BB18042E7D98C68C5D480E24E_208610677 = (os.sysconf(name));
        addTaint(name);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_334002800 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_334002800;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.103 -0400", hash_original_method = "E92B0E3CCB7269FEE37854B5F086E530", hash_generated_method = "36D3DB2A0A57D5224C349982B41C629A")
    public StructUtsname uname() {
        StructUtsname varB4EAC82CA7396A68D541C85D26508E83_2034951652 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2034951652 = os.uname();
        varB4EAC82CA7396A68D541C85D26508E83_2034951652.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2034951652;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.103 -0400", hash_original_method = "EC4C2322F336992223E3CB1B21022BF9", hash_generated_method = "975BF70C8DA4B091C44A88796E456BA5")
    public int waitpid(int pid, MutableInt status, int options) throws ErrnoException {
        int varE8B0A97070670E6FF43AAF48DCCF725E_1712946490 = (os.waitpid(pid, status, options));
        addTaint(pid);
        addTaint(status.getTaint());
        addTaint(options);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_836420363 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_836420363;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.104 -0400", hash_original_method = "844A22BF74026B79E5C643696D2A0D2B", hash_generated_method = "A09EC42FC6F1C79E843E48A7667A7B63")
    public int write(FileDescriptor fd, ByteBuffer buffer) throws ErrnoException {
        int var0626357AF90ACF3FB1D934D119466787_1077571992 = (os.write(fd, buffer));
        addTaint(fd.getTaint());
        addTaint(buffer.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_365218787 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_365218787;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.104 -0400", hash_original_method = "437BEB04F87A5AE656D8F235B16E36DF", hash_generated_method = "3BCF947A5958C8AA46D0D3202F87E687")
    public int write(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount) throws ErrnoException {
        int varE733C997547CF269F3AB7BAEB4D044AF_935022235 = (os.write(fd, bytes, byteOffset, byteCount));
        addTaint(fd.getTaint());
        addTaint(bytes[0]);
        addTaint(byteOffset);
        addTaint(byteCount);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_273764542 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_273764542;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.104 -0400", hash_original_method = "8BC1FDC02B601F3DB4DB2A70967C7CDC", hash_generated_method = "650A4E5FCF3C617E01B928C9005AEF7C")
    public int writev(FileDescriptor fd, Object[] buffers, int[] offsets, int[] byteCounts) throws ErrnoException {
        int var32F5E7D906A9F96A2B6412DC92928AD7_170969670 = (os.writev(fd, buffers, offsets, byteCounts));
        addTaint(fd.getTaint());
        addTaint(buffers[0].getTaint());
        addTaint(offsets[0]);
        addTaint(byteCounts[0]);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_220536966 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_220536966;
        
        
    }

    
}

