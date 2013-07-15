package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.RemotableViewMethod;
import android.view.View;
import android.view.ViewDebug;
import android.view.accessibility.AccessibilityEvent;
import android.widget.RemoteViews.RemoteView;

public class ImageView extends View {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.967 -0400", hash_original_field = "5FBE3730DCFF234F97B15868D5CE649D", hash_generated_field = "04FA8EB5D9FB8AC4AAE6453BCF1BBF82")

    private Uri mUri;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.967 -0400", hash_original_field = "9687C18AF187DE568609D63BF0C95F6E", hash_generated_field = "A1149776195D9A81C2251417049A8983")

    private int mResource = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.967 -0400", hash_original_field = "9FEB0FB4D7668A1A69C2CCE86D8FE6AA", hash_generated_field = "19EDBF8F5E96D57B14276EDE6AD2F400")

    private Matrix mMatrix;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.967 -0400", hash_original_field = "0BFEC49F5128457BE902AB856ABE41D0", hash_generated_field = "D019EEE3A15FE9FAE26B5448B9F5829B")

    private ScaleType mScaleType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.967 -0400", hash_original_field = "0D8E6A9A6439BD0EDB0134B86DD0FF56", hash_generated_field = "A9F2FED4F49AAE6AC6AEAF755030819C")

    private boolean mHaveFrame = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.967 -0400", hash_original_field = "E48EA5F392E29C330AAD7777031257FE", hash_generated_field = "0CE29D9D9A45271B43F0AD7DE06F84E1")

    private boolean mAdjustViewBounds = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.967 -0400", hash_original_field = "9F06F72E481BAF7A136AD40FA3B01EB4", hash_generated_field = "63C7BFD9234113D05BBC54B620020077")

    private int mMaxWidth = Integer.MAX_VALUE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.967 -0400", hash_original_field = "720F6023E916A40B06BB7677E44DB85A", hash_generated_field = "3586D5CEDE91E2DE59FB9742E85FA3AD")

    private int mMaxHeight = Integer.MAX_VALUE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.967 -0400", hash_original_field = "8B2ED40D22A4C08C94CFC40B6DE589B8", hash_generated_field = "5D6D299C9DDEDCCB11EFFA1C147C3DF6")

    private ColorFilter mColorFilter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.967 -0400", hash_original_field = "1439C01AF326A337A2401436745247DA", hash_generated_field = "D85E4CEC9C06A2D96EB98C9ADB4E0FF6")

    private int mAlpha = 255;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.967 -0400", hash_original_field = "05C970399FAF71ED4C8AEFEE55D2E1C7", hash_generated_field = "7D8AB2121554DAB4C026523E1BE546D1")

    private int mViewAlphaScale = 256;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.968 -0400", hash_original_field = "424A8580F75B780B70CB9B4272F55C40", hash_generated_field = "F19CF311EA8DC507DE046A521B9697AE")

    private boolean mColorMod = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.968 -0400", hash_original_field = "C211E639ECC112D6CFE9EF35C7EE2BAD", hash_generated_field = "4203E503DD280EB595B89035662691AC")

    private Drawable mDrawable = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.968 -0400", hash_original_field = "1D598FE22B106935C0C063CC508FA455", hash_generated_field = "55E5EFD87E77F38783CE10C9BF766B2D")

    private int[] mState = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.968 -0400", hash_original_field = "7500A1D75540C8BABBEABE375200D820", hash_generated_field = "CD0E3EB62F2EEB3E7C6BC89E581F03D0")

    private boolean mMergeState = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.968 -0400", hash_original_field = "8D44C0A2CA7183B234B6C68F8099BDEB", hash_generated_field = "D66D669C7CB840BE2CC0AE88CB04AECF")

    private int mLevel = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.968 -0400", hash_original_field = "BDE4B5ECFEF5B3B5C89BD588E039EB7F", hash_generated_field = "A392E3876AEB7B9CD42C742144EAE0B2")

    private int mDrawableWidth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.968 -0400", hash_original_field = "81B997CC4D8DA3F276798F355396D6BC", hash_generated_field = "87D310E7F957167B4F609DB1F09D884D")

    private int mDrawableHeight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.968 -0400", hash_original_field = "38017DD8AAC924883B1956C1C08D2174", hash_generated_field = "90F6D022B92E991BB20BB870E8BC3FF7")

    private Matrix mDrawMatrix = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.968 -0400", hash_original_field = "027BE59B05D90854B1A288EAC269B061", hash_generated_field = "4822CDFF0200FBD929D8DC006BC82F04")

    private RectF mTempSrc = new RectF();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.969 -0400", hash_original_field = "83EED2DFF6690433B8CB303B48558A0E", hash_generated_field = "3F7FC79A12F840875E4DB52E36F649AD")

    private RectF mTempDst = new RectF();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.969 -0400", hash_original_field = "49185ED0BC5B6EEAFDC11117FFA7532C", hash_generated_field = "2A167B0395D5D689B5161FD76D7714AC")

    private boolean mCropToPadding;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.969 -0400", hash_original_field = "E9071209E3EB9AFCB8B5DD7C635F8293", hash_generated_field = "FEB7CA79CE658BB3A037CDF3395A66FC")

    private int mBaseline = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.969 -0400", hash_original_field = "B4AAF99C1540BC541F937E9B9CDB87FA", hash_generated_field = "43E60ED5A18EF5C89E67168564FB92E1")

    private boolean mBaselineAlignBottom = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.969 -0400", hash_original_method = "3103DD3B06C95633A5076C8A302A640B", hash_generated_method = "AC1387B4F100BD85C6E8F957A98E5781")
    public  ImageView(Context context) {
        super(context);
        addTaint(context.getTaint());
        initImageView();
        // ---------- Original Method ----------
        //initImageView();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.970 -0400", hash_original_method = "67FF47760B585BF8195A474475D955DB", hash_generated_method = "203772EEB447B9EA97C8317B7B1D6B5D")
    public  ImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.971 -0400", hash_original_method = "8CC4CE610519C30A909B4E591A3E5936", hash_generated_method = "CC08726F8033D9755B38805547D52A2B")
    public  ImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        addTaint(defStyle);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        initImageView();
        TypedArray a = context.obtainStyledAttributes(attrs,
                com.android.internal.R.styleable.ImageView, defStyle, 0);
        Drawable d = a.getDrawable(com.android.internal.R.styleable.ImageView_src);
    if(d != null)        
        {
            setImageDrawable(d);
        } //End block
        mBaselineAlignBottom = a.getBoolean(
                com.android.internal.R.styleable.ImageView_baselineAlignBottom, false);
        mBaseline = a.getDimensionPixelSize(
                com.android.internal.R.styleable.ImageView_baseline, -1);
        setAdjustViewBounds(
            a.getBoolean(com.android.internal.R.styleable.ImageView_adjustViewBounds,
            false));
        setMaxWidth(a.getDimensionPixelSize(
                com.android.internal.R.styleable.ImageView_maxWidth, Integer.MAX_VALUE));
        setMaxHeight(a.getDimensionPixelSize(
                com.android.internal.R.styleable.ImageView_maxHeight, Integer.MAX_VALUE));
        int index = a.getInt(com.android.internal.R.styleable.ImageView_scaleType, -1);
    if(index >= 0)        
        {
            setScaleType(sScaleTypeArray[index]);
        } //End block
        int tint = a.getInt(com.android.internal.R.styleable.ImageView_tint, 0);
    if(tint != 0)        
        {
            setColorFilter(tint);
        } //End block
        int alpha = a.getInt(com.android.internal.R.styleable.ImageView_drawableAlpha, 255);
    if(alpha != 255)        
        {
            setAlpha(alpha);
        } //End block
        mCropToPadding = a.getBoolean(
                com.android.internal.R.styleable.ImageView_cropToPadding, false);
        a.recycle();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.971 -0400", hash_original_method = "1C158315B1207DD6F7DBD78E9AF6090A", hash_generated_method = "6C86BA293E0B26AF0AEC484FE877D701")
    private void initImageView() {
        mMatrix     = new Matrix();
        mScaleType  = ScaleType.FIT_CENTER;
        // ---------- Original Method ----------
        //mMatrix     = new Matrix();
        //mScaleType  = ScaleType.FIT_CENTER;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.972 -0400", hash_original_method = "D798939B4195D6D5668E5F7C7E8DA2D2", hash_generated_method = "4C1C361E6E6742FCE3261C8AE8DD5049")
    @Override
    protected boolean verifyDrawable(Drawable dr) {
        addTaint(dr.getTaint());
        boolean varC1FFB548593DBD6036C20D574FC33382_674485500 = (mDrawable == dr || super.verifyDrawable(dr));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2113226925 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2113226925;
        // ---------- Original Method ----------
        //return mDrawable == dr || super.verifyDrawable(dr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.972 -0400", hash_original_method = "EFC358D3732AB4D7E168E7965D2C4CA0", hash_generated_method = "A3F30BE3FEAD5877CDDA792F87D82109")
    @Override
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
    if(mDrawable != null)        
        mDrawable.jumpToCurrentState();
        // ---------- Original Method ----------
        //super.jumpDrawablesToCurrentState();
        //if (mDrawable != null) mDrawable.jumpToCurrentState();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.972 -0400", hash_original_method = "EB3EC256D00C5FC794745B960350792B", hash_generated_method = "8502601DC6105EE777EF198134FA371C")
    @Override
    public void invalidateDrawable(Drawable dr) {
        addTaint(dr.getTaint());
    if(dr == mDrawable)        
        {
            invalidate();
        } //End block
        else
        {
            super.invalidateDrawable(dr);
        } //End block
        // ---------- Original Method ----------
        //if (dr == mDrawable) {
            //invalidate();
        //} else {
            //super.invalidateDrawable(dr);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.973 -0400", hash_original_method = "792DD4F5E748125528D3BF6C27B77C70", hash_generated_method = "36ED12E986BD055E7EAEEFC6A8EA652A")
    @Override
    public int getResolvedLayoutDirection(Drawable dr) {
        addTaint(dr.getTaint());
        int varFC301C254931C2AE01ABA245FF2198D1_1052252258 = ((dr == mDrawable) ?
                getResolvedLayoutDirection() : super.getResolvedLayoutDirection(dr));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1790943518 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1790943518;
        // ---------- Original Method ----------
        //return (dr == mDrawable) ?
                //getResolvedLayoutDirection() : super.getResolvedLayoutDirection(dr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.973 -0400", hash_original_method = "000365A595FBC289F16F7AD48241010C", hash_generated_method = "5067EB6439F0B29B533FC25DFC4A1CB4")
    @Override
    protected boolean onSetAlpha(int alpha) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(alpha);
    if(getBackground() == null)        
        {
            int scale = alpha + (alpha >> 7);
    if(mViewAlphaScale != scale)            
            {
                mViewAlphaScale = scale;
                mColorMod = true;
                applyColorMod();
            } //End block
            boolean varB326B5062B2F0E69046810717534CB09_864273538 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_434631850 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_434631850;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_829358534 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2005304539 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2005304539;
        // ---------- Original Method ----------
        //if (getBackground() == null) {
            //int scale = alpha + (alpha >> 7);
            //if (mViewAlphaScale != scale) {
                //mViewAlphaScale = scale;
                //mColorMod = true;
                //applyColorMod();
            //}
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.973 -0400", hash_original_method = "9770981DD4DB73204B697C6119742B6F", hash_generated_method = "FB2A7D1EBC37D2CBE528515AE1825B46")
    @Override
    public void onPopulateAccessibilityEvent(AccessibilityEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        super.onPopulateAccessibilityEvent(event);
        CharSequence contentDescription = getContentDescription();
    if(!TextUtils.isEmpty(contentDescription))        
        {
            event.getText().add(contentDescription);
        } //End block
        // ---------- Original Method ----------
        //super.onPopulateAccessibilityEvent(event);
        //CharSequence contentDescription = getContentDescription();
        //if (!TextUtils.isEmpty(contentDescription)) {
            //event.getText().add(contentDescription);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.974 -0400", hash_original_method = "3F8BE319328C68420F5075492EAAB722", hash_generated_method = "F2482F916C21E7CB2E5E7BCC00CC3778")
    @android.view.RemotableViewMethod
    public void setAdjustViewBounds(boolean adjustViewBounds) {
        mAdjustViewBounds = adjustViewBounds;
    if(adjustViewBounds)        
        {
            setScaleType(ScaleType.FIT_CENTER);
        } //End block
        // ---------- Original Method ----------
        //mAdjustViewBounds = adjustViewBounds;
        //if (adjustViewBounds) {
            //setScaleType(ScaleType.FIT_CENTER);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.974 -0400", hash_original_method = "EB73857FE18ECB168F084B0FAC346FEA", hash_generated_method = "79DFBF0CB12D07C0AEB4E082D13DCC35")
    @android.view.RemotableViewMethod
    public void setMaxWidth(int maxWidth) {
        mMaxWidth = maxWidth;
        // ---------- Original Method ----------
        //mMaxWidth = maxWidth;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.974 -0400", hash_original_method = "9473C5CB1AE9899AEC7CB726EABA77F7", hash_generated_method = "0CD17647B54DD7BBE70494C14EEAE2F5")
    @android.view.RemotableViewMethod
    public void setMaxHeight(int maxHeight) {
        mMaxHeight = maxHeight;
        // ---------- Original Method ----------
        //mMaxHeight = maxHeight;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.975 -0400", hash_original_method = "53D05784890C72350FD6879A6582F7F3", hash_generated_method = "4A95EB16ED0EBBD5486E1571C5216982")
    public Drawable getDrawable() {
Drawable var421F6744A8B50797FB9C4A96CE6DA02C_250468295 =         mDrawable;
        var421F6744A8B50797FB9C4A96CE6DA02C_250468295.addTaint(taint);
        return var421F6744A8B50797FB9C4A96CE6DA02C_250468295;
        // ---------- Original Method ----------
        //return mDrawable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.975 -0400", hash_original_method = "FEA329647011282E5AA15854AC819C8B", hash_generated_method = "A6DA883F1EF8B9E4D0D0C88E47A35C98")
    @android.view.RemotableViewMethod
    public void setImageResource(int resId) {
    if(mUri != null || mResource != resId)        
        {
            updateDrawable(null);
            mResource = resId;
            mUri = null;
            resolveUri();
            requestLayout();
            invalidate();
        } //End block
        // ---------- Original Method ----------
        //if (mUri != null || mResource != resId) {
            //updateDrawable(null);
            //mResource = resId;
            //mUri = null;
            //resolveUri();
            //requestLayout();
            //invalidate();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.976 -0400", hash_original_method = "796039DEA15F6465B0D947F27F5B4F32", hash_generated_method = "E99CFD5A46B994C1CD16DAE3C04F7B42")
    @android.view.RemotableViewMethod
    public void setImageURI(Uri uri) {
    if(mResource != 0 ||
                (mUri != uri &&
                 (uri == null || mUri == null || !uri.equals(mUri))))        
        {
            updateDrawable(null);
            mResource = 0;
            mUri = uri;
            resolveUri();
            requestLayout();
            invalidate();
        } //End block
        // ---------- Original Method ----------
        //if (mResource != 0 ||
                //(mUri != uri &&
                 //(uri == null || mUri == null || !uri.equals(mUri)))) {
            //updateDrawable(null);
            //mResource = 0;
            //mUri = uri;
            //resolveUri();
            //requestLayout();
            //invalidate();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.976 -0400", hash_original_method = "5426F5FAF3C8635D29ADE0169269A6F9", hash_generated_method = "D56FA8FF3B95EDAB5B26B07322F8EAB9")
    public void setImageDrawable(Drawable drawable) {
        addTaint(drawable.getTaint());
    if(mDrawable != drawable)        
        {
            mResource = 0;
            mUri = null;
            int oldWidth = mDrawableWidth;
            int oldHeight = mDrawableHeight;
            updateDrawable(drawable);
    if(oldWidth != mDrawableWidth || oldHeight != mDrawableHeight)            
            {
                requestLayout();
            } //End block
            invalidate();
        } //End block
        // ---------- Original Method ----------
        //if (mDrawable != drawable) {
            //mResource = 0;
            //mUri = null;
            //int oldWidth = mDrawableWidth;
            //int oldHeight = mDrawableHeight;
            //updateDrawable(drawable);
            //if (oldWidth != mDrawableWidth || oldHeight != mDrawableHeight) {
                //requestLayout();
            //}
            //invalidate();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.977 -0400", hash_original_method = "5EFFAF8EE29E35792B081E6E83A7DFE3", hash_generated_method = "87C45DD246FDD6FAF4D4BCB206CBF9CA")
    @android.view.RemotableViewMethod
    public void setImageBitmap(Bitmap bm) {
        addTaint(bm.getTaint());
        setImageDrawable(new BitmapDrawable(mContext.getResources(), bm));
        // ---------- Original Method ----------
        //setImageDrawable(new BitmapDrawable(mContext.getResources(), bm));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.977 -0400", hash_original_method = "B00DD17D168377A844733E90ECCFE75B", hash_generated_method = "A9552C946A2AEE4760FB94E3FE312325")
    public void setImageState(int[] state, boolean merge) {
        mState = state;
        mMergeState = merge;
    if(mDrawable != null)        
        {
            refreshDrawableState();
            resizeFromDrawable();
        } //End block
        // ---------- Original Method ----------
        //mState = state;
        //mMergeState = merge;
        //if (mDrawable != null) {
            //refreshDrawableState();
            //resizeFromDrawable();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.977 -0400", hash_original_method = "44CE6C01D324B2DC91AFD69B5F1BB742", hash_generated_method = "589215400C37259F2C2F02C55C7CF9BD")
    @Override
    public void setSelected(boolean selected) {
        addTaint(selected);
        super.setSelected(selected);
        resizeFromDrawable();
        // ---------- Original Method ----------
        //super.setSelected(selected);
        //resizeFromDrawable();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.978 -0400", hash_original_method = "0A74FF8303919E2F74751A8C668C95F0", hash_generated_method = "4201DBD2F1BDE65FB35E49AA42D20729")
    @android.view.RemotableViewMethod
    public void setImageLevel(int level) {
        mLevel = level;
    if(mDrawable != null)        
        {
            mDrawable.setLevel(level);
            resizeFromDrawable();
        } //End block
        // ---------- Original Method ----------
        //mLevel = level;
        //if (mDrawable != null) {
            //mDrawable.setLevel(level);
            //resizeFromDrawable();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.978 -0400", hash_original_method = "63CC1440F0B24F3C6377C34C34E172F5", hash_generated_method = "4FFEF767EAF3533C8E510A64B59C1D41")
    public void setScaleType(ScaleType scaleType) {
    if(scaleType == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1220045301 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_1220045301.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_1220045301;
        } //End block
    if(mScaleType != scaleType)        
        {
            mScaleType = scaleType;
            setWillNotCacheDrawing(mScaleType == ScaleType.CENTER);
            requestLayout();
            invalidate();
        } //End block
        // ---------- Original Method ----------
        //if (scaleType == null) {
            //throw new NullPointerException();
        //}
        //if (mScaleType != scaleType) {
            //mScaleType = scaleType;
            //setWillNotCacheDrawing(mScaleType == ScaleType.CENTER);            
            //requestLayout();
            //invalidate();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.979 -0400", hash_original_method = "84B4F1338E9C8554FC089CA7254325E0", hash_generated_method = "015F73206C97123A08911AD7E35E1A1B")
    public ScaleType getScaleType() {
ScaleType varA1BE4DC72C5F3036640C8E62A5AD64BE_1428883977 =         mScaleType;
        varA1BE4DC72C5F3036640C8E62A5AD64BE_1428883977.addTaint(taint);
        return varA1BE4DC72C5F3036640C8E62A5AD64BE_1428883977;
        // ---------- Original Method ----------
        //return mScaleType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.979 -0400", hash_original_method = "5B9FD9A0A164EA90D695E910523F6E96", hash_generated_method = "E08DF8EC126C40052FB36F9A4B4A6F30")
    public Matrix getImageMatrix() {
Matrix var49A816397330451E1FD30BEA000F3851_1561464063 =         mMatrix;
        var49A816397330451E1FD30BEA000F3851_1561464063.addTaint(taint);
        return var49A816397330451E1FD30BEA000F3851_1561464063;
        // ---------- Original Method ----------
        //return mMatrix;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.980 -0400", hash_original_method = "A32A82AEE544A388BA62C8178AC7E88C", hash_generated_method = "0B8A709416146EBAE5BEB38AE875AFCF")
    public void setImageMatrix(Matrix matrix) {
        addTaint(matrix.getTaint());
    if(matrix != null && matrix.isIdentity())        
        {
            matrix = null;
        } //End block
    if(matrix == null && !mMatrix.isIdentity() ||
                matrix != null && !mMatrix.equals(matrix))        
        {
            mMatrix.set(matrix);
            configureBounds();
            invalidate();
        } //End block
        // ---------- Original Method ----------
        //if (matrix != null && matrix.isIdentity()) {
            //matrix = null;
        //}
        //if (matrix == null && !mMatrix.isIdentity() ||
                //matrix != null && !mMatrix.equals(matrix)) {
            //mMatrix.set(matrix);
            //configureBounds();
            //invalidate();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.981 -0400", hash_original_method = "16B1589372902AF87B2F0F65CBDC5B57", hash_generated_method = "4BEBE40AB9D5CFBF508FBB2EEF3CE1EF")
    private void resolveUri() {
    if(mDrawable != null)        
        {
            return;
        } //End block
        Resources rsrc = getResources();
    if(rsrc == null)        
        {
            return;
        } //End block
        Drawable d = null;
    if(mResource != 0)        
        {
            try 
            {
                d = rsrc.getDrawable(mResource);
            } //End block
            catch (Exception e)
            {
                mUri = null;
            } //End block
        } //End block
        else
    if(mUri != null)        
        {
            String scheme = mUri.getScheme();
    if(ContentResolver.SCHEME_ANDROID_RESOURCE.equals(scheme))            
            {
                try 
                {
                    ContentResolver.OpenResourceIdResult r = mContext.getContentResolver().getResourceId(mUri);
                    d = r.r.getDrawable(r.id);
                } //End block
                catch (Exception e)
                {
                } //End block
            } //End block
            else
    if(ContentResolver.SCHEME_CONTENT.equals(scheme)
                    || ContentResolver.SCHEME_FILE.equals(scheme))            
            {
                try 
                {
                    d = Drawable.createFromStream(
                        mContext.getContentResolver().openInputStream(mUri),
                        null);
                } //End block
                catch (Exception e)
                {
                } //End block
            } //End block
            else
            {
                d = Drawable.createFromPath(mUri.toString());
            } //End block
    if(d == null)            
            {
                System.out.println("resolveUri failed on bad bitmap uri: "
                                   + mUri);
                mUri = null;
            } //End block
        } //End block
        else
        {
            return;
        } //End block
        updateDrawable(d);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.982 -0400", hash_original_method = "F00D7A8DB32B373F9AAF90A3CC19DF16", hash_generated_method = "4770E24A182229A4765A2898920A50F9")
    @Override
    public int[] onCreateDrawableState(int extraSpace) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(extraSpace);
    if(mState == null)        
        {
            int[] var66AAC6FF29C922B79B81CD6E0D9D06DC_820498535 = (super.onCreateDrawableState(extraSpace));
                        int[] varB4CCCA26F9DB9189C32F33E82D425CFB_1969388364 = {getTaintInt()};
            return varB4CCCA26F9DB9189C32F33E82D425CFB_1969388364;
        } //End block
        else
    if(!mMergeState)        
        {
            int[] var48A902C1D749B47EBC75C77370D5A1F0_1439130781 = (mState);
                        int[] varB4CCCA26F9DB9189C32F33E82D425CFB_73060241 = {getTaintInt()};
            return varB4CCCA26F9DB9189C32F33E82D425CFB_73060241;
        } //End block
        else
        {
            int[] var06A61937153242066E647F94DABCB336_802952893 = (mergeDrawableStates(
                    super.onCreateDrawableState(extraSpace + mState.length), mState));
                        int[] varB4CCCA26F9DB9189C32F33E82D425CFB_1682962691 = {getTaintInt()};
            return varB4CCCA26F9DB9189C32F33E82D425CFB_1682962691;
        } //End block
        // ---------- Original Method ----------
        //if (mState == null) {
            //return super.onCreateDrawableState(extraSpace);
        //} else if (!mMergeState) {
            //return mState;
        //} else {
            //return mergeDrawableStates(
                    //super.onCreateDrawableState(extraSpace + mState.length), mState);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.983 -0400", hash_original_method = "ADE7139D7C0A9B2AE00EA96739AFBDE5", hash_generated_method = "E0867A363840E00ECC8838F7AEAEBB26")
    private void updateDrawable(Drawable d) {
    if(mDrawable != null)        
        {
            mDrawable.setCallback(null);
            unscheduleDrawable(mDrawable);
        } //End block
        mDrawable = d;
    if(d != null)        
        {
            d.setCallback(this);
    if(d.isStateful())            
            {
                d.setState(getDrawableState());
            } //End block
            d.setLevel(mLevel);
            mDrawableWidth = d.getIntrinsicWidth();
            mDrawableHeight = d.getIntrinsicHeight();
            applyColorMod();
            configureBounds();
        } //End block
        else
        {
            mDrawableWidth = mDrawableHeight = -1;
        } //End block
        // ---------- Original Method ----------
        //if (mDrawable != null) {
            //mDrawable.setCallback(null);
            //unscheduleDrawable(mDrawable);
        //}
        //mDrawable = d;
        //if (d != null) {
            //d.setCallback(this);
            //if (d.isStateful()) {
                //d.setState(getDrawableState());
            //}
            //d.setLevel(mLevel);
            //mDrawableWidth = d.getIntrinsicWidth();
            //mDrawableHeight = d.getIntrinsicHeight();
            //applyColorMod();
            //configureBounds();
        //} else {
            //mDrawableWidth = mDrawableHeight = -1;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.984 -0400", hash_original_method = "E1DD34F979587974CF0EAF8DF3CFC3FF", hash_generated_method = "9B32301E4DC1BA530C710FFDA7DAD8F1")
    private void resizeFromDrawable() {
        Drawable d = mDrawable;
    if(d != null)        
        {
            int w = d.getIntrinsicWidth();
    if(w < 0)            
            w = mDrawableWidth;
            int h = d.getIntrinsicHeight();
    if(h < 0)            
            h = mDrawableHeight;
    if(w != mDrawableWidth || h != mDrawableHeight)            
            {
                mDrawableWidth = w;
                mDrawableHeight = h;
                requestLayout();
            } //End block
        } //End block
        // ---------- Original Method ----------
        //Drawable d = mDrawable;
        //if (d != null) {
            //int w = d.getIntrinsicWidth();
            //if (w < 0) w = mDrawableWidth;
            //int h = d.getIntrinsicHeight();
            //if (h < 0) h = mDrawableHeight;
            //if (w != mDrawableWidth || h != mDrawableHeight) {
                //mDrawableWidth = w;
                //mDrawableHeight = h;
                //requestLayout();
            //}
        //}
    }

    
        private static Matrix.ScaleToFit scaleTypeToScaleToFit(ScaleType st) {
        return sS2FArray[st.nativeInt - 1];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.987 -0400", hash_original_method = "5D5C8E0C5B3B131983F43D2E85F23CCE", hash_generated_method = "9FB99FA837B85B92844664E7480A3DC4")
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(heightMeasureSpec);
        addTaint(widthMeasureSpec);
        resolveUri();
        int w;
        int h;
        float desiredAspect = 0.0f;
        boolean resizeWidth = false;
        boolean resizeHeight = false;
        final int widthSpecMode = MeasureSpec.getMode(widthMeasureSpec);
        final int heightSpecMode = MeasureSpec.getMode(heightMeasureSpec);
    if(mDrawable == null)        
        {
            mDrawableWidth = -1;
            mDrawableHeight = -1;
            w = h = 0;
        } //End block
        else
        {
            w = mDrawableWidth;
            h = mDrawableHeight;
    if(w <= 0)            
            w = 1;
    if(h <= 0)            
            h = 1;
    if(mAdjustViewBounds)            
            {
                resizeWidth = widthSpecMode != MeasureSpec.EXACTLY;
                resizeHeight = heightSpecMode != MeasureSpec.EXACTLY;
                desiredAspect = (float) w / (float) h;
            } //End block
        } //End block
        int pleft = mPaddingLeft;
        int pright = mPaddingRight;
        int ptop = mPaddingTop;
        int pbottom = mPaddingBottom;
        int widthSize;
        int heightSize;
    if(resizeWidth || resizeHeight)        
        {
            widthSize = resolveAdjustedSize(w + pleft + pright, mMaxWidth, widthMeasureSpec);
            heightSize = resolveAdjustedSize(h + ptop + pbottom, mMaxHeight, heightMeasureSpec);
    if(desiredAspect != 0.0f)            
            {
                float actualAspect = (float)(widthSize - pleft - pright) /
                                        (heightSize - ptop - pbottom);
    if(Math.abs(actualAspect - desiredAspect) > 0.0000001)                
                {
                    boolean done = false;
    if(resizeWidth)                    
                    {
                        int newWidth = (int)(desiredAspect * (heightSize - ptop - pbottom)) +
                                pleft + pright;
    if(newWidth <= widthSize)                        
                        {
                            widthSize = newWidth;
                            done = true;
                        } //End block
                    } //End block
    if(!done && resizeHeight)                    
                    {
                        int newHeight = (int)((widthSize - pleft - pright) / desiredAspect) +
                                ptop + pbottom;
    if(newHeight <= heightSize)                        
                        {
                            heightSize = newHeight;
                        } //End block
                    } //End block
                } //End block
            } //End block
        } //End block
        else
        {
            w += pleft + pright;
            h += ptop + pbottom;
            w = Math.max(w, getSuggestedMinimumWidth());
            h = Math.max(h, getSuggestedMinimumHeight());
            widthSize = resolveSizeAndState(w, widthMeasureSpec, 0);
            heightSize = resolveSizeAndState(h, heightMeasureSpec, 0);
        } //End block
        setMeasuredDimension(widthSize, heightSize);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.989 -0400", hash_original_method = "6790E6B3204D72187344DF3593244181", hash_generated_method = "1193318B12BB1432EAAA76E356961A10")
    private int resolveAdjustedSize(int desiredSize, int maxSize,
                                   int measureSpec) {
        addTaint(measureSpec);
        addTaint(maxSize);
        addTaint(desiredSize);
        int result = desiredSize;
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);
switch(specMode){
        case MeasureSpec.UNSPECIFIED:
        result = Math.min(desiredSize, maxSize);
        break;
        case MeasureSpec.AT_MOST:
        result = Math.min(Math.min(desiredSize, specSize), maxSize);
        break;
        case MeasureSpec.EXACTLY:
        result = specSize;
        break;
}        int varB4A88417B3D0170D754C647C30B7216A_115850467 = (result);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1561542598 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1561542598;
        // ---------- Original Method ----------
        //int result = desiredSize;
        //int specMode = MeasureSpec.getMode(measureSpec);
        //int specSize =  MeasureSpec.getSize(measureSpec);
        //switch (specMode) {
            //case MeasureSpec.UNSPECIFIED:
                //result = Math.min(desiredSize, maxSize);
                //break;
            //case MeasureSpec.AT_MOST:
                //result = Math.min(Math.min(desiredSize, specSize), maxSize);
                //break;
            //case MeasureSpec.EXACTLY:
                //result = specSize;
                //break;
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.990 -0400", hash_original_method = "7ED99727E4B1435AFDB83292B92819BD", hash_generated_method = "13B4120552CDDB7F6CA654CEEEFF2615")
    @Override
    protected boolean setFrame(int l, int t, int r, int b) {
        addTaint(b);
        addTaint(r);
        addTaint(t);
        addTaint(l);
        boolean changed = super.setFrame(l, t, r, b);
        mHaveFrame = true;
        configureBounds();
        boolean var8977DFAC2F8E04CB96E66882235F5ABA_1760721835 = (changed);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_459208829 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_459208829;
        // ---------- Original Method ----------
        //boolean changed = super.setFrame(l, t, r, b);
        //mHaveFrame = true;
        //configureBounds();
        //return changed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.994 -0400", hash_original_method = "3A8E22D575255E0F3266968983CC3C02", hash_generated_method = "A9094CECDD9FA1324C6E0F82BCD42C44")
    private void configureBounds() {
    if(mDrawable == null || !mHaveFrame)        
        {
            return;
        } //End block
        int dwidth = mDrawableWidth;
        int dheight = mDrawableHeight;
        int vwidth = getWidth() - mPaddingLeft - mPaddingRight;
        int vheight = getHeight() - mPaddingTop - mPaddingBottom;
        boolean fits = (dwidth < 0 || vwidth == dwidth) &&
                       (dheight < 0 || vheight == dheight);
    if(dwidth <= 0 || dheight <= 0 || ScaleType.FIT_XY == mScaleType)        
        {
            mDrawable.setBounds(0, 0, vwidth, vheight);
            mDrawMatrix = null;
        } //End block
        else
        {
            mDrawable.setBounds(0, 0, dwidth, dheight);
    if(ScaleType.MATRIX == mScaleType)            
            {
    if(mMatrix.isIdentity())                
                {
                    mDrawMatrix = null;
                } //End block
                else
                {
                    mDrawMatrix = mMatrix;
                } //End block
            } //End block
            else
    if(fits)            
            {
                mDrawMatrix = null;
            } //End block
            else
    if(ScaleType.CENTER == mScaleType)            
            {
                mDrawMatrix = mMatrix;
                mDrawMatrix.setTranslate((int) ((vwidth - dwidth) * 0.5f + 0.5f),
                                         (int) ((vheight - dheight) * 0.5f + 0.5f));
            } //End block
            else
    if(ScaleType.CENTER_CROP == mScaleType)            
            {
                mDrawMatrix = mMatrix;
                float scale;
                float dx = 0;
                float dy = 0;
    if(dwidth * vheight > vwidth * dheight)                
                {
                    scale = (float) vheight / (float) dheight;
                    dx = (vwidth - dwidth * scale) * 0.5f;
                } //End block
                else
                {
                    scale = (float) vwidth / (float) dwidth;
                    dy = (vheight - dheight * scale) * 0.5f;
                } //End block
                mDrawMatrix.setScale(scale, scale);
                mDrawMatrix.postTranslate((int) (dx + 0.5f), (int) (dy + 0.5f));
            } //End block
            else
    if(ScaleType.CENTER_INSIDE == mScaleType)            
            {
                mDrawMatrix = mMatrix;
                float scale;
                float dx;
                float dy;
    if(dwidth <= vwidth && dheight <= vheight)                
                {
                    scale = 1.0f;
                } //End block
                else
                {
                    scale = Math.min((float) vwidth / (float) dwidth,
                            (float) vheight / (float) dheight);
                } //End block
                dx = (int) ((vwidth - dwidth * scale) * 0.5f + 0.5f);
                dy = (int) ((vheight - dheight * scale) * 0.5f + 0.5f);
                mDrawMatrix.setScale(scale, scale);
                mDrawMatrix.postTranslate(dx, dy);
            } //End block
            else
            {
                mTempSrc.set(0, 0, dwidth, dheight);
                mTempDst.set(0, 0, vwidth, vheight);
                mDrawMatrix = mMatrix;
                mDrawMatrix.setRectToRect(mTempSrc, mTempDst, scaleTypeToScaleToFit(mScaleType));
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.996 -0400", hash_original_method = "D78E25577A68DABE40154D5E4D97E50D", hash_generated_method = "DD0CFBE1CC2D0AE195C8B8242E8A702F")
    @Override
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable d = mDrawable;
    if(d != null && d.isStateful())        
        {
            d.setState(getDrawableState());
        } //End block
        // ---------- Original Method ----------
        //super.drawableStateChanged();
        //Drawable d = mDrawable;
        //if (d != null && d.isStateful()) {
            //d.setState(getDrawableState());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.997 -0400", hash_original_method = "355C7834E61DDE917A6F527556974749", hash_generated_method = "815D34035F4F758600330521508698C7")
    @Override
    protected void onDraw(Canvas canvas) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(canvas.getTaint());
        super.onDraw(canvas);
    if(mDrawable == null)        
        {
            return;
        } //End block
    if(mDrawableWidth == 0 || mDrawableHeight == 0)        
        {
            return;
        } //End block
    if(mDrawMatrix == null && mPaddingTop == 0 && mPaddingLeft == 0)        
        {
            mDrawable.draw(canvas);
        } //End block
        else
        {
            int saveCount = canvas.getSaveCount();
            canvas.save();
    if(mCropToPadding)            
            {
                final int scrollX = mScrollX;
                final int scrollY = mScrollY;
                canvas.clipRect(scrollX + mPaddingLeft, scrollY + mPaddingTop,
                        scrollX + mRight - mLeft - mPaddingRight,
                        scrollY + mBottom - mTop - mPaddingBottom);
            } //End block
            canvas.translate(mPaddingLeft, mPaddingTop);
    if(mDrawMatrix != null)            
            {
                canvas.concat(mDrawMatrix);
            } //End block
            mDrawable.draw(canvas);
            canvas.restoreToCount(saveCount);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.997 -0400", hash_original_method = "697E0DCA3A40ADA0E60547E8AD02CB08", hash_generated_method = "A24C6A49C8E053D87810B6B6EA267382")
    @Override
    @ViewDebug.ExportedProperty(category = "layout")
    public int getBaseline() {
    if(mBaselineAlignBottom)        
        {
            int varC4673332F839A2FA125328034972035F_2077515054 = (getMeasuredHeight());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_693841502 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_693841502;
        } //End block
        else
        {
            int var3D720983D149EBC77303DA989B1707CA_2079249151 = (mBaseline);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1804010232 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1804010232;
        } //End block
        // ---------- Original Method ----------
        //if (mBaselineAlignBottom) {
            //return getMeasuredHeight();
        //} else {
            //return mBaseline;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.998 -0400", hash_original_method = "8108AC4FDDF644F63A2CB47972E74B33", hash_generated_method = "80C984DB9AC99244DA309C5418CA4008")
    public void setBaseline(int baseline) {
    if(mBaseline != baseline)        
        {
            mBaseline = baseline;
            requestLayout();
        } //End block
        // ---------- Original Method ----------
        //if (mBaseline != baseline) {
            //mBaseline = baseline;
            //requestLayout();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.998 -0400", hash_original_method = "ACC3D162C0B2FC40FF806607AF970BEE", hash_generated_method = "5A35C57A66344639548242D450EF4A06")
    public void setBaselineAlignBottom(boolean aligned) {
    if(mBaselineAlignBottom != aligned)        
        {
            mBaselineAlignBottom = aligned;
            requestLayout();
        } //End block
        // ---------- Original Method ----------
        //if (mBaselineAlignBottom != aligned) {
            //mBaselineAlignBottom = aligned;
            //requestLayout();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.999 -0400", hash_original_method = "7D3365C5D6F47846F65EFD0480835D79", hash_generated_method = "3307B7D7CB30FD7EB6E48320DEA1F61F")
    public boolean getBaselineAlignBottom() {
        boolean varA26D0642E93B878E7AEE8C305FF97C22_206369390 = (mBaselineAlignBottom);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1367315378 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1367315378;
        // ---------- Original Method ----------
        //return mBaselineAlignBottom;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.999 -0400", hash_original_method = "F0522F608E5F96C5D99BDA1CF055B16B", hash_generated_method = "6444716592ECA7BF90D9581F9DD179F3")
    public final void setColorFilter(int color, PorterDuff.Mode mode) {
        addTaint(mode.getTaint());
        addTaint(color);
        setColorFilter(new PorterDuffColorFilter(color, mode));
        // ---------- Original Method ----------
        //setColorFilter(new PorterDuffColorFilter(color, mode));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.999 -0400", hash_original_method = "50A13570451A3C69931555EF0FE8C15D", hash_generated_method = "14D6800C6A6954D90B5CBC7212777D42")
    @RemotableViewMethod
    public final void setColorFilter(int color) {
        addTaint(color);
        setColorFilter(color, PorterDuff.Mode.SRC_ATOP);
        // ---------- Original Method ----------
        //setColorFilter(color, PorterDuff.Mode.SRC_ATOP);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.999 -0400", hash_original_method = "B358CFD4AAFD748C624F742F21F12081", hash_generated_method = "5C5D223E65BC6100D1D7D1061123E386")
    public final void clearColorFilter() {
        setColorFilter(null);
        // ---------- Original Method ----------
        //setColorFilter(null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.000 -0400", hash_original_method = "0E997722FEDD3E607A6B49B3558418D6", hash_generated_method = "9A2E6D22B86ED80684E83AC67FC8BFDF")
    public void setColorFilter(ColorFilter cf) {
    if(mColorFilter != cf)        
        {
            mColorFilter = cf;
            mColorMod = true;
            applyColorMod();
            invalidate();
        } //End block
        // ---------- Original Method ----------
        //if (mColorFilter != cf) {
            //mColorFilter = cf;
            //mColorMod = true;
            //applyColorMod();
            //invalidate();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.001 -0400", hash_original_method = "F29539FC5DE82D33A1732D8CBDF1B3F0", hash_generated_method = "7BC657C114B1356AFE6F5243CA74195D")
    @RemotableViewMethod
    public void setAlpha(int alpha) {
        alpha &= 0xFF;
    if(mAlpha != alpha)        
        {
            mAlpha = alpha;
            mColorMod = true;
            applyColorMod();
            invalidate();
        } //End block
        // ---------- Original Method ----------
        //alpha &= 0xFF;
        //if (mAlpha != alpha) {
            //mAlpha = alpha;
            //mColorMod = true;
            //applyColorMod();
            //invalidate();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.001 -0400", hash_original_method = "91840135D820437FBAEF19E5465CA144", hash_generated_method = "A57ACE779DD17A6273C6730F7C31547B")
    private void applyColorMod() {
    if(mDrawable != null && mColorMod)        
        {
            mDrawable = mDrawable.mutate();
            mDrawable.setColorFilter(mColorFilter);
            mDrawable.setAlpha(mAlpha * mViewAlphaScale >> 8);
        } //End block
        // ---------- Original Method ----------
        //if (mDrawable != null && mColorMod) {
            //mDrawable = mDrawable.mutate();
            //mDrawable.setColorFilter(mColorFilter);
            //mDrawable.setAlpha(mAlpha * mViewAlphaScale >> 8);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.002 -0400", hash_original_method = "C6B07741C64FD260DDE5C02AC0455E05", hash_generated_method = "EAB1B39D1CE84EB00581F793D469D57E")
    @RemotableViewMethod
    @Override
    public void setVisibility(int visibility) {
        addTaint(visibility);
        super.setVisibility(visibility);
    if(mDrawable != null)        
        {
            mDrawable.setVisible(visibility == VISIBLE, false);
        } //End block
        // ---------- Original Method ----------
        //super.setVisibility(visibility);
        //if (mDrawable != null) {
            //mDrawable.setVisible(visibility == VISIBLE, false);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.002 -0400", hash_original_method = "3717E0990FC85EED7B1343A97507698D", hash_generated_method = "B1E5E56D571E2B53A9A6D95C52312116")
    @Override
    protected void onAttachedToWindow() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onAttachedToWindow();
    if(mDrawable != null)        
        {
            mDrawable.setVisible(getVisibility() == VISIBLE, false);
        } //End block
        // ---------- Original Method ----------
        //super.onAttachedToWindow();
        //if (mDrawable != null) {
            //mDrawable.setVisible(getVisibility() == VISIBLE, false);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.002 -0400", hash_original_method = "66E6E711A91B2172E1C35BB591AC6445", hash_generated_method = "C4081A958D547BC7E7545B67BFED03FE")
    @Override
    protected void onDetachedFromWindow() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onDetachedFromWindow();
    if(mDrawable != null)        
        {
            mDrawable.setVisible(false, false);
        } //End block
        // ---------- Original Method ----------
        //super.onDetachedFromWindow();
        //if (mDrawable != null) {
            //mDrawable.setVisible(false, false);
        //}
    }

    
    public enum ScaleType {
        MATRIX      (0),
        FIT_XY      (1),
        FIT_START   (2),
        FIT_CENTER  (3),
        FIT_END     (4),
        CENTER      (5),
        CENTER_CROP (6),
        CENTER_INSIDE (7);
        ScaleType(int ni) {
            nativeInt = ni;
        }
        final int nativeInt;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.003 -0400", hash_original_field = "7E568904C4012C80628F09B984FC27AC", hash_generated_field = "49F3AE1F9A33DAD969F75FE221C01603")

    private static final ScaleType[] sScaleTypeArray = {
        ScaleType.MATRIX,
        ScaleType.FIT_XY,
        ScaleType.FIT_START,
        ScaleType.FIT_CENTER,
        ScaleType.FIT_END,
        ScaleType.CENTER,
        ScaleType.CENTER_CROP,
        ScaleType.CENTER_INSIDE
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:07.003 -0400", hash_original_field = "BABD88A0FAF20FCB5EB18CA03EA603B0", hash_generated_field = "6A6FB41DF0BD10A3E546839DDC4FEEB8")

    private static final Matrix.ScaleToFit[] sS2FArray = {
        Matrix.ScaleToFit.FILL,
        Matrix.ScaleToFit.START,
        Matrix.ScaleToFit.CENTER,
        Matrix.ScaleToFit.END
    };
}

