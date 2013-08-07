package com.android.internal.policy.impl;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.media.AudioManager;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.content.Intent;
import android.content.Context;
import android.graphics.PixelFormat;
import android.graphics.Canvas;
import android.telephony.TelephonyManager;
import android.view.KeyEvent;
import android.util.AttributeSet;
public abstract class KeyguardViewBase extends FrameLayout {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.287 -0400", hash_original_field = "1804C5EC7AAE0B28B15CFDA061D25829", hash_generated_field = "2E854999F8FF3F1BC54ABCA08FA19468")

    private KeyguardViewCallback mCallback;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.288 -0400", hash_original_field = "DC563AE6C758BE979A84432D84FFAC40", hash_generated_field = "B52B11818937F27E927A20CDEBA27654")

    private AudioManager mAudioManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.288 -0400", hash_original_field = "61ACDCD5F6C4186D7B173717CB1158CB", hash_generated_field = "916F14F8AEC6535487103DB3B98C6255")

    private TelephonyManager mTelephonyManager = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.292 -0400", hash_original_field = "F6213961D1D9C0E0C8319A70EB473336", hash_generated_field = "DF2F4789CAC6B6ECF9C6E46C376AB109")

    Drawable mBackgroundDrawable = new Drawable()    {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.289 -0400", hash_original_method = "CBB8D61EBC99220492CD852CADC137FA", hash_generated_method = "20A3D15FE0FAE07D2E0A9113EC992034")
        @Override
        public void draw(Canvas canvas) {
            addTaint(canvas.getTaint());
canvas.drawColor(BACKGROUND_COLOR, PorterDuff.Mode.SRC)
            // ---------- Original Method ----------
            //canvas.drawColor(BACKGROUND_COLOR, PorterDuff.Mode.SRC);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.290 -0400", hash_original_method = "5784D116F3F796E4D5324F7E68A41209", hash_generated_method = "DCDCC287CA9BC5217D3FA2BC94984F3E")
        @Override
        public void setAlpha(int alpha) {
            addTaint(alpha);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.291 -0400", hash_original_method = "77240A7357C6E5E7293BFF14ACDD79D8", hash_generated_method = "18D8B35FAE562ED5B4F19A1CD78B9AEE")
        @Override
        public void setColorFilter(ColorFilter cf) {
            addTaint(cf.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.292 -0400", hash_original_method = "AB3D570DA2A917C408AB4F7D8FCD7103", hash_generated_method = "D039A031A6AE29AA85AFA06288DC6768")
        @Override
        public int getOpacity() {
            int var26C79996E92FCFBDC98A49C80BC91AD0_1237892179 = (PixelFormat.TRANSLUCENT);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1159760397 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1159760397;
            // ---------- Original Method ----------
            //return PixelFormat.TRANSLUCENT;
        }

        
    }
;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.293 -0400", hash_original_method = "0094DC6D28F1F680911A981E966DEE19", hash_generated_method = "36142A18E3C5B0C341100FB99AAD5CE5")
    public  KeyguardViewBase(Context context) {
        super(context);
        addTaint(context.getTaint());
resetBackground()
        // ---------- Original Method ----------
        //resetBackground();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.294 -0400", hash_original_method = "51F62513B8379718BCB0CC015BD2514F", hash_generated_method = "38842671A3AB99C24E9A786267D7F1BD")
    public void resetBackground() {
setBackgroundDrawable(mBackgroundDrawable)
        // ---------- Original Method ----------
        //setBackgroundDrawable(mBackgroundDrawable);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.294 -0400", hash_original_method = "0D16C9C17971EC00704AEE400BA138CA", hash_generated_method = "F2E288D4EB8E83220BB6DF460BFAD994")
     void setCallback(KeyguardViewCallback callback) {
        addTaint(callback.getTaint());
mCallback=callback
        // ---------- Original Method ----------
        //mCallback = callback;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.295 -0400", hash_original_method = "176BCD7FD382661B6B6C50365BB8C695", hash_generated_method = "462D8D84EDE64551B743AFB9DF581948")
    public KeyguardViewCallback getCallback() {
KeyguardViewCallback var31075088B2A2E9D45AA9874A2DA07598_361915941 = mCallback        var31075088B2A2E9D45AA9874A2DA07598_361915941.addTaint(taint);
        return var31075088B2A2E9D45AA9874A2DA07598_361915941;
        // ---------- Original Method ----------
        //return mCallback;
    }

    
    abstract public void reset();

    
    abstract public void onScreenTurnedOff();

    
    abstract public void onScreenTurnedOn();

    
    abstract public void show();

    
    abstract public void wakeWhenReadyTq(int keyCode);

    
    abstract public void verifyUnlock();

    
    abstract public void cleanUp();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.298 -0400", hash_original_method = "A120B7CC4FD15C040B507407CD3A6D70", hash_generated_method = "9C7F5DAA12C80E4C409934E613E65B60")
    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        addTaint(event.getTaint());
        if(shouldEventKeepScreenOnWhileKeyguardShowing(event))        
        {
mCallback.pokeWakelock()
        } //End block
        if(interceptMediaKey(event))        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1689783388 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1989400188 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1989400188;
        } //End block
        boolean var639DD27D10E8FF69097B1398D445D1B9_1489828057 = (super.dispatchKeyEvent(event));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1154854788 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1154854788;
        // ---------- Original Method ----------
        //if (shouldEventKeepScreenOnWhileKeyguardShowing(event)) {
            //mCallback.pokeWakelock();
        //}
        //if (interceptMediaKey(event)) {
            //return true;
        //}
        //return super.dispatchKeyEvent(event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.300 -0400", hash_original_method = "4B250B0FF03D958EEB67409161AF78AC", hash_generated_method = "17CE9B0EF5A8BF58C1F9ABBC61348DEB")
    private boolean shouldEventKeepScreenOnWhileKeyguardShowing(KeyEvent event) {
        addTaint(event.getTaint());
        if(event.getAction()!=KeyEvent.ACTION_DOWN)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1752955924 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1176276574 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1176276574;
        } //End block
        switch(event.getKeyCode()){
        case KeyEvent.KEYCODE_DPAD_DOWN:
        case KeyEvent.KEYCODE_DPAD_LEFT:
        case KeyEvent.KEYCODE_DPAD_RIGHT:
        case KeyEvent.KEYCODE_DPAD_UP:
        boolean var68934A3E9455FA72420237EB05902327_1184046654 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1590405732 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1590405732;
        default:
        boolean varB326B5062B2F0E69046810717534CB09_1065568893 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_140007792 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_140007792;
}
        // ---------- Original Method ----------
        //if (event.getAction() != KeyEvent.ACTION_DOWN) {
            //return false;
        //}
        //switch (event.getKeyCode()) {
            //case KeyEvent.KEYCODE_DPAD_DOWN:
            //case KeyEvent.KEYCODE_DPAD_LEFT:
            //case KeyEvent.KEYCODE_DPAD_RIGHT:
            //case KeyEvent.KEYCODE_DPAD_UP:
                //return false;
            //default:
                //return true;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.303 -0400", hash_original_method = "2A538648A2134EA36BD009A4152600A1", hash_generated_method = "591C3871F2FD1B126ADBD04A41C7A6F2")
    private boolean interceptMediaKey(KeyEvent event) {
        addTaint(event.getTaint());
        final int keyCode = event.getKeyCode();
        if(event.getAction()==KeyEvent.ACTION_DOWN)        
        {
            switch(keyCode){
            case KeyEvent.KEYCODE_MEDIA_PLAY:
            case KeyEvent.KEYCODE_MEDIA_PAUSE:
            case KeyEvent.KEYCODE_MEDIA_PLAY_PAUSE:
            if(mTelephonyManager==null)            
            {
mTelephonyManager=(TelephonyManager) getContext().getSystemService(Context.TELEPHONY_SERVICE)
            } //End block
            if(mTelephonyManager!=null&&mTelephonyManager.getCallState()!=TelephonyManager.CALL_STATE_IDLE)            
            {
                boolean varB326B5062B2F0E69046810717534CB09_1891419298 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1591662200 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1591662200;
            } //End block
            case KeyEvent.KEYCODE_MUTE:
            case KeyEvent.KEYCODE_HEADSETHOOK:
            case KeyEvent.KEYCODE_MEDIA_STOP:
            case KeyEvent.KEYCODE_MEDIA_NEXT:
            case KeyEvent.KEYCODE_MEDIA_PREVIOUS:
            case KeyEvent.KEYCODE_MEDIA_REWIND:
            case KeyEvent.KEYCODE_MEDIA_RECORD:
            case KeyEvent.KEYCODE_MEDIA_FAST_FORWARD:
            {
                Intent intent = new Intent(Intent.ACTION_MEDIA_BUTTON, null);
intent.putExtra(Intent.EXTRA_KEY_EVENT, event)getContext().sendOrderedBroadcast(intent, null)                boolean varB326B5062B2F0E69046810717534CB09_1266327594 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1378464798 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1378464798;
            } //End block
            case KeyEvent.KEYCODE_VOLUME_UP:
            case KeyEvent.KEYCODE_VOLUME_DOWN:
            case KeyEvent.KEYCODE_VOLUME_MUTE:
            {
                if(KEYGUARD_MANAGES_VOLUME)                
                {
                    synchronized
(this)                    {
                        if(mAudioManager==null)                        
                        {
mAudioManager=(AudioManager) getContext().getSystemService(Context.AUDIO_SERVICE)
                        } //End block
                    } //End block
                    if(mAudioManager.isMusicActive())                    
                    {
mAudioManager.adjustStreamVolume(AudioManager.STREAM_MUSIC, keyCode==KeyEvent.KEYCODE_VOLUME_UP?AudioManager.ADJUST_RAISE:AudioManager.ADJUST_RAISE, 0)
                    } //End block
                    boolean varB326B5062B2F0E69046810717534CB09_1384162056 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_462808932 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_462808932;
                } //End block
                else
                {
                    boolean var68934A3E9455FA72420237EB05902327_1476857641 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2146202786 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_2146202786;
                } //End block
            } //End block
}
        } //End block
        else
        if(event.getAction()==KeyEvent.ACTION_UP)        
        {
            switch(keyCode){
            case KeyEvent.KEYCODE_MUTE:
            case KeyEvent.KEYCODE_HEADSETHOOK:
            case KeyEvent.KEYCODE_MEDIA_PLAY:
            case KeyEvent.KEYCODE_MEDIA_PAUSE:
            case KeyEvent.KEYCODE_MEDIA_PLAY_PAUSE:
            case KeyEvent.KEYCODE_MEDIA_STOP:
            case KeyEvent.KEYCODE_MEDIA_NEXT:
            case KeyEvent.KEYCODE_MEDIA_PREVIOUS:
            case KeyEvent.KEYCODE_MEDIA_REWIND:
            case KeyEvent.KEYCODE_MEDIA_RECORD:
            case KeyEvent.KEYCODE_MEDIA_FAST_FORWARD:
            {
                Intent intent = new Intent(Intent.ACTION_MEDIA_BUTTON, null);
intent.putExtra(Intent.EXTRA_KEY_EVENT, event)getContext().sendOrderedBroadcast(intent, null)                boolean varB326B5062B2F0E69046810717534CB09_1139027874 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_10913816 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_10913816;
            } //End block
}
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_532398505 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_195247578 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_195247578;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.305 -0400", hash_original_method = "994432BA8753D0FAC3D2BB3E50B1FBDD", hash_generated_method = "2C6526607C150A073DC7DA685DB438FA")
    @Override
    public void dispatchSystemUiVisibilityChanged(int visibility) {
        addTaint(visibility);
super.dispatchSystemUiVisibilityChanged(visibility)setSystemUiVisibility(STATUS_BAR_DISABLE_BACK)
        // ---------- Original Method ----------
        //super.dispatchSystemUiVisibilityChanged(visibility);
        //setSystemUiVisibility(STATUS_BAR_DISABLE_BACK);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.306 -0400", hash_original_field = "55082D7A6FD1AF6473EF55A076A9BE86", hash_generated_field = "18E5E6E8D50039DA72BD147FA2F2A6B5")

    private static final int BACKGROUND_COLOR = 0x70000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.306 -0400", hash_original_field = "149E307FD0DF8062C506A879C25A918F", hash_generated_field = "481133AEFAC4D4F17A27A5D1AF64D66F")

    private static final boolean KEYGUARD_MANAGES_VOLUME = true;
}

