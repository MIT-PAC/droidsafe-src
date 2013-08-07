package com.android.internal.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.SystemClock;
import android.text.style.ForegroundColorSpan;
import com.android.internal.R;
import android.content.ComponentName;
import android.os.Parcelable;
import android.app.PendingIntent;
import android.util.Log;
import android.media.AudioManager;
import android.os.Message;
import android.view.View;
import android.media.RemoteControlClient;
import android.media.MediaMetadataRetriever;
import com.android.internal.widget.LockScreenWidgetInterface;
import android.os.RemoteException;
import android.graphics.Bitmap;
import android.widget.FrameLayout;
import android.content.Intent;
import android.view.KeyEvent;
import android.os.Parcel;
import android.media.IRemoteControlDisplay;
import android.widget.ImageView;
import android.os.Handler;
import com.android.internal.widget.LockScreenWidgetCallback;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.os.Bundle;
import android.text.TextUtils;
import java.lang.ref.WeakReference;
import android.content.Context;
import android.app.PendingIntent.CanceledException;
import android.util.AttributeSet;
import android.text.Spannable;
public class TransportControlView extends FrameLayout implements OnClickListener, LockScreenWidgetInterface {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.542 -0400", hash_original_field = "E115B101A6FBD5F4A6E3A8B7CF03DDCD", hash_generated_field = "DA87E50DBE1C969BAD575EB495CD27D7")

    private ImageView mAlbumArt;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.542 -0400", hash_original_field = "9A94BC078A38FE6C14A0698A26961497", hash_generated_field = "80D50A0B799DDBF9D29E0B56DE151399")

    private TextView mTrackTitle;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.542 -0400", hash_original_field = "5DF2BF0D403AD05DC5B28C01CFD652FF", hash_generated_field = "4CB626F56B1DADAF413500543C751C45")

    private ImageView mBtnPrev;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.543 -0400", hash_original_field = "112BE3FEDD14BA781BCE7BA93FACEC6C", hash_generated_field = "AE01356945E898348C13E9DF62B56549")

    private ImageView mBtnPlay;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.543 -0400", hash_original_field = "B3B30E1A9681AD5245C565C071A9CB01", hash_generated_field = "A71AC8FB251157D8FCED4EB83F064C41")

    private ImageView mBtnNext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.543 -0400", hash_original_field = "5BCC5B85E1C26B4D215DAD4278DF54B1", hash_generated_field = "2C7CAEEC046DE8DB50C50D03DBFC1BE7")

    private int mClientGeneration;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.543 -0400", hash_original_field = "A12A0179E1D2629648052FB49E36EBD9", hash_generated_field = "65100244E81854882C1FF0A6C18D7262")

    private Metadata mMetadata = new Metadata();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.544 -0400", hash_original_field = "5FA0F8F73D793EE9F68BC9250D57B472", hash_generated_field = "1232E3D42FB259E0D63C7FE3AEEB5801")

    private boolean mAttached;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.544 -0400", hash_original_field = "5AF09E32438320E799DEA21641868024", hash_generated_field = "8B3968EAB9AC7349199744E51F542F29")

    private PendingIntent mClientIntent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.544 -0400", hash_original_field = "4DE676EDC2E8F523588AAF737F8C078E", hash_generated_field = "1D3D95706B41E3260DB8C4989FF28B65")

    private int mTransportControlFlags;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.544 -0400", hash_original_field = "F262E88019C62DDAB1F0FC77BD06649F", hash_generated_field = "89AEFACC5B9AD72E7FF5B2EB6A28B6CD")

    private int mCurrentPlayState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.544 -0400", hash_original_field = "DC563AE6C758BE979A84432D84FFAC40", hash_generated_field = "B52B11818937F27E927A20CDEBA27654")

    private AudioManager mAudioManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.544 -0400", hash_original_field = "4A75530491F318D4DF99FD90D3973720", hash_generated_field = "30F3490F1EC2103DA9A48FE26967897C")

    private LockScreenWidgetCallback mWidgetCallbacks;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.544 -0400", hash_original_field = "3F7272E06A7960C22A3ADC557CD1977E", hash_generated_field = "7BA1ADFD9BAA71692C2D7493295C5443")

    private IRemoteControlDisplayWeak mIRCD;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.545 -0400", hash_original_field = "FE14BF2EC96A49F36DB9F889DFBF0BD8", hash_generated_field = "174680FA3EC503AA14E1F9C0FD709876")

    private Bundle mPopulateMetadataWhenAttached = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.546 -0400", hash_original_field = "0439B6CCC82E2E7E5830268CBB656750", hash_generated_field = "78A217002A9CB7EB984A54BDEA02B4D9")

    private Handler mHandler = new Handler()    {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.546 -0400", hash_original_method = "B4068560F86DB4E176F8BE6BCDAB55F4", hash_generated_method = "169935E6DEAB26B5EBF965A4FDF83F8C")
        @Override
        public void handleMessage(Message msg) {
            addTaint(msg.getTaint());
            switch(msg.what){
            case MSG_UPDATE_STATE:
            if(mClientGeneration==msg.arg1)            
updatePlayPauseState(msg.arg2)
            break;
            case MSG_SET_METADATA:
            if(mClientGeneration==msg.arg1)            
updateMetadata((Bundle) msg.obj)
            break;
            case MSG_SET_TRANSPORT_CONTROLS:
            if(mClientGeneration==msg.arg1)            
updateTransportControls(msg.arg2)
            break;
            case MSG_SET_ARTWORK:
            if(mClientGeneration==msg.arg1)            
            {
                if(mMetadata.bitmap!=null)                
                {
mMetadata.bitmap.recycle()
                } //End block
mMetadata.bitmap=(Bitmap) msg.objmAlbumArt.setImageBitmap(mMetadata.bitmap)
            } //End block
            break;
            case MSG_SET_GENERATION_ID:
            if(msg.arg2!=0)            
            {
                if(mWidgetCallbacks!=null)                
                {
mWidgetCallbacks.requestHide(TransportControlView.this)
                } //End block
            } //End block
            if(DEBUG){ }mClientGeneration=msg.arg1mClientIntent=(PendingIntent) msg.obj            break;
}
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }
;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.547 -0400", hash_original_method = "28088DA89CD1F0C759CEF9B76CD31163", hash_generated_method = "67DBA930CCE9D2927631F693DC766122")
    public  TransportControlView(Context context, AttributeSet attrs) {
        super(context, attrs);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
mAudioManager=new AudioManager(mContext)mCurrentPlayState=RemoteControlClient.PLAYSTATE_NONEmIRCD=new IRemoteControlDisplayWeak(mHandler)
        // ---------- Original Method ----------
        //Log.v(TAG, "Create TCV " + this);
        //mAudioManager = new AudioManager(mContext);
        //mCurrentPlayState = RemoteControlClient.PLAYSTATE_NONE;
        //mIRCD = new IRemoteControlDisplayWeak(mHandler);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.547 -0400", hash_original_method = "E3EA28B541F60175F493BCCF9E6E6B00", hash_generated_method = "AC3102E1001EC274C6DF9147F01D5728")
    private void updateTransportControls(int transportControlFlags) {
        addTaint(transportControlFlags);
mTransportControlFlags=transportControlFlags
        // ---------- Original Method ----------
        //mTransportControlFlags = transportControlFlags;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.548 -0400", hash_original_method = "E17A832565C9CA35540F1D64DBE8B3CB", hash_generated_method = "7022ADAA2BE0282D90DF91FA19FC5EB8")
    @Override
    public void onFinishInflate() {
        //DSFIXME:  CODE0009: Possible callback target function detected
super.onFinishInflate()mTrackTitle=(TextView) findViewById(R.id.title)mTrackTitle.setSelected(true)mAlbumArt=(ImageView) findViewById(R.id.albumart)mBtnPrev=(ImageView) findViewById(R.id.btn_prev)mBtnPlay=(ImageView) findViewById(R.id.btn_play)mBtnNext=(ImageView) findViewById(R.id.btn_next)        final View buttons[] = { mBtnPrev, mBtnPlay, mBtnNext };
for(View view : buttons)
        {
view.setOnClickListener(this)
        } //End block
        // ---------- Original Method ----------
        //super.onFinishInflate();
        //mTrackTitle = (TextView) findViewById(R.id.title);
        //mTrackTitle.setSelected(true);
        //mAlbumArt = (ImageView) findViewById(R.id.albumart);
        //mBtnPrev = (ImageView) findViewById(R.id.btn_prev);
        //mBtnPlay = (ImageView) findViewById(R.id.btn_play);
        //mBtnNext = (ImageView) findViewById(R.id.btn_next);
        //final View buttons[] = { mBtnPrev, mBtnPlay, mBtnNext };
        //for (View view : buttons) {
            //view.setOnClickListener(this);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.549 -0400", hash_original_method = "9A47502A2F9BB2AF786B961CB0BF7131", hash_generated_method = "E8B212CD2D10117BC2B4F561AB50B357")
    @Override
    public void onAttachedToWindow() {
        //DSFIXME:  CODE0009: Possible callback target function detected
super.onAttachedToWindow()        if(mPopulateMetadataWhenAttached!=null)        
        {
updateMetadata(mPopulateMetadataWhenAttached)mPopulateMetadataWhenAttached=null
        } //End block
        if(!mAttached)        
        {
            if(DEBUG){ }mAudioManager.registerRemoteControlDisplay(mIRCD)
        } //End block
mAttached=true
        // ---------- Original Method ----------
        //super.onAttachedToWindow();
        //if (mPopulateMetadataWhenAttached != null) {
            //updateMetadata(mPopulateMetadataWhenAttached);
            //mPopulateMetadataWhenAttached = null;
        //}
        //if (!mAttached) {
            //if (DEBUG) Log.v(TAG, "Registering TCV " + this);
            //mAudioManager.registerRemoteControlDisplay(mIRCD);
        //}
        //mAttached = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.549 -0400", hash_original_method = "22F4C979BB2C31E58D19E52DCD5B60DA", hash_generated_method = "3D0D8B8149682534170D4986141AFF03")
    @Override
    public void onDetachedFromWindow() {
        //DSFIXME:  CODE0009: Possible callback target function detected
super.onDetachedFromWindow()        if(mAttached)        
        {
            if(DEBUG){ }mAudioManager.unregisterRemoteControlDisplay(mIRCD)
        } //End block
mAttached=false
        // ---------- Original Method ----------
        //super.onDetachedFromWindow();
        //if (mAttached) {
            //if (DEBUG) Log.v(TAG, "Unregistering TCV " + this);
            //mAudioManager.unregisterRemoteControlDisplay(mIRCD);
        //}
        //mAttached = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.550 -0400", hash_original_method = "6E889933E54B1CA41167DF630373A787", hash_generated_method = "4CC64DA2FDDF7DBD9015CF9B2ABE0020")
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(heightMeasureSpec);
        addTaint(widthMeasureSpec);
super.onMeasure(widthMeasureSpec, heightMeasureSpec)        int dim = Math.min(MAXDIM, Math.max(getWidth(), getHeight()));
        // ---------- Original Method ----------
        //super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //int dim = Math.min(MAXDIM, Math.max(getWidth(), getHeight()));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.551 -0400", hash_original_method = "5EC8C503F440C2B8F585F82F219EB23A", hash_generated_method = "E38AF5615818A5F3ABCB5A62EB1E785E")
    private String getMdString(Bundle data, int id) {
        addTaint(id);
        addTaint(data.getTaint());
String var57F9E661D1675992F9A668B806A8478E_759798132 = data.getString(Integer.toString(id))        var57F9E661D1675992F9A668B806A8478E_759798132.addTaint(taint);
        return var57F9E661D1675992F9A668B806A8478E_759798132;
        // ---------- Original Method ----------
        //return data.getString(Integer.toString(id));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.551 -0400", hash_original_method = "671BCA2847139E170128F59BF068F4A7", hash_generated_method = "18601E539D2B8D7C7ADC6D087BDBF291")
    private void updateMetadata(Bundle data) {
        addTaint(data.getTaint());
        if(mAttached)        
        {
mMetadata.artist=getMdString(data, MediaMetadataRetriever.METADATA_KEY_ALBUMARTIST)mMetadata.trackTitle=getMdString(data, MediaMetadataRetriever.METADATA_KEY_TITLE)mMetadata.albumTitle=getMdString(data, MediaMetadataRetriever.METADATA_KEY_ALBUM)populateMetadata()
        } //End block
        else
        {
mPopulateMetadataWhenAttached=data
        } //End block
        // ---------- Original Method ----------
        //if (mAttached) {
            //mMetadata.artist = getMdString(data, MediaMetadataRetriever.METADATA_KEY_ALBUMARTIST);
            //mMetadata.trackTitle = getMdString(data, MediaMetadataRetriever.METADATA_KEY_TITLE);
            //mMetadata.albumTitle = getMdString(data, MediaMetadataRetriever.METADATA_KEY_ALBUM);
            //populateMetadata();
        //} else {
            //mPopulateMetadataWhenAttached = data;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.552 -0400", hash_original_method = "880DB323EB1003367CBD6D4268C95C6D", hash_generated_method = "43C64B218D86594D99765C4EC730D020")
    private void populateMetadata() {
        StringBuilder sb = new StringBuilder();
        int trackTitleLength = 0;
        if(!TextUtils.isEmpty(mMetadata.trackTitle))        
        {
sb.append(mMetadata.trackTitle)trackTitleLength=mMetadata.trackTitle.length()
        } //End block
        if(!TextUtils.isEmpty(mMetadata.artist))        
        {
            if(sb.length()!=0)            
            {
sb.append(" - ")
            } //End block
sb.append(mMetadata.artist)
        } //End block
        if(!TextUtils.isEmpty(mMetadata.albumTitle))        
        {
            if(sb.length()!=0)            
            {
sb.append(" - ")
            } //End block
sb.append(mMetadata.albumTitle)
        } //End block
mTrackTitle.setText(sb.toString(), TextView.BufferType.SPANNABLE)        Spannable str = (Spannable) mTrackTitle.getText();
        if(trackTitleLength!=0)        
        {
str.setSpan(new ForegroundColorSpan(0xffffffff), 0, trackTitleLength, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)trackTitleLength
        } //End block
        if(sb.length()>trackTitleLength)        
        {
str.setSpan(new ForegroundColorSpan(0x7fffffff), trackTitleLength, sb.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        } //End block
mAlbumArt.setImageBitmap(mMetadata.bitmap)        final int flags = mTransportControlFlags;
setVisibilityBasedOnFlag(mBtnPrev, flags, RemoteControlClient.FLAG_KEY_MEDIA_PREVIOUS)setVisibilityBasedOnFlag(mBtnNext, flags, RemoteControlClient.FLAG_KEY_MEDIA_NEXT)setVisibilityBasedOnFlag(mBtnPrev, flags, RemoteControlClient.FLAG_KEY_MEDIA_PLAY|RemoteControlClient.FLAG_KEY_MEDIA_PAUSE|RemoteControlClient.FLAG_KEY_MEDIA_PLAY_PAUSE|RemoteControlClient.FLAG_KEY_MEDIA_STOP)updatePlayPauseState(mCurrentPlayState)
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        private static void setVisibilityBasedOnFlag(View view, int flags, int flag) {
        if ((flags & flag) != 0) {
            view.setVisibility(View.VISIBLE);
        } else {
            view.setVisibility(View.GONE);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.554 -0400", hash_original_method = "B5E2D534F993E8D98DFB10B1B0D41AF7", hash_generated_method = "B79EA981AC2409BCE7A52F25354C95F6")
    private void updatePlayPauseState(int state) {
        addTaint(state);
        if(DEBUG){ }        if(state==mCurrentPlayState)        
        {
            return;
        } //End block
        int imageResId;
        int imageDescId;
        boolean showIfHidden = false;
        switch(state){
        case RemoteControlClient.PLAYSTATE_ERROR:
imageResId=com.android.internal.R.drawable.stat_sys_warningimageDescId=com.android.internal.R.string.lockscreen_transport_play_description        break;
        case RemoteControlClient.PLAYSTATE_PLAYING:
imageResId=com.android.internal.R.drawable.ic_media_pauseimageDescId=com.android.internal.R.string.lockscreen_transport_pause_descriptionshowIfHidden=true        break;
        case RemoteControlClient.PLAYSTATE_BUFFERING:
imageResId=com.android.internal.R.drawable.ic_media_stopimageDescId=com.android.internal.R.string.lockscreen_transport_stop_descriptionshowIfHidden=true        break;
        case RemoteControlClient.PLAYSTATE_PAUSED:
        default:
imageResId=com.android.internal.R.drawable.ic_media_playimageDescId=com.android.internal.R.string.lockscreen_transport_play_descriptionshowIfHidden=false        break;
}mBtnPlay.setImageResource(imageResId)mBtnPlay.setContentDescription(getResources().getString(imageDescId))        if(showIfHidden&&mWidgetCallbacks!=null&&!mWidgetCallbacks.isVisible(this))        
        {
mWidgetCallbacks.requestShow(this)
        } //End block
mCurrentPlayState=state
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.554 -0400", hash_original_method = "3B14BD4666DD8EB452FEE581A048FD5F", hash_generated_method = "0ECFF9926CA7E4D1AC1B0838EED0EBE6")
    @Override
    public Parcelable onSaveInstanceState() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        if(DEBUG){ }        Parcelable superState = super.onSaveInstanceState();
        SavedState ss = new SavedState(superState);
ss.wasShowing=mWidgetCallbacks!=null&&mWidgetCallbacks.isVisible(this)Parcelable var182E37827114C3F455816E0E29D81D76_312945421 = ss        var182E37827114C3F455816E0E29D81D76_312945421.addTaint(taint);
        return var182E37827114C3F455816E0E29D81D76_312945421;
        // ---------- Original Method ----------
        //if (DEBUG) Log.v(TAG, "onSaveInstanceState()");
        //Parcelable superState = super.onSaveInstanceState();
        //SavedState ss = new SavedState(superState);
        //ss.wasShowing = mWidgetCallbacks != null && mWidgetCallbacks.isVisible(this);
        //return ss;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.555 -0400", hash_original_method = "5E8A2222963B76C27100B85A4E035EFD", hash_generated_method = "0E0AD4D5191E416D52A8DA54805070C1")
    @Override
    public void onRestoreInstanceState(Parcelable state) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(state.getTaint());
        if(DEBUG){ }        if(!(state instanceof SavedState))        
        {
super.onRestoreInstanceState(state)            return;
        } //End block
        SavedState ss = (SavedState) state;
super.onRestoreInstanceState(ss.getSuperState())        if(ss.wasShowing&&mWidgetCallbacks!=null)        
        {
mWidgetCallbacks.requestShow(this)
        } //End block
        // ---------- Original Method ----------
        //if (DEBUG) Log.v(TAG, "onRestoreInstanceState()");
        //if (!(state instanceof SavedState)) {
            //super.onRestoreInstanceState(state);
            //return;
        //}
        //SavedState ss = (SavedState) state;
        //super.onRestoreInstanceState(ss.getSuperState());
        //if (ss.wasShowing && mWidgetCallbacks != null) {
            //mWidgetCallbacks.requestShow(this);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.555 -0400", hash_original_method = "0780831A109BF1303DC7656A563D4910", hash_generated_method = "22FB6EA31479AED91895F31962498B47")
    public void onClick(View v) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(v.getTaint());
        int keyCode = -1;
        if(v==mBtnPrev)        
        {
keyCode=KeyEvent.KEYCODE_MEDIA_PREVIOUS
        } //End block
        else
        if(v==mBtnNext)        
        {
keyCode=KeyEvent.KEYCODE_MEDIA_NEXT
        } //End block
        else
        if(v==mBtnPlay)        
        {
keyCode=KeyEvent.KEYCODE_MEDIA_PLAY_PAUSE
        } //End block
        if(keyCode!=-1)        
        {
sendMediaButtonClick(keyCode)            if(mWidgetCallbacks!=null)            
            {
mWidgetCallbacks.userActivity(this)
            } //End block
        } //End block
        // ---------- Original Method ----------
        //int keyCode = -1;
        //if (v == mBtnPrev) {
            //keyCode = KeyEvent.KEYCODE_MEDIA_PREVIOUS;
        //} else if (v == mBtnNext) {
            //keyCode = KeyEvent.KEYCODE_MEDIA_NEXT;
        //} else if (v == mBtnPlay) {
            //keyCode = KeyEvent.KEYCODE_MEDIA_PLAY_PAUSE;
        //}
        //if (keyCode != -1) {
            //sendMediaButtonClick(keyCode);
            //if (mWidgetCallbacks != null) {
                //mWidgetCallbacks.userActivity(this);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.556 -0400", hash_original_method = "C66AC963BF9A61B1A5E7DE103A63B7D4", hash_generated_method = "4F9D93394FC7D6F1C71C91EED73845A4")
    private void sendMediaButtonClick(int keyCode) {
        addTaint(keyCode);
        if(mClientIntent==null)        
        {
            return;
        } //End block
        KeyEvent keyEvent = new KeyEvent(KeyEvent.ACTION_DOWN, keyCode);
        Intent intent = new Intent(Intent.ACTION_MEDIA_BUTTON);
intent.putExtra(Intent.EXTRA_KEY_EVENT, keyEvent)        try 
        {
mClientIntent.send(getContext(), 0, intent)
        } //End block
        catch (CanceledException e)
        {
e.printStackTrace()
        } //End block
keyEvent=new KeyEvent(KeyEvent.ACTION_UP, keyCode)intent=new Intent(Intent.ACTION_MEDIA_BUTTON)intent.putExtra(Intent.EXTRA_KEY_EVENT, keyEvent)        try 
        {
mClientIntent.send(getContext(), 0, intent)
        } //End block
        catch (CanceledException e)
        {
e.printStackTrace()
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.556 -0400", hash_original_method = "1787BAA6B5DBFF0F60EDC0378CF8A396", hash_generated_method = "D8CB9FDEBDDE15BD62507907F1EEA944")
    public void setCallback(LockScreenWidgetCallback callback) {
        addTaint(callback.getTaint());
mWidgetCallbacks=callback
        // ---------- Original Method ----------
        //mWidgetCallbacks = callback;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.557 -0400", hash_original_method = "F3CEF0CADCB4999187985B579A646B5A", hash_generated_method = "5B6AA5192CEFFAA203236973AA01E95F")
    public boolean providesClock() {
        boolean var68934A3E9455FA72420237EB05902327_563367767 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_662410052 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_662410052;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.558 -0400", hash_original_method = "8BFF2A2DDA90CBC5C00A86EF7761C0D0", hash_generated_method = "816BCD58F62C53ACD6FA96040101F102")
    private boolean wasPlayingRecently(int state, long stateChangeTimeMs) {
        addTaint(stateChangeTimeMs);
        addTaint(state);
        switch(state){
        case RemoteControlClient.PLAYSTATE_PLAYING:
        case RemoteControlClient.PLAYSTATE_FAST_FORWARDING:
        case RemoteControlClient.PLAYSTATE_REWINDING:
        case RemoteControlClient.PLAYSTATE_SKIPPING_FORWARDS:
        case RemoteControlClient.PLAYSTATE_SKIPPING_BACKWARDS:
        case RemoteControlClient.PLAYSTATE_BUFFERING:
        boolean varB326B5062B2F0E69046810717534CB09_316647362 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1828354580 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1828354580;
        case RemoteControlClient.PLAYSTATE_NONE:
        boolean var68934A3E9455FA72420237EB05902327_1297050628 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_587864899 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_587864899;
        case RemoteControlClient.PLAYSTATE_STOPPED:
        case RemoteControlClient.PLAYSTATE_PAUSED:
        case RemoteControlClient.PLAYSTATE_ERROR:
        if(DEBUG)        
        {
            if((SystemClock.elapsedRealtime()-stateChangeTimeMs)<DISPLAY_TIMEOUT_MS)            
            {
            } //End block
            else
            {
            } //End block
        } //End block
        boolean var5784060C06F8E800E94727920402B6A8_1297747548 = (((SystemClock.elapsedRealtime()-stateChangeTimeMs)<DISPLAY_TIMEOUT_MS));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_812036211 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_812036211;
        default:
        boolean var68934A3E9455FA72420237EB05902327_613070939 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2041511263 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2041511263;
}
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    private static class IRemoteControlDisplayWeak extends IRemoteControlDisplay.Stub {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.558 -0400", hash_original_field = "5F18D73E77326B77FC14F8FE4E65B046", hash_generated_field = "AE616DDFD4A5F176B3591808704AC669")

        private WeakReference<Handler> mLocalHandler;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.559 -0400", hash_original_method = "81B0AB303ECE5AB07B847292EB48884D", hash_generated_method = "0F99FABD34E374B275E64003AEED507F")
          IRemoteControlDisplayWeak(Handler handler) {
            addTaint(handler.getTaint());
mLocalHandler=new WeakReference<Handler>(handler)
            // ---------- Original Method ----------
            //mLocalHandler = new WeakReference<Handler>(handler);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.560 -0400", hash_original_method = "4BF7FDAED1D00C2F1AE1265450920EFA", hash_generated_method = "0312E30509A2BD3F3081695000A61E9B")
        public void setPlaybackState(int generationId, int state, long stateChangeTimeMs) {
            addTaint(stateChangeTimeMs);
            addTaint(state);
            addTaint(generationId);
            Handler handler = mLocalHandler.get();
            if(handler!=null)            
            {
handler.obtainMessage(MSG_UPDATE_STATE, generationId, state).sendToTarget()
            } //End block
            // ---------- Original Method ----------
            //Handler handler = mLocalHandler.get();
            //if (handler != null) {
                //handler.obtainMessage(MSG_UPDATE_STATE, generationId, state).sendToTarget();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.560 -0400", hash_original_method = "A0B1E0704C5DEB7A329091E0519CB0DC", hash_generated_method = "EBC156E7A8FF1EF75BB740ECBBAAA4A9")
        public void setMetadata(int generationId, Bundle metadata) {
            addTaint(metadata.getTaint());
            addTaint(generationId);
            Handler handler = mLocalHandler.get();
            if(handler!=null)            
            {
handler.obtainMessage(MSG_SET_METADATA, generationId, 0, metadata).sendToTarget()
            } //End block
            // ---------- Original Method ----------
            //Handler handler = mLocalHandler.get();
            //if (handler != null) {
                //handler.obtainMessage(MSG_SET_METADATA, generationId, 0, metadata).sendToTarget();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.561 -0400", hash_original_method = "7CEFF800367E2828CD3448E45520924F", hash_generated_method = "473A56192931E794A2FDC97BD614C3A1")
        public void setTransportControlFlags(int generationId, int flags) {
            addTaint(flags);
            addTaint(generationId);
            Handler handler = mLocalHandler.get();
            if(handler!=null)            
            {
handler.obtainMessage(MSG_SET_TRANSPORT_CONTROLS, generationId, flags).sendToTarget()
            } //End block
            // ---------- Original Method ----------
            //Handler handler = mLocalHandler.get();
            //if (handler != null) {
                //handler.obtainMessage(MSG_SET_TRANSPORT_CONTROLS, generationId, flags)
                        //.sendToTarget();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.568 -0400", hash_original_method = "94B440C751D4FAF8BA93B0C7F244F234", hash_generated_method = "1D396149C5BDE5FB6CE4BB44D0833F24")
        public void setArtwork(int generationId, Bitmap bitmap) {
            addTaint(bitmap.getTaint());
            addTaint(generationId);
            Handler handler = mLocalHandler.get();
            if(handler!=null)            
            {
handler.obtainMessage(MSG_SET_ARTWORK, generationId, 0, bitmap).sendToTarget()
            } //End block
            // ---------- Original Method ----------
            //Handler handler = mLocalHandler.get();
            //if (handler != null) {
                //handler.obtainMessage(MSG_SET_ARTWORK, generationId, 0, bitmap).sendToTarget();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.570 -0400", hash_original_method = "29058F7148C25A18D99AF4A905A76F41", hash_generated_method = "54D9A0C37E66DF85070856657815226D")
        public void setAllMetadata(int generationId, Bundle metadata, Bitmap bitmap) {
            addTaint(bitmap.getTaint());
            addTaint(metadata.getTaint());
            addTaint(generationId);
            Handler handler = mLocalHandler.get();
            if(handler!=null)            
            {
handler.obtainMessage(MSG_SET_METADATA, generationId, 0, metadata).sendToTarget()handler.obtainMessage(MSG_SET_ARTWORK, generationId, 0, bitmap).sendToTarget()
            } //End block
            // ---------- Original Method ----------
            //Handler handler = mLocalHandler.get();
            //if (handler != null) {
                //handler.obtainMessage(MSG_SET_METADATA, generationId, 0, metadata).sendToTarget();
                //handler.obtainMessage(MSG_SET_ARTWORK, generationId, 0, bitmap).sendToTarget();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.571 -0400", hash_original_method = "14D630A30EAA5019B0E3B89175C47C57", hash_generated_method = "11DEE125734C83437087FFBDBAC705F6")
        public void setCurrentClientId(int clientGeneration, PendingIntent mediaIntent,
                boolean clearing) throws RemoteException {
            addTaint(clearing);
            addTaint(mediaIntent.getTaint());
            addTaint(clientGeneration);
            Handler handler = mLocalHandler.get();
            if(handler!=null)            
            {
handler.obtainMessage(MSG_SET_GENERATION_ID, clientGeneration, (clearing?1:1), mediaIntent).sendToTarget()
            } //End block
            // ---------- Original Method ----------
            //Handler handler = mLocalHandler.get();
            //if (handler != null) {
                //handler.obtainMessage(MSG_SET_GENERATION_ID,
                    //clientGeneration, (clearing ? 1 : 0), mediaIntent).sendToTarget();
            //}
        }

        
    }


    
    class Metadata {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.572 -0400", hash_original_field = "0441F9E2D94C39A70E21B83829259AA4", hash_generated_field = "630EC4E3C31596D2482FD14BAAB70A96")

        private String artist;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.572 -0400", hash_original_field = "41800DD4E7BDCCF7C0AAAAF0384D15B8", hash_generated_field = "993CD1BBECFD466C03E195D0AE39ED2D")

        private String trackTitle;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.572 -0400", hash_original_field = "25BE2CC7CF5E66AF83987C48FA1892DF", hash_generated_field = "75930C1F445691D6B5273945109A467B")

        private String albumTitle;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.573 -0400", hash_original_field = "86BB33755628454AF74F88F047EC894A", hash_generated_field = "E770D44D6A4DC3728778535AAF7EA2BE")

        private Bitmap bitmap;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.573 -0400", hash_original_method = "274136CA387E4B7EE3FECDA777B27CDF", hash_generated_method = "274136CA387E4B7EE3FECDA777B27CDF")
        public Metadata ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.573 -0400", hash_original_method = "262B49665EC229D1A464F9B7CA23D04E", hash_generated_method = "DF3837D8D1EA0FA491CD4598490B984D")
        public String toString() {
String var5BEF89EC8ABCFA18F8285E6F3139A57D_1237610983 = "Metadata[artist="+artist+" trackTitle="+trackTitle+" albumTitle="+albumTitle+"]"            var5BEF89EC8ABCFA18F8285E6F3139A57D_1237610983.addTaint(taint);
            return var5BEF89EC8ABCFA18F8285E6F3139A57D_1237610983;
            // ---------- Original Method ----------
            //return "Metadata[artist=" + artist + " trackTitle=" + trackTitle + " albumTitle=" + albumTitle + "]";
        }

        
    }


    
    static class SavedState extends BaseSavedState {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.574 -0400", hash_original_field = "B8047B126FEBF592B035BCC9C9E7A548", hash_generated_field = "7B55FEC3EE895FFBAE91D7DEEAC0D2DF")

        boolean wasShowing;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.574 -0400", hash_original_method = "89EB4EC154F05BF905ECA8E02BBD14BC", hash_generated_method = "3F4F70129FCB46E4AE0D334AE4D70CF6")
          SavedState(Parcelable superState) {
            super(superState);
            addTaint(superState.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.575 -0400", hash_original_method = "3CD210B9A128142E938491DD9CE70541", hash_generated_method = "A731403F49942036EFFEF7B9B8DF17F0")
        private  SavedState(Parcel in) {
            super(in);
            addTaint(in.getTaint());
this.wasShowing=in.readInt()!=0
            // ---------- Original Method ----------
            //this.wasShowing = in.readInt() != 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.576 -0400", hash_original_method = "791459518958DC1C8FA19A9ACAE620B1", hash_generated_method = "EB6A96B4BC889D62F9D865ACF3991C3E")
        @Override
        public void writeToParcel(Parcel out, int flags) {
            addTaint(flags);
            addTaint(out.getTaint());
super.writeToParcel(out, flags)out.writeInt(this.wasShowing?1:1)
            // ---------- Original Method ----------
            //super.writeToParcel(out, flags);
            //out.writeInt(this.wasShowing ? 1 : 0);
        }

        


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.576 -0400", hash_original_field = "6D0B7A5F2A464355FA3198F7F31BF46B", hash_generated_field = "664E6F392219A3C2CD36A59EFBDA0714")

    private static final int MSG_UPDATE_STATE = 100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.576 -0400", hash_original_field = "FF223C8026805F8533175EB9FE408A1F", hash_generated_field = "CBFBDC92440FDE12C8DB119A72637171")

    private static final int MSG_SET_METADATA = 101;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.577 -0400", hash_original_field = "2AF6A0FC31318C61CAD37B4F5EEECAEB", hash_generated_field = "8D3C02BF7323840A59B5A31175AFE903")

    private static final int MSG_SET_TRANSPORT_CONTROLS = 102;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.577 -0400", hash_original_field = "5C338DA65394197479AC29B81D700EC0", hash_generated_field = "65C730F772AB5F1627ACF85C9785FC9F")

    private static final int MSG_SET_ARTWORK = 103;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.577 -0400", hash_original_field = "679BD3D9F0D8D1FB5939DC4504E98DC3", hash_generated_field = "FFDE353B6F8F25A8C63F8457E8360F16")

    private static final int MSG_SET_GENERATION_ID = 104;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.577 -0400", hash_original_field = "702358C42031D97239DF9C757A5B8A5E", hash_generated_field = "034B75F528C5D56ECF51CFD6223EF333")

    private static final int MAXDIM = 512;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.577 -0400", hash_original_field = "2AD5D9105877AD1B4E9B52EC0B74EF3B", hash_generated_field = "798A1A7B4AA499897BF7E1D31F256F9A")

    private static final int DISPLAY_TIMEOUT_MS = 5000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.577 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "EF0AE41141637767335633A935D364FD")

    protected static final boolean DEBUG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.577 -0400", hash_original_field = "25EA1691D540AA0B7CFE664E34037C68", hash_generated_field = "205B89CFD7A1B38DDCCC3C0C26648D5E")

    protected static final String TAG = "TransportControlView";
}

