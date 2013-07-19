package java.io;

// Droidsafe Imports
import static libcore.io.OsConstants.EEXIST;
import static libcore.io.OsConstants.F_OK;
import static libcore.io.OsConstants.O_CREAT;
import static libcore.io.OsConstants.O_EXCL;
import static libcore.io.OsConstants.O_RDWR;
import static libcore.io.OsConstants.R_OK;
import static libcore.io.OsConstants.S_IRGRP;
import static libcore.io.OsConstants.S_IROTH;
import static libcore.io.OsConstants.S_IRUSR;
import static libcore.io.OsConstants.S_IRWXU;
import static libcore.io.OsConstants.S_ISDIR;
import static libcore.io.OsConstants.S_ISREG;
import static libcore.io.OsConstants.S_IWGRP;
import static libcore.io.OsConstants.S_IWOTH;
import static libcore.io.OsConstants.S_IWUSR;
import static libcore.io.OsConstants.S_IXGRP;
import static libcore.io.OsConstants.S_IXOTH;
import static libcore.io.OsConstants.S_IXUSR;
import static libcore.io.OsConstants.W_OK;
import static libcore.io.OsConstants.X_OK;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import libcore.io.ErrnoException;
import libcore.io.IoUtils;
import libcore.io.Libcore;
import libcore.io.StructStat;
import libcore.io.StructStatFs;

import org.apache.harmony.luni.util.DeleteOnExit;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;
import droidsafe.helpers.DSUtils;

public class File implements Serializable, Comparable<File> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.816 -0400", hash_original_field = "D6FE1D0BE6347B8EF2427FA629C04485", hash_generated_field = "E58B218DC2BC9CF2BD65F7BE2F7C20BE")

    private String path;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.817 -0400", hash_original_method = "A8210D76C41C6A4AAFC6BE2371A42886", hash_generated_method = "B8606CB2576065F12192D6BF4E3AC213")
    public  File(File dir, String name) {
        this(dir == null ? null : dir.getPath(), name);
        addTaint(name.getTaint());
        addTaint(dir.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.817 -0400", hash_original_method = "2175D562A2B588CC53D616403013683C", hash_generated_method = "F0CF2469DAAFA8B053A90565BD5CE965")
    public  File(String path) {
        this.path = fixSlashes(path);
        // ---------- Original Method ----------
        //this.path = fixSlashes(path);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.818 -0400", hash_original_method = "133C96EC98AEE8D59630F091A182C267", hash_generated_method = "C9D8EA190E6F5B02442A96B63D4BAB8F")
    public  File(String dirPath, String name) {
        if(name == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1728762900 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_1728762900.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_1728762900;
        } //End block
        if(dirPath == null || dirPath.isEmpty())        
        {
            this.path = fixSlashes(name);
        } //End block
        else
        if(name.isEmpty())        
        {
            this.path = fixSlashes(dirPath);
        } //End block
        else
        {
            this.path = fixSlashes(join(dirPath, name));
        } //End block
        // ---------- Original Method ----------
        //if (name == null) {
            //throw new NullPointerException();
        //}
        //if (dirPath == null || dirPath.isEmpty()) {
            //this.path = fixSlashes(name);
        //} else if (name.isEmpty()) {
            //this.path = fixSlashes(dirPath);
        //} else {
            //this.path = fixSlashes(join(dirPath, name));
        //}
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.818 -0400", hash_original_method = "8BC21AA0285296D0787FE6CED7AAF58D", hash_generated_method = "79D164A841B35BD55411DA5A8905C5CC")
    public  File(URI uri) {
        checkURI(uri);
        this.path = fixSlashes(uri.getPath());
        // ---------- Original Method ----------
        //checkURI(uri);
        //this.path = fixSlashes(uri.getPath());
    }

    
    private static String fixSlashes(String origPath) {
        boolean lastWasSlash = false;
        char[] newPath = origPath.toCharArray();
        int length = newPath.length;
        int newLength = 0;
        for (int i = 0; i < length; ++i) {
            char ch = newPath[i];
            if (ch == '/') {
                if (!lastWasSlash) {
                    newPath[newLength++] = separatorChar;
                    lastWasSlash = true;
                }
            } else {
                newPath[newLength++] = ch;
                lastWasSlash = false;
            }
        }
        if (lastWasSlash && newLength > 1) {
            newLength--;
        }
        return (newLength != length) ? new String(newPath, 0, newLength) : origPath;
    }

    
    private static String join(String prefix, String suffix) {
        int prefixLength = prefix.length();
        boolean haveSlash = (prefixLength > 0 && prefix.charAt(prefixLength - 1) == separatorChar);
        if (!haveSlash) {
            haveSlash = (suffix.length() > 0 && suffix.charAt(0) == separatorChar);
        }
        return haveSlash ? (prefix + suffix) : (prefix + separatorChar + suffix);
    }

    
    @DSModeled(DSC.SPEC)
    private static void checkURI(URI uri) {
        if (!uri.isAbsolute()) {
            throw new IllegalArgumentException("URI is not absolute: " + uri);
        } else if (!uri.getRawSchemeSpecificPart().startsWith("/")) {
            throw new IllegalArgumentException("URI is not hierarchical: " + uri);
        }
        if (!"file".equals(uri.getScheme())) {
            throw new IllegalArgumentException("Expected file scheme in URI: " + uri);
        }
        String rawPath = uri.getRawPath();
        if (rawPath == null || rawPath.isEmpty()) {
            throw new IllegalArgumentException("Expected non-empty path in URI: " + uri);
        }
        if (uri.getRawAuthority() != null) {
            throw new IllegalArgumentException("Found authority in URI: " + uri);
        }
        if (uri.getRawQuery() != null) {
            throw new IllegalArgumentException("Found query in URI: " + uri);
        }
        if (uri.getRawFragment() != null) {
            throw new IllegalArgumentException("Found fragment in URI: " + uri);
        }
    }

    
    public static File[] listRoots() {
        return new File[] { new File("/") };
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.819 -0400", hash_original_method = "69AF6799D7AA8E2E8441037938ACC088", hash_generated_method = "C20713A48A28F945820A1792C2989DA2")
    public boolean canExecute() {
        boolean varC901E9B79BA5577EEE7F81ECCABA7C1D_2086521049 = (doAccess(X_OK));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1769692783 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1769692783;
        // ---------- Original Method ----------
        //return doAccess(X_OK);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.820 -0400", hash_original_method = "7B792954ECFC131D8AE4D0E193C4885E", hash_generated_method = "3638B595A25C0F8780370B48CA94F454")
    public boolean canRead() {
        boolean var16CC90803A133688E46C28059E79DEE7_841380928 = (doAccess(R_OK));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_985424957 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_985424957;
        // ---------- Original Method ----------
        //return doAccess(R_OK);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.820 -0400", hash_original_method = "80B9F14946D459E582021E9E2F6280AD", hash_generated_method = "19A49A44770368D47E061C51C5D15838")
    public boolean canWrite() {
        boolean varBEFAAAD5410F30F686A9D9145A271872_637281649 = (doAccess(W_OK));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1595276196 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1595276196;
        // ---------- Original Method ----------
        //return doAccess(W_OK);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.820 -0400", hash_original_method = "66AEEE703F2A5FBBF7F14BCD3C8F63B9", hash_generated_method = "0C44B19CE2464D4E09DE0B876EE2BC5F")
    private boolean doAccess(int mode) {
        addTaint(mode);
        try 
        {
            boolean varB9681A08D4EE8BFF06C85294995AA993_728195601 = (Libcore.os.access(path, mode));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2126232100 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2126232100;
        } //End block
        catch (ErrnoException errnoException)
        {
            boolean var68934A3E9455FA72420237EB05902327_666794045 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_655184046 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_655184046;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return Libcore.os.access(path, mode);
        //} catch (ErrnoException errnoException) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.821 -0400", hash_original_method = "B9E553F90A7CDA44D1E185A0919015AC", hash_generated_method = "FC10B56EE7FABDB836C50D11602DF524")
    public int compareTo(File another) {
        addTaint(another.getTaint());
        int varC3EBE29AE605A15DC4B40B4FA04382FC_511382685 = (this.getPath().compareTo(another.getPath()));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_668164244 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_668164244;
        // ---------- Original Method ----------
        //return this.getPath().compareTo(another.getPath());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.821 -0400", hash_original_method = "5CDCBB522AFEF90E14CEC34C413E4DF5", hash_generated_method = "5EAF3499FCEAD1057DC1A1746F2BFBB1")
    public boolean delete() {
        try 
        {
            Libcore.os.remove(path);
            boolean varB326B5062B2F0E69046810717534CB09_1105980689 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_352613774 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_352613774;
        } //End block
        catch (ErrnoException errnoException)
        {
            boolean var68934A3E9455FA72420237EB05902327_71839150 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1126158210 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1126158210;
        } //End block
        // ---------- Original Method ----------
        //try {
            //Libcore.os.remove(path);
            //return true;
        //} catch (ErrnoException errnoException) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.821 -0400", hash_original_method = "CB1935EF5F2FD9C7C5DF0BCD9272AB92", hash_generated_method = "1DCAE6528A5E92D9050119D34A45FB7D")
    public void deleteOnExit() {
        DeleteOnExit.getInstance().addFile(getAbsolutePath());
        // ---------- Original Method ----------
        //DeleteOnExit.getInstance().addFile(getAbsolutePath());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.822 -0400", hash_original_method = "CB9025D33A83838782FA748F5EB00F53", hash_generated_method = "89DC8C1483B0AA65F5CCD442432E4C35")
    @Override
    public boolean equals(Object obj) {
        addTaint(obj.getTaint());
        if(!(obj instanceof File))        
        {
            boolean var68934A3E9455FA72420237EB05902327_1691273854 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1342717241 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1342717241;
        } //End block
        boolean varB906D56A2FF677286A447976F1898945_1428302515 = (path.equals(((File) obj).getPath()));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_922879743 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_922879743;
        // ---------- Original Method ----------
        //if (!(obj instanceof File)) {
            //return false;
        //}
        //return path.equals(((File) obj).getPath());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.822 -0400", hash_original_method = "D48176638CA08E926D8083B62CC7EB27", hash_generated_method = "0448AED004B637B9105ADE023E8782A8")
    public boolean exists() {
        boolean varF8AC394411A576A02E0863588CE659D9_1309869741 = (doAccess(F_OK));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1815584837 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1815584837;
        // ---------- Original Method ----------
        //return doAccess(F_OK);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.822 -0400", hash_original_method = "8F2B41FC4DF09EBF8497AC74B170E125", hash_generated_method = "C12A6EDB79539AA71068DD1E144D2E98")
    public String getAbsolutePath() {
        if(isAbsolute())        
        {
String var535F4D9720F3B0C96D8143873CE0638C_1405753140 =             path;
            var535F4D9720F3B0C96D8143873CE0638C_1405753140.addTaint(taint);
            return var535F4D9720F3B0C96D8143873CE0638C_1405753140;
        } //End block
        String userDir = System.getProperty("user.dir");
String var4F090B9F25B3E37BF995BFA6769B0207_1493143672 =         path.isEmpty() ? userDir : join(userDir, path);
        var4F090B9F25B3E37BF995BFA6769B0207_1493143672.addTaint(taint);
        return var4F090B9F25B3E37BF995BFA6769B0207_1493143672;
        // ---------- Original Method ----------
        //if (isAbsolute()) {
            //return path;
        //}
        //String userDir = System.getProperty("user.dir");
        //return path.isEmpty() ? userDir : join(userDir, path);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.823 -0400", hash_original_method = "C817D7800025B01E09F67B96128B6FD2", hash_generated_method = "80B87A604E4F59841DD4FDA8F461E256")
    public File getAbsoluteFile() {
File var91C0F04A5F15A2E39EBA9EBFE05CB3F9_834863206 =         new File(getAbsolutePath());
        var91C0F04A5F15A2E39EBA9EBFE05CB3F9_834863206.addTaint(taint);
        return var91C0F04A5F15A2E39EBA9EBFE05CB3F9_834863206;
        // ---------- Original Method ----------
        //return new File(getAbsolutePath());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.823 -0400", hash_original_method = "2353D6268FF62C4AA3E4D2A85DA0DDFF", hash_generated_method = "1F14285CBCDC99E0C75610519F2D481D")
    public String getCanonicalPath() throws IOException {
String var5E4E102EA6F7E6699A26045AE0D4A4C0_524579559 =         realpath(getAbsolutePath());
        var5E4E102EA6F7E6699A26045AE0D4A4C0_524579559.addTaint(taint);
        return var5E4E102EA6F7E6699A26045AE0D4A4C0_524579559;
        // ---------- Original Method ----------
        //return realpath(getAbsolutePath());
    }

    
    @DSModeled(DSC.SAFE)
    private static String realpath(String path) {
		return new String();
	}

    
    @DSModeled(DSC.SAFE)
    private static String readlink(String path) {
		return new String();
	}

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.824 -0400", hash_original_method = "703FA6965000EF35DC5F6EF68FCCB383", hash_generated_method = "C4AB9CE5317602355DB440721A181D13")
    public File getCanonicalFile() throws IOException {
File var1398763BFC9F15F6CE7A7CED1F2E0123_106908479 =         new File(getCanonicalPath());
        var1398763BFC9F15F6CE7A7CED1F2E0123_106908479.addTaint(taint);
        return var1398763BFC9F15F6CE7A7CED1F2E0123_106908479;
        // ---------- Original Method ----------
        //return new File(getCanonicalPath());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.824 -0400", hash_original_method = "6E20F332F3C7773E9502AE9F2437B5A6", hash_generated_method = "459D7934FD8A8F626164EF3F87B29EE2")
    public String getName() {
        int separatorIndex = path.lastIndexOf(separator);
String varB9D1E148737978EE546D05465B0A35CE_1553667171 =         (separatorIndex < 0) ? path : path.substring(separatorIndex + 1, path.length());
        varB9D1E148737978EE546D05465B0A35CE_1553667171.addTaint(taint);
        return varB9D1E148737978EE546D05465B0A35CE_1553667171;
        // ---------- Original Method ----------
        //int separatorIndex = path.lastIndexOf(separator);
        //return (separatorIndex < 0) ? path : path.substring(separatorIndex + 1, path.length());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.825 -0400", hash_original_method = "160BE3FD42E1931950E2200B6303D787", hash_generated_method = "901904FD9B5536E8CEEA2A71162668CD")
    public String getParent() {
        int length = path.length();
        int firstInPath = 0;
        if(separatorChar == '\\' && length > 2 && path.charAt(1) == ':')        
        {
            firstInPath = 2;
        } //End block
        int index = path.lastIndexOf(separatorChar);
        if(index == -1 && firstInPath > 0)        
        {
            index = 2;
        } //End block
        if(index == -1 || path.charAt(length - 1) == separatorChar)        
        {
String var540C13E9E156B687226421B24F2DF178_1437828973 =             null;
            var540C13E9E156B687226421B24F2DF178_1437828973.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1437828973;
        } //End block
        if(path.indexOf(separatorChar) == index
                && path.charAt(firstInPath) == separatorChar)        
        {
String var357282AC880EAB1E0039AAC475A27A53_1753242990 =             path.substring(0, index + 1);
            var357282AC880EAB1E0039AAC475A27A53_1753242990.addTaint(taint);
            return var357282AC880EAB1E0039AAC475A27A53_1753242990;
        } //End block
String varB5FC3A328A09035853AC34C6C06DC9DC_2004756439 =         path.substring(0, index);
        varB5FC3A328A09035853AC34C6C06DC9DC_2004756439.addTaint(taint);
        return varB5FC3A328A09035853AC34C6C06DC9DC_2004756439;
        // ---------- Original Method ----------
        //int length = path.length(), firstInPath = 0;
        //if (separatorChar == '\\' && length > 2 && path.charAt(1) == ':') {
            //firstInPath = 2;
        //}
        //int index = path.lastIndexOf(separatorChar);
        //if (index == -1 && firstInPath > 0) {
            //index = 2;
        //}
        //if (index == -1 || path.charAt(length - 1) == separatorChar) {
            //return null;
        //}
        //if (path.indexOf(separatorChar) == index
                //&& path.charAt(firstInPath) == separatorChar) {
            //return path.substring(0, index + 1);
        //}
        //return path.substring(0, index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.825 -0400", hash_original_method = "05B6D7D4A7E04D12316D2DAB95CF61C6", hash_generated_method = "E718C2D61D04FFF97E136FB4D99DC4A1")
    public File getParentFile() {
        String tempParent = getParent();
        if(tempParent == null)        
        {
File var540C13E9E156B687226421B24F2DF178_1286729359 =             null;
            var540C13E9E156B687226421B24F2DF178_1286729359.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1286729359;
        } //End block
File varD8B3B9F37F2A78EA9F84CD2AE0544A52_1305558277 =         new File(tempParent);
        varD8B3B9F37F2A78EA9F84CD2AE0544A52_1305558277.addTaint(taint);
        return varD8B3B9F37F2A78EA9F84CD2AE0544A52_1305558277;
        // ---------- Original Method ----------
        //String tempParent = getParent();
        //if (tempParent == null) {
            //return null;
        //}
        //return new File(tempParent);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.826 -0400", hash_original_method = "F862A3BA81BCB206C83E79C3BEB01336", hash_generated_method = "A008C8D3B69CBA7179C73B7323AD198B")
    public String getPath() {
String var535F4D9720F3B0C96D8143873CE0638C_694766638 =         path;
        var535F4D9720F3B0C96D8143873CE0638C_694766638.addTaint(taint);
        return var535F4D9720F3B0C96D8143873CE0638C_694766638;
        // ---------- Original Method ----------
        //return path;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.826 -0400", hash_original_method = "9D3CBE29781C2664F4636CCC28F83B76", hash_generated_method = "08217A8D41C05B61FD13CD8A5977065B")
    @Override
    public int hashCode() {
        int var69A94F24A603FF8EC28F2CB95FF1273E_566198785 = (getPath().hashCode() ^ 1234321);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1705923426 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1705923426;
        // ---------- Original Method ----------
        //return getPath().hashCode() ^ 1234321;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.826 -0400", hash_original_method = "9F2931F68825A4578F9E89212BCAE059", hash_generated_method = "CE3D9E77162603CF34658C00D7D1B4B1")
    public boolean isAbsolute() {
        boolean var7FA6955EF77820B7CB434F8F4B9C1BA0_1662966708 = (path.length() > 0 && path.charAt(0) == separatorChar);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1200754862 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1200754862;
        // ---------- Original Method ----------
        //return path.length() > 0 && path.charAt(0) == separatorChar;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.826 -0400", hash_original_method = "5A1A5CA8E31989238D097F162F5C184C", hash_generated_method = "096D316934B9E3069C6E5D59C2B49B87")
    public boolean isDirectory() {
        try 
        {
            boolean var4B8DF19CF597FF030ECB92DCEF92F772_93727944 = (S_ISDIR(Libcore.os.stat(path).st_mode));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_511686722 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_511686722;
        } //End block
        catch (ErrnoException errnoException)
        {
            boolean var68934A3E9455FA72420237EB05902327_1959397934 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1450634087 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1450634087;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return S_ISDIR(Libcore.os.stat(path).st_mode);
        //} catch (ErrnoException errnoException) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.827 -0400", hash_original_method = "B5DE2229663641D636EF433E62C83E7A", hash_generated_method = "22C8D7C2618E17F2A751D2247ECD40BA")
    public boolean isFile() {
        try 
        {
            boolean var23B0CD3ED8850077D03D70146096FAD6_487938379 = (S_ISREG(Libcore.os.stat(path).st_mode));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_794910519 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_794910519;
        } //End block
        catch (ErrnoException errnoException)
        {
            boolean var68934A3E9455FA72420237EB05902327_326360423 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1377240740 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1377240740;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return S_ISREG(Libcore.os.stat(path).st_mode);
        //} catch (ErrnoException errnoException) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.827 -0400", hash_original_method = "8D5680EC06296245D4F0DE9A90486B91", hash_generated_method = "101066F72192F27DB69DF4B83A7207D8")
    public boolean isHidden() {
        if(path.isEmpty())        
        {
            boolean var68934A3E9455FA72420237EB05902327_198835530 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1345349153 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1345349153;
        } //End block
        boolean var6FA1B6AE89C70C02B418B153337A505B_1854729463 = (getName().startsWith("."));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1537040123 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1537040123;
        // ---------- Original Method ----------
        //if (path.isEmpty()) {
            //return false;
        //}
        //return getName().startsWith(".");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.827 -0400", hash_original_method = "0921E33485CFCA34C1412D0CC74585F6", hash_generated_method = "C0C5C43D8882F30FC861CF9B295C3968")
    public long lastModified() {
        try 
        {
            long var0663E05393D05DACB96D74C2258268AA_860964772 = (Libcore.os.stat(path).st_mtime * 1000L);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_20851209 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_20851209;
        } //End block
        catch (ErrnoException errnoException)
        {
            long varCFCD208495D565EF66E7DFF9F98764DA_2125019307 = (0);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1167493920 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1167493920;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return Libcore.os.stat(path).st_mtime * 1000L;
        //} catch (ErrnoException errnoException) {
            //return 0;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.828 -0400", hash_original_method = "9B75702C13A04EF9D2AD1E246C28DD45", hash_generated_method = "5C63C7CAD7A8011E56A7510B9B1F342F")
    public boolean setLastModified(long time) {
        addTaint(time);
        if(time < 0)        
        {
            IllegalArgumentException varB8559A4A56D1E9E972ED6F7DB9D29FE8_1627393265 = new IllegalArgumentException("time < 0");
            varB8559A4A56D1E9E972ED6F7DB9D29FE8_1627393265.addTaint(taint);
            throw varB8559A4A56D1E9E972ED6F7DB9D29FE8_1627393265;
        } //End block
        boolean varD17DF9F97B466F892C09B9434A3E81EA_1535518208 = (setLastModifiedImpl(path, time));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1808468541 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1808468541;
        // ---------- Original Method ----------
        //if (time < 0) {
            //throw new IllegalArgumentException("time < 0");
        //}
        //return setLastModifiedImpl(path, time);
    }

    
    @DSModeled(DSC.SAFE)
    private static boolean setLastModifiedImpl(String path, long time) {
		boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_916883677 = DSUtils.UNKNOWN_BOOLEAN;
		return var84E2C64F38F78BA3EA5C905AB5A2DA27_916883677;
	}

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.829 -0400", hash_original_method = "A10D7182120D225C8A5565403EC4EFFE", hash_generated_method = "F3A963AA8516C60484A31F0AE51A81E1")
    public boolean setReadOnly() {
        boolean varA56C101F7C066CC2FB2A405D5121B78E_112178093 = (setWritable(false, false));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1767989141 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1767989141;
        // ---------- Original Method ----------
        //return setWritable(false, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.829 -0400", hash_original_method = "6BD52A034BD79C942DD6922B1E4C88BF", hash_generated_method = "31C86FC721DEA35F47ABCE24D0A7F186")
    public boolean setExecutable(boolean executable, boolean ownerOnly) {
        addTaint(ownerOnly);
        addTaint(executable);
        boolean varE7642FF076B81623232A54476AE77555_1552916135 = (doChmod(ownerOnly ? S_IXUSR : (S_IXUSR | S_IXGRP | S_IXOTH), executable));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_286721584 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_286721584;
        // ---------- Original Method ----------
        //return doChmod(ownerOnly ? S_IXUSR : (S_IXUSR | S_IXGRP | S_IXOTH), executable);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.829 -0400", hash_original_method = "C14362B21605A10B0FC1769762B4B7C4", hash_generated_method = "20459B99CC70F39EF24FC07CAD56CE8D")
    public boolean setExecutable(boolean executable) {
        addTaint(executable);
        boolean var72FFE20D190F553CE0FBD56EAC8180B9_549189911 = (setExecutable(executable, true));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1661636475 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1661636475;
        // ---------- Original Method ----------
        //return setExecutable(executable, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.830 -0400", hash_original_method = "4618439ECB899A21431C9885F3874F0C", hash_generated_method = "79CE09BB86E1B1909B9CCE38678198E1")
    public boolean setReadable(boolean readable, boolean ownerOnly) {
        addTaint(ownerOnly);
        addTaint(readable);
        boolean varA1C07C3B4F0CB28891C75DFC32EABAD1_633985821 = (doChmod(ownerOnly ? S_IRUSR : (S_IRUSR | S_IRGRP | S_IROTH), readable));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_746878454 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_746878454;
        // ---------- Original Method ----------
        //return doChmod(ownerOnly ? S_IRUSR : (S_IRUSR | S_IRGRP | S_IROTH), readable);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.830 -0400", hash_original_method = "25CECE784879D9A6F63C12E2E495084D", hash_generated_method = "2BDB29718C4BBAD0CAD6159405029376")
    public boolean setReadable(boolean readable) {
        addTaint(readable);
        boolean var4D3FAF2A9781DA582CF879708D932A86_1520436684 = (setReadable(readable, true));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_181471962 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_181471962;
        // ---------- Original Method ----------
        //return setReadable(readable, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.830 -0400", hash_original_method = "C7C84CA2ADD923BB8D9E9EBE2B4AA50C", hash_generated_method = "B8B461869391E871C9E66F2C47F96B35")
    public boolean setWritable(boolean writable, boolean ownerOnly) {
        addTaint(ownerOnly);
        addTaint(writable);
        boolean var7E7D573895F2F1DAEBC92E098C540DEE_430617748 = (doChmod(ownerOnly ? S_IWUSR : (S_IWUSR | S_IWGRP | S_IWOTH), writable));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1013596425 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1013596425;
        // ---------- Original Method ----------
        //return doChmod(ownerOnly ? S_IWUSR : (S_IWUSR | S_IWGRP | S_IWOTH), writable);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.830 -0400", hash_original_method = "0112F87387A0225E67147890BEDE5131", hash_generated_method = "4A0976E7061D4C9E9D239FD3CCA4A3C3")
    public boolean setWritable(boolean writable) {
        addTaint(writable);
        boolean varD9C9754172505A976ED3D05649F90027_828656778 = (setWritable(writable, true));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_485748819 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_485748819;
        // ---------- Original Method ----------
        //return setWritable(writable, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.831 -0400", hash_original_method = "1AE2CD7860321C46BB79C9D3B3E6342E", hash_generated_method = "CCBC0E0AD218637FD8B7E581464D48BB")
    private boolean doChmod(int mask, boolean set) {
        addTaint(set);
        addTaint(mask);
        try 
        {
            StructStat sb = Libcore.os.stat(path);
            int newMode = set ? (sb.st_mode | mask) : (sb.st_mode & ~mask);
            Libcore.os.chmod(path, newMode);
            boolean varB326B5062B2F0E69046810717534CB09_2065166716 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_982283248 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_982283248;
        } //End block
        catch (ErrnoException errnoException)
        {
            boolean var68934A3E9455FA72420237EB05902327_313948008 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2044141377 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2044141377;
        } //End block
        // ---------- Original Method ----------
        //try {
            //StructStat sb = Libcore.os.stat(path);
            //int newMode = set ? (sb.st_mode | mask) : (sb.st_mode & ~mask);
            //Libcore.os.chmod(path, newMode);
            //return true;
        //} catch (ErrnoException errnoException) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.831 -0400", hash_original_method = "6E1602EC51AE975F6EDA687DC2872422", hash_generated_method = "1C22129B8BC332243B00551D74991963")
    public long length() {
        try 
        {
            long var4EF3814C0FB7DB72C328FDC964345424_1747145905 = (Libcore.os.stat(path).st_size);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_874516332 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_874516332;
        } //End block
        catch (ErrnoException errnoException)
        {
            long varCFCD208495D565EF66E7DFF9F98764DA_1871438543 = (0);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1480750407 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1480750407;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return Libcore.os.stat(path).st_size;
        //} catch (ErrnoException errnoException) {
            //return 0;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.831 -0400", hash_original_method = "DC3A6B837A6CEBDAA6FC05976EEFEE9C", hash_generated_method = "7484DCC314016383ACAB77C7B1420B73")
    public String[] list() {
String[] var4F4C7F90EA62B6A2861763194713B35C_815412095 =         listImpl(path);
        var4F4C7F90EA62B6A2861763194713B35C_815412095.addTaint(taint);
        return var4F4C7F90EA62B6A2861763194713B35C_815412095;
        // ---------- Original Method ----------
        //return listImpl(path);
    }

    
    @DSModeled(DSC.SAFE)
    private static String[] listImpl(String path) {
		return new String[0];
	}

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.832 -0400", hash_original_method = "9DF6733463E25DE92688E347FBBAD22E", hash_generated_method = "29CF3B6C15F77B477933B63CC31D14A6")
    public String[] list(FilenameFilter filter) {
        addTaint(filter.getTaint());
        String[] filenames = list();
        if(filter == null || filenames == null)        
        {
String[] var6D54B04A16B4CABC2F5099A0A3EDD446_1035677050 =             filenames;
            var6D54B04A16B4CABC2F5099A0A3EDD446_1035677050.addTaint(taint);
            return var6D54B04A16B4CABC2F5099A0A3EDD446_1035677050;
        } //End block
        List<String> result = new ArrayList<String>(filenames.length);
for(String filename : filenames)
        {
            if(filter.accept(this, filename))            
            {
                result.add(filename);
            } //End block
        } //End block
String[] var51A2A63AEB43607DDC4545933C4B2C78_987460155 =         result.toArray(new String[result.size()]);
        var51A2A63AEB43607DDC4545933C4B2C78_987460155.addTaint(taint);
        return var51A2A63AEB43607DDC4545933C4B2C78_987460155;
        // ---------- Original Method ----------
        //String[] filenames = list();
        //if (filter == null || filenames == null) {
            //return filenames;
        //}
        //List<String> result = new ArrayList<String>(filenames.length);
        //for (String filename : filenames) {
            //if (filter.accept(this, filename)) {
                //result.add(filename);
            //}
        //}
        //return result.toArray(new String[result.size()]);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.832 -0400", hash_original_method = "9B953D65872590D8ABB7497D4B159A57", hash_generated_method = "AC5DDFBB176084A6E3902D43B7BCB5AF")
    public File[] listFiles() {
File[] var1B7983DA994F07FB8F700D410235399C_1818608247 =         filenamesToFiles(list());
        var1B7983DA994F07FB8F700D410235399C_1818608247.addTaint(taint);
        return var1B7983DA994F07FB8F700D410235399C_1818608247;
        // ---------- Original Method ----------
        //return filenamesToFiles(list());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.833 -0400", hash_original_method = "94A37D22B56FB881F333055CF5969013", hash_generated_method = "9B8EA342E363C18C05A1904594297F8D")
    public File[] listFiles(FilenameFilter filter) {
        addTaint(filter.getTaint());
File[] var5324373AF7B0AF1EB8D446F24EE9274B_1501053947 =         filenamesToFiles(list(filter));
        var5324373AF7B0AF1EB8D446F24EE9274B_1501053947.addTaint(taint);
        return var5324373AF7B0AF1EB8D446F24EE9274B_1501053947;
        // ---------- Original Method ----------
        //return filenamesToFiles(list(filter));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.833 -0400", hash_original_method = "1FB8ED2C60AA91150D4C3211C8CB2AD8", hash_generated_method = "3DE09770B2E6F03F59F695EE205D82D7")
    public File[] listFiles(FileFilter filter) {
        addTaint(filter.getTaint());
        File[] files = listFiles();
        if(filter == null || files == null)        
        {
File[] var41733365F073B7D9D72A60B6E8BB11F4_2062507864 =             files;
            var41733365F073B7D9D72A60B6E8BB11F4_2062507864.addTaint(taint);
            return var41733365F073B7D9D72A60B6E8BB11F4_2062507864;
        } //End block
        List<File> result = new ArrayList<File>(files.length);
for(File file : files)
        {
            if(filter.accept(file))            
            {
                result.add(file);
            } //End block
        } //End block
File[] var36CD04F8590545BE163F612A0C547736_510542342 =         result.toArray(new File[result.size()]);
        var36CD04F8590545BE163F612A0C547736_510542342.addTaint(taint);
        return var36CD04F8590545BE163F612A0C547736_510542342;
        // ---------- Original Method ----------
        //File[] files = listFiles();
        //if (filter == null || files == null) {
            //return files;
        //}
        //List<File> result = new ArrayList<File>(files.length);
        //for (File file : files) {
            //if (filter.accept(file)) {
                //result.add(file);
            //}
        //}
        //return result.toArray(new File[result.size()]);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.833 -0400", hash_original_method = "7CC449D7C06EBE9C929936D878A8919D", hash_generated_method = "CC3ED78B83BA36B3882FDB2D5B3AC32F")
    private File[] filenamesToFiles(String[] filenames) {
        addTaint(filenames[0].getTaint());
        if(filenames == null)        
        {
File[] var540C13E9E156B687226421B24F2DF178_1406049929 =             null;
            var540C13E9E156B687226421B24F2DF178_1406049929.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1406049929;
        } //End block
        int count = filenames.length;
        File[] result = new File[count];
for(int i = 0;i < count;++i)
        {
            result[i] = new File(this, filenames[i]);
        } //End block
File[] varDC838461EE2FA0CA4C9BBB70A15456B0_1223998741 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_1223998741.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_1223998741;
        // ---------- Original Method ----------
        //if (filenames == null) {
            //return null;
        //}
        //int count = filenames.length;
        //File[] result = new File[count];
        //for (int i = 0; i < count; ++i) {
            //result[i] = new File(this, filenames[i]);
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.834 -0400", hash_original_method = "9AA9A2328E77BE45E90F159A380326D5", hash_generated_method = "82D46EC287CE95186779BCC73A76A390")
    public boolean mkdir() {
        try 
        {
            Libcore.os.mkdir(path, S_IRWXU);
            boolean varB326B5062B2F0E69046810717534CB09_1293210993 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_107891293 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_107891293;
        } //End block
        catch (ErrnoException errnoException)
        {
            boolean var68934A3E9455FA72420237EB05902327_344684989 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1588394190 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1588394190;
        } //End block
        // ---------- Original Method ----------
        //try {
            //Libcore.os.mkdir(path, S_IRWXU);
            //return true;
        //} catch (ErrnoException errnoException) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.834 -0400", hash_original_method = "0ED75208E22CDF6376FEADF6E55B44EF", hash_generated_method = "7019C26F4D561A7F6A0CD3F0EC757694")
    public boolean mkdirs() {
        if(exists())        
        {
            boolean var68934A3E9455FA72420237EB05902327_322358092 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1828349303 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1828349303;
        } //End block
        if(mkdir())        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1181079861 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_575527530 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_575527530;
        } //End block
        String parentDir = getParent();
        if(parentDir == null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1560158630 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1497540254 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1497540254;
        } //End block
        boolean var32C4D9D2D48215B684F04282CDBA9D48_1730382914 = ((new File(parentDir).mkdirs() && mkdir()));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1897065511 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1897065511;
        // ---------- Original Method ----------
        //if (exists()) {
            //return false;
        //}
        //if (mkdir()) {
            //return true;
        //}
        //String parentDir = getParent();
        //if (parentDir == null) {
            //return false;
        //}
        //return (new File(parentDir).mkdirs() && mkdir());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.855 -0400", hash_original_method = "B6F8DC1B8131115DA0E4E46657B89E08", hash_generated_method = "769978219FB45E4ACC9BDEE7C1C1FCE1")
    public boolean createNewFile() throws IOException {
        FileDescriptor fd = null;
        try 
        {
            fd = Libcore.os.open(path, O_RDWR | O_CREAT | O_EXCL, 0600);
            boolean varB326B5062B2F0E69046810717534CB09_1226453672 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_745897568 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_745897568;
        } //End block
        catch (ErrnoException errnoException)
        {
            if(errnoException.errno == EEXIST)            
            {
                boolean var68934A3E9455FA72420237EB05902327_1706201908 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1422719375 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1422719375;
            } //End block
            java.io.IOException var533DBF3F7D78874DC97ED285C3BC3B22_1441150300 = errnoException.rethrowAsIOException();
            var533DBF3F7D78874DC97ED285C3BC3B22_1441150300.addTaint(taint);
            throw var533DBF3F7D78874DC97ED285C3BC3B22_1441150300;
        } //End block
        finally 
        {
            IoUtils.close(fd);
        } //End block
        // ---------- Original Method ----------
        //FileDescriptor fd = null;
        //try {
            //fd = Libcore.os.open(path, O_RDWR | O_CREAT | O_EXCL, 0600);
            //return true;
        //} catch (ErrnoException errnoException) {
            //if (errnoException.errno == EEXIST) {
                //return false;
            //}
            //throw errnoException.rethrowAsIOException();
        //} finally {
            //IoUtils.close(fd); 
        //}
    }

    
    public static File createTempFile(String prefix, String suffix) throws IOException {
        return createTempFile(prefix, suffix, null);
    }

    
    public static File createTempFile(String prefix, String suffix, File directory) throws IOException {
        if (prefix.length() < 3) {
            throw new IllegalArgumentException("prefix must be at least 3 characters");
        }
        if (suffix == null) {
            suffix = ".tmp";
        }
        File tmpDirFile = directory;
        if (tmpDirFile == null) {
            String tmpDir = System.getProperty("java.io.tmpdir", ".");
            tmpDirFile = new File(tmpDir);
        }
        File result;
        do {
            result = new File(tmpDirFile, prefix + tempFileRandom.nextInt() + suffix);
        } while (!result.createNewFile());
        return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.856 -0400", hash_original_method = "FDC5D6D625B3CE9B182F17F4E03581A9", hash_generated_method = "954172FEAF73143795C6A3F56A16F60B")
    public boolean renameTo(File newPath) {
        addTaint(newPath.getTaint());
        try 
        {
            Libcore.os.rename(path, newPath.path);
            boolean varB326B5062B2F0E69046810717534CB09_315476802 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1023136929 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1023136929;
        } //End block
        catch (ErrnoException errnoException)
        {
            boolean var68934A3E9455FA72420237EB05902327_407331843 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1606622115 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1606622115;
        } //End block
        // ---------- Original Method ----------
        //try {
            //Libcore.os.rename(path, newPath.path);
            //return true;
        //} catch (ErrnoException errnoException) {
            //return false;
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.857 -0400", hash_original_method = "2B0DBB93241DF37011E39BE4D10F6879", hash_generated_method = "6AC581FBFF8DEDC16672BABE4BD75275")
    @Override
    public String toString() {
String var535F4D9720F3B0C96D8143873CE0638C_1204713460 =         path;
        var535F4D9720F3B0C96D8143873CE0638C_1204713460.addTaint(taint);
        return var535F4D9720F3B0C96D8143873CE0638C_1204713460;
        // ---------- Original Method ----------
        //return path;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.857 -0400", hash_original_method = "700C756497BE64476D6C692FA75956E5", hash_generated_method = "83B703FD7718250D40AE9A9467D048ED")
    public URI toURI() {
        String name = getAbsoluteName();
        try 
        {
            if(!name.startsWith("/"))            
            {
URI var81CE9C8452AED16CEDF893615168C3D2_1760874075 =                 new URI("file", null, "/" + name, null, null);
                var81CE9C8452AED16CEDF893615168C3D2_1760874075.addTaint(taint);
                return var81CE9C8452AED16CEDF893615168C3D2_1760874075;
            } //End block
            else
            if(name.startsWith("//"))            
            {
URI var29D90A9A6DADA7CCD352DB7E1FC69FFB_1073480290 =                 new URI("file", "", name, null);
                var29D90A9A6DADA7CCD352DB7E1FC69FFB_1073480290.addTaint(taint);
                return var29D90A9A6DADA7CCD352DB7E1FC69FFB_1073480290;
            } //End block
URI varEF9537D825B1B2B07B3A54F3FC640952_313304114 =             new URI("file", null, name, null, null);
            varEF9537D825B1B2B07B3A54F3FC640952_313304114.addTaint(taint);
            return varEF9537D825B1B2B07B3A54F3FC640952_313304114;
        } //End block
        catch (URISyntaxException e)
        {
URI var540C13E9E156B687226421B24F2DF178_816445735 =             null;
            var540C13E9E156B687226421B24F2DF178_816445735.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_816445735;
        } //End block
        // ---------- Original Method ----------
        //String name = getAbsoluteName();
        //try {
            //if (!name.startsWith("/")) {
                //return new URI("file", null, "/" + name, null, null);
            //} else if (name.startsWith("//")) {
                //return new URI("file", "", name, null); 
            //}
            //return new URI("file", null, name, null, null);
        //} catch (URISyntaxException e) {
            //return null;
        //}
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.858 -0400", hash_original_method = "A697C8A8DDF3EFD4E15B0A56A47ADC60", hash_generated_method = "54213675288BBAEBAE1CCF508D505953")
    @Deprecated
    public URL toURL() throws java.net.MalformedURLException {
        String name = getAbsoluteName();
        if(!name.startsWith("/"))        
        {
URL var347EE1274B4A53E8A16CAFF7EB7D3896_581746080 =             new URL("file", "", -1, "/" + name, null);
            var347EE1274B4A53E8A16CAFF7EB7D3896_581746080.addTaint(taint);
            return var347EE1274B4A53E8A16CAFF7EB7D3896_581746080;
        } //End block
        else
        if(name.startsWith("//"))        
        {
URL varB6E76567327A20845E8CD7E94383DAA5_1818859224 =             new URL("file:" + name);
            varB6E76567327A20845E8CD7E94383DAA5_1818859224.addTaint(taint);
            return varB6E76567327A20845E8CD7E94383DAA5_1818859224;
        } //End block
URL var9F0992E1CDD9692D51AE22365958494F_479158924 =         new URL("file", "", -1, name, null);
        var9F0992E1CDD9692D51AE22365958494F_479158924.addTaint(taint);
        return var9F0992E1CDD9692D51AE22365958494F_479158924;
        // ---------- Original Method ----------
        //String name = getAbsoluteName();
        //if (!name.startsWith("/")) {
            //return new URL("file", "", -1, "/" + name, null);
        //} else if (name.startsWith("//")) {
            //return new URL("file:" + name); 
        //}
        //return new URL("file", "", -1, name, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.858 -0400", hash_original_method = "6DC10F50F559258D97A948A93E776D0B", hash_generated_method = "191A2DA5FC2E815BDB8D60F7ECD793CA")
    private String getAbsoluteName() {
        File f = getAbsoluteFile();
        String name = f.getPath();
        if(f.isDirectory() && name.charAt(name.length() - 1) != separatorChar)        
        {
            name = name + "/";
        } //End block
        if(separatorChar != '/')        
        {
            name = name.replace(separatorChar, '/');
        } //End block
String varB017984728AC60AD1F0BF8734F33F15C_248740100 =         name;
        varB017984728AC60AD1F0BF8734F33F15C_248740100.addTaint(taint);
        return varB017984728AC60AD1F0BF8734F33F15C_248740100;
        // ---------- Original Method ----------
        //File f = getAbsoluteFile();
        //String name = f.getPath();
        //if (f.isDirectory() && name.charAt(name.length() - 1) != separatorChar) {
            //name = name + "/";
        //}
        //if (separatorChar != '/') { 
            //name = name.replace(separatorChar, '/');
        //}
        //return name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.858 -0400", hash_original_method = "84E8B11DBED8384FBE25A5788F12F18C", hash_generated_method = "6A6D83BE60C0FC48DB1E5EA5B5695225")
    private void writeObject(ObjectOutputStream stream) throws IOException {
        addTaint(stream.getTaint());
        stream.defaultWriteObject();
        stream.writeChar(separatorChar);
        // ---------- Original Method ----------
        //stream.defaultWriteObject();
        //stream.writeChar(separatorChar);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.858 -0400", hash_original_method = "FED9F4FA8E5031FA72F265B39D2840EA", hash_generated_method = "C987743FCB1A70962960ACC00987A73B")
    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        addTaint(stream.getTaint());
        stream.defaultReadObject();
        char inSeparator = stream.readChar();
        this.path = fixSlashes(path.replace(inSeparator, separatorChar));
        // ---------- Original Method ----------
        //stream.defaultReadObject();
        //char inSeparator = stream.readChar();
        //this.path = fixSlashes(path.replace(inSeparator, separatorChar));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.858 -0400", hash_original_method = "585308EC98C018F35D8810C372CB8328", hash_generated_method = "C1E2AE925C07B7F3C31099A888CBEF5C")
    public long getTotalSpace() {
        try 
        {
            StructStatFs sb = Libcore.os.statfs(path);
            long var5772D9E8E485ABB02EDC3C147B3EE2C4_627918761 = (sb.f_blocks * sb.f_bsize);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1926337336 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1926337336;
        } //End block
        catch (ErrnoException errnoException)
        {
            long varCFCD208495D565EF66E7DFF9F98764DA_52653401 = (0);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_680745368 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_680745368;
        } //End block
        // ---------- Original Method ----------
        //try {
            //StructStatFs sb = Libcore.os.statfs(path);
            //return sb.f_blocks * sb.f_bsize; 
        //} catch (ErrnoException errnoException) {
            //return 0;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.858 -0400", hash_original_method = "14D64E7B25BCE5C0F5FB20D43EB644E7", hash_generated_method = "BE1F4A9E1EA8161B98813A555AEA1914")
    public long getUsableSpace() {
        try 
        {
            StructStatFs sb = Libcore.os.statfs(path);
            long var08F24160F7D4587C47CECCB9E8E4C31D_1575548046 = (sb.f_bavail * sb.f_bsize);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1600012519 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1600012519;
        } //End block
        catch (ErrnoException errnoException)
        {
            long varCFCD208495D565EF66E7DFF9F98764DA_246999795 = (0);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1727396527 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1727396527;
        } //End block
        // ---------- Original Method ----------
        //try {
            //StructStatFs sb = Libcore.os.statfs(path);
            //return sb.f_bavail * sb.f_bsize; 
        //} catch (ErrnoException errnoException) {
            //return 0;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.859 -0400", hash_original_method = "23B4E27185BC412B65C1DC7422116A5E", hash_generated_method = "83DA5210CFBABD4E93F75FD3C51A9C8C")
    public long getFreeSpace() {
        try 
        {
            StructStatFs sb = Libcore.os.statfs(path);
            long var6A72B5421CCB9D514F2491AE02FA6A83_552000505 = (sb.f_bfree * sb.f_bsize);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_562514382 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_562514382;
        } //End block
        catch (ErrnoException errnoException)
        {
            long varCFCD208495D565EF66E7DFF9F98764DA_970581128 = (0);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1309802478 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1309802478;
        } //End block
        // ---------- Original Method ----------
        //try {
            //StructStatFs sb = Libcore.os.statfs(path);
            //return sb.f_bfree * sb.f_bsize; 
        //} catch (ErrnoException errnoException) {
            //return 0;
        //}
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.859 -0400", hash_original_field = "1E2D55A8188F4AAB89A2617091CD8DD3", hash_generated_field = "573261A4844452FF520B7BA941A9349A")

    private static final long serialVersionUID = 301077366599181567L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.859 -0400", hash_original_field = "87AF8356E9494D3959A18CDFF00E37ED", hash_generated_field = "E9BF35C3AF9EB264C60B98A12F779A5F")

    private static final Random tempFileRandom = new Random();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.859 -0400", hash_original_field = "70AC49BC330EA299ED55B5111D605814", hash_generated_field = "0CB7CCD71BDA0E3767C3A1B66A5E66EA")

    public static final char separatorChar;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.859 -0400", hash_original_field = "A0F0BC95016C862498BBAD29D1F4D9D4", hash_generated_field = "27036D15C987D02F54CC6DCFF754396D")

    public static final String separator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.859 -0400", hash_original_field = "D043CF7D7D8EF3A009AAF357162D0088", hash_generated_field = "915D1D5E91DE4C4CF3D6A430E7A8D5AC")

    public static final char pathSeparatorChar;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.859 -0400", hash_original_field = "CB7E5EBB429F7E76E32EC729035E5287", hash_generated_field = "E086687B15C5540EFB395F08D9FB6B55")

    public static final String pathSeparator;
    static {
        separatorChar = System.getProperty("file.separator", "/").charAt(0);
        pathSeparatorChar = System.getProperty("path.separator", ":").charAt(0);
        separator = String.valueOf(separatorChar);
        pathSeparator = String.valueOf(pathSeparatorChar);
    }
    
}

