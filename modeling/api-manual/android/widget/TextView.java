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


package android.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.RemoteViews.RemoteView;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSModeled;
//import android.text.TextUtils.TruncateAt; //DSFIXME:  Commented this out...
//import android.view.ViewGroup.LayoutParams;

@RemoteView
public class TextView extends View implements ViewTreeObserver.OnPreDrawListener {
	static final String LOG_TAG = "TextView";
    static final boolean DEBUG_EXTRACT = false;
    
    private static final int SIGNED = 2;
    private static final int DECIMAL = 4;
    private static final int PRIORITY = 100;
    private static final int PREDRAW_NOT_REGISTERED = 0;
    private static final int PREDRAW_PENDING = 1;
    private static final int PREDRAW_DONE = 2;
    private static final int MARQUEE_FADE_NORMAL = 0;
    private static final int MARQUEE_FADE_SWITCH_SHOW_ELLIPSIS = 1;
    private static final int MARQUEE_FADE_SWITCH_SHOW_FADE = 2;
    
    private int mPreDrawState = PREDRAW_NOT_REGISTERED;

    private static enum TextAlign {
        INHERIT, GRAVITY, TEXT_START, TEXT_END, CENTER, VIEW_START, VIEW_END;
    }
    
    static {
        Paint p = new Paint();
        p.setAntiAlias(true);
        // We don't care about the result, just the side-effect of measuring.
        p.measureText("H");
    }
    
    @DSModeled(DSC.SAFE)
    public TextView(Context context) {
        this(context, null);
    }

    @DSModeled(DSC.SAFE)
    public TextView(Context context,
                    AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.textViewStyle);
    }

    @DSModeled(DSC.SAFE)
    @SuppressWarnings("deprecation")
    public TextView(Context context,
                    AttributeSet attrs,
                    int defStyle) {
        super(context, attrs, defStyle);
        /*
         * For the most part, this function initializes a multitude of internal structures
         * and state.  It is also an extremely long function, so the original implementation
         * is not going to be included.
         */
    }

	@Override
	public boolean onPreDraw() {
		return true;
		/*
        if (mPreDrawState != PREDRAW_PENDING) {
            return true;
        }

        if (mLayout == null) {
            assumeLayout();
        }

        boolean changed = false;

        if (mMovement != null) {
            int curs = getSelectionEnd();
            // Do not create the controller if it is not already created.
            if (mSelectionModifierCursorController != null &&
                    mSelectionModifierCursorController.isSelectionStartDragged()) {
                curs = getSelectionStart();
            }

            if (curs < 0 &&
                  (mGravity & Gravity.VERTICAL_GRAVITY_MASK) == Gravity.BOTTOM) {
                curs = mText.length();
            }

            if (curs >= 0) {
                changed = bringPointIntoView(curs);
            }
        } else {
            changed = bringTextIntoView();
        }

        // This has to be checked here since:
        // - onFocusChanged cannot start it when focus is given to a view with selected text (after
        //   a screen rotation) since layout is not yet initialized at that point.
        if (mCreatedWithASelection) {
            startSelectionActionMode();
            mCreatedWithASelection = false;
        }

        // Phone specific code (there is no ExtractEditText on tablets).
        // ExtractEditText does not call onFocus when it is displayed, and mHasSelectionOnFocus can
        // not be set. Do the test here instead.
        if (this instanceof ExtractEditText && hasSelection()) {
            startSelectionActionMode();
        }

        mPreDrawState = PREDRAW_DONE;
        return !changed;
        */
    }
	
	@DSModeled(DSC.SAFE)
	@android.view.RemotableViewMethod
    public final void setText(CharSequence text) {
		setText(text, BufferType.NORMAL);
        //setText(text, mBufferType);
    }
	
	@DSModeled(DSC.SAFE)
	public void setText(CharSequence text, BufferType type) {
        setText(text, type, true, 0);
        /*
        if (mCharWrapper != null) {
            mCharWrapper.mChars = null;
        }
        */
    }
	
	private CharSequence mText;
	private BufferType mBufferType;
	
	@DSModeled(DSC.SAFE)
	private void setText(CharSequence text, BufferType type,
            boolean notifyBefore, int oldlen) {
		addTaint(text.toString().getTaint());
		addTaint(type.toString().getTaint());
	}
	
	public enum BufferType {
		NORMAL, SPANNABLE, EDITABLE;
		
		@DSModeled(DSC.SAFE)
		BufferType() {
			//Not in the original implementation, added for specdump
		}
    }
	
	@DSModeled(DSC.SAFE)
	@Override
    protected void onDraw(Canvas canvas) {
		//DSFIXME:  Stubbed out method for now.  Underlying function is very large.
		super.onDraw(canvas);
	}
	
	@DSModeled(DSC.SAFE)
	public CharSequence getText() {
        String str = new String();
        str.addTaint(getTaint());
        return str;
    }
}
