package android.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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

public class FileUtils {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:25.996 -0400", hash_original_method = "68A158D183F246B86320864EE65BA192", hash_generated_method = "68A158D183F246B86320864EE65BA192")
    public FileUtils ()
    {
        //Synthesized constructor
    }


        public static boolean getFileStatus(String path, FileStatus status) {
        StrictMode.noteDiskRead();
        return getFileStatusNative(path, status);
    }

    
        private static boolean getFileStatusNative(String path, FileStatus status) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        public static int setPermissions(String file, int mode, int uid, int gid) {
        return DSUtils.UNKNOWN_INT;
    }

    
        public static int getPermissions(String file, int[] outPermissions) {
        return DSUtils.UNKNOWN_INT;
    }

    
        public static int setUMask(int mask) {
        return DSUtils.UNKNOWN_INT;
    }

    
        public static int getFatVolumeId(String mountPoint) {
        return DSUtils.UNKNOWN_INT;
    }

    
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

    
        public static boolean isFilenameSafe(File file) {
        return SAFE_FILENAME_PATTERN.matcher(file.getPath()).matches();
    }

    
        public static String readTextFile(File file, int max, String ellipsis) throws IOException {
        InputStream input = new FileInputStream(file);
        try {
            long size = file.length();
            if (max > 0 || (size > 0 && max == 0)) {  
                if (size > 0 && (max == 0 || size < max)) max = (int) size;
                byte[] data = new byte[max + 1];
                int length = input.read(data);
                if (length <= 0) return "";
                if (length <= max) return new String(data, 0, length);
                if (ellipsis == null) return new String(data, 0, max);
                return new String(data, 0, max) + ellipsis;
            } else if (max < 0) {  
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
            } else {  
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

    
        public static void stringToFile(String filename, String string) throws IOException {
        FileWriter out = new FileWriter(filename);
        try {
            out.write(string);
        } finally {
            out.close();
        }
    }

    
        public static long checksumCrc32(File file) throws FileNotFoundException, IOException {
        CRC32 checkSummer = new CRC32();
        CheckedInputStream cis = null;
        try {
            cis = new CheckedInputStream( new FileInputStream(file), checkSummer);
            byte[] buf = new byte[128];
            while(cis.read(buf) >= 0) {
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

    
    public static final class FileStatus {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:26.048 -0400", hash_original_field = "E77989ED21758E78331B20E477FC5582", hash_generated_field = "3BC0BF1E48D184447842CF72C7D76352")

        public int dev;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:26.049 -0400", hash_original_field = "8BA744AFE510A10886736E9C7BBC496E", hash_generated_field = "C5B78187E92CAE488348D15938155545")

        public int ino;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:26.049 -0400", hash_original_field = "15D61712450A686A7F365ADF4FEF581F", hash_generated_field = "1713E3B7BE81112E8E3FFA899CB92941")

        public int mode;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:26.049 -0400", hash_original_field = "F63D4D2EDAE0E3EEF6009CA2CBEDD404", hash_generated_field = "C56B7D575C90CDCF8818CD5F568C29C4")

        public int nlink;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:26.049 -0400", hash_original_field = "9871D3A2C554B27151CACF1422EEC048", hash_generated_field = "73E9256EB1FAC46D74FF7A0ED583FFBD")

        public int uid;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:26.049 -0400", hash_original_field = "2D53A8FB7ABF5BE7F4A3CF4B565CC75C", hash_generated_field = "DEF9240402918DBE83FD3922BAF6FE1B")

        public int gid;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:26.049 -0400", hash_original_field = "74AC924ED81FD35C3ADDE769A4D3576A", hash_generated_field = "4948E08C5A84F0811E86F1C21CFA9506")

        public int rdev;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:26.049 -0400", hash_original_field = "F7BD60B75B29D79B660A2859395C1A24", hash_generated_field = "330E2C35025396B20CEE6B62953E07F5")

        public long size;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:26.049 -0400", hash_original_field = "02686223F7CE1493C9D3CD39A050161B", hash_generated_field = "5A9416AF6A0095EC9293ABA1DD3E5E25")

        public int blksize;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:26.049 -0400", hash_original_field = "E734964953F880E5164E32827950FF92", hash_generated_field = "C038344B511F4A89F6C2B4393F68FC43")

        public long blocks;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:26.049 -0400", hash_original_field = "8753BAE33310E765A2BC36F9C5D33CCB", hash_generated_field = "FDC47FE6656271859D0CBA456796350E")

        public long atime;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:26.049 -0400", hash_original_field = "7076B27A4FF56615FEDB41F803F69BAA", hash_generated_field = "D1EC330AF97E5F92C2FC6E0FC9153176")

        public long mtime;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:26.049 -0400", hash_original_field = "8C1EDDB947FAD440954F3C703D4DF808", hash_generated_field = "E3A6F80E7AB4D7BEB304623FAC81D67D")

        public long ctime;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:26.049 -0400", hash_original_method = "CFD6FBC969A1D085C457A3FA7AFEA0D4", hash_generated_method = "CFD6FBC969A1D085C457A3FA7AFEA0D4")
        public FileStatus ()
        {
            //Synthesized constructor
        }


    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:26.049 -0400", hash_original_field = "8D68B05BAE34B70900339C99086B1640", hash_generated_field = "2CAA2AB0FB95A97A6D80E1DB09F06B27")

    public static final int S_IRWXU = 00700;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:26.050 -0400", hash_original_field = "CAAB8AFA0427A894D678B44A90BA3B4E", hash_generated_field = "1A5EC998FAB60A99871D172797E6F2F0")

    public static final int S_IRUSR = 00400;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:26.050 -0400", hash_original_field = "D491EA772351C6B6E2728D95CBEDA5DE", hash_generated_field = "06F36DB021A5309262121AF7135E3C35")

    public static final int S_IWUSR = 00200;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:26.050 -0400", hash_original_field = "17EF4EA21CD25D81A7E28C2E3BC5D623", hash_generated_field = "4C99C568B06893F3C61600F6319C4155")

    public static final int S_IXUSR = 00100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:26.050 -0400", hash_original_field = "FBE85776274F392D37521B237116AF5A", hash_generated_field = "60E756ED22C8A2FB318B1943A6859175")

    public static final int S_IRWXG = 00070;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:26.050 -0400", hash_original_field = "00D7A23B8B84331CE8668451F6AE1526", hash_generated_field = "E618992BDF03868A4382EF0566C198A9")

    public static final int S_IRGRP = 00040;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:26.050 -0400", hash_original_field = "0DF59612A7E44112DAEE27B8DDAEB5DB", hash_generated_field = "EE40C8E78B318F3DF64C08702CB5A2E6")

    public static final int S_IWGRP = 00020;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:26.050 -0400", hash_original_field = "742294153C265525CA1D6B68873E1B37", hash_generated_field = "68FC8E0486B1D0BDBF22A3840BBAF8B5")

    public static final int S_IXGRP = 00010;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:26.050 -0400", hash_original_field = "A7E6AF05326ECE3A4621910DEE43F074", hash_generated_field = "5EB8920CEED5B987667569018535F803")

    public static final int S_IRWXO = 00007;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:26.050 -0400", hash_original_field = "8FE283AF0489DBEA22BFA98632475C48", hash_generated_field = "4A3456D50196BD4CE9FF4B01EBC6C175")

    public static final int S_IROTH = 00004;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:26.050 -0400", hash_original_field = "1C2855FC1FF59AC43A6033E6E8C6A792", hash_generated_field = "A4E2AB48DCA1AE9B8FCF698220F7BB6B")

    public static final int S_IWOTH = 00002;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:26.050 -0400", hash_original_field = "B407BCE91C928DD240BFB06A275508DC", hash_generated_field = "11107087E875A4709C2A911CE9EEF9A3")

    public static final int S_IXOTH = 00001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:26.050 -0400", hash_original_field = "C7898A789697DFF05D90DB12E7A7C544", hash_generated_field = "6AD2A74F0DAC78FCEF54A64DECB04B80")

    private static Pattern SAFE_FILENAME_PATTERN = Pattern.compile("[\\w%+,./=_-]+");
}

