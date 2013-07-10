package org.apache.commons.io.filefilter;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.util.Arrays;
import org.apache.commons.io.IOUtils;

public class MagicNumberFileFilter extends AbstractFileFilter implements Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.813 -0400", hash_original_field = "13FC37855C259675D642D1E909CA4D05", hash_generated_field = "43B4B88F8872CE70BC0ACCCB066E1B74")

    private byte[] magicNumbers;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.813 -0400", hash_original_field = "747672084EE79DD5D3FA62FFFB692680", hash_generated_field = "EAC26F9C009071957019CBC1252212E9")

    private long byteOffset;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.814 -0400", hash_original_method = "C78AFEA84D3E16F05915DC512C12F4E5", hash_generated_method = "EDC715867B78B13AD3D49925A24AB8D2")
    public  MagicNumberFileFilter(byte[] magicNumber) {
        this(magicNumber, 0);
        addTaint(magicNumber[0]);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.814 -0400", hash_original_method = "46FC766430A04DE64FCA15E7760EC637", hash_generated_method = "FF2C6EB63A99DA454E02E1DA64EA61EA")
    public  MagicNumberFileFilter(String magicNumber) {
        this(magicNumber, 0);
        addTaint(magicNumber.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.814 -0400", hash_original_method = "DEAF1CD32A03908C66FCBD851D1A4D16", hash_generated_method = "041E5DB38AE091D75E6546B210080851")
    public  MagicNumberFileFilter(String magicNumber, long offset) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("The magic number cannot be null");
        } 
        {
            boolean var8D68F61BC62A144C3DC618700C0337A2_1226362526 = (magicNumber.length() == 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("The magic number must contain at least one byte");
            } 
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("The offset cannot be negative");
        } 
        this.magicNumbers = magicNumber.getBytes();
        this.byteOffset = offset;
        
        
            
        
        
            
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.815 -0400", hash_original_method = "D2ACF25BC388A9DF48A2CB806BA6CFAE", hash_generated_method = "4FA0FED05C3DE9116D3D64021BAB2374")
    public  MagicNumberFileFilter(byte[] magicNumber, long offset) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("The magic number cannot be null");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("The magic number must contain at least one byte");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("The offset cannot be negative");
        } 
        this.magicNumbers = new byte[magicNumber.length];
        System.arraycopy(magicNumber, 0, this.magicNumbers, 0, magicNumber.length);
        this.byteOffset = offset;
        
        
            
        
        
            
        
        
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.815 -0400", hash_original_method = "B71D2F390F50A93DB66E9BFC22DCB2BE", hash_generated_method = "11743899575A052A9611DA5E6859EAD2")
    @Override
    public boolean accept(File file) {
        {
            boolean var2C56F8140BFB13474DA89180C4D6AD9D_1133321438 = (file != null && file.isFile() && file.canRead());
            {
                RandomAccessFile randomAccessFile = null;
                try 
                {
                    byte[] fileBytes = new byte[this.magicNumbers.length];
                    randomAccessFile = new RandomAccessFile(file, "r");
                    randomAccessFile.seek(byteOffset);
                    int read = randomAccessFile.read(fileBytes);
                    boolean varE564DDF876A3E0FBD38EFF53C02D3D07_1443249057 = (Arrays.equals(this.magicNumbers, fileBytes));
                } 
                catch (IOException ioe)
                { }
                finally 
                {
                    IOUtils.closeQuietly(randomAccessFile);
                } 
            } 
        } 
        addTaint(file.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_864818671 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_864818671;
        
        
            
            
                
                
                
                
                
                    
                
                
            
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.816 -0400", hash_original_method = "CB513BDE86C193A798DC85AC9115E8A4", hash_generated_method = "CDC0A95AF659AF2CF7559E84BA93BB8B")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_2021137842 = null; 
        StringBuilder builder = new StringBuilder(super.toString());
        builder.append("(");
        builder.append(new String(magicNumbers));
        builder.append(",");
        builder.append(this.byteOffset);
        builder.append(")");
        varB4EAC82CA7396A68D541C85D26508E83_2021137842 = builder.toString();
        varB4EAC82CA7396A68D541C85D26508E83_2021137842.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2021137842;
        
        
        
        
        
        
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.816 -0400", hash_original_field = "FBCB37A1E33C99FA744AAB732452D4C7", hash_generated_field = "3D72E565CCDBEA9E9149D396EC67955D")

    private static final long serialVersionUID = -547733176983104172L;
}

