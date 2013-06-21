package android.text;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.709 -0400", hash_original_method = "618AB1B9CBAFB419831828FB2E1722C9", hash_generated_method = "184089B139E22F497C16BD8D371A9B08")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public TextPaint() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.710 -0400", hash_original_method = "512D920DE77B40AA9B525CC82C9BBF96", hash_generated_method = "330FA423176AF618E1F775EA8DC3B325")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public TextPaint(int flags) {
        super(flags);
        dsTaint.addTaint(flags);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.710 -0400", hash_original_method = "EB2846FC8EC35D49B4CB30B890D5BAE5", hash_generated_method = "AD7AE3365F75224D8C98F61C99C71885")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public TextPaint(Paint p) {
        super(p);
        dsTaint.addTaint(p.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.710 -0400", hash_original_method = "1430CF075B6F082AE7C06C83102C116C", hash_generated_method = "DCE03F1B5C41A3A9E67136375CD0E610")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.710 -0400", hash_original_method = "398799A16623F5BF0623CBD73B973047", hash_generated_method = "3E21D21A0D02A9C4E80608D4F4FD681A")
    @DSModeled(DSC.SAFE)
    public void setUnderlineText(int color, float thickness) {
        dsTaint.addTaint(color);
        dsTaint.addTaint(thickness);
        // ---------- Original Method ----------
        //underlineColor = color;
        //underlineThickness = thickness;
    }

    
}

