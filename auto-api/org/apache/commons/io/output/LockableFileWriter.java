package org.apache.commons.io.output;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import org.apache.commons.io.Charsets;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

public class LockableFileWriter extends Writer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.564 -0400", hash_original_field = "C68271A63DDBC431C307BEB7D2918275", hash_generated_field = "0251D9C19BD1379B95D6A9A5D4A8C80D")

    private Writer out;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.564 -0400", hash_original_field = "FDFD9B309F399608C8BAF4DCBF3DF5C4", hash_generated_field = "AC90E37DC00D195823505C62C62EC14B")

    private File lockFile;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.564 -0400", hash_original_method = "E4DF2692D09657C937667960DF2A3C67", hash_generated_method = "239FE52EF480120915A9629DB821AD78")
    public  LockableFileWriter(String fileName) throws IOException {
        this(fileName, false, null);
        addTaint(fileName.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.565 -0400", hash_original_method = "FC93D084C129233C65899CC07B40F7F6", hash_generated_method = "F559A1597D2A1193A3069FF91E96A0F9")
    public  LockableFileWriter(String fileName, boolean append) throws IOException {
        this(fileName, append, null);
        addTaint(fileName.getTaint());
        addTaint(append);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.565 -0400", hash_original_method = "B7233EF33CE1581A472B9379DD0E229A", hash_generated_method = "E16806D0265EB92F46B81226208AB2EC")
    public  LockableFileWriter(String fileName, boolean append, String lockDir) throws IOException {
        this(new File(fileName), append, lockDir);
        addTaint(fileName.getTaint());
        addTaint(append);
        addTaint(lockDir.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.565 -0400", hash_original_method = "6ED4CA4A5697FDAC39D30ACE5ED4B1F3", hash_generated_method = "B6C5EB2D3FA30E9F872E0BE8A1CDBFA3")
    public  LockableFileWriter(File file) throws IOException {
        this(file, false, null);
        addTaint(file.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.566 -0400", hash_original_method = "4EF9EE3D70949EF568D3A2DBCC1401FD", hash_generated_method = "3ADECF849DA6373B80F21595BB3A3334")
    public  LockableFileWriter(File file, boolean append) throws IOException {
        this(file, append, null);
        addTaint(file.getTaint());
        addTaint(append);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.566 -0400", hash_original_method = "E6D05E7A8E7A53A0497829DD15335921", hash_generated_method = "1C4004235641FFEFFA5242BAF8DDBE83")
    public  LockableFileWriter(File file, boolean append, String lockDir) throws IOException {
        this(file, Charset.defaultCharset(), append, lockDir);
        addTaint(file.getTaint());
        addTaint(append);
        addTaint(lockDir.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.567 -0400", hash_original_method = "70DFCFEBCCB528E3905963CAD4603A5C", hash_generated_method = "B2BB6F53265D67D52044109750694FCD")
    public  LockableFileWriter(File file, Charset encoding) throws IOException {
        this(file, encoding, false, null);
        addTaint(file.getTaint());
        addTaint(encoding.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.567 -0400", hash_original_method = "51199DDDF4151039B212F3260E0B0706", hash_generated_method = "6599201C28B07CB300BA89AC2AB2189D")
    public  LockableFileWriter(File file, String encoding) throws IOException {
        this(file, encoding, false, null);
        addTaint(file.getTaint());
        addTaint(encoding.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.581 -0400", hash_original_method = "44AD202744E75D3A75FDD22C341BBAC5", hash_generated_method = "5BE875359F62C7B42E7D13D9B188098D")
    public  LockableFileWriter(File file, Charset encoding, boolean append,
            String lockDir) throws IOException {
        super();
        file = file.getAbsoluteFile();
        {
            boolean var3C6B443E1FDDD4F5DD4166952B7B8EBC_19048806 = (file.getParentFile() != null);
            {
                FileUtils.forceMkdir(file.getParentFile());
            } //End block
        } //End collapsed parenthetic
        {
            boolean varB4EF7A82C29897D1EBAB65E15CCB5408_900969672 = (file.isDirectory());
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException("File specified is a directory");
            } //End block
        } //End collapsed parenthetic
        {
            lockDir = System.getProperty("java.io.tmpdir");
        } //End block
        File lockDirFile;
        lockDirFile = new File(lockDir);
        FileUtils.forceMkdir(lockDirFile);
        testLockDir(lockDirFile);
        lockFile = new File(lockDirFile, file.getName() + LCK);
        createLock();
        out = initWriter(file, encoding, append);
        addTaint(lockDir.getTaint());
        // ---------- Original Method ----------
        //file = file.getAbsoluteFile();
        //if (file.getParentFile() != null) {
            //FileUtils.forceMkdir(file.getParentFile());
        //}
        //if (file.isDirectory()) {
            //throw new IOException("File specified is a directory");
        //}
        //if (lockDir == null) {
            //lockDir = System.getProperty("java.io.tmpdir");
        //}
        //File lockDirFile = new File(lockDir);
        //FileUtils.forceMkdir(lockDirFile);
        //testLockDir(lockDirFile);
        //lockFile = new File(lockDirFile, file.getName() + LCK);
        //createLock();
        //out = initWriter(file, encoding, append);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.581 -0400", hash_original_method = "7CC795373BAAA161D6C74B697A2C20C3", hash_generated_method = "FA89960E97DB2426E662695C393166F7")
    public  LockableFileWriter(File file, String encoding, boolean append,
            String lockDir) throws IOException {
        this(file, Charsets.toCharset(encoding), append, lockDir);
        addTaint(file.getTaint());
        addTaint(encoding.getTaint());
        addTaint(append);
        addTaint(lockDir.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.582 -0400", hash_original_method = "8D77B36F2D36A74D4D1D738F1EFBDA2C", hash_generated_method = "9CE78B61FBB3A95704D8C8DC3892BCCA")
    private void testLockDir(File lockDir) throws IOException {
        {
            boolean var15D1DE103EFBE4FFEC91B093BCC68616_1870416057 = (!lockDir.exists());
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException(
                    "Could not find lockDir: " + lockDir.getAbsolutePath());
            } //End block
        } //End collapsed parenthetic
        {
            boolean varB96F37B67BDFBF29B8473930027E6EB2_1557697813 = (!lockDir.canWrite());
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException(
                    "Could not write to lockDir: " + lockDir.getAbsolutePath());
            } //End block
        } //End collapsed parenthetic
        addTaint(lockDir.getTaint());
        // ---------- Original Method ----------
        //if (!lockDir.exists()) {
            //throw new IOException(
                    //"Could not find lockDir: " + lockDir.getAbsolutePath());
        //}
        //if (!lockDir.canWrite()) {
            //throw new IOException(
                    //"Could not write to lockDir: " + lockDir.getAbsolutePath());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.582 -0400", hash_original_method = "17CDBB829EF4B0C5B4419966B6F98CAD", hash_generated_method = "F31DE105A547A4C8D6B4493913AD03F4")
    private void createLock() throws IOException {
        {
            {
                boolean var4B2A44DBDF77C9014A00AF704A516BDF_73378952 = (!lockFile.createNewFile());
                {
                    if (DroidSafeAndroidRuntime.control) throw new IOException("Can't write file, lock " +
                        lockFile.getAbsolutePath() + " exists");
                } //End block
            } //End collapsed parenthetic
            lockFile.deleteOnExit();
        } //End block
        // ---------- Original Method ----------
        //synchronized (LockableFileWriter.class) {
            //if (!lockFile.createNewFile()) {
                //throw new IOException("Can't write file, lock " +
                        //lockFile.getAbsolutePath() + " exists");
            //}
            //lockFile.deleteOnExit();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.584 -0400", hash_original_method = "9026BE33E3D40906CA316E83E271B1B8", hash_generated_method = "1B28786497BDC320993F3BA60419A5CC")
    private Writer initWriter(File file, Charset encoding, boolean append) throws IOException {
        Writer varB4EAC82CA7396A68D541C85D26508E83_38006961 = null; //Variable for return #1
        boolean fileExistedAlready;
        fileExistedAlready = file.exists();
        OutputStream stream;
        stream = null;
        Writer writer;
        writer = null;
        try 
        {
            stream = new FileOutputStream(file.getAbsolutePath(), append);
            writer = new OutputStreamWriter(stream, Charsets.toCharset(encoding));
        } //End block
        catch (IOException ex)
        {
            IOUtils.closeQuietly(writer);
            IOUtils.closeQuietly(stream);
            FileUtils.deleteQuietly(lockFile);
            {
                FileUtils.deleteQuietly(file);
            } //End block
            if (DroidSafeAndroidRuntime.control) throw ex;
        } //End block
        catch (RuntimeException ex)
        {
            IOUtils.closeQuietly(writer);
            IOUtils.closeQuietly(stream);
            FileUtils.deleteQuietly(lockFile);
            {
                FileUtils.deleteQuietly(file);
            } //End block
            if (DroidSafeAndroidRuntime.control) throw ex;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_38006961 = writer;
        addTaint(file.getTaint());
        addTaint(encoding.getTaint());
        addTaint(append);
        varB4EAC82CA7396A68D541C85D26508E83_38006961.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_38006961;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.590 -0400", hash_original_method = "C9C28C6746F703FA832F2D42517AD4AE", hash_generated_method = "D57CA109FD8E5C197C2A4A548F02BC22")
    @Override
    public void close() throws IOException {
        try 
        {
            out.close();
        } //End block
        finally 
        {
            lockFile.delete();
        } //End block
        // ---------- Original Method ----------
        //try {
            //out.close();
        //} finally {
            //lockFile.delete();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.590 -0400", hash_original_method = "EE30809419C042C9133DA321A16F7DFD", hash_generated_method = "9D3E64422199D911A8FED9F04D0CD032")
    @Override
    public void write(int idx) throws IOException {
        out.write(idx);
        addTaint(idx);
        // ---------- Original Method ----------
        //out.write(idx);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.590 -0400", hash_original_method = "46EC5EF747261262EAD8ED1BD4879967", hash_generated_method = "575758C142209E068CE55D69C08DC03C")
    @Override
    public void write(char[] chr) throws IOException {
        out.write(chr);
        addTaint(chr[0]);
        // ---------- Original Method ----------
        //out.write(chr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.591 -0400", hash_original_method = "4007BD37B56F652F2DD863D7816336D0", hash_generated_method = "574C18C42E6F03671E82D29AA383A523")
    @Override
    public void write(char[] chr, int st, int end) throws IOException {
        out.write(chr, st, end);
        addTaint(chr[0]);
        addTaint(st);
        addTaint(end);
        // ---------- Original Method ----------
        //out.write(chr, st, end);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.591 -0400", hash_original_method = "570C1378326063600110CB3D156C7691", hash_generated_method = "01483C2A984EC8B0C3967FC4CB8B0DB7")
    @Override
    public void write(String str) throws IOException {
        out.write(str);
        addTaint(str.getTaint());
        // ---------- Original Method ----------
        //out.write(str);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.591 -0400", hash_original_method = "694B238FF5AB1AB4441171CB6DC98A7A", hash_generated_method = "93542F5D13EEB77A09805F9165E14C09")
    @Override
    public void write(String str, int st, int end) throws IOException {
        out.write(str, st, end);
        addTaint(str.getTaint());
        addTaint(st);
        addTaint(end);
        // ---------- Original Method ----------
        //out.write(str, st, end);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.595 -0400", hash_original_method = "C99FBA65B0D308569620507D6E099042", hash_generated_method = "A2EF74EEF7203CB573D4B22064D57305")
    @Override
    public void flush() throws IOException {
        out.flush();
        // ---------- Original Method ----------
        //out.flush();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.595 -0400", hash_original_field = "5A6FAB8808296EE90651BAA54A1E5114", hash_generated_field = "435FA908F3DC2A9757F037371191E298")

    private static String LCK = ".lck";
}

