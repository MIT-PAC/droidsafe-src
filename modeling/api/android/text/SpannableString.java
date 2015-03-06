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


package android.text;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class SpannableString extends SpannableStringInternal implements CharSequence, GetChars, Spannable {

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:14.067 -0500", hash_original_method = "90012DFD660EB52D22F0B732AA7864A9", hash_generated_method = "E865D88B944D0050BC86EF2B1CE2F561")
    
public static SpannableString valueOf(CharSequence source) {
        if (source instanceof SpannableString) {
            return (SpannableString) source;
        } else {
            return new SpannableString(source);
        }
    }
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:14.061 -0500", hash_original_method = "E921164C349820CE913ADCB9FC3ECE8D", hash_generated_method = "E7827C9A51F3947C52363F7F7A63868F")
    
public SpannableString(CharSequence source) {
        super(source, 0, source.length());
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:14.064 -0500", hash_original_method = "CFA97E25B40B182279BF16FEA76606C4", hash_generated_method = "5E9A332CDC5FDCFABB848DE886135BBA")
    
private SpannableString(CharSequence source, int start, int end) {
        super(source, start, end);
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:14.069 -0500", hash_original_method = "703A4E3A5DC432A077E52C12DF31C39D", hash_generated_method = "981E2E06E7D4115A0BFC2D189CC2436C")
    
public void setSpan(Object what, int start, int end, int flags) {
        super.setSpan(what, start, end, flags);
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:14.072 -0500", hash_original_method = "A032FB453304A8E0F8BC7978F037ECF6", hash_generated_method = "AAC83A74F207840707B5FE26AE6DE953")
    
public void removeSpan(Object what) {
        super.removeSpan(what);
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:14.075 -0500", hash_original_method = "2D77EB0B8B2B37960A9B77E6DDEED655", hash_generated_method = "7D96E1C66DED8CD342ADC6C1F18B8170")
    
public final CharSequence subSequence(int start, int end) {
        return new SpannableString(this, start, end);
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public int getSpanEnd(Object what) {
    	addTaint(what.getTaint());
    	return super.getSpanEnd(what);
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public int getSpanFlags(Object what) {
    	addTaint(what.getTaint());
    	return super.getSpanFlags(what);
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public int getSpanStart(Object what) {
    	addTaint(what.getTaint());
    	return super.getSpanStart(what);
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public int nextSpanTransition(int start, int limit, Class kind) {
    	addTaint(start);
    	addTaint(limit);
    	addTaint(kind.getTaint());
    	return super.nextSpanTransition(start, limit, kind);
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public <T> T[] getSpans(int queryStart, int queryEnd, Class<T> kind) {
    	addTaint(queryStart);
    	addTaint(queryEnd);
    	addTaint(kind.getTaint());
    	return super.getSpans(queryStart, queryEnd, kind);
    }
}

