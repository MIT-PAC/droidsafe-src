package android.graphics.drawable;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.InputStream;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.Region;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;





public class NinePatchDrawable extends Drawable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.416 -0500", hash_original_field = "338D1FBCBD429EAFEF0B800F32A31DDD", hash_generated_field = "17A3499D3AE1DB6784657D5E8AE3951F")

    private static final boolean DEFAULT_DITHER = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.418 -0500", hash_original_field = "A83E67723701C4C1E27B79CA98C37680", hash_generated_field = "6C68B5548B044A9A7BC44A7FEBD76DE2")

    private NinePatchState mNinePatchState;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.420 -0500", hash_original_field = "C0E1C53C4D030D6E494BA74829B1D5B8", hash_generated_field = "70B2B86AA0FF0A8CB74F2B53CA0A60ED")

    private NinePatch mNinePatch;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.422 -0500", hash_original_field = "A053A94BBF9972B52A80E2FC510022E8", hash_generated_field = "017017AA9AF1862D01EDDEC3A7AB7775")

    private Rect mPadding;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.424 -0500", hash_original_field = "0344A2D91EF1BCE652EE63EFC12EEAC9", hash_generated_field = "75BCEEBE83B26919B33E8EA8B289919E")

    private Paint mPaint;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.426 -0500", hash_original_field = "B15C308E96D0EEBD27CFE369FA349C15", hash_generated_field = "5CA5A1EF3CAA45117BCACBC34EF05952")

    private boolean mMutated;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.428 -0500", hash_original_field = "80AC771C22191FC983474A6CF039F227", hash_generated_field = "1860FF555EBFEAEB762501C3F409202A")


    private int mTargetDensity = DisplayMetrics.DENSITY_DEFAULT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.430 -0500", hash_original_field = "4C687A097BDE0B0C2EC2AE8D7A5DB502", hash_generated_field = "568275F41A7E61D900F9F414E799383D")

    private int mBitmapWidth;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.432 -0500", hash_original_field = "02D7E7DAA0BBE312A2B33B0AA711DE83", hash_generated_field = "2EAFFA48F02C3807ED7A1FED6D773758")

    private int mBitmapHeight;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.434 -0500", hash_original_method = "273B833CD4C77CDA56AC8174D9DCFE29", hash_generated_method = "273B833CD4C77CDA56AC8174D9DCFE29")
    
NinePatchDrawable() {
    }

    /**
     * Create drawable from raw nine-patch data, not dealing with density.
     * @deprecated Use {@link #NinePatchDrawable(Resources, Bitmap, byte[], Rect, String)}
     * to ensure that the drawable has correctly set its target density.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.437 -0500", hash_original_method = "EA37E144790F39B12A14B8A0E7D897B0", hash_generated_method = "73377B88F34C63C9BB19DF8D05F68AF6")
    
@Deprecated
    public NinePatchDrawable(Bitmap bitmap, byte[] chunk, Rect padding, String srcName) {
        this(new NinePatchState(new NinePatch(bitmap, chunk, srcName), padding), null);
    }
    
    /**
     * Create drawable from raw nine-patch data, setting initial target density
     * based on the display metrics of the resources.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.440 -0500", hash_original_method = "929FEA5C59B893442F4AD64A16378707", hash_generated_method = "22943E4CDBF792E0F208BA9E8C0BB83A")
    
public NinePatchDrawable(Resources res, Bitmap bitmap, byte[] chunk,
            Rect padding, String srcName) {
        this(new NinePatchState(new NinePatch(bitmap, chunk, srcName), padding), res);
        mNinePatchState.mTargetDensity = mTargetDensity;
    }
    
    /**
     * Create drawable from existing nine-patch, not dealing with density.
     * @deprecated Use {@link #NinePatchDrawable(Resources, NinePatch)}
     * to ensure that the drawable has correctly set its target density.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.443 -0500", hash_original_method = "50B637C031C7A89AA164A5082D6A3A93", hash_generated_method = "B2AEC5AD9697F2A0503EB686601715D6")
    
@Deprecated
    public NinePatchDrawable(NinePatch patch) {
        this(new NinePatchState(patch, new Rect()), null);
    }

    /**
     * Create drawable from existing nine-patch, setting initial target density
     * based on the display metrics of the resources.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.446 -0500", hash_original_method = "78318325CB229FE4515B0254D2B416A2", hash_generated_method = "23EAC72E71441F799B6886655F812A45")
    
public NinePatchDrawable(Resources res, NinePatch patch) {
        this(new NinePatchState(patch, new Rect()), res);
        mNinePatchState.mTargetDensity = mTargetDensity;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.529 -0500", hash_original_method = "EB08CD45C7A208D135CB0BEAA7998119", hash_generated_method = "C88440FDB36794F8F727E1F3B01097B5")
    
private NinePatchDrawable(NinePatchState state, Resources res) {
        setNinePatchState(state, res);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.448 -0500", hash_original_method = "0EDC8E1D8196DBA7E3430735EBC66D6F", hash_generated_method = "0C8B6EDB4F18A083A914AD67F09D1145")
    
private void setNinePatchState(NinePatchState state, Resources res) {
        mNinePatchState = state;
        mNinePatch = state.mNinePatch;
        mPadding = state.mPadding;
        mTargetDensity = res != null ? res.getDisplayMetrics().densityDpi
                : state.mTargetDensity;
        //noinspection PointlessBooleanExpression
        if (state.mDither != DEFAULT_DITHER) {
            // avoid calling the setter unless we need to, since it does a
            // lazy allocation of a paint
            setDither(state.mDither);
        }
        if (mNinePatch != null) {
            computeBitmapSize();
        }
    }

    /**
     * Set the density scale at which this drawable will be rendered. This
     * method assumes the drawable will be rendered at the same density as the
     * specified canvas.
     *
     * @param canvas The Canvas from which the density scale must be obtained.
     *
     * @see android.graphics.Bitmap#setDensity(int)
     * @see android.graphics.Bitmap#getDensity()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.450 -0500", hash_original_method = "82585E992AABF5984A06ED90552A1C77", hash_generated_method = "61CFDB38788DB3DF61DD296AC5E20393")
    
public void setTargetDensity(Canvas canvas) {
        setTargetDensity(canvas.getDensity());
    }

    /**
     * Set the density scale at which this drawable will be rendered.
     *
     * @param metrics The DisplayMetrics indicating the density scale for this drawable.
     *
     * @see android.graphics.Bitmap#setDensity(int)
     * @see android.graphics.Bitmap#getDensity()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.453 -0500", hash_original_method = "4AE49AE83EF2F62C9A584A758B5178F3", hash_generated_method = "5DB2A771EE175C3701864DA1F5B543BF")
    
public void setTargetDensity(DisplayMetrics metrics) {
        setTargetDensity(metrics.densityDpi);
    }

    /**
     * Set the density at which this drawable will be rendered.
     *
     * @param density The density scale for this drawable.
     *
     * @see android.graphics.Bitmap#setDensity(int)
     * @see android.graphics.Bitmap#getDensity()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.455 -0500", hash_original_method = "F1F344BB6765FE54A2E40BB8E2AEB010", hash_generated_method = "858AB15E6B3A21BD24C0AD1BAC621F25")
    
public void setTargetDensity(int density) {
        if (density != mTargetDensity) {
            mTargetDensity = density == 0 ? DisplayMetrics.DENSITY_DEFAULT : density;
            if (mNinePatch != null) {
                computeBitmapSize();
            }
            invalidateSelf();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.457 -0500", hash_original_method = "E8279E2F004E74E2D3A3C9AE5B1B6A96", hash_generated_method = "FBF357EF39CF86BD2EA1024B918A2DAC")
    
private void computeBitmapSize() {
        final int sdensity = mNinePatch.getDensity();
        final int tdensity = mTargetDensity;
        if (sdensity == tdensity) {
            mBitmapWidth = mNinePatch.getWidth();
            mBitmapHeight = mNinePatch.getHeight();
        } else {
            mBitmapWidth = Bitmap.scaleFromDensity(mNinePatch.getWidth(),
                    sdensity, tdensity);
            mBitmapHeight = Bitmap.scaleFromDensity(mNinePatch.getHeight(),
                    sdensity, tdensity);
            if (mNinePatchState.mPadding != null && mPadding != null) {
                Rect dest = mPadding;
                Rect src = mNinePatchState.mPadding;
                if (dest == src) {
                    mPadding = dest = new Rect(src);
                }
                dest.left = Bitmap.scaleFromDensity(src.left, sdensity, tdensity);
                dest.top = Bitmap.scaleFromDensity(src.top, sdensity, tdensity);
                dest.right = Bitmap.scaleFromDensity(src.right, sdensity, tdensity);
                dest.bottom = Bitmap.scaleFromDensity(src.bottom, sdensity, tdensity);
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.460 -0500", hash_original_method = "D590BE7B225C8366E27B182C22714F49", hash_generated_method = "C8AD40ACACCB63A9A23D88384D7CED9B")
    
@Override
    public void draw(Canvas canvas) {
        mNinePatch.draw(canvas, getBounds(), mPaint);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.462 -0500", hash_original_method = "F3B5E1AA8DCA42FBC0209DF5DE34A528", hash_generated_method = "820FEF23DD9AF5206EFEB9F420EC84B9")
    
@Override
    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | mNinePatchState.mChangingConfigurations;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.464 -0500", hash_original_method = "6A7A0B10486EA74D6FDB7CE40BB96DCF", hash_generated_method = "11F4CC9806F6328B92AA9DC802E41BE4")
    
@Override
    public boolean getPadding(Rect padding) {
        padding.set(mPadding);
        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.467 -0500", hash_original_method = "DDA2062A293BD75777B2540266427F8E", hash_generated_method = "304F8A5C1600DCBD8E288A0C143EEE23")
    
@Override
    public void setAlpha(int alpha) {
        if (mPaint == null && alpha == 0xFF) {
            // Fast common case -- leave at normal alpha.
            return;
        }
        getPaint().setAlpha(alpha);
        invalidateSelf();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.469 -0500", hash_original_method = "D5833F804B1FB713A7DF2F016B869F27", hash_generated_method = "4C3398F7DECFA1CCA5537AB3423663CA")
    
@Override
    public void setColorFilter(ColorFilter cf) {
        if (mPaint == null && cf == null) {
            // Fast common case -- leave at no color filter.
            return;
        }
        getPaint().setColorFilter(cf);
        invalidateSelf();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.471 -0500", hash_original_method = "CFE043442F57EFE9659FF8A6FEAF97CC", hash_generated_method = "5B33D46B2087D5819378F713C42245C1")
    
@Override
    public void setDither(boolean dither) {
        if (mPaint == null && dither == DEFAULT_DITHER) {
            // Fast common case -- leave at default dither.
            return;
        }
        getPaint().setDither(dither);
        invalidateSelf();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.473 -0500", hash_original_method = "49680E18787729BA4FD04D8979679DC0", hash_generated_method = "469E9828616F02FFA321DFA7F4094E8F")
    
@Override
    public void setFilterBitmap(boolean filter) {
        getPaint().setFilterBitmap(filter);
        invalidateSelf();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.476 -0500", hash_original_method = "14B4EEBEDACB44F7F53A884DE9C011A3", hash_generated_method = "72522F40C968FD97CA629BA890B71DB0")
    
@Override
    public void inflate(Resources r, XmlPullParser parser, AttributeSet attrs)
            throws XmlPullParserException, IOException {
        super.inflate(r, parser, attrs);

        TypedArray a = r.obtainAttributes(attrs, com.android.internal.R.styleable.NinePatchDrawable);

        final int id = a.getResourceId(com.android.internal.R.styleable.NinePatchDrawable_src, 0);
        if (id == 0) {
            throw new XmlPullParserException(parser.getPositionDescription() +
                    ": <nine-patch> requires a valid src attribute");
        }

        final boolean dither = a.getBoolean(
                com.android.internal.R.styleable.NinePatchDrawable_dither,
                DEFAULT_DITHER);
        final BitmapFactory.Options options = new BitmapFactory.Options();
        if (dither) {
            options.inDither = false;
        }
        options.inScreenDensity = DisplayMetrics.DENSITY_DEVICE;

        final Rect padding = new Rect();        
        Bitmap bitmap = null;

        try {
            final TypedValue value = new TypedValue();
            final InputStream is = r.openRawResource(id, value);

            bitmap = BitmapFactory.decodeResourceStream(r, value, is, padding, options);

            is.close();
        } catch (IOException e) {
            // Ignore
        }

        if (bitmap == null) {
            throw new XmlPullParserException(parser.getPositionDescription() +
                    ": <nine-patch> requires a valid src attribute");
        } else if (bitmap.getNinePatchChunk() == null) {
            throw new XmlPullParserException(parser.getPositionDescription() +
                    ": <nine-patch> requires a valid 9-patch source image");
        }

        setNinePatchState(new NinePatchState(
                new NinePatch(bitmap, bitmap.getNinePatchChunk(), "XML 9-patch"),
                padding, dither), r);
        mNinePatchState.mTargetDensity = mTargetDensity;

        a.recycle();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.478 -0500", hash_original_method = "075C514CB6C74FC258CE8B3440B31BB9", hash_generated_method = "8DB18E39C4FDB6B84FF1968236215A69")
    
public Paint getPaint() {
        if (mPaint == null) {
            mPaint = new Paint();
            mPaint.setDither(DEFAULT_DITHER);
        }
        return mPaint;
    }

    /**
     * Retrieves the width of the source .png file (before resizing).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.482 -0500", hash_original_method = "6DB114FB8E950C38C4587167EE2392DA", hash_generated_method = "21AB0A052F6EA6AC14C0E8AE68C8FF19")
    
@Override
    public int getIntrinsicWidth() {
        return mBitmapWidth;
    }

    /**
     * Retrieves the height of the source .png file (before resizing).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.484 -0500", hash_original_method = "391FEC77F059693D96A6B7B3AE926494", hash_generated_method = "4C6E95AD1C54FB0FB2042DE89349F724")
    
@Override
    public int getIntrinsicHeight() {
        return mBitmapHeight;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.486 -0500", hash_original_method = "F677AE1ECA1CBA7AB5A76B8BE368A72F", hash_generated_method = "6D0F8344968A9B3DC34906DAEE0028B6")
    
@Override
    public int getMinimumWidth() {
        return mBitmapWidth;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.488 -0500", hash_original_method = "0C368C2268B0130C3ACD75434C6C4889", hash_generated_method = "EFB08363CF0F22C2547E118B51A588FD")
    
@Override
    public int getMinimumHeight() {
        return mBitmapHeight;
    }

    /**
     * Returns a {@link android.graphics.PixelFormat graphics.PixelFormat}
     * value of OPAQUE or TRANSLUCENT.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.491 -0500", hash_original_method = "B22FBB09C864D64632C83D9F48FAF25E", hash_generated_method = "26A019198189533DB68C958BCD194B3E")
    
@Override
    public int getOpacity() {
        return mNinePatch.hasAlpha() || (mPaint != null && mPaint.getAlpha() < 255) ?
                PixelFormat.TRANSLUCENT : PixelFormat.OPAQUE;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.493 -0500", hash_original_method = "015B10918498A51630C2035B52469361", hash_generated_method = "640199D0185C3012747587975300B093")
    
@Override
    public Region getTransparentRegion() {
        return mNinePatch.getTransparentRegion(getBounds());
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.495 -0500", hash_original_method = "4F3C3B017CDA56F4212D4719D10B45C1", hash_generated_method = "6618F5A17DC86C374E914E9C8B20F0B8")
    
@Override
    public ConstantState getConstantState() {
        mNinePatchState.mChangingConfigurations = getChangingConfigurations();
        return mNinePatchState;
    }

    
    final static class NinePatchState extends ConstantState {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.501 -0500", hash_original_field = "C0E1C53C4D030D6E494BA74829B1D5B8", hash_generated_field = "C0E1C53C4D030D6E494BA74829B1D5B8")

         NinePatch mNinePatch;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.503 -0500", hash_original_field = "A053A94BBF9972B52A80E2FC510022E8", hash_generated_field = "A053A94BBF9972B52A80E2FC510022E8")

         Rect mPadding;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.505 -0500", hash_original_field = "28ABDDC6F40109F392846C3ED0C6A12A", hash_generated_field = "28ABDDC6F40109F392846C3ED0C6A12A")

         boolean mDither;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.507 -0500", hash_original_field = "9BFAF00848476277D36D9BA586984BA7", hash_generated_field = "9BFAF00848476277D36D9BA586984BA7")

        int mChangingConfigurations;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.509 -0500", hash_original_field = "80AC771C22191FC983474A6CF039F227", hash_generated_field = "80AC771C22191FC983474A6CF039F227")

        int mTargetDensity = DisplayMetrics.DENSITY_DEFAULT;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.513 -0500", hash_original_method = "CA3208FB1D6439C7B894EDBF6EC3D9DE", hash_generated_method = "CA3208FB1D6439C7B894EDBF6EC3D9DE")
        
NinePatchState(NinePatch ninePatch, Rect padding) {
            this(ninePatch, padding, DEFAULT_DITHER);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.515 -0500", hash_original_method = "88C0915540B2FF11645913E277979DA7", hash_generated_method = "88C0915540B2FF11645913E277979DA7")
        
NinePatchState(NinePatch ninePatch, Rect rect, boolean dither) {
            mNinePatch = ninePatch;
            mPadding = rect;
            mDither = dither;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.518 -0500", hash_original_method = "05814CB491C8C0B2C0FEF50DD9B15E6B", hash_generated_method = "7B1CAF446782E30E91AF8DC907AEC5E1")
        
NinePatchState(NinePatchState state) {
            mNinePatch = new NinePatch(state.mNinePatch);
            // Note we don't copy the padding because it is immutable.
            mPadding = state.mPadding;
            mDither = state.mDither;
            mChangingConfigurations = state.mChangingConfigurations;
            mTargetDensity = state.mTargetDensity;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.520 -0500", hash_original_method = "D02B1AE1E59D491553AECB8C917A9A24", hash_generated_method = "6AE2B898B8ED93492B69CB0E6D0DF509")
        
@Override
        public Drawable newDrawable() {
            return new NinePatchDrawable(this, null);
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.522 -0500", hash_original_method = "A66FA8882A8A4D3CAB4071390F4B61B2", hash_generated_method = "91BD28C2AE7958B4E058D2467EFFC2F8")
        
@Override
        public Drawable newDrawable(Resources res) {
            return new NinePatchDrawable(this, res);
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.524 -0500", hash_original_method = "9E7D7C67EAC365FF19BD4971762612A5", hash_generated_method = "3AB30668ED270F2EDF2E0129C706FE4D")
        
@Override
        public int getChangingConfigurations() {
            return mChangingConfigurations;
        }

        
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:11.498 -0500", hash_original_method = "EEABBB7B802F633C5D2C005A94C5FF68", hash_generated_method = "35C014D185CFAE6CD03862422FA4378D")
    
@Override
    public Drawable mutate() {
        if (!mMutated && super.mutate() == this) {
            mNinePatchState = new NinePatchState(mNinePatchState);
            mNinePatch = mNinePatchState.mNinePatch;
            mMutated = true;
        }
        return this;
    }
}

