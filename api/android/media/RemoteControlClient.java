package android.media;

// Droidsafe Imports
import droidsafe.annotations.*;
import android.app.PendingIntent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.os.SystemClock;





public class RemoteControlClient {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.978 -0400", hash_original_field = "825986C2B615FC9AC12680D3918F4AD8", hash_generated_field = "84304313B5BE2FAF3B60D13295A73C77")

    private final Object mCacheLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.978 -0400", hash_original_field = "850AD863440EDBB3324AE9D9090A9703", hash_generated_field = "4614F38337BAA651A52883AEA4B73289")

    private int mPlaybackState = PLAYSTATE_NONE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.978 -0400", hash_original_field = "63CA3372A2CBF1D691233FC176AF9A18", hash_generated_field = "1BEC69AD7A22658EBADD97D1E5E40CB0")

    private long mPlaybackStateChangeTimeMs = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.978 -0400", hash_original_field = "DCBF361CC1FA69AA2900045AD87670CA", hash_generated_field = "BC9C836A2A56878C42A006AD06D23308")

    private Bitmap mArtwork;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.978 -0400", hash_original_field = "DE3E71209A981C0CA4B18A67AD82B790", hash_generated_field = "24B92185327A5356B945DB6DA2A8A474")

    private final int ARTWORK_DEFAULT_SIZE = 256;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.978 -0400", hash_original_field = "5694730B9BE1FD5AA2E9274D3B70E646", hash_generated_field = "897D986065A139967AB4500786131D84")

    private final int ARTWORK_INVALID_SIZE = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.978 -0400", hash_original_field = "C45F63EF9C108145812FB1902A540D7A", hash_generated_field = "8965B25D9EB40BED14D87C783E89F3C5")

    private int mArtworkExpectedWidth = ARTWORK_DEFAULT_SIZE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.979 -0400", hash_original_field = "3B5CE9F4A4FFE223E4B26B0BCF27BAE6", hash_generated_field = "9A05CBDEF29D4A853B9AD874C4D29310")

    private int mArtworkExpectedHeight = ARTWORK_DEFAULT_SIZE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.979 -0400", hash_original_field = "F1EE76BCC944FDF96490A84EDE945FDD", hash_generated_field = "D886D0C4ACF243C5481BBD5AAC40B711")

    private int mTransportControlFlags = FLAGS_KEY_MEDIA_NONE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.979 -0400", hash_original_field = "0B73F4AC2A2DED1FA15B8A8376540BBD", hash_generated_field = "DA6670A1846875744AFAE7AA4DEC9FDF")

    private Bundle mMetadata = new Bundle();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.979 -0400", hash_original_field = "E5A4111167B61E938770B3077096A9AA", hash_generated_field = "9EB4244C60785911067FC7413E2DE31B")

    private int mCurrentClientGenId = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.979 -0400", hash_original_field = "6025A94A465596EFB7A4D9C270923372", hash_generated_field = "14D22A774763FE83A163754E1995815C")

    private int mInternalClientGenId = -2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.979 -0400", hash_original_field = "7156A56E00345AEDBE84A1DBB20B37D1", hash_generated_field = "0D33962CDFCC7D569FC4E814D31B5DFB")

    private PendingIntent mRcMediaIntent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.979 -0400", hash_original_field = "C3821363E374B4C1C9B40F69FE478F3C", hash_generated_field = "6F5BD225EE2017EE2B9E17B1141913F9")

    private IRemoteControlDisplay mRcDisplay;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.461 -0400", hash_original_field = "F4A07242D823C860C73942573E9A702C", hash_generated_field = "0B2C69CE4D7E8D199D2B2E2678BA8AC0")

    private IRemoteControlClient mIRCC = new IRemoteControlClient.Stub() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.460 -0400", hash_original_method = "F932B544DD1B5B88DDD0055B7C1D8F98", hash_generated_method = "8642A93D514E756D20B21B6324049341")
        public void onInformationRequested(int clientGeneration, int infoFlags,
                int artWidth, int artHeight) {
            
            {
                mEventHandler.removeMessages(MSG_NEW_INTERNAL_CLIENT_GEN);
                mEventHandler.dispatchMessage(
                        mEventHandler.obtainMessage(
                                MSG_NEW_INTERNAL_CLIENT_GEN,
                                artWidth, artHeight,
                                new Integer(clientGeneration)));
                mEventHandler.removeMessages(MSG_REQUEST_PLAYBACK_STATE);
                mEventHandler.removeMessages(MSG_REQUEST_METADATA);
                mEventHandler.removeMessages(MSG_REQUEST_TRANSPORTCONTROL);
                mEventHandler.removeMessages(MSG_REQUEST_ARTWORK);
                mEventHandler.dispatchMessage(
                        mEventHandler.obtainMessage(MSG_REQUEST_PLAYBACK_STATE));
                mEventHandler.dispatchMessage(
                        mEventHandler.obtainMessage(MSG_REQUEST_TRANSPORTCONTROL));
                mEventHandler.dispatchMessage(mEventHandler.obtainMessage(MSG_REQUEST_METADATA));
                mEventHandler.dispatchMessage(mEventHandler.obtainMessage(MSG_REQUEST_ARTWORK));
            } 
            addTaint(clientGeneration);
            addTaint(infoFlags);
            addTaint(artWidth);
            addTaint(artHeight);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.460 -0400", hash_original_method = "A6F81BEED91E1311AA2FA5D9223AC5BE", hash_generated_method = "E5B81C889298B648C8569F4E46541402")
        public void setCurrentClientGenerationId(int clientGeneration) {
            {
                mEventHandler.removeMessages(MSG_NEW_CURRENT_CLIENT_GEN);
                mEventHandler.dispatchMessage(mEventHandler.obtainMessage(
                        MSG_NEW_CURRENT_CLIENT_GEN, clientGeneration, 0));
            } 
            addTaint(clientGeneration);
            
            
                
                
                        
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.461 -0400", hash_original_method = "858E8A6EB1AEED0E033B6B24928ADF7F", hash_generated_method = "9B0B6DA7FE58DDEC0A074C40B80AD176")
        public void plugRemoteControlDisplay(IRemoteControlDisplay rcd) {
            {
                mEventHandler.dispatchMessage(mEventHandler.obtainMessage(
                        MSG_PLUG_DISPLAY, rcd));
            } 
            addTaint(rcd.getTaint());
            
            
                
                        
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.461 -0400", hash_original_method = "E2F436516A1B085C4A3368B079EC9835", hash_generated_method = "302035D7C66A014A0FC1946F6AD67D32")
        public void unplugRemoteControlDisplay(IRemoteControlDisplay rcd) {
            {
                mEventHandler.dispatchMessage(mEventHandler.obtainMessage(
                        MSG_UNPLUG_DISPLAY, rcd));
            } 
            addTaint(rcd.getTaint());
            
            
                
                        
            
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.979 -0400", hash_original_field = "3487E63080D45B4AAFB4C377AC2DEA9F", hash_generated_field = "04D6DC37F0EF901EF71A528809491D49")

    private EventHandler mEventHandler;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.980 -0400", hash_original_method = "AD6CCD9D9B436D492F90BC57466F8BB6", hash_generated_method = "DA556633AF4E14DCC67A471502C63FC6")
    public  RemoteControlClient(PendingIntent mediaButtonIntent) {
        mRcMediaIntent = mediaButtonIntent;
        Looper looper;
        if((looper = Looper.myLooper()) != null)        
        {
            mEventHandler = new EventHandler(this, looper);
        } //End block
        else
        if((looper = Looper.getMainLooper()) != null)        
        {
            mEventHandler = new EventHandler(this, looper);
        } //End block
        else
        {
            mEventHandler = null;
        } //End block
        // ---------- Original Method ----------
        //mRcMediaIntent = mediaButtonIntent;
        //Looper looper;
        //if ((looper = Looper.myLooper()) != null) {
            //mEventHandler = new EventHandler(this, looper);
        //} else if ((looper = Looper.getMainLooper()) != null) {
            //mEventHandler = new EventHandler(this, looper);
        //} else {
            //mEventHandler = null;
            //Log.e(TAG, "RemoteControlClient() couldn't find main application thread");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.981 -0400", hash_original_method = "BBCB02942EAA4463B06F3A8D8D85915D", hash_generated_method = "2CD17C2EF419C0ACBD020B84E8A50296")
    public  RemoteControlClient(PendingIntent mediaButtonIntent, Looper looper) {
        mRcMediaIntent = mediaButtonIntent;
        mEventHandler = new EventHandler(this, looper);
        // ---------- Original Method ----------
        //mRcMediaIntent = mediaButtonIntent;
        //mEventHandler = new EventHandler(this, looper);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.983 -0400", hash_original_method = "848F28E79710FB7B251A1B961691D3AF", hash_generated_method = "1731AAA573187B62779B75AB6BA6F5E6")
    public MetadataEditor editMetadata(boolean startEmpty) {
        addTaint(startEmpty);
        MetadataEditor editor = new MetadataEditor();
        if(startEmpty)        
        {
            editor.mEditorMetadata = new Bundle();
            editor.mEditorArtwork = null;
            editor.mMetadataChanged = true;
            editor.mArtworkChanged = true;
        } //End block
        else
        {
            editor.mEditorMetadata = new Bundle(mMetadata);
            editor.mEditorArtwork = mArtwork;
            editor.mMetadataChanged = false;
            editor.mArtworkChanged = false;
        } //End block
MetadataEditor varED224B1BF4EAE660E8B6808A4D079108_1085237358 =         editor;
        varED224B1BF4EAE660E8B6808A4D079108_1085237358.addTaint(taint);
        return varED224B1BF4EAE660E8B6808A4D079108_1085237358;
        // ---------- Original Method ----------
        //MetadataEditor editor = new MetadataEditor();
        //if (startEmpty) {
            //editor.mEditorMetadata = new Bundle();
            //editor.mEditorArtwork = null;
            //editor.mMetadataChanged = true;
            //editor.mArtworkChanged = true;
        //} else {
            //editor.mEditorMetadata = new Bundle(mMetadata);
            //editor.mEditorArtwork = mArtwork;
            //editor.mMetadataChanged = false;
            //editor.mArtworkChanged = false;
        //}
        //return editor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.985 -0400", hash_original_method = "1B4A5A7A2B9348E61A1F8DBEDB05B350", hash_generated_method = "7D2E9646F7E7776C6B0CCEAFEFB1EB27")
    public void setPlaybackState(int state) {
        synchronized
(mCacheLock)        {
            if(mPlaybackState != state)            
            {
                mPlaybackState = state;
                mPlaybackStateChangeTimeMs = SystemClock.elapsedRealtime();
                sendPlaybackState_syncCacheLock();
            } //End block
        } //End block
        // ---------- Original Method ----------
        //synchronized(mCacheLock) {
            //if (mPlaybackState != state) {
                //mPlaybackState = state;
                //mPlaybackStateChangeTimeMs = SystemClock.elapsedRealtime();
                //sendPlaybackState_syncCacheLock();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.986 -0400", hash_original_method = "940D4AD017270A6AD7F6D36A1ADC2473", hash_generated_method = "289FB704B71F712285572BE157CB228D")
    public void setTransportControlFlags(int transportControlFlags) {
        synchronized
(mCacheLock)        {
            mTransportControlFlags = transportControlFlags;
            sendTransportControlFlags_syncCacheLock();
        } //End block
        // ---------- Original Method ----------
        //synchronized(mCacheLock) {
            //mTransportControlFlags = transportControlFlags;
            //sendTransportControlFlags_syncCacheLock();
        //}
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.986 -0400", hash_original_method = "2C35ADA55DC65E9D8CCC19BDAA7D2B4B", hash_generated_method = "A1388D27E357F50A8533F9463DA256AA")
    public PendingIntent getRcMediaIntent() {
PendingIntent var1596228B9A06056CB18AE26D216C4D1A_623396981 =         mRcMediaIntent;
        var1596228B9A06056CB18AE26D216C4D1A_623396981.addTaint(taint);
        return var1596228B9A06056CB18AE26D216C4D1A_623396981;
        // ---------- Original Method ----------
        //return mRcMediaIntent;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.987 -0400", hash_original_method = "6031DEC176ACCB06C28473E7885E0907", hash_generated_method = "B2C77D1A5390E25C5FB20DBC5702DEF5")
    public IRemoteControlClient getIRemoteControlClient() {
IRemoteControlClient var09998700C9FD281176CA7E01A7D049EB_1441011026 =         mIRCC;
        var09998700C9FD281176CA7E01A7D049EB_1441011026.addTaint(taint);
        return var09998700C9FD281176CA7E01A7D049EB_1441011026;
        // ---------- Original Method ----------
        //return mIRCC;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.988 -0400", hash_original_method = "1D4279FF389DE00E45CE62733E438945", hash_generated_method = "7BE69845830A5C30F8E86A0E732E3185")
    private void detachFromDisplay_syncCacheLock() {
        mRcDisplay = null;
        mArtworkExpectedWidth = ARTWORK_INVALID_SIZE;
        mArtworkExpectedHeight = ARTWORK_INVALID_SIZE;
        // ---------- Original Method ----------
        //mRcDisplay = null;
        //mArtworkExpectedWidth = ARTWORK_INVALID_SIZE;
        //mArtworkExpectedHeight = ARTWORK_INVALID_SIZE;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.989 -0400", hash_original_method = "DCEF21D9331BDE9855981A4FAF951191", hash_generated_method = "3FB7A2E1A77F70FA4A7D2BED83BCB705")
    private void sendPlaybackState_syncCacheLock() {
        if((mCurrentClientGenId == mInternalClientGenId) && (mRcDisplay != null))        
        {
            try 
            {
                mRcDisplay.setPlaybackState(mInternalClientGenId, mPlaybackState,
                        mPlaybackStateChangeTimeMs);
            } //End block
            catch (RemoteException e)
            {
                detachFromDisplay_syncCacheLock();
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if ((mCurrentClientGenId == mInternalClientGenId) && (mRcDisplay != null)) {
            //try {
                //mRcDisplay.setPlaybackState(mInternalClientGenId, mPlaybackState,
                        //mPlaybackStateChangeTimeMs);
            //} catch (RemoteException e) {
                //Log.e(TAG, "Error in setPlaybackState(), dead display "+e);
                //detachFromDisplay_syncCacheLock();
            //}
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.989 -0400", hash_original_method = "414E902B5C775D55BC88776E02F34242", hash_generated_method = "9FDD58057F2688A3BEBEBEE2190BFA3E")
    private void sendMetadata_syncCacheLock() {
        if((mCurrentClientGenId == mInternalClientGenId) && (mRcDisplay != null))        
        {
            try 
            {
                mRcDisplay.setMetadata(mInternalClientGenId, mMetadata);
            } //End block
            catch (RemoteException e)
            {
                detachFromDisplay_syncCacheLock();
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if ((mCurrentClientGenId == mInternalClientGenId) && (mRcDisplay != null)) {
            //try {
                //mRcDisplay.setMetadata(mInternalClientGenId, mMetadata);
            //} catch (RemoteException e) {
                //Log.e(TAG, "Error in sendPlaybackState(), dead display "+e);
                //detachFromDisplay_syncCacheLock();
            //}
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.990 -0400", hash_original_method = "AE3ACB485EA21BE41AFE152A08682540", hash_generated_method = "7D91231B66CF314FAC8EE71F0ED7466E")
    private void sendTransportControlFlags_syncCacheLock() {
        if((mCurrentClientGenId == mInternalClientGenId) && (mRcDisplay != null))        
        {
            try 
            {
                mRcDisplay.setTransportControlFlags(mInternalClientGenId,
                        mTransportControlFlags);
            } //End block
            catch (RemoteException e)
            {
                detachFromDisplay_syncCacheLock();
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if ((mCurrentClientGenId == mInternalClientGenId) && (mRcDisplay != null)) {
            //try {
                //mRcDisplay.setTransportControlFlags(mInternalClientGenId,
                        //mTransportControlFlags);
            //} catch (RemoteException e) {
                //Log.e(TAG, "Error in sendTransportControlFlags(), dead display "+e);
                //detachFromDisplay_syncCacheLock();
            //}
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.991 -0400", hash_original_method = "1072470EEE2F2109E34F0B1C5EF1161C", hash_generated_method = "E4BB987BFA089E58BE17F4E739A1E2CE")
    private void sendArtwork_syncCacheLock() {
        if((mCurrentClientGenId == mInternalClientGenId) && (mRcDisplay != null))        
        {
            mArtwork = scaleBitmapIfTooBig(mArtwork, mArtworkExpectedWidth, mArtworkExpectedHeight);
            try 
            {
                mRcDisplay.setArtwork(mInternalClientGenId, mArtwork);
            } //End block
            catch (RemoteException e)
            {
                detachFromDisplay_syncCacheLock();
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if ((mCurrentClientGenId == mInternalClientGenId) && (mRcDisplay != null)) {
            //mArtwork = scaleBitmapIfTooBig(mArtwork, mArtworkExpectedWidth, mArtworkExpectedHeight);
            //try {
                //mRcDisplay.setArtwork(mInternalClientGenId, mArtwork);
            //} catch (RemoteException e) {
                //Log.e(TAG, "Error in sendArtwork(), dead display "+e);
                //detachFromDisplay_syncCacheLock();
            //}
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.992 -0400", hash_original_method = "9C956ABC194A8C18AFD74A607E4260C4", hash_generated_method = "62E66948C1C58836BA9333A56196C591")
    private void sendMetadataWithArtwork_syncCacheLock() {
        if((mCurrentClientGenId == mInternalClientGenId) && (mRcDisplay != null))        
        {
            mArtwork = scaleBitmapIfTooBig(mArtwork, mArtworkExpectedWidth, mArtworkExpectedHeight);
            try 
            {
                mRcDisplay.setAllMetadata(mInternalClientGenId, mMetadata, mArtwork);
            } //End block
            catch (RemoteException e)
            {
                detachFromDisplay_syncCacheLock();
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if ((mCurrentClientGenId == mInternalClientGenId) && (mRcDisplay != null)) {
            //mArtwork = scaleBitmapIfTooBig(mArtwork, mArtworkExpectedWidth, mArtworkExpectedHeight);
            //try {
                //mRcDisplay.setAllMetadata(mInternalClientGenId, mMetadata, mArtwork);
            //} catch (RemoteException e) {
                //Log.e(TAG, "Error in setAllMetadata(), dead display "+e);
                //detachFromDisplay_syncCacheLock();
            //}
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.993 -0400", hash_original_method = "0BE7AE1519A8E1F03CB0A5A1A7C2DA4C", hash_generated_method = "41DCAC07CC73BA8056C2C156B8136902")
    private void onNewInternalClientGen(Integer clientGeneration, int artWidth, int artHeight) {
        synchronized
(mCacheLock)        {
            mInternalClientGenId = clientGeneration.intValue();
            if(artWidth > 0)            
            {
                mArtworkExpectedWidth = artWidth;
                mArtworkExpectedHeight = artHeight;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //synchronized (mCacheLock) {
            //mInternalClientGenId = clientGeneration.intValue();
            //if (artWidth > 0) {
                //mArtworkExpectedWidth = artWidth;
                //mArtworkExpectedHeight = artHeight;
            //}
        //}
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.995 -0400", hash_original_method = "6CA13622614E338BD9C3EB3C00B6EAD4", hash_generated_method = "CE1E34C2269255946FE14815078895D2")
    private void onNewCurrentClientGen(int clientGeneration) {
        synchronized
(mCacheLock)        {
            mCurrentClientGenId = clientGeneration;
        } //End block
        // ---------- Original Method ----------
        //synchronized (mCacheLock) {
            //mCurrentClientGenId = clientGeneration;
        //}
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.996 -0400", hash_original_method = "53EC796651633C35ADEE8DE59FBA0A28", hash_generated_method = "7EB3D35BCC5B940E229808DC7334D943")
    private void onPlugDisplay(IRemoteControlDisplay rcd) {
        synchronized
(mCacheLock)        {
            mRcDisplay = rcd;
        } //End block
        // ---------- Original Method ----------
        //synchronized(mCacheLock) {
            //mRcDisplay = rcd;
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.997 -0400", hash_original_method = "C16B385AF67DD61790B8C9E68A3BEA11", hash_generated_method = "93DDA2D0AB837878B27BAAC2833A35F4")
    private void onUnplugDisplay(IRemoteControlDisplay rcd) {
        addTaint(rcd.getTaint());
        synchronized
(mCacheLock)        {
            if((mRcDisplay != null) && (mRcDisplay.asBinder().equals(rcd.asBinder())))            
            {
                mRcDisplay = null;
                mArtworkExpectedWidth = ARTWORK_DEFAULT_SIZE;
                mArtworkExpectedHeight = ARTWORK_DEFAULT_SIZE;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //synchronized(mCacheLock) {
            //if ((mRcDisplay != null) && (mRcDisplay.asBinder().equals(rcd.asBinder()))) {
                //mRcDisplay = null;
                //mArtworkExpectedWidth = ARTWORK_DEFAULT_SIZE;
                //mArtworkExpectedHeight = ARTWORK_DEFAULT_SIZE;
            //}
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.999 -0400", hash_original_method = "1F39DBEB11686CD36B20A5C71DB4136D", hash_generated_method = "54BF838B97008517A38F7148DA6876B4")
    private Bitmap scaleBitmapIfTooBig(Bitmap bitmap, int maxWidth, int maxHeight) {
        addTaint(maxHeight);
        addTaint(maxWidth);
        addTaint(bitmap.getTaint());
        if(bitmap != null)        
        {
            final int width = bitmap.getWidth();
            final int height = bitmap.getHeight();
            if(width > maxWidth || height > maxHeight)            
            {
                float scale = Math.min((float) maxWidth / width, (float) maxHeight / height);
                int newWidth = Math.round(scale * width);
                int newHeight = Math.round(scale * height);
                Bitmap outBitmap = Bitmap.createBitmap(newWidth, newHeight, bitmap.getConfig());
                Canvas canvas = new Canvas(outBitmap);
                Paint paint = new Paint();
                paint.setAntiAlias(true);
                paint.setFilterBitmap(true);
                canvas.drawBitmap(bitmap, null,
                        new RectF(0, 0, outBitmap.getWidth(), outBitmap.getHeight()), paint);
                bitmap = outBitmap;
            } //End block
        } //End block
Bitmap var3752488A34EC2C4FECF5AE64DF03DAEB_1110661739 =         bitmap;
        var3752488A34EC2C4FECF5AE64DF03DAEB_1110661739.addTaint(taint);
        return var3752488A34EC2C4FECF5AE64DF03DAEB_1110661739;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    private static boolean validTypeForKey(int key, int[] validKeys) {
        try {
            for (int i = 0 ; ; i++) {
                if (key == validKeys[i]) {
                    return true;
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
    }

    
    public class MetadataEditor {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.001 -0400", hash_original_field = "922AE1910D97CE6259E18622EBD56704", hash_generated_field = "B4345E59801D3DC5F4E85DD85D29A43C")

        protected boolean mMetadataChanged;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.001 -0400", hash_original_field = "DC644474377EA8495CFBC89F2C980831", hash_generated_field = "ECD34150F8B85611F271E6014D9D883D")

        protected boolean mArtworkChanged;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.001 -0400", hash_original_field = "591A25AD459249A62BE2F0EE6B48AA51", hash_generated_field = "0EF4A2673652F896972F4DB3B96FB334")

        protected Bitmap mEditorArtwork;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.001 -0400", hash_original_field = "A466346EB11B259E8F4D68E126970EF9", hash_generated_field = "85DB44FBC7E40E567386653DF585C1CB")

        protected Bundle mEditorMetadata;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.001 -0400", hash_original_field = "B9EF4436306782A025291D9D01DEA3F7", hash_generated_field = "FDEB24494AE0377307265E3205B5F5A1")

        private boolean mApplied = false;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.002 -0400", hash_original_method = "35489133548A4653F80D8552B0E58378", hash_generated_method = "8F0077210051A860529F5C8FE4CA59F4")
        private  MetadataEditor() {
            // ---------- Original Method ----------
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.003 -0400", hash_original_method = "3FF219DE1407B1650498BA4CB70E771E", hash_generated_method = "4A2164E12F3FF817BCD9F013D5F0252F")
        public Object clone() throws CloneNotSupportedException {
            CloneNotSupportedException var1615C718FF05C0D800F9FFF876AD8603_444958061 = new CloneNotSupportedException();
            var1615C718FF05C0D800F9FFF876AD8603_444958061.addTaint(taint);
            throw var1615C718FF05C0D800F9FFF876AD8603_444958061;
            // ---------- Original Method ----------
            //throw new CloneNotSupportedException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.004 -0400", hash_original_method = "DC698BF42DF290A93E2069AFDF9D8834", hash_generated_method = "C1643F954201E567067007C34DB18745")
        public synchronized MetadataEditor putString(int key, String value) throws IllegalArgumentException {
            addTaint(value.getTaint());
            addTaint(key);
            if(mApplied)            
            {
MetadataEditor var72A74007B2BE62B849F475C7BDA4658B_1998881026 =                 this;
                var72A74007B2BE62B849F475C7BDA4658B_1998881026.addTaint(taint);
                return var72A74007B2BE62B849F475C7BDA4658B_1998881026;
            } //End block
            if(!validTypeForKey(key, METADATA_KEYS_TYPE_STRING))            
            {
                IllegalArgumentException var19697FD90423497588699BB99E6F16FE_596502715 = new IllegalArgumentException("Invalid type 'String' for key "+ key);
                var19697FD90423497588699BB99E6F16FE_596502715.addTaint(taint);
                throw var19697FD90423497588699BB99E6F16FE_596502715;
            } //End block
            mEditorMetadata.putString(String.valueOf(key), value);
            mMetadataChanged = true;
MetadataEditor var72A74007B2BE62B849F475C7BDA4658B_634577800 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_634577800.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_634577800;
            // ---------- Original Method ----------
            //if (mApplied) {
                //Log.e(TAG, "Can't edit a previously applied MetadataEditor");
                //return this;
            //}
            //if (!validTypeForKey(key, METADATA_KEYS_TYPE_STRING)) {
                //throw(new IllegalArgumentException("Invalid type 'String' for key "+ key));
            //}
            //mEditorMetadata.putString(String.valueOf(key), value);
            //mMetadataChanged = true;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.005 -0400", hash_original_method = "59EE363FF7F9B37AD6A675925DC53A2A", hash_generated_method = "B66C1CF9F4281E86996D7454DB491171")
        public synchronized MetadataEditor putLong(int key, long value) throws IllegalArgumentException {
            addTaint(value);
            addTaint(key);
            if(mApplied)            
            {
MetadataEditor var72A74007B2BE62B849F475C7BDA4658B_1155783337 =                 this;
                var72A74007B2BE62B849F475C7BDA4658B_1155783337.addTaint(taint);
                return var72A74007B2BE62B849F475C7BDA4658B_1155783337;
            } //End block
            if(!validTypeForKey(key, METADATA_KEYS_TYPE_LONG))            
            {
                IllegalArgumentException varDE4C8C6E2BF229D00E71F4420C0A8E29_2143175865 = new IllegalArgumentException("Invalid type 'long' for key "+ key);
                varDE4C8C6E2BF229D00E71F4420C0A8E29_2143175865.addTaint(taint);
                throw varDE4C8C6E2BF229D00E71F4420C0A8E29_2143175865;
            } //End block
            mEditorMetadata.putLong(String.valueOf(key), value);
            mMetadataChanged = true;
MetadataEditor var72A74007B2BE62B849F475C7BDA4658B_1100876326 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1100876326.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1100876326;
            // ---------- Original Method ----------
            //if (mApplied) {
                //Log.e(TAG, "Can't edit a previously applied MetadataEditor");
                //return this;
            //}
            //if (!validTypeForKey(key, METADATA_KEYS_TYPE_LONG)) {
                //throw(new IllegalArgumentException("Invalid type 'long' for key "+ key));
            //}
            //mEditorMetadata.putLong(String.valueOf(key), value);
            //mMetadataChanged = true;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.007 -0400", hash_original_method = "392D9C0804150D161643AF9A81D31BAB", hash_generated_method = "7872390BE8A29060483F79CF18E8FBA3")
        public synchronized MetadataEditor putBitmap(int key, Bitmap bitmap) throws IllegalArgumentException {
            addTaint(key);
            if(mApplied)            
            {
MetadataEditor var72A74007B2BE62B849F475C7BDA4658B_196493415 =                 this;
                var72A74007B2BE62B849F475C7BDA4658B_196493415.addTaint(taint);
                return var72A74007B2BE62B849F475C7BDA4658B_196493415;
            } //End block
            if(key != BITMAP_KEY_ARTWORK)            
            {
                IllegalArgumentException varF070F702F3B8A3B0C403B48995DA94A9_650889636 = new IllegalArgumentException("Invalid type 'Bitmap' for key "+ key);
                varF070F702F3B8A3B0C403B48995DA94A9_650889636.addTaint(taint);
                throw varF070F702F3B8A3B0C403B48995DA94A9_650889636;
            } //End block
            if((mArtworkExpectedWidth > 0) && (mArtworkExpectedHeight > 0))            
            {
                mEditorArtwork = scaleBitmapIfTooBig(bitmap,
                        mArtworkExpectedWidth, mArtworkExpectedHeight);
            } //End block
            else
            {
                mEditorArtwork = bitmap;
            } //End block
            mArtworkChanged = true;
MetadataEditor var72A74007B2BE62B849F475C7BDA4658B_1119306195 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1119306195.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1119306195;
            // ---------- Original Method ----------
            //if (mApplied) {
                //Log.e(TAG, "Can't edit a previously applied MetadataEditor");
                //return this;
            //}
            //if (key != BITMAP_KEY_ARTWORK) {
                //throw(new IllegalArgumentException("Invalid type 'Bitmap' for key "+ key));
            //}
            //if ((mArtworkExpectedWidth > 0) && (mArtworkExpectedHeight > 0)) {
                //mEditorArtwork = scaleBitmapIfTooBig(bitmap,
                        //mArtworkExpectedWidth, mArtworkExpectedHeight);
            //} else {
                //mEditorArtwork = bitmap;
            //}
            //mArtworkChanged = true;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.008 -0400", hash_original_method = "0A0B775C77CB462F6342E4F76031A7F3", hash_generated_method = "A481AC120F8EBB9ABFCBA38F934A29F5")
        public synchronized void clear() {
            if(mApplied)            
            {
                return;
            } //End block
            mEditorMetadata.clear();
            mEditorArtwork = null;
            // ---------- Original Method ----------
            //if (mApplied) {
                //Log.e(TAG, "Can't clear a previously applied MetadataEditor");
                //return;
            //}
            //mEditorMetadata.clear();
            //mEditorArtwork = null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.009 -0400", hash_original_method = "93FD8866501AA3B03BDE4E693768AF3B", hash_generated_method = "D60361C64E5780A4B65FD4F46B37771C")
        public synchronized void apply() {
            if(mApplied)            
            {
                return;
            } //End block
            synchronized
(mCacheLock)            {
                mMetadata = new Bundle(mEditorMetadata);
                if((mArtwork != null) && (!mArtwork.equals(mEditorArtwork)))                
                {
                    mArtwork.recycle();
                } //End block
                mArtwork = mEditorArtwork;
                mEditorArtwork = null;
                if(mMetadataChanged & mArtworkChanged)                
                {
                    sendMetadataWithArtwork_syncCacheLock();
                } //End block
                else
                if(mMetadataChanged)                
                {
                    sendMetadata_syncCacheLock();
                } //End block
                else
                if(mArtworkChanged)                
                {
                    sendArtwork_syncCacheLock();
                } //End block
                mApplied = true;
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.010 -0400", hash_original_field = "3FB4191C765633E0F8B806B7A99FAEEC", hash_generated_field = "483347541B59F8DFA8B12B3C1A84C12D")

        public final static int BITMAP_KEY_ARTWORK = 100;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.010 -0400", hash_original_field = "272507BE4AC597CE2F9EF960ED378355", hash_generated_field = "B8846CA5BE8D5CB94BBEF3C2B4B1EC50")

        public final static int METADATA_KEY_ARTWORK = BITMAP_KEY_ARTWORK;
    }


    
    private class EventHandler extends Handler {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.011 -0400", hash_original_method = "E835DA7FA2605C7661321C420AF4C36C", hash_generated_method = "CA8F8B82761AB25D962E01972D3A64CE")
        public  EventHandler(RemoteControlClient rcc, Looper looper) {
            super(looper);
            addTaint(looper.getTaint());
            addTaint(rcc.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.011 -0400", hash_original_method = "7971FD8B56BD97CBBF08B4EAB35A2033", hash_generated_method = "FBEC1DD70AD5B0458831A46E2B0252DB")
        @Override
        public void handleMessage(Message msg) {
            addTaint(msg.getTaint());
switch(msg.what){
            case MSG_REQUEST_PLAYBACK_STATE:
            synchronized
(mCacheLock)            {
                sendPlaybackState_syncCacheLock();
            } //End block
            break;
            case MSG_REQUEST_METADATA:
            synchronized
(mCacheLock)            {
                sendMetadata_syncCacheLock();
            } //End block
            break;
            case MSG_REQUEST_TRANSPORTCONTROL:
            synchronized
(mCacheLock)            {
                sendTransportControlFlags_syncCacheLock();
            } //End block
            break;
            case MSG_REQUEST_ARTWORK:
            synchronized
(mCacheLock)            {
                sendArtwork_syncCacheLock();
            } //End block
            break;
            case MSG_NEW_INTERNAL_CLIENT_GEN:
            onNewInternalClientGen((Integer)msg.obj, msg.arg1, msg.arg2);
            break;
            case MSG_NEW_CURRENT_CLIENT_GEN:
            onNewCurrentClientGen(msg.arg1);
            break;
            case MSG_PLUG_DISPLAY:
            onPlugDisplay((IRemoteControlDisplay)msg.obj);
            break;
            case MSG_UNPLUG_DISPLAY:
            onUnplugDisplay((IRemoteControlDisplay)msg.obj);
            break;
            default:
}
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.011 -0400", hash_original_field = "681829CC43857D7BDD496D82309A510B", hash_generated_field = "2BE2B9C77FA549F039F405BEB17D9487")

    private final static String TAG = "RemoteControlClient";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.012 -0400", hash_original_field = "5E0127EB9BF7A14512771B2677F027DD", hash_generated_field = "F4D3F848A6E915802E08F3A2E5F1F53B")

    public final static int PLAYSTATE_STOPPED            = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.012 -0400", hash_original_field = "621168741A25DDF3B86B889A9C3FF411", hash_generated_field = "B88C1E8F7B840BB920E884E441877169")

    public final static int PLAYSTATE_PAUSED             = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.012 -0400", hash_original_field = "C6881F6FB78551DFB2511794BBB7FB22", hash_generated_field = "88F962CE51D407CF120388E614DE441E")

    public final static int PLAYSTATE_PLAYING            = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.012 -0400", hash_original_field = "153E0DF6D2E1F8A5AAE67359A666190C", hash_generated_field = "3BE856E2C7FB5313A81FB5745940F465")

    public final static int PLAYSTATE_FAST_FORWARDING    = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.012 -0400", hash_original_field = "D748EC1812D4B9F7D3397B5A882DE85E", hash_generated_field = "DF462EA5CD01B99AD41758C41F4F8E63")

    public final static int PLAYSTATE_REWINDING          = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.012 -0400", hash_original_field = "214B701550DDC8A0EBBF9A388A5F7C2D", hash_generated_field = "35E136D27B02C2075FEAF30610947F93")

    public final static int PLAYSTATE_SKIPPING_FORWARDS  = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.012 -0400", hash_original_field = "033F1B827C945D57AC7CCA8EA3E27B62", hash_generated_field = "66CB7FA527A0829DAAFBA60CE93D1385")

    public final static int PLAYSTATE_SKIPPING_BACKWARDS = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.012 -0400", hash_original_field = "ED9C8E57D9B012079EF5E3C6E6F1E201", hash_generated_field = "CF7819B197FB94121B302B9141F6961C")

    public final static int PLAYSTATE_BUFFERING          = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.012 -0400", hash_original_field = "7B83D065C28AE0B614BC1796DC508604", hash_generated_field = "6CAACC1CF95FAD80651991CB4C906A4D")

    public final static int PLAYSTATE_ERROR              = 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.012 -0400", hash_original_field = "36CEEF9DDA4C3D06DDE4F822EB620475", hash_generated_field = "61319DA85C97420F017C045A9C1729C8")

    public final static int PLAYSTATE_NONE               = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.012 -0400", hash_original_field = "8D0CB88A9669F720A6E7F1DB58C0426E", hash_generated_field = "D9C2B7C797239CFADF59DF6E95F1B111")

    public final static int FLAG_KEY_MEDIA_PREVIOUS = 1 << 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.012 -0400", hash_original_field = "C5A69C0DBDB0E6DC2A73F6E5910E8085", hash_generated_field = "E60961DC3DFBE2A350F7E65CD95479FA")

    public final static int FLAG_KEY_MEDIA_REWIND = 1 << 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.012 -0400", hash_original_field = "68C8D3519A301059C4C3985972B92B4C", hash_generated_field = "C4AADE8FFD83074B2941C8BB305E5194")

    public final static int FLAG_KEY_MEDIA_PLAY = 1 << 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.012 -0400", hash_original_field = "0D1333C0CA3DADD45D56CA57848D0CA8", hash_generated_field = "A50B60387E829EE960A6C24801483960")

    public final static int FLAG_KEY_MEDIA_PLAY_PAUSE = 1 << 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.012 -0400", hash_original_field = "86E621275F2541D2980E411D334BBC56", hash_generated_field = "3037539F2A50CCC54FEF961DB8032CE3")

    public final static int FLAG_KEY_MEDIA_PAUSE = 1 << 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.013 -0400", hash_original_field = "6BCE4D5FF832233773CF7561E86943E3", hash_generated_field = "EB951276E4926A00C8B2D0185D744968")

    public final static int FLAG_KEY_MEDIA_STOP = 1 << 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.013 -0400", hash_original_field = "99660D6F0073B6B1E283E333D89D03EF", hash_generated_field = "727BB4258CAB824CD82070CC756209D0")

    public final static int FLAG_KEY_MEDIA_FAST_FORWARD = 1 << 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.013 -0400", hash_original_field = "9992329CD1297736A27A70FDA9A8044B", hash_generated_field = "AA28402D84BB64B0BBA8663A9933668C")

    public final static int FLAG_KEY_MEDIA_NEXT = 1 << 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.013 -0400", hash_original_field = "6831E878380D68BB6DC2E8DCF8CF0B94", hash_generated_field = "69F8ECB2680C2648C44FFD84EC8F50D3")

    public final static int FLAGS_KEY_MEDIA_NONE = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.013 -0400", hash_original_field = "81B41881744B60F3420A2E698C18B318", hash_generated_field = "9E8AFBDC008F82D3058F352782A0E928")

    public final static int FLAG_INFORMATION_REQUEST_METADATA = 1 << 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.013 -0400", hash_original_field = "E5126BD55CB1C20E9D217C1E06D01370", hash_generated_field = "78AAB419BAA72EC0F3DF7F385ECF46E0")

    public final static int FLAG_INFORMATION_REQUEST_KEY_MEDIA = 1 << 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.013 -0400", hash_original_field = "1036EBA05FF4968278AFFDC3E39A1CA1", hash_generated_field = "3B5B3AE1258E6EDAA51221A3AED72F72")

    public final static int FLAG_INFORMATION_REQUEST_PLAYSTATE = 1 << 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.013 -0400", hash_original_field = "658BA1663FD3990D54FAF0DCE735DFA7", hash_generated_field = "28B78930FAA93C3B508BFC7444D9B284")

    public final static int FLAG_INFORMATION_REQUEST_ALBUM_ART = 1 << 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.013 -0400", hash_original_field = "D9CC95D3F23025733638EDC27E3CF919", hash_generated_field = "0FD52E847D577969F790EF01F30CA0E3")

    private static final int[] METADATA_KEYS_TYPE_STRING = {
        MediaMetadataRetriever.METADATA_KEY_ALBUM,
        MediaMetadataRetriever.METADATA_KEY_ALBUMARTIST,
        MediaMetadataRetriever.METADATA_KEY_TITLE,
        MediaMetadataRetriever.METADATA_KEY_ARTIST,
        MediaMetadataRetriever.METADATA_KEY_AUTHOR,
        MediaMetadataRetriever.METADATA_KEY_COMPILATION,
        MediaMetadataRetriever.METADATA_KEY_COMPOSER,
        MediaMetadataRetriever.METADATA_KEY_DATE,
        MediaMetadataRetriever.METADATA_KEY_GENRE,
        MediaMetadataRetriever.METADATA_KEY_TITLE,
        MediaMetadataRetriever.METADATA_KEY_WRITER };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.013 -0400", hash_original_field = "28060E061B4D52D0125A33FF330B3083", hash_generated_field = "C58FCF18F5F9EC50B35A59C6AC7F2853")

    private static final int[] METADATA_KEYS_TYPE_LONG = {
        MediaMetadataRetriever.METADATA_KEY_CD_TRACK_NUMBER,
        MediaMetadataRetriever.METADATA_KEY_DISC_NUMBER,
        MediaMetadataRetriever.METADATA_KEY_DURATION };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.013 -0400", hash_original_field = "926031DD4A7EAD81A49C52CDFD916BCD", hash_generated_field = "AACFB6D022148421C2F0C7D1E8331E7D")

    private final static int MSG_REQUEST_PLAYBACK_STATE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.013 -0400", hash_original_field = "0FC40B07A6FE09600D86D821AA51165B", hash_generated_field = "04F84EAB3F4DEDCC1CA54ADDFD303582")

    private final static int MSG_REQUEST_METADATA = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.013 -0400", hash_original_field = "E29DF1B33CEAC31DA3E993269C1E7BE6", hash_generated_field = "D37436C8088C6C0DD8728AB37ADE0846")

    private final static int MSG_REQUEST_TRANSPORTCONTROL = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.013 -0400", hash_original_field = "2A2FDA74B0DD75E7B48B517AC71A215A", hash_generated_field = "8B1638BE5F1799455DA931602163CF68")

    private final static int MSG_REQUEST_ARTWORK = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.013 -0400", hash_original_field = "046B9727A90AEA92C2850DF25EBBF61B", hash_generated_field = "92F3229CC0658FD8B22E0EDEA145897F")

    private final static int MSG_NEW_INTERNAL_CLIENT_GEN = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.014 -0400", hash_original_field = "528F89878835FD3BB0C0C86F78D4309A", hash_generated_field = "29900B94B2A6D2360A16D8FD28735F4E")

    private final static int MSG_NEW_CURRENT_CLIENT_GEN = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.014 -0400", hash_original_field = "9C9BA0FDCB520492ED3B1309161B6DC5", hash_generated_field = "E8EBAAC9849DE665CC38834147B90E01")

    private final static int MSG_PLUG_DISPLAY = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.014 -0400", hash_original_field = "374E0D01E8E7E8ED123E4CEBC1314CD4", hash_generated_field = "9A2D676D79FDA0EEDBD63F1D0F038755")

    private final static int MSG_UNPLUG_DISPLAY = 8;
}

