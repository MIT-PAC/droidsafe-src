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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.992 -0400", hash_original_method = "4046CDE00BB837810E8AFBFF17A6CE8F", hash_generated_method = "05221F2C631AA96E1462A4F7CC11A1BC")
    @DSModeled(DSC.SAFE)
     Posix() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.992 -0400", hash_original_method = "3FF894EBDB6D10C08E17FEF79D8BBDA9", hash_generated_method = "462D8C62343021065DD523EDC71976B1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public FileDescriptor accept(FileDescriptor fd, InetSocketAddress peerAddress) throws ErrnoException {
        dsTaint.addTaint(peerAddress.dsTaint);
        dsTaint.addTaint(fd.dsTaint);
        return (FileDescriptor)dsTaint.getTaint();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.993 -0400", hash_original_method = "B1689CE6DA8AD962BE72C0197D9C07BB", hash_generated_method = "D1BBC4749FF28B14438E4F1864CD9772")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean access(String path, int mode) throws ErrnoException {
        dsTaint.addTaint(path);
        dsTaint.addTaint(mode);
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.993 -0400", hash_original_method = "291C8049FE6F5CDE681BB5AEA2008B38", hash_generated_method = "098446885C5F4C35B95BA40CDA7C831C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void bind(FileDescriptor fd, InetAddress address, int port) throws ErrnoException {
        dsTaint.addTaint(port);
        dsTaint.addTaint(address.dsTaint);
        dsTaint.addTaint(fd.dsTaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.993 -0400", hash_original_method = "C6B53F2282285C6075341EF2C607CF79", hash_generated_method = "FF1CB263531B4D82D35F3CE3030E0C3F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void chmod(String path, int mode) throws ErrnoException {
        dsTaint.addTaint(path);
        dsTaint.addTaint(mode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.993 -0400", hash_original_method = "5621A98DBDE11BB13B9D88FD5C4303F9", hash_generated_method = "978158A030730A688DF3F0594270A4A2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void close(FileDescriptor fd) throws ErrnoException {
        dsTaint.addTaint(fd.dsTaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.993 -0400", hash_original_method = "583B21CF7E43DBF5EACD223A833123C4", hash_generated_method = "438575F083F2802397EE405B8079A32F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void connect(FileDescriptor fd, InetAddress address, int port) throws ErrnoException {
        dsTaint.addTaint(port);
        dsTaint.addTaint(address.dsTaint);
        dsTaint.addTaint(fd.dsTaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.993 -0400", hash_original_method = "3C30A8714976314FBC047CABB70B8D73", hash_generated_method = "DA69F9BAC422D3E74E6C4C6F491C7CE9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public FileDescriptor dup(FileDescriptor oldFd) throws ErrnoException {
        dsTaint.addTaint(oldFd.dsTaint);
        return (FileDescriptor)dsTaint.getTaint();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.994 -0400", hash_original_method = "3FF27FFFD1EDB0C110A074DD6B27552E", hash_generated_method = "7FF9D20663DABD46FF1B9BFAEE280B40")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public FileDescriptor dup2(FileDescriptor oldFd, int newFd) throws ErrnoException {
        dsTaint.addTaint(oldFd.dsTaint);
        dsTaint.addTaint(newFd);
        return (FileDescriptor)dsTaint.getTaint();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.994 -0400", hash_original_method = "76B056F20AEC72841BA98095F8E6CB34", hash_generated_method = "74413F06AECADADC9A14E88ABF9E6A8E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String[] environ() {
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.994 -0400", hash_original_method = "2CB0275F8932D4CF3644D073C3F0700F", hash_generated_method = "6EF27AA367A46D7D1D7D6983A1BA471A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int fcntlVoid(FileDescriptor fd, int cmd) throws ErrnoException {
        dsTaint.addTaint(cmd);
        dsTaint.addTaint(fd.dsTaint);
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.994 -0400", hash_original_method = "2A7DB0B256B2976732DDA9A901297EFA", hash_generated_method = "EE337A325DED763DEA7ECA4BB5472BB8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int fcntlLong(FileDescriptor fd, int cmd, long arg) throws ErrnoException {
        dsTaint.addTaint(arg);
        dsTaint.addTaint(cmd);
        dsTaint.addTaint(fd.dsTaint);
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.994 -0400", hash_original_method = "5842C7622D740E7A11EA29095C58FEF2", hash_generated_method = "1F86C1FEEE10747E0A27E4FB6383E0E7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int fcntlFlock(FileDescriptor fd, int cmd, StructFlock arg) throws ErrnoException {
        dsTaint.addTaint(arg.dsTaint);
        dsTaint.addTaint(cmd);
        dsTaint.addTaint(fd.dsTaint);
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.994 -0400", hash_original_method = "CC5ECBC11DCDAEE11F3D1714EA5105D5", hash_generated_method = "DEFFEFAA6832A85322B7590D68C52F47")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void fdatasync(FileDescriptor fd) throws ErrnoException {
        dsTaint.addTaint(fd.dsTaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.994 -0400", hash_original_method = "285E3CF7F1EFC8C330731E11EF4C59B4", hash_generated_method = "656067C5C69EFEDA490BDAF641DC1AEF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StructStat fstat(FileDescriptor fd) throws ErrnoException {
        dsTaint.addTaint(fd.dsTaint);
        return (StructStat)dsTaint.getTaint();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.995 -0400", hash_original_method = "1A9BE1A7FA5485B333D3854795E798C3", hash_generated_method = "EF2DCED2986885EA65CD6EA6EDC987BA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StructStatFs fstatfs(FileDescriptor fd) throws ErrnoException {
        dsTaint.addTaint(fd.dsTaint);
        return (StructStatFs)dsTaint.getTaint();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.995 -0400", hash_original_method = "BC5DB2B4AC1C25097A3FF5E2C6AF2CA8", hash_generated_method = "8FC468DC689E8B473F9915463A5894EE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void fsync(FileDescriptor fd) throws ErrnoException {
        dsTaint.addTaint(fd.dsTaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.995 -0400", hash_original_method = "C3B05E353984E75A36400D4268798B4D", hash_generated_method = "683E773D34983220FB6275432E161A44")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void ftruncate(FileDescriptor fd, long length) throws ErrnoException {
        dsTaint.addTaint(length);
        dsTaint.addTaint(fd.dsTaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.995 -0400", hash_original_method = "26A40D218A150DBB5E3B431436FD5A7B", hash_generated_method = "ED630A684096E28666FDFFEA0B704FED")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String gai_strerror(int error) {
        dsTaint.addTaint(error);
        return dsTaint.getTaintString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.995 -0400", hash_original_method = "40F18080B746539908D74665104D4EA0", hash_generated_method = "A945927E096A774022CAC5C503550DB9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public InetAddress[] getaddrinfo(String node, StructAddrinfo hints) throws GaiException {
        dsTaint.addTaint(node);
        dsTaint.addTaint(hints.dsTaint);
        return (InetAddress[])dsTaint.getTaint();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.995 -0400", hash_original_method = "B351A98E9308B82B72BD8C1A77C5DADB", hash_generated_method = "2D087BC7E7436C2F906619EBFF7D509E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getegid() {
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.995 -0400", hash_original_method = "03FF5CC42F38A66A948C17532C044A2D", hash_generated_method = "E2F8A2FB2ADE6B57751959BF01A21704")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int geteuid() {
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.996 -0400", hash_original_method = "82D0BD1E53FB93AB39C412F5615316CA", hash_generated_method = "52D3A58E79AF1CAAFBE7B0E6531E863F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getgid() {
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.996 -0400", hash_original_method = "ABE371B1B9ED1CAFA0922C4EB05C6BA3", hash_generated_method = "DA10B1977812D8EA03281FA1919FC421")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getenv(String name) {
        dsTaint.addTaint(name);
        return dsTaint.getTaintString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.996 -0400", hash_original_method = "A0AFA0E6B104A41B1981D0BE816BBE02", hash_generated_method = "2619D0DABA9786B04F9D1CC087980FD8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getnameinfo(InetAddress address, int flags) throws GaiException {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(address.dsTaint);
        return dsTaint.getTaintString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.996 -0400", hash_original_method = "ED1FF6EE6302372A02F6AB9DF837F424", hash_generated_method = "BB7D156A0C95F5567CF32B69EE1C9839")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getpid() {
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.996 -0400", hash_original_method = "E9C872CD5783C25015966D177C4AF8C6", hash_generated_method = "C5767AC5DA318FA2765A0C02F1AB7C68")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getppid() {
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.996 -0400", hash_original_method = "CC95F691F046B008F87F75EBB754B9F4", hash_generated_method = "5A843F94D051E3DAD9986DC190129BE8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StructPasswd getpwnam(String name) throws ErrnoException {
        dsTaint.addTaint(name);
        return (StructPasswd)dsTaint.getTaint();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.996 -0400", hash_original_method = "F193108F2C48DAFAA33D43EBB961E0C4", hash_generated_method = "4929EFD755EAF65B7A68EB40944DB595")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StructPasswd getpwuid(int uid) throws ErrnoException {
        dsTaint.addTaint(uid);
        return (StructPasswd)dsTaint.getTaint();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.996 -0400", hash_original_method = "BDE1CE7D74C0BBEFDC894A32FA56505C", hash_generated_method = "B2FB3E066AB878008386E39F62E1FAA3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SocketAddress getsockname(FileDescriptor fd) throws ErrnoException {
        dsTaint.addTaint(fd.dsTaint);
        return (SocketAddress)dsTaint.getTaint();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.996 -0400", hash_original_method = "51446225C69A8CF648D53B0005AE4AA4", hash_generated_method = "30337E853AB93ABA46AF955C1CF32B1B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getsockoptByte(FileDescriptor fd, int level, int option) throws ErrnoException {
        dsTaint.addTaint(level);
        dsTaint.addTaint(fd.dsTaint);
        dsTaint.addTaint(option);
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.997 -0400", hash_original_method = "5BB8092DA4409A5D55882AE524C48CC0", hash_generated_method = "A24E10D7EBC779E50D5DF5EAFF88E462")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public InetAddress getsockoptInAddr(FileDescriptor fd, int level, int option) throws ErrnoException {
        dsTaint.addTaint(level);
        dsTaint.addTaint(fd.dsTaint);
        dsTaint.addTaint(option);
        return (InetAddress)dsTaint.getTaint();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.997 -0400", hash_original_method = "B939E72BF03DDCEDAC639A7621114578", hash_generated_method = "8109858EDE9C02270789FE0007CF9C44")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getsockoptInt(FileDescriptor fd, int level, int option) throws ErrnoException {
        dsTaint.addTaint(level);
        dsTaint.addTaint(fd.dsTaint);
        dsTaint.addTaint(option);
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.997 -0400", hash_original_method = "FEC6121EA2A897FBB99121F96B439FBB", hash_generated_method = "1CC369563446B6C2A8023494FE747857")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StructLinger getsockoptLinger(FileDescriptor fd, int level, int option) throws ErrnoException {
        dsTaint.addTaint(level);
        dsTaint.addTaint(fd.dsTaint);
        dsTaint.addTaint(option);
        return (StructLinger)dsTaint.getTaint();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.997 -0400", hash_original_method = "F02C71E9B42FAB3C0C2F8E812A8DAE0B", hash_generated_method = "6C773997ADC4FD6ED78161AC4F253EF3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StructTimeval getsockoptTimeval(FileDescriptor fd, int level, int option) throws ErrnoException {
        dsTaint.addTaint(level);
        dsTaint.addTaint(fd.dsTaint);
        dsTaint.addTaint(option);
        return (StructTimeval)dsTaint.getTaint();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.997 -0400", hash_original_method = "DCBAE976FF6D195847EC9B9CCBB16DA2", hash_generated_method = "187934CC27A68811639200948D26CA2A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getuid() {
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.997 -0400", hash_original_method = "BC4349F875DD5C315A8CC9563ABD32ED", hash_generated_method = "336E950933AF9F10DEF5C11DB955783F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String if_indextoname(int index) {
        dsTaint.addTaint(index);
        return dsTaint.getTaintString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.997 -0400", hash_original_method = "2643CEE6EE9643256D8BA72042097190", hash_generated_method = "167502DCA5167B599494191EA637160E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public InetAddress inet_pton(int family, String address) {
        dsTaint.addTaint(address);
        dsTaint.addTaint(family);
        return (InetAddress)dsTaint.getTaint();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.998 -0400", hash_original_method = "E90DEAC8BD65E718B0E2ACEED6C5AEE3", hash_generated_method = "6A82AE83CE511D97BCADFDDA13ADE195")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public InetAddress ioctlInetAddress(FileDescriptor fd, int cmd, String interfaceName) throws ErrnoException {
        dsTaint.addTaint(cmd);
        dsTaint.addTaint(interfaceName);
        dsTaint.addTaint(fd.dsTaint);
        return (InetAddress)dsTaint.getTaint();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.998 -0400", hash_original_method = "06336F68D97266AEF577672F8C03A8E4", hash_generated_method = "802864D907D9CAF508FB31B8E07BB11A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int ioctlInt(FileDescriptor fd, int cmd, MutableInt arg) throws ErrnoException {
        dsTaint.addTaint(arg.dsTaint);
        dsTaint.addTaint(cmd);
        dsTaint.addTaint(fd.dsTaint);
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.998 -0400", hash_original_method = "94B275389FB7735E79DD0606BB6663FC", hash_generated_method = "974BCF7B838297741D2CADCB13F0C665")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isatty(FileDescriptor fd) {
        dsTaint.addTaint(fd.dsTaint);
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.998 -0400", hash_original_method = "77BC6E1CDAEA7EC218D4C88B6DD6F628", hash_generated_method = "2818800033AD74C50E46CD1E2334B55B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void kill(int pid, int signal) throws ErrnoException {
        dsTaint.addTaint(signal);
        dsTaint.addTaint(pid);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.998 -0400", hash_original_method = "6ED23D1EA76BF029EEF21B4EAFA6CFF2", hash_generated_method = "19349440F719A16BFA280F30E77A55F6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void listen(FileDescriptor fd, int backlog) throws ErrnoException {
        dsTaint.addTaint(backlog);
        dsTaint.addTaint(fd.dsTaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.998 -0400", hash_original_method = "6DE073E1DD2161D7E507CF5C1E8B8B5C", hash_generated_method = "3C3B5C47E5A003163F829F9B26559902")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long lseek(FileDescriptor fd, long offset, int whence) throws ErrnoException {
        dsTaint.addTaint(whence);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(fd.dsTaint);
        return dsTaint.getTaintLong();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.998 -0400", hash_original_method = "D639C215CF59CE0021DA2A9DC0F695A4", hash_generated_method = "5CA8B87FE2D70F14B73EF0F96D96021E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StructStat lstat(String path) throws ErrnoException {
        dsTaint.addTaint(path);
        return (StructStat)dsTaint.getTaint();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.998 -0400", hash_original_method = "EC9A299C6214A51B56DA51B591F6FF36", hash_generated_method = "491C2BF96BFDBB094B665ECF4CD8A627")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void mincore(long address, long byteCount, byte[] vector) throws ErrnoException {
        dsTaint.addTaint(address);
        dsTaint.addTaint(vector[0]);
        dsTaint.addTaint(byteCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.999 -0400", hash_original_method = "4CC22C39A827987000370BD10B3B7F89", hash_generated_method = "EF52FB6871DCB52F80A15FD93D2EB010")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void mkdir(String path, int mode) throws ErrnoException {
        dsTaint.addTaint(path);
        dsTaint.addTaint(mode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.999 -0400", hash_original_method = "40B753FBD702B9115A8CFFA4EBDDD434", hash_generated_method = "020477E1A2CBE67EA53B515CA8F1794C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void mlock(long address, long byteCount) throws ErrnoException {
        dsTaint.addTaint(address);
        dsTaint.addTaint(byteCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.999 -0400", hash_original_method = "51925E7C1A595364A34E53403D531BF1", hash_generated_method = "E2013EE613B21E9A9273B1074954F2A5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long mmap(long address, long byteCount, int prot, int flags, FileDescriptor fd, long offset) throws ErrnoException {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(address);
        dsTaint.addTaint(byteCount);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(fd.dsTaint);
        dsTaint.addTaint(prot);
        return dsTaint.getTaintLong();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.999 -0400", hash_original_method = "E2366875958D829A580E669A2DB1A4B1", hash_generated_method = "CDBB99FB088AF8587DC0A99900598852")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void msync(long address, long byteCount, int flags) throws ErrnoException {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(address);
        dsTaint.addTaint(byteCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.999 -0400", hash_original_method = "300DE062DB1D5D96D86ACEAAE1343E18", hash_generated_method = "D073BF708C646ADBC996076C41841E4E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void munlock(long address, long byteCount) throws ErrnoException {
        dsTaint.addTaint(address);
        dsTaint.addTaint(byteCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.999 -0400", hash_original_method = "FD321BF6752ECFAABCD6429010BD098F", hash_generated_method = "3492103F83578244CCC05FA7972CFC5E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void munmap(long address, long byteCount) throws ErrnoException {
        dsTaint.addTaint(address);
        dsTaint.addTaint(byteCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.999 -0400", hash_original_method = "B03C285733E86D432A31E9556E29D38C", hash_generated_method = "97E3654BD197D8D6C9C3CBF4C253994E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public FileDescriptor open(String path, int flags, int mode) throws ErrnoException {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(path);
        dsTaint.addTaint(mode);
        return (FileDescriptor)dsTaint.getTaint();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.999 -0400", hash_original_method = "15C3A12A736BB4281EA7C1CDE4AB9480", hash_generated_method = "6898096398CBF838A44B0C5756CB5F59")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public FileDescriptor[] pipe() throws ErrnoException {
        return (FileDescriptor[])dsTaint.getTaint();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.000 -0400", hash_original_method = "A333C05E603FD568E448FA55BD420BEE", hash_generated_method = "C2E058A09CB32FA8C437FF0968C55D7C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int poll(StructPollfd[] fds, int timeoutMs) throws ErrnoException {
        dsTaint.addTaint(timeoutMs);
        dsTaint.addTaint(fds[0].dsTaint);
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.000 -0400", hash_original_method = "FD23B60A9051753476B14299BED1F849", hash_generated_method = "F95C49D0BA3B422CBE78677ABB00F6DD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int pread(FileDescriptor fd, ByteBuffer buffer, long offset) throws ErrnoException {
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(fd.dsTaint);
        {
            boolean var21D6A43A19BB11FD75F2555CEDDC72D3_637114607 = (buffer.isDirect());
            {
                int var8E7907A41BEF94A8EBD28CB040D098F0_2080085911 = (preadBytes(fd, buffer, buffer.position(), buffer.remaining(), offset));
            } //End block
            {
                int var1F069D630372EF5D70684AA69ABBB191_1272364230 = (preadBytes(fd, NioUtils.unsafeArray(buffer), NioUtils.unsafeArrayOffset(buffer) + buffer.position(), buffer.remaining(), offset));
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (buffer.isDirect()) {
            //return preadBytes(fd, buffer, buffer.position(), buffer.remaining(), offset);
        //} else {
            //return preadBytes(fd, NioUtils.unsafeArray(buffer), NioUtils.unsafeArrayOffset(buffer) + buffer.position(), buffer.remaining(), offset);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.000 -0400", hash_original_method = "4B8706AF5748B9EE5E9BCCA6FC3C73C0", hash_generated_method = "9B978BA2100C4EE1B2D4DCB493909B7F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int pread(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount, long offset) throws ErrnoException {
        dsTaint.addTaint(byteOffset);
        dsTaint.addTaint(bytes[0]);
        dsTaint.addTaint(byteCount);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(fd.dsTaint);
        int varCF530DD83FC2922F479A426BEFE4CB6B_323595002 = (preadBytes(fd, bytes, byteOffset, byteCount, offset));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return preadBytes(fd, bytes, byteOffset, byteCount, offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.000 -0400", hash_original_method = "5819B25FAD4FEDA7F174A32C15365436", hash_generated_method = "6A328F591590D754D006991ABA104E9E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int preadBytes(FileDescriptor fd, Object buffer, int bufferOffset, int byteCount, long offset) throws ErrnoException {
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(byteCount);
        dsTaint.addTaint(bufferOffset);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(fd.dsTaint);
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.000 -0400", hash_original_method = "DB8AC8A16E91B9F291442450334BCFF2", hash_generated_method = "A52D909D3064244998CEA7AD5CFF67E4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int pwrite(FileDescriptor fd, ByteBuffer buffer, long offset) throws ErrnoException {
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(fd.dsTaint);
        {
            boolean var21D6A43A19BB11FD75F2555CEDDC72D3_1666877603 = (buffer.isDirect());
            {
                int var87D5C3FD697C182EDD756D3EFF6529D7_257977314 = (pwriteBytes(fd, buffer, buffer.position(), buffer.remaining(), offset));
            } //End block
            {
                int var6DAE9A5C537D89AF40EB6C242AD74611_1699782890 = (pwriteBytes(fd, NioUtils.unsafeArray(buffer), NioUtils.unsafeArrayOffset(buffer) + buffer.position(), buffer.remaining(), offset));
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (buffer.isDirect()) {
            //return pwriteBytes(fd, buffer, buffer.position(), buffer.remaining(), offset);
        //} else {
            //return pwriteBytes(fd, NioUtils.unsafeArray(buffer), NioUtils.unsafeArrayOffset(buffer) + buffer.position(), buffer.remaining(), offset);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.001 -0400", hash_original_method = "364FA462AFF3FCDD2B79B5A0A9405455", hash_generated_method = "DE651B1BF060143927233B92EAF631A5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int pwrite(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount, long offset) throws ErrnoException {
        dsTaint.addTaint(byteOffset);
        dsTaint.addTaint(bytes[0]);
        dsTaint.addTaint(byteCount);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(fd.dsTaint);
        int varFC5C8D1266385A06B48EE648ACD7657C_163229561 = (pwriteBytes(fd, bytes, byteOffset, byteCount, offset));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return pwriteBytes(fd, bytes, byteOffset, byteCount, offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.001 -0400", hash_original_method = "90B6FC1B27EC82D887BE52674747E195", hash_generated_method = "E04269C1908E4A0695A8D0D90AD2A6D2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int pwriteBytes(FileDescriptor fd, Object buffer, int bufferOffset, int byteCount, long offset) throws ErrnoException {
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(byteCount);
        dsTaint.addTaint(bufferOffset);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(fd.dsTaint);
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.001 -0400", hash_original_method = "ADE2F5685BF490A50DE36063F7A06769", hash_generated_method = "92406D29C935D7686C8BB627D8DC7339")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int read(FileDescriptor fd, ByteBuffer buffer) throws ErrnoException {
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(fd.dsTaint);
        {
            boolean var21D6A43A19BB11FD75F2555CEDDC72D3_219889760 = (buffer.isDirect());
            {
                int varD5A85510F41F9F59964F2A7FD9630E4C_1994730114 = (readBytes(fd, buffer, buffer.position(), buffer.remaining()));
            } //End block
            {
                int varC2696D40F0D039BC87FD96259E5276FD_557293480 = (readBytes(fd, NioUtils.unsafeArray(buffer), NioUtils.unsafeArrayOffset(buffer) + buffer.position(), buffer.remaining()));
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (buffer.isDirect()) {
            //return readBytes(fd, buffer, buffer.position(), buffer.remaining());
        //} else {
            //return readBytes(fd, NioUtils.unsafeArray(buffer), NioUtils.unsafeArrayOffset(buffer) + buffer.position(), buffer.remaining());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.001 -0400", hash_original_method = "6168115C79D46336D7C888D619663F88", hash_generated_method = "31D6DB794E87F5F4F0C4B47D40881246")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int read(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount) throws ErrnoException {
        dsTaint.addTaint(byteOffset);
        dsTaint.addTaint(bytes[0]);
        dsTaint.addTaint(byteCount);
        dsTaint.addTaint(fd.dsTaint);
        int varAF7FBEB1A05EE593C49B78D715290282_1015109182 = (readBytes(fd, bytes, byteOffset, byteCount));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return readBytes(fd, bytes, byteOffset, byteCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.001 -0400", hash_original_method = "2C7E892AABA7BE06DDD2C6AC692575BC", hash_generated_method = "405D03D5BF4262EF258D810D2B9DEAF4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int readBytes(FileDescriptor fd, Object buffer, int offset, int byteCount) throws ErrnoException {
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(byteCount);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(fd.dsTaint);
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.001 -0400", hash_original_method = "D5205EB48193928ACF79029A7B33E86B", hash_generated_method = "71E415E77F12F954BE4CF464CFA8CB98")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int readv(FileDescriptor fd, Object[] buffers, int[] offsets, int[] byteCounts) throws ErrnoException {
        dsTaint.addTaint(byteCounts[0]);
        dsTaint.addTaint(offsets[0]);
        dsTaint.addTaint(buffers[0].dsTaint);
        dsTaint.addTaint(fd.dsTaint);
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.002 -0400", hash_original_method = "41329575D83AD4CCCAB565E77BA083D5", hash_generated_method = "1F3E8346777E7CF12A51796B83628562")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int recvfrom(FileDescriptor fd, ByteBuffer buffer, int flags, InetSocketAddress srcAddress) throws ErrnoException {
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(flags);
        dsTaint.addTaint(srcAddress.dsTaint);
        dsTaint.addTaint(fd.dsTaint);
        {
            boolean var21D6A43A19BB11FD75F2555CEDDC72D3_536034546 = (buffer.isDirect());
            {
                int varF31574244E582FAAC1D4E5A3117CCAD5_211511258 = (recvfromBytes(fd, buffer, buffer.position(), buffer.remaining(), flags, srcAddress));
            } //End block
            {
                int var754A91E49CCFCF0B12E0E37D924384F6_294681129 = (recvfromBytes(fd, NioUtils.unsafeArray(buffer), NioUtils.unsafeArrayOffset(buffer) + buffer.position(), buffer.remaining(), flags, srcAddress));
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (buffer.isDirect()) {
            //return recvfromBytes(fd, buffer, buffer.position(), buffer.remaining(), flags, srcAddress);
        //} else {
            //return recvfromBytes(fd, NioUtils.unsafeArray(buffer), NioUtils.unsafeArrayOffset(buffer) + buffer.position(), buffer.remaining(), flags, srcAddress);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.002 -0400", hash_original_method = "D6B3FC14ED62FEA7873773B8EF3E6A7B", hash_generated_method = "3A5B50F8AC0212CF4BAE3308A1C075A0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int recvfrom(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount, int flags, InetSocketAddress srcAddress) throws ErrnoException {
        dsTaint.addTaint(byteOffset);
        dsTaint.addTaint(flags);
        dsTaint.addTaint(bytes[0]);
        dsTaint.addTaint(byteCount);
        dsTaint.addTaint(srcAddress.dsTaint);
        dsTaint.addTaint(fd.dsTaint);
        int var5C3B514BF02C0C51E1C7926B1634D11C_296933060 = (recvfromBytes(fd, bytes, byteOffset, byteCount, flags, srcAddress));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return recvfromBytes(fd, bytes, byteOffset, byteCount, flags, srcAddress);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.002 -0400", hash_original_method = "4ADC9C5F635814CDC8DA4D81B23D96F7", hash_generated_method = "1A864EC0116F0E0A445871C26036341F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int recvfromBytes(FileDescriptor fd, Object buffer, int byteOffset, int byteCount, int flags, InetSocketAddress srcAddress) throws ErrnoException {
        dsTaint.addTaint(byteOffset);
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(flags);
        dsTaint.addTaint(byteCount);
        dsTaint.addTaint(srcAddress.dsTaint);
        dsTaint.addTaint(fd.dsTaint);
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.002 -0400", hash_original_method = "C4D2972D60AD59B1B88202B59332518F", hash_generated_method = "8B6ADFDA8EB2174EA970FBB4707B5744")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void remove(String path) throws ErrnoException {
        dsTaint.addTaint(path);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.002 -0400", hash_original_method = "79CCF6DA9C97D5D1A767D340D63FA141", hash_generated_method = "CA512820CC59B52CCD1C59ABBCD13483")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void rename(String oldPath, String newPath) throws ErrnoException {
        dsTaint.addTaint(newPath);
        dsTaint.addTaint(oldPath);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.002 -0400", hash_original_method = "9AFCCF531361D938553CC3693890CE79", hash_generated_method = "E601A7F05F8166D71058EC8B9A92034D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long sendfile(FileDescriptor outFd, FileDescriptor inFd, MutableLong inOffset, long byteCount) throws ErrnoException {
        dsTaint.addTaint(outFd.dsTaint);
        dsTaint.addTaint(byteCount);
        dsTaint.addTaint(inFd.dsTaint);
        dsTaint.addTaint(inOffset.dsTaint);
        return dsTaint.getTaintLong();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.003 -0400", hash_original_method = "CE9DE10B0135BB1F72B6E5CF17271781", hash_generated_method = "BCA113E0BB3E43DB51158464DC27FE73")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int sendto(FileDescriptor fd, ByteBuffer buffer, int flags, InetAddress inetAddress, int port) throws ErrnoException {
        dsTaint.addTaint(port);
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(flags);
        dsTaint.addTaint(inetAddress.dsTaint);
        dsTaint.addTaint(fd.dsTaint);
        {
            boolean var21D6A43A19BB11FD75F2555CEDDC72D3_1588410533 = (buffer.isDirect());
            {
                int var5E9D1647C6154DCE995D5EEEB1605F7B_608024923 = (sendtoBytes(fd, buffer, buffer.position(), buffer.remaining(), flags, inetAddress, port));
            } //End block
            {
                int var454BEDFAD70DADFAA662DB20DF483B42_1289857650 = (sendtoBytes(fd, NioUtils.unsafeArray(buffer), NioUtils.unsafeArrayOffset(buffer) + buffer.position(), buffer.remaining(), flags, inetAddress, port));
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (buffer.isDirect()) {
            //return sendtoBytes(fd, buffer, buffer.position(), buffer.remaining(), flags, inetAddress, port);
        //} else {
            //return sendtoBytes(fd, NioUtils.unsafeArray(buffer), NioUtils.unsafeArrayOffset(buffer) + buffer.position(), buffer.remaining(), flags, inetAddress, port);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.003 -0400", hash_original_method = "23CCF7407B7F91C60BE72C6923799443", hash_generated_method = "0611650ACED03D879E853C822A6C6CE3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int sendto(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount, int flags, InetAddress inetAddress, int port) throws ErrnoException {
        dsTaint.addTaint(port);
        dsTaint.addTaint(byteOffset);
        dsTaint.addTaint(flags);
        dsTaint.addTaint(bytes[0]);
        dsTaint.addTaint(inetAddress.dsTaint);
        dsTaint.addTaint(byteCount);
        dsTaint.addTaint(fd.dsTaint);
        int varE214C015B4D6A01301684BB848AD3BF2_1748183305 = (sendtoBytes(fd, bytes, byteOffset, byteCount, flags, inetAddress, port));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return sendtoBytes(fd, bytes, byteOffset, byteCount, flags, inetAddress, port);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.003 -0400", hash_original_method = "F841D540A211C98E750DE668FD283BE2", hash_generated_method = "04668109B2AD60C905359B0EEC36B8F8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int sendtoBytes(FileDescriptor fd, Object buffer, int byteOffset, int byteCount, int flags, InetAddress inetAddress, int port) throws ErrnoException {
        dsTaint.addTaint(port);
        dsTaint.addTaint(byteOffset);
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(flags);
        dsTaint.addTaint(inetAddress.dsTaint);
        dsTaint.addTaint(byteCount);
        dsTaint.addTaint(fd.dsTaint);
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.003 -0400", hash_original_method = "4EDFF9AE0EBC71C5A87E99E89B76EA1C", hash_generated_method = "AD05233D46B3C8CB410EE9F1F7DDED85")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setegid(int egid) throws ErrnoException {
        dsTaint.addTaint(egid);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.003 -0400", hash_original_method = "A63D77D63BF9B7372008734FF96F48BC", hash_generated_method = "FFFA128F898CA1A03ADAAEC9683E4A2E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void seteuid(int euid) throws ErrnoException {
        dsTaint.addTaint(euid);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.003 -0400", hash_original_method = "5915305B25E8BEDA092C77560CFF8FA0", hash_generated_method = "B25165CAD3D1EF5B98FC0367DC859DBC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setgid(int gid) throws ErrnoException {
        dsTaint.addTaint(gid);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.003 -0400", hash_original_method = "9A5169BBE0282BCC00E74B397F068D4B", hash_generated_method = "BC7BCF08E124560459B8960297BFC3E2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setsockoptByte(FileDescriptor fd, int level, int option, int value) throws ErrnoException {
        dsTaint.addTaint(level);
        dsTaint.addTaint(value);
        dsTaint.addTaint(fd.dsTaint);
        dsTaint.addTaint(option);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.004 -0400", hash_original_method = "5041A6120F51EBC2B109E6AF0AE7FC14", hash_generated_method = "C64026F9F48A9B6409A71635715C8BC6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setsockoptIfreq(FileDescriptor fd, int level, int option, String value) throws ErrnoException {
        dsTaint.addTaint(level);
        dsTaint.addTaint(value);
        dsTaint.addTaint(fd.dsTaint);
        dsTaint.addTaint(option);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.004 -0400", hash_original_method = "CE894EBBCEEC6D8A98A23F1D6DFA91AF", hash_generated_method = "392500FF5D1421496FA6EB9C481A0D06")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setsockoptInt(FileDescriptor fd, int level, int option, int value) throws ErrnoException {
        dsTaint.addTaint(level);
        dsTaint.addTaint(value);
        dsTaint.addTaint(fd.dsTaint);
        dsTaint.addTaint(option);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.004 -0400", hash_original_method = "6DBB3F1DC41874C1778513E87DD13712", hash_generated_method = "C394555FF21B5AD8FE37F661A21532F9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setsockoptIpMreqn(FileDescriptor fd, int level, int option, int value) throws ErrnoException {
        dsTaint.addTaint(level);
        dsTaint.addTaint(value);
        dsTaint.addTaint(fd.dsTaint);
        dsTaint.addTaint(option);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.004 -0400", hash_original_method = "44866C5C735DD960E2B282162D2DFF44", hash_generated_method = "D1BA6BDBE99A8CF995432B2071C76A51")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setsockoptGroupReq(FileDescriptor fd, int level, int option, StructGroupReq value) throws ErrnoException {
        dsTaint.addTaint(level);
        dsTaint.addTaint(value.dsTaint);
        dsTaint.addTaint(fd.dsTaint);
        dsTaint.addTaint(option);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.004 -0400", hash_original_method = "8265FFDA0D5B54E0714AF7F36058F0FD", hash_generated_method = "758486616117DA31A3810697715658C9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setsockoptLinger(FileDescriptor fd, int level, int option, StructLinger value) throws ErrnoException {
        dsTaint.addTaint(level);
        dsTaint.addTaint(value.dsTaint);
        dsTaint.addTaint(fd.dsTaint);
        dsTaint.addTaint(option);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.004 -0400", hash_original_method = "D0EFA67C69EE44E619BC32AD0ABAAA94", hash_generated_method = "756228C0C69F9955B43DEEA79CCF1D49")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setsockoptTimeval(FileDescriptor fd, int level, int option, StructTimeval value) throws ErrnoException {
        dsTaint.addTaint(level);
        dsTaint.addTaint(value.dsTaint);
        dsTaint.addTaint(fd.dsTaint);
        dsTaint.addTaint(option);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.004 -0400", hash_original_method = "7541ED33DCEBBB89FE1430508C680E96", hash_generated_method = "9C0C6E089891E97596DDE57A35F08EB7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setuid(int uid) throws ErrnoException {
        dsTaint.addTaint(uid);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.005 -0400", hash_original_method = "1961EE437DD0A4352BCFCF2F346982D9", hash_generated_method = "6390E77662FE1A6608E4F92951FD3F9B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void shutdown(FileDescriptor fd, int how) throws ErrnoException {
        dsTaint.addTaint(how);
        dsTaint.addTaint(fd.dsTaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.005 -0400", hash_original_method = "738E096C5E6C6A5066A76A9B90DC0CA9", hash_generated_method = "7DBA47AF0B440C7155978BFB901DC21C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public FileDescriptor socket(int domain, int type, int protocol) throws ErrnoException {
        dsTaint.addTaint(protocol);
        dsTaint.addTaint(domain);
        dsTaint.addTaint(type);
        return (FileDescriptor)dsTaint.getTaint();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.005 -0400", hash_original_method = "6347DE7B46FE3FC2519EB3B202A3981D", hash_generated_method = "0EBA5583BCBDC3D4CED699C3543E6307")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StructStat stat(String path) throws ErrnoException {
        dsTaint.addTaint(path);
        return (StructStat)dsTaint.getTaint();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.005 -0400", hash_original_method = "5BCA24F466E28D74A0DD2E3DB7220B64", hash_generated_method = "C5DA3A46516A97EA0FB6F0736EE425E6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StructStatFs statfs(String path) throws ErrnoException {
        dsTaint.addTaint(path);
        return (StructStatFs)dsTaint.getTaint();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.005 -0400", hash_original_method = "DF22551AABB4776AE8588CD853791D73", hash_generated_method = "7D4485F5C76FD3367AE88F16D27037D5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String strerror(int errno) {
        dsTaint.addTaint(errno);
        return dsTaint.getTaintString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.005 -0400", hash_original_method = "551DE00FB0B39FAF904A5DC205CAA2EB", hash_generated_method = "561D98257118EC6C06435175F02BE5E2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void symlink(String oldPath, String newPath) throws ErrnoException {
        dsTaint.addTaint(newPath);
        dsTaint.addTaint(oldPath);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.005 -0400", hash_original_method = "0CA56D59A1B623A4EE1DB5A7E1204662", hash_generated_method = "D7A41567C9A229062D011922111BFDF8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long sysconf(int name) {
        dsTaint.addTaint(name);
        return dsTaint.getTaintLong();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.006 -0400", hash_original_method = "840E5C1D01B396A2EA80B4AFD333B092", hash_generated_method = "4D2B414BCD601357C997B0D05E49A51D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StructUtsname uname() {
        return (StructUtsname)dsTaint.getTaint();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.006 -0400", hash_original_method = "FE84032F23145F65306977A4498767E9", hash_generated_method = "CFC321EF5AFB55A7A7FC38D81081CFF0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int waitpid(int pid, MutableInt status, int options) throws ErrnoException {
        dsTaint.addTaint(status.dsTaint);
        dsTaint.addTaint(pid);
        dsTaint.addTaint(options);
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.006 -0400", hash_original_method = "FF46C2F8D2234796363F6B9031191E3B", hash_generated_method = "E74CCEF4DAEF6EA1F03EDC912C4187B5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int write(FileDescriptor fd, ByteBuffer buffer) throws ErrnoException {
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(fd.dsTaint);
        {
            boolean var21D6A43A19BB11FD75F2555CEDDC72D3_1057281990 = (buffer.isDirect());
            {
                int var018A5CC680E3A7E1C50076224C8C7605_1060432770 = (writeBytes(fd, buffer, buffer.position(), buffer.remaining()));
            } //End block
            {
                int var30C5EA943FBFB1242D64083C74DD8D3D_1394296590 = (writeBytes(fd, NioUtils.unsafeArray(buffer), NioUtils.unsafeArrayOffset(buffer) + buffer.position(), buffer.remaining()));
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (buffer.isDirect()) {
            //return writeBytes(fd, buffer, buffer.position(), buffer.remaining());
        //} else {
            //return writeBytes(fd, NioUtils.unsafeArray(buffer), NioUtils.unsafeArrayOffset(buffer) + buffer.position(), buffer.remaining());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.006 -0400", hash_original_method = "077A8F097DECE8A2C8BBB2583BE2D8BE", hash_generated_method = "BF3F518BBBFCD1C7E397DEBCB783D2E8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int write(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount) throws ErrnoException {
        dsTaint.addTaint(byteOffset);
        dsTaint.addTaint(bytes[0]);
        dsTaint.addTaint(byteCount);
        dsTaint.addTaint(fd.dsTaint);
        int var68D561E1E5C78821FF2B2E24F418F392_1801204600 = (writeBytes(fd, bytes, byteOffset, byteCount));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return writeBytes(fd, bytes, byteOffset, byteCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.006 -0400", hash_original_method = "E853B1F146558B1458DE2FB65CF651EB", hash_generated_method = "F6A8E16E77F0A08147F1441EBD2768CF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int writeBytes(FileDescriptor fd, Object buffer, int offset, int byteCount) throws ErrnoException {
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(byteCount);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(fd.dsTaint);
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.006 -0400", hash_original_method = "B9E2C692ADA119F653BB2CBF261E7047", hash_generated_method = "6B66F6B1C5FDA74DF89E756F716CF12E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int writev(FileDescriptor fd, Object[] buffers, int[] offsets, int[] byteCounts) throws ErrnoException {
        dsTaint.addTaint(byteCounts[0]);
        dsTaint.addTaint(offsets[0]);
        dsTaint.addTaint(buffers[0].dsTaint);
        dsTaint.addTaint(fd.dsTaint);
        return dsTaint.getTaintInt();
    }

    
}

