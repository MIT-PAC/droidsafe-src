package org.apache.commons.io.output;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

public class FileWriterWithEncoding extends Writer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.687 -0400", hash_original_field = "C68271A63DDBC431C307BEB7D2918275", hash_generated_field = "0251D9C19BD1379B95D6A9A5D4A8C80D")

    private Writer out;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.687 -0400", hash_original_method = "A52AC32E391B7F84AF3674F051432B93", hash_generated_method = "2F655FE9E073194C2869FD5D67021804")
    public  FileWriterWithEncoding(String filename, String encoding) throws IOException {
        this(new File(filename), encoding, false);
        addTaint(filename.getTaint());
        addTaint(encoding.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.688 -0400", hash_original_method = "9268E855F2CAF6B32CC0A84C097AA89C", hash_generated_method = "C1EBD1238BFB1EA3D543CDE8CC3FDD86")
    public  FileWriterWithEncoding(String filename, String encoding, boolean append) throws IOException {
        this(new File(filename), encoding, append);
        addTaint(filename.getTaint());
        addTaint(encoding.getTaint());
        addTaint(append);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.688 -0400", hash_original_method = "5B48C8683005DB158481C5D53B140180", hash_generated_method = "BF25ADACBA54F8492C2B7C91BAECE740")
    public  FileWriterWithEncoding(String filename, Charset encoding) throws IOException {
        this(new File(filename), encoding, false);
        addTaint(filename.getTaint());
        addTaint(encoding.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.688 -0400", hash_original_method = "F4D6C9041E127D6A9D181ECD595CA773", hash_generated_method = "FB56575778AA942AC56E193D05013B1E")
    public  FileWriterWithEncoding(String filename, Charset encoding, boolean append) throws IOException {
        this(new File(filename), encoding, append);
        addTaint(filename.getTaint());
        addTaint(encoding.getTaint());
        addTaint(append);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.688 -0400", hash_original_method = "BE1D40ED821F3E25537E5C6AFC567836", hash_generated_method = "7DB7B0506B880E0EE1992F8A83DF7048")
    public  FileWriterWithEncoding(String filename, CharsetEncoder encoding) throws IOException {
        this(new File(filename), encoding, false);
        addTaint(filename.getTaint());
        addTaint(encoding.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.688 -0400", hash_original_method = "A695A8BF148290BDBA8C8C60EA64EB2D", hash_generated_method = "1DFBF730A3BAE763905E9993063C338B")
    public  FileWriterWithEncoding(String filename, CharsetEncoder encoding, boolean append) throws IOException {
        this(new File(filename), encoding, append);
        addTaint(filename.getTaint());
        addTaint(encoding.getTaint());
        addTaint(append);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.689 -0400", hash_original_method = "2E483D5B654BC30D2C26E569C2C13C4B", hash_generated_method = "1217D596CE4BA4AB7F5BA2DF7FC11645")
    public  FileWriterWithEncoding(File file, String encoding) throws IOException {
        this(file, encoding, false);
        addTaint(file.getTaint());
        addTaint(encoding.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.689 -0400", hash_original_method = "8CE491D4D9BE51D07DB14BE0E12E38B2", hash_generated_method = "111E9BD58734F03F6A4E7670ADAE1165")
    public  FileWriterWithEncoding(File file, String encoding, boolean append) throws IOException {
        super();
        this.out = initWriter(file, encoding, append);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.689 -0400", hash_original_method = "73F04B968EDAB2AA927750D7924907E5", hash_generated_method = "099DD841294283251DF8B64127623080")
    public  FileWriterWithEncoding(File file, Charset encoding) throws IOException {
        this(file, encoding, false);
        addTaint(file.getTaint());
        addTaint(encoding.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.689 -0400", hash_original_method = "3A1E34D05E51ADA7E2716E6B82EE32B2", hash_generated_method = "0B6A899E5E953851125AD4224E5160C3")
    public  FileWriterWithEncoding(File file, Charset encoding, boolean append) throws IOException {
        super();
        this.out = initWriter(file, encoding, append);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.690 -0400", hash_original_method = "3AF4BFBC54E30FB310A497284D9191E7", hash_generated_method = "2A3E4B597E187E40BFBDF9679440F6FF")
    public  FileWriterWithEncoding(File file, CharsetEncoder encoding) throws IOException {
        this(file, encoding, false);
        addTaint(file.getTaint());
        addTaint(encoding.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.690 -0400", hash_original_method = "DB01DDECD36D428EBB5A472FDA637AEC", hash_generated_method = "D1F8937E45B42363E7EE729A011DEEA6")
    public  FileWriterWithEncoding(File file, CharsetEncoder encoding, boolean append) throws IOException {
        super();
        this.out = initWriter(file, encoding, append);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    private static Writer initWriter(File file, Object encoding, boolean append) throws IOException {
        if (file == null) {
            throw new NullPointerException("File is missing");
        }
        if (encoding == null) {
            throw new NullPointerException("Encoding is missing");
        }
        boolean fileExistedAlready = file.exists();
        OutputStream stream = null;
        Writer writer = null;
        try {
            stream = new FileOutputStream(file, append);
            if (encoding instanceof Charset) {
                writer = new OutputStreamWriter(stream, (Charset)encoding);
            } else if (encoding instanceof CharsetEncoder) {
                writer = new OutputStreamWriter(stream, (CharsetEncoder)encoding);
            } else {
                writer = new OutputStreamWriter(stream, (String)encoding);
            }
        } catch (IOException ex) {
            IOUtils.closeQuietly(writer);
            IOUtils.closeQuietly(stream);
            if (fileExistedAlready == false) {
                FileUtils.deleteQuietly(file);
            }
            throw ex;
        } catch (RuntimeException ex) {
            IOUtils.closeQuietly(writer);
            IOUtils.closeQuietly(stream);
            if (fileExistedAlready == false) {
                FileUtils.deleteQuietly(file);
            }
            throw ex;
        }
        return writer;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.690 -0400", hash_original_method = "EE30809419C042C9133DA321A16F7DFD", hash_generated_method = "9D3E64422199D911A8FED9F04D0CD032")
    @Override
    public void write(int idx) throws IOException {
        out.write(idx);
        addTaint(idx);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.690 -0400", hash_original_method = "46EC5EF747261262EAD8ED1BD4879967", hash_generated_method = "575758C142209E068CE55D69C08DC03C")
    @Override
    public void write(char[] chr) throws IOException {
        out.write(chr);
        addTaint(chr[0]);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.691 -0400", hash_original_method = "4007BD37B56F652F2DD863D7816336D0", hash_generated_method = "574C18C42E6F03671E82D29AA383A523")
    @Override
    public void write(char[] chr, int st, int end) throws IOException {
        out.write(chr, st, end);
        addTaint(chr[0]);
        addTaint(st);
        addTaint(end);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.691 -0400", hash_original_method = "570C1378326063600110CB3D156C7691", hash_generated_method = "01483C2A984EC8B0C3967FC4CB8B0DB7")
    @Override
    public void write(String str) throws IOException {
        out.write(str);
        addTaint(str.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.691 -0400", hash_original_method = "694B238FF5AB1AB4441171CB6DC98A7A", hash_generated_method = "93542F5D13EEB77A09805F9165E14C09")
    @Override
    public void write(String str, int st, int end) throws IOException {
        out.write(str, st, end);
        addTaint(str.getTaint());
        addTaint(st);
        addTaint(end);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.691 -0400", hash_original_method = "C99FBA65B0D308569620507D6E099042", hash_generated_method = "A2EF74EEF7203CB573D4B22064D57305")
    @Override
    public void flush() throws IOException {
        out.flush();
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.691 -0400", hash_original_method = "607673C7F0C479BD29B5457E75015964", hash_generated_method = "7B0A1A13788BB485E8432EED04606E81")
    @Override
    public void close() throws IOException {
        out.close();
        
        
    }

    
}

