/*
 * Copyright (C) 2012 The Android Open Source Project
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
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

/**
 * PagerTabStrip is an interactive indicator of the current, next,
 * and previous pages of a {@link ViewPager}. It is intended to be used as a
 * child view of a ViewPager widget in your XML layout.
 * Add it as a child of a ViewPager in your layout file and set its
 * android:layout_gravity to TOP or BOTTOM to pin it to the top or bottom
 * of the ViewPager. The title from each page is supplied by the method
 * {@link PagerAdapter#getPageTitle(int)} in the adapter supplied to
 * the ViewPager.
 *
 * <p>For a non-interactive indicator, see {@link PagerTitleStrip}.</p>
 */
public class PagerTabStrip extends PagerTitleStrip {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:20.690 -0500", hash_original_field = "277977807ED579553398D6CC2379F69F", hash_generated_field = "64B0B411288CFE20B0EA9C8A85989E2F")

    private static final String TAG = "PagerTabStrip";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:20.691 -0500", hash_original_field = "2556A70D2E19F2CBDD2ADBCCB300654E", hash_generated_field = "F815EAE3F4892EA46E413D40A4CACECA")

    private static final int INDICATOR_HEIGHT = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:20.693 -0500", hash_original_field = "765204A0911B6171A5BF3D7B6D3D41FE", hash_generated_field = "FE15022AF2224D927BC779D4428D97DB")

    private static final int MIN_PADDING_BOTTOM = INDICATOR_HEIGHT + 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:20.694 -0500", hash_original_field = "57229BAE5BFE68A5E843371063B031B2", hash_generated_field = "3599EAA4B05FBD75BEE3591AF23B7880")

    private static final int TAB_PADDING = 16;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:20.695 -0500", hash_original_field = "FCDF2DD8308E7006BA15DD0751E22188", hash_generated_field = "ECDB9805019F16D73B6F61501C2408CB")

    private static final int TAB_SPACING = 32;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:20.698 -0500", hash_original_field = "8F7A3165958BEE10D8E67FF87DC6D567", hash_generated_field = "F766C8CB662DF4560C5FBDFCA362ED3F")

    private static final int MIN_TEXT_SPACING = TAB_SPACING + TAB_PADDING * 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:20.700 -0500", hash_original_field = "89CBA5E0AC5F0B8C6AFDFFD53F141C58", hash_generated_field = "93A9F7E8A14957597A2F40091011D859")

    private static final int FULL_UNDERLINE_HEIGHT = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:20.701 -0500", hash_original_field = "084508E8F0EB8BA02E5E12824590B433", hash_generated_field = "AC9054A2B2E2C126AD018B67C8B1189C")

    private static final int MIN_STRIP_HEIGHT = 32;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:20.703 -0500", hash_original_field = "78A76B1C1E172B7EE02E3193D3E15F67", hash_generated_field = "409FE0E5CDF8B52318C1C752E426E71E")

    private int mIndicatorColor;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:20.705 -0500", hash_original_field = "0B78594062216610AA9AD992AC51C103", hash_generated_field = "83098245E64EBFACE72B4215FEFBC24C")

    private int mIndicatorHeight;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:20.707 -0500", hash_original_field = "FC5A6D8561811ED58F674C54BC342B11", hash_generated_field = "D329705655BA0249AA981002B2E08FFB")

    private int mMinPaddingBottom;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:20.708 -0500", hash_original_field = "E3529DDAAA088C9AD89006D0C13170F6", hash_generated_field = "2E19480DB23CD1A94AC53319EE8298A4")

    private int mMinTextSpacing;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:20.709 -0500", hash_original_field = "C9271FEA04C42062C41B7024B6BAD75C", hash_generated_field = "598E6014FAF0ACAD0C354AF2310FFAE5")

    private int mMinStripHeight;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:20.710 -0500", hash_original_field = "CBB8A0F8E6555144886323D859053B7F", hash_generated_field = "B4A7B09278766EFD4D68D9CA85E7B4F2")

    private int mTabPadding;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:20.711 -0500", hash_original_field = "E43EE5FB15F961658A90688AA42DF177", hash_generated_field = "E8B1B360D2FDC03D7C871AFEEE323841")

    private final Paint mTabPaint = new Paint();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:20.713 -0500", hash_original_field = "1732EB32F2D77CCA26590AEEA670A175", hash_generated_field = "A498F2A4744F31D22F9C4ABEBB254F2F")

    private final Rect mTempRect = new Rect();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:20.714 -0500", hash_original_field = "4F8ED051E13AEA0ECB1167BBDF63AF5A", hash_generated_field = "F19DF385984B4F1145AF1A81FF31F095")

    private int mTabAlpha = 0xFF;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:20.715 -0500", hash_original_field = "79C9C7C7EFB1C524A11E843C423C00F7", hash_generated_field = "3F79DD2994E6DB89CED3A3680B088E83")

    private boolean mDrawFullUnderline = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:20.716 -0500", hash_original_field = "936CCA88CFEA633E08F06F4089E4BB87", hash_generated_field = "935435EF24FB211036CB9B2B592AACFC")

    private boolean mDrawFullUnderlineSet = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:20.718 -0500", hash_original_field = "62F6D79B2C49896DA6F62B289CFECC83", hash_generated_field = "CB7E41F64EF564EEADD9F24B71DE1884")

    private int mFullUnderlineHeight;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:20.720 -0500", hash_original_field = "C60964F4DE47B6C6022FAC8C5443E6EF", hash_generated_field = "1B7951305AF6C2C0E6775E9A5145CC72")

    private boolean mIgnoreTap;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:20.721 -0500", hash_original_field = "25CFDFB463A965BC44C22C5B603E6082", hash_generated_field = "E8D995D721D911B655A8BA1B8E85A671")

    private float mInitialMotionX;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:21.053 -0500", hash_original_field = "8405CC958EF7FF178B766BCBE27E1F2F", hash_generated_field = "123A2D63D23BC6C888D43FC39BEED8A4")

    private float mInitialMotionY;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:21.054 -0500", hash_original_field = "D11C33EFD56B37B918E01A200C446C59", hash_generated_field = "3B323323DD6A6BF972666D993592C670")

    private int mTouchSlop;

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:21.056 -0500", hash_original_method = "AEED43FFC18977D21094349BF84C20B4", hash_generated_method = "CC0FCF2A99320A7E6A8674B792A0D877")
    
public PagerTabStrip(Context context) {
        this(context, null);
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:21.062 -0500", hash_original_method = "ACA07B5CE6E6B13EE40202110EB75BD3", hash_generated_method = "31EC5D9E2964078A6C7CBD2C03E74FAC")
    
public PagerTabStrip(Context context, AttributeSet attrs) {
        super(context, attrs);

        mIndicatorColor = mTextColor;
        mTabPaint.setColor(mIndicatorColor);

        // Note: this follows the rules for Resources#getDimensionPixelOffset/Size:
        //       sizes round up, offsets round down.
        final float density = context.getResources().getDisplayMetrics().density;
        mIndicatorHeight = (int) (INDICATOR_HEIGHT * density + 0.5f);
        mMinPaddingBottom = (int) (MIN_PADDING_BOTTOM * density + 0.5f);
        mMinTextSpacing = (int) (MIN_TEXT_SPACING * density);
        mTabPadding = (int) (TAB_PADDING * density + 0.5f);
        mFullUnderlineHeight = (int) (FULL_UNDERLINE_HEIGHT * density + 0.5f);
        mMinStripHeight = (int) (MIN_STRIP_HEIGHT * density + 0.5f);
        mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();

        // Enforce restrictions
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        setTextSpacing(getTextSpacing());

        setWillNotDraw(false);

        mPrevText.setFocusable(true);
        mPrevText.setOnClickListener(new OnClickListener() {
            @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:55:35.033 -0500", hash_original_method = "91A02AD3B25B1F5EE15DA116FF083943", hash_generated_method = "6A31A0B5EC25976A0D08C4B4705305C7")
            
@Override
            public void onClick(View v) {
                mPager.setCurrentItem(mPager.getCurrentItem() - 1);
            }
        });

        mNextText.setFocusable(true);
        mNextText.setOnClickListener(new OnClickListener() {
            @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:55:35.035 -0500", hash_original_method = "1076F28AA463C7302B98279A7C9CC4FD", hash_generated_method = "9E87C1AE87E1F0B4C02C7BFF07B0B81A")
            
@Override
            public void onClick(View v) {
                mPager.setCurrentItem(mPager.getCurrentItem() + 1);
            }
        });

        if (getBackground() == null) {
            mDrawFullUnderline = true;
        }
    }

    /**
     * Set the color of the tab indicator bar.
     *
     * @param color Color to set as an 0xRRGGBB value. The high byte (alpha) is ignored.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:21.064 -0500", hash_original_method = "416E053D9953A7DFD58ABDC9A59B40AE", hash_generated_method = "2D35475DC0D70F5C927CC49B13E18D74")
    
public void setTabIndicatorColor(int color) {
        mIndicatorColor = color;
        mTabPaint.setColor(mIndicatorColor);
        invalidate();
    }

    /**
     * Set the color of the tab indicator bar from a color resource.
     *
     * @param resId Resource ID of a color resource to load
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:21.067 -0500", hash_original_method = "E9D022FF51B83B7CA06819055EF3F1EA", hash_generated_method = "1C9FD94A02A9DEE0BE377BB9F33AF1C5")
    
public void setTabIndicatorColorResource(int resId) {
        setTabIndicatorColor(getContext().getResources().getColor(resId));
    }

    /**
     * @return The current tab indicator color as an 0xRRGGBB value.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:21.068 -0500", hash_original_method = "5395C6CBC695BBA3012BD836AEACC5FF", hash_generated_method = "B6DB81AA78977A9C2DE5F884D0080D84")
    
public int getTabIndicatorColor() {
        return mIndicatorColor;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:21.069 -0500", hash_original_method = "476E6AAD455240BE6ECAEEC8CCE45F2E", hash_generated_method = "678E9CE0511ADA822A21E3091D2BD86E")
    
@Override
    public void setPadding(int left, int top, int right, int bottom) {
        if (bottom < mMinPaddingBottom) {
            bottom = mMinPaddingBottom;
        }
        super.setPadding(left, top, right, bottom);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:21.071 -0500", hash_original_method = "9E708A5002235F54A6E83D6CAB6E0AE5", hash_generated_method = "C8C954E6342AA660D707EC68EBCF2F57")
    
@Override
    public void setTextSpacing(int textSpacing) {
        if (textSpacing < mMinTextSpacing) {
            textSpacing = mMinTextSpacing;
        }
        super.setTextSpacing(textSpacing);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:21.072 -0500", hash_original_method = "3092862974FBD462F013027A320B043F", hash_generated_method = "E0F41005789A6204C22172B2AF4419C3")
    
@Override
    public void setBackgroundDrawable(Drawable d) {
        super.setBackgroundDrawable(d);
        if (!mDrawFullUnderlineSet) {
            mDrawFullUnderline = d == null;
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:21.074 -0500", hash_original_method = "4DB107C989DD8831950A5E6FC781B7EA", hash_generated_method = "8FA7F2F5EE69B341201263CB8FFA759D")
    
@Override
    public void setBackgroundColor(int color) {
        super.setBackgroundColor(color);
        if (!mDrawFullUnderlineSet) {
            mDrawFullUnderline = (color & 0xFF000000) == 0;
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:21.076 -0500", hash_original_method = "3C72ECA005B1B81D90186B2BF9D062C7", hash_generated_method = "874251E1F00E935118495ABCE41BE38B")
    
@Override
    public void setBackgroundResource(int resId) {
        super.setBackgroundResource(resId);
        if (!mDrawFullUnderlineSet) {
            mDrawFullUnderline = resId == 0;
        }
    }

    /**
     * Set whether this tab strip should draw a full-width underline in the
     * current tab indicator color.
     *
     * @param drawFull true to draw a full-width underline, false otherwise
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:21.077 -0500", hash_original_method = "45921BB4543CC1DCECCEDCA990B66B64", hash_generated_method = "7DD42AB510D23D06E77DBA923BBBB4D9")
    
public void setDrawFullUnderline(boolean drawFull) {
        mDrawFullUnderline = drawFull;
        mDrawFullUnderlineSet = true;
        invalidate();
    }

    /**
     * Return whether or not this tab strip will draw a full-width underline.
     * This defaults to true if no background is set.
     *
     * @return true if this tab strip will draw a full-width underline in the
     * current tab indicator color.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:21.078 -0500", hash_original_method = "6FF569EBD79F00CD08226507D1584B29", hash_generated_method = "808135418DBE1556AC77963917B6E4F7")
    
public boolean getDrawFullUnderline() {
        return mDrawFullUnderline;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:21.082 -0500", hash_original_method = "277E06AC1F137E5CAC62EBE97DB0158F", hash_generated_method = "101CA3233DF15482CD1C9AF570B24E0A")
    
@Override
    int getMinHeight() {
        return Math.max(super.getMinHeight(), mMinStripHeight);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:21.085 -0500", hash_original_method = "111ACB958C21102733D4E9303B8F60D8", hash_generated_method = "572CBDECBA9BF004FCC5A1CA52BD19E5")
    
@Override
    public boolean onTouchEvent(MotionEvent ev) {
        final int action = ev.getAction();
        if (action != MotionEvent.ACTION_DOWN && mIgnoreTap) {
            return false;
        }

        // Any tap within touch slop to either side of the current item
        // will scroll to prev/next.
        final float x = ev.getX();
        final float y = ev.getY();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                mInitialMotionX = x;
                mInitialMotionY = y;
                mIgnoreTap = false;
                break;

            case MotionEvent.ACTION_MOVE:
                if (Math.abs(x - mInitialMotionX) > mTouchSlop ||
                        Math.abs(y - mInitialMotionY) > mTouchSlop) {
                    mIgnoreTap = true;
                }
                break;

            case MotionEvent.ACTION_UP:
                if (x < mCurrText.getLeft() - mTabPadding) {
                    mPager.setCurrentItem(mPager.getCurrentItem() - 1);
                } else if (x > mCurrText.getRight() + mTabPadding) {
                    mPager.setCurrentItem(mPager.getCurrentItem() + 1);
                }
                break;
        }

        return true;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:21.089 -0500", hash_original_method = "1ECCB5A2A13672387CA93C5777A80514", hash_generated_method = "43577484297429182C64B20E0C2B64FE")
    
@Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        final int height = getHeight();
        final int bottom = height;
        final int left = mCurrText.getLeft() - mTabPadding;
        final int right = mCurrText.getRight() + mTabPadding;
        final int top = bottom - mIndicatorHeight;

        mTabPaint.setColor(mTabAlpha << 24 | (mIndicatorColor & 0xFFFFFF));
        canvas.drawRect(left, top, right, bottom, mTabPaint);

        if (mDrawFullUnderline) {
            mTabPaint.setColor(0xFF << 24 | (mIndicatorColor & 0xFFFFFF));
            canvas.drawRect(getPaddingLeft(), height - mFullUnderlineHeight,
                    getWidth() - getPaddingRight(), height, mTabPaint);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:21.091 -0500", hash_original_method = "218291EE6C0B81B0F0486DC4B2750F49", hash_generated_method = "8FE85C2488FCD9EE8907565130AB7F46")
    
@Override
    void updateTextPositions(int position, float positionOffset, boolean force) {
        final Rect r = mTempRect;
        int bottom = getHeight();
        int left = mCurrText.getLeft() - mTabPadding;
        int right = mCurrText.getRight() + mTabPadding;
        int top = bottom - mIndicatorHeight;

        r.set(left, top, right, bottom);

        super.updateTextPositions(position, positionOffset, force);
        mTabAlpha = (int) (Math.abs(positionOffset - 0.5f) * 2 * 0xFF);

        left = mCurrText.getLeft() - mTabPadding;
        right = mCurrText.getRight() + mTabPadding;
        r.union(left, top, right, bottom);

        invalidate(r);
    }
}
