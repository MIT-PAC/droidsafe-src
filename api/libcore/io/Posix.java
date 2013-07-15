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
import java.nio.NioUtils;
import libcore.util.MutableInt;
import libcore.util.MutableLong;

public final class Posix implements Os {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.882 -0400", hash_original_method = "4046CDE00BB837810E8AFBFF17A6CE8F", hash_generated_method = "05221F2C631AA96E1462A4F7CC11A1BC")
      Posix() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.381 -0400", hash_original_method = "3FF894EBDB6D10C08E17FEF79D8BBDA9", hash_generated_method = "CD0A84B225A700801CB0CB5C048B5F64")
    public FileDescriptor accept(FileDescriptor fd, InetSocketAddress peerAddress) throws ErrnoException {
    	FileDescriptor ret = new FileDescriptor();
    	ret.addTaint(peerAddress.getTaint());
    	return ret;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.882 -0400", hash_original_method = "B1689CE6DA8AD962BE72C0197D9C07BB", hash_generated_method = "BFCF43581C6ACC98DCE012A728DD5645")
    public boolean access(String path, int mode) throws ErrnoException {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1280874118 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1280874118;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.883 -0400", hash_original_method = "291C8049FE6F5CDE681BB5AEA2008B38", hash_generated_method = "84FB031E5366E9FCB162C111EEB27C87")
    public void bind(FileDescriptor fd, InetAddress address, int port) throws ErrnoException {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.883 -0400", hash_original_method = "C6B53F2282285C6075341EF2C607CF79", hash_generated_method = "1ADDDBE52AB61E2DC2D40B06BD38924E")
    public void chmod(String path, int mode) throws ErrnoException {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.883 -0400", hash_original_method = "5621A98DBDE11BB13B9D88FD5C4303F9", hash_generated_method = "88AC1D1AA0DA20420EB3EC3F557D0CE2")
    public void close(FileDescriptor fd) throws ErrnoException {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.883 -0400", hash_original_method = "583B21CF7E43DBF5EACD223A833123C4", hash_generated_method = "32A14EC0714501BE2AD1DD1B23C061AD")
    public void connect(FileDescriptor fd, InetAddress address, int port) throws ErrnoException {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.382 -0400", hash_original_method = "3C30A8714976314FBC047CABB70B8D73", hash_generated_method = "E9F5AF0FB41B7707675BC76D1920487E")
    public FileDescriptor dup(FileDescriptor oldFd) throws ErrnoException {
    	FileDescriptor ret = new FileDescriptor();
    	ret.setInt$(oldFd.getInt$());
    	return ret;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.382 -0400", hash_original_method = "3FF27FFFD1EDB0C110A074DD6B27552E", hash_generated_method = "CA84B272541AD90B218B5342DA7CD207")
    public FileDescriptor dup2(FileDescriptor oldFd, int newFd) throws ErrnoException {
    	FileDescriptor ret = new FileDescriptor();
    	ret.setInt$(newFd);
    	ret.addTaint(oldFd.getTaint());
    	return ret;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.382 -0400", hash_original_method = "76B056F20AEC72841BA98095F8E6CB34", hash_generated_method = "ADADA30B919F80A500FE6D3D2633BB36")
    public String[] environ() {
    	String[] arr = {new String()};
    	return arr;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.884 -0400", hash_original_method = "2CB0275F8932D4CF3644D073C3F0700F", hash_generated_method = "E9577352E162AA549FB2C2228529EC2C")
    public int fcntlVoid(FileDescriptor fd, int cmd) throws ErrnoException {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1163778413 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1163778413;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.884 -0400", hash_original_method = "2A7DB0B256B2976732DDA9A901297EFA", hash_generated_method = "8D00C33E3EB9BEE4B82DCEE676C282E8")
    public int fcntlLong(FileDescriptor fd, int cmd, long arg) throws ErrnoException {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1855741427 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1855741427;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.885 -0400", hash_original_method = "5842C7622D740E7A11EA29095C58FEF2", hash_generated_method = "0429BA34ECBE79931BDEC463C842278D")
    public int fcntlFlock(FileDescriptor fd, int cmd, StructFlock arg) throws ErrnoException {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_800194118 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_800194118;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.885 -0400", hash_original_method = "CC5ECBC11DCDAEE11F3D1714EA5105D5", hash_generated_method = "2476A3C255789407A2CB89613FFC0767")
    public void fdatasync(FileDescriptor fd) throws ErrnoException {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.383 -0400", hash_original_method = "285E3CF7F1EFC8C330731E11EF4C59B4", hash_generated_method = "FB432B0A46E67C4A515FC7D39713ADEE")
    public StructStat fstat(FileDescriptor fd) throws ErrnoException {
    	StructStat ret = new StructStat(DSUtils.UNKNOWN_LONG, DSUtils.UNKNOWN_LONG, DSUtils.UNKNOWN_INT,
    			DSUtils.UNKNOWN_LONG, DSUtils.UNKNOWN_INT, DSUtils.UNKNOWN_INT, DSUtils.UNKNOWN_LONG,
    			DSUtils.UNKNOWN_LONG, DSUtils.UNKNOWN_LONG, DSUtils.UNKNOWN_LONG, DSUtils.UNKNOWN_LONG,
    			DSUtils.UNKNOWN_LONG, DSUtils.UNKNOWN_LONG);
    	ret.addTaint(fd.getTaint());
    	return ret;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.383 -0400", hash_original_method = "1A9BE1A7FA5485B333D3854795E798C3", hash_generated_method = "2D430EC1E5F2AB304F57C6A4D3ACACFD")
    public StructStatFs fstatfs(FileDescriptor fd) throws ErrnoException {
    	StructStatFs ret = new StructStatFs(DSUtils.UNKNOWN_LONG, DSUtils.UNKNOWN_LONG, DSUtils.UNKNOWN_LONG,
    			DSUtils.UNKNOWN_LONG, DSUtils.UNKNOWN_LONG, DSUtils.UNKNOWN_LONG, DSUtils.UNKNOWN_LONG,
    			DSUtils.UNKNOWN_LONG);
    	ret.addTaint(fd.getTaint());
    	return ret;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.885 -0400", hash_original_method = "BC5DB2B4AC1C25097A3FF5E2C6AF2CA8", hash_generated_method = "E54FD0DB1F8F4382C4F5D3AC3B6E8F36")
    public void fsync(FileDescriptor fd) throws ErrnoException {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.886 -0400", hash_original_method = "C3B05E353984E75A36400D4268798B4D", hash_generated_method = "4E6152073BE3DCA66E0B3ACC6C860A59")
    public void ftruncate(FileDescriptor fd, long length) throws ErrnoException {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.384 -0400", hash_original_method = "26A40D218A150DBB5E3B431436FD5A7B", hash_generated_method = "27F87296D375B8957098A9ECC28029AB")
    public String gai_strerror(int error) {
    	String s = new String();
    	s.addTaint(error);
    	return s;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.384 -0400", hash_original_method = "40F18080B746539908D74665104D4EA0", hash_generated_method = "130FA52FE5275831CC890F85A8CD5D33")
    public InetAddress[] getaddrinfo(String node, StructAddrinfo hints) throws GaiException {
    	return new InetAddress[1];
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.886 -0400", hash_original_method = "B351A98E9308B82B72BD8C1A77C5DADB", hash_generated_method = "6610B41E6161829FB610DDFAC18C343B")
    public int getegid() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_432438747 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_432438747;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.887 -0400", hash_original_method = "03FF5CC42F38A66A948C17532C044A2D", hash_generated_method = "4C812DEEF3F8BDACBFC11257346283C7")
    public int geteuid() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2082927147 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2082927147;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.887 -0400", hash_original_method = "82D0BD1E53FB93AB39C412F5615316CA", hash_generated_method = "B15872F24F28621B203DD3EE82B24811")
    public int getgid() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1163580327 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1163580327;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.385 -0400", hash_original_method = "ABE371B1B9ED1CAFA0922C4EB05C6BA3", hash_generated_method = "06988C5468266BFC53F857DF1F3A7080")
    public String getenv(String name) {
    	String s = new String();
    	s.addTaint(name.getTaint());
    	return s;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.385 -0400", hash_original_method = "A0AFA0E6B104A41B1981D0BE816BBE02", hash_generated_method = "5E0DD6AFD3DD827B3E5DE5816011CF57")
    public String getnameinfo(InetAddress address, int flags) throws GaiException {
    	String s = new String();
    	s.addTaint(address.getTaint());
    	s.addTaint(flags);
    	return s;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.887 -0400", hash_original_method = "ED1FF6EE6302372A02F6AB9DF837F424", hash_generated_method = "5882707813C880889E03AB02A8F68D47")
    public int getpid() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1221504638 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1221504638;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.888 -0400", hash_original_method = "E9C872CD5783C25015966D177C4AF8C6", hash_generated_method = "A2DF1BCA1BF0AD46B204C2C2DD7C7226")
    public int getppid() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1850048329 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1850048329;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.386 -0400", hash_original_method = "CC95F691F046B008F87F75EBB754B9F4", hash_generated_method = "9940A20D3850D7F380FC87AC6AF2F6E5")
    public StructPasswd getpwnam(String name) throws ErrnoException {
    	StructPasswd spwd = new StructPasswd(name, DSUtils.UNKNOWN_INT, DSUtils.UNKNOWN_INT, new String(), new String());
    	return spwd;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.386 -0400", hash_original_method = "F193108F2C48DAFAA33D43EBB961E0C4", hash_generated_method = "59D5893F141FDA927A6CE1BDE49A8CA7")
    public StructPasswd getpwuid(int uid) throws ErrnoException {
    	StructPasswd spwd = new StructPasswd(new String(), uid, DSUtils.UNKNOWN_INT, new String(), new String());
    	return spwd;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.387 -0400", hash_original_method = "BDE1CE7D74C0BBEFDC894A32FA56505C", hash_generated_method = "FEAEAFB793CE2332A26745CF5809AB9A")
    public SocketAddress getsockname(FileDescriptor fd) throws ErrnoException {
    	SocketAddress sa = new SocketAddress() {
			private static final long serialVersionUID = 1L;
		};
		sa.addTaint(fd.getTaint());
		return sa;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.889 -0400", hash_original_method = "51446225C69A8CF648D53B0005AE4AA4", hash_generated_method = "8AFAA2E98CFD17F8C2BC6B816914F15A")
    public int getsockoptByte(FileDescriptor fd, int level, int option) throws ErrnoException {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1041936377 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1041936377;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.387 -0400", hash_original_method = "5BB8092DA4409A5D55882AE524C48CC0", hash_generated_method = "D3C69B8918D913F313F29C114573160B")
    public InetAddress getsockoptInAddr(FileDescriptor fd, int level, int option) throws ErrnoException {
    	InetAddress ia = InetAddress.UNSPECIFIED;
    	ia.addTaint(fd.getTaint());
    	return ia;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.889 -0400", hash_original_method = "B939E72BF03DDCEDAC639A7621114578", hash_generated_method = "CCC6EB5C2DBA80EB785ED43E85B3B221")
    public int getsockoptInt(FileDescriptor fd, int level, int option) throws ErrnoException {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1186810012 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1186810012;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.388 -0400", hash_original_method = "FEC6121EA2A897FBB99121F96B439FBB", hash_generated_method = "F60821EF1BF0B8831D7AAFEE843DD949")
    public StructLinger getsockoptLinger(FileDescriptor fd, int level, int option) throws ErrnoException {
    	StructLinger sl = new StructLinger(DSUtils.UNKNOWN_INT,DSUtils.UNKNOWN_INT);
    	return sl;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.389 -0400", hash_original_method = "F02C71E9B42FAB3C0C2F8E812A8DAE0B", hash_generated_method = "6CA79EDA1D97037C4E5A07F27DEFAAF6")
    public StructTimeval getsockoptTimeval(FileDescriptor fd, int level, int option) throws ErrnoException {
    	StructTimeval st = StructTimeval.fromMillis(DSUtils.UNKNOWN_LONG);
    	st.addTaint(fd.getTaint());
    	return st;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.890 -0400", hash_original_method = "DCBAE976FF6D195847EC9B9CCBB16DA2", hash_generated_method = "98922D859CDB5D503B6BC7721DF2DB6D")
    public int getuid() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_899971989 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_899971989;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.390 -0400", hash_original_method = "BC4349F875DD5C315A8CC9563ABD32ED", hash_generated_method = "5D3B61863086951BE5EE225ADA00E818")
    public String if_indextoname(int index) {
    	String s = new String();
    	s.addTaint(index);
    	return s;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.390 -0400", hash_original_method = "2643CEE6EE9643256D8BA72042097190", hash_generated_method = "45DBEA6F2642076EEB7596214278AC69")
    public InetAddress inet_pton(int family, String address) {
    	return InetAddress.UNSPECIFIED;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.390 -0400", hash_original_method = "E90DEAC8BD65E718B0E2ACEED6C5AEE3", hash_generated_method = "BBFCB604834C488636C059270740197B")
    public InetAddress ioctlInetAddress(FileDescriptor fd, int cmd, String interfaceName) throws ErrnoException {
    	return InetAddress.UNSPECIFIED;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.891 -0400", hash_original_method = "06336F68D97266AEF577672F8C03A8E4", hash_generated_method = "30D64C83DA4B6A74882759A0CB7465CF")
    public int ioctlInt(FileDescriptor fd, int cmd, MutableInt arg) throws ErrnoException {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1750439577 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1750439577;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.891 -0400", hash_original_method = "94B275389FB7735E79DD0606BB6663FC", hash_generated_method = "750B50B23648EA9FBB6BE73DC9272168")
    public boolean isatty(FileDescriptor fd) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1038491404 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1038491404;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.892 -0400", hash_original_method = "77BC6E1CDAEA7EC218D4C88B6DD6F628", hash_generated_method = "F6F6E534CA3E6662FA9A588696A9D1A5")
    public void kill(int pid, int signal) throws ErrnoException {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.892 -0400", hash_original_method = "6ED23D1EA76BF029EEF21B4EAFA6CFF2", hash_generated_method = "DAA83A0CD96D69C2B0AA6D7503222609")
    public void listen(FileDescriptor fd, int backlog) throws ErrnoException {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.892 -0400", hash_original_method = "6DE073E1DD2161D7E507CF5C1E8B8B5C", hash_generated_method = "EC6F506ED10BAC53695FF37786EFC6CC")
    public long lseek(FileDescriptor fd, long offset, int whence) throws ErrnoException {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1929243858 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1929243858;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.391 -0400", hash_original_method = "D639C215CF59CE0021DA2A9DC0F695A4", hash_generated_method = "E0143F1BAA64A6BF1E9A18B98E107A79")
    public StructStat lstat(String path) throws ErrnoException {
    	StructStat ret = new StructStat(DSUtils.UNKNOWN_LONG, DSUtils.UNKNOWN_LONG, DSUtils.UNKNOWN_INT,
    			DSUtils.UNKNOWN_LONG, DSUtils.UNKNOWN_INT, DSUtils.UNKNOWN_INT, DSUtils.UNKNOWN_LONG,
    			DSUtils.UNKNOWN_LONG, DSUtils.UNKNOWN_LONG, DSUtils.UNKNOWN_LONG, DSUtils.UNKNOWN_LONG,
    			DSUtils.UNKNOWN_LONG, DSUtils.UNKNOWN_LONG);
    	ret.addTaint(path.getTaint());
    	return ret;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.893 -0400", hash_original_method = "EC9A299C6214A51B56DA51B591F6FF36", hash_generated_method = "F10B9DD324CECF0A86818AC7CC0C8EAB")
    public void mincore(long address, long byteCount, byte[] vector) throws ErrnoException {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.893 -0400", hash_original_method = "4CC22C39A827987000370BD10B3B7F89", hash_generated_method = "5A7BEC510CF43D25B53554F6D2F2A2AE")
    public void mkdir(String path, int mode) throws ErrnoException {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.893 -0400", hash_original_method = "40B753FBD702B9115A8CFFA4EBDDD434", hash_generated_method = "ED2C99AFEF903695150B0308D01F5D2B")
    public void mlock(long address, long byteCount) throws ErrnoException {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.893 -0400", hash_original_method = "51925E7C1A595364A34E53403D531BF1", hash_generated_method = "04521DEB3CCCC466CA00B6517C9A9078")
    public long mmap(long address, long byteCount, int prot, int flags, FileDescriptor fd, long offset) throws ErrnoException {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1172337815 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1172337815;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.894 -0400", hash_original_method = "E2366875958D829A580E669A2DB1A4B1", hash_generated_method = "8864C229845A0E2CC8F7FDA72470613D")
    public void msync(long address, long byteCount, int flags) throws ErrnoException {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.894 -0400", hash_original_method = "300DE062DB1D5D96D86ACEAAE1343E18", hash_generated_method = "E47F369491E1B5E634DDD0810DD2F19A")
    public void munlock(long address, long byteCount) throws ErrnoException {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.894 -0400", hash_original_method = "FD321BF6752ECFAABCD6429010BD098F", hash_generated_method = "08EB766C3DA5DD7C92B90F48070EBB89")
    public void munmap(long address, long byteCount) throws ErrnoException {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.393 -0400", hash_original_method = "B03C285733E86D432A31E9556E29D38C", hash_generated_method = "3895485A804EB3F7CACE7511B2B310A8")
    public FileDescriptor open(String path, int flags, int mode) throws ErrnoException {
    	FileDescriptor fd = new FileDescriptor();
    	fd.addTaint(path.getTaint());
    	fd.addTaint(mode);
    	fd.addTaint(flags);
    	return fd;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.393 -0400", hash_original_method = "15C3A12A736BB4281EA7C1CDE4AB9480", hash_generated_method = "656244847670CC9BF6362B959913631F")
    public FileDescriptor[] pipe() throws ErrnoException {
    	FileDescriptor[] arr=  {new FileDescriptor()};
    	return arr;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.895 -0400", hash_original_method = "A333C05E603FD568E448FA55BD420BEE", hash_generated_method = "91EFE05F0A82D9FDCEED4140FC8EA0E8")
    public int poll(StructPollfd[] fds, int timeoutMs) throws ErrnoException {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1761930530 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1761930530;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.896 -0400", hash_original_method = "FD23B60A9051753476B14299BED1F849", hash_generated_method = "438442F45E87F184D770E1156FC08468")
    public int pread(FileDescriptor fd, ByteBuffer buffer, long offset) throws ErrnoException {
        addTaint(offset);
        addTaint(buffer.getTaint());
        addTaint(fd.getTaint());
    if(buffer.isDirect())        
        {
            int var9CF553709E4B10E0D7E3D3DBC5705CC2_1850953554 = (preadBytes(fd, buffer, buffer.position(), buffer.remaining(), offset));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1315711764 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1315711764;
        } //End block
        else
        {
            int var1E7E4A1207810B5C44747B19DFB5EE92_304784161 = (preadBytes(fd, NioUtils.unsafeArray(buffer), NioUtils.unsafeArrayOffset(buffer) + buffer.position(), buffer.remaining(), offset));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2017361063 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2017361063;
        } //End block
        // ---------- Original Method ----------
        //if (buffer.isDirect()) {
            //return preadBytes(fd, buffer, buffer.position(), buffer.remaining(), offset);
        //} else {
            //return preadBytes(fd, NioUtils.unsafeArray(buffer), NioUtils.unsafeArrayOffset(buffer) + buffer.position(), buffer.remaining(), offset);
        //}
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.896 -0400", hash_original_method = "4B8706AF5748B9EE5E9BCCA6FC3C73C0", hash_generated_method = "9D70705DE43653627F9CDD92BFFE56B0")
    public int pread(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount, long offset) throws ErrnoException {
        addTaint(offset);
        addTaint(byteCount);
        addTaint(byteOffset);
        addTaint(bytes[0]);
        addTaint(fd.getTaint());
        int var4E45F17089126BBD4C9BC17AB2517E62_67261139 = (preadBytes(fd, bytes, byteOffset, byteCount, offset));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_542274428 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_542274428;
        // ---------- Original Method ----------
        //return preadBytes(fd, bytes, byteOffset, byteCount, offset);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.897 -0400", hash_original_method = "5819B25FAD4FEDA7F174A32C15365436", hash_generated_method = "563E292CD049EABC246E9E72A7A92860")
    private int preadBytes(FileDescriptor fd, Object buffer, int bufferOffset, int byteCount, long offset) throws ErrnoException {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1371933852 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1371933852;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.897 -0400", hash_original_method = "DB8AC8A16E91B9F291442450334BCFF2", hash_generated_method = "1347FCAEF795F224DB57099C96491385")
    public int pwrite(FileDescriptor fd, ByteBuffer buffer, long offset) throws ErrnoException {
        addTaint(offset);
        addTaint(buffer.getTaint());
        addTaint(fd.getTaint());
    if(buffer.isDirect())        
        {
            int varED2CED1A8D69AA3517C98ABA9EDEC050_1894802296 = (pwriteBytes(fd, buffer, buffer.position(), buffer.remaining(), offset));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1694064502 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1694064502;
        } //End block
        else
        {
            int var2E57FBEAB8193884750BA0E23C6360A3_1813954853 = (pwriteBytes(fd, NioUtils.unsafeArray(buffer), NioUtils.unsafeArrayOffset(buffer) + buffer.position(), buffer.remaining(), offset));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2064250057 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2064250057;
        } //End block
        // ---------- Original Method ----------
        //if (buffer.isDirect()) {
            //return pwriteBytes(fd, buffer, buffer.position(), buffer.remaining(), offset);
        //} else {
            //return pwriteBytes(fd, NioUtils.unsafeArray(buffer), NioUtils.unsafeArrayOffset(buffer) + buffer.position(), buffer.remaining(), offset);
        //}
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.897 -0400", hash_original_method = "364FA462AFF3FCDD2B79B5A0A9405455", hash_generated_method = "6D76A0CD58EAF8C8804B455891B8135F")
    public int pwrite(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount, long offset) throws ErrnoException {
        addTaint(offset);
        addTaint(byteCount);
        addTaint(byteOffset);
        addTaint(bytes[0]);
        addTaint(fd.getTaint());
        int var88727F79D61A7D7599EE3878EFE837D9_1265109893 = (pwriteBytes(fd, bytes, byteOffset, byteCount, offset));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1155798965 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1155798965;
        // ---------- Original Method ----------
        //return pwriteBytes(fd, bytes, byteOffset, byteCount, offset);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.898 -0400", hash_original_method = "90B6FC1B27EC82D887BE52674747E195", hash_generated_method = "E942AAB3463152122B4BA42FC44955BC")
    private int pwriteBytes(FileDescriptor fd, Object buffer, int bufferOffset, int byteCount, long offset) throws ErrnoException {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1754273476 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1754273476;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.898 -0400", hash_original_method = "ADE2F5685BF490A50DE36063F7A06769", hash_generated_method = "908DFD8AC1F5F0A2168203BE0489B4B7")
    public int read(FileDescriptor fd, ByteBuffer buffer) throws ErrnoException {
        addTaint(buffer.getTaint());
        addTaint(fd.getTaint());
    if(buffer.isDirect())        
        {
            int varCD7C56A6606830298D652104B003CCE4_1359919781 = (readBytes(fd, buffer, buffer.position(), buffer.remaining()));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_986224961 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_986224961;
        } //End block
        else
        {
            int var1E6550E68AE0A30BFDA86F2C50970647_1201117567 = (readBytes(fd, NioUtils.unsafeArray(buffer), NioUtils.unsafeArrayOffset(buffer) + buffer.position(), buffer.remaining()));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_970654114 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_970654114;
        } //End block
        // ---------- Original Method ----------
        //if (buffer.isDirect()) {
            //return readBytes(fd, buffer, buffer.position(), buffer.remaining());
        //} else {
            //return readBytes(fd, NioUtils.unsafeArray(buffer), NioUtils.unsafeArrayOffset(buffer) + buffer.position(), buffer.remaining());
        //}
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.899 -0400", hash_original_method = "6168115C79D46336D7C888D619663F88", hash_generated_method = "029D8E80C4E344715F9863EB5E365F24")
    public int read(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount) throws ErrnoException {
        addTaint(byteCount);
        addTaint(byteOffset);
        addTaint(bytes[0]);
        addTaint(fd.getTaint());
        int var2F91088E503F8BAB0138FB15F0A9AC48_902433637 = (readBytes(fd, bytes, byteOffset, byteCount));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1429270795 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1429270795;
        // ---------- Original Method ----------
        //return readBytes(fd, bytes, byteOffset, byteCount);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.899 -0400", hash_original_method = "2C7E892AABA7BE06DDD2C6AC692575BC", hash_generated_method = "7A0DE3AD0DBDC94C8637A24FEE982FDF")
    private int readBytes(FileDescriptor fd, Object buffer, int offset, int byteCount) throws ErrnoException {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1485707103 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1485707103;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.900 -0400", hash_original_method = "D5205EB48193928ACF79029A7B33E86B", hash_generated_method = "49EF05ABA9FC08669B5FFEE75B48025C")
    public int readv(FileDescriptor fd, Object[] buffers, int[] offsets, int[] byteCounts) throws ErrnoException {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1641850569 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1641850569;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.900 -0400", hash_original_method = "41329575D83AD4CCCAB565E77BA083D5", hash_generated_method = "3275BD927442CB77A14335EF30BE1C5B")
    public int recvfrom(FileDescriptor fd, ByteBuffer buffer, int flags, InetSocketAddress srcAddress) throws ErrnoException {
        addTaint(srcAddress.getTaint());
        addTaint(flags);
        addTaint(buffer.getTaint());
        addTaint(fd.getTaint());
    if(buffer.isDirect())        
        {
            int var12F2D97C8A59609498BA12716F44601C_3545352 = (recvfromBytes(fd, buffer, buffer.position(), buffer.remaining(), flags, srcAddress));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1723612372 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1723612372;
        } //End block
        else
        {
            int var68DF75D02035940F5D17832A53D51C59_1713397724 = (recvfromBytes(fd, NioUtils.unsafeArray(buffer), NioUtils.unsafeArrayOffset(buffer) + buffer.position(), buffer.remaining(), flags, srcAddress));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1441031707 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1441031707;
        } //End block
        // ---------- Original Method ----------
        //if (buffer.isDirect()) {
            //return recvfromBytes(fd, buffer, buffer.position(), buffer.remaining(), flags, srcAddress);
        //} else {
            //return recvfromBytes(fd, NioUtils.unsafeArray(buffer), NioUtils.unsafeArrayOffset(buffer) + buffer.position(), buffer.remaining(), flags, srcAddress);
        //}
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.901 -0400", hash_original_method = "D6B3FC14ED62FEA7873773B8EF3E6A7B", hash_generated_method = "D9A616ABB78338BF1F08344F52694C3A")
    public int recvfrom(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount, int flags, InetSocketAddress srcAddress) throws ErrnoException {
        addTaint(srcAddress.getTaint());
        addTaint(flags);
        addTaint(byteCount);
        addTaint(byteOffset);
        addTaint(bytes[0]);
        addTaint(fd.getTaint());
        int var77E1AA1A1DBA25F24BFF4EFC7A571925_551838189 = (recvfromBytes(fd, bytes, byteOffset, byteCount, flags, srcAddress));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_346193372 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_346193372;
        // ---------- Original Method ----------
        //return recvfromBytes(fd, bytes, byteOffset, byteCount, flags, srcAddress);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.901 -0400", hash_original_method = "4ADC9C5F635814CDC8DA4D81B23D96F7", hash_generated_method = "59A8BF0E91BDCC3065DEE5EFD9F2D004")
    private int recvfromBytes(FileDescriptor fd, Object buffer, int byteOffset, int byteCount, int flags, InetSocketAddress srcAddress) throws ErrnoException {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_356124893 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_356124893;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.902 -0400", hash_original_method = "C4D2972D60AD59B1B88202B59332518F", hash_generated_method = "F785749D71099D3C2EF1A4F3482E2FC9")
    public void remove(String path) throws ErrnoException {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.902 -0400", hash_original_method = "79CCF6DA9C97D5D1A767D340D63FA141", hash_generated_method = "ECFA7C07C31807064D12083B534138D1")
    public void rename(String oldPath, String newPath) throws ErrnoException {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.902 -0400", hash_original_method = "9AFCCF531361D938553CC3693890CE79", hash_generated_method = "F949578D5B03E720AC36171C75DC5BA1")
    public long sendfile(FileDescriptor outFd, FileDescriptor inFd, MutableLong inOffset, long byteCount) throws ErrnoException {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_387151571 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_387151571;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.903 -0400", hash_original_method = "CE9DE10B0135BB1F72B6E5CF17271781", hash_generated_method = "E76B3FF85C9193A3F1477CB25E0CAF21")
    public int sendto(FileDescriptor fd, ByteBuffer buffer, int flags, InetAddress inetAddress, int port) throws ErrnoException {
        addTaint(port);
        addTaint(inetAddress.getTaint());
        addTaint(flags);
        addTaint(buffer.getTaint());
        addTaint(fd.getTaint());
    if(buffer.isDirect())        
        {
            int varB0ECB811C70F6EAF3856ABEB1D6ADEE3_1969890262 = (sendtoBytes(fd, buffer, buffer.position(), buffer.remaining(), flags, inetAddress, port));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_789491261 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_789491261;
        } //End block
        else
        {
            int var399EA733E3545F6476C9B18F1CE0496F_2013964003 = (sendtoBytes(fd, NioUtils.unsafeArray(buffer), NioUtils.unsafeArrayOffset(buffer) + buffer.position(), buffer.remaining(), flags, inetAddress, port));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1290132424 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1290132424;
        } //End block
        // ---------- Original Method ----------
        //if (buffer.isDirect()) {
            //return sendtoBytes(fd, buffer, buffer.position(), buffer.remaining(), flags, inetAddress, port);
        //} else {
            //return sendtoBytes(fd, NioUtils.unsafeArray(buffer), NioUtils.unsafeArrayOffset(buffer) + buffer.position(), buffer.remaining(), flags, inetAddress, port);
        //}
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.903 -0400", hash_original_method = "23CCF7407B7F91C60BE72C6923799443", hash_generated_method = "ABB44773695A7049C99FADDF52FB5E43")
    public int sendto(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount, int flags, InetAddress inetAddress, int port) throws ErrnoException {
        addTaint(port);
        addTaint(inetAddress.getTaint());
        addTaint(flags);
        addTaint(byteCount);
        addTaint(byteOffset);
        addTaint(bytes[0]);
        addTaint(fd.getTaint());
        int varCB79D9BEC467C575C19F483DDDB196F7_407209947 = (sendtoBytes(fd, bytes, byteOffset, byteCount, flags, inetAddress, port));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1663478058 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1663478058;
        // ---------- Original Method ----------
        //return sendtoBytes(fd, bytes, byteOffset, byteCount, flags, inetAddress, port);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.904 -0400", hash_original_method = "F841D540A211C98E750DE668FD283BE2", hash_generated_method = "C2BFA61AED6C5E50C46B34E919250992")
    private int sendtoBytes(FileDescriptor fd, Object buffer, int byteOffset, int byteCount, int flags, InetAddress inetAddress, int port) throws ErrnoException {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_932009864 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_932009864;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.904 -0400", hash_original_method = "4EDFF9AE0EBC71C5A87E99E89B76EA1C", hash_generated_method = "5E48F6E110C1016C239B842F8C474176")
    public void setegid(int egid) throws ErrnoException {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.904 -0400", hash_original_method = "A63D77D63BF9B7372008734FF96F48BC", hash_generated_method = "D406270C51FEA4C57DDD126C99DCDAC4")
    public void seteuid(int euid) throws ErrnoException {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.905 -0400", hash_original_method = "5915305B25E8BEDA092C77560CFF8FA0", hash_generated_method = "C0F83CBE23D4A2D3DF140C77705BC0FD")
    public void setgid(int gid) throws ErrnoException {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.905 -0400", hash_original_method = "9A5169BBE0282BCC00E74B397F068D4B", hash_generated_method = "3E08FEFBDE4D2BF5FCDEA705F6189D5A")
    public void setsockoptByte(FileDescriptor fd, int level, int option, int value) throws ErrnoException {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.905 -0400", hash_original_method = "5041A6120F51EBC2B109E6AF0AE7FC14", hash_generated_method = "E635827CCD8247E74839393BBD93500E")
    public void setsockoptIfreq(FileDescriptor fd, int level, int option, String value) throws ErrnoException {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.906 -0400", hash_original_method = "CE894EBBCEEC6D8A98A23F1D6DFA91AF", hash_generated_method = "A343E3AD0EAD83A0531ADBCCF86109AA")
    public void setsockoptInt(FileDescriptor fd, int level, int option, int value) throws ErrnoException {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.906 -0400", hash_original_method = "6DBB3F1DC41874C1778513E87DD13712", hash_generated_method = "96EE4BF8E717F1B21BE9FA5405FB5833")
    public void setsockoptIpMreqn(FileDescriptor fd, int level, int option, int value) throws ErrnoException {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.906 -0400", hash_original_method = "44866C5C735DD960E2B282162D2DFF44", hash_generated_method = "2464FDFB24FF4B764E38B335F935BD04")
    public void setsockoptGroupReq(FileDescriptor fd, int level, int option, StructGroupReq value) throws ErrnoException {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.907 -0400", hash_original_method = "8265FFDA0D5B54E0714AF7F36058F0FD", hash_generated_method = "C0337305BF631A0C473462C66250C132")
    public void setsockoptLinger(FileDescriptor fd, int level, int option, StructLinger value) throws ErrnoException {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.907 -0400", hash_original_method = "D0EFA67C69EE44E619BC32AD0ABAAA94", hash_generated_method = "E68EB8161F63BB5AD5B88B1DA31DE467")
    public void setsockoptTimeval(FileDescriptor fd, int level, int option, StructTimeval value) throws ErrnoException {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.907 -0400", hash_original_method = "7541ED33DCEBBB89FE1430508C680E96", hash_generated_method = "98772075B4300BB00447E5FD75DA804A")
    public void setuid(int uid) throws ErrnoException {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.908 -0400", hash_original_method = "1961EE437DD0A4352BCFCF2F346982D9", hash_generated_method = "AF53C7188D1B544BB358D63F5C774F2E")
    public void shutdown(FileDescriptor fd, int how) throws ErrnoException {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.405 -0400", hash_original_method = "738E096C5E6C6A5066A76A9B90DC0CA9", hash_generated_method = "7CA7350BE0F647E1FAD6CC5C953D3D40")
    public FileDescriptor socket(int domain, int type, int protocol) throws ErrnoException {
    	FileDescriptor fd = new FileDescriptor();
    	fd.addTaint(domain);
    	fd.addTaint(type);
    	fd.addTaint(protocol);
    	return fd;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.406 -0400", hash_original_method = "6347DE7B46FE3FC2519EB3B202A3981D", hash_generated_method = "A5CDFE2A5FE4F4A6DDEBA3884597AC82")
    public StructStat stat(String path) throws ErrnoException {
    	StructStat ret = new StructStat(DSUtils.UNKNOWN_LONG, DSUtils.UNKNOWN_LONG, DSUtils.UNKNOWN_INT,
    			DSUtils.UNKNOWN_LONG, DSUtils.UNKNOWN_INT, DSUtils.UNKNOWN_INT, DSUtils.UNKNOWN_LONG,
    			DSUtils.UNKNOWN_LONG, DSUtils.UNKNOWN_LONG, DSUtils.UNKNOWN_LONG, DSUtils.UNKNOWN_LONG,
    			DSUtils.UNKNOWN_LONG, DSUtils.UNKNOWN_LONG);
    	ret.addTaint(path.getTaint());
    	return ret;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.406 -0400", hash_original_method = "5BCA24F466E28D74A0DD2E3DB7220B64", hash_generated_method = "ECEC00D3A13CFD9DCFFA731CEEB7943C")
    public StructStatFs statfs(String path) throws ErrnoException {
    	StructStatFs ret = new StructStatFs(DSUtils.UNKNOWN_LONG, DSUtils.UNKNOWN_LONG, DSUtils.UNKNOWN_LONG,
    			DSUtils.UNKNOWN_LONG, DSUtils.UNKNOWN_LONG, DSUtils.UNKNOWN_LONG, DSUtils.UNKNOWN_LONG,
    			DSUtils.UNKNOWN_LONG);
    	ret.addTaint(path.getTaint());
    	return ret;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.406 -0400", hash_original_method = "DF22551AABB4776AE8588CD853791D73", hash_generated_method = "4B2628A376EBCD8E0BF3F6673B683BA7")
    public String strerror(int errno) {
    	String s = new String();
    	s.addTaint(errno);
    	return s;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.909 -0400", hash_original_method = "551DE00FB0B39FAF904A5DC205CAA2EB", hash_generated_method = "A129CF58BB7DCBA118CE2E16606EEC07")
    public void symlink(String oldPath, String newPath) throws ErrnoException {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.909 -0400", hash_original_method = "0CA56D59A1B623A4EE1DB5A7E1204662", hash_generated_method = "EF82D277D0EFD4C31399FEBB7F8AD772")
    public long sysconf(int name) {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_608835285 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_608835285;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.407 -0400", hash_original_method = "840E5C1D01B396A2EA80B4AFD333B092", hash_generated_method = "6171D41EBFE7E809E74F1D080C3D2A62")
    public StructUtsname uname() {
    	return new StructUtsname(new String(), new String(), new String(), new String(), new String());
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.910 -0400", hash_original_method = "FE84032F23145F65306977A4498767E9", hash_generated_method = "575ACB989BF2A4033D1A60C6345D4347")
    public int waitpid(int pid, MutableInt status, int options) throws ErrnoException {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_95892570 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_95892570;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.910 -0400", hash_original_method = "FF46C2F8D2234796363F6B9031191E3B", hash_generated_method = "99F52426EFF788F6F51100442AE95FAA")
    public int write(FileDescriptor fd, ByteBuffer buffer) throws ErrnoException {
        addTaint(buffer.getTaint());
        addTaint(fd.getTaint());
    if(buffer.isDirect())        
        {
            int var6E91C45D5B7EA487438AE9A770EAA981_842252014 = (writeBytes(fd, buffer, buffer.position(), buffer.remaining()));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1787507381 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1787507381;
        } //End block
        else
        {
            int varC1B44A4E9C5BD8F9E38B0E0EAD9937D1_2141462081 = (writeBytes(fd, NioUtils.unsafeArray(buffer), NioUtils.unsafeArrayOffset(buffer) + buffer.position(), buffer.remaining()));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1711253296 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1711253296;
        } //End block
        // ---------- Original Method ----------
        //if (buffer.isDirect()) {
            //return writeBytes(fd, buffer, buffer.position(), buffer.remaining());
        //} else {
            //return writeBytes(fd, NioUtils.unsafeArray(buffer), NioUtils.unsafeArrayOffset(buffer) + buffer.position(), buffer.remaining());
        //}
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.911 -0400", hash_original_method = "077A8F097DECE8A2C8BBB2583BE2D8BE", hash_generated_method = "8679C5C35F9C7DDD697829E5DA707EBA")
    public int write(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount) throws ErrnoException {
        addTaint(byteCount);
        addTaint(byteOffset);
        addTaint(bytes[0]);
        addTaint(fd.getTaint());
        int var179BF145CC8EDD1D00F4A842A47493BF_2027241074 = (writeBytes(fd, bytes, byteOffset, byteCount));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_256133495 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_256133495;
        // ---------- Original Method ----------
        //return writeBytes(fd, bytes, byteOffset, byteCount);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.911 -0400", hash_original_method = "E853B1F146558B1458DE2FB65CF651EB", hash_generated_method = "773A2060A3BDE6F13CC20F4468F90F51")
    private int writeBytes(FileDescriptor fd, Object buffer, int offset, int byteCount) throws ErrnoException {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1566393103 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1566393103;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.912 -0400", hash_original_method = "B9E2C692ADA119F653BB2CBF261E7047", hash_generated_method = "6E36A476103D2F1C3C420F1D39539046")
    public int writev(FileDescriptor fd, Object[] buffers, int[] offsets, int[] byteCounts) throws ErrnoException {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_93852513 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_93852513;
    }

    
}

