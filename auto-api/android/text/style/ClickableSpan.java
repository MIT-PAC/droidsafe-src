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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.830 -0400", hash_original_method = "7E8EA8088E916DE83ACC63CE479D0130", hash_generated_method = "7E8EA8088E916DE83ACC63CE479D0130")
        public ClickableSpan ()
    {
    }


    public abstract void onClick(View widget);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.830 -0400", hash_original_method = "6A446C4FD57B873C0000087B5918E9E8", hash_generated_method = "F373FDB7ED2D0819BBF474F2E1970AA7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

