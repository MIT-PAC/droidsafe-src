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

import android.graphics.Canvas;
import android.graphics.Paint;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSModeled;

public class SpannableStringBuilder implements CharSequence, GetChars, Spannable, Editable,
Appendable, GraphicsOperations {
	
	@Override
	@DSModeled(DSC.SAFE)
	public String toString() {
		return new String();
	}

	@Override
	public <T> T[] getSpans(int start, int end, Class<T> type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getSpanStart(Object tag) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getSpanEnd(Object tag) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getSpanFlags(Object tag) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int nextSpanTransition(int start, int limit, Class type) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void drawText(Canvas c, int start, int end, float x, float y, Paint p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void drawTextRun(Canvas c, int start, int end, int contextStart,
			int contextEnd, float x, float y, int flags, Paint p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public float measureText(int start, int end, Paint p) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getTextWidths(int start, int end, float[] widths, Paint p) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getTextRunAdvances(int start, int end, int contextStart,
			int contextEnd, int flags, float[] advances, int advancesIndex,
			Paint paint) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getTextRunAdvances(int start, int end, int contextStart,
			int contextEnd, int flags, float[] advances, int advancesIndex,
			Paint paint, int reserved) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getTextRunCursor(int contextStart, int contextEnd, int flags,
			int offset, int cursorOpt, Paint p) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Editable replace(int st, int en, CharSequence source, int start,
			int end) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Editable replace(int st, int en, CharSequence text) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Editable insert(int where, CharSequence text, int start, int end) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Editable insert(int where, CharSequence text) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Editable delete(int st, int en) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Editable append(CharSequence text) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Editable append(CharSequence text, int start, int end) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Editable append(char text) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clearSpans() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setFilters(InputFilter[] filters) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public InputFilter[] getFilters() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setSpan(Object what, int start, int end, int flags) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeSpan(Object what) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getChars(int start, int end, char[] dest, int destoff) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int length() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public char charAt(int index) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public CharSequence subSequence(int start, int end) {
		// TODO Auto-generated method stub
		return null;
	}

}
