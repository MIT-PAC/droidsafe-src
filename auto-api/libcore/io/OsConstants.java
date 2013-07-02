package libcore.io;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public final class OsConstants {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.351 -0400", hash_original_method = "0498D6F7A9D700EE7D091D4440C7A579", hash_generated_method = "A197106530DC08E504EC74CDFEA7722E")
    private  OsConstants() {
        
    }

    
    public static boolean S_ISBLK(int mode) {
        return (mode & S_IFMT) == S_IFBLK;
    }

    
    public static boolean S_ISCHR(int mode) {
        return (mode & S_IFMT) == S_IFCHR;
    }

    
    public static boolean S_ISDIR(int mode) {
        return (mode & S_IFMT) == S_IFDIR;
    }

    
    public static boolean S_ISFIFO(int mode) {
        return (mode & S_IFMT) == S_IFIFO;
    }

    
    public static boolean S_ISREG(int mode) {
        return (mode & S_IFMT) == S_IFREG;
    }

    
    public static boolean S_ISLNK(int mode) {
        return (mode & S_IFMT) == S_IFLNK;
    }

    
    public static boolean S_ISSOCK(int mode) {
        return (mode & S_IFMT) == S_IFSOCK;
    }

    
    public static int WEXITSTATUS(int status) {
        return (status & 0xff00) >> 8;
    }

    
    public static boolean WCOREDUMP(int status) {
        return (status & 0x80) != 0;
    }

    
    public static int WTERMSIG(int status) {
        return status & 0x7f;
    }

    
    public static int WSTOPSIG(int status) {
        return WEXITSTATUS(status);
    }

    
    public static boolean WIFEXITED(int status) {
        return (WTERMSIG(status) == 0);
    }

    
    public static boolean WIFSTOPPED(int status) {
        return (WTERMSIG(status) == 0x7f);
    }

    
    public static boolean WIFSIGNALED(int status) {
        return (WTERMSIG(status + 1) >= 2);
    }

    
    public static String gaiName(int error) {
        if (error == EAI_AGAIN) {
            return "EAI_AGAIN";
        }
        if (error == EAI_BADFLAGS) {
            return "EAI_BADFLAGS";
        }
        if (error == EAI_FAIL) {
            return "EAI_FAIL";
        }
        if (error == EAI_FAMILY) {
            return "EAI_FAMILY";
        }
        if (error == EAI_MEMORY) {
            return "EAI_MEMORY";
        }
        if (error == EAI_NODATA) {
            return "EAI_NODATA";
        }
        if (error == EAI_NONAME) {
            return "EAI_NONAME";
        }
        if (error == EAI_OVERFLOW) {
            return "EAI_OVERFLOW";
        }
        if (error == EAI_SERVICE) {
            return "EAI_SERVICE";
        }
        if (error == EAI_SOCKTYPE) {
            return "EAI_SOCKTYPE";
        }
        if (error == EAI_SYSTEM) {
            return "EAI_SYSTEM";
        }
        return null;
    }

    
    public static String errnoName(int errno) {
        if (errno == E2BIG) {
            return "E2BIG";
        }
        if (errno == EACCES) {
            return "EACCES";
        }
        if (errno == EADDRINUSE) {
            return "EADDRINUSE";
        }
        if (errno == EADDRNOTAVAIL) {
            return "EADDRNOTAVAIL";
        }
        if (errno == EAFNOSUPPORT) {
            return "EAFNOSUPPORT";
        }
        if (errno == EAGAIN) {
            return "EAGAIN";
        }
        if (errno == EALREADY) {
            return "EALREADY";
        }
        if (errno == EBADF) {
            return "EBADF";
        }
        if (errno == EBADMSG) {
            return "EBADMSG";
        }
        if (errno == EBUSY) {
            return "EBUSY";
        }
        if (errno == ECANCELED) {
            return "ECANCELED";
        }
        if (errno == ECHILD) {
            return "ECHILD";
        }
        if (errno == ECONNABORTED) {
            return "ECONNABORTED";
        }
        if (errno == ECONNREFUSED) {
            return "ECONNREFUSED";
        }
        if (errno == ECONNRESET) {
            return "ECONNRESET";
        }
        if (errno == EDEADLK) {
            return "EDEADLK";
        }
        if (errno == EDESTADDRREQ) {
            return "EDESTADDRREQ";
        }
        if (errno == EDOM) {
            return "EDOM";
        }
        if (errno == EDQUOT) {
            return "EDQUOT";
        }
        if (errno == EEXIST) {
            return "EEXIST";
        }
        if (errno == EFAULT) {
            return "EFAULT";
        }
        if (errno == EFBIG) {
            return "EFBIG";
        }
        if (errno == EHOSTUNREACH) {
            return "EHOSTUNREACH";
        }
        if (errno == EIDRM) {
            return "EIDRM";
        }
        if (errno == EILSEQ) {
            return "EILSEQ";
        }
        if (errno == EINPROGRESS) {
            return "EINPROGRESS";
        }
        if (errno == EINTR) {
            return "EINTR";
        }
        if (errno == EINVAL) {
            return "EINVAL";
        }
        if (errno == EIO) {
            return "EIO";
        }
        if (errno == EISCONN) {
            return "EISCONN";
        }
        if (errno == EISDIR) {
            return "EISDIR";
        }
        if (errno == ELOOP) {
            return "ELOOP";
        }
        if (errno == EMFILE) {
            return "EMFILE";
        }
        if (errno == EMLINK) {
            return "EMLINK";
        }
        if (errno == EMSGSIZE) {
            return "EMSGSIZE";
        }
        if (errno == EMULTIHOP) {
            return "EMULTIHOP";
        }
        if (errno == ENAMETOOLONG) {
            return "ENAMETOOLONG";
        }
        if (errno == ENETDOWN) {
            return "ENETDOWN";
        }
        if (errno == ENETRESET) {
            return "ENETRESET";
        }
        if (errno == ENETUNREACH) {
            return "ENETUNREACH";
        }
        if (errno == ENFILE) {
            return "ENFILE";
        }
        if (errno == ENOBUFS) {
            return "ENOBUFS";
        }
        if (errno == ENODATA) {
            return "ENODATA";
        }
        if (errno == ENODEV) {
            return "ENODEV";
        }
        if (errno == ENOENT) {
            return "ENOENT";
        }
        if (errno == ENOEXEC) {
            return "ENOEXEC";
        }
        if (errno == ENOLCK) {
            return "ENOLCK";
        }
        if (errno == ENOLINK) {
            return "ENOLINK";
        }
        if (errno == ENOMEM) {
            return "ENOMEM";
        }
        if (errno == ENOMSG) {
            return "ENOMSG";
        }
        if (errno == ENOPROTOOPT) {
            return "ENOPROTOOPT";
        }
        if (errno == ENOSPC) {
            return "ENOSPC";
        }
        if (errno == ENOSR) {
            return "ENOSR";
        }
        if (errno == ENOSTR) {
            return "ENOSTR";
        }
        if (errno == ENOSYS) {
            return "ENOSYS";
        }
        if (errno == ENOTCONN) {
            return "ENOTCONN";
        }
        if (errno == ENOTDIR) {
            return "ENOTDIR";
        }
        if (errno == ENOTEMPTY) {
            return "ENOTEMPTY";
        }
        if (errno == ENOTSOCK) {
            return "ENOTSOCK";
        }
        if (errno == ENOTSUP) {
            return "ENOTSUP";
        }
        if (errno == ENOTTY) {
            return "ENOTTY";
        }
        if (errno == ENXIO) {
            return "ENXIO";
        }
        if (errno == EOPNOTSUPP) {
            return "EOPNOTSUPP";
        }
        if (errno == EOVERFLOW) {
            return "EOVERFLOW";
        }
        if (errno == EPERM) {
            return "EPERM";
        }
        if (errno == EPIPE) {
            return "EPIPE";
        }
        if (errno == EPROTO) {
            return "EPROTO";
        }
        if (errno == EPROTONOSUPPORT) {
            return "EPROTONOSUPPORT";
        }
        if (errno == EPROTOTYPE) {
            return "EPROTOTYPE";
        }
        if (errno == ERANGE) {
            return "ERANGE";
        }
        if (errno == EROFS) {
            return "EROFS";
        }
        if (errno == ESPIPE) {
            return "ESPIPE";
        }
        if (errno == ESRCH) {
            return "ESRCH";
        }
        if (errno == ESTALE) {
            return "ESTALE";
        }
        if (errno == ETIME) {
            return "ETIME";
        }
        if (errno == ETIMEDOUT) {
            return "ETIMEDOUT";
        }
        if (errno == ETXTBSY) {
            return "ETXTBSY";
        }
        if (errno == EWOULDBLOCK) {
            return "EWOULDBLOCK";
        }
        if (errno == EXDEV) {
            return "EXDEV";
        }
        return null;
    }

    
    private static void initConstants() {
    }

    
    private static int placeholder() {
        return 0;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.355 -0400", hash_original_field = "5AF56DAFCF9E2416B4D175354A6C8E01", hash_generated_field = "482A5E36885C73AF36D6029A0E1AC644")

    public static final int AF_INET = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.355 -0400", hash_original_field = "439EBA89FEF53B82BE3C841DC2E056E3", hash_generated_field = "39BD1786CD1F2CC6E01242300BDAAFBB")

    public static final int AF_INET6 = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.355 -0400", hash_original_field = "85DC58C71099D310C59C9B8CB7042A40", hash_generated_field = "ADAD79B76EBAE1BBE2B8333E5E162782")

    public static final int AF_UNIX = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.355 -0400", hash_original_field = "CA5C661C3FAF442FD3923DC11F9EC421", hash_generated_field = "45F5CFF2BF026E66F99C0293EDEFCB7A")

    public static final int AF_UNSPEC = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.355 -0400", hash_original_field = "5FEE7AB48F91E9A7B817530D88A57D46", hash_generated_field = "1C52FCD3B24444BFE034C8AF859E689B")

    public static final int AI_ADDRCONFIG = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.355 -0400", hash_original_field = "C62DA01A15FEE39637338487B95473E6", hash_generated_field = "C82227C21D5D464E608B1A6C62133AF9")

    public static final int AI_ALL = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.355 -0400", hash_original_field = "40CB8841D811731280C22361D79096AD", hash_generated_field = "F33369422BFDA541058C9E47F9ECDCC6")

    public static final int AI_CANONNAME = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.355 -0400", hash_original_field = "8396571D57513688D54DEC85D26FFA67", hash_generated_field = "DDEA51C9522197098294687D566ADCA0")

    public static final int AI_NUMERICHOST = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.355 -0400", hash_original_field = "5005E2E551A55C5CE3B9E3BA649F373C", hash_generated_field = "402FC34E275FAEBB5C3B97BEA8B0B4B7")

    public static final int AI_NUMERICSERV = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.355 -0400", hash_original_field = "F3444CF75A39DCC695652E9F48060839", hash_generated_field = "20B96BFB9F0AAC881B8557B30749D6F9")

    public static final int AI_PASSIVE = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.355 -0400", hash_original_field = "10E9E96B5D44DC103132E8227B2E57CD", hash_generated_field = "D44F0178082D9F00ECA136CDEDB2843F")

    public static final int AI_V4MAPPED = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.355 -0400", hash_original_field = "9F3BD46803246C52792FA1B571025EAA", hash_generated_field = "22779920E7E00F3F97A136F8C5E38C3E")

    public static final int E2BIG = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.355 -0400", hash_original_field = "F310A436291F443212C9159FED30999A", hash_generated_field = "77093667D80E76D4D84711D0B53964FB")

    public static final int EACCES = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.355 -0400", hash_original_field = "E82D80F84CA02D4D30F1FB35559DAA52", hash_generated_field = "19C3DD77F58178B1681833245D7CA5D1")

    public static final int EADDRINUSE = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.355 -0400", hash_original_field = "820DA93355FB25AEFD970009761DF8A3", hash_generated_field = "791D88D3591F827F5DFD1ADB303DEF58")

    public static final int EADDRNOTAVAIL = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.355 -0400", hash_original_field = "ED940283D26502FF164052787FCD2FC7", hash_generated_field = "8DA506488F2A4768734AECDA2FF00987")

    public static final int EAFNOSUPPORT = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.355 -0400", hash_original_field = "33358DAA1EF92452E8B7457043C660C7", hash_generated_field = "37B47A5025FA649A2B0117FF440E52E6")

    public static final int EAGAIN = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.355 -0400", hash_original_field = "1D07919B46ECC2AB66BD6D249FCB406B", hash_generated_field = "C7D0046F090CDA77AC23440DC64944B9")

    public static final int EAI_AGAIN = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.355 -0400", hash_original_field = "FCD7025701B9A684C76DBBFE6893B161", hash_generated_field = "3074468B14FEDC3DE449F16DE89B02ED")

    public static final int EAI_BADFLAGS = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.355 -0400", hash_original_field = "4E2AD5B3BCB704B1CD377255D713837F", hash_generated_field = "6DAED9157D3933AEF03218488BFDD9A1")

    public static final int EAI_FAIL = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.355 -0400", hash_original_field = "DDA9F579701939BC0B068084170B130A", hash_generated_field = "0C317FE5F7EF54AF98E5C7E07BCC1D36")

    public static final int EAI_FAMILY = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.355 -0400", hash_original_field = "2E7E3013376E7CA600720D85EE48D0C4", hash_generated_field = "A5140BFCD021392D029FEEFF70CAEE55")

    public static final int EAI_MEMORY = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.355 -0400", hash_original_field = "45FC3523535F44088FC95C089654A688", hash_generated_field = "67157B230287FFEE10EF5B48D280EE08")

    public static final int EAI_NODATA = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.355 -0400", hash_original_field = "49A14F73F4BC742EBD3DA0B6C6501EEA", hash_generated_field = "5754754726002943A6619165239E4220")

    public static final int EAI_NONAME = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.355 -0400", hash_original_field = "9B2B72B5B28A824944436A05BA098FE6", hash_generated_field = "131C97BC72FB9CE37862E7376A878267")

    public static final int EAI_OVERFLOW = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.355 -0400", hash_original_field = "05F2FF1997914748351B0D567523DD42", hash_generated_field = "58880A2C3121A4CD31C8B1091702FD79")

    public static final int EAI_SERVICE = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.355 -0400", hash_original_field = "E2134557C5E624AFD941E1AD88750867", hash_generated_field = "BF85A8C5DC1C160F6DFE5E877F5BF333")

    public static final int EAI_SOCKTYPE = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.355 -0400", hash_original_field = "FE7ECCD1DE8D6BC49D4F008CD4CEA721", hash_generated_field = "E784409C26D50C8CA2CD68FDD59364B8")

    public static final int EAI_SYSTEM = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.355 -0400", hash_original_field = "9790BF703024CB768D38AA82249FE75C", hash_generated_field = "A2D944916090E489B8CB8EA81016980E")

    public static final int EALREADY = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.356 -0400", hash_original_field = "8E99E52E7453354BBB5DDB658E4486E7", hash_generated_field = "D98EFFC40CBC020EF6D861094EE7D306")

    public static final int EBADF = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.356 -0400", hash_original_field = "6E7EA25170356B18979ECDD1AA494755", hash_generated_field = "A21ECFCF1EF979F280588D1415B72B25")

    public static final int EBADMSG = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.356 -0400", hash_original_field = "7A1477E83F0E65B2F807DFD23749BFE4", hash_generated_field = "BE69CB2EF975808A460615BBB31EB5CE")

    public static final int EBUSY = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.356 -0400", hash_original_field = "B56E6E8A76A874915695CBC7BDAB1052", hash_generated_field = "0E206F1C8BF2019011FB9251595876C4")

    public static final int ECANCELED = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.356 -0400", hash_original_field = "82C23D1ADFA59E76FC8308FE2E0F6E9A", hash_generated_field = "FF7E957B80537F4A06897A2DCCAA6B69")

    public static final int ECHILD = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.356 -0400", hash_original_field = "E1F923C3EF206CC792CF92C985BD5899", hash_generated_field = "AB8EDEBEFD48CC3088410F2E9E829489")

    public static final int ECONNABORTED = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.356 -0400", hash_original_field = "5A4752449F4B56EFF7160DEFD6DFF96D", hash_generated_field = "E64976B3FC0257AC9D2DDE9D50719FD9")

    public static final int ECONNREFUSED = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.356 -0400", hash_original_field = "55D1D1F5F16700063ADB7D3C494A0BBC", hash_generated_field = "A5D0C9B98560240888C5465E121FC313")

    public static final int ECONNRESET = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.356 -0400", hash_original_field = "37294EF41C50AD3D52D05C46AC9186F5", hash_generated_field = "9B79F4DABB6079CA455BD918A6ADE4B7")

    public static final int EDEADLK = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.356 -0400", hash_original_field = "122DECE1269B2B1C88652B4759A6807B", hash_generated_field = "C04D11134AA1160A6A114EA170D656FC")

    public static final int EDESTADDRREQ = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.356 -0400", hash_original_field = "7F1E0FF58FB3621E7B56E4164C7120B9", hash_generated_field = "578CA375D3E11BB56601C009C281A1B4")

    public static final int EDOM = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.356 -0400", hash_original_field = "E1557F9221E0D4A4E84C7694236F14CD", hash_generated_field = "D3983260757DE62C83B4CFC7978BC9E1")

    public static final int EDQUOT = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.356 -0400", hash_original_field = "58E3C91031A867A4127586BCD3BDEBA5", hash_generated_field = "C49939D05E6D8AE9BA2CF8DE12BC3BBA")

    public static final int EEXIST = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.356 -0400", hash_original_field = "4467C1D16E2ADAAC77F8A4C147D662B9", hash_generated_field = "1057235BC81E98AAE1C475BAF4619779")

    public static final int EFAULT = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.356 -0400", hash_original_field = "A04885649B55A4E70AA63E39D9896A9F", hash_generated_field = "FFE428DEA5986574C044B7ABB14D50E4")

    public static final int EFBIG = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.356 -0400", hash_original_field = "9CF32092F0A5D2CED1E3CE5C1378730E", hash_generated_field = "0FFC1B5163C6347514BF0C00CA9EB025")

    public static final int EHOSTUNREACH = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.356 -0400", hash_original_field = "34F28429AAD75DB04E34DD0E79FD30E8", hash_generated_field = "0B178D01125C38C6C94BC11447D92A07")

    public static final int EIDRM = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.356 -0400", hash_original_field = "BE582B14CAF3EDB40C2CFE32826FB95D", hash_generated_field = "AFC30674B71C7D670B98A40E6EC8EFE4")

    public static final int EILSEQ = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.356 -0400", hash_original_field = "ED9CEC65CB2DF408E9F70C030B3B9C07", hash_generated_field = "0E947E199B4D3197FEB8FB3B8D591D74")

    public static final int EINPROGRESS = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.356 -0400", hash_original_field = "3FDB2381D2F63C84DC0E6FDB7A712D58", hash_generated_field = "212FEF1F9CA81D2781459976365EB88F")

    public static final int EINTR = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.356 -0400", hash_original_field = "FBCD8740864F394ACEE76A349C75CBE4", hash_generated_field = "4B8B89FE05533595D9791129FC4D83AB")

    public static final int EINVAL = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.356 -0400", hash_original_field = "82006B1FC3C10E26D51525BCF0EACB56", hash_generated_field = "00AD0A4BBA955959F77644A9E459E076")

    public static final int EIO = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.356 -0400", hash_original_field = "A7C73435F62660C9C43899F822D8A088", hash_generated_field = "B82D6BF6EB2F0F2F049D77DA995B9758")

    public static final int EISCONN = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.356 -0400", hash_original_field = "FAEBE4E4C74F58A62DCBA6CC07C45B33", hash_generated_field = "556A4A8D62ABD9738A9178140E70CDD2")

    public static final int EISDIR = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.356 -0400", hash_original_field = "97A973A67E5A9E149E4D05B184FF1798", hash_generated_field = "2B03E12BBF4F18DE1A0EFF67A68EF8AE")

    public static final int ELOOP = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.356 -0400", hash_original_field = "3669ADD4B582177511168A6BB6ED0889", hash_generated_field = "86308CBA7343BC540687AF4AE5875DAD")

    public static final int EMFILE = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.356 -0400", hash_original_field = "AC0D0510CB4A02B46CAA7FA66585544D", hash_generated_field = "D6F4777D6D2632DC070E43A7FF2B149A")

    public static final int EMLINK = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.356 -0400", hash_original_field = "FE9D2D0B5435FFB8429B744442F5F975", hash_generated_field = "804245D924876CC06B4887022AFCD422")

    public static final int EMSGSIZE = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.356 -0400", hash_original_field = "4BD76EEBC8E9E0DDD58338FF27DD2433", hash_generated_field = "DE104EF18FCD11961FF0CC473C19F474")

    public static final int EMULTIHOP = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.356 -0400", hash_original_field = "37E041E53EBF241DE8606B0FE84044F8", hash_generated_field = "35D96A09F974660E340931777AD2A861")

    public static final int ENAMETOOLONG = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.356 -0400", hash_original_field = "5B9B65FF8C988260CAEEC3F9EF5B3FE8", hash_generated_field = "1D7AB12661E35C2A40CD50DB39358167")

    public static final int ENETDOWN = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.356 -0400", hash_original_field = "AFE25709C6F7C6CA1635F5C2F03B7604", hash_generated_field = "4F9068185B48F32A672CCE3EBB295A1B")

    public static final int ENETRESET = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.356 -0400", hash_original_field = "00B11B6430E6DCA65502EF79E1EC8973", hash_generated_field = "D848BEE0F666121D559C794D84DC1BEE")

    public static final int ENETUNREACH = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.356 -0400", hash_original_field = "567B5954147E65E753F3D53947E942FA", hash_generated_field = "5BC77D0D67D219E1FCA87876B45BD32C")

    public static final int ENFILE = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.356 -0400", hash_original_field = "B41DF3643F5A57A6330D28F33BFE5660", hash_generated_field = "69A301BFBBBD3F1C187EF860381A3A20")

    public static final int ENOBUFS = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.356 -0400", hash_original_field = "2DB40DEE1AE219F2489441E4D5FCEBDB", hash_generated_field = "509FB735E498DFD6E9437517ED161CE4")

    public static final int ENODATA = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.356 -0400", hash_original_field = "529A2A3F6E4EAC543C4836DBF9E412FA", hash_generated_field = "F1655B771EF4863E9D631A9703F7AE43")

    public static final int ENODEV = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.356 -0400", hash_original_field = "68E1123E8DDB4493769C0415883C18FC", hash_generated_field = "B0473C9DD3B25D891F6CC451562901BE")

    public static final int ENOENT = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.356 -0400", hash_original_field = "14ACA51D21FB8DEDC35051893C611563", hash_generated_field = "08BAE88FE5B3B11D4577FD5DA4C885FF")

    public static final int ENOEXEC = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.356 -0400", hash_original_field = "4207D931B1EBE53C8AC719A4A1ABD47B", hash_generated_field = "C16A9A9922A5D468229191FD772F56C9")

    public static final int ENOLCK = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.356 -0400", hash_original_field = "8E3FE6845CBA6648F795151B89363B0E", hash_generated_field = "A8D367655CFB5285E68AE5C485AE0B07")

    public static final int ENOLINK = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.356 -0400", hash_original_field = "A2E107BB077BB4F64A319A77F05CF2FE", hash_generated_field = "03A0B2F9D9248AD1E8CB187130607A45")

    public static final int ENOMEM = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.356 -0400", hash_original_field = "C8C7CF17952F85AD7EE892DD97D0CB47", hash_generated_field = "CBCAFB787711713095226C1F8D8FCC9A")

    public static final int ENOMSG = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.356 -0400", hash_original_field = "98B57DC25ECADED5545615C95AD817BF", hash_generated_field = "5DE76B95E8AC63E6318539AA95F43253")

    public static final int ENOPROTOOPT = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.356 -0400", hash_original_field = "44ED6BC376EEB08F9D47085ABA009134", hash_generated_field = "D76A4095ED749FFB6ABB6805816EBE06")

    public static final int ENOSPC = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.356 -0400", hash_original_field = "971CEA6EF1A3D92C17F9D0C28C0E9DF5", hash_generated_field = "C3F025BFB574899245D089D875687F56")

    public static final int ENOSR = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.356 -0400", hash_original_field = "54960AC4AE49891BF22FC230C824DA12", hash_generated_field = "A8D49629EF906A76F942445B77BFC048")

    public static final int ENOSTR = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.356 -0400", hash_original_field = "A2773AC7A944D8EC42FE5482496F2A38", hash_generated_field = "DA66249BFE97E040FD338FA3106D68D9")

    public static final int ENOSYS = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.357 -0400", hash_original_field = "EDFAB97F0907ABC425D35F81672BF403", hash_generated_field = "2A2F3FD44366EB4B33C43E4AD57DEC66")

    public static final int ENOTCONN = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.357 -0400", hash_original_field = "648FA676B894609454DD42ECA86E250A", hash_generated_field = "B64A7D37C92D9AB0CF20C430D69B5834")

    public static final int ENOTDIR = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.357 -0400", hash_original_field = "C88F076D3C181E832842CBD25A7071D2", hash_generated_field = "379FD039078CD401802B98861CD3FFE0")

    public static final int ENOTEMPTY = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.357 -0400", hash_original_field = "F8F68ACAF0B128738F96BCFA3ED1A591", hash_generated_field = "8C4BC080B92428B37AFBD88991EA1E63")

    public static final int ENOTSOCK = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.357 -0400", hash_original_field = "8123A31F308330C3D104D346AEF2AC81", hash_generated_field = "89F6D72438BD122B606383CDEFBAA43E")

    public static final int ENOTSUP = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.357 -0400", hash_original_field = "332EB1A8B1191B9FBA751F9710A71E37", hash_generated_field = "775E7CE22934B82500F869FDABDD7651")

    public static final int ENOTTY = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.357 -0400", hash_original_field = "6F5054A989A84D68357A27BE27E447DB", hash_generated_field = "0A07C823F2BD082F0893F711A04E720A")

    public static final int ENXIO = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.357 -0400", hash_original_field = "936EFAA6F314C8B898D1E5739B583771", hash_generated_field = "1433BD89E3D520625A9B9CBE12429A81")

    public static final int EOPNOTSUPP = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.357 -0400", hash_original_field = "A8BA4E8226D00DDB3A2C2463FB290479", hash_generated_field = "BC06ACD6A7E0B073E5707C56CBBC9F2F")

    public static final int EOVERFLOW = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.357 -0400", hash_original_field = "37A2C0D7371B4901DCF31549EE6E3402", hash_generated_field = "F5232F911C09C309FFB9736ABADFF276")

    public static final int EPERM = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.357 -0400", hash_original_field = "C9EC6824A5389510882283E76EA742F2", hash_generated_field = "CB930425A51FE80BB59F9AFFCF884646")

    public static final int EPIPE = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.357 -0400", hash_original_field = "2A04E63E6A3195D244EEB3CB48F2A405", hash_generated_field = "4D6F5FBBB70DEEA2E337D9D3EDF6BF61")

    public static final int EPROTO = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.357 -0400", hash_original_field = "FA0BCFE58D33B84F508CCC585FD5AFF8", hash_generated_field = "DF8EAA47C7CC2A860BCAC729C969D2ED")

    public static final int EPROTONOSUPPORT = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.357 -0400", hash_original_field = "43CDFE40D22141C548D39022BDC6E0ED", hash_generated_field = "BA6AFDE57C408EA7B54C7E266B46C825")

    public static final int EPROTOTYPE = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.357 -0400", hash_original_field = "16FC2FFC9889F92E40A9BBF1DCD42F12", hash_generated_field = "1631F87CB74C9337A8A27ECDD5197DE9")

    public static final int ERANGE = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.357 -0400", hash_original_field = "66839500CAD64CFF23666B02D84E4CD3", hash_generated_field = "5A69469090CC98241FC233E59FDAA249")

    public static final int EROFS = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.357 -0400", hash_original_field = "C03BF09BEEE34E42C55874AB83BCFF11", hash_generated_field = "F74794478BAD77F4514AB3F5EC1F1570")

    public static final int ESPIPE = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.357 -0400", hash_original_field = "D69CAB794F2ED3705CFE73C209AA5BEA", hash_generated_field = "991D954ABFB7B07D3501DE8F500BDAD1")

    public static final int ESRCH = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.357 -0400", hash_original_field = "10D000808889DCE734D28288D06AD913", hash_generated_field = "A542C0BC47281003A9113C20223885AC")

    public static final int ESTALE = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.357 -0400", hash_original_field = "EF68302840A7F6C7542DBC81A13504CA", hash_generated_field = "14EE79346B4FD42B8E48E6F7221E0CE3")

    public static final int ETIME = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.357 -0400", hash_original_field = "9FCA49C367AC491CBCD9F213B46F24BC", hash_generated_field = "680F483052F55F9322BA0DD2E6756EBB")

    public static final int ETIMEDOUT = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.357 -0400", hash_original_field = "91FE0F162CA96EFF731D36322FB6223A", hash_generated_field = "F5890E29FD67945D8A9FAB0756DED43A")

    public static final int ETXTBSY = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.357 -0400", hash_original_field = "811B701E2703929541883467ED5EABC6", hash_generated_field = "7955FF5CE1990F6D985201B5B8504207")

    public static final int EWOULDBLOCK = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.357 -0400", hash_original_field = "9B470906AE684323082F1E3F17D36E47", hash_generated_field = "7863304E29A71F784CFE8BF5724D107F")

    public static final int EXDEV = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.357 -0400", hash_original_field = "F37F5D818B960A1B6C1908D43E83CEC5", hash_generated_field = "5A853747D31FC75F7D19E856810A9956")

    public static final int EXIT_FAILURE = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.357 -0400", hash_original_field = "F569DC449BAE61AF349126BABA8C3AD7", hash_generated_field = "F2B1FC5EC957C7C6F69E6F16118374A6")

    public static final int EXIT_SUCCESS = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.357 -0400", hash_original_field = "276E9995000F0EFE7676D1FD27A6EF64", hash_generated_field = "3DB5AEF69334E62668BD128B2E8B54FD")

    public static final int FD_CLOEXEC = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.357 -0400", hash_original_field = "608450D7D2069891D65EE84402F37BD9", hash_generated_field = "02ED32EEAEF5DBFE84F8A1F9B1B8A7A3")

    public static final int FIONREAD = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.357 -0400", hash_original_field = "4EFD90C5B1E59C95C33B19F81252EDDE", hash_generated_field = "74F79087DB9C802D2894E51D0C4A0318")

    public static final int F_DUPFD = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.357 -0400", hash_original_field = "1139D799DA8C7A8814D41F42468F973F", hash_generated_field = "94C9456FCB1CABFBEBDB4BA3483F4A49")

    public static final int F_GETFD = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.357 -0400", hash_original_field = "A2A697E0345EE6E1F44715DC528C013E", hash_generated_field = "B36CAC664A903E159ADB9D3A9CFB5921")

    public static final int F_GETFL = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.357 -0400", hash_original_field = "6C10CDB02E977A6431FC569F0848527A", hash_generated_field = "D4131E86930A58E28C5282A885660B73")

    public static final int F_GETLK = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.357 -0400", hash_original_field = "B58C1AF0F07D5B737251B2DC56BE074B", hash_generated_field = "AE29CB4C7F1D3FAE666A85A7A28E19E9")

    public static final int F_GETLK64 = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.357 -0400", hash_original_field = "430840604C6B987B4AECEEE52354112E", hash_generated_field = "7838B694E5FF8E126F3D0219BC2D8B7B")

    public static final int F_GETOWN = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.357 -0400", hash_original_field = "8949BB46B87DE980CB23344D4FAE3B7E", hash_generated_field = "C9746D16BD4185CCD3F234478D8C9471")

    public static final int F_OK = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.357 -0400", hash_original_field = "310D1AF96025F312543410BFB3689C4C", hash_generated_field = "78CD9A3EFB7926AD35E04F26321A7B35")

    public static final int F_RDLCK = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.357 -0400", hash_original_field = "F38596AF197D392FF5E23E8E716EAC7B", hash_generated_field = "C77B39B81A7611223C3FB6932D0AB948")

    public static final int F_SETFD = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.357 -0400", hash_original_field = "CB168B02E56C5C0532762C0B106FDCAD", hash_generated_field = "ABC37E3ABCC01D099CC689B798E74D2C")

    public static final int F_SETFL = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.357 -0400", hash_original_field = "8FC0D327AF40F5B0366DDAC1FC3FD8B0", hash_generated_field = "7875A8207CFC80133EAA391C042AB8FB")

    public static final int F_SETLK = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.357 -0400", hash_original_field = "E6FAC678CFC185822C3BB2D3793857F5", hash_generated_field = "74EA9CC7A227689E675D694E70FC7E66")

    public static final int F_SETLK64 = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.357 -0400", hash_original_field = "CC4264CA378FD104A00C623F5DBB1392", hash_generated_field = "05F7C1E9B830DE477F75CC1BED13D0F1")

    public static final int F_SETLKW = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.357 -0400", hash_original_field = "C6EC5509F87D9C82A4E2050D9DF12A40", hash_generated_field = "AC90ED2A211D5B837AE577E134F9872C")

    public static final int F_SETLKW64 = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.357 -0400", hash_original_field = "E98F56B1B871941B99B58331F1928E88", hash_generated_field = "688217BE189CF67981FCFB148A02D135")

    public static final int F_SETOWN = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.357 -0400", hash_original_field = "8196C14580024FD1D1F6A2EA63537D64", hash_generated_field = "3F2AB1519DF6D2D7D759A8145280E81A")

    public static final int F_UNLCK = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.357 -0400", hash_original_field = "0C7BB3F43127D100AD9A76F38100D617", hash_generated_field = "84FB8D216EB9826A5056B13629E08B39")

    public static final int F_WRLCK = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.357 -0400", hash_original_field = "C264036EA51B7ADB822918A157C50F61", hash_generated_field = "645C10A5468246566CAE543F0A3FA502")

    public static final int IFF_ALLMULTI = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.357 -0400", hash_original_field = "6E09974F80C31BFA7F30413701092F19", hash_generated_field = "0C6F17FA9B4397F88191C91DD21BFB1D")

    public static final int IFF_AUTOMEDIA = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.357 -0400", hash_original_field = "64D662DC9DC9A5DF8A811016346C10E7", hash_generated_field = "B8083E100257FBC5CCF7483C6B8BB010")

    public static final int IFF_BROADCAST = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.358 -0400", hash_original_field = "AC325A5A95BC2F2CF611934CA8470C4E", hash_generated_field = "79170692775864C2169227426545F5C0")

    public static final int IFF_DEBUG = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.358 -0400", hash_original_field = "E4AD91955D36B719A0FFB144E50E55DA", hash_generated_field = "A03CE46A3A864415EF038425B6AEC922")

    public static final int IFF_DYNAMIC = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.358 -0400", hash_original_field = "E4F23EF3CC3C32F97447284F57E6F688", hash_generated_field = "73FAB591909F79F60CA9FC40D6F96706")

    public static final int IFF_LOOPBACK = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.358 -0400", hash_original_field = "EF7E6412A9AD1EBE3EC73D7CBCF35A88", hash_generated_field = "E3CBD214A8478115E8E5BD63577D11B9")

    public static final int IFF_MASTER = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.358 -0400", hash_original_field = "634EC2C930EA6396694319B32305ECF0", hash_generated_field = "E6B2D7952B753D4F99805AD56B7231B8")

    public static final int IFF_MULTICAST = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.358 -0400", hash_original_field = "1A82C64EA386DE34883F15F98AA891E1", hash_generated_field = "B57C73E686305543019AEF6E147C770A")

    public static final int IFF_NOARP = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.358 -0400", hash_original_field = "7CF35B79B7EBE18507CF65B75AB13C45", hash_generated_field = "879988EE064A61F40D2BDA0330A0363E")

    public static final int IFF_NOTRAILERS = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.358 -0400", hash_original_field = "7419FF206D0444126747F1BB262E7EA7", hash_generated_field = "7A8361EEA005F5C176B9D054EBECD23B")

    public static final int IFF_POINTOPOINT = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.358 -0400", hash_original_field = "5D41138CC26B0C6F906ADC305535FC69", hash_generated_field = "680FCE76F24295022819C7E5FFCA6769")

    public static final int IFF_PORTSEL = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.358 -0400", hash_original_field = "96278AC6D6546CCC9674E8164BC78D0A", hash_generated_field = "F4B5118A54E8B36A57901FD29FD024C1")

    public static final int IFF_PROMISC = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.358 -0400", hash_original_field = "8F9FED3F752BB2F91581E5953E0B2576", hash_generated_field = "6C39957127E5F1C02D02B2B8F84D14BB")

    public static final int IFF_RUNNING = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.358 -0400", hash_original_field = "F8B3C147F0713C2D5797B5BA7E5C75DB", hash_generated_field = "27A77E0AC4239B25087C90700D30A52D")

    public static final int IFF_SLAVE = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.358 -0400", hash_original_field = "7442A9C16CE39E375E6EBDF3169F1180", hash_generated_field = "0C07466398E428D8D1AEEBC26693D5CE")

    public static final int IFF_UP = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.358 -0400", hash_original_field = "E3E3DE9922A8D678C095EFFF4B9355CC", hash_generated_field = "CA29531C54B20FC77B28C001F3F547F8")

    public static final int IPPROTO_ICMP = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.358 -0400", hash_original_field = "1D3FC2848763F842D7367855518718AC", hash_generated_field = "AC6F903CCEAFD8F87AD98B20C03F293E")

    public static final int IPPROTO_IP = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.358 -0400", hash_original_field = "21E9D717121F220B002A31E75717AD23", hash_generated_field = "67AAAE0362FE7B1D7F197DA2669BC241")

    public static final int IPPROTO_IPV6 = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.358 -0400", hash_original_field = "B249D5B55EE8C7CE543E64E35582116F", hash_generated_field = "BCE6826511D6B2CCE91B0E1E5B9A7223")

    public static final int IPPROTO_RAW = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.358 -0400", hash_original_field = "0208F14ADA86CD189D9B1937DA05181A", hash_generated_field = "89BA07ECE4307FD0730B852BD735E60D")

    public static final int IPPROTO_TCP = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.358 -0400", hash_original_field = "03E6EB989E683B31C452C0A13FB9F5DE", hash_generated_field = "74C4007D6D5447B05E1C8A6A37498E26")

    public static final int IPPROTO_UDP = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.358 -0400", hash_original_field = "F39AF48A107DBD24F665D24E9A65E206", hash_generated_field = "4944D12E8C6CA68F81D1CC0154735188")

    public static final int IPV6_CHECKSUM = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.358 -0400", hash_original_field = "1CCC0E7B7985E5D90B5A01CF53F5E908", hash_generated_field = "D6C187C69E9DFD535AB476740F0A5E94")

    public static final int IPV6_MULTICAST_HOPS = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.358 -0400", hash_original_field = "22E73CA633476B137A29DC5C3A7C1CF8", hash_generated_field = "4F7FD6AFB19D0FC5D2F31996DA977D61")

    public static final int IPV6_MULTICAST_IF = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.358 -0400", hash_original_field = "6E907520A5A82704CB3B66AE38E94802", hash_generated_field = "F6EB27E6C091A3B58C617C44783041D1")

    public static final int IPV6_MULTICAST_LOOP = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.358 -0400", hash_original_field = "0435948BA410B82A4026246B0D54896E", hash_generated_field = "7BDECCFC9D82051B7CAD89BD30B028E9")

    public static final int IPV6_RECVDSTOPTS = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.358 -0400", hash_original_field = "A3DFCDFD215AC4B5C1EA0E29641E60DA", hash_generated_field = "14AA3D0AC2D9ADEC534FE7C063F1C514")

    public static final int IPV6_RECVHOPLIMIT = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.358 -0400", hash_original_field = "392252EB8BE50C457C3F58DAA9D39EEE", hash_generated_field = "BAD531550680930EEB770177F97377E5")

    public static final int IPV6_RECVHOPOPTS = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.358 -0400", hash_original_field = "C40CC21B049ECBC7384AF73AEDC247B9", hash_generated_field = "3D7146308FA53F206C599558CDE5DA04")

    public static final int IPV6_RECVPKTINFO = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.358 -0400", hash_original_field = "9A408F22A2C88B0767C11C229A7DE8CB", hash_generated_field = "D9D24899CC28C88D924C47746DBB9DDD")

    public static final int IPV6_RECVRTHDR = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.358 -0400", hash_original_field = "BCC45E77BCEA6DB4BAAC81DD611D8088", hash_generated_field = "4082B672B001CFA1C3834BAF3F0C2E72")

    public static final int IPV6_RECVTCLASS = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.358 -0400", hash_original_field = "4717FA40EB9F4E36A3861C1A1E3D3B64", hash_generated_field = "E5306C188C5B1E1D738750F7BEEF43AD")

    public static final int IPV6_TCLASS = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.358 -0400", hash_original_field = "25FF7CA415111A0EDE79033292F01A1B", hash_generated_field = "A2C733FA895B3A72661740548C60DFFF")

    public static final int IPV6_UNICAST_HOPS = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.358 -0400", hash_original_field = "D19F2BC204A8A839850C8622250BEFBC", hash_generated_field = "9F2A345456A34CCC52D00EDB60F0F2DD")

    public static final int IPV6_V6ONLY = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.358 -0400", hash_original_field = "4DBB245DE8F848DD52D4A583B7C9EF24", hash_generated_field = "D1AB8F455F85FFA7F147ADA083C1762D")

    public static final int IP_MULTICAST_IF = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.358 -0400", hash_original_field = "BE5F0518B52241199A1484C1C2C96A5F", hash_generated_field = "860A2E8190A829ADF9C24765F87BDE63")

    public static final int IP_MULTICAST_LOOP = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.358 -0400", hash_original_field = "F737F34A70301AA6DFE532969655E508", hash_generated_field = "B80624FC025993B1FD570EE2EEE17E88")

    public static final int IP_MULTICAST_TTL = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.358 -0400", hash_original_field = "30F02A08ED0CAB157962AEF8CF9359DD", hash_generated_field = "18D0831A1B845913FA7DDE43EF722CCC")

    public static final int IP_TOS = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.358 -0400", hash_original_field = "983A6C1B6FA2634FA12CE113317D930D", hash_generated_field = "6CF9812BD98DE530823FDEBA50CFCA3A")

    public static final int IP_TTL = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.358 -0400", hash_original_field = "A49DBE18FB33E4CC56C1311C07309B6F", hash_generated_field = "7B11268B63BB847B88D7EDF908672BD0")

    public static final int MAP_FIXED = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.358 -0400", hash_original_field = "A23AA03455B7B9D9C4251DC801D0871E", hash_generated_field = "F70BD7A0982600BBA677102790C126D2")

    public static final int MAP_PRIVATE = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.358 -0400", hash_original_field = "367538F0A969DA8729D03C7DE9733694", hash_generated_field = "453C98951EFF51073008EBCBB80BE851")

    public static final int MAP_SHARED = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.358 -0400", hash_original_field = "A9750D40ECFF86F6F64BECD4A8533C4C", hash_generated_field = "B9952D2EEC386D199D4EB5B06950E600")

    public static final int MCAST_JOIN_GROUP = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.358 -0400", hash_original_field = "2492E4DCF887E3936FEF41361B2ED82F", hash_generated_field = "3C5C47E390F3ED5BE35389F6E93D10F8")

    public static final int MCAST_LEAVE_GROUP = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.358 -0400", hash_original_field = "5523696563008E60EFCF29C555E24007", hash_generated_field = "A2C9A6D85A9726C2E05F9FBEA8E4DA2E")

    public static final int MCL_CURRENT = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.358 -0400", hash_original_field = "FAA58795D31D2182AB2D644CF6F38472", hash_generated_field = "487C0000D97AA9AF43145A3F44E9A00C")

    public static final int MCL_FUTURE = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.358 -0400", hash_original_field = "361E133731D1868861096E0078CA8E14", hash_generated_field = "D51A6DFBE019437E53762CA4FEA6507C")

    public static final int MSG_CTRUNC = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.358 -0400", hash_original_field = "74320CC31C58832725800CF69CF1CC76", hash_generated_field = "0FB21ACC2F5E0835F797F5C45FD9943B")

    public static final int MSG_DONTROUTE = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.358 -0400", hash_original_field = "8CBB125ABD211461F60ABB2A91CD803F", hash_generated_field = "85F7BB0422429550D172BA06934111D6")

    public static final int MSG_EOR = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.358 -0400", hash_original_field = "0E140DBF20840550D3A3DEC67206E535", hash_generated_field = "F6741D411A3FF13F71B2A7F036D756AC")

    public static final int MSG_OOB = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.358 -0400", hash_original_field = "F79B0F93C9995EC103FA45A155025BE2", hash_generated_field = "23648134841E62EF43708FBD97EE7AF5")

    public static final int MSG_PEEK = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.358 -0400", hash_original_field = "D64650BA1C295CC6864F40B20A0B44B3", hash_generated_field = "75D5F74C2246D786136D769EB1E0E191")

    public static final int MSG_TRUNC = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.358 -0400", hash_original_field = "48AB30AFABA3B01A28831644D25162A0", hash_generated_field = "6681928621750040EC1B0BBD349EA7AE")

    public static final int MSG_WAITALL = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.358 -0400", hash_original_field = "A9F5FA537FA353F3BD4A29363E4A8237", hash_generated_field = "6CED3FCAF409D23B20ED2732D595FF31")

    public static final int MS_ASYNC = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.358 -0400", hash_original_field = "63D4B05BCFF663C625FAB5A5FCF19FAA", hash_generated_field = "BB73C71FDF909698AE7915EC2F6A8881")

    public static final int MS_INVALIDATE = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.359 -0400", hash_original_field = "35988C408A00C07B9C3376C6A2557AAF", hash_generated_field = "AB7F9A8B404F1CFB1DE70EC253C8FE4F")

    public static final int MS_SYNC = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.359 -0400", hash_original_field = "389DE6DD94637B9DA9679CF2FDB2EA8D", hash_generated_field = "B6A981FC25E20E27CE10B6449EF6ED42")

    public static final int NI_DGRAM = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.359 -0400", hash_original_field = "E7526C65A78A8E9FF95066D48F033C59", hash_generated_field = "C88D08604C53FC9E81CB22080A5CDAF9")

    public static final int NI_NAMEREQD = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.359 -0400", hash_original_field = "7597B62C8DE96481CB5241BA1A5B0A7C", hash_generated_field = "A997FCD46E8F73448CD385FDCF07210C")

    public static final int NI_NOFQDN = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.359 -0400", hash_original_field = "2C2E5D95437530E042DFC29748924FB1", hash_generated_field = "E186ADE02C26736D6CE512009858BCDA")

    public static final int NI_NUMERICHOST = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.359 -0400", hash_original_field = "435EA7DC5338264D0367481ACC19F566", hash_generated_field = "A7C6F62221721A70A40E17E223931831")

    public static final int NI_NUMERICSERV = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.359 -0400", hash_original_field = "193ECA592F418C52F03AE0F7DDA88EF7", hash_generated_field = "7AC150A7D9714A0EBA345B2E2FE040E2")

    public static final int O_ACCMODE = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.359 -0400", hash_original_field = "0D8EA63CADEFC0A64C4D55C31B82E713", hash_generated_field = "E8EF2A3D214DF3828EC96142B05ADF37")

    public static final int O_APPEND = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.359 -0400", hash_original_field = "B448DA6A1AC1E7A0BFCD6AB11BB600B5", hash_generated_field = "BDDA222BDF6523E9C288823A2D72F572")

    public static final int O_CREAT = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.359 -0400", hash_original_field = "C38A976118971D9BB2F04EFF4FFEDFD7", hash_generated_field = "968F97CF1135F52480E5D0C156550190")

    public static final int O_EXCL = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.359 -0400", hash_original_field = "7905E0AFADC698056FBD46C8E533604F", hash_generated_field = "F93A6911D55F8783755A2C05FACD5709")

    public static final int O_NOCTTY = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.359 -0400", hash_original_field = "D6339350E02DF3F09B0F0FF7AA2A3817", hash_generated_field = "8E7A9AC2A9C67C03F702AB29E0BE1F57")

    public static final int O_NONBLOCK = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.359 -0400", hash_original_field = "D8ECBBEC2CFBD0ABBE7E7AB3653BD72E", hash_generated_field = "B4EAB14DAEB0DAAB19C1DCB48DA2D873")

    public static final int O_RDONLY = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.359 -0400", hash_original_field = "05FB0CFAF3F7A0E9BEF64F8320558245", hash_generated_field = "4891FB68DCC0DF5256B576815F5BFF8F")

    public static final int O_RDWR = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.359 -0400", hash_original_field = "9779C3E02A50BB5621F5A6FB2C803EA6", hash_generated_field = "3EAE4FD8D6495FDFA38BB89DC8251105")

    public static final int O_SYNC = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.359 -0400", hash_original_field = "47E9FB519314C9B5025D29B7B1CF0B69", hash_generated_field = "FB1DB2A24C84177F93C3A3DA3030C979")

    public static final int O_TRUNC = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.359 -0400", hash_original_field = "26DFAD0F3396C4802FC8FC7A1F05E212", hash_generated_field = "86F0E6FBB71637E0DBEA185623AEF870")

    public static final int O_WRONLY = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.359 -0400", hash_original_field = "B7F367D49B43896C5A8249C3A6E4DD3E", hash_generated_field = "017C3CF354A6F61626D35C651596BBC4")

    public static final int POLLERR = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.359 -0400", hash_original_field = "B93810F6F3337A73FEA943D7C396E5C8", hash_generated_field = "CC1FC3CE8EED646764EB9E03066FAF38")

    public static final int POLLHUP = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.359 -0400", hash_original_field = "B69A92BADF6CD73CF246167AEB272F15", hash_generated_field = "F972B6890F5EB213DD48CEDA9084F136")

    public static final int POLLIN = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.359 -0400", hash_original_field = "8D089FAE8A242108C0AEF8DD9E203F3B", hash_generated_field = "301D4B37B3BFF7769F38E357F681FFDB")

    public static final int POLLNVAL = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.359 -0400", hash_original_field = "6DE99E1D5C6406AD9CB62064543B09EC", hash_generated_field = "0B0F76765E709211D476AB62245CFA7F")

    public static final int POLLOUT = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.359 -0400", hash_original_field = "30186F818F830E44F070017A1AC29DD5", hash_generated_field = "EDCDC8E2FADFB58B58738BF2C70DE402")

    public static final int POLLPRI = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.359 -0400", hash_original_field = "716F8CE2FDA977E93A5760DA21912579", hash_generated_field = "27E43571DB4B872EF27196AE1A1AC1F8")

    public static final int POLLRDBAND = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.359 -0400", hash_original_field = "B2BE14EE7A2CA38A34ECA138F7717504", hash_generated_field = "432EAD2F4C36D6C2E67B1BB994183F28")

    public static final int POLLRDNORM = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.359 -0400", hash_original_field = "D098FB1266DD7FFDFDB7BA6D35327344", hash_generated_field = "96B520D71AE43F6FF2AA9D8F29F6D981")

    public static final int POLLWRBAND = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.359 -0400", hash_original_field = "73D56A28C3B398CD1DDD360DAF5BD3F6", hash_generated_field = "2D027FB10D856B8BA04228294C4BFB0B")

    public static final int POLLWRNORM = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.359 -0400", hash_original_field = "E686C7FFD551206495507A4BE2DD661B", hash_generated_field = "889E1EB851A09BDF77CCB7B8A0420B1A")

    public static final int PROT_EXEC = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.359 -0400", hash_original_field = "9417B24DAA582327064D990390D506DA", hash_generated_field = "5C7F6F68C7585C24DAAFCC63589AD4AD")

    public static final int PROT_NONE = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.359 -0400", hash_original_field = "DF0A55CC5EB72EBADB937D96E4670F12", hash_generated_field = "4C1E9576C8AF1250E1DF4FFCA6159AD7")

    public static final int PROT_READ = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.359 -0400", hash_original_field = "F9136BAB92098ED83C7D38103BD99AE5", hash_generated_field = "32627ABA764E3E023346D489FC7E92D4")

    public static final int PROT_WRITE = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.359 -0400", hash_original_field = "FD45A0D1695627ED70FE0769C4DCA7AA", hash_generated_field = "0C6603221507366D632A5DA6B9DB4F13")

    public static final int R_OK = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.359 -0400", hash_original_field = "4950459ACC9238D8F4E41CB4DB1E5D1D", hash_generated_field = "79E58DB67F59FC577C24DFD69112F7E9")

    public static final int SEEK_CUR = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.359 -0400", hash_original_field = "83BB96CE1D545DF71888A0B6119B72BD", hash_generated_field = "8E0FECB3FC885A9CE3A0A464ADD02EBC")

    public static final int SEEK_END = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.359 -0400", hash_original_field = "CD8EC1A88E83317087D0612DE8C1A465", hash_generated_field = "9D2058571C2DF20E361DC7E3F2BA702E")

    public static final int SEEK_SET = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.359 -0400", hash_original_field = "5A0FB26D95EBEC089C1EC26B2CE14713", hash_generated_field = "B6CB3A61DEC9E307E0C717CE061D7DFE")

    public static final int SHUT_RD = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.359 -0400", hash_original_field = "BD4520B761A055500A42F05ED2CD2CBB", hash_generated_field = "1F84E049E79E44A3E3C4F6545A72D62F")

    public static final int SHUT_RDWR = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.359 -0400", hash_original_field = "48DBA6B40AE133AB525EC960C6EAF70F", hash_generated_field = "29D1B457AA7972C35676FF6258A0C30C")

    public static final int SHUT_WR = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.359 -0400", hash_original_field = "A92AF5AC907F0B5D9FB55A07ED75DD9A", hash_generated_field = "746B5A1E180A00F6586097C60894BC10")

    public static final int SIGABRT = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.359 -0400", hash_original_field = "018F91D363F3228E375836A6C4C28BD4", hash_generated_field = "FACE30C17485234FE122F39B8EE322E7")

    public static final int SIGALRM = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.359 -0400", hash_original_field = "C37075960B179D2EFAC30CF89500A1B9", hash_generated_field = "AEAD3C7C7D56ECCB71DDEDD5CAAE9955")

    public static final int SIGBUS = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.359 -0400", hash_original_field = "905F30999D5A29B3A9B15DAA84E58923", hash_generated_field = "013306661DA886F24C5E73042FF0C7FA")

    public static final int SIGCHLD = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.359 -0400", hash_original_field = "F858DDA580AE18DAEBC6FCDB79BFD058", hash_generated_field = "8F74F374475AD972F981094F1186DD36")

    public static final int SIGCONT = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.359 -0400", hash_original_field = "682448CB64F8DF0177F4933AE754ACD3", hash_generated_field = "09BBC1994199DAB401EEA051F2E28DEA")

    public static final int SIGFPE = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.359 -0400", hash_original_field = "CF8D16EA8DAB614CA629F928930B8A4A", hash_generated_field = "D6A071277D27012A2261F76BB4508D46")

    public static final int SIGHUP = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.359 -0400", hash_original_field = "46BC48574F32E7B531EDF4534144A1B2", hash_generated_field = "5DE97BF86D0572C56343F2F7DA74E305")

    public static final int SIGILL = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.359 -0400", hash_original_field = "141CC0639A527EDD3F720AEAFDCA2EB2", hash_generated_field = "5E119A0A79D09F5FE004E999C4420931")

    public static final int SIGINT = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.359 -0400", hash_original_field = "B7DB8540A7A8C7C9EAEC8B281EDDEA93", hash_generated_field = "E5229926C367AD5C10BC0883E695B950")

    public static final int SIGIO = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.359 -0400", hash_original_field = "952B85B15967051541DD33FC9F6FD772", hash_generated_field = "1FC80CD5EC954948747A556206318BC5")

    public static final int SIGKILL = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.359 -0400", hash_original_field = "EE6E80E605E9C7384E6F5825B0DAEF2A", hash_generated_field = "3931F7589C71D6208B5C02D38A3E7B6C")

    public static final int SIGPIPE = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.359 -0400", hash_original_field = "4E1D6064EB95CBAF9DFF00624856D1C0", hash_generated_field = "6B36C46E80781F8DAAA395754ED06C98")

    public static final int SIGPROF = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.360 -0400", hash_original_field = "18CF27A60F4121EBB8009797676961F8", hash_generated_field = "75FD0A02BE7CAE00D49B237BECD74F96")

    public static final int SIGPWR = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.360 -0400", hash_original_field = "ABB0BEF16A4713CEE3665315E908AD14", hash_generated_field = "E9C3C10E0C52BDC7D9687A8BDA6BEC09")

    public static final int SIGQUIT = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.360 -0400", hash_original_field = "3CD31544B4BDFFF9669FD574D4CFF717", hash_generated_field = "E92D58E9E85894C935B1F78E2F4EAD2E")

    public static final int SIGRTMAX = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.360 -0400", hash_original_field = "37C74EE5889439A262107DB657DF5F5A", hash_generated_field = "0F5FFDBB80249B98D3D3B82173983932")

    public static final int SIGRTMIN = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.360 -0400", hash_original_field = "4C09C4F3EF8D287957563A98FCB75CDE", hash_generated_field = "E2C6E8C1EE54D9DAEABF14608D7E6EA9")

    public static final int SIGSEGV = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.360 -0400", hash_original_field = "5E4909207858B796C49451FFC82F9049", hash_generated_field = "BC3B1FE8458771D70544FE9553042F02")

    public static final int SIGSTKFLT = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.360 -0400", hash_original_field = "41464686BBC7913D4E4AC913B378A63D", hash_generated_field = "8C0E3A0E18BFA46DE1037BE2C89A3E53")

    public static final int SIGSTOP = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.360 -0400", hash_original_field = "386155216CEA4F64EEF845AADC38F1B9", hash_generated_field = "E514C19DBBD93723644D7A40CE3EF04F")

    public static final int SIGSYS = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.360 -0400", hash_original_field = "C783A7AB8DEBFC5F2616935A0A8C3FB1", hash_generated_field = "63295413F48976D7274E6060D478917E")

    public static final int SIGTERM = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.360 -0400", hash_original_field = "C7A65D168A2DD244FC1E5509CFE16674", hash_generated_field = "489B39F7344D6341424A087F4EA882EB")

    public static final int SIGTRAP = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.360 -0400", hash_original_field = "EF5E1F33E9757238B9A6FF6E68D27363", hash_generated_field = "4E3CFF5B32EBABD18294BA20F93BAD18")

    public static final int SIGTSTP = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.360 -0400", hash_original_field = "88FD2B7694E0AD698C20574CB3C0E5D9", hash_generated_field = "D049A731D17B6FC31AC09B5B80B39C65")

    public static final int SIGTTIN = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.360 -0400", hash_original_field = "FE1F648878929027B80374584CAABDB6", hash_generated_field = "4203579CE8117E3B9ACAEEFAF1644328")

    public static final int SIGTTOU = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.360 -0400", hash_original_field = "B5441597F50874B6A139F6CCD6D4A823", hash_generated_field = "043D9B6967ECF51480349622549EDA91")

    public static final int SIGURG = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.360 -0400", hash_original_field = "92D3CCDCD59A69BB6EAA31F3C20DA000", hash_generated_field = "15D0A439D1CC0039AA5E73338D05A983")

    public static final int SIGUSR1 = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.360 -0400", hash_original_field = "645B6962DD25A3DE1DAD3EE3D9972AA9", hash_generated_field = "C71ECF59100024221C9C9B47F39DD45C")

    public static final int SIGUSR2 = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.360 -0400", hash_original_field = "C0B4B03A5F21B3E5D295E77B58E47708", hash_generated_field = "2206B4A337B2C2E39A313A23A61B7267")

    public static final int SIGVTALRM = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.360 -0400", hash_original_field = "038818DEC1D4670849D621ED326A61D2", hash_generated_field = "1F015EAB5E0106AC5364B64CBCC65E48")

    public static final int SIGWINCH = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.360 -0400", hash_original_field = "F360CB9BD319D63A5187E7ECEB21A575", hash_generated_field = "D432054D1483B893E25C7FF6654E1F8B")

    public static final int SIGXCPU = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.360 -0400", hash_original_field = "9663C9C422F001C7FD29CF735C1CE05F", hash_generated_field = "A87AA86D19AFC407289AB86335AEFB0E")

    public static final int SIGXFSZ = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.360 -0400", hash_original_field = "8A1B99DFB96BD92426FD3A32CEE9892D", hash_generated_field = "450F72CDBE76F73E2442FDFEE787D45B")

    public static final int SIOCGIFADDR = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.360 -0400", hash_original_field = "B8CBA8F8736B18B3ED70BA4FDCE8F659", hash_generated_field = "6778A3443F4274A02016E6F76EDAF05B")

    public static final int SIOCGIFBRDADDR = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.360 -0400", hash_original_field = "B4B3E699CB192E87A5BD978DBC8432ED", hash_generated_field = "280152DB9DB05147D7BF23DAA43AB6BA")

    public static final int SIOCGIFDSTADDR = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.360 -0400", hash_original_field = "0B86BB950CC71B7A18923298B15C4F58", hash_generated_field = "10B29492A789E336F544240598F49D4E")

    public static final int SIOCGIFNETMASK = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.360 -0400", hash_original_field = "1213906F9AF52974C84ACD48262BE573", hash_generated_field = "E2CDF6A6FCA2B4B0F617EB95250A9681")

    public static final int SOCK_DGRAM = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.360 -0400", hash_original_field = "87CDB52C1A1A7BFC764D9DA0141DBA18", hash_generated_field = "9FB7AEB5EEABED7238334CFEB1616688")

    public static final int SOCK_RAW = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.360 -0400", hash_original_field = "E350DA6D849D7FD0C226A69369748254", hash_generated_field = "49FF1E80396D3AE9DF4A3289A8AD5575")

    public static final int SOCK_SEQPACKET = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.360 -0400", hash_original_field = "46AC8D707752E9592433C200BBB99DFB", hash_generated_field = "7C1123953BE07B0B1023B9E02A827943")

    public static final int SOCK_STREAM = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.360 -0400", hash_original_field = "7BF20AA931CD44EBC6E68687B12762BE", hash_generated_field = "D149A93C04275EA543360043298EA3C1")

    public static final int SOL_SOCKET = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.360 -0400", hash_original_field = "B9681B78B1D6D7F56A314F53D8A63638", hash_generated_field = "5B01A66CA30EC3F41C84C705BCE7F87D")

    public static final int SO_BINDTODEVICE = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.360 -0400", hash_original_field = "857ACC632F089A912125FBFFEC5A082B", hash_generated_field = "FA3F71842B86F14524256FA4C607CCA7")

    public static final int SO_BROADCAST = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.360 -0400", hash_original_field = "B17069A50FE54F2533349C18E5B4B84D", hash_generated_field = "084AAE80155041E8CF0E191FBDAE0911")

    public static final int SO_DEBUG = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.360 -0400", hash_original_field = "B31C7FFB687A0780E1CE520C995A72A7", hash_generated_field = "A7B278568E89AA2CFE85CDC038809220")

    public static final int SO_DONTROUTE = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.360 -0400", hash_original_field = "CDD6024658F5C7DF6BFA7FDBF9B8B4B7", hash_generated_field = "F70217148E25E32529359AF360CCD1A2")

    public static final int SO_ERROR = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.360 -0400", hash_original_field = "FDE5BFB1FB45DF7F296BB599BCC3A133", hash_generated_field = "E55EBABF4A034B53C14D27DBA229DEEC")

    public static final int SO_KEEPALIVE = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.360 -0400", hash_original_field = "DF03A45AE601241CD6571217DE9A42DD", hash_generated_field = "43E93A407ED81BA897DC5CA73AE40D97")

    public static final int SO_LINGER = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.360 -0400", hash_original_field = "3D49F44975BA3D1D14D1AA09EC7E4245", hash_generated_field = "388505A27CA6726A10A27C729718730F")

    public static final int SO_OOBINLINE = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.360 -0400", hash_original_field = "6CD5DA8ABF5BB921517018244BAE721D", hash_generated_field = "A3890C79CE0CBCEECF3F16F7078462D0")

    public static final int SO_RCVBUF = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.360 -0400", hash_original_field = "9004D004DFF64243B7F11BE426792F7C", hash_generated_field = "C165F3080C4290878A95CE728DB897B1")

    public static final int SO_RCVLOWAT = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.360 -0400", hash_original_field = "E0DBC2AEB4CB8F05B05862F86FCE6978", hash_generated_field = "74190089637D2DE7A8901FF88D136372")

    public static final int SO_RCVTIMEO = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.360 -0400", hash_original_field = "38298FEF67DB11521CEF496104B4064A", hash_generated_field = "6BAC57C7FD2EDD69FA7716D925DADB2C")

    public static final int SO_REUSEADDR = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.360 -0400", hash_original_field = "A45C4AB5126D1850346CF7DE7BC782E7", hash_generated_field = "9CEE5403A55361EF20F5C4E5E89F41A6")

    public static final int SO_SNDBUF = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.360 -0400", hash_original_field = "ED64B454B34E302AAE1C206806E906A8", hash_generated_field = "ACD5499796869F66B8705D3451907320")

    public static final int SO_SNDLOWAT = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.360 -0400", hash_original_field = "D052C4E8C7812C17951E45DBF96C8B41", hash_generated_field = "EB1594F3D5580360086AF83EFAB6ED87")

    public static final int SO_SNDTIMEO = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.360 -0400", hash_original_field = "06B3333991CA5B96F3C97F4D63E38E75", hash_generated_field = "C0FF7E1F41DFE872A824709D1A6EFC86")

    public static final int SO_TYPE = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.360 -0400", hash_original_field = "72464C5FE408D653F92682E01FD7E742", hash_generated_field = "FF0F5ED00D6CBFF54651EB51BBC5F4B6")

    public static final int STDERR_FILENO = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.360 -0400", hash_original_field = "BAE7F8A3365F699C03723823DDAF07FD", hash_generated_field = "79ACFAB0E10F5AC107F593B927C5BD64")

    public static final int STDIN_FILENO = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.360 -0400", hash_original_field = "704171C492E14CD724B62C2FFBD9FAD6", hash_generated_field = "1CD52DEF7F9702893F785C54636531F1")

    public static final int STDOUT_FILENO = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.360 -0400", hash_original_field = "4FE31FB459A519708ED0F1A2A3DDBC14", hash_generated_field = "02B7A908A96065B0C0327A3A5248B169")

    public static final int S_IFBLK = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.360 -0400", hash_original_field = "9146200B86632F5CC4C6D4AEDDA93775", hash_generated_field = "6A5E02A72DB10CD6040A5299A2B9C63C")

    public static final int S_IFCHR = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.360 -0400", hash_original_field = "6E330C0C5825DDC338EE3ABD437CDB0C", hash_generated_field = "05BC1EF3EA6E0907408BB2210DF2CF94")

    public static final int S_IFDIR = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.360 -0400", hash_original_field = "F015B58FC00D6D229D075B27EEC5513A", hash_generated_field = "214256029D80CDEC7963686EF0C35D6D")

    public static final int S_IFIFO = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.360 -0400", hash_original_field = "852C0F07136356020A92E70A33C64ED8", hash_generated_field = "9CBCB2F0BB2698DCC0BC6AD176419721")

    public static final int S_IFLNK = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.361 -0400", hash_original_field = "DFB871ADA7FCDD825597ADF0630ADB14", hash_generated_field = "BC649F4F22F4B80E25916AC88AD84206")

    public static final int S_IFMT = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.361 -0400", hash_original_field = "C7B4B515B1A3028D130F31693335ED75", hash_generated_field = "7A29EEB02CC8F91E82768CB81EFE5A5F")

    public static final int S_IFREG = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.361 -0400", hash_original_field = "2F6C0FF8C774853215CA4C8246159E6A", hash_generated_field = "1600B1A2F5315FFDBD9B36DA8CFAC9D9")

    public static final int S_IFSOCK = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.361 -0400", hash_original_field = "A1D300117CF449F460FF3DF59BB5B6BC", hash_generated_field = "AEB520E5D0F321DF8C61064FB6FD791D")

    public static final int S_IRGRP = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.361 -0400", hash_original_field = "692DAB49B72193C6529EF06DD786F8C0", hash_generated_field = "17B5E5640F3001E91E66494DCED5EAA4")

    public static final int S_IROTH = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.361 -0400", hash_original_field = "C736CC739C84D7D1BEC5622E55E0B85F", hash_generated_field = "AB38923619CDE96D446C44816724BCBC")

    public static final int S_IRUSR = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.361 -0400", hash_original_field = "8C24E54BB2C0395A5B6BF8B927E3E6E8", hash_generated_field = "4BE2155C101F635F640E29B5242986F6")

    public static final int S_IRWXG = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.361 -0400", hash_original_field = "7E738A4B788AA106A575B0DD67D22C60", hash_generated_field = "7E350F5065D81F6066A1FE77AF2D21FB")

    public static final int S_IRWXO = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.361 -0400", hash_original_field = "8A911B05C3F2015C0D1881F2A3783ED9", hash_generated_field = "B86B87F468F5B3C5ECC9C7FCE484CF05")

    public static final int S_IRWXU = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.361 -0400", hash_original_field = "9DE2579F7C20760CD8E60970E3AD3861", hash_generated_field = "DFF291F57A21580A1F24A501B705B9EB")

    public static final int S_ISGID = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.361 -0400", hash_original_field = "F5DDE599A6D5846955895A3C5A338821", hash_generated_field = "B3616A0E0DFA11011C2CC9E9E4A21525")

    public static final int S_ISUID = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.361 -0400", hash_original_field = "3843C6814CE9B6E6332EDD7C1CFB2C0B", hash_generated_field = "E397F80C08E6AFE4AFF0290DC3C1F76C")

    public static final int S_ISVTX = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.361 -0400", hash_original_field = "D5264438738B7C34F042192E448E0287", hash_generated_field = "0054B944ACDB1AE712242975A4ACC41D")

    public static final int S_IWGRP = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.361 -0400", hash_original_field = "013D40DCB0F899BB1F50FC5A33BE596F", hash_generated_field = "530EA0D1F1CAD1F27426E48707EDFB86")

    public static final int S_IWOTH = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.361 -0400", hash_original_field = "10C435C8628C2B450CCF508616A42FD6", hash_generated_field = "E788EFE1E421A339C8DC302071377D43")

    public static final int S_IWUSR = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.361 -0400", hash_original_field = "BFDB4E880C41BCAAE52066AAB8D20DC4", hash_generated_field = "1D89C719C87CB1319F343238B485AE60")

    public static final int S_IXGRP = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.361 -0400", hash_original_field = "8450409C5C45826CFE891BF2E63EF03D", hash_generated_field = "89912B13A29B51B7D20E4D031EAC493D")

    public static final int S_IXOTH = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.361 -0400", hash_original_field = "1A0E8E127F797CBDEA3D53AA41AFF2F7", hash_generated_field = "E3397EDF5EDA1EAB9A884344C88AE722")

    public static final int S_IXUSR = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.361 -0400", hash_original_field = "7D86A90C12CD0D4DCE6247E3C7EAC50D", hash_generated_field = "49DCB8EF216AF67E138A17628DD076F6")

    public static final int TCP_NODELAY = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.361 -0400", hash_original_field = "5AD508EA929033F77297AB2650F2032E", hash_generated_field = "B346A1B2A2B494B098058BBA1AEA85EC")

    public static final int WCONTINUED = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.361 -0400", hash_original_field = "6FFDB66F4933F69851822480FFFF647D", hash_generated_field = "E4F0B57D2766D4E8E36588D050EE32B3")

    public static final int WEXITED = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.361 -0400", hash_original_field = "691C5F63F33B753EB31F3EAEF30DC9A6", hash_generated_field = "734C75AC7EEF9F0AAA35014ECBF37981")

    public static final int WNOHANG = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.361 -0400", hash_original_field = "DABC566C028B65649A6A76D5BA23651B", hash_generated_field = "5E1BFA6531DD6198ADBCBC758B7CC9D3")

    public static final int WNOWAIT = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.361 -0400", hash_original_field = "54EC0B14AC87C62B8689AFD20F546898", hash_generated_field = "DD9DC76FEB5FAF019C91712649120B99")

    public static final int WSTOPPED = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.361 -0400", hash_original_field = "DBCB773C819DFBE538623DFBB4A74CD3", hash_generated_field = "30B965E407E40CA7B6C4E91DDF6B6675")

    public static final int WUNTRACED = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.361 -0400", hash_original_field = "95285E7D03B7ABB2FAADF7B8D1A30277", hash_generated_field = "F992BFA4322B0D8AD3A6BB5BCA09B25C")

    public static final int W_OK = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.361 -0400", hash_original_field = "7FB005C5C3CC0004CC9B618EDDB335DC", hash_generated_field = "519AF21C1DC1083BEAF72D2F2BF01672")

    public static final int X_OK = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.361 -0400", hash_original_field = "640F54EF549B5EC7E46FC7B5372C94D7", hash_generated_field = "DA3610D2195850124EB2F646B2B1E18B")

    public static final int _SC_2_CHAR_TERM = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.361 -0400", hash_original_field = "223CB04487635799C54AAC26588C8B36", hash_generated_field = "A0821DDC05F4BA00E4DE9F7BB80AFB0D")

    public static final int _SC_2_C_BIND = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.361 -0400", hash_original_field = "AFCCAC4B98D09A210FB8804AC69AE205", hash_generated_field = "A2085C68AC35F681596399F0988FCC2B")

    public static final int _SC_2_C_DEV = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.361 -0400", hash_original_field = "008083CA31F8BD8BA50B4764892B6D19", hash_generated_field = "2D2680890C8DB0B204E607A23E57F436")

    public static final int _SC_2_C_VERSION = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.361 -0400", hash_original_field = "1A249B42103F76463256AC7B22F30948", hash_generated_field = "57F764843DE37706AED8B556366979A2")

    public static final int _SC_2_FORT_DEV = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.361 -0400", hash_original_field = "9AEFAB53FF466122F0727D88935D1042", hash_generated_field = "CD714D1FC1C98D62F889A9214A88749B")

    public static final int _SC_2_FORT_RUN = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.361 -0400", hash_original_field = "501663163750D35DAAFEF7CA0B237E5A", hash_generated_field = "8368DDA29169D01EDC2D1357BB5CD881")

    public static final int _SC_2_LOCALEDEF = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.361 -0400", hash_original_field = "69B185D42135A7E5D0087C61F9892A7F", hash_generated_field = "3FC7512068DC26D6A216CA58062AE571")

    public static final int _SC_2_SW_DEV = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.361 -0400", hash_original_field = "7DB9E881FF18479AF45C5970CC64001E", hash_generated_field = "4607BA72A1F2C483635AB40B01647FC3")

    public static final int _SC_2_UPE = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.361 -0400", hash_original_field = "CE7BEA5B58B209BEF4C63D2C4496F68E", hash_generated_field = "E8EC7E26B610E4FA8877BDECF79200C8")

    public static final int _SC_2_VERSION = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.361 -0400", hash_original_field = "3A66E9F98C0E07E8BBB859466BA8BB8C", hash_generated_field = "88848C0A940038190CEC21BD1D87FD5A")

    public static final int _SC_AIO_LISTIO_MAX = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.361 -0400", hash_original_field = "14B0C4B1EC0D2321B52F5D34DD6F588E", hash_generated_field = "20A405B9676BBC3D64C08E53DC734412")

    public static final int _SC_AIO_MAX = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.361 -0400", hash_original_field = "39D0CA623A9FD38A42107817DF04C9E5", hash_generated_field = "720B59B7B0A800AE45296BE6A88AE22F")

    public static final int _SC_AIO_PRIO_DELTA_MAX = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.361 -0400", hash_original_field = "4B910A11C01BAAB0B80684603DD8F5BF", hash_generated_field = "93D18458981161867D4E3995A682D57F")

    public static final int _SC_ARG_MAX = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.361 -0400", hash_original_field = "A9FF52864478446DCAA1C1359DD67405", hash_generated_field = "E33D1EF9D36B6FFDECB6F1B521A1A3C9")

    public static final int _SC_ASYNCHRONOUS_IO = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.361 -0400", hash_original_field = "3993B6AAE0F7E111EB0CD2661EA7F158", hash_generated_field = "6AD62EC8B9581BF1093971A3FB8447F3")

    public static final int _SC_ATEXIT_MAX = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.361 -0400", hash_original_field = "5C81F891A88876304930CAEBD8A9C5E1", hash_generated_field = "8B0122470EB74757384E16127121C72F")

    public static final int _SC_AVPHYS_PAGES = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.361 -0400", hash_original_field = "0BD2CAF09187DE80F127B3C3AC03B568", hash_generated_field = "B70BB94F431F854916249D711C9F79F4")

    public static final int _SC_BC_BASE_MAX = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.361 -0400", hash_original_field = "BB121FF340A0ADF143F3D0A528404329", hash_generated_field = "F998C27C14740569DB6007C216C4D03C")

    public static final int _SC_BC_DIM_MAX = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.361 -0400", hash_original_field = "E5D8EEB7516B8572F0E74AC4C2217ABE", hash_generated_field = "6F81350BF8B4373B760625A543A378A5")

    public static final int _SC_BC_SCALE_MAX = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.361 -0400", hash_original_field = "8D545C010FEE1AFFF651CFA9BCA96E34", hash_generated_field = "52088B92DD6F6E91F33BBB89E196CD4E")

    public static final int _SC_BC_STRING_MAX = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.361 -0400", hash_original_field = "D73260508BF945A1ACE5FC42B46B410F", hash_generated_field = "5C8A0A2887A33B41CDAB706385261796")

    public static final int _SC_CHILD_MAX = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.361 -0400", hash_original_field = "F4158C767685C2DA91863B0BE7CADE85", hash_generated_field = "67AA9E7354115B63D8A3876921104C11")

    public static final int _SC_CLK_TCK = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.361 -0400", hash_original_field = "EC302B34F3BA11D4B323DBAE69C2E59B", hash_generated_field = "B7A075095BD322FFB9E67B43CE0AB93F")

    public static final int _SC_COLL_WEIGHTS_MAX = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.362 -0400", hash_original_field = "B600E8B236A5E00347A97A984DF2E9D4", hash_generated_field = "F376B6C3A0C387413E6F89AC84632448")

    public static final int _SC_DELAYTIMER_MAX = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.362 -0400", hash_original_field = "AAECC306C64EFC07A8F8BE0A4E692DDF", hash_generated_field = "79AF537DFE2AAC2F32B89D4A64A4FA57")

    public static final int _SC_EXPR_NEST_MAX = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.362 -0400", hash_original_field = "C37CBB73CDFA183163E34D6309151427", hash_generated_field = "4BCE52E453B8528C5907E78A9F12A78B")

    public static final int _SC_FSYNC = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.362 -0400", hash_original_field = "C8E9960C63ACB8DA3D94C6E480E55FC8", hash_generated_field = "E0A262A6D449CFB3DBD27AE75C1BD685")

    public static final int _SC_GETGR_R_SIZE_MAX = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.362 -0400", hash_original_field = "21E7072C871E4B5296F77A098178CF9B", hash_generated_field = "FAE2B698F5B490DDD58A5F8A7146EA93")

    public static final int _SC_GETPW_R_SIZE_MAX = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.362 -0400", hash_original_field = "62AD092A59F87143BC7BA38BCAA22161", hash_generated_field = "B091384624D828CF9C5632DDAEFE42BF")

    public static final int _SC_IOV_MAX = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.362 -0400", hash_original_field = "2572D74A2A873AC5391E649EFF33C21C", hash_generated_field = "B2E7F5A239A5887B65D20E55D9D36D58")

    public static final int _SC_JOB_CONTROL = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.362 -0400", hash_original_field = "2A985D4BA385A6376574654825346855", hash_generated_field = "310B239F178DFB49CF8535848FB07407")

    public static final int _SC_LINE_MAX = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.362 -0400", hash_original_field = "11CF5B31ADB984FB5E3F030BEFA57FBA", hash_generated_field = "C0994AD5C3BDB5353EB0BFD2015FFCCF")

    public static final int _SC_LOGIN_NAME_MAX = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.362 -0400", hash_original_field = "E19F1A12ED44D0C217493DE96E8F0BAA", hash_generated_field = "FE4BFDB535F5B9CD3B6DC37B3F65233B")

    public static final int _SC_MAPPED_FILES = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.362 -0400", hash_original_field = "2375B6B5B77EF0282D40F3DE428ABD3F", hash_generated_field = "770BD40AC8B6123FB25E10B7E8BF6282")

    public static final int _SC_MEMLOCK = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.362 -0400", hash_original_field = "12B851C5887C2B2539F2E7B62A49236F", hash_generated_field = "DC23B30B534F185C20B3853DA61A9AED")

    public static final int _SC_MEMLOCK_RANGE = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.362 -0400", hash_original_field = "00EB6A269C4797194813DAEFB8FBA067", hash_generated_field = "958B4DB73FE79D5291BA2E19A31293CB")

    public static final int _SC_MEMORY_PROTECTION = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.362 -0400", hash_original_field = "E72D932757D24BD364F929D3287A8584", hash_generated_field = "FB9F5FAE6F14B8913CAEFA45B933FA38")

    public static final int _SC_MESSAGE_PASSING = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.362 -0400", hash_original_field = "5B4DB35FD142E265C67405AA93DB4200", hash_generated_field = "602B45253D3CBFB7E07228A9349FE1FB")

    public static final int _SC_MQ_OPEN_MAX = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.362 -0400", hash_original_field = "18D5C4C2B8F87675B14C27F9BF21BFEC", hash_generated_field = "AF1FC431372A2E147D9F598A0F08729B")

    public static final int _SC_MQ_PRIO_MAX = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.362 -0400", hash_original_field = "D6E13C935129C480CCC6DD27DF46A255", hash_generated_field = "4BC4513952DED4D717D95D6CFDFD8001")

    public static final int _SC_NGROUPS_MAX = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.362 -0400", hash_original_field = "8EDE24CA14242F3DBC180C4AE3068F31", hash_generated_field = "DAA4A99DCA0BDDFD1576C1B66CE810F1")

    public static final int _SC_NPROCESSORS_CONF = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.362 -0400", hash_original_field = "6D6DFFA59474ECDAC055D234EDDAF38B", hash_generated_field = "E50CC5E0F17B5D932DFD4E3C2C44FB1E")

    public static final int _SC_NPROCESSORS_ONLN = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.362 -0400", hash_original_field = "D9197CF5B07903BF3F10E557AE37A0A1", hash_generated_field = "B31F0284FBBB3AFB0785E73D6865CFCB")

    public static final int _SC_OPEN_MAX = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.362 -0400", hash_original_field = "F11021646731F9D323D7E3A8547003D7", hash_generated_field = "A221B623B582F7B677DBDA3FC2F589B5")

    public static final int _SC_PAGESIZE = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.362 -0400", hash_original_field = "A400FB8BF93FC75D6CFD6AB99714124C", hash_generated_field = "EA42671608B7C20F33162D3F050B7168")

    public static final int _SC_PAGE_SIZE = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.362 -0400", hash_original_field = "6EC627EFB01D79CE5277CABE27BC25B9", hash_generated_field = "5C61833593901C6D386CE1F08714A041")

    public static final int _SC_PASS_MAX = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.362 -0400", hash_original_field = "BA318AC7BD63AFA3709A2C6D7AA194A4", hash_generated_field = "7390D1BA1775AE5E8E315C673759A9BD")

    public static final int _SC_PHYS_PAGES = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.362 -0400", hash_original_field = "B95B232B049C2A6C07068E6D7B6637EF", hash_generated_field = "E94ABFC29E74711B5C29B89B6323D988")

    public static final int _SC_PRIORITIZED_IO = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.362 -0400", hash_original_field = "3586C20B348ED962185021F7C9C95C77", hash_generated_field = "ACCEF4E36F48421728F341407361207C")

    public static final int _SC_PRIORITY_SCHEDULING = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.362 -0400", hash_original_field = "9A2CCEE156D86C3E53C30AD0A8E0322D", hash_generated_field = "FE582064BA7C7A7CD636D1B40E8C7D7B")

    public static final int _SC_REALTIME_SIGNALS = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.362 -0400", hash_original_field = "0B1043646B7AE338D3D5F4E071D77021", hash_generated_field = "CE1F3667FA1B7FCA787A09FDCFDE22FF")

    public static final int _SC_RE_DUP_MAX = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.362 -0400", hash_original_field = "46924A7E39D99D38BBD8D40D58FE8EA1", hash_generated_field = "32C7EDCE4D98FF2CA8F6A9FDB7EE190F")

    public static final int _SC_RTSIG_MAX = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.362 -0400", hash_original_field = "81DA64E4B38E347DE98713757D0EA199", hash_generated_field = "D87B1C5394118FB14370C7760A96932A")

    public static final int _SC_SAVED_IDS = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.362 -0400", hash_original_field = "AE68C37E7E9C909CA511FB685A978849", hash_generated_field = "3ADC405B5C15673008BB69DAA5C5550B")

    public static final int _SC_SEMAPHORES = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.362 -0400", hash_original_field = "F368A40BD1493131F33694592852D4E0", hash_generated_field = "288669ABFB1553960E47E62792E08C3F")

    public static final int _SC_SEM_NSEMS_MAX = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.362 -0400", hash_original_field = "16C327D9CD237E16A1EE55772EE5D6AC", hash_generated_field = "C9D18F74B0C5A5D8CC31897E30D85ED5")

    public static final int _SC_SEM_VALUE_MAX = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.362 -0400", hash_original_field = "D46EDC86AAC463E071AF9BE87C0852B9", hash_generated_field = "894940D99794FE8F5ADDDAFC7C410E30")

    public static final int _SC_SHARED_MEMORY_OBJECTS = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.362 -0400", hash_original_field = "D076C492CE0E8EDC445BEBFD424ADF81", hash_generated_field = "F7FDCB5F6E0A9745CBC8419F8D75255C")

    public static final int _SC_SIGQUEUE_MAX = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.362 -0400", hash_original_field = "320228F1D52A4DAA4F8B8D7D119D8D45", hash_generated_field = "9803CA0AF61BC443ACA8EDE04673B323")

    public static final int _SC_STREAM_MAX = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.362 -0400", hash_original_field = "502173FB3709F221487D05F106435949", hash_generated_field = "1A54E793ABE5811827946E83956334C9")

    public static final int _SC_SYNCHRONIZED_IO = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.362 -0400", hash_original_field = "2026F370059441CEE228BA81618F1695", hash_generated_field = "293F5D061D88CEE6C7A8A6CE0C64D8E4")

    public static final int _SC_THREADS = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.362 -0400", hash_original_field = "E373CAA3AC287DBA6273211F04C72D0B", hash_generated_field = "A06D28FA3C1E6559C2782C9D39C3A0B5")

    public static final int _SC_THREAD_ATTR_STACKADDR = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.362 -0400", hash_original_field = "130440724641CC6F74204286EFBB1ADF", hash_generated_field = "E2A0F7E907E06ABAB5362B77689CCE32")

    public static final int _SC_THREAD_ATTR_STACKSIZE = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.362 -0400", hash_original_field = "25199F9E52969B0BDA9810C90E9C5737", hash_generated_field = "E5F26A7CBC317DFF7DC57B0F8DFD61EB")

    public static final int _SC_THREAD_DESTRUCTOR_ITERATIONS = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.362 -0400", hash_original_field = "4C26E3E7884CAAF8030F2A63340E47D2", hash_generated_field = "34184F57377F7AE2808D6C9AE46080A7")

    public static final int _SC_THREAD_KEYS_MAX = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.362 -0400", hash_original_field = "32A98632F76F4A7B7435B74061C665E5", hash_generated_field = "4E78E78C33614E25392F3E65963E9676")

    public static final int _SC_THREAD_PRIORITY_SCHEDULING = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.362 -0400", hash_original_field = "9F978FE88A6559173A8DB48231BF0883", hash_generated_field = "45BA065E110090B21B4189A7E75E4238")

    public static final int _SC_THREAD_PRIO_INHERIT = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.362 -0400", hash_original_field = "4575BC8B6F247738FF606AC77D33809D", hash_generated_field = "C9C234F36891AB9BB3EFECAE74AA542F")

    public static final int _SC_THREAD_PRIO_PROTECT = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.362 -0400", hash_original_field = "4049D40FEDF0C2D5DB47DF8F38C11912", hash_generated_field = "F020F466EFA48B8769C9E30DE5CD009E")

    public static final int _SC_THREAD_SAFE_FUNCTIONS = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.362 -0400", hash_original_field = "E4ED9D3DE640F67348CF7D23FAFE961E", hash_generated_field = "EFB5148F7EA37E0FA3C001EF1948B22A")

    public static final int _SC_THREAD_STACK_MIN = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.362 -0400", hash_original_field = "42ABB722693A5BAB66D4E85FF71BECAC", hash_generated_field = "E6219C2E25FC002E836BF2A15B6D5E91")

    public static final int _SC_THREAD_THREADS_MAX = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.362 -0400", hash_original_field = "C68C6D5298EDF8147833172AE25DFAC2", hash_generated_field = "D7F8C0A83350BAE1C329FE8048F5C5B7")

    public static final int _SC_TIMERS = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.362 -0400", hash_original_field = "796CD3270ED6A14265C9DAF4741DB263", hash_generated_field = "565BF7615E6860CC213E5B3CF8DEEADB")

    public static final int _SC_TIMER_MAX = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.362 -0400", hash_original_field = "735DA82D994CE0174EF67C1CC5B4BFF0", hash_generated_field = "624272AFB9CC0C4558836B2FD401A0BA")

    public static final int _SC_TTY_NAME_MAX = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.362 -0400", hash_original_field = "CD5FB2B3F8D59CB3D01B992363AE6306", hash_generated_field = "4C45B2CE034A014D4E2B678743F96D23")

    public static final int _SC_TZNAME_MAX = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.363 -0400", hash_original_field = "2A279B1A190C3A69A01EDEF8D15835D4", hash_generated_field = "C3A1CF81581F1C91B2EC6AC3DDF7A3DC")

    public static final int _SC_VERSION = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.363 -0400", hash_original_field = "6AD29714B7788946B31BD849F9B51BA4", hash_generated_field = "7F1187D5BB3C382BB8D6A2CB04215EA8")

    public static final int _SC_XBS5_ILP32_OFF32 = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.363 -0400", hash_original_field = "DBE5BE3599C228C0A0578FD43348D9E9", hash_generated_field = "35656715F6F199D6C2ABA2713B183045")

    public static final int _SC_XBS5_ILP32_OFFBIG = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.363 -0400", hash_original_field = "15262580EFD9B9B8BC308B46AF24891F", hash_generated_field = "C2F5EE9C232131764668DC882E5E1DC2")

    public static final int _SC_XBS5_LP64_OFF64 = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.363 -0400", hash_original_field = "AFE99F5BD83C89D4B71DD8496F455EA8", hash_generated_field = "A20F95ED635815B693F809682D6A152E")

    public static final int _SC_XBS5_LPBIG_OFFBIG = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.363 -0400", hash_original_field = "2D5C53686E20052909A170438E33A8E6", hash_generated_field = "A7F78272D9E2C47492F3B4BF58A12D2B")

    public static final int _SC_XOPEN_CRYPT = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.363 -0400", hash_original_field = "6AB413D00246FE9A739A798DEE07A3FA", hash_generated_field = "2897A20A025EAE966EF9F1572805487D")

    public static final int _SC_XOPEN_ENH_I18N = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.363 -0400", hash_original_field = "A0D927E855F4BD0DCBBB62800A29B847", hash_generated_field = "C028CEE788C15A0E809F0672EC277526")

    public static final int _SC_XOPEN_LEGACY = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.363 -0400", hash_original_field = "45CD2A833F9D581E0FAFFB8956C187B7", hash_generated_field = "32DF52204C4E176806C715F8ED9FBD54")

    public static final int _SC_XOPEN_REALTIME = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.363 -0400", hash_original_field = "CC3E730E8FD70264A4FF5564481A273A", hash_generated_field = "2D61F0626B02A725F8D9924704FC7838")

    public static final int _SC_XOPEN_REALTIME_THREADS = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.363 -0400", hash_original_field = "0ADACCC501D6F2A3A5C9DA1FA015C6C6", hash_generated_field = "C7637E853EB0B990342F5CEC927FA5F8")

    public static final int _SC_XOPEN_SHM = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.363 -0400", hash_original_field = "A9E7F8EF61895572243F5962ACE4452D", hash_generated_field = "91ADF5F6505928D94201526FE19B9591")

    public static final int _SC_XOPEN_UNIX = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.363 -0400", hash_original_field = "F8E361516359FB9FFD1E5581D241BC63", hash_generated_field = "9E3C4414578FC601EB32676A9C74613A")

    public static final int _SC_XOPEN_VERSION = placeholder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:28.363 -0400", hash_original_field = "59CD9E1BF47330056C2DFF8F4F980636", hash_generated_field = "B4FC867314AA4AFC4194C07590CB8E4B")

    public static final int _SC_XOPEN_XCU_VERSION = placeholder();
    static {
        initConstants();
    }
    
}

