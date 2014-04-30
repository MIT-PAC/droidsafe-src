/*
 * Copyright (C) 2011 The Android Open Source Project
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

package android.support.v4.view;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;

import java.lang.ref.WeakReference;

/**
 * PagerTitleStrip is a non-interactive indicator of the current, next,
 * and previous pages of a {@link ViewPager}. It is intended to be used as a
 * child view of a ViewPager widget in your XML layout.
 * Add it as a child of a ViewPager in your layout file and set its
 * android:layout_gravity to TOP or BOTTOM to pin it to the top or bottom
 * of the ViewPager. The title from each page is supplied by the method
 * {@link PagerAdapter#getPageTitle(int)} in the adapter supplied to
 * the ViewPager.
 *
 * <p>For an interactive indicator, see {@link PagerTabStrip}.</p>
 */
public class PagerTitleStrip extends ViewGroup implements ViewPager.Decor {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:19.089 -0500", hash_original_field = "C2EE6479C9887D0BA7A9C8C31BF7EFE5", hash_generated_field = "164E3D6D4AA7EEDF37B3058FD26930B6")

    private static final String TAG = "PagerTitleStrip";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:19.105 -0500", hash_original_field = "82335EE1BEC03B36DC6A2AC07F11DA63", hash_generated_field = "A8654C767D4C14AFF9FCA02480C43040")

    private static final int[] ATTRS = new int[] {
        android.R.attr.textAppearance,
        android.R.attr.textSize,
        android.R.attr.textColor,
        android.R.attr.gravity
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:19.107 -0500", hash_original_field = "E85DAA5F18839F3EB4D6EFAAEB49EDCE", hash_generated_field = "6956ED794238A34B480322E284060485")

    private static final int[] TEXT_ATTRS = new int[] {
        0x0101038c // android.R.attr.textAllCaps
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:19.108 -0500", hash_original_field = "AAF3379FEB1228848EE07B6286AAA9AB", hash_generated_field = "EEFAD9B6C9950C781BDFB1FF111DA31B")

    private static final float SIDE_ALPHA = 0.6f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:19.109 -0500", hash_original_field = "C81215EBF934E1A366D619C0380BD19D", hash_generated_field = "E1365F97F5735C3551DC5975CFC1349F")

    private static final int TEXT_SPACING = 16;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:19.119 -0500", hash_original_field = "F5AFD37F005442D1DA5BECFAE34D10F2", hash_generated_field = "FC43287A1B05CC67CD71D2D929E632B7")

    private static  PagerTitleStripImpl IMPL;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:19.120 -0500", hash_original_method = "8A1039A258802121A36A7EA483714545", hash_generated_method = "EB7F6ED5BA95C3E9550B03050754AAF0")
    
private static void setSingleLineAllCaps(TextView text) {
        IMPL.setSingleLineAllCaps(text);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:19.090 -0500", hash_original_field = "1A8F7587F4799795AFC9E6CF3AD21423", hash_generated_field = "1A8F7587F4799795AFC9E6CF3AD21423")

    ViewPager mPager;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:19.091 -0500", hash_original_field = "758380EDFA6EB374B3DB5871CBD34D35", hash_generated_field = "758380EDFA6EB374B3DB5871CBD34D35")

    TextView mPrevText;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:19.092 -0500", hash_original_field = "D6A93F95F2CD87894EF4AE64A56AB53D", hash_generated_field = "D6A93F95F2CD87894EF4AE64A56AB53D")

    TextView mCurrText;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:19.093 -0500", hash_original_field = "783CD0015D15F39FE9794D515AACDA6C", hash_generated_field = "783CD0015D15F39FE9794D515AACDA6C")

    TextView mNextText;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:19.094 -0500", hash_original_field = "09CB2B0FB30EBEFF47F696BB0E97DE21", hash_generated_field = "90F5F9FB1487026D75D6D5D3AB10A419")

    private int mLastKnownCurrentPage = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:19.096 -0500", hash_original_field = "69D24EDA951514F016F84869EFA2ABD6", hash_generated_field = "CB0C3B4B9C508B6F14C55441D0AD8B91")

    private float mLastKnownPositionOffset = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:19.097 -0500", hash_original_field = "BD91F728160CC1A2726BA55995F06B87", hash_generated_field = "89C52633EF67CCE8BCA882446FF1CD8F")

    private int mScaledTextSpacing;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:19.098 -0500", hash_original_field = "E8D24DE70DE8CB945622B4CE486A90EA", hash_generated_field = "ACF14A395FB2702990553CD0EFA1BDCC")

    private int mGravity;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:19.100 -0500", hash_original_field = "03F2092D9B5049EF80466CF3FCCB54AA", hash_generated_field = "3E47E0ADC999C3364DCD228C5D3CD605")

    private boolean mUpdatingText;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:19.101 -0500", hash_original_field = "5F88EF089749DF9B92D51DD66306AE4E", hash_generated_field = "664984FC99328963C219145CAEA3A509")

    private boolean mUpdatingPositions;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:19.102 -0500", hash_original_field = "ED9D2255D5F7C8970291D49955E4969D", hash_generated_field = "1EFB716647F058CFCB36D954D70AC09A")

    private final PageListener mPageListener = new PageListener();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:19.103 -0500", hash_original_field = "4291F85FF2F5BF7125A9DDF18D846F18", hash_generated_field = "26A2F398E2C092065BC88A0258E63DDF")

    private WeakReference<PagerAdapter> mWatchingAdapter;

    interface PagerTitleStripImpl {
        void setSingleLineAllCaps(TextView text);
    }

    static class PagerTitleStripImplBase implements PagerTitleStripImpl {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:19.115 -0500", hash_original_method = "0CB06A06A9C05B0CCDFA7CD0E85CFD57", hash_generated_method = "EC347066EAA8B6E090F723801C3C066B")
        
public void setSingleLineAllCaps(TextView text) {
            text.setSingleLine();
        }
    }

    static class PagerTitleStripImplIcs implements PagerTitleStripImpl {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:19.117 -0500", hash_original_method = "47ABCBC0DA420E91F72BDDE0CE8B03D5", hash_generated_method = "C4905185FE399E833D5D5B66CEBBC30B")
        
public void setSingleLineAllCaps(TextView text) {
            PagerTitleStripIcs.setSingleLineAllCaps(text);
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:19.111 -0500", hash_original_field = "9804C64E83F313F5DDE5967F03B81389", hash_generated_field = "28DD24027C59F108FB986079494AC102")

    private int mNonPrimaryAlpha;
    static {
        if (android.os.Build.VERSION.SDK_INT >= 14) {
            IMPL = new PagerTitleStripImplIcs();
        } else {
            IMPL = new PagerTitleStripImplBase();
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:19.112 -0500", hash_original_field = "9E1409A112DC65C9353A83D835CDB2FC", hash_generated_field = "9E1409A112DC65C9353A83D835CDB2FC")

    int mTextColor;

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:19.122 -0500", hash_original_method = "58D8374F43287A498EE1AB9EF078D682", hash_generated_method = "B577D5234D9B218F9DE2B292C9C311C1")
    
public PagerTitleStrip(Context context) {
        this(context, null);
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:19.129 -0500", hash_original_method = "ED55AE7F2AC5ABBC94F0D0AB4842FE7D", hash_generated_method = "3BBB2A7AB0DA8C68DA2D46396FB2D74A")
    
public PagerTitleStrip(Context context, AttributeSet attrs) {
        super(context, attrs);

        addView(mPrevText = new TextView(context));
        addView(mCurrText = new TextView(context));
        addView(mNextText = new TextView(context));

        final TypedArray a = context.obtainStyledAttributes(attrs, ATTRS);
        final int textAppearance = a.getResourceId(0, 0);
        if (textAppearance != 0) {
            mPrevText.setTextAppearance(context, textAppearance);
            mCurrText.setTextAppearance(context, textAppearance);
            mNextText.setTextAppearance(context, textAppearance);
        }
        final int textSize = a.getDimensionPixelSize(1, 0);
        if (textSize != 0) {
            setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize);
        }
        if (a.hasValue(2)) {
            final int textColor = a.getColor(2, 0);
            mPrevText.setTextColor(textColor);
            mCurrText.setTextColor(textColor);
            mNextText.setTextColor(textColor);
        }
        mGravity = a.getInteger(3, Gravity.BOTTOM);
        a.recycle();

        mTextColor = mCurrText.getTextColors().getDefaultColor();
        setNonPrimaryAlpha(SIDE_ALPHA);

        mPrevText.setEllipsize(TruncateAt.END);
        mCurrText.setEllipsize(TruncateAt.END);
        mNextText.setEllipsize(TruncateAt.END);

        boolean allCaps = false;
        if (textAppearance != 0) {
            final TypedArray ta = context.obtainStyledAttributes(textAppearance, TEXT_ATTRS);
            allCaps = ta.getBoolean(0, false);
            ta.recycle();
        }

        if (allCaps) {
            setSingleLineAllCaps(mPrevText);
            setSingleLineAllCaps(mCurrText);
            setSingleLineAllCaps(mNextText);
        } else {
            mPrevText.setSingleLine();
            mCurrText.setSingleLine();
            mNextText.setSingleLine();
        }

        final float density = context.getResources().getDisplayMetrics().density;
        mScaledTextSpacing = (int) (TEXT_SPACING * density);
    }

    /**
     * Set the required spacing between title segments.
     *
     * @param spacingPixels Spacing between each title displayed in pixels
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:19.131 -0500", hash_original_method = "2519DA94E840AA5BC78DFFB6AFA12BAD", hash_generated_method = "6C76EA4C73B62027E0712FEFBD7E9043")
    
public void setTextSpacing(int spacingPixels) {
        mScaledTextSpacing = spacingPixels;
        requestLayout();
    }

    /**
     * @return The required spacing between title segments in pixels
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:19.133 -0500", hash_original_method = "F95FEA536A7B88B38F2CCFF5449A0320", hash_generated_method = "B5612F3FCEE6064C6E6D5F64065C3027")
    
public int getTextSpacing() {
        return mScaledTextSpacing;
    }

    /**
     * Set the alpha value used for non-primary page titles.
     *
     * @param alpha Opacity value in the range 0-1f
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:19.135 -0500", hash_original_method = "1B0C50F7A2C10752F175ACE77F04BC8A", hash_generated_method = "F4116F6900D8A83A8CED413B2670C778")
    
public void setNonPrimaryAlpha(float alpha) {
        mNonPrimaryAlpha = (int) (alpha * 255) & 0xFF;
        final int transparentColor = (mNonPrimaryAlpha << 24) | (mTextColor & 0xFFFFFF);
        mPrevText.setTextColor(transparentColor);
        mNextText.setTextColor(transparentColor);
    }

    /**
     * Set the color value used as the base color for all displayed page titles.
     * Alpha will be ignored for non-primary page titles. See {@link #setNonPrimaryAlpha(float)}.
     *
     * @param color Color hex code in 0xAARRGGBB format
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:19.138 -0500", hash_original_method = "1420675230D1D18DC3DA1114D95F1368", hash_generated_method = "61E4198EC4BDB04C5572F52D3A77098F")
    
public void setTextColor(int color) {
        mTextColor = color;
        mCurrText.setTextColor(color);
        final int transparentColor = (mNonPrimaryAlpha << 24) | (mTextColor & 0xFFFFFF);
        mPrevText.setTextColor(transparentColor);
        mNextText.setTextColor(transparentColor);
    }

    /**
     * Set the default text size to a given unit and value.
     * See {@link TypedValue} for the possible dimension units.
     *
     * <p>Example: to set the text size to 14px, use
     * setTextSize(TypedValue.COMPLEX_UNIT_PX, 14);</p>
     *
     * @param unit The desired dimension unit
     * @param size The desired size in the given units
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:19.140 -0500", hash_original_method = "ABA1A9E9733CD7AD4FC9439B74E6026F", hash_generated_method = "F7CDC37E8EFADB77A63C599517F5451E")
    
public void setTextSize(int unit, float size) {
        mPrevText.setTextSize(unit, size);
        mCurrText.setTextSize(unit, size);
        mNextText.setTextSize(unit, size);
    }

    /**
     * Set the {@link Gravity} used to position text within the title strip.
     * Only the vertical gravity component is used.
     *
     * @param gravity {@link Gravity} constant for positioning title text
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:19.141 -0500", hash_original_method = "D8C2C53C8B5E3D0734FA9A20F4A2B9AC", hash_generated_method = "9F018E54A6C5B6C9070DB21C00657470")
    
public void setGravity(int gravity) {
        mGravity = gravity;
        requestLayout();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:19.143 -0500", hash_original_method = "848B9DD252B5642B635212FB2317B5E7", hash_generated_method = "CD3BD792D50FDA5CB5F1596D5E8DC210")
    
@Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        final ViewParent parent = getParent();
        if (!(parent instanceof ViewPager)) {
            throw new IllegalStateException(
                    "PagerTitleStrip must be a direct child of a ViewPager.");
        }

        final ViewPager pager = (ViewPager) parent;
        final PagerAdapter adapter = pager.getAdapter();

        pager.setInternalPageChangeListener(mPageListener);
        pager.setOnAdapterChangeListener(mPageListener);
        mPager = pager;
        updateAdapter(mWatchingAdapter != null ? mWatchingAdapter.get() : null, adapter);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:19.145 -0500", hash_original_method = "226181D55AB267E2F315638FEE6EF6D6", hash_generated_method = "58A5D82F2712610C002F7E525FCE11AC")
    
@Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (mPager != null) {
            updateAdapter(mPager.getAdapter(), null);
            mPager.setInternalPageChangeListener(null);
            mPager.setOnAdapterChangeListener(null);
            mPager = null;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:19.148 -0500", hash_original_method = "E27774F6130A4F6B6CB104EE8BFBF848", hash_generated_method = "7D3D10B4936027CF92250FDFC572D640")
    
void updateText(int currentItem, PagerAdapter adapter) {
        final int itemCount = adapter != null ? adapter.getCount() : 0;
        mUpdatingText = true;

        CharSequence text = null;
        if (currentItem >= 1 && adapter != null) {
            text = adapter.getPageTitle(currentItem - 1);
        }
        mPrevText.setText(text);

        mCurrText.setText(adapter != null && currentItem < itemCount ?
                adapter.getPageTitle(currentItem) : null);

        text = null;
        if (currentItem + 1 < itemCount && adapter != null) {
            text = adapter.getPageTitle(currentItem + 1);
        }
        mNextText.setText(text);

        // Measure everything
        final int width = getWidth() - getPaddingLeft() - getPaddingRight();
        final int childHeight = getHeight() - getPaddingTop() - getPaddingBottom();
        final int childWidthSpec = MeasureSpec.makeMeasureSpec((int) (width * 0.8f),
                MeasureSpec.AT_MOST);
        final int childHeightSpec = MeasureSpec.makeMeasureSpec(childHeight, MeasureSpec.AT_MOST);
        mPrevText.measure(childWidthSpec, childHeightSpec);
        mCurrText.measure(childWidthSpec, childHeightSpec);
        mNextText.measure(childWidthSpec, childHeightSpec);

        mLastKnownCurrentPage = currentItem;

        if (!mUpdatingPositions) {
            updateTextPositions(currentItem, mLastKnownPositionOffset, false);
        }

        mUpdatingText = false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:19.151 -0500", hash_original_method = "BD66F47535DA80AFA969E7F2E28868A2", hash_generated_method = "8BDC48041CBAA6A35580577819C8B411")
    
@Override
    public void requestLayout() {
        if (!mUpdatingText) {
            super.requestLayout();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:19.153 -0500", hash_original_method = "EAF924632CCF71246331B8833B944AA0", hash_generated_method = "EAF924632CCF71246331B8833B944AA0")
    
void updateAdapter(PagerAdapter oldAdapter, PagerAdapter newAdapter) {
        if (oldAdapter != null) {
            oldAdapter.unregisterDataSetObserver(mPageListener);
            mWatchingAdapter = null;
        }
        if (newAdapter != null) {
            newAdapter.registerDataSetObserver(mPageListener);
            mWatchingAdapter = new WeakReference<PagerAdapter>(newAdapter);
        }
        if (mPager != null) {
            mLastKnownCurrentPage = -1;
            mLastKnownPositionOffset = -1;
            updateText(mPager.getCurrentItem(), newAdapter);
            requestLayout();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:19.160 -0500", hash_original_method = "4031212F20DB7BF6694A94FE5410BA3F", hash_generated_method = "4031212F20DB7BF6694A94FE5410BA3F")
    
void updateTextPositions(int position, float positionOffset, boolean force) {
        if (position != mLastKnownCurrentPage) {
            updateText(position, mPager.getAdapter());
        } else if (!force && positionOffset == mLastKnownPositionOffset) {
            return;
        }

        mUpdatingPositions = true;

        final int prevWidth = mPrevText.getMeasuredWidth();
        final int currWidth = mCurrText.getMeasuredWidth();
        final int nextWidth = mNextText.getMeasuredWidth();
        final int halfCurrWidth = currWidth / 2;

        final int stripWidth = getWidth();
        final int stripHeight = getHeight();
        final int paddingLeft = getPaddingLeft();
        final int paddingRight = getPaddingRight();
        final int paddingTop = getPaddingTop();
        final int paddingBottom = getPaddingBottom();
        final int textPaddedLeft = paddingLeft + halfCurrWidth;
        final int textPaddedRight = paddingRight + halfCurrWidth;
        final int contentWidth = stripWidth - textPaddedLeft - textPaddedRight;

        float currOffset = positionOffset + 0.5f;
        if (currOffset > 1.f) {
            currOffset -= 1.f;
        }
        final int currCenter = stripWidth - textPaddedRight - (int) (contentWidth * currOffset);
        final int currLeft = currCenter - currWidth / 2;
        final int currRight = currLeft + currWidth;

        final int prevBaseline = mPrevText.getBaseline();
        final int currBaseline = mCurrText.getBaseline();
        final int nextBaseline = mNextText.getBaseline();
        final int maxBaseline = Math.max(Math.max(prevBaseline, currBaseline), nextBaseline);
        final int prevTopOffset = maxBaseline - prevBaseline;
        final int currTopOffset = maxBaseline - currBaseline;
        final int nextTopOffset = maxBaseline - nextBaseline;
        final int alignedPrevHeight = prevTopOffset + mPrevText.getMeasuredHeight();
        final int alignedCurrHeight = currTopOffset + mCurrText.getMeasuredHeight();
        final int alignedNextHeight = nextTopOffset + mNextText.getMeasuredHeight();
        final int maxTextHeight = Math.max(Math.max(alignedPrevHeight, alignedCurrHeight),
                alignedNextHeight);

        final int vgrav = mGravity & Gravity.VERTICAL_GRAVITY_MASK;

        int prevTop;
        int currTop;
        int nextTop;
        switch (vgrav) {
            default:
            case Gravity.TOP:
                prevTop = paddingTop + prevTopOffset;
                currTop = paddingTop + currTopOffset;
                nextTop = paddingTop + nextTopOffset;
                break;
            case Gravity.CENTER_VERTICAL:
                final int paddedHeight = stripHeight - paddingTop - paddingBottom;
                final int centeredTop = (paddedHeight - maxTextHeight) / 2;
                prevTop = centeredTop + prevTopOffset;
                currTop = centeredTop + currTopOffset;
                nextTop = centeredTop + nextTopOffset;
                break;
            case Gravity.BOTTOM:
                final int bottomGravTop = stripHeight - paddingBottom - maxTextHeight;
                prevTop = bottomGravTop + prevTopOffset;
                currTop = bottomGravTop + currTopOffset;
                nextTop = bottomGravTop + nextTopOffset;
                break;
        }

        mCurrText.layout(currLeft, currTop, currRight,
                currTop + mCurrText.getMeasuredHeight());

        final int prevLeft = Math.min(paddingLeft, currLeft - mScaledTextSpacing - prevWidth);
        mPrevText.layout(prevLeft, prevTop, prevLeft + prevWidth,
                prevTop + mPrevText.getMeasuredHeight());

        final int nextLeft = Math.max(stripWidth - paddingRight - nextWidth,
                currRight + mScaledTextSpacing);
        mNextText.layout(nextLeft, nextTop, nextLeft + nextWidth,
                nextTop + mNextText.getMeasuredHeight());

        mLastKnownPositionOffset = positionOffset;
        mUpdatingPositions = false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:19.163 -0500", hash_original_method = "51FB66892937CB37A2CA53CCF8BF865D", hash_generated_method = "80D12B3C49755A24E9117D738B990825")
    
@Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        final int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        final int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        final int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        final int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        if (widthMode != MeasureSpec.EXACTLY) {
            throw new IllegalStateException("Must measure with an exact width");
        }

        int childHeight = heightSize;
        int minHeight = getMinHeight();
        int padding = 0;
        padding = getPaddingTop() + getPaddingBottom();
        childHeight -= padding;

        final int childWidthSpec = MeasureSpec.makeMeasureSpec((int) (widthSize * 0.8f),
                MeasureSpec.AT_MOST);
        final int childHeightSpec = MeasureSpec.makeMeasureSpec(childHeight, MeasureSpec.AT_MOST);

        mPrevText.measure(childWidthSpec, childHeightSpec);
        mCurrText.measure(childWidthSpec, childHeightSpec);
        mNextText.measure(childWidthSpec, childHeightSpec);

        if (heightMode == MeasureSpec.EXACTLY) {
            setMeasuredDimension(widthSize, heightSize);
        } else {
            int textHeight = mCurrText.getMeasuredHeight();
            setMeasuredDimension(widthSize, Math.max(minHeight, textHeight + padding));
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:19.166 -0500", hash_original_method = "EE71B2554045A13705C826A4155956FA", hash_generated_method = "F2223B4538F54FF5A8030F7E9D551B57")
    
@Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        if (mPager != null) {
            final float offset = mLastKnownPositionOffset >= 0 ? mLastKnownPositionOffset : 0;
            updateTextPositions(mLastKnownCurrentPage, offset, true);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:19.168 -0500", hash_original_method = "5F597790016BBA247C3C04F7E22AC0D1", hash_generated_method = "5F597790016BBA247C3C04F7E22AC0D1")
    
int getMinHeight() {
        int minHeight = 0;
        final Drawable bg = getBackground();
        if (bg != null) {
            minHeight = bg.getIntrinsicHeight();
        }
        return minHeight;
    }

    private class PageListener extends DataSetObserver implements ViewPager.OnPageChangeListener,
            ViewPager.OnAdapterChangeListener {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:19.169 -0500", hash_original_field = "FFE03E93C2BA2892A2DA586623C1B0B0", hash_generated_field = "5762858524B9AF236C570FA132A73251")

        private int mScrollState;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:19.171 -0500", hash_original_method = "6C358B1B424AD01247E78823B26F3317", hash_generated_method = "787B7536EF9C4BB9A019603598E4AA29")
        
@Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            if (positionOffset > 0.5f) {
                // Consider ourselves to be on the next page when we're 50% of the way there.
                position++;
            }
            updateTextPositions(position, positionOffset, false);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:19.173 -0500", hash_original_method = "BDE5366BD51457451209BD696A487B58", hash_generated_method = "8E0A125F931E9981104B9D7888EDFA53")
        
@Override
        public void onPageSelected(int position) {
            if (mScrollState == ViewPager.SCROLL_STATE_IDLE) {
                // Only update the text here if we're not dragging or settling.
                updateText(mPager.getCurrentItem(), mPager.getAdapter());

                final float offset = mLastKnownPositionOffset >= 0 ? mLastKnownPositionOffset : 0;
                updateTextPositions(mPager.getCurrentItem(), offset, true);
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:19.175 -0500", hash_original_method = "7D09E30D83D104D1B391B393C60F770D", hash_generated_method = "2C1D1A2266E25176C415ED9EBEA30F84")
        
@Override
        public void onPageScrollStateChanged(int state) {
            mScrollState = state;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:19.176 -0500", hash_original_method = "61B15A1B041ED988FCE0F531C9B4D949", hash_generated_method = "2BF34629A81712FE654495C0DF81AB11")
        
@Override
        public void onAdapterChanged(PagerAdapter oldAdapter, PagerAdapter newAdapter) {
            updateAdapter(oldAdapter, newAdapter);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:19.178 -0500", hash_original_method = "14F4D00F7C7AD3110DA52FF41E59ABFF", hash_generated_method = "93899DC0A75C9846A7DD4E64A31CFEC2")
        
@Override
        public void onChanged() {
            updateText(mPager.getCurrentItem(), mPager.getAdapter());

            final float offset = mLastKnownPositionOffset >= 0 ? mLastKnownPositionOffset : 0;
            updateTextPositions(mPager.getCurrentItem(), offset, true);
        }
    }
}
