package java.io;

// Droidsafe Imports
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
// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import libcore.io.ErrnoException;
import libcore.io.IoUtils;
import libcore.io.Libcore;
import libcore.io.StructStat;
import libcore.io.StructStatFs;

import org.apache.harmony.luni.util.DeleteOnExit;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;
import droidsafe.helpers.DSUtils;
import droidsafe.runtime.DroidSafeAndroidRuntime;

public class File implements Serializable, Comparable<File> {
    private static final long serialVersionUID = 301077366599181567L;
    private static final Random tempFileRandom = new Random();
    public static final char separatorChar;
    public static final String separator;
    public static final char pathSeparatorChar;
    public static final String pathSeparator;
    private String path;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.442 -0400", hash_original_method = "A8210D76C41C6A4AAFC6BE2371A42886", hash_generated_method = "4CBBCE42215052E475C1E404B8196E7A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public File(File dir, String name) {
        this(dir == null ? null : dir.getPath(), name);
        dsTaint.addTaint(dir.dsTaint);
        dsTaint.addTaint(name);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.442 -0400", hash_original_method = "2175D562A2B588CC53D616403013683C", hash_generated_method = "B87CA57161E10C865E81EAF71B44541B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public File(String path) {
        dsTaint.addTaint(path);
        this.path = fixSlashes(path);
        // ---------- Original Method ----------
        //this.path = fixSlashes(path);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.443 -0400", hash_original_method = "133C96EC98AEE8D59630F091A182C267", hash_generated_method = "12BF6ED580D039BBAB8A32B88379A426")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public File(String dirPath, String name) {
        dsTaint.addTaint(dirPath);
        dsTaint.addTaint(name);
        {
        	if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        {
            boolean var522AFCE5CC8B40A2A75402BE5D6A8AB4_671275694 = (dirPath == null || dirPath.isEmpty());
            {
                this.path = fixSlashes(name);
            } //End block
            {
                boolean varC45442D5CAC21BA5127C6B3BB3F7C12C_655829318 = (name.isEmpty());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.443 -0400", hash_original_method = "8BC21AA0285296D0787FE6CED7AAF58D", hash_generated_method = "ED05238A2596D7F9F5599150B137DC9E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public File(URI uri) {
        dsTaint.addTaint(uri.dsTaint);
        checkURI(uri);
        this.path = fixSlashes(uri.getPath());
        // ---------- Original Method ----------
        //checkURI(uri);
        //this.path = fixSlashes(uri.getPath());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.443 -0400", hash_original_method = "697F450BEC93E79C07B9CD1FF582F761", hash_generated_method = "924F39BDF068DA872ABE76AAE88DD25F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.443 -0400", hash_original_method = "778D2D76B8ECF025B166D37379F9F4F6", hash_generated_method = "31162CF3D2813878020700A2F7AB6098")
    private static String join(String prefix, String suffix) {
        int prefixLength = prefix.length();
        boolean haveSlash = (prefixLength > 0 && prefix.charAt(prefixLength - 1) == separatorChar);
        if (!haveSlash) {
            haveSlash = (suffix.length() > 0 && suffix.charAt(0) == separatorChar);
        }
        return haveSlash ? (prefix + suffix) : (prefix + separatorChar + suffix);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.443 -0400", hash_original_method = "66A735BA68A634D4A7FA7C62964D6383", hash_generated_method = "CBABE2EEAC6A19A4D72F86BDC646B123")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.443 -0400", hash_original_method = "25C36B1EFDAF6FF469C16DA6E3BE9FB2", hash_generated_method = "C4D71F0B354DF213A5E92DEF3BC677B6")
    public static File[] listRoots() {
        return new File[] { new File("/") };
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.443 -0400", hash_original_method = "69AF6799D7AA8E2E8441037938ACC088", hash_generated_method = "EC05CBF7D22D4FDC74326B82060E9C03")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean canExecute() {
        boolean var11EACB11BCA61ED56E96A87B0CEEC84B_1150421138 = (doAccess(X_OK));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return doAccess(X_OK);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.443 -0400", hash_original_method = "7B792954ECFC131D8AE4D0E193C4885E", hash_generated_method = "57F3DAC1A65A41BAC6D2F03F708B18F1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean canRead() {
        boolean varE70EB23F73ADA6B237B4D65AC4B82C5A_1492023600 = (doAccess(R_OK));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return doAccess(R_OK);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.443 -0400", hash_original_method = "80B9F14946D459E582021E9E2F6280AD", hash_generated_method = "FE19718DB1E9114E7A0DE6E74DDCD68A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean canWrite() {
        boolean varDA123BCACBFFAE09BFEC6AFFB499FD36_793234907 = (doAccess(W_OK));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return doAccess(W_OK);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.443 -0400", hash_original_method = "66AEEE703F2A5FBBF7F14BCD3C8F63B9", hash_generated_method = "34281253F08F2D30C9420928196CFF19")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean doAccess(int mode) {
        dsTaint.addTaint(mode);
        try 
        {
            boolean varE1C8CEC7263488E3BB150496CD78C18E_1996082587 = (Libcore.os.access(path, mode));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.443 -0400", hash_original_method = "B9E553F90A7CDA44D1E185A0919015AC", hash_generated_method = "6440232CF2499A2D1B8F4CEDF5E92ACA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int compareTo(File another) {
        dsTaint.addTaint(another.dsTaint);
        int var6643EA56E785E991D6AF3A2A2A7F5979_1072629189 = (this.getPath().compareTo(another.getPath()));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return this.getPath().compareTo(another.getPath());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.443 -0400", hash_original_method = "5CDCBB522AFEF90E14CEC34C413E4DF5", hash_generated_method = "9117509D986A908C8384FD072C459F4B")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.443 -0400", hash_original_method = "CB1935EF5F2FD9C7C5DF0BCD9272AB92", hash_generated_method = "76963BA7E45A5D503FCB3EC96DC31AB4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void deleteOnExit() {
        DeleteOnExit.getInstance().addFile(getAbsolutePath());
        // ---------- Original Method ----------
        //DeleteOnExit.getInstance().addFile(getAbsolutePath());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.443 -0400", hash_original_method = "CB9025D33A83838782FA748F5EB00F53", hash_generated_method = "DAC88BB00F296B5ED0C4CF59C5F379E3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object obj) {
        dsTaint.addTaint(obj.dsTaint);
        boolean varCCDEE86E8E195B720CEBCF68075E8EAF_1170967354 = (path.equals(((File) obj).getPath()));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (!(obj instanceof File)) {
            //return false;
        //}
        //return path.equals(((File) obj).getPath());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.443 -0400", hash_original_method = "D48176638CA08E926D8083B62CC7EB27", hash_generated_method = "EA29888DABECA04F42103C3BDC4084C3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean exists() {
        boolean var3DC7BE7F0FA842D88DF3FAB30F500134_749099320 = (doAccess(F_OK));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return doAccess(F_OK);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.444 -0400", hash_original_method = "8F2B41FC4DF09EBF8497AC74B170E125", hash_generated_method = "568F4861BCE924118739D0232077791C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getAbsolutePath() {
        {
            boolean var40530E982042ED763A2119FF5384DF93_1922303995 = (isAbsolute());
        } //End collapsed parenthetic
        String userDir;
        userDir = System.getProperty("user.dir");
        {
            boolean varA747A2DF3E8CB4EAF5D9CDB3DF3D81CE_633657237 = (path.isEmpty());
            Object var2604BE65C5A596E7ACF1ED91EA2488E4_1909431952 = (join(userDir, path));
        } //End flattened ternary
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (isAbsolute()) {
            //return path;
        //}
        //String userDir = System.getProperty("user.dir");
        //return path.isEmpty() ? userDir : join(userDir, path);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.444 -0400", hash_original_method = "C817D7800025B01E09F67B96128B6FD2", hash_generated_method = "C19FF456F7EF1D192BA78AF226DCD8A2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public File getAbsoluteFile() {
        File var4F83F5FE5BD3095E287C4389DCEF49D9_431423177 = (new File(getAbsolutePath()));
        return (File)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new File(getAbsolutePath());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.444 -0400", hash_original_method = "2353D6268FF62C4AA3E4D2A85DA0DDFF", hash_generated_method = "DDC5E76DE13AF0268D88992C01E338B0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getCanonicalPath() throws IOException {
        String var32DE5438FB5A094857B1E7B7C48836B1_260723414 = (realpath(getAbsolutePath()));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return realpath(getAbsolutePath());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.444 -0400", hash_original_method = "46BEDE9A577C8371952DE0374BD98323", hash_generated_method = "61CE12A462943C45A00D6142E4F89789")
    private static String realpath(String path) {
    	return DSUtils.UNKNOWN_STRING;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.444 -0400", hash_original_method = "497A174E70F7C86705EB0CD57A444934", hash_generated_method = "69FF61E9FC04E3BAD3A2707E337C00FC")
    private static String readlink(String path) {
    	return DSUtils.UNKNOWN_STRING;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.444 -0400", hash_original_method = "703FA6965000EF35DC5F6EF68FCCB383", hash_generated_method = "27789B702FC9A7E5D0B1D8B208FED58C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public File getCanonicalFile() throws IOException {
        File varD619CAF119FD6F0798AFAFC7C2F24EC2_1298084926 = (new File(getCanonicalPath()));
        return (File)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new File(getCanonicalPath());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.444 -0400", hash_original_method = "6E20F332F3C7773E9502AE9F2437B5A6", hash_generated_method = "DEADD3879A893BFA4330F3F71587E0C5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getName() {
        int separatorIndex;
        separatorIndex = path.lastIndexOf(separator);
        {
            Object varCBF9AF8C8E610E7A4D651D386D35C04D_905188971 = (path.substring(separatorIndex + 1, path.length()));
        } //End flattened ternary
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //int separatorIndex = path.lastIndexOf(separator);
        //return (separatorIndex < 0) ? path : path.substring(separatorIndex + 1, path.length());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.444 -0400", hash_original_method = "160BE3FD42E1931950E2200B6303D787", hash_generated_method = "CBDA9AEB1BE6DE2BB1922DD860513423")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getParent() {
        int length, firstInPath;
        length = path.length();
        firstInPath = 0;
        {
            boolean var863DBDB94E3E0C1E688E23D6337C055A_1104326475 = (separatorChar == '\\' && length > 2 && path.charAt(1) == ':');
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
            boolean var5FAB5682D222D850607AC8A1318BB400_809103178 = (index == -1 || path.charAt(length - 1) == separatorChar);
        } //End collapsed parenthetic
        {
            boolean var343245EEE7F8E8A5D373797FE3BDF63A_1038848010 = (path.indexOf(separatorChar) == index
                && path.charAt(firstInPath) == separatorChar);
            {
                String var158C9DB8998BBDD3E76AAD2E14D2A416_1620346921 = (path.substring(0, index + 1));
            } //End block
        } //End collapsed parenthetic
        String varF6A588DA40C8B48DA6B02AA2C475E395_261584113 = (path.substring(0, index));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.444 -0400", hash_original_method = "05B6D7D4A7E04D12316D2DAB95CF61C6", hash_generated_method = "20B0AB630D9F5D28C83244533D095323")
    @DSModeled(DSC.SAFE)
    public File getParentFile() {
        String tempParent;
        tempParent = getParent();
        return (File)dsTaint.getTaint();
        // ---------- Original Method ----------
        //String tempParent = getParent();
        //if (tempParent == null) {
            //return null;
        //}
        //return new File(tempParent);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.444 -0400", hash_original_method = "F862A3BA81BCB206C83E79C3BEB01336", hash_generated_method = "88D7B1D66F9B17ED94509EA59BB3DBF7")
    @DSModeled(DSC.SAFE)
    public String getPath() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return path;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.444 -0400", hash_original_method = "9D3CBE29781C2664F4636CCC28F83B76", hash_generated_method = "C047274898782FBB53AB1F979418AE0F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int hashCode() {
        int var4C9E48E0C9F3F2F1C840C74BEE9A825F_1898682973 = (getPath().hashCode() ^ 1234321);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return getPath().hashCode() ^ 1234321;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.444 -0400", hash_original_method = "9F2931F68825A4578F9E89212BCAE059", hash_generated_method = "17A10CD56ED7D5A39D810C81A8A5398A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isAbsolute() {
        boolean varDB79D8CAC4C2DC7A32AE3E7DAD7DA818_216988978 = (path.length() > 0 && path.charAt(0) == separatorChar);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return path.length() > 0 && path.charAt(0) == separatorChar;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.444 -0400", hash_original_method = "5A1A5CA8E31989238D097F162F5C184C", hash_generated_method = "FE32AA65C1CA2DD92F62FCE3A835AA6D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isDirectory() {
        try 
        {
            boolean var6AC74137E657BFBDC734D05A25089622_543701655 = (S_ISDIR(Libcore.os.stat(path).st_mode));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.445 -0400", hash_original_method = "B5DE2229663641D636EF433E62C83E7A", hash_generated_method = "D753172588A35883FE0F7C15DBD6F11E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isFile() {
        try 
        {
            boolean var14FAC7C6C345F2015B4501A8E995DD2F_1249950262 = (S_ISREG(Libcore.os.stat(path).st_mode));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.445 -0400", hash_original_method = "8D5680EC06296245D4F0DE9A90486B91", hash_generated_method = "7779C3FFF03D639D1F2311BF4954B86F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isHidden() {
        {
            boolean varA747A2DF3E8CB4EAF5D9CDB3DF3D81CE_673558853 = (path.isEmpty());
        } //End collapsed parenthetic
        boolean varECBEA0E755D64DBD137B22ECA70830D2_1990330070 = (getName().startsWith("."));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (path.isEmpty()) {
            //return false;
        //}
        //return getName().startsWith(".");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.445 -0400", hash_original_method = "0921E33485CFCA34C1412D0CC74585F6", hash_generated_method = "14DB81277498530E6202D8E41E4AA931")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long lastModified() {
        try 
        {
            long var98E9A747C7267ABB1ADEE4EE0674948C_122389115 = (Libcore.os.stat(path).st_mtime * 1000L);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.445 -0400", hash_original_method = "9B75702C13A04EF9D2AD1E246C28DD45", hash_generated_method = "D7412C63933EACD3566204A8A0F16649")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean setLastModified(long time) {
        dsTaint.addTaint(time);
        {
        	if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("time < 0");
        } //End block
        boolean varC4720CBC7FAA490EA21CC63802D3E053_1382396727 = (setLastModifiedImpl(path, time));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (time < 0) {
            //throw new IllegalArgumentException("time < 0");
        //}
        //return setLastModifiedImpl(path, time);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.445 -0400", hash_original_method = "570E605E6B82F4BA53E369D5C65196C5", hash_generated_method = "950DE424684D89A5A33871114C791681")
    private static boolean setLastModifiedImpl(String path, long time) {
    	return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.445 -0400", hash_original_method = "A10D7182120D225C8A5565403EC4EFFE", hash_generated_method = "21EF51E9C438725AEA801AFE22951071")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean setReadOnly() {
        boolean var2207B650E4763A2B2533AEE20A1ED73D_789779291 = (setWritable(false, false));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return setWritable(false, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.445 -0400", hash_original_method = "6BD52A034BD79C942DD6922B1E4C88BF", hash_generated_method = "2DE810D3E975261FD5A2EAD54008BD1A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean setExecutable(boolean executable, boolean ownerOnly) {
        dsTaint.addTaint(executable);
        dsTaint.addTaint(ownerOnly);
        boolean varE7D48606C7C85663E76F2F7A25E0A393_46113807 = (doChmod(ownerOnly ? S_IXUSR : (S_IXUSR | S_IXGRP | S_IXOTH), executable)); //DSFIXME:  CODE0008: Nested ternary operator in expression
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return doChmod(ownerOnly ? S_IXUSR : (S_IXUSR | S_IXGRP | S_IXOTH), executable);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.445 -0400", hash_original_method = "C14362B21605A10B0FC1769762B4B7C4", hash_generated_method = "7B6E9C1EA89C17DE01562C201466A872")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean setExecutable(boolean executable) {
        dsTaint.addTaint(executable);
        boolean varA4BAA13E37DA9069F7C7E719CB0FE8CC_304660129 = (setExecutable(executable, true));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return setExecutable(executable, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.445 -0400", hash_original_method = "4618439ECB899A21431C9885F3874F0C", hash_generated_method = "AD37EE689C8FA5EC6BB7E22E5AEA0EF8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean setReadable(boolean readable, boolean ownerOnly) {
        dsTaint.addTaint(readable);
        dsTaint.addTaint(ownerOnly);
        boolean var5C11E9C261FABB343952CE11090CFB2B_1003712844 = (doChmod(ownerOnly ? S_IRUSR : (S_IRUSR | S_IRGRP | S_IROTH), readable)); //DSFIXME:  CODE0008: Nested ternary operator in expression
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return doChmod(ownerOnly ? S_IRUSR : (S_IRUSR | S_IRGRP | S_IROTH), readable);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.445 -0400", hash_original_method = "25CECE784879D9A6F63C12E2E495084D", hash_generated_method = "93C4C688C77CAFC82570785F36619C4F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean setReadable(boolean readable) {
        dsTaint.addTaint(readable);
        boolean var1EB034476AE7B9DE3A44A8EDA359DB4A_572779640 = (setReadable(readable, true));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return setReadable(readable, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.445 -0400", hash_original_method = "C7C84CA2ADD923BB8D9E9EBE2B4AA50C", hash_generated_method = "C26BE2CC001B202A3E6F06118836AFA8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean setWritable(boolean writable, boolean ownerOnly) {
        dsTaint.addTaint(writable);
        dsTaint.addTaint(ownerOnly);
        boolean var2B456D826A2D8464A1C5648BA8B179E5_234879956 = (doChmod(ownerOnly ? S_IWUSR : (S_IWUSR | S_IWGRP | S_IWOTH), writable)); //DSFIXME:  CODE0008: Nested ternary operator in expression
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return doChmod(ownerOnly ? S_IWUSR : (S_IWUSR | S_IWGRP | S_IWOTH), writable);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.445 -0400", hash_original_method = "0112F87387A0225E67147890BEDE5131", hash_generated_method = "ECDA5F25FB4187B2D8C5BE59EB2AC61E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean setWritable(boolean writable) {
        dsTaint.addTaint(writable);
        boolean var16EE60A060ACAE8B25D2293C6A6A7935_1525716968 = (setWritable(writable, true));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return setWritable(writable, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.445 -0400", hash_original_method = "1AE2CD7860321C46BB79C9D3B3E6342E", hash_generated_method = "1FA2489784066C23820055CD96EC198C")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.445 -0400", hash_original_method = "6E1602EC51AE975F6EDA687DC2872422", hash_generated_method = "3FCB8DD71BA5E0162D6EDF3E1B14EACA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long length() {
        try 
        {
            long var9DB83E12CA4626330CD62F63533A5F87_1076395089 = (Libcore.os.stat(path).st_size);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.446 -0400", hash_original_method = "DC3A6B837A6CEBDAA6FC05976EEFEE9C", hash_generated_method = "1686F271534D5288BDBAFE26F46F1A03")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String[] list() {
        String[] var0B058FF722837311DF9F21220E58AB96_994942439 = (listImpl(path));
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //return listImpl(path);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.446 -0400", hash_original_method = "2878623B07645019283057565E59E975", hash_generated_method = "B7C11F20333397C0B0830B9BF70D88CA")
    private static String[] listImpl(String path) {
    	return new String[] {DSUtils.UNKNOWN_STRING};
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.446 -0400", hash_original_method = "9DF6733463E25DE92688E347FBBAD22E", hash_generated_method = "E23BD79D549DCB615DA48FBFD31FC58C")
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
                    boolean var81601EE8E283E32D6B2251267018272D_378537447 = (filter.accept(this, filename));
                    {
                        result.add(filename);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        String[] varADD55AC2D00220D2A7FD16059C35D687_1025538363 = (result.toArray(new String[result.size()]));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.446 -0400", hash_original_method = "9B953D65872590D8ABB7497D4B159A57", hash_generated_method = "77BF3FE2BDD21EEE67EF029D5099A76E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public File[] listFiles() {
        File[] varADD500C5212AB3579E2ED89D0CDDE87D_1388021141 = (filenamesToFiles(list()));
        return (File[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //return filenamesToFiles(list());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.446 -0400", hash_original_method = "94A37D22B56FB881F333055CF5969013", hash_generated_method = "7E76DABD92108963439FC0919C005D4C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public File[] listFiles(FilenameFilter filter) {
        dsTaint.addTaint(filter.dsTaint);
        File[] var447E03466BB3647D36CFC65297E02A03_2092441640 = (filenamesToFiles(list(filter)));
        return (File[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //return filenamesToFiles(list(filter));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.446 -0400", hash_original_method = "1FB8ED2C60AA91150D4C3211C8CB2AD8", hash_generated_method = "8A3AD61B4582D10C5BB7E185B57DF831")
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
                    boolean var03D1D21AA056B6A17B9A8B3C581BEF3E_1949294856 = (filter.accept(file));
                    {
                        result.add(file);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        File[] var9AFAA4289A50507019102F4E1FE53897_1139220618 = (result.toArray(new File[result.size()]));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.446 -0400", hash_original_method = "7CC449D7C06EBE9C929936D878A8919D", hash_generated_method = "8883420F230BE4F6F1E3392D6C50F04E")
    @DSModeled(DSC.SAFE)
    private File[] filenamesToFiles(String[] filenames) {
        dsTaint.addTaint(filenames);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.446 -0400", hash_original_method = "9AA9A2328E77BE45E90F159A380326D5", hash_generated_method = "CBCCD60B32BC6B70FBA0A31A12DA24E7")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.446 -0400", hash_original_method = "0ED75208E22CDF6376FEADF6E55B44EF", hash_generated_method = "516E9E02D83450CCEE53F06BD5FCC269")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean mkdirs() {
        {
            boolean varE013DE3A7A1EF9C151970630934B77B9_602250717 = (exists());
        } //End collapsed parenthetic
        {
            boolean varAB3FB019EC81204DE93169D3E3914AF2_195779747 = (mkdir());
        } //End collapsed parenthetic
        String parentDir;
        parentDir = getParent();
        boolean var8762E100442E02162B81EA5619FDCADC_1239444102 = ((new File(parentDir).mkdirs() && mkdir()));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.447 -0400", hash_original_method = "B6F8DC1B8131115DA0E4E46657B89E08", hash_generated_method = "ABC36173816E4D2F825D1A9AF470E793")
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
            throw errnoException.rethrowAsIOException();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.447 -0400", hash_original_method = "F35DD4D2E6395DF1DE5627BA1147A02F", hash_generated_method = "1887394672DF3A2517963CDA02015A8E")
    public static File createTempFile(String prefix, String suffix) throws IOException {
        return createTempFile(prefix, suffix, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.447 -0400", hash_original_method = "300A258AF9CE3367B2E987791B45E579", hash_generated_method = "B7C56B4555F08191D6DE00DD3855CA3D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.447 -0400", hash_original_method = "FDC5D6D625B3CE9B182F17F4E03581A9", hash_generated_method = "7315F93A6230B43E893873A79FCA13AB")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.447 -0400", hash_original_method = "2B0DBB93241DF37011E39BE4D10F6879", hash_generated_method = "2ECA4A84F94FE48555645630C59E58BB")
    @DSModeled(DSC.SAFE)
    @Override
    public String toString() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return path;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.447 -0400", hash_original_method = "700C756497BE64476D6C692FA75956E5", hash_generated_method = "561CDCFA60D85A641D38375A70297616")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public URI toURI() {
        String name;
        name = getAbsoluteName();
        try 
        {
            {
            	URI uri = new URI("file", "", name, null);
                boolean var7CF5F60EBC5E2C901F827EF7830FC621_1195051356 = (!name.startsWith("/"));
                {
                    boolean varE9B43904F9CC6A4F5AC7EEBE42EBAED2_488196754 = (name.startsWith("//"));
                } //End collapsed parenthetic
            } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.447 -0400", hash_original_method = "A697C8A8DDF3EFD4E15B0A56A47ADC60", hash_generated_method = "411749A317C57997FF8DCB7680A90C8F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public URL toURL() throws java.net.MalformedURLException {
        String name;
        name = getAbsoluteName();
        {
            boolean var3B7AB1EAFD7996D7CA57EDAFF1D8E8B9_785860295 = (!name.startsWith("/"));
            {
                boolean varB9723AF77574C7325A352568702E319A_819243853 = (name.startsWith("//"));
            } //End collapsed parenthetic
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.447 -0400", hash_original_method = "6DC10F50F559258D97A948A93E776D0B", hash_generated_method = "EF2612560A5402E2CF88A88D8513D31E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String getAbsoluteName() {
        File f;
        f = getAbsoluteFile();
        String name;
        name = f.getPath();
        {
            boolean var43D90A838F59D75751D39C0CE0A07AE8_1460718252 = (f.isDirectory() && name.charAt(name.length() - 1) != separatorChar);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.447 -0400", hash_original_method = "84E8B11DBED8384FBE25A5788F12F18C", hash_generated_method = "91BB5563C87BBCE9DEC0288E5662E838")
    @DSModeled(DSC.SAFE)
    private void writeObject(ObjectOutputStream stream) throws IOException {
        dsTaint.addTaint(stream.dsTaint);
        stream.defaultWriteObject();
        stream.writeChar(separatorChar);
        // ---------- Original Method ----------
        //stream.defaultWriteObject();
        //stream.writeChar(separatorChar);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.447 -0400", hash_original_method = "FED9F4FA8E5031FA72F265B39D2840EA", hash_generated_method = "69ABAAC208789999FBC602A4CE419DF9")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.447 -0400", hash_original_method = "585308EC98C018F35D8810C372CB8328", hash_generated_method = "AC8EDBBECE05F13F2ACC88E39596A3D9")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.447 -0400", hash_original_method = "14D64E7B25BCE5C0F5FB20D43EB644E7", hash_generated_method = "5B11869FDC31327F9BB2D3E8D3CF9822")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.448 -0400", hash_original_method = "23B4E27185BC412B65C1DC7422116A5E", hash_generated_method = "8E58BB49C5BDD23BA93850A9B501F6F9")
    @DSModeled(DSC.SAFE)
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

    
    static {
        separatorChar = System.getProperty("file.separator", "/").charAt(0);
        pathSeparatorChar = System.getProperty("path.separator", ":").charAt(0);
        separator = String.valueOf(separatorChar);
        pathSeparator = String.valueOf(pathSeparatorChar);
    }
    
}


