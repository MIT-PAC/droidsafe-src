package android.graphics.drawable;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.550 -0400", hash_original_field = "80A04E56058AB398069773FAD8CBA742", hash_generated_field = "6C68B5548B044A9A7BC44A7FEBD76DE2")

    private NinePatchState mNinePatchState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.550 -0400", hash_original_field = "11340C2D1AC0FCA9696006576602F263", hash_generated_field = "70B2B86AA0FF0A8CB74F2B53CA0A60ED")

    private NinePatch mNinePatch;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.550 -0400", hash_original_field = "9AC2544B5F9B8F60AA16656C94B57A8E", hash_generated_field = "017017AA9AF1862D01EDDEC3A7AB7775")

    private Rect mPadding;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.550 -0400", hash_original_field = "78E27F80AC0100441F897783EFA42851", hash_generated_field = "75BCEEBE83B26919B33E8EA8B289919E")

    private Paint mPaint;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.550 -0400", hash_original_field = "9FB80C30383848C8D006680B5F3BDAF9", hash_generated_field = "5CA5A1EF3CAA45117BCACBC34EF05952")

    private boolean mMutated;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.550 -0400", hash_original_field = "C98BC9AD629AD94FF2237799C3746D10", hash_generated_field = "1860FF555EBFEAEB762501C3F409202A")

    private int mTargetDensity = DisplayMetrics.DENSITY_DEFAULT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.550 -0400", hash_original_field = "DE6A0ABB3CA1313B4F7BDFF407B4A18B", hash_generated_field = "568275F41A7E61D900F9F414E799383D")

    private int mBitmapWidth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.550 -0400", hash_original_field = "EE573FC7FF36074270F8BF43556DFB4C", hash_generated_field = "2EAFFA48F02C3807ED7A1FED6D773758")

    private int mBitmapHeight;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.550 -0400", hash_original_method = "273B833CD4C77CDA56AC8174D9DCFE29", hash_generated_method = "FBBCF1482AE910368A61C9233970F106")
      NinePatchDrawable() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.551 -0400", hash_original_method = "EA37E144790F39B12A14B8A0E7D897B0", hash_generated_method = "920C3EB779A3AFB982DD93E08AD3D6C0")
    @Deprecated
    public  NinePatchDrawable(Bitmap bitmap, byte[] chunk, Rect padding, String srcName) {
        this(new NinePatchState(new NinePatch(bitmap, chunk, srcName), padding), null);
        addTaint(srcName.getTaint());
        addTaint(padding.getTaint());
        addTaint(chunk[0]);
        addTaint(bitmap.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.551 -0400", hash_original_method = "929FEA5C59B893442F4AD64A16378707", hash_generated_method = "D83509E58DB04D6614D87C911ADD5C72")
    public  NinePatchDrawable(Resources res, Bitmap bitmap, byte[] chunk,
            Rect padding, String srcName) {
        this(new NinePatchState(new NinePatch(bitmap, chunk, srcName), padding), res);
        addTaint(srcName.getTaint());
        addTaint(padding.getTaint());
        addTaint(chunk[0]);
        addTaint(bitmap.getTaint());
        addTaint(res.getTaint());
        mNinePatchState.mTargetDensity = mTargetDensity;
        // ---------- Original Method ----------
        //mNinePatchState.mTargetDensity = mTargetDensity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.552 -0400", hash_original_method = "50B637C031C7A89AA164A5082D6A3A93", hash_generated_method = "ADF5474A5E2E0C922D423BE285EC1969")
    @Deprecated
    public  NinePatchDrawable(NinePatch patch) {
        this(new NinePatchState(patch, new Rect()), null);
        addTaint(patch.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.552 -0400", hash_original_method = "78318325CB229FE4515B0254D2B416A2", hash_generated_method = "3DB822036D83D5C77CEBD7A15865D10D")
    public  NinePatchDrawable(Resources res, NinePatch patch) {
        this(new NinePatchState(patch, new Rect()), res);
        addTaint(patch.getTaint());
        addTaint(res.getTaint());
        mNinePatchState.mTargetDensity = mTargetDensity;
        // ---------- Original Method ----------
        //mNinePatchState.mTargetDensity = mTargetDensity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.553 -0400", hash_original_method = "EB08CD45C7A208D135CB0BEAA7998119", hash_generated_method = "BF0F1A13FDB2188FD0ADF9C2CB131DB4")
    private  NinePatchDrawable(NinePatchState state, Resources res) {
        addTaint(res.getTaint());
        addTaint(state.getTaint());
        setNinePatchState(state, res);
        // ---------- Original Method ----------
        //setNinePatchState(state, res);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.554 -0400", hash_original_method = "0EDC8E1D8196DBA7E3430735EBC66D6F", hash_generated_method = "DCE32EDE24D2471C53AF18C0A7D9C77A")
    private void setNinePatchState(NinePatchState state, Resources res) {
        mNinePatchState = state;
        mNinePatch = state.mNinePatch;
        mPadding = state.mPadding;
        mTargetDensity = res != null ? res.getDisplayMetrics().densityDpi
                : state.mTargetDensity;
    if(state.mDither != DEFAULT_DITHER)        
        {
            setDither(state.mDither);
        } //End block
    if(mNinePatch != null)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.554 -0400", hash_original_method = "82585E992AABF5984A06ED90552A1C77", hash_generated_method = "08ADEC9348B823ADA440A2B50003FC7E")
    public void setTargetDensity(Canvas canvas) {
        addTaint(canvas.getTaint());
        setTargetDensity(canvas.getDensity());
        // ---------- Original Method ----------
        //setTargetDensity(canvas.getDensity());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.555 -0400", hash_original_method = "4AE49AE83EF2F62C9A584A758B5178F3", hash_generated_method = "A780DDFCC4CBE80D7EFC83D56CFDF67F")
    public void setTargetDensity(DisplayMetrics metrics) {
        addTaint(metrics.getTaint());
        setTargetDensity(metrics.densityDpi);
        // ---------- Original Method ----------
        //setTargetDensity(metrics.densityDpi);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.556 -0400", hash_original_method = "F1F344BB6765FE54A2E40BB8E2AEB010", hash_generated_method = "663F370820EEE6B0F09592798FB8B7FE")
    public void setTargetDensity(int density) {
    if(density != mTargetDensity)        
        {
            mTargetDensity = density == 0 ? DisplayMetrics.DENSITY_DEFAULT : density;
    if(mNinePatch != null)            
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.557 -0400", hash_original_method = "E8279E2F004E74E2D3A3C9AE5B1B6A96", hash_generated_method = "2F9B40EE02EDB2B79413BDB88C9DB922")
    private void computeBitmapSize() {
        final int sdensity = mNinePatch.getDensity();
        final int tdensity = mTargetDensity;
    if(sdensity == tdensity)        
        {
            mBitmapWidth = mNinePatch.getWidth();
            mBitmapHeight = mNinePatch.getHeight();
        } //End block
        else
        {
            mBitmapWidth = Bitmap.scaleFromDensity(mNinePatch.getWidth(),
                    sdensity, tdensity);
            mBitmapHeight = Bitmap.scaleFromDensity(mNinePatch.getHeight(),
                    sdensity, tdensity);
    if(mNinePatchState.mPadding != null && mPadding != null)            
            {
                Rect dest = mPadding;
                Rect src = mNinePatchState.mPadding;
    if(dest == src)                
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.558 -0400", hash_original_method = "D590BE7B225C8366E27B182C22714F49", hash_generated_method = "68817A4D82208748CCCB18662DE8F22C")
    @Override
    public void draw(Canvas canvas) {
        addTaint(canvas.getTaint());
        mNinePatch.draw(canvas, getBounds(), mPaint);
        // ---------- Original Method ----------
        //mNinePatch.draw(canvas, getBounds(), mPaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.558 -0400", hash_original_method = "F3B5E1AA8DCA42FBC0209DF5DE34A528", hash_generated_method = "734E9DA91708C062EC61C703D46792FD")
    @Override
    public int getChangingConfigurations() {
        int var08CA7BCE8F69966B7213F6876D3E93CD_364828189 = (super.getChangingConfigurations() | mNinePatchState.mChangingConfigurations);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_581119890 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_581119890;
        // ---------- Original Method ----------
        //return super.getChangingConfigurations() | mNinePatchState.mChangingConfigurations;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.558 -0400", hash_original_method = "6A7A0B10486EA74D6FDB7CE40BB96DCF", hash_generated_method = "5EBEB93CE7DE80ED1C7C6437B3935C57")
    @Override
    public boolean getPadding(Rect padding) {
        addTaint(padding.getTaint());
        padding.set(mPadding);
        boolean varB326B5062B2F0E69046810717534CB09_940802257 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2085547215 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2085547215;
        // ---------- Original Method ----------
        //padding.set(mPadding);
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.559 -0400", hash_original_method = "DDA2062A293BD75777B2540266427F8E", hash_generated_method = "F8A78663CF2F4AC718440E66820427BE")
    @Override
    public void setAlpha(int alpha) {
        addTaint(alpha);
    if(mPaint == null && alpha == 0xFF)        
        {
            return;
        } //End block
        getPaint().setAlpha(alpha);
        invalidateSelf();
        // ---------- Original Method ----------
        //if (mPaint == null && alpha == 0xFF) {
            //return;
        //}
        //getPaint().setAlpha(alpha);
        //invalidateSelf();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.559 -0400", hash_original_method = "D5833F804B1FB713A7DF2F016B869F27", hash_generated_method = "89715F17A80D029628E79EDC871F41CC")
    @Override
    public void setColorFilter(ColorFilter cf) {
        addTaint(cf.getTaint());
    if(mPaint == null && cf == null)        
        {
            return;
        } //End block
        getPaint().setColorFilter(cf);
        invalidateSelf();
        // ---------- Original Method ----------
        //if (mPaint == null && cf == null) {
            //return;
        //}
        //getPaint().setColorFilter(cf);
        //invalidateSelf();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.560 -0400", hash_original_method = "CFE043442F57EFE9659FF8A6FEAF97CC", hash_generated_method = "409BC327B8F2379309AF89351EAE4A5D")
    @Override
    public void setDither(boolean dither) {
        addTaint(dither);
    if(mPaint == null && dither == DEFAULT_DITHER)        
        {
            return;
        } //End block
        getPaint().setDither(dither);
        invalidateSelf();
        // ---------- Original Method ----------
        //if (mPaint == null && dither == DEFAULT_DITHER) {
            //return;
        //}
        //getPaint().setDither(dither);
        //invalidateSelf();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.560 -0400", hash_original_method = "49680E18787729BA4FD04D8979679DC0", hash_generated_method = "EDBDDF9F19B2257AC18DC725CB72BD76")
    @Override
    public void setFilterBitmap(boolean filter) {
        addTaint(filter);
        getPaint().setFilterBitmap(filter);
        invalidateSelf();
        // ---------- Original Method ----------
        //getPaint().setFilterBitmap(filter);
        //invalidateSelf();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.561 -0400", hash_original_method = "14B4EEBEDACB44F7F53A884DE9C011A3", hash_generated_method = "483B6F54D6E5AF9CF6384DFE93D51BC5")
    @Override
    public void inflate(Resources r, XmlPullParser parser, AttributeSet attrs) throws XmlPullParserException, IOException {
        addTaint(attrs.getTaint());
        addTaint(parser.getTaint());
        addTaint(r.getTaint());
        super.inflate(r, parser, attrs);
        TypedArray a = r.obtainAttributes(attrs, com.android.internal.R.styleable.NinePatchDrawable);
        final int id = a.getResourceId(com.android.internal.R.styleable.NinePatchDrawable_src, 0);
    if(id == 0)        
        {
            XmlPullParserException var334A59C8D08B34EB7CC02E507B3A2869_1891599683 = new XmlPullParserException(parser.getPositionDescription() +
                    ": <nine-patch> requires a valid src attribute");
            var334A59C8D08B34EB7CC02E507B3A2869_1891599683.addTaint(taint);
            throw var334A59C8D08B34EB7CC02E507B3A2869_1891599683;
        } //End block
        final boolean dither = a.getBoolean(
                com.android.internal.R.styleable.NinePatchDrawable_dither,
                DEFAULT_DITHER);
        final BitmapFactory.Options options = new BitmapFactory.Options();
    if(dither)        
        {
            options.inDither = false;
        } //End block
        options.inScreenDensity = DisplayMetrics.DENSITY_DEVICE;
        final Rect padding = new Rect();
        Bitmap bitmap = null;
        try 
        {
            final TypedValue value = new TypedValue();
            final InputStream is = r.openRawResource(id, value);
            bitmap = BitmapFactory.decodeResourceStream(r, value, is, padding, options);
            is.close();
        } //End block
        catch (IOException e)
        {
        } //End block
    if(bitmap == null)        
        {
            XmlPullParserException var334A59C8D08B34EB7CC02E507B3A2869_431353881 = new XmlPullParserException(parser.getPositionDescription() +
                    ": <nine-patch> requires a valid src attribute");
            var334A59C8D08B34EB7CC02E507B3A2869_431353881.addTaint(taint);
            throw var334A59C8D08B34EB7CC02E507B3A2869_431353881;
        } //End block
        else
    if(bitmap.getNinePatchChunk() == null)        
        {
            XmlPullParserException varCC71B185D866266CBF856D13A66CD303_652180431 = new XmlPullParserException(parser.getPositionDescription() +
                    ": <nine-patch> requires a valid 9-patch source image");
            varCC71B185D866266CBF856D13A66CD303_652180431.addTaint(taint);
            throw varCC71B185D866266CBF856D13A66CD303_652180431;
        } //End block
        setNinePatchState(new NinePatchState(
                new NinePatch(bitmap, bitmap.getNinePatchChunk(), "XML 9-patch"),
                padding, dither), r);
        mNinePatchState.mTargetDensity = mTargetDensity;
        a.recycle();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.562 -0400", hash_original_method = "075C514CB6C74FC258CE8B3440B31BB9", hash_generated_method = "7B02B4F33F7C8D2E9136EA2BD2CBA980")
    public Paint getPaint() {
    if(mPaint == null)        
        {
            mPaint = new Paint();
            mPaint.setDither(DEFAULT_DITHER);
        } //End block
Paint var942A2EBC27CD21C7FBC19AB14FC6E1BE_384233857 =         mPaint;
        var942A2EBC27CD21C7FBC19AB14FC6E1BE_384233857.addTaint(taint);
        return var942A2EBC27CD21C7FBC19AB14FC6E1BE_384233857;
        // ---------- Original Method ----------
        //if (mPaint == null) {
            //mPaint = new Paint();
            //mPaint.setDither(DEFAULT_DITHER);
        //}
        //return mPaint;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.563 -0400", hash_original_method = "6DB114FB8E950C38C4587167EE2392DA", hash_generated_method = "260BA9FD7EDB5B2CA0030730348F0ADE")
    @Override
    public int getIntrinsicWidth() {
        int varDE6A0ABB3CA1313B4F7BDFF407B4A18B_1866475162 = (mBitmapWidth);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1541785628 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1541785628;
        // ---------- Original Method ----------
        //return mBitmapWidth;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.563 -0400", hash_original_method = "391FEC77F059693D96A6B7B3AE926494", hash_generated_method = "223DB29D550EC208F07F53FCFF212F91")
    @Override
    public int getIntrinsicHeight() {
        int varEE573FC7FF36074270F8BF43556DFB4C_867470870 = (mBitmapHeight);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1174537165 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1174537165;
        // ---------- Original Method ----------
        //return mBitmapHeight;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.564 -0400", hash_original_method = "F677AE1ECA1CBA7AB5A76B8BE368A72F", hash_generated_method = "05A6EE8C28470E9AE7A809CF92730282")
    @Override
    public int getMinimumWidth() {
        int varDE6A0ABB3CA1313B4F7BDFF407B4A18B_1076810721 = (mBitmapWidth);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_116383861 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_116383861;
        // ---------- Original Method ----------
        //return mBitmapWidth;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.564 -0400", hash_original_method = "0C368C2268B0130C3ACD75434C6C4889", hash_generated_method = "CA97E18E0F6318B3113CCA583443559F")
    @Override
    public int getMinimumHeight() {
        int varEE573FC7FF36074270F8BF43556DFB4C_1985590710 = (mBitmapHeight);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1387619614 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1387619614;
        // ---------- Original Method ----------
        //return mBitmapHeight;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.564 -0400", hash_original_method = "B22FBB09C864D64632C83D9F48FAF25E", hash_generated_method = "D60C44E148120CDC7339DFB768493A62")
    @Override
    public int getOpacity() {
        int var6B35A817A3CEF6E0E75B24A5D35902CC_564379201 = (mNinePatch.hasAlpha() || (mPaint != null && mPaint.getAlpha() < 255) ?
                PixelFormat.TRANSLUCENT : PixelFormat.OPAQUE);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1520322294 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1520322294;
        // ---------- Original Method ----------
        //return mNinePatch.hasAlpha() || (mPaint != null && mPaint.getAlpha() < 255) ?
                //PixelFormat.TRANSLUCENT : PixelFormat.OPAQUE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.565 -0400", hash_original_method = "015B10918498A51630C2035B52469361", hash_generated_method = "7D29B8BE533BE6A79D734F0469E85F3A")
    @Override
    public Region getTransparentRegion() {
Region var8C9A2FFDF223620D1B8C5F01ABD6446A_1819782474 =         mNinePatch.getTransparentRegion(getBounds());
        var8C9A2FFDF223620D1B8C5F01ABD6446A_1819782474.addTaint(taint);
        return var8C9A2FFDF223620D1B8C5F01ABD6446A_1819782474;
        // ---------- Original Method ----------
        //return mNinePatch.getTransparentRegion(getBounds());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.565 -0400", hash_original_method = "4F3C3B017CDA56F4212D4719D10B45C1", hash_generated_method = "BDCD3A006EE038DC3E8380623919E8EC")
    @Override
    public ConstantState getConstantState() {
        mNinePatchState.mChangingConfigurations = getChangingConfigurations();
ConstantState varE83629E35F6F9864AC8A339BA860BD8D_908196033 =         mNinePatchState;
        varE83629E35F6F9864AC8A339BA860BD8D_908196033.addTaint(taint);
        return varE83629E35F6F9864AC8A339BA860BD8D_908196033;
        // ---------- Original Method ----------
        //mNinePatchState.mChangingConfigurations = getChangingConfigurations();
        //return mNinePatchState;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.566 -0400", hash_original_method = "EEABBB7B802F633C5D2C005A94C5FF68", hash_generated_method = "A2FF01FF94466BF5747BECA3A18F55C7")
    @Override
    public Drawable mutate() {
    if(!mMutated && super.mutate() == this)        
        {
            mNinePatchState = new NinePatchState(mNinePatchState);
            mNinePatch = mNinePatchState.mNinePatch;
            mMutated = true;
        } //End block
Drawable var72A74007B2BE62B849F475C7BDA4658B_245321162 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_245321162.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_245321162;
        // ---------- Original Method ----------
        //if (!mMutated && super.mutate() == this) {
            //mNinePatchState = new NinePatchState(mNinePatchState);
            //mNinePatch = mNinePatchState.mNinePatch;
            //mMutated = true;
        //}
        //return this;
    }

    
    final static class NinePatchState extends ConstantState {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.566 -0400", hash_original_field = "11340C2D1AC0FCA9696006576602F263", hash_generated_field = "C0E1C53C4D030D6E494BA74829B1D5B8")

        NinePatch mNinePatch;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.567 -0400", hash_original_field = "9AC2544B5F9B8F60AA16656C94B57A8E", hash_generated_field = "A053A94BBF9972B52A80E2FC510022E8")

        Rect mPadding;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.567 -0400", hash_original_field = "39F3EFC8FE0445AB43D96028DA65CB34", hash_generated_field = "28ABDDC6F40109F392846C3ED0C6A12A")

        boolean mDither;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.567 -0400", hash_original_field = "276E0645C4E2084773D0EB8C5576428C", hash_generated_field = "9BFAF00848476277D36D9BA586984BA7")

        int mChangingConfigurations;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.567 -0400", hash_original_field = "C98BC9AD629AD94FF2237799C3746D10", hash_generated_field = "80AC771C22191FC983474A6CF039F227")

        int mTargetDensity = DisplayMetrics.DENSITY_DEFAULT;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.568 -0400", hash_original_method = "CA3208FB1D6439C7B894EDBF6EC3D9DE", hash_generated_method = "36BE5747EFD26B53A2FEAEF755695FDB")
          NinePatchState(NinePatch ninePatch, Rect padding) {
            this(ninePatch, padding, DEFAULT_DITHER);
            addTaint(padding.getTaint());
            addTaint(ninePatch.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.568 -0400", hash_original_method = "88C0915540B2FF11645913E277979DA7", hash_generated_method = "9BFFEFD000BA64BCBBB112BD3FA1ECE8")
          NinePatchState(NinePatch ninePatch, Rect rect, boolean dither) {
            mNinePatch = ninePatch;
            mPadding = rect;
            mDither = dither;
            // ---------- Original Method ----------
            //mNinePatch = ninePatch;
            //mPadding = rect;
            //mDither = dither;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.569 -0400", hash_original_method = "05814CB491C8C0B2C0FEF50DD9B15E6B", hash_generated_method = "6FB97DE528A65798A82E3899D34DE7BE")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.570 -0400", hash_original_method = "D02B1AE1E59D491553AECB8C917A9A24", hash_generated_method = "9D718CAB2A80426548103407A9C1B58C")
        @Override
        public Drawable newDrawable() {
Drawable var708FDFD1DBFE28145CA77F3831E02689_36037275 =             new NinePatchDrawable(this, null);
            var708FDFD1DBFE28145CA77F3831E02689_36037275.addTaint(taint);
            return var708FDFD1DBFE28145CA77F3831E02689_36037275;
            // ---------- Original Method ----------
            //return new NinePatchDrawable(this, null);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.570 -0400", hash_original_method = "A66FA8882A8A4D3CAB4071390F4B61B2", hash_generated_method = "5777978BAC0C344180566ACD8BBD9EFF")
        @Override
        public Drawable newDrawable(Resources res) {
            addTaint(res.getTaint());
Drawable var19C30D5C28617817A3DDE2E024CBC4EE_10788500 =             new NinePatchDrawable(this, res);
            var19C30D5C28617817A3DDE2E024CBC4EE_10788500.addTaint(taint);
            return var19C30D5C28617817A3DDE2E024CBC4EE_10788500;
            // ---------- Original Method ----------
            //return new NinePatchDrawable(this, res);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.570 -0400", hash_original_method = "9E7D7C67EAC365FF19BD4971762612A5", hash_generated_method = "1A925A097CA84964C60499D5123A49E9")
        @Override
        public int getChangingConfigurations() {
            int var276E0645C4E2084773D0EB8C5576428C_1892310059 = (mChangingConfigurations);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_883704738 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_883704738;
            // ---------- Original Method ----------
            //return mChangingConfigurations;
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.570 -0400", hash_original_field = "786AC07A1E16FDB1F134271AA028A7C1", hash_generated_field = "17A3499D3AE1DB6784657D5E8AE3951F")

    private static final boolean DEFAULT_DITHER = true;
}

