package android.text.style;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.text.TextPaint;
import android.view.View;

public abstract class ClickableSpan extends CharacterStyle implements UpdateAppearance {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:45.579 -0400", hash_original_method = "779BDEA27573914565EB7FC3B293B826", hash_generated_method = "779BDEA27573914565EB7FC3B293B826")
    public ClickableSpan ()
    {
        //Synthesized constructor
    }


    public abstract void onClick(View widget);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:45.580 -0400", hash_original_method = "6A446C4FD57B873C0000087B5918E9E8", hash_generated_method = "ADCE40F8C52DB31730FA55E2DDECEB52")
    @Override
    public void updateDrawState(TextPaint ds) {
        ds.setColor(ds.linkColor);
        ds.setUnderlineText(true);
        addTaint(ds.getTaint());
        // ---------- Original Method ----------
        //ds.setColor(ds.linkColor);
        //ds.setUnderlineText(true);
    }

    
}

