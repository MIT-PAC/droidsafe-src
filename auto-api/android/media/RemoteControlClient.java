package android.media;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.media.MediaMetadataRetriever;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import java.lang.IllegalArgumentException;

public class RemoteControlClient {
    private Object mCacheLock = new Object();
    private int mPlaybackState = PLAYSTATE_NONE;
    private long mPlaybackStateChangeTimeMs = 0;
    private Bitmap mArtwork;
    private int ARTWORK_DEFAULT_SIZE = 256;
    private int ARTWORK_INVALID_SIZE = -1;
    private int mArtworkExpectedWidth = ARTWORK_DEFAULT_SIZE;
    private int mArtworkExpectedHeight = ARTWORK_DEFAULT_SIZE;
    private int mTransportControlFlags = FLAGS_KEY_MEDIA_NONE;
    private Bundle mMetadata = new Bundle();
    private int mCurrentClientGenId = -1;
    private int mInternalClientGenId = -2;
    private PendingIntent mRcMediaIntent;
    private IRemoteControlDisplay mRcDisplay;
    private IRemoteControlClient mIRCC = new IRemoteControlClient.Stub() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.340 -0400", hash_original_method = "F932B544DD1B5B88DDD0055B7C1D8F98", hash_generated_method = "D4CA43EAFDA3CD998FD38FAB79E6BD74")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void onInformationRequested(int clientGeneration, int infoFlags,
                int artWidth, int artHeight) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(infoFlags);
            dsTaint.addTaint(clientGeneration);
            dsTaint.addTaint(artWidth);
            dsTaint.addTaint(artHeight);
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
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.341 -0400", hash_original_method = "A6F81BEED91E1311AA2FA5D9223AC5BE", hash_generated_method = "4DEF749D51A125EE74F6CC88A074D13C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void setCurrentClientGenerationId(int clientGeneration) {
            dsTaint.addTaint(clientGeneration);
            {
                mEventHandler.removeMessages(MSG_NEW_CURRENT_CLIENT_GEN);
                mEventHandler.dispatchMessage(mEventHandler.obtainMessage(
                        MSG_NEW_CURRENT_CLIENT_GEN, clientGeneration, 0));
            } //End block
            // ---------- Original Method ----------
            //if (mEventHandler != null) {
                //mEventHandler.removeMessages(MSG_NEW_CURRENT_CLIENT_GEN);
                //mEventHandler.dispatchMessage(mEventHandler.obtainMessage(
                        //MSG_NEW_CURRENT_CLIENT_GEN, clientGeneration, 0));
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.341 -0400", hash_original_method = "858E8A6EB1AEED0E033B6B24928ADF7F", hash_generated_method = "350B0335508A5E76B3E76C9013E49834")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void plugRemoteControlDisplay(IRemoteControlDisplay rcd) {
            dsTaint.addTaint(rcd.dsTaint);
            {
                mEventHandler.dispatchMessage(mEventHandler.obtainMessage(
                        MSG_PLUG_DISPLAY, rcd));
            } //End block
            // ---------- Original Method ----------
            //if (mEventHandler != null) {
                //mEventHandler.dispatchMessage(mEventHandler.obtainMessage(
                        //MSG_PLUG_DISPLAY, rcd));
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.341 -0400", hash_original_method = "E2F436516A1B085C4A3368B079EC9835", hash_generated_method = "384DFD7E469D3BA5EC20C9E9C9161511")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void unplugRemoteControlDisplay(IRemoteControlDisplay rcd) {
            dsTaint.addTaint(rcd.dsTaint);
            {
                mEventHandler.dispatchMessage(mEventHandler.obtainMessage(
                        MSG_UNPLUG_DISPLAY, rcd));
            } //End block
            // ---------- Original Method ----------
            //if (mEventHandler != null) {
                //mEventHandler.dispatchMessage(mEventHandler.obtainMessage(
                        //MSG_UNPLUG_DISPLAY, rcd));
            //}
        }

        
}; //Transformed anonymous class
    private EventHandler mEventHandler;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.342 -0400", hash_original_method = "AD6CCD9D9B436D492F90BC57466F8BB6", hash_generated_method = "B02BC89219D340E4D78A03AB7243BAA4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public RemoteControlClient(PendingIntent mediaButtonIntent) {
        dsTaint.addTaint(mediaButtonIntent.dsTaint);
        Looper looper;
        {
            boolean var59AC82EBCD14E4AA50598F2AE3563759_1620997252 = ((looper = Looper.myLooper()) != null);
            {
                mEventHandler = new EventHandler(this, looper);
            } //End block
            {
                boolean var9D854D75870272BF06142F5CE681F893_38518129 = ((looper = Looper.getMainLooper()) != null);
                {
                    mEventHandler = new EventHandler(this, looper);
                } //End block
                {
                    mEventHandler = null;
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.342 -0400", hash_original_method = "BBCB02942EAA4463B06F3A8D8D85915D", hash_generated_method = "EB392C494269E2F07697C6D95603F4F5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public RemoteControlClient(PendingIntent mediaButtonIntent, Looper looper) {
        dsTaint.addTaint(looper.dsTaint);
        dsTaint.addTaint(mediaButtonIntent.dsTaint);
        mEventHandler = new EventHandler(this, looper);
        // ---------- Original Method ----------
        //mRcMediaIntent = mediaButtonIntent;
        //mEventHandler = new EventHandler(this, looper);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.343 -0400", hash_original_method = "848F28E79710FB7B251A1B961691D3AF", hash_generated_method = "DB903A319AD537A7B74BD44E1D55479A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public MetadataEditor editMetadata(boolean startEmpty) {
        dsTaint.addTaint(startEmpty);
        MetadataEditor editor;
        editor = new MetadataEditor();
        {
            editor.mEditorMetadata = new Bundle();
            editor.mEditorArtwork = null;
            editor.mMetadataChanged = true;
            editor.mArtworkChanged = true;
        } //End block
        {
            editor.mEditorMetadata = new Bundle(mMetadata);
            editor.mEditorArtwork = mArtwork;
            editor.mMetadataChanged = false;
            editor.mArtworkChanged = false;
        } //End block
        return (MetadataEditor)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.343 -0400", hash_original_method = "1B4A5A7A2B9348E61A1F8DBEDB05B350", hash_generated_method = "895DE2A662D6FEEAC8E7864FC6C5A31D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setPlaybackState(int state) {
        dsTaint.addTaint(state);
        {
            {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.343 -0400", hash_original_method = "940D4AD017270A6AD7F6D36A1ADC2473", hash_generated_method = "D1D38A1C538D5DC599CC1A7DA3481B49")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setTransportControlFlags(int transportControlFlags) {
        dsTaint.addTaint(transportControlFlags);
        {
            sendTransportControlFlags_syncCacheLock();
        } //End block
        // ---------- Original Method ----------
        //synchronized(mCacheLock) {
            //mTransportControlFlags = transportControlFlags;
            //sendTransportControlFlags_syncCacheLock();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.344 -0400", hash_original_method = "2C35ADA55DC65E9D8CCC19BDAA7D2B4B", hash_generated_method = "6DAF1A7DABC903745E7AAC745691F2DE")
    @DSModeled(DSC.SAFE)
    public PendingIntent getRcMediaIntent() {
        return (PendingIntent)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mRcMediaIntent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.344 -0400", hash_original_method = "6031DEC176ACCB06C28473E7885E0907", hash_generated_method = "D4FA9A63079ADEC0B4E7E8A2717BA5AF")
    @DSModeled(DSC.SAFE)
    public IRemoteControlClient getIRemoteControlClient() {
        return (IRemoteControlClient)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mIRCC;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.344 -0400", hash_original_method = "1D4279FF389DE00E45CE62733E438945", hash_generated_method = "7BE69845830A5C30F8E86A0E732E3185")
    @DSModeled(DSC.SAFE)
    private void detachFromDisplay_syncCacheLock() {
        mRcDisplay = null;
        mArtworkExpectedWidth = ARTWORK_INVALID_SIZE;
        mArtworkExpectedHeight = ARTWORK_INVALID_SIZE;
        // ---------- Original Method ----------
        //mRcDisplay = null;
        //mArtworkExpectedWidth = ARTWORK_INVALID_SIZE;
        //mArtworkExpectedHeight = ARTWORK_INVALID_SIZE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.344 -0400", hash_original_method = "DCEF21D9331BDE9855981A4FAF951191", hash_generated_method = "3C882332ED9B318A0E7C937A9851B766")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void sendPlaybackState_syncCacheLock() {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.345 -0400", hash_original_method = "414E902B5C775D55BC88776E02F34242", hash_generated_method = "340B912F26F8C95214621876511F0079")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void sendMetadata_syncCacheLock() {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.345 -0400", hash_original_method = "AE3ACB485EA21BE41AFE152A08682540", hash_generated_method = "CDACD6606375D72EF147FF50CA16AB3F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void sendTransportControlFlags_syncCacheLock() {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.346 -0400", hash_original_method = "1072470EEE2F2109E34F0B1C5EF1161C", hash_generated_method = "61E68A3A77098E438137E295F48B15CD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void sendArtwork_syncCacheLock() {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.346 -0400", hash_original_method = "9C956ABC194A8C18AFD74A607E4260C4", hash_generated_method = "0D1125B3E60375515D0905499CC13DBC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void sendMetadataWithArtwork_syncCacheLock() {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.346 -0400", hash_original_method = "0BE7AE1519A8E1F03CB0A5A1A7C2DA4C", hash_generated_method = "DF119206A5DFE2DF8A25C58830D6FB1E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void onNewInternalClientGen(Integer clientGeneration, int artWidth, int artHeight) {
        dsTaint.addTaint(clientGeneration.dsTaint);
        dsTaint.addTaint(artWidth);
        dsTaint.addTaint(artHeight);
        {
            mInternalClientGenId = clientGeneration.intValue();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.354 -0400", hash_original_method = "6CA13622614E338BD9C3EB3C00B6EAD4", hash_generated_method = "5E363DC689A6549DEBD3E86987F8F133")
    @DSModeled(DSC.SAFE)
    private void onNewCurrentClientGen(int clientGeneration) {
        dsTaint.addTaint(clientGeneration);
        // ---------- Original Method ----------
        //synchronized (mCacheLock) {
            //mCurrentClientGenId = clientGeneration;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.354 -0400", hash_original_method = "53EC796651633C35ADEE8DE59FBA0A28", hash_generated_method = "B3C1CE107D7B880A1A54DE35767A7E8D")
    @DSModeled(DSC.SAFE)
    private void onPlugDisplay(IRemoteControlDisplay rcd) {
        dsTaint.addTaint(rcd.dsTaint);
        // ---------- Original Method ----------
        //synchronized(mCacheLock) {
            //mRcDisplay = rcd;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.358 -0400", hash_original_method = "C16B385AF67DD61790B8C9E68A3BEA11", hash_generated_method = "5EB7E8DE659DB54CC37B579B5DF3BE56")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void onUnplugDisplay(IRemoteControlDisplay rcd) {
        dsTaint.addTaint(rcd.dsTaint);
        {
            {
                boolean varF99110A45982ACED39E577B93F2FE97A_2120235802 = ((mRcDisplay != null) && (mRcDisplay.asBinder().equals(rcd.asBinder())));
                {
                    mRcDisplay = null;
                    mArtworkExpectedWidth = ARTWORK_DEFAULT_SIZE;
                    mArtworkExpectedHeight = ARTWORK_DEFAULT_SIZE;
                } //End block
            } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.361 -0400", hash_original_method = "1F39DBEB11686CD36B20A5C71DB4136D", hash_generated_method = "29496AD715920C37817921CA515CEE98")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Bitmap scaleBitmapIfTooBig(Bitmap bitmap, int maxWidth, int maxHeight) {
        dsTaint.addTaint(bitmap.dsTaint);
        dsTaint.addTaint(maxHeight);
        dsTaint.addTaint(maxWidth);
        {
            int width;
            width = bitmap.getWidth();
            int height;
            height = bitmap.getHeight();
            {
                float scale;
                scale = Math.min((float) maxWidth / width, (float) maxHeight / height);
                int newWidth;
                newWidth = Math.round(scale * width);
                int newHeight;
                newHeight = Math.round(scale * height);
                Bitmap outBitmap;
                outBitmap = Bitmap.createBitmap(newWidth, newHeight, bitmap.getConfig());
                Canvas canvas;
                canvas = new Canvas(outBitmap);
                Paint paint;
                paint = new Paint();
                paint.setAntiAlias(true);
                paint.setFilterBitmap(true);
                canvas.drawBitmap(bitmap, null,
                        new RectF(0, 0, outBitmap.getWidth(), outBitmap.getHeight()), paint);
                bitmap = outBitmap;
            } //End block
        } //End block
        return (Bitmap)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
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
        protected boolean mMetadataChanged;
        protected boolean mArtworkChanged;
        protected Bitmap mEditorArtwork;
        protected Bundle mEditorMetadata;
        private boolean mApplied = false;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.362 -0400", hash_original_method = "35489133548A4653F80D8552B0E58378", hash_generated_method = "8F0077210051A860529F5C8FE4CA59F4")
        @DSModeled(DSC.SAFE)
        private MetadataEditor() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.362 -0400", hash_original_method = "3FF219DE1407B1650498BA4CB70E771E", hash_generated_method = "6B89DA0F6F10056AF31CFDBC46B6E8A4")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Object clone() throws CloneNotSupportedException {
            if (DroidSafeAndroidRuntime.control) throw new CloneNotSupportedException();
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            //throw new CloneNotSupportedException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.363 -0400", hash_original_method = "DC698BF42DF290A93E2069AFDF9D8834", hash_generated_method = "5B0818A56DAE59FFEAA00349397D0A43")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public synchronized MetadataEditor putString(int key, String value) throws IllegalArgumentException {
            dsTaint.addTaint(value);
            dsTaint.addTaint(key);
            {
                boolean var64500EB793605B810FA43CE9C224FC07_539702803 = (!validTypeForKey(key, METADATA_KEYS_TYPE_STRING));
                {
                    if (DroidSafeAndroidRuntime.control) throw(new IllegalArgumentException("Invalid type 'String' for key "+ key));
                } //End block
            } //End collapsed parenthetic
            mEditorMetadata.putString(String.valueOf(key), value);
            mMetadataChanged = true;
            return (MetadataEditor)dsTaint.getTaint();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.364 -0400", hash_original_method = "59EE363FF7F9B37AD6A675925DC53A2A", hash_generated_method = "E29711FD1F2FF81697696393F0F11F5B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public synchronized MetadataEditor putLong(int key, long value) throws IllegalArgumentException {
            dsTaint.addTaint(value);
            dsTaint.addTaint(key);
            {
                boolean var562764A371AF1324C2F3645CE22F9C0E_1217831925 = (!validTypeForKey(key, METADATA_KEYS_TYPE_LONG));
                {
                    if (DroidSafeAndroidRuntime.control) throw(new IllegalArgumentException("Invalid type 'long' for key "+ key));
                } //End block
            } //End collapsed parenthetic
            mEditorMetadata.putLong(String.valueOf(key), value);
            mMetadataChanged = true;
            return (MetadataEditor)dsTaint.getTaint();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.365 -0400", hash_original_method = "392D9C0804150D161643AF9A81D31BAB", hash_generated_method = "D83E981C50676F7C6D6EB6656CD698F9")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public synchronized MetadataEditor putBitmap(int key, Bitmap bitmap) throws IllegalArgumentException {
            dsTaint.addTaint(bitmap.dsTaint);
            dsTaint.addTaint(key);
            {
                if (DroidSafeAndroidRuntime.control) throw(new IllegalArgumentException("Invalid type 'Bitmap' for key "+ key));
            } //End block
            {
                mEditorArtwork = scaleBitmapIfTooBig(bitmap,
                        mArtworkExpectedWidth, mArtworkExpectedHeight);
            } //End block
            mArtworkChanged = true;
            return (MetadataEditor)dsTaint.getTaint();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.366 -0400", hash_original_method = "0A0B775C77CB462F6342E4F76031A7F3", hash_generated_method = "91F3D1833D8795D6C35D8690287F3DE0")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public synchronized void clear() {
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.367 -0400", hash_original_method = "93FD8866501AA3B03BDE4E693768AF3B", hash_generated_method = "1C20E5FE2FB463C9792AEC7F3B93812E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public synchronized void apply() {
            {
                mMetadata = new Bundle(mEditorMetadata);
                {
                    boolean var6413C1F0A31650058FD58DD0250B281A_1441797801 = ((mArtwork != null) && (!mArtwork.equals(mEditorArtwork)));
                    {
                        mArtwork.recycle();
                    } //End block
                } //End collapsed parenthetic
                mArtwork = mEditorArtwork;
                mEditorArtwork = null;
                {
                    sendMetadataWithArtwork_syncCacheLock();
                } //End block
                {
                    sendMetadata_syncCacheLock();
                } //End block
                {
                    sendArtwork_syncCacheLock();
                } //End block
                mApplied = true;
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        public final static int BITMAP_KEY_ARTWORK = 100;
        public final static int METADATA_KEY_ARTWORK = BITMAP_KEY_ARTWORK;
    }


    
    private class EventHandler extends Handler {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.367 -0400", hash_original_method = "E835DA7FA2605C7661321C420AF4C36C", hash_generated_method = "FB9B2884EB4016FCBB2B43CAF419F1FD")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public EventHandler(RemoteControlClient rcc, Looper looper) {
            super(looper);
            dsTaint.addTaint(looper.dsTaint);
            dsTaint.addTaint(rcc.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.367 -0400", hash_original_method = "7971FD8B56BD97CBBF08B4EAB35A2033", hash_generated_method = "65EE14C1801A9CEE64470F60C7E011F3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void handleMessage(Message msg) {
            dsTaint.addTaint(msg.dsTaint);
            //Begin case MSG_REQUEST_PLAYBACK_STATE 
            {
                sendPlaybackState_syncCacheLock();
            } //End block
            //End case MSG_REQUEST_PLAYBACK_STATE 
            //Begin case MSG_REQUEST_METADATA 
            {
                sendMetadata_syncCacheLock();
            } //End block
            //End case MSG_REQUEST_METADATA 
            //Begin case MSG_REQUEST_TRANSPORTCONTROL 
            {
                sendTransportControlFlags_syncCacheLock();
            } //End block
            //End case MSG_REQUEST_TRANSPORTCONTROL 
            //Begin case MSG_REQUEST_ARTWORK 
            {
                sendArtwork_syncCacheLock();
            } //End block
            //End case MSG_REQUEST_ARTWORK 
            //Begin case MSG_NEW_INTERNAL_CLIENT_GEN 
            onNewInternalClientGen((Integer)msg.obj, msg.arg1, msg.arg2);
            //End case MSG_NEW_INTERNAL_CLIENT_GEN 
            //Begin case MSG_NEW_CURRENT_CLIENT_GEN 
            onNewCurrentClientGen(msg.arg1);
            //End case MSG_NEW_CURRENT_CLIENT_GEN 
            //Begin case MSG_PLUG_DISPLAY 
            onPlugDisplay((IRemoteControlDisplay)msg.obj);
            //End case MSG_PLUG_DISPLAY 
            //Begin case MSG_UNPLUG_DISPLAY 
            onUnplugDisplay((IRemoteControlDisplay)msg.obj);
            //End case MSG_UNPLUG_DISPLAY 
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    private final static String TAG = "RemoteControlClient";
    public final static int PLAYSTATE_STOPPED            = 1;
    public final static int PLAYSTATE_PAUSED             = 2;
    public final static int PLAYSTATE_PLAYING            = 3;
    public final static int PLAYSTATE_FAST_FORWARDING    = 4;
    public final static int PLAYSTATE_REWINDING          = 5;
    public final static int PLAYSTATE_SKIPPING_FORWARDS  = 6;
    public final static int PLAYSTATE_SKIPPING_BACKWARDS = 7;
    public final static int PLAYSTATE_BUFFERING          = 8;
    public final static int PLAYSTATE_ERROR              = 9;
    public final static int PLAYSTATE_NONE               = 0;
    public final static int FLAG_KEY_MEDIA_PREVIOUS = 1 << 0;
    public final static int FLAG_KEY_MEDIA_REWIND = 1 << 1;
    public final static int FLAG_KEY_MEDIA_PLAY = 1 << 2;
    public final static int FLAG_KEY_MEDIA_PLAY_PAUSE = 1 << 3;
    public final static int FLAG_KEY_MEDIA_PAUSE = 1 << 4;
    public final static int FLAG_KEY_MEDIA_STOP = 1 << 5;
    public final static int FLAG_KEY_MEDIA_FAST_FORWARD = 1 << 6;
    public final static int FLAG_KEY_MEDIA_NEXT = 1 << 7;
    public final static int FLAGS_KEY_MEDIA_NONE = 0;
    public final static int FLAG_INFORMATION_REQUEST_METADATA = 1 << 0;
    public final static int FLAG_INFORMATION_REQUEST_KEY_MEDIA = 1 << 1;
    public final static int FLAG_INFORMATION_REQUEST_PLAYSTATE = 1 << 2;
    public final static int FLAG_INFORMATION_REQUEST_ALBUM_ART = 1 << 3;
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
    private static final int[] METADATA_KEYS_TYPE_LONG = {
        MediaMetadataRetriever.METADATA_KEY_CD_TRACK_NUMBER,
        MediaMetadataRetriever.METADATA_KEY_DISC_NUMBER,
        MediaMetadataRetriever.METADATA_KEY_DURATION };
    private final static int MSG_REQUEST_PLAYBACK_STATE = 1;
    private final static int MSG_REQUEST_METADATA = 2;
    private final static int MSG_REQUEST_TRANSPORTCONTROL = 3;
    private final static int MSG_REQUEST_ARTWORK = 4;
    private final static int MSG_NEW_INTERNAL_CLIENT_GEN = 5;
    private final static int MSG_NEW_CURRENT_CLIENT_GEN = 6;
    private final static int MSG_PLUG_DISPLAY = 7;
    private final static int MSG_UNPLUG_DISPLAY = 8;
}

