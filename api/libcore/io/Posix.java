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
import java.nio.NioUtils;

import libcore.util.MutableInt;
import libcore.util.MutableLong;

import droidsafe.helpers.DSUtils;

public final class Posix implements Os {
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:20.968 -0500", hash_original_method = "4046CDE00BB837810E8AFBFF17A6CE8F", hash_generated_method = "4046CDE00BB837810E8AFBFF17A6CE8F")
    
Posix() { }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.381 -0400", hash_original_method = "3FF894EBDB6D10C08E17FEF79D8BBDA9", hash_generated_method = "CD0A84B225A700801CB0CB5C048B5F64")
    public FileDescriptor accept(FileDescriptor fd, InetSocketAddress peerAddress) throws ErrnoException {
    	FileDescriptor ret = new FileDescriptor();
    	return ret;
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:20.976 -0500", hash_original_method = "B1689CE6DA8AD962BE72C0197D9C07BB", hash_generated_method = "7855063195F4F4D7FD71EAD81B9987A1")
    
    public boolean access(String path, int mode) throws ErrnoException{
        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:20.980 -0500", hash_original_method = "291C8049FE6F5CDE681BB5AEA2008B38", hash_generated_method = "B30973F0688AB7C33D49DC154852DCC6")
    
    public void bind(FileDescriptor fd, InetAddress address, int port) throws ErrnoException{
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:20.984 -0500", hash_original_method = "C6B53F2282285C6075341EF2C607CF79", hash_generated_method = "4E2548E286616EBD017EC82A116C4171")
    
    public void chmod(String path, int mode) throws ErrnoException{
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:20.987 -0500", hash_original_method = "5621A98DBDE11BB13B9D88FD5C4303F9", hash_generated_method = "2066EFAD008EF9B58741E3C3093EC053")
    
    public void close(FileDescriptor fd) throws ErrnoException{
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:20.992 -0500", hash_original_method = "583B21CF7E43DBF5EACD223A833123C4", hash_generated_method = "55B217E3E154569193E2F5D6F66C1444")
    
    public void connect(FileDescriptor fd, InetAddress address, int port) throws ErrnoException{
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
    	return ret;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.382 -0400", hash_original_method = "76B056F20AEC72841BA98095F8E6CB34", hash_generated_method = "ADADA30B919F80A500FE6D3D2633BB36")
    public String[] environ() {
    	String[] arr = {new String()};
    	return arr;
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:21.007 -0500", hash_original_method = "2CB0275F8932D4CF3644D073C3F0700F", hash_generated_method = "CDF12D455431496BF3403F99D42E5173")
    
    public int fcntlVoid(FileDescriptor fd, int cmd) throws ErrnoException{
    	//Formerly a native method
    	return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:21.011 -0500", hash_original_method = "2A7DB0B256B2976732DDA9A901297EFA", hash_generated_method = "B836391E5D886840E50E6D0B57702189")
    
    public int fcntlLong(FileDescriptor fd, int cmd, long arg) throws ErrnoException{
    	//Formerly a native method
        return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:21.015 -0500", hash_original_method = "5842C7622D740E7A11EA29095C58FEF2", hash_generated_method = "7DA9A49FED1607CF6DDCC477B5816628")
    
    public int fcntlFlock(FileDescriptor fd, int cmd, StructFlock arg) throws ErrnoException{
    	//Formerly a native method
        return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:21.018 -0500", hash_original_method = "CC5ECBC11DCDAEE11F3D1714EA5105D5", hash_generated_method = "9930736533AE08AD662A6F9CF2BE65F7")
    
    public void fdatasync(FileDescriptor fd) throws ErrnoException{
    	//Formerly a native method
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.383 -0400", hash_original_method = "285E3CF7F1EFC8C330731E11EF4C59B4", hash_generated_method = "FB432B0A46E67C4A515FC7D39713ADEE")
    public StructStat fstat(FileDescriptor fd) throws ErrnoException {
    	StructStat ret = new StructStat(DSUtils.UNKNOWN_LONG, DSUtils.UNKNOWN_LONG, DSUtils.UNKNOWN_INT,
    			DSUtils.UNKNOWN_LONG, DSUtils.UNKNOWN_INT, DSUtils.UNKNOWN_INT, DSUtils.UNKNOWN_LONG,
    			DSUtils.UNKNOWN_LONG, DSUtils.UNKNOWN_LONG, DSUtils.UNKNOWN_LONG, DSUtils.UNKNOWN_LONG,
    			DSUtils.UNKNOWN_LONG, DSUtils.UNKNOWN_LONG);
    	return ret;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.383 -0400", hash_original_method = "1A9BE1A7FA5485B333D3854795E798C3", hash_generated_method = "2D430EC1E5F2AB304F57C6A4D3ACACFD")
    public StructStatFs fstatfs(FileDescriptor fd) throws ErrnoException {
    	StructStatFs ret = new StructStatFs(DSUtils.UNKNOWN_LONG, DSUtils.UNKNOWN_LONG, DSUtils.UNKNOWN_LONG,
    			DSUtils.UNKNOWN_LONG, DSUtils.UNKNOWN_LONG, DSUtils.UNKNOWN_LONG, DSUtils.UNKNOWN_LONG,
    			DSUtils.UNKNOWN_LONG);
    	return ret;
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:21.031 -0500", hash_original_method = "BC5DB2B4AC1C25097A3FF5E2C6AF2CA8", hash_generated_method = "FC6D906D9F25EE52FC4693D17EA53C93")
    
    public void fsync(FileDescriptor fd) throws ErrnoException{
    	//Formerly a native method
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:21.034 -0500", hash_original_method = "C3B05E353984E75A36400D4268798B4D", hash_generated_method = "A9156394C630524739CE8FFF1B557B6E")
    
    public void ftruncate(FileDescriptor fd, long length) throws ErrnoException{
    	//Formerly a native method
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.384 -0400", hash_original_method = "26A40D218A150DBB5E3B431436FD5A7B", hash_generated_method = "27F87296D375B8957098A9ECC28029AB")
    public String gai_strerror(int error) {
    	String s = new String();
    	return s;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.384 -0400", hash_original_method = "40F18080B746539908D74665104D4EA0", hash_generated_method = "130FA52FE5275831CC890F85A8CD5D33")
    public InetAddress[] getaddrinfo(String node, StructAddrinfo hints) throws GaiException {
    	return new InetAddress[1];
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:21.046 -0500", hash_original_method = "B351A98E9308B82B72BD8C1A77C5DADB", hash_generated_method = "8F7B8AA6D99AB3A08C2F911D4B80FD8E")
    
    public int getegid(){
    	//Formerly a native method
    	return getTaintInt();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:21.049 -0500", hash_original_method = "03FF5CC42F38A66A948C17532C044A2D", hash_generated_method = "2925277221C471613280F5411091807D")
    
    public int geteuid(){
    	//Formerly a native method
    	return getTaintInt();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:21.054 -0500", hash_original_method = "82D0BD1E53FB93AB39C412F5615316CA", hash_generated_method = "D0F8DD54912FB282806E0ED2ABCC9491")
    
    public int getgid(){
    	//Formerly a native method
    	return getTaintInt();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.385 -0400", hash_original_method = "ABE371B1B9ED1CAFA0922C4EB05C6BA3", hash_generated_method = "06988C5468266BFC53F857DF1F3A7080")
    public String getenv(String name) {
    	String s = new String();
    	return s;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.385 -0400", hash_original_method = "A0AFA0E6B104A41B1981D0BE816BBE02", hash_generated_method = "5E0DD6AFD3DD827B3E5DE5816011CF57")
    public String getnameinfo(InetAddress address, int flags) throws GaiException {
    	String s = new String();
    	return s;
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:21.064 -0500", hash_original_method = "ED1FF6EE6302372A02F6AB9DF837F424", hash_generated_method = "80DEF722D207A17DE10C0A2A506EE06D")
    
    public int getpid(){
    	//Formerly a native method
    	return getTaintInt();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:21.069 -0500", hash_original_method = "E9C872CD5783C25015966D177C4AF8C6", hash_generated_method = "DD445CD2BBF78CDB53AD3751B5FF1964")
    
    public int getppid(){
    	//Formerly a native method
    	return getTaintInt();
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
        return sa;
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:21.089 -0500", hash_original_method = "51446225C69A8CF648D53B0005AE4AA4", hash_generated_method = "015485E72538CE04D717E43CD2F13CD2")
    
    public int getsockoptByte(FileDescriptor fd, int level, int option) throws ErrnoException{
    	return 0;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.387 -0400", hash_original_method = "5BB8092DA4409A5D55882AE524C48CC0", hash_generated_method = "D3C69B8918D913F313F29C114573160B")
    public InetAddress getsockoptInAddr(FileDescriptor fd, int level, int option) throws ErrnoException {
    	InetAddress ia = InetAddress.UNSPECIFIED;
    	return ia;
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:21.097 -0500", hash_original_method = "B939E72BF03DDCEDAC639A7621114578", hash_generated_method = "6A98FB0286C9110926F4BB3F1F521D09")
    
    public int getsockoptInt(FileDescriptor fd, int level, int option) throws ErrnoException{
    	//Formerly a native method
        return 0;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.388 -0400", hash_original_method = "FEC6121EA2A897FBB99121F96B439FBB", hash_generated_method = "F60821EF1BF0B8831D7AAFEE843DD949")
    public StructLinger getsockoptLinger(FileDescriptor fd, int level, int option) throws ErrnoException {
    	StructLinger sl = new StructLinger(level, option);
    	return sl;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.389 -0400", hash_original_method = "F02C71E9B42FAB3C0C2F8E812A8DAE0B", hash_generated_method = "6CA79EDA1D97037C4E5A07F27DEFAAF6")
    public StructTimeval getsockoptTimeval(FileDescriptor fd, int level, int option) throws ErrnoException {
    	StructTimeval st = StructTimeval.fromMillis(level + option);
    	return st;
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:21.108 -0500", hash_original_method = "DCBAE976FF6D195847EC9B9CCBB16DA2", hash_generated_method = "307AE40176DC7B92D2C34D0BB7F1AAE3")
    
    public int getuid(){
    	//Formerly a native method
    	return getTaintInt();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.390 -0400", hash_original_method = "BC4349F875DD5C315A8CC9563ABD32ED", hash_generated_method = "5D3B61863086951BE5EE225ADA00E818")
    public String if_indextoname(int index) {
    	String s = new String();
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:21.124 -0500", hash_original_method = "06336F68D97266AEF577672F8C03A8E4", hash_generated_method = "D5C22348D9B5204C73FC979345C49E68")
    
    public int ioctlInt(FileDescriptor fd, int cmd, MutableInt arg) throws ErrnoException{
    	//Formerly a native method
    	return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:21.128 -0500", hash_original_method = "94B275389FB7735E79DD0606BB6663FC", hash_generated_method = "FC3758E8184AA4BC31B72D233B336AD0")
    
    public boolean isatty(FileDescriptor fd){
        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:21.132 -0500", hash_original_method = "77BC6E1CDAEA7EC218D4C88B6DD6F628", hash_generated_method = "D6398CA91D44066518E27EA24BF36B18")
    
    public void kill(int pid, int signal) throws ErrnoException{
    	//Formerly a native method
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:21.135 -0500", hash_original_method = "6ED23D1EA76BF029EEF21B4EAFA6CFF2", hash_generated_method = "C0F83593840D3E7F69DA93FC64A946CE")
    
    public void listen(FileDescriptor fd, int backlog) throws ErrnoException{
    	//Formerly a native method
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:21.139 -0500", hash_original_method = "6DE073E1DD2161D7E507CF5C1E8B8B5C", hash_generated_method = "1B476CDBF3CCB454230C61C9F9E96112")
    
    public long lseek(FileDescriptor fd, long offset, int whence) throws ErrnoException{
    	//Formerly a native method
        return 0;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.391 -0400", hash_original_method = "D639C215CF59CE0021DA2A9DC0F695A4", hash_generated_method = "E0143F1BAA64A6BF1E9A18B98E107A79")
    public StructStat lstat(String path) throws ErrnoException {
    	StructStat ret = new StructStat(DSUtils.UNKNOWN_LONG, DSUtils.UNKNOWN_LONG, DSUtils.UNKNOWN_INT,
    			DSUtils.UNKNOWN_LONG, DSUtils.UNKNOWN_INT, DSUtils.UNKNOWN_INT, DSUtils.UNKNOWN_LONG,
    			DSUtils.UNKNOWN_LONG, DSUtils.UNKNOWN_LONG, DSUtils.UNKNOWN_LONG, DSUtils.UNKNOWN_LONG,
    			DSUtils.UNKNOWN_LONG, DSUtils.UNKNOWN_LONG);
    	return ret;
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:21.147 -0500", hash_original_method = "EC9A299C6214A51B56DA51B591F6FF36", hash_generated_method = "DC3F59D8A30BD99EF31B392833DC2CDE")
    
    public void mincore(long address, long byteCount, byte[] vector) throws ErrnoException{
    	//Formerly a native method
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:21.150 -0500", hash_original_method = "4CC22C39A827987000370BD10B3B7F89", hash_generated_method = "AB6DED7A2A49F4BBB8FAEE0FBE2707D4")
    
    public void mkdir(String path, int mode) throws ErrnoException{
    	//Formerly a native method
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:21.154 -0500", hash_original_method = "40B753FBD702B9115A8CFFA4EBDDD434", hash_generated_method = "414509A2E2B8BE295D85C0368AB0930E")
    
    public void mlock(long address, long byteCount) throws ErrnoException{
    	//Formerly a native method
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:21.158 -0500", hash_original_method = "51925E7C1A595364A34E53403D531BF1", hash_generated_method = "CAF276759F941862CEBCB19A9E946B9B")
    
    public long mmap(long address, long byteCount, int prot, int flags, FileDescriptor fd, long offset) throws ErrnoException{
    	//Formerly a native method
        return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:21.162 -0500", hash_original_method = "E2366875958D829A580E669A2DB1A4B1", hash_generated_method = "80BFF5F02100F1A7DF8BB0A2D1E48590")
    
    public void msync(long address, long byteCount, int flags) throws ErrnoException{
    	//Formerly a native method
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:21.166 -0500", hash_original_method = "300DE062DB1D5D96D86ACEAAE1343E18", hash_generated_method = "8901644A7CAB4375AA7C49D41B3DEC4B")
    
    public void munlock(long address, long byteCount) throws ErrnoException{
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:21.169 -0500", hash_original_method = "FD321BF6752ECFAABCD6429010BD098F", hash_generated_method = "AE89EB4737E6718344C12D8BAE4B5E6A")
    
    public void munmap(long address, long byteCount) throws ErrnoException{
    	//Formerly a native method
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.393 -0400", hash_original_method = "B03C285733E86D432A31E9556E29D38C", hash_generated_method = "3895485A804EB3F7CACE7511B2B310A8")
    public FileDescriptor open(String path, int flags, int mode) throws ErrnoException {
    	FileDescriptor fd = new FileDescriptor();
    	return fd;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.393 -0400", hash_original_method = "15C3A12A736BB4281EA7C1CDE4AB9480", hash_generated_method = "656244847670CC9BF6362B959913631F")
    public FileDescriptor[] pipe() throws ErrnoException {
    	FileDescriptor[] arr=  {new FileDescriptor()};
    	return arr;
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:21.181 -0500", hash_original_method = "A333C05E603FD568E448FA55BD420BEE", hash_generated_method = "1FDDA7E1DF3C29CCADCA5F7A8B7CC734")
    
    public int poll(StructPollfd[] fds, int timeoutMs) throws ErrnoException{
    	//Formerly a native method
        return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:21.184 -0500", hash_original_method = "FD23B60A9051753476B14299BED1F849", hash_generated_method = "F49990B95EA8A671D35565F2ED55E8E7")
    
public int pread(FileDescriptor fd, ByteBuffer buffer, long offset) throws ErrnoException {
        if (buffer.isDirect()) {
            return preadBytes(fd, buffer, buffer.position(), buffer.remaining(), offset);
        } else {
            return preadBytes(fd, NioUtils.unsafeArray(buffer), NioUtils.unsafeArrayOffset(buffer) + buffer.position(), buffer.remaining(), offset);
        }
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:21.186 -0500", hash_original_method = "4B8706AF5748B9EE5E9BCCA6FC3C73C0", hash_generated_method = "A4A2DE273A2C0F106B0CEB6A69C4BDA8")
    
public int pread(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount, long offset) throws ErrnoException {
        // This indirection isn't strictly necessary, but ensures that our public interface is type safe.
        return preadBytes(fd, bytes, byteOffset, byteCount, offset);
    }
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:21.190 -0500", hash_original_method = "5819B25FAD4FEDA7F174A32C15365436", hash_generated_method = "792EB837617D57195AF77D75CAA18C72")
    
    private int preadBytes(FileDescriptor fd, Object buffer, int bufferOffset, int byteCount, long offset) throws ErrnoException{
    	//Formerly a native method
    	return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:21.192 -0500", hash_original_method = "DB8AC8A16E91B9F291442450334BCFF2", hash_generated_method = "FB0DFB8E11950C550360129C4EBEBBCE")
    
public int pwrite(FileDescriptor fd, ByteBuffer buffer, long offset) throws ErrnoException {
        if (buffer.isDirect()) {
            return pwriteBytes(fd, buffer, buffer.position(), buffer.remaining(), offset);
        } else {
            return pwriteBytes(fd, NioUtils.unsafeArray(buffer), NioUtils.unsafeArrayOffset(buffer) + buffer.position(), buffer.remaining(), offset);
        }
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:21.194 -0500", hash_original_method = "364FA462AFF3FCDD2B79B5A0A9405455", hash_generated_method = "68C6D2211094FA7457ECAF4AF20A59E8")
    
public int pwrite(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount, long offset) throws ErrnoException {
        // This indirection isn't strictly necessary, but ensures that our public interface is type safe.
        return pwriteBytes(fd, bytes, byteOffset, byteCount, offset);
    }
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:21.198 -0500", hash_original_method = "90B6FC1B27EC82D887BE52674747E195", hash_generated_method = "8A70C40DCEA74BBF51A6362ADD57DA87")
    
    private int pwriteBytes(FileDescriptor fd, Object buffer, int bufferOffset, int byteCount, long offset) throws ErrnoException{
    	//Formerly a native method
    	return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:21.201 -0500", hash_original_method = "ADE2F5685BF490A50DE36063F7A06769", hash_generated_method = "EB3819D713E17857E2537FE95125175B")
    
public int read(FileDescriptor fd, ByteBuffer buffer) throws ErrnoException {
        if (buffer.isDirect()) {
            return readBytes(fd, buffer, buffer.position(), buffer.remaining());
        } else {
            return readBytes(fd, NioUtils.unsafeArray(buffer), NioUtils.unsafeArrayOffset(buffer) + buffer.position(), buffer.remaining());
        }
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:21.203 -0500", hash_original_method = "6168115C79D46336D7C888D619663F88", hash_generated_method = "B92F0BEE46244214849A834E84ECF1F0")
    
public int read(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount) throws ErrnoException {
        // This indirection isn't strictly necessary, but ensures that our public interface is type safe.
        return readBytes(fd, bytes, byteOffset, byteCount);
    }
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:21.207 -0500", hash_original_method = "2C7E892AABA7BE06DDD2C6AC692575BC", hash_generated_method = "264AC2ABFF816724D4F68E54ECECDB3E")
    
    private int readBytes(FileDescriptor fd, Object buffer, int offset, int byteCount) throws ErrnoException{
    	//Formerly a native method
        return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:21.211 -0500", hash_original_method = "D5205EB48193928ACF79029A7B33E86B", hash_generated_method = "7A4E7FCE5CA1D2B70059FEDC4328CC9E")
    
    public int readv(FileDescriptor fd, Object[] buffers, int[] offsets, int[] byteCounts) throws ErrnoException{
    	//Formerly a native method
        return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:21.214 -0500", hash_original_method = "41329575D83AD4CCCAB565E77BA083D5", hash_generated_method = "82048C98027566F4F5327C44FB161816")
    
public int recvfrom(FileDescriptor fd, ByteBuffer buffer, int flags, InetSocketAddress srcAddress) throws ErrnoException {
        if (buffer.isDirect()) {
            return recvfromBytes(fd, buffer, buffer.position(), buffer.remaining(), flags, srcAddress);
        } else {
            return recvfromBytes(fd, NioUtils.unsafeArray(buffer), NioUtils.unsafeArrayOffset(buffer) + buffer.position(), buffer.remaining(), flags, srcAddress);
        }
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:21.216 -0500", hash_original_method = "D6B3FC14ED62FEA7873773B8EF3E6A7B", hash_generated_method = "CEFD1997BA33343A9208F13A2C719AD5")
    
public int recvfrom(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount, int flags, InetSocketAddress srcAddress) throws ErrnoException {
        // This indirection isn't strictly necessary, but ensures that our public interface is type safe.
        return recvfromBytes(fd, bytes, byteOffset, byteCount, flags, srcAddress);
    }
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:21.220 -0500", hash_original_method = "4ADC9C5F635814CDC8DA4D81B23D96F7", hash_generated_method = "B3C3A3FCF3B2B6F4EEC2B108413C8184")
    
    private int recvfromBytes(FileDescriptor fd, Object buffer, int byteOffset, int byteCount, int flags, InetSocketAddress srcAddress) throws ErrnoException{
    	//Formerly a native method
        return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:21.224 -0500", hash_original_method = "C4D2972D60AD59B1B88202B59332518F", hash_generated_method = "BC5D04FC3FE1F52AA805E4C392BC8CAE")
    
    public void remove(String path) throws ErrnoException{
    	//Formerly a native method
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:21.228 -0500", hash_original_method = "79CCF6DA9C97D5D1A767D340D63FA141", hash_generated_method = "AB9AB7D454AEB37211D0B97B8086ED1E")
    
    public void rename(String oldPath, String newPath) throws ErrnoException{
    	//Formerly a native method
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:21.232 -0500", hash_original_method = "9AFCCF531361D938553CC3693890CE79", hash_generated_method = "35B7E6DCCB5A567A315598F8093CEAD2")
    
    public long sendfile(FileDescriptor outFd, FileDescriptor inFd, MutableLong inOffset, long byteCount) throws ErrnoException{
    	//Formerly a native method
        return 0;
    }

    @DSSink({DSSinkKind.FILE})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:21.234 -0500", hash_original_method = "CE9DE10B0135BB1F72B6E5CF17271781", hash_generated_method = "CAF8183DFBEE5667FB8F5C40E33923DF")
    
public int sendto(FileDescriptor fd, ByteBuffer buffer, int flags, InetAddress inetAddress, int port) throws ErrnoException {
        if (buffer.isDirect()) {
            return sendtoBytes(fd, buffer, buffer.position(), buffer.remaining(), flags, inetAddress, port);
        } else {
            return sendtoBytes(fd, NioUtils.unsafeArray(buffer), NioUtils.unsafeArrayOffset(buffer) + buffer.position(), buffer.remaining(), flags, inetAddress, port);
        }
    }
    @DSSink({DSSinkKind.FILE})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:21.236 -0500", hash_original_method = "23CCF7407B7F91C60BE72C6923799443", hash_generated_method = "3A969A36CDD0413839EA04D49316C1AA")
    
public int sendto(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount, int flags, InetAddress inetAddress, int port) throws ErrnoException {
        // This indirection isn't strictly necessary, but ensures that our public interface is type safe.
        return sendtoBytes(fd, bytes, byteOffset, byteCount, flags, inetAddress, port);
    }
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:21.240 -0500", hash_original_method = "F841D540A211C98E750DE668FD283BE2", hash_generated_method = "CCCCB7AA74570A1CFFFDFB5D69726197")
    
    private int sendtoBytes(FileDescriptor fd, Object buffer, int byteOffset, int byteCount, int flags, InetAddress inetAddress, int port) throws ErrnoException{
    	//Formerly a native method
        return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:21.243 -0500", hash_original_method = "4EDFF9AE0EBC71C5A87E99E89B76EA1C", hash_generated_method = "DEA5911280C3F60F62E9848F029A3C41")
    
    public void setegid(int egid) throws ErrnoException{
    	//Formerly a native method
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:21.248 -0500", hash_original_method = "A63D77D63BF9B7372008734FF96F48BC", hash_generated_method = "EAB91D45B9F4386708ED85AF7BEB74E4")
    
    public void seteuid(int euid) throws ErrnoException{
    	//Formerly a native method
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:21.251 -0500", hash_original_method = "5915305B25E8BEDA092C77560CFF8FA0", hash_generated_method = "2A048C04516DDF12AAF9A724ACD3752B")
    
    public void setgid(int gid) throws ErrnoException{
    	//Formerly a native method
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:21.255 -0500", hash_original_method = "9A5169BBE0282BCC00E74B397F068D4B", hash_generated_method = "4E813A9BBA3D3D1C566F988ED6695529")
    
    public void setsockoptByte(FileDescriptor fd, int level, int option, int value) throws ErrnoException{
    	//Formerly a native method
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:21.259 -0500", hash_original_method = "5041A6120F51EBC2B109E6AF0AE7FC14", hash_generated_method = "7AF79450C4C92CAE357911C2F0F3829F")
    
    public void setsockoptIfreq(FileDescriptor fd, int level, int option, String value) throws ErrnoException{
    	//Formerly a native method
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:21.263 -0500", hash_original_method = "CE894EBBCEEC6D8A98A23F1D6DFA91AF", hash_generated_method = "C9320111F243846E33A2FC4E5441919F")
    
    public void setsockoptInt(FileDescriptor fd, int level, int option, int value) throws ErrnoException{
    	//Formerly a native method
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:21.267 -0500", hash_original_method = "6DBB3F1DC41874C1778513E87DD13712", hash_generated_method = "13DD3207B001CC5599089BEB793F0891")
    
    public void setsockoptIpMreqn(FileDescriptor fd, int level, int option, int value) throws ErrnoException{
    	//Formerly a native method
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:21.271 -0500", hash_original_method = "44866C5C735DD960E2B282162D2DFF44", hash_generated_method = "0E4B4D652A5CA11FA34B3EA2F3D5E1BA")
    
    public void setsockoptGroupReq(FileDescriptor fd, int level, int option, StructGroupReq value) throws ErrnoException{
    	//Formerly a native method
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:21.275 -0500", hash_original_method = "8265FFDA0D5B54E0714AF7F36058F0FD", hash_generated_method = "FA341C4C032E1D26CDD840C28AEA0EFE")
    
    public void setsockoptLinger(FileDescriptor fd, int level, int option, StructLinger value) throws ErrnoException{
    	//Formerly a native method
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:21.279 -0500", hash_original_method = "D0EFA67C69EE44E619BC32AD0ABAAA94", hash_generated_method = "AA10EA988F3A9ECA5AE79EB4D0231424")
    
    public void setsockoptTimeval(FileDescriptor fd, int level, int option, StructTimeval value) throws ErrnoException{
    	//Formerly a native method
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:21.282 -0500", hash_original_method = "7541ED33DCEBBB89FE1430508C680E96", hash_generated_method = "E7AA6467B3AEC8A9F28CCFBCAE8F4AE9")
    
    public void setuid(int uid) throws ErrnoException{
    	//Formerly a native method
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:21.286 -0500", hash_original_method = "1961EE437DD0A4352BCFCF2F346982D9", hash_generated_method = "39D2B5639A5B56CC8C51058682BFC2AC")
    
    public void shutdown(FileDescriptor fd, int how) throws ErrnoException{
    	//Formerly a native method
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.405 -0400", hash_original_method = "738E096C5E6C6A5066A76A9B90DC0CA9", hash_generated_method = "7CA7350BE0F647E1FAD6CC5C953D3D40")
    public FileDescriptor socket(int domain, int type, int protocol) throws ErrnoException {
    	FileDescriptor fd = new FileDescriptor();
    	return fd;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.406 -0400", hash_original_method = "6347DE7B46FE3FC2519EB3B202A3981D", hash_generated_method = "A5CDFE2A5FE4F4A6DDEBA3884597AC82")
    public StructStat stat(String path) throws ErrnoException {
    	StructStat ret = new StructStat(DSUtils.UNKNOWN_LONG, DSUtils.UNKNOWN_LONG, DSUtils.UNKNOWN_INT,
    			DSUtils.UNKNOWN_LONG, DSUtils.UNKNOWN_INT, DSUtils.UNKNOWN_INT, DSUtils.UNKNOWN_LONG,
    			DSUtils.UNKNOWN_LONG, DSUtils.UNKNOWN_LONG, DSUtils.UNKNOWN_LONG, DSUtils.UNKNOWN_LONG,
    			DSUtils.UNKNOWN_LONG, DSUtils.UNKNOWN_LONG);
    	return ret;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.406 -0400", hash_original_method = "5BCA24F466E28D74A0DD2E3DB7220B64", hash_generated_method = "ECEC00D3A13CFD9DCFFA731CEEB7943C")
    public StructStatFs statfs(String path) throws ErrnoException {
    	StructStatFs ret = new StructStatFs(DSUtils.UNKNOWN_LONG, DSUtils.UNKNOWN_LONG, DSUtils.UNKNOWN_LONG,
    			DSUtils.UNKNOWN_LONG, DSUtils.UNKNOWN_LONG, DSUtils.UNKNOWN_LONG, DSUtils.UNKNOWN_LONG,
    			DSUtils.UNKNOWN_LONG);
    	return ret;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.406 -0400", hash_original_method = "DF22551AABB4776AE8588CD853791D73", hash_generated_method = "4B2628A376EBCD8E0BF3F6673B683BA7")
    public String strerror(int errno) {
    	String s = new String();
    	return s;
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:21.305 -0500", hash_original_method = "551DE00FB0B39FAF904A5DC205CAA2EB", hash_generated_method = "0F9D17D3CD0B34BAF0973D4579FF8BF9")
    
    public void symlink(String oldPath, String newPath) throws ErrnoException{
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:21.309 -0500", hash_original_method = "0CA56D59A1B623A4EE1DB5A7E1204662", hash_generated_method = "6D1A19C876DD7B3A8AC924257A4091EE")
    
    public long sysconf(int name){
        return 0;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.407 -0400", hash_original_method = "840E5C1D01B396A2EA80B4AFD333B092", hash_generated_method = "6171D41EBFE7E809E74F1D080C3D2A62")
    public StructUtsname uname() {
    	return new StructUtsname(new String(), new String(), new String(), new String(), new String());
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:21.317 -0500", hash_original_method = "FE84032F23145F65306977A4498767E9", hash_generated_method = "4491EB83CA7131D77864C107EB24A5BA")
    
    public int waitpid(int pid, MutableInt status, int options) throws ErrnoException{
    	return 0;
    }

    @DSSink({DSSinkKind.FILE})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:21.319 -0500", hash_original_method = "FF46C2F8D2234796363F6B9031191E3B", hash_generated_method = "CF195152A8B37B982078AE601F3C84F5")
    
public int write(FileDescriptor fd, ByteBuffer buffer) throws ErrnoException {
        if (buffer.isDirect()) {
            return writeBytes(fd, buffer, buffer.position(), buffer.remaining());
        } else {
            return writeBytes(fd, NioUtils.unsafeArray(buffer), NioUtils.unsafeArrayOffset(buffer) + buffer.position(), buffer.remaining());
        }
    }
    @DSSink({DSSinkKind.FILE})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:21.322 -0500", hash_original_method = "077A8F097DECE8A2C8BBB2583BE2D8BE", hash_generated_method = "51DF263082592B477D78285AEB31FEA0")
    
public int write(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount) throws ErrnoException {
        // This indirection isn't strictly necessary, but ensures that our public interface is type safe.
        return writeBytes(fd, bytes, byteOffset, byteCount);
    }
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:21.325 -0500", hash_original_method = "E853B1F146558B1458DE2FB65CF651EB", hash_generated_method = "702616E7F34093F01DAAD7B9747C047A")
    
    private int writeBytes(FileDescriptor fd, Object buffer, int offset, int byteCount) throws ErrnoException{
        return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:21.329 -0500", hash_original_method = "B9E2C692ADA119F653BB2CBF261E7047", hash_generated_method = "07417EC082F9F152A5217CBCB8CAD919")
    
    public int writev(FileDescriptor fd, Object[] buffers, int[] offsets, int[] byteCounts) throws ErrnoException{
        return 0;
    }
    
}

