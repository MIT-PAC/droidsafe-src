package android.text.style;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.text.TextPaint;
import android.view.View;

public abstract class ClickableSpan extends CharacterStyle implements UpdateAppearance {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.152 -0400", hash_original_method = "779BDEA27573914565EB7FC3B293B826", hash_generated_method = "779BDEA27573914565EB7FC3B293B826")
    public ClickableSpan ()
    {
        //Synthesized constructor
    }


    public abstract void onClick(View widget);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.153 -0400", hash_original_method = "6A446C4FD57B873C0000087B5918E9E8", hash_generated_method = "7EBD8470139AEE57F5289AAE828C1AB4")
    @Override
    public void updateDrawState(TextPaint ds) {
        addTaint(ds.getTaint());
        ds.setColor(ds.linkColor);
        ds.setUnderlineText(true);
        // ---------- Original Method ----------
        //ds.setColor(ds.linkColor);
        //ds.setUnderlineText(true);
    }

    
}

