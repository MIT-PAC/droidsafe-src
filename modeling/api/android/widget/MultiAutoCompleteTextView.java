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
 * Copyright (C) 2007 The Android Open Source Project
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

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.content.Context;
import android.text.Editable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.QwertyKeyListener;
import android.util.AttributeSet;

public class MultiAutoCompleteTextView extends AutoCompleteTextView {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:58.616 -0500", hash_original_field = "782DFD3BFEBE1EC21FE0DFA4A07ABD54", hash_generated_field = "DC05FA21DC7A9D97C12BF9C7B68E4314")

    private Tokenizer mTokenizer;

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:58.618 -0500", hash_original_method = "94554F2B341FB5EE45055739E2680C3D", hash_generated_method = "C2F49C3CAFFC526DD205A72441BE92F0")
    
public MultiAutoCompleteTextView(Context context) {
        this(context, null);
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:58.621 -0500", hash_original_method = "42976CB810392B93881A9DEB6E0BA159", hash_generated_method = "A6B2BA027B1DC0B0A5DF3B4D6B203004")
    
public MultiAutoCompleteTextView(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.autoCompleteTextViewStyle);
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:58.623 -0500", hash_original_method = "C6A2FA85257B49A1F6B493810F60209F", hash_generated_method = "4BACF8B5978871C953956D2130A61715")
    
public MultiAutoCompleteTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:58.625 -0500", hash_original_method = "BCA16A32890B669BA239C7F8E91B803C", hash_generated_method = "BCA16A32890B669BA239C7F8E91B803C")
    
void finishInit() { }

    /**
     * Sets the Tokenizer that will be used to determine the relevant
     * range of the text where the user is typing.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:58.627 -0500", hash_original_method = "0C1CB9531D2E188C8CD299E678A81235", hash_generated_method = "CFEFBD07EFD51DC38E45D8740B5CD2ED")
    
public void setTokenizer(Tokenizer t) {
        mTokenizer = t;
    }

    /**
     * Instead of filtering on the entire contents of the edit box,
     * this subclass method filters on the range from
     * {@link Tokenizer#findTokenStart} to {@link #getSelectionEnd}
     * if the length of that range meets or exceeds {@link #getThreshold}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:58.630 -0500", hash_original_method = "D73EB2C94DEE4722FCE1B5247E851200", hash_generated_method = "0D5146E8312D9D5881F63C790ACC0C09")
    
@Override
    protected void performFiltering(CharSequence text, int keyCode) {
        if (enoughToFilter()) {
            int end = getSelectionEnd();
            int start = mTokenizer.findTokenStart(text, end);

            performFiltering(text, start, end, keyCode);
        } else {
            dismissDropDown();

            Filter f = getFilter();
            if (f != null) {
                f.filter(null);
            }
        }
    }

    /**
     * Instead of filtering whenever the total length of the text
     * exceeds the threshhold, this subclass filters only when the
     * length of the range from
     * {@link Tokenizer#findTokenStart} to {@link #getSelectionEnd}
     * meets or exceeds {@link #getThreshold}.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:58.632 -0500", hash_original_method = "4B7E111CDE46EB7665419BBE701F6868", hash_generated_method = "5AF05FDD7F3944E020E9499E3021F972")
    
@Override
    public boolean enoughToFilter() {
        Editable text = getText();

        int end = getSelectionEnd();
        if (end < 0 || mTokenizer == null) {
            return false;
        }

        int start = mTokenizer.findTokenStart(text, end);

        if (end - start >= getThreshold()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Instead of validating the entire text, this subclass method validates
     * each token of the text individually.  Empty tokens are removed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:58.635 -0500", hash_original_method = "5C2EFC56A6F7A7D1FB121838E719CAA2", hash_generated_method = "8C2DBEF647C385CA159DBDC7745537E1")
    
@Override
    public void performValidation() {
        Validator v = getValidator();

        if (v == null || mTokenizer == null) {
            return;
        }

        Editable e = getText();
        int i = getText().length();
        while (i > 0) {
            int start = mTokenizer.findTokenStart(e, i);
            int end = mTokenizer.findTokenEnd(e, start);

            CharSequence sub = e.subSequence(start, end);
            if (TextUtils.isEmpty(sub)) {
                e.replace(start, i, "");
            } else if (!v.isValid(sub)) {
                e.replace(start, i,
                          mTokenizer.terminateToken(v.fixText(sub)));
            }

            i = start;
        }
    }

    /**
     * <p>Starts filtering the content of the drop down list. The filtering
     * pattern is the specified range of text from the edit box. Subclasses may
     * override this method to filter with a different pattern, for
     * instance a smaller substring of <code>text</code>.</p>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:58.637 -0500", hash_original_method = "448D969C1E669B05B875BF81D75455EA", hash_generated_method = "FF28BAFFF03983213F7C0B3A60D18F28")
    
protected void performFiltering(CharSequence text, int start, int end,
                                    int keyCode) {
        getFilter().filter(text.subSequence(start, end), this);
    }

    /**
     * <p>Performs the text completion by replacing the range from
     * {@link Tokenizer#findTokenStart} to {@link #getSelectionEnd} by the
     * the result of passing <code>text</code> through
     * {@link Tokenizer#terminateToken}.
     * In addition, the replaced region will be marked as an AutoText
     * substition so that if the user immediately presses DEL, the
     * completion will be undone.
     * Subclasses may override this method to do some different
     * insertion of the content into the edit box.</p>
     *
     * @param text the selected suggestion in the drop down list
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:58.640 -0500", hash_original_method = "0BC14D3B618E827E554DDB675E2805A0", hash_generated_method = "FD34D90B04008B9817C9A793A477AB63")
    
@Override
    protected void replaceText(CharSequence text) {
        clearComposingText();

        int end = getSelectionEnd();
        int start = mTokenizer.findTokenStart(getText(), end);

        Editable editable = getText();
        String original = TextUtils.substring(editable, start, end);

        QwertyKeyListener.markAsReplaced(editable, start, end, original);
        editable.replace(start, end, mTokenizer.terminateToken(text));
    }
    
    public static class CommaTokenizer implements Tokenizer {
        
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:02.368 -0400", hash_original_method = "F4BA1DCA501F72677108996A68C84C7B", hash_generated_method = "F4BA1DCA501F72677108996A68C84C7B")
        public CommaTokenizer ()
        {
            //Synthesized constructor
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:58.646 -0500", hash_original_method = "280529F27A16CE7436996477971C2C62", hash_generated_method = "DC26E71C45109D6661B28E19F2FCD5A8")
        
public int findTokenStart(CharSequence text, int cursor) {
            int i = cursor;

            while (i > 0 && text.charAt(i - 1) != ',') {
                i--;
            }
            while (i < cursor && text.charAt(i) == ' ') {
                i++;
            }

            return i;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:58.648 -0500", hash_original_method = "4F25D72B16DCF82C04DD0624B35F7FC4", hash_generated_method = "E17625C514273A4C77DDDE81FF22D766")
        
public int findTokenEnd(CharSequence text, int cursor) {
            int i = cursor;
            int len = text.length();

            while (i < len) {
                if (text.charAt(i) == ',') {
                    return i;
                } else {
                    i++;
                }
            }

            return len;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:58.651 -0500", hash_original_method = "C1C1FDB4C90D17F74901681402AEE8BB", hash_generated_method = "289CCB6DEEDB18FBE88F6E92D253EABB")
        
public CharSequence terminateToken(CharSequence text) {
            int i = text.length();

            while (i > 0 && text.charAt(i - 1) == ' ') {
                i--;
            }

            if (i > 0 && text.charAt(i - 1) == ',') {
                return text;
            } else {
                if (text instanceof Spanned) {
                    SpannableString sp = new SpannableString(text + ", ");
                    TextUtils.copySpansFrom((Spanned) text, 0, text.length(),
                                            Object.class, sp, 0);
                    return sp;
                } else {
                    return text + ", ";
                }
            }
        }
        
    }
    
    public static interface Tokenizer {
        
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public int findTokenStart(CharSequence text, int cursor);
        
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public int findTokenEnd(CharSequence text, int cursor);
        
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public CharSequence terminateToken(CharSequence text);
    }
    
}

