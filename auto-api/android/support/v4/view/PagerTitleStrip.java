package android.support.v4.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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

public class PagerTitleStrip extends ViewGroup implements ViewPager.Decor {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.343 -0400", hash_original_field = "959319650E4005CB34A60DBB039B6A05", hash_generated_field = "1A8F7587F4799795AFC9E6CF3AD21423")

    ViewPager mPager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.344 -0400", hash_original_field = "C14417A77EF10127E71F65FBD32A2E8F", hash_generated_field = "758380EDFA6EB374B3DB5871CBD34D35")

    TextView mPrevText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.344 -0400", hash_original_field = "98C948E8CDC8E892CBF89D1AA60FE31E", hash_generated_field = "D6A93F95F2CD87894EF4AE64A56AB53D")

    TextView mCurrText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.344 -0400", hash_original_field = "A099F68DAD444A0E0BFFA52461258756", hash_generated_field = "783CD0015D15F39FE9794D515AACDA6C")

    TextView mNextText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.344 -0400", hash_original_field = "F4E63D3A6D1362995479262CDE7E10C6", hash_generated_field = "90F5F9FB1487026D75D6D5D3AB10A419")

    private int mLastKnownCurrentPage = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.344 -0400", hash_original_field = "A2BD4BD3A2FCF9D8FE8124B967098B36", hash_generated_field = "CB0C3B4B9C508B6F14C55441D0AD8B91")

    private float mLastKnownPositionOffset = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.344 -0400", hash_original_field = "6F4A8FB5B7C8DCAC35330E1BC62F823A", hash_generated_field = "89C52633EF67CCE8BCA882446FF1CD8F")

    private int mScaledTextSpacing;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.344 -0400", hash_original_field = "1DE05384A4316AFED99BFDA3AA41DEF9", hash_generated_field = "ACF14A395FB2702990553CD0EFA1BDCC")

    private int mGravity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.344 -0400", hash_original_field = "B61F4EE6B3071E72AA84A13982B9C801", hash_generated_field = "3E47E0ADC999C3364DCD228C5D3CD605")

    private boolean mUpdatingText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.344 -0400", hash_original_field = "1148501BEDA435B4D0335F0D52071FB2", hash_generated_field = "664984FC99328963C219145CAEA3A509")

    private boolean mUpdatingPositions;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.344 -0400", hash_original_field = "1E716363C56B50ACBC58B91F5DA4A257", hash_generated_field = "4E83C2A941ECC1487A5C360BEBF8F647")

    private PageListener mPageListener = new PageListener();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.344 -0400", hash_original_field = "2BC21E5D932CAD35B66DE550B8144185", hash_generated_field = "26A2F398E2C092065BC88A0258E63DDF")

    private WeakReference<PagerAdapter> mWatchingAdapter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.354 -0400", hash_original_field = "27626BC63D1D64454F6693FB195F1397", hash_generated_field = "28DD24027C59F108FB986079494AC102")

    private int mNonPrimaryAlpha;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.355 -0400", hash_original_field = "D617392BE941E0902ECF95DB04F038E8", hash_generated_field = "9E1409A112DC65C9353A83D835CDB2FC")

    int mTextColor;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.355 -0400", hash_original_method = "58D8374F43287A498EE1AB9EF078D682", hash_generated_method = "08B5DCD29259E8DADE0E5AAA075686C6")
    public  PagerTitleStrip(Context context) {
        this(context, null);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.357 -0400", hash_original_method = "ED55AE7F2AC5ABBC94F0D0AB4842FE7D", hash_generated_method = "C100F330D21CBB6489DD4FBA393A9B8E")
    public  PagerTitleStrip(Context context, AttributeSet attrs) {
        super(context, attrs);
        addView(mPrevText = new TextView(context));
        addView(mCurrText = new TextView(context));
        addView(mNextText = new TextView(context));
        TypedArray a;
        a = context.obtainStyledAttributes(attrs, ATTRS);
        int textAppearance;
        textAppearance = a.getResourceId(0, 0);
        {
            mPrevText.setTextAppearance(context, textAppearance);
            mCurrText.setTextAppearance(context, textAppearance);
            mNextText.setTextAppearance(context, textAppearance);
        } //End block
        int textSize;
        textSize = a.getDimensionPixelSize(1, 0);
        {
            setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize);
        } //End block
        {
            boolean varC56E456E9D7D5394B1593532B89D4F9D_639594378 = (a.hasValue(2));
            {
                int textColor;
                textColor = a.getColor(2, 0);
                mPrevText.setTextColor(textColor);
                mCurrText.setTextColor(textColor);
                mNextText.setTextColor(textColor);
            } //End block
        } //End collapsed parenthetic
        mGravity = a.getInteger(3, Gravity.BOTTOM);
        a.recycle();
        mTextColor = mCurrText.getTextColors().getDefaultColor();
        setNonPrimaryAlpha(SIDE_ALPHA);
        mPrevText.setEllipsize(TruncateAt.END);
        mCurrText.setEllipsize(TruncateAt.END);
        mNextText.setEllipsize(TruncateAt.END);
        boolean allCaps;
        allCaps = false;
        {
            TypedArray ta;
            ta = context.obtainStyledAttributes(textAppearance, TEXT_ATTRS);
            allCaps = ta.getBoolean(0, false);
            ta.recycle();
        } //End block
        {
            setSingleLineAllCaps(mPrevText);
            setSingleLineAllCaps(mCurrText);
            setSingleLineAllCaps(mNextText);
        } //End block
        {
            mPrevText.setSingleLine();
            mCurrText.setSingleLine();
            mNextText.setSingleLine();
        } //End block
        float density;
        density = context.getResources().getDisplayMetrics().density;
        mScaledTextSpacing = (int) (TEXT_SPACING * density);
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        private static void setSingleLineAllCaps(TextView text) {
        IMPL.setSingleLineAllCaps(text);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.366 -0400", hash_original_method = "2519DA94E840AA5BC78DFFB6AFA12BAD", hash_generated_method = "3C8AB964245290985C2552FAD6170B18")
    public void setTextSpacing(int spacingPixels) {
        mScaledTextSpacing = spacingPixels;
        requestLayout();
        // ---------- Original Method ----------
        //mScaledTextSpacing = spacingPixels;
        //requestLayout();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.366 -0400", hash_original_method = "F95FEA536A7B88B38F2CCFF5449A0320", hash_generated_method = "08815B5901470962B194E8F290D87C86")
    public int getTextSpacing() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_405572049 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_405572049;
        // ---------- Original Method ----------
        //return mScaledTextSpacing;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.390 -0400", hash_original_method = "1B0C50F7A2C10752F175ACE77F04BC8A", hash_generated_method = "12C16DD0939834AAECFB102FC0B25CE6")
    public void setNonPrimaryAlpha(float alpha) {
        mNonPrimaryAlpha = (int) (alpha * 255) & 0xFF;
        int transparentColor;
        transparentColor = (mNonPrimaryAlpha << 24) | (mTextColor & 0xFFFFFF);
        mPrevText.setTextColor(transparentColor);
        mNextText.setTextColor(transparentColor);
        // ---------- Original Method ----------
        //mNonPrimaryAlpha = (int) (alpha * 255) & 0xFF;
        //final int transparentColor = (mNonPrimaryAlpha << 24) | (mTextColor & 0xFFFFFF);
        //mPrevText.setTextColor(transparentColor);
        //mNextText.setTextColor(transparentColor);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.399 -0400", hash_original_method = "1420675230D1D18DC3DA1114D95F1368", hash_generated_method = "B3EA10530AA205FD2861FD055EB08041")
    public void setTextColor(int color) {
        mTextColor = color;
        mCurrText.setTextColor(color);
        int transparentColor;
        transparentColor = (mNonPrimaryAlpha << 24) | (mTextColor & 0xFFFFFF);
        mPrevText.setTextColor(transparentColor);
        mNextText.setTextColor(transparentColor);
        // ---------- Original Method ----------
        //mTextColor = color;
        //mCurrText.setTextColor(color);
        //final int transparentColor = (mNonPrimaryAlpha << 24) | (mTextColor & 0xFFFFFF);
        //mPrevText.setTextColor(transparentColor);
        //mNextText.setTextColor(transparentColor);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.400 -0400", hash_original_method = "ABA1A9E9733CD7AD4FC9439B74E6026F", hash_generated_method = "7FBC60F27A726EFFCBC6C639A60AE6B5")
    public void setTextSize(int unit, float size) {
        mPrevText.setTextSize(unit, size);
        mCurrText.setTextSize(unit, size);
        mNextText.setTextSize(unit, size);
        addTaint(unit);
        addTaint(size);
        // ---------- Original Method ----------
        //mPrevText.setTextSize(unit, size);
        //mCurrText.setTextSize(unit, size);
        //mNextText.setTextSize(unit, size);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.400 -0400", hash_original_method = "D8C2C53C8B5E3D0734FA9A20F4A2B9AC", hash_generated_method = "8EE0A9D43E5ACB98AD99F45FFD8ECFB3")
    public void setGravity(int gravity) {
        mGravity = gravity;
        requestLayout();
        // ---------- Original Method ----------
        //mGravity = gravity;
        //requestLayout();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.401 -0400", hash_original_method = "848B9DD252B5642B635212FB2317B5E7", hash_generated_method = "63C0C8D75431F29A9D974B2818DC6C12")
    @Override
    protected void onAttachedToWindow() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onAttachedToWindow();
        ViewParent parent;
        parent = getParent();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(
                    "PagerTitleStrip must be a direct child of a ViewPager.");
        } //End block
        ViewPager pager;
        pager = (ViewPager) parent;
        PagerAdapter adapter;
        adapter = pager.getAdapter();
        pager.setInternalPageChangeListener(mPageListener);
        pager.setOnAdapterChangeListener(mPageListener);
        mPager = pager;
        updateAdapter(mWatchingAdapter != null ? mWatchingAdapter.get() : null, adapter);
        // ---------- Original Method ----------
        //super.onAttachedToWindow();
        //final ViewParent parent = getParent();
        //if (!(parent instanceof ViewPager)) {
            //throw new IllegalStateException(
                    //"PagerTitleStrip must be a direct child of a ViewPager.");
        //}
        //final ViewPager pager = (ViewPager) parent;
        //final PagerAdapter adapter = pager.getAdapter();
        //pager.setInternalPageChangeListener(mPageListener);
        //pager.setOnAdapterChangeListener(mPageListener);
        //mPager = pager;
        //updateAdapter(mWatchingAdapter != null ? mWatchingAdapter.get() : null, adapter);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.401 -0400", hash_original_method = "226181D55AB267E2F315638FEE6EF6D6", hash_generated_method = "51688AE78D1E4CF76ECDC8182F465AC7")
    @Override
    protected void onDetachedFromWindow() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onDetachedFromWindow();
        {
            updateAdapter(mPager.getAdapter(), null);
            mPager.setInternalPageChangeListener(null);
            mPager.setOnAdapterChangeListener(null);
            mPager = null;
        } //End block
        // ---------- Original Method ----------
        //super.onDetachedFromWindow();
        //if (mPager != null) {
            //updateAdapter(mPager.getAdapter(), null);
            //mPager.setInternalPageChangeListener(null);
            //mPager.setOnAdapterChangeListener(null);
            //mPager = null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.410 -0400", hash_original_method = "E27774F6130A4F6B6CB104EE8BFBF848", hash_generated_method = "B7C6FCBD30F965628D3934B6F2FB8AC9")
     void updateText(int currentItem, PagerAdapter adapter) {
        int itemCount;
        itemCount = adapter.getCount();
        itemCount = 0;
        mUpdatingText = true;
        CharSequence text;
        text = null;
        {
            text = adapter.getPageTitle(currentItem - 1);
        } //End block
        mPrevText.setText(text);
        mCurrText.setText(adapter != null && currentItem < itemCount ?
                adapter.getPageTitle(currentItem) : null);
        text = null;
        {
            text = adapter.getPageTitle(currentItem + 1);
        } //End block
        mNextText.setText(text);
        int width;
        width = getWidth() - getPaddingLeft() - getPaddingRight();
        int childHeight;
        childHeight = getHeight() - getPaddingTop() - getPaddingBottom();
        int childWidthSpec;
        childWidthSpec = MeasureSpec.makeMeasureSpec((int) (width * 0.8f),
                MeasureSpec.AT_MOST);
        int childHeightSpec;
        childHeightSpec = MeasureSpec.makeMeasureSpec(childHeight, MeasureSpec.AT_MOST);
        mPrevText.measure(childWidthSpec, childHeightSpec);
        mCurrText.measure(childWidthSpec, childHeightSpec);
        mNextText.measure(childWidthSpec, childHeightSpec);
        mLastKnownCurrentPage = currentItem;
        {
            updateTextPositions(currentItem, mLastKnownPositionOffset, false);
        } //End block
        mUpdatingText = false;
        addTaint(adapter.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.411 -0400", hash_original_method = "BD66F47535DA80AFA969E7F2E28868A2", hash_generated_method = "3E98389D2D1F00FE53C9A58938B3FD69")
    @Override
    public void requestLayout() {
        {
            super.requestLayout();
        } //End block
        // ---------- Original Method ----------
        //if (!mUpdatingText) {
            //super.requestLayout();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.412 -0400", hash_original_method = "EAF924632CCF71246331B8833B944AA0", hash_generated_method = "553A7D05D6AA1CE950C55F0A33F47BF2")
     void updateAdapter(PagerAdapter oldAdapter, PagerAdapter newAdapter) {
        {
            oldAdapter.unregisterDataSetObserver(mPageListener);
            mWatchingAdapter = null;
        } //End block
        {
            newAdapter.registerDataSetObserver(mPageListener);
            mWatchingAdapter = new WeakReference<PagerAdapter>(newAdapter);
        } //End block
        {
            mLastKnownCurrentPage = -1;
            mLastKnownPositionOffset = -1;
            updateText(mPager.getCurrentItem(), newAdapter);
            requestLayout();
        } //End block
        addTaint(oldAdapter.getTaint());
        // ---------- Original Method ----------
        //if (oldAdapter != null) {
            //oldAdapter.unregisterDataSetObserver(mPageListener);
            //mWatchingAdapter = null;
        //}
        //if (newAdapter != null) {
            //newAdapter.registerDataSetObserver(mPageListener);
            //mWatchingAdapter = new WeakReference<PagerAdapter>(newAdapter);
        //}
        //if (mPager != null) {
            //mLastKnownCurrentPage = -1;
            //mLastKnownPositionOffset = -1;
            //updateText(mPager.getCurrentItem(), newAdapter);
            //requestLayout();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.433 -0400", hash_original_method = "4031212F20DB7BF6694A94FE5410BA3F", hash_generated_method = "E8A215BDFE25E097CE3B55333C6739D2")
     void updateTextPositions(int position, float positionOffset, boolean force) {
        {
            updateText(position, mPager.getAdapter());
        } //End block
        mUpdatingPositions = true;
        int prevWidth;
        prevWidth = mPrevText.getMeasuredWidth();
        int currWidth;
        currWidth = mCurrText.getMeasuredWidth();
        int nextWidth;
        nextWidth = mNextText.getMeasuredWidth();
        int halfCurrWidth;
        halfCurrWidth = currWidth / 2;
        int stripWidth;
        stripWidth = getWidth();
        int stripHeight;
        stripHeight = getHeight();
        int paddingLeft;
        paddingLeft = getPaddingLeft();
        int paddingRight;
        paddingRight = getPaddingRight();
        int paddingTop;
        paddingTop = getPaddingTop();
        int paddingBottom;
        paddingBottom = getPaddingBottom();
        int textPaddedLeft;
        textPaddedLeft = paddingLeft + halfCurrWidth;
        int textPaddedRight;
        textPaddedRight = paddingRight + halfCurrWidth;
        int contentWidth;
        contentWidth = stripWidth - textPaddedLeft - textPaddedRight;
        float currOffset;
        currOffset = positionOffset + 0.5f;
        {
            currOffset -= 1.f;
        } //End block
        int currCenter;
        currCenter = stripWidth - textPaddedRight - (int) (contentWidth * currOffset);
        int currLeft;
        currLeft = currCenter - currWidth / 2;
        int currRight;
        currRight = currLeft + currWidth;
        int prevBaseline;
        prevBaseline = mPrevText.getBaseline();
        int currBaseline;
        currBaseline = mCurrText.getBaseline();
        int nextBaseline;
        nextBaseline = mNextText.getBaseline();
        int maxBaseline;
        maxBaseline = Math.max(Math.max(prevBaseline, currBaseline), nextBaseline);
        int prevTopOffset;
        prevTopOffset = maxBaseline - prevBaseline;
        int currTopOffset;
        currTopOffset = maxBaseline - currBaseline;
        int nextTopOffset;
        nextTopOffset = maxBaseline - nextBaseline;
        int alignedPrevHeight;
        alignedPrevHeight = prevTopOffset + mPrevText.getMeasuredHeight();
        int alignedCurrHeight;
        alignedCurrHeight = currTopOffset + mCurrText.getMeasuredHeight();
        int alignedNextHeight;
        alignedNextHeight = nextTopOffset + mNextText.getMeasuredHeight();
        int maxTextHeight;
        maxTextHeight = Math.max(Math.max(alignedPrevHeight, alignedCurrHeight),
                alignedNextHeight);
        int vgrav;
        vgrav = mGravity & Gravity.VERTICAL_GRAVITY_MASK;
        int prevTop;
        int currTop;
        int nextTop;
        //Begin case default Gravity.TOP 
        prevTop = paddingTop + prevTopOffset;
        //End case default Gravity.TOP 
        //Begin case default Gravity.TOP 
        currTop = paddingTop + currTopOffset;
        //End case default Gravity.TOP 
        //Begin case default Gravity.TOP 
        nextTop = paddingTop + nextTopOffset;
        //End case default Gravity.TOP 
        //Begin case Gravity.CENTER_VERTICAL 
        int paddedHeight;
        paddedHeight = stripHeight - paddingTop - paddingBottom;
        //End case Gravity.CENTER_VERTICAL 
        //Begin case Gravity.CENTER_VERTICAL 
        int centeredTop;
        centeredTop = (paddedHeight - maxTextHeight) / 2;
        //End case Gravity.CENTER_VERTICAL 
        //Begin case Gravity.CENTER_VERTICAL 
        prevTop = centeredTop + prevTopOffset;
        //End case Gravity.CENTER_VERTICAL 
        //Begin case Gravity.CENTER_VERTICAL 
        currTop = centeredTop + currTopOffset;
        //End case Gravity.CENTER_VERTICAL 
        //Begin case Gravity.CENTER_VERTICAL 
        nextTop = centeredTop + nextTopOffset;
        //End case Gravity.CENTER_VERTICAL 
        //Begin case Gravity.BOTTOM 
        int bottomGravTop;
        bottomGravTop = stripHeight - paddingBottom - maxTextHeight;
        //End case Gravity.BOTTOM 
        //Begin case Gravity.BOTTOM 
        prevTop = bottomGravTop + prevTopOffset;
        //End case Gravity.BOTTOM 
        //Begin case Gravity.BOTTOM 
        currTop = bottomGravTop + currTopOffset;
        //End case Gravity.BOTTOM 
        //Begin case Gravity.BOTTOM 
        nextTop = bottomGravTop + nextTopOffset;
        //End case Gravity.BOTTOM 
        mCurrText.layout(currLeft, currTop, currRight,
                currTop + mCurrText.getMeasuredHeight());
        int prevLeft;
        prevLeft = Math.min(paddingLeft, currLeft - mScaledTextSpacing - prevWidth);
        mPrevText.layout(prevLeft, prevTop, prevLeft + prevWidth,
                prevTop + mPrevText.getMeasuredHeight());
        int nextLeft;
        nextLeft = Math.max(stripWidth - paddingRight - nextWidth,
                currRight + mScaledTextSpacing);
        mNextText.layout(nextLeft, nextTop, nextLeft + nextWidth,
                nextTop + mNextText.getMeasuredHeight());
        mLastKnownPositionOffset = positionOffset;
        mUpdatingPositions = false;
        addTaint(position);
        addTaint(force);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.449 -0400", hash_original_method = "51FB66892937CB37A2CA53CCF8BF865D", hash_generated_method = "41814E1A0AD3548E0EA0F4345E8F8BCE")
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        int widthMode;
        widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode;
        heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int widthSize;
        widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize;
        heightSize = MeasureSpec.getSize(heightMeasureSpec);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Must measure with an exact width");
        } //End block
        int childHeight;
        childHeight = heightSize;
        int minHeight;
        minHeight = getMinHeight();
        int padding;
        padding = 0;
        padding = getPaddingTop() + getPaddingBottom();
        childHeight -= padding;
        int childWidthSpec;
        childWidthSpec = MeasureSpec.makeMeasureSpec((int) (widthSize * 0.8f),
                MeasureSpec.AT_MOST);
        int childHeightSpec;
        childHeightSpec = MeasureSpec.makeMeasureSpec(childHeight, MeasureSpec.AT_MOST);
        mPrevText.measure(childWidthSpec, childHeightSpec);
        mCurrText.measure(childWidthSpec, childHeightSpec);
        mNextText.measure(childWidthSpec, childHeightSpec);
        {
            setMeasuredDimension(widthSize, heightSize);
        } //End block
        {
            int textHeight;
            textHeight = mCurrText.getMeasuredHeight();
            setMeasuredDimension(widthSize, Math.max(minHeight, textHeight + padding));
        } //End block
        addTaint(widthMeasureSpec);
        addTaint(heightMeasureSpec);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.450 -0400", hash_original_method = "EE71B2554045A13705C826A4155956FA", hash_generated_method = "CA7F586C592DF7ADD77F84757F368378")
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            float offset;
            offset = mLastKnownPositionOffset;
            offset = 0;
            updateTextPositions(mLastKnownCurrentPage, offset, true);
        } //End block
        addTaint(changed);
        addTaint(l);
        addTaint(t);
        addTaint(r);
        addTaint(b);
        // ---------- Original Method ----------
        //if (mPager != null) {
            //final float offset = mLastKnownPositionOffset >= 0 ? mLastKnownPositionOffset : 0;
            //updateTextPositions(mLastKnownCurrentPage, offset, true);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.450 -0400", hash_original_method = "5F597790016BBA247C3C04F7E22AC0D1", hash_generated_method = "4BB8F5F0AA0BFD96285DE64844B90749")
     int getMinHeight() {
        int minHeight;
        minHeight = 0;
        Drawable bg;
        bg = getBackground();
        {
            minHeight = bg.getIntrinsicHeight();
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_637416683 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_637416683;
        // ---------- Original Method ----------
        //int minHeight = 0;
        //final Drawable bg = getBackground();
        //if (bg != null) {
            //minHeight = bg.getIntrinsicHeight();
        //}
        //return minHeight;
    }

    
    static class PagerTitleStripImplBase implements PagerTitleStripImpl {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.450 -0400", hash_original_method = "F69C6EF9306BD49237C6BD65EE477BFD", hash_generated_method = "F69C6EF9306BD49237C6BD65EE477BFD")
        public PagerTitleStripImplBase ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.454 -0400", hash_original_method = "0CB06A06A9C05B0CCDFA7CD0E85CFD57", hash_generated_method = "DC9B20ECEE73785369EF3A5B51C3CB72")
        public void setSingleLineAllCaps(TextView text) {
            text.setSingleLine();
            addTaint(text.getTaint());
            // ---------- Original Method ----------
            //text.setSingleLine();
        }

        
    }


    
    static class PagerTitleStripImplIcs implements PagerTitleStripImpl {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.454 -0400", hash_original_method = "A7C2803E0C7980F7789FD2B4F1224805", hash_generated_method = "A7C2803E0C7980F7789FD2B4F1224805")
        public PagerTitleStripImplIcs ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.455 -0400", hash_original_method = "47ABCBC0DA420E91F72BDDE0CE8B03D5", hash_generated_method = "B1D9C1A9C578D9440BC0308108A3C8E9")
        public void setSingleLineAllCaps(TextView text) {
            PagerTitleStripIcs.setSingleLineAllCaps(text);
            addTaint(text.getTaint());
            // ---------- Original Method ----------
            //PagerTitleStripIcs.setSingleLineAllCaps(text);
        }

        
    }


    
    private class PageListener extends DataSetObserver implements ViewPager.OnPageChangeListener, ViewPager.OnAdapterChangeListener {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.455 -0400", hash_original_field = "792E9C42215FE7E19353556D05AC876B", hash_generated_field = "5762858524B9AF236C570FA132A73251")

        private int mScrollState;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.455 -0400", hash_original_method = "7F155FC4DE697EB9B965E1AE5F0C4BA5", hash_generated_method = "7F155FC4DE697EB9B965E1AE5F0C4BA5")
        public PageListener ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.455 -0400", hash_original_method = "6C358B1B424AD01247E78823B26F3317", hash_generated_method = "0479882258325BD62F9AB3A235A9EB8A")
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            updateTextPositions(position, positionOffset, false);
            addTaint(position);
            addTaint(positionOffset);
            addTaint(positionOffsetPixels);
            // ---------- Original Method ----------
            //if (positionOffset > 0.5f) {
                //position++;
            //}
            //updateTextPositions(position, positionOffset, false);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.471 -0400", hash_original_method = "BDE5366BD51457451209BD696A487B58", hash_generated_method = "938F88A31ABDE1F4CC51F0769C0C8799")
        @Override
        public void onPageSelected(int position) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            {
                updateText(mPager.getCurrentItem(), mPager.getAdapter());
                float offset;
                offset = mLastKnownPositionOffset;
                offset = 0;
                updateTextPositions(mPager.getCurrentItem(), offset, true);
            } //End block
            addTaint(position);
            // ---------- Original Method ----------
            //if (mScrollState == ViewPager.SCROLL_STATE_IDLE) {
                //updateText(mPager.getCurrentItem(), mPager.getAdapter());
                //final float offset = mLastKnownPositionOffset >= 0 ? mLastKnownPositionOffset : 0;
                //updateTextPositions(mPager.getCurrentItem(), offset, true);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.472 -0400", hash_original_method = "7D09E30D83D104D1B391B393C60F770D", hash_generated_method = "BEA820A471F67E44B05AC7485AEA4512")
        @Override
        public void onPageScrollStateChanged(int state) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            mScrollState = state;
            // ---------- Original Method ----------
            //mScrollState = state;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.473 -0400", hash_original_method = "61B15A1B041ED988FCE0F531C9B4D949", hash_generated_method = "031D2C6A847E244D986A5FC12BAD1016")
        @Override
        public void onAdapterChanged(PagerAdapter oldAdapter, PagerAdapter newAdapter) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            updateAdapter(oldAdapter, newAdapter);
            addTaint(oldAdapter.getTaint());
            addTaint(newAdapter.getTaint());
            // ---------- Original Method ----------
            //updateAdapter(oldAdapter, newAdapter);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.474 -0400", hash_original_method = "14F4D00F7C7AD3110DA52FF41E59ABFF", hash_generated_method = "DD52C67B8B86C72372E708F93543653D")
        @Override
        public void onChanged() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            updateText(mPager.getCurrentItem(), mPager.getAdapter());
            float offset;
            offset = mLastKnownPositionOffset;
            offset = 0;
            updateTextPositions(mPager.getCurrentItem(), offset, true);
            // ---------- Original Method ----------
            //updateText(mPager.getCurrentItem(), mPager.getAdapter());
            //final float offset = mLastKnownPositionOffset >= 0 ? mLastKnownPositionOffset : 0;
            //updateTextPositions(mPager.getCurrentItem(), offset, true);
        }

        
    }


    
    interface PagerTitleStripImpl {
        void setSingleLineAllCaps(TextView text);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.486 -0400", hash_original_field = "0F4AB8B8E2BCC5C75E5244A98D1E51FB", hash_generated_field = "59F18959DF001FD365B2D956AA5A172C")

    private static String TAG = "PagerTitleStrip";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.487 -0400", hash_original_field = "53FFF155BE155A31061220E99404FBCE", hash_generated_field = "F3AE002F6E57DA5D4CFC1DEACB8E7C24")

    private static int[] ATTRS = new int[] {
        android.R.attr.textAppearance,
        android.R.attr.textSize,
        android.R.attr.textColor,
        android.R.attr.gravity
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.495 -0400", hash_original_field = "67034624D0F2CA629E6D2C03E2697602", hash_generated_field = "3A4FA64BE23EC64E0E5D35E65C81A5D4")

    private static int[] TEXT_ATTRS = new int[] {
        0x0101038c 
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.495 -0400", hash_original_field = "85EE69D8A8BE27753C5062D3D2F97282", hash_generated_field = "54637E59C4FA66FE3CB07C6F57E34CDB")

    private static float SIDE_ALPHA = 0.6f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.495 -0400", hash_original_field = "9162897F2FC3F5DBA47C424CB7EE006B", hash_generated_field = "90F866EF5B5BC555242522A80CE7B246")

    private static int TEXT_SPACING = 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.495 -0400", hash_original_field = "27A9F92549363F04EF46148FE9E87EEE", hash_generated_field = "FC43287A1B05CC67CD71D2D929E632B7")

    private static PagerTitleStripImpl IMPL;
    static {
        if (android.os.Build.VERSION.SDK_INT >= 14) {
            IMPL = new PagerTitleStripImplIcs();
        } else {
            IMPL = new PagerTitleStripImplBase();
        }
    }
    
}

