package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:06.472 -0400", hash_original_field = "5FBE3730DCFF234F97B15868D5CE649D", hash_generated_field = "04FA8EB5D9FB8AC4AAE6453BCF1BBF82")

    private Uri mUri;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:06.472 -0400", hash_original_field = "9687C18AF187DE568609D63BF0C95F6E", hash_generated_field = "A1149776195D9A81C2251417049A8983")

    private int mResource = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:06.472 -0400", hash_original_field = "9FEB0FB4D7668A1A69C2CCE86D8FE6AA", hash_generated_field = "19EDBF8F5E96D57B14276EDE6AD2F400")

    private Matrix mMatrix;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:06.472 -0400", hash_original_field = "0BFEC49F5128457BE902AB856ABE41D0", hash_generated_field = "D019EEE3A15FE9FAE26B5448B9F5829B")

    private ScaleType mScaleType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:06.472 -0400", hash_original_field = "0D8E6A9A6439BD0EDB0134B86DD0FF56", hash_generated_field = "A9F2FED4F49AAE6AC6AEAF755030819C")

    private boolean mHaveFrame = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:06.472 -0400", hash_original_field = "E48EA5F392E29C330AAD7777031257FE", hash_generated_field = "0CE29D9D9A45271B43F0AD7DE06F84E1")

    private boolean mAdjustViewBounds = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:06.472 -0400", hash_original_field = "9F06F72E481BAF7A136AD40FA3B01EB4", hash_generated_field = "63C7BFD9234113D05BBC54B620020077")

    private int mMaxWidth = Integer.MAX_VALUE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:06.472 -0400", hash_original_field = "720F6023E916A40B06BB7677E44DB85A", hash_generated_field = "3586D5CEDE91E2DE59FB9742E85FA3AD")

    private int mMaxHeight = Integer.MAX_VALUE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:06.472 -0400", hash_original_field = "8B2ED40D22A4C08C94CFC40B6DE589B8", hash_generated_field = "5D6D299C9DDEDCCB11EFFA1C147C3DF6")

    private ColorFilter mColorFilter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:06.472 -0400", hash_original_field = "1439C01AF326A337A2401436745247DA", hash_generated_field = "D85E4CEC9C06A2D96EB98C9ADB4E0FF6")

    private int mAlpha = 255;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:06.472 -0400", hash_original_field = "05C970399FAF71ED4C8AEFEE55D2E1C7", hash_generated_field = "7D8AB2121554DAB4C026523E1BE546D1")

    private int mViewAlphaScale = 256;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:06.472 -0400", hash_original_field = "424A8580F75B780B70CB9B4272F55C40", hash_generated_field = "F19CF311EA8DC507DE046A521B9697AE")

    private boolean mColorMod = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:06.472 -0400", hash_original_field = "C211E639ECC112D6CFE9EF35C7EE2BAD", hash_generated_field = "4203E503DD280EB595B89035662691AC")

    private Drawable mDrawable = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:06.472 -0400", hash_original_field = "1D598FE22B106935C0C063CC508FA455", hash_generated_field = "55E5EFD87E77F38783CE10C9BF766B2D")

    private int[] mState = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:06.472 -0400", hash_original_field = "7500A1D75540C8BABBEABE375200D820", hash_generated_field = "CD0E3EB62F2EEB3E7C6BC89E581F03D0")

    private boolean mMergeState = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:06.472 -0400", hash_original_field = "8D44C0A2CA7183B234B6C68F8099BDEB", hash_generated_field = "D66D669C7CB840BE2CC0AE88CB04AECF")

    private int mLevel = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:06.472 -0400", hash_original_field = "BDE4B5ECFEF5B3B5C89BD588E039EB7F", hash_generated_field = "A392E3876AEB7B9CD42C742144EAE0B2")

    private int mDrawableWidth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:06.472 -0400", hash_original_field = "81B997CC4D8DA3F276798F355396D6BC", hash_generated_field = "87D310E7F957167B4F609DB1F09D884D")

    private int mDrawableHeight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:06.472 -0400", hash_original_field = "38017DD8AAC924883B1956C1C08D2174", hash_generated_field = "90F6D022B92E991BB20BB870E8BC3FF7")

    private Matrix mDrawMatrix = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:06.472 -0400", hash_original_field = "027BE59B05D90854B1A288EAC269B061", hash_generated_field = "4822CDFF0200FBD929D8DC006BC82F04")

    private RectF mTempSrc = new RectF();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:06.473 -0400", hash_original_field = "83EED2DFF6690433B8CB303B48558A0E", hash_generated_field = "3F7FC79A12F840875E4DB52E36F649AD")

    private RectF mTempDst = new RectF();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:06.473 -0400", hash_original_field = "49185ED0BC5B6EEAFDC11117FFA7532C", hash_generated_field = "2A167B0395D5D689B5161FD76D7714AC")

    private boolean mCropToPadding;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:06.473 -0400", hash_original_field = "E9071209E3EB9AFCB8B5DD7C635F8293", hash_generated_field = "FEB7CA79CE658BB3A037CDF3395A66FC")

    private int mBaseline = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:06.473 -0400", hash_original_field = "B4AAF99C1540BC541F937E9B9CDB87FA", hash_generated_field = "43E60ED5A18EF5C89E67168564FB92E1")

    private boolean mBaselineAlignBottom = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:06.473 -0400", hash_original_method = "3103DD3B06C95633A5076C8A302A640B", hash_generated_method = "9F421F362FC0D50B336DDAA22AF2B5E7")
    public  ImageView(Context context) {
        super(context);
        initImageView();
        addTaint(context.getTaint());
        // ---------- Original Method ----------
        //initImageView();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:06.484 -0400", hash_original_method = "67FF47760B585BF8195A474475D955DB", hash_generated_method = "B0770783780D65D12A52847EBE2867F1")
    public  ImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:06.486 -0400", hash_original_method = "8CC4CE610519C30A909B4E591A3E5936", hash_generated_method = "0E56B6FDDB62C90AA03A202E05810881")
    public  ImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initImageView();
        TypedArray a;
        a = context.obtainStyledAttributes(attrs,
                com.android.internal.R.styleable.ImageView, defStyle, 0);
        Drawable d;
        d = a.getDrawable(com.android.internal.R.styleable.ImageView_src);
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
        int index;
        index = a.getInt(com.android.internal.R.styleable.ImageView_scaleType, -1);
        {
            setScaleType(sScaleTypeArray[index]);
        } //End block
        int tint;
        tint = a.getInt(com.android.internal.R.styleable.ImageView_tint, 0);
        {
            setColorFilter(tint);
        } //End block
        int alpha;
        alpha = a.getInt(com.android.internal.R.styleable.ImageView_drawableAlpha, 255);
        {
            setAlpha(alpha);
        } //End block
        mCropToPadding = a.getBoolean(
                com.android.internal.R.styleable.ImageView_cropToPadding, false);
        a.recycle();
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        addTaint(defStyle);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:06.486 -0400", hash_original_method = "1C158315B1207DD6F7DBD78E9AF6090A", hash_generated_method = "6C86BA293E0B26AF0AEC484FE877D701")
    private void initImageView() {
        mMatrix     = new Matrix();
        mScaleType  = ScaleType.FIT_CENTER;
        // ---------- Original Method ----------
        //mMatrix     = new Matrix();
        //mScaleType  = ScaleType.FIT_CENTER;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:06.486 -0400", hash_original_method = "D798939B4195D6D5668E5F7C7E8DA2D2", hash_generated_method = "11A6250EB72CDF12D4BD784A34560E21")
    @Override
    protected boolean verifyDrawable(Drawable dr) {
        boolean var6F0BA58C8588BA95FEB13B8735D08D03_1649701990 = (mDrawable == dr || super.verifyDrawable(dr));
        addTaint(dr.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1116931311 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1116931311;
        // ---------- Original Method ----------
        //return mDrawable == dr || super.verifyDrawable(dr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:06.487 -0400", hash_original_method = "EFC358D3732AB4D7E168E7965D2C4CA0", hash_generated_method = "647FF0158A8AD6165B9B2605A87B9B49")
    @Override
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        mDrawable.jumpToCurrentState();
        // ---------- Original Method ----------
        //super.jumpDrawablesToCurrentState();
        //if (mDrawable != null) mDrawable.jumpToCurrentState();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:06.487 -0400", hash_original_method = "EB3EC256D00C5FC794745B960350792B", hash_generated_method = "9FAD2A829CFD8C40096433413D3DA1FF")
    @Override
    public void invalidateDrawable(Drawable dr) {
        {
            invalidate();
        } //End block
        {
            super.invalidateDrawable(dr);
        } //End block
        addTaint(dr.getTaint());
        // ---------- Original Method ----------
        //if (dr == mDrawable) {
            //invalidate();
        //} else {
            //super.invalidateDrawable(dr);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:06.487 -0400", hash_original_method = "792DD4F5E748125528D3BF6C27B77C70", hash_generated_method = "7089AB74CF517FEBB945C86EBA34BD35")
    @Override
    public int getResolvedLayoutDirection(Drawable dr) {
        {
            Object varAFC6EB2C684D509A17B3A4EFF5D9CB9D_201860263 = (getResolvedLayoutDirection());
            Object varE1F279108E97B96264B9D15008FD7CD5_1675079914 = (super.getResolvedLayoutDirection(dr));
        } //End flattened ternary
        addTaint(dr.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_484467211 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_484467211;
        // ---------- Original Method ----------
        //return (dr == mDrawable) ?
                //getResolvedLayoutDirection() : super.getResolvedLayoutDirection(dr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:06.488 -0400", hash_original_method = "000365A595FBC289F16F7AD48241010C", hash_generated_method = "BC0E5504AF4B8572F6B1178E2A23A10E")
    @Override
    protected boolean onSetAlpha(int alpha) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean varF9737FBB3FA84CB9364E87D929DD087B_468421377 = (getBackground() == null);
            {
                int scale;
                scale = alpha + (alpha >> 7);
                {
                    mViewAlphaScale = scale;
                    mColorMod = true;
                    applyColorMod();
                } //End block
            } //End block
        } //End collapsed parenthetic
        addTaint(alpha);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_549029062 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_549029062;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:06.511 -0400", hash_original_method = "9770981DD4DB73204B697C6119742B6F", hash_generated_method = "34CF7DE3236CFCA5C6E3458441EC7A6D")
    @Override
    public void onPopulateAccessibilityEvent(AccessibilityEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onPopulateAccessibilityEvent(event);
        CharSequence contentDescription;
        contentDescription = getContentDescription();
        {
            boolean var38FE545BF2449F0AB422311DB9C21872_700235970 = (!TextUtils.isEmpty(contentDescription));
            {
                event.getText().add(contentDescription);
            } //End block
        } //End collapsed parenthetic
        addTaint(event.getTaint());
        // ---------- Original Method ----------
        //super.onPopulateAccessibilityEvent(event);
        //CharSequence contentDescription = getContentDescription();
        //if (!TextUtils.isEmpty(contentDescription)) {
            //event.getText().add(contentDescription);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:06.512 -0400", hash_original_method = "3F8BE319328C68420F5075492EAAB722", hash_generated_method = "E75A3752923BDB60E8353DD155C9F586")
    @android.view.RemotableViewMethod
    public void setAdjustViewBounds(boolean adjustViewBounds) {
        mAdjustViewBounds = adjustViewBounds;
        {
            setScaleType(ScaleType.FIT_CENTER);
        } //End block
        // ---------- Original Method ----------
        //mAdjustViewBounds = adjustViewBounds;
        //if (adjustViewBounds) {
            //setScaleType(ScaleType.FIT_CENTER);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:06.512 -0400", hash_original_method = "EB73857FE18ECB168F084B0FAC346FEA", hash_generated_method = "79DFBF0CB12D07C0AEB4E082D13DCC35")
    @android.view.RemotableViewMethod
    public void setMaxWidth(int maxWidth) {
        mMaxWidth = maxWidth;
        // ---------- Original Method ----------
        //mMaxWidth = maxWidth;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:06.513 -0400", hash_original_method = "9473C5CB1AE9899AEC7CB726EABA77F7", hash_generated_method = "0CD17647B54DD7BBE70494C14EEAE2F5")
    @android.view.RemotableViewMethod
    public void setMaxHeight(int maxHeight) {
        mMaxHeight = maxHeight;
        // ---------- Original Method ----------
        //mMaxHeight = maxHeight;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:06.513 -0400", hash_original_method = "53D05784890C72350FD6879A6582F7F3", hash_generated_method = "C51337282A1F0AB227EDC6DB33F07BF8")
    public Drawable getDrawable() {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_896983116 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_896983116 = mDrawable;
        varB4EAC82CA7396A68D541C85D26508E83_896983116.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_896983116;
        // ---------- Original Method ----------
        //return mDrawable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:06.514 -0400", hash_original_method = "FEA329647011282E5AA15854AC819C8B", hash_generated_method = "A3643FD5C96F12ABFF4A0FAEB1B47A0F")
    @android.view.RemotableViewMethod
    public void setImageResource(int resId) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:06.514 -0400", hash_original_method = "796039DEA15F6465B0D947F27F5B4F32", hash_generated_method = "FBFF615779BEB924B2458F24F32A45DB")
    @android.view.RemotableViewMethod
    public void setImageURI(Uri uri) {
        {
            boolean var90AB53EB1D53155B41BCD7E227FE479A_760507771 = (mResource != 0 ||
                (mUri != uri &&
                 (uri == null || mUri == null || !uri.equals(mUri))));
            {
                updateDrawable(null);
                mResource = 0;
                mUri = uri;
                resolveUri();
                requestLayout();
                invalidate();
            } //End block
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:06.515 -0400", hash_original_method = "5426F5FAF3C8635D29ADE0169269A6F9", hash_generated_method = "24E38B7258EA1DE44A4D7ADBFC888FFB")
    public void setImageDrawable(Drawable drawable) {
        {
            mResource = 0;
            mUri = null;
            int oldWidth;
            oldWidth = mDrawableWidth;
            int oldHeight;
            oldHeight = mDrawableHeight;
            updateDrawable(drawable);
            {
                requestLayout();
            } //End block
            invalidate();
        } //End block
        addTaint(drawable.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:06.515 -0400", hash_original_method = "5EFFAF8EE29E35792B081E6E83A7DFE3", hash_generated_method = "1AA64D538B4A3D3BD41437317289C896")
    @android.view.RemotableViewMethod
    public void setImageBitmap(Bitmap bm) {
        setImageDrawable(new BitmapDrawable(mContext.getResources(), bm));
        addTaint(bm.getTaint());
        // ---------- Original Method ----------
        //setImageDrawable(new BitmapDrawable(mContext.getResources(), bm));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:06.519 -0400", hash_original_method = "B00DD17D168377A844733E90ECCFE75B", hash_generated_method = "AEB13EE0E78E1C7D679F434ABE923355")
    public void setImageState(int[] state, boolean merge) {
        mState = state;
        mMergeState = merge;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:06.520 -0400", hash_original_method = "44CE6C01D324B2DC91AFD69B5F1BB742", hash_generated_method = "1D34BBDFEBADC19AD015A84C04CBD506")
    @Override
    public void setSelected(boolean selected) {
        super.setSelected(selected);
        resizeFromDrawable();
        addTaint(selected);
        // ---------- Original Method ----------
        //super.setSelected(selected);
        //resizeFromDrawable();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:06.520 -0400", hash_original_method = "0A74FF8303919E2F74751A8C668C95F0", hash_generated_method = "5BE8AF9B93F28852EC0CBFB41E400656")
    @android.view.RemotableViewMethod
    public void setImageLevel(int level) {
        mLevel = level;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:06.538 -0400", hash_original_method = "63CC1440F0B24F3C6377C34C34E172F5", hash_generated_method = "081CB5FE252ADBD86052D5AC2152848B")
    public void setScaleType(ScaleType scaleType) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:06.539 -0400", hash_original_method = "84B4F1338E9C8554FC089CA7254325E0", hash_generated_method = "5144220B5DE9B3495487B88F49CE0A14")
    public ScaleType getScaleType() {
        ScaleType varB4EAC82CA7396A68D541C85D26508E83_1896647943 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1896647943 = mScaleType;
        varB4EAC82CA7396A68D541C85D26508E83_1896647943.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1896647943;
        // ---------- Original Method ----------
        //return mScaleType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:06.539 -0400", hash_original_method = "5B9FD9A0A164EA90D695E910523F6E96", hash_generated_method = "4554CCA922DB2B9AE2D9207AC178CEB8")
    public Matrix getImageMatrix() {
        Matrix varB4EAC82CA7396A68D541C85D26508E83_1083174968 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1083174968 = mMatrix;
        varB4EAC82CA7396A68D541C85D26508E83_1083174968.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1083174968;
        // ---------- Original Method ----------
        //return mMatrix;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:06.540 -0400", hash_original_method = "A32A82AEE544A388BA62C8178AC7E88C", hash_generated_method = "74CA2CBDEAA9F4D302EF99BB3FA05799")
    public void setImageMatrix(Matrix matrix) {
        {
            boolean var43647054FCC5E2FEA67BA4DB2B5CFDEC_986875081 = (matrix != null && matrix.isIdentity());
            {
                matrix = null;
            } //End block
        } //End collapsed parenthetic
        {
            boolean var07BF5E6DF09B8E40E54FCB7189DEE131_626954553 = (matrix == null && !mMatrix.isIdentity() ||
                matrix != null && !mMatrix.equals(matrix));
            {
                mMatrix.set(matrix);
                configureBounds();
                invalidate();
            } //End block
        } //End collapsed parenthetic
        addTaint(matrix.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:06.541 -0400", hash_original_method = "16B1589372902AF87B2F0F65CBDC5B57", hash_generated_method = "5027CB215D98C5B58D024BE5351402C3")
    private void resolveUri() {
        Resources rsrc;
        rsrc = getResources();
        Drawable d;
        d = null;
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
        {
            String scheme;
            scheme = mUri.getScheme();
            {
                boolean varF1920ADB7A324A214864F4BBBDD05F45_1839060695 = (ContentResolver.SCHEME_ANDROID_RESOURCE.equals(scheme));
                {
                    try 
                    {
                        ContentResolver.OpenResourceIdResult r;
                        r = mContext.getContentResolver().getResourceId(mUri);
                        d = r.r.getDrawable(r.id);
                    } //End block
                    catch (Exception e)
                    { }
                } //End block
                {
                    boolean varECE6BF2CA2A924F44A15A349FCEFEEC1_1746880440 = (ContentResolver.SCHEME_CONTENT.equals(scheme)
                    || ContentResolver.SCHEME_FILE.equals(scheme));
                    {
                        try 
                        {
                            d = Drawable.createFromStream(
                        mContext.getContentResolver().openInputStream(mUri),
                        null);
                        } //End block
                        catch (Exception e)
                        { }
                    } //End block
                    {
                        d = Drawable.createFromPath(mUri.toString());
                    } //End block
                } //End collapsed parenthetic
            } //End collapsed parenthetic
            {
                System.out.println("resolveUri failed on bad bitmap uri: "
                                   + mUri);
                mUri = null;
            } //End block
        } //End block
        updateDrawable(d);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:06.621 -0400", hash_original_method = "F00D7A8DB32B373F9AAF90A3CC19DF16", hash_generated_method = "2E2DF4A4E7020CDB320329C83A9B460A")
    @Override
    public int[] onCreateDrawableState(int extraSpace) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            int[] varEB7CD746CBB534A0BF67F4323334429E_271255669 = (super.onCreateDrawableState(extraSpace));
        } //End block
        {
            int[] varB6313CC42B6FF045E4878C3B3E985625_1582495484 = (mergeDrawableStates(
                    super.onCreateDrawableState(extraSpace + mState.length), mState));
        } //End block
        addTaint(extraSpace);
        int[] varB4CCCA26F9DB9189C32F33E82D425CFB_949316075 = {getTaintInt()};
        return varB4CCCA26F9DB9189C32F33E82D425CFB_949316075;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:06.623 -0400", hash_original_method = "ADE7139D7C0A9B2AE00EA96739AFBDE5", hash_generated_method = "1D2A80F7150BB41530D7016057BAF615")
    private void updateDrawable(Drawable d) {
        {
            mDrawable.setCallback(null);
            unscheduleDrawable(mDrawable);
        } //End block
        mDrawable = d;
        {
            d.setCallback(this);
            {
                boolean var732D4E5C808363BC9BF454DD27943961_208318069 = (d.isStateful());
                {
                    d.setState(getDrawableState());
                } //End block
            } //End collapsed parenthetic
            d.setLevel(mLevel);
            mDrawableWidth = d.getIntrinsicWidth();
            mDrawableHeight = d.getIntrinsicHeight();
            applyColorMod();
            configureBounds();
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:06.623 -0400", hash_original_method = "E1DD34F979587974CF0EAF8DF3CFC3FF", hash_generated_method = "85EC587581ED12F4914FA264FC10AA13")
    private void resizeFromDrawable() {
        Drawable d;
        d = mDrawable;
        {
            int w;
            w = d.getIntrinsicWidth();
            w = mDrawableWidth;
            int h;
            h = d.getIntrinsicHeight();
            h = mDrawableHeight;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:06.631 -0400", hash_original_method = "5D5C8E0C5B3B131983F43D2E85F23CCE", hash_generated_method = "9CD58101DF910694B061EDA34058F836")
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        resolveUri();
        int w;
        int h;
        float desiredAspect;
        desiredAspect = 0.0f;
        boolean resizeWidth;
        resizeWidth = false;
        boolean resizeHeight;
        resizeHeight = false;
        int widthSpecMode;
        widthSpecMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightSpecMode;
        heightSpecMode = MeasureSpec.getMode(heightMeasureSpec);
        {
            mDrawableWidth = -1;
            mDrawableHeight = -1;
            w = h = 0;
        } //End block
        {
            w = mDrawableWidth;
            h = mDrawableHeight;
            w = 1;
            h = 1;
            {
                resizeWidth = widthSpecMode != MeasureSpec.EXACTLY;
                resizeHeight = heightSpecMode != MeasureSpec.EXACTLY;
                desiredAspect = (float) w / (float) h;
            } //End block
        } //End block
        int pleft;
        pleft = mPaddingLeft;
        int pright;
        pright = mPaddingRight;
        int ptop;
        ptop = mPaddingTop;
        int pbottom;
        pbottom = mPaddingBottom;
        int widthSize;
        int heightSize;
        {
            widthSize = resolveAdjustedSize(w + pleft + pright, mMaxWidth, widthMeasureSpec);
            heightSize = resolveAdjustedSize(h + ptop + pbottom, mMaxHeight, heightMeasureSpec);
            {
                float actualAspect;
                actualAspect = (float)(widthSize - pleft - pright) /
                                        (heightSize - ptop - pbottom);
                {
                    boolean var659D7277B9251B22E516EA6035BDC5A3_1466192023 = (Math.abs(actualAspect - desiredAspect) > 0.0000001);
                    {
                        boolean done;
                        done = false;
                        {
                            int newWidth;
                            newWidth = (int)(desiredAspect * (heightSize - ptop - pbottom)) +
                                pleft + pright;
                            {
                                widthSize = newWidth;
                                done = true;
                            } //End block
                        } //End block
                        {
                            int newHeight;
                            newHeight = (int)((widthSize - pleft - pright) / desiredAspect) +
                                ptop + pbottom;
                            {
                                heightSize = newHeight;
                            } //End block
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        {
            w += pleft + pright;
            h += ptop + pbottom;
            w = Math.max(w, getSuggestedMinimumWidth());
            h = Math.max(h, getSuggestedMinimumHeight());
            widthSize = resolveSizeAndState(w, widthMeasureSpec, 0);
            heightSize = resolveSizeAndState(h, heightMeasureSpec, 0);
        } //End block
        setMeasuredDimension(widthSize, heightSize);
        addTaint(widthMeasureSpec);
        addTaint(heightMeasureSpec);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:06.639 -0400", hash_original_method = "6790E6B3204D72187344DF3593244181", hash_generated_method = "368810B20AE9B003A7308BB6D1DD1098")
    private int resolveAdjustedSize(int desiredSize, int maxSize,
                                   int measureSpec) {
        int result;
        result = desiredSize;
        int specMode;
        specMode = MeasureSpec.getMode(measureSpec);
        int specSize;
        specSize = MeasureSpec.getSize(measureSpec);
        //Begin case MeasureSpec.UNSPECIFIED 
        result = Math.min(desiredSize, maxSize);
        //End case MeasureSpec.UNSPECIFIED 
        //Begin case MeasureSpec.AT_MOST 
        result = Math.min(Math.min(desiredSize, specSize), maxSize);
        //End case MeasureSpec.AT_MOST 
        //Begin case MeasureSpec.EXACTLY 
        result = specSize;
        //End case MeasureSpec.EXACTLY 
        addTaint(desiredSize);
        addTaint(maxSize);
        addTaint(measureSpec);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1122221861 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1122221861;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:06.639 -0400", hash_original_method = "7ED99727E4B1435AFDB83292B92819BD", hash_generated_method = "59E84B7AA8D164A937443B2C9CDDFF94")
    @Override
    protected boolean setFrame(int l, int t, int r, int b) {
        boolean changed;
        changed = super.setFrame(l, t, r, b);
        mHaveFrame = true;
        configureBounds();
        addTaint(l);
        addTaint(t);
        addTaint(r);
        addTaint(b);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_334334659 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_334334659;
        // ---------- Original Method ----------
        //boolean changed = super.setFrame(l, t, r, b);
        //mHaveFrame = true;
        //configureBounds();
        //return changed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:06.641 -0400", hash_original_method = "3A8E22D575255E0F3266968983CC3C02", hash_generated_method = "6A3D967B9F29E6E0FC4ADBE51D0FB8DF")
    private void configureBounds() {
        int dwidth;
        dwidth = mDrawableWidth;
        int dheight;
        dheight = mDrawableHeight;
        int vwidth;
        vwidth = getWidth() - mPaddingLeft - mPaddingRight;
        int vheight;
        vheight = getHeight() - mPaddingTop - mPaddingBottom;
        boolean fits;
        fits = (dwidth < 0 || vwidth == dwidth) &&
                       (dheight < 0 || vheight == dheight);
        {
            mDrawable.setBounds(0, 0, vwidth, vheight);
            mDrawMatrix = null;
        } //End block
        {
            mDrawable.setBounds(0, 0, dwidth, dheight);
            {
                {
                    boolean var807A3C6E5DF9AC9E8557F287A85C43B9_466736362 = (mMatrix.isIdentity());
                    {
                        mDrawMatrix = null;
                    } //End block
                    {
                        mDrawMatrix = mMatrix;
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                mDrawMatrix = null;
            } //End block
            {
                mDrawMatrix = mMatrix;
                mDrawMatrix.setTranslate((int) ((vwidth - dwidth) * 0.5f + 0.5f),
                                         (int) ((vheight - dheight) * 0.5f + 0.5f));
            } //End block
            {
                mDrawMatrix = mMatrix;
                float scale;
                float dx, dy;
                dx = 0;
                dy = 0;
                {
                    scale = (float) vheight / (float) dheight;
                    dx = (vwidth - dwidth * scale) * 0.5f;
                } //End block
                {
                    scale = (float) vwidth / (float) dwidth;
                    dy = (vheight - dheight * scale) * 0.5f;
                } //End block
                mDrawMatrix.setScale(scale, scale);
                mDrawMatrix.postTranslate((int) (dx + 0.5f), (int) (dy + 0.5f));
            } //End block
            {
                mDrawMatrix = mMatrix;
                float scale;
                float dx;
                float dy;
                {
                    scale = 1.0f;
                } //End block
                {
                    scale = Math.min((float) vwidth / (float) dwidth,
                            (float) vheight / (float) dheight);
                } //End block
                dx = (int) ((vwidth - dwidth * scale) * 0.5f + 0.5f);
                dy = (int) ((vheight - dheight * scale) * 0.5f + 0.5f);
                mDrawMatrix.setScale(scale, scale);
                mDrawMatrix.postTranslate(dx, dy);
            } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:06.642 -0400", hash_original_method = "D78E25577A68DABE40154D5E4D97E50D", hash_generated_method = "B58DD51EDD20E8B134F39E713E942C66")
    @Override
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable d;
        d = mDrawable;
        {
            boolean var9E4512E9555DA1255DDDA9AE20837176_43540720 = (d != null && d.isStateful());
            {
                d.setState(getDrawableState());
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //super.drawableStateChanged();
        //Drawable d = mDrawable;
        //if (d != null && d.isStateful()) {
            //d.setState(getDrawableState());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:06.642 -0400", hash_original_method = "355C7834E61DDE917A6F527556974749", hash_generated_method = "58DD27EC409CA0BEC756E026DCCE04F5")
    @Override
    protected void onDraw(Canvas canvas) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onDraw(canvas);
        {
            mDrawable.draw(canvas);
        } //End block
        {
            int saveCount;
            saveCount = canvas.getSaveCount();
            canvas.save();
            {
                int scrollX;
                scrollX = mScrollX;
                int scrollY;
                scrollY = mScrollY;
                canvas.clipRect(scrollX + mPaddingLeft, scrollY + mPaddingTop,
                        scrollX + mRight - mLeft - mPaddingRight,
                        scrollY + mBottom - mTop - mPaddingBottom);
            } //End block
            canvas.translate(mPaddingLeft, mPaddingTop);
            {
                canvas.concat(mDrawMatrix);
            } //End block
            mDrawable.draw(canvas);
            canvas.restoreToCount(saveCount);
        } //End block
        addTaint(canvas.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:06.651 -0400", hash_original_method = "697E0DCA3A40ADA0E60547E8AD02CB08", hash_generated_method = "7F49947A76290A947BFB5083071F5E92")
    @Override
    @ViewDebug.ExportedProperty(category = "layout")
    public int getBaseline() {
        {
            int var0FD144A91B49367E40CB3EFF8BA82D53_377128822 = (getMeasuredHeight());
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1687307707 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1687307707;
        // ---------- Original Method ----------
        //if (mBaselineAlignBottom) {
            //return getMeasuredHeight();
        //} else {
            //return mBaseline;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:06.651 -0400", hash_original_method = "8108AC4FDDF644F63A2CB47972E74B33", hash_generated_method = "F52E4655157809D4D5DAB9BDFA329E08")
    public void setBaseline(int baseline) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:06.651 -0400", hash_original_method = "ACC3D162C0B2FC40FF806607AF970BEE", hash_generated_method = "9F3EADD7128D9E893534C5087EBFBFE4")
    public void setBaselineAlignBottom(boolean aligned) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:06.670 -0400", hash_original_method = "7D3365C5D6F47846F65EFD0480835D79", hash_generated_method = "23FBB61B34F616775D06BDAAC6BDB68B")
    public boolean getBaselineAlignBottom() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_416301189 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_416301189;
        // ---------- Original Method ----------
        //return mBaselineAlignBottom;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:06.670 -0400", hash_original_method = "F0522F608E5F96C5D99BDA1CF055B16B", hash_generated_method = "10272503CBB37208DEF183989CB96CFA")
    public final void setColorFilter(int color, PorterDuff.Mode mode) {
        setColorFilter(new PorterDuffColorFilter(color, mode));
        addTaint(color);
        addTaint(mode.getTaint());
        // ---------- Original Method ----------
        //setColorFilter(new PorterDuffColorFilter(color, mode));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:06.670 -0400", hash_original_method = "50A13570451A3C69931555EF0FE8C15D", hash_generated_method = "D6347BFDDC87510138AB2703865BEDE6")
    @RemotableViewMethod
    public final void setColorFilter(int color) {
        setColorFilter(color, PorterDuff.Mode.SRC_ATOP);
        addTaint(color);
        // ---------- Original Method ----------
        //setColorFilter(color, PorterDuff.Mode.SRC_ATOP);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:06.671 -0400", hash_original_method = "B358CFD4AAFD748C624F742F21F12081", hash_generated_method = "5C5D223E65BC6100D1D7D1061123E386")
    public final void clearColorFilter() {
        setColorFilter(null);
        // ---------- Original Method ----------
        //setColorFilter(null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:06.671 -0400", hash_original_method = "0E997722FEDD3E607A6B49B3558418D6", hash_generated_method = "50A2DC2D3B3213E8C9E9E6B4664C560F")
    public void setColorFilter(ColorFilter cf) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:06.671 -0400", hash_original_method = "F29539FC5DE82D33A1732D8CBDF1B3F0", hash_generated_method = "6D36D0C433F7BBF238B97B5A7EB7CF11")
    @RemotableViewMethod
    public void setAlpha(int alpha) {
        alpha &= 0xFF;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:06.672 -0400", hash_original_method = "91840135D820437FBAEF19E5465CA144", hash_generated_method = "D82B0E771B88C4DF60816FA3343812D8")
    private void applyColorMod() {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:06.672 -0400", hash_original_method = "C6B07741C64FD260DDE5C02AC0455E05", hash_generated_method = "095CF5C3DEBC96A747A3D510DE34B26B")
    @RemotableViewMethod
    @Override
    public void setVisibility(int visibility) {
        super.setVisibility(visibility);
        {
            mDrawable.setVisible(visibility == VISIBLE, false);
        } //End block
        addTaint(visibility);
        // ---------- Original Method ----------
        //super.setVisibility(visibility);
        //if (mDrawable != null) {
            //mDrawable.setVisible(visibility == VISIBLE, false);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:06.673 -0400", hash_original_method = "3717E0990FC85EED7B1343A97507698D", hash_generated_method = "EC1E159C12789844B8825972D42E1432")
    @Override
    protected void onAttachedToWindow() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onAttachedToWindow();
        {
            mDrawable.setVisible(getVisibility() == VISIBLE, false);
        } //End block
        // ---------- Original Method ----------
        //super.onAttachedToWindow();
        //if (mDrawable != null) {
            //mDrawable.setVisible(getVisibility() == VISIBLE, false);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:06.673 -0400", hash_original_method = "66E6E711A91B2172E1C35BB591AC6445", hash_generated_method = "432FDA0B484BC398E47027374674B201")
    @Override
    protected void onDetachedFromWindow() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onDetachedFromWindow();
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:06.673 -0400", hash_original_field = "7E568904C4012C80628F09B984FC27AC", hash_generated_field = "EFCA94048849D4D13F613F390665714B")

    private static ScaleType[] sScaleTypeArray = ;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:06.673 -0400", hash_original_field = "BABD88A0FAF20FCB5EB18CA03EA603B0", hash_generated_field = "BCEABF529AEBDF3F50E9FDB117AFF7A1")

    private static Matrix.ScaleToFit[] sS2FArray = ;
}

