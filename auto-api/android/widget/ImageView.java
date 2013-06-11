package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
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
    private Uri mUri;
    private int mResource = 0;
    private Matrix mMatrix;
    private ScaleType mScaleType;
    private boolean mHaveFrame = false;
    private boolean mAdjustViewBounds = false;
    private int mMaxWidth = Integer.MAX_VALUE;
    private int mMaxHeight = Integer.MAX_VALUE;
    private ColorFilter mColorFilter;
    private int mAlpha = 255;
    private int mViewAlphaScale = 256;
    private boolean mColorMod = false;
    private Drawable mDrawable = null;
    private int[] mState = null;
    private boolean mMergeState = false;
    private int mLevel = 0;
    private int mDrawableWidth;
    private int mDrawableHeight;
    private Matrix mDrawMatrix = null;
    private RectF mTempSrc = new RectF();
    private RectF mTempDst = new RectF();
    private boolean mCropToPadding;
    private int mBaseline = -1;
    private boolean mBaselineAlignBottom = false;
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
    private static final Matrix.ScaleToFit[] sS2FArray = {
        Matrix.ScaleToFit.FILL,
        Matrix.ScaleToFit.START,
        Matrix.ScaleToFit.CENTER,
        Matrix.ScaleToFit.END
    };
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.651 -0400", hash_original_method = "3103DD3B06C95633A5076C8A302A640B", hash_generated_method = "26F39DB4E67F66C7D8FDA3BE8C5195B8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ImageView(Context context) {
        super(context);
        dsTaint.addTaint(context.dsTaint);
        initImageView();
        // ---------- Original Method ----------
        //initImageView();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.652 -0400", hash_original_method = "67FF47760B585BF8195A474475D955DB", hash_generated_method = "2806DE573F273E120206E119394D9106")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.652 -0400", hash_original_method = "8CC4CE610519C30A909B4E591A3E5936", hash_generated_method = "A66755DE1E8D980CE466C9848E87D555")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(defStyle);
        dsTaint.addTaint(context.dsTaint);
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.652 -0400", hash_original_method = "1C158315B1207DD6F7DBD78E9AF6090A", hash_generated_method = "E3C02E34DEDD65D9A31106A989E9021E")
    @DSModeled(DSC.SAFE)
    private void initImageView() {
        mMatrix     = new Matrix();
        mScaleType  = ScaleType.FIT_CENTER;
        // ---------- Original Method ----------
        //mMatrix     = new Matrix();
        //mScaleType  = ScaleType.FIT_CENTER;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.652 -0400", hash_original_method = "D798939B4195D6D5668E5F7C7E8DA2D2", hash_generated_method = "64BAF6CF0D3E3C4C6400CA0C7828B130")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected boolean verifyDrawable(Drawable dr) {
        dsTaint.addTaint(dr.dsTaint);
        boolean var6F0BA58C8588BA95FEB13B8735D08D03_1059234565 = (mDrawable == dr || super.verifyDrawable(dr));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mDrawable == dr || super.verifyDrawable(dr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.652 -0400", hash_original_method = "EFC358D3732AB4D7E168E7965D2C4CA0", hash_generated_method = "B3315DAB3C70F8B3E172FAD12F0D7DE8")
    @DSModeled(DSC.SAFE)
    @Override
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        mDrawable.jumpToCurrentState();
        // ---------- Original Method ----------
        //super.jumpDrawablesToCurrentState();
        //if (mDrawable != null) mDrawable.jumpToCurrentState();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.652 -0400", hash_original_method = "EB3EC256D00C5FC794745B960350792B", hash_generated_method = "CF6460F1E45333DAEDBD9DC79A87B983")
    @DSModeled(DSC.SAFE)
    @Override
    public void invalidateDrawable(Drawable dr) {
        dsTaint.addTaint(dr.dsTaint);
        {
            invalidate();
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.652 -0400", hash_original_method = "792DD4F5E748125528D3BF6C27B77C70", hash_generated_method = "48334B807FD203F62430D816DADEA546")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getResolvedLayoutDirection(Drawable dr) {
        dsTaint.addTaint(dr.dsTaint);
        {
            Object varAFC6EB2C684D509A17B3A4EFF5D9CB9D_808279197 = (getResolvedLayoutDirection());
            Object varE1F279108E97B96264B9D15008FD7CD5_248246161 = (super.getResolvedLayoutDirection(dr));
        } //End flattened ternary
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return (dr == mDrawable) ?
                //getResolvedLayoutDirection() : super.getResolvedLayoutDirection(dr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.652 -0400", hash_original_method = "000365A595FBC289F16F7AD48241010C", hash_generated_method = "31DC0D0B2510F3C42CC3D6BB4B7D48D6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected boolean onSetAlpha(int alpha) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(alpha);
        {
            boolean varF9737FBB3FA84CB9364E87D929DD087B_766390136 = (getBackground() == null);
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
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.653 -0400", hash_original_method = "9770981DD4DB73204B697C6119742B6F", hash_generated_method = "BC6ABCBCDC983D4C0796D3ED7457DBA1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void onPopulateAccessibilityEvent(AccessibilityEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(event.dsTaint);
        super.onPopulateAccessibilityEvent(event);
        CharSequence contentDescription;
        contentDescription = getContentDescription();
        {
            boolean var38FE545BF2449F0AB422311DB9C21872_2006843734 = (!TextUtils.isEmpty(contentDescription));
            {
                event.getText().add(contentDescription);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //super.onPopulateAccessibilityEvent(event);
        //CharSequence contentDescription = getContentDescription();
        //if (!TextUtils.isEmpty(contentDescription)) {
            //event.getText().add(contentDescription);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.653 -0400", hash_original_method = "3F8BE319328C68420F5075492EAAB722", hash_generated_method = "9795D3904079F2C93B5C9E7A53513747")
    @DSModeled(DSC.SAFE)
    @android.view.RemotableViewMethod
    public void setAdjustViewBounds(boolean adjustViewBounds) {
        dsTaint.addTaint(adjustViewBounds);
        {
            setScaleType(ScaleType.FIT_CENTER);
        } //End block
        // ---------- Original Method ----------
        //mAdjustViewBounds = adjustViewBounds;
        //if (adjustViewBounds) {
            //setScaleType(ScaleType.FIT_CENTER);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.653 -0400", hash_original_method = "EB73857FE18ECB168F084B0FAC346FEA", hash_generated_method = "8A43C975926F87E2EE81C4653449316F")
    @DSModeled(DSC.SAFE)
    @android.view.RemotableViewMethod
    public void setMaxWidth(int maxWidth) {
        dsTaint.addTaint(maxWidth);
        // ---------- Original Method ----------
        //mMaxWidth = maxWidth;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.653 -0400", hash_original_method = "9473C5CB1AE9899AEC7CB726EABA77F7", hash_generated_method = "6758ADE70D36ECEBCE1C9874D3B54D7A")
    @DSModeled(DSC.SAFE)
    @android.view.RemotableViewMethod
    public void setMaxHeight(int maxHeight) {
        dsTaint.addTaint(maxHeight);
        // ---------- Original Method ----------
        //mMaxHeight = maxHeight;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.653 -0400", hash_original_method = "53D05784890C72350FD6879A6582F7F3", hash_generated_method = "60A7BE3085B581B0B3D414416142ADE4")
    @DSModeled(DSC.SAFE)
    public Drawable getDrawable() {
        return (Drawable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mDrawable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.653 -0400", hash_original_method = "FEA329647011282E5AA15854AC819C8B", hash_generated_method = "84A6C2A51EDA5BB27E26FECD824E26F5")
    @DSModeled(DSC.SAFE)
    @android.view.RemotableViewMethod
    public void setImageResource(int resId) {
        dsTaint.addTaint(resId);
        {
            updateDrawable(null);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.653 -0400", hash_original_method = "796039DEA15F6465B0D947F27F5B4F32", hash_generated_method = "5E7D78AB5C78D86CA6AA4EA5A888FA16")
    @DSModeled(DSC.SPEC)
    @android.view.RemotableViewMethod
    public void setImageURI(Uri uri) {
        dsTaint.addTaint(uri.dsTaint);
        {
            boolean var90AB53EB1D53155B41BCD7E227FE479A_26508229 = (mResource != 0 ||
                (mUri != uri &&
                 (uri == null || mUri == null || !uri.equals(mUri))));
            {
                updateDrawable(null);
                mResource = 0;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.653 -0400", hash_original_method = "5426F5FAF3C8635D29ADE0169269A6F9", hash_generated_method = "53B0FC7EBCC62BFFD21D24B6E4EB03B0")
    @DSModeled(DSC.SAFE)
    public void setImageDrawable(Drawable drawable) {
        dsTaint.addTaint(drawable.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.653 -0400", hash_original_method = "5EFFAF8EE29E35792B081E6E83A7DFE3", hash_generated_method = "BA54DF731F5DDC7AC8D7E88722B9B394")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @android.view.RemotableViewMethod
    public void setImageBitmap(Bitmap bm) {
        dsTaint.addTaint(bm.dsTaint);
        setImageDrawable(new BitmapDrawable(mContext.getResources(), bm));
        // ---------- Original Method ----------
        //setImageDrawable(new BitmapDrawable(mContext.getResources(), bm));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.653 -0400", hash_original_method = "B00DD17D168377A844733E90ECCFE75B", hash_generated_method = "6BAA6D9BC84BAED00EFF5BEBFDF8DD87")
    @DSModeled(DSC.SAFE)
    public void setImageState(int[] state, boolean merge) {
        dsTaint.addTaint(merge);
        dsTaint.addTaint(state);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.653 -0400", hash_original_method = "44CE6C01D324B2DC91AFD69B5F1BB742", hash_generated_method = "0F98536D5FBA486DB69CCD502A4BF4E2")
    @DSModeled(DSC.SAFE)
    @Override
    public void setSelected(boolean selected) {
        dsTaint.addTaint(selected);
        super.setSelected(selected);
        resizeFromDrawable();
        // ---------- Original Method ----------
        //super.setSelected(selected);
        //resizeFromDrawable();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.653 -0400", hash_original_method = "0A74FF8303919E2F74751A8C668C95F0", hash_generated_method = "3300BC90354DD517FCB84B437A54188D")
    @DSModeled(DSC.SAFE)
    @android.view.RemotableViewMethod
    public void setImageLevel(int level) {
        dsTaint.addTaint(level);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.654 -0400", hash_original_method = "63CC1440F0B24F3C6377C34C34E172F5", hash_generated_method = "79697A6909709BA3C6E4A3BFA058E8B8")
    @DSModeled(DSC.SAFE)
    public void setScaleType(ScaleType scaleType) {
        dsTaint.addTaint(scaleType.dsTaint);
        {
            throw new NullPointerException();
        } //End block
        {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.654 -0400", hash_original_method = "84B4F1338E9C8554FC089CA7254325E0", hash_generated_method = "45894C0EF48640DCAA1099EE781EB99B")
    @DSModeled(DSC.SAFE)
    public ScaleType getScaleType() {
        return (ScaleType)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mScaleType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.654 -0400", hash_original_method = "5B9FD9A0A164EA90D695E910523F6E96", hash_generated_method = "6DCA45033D3AB376F7423810119A1D28")
    @DSModeled(DSC.SAFE)
    public Matrix getImageMatrix() {
        return (Matrix)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mMatrix;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.654 -0400", hash_original_method = "A32A82AEE544A388BA62C8178AC7E88C", hash_generated_method = "0D7504A481301042022267846507533C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setImageMatrix(Matrix matrix) {
        dsTaint.addTaint(matrix.dsTaint);
        {
            boolean var43647054FCC5E2FEA67BA4DB2B5CFDEC_681900499 = (matrix != null && matrix.isIdentity());
            {
                matrix = null;
            } //End block
        } //End collapsed parenthetic
        {
            boolean var07BF5E6DF09B8E40E54FCB7189DEE131_845197669 = (matrix == null && !mMatrix.isIdentity() ||
                matrix != null && !mMatrix.equals(matrix));
            {
                mMatrix.set(matrix);
                configureBounds();
                invalidate();
            } //End block
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.654 -0400", hash_original_method = "16B1589372902AF87B2F0F65CBDC5B57", hash_generated_method = "038644DAA2AD7A44F3F5B6BA39CFF410")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
                boolean varF1920ADB7A324A214864F4BBBDD05F45_437958698 = (ContentResolver.SCHEME_ANDROID_RESOURCE.equals(scheme));
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
                    boolean varECE6BF2CA2A924F44A15A349FCEFEEC1_754272359 = (ContentResolver.SCHEME_CONTENT.equals(scheme)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.654 -0400", hash_original_method = "F00D7A8DB32B373F9AAF90A3CC19DF16", hash_generated_method = "1570B21118177FAB240AB1AD44B62399")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int[] onCreateDrawableState(int extraSpace) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(extraSpace);
        {
            int[] varEB7CD746CBB534A0BF67F4323334429E_1956859212 = (super.onCreateDrawableState(extraSpace));
        } //End block
        {
            int[] varB6313CC42B6FF045E4878C3B3E985625_699951108 = (mergeDrawableStates(
                    super.onCreateDrawableState(extraSpace + mState.length), mState));
        } //End block
        int[] retVal = new int[1];
        retVal[0] = dsTaint.getTaintInt();
        return retVal;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.655 -0400", hash_original_method = "ADE7139D7C0A9B2AE00EA96739AFBDE5", hash_generated_method = "225B8FE1245D904CC529311A108A9AEC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void updateDrawable(Drawable d) {
        dsTaint.addTaint(d.dsTaint);
        {
            mDrawable.setCallback(null);
            unscheduleDrawable(mDrawable);
        } //End block
        {
            d.setCallback(this);
            {
                boolean var732D4E5C808363BC9BF454DD27943961_1412696817 = (d.isStateful());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.655 -0400", hash_original_method = "E1DD34F979587974CF0EAF8DF3CFC3FF", hash_generated_method = "A55753560A78AA4E6639522D32B4D0FA")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.655 -0400", hash_original_method = "794DDCD2F1CC379DC73569DF9A81912A", hash_generated_method = "757E7EA00B76428F957F5DEAB245C086")
    private static Matrix.ScaleToFit scaleTypeToScaleToFit(ScaleType st) {
        return sS2FArray[st.nativeInt - 1];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.655 -0400", hash_original_method = "5D5C8E0C5B3B131983F43D2E85F23CCE", hash_generated_method = "5D1CE0ABB0A093CFFE6A0C46024E25C8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(heightMeasureSpec);
        dsTaint.addTaint(widthMeasureSpec);
        resolveUri();
        int w;
        int h;
        float desiredAspect;
        desiredAspect = 0.0f;
        boolean resizeWidth;
        resizeWidth = false;
        boolean resizeHeight;
        resizeHeight = false;
        final int widthSpecMode;
        widthSpecMode = MeasureSpec.getMode(widthMeasureSpec);
        final int heightSpecMode;
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
                    boolean var659D7277B9251B22E516EA6035BDC5A3_2071670853 = (Math.abs(actualAspect - desiredAspect) > 0.0000001);
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.656 -0400", hash_original_method = "6790E6B3204D72187344DF3593244181", hash_generated_method = "0EF50D4659960E4011E9C6784D4CD44E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int resolveAdjustedSize(int desiredSize, int maxSize,
                                   int measureSpec) {
        dsTaint.addTaint(measureSpec);
        dsTaint.addTaint(desiredSize);
        dsTaint.addTaint(maxSize);
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
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.656 -0400", hash_original_method = "7ED99727E4B1435AFDB83292B92819BD", hash_generated_method = "8DE0DEBA169266AE7362666E893FAF73")
    @DSModeled(DSC.SAFE)
    @Override
    protected boolean setFrame(int l, int t, int r, int b) {
        dsTaint.addTaint(t);
        dsTaint.addTaint(b);
        dsTaint.addTaint(r);
        dsTaint.addTaint(l);
        boolean changed;
        changed = super.setFrame(l, t, r, b);
        mHaveFrame = true;
        configureBounds();
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //boolean changed = super.setFrame(l, t, r, b);
        //mHaveFrame = true;
        //configureBounds();
        //return changed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.656 -0400", hash_original_method = "3A8E22D575255E0F3266968983CC3C02", hash_generated_method = "3888ED1F13293C17FCBAEE52BEB916CE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
                    boolean var807A3C6E5DF9AC9E8557F287A85C43B9_480051969 = (mMatrix.isIdentity());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.656 -0400", hash_original_method = "D78E25577A68DABE40154D5E4D97E50D", hash_generated_method = "CBA7CBB376455CF140A572545D66C038")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable d;
        d = mDrawable;
        {
            boolean var9E4512E9555DA1255DDDA9AE20837176_887843274 = (d != null && d.isStateful());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.657 -0400", hash_original_method = "355C7834E61DDE917A6F527556974749", hash_generated_method = "8F7C65222E842DBA7868765304947C5B")
    @DSModeled(DSC.SAFE)
    @Override
    protected void onDraw(Canvas canvas) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(canvas.dsTaint);
        super.onDraw(canvas);
        {
            mDrawable.draw(canvas);
        } //End block
        {
            int saveCount;
            saveCount = canvas.getSaveCount();
            canvas.save();
            {
                final int scrollX;
                scrollX = mScrollX;
                final int scrollY;
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.657 -0400", hash_original_method = "697E0DCA3A40ADA0E60547E8AD02CB08", hash_generated_method = "FF1EECB673E9D337216020770DDA49E4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    @ViewDebug.ExportedProperty(category = "layout")
    public int getBaseline() {
        {
            int var0FD144A91B49367E40CB3EFF8BA82D53_631024188 = (getMeasuredHeight());
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (mBaselineAlignBottom) {
            //return getMeasuredHeight();
        //} else {
            //return mBaseline;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.657 -0400", hash_original_method = "8108AC4FDDF644F63A2CB47972E74B33", hash_generated_method = "891F6D902D98F428760A01C558D2C6B4")
    @DSModeled(DSC.SAFE)
    public void setBaseline(int baseline) {
        dsTaint.addTaint(baseline);
        {
            requestLayout();
        } //End block
        // ---------- Original Method ----------
        //if (mBaseline != baseline) {
            //mBaseline = baseline;
            //requestLayout();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.657 -0400", hash_original_method = "ACC3D162C0B2FC40FF806607AF970BEE", hash_generated_method = "475D2E7DB705CA7D17E9647442F89A22")
    @DSModeled(DSC.SAFE)
    public void setBaselineAlignBottom(boolean aligned) {
        dsTaint.addTaint(aligned);
        {
            requestLayout();
        } //End block
        // ---------- Original Method ----------
        //if (mBaselineAlignBottom != aligned) {
            //mBaselineAlignBottom = aligned;
            //requestLayout();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.657 -0400", hash_original_method = "7D3365C5D6F47846F65EFD0480835D79", hash_generated_method = "17071F89740CDB440818686C72E71F5D")
    @DSModeled(DSC.SAFE)
    public boolean getBaselineAlignBottom() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mBaselineAlignBottom;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.657 -0400", hash_original_method = "F0522F608E5F96C5D99BDA1CF055B16B", hash_generated_method = "858E5431416BB9217CB31D73FF0C19DB")
    @DSModeled(DSC.SAFE)
    public final void setColorFilter(int color, PorterDuff.Mode mode) {
        dsTaint.addTaint(color);
        dsTaint.addTaint(mode.dsTaint);
        setColorFilter(new PorterDuffColorFilter(color, mode));
        // ---------- Original Method ----------
        //setColorFilter(new PorterDuffColorFilter(color, mode));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.657 -0400", hash_original_method = "50A13570451A3C69931555EF0FE8C15D", hash_generated_method = "CF6E7C5D81D0000A623F4CFB112283AB")
    @DSModeled(DSC.SAFE)
    @RemotableViewMethod
    public final void setColorFilter(int color) {
        dsTaint.addTaint(color);
        setColorFilter(color, PorterDuff.Mode.SRC_ATOP);
        // ---------- Original Method ----------
        //setColorFilter(color, PorterDuff.Mode.SRC_ATOP);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.657 -0400", hash_original_method = "B358CFD4AAFD748C624F742F21F12081", hash_generated_method = "D21DFD6FA2D25FBCE6F3CB562CF280F1")
    @DSModeled(DSC.SAFE)
    public final void clearColorFilter() {
        setColorFilter(null);
        // ---------- Original Method ----------
        //setColorFilter(null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.657 -0400", hash_original_method = "0E997722FEDD3E607A6B49B3558418D6", hash_generated_method = "27ED19DBD8876CB8C42DD6612BEB270E")
    @DSModeled(DSC.SAFE)
    public void setColorFilter(ColorFilter cf) {
        dsTaint.addTaint(cf.dsTaint);
        {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.657 -0400", hash_original_method = "F29539FC5DE82D33A1732D8CBDF1B3F0", hash_generated_method = "6998F994372715015E73FCAF753D04C7")
    @DSModeled(DSC.SAFE)
    @RemotableViewMethod
    public void setAlpha(int alpha) {
        dsTaint.addTaint(alpha);
        alpha &= 0xFF;
        {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.657 -0400", hash_original_method = "91840135D820437FBAEF19E5465CA144", hash_generated_method = "1F70CD2C7C9427C6307860110F7A00C6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.657 -0400", hash_original_method = "C6B07741C64FD260DDE5C02AC0455E05", hash_generated_method = "35A7D3A2842154FC596C066729A3EB6F")
    @DSModeled(DSC.SAFE)
    @RemotableViewMethod
    @Override
    public void setVisibility(int visibility) {
        dsTaint.addTaint(visibility);
        super.setVisibility(visibility);
        {
            mDrawable.setVisible(visibility == VISIBLE, false);
        } //End block
        // ---------- Original Method ----------
        //super.setVisibility(visibility);
        //if (mDrawable != null) {
            //mDrawable.setVisible(visibility == VISIBLE, false);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.658 -0400", hash_original_method = "3717E0990FC85EED7B1343A97507698D", hash_generated_method = "2622E2FC9BBEA8D7C89854C804BFD3D8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:07.658 -0400", hash_original_method = "66E6E711A91B2172E1C35BB591AC6445", hash_generated_method = "FDE46F7B1B736239174A814F5D8E1D98")
    @DSModeled(DSC.SAFE)
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

    
}


