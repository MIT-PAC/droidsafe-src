package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.949 -0400", hash_original_field = "D6FE1D0BE6347B8EF2427FA629C04485", hash_generated_field = "E58B218DC2BC9CF2BD65F7BE2F7C20BE")

    private String path;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.949 -0400", hash_original_method = "A8210D76C41C6A4AAFC6BE2371A42886", hash_generated_method = "E550E6CD140886FB69160E8A05F219F7")
    public  File(File dir, String name) {
        this(dir == null ? null : dir.getPath(), name);
        addTaint(dir.getTaint());
        addTaint(name.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.950 -0400", hash_original_method = "2175D562A2B588CC53D616403013683C", hash_generated_method = "F0CF2469DAAFA8B053A90565BD5CE965")
    public  File(String path) {
        this.path = fixSlashes(path);
        // ---------- Original Method ----------
        //this.path = fixSlashes(path);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.964 -0400", hash_original_method = "133C96EC98AEE8D59630F091A182C267", hash_generated_method = "4616349A07177EAFED96825C09CF4FAA")
    public  File(String dirPath, String name) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        {
            boolean var522AFCE5CC8B40A2A75402BE5D6A8AB4_173539114 = (dirPath == null || dirPath.isEmpty());
            {
                this.path = fixSlashes(name);
            } //End block
            {
                boolean varC45442D5CAC21BA5127C6B3BB3F7C12C_462997353 = (name.isEmpty());
                {
                    this.path = fixSlashes(dirPath);
                } //End block
                {
                    this.path = fixSlashes(join(dirPath, name));
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.964 -0400", hash_original_method = "8BC21AA0285296D0787FE6CED7AAF58D", hash_generated_method = "79D164A841B35BD55411DA5A8905C5CC")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.966 -0400", hash_original_method = "69AF6799D7AA8E2E8441037938ACC088", hash_generated_method = "F9D4DC235035D31B8858C3D5E6B94B4C")
    public boolean canExecute() {
        boolean var11EACB11BCA61ED56E96A87B0CEEC84B_1740840452 = (doAccess(X_OK));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_988683296 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_988683296;
        // ---------- Original Method ----------
        //return doAccess(X_OK);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.970 -0400", hash_original_method = "7B792954ECFC131D8AE4D0E193C4885E", hash_generated_method = "3671AF812E902CA68ED91E7C3BA81A45")
    public boolean canRead() {
        boolean varE70EB23F73ADA6B237B4D65AC4B82C5A_2101727994 = (doAccess(R_OK));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_261442473 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_261442473;
        // ---------- Original Method ----------
        //return doAccess(R_OK);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.973 -0400", hash_original_method = "80B9F14946D459E582021E9E2F6280AD", hash_generated_method = "8DF6A060824216BFFC67F21901F34D34")
    public boolean canWrite() {
        boolean varDA123BCACBFFAE09BFEC6AFFB499FD36_1116021627 = (doAccess(W_OK));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_965984640 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_965984640;
        // ---------- Original Method ----------
        //return doAccess(W_OK);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.973 -0400", hash_original_method = "66AEEE703F2A5FBBF7F14BCD3C8F63B9", hash_generated_method = "831DA5553A55AF0D94DD98BBA5E5D97C")
    private boolean doAccess(int mode) {
        try 
        {
            boolean varE1C8CEC7263488E3BB150496CD78C18E_1598277302 = (Libcore.os.access(path, mode));
        } //End block
        catch (ErrnoException errnoException)
        { }
        addTaint(mode);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_689539120 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_689539120;
        // ---------- Original Method ----------
        //try {
            //return Libcore.os.access(path, mode);
        //} catch (ErrnoException errnoException) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.974 -0400", hash_original_method = "B9E553F90A7CDA44D1E185A0919015AC", hash_generated_method = "21D4EA793C11EB15E89F087AD3A4880E")
    public int compareTo(File another) {
        int var6643EA56E785E991D6AF3A2A2A7F5979_1481884843 = (this.getPath().compareTo(another.getPath()));
        addTaint(another.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1801668377 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1801668377;
        // ---------- Original Method ----------
        //return this.getPath().compareTo(another.getPath());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.974 -0400", hash_original_method = "5CDCBB522AFEF90E14CEC34C413E4DF5", hash_generated_method = "AE887D6760758506F6CC3F8380DE41C4")
    public boolean delete() {
        try 
        {
            Libcore.os.remove(path);
        } //End block
        catch (ErrnoException errnoException)
        { }
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1266042020 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1266042020;
        // ---------- Original Method ----------
        //try {
            //Libcore.os.remove(path);
            //return true;
        //} catch (ErrnoException errnoException) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.974 -0400", hash_original_method = "CB1935EF5F2FD9C7C5DF0BCD9272AB92", hash_generated_method = "1DCAE6528A5E92D9050119D34A45FB7D")
    public void deleteOnExit() {
        DeleteOnExit.getInstance().addFile(getAbsolutePath());
        // ---------- Original Method ----------
        //DeleteOnExit.getInstance().addFile(getAbsolutePath());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.989 -0400", hash_original_method = "CB9025D33A83838782FA748F5EB00F53", hash_generated_method = "C9687C0D78AFF6DE8AE3B08217A0CD80")
    @Override
    public boolean equals(Object obj) {
        boolean varCCDEE86E8E195B720CEBCF68075E8EAF_685754563 = (path.equals(((File) obj).getPath()));
        addTaint(obj.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2099627590 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2099627590;
        // ---------- Original Method ----------
        //if (!(obj instanceof File)) {
            //return false;
        //}
        //return path.equals(((File) obj).getPath());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.989 -0400", hash_original_method = "D48176638CA08E926D8083B62CC7EB27", hash_generated_method = "254307E2AC72899C1A5943BE85CB9F06")
    public boolean exists() {
        boolean var3DC7BE7F0FA842D88DF3FAB30F500134_1410710494 = (doAccess(F_OK));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_933554494 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_933554494;
        // ---------- Original Method ----------
        //return doAccess(F_OK);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.989 -0400", hash_original_method = "8F2B41FC4DF09EBF8497AC74B170E125", hash_generated_method = "D082AF8CAB947EB624AE80E65CACA515")
    public String getAbsolutePath() {
        String varB4EAC82CA7396A68D541C85D26508E83_10677700 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1181090171 = null; //Variable for return #2
        {
            boolean var40530E982042ED763A2119FF5384DF93_1752177552 = (isAbsolute());
            {
                varB4EAC82CA7396A68D541C85D26508E83_10677700 = path;
            } //End block
        } //End collapsed parenthetic
        String userDir;
        userDir = System.getProperty("user.dir");
        varB4EAC82CA7396A68D541C85D26508E83_1181090171 = path.isEmpty() ? userDir : join(userDir, path);
        String varA7E53CE21691AB073D9660D615818899_1053423557; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1053423557 = varB4EAC82CA7396A68D541C85D26508E83_10677700;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1053423557 = varB4EAC82CA7396A68D541C85D26508E83_1181090171;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1053423557.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1053423557;
        // ---------- Original Method ----------
        //if (isAbsolute()) {
            //return path;
        //}
        //String userDir = System.getProperty("user.dir");
        //return path.isEmpty() ? userDir : join(userDir, path);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.990 -0400", hash_original_method = "C817D7800025B01E09F67B96128B6FD2", hash_generated_method = "F8476DBDE18613929FF7C479A3329F74")
    public File getAbsoluteFile() {
        File varB4EAC82CA7396A68D541C85D26508E83_652095938 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_652095938 = new File(getAbsolutePath());
        varB4EAC82CA7396A68D541C85D26508E83_652095938.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_652095938;
        // ---------- Original Method ----------
        //return new File(getAbsolutePath());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.990 -0400", hash_original_method = "2353D6268FF62C4AA3E4D2A85DA0DDFF", hash_generated_method = "426E022E1D7D98199FD2551DADBFF7DC")
    public String getCanonicalPath() throws IOException {
        String varB4EAC82CA7396A68D541C85D26508E83_105532932 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_105532932 = realpath(getAbsolutePath());
        varB4EAC82CA7396A68D541C85D26508E83_105532932.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_105532932;
        // ---------- Original Method ----------
        //return realpath(getAbsolutePath());
    }

    
        private static String realpath(String path) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
        private static String readlink(String path) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.991 -0400", hash_original_method = "703FA6965000EF35DC5F6EF68FCCB383", hash_generated_method = "9C8428A199AF489AFEE55EC5CD778DBD")
    public File getCanonicalFile() throws IOException {
        File varB4EAC82CA7396A68D541C85D26508E83_608588593 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_608588593 = new File(getCanonicalPath());
        varB4EAC82CA7396A68D541C85D26508E83_608588593.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_608588593;
        // ---------- Original Method ----------
        //return new File(getCanonicalPath());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.992 -0400", hash_original_method = "6E20F332F3C7773E9502AE9F2437B5A6", hash_generated_method = "7EFD57E634EAAC60200B485375AB5916")
    public String getName() {
        String varB4EAC82CA7396A68D541C85D26508E83_505445945 = null; //Variable for return #1
        int separatorIndex;
        separatorIndex = path.lastIndexOf(separator);
        varB4EAC82CA7396A68D541C85D26508E83_505445945 = (separatorIndex < 0) ? path : path.substring(separatorIndex + 1, path.length());
        varB4EAC82CA7396A68D541C85D26508E83_505445945.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_505445945;
        // ---------- Original Method ----------
        //int separatorIndex = path.lastIndexOf(separator);
        //return (separatorIndex < 0) ? path : path.substring(separatorIndex + 1, path.length());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.001 -0400", hash_original_method = "160BE3FD42E1931950E2200B6303D787", hash_generated_method = "92FC1942D429139A554AA647B23DE3B2")
    public String getParent() {
        String varB4EAC82CA7396A68D541C85D26508E83_297623985 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1296890499 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_1620378731 = null; //Variable for return #3
        int length, firstInPath;
        length = path.length();
        firstInPath = 0;
        {
            boolean var863DBDB94E3E0C1E688E23D6337C055A_2052248329 = (separatorChar == '\\' && length > 2 && path.charAt(1) == ':');
            {
                firstInPath = 2;
            } //End block
        } //End collapsed parenthetic
        int index;
        index = path.lastIndexOf(separatorChar);
        {
            index = 2;
        } //End block
        {
            boolean var5FAB5682D222D850607AC8A1318BB400_1639289843 = (index == -1 || path.charAt(length - 1) == separatorChar);
            {
                varB4EAC82CA7396A68D541C85D26508E83_297623985 = null;
            } //End block
        } //End collapsed parenthetic
        {
            boolean var343245EEE7F8E8A5D373797FE3BDF63A_1919255892 = (path.indexOf(separatorChar) == index
                && path.charAt(firstInPath) == separatorChar);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1296890499 = path.substring(0, index + 1);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1620378731 = path.substring(0, index);
        String varA7E53CE21691AB073D9660D615818899_306369154; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_306369154 = varB4EAC82CA7396A68D541C85D26508E83_297623985;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_306369154 = varB4EAC82CA7396A68D541C85D26508E83_1296890499;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_306369154 = varB4EAC82CA7396A68D541C85D26508E83_1620378731;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_306369154.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_306369154;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.011 -0400", hash_original_method = "05B6D7D4A7E04D12316D2DAB95CF61C6", hash_generated_method = "B11C3B4D62D177862A7EEE2A3921E924")
    public File getParentFile() {
        File varB4EAC82CA7396A68D541C85D26508E83_831988837 = null; //Variable for return #1
        File varB4EAC82CA7396A68D541C85D26508E83_1901754365 = null; //Variable for return #2
        String tempParent;
        tempParent = getParent();
        {
            varB4EAC82CA7396A68D541C85D26508E83_831988837 = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1901754365 = new File(tempParent);
        File varA7E53CE21691AB073D9660D615818899_320367779; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_320367779 = varB4EAC82CA7396A68D541C85D26508E83_831988837;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_320367779 = varB4EAC82CA7396A68D541C85D26508E83_1901754365;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_320367779.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_320367779;
        // ---------- Original Method ----------
        //String tempParent = getParent();
        //if (tempParent == null) {
            //return null;
        //}
        //return new File(tempParent);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.012 -0400", hash_original_method = "F862A3BA81BCB206C83E79C3BEB01336", hash_generated_method = "E6F6B7EFE5BE27E44546A2DC748F7D3B")
    public String getPath() {
        String varB4EAC82CA7396A68D541C85D26508E83_1146016691 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1146016691 = path;
        varB4EAC82CA7396A68D541C85D26508E83_1146016691.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1146016691;
        // ---------- Original Method ----------
        //return path;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.012 -0400", hash_original_method = "9D3CBE29781C2664F4636CCC28F83B76", hash_generated_method = "D550385D65E2D43FC0ECBEBC5C92560F")
    @Override
    public int hashCode() {
        int var4C9E48E0C9F3F2F1C840C74BEE9A825F_887774962 = (getPath().hashCode() ^ 1234321);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1309457048 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1309457048;
        // ---------- Original Method ----------
        //return getPath().hashCode() ^ 1234321;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.012 -0400", hash_original_method = "9F2931F68825A4578F9E89212BCAE059", hash_generated_method = "AFA8FFB38045AF4426BCE4856174379A")
    public boolean isAbsolute() {
        boolean varDB79D8CAC4C2DC7A32AE3E7DAD7DA818_1125724501 = (path.length() > 0 && path.charAt(0) == separatorChar);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_841530900 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_841530900;
        // ---------- Original Method ----------
        //return path.length() > 0 && path.charAt(0) == separatorChar;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.013 -0400", hash_original_method = "5A1A5CA8E31989238D097F162F5C184C", hash_generated_method = "011A42A27AC3DDA9718596D2691EE110")
    public boolean isDirectory() {
        try 
        {
            boolean var6AC74137E657BFBDC734D05A25089622_1714985021 = (S_ISDIR(Libcore.os.stat(path).st_mode));
        } //End block
        catch (ErrnoException errnoException)
        { }
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_218572780 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_218572780;
        // ---------- Original Method ----------
        //try {
            //return S_ISDIR(Libcore.os.stat(path).st_mode);
        //} catch (ErrnoException errnoException) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.016 -0400", hash_original_method = "B5DE2229663641D636EF433E62C83E7A", hash_generated_method = "EA64629194A30BB57181A7459B2DA9D1")
    public boolean isFile() {
        try 
        {
            boolean var14FAC7C6C345F2015B4501A8E995DD2F_999260078 = (S_ISREG(Libcore.os.stat(path).st_mode));
        } //End block
        catch (ErrnoException errnoException)
        { }
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1805607676 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1805607676;
        // ---------- Original Method ----------
        //try {
            //return S_ISREG(Libcore.os.stat(path).st_mode);
        //} catch (ErrnoException errnoException) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.017 -0400", hash_original_method = "8D5680EC06296245D4F0DE9A90486B91", hash_generated_method = "639B5B62C6BC700CF28E21FE816BEC2C")
    public boolean isHidden() {
        {
            boolean varA747A2DF3E8CB4EAF5D9CDB3DF3D81CE_482624798 = (path.isEmpty());
        } //End collapsed parenthetic
        boolean varECBEA0E755D64DBD137B22ECA70830D2_307817674 = (getName().startsWith("."));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_150905650 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_150905650;
        // ---------- Original Method ----------
        //if (path.isEmpty()) {
            //return false;
        //}
        //return getName().startsWith(".");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.018 -0400", hash_original_method = "0921E33485CFCA34C1412D0CC74585F6", hash_generated_method = "FE523C9D15B4FC00F0419EFF842D9A71")
    public long lastModified() {
        try 
        {
            long var98E9A747C7267ABB1ADEE4EE0674948C_1902356881 = (Libcore.os.stat(path).st_mtime * 1000L);
        } //End block
        catch (ErrnoException errnoException)
        { }
        long var0F5264038205EDFB1AC05FBB0E8C5E94_286755164 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_286755164;
        // ---------- Original Method ----------
        //try {
            //return Libcore.os.stat(path).st_mtime * 1000L;
        //} catch (ErrnoException errnoException) {
            //return 0;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.018 -0400", hash_original_method = "9B75702C13A04EF9D2AD1E246C28DD45", hash_generated_method = "E394C8522641CED86A63BC1DC3811E08")
    public boolean setLastModified(long time) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("time < 0");
        } //End block
        boolean varC4720CBC7FAA490EA21CC63802D3E053_56812964 = (setLastModifiedImpl(path, time));
        addTaint(time);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1946285487 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1946285487;
        // ---------- Original Method ----------
        //if (time < 0) {
            //throw new IllegalArgumentException("time < 0");
        //}
        //return setLastModifiedImpl(path, time);
    }

    
        private static boolean setLastModifiedImpl(String path, long time) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.018 -0400", hash_original_method = "A10D7182120D225C8A5565403EC4EFFE", hash_generated_method = "6317432EE613211B66DA88F7CE3D694F")
    public boolean setReadOnly() {
        boolean var2207B650E4763A2B2533AEE20A1ED73D_427437234 = (setWritable(false, false));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_519871635 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_519871635;
        // ---------- Original Method ----------
        //return setWritable(false, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.019 -0400", hash_original_method = "6BD52A034BD79C942DD6922B1E4C88BF", hash_generated_method = "C7D826B15D079809F921E75A20696BAE")
    public boolean setExecutable(boolean executable, boolean ownerOnly) {
        boolean varE7D48606C7C85663E76F2F7A25E0A393_951777378 = (doChmod(ownerOnly ? S_IXUSR : (S_IXUSR | S_IXGRP | S_IXOTH), executable)); //DSFIXME:  CODE0008: Nested ternary operator in expression
        addTaint(executable);
        addTaint(ownerOnly);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1795762570 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1795762570;
        // ---------- Original Method ----------
        //return doChmod(ownerOnly ? S_IXUSR : (S_IXUSR | S_IXGRP | S_IXOTH), executable);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.019 -0400", hash_original_method = "C14362B21605A10B0FC1769762B4B7C4", hash_generated_method = "DDE374FE93CEB09D834B52EF15CD78CB")
    public boolean setExecutable(boolean executable) {
        boolean varA4BAA13E37DA9069F7C7E719CB0FE8CC_1948221927 = (setExecutable(executable, true));
        addTaint(executable);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2039633771 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2039633771;
        // ---------- Original Method ----------
        //return setExecutable(executable, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.019 -0400", hash_original_method = "4618439ECB899A21431C9885F3874F0C", hash_generated_method = "E125D8D673875EC4F38654F8CEEDA32B")
    public boolean setReadable(boolean readable, boolean ownerOnly) {
        boolean var5C11E9C261FABB343952CE11090CFB2B_1000824173 = (doChmod(ownerOnly ? S_IRUSR : (S_IRUSR | S_IRGRP | S_IROTH), readable)); //DSFIXME:  CODE0008: Nested ternary operator in expression
        addTaint(readable);
        addTaint(ownerOnly);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_674493513 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_674493513;
        // ---------- Original Method ----------
        //return doChmod(ownerOnly ? S_IRUSR : (S_IRUSR | S_IRGRP | S_IROTH), readable);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.019 -0400", hash_original_method = "25CECE784879D9A6F63C12E2E495084D", hash_generated_method = "D7F239AE19C4CEF3BCAD929FB222BE69")
    public boolean setReadable(boolean readable) {
        boolean var1EB034476AE7B9DE3A44A8EDA359DB4A_960781376 = (setReadable(readable, true));
        addTaint(readable);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_954228957 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_954228957;
        // ---------- Original Method ----------
        //return setReadable(readable, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.029 -0400", hash_original_method = "C7C84CA2ADD923BB8D9E9EBE2B4AA50C", hash_generated_method = "313CF78B50E56F12C5890D72321E697E")
    public boolean setWritable(boolean writable, boolean ownerOnly) {
        boolean var2B456D826A2D8464A1C5648BA8B179E5_144594368 = (doChmod(ownerOnly ? S_IWUSR : (S_IWUSR | S_IWGRP | S_IWOTH), writable)); //DSFIXME:  CODE0008: Nested ternary operator in expression
        addTaint(writable);
        addTaint(ownerOnly);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1731036030 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1731036030;
        // ---------- Original Method ----------
        //return doChmod(ownerOnly ? S_IWUSR : (S_IWUSR | S_IWGRP | S_IWOTH), writable);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.029 -0400", hash_original_method = "0112F87387A0225E67147890BEDE5131", hash_generated_method = "D66D1A873953AB1288D15E82E632D59F")
    public boolean setWritable(boolean writable) {
        boolean var16EE60A060ACAE8B25D2293C6A6A7935_504602439 = (setWritable(writable, true));
        addTaint(writable);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1454633894 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1454633894;
        // ---------- Original Method ----------
        //return setWritable(writable, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.029 -0400", hash_original_method = "1AE2CD7860321C46BB79C9D3B3E6342E", hash_generated_method = "3A962D4AA0275B48204B64698169B6C5")
    private boolean doChmod(int mask, boolean set) {
        try 
        {
            StructStat sb;
            sb = Libcore.os.stat(path);
            int newMode;
            newMode = (sb.st_mode | mask);
            newMode = (sb.st_mode & ~mask);
            Libcore.os.chmod(path, newMode);
        } //End block
        catch (ErrnoException errnoException)
        { }
        addTaint(mask);
        addTaint(set);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1163421685 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1163421685;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.042 -0400", hash_original_method = "6E1602EC51AE975F6EDA687DC2872422", hash_generated_method = "540CFEE8153079DA588B5A1579A41414")
    public long length() {
        try 
        {
            long var9DB83E12CA4626330CD62F63533A5F87_1518463617 = (Libcore.os.stat(path).st_size);
        } //End block
        catch (ErrnoException errnoException)
        { }
        long var0F5264038205EDFB1AC05FBB0E8C5E94_46017700 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_46017700;
        // ---------- Original Method ----------
        //try {
            //return Libcore.os.stat(path).st_size;
        //} catch (ErrnoException errnoException) {
            //return 0;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.051 -0400", hash_original_method = "DC3A6B837A6CEBDAA6FC05976EEFEE9C", hash_generated_method = "4A9BBEFC7513B6F1D06A8BBC042CB397")
    public String[] list() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_1136969390 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1136969390 = listImpl(path);
        varB4EAC82CA7396A68D541C85D26508E83_1136969390.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1136969390;
        // ---------- Original Method ----------
        //return listImpl(path);
    }

    
        private static String[] listImpl(String path) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.097 -0400", hash_original_method = "9DF6733463E25DE92688E347FBBAD22E", hash_generated_method = "63F9063B367C329B57120A1A323ED997")
    public String[] list(FilenameFilter filter) {
        String[] varB4EAC82CA7396A68D541C85D26508E83_71614202 = null; //Variable for return #1
        String[] varB4EAC82CA7396A68D541C85D26508E83_1201178602 = null; //Variable for return #2
        String[] filenames;
        filenames = list();
        {
            varB4EAC82CA7396A68D541C85D26508E83_71614202 = filenames;
        } //End block
        List<String> result;
        result = new ArrayList<String>(filenames.length);
        {
            String filename = filenames[0];
            {
                {
                    boolean var81601EE8E283E32D6B2251267018272D_120265974 = (filter.accept(this, filename));
                    {
                        result.add(filename);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1201178602 = result.toArray(new String[result.size()]);
        addTaint(filter.getTaint());
        String[] varA7E53CE21691AB073D9660D615818899_755414717; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_755414717 = varB4EAC82CA7396A68D541C85D26508E83_71614202;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_755414717 = varB4EAC82CA7396A68D541C85D26508E83_1201178602;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_755414717.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_755414717;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.104 -0400", hash_original_method = "9B953D65872590D8ABB7497D4B159A57", hash_generated_method = "95BE70CDE848AFACA00BFE001F6F78AB")
    public File[] listFiles() {
        File[] varB4EAC82CA7396A68D541C85D26508E83_1512765335 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1512765335 = filenamesToFiles(list());
        varB4EAC82CA7396A68D541C85D26508E83_1512765335.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1512765335;
        // ---------- Original Method ----------
        //return filenamesToFiles(list());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.107 -0400", hash_original_method = "94A37D22B56FB881F333055CF5969013", hash_generated_method = "DBD09E504E5B099B365EE9108ACF9619")
    public File[] listFiles(FilenameFilter filter) {
        File[] varB4EAC82CA7396A68D541C85D26508E83_1871191506 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1871191506 = filenamesToFiles(list(filter));
        addTaint(filter.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1871191506.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1871191506;
        // ---------- Original Method ----------
        //return filenamesToFiles(list(filter));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.160 -0400", hash_original_method = "1FB8ED2C60AA91150D4C3211C8CB2AD8", hash_generated_method = "8CB506CAEBB025F2CA30337BABA487F2")
    public File[] listFiles(FileFilter filter) {
        File[] varB4EAC82CA7396A68D541C85D26508E83_146400031 = null; //Variable for return #1
        File[] varB4EAC82CA7396A68D541C85D26508E83_760708764 = null; //Variable for return #2
        File[] files;
        files = listFiles();
        {
            varB4EAC82CA7396A68D541C85D26508E83_146400031 = files;
        } //End block
        List<File> result;
        result = new ArrayList<File>(files.length);
        {
            File file = files[0];
            {
                {
                    boolean var03D1D21AA056B6A17B9A8B3C581BEF3E_1875204883 = (filter.accept(file));
                    {
                        result.add(file);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_760708764 = result.toArray(new File[result.size()]);
        addTaint(filter.getTaint());
        File[] varA7E53CE21691AB073D9660D615818899_1763535484; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1763535484 = varB4EAC82CA7396A68D541C85D26508E83_146400031;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1763535484 = varB4EAC82CA7396A68D541C85D26508E83_760708764;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1763535484.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1763535484;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.171 -0400", hash_original_method = "7CC449D7C06EBE9C929936D878A8919D", hash_generated_method = "F9F5A47FB86DDB56E7D85946FDBF0044")
    private File[] filenamesToFiles(String[] filenames) {
        File[] varB4EAC82CA7396A68D541C85D26508E83_397658103 = null; //Variable for return #1
        File[] varB4EAC82CA7396A68D541C85D26508E83_841653896 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_397658103 = null;
        } //End block
        int count;
        count = filenames.length;
        File[] result;
        result = new File[count];
        {
            int i;
            i = 0;
            {
                result[i] = new File(this, filenames[i]);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_841653896 = result;
        addTaint(filenames[0].getTaint());
        File[] varA7E53CE21691AB073D9660D615818899_1327968944; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1327968944 = varB4EAC82CA7396A68D541C85D26508E83_397658103;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1327968944 = varB4EAC82CA7396A68D541C85D26508E83_841653896;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1327968944.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1327968944;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.172 -0400", hash_original_method = "9AA9A2328E77BE45E90F159A380326D5", hash_generated_method = "0C1CB9874E076E54F090D3985F926DDE")
    public boolean mkdir() {
        try 
        {
            Libcore.os.mkdir(path, S_IRWXU);
        } //End block
        catch (ErrnoException errnoException)
        { }
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1568040344 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1568040344;
        // ---------- Original Method ----------
        //try {
            //Libcore.os.mkdir(path, S_IRWXU);
            //return true;
        //} catch (ErrnoException errnoException) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.172 -0400", hash_original_method = "0ED75208E22CDF6376FEADF6E55B44EF", hash_generated_method = "315625FF914FBD3719E3EB2779839B93")
    public boolean mkdirs() {
        {
            boolean varE013DE3A7A1EF9C151970630934B77B9_1349449286 = (exists());
        } //End collapsed parenthetic
        {
            boolean varAB3FB019EC81204DE93169D3E3914AF2_2018159499 = (mkdir());
        } //End collapsed parenthetic
        String parentDir;
        parentDir = getParent();
        boolean var8762E100442E02162B81EA5619FDCADC_1994857452 = ((new File(parentDir).mkdirs() && mkdir()));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2120147868 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2120147868;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.177 -0400", hash_original_method = "B6F8DC1B8131115DA0E4E46657B89E08", hash_generated_method = "E030C7527240FDCAEFE653FB01D62096")
    public boolean createNewFile() throws IOException {
        FileDescriptor fd;
        fd = null;
        try 
        {
            fd = Libcore.os.open(path, O_RDWR | O_CREAT | O_EXCL, 0600);
        } //End block
        catch (ErrnoException errnoException)
        {
            if (DroidSafeAndroidRuntime.control) throw errnoException.rethrowAsIOException();
        } //End block
        finally 
        {
            IoUtils.close(fd);
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1981133210 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1981133210;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.183 -0400", hash_original_method = "FDC5D6D625B3CE9B182F17F4E03581A9", hash_generated_method = "47E74D9C604F1CAE6237EA7453D09C01")
    public boolean renameTo(File newPath) {
        try 
        {
            Libcore.os.rename(path, newPath.path);
        } //End block
        catch (ErrnoException errnoException)
        { }
        addTaint(newPath.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1431917857 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1431917857;
        // ---------- Original Method ----------
        //try {
            //Libcore.os.rename(path, newPath.path);
            //return true;
        //} catch (ErrnoException errnoException) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.183 -0400", hash_original_method = "2B0DBB93241DF37011E39BE4D10F6879", hash_generated_method = "6031AD96A8EFC589F35AA84834FE2CAD")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1623328078 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1623328078 = path;
        varB4EAC82CA7396A68D541C85D26508E83_1623328078.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1623328078;
        // ---------- Original Method ----------
        //return path;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.188 -0400", hash_original_method = "700C756497BE64476D6C692FA75956E5", hash_generated_method = "E7C67389627D8BE6F1FD153AB703A12B")
    public URI toURI() {
        URI varB4EAC82CA7396A68D541C85D26508E83_141423690 = null; //Variable for return #1
        URI varB4EAC82CA7396A68D541C85D26508E83_955515960 = null; //Variable for return #2
        URI varB4EAC82CA7396A68D541C85D26508E83_1677816715 = null; //Variable for return #3
        URI varB4EAC82CA7396A68D541C85D26508E83_1791367113 = null; //Variable for return #4
        String name;
        name = getAbsoluteName();
        try 
        {
            {
                boolean var7CF5F60EBC5E2C901F827EF7830FC621_435453010 = (!name.startsWith("/"));
                {
                    varB4EAC82CA7396A68D541C85D26508E83_141423690 = new URI("file", null, "/" + name, null, null);
                } //End block
                {
                    boolean varE9B43904F9CC6A4F5AC7EEBE42EBAED2_727561761 = (name.startsWith("//"));
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_955515960 = new URI("file", "", name, null);
                    } //End block
                } //End collapsed parenthetic
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_1677816715 = new URI("file", null, name, null, null);
        } //End block
        catch (URISyntaxException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1791367113 = null;
        } //End block
        URI varA7E53CE21691AB073D9660D615818899_628357562; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_628357562 = varB4EAC82CA7396A68D541C85D26508E83_141423690;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_628357562 = varB4EAC82CA7396A68D541C85D26508E83_955515960;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_628357562 = varB4EAC82CA7396A68D541C85D26508E83_1677816715;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_628357562 = varB4EAC82CA7396A68D541C85D26508E83_1791367113;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_628357562.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_628357562;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.194 -0400", hash_original_method = "A697C8A8DDF3EFD4E15B0A56A47ADC60", hash_generated_method = "4027D251A4BD84682D922739F56AEF36")
    @Deprecated
    public URL toURL() throws java.net.MalformedURLException {
        URL varB4EAC82CA7396A68D541C85D26508E83_840550643 = null; //Variable for return #1
        URL varB4EAC82CA7396A68D541C85D26508E83_1538796920 = null; //Variable for return #2
        URL varB4EAC82CA7396A68D541C85D26508E83_386412810 = null; //Variable for return #3
        String name;
        name = getAbsoluteName();
        {
            boolean var3B7AB1EAFD7996D7CA57EDAFF1D8E8B9_845730027 = (!name.startsWith("/"));
            {
                varB4EAC82CA7396A68D541C85D26508E83_840550643 = new URL("file", "", -1, "/" + name, null);
            } //End block
            {
                boolean varB9723AF77574C7325A352568702E319A_1252634671 = (name.startsWith("//"));
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1538796920 = new URL("file:" + name);
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_386412810 = new URL("file", "", -1, name, null);
        URL varA7E53CE21691AB073D9660D615818899_148229525; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_148229525 = varB4EAC82CA7396A68D541C85D26508E83_840550643;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_148229525 = varB4EAC82CA7396A68D541C85D26508E83_1538796920;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_148229525 = varB4EAC82CA7396A68D541C85D26508E83_386412810;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_148229525.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_148229525;
        // ---------- Original Method ----------
        //String name = getAbsoluteName();
        //if (!name.startsWith("/")) {
            //return new URL("file", "", -1, "/" + name, null);
        //} else if (name.startsWith("//")) {
            //return new URL("file:" + name); 
        //}
        //return new URL("file", "", -1, name, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.199 -0400", hash_original_method = "6DC10F50F559258D97A948A93E776D0B", hash_generated_method = "489FD410B7792527E3BE13381917F515")
    private String getAbsoluteName() {
        String varB4EAC82CA7396A68D541C85D26508E83_494523361 = null; //Variable for return #1
        File f;
        f = getAbsoluteFile();
        String name;
        name = f.getPath();
        {
            boolean var43D90A838F59D75751D39C0CE0A07AE8_1313782974 = (f.isDirectory() && name.charAt(name.length() - 1) != separatorChar);
            {
                name = name + "/";
            } //End block
        } //End collapsed parenthetic
        {
            name = name.replace(separatorChar, '/');
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_494523361 = name;
        varB4EAC82CA7396A68D541C85D26508E83_494523361.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_494523361;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.204 -0400", hash_original_method = "84E8B11DBED8384FBE25A5788F12F18C", hash_generated_method = "E89EE35230152441AD158B6AA526B263")
    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
        stream.writeChar(separatorChar);
        addTaint(stream.getTaint());
        // ---------- Original Method ----------
        //stream.defaultWriteObject();
        //stream.writeChar(separatorChar);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.204 -0400", hash_original_method = "FED9F4FA8E5031FA72F265B39D2840EA", hash_generated_method = "ED9219E6FE4FB62DF3609B0BBC2291EF")
    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        stream.defaultReadObject();
        char inSeparator;
        inSeparator = stream.readChar();
        this.path = fixSlashes(path.replace(inSeparator, separatorChar));
        addTaint(stream.getTaint());
        // ---------- Original Method ----------
        //stream.defaultReadObject();
        //char inSeparator = stream.readChar();
        //this.path = fixSlashes(path.replace(inSeparator, separatorChar));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.205 -0400", hash_original_method = "585308EC98C018F35D8810C372CB8328", hash_generated_method = "9770D47893B69A14ECDD9799E914A0E6")
    public long getTotalSpace() {
        try 
        {
            StructStatFs sb;
            sb = Libcore.os.statfs(path);
        } //End block
        catch (ErrnoException errnoException)
        { }
        long var0F5264038205EDFB1AC05FBB0E8C5E94_477466718 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_477466718;
        // ---------- Original Method ----------
        //try {
            //StructStatFs sb = Libcore.os.statfs(path);
            //return sb.f_blocks * sb.f_bsize; 
        //} catch (ErrnoException errnoException) {
            //return 0;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.205 -0400", hash_original_method = "14D64E7B25BCE5C0F5FB20D43EB644E7", hash_generated_method = "6F67E6CF5E82314FBAB690E01A6A3CFF")
    public long getUsableSpace() {
        try 
        {
            StructStatFs sb;
            sb = Libcore.os.statfs(path);
        } //End block
        catch (ErrnoException errnoException)
        { }
        long var0F5264038205EDFB1AC05FBB0E8C5E94_119507645 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_119507645;
        // ---------- Original Method ----------
        //try {
            //StructStatFs sb = Libcore.os.statfs(path);
            //return sb.f_bavail * sb.f_bsize; 
        //} catch (ErrnoException errnoException) {
            //return 0;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.205 -0400", hash_original_method = "23B4E27185BC412B65C1DC7422116A5E", hash_generated_method = "6EE5EAB1EED3A41FF70F5596E65E3C1F")
    public long getFreeSpace() {
        try 
        {
            StructStatFs sb;
            sb = Libcore.os.statfs(path);
        } //End block
        catch (ErrnoException errnoException)
        { }
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1435423868 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1435423868;
        // ---------- Original Method ----------
        //try {
            //StructStatFs sb = Libcore.os.statfs(path);
            //return sb.f_bfree * sb.f_bsize; 
        //} catch (ErrnoException errnoException) {
            //return 0;
        //}
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.205 -0400", hash_original_field = "1E2D55A8188F4AAB89A2617091CD8DD3", hash_generated_field = "1CB750C58181DCE9F8132E815B42FC87")

    private static long serialVersionUID = 301077366599181567L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.205 -0400", hash_original_field = "87AF8356E9494D3959A18CDFF00E37ED", hash_generated_field = "C40FE722C99FF0777A4E961782A06071")

    private static Random tempFileRandom = new Random();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.205 -0400", hash_original_field = "70AC49BC330EA299ED55B5111D605814", hash_generated_field = "0CB7CCD71BDA0E3767C3A1B66A5E66EA")

    public static final char separatorChar;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.205 -0400", hash_original_field = "A0F0BC95016C862498BBAD29D1F4D9D4", hash_generated_field = "27036D15C987D02F54CC6DCFF754396D")

    public static final String separator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.210 -0400", hash_original_field = "D043CF7D7D8EF3A009AAF357162D0088", hash_generated_field = "915D1D5E91DE4C4CF3D6A430E7A8D5AC")

    public static final char pathSeparatorChar;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.210 -0400", hash_original_field = "CB7E5EBB429F7E76E32EC729035E5287", hash_generated_field = "E086687B15C5540EFB395F08D9FB6B55")

    public static final String pathSeparator;
    static {
        separatorChar = System.getProperty("file.separator", "/").charAt(0);
        pathSeparatorChar = System.getProperty("path.separator", ":").charAt(0);
        separator = String.valueOf(separatorChar);
        pathSeparator = String.valueOf(pathSeparatorChar);
    }
    
}

