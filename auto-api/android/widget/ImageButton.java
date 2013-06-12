package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RemoteViews.RemoteView;
import java.util.Map;

public class ImageButton extends ImageView {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.621 -0400", hash_original_method = "D776EEA4260F4386B702AF839A43C27E", hash_generated_method = "EFDA968E9F6114A5B50270FEA3030391")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ImageButton(Context context) {
        this(context, null);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.621 -0400", hash_original_method = "69F1C1BA5F8D6B6EC679242C32E07C96", hash_generated_method = "D51F9625720A111E13547B5ADECB7F58")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ImageButton(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.imageButtonStyle);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.621 -0400", hash_original_method = "47E1B94896A9BFD998FAA5ACD5A61A9C", hash_generated_method = "D12002F355C521826A321F47E756A939")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ImageButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(defStyle);
        dsTaint.addTaint(context.dsTaint);
        setFocusable(true);
        // ---------- Original Method ----------
        //setFocusable(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.621 -0400", hash_original_method = "DC47911C20E58BC47F643D76AAAF3E73", hash_generated_method = "DC4FB516DDC200D0838D759E13A15380")
    @DSModeled(DSC.SAFE)
    @Override
    protected boolean onSetAlpha(int alpha) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(alpha);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
}


