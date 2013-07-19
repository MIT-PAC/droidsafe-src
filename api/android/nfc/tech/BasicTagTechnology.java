package android.nfc.tech;

// Droidsafe Imports
import java.io.IOException;

import android.nfc.ErrorCodes;
import android.nfc.Tag;
import android.nfc.TransceiveResult;
import android.os.RemoteException;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

abstract class BasicTagTechnology implements TagTechnology {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.463 -0400", hash_original_field = "07496860B5C53FDD66588727158D5F73", hash_generated_field = "26F2563105474DD2A79B3C79190EB5BE")

    Tag mTag;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.463 -0400", hash_original_field = "CC8BFB84898B22492B7F55096CBDF6CC", hash_generated_field = "C55D9286978463BA48249377B65E8F9B")

    boolean mIsConnected;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.463 -0400", hash_original_field = "D41A39E038C23551A3BE6A2957389ECC", hash_generated_field = "14A56D04133B1EA444C84A98B6F4BAF8")

    int mSelectedTechnology;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.464 -0400", hash_original_method = "D572C74E7520ED5167A849EF718161FC", hash_generated_method = "64090CC7213E0BD4071575620BFB8345")
      BasicTagTechnology(Tag tag, int tech) throws RemoteException {
        mTag = tag;
        mSelectedTechnology = tech;
        // ---------- Original Method ----------
        //mTag = tag;
        //mSelectedTechnology = tech;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.464 -0400", hash_original_method = "FC84E29499397B8918F938A8205313A1", hash_generated_method = "E8A444ED584B1503EB8068F73143D5CA")
    @Override
    public Tag getTag() {
Tag varD6A25044F8E609F6CD67330C1523D33D_1850809499 =         mTag;
        varD6A25044F8E609F6CD67330C1523D33D_1850809499.addTaint(taint);
        return varD6A25044F8E609F6CD67330C1523D33D_1850809499;
        // ---------- Original Method ----------
        //return mTag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.465 -0400", hash_original_method = "740AD223006A949AE0C5FC9EABD0A7B2", hash_generated_method = "8E4ABC21927DDAD62B95ED196D0BD377")
     void checkConnected() {
        if((mTag.getConnectedTechnology() != mSelectedTechnology) ||
               (mTag.getConnectedTechnology() == -1))        
        {
            IllegalStateException varCC4A2A8C5B5DEE13D67301868F9A3F66_1022296650 = new IllegalStateException("Call connect() first!");
            varCC4A2A8C5B5DEE13D67301868F9A3F66_1022296650.addTaint(taint);
            throw varCC4A2A8C5B5DEE13D67301868F9A3F66_1022296650;
        } //End block
        // ---------- Original Method ----------
        //if ((mTag.getConnectedTechnology() != mSelectedTechnology) ||
               //(mTag.getConnectedTechnology() == -1)) {
           //throw new IllegalStateException("Call connect() first!");
       //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.466 -0400", hash_original_method = "627518FDA5BCF854C6C8A282AA02DD65", hash_generated_method = "5C045D700B9E9B5CF5E707A729F2D3F7")
    @Override
    public boolean isConnected() {
        if(!mIsConnected)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1058045725 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_607544502 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_607544502;
        } //End block
        try 
        {
            boolean varAD67439FE68EDDCA245E2F5D853FF1EA_1421570922 = (mTag.getTagService().isPresent(mTag.getServiceHandle()));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1649457668 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1649457668;
        } //End block
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_151921715 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1411342898 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1411342898;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.468 -0400", hash_original_method = "804D2A1436436AD53D4E3C21667A8A7D", hash_generated_method = "9FA75003970543B9CA5BA2095BDC70BF")
    @Override
    public void connect() throws IOException {
        try 
        {
            int errorCode = mTag.getTagService().connect(mTag.getServiceHandle(),
                    mSelectedTechnology);
            if(errorCode == ErrorCodes.SUCCESS)            
            {
                mTag.setConnectedTechnology(mSelectedTechnology);
                mIsConnected = true;
            } //End block
            else
            if(errorCode == ErrorCodes.ERROR_NOT_SUPPORTED)            
            {
                UnsupportedOperationException var68716AEEE9208F9EF19D3952CED259D0_1092224873 = new UnsupportedOperationException("Connecting to " +
                        "this technology is not supported by the NFC " +
                        "adapter.");
                var68716AEEE9208F9EF19D3952CED259D0_1092224873.addTaint(taint);
                throw var68716AEEE9208F9EF19D3952CED259D0_1092224873;
            } //End block
            else
            {
                IOException var1508E3FDF27FD56D4E1051DB16DE1816_1875357745 = new IOException();
                var1508E3FDF27FD56D4E1051DB16DE1816_1875357745.addTaint(taint);
                throw var1508E3FDF27FD56D4E1051DB16DE1816_1875357745;
            } //End block
        } //End block
        catch (RemoteException e)
        {
            IOException var5594722CB99B3B94B75B86C297B3CD6D_1598920726 = new IOException("NFC service died");
            var5594722CB99B3B94B75B86C297B3CD6D_1598920726.addTaint(taint);
            throw var5594722CB99B3B94B75B86C297B3CD6D_1598920726;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.470 -0400", hash_original_method = "9693ABC23B7E982FA8E766A116B1D439", hash_generated_method = "973C59CE0231AA2E0AB644FA557E6BB6")
    @Override
    public void reconnect() throws IOException {
        if(!mIsConnected)        
        {
            IllegalStateException var295CA0FCAFBEAB3073E5866A5FA0A1A9_1886392108 = new IllegalStateException("Technology not connected yet");
            var295CA0FCAFBEAB3073E5866A5FA0A1A9_1886392108.addTaint(taint);
            throw var295CA0FCAFBEAB3073E5866A5FA0A1A9_1886392108;
        } //End block
        try 
        {
            int errorCode = mTag.getTagService().reconnect(mTag.getServiceHandle());
            if(errorCode != ErrorCodes.SUCCESS)            
            {
                mIsConnected = false;
                mTag.setTechnologyDisconnected();
                IOException var1508E3FDF27FD56D4E1051DB16DE1816_777481889 = new IOException();
                var1508E3FDF27FD56D4E1051DB16DE1816_777481889.addTaint(taint);
                throw var1508E3FDF27FD56D4E1051DB16DE1816_777481889;
            } //End block
        } //End block
        catch (RemoteException e)
        {
            mIsConnected = false;
            mTag.setTechnologyDisconnected();
            IOException var5594722CB99B3B94B75B86C297B3CD6D_1010186065 = new IOException("NFC service died");
            var5594722CB99B3B94B75B86C297B3CD6D_1010186065.addTaint(taint);
            throw var5594722CB99B3B94B75B86C297B3CD6D_1010186065;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.471 -0400", hash_original_method = "DDF274A17EF36B6492A33A14797987DB", hash_generated_method = "F32D9AD00A44E0838086282D7AEEE7CA")
    @Override
    public void close() throws IOException {
        try 
        {
            mTag.getTagService().resetTimeouts();
            mTag.getTagService().reconnect(mTag.getServiceHandle());
        } //End block
        catch (RemoteException e)
        {
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.472 -0400", hash_original_method = "34B3E57F39840A6B37FC716C1405DA5D", hash_generated_method = "6BBB230FD46EDDC37A6F9910A62BC030")
     int getMaxTransceiveLengthInternal() {
        try 
        {
            int var34063F0E4B3EC9014B2C677CC42817C0_1597482260 = (mTag.getTagService().getMaxTransceiveLength(mSelectedTechnology));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1862440180 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1862440180;
        } //End block
        catch (RemoteException e)
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_1857178791 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1821300240 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1821300240;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mTag.getTagService().getMaxTransceiveLength(mSelectedTechnology);
        //} catch (RemoteException e) {
            //Log.e(TAG, "NFC service dead", e);
            //return 0;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.473 -0400", hash_original_method = "8FB7A232CD74B358E0C2332FDF0D5629", hash_generated_method = "3F9D3A27AF1F83F4D5D90B0653C1179B")
     byte[] transceive(byte[] data, boolean raw) throws IOException {
        addTaint(raw);
        addTaint(data[0]);
        checkConnected();
        try 
        {
            TransceiveResult result = mTag.getTagService().transceive(mTag.getServiceHandle(),
                    data, raw);
            if(result == null)            
            {
                IOException var79274916E19B1BF20ACD942A90B4076A_1870499894 = new IOException("transceive failed");
                var79274916E19B1BF20ACD942A90B4076A_1870499894.addTaint(taint);
                throw var79274916E19B1BF20ACD942A90B4076A_1870499894;
            } //End block
            else
            {
                byte[] var038A045660D91EF12CC4760617F13625_1839868811 = (result.getResponseOrThrow());
                                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_2114974161 = {getTaintByte()};
                return var2F9C81BC6E497382285CD6B7A7E33DE1_2114974161;
            } //End block
        } //End block
        catch (RemoteException e)
        {
            IOException var5594722CB99B3B94B75B86C297B3CD6D_275438594 = new IOException("NFC service died");
            var5594722CB99B3B94B75B86C297B3CD6D_275438594.addTaint(taint);
            throw var5594722CB99B3B94B75B86C297B3CD6D_275438594;
        } //End block
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.474 -0400", hash_original_field = "839E89798F641D78E99C5732B39CA844", hash_generated_field = "BC8F11E4AEAD11E0412B7B53DF0CA6C8")

    private static final String TAG = "NFC";
}

