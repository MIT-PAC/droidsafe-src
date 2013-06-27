package com.android.internal.telephony.cat;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class TextAttribute {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.995 -0400", hash_original_field = "EA2B2676C28C0DB26D39331A336C6B92", hash_generated_field = "D3D73C9CC2FDA0D0E8781D6E9A3253AA")

    public int start;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.996 -0400", hash_original_field = "2FA47F7C65FEC19CC163B195725E3844", hash_generated_field = "1125768121756783FBBAD7831AFCFE31")

    public int length;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.996 -0400", hash_original_field = "F792D1AFB0399DCE47533BEAD9D71A8A", hash_generated_field = "D9C7E3610C11CF71DEC061C08CF0E9A0")

    public TextAlignment align;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.996 -0400", hash_original_field = "F7BD60B75B29D79B660A2859395C1A24", hash_generated_field = "F637E6EF067851C91D97ED085AD6D7D3")

    public FontSize size;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.996 -0400", hash_original_field = "69DCAB4A73AEEC2113F69B61E6263DA8", hash_generated_field = "A96C5B0A6E9769B51001638F997AB866")

    public boolean bold;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.996 -0400", hash_original_field = "030C5B6D1E5715105943AC111D9671BF", hash_generated_field = "0057903D40F2656E1CE8FB3E44BCEBF6")

    public boolean italic;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.996 -0400", hash_original_field = "53D8B12F5A04C848B57A2D303A1DED53", hash_generated_field = "8FC446EF7B95B9F22E5D2FD8CD818E9D")

    public boolean underlined;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.996 -0400", hash_original_field = "6CC60610AFEBF855C4D144261665C2A5", hash_generated_field = "04E5E26C9915A9BBAC1BC323ABB85236")

    public boolean strikeThrough;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.996 -0400", hash_original_field = "70DDA5DFB8053DC6D1C492574BCE9BFD", hash_generated_field = "9D6479F36C8B4E7C114F4D482BE8BC83")

    public TextColor color;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:17.998 -0400", hash_original_method = "4F5520D3BCCB9D14B21693AFF8505891", hash_generated_method = "A9D302A56AE6341504F2B5F68DC283FD")
    public  TextAttribute(int start, int length, TextAlignment align,
            FontSize size, boolean bold, boolean italic, boolean underlined,
            boolean strikeThrough, TextColor color) {
        this.start = start;
        this.length = length;
        this.align = align;
        this.size = size;
        this.bold = bold;
        this.italic = italic;
        this.underlined = underlined;
        this.strikeThrough = strikeThrough;
        this.color = color;
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

