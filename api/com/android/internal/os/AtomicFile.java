package com.android.internal.os;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.os.FileUtils;





public class AtomicFile {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:50.284 -0500", hash_original_field = "0EF2CCD9F04729765DB1F68752E0F610", hash_generated_field = "AB7EB62D4846E04C9549A0F948CCC84A")

    private  File mBaseName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:50.287 -0500", hash_original_field = "28F1ABD789DDE37ACEB8C5F11FA1328F", hash_generated_field = "05FBF0A6813A8D6E5E2596945AF63AA3")

    private  File mBackupName;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:50.289 -0500", hash_original_method = "4B5AD0CA4BAB4787DEF9E50D606D6D18", hash_generated_method = "B8BF78A2C42DF8A207F0CE28FF8926A5")
    
public AtomicFile(File baseName) {
        mBaseName = baseName;
        mBackupName = new File(baseName.getPath() + ".bak");
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:50.291 -0500", hash_original_method = "9A558AA4F639B650B9F7EAEB27AD7615", hash_generated_method = "E09F7B21F8463E6D961987C1D71EC0B8")
    
public File getBaseFile() {
        return mBaseName;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:50.295 -0500", hash_original_method = "3A4012A9534B3FE136043C6A101CE434", hash_generated_method = "0C5E2D28995D10BD57413E594FF90D47")
    
public FileOutputStream startWrite() throws IOException {
        // Rename the current file so it may be used as a backup during the next read
        if (mBaseName.exists()) {
            if (!mBackupName.exists()) {
                if (!mBaseName.renameTo(mBackupName)) {
                    Log.w("AtomicFile", "Couldn't rename file " + mBaseName
                            + " to backup file " + mBackupName);
                }
            } else {
                mBaseName.delete();
            }
        }
        FileOutputStream str = null;
        try {
            str = new FileOutputStream(mBaseName);
        } catch (FileNotFoundException e) {
            File parent = mBaseName.getParentFile();
            if (!parent.mkdir()) {
                throw new IOException("Couldn't create directory " + mBaseName);
            }
            FileUtils.setPermissions(
                parent.getPath(),
                FileUtils.S_IRWXU|FileUtils.S_IRWXG|FileUtils.S_IXOTH,
                -1, -1);
            try {
                str = new FileOutputStream(mBaseName);
            } catch (FileNotFoundException e2) {
                throw new IOException("Couldn't create " + mBaseName);
            }
        }
        return str;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:50.297 -0500", hash_original_method = "D04158B1AAD606E61A919B5845F356D0", hash_generated_method = "E9EF6869C45210F9694BD7A340EB367E")
    
public void finishWrite(FileOutputStream str) {
        if (str != null) {
            FileUtils.sync(str);
            try {
                str.close();
                mBackupName.delete();
            } catch (IOException e) {
                Log.w("AtomicFile", "finishWrite: Got exception:", e);
            }
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:50.300 -0500", hash_original_method = "4F4EB111C51C134B2301DB792D42BE44", hash_generated_method = "8500917FC369FE80172E61E1136EEA8C")
    
public void failWrite(FileOutputStream str) {
        if (str != null) {
            FileUtils.sync(str);
            try {
                str.close();
                mBaseName.delete();
                mBackupName.renameTo(mBaseName);
            } catch (IOException e) {
                Log.w("AtomicFile", "failWrite: Got exception:", e);
            }
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:50.302 -0500", hash_original_method = "9D6541EF95DD6CE6D6599F106C94D734", hash_generated_method = "559993A72B384FB6EEB7CE268F3590A5")
    
public FileOutputStream openAppend() throws IOException {
        try {
            return new FileOutputStream(mBaseName, true);
        } catch (FileNotFoundException e) {
            throw new IOException("Couldn't append " + mBaseName);
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:50.304 -0500", hash_original_method = "057A1C42B6EC5037516E78678BBEEE23", hash_generated_method = "4418F3D6EF001028221D4E2CB6F95ABF")
    
public void truncate() throws IOException {
        try {
            FileOutputStream fos = new FileOutputStream(mBaseName);
            FileUtils.sync(fos);
            fos.close();
        } catch (FileNotFoundException e) {
            throw new IOException("Couldn't append " + mBaseName);
        } catch (IOException e) {
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:50.307 -0500", hash_original_method = "1A78B3BB099030EABAF4D8DEC5E5F129", hash_generated_method = "F1099AF04C67A26CC31E5F75C97D05A4")
    
public FileInputStream openRead() throws FileNotFoundException {
        if (mBackupName.exists()) {
            mBaseName.delete();
            mBackupName.renameTo(mBaseName);
        }
        return new FileInputStream(mBaseName);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:50.309 -0500", hash_original_method = "69475477B3077359758F883E80DC53D4", hash_generated_method = "38F70CCCEE755E1F4C3094935B1F75BA")
    
public byte[] readFully() throws IOException {
        FileInputStream stream = openRead();
        try {
            int pos = 0;
            int avail = stream.available();
            byte[] data = new byte[avail];
            while (true) {
                int amt = stream.read(data, pos, data.length-pos);
                //Log.i("foo", "Read " + amt + " bytes at " + pos
                //        + " of avail " + data.length);
                if (amt <= 0) {
                    //Log.i("foo", "**** FINISHED READING: pos=" + pos
                    //        + " len=" + data.length);
                    return data;
                }
                pos += amt;
                avail = stream.available();
                if (avail > data.length-pos) {
                    byte[] newData = new byte[pos+avail];
                    System.arraycopy(data, 0, newData, 0, pos);
                    data = newData;
                }
            }
        } finally {
            stream.close();
        }
    }

    
}

