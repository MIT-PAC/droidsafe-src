package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
import static libcore.io.OsConstants.*;

public class File implements Serializable, Comparable<File> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:40.113 -0400", hash_original_field = "D6FE1D0BE6347B8EF2427FA629C04485", hash_generated_field = "E58B218DC2BC9CF2BD65F7BE2F7C20BE")

    private String path;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:40.114 -0400", hash_original_method = "A8210D76C41C6A4AAFC6BE2371A42886", hash_generated_method = "B8606CB2576065F12192D6BF4E3AC213")
    public  File(File dir, String name) {
        this(dir == null ? null : dir.getPath(), name);
        addTaint(name.getTaint());
        addTaint(dir.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:40.115 -0400", hash_original_method = "2175D562A2B588CC53D616403013683C", hash_generated_method = "F0CF2469DAAFA8B053A90565BD5CE965")
    public  File(String path) {
        this.path = fixSlashes(path);
        // ---------- Original Method ----------
        //this.path = fixSlashes(path);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:40.117 -0400", hash_original_method = "133C96EC98AEE8D59630F091A182C267", hash_generated_method = "2F2FFF15376D3CC9DC5ED85E9A7C2D57")
    public  File(String dirPath, String name) {
    if(name == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_648153928 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_648153928.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_648153928;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:40.119 -0400", hash_original_method = "8BC21AA0285296D0787FE6CED7AAF58D", hash_generated_method = "79D164A841B35BD55411DA5A8905C5CC")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:40.127 -0400", hash_original_method = "69AF6799D7AA8E2E8441037938ACC088", hash_generated_method = "38E8118687DD0141F89BCABA9B0A9C9F")
    public boolean canExecute() {
        boolean varC901E9B79BA5577EEE7F81ECCABA7C1D_1935228943 = (doAccess(X_OK));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1961000220 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1961000220;
        // ---------- Original Method ----------
        //return doAccess(X_OK);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:40.128 -0400", hash_original_method = "7B792954ECFC131D8AE4D0E193C4885E", hash_generated_method = "5CCAE9C8C3E286CCEDC9D904BFA1DE69")
    public boolean canRead() {
        boolean var16CC90803A133688E46C28059E79DEE7_1086178431 = (doAccess(R_OK));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2051154145 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2051154145;
        // ---------- Original Method ----------
        //return doAccess(R_OK);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:40.129 -0400", hash_original_method = "80B9F14946D459E582021E9E2F6280AD", hash_generated_method = "79E8B067E3B8606914F3B6F76F0F1E4F")
    public boolean canWrite() {
        boolean varBEFAAAD5410F30F686A9D9145A271872_715362218 = (doAccess(W_OK));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1401455482 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1401455482;
        // ---------- Original Method ----------
        //return doAccess(W_OK);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:40.130 -0400", hash_original_method = "66AEEE703F2A5FBBF7F14BCD3C8F63B9", hash_generated_method = "0FD260509747855DD19373AD14C8CEF9")
    private boolean doAccess(int mode) {
        addTaint(mode);
        try 
        {
            boolean varB9681A08D4EE8BFF06C85294995AA993_1124921188 = (Libcore.os.access(path, mode));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_818055501 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_818055501;
        } //End block
        catch (ErrnoException errnoException)
        {
            boolean var68934A3E9455FA72420237EB05902327_467565806 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1324451382 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1324451382;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return Libcore.os.access(path, mode);
        //} catch (ErrnoException errnoException) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:40.132 -0400", hash_original_method = "B9E553F90A7CDA44D1E185A0919015AC", hash_generated_method = "FAD458FB36C5EB8BEE8B43A772649833")
    public int compareTo(File another) {
        addTaint(another.getTaint());
        int varC3EBE29AE605A15DC4B40B4FA04382FC_1391121102 = (this.getPath().compareTo(another.getPath()));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2125825449 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2125825449;
        // ---------- Original Method ----------
        //return this.getPath().compareTo(another.getPath());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:40.134 -0400", hash_original_method = "5CDCBB522AFEF90E14CEC34C413E4DF5", hash_generated_method = "A5E48A8AF13336C30E4DB115D1E47B04")
    public boolean delete() {
        try 
        {
            Libcore.os.remove(path);
            boolean varB326B5062B2F0E69046810717534CB09_1778456956 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_499788591 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_499788591;
        } //End block
        catch (ErrnoException errnoException)
        {
            boolean var68934A3E9455FA72420237EB05902327_965519061 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_591064889 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_591064889;
        } //End block
        // ---------- Original Method ----------
        //try {
            //Libcore.os.remove(path);
            //return true;
        //} catch (ErrnoException errnoException) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:40.135 -0400", hash_original_method = "CB1935EF5F2FD9C7C5DF0BCD9272AB92", hash_generated_method = "1DCAE6528A5E92D9050119D34A45FB7D")
    public void deleteOnExit() {
        DeleteOnExit.getInstance().addFile(getAbsolutePath());
        // ---------- Original Method ----------
        //DeleteOnExit.getInstance().addFile(getAbsolutePath());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:40.136 -0400", hash_original_method = "CB9025D33A83838782FA748F5EB00F53", hash_generated_method = "86E2B98568BF02EBD976EE32C11BD810")
    @Override
    public boolean equals(Object obj) {
        addTaint(obj.getTaint());
    if(!(obj instanceof File))        
        {
            boolean var68934A3E9455FA72420237EB05902327_453764653 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_908284738 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_908284738;
        } //End block
        boolean varB906D56A2FF677286A447976F1898945_347455588 = (path.equals(((File) obj).getPath()));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1960158452 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1960158452;
        // ---------- Original Method ----------
        //if (!(obj instanceof File)) {
            //return false;
        //}
        //return path.equals(((File) obj).getPath());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:40.138 -0400", hash_original_method = "D48176638CA08E926D8083B62CC7EB27", hash_generated_method = "93834D23CF9DB4AB626243B93D155D36")
    public boolean exists() {
        boolean varF8AC394411A576A02E0863588CE659D9_1976773936 = (doAccess(F_OK));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_745032002 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_745032002;
        // ---------- Original Method ----------
        //return doAccess(F_OK);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:40.139 -0400", hash_original_method = "8F2B41FC4DF09EBF8497AC74B170E125", hash_generated_method = "AAB5C990E44EA8CD184507FDDA1ED480")
    public String getAbsolutePath() {
    if(isAbsolute())        
        {
String var535F4D9720F3B0C96D8143873CE0638C_2040237459 =             path;
            var535F4D9720F3B0C96D8143873CE0638C_2040237459.addTaint(taint);
            return var535F4D9720F3B0C96D8143873CE0638C_2040237459;
        } //End block
        String userDir = System.getProperty("user.dir");
String var4F090B9F25B3E37BF995BFA6769B0207_1559118705 =         path.isEmpty() ? userDir : join(userDir, path);
        var4F090B9F25B3E37BF995BFA6769B0207_1559118705.addTaint(taint);
        return var4F090B9F25B3E37BF995BFA6769B0207_1559118705;
        // ---------- Original Method ----------
        //if (isAbsolute()) {
            //return path;
        //}
        //String userDir = System.getProperty("user.dir");
        //return path.isEmpty() ? userDir : join(userDir, path);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:40.140 -0400", hash_original_method = "C817D7800025B01E09F67B96128B6FD2", hash_generated_method = "19B193F6D5346B7BD869C396E6279861")
    public File getAbsoluteFile() {
File var91C0F04A5F15A2E39EBA9EBFE05CB3F9_624975813 =         new File(getAbsolutePath());
        var91C0F04A5F15A2E39EBA9EBFE05CB3F9_624975813.addTaint(taint);
        return var91C0F04A5F15A2E39EBA9EBFE05CB3F9_624975813;
        // ---------- Original Method ----------
        //return new File(getAbsolutePath());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:40.141 -0400", hash_original_method = "2353D6268FF62C4AA3E4D2A85DA0DDFF", hash_generated_method = "C5C5361483B2E064577CA04D844C387A")
    public String getCanonicalPath() throws IOException {
String var5E4E102EA6F7E6699A26045AE0D4A4C0_79207150 =         realpath(getAbsolutePath());
        var5E4E102EA6F7E6699A26045AE0D4A4C0_79207150.addTaint(taint);
        return var5E4E102EA6F7E6699A26045AE0D4A4C0_79207150;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:40.144 -0400", hash_original_method = "703FA6965000EF35DC5F6EF68FCCB383", hash_generated_method = "663898205A2A06B1FC746B2531B525D4")
    public File getCanonicalFile() throws IOException {
File var1398763BFC9F15F6CE7A7CED1F2E0123_585072243 =         new File(getCanonicalPath());
        var1398763BFC9F15F6CE7A7CED1F2E0123_585072243.addTaint(taint);
        return var1398763BFC9F15F6CE7A7CED1F2E0123_585072243;
        // ---------- Original Method ----------
        //return new File(getCanonicalPath());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:40.148 -0400", hash_original_method = "6E20F332F3C7773E9502AE9F2437B5A6", hash_generated_method = "74B8B78125AFCEFA534AB1D20E549204")
    public String getName() {
        int separatorIndex = path.lastIndexOf(separator);
String varB9D1E148737978EE546D05465B0A35CE_576967849 =         (separatorIndex < 0) ? path : path.substring(separatorIndex + 1, path.length());
        varB9D1E148737978EE546D05465B0A35CE_576967849.addTaint(taint);
        return varB9D1E148737978EE546D05465B0A35CE_576967849;
        // ---------- Original Method ----------
        //int separatorIndex = path.lastIndexOf(separator);
        //return (separatorIndex < 0) ? path : path.substring(separatorIndex + 1, path.length());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:40.151 -0400", hash_original_method = "160BE3FD42E1931950E2200B6303D787", hash_generated_method = "2DA8AA6888D2BC529D80771A98AB795D")
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
String var540C13E9E156B687226421B24F2DF178_950910300 =             null;
            var540C13E9E156B687226421B24F2DF178_950910300.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_950910300;
        } //End block
    if(path.indexOf(separatorChar) == index
                && path.charAt(firstInPath) == separatorChar)        
        {
String var357282AC880EAB1E0039AAC475A27A53_1323354071 =             path.substring(0, index + 1);
            var357282AC880EAB1E0039AAC475A27A53_1323354071.addTaint(taint);
            return var357282AC880EAB1E0039AAC475A27A53_1323354071;
        } //End block
String varB5FC3A328A09035853AC34C6C06DC9DC_77696520 =         path.substring(0, index);
        varB5FC3A328A09035853AC34C6C06DC9DC_77696520.addTaint(taint);
        return varB5FC3A328A09035853AC34C6C06DC9DC_77696520;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:40.154 -0400", hash_original_method = "05B6D7D4A7E04D12316D2DAB95CF61C6", hash_generated_method = "D1A6D39C0106EFA63CF4DC0FC697A41A")
    public File getParentFile() {
        String tempParent = getParent();
    if(tempParent == null)        
        {
File var540C13E9E156B687226421B24F2DF178_2023641309 =             null;
            var540C13E9E156B687226421B24F2DF178_2023641309.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_2023641309;
        } //End block
File varD8B3B9F37F2A78EA9F84CD2AE0544A52_1350042859 =         new File(tempParent);
        varD8B3B9F37F2A78EA9F84CD2AE0544A52_1350042859.addTaint(taint);
        return varD8B3B9F37F2A78EA9F84CD2AE0544A52_1350042859;
        // ---------- Original Method ----------
        //String tempParent = getParent();
        //if (tempParent == null) {
            //return null;
        //}
        //return new File(tempParent);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:40.156 -0400", hash_original_method = "F862A3BA81BCB206C83E79C3BEB01336", hash_generated_method = "37C21016B20E3AF34C44FC916B540003")
    public String getPath() {
String var535F4D9720F3B0C96D8143873CE0638C_1772683556 =         path;
        var535F4D9720F3B0C96D8143873CE0638C_1772683556.addTaint(taint);
        return var535F4D9720F3B0C96D8143873CE0638C_1772683556;
        // ---------- Original Method ----------
        //return path;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:40.157 -0400", hash_original_method = "9D3CBE29781C2664F4636CCC28F83B76", hash_generated_method = "36D5B78D81BF338559FF0BDFE495DF3E")
    @Override
    public int hashCode() {
        int var69A94F24A603FF8EC28F2CB95FF1273E_2078949795 = (getPath().hashCode() ^ 1234321);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1474838354 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1474838354;
        // ---------- Original Method ----------
        //return getPath().hashCode() ^ 1234321;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:40.158 -0400", hash_original_method = "9F2931F68825A4578F9E89212BCAE059", hash_generated_method = "708BDD1F2901C2D2C972233917E3FF0D")
    public boolean isAbsolute() {
        boolean var7FA6955EF77820B7CB434F8F4B9C1BA0_479959119 = (path.length() > 0 && path.charAt(0) == separatorChar);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1729339862 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1729339862;
        // ---------- Original Method ----------
        //return path.length() > 0 && path.charAt(0) == separatorChar;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:40.159 -0400", hash_original_method = "5A1A5CA8E31989238D097F162F5C184C", hash_generated_method = "AB2B683AAC8D1EF63FBEC600081660DF")
    public boolean isDirectory() {
        try 
        {
            boolean var4B8DF19CF597FF030ECB92DCEF92F772_1649049447 = (S_ISDIR(Libcore.os.stat(path).st_mode));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1790190886 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1790190886;
        } //End block
        catch (ErrnoException errnoException)
        {
            boolean var68934A3E9455FA72420237EB05902327_766963565 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1120323240 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1120323240;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return S_ISDIR(Libcore.os.stat(path).st_mode);
        //} catch (ErrnoException errnoException) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:40.161 -0400", hash_original_method = "B5DE2229663641D636EF433E62C83E7A", hash_generated_method = "94DB888F147B423BCEBE745B1D796FC5")
    public boolean isFile() {
        try 
        {
            boolean var23B0CD3ED8850077D03D70146096FAD6_1978551205 = (S_ISREG(Libcore.os.stat(path).st_mode));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_93287309 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_93287309;
        } //End block
        catch (ErrnoException errnoException)
        {
            boolean var68934A3E9455FA72420237EB05902327_1644506302 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2033660739 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2033660739;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return S_ISREG(Libcore.os.stat(path).st_mode);
        //} catch (ErrnoException errnoException) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:40.164 -0400", hash_original_method = "8D5680EC06296245D4F0DE9A90486B91", hash_generated_method = "C03A2EC1161C2D29230D9AC282E9CDC1")
    public boolean isHidden() {
    if(path.isEmpty())        
        {
            boolean var68934A3E9455FA72420237EB05902327_1071337414 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_282478663 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_282478663;
        } //End block
        boolean var6FA1B6AE89C70C02B418B153337A505B_776474823 = (getName().startsWith("."));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_736305626 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_736305626;
        // ---------- Original Method ----------
        //if (path.isEmpty()) {
            //return false;
        //}
        //return getName().startsWith(".");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:40.166 -0400", hash_original_method = "0921E33485CFCA34C1412D0CC74585F6", hash_generated_method = "9879E5439EA15C32A97931B80CFA4801")
    public long lastModified() {
        try 
        {
            long var0663E05393D05DACB96D74C2258268AA_746201364 = (Libcore.os.stat(path).st_mtime * 1000L);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_947722262 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_947722262;
        } //End block
        catch (ErrnoException errnoException)
        {
            long varCFCD208495D565EF66E7DFF9F98764DA_1774904140 = (0);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_22229165 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_22229165;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return Libcore.os.stat(path).st_mtime * 1000L;
        //} catch (ErrnoException errnoException) {
            //return 0;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:40.167 -0400", hash_original_method = "9B75702C13A04EF9D2AD1E246C28DD45", hash_generated_method = "ADC1B35E0F5ED2466BB4993411A5438D")
    public boolean setLastModified(long time) {
        addTaint(time);
    if(time < 0)        
        {
            IllegalArgumentException varB8559A4A56D1E9E972ED6F7DB9D29FE8_9034508 = new IllegalArgumentException("time < 0");
            varB8559A4A56D1E9E972ED6F7DB9D29FE8_9034508.addTaint(taint);
            throw varB8559A4A56D1E9E972ED6F7DB9D29FE8_9034508;
        } //End block
        boolean varD17DF9F97B466F892C09B9434A3E81EA_387400898 = (setLastModifiedImpl(path, time));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2095755733 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2095755733;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:40.170 -0400", hash_original_method = "A10D7182120D225C8A5565403EC4EFFE", hash_generated_method = "A11FA3E27119B1EFC0FEDC4107CA090A")
    public boolean setReadOnly() {
        boolean varA56C101F7C066CC2FB2A405D5121B78E_948192885 = (setWritable(false, false));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_919554981 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_919554981;
        // ---------- Original Method ----------
        //return setWritable(false, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:40.173 -0400", hash_original_method = "6BD52A034BD79C942DD6922B1E4C88BF", hash_generated_method = "50A1CE75E59B278E3525B82B2F770E38")
    public boolean setExecutable(boolean executable, boolean ownerOnly) {
        addTaint(ownerOnly);
        addTaint(executable);
        boolean varE7642FF076B81623232A54476AE77555_1342176641 = (doChmod(ownerOnly ? S_IXUSR : (S_IXUSR | S_IXGRP | S_IXOTH), executable));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1646291098 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1646291098;
        // ---------- Original Method ----------
        //return doChmod(ownerOnly ? S_IXUSR : (S_IXUSR | S_IXGRP | S_IXOTH), executable);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:40.177 -0400", hash_original_method = "C14362B21605A10B0FC1769762B4B7C4", hash_generated_method = "23D597F49D57DA55764EDE8DA90A9A89")
    public boolean setExecutable(boolean executable) {
        addTaint(executable);
        boolean var72FFE20D190F553CE0FBD56EAC8180B9_863202996 = (setExecutable(executable, true));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_911838943 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_911838943;
        // ---------- Original Method ----------
        //return setExecutable(executable, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:40.178 -0400", hash_original_method = "4618439ECB899A21431C9885F3874F0C", hash_generated_method = "5A07BB39B3D4C97EDDDA3337F8C0562F")
    public boolean setReadable(boolean readable, boolean ownerOnly) {
        addTaint(ownerOnly);
        addTaint(readable);
        boolean varA1C07C3B4F0CB28891C75DFC32EABAD1_1396660710 = (doChmod(ownerOnly ? S_IRUSR : (S_IRUSR | S_IRGRP | S_IROTH), readable));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1879629930 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1879629930;
        // ---------- Original Method ----------
        //return doChmod(ownerOnly ? S_IRUSR : (S_IRUSR | S_IRGRP | S_IROTH), readable);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:40.180 -0400", hash_original_method = "25CECE784879D9A6F63C12E2E495084D", hash_generated_method = "CB1E6A12619E8AAC52E31E3599DB344B")
    public boolean setReadable(boolean readable) {
        addTaint(readable);
        boolean var4D3FAF2A9781DA582CF879708D932A86_1145053136 = (setReadable(readable, true));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_496341759 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_496341759;
        // ---------- Original Method ----------
        //return setReadable(readable, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:40.242 -0400", hash_original_method = "C7C84CA2ADD923BB8D9E9EBE2B4AA50C", hash_generated_method = "BDAB941B617036C7B55BBC23FF580237")
    public boolean setWritable(boolean writable, boolean ownerOnly) {
        addTaint(ownerOnly);
        addTaint(writable);
        boolean var7E7D573895F2F1DAEBC92E098C540DEE_1438390368 = (doChmod(ownerOnly ? S_IWUSR : (S_IWUSR | S_IWGRP | S_IWOTH), writable));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_48731273 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_48731273;
        // ---------- Original Method ----------
        //return doChmod(ownerOnly ? S_IWUSR : (S_IWUSR | S_IWGRP | S_IWOTH), writable);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:40.249 -0400", hash_original_method = "0112F87387A0225E67147890BEDE5131", hash_generated_method = "56BD2C94925184F60D6D337716CFADFC")
    public boolean setWritable(boolean writable) {
        addTaint(writable);
        boolean varD9C9754172505A976ED3D05649F90027_1449295036 = (setWritable(writable, true));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_217536624 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_217536624;
        // ---------- Original Method ----------
        //return setWritable(writable, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:40.257 -0400", hash_original_method = "1AE2CD7860321C46BB79C9D3B3E6342E", hash_generated_method = "B8B9F64AACB3C88F1307E601CD6AA68C")
    private boolean doChmod(int mask, boolean set) {
        addTaint(set);
        addTaint(mask);
        try 
        {
            StructStat sb = Libcore.os.stat(path);
            int newMode = set ? (sb.st_mode | mask) : (sb.st_mode & ~mask);
            Libcore.os.chmod(path, newMode);
            boolean varB326B5062B2F0E69046810717534CB09_436369748 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1174145112 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1174145112;
        } //End block
        catch (ErrnoException errnoException)
        {
            boolean var68934A3E9455FA72420237EB05902327_1268833588 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1195144279 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1195144279;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:40.258 -0400", hash_original_method = "6E1602EC51AE975F6EDA687DC2872422", hash_generated_method = "530B93C8434024D2ED3AAFDCAC3BDE27")
    public long length() {
        try 
        {
            long var4EF3814C0FB7DB72C328FDC964345424_1693711174 = (Libcore.os.stat(path).st_size);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1223065844 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1223065844;
        } //End block
        catch (ErrnoException errnoException)
        {
            long varCFCD208495D565EF66E7DFF9F98764DA_1393850117 = (0);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_2052049323 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_2052049323;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return Libcore.os.stat(path).st_size;
        //} catch (ErrnoException errnoException) {
            //return 0;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:40.260 -0400", hash_original_method = "DC3A6B837A6CEBDAA6FC05976EEFEE9C", hash_generated_method = "D7E047737C2B607961B4328DF6366A6A")
    public String[] list() {
String[] var4F4C7F90EA62B6A2861763194713B35C_463784834 =         listImpl(path);
        var4F4C7F90EA62B6A2861763194713B35C_463784834.addTaint(taint);
        return var4F4C7F90EA62B6A2861763194713B35C_463784834;
        // ---------- Original Method ----------
        //return listImpl(path);
    }

    
    @DSModeled(DSC.SAFE)
    private static String[] listImpl(String path) {
		return new String[0];
	}

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:40.263 -0400", hash_original_method = "9DF6733463E25DE92688E347FBBAD22E", hash_generated_method = "DBA047CBC9BD6D9598E5585FF762D44C")
    public String[] list(FilenameFilter filter) {
        addTaint(filter.getTaint());
        String[] filenames = list();
    if(filter == null || filenames == null)        
        {
String[] var6D54B04A16B4CABC2F5099A0A3EDD446_1774400301 =             filenames;
            var6D54B04A16B4CABC2F5099A0A3EDD446_1774400301.addTaint(taint);
            return var6D54B04A16B4CABC2F5099A0A3EDD446_1774400301;
        } //End block
        List<String> result = new ArrayList<String>(filenames.length);
for(String filename : filenames)
        {
    if(filter.accept(this, filename))            
            {
                result.add(filename);
            } //End block
        } //End block
String[] var51A2A63AEB43607DDC4545933C4B2C78_325224655 =         result.toArray(new String[result.size()]);
        var51A2A63AEB43607DDC4545933C4B2C78_325224655.addTaint(taint);
        return var51A2A63AEB43607DDC4545933C4B2C78_325224655;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:40.265 -0400", hash_original_method = "9B953D65872590D8ABB7497D4B159A57", hash_generated_method = "836AC646CD9493CCA641555753231BC6")
    public File[] listFiles() {
File[] var1B7983DA994F07FB8F700D410235399C_187240688 =         filenamesToFiles(list());
        var1B7983DA994F07FB8F700D410235399C_187240688.addTaint(taint);
        return var1B7983DA994F07FB8F700D410235399C_187240688;
        // ---------- Original Method ----------
        //return filenamesToFiles(list());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:40.267 -0400", hash_original_method = "94A37D22B56FB881F333055CF5969013", hash_generated_method = "638F3832801614B1B3A4A330279D46F2")
    public File[] listFiles(FilenameFilter filter) {
        addTaint(filter.getTaint());
File[] var5324373AF7B0AF1EB8D446F24EE9274B_860223636 =         filenamesToFiles(list(filter));
        var5324373AF7B0AF1EB8D446F24EE9274B_860223636.addTaint(taint);
        return var5324373AF7B0AF1EB8D446F24EE9274B_860223636;
        // ---------- Original Method ----------
        //return filenamesToFiles(list(filter));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:40.270 -0400", hash_original_method = "1FB8ED2C60AA91150D4C3211C8CB2AD8", hash_generated_method = "0F837E9EBCC028BB22A6E88ED275627D")
    public File[] listFiles(FileFilter filter) {
        addTaint(filter.getTaint());
        File[] files = listFiles();
    if(filter == null || files == null)        
        {
File[] var41733365F073B7D9D72A60B6E8BB11F4_811318901 =             files;
            var41733365F073B7D9D72A60B6E8BB11F4_811318901.addTaint(taint);
            return var41733365F073B7D9D72A60B6E8BB11F4_811318901;
        } //End block
        List<File> result = new ArrayList<File>(files.length);
for(File file : files)
        {
    if(filter.accept(file))            
            {
                result.add(file);
            } //End block
        } //End block
File[] var36CD04F8590545BE163F612A0C547736_1964530857 =         result.toArray(new File[result.size()]);
        var36CD04F8590545BE163F612A0C547736_1964530857.addTaint(taint);
        return var36CD04F8590545BE163F612A0C547736_1964530857;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:40.276 -0400", hash_original_method = "7CC449D7C06EBE9C929936D878A8919D", hash_generated_method = "D53C3BA3D36DE84D6150C5A9A970941D")
    private File[] filenamesToFiles(String[] filenames) {
        addTaint(filenames[0].getTaint());
    if(filenames == null)        
        {
File[] var540C13E9E156B687226421B24F2DF178_563475961 =             null;
            var540C13E9E156B687226421B24F2DF178_563475961.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_563475961;
        } //End block
        int count = filenames.length;
        File[] result = new File[count];
for(int i = 0;i < count;++i)
        {
            result[i] = new File(this, filenames[i]);
        } //End block
File[] varDC838461EE2FA0CA4C9BBB70A15456B0_1133811553 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_1133811553.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_1133811553;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:40.278 -0400", hash_original_method = "9AA9A2328E77BE45E90F159A380326D5", hash_generated_method = "3D9F0BB1F57D0F13CDFAF87DAFB68098")
    public boolean mkdir() {
        try 
        {
            Libcore.os.mkdir(path, S_IRWXU);
            boolean varB326B5062B2F0E69046810717534CB09_785044148 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_129516708 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_129516708;
        } //End block
        catch (ErrnoException errnoException)
        {
            boolean var68934A3E9455FA72420237EB05902327_472028153 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_676140905 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_676140905;
        } //End block
        // ---------- Original Method ----------
        //try {
            //Libcore.os.mkdir(path, S_IRWXU);
            //return true;
        //} catch (ErrnoException errnoException) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:40.281 -0400", hash_original_method = "0ED75208E22CDF6376FEADF6E55B44EF", hash_generated_method = "D221D87AAFF923170C0B8CE976E88237")
    public boolean mkdirs() {
    if(exists())        
        {
            boolean var68934A3E9455FA72420237EB05902327_61935455 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1097378672 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1097378672;
        } //End block
    if(mkdir())        
        {
            boolean varB326B5062B2F0E69046810717534CB09_206658860 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_587625381 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_587625381;
        } //End block
        String parentDir = getParent();
    if(parentDir == null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_908105980 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_972527410 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_972527410;
        } //End block
        boolean var32C4D9D2D48215B684F04282CDBA9D48_1181944305 = ((new File(parentDir).mkdirs() && mkdir()));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_844353199 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_844353199;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:40.349 -0400", hash_original_method = "B6F8DC1B8131115DA0E4E46657B89E08", hash_generated_method = "E77C47D593F2A25609A5E07C9B69E514")
    public boolean createNewFile() throws IOException {
        FileDescriptor fd = null;
        try 
        {
            fd = Libcore.os.open(path, O_RDWR | O_CREAT | O_EXCL, 0600);
            boolean varB326B5062B2F0E69046810717534CB09_502050516 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1259726564 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1259726564;
        } //End block
        catch (ErrnoException errnoException)
        {
    if(errnoException.errno == EEXIST)            
            {
                boolean var68934A3E9455FA72420237EB05902327_37635095 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_901888222 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_901888222;
            } //End block
            java.io.IOException var533DBF3F7D78874DC97ED285C3BC3B22_301480989 = errnoException.rethrowAsIOException();
            var533DBF3F7D78874DC97ED285C3BC3B22_301480989.addTaint(taint);
            throw var533DBF3F7D78874DC97ED285C3BC3B22_301480989;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:40.387 -0400", hash_original_method = "FDC5D6D625B3CE9B182F17F4E03581A9", hash_generated_method = "AC96DE0D4E30FE3787878D2D4C665CFD")
    public boolean renameTo(File newPath) {
        addTaint(newPath.getTaint());
        try 
        {
            Libcore.os.rename(path, newPath.path);
            boolean varB326B5062B2F0E69046810717534CB09_493724507 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_543064273 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_543064273;
        } //End block
        catch (ErrnoException errnoException)
        {
            boolean var68934A3E9455FA72420237EB05902327_748529396 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_616094501 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_616094501;
        } //End block
        // ---------- Original Method ----------
        //try {
            //Libcore.os.rename(path, newPath.path);
            //return true;
        //} catch (ErrnoException errnoException) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:40.401 -0400", hash_original_method = "2B0DBB93241DF37011E39BE4D10F6879", hash_generated_method = "50D89DF4F29D7EB95EA86A602FB9F454")
    @Override
    public String toString() {
String var535F4D9720F3B0C96D8143873CE0638C_888147156 =         path;
        var535F4D9720F3B0C96D8143873CE0638C_888147156.addTaint(taint);
        return var535F4D9720F3B0C96D8143873CE0638C_888147156;
        // ---------- Original Method ----------
        //return path;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:40.412 -0400", hash_original_method = "700C756497BE64476D6C692FA75956E5", hash_generated_method = "1EF49E95BC472C43CE76FF7E680A8B65")
    public URI toURI() {
        String name = getAbsoluteName();
        try 
        {
    if(!name.startsWith("/"))            
            {
URI var81CE9C8452AED16CEDF893615168C3D2_695822009 =                 new URI("file", null, "/" + name, null, null);
                var81CE9C8452AED16CEDF893615168C3D2_695822009.addTaint(taint);
                return var81CE9C8452AED16CEDF893615168C3D2_695822009;
            } //End block
            else
    if(name.startsWith("//"))            
            {
URI var29D90A9A6DADA7CCD352DB7E1FC69FFB_1409128065 =                 new URI("file", "", name, null);
                var29D90A9A6DADA7CCD352DB7E1FC69FFB_1409128065.addTaint(taint);
                return var29D90A9A6DADA7CCD352DB7E1FC69FFB_1409128065;
            } //End block
URI varEF9537D825B1B2B07B3A54F3FC640952_1798021472 =             new URI("file", null, name, null, null);
            varEF9537D825B1B2B07B3A54F3FC640952_1798021472.addTaint(taint);
            return varEF9537D825B1B2B07B3A54F3FC640952_1798021472;
        } //End block
        catch (URISyntaxException e)
        {
URI var540C13E9E156B687226421B24F2DF178_1805726078 =             null;
            var540C13E9E156B687226421B24F2DF178_1805726078.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1805726078;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:40.431 -0400", hash_original_method = "A697C8A8DDF3EFD4E15B0A56A47ADC60", hash_generated_method = "9D4166729FBF67E106CDD78B3A5D7A25")
    @Deprecated
    public URL toURL() throws java.net.MalformedURLException {
        String name = getAbsoluteName();
    if(!name.startsWith("/"))        
        {
URL var347EE1274B4A53E8A16CAFF7EB7D3896_503580223 =             new URL("file", "", -1, "/" + name, null);
            var347EE1274B4A53E8A16CAFF7EB7D3896_503580223.addTaint(taint);
            return var347EE1274B4A53E8A16CAFF7EB7D3896_503580223;
        } //End block
        else
    if(name.startsWith("//"))        
        {
URL varB6E76567327A20845E8CD7E94383DAA5_1084791337 =             new URL("file:" + name);
            varB6E76567327A20845E8CD7E94383DAA5_1084791337.addTaint(taint);
            return varB6E76567327A20845E8CD7E94383DAA5_1084791337;
        } //End block
URL var9F0992E1CDD9692D51AE22365958494F_739612927 =         new URL("file", "", -1, name, null);
        var9F0992E1CDD9692D51AE22365958494F_739612927.addTaint(taint);
        return var9F0992E1CDD9692D51AE22365958494F_739612927;
        // ---------- Original Method ----------
        //String name = getAbsoluteName();
        //if (!name.startsWith("/")) {
            //return new URL("file", "", -1, "/" + name, null);
        //} else if (name.startsWith("//")) {
            //return new URL("file:" + name); 
        //}
        //return new URL("file", "", -1, name, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:40.433 -0400", hash_original_method = "6DC10F50F559258D97A948A93E776D0B", hash_generated_method = "C02938DAC4ED261740800C89A119BA77")
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
String varB017984728AC60AD1F0BF8734F33F15C_2117736917 =         name;
        varB017984728AC60AD1F0BF8734F33F15C_2117736917.addTaint(taint);
        return varB017984728AC60AD1F0BF8734F33F15C_2117736917;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:40.434 -0400", hash_original_method = "84E8B11DBED8384FBE25A5788F12F18C", hash_generated_method = "6A6D83BE60C0FC48DB1E5EA5B5695225")
    private void writeObject(ObjectOutputStream stream) throws IOException {
        addTaint(stream.getTaint());
        stream.defaultWriteObject();
        stream.writeChar(separatorChar);
        // ---------- Original Method ----------
        //stream.defaultWriteObject();
        //stream.writeChar(separatorChar);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:40.437 -0400", hash_original_method = "FED9F4FA8E5031FA72F265B39D2840EA", hash_generated_method = "C987743FCB1A70962960ACC00987A73B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:40.438 -0400", hash_original_method = "585308EC98C018F35D8810C372CB8328", hash_generated_method = "7360F9AD40E442EAAFEE5660FB03763F")
    public long getTotalSpace() {
        try 
        {
            StructStatFs sb = Libcore.os.statfs(path);
            long var5772D9E8E485ABB02EDC3C147B3EE2C4_304742795 = (sb.f_blocks * sb.f_bsize);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_2144066849 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_2144066849;
        } //End block
        catch (ErrnoException errnoException)
        {
            long varCFCD208495D565EF66E7DFF9F98764DA_2127657226 = (0);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1472503050 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1472503050;
        } //End block
        // ---------- Original Method ----------
        //try {
            //StructStatFs sb = Libcore.os.statfs(path);
            //return sb.f_blocks * sb.f_bsize; 
        //} catch (ErrnoException errnoException) {
            //return 0;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:40.440 -0400", hash_original_method = "14D64E7B25BCE5C0F5FB20D43EB644E7", hash_generated_method = "24198863C6A3C7803793FFC0086305B6")
    public long getUsableSpace() {
        try 
        {
            StructStatFs sb = Libcore.os.statfs(path);
            long var08F24160F7D4587C47CECCB9E8E4C31D_811922219 = (sb.f_bavail * sb.f_bsize);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_2103889164 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_2103889164;
        } //End block
        catch (ErrnoException errnoException)
        {
            long varCFCD208495D565EF66E7DFF9F98764DA_846621094 = (0);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_194616764 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_194616764;
        } //End block
        // ---------- Original Method ----------
        //try {
            //StructStatFs sb = Libcore.os.statfs(path);
            //return sb.f_bavail * sb.f_bsize; 
        //} catch (ErrnoException errnoException) {
            //return 0;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:40.441 -0400", hash_original_method = "23B4E27185BC412B65C1DC7422116A5E", hash_generated_method = "6406A0B08D9E414F5CE50C2AE1331E8C")
    public long getFreeSpace() {
        try 
        {
            StructStatFs sb = Libcore.os.statfs(path);
            long var6A72B5421CCB9D514F2491AE02FA6A83_824119462 = (sb.f_bfree * sb.f_bsize);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_600865342 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_600865342;
        } //End block
        catch (ErrnoException errnoException)
        {
            long varCFCD208495D565EF66E7DFF9F98764DA_1406782730 = (0);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_453203355 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_453203355;
        } //End block
        // ---------- Original Method ----------
        //try {
            //StructStatFs sb = Libcore.os.statfs(path);
            //return sb.f_bfree * sb.f_bsize; 
        //} catch (ErrnoException errnoException) {
            //return 0;
        //}
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:40.442 -0400", hash_original_field = "1E2D55A8188F4AAB89A2617091CD8DD3", hash_generated_field = "573261A4844452FF520B7BA941A9349A")

    private static final long serialVersionUID = 301077366599181567L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:40.442 -0400", hash_original_field = "87AF8356E9494D3959A18CDFF00E37ED", hash_generated_field = "E9BF35C3AF9EB264C60B98A12F779A5F")

    private static final Random tempFileRandom = new Random();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:40.443 -0400", hash_original_field = "70AC49BC330EA299ED55B5111D605814", hash_generated_field = "0CB7CCD71BDA0E3767C3A1B66A5E66EA")

    public static final char separatorChar;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:40.443 -0400", hash_original_field = "A0F0BC95016C862498BBAD29D1F4D9D4", hash_generated_field = "27036D15C987D02F54CC6DCFF754396D")

    public static final String separator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:40.444 -0400", hash_original_field = "D043CF7D7D8EF3A009AAF357162D0088", hash_generated_field = "915D1D5E91DE4C4CF3D6A430E7A8D5AC")

    public static final char pathSeparatorChar;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:40.444 -0400", hash_original_field = "CB7E5EBB429F7E76E32EC729035E5287", hash_generated_field = "E086687B15C5540EFB395F08D9FB6B55")

    public static final String pathSeparator;
    static {
        separatorChar = System.getProperty("file.separator", "/").charAt(0);
        pathSeparatorChar = System.getProperty("path.separator", ":").charAt(0);
        separator = String.valueOf(separatorChar);
        pathSeparator = String.valueOf(pathSeparatorChar);
    }
    
}

