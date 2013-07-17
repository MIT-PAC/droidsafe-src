package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:54.949 -0400", hash_original_field = "E4F0AC5F69FC7254EF772878E84BE9AD", hash_generated_field = "723113CD58F6B081A7D304DE131200C0")

    private Drawable mThumbDrawable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:54.951 -0400", hash_original_field = "25A0A5DB31F18B827384634F1DF122D7", hash_generated_field = "95BC711301E78A9ECDB61E242B32BBFC")

    private Drawable mTrackDrawable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:54.952 -0400", hash_original_field = "91295B4A817A1771EF09922E50C3AB68", hash_generated_field = "4B80EA12A43F45BEE4B8687EA4F9C608")

    private int mThumbTextPadding;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:54.953 -0400", hash_original_field = "CFECB00315B6D7645632F403D165CBE7", hash_generated_field = "FE47678E8002C05470AB092D10E768CB")

    private int mSwitchMinWidth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:54.954 -0400", hash_original_field = "345EF348BB266FB89933C566AC1B956E", hash_generated_field = "1354B22A77511E7AAF53A6D1AC0EC646")

    private int mSwitchPadding;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:54.957 -0400", hash_original_field = "B8D771293243D6B66B9BDFE3767FA658", hash_generated_field = "88910E09C0D7EF0865C6C6AF2A30F920")

    private CharSequence mTextOn;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:54.958 -0400", hash_original_field = "F9730C00EAB435441597544B6A3333AB", hash_generated_field = "46E8A8BDEBA8D39F1C8B9DD255F9FFFF")

    private CharSequence mTextOff;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:54.958 -0400", hash_original_field = "3EE6E9DD4A34C3EFEC82F0840734559C", hash_generated_field = "05391D3E5A92F1F9C57B26577E93BB8A")

    private int mTouchMode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:54.959 -0400", hash_original_field = "3DFFFAD10926598D18EEC50D61DE79CA", hash_generated_field = "3B323323DD6A6BF972666D993592C670")

    private int mTouchSlop;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:54.960 -0400", hash_original_field = "1FC9B54FE13BA42BE9A522640C5C578A", hash_generated_field = "1F740CEDE27892C1CBBFA617E652A24D")

    private float mTouchX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:54.960 -0400", hash_original_field = "A721014F64789DED6C16D445847F275C", hash_generated_field = "1AB3677D77377F6AD3BD836FBA85AC6A")

    private float mTouchY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:54.961 -0400", hash_original_field = "BCB120539C976E78B4F73FCF43A17970", hash_generated_field = "C838551A2063BBB11D3BCBAACD84F0C0")

    private VelocityTracker mVelocityTracker = VelocityTracker.obtain();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:54.962 -0400", hash_original_field = "63BC75FF9D4C28774664B2BC28696494", hash_generated_field = "FF438FC8C4FA40788FE8D6220E7ED672")

    private int mMinFlingVelocity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:54.962 -0400", hash_original_field = "A7354FE918DDCC244E18EBC77D2C6A00", hash_generated_field = "F988D54F9B1F33137D2E224F4C0D3687")

    private float mThumbPosition;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:54.963 -0400", hash_original_field = "D56199DB7070ACB740D49D9F49A30002", hash_generated_field = "E445BAA52D3DABA04B0C4E748520EC39")

    private int mSwitchWidth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:54.964 -0400", hash_original_field = "70477094890ADB318F4521E237E82720", hash_generated_field = "616327EE38810A9DEF7A790FD1EC56B1")

    private int mSwitchHeight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:54.966 -0400", hash_original_field = "58CE2FBF0B2F97C67636FC1770749FEE", hash_generated_field = "C44690E186E83CD4E656AD8BCE481FD0")

    private int mThumbWidth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:54.967 -0400", hash_original_field = "AA89EC22221FA320B7BC48EFFE62FA70", hash_generated_field = "27A13FA81AC36C1C7B7A455273DF1B68")

    private int mSwitchLeft;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:54.968 -0400", hash_original_field = "5B9EAF8DCE0E5BD9511802F62BA97361", hash_generated_field = "ECDF185842EB33043CD213F2E4D31DD2")

    private int mSwitchTop;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:54.969 -0400", hash_original_field = "E035EADCCFB85BC5E670D00CA8A5876A", hash_generated_field = "85F67C619595B345CB20C710FBCA2797")

    private int mSwitchRight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:54.970 -0400", hash_original_field = "BCBFF68A061E95BA86FF4819D5D96263", hash_generated_field = "A803681FEBCE7BFB2E3081B27996D80A")

    private int mSwitchBottom;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:54.971 -0400", hash_original_field = "A623C6B7D6CD75F8A26EF2CAD7479AA5", hash_generated_field = "6AD5EFC1421B741B1A8F78A5B815BBFE")

    private TextPaint mTextPaint;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:54.972 -0400", hash_original_field = "9FDEA418DA756F2F03FAA0822A11BF8D", hash_generated_field = "06CA2F66604DADF822AA39C486035A89")

    private ColorStateList mTextColors;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:54.973 -0400", hash_original_field = "2FBA6417BFDCC07E23F3D5085C2DE2EC", hash_generated_field = "F06715C8A97FAF124BA6D651D138C505")

    private Layout mOnLayout;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:54.974 -0400", hash_original_field = "84421618B0DA3758EAFEC426C34BEF92", hash_generated_field = "E0FE10CB210A6BEA4B76EAAF1CE29703")

    private Layout mOffLayout;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:54.975 -0400", hash_original_field = "DF43B278CEE8933271AB3D9F9E312F86", hash_generated_field = "AEB9EF736E47F0CD4747F7C2B6703936")

    @SuppressWarnings("hiding") private final Rect mTempRect = new Rect();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:54.977 -0400", hash_original_method = "A519C4334A107DCE43F6A6D72AE8F654", hash_generated_method = "5C7F1BD13C94F692EF65C9AB4BE954F3")
    public  Switch(Context context) {
        this(context, null);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:54.981 -0400", hash_original_method = "0FB069D8C375377E937B40F8D8C213ED", hash_generated_method = "F49ABE52E58F4D1E621DE50EAAB7078B")
    public  Switch(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.switchStyle);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.001 -0400", hash_original_method = "7052304410F6ACDD18F00D1DE979132C", hash_generated_method = "881A214A64681322518769C468F5AC13")
    public  Switch(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        addTaint(defStyle);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
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
        if(appearance != 0)        
        {
            setSwitchTextAppearance(context, appearance);
        } //End block
        a.recycle();
        ViewConfiguration config = ViewConfiguration.get(context);
        mTouchSlop = config.getScaledTouchSlop();
        mMinFlingVelocity = config.getScaledMinimumFlingVelocity();
        refreshDrawableState();
        setChecked(isChecked());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.017 -0400", hash_original_method = "D688751389B30165717277DD9DF1E478", hash_generated_method = "DFB35D25EB7B121FADC488F32CDE61EE")
    public void setSwitchTextAppearance(Context context, int resid) {
        addTaint(resid);
        addTaint(context.getTaint());
        TypedArray appearance = context.obtainStyledAttributes(resid,
                        com.android.internal.R.styleable.TextAppearance);
        ColorStateList colors;
        int ts;
        colors = appearance.getColorStateList(com.android.internal.R.styleable.
                TextAppearance_textColor);
        if(colors != null)        
        {
            mTextColors = colors;
        } //End block
        else
        {
            mTextColors = getTextColors();
        } //End block
        ts = appearance.getDimensionPixelSize(com.android.internal.R.styleable.
                TextAppearance_textSize, 0);
        if(ts != 0)        
        {
            if(ts != mTextPaint.getTextSize())            
            {
                mTextPaint.setTextSize(ts);
                requestLayout();
            } //End block
        } //End block
        int typefaceIndex;
        int styleIndex;
        typefaceIndex = appearance.getInt(com.android.internal.R.styleable.
                TextAppearance_typeface, -1);
        styleIndex = appearance.getInt(com.android.internal.R.styleable.
                TextAppearance_textStyle, -1);
        setSwitchTypefaceByIndex(typefaceIndex, styleIndex);
        appearance.recycle();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.025 -0400", hash_original_method = "667B994D675EC27CF64612287AF7A922", hash_generated_method = "1D8E63C4B68720CCFB3037715CE9C326")
    private void setSwitchTypefaceByIndex(int typefaceIndex, int styleIndex) {
        addTaint(styleIndex);
        addTaint(typefaceIndex);
        Typeface tf = null;
switch(typefaceIndex){
        case SANS:
        tf = Typeface.SANS_SERIF;
        break;
        case SERIF:
        tf = Typeface.SERIF;
        break;
        case MONOSPACE:
        tf = Typeface.MONOSPACE;
        break;
}        setSwitchTypeface(tf, styleIndex);
        // ---------- Original Method ----------
        //Typeface tf = null;
        //switch (typefaceIndex) {
            //case SANS:
                //tf = Typeface.SANS_SERIF;
                //break;
            //case SERIF:
                //tf = Typeface.SERIF;
                //break;
            //case MONOSPACE:
                //tf = Typeface.MONOSPACE;
                //break;
        //}
        //setSwitchTypeface(tf, styleIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.032 -0400", hash_original_method = "C023070590A87D2CA3EA267526ED6F0D", hash_generated_method = "E6DA1F171F64558C344DDAFB9DB7EE06")
    public void setSwitchTypeface(Typeface tf, int style) {
        addTaint(style);
        addTaint(tf.getTaint());
        if(style > 0)        
        {
            if(tf == null)            
            {
                tf = Typeface.defaultFromStyle(style);
            } //End block
            else
            {
                tf = Typeface.create(tf, style);
            } //End block
            setSwitchTypeface(tf);
            int typefaceStyle = tf != null ? tf.getStyle() : 0;
            int need = style & ~typefaceStyle;
            mTextPaint.setFakeBoldText((need & Typeface.BOLD) != 0);
            mTextPaint.setTextSkewX((need & Typeface.ITALIC) != 0 ? -0.25f : 0);
        } //End block
        else
        {
            mTextPaint.setFakeBoldText(false);
            mTextPaint.setTextSkewX(0);
            setSwitchTypeface(tf);
        } //End block
        // ---------- Original Method ----------
        //if (style > 0) {
            //if (tf == null) {
                //tf = Typeface.defaultFromStyle(style);
            //} else {
                //tf = Typeface.create(tf, style);
            //}
            //setSwitchTypeface(tf);
            //int typefaceStyle = tf != null ? tf.getStyle() : 0;
            //int need = style & ~typefaceStyle;
            //mTextPaint.setFakeBoldText((need & Typeface.BOLD) != 0);
            //mTextPaint.setTextSkewX((need & Typeface.ITALIC) != 0 ? -0.25f : 0);
        //} else {
            //mTextPaint.setFakeBoldText(false);
            //mTextPaint.setTextSkewX(0);
            //setSwitchTypeface(tf);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.039 -0400", hash_original_method = "543DA1ECFCDDAA3B3698B41BEC9D49BA", hash_generated_method = "13D266621D0F0AC3E13B5F11A90F1CE5")
    public void setSwitchTypeface(Typeface tf) {
        addTaint(tf.getTaint());
        if(mTextPaint.getTypeface() != tf)        
        {
            mTextPaint.setTypeface(tf);
            requestLayout();
            invalidate();
        } //End block
        // ---------- Original Method ----------
        //if (mTextPaint.getTypeface() != tf) {
            //mTextPaint.setTypeface(tf);
            //requestLayout();
            //invalidate();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.043 -0400", hash_original_method = "5C0E5388314CF71485B1BF56327EECD2", hash_generated_method = "AB3D12136ED64ED9544FAA90CCE4DAED")
    public CharSequence getTextOn() {
CharSequence varB717BC0D87EF7CA63EF5B2DADD0E238D_1391447410 =         mTextOn;
        varB717BC0D87EF7CA63EF5B2DADD0E238D_1391447410.addTaint(taint);
        return varB717BC0D87EF7CA63EF5B2DADD0E238D_1391447410;
        // ---------- Original Method ----------
        //return mTextOn;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.047 -0400", hash_original_method = "6FFD0F84C29886200B9EFC80768CA614", hash_generated_method = "724A867E451862DC0A3CA1C1D8C6919B")
    public void setTextOn(CharSequence textOn) {
        mTextOn = textOn;
        requestLayout();
        // ---------- Original Method ----------
        //mTextOn = textOn;
        //requestLayout();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.049 -0400", hash_original_method = "EAEA80D56F502C97F845DE2B9DA853EF", hash_generated_method = "5F922F1D34ECA5A2EA0D6268196B6D5D")
    public CharSequence getTextOff() {
CharSequence varAB991E92B38590F8C1DAE21519779556_265359710 =         mTextOff;
        varAB991E92B38590F8C1DAE21519779556_265359710.addTaint(taint);
        return varAB991E92B38590F8C1DAE21519779556_265359710;
        // ---------- Original Method ----------
        //return mTextOff;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.053 -0400", hash_original_method = "D6EC5A221EB0AF6C7F25B9FE392EF4CC", hash_generated_method = "F5AAA7F178CC8D6FF87FECD348C53768")
    public void setTextOff(CharSequence textOff) {
        mTextOff = textOff;
        requestLayout();
        // ---------- Original Method ----------
        //mTextOff = textOff;
        //requestLayout();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.067 -0400", hash_original_method = "13BAC45BF6F94061A5C888CE492B7F47", hash_generated_method = "AF4B286D739706D551E591E4CD660C42")
    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(heightMeasureSpec);
        addTaint(widthMeasureSpec);
        final int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        final int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        if(mOnLayout == null)        
        {
            mOnLayout = makeLayout(mTextOn);
        } //End block
        if(mOffLayout == null)        
        {
            mOffLayout = makeLayout(mTextOff);
        } //End block
        mTrackDrawable.getPadding(mTempRect);
        final int maxTextWidth = Math.max(mOnLayout.getWidth(), mOffLayout.getWidth());
        final int switchWidth = Math.max(mSwitchMinWidth,
                maxTextWidth * 2 + mThumbTextPadding * 4 + mTempRect.left + mTempRect.right);
        final int switchHeight = mTrackDrawable.getIntrinsicHeight();
        mThumbWidth = maxTextWidth + mThumbTextPadding * 2;
switch(widthMode){
        case MeasureSpec.AT_MOST:
        widthSize = Math.min(widthSize, switchWidth);
        break;
        case MeasureSpec.UNSPECIFIED:
        widthSize = switchWidth;
        break;
        case MeasureSpec.EXACTLY:
        break;
}switch(heightMode){
        case MeasureSpec.AT_MOST:
        heightSize = Math.min(heightSize, switchHeight);
        break;
        case MeasureSpec.UNSPECIFIED:
        heightSize = switchHeight;
        break;
        case MeasureSpec.EXACTLY:
        break;
}        mSwitchWidth = switchWidth;
        mSwitchHeight = switchHeight;
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        final int measuredHeight = getMeasuredHeight();
        if(measuredHeight < switchHeight)        
        {
            setMeasuredDimension(getMeasuredWidthAndState(), switchHeight);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.074 -0400", hash_original_method = "48254B36708A3254CD52161026ABD6F4", hash_generated_method = "CF993C9605D0B73F7C11BE7AA3A5D8F7")
    @Override
    public void onPopulateAccessibilityEvent(AccessibilityEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        super.onPopulateAccessibilityEvent(event);
        if(isChecked())        
        {
            CharSequence text = mOnLayout.getText();
            if(TextUtils.isEmpty(text))            
            {
                text = mContext.getString(R.string.switch_on);
            } //End block
            event.getText().add(text);
        } //End block
        else
        {
            CharSequence text = mOffLayout.getText();
            if(TextUtils.isEmpty(text))            
            {
                text = mContext.getString(R.string.switch_off);
            } //End block
            event.getText().add(text);
        } //End block
        // ---------- Original Method ----------
        //super.onPopulateAccessibilityEvent(event);
        //if (isChecked()) {
            //CharSequence text = mOnLayout.getText();
            //if (TextUtils.isEmpty(text)) {
                //text = mContext.getString(R.string.switch_on);
            //}
            //event.getText().add(text);
        //} else {
            //CharSequence text = mOffLayout.getText();
            //if (TextUtils.isEmpty(text)) {
                //text = mContext.getString(R.string.switch_off);
            //}
            //event.getText().add(text);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.081 -0400", hash_original_method = "D1466C388B2346E8DF10ED51CFBEA0FC", hash_generated_method = "8BDBCB278E968AD92C94012D307DBD5C")
    private Layout makeLayout(CharSequence text) {
        addTaint(text.getTaint());
Layout varCE2BB04DC870A298373702A783739055_1467233509 =         new StaticLayout(text, mTextPaint,
                (int) Math.ceil(Layout.getDesiredWidth(text, mTextPaint)),
                Layout.Alignment.ALIGN_NORMAL, 1.f, 0, true);
        varCE2BB04DC870A298373702A783739055_1467233509.addTaint(taint);
        return varCE2BB04DC870A298373702A783739055_1467233509;
        // ---------- Original Method ----------
        //return new StaticLayout(text, mTextPaint,
                //(int) Math.ceil(Layout.getDesiredWidth(text, mTextPaint)),
                //Layout.Alignment.ALIGN_NORMAL, 1.f, 0, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.087 -0400", hash_original_method = "EC82A35D1017AC4F050030BE5A651660", hash_generated_method = "62058B30834EDA7458AB741634836C71")
    private boolean hitThumb(float x, float y) {
        addTaint(y);
        addTaint(x);
        mThumbDrawable.getPadding(mTempRect);
        final int thumbTop = mSwitchTop - mTouchSlop;
        final int thumbLeft = mSwitchLeft + (int) (mThumbPosition + 0.5f) - mTouchSlop;
        final int thumbRight = thumbLeft + mThumbWidth +
                mTempRect.left + mTempRect.right + mTouchSlop;
        final int thumbBottom = mSwitchBottom + mTouchSlop;
        boolean var0A5C96D66420474133AD5290BB8D03D1_1966050557 = (x > thumbLeft && x < thumbRight && y > thumbTop && y < thumbBottom);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1725811797 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1725811797;
        // ---------- Original Method ----------
        //mThumbDrawable.getPadding(mTempRect);
        //final int thumbTop = mSwitchTop - mTouchSlop;
        //final int thumbLeft = mSwitchLeft + (int) (mThumbPosition + 0.5f) - mTouchSlop;
        //final int thumbRight = thumbLeft + mThumbWidth +
                //mTempRect.left + mTempRect.right + mTouchSlop;
        //final int thumbBottom = mSwitchBottom + mTouchSlop;
        //return x > thumbLeft && x < thumbRight && y > thumbTop && y < thumbBottom;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.111 -0400", hash_original_method = "BEA9271A473068780C9D1CF1D0CB8717", hash_generated_method = "F3FAAD9610488232DEAF30E3B93499B2")
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(ev.getTaint());
        mVelocityTracker.addMovement(ev);
        final int action = ev.getActionMasked();
switch(action){
        case MotionEvent.ACTION_DOWN:
        {
            final float x = ev.getX();
            final float y = ev.getY();
            if(isEnabled() && hitThumb(x, y))            
            {
                mTouchMode = TOUCH_MODE_DOWN;
                mTouchX = x;
                mTouchY = y;
            } //End block
            break;
        } //End block
        case MotionEvent.ACTION_MOVE:
        {
switch(mTouchMode){
            case TOUCH_MODE_IDLE:
            break;
            case TOUCH_MODE_DOWN:
            {
                final float x = ev.getX();
                final float y = ev.getY();
                if(Math.abs(x - mTouchX) > mTouchSlop ||
                                Math.abs(y - mTouchY) > mTouchSlop)                
                {
                    mTouchMode = TOUCH_MODE_DRAGGING;
                    getParent().requestDisallowInterceptTouchEvent(true);
                    mTouchX = x;
                    mTouchY = y;
                    boolean varB326B5062B2F0E69046810717534CB09_1636248826 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2139358551 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_2139358551;
                } //End block
                break;
            } //End block
            case TOUCH_MODE_DRAGGING:
            {
                final float x = ev.getX();
                final float dx = x - mTouchX;
                float newPos = Math.max(0,
                                Math.min(mThumbPosition + dx, getThumbScrollRange()));
                if(newPos != mThumbPosition)                
                {
                    mThumbPosition = newPos;
                    mTouchX = x;
                    invalidate();
                } //End block
                boolean varB326B5062B2F0E69046810717534CB09_339922961 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_598077044 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_598077044;
            } //End block
}            break;
        } //End block
        case MotionEvent.ACTION_UP:
        case MotionEvent.ACTION_CANCEL:
        {
            if(mTouchMode == TOUCH_MODE_DRAGGING)            
            {
                stopDrag(ev);
                boolean varB326B5062B2F0E69046810717534CB09_313564702 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_692909028 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_692909028;
            } //End block
            mTouchMode = TOUCH_MODE_IDLE;
            mVelocityTracker.clear();
            break;
        } //End block
}        boolean varAD999E87828E920C1F4F0D963C1B2C2B_2138165829 = (super.onTouchEvent(ev));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_235812553 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_235812553;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.119 -0400", hash_original_method = "C7212DC872D0065CD5A602E451EED0FD", hash_generated_method = "DD077BD3408653B31F15AB21E046C86E")
    private void cancelSuperTouch(MotionEvent ev) {
        addTaint(ev.getTaint());
        MotionEvent cancel = MotionEvent.obtain(ev);
        cancel.setAction(MotionEvent.ACTION_CANCEL);
        super.onTouchEvent(cancel);
        cancel.recycle();
        // ---------- Original Method ----------
        //MotionEvent cancel = MotionEvent.obtain(ev);
        //cancel.setAction(MotionEvent.ACTION_CANCEL);
        //super.onTouchEvent(cancel);
        //cancel.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.125 -0400", hash_original_method = "6053E208B701C67F21F78DB5D1D6AC6A", hash_generated_method = "6B1FAB84EED998D56FABF620F9EAC7A6")
    private void stopDrag(MotionEvent ev) {
        addTaint(ev.getTaint());
        mTouchMode = TOUCH_MODE_IDLE;
        boolean commitChange = ev.getAction() == MotionEvent.ACTION_UP && isEnabled();
        cancelSuperTouch(ev);
        if(commitChange)        
        {
            boolean newState;
            mVelocityTracker.computeCurrentVelocity(1000);
            float xvel = mVelocityTracker.getXVelocity();
            if(Math.abs(xvel) > mMinFlingVelocity)            
            {
                newState = xvel > 0;
            } //End block
            else
            {
                newState = getTargetCheckedState();
            } //End block
            animateThumbToCheckedState(newState);
        } //End block
        else
        {
            animateThumbToCheckedState(isChecked());
        } //End block
        // ---------- Original Method ----------
        //mTouchMode = TOUCH_MODE_IDLE;
        //boolean commitChange = ev.getAction() == MotionEvent.ACTION_UP && isEnabled();
        //cancelSuperTouch(ev);
        //if (commitChange) {
            //boolean newState;
            //mVelocityTracker.computeCurrentVelocity(1000);
            //float xvel = mVelocityTracker.getXVelocity();
            //if (Math.abs(xvel) > mMinFlingVelocity) {
                //newState = xvel > 0;
            //} else {
                //newState = getTargetCheckedState();
            //}
            //animateThumbToCheckedState(newState);
        //} else {
            //animateThumbToCheckedState(isChecked());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.129 -0400", hash_original_method = "7C8C019C9C57DB27BCCABCAFF8863202", hash_generated_method = "E38135EBCD5AF7DA5497464F4436EA86")
    private void animateThumbToCheckedState(boolean newCheckedState) {
        addTaint(newCheckedState);
        setChecked(newCheckedState);
        // ---------- Original Method ----------
        //setChecked(newCheckedState);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.132 -0400", hash_original_method = "49A1E38FB4C1D1775597A6823232C034", hash_generated_method = "29786727837E90BF4DA845D45990E7C1")
    private boolean getTargetCheckedState() {
        boolean var5AA6B655859B5EFB82782A0372A6FE1D_272103324 = (mThumbPosition >= getThumbScrollRange() / 2);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_894777624 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_894777624;
        // ---------- Original Method ----------
        //return mThumbPosition >= getThumbScrollRange() / 2;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.142 -0400", hash_original_method = "523B4C6A0F0C2AD264BC263A9EEF64F2", hash_generated_method = "57E9296DAAE1C6587AFD72472D55FCDC")
    @Override
    public void setChecked(boolean checked) {
        super.setChecked(checked);
        mThumbPosition = checked ? getThumbScrollRange() : 0;
        invalidate();
        // ---------- Original Method ----------
        //super.setChecked(checked);
        //mThumbPosition = checked ? getThumbScrollRange() : 0;
        //invalidate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.157 -0400", hash_original_method = "12EE2ABDB63D99AE62C7AA4AFB810394", hash_generated_method = "EE163C12D80A7BF8752798E65D5032DF")
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(bottom);
        addTaint(right);
        addTaint(top);
        addTaint(left);
        addTaint(changed);
        super.onLayout(changed, left, top, right, bottom);
        mThumbPosition = isChecked() ? getThumbScrollRange() : 0;
        int switchRight = getWidth() - getPaddingRight();
        int switchLeft = switchRight - mSwitchWidth;
        int switchTop = 0;
        int switchBottom = 0;
switch(getGravity() & Gravity.VERTICAL_GRAVITY_MASK){
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
}        mSwitchLeft = switchLeft;
        mSwitchTop = switchTop;
        mSwitchBottom = switchBottom;
        mSwitchRight = switchRight;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.165 -0400", hash_original_method = "8EF5F4DDEE2B0F2714B687B8F02D0637", hash_generated_method = "E9093B006E6229B8E68F8B11F2A5D7A5")
    @Override
    protected void onDraw(Canvas canvas) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(canvas.getTaint());
        super.onDraw(canvas);
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
        if(mTextColors != null)        
        {
            mTextPaint.setColor(mTextColors.getColorForState(getDrawableState(),
                    mTextColors.getDefaultColor()));
        } //End block
        mTextPaint.drawableState = getDrawableState();
        Layout switchText = getTargetCheckedState() ? mOnLayout : mOffLayout;
        canvas.translate((thumbLeft + thumbRight) / 2 - switchText.getWidth() / 2,
                (switchInnerTop + switchInnerBottom) / 2 - switchText.getHeight() / 2);
        switchText.draw(canvas);
        canvas.restore();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.172 -0400", hash_original_method = "C22AF595E85F3FD93263583BC3DF92ED", hash_generated_method = "9B35A8F62B4BF887F79A5FBD3DC1C121")
    @Override
    public int getCompoundPaddingRight() {
        int padding = super.getCompoundPaddingRight() + mSwitchWidth;
        if(!TextUtils.isEmpty(getText()))        
        {
            padding += mSwitchPadding;
        } //End block
        int varB70CDB878A204FECF91C7DD1AF312421_1075436254 = (padding);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_355914277 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_355914277;
        // ---------- Original Method ----------
        //int padding = super.getCompoundPaddingRight() + mSwitchWidth;
        //if (!TextUtils.isEmpty(getText())) {
            //padding += mSwitchPadding;
        //}
        //return padding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.177 -0400", hash_original_method = "B890BAF452343CC74FA34D76EC58FC5C", hash_generated_method = "999D70262D556685031015D9F84516BA")
    private int getThumbScrollRange() {
        if(mTrackDrawable == null)        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_1431510830 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_137572738 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_137572738;
        } //End block
        mTrackDrawable.getPadding(mTempRect);
        int varA034FCED26D2E9E7B027363481516DC5_508523576 = (mSwitchWidth - mThumbWidth - mTempRect.left - mTempRect.right);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_576687425 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_576687425;
        // ---------- Original Method ----------
        //if (mTrackDrawable == null) {
            //return 0;
        //}
        //mTrackDrawable.getPadding(mTempRect);
        //return mSwitchWidth - mThumbWidth - mTempRect.left - mTempRect.right;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.184 -0400", hash_original_method = "E661308564BAD0BE96E34DA026589671", hash_generated_method = "C45628C3176AEA91527AF4DB2ED7CE35")
    @Override
    protected int[] onCreateDrawableState(int extraSpace) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(extraSpace);
        final int[] drawableState = super.onCreateDrawableState(extraSpace + 1);
        if(isChecked())        
        {
            mergeDrawableStates(drawableState, CHECKED_STATE_SET);
        } //End block
        int[] var7A12E87773589D809FD51F1A26B9BDA9_1069441199 = (drawableState);
                int[] varB4CCCA26F9DB9189C32F33E82D425CFB_2077324838 = {getTaintInt()};
        return varB4CCCA26F9DB9189C32F33E82D425CFB_2077324838;
        // ---------- Original Method ----------
        //final int[] drawableState = super.onCreateDrawableState(extraSpace + 1);
        //if (isChecked()) {
            //mergeDrawableStates(drawableState, CHECKED_STATE_SET);
        //}
        //return drawableState;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.191 -0400", hash_original_method = "DBFC9AA6074AC9C1F36B3AF225F67863", hash_generated_method = "B01A6B758EC1317E328A67B2FF2DE8A3")
    @Override
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] myDrawableState = getDrawableState();
        if(mThumbDrawable != null)        
        mThumbDrawable.setState(myDrawableState);
        if(mTrackDrawable != null)        
        mTrackDrawable.setState(myDrawableState);
        invalidate();
        // ---------- Original Method ----------
        //super.drawableStateChanged();
        //int[] myDrawableState = getDrawableState();
        //if (mThumbDrawable != null) mThumbDrawable.setState(myDrawableState);
        //if (mTrackDrawable != null) mTrackDrawable.setState(myDrawableState);
        //invalidate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.197 -0400", hash_original_method = "1DDC7918114D3BA198855AEA4718194D", hash_generated_method = "294B25882317C2DB325A2A0E00B3FF2A")
    @Override
    protected boolean verifyDrawable(Drawable who) {
        addTaint(who.getTaint());
        boolean var3E15040A665A4A53DE459BF33F862300_1432975806 = (super.verifyDrawable(who) || who == mThumbDrawable || who == mTrackDrawable);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1942797054 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1942797054;
        // ---------- Original Method ----------
        //return super.verifyDrawable(who) || who == mThumbDrawable || who == mTrackDrawable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.203 -0400", hash_original_method = "B8A29477D7D79C90248691E663D147EB", hash_generated_method = "ADDA229C5AD62D1E4F9B04ED39B0DD3F")
    @Override
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        mThumbDrawable.jumpToCurrentState();
        mTrackDrawable.jumpToCurrentState();
        // ---------- Original Method ----------
        //super.jumpDrawablesToCurrentState();
        //mThumbDrawable.jumpToCurrentState();
        //mTrackDrawable.jumpToCurrentState();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.206 -0400", hash_original_field = "88C24C24A695FA7E184C364FC6761240", hash_generated_field = "6191CA7799994B85F015ACBC4A72ECF0")

    private static final int TOUCH_MODE_IDLE = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.207 -0400", hash_original_field = "41B5A739DC10C60ED32F302A1C3B1A00", hash_generated_field = "C79D4D88CCB9B6DDFEBEEEBDDCAC18DF")

    private static final int TOUCH_MODE_DOWN = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.209 -0400", hash_original_field = "9A3D33AC58FDE0809DDD0AD42ACA4F7B", hash_generated_field = "1C693615B4C4F2116D3600AD3C1B110A")

    private static final int TOUCH_MODE_DRAGGING = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.211 -0400", hash_original_field = "07F356F3070D07B6930DE3A9967108FE", hash_generated_field = "308BD7C2CCB94571F8E68E822492425A")

    private static final int SANS = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.214 -0400", hash_original_field = "5B5E6C83C125CC348E4EE28ACCFE5BFF", hash_generated_field = "AD8E248EA94D9FBB450731AC61EA4CF6")

    private static final int SERIF = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.216 -0400", hash_original_field = "399280F48C3EEEEAEAD47346CF3011F2", hash_generated_field = "1E362376CB7EB57CA2898CE49E4D3589")

    private static final int MONOSPACE = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.218 -0400", hash_original_field = "312B7CC8C1FC8133C5B1FE8103106614", hash_generated_field = "648B080756031EA789B9ECD9F36CC170")

    private static final int[] CHECKED_STATE_SET = {
        R.attr.state_checked
    };
}

