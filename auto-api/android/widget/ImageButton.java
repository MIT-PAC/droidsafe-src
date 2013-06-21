package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RemoteViews.RemoteView;
import java.util.Map;

public class ImageButton extends ImageView {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.110 -0400", hash_original_method = "D776EEA4260F4386B702AF839A43C27E", hash_generated_method = "A335AAABB24E6EB5095C37EA93C549DF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ImageButton(Context context) {
        this(context, null);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.110 -0400", hash_original_method = "69F1C1BA5F8D6B6EC679242C32E07C96", hash_generated_method = "C80A77A0EA8DE89BD9A08F5BC40EAADE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ImageButton(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.imageButtonStyle);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.110 -0400", hash_original_method = "47E1B94896A9BFD998FAA5ACD5A61A9C", hash_generated_method = "5E9FBC4AF1D430360305603251DB3E4F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.110 -0400", hash_original_method = "DC47911C20E58BC47F643D76AAAF3E73", hash_generated_method = "80D3E6A0D381195312A247B73072F0A5")
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

