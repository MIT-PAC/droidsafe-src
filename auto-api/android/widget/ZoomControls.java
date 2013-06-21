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
    private ZoomButton mZoomIn;
    private ZoomButton mZoomOut;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.844 -0400", hash_original_method = "10F3E3D1A11DC20FE44EEC423922BDF4", hash_generated_method = "025316BE459AA48C0513F7DEE574E4F0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ZoomControls(Context context) {
        this(context, null);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.844 -0400", hash_original_method = "EEE1D0E353F6E8D1719CC2CAB69CDDDF", hash_generated_method = "0B8E33686F6FCFB15E430D4624721F08")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ZoomControls(Context context, AttributeSet attrs) {
        super(context, attrs);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        setFocusable(false);
        LayoutInflater inflater;
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.zoom_controls, this, 
                true);
        mZoomIn = (ZoomButton) findViewById(R.id.zoomIn);
        mZoomOut = (ZoomButton) findViewById(R.id.zoomOut);
        // ---------- Original Method ----------
        //setFocusable(false);
        //LayoutInflater inflater = (LayoutInflater) context
                //.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //inflater.inflate(R.layout.zoom_controls, this, 
                //true);
        //mZoomIn = (ZoomButton) findViewById(R.id.zoomIn);
        //mZoomOut = (ZoomButton) findViewById(R.id.zoomOut);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.844 -0400", hash_original_method = "BB515265AEE98A63EEEF9DCF76B8616A", hash_generated_method = "D95F9A2E32D69EDDD6456864427F1A56")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setOnZoomInClickListener(OnClickListener listener) {
        dsTaint.addTaint(listener.dsTaint);
        mZoomIn.setOnClickListener(listener);
        // ---------- Original Method ----------
        //mZoomIn.setOnClickListener(listener);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.845 -0400", hash_original_method = "35622AF1D6D5327607A99B20A992A9B1", hash_generated_method = "D568A20BED253B7BC6B8FC0B7006FE46")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setOnZoomOutClickListener(OnClickListener listener) {
        dsTaint.addTaint(listener.dsTaint);
        mZoomOut.setOnClickListener(listener);
        // ---------- Original Method ----------
        //mZoomOut.setOnClickListener(listener);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.845 -0400", hash_original_method = "A6640A96361603BAC2F17D8F8F5DC89E", hash_generated_method = "E7AB4E19D624320B89C61903D241E04D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setZoomSpeed(long speed) {
        dsTaint.addTaint(speed);
        mZoomIn.setZoomSpeed(speed);
        mZoomOut.setZoomSpeed(speed);
        // ---------- Original Method ----------
        //mZoomIn.setZoomSpeed(speed);
        //mZoomOut.setZoomSpeed(speed);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.845 -0400", hash_original_method = "D87B32C51AD302A4F9341AA86337AE33", hash_generated_method = "CAC19770074E9335F5A0948E5AD2CEE9")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(event.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.845 -0400", hash_original_method = "C11451C1AB4E567449CD07B5E594E725", hash_generated_method = "2A34B6A5D8BCEC0514353FD815FCBC82")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void show() {
        fade(View.VISIBLE, 0.0f, 1.0f);
        // ---------- Original Method ----------
        //fade(View.VISIBLE, 0.0f, 1.0f);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.845 -0400", hash_original_method = "E5A5304131EA7BA6BF2FB03B8454E0A2", hash_generated_method = "1763705770489D0C249161FFFC62FF0D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void hide() {
        fade(View.GONE, 1.0f, 0.0f);
        // ---------- Original Method ----------
        //fade(View.GONE, 1.0f, 0.0f);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.846 -0400", hash_original_method = "9BED0A47A1FCF93930F77C8CDDC09D0D", hash_generated_method = "1EF211ADC65E80CD053CBF3AE74DDA44")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void fade(int visibility, float startAlpha, float endAlpha) {
        dsTaint.addTaint(startAlpha);
        dsTaint.addTaint(visibility);
        dsTaint.addTaint(endAlpha);
        AlphaAnimation anim;
        anim = new AlphaAnimation(startAlpha, endAlpha);
        anim.setDuration(500);
        startAnimation(anim);
        setVisibility(visibility);
        // ---------- Original Method ----------
        //AlphaAnimation anim = new AlphaAnimation(startAlpha, endAlpha);
        //anim.setDuration(500);
        //startAnimation(anim);
        //setVisibility(visibility);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.846 -0400", hash_original_method = "2126F62859134DF2EBC550B9718A317B", hash_generated_method = "B4478699F65AEE23CAF4A70FD6F9596F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setIsZoomInEnabled(boolean isEnabled) {
        dsTaint.addTaint(isEnabled);
        mZoomIn.setEnabled(isEnabled);
        // ---------- Original Method ----------
        //mZoomIn.setEnabled(isEnabled);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.846 -0400", hash_original_method = "45416B0BE009A28B7DBB8DCE0047833B", hash_generated_method = "03A2329500AFAF8CF63CC4323FDDBF2B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setIsZoomOutEnabled(boolean isEnabled) {
        dsTaint.addTaint(isEnabled);
        mZoomOut.setEnabled(isEnabled);
        // ---------- Original Method ----------
        //mZoomOut.setEnabled(isEnabled);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.846 -0400", hash_original_method = "627B89961C8BD752C151F14A1A83054C", hash_generated_method = "00E6EE772D35D19B084067272F3F6316")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean hasFocus() {
        boolean varF3ECAAB64F990C275F0712A961E35977_1984307318 = (mZoomIn.hasFocus() || mZoomOut.hasFocus());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mZoomIn.hasFocus() || mZoomOut.hasFocus();
    }

    
}

