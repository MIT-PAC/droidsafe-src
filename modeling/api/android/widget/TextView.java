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

// Droidsafe Imports
import droidsafe.annotations.*;
import droidsafe.helpers.*;
import droidsafe.runtime.*;

import com.android.internal.R;

import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.CompatibilityInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.inputmethodservice.ExtractEditText;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.BoringLayout;
import android.text.DynamicLayout;
import android.text.Editable;
import android.text.GetChars;
import android.text.GraphicsOperations;
import android.text.InputFilter;
import android.text.InputType;
import android.text.Layout;
import android.text.ParcelableSpan;
import android.text.Selection;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.SpannedString;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.TextWatcher;
import android.text.method.AllCapsTransformationMethod;
import android.text.method.ArrowKeyMovementMethod;
import android.text.method.DateKeyListener;
import android.text.method.DateTimeKeyListener;
import android.text.method.DialerKeyListener;
import android.text.method.DigitsKeyListener;
import android.text.method.KeyListener;
import android.text.method.LinkMovementMethod;
import android.text.method.MetaKeyKeyListener;
import android.text.method.MovementMethod;
import android.text.method.PasswordTransformationMethod;
import android.text.method.SingleLineTransformationMethod;
import android.text.method.TextKeyListener;
import android.text.method.TimeKeyListener;
import android.text.method.TransformationMethod;
import android.text.method.TransformationMethod2;
import android.text.method.WordIterator;
import android.text.style.ClickableSpan;
import android.text.style.EasyEditSpan;
import android.text.style.ParagraphStyle;
import android.text.style.SpellCheckSpan;
import android.text.style.SuggestionRangeSpan;
import android.text.style.SuggestionSpan;
import android.text.style.TextAppearanceSpan;
import android.text.style.URLSpan;
import android.text.style.UpdateAppearance;
import android.text.util.Linkify;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.FloatMath;
import android.util.Log;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.DragEvent;
import android.view.Gravity;
import android.view.HapticFeedbackConstants;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.ViewRootImpl;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.CompletionInfo;
import android.view.inputmethod.CorrectionInfo;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.ExtractedTextRequest;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.view.textservice.SpellCheckerSubtype;
import android.view.textservice.TextServicesManager;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.RemoteViews.RemoteView;

import com.android.internal.util.FastMath;
import com.android.internal.widget.EditableInputConnection;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Locale;

public class TextView extends View implements ViewTreeObserver.OnPreDrawListener {

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.900 -0500", hash_original_method = "CF798DBA236922C7D3F20B562F3C113C", hash_generated_method = "6EB0B365903FFEA482F4C4B0A27940DE")
    
private static boolean isMultilineInputType(int type) {
        return (type & (EditorInfo.TYPE_MASK_CLASS | EditorInfo.TYPE_TEXT_FLAG_MULTI_LINE)) ==
            (EditorInfo.TYPE_CLASS_TEXT | EditorInfo.TYPE_TEXT_FLAG_MULTI_LINE);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.907 -0500", hash_original_method = "E0A9182B87E4303FDDF2B8B7ED0929E4", hash_generated_method = "FC94ED4940EE725651B02473EC2D27D2")
    
private static boolean isPasswordInputType(int inputType) {
        final int variation =
                inputType & (EditorInfo.TYPE_MASK_CLASS | EditorInfo.TYPE_MASK_VARIATION);
        return variation
                == (EditorInfo.TYPE_CLASS_TEXT | EditorInfo.TYPE_TEXT_VARIATION_PASSWORD)
                || variation
                == (EditorInfo.TYPE_CLASS_TEXT | EditorInfo.TYPE_TEXT_VARIATION_WEB_PASSWORD)
                || variation
                == (EditorInfo.TYPE_CLASS_NUMBER | EditorInfo.TYPE_NUMBER_VARIATION_PASSWORD);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.910 -0500", hash_original_method = "184D7B00FEDEC84189B51C8F1682F683", hash_generated_method = "40626CA272A26BF73AE4224D8B70099C")
    
private static boolean isVisiblePasswordInputType(int inputType) {
        final int variation =
                inputType & (EditorInfo.TYPE_MASK_CLASS | EditorInfo.TYPE_MASK_VARIATION);
        return variation
                == (EditorInfo.TYPE_CLASS_TEXT | EditorInfo.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
    }
    
    /**
     * This is used to remove all style-impacting spans from text before new
     * extracted text is being replaced into it, so that we don't have any
     * lingering spans applied during the replace.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.137 -0500", hash_original_method = "19B083F16A9E6F8D7C9301AD2E77499E", hash_generated_method = "84E0D74E88344C70AC04251A53043A8C")
    
static void removeParcelableSpans(Spannable spannable, int start, int end) {
        Object[] spans = spannable.getSpans(start, end, ParcelableSpan.class);
        int i = spans.length;
        while (i > 0) {
            i--;
            spannable.removeSpan(spans[i]);
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.227 -0500", hash_original_method = "96CB246721D7A29D66FE7CD97D8BA203", hash_generated_method = "AF1F0773BB4870C5B9F974E47AAACA5D")
    
private static int desired(Layout layout) {
        int n = layout.getLineCount();
        CharSequence text = layout.getText();
        float max = 0;

        // if any line was wrapped, we can't use it.
        // but it's ok for the last line not to have a newline

        for (int i = 0; i < n - 1; i++) {
            if (text.charAt(layout.getLineEnd(i) - 1) != '\n')
                return -1;
        }

        for (int i = 0; i < n; i++) {
            max = Math.max(max, layout.getLineWidth(i));
        }

        return (int) FloatMath.ceil(max);
    }

    /**
     * Returns the TextView_textColor attribute from the
     * Resources.StyledAttributes, if set, or the TextAppearance_textColor
     * from the TextView_textAppearance attribute, if TextView_textColor
     * was not set directly.
     */
    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.660 -0500", hash_original_method = "610DF4562C72E9710D612FAA54D67DFE", hash_generated_method = "A75A6D7F80F1F0271AD4582D7821E552")
    
public static ColorStateList getTextColors(Context context, TypedArray attrs) {
        ColorStateList colors;
        colors = attrs.getColorStateList(com.android.internal.R.styleable.
                                         TextView_textColor);

        if (colors == null) {
            int ap = attrs.getResourceId(com.android.internal.R.styleable.
                                         TextView_textAppearance, -1);
            if (ap != -1) {
                TypedArray appearance;
                appearance = context.obtainStyledAttributes(ap,
                                            com.android.internal.R.styleable.TextAppearance);
                colors = appearance.getColorStateList(com.android.internal.R.styleable.
                                                  TextAppearance_textColor);
                appearance.recycle();
            }
        }

        return colors;
    }

    /**
     * Returns the default color from the TextView_textColor attribute
     * from the AttributeSet, if set, or the default color from the
     * TextAppearance_textColor from the TextView_textAppearance attribute,
     * if TextView_textColor was not set directly.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.662 -0500", hash_original_method = "97B35435029E9835DF5CDCF17B9F2F51", hash_generated_method = "73EE96094A2B5463D96C2ABCBBBBB25C")
    
public static int getTextColor(Context context,
                                   TypedArray attrs,
                                   int def) {
        ColorStateList colors = getTextColors(context, attrs);

        if (colors == null) {
            return def;
        } else {
            return colors.getDefaultColor();
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.679 -0500", hash_original_method = "6CF90DF2EC40ED00D80E18C1F33E11BC", hash_generated_method = "5FA359866299A35489C3737B61CC9E43")
    
private static long packRangeInLong(int start, int end) {
        return (((long) start) << 32) | end;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.681 -0500", hash_original_method = "B8457D164A465BC6DBF90754C8516687", hash_generated_method = "EC410F8EAE725FE659DD2D2EFBCDB07E")
    
private static int extractRangeStartFromLong(long range) {
        return (int) (range >>> 32);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.683 -0500", hash_original_method = "F1A2938AD077ADF89D5A8BD63BAC91E0", hash_generated_method = "644C64A378737B0C013497F66056F5D5")
    
private static int extractRangeEndFromLong(long range) {
        return (int) (range & 0x00000000FFFFFFFFL);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.307 -0500", hash_original_field = "DF2F61116F97F2B3C3FB2856992E9A40", hash_generated_field = "318C0D140A347FB72B8CF35CDBABB5E4")

    static final String LOG_TAG = "TextView";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.309 -0500", hash_original_field = "B7B864FF11E5822ABA471499318E4450", hash_generated_field = "8F4574CB2F6E43394A5BA522A2B5B852")

    static final boolean DEBUG_EXTRACT = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.311 -0500", hash_original_field = "B3134A6C9DB121DBC86BFC6166441E96", hash_generated_field = "0C5EC1740FD044550CD627FFA2580630")

    private static final int PRIORITY = 100;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.350 -0500", hash_original_field = "5E98F29B307A7CE0B5C77018B82916E0", hash_generated_field = "45D348A3F29C90D42A8C5DC6B241EAC1")

    private static final int PREDRAW_NOT_REGISTERED = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.353 -0500", hash_original_field = "BABBDA174DBF305AD32471E79BB4EA5C", hash_generated_field = "62D44753BF78CBC0F9661335F4D5609E")

    private static final int PREDRAW_PENDING = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.355 -0500", hash_original_field = "9F43306CF08782611EA9541FAD000D94", hash_generated_field = "363B97B9FD402B0FDBC0C24AF5E9CCFB")

    private static final int PREDRAW_DONE = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.363 -0500", hash_original_field = "6E1FD7DF3E1622E164C31BB68A6FD043", hash_generated_field = "3ADE3952E67B8B5E351AD96559D22614")

    // TODO: How can we get this from the XML instead of hardcoding it here?
    private static final int SANS = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.365 -0500", hash_original_field = "75A0F9D31714322C507EC33A93FB0403", hash_generated_field = "AD8E248EA94D9FBB450731AC61EA4CF6")

    private static final int SERIF = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.368 -0500", hash_original_field = "C79FD66B7824EA0B8578C6118F1487E8", hash_generated_field = "1E362376CB7EB57CA2898CE49E4D3589")

    private static final int MONOSPACE = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.370 -0500", hash_original_field = "83068D012EEBFB1211E31595988E5C60", hash_generated_field = "A6B151CF756168A68BAE5F928A9C4121")

    // TODO: How can we get this from the XML instead of hardcoding it here?
    private static final int SIGNED = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.372 -0500", hash_original_field = "40936D5EFB00E6FF4DB46554996330EE", hash_generated_field = "F04391D0E1DECB4D13494A519EEF830A")

    private static final int DECIMAL = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.513 -0500", hash_original_field = "5E95FCF1636E2C1ACF4F4161AB333E6D", hash_generated_field = "0A9F849D4DA2786122725914FA369286")

    private static final int MARQUEE_FADE_NORMAL = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.516 -0500", hash_original_field = "69446EC26F7ABDA7583DE086B20D535F", hash_generated_field = "133D51D3A4503E091F405407040E7EC2")

    private static final int MARQUEE_FADE_SWITCH_SHOW_ELLIPSIS = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.519 -0500", hash_original_field = "2FF34D913A8F20C3CF290969CF364BCE", hash_generated_field = "B9CEA3C7890F9A20881FBE5B1B4F328A")

    private static final int MARQUEE_FADE_SWITCH_SHOW_FADE = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.126 -0500", hash_original_field = "8D558E17489B6D2C099B438866436ED5", hash_generated_field = "809D152A38BBF91CF345EB9A3A2C2FD9")
    
    static final int EXTRACT_NOTHING = -2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.128 -0500", hash_original_field = "8EA9111124941DC0A0D3400714CA16BB", hash_generated_field = "7BA27C744DDFC4A241AE9CAF8C089243")

    static final int EXTRACT_UNKNOWN = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.231 -0500", hash_original_field = "9E7EAE2EF4FA3FD80936BF2D57BD92CD", hash_generated_field = "629A8FC22D1527458B2653CFE43B483D")

    private static final BoringLayout.Metrics UNKNOWN_BORING = new BoringLayout.Metrics();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.720 -0500", hash_original_field = "7442B3EDD950BAFB94C8915F47D8D21C", hash_generated_field = "F08D4DB64B803815AE7522F1172B7B26")

    private static final int ID_SELECT_ALL = android.R.id.selectAll;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.723 -0500", hash_original_field = "2FB38655C3BDC4EFE166119DC73F7B7A", hash_generated_field = "45199D67295B65909EEDA2BE3B9357D0")

    private static final int ID_CUT = android.R.id.cut;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.725 -0500", hash_original_field = "682C2AD0E981EEF5AC33A679322F5AD0", hash_generated_field = "BDD63BE32ED24AFE6036B6E73DCBA9C7")

    private static final int ID_COPY = android.R.id.copy;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.728 -0500", hash_original_field = "E700869349A998683E96A1CBFDD30F56", hash_generated_field = "5F09992E187A3237CB33E9C773AB2BFD")

    private static final int ID_PASTE = android.R.id.paste;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.449 -0500", hash_original_field = "238BEF0DC90C4F048E2E9A26A978C4B9", hash_generated_field = "6B7729A476E0DC23D4228210CAC8F2AF")

    private static final int        LINES = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.452 -0500", hash_original_field = "E691888661FF08A796F93D5FAAC3AA47", hash_generated_field = "38D0380954D68681C2B16AF77B10E2B1")

    private static final int        EMS = LINES;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.454 -0500", hash_original_field = "B40BDB58ECF6968C2248114C134CD621", hash_generated_field = "F3B05802BBCCF9A648D3A31248579690")

    private static final int        PIXELS = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.490 -0500", hash_original_field = "16C377DD24A72A3B7991705B013AE605", hash_generated_field = "F1AA779AD4EF6BDB726801C8FA756FE2")

    private static final RectF      sTempRect = new RectF();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.492 -0500", hash_original_field = "A0672BC0E7B5BD409EEF1BE700009438", hash_generated_field = "B1C3BA47068027642A7B08D73ED520A7")

    private static final float[]    sTmpPosition = new float[2];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.496 -0500", hash_original_field = "58085253038E8651E7D11377DBE103C4", hash_generated_field = "BE987383F3E2A020A9B790ED1BD41CEC")

    private static final int        VERY_WIDE = 1024*1024;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.498 -0500", hash_original_field = "2CB9638D709F3209C935DFF0C087362C", hash_generated_field = "75590DDE5A63D4C5AC8A6BCF800B7F27")

    private static final int        BLINK = 500;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.501 -0500", hash_original_field = "95ED7F4260F6B91A51F75452B47C3723", hash_generated_field = "D83A807392D6236B9C81A46BCD93EAD5")

    private static final int ANIMATED_SCROLL_GAP = 250;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.517 -0500", hash_original_field = "8F8BB2875FCC75EB5D66BC4152125391", hash_generated_field = "EDD7FE0B7D12EE9C3486272F367681B2")

    private static final InputFilter[] NO_FILTERS = new InputFilter[0];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.521 -0500", hash_original_field = "2DBE24DDE871487B6B27644DBAD53FAC", hash_generated_field = "14183BB546091CFA567F945F2B307159")

    private static final Spanned EMPTY_SPANNED = new SpannedString("");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.524 -0500", hash_original_field = "1314FA0C797658EAA93F7B2A8ACE29E1", hash_generated_field = "7034D880E0F4FCBF3812B9BF24C47313")

    private static int DRAG_SHADOW_MAX_TEXT_LENGTH = 20;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.529 -0500", hash_original_field = "DC7C2A6ECA2E8CF016240B5F07AFB115", hash_generated_field = "191F5BCD79A0AB522145FB777A15B556")

    private static long sLastCutOrCopyTime;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.535 -0500", hash_original_field = "5CCAB8B9CDAB31E986AECF2BA7A57C6D", hash_generated_field = "426A62F90365670637A2793B721C0BE6")

    private static final int[] MULTILINE_STATE_SET = { R.attr.state_multiline };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.313 -0500", hash_original_field = "FDBB39DB7FAA6CD848A349921BC51858", hash_generated_field = "695EE05B4D22A341938A08B09254F27D")

    private int mCurrentAlpha = 255;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.315 -0500", hash_original_field = "D9B0D13C40450FC3F14D851B73E25CE9", hash_generated_field = "BAE1383AB87BD7B338A209B29BBF86C2")

    final int[] mTempCoords = new int[2];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.317 -0500", hash_original_field = "9F1BD97088B2257F3EF12D8B258FBB69", hash_generated_field = "9F1BD97088B2257F3EF12D8B258FBB69")

    Rect mTempRect;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.319 -0500", hash_original_field = "B31ADBE0719B7B69EDAEB4A1C7EA7A09", hash_generated_field = "F28951B95CC06B6EA971BC050BE7DE22")

    private ColorStateList mTextColor;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.322 -0500", hash_original_field = "1A8A07EEE22FF4F1A21EA9577A682CF3", hash_generated_field = "DDC7D6F23AA3E68217EEBC390EBBF804")

    private int mCurTextColor;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.324 -0500", hash_original_field = "29302BA5AB3093FA3938531EBD03D5A7", hash_generated_field = "9F10F4704A7B04F2C4871DD09D608BF0")

    private ColorStateList mHintTextColor;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.326 -0500", hash_original_field = "CBC0C3FF4320075C95BB989BF3E240CE", hash_generated_field = "AE6720DC2457713C725D4C56460C9DC2")

    private ColorStateList mLinkTextColor;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.328 -0500", hash_original_field = "2D4130ACE7C5EF0657F7AA64BC453187", hash_generated_field = "5A275158889F26A8351A14A4F8F0D9DD")

    private int mCurHintTextColor;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.330 -0500", hash_original_field = "69E8F5093B256AC76905B95B0BC4C528", hash_generated_field = "8D828812FF76F4DB76DB63A2398AF5C6")

    private boolean mFreezesText;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.332 -0500", hash_original_field = "903B6846EDD5930281E801F3FC8F9705", hash_generated_field = "DC2B1736EBA532012F131A593130D38C")

    private boolean mFrozenWithFocus;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.335 -0500", hash_original_field = "ADA78B2EA07442B6E158B79E9D0AD441", hash_generated_field = "C16E2255547619A01263AC9BE7B2E134")

    private boolean mTemporaryDetach;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.337 -0500", hash_original_field = "DB1D7F443FA80D678E66523E42B8B7FE", hash_generated_field = "5C6A9DB416A74CA58302EC973E49E0E3")

    private boolean mDispatchTemporaryDetach;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.340 -0500", hash_original_field = "FC06855DCF32FF2BA39A61D0BF37E5CB", hash_generated_field = "9EDEB4E5741E85F20A0B3026682B4863")

    private boolean mDiscardNextActionUp = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.342 -0500", hash_original_field = "164338EB9849CDE487DEE0C1D2DB2511", hash_generated_field = "7878E8941BAE988F39F461EEC8B7CCDF")

    private boolean mIgnoreActionUpEvent = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.344 -0500", hash_original_field = "4CE49AA222DB4BBFDC9CBD5A15547D50", hash_generated_field = "6D10B174FA8E858FA02AA86D85663AD4")

    private Editable.Factory mEditableFactory = Editable.Factory.getInstance();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.346 -0500", hash_original_field = "FC8F2A0A4CC43599637ACDA8EDF3CB5F", hash_generated_field = "10200E22D9B91A38418945F375917DF5")

    private Spannable.Factory mSpannableFactory = Spannable.Factory.getInstance();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.441 -0400", hash_original_field = "0021C70065C1D0F5DA3DE4086470A1AC", hash_generated_field = "E95B50404D53A741F5CBE2BA4A3E9431")

    private float mShadowRadius;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.441 -0400", hash_original_field = "C882880E2E13EA27F677D50AEA4C2D30", hash_generated_field = "CC57606479233D9D93ED0B57219ED7CE")

    private float mShadowDx;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.441 -0400", hash_original_field = "F6C0DA7C4DD70FAC183A5D5D940CBEBF", hash_generated_field = "5A526AAA72A41CBD334BF1D9A433DD2D")

    private float mShadowDy;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.357 -0500", hash_original_field = "69634037C4F017BF6902EC61EBEF78D4", hash_generated_field = "A64E4C65A01F6E2CFC767B574B9B2B25")

    private int mPreDrawState = PREDRAW_NOT_REGISTERED;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.360 -0500", hash_original_field = "37D479CE607529567B41813560D0B2E6", hash_generated_field = "4984AF4C2DB23A63F16A5A1F70DBBE23")

    private TextUtils.TruncateAt mEllipsize = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.387 -0500", hash_original_field = "8C7568A5CD3CE7BA3BBB1BC76225A2B9", hash_generated_field = "DA26917F8EABBE7FB6675DEEA4CDD42F")

    private Drawables mDrawables;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.389 -0500", hash_original_field = "04D185E8DA7F8737D1F9D540C4FEFD20", hash_generated_field = "8B5DD3B1B3DD08B759F16C26A18B23CA")

    private CharSequence mError;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.392 -0500", hash_original_field = "9D57D2A225CCFD2ACB4DE64827BDE03E", hash_generated_field = "EA3CC19FBACB277B4E0CFF08BB94E8C5")

    private boolean mErrorWasChanged;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.394 -0500", hash_original_field = "7376C1FD4A4719902023BB5E9E3B3137", hash_generated_field = "3D80774243FE973442F872DD04152DA0")

    private ErrorPopup mPopup;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.397 -0500", hash_original_field = "B02B91E8E2AFCA9BD407B9BB035214F4", hash_generated_field = "6846AAA470F19DD23ADF6122A2BA28EB")

    private boolean mShowErrorAfterAttach;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.399 -0500", hash_original_field = "2315BE3CC53CA3951590C4E47767F14C", hash_generated_field = "ED2A81D0AA757272F61284C94F8CB304")

    private CharWrapper mCharWrapper = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.401 -0500", hash_original_field = "FCB545EE0D45AD494A66740C7823B1F7", hash_generated_field = "89CF3363829B7F18DD131036DE4F0A1D")

    private boolean mSelectionMoved = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.403 -0500", hash_original_field = "685E07B4F63BCFC5928F5B5A69ED4706", hash_generated_field = "B3FE9FD9576C4C98F6C4A561DFC39377")

    private boolean mTouchFocusSelected = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.405 -0500", hash_original_field = "B7FAADCE6F410EF19B72A2EA8DA18F08", hash_generated_field = "E6A1FEE90A4433FD8B74A8F47A5E0E13")

    private Marquee mMarquee;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.407 -0500", hash_original_field = "B7F90A2994AD6EDCEA908BF773BDEB4E", hash_generated_field = "E1D72A00A2DFF52C1CB7FA697FBC9898")

    private boolean mRestartMarquee;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.409 -0500", hash_original_field = "E47F4D5CF89BADC09DC318F600F3CDD4", hash_generated_field = "A706E5A4CE970BDC6898B0827FF2B8CB")

    private int mMarqueeRepeatLimit = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.428 -0500", hash_original_field = "E1403D58E8CC04D062F12EDE2F93FC48", hash_generated_field = "E1403D58E8CC04D062F12EDE2F93FC48")

    InputContentType mInputContentType;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.454 -0500", hash_original_field = "23BEF75E7D0F22ED753350F2B8C53A97", hash_generated_field = "23BEF75E7D0F22ED753350F2B8C53A97")

    InputMethodState mInputMethodState;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.456 -0500", hash_original_field = "BB8D0859AB8330146CB63FF0F2D1A52D", hash_generated_field = "29065B52E0E09EECA006A7A5A8F78524")

    private int mTextSelectHandleLeftRes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.458 -0500", hash_original_field = "03ABAC647EB3594ED232D1B3454961E1", hash_generated_field = "9FC61DEFB614916CB19F9F18AE4BBCF8")

    private int mTextSelectHandleRightRes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.460 -0500", hash_original_field = "374332909C45DE8F21434001B66AAA66", hash_generated_field = "3CAFBFF7DAB243B3E8841417BD521E3B")

    private int mTextSelectHandleRes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.463 -0500", hash_original_field = "EB895F6EE6EDACF2253B16B03AB7632E", hash_generated_field = "899920185C4484CA31C0F443B855010D")

    private int mTextEditSuggestionItemLayout;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.465 -0500", hash_original_field = "FC9167D8CD13EE30AC553E5AB967C97F", hash_generated_field = "EE9100393A7AA7FB8D758BBE48AF5F35")

    private SuggestionsPopupWindow mSuggestionsPopupWindow;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.467 -0500", hash_original_field = "770EBCED003CBC82FAA618543966D5D9", hash_generated_field = "84F489ACE61EF8AEAEC12B2F2593297C")

    private SuggestionRangeSpan mSuggestionRangeSpan;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.469 -0500", hash_original_field = "C869BF092CC7483BAB857F97063D735E", hash_generated_field = "02A74559D19DD086E571BE2B3AA83A8F")

    private int mCursorDrawableRes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.472 -0500", hash_original_field = "A374426BF8221A21C3D19FF59F174CC1", hash_generated_field = "E667A519A6080C5A572800DEC412B8A1")

    private final Drawable[] mCursorDrawable = new Drawable[2];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.474 -0500", hash_original_field = "2D35703DC6F698F0A313B41B303D760E", hash_generated_field = "8657E501533B875D60AA97A414831DBD")

    private int mCursorCount;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.476 -0500", hash_original_field = "73A3461427515CA0D6EC13FAF3DABAD3", hash_generated_field = "72952B5254D373336CA0A7F293822C5C")

    private Drawable mSelectHandleLeft;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.478 -0500", hash_original_field = "63C35F1953545E7F3F0712EB353CE909", hash_generated_field = "BE0700D1B06984983D5C63B2FD49DB15")

    private Drawable mSelectHandleRight;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.480 -0500", hash_original_field = "EED340980C6AE886D168C654EB6741D9", hash_generated_field = "08AFAF21E471F629DFA4D8F58C03B94B")

    private Drawable mSelectHandleCenter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.482 -0500", hash_original_field = "F58257283D4C30B366EBD0F9BC30DD07", hash_generated_field = "FB42528DAE75699ED1B6CC0A5A674A55")

    private PositionListener mPositionListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.443 -0400", hash_original_field = "43041C61A1DA9DC67B7FC8F5C22C953B", hash_generated_field = "40ACD97E99B995A7FCA41633B5D7F459")

    private float mLastDownPositionX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.443 -0400", hash_original_field = "5211DB32F771F4FB6B254B7227DAF0E4", hash_generated_field = "25FA8F6701B3D1C16B56B376BE78487E")

    private float mLastDownPositionY;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.487 -0500", hash_original_field = "584AE3525E1E94B7AD1FB60B1848939C", hash_generated_field = "4A2FD1B1A3BA8B998F40B2C0D929E44F")

    private Callback mCustomSelectionActionModeCallback;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.489 -0500", hash_original_field = "56AFDF4A1248F7BA5B608BFF7CEC4733", hash_generated_field = "FE1D03D7C65C5CEC56D15F835C8E0A4C")

    private  int mSquaredTouchSlopDistance;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.491 -0500", hash_original_field = "BB7B7CF77111531DDEEC08C52A3BE003", hash_generated_field = "301C10EAD74C8CF352F89DA817F09EF5")

    private boolean mCreatedWithASelection = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.493 -0500", hash_original_field = "134C3C55F24C618FDDF57AD7DFB984D3", hash_generated_field = "B64007D723854AD8DD3C03BCCA9834A5")

    private WordIterator mWordIterator;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.495 -0500", hash_original_field = "A857FE1EDA9A69865B92571D5E0F462D", hash_generated_field = "D936161C5FDE3DD296D182C31C4ED500")

    private SpellChecker mSpellChecker;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.497 -0500", hash_original_field = "3B8E564876C7575FF663664560458D8A", hash_generated_field = "9735B231E6C5186126230C7191CC2027")

    private boolean mSoftInputShownOnFocus = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.499 -0500", hash_original_field = "8F24DC3C95CDFE3D8A9310566DB05EB7", hash_generated_field = "AE17667AF244FFA2D2100AF02F19092F")

    private Layout.Alignment mLayoutAlignment;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.502 -0500", hash_original_field = "B904A578F88FDF43351CE478F33B1BD5", hash_generated_field = "B8FF70A86AC51485598DFBCFFB37720F")

    private TextAlign mTextAlign = TextAlign.INHERIT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.506 -0500", hash_original_field = "B7E951EB709CD7F5CCC8BBD38F1BFAEF", hash_generated_field = "88A15E3715BB62052F2448ED895C9BBA")

    private boolean mResolvedDrawables = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.508 -0500", hash_original_field = "C386FE6917AFDFF5A58A83CD13EF2CEF", hash_generated_field = "601913B8190553DCCF7F60EF06AC5711")

    private int mMarqueeFadeMode = MARQUEE_FADE_NORMAL;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.511 -0500", hash_original_field = "E5732B1F383F0BCA1AFE7C169DAA1A60", hash_generated_field = "2AD0F97487EA7D5F86DCAFC3259ED37F")

    private Layout mSavedMarqueeModeLayout;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.375 -0500", hash_original_field = "A59BBC07E5E46996D793B2F37E80BD24", hash_generated_field = "6CF16E724237A2841199FB30284CED38")

    @ViewDebug.ExportedProperty(category = "text")
    @DSVAModeled
    protected CharSequence            mText;

@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.377 -0500", hash_original_field = "42E628F60C958E8C05B8C414894669BE", hash_generated_field = "30221785C9497266E9C8ABBDFDCBE7EC")

    private CharSequence            mTransformed;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.379 -0500", hash_original_field = "ACCAD10BAF0288008F3F050657D7C94A", hash_generated_field = "D0147D76A56855726ED38FF51B24F6FD")

    private BufferType              mBufferType = BufferType.NORMAL;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.381 -0500", hash_original_field = "11B2C42B019858DCA60A3878A44A14FC", hash_generated_field = "7CCB62B854814A590D259304E0729FB4")

    private int                     mInputType = EditorInfo.TYPE_NULL;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.383 -0500", hash_original_field = "20B85DCC442F65116E07F2CD18DD5949", hash_generated_field = "D5CD99D8D87E7592EC6B5781C6FFB2FA")

@DSVAModeled
    private CharSequence            mHint;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.385 -0500", hash_original_field = "893C81BF77774962E846196D9E846E6B", hash_generated_field = "EFAB677B32664E9E21A5DE46AC4EC1D6")

    private Layout                  mHintLayout;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.388 -0500", hash_original_field = "88E59AA1AE83A980B1DB90A5B2A8A4D4", hash_generated_field = "CE990DF015C00781E7408846E8AEC5CB")

    private KeyListener             mInput;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.390 -0500", hash_original_field = "C66ED7E42EFE4395CE33BC8E443EFB18", hash_generated_field = "BFA3240A2EA25F7A99F6D250E98184A7")

    private MovementMethod          mMovement;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.392 -0500", hash_original_field = "5BA7777BB54EB53FB5723B872D068A39", hash_generated_field = "5EB7FC8FAB0A2FCCA9E8BF646DA1559A")

    private TransformationMethod    mTransformation;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.394 -0500", hash_original_field = "0C46A1739FD06E21FB0A5256170AD87E", hash_generated_field = "487D1BC024AFF96C6A5C663DC3AA641C")

    private boolean                 mAllowTransformationLengthChange;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.396 -0500", hash_original_field = "BCC562433077D5DF62E470C1094C516B", hash_generated_field = "0D3B538949663CFF4038D6D64784977E")

    private ChangeWatcher           mChangeWatcher;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.398 -0500", hash_original_field = "24AA345C0456C8B18BD2ACE8F14DFFD2", hash_generated_field = "B7D02B86862FFD54C18C460CFF0B0C2C")

    private ArrayList<TextWatcher>  mListeners = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.400 -0500", hash_original_field = "0A19A1954ABA26FA39E555FE892A4ABD", hash_generated_field = "6AD5EFC1421B741B1A8F78A5B815BBFE")

    private  TextPaint         mTextPaint;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.403 -0500", hash_original_field = "14473CD3900E5E4310478E81ABCBEB87", hash_generated_field = "21DF46CCA8F8000ED3BFF8BCF4D828BF")

    private boolean                 mUserSetTextScaleX;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.406 -0500", hash_original_field = "BDFA66A7C027D186A6AA01CBFAC5217F", hash_generated_field = "8983462E53EAFA6E482F98025B0E9AB8")

    private  Paint             mHighlightPaint;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.408 -0500", hash_original_field = "6F8CBE2B4BD88E6A19824DA6B3AC18A9", hash_generated_field = "D25F7D2FFD7EFCE07B644E099B3A56D3")

    private int                     mHighlightColor = 0x6633B5E5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.410 -0500", hash_original_field = "99107F82B615317EF9A2721652F6B828", hash_generated_field = "C7DD20DF980F25C7241B09204173E163")

    protected Layout                mLayout;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.412 -0500", hash_original_field = "6FD5A7BFB809F49B7844553BC23F69BB", hash_generated_field = "0FB0111930B8AF18F464AB4FA2C6200F")

    private long                    mShowCursor;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.414 -0500", hash_original_field = "8B94EFBD9D798E1F0EA69530F08FEE7E", hash_generated_field = "AC59C081943B626844E369F1A5892415")

    private Blink                   mBlink;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.417 -0500", hash_original_field = "80196B9AF917F8290BE459D49C216DFE", hash_generated_field = "F225E507C7DF6D613F7CBC4F577CB716")

    private boolean                 mCursorVisible = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.419 -0500", hash_original_field = "4B88938E9FC26A5D88844C3C77E6DB93", hash_generated_field = "FDFA161EB04278A13E9ECB602C9782F4")

    private InsertionPointCursorController mInsertionPointCursorController;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.421 -0500", hash_original_field = "5B21073CEDFC9AE2E05ADBED2F33F907", hash_generated_field = "2218505DE3146C01814D6E81956F9301")

    private SelectionModifierCursorController mSelectionModifierCursorController;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.423 -0500", hash_original_field = "CEBB58A182EB7BDEC35DB663E2623036", hash_generated_field = "656A5581A4DED5B2323E4335C55017B9")

    private ActionMode              mSelectionActionMode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.425 -0500", hash_original_field = "62430829720A80CF44C0ACB70E0517B6", hash_generated_field = "D1C9F3209CB13DAFB4E161EED540694F")

    private boolean                 mInsertionControllerEnabled;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.427 -0500", hash_original_field = "0BD648B155E56A070F380619AFAE0281", hash_generated_field = "E71C12A23BD84DA882CBDDBA123ABB17")

    private boolean                 mSelectionControllerEnabled;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.429 -0500", hash_original_field = "B02558270B495D442AE8FB9A71E0B833", hash_generated_field = "60F18FE1AE8CDBA3A5368ABF9BB5958F")

    private boolean                 mInBatchEditControllers;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.432 -0500", hash_original_field = "2AE4BB08326E7EC947DD03C414B0E6A9", hash_generated_field = "7E20F67A0496D1E1FE6F1DC6D3BACA5D")

    private boolean                 mSelectAllOnFocus = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.434 -0500", hash_original_field = "291C5E0BA2266BE0C69102A7D7484DCA", hash_generated_field = "3FFAAA27B6CA268237E3AFE24778DD3C")

    private int                     mGravity = Gravity.TOP | Gravity.START;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.437 -0500", hash_original_field = "7F26321CD61769A9E712D7B1E11EF33F", hash_generated_field = "74DB3F78A4C361569E560DA09766931D")

    private boolean                 mHorizontallyScrolling;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.439 -0500", hash_original_field = "E6A230E273F46EC82B984255353366A2", hash_generated_field = "3127858001137B18AA1050FDA67563F8")

    private int                     mAutoLinkMask;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.441 -0500", hash_original_field = "46EB511A401543F3C2E64A5C3A3FEBD7", hash_generated_field = "66946D660FCFF22371342C2FCD7310DE")

    private boolean                 mLinksClickable = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.443 -0500", hash_original_field = "B76B865F6F01D08BDDEA7F89B43686A4", hash_generated_field = "8F925916DEF4152F81E2C1B309E2CAD4")

    private float                   mSpacingMult = 1.0f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.445 -0500", hash_original_field = "486DA14D0AA84CC5C732A1AE0381DDE8", hash_generated_field = "1E02CC84BB1334BEF2DEA24E10A518A6")

    private float                   mSpacingAdd = 0.0f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.447 -0500", hash_original_field = "823246F981B971CEE8F8484E9E53106B", hash_generated_field = "68BD06BADA0355451B21E90ACC461FA5")

    private boolean                 mTextIsSelectable = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.456 -0500", hash_original_field = "394E314F937C69758A7F32EA5004838E", hash_generated_field = "0EE8DD6435BEB8CBE9F46AA7496B8DA6")

    private int                     mMaximum = Integer.MAX_VALUE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.459 -0500", hash_original_field = "BCB210748667576A4180087030857C0D", hash_generated_field = "033C060EBF21916B1ECB824474BF4BDF")

    private int                     mMaxMode = LINES;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.462 -0500", hash_original_field = "2111FF2867FED23DFB0FD2B17B101114", hash_generated_field = "0828D86E694A99841F66D5DB44492D82")

    private int                     mMinimum = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.464 -0500", hash_original_field = "617928FAA57CDB53BF6BC94A037591FF", hash_generated_field = "01F00155DEDA2DDBFDB49BED19C8F96E")

    private int                     mMinMode = LINES;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.466 -0500", hash_original_field = "05DE72AE337B5F58B47F6BC934618C6F", hash_generated_field = "A1A2411DB171DF204A9C43EDA39C69C7")

    private int                     mOldMaximum = mMaximum;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.468 -0500", hash_original_field = "5B8AC6DA3705AFD6895818B071E9E07F", hash_generated_field = "DDDC3184AF678EE8EE38801D06FC99BF")

    private int                     mOldMaxMode = mMaxMode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.470 -0500", hash_original_field = "7923988CB2BF485CE356C2C41363F3B6", hash_generated_field = "63C7BFD9234113D05BBC54B620020077")

    private int                     mMaxWidth = Integer.MAX_VALUE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.472 -0500", hash_original_field = "3C40084BED7A50C5B614921AC192FD7B", hash_generated_field = "C110306973FAB903E136E57733D142DD")

    private int                     mMaxWidthMode = PIXELS;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.474 -0500", hash_original_field = "621B21EA24E30397A6D782CA92FE82C8", hash_generated_field = "5E59AE0126344902582396461E5FAA8C")

    private int                     mMinWidth = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.476 -0500", hash_original_field = "AAF7338DE86E7860E2AE8D89CC37C970", hash_generated_field = "0B24A55CAE86F87D6F35062C108A6502")

    private int                     mMinWidthMode = PIXELS;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.478 -0500", hash_original_field = "8D5BE8949527355183F65B9817B24AEC", hash_generated_field = "6C530F900873AA9699052FBD8A88B031")

    private boolean                 mSingleLine;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.481 -0500", hash_original_field = "06E243F3E7FC6742E8F59FDFCA0F8F5E", hash_generated_field = "3740A3452EC2B82472EDA36D3C6B8C87")

    private int                     mDesiredHeightAtMeasure = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.483 -0500", hash_original_field = "949925B8F9B2F0E88837C7311849C58F", hash_generated_field = "F60C6FE0825AD0E4922E523051656DE4")

    private boolean                 mIncludePad = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.485 -0500", hash_original_field = "9688DF0F9E164893EDF48EFCB1ECBC71", hash_generated_field = "F7ADD3635432B5C7B3A742E5E6D21FF7")

    private Path                    mHighlightPath;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.487 -0500", hash_original_field = "CFD53FAEBD3C0FEB16425BCB5CA22EBE", hash_generated_field = "899F52BC2A6F9C0116B0475059B2BE9C")

    private boolean                 mHighlightPathBogus = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.503 -0500", hash_original_field = "D9542227DCB2FC07C7FAE482DB504F32", hash_generated_field = "507FF60BF6AED501221786F4F9B1C4CE")

    private long mLastScroll;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.505 -0500", hash_original_field = "B3B35C824D797ABE6BE2522C26F9275B", hash_generated_field = "9C30A415641DC69EAA3304A141095B90")

    private Scroller mScroller = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.507 -0500", hash_original_field = "42CCDDA82D0848FB448DE832C7CFDAFD", hash_generated_field = "FF6D60EE34326DC34FD3A8DE24FDF7C9")

    private BoringLayout.Metrics mBoring;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.510 -0500", hash_original_field = "D410C937BEF1BAF3A782760729B3EE28", hash_generated_field = "AAFF1CC477C8CC62A538A60FE46DC5D1")

    private BoringLayout.Metrics mHintBoring;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.455 -0400", hash_original_field = "0A793C83D74ADBD2F96615B43A58295A", hash_generated_field = "A58D53DD9C11A6C44CEF04B476DD83D8")

    private BoringLayout mSavedLayout;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.455 -0400", hash_original_field = "3823EF2992779A9DCE6B5232294F71F7", hash_generated_field = "65F61BA5EAB2A99364AEC51C71BE0AD2")

    private BoringLayout mSavedHintLayout;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.514 -0500", hash_original_field = "2FFDA2E6D8BEF2E6C031B1E812C46320", hash_generated_field = "49191C3FC0794274CF62373EA69DAA6D")

    private TextDirectionHeuristic mTextDir = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.519 -0500", hash_original_field = "8C8A85521B489004093F260598DE60E3", hash_generated_field = "489605ABB55A73F593690CC2882D1D5E")

    private InputFilter[] mFilters = NO_FILTERS;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.532 -0500", hash_original_field = "2C882CC57A3D8BD44BC3BF8B194BAFDD", hash_generated_field = "946F5E9D92C681851A4147B34C44B028")

    private CorrectionHighlighter mCorrectionHighlighter;

    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.523 -0500", hash_original_method = "16A18A865F32B95685EAC04EF434D4B5", hash_generated_method = "5BD772F917010B9D0FE3F05FF4D0CD58")
    
public TextView(Context context) {
        this(context, null);
    }

    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.526 -0500", hash_original_method = "2AA1B7AF4AA0321ED5A0A8E3910A65F3", hash_generated_method = "056D37355FCFA9907259EFB0C9FF69AD")
    
public TextView(Context context,
                    AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.textViewStyle);
    }
    
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.462 -0400", hash_original_method = "9090DB4BB502E7A1E7DDA866F2D92623", hash_generated_method = "23AD89CBA0BEBC0D035CBE13A9739020")
    @SuppressWarnings("deprecation")
    public  TextView(Context context,
                     AttributeSet attrs,
                     int defStyle) {
        super(context, attrs, defStyle);
        //addTaint(defStyle);
        //addTaint(attrs.getTaint());
        //addTaint(context.getTaint());
        mText = "";
        final Resources res = getResources();
        final CompatibilityInfo compat = res.getCompatibilityInfo();
        mTextPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG);
        mTextPaint.density = res.getDisplayMetrics().density;
        mTextPaint.setCompatibilityScaling(compat.applicationScale);
        mHighlightPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mHighlightPaint.setCompatibilityScaling(compat.applicationScale);
        mMovement = getDefaultMovementMethod();
        mTransformation = null;
        int textColorHighlight = 0;
        ColorStateList textColor = null;
        ColorStateList textColorHint = null;
        ColorStateList textColorLink = null;
        int textSize = 15;
        int typefaceIndex = -1;
        int styleIndex = -1;
        boolean allCaps = false;
        final Resources.Theme theme = context.getTheme();
        boolean editable = getDefaultEditable();
        CharSequence inputMethod = null;
        int numeric = 0;
        CharSequence digits = null;
        boolean phone = false;
        boolean autotext = false;
        int autocap = -1;
        int buffertype = 0;
        boolean selectallonfocus = false;
        Drawable drawableLeft = null;
        Drawable drawableTop = null;
        Drawable drawableRight = null;
        Drawable drawableBottom = null;
        Drawable drawableStart = null;
        Drawable drawableEnd = null;
        int drawablePadding = 0;
        int ellipsize = -1;
        boolean singleLine = false;
        int maxlength = -1;
        CharSequence hint = null;
        int shadowcolor = 0;
        float dx = 0;
        float dy = 0;
        float r = 0;
        boolean password = false;
        int inputType = EditorInfo.TYPE_NULL;
        BufferType bufferType = BufferType.EDITABLE;
        final int variation = inputType & (EditorInfo.TYPE_MASK_CLASS | EditorInfo.TYPE_MASK_VARIATION);
        final boolean passwordInputType = variation
                == (EditorInfo.TYPE_CLASS_TEXT | EditorInfo.TYPE_TEXT_VARIATION_PASSWORD);
        final boolean webPasswordInputType = variation
                == (EditorInfo.TYPE_CLASS_TEXT | EditorInfo.TYPE_TEXT_VARIATION_WEB_PASSWORD);
        final boolean numberPasswordInputType = variation
                == (EditorInfo.TYPE_CLASS_NUMBER | EditorInfo.TYPE_NUMBER_VARIATION_PASSWORD);
        if(inputMethod != null)        
        {
            /* commented by droidsafe because reflection cannot be resolved!
            Class<?> c;
            try 
            {
                c = Class.forName(inputMethod.toString());
            } //End block
            catch (ClassNotFoundException ex)
            {
                RuntimeException varF35D3C95F99DACEE8C542CF38D772C50_1465662716 = new RuntimeException(ex);
                varF35D3C95F99DACEE8C542CF38D772C50_1465662716.addTaint(getTaint());
                throw varF35D3C95F99DACEE8C542CF38D772C50_1465662716;
            } //End block
            try 
            {
                mInput = (KeyListener) c.newInstance();
            } //End block
            catch (InstantiationException ex)
            {
                RuntimeException varF35D3C95F99DACEE8C542CF38D772C50_783290925 = new RuntimeException(ex);
                varF35D3C95F99DACEE8C542CF38D772C50_783290925.addTaint(getTaint());
                throw varF35D3C95F99DACEE8C542CF38D772C50_783290925;
            } //End block
            catch (IllegalAccessException ex)
            {
                RuntimeException varF35D3C95F99DACEE8C542CF38D772C50_1419080337 = new RuntimeException(ex);
                varF35D3C95F99DACEE8C542CF38D772C50_1419080337.addTaint(getTaint());
                throw varF35D3C95F99DACEE8C542CF38D772C50_1419080337;
            } //End block
            try 
            {
                mInputType = inputType != EditorInfo.TYPE_NULL
                ? inputType
                                : mInput.getInputType();
            } //End block
            catch (IncompatibleClassChangeError e)
            {
                mInputType = EditorInfo.TYPE_CLASS_TEXT;
            } //End block
            */
        } //End block
        else
            if(digits != null)        
            {
                mInput = DigitsKeyListener.getInstance(digits.toString());
                mInputType = inputType != EditorInfo.TYPE_NULL
                        ? inputType : EditorInfo.TYPE_CLASS_TEXT;
            } //End block
            else
                if(inputType != EditorInfo.TYPE_NULL)        
                {
                    setInputType(inputType, true);
                    singleLine = !isMultilineInputType(inputType);
                } //End block
                else
                    if(phone)        
                    {
                        mInput = DialerKeyListener.getInstance();
                        mInputType = inputType = EditorInfo.TYPE_CLASS_PHONE;
                    } //End block
                    else
                        if(numeric != 0)        
                        {
                            mInput = DigitsKeyListener.getInstance((numeric & SIGNED) != 0,
                                    (numeric & DECIMAL) != 0);
                            inputType = EditorInfo.TYPE_CLASS_NUMBER;
                            if((numeric & SIGNED) != 0)            
                            {
                                inputType |= EditorInfo.TYPE_NUMBER_FLAG_SIGNED;
                            } //End block
                            if((numeric & DECIMAL) != 0)            
                            {
                                inputType |= EditorInfo.TYPE_NUMBER_FLAG_DECIMAL;
                            } //End block
                            mInputType = inputType;
                        } //End block
                        else
                            if(autotext || autocap != -1)        
                            {
                                TextKeyListener.Capitalize cap;
                                inputType = EditorInfo.TYPE_CLASS_TEXT;
                                switch(autocap){
                                    case 1:
                                        cap = TextKeyListener.Capitalize.SENTENCES;
                                        inputType |= EditorInfo.TYPE_TEXT_FLAG_CAP_SENTENCES;
                                        break;
                                    case 2:
                                        cap = TextKeyListener.Capitalize.WORDS;
                                        inputType |= EditorInfo.TYPE_TEXT_FLAG_CAP_WORDS;
                                        break;
                                    case 3:
                                        cap = TextKeyListener.Capitalize.CHARACTERS;
                                        inputType |= EditorInfo.TYPE_TEXT_FLAG_CAP_CHARACTERS;
                                        break;
                                    default:
                                        cap = TextKeyListener.Capitalize.NONE;
                                        break;
                                }            mInput = TextKeyListener.getInstance(autotext, cap);
                                mInputType = inputType;
                            } //End block
                            else
                                if(mTextIsSelectable)        
                                {
                                    mInputType = EditorInfo.TYPE_NULL;
                                    mInput = null;
                                    bufferType = BufferType.SPANNABLE;
                                    setFocusableInTouchMode(true);
                                    setMovementMethod(ArrowKeyMovementMethod.getInstance());
                                } //End block
                                else
                                    if(editable)        
                                    {
                                        mInput = TextKeyListener.getInstance();
                                        mInputType = EditorInfo.TYPE_CLASS_TEXT;
                                    } //End block
                                    else
                                    {
                                        mInput = null;
                                        switch(buffertype){
                                            case 0:
                                                bufferType = BufferType.NORMAL;
                                                break;
                                            case 1:
                                                bufferType = BufferType.SPANNABLE;
                                                break;
                                            case 2:
                                                bufferType = BufferType.EDITABLE;
                                                break;
                                        }
                                    } //End block
        if((mInputType & EditorInfo.TYPE_MASK_CLASS) == EditorInfo.TYPE_CLASS_TEXT)        
        {
            if(password || passwordInputType)            
            {
                mInputType = (mInputType & ~(EditorInfo.TYPE_MASK_VARIATION))
                        | EditorInfo.TYPE_TEXT_VARIATION_PASSWORD;
            } //End block
            if(webPasswordInputType)            
            {
                mInputType = (mInputType & ~(EditorInfo.TYPE_MASK_VARIATION))
                        | EditorInfo.TYPE_TEXT_VARIATION_WEB_PASSWORD;
            } //End block
        } //End block
        else
            if((mInputType & EditorInfo.TYPE_MASK_CLASS) == EditorInfo.TYPE_CLASS_NUMBER)        
            {
                if(numberPasswordInputType)            
                {
                    mInputType = (mInputType & ~(EditorInfo.TYPE_MASK_VARIATION))
                            | EditorInfo.TYPE_NUMBER_VARIATION_PASSWORD;
                } //End block
            } //End block
        if(selectallonfocus)        
        {
            mSelectAllOnFocus = true;
            if(bufferType == BufferType.NORMAL)            
                bufferType = BufferType.SPANNABLE;
        } //End block
        setCompoundDrawablesWithIntrinsicBounds(
            drawableLeft, drawableTop, drawableRight, drawableBottom);
        setRelativeDrawablesIfNeeded(drawableStart, drawableEnd);
        setCompoundDrawablePadding(drawablePadding);
        setInputTypeSingleLine(singleLine);
        applySingleLine(singleLine, singleLine, singleLine);
        if(singleLine && mInput == null && ellipsize < 0)        
        {
            ellipsize = 3;
        } //End block
        switch(ellipsize){
            case 1:
                setEllipsize(TextUtils.TruncateAt.START);
                break;
            case 2:
                setEllipsize(TextUtils.TruncateAt.MIDDLE);
                break;
            case 3:
                setEllipsize(TextUtils.TruncateAt.END);
                break;
            case 4:
                if(ViewConfiguration.get(context).isFadingMarqueeEnabled())        
                {
                    setHorizontalFadingEdgeEnabled(true);
                    mMarqueeFadeMode = MARQUEE_FADE_NORMAL;
                } //End block
                else
                {
                    setHorizontalFadingEdgeEnabled(false);
                    mMarqueeFadeMode = MARQUEE_FADE_SWITCH_SHOW_ELLIPSIS;
                } //End block
                setEllipsize(TextUtils.TruncateAt.MARQUEE);
                break;
        }        setTextColor(textColor != null ? textColor : ColorStateList.valueOf(0xFF000000));
        setHintTextColor(textColorHint);
        setLinkTextColor(textColorLink);
        if(textColorHighlight != 0)        
        {
            setHighlightColor(textColorHighlight);
        } //End block
        setRawTextSize(textSize);
        if(allCaps)        
        {
            setTransformationMethod(new AllCapsTransformationMethod(getContext()));
        } //End block
        if(password || passwordInputType || webPasswordInputType || numberPasswordInputType)        
        {
            setTransformationMethod(PasswordTransformationMethod.getInstance());
            typefaceIndex = MONOSPACE;
        } //End block
        else
            if((mInputType & (EditorInfo.TYPE_MASK_CLASS | EditorInfo.TYPE_MASK_VARIATION))
                    == (EditorInfo.TYPE_CLASS_TEXT | EditorInfo.TYPE_TEXT_VARIATION_PASSWORD))        
            {
                typefaceIndex = MONOSPACE;
            } //End block
        setTypefaceByIndex(typefaceIndex, styleIndex);
        if(shadowcolor != 0)        
        {
            setShadowLayer(r, dx, dy, shadowcolor);
        } //End block
        if(maxlength >= 0)        
        {
            setFilters(new InputFilter[] { new InputFilter.LengthFilter(maxlength) });
        } //End block
        else
        {
            setFilters(NO_FILTERS);
        } //End block
        //setText(text, bufferType);
        mBufferType = bufferType;
        if(hint != null)        
            setHint(hint);
        boolean focusable = mMovement != null || mInput != null;
        boolean clickable = focusable;
        boolean longClickable = focusable;
        setFocusable(focusable);
        setClickable(clickable);
        setLongClickable(longClickable);
        prepareCursorControllers();
        final ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        final int touchSlop = viewConfiguration.getScaledTouchSlop();
        mSquaredTouchSlopDistance = touchSlop * touchSlop;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.545 -0500", hash_original_method = "C60E18AF77ADDBBD7F15C48D3326353D", hash_generated_method = "DADECFA14B63B34B36583D0A75D94394")
    
private void setTypefaceByIndex(int typefaceIndex, int styleIndex) {
        Typeface tf = null;
        switch (typefaceIndex) {
            case SANS:
                tf = Typeface.SANS_SERIF;
                break;

            case SERIF:
                tf = Typeface.SERIF;
                break;

            case MONOSPACE:
                tf = Typeface.MONOSPACE;
                break;
        }

        setTypeface(tf, styleIndex);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.547 -0500", hash_original_method = "81361F4824C6D1D7960776386313375B", hash_generated_method = "CC692AB6FD3941537739E836CC18EFD0")
    
private void setRelativeDrawablesIfNeeded(Drawable start, Drawable end) {
        boolean hasRelativeDrawables = (start != null) || (end != null);
        if (hasRelativeDrawables) {
            Drawables dr = mDrawables;
            if (dr == null) {
                mDrawables = dr = new Drawables();
            }
            final Rect compoundRect = dr.mCompoundRect;
            int[] state = getDrawableState();
            if (start != null) {
                start.setBounds(0, 0, start.getIntrinsicWidth(), start.getIntrinsicHeight());
                start.setState(state);
                start.copyBounds(compoundRect);
                start.setCallback(this);

                dr.mDrawableStart = start;
                dr.mDrawableSizeStart = compoundRect.width();
                dr.mDrawableHeightStart = compoundRect.height();
            } else {
                dr.mDrawableSizeStart = dr.mDrawableHeightStart = 0;
            }
            if (end != null) {
                end.setBounds(0, 0, end.getIntrinsicWidth(), end.getIntrinsicHeight());
                end.setState(state);
                end.copyBounds(compoundRect);
                end.setCallback(this);

                dr.mDrawableEnd = end;
                dr.mDrawableSizeEnd = compoundRect.width();
                dr.mDrawableHeightEnd = compoundRect.height();
            } else {
                dr.mDrawableSizeEnd = dr.mDrawableHeightEnd = 0;
            }
        }
    }

    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.550 -0500", hash_original_method = "224789FFA5DBD63B17185276A15DADF0", hash_generated_method = "756550E254590B5801A7246265A40FA0")
    
@Override
    public void setEnabled(boolean enabled) {
        if (enabled == isEnabled()) {
            return;
        }

        if (!enabled) {
            // Hide the soft input if the currently active TextView is disabled
            InputMethodManager imm = InputMethodManager.peekInstance();
            if (imm != null && imm.isActive(this)) {
                imm.hideSoftInputFromWindow(getWindowToken(), 0);
            }
        }
        super.setEnabled(enabled);
        prepareCursorControllers();
        if (enabled) {
            // Make sure IME is updated with current editor info.
            InputMethodManager imm = InputMethodManager.peekInstance();
            if (imm != null) imm.restartInput(this);
        }

        // start or stop the cursor blinking as appropriate
        makeBlink();
    }

    /**
     * Sets the typeface and style in which the text should be displayed,
     * and turns on the fake bold and italic bits in the Paint if the
     * Typeface that you provided does not have all the bits in the
     * style that you specified.
     *
     * @attr ref android.R.styleable#TextView_typeface
     * @attr ref android.R.styleable#TextView_textStyle
     */
    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.553 -0500", hash_original_method = "6CE73F981984CDCC5004358BB070DFC0", hash_generated_method = "3E90EBA10091B15BB3C4DBAFB3CF7D7F")
    
public void setTypeface(Typeface tf, int style) {
        if (style > 0) {
            if (tf == null) {
                tf = Typeface.defaultFromStyle(style);
            } else {
                tf = Typeface.create(tf, style);
            }

            setTypeface(tf);
            // now compute what (if any) algorithmic styling is needed
            int typefaceStyle = tf != null ? tf.getStyle() : 0;
            int need = style & ~typefaceStyle;
            mTextPaint.setFakeBoldText((need & Typeface.BOLD) != 0);
            mTextPaint.setTextSkewX((need & Typeface.ITALIC) != 0 ? -0.25f : 0);
        } else {
            mTextPaint.setFakeBoldText(false);
            mTextPaint.setTextSkewX(0);
            setTypeface(tf);
        }
    }

    /**
     * Subclasses override this to specify that they have a KeyListener
     * by default even if not specifically called for in the XML options.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.555 -0500", hash_original_method = "BFDF598F6F7CD4AFD7EB65F700EA9607", hash_generated_method = "D9C4C32C3532FBA603058E06C639E3BA")
    
protected boolean getDefaultEditable() {
        return false;
    }

    /**
     * Subclasses override this to specify a default movement method.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.557 -0500", hash_original_method = "BBE0A92ADC5D9278A97962CE8941F1CB", hash_generated_method = "39B4E4940F13EF9E6E2B61E312107E0C")
    
protected MovementMethod getDefaultMovementMethod() {
        return null;
    }

    /**
     * Return the text the TextView is displaying. If setText() was called with
     * an argument of BufferType.SPANNABLE or BufferType.EDITABLE, you can cast
     * the return value from this method to Spannable or Editable, respectively.
     *
     * Note: The content of the return value should not be modified. If you want
     * a modifiable one, you should make your own copy first.
     */
    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.GUI_TEXT}) 
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.559 -0500", hash_original_method = "D3D56665E0CC0B43413FBFB4C720E96C", hash_generated_method = "07E497F06FCA3C4F8CABDACFD16853C1")
@ViewDebug.CapturedViewProperty
    public CharSequence getText() {
        return mText;
    }

    /**
     * Returns the length, in characters, of the text managed by this TextView
     */
    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.561 -0500", hash_original_method = "9A68249D01A4FE1CBD4D535668FCEB6F", hash_generated_method = "8958BA6171CC7F46E64433775F1B4CBA")
    
public int length() {
        return mText.length();
    }

    /**
     * Return the text the TextView is displaying as an Editable object.  If
     * the text is not editable, null is returned.
     *
     * @see #getText
     */
    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.563 -0500", hash_original_method = "7ED3A36B3A9686857AF495D746EF7144", hash_generated_method = "EE75B94FCCCA9A8B2BF2609EB9C259A6")
    
public Editable getEditableText() {
        return (mText instanceof Editable) ? (Editable)mText : null;
    }

    /**
     * @return the height of one standard line in pixels.  Note that markup
     * within the text can cause individual lines to be taller or shorter
     * than this height, and the layout may contain additional first-
     * or last-line padding.
     */
    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.565 -0500", hash_original_method = "0FF7B2A5A4CF7321FA6B03810945EA51", hash_generated_method = "0002CF0C9D9916FDEEE5869841EEA9A7")
    
public int getLineHeight() {
        return FastMath.round(mTextPaint.getFontMetricsInt(null) * mSpacingMult + mSpacingAdd);
    }

    /**
     * @return the Layout that is currently being used to display the text.
     * This can be null if the text or width has recently changes.
     */
    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.567 -0500", hash_original_method = "AA853122D8F66FE025B9AF375421C379", hash_generated_method = "ED3F5A3D1B36127BD7C8A4AEE1060989")
    
public final Layout getLayout() {
        return mLayout;
    }

    /**
     * @return the current key listener for this TextView.
     * This will frequently be null for non-EditText TextViews.
     */
    @DSComment("potential callback called inside method")
    @DSSpec(DSCat.TO_MODEL)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.569 -0500", hash_original_method = "16C14256413AD7EC2C071FEF64E5C315", hash_generated_method = "8E1962FA488BE42502AE603ACF2A0A9D")
    
public final KeyListener getKeyListener() {
        return mInput;
    }

    /**
     * Sets the key listener to be used with this TextView.  This can be null
     * to disallow user input.  Note that this method has significant and
     * subtle interactions with soft keyboards and other input method:
     * see {@link KeyListener#getInputType() KeyListener.getContentType()}
     * for important details.  Calling this method will replace the current
     * content type of the text view with the content type returned by the
     * key listener.
     * <p>
     * Be warned that if you want a TextView with a key listener or movement
     * method not to be focusable, or if you want a TextView without a
     * key listener or movement method to be focusable, you must call
     * {@link #setFocusable} again after calling this to get the focusability
     * back the way you want it.
     *
     * @attr ref android.R.styleable#TextView_numeric
     * @attr ref android.R.styleable#TextView_digits
     * @attr ref android.R.styleable#TextView_phoneNumber
     * @attr ref android.R.styleable#TextView_inputMethod
     * @attr ref android.R.styleable#TextView_capitalize
     * @attr ref android.R.styleable#TextView_autoText
     */
    @DSVerified
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.572 -0500", hash_original_method = "C24E7464E624E00527FA94ACF2B78CDF", hash_generated_method = "3006DC6A1FBEBD6754AC5B1AA8ADEDC1")
public void setKeyListener(KeyListener input) {
        setKeyListenerOnly(input);
        fixFocusableAndClickableSettings();

        if (input != null) {
            try {
                mInputType = mInput.getInputType();
            } catch (IncompatibleClassChangeError e) {
                mInputType = EditorInfo.TYPE_CLASS_TEXT;
            }
            // Change inputType, without affecting transformation.
            // No need to applySingleLine since mSingleLine is unchanged.
            setInputTypeSingleLine(mSingleLine);
        } else {
            mInputType = EditorInfo.TYPE_NULL;
        }

        InputMethodManager imm = InputMethodManager.peekInstance();
        if (imm != null) imm.restartInput(this);
    }
    
    @DSVerified
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.466 -0400", hash_original_method = "4C0922906A0644E54152EA479C6FB8D4", hash_generated_method = "D150019EF240ACF49C8766A33CC7D765")
    private void setKeyListenerOnly(KeyListener input) {
        mInput = input;
        /*
        if(mInput != null && !(mText instanceof Editable))        
            setText(mText);
            */
        setFilters((Editable) mText, mFilters);
        if (input != null) {
            input.onKeyDown(this, (Editable)mText,  DSUtils.FAKE_INT, new KeyEvent());
            input.onKeyUp(this, (Editable)mText,  DSUtils.FAKE_INT, new KeyEvent());
            input.onKeyOther(this, (Editable)mText,  new KeyEvent());

        }

        // ---------- Original Method ----------
        //mInput = input;
        //if (mInput != null && !(mText instanceof Editable))
        //setText(mText);
        //setFilters((Editable) mText, mFilters);
    }

    /**
     * @return the movement method being used for this TextView.
     * This will frequently be null for non-EditText TextViews.
     */
    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.577 -0500", hash_original_method = "48923BC0AD13C4CAAF5FC92105497B11", hash_generated_method = "0820B16E8A8197F6FEBF23693637C81F")
    
public final MovementMethod getMovementMethod() {
        return mMovement;
    }
    
    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.466 -0400", hash_original_method = "A60F83672BBDF336AF379460700DB19E", hash_generated_method = "9B27B40E42098005C48EF0F2D7F52E41")
    public final void setMovementMethod(MovementMethod movement) {
        mMovement = movement;
        /*
        if(mMovement != null && !(mText instanceof Spannable))        
            setText(mText);
            */
        fixFocusableAndClickableSettings();
        prepareCursorControllers();
        // ---------- Original Method ----------
        //mMovement = movement;
        //if (mMovement != null && !(mText instanceof Spannable))
        //setText(mText);
        //fixFocusableAndClickableSettings();
        //prepareCursorControllers();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.582 -0500", hash_original_method = "20BA1DEB0A4AF2EE483D2287D9007BE7", hash_generated_method = "6BB7A0D320C6B8F75D20CFD7F0ABF4C2")
    
private void fixFocusableAndClickableSettings() {
        if ((mMovement != null) || mInput != null) {
            setFocusable(true);
            setClickable(true);
            setLongClickable(true);
        } else {
            setFocusable(false);
            setClickable(false);
            setLongClickable(false);
        }
    }

    /**
     * @return the current transformation method for this TextView.
     * This will frequently be null except for single-line and password
     * fields.
     */
    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.584 -0500", hash_original_method = "2CDC6DDF1029E76D6DBEC0602C28EC15", hash_generated_method = "CD8BD182961C287E2B549608478BC782")
    
public final TransformationMethod getTransformationMethod() {
        return mTransformation;
    }
    
    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.467 -0400", hash_original_method = "93D394D84FFC0B02B9FD24841443EB6E", hash_generated_method = "73B025571B06364795372CD69839C012")
    public final void setTransformationMethod(TransformationMethod method) {
        if(method == mTransformation)        
        {
            return;
        } //End block
        if(mTransformation != null)        
        {
            if(mText instanceof Spannable)            
            {
                ((Spannable) mText).removeSpan(mTransformation);
            } //End block
        } //End block
        mTransformation = method;
        if(method instanceof TransformationMethod2)        
        {
            TransformationMethod2 method2 = (TransformationMethod2) method;
            mAllowTransformationLengthChange = !mTextIsSelectable && !(mText instanceof Editable);
            method2.setLengthChangesAllowed(mAllowTransformationLengthChange);
        } //End block
        else
        {
            mAllowTransformationLengthChange = false;
        } //End block
        //setText(mText);
        // ---------- Original Method ----------
        //if (method == mTransformation) {
        //return;
        //}
        //if (mTransformation != null) {
        //if (mText instanceof Spannable) {
        //((Spannable) mText).removeSpan(mTransformation);
        //}
        //}
        //mTransformation = method;
        //if (method instanceof TransformationMethod2) {
        //TransformationMethod2 method2 = (TransformationMethod2) method;
        //mAllowTransformationLengthChange = !mTextIsSelectable && !(mText instanceof Editable);
        //method2.setLengthChangesAllowed(mAllowTransformationLengthChange);
        //} else {
        //mAllowTransformationLengthChange = false;
        //}
        //setText(mText);
    }

    /**
     * Returns the top padding of the view, plus space for the top
     * Drawable if any.
     */
    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.590 -0500", hash_original_method = "CD4E87E17C71F6F36E69A30DF125A2EC", hash_generated_method = "435E87EB3854551FDB74945C36FF9A8E")
    
public int getCompoundPaddingTop() {
        final Drawables dr = mDrawables;
        if (dr == null || dr.mDrawableTop == null) {
            return mPaddingTop;
        } else {
            return mPaddingTop + dr.mDrawablePadding + dr.mDrawableSizeTop;
        }
    }

    /**
     * Returns the bottom padding of the view, plus space for the bottom
     * Drawable if any.
     */
    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.592 -0500", hash_original_method = "F8E73EA88ED50BD236713C6E1FD6275E", hash_generated_method = "66C7DFC5854FDFA910AA65CC31385341")
    
public int getCompoundPaddingBottom() {
        final Drawables dr = mDrawables;
        if (dr == null || dr.mDrawableBottom == null) {
            return mPaddingBottom;
        } else {
            return mPaddingBottom + dr.mDrawablePadding + dr.mDrawableSizeBottom;
        }
    }

    /**
     * Returns the left padding of the view, plus space for the left
     * Drawable if any.
     */
    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.594 -0500", hash_original_method = "E37CE1C2FEDB3DD18FEE34DF2470D692", hash_generated_method = "E2C37DAA056C4CB748AB0AE971EE4586")
    
public int getCompoundPaddingLeft() {
        final Drawables dr = mDrawables;
        if (dr == null || dr.mDrawableLeft == null) {
            return mPaddingLeft;
        } else {
            return mPaddingLeft + dr.mDrawablePadding + dr.mDrawableSizeLeft;
        }
    }

    /**
     * Returns the right padding of the view, plus space for the right
     * Drawable if any.
     */
    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.596 -0500", hash_original_method = "FA75E1802F0BBA6FD5DC7258A0FBEB3C", hash_generated_method = "AB29288C62020D6924B779D391C28A20")
    
public int getCompoundPaddingRight() {
        final Drawables dr = mDrawables;
        if (dr == null || dr.mDrawableRight == null) {
            return mPaddingRight;
        } else {
            return mPaddingRight + dr.mDrawablePadding + dr.mDrawableSizeRight;
        }
    }

    /**
     * Returns the start padding of the view, plus space for the start
     * Drawable if any.
     *
     * @hide
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.599 -0500", hash_original_method = "045E56B45A145CD7B99AFA777E63AEB3", hash_generated_method = "E3A61FBF21DA951944CCF8044CE78DCC")
    
public int getCompoundPaddingStart() {
        resolveDrawables();
        switch(getResolvedLayoutDirection()) {
            default:
            case LAYOUT_DIRECTION_LTR:
                return getCompoundPaddingLeft();
            case LAYOUT_DIRECTION_RTL:
                return getCompoundPaddingRight();
        }
    }

    /**
     * Returns the end padding of the view, plus space for the end
     * Drawable if any.
     *
     * @hide
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.601 -0500", hash_original_method = "0C4A0FB6513BA7C283389B0C3E09BE68", hash_generated_method = "C23BC1AA95CDCEC51F9E31488B7BAE6C")
    
public int getCompoundPaddingEnd() {
        resolveDrawables();
        switch(getResolvedLayoutDirection()) {
            default:
            case LAYOUT_DIRECTION_LTR:
                return getCompoundPaddingRight();
            case LAYOUT_DIRECTION_RTL:
                return getCompoundPaddingLeft();
        }
    }

    /**
     * Returns the extended top padding of the view, including both the
     * top Drawable if any and any extra space to keep more than maxLines
     * of text from showing.  It is only valid to call this after measuring.
     */
    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.603 -0500", hash_original_method = "363FF0B4BA7F59F6CC6EB59AE673A7C9", hash_generated_method = "C8EED0CA2B9DF5989501723DC3FB0497")
    
public int getExtendedPaddingTop() {
        if (mMaxMode != LINES) {
            return getCompoundPaddingTop();
        }

        if (mLayout.getLineCount() <= mMaximum) {
            return getCompoundPaddingTop();
        }

        int top = getCompoundPaddingTop();
        int bottom = getCompoundPaddingBottom();
        int viewht = getHeight() - top - bottom;
        int layoutht = mLayout.getLineTop(mMaximum);

        if (layoutht >= viewht) {
            return top;
        }

        final int gravity = mGravity & Gravity.VERTICAL_GRAVITY_MASK;
        if (gravity == Gravity.TOP) {
            return top;
        } else if (gravity == Gravity.BOTTOM) {
            return top + viewht - layoutht;
        } else { // (gravity == Gravity.CENTER_VERTICAL)
            return top + (viewht - layoutht) / 2;
        }
    }

    /**
     * Returns the extended bottom padding of the view, including both the
     * bottom Drawable if any and any extra space to keep more than maxLines
     * of text from showing.  It is only valid to call this after measuring.
     */
    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.606 -0500", hash_original_method = "7A2DB8BFB057F07CEDE0D120BE6FFB10", hash_generated_method = "68EB0183E36F352FA5C69DE11619572C")
    
public int getExtendedPaddingBottom() {
        if (mMaxMode != LINES) {
            return getCompoundPaddingBottom();
        }

        if (mLayout.getLineCount() <= mMaximum) {
            return getCompoundPaddingBottom();
        }

        int top = getCompoundPaddingTop();
        int bottom = getCompoundPaddingBottom();
        int viewht = getHeight() - top - bottom;
        int layoutht = mLayout.getLineTop(mMaximum);

        if (layoutht >= viewht) {
            return bottom;
        }

        final int gravity = mGravity & Gravity.VERTICAL_GRAVITY_MASK;
        if (gravity == Gravity.TOP) {
            return bottom + viewht - layoutht;
        } else if (gravity == Gravity.BOTTOM) {
            return bottom;
        } else { // (gravity == Gravity.CENTER_VERTICAL)
            return bottom + (viewht - layoutht) / 2;
        }
    }

    /**
     * Returns the total left padding of the view, including the left
     * Drawable if any.
     */
    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.608 -0500", hash_original_method = "5245DB1A490E586E6093F4BFC26117D1", hash_generated_method = "32E15931217A6CEE49BF00D4AEB6DC66")
    
public int getTotalPaddingLeft() {
        return getCompoundPaddingLeft();
    }

    /**
     * Returns the total right padding of the view, including the right
     * Drawable if any.
     */
    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.610 -0500", hash_original_method = "A1EB6CC80DC85EDA662D4DD9C10BBDEB", hash_generated_method = "3769F6277A251519A18B24855F8E5F69")
    
public int getTotalPaddingRight() {
        return getCompoundPaddingRight();
    }

    /**
     * Returns the total start padding of the view, including the start
     * Drawable if any.
     *
     * @hide
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.612 -0500", hash_original_method = "DD9B038504EC66CC7FCB75AE1CB753E5", hash_generated_method = "0F8B01F0BAB2340E14E968E2E574AE79")
    
public int getTotalPaddingStart() {
        return getCompoundPaddingStart();
    }

    /**
     * Returns the total end padding of the view, including the end
     * Drawable if any.
     *
     * @hide
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.614 -0500", hash_original_method = "7924A3AF5CA0D716DAB0CFDF1EC0C456", hash_generated_method = "5C1CAD4D5A6B45D6061D84EE15C4D2FD")
    
public int getTotalPaddingEnd() {
        return getCompoundPaddingEnd();
    }

    /**
     * Returns the total top padding of the view, including the top
     * Drawable if any, the extra space to keep more than maxLines
     * from showing, and the vertical offset for gravity, if any.
     */
    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.616 -0500", hash_original_method = "3FBB92A2EE65C62C674BD5E5A5FB2713", hash_generated_method = "FD290D38064F4BCF8AC2EE4A93E66F6B")
    
public int getTotalPaddingTop() {
        return getExtendedPaddingTop() + getVerticalOffset(true);
    }

    /**
     * Returns the total bottom padding of the view, including the bottom
     * Drawable if any, the extra space to keep more than maxLines
     * from showing, and the vertical offset for gravity, if any.
     */
    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.618 -0500", hash_original_method = "DD0E7E66835F9F938ABD11A206F39F98", hash_generated_method = "CB232BB44DAA142F75F529801F04B46F")
    
public int getTotalPaddingBottom() {
        return getExtendedPaddingBottom() + getBottomVerticalOffset(true);
    }

    /**
     * Sets the Drawables (if any) to appear to the left of, above,
     * to the right of, and below the text.  Use null if you do not
     * want a Drawable there.  The Drawables must already have had
     * {@link Drawable#setBounds} called.
     *
     * @attr ref android.R.styleable#TextView_drawableLeft
     * @attr ref android.R.styleable#TextView_drawableTop
     * @attr ref android.R.styleable#TextView_drawableRight
     * @attr ref android.R.styleable#TextView_drawableBottom
     */
    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.623 -0500", hash_original_method = "FDA2BF05D2CC3125A844DA2F1CDB97F3", hash_generated_method = "A47525F7712E804B11EE06B2DB903D29")
    
public void setCompoundDrawables(Drawable left, Drawable top,
                                     Drawable right, Drawable bottom) {
        Drawables dr = mDrawables;

        final boolean drawables = left != null || top != null
                || right != null || bottom != null;

        if (!drawables) {
            // Clearing drawables...  can we free the data structure?
            if (dr != null) {
                if (dr.mDrawablePadding == 0) {
                    mDrawables = null;
                } else {
                    // We need to retain the last set padding, so just clear
                    // out all of the fields in the existing structure.
                    if (dr.mDrawableLeft != null) dr.mDrawableLeft.setCallback(null);
                    dr.mDrawableLeft = null;
                    if (dr.mDrawableTop != null) dr.mDrawableTop.setCallback(null);
                    dr.mDrawableTop = null;
                    if (dr.mDrawableRight != null) dr.mDrawableRight.setCallback(null);
                    dr.mDrawableRight = null;
                    if (dr.mDrawableBottom != null) dr.mDrawableBottom.setCallback(null);
                    dr.mDrawableBottom = null;
                    dr.mDrawableSizeLeft = dr.mDrawableHeightLeft = 0;
                    dr.mDrawableSizeRight = dr.mDrawableHeightRight = 0;
                    dr.mDrawableSizeTop = dr.mDrawableWidthTop = 0;
                    dr.mDrawableSizeBottom = dr.mDrawableWidthBottom = 0;
                }
            }
        } else {
            if (dr == null) {
                mDrawables = dr = new Drawables();
            }

            if (dr.mDrawableLeft != left && dr.mDrawableLeft != null) {
                dr.mDrawableLeft.setCallback(null);
            }
            dr.mDrawableLeft = left;

            if (dr.mDrawableTop != top && dr.mDrawableTop != null) {
                dr.mDrawableTop.setCallback(null);
            }
            dr.mDrawableTop = top;

            if (dr.mDrawableRight != right && dr.mDrawableRight != null) {
                dr.mDrawableRight.setCallback(null);
            }
            dr.mDrawableRight = right;

            if (dr.mDrawableBottom != bottom && dr.mDrawableBottom != null) {
                dr.mDrawableBottom.setCallback(null);
            }
            dr.mDrawableBottom = bottom;

            final Rect compoundRect = dr.mCompoundRect;
            int[] state;

            state = getDrawableState();

            if (left != null) {
                left.setState(state);
                left.copyBounds(compoundRect);
                left.setCallback(this);
                dr.mDrawableSizeLeft = compoundRect.width();
                dr.mDrawableHeightLeft = compoundRect.height();
            } else {
                dr.mDrawableSizeLeft = dr.mDrawableHeightLeft = 0;
            }

            if (right != null) {
                right.setState(state);
                right.copyBounds(compoundRect);
                right.setCallback(this);
                dr.mDrawableSizeRight = compoundRect.width();
                dr.mDrawableHeightRight = compoundRect.height();
            } else {
                dr.mDrawableSizeRight = dr.mDrawableHeightRight = 0;
            }

            if (top != null) {
                top.setState(state);
                top.copyBounds(compoundRect);
                top.setCallback(this);
                dr.mDrawableSizeTop = compoundRect.height();
                dr.mDrawableWidthTop = compoundRect.width();
            } else {
                dr.mDrawableSizeTop = dr.mDrawableWidthTop = 0;
            }

            if (bottom != null) {
                bottom.setState(state);
                bottom.copyBounds(compoundRect);
                bottom.setCallback(this);
                dr.mDrawableSizeBottom = compoundRect.height();
                dr.mDrawableWidthBottom = compoundRect.width();
            } else {
                dr.mDrawableSizeBottom = dr.mDrawableWidthBottom = 0;
            }
        }

        invalidate();
        requestLayout();
    }

    /**
     * Sets the Drawables (if any) to appear to the left of, above,
     * to the right of, and below the text.  Use 0 if you do not
     * want a Drawable there. The Drawables' bounds will be set to
     * their intrinsic bounds.
     *
     * @param left Resource identifier of the left Drawable.
     * @param top Resource identifier of the top Drawable.
     * @param right Resource identifier of the right Drawable.
     * @param bottom Resource identifier of the bottom Drawable.
     *
     * @attr ref android.R.styleable#TextView_drawableLeft
     * @attr ref android.R.styleable#TextView_drawableTop
     * @attr ref android.R.styleable#TextView_drawableRight
     * @attr ref android.R.styleable#TextView_drawableBottom
     */
    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.625 -0500", hash_original_method = "4DA9B29500DC46492C6684BECC05C749", hash_generated_method = "9B9BC0F73DD37625634172AB556EC2D7")
    
public void setCompoundDrawablesWithIntrinsicBounds(int left, int top, int right, int bottom) {
        final Resources resources = getContext().getResources();
        setCompoundDrawablesWithIntrinsicBounds(left != 0 ? resources.getDrawable(left) : null,
                top != 0 ? resources.getDrawable(top) : null,
                right != 0 ? resources.getDrawable(right) : null,
                bottom != 0 ? resources.getDrawable(bottom) : null);
    }

    /**
     * Sets the Drawables (if any) to appear to the left of, above,
     * to the right of, and below the text.  Use null if you do not
     * want a Drawable there. The Drawables' bounds will be set to
     * their intrinsic bounds.
     *
     * @attr ref android.R.styleable#TextView_drawableLeft
     * @attr ref android.R.styleable#TextView_drawableTop
     * @attr ref android.R.styleable#TextView_drawableRight
     * @attr ref android.R.styleable#TextView_drawableBottom
     */
    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.627 -0500", hash_original_method = "19E536EC7FD9E8E0EBEABA79F37A1C35", hash_generated_method = "3651805090A0EB48DBE5889BE23DEB11")
    
public void setCompoundDrawablesWithIntrinsicBounds(Drawable left, Drawable top,
            Drawable right, Drawable bottom) {

        if (left != null) {
            left.setBounds(0, 0, left.getIntrinsicWidth(), left.getIntrinsicHeight());
        }
        if (right != null) {
            right.setBounds(0, 0, right.getIntrinsicWidth(), right.getIntrinsicHeight());
        }
        if (top != null) {
            top.setBounds(0, 0, top.getIntrinsicWidth(), top.getIntrinsicHeight());
        }
        if (bottom != null) {
            bottom.setBounds(0, 0, bottom.getIntrinsicWidth(), bottom.getIntrinsicHeight());
        }
        setCompoundDrawables(left, top, right, bottom);
    }

    /**
     * Sets the Drawables (if any) to appear to the start of, above,
     * to the end of, and below the text.  Use null if you do not
     * want a Drawable there.  The Drawables must already have had
     * {@link Drawable#setBounds} called.
     *
     * @attr ref android.R.styleable#TextView_drawableStart
     * @attr ref android.R.styleable#TextView_drawableTop
     * @attr ref android.R.styleable#TextView_drawableEnd
     * @attr ref android.R.styleable#TextView_drawableBottom
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.632 -0500", hash_original_method = "C527F166CA85E985387BA0B670132163", hash_generated_method = "5E9C6C84948994B36C0ECF433C2DB08E")
    
public void setCompoundDrawablesRelative(Drawable start, Drawable top,
                                     Drawable end, Drawable bottom) {
        Drawables dr = mDrawables;

        final boolean drawables = start != null || top != null
                || end != null || bottom != null;

        if (!drawables) {
            // Clearing drawables...  can we free the data structure?
            if (dr != null) {
                if (dr.mDrawablePadding == 0) {
                    mDrawables = null;
                } else {
                    // We need to retain the last set padding, so just clear
                    // out all of the fields in the existing structure.
                    if (dr.mDrawableStart != null) dr.mDrawableStart.setCallback(null);
                    dr.mDrawableStart = null;
                    if (dr.mDrawableTop != null) dr.mDrawableTop.setCallback(null);
                    dr.mDrawableTop = null;
                    if (dr.mDrawableEnd != null) dr.mDrawableEnd.setCallback(null);
                    dr.mDrawableEnd = null;
                    if (dr.mDrawableBottom != null) dr.mDrawableBottom.setCallback(null);
                    dr.mDrawableBottom = null;
                    dr.mDrawableSizeStart = dr.mDrawableHeightStart = 0;
                    dr.mDrawableSizeEnd = dr.mDrawableHeightEnd = 0;
                    dr.mDrawableSizeTop = dr.mDrawableWidthTop = 0;
                    dr.mDrawableSizeBottom = dr.mDrawableWidthBottom = 0;
                }
            }
        } else {
            if (dr == null) {
                mDrawables = dr = new Drawables();
            }

            if (dr.mDrawableStart != start && dr.mDrawableStart != null) {
                dr.mDrawableStart.setCallback(null);
            }
            dr.mDrawableStart = start;

            if (dr.mDrawableTop != top && dr.mDrawableTop != null) {
                dr.mDrawableTop.setCallback(null);
            }
            dr.mDrawableTop = top;

            if (dr.mDrawableEnd != end && dr.mDrawableEnd != null) {
                dr.mDrawableEnd.setCallback(null);
            }
            dr.mDrawableEnd = end;

            if (dr.mDrawableBottom != bottom && dr.mDrawableBottom != null) {
                dr.mDrawableBottom.setCallback(null);
            }
            dr.mDrawableBottom = bottom;

            final Rect compoundRect = dr.mCompoundRect;
            int[] state;

            state = getDrawableState();

            if (start != null) {
                start.setState(state);
                start.copyBounds(compoundRect);
                start.setCallback(this);
                dr.mDrawableSizeStart = compoundRect.width();
                dr.mDrawableHeightStart = compoundRect.height();
            } else {
                dr.mDrawableSizeStart = dr.mDrawableHeightStart = 0;
            }

            if (end != null) {
                end.setState(state);
                end.copyBounds(compoundRect);
                end.setCallback(this);
                dr.mDrawableSizeEnd = compoundRect.width();
                dr.mDrawableHeightEnd = compoundRect.height();
            } else {
                dr.mDrawableSizeEnd = dr.mDrawableHeightEnd = 0;
            }

            if (top != null) {
                top.setState(state);
                top.copyBounds(compoundRect);
                top.setCallback(this);
                dr.mDrawableSizeTop = compoundRect.height();
                dr.mDrawableWidthTop = compoundRect.width();
            } else {
                dr.mDrawableSizeTop = dr.mDrawableWidthTop = 0;
            }

            if (bottom != null) {
                bottom.setState(state);
                bottom.copyBounds(compoundRect);
                bottom.setCallback(this);
                dr.mDrawableSizeBottom = compoundRect.height();
                dr.mDrawableWidthBottom = compoundRect.width();
            } else {
                dr.mDrawableSizeBottom = dr.mDrawableWidthBottom = 0;
            }
        }

        resolveDrawables();
        invalidate();
        requestLayout();
    }

    /**
     * Sets the Drawables (if any) to appear to the start of, above,
     * to the end of, and below the text.  Use 0 if you do not
     * want a Drawable there. The Drawables' bounds will be set to
     * their intrinsic bounds.
     *
     * @param start Resource identifier of the start Drawable.
     * @param top Resource identifier of the top Drawable.
     * @param end Resource identifier of the end Drawable.
     * @param bottom Resource identifier of the bottom Drawable.
     *
     * @attr ref android.R.styleable#TextView_drawableStart
     * @attr ref android.R.styleable#TextView_drawableTop
     * @attr ref android.R.styleable#TextView_drawableEnd
     * @attr ref android.R.styleable#TextView_drawableBottom
     *
     * @hide
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.634 -0500", hash_original_method = "08DFFEC64B0A3553E53B210C6E8B4F5B", hash_generated_method = "72EBD4C2521F6306F13066BE513B5F5C")
    
public void setCompoundDrawablesRelativeWithIntrinsicBounds(int start, int top, int end,
            int bottom) {
        resetResolvedDrawables();
        final Resources resources = getContext().getResources();
        setCompoundDrawablesRelativeWithIntrinsicBounds(
                start != 0 ? resources.getDrawable(start) : null,
                top != 0 ? resources.getDrawable(top) : null,
                end != 0 ? resources.getDrawable(end) : null,
                bottom != 0 ? resources.getDrawable(bottom) : null);
    }

    /**
     * Sets the Drawables (if any) to appear to the start of, above,
     * to the end of, and below the text.  Use null if you do not
     * want a Drawable there. The Drawables' bounds will be set to
     * their intrinsic bounds.
     *
     * @attr ref android.R.styleable#TextView_drawableStart
     * @attr ref android.R.styleable#TextView_drawableTop
     * @attr ref android.R.styleable#TextView_drawableEnd
     * @attr ref android.R.styleable#TextView_drawableBottom
     *
     * @hide
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.637 -0500", hash_original_method = "BA79780015035B80B72E7A4B08D0D299", hash_generated_method = "908C3B521766163169408505546967E0")
    
public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable start, Drawable top,
            Drawable end, Drawable bottom) {

        resetResolvedDrawables();
        if (start != null) {
            start.setBounds(0, 0, start.getIntrinsicWidth(), start.getIntrinsicHeight());
        }
        if (end != null) {
            end.setBounds(0, 0, end.getIntrinsicWidth(), end.getIntrinsicHeight());
        }
        if (top != null) {
            top.setBounds(0, 0, top.getIntrinsicWidth(), top.getIntrinsicHeight());
        }
        if (bottom != null) {
            bottom.setBounds(0, 0, bottom.getIntrinsicWidth(), bottom.getIntrinsicHeight());
        }
        setCompoundDrawablesRelative(start, top, end, bottom);
    }

    /**
     * Returns drawables for the left, top, right, and bottom borders.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.639 -0500", hash_original_method = "06FDA6F654D58A3BC65C29C47124F71A", hash_generated_method = "ADB229B4533C834E76946EFEE29915EA")
    
public Drawable[] getCompoundDrawables() {
        final Drawables dr = mDrawables;
        if (dr != null) {
            return new Drawable[] {
                dr.mDrawableLeft, dr.mDrawableTop, dr.mDrawableRight, dr.mDrawableBottom
            };
        } else {
            return new Drawable[] { null, null, null, null };
        }
    }

    /**
     * Returns drawables for the start, top, end, and bottom borders.
     *
     * @hide
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.642 -0500", hash_original_method = "7D536599368FF7E7773D59B2D0C7C092", hash_generated_method = "797EDDFB58B3712A8E08A704255AE3BD")
    
public Drawable[] getCompoundDrawablesRelative() {
        final Drawables dr = mDrawables;
        if (dr != null) {
            return new Drawable[] {
                dr.mDrawableStart, dr.mDrawableTop, dr.mDrawableEnd, dr.mDrawableBottom
            };
        } else {
            return new Drawable[] { null, null, null, null };
        }
    }

    /**
     * Sets the size of the padding between the compound drawables and
     * the text.
     *
     * @attr ref android.R.styleable#TextView_drawablePadding
     */
    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.644 -0500", hash_original_method = "7E4DBC59802038B0E00C34B579D2DA37", hash_generated_method = "B9127CDB964D8FC4860500F15BC6C84F")
    
public void setCompoundDrawablePadding(int pad) {
        Drawables dr = mDrawables;
        if (pad == 0) {
            if (dr != null) {
                dr.mDrawablePadding = pad;
            }
        } else {
            if (dr == null) {
                mDrawables = dr = new Drawables();
            }
            dr.mDrawablePadding = pad;
        }

        invalidate();
        requestLayout();
    }

    /**
     * Returns the padding between the compound drawables and the text.
     */
    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.646 -0500", hash_original_method = "6B458DA6759E58857DA3CAF4E6D1B789", hash_generated_method = "090F1D2E56867401DC85DB95E3C8BCF8")
    
public int getCompoundDrawablePadding() {
        final Drawables dr = mDrawables;
        return dr != null ? dr.mDrawablePadding : 0;
    }

    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.649 -0500", hash_original_method = "4C42E9479946D6D8F38619DA66232863", hash_generated_method = "FA118EB41CF7D8B2AE88A6737B993C6A")
    
@Override
    public void setPadding(int left, int top, int right, int bottom) {
        if (left != mPaddingLeft ||
            right != mPaddingRight ||
            top != mPaddingTop ||
            bottom != mPaddingBottom) {
            nullLayouts();
        }

        // the super call will requestLayout()
        super.setPadding(left, top, right, bottom);
        invalidate();
    }

    /**
     * Gets the autolink mask of the text.  See {@link
     * android.text.util.Linkify#ALL Linkify.ALL} and peers for
     * possible values.
     *
     * @attr ref android.R.styleable#TextView_autoLink
     */
    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.651 -0500", hash_original_method = "D796BA921A3359840CCD26FF0DD1CFB0", hash_generated_method = "D1CD23461D8086CABB7BD04AEEAAB198")
    
public final int getAutoLinkMask() {
        return mAutoLinkMask;
    }

    /**
     * Sets the text color, size, style, hint color, and highlight color
     * from the specified TextAppearance resource.
     */
    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.654 -0500", hash_original_method = "FFEF779179433D30901B486DA8C4C9D0", hash_generated_method = "47F0432AEA180ACF38ECBDDDB45C9850")
    
public void setTextAppearance(Context context, int resid) {
        TypedArray appearance =
            context.obtainStyledAttributes(resid,
                                           com.android.internal.R.styleable.TextAppearance);

        int color;
        ColorStateList colors;
        int ts;

        color = appearance.getColor(com.android.internal.R.styleable.TextAppearance_textColorHighlight, 0);
        if (color != 0) {
            setHighlightColor(color);
        }

        colors = appearance.getColorStateList(com.android.internal.R.styleable.
                                              TextAppearance_textColor);
        if (colors != null) {
            setTextColor(colors);
        }

        ts = appearance.getDimensionPixelSize(com.android.internal.R.styleable.
                                              TextAppearance_textSize, 0);
        if (ts != 0) {
            setRawTextSize(ts);
        }

        colors = appearance.getColorStateList(com.android.internal.R.styleable.
                                              TextAppearance_textColorHint);
        if (colors != null) {
            setHintTextColor(colors);
        }

        colors = appearance.getColorStateList(com.android.internal.R.styleable.
                                              TextAppearance_textColorLink);
        if (colors != null) {
            setLinkTextColor(colors);
        }

        int typefaceIndex, styleIndex;

        typefaceIndex = appearance.getInt(com.android.internal.R.styleable.
                                          TextAppearance_typeface, -1);
        styleIndex = appearance.getInt(com.android.internal.R.styleable.
                                       TextAppearance_textStyle, -1);

        setTypefaceByIndex(typefaceIndex, styleIndex);

        if (appearance.getBoolean(com.android.internal.R.styleable.TextAppearance_textAllCaps,
                false)) {
            setTransformationMethod(new AllCapsTransformationMethod(getContext()));
        }

        appearance.recycle();
    }

    /**
     * @return the size (in pixels) of the default text size in this TextView.
     */
    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.656 -0500", hash_original_method = "5E6FE671862457C6BB25EDC2CEDE399B", hash_generated_method = "94450DCF9C4C7307EE77B37B73EA2C43")
    
public float getTextSize() {
        return mTextPaint.getTextSize();
    }

    /**
     * Set the default text size to the given value, interpreted as "scaled
     * pixel" units.  This size is adjusted based on the current density and
     * user font size preference.
     *
     * @param size The scaled pixel size.
     *
     * @attr ref android.R.styleable#TextView_textSize
     */
    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.658 -0500", hash_original_method = "7DB2A551583349AB1C418E0528006365", hash_generated_method = "B390E22B85EE4C4563DD2C9B1E564055")
    
@android.view.RemotableViewMethod
    public void setTextSize(float size) {
        setTextSize(TypedValue.COMPLEX_UNIT_SP, size);
    }

    /**
     * Set the default text size to a given unit and value.  See {@link
     * TypedValue} for the possible dimension units.
     *
     * @param unit The desired dimension unit.
     * @param size The desired size in the given units.
     *
     * @attr ref android.R.styleable#TextView_textSize
     */
    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.660 -0500", hash_original_method = "487975E6A0CF72E721F7BDECB44E1312", hash_generated_method = "4B39AC24B650C96ECA78ECD296D29BD0")
    
public void setTextSize(int unit, float size) {
        Context c = getContext();
        Resources r;

        if (c == null)
            r = Resources.getSystem();
        else
            r = c.getResources();

        setRawTextSize(TypedValue.applyDimension(
            unit, size, r.getDisplayMetrics()));
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.662 -0500", hash_original_method = "ADDFE88D6F3490AE157EE578011F4FFC", hash_generated_method = "7E7C3774CA72F97E5610C71FBF88E94F")
    
private void setRawTextSize(float size) {
        if (size != mTextPaint.getTextSize()) {
            mTextPaint.setTextSize(size);

            if (mLayout != null) {
                nullLayouts();
                requestLayout();
                invalidate();
            }
        }
    }

    /**
     * @return the extent by which text is currently being stretched
     * horizontally.  This will usually be 1.
     */
    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.665 -0500", hash_original_method = "8F71F8091E79DE5D49BC786B53F6B56F", hash_generated_method = "9A057D0C6F3A8C87D5D6EEBAAD8FB4E7")
    
public float getTextScaleX() {
        return mTextPaint.getTextScaleX();
    }

    /**
     * Sets the extent by which text should be stretched horizontally.
     *
     * @attr ref android.R.styleable#TextView_textScaleX
     */
    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.668 -0500", hash_original_method = "32FC23A8E8D24759E03CF98EE692BD3E", hash_generated_method = "64688DEE4444BF4E1365AA667E3031F4")
    
@android.view.RemotableViewMethod
    public void setTextScaleX(float size) {
        if (size != mTextPaint.getTextScaleX()) {
            mUserSetTextScaleX = true;
            mTextPaint.setTextScaleX(size);

            if (mLayout != null) {
                nullLayouts();
                requestLayout();
                invalidate();
            }
        }
    }

    /**
     * Sets the typeface and style in which the text should be displayed.
     * Note that not all Typeface families actually have bold and italic
     * variants, so you may need to use
     * {@link #setTypeface(Typeface, int)} to get the appearance
     * that you actually want.
     *
     * @attr ref android.R.styleable#TextView_typeface
     * @attr ref android.R.styleable#TextView_textStyle
     */
    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.671 -0500", hash_original_method = "780D15535FA403FCFD3F32D6E7303769", hash_generated_method = "6847AC35599A30DFD5FF0D7ECC908CC0")
    
public void setTypeface(Typeface tf) {
        if (mTextPaint.getTypeface() != tf) {
            mTextPaint.setTypeface(tf);

            if (mLayout != null) {
                nullLayouts();
                requestLayout();
                invalidate();
            }
        }
    }

    /**
     * @return the current typeface and style in which the text is being
     * displayed.
     */
    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.673 -0500", hash_original_method = "6FFDE601A24D081BE5F9A52F7BB654E9", hash_generated_method = "1A3B4DE5628EDD5C3401E8C0E04E04DA")
    
public Typeface getTypeface() {
        return mTextPaint.getTypeface();
    }

    /**
     * Sets the text color for all the states (normal, selected,
     * focused) to be this color.
     *
     * @attr ref android.R.styleable#TextView_textColor
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.675 -0500", hash_original_method = "7D6C422943C1CBA6B222D2B0CA531386", hash_generated_method = "5D82075A69C90ECDFAAB52071D154026")
    
@android.view.RemotableViewMethod
    public void setTextColor(int color) {
        mTextColor = ColorStateList.valueOf(color);
        updateTextColors();
    }

    /**
     * Sets the text color.
     *
     * @attr ref android.R.styleable#TextView_textColor
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.677 -0500", hash_original_method = "E5548FB85C1126384CE08AD8E1667A0C", hash_generated_method = "C8CAFCEF19E8342E0BA4A2A316014CAE")
    
public void setTextColor(ColorStateList colors) {
        if (colors == null) {
            throw new NullPointerException();
        }

        mTextColor = colors;
        updateTextColors();
    }

    /**
     * Return the set of text colors.
     *
     * @return Returns the set of text colors.
     */
    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.679 -0500", hash_original_method = "E9708E6780595497A0F38B1A3DFD4921", hash_generated_method = "7370868768EEE725AC2F3C6CF89297D0")
    
public final ColorStateList getTextColors() {
        return mTextColor;
    }

    /**
     * <p>Return the current color selected for normal text.</p>
     *
     * @return Returns the current text color.
     */
    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.681 -0500", hash_original_method = "69BC167CA8CC0024E4446D6ED57F972B", hash_generated_method = "898D05C80349DD6D3D99FB82A7141A2D")
    
public final int getCurrentTextColor() {
        return mCurTextColor;
    }

    /**
     * Sets the color used to display the selection highlight.
     *
     * @attr ref android.R.styleable#TextView_textColorHighlight
     */
    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.684 -0500", hash_original_method = "969DDD835D55F329C6E2048E92EE3D41", hash_generated_method = "4923792194FED149CB4D2D0C8D5E25A2")
    
@android.view.RemotableViewMethod
    public void setHighlightColor(int color) {
        if (mHighlightColor != color) {
            mHighlightColor = color;
            invalidate();
        }
    }

    /**
     * Gives the text a shadow of the specified radius and color, the specified
     * distance from its normal position.
     *
     * @attr ref android.R.styleable#TextView_shadowColor
     * @attr ref android.R.styleable#TextView_shadowDx
     * @attr ref android.R.styleable#TextView_shadowDy
     * @attr ref android.R.styleable#TextView_shadowRadius
     */
    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.686 -0500", hash_original_method = "5ADAC484D4689A7795B408EA7D6B6AC8", hash_generated_method = "D9A0F8E0625DD40D24B5960DDBF854DC")
    
public void setShadowLayer(float radius, float dx, float dy, int color) {
        mTextPaint.setShadowLayer(radius, dx, dy, color);

        mShadowRadius = radius;
        mShadowDx = dx;
        mShadowDy = dy;

        invalidate();
    }

    /**
     * @return the base paint used for the text.  Please use this only to
     * consult the Paint's properties and not to change them.
     */
    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.688 -0500", hash_original_method = "5B4E8CD3DF4A8D21F89EBB7BF27B30F6", hash_generated_method = "4953D3639DA9E295D920AA591AADA99B")
    
public TextPaint getPaint() {
        return mTextPaint;
    }

    /**
     * Sets the autolink mask of the text.  See {@link
     * android.text.util.Linkify#ALL Linkify.ALL} and peers for
     * possible values.
     *
     * @attr ref android.R.styleable#TextView_autoLink
     */
    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.690 -0500", hash_original_method = "9B238C42610AAE77586EFF469787CAA2", hash_generated_method = "DDDC434B229E17B0F6C960BAA275563A")
    
@android.view.RemotableViewMethod
    public final void setAutoLinkMask(int mask) {
        mAutoLinkMask = mask;
    }

    /**
     * Sets whether the movement method will automatically be set to
     * {@link LinkMovementMethod} if {@link #setAutoLinkMask} has been
     * set to nonzero and links are detected in {@link #setText}.
     * The default is true.
     *
     * @attr ref android.R.styleable#TextView_linksClickable
     */
    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.693 -0500", hash_original_method = "E276016FD2FFF976FC669270E78164FC", hash_generated_method = "7A7E99862C11406041A0B552AE139D04")
    
@android.view.RemotableViewMethod
    public final void setLinksClickable(boolean whether) {
        mLinksClickable = whether;
    }

    /**
     * Returns whether the movement method will automatically be set to
     * {@link LinkMovementMethod} if {@link #setAutoLinkMask} has been
     * set to nonzero and links are detected in {@link #setText}.
     * The default is true.
     *
     * @attr ref android.R.styleable#TextView_linksClickable
     */
    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.695 -0500", hash_original_method = "5582C38299F4F11EB9D233BD445CE8CA", hash_generated_method = "53CD913A92D144F9BA5A09F48C1302B7")
    
public final boolean getLinksClickable() {
        return mLinksClickable;
    }

    /**
     * Sets whether the soft input method will be made visible when this
     * TextView gets focused. The default is true.
     *
     * @attr ref android.R.styleable#TextView_softInputShownOnFocus
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.697 -0500", hash_original_method = "4DF4A96EB5A0519062801E1FD0A991F4", hash_generated_method = "7983E7803CEE81875AFD98EF981F7122")
    
@android.view.RemotableViewMethod
    public final void setSoftInputShownOnFocus(boolean show) {
        mSoftInputShownOnFocus = show;
    }

    /**
     * Returns whether the soft input method will be made visible when this
     * TextView gets focused. The default is true.
     *
     * @attr ref android.R.styleable#TextView_softInputShownOnFocus
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.699 -0500", hash_original_method = "5A10A6630E4A15A93780A83DCE21BFA6", hash_generated_method = "4443E2C94F339B471578086473E80693")
    
public final boolean getSoftInputShownOnFocus() {
        return mSoftInputShownOnFocus;
    }

    /**
     * Returns the list of URLSpans attached to the text
     * (by {@link Linkify} or otherwise) if any.  You can call
     * {@link URLSpan#getURL} on them to find where they link to
     * or use {@link Spanned#getSpanStart} and {@link Spanned#getSpanEnd}
     * to find the region of the text they are attached to.
     */
    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.702 -0500", hash_original_method = "7722BA5204257A1CDED1550384208856", hash_generated_method = "16D9C1AF637BC963D3AB4AEE56CAE387")
    
public URLSpan[] getUrls() {
        if (mText instanceof Spanned) {
            return ((Spanned) mText).getSpans(0, mText.length(), URLSpan.class);
        } else {
            return new URLSpan[0];
        }
    }

    /**
     * Sets the color of the hint text.
     *
     * @attr ref android.R.styleable#TextView_textColorHint
     */
    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.704 -0500", hash_original_method = "E9B4A1B921938A82A5322DAF3992AE5D", hash_generated_method = "120A062D047149D3E557DDFB3EF653A8")
    
@android.view.RemotableViewMethod
    public final void setHintTextColor(int color) {
        mHintTextColor = ColorStateList.valueOf(color);
        updateTextColors();
    }

    /**
     * Sets the color of the hint text.
     *
     * @attr ref android.R.styleable#TextView_textColorHint
     */
    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.706 -0500", hash_original_method = "FDEA4F057DD6E07AD523C7053B227866", hash_generated_method = "AE7772992C0B8CEF3932CA1CA430BC0E")
    
public final void setHintTextColor(ColorStateList colors) {
        mHintTextColor = colors;
        updateTextColors();
    }

    /**
     * <p>Return the color used to paint the hint text.</p>
     *
     * @return Returns the list of hint text colors.
     */
    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.708 -0500", hash_original_method = "475EC0453C7F74E6A779EAD7F8319059", hash_generated_method = "D5B803A9EB9B7CC4A713C401EE4AD557")
    
public final ColorStateList getHintTextColors() {
        return mHintTextColor;
    }

    /**
     * <p>Return the current color selected to paint the hint text.</p>
     *
     * @return Returns the current hint text color.
     */
    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.711 -0500", hash_original_method = "1826756F3CA2F0D97D555C81DC90D9D1", hash_generated_method = "38EDD1A900BDA63B4C18954FE58B5474")
    
public final int getCurrentHintTextColor() {
        return mHintTextColor != null ? mCurHintTextColor : mCurTextColor;
    }

    /**
     * Sets the color of links in the text.
     *
     * @attr ref android.R.styleable#TextView_textColorLink
     */
    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.713 -0500", hash_original_method = "9463279339C3C6EB304729CC6A96FD58", hash_generated_method = "CB446DABA47884E309A73BEDA5242760")
    
@android.view.RemotableViewMethod
    public final void setLinkTextColor(int color) {
        mLinkTextColor = ColorStateList.valueOf(color);
        updateTextColors();
    }

    /**
     * Sets the color of links in the text.
     *
     * @attr ref android.R.styleable#TextView_textColorLink
     */
    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.716 -0500", hash_original_method = "9B67E7CBCE87C562841DDA31DA1BE653", hash_generated_method = "5C0768F661C3B98228F6CFEAD54FBE47")
    
public final void setLinkTextColor(ColorStateList colors) {
        mLinkTextColor = colors;
        updateTextColors();
    }

    /**
     * <p>Returns the color used to paint links in the text.</p>
     *
     * @return Returns the list of link text colors.
     */
    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.718 -0500", hash_original_method = "3A49B90BEACC4CBB32A44A5B9C48739C", hash_generated_method = "5981F761ADA030EEC832386D8D02EA29")
    
public final ColorStateList getLinkTextColors() {
        return mLinkTextColor;
    }

    /**
     * Sets the horizontal alignment of the text and the
     * vertical gravity that will be used when there is extra space
     * in the TextView beyond what is required for the text itself.
     *
     * @see android.view.Gravity
     * @attr ref android.R.styleable#TextView_gravity
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.721 -0500", hash_original_method = "AEAA45BF8B2B9C05CF6AA4E644080F44", hash_generated_method = "E75FCD919D6A7010B0A9971D266B80B8")
    
public void setGravity(int gravity) {
        if ((gravity & Gravity.RELATIVE_HORIZONTAL_GRAVITY_MASK) == 0) {
            gravity |= Gravity.START;
        }
        if ((gravity & Gravity.VERTICAL_GRAVITY_MASK) == 0) {
            gravity |= Gravity.TOP;
        }

        boolean newLayout = false;

        if ((gravity & Gravity.RELATIVE_HORIZONTAL_GRAVITY_MASK) !=
            (mGravity & Gravity.RELATIVE_HORIZONTAL_GRAVITY_MASK)) {
            newLayout = true;
        }

        if (gravity != mGravity) {
            invalidate();
            mLayoutAlignment = null;
        }

        mGravity = gravity;

        if (mLayout != null && newLayout) {
            // XXX this is heavy-handed because no actual content changes.
            int want = mLayout.getWidth();
            int hintWant = mHintLayout == null ? 0 : mHintLayout.getWidth();

            makeNewLayout(want, hintWant, UNKNOWN_BORING, UNKNOWN_BORING,
                          mRight - mLeft - getCompoundPaddingLeft() -
                          getCompoundPaddingRight(), true);
        }
    }

    /**
     * Returns the horizontal and vertical alignment of this TextView.
     *
     * @see android.view.Gravity
     * @attr ref android.R.styleable#TextView_gravity
     */
    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.723 -0500", hash_original_method = "80A4065F7A7EA77AF4C4ADD19E36F9A5", hash_generated_method = "34250BBFB3A98B1274520CC4DAA66C94")
    
public int getGravity() {
        return mGravity;
    }

    /**
     * @return the flags on the Paint being used to display the text.
     * @see Paint#getFlags
     */
    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.725 -0500", hash_original_method = "7C7AF1B698E75A76793B55FAC07B7AAB", hash_generated_method = "C7BEB0290B740CD26F8377E078D4D96A")
    
public int getPaintFlags() {
        return mTextPaint.getFlags();
    }

    /**
     * Sets flags on the Paint being used to display the text and
     * reflows the text if they are different from the old flags.
     * @see Paint#setFlags
     */
    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.727 -0500", hash_original_method = "8002046373E96371B4D25FE3E547C1A2", hash_generated_method = "9B52C2B1C6E75FA8158063D2828BC0CF")
    
@android.view.RemotableViewMethod
    public void setPaintFlags(int flags) {
        if (mTextPaint.getFlags() != flags) {
            mTextPaint.setFlags(flags);

            if (mLayout != null) {
                nullLayouts();
                requestLayout();
                invalidate();
            }
        }
    }

    /**
     * Sets whether the text should be allowed to be wider than the
     * View is.  If false, it will be wrapped to the width of the View.
     *
     * @attr ref android.R.styleable#TextView_scrollHorizontally
     */
    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.729 -0500", hash_original_method = "EA5DCBED1A48E34EEA6259FD93E64EB0", hash_generated_method = "6F8275EAED5DC153C7390C0F21043C48")
    
public void setHorizontallyScrolling(boolean whether) {
        if (mHorizontallyScrolling != whether) {
            mHorizontallyScrolling = whether;

            if (mLayout != null) {
                nullLayouts();
                requestLayout();
                invalidate();
            }
        }
    }

    /**
     * Returns whether the text is allowed to be wider than the View is.
     * If false, the text will be wrapped to the width of the View.
     *
     * @attr ref android.R.styleable#TextView_scrollHorizontally
     * @hide
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.732 -0500", hash_original_method = "7B94D421E91473A8A956329EBDF6A0E9", hash_generated_method = "7F5524A321700835AF38C6DB60B2B9B4")
    
public boolean getHorizontallyScrolling() {
        return mHorizontallyScrolling;
    }

    /**
     * Makes the TextView at least this many lines tall.
     *
     * Setting this value overrides any other (minimum) height setting. A single line TextView will
     * set this value to 1.
     *
     * @attr ref android.R.styleable#TextView_minLines
     */
    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.734 -0500", hash_original_method = "0EE7081F083B0DC579019805442C8765", hash_generated_method = "D2C1B38292991068644A1FBE464CAEE1")
    
@android.view.RemotableViewMethod
    public void setMinLines(int minlines) {
        mMinimum = minlines;
        mMinMode = LINES;

        requestLayout();
        invalidate();
    }

    /**
     * Makes the TextView at least this many pixels tall.
     *
     * Setting this value overrides any other (minimum) number of lines setting.
     *
     * @attr ref android.R.styleable#TextView_minHeight
     */
    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.737 -0500", hash_original_method = "68757877A1DD20E33F15DE32FA3B7F07", hash_generated_method = "0FF850DF06C4F28A466143FEE45BC427")
    
@android.view.RemotableViewMethod
    public void setMinHeight(int minHeight) {
        mMinimum = minHeight;
        mMinMode = PIXELS;

        requestLayout();
        invalidate();
    }

    /**
     * Makes the TextView at most this many lines tall.
     *
     * Setting this value overrides any other (maximum) height setting.
     *
     * @attr ref android.R.styleable#TextView_maxLines
     */
    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.739 -0500", hash_original_method = "8B36C1E1F9FD83BB5DA2A8A03A7A6664", hash_generated_method = "91B4E49ECC2C6B1A2E745FAC9A84C187")
    
@android.view.RemotableViewMethod
    public void setMaxLines(int maxlines) {
        mMaximum = maxlines;
        mMaxMode = LINES;

        requestLayout();
        invalidate();
    }

    /**
     * Makes the TextView at most this many pixels tall.  This option is mutually exclusive with the
     * {@link #setMaxLines(int)} method.
     *
     * Setting this value overrides any other (maximum) number of lines setting.
     *
     * @attr ref android.R.styleable#TextView_maxHeight
     */
    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.742 -0500", hash_original_method = "04C4C22BF9024D43E2A856D219B26DEF", hash_generated_method = "A361D76AEABB965DC999CFE707A8ADBC")
    
@android.view.RemotableViewMethod
    public void setMaxHeight(int maxHeight) {
        mMaximum = maxHeight;
        mMaxMode = PIXELS;

        requestLayout();
        invalidate();
    }

    /**
     * Makes the TextView exactly this many lines tall.
     *
     * Note that setting this value overrides any other (minimum / maximum) number of lines or
     * height setting. A single line TextView will set this value to 1.
     *
     * @attr ref android.R.styleable#TextView_lines
     */
    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.744 -0500", hash_original_method = "1ADF089518552DEF85C429E373D0543D", hash_generated_method = "3B146C9A775AA8A1587A1153B7727E6F")
    
@android.view.RemotableViewMethod
    public void setLines(int lines) {
        mMaximum = mMinimum = lines;
        mMaxMode = mMinMode = LINES;

        requestLayout();
        invalidate();
    }

    /**
     * Makes the TextView exactly this many pixels tall.
     * You could do the same thing by specifying this number in the
     * LayoutParams.
     *
     * Note that setting this value overrides any other (minimum / maximum) number of lines or
     * height setting.
     *
     * @attr ref android.R.styleable#TextView_height
     */
    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.746 -0500", hash_original_method = "6CD9B04ABBE9A4E392854E2FFBA64155", hash_generated_method = "986EF61126B4C904641C9AC9B17D406E")
    
@android.view.RemotableViewMethod
    public void setHeight(int pixels) {
        mMaximum = mMinimum = pixels;
        mMaxMode = mMinMode = PIXELS;

        requestLayout();
        invalidate();
    }

    /**
     * Makes the TextView at least this many ems wide
     *
     * @attr ref android.R.styleable#TextView_minEms
     */
    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.748 -0500", hash_original_method = "6EF109AA0B8A98B265CEDBFE77B13F24", hash_generated_method = "8DD8A7EE69C891F1593C436E5DDCFAED")
    
@android.view.RemotableViewMethod
    public void setMinEms(int minems) {
        mMinWidth = minems;
        mMinWidthMode = EMS;

        requestLayout();
        invalidate();
    }

    /**
     * Makes the TextView at least this many pixels wide
     *
     * @attr ref android.R.styleable#TextView_minWidth
     */
    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.750 -0500", hash_original_method = "CC5034BC1B28BBCD01B0947E11300CEA", hash_generated_method = "DDAE4F14CBA19A9DBBF5EB58AA161A29")
    
@android.view.RemotableViewMethod
    public void setMinWidth(int minpixels) {
        mMinWidth = minpixels;
        mMinWidthMode = PIXELS;

        requestLayout();
        invalidate();
    }

    /**
     * Makes the TextView at most this many ems wide
     *
     * @attr ref android.R.styleable#TextView_maxEms
     */
    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.752 -0500", hash_original_method = "024C424B12C855A76B8C4D4EF37E56E9", hash_generated_method = "AB0C98CC1DE8A0E4E6EA83BB04824AE4")
    
@android.view.RemotableViewMethod
    public void setMaxEms(int maxems) {
        mMaxWidth = maxems;
        mMaxWidthMode = EMS;

        requestLayout();
        invalidate();
    }

    /**
     * Makes the TextView at most this many pixels wide
     *
     * @attr ref android.R.styleable#TextView_maxWidth
     */
    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.755 -0500", hash_original_method = "66D27E295E9935EDB856E68754ECCF50", hash_generated_method = "7FF72A4FC7B9970BD8FA69B64C371EE6")
    
@android.view.RemotableViewMethod
    public void setMaxWidth(int maxpixels) {
        mMaxWidth = maxpixels;
        mMaxWidthMode = PIXELS;

        requestLayout();
        invalidate();
    }

    /**
     * Makes the TextView exactly this many ems wide
     *
     * @attr ref android.R.styleable#TextView_ems
     */
    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.757 -0500", hash_original_method = "29184B32707510663C7CC00A1776202A", hash_generated_method = "88DBE3FCAE4EF8EBC9E8D0B8884C9608")
    
@android.view.RemotableViewMethod
    public void setEms(int ems) {
        mMaxWidth = mMinWidth = ems;
        mMaxWidthMode = mMinWidthMode = EMS;

        requestLayout();
        invalidate();
    }

    /**
     * Makes the TextView exactly this many pixels wide.
     * You could do the same thing by specifying this number in the
     * LayoutParams.
     *
     * @attr ref android.R.styleable#TextView_width
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.760 -0500", hash_original_method = "A6A8746AE8743344ECC9244BF17B5285", hash_generated_method = "0FBE8584598089087FAB0BEA1EF2382B")
    
@android.view.RemotableViewMethod
    public void setWidth(int pixels) {
        mMaxWidth = mMinWidth = pixels;
        mMaxWidthMode = mMinWidthMode = PIXELS;

        requestLayout();
        invalidate();
    }

    /**
     * Sets line spacing for this TextView.  Each line will have its height
     * multiplied by <code>mult</code> and have <code>add</code> added to it.
     *
     * @attr ref android.R.styleable#TextView_lineSpacingExtra
     * @attr ref android.R.styleable#TextView_lineSpacingMultiplier
     */
    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.762 -0500", hash_original_method = "9D5DCCC1076394887EA3B21F5DF8F706", hash_generated_method = "D2012D9F9B91DBF8E2F8131BA5F72474")
    
public void setLineSpacing(float add, float mult) {
        if (mSpacingAdd != add || mSpacingMult != mult) {
            mSpacingAdd = add;
            mSpacingMult = mult;

            if (mLayout != null) {
                nullLayouts();
                requestLayout();
                invalidate();
            }
        }
    }

    /**
     * Convenience method: Append the specified text to the TextView's
     * display buffer, upgrading it to BufferType.EDITABLE if it was
     * not already editable.
     */
    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.764 -0500", hash_original_method = "699FFD9CCBE3B133871A47DAD4072321", hash_generated_method = "491A2E07FFF7EE4D5F0C0688AD583155")
    
public final void append(CharSequence text) {
        append(text, 0, text.length());
    }
    
    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.520 -0400", hash_original_method = "B2621C1C8DC7A6B197F310747926C024", hash_generated_method = "2D8CCB202FABF6DFC18EDB9314F71358")
    public void append(CharSequence text, int start, int end) {
        //addTaint(end);
        //addTaint(start);
        //addTaint(text.getTaint());
        /*if(!(mText instanceof Editable))        
        {
            setText(mText, BufferType.EDITABLE);
        }*/ //End block
        ((Editable) mText).append(text, start, end);
        // ---------- Original Method ----------
        //if (!(mText instanceof Editable)) {
        //setText(mText, BufferType.EDITABLE);
        //}
        //((Editable) mText).append(text, start, end);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.769 -0500", hash_original_method = "ADC7043537742A0A0C5E53BD45A182BE", hash_generated_method = "B61337613F1B72DFDED0DF5C7A1F4555")
    
private void updateTextColors() {
        boolean inval = false;
        int color = mTextColor.getColorForState(getDrawableState(), 0);
        if (color != mCurTextColor) {
            mCurTextColor = color;
            inval = true;
        }
        if (mLinkTextColor != null) {
            color = mLinkTextColor.getColorForState(getDrawableState(), 0);
            if (color != mTextPaint.linkColor) {
                mTextPaint.linkColor = color;
                inval = true;
            }
        }
        if (mHintTextColor != null) {
            color = mHintTextColor.getColorForState(getDrawableState(), 0);
            if (color != mCurHintTextColor && mText.length() == 0) {
                mCurHintTextColor = color;
                inval = true;
            }
        }
        if (inval) {
            invalidate();
        }
    }

    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.773 -0500", hash_original_method = "3E3CC8861E854C1E6B450E5CB8D8974F", hash_generated_method = "2B51386E2D838BC822FD4852A37E2AE7")
    
@Override
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (mTextColor != null && mTextColor.isStateful()
                || (mHintTextColor != null && mHintTextColor.isStateful())
                || (mLinkTextColor != null && mLinkTextColor.isStateful())) {
            updateTextColors();
        }

        final Drawables dr = mDrawables;
        if (dr != null) {
            int[] state = getDrawableState();
            if (dr.mDrawableTop != null && dr.mDrawableTop.isStateful()) {
                dr.mDrawableTop.setState(state);
            }
            if (dr.mDrawableBottom != null && dr.mDrawableBottom.isStateful()) {
                dr.mDrawableBottom.setState(state);
            }
            if (dr.mDrawableLeft != null && dr.mDrawableLeft.isStateful()) {
                dr.mDrawableLeft.setState(state);
            }
            if (dr.mDrawableRight != null && dr.mDrawableRight.isStateful()) {
                dr.mDrawableRight.setState(state);
            }
            if (dr.mDrawableStart != null && dr.mDrawableStart.isStateful()) {
                dr.mDrawableStart.setState(state);
            }
            if (dr.mDrawableEnd != null && dr.mDrawableEnd.isStateful()) {
                dr.mDrawableEnd.setState(state);
            }
        }
    }

    @DSComment("Data serialization/deserialization")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.808 -0500", hash_original_method = "AF2C3EA4891B79A54157B80D9A5CB454", hash_generated_method = "ED1315019FB24AA6DDAC1BA41A154249")
    
@Override
    public Parcelable onSaveInstanceState() {
        Parcelable superState = super.onSaveInstanceState();

        // Save state if we are forced to
        boolean save = mFreezesText;
        int start = 0;
        int end = 0;

        if (mText != null) {
            start = getSelectionStart();
            end = getSelectionEnd();
            if (start >= 0 || end >= 0) {
                // Or save state if there is a selection
                save = true;
            }
        }

        if (save) {
            SavedState ss = new SavedState(superState);
            // XXX Should also save the current scroll position!
            ss.selStart = start;
            ss.selEnd = end;

            if (mText instanceof Spanned) {
                /*
                 * Calling setText() strips off any ChangeWatchers;
                 * strip them now to avoid leaking references.
                 * But do it to a copy so that if there are any
                 * further changes to the text of this view, it
                 * won't get into an inconsistent state.
                 */

                Spannable sp = new SpannableString(mText);

                for (ChangeWatcher cw : sp.getSpans(0, sp.length(), ChangeWatcher.class)) {
                    sp.removeSpan(cw);
                }

                removeMisspelledSpans(sp);
                sp.removeSpan(mSuggestionRangeSpan);

                ss.text = sp;
            } else {
                ss.text = mText.toString();
            }

            if (isFocused() && start >= 0 && end >= 0) {
                ss.frozenWithFocus = true;
            }

            ss.error = mError;

            return ss;
        }

        return superState;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.810 -0500", hash_original_method = "F2FC1C379415C0983647E04C4964FB91", hash_generated_method = "F2FC1C379415C0983647E04C4964FB91")
    
void removeMisspelledSpans(Spannable spannable) {
        SuggestionSpan[] suggestionSpans = spannable.getSpans(0, spannable.length(),
                SuggestionSpan.class);
        for (int i = 0; i < suggestionSpans.length; i++) {
            int flags = suggestionSpans[i].getFlags();
            if ((flags & SuggestionSpan.FLAG_EASY_CORRECT) != 0
                    && (flags & SuggestionSpan.FLAG_MISSPELLED) != 0) {
                spannable.removeSpan(suggestionSpans[i]);
            }
        }
    }
    
    @DSComment("Data serialization/deserialization")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.529 -0400", hash_original_method = "F50E2D5CE86BF5E6A61BC8360971F12F", hash_generated_method = "A34771C5481C8B20DDC170D4768E54D2")
    @Override
    public void onRestoreInstanceState(Parcelable state) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        //addTaint(state.getTaint());
        if(!(state instanceof SavedState))        
        {
            super.onRestoreInstanceState(state);
            return;
        } //End block
        SavedState ss = (SavedState)state;
        super.onRestoreInstanceState(ss.getSuperState());
        if(ss.text != null)        
        {
            //setText(ss.text);
        } //End block
        if(ss.selStart >= 0 && ss.selEnd >= 0)        
        {
            if(mText instanceof Spannable)            
            {
                int len = mText.length();
                if(ss.selStart > len || ss.selEnd > len)                
                {
                    String restored = "";
                    if(ss.text != null)                    
                    {
                        restored = "(restored) ";
                    } //End block
                } //End block
                else
                {
                    Selection.setSelection((Spannable) mText, ss.selStart,
                        ss.selEnd);
                    if(ss.frozenWithFocus)                    
                    {
                        mFrozenWithFocus = true;
                    } //End block
                } //End block
            } //End block
        } //End block
        if(ss.error != null)        
        {
            final CharSequence error = ss.error;
            post(new Runnable() {
                @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.813 -0500", hash_original_method = "6D4719BAECED3DD83F9692F93AFBC954", hash_generated_method = "ECFDA33AAC392651DB41463C65C4CF3B")
                
public void run() {
                    setError(error);
                }
            });
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    /**
     * Control whether this text view saves its entire text contents when
     * freezing to an icicle, in addition to dynamic state such as cursor
     * position.  By default this is false, not saving the text.  Set to true
     * if the text in the text view is not being saved somewhere else in
     * persistent storage (such as in a content provider) so that if the
     * view is later thawed the user will not lose their data.
     *
     * @param freezesText Controls whether a frozen icicle should include the
     * entire text data: true to include it, false to not.
     *
     * @attr ref android.R.styleable#TextView_freezesText
     */
    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.818 -0500", hash_original_method = "73E23EE9831A5ABB45118C6D9D08B19B", hash_generated_method = "13CC444C5C8D51347F5342E0293BADA8")
    
@android.view.RemotableViewMethod
    public void setFreezesText(boolean freezesText) {
        mFreezesText = freezesText;
    }

    /**
     * Return whether this text view is including its entire text contents
     * in frozen icicles.
     *
     * @return Returns true if text is included, false if it isn't.
     *
     * @see #setFreezesText
     */
    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.820 -0500", hash_original_method = "8E3F839ECE8B91BC1C15216DAAE76890", hash_generated_method = "C8C8237A825C6C7A016CBC4939E4E58B")
    
public boolean getFreezesText() {
        return mFreezesText;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.529 -0400", hash_original_method = "72071F64A960BCDF8628E8519218C076", hash_generated_method = "0D865B4C4C33F8BF881769588A4B7450")
    public final void setEditableFactory(Editable.Factory factory) {
        mEditableFactory = factory;
        //setText(mText);
        // ---------- Original Method ----------
        //mEditableFactory = factory;
        //setText(mText);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.529 -0400", hash_original_method = "EE70434E54240A6008C9D2EA9B017339", hash_generated_method = "D377DBA7CFAFD2BF6D3E343C891A2FD6")
    public final void setSpannableFactory(Spannable.Factory factory) {
        mSpannableFactory = factory;
        //setText(mText);
        // ---------- Original Method ----------
        //mSpannableFactory = factory;
        //setText(mText);
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.530 -0400", hash_original_method = "F37C8918E495A353D909855BE6AEA0B3", hash_generated_method = "170DA8E8BD4336C0FB792281FDE81EAF")
    @android.view.RemotableViewMethod
    public final void setText(CharSequence text) {
        //addTaint(text.getTaint());
        //setText(text, mBufferType);
        mText = text;
        // ---------- Original Method ----------
        //setText(text, mBufferType);
    }

    /**
     * Like {@link #setText(CharSequence)},
     * except that the cursor position (if any) is retained in the new text.
     *
     * @param text The new text to place in the text view.
     *
     * @see #setText(CharSequence)
     */
    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.830 -0500", hash_original_method = "8D1404A47F965A96F115CE2D4080AFCB", hash_generated_method = "E75E6F9F72FD82CA06FB6808B2658A4C")
    
@android.view.RemotableViewMethod
    public final void setTextKeepState(CharSequence text) {
        setTextKeepState(text, mBufferType);
    }

    /**
     * Sets the text that this TextView is to display (see
     * {@link #setText(CharSequence)}) and also sets whether it is stored
     * in a styleable/spannable buffer and whether it is editable.
     *
     * @attr ref android.R.styleable#TextView_text
     * @attr ref android.R.styleable#TextView_bufferType
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.833 -0500", hash_original_method = "607651EBB019EF2524713C89A6A4FC8C", hash_generated_method = "98E679A14C4ED901FEA49B7F2111C04B")
    
public void setText(CharSequence text, BufferType type) {
        setText(text, type, true, 0);

        if (mCharWrapper != null) {
            mCharWrapper.mChars = null;
        }
    }
    
    @DSComment("Private Method")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.534 -0400", hash_original_method = "EBAE4ED74D570AD4FF310073DD3BF4E5", hash_generated_method = "2BA93A7A63A103A1E7CA1F5FB9BB442F")
    private void setText(CharSequence text, BufferType type,
                         boolean notifyBefore, int oldlen) {
        //addTaint(oldlen);
        //addTaint(notifyBefore);
        /*
        if(text == null)        
        {
            text = "";
        } //End block
        */

        mText = text;

        /*
        if(!isSuggestionsEnabled())        
        {
            text = removeSuggestionSpans(text);
        } //End block
        if(!mUserSetTextScaleX)        
        mTextPaint.setTextScaleX(1.0f);
        if(text instanceof Spanned &&
            ((Spanned) text).getSpanStart(TextUtils.TruncateAt.MARQUEE) >= 0)        
        {
            if(ViewConfiguration.get(mContext).isFadingMarqueeEnabled())            
            {
                setHorizontalFadingEdgeEnabled(true);
                mMarqueeFadeMode = MARQUEE_FADE_NORMAL;
            } //End block
            else
            {
                setHorizontalFadingEdgeEnabled(false);
                mMarqueeFadeMode = MARQUEE_FADE_SWITCH_SHOW_ELLIPSIS;
            } //End block
            setEllipsize(TextUtils.TruncateAt.MARQUEE);
        } //End block
        int n = mFilters.length;
for(int i = 0;i < n;i++)
        {
            CharSequence out = mFilters[i].filter(text, 0, text.length(),
                                                  EMPTY_SPANNED, 0, 0);
            if(out != null)            
            {
                text = out;
            } //End block

        } //End block

         */
        if(notifyBefore)        
        {
            if(mText != null)            
            {
                oldlen = mText.length();
                sendBeforeTextChanged(mText, 0, oldlen, text.length());
            } //End block
            else
            {
                sendBeforeTextChanged("", 0, 0, text.length());
            } //End block
        } //End block

        boolean needEditableForNotification = false;
        if(mListeners != null && mListeners.size() != 0)        
        {
            needEditableForNotification = true;
        } //End block
        if(type == BufferType.EDITABLE || mInput != null || needEditableForNotification)        
        {
            Editable t = mEditableFactory.newEditable(text);
            //text = t;
            setFilters(t, mFilters);
            InputMethodManager imm = InputMethodManager.peekInstance();
            if(imm != null)            
                imm.restartInput(this);
        } //End block
        else
            if(type == BufferType.SPANNABLE || mMovement != null)        
            {
                //text = mSpannableFactory.newSpannable(text);
            } //End block
            else
                if(!(text instanceof CharWrapper))        
                {
                    //text = TextUtils.stringOrSpannedString(text);
                } //End block
        if(mAutoLinkMask != 0)        
        {
            Spannable s2;
            if(type == BufferType.EDITABLE || text instanceof Spannable)            
            {
                s2 = (Spannable) text;
            } //End block
            else
            {
                s2 = mSpannableFactory.newSpannable(text);
            } //End block
            if(Linkify.addLinks(s2, mAutoLinkMask))            
            {
                //text = s2;
                type = (type == BufferType.EDITABLE) ? BufferType.EDITABLE : BufferType.SPANNABLE;
                //mText = text;
                if(mLinksClickable && !textCanBeSelected())                
                {
                    setMovementMethod(LinkMovementMethod.getInstance());
                } //End block
            } //End block
        } //End block
        mBufferType = type;
        //mText = text;
        if(mTransformation == null)        
        {
            mTransformed = text;
        } //End block
        else
        {
            mTransformed = mTransformation.getTransformation(text, this);
        } //End block
        final int textLength = text.length();
        if(text instanceof Spannable && !mAllowTransformationLengthChange)        
        {
            Spannable sp = (Spannable) text;
            final ChangeWatcher[] watchers = sp.getSpans(0, sp.length(), ChangeWatcher.class);
            final int count = watchers.length;
            for(int i = 0;i < count;i++)
                sp.removeSpan(watchers[i]);
            if(mChangeWatcher == null)            
                mChangeWatcher = new ChangeWatcher();
            sp.setSpan(mChangeWatcher, 0, textLength, Spanned.SPAN_INCLUSIVE_INCLUSIVE |
                (PRIORITY << Spanned.SPAN_PRIORITY_SHIFT));
            if(mInput != null)            
            {
                sp.setSpan(mInput, 0, textLength, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
            } //End block
            if(mTransformation != null)            
            {
                sp.setSpan(mTransformation, 0, textLength, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
            } //End block
            if(mMovement != null)            
            {
                mMovement.initialize(this, (Spannable) text);
                mSelectionMoved = false;
            } //End block
        } //End block
        if(mLayout != null)        
        {
            checkForRelayout();
        } //End block
        sendOnTextChanged(text, 0, oldlen, textLength);
        onTextChanged(text, 0, oldlen, textLength);
        if(needEditableForNotification)        
        {
            sendAfterTextChanged((Editable) text);
        } //End block
        prepareCursorControllers();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    /**
     * Sets the TextView to display the specified slice of the specified
     * char array.  You must promise that you will not change the contents
     * of the array except for right before another call to setText(),
     * since the TextView has no way to know that the text
     * has changed and that it needs to invalidate and re-layout.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.841 -0500", hash_original_method = "36BFF315CD4AAC9D68E14477979C2AB5", hash_generated_method = "C07655603B1C7698549A580EC59D382A")
    
public final void setText(char[] text, int start, int len) {
        int oldlen = 0;

        if (start < 0 || len < 0 || start + len > text.length) {
            throw new IndexOutOfBoundsException(start + ", " + len);
        }

        /*
         * We must do the before-notification here ourselves because if
         * the old text is a CharWrapper we destroy it before calling
         * into the normal path.
         */
        if (mText != null) {
            oldlen = mText.length();
            sendBeforeTextChanged(mText, 0, oldlen, len);
        } else {
            sendBeforeTextChanged("", 0, 0, len);
        }

        if (mCharWrapper == null) {
            mCharWrapper = new CharWrapper(text, start, len);
        } else {
            mCharWrapper.set(text, start, len);
        }

        setText(mCharWrapper, mBufferType, false, oldlen);
    }

    /**
     * Like {@link #setText(CharSequence, android.widget.TextView.BufferType)},
     * except that the cursor position (if any) is retained in the new text.
     *
     * @see #setText(CharSequence, android.widget.TextView.BufferType)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.885 -0500", hash_original_method = "9AF748BA799D545173D512FE98AE91A8", hash_generated_method = "398ACAB538BAE5D12DB55814976855CD")
    
public final void setTextKeepState(CharSequence text, BufferType type) {
        int start = getSelectionStart();
        int end = getSelectionEnd();
        int len = text.length();

        setText(text, type);

        if (start >= 0 || end >= 0) {
            if (mText instanceof Spannable) {
                Selection.setSelection((Spannable) mText,
                                       Math.max(0, Math.min(start, len)),
                                       Math.max(0, Math.min(end, len)));
            }
        }
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.887 -0500", hash_original_method = "F67FB9F700F5516CACC8B84E46FAB678", hash_generated_method = "929DBDF02CD46CB45E799900F9F11CB3")
    
@android.view.RemotableViewMethod
    public final void setText(int resid) {
        setText(getContext().getResources().getText(resid));
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.890 -0500", hash_original_method = "A59BD645A347EA39C4147D9E24C2BE1F", hash_generated_method = "A74286E7AFE78955A1C99AD90E6CBDE1")
    
public final void setText(int resid, BufferType type) {
        setText(getContext().getResources().getText(resid), type);
    }

    /**
     * Sets the text to be displayed when the text of the TextView is empty.
     * Null means to use the normal empty text. The hint does not currently
     * participate in determining the size of the view.
     *
     * @attr ref android.R.styleable#TextView_hint
     */
    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.892 -0500", hash_original_method = "E428F8CA5E03E5225CDDDB51AA0FFAC9", hash_generated_method = "EF1B5E2F6E1144B674B014236F2CBA7E")
    
@android.view.RemotableViewMethod
    public final void setHint(CharSequence hint) {
        mHint = hint;
    }

    /**
     * Sets the text to be displayed when the text of the TextView is empty,
     * from a resource.
     *
     * @attr ref android.R.styleable#TextView_hint
     */
    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.895 -0500", hash_original_method = "38FC4DBAEFB265C97233FE4F28F668E7", hash_generated_method = "C1B1E4FC4A9A8576B3FF0CC12072DD46")
    
@android.view.RemotableViewMethod
    public final void setHint(int resid) {
        setHint(getContext().getResources().getText(resid));
    }

    /**
     * Returns the hint that is displayed when the text of the TextView
     * is empty.
     *
     * @attr ref android.R.styleable#TextView_hint
     */
    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.897 -0500", hash_original_method = "B545FCA8809064A694F5A37F99B0BBF1", hash_generated_method = "C9562F3D7BCAB1C591C4688BED076F67")
    
@ViewDebug.CapturedViewProperty
    public CharSequence getHint() {
        return mHint;
    }

    /**
     * Set the type of the content with a constant as defined for {@link EditorInfo#inputType}. This
     * will take care of changing the key listener, by calling {@link #setKeyListener(KeyListener)},
     * to match the given content type.  If the given content type is {@link EditorInfo#TYPE_NULL}
     * then a soft keyboard will not be displayed for this text view.
     *
     * Note that the maximum number of displayed lines (see {@link #setMaxLines(int)}) will be
     * modified if you change the {@link EditorInfo#TYPE_TEXT_FLAG_MULTI_LINE} flag of the input
     * type.
     *
     * @see #getInputType()
     * @see #setRawInputType(int)
     * @see android.text.InputType
     * @attr ref android.R.styleable#TextView_inputType
     */
    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.903 -0500", hash_original_method = "49514C27E12484581D1021562BB6B56C", hash_generated_method = "CA49E890B8FA1C48882750F052EE89CC")
    
public void setInputType(int type) {
        final boolean wasPassword = isPasswordInputType(mInputType);
        final boolean wasVisiblePassword = isVisiblePasswordInputType(mInputType);
        setInputType(type, false);
        final boolean isPassword = isPasswordInputType(type);
        final boolean isVisiblePassword = isVisiblePasswordInputType(type);
        boolean forceUpdate = false;
        if (isPassword) {
            setTransformationMethod(PasswordTransformationMethod.getInstance());
            setTypefaceByIndex(MONOSPACE, 0);
        } else if (isVisiblePassword) {
            if (mTransformation == PasswordTransformationMethod.getInstance()) {
                forceUpdate = true;
            }
            setTypefaceByIndex(MONOSPACE, 0);
        } else if (wasPassword || wasVisiblePassword) {
            // not in password mode, clean up typeface and transformation
            setTypefaceByIndex(-1, -1);
            if (mTransformation == PasswordTransformationMethod.getInstance()) {
                forceUpdate = true;
            }
        }
        
        boolean singleLine = !isMultilineInputType(type);
        
        // We need to update the single line mode if it has changed or we
        // were previously in password mode.
        if (mSingleLine != singleLine || forceUpdate) {
            // Change single line mode, but only change the transformation if
            // we are not in password mode.
            applySingleLine(singleLine, !isPassword, true);
        }
        
        InputMethodManager imm = InputMethodManager.peekInstance();
        if (imm != null) imm.restartInput(this);
    }

    /**
     * It would be better to rely on the input type for everything. A password inputType should have
     * a password transformation. We should hence use isPasswordInputType instead of this method.
     *
     * We should:
     * - Call setInputType in setKeyListener instead of changing the input type directly (which
     * would install the correct transformation).
     * - Refuse the installation of a non-password transformation in setTransformation if the input
     * type is password.
     *
     * However, this is like this for legacy reasons and we cannot break existing apps. This method
     * is useful since it matches what the user can see (obfuscated text or not).
     *
     * @return true if the current transformation method is of the password type.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.905 -0500", hash_original_method = "103CDD92E42BC521C8FE05F02491D14C", hash_generated_method = "D2E5E2DB15BF990358360AE340E05270")
    
private boolean hasPasswordTransformationMethod() {
        return mTransformation instanceof PasswordTransformationMethod;
    }

    /**
     * Directly change the content type integer of the text view, without
     * modifying any other state.
     * @see #setInputType(int)
     * @see android.text.InputType
     * @attr ref android.R.styleable#TextView_inputType
     */
    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.912 -0500", hash_original_method = "5561319FE52E5BCF6B9F27794140DEB3", hash_generated_method = "8131C8E5CFB35517C5955477D5E7F385")
    
public void setRawInputType(int type) {
        mInputType = type;
    }

    @DSComment("Private Method")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.915 -0500", hash_original_method = "95BF8AE0F4607DDA852256E0031089E3", hash_generated_method = "0B7E5FF59BD48A921190514207AAB77F")
    
private void setInputType(int type, boolean direct) {
        final int cls = type & EditorInfo.TYPE_MASK_CLASS;
        KeyListener input;
        if (cls == EditorInfo.TYPE_CLASS_TEXT) {
            boolean autotext = (type & EditorInfo.TYPE_TEXT_FLAG_AUTO_CORRECT) != 0;
            TextKeyListener.Capitalize cap;
            if ((type & EditorInfo.TYPE_TEXT_FLAG_CAP_CHARACTERS) != 0) {
                cap = TextKeyListener.Capitalize.CHARACTERS;
            } else if ((type & EditorInfo.TYPE_TEXT_FLAG_CAP_WORDS) != 0) {
                cap = TextKeyListener.Capitalize.WORDS;
            } else if ((type & EditorInfo.TYPE_TEXT_FLAG_CAP_SENTENCES) != 0) {
                cap = TextKeyListener.Capitalize.SENTENCES;
            } else {
                cap = TextKeyListener.Capitalize.NONE;
            }
            input = TextKeyListener.getInstance(autotext, cap);
        } else if (cls == EditorInfo.TYPE_CLASS_NUMBER) {
            input = DigitsKeyListener.getInstance(
                    (type & EditorInfo.TYPE_NUMBER_FLAG_SIGNED) != 0,
                    (type & EditorInfo.TYPE_NUMBER_FLAG_DECIMAL) != 0);
        } else if (cls == EditorInfo.TYPE_CLASS_DATETIME) {
            switch (type & EditorInfo.TYPE_MASK_VARIATION) {
                case EditorInfo.TYPE_DATETIME_VARIATION_DATE:
                    input = DateKeyListener.getInstance();
                    break;
                case EditorInfo.TYPE_DATETIME_VARIATION_TIME:
                    input = TimeKeyListener.getInstance();
                    break;
                default:
                    input = DateTimeKeyListener.getInstance();
                    break;
            }
        } else if (cls == EditorInfo.TYPE_CLASS_PHONE) {
            input = DialerKeyListener.getInstance();
        } else {
            input = TextKeyListener.getInstance();
        }
        setRawInputType(type);
        if (direct) mInput = input;
        else {
            setKeyListenerOnly(input);
        }
    }

    /**
     * Get the type of the content.
     *
     * @see #setInputType(int)
     * @see android.text.InputType
     */
    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.917 -0500", hash_original_method = "CC20F62DEC3871662808940856B4AD97", hash_generated_method = "21F93154F83E3D01EA5F5592942E4719")
    
public int getInputType() {
        return mInputType;
    }

    /**
     * Change the editor type integer associated with the text view, which
     * will be reported to an IME with {@link EditorInfo#imeOptions} when it
     * has focus.
     * @see #getImeOptions
     * @see android.view.inputmethod.EditorInfo
     * @attr ref android.R.styleable#TextView_imeOptions
     */
    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.919 -0500", hash_original_method = "15D43244184C7971E001BEB05B105E77", hash_generated_method = "1F0912700FA3B87298E896BBA0F35A9B")
    
public void setImeOptions(int imeOptions) {
        if (mInputContentType == null) {
            mInputContentType = new InputContentType();
        }
        mInputContentType.imeOptions = imeOptions;
    }

    /**
     * Get the type of the IME editor.
     *
     * @see #setImeOptions(int)
     * @see android.view.inputmethod.EditorInfo
     */
    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.921 -0500", hash_original_method = "2B64657558FBAC5C9C7E6BDC8C1A3258", hash_generated_method = "CABBC41593BB7D9C42C9C69272BDB7EC")
    
public int getImeOptions() {
        return mInputContentType != null
                ? mInputContentType.imeOptions : EditorInfo.IME_NULL;
    }

    /**
     * Change the custom IME action associated with the text view, which
     * will be reported to an IME with {@link EditorInfo#actionLabel}
     * and {@link EditorInfo#actionId} when it has focus.
     * @see #getImeActionLabel
     * @see #getImeActionId
     * @see android.view.inputmethod.EditorInfo
     * @attr ref android.R.styleable#TextView_imeActionLabel
     * @attr ref android.R.styleable#TextView_imeActionId
     */
    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.923 -0500", hash_original_method = "1A4477F3225C39150F0F3FBD7557F91B", hash_generated_method = "47915585101DEDCD38E3592666E7631E")
    
public void setImeActionLabel(CharSequence label, int actionId) {
        if (mInputContentType == null) {
            mInputContentType = new InputContentType();
        }
        mInputContentType.imeActionLabel = label;
        mInputContentType.imeActionId = actionId;
    }

    /**
     * Get the IME action label previous set with {@link #setImeActionLabel}.
     *
     * @see #setImeActionLabel
     * @see android.view.inputmethod.EditorInfo
     */
    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.926 -0500", hash_original_method = "A4E3D8286D59E9D4715BBC467F3D8808", hash_generated_method = "122B7A7DAD7856768B6DFE10C14FDB00")
    
public CharSequence getImeActionLabel() {
        return mInputContentType != null
                ? mInputContentType.imeActionLabel : null;
    }

    /**
     * Get the IME action ID previous set with {@link #setImeActionLabel}.
     *
     * @see #setImeActionLabel
     * @see android.view.inputmethod.EditorInfo
     */
    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.928 -0500", hash_original_method = "4B4E4CA7604BFFF08B66F520F2D9A667", hash_generated_method = "603A238874E875E78E97338A777A3A52")
    
public int getImeActionId() {
        return mInputContentType != null
                ? mInputContentType.imeActionId : 0;
    }

    /**
     * Set a special listener to be called when an action is performed
     * on the text view.  This will be called when the enter key is pressed,
     * or when an action supplied to the IME is selected by the user.  Setting
     * this means that the normal hard key event will not insert a newline
     * into the text view, even if it is multi-line; holding down the ALT
     * modifier will, however, allow the user to insert a newline character.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.930 -0500", hash_original_method = "46DFB908E4A3870151F9CA120300C85B", hash_generated_method = "5B6C40581092B44D2318441116923AA7")
    @DSVerified
    @DSSafe(DSCat.SAFE_LIST)
public void setOnEditorActionListener(OnEditorActionListener l) {
        if (mInputContentType == null) {
            mInputContentType = new InputContentType();
        }
        mInputContentType.onEditorActionListener = l;
        
        if (l != null){
            l.onEditorAction(this, DSUtils.FAKE_INT, new KeyEvent());
        }
    }
    
    /**
     * Called when an attached input method calls
     * {@link InputConnection#performEditorAction(int)
     * InputConnection.performEditorAction()}
     * for this text view.  The default implementation will call your action
     * listener supplied to {@link #setOnEditorActionListener}, or perform
     * a standard operation for {@link EditorInfo#IME_ACTION_NEXT
     * EditorInfo.IME_ACTION_NEXT}, {@link EditorInfo#IME_ACTION_PREVIOUS
     * EditorInfo.IME_ACTION_PREVIOUS}, or {@link EditorInfo#IME_ACTION_DONE
     * EditorInfo.IME_ACTION_DONE}.
     * 
     * <p>For backwards compatibility, if no IME options have been set and the
     * text view would not normally advance focus on enter, then
     * the NEXT and DONE actions received here will be turned into an enter
     * key down/up pair to go through the normal key handling.
     * 
     * @param actionCode The code of the action being performed.
     * 
     * @see #setOnEditorActionListener
     */
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.934 -0500", hash_original_method = "0518018E7AD402CBF7FDAFFEA66C2B57", hash_generated_method = "52344A2AE6A8C3A4DFD0C2E9F085EDED")
    
public void onEditorAction(int actionCode) {
        final InputContentType ict = mInputContentType;
        if (ict != null) {
            if (ict.onEditorActionListener != null) {
                if (ict.onEditorActionListener.onEditorAction(this,
                        actionCode, null)) {
                    return;
                }
            }

            // This is the handling for some default action.
            // Note that for backwards compatibility we don't do this
            // default handling if explicit ime options have not been given,
            // instead turning this into the normal enter key codes that an
            // app may be expecting.
            if (actionCode == EditorInfo.IME_ACTION_NEXT) {
                View v = focusSearch(FOCUS_FORWARD);
                if (v != null) {
                    if (!v.requestFocus(FOCUS_FORWARD)) {
                        throw new IllegalStateException("focus search returned a view " +
                                "that wasn't able to take focus!");
                    }
                }
                return;

            } else if (actionCode == EditorInfo.IME_ACTION_PREVIOUS) {
                View v = focusSearch(FOCUS_BACKWARD);
                if (v != null) {
                    if (!v.requestFocus(FOCUS_BACKWARD)) {
                        throw new IllegalStateException("focus search returned a view " +
                                "that wasn't able to take focus!");
                    }
                }
                return;

            } else if (actionCode == EditorInfo.IME_ACTION_DONE) {
                InputMethodManager imm = InputMethodManager.peekInstance();
                if (imm != null && imm.isActive(this)) {
                    imm.hideSoftInputFromWindow(getWindowToken(), 0);
                }
                return;
            }
        }

        Handler h = getHandler();
        if (h != null) {
            long eventTime = SystemClock.uptimeMillis();
            h.sendMessage(h.obtainMessage(ViewRootImpl.DISPATCH_KEY_FROM_IME,
                    new KeyEvent(eventTime, eventTime,
                    KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_ENTER, 0, 0,
                    KeyCharacterMap.VIRTUAL_KEYBOARD, 0,
                    KeyEvent.FLAG_SOFT_KEYBOARD | KeyEvent.FLAG_KEEP_TOUCH_MODE
                    | KeyEvent.FLAG_EDITOR_ACTION)));
            h.sendMessage(h.obtainMessage(ViewRootImpl.DISPATCH_KEY_FROM_IME,
                    new KeyEvent(SystemClock.uptimeMillis(), eventTime,
                    KeyEvent.ACTION_UP, KeyEvent.KEYCODE_ENTER, 0, 0,
                    KeyCharacterMap.VIRTUAL_KEYBOARD, 0,
                    KeyEvent.FLAG_SOFT_KEYBOARD | KeyEvent.FLAG_KEEP_TOUCH_MODE
                    | KeyEvent.FLAG_EDITOR_ACTION)));
        }
    }

    /**
     * Set the private content type of the text, which is the
     * {@link EditorInfo#privateImeOptions EditorInfo.privateImeOptions}
     * field that will be filled in when creating an input connection.
     *
     * @see #getPrivateImeOptions()
     * @see EditorInfo#privateImeOptions
     * @attr ref android.R.styleable#TextView_privateImeOptions
     */
    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.937 -0500", hash_original_method = "E93C7F3F4C0717B4FFE77CC972CA5ABA", hash_generated_method = "E89AD0C61E67417CA431B3AD9F996830")
    
public void setPrivateImeOptions(String type) {
        if (mInputContentType == null) mInputContentType = new InputContentType();
        mInputContentType.privateImeOptions = type;
    }

    /**
     * Get the private type of the content.
     *
     * @see #setPrivateImeOptions(String)
     * @see EditorInfo#privateImeOptions
     */
    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.939 -0500", hash_original_method = "92B56934BB38E74A857D4D87A23CFEBD", hash_generated_method = "2F5A1921D3DB438EAA306288C48113F2")
    
public String getPrivateImeOptions() {
        return mInputContentType != null
                ? mInputContentType.privateImeOptions : null;
    }

    /**
     * Set the extra input data of the text, which is the
     * {@link EditorInfo#extras TextBoxAttribute.extras}
     * Bundle that will be filled in when creating an input connection.  The
     * given integer is the resource ID of an XML resource holding an
     * {@link android.R.styleable#InputExtras &lt;input-extras&gt;} XML tree.
     *
     * @see #getInputExtras(boolean) 
     * @see EditorInfo#extras
     * @attr ref android.R.styleable#TextView_editorExtras
     */
    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.941 -0500", hash_original_method = "4D2957EAEB6AF33B1C49D1AAB860E441", hash_generated_method = "30CBCB631ED5E63FC350B6B2B257F3B5")
    
public void setInputExtras(int xmlResId)
            throws XmlPullParserException, IOException {
        XmlResourceParser parser = getResources().getXml(xmlResId);
        if (mInputContentType == null) mInputContentType = new InputContentType();
        mInputContentType.extras = new Bundle();
        getResources().parseBundleExtras(parser, mInputContentType.extras);
    }

    /**
     * Retrieve the input extras currently associated with the text view, which
     * can be viewed as well as modified.
     *
     * @param create If true, the extras will be created if they don't already
     * exist.  Otherwise, null will be returned if none have been created.
     * @see #setInputExtras(int)
     * @see EditorInfo#extras
     * @attr ref android.R.styleable#TextView_editorExtras
     */
    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.943 -0500", hash_original_method = "3CCBAE1ACA56EC727CC56362E5EC99DC", hash_generated_method = "F5BFBE58772702760E837C3DD55463D6")
    
public Bundle getInputExtras(boolean create) {
        if (mInputContentType == null) {
            if (!create) return null;
            mInputContentType = new InputContentType();
        }
        if (mInputContentType.extras == null) {
            if (!create) return null;
            mInputContentType.extras = new Bundle();
        }
        return mInputContentType.extras;
    }

    /**
     * Returns the error message that was set to be displayed with
     * {@link #setError}, or <code>null</code> if no error was set
     * or if it the error was cleared by the widget after user input.
     */
    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.945 -0500", hash_original_method = "9A980CBEBB946A11C624D95D8D1017B2", hash_generated_method = "E15DFD979F85DE1B2553570F80F86D46")
    
public CharSequence getError() {
        return mError;
    }

    /**
     * Sets the right-hand compound drawable of the TextView to the "error"
     * icon and sets an error message that will be displayed in a popup when
     * the TextView has focus.  The icon and error message will be reset to
     * null when any key events cause changes to the TextView's text.  If the
     * <code>error</code> is <code>null</code>, the error message and icon
     * will be cleared.
     */
    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.948 -0500", hash_original_method = "D7457C91A83A908A8309ED29F602BDCA", hash_generated_method = "0D7297B218A16912CD61BB587A3DD5F3")
    
@android.view.RemotableViewMethod
    public void setError(CharSequence error) {
        if (error == null) {
            setError(null, null);
        } else {
            Drawable dr = getContext().getResources().
                getDrawable(com.android.internal.R.drawable.indicator_input_error);

            dr.setBounds(0, 0, dr.getIntrinsicWidth(), dr.getIntrinsicHeight());
            setError(error, dr);
        }
    }

    /**
     * Sets the right-hand compound drawable of the TextView to the specified
     * icon and sets an error message that will be displayed in a popup when
     * the TextView has focus.  The icon and error message will be reset to
     * null when any key events cause changes to the TextView's text.  The
     * drawable must already have had {@link Drawable#setBounds} set on it.
     * If the <code>error</code> is <code>null</code>, the error message will
     * be cleared (and you should provide a <code>null</code> icon as well).
     */
    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.951 -0500", hash_original_method = "A707A7C4B74C4D669C69114C0D73A7BA", hash_generated_method = "9F0ED2787620537ED4373AB9E0A76774")
    
public void setError(CharSequence error, Drawable icon) {
        error = TextUtils.stringOrSpannedString(error);

        mError = error;
        mErrorWasChanged = true;
        final Drawables dr = mDrawables;
        if (dr != null) {
            switch (getResolvedLayoutDirection()) {
                default:
                case LAYOUT_DIRECTION_LTR:
                    setCompoundDrawables(dr.mDrawableLeft, dr.mDrawableTop, icon,
                            dr.mDrawableBottom);
                    break;
                case LAYOUT_DIRECTION_RTL:
                    setCompoundDrawables(icon, dr.mDrawableTop, dr.mDrawableRight,
                            dr.mDrawableBottom);
                    break;
            }
        } else {
            setCompoundDrawables(null, null, icon, null);
        }

        if (error == null) {
            if (mPopup != null) {
                if (mPopup.isShowing()) {
                    mPopup.dismiss();
                }

                mPopup = null;
            }
        } else {
            if (isFocused()) {
                showError();
            }
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.953 -0500", hash_original_method = "691606EEB666F38CF8433096C671CCBD", hash_generated_method = "E627710879286267BB08B26686F660BD")
    
private void showError() {
        if (getWindowToken() == null) {
            mShowErrorAfterAttach = true;
            return;
        }

        if (mPopup == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            final TextView err = (TextView) inflater.inflate(
                    com.android.internal.R.layout.textview_hint, null);

            final float scale = getResources().getDisplayMetrics().density;
            mPopup = new ErrorPopup(err, (int) (200 * scale + 0.5f), (int) (50 * scale + 0.5f));
            mPopup.setFocusable(false);
            // The user is entering text, so the input method is needed.  We
            // don't want the popup to be displayed on top of it.
            mPopup.setInputMethodMode(PopupWindow.INPUT_METHOD_NEEDED);
        }

        TextView tv = (TextView) mPopup.getContentView();
        chooseSize(mPopup, mError, tv);
        tv.setText(mError);

        mPopup.showAsDropDown(this, getErrorX(), getErrorY());
        mPopup.fixDirection(mPopup.isAboveAnchor());
    }

    /**
     * Returns the Y offset to make the pointy top of the error point
     * at the middle of the error icon.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.979 -0500", hash_original_method = "193E855DAAE9F0495F7DD2501E8046B7", hash_generated_method = "C448D115977004F992FD3B89303A5875")
    
private int getErrorX() {
        /*
         * The "25" is the distance between the point and the right edge
         * of the background
         */
        final float scale = getResources().getDisplayMetrics().density;

        final Drawables dr = mDrawables;
        return getWidth() - mPopup.getWidth() - getPaddingRight() -
                (dr != null ? dr.mDrawableSizeRight : 0) / 2 + (int) (25 * scale + 0.5f);
    }

    /**
     * Returns the Y offset to make the pointy top of the error point
     * at the bottom of the error icon.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.981 -0500", hash_original_method = "AEF78C4F5C84BB7DCAE783FBA8691257", hash_generated_method = "F94A7378C81B3D397B7632E155A88066")
    
private int getErrorY() {
        /*
         * Compound, not extended, because the icon is not clipped
         * if the text height is smaller.
         */
        final int compoundPaddingTop = getCompoundPaddingTop();
        int vspace = mBottom - mTop - getCompoundPaddingBottom() - compoundPaddingTop;

        final Drawables dr = mDrawables;
        int icontop = compoundPaddingTop +
                (vspace - (dr != null ? dr.mDrawableHeightRight : 0)) / 2;

        /*
         * The "2" is the distance between the point and the top edge
         * of the background.
         */
        final float scale = getResources().getDisplayMetrics().density;
        return icontop + (dr != null ? dr.mDrawableHeightRight : 0) - getHeight() -
                (int) (2 * scale + 0.5f);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.983 -0500", hash_original_method = "F599686205634A1B40098A399108C287", hash_generated_method = "99F3E6B0016C4B62A36CABAF5B7274FB")
    
private void hideError() {
        if (mPopup != null) {
            if (mPopup.isShowing()) {
                mPopup.dismiss();
            }
        }

        mShowErrorAfterAttach = false;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.986 -0500", hash_original_method = "E776865F48A57A0CE6F068EC64FA9769", hash_generated_method = "CCED89E581FC8BBF50513A2A1C2E18DE")
    
private void chooseSize(PopupWindow pop, CharSequence text, TextView tv) {
        int wid = tv.getPaddingLeft() + tv.getPaddingRight();
        int ht = tv.getPaddingTop() + tv.getPaddingBottom();

        int defaultWidthInPixels = getResources().getDimensionPixelSize(
                com.android.internal.R.dimen.textview_error_popup_default_width);
        Layout l = new StaticLayout(text, tv.getPaint(), defaultWidthInPixels,
                                    Layout.Alignment.ALIGN_NORMAL, 1, 0, true);
        float max = 0;
        for (int i = 0; i < l.getLineCount(); i++) {
            max = Math.max(max, l.getLineWidth(i));
        }

        /*
         * Now set the popup size to be big enough for the text plus the border capped
         * to DEFAULT_MAX_POPUP_WIDTH
         */
        pop.setWidth(wid + (int) Math.ceil(max));
        pop.setHeight(ht + l.getHeight());
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.988 -0500", hash_original_method = "5914A6C90CD99156CDEB55240C7F0CC3", hash_generated_method = "3D426D23DE36E37F9564B19DAFC764BD")
    
@Override
    protected boolean setFrame(int l, int t, int r, int b) {
        boolean result = super.setFrame(l, t, r, b);

        if (mPopup != null) {
            TextView tv = (TextView) mPopup.getContentView();
            chooseSize(mPopup, mError, tv);
            mPopup.update(this, getErrorX(), getErrorY(),
                          mPopup.getWidth(), mPopup.getHeight());
        }

        restartMarqueeIfNeeded();

        return result;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.991 -0500", hash_original_method = "F008D6FB8FE5770ECA7C6E535BB409D7", hash_generated_method = "59B14025D02A5CC1F924BE8FAE863309")
    
private void restartMarqueeIfNeeded() {
        if (mRestartMarquee && mEllipsize == TextUtils.TruncateAt.MARQUEE) {
            mRestartMarquee = false;
            startMarquee();
        }
    }

    /**
     * Sets the list of input filters that will be used if the buffer is
     * Editable.  Has no effect otherwise.
     *
     * @attr ref android.R.styleable#TextView_maxLength
     */
    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.993 -0500", hash_original_method = "BC1716C27CAAB9B1A5BA926037A5041B", hash_generated_method = "26CFC3A292E7F3EF6BF46DB8BB32D02E")
    
public void setFilters(InputFilter[] filters) {
        if (filters == null) {
            throw new IllegalArgumentException();
        }

        mFilters = filters;

        if (mText instanceof Editable) {
            setFilters((Editable) mText, filters);
        }
    }

    /**
     * Sets the list of input filters on the specified Editable,
     * and includes mInput in the list if it is an InputFilter.
     */
    @DSComment("Private Method")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.996 -0500", hash_original_method = "48C3B4A6108D00EDE1CFE79059C5E0E2", hash_generated_method = "C4C28B3C485DBB99D926FBB41EF7AE09")
    
private void setFilters(Editable e, InputFilter[] filters) {
        if (mInput instanceof InputFilter) {
            InputFilter[] nf = new InputFilter[filters.length + 1];

            System.arraycopy(filters, 0, nf, 0, filters.length);
            nf[filters.length] = (InputFilter) mInput;

            e.setFilters(nf);
        } else {
            e.setFilters(filters);
        }
    }

    /**
     * Returns the current list of input filters.
     */
    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.998 -0500", hash_original_method = "E0010D0DD1DD8F03E408AEE972028B3D", hash_generated_method = "E525C716C16B680B8DF63B06A2EE86E7")
    
public InputFilter[] getFilters() {
        return mFilters;
    }

    /////////////////////////////////////////////////////////////////////////

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.001 -0500", hash_original_method = "DAA92D774C652EE383E55D96FD59260D", hash_generated_method = "1185CC0C3A5098E801D81CCDEAB8BB9E")
    
private int getVerticalOffset(boolean forceNormal) {
        int voffset = 0;
        final int gravity = mGravity & Gravity.VERTICAL_GRAVITY_MASK;

        Layout l = mLayout;
        if (!forceNormal && mText.length() == 0 && mHintLayout != null) {
            l = mHintLayout;
        }

        if (gravity != Gravity.TOP) {
            int boxht;

            if (l == mHintLayout) {
                boxht = getMeasuredHeight() - getCompoundPaddingTop() -
                        getCompoundPaddingBottom();
            } else {
                boxht = getMeasuredHeight() - getExtendedPaddingTop() -
                        getExtendedPaddingBottom();
            }
            int textht = l.getHeight();

            if (textht < boxht) {
                if (gravity == Gravity.BOTTOM)
                    voffset = boxht - textht;
                else // (gravity == Gravity.CENTER_VERTICAL)
                    voffset = (boxht - textht) >> 1;
            }
        }
        return voffset;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.003 -0500", hash_original_method = "FA4757416C7C28BA09CF9D290B4D7551", hash_generated_method = "9FC46F0C7E4B0D5C98513DF5E92BED95")
    
private int getBottomVerticalOffset(boolean forceNormal) {
        int voffset = 0;
        final int gravity = mGravity & Gravity.VERTICAL_GRAVITY_MASK;

        Layout l = mLayout;
        if (!forceNormal && mText.length() == 0 && mHintLayout != null) {
            l = mHintLayout;
        }

        if (gravity != Gravity.BOTTOM) {
            int boxht;

            if (l == mHintLayout) {
                boxht = getMeasuredHeight() - getCompoundPaddingTop() -
                        getCompoundPaddingBottom();
            } else {
                boxht = getMeasuredHeight() - getExtendedPaddingTop() -
                        getExtendedPaddingBottom();
            }
            int textht = l.getHeight();

            if (textht < boxht) {
                if (gravity == Gravity.TOP)
                    voffset = boxht - textht;
                else // (gravity == Gravity.CENTER_VERTICAL)
                    voffset = (boxht - textht) >> 1;
            }
        }
        return voffset;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.006 -0500", hash_original_method = "53216DF5147B6AD3B10E93427C42A87D", hash_generated_method = "66FD3245AAC65127067928F4D541E68A")
    
private void invalidateCursorPath() {
        if (mHighlightPathBogus) {
            invalidateCursor();
        } else {
            final int horizontalPadding = getCompoundPaddingLeft();
            final int verticalPadding = getExtendedPaddingTop() + getVerticalOffset(true);

            if (mCursorCount == 0) {
                synchronized (sTempRect) {
                    /*
                     * The reason for this concern about the thickness of the
                     * cursor and doing the floor/ceil on the coordinates is that
                     * some EditTexts (notably textfields in the Browser) have
                     * anti-aliased text where not all the characters are
                     * necessarily at integer-multiple locations.  This should
                     * make sure the entire cursor gets invalidated instead of
                     * sometimes missing half a pixel.
                     */
                    float thick = FloatMath.ceil(mTextPaint.getStrokeWidth());
                    if (thick < 1.0f) {
                        thick = 1.0f;
                    }

                    thick /= 2.0f;

                    mHighlightPath.computeBounds(sTempRect, false);

                    invalidate((int) FloatMath.floor(horizontalPadding + sTempRect.left - thick),
                            (int) FloatMath.floor(verticalPadding + sTempRect.top - thick),
                            (int) FloatMath.ceil(horizontalPadding + sTempRect.right + thick),
                            (int) FloatMath.ceil(verticalPadding + sTempRect.bottom + thick));
                }
            } else {
                for (int i = 0; i < mCursorCount; i++) {
                    Rect bounds = mCursorDrawable[i].getBounds();
                    invalidate(bounds.left + horizontalPadding, bounds.top + verticalPadding,
                            bounds.right + horizontalPadding, bounds.bottom + verticalPadding);
                }
            }
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.008 -0500", hash_original_method = "18CF38FA770F258E57001CEB5008E4BD", hash_generated_method = "E5326BD12E4BF482120D74113678B976")
    
private void invalidateCursor() {
        int where = getSelectionEnd();

        invalidateCursor(where, where, where);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.011 -0500", hash_original_method = "7C61928A88071E487AF3987FA1C70EFA", hash_generated_method = "4139BB0FADBE2F8969A16FE36EA86B1B")
    
private void invalidateCursor(int a, int b, int c) {
       /* if (a >= 0 || b >= 0 || c >= 0) {
            int start = Math.min(Math.min(a, b), c);
            int end = Math.max(Math.max(a, b), c);
            invalidateRegion(start, end, true  Also invalidates blinking cursor );
        }*/
    }

    /**
     * Invalidates the region of text enclosed between the start and end text offsets.
     *
     * @hide
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.014 -0500", hash_original_method = "D9CEA3E6F10B2E8340E14518563D9425", hash_generated_method = "777677D903227440B9292EFA4C4147CD")
    
void invalidateRegion(int start, int end, boolean invalidateCursor) {
        if (mLayout == null) {
            invalidate();
        } else {
                int lineStart = mLayout.getLineForOffset(start);
                int top = mLayout.getLineTop(lineStart);

                // This is ridiculous, but the descent from the line above
                // can hang down into the line we really want to redraw,
                // so we have to invalidate part of the line above to make
                // sure everything that needs to be redrawn really is.
                // (But not the whole line above, because that would cause
                // the same problem with the descenders on the line above it!)
                if (lineStart > 0) {
                    top -= mLayout.getLineDescent(lineStart - 1);
                }

                int lineEnd;

                if (start == end)
                    lineEnd = lineStart;
                else
                    lineEnd = mLayout.getLineForOffset(end);

                int bottom = mLayout.getLineBottom(lineEnd);

                if (invalidateCursor) {
                    for (int i = 0; i < mCursorCount; i++) {
                        Rect bounds = mCursorDrawable[i].getBounds();
                        top = Math.min(top, bounds.top);
                        bottom = Math.max(bottom, bounds.bottom);
                    }
                }

                final int compoundPaddingLeft = getCompoundPaddingLeft();
                final int verticalPadding = getExtendedPaddingTop() + getVerticalOffset(true);

                int left, right;
                if (lineStart == lineEnd && !invalidateCursor) {
                    left = (int) mLayout.getPrimaryHorizontal(start);
                    right = (int) (mLayout.getPrimaryHorizontal(end) + 1.0);
                    left += compoundPaddingLeft;
                    right += compoundPaddingLeft;
                } else {
                    // Rectangle bounding box when the region spans several lines
                    left = compoundPaddingLeft;
                    right = getWidth() - getCompoundPaddingRight();
                }

                invalidate(mScrollX + left, verticalPadding + top,
                        mScrollX + right, verticalPadding + bottom);
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.016 -0500", hash_original_method = "14444C10F141ED0D65415BFE9043EE15", hash_generated_method = "17EFD15ECB3628DC19CF710BF24331AE")
    
private void registerForPreDraw() {
        final ViewTreeObserver observer = getViewTreeObserver();

        if (mPreDrawState == PREDRAW_NOT_REGISTERED) {
            observer.addOnPreDrawListener(this);
            mPreDrawState = PREDRAW_PENDING;
        } else if (mPreDrawState == PREDRAW_DONE) {
            mPreDrawState = PREDRAW_PENDING;
        }

        // else state is PREDRAW_PENDING, so keep waiting.
    }

    /**
     * {@inheritDoc}
     */
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.019 -0500", hash_original_method = "7ED99206FCCA4C828A375B5616572C0F", hash_generated_method = "9B3747C3A309A33946CDBFD0E6694EC8")
    
public boolean onPreDraw() {
        if (mPreDrawState != PREDRAW_PENDING) {
            return true;
        }

        if (mLayout == null) {
            assumeLayout();
        }

        boolean changed = false;

        if (mMovement != null) {
            /* This code also provides auto-scrolling when a cursor is moved using a
             * CursorController (insertion point or selection limits).
             * For selection, ensure start or end is visible depending on controller's state.
             */
            int curs = getSelectionEnd();
            // Do not create the controller if it is not already created.
            if (mSelectionModifierCursorController != null &&
                    mSelectionModifierCursorController.isSelectionStartDragged()) {
                curs = getSelectionStart();
            }

            /*
             * TODO: This should really only keep the end in view if
             * it already was before the text changed.  I'm not sure
             * of a good way to tell from here if it was.
             */
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
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.023 -0500", hash_original_method = "37A00D47E5792B2A68D22343089CAC73", hash_generated_method = "461C16F8528763DFA5C0435B340811DF")
    
@Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        mTemporaryDetach = false;
        
        if (mShowErrorAfterAttach) {
            showError();
            mShowErrorAfterAttach = false;
        }

        final ViewTreeObserver observer = getViewTreeObserver();
        // No need to create the controller.
        // The get method will add the listener on controller creation.
        if (mInsertionPointCursorController != null) {
            observer.addOnTouchModeChangeListener(mInsertionPointCursorController);
        }
        if (mSelectionModifierCursorController != null) {
            observer.addOnTouchModeChangeListener(mSelectionModifierCursorController);
        }

        // Resolve drawables as the layout direction has been resolved
        resolveDrawables();

        updateSpellCheckSpans(0, mText.length(), true /* create the spell checker if needed */);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.026 -0500", hash_original_method = "16099E9CBA4D38D7973AB46B58716911", hash_generated_method = "26901B1F437DD59B22BC6DEBEFFA6DEF")
    
@Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();

        final ViewTreeObserver observer = getViewTreeObserver();
        if (mPreDrawState != PREDRAW_NOT_REGISTERED) {
            observer.removeOnPreDrawListener(this);
            mPreDrawState = PREDRAW_NOT_REGISTERED;
        }

        if (mError != null) {
            hideError();
        }

        if (mBlink != null) {
            mBlink.removeCallbacks(mBlink);
        }

        if (mInsertionPointCursorController != null) {
            mInsertionPointCursorController.onDetached();
        }

        if (mSelectionModifierCursorController != null) {
            mSelectionModifierCursorController.onDetached();
        }

        hideControllers();

        resetResolvedDrawables();

        if (mSpellChecker != null) {
            mSpellChecker.closeSession();
            // Forces the creation of a new SpellChecker next time this window is created.
            // Will handle the cases where the settings has been changed in the meantime.
            mSpellChecker = null;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.028 -0500", hash_original_method = "F9485E7598554FF005152B05BE66332E", hash_generated_method = "61C00F115246E5103204AE78FC73EA6C")
    
@Override
    protected boolean isPaddingOffsetRequired() {
        return mShadowRadius != 0 || mDrawables != null;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.030 -0500", hash_original_method = "7F5FAD56D372BFDBD8919382F1DF4F10", hash_generated_method = "C3191ADDD628FDA1B8DEBCD96354A303")
    
@Override
    protected int getLeftPaddingOffset() {
        return getCompoundPaddingLeft() - mPaddingLeft +
                (int) Math.min(0, mShadowDx - mShadowRadius);
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.032 -0500", hash_original_method = "BBBA34DDC8A574B01D58B3AC0235EEFE", hash_generated_method = "DC8D30190F2A0D828F1D3E12CDB9314A")
    
@Override
    protected int getTopPaddingOffset() {
        return (int) Math.min(0, mShadowDy - mShadowRadius);
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.035 -0500", hash_original_method = "2F5480661817CC97DFDD529692B7CB6A", hash_generated_method = "1289E3CDEB75064882194165A82DFCEC")
    
@Override
    protected int getBottomPaddingOffset() {
        return (int) Math.max(0, mShadowDy + mShadowRadius);
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.037 -0500", hash_original_method = "03B94E40D261DCBBD1910980153D8E7A", hash_generated_method = "6B96C245B7D23B7DE14FBB5565A8763B")
    
@Override
    protected int getRightPaddingOffset() {
        return -(getCompoundPaddingRight() - mPaddingRight) +
                (int) Math.max(0, mShadowDx + mShadowRadius);
    }

    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.039 -0500", hash_original_method = "CE928B829998126087759CE89BCD7C50", hash_generated_method = "652AB197A49C37F550BE6DB905011CD6")
    
@Override
    protected boolean verifyDrawable(Drawable who) {
        final boolean verified = super.verifyDrawable(who);
        if (!verified && mDrawables != null) {
            return who == mDrawables.mDrawableLeft || who == mDrawables.mDrawableTop ||
                    who == mDrawables.mDrawableRight || who == mDrawables.mDrawableBottom ||
                    who == mDrawables.mDrawableStart || who == mDrawables.mDrawableEnd;
        }
        return verified;
    }

    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.042 -0500", hash_original_method = "40478AC632904F83B590338EFFF77EC4", hash_generated_method = "B1C4B67C47D151244574210A6912B8BF")
    
@Override
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        if (mDrawables != null) {
            if (mDrawables.mDrawableLeft != null) {
                mDrawables.mDrawableLeft.jumpToCurrentState();
            }
            if (mDrawables.mDrawableTop != null) {
                mDrawables.mDrawableTop.jumpToCurrentState();
            }
            if (mDrawables.mDrawableRight != null) {
                mDrawables.mDrawableRight.jumpToCurrentState();
            }
            if (mDrawables.mDrawableBottom != null) {
                mDrawables.mDrawableBottom.jumpToCurrentState();
            }
            if (mDrawables.mDrawableStart != null) {
                mDrawables.mDrawableStart.jumpToCurrentState();
            }
            if (mDrawables.mDrawableEnd != null) {
                mDrawables.mDrawableEnd.jumpToCurrentState();
            }
        }
    }

    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.045 -0500", hash_original_method = "BFAA7AB246AB7FE030F8E5E06E7C4938", hash_generated_method = "9B943392B226BF7AD091FF3F0C0EF73A")
    
@Override
    public void invalidateDrawable(Drawable drawable) {
        if (verifyDrawable(drawable)) {
            final Rect dirty = drawable.getBounds();
            int scrollX = mScrollX;
            int scrollY = mScrollY;

            // IMPORTANT: The coordinates below are based on the coordinates computed
            // for each compound drawable in onDraw(). Make sure to update each section
            // accordingly.
            final TextView.Drawables drawables = mDrawables;
            if (drawables != null) {
                if (drawable == drawables.mDrawableLeft) {
                    final int compoundPaddingTop = getCompoundPaddingTop();
                    final int compoundPaddingBottom = getCompoundPaddingBottom();
                    final int vspace = mBottom - mTop - compoundPaddingBottom - compoundPaddingTop;

                    scrollX += mPaddingLeft;
                    scrollY += compoundPaddingTop + (vspace - drawables.mDrawableHeightLeft) / 2;
                } else if (drawable == drawables.mDrawableRight) {
                    final int compoundPaddingTop = getCompoundPaddingTop();
                    final int compoundPaddingBottom = getCompoundPaddingBottom();
                    final int vspace = mBottom - mTop - compoundPaddingBottom - compoundPaddingTop;

                    scrollX += (mRight - mLeft - mPaddingRight - drawables.mDrawableSizeRight);
                    scrollY += compoundPaddingTop + (vspace - drawables.mDrawableHeightRight) / 2;
                } else if (drawable == drawables.mDrawableTop) {
                    final int compoundPaddingLeft = getCompoundPaddingLeft();
                    final int compoundPaddingRight = getCompoundPaddingRight();
                    final int hspace = mRight - mLeft - compoundPaddingRight - compoundPaddingLeft;

                    scrollX += compoundPaddingLeft + (hspace - drawables.mDrawableWidthTop) / 2;
                    scrollY += mPaddingTop;
                } else if (drawable == drawables.mDrawableBottom) {
                    final int compoundPaddingLeft = getCompoundPaddingLeft();
                    final int compoundPaddingRight = getCompoundPaddingRight();
                    final int hspace = mRight - mLeft - compoundPaddingRight - compoundPaddingLeft;

                    scrollX += compoundPaddingLeft + (hspace - drawables.mDrawableWidthBottom) / 2;
                    scrollY += (mBottom - mTop - mPaddingBottom - drawables.mDrawableSizeBottom);
                }
            }

            invalidate(dirty.left + scrollX, dirty.top + scrollY,
                    dirty.right + scrollX, dirty.bottom + scrollY);
        }
    }

    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.048 -0500", hash_original_method = "365B978F98464E672BAE2334EE130C56", hash_generated_method = "6046D534452136760D0DB2ABB06A9238")
    
@Override
    public int getResolvedLayoutDirection(Drawable who) {
        if (who == null) return View.LAYOUT_DIRECTION_LTR;
        if (mDrawables != null) {
            final Drawables drawables = mDrawables;
            if (who == drawables.mDrawableLeft || who == drawables.mDrawableRight ||
                who == drawables.mDrawableTop || who == drawables.mDrawableBottom ||
                who == drawables.mDrawableStart || who == drawables.mDrawableEnd) {
                return getResolvedLayoutDirection();
            }
        }
        return super.getResolvedLayoutDirection(who);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.051 -0500", hash_original_method = "361EEEB4229AF287B326C983EB9B20B0", hash_generated_method = "7AB8BBF18A1A74A69FEEAC345A2A97ED")
    
@Override
    protected boolean onSetAlpha(int alpha) {
        // Alpha is supported if and only if the drawing can be done in one pass.
        // TODO text with spans with a background color currently do not respect this alpha.
        if (getBackground() == null) {
            mCurrentAlpha = alpha;
            final Drawables dr = mDrawables;
            if (dr != null) {
                if (dr.mDrawableLeft != null) dr.mDrawableLeft.mutate().setAlpha(alpha);
                if (dr.mDrawableTop != null) dr.mDrawableTop.mutate().setAlpha(alpha);
                if (dr.mDrawableRight != null) dr.mDrawableRight.mutate().setAlpha(alpha);
                if (dr.mDrawableBottom != null) dr.mDrawableBottom.mutate().setAlpha(alpha);
                if (dr.mDrawableStart != null) dr.mDrawableStart.mutate().setAlpha(alpha);
                if (dr.mDrawableEnd != null) dr.mDrawableEnd.mutate().setAlpha(alpha);
            }
            return true;
        }

        mCurrentAlpha = 255;
        return false;
    }

    /**
     * When a TextView is used to display a useful piece of information to the user (such as a
     * contact's address), it should be made selectable, so that the user can select and copy this
     * content.
     *
     * Use {@link #setTextIsSelectable(boolean)} or the
     * {@link android.R.styleable#TextView_textIsSelectable} XML attribute to make this TextView
     * selectable (text is not selectable by default).
     *
     * Note that this method simply returns the state of this flag. Although this flag has to be set
     * in order to select text in non-editable TextView, the content of an {@link EditText} can
     * always be selected, independently of the value of this flag.
     *
     * @return True if the text displayed in this TextView can be selected by the user.
     *
     * @attr ref android.R.styleable#TextView_textIsSelectable
     */
    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.052 -0500", hash_original_method = "CB6193FD8EC60616857FED31421868C5", hash_generated_method = "78DBA5B206ACFAEB4AE89817F93E4B3A")
    
public boolean isTextSelectable() {
        return mTextIsSelectable;
    }
    
    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.565 -0400", hash_original_method = "F5356B5CDB0C54713C7C3659E2E49BDB", hash_generated_method = "F69C6BB36C85D5DAEA70974E82C48D37")
    public void setTextIsSelectable(boolean selectable) {
        if(mTextIsSelectable == selectable)        
            return;
        mTextIsSelectable = selectable;
        setFocusableInTouchMode(selectable);
        setFocusable(selectable);
        setClickable(selectable);
        setLongClickable(selectable);
        setMovementMethod(selectable ? ArrowKeyMovementMethod.getInstance() : null);
        //setText(getText(), selectable ? BufferType.SPANNABLE : BufferType.NORMAL);
        prepareCursorControllers();
        // ---------- Original Method ----------
        //if (mTextIsSelectable == selectable) return;
        //mTextIsSelectable = selectable;
        //setFocusableInTouchMode(selectable);
        //setFocusable(selectable);
        //setClickable(selectable);
        //setLongClickable(selectable);
        //setMovementMethod(selectable ? ArrowKeyMovementMethod.getInstance() : null);
        //setText(getText(), selectable ? BufferType.SPANNABLE : BufferType.NORMAL);
        //prepareCursorControllers();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.059 -0500", hash_original_method = "E327CCF4B590DA515951F33B48F8FD2D", hash_generated_method = "55310CA6FBAACDA19A9612D96AAE04E8")
    
@Override
    protected int[] onCreateDrawableState(int extraSpace) {
        final int[] drawableState;

        if (mSingleLine) {
            drawableState = super.onCreateDrawableState(extraSpace);
        } else {
            drawableState = super.onCreateDrawableState(extraSpace + 1);
            mergeDrawableStates(drawableState, MULTILINE_STATE_SET);
        }

        if (mTextIsSelectable) {
            // Disable pressed state, which was introduced when TextView was made clickable.
            // Prevents text color change.
            // setClickable(false) would have a similar effect, but it also disables focus changes
            // and long press actions, which are both needed by text selection.
            final int length = drawableState.length;
            for (int i = 0; i < length; i++) {
                if (drawableState[i] == R.attr.state_pressed) {
                    final int[] nonPressedState = new int[length - 1];
                    System.arraycopy(drawableState, 0, nonPressedState, 0, i);
                    System.arraycopy(drawableState, i + 1, nonPressedState, i, length - i - 1);
                    return nonPressedState;
                }
            }
        }

        return drawableState;
    }

    @DSVerified
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.066 -0500", hash_original_method = "FA11BA597CA3990806012CD62CCA6F49", hash_generated_method = "FFCEB09FFDE79BF596434566074776DB")
    
@Override
    protected void onDraw(Canvas canvas) {
        if (mPreDrawState == PREDRAW_DONE) {
            final ViewTreeObserver observer = getViewTreeObserver();
            observer.removeOnPreDrawListener(this);
            mPreDrawState = PREDRAW_NOT_REGISTERED;
        }

        if (mCurrentAlpha <= ViewConfiguration.ALPHA_THRESHOLD_INT) return;

        onDrawStub(canvas);
        
        //restartMarqueeIfNeeded();

//        // Draw the background for this view
//        super.onDraw(canvas);
//
//        final int compoundPaddingLeft = getCompoundPaddingLeft();
//        final int compoundPaddingTop = getCompoundPaddingTop();
//        final int compoundPaddingRight = getCompoundPaddingRight();
//        final int compoundPaddingBottom = getCompoundPaddingBottom();
//        final int scrollX = mScrollX;
//        final int scrollY = mScrollY;
//        final int right = mRight;
//        final int left = mLeft;
//        final int bottom = mBottom;
//        final int top = mTop;
//
//        final Drawables dr = mDrawables;
//        if (dr != null) {
//            /*
//             * Compound, not extended, because the icon is not clipped
//             * if the text height is smaller.
//             */
//
//            int vspace = bottom - top - compoundPaddingBottom - compoundPaddingTop;
//            int hspace = right - left - compoundPaddingRight - compoundPaddingLeft;
//
//            // IMPORTANT: The coordinates computed are also used in invalidateDrawable()
//            // Make sure to update invalidateDrawable() when changing this code.
//            if (dr.mDrawableLeft != null) {
//                canvas.save();
//                canvas.translate(scrollX + mPaddingLeft,
//                                 scrollY + compoundPaddingTop +
//                                 (vspace - dr.mDrawableHeightLeft) / 2);
//                dr.mDrawableLeft.draw(canvas);
//                canvas.restore();
//            }
//
//            // IMPORTANT: The coordinates computed are also used in invalidateDrawable()
//            // Make sure to update invalidateDrawable() when changing this code.
//            if (dr.mDrawableRight != null) {
//                canvas.save();
//                canvas.translate(scrollX + right - left - mPaddingRight - dr.mDrawableSizeRight,
//                         scrollY + compoundPaddingTop + (vspace - dr.mDrawableHeightRight) / 2);
//                dr.mDrawableRight.draw(canvas);
//                canvas.restore();
//            }
//
//            // IMPORTANT: The coordinates computed are also used in invalidateDrawable()
//            // Make sure to update invalidateDrawable() when changing this code.
//            if (dr.mDrawableTop != null) {
//                canvas.save();
//                canvas.translate(scrollX + compoundPaddingLeft + (hspace - dr.mDrawableWidthTop) / 2,
//                        scrollY + mPaddingTop);
//                dr.mDrawableTop.draw(canvas);
//                canvas.restore();
//            }
//
//            // IMPORTANT: The coordinates computed are also used in invalidateDrawable()
//            // Make sure to update invalidateDrawable() when changing this code.
//            if (dr.mDrawableBottom != null) {
//                canvas.save();
//                canvas.translate(scrollX + compoundPaddingLeft +
//                        (hspace - dr.mDrawableWidthBottom) / 2,
//                         scrollY + bottom - top - mPaddingBottom - dr.mDrawableSizeBottom);
//                dr.mDrawableBottom.draw(canvas);
//                canvas.restore();
//            }
//        }
//
//        int color = mCurTextColor;
//
//        if (mLayout == null) {
//            assumeLayout();
//        }
//
//        Layout layout = mLayout;
//        int cursorcolor = color;
//
//        if (mHint != null && mText.length() == 0) {
//            if (mHintTextColor != null) {
//                color = mCurHintTextColor;
//            }
//
//            layout = mHintLayout;
//        }
//
//        mTextPaint.setColor(color);
//        if (mCurrentAlpha != 255) {
//            // If set, the alpha will override the color's alpha. Multiply the alphas.
//            mTextPaint.setAlpha((mCurrentAlpha * Color.alpha(color)) / 255);
//        }
//        mTextPaint.drawableState = getDrawableState();
//
//        canvas.save();
//        /*  Would be faster if we didn't have to do this. Can we chop the
//            (displayable) text so that we don't need to do this ever?
//        */
//
//        int extendedPaddingTop = getExtendedPaddingTop();
//        int extendedPaddingBottom = getExtendedPaddingBottom();
//
//        float clipLeft = compoundPaddingLeft + scrollX;
//        float clipTop = extendedPaddingTop + scrollY;
//        float clipRight = right - left - compoundPaddingRight + scrollX;
//        float clipBottom = bottom - top - extendedPaddingBottom + scrollY;
//
//        if (mShadowRadius != 0) {
//            clipLeft += Math.min(0, mShadowDx - mShadowRadius);
//            clipRight += Math.max(0, mShadowDx + mShadowRadius);
//
//            clipTop += Math.min(0, mShadowDy - mShadowRadius);
//            clipBottom += Math.max(0, mShadowDy + mShadowRadius);
//        }
//
//        canvas.clipRect(clipLeft, clipTop, clipRight, clipBottom);
//
//        int voffsetText = 0;
//        int voffsetCursor = 0;
//
//        // translate in by our padding
//        {
//            /* shortcircuit calling getVerticaOffset() */
//            if ((mGravity & Gravity.VERTICAL_GRAVITY_MASK) != Gravity.TOP) {
//                voffsetText = getVerticalOffset(false);
//                voffsetCursor = getVerticalOffset(true);
//            }
//            canvas.translate(compoundPaddingLeft, extendedPaddingTop + voffsetText);
//        }
//
//        final int layoutDirection = getResolvedLayoutDirection();
//        final int absoluteGravity = Gravity.getAbsoluteGravity(mGravity, layoutDirection);
//        if (mEllipsize == TextUtils.TruncateAt.MARQUEE &&
//                mMarqueeFadeMode != MARQUEE_FADE_SWITCH_SHOW_ELLIPSIS) {
//            if (!mSingleLine && getLineCount() == 1 && canMarquee() &&
//                    (absoluteGravity & Gravity.HORIZONTAL_GRAVITY_MASK) != Gravity.LEFT) {
//                canvas.translate(mLayout.getLineRight(0) - (mRight - mLeft -
//                        getCompoundPaddingLeft() - getCompoundPaddingRight()), 0.0f);
//            }
//
//            if (mMarquee != null && mMarquee.isRunning()) {
//                canvas.translate(-mMarquee.mScroll, 0.0f);
//            }
//        }
//
//        Path highlight = null;
//        int selStart = -1, selEnd = -1;
//        boolean drawCursor = false;
//
//        //  If there is no movement method, then there can be no selection.
//        //  Check that first and attempt to skip everything having to do with
//        //  the cursor.
//        //  XXX This is not strictly true -- a program could set the
//        //  selection manually if it really wanted to.
//        if (mMovement != null && (isFocused() || isPressed())) {
//            selStart = getSelectionStart();
//            selEnd = getSelectionEnd();
//
//            if (selStart >= 0) {
//                if (mHighlightPath == null) mHighlightPath = new Path();
//
//                if (selStart == selEnd) {
//                    if (isCursorVisible() &&
//                            (SystemClock.uptimeMillis() - mShowCursor) % (2 * BLINK) < BLINK) {
//                        if (mHighlightPathBogus) {
//                            mHighlightPath.reset();
//                            mLayout.getCursorPath(selStart, mHighlightPath, mText);
//                            updateCursorsPositions();
//                            mHighlightPathBogus = false;
//                        }
//
//                        // XXX should pass to skin instead of drawing directly
//                        mHighlightPaint.setColor(cursorcolor);
//                        if (mCurrentAlpha != 255) {
//                            mHighlightPaint.setAlpha(
//                                    (mCurrentAlpha * Color.alpha(cursorcolor)) / 255);
//                        }
//                        mHighlightPaint.setStyle(Paint.Style.STROKE);
//                        highlight = mHighlightPath;
//                        drawCursor = mCursorCount > 0;
//                    }
//                } else if (textCanBeSelected()) {
//                    if (mHighlightPathBogus) {
//                        mHighlightPath.reset();
//                        mLayout.getSelectionPath(selStart, selEnd, mHighlightPath);
//                        mHighlightPathBogus = false;
//                    }
//
//                    // XXX should pass to skin instead of drawing directly
//                    mHighlightPaint.setColor(mHighlightColor);
//                    if (mCurrentAlpha != 255) {
//                        mHighlightPaint.setAlpha(
//                                (mCurrentAlpha * Color.alpha(mHighlightColor)) / 255);
//                    }
//                    mHighlightPaint.setStyle(Paint.Style.FILL);
//
//                    highlight = mHighlightPath;
//                }
//            }
//        }
//
//        /*  Comment out until we decide what to do about animations
//        boolean isLinearTextOn = false;
//        if (currentTransformation != null) {
//            isLinearTextOn = mTextPaint.isLinearTextOn();
//            Matrix m = currentTransformation.getMatrix();
//            if (!m.isIdentity()) {
//                // mTextPaint.setLinearTextOn(true);
//            }
//        }
//        */
//
//        final InputMethodState ims = mInputMethodState;
//        final int cursorOffsetVertical = voffsetCursor - voffsetText;
//        if (ims != null && ims.mBatchEditNesting == 0) {
//            InputMethodManager imm = InputMethodManager.peekInstance();
//            if (imm != null) {
//                if (imm.isActive(this)) {
//                    boolean reported = false;
//                    if (ims.mContentChanged || ims.mSelectionModeChanged) {
//                        // We are in extract mode and the content has changed
//                        // in some way... just report complete new text to the
//                        // input method.
//                        reported = reportExtractedText();
//                    }
//                    if (!reported && highlight != null) {
//                        int candStart = -1;
//                        int candEnd = -1;
//                        if (mText instanceof Spannable) {
//                            Spannable sp = (Spannable)mText;
//                            candStart = EditableInputConnection.getComposingSpanStart(sp);
//                            candEnd = EditableInputConnection.getComposingSpanEnd(sp);
//                        }
//                        imm.updateSelection(this, selStart, selEnd, candStart, candEnd);
//                    }
//                }
//                
//                if (imm.isWatchingCursor(this) && highlight != null) {
//                    highlight.computeBounds(ims.mTmpRectF, true);
//                    ims.mTmpOffset[0] = ims.mTmpOffset[1] = 0;
//    
//                    canvas.getMatrix().mapPoints(ims.mTmpOffset);
//                    ims.mTmpRectF.offset(ims.mTmpOffset[0], ims.mTmpOffset[1]);
//    
//                    ims.mTmpRectF.offset(0, cursorOffsetVertical);
//    
//                    ims.mCursorRectInWindow.set((int)(ims.mTmpRectF.left + 0.5),
//                            (int)(ims.mTmpRectF.top + 0.5),
//                            (int)(ims.mTmpRectF.right + 0.5),
//                            (int)(ims.mTmpRectF.bottom + 0.5));
//    
//                    imm.updateCursor(this,
//                            ims.mCursorRectInWindow.left, ims.mCursorRectInWindow.top,
//                            ims.mCursorRectInWindow.right, ims.mCursorRectInWindow.bottom);
//                }
//            }
//        }
//
//        if (mCorrectionHighlighter != null) {
//            mCorrectionHighlighter.draw(canvas, cursorOffsetVertical);
//        }
//
//        if (drawCursor) {
//            drawCursor(canvas, cursorOffsetVertical);
//            // Rely on the drawable entirely, do not draw the cursor line.
//            // Has to be done after the IMM related code above which relies on the highlight.
//            highlight = null;
//        }
//
//        layout.draw(canvas, highlight, mHighlightPaint, cursorOffsetVertical);
//
//        if (mMarquee != null && mMarquee.shouldDrawGhost()) {
//            canvas.translate((int) mMarquee.getGhostOffset(), 0.0f);
//            layout.draw(canvas, highlight, mHighlightPaint, cursorOffsetVertical);
//        }
//
//        /*  Comment out until we decide what to do about animations
//        if (currentTransformation != null) {
//            mTextPaint.setLinearTextOn(isLinearTextOn);
//        }
//
//        */
//        canvas.restore();
    }
    
    private void onDrawStub(Canvas canvas) {
        super.onDraw(canvas);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.069 -0500", hash_original_method = "78F759649DF9DADE7AC797D0043ECB32", hash_generated_method = "7D01EBABCCE1D5CC038ED2590719E640")
    
private void updateCursorsPositions() {
        if (mCursorDrawableRes == 0) {
            mCursorCount = 0;
            return; 
        }

        final int offset = getSelectionStart();
        final int line = mLayout.getLineForOffset(offset);
        final int top = mLayout.getLineTop(line);
        final int bottom = mLayout.getLineTop(line + 1);

        mCursorCount = mLayout.isLevelBoundary(offset) ? 2 : 1;

        int middle = bottom;
        if (mCursorCount == 2) {
            // Similar to what is done in {@link Layout.#getCursorPath(int, Path, CharSequence)}
            middle = (top + bottom) >> 1;
        }

        updateCursorPosition(0, top, middle, mLayout.getPrimaryHorizontal(offset));

        if (mCursorCount == 2) {
            updateCursorPosition(1, middle, bottom, mLayout.getSecondaryHorizontal(offset));
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.072 -0500", hash_original_method = "E19C5E504E793D85568DEA288EC3BB71", hash_generated_method = "A5A60BFBDF3885A555A0B732ED07BC36")
    
private void updateCursorPosition(int cursorIndex, int top, int bottom, float horizontal) {
        if (mCursorDrawable[cursorIndex] == null)
            mCursorDrawable[cursorIndex] = mContext.getResources().getDrawable(mCursorDrawableRes);

        if (mTempRect == null) mTempRect = new Rect();

        mCursorDrawable[cursorIndex].getPadding(mTempRect);
        final int width = mCursorDrawable[cursorIndex].getIntrinsicWidth();
        horizontal = Math.max(0.5f, horizontal - 0.5f);
        final int left = (int) (horizontal) - mTempRect.left;
        mCursorDrawable[cursorIndex].setBounds(left, top - mTempRect.top, left + width,
                bottom + mTempRect.bottom);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.074 -0500", hash_original_method = "38A0E9FCBE0DF4E61FBA21D6958F939A", hash_generated_method = "5DAB79D74012D8512E39A1F8ED5DC500")
    
private void drawCursor(Canvas canvas, int cursorOffsetVertical) {
        final boolean translate = cursorOffsetVertical != 0;
        if (translate) canvas.translate(0, cursorOffsetVertical);
        for (int i = 0; i < mCursorCount; i++) {
            mCursorDrawable[i].draw(canvas);
        }
        if (translate) canvas.translate(0, -cursorOffsetVertical);
    }

    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.078 -0500", hash_original_method = "9AB167D6C4B117BDFB6C2B72A1D862B5", hash_generated_method = "32A25FCF75C8A475B383E6A9BDA1B0F6")
    
@Override
    public void getFocusedRect(Rect r) {
        if (mLayout == null) {
            super.getFocusedRect(r);
            return;
        }

        int selEnd = getSelectionEnd();
        if (selEnd < 0) {
            super.getFocusedRect(r);
            return;
        }

        int selStart = getSelectionStart();
        
        int lineNum = selStart + selEnd;
        
        r.addTaint(selStart + selEnd + selStart + mLayout.getLineForOffset(lineNum));
        r.addTaint(mLayout.getLineTop(lineNum) + mLayout.getLineBottom(lineNum) +
                mLayout.getPrimaryHorizontal(lineNum));
        
        if (((selStart + selEnd) == 1)) {
            if (mHighlightPath == null) mHighlightPath = new Path();
            if (mHighlightPathBogus) {
                mHighlightPath.reset();
                mLayout.getSelectionPath(selStart, selEnd, mHighlightPath);
                mHighlightPathBogus = false;
            }
            synchronized (sTempRect) {
                mHighlightPath.computeBounds(sTempRect, true);
                r.left = (int)sTempRect.left-1;
                r.right = (int)sTempRect.right+1;
            }
        }
        
        //Original body
      /*  
        if (selStart < 0 || selStart >= selEnd) {
            int line = mLayout.getLineForOffset(selEnd);
            r.top = mLayout.getLineTop(line);
            r.bottom = mLayout.getLineBottom(line);
            r.left = (int) mLayout.getPrimaryHorizontal(selEnd) - 2;
            r.right = r.left + 4;
        } else {
            int lineStart = mLayout.getLineForOffset(selStart);
            int lineEnd = mLayout.getLineForOffset(selEnd);
            r.top = mLayout.getLineTop(lineStart);
            r.bottom = mLayout.getLineBottom(lineEnd);
            if (lineStart == lineEnd) {
                r.left = (int) mLayout.getPrimaryHorizontal(selStart);
                r.right = (int) mLayout.getPrimaryHorizontal(selEnd);
            } else {
                // Selection extends across multiple lines -- the focused
                // rect covers the entire width.
                if (mHighlightPath == null) mHighlightPath = new Path();
                if (mHighlightPathBogus) {
                    mHighlightPath.reset();
                    mLayout.getSelectionPath(selStart, selEnd, mHighlightPath);
                    mHighlightPathBogus = false;
                }
                synchronized (sTempRect) {
                    mHighlightPath.computeBounds(sTempRect, true);
                    r.left = (int)sTempRect.left-1;
                    r.right = (int)sTempRect.right+1;
                }
            }
        }
        */

        // Adjust for padding and gravity.
        int paddingLeft = getCompoundPaddingLeft();
        int paddingTop = getExtendedPaddingTop() + mGravity;
        
        if ((mGravity & Gravity.VERTICAL_GRAVITY_MASK) != Gravity.TOP) {
            paddingTop += getVerticalOffset(false);
        }
        r.offset(paddingLeft, paddingTop);
    }

    /**
     * Return the number of lines of text, or 0 if the internal Layout has not
     * been built.
     */
    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.081 -0500", hash_original_method = "97BE8C8E19AAF13DDBB7397BA8716CD7", hash_generated_method = "EEE1F02BCDA906005354077C760388E3")
    
public int getLineCount() {
        return mLayout != null ? mLayout.getLineCount() : 0;
    }

    /**
     * Return the baseline for the specified line (0...getLineCount() - 1)
     * If bounds is not null, return the top, left, right, bottom extents
     * of the specified line in it. If the internal Layout has not been built,
     * return 0 and set bounds to (0, 0, 0, 0)
     * @param line which line to examine (0..getLineCount() - 1)
     * @param bounds Optional. If not null, it returns the extent of the line
     * @return the Y-coordinate of the baseline
     */
    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.083 -0500", hash_original_method = "C119BED798B9C2A141229B29A4C86BDD", hash_generated_method = "E7111F73FD05C0A44B77E6A7185BF326")
    
public int getLineBounds(int line, Rect bounds) {
        if (mLayout == null) {
            if (bounds != null) {
                bounds.set(0, 0, 0, 0);
            }
            return 0;
        }
        else {
            int baseline = mLayout.getLineBounds(line, bounds);

            int voffset = getExtendedPaddingTop();
            if ((mGravity & Gravity.VERTICAL_GRAVITY_MASK) != Gravity.TOP) {
                voffset += getVerticalOffset(true);
            }
            if (bounds != null) {
                bounds.offset(getCompoundPaddingLeft(), voffset);
            }
            return baseline + voffset;
        }
    }

    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.085 -0500", hash_original_method = "3C56831CF91C4818C48A7DCC6043867F", hash_generated_method = "11AACCCD0BFDE6D0A18DC36C2E564BFA")
    
@Override
    public int getBaseline() {
        if (mLayout == null) {
            return super.getBaseline();
        }

        int voffset = 0;
        if ((mGravity & Gravity.VERTICAL_GRAVITY_MASK) != Gravity.TOP) {
            voffset = getVerticalOffset(true);
        }

        return getExtendedPaddingTop() + voffset + mLayout.getLineBaseline(0);
    }

    /**
     * @hide
     * @param offsetRequired
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.088 -0500", hash_original_method = "9B40D92CA2D66C315619C6CA13460A4B", hash_generated_method = "33E039A897C6078CD645936949D53969")
    
@Override
    protected int getFadeTop(boolean offsetRequired) {
        if (mLayout == null) return 0;

        int voffset = 0;
        if ((mGravity & Gravity.VERTICAL_GRAVITY_MASK) != Gravity.TOP) {
            voffset = getVerticalOffset(true);
        }
        
        if (offsetRequired) voffset += getTopPaddingOffset();

        return getExtendedPaddingTop() + voffset;
    }

    /**
     * @hide
     * @param offsetRequired
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.090 -0500", hash_original_method = "4B4E36AF8D516BA2309E720A4535DE33", hash_generated_method = "2DF5EDFD58C415612D02AB4D83DFE046")
    
@Override
    protected int getFadeHeight(boolean offsetRequired) {
        return mLayout != null ? mLayout.getHeight() : 0;
    }

    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.093 -0500", hash_original_method = "D780B8C0D740C935BBFD0FE1FAA345B5", hash_generated_method = "74526FFE127202BA83AD3871F886355F")
    
@Override
    public boolean onKeyPreIme(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            boolean isInSelectionMode = mSelectionActionMode != null;

            if (isInSelectionMode) {
                if (event.getAction() == KeyEvent.ACTION_DOWN && event.getRepeatCount() == 0) {
                    KeyEvent.DispatcherState state = getKeyDispatcherState();
                    if (state != null) {
                        state.startTracking(event, this);
                    }
                    return true;
                } else if (event.getAction() == KeyEvent.ACTION_UP) {
                    KeyEvent.DispatcherState state = getKeyDispatcherState();
                    if (state != null) {
                        state.handleUpEvent(event);
                    }
                    if (event.isTracking() && !event.isCanceled()) {
                        if (isInSelectionMode) {
                            stopSelectionActionMode();
                            return true;
                        }
                    }
                }
            }
        }
        return super.onKeyPreIme(keyCode, event);
    }

    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.095 -0500", hash_original_method = "34FB4F2A2A6D04958B0CB574357346B4", hash_generated_method = "FA388700703B0DBAAE3200ADC0E28EF9")
    
@Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        int which = doKeyDown(keyCode, event, null);
        if (which == 0) {
            // Go through default dispatching.
            return super.onKeyDown(keyCode, event);
        }

        return true;
    }

    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.098 -0500", hash_original_method = "29E1D0F837CE3120BC9F0CF834D8CD7B", hash_generated_method = "0AD02EFFA2C2E0123DDB1CF861AE83D9")
    
@Override
    public boolean onKeyMultiple(int keyCode, int repeatCount, KeyEvent event) {
        KeyEvent down = KeyEvent.changeAction(event, KeyEvent.ACTION_DOWN);

        int which = doKeyDown(keyCode, down, event);
        if (which == 0) {
            // Go through default dispatching.
            return super.onKeyMultiple(keyCode, repeatCount, event);
        }
        if (which == -1) {
            // Consumed the whole thing.
            return true;
        }

        repeatCount--;
        
        // We are going to dispatch the remaining events to either the input
        // or movement method.  To do this, we will just send a repeated stream
        // of down and up events until we have done the complete repeatCount.
        // It would be nice if those interfaces had an onKeyMultiple() method,
        // but adding that is a more complicated change.
        KeyEvent up = KeyEvent.changeAction(event, KeyEvent.ACTION_UP);
        if (which == 1) {
            mInput.onKeyUp(this, (Editable)mText, keyCode, up);
            while (--repeatCount > 0) {
                mInput.onKeyDown(this, (Editable)mText, keyCode, down);
                mInput.onKeyUp(this, (Editable)mText, keyCode, up);
            }
            hideErrorIfUnchanged();

        } else if (which == 2) {
            mMovement.onKeyUp(this, (Spannable)mText, keyCode, up);
            while (--repeatCount > 0) {
                mMovement.onKeyDown(this, (Spannable)mText, keyCode, down);
                mMovement.onKeyUp(this, (Spannable)mText, keyCode, up);
            }
        }

        return true;
    }

    /**
     * Returns true if pressing ENTER in this field advances focus instead
     * of inserting the character.  This is true mostly in single-line fields,
     * but also in mail addresses and subjects which will display on multiple
     * lines but where it doesn't make sense to insert newlines.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.100 -0500", hash_original_method = "F8A8C23B2901B68727EC4DCE05389523", hash_generated_method = "6186C0606A2B1A96580108A9615CEDE9")
    
private boolean shouldAdvanceFocusOnEnter() {
        if (mInput == null) {
            return false;
        }

        if (mSingleLine) {
            return true;
        }

        if ((mInputType & EditorInfo.TYPE_MASK_CLASS) == EditorInfo.TYPE_CLASS_TEXT) {
            int variation = mInputType & EditorInfo.TYPE_MASK_VARIATION;
            if (variation == EditorInfo.TYPE_TEXT_VARIATION_EMAIL_ADDRESS
                    || variation == EditorInfo.TYPE_TEXT_VARIATION_EMAIL_SUBJECT) {
                return true;
            }
        }

        return false;
    }

    /**
     * Returns true if pressing TAB in this field advances focus instead
     * of inserting the character.  Insert tabs only in multi-line editors.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.102 -0500", hash_original_method = "3820039215BEB2B783682B0606CB8390", hash_generated_method = "C21C298E6743F299E3813BB3E976B331")
    
private boolean shouldAdvanceFocusOnTab() {
        if (mInput != null && !mSingleLine) {
            if ((mInputType & EditorInfo.TYPE_MASK_CLASS) == EditorInfo.TYPE_CLASS_TEXT) {
                int variation = mInputType & EditorInfo.TYPE_MASK_VARIATION;
                if (variation == EditorInfo.TYPE_TEXT_FLAG_IME_MULTI_LINE
                        || variation == EditorInfo.TYPE_TEXT_FLAG_MULTI_LINE) {
                    return false;
                }
            }
        }
        return true;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.105 -0500", hash_original_method = "06C558A5D7DCBFD0B9ED82B9C331F1F3", hash_generated_method = "8B628FABF84485ECC3F0BF247BC7350A")
    
private int doKeyDown(int keyCode, KeyEvent event, KeyEvent otherEvent) {
        if (!isEnabled()) {
            return 0;
        }

        switch (keyCode) {
            case KeyEvent.KEYCODE_ENTER:
                if (event.hasNoModifiers()) {
                    // When mInputContentType is set, we know that we are
                    // running in a "modern" cupcake environment, so don't need
                    // to worry about the application trying to capture
                    // enter key events.
                    if (mInputContentType != null) {
                        // If there is an action listener, given them a
                        // chance to consume the event.
                        if (mInputContentType.onEditorActionListener != null &&
                                mInputContentType.onEditorActionListener.onEditorAction(
                                this, EditorInfo.IME_NULL, event)) {
                            mInputContentType.enterDown = true;
                            // We are consuming the enter key for them.
                            return -1;
                        }
                    }

                    // If our editor should move focus when enter is pressed, or
                    // this is a generated event from an IME action button, then
                    // don't let it be inserted into the text.
                    if ((event.getFlags() & KeyEvent.FLAG_EDITOR_ACTION) != 0
                            || shouldAdvanceFocusOnEnter()) {
                        if (hasOnClickListeners()) {
                            return 0;
                        }
                        return -1;
                    }
                }
                break;
                
            case KeyEvent.KEYCODE_DPAD_CENTER:
                if (event.hasNoModifiers()) {
                    if (shouldAdvanceFocusOnEnter()) {
                        return 0;
                    }
                }
                break;

            case KeyEvent.KEYCODE_TAB:
                if (event.hasNoModifiers() || event.hasModifiers(KeyEvent.META_SHIFT_ON)) {
                    if (shouldAdvanceFocusOnTab()) {
                        return 0;
                    }
                }
                break;

                // Has to be done on key down (and not on key up) to correctly be intercepted.
            case KeyEvent.KEYCODE_BACK:
                if (mSelectionActionMode != null) {
                    stopSelectionActionMode();
                    return -1;
                }
                break;
        }

        if (mInput != null) {
            resetErrorChangedFlag();

            boolean doDown = true;
            if (otherEvent != null) {
                try {
                    beginBatchEdit();
                    final boolean handled = mInput.onKeyOther(this, (Editable) mText, otherEvent);
                    hideErrorIfUnchanged();
                    doDown = false;
                    if (handled) {
                        return -1;
                    }
                } catch (AbstractMethodError e) {
                    // onKeyOther was added after 1.0, so if it isn't
                    // implemented we need to try to dispatch as a regular down.
                } finally {
                    endBatchEdit();
                }
            }
            
            if (doDown) {
                beginBatchEdit();
                final boolean handled = mInput.onKeyDown(this, (Editable) mText, keyCode, event);
                endBatchEdit();
                hideErrorIfUnchanged();
                if (handled) return 1;
            }
        }

        // bug 650865: sometimes we get a key event before a layout.
        // don't try to move around if we don't know the layout.

        if (mMovement != null && mLayout != null) {
            boolean doDown = true;
            if (otherEvent != null) {
                try {
                    boolean handled = mMovement.onKeyOther(this, (Spannable) mText,
                            otherEvent);
                    doDown = false;
                    if (handled) {
                        return -1;
                    }
                } catch (AbstractMethodError e) {
                    // onKeyOther was added after 1.0, so if it isn't
                    // implemented we need to try to dispatch as a regular down.
                }
            }
            if (doDown) {
                if (mMovement.onKeyDown(this, (Spannable)mText, keyCode, event))
                    return 2;
            }
        }

        return 0;
    }

    /**
     * Resets the mErrorWasChanged flag, so that future calls to {@link #setError(CharSequence)}
     * can be recorded.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.108 -0500", hash_original_method = "7246AB9167FB26EEC2DE7F4C0B385BF5", hash_generated_method = "E4671EF1E1FAADF7E6EDF97372DDD1C0")
    
public void resetErrorChangedFlag() {
        /*
         * Keep track of what the error was before doing the input
         * so that if an input filter changed the error, we leave
         * that error showing.  Otherwise, we take down whatever
         * error was showing when the user types something.
         */
        mErrorWasChanged = false;
    }

    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.110 -0500", hash_original_method = "0D0DD73869C4F453DDB81949A9BAE239", hash_generated_method = "2A290A4CEBC1011ED1576BAC146B510C")
    
public void hideErrorIfUnchanged() {
        if (mError != null && !mErrorWasChanged) {
            setError(null, null);
        }
    }

    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.115 -0500", hash_original_method = "5424E0BE647EA73439DA25EAE2FC3B50", hash_generated_method = "2088BCE0CF0B0ED59102074801DF62D1")
    
@Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (!isEnabled()) {
            return super.onKeyUp(keyCode, event);
        }

        switch (keyCode) {
            case KeyEvent.KEYCODE_DPAD_CENTER:
                if (event.hasNoModifiers()) {
                    /*
                     * If there is a click listener, just call through to
                     * super, which will invoke it.
                     *
                     * If there isn't a click listener, try to show the soft
                     * input method.  (It will also
                     * call performClick(), but that won't do anything in
                     * this case.)
                     */
                    if (!hasOnClickListeners()) {
                        if (mMovement != null && mText instanceof Editable
                                && mLayout != null && onCheckIsTextEditor()) {
                            InputMethodManager imm = InputMethodManager.peekInstance();
                            viewClicked(imm);
                            if (imm != null && mSoftInputShownOnFocus) {
                                imm.showSoftInput(this, 0);
                            }
                        }
                    }
                }
                return super.onKeyUp(keyCode, event);

            case KeyEvent.KEYCODE_ENTER:
                if (event.hasNoModifiers()) {
                    if (mInputContentType != null
                            && mInputContentType.onEditorActionListener != null
                            && mInputContentType.enterDown) {
                        mInputContentType.enterDown = false;
                        if (mInputContentType.onEditorActionListener.onEditorAction(
                                this, EditorInfo.IME_NULL, event)) {
                            return true;
                        }
                    }

                    if ((event.getFlags() & KeyEvent.FLAG_EDITOR_ACTION) != 0
                            || shouldAdvanceFocusOnEnter()) {
                        /*
                         * If there is a click listener, just call through to
                         * super, which will invoke it.
                         *
                         * If there isn't a click listener, try to advance focus,
                         * but still call through to super, which will reset the
                         * pressed state and longpress state.  (It will also
                         * call performClick(), but that won't do anything in
                         * this case.)
                         */
                        if (!hasOnClickListeners()) {
                            View v = focusSearch(FOCUS_DOWN);

                            if (v != null) {
                                if (!v.requestFocus(FOCUS_DOWN)) {
                                    throw new IllegalStateException(
                                            "focus search returned a view " +
                                            "that wasn't able to take focus!");
                                }

                                /*
                                 * Return true because we handled the key; super
                                 * will return false because there was no click
                                 * listener.
                                 */
                                super.onKeyUp(keyCode, event);
                                return true;
                            } else if ((event.getFlags()
                                    & KeyEvent.FLAG_EDITOR_ACTION) != 0) {
                                // No target for next focus, but make sure the IME
                                // if this came from it.
                                InputMethodManager imm = InputMethodManager.peekInstance();
                                if (imm != null && imm.isActive(this)) {
                                    imm.hideSoftInputFromWindow(getWindowToken(), 0);
                                }
                            }
                        }
                    }
                    return super.onKeyUp(keyCode, event);
                }
                break;
        }

        if (mInput != null)
            if (mInput.onKeyUp(this, (Editable) mText, keyCode, event))
                return true;

        if (mMovement != null && mLayout != null)
            if (mMovement.onKeyUp(this, (Spannable) mText, keyCode, event))
                return true;

        return super.onKeyUp(keyCode, event);
    }

    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.118 -0500", hash_original_method = "71F7C8422E0B6AB59261F7E112139F7A", hash_generated_method = "EDD0B49CDB792E08A54855578E9316ED")
    
@Override public boolean onCheckIsTextEditor() {
        return mInputType != EditorInfo.TYPE_NULL;
    }

    @DSComment("Method returns IO Object")
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.121 -0500", hash_original_method = "B65AC544FAB392A4E417298C2021FD9E", hash_generated_method = "FEE92D5B812246A4607923CA852D8F05")
    
@Override public InputConnection onCreateInputConnection(EditorInfo outAttrs) {
        if (onCheckIsTextEditor() && isEnabled()) {
            if (mInputMethodState == null) {
                mInputMethodState = new InputMethodState();
            }
            outAttrs.inputType = mInputType;
            if (mInputContentType != null) {
                outAttrs.imeOptions = mInputContentType.imeOptions;
                outAttrs.privateImeOptions = mInputContentType.privateImeOptions;
                outAttrs.actionLabel = mInputContentType.imeActionLabel;
                outAttrs.actionId = mInputContentType.imeActionId;
                outAttrs.extras = mInputContentType.extras;
            } else {
                outAttrs.imeOptions = EditorInfo.IME_NULL;
            }
            if (focusSearch(FOCUS_DOWN) != null) {
                outAttrs.imeOptions |= EditorInfo.IME_FLAG_NAVIGATE_NEXT;
            }
            if (focusSearch(FOCUS_UP) != null) {
                outAttrs.imeOptions |= EditorInfo.IME_FLAG_NAVIGATE_PREVIOUS;
            }
            if ((outAttrs.imeOptions&EditorInfo.IME_MASK_ACTION)
                    == EditorInfo.IME_ACTION_UNSPECIFIED) {
                if ((outAttrs.imeOptions&EditorInfo.IME_FLAG_NAVIGATE_NEXT) != 0) {
                    // An action has not been set, but the enter key will move to
                    // the next focus, so set the action to that.
                    outAttrs.imeOptions |= EditorInfo.IME_ACTION_NEXT;
                } else {
                    // An action has not been set, and there is no focus to move
                    // to, so let's just supply a "done" action.
                    outAttrs.imeOptions |= EditorInfo.IME_ACTION_DONE;
                }
                if (!shouldAdvanceFocusOnEnter()) {
                    outAttrs.imeOptions |= EditorInfo.IME_FLAG_NO_ENTER_ACTION;
                }
            }
            if (isMultilineInputType(outAttrs.inputType)) {
                // Multi-line text editors should always show an enter key.
                outAttrs.imeOptions |= EditorInfo.IME_FLAG_NO_ENTER_ACTION;
            }
            outAttrs.hintText = mHint;
            if (mText instanceof Editable) {
                InputConnection ic = new EditableInputConnection(this);
                outAttrs.initialSelStart = getSelectionStart();
                outAttrs.initialSelEnd = getSelectionEnd();
                outAttrs.initialCapsMode = ic.getCursorCapsMode(mInputType);
                return ic;
            }
        }
        return null;
    }

    /**
     * If this TextView contains editable content, extract a portion of it
     * based on the information in <var>request</var> in to <var>outText</var>.
     * @return Returns true if the text was successfully extracted, else false.
     */
    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.124 -0500", hash_original_method = "99984EBDDEABE6A84A830C32C2411508", hash_generated_method = "CCA28C01F3526E1B155AFF4C599AE93D")
    
public boolean extractText(ExtractedTextRequest request,
            ExtractedText outText) {
        return extractTextInternal(request, EXTRACT_UNKNOWN, EXTRACT_UNKNOWN,
                EXTRACT_UNKNOWN, outText);
    }
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.133 -0500", hash_original_method = "D5583180449515B28719DEEF8D226179", hash_generated_method = "81201E16FB9A2FCCF19A83FA2DFC7FB3")
    
boolean extractTextInternal(ExtractedTextRequest request,
            int partialStartOffset, int partialEndOffset, int delta,
            ExtractedText outText) {
        final CharSequence content = mText;
        if (content != null) {
            if (partialStartOffset != EXTRACT_NOTHING) {
                final int N = content.length();
                if (partialStartOffset < 0) {
                    outText.partialStartOffset = outText.partialEndOffset = -1;
                    partialStartOffset = 0;
                    partialEndOffset = N;
                } else {
                    // Now use the delta to determine the actual amount of text
                    // we need.
                    partialEndOffset += delta;
                    // Adjust offsets to ensure we contain full spans.
                    if (content instanceof Spanned) {
                        Spanned spanned = (Spanned)content;
                        Object[] spans = spanned.getSpans(partialStartOffset,
                                partialEndOffset, ParcelableSpan.class);
                        int i = spans.length;
                        while (i > 0) {
                            i--;
                            int j = spanned.getSpanStart(spans[i]);
                            if (j < partialStartOffset) partialStartOffset = j;
                            j = spanned.getSpanEnd(spans[i]);
                            if (j > partialEndOffset) partialEndOffset = j;
                        }
                    }
                    outText.partialStartOffset = partialStartOffset;
                    outText.partialEndOffset = partialEndOffset - delta;

                    if (partialStartOffset > N) {
                        partialStartOffset = N;
                    } else if (partialStartOffset < 0) {
                        partialStartOffset = 0;
                    }
                    if (partialEndOffset > N) {
                        partialEndOffset = N;
                    } else if (partialEndOffset < 0) {
                        partialEndOffset = 0;
                    }
                }
                if ((request.flags&InputConnection.GET_TEXT_WITH_STYLES) != 0) {
                    outText.text = content.subSequence(partialStartOffset,
                            partialEndOffset);
                } else {
                    outText.text = TextUtils.substring(content, partialStartOffset,
                            partialEndOffset);
                }
            } else {
                outText.partialStartOffset = 0;
                outText.partialEndOffset = 0;
                outText.text = "";
            }
            outText.flags = 0;
            if (MetaKeyKeyListener.getMetaState(mText, MetaKeyKeyListener.META_SELECTING) != 0) {
                outText.flags |= ExtractedText.FLAG_SELECTING;
            }
            if (mSingleLine) {
                outText.flags |= ExtractedText.FLAG_SINGLE_LINE;
            }
            outText.startOffset = 0;
            outText.selectionStart = getSelectionStart();
            outText.selectionEnd = getSelectionEnd();
            return true;
        }
        return false;
    }
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.135 -0500", hash_original_method = "E0B2F563BD380D089394FF3F6A004FAB", hash_generated_method = "E0B2F563BD380D089394FF3F6A004FAB")
    
boolean reportExtractedText() {
        final InputMethodState ims = mInputMethodState;
        if (ims != null) {
            final boolean contentChanged = ims.mContentChanged;
            if (contentChanged || ims.mSelectionModeChanged) {
                ims.mContentChanged = false;
                ims.mSelectionModeChanged = false;
                final ExtractedTextRequest req = mInputMethodState.mExtracting;
                if (req != null) {
                    InputMethodManager imm = InputMethodManager.peekInstance();
                    if (imm != null) {
                        if (DEBUG_EXTRACT) Log.v(LOG_TAG, "Retrieving extracted start="
                                + ims.mChangedStart + " end=" + ims.mChangedEnd
                                + " delta=" + ims.mChangedDelta);
                        if (ims.mChangedStart < 0 && !contentChanged) {
                            ims.mChangedStart = EXTRACT_NOTHING;
                        }
                        if (extractTextInternal(req, ims.mChangedStart, ims.mChangedEnd,
                                ims.mChangedDelta, ims.mTmpExtracted)) {
                            if (DEBUG_EXTRACT) Log.v(LOG_TAG, "Reporting extracted start="
                                    + ims.mTmpExtracted.partialStartOffset
                                    + " end=" + ims.mTmpExtracted.partialEndOffset
                                    + ": " + ims.mTmpExtracted.text);
                            imm.updateExtractedText(this, req.token,
                                    mInputMethodState.mTmpExtracted);
                            ims.mChangedStart = EXTRACT_UNKNOWN;
                            ims.mChangedEnd = EXTRACT_UNKNOWN;
                            ims.mChangedDelta = 0;
                            ims.mContentChanged = false;
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
    
    /**
     * Apply to this text view the given extracted text, as previously
     * returned by {@link #extractText(ExtractedTextRequest, ExtractedText)}.
     */
    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.140 -0500", hash_original_method = "BCA6F941081EC35E5D75ECC5825A5773", hash_generated_method = "4B9ECFE035B9A32E9E537C3BE7FDBBE9")
    
public void setExtractedText(ExtractedText text) {
        Editable content = getEditableText();
        if (text.text != null) {
            if (content == null) {
                setText(text.text, TextView.BufferType.EDITABLE);
            } else if (text.partialStartOffset < 0) {
                removeParcelableSpans(content, 0, content.length());
                content.replace(0, content.length(), text.text);
            } else {
                final int N = content.length();
                int start = text.partialStartOffset;
                if (start > N) start = N;
                int end = text.partialEndOffset;
                if (end > N) end = N;
                removeParcelableSpans(content, start, end);
                content.replace(start, end, text.text);
            }
        }
        
        // Now set the selection position...  make sure it is in range, to
        // avoid crashes.  If this is a partial update, it is possible that
        // the underlying text may have changed, causing us problems here.
        // Also we just don't want to trust clients to do the right thing.
        Spannable sp = (Spannable)getText();
        final int N = sp.length();
        int start = text.selectionStart;
        if (start < 0) start = 0;
        else if (start > N) start = N;
        int end = text.selectionEnd;
        if (end < 0) end = 0;
        else if (end > N) end = N;
        Selection.setSelection(sp, start, end);
        
        // Finally, update the selection mode.
        if ((text.flags&ExtractedText.FLAG_SELECTING) != 0) {
            MetaKeyKeyListener.startSelecting(this, sp);
        } else {
            MetaKeyKeyListener.stopSelecting(this, sp);
        }
    }

    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.142 -0500", hash_original_method = "7277A5A8CCC47DEA1B4CD7EF17ABC767", hash_generated_method = "CF5CBFA64580484AD8C40589C3A6079E")
    
public void setExtracting(ExtractedTextRequest req) {
        if (mInputMethodState != null) {
            mInputMethodState.mExtracting = req;
        }
        // This would stop a possible selection mode, but no such mode is started in case
        // extracted mode will start. Some text is selected though, and will trigger an action mode
        // in the extracted view.
        hideControllers();
    }

    /**
     * Called by the framework in response to a text completion from
     * the current input method, provided by it calling
     * {@link InputConnection#commitCompletion
     * InputConnection.commitCompletion()}.  The default implementation does
     * nothing; text views that are supporting auto-completion should override
     * this to do their desired behavior.
     *
     * @param text The auto complete text the user has selected.
     */
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.145 -0500", hash_original_method = "00B2156ECAED706F16E8F8EE554C74A0", hash_generated_method = "59FA59CE3A8D66A35B1E7FE49B06E016")
    
public void onCommitCompletion(CompletionInfo text) {
        // intentionally empty
    }

    /**
     * Called by the framework in response to a text auto-correction (such as fixing a typo using a
     * a dictionnary) from the current input method, provided by it calling
     * {@link InputConnection#commitCorrection} InputConnection.commitCorrection()}. The default
     * implementation flashes the background of the corrected word to provide feedback to the user.
     *
     * @param info The auto correct info about the text that was corrected.
     */
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.148 -0500", hash_original_method = "F0F3377304175B47C81480C4E8ACCA98", hash_generated_method = "9158502D1EE0D482190B49A12C2F38AD")
    
public void onCommitCorrection(CorrectionInfo info) {
        if (mCorrectionHighlighter == null) {
            mCorrectionHighlighter = new CorrectionHighlighter();
        } else {
            mCorrectionHighlighter.invalidate(false);
        }

        mCorrectionHighlighter.highlight(info);
    }

    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.183 -0500", hash_original_method = "7E84F411EBAFCA8676D2B5471CC899F7", hash_generated_method = "9AC3D14020ADEC1186BFD91EFB526255")
    
public void beginBatchEdit() {
        mInBatchEditControllers = true;
        final InputMethodState ims = mInputMethodState;
        if (ims != null) {
            int nesting = ++ims.mBatchEditNesting;
            if (nesting == 1) {
                ims.mCursorChanged = false;
                ims.mChangedDelta = 0;
                if (ims.mContentChanged) {
                    // We already have a pending change from somewhere else,
                    // so turn this into a full update.
                    ims.mChangedStart = 0;
                    ims.mChangedEnd = mText.length();
                } else {
                    ims.mChangedStart = EXTRACT_UNKNOWN;
                    ims.mChangedEnd = EXTRACT_UNKNOWN;
                    ims.mContentChanged = false;
                }
                onBeginBatchEdit();
            }
        }
    }
    
    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.186 -0500", hash_original_method = "53E9CEBDC3778C58F6F63CD77BA92C78", hash_generated_method = "4B3532DEC000306D304197C20D1706B9")
    
public void endBatchEdit() {
        mInBatchEditControllers = false;
        final InputMethodState ims = mInputMethodState;
        if (ims != null) {
            int nesting = --ims.mBatchEditNesting;
            if (nesting == 0) {
                finishBatchEdit(ims);
            }
        }
    }
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.188 -0500", hash_original_method = "49FC9F53534FDBC4416EED2F953235D5", hash_generated_method = "49FC9F53534FDBC4416EED2F953235D5")
    
void ensureEndedBatchEdit() {
        final InputMethodState ims = mInputMethodState;
        if (ims != null && ims.mBatchEditNesting != 0) {
            ims.mBatchEditNesting = 0;
            finishBatchEdit(ims);
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.190 -0500", hash_original_method = "5C56AEFFFAF99A5A2B83332AB2B67F77", hash_generated_method = "BF8D033335A8065910BC925221887E07")
    
void finishBatchEdit(final InputMethodState ims) {
        onEndBatchEdit();
        
       /* if (ims.mContentChanged || ims.mSelectionModeChanged) {
            updateAfterEdit();
            reportExtractedText();
        } else if (ims.mCursorChanged) {
            // Cheezy way to get us to report the current cursor location.
            invalidateCursor();
        }*/
    }
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.192 -0500", hash_original_method = "208D05A3FD324C57DA7FED31CDB936F2", hash_generated_method = "208D05A3FD324C57DA7FED31CDB936F2")
    
void updateAfterEdit() {
  /*      invalidate();
        int curs = getSelectionStart();

        if (curs >= 0 || (mGravity & Gravity.VERTICAL_GRAVITY_MASK) == Gravity.BOTTOM) {
            registerForPreDraw();
        }

        if (curs >= 0) {
            mHighlightPathBogus = true;
            makeBlink();
            bringPointIntoView(curs);
        }

        checkForResize();*/
    }
    
    /**
     * Called by the framework in response to a request to begin a batch
     * of edit operations through a call to link {@link #beginBatchEdit()}.
     */
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.194 -0500", hash_original_method = "77FDC1BC2641DD2E3C25361410AF5DB0", hash_generated_method = "E0183E0FB2FF999C8806671C9A27303A")
    
public void onBeginBatchEdit() {
        // intentionally empty
    }
    
    /**
     * Called by the framework in response to a request to end a batch
     * of edit operations through a call to link {@link #endBatchEdit}.
     */
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.196 -0500", hash_original_method = "52249F36F9A17EF1D72281B7699502C1", hash_generated_method = "548E5F88B7C8334FC3B9E3D43685F011")
    
public void onEndBatchEdit() {
        // intentionally empty
    }
    
    /**
     * Called by the framework in response to a private command from the
     * current method, provided by it calling
     * {@link InputConnection#performPrivateCommand
     * InputConnection.performPrivateCommand()}.
     *
     * @param action The action name of the command.
     * @param data Any additional data for the command.  This may be null.
     * @return Return true if you handled the command, else false.
     */
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.199 -0500", hash_original_method = "4EBA5E538796A46420814B4C84FDA4F7", hash_generated_method = "E66001FA423353B7A0351D411E35B90B")
    
public boolean onPrivateIMECommand(String action, Bundle data) {
        return false;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.202 -0500", hash_original_method = "4BBE7444811911981578CD1FC44D7898", hash_generated_method = "89A65CDC26A331ECEC7132210563FD54")
    
private void nullLayouts() {
        if (mLayout instanceof BoringLayout && mSavedLayout == null) {
            mSavedLayout = (BoringLayout) mLayout;
        }
        if (mHintLayout instanceof BoringLayout && mSavedHintLayout == null) {
            mSavedHintLayout = (BoringLayout) mHintLayout;
        }

        mSavedMarqueeModeLayout = mLayout = mHintLayout = null;

        // Since it depends on the value of mLayout
        prepareCursorControllers();
    }

    /**
     * Make a new Layout based on the already-measured size of the view,
     * on the assumption that it was measured correctly at some point.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.204 -0500", hash_original_method = "DE76D8533357DD76552FFACD362B9B5D", hash_generated_method = "83FED857DF11B166F36CA9AFBBDF4F3C")
    
private void assumeLayout() {
        int width = mRight - mLeft - getCompoundPaddingLeft() - getCompoundPaddingRight();

        if (width < 1) {
            width = 0;
        }

        int physicalWidth = width;

        if (mHorizontallyScrolling) {
            width = VERY_WIDE;
        }

        makeNewLayout(width, physicalWidth, UNKNOWN_BORING, UNKNOWN_BORING,
                      physicalWidth, false);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.207 -0500", hash_original_method = "FF379A6CAE0485B60E59F45E1B8A7246", hash_generated_method = "36071A8DB0C1FFBE8DC76245108702E7")
    
@Override
    protected void resetResolvedLayoutDirection() {
        super.resetResolvedLayoutDirection();

        if (mLayoutAlignment != null &&
                (mTextAlign == TextAlign.VIEW_START ||
                mTextAlign == TextAlign.VIEW_END)) {
            mLayoutAlignment = null;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.210 -0500", hash_original_method = "C784F6D37EB77044D77D743FABD50125", hash_generated_method = "EDB19ADE7B43A41E20ABBE2C809CF496")
    
private Layout.Alignment getLayoutAlignment() {
        if (mLayoutAlignment == null) {
            Layout.Alignment alignment;
            TextAlign textAlign = mTextAlign;
            switch (textAlign) {
                case INHERIT:
                    // fall through to gravity temporarily
                    // intention is to inherit value through view hierarchy.
                case GRAVITY:
                    switch (mGravity & Gravity.RELATIVE_HORIZONTAL_GRAVITY_MASK) {
                        case Gravity.START:
                            alignment = Layout.Alignment.ALIGN_NORMAL;
                            break;
                        case Gravity.END:
                            alignment = Layout.Alignment.ALIGN_OPPOSITE;
                            break;
                        case Gravity.LEFT:
                            alignment = Layout.Alignment.ALIGN_LEFT;
                            break;
                        case Gravity.RIGHT:
                            alignment = Layout.Alignment.ALIGN_RIGHT;
                            break;
                        case Gravity.CENTER_HORIZONTAL:
                            alignment = Layout.Alignment.ALIGN_CENTER;
                            break;
                        default:
                            alignment = Layout.Alignment.ALIGN_NORMAL;
                            break;
                    }
                    break;
                case TEXT_START:
                    alignment = Layout.Alignment.ALIGN_NORMAL;
                    break;
                case TEXT_END:
                    alignment = Layout.Alignment.ALIGN_OPPOSITE;
                    break;
                case CENTER:
                    alignment = Layout.Alignment.ALIGN_CENTER;
                    break;
                case VIEW_START:
                    alignment = (getResolvedLayoutDirection() == LAYOUT_DIRECTION_RTL) ?
                            Layout.Alignment.ALIGN_RIGHT : Layout.Alignment.ALIGN_LEFT;
                    break;
                case VIEW_END:
                    alignment = (getResolvedLayoutDirection() == LAYOUT_DIRECTION_RTL) ?
                            Layout.Alignment.ALIGN_LEFT : Layout.Alignment.ALIGN_RIGHT;
                    break;
                default:
                    alignment = Layout.Alignment.ALIGN_NORMAL;
                    break;
            }
            mLayoutAlignment = alignment;
        }
        return mLayoutAlignment;
    }

    /**
     * The width passed in is now the desired layout width,
     * not the full view width with padding.
     * {@hide}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.215 -0500", hash_original_method = "A69555D5DBD727E4B4531FE7AB9727A4", hash_generated_method = "15F120A49C80ECF449460D9170AD02D6")
    
protected void makeNewLayout(int wantWidth, int hintWidth,
                                 BoringLayout.Metrics boring,
                                 BoringLayout.Metrics hintBoring,
                                 int ellipsisWidth, boolean bringIntoView) {
        stopMarquee();

        // Update "old" cached values
        mOldMaximum = mMaximum;
        mOldMaxMode = mMaxMode;

        mHighlightPathBogus = true;

        if (wantWidth < 0) {
            wantWidth = 0;
        }
        if (hintWidth < 0) {
            hintWidth = 0;
        }

        Layout.Alignment alignment = getLayoutAlignment();
        boolean shouldEllipsize = mEllipsize != null && mInput == null;
        final boolean switchEllipsize = mEllipsize == TruncateAt.MARQUEE &&
                mMarqueeFadeMode != MARQUEE_FADE_NORMAL;
        TruncateAt effectiveEllipsize = mEllipsize;
        if (mEllipsize == TruncateAt.MARQUEE &&
                mMarqueeFadeMode == MARQUEE_FADE_SWITCH_SHOW_ELLIPSIS) {
            effectiveEllipsize = TruncateAt.END_SMALL;
        }

        if (mTextDir == null) {
            resolveTextDirection();
        }

        mLayout = makeSingleLayout(wantWidth, boring, ellipsisWidth, alignment, shouldEllipsize,
                effectiveEllipsize, effectiveEllipsize == mEllipsize);
        if (switchEllipsize) {
            TruncateAt oppositeEllipsize = effectiveEllipsize == TruncateAt.MARQUEE ?
                    TruncateAt.END : TruncateAt.MARQUEE;
            mSavedMarqueeModeLayout = makeSingleLayout(wantWidth, boring, ellipsisWidth, alignment,
                    shouldEllipsize, oppositeEllipsize, effectiveEllipsize != mEllipsize);
        }

        shouldEllipsize = mEllipsize != null;
        mHintLayout = null;

        if (mHint != null) {
            if (shouldEllipsize) hintWidth = wantWidth;

            if (hintBoring == UNKNOWN_BORING) {
                hintBoring = BoringLayout.isBoring(mHint, mTextPaint, mTextDir,
                                                   mHintBoring);
                if (hintBoring != null) {
                    mHintBoring = hintBoring;
                }
            }

            if (hintBoring != null) {
                if (hintBoring.width <= hintWidth &&
                    (!shouldEllipsize || hintBoring.width <= ellipsisWidth)) {
                    if (mSavedHintLayout != null) {
                        mHintLayout = mSavedHintLayout.
                                replaceOrMake(mHint, mTextPaint,
                                hintWidth, alignment, mSpacingMult, mSpacingAdd,
                                hintBoring, mIncludePad);
                    } else {
                        mHintLayout = BoringLayout.make(mHint, mTextPaint,
                                hintWidth, alignment, mSpacingMult, mSpacingAdd,
                                hintBoring, mIncludePad);
                    }

                    mSavedHintLayout = (BoringLayout) mHintLayout;
                } else if (shouldEllipsize && hintBoring.width <= hintWidth) {
                    if (mSavedHintLayout != null) {
                        mHintLayout = mSavedHintLayout.
                                replaceOrMake(mHint, mTextPaint,
                                hintWidth, alignment, mSpacingMult, mSpacingAdd,
                                hintBoring, mIncludePad, mEllipsize,
                                ellipsisWidth);
                    } else {
                        mHintLayout = BoringLayout.make(mHint, mTextPaint,
                                hintWidth, alignment, mSpacingMult, mSpacingAdd,
                                hintBoring, mIncludePad, mEllipsize,
                                ellipsisWidth);
                    }
                } else if (shouldEllipsize) {
                    mHintLayout = new StaticLayout(mHint,
                                0, mHint.length(),
                                mTextPaint, hintWidth, alignment, mTextDir, mSpacingMult,
                                mSpacingAdd, mIncludePad, mEllipsize,
                                ellipsisWidth, mMaxMode == LINES ? mMaximum : Integer.MAX_VALUE);
                } else {
                    mHintLayout = new StaticLayout(mHint, mTextPaint,
                            hintWidth, alignment, mTextDir, mSpacingMult, mSpacingAdd,
                            mIncludePad);
                }
            } else if (shouldEllipsize) {
                mHintLayout = new StaticLayout(mHint,
                            0, mHint.length(),
                            mTextPaint, hintWidth, alignment, mTextDir, mSpacingMult,
                            mSpacingAdd, mIncludePad, mEllipsize,
                            ellipsisWidth, mMaxMode == LINES ? mMaximum : Integer.MAX_VALUE);
            } else {
                mHintLayout = new StaticLayout(mHint, mTextPaint,
                        hintWidth, alignment, mTextDir, mSpacingMult, mSpacingAdd,
                        mIncludePad);
            }
        }

        if (bringIntoView) {
            registerForPreDraw();
        }

        if (mEllipsize == TextUtils.TruncateAt.MARQUEE) {
            if (!compressText(ellipsisWidth)) {
                final int height = mLayoutParams.height;
                // If the size of the view does not depend on the size of the text, try to
                // start the marquee immediately
                if (height != LayoutParams.WRAP_CONTENT && height != LayoutParams.MATCH_PARENT) {
                    startMarquee();
                } else {
                    // Defer the start of the marquee until we know our width (see setFrame())
                    mRestartMarquee = true;
                }
            }
        }

        // CursorControllers need a non-null mLayout
        prepareCursorControllers();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.219 -0500", hash_original_method = "919E80CF27514D43AA0D66AD56F3C47B", hash_generated_method = "71B953A2BA394E5646E248B50E7BA35D")
    
private Layout makeSingleLayout(int wantWidth, BoringLayout.Metrics boring, int ellipsisWidth,
            Layout.Alignment alignment, boolean shouldEllipsize, TruncateAt effectiveEllipsize,
            boolean useSaved) {
        Layout result = null;
        if (mText instanceof Spannable) {
            result = new DynamicLayout(mText, mTransformed, mTextPaint, wantWidth,
                    alignment, mTextDir, mSpacingMult,
                    mSpacingAdd, mIncludePad, mInput == null ? effectiveEllipsize : null,
                            ellipsisWidth);
        } else {
            if (boring == UNKNOWN_BORING) {
                boring = BoringLayout.isBoring(mTransformed, mTextPaint, mTextDir, mBoring);
                if (boring != null) {
                    mBoring = boring;
                }
            }

            if (boring != null) {
                if (boring.width <= wantWidth &&
                        (effectiveEllipsize == null || boring.width <= ellipsisWidth)) {
                    if (useSaved && mSavedLayout != null) {
                        result = mSavedLayout.replaceOrMake(mTransformed, mTextPaint,
                                wantWidth, alignment, mSpacingMult, mSpacingAdd,
                                boring, mIncludePad);
                    } else {
                        result = BoringLayout.make(mTransformed, mTextPaint,
                                wantWidth, alignment, mSpacingMult, mSpacingAdd,
                                boring, mIncludePad);
                    }

                    if (useSaved) {
                        mSavedLayout = (BoringLayout) result;
                    }
                } else if (shouldEllipsize && boring.width <= wantWidth) {
                    if (useSaved && mSavedLayout != null) {
                        result = mSavedLayout.replaceOrMake(mTransformed, mTextPaint,
                                wantWidth, alignment, mSpacingMult, mSpacingAdd,
                                boring, mIncludePad, effectiveEllipsize,
                                ellipsisWidth);
                    } else {
                        result = BoringLayout.make(mTransformed, mTextPaint,
                                wantWidth, alignment, mSpacingMult, mSpacingAdd,
                                boring, mIncludePad, effectiveEllipsize,
                                ellipsisWidth);
                    }
                } else if (shouldEllipsize) {
                    result = new StaticLayout(mTransformed,
                            0, mTransformed.length(),
                            mTextPaint, wantWidth, alignment, mTextDir, mSpacingMult,
                            mSpacingAdd, mIncludePad, effectiveEllipsize,
                            ellipsisWidth, mMaxMode == LINES ? mMaximum : Integer.MAX_VALUE);
                } else {
                    result = new StaticLayout(mTransformed, mTextPaint,
                            wantWidth, alignment, mTextDir, mSpacingMult, mSpacingAdd,
                            mIncludePad);
                }
            } else if (shouldEllipsize) {
                result = new StaticLayout(mTransformed,
                        0, mTransformed.length(),
                        mTextPaint, wantWidth, alignment, mTextDir, mSpacingMult,
                        mSpacingAdd, mIncludePad, effectiveEllipsize,
                        ellipsisWidth, mMaxMode == LINES ? mMaximum : Integer.MAX_VALUE);
            } else {
                result = new StaticLayout(mTransformed, mTextPaint,
                        wantWidth, alignment, mTextDir, mSpacingMult, mSpacingAdd,
                        mIncludePad);
            }
        }
        return result;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.609 -0400", hash_original_method = "F38DBB61FA92C8376A0BF0DADC8F1411", hash_generated_method = "B13012CAC0E1563228581F5DFB50ADC7")
    private boolean compressText(float width) {
        //addTaint(width);
        if(isHardwareAccelerated())        
        {
            boolean var68934A3E9455FA72420237EB05902327_1239452033 = (false);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1084813358 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1084813358;
        }
        if(width > 0.0f && mLayout != null && getLineCount() == 1 && !mUserSetTextScaleX &&
                mTextPaint.getTextScaleX() == 1.0f)        
        {
            final float textWidth = mLayout.getLineWidth(0);
            final float overflow = (textWidth + 1.0f - width) / width;
            if(overflow > 0.0f && overflow <= Marquee.MARQUEE_DELTA_MAX)            
            {
                mTextPaint.setTextScaleX(1.0f - overflow - 0.005f);
                post(new Runnable() {
                    @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.222 -0500", hash_original_method = "13996B392673F4526875359F0F526DB3", hash_generated_method = "25FB43B3CDEBAA9B64CBC4DD89B24EF5")
                    
public void run() {
                        requestLayout();
                    }
                });
                boolean varB326B5062B2F0E69046810717534CB09_1119661508 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_730163255 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_730163255;
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1633240311 = (false);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1947786176 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1947786176;
        // ---------- Original Method ----------
        //if (isHardwareAccelerated()) return false;
        //if (width > 0.0f && mLayout != null && getLineCount() == 1 && !mUserSetTextScaleX &&
        //mTextPaint.getTextScaleX() == 1.0f) {
        //final float textWidth = mLayout.getLineWidth(0);
        //final float overflow = (textWidth + 1.0f - width) / width;
        //if (overflow > 0.0f && overflow <= Marquee.MARQUEE_DELTA_MAX) {
        //mTextPaint.setTextScaleX(1.0f - overflow - 0.005f);
        //post(new Runnable() {
        //public void run() {
        //requestLayout();
        //}
        //});
        //return true;
        //}
        //}
        //return false;
    }

    /**
     * Set whether the TextView includes extra top and bottom padding to make
     * room for accents that go above the normal ascent and descent.
     * The default is true.
     *
     * @attr ref android.R.styleable#TextView_includeFontPadding
     */
    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.229 -0500", hash_original_method = "6C6FEB869E07EC14B89A3785CB4B2378", hash_generated_method = "62F3A46C8A339BA6809FEC29153F590A")
    
public void setIncludeFontPadding(boolean includepad) {
        if (mIncludePad != includepad) {
            mIncludePad = includepad;

            if (mLayout != null) {
                nullLayouts();
                requestLayout();
                invalidate();
            }
        }
    }

    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.238 -0500", hash_original_method = "CC856997CB919A81C5DE847B897CC56B", hash_generated_method = "3FBCFDEBA7EE6571CB5B4BFF9A49F313")
    
@Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //addTaint(widthMeasureSpec + heightMeasureSpec);
        
        //We are only interested in catching the override, this whole thing can be 
        //NOOP
      /*  int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        int width;
        int height;

        BoringLayout.Metrics boring = UNKNOWN_BORING;
        BoringLayout.Metrics hintBoring = UNKNOWN_BORING;

        if (mTextDir == null) {
            resolveTextDirection();
        }

        int des = -1;
        boolean fromexisting = false;

        if (widthMode == MeasureSpec.EXACTLY) {
            // Parent has told us how big to be. So be it.
            width = widthSize;
        } else {
            if (mLayout != null && mEllipsize == null) {
                des = desired(mLayout);
            }

            if (des < 0) {
                boring = BoringLayout.isBoring(mTransformed, mTextPaint, mTextDir, mBoring);
                if (boring != null) {
                    mBoring = boring;
                }
            } else {
                fromexisting = true;
            }

            if (boring == null || boring == UNKNOWN_BORING) {
                if (des < 0) {
                    des = (int) FloatMath.ceil(Layout.getDesiredWidth(mTransformed, mTextPaint));
                }

                width = des;
            } else {
                width = boring.width;
            }

            final Drawables dr = mDrawables;
            if (dr != null) {
                width = Math.max(width, dr.mDrawableWidthTop);
                width = Math.max(width, dr.mDrawableWidthBottom);
            }

            if (mHint != null) {
                int hintDes = -1;
                int hintWidth;

                if (mHintLayout != null && mEllipsize == null) {
                    hintDes = desired(mHintLayout);
                }

                if (hintDes < 0) {
                    hintBoring = BoringLayout.isBoring(mHint, mTextPaint, mHintBoring);
                    if (hintBoring != null) {
                        mHintBoring = hintBoring;
                    }
                }

                if (hintBoring == null || hintBoring == UNKNOWN_BORING) {
                    if (hintDes < 0) {
                        hintDes = (int) FloatMath.ceil(
                                Layout.getDesiredWidth(mHint, mTextPaint));
                    }

                    hintWidth = hintDes;
                } else {
                    hintWidth = hintBoring.width;
                }

                if (hintWidth > width) {
                    width = hintWidth;
                }
            }

            width += getCompoundPaddingLeft() + getCompoundPaddingRight();

            if (mMaxWidthMode == EMS) {
                width = Math.min(width, mMaxWidth * getLineHeight());
            } else {
                width = Math.min(width, mMaxWidth);
            }

            if (mMinWidthMode == EMS) {
                width = Math.max(width, mMinWidth * getLineHeight());
            } else {
                width = Math.max(width, mMinWidth);
            }

            // Check against our minimum width
            width = Math.max(width, getSuggestedMinimumWidth());

            if (widthMode == MeasureSpec.AT_MOST) {
                width = Math.min(widthSize, width);
            }
        }

        int want = width - getCompoundPaddingLeft() - getCompoundPaddingRight();
        int unpaddedWidth = want;

        if (mHorizontallyScrolling) want = VERY_WIDE;

        int hintWant = want;
        int hintWidth = (mHintLayout == null) ? hintWant : mHintLayout.getWidth();

        if (mLayout == null) {
            makeNewLayout(want, hintWant, boring, hintBoring,
                          width - getCompoundPaddingLeft() - getCompoundPaddingRight(), false);
        } else {
            final boolean layoutChanged = (mLayout.getWidth() != want) ||
                    (hintWidth != hintWant) ||
                    (mLayout.getEllipsizedWidth() !=
                            width - getCompoundPaddingLeft() - getCompoundPaddingRight());

            final boolean widthChanged = (mHint == null) &&
                    (mEllipsize == null) &&
                    (want > mLayout.getWidth()) &&
                    (mLayout instanceof BoringLayout || (fromexisting && des >= 0 && des <= want));

            final boolean maximumChanged = (mMaxMode != mOldMaxMode) || (mMaximum != mOldMaximum);

            if (layoutChanged || maximumChanged) {
                if (!maximumChanged && widthChanged) {
                    mLayout.increaseWidthTo(want);
                } else {
                    makeNewLayout(want, hintWant, boring, hintBoring,
                            width - getCompoundPaddingLeft() - getCompoundPaddingRight(), false);
                }
            } else {
                // Nothing has changed
            }
        }

        if (heightMode == MeasureSpec.EXACTLY) {
            // Parent has told us how big to be. So be it.
            height = heightSize;
            mDesiredHeightAtMeasure = -1;
        } else {
            int desired = getDesiredHeight();

            height = desired;
            mDesiredHeightAtMeasure = desired;

            if (heightMode == MeasureSpec.AT_MOST) {
                height = Math.min(desired, heightSize);
            }
        }

        int unpaddedHeight = height - getCompoundPaddingTop() - getCompoundPaddingBottom();
        if (mMaxMode == LINES && mLayout.getLineCount() > mMaximum) {
            unpaddedHeight = Math.min(unpaddedHeight, mLayout.getLineTop(mMaximum));
        }
        
         * We didn't let makeNewLayout() register to bring the cursor into view,
         * so do it here if there is any possibility that it is needed.
         
        if (mMovement != null ||
            mLayout.getWidth() > unpaddedWidth ||
            mLayout.getHeight() > unpaddedHeight) {
            registerForPreDraw();
        } else {
            scrollTo(0, 0);
        }

        setMeasuredDimension(width, height);*/
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.240 -0500", hash_original_method = "94259D4548546EABDDB6F8414E37FA42", hash_generated_method = "1F2948DA69D49421796FD6CA7842901B")
    
private int getDesiredHeight() {
        return Math.max(
                getDesiredHeight(mLayout, true),
                getDesiredHeight(mHintLayout, mEllipsize != null));
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.243 -0500", hash_original_method = "7AA300272C545049E0340D139CA1349D", hash_generated_method = "0F28E44844A952C5648BDFBEDABEB707")
    
private int getDesiredHeight(Layout layout, boolean cap) {
        if (layout == null) {
            return 0;
        }

        int linecount = layout.getLineCount();
        int pad = getCompoundPaddingTop() + getCompoundPaddingBottom();
        int desired = layout.getLineTop(linecount);

        final Drawables dr = mDrawables;
        if (dr != null) {
            desired = Math.max(desired, dr.mDrawableHeightLeft);
            desired = Math.max(desired, dr.mDrawableHeightRight);
        }

        desired += pad;

        if (mMaxMode == LINES) {
            /*
             * Don't cap the hint to a certain number of lines.
             * (Do cap it, though, if we have a maximum pixel height.)
             */
            if (cap) {
                if (linecount > mMaximum) {
                    desired = layout.getLineTop(mMaximum);

                    if (dr != null) {
                        desired = Math.max(desired, dr.mDrawableHeightLeft);
                        desired = Math.max(desired, dr.mDrawableHeightRight);
                    }

                    desired += pad;
                    linecount = mMaximum;
                }
            }
        } else {
            desired = Math.min(desired, mMaximum);
        }

        if (mMinMode == LINES) {
            if (linecount < mMinimum) {
                desired += getLineHeight() * (mMinimum - linecount);
            }
        } else {
            desired = Math.max(desired, mMinimum);
        }

        // Check against our minimum height
        desired = Math.max(desired, getSuggestedMinimumHeight());

        return desired;
    }

    /**
     * Check whether a change to the existing text layout requires a
     * new view layout.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.245 -0500", hash_original_method = "112907D8B10F62764352610BA7B79108", hash_generated_method = "C0F539F49F191F0FBEAC0548AC3B6FE6")
    
private void checkForResize() {
        boolean sizeChanged = false;

        if (mLayout != null) {
            // Check if our width changed
            if (mLayoutParams.width == LayoutParams.WRAP_CONTENT) {
                sizeChanged = true;
                invalidate();
            }

            // Check if our height changed
            if (mLayoutParams.height == LayoutParams.WRAP_CONTENT) {
                int desiredHeight = getDesiredHeight();

                if (desiredHeight != this.getHeight()) {
                    sizeChanged = true;
                }
            } else if (mLayoutParams.height == LayoutParams.MATCH_PARENT) {
                if (mDesiredHeightAtMeasure >= 0) {
                    int desiredHeight = getDesiredHeight();

                    if (desiredHeight != mDesiredHeightAtMeasure) {
                        sizeChanged = true;
                    }
                }
            }
        }

        if (sizeChanged) {
            requestLayout();
            // caller will have already invalidated
        }
    }

    /**
     * Check whether entirely new text requires a new view layout
     * or merely a new text layout.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.248 -0500", hash_original_method = "5832A71588E0ABA41180B589D326BF70", hash_generated_method = "E23BB2176D92050A2855E3FBAA5D7845")
    
private void checkForRelayout() {
        // If we have a fixed width, we can just swap in a new text layout
        // if the text height stays the same or if the view height is fixed.

        if ((mLayoutParams.width != LayoutParams.WRAP_CONTENT ||
                (mMaxWidthMode == mMinWidthMode && mMaxWidth == mMinWidth)) &&
                (mHint == null || mHintLayout != null) &&
                (mRight - mLeft - getCompoundPaddingLeft() - getCompoundPaddingRight() > 0)) {
            // Static width, so try making a new text layout.

            int oldht = mLayout.getHeight();
            int want = mLayout.getWidth();
            int hintWant = mHintLayout == null ? 0 : mHintLayout.getWidth();

            /*
             * No need to bring the text into view, since the size is not
             * changing (unless we do the requestLayout(), in which case it
             * will happen at measure).
             */
            makeNewLayout(want, hintWant, UNKNOWN_BORING, UNKNOWN_BORING,
                          mRight - mLeft - getCompoundPaddingLeft() - getCompoundPaddingRight(),
                          false);

            if (mEllipsize != TextUtils.TruncateAt.MARQUEE) {
                // In a fixed-height view, so use our new text layout.
                if (mLayoutParams.height != LayoutParams.WRAP_CONTENT &&
                    mLayoutParams.height != LayoutParams.MATCH_PARENT) {
                    invalidate();
                    return;
                }
    
                // Dynamic height, but height has stayed the same,
                // so use our new text layout.
                if (mLayout.getHeight() == oldht &&
                    (mHintLayout == null || mHintLayout.getHeight() == oldht)) {
                    invalidate();
                    return;
                }
            }

            // We lose: the height has changed and we have a dynamic height.
            // Request a new view layout using our new text layout.
            requestLayout();
            invalidate();
        } else {
            // Dynamic width, so we have no choice but to request a new
            // view layout with a new text layout.
            nullLayouts();
            requestLayout();
            invalidate();
        }
    }

    /**
     * Returns true if anything changed.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.252 -0500", hash_original_method = "0DA3D6D28C1432B95D5D1B1B5DDB2BC8", hash_generated_method = "23C022C622AFC9C9601D4F9901DFAB0D")
    
private boolean bringTextIntoView() {
        int line = 0;
        if ((mGravity & Gravity.VERTICAL_GRAVITY_MASK) == Gravity.BOTTOM) {
            line = mLayout.getLineCount() - 1;
        }

        Layout.Alignment a = mLayout.getParagraphAlignment(line);
        int dir = mLayout.getParagraphDirection(line);
        int hspace = mRight - mLeft - getCompoundPaddingLeft() - getCompoundPaddingRight();
        int vspace = mBottom - mTop - getExtendedPaddingTop() - getExtendedPaddingBottom();
        int ht = mLayout.getHeight();

        int scrollx, scrolly;

        // Convert to left, center, or right alignment.
        if (a == Layout.Alignment.ALIGN_NORMAL) {
            a = dir == Layout.DIR_LEFT_TO_RIGHT ? Layout.Alignment.ALIGN_LEFT :
                Layout.Alignment.ALIGN_RIGHT;
        } else if (a == Layout.Alignment.ALIGN_OPPOSITE){
            a = dir == Layout.DIR_LEFT_TO_RIGHT ? Layout.Alignment.ALIGN_RIGHT :
                Layout.Alignment.ALIGN_LEFT;
        }

        if (a == Layout.Alignment.ALIGN_CENTER) {
            /*
             * Keep centered if possible, or, if it is too wide to fit,
             * keep leading edge in view.
             */

            int left = (int) FloatMath.floor(mLayout.getLineLeft(line));
            int right = (int) FloatMath.ceil(mLayout.getLineRight(line));

            if (right - left < hspace) {
                scrollx = (right + left) / 2 - hspace / 2;
            } else {
                if (dir < 0) {
                    scrollx = right - hspace;
                } else {
                    scrollx = left;
                }
            }
        } else if (a == Layout.Alignment.ALIGN_RIGHT) {
            int right = (int) FloatMath.ceil(mLayout.getLineRight(line));
            scrollx = right - hspace;
        } else { // a == Layout.Alignment.ALIGN_LEFT (will also be the default)
            scrollx = (int) FloatMath.floor(mLayout.getLineLeft(line));
        }

        if (ht < vspace) {
            scrolly = 0;
        } else {
            if ((mGravity & Gravity.VERTICAL_GRAVITY_MASK) == Gravity.BOTTOM) {
                scrolly = ht - vspace;
            } else {
                scrolly = 0;
            }
        }

        if (scrollx != mScrollX || scrolly != mScrollY) {
            scrollTo(scrollx, scrolly);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Move the point, specified by the offset, into the view if it is needed.
     * This has to be called after layout. Returns true if anything changed.
     */
    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.257 -0500", hash_original_method = "3C0DD43A95E696C7A1592341A7B2F740", hash_generated_method = "FFD174F387B710E45BDFF34F9CF79952")
    
public boolean bringPointIntoView(int offset) {
        boolean changed = false;

        if (mLayout == null) return changed;

        int line = mLayout.getLineForOffset(offset);

        // FIXME: Is it okay to truncate this, or should we round?
        final int x = (int)mLayout.getPrimaryHorizontal(offset);
        final int top = mLayout.getLineTop(line);
        final int bottom = mLayout.getLineTop(line + 1);

        int left = (int) FloatMath.floor(mLayout.getLineLeft(line));
        int right = (int) FloatMath.ceil(mLayout.getLineRight(line));
        int ht = mLayout.getHeight();

        int grav;

        switch (mLayout.getParagraphAlignment(line)) {
            case ALIGN_LEFT:
                grav = 1;
                break;
            case ALIGN_RIGHT:
                grav = -1;
                break;
            case ALIGN_NORMAL:
                grav = mLayout.getParagraphDirection(line);
                break;
            case ALIGN_OPPOSITE:
                grav = -mLayout.getParagraphDirection(line);
                break;
            case ALIGN_CENTER:
            default:
                grav = 0;
                break;
        }

        int hspace = mRight - mLeft - getCompoundPaddingLeft() - getCompoundPaddingRight();
        int vspace = mBottom - mTop - getExtendedPaddingTop() - getExtendedPaddingBottom();

        int hslack = (bottom - top) / 2;
        int vslack = hslack;

        if (vslack > vspace / 4)
            vslack = vspace / 4;
        if (hslack > hspace / 4)
            hslack = hspace / 4;

        int hs = mScrollX;
        int vs = mScrollY;

        if (top - vs < vslack)
            vs = top - vslack;
        if (bottom - vs > vspace - vslack)
            vs = bottom - (vspace - vslack);
        if (ht - vs < vspace)
            vs = ht - vspace;
        if (0 - vs > 0)
            vs = 0;

        if (grav != 0) {
            if (x - hs < hslack) {
                hs = x - hslack;
            }
            if (x - hs > hspace - hslack) {
                hs = x - (hspace - hslack);
            }
        }

        if (grav < 0) {
            if (left - hs > 0)
                hs = left;
            if (right - hs < hspace)
                hs = right - hspace;
        } else if (grav > 0) {
            if (right - hs < hspace)
                hs = right - hspace;
            if (left - hs > 0)
                hs = left;
        } else /* grav == 0 */ {
            if (right - left <= hspace) {
                /*
                 * If the entire text fits, center it exactly.
                 */
                hs = left - (hspace - (right - left)) / 2;
            } else if (x > right - hslack) {
                /*
                 * If we are near the right edge, keep the right edge
                 * at the edge of the view.
                 */
                hs = right - hspace;
            } else if (x < left + hslack) {
                /*
                 * If we are near the left edge, keep the left edge
                 * at the edge of the view.
                 */
                hs = left;
            } else if (left > hs) {
                /*
                 * Is there whitespace visible at the left?  Fix it if so.
                 */
                hs = left;
            } else if (right < hs + hspace) {
                /*
                 * Is there whitespace visible at the right?  Fix it if so.
                 */
                hs = right - hspace;
            } else {
                /*
                 * Otherwise, float as needed.
                 */
                if (x - hs < hslack) {
                    hs = x - hslack;
                }
                if (x - hs > hspace - hslack) {
                    hs = x - (hspace - hslack);
                }
            }
        }

        if (hs != mScrollX || vs != mScrollY) {
            if (mScroller == null) {
                scrollTo(hs, vs);
            } else {
                long duration = AnimationUtils.currentAnimationTimeMillis() - mLastScroll;
                int dx = hs - mScrollX;
                int dy = vs - mScrollY;

                if (duration > ANIMATED_SCROLL_GAP) {
                    mScroller.startScroll(mScrollX, mScrollY, dx, dy);
                    awakenScrollBars(mScroller.getDuration());
                    invalidate();
                } else {
                    if (!mScroller.isFinished()) {
                        mScroller.abortAnimation();
                    }

                    scrollBy(dx, dy);
                }

                mLastScroll = AnimationUtils.currentAnimationTimeMillis();
            }

            changed = true;
        }

        if (isFocused()) {
            // This offsets because getInterestingRect() is in terms of viewport coordinates, but
            // requestRectangleOnScreen() is in terms of content coordinates.

            if (mTempRect == null) mTempRect = new Rect();
            // The offsets here are to ensure the rectangle we are using is
            // within our view bounds, in case the cursor is on the far left
            // or right.  If it isn't withing the bounds, then this request
            // will be ignored.
            mTempRect.set(x - 2, top, x + 2, bottom);
            getInterestingRect(mTempRect, line);
            mTempRect.offset(mScrollX, mScrollY);

            if (requestRectangleOnScreen(mTempRect)) {
                changed = true;
            }
        }

        return changed;
    }

    /**
     * Move the cursor, if needed, so that it is at an offset that is visible
     * to the user.  This will not move the cursor if it represents more than
     * one character (a selection range).  This will only work if the
     * TextView contains spannable text; otherwise it will do nothing.
     *
     * @return True if the cursor was actually moved, false otherwise.
     */
    @DSComment("IO movement methodName")
    @DSSpec(DSCat.IO_ACTION_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.261 -0500", hash_original_method = "02D4B7457672C459E287DBA1B16986EC", hash_generated_method = "002F454487A2930E313E7BC73201A33A")
    
public boolean moveCursorToVisibleOffset() {
        if (!(mText instanceof Spannable)) {
            return false;
        }
        int start = getSelectionStart();
        int end = getSelectionEnd();
        if (start != end) {
            return false;
        }
        
        // First: make sure the line is visible on screen:
        
        int line = mLayout.getLineForOffset(start);

        final int top = mLayout.getLineTop(line);
        final int bottom = mLayout.getLineTop(line + 1);
        final int vspace = mBottom - mTop - getExtendedPaddingTop() - getExtendedPaddingBottom();
        int vslack = (bottom - top) / 2;
        if (vslack > vspace / 4)
            vslack = vspace / 4;
        final int vs = mScrollY;

        if (top < (vs+vslack)) {
            line = mLayout.getLineForVertical(vs+vslack+(bottom-top));
        } else if (bottom > (vspace+vs-vslack)) {
            line = mLayout.getLineForVertical(vspace+vs-vslack-(bottom-top));
        }
        
        // Next: make sure the character is visible on screen:
        
        final int hspace = mRight - mLeft - getCompoundPaddingLeft() - getCompoundPaddingRight();
        final int hs = mScrollX;
        final int leftChar = mLayout.getOffsetForHorizontal(line, hs);
        final int rightChar = mLayout.getOffsetForHorizontal(line, hspace+hs);
        
        // line might contain bidirectional text
        final int lowChar = leftChar < rightChar ? leftChar : rightChar;
        final int highChar = leftChar > rightChar ? leftChar : rightChar;

        int newStart = start;
        if (newStart < lowChar) {
            newStart = lowChar;
        } else if (newStart > highChar) {
            newStart = highChar;
        }
        
        if (newStart != start) {
            Selection.setSelection((Spannable)mText, newStart);
            return true;
        }
        
        return false;
    }

    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.263 -0500", hash_original_method = "D06313C44705A7887AB654B7CF5A74B3", hash_generated_method = "23025E8AB99CE338DA1EE83552560128")
    
@Override
    public void computeScroll() {
        if (mScroller != null) {
            if (mScroller.computeScrollOffset()) {
                mScrollX = mScroller.getCurrX();
                mScrollY = mScroller.getCurrY();
                invalidateParentCaches();
                postInvalidate();  // So we draw again
            }
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.266 -0500", hash_original_method = "ABFDC323272F3E6393D3C4F9B9F60889", hash_generated_method = "8CE7BFB23412B6C75D1A68569388BB15")
    
private void getInterestingRect(Rect r, int line) {
        convertFromViewportToContentCoordinates(r);

        // Rectangle can can be expanded on first and last line to take
        // padding into account.
        // TODO Take left/right padding into account too?
        if (line == 0) r.top -= getExtendedPaddingTop();
        if (line == mLayout.getLineCount() - 1) r.bottom += getExtendedPaddingBottom();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.268 -0500", hash_original_method = "D2E7C9E2773084F5B5BC96B85475267E", hash_generated_method = "38332A7BC9F95197134E4A5BF5551A0A")
    
private void convertFromViewportToContentCoordinates(Rect r) {
        final int horizontalOffset = viewportToContentHorizontalOffset();
        r.left += horizontalOffset;
        r.right += horizontalOffset;

        final int verticalOffset = viewportToContentVerticalOffset();
        r.top += verticalOffset;
        r.bottom += verticalOffset;
        
        //r.addTaint(horizontalOffset + verticalOffset);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.270 -0500", hash_original_method = "3DB802CF5F82AE3562BB26F896D07DB6", hash_generated_method = "A5018E22166BD8CFC37440EBB2EFB275")
    
private int viewportToContentHorizontalOffset() {
        return getCompoundPaddingLeft() - mScrollX;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.272 -0500", hash_original_method = "1E5AEDFCDEE7B994A62FE1D426BA9AAE", hash_generated_method = "92A2BE03DCB067F3731CAAE011C31AAC")
    
private int viewportToContentVerticalOffset() {
        int offset = getExtendedPaddingTop() - mScrollY;
        if ((mGravity & Gravity.VERTICAL_GRAVITY_MASK) != Gravity.TOP) {
            offset += getVerticalOffset(false);
        }
        return offset;
    }

    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.274 -0500", hash_original_method = "7E6A70E8247BE9F0E1C3854BAECCAE99", hash_generated_method = "212E1850A73FCE6B4E94CE57A664D996")
    
@Override
    public void debug(int depth) {
        super.debug(depth);

        String output = debugIndent(depth);
        output += "frame={" + mLeft + ", " + mTop + ", " + mRight
                + ", " + mBottom + "} scroll={" + mScrollX + ", " + mScrollY
                + "} ";

        if (mText != null) {

            output += "mText=\"" + mText + "\" ";
            if (mLayout != null) {
                output += "mLayout width=" + mLayout.getWidth()
                        + " height=" + mLayout.getHeight();
            }
        } else {
            output += "mText=NULL";
        }
        Log.d(VIEW_LOG_TAG, output);
    }

    /**
     * Convenience for {@link Selection#getSelectionStart}.
     */
    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.277 -0500", hash_original_method = "FC0380BF9D344F57087ADAA0F0C8C1E5", hash_generated_method = "94DF1973D25DC8C3AF2B4887D7ED182D")
    
@ViewDebug.ExportedProperty(category = "text")
    public int getSelectionStart() {
        return Selection.getSelectionStart(getText());
    }

    /**
     * Convenience for {@link Selection#getSelectionEnd}.
     */
    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.279 -0500", hash_original_method = "59139061668C8515BDA5938230C2D233", hash_generated_method = "AFCDEB9A3371B824E147EB066362D511")
    
@ViewDebug.ExportedProperty(category = "text")
    public int getSelectionEnd() {
        return Selection.getSelectionEnd(getText());
    }

    /**
     * Return true iff there is a selection inside this text view.
     */
    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.282 -0500", hash_original_method = "BD52AC55F75FC20C70791ABE185D07B3", hash_generated_method = "478398040ECB8A17B7928024118A55F6")
    
public boolean hasSelection() {
        final int selectionStart = getSelectionStart();
        final int selectionEnd = getSelectionEnd();

        return selectionStart >= 0 && selectionStart != selectionEnd;
    }

    /**
     * Sets the properties of this field (lines, horizontally scrolling,
     * transformation method) to be for a single-line input.
     *
     * @attr ref android.R.styleable#TextView_singleLine
     */
    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.284 -0500", hash_original_method = "08C77724BEA7FD604DDC056EC8AC0A85", hash_generated_method = "26EE08C1F9DEDC593EDC7DD22DE81C21")
    
public void setSingleLine() {
        setSingleLine(true);
    }

    /**
     * Sets the properties of this field to transform input to ALL CAPS
     * display. This may use a "small caps" formatting if available.
     * This setting will be ignored if this field is editable or selectable.
     *
     * This call replaces the current transformation method. Disabling this
     * will not necessarily restore the previous behavior from before this
     * was enabled.
     *
     * @see #setTransformationMethod(TransformationMethod)
     * @attr ref android.R.styleable#TextView_textAllCaps
     */
    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.286 -0500", hash_original_method = "02E25EABD0939EA349140FD704ABC4B2", hash_generated_method = "6B71C346F5C24DC1875AFF80C4A4ACC5")
    
public void setAllCaps(boolean allCaps) {
        if (allCaps) {
            setTransformationMethod(new AllCapsTransformationMethod(getContext()));
        } else {
            setTransformationMethod(null);
        }
    }

    /**
     * If true, sets the properties of this field (number of lines, horizontally scrolling,
     * transformation method) to be for a single-line input; if false, restores these to the default
     * conditions.
     *
     * Note that the default conditions are not necessarily those that were in effect prior this
     * method, and you may want to reset these properties to your custom values.
     *
     * @attr ref android.R.styleable#TextView_singleLine
     */
    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.288 -0500", hash_original_method = "F67AECEDD15B73EEA4C7246A27A881B1", hash_generated_method = "A632A942888A523DC93F0E9011802DB2")
    
@android.view.RemotableViewMethod
    public void setSingleLine(boolean singleLine) {
        // Could be used, but may break backward compatibility.
        // if (mSingleLine == singleLine) return;
        setInputTypeSingleLine(singleLine);
        applySingleLine(singleLine, true, true);
    }

    /**
     * Adds or remove the EditorInfo.TYPE_TEXT_FLAG_MULTI_LINE on the mInputType.
     * @param singleLine
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.292 -0500", hash_original_method = "7606E2D7FCC52ECFF0946358CA46A596", hash_generated_method = "AFC27C35E623183138D0F104F5F625BE")
    
private void setInputTypeSingleLine(boolean singleLine) {
        if ((mInputType & EditorInfo.TYPE_MASK_CLASS) == EditorInfo.TYPE_CLASS_TEXT) {
            if (singleLine) {
                mInputType &= ~EditorInfo.TYPE_TEXT_FLAG_MULTI_LINE;
            } else {
                mInputType |= EditorInfo.TYPE_TEXT_FLAG_MULTI_LINE;
            }
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.294 -0500", hash_original_method = "939294E5BC9AAD2D1E9D05ACD8801E5C", hash_generated_method = "6D46F2014198AE5180AC70831BB8C59F")
    
private void applySingleLine(boolean singleLine, boolean applyTransformation,
            boolean changeMaxLines) {
        mSingleLine = singleLine;
        if (singleLine) {
            setLines(1);
            setHorizontallyScrolling(true);
            if (applyTransformation) {
                setTransformationMethod(SingleLineTransformationMethod.getInstance());
            }
        } else {
            if (changeMaxLines) {
                setMaxLines(Integer.MAX_VALUE);
            }
            setHorizontallyScrolling(false);
            if (applyTransformation) {
                setTransformationMethod(null);
            }
        }
    }

    /**
     * Causes words in the text that are longer than the view is wide
     * to be ellipsized instead of broken in the middle.  You may also
     * want to {@link #setSingleLine} or {@link #setHorizontallyScrolling}
     * to constrain the text to a single line.  Use <code>null</code>
     * to turn off ellipsizing.
     *
     * If {@link #setMaxLines} has been used to set two or more lines,
     * {@link android.text.TextUtils.TruncateAt#END} and
     * {@link android.text.TextUtils.TruncateAt#MARQUEE}* are only supported
     * (other ellipsizing types will not do anything).
     *
     * @attr ref android.R.styleable#TextView_ellipsize
     */
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.297 -0500", hash_original_method = "8F48F7BF1B8DCE5D5519F1200A0ED853", hash_generated_method = "F285A0E27AA103D42B31FA598A7067B7")
    
public void setEllipsize(TextUtils.TruncateAt where) {
        // TruncateAt is an enum. != comparison is ok between these singleton objects.
        if (mEllipsize != where) {
            mEllipsize = where;

//            if (mLayout != null) {
//                nullLayouts();
//                requestLayout();
//                invalidate();
//            }
        }
    }

    /**
     * Sets how many times to repeat the marquee animation. Only applied if the
     * TextView has marquee enabled. Set to -1 to repeat indefinitely.
     *
     * @attr ref android.R.styleable#TextView_marqueeRepeatLimit
     */
    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.299 -0500", hash_original_method = "CD4BE90CF39D915FD988D1208E7FE9CE", hash_generated_method = "A419815A101AAD509B78A13866BFED77")
    
public void setMarqueeRepeatLimit(int marqueeLimit) {
        mMarqueeRepeatLimit = marqueeLimit;
    }

    /**
     * Returns where, if anywhere, words that are longer than the view
     * is wide should be ellipsized.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.301 -0500", hash_original_method = "A6931739C39A011B325E0D6A04B5E1A4", hash_generated_method = "CFB05B22B28540D9A8CE821CCD319DCB")
    
@ViewDebug.ExportedProperty
    public TextUtils.TruncateAt getEllipsize() {
        return mEllipsize;
    }
    
    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.637 -0400", hash_original_method = "EF856664E3DB8B213F8E2D5A0092DC9C", hash_generated_method = "93D7697E67D97A654B5EB872F69B9428")
    @android.view.RemotableViewMethod
    public void setSelectAllOnFocus(boolean selectAllOnFocus) {
        mSelectAllOnFocus = selectAllOnFocus;
        if(selectAllOnFocus && !(mText instanceof Spannable))        
        {
            //setText(mText, BufferType.SPANNABLE);
        } //End block
        // ---------- Original Method ----------
        //mSelectAllOnFocus = selectAllOnFocus;
        //if (selectAllOnFocus && !(mText instanceof Spannable)) {
        //setText(mText, BufferType.SPANNABLE);
        //}
    }

    /**
     * Set whether the cursor is visible.  The default is true.
     *
     * @attr ref android.R.styleable#TextView_cursorVisible
     */
    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.305 -0500", hash_original_method = "8363604A399432417CD34524C965D01B", hash_generated_method = "BAC303BCA93BF440DBEF9909117D750B")
    
@android.view.RemotableViewMethod
    public void setCursorVisible(boolean visible) {
        if (mCursorVisible != visible) {
            mCursorVisible = visible;
            invalidate();

            makeBlink();

            // InsertionPointCursorController depends on mCursorVisible
            prepareCursorControllers();
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.307 -0500", hash_original_method = "D29F788B650242C9D9871158254DD48F", hash_generated_method = "E457BFBB74B0F4BFFC09E6F100CD374A")
    
private boolean isCursorVisible() {
        return mCursorVisible && isTextEditable();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.309 -0500", hash_original_method = "20D9FD35375357DA34698727A7AEC969", hash_generated_method = "6C72199B67DFE16C393EC856BE5F835A")
    
private boolean canMarquee() {
        int width = (mRight - mLeft - getCompoundPaddingLeft() - getCompoundPaddingRight());
        return width > 0 && (mLayout.getLineWidth(0) > width ||
                (mMarqueeFadeMode != MARQUEE_FADE_NORMAL && mSavedMarqueeModeLayout != null &&
                        mSavedMarqueeModeLayout.getLineWidth(0) > width));
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.312 -0500", hash_original_method = "A5A9508FE00ED8FCDF4CF88DA2302AE0", hash_generated_method = "3C352FDAC422D458F43A454ADA062329")
    
private void startMarquee() {
        // Do not ellipsize EditText
        if (mInput != null) return;

        if (compressText(getWidth() - getCompoundPaddingLeft() - getCompoundPaddingRight())) {
            return;
        }

        if ((mMarquee == null || mMarquee.isStopped()) && (isFocused() || isSelected()) &&
                getLineCount() == 1 && canMarquee()) {

            if (mMarqueeFadeMode == MARQUEE_FADE_SWITCH_SHOW_ELLIPSIS) {
                mMarqueeFadeMode = MARQUEE_FADE_SWITCH_SHOW_FADE;
                final Layout tmp = mLayout;
                mLayout = mSavedMarqueeModeLayout;
                mSavedMarqueeModeLayout = tmp;
                setHorizontalFadingEdgeEnabled(true);
                requestLayout();
                invalidate();
            }

            if (mMarquee == null) mMarquee = new Marquee(this);
            mMarquee.start(mMarqueeRepeatLimit);
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.316 -0500", hash_original_method = "20FFAC26BF2AB259CA62980CC6D60A71", hash_generated_method = "F3215B695414C9E5E0D0C0CC6A43EC9B")
    
private void stopMarquee() {
        if (mMarquee != null && !mMarquee.isStopped()) {
            mMarquee.stop();
        }

        if (mMarqueeFadeMode == MARQUEE_FADE_SWITCH_SHOW_FADE) {
            mMarqueeFadeMode = MARQUEE_FADE_SWITCH_SHOW_ELLIPSIS;
            final Layout tmp = mSavedMarqueeModeLayout;
            mSavedMarqueeModeLayout = mLayout;
            mLayout = tmp;
            setHorizontalFadingEdgeEnabled(false);
            requestLayout();
            invalidate();
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.318 -0500", hash_original_method = "21D240E17A817FDDEDCDA696469AE631", hash_generated_method = "279BC18922337C94767FA6C980C7E7AE")
    
private void startStopMarquee(boolean start) {
        if (mEllipsize == TextUtils.TruncateAt.MARQUEE) {
            if (start) {
                startMarquee();
            } else {
                stopMarquee();
            }
        }
    }

    /**
     * This method is called when the text is changed, in case any subclasses
     * would like to know.
     *
     * Within <code>text</code>, the <code>lengthAfter</code> characters
     * beginning at <code>start</code> have just replaced old text that had
     * length <code>lengthBefore</code>. It is an error to attempt to make
     * changes to <code>text</code> from this callback.
     *
     * @param text The text the TextView is displaying
     * @param start The offset of the start of the range of the text that was
     * modified
     * @param lengthBefore The length of the former text that has been replaced
     * @param lengthAfter The length of the replacement modified text
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.453 -0500", hash_original_method = "CD3A5A17C18A7E4515BB5E10EEE133D7", hash_generated_method = "04BEADDF64B5BF716EB1A082FE3CF209")
    
protected void onTextChanged(CharSequence text, int start, int lengthBefore, int lengthAfter) {
        // intentionally empty, template pattern method can be overridden by subclasses
    }

    /**
     * This method is called when the selection has changed, in case any
     * subclasses would like to know.
     * 
     * @param selStart The new selection start location.
     * @param selEnd The new selection end location.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.455 -0500", hash_original_method = "50DC1B812435050055FA72016E5949C2", hash_generated_method = "8BC172F6ECFFD1275CA5C0A389F3A4E9")
    
protected void onSelectionChanged(int selStart, int selEnd) {
        sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_TEXT_SELECTION_CHANGED);
    }

    /**
     * Adds a TextWatcher to the list of those whose methods are called
     * whenever this TextView's text changes.
     * <p>
     * In 1.0, the {@link TextWatcher#afterTextChanged} method was erroneously
     * not called after {@link #setText} calls.  Now, doing {@link #setText}
     * if there are any text changed listeners forces the buffer type to
     * Editable if it would not otherwise be and does call this method.
     */
    @DSComment("potential callback called inside method")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.457 -0500", hash_original_method = "B64F50676D912718618203C6EADBF90A", hash_generated_method = "626E7FC9F045281C668160725195AD32")
    @DSVerified
public void addTextChangedListener(TextWatcher watcher) {
        if (mListeners == null) {
            mListeners = new ArrayList<TextWatcher>();
        }

        watcher.beforeTextChanged("DS-UNKNOWN", 0, 0, 0);       
        watcher.onTextChanged("DS-UNKNOWN", 0,0,0);        
        watcher.afterTextChanged(new android.text.SpannableStringBuilder("DS-UNKNOWN"));

        mListeners.add(watcher);
    }

    /**
     * Removes the specified TextWatcher from the list of those whose
     * methods are called
     * whenever this TextView's text changes.
     */
    @DSComment("potential callback called inside method")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.459 -0500", hash_original_method = "8E2AAA118EDD6CA871B924E45DB79686", hash_generated_method = "877603A4E4B450BE70E59E877BCAE52C")
    
public void removeTextChangedListener(TextWatcher watcher) {
        if (mListeners != null) {
            int i = mListeners.indexOf(watcher);

            if (i >= 0) {
                mListeners.remove(i);
            }
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.462 -0500", hash_original_method = "282476D07DF9C69037F7F82B56506B50", hash_generated_method = "889CABD791268B4BF1AF0D48EDC840BE")
    
private void sendBeforeTextChanged(CharSequence text, int start, int before, int after) {
        if (mListeners != null) {
            final ArrayList<TextWatcher> list = mListeners;
            final int count = list.size();
            for (int i = 0; i < count; i++) {
                list.get(i).beforeTextChanged(text, start, before, after);
            }
        }

        // The spans that are inside or intersect the modified region no longer make sense
        removeIntersectingSpans(start, start + before, SpellCheckSpan.class);
        removeIntersectingSpans(start, start + before, SuggestionSpan.class);
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.642 -0400", hash_original_method = "3C2834233455B82E3097E9750018AB89", hash_generated_method = "9746CE50A0BC4885ABD44D4FB3A5D0A5")
    private <T> void removeIntersectingSpans(int start, int end, Class<T> type) {
        //addTaint(type.getTaint());
        //addTaint(end);
        //addTaint(start);
        if(!(mText instanceof Editable))        
            return;
        Editable text = (Editable) mText;
        T[] spans = text.getSpans(start, end, type);
        final int length = spans.length;
        for(int i = 0;i < length;i++)
        {
            final int s = text.getSpanStart(spans[i]);
            final int e = text.getSpanEnd(spans[i]);
            if(e == start || s == end)            
                break;
            text.removeSpan(spans[i]);
        } //End block
        // ---------- Original Method ----------
        //if (!(mText instanceof Editable)) return;
        //Editable text = (Editable) mText;
        //T[] spans = text.getSpans(start, end, type);
        //final int length = spans.length;
        //for (int i = 0; i < length; i++) {
        //final int s = text.getSpanStart(spans[i]);
        //final int e = text.getSpanEnd(spans[i]);
        //if (e == start || s == end) break;
        //text.removeSpan(spans[i]);
        //}
    }

    /**
     * Not private so it can be called from an inner class without going
     * through a thunk.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.467 -0500", hash_original_method = "942AE7F3893B5D5A1A729CC9A3D3A214", hash_generated_method = "0AFBFDB321B7E368AC164B7FF00A5AC4")
    
void sendOnTextChanged(CharSequence text, int start, int before, int after) {
        if (mListeners != null) {
            final ArrayList<TextWatcher> list = mListeners;
            final int count = list.size();
            for (int i = 0; i < count; i++) {
                list.get(i).onTextChanged(text, start, before, after);
            }
        }

        updateSpellCheckSpans(start, start + after, false);

        // Hide the controllers as soon as text is modified (typing, procedural...)
        // We do not hide the span controllers, since they can be added when a new text is
        // inserted into the text view (voice IME).
        hideCursorControllers();
    }

    /**
     * Not private so it can be called from an inner class without going
     * through a thunk.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.469 -0500", hash_original_method = "9B73ECD477F18D05FDDE640FFC672625", hash_generated_method = "9B73ECD477F18D05FDDE640FFC672625")
    
void sendAfterTextChanged(Editable text) {
        if (mListeners != null) {
            final ArrayList<TextWatcher> list = mListeners;
            final int count = list.size();
            for (int i = 0; i < count; i++) {
                list.get(i).afterTextChanged(text);
            }
        }
    }

    /**
     * Not private so it can be called from an inner class without going
     * through a thunk.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.471 -0500", hash_original_method = "4CD104B06ADE0BFE958B91634E28368D", hash_generated_method = "4CD104B06ADE0BFE958B91634E28368D")
    
void handleTextChanged(CharSequence buffer, int start, int before, int after) {
        final InputMethodState ims = mInputMethodState;
        if (ims == null || ims.mBatchEditNesting == 0) {
            updateAfterEdit();
        }
        if (ims != null) {
            ims.mContentChanged = true;
            if (ims.mChangedStart < 0) {
                ims.mChangedStart = start;
                ims.mChangedEnd = start+before;
            } else {
                ims.mChangedStart = Math.min(ims.mChangedStart, start);
                ims.mChangedEnd = Math.max(ims.mChangedEnd, start + before - ims.mChangedDelta);
            }
            ims.mChangedDelta += after-before;
        }

        sendOnTextChanged(buffer, start, before, after);
        onTextChanged(buffer, start, before, after);
    }
    
    /**
     * Not private so it can be called from an inner class without going
     * through a thunk.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.475 -0500", hash_original_method = "69940040C167925CDE0DCFB6E34891AF", hash_generated_method = "809F54672ADE7A73628E2B33015C04CB")
    
void spanChange(Spanned buf, Object what, int oldStart, int newStart, int oldEnd, int newEnd) {
        // XXX Make the start and end move together if this ends up
        // spending too much time invalidating.

        boolean selChanged = false;
        int newSelStart=-1, newSelEnd=-1;
        
        final InputMethodState ims = mInputMethodState;
        
        if (what == Selection.SELECTION_END) {
            mHighlightPathBogus = true;
            selChanged = true;
            newSelEnd = newStart;

            if (!isFocused()) {
                mSelectionMoved = true;
            }

            if (oldStart >= 0 || newStart >= 0) {
                invalidateCursor(Selection.getSelectionStart(buf), oldStart, newStart);
                registerForPreDraw();
                makeBlink();
            }
        }

        if (what == Selection.SELECTION_START) {
            mHighlightPathBogus = true;
            selChanged = true;
            newSelStart = newStart;

            if (!isFocused()) {
                mSelectionMoved = true;
            }

            if (oldStart >= 0 || newStart >= 0) {
                int end = Selection.getSelectionEnd(buf);
                invalidateCursor(end, oldStart, newStart);
            }
        }

        if (selChanged) {
            if ((buf.getSpanFlags(what)&Spanned.SPAN_INTERMEDIATE) == 0) {
                if (newSelStart < 0) {
                    newSelStart = Selection.getSelectionStart(buf);
                }
                if (newSelEnd < 0) {
                    newSelEnd = Selection.getSelectionEnd(buf);
                }
                onSelectionChanged(newSelStart, newSelEnd);
            }
        }

        if (what instanceof UpdateAppearance || what instanceof ParagraphStyle) {
            if (ims == null || ims.mBatchEditNesting == 0) {
                invalidate();
                mHighlightPathBogus = true;
                checkForResize();
            } else {
                ims.mContentChanged = true;
            }
        }

        if (MetaKeyKeyListener.isMetaTracker(buf, what)) {
            mHighlightPathBogus = true;
            if (ims != null && MetaKeyKeyListener.isSelectingMetaTracker(buf, what)) {
                ims.mSelectionModeChanged = true;
            }

            if (Selection.getSelectionStart(buf) >= 0) {
                if (ims == null || ims.mBatchEditNesting == 0) {
                    invalidateCursor();
                } else {
                    ims.mCursorChanged = true;
                }
            }
        }

        if (what instanceof ParcelableSpan) {
            // If this is a span that can be sent to a remote process,
            // the current extract editor would be interested in it.
            if (ims != null && ims.mExtracting != null) {
                if (ims.mBatchEditNesting != 0) {
                    if (oldStart >= 0) {
                        if (ims.mChangedStart > oldStart) {
                            ims.mChangedStart = oldStart;
                        }
                        if (ims.mChangedStart > oldEnd) {
                            ims.mChangedStart = oldEnd;
                        }
                    }
                    if (newStart >= 0) {
                        if (ims.mChangedStart > newStart) {
                            ims.mChangedStart = newStart;
                        }
                        if (ims.mChangedStart > newEnd) {
                            ims.mChangedStart = newEnd;
                        }
                    }
                } else {
                    if (DEBUG_EXTRACT) Log.v(LOG_TAG, "Span change outside of batch: "
                            + oldStart + "-" + oldEnd + ","
                            + newStart + "-" + newEnd + what);
                    ims.mContentChanged = true;
                }
            }
        }

        if (mSpellChecker != null && newStart < 0 && what instanceof SpellCheckSpan) {
            mSpellChecker.removeSpellCheckSpan((SpellCheckSpan) what);
        }
    }

    /**
     * Create new SpellCheckSpans on the modified region.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.478 -0500", hash_original_method = "3584A2B9A599770217F39B9A82ACFE32", hash_generated_method = "628CC83F2B2A1BD6D27EF4E230C2D32C")
    
private void updateSpellCheckSpans(int start, int end, boolean createSpellChecker) {
        if (isTextEditable() && isSuggestionsEnabled() && !(this instanceof ExtractEditText)) {
            if (mSpellChecker == null && createSpellChecker) {
                mSpellChecker = new SpellChecker(this);
            }
            if (mSpellChecker != null) {
                mSpellChecker.spellCheck(start, end);
            }
        }
    }

    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.567 -0500", hash_original_method = "5B060B8ED8B2D254991A03FDABE416A2", hash_generated_method = "1B20F98313C8A5B4A0513298907104FB")
    
@Override
    public void dispatchFinishTemporaryDetach() {
        mDispatchTemporaryDetach = true;
        super.dispatchFinishTemporaryDetach();
        mDispatchTemporaryDetach = false;
    }

    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.570 -0500", hash_original_method = "F389EC0F4785B5FE5917104FC845071C", hash_generated_method = "B3713F3D121502BB33300E5477FDB1FB")
    
@Override
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        // Only track when onStartTemporaryDetach() is called directly,
        // usually because this instance is an editable field in a list
        if (!mDispatchTemporaryDetach) mTemporaryDetach = true;

        // Because of View recycling in ListView, there is no easy way to know when a TextView with
        // selection becomes visible again. Until a better solution is found, stop text selection
        // mode (if any) as soon as this TextView is recycled.
        hideControllers();
    }

    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.572 -0500", hash_original_method = "FEAF0C4CB4DA72DBC669293A29968ABE", hash_generated_method = "FEC3A3C2B730D10560F99B5167C1C82E")
    
@Override
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        // Only track when onStartTemporaryDetach() is called directly,
        // usually because this instance is an editable field in a list
        if (!mDispatchTemporaryDetach) mTemporaryDetach = false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.575 -0500", hash_original_method = "B5EB741E17FA804FF18CB2D4805829B5", hash_generated_method = "C59B4705C66658B3C883376CE653191F")
    
@Override
    protected void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect) {
        if (mTemporaryDetach) {
            // If we are temporarily in the detach state, then do nothing.
            super.onFocusChanged(focused, direction, previouslyFocusedRect);
            return;
        }
        
        /*mShowCursor = SystemClock.uptimeMillis();

        ensureEndedBatchEdit();

        if (focused) {
            int selStart = getSelectionStart();
            int selEnd = getSelectionEnd();

            // SelectAllOnFocus fields are highlighted and not selected. Do not start text selection
            // mode for these, unless there was a specific selection already started.
            final boolean isFocusHighlighted = mSelectAllOnFocus && selStart == 0 &&
                    selEnd == mText.length();
            mCreatedWithASelection = mFrozenWithFocus && hasSelection() && !isFocusHighlighted;

            if (!mFrozenWithFocus || (selStart < 0 || selEnd < 0)) {
                // If a tap was used to give focus to that view, move cursor at tap position.
                // Has to be done before onTakeFocus, which can be overloaded.
                final int lastTapPosition = getLastTapPosition();
                if (lastTapPosition >= 0) {
                    Selection.setSelection((Spannable) mText, lastTapPosition);
                }

                if (mMovement != null) {
                    mMovement.onTakeFocus(this, (Spannable) mText, direction);
                }

                // The DecorView does not have focus when the 'Done' ExtractEditText button is
                // pressed. Since it is the ViewAncestor's mView, it requests focus before
                // ExtractEditText clears focus, which gives focus to the ExtractEditText.
                // This special case ensure that we keep current selection in that case.
                // It would be better to know why the DecorView does not have focus at that time.
                if (((this instanceof ExtractEditText) || mSelectionMoved) &&
                        selStart >= 0 && selEnd >= 0) {
                    
                     * Someone intentionally set the selection, so let them
                     * do whatever it is that they wanted to do instead of
                     * the default on-focus behavior.  We reset the selection
                     * here instead of just skipping the onTakeFocus() call
                     * because some movement methods do something other than
                     * just setting the selection in theirs and we still
                     * need to go through that path.
                     
                    Selection.setSelection((Spannable) mText, selStart, selEnd);
                }

                if (mSelectAllOnFocus) {
                    selectAll();
                }

                mTouchFocusSelected = true;
            }

            mFrozenWithFocus = false;
            mSelectionMoved = false;

            if (mText instanceof Spannable) {
                Spannable sp = (Spannable) mText;
                MetaKeyKeyListener.resetMetaState(sp);
            }

            makeBlink();

            if (mError != null) {
                showError();
            }
        } else {
            if (mError != null) {
                hideError();
            }
            // Don't leave us in the middle of a batch edit.
            onEndBatchEdit();

            if (this instanceof ExtractEditText) {
                // terminateTextSelectionMode removes selection, which we want to keep when
                // ExtractEditText goes out of focus.
                final int selStart = getSelectionStart();
                final int selEnd = getSelectionEnd();
                hideControllers();
                Selection.setSelection((Spannable) mText, selStart, selEnd);
            } else {
                hideControllers();
                downgradeEasyCorrectionSpans();
            }

            // No need to create the controller
            if (mSelectionModifierCursorController != null) {
                mSelectionModifierCursorController.resetTouchOffsets();
            }
        }

        startStopMarquee(focused);

        if (mTransformation != null) {
            mTransformation.onFocusChanged(this, mText, focused, direction, previouslyFocusedRect);
        }
*/
        super.onFocusChanged(focused, direction, previouslyFocusedRect);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.578 -0500", hash_original_method = "CD7EF11AEB2748DC958E6E43AA11AC3D", hash_generated_method = "6D92873A47C215D7E3E3EDDFCE4C96C1")
    
private int getLastTapPosition() {
        // No need to create the controller at that point, no last tap position saved
        if (mSelectionModifierCursorController != null) {
            int lastTapPosition = mSelectionModifierCursorController.getMinTouchOffset();
            if (lastTapPosition >= 0) {
                // Safety check, should not be possible.
                if (lastTapPosition > mText.length()) {
                    Log.e(LOG_TAG, "Invalid tap focus position (" + lastTapPosition + " vs "
                            + mText.length() + ")");
                    lastTapPosition = mText.length();
                }
                return lastTapPosition;
            }
        }

        return -1;
    }

    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.581 -0500", hash_original_method = "52F09857D084B6A7FF7DED6ACD447E38", hash_generated_method = "C41D94DAB2335864A18ADAD11A72AE98")
    
@Override
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        super.onWindowFocusChanged(hasWindowFocus);

        if (hasWindowFocus) {
            if (mBlink != null) {
                mBlink.uncancel();
                makeBlink();
            }
        } else {
            if (mBlink != null) {
                mBlink.cancel();
            }
            // Don't leave us in the middle of a batch edit.
            onEndBatchEdit();
            if (mInputContentType != null) {
                mInputContentType.enterDown = false;
            }

            hideControllers();
            if (mSuggestionsPopupWindow != null) {
                mSuggestionsPopupWindow.onParentLostFocus();
            }
        }

        startStopMarquee(hasWindowFocus);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.583 -0500", hash_original_method = "CACE22E1BEC14AEE1A4D35946DA3AF11", hash_generated_method = "26E55A35FEB25F9A879B86322E285814")
    
@Override
    protected void onVisibilityChanged(View changedView, int visibility) {
        super.onVisibilityChanged(changedView, visibility);
        if (visibility != VISIBLE) {
            hideControllers();
        }
    }

    /**
     * Use {@link BaseInputConnection#removeComposingSpans
     * BaseInputConnection.removeComposingSpans()} to remove any IME composing
     * state from this text view.
     */
    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.585 -0500", hash_original_method = "B1100F7CC0894E179F002CED35623F94", hash_generated_method = "EAE042BA3903312E8FFD5682D773B753")
    
public void clearComposingText() {
        if (mText instanceof Spannable) {
            BaseInputConnection.removeComposingSpans((Spannable)mText);
        }
    }
    
    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.588 -0500", hash_original_method = "D9A75FFCA0200824B6C25D7D7E778114", hash_generated_method = "C40C539386AB87890ED322944C97A618")
    
@Override
    public void setSelected(boolean selected) {
        boolean wasSelected = isSelected();

        super.setSelected(selected);

        if (selected != wasSelected && mEllipsize == TextUtils.TruncateAt.MARQUEE) {
            if (selected) {
                startMarquee();
            } else {
                stopMarquee();
            }
        }
    }

    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.592 -0500", hash_original_method = "66B01BC66F894D20F58119BE8C84CE2C", hash_generated_method = "BA2D876519865434DA188ECB30BDA3F6")
    
@Override
    public boolean onTouchEvent(MotionEvent event) {
        final int action = event.getActionMasked();

        if (hasSelectionController()) {
            getSelectionController().onTouchEvent(event);
        }

        if (action == MotionEvent.ACTION_DOWN) {
            mLastDownPositionX = event.getX();
            mLastDownPositionY = event.getY();

            // Reset this state; it will be re-set if super.onTouchEvent
            // causes focus to move to the view.
            mTouchFocusSelected = false;
            mIgnoreActionUpEvent = false;
        }

        final boolean superResult = super.onTouchEvent(event);

        /*
         * Don't handle the release after a long press, because it will
         * move the selection away from whatever the menu action was
         * trying to affect.
         */
        if (mDiscardNextActionUp && action == MotionEvent.ACTION_UP) {
            mDiscardNextActionUp = false;
            return superResult;
        }

        final boolean touchIsFinished = (action == MotionEvent.ACTION_UP) &&
                !shouldIgnoreActionUpEvent() && isFocused();

         if ((mMovement != null || onCheckIsTextEditor()) && isEnabled()
                && mText instanceof Spannable && mLayout != null) {
            boolean handled = false;

            if (mMovement != null) {
                handled |= mMovement.onTouchEvent(this, (Spannable) mText, event);
            }

            if (touchIsFinished && mLinksClickable && mAutoLinkMask != 0 && mTextIsSelectable) {
                // The LinkMovementMethod which should handle taps on links has not been installed
                // on non editable text that support text selection.
                // We reproduce its behavior here to open links for these.
                ClickableSpan[] links = ((Spannable) mText).getSpans(getSelectionStart(),
                        getSelectionEnd(), ClickableSpan.class);

                if (links.length != 0) {
                    links[0].onClick(this);
                    handled = true;
                }
            }

            if (touchIsFinished && (isTextEditable() || mTextIsSelectable)) {
                // Show the IME, except when selecting in read-only text.
                final InputMethodManager imm = InputMethodManager.peekInstance();
                viewClicked(imm);
                if (!mTextIsSelectable && mSoftInputShownOnFocus) {
                    handled |= imm != null && imm.showSoftInput(this, 0);
                }

                boolean selectAllGotFocus = mSelectAllOnFocus && didTouchFocusSelect();
                hideControllers();
                if (!selectAllGotFocus && mText.length() > 0) {
                    if (mSpellChecker != null) {
                        // When the cursor moves, the word that was typed may need spell check
                        mSpellChecker.onSelectionChanged();
                    }
                    if (!extractedTextModeWillBeStarted()) {
                        if (isCursorInsideEasyCorrectionSpan()) {
                            showSuggestions();
                        } else if (hasInsertionController()) {
                            getInsertionController().show();
                        }
                    }
                }

                handled = true;
            }

            if (handled) {
                return true;
            }
        }

        return superResult;
    }

    /**
     * @return <code>true</code> if the cursor/current selection overlaps a {@link SuggestionSpan}.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.594 -0500", hash_original_method = "03AC5F43014CB2A7B3EC5095819B8787", hash_generated_method = "389E037DC9B1DED467680639AD104457")
    
private boolean isCursorInsideSuggestionSpan() {
        if (!(mText instanceof Spannable)) return false;

        SuggestionSpan[] suggestionSpans = ((Spannable) mText).getSpans(getSelectionStart(),
                getSelectionEnd(), SuggestionSpan.class);
        return (suggestionSpans.length > 0);
    }

    /**
     * @return <code>true</code> if the cursor is inside an {@link SuggestionSpan} with
     * {@link SuggestionSpan#FLAG_EASY_CORRECT} set.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.596 -0500", hash_original_method = "FDBB0D2E258BF757A8B32CAC4ADCAFC2", hash_generated_method = "63CA808515F0D03F465464B7F0F58CFE")
    
private boolean isCursorInsideEasyCorrectionSpan() {
        Spannable spannable = (Spannable) mText;
        SuggestionSpan[] suggestionSpans = spannable.getSpans(getSelectionStart(),
                getSelectionEnd(), SuggestionSpan.class);
        for (int i = 0; i < suggestionSpans.length; i++) {
            if ((suggestionSpans[i].getFlags() & SuggestionSpan.FLAG_EASY_CORRECT) != 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * Downgrades to simple suggestions all the easy correction spans that are not a spell check
     * span.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.600 -0500", hash_original_method = "B422CE655E2FA1B2DED230B806484199", hash_generated_method = "8B272A65EC9C145D8D7A3CAC51D55ECF")
    
private void downgradeEasyCorrectionSpans() {
        if (mText instanceof Spannable) {
            Spannable spannable = (Spannable) mText;
            SuggestionSpan[] suggestionSpans = spannable.getSpans(0,
                    spannable.length(), SuggestionSpan.class);
            for (int i = 0; i < suggestionSpans.length; i++) {
                int flags = suggestionSpans[i].getFlags();
                if ((flags & SuggestionSpan.FLAG_EASY_CORRECT) != 0
                        && (flags & SuggestionSpan.FLAG_MISSPELLED) == 0) {
                    flags &= ~SuggestionSpan.FLAG_EASY_CORRECT;
                    suggestionSpans[i].setFlags(flags);
                }
            }
        }
    }

    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.602 -0500", hash_original_method = "F41FEEC7411770322E4286C20722D03F", hash_generated_method = "26132ED2B04CFC87467A243AAB616D01")
    
@Override
    public boolean onGenericMotionEvent(MotionEvent event) {
        if (mMovement != null && mText instanceof Spannable && mLayout != null) {
            try {
                if (mMovement.onGenericMotionEvent(this, (Spannable) mText, event)) {
                    return true;
                }
            } catch (AbstractMethodError ex) {
                // onGenericMotionEvent was added to the MovementMethod interface in API 12.
                // Ignore its absence in case third party applications implemented the
                // interface directly.
            }
        }
        return super.onGenericMotionEvent(event);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.605 -0500", hash_original_method = "1022846F3BD24E55F7B42FF144EBDE9C", hash_generated_method = "DAD6D0E43EF9339B29A9002BF6C34AA9")
    
private void prepareCursorControllers() {
      /*  boolean windowSupportsHandles = false;

        ViewGroup.LayoutParams params = getRootView().getLayoutParams();
        if (params instanceof WindowManager.LayoutParams) {
            WindowManager.LayoutParams windowParams = (WindowManager.LayoutParams) params;
            windowSupportsHandles = windowParams.type < WindowManager.LayoutParams.FIRST_SUB_WINDOW
                    || windowParams.type > WindowManager.LayoutParams.LAST_SUB_WINDOW;
        }

        mInsertionControllerEnabled = windowSupportsHandles && isCursorVisible() && mLayout != null;
        mSelectionControllerEnabled = windowSupportsHandles && textCanBeSelected() &&
                mLayout != null;

        if (!mInsertionControllerEnabled) {
            hideInsertionPointCursorController();
            if (mInsertionPointCursorController != null) {
                mInsertionPointCursorController.onDetached();
                mInsertionPointCursorController = null;
            }
        }

        if (!mSelectionControllerEnabled) {
            stopSelectionActionMode();
            if (mSelectionModifierCursorController != null) {
                mSelectionModifierCursorController.onDetached();
                mSelectionModifierCursorController = null;
            }
        }*/
    }

    /**
     * @return True iff this TextView contains a text that can be edited, or if this is
     * a selectable TextView.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.607 -0500", hash_original_method = "5768F33DD15C2D6A1E8DF566C117D02C", hash_generated_method = "9C9CABBCAF543BD0957AB4D38FB3561D")
    
private boolean isTextEditable() {
        return mText instanceof Editable && onCheckIsTextEditor() && isEnabled();
    }

    /**
     * Returns true, only while processing a touch gesture, if the initial
     * touch down event caused focus to move to the text view and as a result
     * its selection changed.  Only valid while processing the touch gesture
     * of interest.
     */
    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.609 -0500", hash_original_method = "319EEEA24E78F0A8A97E7B3282410D43", hash_generated_method = "FEFFEA66C7443F9A8E84F03A8F522EEA")
    
public boolean didTouchFocusSelect() {
        return mTouchFocusSelected;
    }
    
    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.612 -0500", hash_original_method = "F8EF60C67754333637E515F4BC0EB2C7", hash_generated_method = "E425EEBA981733980FD348E89130D36B")
    
@Override
    public void cancelLongPress() {
        super.cancelLongPress();
        mIgnoreActionUpEvent = true;
    }

    /**
     * This method is only valid during a touch event.
     *
     * @return true when the ACTION_UP event should be ignored, false otherwise.
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.614 -0500", hash_original_method = "1EBA305C38503D593DE5ED34528F31AE", hash_generated_method = "77CF7EB7B2C9119AFBC473FD491D531B")
    
public boolean shouldIgnoreActionUpEvent() {
        return mIgnoreActionUpEvent;
    }

    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.616 -0500", hash_original_method = "2ED59B8CED9712CD9EFEA3386ABFE955", hash_generated_method = "EACED8FFFC15C19C4E5F3C9693D97825")
    
@Override
    public boolean onTrackballEvent(MotionEvent event) {
        if (mMovement != null && mText instanceof Spannable &&
            mLayout != null) {
            if (mMovement.onTrackballEvent(this, (Spannable) mText, event)) {
                return true;
            }
        }

        return super.onTrackballEvent(event);
    }

    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.618 -0500", hash_original_method = "9E4C5FDADE7CEAD68CF365879A643A39", hash_generated_method = "2B46961BDA5B0E1B9AFAAEE3C94EF789")
    
public void setScroller(Scroller s) {
        mScroller = s;
    }

    /**
     * @return True when the TextView isFocused and has a valid zero-length selection (cursor).
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.637 -0500", hash_original_method = "D90D14C34AE2DD19EDEA4AA99DD580AF", hash_generated_method = "038933391836565386C21A60773DB5BF")
    
private boolean shouldBlink() {
        if (!isFocused()) return false;

        final int start = getSelectionStart();
        if (start < 0) return false;

        final int end = getSelectionEnd();
        if (end < 0) return false;

        return start == end;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.639 -0500", hash_original_method = "D1BDF909CEA832525561C896748DB631", hash_generated_method = "2459C64599C61B8E4F84700A53CFE0E9")
    
private void makeBlink() {
        if (isCursorVisible()) {
            if (shouldBlink()) {
                mShowCursor = SystemClock.uptimeMillis();
                if (mBlink == null) mBlink = new Blink(this);
                mBlink.removeCallbacks(mBlink);
                mBlink.postAtTime(mBlink, mShowCursor + BLINK);
            }
        } else {
            if (mBlink != null) mBlink.removeCallbacks(mBlink);
        }
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.643 -0500", hash_original_method = "2371CC9F994A54DD5E29CBD2552784AA", hash_generated_method = "0EB7E1E6CEC5C13C9DA13E65FF82AD72")
    
@Override
    protected float getLeftFadingEdgeStrength() {
        if (mCurrentAlpha <= ViewConfiguration.ALPHA_THRESHOLD_INT) return 0.0f;
        if (mEllipsize == TextUtils.TruncateAt.MARQUEE &&
                mMarqueeFadeMode != MARQUEE_FADE_SWITCH_SHOW_ELLIPSIS) {
            if (mMarquee != null && !mMarquee.isStopped()) {
                final Marquee marquee = mMarquee;
                if (marquee.shouldDrawLeftFade()) {
                    return marquee.mScroll / getHorizontalFadingEdgeLength();
                } else {
                    return 0.0f;
                }
            } else if (getLineCount() == 1) {
                final int layoutDirection = getResolvedLayoutDirection();
                final int absoluteGravity = Gravity.getAbsoluteGravity(mGravity, layoutDirection);
                switch (absoluteGravity & Gravity.HORIZONTAL_GRAVITY_MASK) {
                    case Gravity.LEFT:
                        return 0.0f;
                    case Gravity.RIGHT:
                        return (mLayout.getLineRight(0) - (mRight - mLeft) -
                                getCompoundPaddingLeft() - getCompoundPaddingRight() -
                                mLayout.getLineLeft(0)) / getHorizontalFadingEdgeLength();
                    case Gravity.CENTER_HORIZONTAL:
                        return 0.0f;
                }
            }
        }
        return super.getLeftFadingEdgeStrength();
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.646 -0500", hash_original_method = "7D05EA9E8579412E6DC4A8392EC7FDC2", hash_generated_method = "7BE323B0E966EB6654A907901522776F")
    
@Override
    protected float getRightFadingEdgeStrength() {
        if (mCurrentAlpha <= ViewConfiguration.ALPHA_THRESHOLD_INT) return 0.0f;
        if (mEllipsize == TextUtils.TruncateAt.MARQUEE &&
                mMarqueeFadeMode != MARQUEE_FADE_SWITCH_SHOW_ELLIPSIS) {
            if (mMarquee != null && !mMarquee.isStopped()) {
                final Marquee marquee = mMarquee;
                return (marquee.mMaxFadeScroll - marquee.mScroll) / getHorizontalFadingEdgeLength();
            } else if (getLineCount() == 1) {
                final int layoutDirection = getResolvedLayoutDirection();
                final int absoluteGravity = Gravity.getAbsoluteGravity(mGravity, layoutDirection);
                switch (absoluteGravity & Gravity.HORIZONTAL_GRAVITY_MASK) {
                    case Gravity.LEFT:
                        final int textWidth = (mRight - mLeft) - getCompoundPaddingLeft() -
                                getCompoundPaddingRight();
                        final float lineWidth = mLayout.getLineWidth(0);
                        return (lineWidth - textWidth) / getHorizontalFadingEdgeLength();
                    case Gravity.RIGHT:
                        return 0.0f;
                    case Gravity.CENTER_HORIZONTAL:
                    case Gravity.FILL_HORIZONTAL:
                        return (mLayout.getLineWidth(0) - ((mRight - mLeft) -
                                getCompoundPaddingLeft() - getCompoundPaddingRight())) /
                                getHorizontalFadingEdgeLength();
                }
            }
        }
        return super.getRightFadingEdgeStrength();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.648 -0500", hash_original_method = "A3B3BBCD8F5911495212C23A0CDB87AF", hash_generated_method = "54B87EB7FCCFD81D38B8755608D2BB43")
    
@Override
    protected int computeHorizontalScrollRange() {
        if (mLayout != null) {
            return mSingleLine && (mGravity & Gravity.HORIZONTAL_GRAVITY_MASK) == Gravity.LEFT ?
                    (int) mLayout.getLineWidth(0) : mLayout.getWidth();
        }

        return super.computeHorizontalScrollRange();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.651 -0500", hash_original_method = "FD0A725F27B0D409B10AFF4BD8232C49", hash_generated_method = "9147BE1DECDCB240E48F4395A4CC59B4")
    
@Override
    protected int computeVerticalScrollRange() {
        if (mLayout != null)
            return mLayout.getHeight();

        return super.computeVerticalScrollRange();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.653 -0500", hash_original_method = "9A16EAE7151454D3FA35454A6C3BB413", hash_generated_method = "4426FDB023A63D16EDBDFB6521FBAD04")
    
@Override
    protected int computeVerticalScrollExtent() {
        return getHeight() - getCompoundPaddingTop() - getCompoundPaddingBottom();
    }

    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.656 -0500", hash_original_method = "AF6DED1CDDAE4FEC9AD8DCCD50DF8C26", hash_generated_method = "970D396B311EFBCF05DD1FA84F01E312")
    
@Override
    public void findViewsWithText(ArrayList<View> outViews, CharSequence searched, int flags) {
        super.findViewsWithText(outViews, searched, flags);
        if (!outViews.contains(this) && (flags & FIND_VIEWS_WITH_TEXT) != 0
                && !TextUtils.isEmpty(searched) && !TextUtils.isEmpty(mText)) {
            String searchedLowerCase = searched.toString().toLowerCase();
            String textLowerCase = mText.toString().toLowerCase();
            if (textLowerCase.contains(searchedLowerCase)) {
                outViews.add(this);
            }
        }
    }

    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.665 -0500", hash_original_method = "9DEDF12E7A1F2B52484CF7C1E98D635C", hash_generated_method = "59ADE841833CF06541EA19591B134F16")
    
@Override
    public boolean onKeyShortcut(int keyCode, KeyEvent event) {
        final int filteredMetaState = event.getMetaState() & ~KeyEvent.META_CTRL_MASK;
        if (KeyEvent.metaStateHasNoModifiers(filteredMetaState)) {
            switch (keyCode) {
            case KeyEvent.KEYCODE_A:
                if (canSelectText()) {
                    return onTextContextMenuItem(ID_SELECT_ALL);
                }
                break;
            case KeyEvent.KEYCODE_X:
                if (canCut()) {
                    return onTextContextMenuItem(ID_CUT);
                }
                break;
            case KeyEvent.KEYCODE_C:
                if (canCopy()) {
                    return onTextContextMenuItem(ID_COPY);
                }
                break;
            case KeyEvent.KEYCODE_V:
                if (canPaste()) {
                    return onTextContextMenuItem(ID_PASTE);
                }
                break;
            }
        }
        return super.onKeyShortcut(keyCode, event);
    }

    /**
     * Unlike {@link #textCanBeSelected()}, this method is based on the <i>current</i> state of the
     * TextView. {@link #textCanBeSelected()} has to be true (this is one of the conditions to have
     * a selection controller (see {@link #prepareCursorControllers()}), but this is not sufficient.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.667 -0500", hash_original_method = "CD8FD18ADF4940449D6A099035EC8FE9", hash_generated_method = "7CE721685DB20C6327864F68BBE14707")
    
private boolean canSelectText() {
        return hasSelectionController() && mText.length() != 0;
    }

    /**
     * Test based on the <i>intrinsic</i> charateristics of the TextView.
     * The text must be spannable and the movement method must allow for arbitary selection.
     * 
     * See also {@link #canSelectText()}.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.669 -0500", hash_original_method = "09898B129565A0932D7F5D96EEC9BB39", hash_generated_method = "68825D4E189F4A8FF595703283A88D2C")
    
private boolean textCanBeSelected() {
        // prepareCursorController() relies on this method.
        // If you change this condition, make sure prepareCursorController is called anywhere
        // the value of this condition might be changed.
        if (mMovement == null || !mMovement.canSelectArbitrarily()) return false;
        return isTextEditable() || (mTextIsSelectable && mText instanceof Spannable && isEnabled());
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.672 -0500", hash_original_method = "5A8A75E52337470DA5834210CD94E844", hash_generated_method = "80397E825DF876D9CB4C7A9911AE8BA3")
    
private boolean canCut() {
        if (hasPasswordTransformationMethod()) {
            return false;
        }

        if (mText.length() > 0 && hasSelection() && mText instanceof Editable && mInput != null) {
            return true;
        }

        return false;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.674 -0500", hash_original_method = "C5BA619EC7C225A5F87BCD822F6EF570", hash_generated_method = "A6FEF249CF39D610A187F0248B7C937F")
    
private boolean canCopy() {
        if (hasPasswordTransformationMethod()) {
            return false;
        }

        if (mText.length() > 0 && hasSelection()) {
            return true;
        }

        return false;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.676 -0500", hash_original_method = "4C1E94F781705995B290C548A8DF616E", hash_generated_method = "B7CB266A63E857654DA054704C6EBED4")
    
private boolean canPaste() {
        return (mText instanceof Editable &&
                mInput != null &&
                getSelectionStart() >= 0 &&
                getSelectionEnd() >= 0 &&
                ((ClipboardManager)getContext().getSystemService(Context.CLIPBOARD_SERVICE)).
                hasPrimaryClip());
    }

    @DSComment("Private Method")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.685 -0500", hash_original_method = "493FC66F8A7ACF6A75CECBBBC666AB3C", hash_generated_method = "FAE51C80D3C22F72E9E45A371C71535D")
    
private boolean selectAll() {
        final int length = mText.length();
        Selection.setSelection((Spannable) mText, 0, length);
        return length > 0;
    }

    /**
     * Adjusts selection to the word under last touch offset.
     * Return true if the operation was successfully performed.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.690 -0500", hash_original_method = "B770D2F4FC63A979B3CD07A81B20384D", hash_generated_method = "40C015DAE440AB2F67B47A00DA2201B5")
    
private boolean selectCurrentWord() {
        if (!canSelectText()) {
            return false;
        }

        if (hasPasswordTransformationMethod()) {
            // Always select all on a password field.
            // Cut/copy menu entries are not available for passwords, but being able to select all
            // is however useful to delete or paste to replace the entire content.
            return selectAll();
        }

        int klass = mInputType & InputType.TYPE_MASK_CLASS;
        int variation = mInputType & InputType.TYPE_MASK_VARIATION;

        // Specific text field types: select the entire text for these
        if (klass == InputType.TYPE_CLASS_NUMBER ||
                klass == InputType.TYPE_CLASS_PHONE ||
                klass == InputType.TYPE_CLASS_DATETIME ||
                variation == InputType.TYPE_TEXT_VARIATION_URI ||
                variation == InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS ||
                variation == InputType.TYPE_TEXT_VARIATION_WEB_EMAIL_ADDRESS ||
                variation == InputType.TYPE_TEXT_VARIATION_FILTER) {
            return selectAll();
        }

        long lastTouchOffsets = getLastTouchOffsets();
        final int minOffset = extractRangeStartFromLong(lastTouchOffsets);
        final int maxOffset = extractRangeEndFromLong(lastTouchOffsets);

        // Safety check in case standard touch event handling has been bypassed
        if (minOffset < 0 || minOffset >= mText.length()) return false;
        if (maxOffset < 0 || maxOffset >= mText.length()) return false;

        int selectionStart, selectionEnd;

        // If a URLSpan (web address, email, phone...) is found at that position, select it.
        URLSpan[] urlSpans = ((Spanned) mText).getSpans(minOffset, maxOffset, URLSpan.class);
        if (urlSpans.length >= 1) {
            URLSpan urlSpan = urlSpans[0];
            selectionStart = ((Spanned) mText).getSpanStart(urlSpan);
            selectionEnd = ((Spanned) mText).getSpanEnd(urlSpan);
        } else {
            final WordIterator wordIterator = getWordIterator();
            wordIterator.setCharSequence(mText, minOffset, maxOffset);

            selectionStart = wordIterator.getBeginning(minOffset);
            if (selectionStart == BreakIterator.DONE) return false;

            selectionEnd = wordIterator.getEnd(maxOffset);
            if (selectionEnd == BreakIterator.DONE) return false;

            if (selectionStart == selectionEnd) {
                // Possible when the word iterator does not properly handle the text's language
                long range = getCharRange(selectionStart);
                selectionStart = extractRangeStartFromLong(range);
                selectionEnd = extractRangeEndFromLong(range);
            }
        }

        Selection.setSelection((Spannable) mText, selectionStart, selectionEnd);
        return selectionEnd > selectionStart;
    }

    /**
     * This is a temporary method. Future versions may support multi-locale text.
     *
     * @return The locale that should be used for a word iterator and a spell checker
     * in this TextView, based on the current spell checker settings,
     * the current IME's locale, or the system default locale.
     * @hide
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.692 -0500", hash_original_method = "9DCEB61D4BC0794F06560CB12151C0AA", hash_generated_method = "5A15492509F59DC4E40A957A59037443")
    
public Locale getTextServicesLocale() {
        Locale locale = Locale.getDefault();
        final TextServicesManager textServicesManager = (TextServicesManager)
                mContext.getSystemService(Context.TEXT_SERVICES_MANAGER_SERVICE);
        final SpellCheckerSubtype subtype = textServicesManager.getCurrentSpellCheckerSubtype(true);
        if (subtype != null) {
            locale = new Locale(subtype.getLocale());
        }
        return locale;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.694 -0500", hash_original_method = "84E4450A5BCA42ECDB6E0E833B2BF3C6", hash_generated_method = "D2363E1EE5411C67A76C7C3C5FDFC7A8")
    
void onLocaleChanged() {
        // Will be re-created on demand in getWordIterator with the proper new locale
        mWordIterator = null;
    }

    /**
     * @hide
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.696 -0500", hash_original_method = "D7DB0153FBA43371270FE2DB428D268F", hash_generated_method = "C83C8F49D6DFE55F7EED53D9F0380230")
    
public WordIterator getWordIterator() {
        if (mWordIterator == null) {
            mWordIterator = new WordIterator(getTextServicesLocale());
        }
        return mWordIterator;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.699 -0500", hash_original_method = "B4D83E103073E3F8ED3897EF06B95E07", hash_generated_method = "A8CA05192C8E7584768B1A7881922399")
    
private long getCharRange(int offset) {
        final int textLength = mText.length();
        if (offset + 1 < textLength) {
            final char currentChar = mText.charAt(offset);
            final char nextChar = mText.charAt(offset + 1);
            if (Character.isSurrogatePair(currentChar, nextChar)) {
                return packRangeInLong(offset,  offset + 2);
            }
        }
        if (offset < textLength) {
            return packRangeInLong(offset,  offset + 1);
        }
        if (offset - 2 >= 0) {
            final char previousChar = mText.charAt(offset - 1);
            final char previousPreviousChar = mText.charAt(offset - 2);
            if (Character.isSurrogatePair(previousPreviousChar, previousChar)) {
                return packRangeInLong(offset - 2,  offset);
            }
        }
        if (offset - 1 >= 0) {
            return packRangeInLong(offset - 1,  offset);
        }
        return packRangeInLong(offset,  offset);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.702 -0500", hash_original_method = "C07E078EE2A4D1805F6BF366C72ED78F", hash_generated_method = "DB5249F251332BC055351F5FA3E84BE8")
    
private long getLastTouchOffsets() {
        SelectionModifierCursorController selectionController = getSelectionController();
        final int minOffset = selectionController.getMinTouchOffset();
        final int maxOffset = selectionController.getMaxTouchOffset();
        return packRangeInLong(minOffset, maxOffset);
    }

    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.704 -0500", hash_original_method = "A81C1729DD6237516D7BACF34829C51D", hash_generated_method = "09CFB8D1E38B114C2248CEB82D9933BF")
    
@Override
    public void onPopulateAccessibilityEvent(AccessibilityEvent event) {
        super.onPopulateAccessibilityEvent(event);

        final boolean isPassword = hasPasswordTransformationMethod();
        if (!isPassword) {
            CharSequence text = getTextForAccessibility();
            if (!TextUtils.isEmpty(text)) {
                event.getText().add(text);
            }
        }
    }

    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.706 -0500", hash_original_method = "6FC069A7F29DA435C1F4CA8AC1DF9A7A", hash_generated_method = "02619EC3A186B04C795D3A0FAA455F52")
    
@Override
    public void onInitializeAccessibilityEvent(AccessibilityEvent event) {
        super.onInitializeAccessibilityEvent(event);

        final boolean isPassword = hasPasswordTransformationMethod();
        event.setPassword(isPassword);

        if (event.getEventType() == AccessibilityEvent.TYPE_VIEW_TEXT_SELECTION_CHANGED) {
            event.setFromIndex(Selection.getSelectionStart(mText));
            event.setToIndex(Selection.getSelectionEnd(mText));
            event.setItemCount(mText.length());
        }
    }

    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.709 -0500", hash_original_method = "305122B0EBB45F51524377B6AB6D9296", hash_generated_method = "DB7B63EE6053C441754C1433172526D6")
    
@Override
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        super.onInitializeAccessibilityNodeInfo(info);

        final boolean isPassword = hasPasswordTransformationMethod();
        if (!isPassword) {
            info.setText(getTextForAccessibility());
        }
        info.setPassword(isPassword);
    }

    @DSComment("IO movement methodName")
    @DSSpec(DSCat.IO_ACTION_METHOD)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.711 -0500", hash_original_method = "69E83CE4CD48DE4ECD21620922EFCC1A", hash_generated_method = "88A1CAE2B46ADFC63A0B34C8A7607E31")
    
@Override
    public void sendAccessibilityEvent(int eventType) {
        // Do not send scroll events since first they are not interesting for
        // accessibility and second such events a generated too frequently.
        // For details see the implementation of bringTextIntoView().
        if (eventType == AccessibilityEvent.TYPE_VIEW_SCROLLED) {
            return;
        }
        super.sendAccessibilityEvent(eventType);
    }

    /**
     * Gets the text reported for accessibility purposes. It is the
     * text if not empty or the hint.
     *
     * @return The accessibility text.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.713 -0500", hash_original_method = "8463B72D535FD98D84B93D99DA9D2B3A", hash_generated_method = "12AC6370544DEE1DB28AAC34FBAE43BD")
    
private CharSequence getTextForAccessibility() {
        CharSequence text = getText();
        if (TextUtils.isEmpty(text)) {
            text = getHint();
        }
        return text;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.716 -0500", hash_original_method = "77215EF020F664C77A4E0174E763346B", hash_generated_method = "77215EF020F664C77A4E0174E763346B")
    
void sendAccessibilityEventTypeViewTextChanged(CharSequence beforeText,
            int fromIndex, int removedCount, int addedCount) {
        AccessibilityEvent event =
            AccessibilityEvent.obtain(AccessibilityEvent.TYPE_VIEW_TEXT_CHANGED);
        event.setFromIndex(fromIndex);
        event.setRemovedCount(removedCount);
        event.setAddedCount(addedCount);
        event.setBeforeText(beforeText);
        sendAccessibilityEventUnchecked(event);
    }

    /**
     * Returns whether this text view is a current input method target.  The
     * default implementation just checks with {@link InputMethodManager}.
     */
    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.718 -0500", hash_original_method = "10EC795892359880AFC1661A7060F8D4", hash_generated_method = "CE548D9D4B6FE2D17CE97A1341C66F31")
    
public boolean isInputMethodTarget() {
        InputMethodManager imm = InputMethodManager.peekInstance();
        return imm != null && imm.isActive(this);
    }

    /**
     * Called when a context menu option for the text view is selected.  Currently
     * this will be one of {@link android.R.id#selectAll}, {@link android.R.id#cut},
     * {@link android.R.id#copy} or {@link android.R.id#paste}.
     *
     * @return true if the context menu item action was performed.
     */
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.731 -0500", hash_original_method = "395A8406E426F55316A0BF37153197E7", hash_generated_method = "383EBE9DFECDDCB1B3E175A0796637AD")
    
public boolean onTextContextMenuItem(int id) {
        int min = 0;
        int max = mText.length();

        if (isFocused()) {
            final int selStart = getSelectionStart();
            final int selEnd = getSelectionEnd();

            min = Math.max(0, Math.min(selStart, selEnd));
            max = Math.max(0, Math.max(selStart, selEnd));
        }

        switch (id) {
            case ID_SELECT_ALL:
                // This does not enter text selection mode. Text is highlighted, so that it can be
                // bulk edited, like selectAllOnFocus does. Returns true even if text is empty.
                selectAll();
                return true;

            case ID_PASTE:
                paste(min, max);
                return true;

            case ID_CUT:
                setPrimaryClip(ClipData.newPlainText(null, getTransformedText(min, max)));
                deleteText_internal(min, max);
                stopSelectionActionMode();
                return true;

            case ID_COPY:
                setPrimaryClip(ClipData.newPlainText(null, getTransformedText(min, max)));
                stopSelectionActionMode();
                return true;
        }
        return false;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.733 -0500", hash_original_method = "FE79E6B9FD3BC9A3AB2F6DF9CAFCD48E", hash_generated_method = "42F51A2B20C917A07CF6190FBE54DEAD")
    
private CharSequence getTransformedText(int start, int end) {
        return removeSuggestionSpans(mTransformed.subSequence(start, end));
    }

    /**
     * Prepare text so that there are not zero or two spaces at beginning and end of region defined
     * by [min, max] when replacing this region by paste.
     * Note that if there were two spaces (or more) at that position before, they are kept. We just
     * make sure we do not add an extra one from the paste content.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.736 -0500", hash_original_method = "6ABCBA1E552641094DE1B3327AD7FDD1", hash_generated_method = "8908DDB85E92E0857ED7F3E52CEE30B2")
    
private long prepareSpacesAroundPaste(int min, int max, CharSequence paste) {
        if (paste.length() > 0) {
            if (min > 0) {
                final char charBefore = mTransformed.charAt(min - 1);
                final char charAfter = paste.charAt(0);

                if (Character.isSpaceChar(charBefore) && Character.isSpaceChar(charAfter)) {
                    // Two spaces at beginning of paste: remove one
                    final int originalLength = mText.length();
                    deleteText_internal(min - 1, min);
                    // Due to filters, there is no guarantee that exactly one character was
                    // removed: count instead.
                    final int delta = mText.length() - originalLength;
                    min += delta;
                    max += delta;
                } else if (!Character.isSpaceChar(charBefore) && charBefore != '\n' &&
                        !Character.isSpaceChar(charAfter) && charAfter != '\n') {
                    // No space at beginning of paste: add one
                    final int originalLength = mText.length();
                    replaceText_internal(min, min, " ");
                    // Taking possible filters into account as above.
                    final int delta = mText.length() - originalLength;
                    min += delta;
                    max += delta;
                }
            }

            if (max < mText.length()) {
                final char charBefore = paste.charAt(paste.length() - 1);
                final char charAfter = mTransformed.charAt(max);

                if (Character.isSpaceChar(charBefore) && Character.isSpaceChar(charAfter)) {
                    // Two spaces at end of paste: remove one
                    deleteText_internal(max, max + 1);
                } else if (!Character.isSpaceChar(charBefore) && charBefore != '\n' &&
                        !Character.isSpaceChar(charAfter) && charAfter != '\n') {
                    // No space at end of paste: add one
                    replaceText_internal(max, max, " ");
                }
            }
        }

        return packRangeInLong(min, max);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.739 -0500", hash_original_method = "E0F0E7304052F47B24D850362D52309F", hash_generated_method = "1215B0B9337343FC00CC299AB58AAB22")
    
private DragShadowBuilder getTextThumbnailBuilder(CharSequence text) {
        TextView shadowView = (TextView) inflate(mContext,
                com.android.internal.R.layout.text_drag_thumbnail, null);

        if (shadowView == null) {
            throw new IllegalArgumentException("Unable to inflate text drag thumbnail");
        }

        if (text.length() > DRAG_SHADOW_MAX_TEXT_LENGTH) {
            text = text.subSequence(0, DRAG_SHADOW_MAX_TEXT_LENGTH);
        }
        shadowView.setText(text);
        shadowView.setTextColor(getTextColors());

        shadowView.setTextAppearance(mContext, R.styleable.Theme_textAppearanceLarge);
        shadowView.setGravity(Gravity.CENTER);

        shadowView.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));

        final int size = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        shadowView.measure(size, size);

        shadowView.layout(0, 0, shadowView.getMeasuredWidth(), shadowView.getMeasuredHeight());
        shadowView.invalidate();
        return new DragShadowBuilder(shadowView);
    }

    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.752 -0500", hash_original_method = "FE9E03D9F3FD52DB88C5DE28D1E8768B", hash_generated_method = "179F6734C366792F37BA87E074D46B41")
    
@Override
    public boolean performLongClick() {
        boolean handled = false;
        boolean vibrate = true;

        if (super.performLongClick()) {
            mDiscardNextActionUp = true;
            handled = true;
        }

        // Long press in empty space moves cursor and shows the Paste affordance if available.
        if (!handled && !isPositionOnText(mLastDownPositionX, mLastDownPositionY) &&
                mInsertionControllerEnabled) {
            final int offset = getOffsetForPosition(mLastDownPositionX, mLastDownPositionY);
            stopSelectionActionMode();
            Selection.setSelection((Spannable) mText, offset);
            getInsertionController().showWithActionPopup();
            handled = true;
            vibrate = false;
        }

        if (!handled && mSelectionActionMode != null) {
            if (touchPositionIsInSelection()) {
                // Start a drag
                final int start = getSelectionStart();
                final int end = getSelectionEnd();
                CharSequence selectedText = getTransformedText(start, end);
                ClipData data = ClipData.newPlainText(null, selectedText);
                DragLocalState localState = new DragLocalState(this, start, end);
                startDrag(data, getTextThumbnailBuilder(selectedText), localState, 0);
                stopSelectionActionMode();
            } else {
                getSelectionController().hide();
                selectCurrentWord();
                getSelectionController().show();
            }
            handled = true;
        }

        // Start a new selection
        if (!handled) {
            vibrate = handled = startSelectionActionMode();
        }

        if (vibrate) {
            performHapticFeedback(HapticFeedbackConstants.LONG_PRESS);
        }

        if (handled) {
            mDiscardNextActionUp = true;
        }

        return handled;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.754 -0500", hash_original_method = "227669F89CB3324004EC787BF93F591D", hash_generated_method = "1FF25EC623B2D574BE485E89C2096B1B")
    
private boolean touchPositionIsInSelection() {
        int selectionStart = getSelectionStart();
        int selectionEnd = getSelectionEnd();

        if (selectionStart == selectionEnd) {
            return false;
        }

        if (selectionStart > selectionEnd) {
            int tmp = selectionStart;
            selectionStart = selectionEnd;
            selectionEnd = tmp;
            Selection.setSelection((Spannable) mText, selectionStart, selectionEnd);
        }

        SelectionModifierCursorController selectionController = getSelectionController();
        int minOffset = selectionController.getMinTouchOffset();
        int maxOffset = selectionController.getMaxTouchOffset();

        return ((minOffset >= selectionStart) && (maxOffset < selectionEnd));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.756 -0500", hash_original_method = "A2BF41305999CD5C7E75DA3423749804", hash_generated_method = "5E201B649BDB3F3A02DA17E14A1F6480")
    
private PositionListener getPositionListener() {
        if (mPositionListener == null) {
            mPositionListener = new PositionListener();
        }
        return mPositionListener;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.799 -0500", hash_original_method = "23179C09AF51D00D4FCF53E6D8173595", hash_generated_method = "839273BACE588C5B3A25D83231A20918")
    
private boolean isPositionVisible(int positionX, int positionY) {
        synchronized (sTmpPosition) {
            final float[] position = sTmpPosition;
            position[0] = positionX;
            position[1] = positionY;
            View view = this;

            while (view != null) {
                if (view != this) {
                    // Local scroll is already taken into account in positionX/Y
                    position[0] -= view.getScrollX();
                    position[1] -= view.getScrollY();
                }

                if (position[0] < 0 || position[1] < 0 ||
                        position[0] > view.getWidth() || position[1] > view.getHeight()) {
                    return false;
                }

                if (!view.getMatrix().isIdentity()) {
                    view.getMatrix().mapPoints(position);
                }

                position[0] += view.getLeft();
                position[1] += view.getTop();

                final ViewParent parent = view.getParent();
                if (parent instanceof View) {
                    view = (View) parent;
                } else {
                    // We've reached the ViewRoot, stop iterating
                    view = null;
                }
            }
        }

        // We've been able to walk up the view hierarchy and the position was never clipped
        return true;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.801 -0500", hash_original_method = "51F76D7934106C8713E6D720A3BD9BE7", hash_generated_method = "C073A34991C3AC3CA641A6266E50494A")
    
private boolean isOffsetVisible(int offset) {
        final int line = mLayout.getLineForOffset(offset);
        final int lineBottom = mLayout.getLineBottom(line);
        final int primaryHorizontal = (int) mLayout.getPrimaryHorizontal(offset);
        return isPositionVisible(primaryHorizontal + viewportToContentHorizontalOffset(),
                lineBottom + viewportToContentVerticalOffset());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.804 -0500", hash_original_method = "8567BA4CA284138DD0CB4B48B9C8C278", hash_generated_method = "4A08428FEDDC404C8AC9C76B94B2B683")
    
@Override
    protected void onScrollChanged(int horiz, int vert, int oldHoriz, int oldVert) {
        super.onScrollChanged(horiz, vert, oldHoriz, oldVert);
        if (mPositionListener != null) {
            mPositionListener.onScrollChanged();
        }
    }

    /**
     * Removes the suggestion spans.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.968 -0500", hash_original_method = "9FAF02695A10AC660CF2B5DD3EDB7DD4", hash_generated_method = "9FAF02695A10AC660CF2B5DD3EDB7DD4")
    
CharSequence removeSuggestionSpans(CharSequence text) {
       if (text instanceof Spanned) {
           Spannable spannable;
           if (text instanceof Spannable) {
               spannable = (Spannable) text;
           } else {
               spannable = new SpannableString(text);
               text = spannable;
           }

           SuggestionSpan[] spans = spannable.getSpans(0, text.length(), SuggestionSpan.class);
           for (int i = 0; i < spans.length; i++) {
               spannable.removeSpan(spans[i]);
           }
       }
       return text;
    }

    static class Drawables {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.375 -0500", hash_original_field = "32F20D33EC64DE2D5D814E6A5C824218", hash_generated_field = "DE8F04160588686525A3D8B15BC2DFE8")

        final Rect mCompoundRect = new Rect();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.710 -0400", hash_original_field = "0C7DD96235E9F9762942299197287CDE", hash_generated_field = "EA47CEDDDC7FEEFF8968F16759D386B7")

        Drawable mDrawableTop;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.710 -0400", hash_original_field = "FFC9598591962399CC8E8DA93075B1FF", hash_generated_field = "95D5EBB5A7DB907B0D10BA6FCACBEB79")

        Drawable mDrawableBottom;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.710 -0400", hash_original_field = "449D3E5B49321EA02E52964E3AD5E600", hash_generated_field = "E0F354AEDF5B6392510E8BF8351EC72A")

        Drawable mDrawableLeft;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.710 -0400", hash_original_field = "E63FC6EB4CF70CF1E79E34F4802DD068", hash_generated_field = "DEB85B9558F1DB613F21ACF47C293916")

        Drawable mDrawableRight;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.710 -0400", hash_original_field = "89A4C538AC75F9C8F89ECA933AF96BAC", hash_generated_field = "B1620A6A345278DE80A9BA4900B11475")

        Drawable mDrawableStart;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.710 -0400", hash_original_field = "6A5FA7C04A36BE708BEA6972E6A10C46", hash_generated_field = "ACC539430A5F08E0F28AB3BE40D0952D")

        Drawable mDrawableEnd;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.710 -0400", hash_original_field = "7D9F9A3BD601360DABB13C24EDE31952", hash_generated_field = "11854D143E60E009B90CD1FF8A02DEE3")

        int mDrawableSizeTop;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.710 -0400", hash_original_field = "5EF68820BA8AD14D3920D191E438FBDF", hash_generated_field = "16E3A7AF686EC0516100ECED818E8EBA")

        int mDrawableSizeBottom;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.710 -0400", hash_original_field = "8DF66E67AC6A7270297B2C5293CA4A1E", hash_generated_field = "9140D35B31C4D61223B6173C166B3B31")

        int mDrawableSizeLeft;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.710 -0400", hash_original_field = "2BF66DDDC1E0C702D032E0065415C285", hash_generated_field = "D5565D3AC427749F2C0140A5168ACEC1")

        int mDrawableSizeRight;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.710 -0400", hash_original_field = "BC24A3002B0209BBAD6B5107B8C2EA00", hash_generated_field = "400EC481934DD8ABF5A430FF208AE483")

        int mDrawableSizeStart;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.710 -0400", hash_original_field = "7A0964DB19BD292930633D81D5FE202A", hash_generated_field = "FC1E40A21375A985A535463B1946D0C4")

        int mDrawableSizeEnd;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.710 -0400", hash_original_field = "D200C09B8E1D61364C5957FCD8230942", hash_generated_field = "F24DC8D9531D637A0AFC8D7ABA047F75")

        int mDrawableWidthTop;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.710 -0400", hash_original_field = "E5BC5ECE7466DFCB1D39A398C2C574A1", hash_generated_field = "3EE0808C0F345FDF9EFA159F089ADA7B")

        int mDrawableWidthBottom;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.710 -0400", hash_original_field = "875C159AC4F13BDACAA64D85FCF9101B", hash_generated_field = "F4D603ED5E02DAD268A97E78155D65C1")

        int mDrawableHeightLeft;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.710 -0400", hash_original_field = "D0C439D856EBC4A4B843E9FB48AFDB7F", hash_generated_field = "13D419316EC5090DDF8A1B991D8C5815")

        int mDrawableHeightRight;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.710 -0400", hash_original_field = "733346E69602A23B6E0712C7624F8348", hash_generated_field = "BEF3751E3F03DC5BEF12658362370AC3")

        int mDrawableHeightStart;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.710 -0400", hash_original_field = "E6A25620EDEE5CEC3B3C35B3F7640BFF", hash_generated_field = "6D5FC4CA6674578E6C48F812EBFBEB45")

        int mDrawableHeightEnd;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.384 -0500", hash_original_field = "4B293F8E3375C5C6A3B4DDED1666F169", hash_generated_field = "4B293F8E3375C5C6A3B4DDED1666F169")

        int mDrawablePadding;
        
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.710 -0400", hash_original_method = "8748E639EC70CC7FF4A65E9B42DA91C9", hash_generated_method = "8748E639EC70CC7FF4A65E9B42DA91C9")
        public Drawables ()
        {
            //Synthesized constructor
        }

    }

    static class InputContentType {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.412 -0500", hash_original_field = "6219A24954430291C20C014227F0E7AC", hash_generated_field = "6219A24954430291C20C014227F0E7AC")

        int imeOptions = EditorInfo.IME_NULL;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.414 -0500", hash_original_field = "E12E483301A64F5247F5B384AF8C5D04", hash_generated_field = "E12E483301A64F5247F5B384AF8C5D04")

        String privateImeOptions;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.416 -0500", hash_original_field = "0C07741C23A7BB415A826F63EBCB78E4", hash_generated_field = "0C07741C23A7BB415A826F63EBCB78E4")

        CharSequence imeActionLabel;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.418 -0500", hash_original_field = "8D9B82A785391392ECC49B1515360CFD", hash_generated_field = "8D9B82A785391392ECC49B1515360CFD")

        int imeActionId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.420 -0500", hash_original_field = "6F80A5414A80FF69E92A0BD3C0E073DC", hash_generated_field = "6F80A5414A80FF69E92A0BD3C0E073DC")

        Bundle extras;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.422 -0500", hash_original_field = "FBB987EFA3E5C389D064619D4166B06F", hash_generated_field = "FBB987EFA3E5C389D064619D4166B06F")

        OnEditorActionListener onEditorActionListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.424 -0500", hash_original_field = "94119079D0396AC6C04F22D47E6CD16C", hash_generated_field = "94119079D0396AC6C04F22D47E6CD16C")

        boolean enterDown;
        
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.711 -0400", hash_original_method = "B3EB62E33A235E4F2C0FA9694799B659", hash_generated_method = "B3EB62E33A235E4F2C0FA9694799B659")
        public InputContentType ()
        {
            //Synthesized constructor
        }

    }

    static class InputMethodState {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.432 -0500", hash_original_field = "09DEDD19F4EE15AD81232C03C2E1F622", hash_generated_field = "09DEDD19F4EE15AD81232C03C2E1F622")

        Rect mCursorRectInWindow = new Rect();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.434 -0500", hash_original_field = "C70C3A106639E4B88E9E717A37688D8A", hash_generated_field = "C70C3A106639E4B88E9E717A37688D8A")

        RectF mTmpRectF = new RectF();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.436 -0500", hash_original_field = "49A81A03C51B25D7E9A5C3BCA9AE957B", hash_generated_field = "49A81A03C51B25D7E9A5C3BCA9AE957B")

        float[] mTmpOffset = new float[2];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.437 -0500", hash_original_field = "FF9982DFAABD3C0DCD2EF1CD08CB60CF", hash_generated_field = "FF9982DFAABD3C0DCD2EF1CD08CB60CF")

        ExtractedTextRequest mExtracting;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.440 -0500", hash_original_field = "1FADD3620F542FA2687CB00E89D0BDDF", hash_generated_field = "63C64C7DC589F0F8C0F2D7EE456E6161")

        final ExtractedText mTmpExtracted = new ExtractedText();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.442 -0500", hash_original_field = "21001EAFF7A276FB78FCAA91CB53D94F", hash_generated_field = "21001EAFF7A276FB78FCAA91CB53D94F")

        int mBatchEditNesting;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.445 -0500", hash_original_field = "90AD8A78AE95138D386FCE8C5FEB694D", hash_generated_field = "90AD8A78AE95138D386FCE8C5FEB694D")

        boolean mCursorChanged;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.447 -0500", hash_original_field = "866086E9E33AFC2E676556369B9C50CF", hash_generated_field = "866086E9E33AFC2E676556369B9C50CF")

        boolean mSelectionModeChanged;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.449 -0500", hash_original_field = "9AAC9C08BF94B94F258CADEF618638FC", hash_generated_field = "9AAC9C08BF94B94F258CADEF618638FC")

        boolean mContentChanged;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.712 -0400", hash_original_field = "FA977B41050645C0B88E06966F709384", hash_generated_field = "4675A60A313C032BC0FE364A0DDA2ED7")

        int mChangedStart;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.712 -0400", hash_original_field = "9A4002C6FBE401B7B9714E151801E727", hash_generated_field = "8C7E0284E9593E9DE8C552E7CF188261")

        int mChangedEnd;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.712 -0400", hash_original_field = "625F12322D4384854704A8C6631D51D2", hash_generated_field = "D983CF835648B537298EC9705400AAB7")

        int mChangedDelta;
        
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.712 -0400", hash_original_method = "60FC2021DEC54591E7EA76E02BC73921", hash_generated_method = "60FC2021DEC54591E7EA76E02BC73921")
        public InputMethodState ()
        {
            //Synthesized constructor
        }

    }

    private static enum TextAlign {
        INHERIT, GRAVITY, TEXT_START, TEXT_END, CENTER, VIEW_START, VIEW_END;
    }

    public static class SavedState extends BaseSavedState {

        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.713 -0400", hash_original_field = "7DF6FB2587CB67E9544A859A8F6E8FF3", hash_generated_field = "3C65ED69ACC8B99E43F04B4C3721B494")

        @SuppressWarnings("hiding")
        public static final Parcelable.Creator<SavedState> CREATOR
        = new Parcelable.Creator<SavedState>() {
            @DSSafe(DSCat.SAFE_OTHERS)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.794 -0500", hash_original_method = "E26812089C072DDE1A14AECAA6CD6686", hash_generated_method = "C97AA17CB243756458D0FB7A2D786EA0")
            
public SavedState createFromParcel(Parcel in) {
                return new SavedState(in);
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.797 -0500", hash_original_method = "2D31E9CBAAAE05B696D738324F87FF78", hash_generated_method = "020465B62F970B98C266AF229149E391")
            
public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.775 -0500", hash_original_field = "4970E7F36D3C8378761D0E310C2396E8", hash_generated_field = "4970E7F36D3C8378761D0E310C2396E8")

        int selStart;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.777 -0500", hash_original_field = "E27E0ADA332B9C693E53A0FBE392C373", hash_generated_field = "E27E0ADA332B9C693E53A0FBE392C373")

        int selEnd;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.779 -0500", hash_original_field = "0F26345BF87C16C80BAC76779863E330", hash_generated_field = "0F26345BF87C16C80BAC76779863E330")

        CharSequence text;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.781 -0500", hash_original_field = "C49FE4AC5327729CC90ECD7A211AF40F", hash_generated_field = "C49FE4AC5327729CC90ECD7A211AF40F")

        boolean frozenWithFocus;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.784 -0500", hash_original_field = "BF3285010BEB822EC6EFACD0340B80BF", hash_generated_field = "BF3285010BEB822EC6EFACD0340B80BF")

        CharSequence error;

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.786 -0500", hash_original_method = "89EB4EC154F05BF905ECA8E02BBD14BC", hash_generated_method = "89EB4EC154F05BF905ECA8E02BBD14BC")
        
SavedState(Parcelable superState) {
            super(superState);
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.803 -0500", hash_original_method = "37D3E7AD53C42A47440A9F9D38DFF900", hash_generated_method = "AA03845A7646E4F49B7D98EFBF67C996")
        
private SavedState(Parcel in) {
            super(in);
            selStart = in.readInt();
            selEnd = in.readInt();
            frozenWithFocus = (in.readInt() != 0);
            text = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(in);

            if (in.readInt() != 0) {
                error = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(in);
            }
        }

        @DSSafe(DSCat.SAFE_LIST)
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.789 -0500", hash_original_method = "0917C7384BCC053D7DFEC5346FB5EF0D", hash_generated_method = "0B3837D9E0CF04BF562262CFBE4CBCAE")
        
@Override
        public void writeToParcel(Parcel out, int flags) {
            super.writeToParcel(out, flags);
            out.writeInt(selStart);
            out.writeInt(selEnd);
            out.writeInt(frozenWithFocus ? 1 : 0);
            TextUtils.writeToParcel(text, out, flags);

            if (error == null) {
                out.writeInt(0);
            } else {
                out.writeInt(1);
                TextUtils.writeToParcel(error, out, flags);
            }
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.791 -0500", hash_original_method = "B2667A033A504E8795AC5B896DD98B5F", hash_generated_method = "9F838FE70206FD2B0A698544466E56AD")
        
@Override
        public String toString() {
            String str = "TextView.SavedState{"
                    + Integer.toHexString(System.identityHashCode(this))
                    + " start=" + selStart + " end=" + selEnd;
            if (text != null) {
                str += " text=" + text;
            }
            return str + "}";
        }
    }

    private static class CharWrapper implements CharSequence, GetChars, GraphicsOperations {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.844 -0500", hash_original_field = "221D78AA948575C2C408290E651B0D1C", hash_generated_field = "20B8558AB5FD0F0B5A30B95221D68246")

        private char[] mChars;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.714 -0400", hash_original_field = "59B50EB80ABF1071654EE6DE5094E070", hash_generated_field = "D233E3389CE5D79EE6040D6A855ED4FF")

        private int mStart;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.714 -0400", hash_original_field = "429F431E8CD8AC287AA27460675EAEFE", hash_generated_field = "E9E17726F18BEC3E5C2C142D209555FD")

        private int mLength;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.849 -0500", hash_original_method = "91EFB0F7C01F6A5A0D8B3974D02E0951", hash_generated_method = "0208A9A19847098E5D37B25A71EE1F01")
        
public CharWrapper(char[] chars, int start, int len) {
            mChars = chars;
            mStart = start;
            mLength = len;
        }

        /* package */ @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.851 -0500", hash_original_method = "9DC2F69D47DD9984FB3378BE28468419", hash_generated_method = "9DC2F69D47DD9984FB3378BE28468419")
        
void set(char[] chars, int start, int len) {
            mChars = chars;
            mStart = start;
            mLength = len;
        }

        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.853 -0500", hash_original_method = "C0D624CC7CEFFAF650D54F4FB963FAF6", hash_generated_method = "8EA7C3FDBAE62B32653DE70AB5661C3A")
        
public int length() {
            return mLength;
        }

        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.855 -0500", hash_original_method = "02B707818F2669493B94939B301EE67F", hash_generated_method = "DAB18023A08BDE25422C64C18F46C777")
        
public char charAt(int off) {
            return mChars[off + mStart];
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.858 -0500", hash_original_method = "16BC7956BCD83D2479A5892A7E5C0E12", hash_generated_method = "68BD2714C01C6FC5CC9CE8FC44EE970C")
        
@Override
        public String toString() {
            return new String(mChars, mStart, mLength);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.860 -0500", hash_original_method = "BA853CED33F98EDEC6E428BC258874A3", hash_generated_method = "C002A332E18C3351F8B6966053E529D3")
        
public CharSequence subSequence(int start, int end) {
            if (start < 0 || end < 0 || start > mLength || end > mLength) {
                throw new IndexOutOfBoundsException(start + ", " + end);
            }

            return new String(mChars, start + mStart, end - start);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.863 -0500", hash_original_method = "BA41D2BD366E4073F3399B79828CDD69", hash_generated_method = "609302544D8F041B15C39C0E80CA5EA2")
        
public void getChars(int start, int end, char[] buf, int off) {
            if (start < 0 || end < 0 || start > mLength || end > mLength) {
                throw new IndexOutOfBoundsException(start + ", " + end);
            }

            System.arraycopy(mChars, start + mStart, buf, off, end - start);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.865 -0500", hash_original_method = "69B7B91382C25765CF25BB95E9C19951", hash_generated_method = "E80AFA26452321E81F270CD5EA967084")
        
public void drawText(Canvas c, int start, int end,
                             float x, float y, Paint p) {
            c.drawText(mChars, start + mStart, end - start, x, y, p);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.867 -0500", hash_original_method = "7645CF39D6B95BCD64DC33FB4F483F74", hash_generated_method = "606B0558971E2684F310627A301F3A6B")
        
public void drawTextRun(Canvas c, int start, int end,
                int contextStart, int contextEnd, float x, float y, int flags, Paint p) {
            int count = end - start;
            int contextCount = contextEnd - contextStart;
            c.drawTextRun(mChars, start + mStart, count, contextStart + mStart,
                    contextCount, x, y, flags, p);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.869 -0500", hash_original_method = "4FA2C1189F8B48AEDF7B10BEDFF84543", hash_generated_method = "A9D64B32EA63B302F8A8D568E5099672")
        
public float measureText(int start, int end, Paint p) {
            return p.measureText(mChars, start + mStart, end - start);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.871 -0500", hash_original_method = "E75F381DB76AB16AB72FA7895D0F4EE0", hash_generated_method = "65F6A7E674B7760E9E3FE94CEABACA5E")
        
public int getTextWidths(int start, int end, float[] widths, Paint p) {
            return p.getTextWidths(mChars, start + mStart, end - start, widths);
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.876 -0500", hash_original_method = "8AE304950D3C27A7D6E58BA388580EF8", hash_generated_method = "FE2955D9B1E8B9948C991A47B32E4EE1")
        
public float getTextRunAdvances(int start, int end, int contextStart,
                int contextEnd, int flags, float[] advances, int advancesIndex,
                Paint p) {
            int count = end - start;
            int contextCount = contextEnd - contextStart;
            return p.getTextRunAdvances(mChars, start + mStart, count,
                    contextStart + mStart, contextCount, flags, advances,
                    advancesIndex);
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.878 -0500", hash_original_method = "F8F49F104CF6E56864F062F013326F8E", hash_generated_method = "DD1556B4225F318A2ED9ECD69E6E0E0E")
        
public float getTextRunAdvances(int start, int end, int contextStart,
                int contextEnd, int flags, float[] advances, int advancesIndex,
                Paint p, int reserved) {
            int count = end - start;
            int contextCount = contextEnd - contextStart;
            return p.getTextRunAdvances(mChars, start + mStart, count,
                    contextStart + mStart, contextCount, flags, advances,
                    advancesIndex, reserved);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.880 -0500", hash_original_method = "BDCC8CC855D861C4246044B3842097FC", hash_generated_method = "A2BA67107C3C959BCEEE8F79E77DD772")
        
public int getTextRunCursor(int contextStart, int contextEnd, int flags,
                int offset, int cursorOpt, Paint p) {
            int contextCount = contextEnd - contextStart;
            return p.getTextRunCursor(mChars, contextStart + mStart,
                    contextCount, flags, offset + mStart, cursorOpt);
        }

    }

    private static class ErrorPopup extends PopupWindow {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.956 -0500", hash_original_field = "F6C3B021178F9F190BA6747803232645", hash_generated_field = "7E17DC26D2CD570CF106F239587AB53D")

        private boolean mAbove = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.958 -0500", hash_original_field = "FB06296B307A2944C1B9FA151DCD6108", hash_generated_field = "EC8812FBC96AED57B9AA8E9AC44D0DAB")

        private  TextView mView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.961 -0500", hash_original_field = "D79C6FD5FDC72C68D893E8638B37A6CF", hash_generated_field = "950EB5B59166D035BC490D5607F4FE92")

        private int mPopupInlineErrorBackgroundId = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.963 -0500", hash_original_field = "1D14F87C5E221EB56BD8F60BD4E299EA", hash_generated_field = "44679A20C762322AD033B0D96DF5B4A1")

        private int mPopupInlineErrorAboveBackgroundId = 0;

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.967 -0500", hash_original_method = "272870BAEDFD334116717C4E8AB7F4AA", hash_generated_method = "161E5141BF5556748F2F69FA1616977C")
        
ErrorPopup(TextView v, int width, int height) {
            super(v, width, height);
            mView = v;
            // Make sure the TextView has a background set as it will be used the first time it is
            // shown and positionned. Initialized with below background, which should have
            // dimensions identical to the above version for this to work (and is more likely).
            mPopupInlineErrorBackgroundId = getResourceId(mPopupInlineErrorBackgroundId,
                    com.android.internal.R.styleable.Theme_errorMessageBackground);
            mView.setBackgroundResource(mPopupInlineErrorBackgroundId);
        }

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.969 -0500", hash_original_method = "FF785E3F959B10F16CB73DE59942CDE6", hash_generated_method = "FF785E3F959B10F16CB73DE59942CDE6")
        
void fixDirection(boolean above) {
            mAbove = above;

            if (above) {
                mPopupInlineErrorAboveBackgroundId =
                    getResourceId(mPopupInlineErrorAboveBackgroundId,
                            com.android.internal.R.styleable.Theme_errorMessageAboveBackground);
            } else {
                mPopupInlineErrorBackgroundId = getResourceId(mPopupInlineErrorBackgroundId,
                        com.android.internal.R.styleable.Theme_errorMessageBackground);
            }

            mView.setBackgroundResource(above ? mPopupInlineErrorAboveBackgroundId :
                mPopupInlineErrorBackgroundId);
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.972 -0500", hash_original_method = "283134609ABCFB2A4CA7FFE3B421D4C1", hash_generated_method = "6436147C1F0964B47D33361ECC58782A")
        
private int getResourceId(int currentId, int index) {
            if (currentId == 0) {
                TypedArray styledAttributes = mView.getContext().obtainStyledAttributes(
                        R.styleable.Theme);
                currentId = styledAttributes.getResourceId(index, 0);
                styledAttributes.recycle();
            }
            return currentId;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:18.974 -0500", hash_original_method = "D12B38B9E303D838A7A28156EE92AFAA", hash_generated_method = "6B97F9D9AF29EBFA9808B0206DE1D9EE")
        
@Override
        public void update(int x, int y, int w, int h, boolean force) {
            super.update(x, y, w, h, force);

            boolean above = isAboveAnchor();
            if (above != mAbove) {
                fixDirection(above);
            }
        }

    }

    private class CorrectionHighlighter {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.160 -0500", hash_original_field = "B1A61C1647BF998788B652FB0B2A603B", hash_generated_field = "BE8E612E603608AA1A116A2C67EC5B99")

        private final static int FADE_OUT_DURATION = 400;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.151 -0500", hash_original_field = "9F8A427DBED06081C76DCB512FA4C1C6", hash_generated_field = "1C9B38C7F9B71799B7B8F281B135448B")

        private final Path mPath = new Path();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.153 -0500", hash_original_field = "09AA50A093F957BCED6646ACAF0E3BF9", hash_generated_field = "72C5AF717CADB3E1B93A20C1294BD3BC")

        private final Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.720 -0400", hash_original_field = "59B50EB80ABF1071654EE6DE5094E070", hash_generated_field = "D233E3389CE5D79EE6040D6A855ED4FF")

        private int mStart;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.720 -0400", hash_original_field = "C3B248BAD041692A85BAABC024E9FDCE", hash_generated_field = "EA295975CAF8E42F4C28A87EADB358DF")

        private int mEnd;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.158 -0500", hash_original_field = "F72F6DEA0627525FA57319286BB3DC27", hash_generated_field = "516150ABFF873AC5B12EBF2F659E6EFD")

        private long mFadingStartTime;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.163 -0500", hash_original_method = "76400340233C9D40D55E8C6995EBADF6", hash_generated_method = "C79B96E2CABF0D13CC4A9596B43F2592")
        
public CorrectionHighlighter() {
            mPaint.setCompatibilityScaling(getResources().getCompatibilityInfo().applicationScale);
            mPaint.setStyle(Paint.Style.FILL);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.165 -0500", hash_original_method = "9DA46F38DADC56BDE7EACA06EAFC15FB", hash_generated_method = "E8506D56690066BD366BBFC12E2AD841")
        
public void highlight(CorrectionInfo info) {
            mStart = info.getOffset();
            mEnd = mStart + info.getNewText().length();
            mFadingStartTime = SystemClock.uptimeMillis();

            if (mStart < 0 || mEnd < 0) {
                stopAnimation();
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.168 -0500", hash_original_method = "F315418B1425EA36D28AB47D63F906BC", hash_generated_method = "1C525F867DEEBC535F8E67265263C2CF")
        
public void draw(Canvas canvas, int cursorOffsetVertical) {
            if (updatePath() && updatePaint()) {
                if (cursorOffsetVertical != 0) {
                    canvas.translate(0, cursorOffsetVertical);
                }

                canvas.drawPath(mPath, mPaint);

                if (cursorOffsetVertical != 0) {
                    canvas.translate(0, -cursorOffsetVertical);
                }
                invalidate(true); // TODO invalidate cursor region only
            } else {
                stopAnimation();
                invalidate(false); // TODO invalidate cursor region only
            }
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.171 -0500", hash_original_method = "5CBDA1AAE290DD8920EE208B7E44B556", hash_generated_method = "ED26E3B636678C8EA25C1D141D6BF770")
        
private boolean updatePaint() {
            final long duration = SystemClock.uptimeMillis() - mFadingStartTime;
            if (duration > FADE_OUT_DURATION) return false;

            final float coef = 1.0f - (float) duration / FADE_OUT_DURATION;
            final int highlightColorAlpha = Color.alpha(mHighlightColor);
            final int color = (mHighlightColor & 0x00FFFFFF) +
                    ((int) (highlightColorAlpha * coef) << 24);
            mPaint.setColor(color);
            return true;
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.173 -0500", hash_original_method = "77DEEE2C70776896B8DA6C9B8DAC8452", hash_generated_method = "9D7947AEA6735189DFACD312F0E64921")
        
private boolean updatePath() {
            final Layout layout = TextView.this.mLayout;
            if (layout == null) return false;

            // Update in case text is edited while the animation is run
            final int length = mText.length();
            int start = Math.min(length, mStart);
            int end = Math.min(length, mEnd);

            mPath.reset();
            TextView.this.mLayout.getSelectionPath(start, end, mPath);
            return true;
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.176 -0500", hash_original_method = "E7B5FD6BE43D84566E63BFC892235B90", hash_generated_method = "2AA446935136818A54782F5561D3AF4F")
        
private void invalidate(boolean delayed) {
            if (TextView.this.mLayout == null) return;

            synchronized (sTempRect) {
                mPath.computeBounds(sTempRect, false);

                int left = getCompoundPaddingLeft();
                int top = getExtendedPaddingTop() + getVerticalOffset(true);

                if (delayed) {
                    TextView.this.postInvalidateDelayed(16, // 60 Hz update
                            left + (int) sTempRect.left, top + (int) sTempRect.top,
                            left + (int) sTempRect.right, top + (int) sTempRect.bottom);
                } else {
                    TextView.this.postInvalidate((int) sTempRect.left, (int) sTempRect.top,
                            (int) sTempRect.right, (int) sTempRect.bottom);
                }
            }
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.178 -0500", hash_original_method = "4BD6A36A746D13E089BD00A9CC0A6FB7", hash_generated_method = "31BD78226BC387E32403D41B5F1E3ABB")
        
private void stopAnimation() {
            TextView.this.mCorrectionHighlighter = null;
        }
    }

    private static final class Marquee extends Handler {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.321 -0500", hash_original_field = "39CC531B9DEBE7EA578FE594B69522AC", hash_generated_field = "8C251E17630B365D009996AD47B2DD3C")

        private static final float MARQUEE_DELTA_MAX = 0.07f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.324 -0500", hash_original_field = "3B536EC61A0D01698734C8EB22D9DB26", hash_generated_field = "35927BC6057D4173F3812056640AA204")

        private static final int MARQUEE_DELAY = 1200;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.326 -0500", hash_original_field = "5F4D43D95676E2A8E5743036800234CC", hash_generated_field = "A480DE8D7F8C3DD06D7F56FDCF1785D2")

        private static final int MARQUEE_RESTART_DELAY = 1200;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.329 -0500", hash_original_field = "A112DB925624E85FC8C63DEA0828FFB1", hash_generated_field = "FB93BB56AFDF6E4B8D61ECD57E059D47")

        private static final int MARQUEE_RESOLUTION = 1000 / 30;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.380 -0500", hash_original_field = "EA9C89E7A961FCB57552984EF904D99E", hash_generated_field = "B05A9FDC59FD134B7233CD4AFE4BE285")

        private static final int MARQUEE_PIXELS_PER_SECOND = 30;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.383 -0500", hash_original_field = "555CA13B66E0040A231166E103E42F33", hash_generated_field = "84F62194C3706C2DA47D02768AFB5267")

        private static final byte MARQUEE_STOPPED = 0x0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.385 -0500", hash_original_field = "C68391F853C4D098EB9A85A6D51DE01A", hash_generated_field = "BE8444FCF06CF4D0AF51FD248A85AAC9")

        private static final byte MARQUEE_STARTING = 0x1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.388 -0500", hash_original_field = "4C2BC44511F8CB41E36E220A7B43A101", hash_generated_field = "5524003C352475E0FE9851B8CCD129C6")

        private static final byte MARQUEE_RUNNING = 0x2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.390 -0500", hash_original_field = "A6B98DE92117DA5A2A24F1795A8B1CF4", hash_generated_field = "CB5FC73826DDCE47D2749061356148BA")

        private static final int MESSAGE_START = 0x1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.393 -0500", hash_original_field = "592F5628FB7739A9A82398DA0DE312EB", hash_generated_field = "FAB12A799FD1570304AC952DCE5A469B")

        private static final int MESSAGE_TICK = 0x2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.395 -0500", hash_original_field = "6A2AFFEA331ECBF4827C679A3DDEED09", hash_generated_field = "BB4587B4AB1E5F07B03C638733286E8C")

        private static final int MESSAGE_RESTART = 0x3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.397 -0500", hash_original_field = "B5464419D4BCD8469BA8BB32B36ACBD7", hash_generated_field = "378CC9BF8F5DA198EF400A97F72A70A3")

        private  WeakReference<TextView> mView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.399 -0500", hash_original_field = "7827AC930882937BC9D80405256DBB39", hash_generated_field = "E1F826A18833675CAA3F20EBBCB74E63")

        private byte mStatus = MARQUEE_STOPPED;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.403 -0500", hash_original_field = "BEFBE4BBFEA9B8A144FCC1A148621438", hash_generated_field = "F7B50A7445EB5AE7B4AED021C79A3798")

        private  float mScrollUnit;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.405 -0500", hash_original_field = "BBD33DBCED8E525F1DE41EC704DE3499", hash_generated_field = "01E3791EB1346C97E47507148C4BA197")

        private float mMaxScroll;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.407 -0500", hash_original_field = "60FE7DDBA197AB2FD49DEEDB9A0234B2", hash_generated_field = "60FE7DDBA197AB2FD49DEEDB9A0234B2")

        float mMaxFadeScroll;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.410 -0500", hash_original_field = "0AB7BEFA69C0FC5F8D977DE9B87BDFD6", hash_generated_field = "A1B75D52F4336D0AD351EB697147DDEE")

        private float mGhostStart;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.413 -0500", hash_original_field = "34A1FA809BA2BB5219D5F7C06351ED91", hash_generated_field = "F191C5ED756AC66F521DCB9604BE3690")

        private float mGhostOffset;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.416 -0500", hash_original_field = "1E8690A0B0D0D3E466AB34F37C3F085C", hash_generated_field = "64343518D38D9F055C2F10972107CF16")

        private float mFadeStop;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.419 -0500", hash_original_field = "6E57B3D17DAA3E96A142FDC859183BD1", hash_generated_field = "4382F6070B0A1518DE23E4DA7693EF55")

        private int mRepeatLimit;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.421 -0500", hash_original_field = "C7F848EDC5F556B007801A6A62728CC6", hash_generated_field = "C7F848EDC5F556B007801A6A62728CC6")

        float mScroll;

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.424 -0500", hash_original_method = "EC19D4EFFC7CC18F674B4C588B8FB87B", hash_generated_method = "EC19D4EFFC7CC18F674B4C588B8FB87B")
        
Marquee(TextView v) {
            final float density = v.getContext().getResources().getDisplayMetrics().density;
            mScrollUnit = (MARQUEE_PIXELS_PER_SECOND * density) / MARQUEE_RESOLUTION;
            mView = new WeakReference<TextView>(v);
        }

        @DSSafe(DSCat.IPC_CALLBACK)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.426 -0500", hash_original_method = "6484E5DEDF9A6D25913C9D3BAE668871", hash_generated_method = "606EB87738F44092C36959C06D6E86C4")
        
@Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case MESSAGE_START:
                    mStatus = MARQUEE_RUNNING;
                    tick();
                    break;
                case MESSAGE_TICK:
                    tick();
                    break;
                case MESSAGE_RESTART:
                    if (mStatus == MARQUEE_RUNNING) {
                        if (mRepeatLimit >= 0) {
                            mRepeatLimit--;
                        }
                        start(mRepeatLimit);
                    }
                    break;
            }
        }

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.429 -0500", hash_original_method = "EE95900433272316B4E2225B22ADF455", hash_generated_method = "EE95900433272316B4E2225B22ADF455")
        
void tick() {
            if (mStatus != MARQUEE_RUNNING) {
                return;
            }

            removeMessages(MESSAGE_TICK);

            final TextView textView = mView.get();
            if (textView != null && (textView.isFocused() || textView.isSelected())) {
                mScroll += mScrollUnit;
                if (mScroll > mMaxScroll) {
                    mScroll = mMaxScroll;
                    sendEmptyMessageDelayed(MESSAGE_RESTART, MARQUEE_RESTART_DELAY);
                } else {
                    sendEmptyMessageDelayed(MESSAGE_TICK, MARQUEE_RESOLUTION);
                }
                textView.invalidate();
            }
        }

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.432 -0500", hash_original_method = "559B799FFC0EAE80362A4924AC6B387F", hash_generated_method = "559B799FFC0EAE80362A4924AC6B387F")
        
void stop() {
            mStatus = MARQUEE_STOPPED;
            removeMessages(MESSAGE_START);
            removeMessages(MESSAGE_RESTART);
            removeMessages(MESSAGE_TICK);
            resetScroll();
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.434 -0500", hash_original_method = "E75276DE0DCFDFD0F42F697FF2F53A01", hash_generated_method = "8AB5466DE7E8AC40C65C8C4CF62E5722")
        
private void resetScroll() {
            mScroll = 0.0f;
            final TextView textView = mView.get();
            if (textView != null) textView.invalidate();
        }

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.437 -0500", hash_original_method = "C8CF1974A44593F9FA59199A16CE27AD", hash_generated_method = "C8CF1974A44593F9FA59199A16CE27AD")
        
void start(int repeatLimit) {
            if (repeatLimit == 0) {
                stop();
                return;
            }
            mRepeatLimit = repeatLimit;
            final TextView textView = mView.get();
            if (textView != null && textView.mLayout != null) {
                mStatus = MARQUEE_STARTING;
                mScroll = 0.0f;
                final int textWidth = textView.getWidth() - textView.getCompoundPaddingLeft() -
                        textView.getCompoundPaddingRight();
                final float lineWidth = textView.mLayout.getLineWidth(0);
                final float gap = textWidth / 3.0f;
                mGhostStart = lineWidth - textWidth + gap;
                mMaxScroll = mGhostStart + textWidth;
                mGhostOffset = lineWidth + gap;
                mFadeStop = lineWidth + textWidth / 6.0f;
                mMaxFadeScroll = mGhostStart + lineWidth + lineWidth;

                textView.invalidate();
                sendEmptyMessageDelayed(MESSAGE_START, MARQUEE_DELAY);
            }
        }

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.439 -0500", hash_original_method = "8BEDD434588E893B08521C1E5E937982", hash_generated_method = "8BEDD434588E893B08521C1E5E937982")
        
float getGhostOffset() {
            return mGhostOffset;
        }

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.441 -0500", hash_original_method = "FBB73F0BC2F425DEBE19335413BBBBD5", hash_generated_method = "FBB73F0BC2F425DEBE19335413BBBBD5")
        
boolean shouldDrawLeftFade() {
            return mScroll <= mFadeStop;
        }

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.443 -0500", hash_original_method = "297E21CB54951ECF2F6E26FAB2DC7036", hash_generated_method = "297E21CB54951ECF2F6E26FAB2DC7036")
        
boolean shouldDrawGhost() {
            return mStatus == MARQUEE_RUNNING && mScroll > mGhostStart;
        }

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.446 -0500", hash_original_method = "9069B9288EAB1BBCE4A11291BAF7E3F4", hash_generated_method = "9069B9288EAB1BBCE4A11291BAF7E3F4")
        
boolean isRunning() {
            return mStatus == MARQUEE_RUNNING;
        }

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.448 -0500", hash_original_method = "57F6027DED5DA77924B224C2BB22701E", hash_generated_method = "57F6027DED5DA77924B224C2BB22701E")
        
boolean isStopped() {
            return mStatus == MARQUEE_STOPPED;
        }
    }

    private class EasyEditSpanController {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.481 -0500", hash_original_field = "D76BD11D28EF5428EF127244C8260F42", hash_generated_field = "50759637C8B37D549CBDCF2AF0EA1F75")

        private static final int DISPLAY_TIMEOUT_MS = 3000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.483 -0500", hash_original_field = "A6D2E77A978F7620CD5EDAA297B4C685", hash_generated_field = "93AE44B2D9F293D0BC2408DE643B7037")

        private EasyEditPopupWindow mPopupWindow;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.485 -0500", hash_original_field = "C80216BF2E7D0C774832D807BD56DC02", hash_generated_field = "D79D9256BE9491F92C92FB8BCC6A61DC")

        private EasyEditSpan mEasyEditSpan;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.487 -0500", hash_original_field = "67DA9649A211AF9242A3873E1B372D0E", hash_generated_field = "EE65FA1568E5725BCA3859DE8F52F788")

        private Runnable mHidePopup;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.731 -0400", hash_original_method = "2E07A306089CEDB8C207DEEB8EF7B36E", hash_generated_method = "2E07A306089CEDB8C207DEEB8EF7B36E")
        public EasyEditSpanController ()
        {
            //Synthesized constructor
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.489 -0500", hash_original_method = "EDC90536D8A41E1495260C5D2B0A4CB4", hash_generated_method = "0ED34DB023548A4B3AB3884724B8C234")
        
private void hide() {
            if (mPopupWindow != null) {
                mPopupWindow.hide();
                TextView.this.removeCallbacks(mHidePopup);
            }
            removeSpans(mText);
            mEasyEditSpan = null;
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.732 -0400", hash_original_method = "400D6F397C7E694E5D2CC26E5076AFF1", hash_generated_method = "52F6789B7CBDBC1947ECA2B9D719D046")
        public void onTextChange(CharSequence buffer) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            adjustSpans(mText);
            if(getWindowVisibility() != View.VISIBLE)            
            {
                return;
            } //End block
            if(mLayout == null)            
            {
                return;
            } //End block
            InputMethodManager imm = InputMethodManager.peekInstance();
            if(!(TextView.this instanceof ExtractEditText)
                    && imm != null && imm.isFullscreenMode())            
            {
                return;
            } //End block
            if(mEasyEditSpan != null)            
            {
                if(mText instanceof Spannable)                
                {
                    ((Spannable) mText).removeSpan(mEasyEditSpan);
                } //End block
                mEasyEditSpan = null;
            } //End block
            if(mPopupWindow != null && mPopupWindow.isShowing())            
            {
                mPopupWindow.hide();
            } //End block
            if(buffer instanceof Spanned)            
            {
                mEasyEditSpan = getSpan((Spanned) buffer);
                if(mEasyEditSpan != null)                
                {
                    if(mPopupWindow == null)                    
                    {
                        mPopupWindow = new EasyEditPopupWindow();
                        mHidePopup = new Runnable() {
                            @DSSafe(DSCat.SAFE_LIST)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.494 -0500", hash_original_method = "21815FA27ABEB649DED6A46E4F97905B", hash_generated_method = "3B7C51A201D248C5C174CE9CC51C0ACD")
                            
@Override
                            public void run() {
                                hide();
                            }
                        };
                    } //End block
                    mPopupWindow.show(mEasyEditSpan);
                    TextView.this.removeCallbacks(mHidePopup);
                    TextView.this.postDelayed(mHidePopup, DISPLAY_TIMEOUT_MS);
                } //End block
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        /**
         * Adjusts the spans by removing all of them except the last one.
         */
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.499 -0500", hash_original_method = "BE935C64EC56548296E167AABD21FC2C", hash_generated_method = "618DCC454AEB480F6C087EA1F2C1CD36")
        
private void adjustSpans(CharSequence buffer) {
            // This method enforces that only one easy edit span is attached to the text.
            // A better way to enforce this would be to listen for onSpanAdded, but this method
            // cannot be used in this scenario as no notification is triggered when a text with
            // spans is inserted into a text.
            if (buffer instanceof Spannable) {
                Spannable spannable = (Spannable) buffer;
                EasyEditSpan[] spans = spannable.getSpans(0, spannable.length(),
                        EasyEditSpan.class);
                for (int i = 0; i < spans.length - 1; i++) {
                    spannable.removeSpan(spans[i]);
                }
            }
        }

        /**
         * Removes all the {@link EasyEditSpan} currently attached.
         */
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.502 -0500", hash_original_method = "D4568FCB8F606B40F32BB2FF24EF8AE2", hash_generated_method = "6B51F9E9AF7DBD9BCDCA3D934BF45AAC")
        
private void removeSpans(CharSequence buffer) {
            if (buffer instanceof Spannable) {
                Spannable spannable = (Spannable) buffer;
                EasyEditSpan[] spans = spannable.getSpans(0, spannable.length(),
                        EasyEditSpan.class);
                for (int i = 0; i < spans.length; i++) {
                    spannable.removeSpan(spans[i]);
                }
            }
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.505 -0500", hash_original_method = "FD0036F1377269974D72D9C2BC2EFAA3", hash_generated_method = "951D290164FBBE0C01655EA89E4D17F9")
        
private EasyEditSpan getSpan(Spanned spanned) {
            EasyEditSpan[] easyEditSpans = spanned.getSpans(0, spanned.length(),
                    EasyEditSpan.class);
            if (easyEditSpans.length == 0) {
                return null;
            } else {
                return easyEditSpans[0];
            }
        }
    }

    private class EasyEditPopupWindow extends PinnedPopupWindow implements OnClickListener {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.512 -0500", hash_original_field = "79C145E39484BF77945F7170B22F5DF9", hash_generated_field = "9556C9F4A76B40115A0F30878921C774")

        private static final int POPUP_TEXT_LAYOUT =
                com.android.internal.R.layout.text_edit_action_popup_text;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.514 -0500", hash_original_field = "06B2EE38AE7075BF016BD9BA232FF595", hash_generated_field = "4DBBAC6216F3AE0A070BCCEDE828B9C4")

        private TextView mDeleteTextView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.517 -0500", hash_original_field = "C80216BF2E7D0C774832D807BD56DC02", hash_generated_field = "D79D9256BE9491F92C92FB8BCC6A61DC")

        private EasyEditSpan mEasyEditSpan;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.733 -0400", hash_original_method = "8F35ACDDC3336F80EA4BC14F76358073", hash_generated_method = "8F35ACDDC3336F80EA4BC14F76358073")
        public EasyEditPopupWindow ()
        {
            //Synthesized constructor
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.519 -0500", hash_original_method = "57DC4A0271DC22A49F19ED5E582C7E72", hash_generated_method = "10852B4B1EFC13C1016C64016E2F47F2")
        
@Override
        protected void createPopupWindow() {
            mPopupWindow = new PopupWindow(TextView.this.mContext, null,
                    com.android.internal.R.attr.textSelectHandleWindowStyle);
            mPopupWindow.setInputMethodMode(PopupWindow.INPUT_METHOD_NOT_NEEDED);
            mPopupWindow.setClippingEnabled(true);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.522 -0500", hash_original_method = "128C0E079A8A50F8B38C36065ADCA0D3", hash_generated_method = "19EFD34804E56107D4416C508F081739")
        
@Override
        protected void initContentView() {
            LinearLayout linearLayout = new LinearLayout(TextView.this.getContext());
            linearLayout.setOrientation(LinearLayout.HORIZONTAL);
            mContentView = linearLayout;
            mContentView.setBackgroundResource(
                    com.android.internal.R.drawable.text_edit_side_paste_window);

            LayoutInflater inflater = (LayoutInflater)TextView.this.mContext.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            LayoutParams wrapContent = new LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

            mDeleteTextView = (TextView) inflater.inflate(POPUP_TEXT_LAYOUT, null);
            mDeleteTextView.setLayoutParams(wrapContent);
            mDeleteTextView.setText(com.android.internal.R.string.delete);
            mDeleteTextView.setOnClickListener(this);
            mContentView.addView(mDeleteTextView);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.525 -0500", hash_original_method = "EB30ECB06A4982701AF1B8E86934D288", hash_generated_method = "135CE12706895AAB541F46624DC79323")
        
public void show(EasyEditSpan easyEditSpan) {
            mEasyEditSpan = easyEditSpan;
            super.show();
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.527 -0500", hash_original_method = "C063208218D3B6E27F261A5578D5D2B9", hash_generated_method = "4CC057609709A9A0F381A0751CEA826C")
        
@Override
        public void onClick(View view) {
            if (view == mDeleteTextView) {
                Editable editable = (Editable) mText;
                int start = editable.getSpanStart(mEasyEditSpan);
                int end = editable.getSpanEnd(mEasyEditSpan);
                if (start >= 0 && end >= 0) {
                    deleteText_internal(start, end);
                }
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.529 -0500", hash_original_method = "7C1AF53FA575FE23CA1F61E7AC0FA9D9", hash_generated_method = "D7DD431E4F1C814F29F5E9D64AE3144B")
        
@Override
        protected int getTextOffset() {
            // Place the pop-up at the end of the span
            Editable editable = (Editable) mText;
            return editable.getSpanEnd(mEasyEditSpan);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.532 -0500", hash_original_method = "87FFA2F036D6FB2F317732DF596E05CB", hash_generated_method = "D3278FDA92F856377C960D088FDD884F")
        
@Override
        protected int getVerticalLocalPosition(int line) {
            return mLayout.getLineBottom(line);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.534 -0500", hash_original_method = "48C7510506F753F88F1EBACB4F114059", hash_generated_method = "799D206C26F22A4141BC52202F0EFC4B")
        
@Override
        protected int clipVertically(int positionY) {
            // As we display the pop-up below the span, no vertical clipping is required.
            return positionY;
        }
    }

    private class ChangeWatcher implements TextWatcher, SpanWatcher {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.540 -0500", hash_original_field = "6FED3330A012BA7D2A27B5EF6045F2F0", hash_generated_field = "9AF7D20EAE94D8E70217DF1DC0F4EBF6")

        private CharSequence mBeforeText;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.542 -0500", hash_original_field = "14EEEBF7A146EB10252B2CBBA34E05B5", hash_generated_field = "B09D56552589EA59BDE2FAB6B8B27882")

        private EasyEditSpanController mEasyEditSpanController;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.545 -0500", hash_original_method = "41973225A14E12423F2683848135C141", hash_generated_method = "D30CBE1D7FB4911CD46CDF3FCE2EBC45")
        
private ChangeWatcher() {
            mEasyEditSpanController = new EasyEditSpanController();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.547 -0500", hash_original_method = "720D371807084B06633282B0029EC53C", hash_generated_method = "B7B89C89650A6F21A55449912DC4BEDF")
        
public void beforeTextChanged(CharSequence buffer, int start,
                                      int before, int after) {
            if (DEBUG_EXTRACT) Log.v(LOG_TAG, "beforeTextChanged start=" + start
                    + " before=" + before + " after=" + after + ": " + buffer);

            if (AccessibilityManager.getInstance(mContext).isEnabled()
                    && !isPasswordInputType(mInputType)
                    && !hasPasswordTransformationMethod()) {
                mBeforeText = buffer.toString();
            }

            TextView.this.sendBeforeTextChanged(buffer, start, before, after);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.550 -0500", hash_original_method = "94F338CF670251E301395B1B01A5E75A", hash_generated_method = "7532C9CCEAB72821A2F3B423F4C0A03C")
        
public void onTextChanged(CharSequence buffer, int start,
                                  int before, int after) {
            if (DEBUG_EXTRACT) Log.v(LOG_TAG, "onTextChanged start=" + start
                    + " before=" + before + " after=" + after + ": " + buffer);
            TextView.this.handleTextChanged(buffer, start, before, after);

            mEasyEditSpanController.onTextChange(buffer);

            if (AccessibilityManager.getInstance(mContext).isEnabled() &&
                    (isFocused() || isSelected() && isShown())) {
                sendAccessibilityEventTypeViewTextChanged(mBeforeText, start, before, after);
                mBeforeText = null;
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.552 -0500", hash_original_method = "36BCFC0FC76553AA6F29D2F790EC381C", hash_generated_method = "9B0829B744F186BE242BF93D6C824468")
        
public void afterTextChanged(Editable buffer) {
            if (DEBUG_EXTRACT) Log.v(LOG_TAG, "afterTextChanged: " + buffer);
            TextView.this.sendAfterTextChanged(buffer);

            if (MetaKeyKeyListener.getMetaState(buffer, MetaKeyKeyListener.META_SELECTING) != 0) {
                MetaKeyKeyListener.stopSelecting(TextView.this, buffer);
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.556 -0500", hash_original_method = "6F9EDB470C5AD5F1E23596AFEC700ED3", hash_generated_method = "B7213E015864492B185444A183A616D2")
        
public void onSpanChanged(Spannable buf,
                                  Object what, int s, int e, int st, int en) {
            if (DEBUG_EXTRACT) Log.v(LOG_TAG, "onSpanChanged s=" + s + " e=" + e
                    + " st=" + st + " en=" + en + " what=" + what + ": " + buf);
            TextView.this.spanChange(buf, what, s, st, e, en);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.558 -0500", hash_original_method = "B2A75CCE31AAD63896365B7E450A433A", hash_generated_method = "3ED3EFFD0BB9911CA5C840810C179E6A")
        
public void onSpanAdded(Spannable buf, Object what, int s, int e) {
            if (DEBUG_EXTRACT) Log.v(LOG_TAG, "onSpanAdded s=" + s + " e=" + e
                    + " what=" + what + ": " + buf);
            TextView.this.spanChange(buf, what, -1, s, -1, e);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.560 -0500", hash_original_method = "11DC5396F5D4F6210F8F1D677B03B553", hash_generated_method = "D457D78BBECE35FFF866D40417A282DA")
        
public void onSpanRemoved(Spannable buf, Object what, int s, int e) {
            if (DEBUG_EXTRACT) Log.v(LOG_TAG, "onSpanRemoved s=" + s + " e=" + e
                    + " what=" + what + ": " + buf);
            TextView.this.spanChange(buf, what, s, -1, e, -1);
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.563 -0500", hash_original_method = "FB97DDA9E5EB9C645F7C42D5DCEE1A36", hash_generated_method = "C36C6DAF044EF014E984BC7849F16A1F")
        
private void hideControllers() {
            mEasyEditSpanController.hide();
        }

    }

    private static class Blink extends Handler implements Runnable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.621 -0500", hash_original_field = "B5464419D4BCD8469BA8BB32B36ACBD7", hash_generated_field = "378CC9BF8F5DA198EF400A97F72A70A3")

        private  WeakReference<TextView> mView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.623 -0500", hash_original_field = "CCCB3FDCAF75EA369C4CD3D5C8686C3D", hash_generated_field = "582F041564D3B399F48E8AE230C16FEE")

        private boolean mCancelled;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.626 -0500", hash_original_method = "B3B341EB4735766A8EE81E50FC9FCC5D", hash_generated_method = "DC4157FDEA2ECCBEC0CA630BDDB8B114")
        
public Blink(TextView v) {
            mView = new WeakReference<TextView>(v);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.629 -0500", hash_original_method = "ACD5284757446306F2E6E1BADED5158A", hash_generated_method = "1120A83631DE6622FBA3DFAE77AC004E")
        
public void run() {
            if (mCancelled) {
                return;
            }

            removeCallbacks(Blink.this);

            TextView tv = mView.get();

            if (tv != null && tv.shouldBlink()) {
                if (tv.mLayout != null) {
                    tv.invalidateCursorPath();
                }

                postAtTime(this, SystemClock.uptimeMillis() + BLINK);
            }
        }

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.631 -0500", hash_original_method = "A015A25EF128A9724656D77FE5A94B9E", hash_generated_method = "A015A25EF128A9724656D77FE5A94B9E")
        
void cancel() {
            if (!mCancelled) {
                removeCallbacks(Blink.this);
                mCancelled = true;
            }
        }

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.633 -0500", hash_original_method = "A06944554EAF73141DA4277B06D0E2BD", hash_generated_method = "A06944554EAF73141DA4277B06D0E2BD")
        
void uncancel() {
            mCancelled = false;
        }

    }

    public enum BufferType {
        NORMAL, SPANNABLE, EDITABLE,
    }

    private static class DragLocalState {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.742 -0500", hash_original_field = "4562764A5B0CCAA27F2422416C4208E7", hash_generated_field = "71C1F40F965BD09DE6D53C89B0AA9A2B")

        public TextView sourceTextView;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.738 -0400", hash_original_field = "EA2B2676C28C0DB26D39331A336C6B92", hash_generated_field = "D3D73C9CC2FDA0D0E8781D6E9A3253AA")

        public int start;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.738 -0400", hash_original_field = "7F021A1415B86F2D013B2618FB31AE53", hash_generated_field = "109F16BFAE7B1E88A50CE09673D176EC")

        public int end;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.747 -0500", hash_original_method = "78F248ABC93BE1F7C9E297B91A3F7D55", hash_generated_method = "6ADAB3ADF75FFC33E072564FF4380FF4")
        
public DragLocalState(TextView sourceTextView, int start, int end) {
            this.sourceTextView = sourceTextView;
            this.start = start;
            this.end = end;
        }

    }

    private class PositionListener implements ViewTreeObserver.OnPreDrawListener {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.761 -0500", hash_original_field = "59753C517C16DB508A57C6495439D660", hash_generated_field = "D5988F038F5611008A570FAFDE14074B")

        // 3 ActionPopup [replace, suggestion, easyedit] (suggestionsPopup first hides the others)
        private final int MAXIMUM_NUMBER_OF_LISTENERS = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.764 -0500", hash_original_field = "C095AD61AD3E55E9E3A951A1C2CD0337", hash_generated_field = "6E86BBFEE5AB32BEC4338815D88DA562")

        private TextViewPositionListener[] mPositionListeners =
                new TextViewPositionListener[MAXIMUM_NUMBER_OF_LISTENERS];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.767 -0500", hash_original_field = "B8B4999279E5823B1859AA5B19ABE2CD", hash_generated_field = "E1EB7F48AC3DAF5A3BC279FE32D5BD2C")

        private boolean mCanMove[] = new boolean[MAXIMUM_NUMBER_OF_LISTENERS];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.769 -0500", hash_original_field = "509C5DB407C2C48F887C9D58E2471A0C", hash_generated_field = "348E54253A3677FA237DAA94481A3907")

        private boolean mPositionHasChanged = true;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.739 -0400", hash_original_field = "E33EA5C4D485469D2432B3A781CD5014", hash_generated_field = "B562606C08FEFE4EA880E0BAFC4807BC")

        private int mPositionX;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.739 -0400", hash_original_field = "5EF2225F886100AA279B39F41428F3C5", hash_generated_field = "30733FB91B36B499B68F008F42192052")

        private int mPositionY;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.774 -0500", hash_original_field = "00213395D1AFABFFFCE37A0919C1B0B9", hash_generated_field = "3FFCBF0CA982B9F89F06AD1BE7BFADF1")

        private int mNumberOfListeners;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.776 -0500", hash_original_field = "DEE6D2C3A024242276D593168F789C75", hash_generated_field = "165D6DE2599A80133D2595B1A8A737DE")

        private boolean mScrollHasChanged;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.739 -0400", hash_original_method = "7156A70387EDCE5A8031F9E196BAE1E0", hash_generated_method = "7156A70387EDCE5A8031F9E196BAE1E0")
        public PositionListener ()
        {
            //Synthesized constructor
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.779 -0500", hash_original_method = "2CEF91B445974B7F0C1F2F2831D38171", hash_generated_method = "0DE4E54147CF9E196DEFA33F592E78BB")
        
public void addSubscriber(TextViewPositionListener positionListener, boolean canMove) {
            if (mNumberOfListeners == 0) {
                updatePosition();
                ViewTreeObserver vto = TextView.this.getViewTreeObserver();
                vto.addOnPreDrawListener(this);
            }

            int emptySlotIndex = -1;
            for (int i = 0; i < MAXIMUM_NUMBER_OF_LISTENERS; i++) {
                TextViewPositionListener listener = mPositionListeners[i];
                if (listener == positionListener) {
                    return;
                } else if (emptySlotIndex < 0 && listener == null) {
                    emptySlotIndex = i;
                }
            }

            mPositionListeners[emptySlotIndex] = positionListener;
            mCanMove[emptySlotIndex] = canMove;
            mNumberOfListeners++;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.781 -0500", hash_original_method = "F36C99880C8165921A7F03E512CBB647", hash_generated_method = "0F21ADF93B7E13541F7111133879BA4C")
        
public void removeSubscriber(TextViewPositionListener positionListener) {
            for (int i = 0; i < MAXIMUM_NUMBER_OF_LISTENERS; i++) {
                if (mPositionListeners[i] == positionListener) {
                    mPositionListeners[i] = null;
                    mNumberOfListeners--;
                    break;
                }
            }

            if (mNumberOfListeners == 0) {
                ViewTreeObserver vto = TextView.this.getViewTreeObserver();
                vto.removeOnPreDrawListener(this);
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.783 -0500", hash_original_method = "256A376A54FD4CD53D18A0F020A0467C", hash_generated_method = "130CF556F9ACD6B521B155391520B9B9")
        
public int getPositionX() {
            return mPositionX;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.785 -0500", hash_original_method = "4CCC26BBD5544F9405CBD90295EAF862", hash_generated_method = "9C8F818A61F89F376B38D544A51F62DC")
        
public int getPositionY() {
            return mPositionY;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.788 -0500", hash_original_method = "4634D6360837F07AB476144D9CD27591", hash_generated_method = "A1F26D3CCD2F0197DB4A6651B892D2F8")
        
@Override
        public boolean onPreDraw() {
            updatePosition();

            for (int i = 0; i < MAXIMUM_NUMBER_OF_LISTENERS; i++) {
                if (mPositionHasChanged || mScrollHasChanged || mCanMove[i]) {
                    TextViewPositionListener positionListener = mPositionListeners[i];
                    if (positionListener != null) {
                        positionListener.updatePosition(mPositionX, mPositionY,
                                mPositionHasChanged, mScrollHasChanged);
                    }
                }
            }

            mScrollHasChanged = false;
            return true;
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.791 -0500", hash_original_method = "65C89C768DE236BFCC52E144F22BF85B", hash_generated_method = "43B113CB3060064319A9D30E00C05B75")
        
private void updatePosition() {
            TextView.this.getLocationInWindow(mTempCoords);

            mPositionHasChanged = mTempCoords[0] != mPositionX || mTempCoords[1] != mPositionY;

            mPositionX = mTempCoords[0];
            mPositionY = mTempCoords[1];
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.793 -0500", hash_original_method = "45AFA571A6FC9FC84FC093F1FB86DABC", hash_generated_method = "82A1D24F4D46FFC618BBC29C767CFFF6")
        
public void onScrollChanged() {
            mScrollHasChanged = true;
        }

    }

    private abstract class PinnedPopupWindow implements TextViewPositionListener {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.807 -0500", hash_original_field = "7E7356C9B912251C74BC7963E9037246", hash_generated_field = "5CD7D447C671D86883FAE32274213485")

        protected PopupWindow mPopupWindow;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.809 -0500", hash_original_field = "740B4677BC7B62C194DEFD1D9555325C", hash_generated_field = "B572FFE44EB19A4D34C75C5D0C555606")

        protected ViewGroup mContentView;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.741 -0400", hash_original_field = "E33EA5C4D485469D2432B3A781CD5014", hash_generated_field = "2AF62DB1E3AEF057C912EFF081692BF4")

        int mPositionX;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.741 -0400", hash_original_field = "5EF2225F886100AA279B39F41428F3C5", hash_generated_field = "81023086806A696B7ADDE3F7B5299B8C")

        int mPositionY;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.825 -0500", hash_original_method = "596A5600AE60FE2F4CDE653E6E3819B3", hash_generated_method = "F885DDCA19CB2A05AD767F53595C321A")
        
public PinnedPopupWindow() {
            createPopupWindow();

            mPopupWindow.setWindowLayoutType(WindowManager.LayoutParams.TYPE_APPLICATION_SUB_PANEL);
            mPopupWindow.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
            mPopupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);

            initContentView();

            LayoutParams wrapContent = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
            mContentView.setLayoutParams(wrapContent);

            mPopupWindow.setContentView(mContentView);
        }

        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.813 -0500", hash_original_method = "93F1CCA3EA2AFCB682FEA383AAF84BC5", hash_generated_method = "871DDF9E1A5A13A727E73AD3D673A00D")
        
protected abstract void createPopupWindow();
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.816 -0500", hash_original_method = "12D5F5A3437071DB8456AC5188F4E6A8", hash_generated_method = "E89E866BFD41C186993321997275E04B")
        
protected abstract void initContentView();
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.818 -0500", hash_original_method = "DCC83C3654FF10DB085953B7387AB5A0", hash_generated_method = "F9086CD5472078D2DE1398AA89D06DF3")
        
protected abstract int getTextOffset();
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.821 -0500", hash_original_method = "06DC6AD2F94070B9AB930329FC3A82B5", hash_generated_method = "8AAB5ABF01AE48B6091DECC873053774")
        
protected abstract int getVerticalLocalPosition(int line);
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.823 -0500", hash_original_method = "F6BC4844BF8ED11AFAEBE03319D2C8A6", hash_generated_method = "09AADB20A10B309E4B335DCD3CD3E255")
        
protected abstract int clipVertically(int positionY);

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.828 -0500", hash_original_method = "6C3D8663E8D10274240ADCEB82AE9A86", hash_generated_method = "977F487586C192421560E5AB0BC824B6")
        
public void show() {
            TextView.this.getPositionListener().addSubscriber(this, false /* offset is fixed */);

            computeLocalPosition();

            final PositionListener positionListener = TextView.this.getPositionListener();
            updatePosition(positionListener.getPositionX(), positionListener.getPositionY());
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.830 -0500", hash_original_method = "AFC1F8ABC6317EB9C1F375A956F1E985", hash_generated_method = "905E1A3A34B6D47FFD9CA5E2015723FD")
        
protected void measureContent() {
            final DisplayMetrics displayMetrics = mContext.getResources().getDisplayMetrics();
            mContentView.measure(
                    View.MeasureSpec.makeMeasureSpec(displayMetrics.widthPixels,
                            View.MeasureSpec.AT_MOST),
                    View.MeasureSpec.makeMeasureSpec(displayMetrics.heightPixels,
                            View.MeasureSpec.AT_MOST));
        }

        /* The popup window will be horizontally centered on the getTextOffset() and vertically
         * positioned according to viewportToContentHorizontalOffset.
         * 
         * This method assumes that mContentView has properly been measured from its content. */
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.832 -0500", hash_original_method = "422A968B45C30695D0BEB603E4E72147", hash_generated_method = "1D9E1F7392F26C419431AB56FF0C5FDA")
        
private void computeLocalPosition() {
            measureContent();
            final int width = mContentView.getMeasuredWidth();
            final int offset = getTextOffset();
            mPositionX = (int) (mLayout.getPrimaryHorizontal(offset) - width / 2.0f);
            mPositionX += viewportToContentHorizontalOffset();

            final int line = mLayout.getLineForOffset(offset);
            mPositionY = getVerticalLocalPosition(line);
            mPositionY += viewportToContentVerticalOffset();
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.836 -0500", hash_original_method = "3C2767EB11AB639449E091DD5FC9CB2A", hash_generated_method = "9BF7768A9709A5CC9C16A820A59732AB")
        
private void updatePosition(int parentPositionX, int parentPositionY) {
            int positionX = parentPositionX + mPositionX;
            int positionY = parentPositionY + mPositionY;

            positionY = clipVertically(positionY);

            // Horizontal clipping
            final DisplayMetrics displayMetrics = mContext.getResources().getDisplayMetrics();
            final int width = mContentView.getMeasuredWidth();
            positionX = Math.min(displayMetrics.widthPixels - width, positionX);
            positionX = Math.max(0, positionX);

            if (isShowing()) {
                mPopupWindow.update(positionX, positionY, -1, -1);
            } else {
                mPopupWindow.showAtLocation(TextView.this, Gravity.NO_GRAVITY,
                        positionX, positionY);
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.838 -0500", hash_original_method = "9C51A5E6940629038A75840F54DCC577", hash_generated_method = "600FA4132B18BBA150640270461C2BA9")
        
public void hide() {
            mPopupWindow.dismiss();
            TextView.this.getPositionListener().removeSubscriber(this);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.841 -0500", hash_original_method = "48D3C5BA4737FA32BEEBA9E620F4B3A6", hash_generated_method = "63CD481E98CABBB822CCE664AF41B1DA")
        
@Override
        public void updatePosition(int parentPositionX, int parentPositionY,
                boolean parentPositionChanged, boolean parentScrolled) {
            // Either parentPositionChanged or parentScrolled is true, check if still visible
            if (isShowing() && isOffsetVisible(getTextOffset())) {
                if (parentScrolled) computeLocalPosition();
                updatePosition(parentPositionX, parentPositionY);
            } else {
                hide();
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.844 -0500", hash_original_method = "771871BA8F1191126AB0990E72BA0594", hash_generated_method = "DDD7FBE926D0B0B28759EBEFF70B4437")
        
public boolean isShowing() {
            return mPopupWindow.isShowing();
        }

    }

    private class SuggestionsPopupWindow extends PinnedPopupWindow implements OnItemClickListener {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.850 -0500", hash_original_field = "1AAFB2B71DB3DF193BFF5555C7DAC358", hash_generated_field = "D839A1C329DC1C2BA302C63069B302E8")

        private static final int MAX_NUMBER_SUGGESTIONS = SuggestionSpan.SUGGESTIONS_MAX_SIZE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.852 -0500", hash_original_field = "D6B106A4C7668506595B4139EEDB50F9", hash_generated_field = "60496CAB9AB07AE99F349E1717F7224D")

        private static final int ADD_TO_DICTIONARY = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.855 -0500", hash_original_field = "3D2079E13C4387E5623EA433F73DE191", hash_generated_field = "992995ADFDA4143135C9B34605503287")

        private static final int DELETE_TEXT = -2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.857 -0500", hash_original_field = "37FF1C98D290C653E38C8AD77E5F13E2", hash_generated_field = "DF9B2B2A32C54D35B3228EF58FDC6E78")

        private SuggestionInfo[] mSuggestionInfos;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.859 -0500", hash_original_field = "D8B80D0A7917D72837B4BB744FBB7D5B", hash_generated_field = "596DE3763E763BE0F497615E1944F22C")

        private int mNumberOfSuggestions;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.861 -0500", hash_original_field = "3C71686ED1CB01B644E6670401060C58", hash_generated_field = "7F93C534F2DFE71AE91870F5785F473D")

        private boolean mCursorWasVisibleBeforeSuggestions;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.864 -0500", hash_original_field = "1582640AF865FCC58F23ADF5958867BF", hash_generated_field = "641DA69AA28F49EC5C5A62A58B67E06A")

        private boolean mIsShowingUp = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.866 -0500", hash_original_field = "3BBAA2339730CCFFD0B503DBA852A577", hash_generated_field = "EC7957C4E8F88AF8C25BE753B9E15A66")

        private SuggestionAdapter mSuggestionsAdapter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.868 -0500", hash_original_field = "5788C59CE52CE3E5A956E0CC8E6F5B2B", hash_generated_field = "B69BA7FB6136A02593E4286BE8CED5FC")

        private  Comparator<SuggestionSpan> mSuggestionSpanComparator;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.871 -0500", hash_original_field = "F4D1CBF7C93918937D87F0B46012E853", hash_generated_field = "D0B23D9D75631218A54DFB41905818F7")

        private  HashMap<SuggestionSpan, Integer> mSpansLengths;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.881 -0500", hash_original_method = "296BEE5065EB2EF8F82574E0F3647EF2", hash_generated_method = "1134B525AEF72B5D2F13E77A2ADF1C5A")
        
public SuggestionsPopupWindow() {
            mCursorWasVisibleBeforeSuggestions = mCursorVisible;
            mSuggestionSpanComparator = new SuggestionSpanComparator();
            mSpansLengths = new HashMap<SuggestionSpan, Integer>();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.884 -0500", hash_original_method = "2C5A34402E22C878AD33972323D3ACC4", hash_generated_method = "38470A1B80FDB9B2BA08FEA35039E41F")
        
@Override
        protected void createPopupWindow() {
            mPopupWindow = new CustomPopupWindow(TextView.this.mContext,
                com.android.internal.R.attr.textSuggestionsWindowStyle);
            mPopupWindow.setInputMethodMode(PopupWindow.INPUT_METHOD_NOT_NEEDED);
            mPopupWindow.setFocusable(true);
            mPopupWindow.setClippingEnabled(false);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.887 -0500", hash_original_method = "E003230CE90A2ACB93D34E336B67EF46", hash_generated_method = "A9AE7CF5898273EEF5BD2628C960C9A0")
        
@Override
        protected void initContentView() {
            ListView listView = new ListView(TextView.this.getContext());
            mSuggestionsAdapter = new SuggestionAdapter();
            listView.setAdapter(mSuggestionsAdapter);
            listView.setOnItemClickListener(this);
            mContentView = listView;

            // Inflate the suggestion items once and for all. + 2 for add to dictionary and delete
            mSuggestionInfos = new SuggestionInfo[MAX_NUMBER_SUGGESTIONS + 2];
            for (int i = 0; i < mSuggestionInfos.length; i++) {
                mSuggestionInfos[i] = new SuggestionInfo();
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.889 -0500", hash_original_method = "4C7853BA5C99567CAD84815F4452E5F9", hash_generated_method = "E9CE60615E86C119B4C33C8A4CD08121")
        
public boolean isShowingUp() {
            return mIsShowingUp;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.891 -0500", hash_original_method = "3914DCDC5DB3E14D1A1A163B7497EFBA", hash_generated_method = "F64183CEC51AA68F2920498606F8BF99")
        
public void onParentLostFocus() {
            mIsShowingUp = false;
        }

        /**
         * Returns the suggestion spans that cover the current cursor position. The suggestion
         * spans are sorted according to the length of text that they are attached to.
         */
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.930 -0500", hash_original_method = "A21D81008594D05973BC33E2948715E2", hash_generated_method = "77B17286E467E85E40AD54A373A374D7")
        
private SuggestionSpan[] getSuggestionSpans() {
            int pos = TextView.this.getSelectionStart();
            Spannable spannable = (Spannable) TextView.this.mText;
            SuggestionSpan[] suggestionSpans = spannable.getSpans(pos, pos, SuggestionSpan.class);

            mSpansLengths.clear();
            for (SuggestionSpan suggestionSpan : suggestionSpans) {
                int start = spannable.getSpanStart(suggestionSpan);
                int end = spannable.getSpanEnd(suggestionSpan);
                mSpansLengths.put(suggestionSpan, Integer.valueOf(end - start));
            }

            // The suggestions are sorted according to their types (easy correction first, then
            // misspelled) and to the length of the text that they cover (shorter first).
            Arrays.sort(suggestionSpans, mSuggestionSpanComparator);
            return suggestionSpans;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.933 -0500", hash_original_method = "C166DC70ACC1835B92197E48CEB369FC", hash_generated_method = "0765B3ED2700E49D9041CEE4F84BDBF1")
        
@Override
        public void show() {
            if (!(mText instanceof Editable)) return;

            // updateSuggestions();
            mCursorWasVisibleBeforeSuggestions = mCursorVisible;
            setCursorVisible(false);
            mIsShowingUp = true;
            super.show();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.937 -0500", hash_original_method = "8DDB7ED8B40AC8DC3D4FF9060DA06A2E", hash_generated_method = "13C7C36DEA14F5322F0E7EDE4934772C")
        
@Override
        protected void measureContent() {
            final DisplayMetrics displayMetrics = mContext.getResources().getDisplayMetrics();
            final int horizontalMeasure = View.MeasureSpec.makeMeasureSpec(
                    displayMetrics.widthPixels, View.MeasureSpec.AT_MOST);
            final int verticalMeasure = View.MeasureSpec.makeMeasureSpec(
                    displayMetrics.heightPixels, View.MeasureSpec.AT_MOST);
            
            int width = 0;
            View view = null;
            for (int i = 0; i < mNumberOfSuggestions; i++) {
                view = mSuggestionsAdapter.getView(i, view, mContentView);
                view.getLayoutParams().width = LayoutParams.WRAP_CONTENT;
                view.measure(horizontalMeasure, verticalMeasure);
                width = Math.max(width, view.getMeasuredWidth());
            }

            // Enforce the width based on actual text widths
            mContentView.measure(
                    View.MeasureSpec.makeMeasureSpec(width, View.MeasureSpec.EXACTLY),
                    verticalMeasure);

            Drawable popupBackground = mPopupWindow.getBackground();
            if (popupBackground != null) {
                if (mTempRect == null) mTempRect = new Rect();
                popupBackground.getPadding(mTempRect);
                width += mTempRect.left + mTempRect.right;
            }
            mPopupWindow.setWidth(width);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.939 -0500", hash_original_method = "6820F3398D40FE1AF57F321A0934E9B8", hash_generated_method = "F920960D9B99AE4B9BBFCE7EC14277D3")
        
@Override
        protected int getTextOffset() {
            return getSelectionStart();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.941 -0500", hash_original_method = "87FFA2F036D6FB2F317732DF596E05CB", hash_generated_method = "D3278FDA92F856377C960D088FDD884F")
        
@Override
        protected int getVerticalLocalPosition(int line) {
            return mLayout.getLineBottom(line);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.944 -0500", hash_original_method = "BF4D66DCAEE7C7EAD97F70105958840C", hash_generated_method = "E6A869820BA044F291AF375C0430534E")
        
@Override
        protected int clipVertically(int positionY) {
            final int height = mContentView.getMeasuredHeight();
            final DisplayMetrics displayMetrics = mContext.getResources().getDisplayMetrics();
            return Math.min(positionY, displayMetrics.heightPixels - height);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.946 -0500", hash_original_method = "7609E0B22D3FA397AAE3B56DEE3F8C83", hash_generated_method = "5EAC133888E84C81B88CAE2B4A362701")
        
@Override
        public void hide() {
            super.hide();
        }

        private class CustomPopupWindow extends PopupWindow {
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.874 -0500", hash_original_method = "76E50B1843F1484B0424D837A17373EE", hash_generated_method = "F2D670E339A53BD958770C273722BAC3")
            
public CustomPopupWindow(Context context, int defStyle) {
                super(context, null, defStyle);
            }
            
            @DSSafe(DSCat.SAFE_LIST)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.758 -0400", hash_original_method = "3CF42E745499FBF7012823B6BEAA6E8B", hash_generated_method = "C8CBE2AFBCB4FE72843F29026D4AB90D")
            @Override
            public void dismiss() {
                super.dismiss();
                TextView.this.getPositionListener().removeSubscriber(SuggestionsPopupWindow.this);
                //((Spannable) mText).removeSpan(mSuggestionRangeSpan);
                setCursorVisible(mCursorWasVisibleBeforeSuggestions);
                if(hasInsertionController())                
                {
                    getInsertionController().show();
                } //End block
                // ---------- Original Method ----------
                //super.dismiss();
                //TextView.this.getPositionListener().removeSubscriber(SuggestionsPopupWindow.this);
                //((Spannable) mText).removeSpan(mSuggestionRangeSpan);
                //setCursorVisible(mCursorWasVisibleBeforeSuggestions);
                //if (hasInsertionController()) {
                //getInsertionController().show(); 
                //}
            }

        }

        private class SuggestionInfo {
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.758 -0400", hash_original_field = "E0CCBC7742EB01E23FE8CAC0823856EC", hash_generated_field = "872480635E7B6A6F7A5C26A47649A56F")

            int suggestionStart;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.758 -0400", hash_original_field = "6BA3CAF30490DD7C10C1C1903B7C4EE6", hash_generated_field = "AC9E6ECED58FB8EF180833836DBCAA2D")

            int suggestionEnd;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.896 -0500", hash_original_field = "46D75F50466858EB51EAFAE8BB212D75", hash_generated_field = "46D75F50466858EB51EAFAE8BB212D75")

            SuggestionSpan suggestionSpan;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.899 -0500", hash_original_field = "E2038F479A232C008DEC2C58888E09AF", hash_generated_field = "E2038F479A232C008DEC2C58888E09AF")

            int suggestionIndex;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.901 -0500", hash_original_field = "59937CFD4951C01B73A6EF4F5C4D841A", hash_generated_field = "59937CFD4951C01B73A6EF4F5C4D841A")

            SpannableStringBuilder text = new SpannableStringBuilder();
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.758 -0400", hash_original_field = "4EE2EC84135A501AB5CC573E44247990", hash_generated_field = "18031134C63E234D2C3372B21DDAF396")

            TextAppearanceSpan highlightSpan = new TextAppearanceSpan(mContext,
                com.android.internal.R.style.TextAppearance_SuggestionHighlight);
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.758 -0400", hash_original_method = "613563FC71224468A61688B0DDA11E74", hash_generated_method = "613563FC71224468A61688B0DDA11E74")
            public SuggestionInfo ()
            {
                //Synthesized constructor
            }

        }

        private class SuggestionAdapter extends BaseAdapter {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.908 -0500", hash_original_field = "4E09E9924623D83FCCD84E10CD956F7A", hash_generated_field = "0B998218A375E40727D240F37441CBEB")

            private LayoutInflater mInflater = (LayoutInflater) TextView.this.mContext.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.758 -0400", hash_original_method = "56675D9229C135A53AD81FE91AEF2A02", hash_generated_method = "56675D9229C135A53AD81FE91AEF2A02")
            public SuggestionAdapter ()
            {
                //Synthesized constructor
            }

            @DSSource({DSSourceKind.DATABASE})
            @DSSafe(DSCat.SAFE_LIST)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.911 -0500", hash_original_method = "02B536C5901CCC3DE9A3084712F44E45", hash_generated_method = "1655477EC64B6013C786FCC7D7D72FC9")
            
@Override
            public int getCount() {
                return mNumberOfSuggestions;
            }

            @DSSource({DSSourceKind.DATABASE_INFORMATION})
            @DSSafe(DSCat.SAFE_LIST)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.914 -0500", hash_original_method = "AB9B090A0CFC1C7403BFB1F3A94BDE2B", hash_generated_method = "CC534956B1360142C79C8647A2F4F1B9")
            
@Override
            public Object getItem(int position) {
                return mSuggestionInfos[position];
            }

            @DSSource({DSSourceKind.DATABASE})
            @DSSafe(DSCat.SAFE_LIST)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.916 -0500", hash_original_method = "7144EF990F660E75AA61001CF21A1CD5", hash_generated_method = "82702E9A3501EE6841B2C5A334199C16")
            
@Override
            public long getItemId(int position) {
                return position;
            }

            @DSSafe(DSCat.SAFE_LIST)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.919 -0500", hash_original_method = "EB7381461F4FDD3A1934D144B2D8DE50", hash_generated_method = "2AF2AC9ABAEAF87EAFC6DE0E58B9E561")
            
@Override
            public View getView(int position, View convertView, ViewGroup parent) {
                TextView textView = (TextView) convertView;

                if (textView == null) {
                    textView = (TextView) mInflater.inflate(mTextEditSuggestionItemLayout, parent,
                            false);
                }

                final SuggestionInfo suggestionInfo = mSuggestionInfos[position];
                textView.setText(suggestionInfo.text);

                if (suggestionInfo.suggestionIndex == ADD_TO_DICTIONARY) {
                    textView.setCompoundDrawablesWithIntrinsicBounds(
                            com.android.internal.R.drawable.ic_suggestions_add, 0, 0, 0);
                } else if (suggestionInfo.suggestionIndex == DELETE_TEXT) {
                    textView.setCompoundDrawablesWithIntrinsicBounds(
                            com.android.internal.R.drawable.ic_suggestions_delete, 0, 0, 0);
                } else {
                    textView.setCompoundDrawables(null, null, null, null);
                }

                return textView;
            }

        }

        private class SuggestionSpanComparator implements Comparator<SuggestionSpan> {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.759 -0400", hash_original_method = "22EA00C20DD1AAEDCB1186FBD85A1C5E", hash_generated_method = "22EA00C20DD1AAEDCB1186FBD85A1C5E")
            public SuggestionSpanComparator ()
            {
                //Synthesized constructor
            }
            @DSSafe(DSCat.SAFE_LIST)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.925 -0500", hash_original_method = "D4A09F0FD84AABB3F69B7BD15CCD92DF", hash_generated_method = "2F068B0BFE431952F7EBF091DFEBD6F1")
            
public int compare(SuggestionSpan span1, SuggestionSpan span2) {
                final int flag1 = span1.getFlags();
                final int flag2 = span2.getFlags();
                if (flag1 != flag2) {
                    // The order here should match what is used in updateDrawState
                    final boolean easy1 = (flag1 & SuggestionSpan.FLAG_EASY_CORRECT) != 0;
                    final boolean easy2 = (flag2 & SuggestionSpan.FLAG_EASY_CORRECT) != 0;
                    final boolean misspelled1 = (flag1 & SuggestionSpan.FLAG_MISSPELLED) != 0;
                    final boolean misspelled2 = (flag2 & SuggestionSpan.FLAG_MISSPELLED) != 0;
                    if (easy1 && !misspelled1) return -1;
                    if (easy2 && !misspelled2) return 1;
                    if (misspelled1) return -1;
                    if (misspelled2) return 1;
                }

                return mSpansLengths.get(span1).intValue() - mSpansLengths.get(span2).intValue();
            }

        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.951 -0500", hash_original_method = "43D89583824EB2CC5185C1DC5EA2D76A", hash_generated_method = "208231DC7A62F09A93BB78BF198C237F")
        
private void updateSuggestions() {
            Spannable spannable = (Spannable) TextView.this.mText;
            SuggestionSpan[] suggestionSpans = getSuggestionSpans();

            final int nbSpans = suggestionSpans.length;

            mNumberOfSuggestions = 0;
            int spanUnionStart = mText.length();
            int spanUnionEnd = 0;

            SuggestionSpan misspelledSpan = null;
            int underlineColor = 0;

            for (int spanIndex = 0; spanIndex < nbSpans; spanIndex++) {
                SuggestionSpan suggestionSpan = suggestionSpans[spanIndex];
                final int spanStart = spannable.getSpanStart(suggestionSpan);
                final int spanEnd = spannable.getSpanEnd(suggestionSpan);
                spanUnionStart = Math.min(spanStart, spanUnionStart);
                spanUnionEnd = Math.max(spanEnd, spanUnionEnd);

                if ((suggestionSpan.getFlags() & SuggestionSpan.FLAG_MISSPELLED) != 0) {
                    misspelledSpan = suggestionSpan;
                }

                // The first span dictates the background color of the highlighted text
                if (spanIndex == 0) underlineColor = suggestionSpan.getUnderlineColor();

                String[] suggestions = suggestionSpan.getSuggestions();
                int nbSuggestions = suggestions.length;
                for (int suggestionIndex = 0; suggestionIndex < nbSuggestions; suggestionIndex++) {
                    SuggestionInfo suggestionInfo = mSuggestionInfos[mNumberOfSuggestions];
                    suggestionInfo.suggestionSpan = suggestionSpan;
                    suggestionInfo.suggestionIndex = suggestionIndex;
                    suggestionInfo.text.replace(0, suggestionInfo.text.length(),
                            suggestions[suggestionIndex]);

                    mNumberOfSuggestions++;
                    if (mNumberOfSuggestions == MAX_NUMBER_SUGGESTIONS) {
                        // Also end outer for loop
                        spanIndex = nbSpans;
                        break;
                    }
                }
            }

            for (int i = 0; i < mNumberOfSuggestions; i++) {
                highlightTextDifferences(mSuggestionInfos[i], spanUnionStart, spanUnionEnd);
            }

            // Add to dictionary item if there is a span with the misspelled flag
            if (misspelledSpan != null) {
                final int misspelledStart = spannable.getSpanStart(misspelledSpan);
                final int misspelledEnd = spannable.getSpanEnd(misspelledSpan);
                if (misspelledStart >= 0 && misspelledEnd > misspelledStart) {
                    SuggestionInfo suggestionInfo = mSuggestionInfos[mNumberOfSuggestions];
                    suggestionInfo.suggestionSpan = misspelledSpan;
                    suggestionInfo.suggestionIndex = ADD_TO_DICTIONARY;
                    suggestionInfo.text.replace(0, suggestionInfo.text.length(),
                            getContext().getString(com.android.internal.R.string.addToDictionary));
                    suggestionInfo.text.setSpan(suggestionInfo.highlightSpan, 0, 0,
                            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

                    mNumberOfSuggestions++;
                }
            }

            // Delete item
            SuggestionInfo suggestionInfo = mSuggestionInfos[mNumberOfSuggestions];
            suggestionInfo.suggestionSpan = null;
            suggestionInfo.suggestionIndex = DELETE_TEXT;
            suggestionInfo.text.replace(0, suggestionInfo.text.length(),
                    getContext().getString(com.android.internal.R.string.deleteText));
            suggestionInfo.text.setSpan(suggestionInfo.highlightSpan, 0, 0,
                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            mNumberOfSuggestions++;

            if (mSuggestionRangeSpan == null) mSuggestionRangeSpan = new SuggestionRangeSpan();
            if (underlineColor == 0) {
                // Fallback on the default highlight color when the first span does not provide one
                mSuggestionRangeSpan.setBackgroundColor(mHighlightColor);
            } else {
                final float BACKGROUND_TRANSPARENCY = 0.4f;
                final int newAlpha = (int) (Color.alpha(underlineColor) * BACKGROUND_TRANSPARENCY);
                mSuggestionRangeSpan.setBackgroundColor(
                        (underlineColor & 0x00FFFFFF) + (newAlpha << 24));
            }
            spannable.setSpan(mSuggestionRangeSpan, spanUnionStart, spanUnionEnd,
                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

            mSuggestionsAdapter.notifyDataSetChanged();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.953 -0500", hash_original_method = "9587A8E163DBC119C2F6F3B6CD33F02D", hash_generated_method = "E00119F4900491C676D7C12B1C28255B")
        
private void highlightTextDifferences(SuggestionInfo suggestionInfo, int unionStart,
                int unionEnd) {
            final Spannable text = (Spannable) mText;
            final int spanStart = text.getSpanStart(suggestionInfo.suggestionSpan);
            final int spanEnd = text.getSpanEnd(suggestionInfo.suggestionSpan);

            // Adjust the start/end of the suggestion span
            suggestionInfo.suggestionStart = spanStart - unionStart;
            suggestionInfo.suggestionEnd = suggestionInfo.suggestionStart 
                    + suggestionInfo.text.length();

            suggestionInfo.text.setSpan(suggestionInfo.highlightSpan, 0,
                    suggestionInfo.text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

            // Add the text before and after the span.
            suggestionInfo.text.insert(0, mText.toString().substring(unionStart, spanStart));
            suggestionInfo.text.append(mText.toString().substring(spanEnd, unionEnd));
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.958 -0500", hash_original_method = "73388536B046BC3C58C91A89E4930696", hash_generated_method = "1C90A24B85A8B650ECB595E782B3785F")
        
@Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Editable editable = (Editable) mText;
            SuggestionInfo suggestionInfo = mSuggestionInfos[position];

            if (suggestionInfo.suggestionIndex == DELETE_TEXT) {
                final int spanUnionStart = editable.getSpanStart(mSuggestionRangeSpan);
                int spanUnionEnd = editable.getSpanEnd(mSuggestionRangeSpan);
                if (spanUnionStart >= 0 && spanUnionEnd > spanUnionStart) {
                    // Do not leave two adjacent spaces after deletion, or one at beginning of text
                    if (spanUnionEnd < editable.length() &&
                            Character.isSpaceChar(editable.charAt(spanUnionEnd)) &&
                            (spanUnionStart == 0 ||
                            Character.isSpaceChar(editable.charAt(spanUnionStart - 1)))) {
                        spanUnionEnd = spanUnionEnd + 1;
                    }
                    deleteText_internal(spanUnionStart, spanUnionEnd);
                }
                hide();
                return;
            }

            final int spanStart = editable.getSpanStart(suggestionInfo.suggestionSpan);
            final int spanEnd = editable.getSpanEnd(suggestionInfo.suggestionSpan);
            if (spanStart < 0 || spanEnd <= spanStart) {
                // Span has been removed
                hide();
                return;
            }
            final String originalText = mText.toString().substring(spanStart, spanEnd);

            if (suggestionInfo.suggestionIndex == ADD_TO_DICTIONARY) {
                Intent intent = new Intent(Settings.ACTION_USER_DICTIONARY_INSERT);
                intent.putExtra("word", originalText);
                intent.putExtra("locale", getTextServicesLocale().toString());
                intent.setFlags(intent.getFlags() | Intent.FLAG_ACTIVITY_NEW_TASK);
                getContext().startActivity(intent);
                // There is no way to know if the word was indeed added. Re-check.
                // TODO The ExtractEditText should remove the span in the original text instead
                editable.removeSpan(suggestionInfo.suggestionSpan);
                updateSpellCheckSpans(spanStart, spanEnd, false);
            } else {
                // SuggestionSpans are removed by replace: save them before
                SuggestionSpan[] suggestionSpans = editable.getSpans(spanStart, spanEnd,
                        SuggestionSpan.class);
                final int length = suggestionSpans.length;
                int[] suggestionSpansStarts = new int[length];
                int[] suggestionSpansEnds = new int[length];
                int[] suggestionSpansFlags = new int[length];
                for (int i = 0; i < length; i++) {
                    final SuggestionSpan suggestionSpan = suggestionSpans[i];
                    suggestionSpansStarts[i] = editable.getSpanStart(suggestionSpan);
                    suggestionSpansEnds[i] = editable.getSpanEnd(suggestionSpan);
                    suggestionSpansFlags[i] = editable.getSpanFlags(suggestionSpan);

                    // Remove potential misspelled flags
                    int suggestionSpanFlags = suggestionSpan.getFlags();
                    if ((suggestionSpanFlags & SuggestionSpan.FLAG_MISSPELLED) > 0) {
                        suggestionSpanFlags &= ~SuggestionSpan.FLAG_MISSPELLED;
                        suggestionSpanFlags &= ~SuggestionSpan.FLAG_EASY_CORRECT;
                        suggestionSpan.setFlags(suggestionSpanFlags);
                    }
                }

                final int suggestionStart = suggestionInfo.suggestionStart;
                final int suggestionEnd = suggestionInfo.suggestionEnd;
                final String suggestion = suggestionInfo.text.subSequence(
                        suggestionStart, suggestionEnd).toString();
                replaceText_internal(spanStart, spanEnd, suggestion);

                // Notify source IME of the suggestion pick. Do this before swaping texts.
                if (!TextUtils.isEmpty(
                        suggestionInfo.suggestionSpan.getNotificationTargetClassName())) {
                    InputMethodManager imm = InputMethodManager.peekInstance();
                    if (imm != null) {
                        imm.notifySuggestionPicked(suggestionInfo.suggestionSpan, originalText,
                                suggestionInfo.suggestionIndex);
                    }
                }

                // Swap text content between actual text and Suggestion span
                String[] suggestions = suggestionInfo.suggestionSpan.getSuggestions();
                suggestions[suggestionInfo.suggestionIndex] = originalText;

                // Restore previous SuggestionSpans
                final int lengthDifference = suggestion.length() - (spanEnd - spanStart);
                for (int i = 0; i < length; i++) {
                    // Only spans that include the modified region make sense after replacement
                    // Spans partially included in the replaced region are removed, there is no
                    // way to assign them a valid range after replacement
                    if (suggestionSpansStarts[i] <= spanStart &&
                            suggestionSpansEnds[i] >= spanEnd) {
                        setSpan_internal(suggestionSpans[i], suggestionSpansStarts[i],
                                suggestionSpansEnds[i] + lengthDifference, suggestionSpansFlags[i]);
                    }
                }

                // Move cursor at the end of the replaced word
                final int newCursorPosition = spanEnd + lengthDifference;
                setCursorPosition_internal(newCursorPosition, newCursorPosition);
            }

            hide();
        }
    }

    private class SelectionActionModeCallback implements ActionMode.Callback {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.760 -0400", hash_original_method = "0A08C97F3CA872D86BD6FA2FC1044E6A", hash_generated_method = "0A08C97F3CA872D86BD6FA2FC1044E6A")
        public SelectionActionModeCallback ()
        {
            //Synthesized constructor
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.997 -0500", hash_original_method = "9BA90F93967180A852B2E5C718CC8322", hash_generated_method = "65B87AD8F4665C05B77B2C334CF7DEB3")
        
@Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            TypedArray styledAttributes = mContext.obtainStyledAttributes(
                    com.android.internal.R.styleable.SelectionModeDrawables);

            boolean allowText = getContext().getResources().getBoolean(
                    com.android.internal.R.bool.config_allowActionMenuItemTextWithIcon);

            mode.setTitle(allowText ?
                    mContext.getString(com.android.internal.R.string.textSelectionCABTitle) : null);
            mode.setSubtitle(null);

            int selectAllIconId = 0; // No icon by default
            if (!allowText) {
                // Provide an icon, text will not be displayed on smaller screens.
                selectAllIconId = styledAttributes.getResourceId(
                        R.styleable.SelectionModeDrawables_actionModeSelectAllDrawable, 0);
            }

            menu.add(0, ID_SELECT_ALL, 0, com.android.internal.R.string.selectAll).
                    setIcon(selectAllIconId).
                    setAlphabeticShortcut('a').
                    setShowAsAction(
                            MenuItem.SHOW_AS_ACTION_ALWAYS | MenuItem.SHOW_AS_ACTION_WITH_TEXT);

            if (canCut()) {
                menu.add(0, ID_CUT, 0, com.android.internal.R.string.cut).
                    setIcon(styledAttributes.getResourceId(
                            R.styleable.SelectionModeDrawables_actionModeCutDrawable, 0)).
                    setAlphabeticShortcut('x').
                    setShowAsAction(
                            MenuItem.SHOW_AS_ACTION_ALWAYS | MenuItem.SHOW_AS_ACTION_WITH_TEXT);
            }

            if (canCopy()) {
                menu.add(0, ID_COPY, 0, com.android.internal.R.string.copy).
                    setIcon(styledAttributes.getResourceId(
                            R.styleable.SelectionModeDrawables_actionModeCopyDrawable, 0)).
                    setAlphabeticShortcut('c').
                    setShowAsAction(
                            MenuItem.SHOW_AS_ACTION_ALWAYS | MenuItem.SHOW_AS_ACTION_WITH_TEXT);
            }

            if (canPaste()) {
                menu.add(0, ID_PASTE, 0, com.android.internal.R.string.paste).
                        setIcon(styledAttributes.getResourceId(
                                R.styleable.SelectionModeDrawables_actionModePasteDrawable, 0)).
                        setAlphabeticShortcut('v').
                        setShowAsAction(
                                MenuItem.SHOW_AS_ACTION_ALWAYS | MenuItem.SHOW_AS_ACTION_WITH_TEXT);
            }

            styledAttributes.recycle();

            if (mCustomSelectionActionModeCallback != null) {
                if (!mCustomSelectionActionModeCallback.onCreateActionMode(mode, menu)) {
                    // The custom mode can choose to cancel the action mode
                    return false;
                }
            }

            if (menu.hasVisibleItems() || mode.getCustomView() != null) {
                getSelectionController().show();
                return true;
            } else {
                return false;
            }
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.000 -0500", hash_original_method = "350C4916EAD271625C17FEEF1988576E", hash_generated_method = "2CB47A9ED2B87C5BD02A33F178801F5E")
        
@Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            if (mCustomSelectionActionModeCallback != null) {
                return mCustomSelectionActionModeCallback.onPrepareActionMode(mode, menu);
            }
            return true;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.003 -0500", hash_original_method = "7EC2472DA1F2018FBE0DB5359E02217C", hash_generated_method = "6A82A63239817703A3F9BA30FD222ED2")
        
@Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            if (mCustomSelectionActionModeCallback != null &&
                 mCustomSelectionActionModeCallback.onActionItemClicked(mode, item)) {
                return true;
            }
            return onTextContextMenuItem(item.getItemId());
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.005 -0500", hash_original_method = "E3DA233478038DA411461438FCA54906", hash_generated_method = "90E7834E2C7E91553E57BC8833D4AEFE")
        
@Override
        public void onDestroyActionMode(ActionMode mode) {
            if (mCustomSelectionActionModeCallback != null) {
                mCustomSelectionActionModeCallback.onDestroyActionMode(mode);
            }
            Selection.setSelection((Spannable) mText, getSelectionEnd());

            if (mSelectionModifierCursorController != null) {
                mSelectionModifierCursorController.hide();
            }

            mSelectionActionMode = null;
        }

    }

    private class ActionPopupWindow extends PinnedPopupWindow implements OnClickListener {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.011 -0500", hash_original_field = "79C145E39484BF77945F7170B22F5DF9", hash_generated_field = "9556C9F4A76B40115A0F30878921C774")

        private static final int POPUP_TEXT_LAYOUT =
                com.android.internal.R.layout.text_edit_action_popup_text;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.013 -0500", hash_original_field = "45686E114CE3900CD8358FA0DC1B32BB", hash_generated_field = "D8E77E145B60561FAD9A3B60E7593FC7")

        private TextView mPasteTextView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.016 -0500", hash_original_field = "132E850E5CBC14C74C3A87A297CDBB5C", hash_generated_field = "5647E56FAEB644585635D1F439C78D58")

        private TextView mReplaceTextView;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.764 -0400", hash_original_method = "66BB2A1B8CD91C3CE44D6AD3A6EA951F", hash_generated_method = "66BB2A1B8CD91C3CE44D6AD3A6EA951F")
        public ActionPopupWindow ()
        {
            //Synthesized constructor
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.019 -0500", hash_original_method = "3A27BFF151DD7090A49C43ED6F082D3A", hash_generated_method = "29A464309A3DA7D4E119FC3F187526A2")
        
@Override
        protected void createPopupWindow() {
            mPopupWindow = new PopupWindow(TextView.this.mContext, null,
                    com.android.internal.R.attr.textSelectHandleWindowStyle);
            mPopupWindow.setClippingEnabled(true);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.022 -0500", hash_original_method = "24A2CF459D5801BCD7B986330654CD38", hash_generated_method = "160845800CEAC3DB04C9C4CDDD900821")
        
@Override
        protected void initContentView() {
            LinearLayout linearLayout = new LinearLayout(TextView.this.getContext());
            linearLayout.setOrientation(LinearLayout.HORIZONTAL);
            mContentView = linearLayout;
            mContentView.setBackgroundResource(
                    com.android.internal.R.drawable.text_edit_paste_window);

            LayoutInflater inflater = (LayoutInflater)TextView.this.mContext.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            LayoutParams wrapContent = new LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

            mPasteTextView = (TextView) inflater.inflate(POPUP_TEXT_LAYOUT, null);
            mPasteTextView.setLayoutParams(wrapContent);
            mContentView.addView(mPasteTextView);
            mPasteTextView.setText(com.android.internal.R.string.paste);
            mPasteTextView.setOnClickListener(this);

            mReplaceTextView = (TextView) inflater.inflate(POPUP_TEXT_LAYOUT, null);
            mReplaceTextView.setLayoutParams(wrapContent);
            mContentView.addView(mReplaceTextView);
            mReplaceTextView.setText(com.android.internal.R.string.replace);
            mReplaceTextView.setOnClickListener(this);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.025 -0500", hash_original_method = "A37D41A60FC392DB422E94A09527D04E", hash_generated_method = "8DE7CEB1C281E9C7B33D42F7F6F41493")
        
@Override
        public void show() {
            boolean canPaste = canPaste();
            boolean canSuggest = isSuggestionsEnabled() && isCursorInsideSuggestionSpan();
            mPasteTextView.setVisibility(canPaste ? View.VISIBLE : View.GONE);
            mReplaceTextView.setVisibility(canSuggest ? View.VISIBLE : View.GONE);

            if (!canPaste && !canSuggest) return;

            super.show();
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.027 -0500", hash_original_method = "35B6F06783189901121FFF5DA40FB852", hash_generated_method = "7300FD216DCBB1A7F01EED3DA5E222B8")
        
@Override
        public void onClick(View view) {
            if (view == mPasteTextView && canPaste()) {
                onTextContextMenuItem(ID_PASTE);
                hide();
            } else if (view == mReplaceTextView) {
                final int middle = (getSelectionStart() + getSelectionEnd()) / 2;
                stopSelectionActionMode();
                Selection.setSelection((Spannable) mText, middle);
                showSuggestions();
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.030 -0500", hash_original_method = "6C32A970FB91901A3510EE736EF065A8", hash_generated_method = "55D0215E27C6A014418C671EB6B035AE")
        
@Override
        protected int getTextOffset() {
            return (getSelectionStart() + getSelectionEnd()) / 2;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.032 -0500", hash_original_method = "AB01324FAF38A5FF69620E59B4546722", hash_generated_method = "5E189447C9944B79FD38DE086139B834")
        
@Override
        protected int getVerticalLocalPosition(int line) {
            return mLayout.getLineTop(line) - mContentView.getMeasuredHeight();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.035 -0500", hash_original_method = "155BF5081251C49CE36145C9CC0615FD", hash_generated_method = "0F029D6017A145BC1A5905BA1E12C6C4")
        
@Override
        protected int clipVertically(int positionY) {
            if (positionY < 0) {
                final int offset = getTextOffset();
                final int line = mLayout.getLineForOffset(offset);
                positionY += mLayout.getLineBottom(line) - mLayout.getLineTop(line);
                positionY += mContentView.getMeasuredHeight();

                // Assumes insertion and selection handles share the same height
                final Drawable handle = mContext.getResources().getDrawable(mTextSelectHandleRes);
                positionY += handle.getIntrinsicHeight();
            }

            return positionY;
        }
    }

    private abstract class HandleView extends View implements TextViewPositionListener {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.084 -0500", hash_original_field = "DBD31178556EACE1327E939DC1C9F5C6", hash_generated_field = "917FEC01F976A8368E859F3ACCB2974D")

        private static final int HISTORY_SIZE = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.087 -0500", hash_original_field = "55D5EE16DB379F62DEFE61F492062C33", hash_generated_field = "2607BC863EBAADB23B7B64E594D70D00")

        private static final int TOUCH_UP_FILTER_DELAY_AFTER = 150;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.089 -0500", hash_original_field = "F1DB97F111C264B8F6AB7BEBFE443020", hash_generated_field = "4E35A675947440670D142A9EC9F7D555")

        private static final int TOUCH_UP_FILTER_DELAY_BEFORE = 350;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.041 -0500", hash_original_field = "38BA53DD394F85639C99ED8E666FF8FB", hash_generated_field = "6C4E60FE8A6D1EE71691C50FE013D71E")

        protected Drawable mDrawable;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.043 -0500", hash_original_field = "19534CEC22A532E9A79E581E304C832D", hash_generated_field = "4C4EE51B5C48463562D9242B398F28CE")

        protected Drawable mDrawableLtr;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.045 -0500", hash_original_field = "A319849D6A55D0D58FE976805869B656", hash_generated_field = "C7A02A239F561A2D85D421A4E8712A4E")

        protected Drawable mDrawableRtl;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.048 -0500", hash_original_field = "BAE78F776F19234C0774872503ED9170", hash_generated_field = "B93BD44443CA54ABF5B84DF5F163A33F")

        private  PopupWindow mContainer;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.766 -0400", hash_original_field = "E33EA5C4D485469D2432B3A781CD5014", hash_generated_field = "B562606C08FEFE4EA880E0BAFC4807BC")

        private int mPositionX;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.766 -0400", hash_original_field = "5EF2225F886100AA279B39F41428F3C5", hash_generated_field = "30733FB91B36B499B68F008F42192052")

        private int mPositionY;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.053 -0500", hash_original_field = "3A568D5A24E6042844823649C40BC486", hash_generated_field = "71A2FEF14E89166E5A8A859417B1663A")

        private boolean mIsDragging;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.766 -0400", hash_original_field = "029443A19C599CE9A771103B1F04FFA7", hash_generated_field = "93A0F0D3D0C011A4C3C7501AB57199A0")

        private float mTouchToWindowOffsetX;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.766 -0400", hash_original_field = "01E0875D4861BF37105440B51BFCE246", hash_generated_field = "540D3F7CD2E1D98D601A597896694EF1")

        private float mTouchToWindowOffsetY;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.057 -0500", hash_original_field = "C43D14F750B8AFCF81873169DDA860BD", hash_generated_field = "FC8146331AA3445EF26C9BD556ACBB7A")

        protected int mHotspotX;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.059 -0500", hash_original_field = "4A3DC8D982304C932853D2F76849AA77", hash_generated_field = "6BB781632FC22CFF12B61F61AC16C144")

        private float mTouchOffsetY;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.062 -0500", hash_original_field = "C3798A09CA87BA3FEFEBBB576225318E", hash_generated_field = "7A7CA8BEEE2A68B1CAD15B2AD85A2E90")

        private float mIdealVerticalOffset;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.767 -0400", hash_original_field = "AFAA5B704E00C118BFC94C3DB68B3EB8", hash_generated_field = "4316A0FF32FF85FA98C402B295009B89")

        private int mLastParentX;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.767 -0400", hash_original_field = "921E843A2994BBE22EA5E45795AA43E4", hash_generated_field = "989834E9B58E837BA06B11D0842ADD46")

        private int mLastParentY;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.067 -0500", hash_original_field = "B19DB6AFB1D8AFD756F38B8B28F71A87", hash_generated_field = "2EC1E5C57AE86C2314399153800FDC8F")

        protected ActionPopupWindow mActionPopupWindow;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.069 -0500", hash_original_field = "D1DA96F9942666A253433F4CE969366F", hash_generated_field = "C47DED40298BEE97981BC7B8F1538E5B")

        private int mPreviousOffset = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.071 -0500", hash_original_field = "509C5DB407C2C48F887C9D58E2471A0C", hash_generated_field = "348E54253A3677FA237DAA94481A3907")

        private boolean mPositionHasChanged = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.073 -0500", hash_original_field = "D53FEFFD5CA7038F93BE32985B7741CC", hash_generated_field = "AF098A48DA71A067D06553B74FDC10EC")

        private Runnable mActionPopupShower;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.092 -0500", hash_original_field = "32E49D1FF377893A740F70634E4654B0", hash_generated_field = "49D0562CBA301978D9BE0EDDCD29274F")

        private final long[] mPreviousOffsetsTimes = new long[HISTORY_SIZE];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.095 -0500", hash_original_field = "0E5E798991E1DD9A0E7CA32640C72D11", hash_generated_field = "B14296EE4EF0011B1C75932F407A07FC")

        private final int[] mPreviousOffsets = new int[HISTORY_SIZE];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.097 -0500", hash_original_field = "BA99609CDA8DDC4C7F2A9CA51BC5A5B6", hash_generated_field = "A862CB689B1B30174089DC5C296E66B1")

        private int mPreviousOffsetIndex = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.099 -0500", hash_original_field = "47E486EDCF935554FAAA9BD196711D52", hash_generated_field = "FFBAC9977BB0F1F158F20DFF11AA8445")

        private int mNumberPreviousOffsets = 0;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.076 -0500", hash_original_method = "96CFEA14605480F2CAC7A5BABB016DB2", hash_generated_method = "8014AB30DA6574D83B19A30BFAE813BE")
        
public HandleView(Drawable drawableLtr, Drawable drawableRtl) {
            super(TextView.this.mContext);
            mContainer = new PopupWindow(TextView.this.mContext, null,
                    com.android.internal.R.attr.textSelectHandleWindowStyle);
            mContainer.setSplitTouchEnabled(true);
            mContainer.setClippingEnabled(false);
            mContainer.setWindowLayoutType(WindowManager.LayoutParams.TYPE_APPLICATION_SUB_PANEL);
            mContainer.setContentView(this);

            mDrawableLtr = drawableLtr;
            mDrawableRtl = drawableRtl;

            updateDrawable();

            final int handleHeight = mDrawable.getIntrinsicHeight();
            mTouchOffsetY = -0.3f * handleHeight;
            mIdealVerticalOffset = 0.7f * handleHeight;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.079 -0500", hash_original_method = "79B760AD39E8E4DC7B1000745317DEB7", hash_generated_method = "5F37903969600EEE19F363ACE309295A")
        
protected void updateDrawable() {
            final int offset = getCurrentCursorOffset();
            final boolean isRtlCharAtOffset = mLayout.isRtlCharAt(offset);
            mDrawable = isRtlCharAtOffset ? mDrawableRtl : mDrawableLtr;
            mHotspotX = getHotspotX(mDrawable, isRtlCharAtOffset);
        }

        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.081 -0500", hash_original_method = "8501619A96C71D53CFF709ABFDB75FE7", hash_generated_method = "D4B7AAD0D5F5484F11DA3EF2330C8D0F")
        
protected abstract int getHotspotX(Drawable drawable, boolean isRtlRun);

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.101 -0500", hash_original_method = "FC7484D3CDDEA8A708B164CA1D725BB5", hash_generated_method = "C7DC7FBC810761A793D85453987CDD3D")
        
private void startTouchUpFilter(int offset) {
            mNumberPreviousOffsets = 0;
            addPositionToTouchUpFilter(offset);
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.103 -0500", hash_original_method = "F067815A22302FA44603BE1943641FAF", hash_generated_method = "9054F6F505BD8760BBAD57418D6CC3F8")
        
private void addPositionToTouchUpFilter(int offset) {
            mPreviousOffsetIndex = (mPreviousOffsetIndex + 1) % HISTORY_SIZE;
            mPreviousOffsets[mPreviousOffsetIndex] = offset;
            mPreviousOffsetsTimes[mPreviousOffsetIndex] = SystemClock.uptimeMillis();
            mNumberPreviousOffsets++;
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.106 -0500", hash_original_method = "55F0EF9CEF8C5AA4299D2A57A3F07803", hash_generated_method = "55CD28495667CED9B5398DC6E80D1277")
        
private void filterOnTouchUp() {
            final long now = SystemClock.uptimeMillis();
            int i = 0;
            int index = mPreviousOffsetIndex;
            final int iMax = Math.min(mNumberPreviousOffsets, HISTORY_SIZE);
            while (i < iMax && (now - mPreviousOffsetsTimes[index]) < TOUCH_UP_FILTER_DELAY_AFTER) {
                i++;
                index = (mPreviousOffsetIndex - i + HISTORY_SIZE) % HISTORY_SIZE;
            }

            if (i > 0 && i < iMax &&
                    (now - mPreviousOffsetsTimes[index]) > TOUCH_UP_FILTER_DELAY_BEFORE) {
                positionAtCursorOffset(mPreviousOffsets[index], false);
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.108 -0500", hash_original_method = "8E1053DB926B4787A5B252A5CCF7E3E6", hash_generated_method = "8F4B87C61A14C3E2CEA5639AAA23CBCF")
        
public boolean offsetHasBeenChanged() {
            return mNumberPreviousOffsets > 1;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.111 -0500", hash_original_method = "F1B9B11E208A14EF1A8385C794E8615A", hash_generated_method = "45F57BAEB9C14D9BC3F2C3BC59EF0D6C")
        
@Override
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            setMeasuredDimension(mDrawable.getIntrinsicWidth(), mDrawable.getIntrinsicHeight());
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.113 -0500", hash_original_method = "0CEFB75F912E1774230D056666C1CB4D", hash_generated_method = "65CBB25BCBA17B4FEC5CF149534AF0DD")
        
public void show() {
            if (isShowing()) return;

            getPositionListener().addSubscriber(this, true /* local position may change */);

            // Make sure the offset is always considered new, even when focusing at same position
            mPreviousOffset = -1;
            positionAtCursorOffset(getCurrentCursorOffset(), false);

            hideActionPopupWindow();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.116 -0500", hash_original_method = "58A1CA71E65CA8505283F80ECD55B125", hash_generated_method = "E97E1F261DF68304D703D6B2839B8F0D")
        
protected void dismiss() {
            mIsDragging = false;
            mContainer.dismiss();
            onDetached();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.118 -0500", hash_original_method = "E51AD13D62B6328756BEDC07E20C91A7", hash_generated_method = "CE74422C59DE5029B94985860D1764AF")
        
public void hide() {
            dismiss();

            TextView.this.getPositionListener().removeSubscriber(this);
        }
        
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.770 -0400", hash_original_method = "0D5333D88B146866CC739B7BC1FA2E0A", hash_generated_method = "35C87A0497B2DDA10AB5E7767F78297E")
        void showActionPopupWindow(int delay) {
            //addTaint(delay);
            if(mActionPopupWindow == null)            
            {
                mActionPopupWindow = new ActionPopupWindow();
            } //End block
            if(mActionPopupShower == null)            
            {
                mActionPopupShower = new Runnable() {
                    @DSSafe(DSCat.SAFE_LIST)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.121 -0500", hash_original_method = "3DEF90E085B5D89C941B0ED88F0DC7FD", hash_generated_method = "BCEE768D2B06C731F82F8504A0316B5C")
                    
public void run() {
                        mActionPopupWindow.show();
                    }
                };
            } //End block
            else
            {
                TextView.this.removeCallbacks(mActionPopupShower);
            } //End block
            TextView.this.postDelayed(mActionPopupShower, delay);
            // ---------- Original Method ----------
            //if (mActionPopupWindow == null) {
            //mActionPopupWindow = new ActionPopupWindow();
            //}
            //if (mActionPopupShower == null) {
            //mActionPopupShower = new Runnable() {
            //public void run() {
            //mActionPopupWindow.show();
            //}
            //};
            //} else {
            //TextView.this.removeCallbacks(mActionPopupShower);
            //}
            //TextView.this.postDelayed(mActionPopupShower, delay);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.126 -0500", hash_original_method = "7E990B2771AC26D4AD93278F16BEC9C8", hash_generated_method = "1A8F66159A37E630249C8857903402F2")
        
protected void hideActionPopupWindow() {
            if (mActionPopupShower != null) {
                TextView.this.removeCallbacks(mActionPopupShower);
            }
            if (mActionPopupWindow != null) {
                mActionPopupWindow.hide();
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.128 -0500", hash_original_method = "4C582CFB225DCFD162C1BDA55C8E191D", hash_generated_method = "DCAF4FBDC1486E2B5377C9D508FB4C00")
        
public boolean isShowing() {
            return mContainer.isShowing();
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.131 -0500", hash_original_method = "622F11C59DDFBBB8F6FA4F43A2282A80", hash_generated_method = "35A8F344AB40ACE53773BEBD42977B83")
        
private boolean isVisible() {
            // Always show a dragging handle.
            if (mIsDragging) {
                return true;
            }

            if (isInBatchEditMode()) {
                return false;
            }

            return TextView.this.isPositionVisible(mPositionX + mHotspotX, mPositionY);
        }

        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.133 -0500", hash_original_method = "AEE53A521F2D589B47E08037B7779A75", hash_generated_method = "0358BA4415F52BA396AB03FAEBD4C12A")
        
public abstract int getCurrentCursorOffset();

        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.136 -0500", hash_original_method = "4F3A56003BC466CAB6DAB9F4B296D3B2", hash_generated_method = "3093F5F4F43816463C62DE1877709A6A")
        
protected abstract void updateSelection(int offset);

        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.138 -0500", hash_original_method = "9519DD3C69AC3FFE6C9315933390E1E4", hash_generated_method = "68D6AFF41943C2B13124ECAE7F18A0C5")
        
public abstract void updatePosition(float x, float y);

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.141 -0500", hash_original_method = "23AE0E97732D2E1BD689A17102858930", hash_generated_method = "AB4BF1A98C38C822DB91677EE5ADD47B")
        
protected void positionAtCursorOffset(int offset, boolean parentScrolled) {
            // A HandleView relies on the layout, which may be nulled by external methods
            if (mLayout == null) {
                // Will update controllers' state, hiding them and stopping selection mode if needed
                prepareCursorControllers();
                return;
            }

            if (offset != mPreviousOffset || parentScrolled) {
                updateSelection(offset);
                addPositionToTouchUpFilter(offset);
                final int line = mLayout.getLineForOffset(offset);

                mPositionX = (int) (mLayout.getPrimaryHorizontal(offset) - 0.5f - mHotspotX);
                mPositionY = mLayout.getLineBottom(line);

                // Take TextView's padding and scroll into account.
                mPositionX += viewportToContentHorizontalOffset();
                mPositionY += viewportToContentVerticalOffset();

                mPreviousOffset = offset;
                mPositionHasChanged = true;
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.144 -0500", hash_original_method = "13FE1FBB4F8CE63ECDC017603A6579A6", hash_generated_method = "DD412FAA04C81B715E1FC0C2F1E90EC1")
        
public void updatePosition(int parentPositionX, int parentPositionY,
                boolean parentPositionChanged, boolean parentScrolled) {
            positionAtCursorOffset(getCurrentCursorOffset(), parentScrolled);
            if (parentPositionChanged || mPositionHasChanged) {
                if (mIsDragging) {
                    // Update touchToWindow offset in case of parent scrolling while dragging
                    if (parentPositionX != mLastParentX || parentPositionY != mLastParentY) {
                        mTouchToWindowOffsetX += parentPositionX - mLastParentX;
                        mTouchToWindowOffsetY += parentPositionY - mLastParentY;
                        mLastParentX = parentPositionX;
                        mLastParentY = parentPositionY;
                    }

                    onHandleMoved();
                }

                if (isVisible()) {
                    final int positionX = parentPositionX + mPositionX;
                    final int positionY = parentPositionY + mPositionY;
                    if (isShowing()) {
                        mContainer.update(positionX, positionY, -1, -1);
                    } else {
                        mContainer.showAtLocation(TextView.this, Gravity.NO_GRAVITY,
                                positionX, positionY);
                    }
                } else {
                    if (isShowing()) {
                        dismiss();
                    }
                }

                mPositionHasChanged = false;
            }
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.146 -0500", hash_original_method = "F8254677C35EEC48CDE0AC0DA5BFAEC5", hash_generated_method = "9322B89253EF09AAB17F50613F5368BC")
        
@Override
        protected void onDraw(Canvas c) {
            mDrawable.setBounds(0, 0, mRight - mLeft, mBottom - mTop);
            mDrawable.draw(c);
        }

        @DSSafe(DSCat.ANDROID_CALLBACK)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.149 -0500", hash_original_method = "AFDBACCAFCABC81309AB0079A4EAD49F", hash_generated_method = "9312E0A74C7B7089B5503960EE384788")
        
@Override
        public boolean onTouchEvent(MotionEvent ev) {
            switch (ev.getActionMasked()) {
                case MotionEvent.ACTION_DOWN: {
                    startTouchUpFilter(getCurrentCursorOffset());
                    mTouchToWindowOffsetX = ev.getRawX() - mPositionX;
                    mTouchToWindowOffsetY = ev.getRawY() - mPositionY;

                    final PositionListener positionListener = getPositionListener();
                    mLastParentX = positionListener.getPositionX();
                    mLastParentY = positionListener.getPositionY();
                    mIsDragging = true;
                    break;
                }

                case MotionEvent.ACTION_MOVE: {
                    final float rawX = ev.getRawX();
                    final float rawY = ev.getRawY();

                    // Vertical hysteresis: vertical down movement tends to snap to ideal offset
                    final float previousVerticalOffset = mTouchToWindowOffsetY - mLastParentY;
                    final float currentVerticalOffset = rawY - mPositionY - mLastParentY;
                    float newVerticalOffset;
                    if (previousVerticalOffset < mIdealVerticalOffset) {
                        newVerticalOffset = Math.min(currentVerticalOffset, mIdealVerticalOffset);
                        newVerticalOffset = Math.max(newVerticalOffset, previousVerticalOffset);
                    } else {
                        newVerticalOffset = Math.max(currentVerticalOffset, mIdealVerticalOffset);
                        newVerticalOffset = Math.min(newVerticalOffset, previousVerticalOffset);
                    }
                    mTouchToWindowOffsetY = newVerticalOffset + mLastParentY;

                    final float newPosX = rawX - mTouchToWindowOffsetX + mHotspotX;
                    final float newPosY = rawY - mTouchToWindowOffsetY + mTouchOffsetY;

                    updatePosition(newPosX, newPosY);
                    break;
                }

                case MotionEvent.ACTION_UP:
                    filterOnTouchUp();
                    mIsDragging = false;
                    break;

                case MotionEvent.ACTION_CANCEL:
                    mIsDragging = false;
                    break;
            }
            return true;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.152 -0500", hash_original_method = "A2059A5EB773F7552F7C3D2AAFE1E47B", hash_generated_method = "934A5209AD27C5E9159103EE12F3EA67")
        
public boolean isDragging() {
            return mIsDragging;
        }

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.154 -0500", hash_original_method = "5C16B6634DA5CEF817B70D10C5EDCDFD", hash_generated_method = "5C16B6634DA5CEF817B70D10C5EDCDFD")
        
void onHandleMoved() {
            hideActionPopupWindow();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.156 -0500", hash_original_method = "0744EFF256BE5CA55B7C747C6AB06865", hash_generated_method = "725C9E632EBA72694E0868215B8FD2A6")
        
public void onDetached() {
            hideActionPopupWindow();
        }
    }

    private class InsertionHandleView extends HandleView {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.165 -0500", hash_original_field = "91C7434F4BD696DEE4A305599B811EBD", hash_generated_field = "6C20793C8F6CDE2B4C4C7A5C8F5C1B65")

        private static final int DELAY_BEFORE_HANDLE_FADES_OUT = 4000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.168 -0500", hash_original_field = "FF779C1E40891D529D06D4F7D00DEDA6", hash_generated_field = "F31F61562A37EF5E0681F9FDEFBC7D4B")

        private static final int RECENT_CUT_COPY_DURATION = 15 * 1000;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.779 -0400", hash_original_field = "E112B12E6D91B6522B4D9A9D3C4682F9", hash_generated_field = "096F0842C4660386417099FC96034322")

        private float mDownPositionX;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.779 -0400", hash_original_field = "B61BFF081F30765551C8F83D5FE6EC6E", hash_generated_field = "70F6109386E0D3A8FC8471F06A6A2F6D")

        private float mDownPositionY;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.172 -0500", hash_original_field = "2CE26B0B5E9D902214E8A083D4A15AD4", hash_generated_field = "1E652DE5CA4B75E782FE33512F595202")

        private Runnable mHider;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.175 -0500", hash_original_method = "F74814C2C752895D626389ECC5F1998A", hash_generated_method = "6B003170FBD61F321D4A1FE310D4FA69")
        
public InsertionHandleView(Drawable drawable) {
            super(drawable, drawable);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.177 -0500", hash_original_method = "0F6B36BAB7494929112A1B2A0EAC8D6C", hash_generated_method = "9EFD51E6B250304A0B532EE1A1174641")
        
@Override
        public void show() {
         /*   super.show();

            final long durationSinceCutOrCopy = SystemClock.uptimeMillis() - sLastCutOrCopyTime;
            if (durationSinceCutOrCopy < RECENT_CUT_COPY_DURATION) {
                showActionPopupWindow(0);
            }

            hideAfterDelay();*/
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.180 -0500", hash_original_method = "59B6A837BA01A6E9F2644C670D997B83", hash_generated_method = "1BF6184BF9B4E6FF6F7F5FFEDE9126A1")
        
public void showWithActionPopup() {
            show();
            showActionPopupWindow(0);
        }
        
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.780 -0400", hash_original_method = "60FC6C1FF502D89543DDAA49F0EA3292", hash_generated_method = "C0FB9B494F1E5467E2B21D2F3ADD0A6B")
        private void hideAfterDelay() {
            removeHiderCallback();
            if(mHider == null)            
            {
                mHider = new Runnable() {
                    @DSSafe(DSCat.SAFE_LIST)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.183 -0500", hash_original_method = "21815FA27ABEB649DED6A46E4F97905B", hash_generated_method = "9139AD50522A4FA227B3E2A4D707A8E7")
                    
public void run() {
                        hide();
                    }
                };
            } //End block
            TextView.this.postDelayed(mHider, DELAY_BEFORE_HANDLE_FADES_OUT);
            // ---------- Original Method ----------
            //removeHiderCallback();
            //if (mHider == null) {
            //mHider = new Runnable() {
            //public void run() {
            //hide();
            //}
            //};
            //}
            //TextView.this.postDelayed(mHider, DELAY_BEFORE_HANDLE_FADES_OUT);
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.187 -0500", hash_original_method = "C682D1056E8259D8BAEA8A544AED7A4D", hash_generated_method = "379D4D8FEA9FE8838A10B2020FF04205")
        
private void removeHiderCallback() {
            if (mHider != null) {
                TextView.this.removeCallbacks(mHider);
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.190 -0500", hash_original_method = "6DC2E28231BC586AA27A394F083E414A", hash_generated_method = "D30898DD4BA7E3B025C0C7B0DA011F46")
        
@Override
        protected int getHotspotX(Drawable drawable, boolean isRtlRun) {
            return drawable.getIntrinsicWidth() / 2;
        }

        @DSSafe(DSCat.ANDROID_CALLBACK)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.193 -0500", hash_original_method = "0786A2C72AD62CB255408C178910DEC1", hash_generated_method = "2CBF3B7886B566CDCE7B2A10E9348CC4")
        
@Override
        public boolean onTouchEvent(MotionEvent ev) {
            final boolean result = super.onTouchEvent(ev);

            switch (ev.getActionMasked()) {
                case MotionEvent.ACTION_DOWN:
                    mDownPositionX = ev.getRawX();
                    mDownPositionY = ev.getRawY();
                    break;

                case MotionEvent.ACTION_UP:
                    if (!offsetHasBeenChanged()) {
                        final float deltaX = mDownPositionX - ev.getRawX();
                        final float deltaY = mDownPositionY - ev.getRawY();
                        final float distanceSquared = deltaX * deltaX + deltaY * deltaY;
                        if (distanceSquared < mSquaredTouchSlopDistance) {
                            if (mActionPopupWindow != null && mActionPopupWindow.isShowing()) {
                                // Tapping on the handle dismisses the displayed action popup
                                mActionPopupWindow.hide();
                            } else {
                                showWithActionPopup();
                            }
                        }
                    }
                    hideAfterDelay();
                    break;

                case MotionEvent.ACTION_CANCEL:
                    hideAfterDelay();
                    break;

                default:
                    break;
            }

            return result;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.196 -0500", hash_original_method = "CA0934B91A8FE7B0CF5B9D9FD475827B", hash_generated_method = "A574CB0909A8011ED8F86DAA04E206FB")
        
@Override
        public int getCurrentCursorOffset() {
            return TextView.this.getSelectionStart();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.199 -0500", hash_original_method = "A55C2EA19B8C1EC0135F14E2406421A5", hash_generated_method = "F02E6E377B8DC3EEF8E2019CDC8B346B")
        
@Override
        public void updateSelection(int offset) {
            Selection.setSelection((Spannable) mText, offset);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.201 -0500", hash_original_method = "76FEC5259BD2EF7A10D2C6D9447263AD", hash_generated_method = "58A657B0ED096BB5414538EB2169C859")
        
@Override
        public void updatePosition(float x, float y) {
            positionAtCursorOffset(getOffsetForPosition(x, y), false);
        }

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.203 -0500", hash_original_method = "DF26232D8C6513289215597105F4C19A", hash_generated_method = "EA582C6E89D6998B005AEE2E8C0511C4")
        
@Override
        void onHandleMoved() {
            super.onHandleMoved();
            removeHiderCallback();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.206 -0500", hash_original_method = "58D1696EBF955B571F830BA2F6EDC257", hash_generated_method = "D85891CFB8DE188632B32ADC821EC7B0")
        
@Override
        public void onDetached() {
            super.onDetached();
            removeHiderCallback();
        }
    }

    private class SelectionStartHandleView extends HandleView {

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.212 -0500", hash_original_method = "83BC78691BC747F1E4426492F397A3E5", hash_generated_method = "1975571AF4C60F87FB3FAEB82B5374BB")
        
public SelectionStartHandleView(Drawable drawableLtr, Drawable drawableRtl) {
            super(drawableLtr, drawableRtl);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.214 -0500", hash_original_method = "E4FEF24C3E269A0B427919DBE201803F", hash_generated_method = "B47B2D8009BB3D3DA4DA515CABB6D79F")
        
@Override
        protected int getHotspotX(Drawable drawable, boolean isRtlRun) {
            if (isRtlRun) {
                return drawable.getIntrinsicWidth() / 4;
            } else {
                return (drawable.getIntrinsicWidth() * 3) / 4;
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.216 -0500", hash_original_method = "CA0934B91A8FE7B0CF5B9D9FD475827B", hash_generated_method = "A574CB0909A8011ED8F86DAA04E206FB")
        
@Override
        public int getCurrentCursorOffset() {
            return TextView.this.getSelectionStart();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.219 -0500", hash_original_method = "E42DF79873294756C3452434D16E6BD3", hash_generated_method = "59A256A9AC67614CD01BAC71D6C52001")
        
@Override
        public void updateSelection(int offset) {
            Selection.setSelection((Spannable) mText, offset, getSelectionEnd());
            updateDrawable();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.221 -0500", hash_original_method = "7B45D907648A79384D6568EC81E6D22D", hash_generated_method = "11EBE182140F2F09CE03E98A27E3ED3C")
        
@Override
        public void updatePosition(float x, float y) {
            int offset = getOffsetForPosition(x, y);

            // Handles can not cross and selection is at least one character
            final int selectionEnd = getSelectionEnd();
            if (offset >= selectionEnd) offset = Math.max(0, selectionEnd - 1);

            positionAtCursorOffset(offset, false);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.224 -0500", hash_original_method = "0C631CE72876F998F945C3B67884BC26", hash_generated_method = "BEEF0F70B63355243FE7E8A23AEFF21F")
        
public ActionPopupWindow getActionPopupWindow() {
            return mActionPopupWindow;
        }

    }

    private class SelectionEndHandleView extends HandleView {

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.230 -0500", hash_original_method = "883DF21D67E4B772D6E1A322F4D5F533", hash_generated_method = "8B14E8EAD418E8907260AD7BE1BFEC94")
        
public SelectionEndHandleView(Drawable drawableLtr, Drawable drawableRtl) {
            super(drawableLtr, drawableRtl);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.232 -0500", hash_original_method = "6A8A8B43FF48B8BB585E51FD6E86C9E2", hash_generated_method = "DB2A9F37CC51A687C0D1D35DE4F2F417")
        
@Override
        protected int getHotspotX(Drawable drawable, boolean isRtlRun) {
            if (isRtlRun) {
                return (drawable.getIntrinsicWidth() * 3) / 4;
            } else {
                return drawable.getIntrinsicWidth() / 4;
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.235 -0500", hash_original_method = "CA6DDFB8F86FC43076502B090D003904", hash_generated_method = "AE576C2572B67DDCB6FEA9D3F76EA19C")
        
@Override
        public int getCurrentCursorOffset() {
            return TextView.this.getSelectionEnd();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.237 -0500", hash_original_method = "B3473CE6965F2521B605BA0101D0A91A", hash_generated_method = "21DE117B8C8424ED2D209D252FD05438")
        
@Override
        public void updateSelection(int offset) {
            Selection.setSelection((Spannable) mText, getSelectionStart(), offset);
            updateDrawable();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.239 -0500", hash_original_method = "DE26EB392137324C128BF7B92FEE748A", hash_generated_method = "E3492A7A384D66FF9176A8AE0AA0FA88")
        
@Override
        public void updatePosition(float x, float y) {
            int offset = getOffsetForPosition(x, y);

            // Handles can not cross and selection is at least one character
            final int selectionStart = getSelectionStart();
            if (offset <= selectionStart) offset = Math.min(selectionStart + 1, mText.length());

            positionAtCursorOffset(offset, false);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.242 -0500", hash_original_method = "1AE0953CF1E401F1791B2AA9D0C762E1", hash_generated_method = "F96A05C8CEE6B998A6DA3B5A6757D023")
        
public void setActionPopupWindow(ActionPopupWindow actionPopupWindow) {
            mActionPopupWindow = actionPopupWindow;
        }

    }

    private class InsertionPointCursorController implements CursorController {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.249 -0500", hash_original_field = "2DF32AF9477A8C8DA5ABD456C0DA31A0", hash_generated_field = "25F2B1ECCF00A4687A034C77E527EB90")

        private InsertionHandleView mHandle;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.790 -0400", hash_original_method = "85F6797FDF607C95B81DF68401917B00", hash_generated_method = "85F6797FDF607C95B81DF68401917B00")
        public InsertionPointCursorController ()
        {
            //Synthesized constructor
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.251 -0500", hash_original_method = "5D45AEF69914729B932C554DDDCEB4D3", hash_generated_method = "EC94BCD1C8CE914D8A48ABD19866CE99")
        
public void show() {
            getHandle().show();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.254 -0500", hash_original_method = "BEDA636D814D43341B0837622BB75D12", hash_generated_method = "61528F25B15AE0283D02698E624FF8E5")
        
public void showWithActionPopup() {
            getHandle().showWithActionPopup();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.256 -0500", hash_original_method = "99DAD3C319227F2A1F78AE95D96BD2B3", hash_generated_method = "75DB7F01147CCD9BE41028AF9AE2CC54")
        
public void hide() {
            if (mHandle != null) {
                mHandle.hide();
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.259 -0500", hash_original_method = "43F562659DF9586EE8DC985200A1394B", hash_generated_method = "7D809C691CED5DEF5CFB44D2BBC3B33F")
        
public void onTouchModeChanged(boolean isInTouchMode) {
            if (!isInTouchMode) {
                hide();
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.261 -0500", hash_original_method = "AFBF832B3C2DD5F3EC6366306B6BB027", hash_generated_method = "3B814F33875EB9702AAD11CB846ED6B7")
        
private InsertionHandleView getHandle() {
            if (mSelectHandleCenter == null) {
                mSelectHandleCenter = mContext.getResources().getDrawable(
                        mTextSelectHandleRes);
            }
            if (mHandle == null) {
                mHandle = new InsertionHandleView(mSelectHandleCenter);
            }
            return mHandle;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.263 -0500", hash_original_method = "5CA35A7F100FC077200BA56F0D1F67CB", hash_generated_method = "B49F67C44A09E7949A39C7F1BD4CB80D")
        
@Override
        public void onDetached() {
            final ViewTreeObserver observer = getViewTreeObserver();
            observer.removeOnTouchModeChangeListener(this);

            if (mHandle != null) mHandle.onDetached();
        }

    }

    private class SelectionModifierCursorController implements CursorController {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.268 -0500", hash_original_field = "AC7143692E8894590C24FE3E3F251060", hash_generated_field = "8C0DD79BB03BF5A19DC440BA5A7C743D")

        private static final int DELAY_BEFORE_REPLACE_ACTION = 200;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.271 -0500", hash_original_field = "E2FB4AF24CA917D2CC3E127A2F3D42C7", hash_generated_field = "D5D847CA48A8951841CED46080C5C4F2")

        // The cursor controller handles, lazily created when shown.
        private SelectionStartHandleView mStartHandle;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.273 -0500", hash_original_field = "540327E431B69FFF227846326B4AB2E0", hash_generated_field = "19A28AD860044ACC5058053954B56AC1")

        private SelectionEndHandleView mEndHandle;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.791 -0400", hash_original_field = "17546985D71D9022C1E12FDE1CAFC6E5", hash_generated_field = "6FCDDDBC590A39D5D0BCAFDBA6EA63E5")

        private int mMinTouchOffset;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.791 -0400", hash_original_field = "690ACF87EFB1963C7A4637EB14226F0B", hash_generated_field = "F147B97F09325CC9B6538D3E5D26C2FE")

        private int mMaxTouchOffset;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.278 -0500", hash_original_field = "963329A0F053C805E7BFB3B8EA790B97", hash_generated_field = "7CECB42F787323EA52A439F784FC8CBE")

        private long mPreviousTapUpTime = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.791 -0400", hash_original_field = "868B14065502FE9C1E526C78E73FCAF9", hash_generated_field = "0BA74B206DFC70E28F82C95A0E3C40BF")

        private float mPreviousTapPositionX;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.791 -0400", hash_original_field = "78D2D33220DDE6DE9E8A068208CC3141", hash_generated_field = "1F4747912771D340E5AE19794AD2D9A3")

        private float mPreviousTapPositionY;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.283 -0500", hash_original_method = "7762686ED4BD194662F98430835FCC93", hash_generated_method = "7762686ED4BD194662F98430835FCC93")
        
SelectionModifierCursorController() {
            resetTouchOffsets();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.285 -0500", hash_original_method = "803DF98A86477F9509B518860444CA62", hash_generated_method = "377F1B78A4D79C21EC12C83672A68525")
        
public void show() {
            if (isInBatchEditMode()) {
                return;
            }
            initDrawables();
            initHandles();
            hideInsertionPointCursorController();
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.288 -0500", hash_original_method = "2C322B9176F95E96CE86AF105C0AA144", hash_generated_method = "F031EF889939C9F4B76335D1A018AFC0")
        
private void initDrawables() {
            if (mSelectHandleLeft == null) {
                mSelectHandleLeft = mContext.getResources().getDrawable(
                        mTextSelectHandleLeftRes);
            }
            if (mSelectHandleRight == null) {
                mSelectHandleRight = mContext.getResources().getDrawable(
                        mTextSelectHandleRightRes);
            }
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.290 -0500", hash_original_method = "C3351664D38EE8E6983EFA56F5011D2A", hash_generated_method = "489604820EED09C4B119A7213DF455BB")
        
private void initHandles() {
            // Lazy object creation has to be done before updatePosition() is called.
            if (mStartHandle == null) {
                mStartHandle = new SelectionStartHandleView(mSelectHandleLeft, mSelectHandleRight);
            }
            if (mEndHandle == null) {
                mEndHandle = new SelectionEndHandleView(mSelectHandleRight, mSelectHandleLeft);
            }

            mStartHandle.show();
            mEndHandle.show();

            // Make sure both left and right handles share the same ActionPopupWindow (so that
            // moving any of the handles hides the action popup).
            mStartHandle.showActionPopupWindow(DELAY_BEFORE_REPLACE_ACTION);
            mEndHandle.setActionPopupWindow(mStartHandle.getActionPopupWindow());

            hideInsertionPointCursorController();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.293 -0500", hash_original_method = "9904AE40606D29E60FAC10481978E041", hash_generated_method = "9A89A5CC20F7790098A72141AC5750D9")
        
public void hide() {
            if (mStartHandle != null) mStartHandle.hide();
            if (mEndHandle != null) mEndHandle.hide();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.296 -0500", hash_original_method = "4BB059019645E4258A18514D6F6D1609", hash_generated_method = "057946A489C10961FE7CE4AF3EBC2AB1")
        
public void onTouchEvent(MotionEvent event) {
            // This is done even when the View does not have focus, so that long presses can start
            // selection and tap can move cursor from this tap position.
            switch (event.getActionMasked()) {
                case MotionEvent.ACTION_DOWN:
                    final float x = event.getX();
                    final float y = event.getY();

                    // Remember finger down position, to be able to start selection from there
                    mMinTouchOffset = mMaxTouchOffset = getOffsetForPosition(x, y);

                    // Double tap detection
                    long duration = SystemClock.uptimeMillis() - mPreviousTapUpTime;
                    if (duration <= ViewConfiguration.getDoubleTapTimeout() &&
                            isPositionOnText(x, y)) {
                        final float deltaX = x - mPreviousTapPositionX;
                        final float deltaY = y - mPreviousTapPositionY;
                        final float distanceSquared = deltaX * deltaX + deltaY * deltaY;
                        if (distanceSquared < mSquaredTouchSlopDistance) {
                            startSelectionActionMode();
                            mDiscardNextActionUp = true;
                        }
                    }

                    mPreviousTapPositionX = x;
                    mPreviousTapPositionY = y;
                    break;

                case MotionEvent.ACTION_POINTER_DOWN:
                case MotionEvent.ACTION_POINTER_UP:
                    // Handle multi-point gestures. Keep min and max offset positions.
                    // Only activated for devices that correctly handle multi-touch.
                    if (mContext.getPackageManager().hasSystemFeature(
                            PackageManager.FEATURE_TOUCHSCREEN_MULTITOUCH_DISTINCT)) {
                        updateMinAndMaxOffsets(event);
                    }
                    break;

                case MotionEvent.ACTION_UP:
                    mPreviousTapUpTime = SystemClock.uptimeMillis();
                    break;
            }
        }

        /**
         * @param event
         */
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.298 -0500", hash_original_method = "ABEB7C98C3FEAD2725211345FA5A10D0", hash_generated_method = "3C36B88705057568D988AC12BA8AFCEE")
        
private void updateMinAndMaxOffsets(MotionEvent event) {
            int pointerCount = event.getPointerCount();
            for (int index = 0; index < pointerCount; index++) {
                int offset = getOffsetForPosition(event.getX(index), event.getY(index));
                if (offset < mMinTouchOffset) mMinTouchOffset = offset;
                if (offset > mMaxTouchOffset) mMaxTouchOffset = offset;
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.301 -0500", hash_original_method = "CE1D6B62E449D2E0E68A6EA4156BEDFA", hash_generated_method = "EDCA85237CBBC566F55F2B92C0C7619D")
        
public int getMinTouchOffset() {
            return mMinTouchOffset;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.303 -0500", hash_original_method = "C55B3C28483F8C218641DDDF4F4BCFF7", hash_generated_method = "3DC0A88D65F96F34F8C52B797CE6FC38")
        
public int getMaxTouchOffset() {
            return mMaxTouchOffset;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.305 -0500", hash_original_method = "4C87B6BF406B366B26A5C4FE4B60E794", hash_generated_method = "76D997C248416799A4F3890A74C98463")
        
public void resetTouchOffsets() {
            mMinTouchOffset = mMaxTouchOffset = -1;
        }

        /**
         * @return true iff this controller is currently used to move the selection start.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.307 -0500", hash_original_method = "CED25BB71024452A25A320AF88BD1346", hash_generated_method = "CA74757E2F3FBE20C558F4B34C62FF1A")
        
public boolean isSelectionStartDragged() {
            return mStartHandle != null && mStartHandle.isDragging();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.309 -0500", hash_original_method = "43F562659DF9586EE8DC985200A1394B", hash_generated_method = "7D809C691CED5DEF5CFB44D2BBC3B33F")
        
public void onTouchModeChanged(boolean isInTouchMode) {
            if (!isInTouchMode) {
                hide();
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.312 -0500", hash_original_method = "190B38DD5A1110FFE55D8237DE7DCE67", hash_generated_method = "EE3652F16BC7DE1628158298ABC98247")
        
@Override
        public void onDetached() {
            final ViewTreeObserver observer = getViewTreeObserver();
            observer.removeOnTouchModeChangeListener(this);

            if (mStartHandle != null) mStartHandle.onDetached();
            if (mEndHandle != null) mEndHandle.onDetached();
        }
    }

    public interface OnEditorActionListener {

        @DSVerified
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        boolean onEditorAction(TextView v, int actionId, KeyEvent event);
    }

    private interface TextViewPositionListener {
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public void updatePosition(int parentPositionX, int parentPositionY,
                                   boolean parentPositionChanged, boolean parentScrolled);
    }

    private interface CursorController extends ViewTreeObserver.OnTouchModeChangeListener {

        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public void show();

        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public void hide();

        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public void onDetached();
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.971 -0500", hash_original_method = "97397C66433481C877E194A1E7813AF3", hash_generated_method = "97397C66433481C877E194A1E7813AF3")
    
void showSuggestions() {
        if (mSuggestionsPopupWindow == null) {
            mSuggestionsPopupWindow = new SuggestionsPopupWindow();
        }
        hideControllers();
        mSuggestionsPopupWindow.show();
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.973 -0500", hash_original_method = "E5A6F19BA20AF228602A3EAA320E6192", hash_generated_method = "E5A6F19BA20AF228602A3EAA320E6192")
    
boolean areSuggestionsShown() {
        return mSuggestionsPopupWindow != null && mSuggestionsPopupWindow.isShowing();
    }

    /**
     * Return whether or not suggestions are enabled on this TextView. The suggestions are generated
     * by the IME or by the spell checker as the user types. This is done by adding
     * {@link SuggestionSpan}s to the text.
     *
     * When suggestions are enabled (default), this list of suggestions will be displayed when the
     * user asks for them on these parts of the text. This value depends on the inputType of this
     * TextView.
     *
     * The class of the input type must be {@link InputType#TYPE_CLASS_TEXT}.
     *
     * In addition, the type variation must be one of
     * {@link InputType#TYPE_TEXT_VARIATION_NORMAL},
     * {@link InputType#TYPE_TEXT_VARIATION_EMAIL_SUBJECT},
     * {@link InputType#TYPE_TEXT_VARIATION_LONG_MESSAGE},
     * {@link InputType#TYPE_TEXT_VARIATION_SHORT_MESSAGE} or
     * {@link InputType#TYPE_TEXT_VARIATION_WEB_EDIT_TEXT}.
     *
     * And finally, the {@link InputType#TYPE_TEXT_FLAG_NO_SUGGESTIONS} flag must <i>not</i> be set.
     *
     * @return true if the suggestions popup window is enabled, based on the inputType.
     */
    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.975 -0500", hash_original_method = "25A5AF708197CD0F2143471E812F624E", hash_generated_method = "2F93B971BD4FD74C03172FA6A2ECE222")
    
public boolean isSuggestionsEnabled() {
        if ((mInputType & InputType.TYPE_MASK_CLASS) != InputType.TYPE_CLASS_TEXT) return false;
        if ((mInputType & InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS) > 0) return false;

        final int variation = mInputType & EditorInfo.TYPE_MASK_VARIATION;
        return (variation == EditorInfo.TYPE_TEXT_VARIATION_NORMAL ||
                variation == EditorInfo.TYPE_TEXT_VARIATION_EMAIL_SUBJECT ||
                variation == EditorInfo.TYPE_TEXT_VARIATION_LONG_MESSAGE ||
                variation == EditorInfo.TYPE_TEXT_VARIATION_SHORT_MESSAGE ||
                variation == EditorInfo.TYPE_TEXT_VARIATION_WEB_EDIT_TEXT);
    }

    /**
     * If provided, this ActionMode.Callback will be used to create the ActionMode when text
     * selection is initiated in this View.
     *
     * The standard implementation populates the menu with a subset of Select All, Cut, Copy and
     * Paste actions, depending on what this View supports.
     *
     * A custom implementation can add new entries in the default menu in its
     * {@link android.view.ActionMode.Callback#onPrepareActionMode(ActionMode, Menu)} method. The
     * default actions can also be removed from the menu using {@link Menu#removeItem(int)} and
     * passing {@link android.R.id#selectAll}, {@link android.R.id#cut}, {@link android.R.id#copy}
     * or {@link android.R.id#paste} ids as parameters.
     *
     * Returning false from 
     * {@link android.view.ActionMode.Callback#onCreateActionMode(ActionMode, Menu)} will prevent
     * the action mode from being started.
     *
     * Action click events should be handled by the custom implementation of
     * {@link android.view.ActionMode.Callback#onActionItemClicked(ActionMode, MenuItem)}.
     *
     * Note that text selection mode is not started when a TextView receives focus and the
     * {@link android.R.attr#selectAllOnFocus} flag has been set. The content is highlighted in
     * that case, to allow for quick replacement.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.978 -0500", hash_original_method = "9876FACCD4EAE43EA4CB6FD414FD5E5A", hash_generated_method = "92B124469681B25A23E5C55AFDFFE393")
    
public void setCustomSelectionActionModeCallback(ActionMode.Callback actionModeCallback) {
        mCustomSelectionActionModeCallback = actionModeCallback;
        if (actionModeCallback != null) {
            
        }
    }

    /**
     * Retrieves the value set in {@link #setCustomSelectionActionModeCallback}. Default is null.
     *
     * @return The current custom selection callback.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.980 -0500", hash_original_method = "6671930C0B8994CBEF8AFBE835B485C8", hash_generated_method = "CAE7EC34EDCF1D96CE21EFB64BBA1D98")
    
public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return mCustomSelectionActionModeCallback;
    }

    /**
     *
     * @return true if the selection mode was actually started.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.983 -0500", hash_original_method = "B9B1CE7E81D0AD0E9224682576CA1ABE", hash_generated_method = "2A67FBA7E3B2A6D5EBE0773B674D98A7")
    
private boolean startSelectionActionMode() {
        if (mSelectionActionMode != null) {
            // Selection action mode is already started
            return false;
        }

        if (!canSelectText() || !requestFocus()) {
            Log.w(LOG_TAG, "TextView does not support text selection. Action mode cancelled.");
            return false;
        }

        if (!hasSelection()) {
            // There may already be a selection on device rotation
            if (!selectCurrentWord()) {
                // No word found under cursor or text selection not permitted.
                return false;
            }
        }

        boolean willExtract = extractedTextModeWillBeStarted();

        // Do not start the action mode when extracted text will show up full screen, thus
        // immediately hiding the newly created action bar, which would be visually distracting.
        if (!willExtract) {
            ActionMode.Callback actionModeCallback = new SelectionActionModeCallback();
            mSelectionActionMode = startActionMode(actionModeCallback);
        }

        final boolean selectionStarted = mSelectionActionMode != null || willExtract;
        if (selectionStarted && !mTextIsSelectable && mSoftInputShownOnFocus) {
            // Show the IME to be able to replace text, except when selecting non editable text.
            final InputMethodManager imm = InputMethodManager.peekInstance();
            if (imm != null) {
                imm.showSoftInput(this, 0, null);
            }
        }

        return selectionStarted;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.986 -0500", hash_original_method = "F292596F6DB6F0A1BCB4946717902139", hash_generated_method = "CC16D25410ECEC34241D73E3CC97C9D8")
    
private boolean extractedTextModeWillBeStarted() {
        if (!(this instanceof ExtractEditText)) {
            final InputMethodManager imm = InputMethodManager.peekInstance();
            return  imm != null && imm.isFullscreenMode();
        }
        return false;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.988 -0500", hash_original_method = "9843C3F333617B8C113B72E2C38319BA", hash_generated_method = "3CAF6C6F803981B26A86059F40C7FA82")
    
private void stopSelectionActionMode() {
        if (mSelectionActionMode != null) {
            // This will hide the mSelectionModifierCursorController
            mSelectionActionMode.finish();
        }
    }

    /**
     * Paste clipboard content between min and max positions.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.991 -0500", hash_original_method = "FD893A1B640E2E356DBE924FBE58EA4D", hash_generated_method = "003CAD3BE8AC76BDCFA4D225F1A939EA")
    
private void paste(int min, int max) {
        ClipboardManager clipboard =
            (ClipboardManager) getContext().getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = clipboard.getPrimaryClip();
        if (clip != null) {
            boolean didFirst = false;
            for (int i=0; i<clip.getItemCount(); i++) {
                CharSequence paste = clip.getItemAt(i).coerceToText(getContext());
                if (paste != null) {
                    if (!didFirst) {
                        long minMax = prepareSpacesAroundPaste(min, max, paste);
                        min = extractRangeStartFromLong(minMax);
                        max = extractRangeEndFromLong(minMax);
                        Selection.setSelection((Spannable) mText, max);
                        ((Editable) mText).replace(min, max, paste);
                        didFirst = true;
                    } else {
                        ((Editable) mText).insert(getSelectionEnd(), "\n");
                        ((Editable) mText).insert(getSelectionEnd(), paste);
                    }
                }
            }
            stopSelectionActionMode();
            sLastCutOrCopyTime = 0;
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:19.993 -0500", hash_original_method = "8BE6A63416328BC319B0B5D0DB32AF7B", hash_generated_method = "81E809BBC5305F25C746B5503E2E356C")
    
private void setPrimaryClip(ClipData clip) {
        ClipboardManager clipboard = (ClipboardManager) getContext().
                getSystemService(Context.CLIPBOARD_SERVICE);
        clipboard.setPrimaryClip(clip);
        sLastCutOrCopyTime = SystemClock.uptimeMillis();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.317 -0500", hash_original_method = "EC32E229F62759229A3F9E53D2729660", hash_generated_method = "692ECE93D57D8D9B4F5AAB12BA86F82C")
    
private void hideInsertionPointCursorController() {
        // No need to create the controller to hide it.
        if (mInsertionPointCursorController != null) {
            mInsertionPointCursorController.hide();
        }
    }

    /**
     * Hides the insertion controller and stops text selection mode, hiding the selection controller
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.320 -0500", hash_original_method = "24BE7797312EE966374B6FFCFBB4586E", hash_generated_method = "D6426D43EF2AA9577C84FBC20E54DB09")
    
private void hideControllers() {
        hideCursorControllers();
        hideSpanControllers();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.322 -0500", hash_original_method = "49CA1E2702021EF560B250FA375633C6", hash_generated_method = "1D5A15E72A8A506C572DC761F3CE0F3D")
    
private void hideSpanControllers() {
        if (mChangeWatcher != null) {
            mChangeWatcher.hideControllers();
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.324 -0500", hash_original_method = "1E18C93748F74C8EE354333AE329FDA3", hash_generated_method = "D71171C226C635D8F7375BFE65C0099D")
    
private void hideCursorControllers() {
        if (mSuggestionsPopupWindow != null && !mSuggestionsPopupWindow.isShowingUp()) {
            // Should be done before hide insertion point controller since it triggers a show of it
            mSuggestionsPopupWindow.hide();
        }
        hideInsertionPointCursorController();
        stopSelectionActionMode();
    }
    static {
        Paint p = new Paint();
        p.setAntiAlias(true);
        p.measureText("H");
    }

    /**
     * Get the character offset closest to the specified absolute position. A typical use case is to
     * pass the result of {@link MotionEvent#getX()} and {@link MotionEvent#getY()} to this method.
     *
     * @param x The horizontal absolute position of a point on screen
     * @param y The vertical absolute position of a point on screen
     * @return the character offset for the character whose position is closest to the specified
     *  position. Returns -1 if there is no layout.
     */
    @DSComment("TextView, check callbacks modeled")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.326 -0500", hash_original_method = "3AC7FDA43CAD0B3033F953FC5E229096", hash_generated_method = "A25558BBE17A595E2FC6DE1573A0FB76")
    
public int getOffsetForPosition(float x, float y) {
        if (getLayout() == null) return -1;
        final int line = getLineAtCoordinate(y);
        final int offset = getOffsetAtCoordinate(line, x);
        return offset;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.329 -0500", hash_original_method = "C0F2EACF537DEE598E512FB7710303B4", hash_generated_method = "459052ED6610D7F03269985A2149CBE6")
    
private float convertToLocalHorizontalCoordinate(float x) {
        x -= getTotalPaddingLeft();
        // Clamp the position to inside of the view.
        x = Math.max(0.0f, x);
        x = Math.min(getWidth() - getTotalPaddingRight() - 1, x);
        x += getScrollX();
        return x;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.332 -0500", hash_original_method = "69F0EDA2749521F4A39C0BEAC846F1E5", hash_generated_method = "E24324044857D124C817094DC42A7FB5")
    
private int getLineAtCoordinate(float y) {
        y -= getTotalPaddingTop();
        // Clamp the position to inside of the view.
        y = Math.max(0.0f, y);
        y = Math.min(getHeight() - getTotalPaddingBottom() - 1, y);
        y += getScrollY();
        return getLayout().getLineForVertical((int) y);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.334 -0500", hash_original_method = "78600135096D77C91825CF9049D3F243", hash_generated_method = "C75019E42738EC2296264E45AC24B5CF")
    
private int getOffsetAtCoordinate(int line, float x) {
        x = convertToLocalHorizontalCoordinate(x);
        return getLayout().getOffsetForHorizontal(line, x);
    }

    /** Returns true if the screen coordinates position (x,y) corresponds to a character displayed
     * in the view. Returns false when the position is in the empty space of left/right of text.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.336 -0500", hash_original_method = "B77333C8EDA86B5BA4A004A4B129217A", hash_generated_method = "E6FC9ED6DF482DD5FB26C2C8DB4219E1")
    
private boolean isPositionOnText(float x, float y) {
        if (getLayout() == null) return false;

        final int line = getLineAtCoordinate(y);
        x = convertToLocalHorizontalCoordinate(x);

        if (x < getLayout().getLineLeft(line)) return false;
        if (x > getLayout().getLineRight(line)) return false;
        return true;
    }

    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.339 -0500", hash_original_method = "282C8F5427700D40A542E64F343C6674", hash_generated_method = "2379B60EFA0DC457302FBE4CE880DDC5")
    
@Override
    public boolean onDragEvent(DragEvent event) {
        switch (event.getAction()) {
            case DragEvent.ACTION_DRAG_STARTED:
                return hasInsertionController();

            case DragEvent.ACTION_DRAG_ENTERED:
                TextView.this.requestFocus();
                return true;

            case DragEvent.ACTION_DRAG_LOCATION:
                final int offset = getOffsetForPosition(event.getX(), event.getY());
                Selection.setSelection((Spannable)mText, offset);
                return true;

            case DragEvent.ACTION_DROP:
                onDrop(event);
                return true;

            case DragEvent.ACTION_DRAG_ENDED:
            case DragEvent.ACTION_DRAG_EXITED:
            default:
                return true;
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.342 -0500", hash_original_method = "89464BC34879AFE88152B04970AA44D2", hash_generated_method = "6F63A7795D168098E7F0E18048DD24F1")
    
private void onDrop(DragEvent event) {
        StringBuilder content = new StringBuilder("");
        ClipData clipData = event.getClipData();
        final int itemCount = clipData.getItemCount();
        for (int i=0; i < itemCount; i++) {
            Item item = clipData.getItemAt(i);
            content.append(item.coerceToText(TextView.this.mContext));
        }

        final int offset = getOffsetForPosition(event.getX(), event.getY());

        Object localState = event.getLocalState();
        DragLocalState dragLocalState = null;
        if (localState instanceof DragLocalState) {
            dragLocalState = (DragLocalState) localState;
        }
        boolean dragDropIntoItself = dragLocalState != null &&
                dragLocalState.sourceTextView == this;

        if (dragDropIntoItself) {
            if (offset >= dragLocalState.start && offset < dragLocalState.end) {
                // A drop inside the original selection discards the drop.
                return;
            }
        }

        final int originalLength = mText.length();
        long minMax = prepareSpacesAroundPaste(offset, offset, content);
        int min = extractRangeStartFromLong(minMax);
        int max = extractRangeEndFromLong(minMax);

        Selection.setSelection((Spannable) mText, max);
        replaceText_internal(min, max, content);

        if (dragDropIntoItself) {
            int dragSourceStart = dragLocalState.start;
            int dragSourceEnd = dragLocalState.end;
            if (max <= dragSourceStart) {
                // Inserting text before selection has shifted positions
                final int shift = mText.length() - originalLength;
                dragSourceStart += shift;
                dragSourceEnd += shift;
            }

            // Delete original selection
            deleteText_internal(dragSourceStart, dragSourceEnd);

            // Make sure we do not leave two adjacent spaces.
            if ((dragSourceStart == 0 ||
                    Character.isSpaceChar(mTransformed.charAt(dragSourceStart - 1))) &&
                    (dragSourceStart == mText.length() ||
                    Character.isSpaceChar(mTransformed.charAt(dragSourceStart)))) {
                final int pos = dragSourceStart == mText.length() ?
                        dragSourceStart - 1 : dragSourceStart;
                deleteText_internal(pos, pos + 1);
            }
        }
    }

    /**
     * @return True if this view supports insertion handles.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.344 -0500", hash_original_method = "91BB575EAEE11A270473B31B356B5B12", hash_generated_method = "91BB575EAEE11A270473B31B356B5B12")
    
boolean hasInsertionController() {
        return mInsertionControllerEnabled;
    }

    /**
     * @return True if this view supports selection handles.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.346 -0500", hash_original_method = "EE05979336406D2A8CCC57049072454C", hash_generated_method = "EE05979336406D2A8CCC57049072454C")
    
boolean hasSelectionController() {
        return mSelectionControllerEnabled;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.348 -0500", hash_original_method = "02A03A91466BF03F45C3C819266A605E", hash_generated_method = "02A03A91466BF03F45C3C819266A605E")
    
InsertionPointCursorController getInsertionController() {
        if (!mInsertionControllerEnabled) {
            return null;
        }

        if (mInsertionPointCursorController == null) {
            mInsertionPointCursorController = new InsertionPointCursorController();

            final ViewTreeObserver observer = getViewTreeObserver();
            observer.addOnTouchModeChangeListener(mInsertionPointCursorController);
        }

        return mInsertionPointCursorController;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.350 -0500", hash_original_method = "CD09732805D28B5BF513C98008463942", hash_generated_method = "CD09732805D28B5BF513C98008463942")
    
SelectionModifierCursorController getSelectionController() {
        if (!mSelectionControllerEnabled) {
            return null;
        }

        if (mSelectionModifierCursorController == null) {
            mSelectionModifierCursorController = new SelectionModifierCursorController();

            final ViewTreeObserver observer = getViewTreeObserver();
            observer.addOnTouchModeChangeListener(mSelectionModifierCursorController);
        }

        return mSelectionModifierCursorController;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.352 -0500", hash_original_method = "2A090273FA835CA26EC17C458A37DEC8", hash_generated_method = "2A090273FA835CA26EC17C458A37DEC8")
    
boolean isInBatchEditMode() {
        final InputMethodState ims = mInputMethodState;
        if (ims != null) {
            return ims.mBatchEditNesting > 0;
        }
        return mInBatchEditControllers;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.355 -0500", hash_original_method = "6388CB4B4CF218043B88410FEBCF8F11", hash_generated_method = "35D5F0872148D6A49C1C2216036647A2")
    
@Override
    protected void resolveTextDirection() {
        if (hasPasswordTransformationMethod()) {
            mTextDir = TextDirectionHeuristics.LOCALE;
            return;
        }

        // Always need to resolve layout direction first
        final boolean defaultIsRtl = (getResolvedLayoutDirection() == LAYOUT_DIRECTION_RTL);

        // Then resolve text direction on the parent
        super.resolveTextDirection();

        // Now, we can select the heuristic
        int textDir = getResolvedTextDirection();
        switch (textDir) {
            default:
            case TEXT_DIRECTION_FIRST_STRONG:
                mTextDir = (defaultIsRtl ? TextDirectionHeuristics.FIRSTSTRONG_RTL :
                        TextDirectionHeuristics.FIRSTSTRONG_LTR);
                break;
            case TEXT_DIRECTION_ANY_RTL:
                mTextDir = TextDirectionHeuristics.ANYRTL_LTR;
                break;
            case TEXT_DIRECTION_LTR:
                mTextDir = TextDirectionHeuristics.LTR;
                break;
            case TEXT_DIRECTION_RTL:
                mTextDir = TextDirectionHeuristics.RTL;
                break;
        }
    }

    /**
     * Subclasses will need to override this method to implement their own way of resolving
     * drawables depending on the layout direction.
     *
     * A call to the super method will be required from the subclasses implementation.
     *
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.358 -0500", hash_original_method = "E2C9FAE08740394CAC2960942379DB19", hash_generated_method = "DADC4B1C8B09BE4A271131C63A44282F")
    
protected void resolveDrawables() {
        // No need to resolve twice
        if (mResolvedDrawables) {
            return;
        }
        // No drawable to resolve
        if (mDrawables == null) {
            return;
        }
        // No relative drawable to resolve
        if (mDrawables.mDrawableStart == null && mDrawables.mDrawableEnd == null) {
            mResolvedDrawables = true;
            return;
        }

        Drawables dr = mDrawables;
        switch(getResolvedLayoutDirection()) {
            case LAYOUT_DIRECTION_RTL:
                if (dr.mDrawableStart != null) {
                    dr.mDrawableRight = dr.mDrawableStart;

                    dr.mDrawableSizeRight = dr.mDrawableSizeStart;
                    dr.mDrawableHeightRight = dr.mDrawableHeightStart;
                }
                if (dr.mDrawableEnd != null) {
                    dr.mDrawableLeft = dr.mDrawableEnd;

                    dr.mDrawableSizeLeft = dr.mDrawableSizeEnd;
                    dr.mDrawableHeightLeft = dr.mDrawableHeightEnd;
                }
                break;

            case LAYOUT_DIRECTION_LTR:
            default:
                if (dr.mDrawableStart != null) {
                    dr.mDrawableLeft = dr.mDrawableStart;

                    dr.mDrawableSizeLeft = dr.mDrawableSizeStart;
                    dr.mDrawableHeightLeft = dr.mDrawableHeightStart;
                }
                if (dr.mDrawableEnd != null) {
                    dr.mDrawableRight = dr.mDrawableEnd;

                    dr.mDrawableSizeRight = dr.mDrawableSizeEnd;
                    dr.mDrawableHeightRight = dr.mDrawableHeightEnd;
                }
                break;
        }
        mResolvedDrawables = true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.360 -0500", hash_original_method = "18FE12CF478DF44CED567E30FAAD0C93", hash_generated_method = "ADC4D8012C2441D7C1D480D29D70C1D7")
    
protected void resetResolvedDrawables() {
        mResolvedDrawables = false;
    }

    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.363 -0500", hash_original_method = "6AA5A1E8B49AF4D4943616613CE0B2E3", hash_generated_method = "E99C22EA59116712FB6F24C0976595F5")
    
protected void viewClicked(InputMethodManager imm) {
        if (imm != null) {
            imm.viewClicked(this);
        }
    }

    /**
     * Deletes the range of text [start, end[.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.365 -0500", hash_original_method = "D7BCF3915857A038F77C712DE4BFFF5D", hash_generated_method = "C9AF16B505B2F9D446788E1DEF400E39")
    
protected void deleteText_internal(int start, int end) {
        ((Editable) mText).delete(start, end);
    }

    /**
     * Replaces the range of text [start, end[ by replacement text
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.368 -0500", hash_original_method = "2F865B1F2B94D9294078802BAAEABE19", hash_generated_method = "2CD7E3DE1C90613C5077319C6DF2AB05")
    
protected void replaceText_internal(int start, int end, CharSequence text) {
        ((Editable) mText).replace(start, end, text);
    }

    /**
     * Sets a span on the specified range of text
     * @hide
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.370 -0500", hash_original_method = "80E41DC8CAFBEBBFCDBF175A54ED075C", hash_generated_method = "3C66F8CD003E455B8DB2DE2732278824")
    
protected void setSpan_internal(Object span, int start, int end, int flags) {
        ((Editable) mText).setSpan(span, start, end, flags);
    }

    /**
     * Moves the cursor to the specified offset position in text
     * @hide
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:20.372 -0500", hash_original_method = "ED942619162EB0C0AFB16CB348D15185", hash_generated_method = "0B25625E0F9511BCA177109D2E50D45B")
    
protected void setCursorPosition_internal(int start, int end) {
        Selection.setSelection(((Editable) mText), start, end);
    }
}

