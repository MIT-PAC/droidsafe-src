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
 * Copyright (C) 2008 The Android Open Source Project
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


package android.text;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface InputType {
    
    public static final int TYPE_MASK_CLASS = 0x0000000f;
    
    
    public static final int TYPE_MASK_VARIATION = 0x00000ff0;
    
    
    public static final int TYPE_MASK_FLAGS = 0x00fff000;
    
    
    public static final int TYPE_NULL = 0x00000000;
    
    
    
    
    
    
    public static final int TYPE_CLASS_TEXT = 0x00000001;
    
    
    public static final int TYPE_TEXT_FLAG_CAP_CHARACTERS = 0x00001000;
    
    
    public static final int TYPE_TEXT_FLAG_CAP_WORDS = 0x00002000;
    
    
    public static final int TYPE_TEXT_FLAG_CAP_SENTENCES = 0x00004000;
    
    
    public static final int TYPE_TEXT_FLAG_AUTO_CORRECT = 0x00008000;
    
    
    public static final int TYPE_TEXT_FLAG_AUTO_COMPLETE = 0x00010000;
    
    
    public static final int TYPE_TEXT_FLAG_MULTI_LINE = 0x00020000;
    
    
    public static final int TYPE_TEXT_FLAG_IME_MULTI_LINE = 0x00040000;
    
    
    public static final int TYPE_TEXT_FLAG_NO_SUGGESTIONS = 0x00080000;

    
    
    
    public static final int TYPE_TEXT_VARIATION_NORMAL = 0x00000000;
    
    
    public static final int TYPE_TEXT_VARIATION_URI = 0x00000010;
    
    
    public static final int TYPE_TEXT_VARIATION_EMAIL_ADDRESS = 0x00000020;
    
    
    public static final int TYPE_TEXT_VARIATION_EMAIL_SUBJECT = 0x00000030;
    
    
    public static final int TYPE_TEXT_VARIATION_SHORT_MESSAGE = 0x00000040;
    
    
    public static final int TYPE_TEXT_VARIATION_LONG_MESSAGE = 0x00000050;

    
    public static final int TYPE_TEXT_VARIATION_PERSON_NAME = 0x00000060;
    
    
    public static final int TYPE_TEXT_VARIATION_POSTAL_ADDRESS = 0x00000070;
    
    
    public static final int TYPE_TEXT_VARIATION_PASSWORD = 0x00000080;
    
    
    public static final int TYPE_TEXT_VARIATION_VISIBLE_PASSWORD = 0x00000090;
    
    
    public static final int TYPE_TEXT_VARIATION_WEB_EDIT_TEXT = 0x000000a0;
    
    
    public static final int TYPE_TEXT_VARIATION_FILTER = 0x000000b0;
    
    
    public static final int TYPE_TEXT_VARIATION_PHONETIC = 0x000000c0;
    
    
    public static final int TYPE_TEXT_VARIATION_WEB_EMAIL_ADDRESS = 0x000000d0;

    
    public static final int TYPE_TEXT_VARIATION_WEB_PASSWORD = 0x000000e0;

    
    
    
    
    
    public static final int TYPE_CLASS_NUMBER = 0x00000002;
    
    
    public static final int TYPE_NUMBER_FLAG_SIGNED = 0x00001000;
    
    
    public static final int TYPE_NUMBER_FLAG_DECIMAL = 0x00002000;
    
    

    
    public static final int TYPE_NUMBER_VARIATION_NORMAL = 0x00000000;

    
    public static final int TYPE_NUMBER_VARIATION_PASSWORD = 0x00000010;

    
    
    
    
    
    public static final int TYPE_CLASS_PHONE = 0x00000003;
    
    
    
    
    
    
    public static final int TYPE_CLASS_DATETIME = 0x00000004;
    
    
    public static final int TYPE_DATETIME_VARIATION_NORMAL = 0x00000000;
    
    
    public static final int TYPE_DATETIME_VARIATION_DATE = 0x00000010;
    
    
    public static final int TYPE_DATETIME_VARIATION_TIME = 0x00000020;
}
