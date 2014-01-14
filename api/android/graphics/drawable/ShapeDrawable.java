package android.graphics.drawable;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import java.io.IOException;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.shapes.Shape;
import android.util.AttributeSet;

public class ShapeDrawable extends Drawable {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:12.663 -0500", hash_original_method = "E383078E6D302FDDE500ADE293E90381", hash_generated_method = "5A904229B3812503535488EEFBA822E7")
    
private static int modulateAlpha(int paintAlpha, int alpha) {
        int scale = alpha + (alpha >>> 7);  // convert to 0..256
        return paintAlpha * scale >>> 8;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:12.625 -0500", hash_original_field = "92E80590B202C22CEC5604E45CC58270", hash_generated_field = "E775880DE66EC067EFB70E829A0DB9BA")

    private ShapeState mShapeState;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:12.628 -0500", hash_original_field = "B15C308E96D0EEBD27CFE369FA349C15", hash_generated_field = "5CA5A1EF3CAA45117BCACBC34EF05952")

    private boolean mMutated;

    /**
     * ShapeDrawable constructor.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:12.630 -0500", hash_original_method = "0D9B9D363D3461B1F66ABDB4BD10ADF4", hash_generated_method = "17FB7767631FA7F832472B17C1CEE3CA")
    
public ShapeDrawable() {
        this((ShapeState) null);
    }
    
    /**
     * Creates a ShapeDrawable with a specified Shape.
     * 
     * @param s the Shape that this ShapeDrawable should be
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:12.632 -0500", hash_original_method = "F897BE84D7E0CD5527DF62F0C124D538", hash_generated_method = "C164D286312FCAC2934B216E95CD94BA")
    
public ShapeDrawable(Shape s) {
        this((ShapeState) null);
        
        mShapeState.mShape = s;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:12.635 -0500", hash_original_method = "1601A6C313758A231E2593A310142434", hash_generated_method = "C8D858770170D867DAAE78A66A2AF545")
    
private ShapeDrawable(ShapeState state) {
        mShapeState = new ShapeState(state);
    }

    /**
     * Returns the Shape of this ShapeDrawable.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:12.637 -0500", hash_original_method = "93DF953391DA58A2026A871408A81498", hash_generated_method = "737BC6EBDFDD70AFFDB3FDB0CB181E1E")
    
public Shape getShape() {
        return mShapeState.mShape;
    }
    
    /**
     * Sets the Shape of this ShapeDrawable.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:12.639 -0500", hash_original_method = "91DE5C2C93AB9A1591999F92B24BB2F1", hash_generated_method = "D11C8B8E59719A488486EDE1B36A0142")
    
public void setShape(Shape s) {
        mShapeState.mShape = s;
        updateShape();
    }
    
    /**
     * Sets a ShaderFactory to which requests for a 
     * {@link android.graphics.Shader} object will be made.
     * 
     * @param fact an instance of your ShaderFactory implementation
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:12.641 -0500", hash_original_method = "63480B19EB44379868D8321D7A96C7B7", hash_generated_method = "C8B0421E4B4920DB7B695E5EF11C4902")
    
public void setShaderFactory(ShaderFactory fact) {
        mShapeState.mShaderFactory = fact;
    }
    
    /**
     * Returns the ShaderFactory used by this ShapeDrawable for requesting a 
     * {@link android.graphics.Shader}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:12.644 -0500", hash_original_method = "E65D8AF971F17EDFF075456EB259C0A6", hash_generated_method = "1A0A5F3FA2356D7A2CD6DD11F3188EF7")
    
public ShaderFactory getShaderFactory() {
        return mShapeState.mShaderFactory;
    }

    /**
     * Returns the Paint used to draw the shape.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:12.646 -0500", hash_original_method = "F97BA42DC4507A8A136D2774D1D1BA0E", hash_generated_method = "068B430F7B4C53C726FFF413D2F3A531")
    
public Paint getPaint() {
        return mShapeState.mPaint;
    }
    
    /**
     * Sets padding for the shape.
     * 
     * @param left    padding for the left side (in pixels)
     * @param top     padding for the top (in pixels)
     * @param right   padding for the right side (in pixels)
     * @param bottom  padding for the bottom (in pixels)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:12.648 -0500", hash_original_method = "B421F82679CD23EB7F3D507B70942FAD", hash_generated_method = "1ED0A641FD2E298BCD9FC4061CDBEB04")
    
public void setPadding(int left, int top, int right, int bottom) {
        if ((left | top | right | bottom) == 0) {
            mShapeState.mPadding = null;
        } else {
            if (mShapeState.mPadding == null) {
                mShapeState.mPadding = new Rect();
            }
            mShapeState.mPadding.set(left, top, right, bottom);
        }
        invalidateSelf();
    }
    
    /**
     * Sets padding for this shape, defined by a Rect object.
     * Define the padding in the Rect object as: left, top, right, bottom.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:12.651 -0500", hash_original_method = "416AA9F2AA0561BA0C5710C29E641860", hash_generated_method = "266E91202B7A5EBA0F38729A240A61C7")
    
public void setPadding(Rect padding) {
        if (padding == null) {
            mShapeState.mPadding = null;
        } else {
            if (mShapeState.mPadding == null) {
                mShapeState.mPadding = new Rect();
            }
            mShapeState.mPadding.set(padding);
        }
        invalidateSelf();
    }
    
    /**
     * Sets the intrinsic (default) width for this shape.
     * 
     * @param width the intrinsic width (in pixels)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:12.653 -0500", hash_original_method = "0038E10CC04EA446FBCFE7542F8A245A", hash_generated_method = "20440F4623A1428B535E4C42E9FFF03A")
    
public void setIntrinsicWidth(int width) {
        mShapeState.mIntrinsicWidth = width;
        invalidateSelf();
    }
    
    /**
     * Sets the intrinsic (default) height for this shape.
     * 
     * @param height the intrinsic height (in pixels)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:12.655 -0500", hash_original_method = "0D195260E9CE84B5EB7D22342052E56D", hash_generated_method = "EFB6D5AB629660A42C5D27E55F0E31B7")
    
public void setIntrinsicHeight(int height) {
        mShapeState.mIntrinsicHeight = height;
        invalidateSelf();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:12.657 -0500", hash_original_method = "2BA24D2DFEB102D9B9B4478CA4BDB4E4", hash_generated_method = "64ECD1662B7E31C069921F1B1B38615B")
    
@Override
    public int getIntrinsicWidth() {
        return mShapeState.mIntrinsicWidth;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:12.659 -0500", hash_original_method = "A17CBC5FDAD1E989314B42A85C195659", hash_generated_method = "B3B41353119A905FD6F7F60D49AA06B4")
    
@Override
    public int getIntrinsicHeight() {
        return mShapeState.mIntrinsicHeight;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:12.661 -0500", hash_original_method = "57EA20106D2449A841F533A811E87EF0", hash_generated_method = "AC841C603BEB0FAE5CC1FB153CD242F1")
    
@Override
    public boolean getPadding(Rect padding) {
        if (mShapeState.mPadding != null) {
            padding.set(mShapeState.mPadding);
            return true;
        } else {
            return super.getPadding(padding);
        }
    }

    /**
     * Called from the drawable's draw() method after the canvas has been set
     * to draw the shape at (0,0). Subclasses can override for special effects
     * such as multiple layers, stroking, etc.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:12.666 -0500", hash_original_method = "94C805D8D565AE05BF02DE9855C838FE", hash_generated_method = "04B03AA513247D394DECF4A727FA6145")
    
protected void onDraw(Shape shape, Canvas canvas, Paint paint) {
        shape.draw(canvas, paint);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:12.668 -0500", hash_original_method = "2D289F2C5870F3B95565E05840E163B8", hash_generated_method = "1364F2E2B8E64B241E35587E8A217814")
    
@Override
    public void draw(Canvas canvas) {
        Rect r = getBounds();
        Paint paint = mShapeState.mPaint;

        int prevAlpha = paint.getAlpha();
        paint.setAlpha(modulateAlpha(prevAlpha, mShapeState.mAlpha));

        if (mShapeState.mShape != null) {
            // need the save both for the translate, and for the (unknown) Shape
            int count = canvas.save();
            canvas.translate(r.left, r.top);
            onDraw(mShapeState.mShape, canvas, paint);
            canvas.restoreToCount(count);
        } else {
            canvas.drawRect(r, paint);
        }
        
        // restore
        paint.setAlpha(prevAlpha);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:12.671 -0500", hash_original_method = "DB1A6AE8DEB59FB8C1923E504575EFF9", hash_generated_method = "4C165A424E276EF94F8AA9A3E81C903F")
    
@Override
    public int getChangingConfigurations() {
        return super.getChangingConfigurations()
                | mShapeState.mChangingConfigurations;
    }
    
    /**
     * Set the alpha level for this drawable [0..255]. Note that this drawable
     * also has a color in its paint, which has an alpha as well. These two
     * values are automatically combined during drawing. Thus if the color's
     * alpha is 75% (i.e. 192) and the drawable's alpha is 50% (i.e. 128), then
     * the combined alpha that will be used during drawing will be 37.5%
     * (i.e. 96).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:12.673 -0500", hash_original_method = "6237C1F5A576324C3E69C30154E7DEFA", hash_generated_method = "3FFBA91E5BE03B41ADCDE66CA52608AD")
    
@Override public void setAlpha(int alpha) {
        mShapeState.mAlpha = alpha;
        invalidateSelf();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:12.675 -0500", hash_original_method = "DD3A0AA7864766F7FA9D12D24B53719B", hash_generated_method = "7C9304B642C9456EC60FCF7238F96B88")
    
@Override
    public void setColorFilter(ColorFilter cf) {
        mShapeState.mPaint.setColorFilter(cf);
        invalidateSelf();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:12.678 -0500", hash_original_method = "056406D5393D0B46C202324FAF95659D", hash_generated_method = "384F781BD7AF450D15F5CFCF282A7CB9")
    
@Override
    public int getOpacity() {
        if (mShapeState.mShape == null) {
            final Paint p = mShapeState.mPaint;
            if (p.getXfermode() == null) {
                final int alpha = p.getAlpha();
                if (alpha == 0) {
                    return PixelFormat.TRANSPARENT;
                }
                if (alpha == 255) {
                    return PixelFormat.OPAQUE;
                }
            }
        }
        // not sure, so be safe
        return PixelFormat.TRANSLUCENT;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:12.680 -0500", hash_original_method = "3955BCB5252FAD61A7FDF156B0C32957", hash_generated_method = "9B1560AF942AE9072A6473BDBCEFDE3B")
    
@Override
    public void setDither(boolean dither) {
        mShapeState.mPaint.setDither(dither);
        invalidateSelf();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:12.683 -0500", hash_original_method = "E6B6299A3D5979543EAAC4DC6F8268D1", hash_generated_method = "A3535D1B76AFFA4E4051DC201C7F142E")
    
@Override
    protected void onBoundsChange(Rect bounds) {
        super.onBoundsChange(bounds);
        updateShape();
    }

    /**
     * Subclasses override this to parse custom subelements.
     * If you handle it, return true, else return <em>super.inflateTag(...)</em>.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:12.685 -0500", hash_original_method = "FCE81D70334945C2A418AF4A55A47945", hash_generated_method = "ABB528E1D542070DBBFF39BFEEE7FB4C")
    
protected boolean inflateTag(String name, Resources r, XmlPullParser parser,
            AttributeSet attrs) {

        if ("padding".equals(name)) {
            TypedArray a = r.obtainAttributes(attrs,
                    com.android.internal.R.styleable.ShapeDrawablePadding);
            setPadding(
                    a.getDimensionPixelOffset(
                            com.android.internal.R.styleable.ShapeDrawablePadding_left, 0),
                    a.getDimensionPixelOffset(
                            com.android.internal.R.styleable.ShapeDrawablePadding_top, 0),
                    a.getDimensionPixelOffset(
                            com.android.internal.R.styleable.ShapeDrawablePadding_right, 0),
                    a.getDimensionPixelOffset(
                            com.android.internal.R.styleable.ShapeDrawablePadding_bottom, 0));
            a.recycle();
            return true;
        }

        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:12.688 -0500", hash_original_method = "5F3462BA297EEEB891A1F24F05317325", hash_generated_method = "78E971DDBDE126C087012D855B0F8127")
    
@Override
    public void inflate(Resources r, XmlPullParser parser, AttributeSet attrs)
                        throws XmlPullParserException, IOException {
        super.inflate(r, parser, attrs);

        TypedArray a = r.obtainAttributes(attrs, com.android.internal.R.styleable.ShapeDrawable);

        int color = mShapeState.mPaint.getColor();
        color = a.getColor(com.android.internal.R.styleable.ShapeDrawable_color, color);
        mShapeState.mPaint.setColor(color);

        boolean dither = a.getBoolean(com.android.internal.R.styleable.ShapeDrawable_dither, false);
        mShapeState.mPaint.setDither(dither);

        setIntrinsicWidth((int)
                a.getDimension(com.android.internal.R.styleable.ShapeDrawable_width, 0f));
        setIntrinsicHeight((int)
                a.getDimension(com.android.internal.R.styleable.ShapeDrawable_height, 0f));

        a.recycle();

        int type;
        final int outerDepth = parser.getDepth();
        while ((type=parser.next()) != XmlPullParser.END_DOCUMENT
               && (type != XmlPullParser.END_TAG || parser.getDepth() > outerDepth)) {
            if (type != XmlPullParser.START_TAG) {
                continue;
            }
            
            final String name = parser.getName();
            // call our subclass
            if (!inflateTag(name, r, parser, attrs)) {
                android.util.Log.w("drawable", "Unknown element: " + name +
                        " for ShapeDrawable " + this);
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:12.691 -0500", hash_original_method = "A8D04337EAFF1E34F1C3CFBFD3AD3EF7", hash_generated_method = "0F5EB8196B820609A8160DB4FF0E5467")
    
private void updateShape() {
        if (mShapeState.mShape != null) {
            final Rect r = getBounds();
            final int w = r.width();
            final int h = r.height();

            mShapeState.mShape.resize(w, h);
            if (mShapeState.mShaderFactory != null) {
                mShapeState.mPaint.setShader(mShapeState.mShaderFactory.resize(w, h));
            }
        }
        invalidateSelf();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:12.693 -0500", hash_original_method = "A9816EFD17AF344D0CD39D6855E6F73A", hash_generated_method = "70DABC3C391B17AA3468BC899E17105E")
    
@Override
    public ConstantState getConstantState() {
        mShapeState.mChangingConfigurations = getChangingConfigurations();
        return mShapeState;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:12.696 -0500", hash_original_method = "4A16C05F7F7E58EF657A6CA1B8182ABE", hash_generated_method = "76CC5F1B3E419B00AD91A876B2F16A4A")
    
@Override
    public Drawable mutate() {
        if (!mMutated && super.mutate() == this) {
            mShapeState.mPaint = new Paint(mShapeState.mPaint);
            mShapeState.mPadding = new Rect(mShapeState.mPadding);
            try {
                mShapeState.mShape = mShapeState.mShape.clone();
            } catch (CloneNotSupportedException e) {
                return null;
            }
            mMutated = true;
        }
        return this;
    }
    
    final static class ShapeState extends ConstantState {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:12.699 -0500", hash_original_field = "9BFAF00848476277D36D9BA586984BA7", hash_generated_field = "9BFAF00848476277D36D9BA586984BA7")

        int mChangingConfigurations;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:12.701 -0500", hash_original_field = "0344A2D91EF1BCE652EE63EFC12EEAC9", hash_generated_field = "0344A2D91EF1BCE652EE63EFC12EEAC9")

        Paint mPaint;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:12.702 -0500", hash_original_field = "E7A888C0E804BDEECC7B681F4946AFDC", hash_generated_field = "E7A888C0E804BDEECC7B681F4946AFDC")

        Shape mShape;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:12.704 -0500", hash_original_field = "A053A94BBF9972B52A80E2FC510022E8", hash_generated_field = "A053A94BBF9972B52A80E2FC510022E8")

        Rect mPadding;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:12.706 -0500", hash_original_field = "AAE27B48F9D50812AABD238DAF78161A", hash_generated_field = "AAE27B48F9D50812AABD238DAF78161A")

        int mIntrinsicWidth;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:12.708 -0500", hash_original_field = "72B37F3E39E1F9B80F01AF0004B418D7", hash_generated_field = "72B37F3E39E1F9B80F01AF0004B418D7")

        int mIntrinsicHeight;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:12.711 -0500", hash_original_field = "A6B19F1E237A801306F5C3BB6F56FD1D", hash_generated_field = "A6B19F1E237A801306F5C3BB6F56FD1D")

        int mAlpha = 255;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:12.713 -0500", hash_original_field = "ADCB4599C69CB10A0B4150CAF65EDF82", hash_generated_field = "ADCB4599C69CB10A0B4150CAF65EDF82")

        ShaderFactory mShaderFactory;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:12.716 -0500", hash_original_method = "EFBED6F0CFE384FE09150C9B37976B1A", hash_generated_method = "EFBED6F0CFE384FE09150C9B37976B1A")
        
ShapeState(ShapeState orig) {
            if (orig != null) {
                mPaint = orig.mPaint;
                mShape = orig.mShape;
                mPadding = orig.mPadding;
                mIntrinsicWidth = orig.mIntrinsicWidth;
                mIntrinsicHeight = orig.mIntrinsicHeight;
                mAlpha = orig.mAlpha;
                mShaderFactory = orig.mShaderFactory;
            } else {
                mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
            }
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:12.718 -0500", hash_original_method = "712D1F78574D9DF109190A3CBF508567", hash_generated_method = "D8DCF2361BEA40070800C3ACFFC66541")
        
@Override
        public Drawable newDrawable() {
            return new ShapeDrawable(this);
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:12.720 -0500", hash_original_method = "7ABD019570C442758FC9C41DDD5AE24E", hash_generated_method = "D9506BB771184D41749D90BE37A1FF4C")
        
@Override
        public Drawable newDrawable(Resources res) {
            return new ShapeDrawable(this);
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:12.723 -0500", hash_original_method = "9E7D7C67EAC365FF19BD4971762612A5", hash_generated_method = "3AB30668ED270F2EDF2E0129C706FE4D")
        
@Override
        public int getChangingConfigurations() {
            return mChangingConfigurations;
        }
        
    }
    
    public static abstract class ShaderFactory {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.650 -0400", hash_original_method = "3BAAD89D982163CC2C371B74D92AB9C1", hash_generated_method = "3BAAD89D982163CC2C371B74D92AB9C1")
        public ShaderFactory ()
        {
            //Synthesized constructor
        }
        /**
         * Returns the Shader to be drawn when a Drawable is drawn.
         * The dimensions of the Drawable are passed because they may be needed
         * to adjust how the Shader is configured for drawing.
         * This is called by ShapeDrawable.setShape().
         * 
         * @param width  the width of the Drawable being drawn
         * @param height the heigh of the Drawable being drawn
         * @return       the Shader to be drawn
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:12.728 -0500", hash_original_method = "92C4F993B99331086798131F62C354D9", hash_generated_method = "D4216D414103AB0911F28C0ECC4A5161")
        
public abstract Shader resize(int width, int height);
        
    }
    
}

