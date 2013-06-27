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
import java.nio.NioUtils;
import libcore.util.MutableInt;
import libcore.util.MutableLong;

public final class Posix implements Os {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.414 -0400", hash_original_method = "4046CDE00BB837810E8AFBFF17A6CE8F", hash_generated_method = "05221F2C631AA96E1462A4F7CC11A1BC")
      Posix() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.421 -0400", hash_original_method = "3FF894EBDB6D10C08E17FEF79D8BBDA9", hash_generated_method = "CD0A84B225A700801CB0CB5C048B5F64")
    public FileDescriptor accept(FileDescriptor fd, InetSocketAddress peerAddress) throws ErrnoException {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.422 -0400", hash_original_method = "B1689CE6DA8AD962BE72C0197D9C07BB", hash_generated_method = "0098EBD9685B51620AB2B74D3A80C50B")
    public boolean access(String path, int mode) throws ErrnoException {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1485054072 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1485054072;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.424 -0400", hash_original_method = "291C8049FE6F5CDE681BB5AEA2008B38", hash_generated_method = "84FB031E5366E9FCB162C111EEB27C87")
    public void bind(FileDescriptor fd, InetAddress address, int port) throws ErrnoException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.425 -0400", hash_original_method = "C6B53F2282285C6075341EF2C607CF79", hash_generated_method = "1ADDDBE52AB61E2DC2D40B06BD38924E")
    public void chmod(String path, int mode) throws ErrnoException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.425 -0400", hash_original_method = "5621A98DBDE11BB13B9D88FD5C4303F9", hash_generated_method = "88AC1D1AA0DA20420EB3EC3F557D0CE2")
    public void close(FileDescriptor fd) throws ErrnoException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.425 -0400", hash_original_method = "583B21CF7E43DBF5EACD223A833123C4", hash_generated_method = "32A14EC0714501BE2AD1DD1B23C061AD")
    public void connect(FileDescriptor fd, InetAddress address, int port) throws ErrnoException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.425 -0400", hash_original_method = "3C30A8714976314FBC047CABB70B8D73", hash_generated_method = "E9F5AF0FB41B7707675BC76D1920487E")
    public FileDescriptor dup(FileDescriptor oldFd) throws ErrnoException {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.425 -0400", hash_original_method = "3FF27FFFD1EDB0C110A074DD6B27552E", hash_generated_method = "CA84B272541AD90B218B5342DA7CD207")
    public FileDescriptor dup2(FileDescriptor oldFd, int newFd) throws ErrnoException {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.428 -0400", hash_original_method = "76B056F20AEC72841BA98095F8E6CB34", hash_generated_method = "ADADA30B919F80A500FE6D3D2633BB36")
    public String[] environ() {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.428 -0400", hash_original_method = "2CB0275F8932D4CF3644D073C3F0700F", hash_generated_method = "0F561E3D90EDEC72801ECF343A96CAD5")
    public int fcntlVoid(FileDescriptor fd, int cmd) throws ErrnoException {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1106625764 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1106625764;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.428 -0400", hash_original_method = "2A7DB0B256B2976732DDA9A901297EFA", hash_generated_method = "4EE1E2E735EF6F4952D27066C4F8B242")
    public int fcntlLong(FileDescriptor fd, int cmd, long arg) throws ErrnoException {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1128420595 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1128420595;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.428 -0400", hash_original_method = "5842C7622D740E7A11EA29095C58FEF2", hash_generated_method = "A4C1D129401BF380E5B1CFBE156B188D")
    public int fcntlFlock(FileDescriptor fd, int cmd, StructFlock arg) throws ErrnoException {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1525821653 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1525821653;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.429 -0400", hash_original_method = "CC5ECBC11DCDAEE11F3D1714EA5105D5", hash_generated_method = "2476A3C255789407A2CB89613FFC0767")
    public void fdatasync(FileDescriptor fd) throws ErrnoException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.432 -0400", hash_original_method = "285E3CF7F1EFC8C330731E11EF4C59B4", hash_generated_method = "FB432B0A46E67C4A515FC7D39713ADEE")
    public StructStat fstat(FileDescriptor fd) throws ErrnoException {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.432 -0400", hash_original_method = "1A9BE1A7FA5485B333D3854795E798C3", hash_generated_method = "2D430EC1E5F2AB304F57C6A4D3ACACFD")
    public StructStatFs fstatfs(FileDescriptor fd) throws ErrnoException {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.432 -0400", hash_original_method = "BC5DB2B4AC1C25097A3FF5E2C6AF2CA8", hash_generated_method = "E54FD0DB1F8F4382C4F5D3AC3B6E8F36")
    public void fsync(FileDescriptor fd) throws ErrnoException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.432 -0400", hash_original_method = "C3B05E353984E75A36400D4268798B4D", hash_generated_method = "4E6152073BE3DCA66E0B3ACC6C860A59")
    public void ftruncate(FileDescriptor fd, long length) throws ErrnoException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.432 -0400", hash_original_method = "26A40D218A150DBB5E3B431436FD5A7B", hash_generated_method = "27F87296D375B8957098A9ECC28029AB")
    public String gai_strerror(int error) {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.433 -0400", hash_original_method = "40F18080B746539908D74665104D4EA0", hash_generated_method = "130FA52FE5275831CC890F85A8CD5D33")
    public InetAddress[] getaddrinfo(String node, StructAddrinfo hints) throws GaiException {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.434 -0400", hash_original_method = "B351A98E9308B82B72BD8C1A77C5DADB", hash_generated_method = "25CD6FE2277DDE00B4142420EB05D65D")
    public int getegid() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1399297744 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1399297744;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.434 -0400", hash_original_method = "03FF5CC42F38A66A948C17532C044A2D", hash_generated_method = "8ADA070C3E9635EC86FC1A6BD3C31BD2")
    public int geteuid() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1717548862 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1717548862;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.434 -0400", hash_original_method = "82D0BD1E53FB93AB39C412F5615316CA", hash_generated_method = "E4435D2EDB3A30805DDEE35FE3281818")
    public int getgid() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1042752532 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1042752532;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.435 -0400", hash_original_method = "ABE371B1B9ED1CAFA0922C4EB05C6BA3", hash_generated_method = "06988C5468266BFC53F857DF1F3A7080")
    public String getenv(String name) {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.436 -0400", hash_original_method = "A0AFA0E6B104A41B1981D0BE816BBE02", hash_generated_method = "5E0DD6AFD3DD827B3E5DE5816011CF57")
    public String getnameinfo(InetAddress address, int flags) throws GaiException {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.436 -0400", hash_original_method = "ED1FF6EE6302372A02F6AB9DF837F424", hash_generated_method = "C1ECDEB224297C0C56957C22170E89B1")
    public int getpid() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1800828244 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1800828244;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.436 -0400", hash_original_method = "E9C872CD5783C25015966D177C4AF8C6", hash_generated_method = "362079A6DF73FAD1E6A8FC2427E2B987")
    public int getppid() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_531672801 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_531672801;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.436 -0400", hash_original_method = "CC95F691F046B008F87F75EBB754B9F4", hash_generated_method = "9940A20D3850D7F380FC87AC6AF2F6E5")
    public StructPasswd getpwnam(String name) throws ErrnoException {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.437 -0400", hash_original_method = "F193108F2C48DAFAA33D43EBB961E0C4", hash_generated_method = "59D5893F141FDA927A6CE1BDE49A8CA7")
    public StructPasswd getpwuid(int uid) throws ErrnoException {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.443 -0400", hash_original_method = "BDE1CE7D74C0BBEFDC894A32FA56505C", hash_generated_method = "FEAEAFB793CE2332A26745CF5809AB9A")
    public SocketAddress getsockname(FileDescriptor fd) throws ErrnoException {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.446 -0400", hash_original_method = "51446225C69A8CF648D53B0005AE4AA4", hash_generated_method = "AA665B352861AE9E00642F0EB4976870")
    public int getsockoptByte(FileDescriptor fd, int level, int option) throws ErrnoException {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_987350790 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_987350790;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.446 -0400", hash_original_method = "5BB8092DA4409A5D55882AE524C48CC0", hash_generated_method = "D3C69B8918D913F313F29C114573160B")
    public InetAddress getsockoptInAddr(FileDescriptor fd, int level, int option) throws ErrnoException {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.452 -0400", hash_original_method = "B939E72BF03DDCEDAC639A7621114578", hash_generated_method = "358455C89EA4ACE9EF06DD62919518A6")
    public int getsockoptInt(FileDescriptor fd, int level, int option) throws ErrnoException {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_722915001 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_722915001;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.452 -0400", hash_original_method = "FEC6121EA2A897FBB99121F96B439FBB", hash_generated_method = "F60821EF1BF0B8831D7AAFEE843DD949")
    public StructLinger getsockoptLinger(FileDescriptor fd, int level, int option) throws ErrnoException {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.452 -0400", hash_original_method = "F02C71E9B42FAB3C0C2F8E812A8DAE0B", hash_generated_method = "6CA79EDA1D97037C4E5A07F27DEFAAF6")
    public StructTimeval getsockoptTimeval(FileDescriptor fd, int level, int option) throws ErrnoException {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.452 -0400", hash_original_method = "DCBAE976FF6D195847EC9B9CCBB16DA2", hash_generated_method = "F89B271804F065F394017EE887A73219")
    public int getuid() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_922116908 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_922116908;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.452 -0400", hash_original_method = "BC4349F875DD5C315A8CC9563ABD32ED", hash_generated_method = "5D3B61863086951BE5EE225ADA00E818")
    public String if_indextoname(int index) {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.454 -0400", hash_original_method = "2643CEE6EE9643256D8BA72042097190", hash_generated_method = "45DBEA6F2642076EEB7596214278AC69")
    public InetAddress inet_pton(int family, String address) {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.454 -0400", hash_original_method = "E90DEAC8BD65E718B0E2ACEED6C5AEE3", hash_generated_method = "BBFCB604834C488636C059270740197B")
    public InetAddress ioctlInetAddress(FileDescriptor fd, int cmd, String interfaceName) throws ErrnoException {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.454 -0400", hash_original_method = "06336F68D97266AEF577672F8C03A8E4", hash_generated_method = "5D5CF2B54C951CE6FDE0D218F2A7BA22")
    public int ioctlInt(FileDescriptor fd, int cmd, MutableInt arg) throws ErrnoException {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2096285925 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2096285925;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.454 -0400", hash_original_method = "94B275389FB7735E79DD0606BB6663FC", hash_generated_method = "9536AACDE637C944FB55ACD24CCC0AFA")
    public boolean isatty(FileDescriptor fd) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2094349219 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2094349219;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.455 -0400", hash_original_method = "77BC6E1CDAEA7EC218D4C88B6DD6F628", hash_generated_method = "F6F6E534CA3E6662FA9A588696A9D1A5")
    public void kill(int pid, int signal) throws ErrnoException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.456 -0400", hash_original_method = "6ED23D1EA76BF029EEF21B4EAFA6CFF2", hash_generated_method = "DAA83A0CD96D69C2B0AA6D7503222609")
    public void listen(FileDescriptor fd, int backlog) throws ErrnoException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.456 -0400", hash_original_method = "6DE073E1DD2161D7E507CF5C1E8B8B5C", hash_generated_method = "87695553055EF84878FFE52BE48C8CE4")
    public long lseek(FileDescriptor fd, long offset, int whence) throws ErrnoException {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_621545009 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_621545009;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.456 -0400", hash_original_method = "D639C215CF59CE0021DA2A9DC0F695A4", hash_generated_method = "E0143F1BAA64A6BF1E9A18B98E107A79")
    public StructStat lstat(String path) throws ErrnoException {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.456 -0400", hash_original_method = "EC9A299C6214A51B56DA51B591F6FF36", hash_generated_method = "F10B9DD324CECF0A86818AC7CC0C8EAB")
    public void mincore(long address, long byteCount, byte[] vector) throws ErrnoException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.461 -0400", hash_original_method = "4CC22C39A827987000370BD10B3B7F89", hash_generated_method = "5A7BEC510CF43D25B53554F6D2F2A2AE")
    public void mkdir(String path, int mode) throws ErrnoException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.462 -0400", hash_original_method = "40B753FBD702B9115A8CFFA4EBDDD434", hash_generated_method = "ED2C99AFEF903695150B0308D01F5D2B")
    public void mlock(long address, long byteCount) throws ErrnoException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.462 -0400", hash_original_method = "51925E7C1A595364A34E53403D531BF1", hash_generated_method = "EA562F133079CD0236B97DAE4D9B4981")
    public long mmap(long address, long byteCount, int prot, int flags, FileDescriptor fd, long offset) throws ErrnoException {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_273434039 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_273434039;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.462 -0400", hash_original_method = "E2366875958D829A580E669A2DB1A4B1", hash_generated_method = "8864C229845A0E2CC8F7FDA72470613D")
    public void msync(long address, long byteCount, int flags) throws ErrnoException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.462 -0400", hash_original_method = "300DE062DB1D5D96D86ACEAAE1343E18", hash_generated_method = "E47F369491E1B5E634DDD0810DD2F19A")
    public void munlock(long address, long byteCount) throws ErrnoException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.463 -0400", hash_original_method = "FD321BF6752ECFAABCD6429010BD098F", hash_generated_method = "08EB766C3DA5DD7C92B90F48070EBB89")
    public void munmap(long address, long byteCount) throws ErrnoException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.464 -0400", hash_original_method = "B03C285733E86D432A31E9556E29D38C", hash_generated_method = "3895485A804EB3F7CACE7511B2B310A8")
    public FileDescriptor open(String path, int flags, int mode) throws ErrnoException {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.464 -0400", hash_original_method = "15C3A12A736BB4281EA7C1CDE4AB9480", hash_generated_method = "656244847670CC9BF6362B959913631F")
    public FileDescriptor[] pipe() throws ErrnoException {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.464 -0400", hash_original_method = "A333C05E603FD568E448FA55BD420BEE", hash_generated_method = "C898EB759EA21790EBB3F3B4CC454CC3")
    public int poll(StructPollfd[] fds, int timeoutMs) throws ErrnoException {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1398016150 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1398016150;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.465 -0400", hash_original_method = "FD23B60A9051753476B14299BED1F849", hash_generated_method = "1100EB9906F5ACD2B0F82D1DD878BC3F")
    public int pread(FileDescriptor fd, ByteBuffer buffer, long offset) throws ErrnoException {
        {
            boolean var21D6A43A19BB11FD75F2555CEDDC72D3_269326988 = (buffer.isDirect());
            {
                int var8E7907A41BEF94A8EBD28CB040D098F0_293326589 = (preadBytes(fd, buffer, buffer.position(), buffer.remaining(), offset));
            } //End block
            {
                int var1F069D630372EF5D70684AA69ABBB191_809567231 = (preadBytes(fd, NioUtils.unsafeArray(buffer), NioUtils.unsafeArrayOffset(buffer) + buffer.position(), buffer.remaining(), offset));
            } //End block
        } //End collapsed parenthetic
        addTaint(fd.getTaint());
        addTaint(buffer.getTaint());
        addTaint(offset);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_929041759 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_929041759;
        // ---------- Original Method ----------
        //if (buffer.isDirect()) {
            //return preadBytes(fd, buffer, buffer.position(), buffer.remaining(), offset);
        //} else {
            //return preadBytes(fd, NioUtils.unsafeArray(buffer), NioUtils.unsafeArrayOffset(buffer) + buffer.position(), buffer.remaining(), offset);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.470 -0400", hash_original_method = "4B8706AF5748B9EE5E9BCCA6FC3C73C0", hash_generated_method = "1102DA2F026D913A37AB88D38506CCCA")
    public int pread(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount, long offset) throws ErrnoException {
        int varCF530DD83FC2922F479A426BEFE4CB6B_1366451958 = (preadBytes(fd, bytes, byteOffset, byteCount, offset));
        addTaint(fd.getTaint());
        addTaint(bytes[0]);
        addTaint(byteOffset);
        addTaint(byteCount);
        addTaint(offset);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_75971607 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_75971607;
        // ---------- Original Method ----------
        //return preadBytes(fd, bytes, byteOffset, byteCount, offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.470 -0400", hash_original_method = "5819B25FAD4FEDA7F174A32C15365436", hash_generated_method = "DE41024681AB3EB4409C007B0DFA51CD")
    private int preadBytes(FileDescriptor fd, Object buffer, int bufferOffset, int byteCount, long offset) throws ErrnoException {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1960765442 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1960765442;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.473 -0400", hash_original_method = "DB8AC8A16E91B9F291442450334BCFF2", hash_generated_method = "87D280037C94DC4EE028A01C06618E87")
    public int pwrite(FileDescriptor fd, ByteBuffer buffer, long offset) throws ErrnoException {
        {
            boolean var21D6A43A19BB11FD75F2555CEDDC72D3_1913178333 = (buffer.isDirect());
            {
                int var87D5C3FD697C182EDD756D3EFF6529D7_1964331544 = (pwriteBytes(fd, buffer, buffer.position(), buffer.remaining(), offset));
            } //End block
            {
                int var6DAE9A5C537D89AF40EB6C242AD74611_1773898294 = (pwriteBytes(fd, NioUtils.unsafeArray(buffer), NioUtils.unsafeArrayOffset(buffer) + buffer.position(), buffer.remaining(), offset));
            } //End block
        } //End collapsed parenthetic
        addTaint(fd.getTaint());
        addTaint(buffer.getTaint());
        addTaint(offset);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_753412092 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_753412092;
        // ---------- Original Method ----------
        //if (buffer.isDirect()) {
            //return pwriteBytes(fd, buffer, buffer.position(), buffer.remaining(), offset);
        //} else {
            //return pwriteBytes(fd, NioUtils.unsafeArray(buffer), NioUtils.unsafeArrayOffset(buffer) + buffer.position(), buffer.remaining(), offset);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.474 -0400", hash_original_method = "364FA462AFF3FCDD2B79B5A0A9405455", hash_generated_method = "1AB73AE28E688C8CCEFB55B57735D964")
    public int pwrite(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount, long offset) throws ErrnoException {
        int varFC5C8D1266385A06B48EE648ACD7657C_1032489041 = (pwriteBytes(fd, bytes, byteOffset, byteCount, offset));
        addTaint(fd.getTaint());
        addTaint(bytes[0]);
        addTaint(byteOffset);
        addTaint(byteCount);
        addTaint(offset);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1272955796 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1272955796;
        // ---------- Original Method ----------
        //return pwriteBytes(fd, bytes, byteOffset, byteCount, offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.474 -0400", hash_original_method = "90B6FC1B27EC82D887BE52674747E195", hash_generated_method = "8757068A3FE6B864FB5EAC5A5FD410DE")
    private int pwriteBytes(FileDescriptor fd, Object buffer, int bufferOffset, int byteCount, long offset) throws ErrnoException {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_839593364 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_839593364;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.474 -0400", hash_original_method = "ADE2F5685BF490A50DE36063F7A06769", hash_generated_method = "128399C08F17EF8F99CB43DC89AC40DF")
    public int read(FileDescriptor fd, ByteBuffer buffer) throws ErrnoException {
        {
            boolean var21D6A43A19BB11FD75F2555CEDDC72D3_1155197184 = (buffer.isDirect());
            {
                int varD5A85510F41F9F59964F2A7FD9630E4C_2075039670 = (readBytes(fd, buffer, buffer.position(), buffer.remaining()));
            } //End block
            {
                int varC2696D40F0D039BC87FD96259E5276FD_1265713195 = (readBytes(fd, NioUtils.unsafeArray(buffer), NioUtils.unsafeArrayOffset(buffer) + buffer.position(), buffer.remaining()));
            } //End block
        } //End collapsed parenthetic
        addTaint(fd.getTaint());
        addTaint(buffer.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_732852770 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_732852770;
        // ---------- Original Method ----------
        //if (buffer.isDirect()) {
            //return readBytes(fd, buffer, buffer.position(), buffer.remaining());
        //} else {
            //return readBytes(fd, NioUtils.unsafeArray(buffer), NioUtils.unsafeArrayOffset(buffer) + buffer.position(), buffer.remaining());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.478 -0400", hash_original_method = "6168115C79D46336D7C888D619663F88", hash_generated_method = "C65898741779DF6168FB5D3C76D6B5E6")
    public int read(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount) throws ErrnoException {
        int varAF7FBEB1A05EE593C49B78D715290282_1163339532 = (readBytes(fd, bytes, byteOffset, byteCount));
        addTaint(fd.getTaint());
        addTaint(bytes[0]);
        addTaint(byteOffset);
        addTaint(byteCount);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1945697141 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1945697141;
        // ---------- Original Method ----------
        //return readBytes(fd, bytes, byteOffset, byteCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.488 -0400", hash_original_method = "2C7E892AABA7BE06DDD2C6AC692575BC", hash_generated_method = "1267E7C15C8520DD4B2A5539029BF080")
    private int readBytes(FileDescriptor fd, Object buffer, int offset, int byteCount) throws ErrnoException {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1867719610 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1867719610;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.489 -0400", hash_original_method = "D5205EB48193928ACF79029A7B33E86B", hash_generated_method = "639215E6B40FE8580B809AFA9F973E9E")
    public int readv(FileDescriptor fd, Object[] buffers, int[] offsets, int[] byteCounts) throws ErrnoException {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_811987143 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_811987143;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.489 -0400", hash_original_method = "41329575D83AD4CCCAB565E77BA083D5", hash_generated_method = "9951EA7776E31B86D0357110BA044D26")
    public int recvfrom(FileDescriptor fd, ByteBuffer buffer, int flags, InetSocketAddress srcAddress) throws ErrnoException {
        {
            boolean var21D6A43A19BB11FD75F2555CEDDC72D3_1883230888 = (buffer.isDirect());
            {
                int varF31574244E582FAAC1D4E5A3117CCAD5_1608401561 = (recvfromBytes(fd, buffer, buffer.position(), buffer.remaining(), flags, srcAddress));
            } //End block
            {
                int var754A91E49CCFCF0B12E0E37D924384F6_916828180 = (recvfromBytes(fd, NioUtils.unsafeArray(buffer), NioUtils.unsafeArrayOffset(buffer) + buffer.position(), buffer.remaining(), flags, srcAddress));
            } //End block
        } //End collapsed parenthetic
        addTaint(fd.getTaint());
        addTaint(buffer.getTaint());
        addTaint(flags);
        addTaint(srcAddress.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_521839872 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_521839872;
        // ---------- Original Method ----------
        //if (buffer.isDirect()) {
            //return recvfromBytes(fd, buffer, buffer.position(), buffer.remaining(), flags, srcAddress);
        //} else {
            //return recvfromBytes(fd, NioUtils.unsafeArray(buffer), NioUtils.unsafeArrayOffset(buffer) + buffer.position(), buffer.remaining(), flags, srcAddress);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.490 -0400", hash_original_method = "D6B3FC14ED62FEA7873773B8EF3E6A7B", hash_generated_method = "E5586792C226947F849C631719E1BB78")
    public int recvfrom(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount, int flags, InetSocketAddress srcAddress) throws ErrnoException {
        int var5C3B514BF02C0C51E1C7926B1634D11C_5559410 = (recvfromBytes(fd, bytes, byteOffset, byteCount, flags, srcAddress));
        addTaint(fd.getTaint());
        addTaint(bytes[0]);
        addTaint(byteOffset);
        addTaint(byteCount);
        addTaint(flags);
        addTaint(srcAddress.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_22825513 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_22825513;
        // ---------- Original Method ----------
        //return recvfromBytes(fd, bytes, byteOffset, byteCount, flags, srcAddress);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.490 -0400", hash_original_method = "4ADC9C5F635814CDC8DA4D81B23D96F7", hash_generated_method = "CE6E87574048B99C9155558407EC9C17")
    private int recvfromBytes(FileDescriptor fd, Object buffer, int byteOffset, int byteCount, int flags, InetSocketAddress srcAddress) throws ErrnoException {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1734343151 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1734343151;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.490 -0400", hash_original_method = "C4D2972D60AD59B1B88202B59332518F", hash_generated_method = "F785749D71099D3C2EF1A4F3482E2FC9")
    public void remove(String path) throws ErrnoException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.490 -0400", hash_original_method = "79CCF6DA9C97D5D1A767D340D63FA141", hash_generated_method = "ECFA7C07C31807064D12083B534138D1")
    public void rename(String oldPath, String newPath) throws ErrnoException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.490 -0400", hash_original_method = "9AFCCF531361D938553CC3693890CE79", hash_generated_method = "6CC8B380CE4E81DB79F2C006A8D0B9CA")
    public long sendfile(FileDescriptor outFd, FileDescriptor inFd, MutableLong inOffset, long byteCount) throws ErrnoException {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1293120980 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1293120980;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.492 -0400", hash_original_method = "CE9DE10B0135BB1F72B6E5CF17271781", hash_generated_method = "ADAE642DF6BC80BD6A8ED5ECF8AF1F08")
    public int sendto(FileDescriptor fd, ByteBuffer buffer, int flags, InetAddress inetAddress, int port) throws ErrnoException {
        {
            boolean var21D6A43A19BB11FD75F2555CEDDC72D3_1596711132 = (buffer.isDirect());
            {
                int var5E9D1647C6154DCE995D5EEEB1605F7B_932256474 = (sendtoBytes(fd, buffer, buffer.position(), buffer.remaining(), flags, inetAddress, port));
            } //End block
            {
                int var454BEDFAD70DADFAA662DB20DF483B42_1622067420 = (sendtoBytes(fd, NioUtils.unsafeArray(buffer), NioUtils.unsafeArrayOffset(buffer) + buffer.position(), buffer.remaining(), flags, inetAddress, port));
            } //End block
        } //End collapsed parenthetic
        addTaint(fd.getTaint());
        addTaint(buffer.getTaint());
        addTaint(flags);
        addTaint(inetAddress.getTaint());
        addTaint(port);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1089428745 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1089428745;
        // ---------- Original Method ----------
        //if (buffer.isDirect()) {
            //return sendtoBytes(fd, buffer, buffer.position(), buffer.remaining(), flags, inetAddress, port);
        //} else {
            //return sendtoBytes(fd, NioUtils.unsafeArray(buffer), NioUtils.unsafeArrayOffset(buffer) + buffer.position(), buffer.remaining(), flags, inetAddress, port);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.492 -0400", hash_original_method = "23CCF7407B7F91C60BE72C6923799443", hash_generated_method = "40AEBF20E30A0CC4C7B537A6999A61EA")
    public int sendto(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount, int flags, InetAddress inetAddress, int port) throws ErrnoException {
        int varE214C015B4D6A01301684BB848AD3BF2_890991803 = (sendtoBytes(fd, bytes, byteOffset, byteCount, flags, inetAddress, port));
        addTaint(fd.getTaint());
        addTaint(bytes[0]);
        addTaint(byteOffset);
        addTaint(byteCount);
        addTaint(flags);
        addTaint(inetAddress.getTaint());
        addTaint(port);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1398671948 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1398671948;
        // ---------- Original Method ----------
        //return sendtoBytes(fd, bytes, byteOffset, byteCount, flags, inetAddress, port);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.492 -0400", hash_original_method = "F841D540A211C98E750DE668FD283BE2", hash_generated_method = "3AB02FCE7E289F60980D48FD7A14E4D7")
    private int sendtoBytes(FileDescriptor fd, Object buffer, int byteOffset, int byteCount, int flags, InetAddress inetAddress, int port) throws ErrnoException {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1239551295 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1239551295;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.493 -0400", hash_original_method = "4EDFF9AE0EBC71C5A87E99E89B76EA1C", hash_generated_method = "5E48F6E110C1016C239B842F8C474176")
    public void setegid(int egid) throws ErrnoException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.494 -0400", hash_original_method = "A63D77D63BF9B7372008734FF96F48BC", hash_generated_method = "D406270C51FEA4C57DDD126C99DCDAC4")
    public void seteuid(int euid) throws ErrnoException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.494 -0400", hash_original_method = "5915305B25E8BEDA092C77560CFF8FA0", hash_generated_method = "C0F83CBE23D4A2D3DF140C77705BC0FD")
    public void setgid(int gid) throws ErrnoException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.494 -0400", hash_original_method = "9A5169BBE0282BCC00E74B397F068D4B", hash_generated_method = "3E08FEFBDE4D2BF5FCDEA705F6189D5A")
    public void setsockoptByte(FileDescriptor fd, int level, int option, int value) throws ErrnoException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.494 -0400", hash_original_method = "5041A6120F51EBC2B109E6AF0AE7FC14", hash_generated_method = "E635827CCD8247E74839393BBD93500E")
    public void setsockoptIfreq(FileDescriptor fd, int level, int option, String value) throws ErrnoException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.495 -0400", hash_original_method = "CE894EBBCEEC6D8A98A23F1D6DFA91AF", hash_generated_method = "A343E3AD0EAD83A0531ADBCCF86109AA")
    public void setsockoptInt(FileDescriptor fd, int level, int option, int value) throws ErrnoException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.498 -0400", hash_original_method = "6DBB3F1DC41874C1778513E87DD13712", hash_generated_method = "96EE4BF8E717F1B21BE9FA5405FB5833")
    public void setsockoptIpMreqn(FileDescriptor fd, int level, int option, int value) throws ErrnoException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.499 -0400", hash_original_method = "44866C5C735DD960E2B282162D2DFF44", hash_generated_method = "2464FDFB24FF4B764E38B335F935BD04")
    public void setsockoptGroupReq(FileDescriptor fd, int level, int option, StructGroupReq value) throws ErrnoException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.499 -0400", hash_original_method = "8265FFDA0D5B54E0714AF7F36058F0FD", hash_generated_method = "C0337305BF631A0C473462C66250C132")
    public void setsockoptLinger(FileDescriptor fd, int level, int option, StructLinger value) throws ErrnoException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.499 -0400", hash_original_method = "D0EFA67C69EE44E619BC32AD0ABAAA94", hash_generated_method = "E68EB8161F63BB5AD5B88B1DA31DE467")
    public void setsockoptTimeval(FileDescriptor fd, int level, int option, StructTimeval value) throws ErrnoException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.499 -0400", hash_original_method = "7541ED33DCEBBB89FE1430508C680E96", hash_generated_method = "98772075B4300BB00447E5FD75DA804A")
    public void setuid(int uid) throws ErrnoException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.500 -0400", hash_original_method = "1961EE437DD0A4352BCFCF2F346982D9", hash_generated_method = "AF53C7188D1B544BB358D63F5C774F2E")
    public void shutdown(FileDescriptor fd, int how) throws ErrnoException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.501 -0400", hash_original_method = "738E096C5E6C6A5066A76A9B90DC0CA9", hash_generated_method = "7CA7350BE0F647E1FAD6CC5C953D3D40")
    public FileDescriptor socket(int domain, int type, int protocol) throws ErrnoException {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.501 -0400", hash_original_method = "6347DE7B46FE3FC2519EB3B202A3981D", hash_generated_method = "A5CDFE2A5FE4F4A6DDEBA3884597AC82")
    public StructStat stat(String path) throws ErrnoException {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.501 -0400", hash_original_method = "5BCA24F466E28D74A0DD2E3DB7220B64", hash_generated_method = "ECEC00D3A13CFD9DCFFA731CEEB7943C")
    public StructStatFs statfs(String path) throws ErrnoException {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.502 -0400", hash_original_method = "DF22551AABB4776AE8588CD853791D73", hash_generated_method = "4B2628A376EBCD8E0BF3F6673B683BA7")
    public String strerror(int errno) {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.502 -0400", hash_original_method = "551DE00FB0B39FAF904A5DC205CAA2EB", hash_generated_method = "A129CF58BB7DCBA118CE2E16606EEC07")
    public void symlink(String oldPath, String newPath) throws ErrnoException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.502 -0400", hash_original_method = "0CA56D59A1B623A4EE1DB5A7E1204662", hash_generated_method = "8BF8C5CDFFAD51871B9EF2AD2C5B8C85")
    public long sysconf(int name) {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1025169547 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1025169547;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.502 -0400", hash_original_method = "840E5C1D01B396A2EA80B4AFD333B092", hash_generated_method = "6171D41EBFE7E809E74F1D080C3D2A62")
    public StructUtsname uname() {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.502 -0400", hash_original_method = "FE84032F23145F65306977A4498767E9", hash_generated_method = "337F43F513A037EE52B142C2F924E272")
    public int waitpid(int pid, MutableInt status, int options) throws ErrnoException {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1569464617 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1569464617;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.503 -0400", hash_original_method = "FF46C2F8D2234796363F6B9031191E3B", hash_generated_method = "2A9FC8DF2F1B602242AEE2869FBCCDA6")
    public int write(FileDescriptor fd, ByteBuffer buffer) throws ErrnoException {
        {
            boolean var21D6A43A19BB11FD75F2555CEDDC72D3_1855370508 = (buffer.isDirect());
            {
                int var018A5CC680E3A7E1C50076224C8C7605_1050270407 = (writeBytes(fd, buffer, buffer.position(), buffer.remaining()));
            } //End block
            {
                int var30C5EA943FBFB1242D64083C74DD8D3D_353184356 = (writeBytes(fd, NioUtils.unsafeArray(buffer), NioUtils.unsafeArrayOffset(buffer) + buffer.position(), buffer.remaining()));
            } //End block
        } //End collapsed parenthetic
        addTaint(fd.getTaint());
        addTaint(buffer.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_119360774 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_119360774;
        // ---------- Original Method ----------
        //if (buffer.isDirect()) {
            //return writeBytes(fd, buffer, buffer.position(), buffer.remaining());
        //} else {
            //return writeBytes(fd, NioUtils.unsafeArray(buffer), NioUtils.unsafeArrayOffset(buffer) + buffer.position(), buffer.remaining());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.503 -0400", hash_original_method = "077A8F097DECE8A2C8BBB2583BE2D8BE", hash_generated_method = "DE543A71E1E2CA91EA815D2619285A16")
    public int write(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount) throws ErrnoException {
        int var68D561E1E5C78821FF2B2E24F418F392_1429861164 = (writeBytes(fd, bytes, byteOffset, byteCount));
        addTaint(fd.getTaint());
        addTaint(bytes[0]);
        addTaint(byteOffset);
        addTaint(byteCount);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2025891180 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2025891180;
        // ---------- Original Method ----------
        //return writeBytes(fd, bytes, byteOffset, byteCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.503 -0400", hash_original_method = "E853B1F146558B1458DE2FB65CF651EB", hash_generated_method = "2D3B680AB06C770C36B19681C48C857D")
    private int writeBytes(FileDescriptor fd, Object buffer, int offset, int byteCount) throws ErrnoException {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_759293857 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_759293857;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:04.504 -0400", hash_original_method = "B9E2C692ADA119F653BB2CBF261E7047", hash_generated_method = "465D91AC6AA1FB205D2F50BED6F16028")
    public int writev(FileDescriptor fd, Object[] buffers, int[] offsets, int[] byteCounts) throws ErrnoException {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_646292948 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_646292948;
    }

    
}

