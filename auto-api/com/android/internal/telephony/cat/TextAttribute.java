package com.android.internal.telephony.cat;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class TextAttribute {
    public int start;
    public int length;
    public TextAlignment align;
    public FontSize size;
    public boolean bold;
    public boolean italic;
    public boolean underlined;
    public boolean strikeThrough;
    public TextColor color;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.010 -0400", hash_original_method = "4F5520D3BCCB9D14B21693AFF8505891", hash_generated_method = "5614C74D0B0D49988FA037BB5983C71B")
    @DSModeled(DSC.SAFE)
    public TextAttribute(int start, int length, TextAlignment align,
            FontSize size, boolean bold, boolean italic, boolean underlined,
            boolean strikeThrough, TextColor color) {
        dsTaint.addTaint(bold);
        dsTaint.addTaint(color.dsTaint);
        dsTaint.addTaint(strikeThrough);
        dsTaint.addTaint(start);
        dsTaint.addTaint(align.dsTaint);
        dsTaint.addTaint(length);
        dsTaint.addTaint(italic);
        dsTaint.addTaint(underlined);
        dsTaint.addTaint(size.dsTaint);
        // ---------- Original Method ----------
        //this.start = start;
        //this.length = length;
        //this.align = align;
        //this.size = size;
        //this.bold = bold;
        //this.italic = italic;
        //this.underlined = underlined;
        //this.strikeThrough = strikeThrough;
        //this.color = color;
    }

    
}

