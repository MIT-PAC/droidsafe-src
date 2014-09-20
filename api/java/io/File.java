package java.io;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
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

import droidsafe.helpers.DSUtils;

public class File implements Serializable, Comparable<File> {

    // Removes duplicate adjacent slashes and any trailing slash.
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:44.445 -0500", hash_original_method = "697F450BEC93E79C07B9CD1FF582F761", hash_generated_method = "3C3E10015E26D5B6A8A0B8197CDF731F")
    
private static String fixSlashes(String origPath) {
        // Remove duplicate adjacent slashes.
        
        return origPath;
        
/*        boolean lastWasSlash = false;
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
        // Remove any trailing slash (unless this is the root of the file system).
        if (lastWasSlash && newLength > 1) {
            newLength--;
        }
        // Reuse the original string if possible.
        return (newLength != length) ? new String(newPath, 0, newLength) : origPath;*/
    }

    // Joins two path components, adding a separator only if necessary.
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:44.447 -0500", hash_original_method = "778D2D76B8ECF025B166D37379F9F4F6", hash_generated_method = "31162CF3D2813878020700A2F7AB6098")
    
private static String join(String prefix, String suffix) {
        int prefixLength = prefix.length();
        boolean haveSlash = (prefixLength > 0 && prefix.charAt(prefixLength - 1) == separatorChar);
        if (!haveSlash) {
            haveSlash = (suffix.length() > 0 && suffix.charAt(0) == separatorChar);
        }
        return haveSlash ? (prefix + suffix) : (prefix + separatorChar + suffix);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:44.450 -0500", hash_original_method = "66A735BA68A634D4A7FA7C62964D6383", hash_generated_method = "CBABE2EEAC6A19A4D72F86BDC646B123")
    
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

    /**
     * Returns the file system roots. On Android and other Unix systems, there is
     * a single root, {@code /}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:44.453 -0500", hash_original_method = "25C36B1EFDAF6FF469C16DA6E3BE9FB2", hash_generated_method = "C4D71F0B354DF213A5E92DEF3BC677B6")
    
public static File[] listRoots() {
        return new File[] { new File("/") };
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static String realpath(String path) {
		return new String();
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static String readlink(String path) {
		return new String();
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static boolean setLastModifiedImpl(String path, long time) {
        return toTaintBoolean(((int)time + path.getTaintInt()));
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static String[] listImpl(String path) {
		return new String[]{"*.*" + path};
	}

    /**
     * Creates an empty temporary file using the given prefix and suffix as part
     * of the file name. If {@code suffix} is null, {@code .tmp} is used. This
     * method is a convenience method that calls
     * {@link #createTempFile(String, String, File)} with the third argument
     * being {@code null}.
     *
     * @param prefix
     *            the prefix to the temp file name.
     * @param suffix
     *            the suffix to the temp file name.
     * @return the temporary file.
     * @throws IOException
     *             if an error occurs when writing the file.
     */
    @DSComment("Method returns IO Object")
    @DSSpec(DSCat.IO)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:44.575 -0500", hash_original_method = "F35DD4D2E6395DF1DE5627BA1147A02F", hash_generated_method = "1887394672DF3A2517963CDA02015A8E")
    
public static File createTempFile(String prefix, String suffix) throws IOException {
        return createTempFile(prefix, suffix, null);
    }

    /**
     * Creates an empty temporary file in the given directory using the given
     * prefix and suffix as part of the file name. If {@code suffix} is null, {@code .tmp} is used.
     *
     * <p>Note that this method does <i>not</i> call {@link #deleteOnExit}, but see the
     * documentation for that method before you call it manually.
     *
     * @param prefix
     *            the prefix to the temp file name.
     * @param suffix
     *            the suffix to the temp file name.
     * @param directory
     *            the location to which the temp file is to be written, or
     *            {@code null} for the default location for temporary files,
     *            which is taken from the "java.io.tmpdir" system property. It
     *            may be necessary to set this property to an existing, writable
     *            directory for this method to work properly.
     * @return the temporary file.
     * @throws IllegalArgumentException
     *             if the length of {@code prefix} is less than 3.
     * @throws IOException
     *             if an error occurs when writing the file.
     */
    @DSComment("Method returns IO Object")
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:44.577 -0500", hash_original_method = "300A258AF9CE3367B2E987791B45E579", hash_generated_method = "5A12F0C33269F4818329EA209B0269C7")
    
public static File createTempFile(String prefix, String suffix, File directory)
            throws IOException {
        // Force a prefix null check first
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:44.414 -0500", hash_original_field = "A717B0E8BB8BB9C8749F8488C4A39112", hash_generated_field = "573261A4844452FF520B7BA941A9349A")

    private static final long serialVersionUID = 301077366599181567L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:44.417 -0500", hash_original_field = "71ABA57E9B6FC148FE35EF640D431287", hash_generated_field = "E9BF35C3AF9EB264C60B98A12F779A5F")

    private static final Random tempFileRandom = new Random();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:44.419 -0500", hash_original_field = "2B68204F7DF12B112653AA6BA91F1B43", hash_generated_field = "29AF355A40323D41E13A60AE4B413BAF")

    public static  char separatorChar;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:44.422 -0500", hash_original_field = "9B5B4672FF037607BB8CCE0F5B6469A8", hash_generated_field = "E1392EC387AB3DBDD9BD083C730593A3")

    public static  String separator;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:44.424 -0500", hash_original_field = "C8C0870D553B2FDB134BFEF10EF505BD", hash_generated_field = "21DB87A62EEC8BA87CEF544AB3B690C4")

    public static  char pathSeparatorChar;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:44.427 -0500", hash_original_field = "6BE2AF10E777193872E98F26779C3458", hash_generated_field = "73B014782B5AE687AFF72A95C3B82D1A")

    public static  String pathSeparator;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:44.429 -0500", hash_original_field = "4936DBCD90EF1129A7D9F03C4DB55EE0", hash_generated_field = "E58B218DC2BC9CF2BD65F7BE2F7C20BE")

    @DSVAModeled
    private String path;

    /**
     * Constructs a new file using the specified directory and name.
     *
     * @param dir
     *            the directory where the file is stored.
     * @param name
     *            the file's name.
     * @throws NullPointerException
     *             if {@code name} is {@code null}.
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:44.432 -0500", hash_original_method = "A8210D76C41C6A4AAFC6BE2371A42886", hash_generated_method = "C4F8D83E64C44160E188661FCFE7409A")
    
public File(File dir, String name) {
        this(dir == null ? null : dir.getPath(), name);
    }

    /**
     * Constructs a new file using the specified path.
     *
     * @param path
     *            the path to be used for the file.
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:44.435 -0500", hash_original_method = "2175D562A2B588CC53D616403013683C", hash_generated_method = "6E9FD4316F59D7CE7196381057C46B1A")
    
public File(String path) {
        this.path = fixSlashes(path);
    }

    /**
     * Constructs a new File using the specified directory path and file name,
     * placing a path separator between the two.
     *
     * @param dirPath
     *            the path to the directory where the file is stored.
     * @param name
     *            the file's name.
     * @throws NullPointerException
     *             if {@code name == null}.
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:44.439 -0500", hash_original_method = "133C96EC98AEE8D59630F091A182C267", hash_generated_method = "6F57CB283102230538221213F534B8CF")
    
public File(String dirPath, String name) {
        if (name == null) {
            throw new NullPointerException();
        }
        if (dirPath == null || dirPath.isEmpty()) {
            this.path = fixSlashes(name);
        } else if (name.isEmpty()) {
            this.path = fixSlashes(dirPath);
        } else {
            this.path = fixSlashes(join(dirPath, name));
        }
    }

    /**
     * Constructs a new File using the path of the specified URI. {@code uri}
     * needs to be an absolute and hierarchical Unified Resource Identifier with
     * file scheme and non-empty path component, but with undefined authority,
     * query or fragment components.
     *
     * @param uri
     *            the Unified Resource Identifier that is used to construct this
     *            file.
     * @throws IllegalArgumentException
     *             if {@code uri} does not comply with the conditions above.
     * @see #toURI
     * @see java.net.URI
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:44.442 -0500", hash_original_method = "8BC21AA0285296D0787FE6CED7AAF58D", hash_generated_method = "8D7B2025B352DFD259920003A0518A80")
    
public File(URI uri) {
        // check pre-conditions
        checkURI(uri);
        this.path = fixSlashes(uri.getPath());
    }

    /**
     * Tests whether or not this process is allowed to execute this file.
     * Note that this is a best-effort result; the only way to be certain is
     * to actually attempt the operation.
     *
     * @return {@code true} if this file can be executed, {@code false} otherwise.
     * @since 1.6
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:44.455 -0500", hash_original_method = "69AF6799D7AA8E2E8441037938ACC088", hash_generated_method = "871D1891F24D5F57AD2B962D4F6CB2C0")
    
public boolean canExecute() {
        return doAccess(X_OK);
    }

    /**
     * Indicates whether the current context is allowed to read from this file.
     *
     * @return {@code true} if this file can be read, {@code false} otherwise.
     */
    @DSComment("File Information")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:44.457 -0500", hash_original_method = "7B792954ECFC131D8AE4D0E193C4885E", hash_generated_method = "0EB677AB132959DC534CAC8C90D1B544")
    
public boolean canRead() {
        return doAccess(R_OK);
    }

    /**
     * Indicates whether the current context is allowed to write to this file.
     *
     * @return {@code true} if this file can be written, {@code false}
     *         otherwise.
     */
    @DSComment("File Information")
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:44.460 -0500", hash_original_method = "80B9F14946D459E582021E9E2F6280AD", hash_generated_method = "CF578D1B801A5F671FA69BBF6907AB62")
    
public boolean canWrite() {
        return doAccess(W_OK);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:44.462 -0500", hash_original_method = "66AEEE703F2A5FBBF7F14BCD3C8F63B9", hash_generated_method = "2D9999FA3CDD16B993F2AB1930A20D43")
    
private boolean doAccess(int mode) {
        try {
            return Libcore.os.access(path, mode);
        } catch (ErrnoException errnoException) {
            return false;
        }
    }

    /**
     * Returns the relative sort ordering of the paths for this file and the
     * file {@code another}. The ordering is platform dependent.
     *
     * @param another
     *            a file to compare this file to
     * @return an int determined by comparing the two paths. Possible values are
     *         described in the Comparable interface.
     * @see Comparable
     */
    @DSComment("no security concern")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:44.464 -0500", hash_original_method = "B9E553F90A7CDA44D1E185A0919015AC", hash_generated_method = "9246B5974DFCA41CBC6E6EB8589B0456")
    
public int compareTo(File another) {
        return this.getPath().compareTo(another.getPath());
    }

    /**
     * Deletes this file. Directories must be empty before they will be deleted.
     *
     * <p>Note that this method does <i>not</i> throw {@code IOException} on failure.
     * Callers must check the return value.
     *
     * @return {@code true} if this file was deleted, {@code false} otherwise.
     */
    @DSComment("Activity on IO class")
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:44.467 -0500", hash_original_method = "5CDCBB522AFEF90E14CEC34C413E4DF5", hash_generated_method = "846E399EF55FCBBB469502891E573429")
    
public boolean delete() {
        try {
            Libcore.os.remove(path);
            return true;
        } catch (ErrnoException errnoException) {
            return false;
        }
    }

    /**
     * Schedules this file to be automatically deleted when the VM terminates normally.
     *
     * <p><i>Note that on Android, the application lifecycle does not include VM termination,
     * so calling this method will not ensure that files are deleted</i>. Instead, you should
     * use the most appropriate out of:
     * <ul>
     * <li>Use a {@code finally} clause to manually invoke {@link #delete}.
     * <li>Maintain your own set of files to delete, and process it at an appropriate point
     * in your application's lifecycle.
     * <li>Use the Unix trick of deleting the file as soon as all readers and writers have
     * opened it. No new readers/writers will be able to access the file, but all existing
     * ones will still have access until the last one closes the file.
     * </ul>
     */
    @DSComment("IO movement methodName")
    @DSSpec(DSCat.IO_ACTION_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:44.469 -0500", hash_original_method = "CB1935EF5F2FD9C7C5DF0BCD9272AB92", hash_generated_method = "619F358CAF22F889A790A5205E70805E")
    
public void deleteOnExit() {
        DeleteOnExit.getInstance().addFile(getAbsolutePath());
    }

    /**
     * Compares {@code obj} to this file and returns {@code true} if they
     * represent the <em>same</em> object using a path specific comparison.
     *
     * @param obj
     *            the object to compare this file with.
     * @return {@code true} if {@code obj} is the same as this object,
     *         {@code false} otherwise.
     */
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:44.472 -0500", hash_original_method = "CB9025D33A83838782FA748F5EB00F53", hash_generated_method = "DF6CC618E6FEC2A320CD341AE4AF4C1F")
    
@Override
    public boolean equals(Object obj) {
        if (!(obj instanceof File)) {
            return false;
        }
        return path.equals(((File) obj).getPath());
    }

    /**
     * Returns a boolean indicating whether this file can be found on the
     * underlying file system.
     *
     * @return {@code true} if this file exists, {@code false} otherwise.
     */
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:44.474 -0500", hash_original_method = "D48176638CA08E926D8083B62CC7EB27", hash_generated_method = "F8A2DBAD4957C2E8530D4BBC1D7A1A43")
    
public boolean exists() {
        return doAccess(F_OK);
    }
    
    @DSComment("File Information")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.FILE_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.822 -0400", hash_original_method = "8F2B41FC4DF09EBF8497AC74B170E125", hash_generated_method = "C12A6EDB79539AA71068DD1E144D2E98")
    public String getAbsolutePath() {
        if(isAbsolute())        
        {
String var535F4D9720F3B0C96D8143873CE0638C_1405753140 =             path;
            var535F4D9720F3B0C96D8143873CE0638C_1405753140.addTaint(getTaint());
            return var535F4D9720F3B0C96D8143873CE0638C_1405753140;
        } //End block
        String userDir = "user.dir" + path;
        String var4F090B9F25B3E37BF995BFA6769B0207_1493143672 = userDir, path;
        var4F090B9F25B3E37BF995BFA6769B0207_1493143672.addTaint(getTaint());
        return var4F090B9F25B3E37BF995BFA6769B0207_1493143672;
        // ---------- Original Method ----------
        //if (isAbsolute()) {
            //return path;
        //}
        //String userDir = System.getProperty("user.dir");
        //return path.isEmpty() ? userDir : join(userDir, path);
    }

    /**
     * Returns a new file constructed using the absolute path of this file.
     * Equivalent to {@code new File(this.getAbsolutePath())}.
     */
    @DSComment("Method returns IO Object")
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:44.478 -0500", hash_original_method = "C817D7800025B01E09F67B96128B6FD2", hash_generated_method = "762253F33B1D9B859BA14BD84E373A66")
    
public File getAbsoluteFile() {
        return new File(getAbsolutePath());
    }

    /**
     * Returns the canonical path of this file.
     * An <i>absolute</i> path is one that begins at the root of the file system.
     * A <i>canonical</i> path is an absolute path with symbolic links
     * and references to "." or ".." resolved. If a path element does not exist (or
     * is not searchable), there is a conflict between interpreting canonicalization
     * as a textual operation (where "a/../b" is "b" even if "a" does not exist) .
     *
     * <p>Most callers should use {@link #getAbsolutePath} instead. A canonical path is
     * significantly more expensive to compute, and not generally useful. The primary
     * use for canonical paths is determining whether two paths point to the same file by
     * comparing the canonicalized paths.
     *
     * <p>It can be actively harmful to use a canonical path, specifically because
     * canonicalization removes symbolic links. It's wise to assume that a symbolic link
     * is present for a reason, and that that reason is because the link may need to change.
     * Canonicalization removes this layer of indirection. Good code should generally avoid
     * caching canonical paths.
     *
     * @return the canonical path of this file.
     * @throws IOException
     *             if an I/O error occurs.
     */
    @DSComment("File Information")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.FILE_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:44.482 -0500", hash_original_method = "2353D6268FF62C4AA3E4D2A85DA0DDFF", hash_generated_method = "3D68E5C98B6F0441D9B8857E875066A3")
    
public String getCanonicalPath() throws IOException {
        return realpath(getAbsolutePath());
    }

    /**
     * Returns a new file created using the canonical path of this file.
     * Equivalent to {@code new File(this.getCanonicalPath())}.
     *
     * @return the new file constructed from this file's canonical path.
     * @throws IOException
     *             if an I/O error occurs.
     */
    @DSComment("Method returns IO Object")
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:44.492 -0500", hash_original_method = "703FA6965000EF35DC5F6EF68FCCB383", hash_generated_method = "607D769DE09E9975A9BD8FE6BF604C70")
    
public File getCanonicalFile() throws IOException {
        return new File(getCanonicalPath());
    }

    /**
     * Returns the name of the file or directory represented by this file.
     *
     * @return this file's name or an empty string if there is no name part in
     *         the file's path.
     */
    @DSComment("File Information")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.FILE_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:44.495 -0500", hash_original_method = "6E20F332F3C7773E9502AE9F2437B5A6", hash_generated_method = "AB4E3BAE59DBA2943E712F2F58B340A9")
    
public String getName() {
        int separatorIndex = path.lastIndexOf(separator);
        return (separatorIndex < 0) ? path : path.substring(separatorIndex + 1, path.length());
    }

    /**
     * Returns the pathname of the parent of this file. This is the path up to
     * but not including the last name. {@code null} is returned if there is no
     * parent.
     *
     * @return this file's parent pathname or {@code null}.
     */
    @DSComment("File Information")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.FILE_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:44.497 -0500", hash_original_method = "160BE3FD42E1931950E2200B6303D787", hash_generated_method = "D19EE6AE71A6B9F0A19C9A50867DF716")
    
public String getParent() {
        int length = path.length(), firstInPath = 0;
        if (separatorChar == '\\' && length > 2 && path.charAt(1) == ':') {
            firstInPath = 2;
        }
        int index = path.lastIndexOf(separatorChar);
        if (index == -1 && firstInPath > 0) {
            index = 2;
        }
        if (index == -1 || path.charAt(length - 1) == separatorChar) {
            return null;
        }
        if (path.indexOf(separatorChar) == index
                && path.charAt(firstInPath) == separatorChar) {
            return path.substring(0, index + 1);
        }
        return path.substring(0, index);
    }

    /**
     * Returns a new file made from the pathname of the parent of this file.
     * This is the path up to but not including the last name. {@code null} is
     * returned when there is no parent.
     *
     * @return a new file representing this file's parent or {@code null}.
     */
    @DSComment("Method returns IO Object")
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:44.500 -0500", hash_original_method = "05B6D7D4A7E04D12316D2DAB95CF61C6", hash_generated_method = "87CB15FAAF0F4CE298C7CD4BD98EF741")
    
public File getParentFile() {
        String tempParent = getParent();
        if (tempParent == null) {
            return null;
        }
        return new File(tempParent);
    }

    /**
     * Returns the path of this file.
     *
     * @return this file's path.
     */
    @DSSource({DSSourceKind.FILE_INFORMATION})
    @DSComment("File Information")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:44.502 -0500", hash_original_method = "F862A3BA81BCB206C83E79C3BEB01336", hash_generated_method = "685DA06B3205BF0988B63E7E0C7CEB6C")
public String getPath() {
        return path;
    }

    /**
     * Returns an integer hash code for the receiver. Any two objects for which
     * {@code equals} returns {@code true} must return the same hash code.
     *
     * @return this files's hash value.
     * @see #equals
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:44.504 -0500", hash_original_method = "9D3CBE29781C2664F4636CCC28F83B76", hash_generated_method = "A10691391C760522DECD477F5CBA372A")
    
@Override
    public int hashCode() {
        return getPath().hashCode() ^ 1234321;
    }

    /**
     * Indicates if this file's pathname is absolute. Whether a pathname is
     * absolute is platform specific. On Android, absolute paths start with
     * the character '/'.
     *
     * @return {@code true} if this file's pathname is absolute, {@code false}
     *         otherwise.
     * @see #getPath
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:44.507 -0500", hash_original_method = "9F2931F68825A4578F9E89212BCAE059", hash_generated_method = "2E75DF42A48FEC873AC09333063133CF")
    
public boolean isAbsolute() {
        return toTaintBoolean(path.length() + path.charAt(0) + separatorChar);
    }

    /**
     * Indicates if this file represents a <em>directory</em> on the
     * underlying file system.
     *
     * @return {@code true} if this file is a directory, {@code false}
     *         otherwise.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:44.510 -0500", hash_original_method = "5A1A5CA8E31989238D097F162F5C184C", hash_generated_method = "D36D7BBF127F2983896837F632E4EBE0")
    
public boolean isDirectory() {
        try {
            return S_ISDIR(Libcore.os.stat(path).st_mode);
        } catch (ErrnoException errnoException) {
            // The RI returns false on error. (Even for errors like EACCES or ELOOP.)
            return false;
        }
    }

    /**
     * Indicates if this file represents a <em>file</em> on the underlying
     * file system.
     *
     * @return {@code true} if this file is a file, {@code false} otherwise.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:44.513 -0500", hash_original_method = "B5DE2229663641D636EF433E62C83E7A", hash_generated_method = "D28055B98E7DD2D66204F5D003B9EB24")
    
public boolean isFile() {
        try {
            return S_ISREG(Libcore.os.stat(path).st_mode);
        } catch (ErrnoException errnoException) {
            // The RI returns false on error. (Even for errors like EACCES or ELOOP.)
            return false;
        }
    }

    /**
     * Returns whether or not this file is a hidden file as defined by the
     * operating system. The notion of "hidden" is system-dependent. For Unix
     * systems a file is considered hidden if its name starts with a ".". For
     * Windows systems there is an explicit flag in the file system for this
     * purpose.
     *
     * @return {@code true} if the file is hidden, {@code false} otherwise.
     */
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:44.515 -0500", hash_original_method = "8D5680EC06296245D4F0DE9A90486B91", hash_generated_method = "38682CD78A90AEDA2EE3A2281092DE61")
    
public boolean isHidden() {
        if (path.isEmpty()) {
            return false;
        }
        return getName().startsWith(".");
    }

    /**
     * Returns the time when this file was last modified, measured in
     * milliseconds since January 1st, 1970, midnight.
     * Returns 0 if the file does not exist.
     *
     * @return the time when this file was last modified.
     */
    @DSComment("File Information")
    @DSSpec(DSCat.TRIGGER)
    @DSSource({DSSourceKind.FILE_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:44.517 -0500", hash_original_method = "0921E33485CFCA34C1412D0CC74585F6", hash_generated_method = "D860E5F1DFBA213A0282A688E6D70B62")
    
public long lastModified() {
        try {
            return Libcore.os.stat(path).st_mtime * 1000L;
        } catch (ErrnoException errnoException) {
            // The RI returns 0 on error. (Even for errors like EACCES or ELOOP.)
            return 0;
        }
    }

    /**
     * Sets the time this file was last modified, measured in milliseconds since
     * January 1st, 1970, midnight.
     *
     * <p>Note that this method does <i>not</i> throw {@code IOException} on failure.
     * Callers must check the return value.
     *
     * @param time
     *            the last modification time for this file.
     * @return {@code true} if the operation is successful, {@code false}
     *         otherwise.
     * @throws IllegalArgumentException
     *             if {@code time < 0}.
     */
    @DSComment("Activity on IO class")
    @DSSpec(DSCat.IO)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:44.519 -0500", hash_original_method = "9B75702C13A04EF9D2AD1E246C28DD45", hash_generated_method = "E25510CB69644BCC9EDEFC03E361A7CC")
    
public boolean setLastModified(long time) {
        if (time < 0) {
            throw new IllegalArgumentException("time < 0");
        }
        return setLastModifiedImpl(path, time);
    }

    /**
     * Equivalent to setWritable(false, false).
     *
     * @see #setWritable(boolean, boolean)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:44.526 -0500", hash_original_method = "A10D7182120D225C8A5565403EC4EFFE", hash_generated_method = "8A2B9B863D8D29185E8095812275FAE6")
    
public boolean setReadOnly() {
        return setWritable(false, false);
    }

    /**
     * Manipulates the execute permissions for the abstract path designated by
     * this file.
     *
     * <p>Note that this method does <i>not</i> throw {@code IOException} on failure.
     * Callers must check the return value.
     *
     * @param executable
     *            To allow execute permission if true, otherwise disallow
     * @param ownerOnly
     *            To manipulate execute permission only for owner if true,
     *            otherwise for everyone. The manipulation will apply to
     *            everyone regardless of this value if the underlying system
     *            does not distinguish owner and other users.
     * @return true if and only if the operation succeeded. If the user does not
     *         have permission to change the access permissions of this abstract
     *         pathname the operation will fail. If the underlying file system
     *         does not support execute permission and the value of executable
     *         is false, this operation will fail.
     * @since 1.6
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:44.529 -0500", hash_original_method = "6BD52A034BD79C942DD6922B1E4C88BF", hash_generated_method = "846DAA1FE59B7D0BD8818911AEF86CE4")
    
public boolean setExecutable(boolean executable, boolean ownerOnly) {
        return doChmod(ownerOnly ? S_IXUSR : (S_IXUSR | S_IXGRP | S_IXOTH), executable);
    }

    /**
     * Equivalent to setExecutable(executable, true).
     * @see #setExecutable(boolean, boolean)
     * @since 1.6
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:44.531 -0500", hash_original_method = "C14362B21605A10B0FC1769762B4B7C4", hash_generated_method = "76EA56D136285A936DF78C3CC7F031FE")
    
public boolean setExecutable(boolean executable) {
        return setExecutable(executable, true);
    }

    /**
     * Manipulates the read permissions for the abstract path designated by this
     * file.
     *
     * @param readable
     *            To allow read permission if true, otherwise disallow
     * @param ownerOnly
     *            To manipulate read permission only for owner if true,
     *            otherwise for everyone. The manipulation will apply to
     *            everyone regardless of this value if the underlying system
     *            does not distinguish owner and other users.
     * @return true if and only if the operation succeeded. If the user does not
     *         have permission to change the access permissions of this abstract
     *         pathname the operation will fail. If the underlying file system
     *         does not support read permission and the value of readable is
     *         false, this operation will fail.
     * @since 1.6
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:44.533 -0500", hash_original_method = "4618439ECB899A21431C9885F3874F0C", hash_generated_method = "F6CA3ED75EE2D9A55AE6FE511CEE0C49")
    
public boolean setReadable(boolean readable, boolean ownerOnly) {
        return doChmod(ownerOnly ? S_IRUSR : (S_IRUSR | S_IRGRP | S_IROTH), readable);
    }

    /**
     * Equivalent to setReadable(readable, true).
     * @see #setReadable(boolean, boolean)
     * @since 1.6
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:44.536 -0500", hash_original_method = "25CECE784879D9A6F63C12E2E495084D", hash_generated_method = "CB831F961B92F1F53F258BE584B5B45A")
    
public boolean setReadable(boolean readable) {
        return setReadable(readable, true);
    }

    /**
     * Manipulates the write permissions for the abstract path designated by this
     * file.
     *
     * @param writable
     *            To allow write permission if true, otherwise disallow
     * @param ownerOnly
     *            To manipulate write permission only for owner if true,
     *            otherwise for everyone. The manipulation will apply to
     *            everyone regardless of this value if the underlying system
     *            does not distinguish owner and other users.
     * @return true if and only if the operation succeeded. If the user does not
     *         have permission to change the access permissions of this abstract
     *         pathname the operation will fail.
     * @since 1.6
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:44.538 -0500", hash_original_method = "C7C84CA2ADD923BB8D9E9EBE2B4AA50C", hash_generated_method = "34D07E994BAF6ACE4C2A8B4FD73AA63E")
    
public boolean setWritable(boolean writable, boolean ownerOnly) {
        return doChmod(ownerOnly ? S_IWUSR : (S_IWUSR | S_IWGRP | S_IWOTH), writable);
    }

    /**
     * Equivalent to setWritable(writable, true).
     * @see #setWritable(boolean, boolean)
     * @since 1.6
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:44.540 -0500", hash_original_method = "0112F87387A0225E67147890BEDE5131", hash_generated_method = "2CE16D26B0CD2AB7F814C2524F473F43")
    
public boolean setWritable(boolean writable) {
        return setWritable(writable, true);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:44.543 -0500", hash_original_method = "1AE2CD7860321C46BB79C9D3B3E6342E", hash_generated_method = "5912B43ADAE800E83E77A983007838D8")
    
private boolean doChmod(int mask, boolean set) {
        try {
            StructStat sb = Libcore.os.stat(path);
            int newMode = set ? (sb.st_mode | mask) : (sb.st_mode & ~mask);
            Libcore.os.chmod(path, newMode);
            return true;
        } catch (ErrnoException errnoException) {
            return false;
        }
    }

    /**
     * Returns the length of this file in bytes.
     * Returns 0 if the file does not exist.
     * The result for a directory is not defined.
     *
     * @return the number of bytes in this file.
     */
    @DSComment("File Information")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:44.546 -0500", hash_original_method = "6E1602EC51AE975F6EDA687DC2872422", hash_generated_method = "0CD97CA24911DBF6FF7EFE61EEFD12E2")
    
public long length() {
        try {
            return Libcore.os.stat(path).st_size;
        } catch (ErrnoException errnoException) {
            // The RI returns 0 on error. (Even for errors like EACCES or ELOOP.)
            return 0;
        }
    }

    /**
     * Returns an array of strings with the file names in the directory
     * represented by this file. The result is {@code null} if this file is not
     * a directory.
     * <p>
     * The entries {@code .} and {@code ..} representing the current and parent
     * directory are not returned as part of the list.
     *
     * @return an array of strings with file names or {@code null}.
     */
    @DSSource({DSSourceKind.FILE_INFORMATION})
    @DSComment("Activity on IO class")
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:44.548 -0500", hash_original_method = "DC3A6B837A6CEBDAA6FC05976EEFEE9C", hash_generated_method = "C3F461AD4C3340BD933823AE6BD632D0")
    
public String[] list() {
        return listImpl(path);
    }

    /**
     * Gets a list of the files in the directory represented by this file. This
     * list is then filtered through a FilenameFilter and the names of files
     * with matching names are returned as an array of strings. Returns
     * {@code null} if this file is not a directory. If {@code filter} is
     * {@code null} then all filenames match.
     * <p>
     * The entries {@code .} and {@code ..} representing the current and parent
     * directories are not returned as part of the list.
     *
     * @param filter
     *            the filter to match names against, may be {@code null}.
     * @return an array of files or {@code null}.
     */
    @DSSource({DSSourceKind.FILE_INFORMATION})
    @DSComment("Activity on IO class")
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:44.555 -0500", hash_original_method = "9DF6733463E25DE92688E347FBBAD22E", hash_generated_method = "3C3A3CFC49EB3C95FA39F5723040A33C")
    
public String[] list(FilenameFilter filter) {
        String[] filenames = list();
        if (filter == null || filenames == null) {
            return filenames;
        }
        List<String> result = new ArrayList<String>(filenames.length);
        for (String filename : filenames) {
            if (filter.accept(this, filename)) {
                result.add(filename);
            }
        }
        return result.toArray(new String[result.size()]);
    }

    /**
     * Returns an array of files contained in the directory represented by this
     * file. The result is {@code null} if this file is not a directory. The
     * paths of the files in the array are absolute if the path of this file is
     * absolute, they are relative otherwise.
     *
     * @return an array of files or {@code null}.
     */
    @DSComment("Method returns IO Object")
    @DSSpec(DSCat.IO)
    @DSSource({DSSourceKind.FILE_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:44.557 -0500", hash_original_method = "9B953D65872590D8ABB7497D4B159A57", hash_generated_method = "02AE2C1C40DB6FEABA09D2EED581A218")
    
public File[] listFiles() {
        return filenamesToFiles(list());
    }

    /**
     * Gets a list of the files in the directory represented by this file. This
     * list is then filtered through a FilenameFilter and files with matching
     * names are returned as an array of files. Returns {@code null} if this
     * file is not a directory. If {@code filter} is {@code null} then all
     * filenames match.
     * <p>
     * The entries {@code .} and {@code ..} representing the current and parent
     * directories are not returned as part of the list.
     *
     * @param filter
     *            the filter to match names against, may be {@code null}.
     * @return an array of files or {@code null}.
     */
    @DSComment("Method returns IO Object")
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:44.559 -0500", hash_original_method = "94A37D22B56FB881F333055CF5969013", hash_generated_method = "915FAD761344385A2BCFAA4982F4BEE2")
    
public File[] listFiles(FilenameFilter filter) {
        return filenamesToFiles(list(filter));
    }

    /**
     * Gets a list of the files in the directory represented by this file. This
     * list is then filtered through a FileFilter and matching files are
     * returned as an array of files. Returns {@code null} if this file is not a
     * directory. If {@code filter} is {@code null} then all files match.
     * <p>
     * The entries {@code .} and {@code ..} representing the current and parent
     * directories are not returned as part of the list.
     *
     * @param filter
     *            the filter to match names against, may be {@code null}.
     * @return an array of files or {@code null}.
     */
    @DSComment("Method returns IO Object")
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:44.562 -0500", hash_original_method = "1FB8ED2C60AA91150D4C3211C8CB2AD8", hash_generated_method = "1F599671FB5A99CF35C65B016AE3135C")
    
public File[] listFiles(FileFilter filter) {
        File[] files = listFiles();
        if (filter == null || files == null) {
            return files;
        }
        List<File> result = new ArrayList<File>(files.length);
        for (File file : files) {
            if (filter.accept(file)) {
                result.add(file);
            }
        }
        return result.toArray(new File[result.size()]);
    }

    /**
     * Converts a String[] containing filenames to a File[].
     * Note that the filenames must not contain slashes.
     * This method is to remove duplication in the implementation
     * of File.list's overloads.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:44.564 -0500", hash_original_method = "7CC449D7C06EBE9C929936D878A8919D", hash_generated_method = "CD6036511F0CD6F301B7588427C26A96")
    
private File[] filenamesToFiles(String[] filenames) {
        if (filenames == null) {
            return null;
        }
        int count = filenames.length;
        File[] result = new File[count];
        for (int i = 0; i < count; ++i) {
            result[i] = new File(this, filenames[i]);
        }
        return result;
    }

    /**
     * Creates the directory named by the trailing filename of this file. Does
     * not create the complete path required to create this directory.
     *
     * <p>Note that this method does <i>not</i> throw {@code IOException} on failure.
     * Callers must check the return value.
     *
     * @return {@code true} if the directory has been created, {@code false}
     *         otherwise.
     * @see #mkdirs
     */
    @DSComment("Activity on IO class")
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:44.566 -0500", hash_original_method = "9AA9A2328E77BE45E90F159A380326D5", hash_generated_method = "0A065ADE1D040E425EF9A892E1097ECB")
    
public boolean mkdir() {
        try {
            // On Android, we don't want default permissions to allow global access.
            Libcore.os.mkdir(path, S_IRWXU);
            return true;
        } catch (ErrnoException errnoException) {
            return false;
        }
    }

    /**
     * Creates the directory named by the trailing filename of this file,
     * including the complete directory path required to create this directory.
     *
     * <p>Note that this method does <i>not</i> throw {@code IOException} on failure.
     * Callers must check the return value.
     *
     * @return {@code true} if the necessary directories have been created,
     *         {@code false} if the target directory already exists or one of
     *         the directories can not be created.
     * @see #mkdir
     */
    @DSComment("Activity on IO class")
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:44.569 -0500", hash_original_method = "0ED75208E22CDF6376FEADF6E55B44EF", hash_generated_method = "7BFF1F27222801DE4A24EF4A5B51C4ED")
    
public boolean mkdirs() {
        /* If the terminal directory already exists, answer false */
        if (exists()) {
            return false;
        }

        /* If the receiver can be created, answer true */
        if (mkdir()) {
            return true;
        }

        String parentDir = getParent();
        /* If there is no parent and we were not created, answer false */
        if (parentDir == null) {
            return false;
        }

        /* Otherwise, try to create a parent directory and then this directory */
        return toTaintBoolean(toTaintInt(new File(parentDir).mkdirs()) +
                              toTaintInt(mkdir()));
    }

    /**
     * Creates a new, empty file on the file system according to the path
     * information stored in this file. This method returns true if it creates
     * a file, false if the file already existed. Note that it returns false
     * even if the file is not a file (because it's a directory, say).
     *
     * <p>This method is not generally useful. For creating temporary files,
     * use {@link #createTempFile} instead. For reading/writing files, use {@link FileInputStream},
     * {@link FileOutputStream}, or {@link RandomAccessFile}, all of which can create files.
     *
     * <p>Note that this method does <i>not</i> throw {@code IOException} if the file
     * already exists, even if it's not a regular file. Callers should always check the
     * return value, and may additionally want to call {@link #isFile}.
     *
     * @return true if the file has been created, false if it
     *         already exists.
     * @throws IOException if it's not possible to create the file.
     */
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:44.572 -0500", hash_original_method = "B6F8DC1B8131115DA0E4E46657B89E08", hash_generated_method = "AD75715A5AEB9B279CC677EEA8B71771")
    
public boolean createNewFile() throws IOException {
        FileDescriptor fd = null;
        try {
            // On Android, we don't want default permissions to allow global access.
            fd = Libcore.os.open(path, O_RDWR | O_CREAT | O_EXCL, 0600);
            return true;
        } catch (ErrnoException errnoException) {
            if (errnoException.errno == EEXIST) {
                // The file already exists.
                return false;
            }
            throw errnoException.rethrowAsIOException();
        } finally {
            IoUtils.close(fd); // TODO: should we suppress IOExceptions thrown here?
        }
    }

    /**
     * Renames this file to {@code newPath}. This operation is supported for both
     * files and directories.
     *
     * <p>Many failures are possible. Some of the more likely failures include:
     * <ul>
     * <li>Write permission is required on the directories containing both the source and
     * destination paths.
     * <li>Search permission is required for all parents of both paths.
     * <li>Both paths be on the same mount point. On Android, applications are most likely to hit
     * this restriction when attempting to copy between internal storage and an SD card.
     * </ul>
     *
     * <p>Note that this method does <i>not</i> throw {@code IOException} on failure.
     * Callers must check the return value.
     *
     * @param newPath the new path.
     * @return true on success.
     */
    @DSComment("Activity on IO class")
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:44.580 -0500", hash_original_method = "FDC5D6D625B3CE9B182F17F4E03581A9", hash_generated_method = "7C1AE3A6CB934088A19AA981E3FB6DB0")
    
public boolean renameTo(File newPath) {
        try {
            Libcore.os.rename(path, newPath.path);
            return true;
        } catch (ErrnoException errnoException) {
            return false;
        }
    }

    /**
     * Returns a string containing a concise, human-readable description of this
     * file.
     *
     * @return a printable representation of this file.
     */
    @DSSource({DSSourceKind.FILE_INFORMATION})
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:44.583 -0500", hash_original_method = "2B0DBB93241DF37011E39BE4D10F6879", hash_generated_method = "26C57ED0CDB609D607D36CA3242D043F")
    
@Override
    public String toString() {
        return path;
    }
        
@DSComment("File Information")
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.857 -0400", hash_original_method = "700C756497BE64476D6C692FA75956E5", hash_generated_method = "83B703FD7718250D40AE9A9467D048ED")
    public URI toURI() {
        String name = getAbsoluteName();
        try 
        {
            if(!name.startsWith("/"))            
            {
URI var81CE9C8452AED16CEDF893615168C3D2_1760874075 =                 new URI("file", null, "/" + name, null, null);
                var81CE9C8452AED16CEDF893615168C3D2_1760874075.addTaint(getTaint());
                return var81CE9C8452AED16CEDF893615168C3D2_1760874075;
            } //End block
            else
            if(name.startsWith("//"))            
            {
URI var29D90A9A6DADA7CCD352DB7E1FC69FFB_1073480290 =                 new URI("file", "", name, null);
                var29D90A9A6DADA7CCD352DB7E1FC69FFB_1073480290.addTaint(getTaint());
                return var29D90A9A6DADA7CCD352DB7E1FC69FFB_1073480290;
            } //End block
URI varEF9537D825B1B2B07B3A54F3FC640952_313304114 =             new URI("file", null, name, null, null);
            varEF9537D825B1B2B07B3A54F3FC640952_313304114.addTaint(getTaint());
            return varEF9537D825B1B2B07B3A54F3FC640952_313304114;
        } //End block
        catch (URISyntaxException e)
        {
URI var540C13E9E156B687226421B24F2DF178_816445735 =             null;
            var540C13E9E156B687226421B24F2DF178_816445735.addTaint(getTaint());
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
        
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.858 -0400", hash_original_method = "A697C8A8DDF3EFD4E15B0A56A47ADC60", hash_generated_method = "54213675288BBAEBAE1CCF508D505953")
    @Deprecated
    public URL toURL() throws java.net.MalformedURLException {
        String name = getAbsoluteName();
        if(!name.startsWith("/"))        
        {
URL var347EE1274B4A53E8A16CAFF7EB7D3896_581746080 =             new URL("file", "", -1, "/" + name, null);
            var347EE1274B4A53E8A16CAFF7EB7D3896_581746080.addTaint(getTaint());
            return var347EE1274B4A53E8A16CAFF7EB7D3896_581746080;
        } //End block
        else
        if(name.startsWith("//"))        
        {
URL varB6E76567327A20845E8CD7E94383DAA5_1818859224 =             new URL("file:" + name);
            varB6E76567327A20845E8CD7E94383DAA5_1818859224.addTaint(getTaint());
            return varB6E76567327A20845E8CD7E94383DAA5_1818859224;
        } //End block
URL var9F0992E1CDD9692D51AE22365958494F_479158924 =         new URL("file", "", -1, name, null);
        var9F0992E1CDD9692D51AE22365958494F_479158924.addTaint(getTaint());
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

    // TODO: is this really necessary, or can it be replaced with getAbsolutePath?
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:44.591 -0500", hash_original_method = "6DC10F50F559258D97A948A93E776D0B", hash_generated_method = "43BB7D5D5C9A267DFD30E45C439351E4")
    
private String getAbsoluteName() {
        File f = getAbsoluteFile();
        String name = f.getPath();
        if (f.isDirectory() && name.charAt(name.length() - 1) != separatorChar) {
            // Directories must end with a slash
            name = name + "/";
        }
        if (separatorChar != '/') { // Must convert slashes.
            name = name.replace(separatorChar, '/');
        }
        return name;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:44.593 -0500", hash_original_method = "84E8B11DBED8384FBE25A5788F12F18C", hash_generated_method = "B1032A28D4FC10DA64CFD152C1DA706D")
    
private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
        stream.writeChar(separatorChar);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:44.596 -0500", hash_original_method = "FED9F4FA8E5031FA72F265B39D2840EA", hash_generated_method = "A8A7F8C580E8B6DA1583F7A37E65CB80")
    
private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        stream.defaultReadObject();
        char inSeparator = stream.readChar();
        this.path = fixSlashes(path.replace(inSeparator, separatorChar));
    }

    /**
     * Returns the total size in bytes of the partition containing this path.
     * Returns 0 if this path does not exist.
     *
     * @since 1.6
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:44.598 -0500", hash_original_method = "585308EC98C018F35D8810C372CB8328", hash_generated_method = "885E67B6330987DB56125FD6BBFE1E2D")
    
public long getTotalSpace() {
    	return (path.getTaintInt());
    }

    /**
     * Returns the number of usable free bytes on the partition containing this path.
     * Returns 0 if this path does not exist.
     *
     * <p>Note that this is likely to be an optimistic over-estimate and should not
     * be taken as a guarantee your application can actually write this many bytes.
     * On Android (and other Unix-based systems), this method returns the number of free bytes
     * available to non-root users, regardless of whether you're actually running as root,
     * and regardless of any quota or other restrictions that might apply to the user.
     * (The {@code getFreeSpace} method returns the number of bytes potentially available to root.)
     *
     * @since 1.6
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:44.601 -0500", hash_original_method = "14D64E7B25BCE5C0F5FB20D43EB644E7", hash_generated_method = "6CD8F121B9E4CDF5CEAEFF89549D249C")
    
public long getUsableSpace() {
    	return this.path.getTaintInt();
    }

    /**
     * Returns the number of free bytes on the partition containing this path.
     * Returns 0 if this path does not exist.
     *
     * <p>Note that this is likely to be an optimistic over-estimate and should not
     * be taken as a guarantee your application can actually write this many bytes.
     *
     * @since 1.6
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:44.603 -0500", hash_original_method = "23B4E27185BC412B65C1DC7422116A5E", hash_generated_method = "F52E291AFDE778BA59DB069A0EF655E5")
    
public long getFreeSpace() {
    	return path.getTaintInt();
    }
    static {
        separatorChar = '/';     //System.getProperty("file.separator", "/").charAt(0);
        pathSeparatorChar = ':'; //System.getProperty("path.separator", ":").charAt(0);
        separator = "/";         //String.valueOf(separatorChar);
        pathSeparator = ";";     //String.valueOf(pathSeparatorChar);
    }
    
}

