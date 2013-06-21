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
    Tag mTag;
    boolean mIsConnected;
    int mSelectedTechnology;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.144 -0400", hash_original_method = "D572C74E7520ED5167A849EF718161FC", hash_generated_method = "591D3980141D96D749AC48DC6F42003C")
    @DSModeled(DSC.SAFE)
     BasicTagTechnology(Tag tag, int tech) throws RemoteException {
        dsTaint.addTaint(tag.dsTaint);
        dsTaint.addTaint(tech);
        // ---------- Original Method ----------
        //mTag = tag;
        //mSelectedTechnology = tech;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.144 -0400", hash_original_method = "FC84E29499397B8918F938A8205313A1", hash_generated_method = "A2614570779EE5A6637BA73410FE748C")
    @DSModeled(DSC.SAFE)
    @Override
    public Tag getTag() {
        return (Tag)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mTag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.144 -0400", hash_original_method = "740AD223006A949AE0C5FC9EABD0A7B2", hash_generated_method = "CB38366AA4D9CC8075445B975C15DD07")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void checkConnected() {
        {
            boolean varB8202F37609FE37124618EAEB8892C7A_963397180 = ((mTag.getConnectedTechnology() != mSelectedTechnology) ||
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.145 -0400", hash_original_method = "627518FDA5BCF854C6C8A282AA02DD65", hash_generated_method = "0937CD2901825A20CB806056F4408815")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean isConnected() {
        try 
        {
            boolean var5E5F64CA966EA9C33B4D042F7699BD61_1270601744 = (mTag.getTagService().isPresent(mTag.getServiceHandle()));
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.145 -0400", hash_original_method = "804D2A1436436AD53D4E3C21667A8A7D", hash_generated_method = "4545B150B44BE781213A09F8F627E373")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.146 -0400", hash_original_method = "9693ABC23B7E982FA8E766A116B1D439", hash_generated_method = "F1CCADFBDF91CEDA3973DBEB19784F79")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.146 -0400", hash_original_method = "DDF274A17EF36B6492A33A14797987DB", hash_generated_method = "A9D5DBAFE8415F2DA079939520FFC47A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.146 -0400", hash_original_method = "34B3E57F39840A6B37FC716C1405DA5D", hash_generated_method = "C4DF9F6D23086844A71D71A3B1CA05D3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     int getMaxTransceiveLengthInternal() {
        try 
        {
            int var7ACE9C893624C9A3992072F313461E38_1555617442 = (mTag.getTagService().getMaxTransceiveLength(mSelectedTechnology));
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //try {
            //return mTag.getTagService().getMaxTransceiveLength(mSelectedTechnology);
        //} catch (RemoteException e) {
            //Log.e(TAG, "NFC service dead", e);
            //return 0;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.147 -0400", hash_original_method = "8FB7A232CD74B358E0C2332FDF0D5629", hash_generated_method = "CDC89E5A97DF28C3E67AF96BE4E56BAC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     byte[] transceive(byte[] data, boolean raw) throws IOException {
        dsTaint.addTaint(raw);
        dsTaint.addTaint(data[0]);
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
                byte[] var09BF1567DACC2F11C05A732312048852_1440393388 = (result.getResponseOrThrow());
            } //End block
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("NFC service died");
        } //End block
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
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

    
    private static final String TAG = "NFC";
}

