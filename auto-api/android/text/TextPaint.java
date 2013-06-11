package android.text;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.graphics.Paint;

public class TextPaint extends Paint {
    public int bgColor;
    public int baselineShift;
    public int linkColor;
    public int[] drawableState;
    public float density = 1.0f;
    public int underlineColor = 0;
    public float underlineThickness;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.375 -0400", hash_original_method = "618AB1B9CBAFB419831828FB2E1722C9", hash_generated_method = "1B1CACD9B3FDD3F2D2709EA9ACB777B3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public TextPaint() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.375 -0400", hash_original_method = "512D920DE77B40AA9B525CC82C9BBF96", hash_generated_method = "F8D32377F337372AFC9258798DBE6CD8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public TextPaint(int flags) {
        super(flags);
        dsTaint.addTaint(flags);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.375 -0400", hash_original_method = "EB2846FC8EC35D49B4CB30B890D5BAE5", hash_generated_method = "2D1F40D3C92A84AFB175C9A8E6B8E946")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public TextPaint(Paint p) {
        super(p);
        dsTaint.addTaint(p.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.376 -0400", hash_original_method = "1430CF075B6F082AE7C06C83102C116C", hash_generated_method = "70E5B4C54E62D76D145D715CF018F4E2")
    @DSModeled(DSC.SAFE)
    public void set(TextPaint tp) {
        dsTaint.addTaint(tp.dsTaint);
        super.set(tp);
        bgColor = tp.bgColor;
        baselineShift = tp.baselineShift;
        linkColor = tp.linkColor;
        drawableState = tp.drawableState;
        density = tp.density;
        underlineColor = tp.underlineColor;
        underlineThickness = tp.underlineThickness;
        // ---------- Original Method ----------
        //super.set(tp);
        //bgColor = tp.bgColor;
        //baselineShift = tp.baselineShift;
        //linkColor = tp.linkColor;
        //drawableState = tp.drawableState;
        //density = tp.density;
        //underlineColor = tp.underlineColor;
        //underlineThickness = tp.underlineThickness;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.376 -0400", hash_original_method = "398799A16623F5BF0623CBD73B973047", hash_generated_method = "DBB02623FE1D237DC3B3C30F99CE593A")
    @DSModeled(DSC.SAFE)
    public void setUnderlineText(int color, float thickness) {
        dsTaint.addTaint(color);
        dsTaint.addTaint(thickness);
        // ---------- Original Method ----------
        //underlineColor = color;
        //underlineThickness = thickness;
    }

    
}


