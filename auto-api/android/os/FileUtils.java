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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.503 -0400", hash_original_method = "53204DA468636FDA1579E622ED1B7599", hash_generated_method = "53204DA468636FDA1579E622ED1B7599")
        public FileUtils ()
    {
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
        public int dev;
        public int ino;
        public int mode;
        public int nlink;
        public int uid;
        public int gid;
        public int rdev;
        public long size;
        public int blksize;
        public long blocks;
        public long atime;
        public long mtime;
        public long ctime;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.510 -0400", hash_original_method = "B9295076B9F9BAA54AB5636A1A7340CA", hash_generated_method = "B9295076B9F9BAA54AB5636A1A7340CA")
                public FileStatus ()
        {
        }


    }


    
    public static final int S_IRWXU = 00700;
    public static final int S_IRUSR = 00400;
    public static final int S_IWUSR = 00200;
    public static final int S_IXUSR = 00100;
    public static final int S_IRWXG = 00070;
    public static final int S_IRGRP = 00040;
    public static final int S_IWGRP = 00020;
    public static final int S_IXGRP = 00010;
    public static final int S_IRWXO = 00007;
    public static final int S_IROTH = 00004;
    public static final int S_IWOTH = 00002;
    public static final int S_IXOTH = 00001;
    private static final Pattern SAFE_FILENAME_PATTERN = Pattern.compile("[\\w%+,./=_-]+");
}

