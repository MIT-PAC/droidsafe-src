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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.084 -0400", hash_original_method = "4046CDE00BB837810E8AFBFF17A6CE8F", hash_generated_method = "05221F2C631AA96E1462A4F7CC11A1BC")
      Posix() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.084 -0400", hash_original_method = "3FF894EBDB6D10C08E17FEF79D8BBDA9", hash_generated_method = "CD0A84B225A700801CB0CB5C048B5F64")
    public FileDescriptor accept(FileDescriptor fd, InetSocketAddress peerAddress) throws ErrnoException {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.086 -0400", hash_original_method = "B1689CE6DA8AD962BE72C0197D9C07BB", hash_generated_method = "B9C3A6E059BE91900780C0270277EEFD")
    public boolean access(String path, int mode) throws ErrnoException {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_74512832 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_74512832;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.087 -0400", hash_original_method = "291C8049FE6F5CDE681BB5AEA2008B38", hash_generated_method = "84FB031E5366E9FCB162C111EEB27C87")
    public void bind(FileDescriptor fd, InetAddress address, int port) throws ErrnoException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.087 -0400", hash_original_method = "C6B53F2282285C6075341EF2C607CF79", hash_generated_method = "1ADDDBE52AB61E2DC2D40B06BD38924E")
    public void chmod(String path, int mode) throws ErrnoException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.087 -0400", hash_original_method = "5621A98DBDE11BB13B9D88FD5C4303F9", hash_generated_method = "88AC1D1AA0DA20420EB3EC3F557D0CE2")
    public void close(FileDescriptor fd) throws ErrnoException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.087 -0400", hash_original_method = "583B21CF7E43DBF5EACD223A833123C4", hash_generated_method = "32A14EC0714501BE2AD1DD1B23C061AD")
    public void connect(FileDescriptor fd, InetAddress address, int port) throws ErrnoException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.087 -0400", hash_original_method = "3C30A8714976314FBC047CABB70B8D73", hash_generated_method = "E9F5AF0FB41B7707675BC76D1920487E")
    public FileDescriptor dup(FileDescriptor oldFd) throws ErrnoException {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.088 -0400", hash_original_method = "3FF27FFFD1EDB0C110A074DD6B27552E", hash_generated_method = "CA84B272541AD90B218B5342DA7CD207")
    public FileDescriptor dup2(FileDescriptor oldFd, int newFd) throws ErrnoException {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.088 -0400", hash_original_method = "76B056F20AEC72841BA98095F8E6CB34", hash_generated_method = "ADADA30B919F80A500FE6D3D2633BB36")
    public String[] environ() {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.088 -0400", hash_original_method = "2CB0275F8932D4CF3644D073C3F0700F", hash_generated_method = "E0C48B4077DE734A9111946CFF822269")
    public int fcntlVoid(FileDescriptor fd, int cmd) throws ErrnoException {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_826283166 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_826283166;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.088 -0400", hash_original_method = "2A7DB0B256B2976732DDA9A901297EFA", hash_generated_method = "54550541E6B62993199333FDA41D5DF8")
    public int fcntlLong(FileDescriptor fd, int cmd, long arg) throws ErrnoException {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1652806248 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1652806248;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.094 -0400", hash_original_method = "5842C7622D740E7A11EA29095C58FEF2", hash_generated_method = "41B3FA144D88D9F490730545384D76D8")
    public int fcntlFlock(FileDescriptor fd, int cmd, StructFlock arg) throws ErrnoException {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1348066928 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1348066928;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.095 -0400", hash_original_method = "CC5ECBC11DCDAEE11F3D1714EA5105D5", hash_generated_method = "2476A3C255789407A2CB89613FFC0767")
    public void fdatasync(FileDescriptor fd) throws ErrnoException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.095 -0400", hash_original_method = "285E3CF7F1EFC8C330731E11EF4C59B4", hash_generated_method = "FB432B0A46E67C4A515FC7D39713ADEE")
    public StructStat fstat(FileDescriptor fd) throws ErrnoException {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.095 -0400", hash_original_method = "1A9BE1A7FA5485B333D3854795E798C3", hash_generated_method = "2D430EC1E5F2AB304F57C6A4D3ACACFD")
    public StructStatFs fstatfs(FileDescriptor fd) throws ErrnoException {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.095 -0400", hash_original_method = "BC5DB2B4AC1C25097A3FF5E2C6AF2CA8", hash_generated_method = "E54FD0DB1F8F4382C4F5D3AC3B6E8F36")
    public void fsync(FileDescriptor fd) throws ErrnoException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.103 -0400", hash_original_method = "C3B05E353984E75A36400D4268798B4D", hash_generated_method = "4E6152073BE3DCA66E0B3ACC6C860A59")
    public void ftruncate(FileDescriptor fd, long length) throws ErrnoException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.104 -0400", hash_original_method = "26A40D218A150DBB5E3B431436FD5A7B", hash_generated_method = "27F87296D375B8957098A9ECC28029AB")
    public String gai_strerror(int error) {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.104 -0400", hash_original_method = "40F18080B746539908D74665104D4EA0", hash_generated_method = "130FA52FE5275831CC890F85A8CD5D33")
    public InetAddress[] getaddrinfo(String node, StructAddrinfo hints) throws GaiException {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.104 -0400", hash_original_method = "B351A98E9308B82B72BD8C1A77C5DADB", hash_generated_method = "7F40CE65D490F5977BEB8C6E2CD1D801")
    public int getegid() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_185096522 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_185096522;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.105 -0400", hash_original_method = "03FF5CC42F38A66A948C17532C044A2D", hash_generated_method = "9F41B2B11542BF93B253F2D09BF95DD3")
    public int geteuid() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_430238176 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_430238176;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.105 -0400", hash_original_method = "82D0BD1E53FB93AB39C412F5615316CA", hash_generated_method = "0CDF8AC513E83A3BC536BC7296D86CA9")
    public int getgid() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1436229891 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1436229891;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.105 -0400", hash_original_method = "ABE371B1B9ED1CAFA0922C4EB05C6BA3", hash_generated_method = "06988C5468266BFC53F857DF1F3A7080")
    public String getenv(String name) {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.105 -0400", hash_original_method = "A0AFA0E6B104A41B1981D0BE816BBE02", hash_generated_method = "5E0DD6AFD3DD827B3E5DE5816011CF57")
    public String getnameinfo(InetAddress address, int flags) throws GaiException {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.105 -0400", hash_original_method = "ED1FF6EE6302372A02F6AB9DF837F424", hash_generated_method = "16DAE192F41DDC29AD6E9B3C12BF7E21")
    public int getpid() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1028622192 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1028622192;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.106 -0400", hash_original_method = "E9C872CD5783C25015966D177C4AF8C6", hash_generated_method = "12DF33BAF8B62188EAA939A000B4B108")
    public int getppid() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_882737949 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_882737949;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.106 -0400", hash_original_method = "CC95F691F046B008F87F75EBB754B9F4", hash_generated_method = "9940A20D3850D7F380FC87AC6AF2F6E5")
    public StructPasswd getpwnam(String name) throws ErrnoException {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.106 -0400", hash_original_method = "F193108F2C48DAFAA33D43EBB961E0C4", hash_generated_method = "59D5893F141FDA927A6CE1BDE49A8CA7")
    public StructPasswd getpwuid(int uid) throws ErrnoException {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.106 -0400", hash_original_method = "BDE1CE7D74C0BBEFDC894A32FA56505C", hash_generated_method = "FEAEAFB793CE2332A26745CF5809AB9A")
    public SocketAddress getsockname(FileDescriptor fd) throws ErrnoException {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.106 -0400", hash_original_method = "51446225C69A8CF648D53B0005AE4AA4", hash_generated_method = "11C195A415B2D5B2DD3DA0961D4E81C6")
    public int getsockoptByte(FileDescriptor fd, int level, int option) throws ErrnoException {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_88378875 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_88378875;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.106 -0400", hash_original_method = "5BB8092DA4409A5D55882AE524C48CC0", hash_generated_method = "D3C69B8918D913F313F29C114573160B")
    public InetAddress getsockoptInAddr(FileDescriptor fd, int level, int option) throws ErrnoException {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.107 -0400", hash_original_method = "B939E72BF03DDCEDAC639A7621114578", hash_generated_method = "8AC5532ED02A57F17A95885F7AE2EAD6")
    public int getsockoptInt(FileDescriptor fd, int level, int option) throws ErrnoException {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_642929793 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_642929793;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.121 -0400", hash_original_method = "FEC6121EA2A897FBB99121F96B439FBB", hash_generated_method = "F60821EF1BF0B8831D7AAFEE843DD949")
    public StructLinger getsockoptLinger(FileDescriptor fd, int level, int option) throws ErrnoException {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.121 -0400", hash_original_method = "F02C71E9B42FAB3C0C2F8E812A8DAE0B", hash_generated_method = "6CA79EDA1D97037C4E5A07F27DEFAAF6")
    public StructTimeval getsockoptTimeval(FileDescriptor fd, int level, int option) throws ErrnoException {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.122 -0400", hash_original_method = "DCBAE976FF6D195847EC9B9CCBB16DA2", hash_generated_method = "BF8C4A9D74881A1B3804F24F6BCF2CCC")
    public int getuid() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2036902626 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2036902626;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.125 -0400", hash_original_method = "BC4349F875DD5C315A8CC9563ABD32ED", hash_generated_method = "5D3B61863086951BE5EE225ADA00E818")
    public String if_indextoname(int index) {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.125 -0400", hash_original_method = "2643CEE6EE9643256D8BA72042097190", hash_generated_method = "45DBEA6F2642076EEB7596214278AC69")
    public InetAddress inet_pton(int family, String address) {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.126 -0400", hash_original_method = "E90DEAC8BD65E718B0E2ACEED6C5AEE3", hash_generated_method = "BBFCB604834C488636C059270740197B")
    public InetAddress ioctlInetAddress(FileDescriptor fd, int cmd, String interfaceName) throws ErrnoException {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.126 -0400", hash_original_method = "06336F68D97266AEF577672F8C03A8E4", hash_generated_method = "C19C9C09293FA794AF2941B0E7F28723")
    public int ioctlInt(FileDescriptor fd, int cmd, MutableInt arg) throws ErrnoException {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2082107986 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2082107986;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.130 -0400", hash_original_method = "94B275389FB7735E79DD0606BB6663FC", hash_generated_method = "6EADF07090D4550732E42669E2A790A1")
    public boolean isatty(FileDescriptor fd) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_215579386 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_215579386;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.131 -0400", hash_original_method = "77BC6E1CDAEA7EC218D4C88B6DD6F628", hash_generated_method = "F6F6E534CA3E6662FA9A588696A9D1A5")
    public void kill(int pid, int signal) throws ErrnoException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.131 -0400", hash_original_method = "6ED23D1EA76BF029EEF21B4EAFA6CFF2", hash_generated_method = "DAA83A0CD96D69C2B0AA6D7503222609")
    public void listen(FileDescriptor fd, int backlog) throws ErrnoException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.131 -0400", hash_original_method = "6DE073E1DD2161D7E507CF5C1E8B8B5C", hash_generated_method = "25FFD2925B1520303B425CF1C545C3CC")
    public long lseek(FileDescriptor fd, long offset, int whence) throws ErrnoException {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_496118959 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_496118959;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.131 -0400", hash_original_method = "D639C215CF59CE0021DA2A9DC0F695A4", hash_generated_method = "E0143F1BAA64A6BF1E9A18B98E107A79")
    public StructStat lstat(String path) throws ErrnoException {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.132 -0400", hash_original_method = "EC9A299C6214A51B56DA51B591F6FF36", hash_generated_method = "F10B9DD324CECF0A86818AC7CC0C8EAB")
    public void mincore(long address, long byteCount, byte[] vector) throws ErrnoException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.132 -0400", hash_original_method = "4CC22C39A827987000370BD10B3B7F89", hash_generated_method = "5A7BEC510CF43D25B53554F6D2F2A2AE")
    public void mkdir(String path, int mode) throws ErrnoException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.132 -0400", hash_original_method = "40B753FBD702B9115A8CFFA4EBDDD434", hash_generated_method = "ED2C99AFEF903695150B0308D01F5D2B")
    public void mlock(long address, long byteCount) throws ErrnoException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.132 -0400", hash_original_method = "51925E7C1A595364A34E53403D531BF1", hash_generated_method = "B1726695C2CB30AE549D3395DD2CAC1D")
    public long mmap(long address, long byteCount, int prot, int flags, FileDescriptor fd, long offset) throws ErrnoException {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1727287138 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1727287138;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.132 -0400", hash_original_method = "E2366875958D829A580E669A2DB1A4B1", hash_generated_method = "8864C229845A0E2CC8F7FDA72470613D")
    public void msync(long address, long byteCount, int flags) throws ErrnoException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.133 -0400", hash_original_method = "300DE062DB1D5D96D86ACEAAE1343E18", hash_generated_method = "E47F369491E1B5E634DDD0810DD2F19A")
    public void munlock(long address, long byteCount) throws ErrnoException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.142 -0400", hash_original_method = "FD321BF6752ECFAABCD6429010BD098F", hash_generated_method = "08EB766C3DA5DD7C92B90F48070EBB89")
    public void munmap(long address, long byteCount) throws ErrnoException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.146 -0400", hash_original_method = "B03C285733E86D432A31E9556E29D38C", hash_generated_method = "3895485A804EB3F7CACE7511B2B310A8")
    public FileDescriptor open(String path, int flags, int mode) throws ErrnoException {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.146 -0400", hash_original_method = "15C3A12A736BB4281EA7C1CDE4AB9480", hash_generated_method = "656244847670CC9BF6362B959913631F")
    public FileDescriptor[] pipe() throws ErrnoException {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.147 -0400", hash_original_method = "A333C05E603FD568E448FA55BD420BEE", hash_generated_method = "4CFCFC59CDDC0F96B5DC1C3329A3F87E")
    public int poll(StructPollfd[] fds, int timeoutMs) throws ErrnoException {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_913266106 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_913266106;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.147 -0400", hash_original_method = "FD23B60A9051753476B14299BED1F849", hash_generated_method = "AD067F5869860C7A4CE640EA6E8E9BEA")
    public int pread(FileDescriptor fd, ByteBuffer buffer, long offset) throws ErrnoException {
        {
            boolean var21D6A43A19BB11FD75F2555CEDDC72D3_1279051621 = (buffer.isDirect());
            {
                int var8E7907A41BEF94A8EBD28CB040D098F0_1115604213 = (preadBytes(fd, buffer, buffer.position(), buffer.remaining(), offset));
            } //End block
            {
                int var1F069D630372EF5D70684AA69ABBB191_2044609239 = (preadBytes(fd, NioUtils.unsafeArray(buffer), NioUtils.unsafeArrayOffset(buffer) + buffer.position(), buffer.remaining(), offset));
            } //End block
        } //End collapsed parenthetic
        addTaint(fd.getTaint());
        addTaint(buffer.getTaint());
        addTaint(offset);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_814240134 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_814240134;
        // ---------- Original Method ----------
        //if (buffer.isDirect()) {
            //return preadBytes(fd, buffer, buffer.position(), buffer.remaining(), offset);
        //} else {
            //return preadBytes(fd, NioUtils.unsafeArray(buffer), NioUtils.unsafeArrayOffset(buffer) + buffer.position(), buffer.remaining(), offset);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.149 -0400", hash_original_method = "4B8706AF5748B9EE5E9BCCA6FC3C73C0", hash_generated_method = "F5A65CB3AF7B032FBA54D263B5E92F90")
    public int pread(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount, long offset) throws ErrnoException {
        int varCF530DD83FC2922F479A426BEFE4CB6B_445449422 = (preadBytes(fd, bytes, byteOffset, byteCount, offset));
        addTaint(fd.getTaint());
        addTaint(bytes[0]);
        addTaint(byteOffset);
        addTaint(byteCount);
        addTaint(offset);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1735796617 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1735796617;
        // ---------- Original Method ----------
        //return preadBytes(fd, bytes, byteOffset, byteCount, offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.149 -0400", hash_original_method = "5819B25FAD4FEDA7F174A32C15365436", hash_generated_method = "EBF544A22BFF1400E2227CBE57F2F322")
    private int preadBytes(FileDescriptor fd, Object buffer, int bufferOffset, int byteCount, long offset) throws ErrnoException {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1759435166 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1759435166;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.157 -0400", hash_original_method = "DB8AC8A16E91B9F291442450334BCFF2", hash_generated_method = "C8376A0D5DE692BBC0C86C8B7A96D098")
    public int pwrite(FileDescriptor fd, ByteBuffer buffer, long offset) throws ErrnoException {
        {
            boolean var21D6A43A19BB11FD75F2555CEDDC72D3_909598630 = (buffer.isDirect());
            {
                int var87D5C3FD697C182EDD756D3EFF6529D7_1094734867 = (pwriteBytes(fd, buffer, buffer.position(), buffer.remaining(), offset));
            } //End block
            {
                int var6DAE9A5C537D89AF40EB6C242AD74611_194171302 = (pwriteBytes(fd, NioUtils.unsafeArray(buffer), NioUtils.unsafeArrayOffset(buffer) + buffer.position(), buffer.remaining(), offset));
            } //End block
        } //End collapsed parenthetic
        addTaint(fd.getTaint());
        addTaint(buffer.getTaint());
        addTaint(offset);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1172162662 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1172162662;
        // ---------- Original Method ----------
        //if (buffer.isDirect()) {
            //return pwriteBytes(fd, buffer, buffer.position(), buffer.remaining(), offset);
        //} else {
            //return pwriteBytes(fd, NioUtils.unsafeArray(buffer), NioUtils.unsafeArrayOffset(buffer) + buffer.position(), buffer.remaining(), offset);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.158 -0400", hash_original_method = "364FA462AFF3FCDD2B79B5A0A9405455", hash_generated_method = "054316DB0D2A1065766918C3AD586FF9")
    public int pwrite(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount, long offset) throws ErrnoException {
        int varFC5C8D1266385A06B48EE648ACD7657C_528962589 = (pwriteBytes(fd, bytes, byteOffset, byteCount, offset));
        addTaint(fd.getTaint());
        addTaint(bytes[0]);
        addTaint(byteOffset);
        addTaint(byteCount);
        addTaint(offset);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2072299198 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2072299198;
        // ---------- Original Method ----------
        //return pwriteBytes(fd, bytes, byteOffset, byteCount, offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.158 -0400", hash_original_method = "90B6FC1B27EC82D887BE52674747E195", hash_generated_method = "B48B11A6C4F11645F708E1BB8BEA5F80")
    private int pwriteBytes(FileDescriptor fd, Object buffer, int bufferOffset, int byteCount, long offset) throws ErrnoException {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_312589418 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_312589418;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.159 -0400", hash_original_method = "ADE2F5685BF490A50DE36063F7A06769", hash_generated_method = "65597B337977F67C7571311076D7D023")
    public int read(FileDescriptor fd, ByteBuffer buffer) throws ErrnoException {
        {
            boolean var21D6A43A19BB11FD75F2555CEDDC72D3_1566429250 = (buffer.isDirect());
            {
                int varD5A85510F41F9F59964F2A7FD9630E4C_1086895558 = (readBytes(fd, buffer, buffer.position(), buffer.remaining()));
            } //End block
            {
                int varC2696D40F0D039BC87FD96259E5276FD_1470367505 = (readBytes(fd, NioUtils.unsafeArray(buffer), NioUtils.unsafeArrayOffset(buffer) + buffer.position(), buffer.remaining()));
            } //End block
        } //End collapsed parenthetic
        addTaint(fd.getTaint());
        addTaint(buffer.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1851507125 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1851507125;
        // ---------- Original Method ----------
        //if (buffer.isDirect()) {
            //return readBytes(fd, buffer, buffer.position(), buffer.remaining());
        //} else {
            //return readBytes(fd, NioUtils.unsafeArray(buffer), NioUtils.unsafeArrayOffset(buffer) + buffer.position(), buffer.remaining());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.159 -0400", hash_original_method = "6168115C79D46336D7C888D619663F88", hash_generated_method = "2425B0673D5BB587CE36300ED5B3A0E7")
    public int read(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount) throws ErrnoException {
        int varAF7FBEB1A05EE593C49B78D715290282_1863098807 = (readBytes(fd, bytes, byteOffset, byteCount));
        addTaint(fd.getTaint());
        addTaint(bytes[0]);
        addTaint(byteOffset);
        addTaint(byteCount);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_502323660 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_502323660;
        // ---------- Original Method ----------
        //return readBytes(fd, bytes, byteOffset, byteCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.160 -0400", hash_original_method = "2C7E892AABA7BE06DDD2C6AC692575BC", hash_generated_method = "729032EE60630476B697F9A5E9125112")
    private int readBytes(FileDescriptor fd, Object buffer, int offset, int byteCount) throws ErrnoException {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_471950614 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_471950614;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.160 -0400", hash_original_method = "D5205EB48193928ACF79029A7B33E86B", hash_generated_method = "A56407A3604A55ADBA75CC37E51BD09A")
    public int readv(FileDescriptor fd, Object[] buffers, int[] offsets, int[] byteCounts) throws ErrnoException {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1248414743 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1248414743;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.160 -0400", hash_original_method = "41329575D83AD4CCCAB565E77BA083D5", hash_generated_method = "D18FA91177E2B5460695AB3DB6F79645")
    public int recvfrom(FileDescriptor fd, ByteBuffer buffer, int flags, InetSocketAddress srcAddress) throws ErrnoException {
        {
            boolean var21D6A43A19BB11FD75F2555CEDDC72D3_638084851 = (buffer.isDirect());
            {
                int varF31574244E582FAAC1D4E5A3117CCAD5_1659162463 = (recvfromBytes(fd, buffer, buffer.position(), buffer.remaining(), flags, srcAddress));
            } //End block
            {
                int var754A91E49CCFCF0B12E0E37D924384F6_2001333666 = (recvfromBytes(fd, NioUtils.unsafeArray(buffer), NioUtils.unsafeArrayOffset(buffer) + buffer.position(), buffer.remaining(), flags, srcAddress));
            } //End block
        } //End collapsed parenthetic
        addTaint(fd.getTaint());
        addTaint(buffer.getTaint());
        addTaint(flags);
        addTaint(srcAddress.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2101968423 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2101968423;
        // ---------- Original Method ----------
        //if (buffer.isDirect()) {
            //return recvfromBytes(fd, buffer, buffer.position(), buffer.remaining(), flags, srcAddress);
        //} else {
            //return recvfromBytes(fd, NioUtils.unsafeArray(buffer), NioUtils.unsafeArrayOffset(buffer) + buffer.position(), buffer.remaining(), flags, srcAddress);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.167 -0400", hash_original_method = "D6B3FC14ED62FEA7873773B8EF3E6A7B", hash_generated_method = "A99E26F0AB7F9CDA93DE5C90E2C044ED")
    public int recvfrom(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount, int flags, InetSocketAddress srcAddress) throws ErrnoException {
        int var5C3B514BF02C0C51E1C7926B1634D11C_1439088053 = (recvfromBytes(fd, bytes, byteOffset, byteCount, flags, srcAddress));
        addTaint(fd.getTaint());
        addTaint(bytes[0]);
        addTaint(byteOffset);
        addTaint(byteCount);
        addTaint(flags);
        addTaint(srcAddress.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1520534311 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1520534311;
        // ---------- Original Method ----------
        //return recvfromBytes(fd, bytes, byteOffset, byteCount, flags, srcAddress);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.168 -0400", hash_original_method = "4ADC9C5F635814CDC8DA4D81B23D96F7", hash_generated_method = "A1E21022E5B9E9D2D9BB20D7D1378FF0")
    private int recvfromBytes(FileDescriptor fd, Object buffer, int byteOffset, int byteCount, int flags, InetSocketAddress srcAddress) throws ErrnoException {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1158284655 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1158284655;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.168 -0400", hash_original_method = "C4D2972D60AD59B1B88202B59332518F", hash_generated_method = "F785749D71099D3C2EF1A4F3482E2FC9")
    public void remove(String path) throws ErrnoException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.175 -0400", hash_original_method = "79CCF6DA9C97D5D1A767D340D63FA141", hash_generated_method = "ECFA7C07C31807064D12083B534138D1")
    public void rename(String oldPath, String newPath) throws ErrnoException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.175 -0400", hash_original_method = "9AFCCF531361D938553CC3693890CE79", hash_generated_method = "F360A6B3BCF09F23E0E97C1B064E059E")
    public long sendfile(FileDescriptor outFd, FileDescriptor inFd, MutableLong inOffset, long byteCount) throws ErrnoException {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_928223890 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_928223890;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.180 -0400", hash_original_method = "CE9DE10B0135BB1F72B6E5CF17271781", hash_generated_method = "17AA5C44549094F606C220DA48AB4E8B")
    public int sendto(FileDescriptor fd, ByteBuffer buffer, int flags, InetAddress inetAddress, int port) throws ErrnoException {
        {
            boolean var21D6A43A19BB11FD75F2555CEDDC72D3_1841292154 = (buffer.isDirect());
            {
                int var5E9D1647C6154DCE995D5EEEB1605F7B_642661790 = (sendtoBytes(fd, buffer, buffer.position(), buffer.remaining(), flags, inetAddress, port));
            } //End block
            {
                int var454BEDFAD70DADFAA662DB20DF483B42_916892426 = (sendtoBytes(fd, NioUtils.unsafeArray(buffer), NioUtils.unsafeArrayOffset(buffer) + buffer.position(), buffer.remaining(), flags, inetAddress, port));
            } //End block
        } //End collapsed parenthetic
        addTaint(fd.getTaint());
        addTaint(buffer.getTaint());
        addTaint(flags);
        addTaint(inetAddress.getTaint());
        addTaint(port);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_836110392 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_836110392;
        // ---------- Original Method ----------
        //if (buffer.isDirect()) {
            //return sendtoBytes(fd, buffer, buffer.position(), buffer.remaining(), flags, inetAddress, port);
        //} else {
            //return sendtoBytes(fd, NioUtils.unsafeArray(buffer), NioUtils.unsafeArrayOffset(buffer) + buffer.position(), buffer.remaining(), flags, inetAddress, port);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.180 -0400", hash_original_method = "23CCF7407B7F91C60BE72C6923799443", hash_generated_method = "DC113ED7412BD5AF37B992005343581A")
    public int sendto(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount, int flags, InetAddress inetAddress, int port) throws ErrnoException {
        int varE214C015B4D6A01301684BB848AD3BF2_1926037559 = (sendtoBytes(fd, bytes, byteOffset, byteCount, flags, inetAddress, port));
        addTaint(fd.getTaint());
        addTaint(bytes[0]);
        addTaint(byteOffset);
        addTaint(byteCount);
        addTaint(flags);
        addTaint(inetAddress.getTaint());
        addTaint(port);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1253794193 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1253794193;
        // ---------- Original Method ----------
        //return sendtoBytes(fd, bytes, byteOffset, byteCount, flags, inetAddress, port);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.190 -0400", hash_original_method = "F841D540A211C98E750DE668FD283BE2", hash_generated_method = "A407B07D4B622BDE6A50C10E4C32AE6A")
    private int sendtoBytes(FileDescriptor fd, Object buffer, int byteOffset, int byteCount, int flags, InetAddress inetAddress, int port) throws ErrnoException {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_295233425 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_295233425;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.190 -0400", hash_original_method = "4EDFF9AE0EBC71C5A87E99E89B76EA1C", hash_generated_method = "5E48F6E110C1016C239B842F8C474176")
    public void setegid(int egid) throws ErrnoException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.191 -0400", hash_original_method = "A63D77D63BF9B7372008734FF96F48BC", hash_generated_method = "D406270C51FEA4C57DDD126C99DCDAC4")
    public void seteuid(int euid) throws ErrnoException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.191 -0400", hash_original_method = "5915305B25E8BEDA092C77560CFF8FA0", hash_generated_method = "C0F83CBE23D4A2D3DF140C77705BC0FD")
    public void setgid(int gid) throws ErrnoException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.191 -0400", hash_original_method = "9A5169BBE0282BCC00E74B397F068D4B", hash_generated_method = "3E08FEFBDE4D2BF5FCDEA705F6189D5A")
    public void setsockoptByte(FileDescriptor fd, int level, int option, int value) throws ErrnoException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.191 -0400", hash_original_method = "5041A6120F51EBC2B109E6AF0AE7FC14", hash_generated_method = "E635827CCD8247E74839393BBD93500E")
    public void setsockoptIfreq(FileDescriptor fd, int level, int option, String value) throws ErrnoException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.192 -0400", hash_original_method = "CE894EBBCEEC6D8A98A23F1D6DFA91AF", hash_generated_method = "A343E3AD0EAD83A0531ADBCCF86109AA")
    public void setsockoptInt(FileDescriptor fd, int level, int option, int value) throws ErrnoException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.192 -0400", hash_original_method = "6DBB3F1DC41874C1778513E87DD13712", hash_generated_method = "96EE4BF8E717F1B21BE9FA5405FB5833")
    public void setsockoptIpMreqn(FileDescriptor fd, int level, int option, int value) throws ErrnoException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.193 -0400", hash_original_method = "44866C5C735DD960E2B282162D2DFF44", hash_generated_method = "2464FDFB24FF4B764E38B335F935BD04")
    public void setsockoptGroupReq(FileDescriptor fd, int level, int option, StructGroupReq value) throws ErrnoException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.199 -0400", hash_original_method = "8265FFDA0D5B54E0714AF7F36058F0FD", hash_generated_method = "C0337305BF631A0C473462C66250C132")
    public void setsockoptLinger(FileDescriptor fd, int level, int option, StructLinger value) throws ErrnoException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.200 -0400", hash_original_method = "D0EFA67C69EE44E619BC32AD0ABAAA94", hash_generated_method = "E68EB8161F63BB5AD5B88B1DA31DE467")
    public void setsockoptTimeval(FileDescriptor fd, int level, int option, StructTimeval value) throws ErrnoException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.200 -0400", hash_original_method = "7541ED33DCEBBB89FE1430508C680E96", hash_generated_method = "98772075B4300BB00447E5FD75DA804A")
    public void setuid(int uid) throws ErrnoException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.201 -0400", hash_original_method = "1961EE437DD0A4352BCFCF2F346982D9", hash_generated_method = "AF53C7188D1B544BB358D63F5C774F2E")
    public void shutdown(FileDescriptor fd, int how) throws ErrnoException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.201 -0400", hash_original_method = "738E096C5E6C6A5066A76A9B90DC0CA9", hash_generated_method = "7CA7350BE0F647E1FAD6CC5C953D3D40")
    public FileDescriptor socket(int domain, int type, int protocol) throws ErrnoException {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.201 -0400", hash_original_method = "6347DE7B46FE3FC2519EB3B202A3981D", hash_generated_method = "A5CDFE2A5FE4F4A6DDEBA3884597AC82")
    public StructStat stat(String path) throws ErrnoException {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.202 -0400", hash_original_method = "5BCA24F466E28D74A0DD2E3DB7220B64", hash_generated_method = "ECEC00D3A13CFD9DCFFA731CEEB7943C")
    public StructStatFs statfs(String path) throws ErrnoException {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.208 -0400", hash_original_method = "DF22551AABB4776AE8588CD853791D73", hash_generated_method = "4B2628A376EBCD8E0BF3F6673B683BA7")
    public String strerror(int errno) {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.212 -0400", hash_original_method = "551DE00FB0B39FAF904A5DC205CAA2EB", hash_generated_method = "A129CF58BB7DCBA118CE2E16606EEC07")
    public void symlink(String oldPath, String newPath) throws ErrnoException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.213 -0400", hash_original_method = "0CA56D59A1B623A4EE1DB5A7E1204662", hash_generated_method = "B88F79F1B8C2128ED061EA9D3A33ADDF")
    public long sysconf(int name) {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_379059373 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_379059373;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.213 -0400", hash_original_method = "840E5C1D01B396A2EA80B4AFD333B092", hash_generated_method = "6171D41EBFE7E809E74F1D080C3D2A62")
    public StructUtsname uname() {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.213 -0400", hash_original_method = "FE84032F23145F65306977A4498767E9", hash_generated_method = "7D16953E6604789ADBBD0F0CDDEE503E")
    public int waitpid(int pid, MutableInt status, int options) throws ErrnoException {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2138814116 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2138814116;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.214 -0400", hash_original_method = "FF46C2F8D2234796363F6B9031191E3B", hash_generated_method = "FFA030C7AB008C0CFE89706C30E70829")
    public int write(FileDescriptor fd, ByteBuffer buffer) throws ErrnoException {
        {
            boolean var21D6A43A19BB11FD75F2555CEDDC72D3_1828371737 = (buffer.isDirect());
            {
                int var018A5CC680E3A7E1C50076224C8C7605_616528551 = (writeBytes(fd, buffer, buffer.position(), buffer.remaining()));
            } //End block
            {
                int var30C5EA943FBFB1242D64083C74DD8D3D_2013578505 = (writeBytes(fd, NioUtils.unsafeArray(buffer), NioUtils.unsafeArrayOffset(buffer) + buffer.position(), buffer.remaining()));
            } //End block
        } //End collapsed parenthetic
        addTaint(fd.getTaint());
        addTaint(buffer.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_682004244 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_682004244;
        // ---------- Original Method ----------
        //if (buffer.isDirect()) {
            //return writeBytes(fd, buffer, buffer.position(), buffer.remaining());
        //} else {
            //return writeBytes(fd, NioUtils.unsafeArray(buffer), NioUtils.unsafeArrayOffset(buffer) + buffer.position(), buffer.remaining());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.214 -0400", hash_original_method = "077A8F097DECE8A2C8BBB2583BE2D8BE", hash_generated_method = "081798CECE2FC821890D0F1421080CA2")
    public int write(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount) throws ErrnoException {
        int var68D561E1E5C78821FF2B2E24F418F392_677913739 = (writeBytes(fd, bytes, byteOffset, byteCount));
        addTaint(fd.getTaint());
        addTaint(bytes[0]);
        addTaint(byteOffset);
        addTaint(byteCount);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_299741175 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_299741175;
        // ---------- Original Method ----------
        //return writeBytes(fd, bytes, byteOffset, byteCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.214 -0400", hash_original_method = "E853B1F146558B1458DE2FB65CF651EB", hash_generated_method = "EA7AE70DA6E7C4E20730948C29EA9F88")
    private int writeBytes(FileDescriptor fd, Object buffer, int offset, int byteCount) throws ErrnoException {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_972577431 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_972577431;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.224 -0400", hash_original_method = "B9E2C692ADA119F653BB2CBF261E7047", hash_generated_method = "0D8BBF8C5B7109F8B41371DBC9383F2B")
    public int writev(FileDescriptor fd, Object[] buffers, int[] offsets, int[] byteCounts) throws ErrnoException {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1684323796 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1684323796;
    }

    
}

