package android.graphics.drawable;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.graphics.*;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import java.io.IOException;
import java.io.InputStream;

public class NinePatchDrawable extends Drawable {
    private NinePatchState mNinePatchState;
    private NinePatch mNinePatch;
    private Rect mPadding;
    private Paint mPaint;
    private boolean mMutated;
    private int mTargetDensity = DisplayMetrics.DENSITY_DEFAULT;
    private int mBitmapWidth;
    private int mBitmapHeight;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.520 -0400", hash_original_method = "273B833CD4C77CDA56AC8174D9DCFE29", hash_generated_method = "FBBCF1482AE910368A61C9233970F106")
    @DSModeled(DSC.SAFE)
     NinePatchDrawable() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.521 -0400", hash_original_method = "EA37E144790F39B12A14B8A0E7D897B0", hash_generated_method = "66C19EE06389586312D6AD683BF8094B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public NinePatchDrawable(Bitmap bitmap, byte[] chunk, Rect padding, String srcName) {
        this(new NinePatchState(new NinePatch(bitmap, chunk, srcName), padding), null);
        dsTaint.addTaint(chunk[0]);
        dsTaint.addTaint(bitmap.dsTaint);
        dsTaint.addTaint(padding.dsTaint);
        dsTaint.addTaint(srcName);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.521 -0400", hash_original_method = "929FEA5C59B893442F4AD64A16378707", hash_generated_method = "8FA3DF8AAA4B706CA653BF7D2915F5CB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public NinePatchDrawable(Resources res, Bitmap bitmap, byte[] chunk,
            Rect padding, String srcName) {
        this(new NinePatchState(new NinePatch(bitmap, chunk, srcName), padding), res);
        dsTaint.addTaint(res.dsTaint);
        dsTaint.addTaint(chunk[0]);
        dsTaint.addTaint(bitmap.dsTaint);
        dsTaint.addTaint(padding.dsTaint);
        dsTaint.addTaint(srcName);
        mNinePatchState.mTargetDensity = mTargetDensity;
        // ---------- Original Method ----------
        //mNinePatchState.mTargetDensity = mTargetDensity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.522 -0400", hash_original_method = "50B637C031C7A89AA164A5082D6A3A93", hash_generated_method = "DC6734B65B6797396A923CD120C9BD7F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public NinePatchDrawable(NinePatch patch) {
        this(new NinePatchState(patch, new Rect()), null);
        dsTaint.addTaint(patch.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.522 -0400", hash_original_method = "78318325CB229FE4515B0254D2B416A2", hash_generated_method = "E40A17D157549455F1CC69B573F1CBF7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public NinePatchDrawable(Resources res, NinePatch patch) {
        this(new NinePatchState(patch, new Rect()), res);
        dsTaint.addTaint(res.dsTaint);
        dsTaint.addTaint(patch.dsTaint);
        mNinePatchState.mTargetDensity = mTargetDensity;
        // ---------- Original Method ----------
        //mNinePatchState.mTargetDensity = mTargetDensity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.522 -0400", hash_original_method = "EB08CD45C7A208D135CB0BEAA7998119", hash_generated_method = "EA7DC16A6CBB5F4132318A55F9F06BB9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private NinePatchDrawable(NinePatchState state, Resources res) {
        dsTaint.addTaint(res.dsTaint);
        dsTaint.addTaint(state.dsTaint);
        setNinePatchState(state, res);
        // ---------- Original Method ----------
        //setNinePatchState(state, res);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.523 -0400", hash_original_method = "0EDC8E1D8196DBA7E3430735EBC66D6F", hash_generated_method = "F79F8B0FBCAB083EF283DAAB0FF597C8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setNinePatchState(NinePatchState state, Resources res) {
        dsTaint.addTaint(res.dsTaint);
        dsTaint.addTaint(state.dsTaint);
        mNinePatch = state.mNinePatch;
        mPadding = state.mPadding;
        mTargetDensity = res != null ? res.getDisplayMetrics().densityDpi
                : state.mTargetDensity;
        {
            setDither(state.mDither);
        } //End block
        {
            computeBitmapSize();
        } //End block
        // ---------- Original Method ----------
        //mNinePatchState = state;
        //mNinePatch = state.mNinePatch;
        //mPadding = state.mPadding;
        //mTargetDensity = res != null ? res.getDisplayMetrics().densityDpi
                //: state.mTargetDensity;
        //if (state.mDither != DEFAULT_DITHER) {
            //setDither(state.mDither);
        //}
        //if (mNinePatch != null) {
            //computeBitmapSize();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.523 -0400", hash_original_method = "82585E992AABF5984A06ED90552A1C77", hash_generated_method = "5AE2074DBD3336F28282B383F84002BF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setTargetDensity(Canvas canvas) {
        dsTaint.addTaint(canvas.dsTaint);
        setTargetDensity(canvas.getDensity());
        // ---------- Original Method ----------
        //setTargetDensity(canvas.getDensity());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.523 -0400", hash_original_method = "4AE49AE83EF2F62C9A584A758B5178F3", hash_generated_method = "CA201B9257141BB6206992605DA679FB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setTargetDensity(DisplayMetrics metrics) {
        dsTaint.addTaint(metrics.dsTaint);
        setTargetDensity(metrics.densityDpi);
        // ---------- Original Method ----------
        //setTargetDensity(metrics.densityDpi);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.524 -0400", hash_original_method = "F1F344BB6765FE54A2E40BB8E2AEB010", hash_generated_method = "20B5D07F7F243F1522323D12181445A5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setTargetDensity(int density) {
        dsTaint.addTaint(density);
        {
            mTargetDensity = density == 0 ? DisplayMetrics.DENSITY_DEFAULT : density;
            {
                computeBitmapSize();
            } //End block
            invalidateSelf();
        } //End block
        // ---------- Original Method ----------
        //if (density != mTargetDensity) {
            //mTargetDensity = density == 0 ? DisplayMetrics.DENSITY_DEFAULT : density;
            //if (mNinePatch != null) {
                //computeBitmapSize();
            //}
            //invalidateSelf();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.524 -0400", hash_original_method = "E8279E2F004E74E2D3A3C9AE5B1B6A96", hash_generated_method = "B0C73764766DE27F7D493674A555E255")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void computeBitmapSize() {
        int sdensity;
        sdensity = mNinePatch.getDensity();
        int tdensity;
        tdensity = mTargetDensity;
        {
            mBitmapWidth = mNinePatch.getWidth();
            mBitmapHeight = mNinePatch.getHeight();
        } //End block
        {
            mBitmapWidth = Bitmap.scaleFromDensity(mNinePatch.getWidth(),
                    sdensity, tdensity);
            mBitmapHeight = Bitmap.scaleFromDensity(mNinePatch.getHeight(),
                    sdensity, tdensity);
            {
                Rect dest;
                dest = mPadding;
                Rect src;
                src = mNinePatchState.mPadding;
                {
                    mPadding = dest = new Rect(src);
                } //End block
                dest.left = Bitmap.scaleFromDensity(src.left, sdensity, tdensity);
                dest.top = Bitmap.scaleFromDensity(src.top, sdensity, tdensity);
                dest.right = Bitmap.scaleFromDensity(src.right, sdensity, tdensity);
                dest.bottom = Bitmap.scaleFromDensity(src.bottom, sdensity, tdensity);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.525 -0400", hash_original_method = "D590BE7B225C8366E27B182C22714F49", hash_generated_method = "A4A112CB6B00610F3E6956C42FDC9E10")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void draw(Canvas canvas) {
        dsTaint.addTaint(canvas.dsTaint);
        mNinePatch.draw(canvas, getBounds(), mPaint);
        // ---------- Original Method ----------
        //mNinePatch.draw(canvas, getBounds(), mPaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.526 -0400", hash_original_method = "F3B5E1AA8DCA42FBC0209DF5DE34A528", hash_generated_method = "C9994844B45388363F5F7E03CEC74F1E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getChangingConfigurations() {
        int var7A9612B45A1F8CC4B627EDFD82A27BB0_642085898 = (super.getChangingConfigurations() | mNinePatchState.mChangingConfigurations);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return super.getChangingConfigurations() | mNinePatchState.mChangingConfigurations;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.527 -0400", hash_original_method = "6A7A0B10486EA74D6FDB7CE40BB96DCF", hash_generated_method = "529665C8AD88BE8D8A11B87CA7639B12")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean getPadding(Rect padding) {
        dsTaint.addTaint(padding.dsTaint);
        padding.set(mPadding);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //padding.set(mPadding);
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.528 -0400", hash_original_method = "DDA2062A293BD75777B2540266427F8E", hash_generated_method = "051BD25F7151994D81575DB4E73611B3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setAlpha(int alpha) {
        dsTaint.addTaint(alpha);
        getPaint().setAlpha(alpha);
        invalidateSelf();
        // ---------- Original Method ----------
        //if (mPaint == null && alpha == 0xFF) {
            //return;
        //}
        //getPaint().setAlpha(alpha);
        //invalidateSelf();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.528 -0400", hash_original_method = "D5833F804B1FB713A7DF2F016B869F27", hash_generated_method = "1922FF925BFF0811A7B8378E4CEB2ED4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setColorFilter(ColorFilter cf) {
        dsTaint.addTaint(cf.dsTaint);
        getPaint().setColorFilter(cf);
        invalidateSelf();
        // ---------- Original Method ----------
        //if (mPaint == null && cf == null) {
            //return;
        //}
        //getPaint().setColorFilter(cf);
        //invalidateSelf();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.529 -0400", hash_original_method = "CFE043442F57EFE9659FF8A6FEAF97CC", hash_generated_method = "FBB5BD675D63E36F363BEE95CE579BA7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setDither(boolean dither) {
        dsTaint.addTaint(dither);
        getPaint().setDither(dither);
        invalidateSelf();
        // ---------- Original Method ----------
        //if (mPaint == null && dither == DEFAULT_DITHER) {
            //return;
        //}
        //getPaint().setDither(dither);
        //invalidateSelf();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.529 -0400", hash_original_method = "49680E18787729BA4FD04D8979679DC0", hash_generated_method = "0BB0158E79E6218BC574F5688B25FE7A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setFilterBitmap(boolean filter) {
        dsTaint.addTaint(filter);
        getPaint().setFilterBitmap(filter);
        invalidateSelf();
        // ---------- Original Method ----------
        //getPaint().setFilterBitmap(filter);
        //invalidateSelf();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.530 -0400", hash_original_method = "14B4EEBEDACB44F7F53A884DE9C011A3", hash_generated_method = "2EE033DF46C9672215AD099F3672D479")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void inflate(Resources r, XmlPullParser parser, AttributeSet attrs) throws XmlPullParserException, IOException {
        dsTaint.addTaint(r.dsTaint);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(parser.dsTaint);
        super.inflate(r, parser, attrs);
        TypedArray a;
        a = r.obtainAttributes(attrs, com.android.internal.R.styleable.NinePatchDrawable);
        int id;
        id = a.getResourceId(com.android.internal.R.styleable.NinePatchDrawable_src, 0);
        {
            if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException(parser.getPositionDescription() +
                    ": <nine-patch> requires a valid src attribute");
        } //End block
        boolean dither;
        dither = a.getBoolean(
                com.android.internal.R.styleable.NinePatchDrawable_dither,
                DEFAULT_DITHER);
        BitmapFactory.Options options;
        options = new BitmapFactory.Options();
        {
            options.inDither = false;
        } //End block
        options.inScreenDensity = DisplayMetrics.DENSITY_DEVICE;
        Rect padding;
        padding = new Rect();
        Bitmap bitmap;
        bitmap = null;
        try 
        {
            TypedValue value;
            value = new TypedValue();
            InputStream is;
            is = r.openRawResource(id, value);
            bitmap = BitmapFactory.decodeResourceStream(r, value, is, padding, options);
            is.close();
        } //End block
        catch (IOException e)
        { }
        {
            if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException(parser.getPositionDescription() +
                    ": <nine-patch> requires a valid src attribute");
        } //End block
        {
            boolean varEE0C99B0E498FE80FA057D0ADB22AD18_1134397553 = (bitmap.getNinePatchChunk() == null);
            {
                if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException(parser.getPositionDescription() +
                    ": <nine-patch> requires a valid 9-patch source image");
            } //End block
        } //End collapsed parenthetic
        setNinePatchState(new NinePatchState(
                new NinePatch(bitmap, bitmap.getNinePatchChunk(), "XML 9-patch"),
                padding, dither), r);
        mNinePatchState.mTargetDensity = mTargetDensity;
        a.recycle();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.530 -0400", hash_original_method = "075C514CB6C74FC258CE8B3440B31BB9", hash_generated_method = "00EE17C7F4C292D2B7C6E72210CCAE7A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Paint getPaint() {
        {
            mPaint = new Paint();
            mPaint.setDither(DEFAULT_DITHER);
        } //End block
        return (Paint)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mPaint == null) {
            //mPaint = new Paint();
            //mPaint.setDither(DEFAULT_DITHER);
        //}
        //return mPaint;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.530 -0400", hash_original_method = "6DB114FB8E950C38C4587167EE2392DA", hash_generated_method = "5FF4CA940937A0DF3B8654CDD8C46AE8")
    @DSModeled(DSC.SAFE)
    @Override
    public int getIntrinsicWidth() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mBitmapWidth;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.530 -0400", hash_original_method = "391FEC77F059693D96A6B7B3AE926494", hash_generated_method = "290BB80DDDA870A8A4E130689F858B6F")
    @DSModeled(DSC.SAFE)
    @Override
    public int getIntrinsicHeight() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mBitmapHeight;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.531 -0400", hash_original_method = "F677AE1ECA1CBA7AB5A76B8BE368A72F", hash_generated_method = "5BD4759DCB66EFA31FDFFE856B6CCF24")
    @DSModeled(DSC.SAFE)
    @Override
    public int getMinimumWidth() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mBitmapWidth;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.531 -0400", hash_original_method = "0C368C2268B0130C3ACD75434C6C4889", hash_generated_method = "711430BD98C3744989CD7DAE94209036")
    @DSModeled(DSC.SAFE)
    @Override
    public int getMinimumHeight() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mBitmapHeight;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.531 -0400", hash_original_method = "B22FBB09C864D64632C83D9F48FAF25E", hash_generated_method = "29495E9ABC65ABBE3D8360705BC8EF8A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getOpacity() {
        {
            boolean varB6178F50962C98D5C92810A1A86D2E76_445589019 = (mNinePatch.hasAlpha() || (mPaint != null && mPaint.getAlpha() < 255));
        } //End flattened ternary
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mNinePatch.hasAlpha() || (mPaint != null && mPaint.getAlpha() < 255) ?
                //PixelFormat.TRANSLUCENT : PixelFormat.OPAQUE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.532 -0400", hash_original_method = "015B10918498A51630C2035B52469361", hash_generated_method = "EE4625EE65D0E52FA585C8A935C91DD4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Region getTransparentRegion() {
        Region var3A632A9F55CA2073D4B58F86DF391FFB_108644287 = (mNinePatch.getTransparentRegion(getBounds()));
        return (Region)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mNinePatch.getTransparentRegion(getBounds());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.532 -0400", hash_original_method = "4F3C3B017CDA56F4212D4719D10B45C1", hash_generated_method = "34B5E1342D8CF19060BE34527B34AF92")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ConstantState getConstantState() {
        mNinePatchState.mChangingConfigurations = getChangingConfigurations();
        return (ConstantState)dsTaint.getTaint();
        // ---------- Original Method ----------
        //mNinePatchState.mChangingConfigurations = getChangingConfigurations();
        //return mNinePatchState;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.532 -0400", hash_original_method = "EEABBB7B802F633C5D2C005A94C5FF68", hash_generated_method = "9574C8A5181CE4584F69F3EBAA0D10C9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Drawable mutate() {
        {
            boolean varC94B19053599294E7944C8C841976773_203882843 = (!mMutated && super.mutate() == this);
            {
                mNinePatchState = new NinePatchState(mNinePatchState);
                mNinePatch = mNinePatchState.mNinePatch;
                mMutated = true;
            } //End block
        } //End collapsed parenthetic
        return (Drawable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (!mMutated && super.mutate() == this) {
            //mNinePatchState = new NinePatchState(mNinePatchState);
            //mNinePatch = mNinePatchState.mNinePatch;
            //mMutated = true;
        //}
        //return this;
    }

    
    final static class NinePatchState extends ConstantState {
        NinePatch mNinePatch;
        Rect mPadding;
        boolean mDither;
        int mChangingConfigurations;
        int mTargetDensity = DisplayMetrics.DENSITY_DEFAULT;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.533 -0400", hash_original_method = "CA3208FB1D6439C7B894EDBF6EC3D9DE", hash_generated_method = "007F44F7A44716F2FC24A59D04112DB3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         NinePatchState(NinePatch ninePatch, Rect padding) {
            this(ninePatch, padding, DEFAULT_DITHER);
            dsTaint.addTaint(padding.dsTaint);
            dsTaint.addTaint(ninePatch.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.533 -0400", hash_original_method = "88C0915540B2FF11645913E277979DA7", hash_generated_method = "708BF58A5CE322054F916C880BD9CBA1")
        @DSModeled(DSC.SAFE)
         NinePatchState(NinePatch ninePatch, Rect rect, boolean dither) {
            dsTaint.addTaint(dither);
            dsTaint.addTaint(rect.dsTaint);
            dsTaint.addTaint(ninePatch.dsTaint);
            // ---------- Original Method ----------
            //mNinePatch = ninePatch;
            //mPadding = rect;
            //mDither = dither;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.533 -0400", hash_original_method = "05814CB491C8C0B2C0FEF50DD9B15E6B", hash_generated_method = "81B3E2C0B3750656368154C9247CD671")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         NinePatchState(NinePatchState state) {
            dsTaint.addTaint(state.dsTaint);
            mNinePatch = new NinePatch(state.mNinePatch);
            mPadding = state.mPadding;
            mDither = state.mDither;
            mChangingConfigurations = state.mChangingConfigurations;
            mTargetDensity = state.mTargetDensity;
            // ---------- Original Method ----------
            //mNinePatch = new NinePatch(state.mNinePatch);
            //mPadding = state.mPadding;
            //mDither = state.mDither;
            //mChangingConfigurations = state.mChangingConfigurations;
            //mTargetDensity = state.mTargetDensity;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.533 -0400", hash_original_method = "D02B1AE1E59D491553AECB8C917A9A24", hash_generated_method = "E4701606FE4B923BEA6C1FD04D75C990")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Drawable newDrawable() {
            Drawable var38720855BBC0C11A46251AB45341F823_598967344 = (new NinePatchDrawable(this, null));
            return (Drawable)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new NinePatchDrawable(this, null);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.534 -0400", hash_original_method = "A66FA8882A8A4D3CAB4071390F4B61B2", hash_generated_method = "02FE922525856569F62B2EBCA769BE1E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Drawable newDrawable(Resources res) {
            dsTaint.addTaint(res.dsTaint);
            Drawable var0EE1E7295C118EC25B716772CED0139C_1853567376 = (new NinePatchDrawable(this, res));
            return (Drawable)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new NinePatchDrawable(this, res);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.534 -0400", hash_original_method = "9E7D7C67EAC365FF19BD4971762612A5", hash_generated_method = "36011B0CFA5B1C48E438EB66BB35159E")
        @DSModeled(DSC.SAFE)
        @Override
        public int getChangingConfigurations() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return mChangingConfigurations;
        }

        
    }


    
    private static final boolean DEFAULT_DITHER = true;
}

