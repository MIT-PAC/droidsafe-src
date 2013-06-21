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
    private String path;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.569 -0400", hash_original_method = "A8210D76C41C6A4AAFC6BE2371A42886", hash_generated_method = "E3567DF9BA3B11B4D5C87577EFF81A32")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public File(File dir, String name) {
        this(dir == null ? null : dir.getPath(), name);
        dsTaint.addTaint(dir.dsTaint);
        dsTaint.addTaint(name);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.569 -0400", hash_original_method = "2175D562A2B588CC53D616403013683C", hash_generated_method = "DC33A9E2604F43FCB8ECB727C50E725B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public File(String path) {
        dsTaint.addTaint(path);
        this.path = fixSlashes(path);
        // ---------- Original Method ----------
        //this.path = fixSlashes(path);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.570 -0400", hash_original_method = "133C96EC98AEE8D59630F091A182C267", hash_generated_method = "033CB50F4818E043770D0584C7FEBF95")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public File(String dirPath, String name) {
        dsTaint.addTaint(dirPath);
        dsTaint.addTaint(name);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        {
            boolean var522AFCE5CC8B40A2A75402BE5D6A8AB4_1258161673 = (dirPath == null || dirPath.isEmpty());
            {
                this.path = fixSlashes(name);
            } //End block
            {
                boolean varC45442D5CAC21BA5127C6B3BB3F7C12C_986070758 = (name.isEmpty());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.570 -0400", hash_original_method = "8BC21AA0285296D0787FE6CED7AAF58D", hash_generated_method = "3AC1394CC68339D18B6D7DF31F549234")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public File(URI uri) {
        dsTaint.addTaint(uri.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.571 -0400", hash_original_method = "69AF6799D7AA8E2E8441037938ACC088", hash_generated_method = "9B005FA8A08E59A8FDBD7D5106BCDF2B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean canExecute() {
        boolean var11EACB11BCA61ED56E96A87B0CEEC84B_1007286509 = (doAccess(X_OK));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return doAccess(X_OK);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.571 -0400", hash_original_method = "7B792954ECFC131D8AE4D0E193C4885E", hash_generated_method = "E9E7CC15DE1DE0510897B4F9152F1B1F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean canRead() {
        boolean varE70EB23F73ADA6B237B4D65AC4B82C5A_629546450 = (doAccess(R_OK));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return doAccess(R_OK);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.571 -0400", hash_original_method = "80B9F14946D459E582021E9E2F6280AD", hash_generated_method = "4A906C93ADBE4566857F12050C1A874E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean canWrite() {
        boolean varDA123BCACBFFAE09BFEC6AFFB499FD36_485916038 = (doAccess(W_OK));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return doAccess(W_OK);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.571 -0400", hash_original_method = "66AEEE703F2A5FBBF7F14BCD3C8F63B9", hash_generated_method = "6A842E59D758283BDF9F03B7B7782B65")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean doAccess(int mode) {
        dsTaint.addTaint(mode);
        try 
        {
            boolean varE1C8CEC7263488E3BB150496CD78C18E_274329241 = (Libcore.os.access(path, mode));
        } //End block
        catch (ErrnoException errnoException)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //return Libcore.os.access(path, mode);
        //} catch (ErrnoException errnoException) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.571 -0400", hash_original_method = "B9E553F90A7CDA44D1E185A0919015AC", hash_generated_method = "50DF17E2653EA93C48087DE812C1C6D3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int compareTo(File another) {
        dsTaint.addTaint(another.dsTaint);
        int var6643EA56E785E991D6AF3A2A2A7F5979_540848270 = (this.getPath().compareTo(another.getPath()));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return this.getPath().compareTo(another.getPath());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.571 -0400", hash_original_method = "5CDCBB522AFEF90E14CEC34C413E4DF5", hash_generated_method = "BD81C7BD702902724F7E982A995D876D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean delete() {
        try 
        {
            Libcore.os.remove(path);
        } //End block
        catch (ErrnoException errnoException)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //Libcore.os.remove(path);
            //return true;
        //} catch (ErrnoException errnoException) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.572 -0400", hash_original_method = "CB1935EF5F2FD9C7C5DF0BCD9272AB92", hash_generated_method = "1DCAE6528A5E92D9050119D34A45FB7D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void deleteOnExit() {
        DeleteOnExit.getInstance().addFile(getAbsolutePath());
        // ---------- Original Method ----------
        //DeleteOnExit.getInstance().addFile(getAbsolutePath());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.572 -0400", hash_original_method = "CB9025D33A83838782FA748F5EB00F53", hash_generated_method = "761A23EEFF34236E2A154F2B4E5B4067")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object obj) {
        dsTaint.addTaint(obj.dsTaint);
        boolean varCCDEE86E8E195B720CEBCF68075E8EAF_1926545851 = (path.equals(((File) obj).getPath()));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (!(obj instanceof File)) {
            //return false;
        //}
        //return path.equals(((File) obj).getPath());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.572 -0400", hash_original_method = "D48176638CA08E926D8083B62CC7EB27", hash_generated_method = "429CD51914CFCCDFB851AFA591F77347")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean exists() {
        boolean var3DC7BE7F0FA842D88DF3FAB30F500134_1768044480 = (doAccess(F_OK));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return doAccess(F_OK);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.572 -0400", hash_original_method = "8F2B41FC4DF09EBF8497AC74B170E125", hash_generated_method = "7879DCA697E1803116CA79758CCA47F4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getAbsolutePath() {
        {
            boolean var40530E982042ED763A2119FF5384DF93_1824511597 = (isAbsolute());
        } //End collapsed parenthetic
        String userDir;
        userDir = System.getProperty("user.dir");
        {
            boolean varA747A2DF3E8CB4EAF5D9CDB3DF3D81CE_572281239 = (path.isEmpty());
            Object var2604BE65C5A596E7ACF1ED91EA2488E4_2055752921 = (join(userDir, path));
        } //End flattened ternary
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (isAbsolute()) {
            //return path;
        //}
        //String userDir = System.getProperty("user.dir");
        //return path.isEmpty() ? userDir : join(userDir, path);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.572 -0400", hash_original_method = "C817D7800025B01E09F67B96128B6FD2", hash_generated_method = "8758D59F26B207A5C5FA73F07ACD9685")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public File getAbsoluteFile() {
        File var4F83F5FE5BD3095E287C4389DCEF49D9_354190411 = (new File(getAbsolutePath()));
        return (File)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new File(getAbsolutePath());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.573 -0400", hash_original_method = "2353D6268FF62C4AA3E4D2A85DA0DDFF", hash_generated_method = "625421C3ADDA5B4E681462600770E63B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getCanonicalPath() throws IOException {
        String var32DE5438FB5A094857B1E7B7C48836B1_478671435 = (realpath(getAbsolutePath()));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return realpath(getAbsolutePath());
    }

    
        private static String realpath(String path) {
        return DSUtils.UNKNOWN_STRING;
    }

    
        private static String readlink(String path) {
        return DSUtils.UNKNOWN_STRING;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.573 -0400", hash_original_method = "703FA6965000EF35DC5F6EF68FCCB383", hash_generated_method = "D6BCC50C10700FD99A326308D0D89686")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public File getCanonicalFile() throws IOException {
        File varD619CAF119FD6F0798AFAFC7C2F24EC2_1157968317 = (new File(getCanonicalPath()));
        return (File)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new File(getCanonicalPath());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.573 -0400", hash_original_method = "6E20F332F3C7773E9502AE9F2437B5A6", hash_generated_method = "7DE64B78CC8942B09DB387C93972CAD4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getName() {
        int separatorIndex;
        separatorIndex = path.lastIndexOf(separator);
        {
            Object varCBF9AF8C8E610E7A4D651D386D35C04D_825845441 = (path.substring(separatorIndex + 1, path.length()));
        } //End flattened ternary
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //int separatorIndex = path.lastIndexOf(separator);
        //return (separatorIndex < 0) ? path : path.substring(separatorIndex + 1, path.length());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.574 -0400", hash_original_method = "160BE3FD42E1931950E2200B6303D787", hash_generated_method = "CDAD48FB9EF8B7BB72B76E32BE0AD54F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getParent() {
        int length, firstInPath;
        length = path.length();
        firstInPath = 0;
        {
            boolean var863DBDB94E3E0C1E688E23D6337C055A_1171482893 = (separatorChar == '\\' && length > 2 && path.charAt(1) == ':');
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
            boolean var5FAB5682D222D850607AC8A1318BB400_385086193 = (index == -1 || path.charAt(length - 1) == separatorChar);
        } //End collapsed parenthetic
        {
            boolean var343245EEE7F8E8A5D373797FE3BDF63A_314807858 = (path.indexOf(separatorChar) == index
                && path.charAt(firstInPath) == separatorChar);
            {
                String var158C9DB8998BBDD3E76AAD2E14D2A416_1441950676 = (path.substring(0, index + 1));
            } //End block
        } //End collapsed parenthetic
        String varF6A588DA40C8B48DA6B02AA2C475E395_1811246508 = (path.substring(0, index));
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.574 -0400", hash_original_method = "05B6D7D4A7E04D12316D2DAB95CF61C6", hash_generated_method = "DC885C2A74B6CB468E960E7407D4D394")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public File getParentFile() {
        String tempParent;
        tempParent = getParent();
        File var7C41E0A4DE77B6B6B6667909D9FC2A08_148276246 = (new File(tempParent));
        return (File)dsTaint.getTaint();
        // ---------- Original Method ----------
        //String tempParent = getParent();
        //if (tempParent == null) {
            //return null;
        //}
        //return new File(tempParent);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.574 -0400", hash_original_method = "F862A3BA81BCB206C83E79C3BEB01336", hash_generated_method = "D5220EB7264C7D7D84F8D5CCD4678C60")
    @DSModeled(DSC.SAFE)
    public String getPath() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return path;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.574 -0400", hash_original_method = "9D3CBE29781C2664F4636CCC28F83B76", hash_generated_method = "23EC4390ED762F70EEFDB649693B20D9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int hashCode() {
        int var4C9E48E0C9F3F2F1C840C74BEE9A825F_731626914 = (getPath().hashCode() ^ 1234321);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return getPath().hashCode() ^ 1234321;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.574 -0400", hash_original_method = "9F2931F68825A4578F9E89212BCAE059", hash_generated_method = "272EF8641A84F4C9452C0C0443C2411B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isAbsolute() {
        boolean varDB79D8CAC4C2DC7A32AE3E7DAD7DA818_238184122 = (path.length() > 0 && path.charAt(0) == separatorChar);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return path.length() > 0 && path.charAt(0) == separatorChar;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.575 -0400", hash_original_method = "5A1A5CA8E31989238D097F162F5C184C", hash_generated_method = "966E1F502382F62D9789227411706272")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isDirectory() {
        try 
        {
            boolean var6AC74137E657BFBDC734D05A25089622_1800659390 = (S_ISDIR(Libcore.os.stat(path).st_mode));
        } //End block
        catch (ErrnoException errnoException)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //return S_ISDIR(Libcore.os.stat(path).st_mode);
        //} catch (ErrnoException errnoException) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.575 -0400", hash_original_method = "B5DE2229663641D636EF433E62C83E7A", hash_generated_method = "BA71238DADB293A8B09E78CDDF2D4E31")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isFile() {
        try 
        {
            boolean var14FAC7C6C345F2015B4501A8E995DD2F_1196089643 = (S_ISREG(Libcore.os.stat(path).st_mode));
        } //End block
        catch (ErrnoException errnoException)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //return S_ISREG(Libcore.os.stat(path).st_mode);
        //} catch (ErrnoException errnoException) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.575 -0400", hash_original_method = "8D5680EC06296245D4F0DE9A90486B91", hash_generated_method = "869CBB4000BB7840656787C8A037C7E7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isHidden() {
        {
            boolean varA747A2DF3E8CB4EAF5D9CDB3DF3D81CE_520152029 = (path.isEmpty());
        } //End collapsed parenthetic
        boolean varECBEA0E755D64DBD137B22ECA70830D2_1648696118 = (getName().startsWith("."));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (path.isEmpty()) {
            //return false;
        //}
        //return getName().startsWith(".");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.575 -0400", hash_original_method = "0921E33485CFCA34C1412D0CC74585F6", hash_generated_method = "608B8300603C97829E0894172DC524AB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long lastModified() {
        try 
        {
            long var98E9A747C7267ABB1ADEE4EE0674948C_296561324 = (Libcore.os.stat(path).st_mtime * 1000L);
        } //End block
        catch (ErrnoException errnoException)
        { }
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //try {
            //return Libcore.os.stat(path).st_mtime * 1000L;
        //} catch (ErrnoException errnoException) {
            //return 0;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.575 -0400", hash_original_method = "9B75702C13A04EF9D2AD1E246C28DD45", hash_generated_method = "5D2795ABF036A1FDB61607BF7F75FE35")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean setLastModified(long time) {
        dsTaint.addTaint(time);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("time < 0");
        } //End block
        boolean varC4720CBC7FAA490EA21CC63802D3E053_1513680520 = (setLastModifiedImpl(path, time));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (time < 0) {
            //throw new IllegalArgumentException("time < 0");
        //}
        //return setLastModifiedImpl(path, time);
    }

    
        private static boolean setLastModifiedImpl(String path, long time) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.603 -0400", hash_original_method = "A10D7182120D225C8A5565403EC4EFFE", hash_generated_method = "060BC8EEB25DB09A3E37E9D26E0D97AE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean setReadOnly() {
        boolean var2207B650E4763A2B2533AEE20A1ED73D_743148786 = (setWritable(false, false));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return setWritable(false, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.603 -0400", hash_original_method = "6BD52A034BD79C942DD6922B1E4C88BF", hash_generated_method = "EC157D17ABACA7262947BD09271C2556")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean setExecutable(boolean executable, boolean ownerOnly) {
        dsTaint.addTaint(executable);
        dsTaint.addTaint(ownerOnly);
        boolean varE7D48606C7C85663E76F2F7A25E0A393_2054732288 = (doChmod(ownerOnly ? S_IXUSR : (S_IXUSR | S_IXGRP | S_IXOTH), executable)); //DSFIXME:  CODE0008: Nested ternary operator in expression
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return doChmod(ownerOnly ? S_IXUSR : (S_IXUSR | S_IXGRP | S_IXOTH), executable);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.604 -0400", hash_original_method = "C14362B21605A10B0FC1769762B4B7C4", hash_generated_method = "D787748EBBDFA13495D2F4DB5C0D73D0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean setExecutable(boolean executable) {
        dsTaint.addTaint(executable);
        boolean varA4BAA13E37DA9069F7C7E719CB0FE8CC_1837692055 = (setExecutable(executable, true));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return setExecutable(executable, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.604 -0400", hash_original_method = "4618439ECB899A21431C9885F3874F0C", hash_generated_method = "9D8A0CD57FD0C045CB481DB90F83358F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean setReadable(boolean readable, boolean ownerOnly) {
        dsTaint.addTaint(readable);
        dsTaint.addTaint(ownerOnly);
        boolean var5C11E9C261FABB343952CE11090CFB2B_1770865358 = (doChmod(ownerOnly ? S_IRUSR : (S_IRUSR | S_IRGRP | S_IROTH), readable)); //DSFIXME:  CODE0008: Nested ternary operator in expression
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return doChmod(ownerOnly ? S_IRUSR : (S_IRUSR | S_IRGRP | S_IROTH), readable);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.604 -0400", hash_original_method = "25CECE784879D9A6F63C12E2E495084D", hash_generated_method = "D4B082CBD2DEA1A99AEE2C17679D4A1B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean setReadable(boolean readable) {
        dsTaint.addTaint(readable);
        boolean var1EB034476AE7B9DE3A44A8EDA359DB4A_630252199 = (setReadable(readable, true));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return setReadable(readable, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.604 -0400", hash_original_method = "C7C84CA2ADD923BB8D9E9EBE2B4AA50C", hash_generated_method = "026E67A9D1A514BA789DBF3564826B7C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean setWritable(boolean writable, boolean ownerOnly) {
        dsTaint.addTaint(writable);
        dsTaint.addTaint(ownerOnly);
        boolean var2B456D826A2D8464A1C5648BA8B179E5_741809373 = (doChmod(ownerOnly ? S_IWUSR : (S_IWUSR | S_IWGRP | S_IWOTH), writable)); //DSFIXME:  CODE0008: Nested ternary operator in expression
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return doChmod(ownerOnly ? S_IWUSR : (S_IWUSR | S_IWGRP | S_IWOTH), writable);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.604 -0400", hash_original_method = "0112F87387A0225E67147890BEDE5131", hash_generated_method = "599B42744490E64C66B56615C961D21A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean setWritable(boolean writable) {
        dsTaint.addTaint(writable);
        boolean var16EE60A060ACAE8B25D2293C6A6A7935_1785321926 = (setWritable(writable, true));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return setWritable(writable, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.604 -0400", hash_original_method = "1AE2CD7860321C46BB79C9D3B3E6342E", hash_generated_method = "88EFCD521A62E2A209B51D26E53CD43A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean doChmod(int mask, boolean set) {
        dsTaint.addTaint(set);
        dsTaint.addTaint(mask);
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
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.605 -0400", hash_original_method = "6E1602EC51AE975F6EDA687DC2872422", hash_generated_method = "7E359A996A09CC9189EC89BFB5B8DA0E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long length() {
        try 
        {
            long var9DB83E12CA4626330CD62F63533A5F87_2099217437 = (Libcore.os.stat(path).st_size);
        } //End block
        catch (ErrnoException errnoException)
        { }
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //try {
            //return Libcore.os.stat(path).st_size;
        //} catch (ErrnoException errnoException) {
            //return 0;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.605 -0400", hash_original_method = "DC3A6B837A6CEBDAA6FC05976EEFEE9C", hash_generated_method = "7272AE5072C7A385D15233811A19CF62")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String[] list() {
        String[] var0B058FF722837311DF9F21220E58AB96_120262829 = (listImpl(path));
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //return listImpl(path);
    }

    
        private static String[] listImpl(String path) {
        String[] retVal = {DSUtils.UNKNOWN_STRING};
        return retVal;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.613 -0400", hash_original_method = "9DF6733463E25DE92688E347FBBAD22E", hash_generated_method = "97F48596F17FA536D6A44283261801DB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String[] list(FilenameFilter filter) {
        dsTaint.addTaint(filter.dsTaint);
        String[] filenames;
        filenames = list();
        List<String> result;
        result = new ArrayList<String>(filenames.length);
        {
            String filename = filenames[0];
            {
                {
                    boolean var81601EE8E283E32D6B2251267018272D_35379060 = (filter.accept(this, filename));
                    {
                        result.add(filename);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        String[] varADD55AC2D00220D2A7FD16059C35D687_1722408087 = (result.toArray(new String[result.size()]));
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.613 -0400", hash_original_method = "9B953D65872590D8ABB7497D4B159A57", hash_generated_method = "4203FF37C001E9B147BA1A445E3924CF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public File[] listFiles() {
        File[] varADD500C5212AB3579E2ED89D0CDDE87D_928120405 = (filenamesToFiles(list()));
        return (File[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //return filenamesToFiles(list());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.613 -0400", hash_original_method = "94A37D22B56FB881F333055CF5969013", hash_generated_method = "3121BAEAC0FB04AFBA0E1ACF96A0E3AA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public File[] listFiles(FilenameFilter filter) {
        dsTaint.addTaint(filter.dsTaint);
        File[] var447E03466BB3647D36CFC65297E02A03_1494306795 = (filenamesToFiles(list(filter)));
        return (File[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //return filenamesToFiles(list(filter));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.620 -0400", hash_original_method = "1FB8ED2C60AA91150D4C3211C8CB2AD8", hash_generated_method = "97822B55074AE26FC898DD3BBD1F8426")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public File[] listFiles(FileFilter filter) {
        dsTaint.addTaint(filter.dsTaint);
        File[] files;
        files = listFiles();
        List<File> result;
        result = new ArrayList<File>(files.length);
        {
            File file = files[0];
            {
                {
                    boolean var03D1D21AA056B6A17B9A8B3C581BEF3E_1420079802 = (filter.accept(file));
                    {
                        result.add(file);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        File[] var9AFAA4289A50507019102F4E1FE53897_600708783 = (result.toArray(new File[result.size()]));
        return (File[])dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.620 -0400", hash_original_method = "7CC449D7C06EBE9C929936D878A8919D", hash_generated_method = "D6FC0B7A942D58F7398608C74AE8E5BE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private File[] filenamesToFiles(String[] filenames) {
        dsTaint.addTaint(filenames[0]);
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
        return (File[])dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.621 -0400", hash_original_method = "9AA9A2328E77BE45E90F159A380326D5", hash_generated_method = "987C8CAA5123C0CEF1A2C47D763AC486")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean mkdir() {
        try 
        {
            Libcore.os.mkdir(path, S_IRWXU);
        } //End block
        catch (ErrnoException errnoException)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //Libcore.os.mkdir(path, S_IRWXU);
            //return true;
        //} catch (ErrnoException errnoException) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.621 -0400", hash_original_method = "0ED75208E22CDF6376FEADF6E55B44EF", hash_generated_method = "203125026C2B6EE996A430A02BBC90FF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean mkdirs() {
        {
            boolean varE013DE3A7A1EF9C151970630934B77B9_1177320118 = (exists());
        } //End collapsed parenthetic
        {
            boolean varAB3FB019EC81204DE93169D3E3914AF2_1920535038 = (mkdir());
        } //End collapsed parenthetic
        String parentDir;
        parentDir = getParent();
        boolean var8762E100442E02162B81EA5619FDCADC_1371394314 = ((new File(parentDir).mkdirs() && mkdir()));
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.621 -0400", hash_original_method = "B6F8DC1B8131115DA0E4E46657B89E08", hash_generated_method = "3D14B96A54A6BD560FF7B30FBEC07C1B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.622 -0400", hash_original_method = "FDC5D6D625B3CE9B182F17F4E03581A9", hash_generated_method = "7C73498116635C796B8710E78CAF4397")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean renameTo(File newPath) {
        dsTaint.addTaint(newPath.dsTaint);
        try 
        {
            Libcore.os.rename(path, newPath.path);
        } //End block
        catch (ErrnoException errnoException)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //Libcore.os.rename(path, newPath.path);
            //return true;
        //} catch (ErrnoException errnoException) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.622 -0400", hash_original_method = "2B0DBB93241DF37011E39BE4D10F6879", hash_generated_method = "15305831FB71587DAF0ECCB9EB7A7E7D")
    @DSModeled(DSC.SAFE)
    @Override
    public String toString() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return path;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.622 -0400", hash_original_method = "700C756497BE64476D6C692FA75956E5", hash_generated_method = "69B5A6121E958B16FF85798805F7B8C5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public URI toURI() {
        String name;
        name = getAbsoluteName();
        try 
        {
            {
                boolean var7CF5F60EBC5E2C901F827EF7830FC621_289517730 = (!name.startsWith("/"));
                {
                    URI var9BB60FAB2192D18B4EF03C63EB883D2D_162072844 = (new URI("file", null, "/" + name, null, null));
                } //End block
                {
                    boolean varE9B43904F9CC6A4F5AC7EEBE42EBAED2_1306106272 = (name.startsWith("//"));
                    {
                        URI var570B0F3D9E05BCCAEAD65F2562E706CD_735489505 = (new URI("file", "", name, null));
                    } //End block
                } //End collapsed parenthetic
            } //End collapsed parenthetic
            URI var632035A2550A30C387CA18CAF3CC2612_1562083154 = (new URI("file", null, name, null, null));
        } //End block
        catch (URISyntaxException e)
        { }
        return (URI)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.623 -0400", hash_original_method = "A697C8A8DDF3EFD4E15B0A56A47ADC60", hash_generated_method = "B6D4226C7BB3C64C18BCA3ED4D640C8D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public URL toURL() throws java.net.MalformedURLException {
        String name;
        name = getAbsoluteName();
        {
            boolean var3B7AB1EAFD7996D7CA57EDAFF1D8E8B9_1588890168 = (!name.startsWith("/"));
            {
                URL var64362FF0102A695513BDF865BA80AEF4_1458480468 = (new URL("file", "", -1, "/" + name, null));
            } //End block
            {
                boolean varB9723AF77574C7325A352568702E319A_668670211 = (name.startsWith("//"));
                {
                    URL varA27F7F5CA06EB8578481BA0394168132_1364059285 = (new URL("file:" + name));
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        URL varCF766E67C1ED3CB1A7F6847BBE7CF2B2_440242799 = (new URL("file", "", -1, name, null));
        return (URL)dsTaint.getTaint();
        // ---------- Original Method ----------
        //String name = getAbsoluteName();
        //if (!name.startsWith("/")) {
            //return new URL("file", "", -1, "/" + name, null);
        //} else if (name.startsWith("//")) {
            //return new URL("file:" + name); 
        //}
        //return new URL("file", "", -1, name, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.623 -0400", hash_original_method = "6DC10F50F559258D97A948A93E776D0B", hash_generated_method = "31AD46EDA17D495E084010D180017377")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String getAbsoluteName() {
        File f;
        f = getAbsoluteFile();
        String name;
        name = f.getPath();
        {
            boolean var43D90A838F59D75751D39C0CE0A07AE8_199730997 = (f.isDirectory() && name.charAt(name.length() - 1) != separatorChar);
            {
                name = name + "/";
            } //End block
        } //End collapsed parenthetic
        {
            name = name.replace(separatorChar, '/');
        } //End block
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.624 -0400", hash_original_method = "84E8B11DBED8384FBE25A5788F12F18C", hash_generated_method = "1004BBB43B0543E38697061DA05EF2B8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void writeObject(ObjectOutputStream stream) throws IOException {
        dsTaint.addTaint(stream.dsTaint);
        stream.defaultWriteObject();
        stream.writeChar(separatorChar);
        // ---------- Original Method ----------
        //stream.defaultWriteObject();
        //stream.writeChar(separatorChar);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.624 -0400", hash_original_method = "FED9F4FA8E5031FA72F265B39D2840EA", hash_generated_method = "FC0ADF7766F8541F19B3C495EA905469")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        dsTaint.addTaint(stream.dsTaint);
        stream.defaultReadObject();
        char inSeparator;
        inSeparator = stream.readChar();
        this.path = fixSlashes(path.replace(inSeparator, separatorChar));
        // ---------- Original Method ----------
        //stream.defaultReadObject();
        //char inSeparator = stream.readChar();
        //this.path = fixSlashes(path.replace(inSeparator, separatorChar));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.625 -0400", hash_original_method = "585308EC98C018F35D8810C372CB8328", hash_generated_method = "B17D0DCC3AF4EA87BDDA960B03AFCB4A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long getTotalSpace() {
        try 
        {
            StructStatFs sb;
            sb = Libcore.os.statfs(path);
        } //End block
        catch (ErrnoException errnoException)
        { }
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //try {
            //StructStatFs sb = Libcore.os.statfs(path);
            //return sb.f_blocks * sb.f_bsize; 
        //} catch (ErrnoException errnoException) {
            //return 0;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.628 -0400", hash_original_method = "14D64E7B25BCE5C0F5FB20D43EB644E7", hash_generated_method = "1B80380E884A212B264D83C68D824301")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long getUsableSpace() {
        try 
        {
            StructStatFs sb;
            sb = Libcore.os.statfs(path);
        } //End block
        catch (ErrnoException errnoException)
        { }
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //try {
            //StructStatFs sb = Libcore.os.statfs(path);
            //return sb.f_bavail * sb.f_bsize; 
        //} catch (ErrnoException errnoException) {
            //return 0;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.755 -0400", hash_original_method = "23B4E27185BC412B65C1DC7422116A5E", hash_generated_method = "20575D25F2B6A0A0D23FBB42BC1530A1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long getFreeSpace() {
        try 
        {
            StructStatFs sb;
            sb = Libcore.os.statfs(path);
        } //End block
        catch (ErrnoException errnoException)
        { }
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //try {
            //StructStatFs sb = Libcore.os.statfs(path);
            //return sb.f_bfree * sb.f_bsize; 
        //} catch (ErrnoException errnoException) {
            //return 0;
        //}
    }

    
    private static final long serialVersionUID = 301077366599181567L;
    private static final Random tempFileRandom = new Random();
    public static final char separatorChar;
    public static final String separator;
    public static final char pathSeparatorChar;
    public static final String pathSeparator;
    static {
        separatorChar = System.getProperty("file.separator", "/").charAt(0);
        pathSeparatorChar = System.getProperty("path.separator", ":").charAt(0);
        separator = String.valueOf(separatorChar);
        pathSeparator = String.valueOf(pathSeparatorChar);
    }
    
}

