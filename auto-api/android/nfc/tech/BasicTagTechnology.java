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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.300 -0400", hash_original_field = "07496860B5C53FDD66588727158D5F73", hash_generated_field = "26F2563105474DD2A79B3C79190EB5BE")

    Tag mTag;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.300 -0400", hash_original_field = "CC8BFB84898B22492B7F55096CBDF6CC", hash_generated_field = "C55D9286978463BA48249377B65E8F9B")

    boolean mIsConnected;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.300 -0400", hash_original_field = "D41A39E038C23551A3BE6A2957389ECC", hash_generated_field = "14A56D04133B1EA444C84A98B6F4BAF8")

    int mSelectedTechnology;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.301 -0400", hash_original_method = "D572C74E7520ED5167A849EF718161FC", hash_generated_method = "64090CC7213E0BD4071575620BFB8345")
      BasicTagTechnology(Tag tag, int tech) throws RemoteException {
        mTag = tag;
        mSelectedTechnology = tech;
        // ---------- Original Method ----------
        //mTag = tag;
        //mSelectedTechnology = tech;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.301 -0400", hash_original_method = "FC84E29499397B8918F938A8205313A1", hash_generated_method = "C2B7727FCC725632E78B7DC226AA0721")
    @Override
    public Tag getTag() {
        Tag varB4EAC82CA7396A68D541C85D26508E83_76953379 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_76953379 = mTag;
        varB4EAC82CA7396A68D541C85D26508E83_76953379.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_76953379;
        // ---------- Original Method ----------
        //return mTag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.302 -0400", hash_original_method = "740AD223006A949AE0C5FC9EABD0A7B2", hash_generated_method = "B30747FB295A3A6FCAF5BDB10AF31C8A")
     void checkConnected() {
        {
            boolean varB8202F37609FE37124618EAEB8892C7A_1382529902 = ((mTag.getConnectedTechnology() != mSelectedTechnology) ||
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.302 -0400", hash_original_method = "627518FDA5BCF854C6C8A282AA02DD65", hash_generated_method = "3B1A33E3596A96BF82A3E74C57BE569D")
    @Override
    public boolean isConnected() {
        try 
        {
            boolean var5E5F64CA966EA9C33B4D042F7699BD61_651055864 = (mTag.getTagService().isPresent(mTag.getServiceHandle()));
        } //End block
        catch (RemoteException e)
        { }
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_862891726 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_862891726;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.303 -0400", hash_original_method = "804D2A1436436AD53D4E3C21667A8A7D", hash_generated_method = "30E0AE32D154059E63071C8C7F2D12C0")
    @Override
    public void connect() throws IOException {
        try 
        {
            int errorCode = mTag.getTagService().connect(mTag.getServiceHandle(),
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.303 -0400", hash_original_method = "9693ABC23B7E982FA8E766A116B1D439", hash_generated_method = "D4D09E730F9B69D5D2C99EECD2F7C47F")
    @Override
    public void reconnect() throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Technology not connected yet");
        } //End block
        try 
        {
            int errorCode = mTag.getTagService().reconnect(mTag.getServiceHandle());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.304 -0400", hash_original_method = "DDF274A17EF36B6492A33A14797987DB", hash_generated_method = "A9D5DBAFE8415F2DA079939520FFC47A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.305 -0400", hash_original_method = "34B3E57F39840A6B37FC716C1405DA5D", hash_generated_method = "8CD11D3CBC44B046D2F062BCA121A13A")
     int getMaxTransceiveLengthInternal() {
        try 
        {
            int var7ACE9C893624C9A3992072F313461E38_1345617301 = (mTag.getTagService().getMaxTransceiveLength(mSelectedTechnology));
        } //End block
        catch (RemoteException e)
        { }
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1598358200 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1598358200;
        // ---------- Original Method ----------
        //try {
            //return mTag.getTagService().getMaxTransceiveLength(mSelectedTechnology);
        //} catch (RemoteException e) {
            //Log.e(TAG, "NFC service dead", e);
            //return 0;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.305 -0400", hash_original_method = "8FB7A232CD74B358E0C2332FDF0D5629", hash_generated_method = "4E31105F4C4D13391B04158FF996E206")
     byte[] transceive(byte[] data, boolean raw) throws IOException {
        checkConnected();
        try 
        {
            TransceiveResult result = mTag.getTagService().transceive(mTag.getServiceHandle(),
                    data, raw);
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException("transceive failed");
            } //End block
            {
                byte[] var09BF1567DACC2F11C05A732312048852_56165192 = (result.getResponseOrThrow());
            } //End block
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("NFC service died");
        } //End block
        addTaint(data[0]);
        addTaint(raw);
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1101951245 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1101951245;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.305 -0400", hash_original_field = "839E89798F641D78E99C5732B39CA844", hash_generated_field = "BC8F11E4AEAD11E0412B7B53DF0CA6C8")

    private static final String TAG = "NFC";
}

