package android.nfc.tech;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.nfc.ErrorCodes;
import android.nfc.Tag;
import android.nfc.TagLostException;
import android.nfc.TransceiveResult;
import android.os.RemoteException;
import android.util.Log;
import java.io.IOException;

abstract class BasicTagTechnology implements TagTechnology {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:24.844 -0400", hash_original_field = "07496860B5C53FDD66588727158D5F73", hash_generated_field = "26F2563105474DD2A79B3C79190EB5BE")

    Tag mTag;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:24.845 -0400", hash_original_field = "CC8BFB84898B22492B7F55096CBDF6CC", hash_generated_field = "C55D9286978463BA48249377B65E8F9B")

    boolean mIsConnected;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:24.845 -0400", hash_original_field = "D41A39E038C23551A3BE6A2957389ECC", hash_generated_field = "14A56D04133B1EA444C84A98B6F4BAF8")

    int mSelectedTechnology;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:24.868 -0400", hash_original_method = "D572C74E7520ED5167A849EF718161FC", hash_generated_method = "64090CC7213E0BD4071575620BFB8345")
      BasicTagTechnology(Tag tag, int tech) throws RemoteException {
        mTag = tag;
        mSelectedTechnology = tech;
        // ---------- Original Method ----------
        //mTag = tag;
        //mSelectedTechnology = tech;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:24.870 -0400", hash_original_method = "FC84E29499397B8918F938A8205313A1", hash_generated_method = "C0199A1E4C770683C976657AA735543B")
    @Override
    public Tag getTag() {
        Tag varB4EAC82CA7396A68D541C85D26508E83_619278672 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_619278672 = mTag;
        varB4EAC82CA7396A68D541C85D26508E83_619278672.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_619278672;
        // ---------- Original Method ----------
        //return mTag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:24.870 -0400", hash_original_method = "740AD223006A949AE0C5FC9EABD0A7B2", hash_generated_method = "6BEB536F64A20AA0A28350A43408E66D")
     void checkConnected() {
        {
            boolean varB8202F37609FE37124618EAEB8892C7A_1523522522 = ((mTag.getConnectedTechnology() != mSelectedTechnology) ||
               (mTag.getConnectedTechnology() == -1));
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Call connect() first!");
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if ((mTag.getConnectedTechnology() != mSelectedTechnology) ||
               //(mTag.getConnectedTechnology() == -1)) {
           //throw new IllegalStateException("Call connect() first!");
       //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:24.883 -0400", hash_original_method = "627518FDA5BCF854C6C8A282AA02DD65", hash_generated_method = "28F8BAD09849F3D5680886CE03B205A4")
    @Override
    public boolean isConnected() {
        try 
        {
            boolean var5E5F64CA966EA9C33B4D042F7699BD61_824562467 = (mTag.getTagService().isPresent(mTag.getServiceHandle()));
        } //End block
        catch (RemoteException e)
        { }
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_478967060 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_478967060;
        // ---------- Original Method ----------
        //if (!mIsConnected) {
            //return false;
        //}
        //try {
            //return mTag.getTagService().isPresent(mTag.getServiceHandle());
        //} catch (RemoteException e) {
            //Log.e(TAG, "NFC service dead", e);
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:24.884 -0400", hash_original_method = "804D2A1436436AD53D4E3C21667A8A7D", hash_generated_method = "4545B150B44BE781213A09F8F627E373")
    @Override
    public void connect() throws IOException {
        try 
        {
            int errorCode;
            errorCode = mTag.getTagService().connect(mTag.getServiceHandle(),
                    mSelectedTechnology);
            {
                mTag.setConnectedTechnology(mSelectedTechnology);
                mIsConnected = true;
            } //End block
            {
                if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException("Connecting to " +
                        "this technology is not supported by the NFC " +
                        "adapter.");
            } //End block
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException();
            } //End block
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("NFC service died");
        } //End block
        // ---------- Original Method ----------
        //try {
            //int errorCode = mTag.getTagService().connect(mTag.getServiceHandle(),
                    //mSelectedTechnology);
            //if (errorCode == ErrorCodes.SUCCESS) {
                //mTag.setConnectedTechnology(mSelectedTechnology);
                //mIsConnected = true;
            //} else if (errorCode == ErrorCodes.ERROR_NOT_SUPPORTED) {
                //throw new UnsupportedOperationException("Connecting to " +
                        //"this technology is not supported by the NFC " +
                        //"adapter.");
            //} else {
                //throw new IOException();
            //}
        //} catch (RemoteException e) {
            //Log.e(TAG, "NFC service dead", e);
            //throw new IOException("NFC service died");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:24.902 -0400", hash_original_method = "9693ABC23B7E982FA8E766A116B1D439", hash_generated_method = "F1CCADFBDF91CEDA3973DBEB19784F79")
    @Override
    public void reconnect() throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Technology not connected yet");
        } //End block
        try 
        {
            int errorCode;
            errorCode = mTag.getTagService().reconnect(mTag.getServiceHandle());
            {
                mIsConnected = false;
                mTag.setTechnologyDisconnected();
                if (DroidSafeAndroidRuntime.control) throw new IOException();
            } //End block
        } //End block
        catch (RemoteException e)
        {
            mIsConnected = false;
            mTag.setTechnologyDisconnected();
            if (DroidSafeAndroidRuntime.control) throw new IOException("NFC service died");
        } //End block
        // ---------- Original Method ----------
        //if (!mIsConnected) {
            //throw new IllegalStateException("Technology not connected yet");
        //}
        //try {
            //int errorCode = mTag.getTagService().reconnect(mTag.getServiceHandle());
            //if (errorCode != ErrorCodes.SUCCESS) {
                //mIsConnected = false;
                //mTag.setTechnologyDisconnected();
                //throw new IOException();
            //}
        //} catch (RemoteException e) {
            //mIsConnected = false;
            //mTag.setTechnologyDisconnected();
            //Log.e(TAG, "NFC service dead", e);
            //throw new IOException("NFC service died");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:24.904 -0400", hash_original_method = "DDF274A17EF36B6492A33A14797987DB", hash_generated_method = "A9D5DBAFE8415F2DA079939520FFC47A")
    @Override
    public void close() throws IOException {
        try 
        {
            mTag.getTagService().resetTimeouts();
            mTag.getTagService().reconnect(mTag.getServiceHandle());
        } //End block
        catch (RemoteException e)
        { }
        finally 
        {
            mIsConnected = false;
            mTag.setTechnologyDisconnected();
        } //End block
        // ---------- Original Method ----------
        //try {
            //mTag.getTagService().resetTimeouts();
            //mTag.getTagService().reconnect(mTag.getServiceHandle());
        //} catch (RemoteException e) {
            //Log.e(TAG, "NFC service dead", e);
        //} finally {
            //mIsConnected = false;
            //mTag.setTechnologyDisconnected();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:24.918 -0400", hash_original_method = "34B3E57F39840A6B37FC716C1405DA5D", hash_generated_method = "EF129C7C85BA66F090D8AD7094AD869E")
     int getMaxTransceiveLengthInternal() {
        try 
        {
            int var7ACE9C893624C9A3992072F313461E38_1739985468 = (mTag.getTagService().getMaxTransceiveLength(mSelectedTechnology));
        } //End block
        catch (RemoteException e)
        { }
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1802562171 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1802562171;
        // ---------- Original Method ----------
        //try {
            //return mTag.getTagService().getMaxTransceiveLength(mSelectedTechnology);
        //} catch (RemoteException e) {
            //Log.e(TAG, "NFC service dead", e);
            //return 0;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:24.919 -0400", hash_original_method = "8FB7A232CD74B358E0C2332FDF0D5629", hash_generated_method = "A581E385DB1CA3588FD32F38BCBCE457")
     byte[] transceive(byte[] data, boolean raw) throws IOException {
        checkConnected();
        try 
        {
            TransceiveResult result;
            result = mTag.getTagService().transceive(mTag.getServiceHandle(),
                    data, raw);
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException("transceive failed");
            } //End block
            {
                byte[] var09BF1567DACC2F11C05A732312048852_1707977843 = (result.getResponseOrThrow());
            } //End block
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("NFC service died");
        } //End block
        addTaint(data[0]);
        addTaint(raw);
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_94978801 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_94978801;
        // ---------- Original Method ----------
        //checkConnected();
        //try {
            //TransceiveResult result = mTag.getTagService().transceive(mTag.getServiceHandle(),
                    //data, raw);
            //if (result == null) {
                //throw new IOException("transceive failed");
            //} else {
                //return result.getResponseOrThrow();
            //}
        //} catch (RemoteException e) {
            //Log.e(TAG, "NFC service dead", e);
            //throw new IOException("NFC service died");
        //}
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:24.919 -0400", hash_original_field = "839E89798F641D78E99C5732B39CA844", hash_generated_field = "75254E4C21911FCCBBD25490236328DA")

    private static String TAG = "NFC";
}

