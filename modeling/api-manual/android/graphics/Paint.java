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


package android.graphics;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSModeled;

/*
 * Refactored the original Paint model to be more streamlined.  Also cut over the native
 * getter/setter methods to non-native and added taint tracking to them.
 * 
 * @author sgraf
 */

public class Paint {
	
	
	@DSModeled(DSC.SAFE)
    public void setFlags(int flags) {  //Originally a native method, converted over
		addTaint(flags);
	}
	
	@DSModeled(value = DSC.SAFE)
	public int getFlags() {  //Originally a native method, converted over
		return getTaintInt();
	}
	
	@DSModeled(DSC.SAFE)
    public Paint(int flags) {
		setFlags(flags);
		/*
        mNativePaint = native_init();
        setFlags(flags | DEFAULT_PAINT_FLAGS);
        mCompatScaling = mInvCompatScaling = 1;
        */
    }
	
	@DSModeled(DSC.SAFE)
    public Paint() {
        //this(0);  No real need to flow down into second constructor which would track taint, since it's a fixed value
    }
	
	@DSModeled(value = DSC.SAFE)
	public void setColor(int color) { //Originally a native method, converted over
		addTaint(color);
	}
	
	@DSModeled(value = DSC.SAFE)
	public int getColor() {  //Originally a native method, converted over
		return getTaintInt();
	}
	
	@DSModeled(value = DSC.SAFE)
	public float measureText(char[] text, int index, int count) {
		return 0;  //Is purely a computational function and doesn't appear to change any values/state
		/*
        if (text == null) {
            throw new IllegalArgumentException("text cannot be null");
        }
        if ((index | count) < 0 || index + count > text.length) {
            throw new ArrayIndexOutOfBoundsException();
        }

        if (text.length == 0 || count == 0) {
            return 0f;
        }
        if (!mHasCompatScaling) {
            return native_measureText(text, index, count);
        }

        final float oldSize = getTextSize();
        setTextSize(oldSize*mCompatScaling);
        float w = native_measureText(text, index, count);
        setTextSize(oldSize);
        return w*mInvCompatScaling;
        */
    }
	
	@DSModeled(value = DSC.SAFE)
	public float measureText(String text) {
		return 0;  //Is purely a computational function and doesn't appear to change any values/state
		/*
        if (text == null) {
            throw new IllegalArgumentException("text cannot be null");
        }

        if (text.length() == 0) {
            return 0f;
        }

        if (!mHasCompatScaling) return native_measureText(text);
        final float oldSize = getTextSize();
        setTextSize(oldSize*mCompatScaling);
        float w = native_measureText(text);
        setTextSize(oldSize);
        return w*mInvCompatScaling;
        */
    }
	
	@DSModeled(DSC.SAFE)
	public void setAntiAlias(boolean aa) {
		//Helper for setFlags(), setting or clearing the ANTI_ALIAS_FLAG bit
		addTaint(aa);
	}
	
	public void setFilterBitmap(boolean filter) {
		//Don't think we need to perform any tainting
		//filter true to set the FILTER_BITMAP_FLAG bit in the paint's flags, false to clear it.
	}
	
	@DSModeled(DSC.SAFE)
	@Override
    protected void finalize() throws Throwable {
		super.finalize();
		/*
        try {
            finalizer(mNativePaint);
        } finally {
            super.finalize();
        }
        */
    }
}
