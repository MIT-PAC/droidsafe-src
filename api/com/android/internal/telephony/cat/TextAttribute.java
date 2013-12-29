package com.android.internal.telephony.cat;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;



public class TextAttribute {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:26.608 -0500", hash_original_field = "A420862623A673AB42FCEC90A616158F", hash_generated_field = "D3D73C9CC2FDA0D0E8781D6E9A3253AA")

    public int start;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:26.609 -0500", hash_original_field = "136C4DD872F8065EECD33F6CD4E7556E", hash_generated_field = "1125768121756783FBBAD7831AFCFE31")

    public int length;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:26.609 -0500", hash_original_field = "BEB8751D1961E3E16C64F4D95213DF02", hash_generated_field = "D9C7E3610C11CF71DEC061C08CF0E9A0")

    public TextAlignment align;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:26.610 -0500", hash_original_field = "5B6C4D32AE81085A7C5F1C0D463CC6E0", hash_generated_field = "F637E6EF067851C91D97ED085AD6D7D3")

    public FontSize size;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:26.611 -0500", hash_original_field = "C53DC8751F677350C4748133DCC79F16", hash_generated_field = "A96C5B0A6E9769B51001638F997AB866")

    public boolean bold;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:26.612 -0500", hash_original_field = "A13240A1EA36A867FBEBFDE008B6BF85", hash_generated_field = "0057903D40F2656E1CE8FB3E44BCEBF6")

    public boolean italic;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:26.613 -0500", hash_original_field = "64E014CBB0BA5054E83EA36C87341DF4", hash_generated_field = "8FC446EF7B95B9F22E5D2FD8CD818E9D")

    public boolean underlined;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:26.613 -0500", hash_original_field = "C69B981592EB905470C00D027295259A", hash_generated_field = "04E5E26C9915A9BBAC1BC323ABB85236")

    public boolean strikeThrough;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:26.614 -0500", hash_original_field = "2444A8C8DFC96D0BDBBBAFDFF83AF2AE", hash_generated_field = "9D6479F36C8B4E7C114F4D482BE8BC83")

    public TextColor color;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:26.615 -0500", hash_original_method = "4F5520D3BCCB9D14B21693AFF8505891", hash_generated_method = "F08E34470AF0997BF7B352FD5DEF5A6D")
    public TextAttribute(int start, int length, TextAlignment align,
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
    }

    
}

