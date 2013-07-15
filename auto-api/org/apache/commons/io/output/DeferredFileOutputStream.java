package org.apache.commons.io.output;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.commons.io.IOUtils;

public class DeferredFileOutputStream extends ThresholdingOutputStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.668 -0400", hash_original_field = "FABA8AF9F249B2667CE40BDCCE2A9204", hash_generated_field = "2434DA308586EAA1509E3D268C40C3DE")

    private ByteArrayOutputStream memoryOutputStream;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.668 -0400", hash_original_field = "48751A6C61BF15910CC76DF00D732DA1", hash_generated_field = "95C2638CFCA277D66AF64A0C84E5EFAA")

    private OutputStream currentOutputStream;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.668 -0400", hash_original_field = "0E20961C41539D1F0459CE5FA6AFC03B", hash_generated_field = "13DF2A79D46A052511C9FF993E8FED07")

    private File outputFile;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.668 -0400", hash_original_field = "851F5AC9941D720844D143ED9CFCF60A", hash_generated_field = "F717D382565968ED95842821FAEC62F9")

    private String prefix;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.668 -0400", hash_original_field = "4EC1B477CD0232B832C1899905EC51A4", hash_generated_field = "4D4C553D5B0C0462F41497F0C740F576")

    private String suffix;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.668 -0400", hash_original_field = "5F8F22B8CDBAEEE8CF857673A9B6BA20", hash_generated_field = "8B0860249151DE823C54467CC9BADB3F")

    private File directory;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.668 -0400", hash_original_field = "1E79543A888DE7BB0ADBB289A8F4251D", hash_generated_field = "AA98B16E301073717D23E903C6D6286D")

    private boolean closed = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.668 -0400", hash_original_method = "12A02A287ADE8B8C967BB9DD34A9FF2E", hash_generated_method = "5A6F56F3FC7E406217CAC10AB95C7401")
    public  DeferredFileOutputStream(int threshold, File outputFile) {
        this(threshold,  outputFile, null, null, null);
        addTaint(threshold);
        addTaint(outputFile.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.668 -0400", hash_original_method = "7C105C969E0E98618A848E2BA2427DC3", hash_generated_method = "535677DA161E863E1157C697FA703686")
    public  DeferredFileOutputStream(int threshold, String prefix, String suffix, File directory) {
        this(threshold, null, prefix, suffix, directory);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Temporary file prefix is missing");
        } 
        addTaint(threshold);
        addTaint(prefix.getTaint());
        addTaint(suffix.getTaint());
        addTaint(directory.getTaint());
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.669 -0400", hash_original_method = "48C97AA3045E7A9B2226A2F0245D0AFE", hash_generated_method = "1AF449A4607C2186E88917733C467465")
    private  DeferredFileOutputStream(int threshold, File outputFile, String prefix, String suffix, File directory) {
        super(threshold);
        this.outputFile = outputFile;
        memoryOutputStream = new ByteArrayOutputStream();
        currentOutputStream = memoryOutputStream;
        this.prefix = prefix;
        this.suffix = suffix;
        this.directory = directory;
        addTaint(threshold);
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.669 -0400", hash_original_method = "F995E868509776850AFF6498E755EFC4", hash_generated_method = "FF8B9E0479D1D8CE7C9D382D97BDE5C9")
    @Override
    protected OutputStream getStream() throws IOException {
        OutputStream varB4EAC82CA7396A68D541C85D26508E83_2063728765 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2063728765 = currentOutputStream;
        varB4EAC82CA7396A68D541C85D26508E83_2063728765.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2063728765;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.670 -0400", hash_original_method = "90F9D8BE12A4409DA41E0CA93662D129", hash_generated_method = "858E5648A77B78616DA767663201D7C5")
    @Override
    protected void thresholdReached() throws IOException {
        {
            outputFile = File.createTempFile(prefix, suffix, directory);
        } 
        FileOutputStream fos = new FileOutputStream(outputFile);
        memoryOutputStream.writeTo(fos);
        currentOutputStream = fos;
        memoryOutputStream = null;
        
        
            
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.670 -0400", hash_original_method = "02F113772DEC1618BE4A7F2BC7B846DE", hash_generated_method = "40684F90586F003F3875F90453343C49")
    public boolean isInMemory() {
        boolean var79A530CFC245235708C67CC30D6574AD_1145081684 = (!isThresholdExceeded());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_172326851 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_172326851;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.670 -0400", hash_original_method = "CEBBD6265454356FCC4FE657D9359767", hash_generated_method = "6DBC22D0801F8236A0CD1AC9C7B1292D")
    public byte[] getData() {
        {
            byte[] var09DAD4E7AF301F104761D7FD07F9EB60_831798590 = (memoryOutputStream.toByteArray());
        } 
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1531935852 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1531935852;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.670 -0400", hash_original_method = "2FAEE05DD81B3DF9BBBB7355A430983C", hash_generated_method = "89312090196F7C3EED4A85765765F0E8")
    public File getFile() {
        File varB4EAC82CA7396A68D541C85D26508E83_1776663472 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1776663472 = outputFile;
        varB4EAC82CA7396A68D541C85D26508E83_1776663472.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1776663472;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.671 -0400", hash_original_method = "C7FCBD344022D72FF18766A4DFEA8EE1", hash_generated_method = "DCC0D06E7F79ED3EAE0E8D99DD76C5B5")
    @Override
    public void close() throws IOException {
        super.close();
        closed = true;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.671 -0400", hash_original_method = "EDA7487DCECD411B0E9FBCE942C20A22", hash_generated_method = "0721CBF58F787AE255730C892EC8FE8E")
    public void writeTo(OutputStream out) throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("Stream not closed");
        } 
        {
            boolean varBCECD79AA34B2E7F7193471A45415FDC_1665149498 = (isInMemory());
            {
                memoryOutputStream.writeTo(out);
            } 
            {
                FileInputStream fis = new FileInputStream(outputFile);
                try 
                {
                    IOUtils.copy(fis, out);
                } 
                finally 
                {
                    IOUtils.closeQuietly(fis);
                } 
            } 
        } 
        addTaint(out.getTaint());
        
        
        
            
        
        
        
            
        
        
        
            
            
                
            
                
            
        
    }

    
}

