package libcore.io;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.FileDescriptor;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;

import libcore.util.MutableInt;
import libcore.util.MutableLong;

public class ForwardingOs implements Os {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:28.352 -0500", hash_original_field = "93DD8FF2BD0970E1C11B15D0D608CCBC", hash_generated_field = "AD741EF2B519FC3080D4269DB2BABC3A")

    protected  Os os;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:28.356 -0500", hash_original_method = "EC37328A0FF4DE634029572AA03E9806", hash_generated_method = "EC3D8728860309F7C905C11D3B2439D6")
    
public ForwardingOs(Os os) {
        this.os = os;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:28.358 -0500", hash_original_method = "5CF5B545FE52A5A749C69E4804E7DB37", hash_generated_method = "3871A713432485D404C9554F237744A0")
    
public FileDescriptor accept(FileDescriptor fd, InetSocketAddress peerAddress) throws ErrnoException { return os.accept(fd, peerAddress); }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:28.360 -0500", hash_original_method = "FFD94E7AFE1E3B1F76A2D696707B6857", hash_generated_method = "0A96B3396472D438726415ECF4473437")
    
public boolean access(String path, int mode) throws ErrnoException { return os.access(path, mode); }
    @DSSink({DSSinkKind.FILE})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:28.363 -0500", hash_original_method = "743422D2EB39F172C4245C8DC993624F", hash_generated_method = "71C4EAA407989047BBF56418D8AE5E61")
    
public void bind(FileDescriptor fd, InetAddress address, int port) throws ErrnoException { os.bind(fd, address, port); }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:28.365 -0500", hash_original_method = "A92F7B75A5B2B90071388C67FA677A74", hash_generated_method = "BDB0366AAC480A687EE036CCB579F88A")
    
public void chmod(String path, int mode) throws ErrnoException { os.chmod(path, mode); }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:28.367 -0500", hash_original_method = "2AF652D8862D637B4A4051CAB7CD62FB", hash_generated_method = "7557C20D5438C42A2205658B9CEDDACC")
    
public void close(FileDescriptor fd) throws ErrnoException { os.close(fd); }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:28.369 -0500", hash_original_method = "FADD460EF8DBCF58AF836CFAB2496AF1", hash_generated_method = "D7D9108EB6C6034DB6903D95AA5AE61D")
    
public void connect(FileDescriptor fd, InetAddress address, int port) throws ErrnoException { os.connect(fd, address, port); }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:28.372 -0500", hash_original_method = "6162F8350974235CF8AA9EBE9F68335F", hash_generated_method = "8F39DA7B23C82BA9EE93A5A4C07B3B80")
    
public FileDescriptor dup(FileDescriptor oldFd) throws ErrnoException { return os.dup(oldFd); }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:28.374 -0500", hash_original_method = "E190E2A3CFD75C84461AB90FFE03369B", hash_generated_method = "C38532934480A178D09DE22BAA86CDF1")
    
public FileDescriptor dup2(FileDescriptor oldFd, int newFd) throws ErrnoException { return os.dup2(oldFd, newFd); }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:28.376 -0500", hash_original_method = "5CF51EBD75B5D23C7F632D7D494380D1", hash_generated_method = "80E1FA1E701B11EE6D7D54E392EB6256")
    
public String[] environ() { return os.environ(); }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:28.378 -0500", hash_original_method = "CA43F47313D11741B7EE5D06954736CB", hash_generated_method = "92CA43CA98853D7AB96F64443004E6C2")
    
public int fcntlVoid(FileDescriptor fd, int cmd) throws ErrnoException { return os.fcntlVoid(fd, cmd); }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:28.381 -0500", hash_original_method = "6B248418A1B43AC8597DD680343F17BD", hash_generated_method = "72D785643FA310DFBBD167D35829474F")
    
public int fcntlLong(FileDescriptor fd, int cmd, long arg) throws ErrnoException { return os.fcntlLong(fd, cmd, arg); }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:28.383 -0500", hash_original_method = "28B6741D270DBCC0BDA43B4FBA76C484", hash_generated_method = "F77D6B2FF0AA040201985981E2C2642D")
    
public int fcntlFlock(FileDescriptor fd, int cmd, StructFlock arg) throws ErrnoException { return os.fcntlFlock(fd, cmd, arg); }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:28.386 -0500", hash_original_method = "D2B4800A8551761D0A11CAE1762DA39E", hash_generated_method = "60130D26EFA8564C33FCA273C4032437")
    
public void fdatasync(FileDescriptor fd) throws ErrnoException { os.fdatasync(fd); }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:28.388 -0500", hash_original_method = "0159E8BC0EB89F7B9A8B0DA54E55E46B", hash_generated_method = "A8A06EDB331BF36CEA0AF0549DA35363")
    
public StructStat fstat(FileDescriptor fd) throws ErrnoException { return os.fstat(fd); }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:28.391 -0500", hash_original_method = "1D4670A49E88E5904763EEFCF378AA9C", hash_generated_method = "57C3C77DE529CD7219780B6F5FB21BBF")
    
public StructStatFs fstatfs(FileDescriptor fd) throws ErrnoException { return os.fstatfs(fd); }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:28.393 -0500", hash_original_method = "5A3103E0191F55AC2413EF7A293382EA", hash_generated_method = "6491E3FB2F3CA27138515A31C84AFDAF")
    
public void fsync(FileDescriptor fd) throws ErrnoException { os.fsync(fd); }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:28.395 -0500", hash_original_method = "B89F13DA07AD88D9E35FDD0F8C706602", hash_generated_method = "0770E85CAABB4F8E6BE1BDA282AD2D2D")
    
public void ftruncate(FileDescriptor fd, long length) throws ErrnoException { os.ftruncate(fd, length); }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:28.397 -0500", hash_original_method = "4EDF3DB0839BDB5BB59D5BDCF6ED266B", hash_generated_method = "686F11EE60C5B7116BD54D9C34E1615E")
    
public String gai_strerror(int error) { return os.gai_strerror(error); }
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:28.400 -0500", hash_original_method = "D134969B79309E2FFE6734562680F40F", hash_generated_method = "5B6FF426293EB9AD233C01B50B0152E5")
    
public InetAddress[] getaddrinfo(String node, StructAddrinfo hints) throws GaiException { return os.getaddrinfo(node, hints); }
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:28.402 -0500", hash_original_method = "DA32E4A67BBB878517DC4C1F6AD2DE47", hash_generated_method = "B3798FC3BE783773F5A6E336FE8A0AC7")
    
public int getegid() { return os.getegid(); }
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:28.404 -0500", hash_original_method = "FAD72A6DE2CC7E2DB1B9B6FC41642D5B", hash_generated_method = "3C80A309D1E87A326960E15F84BB68E1")
    
public int geteuid() { return os.geteuid(); }
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:28.406 -0500", hash_original_method = "FADA5B6063E47C208AC2D0843F6EB847", hash_generated_method = "084475CB157E31F03D22E348B4446B9A")
    
public int getgid() { return os.getgid(); }
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:28.408 -0500", hash_original_method = "E4B66B682B354EFDCC2A2307B9973162", hash_generated_method = "6E01A6F3C1BE73C1AE0AB39A6C085987")
    
public String getenv(String name) { return os.getenv(name); }
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:28.411 -0500", hash_original_method = "95C6CCF446FE941364E9F3FC808640B5", hash_generated_method = "9FFF9217E91A309C45EB47FA3B6C5CBA")
    
public String getnameinfo(InetAddress address, int flags) throws GaiException { return os.getnameinfo(address, flags); }
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:28.413 -0500", hash_original_method = "A3B371C9A268817901795576D0A04CF6", hash_generated_method = "E964E9B223F73D82BA6D6516ED51459C")
    
public int getpid() { return os.getpid(); }
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:28.416 -0500", hash_original_method = "878D1FDE3DC9E3A460294EB2A78F5342", hash_generated_method = "2177D82BECBEBCDA8C75685C8B0FE414")
    
public int getppid() { return os.getppid(); }
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:28.418 -0500", hash_original_method = "A3C50DDCB01897A6F2E46FE623EA65A2", hash_generated_method = "3AB586BA4305E0292F99FED321F07F93")
    
public StructPasswd getpwnam(String name) throws ErrnoException { return os.getpwnam(name); }
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:28.420 -0500", hash_original_method = "F069BDB68A1BE69C49E58A44BE7A4944", hash_generated_method = "A7477AD25146288C4A39EF4C24A558A1")
    
public StructPasswd getpwuid(int uid) throws ErrnoException { return os.getpwuid(uid); }
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:28.422 -0500", hash_original_method = "C71AB83C8CB24831B3B392DF1EFA2A55", hash_generated_method = "58F1A7A63E061F679A9EC3B1266068B5")
    
public SocketAddress getsockname(FileDescriptor fd) throws ErrnoException { return os.getsockname(fd); }
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:28.424 -0500", hash_original_method = "E5D66E4A2B17F99E78F6B2E97C4D0018", hash_generated_method = "DEF6605C6797272AFA10F6CC601C2257")
    
public int getsockoptByte(FileDescriptor fd, int level, int option) throws ErrnoException { return os.getsockoptByte(fd, level, option); }
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:28.426 -0500", hash_original_method = "0CBF6F7E2BE2FF171C45C7BCFC831012", hash_generated_method = "15AAC2950D4F4E03D3495C5CA0352C81")
    
public InetAddress getsockoptInAddr(FileDescriptor fd, int level, int option) throws ErrnoException { return os.getsockoptInAddr(fd, level, option); }
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:28.428 -0500", hash_original_method = "946A87B9C2E87F4C961C36C4569A31BA", hash_generated_method = "8CF4C710880DEFBB57634CE6C182B591")
    
public int getsockoptInt(FileDescriptor fd, int level, int option) throws ErrnoException { return os.getsockoptInt(fd, level, option); }
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:28.431 -0500", hash_original_method = "EBD2988D937DD58B5AD9697AEE85A0FB", hash_generated_method = "7E8BD4BB82FA74E82E30C97590B69AD6")
    
public StructLinger getsockoptLinger(FileDescriptor fd, int level, int option) throws ErrnoException { return os.getsockoptLinger(fd, level, option); }
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:28.434 -0500", hash_original_method = "1C478D9E653EA1E4A0CA2442FA9E2156", hash_generated_method = "31E1AE1A036AD29693BF62D40C20EF69")
    
public StructTimeval getsockoptTimeval(FileDescriptor fd, int level, int option) throws ErrnoException { return os.getsockoptTimeval(fd, level, option); }
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:28.437 -0500", hash_original_method = "2F11239B76600858937301E80656F86F", hash_generated_method = "71B4CCB4CEA37B2A191E88F16A87EC5D")
    
public int getuid() { return os.getuid(); }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:28.439 -0500", hash_original_method = "FD1CFE447DC743FEF7DD120355028D01", hash_generated_method = "C4A14E76F0C5AEBBC1787AB9F64DB9BE")
    
public String if_indextoname(int index) { return os.if_indextoname(index); }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:28.441 -0500", hash_original_method = "244F6B5FD78AC80358A10468727F943C", hash_generated_method = "F016486049D5EF3ECCBA746DA1BFAE2A")
    
public InetAddress inet_pton(int family, String address) { return os.inet_pton(family, address); }
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:28.443 -0500", hash_original_method = "81C548F366545C14DF26B9A5D253BEA5", hash_generated_method = "6051ECB7D67CF73EF2727886689C4F9C")
    
public InetAddress ioctlInetAddress(FileDescriptor fd, int cmd, String interfaceName) throws ErrnoException { return os.ioctlInetAddress(fd, cmd, interfaceName); }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:28.445 -0500", hash_original_method = "B9A716BFE88006BFE54885EB5B40EF6E", hash_generated_method = "46407EFA1AD79125DC270B9E6FF5C31D")
    
public int ioctlInt(FileDescriptor fd, int cmd, MutableInt arg) throws ErrnoException { return os.ioctlInt(fd, cmd, arg); }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:28.448 -0500", hash_original_method = "E622E0FA602C62724E493B1B03996EEA", hash_generated_method = "C9165D36FC61FD07A96A1E432760CC9F")
    
public boolean isatty(FileDescriptor fd) { return os.isatty(fd); }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:28.450 -0500", hash_original_method = "39C5C221EF1E81F6FE3B9410463D5E57", hash_generated_method = "8D991654C9DD9E18CE70E2ECF29DDE94")
    
public void kill(int pid, int signal) throws ErrnoException { os.kill(pid, signal); }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:28.452 -0500", hash_original_method = "039EEA76B9DC6E04921BFC5BC270EDD9", hash_generated_method = "9ABD279C8994CF5273EB8DB36BCE7FD9")
    
public void listen(FileDescriptor fd, int backlog) throws ErrnoException { os.listen(fd, backlog); }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:28.454 -0500", hash_original_method = "3005A45BFDFB73561B6BABAEF57B12E1", hash_generated_method = "AEF0964B66ABD2B9F52977392A89CC2B")
    
public long lseek(FileDescriptor fd, long offset, int whence) throws ErrnoException { return os.lseek(fd, offset, whence); }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:28.457 -0500", hash_original_method = "F288030A10BA391FE6D7AD19552493B8", hash_generated_method = "7F2514FDFD7A0341402ECC2E8A7F141A")
    
public StructStat lstat(String path) throws ErrnoException { return os.lstat(path); }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:28.459 -0500", hash_original_method = "0D8D349CD4EFD867777AD4E59116610D", hash_generated_method = "60815B4540BD2C6711BEB820CC5AD147")
    
public void mincore(long address, long byteCount, byte[] vector) throws ErrnoException { os.mincore(address, byteCount, vector); }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:28.461 -0500", hash_original_method = "689C229BD7F4B7F5308857A16DB04D8E", hash_generated_method = "4057E945D53B903C8DB0E83E960F3288")
    
public void mkdir(String path, int mode) throws ErrnoException { os.mkdir(path, mode); }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:28.464 -0500", hash_original_method = "419517122697B0628E53EB3E2B0A6370", hash_generated_method = "4B40E969784E9566489E0CBA54C2A2A5")
    
public void mlock(long address, long byteCount) throws ErrnoException { os.mlock(address, byteCount); }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:28.466 -0500", hash_original_method = "4029BCDA0489C716FD1384F50323A029", hash_generated_method = "D9CADAD31886DA999CAD3E7F2E0566CF")
    
public long mmap(long address, long byteCount, int prot, int flags, FileDescriptor fd, long offset) throws ErrnoException { return os.mmap(address, byteCount, prot, flags, fd, offset); }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:28.468 -0500", hash_original_method = "26058ECBCE0A88D4B8D4418B78F705C5", hash_generated_method = "16D459B3A939C70B397A1908F4DBB795")
    
public void msync(long address, long byteCount, int flags) throws ErrnoException { os.msync(address, byteCount, flags); }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:28.470 -0500", hash_original_method = "12F3B374B5C7D041381B26987EDF7BE8", hash_generated_method = "AF957E90A519916604A6146DFE7412FF")
    
public void munlock(long address, long byteCount) throws ErrnoException { os.munlock(address, byteCount); }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:28.472 -0500", hash_original_method = "93EF25630433342C6922044F58653EDA", hash_generated_method = "AFE532C958C1007298D1DE3EE3BB5F5C")
    
public void munmap(long address, long byteCount) throws ErrnoException { os.munmap(address, byteCount); }
    @DSSink({DSSinkKind.FILE})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:28.475 -0500", hash_original_method = "3A1C8AE14DFE6F094F17065084A852DA", hash_generated_method = "9F7883779F0088C33462F189FBB0058F")
    
public FileDescriptor open(String path, int flags, int mode) throws ErrnoException { return os.open(path, flags, mode); }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:28.477 -0500", hash_original_method = "C44D806183F8681F84B21225E3DD2820", hash_generated_method = "979573433DA3F8C794210841FEC68A0A")
    
public FileDescriptor[] pipe() throws ErrnoException { return os.pipe(); }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:28.479 -0500", hash_original_method = "5599B9E106312A6343AFDB459C1296E6", hash_generated_method = "826AEB2345FD2FC7091BE58C6F32A431")
    
public int poll(StructPollfd[] fds, int timeoutMs) throws ErrnoException { return os.poll(fds, timeoutMs); }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:28.482 -0500", hash_original_method = "E02E4577E71F70F2C9CAE7AED1E2F8AC", hash_generated_method = "4A185ED75F66DE2D32D5CCB866ABC2D2")
    
public int pread(FileDescriptor fd, ByteBuffer buffer, long offset) throws ErrnoException { return os.pread(fd, buffer, offset); }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:28.484 -0500", hash_original_method = "77B89AD0CF3C5D71E7DD42E992F283EF", hash_generated_method = "32D6624582BBE3A0F79A612BDD1BD03C")
    
public int pread(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount, long offset) throws ErrnoException { return os.pread(fd, bytes, byteOffset, byteCount, offset); }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:28.486 -0500", hash_original_method = "1CD5001FEE779ACE9E3DB9100CD609FC", hash_generated_method = "141AC5EB9F7C069D5446A056496F6B47")
    
public int pwrite(FileDescriptor fd, ByteBuffer buffer, long offset) throws ErrnoException { return os.pwrite(fd, buffer, offset); }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:28.489 -0500", hash_original_method = "F0611566A9565E2DEF97709E6B9B6418", hash_generated_method = "A2B5332045FD6E0D11EC6696FB1A0FFD")
    
public int pwrite(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount, long offset) throws ErrnoException { return os.pwrite(fd, bytes, byteOffset, byteCount, offset); }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:28.491 -0500", hash_original_method = "F3C222630BE6E1046A8D40208CD4C60B", hash_generated_method = "9F4B9CC5D42B8DFC58AFD8EDCCF2D75B")
    
public int read(FileDescriptor fd, ByteBuffer buffer) throws ErrnoException { return os.read(fd, buffer); }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:28.493 -0500", hash_original_method = "21F8B1ED0ECF46FDBCE6EA979BADF2C3", hash_generated_method = "1F5BC28FFA87ED4892DD2D01D173D643")
    
public int read(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount) throws ErrnoException { return os.read(fd, bytes, byteOffset, byteCount); }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:28.496 -0500", hash_original_method = "E2800F54CC6608A5FBBD1BF36223D806", hash_generated_method = "393A9226619225B7F2E591152372FF5B")
    
public int readv(FileDescriptor fd, Object[] buffers, int[] offsets, int[] byteCounts) throws ErrnoException { return os.readv(fd, buffers, offsets, byteCounts); }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:28.498 -0500", hash_original_method = "84F37C132BD33033E9DE4E38A8430067", hash_generated_method = "7226923F0C33E756C2154BE1BDF966F5")
    
public int recvfrom(FileDescriptor fd, ByteBuffer buffer, int flags, InetSocketAddress srcAddress) throws ErrnoException { return os.recvfrom(fd, buffer, flags, srcAddress); }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:28.500 -0500", hash_original_method = "0394D475125B49320B23E75594B5C434", hash_generated_method = "9A00148B1ED8E97D566A870DA4745163")
    
public int recvfrom(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount, int flags, InetSocketAddress srcAddress) throws ErrnoException { return os.recvfrom(fd, bytes, byteOffset, byteCount, flags, srcAddress); }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:28.503 -0500", hash_original_method = "B12B5B450AD1F25F30BAE5F7F0558752", hash_generated_method = "E9E1FD709F69F08B201BFCC3B7CD2E6C")
    
    @DSSpec(DSCat.FILE_SYSTEM)
public void remove(String path) throws ErrnoException { os.remove(path); }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:28.505 -0500", hash_original_method = "91C997D77FC3A21A4E5692674F9BE11B", hash_generated_method = "E5FB73D16505D8B2B19A895F812629FF")
    @DSSpec(DSCat.FILE_SYSTEM)
public void rename(String oldPath, String newPath) throws ErrnoException { os.rename(oldPath, newPath); }
    @DSSink({DSSinkKind.FILE})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:28.507 -0500", hash_original_method = "C572D6E07635A5094C687364A5671672", hash_generated_method = "9210DAC481869179E325D412403D65FF")
    
public long sendfile(FileDescriptor outFd, FileDescriptor inFd, MutableLong inOffset, long byteCount) throws ErrnoException { return os.sendfile(outFd, inFd, inOffset, byteCount); }
    @DSSink({DSSinkKind.FILE})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:28.510 -0500", hash_original_method = "88066FF66E9BA638CFCEFABD2B423922", hash_generated_method = "210D71E5A64D693EF323FE13DF114FBB")
    
public int sendto(FileDescriptor fd, ByteBuffer buffer, int flags, InetAddress inetAddress, int port) throws ErrnoException { return os.sendto(fd, buffer, flags, inetAddress, port); }
    @DSSink({DSSinkKind.FILE})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:28.512 -0500", hash_original_method = "BC2321A87F2222D5681A88900983F12D", hash_generated_method = "30E7ED50918659019E777D297A4F027B")
    
public int sendto(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount, int flags, InetAddress inetAddress, int port) throws ErrnoException { return os.sendto(fd, bytes, byteOffset, byteCount, flags, inetAddress, port); }
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:28.515 -0500", hash_original_method = "D0978EE2EC25CFB475F603941EE6E321", hash_generated_method = "4766E0245DFD1B5F6CACB45D5B1CE9AD")
    
public void setegid(int egid) throws ErrnoException { os.setegid(egid); }
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:28.517 -0500", hash_original_method = "0B3E20A1D3AFC99676F4A67D4967A4C5", hash_generated_method = "CEFD4AAFE47A6AB86C2AB48192C6F628")
    
public void seteuid(int euid) throws ErrnoException { os.seteuid(euid); }
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:28.519 -0500", hash_original_method = "5A836F22DA1ADF6236109717B09FFB11", hash_generated_method = "ED95594EAAE4DF50A855B838BBCFA5F9")
    
public void setgid(int gid) throws ErrnoException { os.setgid(gid); }
    @DSSink({DSSinkKind.FILE})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:28.522 -0500", hash_original_method = "02713B5D8B1D9FC1829D645D7EE01360", hash_generated_method = "C1C18650652E19BAA1AF14BE22F74BFC")
    
public void setsockoptByte(FileDescriptor fd, int level, int option, int value) throws ErrnoException { os.setsockoptByte(fd, level, option, value); }
    @DSSink({DSSinkKind.FILE})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:28.524 -0500", hash_original_method = "859AD73B12F1FCBFB785F9C03E57780C", hash_generated_method = "E99886C0DEF8A685FFA3A626D457CD51")
    
public void setsockoptIfreq(FileDescriptor fd, int level, int option, String value) throws ErrnoException { os.setsockoptIfreq(fd, level, option, value); }
    @DSSink({DSSinkKind.FILE})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:28.527 -0500", hash_original_method = "5882A7C612198E8B1D9CBF2EDBCD6FE7", hash_generated_method = "9DA655902BF199DA7AAB0C56600A2421")
    
public void setsockoptInt(FileDescriptor fd, int level, int option, int value) throws ErrnoException { os.setsockoptInt(fd, level, option, value); }
    @DSSink({DSSinkKind.FILE})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:28.529 -0500", hash_original_method = "3A8741E8D07270D7E757C05217AEFD39", hash_generated_method = "1FE3AE74050FEE6FA5034CC807271044")
    
public void setsockoptIpMreqn(FileDescriptor fd, int level, int option, int value) throws ErrnoException { os.setsockoptIpMreqn(fd, level, option, value); }
    @DSSink({DSSinkKind.FILE})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:28.531 -0500", hash_original_method = "4E1D080A99B5B2F06B7A0201A27B3E99", hash_generated_method = "DA83831D05C715F7B422EF47CF0A412B")
    
public void setsockoptGroupReq(FileDescriptor fd, int level, int option, StructGroupReq value) throws ErrnoException { os.setsockoptGroupReq(fd, level, option, value); }
    @DSSink({DSSinkKind.FILE})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:28.533 -0500", hash_original_method = "A1EC25C1EA10D3E94DA65D129945BE62", hash_generated_method = "D113D834368DE9DE282D238E1C043E88")
    
public void setsockoptLinger(FileDescriptor fd, int level, int option, StructLinger value) throws ErrnoException { os.setsockoptLinger(fd, level, option, value); }
    @DSSink({DSSinkKind.FILE})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:28.536 -0500", hash_original_method = "B0DC8E18521874709C24B9B37D89D87C", hash_generated_method = "89AE5AC6DABF61A935158397B14314EA")
    
public void setsockoptTimeval(FileDescriptor fd, int level, int option, StructTimeval value) throws ErrnoException { os.setsockoptTimeval(fd, level, option, value); }
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:28.538 -0500", hash_original_method = "554251AE1D031EE7BA07BC4F696C724A", hash_generated_method = "AAB537F3F4A4527FEDB885DB035F3177")
    
public void setuid(int uid) throws ErrnoException { os.setuid(uid); }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:28.540 -0500", hash_original_method = "5FEB3BBC8A3C8F5F8A22DE81B35CAE4D", hash_generated_method = "D499DCC6483DE7D5C39E72B43F937AE6")
    
public void shutdown(FileDescriptor fd, int how) throws ErrnoException { os.shutdown(fd, how); }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:28.542 -0500", hash_original_method = "558F533484D6B9C99DDFE653A920693C", hash_generated_method = "2E78D13D6A0EB09EEF68E2CF7750394E")
    
public FileDescriptor socket(int domain, int type, int protocol) throws ErrnoException { return os.socket(domain, type, protocol); }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:28.545 -0500", hash_original_method = "E3FE6B0CE9C868055585C77F475D7F5A", hash_generated_method = "E3016EE26504F6903707CE285BE4E18D")
    
public StructStat stat(String path) throws ErrnoException { return os.stat(path); }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:28.547 -0500", hash_original_method = "EA8F2D89CBB0B8AF52F0D62C5DA4B5A0", hash_generated_method = "7594CF5CA7A87B76E3CB5E7025B440DE")
    
public StructStatFs statfs(String path) throws ErrnoException { return os.statfs(path); }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:28.549 -0500", hash_original_method = "FBEAE456B3A3C776553B1F7E912CD6FB", hash_generated_method = "5EED1E7F623333459384FDFECE46A112")
    
public String strerror(int errno) { return os.strerror(errno); }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:28.552 -0500", hash_original_method = "FB4E2B29DA5C665C03E887C9C86A36A3", hash_generated_method = "291112ED4F536E1104BB601E3077FF20")
    
public void symlink(String oldPath, String newPath) throws ErrnoException { os.symlink(oldPath, newPath); }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:28.554 -0500", hash_original_method = "9239DE14FB7F01A1D647B884E3411551", hash_generated_method = "4AEB3D21837937BBDA5672E90B2D70C5")
    
public long sysconf(int name) { return os.sysconf(name); }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:28.556 -0500", hash_original_method = "E92B0E3CCB7269FEE37854B5F086E530", hash_generated_method = "750A61E951DFC9D27E6B9A21E9CDBC99")
    
public StructUtsname uname() { return os.uname(); }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:28.559 -0500", hash_original_method = "EC4C2322F336992223E3CB1B21022BF9", hash_generated_method = "E9E819FAFB8845664878B6CD1C32DE4B")
    
public int waitpid(int pid, MutableInt status, int options) throws ErrnoException { return os.waitpid(pid, status, options); }
    @DSSink({DSSinkKind.FILE})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:28.561 -0500", hash_original_method = "844A22BF74026B79E5C643696D2A0D2B", hash_generated_method = "8D350D3F70A91350AA725031C4B66D18")
    
public int write(FileDescriptor fd, ByteBuffer buffer) throws ErrnoException { return os.write(fd, buffer); }
    @DSSink({DSSinkKind.FILE})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:28.563 -0500", hash_original_method = "437BEB04F87A5AE656D8F235B16E36DF", hash_generated_method = "C1CD7E6CEFBA9362229C67090E7CAE3B")
    
public int write(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount) throws ErrnoException { return os.write(fd, bytes, byteOffset, byteCount); }
    @DSSink({DSSinkKind.FILE})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:28.565 -0500", hash_original_method = "8BC1FDC02B601F3DB4DB2A70967C7CDC", hash_generated_method = "603839B5332CB7FB6407521AC7E56C38")
    
public int writev(FileDescriptor fd, Object[] buffers, int[] offsets, int[] byteCounts) throws ErrnoException { return os.writev(fd, buffers, offsets, byteCounts); }
    
}

