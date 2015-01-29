package android.widget;

// Droidsafe Imports
import droidsafe.annotations.*;
import droidsafe.helpers.*;

import droidsafe.runtime.*;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import com.android.internal.R;

public class Switch extends CompoundButton {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:38.883 -0500", hash_original_field = "9979BC6E43385C8BFBFD00D12C1E2275", hash_generated_field = "6191CA7799994B85F015ACBC4A72ECF0")

    private static final int TOUCH_MODE_IDLE = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:38.885 -0500", hash_original_field = "CAE1E485CDFD3843F9F7D068150E8486", hash_generated_field = "C79D4D88CCB9B6DDFEBEEEBDDCAC18DF")

    private static final int TOUCH_MODE_DOWN = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:38.887 -0500", hash_original_field = "C5A0BD3FD42F1B08693B326BA30DF53B", hash_generated_field = "1C693615B4C4F2116D3600AD3C1B110A")

    private static final int TOUCH_MODE_DRAGGING = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:38.890 -0500", hash_original_field = "6E1FD7DF3E1622E164C31BB68A6FD043", hash_generated_field = "308BD7C2CCB94571F8E68E822492425A")

    private static final int SANS = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:38.892 -0500", hash_original_field = "75A0F9D31714322C507EC33A93FB0403", hash_generated_field = "AD8E248EA94D9FBB450731AC61EA4CF6")

    private static final int SERIF = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:38.895 -0500", hash_original_field = "C79FD66B7824EA0B8578C6118F1487E8", hash_generated_field = "1E362376CB7EB57CA2898CE49E4D3589")

    private static final int MONOSPACE = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:38.952 -0500", hash_original_field = "73791D998AED7A27216E6912B00269F9", hash_generated_field = "648B080756031EA789B9ECD9F36CC170")

    private static final int[] CHECKED_STATE_SET = {
        R.attr.state_checked
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:38.897 -0500", hash_original_field = "CC35B65C4DF6EB37FFE598AD0E85776D", hash_generated_field = "723113CD58F6B081A7D304DE131200C0")

    private Drawable mThumbDrawable;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:38.899 -0500", hash_original_field = "A90D7BED756182929175B8B430BA5712", hash_generated_field = "95BC711301E78A9ECDB61E242B32BBFC")

    private Drawable mTrackDrawable;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:38.901 -0500", hash_original_field = "26BAB6D7AA62A2DDC98C39FE36E7C453", hash_generated_field = "4B80EA12A43F45BEE4B8687EA4F9C608")

    private int mThumbTextPadding;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:38.903 -0500", hash_original_field = "393DFB71294DF2FDFDF450C9F942BBBF", hash_generated_field = "FE47678E8002C05470AB092D10E768CB")

    private int mSwitchMinWidth;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:38.905 -0500", hash_original_field = "185901082370909EBA41413FE037BCA3", hash_generated_field = "1354B22A77511E7AAF53A6D1AC0EC646")

    private int mSwitchPadding;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:38.907 -0500", hash_original_field = "769F2C0D0F3768558E3E71BB28929F11", hash_generated_field = "88910E09C0D7EF0865C6C6AF2A30F920")

    private CharSequence mTextOn;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:38.909 -0500", hash_original_field = "A802E7DF1BA0E3577A5B291A79D76CF7", hash_generated_field = "46E8A8BDEBA8D39F1C8B9DD255F9FFFF")

    private CharSequence mTextOff;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:38.911 -0500", hash_original_field = "0166621EFA26326BDA100AD828233350", hash_generated_field = "05391D3E5A92F1F9C57B26577E93BB8A")

    private int mTouchMode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:38.913 -0500", hash_original_field = "D11C33EFD56B37B918E01A200C446C59", hash_generated_field = "3B323323DD6A6BF972666D993592C670")

    private int mTouchSlop;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:38.915 -0500", hash_original_field = "46A957BD7BF7976FC061904F86C4B7C3", hash_generated_field = "1F740CEDE27892C1CBBFA617E652A24D")

    private float mTouchX;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:38.917 -0500", hash_original_field = "84E38DC58BB1878CECC280DD27F28A07", hash_generated_field = "1AB3677D77377F6AD3BD836FBA85AC6A")

    private float mTouchY;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:38.919 -0500", hash_original_field = "6EF117646CB24AA11D98A55DD8C4939C", hash_generated_field = "C838551A2063BBB11D3BCBAACD84F0C0")

    private VelocityTracker mVelocityTracker = VelocityTracker.obtain();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:38.922 -0500", hash_original_field = "46F119E0C9C890082D25CDB1CBAA6A3C", hash_generated_field = "FF438FC8C4FA40788FE8D6220E7ED672")

    private int mMinFlingVelocity;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:38.924 -0500", hash_original_field = "C04626F5E88EAACF501FEF71DF86A502", hash_generated_field = "F988D54F9B1F33137D2E224F4C0D3687")

    private float mThumbPosition;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:38.926 -0500", hash_original_field = "ADC31869EAFD9B237AE6DC2EB7E363E5", hash_generated_field = "E445BAA52D3DABA04B0C4E748520EC39")

    private int mSwitchWidth;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:38.928 -0500", hash_original_field = "41813E52E3EC85B3D53562B71DCFC876", hash_generated_field = "616327EE38810A9DEF7A790FD1EC56B1")

    private int mSwitchHeight;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:38.931 -0500", hash_original_field = "701EB62324FA53C4D993BB518A36511B", hash_generated_field = "C44690E186E83CD4E656AD8BCE481FD0")

    private int mThumbWidth;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:38.933 -0500", hash_original_field = "0CE159F0F431A6020F50CDE4F638B5A4", hash_generated_field = "27A13FA81AC36C1C7B7A455273DF1B68")

    private int mSwitchLeft;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:38.935 -0500", hash_original_field = "B8B2530C649DAD44D23C1920D9585B5F", hash_generated_field = "ECDF185842EB33043CD213F2E4D31DD2")

    private int mSwitchTop;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:38.937 -0500", hash_original_field = "E2173665EA68A17A642C076A5FC954D0", hash_generated_field = "85F67C619595B345CB20C710FBCA2797")

    private int mSwitchRight;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:38.939 -0500", hash_original_field = "930BA55275CCB79E58E576673AFF81B9", hash_generated_field = "A803681FEBCE7BFB2E3081B27996D80A")

    private int mSwitchBottom;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:38.941 -0500", hash_original_field = "0A19A1954ABA26FA39E555FE892A4ABD", hash_generated_field = "6AD5EFC1421B741B1A8F78A5B815BBFE")

    private TextPaint mTextPaint;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:38.943 -0500", hash_original_field = "436AA1E4B034214040D84D3E7144D335", hash_generated_field = "06CA2F66604DADF822AA39C486035A89")

    private ColorStateList mTextColors;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:38.946 -0500", hash_original_field = "D838467D26B99EA6C8EB951B288D1F04", hash_generated_field = "F06715C8A97FAF124BA6D651D138C505")

    private Layout mOnLayout;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:38.948 -0500", hash_original_field = "1E93F6EF98FCA151988DE07E57AF6C8F", hash_generated_field = "E0FE10CB210A6BEA4B76EAAF1CE29703")

    private Layout mOffLayout;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:38.950 -0500", hash_original_field = "1732EB32F2D77CCA26590AEEA670A175", hash_generated_field = "AEB9EF736E47F0CD4747F7C2B6703936")

    @SuppressWarnings("hiding")
    private final Rect mTempRect = new Rect();

    /**
     * Construct a new Switch with default styling.
     *
     * @param context The Context that will determine this widget's theming.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:38.955 -0500", hash_original_method = "A519C4334A107DCE43F6A6D72AE8F654", hash_generated_method = "C17E9A35FEB240A0BF8BBDE9F07315B8")
    
public Switch(Context context) {
        this(context, null);
    }

    /**
     * Construct a new Switch with default styling, overriding specific style
     * attributes as requested.
     *
     * @param context The Context that will determine this widget's theming.
     * @param attrs Specification of attributes that should deviate from default styling.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:38.957 -0500", hash_original_method = "0FB069D8C375377E937B40F8D8C213ED", hash_generated_method = "BAC494EA4140FA064A4C6448498E2454")
    
public Switch(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.switchStyle);
    }

    /**
     * Construct a new Switch with a default style determined by the given theme attribute,
     * overriding specific style attributes as requested.
     *
     * @param context The Context that will determine this widget's theming.
     * @param attrs Specification of attributes that should deviate from the default styling.
     * @param defStyle An attribute ID within the active theme containing a reference to the
     *                 default style for this widget. e.g. android.R.attr.switchStyle.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:38.961 -0500", hash_original_method = "7052304410F6ACDD18F00D1DE979132C", hash_generated_method = "BB80C96EAFAACFABC6CADBC976E9EB8F")
    
public Switch(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        mTextPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG);
        Resources res = getResources();
        mTextPaint.density = res.getDisplayMetrics().density;
        mTextPaint.setCompatibilityScaling(res.getCompatibilityInfo().applicationScale);

        TypedArray a = context.obtainStyledAttributes(attrs,
                com.android.internal.R.styleable.Switch, defStyle, 0);

        mThumbDrawable = a.getDrawable(com.android.internal.R.styleable.Switch_thumb);
        mTrackDrawable = a.getDrawable(com.android.internal.R.styleable.Switch_track);
        mTextOn = a.getText(com.android.internal.R.styleable.Switch_textOn);
        mTextOff = a.getText(com.android.internal.R.styleable.Switch_textOff);
        mThumbTextPadding = a.getDimensionPixelSize(
                com.android.internal.R.styleable.Switch_thumbTextPadding, 0);
        mSwitchMinWidth = a.getDimensionPixelSize(
                com.android.internal.R.styleable.Switch_switchMinWidth, 0);
        mSwitchPadding = a.getDimensionPixelSize(
                com.android.internal.R.styleable.Switch_switchPadding, 0);

        int appearance = a.getResourceId(
                com.android.internal.R.styleable.Switch_switchTextAppearance, 0);
        if (appearance != 0) {
            setSwitchTextAppearance(context, appearance);
        }
        a.recycle();

        ViewConfiguration config = ViewConfiguration.get(context);
        mTouchSlop = config.getScaledTouchSlop();
        mMinFlingVelocity = config.getScaledMinimumFlingVelocity();

        // Refresh display with current params
        refreshDrawableState();
        setChecked(isChecked());
    }

    /**
     * Sets the switch text color, size, style, hint color, and highlight color
     * from the specified TextAppearance resource.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:38.964 -0500", hash_original_method = "D688751389B30165717277DD9DF1E478", hash_generated_method = "73E1EB1B05696ABE6E61B4459E7367C0")
    
public void setSwitchTextAppearance(Context context, int resid) {
        TypedArray appearance =
                context.obtainStyledAttributes(resid,
                        com.android.internal.R.styleable.TextAppearance);

        ColorStateList colors;
        int ts;

        colors = appearance.getColorStateList(com.android.internal.R.styleable.
                TextAppearance_textColor);
        if (colors != null) {
            mTextColors = colors;
        } else {
            // If no color set in TextAppearance, default to the view's textColor
            mTextColors = getTextColors();
        }

        ts = appearance.getDimensionPixelSize(com.android.internal.R.styleable.
                TextAppearance_textSize, 0);
        if (ts != 0) {
            if (ts != mTextPaint.getTextSize()) {
                mTextPaint.setTextSize(ts);
                requestLayout();
            }
        }

        int typefaceIndex, styleIndex;

        typefaceIndex = appearance.getInt(com.android.internal.R.styleable.
                TextAppearance_typeface, -1);
        styleIndex = appearance.getInt(com.android.internal.R.styleable.
                TextAppearance_textStyle, -1);

        setSwitchTypefaceByIndex(typefaceIndex, styleIndex);

        appearance.recycle();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:38.966 -0500", hash_original_method = "667B994D675EC27CF64612287AF7A922", hash_generated_method = "9F214B4B0CA568C5CDAFDE925F51AD5A")
    
private void setSwitchTypefaceByIndex(int typefaceIndex, int styleIndex) {
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

        setSwitchTypeface(tf, styleIndex);
    }

    /**
     * Sets the typeface and style in which the text should be displayed on the
     * switch, and turns on the fake bold and italic bits in the Paint if the
     * Typeface that you provided does not have all the bits in the
     * style that you specified.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:38.969 -0500", hash_original_method = "C023070590A87D2CA3EA267526ED6F0D", hash_generated_method = "F82FC8B41E25F3BB3EF7EE112D71DCB5")
    
public void setSwitchTypeface(Typeface tf, int style) {
        if (style > 0) {
            if (tf == null) {
                tf = Typeface.defaultFromStyle(style);
            } else {
                tf = Typeface.create(tf, style);
            }

            setSwitchTypeface(tf);
            // now compute what (if any) algorithmic styling is needed
            int typefaceStyle = tf != null ? tf.getStyle() : 0;
            int need = style & ~typefaceStyle;
            mTextPaint.setFakeBoldText((need & Typeface.BOLD) != 0);
            mTextPaint.setTextSkewX((need & Typeface.ITALIC) != 0 ? -0.25f : 0);
        } else {
            mTextPaint.setFakeBoldText(false);
            mTextPaint.setTextSkewX(0);
            setSwitchTypeface(tf);
        }
    }

    /**
     * Sets the typeface in which the text should be displayed on the switch.
     * Note that not all Typeface families actually have bold and italic
     * variants, so you may need to use
     * {@link #setSwitchTypeface(Typeface, int)} to get the appearance
     * that you actually want.
     *
     * @attr ref android.R.styleable#TextView_typeface
     * @attr ref android.R.styleable#TextView_textStyle
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:38.971 -0500", hash_original_method = "543DA1ECFCDDAA3B3698B41BEC9D49BA", hash_generated_method = "0BCBDD8F56261AD4228B03AE6ADEBAA3")
    
public void setSwitchTypeface(Typeface tf) {
        if (mTextPaint.getTypeface() != tf) {
            mTextPaint.setTypeface(tf);

            requestLayout();
            invalidate();
        }
    }

    /**
     * Returns the text displayed when the button is in the checked state.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:38.973 -0500", hash_original_method = "5C0E5388314CF71485B1BF56327EECD2", hash_generated_method = "88C8DD18DC57878BA442223FAB42DEBF")
    
public CharSequence getTextOn() {
        return mTextOn;
    }

    /**
     * Sets the text displayed when the button is in the checked state.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:38.975 -0500", hash_original_method = "6FFD0F84C29886200B9EFC80768CA614", hash_generated_method = "0E59F8A48AC69773E5613365EA431CC7")
    
public void setTextOn(CharSequence textOn) {
        mTextOn = textOn;
        requestLayout();
    }

    /**
     * Returns the text displayed when the button is not in the checked state.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:38.977 -0500", hash_original_method = "EAEA80D56F502C97F845DE2B9DA853EF", hash_generated_method = "849DDC2D49CECB6A57382D582199C99E")
    
public CharSequence getTextOff() {
        return mTextOff;
    }

    /**
     * Sets the text displayed when the button is not in the checked state.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:38.980 -0500", hash_original_method = "D6EC5A221EB0AF6C7F25B9FE392EF4CC", hash_generated_method = "EC8B2C2D1C97FDE143246B6B3B9CBFCE")
    
public void setTextOff(CharSequence textOff) {
        mTextOff = textOff;
        requestLayout();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:38.983 -0500", hash_original_method = "13BAC45BF6F94061A5C888CE492B7F47", hash_generated_method = "55F7AE5B882AE333AA81371DAE3A442B")
    
@Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        final int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        final int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        if (mOnLayout == null) {
            mOnLayout = makeLayout(mTextOn);
        }
        if (mOffLayout == null) {
            mOffLayout = makeLayout(mTextOff);
        }

        mTrackDrawable.getPadding(mTempRect);
        final int maxTextWidth = Math.max(mOnLayout.getWidth(), mOffLayout.getWidth());
        final int switchWidth = Math.max(mSwitchMinWidth,
                maxTextWidth * 2 + mThumbTextPadding * 4 + mTempRect.left + mTempRect.right);
        final int switchHeight = mTrackDrawable.getIntrinsicHeight();

        mThumbWidth = maxTextWidth + mThumbTextPadding * 2;

        switch (widthMode) {
            case MeasureSpec.AT_MOST:
                widthSize = Math.min(widthSize, switchWidth);
                break;

            case MeasureSpec.UNSPECIFIED:
                widthSize = switchWidth;
                break;

            case MeasureSpec.EXACTLY:
                // Just use what we were given
                break;
        }

        switch (heightMode) {
            case MeasureSpec.AT_MOST:
                heightSize = Math.min(heightSize, switchHeight);
                break;

            case MeasureSpec.UNSPECIFIED:
                heightSize = switchHeight;
                break;

            case MeasureSpec.EXACTLY:
                // Just use what we were given
                break;
        }

        mSwitchWidth = switchWidth;
        mSwitchHeight = switchHeight;

        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        final int measuredHeight = getMeasuredHeight();
        if (measuredHeight < switchHeight) {
            setMeasuredDimension(getMeasuredWidthAndState(), switchHeight);
        }
    }

    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:38.985 -0500", hash_original_method = "48254B36708A3254CD52161026ABD6F4", hash_generated_method = "68F9235CF4829EF977755A61FC2CDF9F")
    
@Override
    public void onPopulateAccessibilityEvent(AccessibilityEvent event) {
        super.onPopulateAccessibilityEvent(event);
        if (isChecked()) {
            CharSequence text = mOnLayout.getText();
            if (TextUtils.isEmpty(text)) {
                text = mContext.getString(R.string.switch_on);
            }
            event.getText().add(text);
        } else {
            CharSequence text = mOffLayout.getText();
            if (TextUtils.isEmpty(text)) {
                text = mContext.getString(R.string.switch_off);
            }
            event.getText().add(text);
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:38.987 -0500", hash_original_method = "D1466C388B2346E8DF10ED51CFBEA0FC", hash_generated_method = "D8C92525C7A7973F0C0D40F73B8E8C07")
    
private Layout makeLayout(CharSequence text) {
        return new StaticLayout(text, mTextPaint,
                (int) Math.ceil(Layout.getDesiredWidth(text, mTextPaint)),
                Layout.Alignment.ALIGN_NORMAL, 1.f, 0, true);
    }

    /**
     * @return true if (x, y) is within the target area of the switch thumb
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:38.990 -0500", hash_original_method = "EC82A35D1017AC4F050030BE5A651660", hash_generated_method = "4C603F1D40FEECCAC0350BF15A939038")
    
private boolean hitThumb(float x, float y) {
        mThumbDrawable.getPadding(mTempRect);
        final int thumbTop = mSwitchTop - mTouchSlop;
        final int thumbLeft = mSwitchLeft + (int) (mThumbPosition + 0.5f) - mTouchSlop;
        final int thumbRight = thumbLeft + mThumbWidth +
                mTempRect.left + mTempRect.right + mTouchSlop;
        final int thumbBottom = mSwitchBottom + mTouchSlop;
        return x > thumbLeft && x < thumbRight && y > thumbTop && y < thumbBottom;
    }

    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:38.993 -0500", hash_original_method = "BEA9271A473068780C9D1CF1D0CB8717", hash_generated_method = "3803E2F449F9B58446BF4B2A0AAA0821")
    
@Override
    public boolean onTouchEvent(MotionEvent ev) {
        mVelocityTracker.addMovement(ev);
        final int action = ev.getActionMasked();
        switch (action) {
            case MotionEvent.ACTION_DOWN: {
                final float x = ev.getX();
                final float y = ev.getY();
                if (isEnabled() && hitThumb(x, y)) {
                    mTouchMode = TOUCH_MODE_DOWN;
                    mTouchX = x;
                    mTouchY = y;
                }
                break;
            }

            case MotionEvent.ACTION_MOVE: {
                switch (mTouchMode) {
                    case TOUCH_MODE_IDLE:
                        // Didn't target the thumb, treat normally.
                        break;

                    case TOUCH_MODE_DOWN: {
                        final float x = ev.getX();
                        final float y = ev.getY();
                        if (Math.abs(x - mTouchX) > mTouchSlop ||
                                Math.abs(y - mTouchY) > mTouchSlop) {
                            mTouchMode = TOUCH_MODE_DRAGGING;
                            getParent().requestDisallowInterceptTouchEvent(true);
                            mTouchX = x;
                            mTouchY = y;
                            return true;
                        }
                        break;
                    }

                    case TOUCH_MODE_DRAGGING: {
                        final float x = ev.getX();
                        final float dx = x - mTouchX;
                        float newPos = Math.max(0,
                                Math.min(mThumbPosition + dx, getThumbScrollRange()));
                        if (newPos != mThumbPosition) {
                            mThumbPosition = newPos;
                            mTouchX = x;
                            invalidate();
                        }
                        return true;
                    }
                }
                break;
            }

            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL: {
                if (mTouchMode == TOUCH_MODE_DRAGGING) {
                    stopDrag(ev);
                    return true;
                }
                mTouchMode = TOUCH_MODE_IDLE;
                mVelocityTracker.clear();
                break;
            }
        }

        return super.onTouchEvent(ev);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:38.996 -0500", hash_original_method = "C7212DC872D0065CD5A602E451EED0FD", hash_generated_method = "02B79B21F5F37A4E69C03FB3C48585BB")
    
private void cancelSuperTouch(MotionEvent ev) {
        MotionEvent cancel = MotionEvent.obtain(ev);
        cancel.setAction(MotionEvent.ACTION_CANCEL);
        super.onTouchEvent(cancel);
        cancel.recycle();
    }

    /**
     * Called from onTouchEvent to end a drag operation.
     *
     * @param ev Event that triggered the end of drag mode - ACTION_UP or ACTION_CANCEL
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:38.999 -0500", hash_original_method = "6053E208B701C67F21F78DB5D1D6AC6A", hash_generated_method = "491F5DDF5DBDD960B484D5DC883459C0")
    
private void stopDrag(MotionEvent ev) {
        mTouchMode = TOUCH_MODE_IDLE;
        // Up and not canceled, also checks the switch has not been disabled during the drag
        boolean commitChange = ev.getAction() == MotionEvent.ACTION_UP && isEnabled();

        cancelSuperTouch(ev);

        if (commitChange) {
            boolean newState;
            mVelocityTracker.computeCurrentVelocity(1000);
            float xvel = mVelocityTracker.getXVelocity();
            if (Math.abs(xvel) > mMinFlingVelocity) {
                newState = xvel > 0;
            } else {
                newState = getTargetCheckedState();
            }
            animateThumbToCheckedState(newState);
        } else {
            animateThumbToCheckedState(isChecked());
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:39.001 -0500", hash_original_method = "7C8C019C9C57DB27BCCABCAFF8863202", hash_generated_method = "41F5DD15070328B26087D46F930E061F")
    
private void animateThumbToCheckedState(boolean newCheckedState) {
        // TODO animate!
        //float targetPos = newCheckedState ? 0 : getThumbScrollRange();
        //mThumbPosition = targetPos;
        setChecked(newCheckedState);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:39.003 -0500", hash_original_method = "49A1E38FB4C1D1775597A6823232C034", hash_generated_method = "73086EA9F7B46B40F8A783B0BCA4CE2C")
    
private boolean getTargetCheckedState() {
        return mThumbPosition >= getThumbScrollRange() / 2;
    }

    @DSComment("Switch, UI only")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:39.005 -0500", hash_original_method = "523B4C6A0F0C2AD264BC263A9EEF64F2", hash_generated_method = "FDD4E576576EBC4CBE518A8A70E671CF")
    
@Override
    public void setChecked(boolean checked) {
        super.setChecked(checked);
        mThumbPosition = checked ? getThumbScrollRange() : 0;
        invalidate();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:39.008 -0500", hash_original_method = "12EE2ABDB63D99AE62C7AA4AFB810394", hash_generated_method = "350F8AF9AC647B5688F91A168CFB8CC4")
    
@Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);

        mThumbPosition = isChecked() ? getThumbScrollRange() : 0;

        int switchRight = getWidth() - getPaddingRight();
        int switchLeft = switchRight - mSwitchWidth;
        int switchTop = 0;
        int switchBottom = 0;
        switch (getGravity() & Gravity.VERTICAL_GRAVITY_MASK) {
            default:
            case Gravity.TOP:
                switchTop = getPaddingTop();
                switchBottom = switchTop + mSwitchHeight;
                break;

            case Gravity.CENTER_VERTICAL:
                switchTop = (getPaddingTop() + getHeight() - getPaddingBottom()) / 2 -
                        mSwitchHeight / 2;
                switchBottom = switchTop + mSwitchHeight;
                break;

            case Gravity.BOTTOM:
                switchBottom = getHeight() - getPaddingBottom();
                switchTop = switchBottom - mSwitchHeight;
                break;
        }

        mSwitchLeft = switchLeft;
        mSwitchTop = switchTop;
        mSwitchBottom = switchBottom;
        mSwitchRight = switchRight;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:39.011 -0500", hash_original_method = "8EF5F4DDEE2B0F2714B687B8F02D0637", hash_generated_method = "D18DB1F7E35D8E5BEC5243BB7662DDA0")
    
@Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // Draw the switch
        int switchLeft = mSwitchLeft;
        int switchTop = mSwitchTop;
        int switchRight = mSwitchRight;
        int switchBottom = mSwitchBottom;

        mTrackDrawable.setBounds(switchLeft, switchTop, switchRight, switchBottom);
        mTrackDrawable.draw(canvas);

        canvas.save();

        mTrackDrawable.getPadding(mTempRect);
        int switchInnerLeft = switchLeft + mTempRect.left;
        int switchInnerTop = switchTop + mTempRect.top;
        int switchInnerRight = switchRight - mTempRect.right;
        int switchInnerBottom = switchBottom - mTempRect.bottom;
        canvas.clipRect(switchInnerLeft, switchTop, switchInnerRight, switchBottom);

        mThumbDrawable.getPadding(mTempRect);
        final int thumbPos = (int) (mThumbPosition + 0.5f);
        int thumbLeft = switchInnerLeft - mTempRect.left + thumbPos;
        int thumbRight = switchInnerLeft + thumbPos + mThumbWidth + mTempRect.right;

        mThumbDrawable.setBounds(thumbLeft, switchTop, thumbRight, switchBottom);
        mThumbDrawable.draw(canvas);

        // mTextColors should not be null, but just in case
        if (mTextColors != null) {
            mTextPaint.setColor(mTextColors.getColorForState(getDrawableState(),
                    mTextColors.getDefaultColor()));
        }
        mTextPaint.drawableState = getDrawableState();

        Layout switchText = getTargetCheckedState() ? mOnLayout : mOffLayout;

        canvas.translate((thumbLeft + thumbRight) / 2 - switchText.getWidth() / 2,
                (switchInnerTop + switchInnerBottom) / 2 - switchText.getHeight() / 2);
        switchText.draw(canvas);

        canvas.restore();
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:39.014 -0500", hash_original_method = "C22AF595E85F3FD93263583BC3DF92ED", hash_generated_method = "23C197D675F68CF79053E814C001C6B3")
    
@Override
    public int getCompoundPaddingRight() {
        int padding = super.getCompoundPaddingRight() + mSwitchWidth;
        if (!TextUtils.isEmpty(getText())) {
            padding += mSwitchPadding;
        }
        return padding;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:39.016 -0500", hash_original_method = "B890BAF452343CC74FA34D76EC58FC5C", hash_generated_method = "F35C8F9DD5E41788228A9AEFDAFFA43D")
    
private int getThumbScrollRange() {
        if (mTrackDrawable == null) {
            return 0;
        }
        mTrackDrawable.getPadding(mTempRect);
        return mSwitchWidth - mThumbWidth - mTempRect.left - mTempRect.right;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:39.018 -0500", hash_original_method = "E661308564BAD0BE96E34DA026589671", hash_generated_method = "5E8E36BFCD9C1913662CF74C63EBB21F")
    
@Override
    protected int[] onCreateDrawableState(int extraSpace) {
        final int[] drawableState = super.onCreateDrawableState(extraSpace + 1);
        if (isChecked()) {
            mergeDrawableStates(drawableState, CHECKED_STATE_SET);
        }
        return drawableState;
    }

    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:39.021 -0500", hash_original_method = "DBFC9AA6074AC9C1F36B3AF225F67863", hash_generated_method = "35B8184BAFAF236CA852885CAF972486")
    
@Override
    protected void drawableStateChanged() {
        super.drawableStateChanged();

        int[] myDrawableState = getDrawableState();

        // Set the state of the Drawable
        // Drawable may be null when checked state is set from XML, from super constructor
        if (mThumbDrawable != null) mThumbDrawable.setState(myDrawableState);
        if (mTrackDrawable != null) mTrackDrawable.setState(myDrawableState);

        invalidate();
    }

    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:39.023 -0500", hash_original_method = "1DDC7918114D3BA198855AEA4718194D", hash_generated_method = "6435E9B4FE47DB85E6037CF0706B949A")
    
@Override
    protected boolean verifyDrawable(Drawable who) {
        return super.verifyDrawable(who) || who == mThumbDrawable || who == mTrackDrawable;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:39.025 -0500", hash_original_method = "B8A29477D7D79C90248691E663D147EB", hash_generated_method = "9F70E442D1413F4621A334D880730DCC")
    
@Override
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        mThumbDrawable.jumpToCurrentState();
        mTrackDrawable.jumpToCurrentState();
    }
}

