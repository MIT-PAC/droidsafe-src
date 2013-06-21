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
    private File mBaseName;
    private File mBackupName;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.192 -0400", hash_original_method = "4B5AD0CA4BAB4787DEF9E50D606D6D18", hash_generated_method = "EBEE86D439C7AEC0E13987B44B015997")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AtomicFile(File baseName) {
        dsTaint.addTaint(baseName.dsTaint);
        mBackupName = new File(baseName.getPath() + ".bak");
        // ---------- Original Method ----------
        //mBaseName = baseName;
        //mBackupName = new File(baseName.getPath() + ".bak");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.192 -0400", hash_original_method = "9A558AA4F639B650B9F7EAEB27AD7615", hash_generated_method = "0299780CCDC90D3BB68D49EE3D2CF29C")
    @DSModeled(DSC.SAFE)
    public File getBaseFile() {
        return (File)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mBaseName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.192 -0400", hash_original_method = "3A4012A9534B3FE136043C6A101CE434", hash_generated_method = "760DCF90A9B3EBD2DE3EE1D93FB41525")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public FileOutputStream startWrite() throws IOException {
        {
            boolean var1323D5E0F3BF0FA81A304BD4896667A7_682187059 = (mBaseName.exists());
            {
                {
                    boolean varAEE7D7A940AB3767149F806FF409A126_2105091979 = (!mBackupName.exists());
                    {
                        {
                            boolean varCCE4FE125A8CE4C392A8A729DA52A607_1163862628 = (!mBaseName.renameTo(mBackupName));
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
                boolean var59EAC8754CECCC6B5E5BC1C021900B45_813150810 = (!parent.mkdir());
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
        return (FileOutputStream)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.193 -0400", hash_original_method = "D04158B1AAD606E61A919B5845F356D0", hash_generated_method = "177CAF48B9BBABE98B76B1C04CB5664F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void finishWrite(FileOutputStream str) {
        dsTaint.addTaint(str.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.193 -0400", hash_original_method = "4F4EB111C51C134B2301DB792D42BE44", hash_generated_method = "E9791415DC9CB8AF095007C3BFCCD414")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void failWrite(FileOutputStream str) {
        dsTaint.addTaint(str.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.193 -0400", hash_original_method = "9D6541EF95DD6CE6D6599F106C94D734", hash_generated_method = "087FEE69BEF5DCF6141D049749EB56E3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public FileOutputStream openAppend() throws IOException {
        try 
        {
            FileOutputStream var55BD66CE0F553F197725682CB4A25D2F_20536587 = (new FileOutputStream(mBaseName, true));
        } //End block
        catch (FileNotFoundException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("Couldn't append " + mBaseName);
        } //End block
        return (FileOutputStream)dsTaint.getTaint();
        // ---------- Original Method ----------
        //try {
            //return new FileOutputStream(mBaseName, true);
        //} catch (FileNotFoundException e) {
            //throw new IOException("Couldn't append " + mBaseName);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.193 -0400", hash_original_method = "057A1C42B6EC5037516E78678BBEEE23", hash_generated_method = "C2BCF239F3EDB5283E9161B0CCDC2DAD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.194 -0400", hash_original_method = "1A78B3BB099030EABAF4D8DEC5E5F129", hash_generated_method = "20AFFC5C3082F60F85B4F9A37A3AC9E3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public FileInputStream openRead() throws FileNotFoundException {
        {
            boolean varCEF6CEE2C4C63504BA214A7A02CF53A4_656153866 = (mBackupName.exists());
            {
                mBaseName.delete();
                mBackupName.renameTo(mBaseName);
            } //End block
        } //End collapsed parenthetic
        FileInputStream var4235C54CA0B44520425973402E173C55_1621508912 = (new FileInputStream(mBaseName));
        return (FileInputStream)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mBackupName.exists()) {
            //mBaseName.delete();
            //mBackupName.renameTo(mBaseName);
        //}
        //return new FileInputStream(mBaseName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.194 -0400", hash_original_method = "69475477B3077359758F883E80DC53D4", hash_generated_method = "2E502E82E8BD8E3E1A73EC968CBF7AEA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
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

