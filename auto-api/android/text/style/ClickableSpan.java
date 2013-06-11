package android.text.style;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.text.TextPaint;
import android.view.View;

public abstract class ClickableSpan extends CharacterStyle implements UpdateAppearance {
    
    public abstract void onClick(View widget);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.301 -0400", hash_original_method = "6A446C4FD57B873C0000087B5918E9E8", hash_generated_method = "D67F5668D40C31615390B71B52531012")
    @DSModeled(DSC.SAFE)
    @Override
    public void updateDrawState(TextPaint ds) {
        dsTaint.addTaint(ds.dsTaint);
        ds.setColor(ds.linkColor);
        ds.setUnderlineText(true);
        // ---------- Original Method ----------
        //ds.setColor(ds.linkColor);
        //ds.setUnderlineText(true);
    }

    
}


