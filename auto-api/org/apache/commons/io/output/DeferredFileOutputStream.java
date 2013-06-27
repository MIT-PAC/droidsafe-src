package org.apache.commons.io.output;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.commons.io.IOUtils;

public class DeferredFileOutputStream extends ThresholdingOutputStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.381 -0400", hash_original_field = "FABA8AF9F249B2667CE40BDCCE2A9204", hash_generated_field = "2434DA308586EAA1509E3D268C40C3DE")

    private ByteArrayOutputStream memoryOutputStream;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.382 -0400", hash_original_field = "48751A6C61BF15910CC76DF00D732DA1", hash_generated_field = "95C2638CFCA277D66AF64A0C84E5EFAA")

    private OutputStream currentOutputStream;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.382 -0400", hash_original_field = "0E20961C41539D1F0459CE5FA6AFC03B", hash_generated_field = "13DF2A79D46A052511C9FF993E8FED07")

    private File outputFile;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.382 -0400", hash_original_field = "851F5AC9941D720844D143ED9CFCF60A", hash_generated_field = "F717D382565968ED95842821FAEC62F9")

    private String prefix;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.382 -0400", hash_original_field = "4EC1B477CD0232B832C1899905EC51A4", hash_generated_field = "4D4C553D5B0C0462F41497F0C740F576")

    private String suffix;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.382 -0400", hash_original_field = "5F8F22B8CDBAEEE8CF857673A9B6BA20", hash_generated_field = "8B0860249151DE823C54467CC9BADB3F")

    private File directory;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.382 -0400", hash_original_field = "1E79543A888DE7BB0ADBB289A8F4251D", hash_generated_field = "AA98B16E301073717D23E903C6D6286D")

    private boolean closed = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.382 -0400", hash_original_method = "12A02A287ADE8B8C967BB9DD34A9FF2E", hash_generated_method = "5A6F56F3FC7E406217CAC10AB95C7401")
    public  DeferredFileOutputStream(int threshold, File outputFile) {
        this(threshold,  outputFile, null, null, null);
        addTaint(threshold);
        addTaint(outputFile.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.382 -0400", hash_original_method = "7C105C969E0E98618A848E2BA2427DC3", hash_generated_method = "535677DA161E863E1157C697FA703686")
    public  DeferredFileOutputStream(int threshold, String prefix, String suffix, File directory) {
        this(threshold, null, prefix, suffix, directory);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Temporary file prefix is missing");
        } //End block
        addTaint(threshold);
        addTaint(prefix.getTaint());
        addTaint(suffix.getTaint());
        addTaint(directory.getTaint());
        // ---------- Original Method ----------
        //if (prefix == null) {
            //throw new IllegalArgumentException("Temporary file prefix is missing");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.383 -0400", hash_original_method = "48C97AA3045E7A9B2226A2F0245D0AFE", hash_generated_method = "1AF449A4607C2186E88917733C467465")
    private  DeferredFileOutputStream(int threshold, File outputFile, String prefix, String suffix, File directory) {
        super(threshold);
        this.outputFile = outputFile;
        memoryOutputStream = new ByteArrayOutputStream();
        currentOutputStream = memoryOutputStream;
        this.prefix = prefix;
        this.suffix = suffix;
        this.directory = directory;
        addTaint(threshold);
        // ---------- Original Method ----------
        //this.outputFile = outputFile;
        //memoryOutputStream = new ByteArrayOutputStream();
        //currentOutputStream = memoryOutputStream;
        //this.prefix = prefix;
        //this.suffix = suffix;
        //this.directory = directory;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.384 -0400", hash_original_method = "F995E868509776850AFF6498E755EFC4", hash_generated_method = "FA4A75B1D905409BE07800EDF5BE3605")
    @Override
    protected OutputStream getStream() throws IOException {
        OutputStream varB4EAC82CA7396A68D541C85D26508E83_2051491333 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2051491333 = currentOutputStream;
        varB4EAC82CA7396A68D541C85D26508E83_2051491333.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2051491333;
        // ---------- Original Method ----------
        //return currentOutputStream;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.398 -0400", hash_original_method = "90F9D8BE12A4409DA41E0CA93662D129", hash_generated_method = "4936F2C6309AB296DEAB6F6725B6607C")
    @Override
    protected void thresholdReached() throws IOException {
        {
            outputFile = File.createTempFile(prefix, suffix, directory);
        } //End block
        FileOutputStream fos;
        fos = new FileOutputStream(outputFile);
        memoryOutputStream.writeTo(fos);
        currentOutputStream = fos;
        memoryOutputStream = null;
        // ---------- Original Method ----------
        //if (prefix != null) {
            //outputFile = File.createTempFile(prefix, suffix, directory);
        //}
        //FileOutputStream fos = new FileOutputStream(outputFile);
        //memoryOutputStream.writeTo(fos);
        //currentOutputStream = fos;
        //memoryOutputStream = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.398 -0400", hash_original_method = "02F113772DEC1618BE4A7F2BC7B846DE", hash_generated_method = "627E10D6EFC9EAC05EE5AF375D5F9D7C")
    public boolean isInMemory() {
        boolean var79A530CFC245235708C67CC30D6574AD_1078422625 = (!isThresholdExceeded());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1779200805 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1779200805;
        // ---------- Original Method ----------
        //return !isThresholdExceeded();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.399 -0400", hash_original_method = "CEBBD6265454356FCC4FE657D9359767", hash_generated_method = "688DE8B5C83F3F6EBB718CEAD10F90A9")
    public byte[] getData() {
        {
            byte[] var09DAD4E7AF301F104761D7FD07F9EB60_1335471007 = (memoryOutputStream.toByteArray());
        } //End block
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_328395624 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_328395624;
        // ---------- Original Method ----------
        //if (memoryOutputStream != null)
        //{
            //return memoryOutputStream.toByteArray();
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.399 -0400", hash_original_method = "2FAEE05DD81B3DF9BBBB7355A430983C", hash_generated_method = "E03F667A3C322045E99A44F87BB3F742")
    public File getFile() {
        File varB4EAC82CA7396A68D541C85D26508E83_683671018 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_683671018 = outputFile;
        varB4EAC82CA7396A68D541C85D26508E83_683671018.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_683671018;
        // ---------- Original Method ----------
        //return outputFile;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.400 -0400", hash_original_method = "C7FCBD344022D72FF18766A4DFEA8EE1", hash_generated_method = "DCC0D06E7F79ED3EAE0E8D99DD76C5B5")
    @Override
    public void close() throws IOException {
        super.close();
        closed = true;
        // ---------- Original Method ----------
        //super.close();
        //closed = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.400 -0400", hash_original_method = "EDA7487DCECD411B0E9FBCE942C20A22", hash_generated_method = "33C188C270EC45D08B05E18C1D9BA8FA")
    public void writeTo(OutputStream out) throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("Stream not closed");
        } //End block
        {
            boolean varBCECD79AA34B2E7F7193471A45415FDC_415871932 = (isInMemory());
            {
                memoryOutputStream.writeTo(out);
            } //End block
            {
                FileInputStream fis;
                fis = new FileInputStream(outputFile);
                try 
                {
                    IOUtils.copy(fis, out);
                } //End block
                finally 
                {
                    IOUtils.closeQuietly(fis);
                } //End block
            } //End block
        } //End collapsed parenthetic
        addTaint(out.getTaint());
        // ---------- Original Method ----------
        //if (!closed)
        //{
            //throw new IOException("Stream not closed");
        //}
        //if(isInMemory())
        //{
            //memoryOutputStream.writeTo(out);
        //}
        //else
        //{
            //FileInputStream fis = new FileInputStream(outputFile);
            //try {
                //IOUtils.copy(fis, out);
            //} finally {
                //IOUtils.closeQuietly(fis);
            //}
        //}
    }

    
}

