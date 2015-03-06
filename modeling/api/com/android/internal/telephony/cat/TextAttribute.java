/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 * 
 * 
 * This file incorporates work covered by the following copyright and
 * permission notice:
 *
 * Copyright (C) 2006 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package com.android.internal.telephony.cat;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;



public class TextAttribute {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:07.662 -0500", hash_original_field = "A420862623A673AB42FCEC90A616158F", hash_generated_field = "D3D73C9CC2FDA0D0E8781D6E9A3253AA")

    public int start;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:07.665 -0500", hash_original_field = "136C4DD872F8065EECD33F6CD4E7556E", hash_generated_field = "1125768121756783FBBAD7831AFCFE31")

    public int length;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:07.667 -0500", hash_original_field = "BEB8751D1961E3E16C64F4D95213DF02", hash_generated_field = "D9C7E3610C11CF71DEC061C08CF0E9A0")

    public TextAlignment align;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:07.669 -0500", hash_original_field = "5B6C4D32AE81085A7C5F1C0D463CC6E0", hash_generated_field = "F637E6EF067851C91D97ED085AD6D7D3")

    public FontSize size;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:07.671 -0500", hash_original_field = "C53DC8751F677350C4748133DCC79F16", hash_generated_field = "A96C5B0A6E9769B51001638F997AB866")

    public boolean bold;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:07.673 -0500", hash_original_field = "A13240A1EA36A867FBEBFDE008B6BF85", hash_generated_field = "0057903D40F2656E1CE8FB3E44BCEBF6")

    public boolean italic;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:07.675 -0500", hash_original_field = "64E014CBB0BA5054E83EA36C87341DF4", hash_generated_field = "8FC446EF7B95B9F22E5D2FD8CD818E9D")

    public boolean underlined;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:07.678 -0500", hash_original_field = "C69B981592EB905470C00D027295259A", hash_generated_field = "04E5E26C9915A9BBAC1BC323ABB85236")

    public boolean strikeThrough;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:07.681 -0500", hash_original_field = "2444A8C8DFC96D0BDBBBAFDFF83AF2AE", hash_generated_field = "9D6479F36C8B4E7C114F4D482BE8BC83")

    public TextColor color;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:07.683 -0500", hash_original_method = "4F5520D3BCCB9D14B21693AFF8505891", hash_generated_method = "F08E34470AF0997BF7B352FD5DEF5A6D")
    
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

