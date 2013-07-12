package android.widget;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.annotation.Widget;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import com.android.internal.R;

public class ZoomControls extends LinearLayout {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:14.233 -0400", hash_original_field = "D03859FA7BA3F6915C2AA20924B0C889", hash_generated_field = "7116DE4A12D2EB2034E69BBBF12212DA")

    private ZoomButton mZoomIn;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:14.233 -0400", hash_original_field = "CD12A457BB06D87CB078DDFD8E359C90", hash_generated_field = "E64AF7300F8D4E214346AF3EA47CF57E")

    private ZoomButton mZoomOut;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:14.233 -0400", hash_original_method = "10F3E3D1A11DC20FE44EEC423922BDF4", hash_generated_method = "71C12E493572EE447DA5234C8B96CE8F")
    public  ZoomControls(Context context) {
        this(context, null);
        addTaint(context.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:14.234 -0400", hash_original_method = "EEE1D0E353F6E8D1719CC2CAB69CDDDF", hash_generated_method = "42F63EB371FDFB2050119AC48C2853CA")
    public  ZoomControls(Context context, AttributeSet attrs) {
        super(context, attrs);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        setFocusable(false);
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.zoom_controls, this, 
                true);
        mZoomIn = (ZoomButton) findViewById(R.id.zoomIn);
        mZoomOut = (ZoomButton) findViewById(R.id.zoomOut);
        
        
        
                
        
                
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:14.234 -0400", hash_original_method = "BB515265AEE98A63EEEF9DCF76B8616A", hash_generated_method = "AAE69872B2E7F6289640016460F2554F")
    public void setOnZoomInClickListener(OnClickListener listener) {
        addTaint(listener.getTaint());
        mZoomIn.setOnClickListener(listener);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:14.235 -0400", hash_original_method = "35622AF1D6D5327607A99B20A992A9B1", hash_generated_method = "BCFBBD000C999016E92FC2F48F08B340")
    public void setOnZoomOutClickListener(OnClickListener listener) {
        addTaint(listener.getTaint());
        mZoomOut.setOnClickListener(listener);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:14.235 -0400", hash_original_method = "A6640A96361603BAC2F17D8F8F5DC89E", hash_generated_method = "E526B3E3A654349CB1BF37266ADD5405")
    public void setZoomSpeed(long speed) {
        addTaint(speed);
        mZoomIn.setZoomSpeed(speed);
        mZoomOut.setZoomSpeed(speed);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:14.235 -0400", hash_original_method = "D87B32C51AD302A4F9341AA86337AE33", hash_generated_method = "5CF2570229A96077D9C2C9E38FD7B1B8")
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        
        addTaint(event.getTaint());
        boolean varB326B5062B2F0E69046810717534CB09_1631706577 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1241483450 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1241483450;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:14.235 -0400", hash_original_method = "C11451C1AB4E567449CD07B5E594E725", hash_generated_method = "2A34B6A5D8BCEC0514353FD815FCBC82")
    public void show() {
        fade(View.VISIBLE, 0.0f, 1.0f);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:14.236 -0400", hash_original_method = "E5A5304131EA7BA6BF2FB03B8454E0A2", hash_generated_method = "1763705770489D0C249161FFFC62FF0D")
    public void hide() {
        fade(View.GONE, 1.0f, 0.0f);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:14.236 -0400", hash_original_method = "9BED0A47A1FCF93930F77C8CDDC09D0D", hash_generated_method = "1E5CB067E3CEB98E43F612AE3706CF55")
    private void fade(int visibility, float startAlpha, float endAlpha) {
        addTaint(endAlpha);
        addTaint(startAlpha);
        addTaint(visibility);
        AlphaAnimation anim = new AlphaAnimation(startAlpha, endAlpha);
        anim.setDuration(500);
        startAnimation(anim);
        setVisibility(visibility);
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:14.236 -0400", hash_original_method = "2126F62859134DF2EBC550B9718A317B", hash_generated_method = "822EA97F6C4DD48D2E0E533A0BD9871C")
    public void setIsZoomInEnabled(boolean isEnabled) {
        addTaint(isEnabled);
        mZoomIn.setEnabled(isEnabled);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:14.237 -0400", hash_original_method = "45416B0BE009A28B7DBB8DCE0047833B", hash_generated_method = "31C4E381E20C53ED3919A96B417FD3B5")
    public void setIsZoomOutEnabled(boolean isEnabled) {
        addTaint(isEnabled);
        mZoomOut.setEnabled(isEnabled);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:14.237 -0400", hash_original_method = "627B89961C8BD752C151F14A1A83054C", hash_generated_method = "A0D3EF032DB682D4029B6EC3ADFB7F92")
    @Override
    public boolean hasFocus() {
        boolean varA7700542A5CF594E0CC0101E1DA4F0D0_61653799 = (mZoomIn.hasFocus() || mZoomOut.hasFocus());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_289430824 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_289430824;
        
        
    }

    
}

