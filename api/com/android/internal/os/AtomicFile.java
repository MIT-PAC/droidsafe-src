package com.android.internal.os;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.FileUtils;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class AtomicFile {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:18.885 -0400", hash_original_field = "C3FD8FFD23ACFE4E16816CFE1B1C32CF", hash_generated_field = "AB7EB62D4846E04C9549A0F948CCC84A")

    private File mBaseName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:18.885 -0400", hash_original_field = "B2FEECD946B3DC4B664EEE2321D53EB7", hash_generated_field = "05FBF0A6813A8D6E5E2596945AF63AA3")

    private File mBackupName;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:18.886 -0400", hash_original_method = "4B5AD0CA4BAB4787DEF9E50D606D6D18", hash_generated_method = "4845B50C2624F2B3D352524A4402108A")
    public  AtomicFile(File baseName) {
        mBaseName = baseName;
        mBackupName = new File(baseName.getPath() + ".bak");
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:18.886 -0400", hash_original_method = "9A558AA4F639B650B9F7EAEB27AD7615", hash_generated_method = "96ED4E1FBCB51B1E78F8ED474CE7869A")
    public File getBaseFile() {
File var3159B9DA1820FE9B195E6E0FE8FEB2CB_1766173871 =         mBaseName;
        var3159B9DA1820FE9B195E6E0FE8FEB2CB_1766173871.addTaint(taint);
        return var3159B9DA1820FE9B195E6E0FE8FEB2CB_1766173871;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:18.887 -0400", hash_original_method = "3A4012A9534B3FE136043C6A101CE434", hash_generated_method = "71486F296209CFE8634803B0AF86746D")
    public FileOutputStream startWrite() throws IOException {
    if(mBaseName.exists())        
        {
    if(!mBackupName.exists())            
            {
    if(!mBaseName.renameTo(mBackupName))                
                {
                } 
            } 
            else
            {
                mBaseName.delete();
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
    if(!parent.mkdir())            
            {
                IOException var93E80C5AEA7236343C539F8482239D40_770411921 = new IOException("Couldn't create directory " + mBaseName);
                var93E80C5AEA7236343C539F8482239D40_770411921.addTaint(taint);
                throw var93E80C5AEA7236343C539F8482239D40_770411921;
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
                IOException var66986A0D2FFF21E9D34211DD32CEA621_2065422849 = new IOException("Couldn't create " + mBaseName);
                var66986A0D2FFF21E9D34211DD32CEA621_2065422849.addTaint(taint);
                throw var66986A0D2FFF21E9D34211DD32CEA621_2065422849;
            } 
        } 
FileOutputStream var061B89662D09DE43FE2A2D88636258A2_1950314063 =         str;
        var061B89662D09DE43FE2A2D88636258A2_1950314063.addTaint(taint);
        return var061B89662D09DE43FE2A2D88636258A2_1950314063;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:18.887 -0400", hash_original_method = "D04158B1AAD606E61A919B5845F356D0", hash_generated_method = "6C1C9530AC3DAA1D29A744FC6075B344")
    public void finishWrite(FileOutputStream str) {
        addTaint(str.getTaint());
    if(str != null)        
        {
            FileUtils.sync(str);
            try 
            {
                str.close();
                mBackupName.delete();
            } 
            catch (IOException e)
            {
            } 
        } 
        
        
            
            
                
                
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:18.888 -0400", hash_original_method = "4F4EB111C51C134B2301DB792D42BE44", hash_generated_method = "67F239FB115E25F06CA9D8752F455A9B")
    public void failWrite(FileOutputStream str) {
        addTaint(str.getTaint());
    if(str != null)        
        {
            FileUtils.sync(str);
            try 
            {
                str.close();
                mBaseName.delete();
                mBackupName.renameTo(mBaseName);
            } 
            catch (IOException e)
            {
            } 
        } 
        
        
            
            
                
                
                
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:18.888 -0400", hash_original_method = "9D6541EF95DD6CE6D6599F106C94D734", hash_generated_method = "1BBABFB53FE94A6CD8739EB891A82AC9")
    public FileOutputStream openAppend() throws IOException {
        try 
        {
FileOutputStream var9DC698F848EB30D5DB0E737C03EA529F_989104571 =             new FileOutputStream(mBaseName, true);
            var9DC698F848EB30D5DB0E737C03EA529F_989104571.addTaint(taint);
            return var9DC698F848EB30D5DB0E737C03EA529F_989104571;
        } 
        catch (FileNotFoundException e)
        {
            IOException var0AB19DAFC7C56311DB5577169867305B_440368685 = new IOException("Couldn't append " + mBaseName);
            var0AB19DAFC7C56311DB5577169867305B_440368685.addTaint(taint);
            throw var0AB19DAFC7C56311DB5577169867305B_440368685;
        } 
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:18.888 -0400", hash_original_method = "057A1C42B6EC5037516E78678BBEEE23", hash_generated_method = "DA57A2EE572B2F7554487A42AAC57841")
    public void truncate() throws IOException {
        try 
        {
            FileOutputStream fos = new FileOutputStream(mBaseName);
            FileUtils.sync(fos);
            fos.close();
        } 
        catch (FileNotFoundException e)
        {
            IOException var0AB19DAFC7C56311DB5577169867305B_2116074740 = new IOException("Couldn't append " + mBaseName);
            var0AB19DAFC7C56311DB5577169867305B_2116074740.addTaint(taint);
            throw var0AB19DAFC7C56311DB5577169867305B_2116074740;
        } 
        catch (IOException e)
        {
        } 
        
        
            
            
            
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:18.889 -0400", hash_original_method = "1A78B3BB099030EABAF4D8DEC5E5F129", hash_generated_method = "B09936829F4DC3F164309AD6BBB2F073")
    public FileInputStream openRead() throws FileNotFoundException {
    if(mBackupName.exists())        
        {
            mBaseName.delete();
            mBackupName.renameTo(mBaseName);
        } 
FileInputStream var59D1E0F00673AB4D53EFD779A964E7E0_1660242543 =         new FileInputStream(mBaseName);
        var59D1E0F00673AB4D53EFD779A964E7E0_1660242543.addTaint(taint);
        return var59D1E0F00673AB4D53EFD779A964E7E0_1660242543;
        
        
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:18.890 -0400", hash_original_method = "69475477B3077359758F883E80DC53D4", hash_generated_method = "1C6609962BB4E4B288F95DC2508ECC4A")
    public byte[] readFully() throws IOException {
        FileInputStream stream = openRead();
        try 
        {
            int pos = 0;
            int avail = stream.available();
            byte[] data = new byte[avail];
            while
(true)            
            {
                int amt = stream.read(data, pos, data.length-pos);
    if(amt <= 0)                
                {
                    byte[] var8D777F385D3DFEC8815D20F7496026DC_35336702 = (data);
                                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1269048871 = {getTaintByte()};
                    return var2F9C81BC6E497382285CD6B7A7E33DE1_1269048871;
                } 
                pos += amt;
                avail = stream.available();
    if(avail > data.length-pos)                
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
        
        
        
            
            
            
            
                
                
                    
                
                
                
                
                    
                    
                    
                
            
        
            
        
    }

    
}

