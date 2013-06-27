package android.support.v4.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class AtomicFile {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:34.688 -0400", hash_original_field = "C3FD8FFD23ACFE4E16816CFE1B1C32CF", hash_generated_field = "AB7EB62D4846E04C9549A0F948CCC84A")

    private File mBaseName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:34.688 -0400", hash_original_field = "B2FEECD946B3DC4B664EEE2321D53EB7", hash_generated_field = "05FBF0A6813A8D6E5E2596945AF63AA3")

    private File mBackupName;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:34.688 -0400", hash_original_method = "4B5AD0CA4BAB4787DEF9E50D606D6D18", hash_generated_method = "4845B50C2624F2B3D352524A4402108A")
    public  AtomicFile(File baseName) {
        mBaseName = baseName;
        mBackupName = new File(baseName.getPath() + ".bak");
        // ---------- Original Method ----------
        //mBaseName = baseName;
        //mBackupName = new File(baseName.getPath() + ".bak");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:34.689 -0400", hash_original_method = "9A558AA4F639B650B9F7EAEB27AD7615", hash_generated_method = "DE9DC020D807B69F98D50EB2D56A6F6D")
    public File getBaseFile() {
        File varB4EAC82CA7396A68D541C85D26508E83_489952207 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_489952207 = mBaseName;
        varB4EAC82CA7396A68D541C85D26508E83_489952207.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_489952207;
        // ---------- Original Method ----------
        //return mBaseName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:34.689 -0400", hash_original_method = "FE68BA0A4FE7F98468ECE570B1E66422", hash_generated_method = "329A284779AA09BF2760311937FBD7AA")
    public void delete() {
        mBaseName.delete();
        mBackupName.delete();
        // ---------- Original Method ----------
        //mBaseName.delete();
        //mBackupName.delete();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:34.700 -0400", hash_original_method = "12832995E7C43A063591E6E78BE27D07", hash_generated_method = "78A554B38AAD3E82E2FE22442A5AE968")
    public FileOutputStream startWrite() throws IOException {
        FileOutputStream varB4EAC82CA7396A68D541C85D26508E83_436192955 = null; //Variable for return #1
        {
            boolean var1323D5E0F3BF0FA81A304BD4896667A7_254729003 = (mBaseName.exists());
            {
                {
                    boolean varAEE7D7A940AB3767149F806FF409A126_1311794581 = (!mBackupName.exists());
                    {
                        {
                            boolean varCCE4FE125A8CE4C392A8A729DA52A607_1916921047 = (!mBaseName.renameTo(mBackupName));
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
                boolean var59EAC8754CECCC6B5E5BC1C021900B45_2024060529 = (!parent.mkdir());
                {
                    if (DroidSafeAndroidRuntime.control) throw new IOException("Couldn't create directory " + mBaseName);
                } //End block
            } //End collapsed parenthetic
            try 
            {
                str = new FileOutputStream(mBaseName);
            } //End block
            catch (FileNotFoundException e2)
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException("Couldn't create " + mBaseName);
            } //End block
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_436192955 = str;
        varB4EAC82CA7396A68D541C85D26508E83_436192955.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_436192955;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:34.713 -0400", hash_original_method = "410EDD5A3D4FEFF4FD493FA486BCF8EE", hash_generated_method = "EBFDFBCB73CF33D9EA685161E6D3B507")
    public void finishWrite(FileOutputStream str) {
        {
            sync(str);
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
            //sync(str);
            //try {
                //str.close();
                //mBackupName.delete();
            //} catch (IOException e) {
                //Log.w("AtomicFile", "finishWrite: Got exception:", e);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:34.713 -0400", hash_original_method = "71F10F93B6BC235D738FD59F1AECD302", hash_generated_method = "1F7C341654E0CE1F64028ED92FAE5978")
    public void failWrite(FileOutputStream str) {
        {
            sync(str);
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
            //sync(str);
            //try {
                //str.close();
                //mBaseName.delete();
                //mBackupName.renameTo(mBaseName);
            //} catch (IOException e) {
                //Log.w("AtomicFile", "failWrite: Got exception:", e);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:34.714 -0400", hash_original_method = "1A78B3BB099030EABAF4D8DEC5E5F129", hash_generated_method = "1D94B0EC4ABB17D00CEE2896FA845380")
    public FileInputStream openRead() throws FileNotFoundException {
        FileInputStream varB4EAC82CA7396A68D541C85D26508E83_2145095037 = null; //Variable for return #1
        {
            boolean varCEF6CEE2C4C63504BA214A7A02CF53A4_1198597726 = (mBackupName.exists());
            {
                mBaseName.delete();
                mBackupName.renameTo(mBaseName);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_2145095037 = new FileInputStream(mBaseName);
        varB4EAC82CA7396A68D541C85D26508E83_2145095037.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2145095037;
        // ---------- Original Method ----------
        //if (mBackupName.exists()) {
            //mBaseName.delete();
            //mBackupName.renameTo(mBaseName);
        //}
        //return new FileInputStream(mBaseName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:34.727 -0400", hash_original_method = "69475477B3077359758F883E80DC53D4", hash_generated_method = "105E4549FB4F375C24A32F78EB109BE7")
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
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_242035700 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_242035700;
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

    
        static boolean sync(FileOutputStream stream) {
        try {
            if (stream != null) {
                stream.getFD().sync();
            }
            return true;
        } catch (IOException e) {
        }
        return false;
    }

    
}

