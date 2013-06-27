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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.425 -0400", hash_original_field = "80A04E56058AB398069773FAD8CBA742", hash_generated_field = "6C68B5548B044A9A7BC44A7FEBD76DE2")

    private NinePatchState mNinePatchState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.425 -0400", hash_original_field = "11340C2D1AC0FCA9696006576602F263", hash_generated_field = "70B2B86AA0FF0A8CB74F2B53CA0A60ED")

    private NinePatch mNinePatch;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.425 -0400", hash_original_field = "9AC2544B5F9B8F60AA16656C94B57A8E", hash_generated_field = "017017AA9AF1862D01EDDEC3A7AB7775")

    private Rect mPadding;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.425 -0400", hash_original_field = "78E27F80AC0100441F897783EFA42851", hash_generated_field = "75BCEEBE83B26919B33E8EA8B289919E")

    private Paint mPaint;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.425 -0400", hash_original_field = "9FB80C30383848C8D006680B5F3BDAF9", hash_generated_field = "5CA5A1EF3CAA45117BCACBC34EF05952")

    private boolean mMutated;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.425 -0400", hash_original_field = "C98BC9AD629AD94FF2237799C3746D10", hash_generated_field = "1860FF555EBFEAEB762501C3F409202A")

    private int mTargetDensity = DisplayMetrics.DENSITY_DEFAULT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.425 -0400", hash_original_field = "DE6A0ABB3CA1313B4F7BDFF407B4A18B", hash_generated_field = "568275F41A7E61D900F9F414E799383D")

    private int mBitmapWidth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.425 -0400", hash_original_field = "EE573FC7FF36074270F8BF43556DFB4C", hash_generated_field = "2EAFFA48F02C3807ED7A1FED6D773758")

    private int mBitmapHeight;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.426 -0400", hash_original_method = "273B833CD4C77CDA56AC8174D9DCFE29", hash_generated_method = "FBBCF1482AE910368A61C9233970F106")
      NinePatchDrawable() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.427 -0400", hash_original_method = "EA37E144790F39B12A14B8A0E7D897B0", hash_generated_method = "A2986C5AC085DD3D2F5BFFD7B289A14B")
    @Deprecated
    public  NinePatchDrawable(Bitmap bitmap, byte[] chunk, Rect padding, String srcName) {
        this(new NinePatchState(new NinePatch(bitmap, chunk, srcName), padding), null);
        addTaint(bitmap.getTaint());
        addTaint(chunk[0]);
        addTaint(padding.getTaint());
        addTaint(srcName.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.440 -0400", hash_original_method = "929FEA5C59B893442F4AD64A16378707", hash_generated_method = "69A9FDC8D8A8AB0BF6E5AC6888322918")
    public  NinePatchDrawable(Resources res, Bitmap bitmap, byte[] chunk,
            Rect padding, String srcName) {
        this(new NinePatchState(new NinePatch(bitmap, chunk, srcName), padding), res);
        mNinePatchState.mTargetDensity = mTargetDensity;
        addTaint(res.getTaint());
        addTaint(bitmap.getTaint());
        addTaint(chunk[0]);
        addTaint(padding.getTaint());
        addTaint(srcName.getTaint());
        // ---------- Original Method ----------
        //mNinePatchState.mTargetDensity = mTargetDensity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.441 -0400", hash_original_method = "50B637C031C7A89AA164A5082D6A3A93", hash_generated_method = "ADF5474A5E2E0C922D423BE285EC1969")
    @Deprecated
    public  NinePatchDrawable(NinePatch patch) {
        this(new NinePatchState(patch, new Rect()), null);
        addTaint(patch.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.441 -0400", hash_original_method = "78318325CB229FE4515B0254D2B416A2", hash_generated_method = "F3C9B7D5023AE47D414C412D5228939D")
    public  NinePatchDrawable(Resources res, NinePatch patch) {
        this(new NinePatchState(patch, new Rect()), res);
        mNinePatchState.mTargetDensity = mTargetDensity;
        addTaint(res.getTaint());
        addTaint(patch.getTaint());
        // ---------- Original Method ----------
        //mNinePatchState.mTargetDensity = mTargetDensity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.442 -0400", hash_original_method = "EB08CD45C7A208D135CB0BEAA7998119", hash_generated_method = "558AD6FEB97F89D3FA697CEAF05F2282")
    private  NinePatchDrawable(NinePatchState state, Resources res) {
        setNinePatchState(state, res);
        addTaint(state.getTaint());
        addTaint(res.getTaint());
        // ---------- Original Method ----------
        //setNinePatchState(state, res);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.468 -0400", hash_original_method = "0EDC8E1D8196DBA7E3430735EBC66D6F", hash_generated_method = "8F791408CB37F5AE3773ACC7B1D18147")
    private void setNinePatchState(NinePatchState state, Resources res) {
        mNinePatchState = state;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.495 -0400", hash_original_method = "82585E992AABF5984A06ED90552A1C77", hash_generated_method = "215297D0233ECB14FB787AB40CF9D26A")
    public void setTargetDensity(Canvas canvas) {
        setTargetDensity(canvas.getDensity());
        addTaint(canvas.getTaint());
        // ---------- Original Method ----------
        //setTargetDensity(canvas.getDensity());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.511 -0400", hash_original_method = "4AE49AE83EF2F62C9A584A758B5178F3", hash_generated_method = "960E9F99A08076327B89289C4AB924D5")
    public void setTargetDensity(DisplayMetrics metrics) {
        setTargetDensity(metrics.densityDpi);
        addTaint(metrics.getTaint());
        // ---------- Original Method ----------
        //setTargetDensity(metrics.densityDpi);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.512 -0400", hash_original_method = "F1F344BB6765FE54A2E40BB8E2AEB010", hash_generated_method = "E06FAF201BD22143A505D4007008745A")
    public void setTargetDensity(int density) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.527 -0400", hash_original_method = "E8279E2F004E74E2D3A3C9AE5B1B6A96", hash_generated_method = "B0C73764766DE27F7D493674A555E255")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.527 -0400", hash_original_method = "D590BE7B225C8366E27B182C22714F49", hash_generated_method = "D06A8558C3944B97B37571E8D942A3E7")
    @Override
    public void draw(Canvas canvas) {
        mNinePatch.draw(canvas, getBounds(), mPaint);
        addTaint(canvas.getTaint());
        // ---------- Original Method ----------
        //mNinePatch.draw(canvas, getBounds(), mPaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.528 -0400", hash_original_method = "F3B5E1AA8DCA42FBC0209DF5DE34A528", hash_generated_method = "13E75B38E4A98129CAFA0D832B11D23A")
    @Override
    public int getChangingConfigurations() {
        int var7A9612B45A1F8CC4B627EDFD82A27BB0_842361694 = (super.getChangingConfigurations() | mNinePatchState.mChangingConfigurations);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_733179030 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_733179030;
        // ---------- Original Method ----------
        //return super.getChangingConfigurations() | mNinePatchState.mChangingConfigurations;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.528 -0400", hash_original_method = "6A7A0B10486EA74D6FDB7CE40BB96DCF", hash_generated_method = "36C5D6BF45F438F4B2543157605FFD1F")
    @Override
    public boolean getPadding(Rect padding) {
        padding.set(mPadding);
        addTaint(padding.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_813160170 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_813160170;
        // ---------- Original Method ----------
        //padding.set(mPadding);
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.540 -0400", hash_original_method = "DDA2062A293BD75777B2540266427F8E", hash_generated_method = "62C420A9E1F42CD11BCBA0B97C96F8F8")
    @Override
    public void setAlpha(int alpha) {
        getPaint().setAlpha(alpha);
        invalidateSelf();
        addTaint(alpha);
        // ---------- Original Method ----------
        //if (mPaint == null && alpha == 0xFF) {
            //return;
        //}
        //getPaint().setAlpha(alpha);
        //invalidateSelf();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.541 -0400", hash_original_method = "D5833F804B1FB713A7DF2F016B869F27", hash_generated_method = "FA3CB89224B1E17F606DE7D5B7A19911")
    @Override
    public void setColorFilter(ColorFilter cf) {
        getPaint().setColorFilter(cf);
        invalidateSelf();
        addTaint(cf.getTaint());
        // ---------- Original Method ----------
        //if (mPaint == null && cf == null) {
            //return;
        //}
        //getPaint().setColorFilter(cf);
        //invalidateSelf();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.547 -0400", hash_original_method = "CFE043442F57EFE9659FF8A6FEAF97CC", hash_generated_method = "05D68A3AC4371A6598CC3A81BEEA8689")
    @Override
    public void setDither(boolean dither) {
        getPaint().setDither(dither);
        invalidateSelf();
        addTaint(dither);
        // ---------- Original Method ----------
        //if (mPaint == null && dither == DEFAULT_DITHER) {
            //return;
        //}
        //getPaint().setDither(dither);
        //invalidateSelf();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.548 -0400", hash_original_method = "49680E18787729BA4FD04D8979679DC0", hash_generated_method = "D30BA4BD8FCA25916D1D13F5E11A2EF8")
    @Override
    public void setFilterBitmap(boolean filter) {
        getPaint().setFilterBitmap(filter);
        invalidateSelf();
        addTaint(filter);
        // ---------- Original Method ----------
        //getPaint().setFilterBitmap(filter);
        //invalidateSelf();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.566 -0400", hash_original_method = "14B4EEBEDACB44F7F53A884DE9C011A3", hash_generated_method = "23B3966209C93F10A33042F940AC6D07")
    @Override
    public void inflate(Resources r, XmlPullParser parser, AttributeSet attrs) throws XmlPullParserException, IOException {
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
            boolean varEE0C99B0E498FE80FA057D0ADB22AD18_2072297362 = (bitmap.getNinePatchChunk() == null);
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
        addTaint(r.getTaint());
        addTaint(parser.getTaint());
        addTaint(attrs.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.591 -0400", hash_original_method = "075C514CB6C74FC258CE8B3440B31BB9", hash_generated_method = "22722E9C33674DF53CC13B507CF804C3")
    public Paint getPaint() {
        Paint varB4EAC82CA7396A68D541C85D26508E83_1410586739 = null; //Variable for return #1
        {
            mPaint = new Paint();
            mPaint.setDither(DEFAULT_DITHER);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1410586739 = mPaint;
        varB4EAC82CA7396A68D541C85D26508E83_1410586739.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1410586739;
        // ---------- Original Method ----------
        //if (mPaint == null) {
            //mPaint = new Paint();
            //mPaint.setDither(DEFAULT_DITHER);
        //}
        //return mPaint;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.592 -0400", hash_original_method = "6DB114FB8E950C38C4587167EE2392DA", hash_generated_method = "30F0C1C54AC290A21EF43DACFC05EF7A")
    @Override
    public int getIntrinsicWidth() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2100143308 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2100143308;
        // ---------- Original Method ----------
        //return mBitmapWidth;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.593 -0400", hash_original_method = "391FEC77F059693D96A6B7B3AE926494", hash_generated_method = "D56138313C61427989D304B2F654AAE3")
    @Override
    public int getIntrinsicHeight() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1312692190 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1312692190;
        // ---------- Original Method ----------
        //return mBitmapHeight;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.594 -0400", hash_original_method = "F677AE1ECA1CBA7AB5A76B8BE368A72F", hash_generated_method = "AF23C1DC44093523D767CCD7C08E2026")
    @Override
    public int getMinimumWidth() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1503610259 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1503610259;
        // ---------- Original Method ----------
        //return mBitmapWidth;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.620 -0400", hash_original_method = "0C368C2268B0130C3ACD75434C6C4889", hash_generated_method = "DDA196B8F6C28735F0AD377E94E5A97A")
    @Override
    public int getMinimumHeight() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_926687487 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_926687487;
        // ---------- Original Method ----------
        //return mBitmapHeight;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.632 -0400", hash_original_method = "B22FBB09C864D64632C83D9F48FAF25E", hash_generated_method = "064DE6FDC168FE195A8E2095031CAE51")
    @Override
    public int getOpacity() {
        {
            boolean varB6178F50962C98D5C92810A1A86D2E76_874945129 = (mNinePatch.hasAlpha() || (mPaint != null && mPaint.getAlpha() < 255));
        } //End flattened ternary
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_226137658 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_226137658;
        // ---------- Original Method ----------
        //return mNinePatch.hasAlpha() || (mPaint != null && mPaint.getAlpha() < 255) ?
                //PixelFormat.TRANSLUCENT : PixelFormat.OPAQUE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.639 -0400", hash_original_method = "015B10918498A51630C2035B52469361", hash_generated_method = "E1CBAB240AA7A2F9CED521A5CA1AB626")
    @Override
    public Region getTransparentRegion() {
        Region varB4EAC82CA7396A68D541C85D26508E83_294795447 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_294795447 = mNinePatch.getTransparentRegion(getBounds());
        varB4EAC82CA7396A68D541C85D26508E83_294795447.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_294795447;
        // ---------- Original Method ----------
        //return mNinePatch.getTransparentRegion(getBounds());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.641 -0400", hash_original_method = "4F3C3B017CDA56F4212D4719D10B45C1", hash_generated_method = "F708B9EE54ABD8C99A488C7A5FB9E9E8")
    @Override
    public ConstantState getConstantState() {
        ConstantState varB4EAC82CA7396A68D541C85D26508E83_1212923101 = null; //Variable for return #1
        mNinePatchState.mChangingConfigurations = getChangingConfigurations();
        varB4EAC82CA7396A68D541C85D26508E83_1212923101 = mNinePatchState;
        varB4EAC82CA7396A68D541C85D26508E83_1212923101.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1212923101;
        // ---------- Original Method ----------
        //mNinePatchState.mChangingConfigurations = getChangingConfigurations();
        //return mNinePatchState;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.644 -0400", hash_original_method = "EEABBB7B802F633C5D2C005A94C5FF68", hash_generated_method = "344D6414765183296F0C6D4D729078D0")
    @Override
    public Drawable mutate() {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_875648793 = null; //Variable for return #1
        {
            boolean varC94B19053599294E7944C8C841976773_628869320 = (!mMutated && super.mutate() == this);
            {
                mNinePatchState = new NinePatchState(mNinePatchState);
                mNinePatch = mNinePatchState.mNinePatch;
                mMutated = true;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_875648793 = this;
        varB4EAC82CA7396A68D541C85D26508E83_875648793.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_875648793;
        // ---------- Original Method ----------
        //if (!mMutated && super.mutate() == this) {
            //mNinePatchState = new NinePatchState(mNinePatchState);
            //mNinePatch = mNinePatchState.mNinePatch;
            //mMutated = true;
        //}
        //return this;
    }

    
    final static class NinePatchState extends ConstantState {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.645 -0400", hash_original_field = "11340C2D1AC0FCA9696006576602F263", hash_generated_field = "C0E1C53C4D030D6E494BA74829B1D5B8")

        NinePatch mNinePatch;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.645 -0400", hash_original_field = "9AC2544B5F9B8F60AA16656C94B57A8E", hash_generated_field = "A053A94BBF9972B52A80E2FC510022E8")

        Rect mPadding;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.645 -0400", hash_original_field = "39F3EFC8FE0445AB43D96028DA65CB34", hash_generated_field = "28ABDDC6F40109F392846C3ED0C6A12A")

        boolean mDither;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.645 -0400", hash_original_field = "276E0645C4E2084773D0EB8C5576428C", hash_generated_field = "9BFAF00848476277D36D9BA586984BA7")

        int mChangingConfigurations;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.645 -0400", hash_original_field = "C98BC9AD629AD94FF2237799C3746D10", hash_generated_field = "80AC771C22191FC983474A6CF039F227")

        int mTargetDensity = DisplayMetrics.DENSITY_DEFAULT;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.658 -0400", hash_original_method = "CA3208FB1D6439C7B894EDBF6EC3D9DE", hash_generated_method = "2F7F9E1AEFFA783F5A2DEEAA6B028141")
          NinePatchState(NinePatch ninePatch, Rect padding) {
            this(ninePatch, padding, DEFAULT_DITHER);
            addTaint(ninePatch.getTaint());
            addTaint(padding.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.666 -0400", hash_original_method = "88C0915540B2FF11645913E277979DA7", hash_generated_method = "9BFFEFD000BA64BCBBB112BD3FA1ECE8")
          NinePatchState(NinePatch ninePatch, Rect rect, boolean dither) {
            mNinePatch = ninePatch;
            mPadding = rect;
            mDither = dither;
            // ---------- Original Method ----------
            //mNinePatch = ninePatch;
            //mPadding = rect;
            //mDither = dither;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.668 -0400", hash_original_method = "05814CB491C8C0B2C0FEF50DD9B15E6B", hash_generated_method = "6FB97DE528A65798A82E3899D34DE7BE")
          NinePatchState(NinePatchState state) {
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.669 -0400", hash_original_method = "D02B1AE1E59D491553AECB8C917A9A24", hash_generated_method = "5C8EB5C1204D0E9A14B73049CAB9D62D")
        @Override
        public Drawable newDrawable() {
            Drawable varB4EAC82CA7396A68D541C85D26508E83_739430142 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_739430142 = new NinePatchDrawable(this, null);
            varB4EAC82CA7396A68D541C85D26508E83_739430142.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_739430142;
            // ---------- Original Method ----------
            //return new NinePatchDrawable(this, null);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.669 -0400", hash_original_method = "A66FA8882A8A4D3CAB4071390F4B61B2", hash_generated_method = "327FE264AE85E05EAE9BE09BFB051817")
        @Override
        public Drawable newDrawable(Resources res) {
            Drawable varB4EAC82CA7396A68D541C85D26508E83_1992149691 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1992149691 = new NinePatchDrawable(this, res);
            addTaint(res.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1992149691.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1992149691;
            // ---------- Original Method ----------
            //return new NinePatchDrawable(this, res);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.670 -0400", hash_original_method = "9E7D7C67EAC365FF19BD4971762612A5", hash_generated_method = "09E15E4AE5210DAD35E5456AD97BF081")
        @Override
        public int getChangingConfigurations() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1892294797 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1892294797;
            // ---------- Original Method ----------
            //return mChangingConfigurations;
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.670 -0400", hash_original_field = "786AC07A1E16FDB1F134271AA028A7C1", hash_generated_field = "50E8831DF5E0728C9EF4B3F3FEDD2908")

    private static boolean DEFAULT_DITHER = true;
}

