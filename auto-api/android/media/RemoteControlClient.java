package android.media;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.459 -0400", hash_original_field = "825986C2B615FC9AC12680D3918F4AD8", hash_generated_field = "84304313B5BE2FAF3B60D13295A73C77")

    private final Object mCacheLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.459 -0400", hash_original_field = "850AD863440EDBB3324AE9D9090A9703", hash_generated_field = "4614F38337BAA651A52883AEA4B73289")

    private int mPlaybackState = PLAYSTATE_NONE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.459 -0400", hash_original_field = "63CA3372A2CBF1D691233FC176AF9A18", hash_generated_field = "1BEC69AD7A22658EBADD97D1E5E40CB0")

    private long mPlaybackStateChangeTimeMs = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.459 -0400", hash_original_field = "DCBF361CC1FA69AA2900045AD87670CA", hash_generated_field = "BC9C836A2A56878C42A006AD06D23308")

    private Bitmap mArtwork;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.459 -0400", hash_original_field = "DE3E71209A981C0CA4B18A67AD82B790", hash_generated_field = "24B92185327A5356B945DB6DA2A8A474")

    private final int ARTWORK_DEFAULT_SIZE = 256;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.459 -0400", hash_original_field = "5694730B9BE1FD5AA2E9274D3B70E646", hash_generated_field = "897D986065A139967AB4500786131D84")

    private final int ARTWORK_INVALID_SIZE = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.459 -0400", hash_original_field = "C45F63EF9C108145812FB1902A540D7A", hash_generated_field = "8965B25D9EB40BED14D87C783E89F3C5")

    private int mArtworkExpectedWidth = ARTWORK_DEFAULT_SIZE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.459 -0400", hash_original_field = "3B5CE9F4A4FFE223E4B26B0BCF27BAE6", hash_generated_field = "9A05CBDEF29D4A853B9AD874C4D29310")

    private int mArtworkExpectedHeight = ARTWORK_DEFAULT_SIZE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.459 -0400", hash_original_field = "F1EE76BCC944FDF96490A84EDE945FDD", hash_generated_field = "D886D0C4ACF243C5481BBD5AAC40B711")

    private int mTransportControlFlags = FLAGS_KEY_MEDIA_NONE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.459 -0400", hash_original_field = "0B73F4AC2A2DED1FA15B8A8376540BBD", hash_generated_field = "DA6670A1846875744AFAE7AA4DEC9FDF")

    private Bundle mMetadata = new Bundle();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.459 -0400", hash_original_field = "E5A4111167B61E938770B3077096A9AA", hash_generated_field = "9EB4244C60785911067FC7413E2DE31B")

    private int mCurrentClientGenId = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.459 -0400", hash_original_field = "6025A94A465596EFB7A4D9C270923372", hash_generated_field = "14D22A774763FE83A163754E1995815C")

    private int mInternalClientGenId = -2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.459 -0400", hash_original_field = "7156A56E00345AEDBE84A1DBB20B37D1", hash_generated_field = "0D33962CDFCC7D569FC4E814D31B5DFB")

    private PendingIntent mRcMediaIntent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.459 -0400", hash_original_field = "C3821363E374B4C1C9B40F69FE478F3C", hash_generated_field = "6F5BD225EE2017EE2B9E17B1141913F9")

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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.461 -0400", hash_original_field = "3487E63080D45B4AAFB4C377AC2DEA9F", hash_generated_field = "04D6DC37F0EF901EF71A528809491D49")

    private EventHandler mEventHandler;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.462 -0400", hash_original_method = "AD6CCD9D9B436D492F90BC57466F8BB6", hash_generated_method = "420F727ADE92645363313D3F61FA4B73")
    public  RemoteControlClient(PendingIntent mediaButtonIntent) {
        mRcMediaIntent = mediaButtonIntent;
        Looper looper;
        {
            boolean var59AC82EBCD14E4AA50598F2AE3563759_569295870 = ((looper = Looper.myLooper()) != null);
            {
                mEventHandler = new EventHandler(this, looper);
            } 
            {
                boolean var9D854D75870272BF06142F5CE681F893_1947258944 = ((looper = Looper.getMainLooper()) != null);
                {
                    mEventHandler = new EventHandler(this, looper);
                } 
                {
                    mEventHandler = null;
                } 
            } 
        } 
        
        
        
        
            
        
            
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.463 -0400", hash_original_method = "BBCB02942EAA4463B06F3A8D8D85915D", hash_generated_method = "2CD17C2EF419C0ACBD020B84E8A50296")
    public  RemoteControlClient(PendingIntent mediaButtonIntent, Looper looper) {
        mRcMediaIntent = mediaButtonIntent;
        mEventHandler = new EventHandler(this, looper);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.464 -0400", hash_original_method = "848F28E79710FB7B251A1B961691D3AF", hash_generated_method = "4F730E775C1C892C35BFB77DD0F0FD15")
    public MetadataEditor editMetadata(boolean startEmpty) {
        MetadataEditor varB4EAC82CA7396A68D541C85D26508E83_918039972 = null; 
        MetadataEditor editor = new MetadataEditor();
        {
            editor.mEditorMetadata = new Bundle();
            editor.mEditorArtwork = null;
            editor.mMetadataChanged = true;
            editor.mArtworkChanged = true;
        } 
        {
            editor.mEditorMetadata = new Bundle(mMetadata);
            editor.mEditorArtwork = mArtwork;
            editor.mMetadataChanged = false;
            editor.mArtworkChanged = false;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_918039972 = editor;
        addTaint(startEmpty);
        varB4EAC82CA7396A68D541C85D26508E83_918039972.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_918039972;
        
        
        
            
            
            
            
        
            
            
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.464 -0400", hash_original_method = "1B4A5A7A2B9348E61A1F8DBEDB05B350", hash_generated_method = "E1EC7135AE27622B6C8A1C7CF3F40AA2")
    public void setPlaybackState(int state) {
        {
            {
                mPlaybackState = state;
                mPlaybackStateChangeTimeMs = SystemClock.elapsedRealtime();
                sendPlaybackState_syncCacheLock();
            } 
        } 
        
        
            
                
                
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.465 -0400", hash_original_method = "940D4AD017270A6AD7F6D36A1ADC2473", hash_generated_method = "709A50EF4B917CA26B81C379F53EB763")
    public void setTransportControlFlags(int transportControlFlags) {
        {
            mTransportControlFlags = transportControlFlags;
            sendTransportControlFlags_syncCacheLock();
        } 
        
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.465 -0400", hash_original_method = "2C35ADA55DC65E9D8CCC19BDAA7D2B4B", hash_generated_method = "5510513D386522AEEAAE7BC19A86BE85")
    public PendingIntent getRcMediaIntent() {
        PendingIntent varB4EAC82CA7396A68D541C85D26508E83_1175651604 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1175651604 = mRcMediaIntent;
        varB4EAC82CA7396A68D541C85D26508E83_1175651604.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1175651604;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.466 -0400", hash_original_method = "6031DEC176ACCB06C28473E7885E0907", hash_generated_method = "795863280FA82414477FF866309C79C9")
    public IRemoteControlClient getIRemoteControlClient() {
        IRemoteControlClient varB4EAC82CA7396A68D541C85D26508E83_818209586 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_818209586 = mIRCC;
        varB4EAC82CA7396A68D541C85D26508E83_818209586.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_818209586;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.466 -0400", hash_original_method = "1D4279FF389DE00E45CE62733E438945", hash_generated_method = "7BE69845830A5C30F8E86A0E732E3185")
    private void detachFromDisplay_syncCacheLock() {
        mRcDisplay = null;
        mArtworkExpectedWidth = ARTWORK_INVALID_SIZE;
        mArtworkExpectedHeight = ARTWORK_INVALID_SIZE;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.467 -0400", hash_original_method = "DCEF21D9331BDE9855981A4FAF951191", hash_generated_method = "3C882332ED9B318A0E7C937A9851B766")
    private void sendPlaybackState_syncCacheLock() {
        {
            try 
            {
                mRcDisplay.setPlaybackState(mInternalClientGenId, mPlaybackState,
                        mPlaybackStateChangeTimeMs);
            } 
            catch (RemoteException e)
            {
                detachFromDisplay_syncCacheLock();
            } 
        } 
        
        
            
                
                        
            
                
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.467 -0400", hash_original_method = "414E902B5C775D55BC88776E02F34242", hash_generated_method = "340B912F26F8C95214621876511F0079")
    private void sendMetadata_syncCacheLock() {
        {
            try 
            {
                mRcDisplay.setMetadata(mInternalClientGenId, mMetadata);
            } 
            catch (RemoteException e)
            {
                detachFromDisplay_syncCacheLock();
            } 
        } 
        
        
            
                
            
                
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.467 -0400", hash_original_method = "AE3ACB485EA21BE41AFE152A08682540", hash_generated_method = "CDACD6606375D72EF147FF50CA16AB3F")
    private void sendTransportControlFlags_syncCacheLock() {
        {
            try 
            {
                mRcDisplay.setTransportControlFlags(mInternalClientGenId,
                        mTransportControlFlags);
            } 
            catch (RemoteException e)
            {
                detachFromDisplay_syncCacheLock();
            } 
        } 
        
        
            
                
                        
            
                
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.468 -0400", hash_original_method = "1072470EEE2F2109E34F0B1C5EF1161C", hash_generated_method = "61E68A3A77098E438137E295F48B15CD")
    private void sendArtwork_syncCacheLock() {
        {
            mArtwork = scaleBitmapIfTooBig(mArtwork, mArtworkExpectedWidth, mArtworkExpectedHeight);
            try 
            {
                mRcDisplay.setArtwork(mInternalClientGenId, mArtwork);
            } 
            catch (RemoteException e)
            {
                detachFromDisplay_syncCacheLock();
            } 
        } 
        
        
            
            
                
            
                
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.468 -0400", hash_original_method = "9C956ABC194A8C18AFD74A607E4260C4", hash_generated_method = "0D1125B3E60375515D0905499CC13DBC")
    private void sendMetadataWithArtwork_syncCacheLock() {
        {
            mArtwork = scaleBitmapIfTooBig(mArtwork, mArtworkExpectedWidth, mArtworkExpectedHeight);
            try 
            {
                mRcDisplay.setAllMetadata(mInternalClientGenId, mMetadata, mArtwork);
            } 
            catch (RemoteException e)
            {
                detachFromDisplay_syncCacheLock();
            } 
        } 
        
        
            
            
                
            
                
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.469 -0400", hash_original_method = "0BE7AE1519A8E1F03CB0A5A1A7C2DA4C", hash_generated_method = "378619F96F30079F7820E7B0E296BF55")
    private void onNewInternalClientGen(Integer clientGeneration, int artWidth, int artHeight) {
        {
            mInternalClientGenId = clientGeneration.intValue();
            {
                mArtworkExpectedWidth = artWidth;
                mArtworkExpectedHeight = artHeight;
            } 
        } 
        
        
            
            
                
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.469 -0400", hash_original_method = "6CA13622614E338BD9C3EB3C00B6EAD4", hash_generated_method = "3FF62058D3A647B70C055B8AAB75C39B")
    private void onNewCurrentClientGen(int clientGeneration) {
        {
            mCurrentClientGenId = clientGeneration;
        } 
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.469 -0400", hash_original_method = "53EC796651633C35ADEE8DE59FBA0A28", hash_generated_method = "4C40438E54442322ACB9E5F2A5968DB2")
    private void onPlugDisplay(IRemoteControlDisplay rcd) {
        {
            mRcDisplay = rcd;
        } 
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.470 -0400", hash_original_method = "C16B385AF67DD61790B8C9E68A3BEA11", hash_generated_method = "7D61DE9C48286BB29D186177863DD2F1")
    private void onUnplugDisplay(IRemoteControlDisplay rcd) {
        {
            {
                boolean varF99110A45982ACED39E577B93F2FE97A_239547990 = ((mRcDisplay != null) && (mRcDisplay.asBinder().equals(rcd.asBinder())));
                {
                    mRcDisplay = null;
                    mArtworkExpectedWidth = ARTWORK_DEFAULT_SIZE;
                    mArtworkExpectedHeight = ARTWORK_DEFAULT_SIZE;
                } 
            } 
        } 
        addTaint(rcd.getTaint());
        
        
            
                
                
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.471 -0400", hash_original_method = "1F39DBEB11686CD36B20A5C71DB4136D", hash_generated_method = "FEDCB31395A7CFAC285F39E5C7BA6BF1")
    private Bitmap scaleBitmapIfTooBig(Bitmap bitmap, int maxWidth, int maxHeight) {
        Bitmap varB4EAC82CA7396A68D541C85D26508E83_1051126309 = null; 
        {
            final int width = bitmap.getWidth();
            final int height = bitmap.getHeight();
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
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1051126309 = bitmap;
        addTaint(bitmap.getTaint());
        addTaint(maxWidth);
        addTaint(maxHeight);
        varB4EAC82CA7396A68D541C85D26508E83_1051126309.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1051126309;
        
        
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.471 -0400", hash_original_field = "922AE1910D97CE6259E18622EBD56704", hash_generated_field = "B4345E59801D3DC5F4E85DD85D29A43C")

        protected boolean mMetadataChanged;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.471 -0400", hash_original_field = "DC644474377EA8495CFBC89F2C980831", hash_generated_field = "ECD34150F8B85611F271E6014D9D883D")

        protected boolean mArtworkChanged;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.471 -0400", hash_original_field = "591A25AD459249A62BE2F0EE6B48AA51", hash_generated_field = "0EF4A2673652F896972F4DB3B96FB334")

        protected Bitmap mEditorArtwork;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.471 -0400", hash_original_field = "A466346EB11B259E8F4D68E126970EF9", hash_generated_field = "85DB44FBC7E40E567386653DF585C1CB")

        protected Bundle mEditorMetadata;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.471 -0400", hash_original_field = "B9EF4436306782A025291D9D01DEA3F7", hash_generated_field = "FDEB24494AE0377307265E3205B5F5A1")

        private boolean mApplied = false;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.471 -0400", hash_original_method = "35489133548A4653F80D8552B0E58378", hash_generated_method = "8F0077210051A860529F5C8FE4CA59F4")
        private  MetadataEditor() {
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.472 -0400", hash_original_method = "3FF219DE1407B1650498BA4CB70E771E", hash_generated_method = "8733CE8F5E836126EF8C3D827D0AABA1")
        public Object clone() throws CloneNotSupportedException {
            throw new CloneNotSupportedException();
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.473 -0400", hash_original_method = "DC698BF42DF290A93E2069AFDF9D8834", hash_generated_method = "8E391AA17C5C0BA5620E040E71E8C6AB")
        public synchronized MetadataEditor putString(int key, String value) throws IllegalArgumentException {
            MetadataEditor varB4EAC82CA7396A68D541C85D26508E83_1480586121 = null; 
            MetadataEditor varB4EAC82CA7396A68D541C85D26508E83_664648212 = null; 
            {
                varB4EAC82CA7396A68D541C85D26508E83_1480586121 = this;
            } 
            {
                boolean var64500EB793605B810FA43CE9C224FC07_1547236436 = (!validTypeForKey(key, METADATA_KEYS_TYPE_STRING));
                {
                    if (DroidSafeAndroidRuntime.control) throw(new IllegalArgumentException("Invalid type 'String' for key "+ key));
                } 
            } 
            mEditorMetadata.putString(String.valueOf(key), value);
            mMetadataChanged = true;
            varB4EAC82CA7396A68D541C85D26508E83_664648212 = this;
            addTaint(key);
            addTaint(value.getTaint());
            MetadataEditor varA7E53CE21691AB073D9660D615818899_337347598; 
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: 
                    varA7E53CE21691AB073D9660D615818899_337347598 = varB4EAC82CA7396A68D541C85D26508E83_1480586121;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_337347598 = varB4EAC82CA7396A68D541C85D26508E83_664648212;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_337347598.addTaint(getTaint()); 
            return varA7E53CE21691AB073D9660D615818899_337347598;
            
            
                
                
            
            
                
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.475 -0400", hash_original_method = "59EE363FF7F9B37AD6A675925DC53A2A", hash_generated_method = "C70E6AFDD60861123BCDB0E9472B5D46")
        public synchronized MetadataEditor putLong(int key, long value) throws IllegalArgumentException {
            MetadataEditor varB4EAC82CA7396A68D541C85D26508E83_1729238429 = null; 
            MetadataEditor varB4EAC82CA7396A68D541C85D26508E83_243880146 = null; 
            {
                varB4EAC82CA7396A68D541C85D26508E83_1729238429 = this;
            } 
            {
                boolean var562764A371AF1324C2F3645CE22F9C0E_267015382 = (!validTypeForKey(key, METADATA_KEYS_TYPE_LONG));
                {
                    if (DroidSafeAndroidRuntime.control) throw(new IllegalArgumentException("Invalid type 'long' for key "+ key));
                } 
            } 
            mEditorMetadata.putLong(String.valueOf(key), value);
            mMetadataChanged = true;
            varB4EAC82CA7396A68D541C85D26508E83_243880146 = this;
            addTaint(key);
            addTaint(value);
            MetadataEditor varA7E53CE21691AB073D9660D615818899_592650340; 
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: 
                    varA7E53CE21691AB073D9660D615818899_592650340 = varB4EAC82CA7396A68D541C85D26508E83_1729238429;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_592650340 = varB4EAC82CA7396A68D541C85D26508E83_243880146;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_592650340.addTaint(getTaint()); 
            return varA7E53CE21691AB073D9660D615818899_592650340;
            
            
                
                
            
            
                
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.476 -0400", hash_original_method = "392D9C0804150D161643AF9A81D31BAB", hash_generated_method = "6D0A110AE4AAAE01996393BB747F65B5")
        public synchronized MetadataEditor putBitmap(int key, Bitmap bitmap) throws IllegalArgumentException {
            MetadataEditor varB4EAC82CA7396A68D541C85D26508E83_870756131 = null; 
            MetadataEditor varB4EAC82CA7396A68D541C85D26508E83_1912371455 = null; 
            {
                varB4EAC82CA7396A68D541C85D26508E83_870756131 = this;
            } 
            {
                if (DroidSafeAndroidRuntime.control) throw(new IllegalArgumentException("Invalid type 'Bitmap' for key "+ key));
            } 
            {
                mEditorArtwork = scaleBitmapIfTooBig(bitmap,
                        mArtworkExpectedWidth, mArtworkExpectedHeight);
            } 
            {
                mEditorArtwork = bitmap;
            } 
            mArtworkChanged = true;
            varB4EAC82CA7396A68D541C85D26508E83_1912371455 = this;
            addTaint(key);
            MetadataEditor varA7E53CE21691AB073D9660D615818899_866983560; 
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: 
                    varA7E53CE21691AB073D9660D615818899_866983560 = varB4EAC82CA7396A68D541C85D26508E83_870756131;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_866983560 = varB4EAC82CA7396A68D541C85D26508E83_1912371455;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_866983560.addTaint(getTaint()); 
            return varA7E53CE21691AB073D9660D615818899_866983560;
            
            
                
                
            
            
                
            
            
                
                        
            
                
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.477 -0400", hash_original_method = "0A0B775C77CB462F6342E4F76031A7F3", hash_generated_method = "91F3D1833D8795D6C35D8690287F3DE0")
        public synchronized void clear() {
            mEditorMetadata.clear();
            mEditorArtwork = null;
            
            
                
                
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.478 -0400", hash_original_method = "93FD8866501AA3B03BDE4E693768AF3B", hash_generated_method = "0387E1D2B65E40275AD39D01257A45E4")
        public synchronized void apply() {
            {
                mMetadata = new Bundle(mEditorMetadata);
                {
                    boolean var6413C1F0A31650058FD58DD0250B281A_1039695166 = ((mArtwork != null) && (!mArtwork.equals(mEditorArtwork)));
                    {
                        mArtwork.recycle();
                    } 
                } 
                mArtwork = mEditorArtwork;
                mEditorArtwork = null;
                {
                    sendMetadataWithArtwork_syncCacheLock();
                } 
                {
                    sendMetadata_syncCacheLock();
                } 
                {
                    sendArtwork_syncCacheLock();
                } 
                mApplied = true;
            } 
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.478 -0400", hash_original_field = "3FB4191C765633E0F8B806B7A99FAEEC", hash_generated_field = "483347541B59F8DFA8B12B3C1A84C12D")

        public final static int BITMAP_KEY_ARTWORK = 100;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.478 -0400", hash_original_field = "272507BE4AC597CE2F9EF960ED378355", hash_generated_field = "B8846CA5BE8D5CB94BBEF3C2B4B1EC50")

        public final static int METADATA_KEY_ARTWORK = BITMAP_KEY_ARTWORK;
    }


    
    private class EventHandler extends Handler {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.478 -0400", hash_original_method = "E835DA7FA2605C7661321C420AF4C36C", hash_generated_method = "686B730614436C059D698B2373FF7E42")
        public  EventHandler(RemoteControlClient rcc, Looper looper) {
            super(looper);
            addTaint(rcc.getTaint());
            addTaint(looper.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.479 -0400", hash_original_method = "7971FD8B56BD97CBBF08B4EAB35A2033", hash_generated_method = "078E7843CBFF8C22ECFC6B22CA7A4CE9")
        @Override
        public void handleMessage(Message msg) {
            
            {
                sendPlaybackState_syncCacheLock();
            } 
            
            
            {
                sendMetadata_syncCacheLock();
            } 
            
            
            {
                sendTransportControlFlags_syncCacheLock();
            } 
            
            
            {
                sendArtwork_syncCacheLock();
            } 
            
            
            onNewInternalClientGen((Integer)msg.obj, msg.arg1, msg.arg2);
            
            
            onNewCurrentClientGen(msg.arg1);
            
            
            onPlugDisplay((IRemoteControlDisplay)msg.obj);
            
            
            onUnplugDisplay((IRemoteControlDisplay)msg.obj);
            
            addTaint(msg.getTaint());
            
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.479 -0400", hash_original_field = "681829CC43857D7BDD496D82309A510B", hash_generated_field = "2BE2B9C77FA549F039F405BEB17D9487")

    private final static String TAG = "RemoteControlClient";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.479 -0400", hash_original_field = "5E0127EB9BF7A14512771B2677F027DD", hash_generated_field = "F4D3F848A6E915802E08F3A2E5F1F53B")

    public final static int PLAYSTATE_STOPPED            = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.479 -0400", hash_original_field = "621168741A25DDF3B86B889A9C3FF411", hash_generated_field = "B88C1E8F7B840BB920E884E441877169")

    public final static int PLAYSTATE_PAUSED             = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.479 -0400", hash_original_field = "C6881F6FB78551DFB2511794BBB7FB22", hash_generated_field = "88F962CE51D407CF120388E614DE441E")

    public final static int PLAYSTATE_PLAYING            = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.479 -0400", hash_original_field = "153E0DF6D2E1F8A5AAE67359A666190C", hash_generated_field = "3BE856E2C7FB5313A81FB5745940F465")

    public final static int PLAYSTATE_FAST_FORWARDING    = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.479 -0400", hash_original_field = "D748EC1812D4B9F7D3397B5A882DE85E", hash_generated_field = "DF462EA5CD01B99AD41758C41F4F8E63")

    public final static int PLAYSTATE_REWINDING          = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.479 -0400", hash_original_field = "214B701550DDC8A0EBBF9A388A5F7C2D", hash_generated_field = "35E136D27B02C2075FEAF30610947F93")

    public final static int PLAYSTATE_SKIPPING_FORWARDS  = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.479 -0400", hash_original_field = "033F1B827C945D57AC7CCA8EA3E27B62", hash_generated_field = "66CB7FA527A0829DAAFBA60CE93D1385")

    public final static int PLAYSTATE_SKIPPING_BACKWARDS = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.479 -0400", hash_original_field = "ED9C8E57D9B012079EF5E3C6E6F1E201", hash_generated_field = "CF7819B197FB94121B302B9141F6961C")

    public final static int PLAYSTATE_BUFFERING          = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.479 -0400", hash_original_field = "7B83D065C28AE0B614BC1796DC508604", hash_generated_field = "6CAACC1CF95FAD80651991CB4C906A4D")

    public final static int PLAYSTATE_ERROR              = 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.479 -0400", hash_original_field = "36CEEF9DDA4C3D06DDE4F822EB620475", hash_generated_field = "61319DA85C97420F017C045A9C1729C8")

    public final static int PLAYSTATE_NONE               = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.479 -0400", hash_original_field = "8D0CB88A9669F720A6E7F1DB58C0426E", hash_generated_field = "D9C2B7C797239CFADF59DF6E95F1B111")

    public final static int FLAG_KEY_MEDIA_PREVIOUS = 1 << 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.479 -0400", hash_original_field = "C5A69C0DBDB0E6DC2A73F6E5910E8085", hash_generated_field = "E60961DC3DFBE2A350F7E65CD95479FA")

    public final static int FLAG_KEY_MEDIA_REWIND = 1 << 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.479 -0400", hash_original_field = "68C8D3519A301059C4C3985972B92B4C", hash_generated_field = "C4AADE8FFD83074B2941C8BB305E5194")

    public final static int FLAG_KEY_MEDIA_PLAY = 1 << 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.479 -0400", hash_original_field = "0D1333C0CA3DADD45D56CA57848D0CA8", hash_generated_field = "A50B60387E829EE960A6C24801483960")

    public final static int FLAG_KEY_MEDIA_PLAY_PAUSE = 1 << 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.479 -0400", hash_original_field = "86E621275F2541D2980E411D334BBC56", hash_generated_field = "3037539F2A50CCC54FEF961DB8032CE3")

    public final static int FLAG_KEY_MEDIA_PAUSE = 1 << 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.479 -0400", hash_original_field = "6BCE4D5FF832233773CF7561E86943E3", hash_generated_field = "EB951276E4926A00C8B2D0185D744968")

    public final static int FLAG_KEY_MEDIA_STOP = 1 << 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.479 -0400", hash_original_field = "99660D6F0073B6B1E283E333D89D03EF", hash_generated_field = "727BB4258CAB824CD82070CC756209D0")

    public final static int FLAG_KEY_MEDIA_FAST_FORWARD = 1 << 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.479 -0400", hash_original_field = "9992329CD1297736A27A70FDA9A8044B", hash_generated_field = "AA28402D84BB64B0BBA8663A9933668C")

    public final static int FLAG_KEY_MEDIA_NEXT = 1 << 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.479 -0400", hash_original_field = "6831E878380D68BB6DC2E8DCF8CF0B94", hash_generated_field = "69F8ECB2680C2648C44FFD84EC8F50D3")

    public final static int FLAGS_KEY_MEDIA_NONE = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.479 -0400", hash_original_field = "81B41881744B60F3420A2E698C18B318", hash_generated_field = "9E8AFBDC008F82D3058F352782A0E928")

    public final static int FLAG_INFORMATION_REQUEST_METADATA = 1 << 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.479 -0400", hash_original_field = "E5126BD55CB1C20E9D217C1E06D01370", hash_generated_field = "78AAB419BAA72EC0F3DF7F385ECF46E0")

    public final static int FLAG_INFORMATION_REQUEST_KEY_MEDIA = 1 << 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.479 -0400", hash_original_field = "1036EBA05FF4968278AFFDC3E39A1CA1", hash_generated_field = "3B5B3AE1258E6EDAA51221A3AED72F72")

    public final static int FLAG_INFORMATION_REQUEST_PLAYSTATE = 1 << 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.479 -0400", hash_original_field = "658BA1663FD3990D54FAF0DCE735DFA7", hash_generated_field = "28B78930FAA93C3B508BFC7444D9B284")

    public final static int FLAG_INFORMATION_REQUEST_ALBUM_ART = 1 << 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.479 -0400", hash_original_field = "D9CC95D3F23025733638EDC27E3CF919", hash_generated_field = "0FD52E847D577969F790EF01F30CA0E3")

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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.479 -0400", hash_original_field = "28060E061B4D52D0125A33FF330B3083", hash_generated_field = "C58FCF18F5F9EC50B35A59C6AC7F2853")

    private static final int[] METADATA_KEYS_TYPE_LONG = {
        MediaMetadataRetriever.METADATA_KEY_CD_TRACK_NUMBER,
        MediaMetadataRetriever.METADATA_KEY_DISC_NUMBER,
        MediaMetadataRetriever.METADATA_KEY_DURATION };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.479 -0400", hash_original_field = "926031DD4A7EAD81A49C52CDFD916BCD", hash_generated_field = "AACFB6D022148421C2F0C7D1E8331E7D")

    private final static int MSG_REQUEST_PLAYBACK_STATE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.479 -0400", hash_original_field = "0FC40B07A6FE09600D86D821AA51165B", hash_generated_field = "04F84EAB3F4DEDCC1CA54ADDFD303582")

    private final static int MSG_REQUEST_METADATA = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.480 -0400", hash_original_field = "E29DF1B33CEAC31DA3E993269C1E7BE6", hash_generated_field = "D37436C8088C6C0DD8728AB37ADE0846")

    private final static int MSG_REQUEST_TRANSPORTCONTROL = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.480 -0400", hash_original_field = "2A2FDA74B0DD75E7B48B517AC71A215A", hash_generated_field = "8B1638BE5F1799455DA931602163CF68")

    private final static int MSG_REQUEST_ARTWORK = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.480 -0400", hash_original_field = "046B9727A90AEA92C2850DF25EBBF61B", hash_generated_field = "92F3229CC0658FD8B22E0EDEA145897F")

    private final static int MSG_NEW_INTERNAL_CLIENT_GEN = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.480 -0400", hash_original_field = "528F89878835FD3BB0C0C86F78D4309A", hash_generated_field = "29900B94B2A6D2360A16D8FD28735F4E")

    private final static int MSG_NEW_CURRENT_CLIENT_GEN = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.480 -0400", hash_original_field = "9C9BA0FDCB520492ED3B1309161B6DC5", hash_generated_field = "E8EBAAC9849DE665CC38834147B90E01")

    private final static int MSG_PLUG_DISPLAY = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.480 -0400", hash_original_field = "374E0D01E8E7E8ED123E4CEBC1314CD4", hash_generated_field = "9A2D676D79FDA0EEDBD63F1D0F038755")

    private final static int MSG_UNPLUG_DISPLAY = 8;
}

