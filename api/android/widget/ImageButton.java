package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RemoteViews.RemoteView;
import java.util.Map;

public class ImageButton extends ImageView {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.882 -0400", hash_original_method = "D776EEA4260F4386B702AF839A43C27E", hash_generated_method = "C74D4D92DF22322A519BE7CC5DE7B6B8")
    public  ImageButton(Context context) {
        this(context, null);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.883 -0400", hash_original_method = "69F1C1BA5F8D6B6EC679242C32E07C96", hash_generated_method = "4DB79E7CEC627C671366827CA70F520C")
    public  ImageButton(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.imageButtonStyle);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.883 -0400", hash_original_method = "47E1B94896A9BFD998FAA5ACD5A61A9C", hash_generated_method = "080901009EF58C2AF01D20F3EBDEFDF6")
    public  ImageButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        addTaint(defStyle);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        setFocusable(true);
        // ---------- Original Method ----------
        //setFocusable(true);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.884 -0400", hash_original_method = "DC47911C20E58BC47F643D76AAAF3E73", hash_generated_method = "A9D3B9CB03C03F500FEEE19E8F5132D8")
    @Override
    protected boolean onSetAlpha(int alpha) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(alpha);
        boolean var68934A3E9455FA72420237EB05902327_630403987 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1085888827 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1085888827;
        // ---------- Original Method ----------
        //return false;
    }

    
}

