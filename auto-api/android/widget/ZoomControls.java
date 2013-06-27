package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.annotation.Widget;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import com.android.internal.R;

public class ZoomControls extends LinearLayout {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.896 -0400", hash_original_field = "D03859FA7BA3F6915C2AA20924B0C889", hash_generated_field = "7116DE4A12D2EB2034E69BBBF12212DA")

    private ZoomButton mZoomIn;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.896 -0400", hash_original_field = "CD12A457BB06D87CB078DDFD8E359C90", hash_generated_field = "E64AF7300F8D4E214346AF3EA47CF57E")

    private ZoomButton mZoomOut;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.896 -0400", hash_original_method = "10F3E3D1A11DC20FE44EEC423922BDF4", hash_generated_method = "71C12E493572EE447DA5234C8B96CE8F")
    public  ZoomControls(Context context) {
        this(context, null);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.905 -0400", hash_original_method = "EEE1D0E353F6E8D1719CC2CAB69CDDDF", hash_generated_method = "8562E0F8EFD324C7D99FD4CA70520F5C")
    public  ZoomControls(Context context, AttributeSet attrs) {
        super(context, attrs);
        setFocusable(false);
        LayoutInflater inflater;
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.zoom_controls, this, 
                true);
        mZoomIn = (ZoomButton) findViewById(R.id.zoomIn);
        mZoomOut = (ZoomButton) findViewById(R.id.zoomOut);
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        // ---------- Original Method ----------
        //setFocusable(false);
        //LayoutInflater inflater = (LayoutInflater) context
                //.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //inflater.inflate(R.layout.zoom_controls, this, 
                //true);
        //mZoomIn = (ZoomButton) findViewById(R.id.zoomIn);
        //mZoomOut = (ZoomButton) findViewById(R.id.zoomOut);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.908 -0400", hash_original_method = "BB515265AEE98A63EEEF9DCF76B8616A", hash_generated_method = "4F6F0DAD81AD13121B6A7A0C55352BCB")
    public void setOnZoomInClickListener(OnClickListener listener) {
        mZoomIn.setOnClickListener(listener);
        addTaint(listener.getTaint());
        // ---------- Original Method ----------
        //mZoomIn.setOnClickListener(listener);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.908 -0400", hash_original_method = "35622AF1D6D5327607A99B20A992A9B1", hash_generated_method = "ADD116C29F94ED6253C3E5DF3530A27D")
    public void setOnZoomOutClickListener(OnClickListener listener) {
        mZoomOut.setOnClickListener(listener);
        addTaint(listener.getTaint());
        // ---------- Original Method ----------
        //mZoomOut.setOnClickListener(listener);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.915 -0400", hash_original_method = "A6640A96361603BAC2F17D8F8F5DC89E", hash_generated_method = "CCEC0DA77ADAC2B5261FDA70442005A8")
    public void setZoomSpeed(long speed) {
        mZoomIn.setZoomSpeed(speed);
        mZoomOut.setZoomSpeed(speed);
        addTaint(speed);
        // ---------- Original Method ----------
        //mZoomIn.setZoomSpeed(speed);
        //mZoomOut.setZoomSpeed(speed);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.916 -0400", hash_original_method = "D87B32C51AD302A4F9341AA86337AE33", hash_generated_method = "79F5DA12D607D9CD7A371708281C4795")
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1895683 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1895683;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.920 -0400", hash_original_method = "C11451C1AB4E567449CD07B5E594E725", hash_generated_method = "2A34B6A5D8BCEC0514353FD815FCBC82")
    public void show() {
        fade(View.VISIBLE, 0.0f, 1.0f);
        // ---------- Original Method ----------
        //fade(View.VISIBLE, 0.0f, 1.0f);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.922 -0400", hash_original_method = "E5A5304131EA7BA6BF2FB03B8454E0A2", hash_generated_method = "1763705770489D0C249161FFFC62FF0D")
    public void hide() {
        fade(View.GONE, 1.0f, 0.0f);
        // ---------- Original Method ----------
        //fade(View.GONE, 1.0f, 0.0f);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.922 -0400", hash_original_method = "9BED0A47A1FCF93930F77C8CDDC09D0D", hash_generated_method = "39AA330BFFC05ABDE74173F5893938C3")
    private void fade(int visibility, float startAlpha, float endAlpha) {
        AlphaAnimation anim;
        anim = new AlphaAnimation(startAlpha, endAlpha);
        anim.setDuration(500);
        startAnimation(anim);
        setVisibility(visibility);
        addTaint(visibility);
        addTaint(startAlpha);
        addTaint(endAlpha);
        // ---------- Original Method ----------
        //AlphaAnimation anim = new AlphaAnimation(startAlpha, endAlpha);
        //anim.setDuration(500);
        //startAnimation(anim);
        //setVisibility(visibility);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.922 -0400", hash_original_method = "2126F62859134DF2EBC550B9718A317B", hash_generated_method = "C06BAEDE3577658C916C95BE87E0C9DA")
    public void setIsZoomInEnabled(boolean isEnabled) {
        mZoomIn.setEnabled(isEnabled);
        addTaint(isEnabled);
        // ---------- Original Method ----------
        //mZoomIn.setEnabled(isEnabled);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.964 -0400", hash_original_method = "45416B0BE009A28B7DBB8DCE0047833B", hash_generated_method = "7D98BE09DF6D1F43D29917DA4437916F")
    public void setIsZoomOutEnabled(boolean isEnabled) {
        mZoomOut.setEnabled(isEnabled);
        addTaint(isEnabled);
        // ---------- Original Method ----------
        //mZoomOut.setEnabled(isEnabled);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.965 -0400", hash_original_method = "627B89961C8BD752C151F14A1A83054C", hash_generated_method = "640A6D1EB2350877B357792609C39AFE")
    @Override
    public boolean hasFocus() {
        boolean varF3ECAAB64F990C275F0712A961E35977_920432409 = (mZoomIn.hasFocus() || mZoomOut.hasFocus());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1032953256 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1032953256;
        // ---------- Original Method ----------
        //return mZoomIn.hasFocus() || mZoomOut.hasFocus();
    }

    
}

