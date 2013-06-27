package com.android.internal.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.FileUtils;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class AtomicFile {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.302 -0400", hash_original_field = "C3FD8FFD23ACFE4E16816CFE1B1C32CF", hash_generated_field = "AB7EB62D4846E04C9549A0F948CCC84A")

    private File mBaseName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.302 -0400", hash_original_field = "B2FEECD946B3DC4B664EEE2321D53EB7", hash_generated_field = "05FBF0A6813A8D6E5E2596945AF63AA3")

    private File mBackupName;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.309 -0400", hash_original_method = "4B5AD0CA4BAB4787DEF9E50D606D6D18", hash_generated_method = "4845B50C2624F2B3D352524A4402108A")
    public  AtomicFile(File baseName) {
        mBaseName = baseName;
        mBackupName = new File(baseName.getPath() + ".bak");
        // ---------- Original Method ----------
        //mBaseName = baseName;
        //mBackupName = new File(baseName.getPath() + ".bak");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.310 -0400", hash_original_method = "9A558AA4F639B650B9F7EAEB27AD7615", hash_generated_method = "05C81720BB68161690947B51B09CE8E1")
    public File getBaseFile() {
        File varB4EAC82CA7396A68D541C85D26508E83_565564656 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_565564656 = mBaseName;
        varB4EAC82CA7396A68D541C85D26508E83_565564656.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_565564656;
        // ---------- Original Method ----------
        //return mBaseName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.314 -0400", hash_original_method = "3A4012A9534B3FE136043C6A101CE434", hash_generated_method = "8040BED176421C6253F9C6925CD602AC")
    public FileOutputStream startWrite() throws IOException {
        FileOutputStream varB4EAC82CA7396A68D541C85D26508E83_1051367072 = null; //Variable for return #1
        {
            boolean var1323D5E0F3BF0FA81A304BD4896667A7_926641867 = (mBaseName.exists());
            {
                {
                    boolean varAEE7D7A940AB3767149F806FF409A126_1305223684 = (!mBackupName.exists());
                    {
                        {
                            boolean varCCE4FE125A8CE4C392A8A729DA52A607_1194062813 = (!mBaseName.renameTo(mBackupName));
                        } //End collapsed parenthetic
                    } //End block
                    {
                        mBaseName.delete();
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        FileOutputStream str;
        str = null;
        try 
        {
            str = new FileOutputStream(mBaseName);
        } //End block
        catch (FileNotFoundException e)
        {
            File parent;
            parent = mBaseName.getParentFile();
            {
                boolean var59EAC8754CECCC6B5E5BC1C021900B45_1148666923 = (!parent.mkdir());
                {
                    if (DroidSafeAndroidRuntime.control) throw new IOException("Couldn't create directory " + mBaseName);
                } //End block
            } //End collapsed parenthetic
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
                if (DroidSafeAndroidRuntime.control) throw new IOException("Couldn't create " + mBaseName);
            } //End block
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1051367072 = str;
        varB4EAC82CA7396A68D541C85D26508E83_1051367072.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1051367072;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.315 -0400", hash_original_method = "D04158B1AAD606E61A919B5845F356D0", hash_generated_method = "8C401A23E3044EC84AB14A912731A68D")
    public void finishWrite(FileOutputStream str) {
        {
            FileUtils.sync(str);
            try 
            {
                str.close();
                mBackupName.delete();
            } //End block
            catch (IOException e)
            { }
        } //End block
        addTaint(str.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.315 -0400", hash_original_method = "4F4EB111C51C134B2301DB792D42BE44", hash_generated_method = "83BCB63F187269805C337B0BDE579DE5")
    public void failWrite(FileOutputStream str) {
        {
            FileUtils.sync(str);
            try 
            {
                str.close();
                mBaseName.delete();
                mBackupName.renameTo(mBaseName);
            } //End block
            catch (IOException e)
            { }
        } //End block
        addTaint(str.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.330 -0400", hash_original_method = "9D6541EF95DD6CE6D6599F106C94D734", hash_generated_method = "0BBA86B4948407071A343CA4AD3C533D")
    public FileOutputStream openAppend() throws IOException {
        FileOutputStream varB4EAC82CA7396A68D541C85D26508E83_573993868 = null; //Variable for return #1
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_573993868 = new FileOutputStream(mBaseName, true);
        } //End block
        catch (FileNotFoundException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("Couldn't append " + mBaseName);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_573993868.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_573993868;
        // ---------- Original Method ----------
        //try {
            //return new FileOutputStream(mBaseName, true);
        //} catch (FileNotFoundException e) {
            //throw new IOException("Couldn't append " + mBaseName);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.332 -0400", hash_original_method = "057A1C42B6EC5037516E78678BBEEE23", hash_generated_method = "C2BCF239F3EDB5283E9161B0CCDC2DAD")
    public void truncate() throws IOException {
        try 
        {
            FileOutputStream fos;
            fos = new FileOutputStream(mBaseName);
            FileUtils.sync(fos);
            fos.close();
        } //End block
        catch (FileNotFoundException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("Couldn't append " + mBaseName);
        } //End block
        catch (IOException e)
        { }
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.336 -0400", hash_original_method = "1A78B3BB099030EABAF4D8DEC5E5F129", hash_generated_method = "FF3A14FCCAF3E127636BCFB685845E11")
    public FileInputStream openRead() throws FileNotFoundException {
        FileInputStream varB4EAC82CA7396A68D541C85D26508E83_100315857 = null; //Variable for return #1
        {
            boolean varCEF6CEE2C4C63504BA214A7A02CF53A4_571296418 = (mBackupName.exists());
            {
                mBaseName.delete();
                mBackupName.renameTo(mBaseName);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_100315857 = new FileInputStream(mBaseName);
        varB4EAC82CA7396A68D541C85D26508E83_100315857.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_100315857;
        // ---------- Original Method ----------
        //if (mBackupName.exists()) {
            //mBaseName.delete();
            //mBackupName.renameTo(mBaseName);
        //}
        //return new FileInputStream(mBaseName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.341 -0400", hash_original_method = "69475477B3077359758F883E80DC53D4", hash_generated_method = "292199A7E524528364EAEF51DC1C6725")
    public byte[] readFully() throws IOException {
        FileInputStream stream;
        stream = openRead();
        try 
        {
            int pos;
            pos = 0;
            int avail;
            avail = stream.available();
            byte[] data;
            data = new byte[avail];
            {
                int amt;
                amt = stream.read(data, pos, data.length-pos);
                pos += amt;
                avail = stream.available();
                {
                    byte[] newData;
                    newData = new byte[pos+avail];
                    System.arraycopy(data, 0, newData, 0, pos);
                    data = newData;
                } //End block
            } //End block
        } //End block
        finally 
        {
            stream.close();
        } //End block
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_646334626 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_646334626;
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

