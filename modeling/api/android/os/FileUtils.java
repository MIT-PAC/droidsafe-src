package android.os;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.regex.Pattern;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;

import droidsafe.helpers.DSUtils;

public class FileUtils {
    
    /**
     * Get the status for the given path. This is equivalent to the POSIX stat(2) system call. 
     * @param path The path of the file to be stat'd.
     * @param status Optional argument to fill in. It will only fill in the status if the file
     * exists. 
     * @return true if the file exists and false if it does not exist. If you do not have 
     * permission to stat the file, then this method will return false.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:28.057 -0500", hash_original_method = "52F69AC4093C03E777560ACE07D1F17A", hash_generated_method = "1C9367A5529F4286E207298D4FF44297")
    
public static boolean getFileStatus(String path, FileStatus status) {
        StrictMode.noteDiskRead();
        return getFileStatusNative(path, status);
    }
    
    private static boolean getFileStatusNative(String path, FileStatus status) {
        status.addTaint(path.getTaint());
        return status.getTaintBoolean();
    }
    
    public static int setPermissions(String file, int mode, int uid, int gid) {
        file.addTaint(mode + uid + gid);
        return file.getTaintInt();
    }
    
    public static int getPermissions(String file, int[] outPermissions) {
        outPermissions[0] = file.getTaintInt();
        return outPermissions.getTaintInt();
    }
    
    public static int setUMask(int mask) {
        return mask;
    }
    
    public static int getFatVolumeId(String mountPoint) {
        return mountPoint.getTaintInt();
    }

    /**
     * Perform an fsync on the given FileOutputStream.  The stream at this
     * point must be flushed but not yet closed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:28.081 -0500", hash_original_method = "3729C161BCA0FC1AAAEBF21C0BD668CD", hash_generated_method = "2E490ECF0C5FB204E077B0A60C07CFA0")
    
public static boolean sync(FileOutputStream stream) {
        try {
            if (stream != null) {
                stream.getFD().sync();
            }
            return true;
        } catch (IOException e) {
        }
        return false;
    }

    // copy a file from srcFile to destFile, return true if succeed, return
    // false if fail
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:28.083 -0500", hash_original_method = "CC9BE87F74B18E73F18C50ADB4F7E085", hash_generated_method = "078D8872A14105C3472A0E41AB758576")
    
public static boolean copyFile(File srcFile, File destFile) {
        boolean result = false;
        try {
            InputStream in = new FileInputStream(srcFile);
            try {
                result = copyToFile(in, destFile);
            } finally  {
                in.close();
            }
        } catch (IOException e) {
            result = false;
        }
        return result;
    }
    
    /**
     * Copy data from a source stream to destFile.
     * Return true if succeed, return false if failed.
     */
    @DSSink({DSSinkKind.FILE})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:28.086 -0500", hash_original_method = "75A6708119FD051685C400EDBE70E7B1", hash_generated_method = "FA5E98C53996F1C8C9BECBAA845B2245")
    
public static boolean copyToFile(InputStream inputStream, File destFile) {
        try {
            if (destFile.exists()) {
                destFile.delete();
            }
            FileOutputStream out = new FileOutputStream(destFile);
            try {
                byte[] buffer = new byte[4096];
                int bytesRead;
                while ((bytesRead = inputStream.read(buffer)) >= 0) {
                    out.write(buffer, 0, bytesRead);
                }
            } finally {
                out.flush();
                try {
                    out.getFD().sync();
                } catch (IOException e) {
                }
                out.close();
            }
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    /**
     * Check if a filename is "safe" (no metacharacters or spaces).
     * @param file  The file to check
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:28.088 -0500", hash_original_method = "2A2F8FB5411E4566B3A86B15AD79DAB4", hash_generated_method = "7C058DE2980D8DBEF6B60FDEC890F224")
    
public static boolean isFilenameSafe(File file) {
        // Note, we check whether it matches what's known to be safe,
        // rather than what's known to be unsafe.  Non-ASCII, control
        // characters, etc. are all unsafe by default.
        return SAFE_FILENAME_PATTERN.matcher(file.getPath()).matches();
    }

    /**
     * Read a text file into a String, optionally limiting the length.
     * @param file to read (will not seek, so things like /proc files are OK)
     * @param max length (positive for head, negative of tail, 0 for no limit)
     * @param ellipsis to add of the file was truncated (can be null)
     * @return the contents of the file, possibly truncated
     * @throws IOException if something goes wrong reading the file
     */
    @DSSink({DSSinkKind.FILE})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:28.091 -0500", hash_original_method = "E16E904B564260AEFFEF8BC8F6F4E16A", hash_generated_method = "311465B2200E7484981B486871B50005")
    
public static String readTextFile(File file, int max, String ellipsis) throws IOException {
        InputStream input = new FileInputStream(file);
        try {
            long size = file.length();
            if (max > 0 || (size > 0 && max == 0)) {  // "head" mode: read the first N bytes
                if (size > 0 && (max == 0 || size < max)) max = (int) size;
                byte[] data = new byte[max + 1];
                int length = input.read(data);
                if (length <= 0) return "";
                if (length <= max) return new String(data, 0, length);
                if (ellipsis == null) return new String(data, 0, max);
                return new String(data, 0, max) + ellipsis;
            } else if (max < 0) {  // "tail" mode: keep the last N
                int len;
                boolean rolled = false;
                byte[] last = null, data = null;
                do {
                    if (last != null) rolled = true;
                    byte[] tmp = last; last = data; data = tmp;
                    if (data == null) data = new byte[-max];
                    len = input.read(data);
                } while (len == data.length);

                if (last == null && len <= 0) return "";
                if (last == null) return new String(data, 0, len);
                if (len > 0) {
                    rolled = true;
                    System.arraycopy(last, len, last, 0, last.length - len);
                    System.arraycopy(data, 0, last, last.length - len, len);
                }
                if (ellipsis == null || !rolled) return new String(last);
                return ellipsis + new String(last);
            } else {  // "cat" mode: size unknown, read it all in streaming fashion
                ByteArrayOutputStream contents = new ByteArrayOutputStream();
                int len;
                byte[] data = new byte[1024];
                do {
                    len = input.read(data);
                    if (len > 0) contents.write(data, 0, len);
                } while (len == data.length);
                return contents.toString();
            }
        } finally {
            input.close();
        }
    }

   /**
     * Writes string to file. Basically same as "echo -n $string > $filename"
     *
     * @param filename
     * @param string
     * @throws IOException
     */
    @DSSink({DSSinkKind.FILE})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:28.094 -0500", hash_original_method = "F847A87F54B2C1AF9220E117BEF97E96", hash_generated_method = "D3453BFCD0BC9D1F554A950B1C0DBA5D")
    
public static void stringToFile(String filename, String string) throws IOException {
        FileWriter out = new FileWriter(filename);
        try {
            out.write(string);
        } finally {
            out.close();
        }
    }

    /**
     * Computes the checksum of a file using the CRC32 checksum routine.
     * The value of the checksum is returned.
     *
     * @param file  the file to checksum, must not be null
     * @return the checksum value or an exception is thrown.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:28.096 -0500", hash_original_method = "BA862217BE157CF5D802B772A24ECC4A", hash_generated_method = "26EB793AC366F285F6899E4DE193E39A")
    
public static long checksumCrc32(File file) throws FileNotFoundException, IOException {
        CRC32 checkSummer = new CRC32();
        CheckedInputStream cis = null;

        try {
            cis = new CheckedInputStream( new FileInputStream(file), checkSummer);
            byte[] buf = new byte[128];
            while(cis.read(buf) >= 0) {
                // Just read for checksum to get calculated.
            }
            return checkSummer.getValue();
        } finally {
            if (cis != null) {
                try {
                    cis.close();
                } catch (IOException e) {
                }
            }
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:27.998 -0500", hash_original_field = "B197139365886252127F5AA47ABC83DE", hash_generated_field = "2CAA2AB0FB95A97A6D80E1DB09F06B27")

    public static final int S_IRWXU = 00700;
    
    public static final class FileStatus {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:28.026 -0500", hash_original_field = "EA6E4E5EB18E8B542120B7930F12DA66", hash_generated_field = "3BC0BF1E48D184447842CF72C7D76352")

        public int dev;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:28.028 -0500", hash_original_field = "4A8EE67C988764ED3C41CE53C7EBE0EB", hash_generated_field = "C5B78187E92CAE488348D15938155545")

        public int ino;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:28.031 -0500", hash_original_field = "462D02655D7DD7DF6E5BA12D65851DD2", hash_generated_field = "1713E3B7BE81112E8E3FFA899CB92941")

        public int mode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:28.033 -0500", hash_original_field = "763E3014100AF2F048CC86D2BAB629EE", hash_generated_field = "C56B7D575C90CDCF8818CD5F568C29C4")

        public int nlink;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:28.035 -0500", hash_original_field = "12FA9B6FF5DE3157A8BC781F3445534B", hash_generated_field = "73E9256EB1FAC46D74FF7A0ED583FFBD")

        public int uid;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:28.037 -0500", hash_original_field = "348B89EEBBB5FD5838C41F12F0D7CCCB", hash_generated_field = "DEF9240402918DBE83FD3922BAF6FE1B")

        public int gid;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:28.040 -0500", hash_original_field = "C0598B220059222D0254CD53FA50A076", hash_generated_field = "4948E08C5A84F0811E86F1C21CFA9506")

        public int rdev;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:28.042 -0500", hash_original_field = "298A39EB1E059FD1DCE8DF5205BAB3E6", hash_generated_field = "330E2C35025396B20CEE6B62953E07F5")

        public long size;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:28.045 -0500", hash_original_field = "B06F265A100630A9B27BB5B60EA9634F", hash_generated_field = "5A9416AF6A0095EC9293ABA1DD3E5E25")

        public int blksize;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:28.047 -0500", hash_original_field = "33B1E8E3A1BE61390B10EE3D81E42915", hash_generated_field = "C038344B511F4A89F6C2B4393F68FC43")

        public long blocks;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:28.049 -0500", hash_original_field = "70AD21F2C2CF7C425B69684DDADE9D97", hash_generated_field = "FDC47FE6656271859D0CBA456796350E")

        public long atime;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:28.051 -0500", hash_original_field = "58DEB1B4AB58C5189A04256EB8254DFE", hash_generated_field = "D1EC330AF97E5F92C2FC6E0FC9153176")

        public long mtime;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:28.053 -0500", hash_original_field = "471EC8CF7D1CAE28632DD68956D1F6A8", hash_generated_field = "E3A6F80E7AB4D7BEB304623FAC81D67D")

        public long ctime;
        
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.084 -0400", hash_original_method = "CFD6FBC969A1D085C457A3FA7AFEA0D4", hash_generated_method = "CFD6FBC969A1D085C457A3FA7AFEA0D4")
        public FileStatus ()
        {
            //Synthesized constructor
        }

    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:28.000 -0500", hash_original_field = "3959CDB55E23F33259E6AC10E977A6C3", hash_generated_field = "1A5EC998FAB60A99871D172797E6F2F0")

    public static final int S_IRUSR = 00400;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:28.003 -0500", hash_original_field = "1180DB3DF2B9501F60E63C9B07A87F74", hash_generated_field = "06F36DB021A5309262121AF7135E3C35")

    public static final int S_IWUSR = 00200;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:28.005 -0500", hash_original_field = "9C0920D2039AC2308A341B110B4244C8", hash_generated_field = "4C99C568B06893F3C61600F6319C4155")

    public static final int S_IXUSR = 00100;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:28.007 -0500", hash_original_field = "C9F3BC2F524574048AE14FA153D4F2B3", hash_generated_field = "60E756ED22C8A2FB318B1943A6859175")

    public static final int S_IRWXG = 00070;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:28.010 -0500", hash_original_field = "E83991E3B70508D1939B5D52ECF9B627", hash_generated_field = "E618992BDF03868A4382EF0566C198A9")

    public static final int S_IRGRP = 00040;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:28.012 -0500", hash_original_field = "4545CC4EB8B904F584A7792CEB9C2EED", hash_generated_field = "EE40C8E78B318F3DF64C08702CB5A2E6")

    public static final int S_IWGRP = 00020;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:28.014 -0500", hash_original_field = "55FA52A0BB9987A6F5563499673BFC72", hash_generated_field = "68FC8E0486B1D0BDBF22A3840BBAF8B5")

    public static final int S_IXGRP = 00010;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:28.016 -0500", hash_original_field = "8BE5FB87E4A59E8C1BE7852ACBC0EB05", hash_generated_field = "5EB8920CEED5B987667569018535F803")

    public static final int S_IRWXO = 00007;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:28.018 -0500", hash_original_field = "46D7F3A4E6C9FCEF70C792555E459245", hash_generated_field = "4A3456D50196BD4CE9FF4B01EBC6C175")

    public static final int S_IROTH = 00004;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:28.021 -0500", hash_original_field = "59E7CE82C3B9DEF0E92B51258951D3D7", hash_generated_field = "A4E2AB48DCA1AE9B8FCF698220F7BB6B")

    public static final int S_IWOTH = 00002;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:28.023 -0500", hash_original_field = "A52D762E0DEFE716B9B65F492128C445", hash_generated_field = "11107087E875A4709C2A911CE9EEF9A3")

    public static final int S_IXOTH = 00001;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:28.063 -0500", hash_original_field = "6CF80D8BDD9EB0241F84C7CD80E937F0", hash_generated_field = "EA46EEA9EA87C6037D743065589C50C1")

    private static final Pattern SAFE_FILENAME_PATTERN = Pattern.compile("[\\w%+,./=_-]+");
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.083 -0400", hash_original_method = "68A158D183F246B86320864EE65BA192", hash_generated_method = "68A158D183F246B86320864EE65BA192")
    public FileUtils ()
    {
        //Synthesized constructor
    }
}

