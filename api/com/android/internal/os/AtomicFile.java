package com.android.internal.os;

// Droidsafe Imports
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.os.FileUtils;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class AtomicFile {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.449 -0400", hash_original_field = "C3FD8FFD23ACFE4E16816CFE1B1C32CF", hash_generated_field = "AB7EB62D4846E04C9549A0F948CCC84A")

    private File mBaseName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.449 -0400", hash_original_field = "B2FEECD946B3DC4B664EEE2321D53EB7", hash_generated_field = "05FBF0A6813A8D6E5E2596945AF63AA3")

    private File mBackupName;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.450 -0400", hash_original_method = "4B5AD0CA4BAB4787DEF9E50D606D6D18", hash_generated_method = "4845B50C2624F2B3D352524A4402108A")
    public  AtomicFile(File baseName) {
        mBaseName = baseName;
        mBackupName = new File(baseName.getPath() + ".bak");
        // ---------- Original Method ----------
        //mBaseName = baseName;
        //mBackupName = new File(baseName.getPath() + ".bak");
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.450 -0400", hash_original_method = "9A558AA4F639B650B9F7EAEB27AD7615", hash_generated_method = "1BDD1B80A7C74A0EB7E31A5CC9CE637F")
    public File getBaseFile() {
File var3159B9DA1820FE9B195E6E0FE8FEB2CB_1812383174 =         mBaseName;
        var3159B9DA1820FE9B195E6E0FE8FEB2CB_1812383174.addTaint(taint);
        return var3159B9DA1820FE9B195E6E0FE8FEB2CB_1812383174;
        // ---------- Original Method ----------
        //return mBaseName;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.451 -0400", hash_original_method = "3A4012A9534B3FE136043C6A101CE434", hash_generated_method = "43C5D4744462D7456B5BC64534BEE23A")
    public FileOutputStream startWrite() throws IOException {
        if(mBaseName.exists())        
        {
            if(!mBackupName.exists())            
            {
                if(!mBaseName.renameTo(mBackupName))                
                {
                } //End block
            } //End block
            else
            {
                mBaseName.delete();
            } //End block
        } //End block
        FileOutputStream str = null;
        try 
        {
            str = new FileOutputStream(mBaseName);
        } //End block
        catch (FileNotFoundException e)
        {
            File parent = mBaseName.getParentFile();
            if(!parent.mkdir())            
            {
                IOException var93E80C5AEA7236343C539F8482239D40_612765747 = new IOException("Couldn't create directory " + mBaseName);
                var93E80C5AEA7236343C539F8482239D40_612765747.addTaint(taint);
                throw var93E80C5AEA7236343C539F8482239D40_612765747;
            } //End block
            FileUtils.setPermissions(
                parent.getPath(),
                FileUtils.S_IRWXU|FileUtils.S_IRWXG|FileUtils.S_IXOTH,
                -1, -1);
            try 
            {
                str = new FileOutputStream(mBaseName);
            } //End block
            catch (FileNotFoundException e2)
            {
                IOException var66986A0D2FFF21E9D34211DD32CEA621_1897372628 = new IOException("Couldn't create " + mBaseName);
                var66986A0D2FFF21E9D34211DD32CEA621_1897372628.addTaint(taint);
                throw var66986A0D2FFF21E9D34211DD32CEA621_1897372628;
            } //End block
        } //End block
FileOutputStream var061B89662D09DE43FE2A2D88636258A2_1421759444 =         str;
        var061B89662D09DE43FE2A2D88636258A2_1421759444.addTaint(taint);
        return var061B89662D09DE43FE2A2D88636258A2_1421759444;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.451 -0400", hash_original_method = "D04158B1AAD606E61A919B5845F356D0", hash_generated_method = "6C1C9530AC3DAA1D29A744FC6075B344")
    public void finishWrite(FileOutputStream str) {
        addTaint(str.getTaint());
        if(str != null)        
        {
            FileUtils.sync(str);
            try 
            {
                str.close();
                mBackupName.delete();
            } //End block
            catch (IOException e)
            {
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (str != null) {
            //FileUtils.sync(str);
            //try {
                //str.close();
                //mBackupName.delete();
            //} catch (IOException e) {
                //Log.w("AtomicFile", "finishWrite: Got exception:", e);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.452 -0400", hash_original_method = "4F4EB111C51C134B2301DB792D42BE44", hash_generated_method = "67F239FB115E25F06CA9D8752F455A9B")
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
            } //End block
            catch (IOException e)
            {
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (str != null) {
            //FileUtils.sync(str);
            //try {
                //str.close();
                //mBaseName.delete();
                //mBackupName.renameTo(mBaseName);
            //} catch (IOException e) {
                //Log.w("AtomicFile", "failWrite: Got exception:", e);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.452 -0400", hash_original_method = "9D6541EF95DD6CE6D6599F106C94D734", hash_generated_method = "A0BFAF1EFA4F51B8C14A3AC1E769E2AC")
    public FileOutputStream openAppend() throws IOException {
        try 
        {
FileOutputStream var9DC698F848EB30D5DB0E737C03EA529F_729207677 =             new FileOutputStream(mBaseName, true);
            var9DC698F848EB30D5DB0E737C03EA529F_729207677.addTaint(taint);
            return var9DC698F848EB30D5DB0E737C03EA529F_729207677;
        } //End block
        catch (FileNotFoundException e)
        {
            IOException var0AB19DAFC7C56311DB5577169867305B_617664985 = new IOException("Couldn't append " + mBaseName);
            var0AB19DAFC7C56311DB5577169867305B_617664985.addTaint(taint);
            throw var0AB19DAFC7C56311DB5577169867305B_617664985;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return new FileOutputStream(mBaseName, true);
        //} catch (FileNotFoundException e) {
            //throw new IOException("Couldn't append " + mBaseName);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.453 -0400", hash_original_method = "057A1C42B6EC5037516E78678BBEEE23", hash_generated_method = "30F84CEBC4B705A641EBF627B93BA8AC")
    public void truncate() throws IOException {
        try 
        {
            FileOutputStream fos = new FileOutputStream(mBaseName);
            FileUtils.sync(fos);
            fos.close();
        } //End block
        catch (FileNotFoundException e)
        {
            IOException var0AB19DAFC7C56311DB5577169867305B_1666654076 = new IOException("Couldn't append " + mBaseName);
            var0AB19DAFC7C56311DB5577169867305B_1666654076.addTaint(taint);
            throw var0AB19DAFC7C56311DB5577169867305B_1666654076;
        } //End block
        catch (IOException e)
        {
        } //End block
        // ---------- Original Method ----------
        //try {
            //FileOutputStream fos = new FileOutputStream(mBaseName);
            //FileUtils.sync(fos);
            //fos.close();
        //} catch (FileNotFoundException e) {
            //throw new IOException("Couldn't append " + mBaseName);
        //} catch (IOException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.453 -0400", hash_original_method = "1A78B3BB099030EABAF4D8DEC5E5F129", hash_generated_method = "796AC1D538DFA365B60CE9622CB6817E")
    public FileInputStream openRead() throws FileNotFoundException {
        if(mBackupName.exists())        
        {
            mBaseName.delete();
            mBackupName.renameTo(mBaseName);
        } //End block
FileInputStream var59D1E0F00673AB4D53EFD779A964E7E0_1860480829 =         new FileInputStream(mBaseName);
        var59D1E0F00673AB4D53EFD779A964E7E0_1860480829.addTaint(taint);
        return var59D1E0F00673AB4D53EFD779A964E7E0_1860480829;
        // ---------- Original Method ----------
        //if (mBackupName.exists()) {
            //mBaseName.delete();
            //mBackupName.renameTo(mBaseName);
        //}
        //return new FileInputStream(mBaseName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.454 -0400", hash_original_method = "69475477B3077359758F883E80DC53D4", hash_generated_method = "01536A6D9FD12A7D184AAAE1CF66F2EC")
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
                    byte[] var8D777F385D3DFEC8815D20F7496026DC_1349776526 = (data);
                                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_2012169734 = {getTaintByte()};
                    return var2F9C81BC6E497382285CD6B7A7E33DE1_2012169734;
                } //End block
                pos += amt;
                avail = stream.available();
                if(avail > data.length-pos)                
                {
                    byte[] newData = new byte[pos+avail];
                    System.arraycopy(data, 0, newData, 0, pos);
                    data = newData;
                } //End block
            } //End block
        } //End block
        finally 
        {
            stream.close();
        } //End block
        // ---------- Original Method ----------
        //FileInputStream stream = openRead();
        //try {
            //int pos = 0;
            //int avail = stream.available();
            //byte[] data = new byte[avail];
            //while (true) {
                //int amt = stream.read(data, pos, data.length-pos);
                //if (amt <= 0) {
                    //return data;
                //}
                //pos += amt;
                //avail = stream.available();
                //if (avail > data.length-pos) {
                    //byte[] newData = new byte[pos+avail];
                    //System.arraycopy(data, 0, newData, 0, pos);
                    //data = newData;
                //}
            //}
        //} finally {
            //stream.close();
        //}
    }

    
}

