package com.android.internal.os;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.os.FileUtils;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class AtomicFile {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:19.456 -0400", hash_original_field = "C3FD8FFD23ACFE4E16816CFE1B1C32CF", hash_generated_field = "AB7EB62D4846E04C9549A0F948CCC84A")

    private File mBaseName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:19.456 -0400", hash_original_field = "B2FEECD946B3DC4B664EEE2321D53EB7", hash_generated_field = "05FBF0A6813A8D6E5E2596945AF63AA3")

    private File mBackupName;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:19.457 -0400", hash_original_method = "4B5AD0CA4BAB4787DEF9E50D606D6D18", hash_generated_method = "4845B50C2624F2B3D352524A4402108A")
    public  AtomicFile(File baseName) {
        mBaseName = baseName;
        mBackupName = new File(baseName.getPath() + ".bak");
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:19.457 -0400", hash_original_method = "9A558AA4F639B650B9F7EAEB27AD7615", hash_generated_method = "C3D2ACEF9417A7EE9EA8A01C417C090B")
    public File getBaseFile() {
        File varB4EAC82CA7396A68D541C85D26508E83_1648011473 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1648011473 = mBaseName;
        varB4EAC82CA7396A68D541C85D26508E83_1648011473.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1648011473;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:19.458 -0400", hash_original_method = "3A4012A9534B3FE136043C6A101CE434", hash_generated_method = "E371241176FBA23816080CB3FE41A7C3")
    public FileOutputStream startWrite() throws IOException {
        FileOutputStream varB4EAC82CA7396A68D541C85D26508E83_829117247 = null; 
        {
            boolean var1323D5E0F3BF0FA81A304BD4896667A7_175736476 = (mBaseName.exists());
            {
                {
                    boolean varAEE7D7A940AB3767149F806FF409A126_453928848 = (!mBackupName.exists());
                    {
                        {
                            boolean varCCE4FE125A8CE4C392A8A729DA52A607_1477078295 = (!mBaseName.renameTo(mBackupName));
                        } 
                    } 
                    {
                        mBaseName.delete();
                    } 
                } 
            } 
        } 
        FileOutputStream str = null;
        try 
        {
            str = new FileOutputStream(mBaseName);
        } 
        catch (FileNotFoundException e)
        {
            File parent = mBaseName.getParentFile();
            {
                boolean var59EAC8754CECCC6B5E5BC1C021900B45_1749048260 = (!parent.mkdir());
                {
                    if (DroidSafeAndroidRuntime.control) throw new IOException("Couldn't create directory " + mBaseName);
                } 
            } 
            FileUtils.setPermissions(
                parent.getPath(),
                FileUtils.S_IRWXU|FileUtils.S_IRWXG|FileUtils.S_IXOTH,
                -1, -1);
            try 
            {
                str = new FileOutputStream(mBaseName);
            } 
            catch (FileNotFoundException e2)
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException("Couldn't create " + mBaseName);
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_829117247 = str;
        varB4EAC82CA7396A68D541C85D26508E83_829117247.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_829117247;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:19.459 -0400", hash_original_method = "D04158B1AAD606E61A919B5845F356D0", hash_generated_method = "8C401A23E3044EC84AB14A912731A68D")
    public void finishWrite(FileOutputStream str) {
        {
            FileUtils.sync(str);
            try 
            {
                str.close();
                mBackupName.delete();
            } 
            catch (IOException e)
            { }
        } 
        addTaint(str.getTaint());
        
        
            
            
                
                
            
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:19.460 -0400", hash_original_method = "4F4EB111C51C134B2301DB792D42BE44", hash_generated_method = "83BCB63F187269805C337B0BDE579DE5")
    public void failWrite(FileOutputStream str) {
        {
            FileUtils.sync(str);
            try 
            {
                str.close();
                mBaseName.delete();
                mBackupName.renameTo(mBaseName);
            } 
            catch (IOException e)
            { }
        } 
        addTaint(str.getTaint());
        
        
            
            
                
                
                
            
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:19.461 -0400", hash_original_method = "9D6541EF95DD6CE6D6599F106C94D734", hash_generated_method = "57681D801F020EBB1C39B29D4575EC8A")
    public FileOutputStream openAppend() throws IOException {
        FileOutputStream varB4EAC82CA7396A68D541C85D26508E83_562640381 = null; 
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_562640381 = new FileOutputStream(mBaseName, true);
        } 
        catch (FileNotFoundException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("Couldn't append " + mBaseName);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_562640381.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_562640381;
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:19.462 -0400", hash_original_method = "057A1C42B6EC5037516E78678BBEEE23", hash_generated_method = "1FC7465D04B740FF5F7D171C3913BF51")
    public void truncate() throws IOException {
        try 
        {
            FileOutputStream fos = new FileOutputStream(mBaseName);
            FileUtils.sync(fos);
            fos.close();
        } 
        catch (FileNotFoundException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("Couldn't append " + mBaseName);
        } 
        catch (IOException e)
        { }
        
        
            
            
            
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:19.463 -0400", hash_original_method = "1A78B3BB099030EABAF4D8DEC5E5F129", hash_generated_method = "4C928B7544D31ECE3BFC1A029D77BB16")
    public FileInputStream openRead() throws FileNotFoundException {
        FileInputStream varB4EAC82CA7396A68D541C85D26508E83_1730510810 = null; 
        {
            boolean varCEF6CEE2C4C63504BA214A7A02CF53A4_1501755009 = (mBackupName.exists());
            {
                mBaseName.delete();
                mBackupName.renameTo(mBaseName);
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1730510810 = new FileInputStream(mBaseName);
        varB4EAC82CA7396A68D541C85D26508E83_1730510810.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1730510810;
        
        
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:19.463 -0400", hash_original_method = "69475477B3077359758F883E80DC53D4", hash_generated_method = "E977B34A29CD2E48D013976F9E058FD0")
    public byte[] readFully() throws IOException {
        FileInputStream stream = openRead();
        try 
        {
            int pos = 0;
            int avail = stream.available();
            byte[] data = new byte[avail];
            {
                int amt = stream.read(data, pos, data.length-pos);
                pos += amt;
                avail = stream.available();
                {
                    byte[] newData = new byte[pos+avail];
                    System.arraycopy(data, 0, newData, 0, pos);
                    data = newData;
                } 
            } 
        } 
        finally 
        {
            stream.close();
        } 
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1614693247 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1614693247;
        
        
        
            
            
            
            
                
                
                    
                
                
                
                
                    
                    
                    
                
            
        
            
        
    }

    
}

