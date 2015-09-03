/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 * 
 * 
 * This file incorporates work covered by the following copyright and
 * permission notice:
 *
 * Copyright (C) 2011 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package libcore.io;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public final class OsConstants {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.588 -0500", hash_original_method = "6FBD45B2EC49C3532B2A383542F004C9", hash_generated_method = "BECA4FADD60375FF883204962270EC05")
    
public static boolean S_ISBLK(int mode) { return (mode & S_IFMT) == S_IFBLK; }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.590 -0500", hash_original_method = "75A6C09D50B78A7E066A87C97D7F2C86", hash_generated_method = "3D734EC988B6821896E8350413963FB8")
    
public static boolean S_ISCHR(int mode) { return (mode & S_IFMT) == S_IFCHR; }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.592 -0500", hash_original_method = "27999EF9B355FE00BFD3F19E0247E66F", hash_generated_method = "61123434991B0AAC1C3BFF3DF19AAFB0")
    
public static boolean S_ISDIR(int mode) { return (mode & S_IFMT) == S_IFDIR; }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.594 -0500", hash_original_method = "AEB7632998EE01A4F3281B8657D9E5D3", hash_generated_method = "6266A6BC6CCE89B50A3C7CE69FD0988C")
    
public static boolean S_ISFIFO(int mode) { return (mode & S_IFMT) == S_IFIFO; }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.597 -0500", hash_original_method = "972D3B2E46340018C527E1154F3167D2", hash_generated_method = "4A786707D4D29E2E34822EC4129D9E89")
    
public static boolean S_ISREG(int mode) { return (mode & S_IFMT) == S_IFREG; }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.599 -0500", hash_original_method = "1CF5A4CB88456E82FF9CD0E58E92EACB", hash_generated_method = "8D2B3D09DFDD15BBE5CDACAE72BB2F93")
    
public static boolean S_ISLNK(int mode) { return (mode & S_IFMT) == S_IFLNK; }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.602 -0500", hash_original_method = "693E3BBB558BEACE567A30F01F127355", hash_generated_method = "5A1EBECA633E1265DEEC8AC85C2995BF")
    
public static boolean S_ISSOCK(int mode) { return (mode & S_IFMT) == S_IFSOCK; }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.604 -0500", hash_original_method = "7265A183623C1B7655F66D7720AC9885", hash_generated_method = "3BDFDB45BEC72E773052BDCC88CE7927")
    
public static int WEXITSTATUS(int status) { return (status & 0xff00) >> 8; }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.606 -0500", hash_original_method = "1F545C20977CE91288194D26B79358B2", hash_generated_method = "36E190B2ED8E5DD4195F4FCDB325CB9E")
    
public static boolean WCOREDUMP(int status) { return (status & 0x80) != 0; }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.609 -0500", hash_original_method = "B60BFB6C0F446069236CAE2C76701814", hash_generated_method = "1502042B4E03D36D008575D59271247D")
    
public static int WTERMSIG(int status) { return status & 0x7f; }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.611 -0500", hash_original_method = "F522AEA5FB6766147D1222FB42A28E21", hash_generated_method = "D144AF06888D7BFD86185DA1C260AD3D")
    
public static int WSTOPSIG(int status) { return WEXITSTATUS(status); }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.613 -0500", hash_original_method = "37813A3787992D7DD1D2B70B07491038", hash_generated_method = "B060458B87E21F64E4715EE2AC9A7DDE")
    
public static boolean WIFEXITED(int status) { return (WTERMSIG(status) == 0); }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.616 -0500", hash_original_method = "495761AFADA0822BBC79B1906BC0C77E", hash_generated_method = "ACA2F84F2DE55964FFB8891C12DBB573")
    
public static boolean WIFSTOPPED(int status) { return (WTERMSIG(status) == 0x7f); }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.618 -0500", hash_original_method = "361E3DCA43EB386BBDF0415C21375804", hash_generated_method = "EF47DD3AA9A5D00092FA7AF16054103B")
    
public static boolean WIFSIGNALED(int status) { return (WTERMSIG(status + 1) >= 2); }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.615 -0500", hash_original_method = "CA6E12AB409431E0F71B9735038F5085", hash_generated_method = "7E4EE6CB3518AAB1F86C3F301F109F04")
    
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.620 -0500", hash_original_method = "C99BF098EAFCFD142E84E172974A3402", hash_generated_method = "66D4EAA01242C9F463381EE3DBE8784A")
    
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
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void initConstants() {
    }

    // A hack to avoid these constants being inlined by javac...
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.626 -0500", hash_original_method = "DAE024EA6D6BB39319E6D500BD21C97F", hash_generated_method = "9EC037694603E2A7AF82232FD6D0B452")
    
private static int placeholder() { return 0; }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.620 -0500", hash_original_field = "E7C117905C5ADA6CBC0CC67F7B2495CE", hash_generated_field = "482A5E36885C73AF36D6029A0E1AC644")

    public static final int AF_INET = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.623 -0500", hash_original_field = "D14179F81D108B2F0A78107F5FAE8DE7", hash_generated_field = "39BD1786CD1F2CC6E01242300BDAAFBB")

    public static final int AF_INET6 = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.626 -0500", hash_original_field = "07A3F33A2E70275CA7247483B99CFBDF", hash_generated_field = "ADAD79B76EBAE1BBE2B8333E5E162782")

    public static final int AF_UNIX = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.628 -0500", hash_original_field = "9409EDE4FC58786DC174C9E080A360CF", hash_generated_field = "45F5CFF2BF026E66F99C0293EDEFCB7A")

    public static final int AF_UNSPEC = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.631 -0500", hash_original_field = "C5BB64ECC211288A35D3AE88FA2C8043", hash_generated_field = "1C52FCD3B24444BFE034C8AF859E689B")

    public static final int AI_ADDRCONFIG = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.633 -0500", hash_original_field = "9DF2E12D2396FDA9A87ADA7D2220B8B5", hash_generated_field = "C82227C21D5D464E608B1A6C62133AF9")

    public static final int AI_ALL = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.636 -0500", hash_original_field = "A6D7422E08C1D5AD553659D92AA82880", hash_generated_field = "F33369422BFDA541058C9E47F9ECDCC6")

    public static final int AI_CANONNAME = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.638 -0500", hash_original_field = "0DC0DF9BF82874FD7D3A83717232AA57", hash_generated_field = "DDEA51C9522197098294687D566ADCA0")

    public static final int AI_NUMERICHOST = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.641 -0500", hash_original_field = "C403FF11985E4ECEDF6067154E2498ED", hash_generated_field = "402FC34E275FAEBB5C3B97BEA8B0B4B7")

    public static final int AI_NUMERICSERV = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.643 -0500", hash_original_field = "C15133B355B566A6C8B85E84D5AD86F4", hash_generated_field = "20B96BFB9F0AAC881B8557B30749D6F9")

    public static final int AI_PASSIVE = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.645 -0500", hash_original_field = "3BB2D19E5AE1A00F7254CCFBE0B054FC", hash_generated_field = "D44F0178082D9F00ECA136CDEDB2843F")

    public static final int AI_V4MAPPED = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.648 -0500", hash_original_field = "6F49D6636B72BA22EBE61FB89EC0322D", hash_generated_field = "22779920E7E00F3F97A136F8C5E38C3E")

    public static final int E2BIG = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.651 -0500", hash_original_field = "BE5609B9E187E36687E90895E99C2647", hash_generated_field = "77093667D80E76D4D84711D0B53964FB")

    public static final int EACCES = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.654 -0500", hash_original_field = "B0B5346D8DA307E7589F4CAE5003A1ED", hash_generated_field = "19C3DD77F58178B1681833245D7CA5D1")

    public static final int EADDRINUSE = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.656 -0500", hash_original_field = "92C9C15FFDCB9D9E201C30ABFC7175B3", hash_generated_field = "791D88D3591F827F5DFD1ADB303DEF58")

    public static final int EADDRNOTAVAIL = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.658 -0500", hash_original_field = "477C6771E6E55947DFE442AC046FB349", hash_generated_field = "8DA506488F2A4768734AECDA2FF00987")

    public static final int EAFNOSUPPORT = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.661 -0500", hash_original_field = "76F9D90013940117179B6C084486A0B8", hash_generated_field = "37B47A5025FA649A2B0117FF440E52E6")

    public static final int EAGAIN = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.663 -0500", hash_original_field = "EDF4F398D9A3495C6E0330EC6FBEAA6B", hash_generated_field = "C7D0046F090CDA77AC23440DC64944B9")

    public static final int EAI_AGAIN = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.665 -0500", hash_original_field = "707B8E1266BA5355CBF863E104B3C76D", hash_generated_field = "3074468B14FEDC3DE449F16DE89B02ED")

    public static final int EAI_BADFLAGS = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.668 -0500", hash_original_field = "08FA632BF083059E904AF884A44CBACE", hash_generated_field = "6DAED9157D3933AEF03218488BFDD9A1")

    public static final int EAI_FAIL = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.671 -0500", hash_original_field = "E95958F7F4D36D5E5968794289903D96", hash_generated_field = "0C317FE5F7EF54AF98E5C7E07BCC1D36")

    public static final int EAI_FAMILY = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.673 -0500", hash_original_field = "632F26AA637344640E26FD0329A50BDE", hash_generated_field = "A5140BFCD021392D029FEEFF70CAEE55")

    public static final int EAI_MEMORY = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.675 -0500", hash_original_field = "F5E0286F515098D6413DB3812970A4B4", hash_generated_field = "67157B230287FFEE10EF5B48D280EE08")

    public static final int EAI_NODATA = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.678 -0500", hash_original_field = "43EDDDBE55DDCA0318FB1FAB26D70C98", hash_generated_field = "5754754726002943A6619165239E4220")

    public static final int EAI_NONAME = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.680 -0500", hash_original_field = "F3A98FFC1E0DA9CB88C972D42F50BE56", hash_generated_field = "131C97BC72FB9CE37862E7376A878267")

    public static final int EAI_OVERFLOW = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.682 -0500", hash_original_field = "ACEB5E07D29CA7E895FF0531E32713E1", hash_generated_field = "58880A2C3121A4CD31C8B1091702FD79")

    public static final int EAI_SERVICE = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.685 -0500", hash_original_field = "4DB44DECA2C90FF7F9A4911EFDC2CA1C", hash_generated_field = "BF85A8C5DC1C160F6DFE5E877F5BF333")

    public static final int EAI_SOCKTYPE = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.688 -0500", hash_original_field = "773EE7E89C251A683F0C67D22CA83E6E", hash_generated_field = "E784409C26D50C8CA2CD68FDD59364B8")

    public static final int EAI_SYSTEM = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.690 -0500", hash_original_field = "C7919BC8C21445F338ED0CEAC52DC4A3", hash_generated_field = "A2D944916090E489B8CB8EA81016980E")

    public static final int EALREADY = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.692 -0500", hash_original_field = "A2D9E833434B15BC45964DF7DE289CA5", hash_generated_field = "D98EFFC40CBC020EF6D861094EE7D306")

    public static final int EBADF = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.695 -0500", hash_original_field = "4C720058CF10CC9284464728344454A2", hash_generated_field = "A21ECFCF1EF979F280588D1415B72B25")

    public static final int EBADMSG = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.697 -0500", hash_original_field = "072AA8B71A22E2CE61E754076904C938", hash_generated_field = "BE69CB2EF975808A460615BBB31EB5CE")

    public static final int EBUSY = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.700 -0500", hash_original_field = "394ED9B73204B65289A05B3F2E725C76", hash_generated_field = "0E206F1C8BF2019011FB9251595876C4")

    public static final int ECANCELED = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.702 -0500", hash_original_field = "71134F7210FB6F1F208975E0E52D1173", hash_generated_field = "FF7E957B80537F4A06897A2DCCAA6B69")

    public static final int ECHILD = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.705 -0500", hash_original_field = "34C772F8FBB7338A7EADC2EA3AC3C81A", hash_generated_field = "AB8EDEBEFD48CC3088410F2E9E829489")

    public static final int ECONNABORTED = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.707 -0500", hash_original_field = "639C9F997722D21B487F90B80D309152", hash_generated_field = "E64976B3FC0257AC9D2DDE9D50719FD9")

    public static final int ECONNREFUSED = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.709 -0500", hash_original_field = "9C102F8D2457D65510286594CE41A6D2", hash_generated_field = "A5D0C9B98560240888C5465E121FC313")

    public static final int ECONNRESET = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.712 -0500", hash_original_field = "742199D9B5D2B4BD29735C5E90F39148", hash_generated_field = "9B79F4DABB6079CA455BD918A6ADE4B7")

    public static final int EDEADLK = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.715 -0500", hash_original_field = "36A9A1239EE9A217AB54A8C2EE7A928F", hash_generated_field = "C04D11134AA1160A6A114EA170D656FC")

    public static final int EDESTADDRREQ = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.718 -0500", hash_original_field = "9D3C95CC223A80C8DA0309B43DDD8108", hash_generated_field = "578CA375D3E11BB56601C009C281A1B4")

    public static final int EDOM = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.720 -0500", hash_original_field = "C6DE4D33EB8BB29B5FF888C2D0C5B5CB", hash_generated_field = "D3983260757DE62C83B4CFC7978BC9E1")

    public static final int EDQUOT = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.722 -0500", hash_original_field = "CEDA8D57B6B6A70B4D5C8A4087A6C54F", hash_generated_field = "C49939D05E6D8AE9BA2CF8DE12BC3BBA")

    public static final int EEXIST = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.724 -0500", hash_original_field = "92B774E29FEB3C8A2CCC31F7E1CA479B", hash_generated_field = "1057235BC81E98AAE1C475BAF4619779")

    public static final int EFAULT = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.727 -0500", hash_original_field = "5B50D0AB6668262A577A18BE5AF2D709", hash_generated_field = "FFE428DEA5986574C044B7ABB14D50E4")

    public static final int EFBIG = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.729 -0500", hash_original_field = "F5875AB38D1815081D9CADACBF744E04", hash_generated_field = "0FFC1B5163C6347514BF0C00CA9EB025")

    public static final int EHOSTUNREACH = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.732 -0500", hash_original_field = "43B0B7EEB89F82CEB048522B98F86F20", hash_generated_field = "0B178D01125C38C6C94BC11447D92A07")

    public static final int EIDRM = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.734 -0500", hash_original_field = "62F74635A6319E8069FC44907CE6888D", hash_generated_field = "AFC30674B71C7D670B98A40E6EC8EFE4")

    public static final int EILSEQ = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.737 -0500", hash_original_field = "56B7A9DE2FDF9E6DAD5F99A68D548D67", hash_generated_field = "0E947E199B4D3197FEB8FB3B8D591D74")

    public static final int EINPROGRESS = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.739 -0500", hash_original_field = "32798BED35A204F9C306C99B793047DB", hash_generated_field = "212FEF1F9CA81D2781459976365EB88F")

    public static final int EINTR = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.742 -0500", hash_original_field = "1A7B7150FEED7D0BA8E1B0086860720B", hash_generated_field = "4B8B89FE05533595D9791129FC4D83AB")

    public static final int EINVAL = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.744 -0500", hash_original_field = "990559BB760BC4D5DEBECC03A86DCA63", hash_generated_field = "00AD0A4BBA955959F77644A9E459E076")

    public static final int EIO = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.747 -0500", hash_original_field = "7A40493869879B74B4A9ABEED91989FA", hash_generated_field = "B82D6BF6EB2F0F2F049D77DA995B9758")

    public static final int EISCONN = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.750 -0500", hash_original_field = "1F076F043610EBA4CBE7498245C6C533", hash_generated_field = "556A4A8D62ABD9738A9178140E70CDD2")

    public static final int EISDIR = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.752 -0500", hash_original_field = "8DDCD3EE51A1616AAC72953D831D7CC8", hash_generated_field = "2B03E12BBF4F18DE1A0EFF67A68EF8AE")

    public static final int ELOOP = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.755 -0500", hash_original_field = "444D94BB03C25D31B3641F89026FBC1D", hash_generated_field = "86308CBA7343BC540687AF4AE5875DAD")

    public static final int EMFILE = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.757 -0500", hash_original_field = "53E846F9E83FDAA039915A9D94DAA432", hash_generated_field = "D6F4777D6D2632DC070E43A7FF2B149A")

    public static final int EMLINK = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.759 -0500", hash_original_field = "C542AB0E0A2D6814876A69DC9D7E6296", hash_generated_field = "804245D924876CC06B4887022AFCD422")

    public static final int EMSGSIZE = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.762 -0500", hash_original_field = "D50934847CD8C09AD18A44441F315C8F", hash_generated_field = "DE104EF18FCD11961FF0CC473C19F474")

    public static final int EMULTIHOP = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.764 -0500", hash_original_field = "3F8C4FF26A868C866951B1F303456A76", hash_generated_field = "35D96A09F974660E340931777AD2A861")

    public static final int ENAMETOOLONG = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.767 -0500", hash_original_field = "7CAF138C37B0DAEA6C578BAB498EF48F", hash_generated_field = "1D7AB12661E35C2A40CD50DB39358167")

    public static final int ENETDOWN = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.769 -0500", hash_original_field = "074A4F34D3567D725CF05A09B86D1C6A", hash_generated_field = "4F9068185B48F32A672CCE3EBB295A1B")

    public static final int ENETRESET = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.771 -0500", hash_original_field = "34A8C302B8B4994DB7B49BA9204DCD14", hash_generated_field = "D848BEE0F666121D559C794D84DC1BEE")

    public static final int ENETUNREACH = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.774 -0500", hash_original_field = "C11E7C7F0F98B6E301810F484F79A63B", hash_generated_field = "5BC77D0D67D219E1FCA87876B45BD32C")

    public static final int ENFILE = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.777 -0500", hash_original_field = "495D7ECEE29810443F35C8E5315E2C69", hash_generated_field = "69A301BFBBBD3F1C187EF860381A3A20")

    public static final int ENOBUFS = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.779 -0500", hash_original_field = "B3FE4A51D65F999CFBA38264B6140E6B", hash_generated_field = "509FB735E498DFD6E9437517ED161CE4")

    public static final int ENODATA = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.781 -0500", hash_original_field = "F60A94F36C269A2A47D4773A2DE79BAD", hash_generated_field = "F1655B771EF4863E9D631A9703F7AE43")

    public static final int ENODEV = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.784 -0500", hash_original_field = "78A1D19997609A5093FB7B16CFAC31DB", hash_generated_field = "B0473C9DD3B25D891F6CC451562901BE")

    public static final int ENOENT = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.786 -0500", hash_original_field = "93B1AFDDCF6D154EAE3CA54C5F7F88B7", hash_generated_field = "08BAE88FE5B3B11D4577FD5DA4C885FF")

    public static final int ENOEXEC = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.789 -0500", hash_original_field = "B9288B03E486A7B9F321D000B04DD884", hash_generated_field = "C16A9A9922A5D468229191FD772F56C9")

    public static final int ENOLCK = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.791 -0500", hash_original_field = "BB1C7AB9834DB6D985FF341F3C659C22", hash_generated_field = "A8D367655CFB5285E68AE5C485AE0B07")

    public static final int ENOLINK = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.793 -0500", hash_original_field = "0286FEC2EAFB4FE5E79B21187FE61AB2", hash_generated_field = "03A0B2F9D9248AD1E8CB187130607A45")

    public static final int ENOMEM = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.796 -0500", hash_original_field = "55DF924BF6D9CD2DF412EE5272C0EC27", hash_generated_field = "CBCAFB787711713095226C1F8D8FCC9A")

    public static final int ENOMSG = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.798 -0500", hash_original_field = "8474497DD934C247524870FC5C6A4223", hash_generated_field = "5DE76B95E8AC63E6318539AA95F43253")

    public static final int ENOPROTOOPT = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.801 -0500", hash_original_field = "6C9710570A34B465223D08DA1B667A92", hash_generated_field = "D76A4095ED749FFB6ABB6805816EBE06")

    public static final int ENOSPC = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.803 -0500", hash_original_field = "FA4053F97A7D76839B75B545CF916585", hash_generated_field = "C3F025BFB574899245D089D875687F56")

    public static final int ENOSR = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.806 -0500", hash_original_field = "DCB54838148B3A3E46818A455665B11F", hash_generated_field = "A8D49629EF906A76F942445B77BFC048")

    public static final int ENOSTR = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.808 -0500", hash_original_field = "7AF80E812E8E3E4766FF2F004FB5023B", hash_generated_field = "DA66249BFE97E040FD338FA3106D68D9")

    public static final int ENOSYS = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.811 -0500", hash_original_field = "D8B30C1E197D9A1A4E9F63A40D43A2C2", hash_generated_field = "2A2F3FD44366EB4B33C43E4AD57DEC66")

    public static final int ENOTCONN = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.813 -0500", hash_original_field = "7EAD27665D0F789A1D3892C5E9C07B00", hash_generated_field = "B64A7D37C92D9AB0CF20C430D69B5834")

    public static final int ENOTDIR = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.815 -0500", hash_original_field = "60E42D7DEE1E261DE72753799EF2A791", hash_generated_field = "379FD039078CD401802B98861CD3FFE0")

    public static final int ENOTEMPTY = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.817 -0500", hash_original_field = "3B68EA322217E5E41372323D1F92A9E8", hash_generated_field = "8C4BC080B92428B37AFBD88991EA1E63")

    public static final int ENOTSOCK = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.820 -0500", hash_original_field = "7B00BA7145D3ED2C6B33E020E7A3442A", hash_generated_field = "89F6D72438BD122B606383CDEFBAA43E")

    public static final int ENOTSUP = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.824 -0500", hash_original_field = "ADD988CADC95E8CF1BB79730C4F0E87A", hash_generated_field = "775E7CE22934B82500F869FDABDD7651")

    public static final int ENOTTY = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.826 -0500", hash_original_field = "1541F2147442A72A57D042BF95D2A3E5", hash_generated_field = "0A07C823F2BD082F0893F711A04E720A")

    public static final int ENXIO = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.829 -0500", hash_original_field = "A2A903CBD243A0C042967DFE36802029", hash_generated_field = "1433BD89E3D520625A9B9CBE12429A81")

    public static final int EOPNOTSUPP = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.831 -0500", hash_original_field = "329B216BA4A522018CC74880E6064B5B", hash_generated_field = "BC06ACD6A7E0B073E5707C56CBBC9F2F")

    public static final int EOVERFLOW = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.833 -0500", hash_original_field = "CF8DFB2C96C305C2FE445C677A4B1188", hash_generated_field = "F5232F911C09C309FFB9736ABADFF276")

    public static final int EPERM = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.836 -0500", hash_original_field = "45AB66D21A3101064E2DE1A4B173D811", hash_generated_field = "CB930425A51FE80BB59F9AFFCF884646")

    public static final int EPIPE = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.839 -0500", hash_original_field = "BB5C521467C5898400152DF137BF4CE9", hash_generated_field = "4D6F5FBBB70DEEA2E337D9D3EDF6BF61")

    public static final int EPROTO = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.841 -0500", hash_original_field = "3C99AA355173C353EDA4DDE4F585BF17", hash_generated_field = "DF8EAA47C7CC2A860BCAC729C969D2ED")

    public static final int EPROTONOSUPPORT = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.843 -0500", hash_original_field = "4EF6601104ABDD35A080BB394956C490", hash_generated_field = "BA6AFDE57C408EA7B54C7E266B46C825")

    public static final int EPROTOTYPE = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.845 -0500", hash_original_field = "6C1C93DD68E4BAA346EEFFE941D96C14", hash_generated_field = "1631F87CB74C9337A8A27ECDD5197DE9")

    public static final int ERANGE = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.848 -0500", hash_original_field = "E10205E0A68E876AE4EC95AC93BC5082", hash_generated_field = "5A69469090CC98241FC233E59FDAA249")

    public static final int EROFS = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.850 -0500", hash_original_field = "7F4102D8892BDA7134527BDC84818219", hash_generated_field = "F74794478BAD77F4514AB3F5EC1F1570")

    public static final int ESPIPE = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.853 -0500", hash_original_field = "462AC1BDD56E0CB27A6DC6FCF242C776", hash_generated_field = "991D954ABFB7B07D3501DE8F500BDAD1")

    public static final int ESRCH = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.856 -0500", hash_original_field = "DFEBDD849895801C9A0EAA0249D4E238", hash_generated_field = "A542C0BC47281003A9113C20223885AC")

    public static final int ESTALE = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.859 -0500", hash_original_field = "424D2F7681F0BDE1FA21527B500256BE", hash_generated_field = "14EE79346B4FD42B8E48E6F7221E0CE3")

    public static final int ETIME = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.861 -0500", hash_original_field = "5F50C2D90879A34510B363FEC1A64BAF", hash_generated_field = "680F483052F55F9322BA0DD2E6756EBB")

    public static final int ETIMEDOUT = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.864 -0500", hash_original_field = "0AFC53D25DADB615ECF8E2D02B9B32DE", hash_generated_field = "F5890E29FD67945D8A9FAB0756DED43A")

    public static final int ETXTBSY = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.866 -0500", hash_original_field = "FF2E4439B559B95B914712FF3BA63EDF", hash_generated_field = "7955FF5CE1990F6D985201B5B8504207")

    public static final int EWOULDBLOCK = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.868 -0500", hash_original_field = "CB8F8796426A3C85AA7395A99D526EE8", hash_generated_field = "7863304E29A71F784CFE8BF5724D107F")

    public static final int EXDEV = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.871 -0500", hash_original_field = "CBD660006F574081B1771D347FEDAEA6", hash_generated_field = "5A853747D31FC75F7D19E856810A9956")

    public static final int EXIT_FAILURE = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.873 -0500", hash_original_field = "3DFA96C3B1EFEAEC06C8A6AC62D8DF8F", hash_generated_field = "F2B1FC5EC957C7C6F69E6F16118374A6")

    public static final int EXIT_SUCCESS = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.876 -0500", hash_original_field = "A4C4E0F3B5ECE69FDB540BAC8BFE240C", hash_generated_field = "3DB5AEF69334E62668BD128B2E8B54FD")

    public static final int FD_CLOEXEC = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.878 -0500", hash_original_field = "F3095500E61E8AB17A4DF76963610847", hash_generated_field = "02ED32EEAEF5DBFE84F8A1F9B1B8A7A3")

    public static final int FIONREAD = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.881 -0500", hash_original_field = "09D3F1EB50B9A064A82FDA20E6DC4D77", hash_generated_field = "74F79087DB9C802D2894E51D0C4A0318")

    public static final int F_DUPFD = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.883 -0500", hash_original_field = "0DCFFC526F432AD6B9037604CE462A9D", hash_generated_field = "94C9456FCB1CABFBEBDB4BA3483F4A49")

    public static final int F_GETFD = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.885 -0500", hash_original_field = "C97D829AE029F7BF5D3DEC0DD85AE695", hash_generated_field = "B36CAC664A903E159ADB9D3A9CFB5921")

    public static final int F_GETFL = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.888 -0500", hash_original_field = "879B5313F13C736E95E79C98AD9101D8", hash_generated_field = "D4131E86930A58E28C5282A885660B73")

    public static final int F_GETLK = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.891 -0500", hash_original_field = "EAB68CE7BC7633DEB5168F199F41A818", hash_generated_field = "AE29CB4C7F1D3FAE666A85A7A28E19E9")

    public static final int F_GETLK64 = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.893 -0500", hash_original_field = "9A450AD6DF829FC302BE0A467F69068C", hash_generated_field = "7838B694E5FF8E126F3D0219BC2D8B7B")

    public static final int F_GETOWN = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.896 -0500", hash_original_field = "87A819B7FFE700CBD220230381374212", hash_generated_field = "C9746D16BD4185CCD3F234478D8C9471")

    public static final int F_OK = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.898 -0500", hash_original_field = "2D9FB12B58ED1B2E418047EFF29ED19D", hash_generated_field = "78CD9A3EFB7926AD35E04F26321A7B35")

    public static final int F_RDLCK = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.901 -0500", hash_original_field = "EE8284ACEFA7CE7CF9595AD045A1282D", hash_generated_field = "C77B39B81A7611223C3FB6932D0AB948")

    public static final int F_SETFD = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.903 -0500", hash_original_field = "8E07593CA9DCD597C4466F9548511B7F", hash_generated_field = "ABC37E3ABCC01D099CC689B798E74D2C")

    public static final int F_SETFL = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.906 -0500", hash_original_field = "E81648E3BC5366FC8A9D87C280D0155E", hash_generated_field = "7875A8207CFC80133EAA391C042AB8FB")

    public static final int F_SETLK = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.908 -0500", hash_original_field = "2F38A2CD01C62B8FDFF6CE9C2E97D8C4", hash_generated_field = "74EA9CC7A227689E675D694E70FC7E66")

    public static final int F_SETLK64 = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.911 -0500", hash_original_field = "B8C53F6DC92C120BAF846E93DDF67B41", hash_generated_field = "05F7C1E9B830DE477F75CC1BED13D0F1")

    public static final int F_SETLKW = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.913 -0500", hash_original_field = "148A73DC8C43739C7A4BF52D2C05E636", hash_generated_field = "AC90ED2A211D5B837AE577E134F9872C")

    public static final int F_SETLKW64 = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.915 -0500", hash_original_field = "FABEB856C60275364D673BAA359AD54D", hash_generated_field = "688217BE189CF67981FCFB148A02D135")

    public static final int F_SETOWN = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.918 -0500", hash_original_field = "841F244270BB20A590F01C38B8A50780", hash_generated_field = "3F2AB1519DF6D2D7D759A8145280E81A")

    public static final int F_UNLCK = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.920 -0500", hash_original_field = "2C22019B892CE790E28C2D48D35641E0", hash_generated_field = "84FB8D216EB9826A5056B13629E08B39")

    public static final int F_WRLCK = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.923 -0500", hash_original_field = "F9F3F2143871C50B5CBDF295C5874996", hash_generated_field = "645C10A5468246566CAE543F0A3FA502")

    public static final int IFF_ALLMULTI = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.925 -0500", hash_original_field = "9C3368E71E3E84C4DDC61410EE329192", hash_generated_field = "0C6F17FA9B4397F88191C91DD21BFB1D")

    public static final int IFF_AUTOMEDIA = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.928 -0500", hash_original_field = "B16E538F1A2764B4F9870AA7A165F550", hash_generated_field = "B8083E100257FBC5CCF7483C6B8BB010")

    public static final int IFF_BROADCAST = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.930 -0500", hash_original_field = "C1C6CAA8027F15A9617279FDE2A452B0", hash_generated_field = "79170692775864C2169227426545F5C0")

    public static final int IFF_DEBUG = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.932 -0500", hash_original_field = "DA40363810A8AE7ADB43C128681BDD45", hash_generated_field = "A03CE46A3A864415EF038425B6AEC922")

    public static final int IFF_DYNAMIC = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.935 -0500", hash_original_field = "68B06B4F88DB7646BEFEF47AB08F8CA5", hash_generated_field = "73FAB591909F79F60CA9FC40D6F96706")

    public static final int IFF_LOOPBACK = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.938 -0500", hash_original_field = "AB505711DF50BB51F448449ECB9F5FC9", hash_generated_field = "E3CBD214A8478115E8E5BD63577D11B9")

    public static final int IFF_MASTER = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.940 -0500", hash_original_field = "8AD81379E9912AF80AC7DE3A77AFE111", hash_generated_field = "E6B2D7952B753D4F99805AD56B7231B8")

    public static final int IFF_MULTICAST = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.943 -0500", hash_original_field = "29AD4D246F9C71B13EB3A1C8B4C72F79", hash_generated_field = "B57C73E686305543019AEF6E147C770A")

    public static final int IFF_NOARP = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.945 -0500", hash_original_field = "D04DB99FD9C082189BEF3E2C32C78488", hash_generated_field = "879988EE064A61F40D2BDA0330A0363E")

    public static final int IFF_NOTRAILERS = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.948 -0500", hash_original_field = "59DBF52C0F9259ADA87C1DECED38218F", hash_generated_field = "7A8361EEA005F5C176B9D054EBECD23B")

    public static final int IFF_POINTOPOINT = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.950 -0500", hash_original_field = "1B55DF804C8A770C3E17D77C90A3C3A5", hash_generated_field = "680FCE76F24295022819C7E5FFCA6769")

    public static final int IFF_PORTSEL = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.953 -0500", hash_original_field = "0783285CAEB141576C120769CBFB5442", hash_generated_field = "F4B5118A54E8B36A57901FD29FD024C1")

    public static final int IFF_PROMISC = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.955 -0500", hash_original_field = "A15CB76D55F5B947F88E58B61D408515", hash_generated_field = "6C39957127E5F1C02D02B2B8F84D14BB")

    public static final int IFF_RUNNING = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.958 -0500", hash_original_field = "3FCEC5466C522BE9EA1312FA8726731C", hash_generated_field = "27A77E0AC4239B25087C90700D30A52D")

    public static final int IFF_SLAVE = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.960 -0500", hash_original_field = "2FB874BF21622B1B1BB5480AE246E5CA", hash_generated_field = "0C07466398E428D8D1AEEBC26693D5CE")

    public static final int IFF_UP = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.963 -0500", hash_original_field = "77F7F2A74A7DA60ACB07D1ED0A26C0FF", hash_generated_field = "CA29531C54B20FC77B28C001F3F547F8")

    public static final int IPPROTO_ICMP = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.965 -0500", hash_original_field = "56E5581A65F73C40F43F5665A8E6C440", hash_generated_field = "AC6F903CCEAFD8F87AD98B20C03F293E")

    public static final int IPPROTO_IP = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.968 -0500", hash_original_field = "E6AB4A40723C32A2ECB9E8317FDD36F1", hash_generated_field = "67AAAE0362FE7B1D7F197DA2669BC241")

    public static final int IPPROTO_IPV6 = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.971 -0500", hash_original_field = "2306A9AEF26B4AF661A878E85EB7F37B", hash_generated_field = "BCE6826511D6B2CCE91B0E1E5B9A7223")

    public static final int IPPROTO_RAW = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.973 -0500", hash_original_field = "EFC6FD76F40D93ED0C506471B5B4F0F6", hash_generated_field = "89BA07ECE4307FD0730B852BD735E60D")

    public static final int IPPROTO_TCP = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.976 -0500", hash_original_field = "B79FC15C62BCFD11418C261CB5035771", hash_generated_field = "74C4007D6D5447B05E1C8A6A37498E26")

    public static final int IPPROTO_UDP = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.978 -0500", hash_original_field = "83F09CE522531C02FECF50EAF773DAFD", hash_generated_field = "4944D12E8C6CA68F81D1CC0154735188")

    public static final int IPV6_CHECKSUM = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.980 -0500", hash_original_field = "10E08BFF5D0746DD297BDB39B6376DFD", hash_generated_field = "D6C187C69E9DFD535AB476740F0A5E94")

    public static final int IPV6_MULTICAST_HOPS = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.983 -0500", hash_original_field = "5ADA0DB980C9726C76AED358D43A7F93", hash_generated_field = "4F7FD6AFB19D0FC5D2F31996DA977D61")

    public static final int IPV6_MULTICAST_IF = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.986 -0500", hash_original_field = "9E4C9DDDC20EA6D1D471B417487CC8DC", hash_generated_field = "F6EB27E6C091A3B58C617C44783041D1")

    public static final int IPV6_MULTICAST_LOOP = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.988 -0500", hash_original_field = "8AAC5969BDAD6AF92A47A9D72DD93B38", hash_generated_field = "7BDECCFC9D82051B7CAD89BD30B028E9")

    public static final int IPV6_RECVDSTOPTS = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.991 -0500", hash_original_field = "3688FA0009BA44E37A2F59CA4EE7F532", hash_generated_field = "14AA3D0AC2D9ADEC534FE7C063F1C514")

    public static final int IPV6_RECVHOPLIMIT = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.993 -0500", hash_original_field = "91FDC31B2C4E71EEA502F26DFE830C32", hash_generated_field = "BAD531550680930EEB770177F97377E5")

    public static final int IPV6_RECVHOPOPTS = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.996 -0500", hash_original_field = "9141D054CD8F8A9DBF70060B10CB9CA8", hash_generated_field = "3D7146308FA53F206C599558CDE5DA04")

    public static final int IPV6_RECVPKTINFO = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.998 -0500", hash_original_field = "307169FF6B8CB1677A57A2A26C3F7C96", hash_generated_field = "D9D24899CC28C88D924C47746DBB9DDD")

    public static final int IPV6_RECVRTHDR = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.001 -0500", hash_original_field = "1001E5C16368CF1D7C006E9D08821FEA", hash_generated_field = "4082B672B001CFA1C3834BAF3F0C2E72")

    public static final int IPV6_RECVTCLASS = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.003 -0500", hash_original_field = "76761EC506D995C9AE43AD78E7EB17A5", hash_generated_field = "E5306C188C5B1E1D738750F7BEEF43AD")

    public static final int IPV6_TCLASS = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.006 -0500", hash_original_field = "24F52777BD7A2FDE7A0E7E0C6DDAD2C7", hash_generated_field = "A2C733FA895B3A72661740548C60DFFF")

    public static final int IPV6_UNICAST_HOPS = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.008 -0500", hash_original_field = "17F9017942AB62C1BED50AAB20C72E60", hash_generated_field = "9F2A345456A34CCC52D00EDB60F0F2DD")

    public static final int IPV6_V6ONLY = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.011 -0500", hash_original_field = "37BFDF527FEC2EF70E87AACDECDB1172", hash_generated_field = "D1AB8F455F85FFA7F147ADA083C1762D")

    public static final int IP_MULTICAST_IF = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.013 -0500", hash_original_field = "0149D25FD832A172BAF9CC4C97C9276D", hash_generated_field = "860A2E8190A829ADF9C24765F87BDE63")

    public static final int IP_MULTICAST_LOOP = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.016 -0500", hash_original_field = "DD543EA059A2575C483E60422D96599A", hash_generated_field = "B80624FC025993B1FD570EE2EEE17E88")

    public static final int IP_MULTICAST_TTL = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.018 -0500", hash_original_field = "BF4BE5934B0F6548DF78BDF0C7CA89A4", hash_generated_field = "18D0831A1B845913FA7DDE43EF722CCC")

    public static final int IP_TOS = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.021 -0500", hash_original_field = "82D84935898E484C64B3B23ADE9B0934", hash_generated_field = "6CF9812BD98DE530823FDEBA50CFCA3A")

    public static final int IP_TTL = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.024 -0500", hash_original_field = "6D537F316561855612171BE15BE51DD8", hash_generated_field = "7B11268B63BB847B88D7EDF908672BD0")

    public static final int MAP_FIXED = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.026 -0500", hash_original_field = "EC0B10EFB280EAC552899A86D6DCF6FE", hash_generated_field = "F70BD7A0982600BBA677102790C126D2")

    public static final int MAP_PRIVATE = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.028 -0500", hash_original_field = "3E8A7C62C68D301346A991E1DE403FB0", hash_generated_field = "453C98951EFF51073008EBCBB80BE851")

    public static final int MAP_SHARED = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.031 -0500", hash_original_field = "3852AA8EB67369A57F26DC4F14B85680", hash_generated_field = "B9952D2EEC386D199D4EB5B06950E600")

    public static final int MCAST_JOIN_GROUP = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.033 -0500", hash_original_field = "C18095697F50B1A5D04728308751EA19", hash_generated_field = "3C5C47E390F3ED5BE35389F6E93D10F8")

    public static final int MCAST_LEAVE_GROUP = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.036 -0500", hash_original_field = "E9B585AB39EFC5C899FE0B5F4A15A8C5", hash_generated_field = "A2C9A6D85A9726C2E05F9FBEA8E4DA2E")

    public static final int MCL_CURRENT = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.039 -0500", hash_original_field = "28FBDE554D95179B9E3DCEEEB36048ED", hash_generated_field = "487C0000D97AA9AF43145A3F44E9A00C")

    public static final int MCL_FUTURE = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.041 -0500", hash_original_field = "C115E32DBC34BDE7683C5247393F734A", hash_generated_field = "D51A6DFBE019437E53762CA4FEA6507C")

    public static final int MSG_CTRUNC = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.044 -0500", hash_original_field = "D15422ECCB6B054866B8A568AA7E066E", hash_generated_field = "0FB21ACC2F5E0835F797F5C45FD9943B")

    public static final int MSG_DONTROUTE = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.046 -0500", hash_original_field = "41561DF1F1931BDF470FAF2E19BB5C5A", hash_generated_field = "85F7BB0422429550D172BA06934111D6")

    public static final int MSG_EOR = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.049 -0500", hash_original_field = "FF26FE8A56230C60E430F1C4FD7E1B0F", hash_generated_field = "F6741D411A3FF13F71B2A7F036D756AC")

    public static final int MSG_OOB = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.051 -0500", hash_original_field = "313E398B025D0313B3501BF2781ACF0F", hash_generated_field = "23648134841E62EF43708FBD97EE7AF5")

    public static final int MSG_PEEK = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.054 -0500", hash_original_field = "13D137A98F42D5C6A903070138997957", hash_generated_field = "75D5F74C2246D786136D769EB1E0E191")

    public static final int MSG_TRUNC = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.056 -0500", hash_original_field = "29A10D571E42D9485DDC4CF09F1CF3B7", hash_generated_field = "6681928621750040EC1B0BBD349EA7AE")

    public static final int MSG_WAITALL = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.058 -0500", hash_original_field = "3817E03BDBC27786E5A2A3DF323EF6D5", hash_generated_field = "6CED3FCAF409D23B20ED2732D595FF31")

    public static final int MS_ASYNC = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.061 -0500", hash_original_field = "A973D885799A03EE08A2ACD875498533", hash_generated_field = "BB73C71FDF909698AE7915EC2F6A8881")

    public static final int MS_INVALIDATE = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.063 -0500", hash_original_field = "7F037C5E7A7CD3EF13AEBB753ECEAEB0", hash_generated_field = "AB7F9A8B404F1CFB1DE70EC253C8FE4F")

    public static final int MS_SYNC = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.065 -0500", hash_original_field = "23BFA8CEDB366C8024A2A4C6E7917CEE", hash_generated_field = "B6A981FC25E20E27CE10B6449EF6ED42")

    public static final int NI_DGRAM = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.068 -0500", hash_original_field = "D3C71673B698B82AD94944CB1B874B00", hash_generated_field = "C88D08604C53FC9E81CB22080A5CDAF9")

    public static final int NI_NAMEREQD = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.071 -0500", hash_original_field = "1BDAA7FEB76082A106A6EACBFC1ED452", hash_generated_field = "A997FCD46E8F73448CD385FDCF07210C")

    public static final int NI_NOFQDN = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.073 -0500", hash_original_field = "6C73F5D60E6FABF9269282F07D6F4198", hash_generated_field = "E186ADE02C26736D6CE512009858BCDA")

    public static final int NI_NUMERICHOST = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.076 -0500", hash_original_field = "53D1F54257EC4A44AC107254999E4496", hash_generated_field = "A7C6F62221721A70A40E17E223931831")

    public static final int NI_NUMERICSERV = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.079 -0500", hash_original_field = "016EF851DC287945DE00A8FA9B65A7F8", hash_generated_field = "7AC150A7D9714A0EBA345B2E2FE040E2")

    public static final int O_ACCMODE = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.081 -0500", hash_original_field = "78F121EE9B887B71FC4AC862CF5B0AE6", hash_generated_field = "E8EF2A3D214DF3828EC96142B05ADF37")

    public static final int O_APPEND = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.083 -0500", hash_original_field = "4D3C0E66C5A513C9A1616F7193D201FC", hash_generated_field = "BDDA222BDF6523E9C288823A2D72F572")

    public static final int O_CREAT = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.086 -0500", hash_original_field = "ED1CE6B27F4A6220F49CFE7734783027", hash_generated_field = "968F97CF1135F52480E5D0C156550190")

    public static final int O_EXCL = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.088 -0500", hash_original_field = "F2C26775B84343CC489CEDD5A11D4A68", hash_generated_field = "F93A6911D55F8783755A2C05FACD5709")

    public static final int O_NOCTTY = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.091 -0500", hash_original_field = "7C7659AC681D24AC203BFC404274D7E9", hash_generated_field = "8E7A9AC2A9C67C03F702AB29E0BE1F57")

    public static final int O_NONBLOCK = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.093 -0500", hash_original_field = "C6123548892343890C052EBD76906F8C", hash_generated_field = "B4EAB14DAEB0DAAB19C1DCB48DA2D873")

    public static final int O_RDONLY = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.096 -0500", hash_original_field = "947B1D985C6D399004C78D0F46BF649A", hash_generated_field = "4891FB68DCC0DF5256B576815F5BFF8F")

    public static final int O_RDWR = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.098 -0500", hash_original_field = "A3F56EF9249DDB5D7925399B6436B5BE", hash_generated_field = "3EAE4FD8D6495FDFA38BB89DC8251105")

    public static final int O_SYNC = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.100 -0500", hash_original_field = "74D752E876D5BE5CDD398F327BF99EA8", hash_generated_field = "FB1DB2A24C84177F93C3A3DA3030C979")

    public static final int O_TRUNC = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.103 -0500", hash_original_field = "88EE19AC13A4B6F68510C5E33919AE52", hash_generated_field = "86F0E6FBB71637E0DBEA185623AEF870")

    public static final int O_WRONLY = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.106 -0500", hash_original_field = "1CDFDD2341B993D16A346F1544BFBD04", hash_generated_field = "017C3CF354A6F61626D35C651596BBC4")

    public static final int POLLERR = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.108 -0500", hash_original_field = "91DD49F0768CFB5767ECD8467D3F48C8", hash_generated_field = "CC1FC3CE8EED646764EB9E03066FAF38")

    public static final int POLLHUP = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.111 -0500", hash_original_field = "86BF77C498ECB797CC8671ED550FD102", hash_generated_field = "F972B6890F5EB213DD48CEDA9084F136")

    public static final int POLLIN = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.113 -0500", hash_original_field = "6F16F32EAC23CDFB1F19E8745E4122B8", hash_generated_field = "301D4B37B3BFF7769F38E357F681FFDB")

    public static final int POLLNVAL = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.116 -0500", hash_original_field = "2F38FFBE24DDF586FAFB07E58432D40C", hash_generated_field = "0B0F76765E709211D476AB62245CFA7F")

    public static final int POLLOUT = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.118 -0500", hash_original_field = "48CC8511CFEE9B8C381C6D5305917894", hash_generated_field = "EDCDC8E2FADFB58B58738BF2C70DE402")

    public static final int POLLPRI = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.121 -0500", hash_original_field = "5880E20930A64D1A21B0E6FDFEE6077C", hash_generated_field = "27E43571DB4B872EF27196AE1A1AC1F8")

    public static final int POLLRDBAND = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.123 -0500", hash_original_field = "12A5C453AE3345891A1279627EE9C14D", hash_generated_field = "432EAD2F4C36D6C2E67B1BB994183F28")

    public static final int POLLRDNORM = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.126 -0500", hash_original_field = "A69B50DD39FBD60C146BAC5706E346FA", hash_generated_field = "96B520D71AE43F6FF2AA9D8F29F6D981")

    public static final int POLLWRBAND = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.128 -0500", hash_original_field = "CF78D7CCEB8895E40D6872B7D1F67496", hash_generated_field = "2D027FB10D856B8BA04228294C4BFB0B")

    public static final int POLLWRNORM = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.131 -0500", hash_original_field = "FB51B42DEDB3893EF1F7FBDCE6996D0E", hash_generated_field = "889E1EB851A09BDF77CCB7B8A0420B1A")

    public static final int PROT_EXEC = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.133 -0500", hash_original_field = "297A7E902CC33F4401E0C67159E52BDB", hash_generated_field = "5C7F6F68C7585C24DAAFCC63589AD4AD")

    public static final int PROT_NONE = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.135 -0500", hash_original_field = "253CCA97AB376E830CDD665DAF8ED5FE", hash_generated_field = "4C1E9576C8AF1250E1DF4FFCA6159AD7")

    public static final int PROT_READ = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.138 -0500", hash_original_field = "AB8C9513D51758ED2DC86C84EA497ED1", hash_generated_field = "32627ABA764E3E023346D489FC7E92D4")

    public static final int PROT_WRITE = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.140 -0500", hash_original_field = "0DE3BD8A27F3556677FEBD33F9D24058", hash_generated_field = "0C6603221507366D632A5DA6B9DB4F13")

    public static final int R_OK = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.143 -0500", hash_original_field = "FD468D21D899E1B5874BE9B3FE8C16C9", hash_generated_field = "79E58DB67F59FC577C24DFD69112F7E9")

    public static final int SEEK_CUR = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.145 -0500", hash_original_field = "69127F559AF8459EB6AC08446A3EC05D", hash_generated_field = "8E0FECB3FC885A9CE3A0A464ADD02EBC")

    public static final int SEEK_END = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.148 -0500", hash_original_field = "4E2F782B2ED2F585840DAC5B59C41C81", hash_generated_field = "9D2058571C2DF20E361DC7E3F2BA702E")

    public static final int SEEK_SET = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.151 -0500", hash_original_field = "0F178244FFE5A723A10F05BBA150ABEA", hash_generated_field = "B6CB3A61DEC9E307E0C717CE061D7DFE")

    public static final int SHUT_RD = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.154 -0500", hash_original_field = "49729E566BF7F59A2CB31B0CB7076531", hash_generated_field = "1F84E049E79E44A3E3C4F6545A72D62F")

    public static final int SHUT_RDWR = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.156 -0500", hash_original_field = "7B44F259AE97690BAC6EABC9872E33C9", hash_generated_field = "29D1B457AA7972C35676FF6258A0C30C")

    public static final int SHUT_WR = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.158 -0500", hash_original_field = "855AB1FD185B3B411C0B702CABB508CC", hash_generated_field = "746B5A1E180A00F6586097C60894BC10")

    public static final int SIGABRT = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.160 -0500", hash_original_field = "59AADEE4C4D0E90ED74755C50B6E0542", hash_generated_field = "FACE30C17485234FE122F39B8EE322E7")

    public static final int SIGALRM = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.163 -0500", hash_original_field = "18C207F92304666B0C4DFF6E3846EA3B", hash_generated_field = "AEAD3C7C7D56ECCB71DDEDD5CAAE9955")

    public static final int SIGBUS = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.166 -0500", hash_original_field = "9D7B97AD6EB55970241192B125F07C71", hash_generated_field = "013306661DA886F24C5E73042FF0C7FA")

    public static final int SIGCHLD = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.168 -0500", hash_original_field = "B30FE84FC1D7FD5F8B60E3A821E637B4", hash_generated_field = "8F74F374475AD972F981094F1186DD36")

    public static final int SIGCONT = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.171 -0500", hash_original_field = "66C4999A3D45FF25CB7FD5E9D608EDE2", hash_generated_field = "09BBC1994199DAB401EEA051F2E28DEA")

    public static final int SIGFPE = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.173 -0500", hash_original_field = "CBA90F1400E52D0AF4AE5251293A8287", hash_generated_field = "D6A071277D27012A2261F76BB4508D46")

    public static final int SIGHUP = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.175 -0500", hash_original_field = "9A900BF2D25BC8B674ECB6584A340B79", hash_generated_field = "5DE97BF86D0572C56343F2F7DA74E305")

    public static final int SIGILL = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.178 -0500", hash_original_field = "DF46DDAE0C61CD5F55054A59D2A5E652", hash_generated_field = "5E119A0A79D09F5FE004E999C4420931")

    public static final int SIGINT = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.180 -0500", hash_original_field = "0ABFD16BD239D23E0EFCA82158D71CBF", hash_generated_field = "E5229926C367AD5C10BC0883E695B950")

    public static final int SIGIO = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.183 -0500", hash_original_field = "8C85123291672ED1CFA8D962CE2704A7", hash_generated_field = "1FC80CD5EC954948747A556206318BC5")

    public static final int SIGKILL = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.185 -0500", hash_original_field = "DEC885AF7C0FA7C89DA8966F1FC863E5", hash_generated_field = "3931F7589C71D6208B5C02D38A3E7B6C")

    public static final int SIGPIPE = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.188 -0500", hash_original_field = "29AA5468268934EF5355951CBD020C79", hash_generated_field = "6B36C46E80781F8DAAA395754ED06C98")

    public static final int SIGPROF = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.191 -0500", hash_original_field = "C72244D3035CD2438B59EFBA1DF96660", hash_generated_field = "75FD0A02BE7CAE00D49B237BECD74F96")

    public static final int SIGPWR = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.193 -0500", hash_original_field = "E27C66E01BBF35D0860ADF5840F118C5", hash_generated_field = "E9C3C10E0C52BDC7D9687A8BDA6BEC09")

    public static final int SIGQUIT = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.196 -0500", hash_original_field = "2C51E433B86800C598F4E56575BECBF4", hash_generated_field = "E92D58E9E85894C935B1F78E2F4EAD2E")

    public static final int SIGRTMAX = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.198 -0500", hash_original_field = "F1D7A8460044E1387A2D6CBD373E6F31", hash_generated_field = "0F5FFDBB80249B98D3D3B82173983932")

    public static final int SIGRTMIN = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.200 -0500", hash_original_field = "757BE58ED6CBCBF959F70E30C1F6B365", hash_generated_field = "E2C6E8C1EE54D9DAEABF14608D7E6EA9")

    public static final int SIGSEGV = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.203 -0500", hash_original_field = "DA9012A2735B3A91D6EF45F74DC8C9A0", hash_generated_field = "BC3B1FE8458771D70544FE9553042F02")

    public static final int SIGSTKFLT = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.205 -0500", hash_original_field = "BB1FBFB02063EBA989358A7DB49FE960", hash_generated_field = "8C0E3A0E18BFA46DE1037BE2C89A3E53")

    public static final int SIGSTOP = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.207 -0500", hash_original_field = "10C5D6E94A589B0178A443C87EB1D260", hash_generated_field = "E514C19DBBD93723644D7A40CE3EF04F")

    public static final int SIGSYS = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.210 -0500", hash_original_field = "7C1842FA442F6D265B887462A60A999E", hash_generated_field = "63295413F48976D7274E6060D478917E")

    public static final int SIGTERM = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.212 -0500", hash_original_field = "1F421CD4CCF1EBDE031CE6079B0B6DDF", hash_generated_field = "489B39F7344D6341424A087F4EA882EB")

    public static final int SIGTRAP = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.215 -0500", hash_original_field = "22E2F64EE73055A70B46752C5AB18C33", hash_generated_field = "4E3CFF5B32EBABD18294BA20F93BAD18")

    public static final int SIGTSTP = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.217 -0500", hash_original_field = "DEEF3706D79C66705B7490DEFF3AB915", hash_generated_field = "D049A731D17B6FC31AC09B5B80B39C65")

    public static final int SIGTTIN = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.220 -0500", hash_original_field = "5C87AFCB5C5DAC9BE4E1D98FEE00E68B", hash_generated_field = "4203579CE8117E3B9ACAEEFAF1644328")

    public static final int SIGTTOU = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.222 -0500", hash_original_field = "EC3A0F21FDA3BCDF15D2975E46EA81A3", hash_generated_field = "043D9B6967ECF51480349622549EDA91")

    public static final int SIGURG = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.225 -0500", hash_original_field = "6D71E9056646B07DD5702718C1443AB0", hash_generated_field = "15D0A439D1CC0039AA5E73338D05A983")

    public static final int SIGUSR1 = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.227 -0500", hash_original_field = "EC82F75A1FF2867E18339105E95C3DB7", hash_generated_field = "C71ECF59100024221C9C9B47F39DD45C")

    public static final int SIGUSR2 = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.230 -0500", hash_original_field = "2A0264B4A4D36ADB57F03270CEDB3D2A", hash_generated_field = "2206B4A337B2C2E39A313A23A61B7267")

    public static final int SIGVTALRM = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.232 -0500", hash_original_field = "92CB5AF94FAE14FFF0C82C98A8B33979", hash_generated_field = "1F015EAB5E0106AC5364B64CBCC65E48")

    public static final int SIGWINCH = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.235 -0500", hash_original_field = "F33C173149B2EB588B445E3B2020DF99", hash_generated_field = "D432054D1483B893E25C7FF6654E1F8B")

    public static final int SIGXCPU = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.237 -0500", hash_original_field = "F0D2F53C2F4E36B7C22DFC3694FA7EDA", hash_generated_field = "A87AA86D19AFC407289AB86335AEFB0E")

    public static final int SIGXFSZ = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.240 -0500", hash_original_field = "44EFF5C81D00792A9C98345B5B09549B", hash_generated_field = "450F72CDBE76F73E2442FDFEE787D45B")

    public static final int SIOCGIFADDR = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.243 -0500", hash_original_field = "F941C88FD31327A986D1245A0EDC9582", hash_generated_field = "6778A3443F4274A02016E6F76EDAF05B")

    public static final int SIOCGIFBRDADDR = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.245 -0500", hash_original_field = "18D548FEDC86EF787EDA2AD3D80DF8A9", hash_generated_field = "280152DB9DB05147D7BF23DAA43AB6BA")

    public static final int SIOCGIFDSTADDR = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.247 -0500", hash_original_field = "C013F30A86F3C3C65F7C0A3CF87C3294", hash_generated_field = "10B29492A789E336F544240598F49D4E")

    public static final int SIOCGIFNETMASK = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.250 -0500", hash_original_field = "001662520478FAFD887D483B9814D032", hash_generated_field = "E2CDF6A6FCA2B4B0F617EB95250A9681")

    public static final int SOCK_DGRAM = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.252 -0500", hash_original_field = "55A1CCC96384C0BD044FFA122A962D5A", hash_generated_field = "9FB7AEB5EEABED7238334CFEB1616688")

    public static final int SOCK_RAW = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.254 -0500", hash_original_field = "E60B7109E104741463BB96400392317F", hash_generated_field = "49FF1E80396D3AE9DF4A3289A8AD5575")

    public static final int SOCK_SEQPACKET = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.257 -0500", hash_original_field = "74F46644D37D2823FA1F1BEFA18C4B36", hash_generated_field = "7C1123953BE07B0B1023B9E02A827943")

    public static final int SOCK_STREAM = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.260 -0500", hash_original_field = "AC98E916F6416DC0C38CB99E61FBD9E0", hash_generated_field = "D149A93C04275EA543360043298EA3C1")

    public static final int SOL_SOCKET = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.262 -0500", hash_original_field = "7BE9709FACFF224F8AAC7AED9AE279D5", hash_generated_field = "5B01A66CA30EC3F41C84C705BCE7F87D")

    public static final int SO_BINDTODEVICE = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.265 -0500", hash_original_field = "B5E3ECB7E6A6751140592E3D3001C2C3", hash_generated_field = "FA3F71842B86F14524256FA4C607CCA7")

    public static final int SO_BROADCAST = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.267 -0500", hash_original_field = "DF410F32D458A219A8B117689BA48477", hash_generated_field = "084AAE80155041E8CF0E191FBDAE0911")

    public static final int SO_DEBUG = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.270 -0500", hash_original_field = "A7CCF82238B7B397A12FB601B04FE0B2", hash_generated_field = "A7B278568E89AA2CFE85CDC038809220")

    public static final int SO_DONTROUTE = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.272 -0500", hash_original_field = "444C45EED270E05C0A9C8CA729774407", hash_generated_field = "F70217148E25E32529359AF360CCD1A2")

    public static final int SO_ERROR = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.275 -0500", hash_original_field = "E4D3E848F52BBF39783211E8D698AC79", hash_generated_field = "E55EBABF4A034B53C14D27DBA229DEEC")

    public static final int SO_KEEPALIVE = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.277 -0500", hash_original_field = "8633B98E0FBCCDEC2E65F727700E9620", hash_generated_field = "43E93A407ED81BA897DC5CA73AE40D97")

    public static final int SO_LINGER = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.279 -0500", hash_original_field = "CB09D81466158168078E796BA3A4AAB6", hash_generated_field = "388505A27CA6726A10A27C729718730F")

    public static final int SO_OOBINLINE = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.282 -0500", hash_original_field = "DF8A8918DC848D5947E8EC449640CC9D", hash_generated_field = "A3890C79CE0CBCEECF3F16F7078462D0")

    public static final int SO_RCVBUF = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.284 -0500", hash_original_field = "AA70BF01429D4A9D00938EC3BD0D262C", hash_generated_field = "C165F3080C4290878A95CE728DB897B1")

    public static final int SO_RCVLOWAT = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.287 -0500", hash_original_field = "BB91A766F054FFB789BD59CD09AA0A41", hash_generated_field = "74190089637D2DE7A8901FF88D136372")

    public static final int SO_RCVTIMEO = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.289 -0500", hash_original_field = "46C759D27FF6CFB23D15D38F839D366A", hash_generated_field = "6BAC57C7FD2EDD69FA7716D925DADB2C")

    public static final int SO_REUSEADDR = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.293 -0500", hash_original_field = "832B7AC4A158E3EE50CAED1600197E27", hash_generated_field = "9CEE5403A55361EF20F5C4E5E89F41A6")

    public static final int SO_SNDBUF = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.295 -0500", hash_original_field = "754F08266526CC85DD4D0B84D462B843", hash_generated_field = "ACD5499796869F66B8705D3451907320")

    public static final int SO_SNDLOWAT = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.298 -0500", hash_original_field = "E4BD6E0EFE953D133C9C972CF8A8D45D", hash_generated_field = "EB1594F3D5580360086AF83EFAB6ED87")

    public static final int SO_SNDTIMEO = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.300 -0500", hash_original_field = "FF13A803AEF71D3EEBF1BCCDC2653333", hash_generated_field = "C0FF7E1F41DFE872A824709D1A6EFC86")

    public static final int SO_TYPE = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.302 -0500", hash_original_field = "D61C99FED941117BBD6FF6D9E2ACCB07", hash_generated_field = "FF0F5ED00D6CBFF54651EB51BBC5F4B6")

    public static final int STDERR_FILENO = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.305 -0500", hash_original_field = "F9BCBBC8A1CD2BA015DC47EC6EDF361C", hash_generated_field = "79ACFAB0E10F5AC107F593B927C5BD64")

    public static final int STDIN_FILENO = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.307 -0500", hash_original_field = "3D6DDF044A92D8990D14F4D9BD8DBE22", hash_generated_field = "1CD52DEF7F9702893F785C54636531F1")

    public static final int STDOUT_FILENO = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.310 -0500", hash_original_field = "23867ADE97920F38140F7DCE6E31966B", hash_generated_field = "02B7A908A96065B0C0327A3A5248B169")

    public static final int S_IFBLK = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.312 -0500", hash_original_field = "0FFEDC4AD42AC76FAB8E15B119E41EA0", hash_generated_field = "6A5E02A72DB10CD6040A5299A2B9C63C")

    public static final int S_IFCHR = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.314 -0500", hash_original_field = "3E87500507801CB9F7D7B22166098BED", hash_generated_field = "05BC1EF3EA6E0907408BB2210DF2CF94")

    public static final int S_IFDIR = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.317 -0500", hash_original_field = "F92A559E5805B0265C50B4E65F9C3441", hash_generated_field = "214256029D80CDEC7963686EF0C35D6D")

    public static final int S_IFIFO = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.319 -0500", hash_original_field = "8D2FB0F88F42F60AD606B943284951F1", hash_generated_field = "9CBCB2F0BB2698DCC0BC6AD176419721")

    public static final int S_IFLNK = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.321 -0500", hash_original_field = "325FED63DE4456E49AA9DB308FD90F95", hash_generated_field = "BC649F4F22F4B80E25916AC88AD84206")

    public static final int S_IFMT = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.325 -0500", hash_original_field = "E070103E422E1FE36C66ACD88E005E47", hash_generated_field = "7A29EEB02CC8F91E82768CB81EFE5A5F")

    public static final int S_IFREG = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.327 -0500", hash_original_field = "55296090A2EA11BD094DA1358EC4306F", hash_generated_field = "1600B1A2F5315FFDBD9B36DA8CFAC9D9")

    public static final int S_IFSOCK = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.329 -0500", hash_original_field = "3051F98BFA70909A5F8DDFFF7DACBD55", hash_generated_field = "AEB520E5D0F321DF8C61064FB6FD791D")

    public static final int S_IRGRP = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.332 -0500", hash_original_field = "1F992E1CBA51B227151A35840A4A8A2A", hash_generated_field = "17B5E5640F3001E91E66494DCED5EAA4")

    public static final int S_IROTH = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.334 -0500", hash_original_field = "06B1B69C6CC02B7C8C1EE7E9650D74F4", hash_generated_field = "AB38923619CDE96D446C44816724BCBC")

    public static final int S_IRUSR = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.337 -0500", hash_original_field = "492E6A1AE422A53F2D6BEB794780638F", hash_generated_field = "4BE2155C101F635F640E29B5242986F6")

    public static final int S_IRWXG = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.339 -0500", hash_original_field = "231B33E693C9E6952939896273121DA4", hash_generated_field = "7E350F5065D81F6066A1FE77AF2D21FB")

    public static final int S_IRWXO = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.341 -0500", hash_original_field = "A81323A77CE226660BFDC3E88C916649", hash_generated_field = "B86B87F468F5B3C5ECC9C7FCE484CF05")

    public static final int S_IRWXU = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.345 -0500", hash_original_field = "7938B22E626EFDA38A30E39039400D4A", hash_generated_field = "DFF291F57A21580A1F24A501B705B9EB")

    public static final int S_ISGID = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.347 -0500", hash_original_field = "35713B7A02F1C4D737100886A35625B3", hash_generated_field = "B3616A0E0DFA11011C2CC9E9E4A21525")

    public static final int S_ISUID = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.350 -0500", hash_original_field = "C4261E57C6CFA2F879FD4623AC1BA500", hash_generated_field = "E397F80C08E6AFE4AFF0290DC3C1F76C")

    public static final int S_ISVTX = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.352 -0500", hash_original_field = "78B377C5A51723E332224E44364DA1E5", hash_generated_field = "0054B944ACDB1AE712242975A4ACC41D")

    public static final int S_IWGRP = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.354 -0500", hash_original_field = "FB6BB30B1B37888ADA16EF948D3F67F9", hash_generated_field = "530EA0D1F1CAD1F27426E48707EDFB86")

    public static final int S_IWOTH = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.357 -0500", hash_original_field = "EC384C1573185A25DA370608340E8065", hash_generated_field = "E788EFE1E421A339C8DC302071377D43")

    public static final int S_IWUSR = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.360 -0500", hash_original_field = "44F4457E1A2056D70A6820A218E774E6", hash_generated_field = "1D89C719C87CB1319F343238B485AE60")

    public static final int S_IXGRP = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.362 -0500", hash_original_field = "ED76C4A15DA4B45E242EAC527332F8F5", hash_generated_field = "89912B13A29B51B7D20E4D031EAC493D")

    public static final int S_IXOTH = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.365 -0500", hash_original_field = "6518C76BBA438D7FFE947C34A686646B", hash_generated_field = "E3397EDF5EDA1EAB9A884344C88AE722")

    public static final int S_IXUSR = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.367 -0500", hash_original_field = "0A0DD0784D99B1A7782B6ED620D15400", hash_generated_field = "49DCB8EF216AF67E138A17628DD076F6")

    public static final int TCP_NODELAY = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.369 -0500", hash_original_field = "D2EB2B8488B38BF3E615EA9F93231B4F", hash_generated_field = "B346A1B2A2B494B098058BBA1AEA85EC")

    public static final int WCONTINUED = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.371 -0500", hash_original_field = "DF56E00CE2DA359AEFC97B1C2BE0ECBC", hash_generated_field = "E4F0B57D2766D4E8E36588D050EE32B3")

    public static final int WEXITED = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.374 -0500", hash_original_field = "D32C135E61D3197E5D6D924E4486A435", hash_generated_field = "734C75AC7EEF9F0AAA35014ECBF37981")

    public static final int WNOHANG = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.377 -0500", hash_original_field = "52968A114C50867BDA7274EFE170909D", hash_generated_field = "5E1BFA6531DD6198ADBCBC758B7CC9D3")

    public static final int WNOWAIT = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.379 -0500", hash_original_field = "AE6E74AE8045FA2EDF61F35672DEF1D7", hash_generated_field = "DD9DC76FEB5FAF019C91712649120B99")

    public static final int WSTOPPED = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.382 -0500", hash_original_field = "3E785A181E8540E793EFEEC53E255661", hash_generated_field = "30B965E407E40CA7B6C4E91DDF6B6675")

    public static final int WUNTRACED = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.384 -0500", hash_original_field = "998D80DDF39C6D99BB270A1CE9305184", hash_generated_field = "F992BFA4322B0D8AD3A6BB5BCA09B25C")

    public static final int W_OK = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.387 -0500", hash_original_field = "CDBD85D35A5E3683069A513D77129314", hash_generated_field = "519AF21C1DC1083BEAF72D2F2BF01672")

    public static final int X_OK = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.389 -0500", hash_original_field = "FD7C07C1295801A6EC8EDAAA35AA3279", hash_generated_field = "DA3610D2195850124EB2F646B2B1E18B")

    public static final int _SC_2_CHAR_TERM = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.392 -0500", hash_original_field = "E34031D6D737D5D2C8D76FDC309ADA59", hash_generated_field = "A0821DDC05F4BA00E4DE9F7BB80AFB0D")

    public static final int _SC_2_C_BIND = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.394 -0500", hash_original_field = "4E9F85C07A51E5E1C6E669C59437BFE0", hash_generated_field = "A2085C68AC35F681596399F0988FCC2B")

    public static final int _SC_2_C_DEV = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.397 -0500", hash_original_field = "3C3B7B6BA8407917E2929B885806BA18", hash_generated_field = "2D2680890C8DB0B204E607A23E57F436")

    public static final int _SC_2_C_VERSION = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.400 -0500", hash_original_field = "E49A91F953FF8113C057B2DDCD4504AB", hash_generated_field = "57F764843DE37706AED8B556366979A2")

    public static final int _SC_2_FORT_DEV = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.403 -0500", hash_original_field = "1B11C67B210967F945909BFAC9ECA37E", hash_generated_field = "CD714D1FC1C98D62F889A9214A88749B")

    public static final int _SC_2_FORT_RUN = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.405 -0500", hash_original_field = "FC48FAA3AA666D2875325FA9742F076F", hash_generated_field = "8368DDA29169D01EDC2D1357BB5CD881")

    public static final int _SC_2_LOCALEDEF = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.408 -0500", hash_original_field = "D0C7A5F5A611D92082F83FD8BEA6A691", hash_generated_field = "3FC7512068DC26D6A216CA58062AE571")

    public static final int _SC_2_SW_DEV = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.410 -0500", hash_original_field = "8184587C3C55987FB2BEE6A6C9673E8B", hash_generated_field = "4607BA72A1F2C483635AB40B01647FC3")

    public static final int _SC_2_UPE = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.412 -0500", hash_original_field = "E8866A4E268C3EAA6782B23FB87402DB", hash_generated_field = "E8EC7E26B610E4FA8877BDECF79200C8")

    public static final int _SC_2_VERSION = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.415 -0500", hash_original_field = "CC5F0C0B932D916DF1FE9608E113A056", hash_generated_field = "88848C0A940038190CEC21BD1D87FD5A")

    public static final int _SC_AIO_LISTIO_MAX = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.417 -0500", hash_original_field = "0DFE8B33562AAF15883FA3241576C2CE", hash_generated_field = "20A405B9676BBC3D64C08E53DC734412")

    public static final int _SC_AIO_MAX = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.419 -0500", hash_original_field = "CA001E44B4B124916974488030695E37", hash_generated_field = "720B59B7B0A800AE45296BE6A88AE22F")

    public static final int _SC_AIO_PRIO_DELTA_MAX = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.422 -0500", hash_original_field = "8DD6D601670482C80DA97EED10C9FE9C", hash_generated_field = "93D18458981161867D4E3995A682D57F")

    public static final int _SC_ARG_MAX = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.425 -0500", hash_original_field = "7FA6E9642077B5255F495833C3B253B6", hash_generated_field = "E33D1EF9D36B6FFDECB6F1B521A1A3C9")

    public static final int _SC_ASYNCHRONOUS_IO = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.427 -0500", hash_original_field = "00B4365D0DE9E77A0574E6F670C79D6C", hash_generated_field = "6AD62EC8B9581BF1093971A3FB8447F3")

    public static final int _SC_ATEXIT_MAX = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.430 -0500", hash_original_field = "9758C22BAC0A0FDAF22C0B64924D9BCE", hash_generated_field = "8B0122470EB74757384E16127121C72F")

    public static final int _SC_AVPHYS_PAGES = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.432 -0500", hash_original_field = "CF36122767A5307232E2A533009B9848", hash_generated_field = "B70BB94F431F854916249D711C9F79F4")

    public static final int _SC_BC_BASE_MAX = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.435 -0500", hash_original_field = "8A5FBF0BE9C0A63CD26A4EE11F41F7DB", hash_generated_field = "F998C27C14740569DB6007C216C4D03C")

    public static final int _SC_BC_DIM_MAX = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.437 -0500", hash_original_field = "7F4C1873209657A4AC8D8E2FE8051080", hash_generated_field = "6F81350BF8B4373B760625A543A378A5")

    public static final int _SC_BC_SCALE_MAX = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.439 -0500", hash_original_field = "FFB954215D5AF636100A0439CBDFB070", hash_generated_field = "52088B92DD6F6E91F33BBB89E196CD4E")

    public static final int _SC_BC_STRING_MAX = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.442 -0500", hash_original_field = "3A685880F2BACA67AF7B258A5EB4DDF4", hash_generated_field = "5C8A0A2887A33B41CDAB706385261796")

    public static final int _SC_CHILD_MAX = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.444 -0500", hash_original_field = "DFFB8ABE94C25389592CD38D010625B9", hash_generated_field = "67AA9E7354115B63D8A3876921104C11")

    public static final int _SC_CLK_TCK = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.447 -0500", hash_original_field = "300ACEC367E66783677DE3365F7CF6B1", hash_generated_field = "B7A075095BD322FFB9E67B43CE0AB93F")

    public static final int _SC_COLL_WEIGHTS_MAX = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.450 -0500", hash_original_field = "3A4E91CD0E08CE33FDE06213B2699911", hash_generated_field = "F376B6C3A0C387413E6F89AC84632448")

    public static final int _SC_DELAYTIMER_MAX = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.453 -0500", hash_original_field = "AF866CF0B3E509BBB24FA95C58CD47A5", hash_generated_field = "79AF537DFE2AAC2F32B89D4A64A4FA57")

    public static final int _SC_EXPR_NEST_MAX = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.455 -0500", hash_original_field = "481A685B5AD07EE3A8F5F6DF97C4C9BA", hash_generated_field = "4BCE52E453B8528C5907E78A9F12A78B")

    public static final int _SC_FSYNC = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.457 -0500", hash_original_field = "68817C2B59252D5A47D63B66D3650F14", hash_generated_field = "E0A262A6D449CFB3DBD27AE75C1BD685")

    public static final int _SC_GETGR_R_SIZE_MAX = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.460 -0500", hash_original_field = "B9E0D4C01ECD3A903E1E681C5C2F678E", hash_generated_field = "FAE2B698F5B490DDD58A5F8A7146EA93")

    public static final int _SC_GETPW_R_SIZE_MAX = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.462 -0500", hash_original_field = "4BB24B954A6CB727418B37AC96770D4B", hash_generated_field = "B091384624D828CF9C5632DDAEFE42BF")

    public static final int _SC_IOV_MAX = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.464 -0500", hash_original_field = "7F66183169C99EBC5DD19053C3E51B64", hash_generated_field = "B2E7F5A239A5887B65D20E55D9D36D58")

    public static final int _SC_JOB_CONTROL = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.467 -0500", hash_original_field = "01DA25B943FDB6C787E7E12E05EAF9C3", hash_generated_field = "310B239F178DFB49CF8535848FB07407")

    public static final int _SC_LINE_MAX = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.470 -0500", hash_original_field = "FEE442C10F81021556977D2105597E9F", hash_generated_field = "C0994AD5C3BDB5353EB0BFD2015FFCCF")

    public static final int _SC_LOGIN_NAME_MAX = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.472 -0500", hash_original_field = "BA87C458D93CE2F961CE107D2E227930", hash_generated_field = "FE4BFDB535F5B9CD3B6DC37B3F65233B")

    public static final int _SC_MAPPED_FILES = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.475 -0500", hash_original_field = "4BB66BC3D90DC1DDC1E74C63B9F02ECE", hash_generated_field = "770BD40AC8B6123FB25E10B7E8BF6282")

    public static final int _SC_MEMLOCK = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.477 -0500", hash_original_field = "9B7344AA0BEF6A95F131B0D5AB1FA6A9", hash_generated_field = "DC23B30B534F185C20B3853DA61A9AED")

    public static final int _SC_MEMLOCK_RANGE = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.480 -0500", hash_original_field = "F785A2E59FACE38AD8B947D31998D0D6", hash_generated_field = "958B4DB73FE79D5291BA2E19A31293CB")

    public static final int _SC_MEMORY_PROTECTION = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.483 -0500", hash_original_field = "C847E7644E5689870F2B0DD9FE64DA8F", hash_generated_field = "FB9F5FAE6F14B8913CAEFA45B933FA38")

    public static final int _SC_MESSAGE_PASSING = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.485 -0500", hash_original_field = "FF432231C0C58C666173CC2C0F59F088", hash_generated_field = "602B45253D3CBFB7E07228A9349FE1FB")

    public static final int _SC_MQ_OPEN_MAX = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.488 -0500", hash_original_field = "6FEA02CFEA2CA22099E2D8234D3F554A", hash_generated_field = "AF1FC431372A2E147D9F598A0F08729B")

    public static final int _SC_MQ_PRIO_MAX = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.490 -0500", hash_original_field = "F7FECC74BCB8F0BB01D78B0FD974D8B5", hash_generated_field = "4BC4513952DED4D717D95D6CFDFD8001")

    public static final int _SC_NGROUPS_MAX = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.492 -0500", hash_original_field = "132BA849266B63A5278F954E1F2608D8", hash_generated_field = "DAA4A99DCA0BDDFD1576C1B66CE810F1")

    public static final int _SC_NPROCESSORS_CONF = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.495 -0500", hash_original_field = "AF802FA8F259F98F16B62074BD0F7C64", hash_generated_field = "E50CC5E0F17B5D932DFD4E3C2C44FB1E")

    public static final int _SC_NPROCESSORS_ONLN = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.497 -0500", hash_original_field = "9F497CA61F660A887A0AE8F5BD4A5F48", hash_generated_field = "B31F0284FBBB3AFB0785E73D6865CFCB")

    public static final int _SC_OPEN_MAX = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.500 -0500", hash_original_field = "78005B0E14D246DF53926C108DC0472C", hash_generated_field = "A221B623B582F7B677DBDA3FC2F589B5")

    public static final int _SC_PAGESIZE = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.502 -0500", hash_original_field = "2D4F267B471DAF5EA4C896410FB6BE81", hash_generated_field = "EA42671608B7C20F33162D3F050B7168")

    public static final int _SC_PAGE_SIZE = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.504 -0500", hash_original_field = "674C94B2230DE20209E3BA6F5EB991A6", hash_generated_field = "5C61833593901C6D386CE1F08714A041")

    public static final int _SC_PASS_MAX = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.507 -0500", hash_original_field = "6FAA7F4716100A1E74B831DB8024ED08", hash_generated_field = "7390D1BA1775AE5E8E315C673759A9BD")

    public static final int _SC_PHYS_PAGES = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.509 -0500", hash_original_field = "065AB6D12DB13B0FC94938D97A54872D", hash_generated_field = "E94ABFC29E74711B5C29B89B6323D988")

    public static final int _SC_PRIORITIZED_IO = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.513 -0500", hash_original_field = "16DFFF84F42D2A00CCB8A6EECFA4A7C0", hash_generated_field = "ACCEF4E36F48421728F341407361207C")

    public static final int _SC_PRIORITY_SCHEDULING = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.516 -0500", hash_original_field = "8DD59A3AA28D262C50E76D9B1CD24076", hash_generated_field = "FE582064BA7C7A7CD636D1B40E8C7D7B")

    public static final int _SC_REALTIME_SIGNALS = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.518 -0500", hash_original_field = "C6E65229EF6E45BF2427A5711301F258", hash_generated_field = "CE1F3667FA1B7FCA787A09FDCFDE22FF")

    public static final int _SC_RE_DUP_MAX = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.520 -0500", hash_original_field = "AAB8341A774AB2F97CE098E0008FF1BE", hash_generated_field = "32C7EDCE4D98FF2CA8F6A9FDB7EE190F")

    public static final int _SC_RTSIG_MAX = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.523 -0500", hash_original_field = "F316D4B5F54B16902CF3F8A0E2A5A29A", hash_generated_field = "D87B1C5394118FB14370C7760A96932A")

    public static final int _SC_SAVED_IDS = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.525 -0500", hash_original_field = "AFD086F410F062D4F885A60AC57F4BFF", hash_generated_field = "3ADC405B5C15673008BB69DAA5C5550B")

    public static final int _SC_SEMAPHORES = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.528 -0500", hash_original_field = "B56803D8088268890CC98B966A10AB44", hash_generated_field = "288669ABFB1553960E47E62792E08C3F")

    public static final int _SC_SEM_NSEMS_MAX = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.530 -0500", hash_original_field = "BFCB1D35021BC29B00BD29E2CEF1A0C2", hash_generated_field = "C9D18F74B0C5A5D8CC31897E30D85ED5")

    public static final int _SC_SEM_VALUE_MAX = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.533 -0500", hash_original_field = "C3391B051AF3390E833A950D87CD41CF", hash_generated_field = "894940D99794FE8F5ADDDAFC7C410E30")

    public static final int _SC_SHARED_MEMORY_OBJECTS = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.535 -0500", hash_original_field = "CEFCC6967A9E3C7D170CF5CC5CBED5CB", hash_generated_field = "F7FDCB5F6E0A9745CBC8419F8D75255C")

    public static final int _SC_SIGQUEUE_MAX = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.537 -0500", hash_original_field = "EA9266BE295BF28C749DF773D34B08C3", hash_generated_field = "9803CA0AF61BC443ACA8EDE04673B323")

    public static final int _SC_STREAM_MAX = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.540 -0500", hash_original_field = "1F07B0F11A4FDD21204D0A5D416FDDAF", hash_generated_field = "1A54E793ABE5811827946E83956334C9")

    public static final int _SC_SYNCHRONIZED_IO = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.543 -0500", hash_original_field = "62A9FB8BFDB9C63266AA3DDDD98B4580", hash_generated_field = "293F5D061D88CEE6C7A8A6CE0C64D8E4")

    public static final int _SC_THREADS = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.545 -0500", hash_original_field = "8CCEC587ADA9927F216743F6C530C0B5", hash_generated_field = "A06D28FA3C1E6559C2782C9D39C3A0B5")

    public static final int _SC_THREAD_ATTR_STACKADDR = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.548 -0500", hash_original_field = "69AF66CB7A8398BE38ACA2A8BE4A1AC5", hash_generated_field = "E2A0F7E907E06ABAB5362B77689CCE32")

    public static final int _SC_THREAD_ATTR_STACKSIZE = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.550 -0500", hash_original_field = "47221A424177033E7DAF3BDDE311E387", hash_generated_field = "E5F26A7CBC317DFF7DC57B0F8DFD61EB")

    public static final int _SC_THREAD_DESTRUCTOR_ITERATIONS = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.552 -0500", hash_original_field = "086746B766418CA89F9F96AED344E417", hash_generated_field = "34184F57377F7AE2808D6C9AE46080A7")

    public static final int _SC_THREAD_KEYS_MAX = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.555 -0500", hash_original_field = "EFF0D22C4F23E7C78B0699E649500B1D", hash_generated_field = "4E78E78C33614E25392F3E65963E9676")

    public static final int _SC_THREAD_PRIORITY_SCHEDULING = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.559 -0500", hash_original_field = "A8B4D40CDE52B3DF8240AA35148926B8", hash_generated_field = "45BA065E110090B21B4189A7E75E4238")

    public static final int _SC_THREAD_PRIO_INHERIT = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.561 -0500", hash_original_field = "AF3397B1F1646A8A86DCDCB35E8398D1", hash_generated_field = "C9C234F36891AB9BB3EFECAE74AA542F")

    public static final int _SC_THREAD_PRIO_PROTECT = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.564 -0500", hash_original_field = "3ACAF7F42E0BCF0406E6D0EACD6151BD", hash_generated_field = "F020F466EFA48B8769C9E30DE5CD009E")

    public static final int _SC_THREAD_SAFE_FUNCTIONS = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.566 -0500", hash_original_field = "3CC70F477D93452D4D611EBBA1198259", hash_generated_field = "EFB5148F7EA37E0FA3C001EF1948B22A")

    public static final int _SC_THREAD_STACK_MIN = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.568 -0500", hash_original_field = "0F3B5E55EC18AAF63CB1AAF12B1B7C95", hash_generated_field = "E6219C2E25FC002E836BF2A15B6D5E91")

    public static final int _SC_THREAD_THREADS_MAX = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.571 -0500", hash_original_field = "26EF89E92826C6B40B288171C1BF6449", hash_generated_field = "D7F8C0A83350BAE1C329FE8048F5C5B7")

    public static final int _SC_TIMERS = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.573 -0500", hash_original_field = "A7730B2D28DC6A2D0B9C0CEC0B998BB9", hash_generated_field = "565BF7615E6860CC213E5B3CF8DEEADB")

    public static final int _SC_TIMER_MAX = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.576 -0500", hash_original_field = "CBE0BFDA01E9145C5B3D04447E51E5FE", hash_generated_field = "624272AFB9CC0C4558836B2FD401A0BA")

    public static final int _SC_TTY_NAME_MAX = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.578 -0500", hash_original_field = "2B0812A416F9A717696071EA79A89134", hash_generated_field = "4C45B2CE034A014D4E2B678743F96D23")

    public static final int _SC_TZNAME_MAX = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.580 -0500", hash_original_field = "A5EE52BA08195E9EC3FE7DCA7C6B7B6B", hash_generated_field = "C3A1CF81581F1C91B2EC6AC3DDF7A3DC")

    public static final int _SC_VERSION = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.583 -0500", hash_original_field = "BA2BFA6E033DB9C41FD8FE9F1C356A41", hash_generated_field = "7F1187D5BB3C382BB8D6A2CB04215EA8")

    public static final int _SC_XBS5_ILP32_OFF32 = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.585 -0500", hash_original_field = "5A3A2C264EBABE22B8925A353F641447", hash_generated_field = "35656715F6F199D6C2ABA2713B183045")

    public static final int _SC_XBS5_ILP32_OFFBIG = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.588 -0500", hash_original_field = "76F3EEE8020A2B6103CA0DDF64231F06", hash_generated_field = "C2F5EE9C232131764668DC882E5E1DC2")

    public static final int _SC_XBS5_LP64_OFF64 = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.590 -0500", hash_original_field = "A498F927E7042338CD23DB353EC6F7C3", hash_generated_field = "A20F95ED635815B693F809682D6A152E")

    public static final int _SC_XBS5_LPBIG_OFFBIG = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.592 -0500", hash_original_field = "EE206C9DF493CE946427692B0F7587E0", hash_generated_field = "A7F78272D9E2C47492F3B4BF58A12D2B")

    public static final int _SC_XOPEN_CRYPT = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.595 -0500", hash_original_field = "A09B413EFA98C5A37DF75E80F337C480", hash_generated_field = "2897A20A025EAE966EF9F1572805487D")

    public static final int _SC_XOPEN_ENH_I18N = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.597 -0500", hash_original_field = "379FFBB8220A56A4F609B232E568822B", hash_generated_field = "C028CEE788C15A0E809F0672EC277526")

    public static final int _SC_XOPEN_LEGACY = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.600 -0500", hash_original_field = "9160760D1B258D26AA367C2AD4629EF6", hash_generated_field = "32DF52204C4E176806C715F8ED9FBD54")

    public static final int _SC_XOPEN_REALTIME = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.603 -0500", hash_original_field = "20CE29BE8B7FE8150AED312C4C6C3CDD", hash_generated_field = "2D61F0626B02A725F8D9924704FC7838")

    public static final int _SC_XOPEN_REALTIME_THREADS = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.605 -0500", hash_original_field = "29DBA0562A9A99696963182F06555A24", hash_generated_field = "C7637E853EB0B990342F5CEC927FA5F8")

    public static final int _SC_XOPEN_SHM = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.608 -0500", hash_original_field = "7282661C81CBE38D431CD8E027FDCEE5", hash_generated_field = "91ADF5F6505928D94201526FE19B9591")

    public static final int _SC_XOPEN_UNIX = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.610 -0500", hash_original_field = "FE0C7AB03018436EF82D931ECD6CF0AF", hash_generated_field = "9E3C4414578FC601EB32676A9C74613A")

    public static final int _SC_XOPEN_VERSION = placeholder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:23.613 -0500", hash_original_field = "67647287038FE23E10B919AA206355E3", hash_generated_field = "B4FC867314AA4AFC4194C07590CB8E4B")

    public static final int _SC_XOPEN_XCU_VERSION = placeholder();
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:22.585 -0500", hash_original_method = "0498D6F7A9D700EE7D091D4440C7A579", hash_generated_method = "8D4AC756647267C5FAEEAEC8B6A79696")
    
private OsConstants() { }
    static {
        initConstants();
    }
    
}

