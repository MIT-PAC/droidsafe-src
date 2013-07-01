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

import sun.net.InetAddressCachePolicy;
import libcore.util.MutableInt;
import libcore.util.MutableLong;

public final class Posix implements Os {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.381 -0400", hash_original_method = "4046CDE00BB837810E8AFBFF17A6CE8F", hash_generated_method = "05221F2C631AA96E1462A4F7CC11A1BC")
      Posix() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.381 -0400", hash_original_method = "3FF894EBDB6D10C08E17FEF79D8BBDA9", hash_generated_method = "CD0A84B225A700801CB0CB5C048B5F64")
    public FileDescriptor accept(FileDescriptor fd, InetSocketAddress peerAddress) throws ErrnoException {
    	FileDescriptor ret = new FileDescriptor();
    	ret.addTaint(peerAddress.getTaint());
    	return ret;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.381 -0400", hash_original_method = "B1689CE6DA8AD962BE72C0197D9C07BB", hash_generated_method = "E8FBE4E7FE6C58A40D9AA3CB0B76D807")
    public boolean access(String path, int mode) throws ErrnoException {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1840900899 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1840900899;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.381 -0400", hash_original_method = "291C8049FE6F5CDE681BB5AEA2008B38", hash_generated_method = "84FB031E5366E9FCB162C111EEB27C87")
    public void bind(FileDescriptor fd, InetAddress address, int port) throws ErrnoException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.381 -0400", hash_original_method = "C6B53F2282285C6075341EF2C607CF79", hash_generated_method = "1ADDDBE52AB61E2DC2D40B06BD38924E")
    public void chmod(String path, int mode) throws ErrnoException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.381 -0400", hash_original_method = "5621A98DBDE11BB13B9D88FD5C4303F9", hash_generated_method = "88AC1D1AA0DA20420EB3EC3F557D0CE2")
    public void close(FileDescriptor fd) throws ErrnoException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.382 -0400", hash_original_method = "583B21CF7E43DBF5EACD223A833123C4", hash_generated_method = "32A14EC0714501BE2AD1DD1B23C061AD")
    public void connect(FileDescriptor fd, InetAddress address, int port) throws ErrnoException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.382 -0400", hash_original_method = "3C30A8714976314FBC047CABB70B8D73", hash_generated_method = "E9F5AF0FB41B7707675BC76D1920487E")
    public FileDescriptor dup(FileDescriptor oldFd) throws ErrnoException {
    	FileDescriptor ret = new FileDescriptor();
    	ret.setInt$(oldFd.getInt$());
    	return ret;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.382 -0400", hash_original_method = "3FF27FFFD1EDB0C110A074DD6B27552E", hash_generated_method = "CA84B272541AD90B218B5342DA7CD207")
    public FileDescriptor dup2(FileDescriptor oldFd, int newFd) throws ErrnoException {
    	FileDescriptor ret = new FileDescriptor();
    	ret.setInt$(newFd);
    	ret.addTaint(oldFd.getTaint());
    	return ret;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.382 -0400", hash_original_method = "76B056F20AEC72841BA98095F8E6CB34", hash_generated_method = "ADADA30B919F80A500FE6D3D2633BB36")
    public String[] environ() {
    	String[] arr = {new String()};
    	return arr;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.382 -0400", hash_original_method = "2CB0275F8932D4CF3644D073C3F0700F", hash_generated_method = "AC4B51B5F9EAC4E260191F237C5A393F")
    public int fcntlVoid(FileDescriptor fd, int cmd) throws ErrnoException {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1367155640 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1367155640;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.383 -0400", hash_original_method = "2A7DB0B256B2976732DDA9A901297EFA", hash_generated_method = "5544CB8A80D80FBA2D9BC9A4A43E1017")
    public int fcntlLong(FileDescriptor fd, int cmd, long arg) throws ErrnoException {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1027000035 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1027000035;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.383 -0400", hash_original_method = "5842C7622D740E7A11EA29095C58FEF2", hash_generated_method = "893B73DAB536E12601B87EFD96878B23")
    public int fcntlFlock(FileDescriptor fd, int cmd, StructFlock arg) throws ErrnoException {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1627196532 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1627196532;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.383 -0400", hash_original_method = "CC5ECBC11DCDAEE11F3D1714EA5105D5", hash_generated_method = "2476A3C255789407A2CB89613FFC0767")
    public void fdatasync(FileDescriptor fd) throws ErrnoException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.383 -0400", hash_original_method = "285E3CF7F1EFC8C330731E11EF4C59B4", hash_generated_method = "FB432B0A46E67C4A515FC7D39713ADEE")
    public StructStat fstat(FileDescriptor fd) throws ErrnoException {
    	StructStat ret = new StructStat(DSUtils.UNKNOWN_LONG, DSUtils.UNKNOWN_LONG, DSUtils.UNKNOWN_INT,
    			DSUtils.UNKNOWN_LONG, DSUtils.UNKNOWN_INT, DSUtils.UNKNOWN_INT, DSUtils.UNKNOWN_LONG,
    			DSUtils.UNKNOWN_LONG, DSUtils.UNKNOWN_LONG, DSUtils.UNKNOWN_LONG, DSUtils.UNKNOWN_LONG,
    			DSUtils.UNKNOWN_LONG, DSUtils.UNKNOWN_LONG);
    	ret.addTaint(fd.getTaint());
    	return ret;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.383 -0400", hash_original_method = "1A9BE1A7FA5485B333D3854795E798C3", hash_generated_method = "2D430EC1E5F2AB304F57C6A4D3ACACFD")
    public StructStatFs fstatfs(FileDescriptor fd) throws ErrnoException {
    	StructStatFs ret = new StructStatFs(DSUtils.UNKNOWN_LONG, DSUtils.UNKNOWN_LONG, DSUtils.UNKNOWN_LONG,
    			DSUtils.UNKNOWN_LONG, DSUtils.UNKNOWN_LONG, DSUtils.UNKNOWN_LONG, DSUtils.UNKNOWN_LONG,
    			DSUtils.UNKNOWN_LONG);
    	ret.addTaint(fd.getTaint());
    	return ret;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.383 -0400", hash_original_method = "BC5DB2B4AC1C25097A3FF5E2C6AF2CA8", hash_generated_method = "E54FD0DB1F8F4382C4F5D3AC3B6E8F36")
    public void fsync(FileDescriptor fd) throws ErrnoException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.384 -0400", hash_original_method = "C3B05E353984E75A36400D4268798B4D", hash_generated_method = "4E6152073BE3DCA66E0B3ACC6C860A59")
    public void ftruncate(FileDescriptor fd, long length) throws ErrnoException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.384 -0400", hash_original_method = "26A40D218A150DBB5E3B431436FD5A7B", hash_generated_method = "27F87296D375B8957098A9ECC28029AB")
    public String gai_strerror(int error) {
    	String s = new String();
    	s.addTaint(error);
    	return s;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.384 -0400", hash_original_method = "40F18080B746539908D74665104D4EA0", hash_generated_method = "130FA52FE5275831CC890F85A8CD5D33")
    public InetAddress[] getaddrinfo(String node, StructAddrinfo hints) throws GaiException {
    	return new InetAddress[1];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.384 -0400", hash_original_method = "B351A98E9308B82B72BD8C1A77C5DADB", hash_generated_method = "1173774FCCA2B03A9A17C7535E35FB04")
    public int getegid() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_728642053 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_728642053;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.384 -0400", hash_original_method = "03FF5CC42F38A66A948C17532C044A2D", hash_generated_method = "1759358A4977D642D21037B3A42EBA02")
    public int geteuid() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_587696606 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_587696606;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.385 -0400", hash_original_method = "82D0BD1E53FB93AB39C412F5615316CA", hash_generated_method = "DB12EE688D6034FCB6F94644FC0EACBA")
    public int getgid() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_267287810 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_267287810;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.385 -0400", hash_original_method = "ABE371B1B9ED1CAFA0922C4EB05C6BA3", hash_generated_method = "06988C5468266BFC53F857DF1F3A7080")
    public String getenv(String name) {
    	String s = new String();
    	s.addTaint(name.getTaint());
    	return s;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.385 -0400", hash_original_method = "A0AFA0E6B104A41B1981D0BE816BBE02", hash_generated_method = "5E0DD6AFD3DD827B3E5DE5816011CF57")
    public String getnameinfo(InetAddress address, int flags) throws GaiException {
    	String s = new String();
    	s.addTaint(address.getTaint());
    	s.addTaint(flags);
    	return s;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.386 -0400", hash_original_method = "ED1FF6EE6302372A02F6AB9DF837F424", hash_generated_method = "03EFF95FCC233A87412FA3E5DF2A2CBB")
    public int getpid() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1597135571 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1597135571;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.386 -0400", hash_original_method = "E9C872CD5783C25015966D177C4AF8C6", hash_generated_method = "808BE9971B07B6BEE1845FE7118413C5")
    public int getppid() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_884047502 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_884047502;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.386 -0400", hash_original_method = "CC95F691F046B008F87F75EBB754B9F4", hash_generated_method = "9940A20D3850D7F380FC87AC6AF2F6E5")
    public StructPasswd getpwnam(String name) throws ErrnoException {
    	StructPasswd spwd = new StructPasswd(name, DSUtils.UNKNOWN_INT, DSUtils.UNKNOWN_INT, new String(), new String());
    	return spwd;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.386 -0400", hash_original_method = "F193108F2C48DAFAA33D43EBB961E0C4", hash_generated_method = "59D5893F141FDA927A6CE1BDE49A8CA7")
    public StructPasswd getpwuid(int uid) throws ErrnoException {
    	StructPasswd spwd = new StructPasswd(new String(), uid, DSUtils.UNKNOWN_INT, new String(), new String());
    	return spwd;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.387 -0400", hash_original_method = "BDE1CE7D74C0BBEFDC894A32FA56505C", hash_generated_method = "FEAEAFB793CE2332A26745CF5809AB9A")
    public SocketAddress getsockname(FileDescriptor fd) throws ErrnoException {
    	SocketAddress sa = new SocketAddress() {
			private static final long serialVersionUID = 1L;
		};
		sa.addTaint(fd.getTaint());
		return sa;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.387 -0400", hash_original_method = "51446225C69A8CF648D53B0005AE4AA4", hash_generated_method = "2775636EEAE259251FB8C2FEAE454C44")
    public int getsockoptByte(FileDescriptor fd, int level, int option) throws ErrnoException {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_862261199 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_862261199;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.387 -0400", hash_original_method = "5BB8092DA4409A5D55882AE524C48CC0", hash_generated_method = "D3C69B8918D913F313F29C114573160B")
    public InetAddress getsockoptInAddr(FileDescriptor fd, int level, int option) throws ErrnoException {
    	InetAddress ia = InetAddress.UNSPECIFIED;
    	ia.addTaint(fd.getTaint());
    	return ia;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.387 -0400", hash_original_method = "B939E72BF03DDCEDAC639A7621114578", hash_generated_method = "D12DFFD37BF10A591E63A8ACBFB6D871")
    public int getsockoptInt(FileDescriptor fd, int level, int option) throws ErrnoException {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1280387375 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1280387375;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.388 -0400", hash_original_method = "FEC6121EA2A897FBB99121F96B439FBB", hash_generated_method = "F60821EF1BF0B8831D7AAFEE843DD949")
    public StructLinger getsockoptLinger(FileDescriptor fd, int level, int option) throws ErrnoException {
    	StructLinger sl = new StructLinger(DSUtils.UNKNOWN_INT,DSUtils.UNKNOWN_INT);
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    	return sl;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.389 -0400", hash_original_method = "F02C71E9B42FAB3C0C2F8E812A8DAE0B", hash_generated_method = "6CA79EDA1D97037C4E5A07F27DEFAAF6")
    public StructTimeval getsockoptTimeval(FileDescriptor fd, int level, int option) throws ErrnoException {
    	StructTimeval st = StructTimeval.fromMillis(DSUtils.UNKNOWN_LONG);
    	st.addTaint(fd.getTaint());
    	return st;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.390 -0400", hash_original_method = "DCBAE976FF6D195847EC9B9CCBB16DA2", hash_generated_method = "5302B0A9643FD897A0657DF4039F9667")
    public int getuid() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_155324581 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_155324581;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.390 -0400", hash_original_method = "BC4349F875DD5C315A8CC9563ABD32ED", hash_generated_method = "5D3B61863086951BE5EE225ADA00E818")
    public String if_indextoname(int index) {
    	String s = new String();
    	s.addTaint(index);
    	return s;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.390 -0400", hash_original_method = "2643CEE6EE9643256D8BA72042097190", hash_generated_method = "45DBEA6F2642076EEB7596214278AC69")
    public InetAddress inet_pton(int family, String address) {
    	return InetAddress.UNSPECIFIED;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.390 -0400", hash_original_method = "E90DEAC8BD65E718B0E2ACEED6C5AEE3", hash_generated_method = "BBFCB604834C488636C059270740197B")
    public InetAddress ioctlInetAddress(FileDescriptor fd, int cmd, String interfaceName) throws ErrnoException {
    	return InetAddress.UNSPECIFIED;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.390 -0400", hash_original_method = "06336F68D97266AEF577672F8C03A8E4", hash_generated_method = "2B2C2A82BF9D2142C22E625EC6857DC0")
    public int ioctlInt(FileDescriptor fd, int cmd, MutableInt arg) throws ErrnoException {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1126572063 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1126572063;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.391 -0400", hash_original_method = "94B275389FB7735E79DD0606BB6663FC", hash_generated_method = "E2568F37E1076EF6BE5069B75606FB43")
    public boolean isatty(FileDescriptor fd) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_65291563 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_65291563;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.391 -0400", hash_original_method = "77BC6E1CDAEA7EC218D4C88B6DD6F628", hash_generated_method = "F6F6E534CA3E6662FA9A588696A9D1A5")
    public void kill(int pid, int signal) throws ErrnoException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.391 -0400", hash_original_method = "6ED23D1EA76BF029EEF21B4EAFA6CFF2", hash_generated_method = "DAA83A0CD96D69C2B0AA6D7503222609")
    public void listen(FileDescriptor fd, int backlog) throws ErrnoException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.391 -0400", hash_original_method = "6DE073E1DD2161D7E507CF5C1E8B8B5C", hash_generated_method = "04FAF7926B3F692D6B0664A9FBFB7422")
    public long lseek(FileDescriptor fd, long offset, int whence) throws ErrnoException {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1204117769 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1204117769;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.391 -0400", hash_original_method = "D639C215CF59CE0021DA2A9DC0F695A4", hash_generated_method = "E0143F1BAA64A6BF1E9A18B98E107A79")
    public StructStat lstat(String path) throws ErrnoException {
    	StructStat ret = new StructStat(DSUtils.UNKNOWN_LONG, DSUtils.UNKNOWN_LONG, DSUtils.UNKNOWN_INT,
    			DSUtils.UNKNOWN_LONG, DSUtils.UNKNOWN_INT, DSUtils.UNKNOWN_INT, DSUtils.UNKNOWN_LONG,
    			DSUtils.UNKNOWN_LONG, DSUtils.UNKNOWN_LONG, DSUtils.UNKNOWN_LONG, DSUtils.UNKNOWN_LONG,
    			DSUtils.UNKNOWN_LONG, DSUtils.UNKNOWN_LONG);
    	ret.addTaint(path.getTaint());
    	return ret;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.392 -0400", hash_original_method = "EC9A299C6214A51B56DA51B591F6FF36", hash_generated_method = "F10B9DD324CECF0A86818AC7CC0C8EAB")
    public void mincore(long address, long byteCount, byte[] vector) throws ErrnoException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.392 -0400", hash_original_method = "4CC22C39A827987000370BD10B3B7F89", hash_generated_method = "5A7BEC510CF43D25B53554F6D2F2A2AE")
    public void mkdir(String path, int mode) throws ErrnoException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.392 -0400", hash_original_method = "40B753FBD702B9115A8CFFA4EBDDD434", hash_generated_method = "ED2C99AFEF903695150B0308D01F5D2B")
    public void mlock(long address, long byteCount) throws ErrnoException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.392 -0400", hash_original_method = "51925E7C1A595364A34E53403D531BF1", hash_generated_method = "CFF5C4D7126963567028E372B334DFFD")
    public long mmap(long address, long byteCount, int prot, int flags, FileDescriptor fd, long offset) throws ErrnoException {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1274936961 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1274936961;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.392 -0400", hash_original_method = "E2366875958D829A580E669A2DB1A4B1", hash_generated_method = "8864C229845A0E2CC8F7FDA72470613D")
    public void msync(long address, long byteCount, int flags) throws ErrnoException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.392 -0400", hash_original_method = "300DE062DB1D5D96D86ACEAAE1343E18", hash_generated_method = "E47F369491E1B5E634DDD0810DD2F19A")
    public void munlock(long address, long byteCount) throws ErrnoException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.393 -0400", hash_original_method = "FD321BF6752ECFAABCD6429010BD098F", hash_generated_method = "08EB766C3DA5DD7C92B90F48070EBB89")
    public void munmap(long address, long byteCount) throws ErrnoException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.393 -0400", hash_original_method = "B03C285733E86D432A31E9556E29D38C", hash_generated_method = "3895485A804EB3F7CACE7511B2B310A8")
    public FileDescriptor open(String path, int flags, int mode) throws ErrnoException {
    	FileDescriptor fd = new FileDescriptor();
    	fd.addTaint(path.getTaint());
    	fd.addTaint(mode);
    	fd.addTaint(flags);
    	return fd;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.393 -0400", hash_original_method = "15C3A12A736BB4281EA7C1CDE4AB9480", hash_generated_method = "656244847670CC9BF6362B959913631F")
    public FileDescriptor[] pipe() throws ErrnoException {
    	FileDescriptor[] arr=  {new FileDescriptor()};
    	return arr;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.393 -0400", hash_original_method = "A333C05E603FD568E448FA55BD420BEE", hash_generated_method = "2B14B660CBDBC77400B55A268341AB0A")
    public int poll(StructPollfd[] fds, int timeoutMs) throws ErrnoException {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_497952812 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_497952812;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.393 -0400", hash_original_method = "FD23B60A9051753476B14299BED1F849", hash_generated_method = "46FE8C5F7DD68DFA4DD52E227C8AD6FC")
    public int pread(FileDescriptor fd, ByteBuffer buffer, long offset) throws ErrnoException {
        {
            boolean var21D6A43A19BB11FD75F2555CEDDC72D3_398392348 = (buffer.isDirect());
            {
                int var8E7907A41BEF94A8EBD28CB040D098F0_1868617077 = (preadBytes(fd, buffer, buffer.position(), buffer.remaining(), offset));
            } //End block
            {
                int var1F069D630372EF5D70684AA69ABBB191_700275951 = (preadBytes(fd, NioUtils.unsafeArray(buffer), NioUtils.unsafeArrayOffset(buffer) + buffer.position(), buffer.remaining(), offset));
            } //End block
        } //End collapsed parenthetic
        addTaint(fd.getTaint());
        addTaint(buffer.getTaint());
        addTaint(offset);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1923143411 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1923143411;
        // ---------- Original Method ----------
        //if (buffer.isDirect()) {
            //return preadBytes(fd, buffer, buffer.position(), buffer.remaining(), offset);
        //} else {
            //return preadBytes(fd, NioUtils.unsafeArray(buffer), NioUtils.unsafeArrayOffset(buffer) + buffer.position(), buffer.remaining(), offset);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.394 -0400", hash_original_method = "4B8706AF5748B9EE5E9BCCA6FC3C73C0", hash_generated_method = "69B3393150AD94F336A2FAC6A59898B0")
    public int pread(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount, long offset) throws ErrnoException {
        int varCF530DD83FC2922F479A426BEFE4CB6B_1540379869 = (preadBytes(fd, bytes, byteOffset, byteCount, offset));
        addTaint(fd.getTaint());
        addTaint(bytes[0]);
        addTaint(byteOffset);
        addTaint(byteCount);
        addTaint(offset);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_256533973 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_256533973;
        // ---------- Original Method ----------
        //return preadBytes(fd, bytes, byteOffset, byteCount, offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.394 -0400", hash_original_method = "5819B25FAD4FEDA7F174A32C15365436", hash_generated_method = "994FC10CE2860D2B897D89F24381E36E")
    private int preadBytes(FileDescriptor fd, Object buffer, int bufferOffset, int byteCount, long offset) throws ErrnoException {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_485191154 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_485191154;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.395 -0400", hash_original_method = "DB8AC8A16E91B9F291442450334BCFF2", hash_generated_method = "C45AD2E21038AD97409479CC9FAB5C79")
    public int pwrite(FileDescriptor fd, ByteBuffer buffer, long offset) throws ErrnoException {
        {
            boolean var21D6A43A19BB11FD75F2555CEDDC72D3_1081178199 = (buffer.isDirect());
            {
                int var87D5C3FD697C182EDD756D3EFF6529D7_1345757148 = (pwriteBytes(fd, buffer, buffer.position(), buffer.remaining(), offset));
            } //End block
            {
                int var6DAE9A5C537D89AF40EB6C242AD74611_1295027363 = (pwriteBytes(fd, NioUtils.unsafeArray(buffer), NioUtils.unsafeArrayOffset(buffer) + buffer.position(), buffer.remaining(), offset));
            } //End block
        } //End collapsed parenthetic
        addTaint(fd.getTaint());
        addTaint(buffer.getTaint());
        addTaint(offset);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1200246707 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1200246707;
        // ---------- Original Method ----------
        //if (buffer.isDirect()) {
            //return pwriteBytes(fd, buffer, buffer.position(), buffer.remaining(), offset);
        //} else {
            //return pwriteBytes(fd, NioUtils.unsafeArray(buffer), NioUtils.unsafeArrayOffset(buffer) + buffer.position(), buffer.remaining(), offset);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.396 -0400", hash_original_method = "364FA462AFF3FCDD2B79B5A0A9405455", hash_generated_method = "32DC50E5C31173461DC0EF0B82AB9E4E")
    public int pwrite(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount, long offset) throws ErrnoException {
        int varFC5C8D1266385A06B48EE648ACD7657C_1519203927 = (pwriteBytes(fd, bytes, byteOffset, byteCount, offset));
        addTaint(fd.getTaint());
        addTaint(bytes[0]);
        addTaint(byteOffset);
        addTaint(byteCount);
        addTaint(offset);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1944877467 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1944877467;
        // ---------- Original Method ----------
        //return pwriteBytes(fd, bytes, byteOffset, byteCount, offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.396 -0400", hash_original_method = "90B6FC1B27EC82D887BE52674747E195", hash_generated_method = "73557C7202BCF522904A50F08B767EFB")
    private int pwriteBytes(FileDescriptor fd, Object buffer, int bufferOffset, int byteCount, long offset) throws ErrnoException {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1357930468 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1357930468;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.397 -0400", hash_original_method = "ADE2F5685BF490A50DE36063F7A06769", hash_generated_method = "7BE515E295616A633A18CCDC19F3967D")
    public int read(FileDescriptor fd, ByteBuffer buffer) throws ErrnoException {
        {
            boolean var21D6A43A19BB11FD75F2555CEDDC72D3_226485712 = (buffer.isDirect());
            {
                int varD5A85510F41F9F59964F2A7FD9630E4C_1422519489 = (readBytes(fd, buffer, buffer.position(), buffer.remaining()));
            } //End block
            {
                int varC2696D40F0D039BC87FD96259E5276FD_1437190408 = (readBytes(fd, NioUtils.unsafeArray(buffer), NioUtils.unsafeArrayOffset(buffer) + buffer.position(), buffer.remaining()));
            } //End block
        } //End collapsed parenthetic
        addTaint(fd.getTaint());
        addTaint(buffer.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2079404069 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2079404069;
        // ---------- Original Method ----------
        //if (buffer.isDirect()) {
            //return readBytes(fd, buffer, buffer.position(), buffer.remaining());
        //} else {
            //return readBytes(fd, NioUtils.unsafeArray(buffer), NioUtils.unsafeArrayOffset(buffer) + buffer.position(), buffer.remaining());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.398 -0400", hash_original_method = "6168115C79D46336D7C888D619663F88", hash_generated_method = "1FADFD8013CF2A702ACC8D7544EFFF17")
    public int read(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount) throws ErrnoException {
        int varAF7FBEB1A05EE593C49B78D715290282_355486435 = (readBytes(fd, bytes, byteOffset, byteCount));
        addTaint(fd.getTaint());
        addTaint(bytes[0]);
        addTaint(byteOffset);
        addTaint(byteCount);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1169279883 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1169279883;
        // ---------- Original Method ----------
        //return readBytes(fd, bytes, byteOffset, byteCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.398 -0400", hash_original_method = "2C7E892AABA7BE06DDD2C6AC692575BC", hash_generated_method = "9261813ADC5D910B0FAE43AA9835F721")
    private int readBytes(FileDescriptor fd, Object buffer, int offset, int byteCount) throws ErrnoException {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1711941613 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1711941613;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.399 -0400", hash_original_method = "D5205EB48193928ACF79029A7B33E86B", hash_generated_method = "1CD6675B3C1D2AE607D53CCC3BD4A8AE")
    public int readv(FileDescriptor fd, Object[] buffers, int[] offsets, int[] byteCounts) throws ErrnoException {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_480489854 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_480489854;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.399 -0400", hash_original_method = "41329575D83AD4CCCAB565E77BA083D5", hash_generated_method = "565D26EFB32BC3E79B7DC483DF61255D")
    public int recvfrom(FileDescriptor fd, ByteBuffer buffer, int flags, InetSocketAddress srcAddress) throws ErrnoException {
        {
            boolean var21D6A43A19BB11FD75F2555CEDDC72D3_1618119416 = (buffer.isDirect());
            {
                int varF31574244E582FAAC1D4E5A3117CCAD5_288958616 = (recvfromBytes(fd, buffer, buffer.position(), buffer.remaining(), flags, srcAddress));
            } //End block
            {
                int var754A91E49CCFCF0B12E0E37D924384F6_675940397 = (recvfromBytes(fd, NioUtils.unsafeArray(buffer), NioUtils.unsafeArrayOffset(buffer) + buffer.position(), buffer.remaining(), flags, srcAddress));
            } //End block
        } //End collapsed parenthetic
        addTaint(fd.getTaint());
        addTaint(buffer.getTaint());
        addTaint(flags);
        addTaint(srcAddress.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1231366199 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1231366199;
        // ---------- Original Method ----------
        //if (buffer.isDirect()) {
            //return recvfromBytes(fd, buffer, buffer.position(), buffer.remaining(), flags, srcAddress);
        //} else {
            //return recvfromBytes(fd, NioUtils.unsafeArray(buffer), NioUtils.unsafeArrayOffset(buffer) + buffer.position(), buffer.remaining(), flags, srcAddress);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.399 -0400", hash_original_method = "D6B3FC14ED62FEA7873773B8EF3E6A7B", hash_generated_method = "1A3707B7B05410578EFBF01EA5ACF825")
    public int recvfrom(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount, int flags, InetSocketAddress srcAddress) throws ErrnoException {
        int var5C3B514BF02C0C51E1C7926B1634D11C_1549932867 = (recvfromBytes(fd, bytes, byteOffset, byteCount, flags, srcAddress));
        addTaint(fd.getTaint());
        addTaint(bytes[0]);
        addTaint(byteOffset);
        addTaint(byteCount);
        addTaint(flags);
        addTaint(srcAddress.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2023162953 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2023162953;
        // ---------- Original Method ----------
        //return recvfromBytes(fd, bytes, byteOffset, byteCount, flags, srcAddress);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.400 -0400", hash_original_method = "4ADC9C5F635814CDC8DA4D81B23D96F7", hash_generated_method = "9A50D192B62BEB650E6C1745F2F4AD8F")
    private int recvfromBytes(FileDescriptor fd, Object buffer, int byteOffset, int byteCount, int flags, InetSocketAddress srcAddress) throws ErrnoException {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_558437237 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_558437237;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.400 -0400", hash_original_method = "C4D2972D60AD59B1B88202B59332518F", hash_generated_method = "F785749D71099D3C2EF1A4F3482E2FC9")
    public void remove(String path) throws ErrnoException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.400 -0400", hash_original_method = "79CCF6DA9C97D5D1A767D340D63FA141", hash_generated_method = "ECFA7C07C31807064D12083B534138D1")
    public void rename(String oldPath, String newPath) throws ErrnoException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.400 -0400", hash_original_method = "9AFCCF531361D938553CC3693890CE79", hash_generated_method = "AAF3E0377715383B5981D8E73DCBFB3F")
    public long sendfile(FileDescriptor outFd, FileDescriptor inFd, MutableLong inOffset, long byteCount) throws ErrnoException {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1620474526 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1620474526;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.401 -0400", hash_original_method = "CE9DE10B0135BB1F72B6E5CF17271781", hash_generated_method = "4758D9285C162C4093C437DE5DFA4B54")
    public int sendto(FileDescriptor fd, ByteBuffer buffer, int flags, InetAddress inetAddress, int port) throws ErrnoException {
        {
            boolean var21D6A43A19BB11FD75F2555CEDDC72D3_1978962709 = (buffer.isDirect());
            {
                int var5E9D1647C6154DCE995D5EEEB1605F7B_1629203414 = (sendtoBytes(fd, buffer, buffer.position(), buffer.remaining(), flags, inetAddress, port));
            } //End block
            {
                int var454BEDFAD70DADFAA662DB20DF483B42_1425151439 = (sendtoBytes(fd, NioUtils.unsafeArray(buffer), NioUtils.unsafeArrayOffset(buffer) + buffer.position(), buffer.remaining(), flags, inetAddress, port));
            } //End block
        } //End collapsed parenthetic
        addTaint(fd.getTaint());
        addTaint(buffer.getTaint());
        addTaint(flags);
        addTaint(inetAddress.getTaint());
        addTaint(port);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_847031305 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_847031305;
        // ---------- Original Method ----------
        //if (buffer.isDirect()) {
            //return sendtoBytes(fd, buffer, buffer.position(), buffer.remaining(), flags, inetAddress, port);
        //} else {
            //return sendtoBytes(fd, NioUtils.unsafeArray(buffer), NioUtils.unsafeArrayOffset(buffer) + buffer.position(), buffer.remaining(), flags, inetAddress, port);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.401 -0400", hash_original_method = "23CCF7407B7F91C60BE72C6923799443", hash_generated_method = "AE02F7D0FA6DBE462B43B3E03CDE8CB4")
    public int sendto(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount, int flags, InetAddress inetAddress, int port) throws ErrnoException {
        int varE214C015B4D6A01301684BB848AD3BF2_1587178489 = (sendtoBytes(fd, bytes, byteOffset, byteCount, flags, inetAddress, port));
        addTaint(fd.getTaint());
        addTaint(bytes[0]);
        addTaint(byteOffset);
        addTaint(byteCount);
        addTaint(flags);
        addTaint(inetAddress.getTaint());
        addTaint(port);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_301800609 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_301800609;
        // ---------- Original Method ----------
        //return sendtoBytes(fd, bytes, byteOffset, byteCount, flags, inetAddress, port);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.401 -0400", hash_original_method = "F841D540A211C98E750DE668FD283BE2", hash_generated_method = "8C246F74F6C9DE13D0BF8AE9609AF1DE")
    private int sendtoBytes(FileDescriptor fd, Object buffer, int byteOffset, int byteCount, int flags, InetAddress inetAddress, int port) throws ErrnoException {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_205013995 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_205013995;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.402 -0400", hash_original_method = "4EDFF9AE0EBC71C5A87E99E89B76EA1C", hash_generated_method = "5E48F6E110C1016C239B842F8C474176")
    public void setegid(int egid) throws ErrnoException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.402 -0400", hash_original_method = "A63D77D63BF9B7372008734FF96F48BC", hash_generated_method = "D406270C51FEA4C57DDD126C99DCDAC4")
    public void seteuid(int euid) throws ErrnoException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.402 -0400", hash_original_method = "5915305B25E8BEDA092C77560CFF8FA0", hash_generated_method = "C0F83CBE23D4A2D3DF140C77705BC0FD")
    public void setgid(int gid) throws ErrnoException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.402 -0400", hash_original_method = "9A5169BBE0282BCC00E74B397F068D4B", hash_generated_method = "3E08FEFBDE4D2BF5FCDEA705F6189D5A")
    public void setsockoptByte(FileDescriptor fd, int level, int option, int value) throws ErrnoException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.402 -0400", hash_original_method = "5041A6120F51EBC2B109E6AF0AE7FC14", hash_generated_method = "E635827CCD8247E74839393BBD93500E")
    public void setsockoptIfreq(FileDescriptor fd, int level, int option, String value) throws ErrnoException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.403 -0400", hash_original_method = "CE894EBBCEEC6D8A98A23F1D6DFA91AF", hash_generated_method = "A343E3AD0EAD83A0531ADBCCF86109AA")
    public void setsockoptInt(FileDescriptor fd, int level, int option, int value) throws ErrnoException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.403 -0400", hash_original_method = "6DBB3F1DC41874C1778513E87DD13712", hash_generated_method = "96EE4BF8E717F1B21BE9FA5405FB5833")
    public void setsockoptIpMreqn(FileDescriptor fd, int level, int option, int value) throws ErrnoException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.403 -0400", hash_original_method = "44866C5C735DD960E2B282162D2DFF44", hash_generated_method = "2464FDFB24FF4B764E38B335F935BD04")
    public void setsockoptGroupReq(FileDescriptor fd, int level, int option, StructGroupReq value) throws ErrnoException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.403 -0400", hash_original_method = "8265FFDA0D5B54E0714AF7F36058F0FD", hash_generated_method = "C0337305BF631A0C473462C66250C132")
    public void setsockoptLinger(FileDescriptor fd, int level, int option, StructLinger value) throws ErrnoException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.404 -0400", hash_original_method = "D0EFA67C69EE44E619BC32AD0ABAAA94", hash_generated_method = "E68EB8161F63BB5AD5B88B1DA31DE467")
    public void setsockoptTimeval(FileDescriptor fd, int level, int option, StructTimeval value) throws ErrnoException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.404 -0400", hash_original_method = "7541ED33DCEBBB89FE1430508C680E96", hash_generated_method = "98772075B4300BB00447E5FD75DA804A")
    public void setuid(int uid) throws ErrnoException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.405 -0400", hash_original_method = "1961EE437DD0A4352BCFCF2F346982D9", hash_generated_method = "AF53C7188D1B544BB358D63F5C774F2E")
    public void shutdown(FileDescriptor fd, int how) throws ErrnoException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.405 -0400", hash_original_method = "738E096C5E6C6A5066A76A9B90DC0CA9", hash_generated_method = "7CA7350BE0F647E1FAD6CC5C953D3D40")
    public FileDescriptor socket(int domain, int type, int protocol) throws ErrnoException {
    	FileDescriptor fd = new FileDescriptor();
    	fd.addTaint(domain);
    	fd.addTaint(type);
    	fd.addTaint(protocol);
    	return fd;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.406 -0400", hash_original_method = "6347DE7B46FE3FC2519EB3B202A3981D", hash_generated_method = "A5CDFE2A5FE4F4A6DDEBA3884597AC82")
    public StructStat stat(String path) throws ErrnoException {
    	StructStat ret = new StructStat(DSUtils.UNKNOWN_LONG, DSUtils.UNKNOWN_LONG, DSUtils.UNKNOWN_INT,
    			DSUtils.UNKNOWN_LONG, DSUtils.UNKNOWN_INT, DSUtils.UNKNOWN_INT, DSUtils.UNKNOWN_LONG,
    			DSUtils.UNKNOWN_LONG, DSUtils.UNKNOWN_LONG, DSUtils.UNKNOWN_LONG, DSUtils.UNKNOWN_LONG,
    			DSUtils.UNKNOWN_LONG, DSUtils.UNKNOWN_LONG);
    	ret.addTaint(path.getTaint());
    	return ret;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.406 -0400", hash_original_method = "5BCA24F466E28D74A0DD2E3DB7220B64", hash_generated_method = "ECEC00D3A13CFD9DCFFA731CEEB7943C")
    public StructStatFs statfs(String path) throws ErrnoException {
    	StructStatFs ret = new StructStatFs(DSUtils.UNKNOWN_LONG, DSUtils.UNKNOWN_LONG, DSUtils.UNKNOWN_LONG,
    			DSUtils.UNKNOWN_LONG, DSUtils.UNKNOWN_LONG, DSUtils.UNKNOWN_LONG, DSUtils.UNKNOWN_LONG,
    			DSUtils.UNKNOWN_LONG);
    	ret.addTaint(path.getTaint());
    	return ret;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.406 -0400", hash_original_method = "DF22551AABB4776AE8588CD853791D73", hash_generated_method = "4B2628A376EBCD8E0BF3F6673B683BA7")
    public String strerror(int errno) {
    	String s = new String();
    	s.addTaint(errno);
    	return s;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.407 -0400", hash_original_method = "551DE00FB0B39FAF904A5DC205CAA2EB", hash_generated_method = "A129CF58BB7DCBA118CE2E16606EEC07")
    public void symlink(String oldPath, String newPath) throws ErrnoException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.407 -0400", hash_original_method = "0CA56D59A1B623A4EE1DB5A7E1204662", hash_generated_method = "1F4F0DC7642EC749BC7DDA0DE12AD82D")
    public long sysconf(int name) {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1635036830 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1635036830;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.407 -0400", hash_original_method = "840E5C1D01B396A2EA80B4AFD333B092", hash_generated_method = "6171D41EBFE7E809E74F1D080C3D2A62")
    public StructUtsname uname() {
    	return new StructUtsname(new String(), new String(), new String(), new String(), new String());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.407 -0400", hash_original_method = "FE84032F23145F65306977A4498767E9", hash_generated_method = "3E5F75BC99C38D6F0471122A2E60543F")
    public int waitpid(int pid, MutableInt status, int options) throws ErrnoException {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_744964208 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_744964208;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.408 -0400", hash_original_method = "FF46C2F8D2234796363F6B9031191E3B", hash_generated_method = "0796EB7A5B30A281F8658C6ABA1F8968")
    public int write(FileDescriptor fd, ByteBuffer buffer) throws ErrnoException {
        {
            boolean var21D6A43A19BB11FD75F2555CEDDC72D3_2072866768 = (buffer.isDirect());
            {
                int var018A5CC680E3A7E1C50076224C8C7605_1302665036 = (writeBytes(fd, buffer, buffer.position(), buffer.remaining()));
            } //End block
            {
                int var30C5EA943FBFB1242D64083C74DD8D3D_1310905279 = (writeBytes(fd, NioUtils.unsafeArray(buffer), NioUtils.unsafeArrayOffset(buffer) + buffer.position(), buffer.remaining()));
            } //End block
        } //End collapsed parenthetic
        addTaint(fd.getTaint());
        addTaint(buffer.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2052004563 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2052004563;
        // ---------- Original Method ----------
        //if (buffer.isDirect()) {
            //return writeBytes(fd, buffer, buffer.position(), buffer.remaining());
        //} else {
            //return writeBytes(fd, NioUtils.unsafeArray(buffer), NioUtils.unsafeArrayOffset(buffer) + buffer.position(), buffer.remaining());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.408 -0400", hash_original_method = "077A8F097DECE8A2C8BBB2583BE2D8BE", hash_generated_method = "9922623F4C095E4D03E0E215009F69D9")
    public int write(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount) throws ErrnoException {
        int var68D561E1E5C78821FF2B2E24F418F392_1006445641 = (writeBytes(fd, bytes, byteOffset, byteCount));
        addTaint(fd.getTaint());
        addTaint(bytes[0]);
        addTaint(byteOffset);
        addTaint(byteCount);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_793448626 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_793448626;
        // ---------- Original Method ----------
        //return writeBytes(fd, bytes, byteOffset, byteCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.408 -0400", hash_original_method = "E853B1F146558B1458DE2FB65CF651EB", hash_generated_method = "D2DEC757AA80C08147AD41FEE74BBA60")
    private int writeBytes(FileDescriptor fd, Object buffer, int offset, int byteCount) throws ErrnoException {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1719543757 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1719543757;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.409 -0400", hash_original_method = "B9E2C692ADA119F653BB2CBF261E7047", hash_generated_method = "CB497A66E34226FE252CCC10EAB10DEC")
    public int writev(FileDescriptor fd, Object[] buffers, int[] offsets, int[] byteCounts) throws ErrnoException {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1915215568 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1915215568;
    }

    
}

