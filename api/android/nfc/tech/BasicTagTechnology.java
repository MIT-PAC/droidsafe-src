package android.nfc.tech;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.nfc.ErrorCodes;
import android.nfc.Tag;
import android.nfc.TagLostException;
import android.nfc.TransceiveResult;
import android.os.RemoteException;
import android.util.Log;
import java.io.IOException;

abstract class BasicTagTechnology implements TagTechnology {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.816 -0400", hash_original_field = "07496860B5C53FDD66588727158D5F73", hash_generated_field = "26F2563105474DD2A79B3C79190EB5BE")

    Tag mTag;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.816 -0400", hash_original_field = "CC8BFB84898B22492B7F55096CBDF6CC", hash_generated_field = "C55D9286978463BA48249377B65E8F9B")

    boolean mIsConnected;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.817 -0400", hash_original_field = "D41A39E038C23551A3BE6A2957389ECC", hash_generated_field = "14A56D04133B1EA444C84A98B6F4BAF8")

    int mSelectedTechnology;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.817 -0400", hash_original_method = "D572C74E7520ED5167A849EF718161FC", hash_generated_method = "64090CC7213E0BD4071575620BFB8345")
      BasicTagTechnology(Tag tag, int tech) throws RemoteException {
        mTag = tag;
        mSelectedTechnology = tech;
        // ---------- Original Method ----------
        //mTag = tag;
        //mSelectedTechnology = tech;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.818 -0400", hash_original_method = "FC84E29499397B8918F938A8205313A1", hash_generated_method = "A88B29D080902B16D1C0A4D725811A1E")
    @Override
    public Tag getTag() {
Tag varD6A25044F8E609F6CD67330C1523D33D_650001313 =         mTag;
        varD6A25044F8E609F6CD67330C1523D33D_650001313.addTaint(taint);
        return varD6A25044F8E609F6CD67330C1523D33D_650001313;
        // ---------- Original Method ----------
        //return mTag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.818 -0400", hash_original_method = "740AD223006A949AE0C5FC9EABD0A7B2", hash_generated_method = "5585DDC4A4A323DF13EB3E1C147E804A")
     void checkConnected() {
    if((mTag.getConnectedTechnology() != mSelectedTechnology) ||
               (mTag.getConnectedTechnology() == -1))        
        {
            IllegalStateException varCC4A2A8C5B5DEE13D67301868F9A3F66_1811390038 = new IllegalStateException("Call connect() first!");
            varCC4A2A8C5B5DEE13D67301868F9A3F66_1811390038.addTaint(taint);
            throw varCC4A2A8C5B5DEE13D67301868F9A3F66_1811390038;
        } //End block
        // ---------- Original Method ----------
        //if ((mTag.getConnectedTechnology() != mSelectedTechnology) ||
               //(mTag.getConnectedTechnology() == -1)) {
           //throw new IllegalStateException("Call connect() first!");
       //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.818 -0400", hash_original_method = "627518FDA5BCF854C6C8A282AA02DD65", hash_generated_method = "0C8A3E41FB6B2B227BC2A09C4EC84477")
    @Override
    public boolean isConnected() {
    if(!mIsConnected)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1916695903 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1738598787 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1738598787;
        } //End block
        try 
        {
            boolean varAD67439FE68EDDCA245E2F5D853FF1EA_509187047 = (mTag.getTagService().isPresent(mTag.getServiceHandle()));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1678950501 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1678950501;
        } //End block
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_2111376100 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_814765625 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_814765625;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.819 -0400", hash_original_method = "804D2A1436436AD53D4E3C21667A8A7D", hash_generated_method = "3E563337C2AB8CA0F33B94B523D66B39")
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
                UnsupportedOperationException var68716AEEE9208F9EF19D3952CED259D0_1305597070 = new UnsupportedOperationException("Connecting to " +
                        "this technology is not supported by the NFC " +
                        "adapter.");
                var68716AEEE9208F9EF19D3952CED259D0_1305597070.addTaint(taint);
                throw var68716AEEE9208F9EF19D3952CED259D0_1305597070;
            } //End block
            else
            {
                IOException var1508E3FDF27FD56D4E1051DB16DE1816_573826005 = new IOException();
                var1508E3FDF27FD56D4E1051DB16DE1816_573826005.addTaint(taint);
                throw var1508E3FDF27FD56D4E1051DB16DE1816_573826005;
            } //End block
        } //End block
        catch (RemoteException e)
        {
            IOException var5594722CB99B3B94B75B86C297B3CD6D_149028625 = new IOException("NFC service died");
            var5594722CB99B3B94B75B86C297B3CD6D_149028625.addTaint(taint);
            throw var5594722CB99B3B94B75B86C297B3CD6D_149028625;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.820 -0400", hash_original_method = "9693ABC23B7E982FA8E766A116B1D439", hash_generated_method = "283EC2A5569830476C63E08E9A6E714F")
    @Override
    public void reconnect() throws IOException {
    if(!mIsConnected)        
        {
            IllegalStateException var295CA0FCAFBEAB3073E5866A5FA0A1A9_845188922 = new IllegalStateException("Technology not connected yet");
            var295CA0FCAFBEAB3073E5866A5FA0A1A9_845188922.addTaint(taint);
            throw var295CA0FCAFBEAB3073E5866A5FA0A1A9_845188922;
        } //End block
        try 
        {
            int errorCode = mTag.getTagService().reconnect(mTag.getServiceHandle());
    if(errorCode != ErrorCodes.SUCCESS)            
            {
                mIsConnected = false;
                mTag.setTechnologyDisconnected();
                IOException var1508E3FDF27FD56D4E1051DB16DE1816_1003163137 = new IOException();
                var1508E3FDF27FD56D4E1051DB16DE1816_1003163137.addTaint(taint);
                throw var1508E3FDF27FD56D4E1051DB16DE1816_1003163137;
            } //End block
        } //End block
        catch (RemoteException e)
        {
            mIsConnected = false;
            mTag.setTechnologyDisconnected();
            IOException var5594722CB99B3B94B75B86C297B3CD6D_1306143610 = new IOException("NFC service died");
            var5594722CB99B3B94B75B86C297B3CD6D_1306143610.addTaint(taint);
            throw var5594722CB99B3B94B75B86C297B3CD6D_1306143610;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.820 -0400", hash_original_method = "DDF274A17EF36B6492A33A14797987DB", hash_generated_method = "F32D9AD00A44E0838086282D7AEEE7CA")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.821 -0400", hash_original_method = "34B3E57F39840A6B37FC716C1405DA5D", hash_generated_method = "75E5CB8E1F9B9CE63D271E03845527BC")
     int getMaxTransceiveLengthInternal() {
        try 
        {
            int var34063F0E4B3EC9014B2C677CC42817C0_2044858711 = (mTag.getTagService().getMaxTransceiveLength(mSelectedTechnology));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_891212597 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_891212597;
        } //End block
        catch (RemoteException e)
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_844257527 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1348616570 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1348616570;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return mTag.getTagService().getMaxTransceiveLength(mSelectedTechnology);
        //} catch (RemoteException e) {
            //Log.e(TAG, "NFC service dead", e);
            //return 0;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.821 -0400", hash_original_method = "8FB7A232CD74B358E0C2332FDF0D5629", hash_generated_method = "F58B45B98BB9B5A4DC77EACA7EEEB437")
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
                IOException var79274916E19B1BF20ACD942A90B4076A_1179337716 = new IOException("transceive failed");
                var79274916E19B1BF20ACD942A90B4076A_1179337716.addTaint(taint);
                throw var79274916E19B1BF20ACD942A90B4076A_1179337716;
            } //End block
            else
            {
                byte[] var038A045660D91EF12CC4760617F13625_2136531542 = (result.getResponseOrThrow());
                                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_515270294 = {getTaintByte()};
                return var2F9C81BC6E497382285CD6B7A7E33DE1_515270294;
            } //End block
        } //End block
        catch (RemoteException e)
        {
            IOException var5594722CB99B3B94B75B86C297B3CD6D_940353800 = new IOException("NFC service died");
            var5594722CB99B3B94B75B86C297B3CD6D_940353800.addTaint(taint);
            throw var5594722CB99B3B94B75B86C297B3CD6D_940353800;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:29.822 -0400", hash_original_field = "839E89798F641D78E99C5732B39CA844", hash_generated_field = "BC8F11E4AEAD11E0412B7B53DF0CA6C8")

    private static final String TAG = "NFC";
}

