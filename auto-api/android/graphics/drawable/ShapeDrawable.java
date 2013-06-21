package android.graphics.drawable;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.graphics.*;
import android.graphics.drawable.shapes.Shape;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import java.io.IOException;

public class ShapeDrawable extends Drawable {
    private ShapeState mShapeState;
    private boolean mMutated;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.643 -0400", hash_original_method = "0D9B9D363D3461B1F66ABDB4BD10ADF4", hash_generated_method = "F8142F9CA4A2ED9C1A4C2A61C668E2C1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ShapeDrawable() {
        this((ShapeState) null);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.644 -0400", hash_original_method = "F897BE84D7E0CD5527DF62F0C124D538", hash_generated_method = "9012E309C2C5DB3A20584AA2A2AB88A3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ShapeDrawable(Shape s) {
        this((ShapeState) null);
        dsTaint.addTaint(s.dsTaint);
        mShapeState.mShape = s;
        // ---------- Original Method ----------
        //mShapeState.mShape = s;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.644 -0400", hash_original_method = "1601A6C313758A231E2593A310142434", hash_generated_method = "913948943E5CE0EDC36F842806062A8F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private ShapeDrawable(ShapeState state) {
        dsTaint.addTaint(state.dsTaint);
        mShapeState = new ShapeState(state);
        // ---------- Original Method ----------
        //mShapeState = new ShapeState(state);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.645 -0400", hash_original_method = "93DF953391DA58A2026A871408A81498", hash_generated_method = "FC560504E392A0D0ED4E34ED89B19EFC")
    @DSModeled(DSC.SAFE)
    public Shape getShape() {
        return (Shape)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mShapeState.mShape;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.646 -0400", hash_original_method = "91DE5C2C93AB9A1591999F92B24BB2F1", hash_generated_method = "30E37ADC35C7240E43A0E4BBDA132BE8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setShape(Shape s) {
        dsTaint.addTaint(s.dsTaint);
        mShapeState.mShape = s;
        updateShape();
        // ---------- Original Method ----------
        //mShapeState.mShape = s;
        //updateShape();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.648 -0400", hash_original_method = "63480B19EB44379868D8321D7A96C7B7", hash_generated_method = "254E3A07534EA826F80866AC44E6F474")
    @DSModeled(DSC.SAFE)
    public void setShaderFactory(ShaderFactory fact) {
        dsTaint.addTaint(fact.dsTaint);
        mShapeState.mShaderFactory = fact;
        // ---------- Original Method ----------
        //mShapeState.mShaderFactory = fact;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.648 -0400", hash_original_method = "E65D8AF971F17EDFF075456EB259C0A6", hash_generated_method = "D17E712535855E74820FF5B51057F828")
    @DSModeled(DSC.SAFE)
    public ShaderFactory getShaderFactory() {
        return (ShaderFactory)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mShapeState.mShaderFactory;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.648 -0400", hash_original_method = "F97BA42DC4507A8A136D2774D1D1BA0E", hash_generated_method = "D4E6AC1848041EFE56BC7C112B6D0AD2")
    @DSModeled(DSC.SAFE)
    public Paint getPaint() {
        return (Paint)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mShapeState.mPaint;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.649 -0400", hash_original_method = "B421F82679CD23EB7F3D507B70942FAD", hash_generated_method = "5E9839338FE2D18CECF1853169D5CD72")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setPadding(int left, int top, int right, int bottom) {
        dsTaint.addTaint(bottom);
        dsTaint.addTaint(left);
        dsTaint.addTaint(right);
        dsTaint.addTaint(top);
        {
            mShapeState.mPadding = null;
        } //End block
        {
            {
                mShapeState.mPadding = new Rect();
            } //End block
            mShapeState.mPadding.set(left, top, right, bottom);
        } //End block
        invalidateSelf();
        // ---------- Original Method ----------
        //if ((left | top | right | bottom) == 0) {
            //mShapeState.mPadding = null;
        //} else {
            //if (mShapeState.mPadding == null) {
                //mShapeState.mPadding = new Rect();
            //}
            //mShapeState.mPadding.set(left, top, right, bottom);
        //}
        //invalidateSelf();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.649 -0400", hash_original_method = "416AA9F2AA0561BA0C5710C29E641860", hash_generated_method = "0C07765D7FAF745F79154F4A7F9EBA4D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setPadding(Rect padding) {
        dsTaint.addTaint(padding.dsTaint);
        {
            mShapeState.mPadding = null;
        } //End block
        {
            {
                mShapeState.mPadding = new Rect();
            } //End block
            mShapeState.mPadding.set(padding);
        } //End block
        invalidateSelf();
        // ---------- Original Method ----------
        //if (padding == null) {
            //mShapeState.mPadding = null;
        //} else {
            //if (mShapeState.mPadding == null) {
                //mShapeState.mPadding = new Rect();
            //}
            //mShapeState.mPadding.set(padding);
        //}
        //invalidateSelf();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.649 -0400", hash_original_method = "0038E10CC04EA446FBCFE7542F8A245A", hash_generated_method = "28ABED543119FE4A41A17B0D24ADDF12")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setIntrinsicWidth(int width) {
        dsTaint.addTaint(width);
        mShapeState.mIntrinsicWidth = width;
        invalidateSelf();
        // ---------- Original Method ----------
        //mShapeState.mIntrinsicWidth = width;
        //invalidateSelf();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.650 -0400", hash_original_method = "0D195260E9CE84B5EB7D22342052E56D", hash_generated_method = "3F428AFC03BAE07447DBF0741E49726E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setIntrinsicHeight(int height) {
        dsTaint.addTaint(height);
        mShapeState.mIntrinsicHeight = height;
        invalidateSelf();
        // ---------- Original Method ----------
        //mShapeState.mIntrinsicHeight = height;
        //invalidateSelf();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.650 -0400", hash_original_method = "2BA24D2DFEB102D9B9B4478CA4BDB4E4", hash_generated_method = "9A84566C4C59C38D4017A2B50D64F48E")
    @DSModeled(DSC.SAFE)
    @Override
    public int getIntrinsicWidth() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mShapeState.mIntrinsicWidth;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.650 -0400", hash_original_method = "A17CBC5FDAD1E989314B42A85C195659", hash_generated_method = "AC1E69A42BC6549941CAA4C2FCCA2387")
    @DSModeled(DSC.SAFE)
    @Override
    public int getIntrinsicHeight() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mShapeState.mIntrinsicHeight;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.651 -0400", hash_original_method = "57EA20106D2449A841F533A811E87EF0", hash_generated_method = "06B1CBA9F0AE611CFF8E88ECB75BB642")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean getPadding(Rect padding) {
        dsTaint.addTaint(padding.dsTaint);
        {
            padding.set(mShapeState.mPadding);
        } //End block
        {
            boolean var26681595319194856AEB3747307B6E08_1446240556 = (super.getPadding(padding));
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mShapeState.mPadding != null) {
            //padding.set(mShapeState.mPadding);
            //return true;
        //} else {
            //return super.getPadding(padding);
        //}
    }

    
        private static int modulateAlpha(int paintAlpha, int alpha) {
        int scale = alpha + (alpha >>> 7);
        return paintAlpha * scale >>> 8;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.651 -0400", hash_original_method = "94C805D8D565AE05BF02DE9855C838FE", hash_generated_method = "403FCB3777EEE49329BE0762A3DFC265")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void onDraw(Shape shape, Canvas canvas, Paint paint) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(canvas.dsTaint);
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(shape.dsTaint);
        shape.draw(canvas, paint);
        // ---------- Original Method ----------
        //shape.draw(canvas, paint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.652 -0400", hash_original_method = "2D289F2C5870F3B95565E05840E163B8", hash_generated_method = "24C7F0B3B5AF091F6A0599858E42F385")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void draw(Canvas canvas) {
        dsTaint.addTaint(canvas.dsTaint);
        Rect r;
        r = getBounds();
        Paint paint;
        paint = mShapeState.mPaint;
        int prevAlpha;
        prevAlpha = paint.getAlpha();
        paint.setAlpha(modulateAlpha(prevAlpha, mShapeState.mAlpha));
        {
            int count;
            count = canvas.save();
            canvas.translate(r.left, r.top);
            onDraw(mShapeState.mShape, canvas, paint);
            canvas.restoreToCount(count);
        } //End block
        {
            canvas.drawRect(r, paint);
        } //End block
        paint.setAlpha(prevAlpha);
        // ---------- Original Method ----------
        //Rect r = getBounds();
        //Paint paint = mShapeState.mPaint;
        //int prevAlpha = paint.getAlpha();
        //paint.setAlpha(modulateAlpha(prevAlpha, mShapeState.mAlpha));
        //if (mShapeState.mShape != null) {
            //int count = canvas.save();
            //canvas.translate(r.left, r.top);
            //onDraw(mShapeState.mShape, canvas, paint);
            //canvas.restoreToCount(count);
        //} else {
            //canvas.drawRect(r, paint);
        //}
        //paint.setAlpha(prevAlpha);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.652 -0400", hash_original_method = "DB1A6AE8DEB59FB8C1923E504575EFF9", hash_generated_method = "F9FD772EF5A95EFD919B05B0026FE971")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getChangingConfigurations() {
        int var03C30E2DD78CE71D6B967BDA275B0525_1748351751 = (super.getChangingConfigurations()
                | mShapeState.mChangingConfigurations);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return super.getChangingConfigurations()
                //| mShapeState.mChangingConfigurations;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.652 -0400", hash_original_method = "6237C1F5A576324C3E69C30154E7DEFA", hash_generated_method = "8CC59FBA665F8B377065C18F06AD8E74")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setAlpha(int alpha) {
        dsTaint.addTaint(alpha);
        mShapeState.mAlpha = alpha;
        invalidateSelf();
        // ---------- Original Method ----------
        //mShapeState.mAlpha = alpha;
        //invalidateSelf();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.653 -0400", hash_original_method = "DD3A0AA7864766F7FA9D12D24B53719B", hash_generated_method = "B001678C89E2278714FB550649231A0C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setColorFilter(ColorFilter cf) {
        dsTaint.addTaint(cf.dsTaint);
        mShapeState.mPaint.setColorFilter(cf);
        invalidateSelf();
        // ---------- Original Method ----------
        //mShapeState.mPaint.setColorFilter(cf);
        //invalidateSelf();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.653 -0400", hash_original_method = "056406D5393D0B46C202324FAF95659D", hash_generated_method = "0D643996166ABB5B11001CAA1DF4E55F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getOpacity() {
        {
            Paint p;
            p = mShapeState.mPaint;
            {
                boolean var9572989EFAB64708D1AB2CADA0B7F390_2062680003 = (p.getXfermode() == null);
                {
                    int alpha;
                    alpha = p.getAlpha();
                } //End block
            } //End collapsed parenthetic
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (mShapeState.mShape == null) {
            //final Paint p = mShapeState.mPaint;
            //if (p.getXfermode() == null) {
                //final int alpha = p.getAlpha();
                //if (alpha == 0) {
                    //return PixelFormat.TRANSPARENT;
                //}
                //if (alpha == 255) {
                    //return PixelFormat.OPAQUE;
                //}
            //}
        //}
        //return PixelFormat.TRANSLUCENT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.654 -0400", hash_original_method = "3955BCB5252FAD61A7FDF156B0C32957", hash_generated_method = "4CE7EFE19E4FDC0490CAA99569395B3C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setDither(boolean dither) {
        dsTaint.addTaint(dither);
        mShapeState.mPaint.setDither(dither);
        invalidateSelf();
        // ---------- Original Method ----------
        //mShapeState.mPaint.setDither(dither);
        //invalidateSelf();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.654 -0400", hash_original_method = "E6B6299A3D5979543EAAC4DC6F8268D1", hash_generated_method = "067E423F5B6A93C0ED14C8B9CB89CC4E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onBoundsChange(Rect bounds) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(bounds.dsTaint);
        super.onBoundsChange(bounds);
        updateShape();
        // ---------- Original Method ----------
        //super.onBoundsChange(bounds);
        //updateShape();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.654 -0400", hash_original_method = "FCE81D70334945C2A418AF4A55A47945", hash_generated_method = "CB40F619E80A0768D3395EF1FF65726C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected boolean inflateTag(String name, Resources r, XmlPullParser parser,
            AttributeSet attrs) {
        dsTaint.addTaint(r.dsTaint);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(name);
        dsTaint.addTaint(parser.dsTaint);
        {
            boolean varC590E54E2D929B80732C65F42F4C39A6_146946769 = ("padding".equals(name));
            {
                TypedArray a;
                a = r.obtainAttributes(attrs,
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
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.655 -0400", hash_original_method = "5F3462BA297EEEB891A1F24F05317325", hash_generated_method = "541D3226E4B9844E28ECD6BFEA2DECE1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void inflate(Resources r, XmlPullParser parser, AttributeSet attrs) throws XmlPullParserException, IOException {
        dsTaint.addTaint(r.dsTaint);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(parser.dsTaint);
        super.inflate(r, parser, attrs);
        TypedArray a;
        a = r.obtainAttributes(attrs, com.android.internal.R.styleable.ShapeDrawable);
        int color;
        color = mShapeState.mPaint.getColor();
        color = a.getColor(com.android.internal.R.styleable.ShapeDrawable_color, color);
        mShapeState.mPaint.setColor(color);
        boolean dither;
        dither = a.getBoolean(com.android.internal.R.styleable.ShapeDrawable_dither, false);
        mShapeState.mPaint.setDither(dither);
        setIntrinsicWidth((int)
                a.getDimension(com.android.internal.R.styleable.ShapeDrawable_width, 0f));
        setIntrinsicHeight((int)
                a.getDimension(com.android.internal.R.styleable.ShapeDrawable_height, 0f));
        a.recycle();
        int type;
        int outerDepth;
        outerDepth = parser.getDepth();
        {
            boolean var49BAE650CF2F44016B0E4A15ECAD0A92_481065937 = ((type=parser.next()) != XmlPullParser.END_DOCUMENT
               && (type != XmlPullParser.END_TAG || parser.getDepth() > outerDepth));
            {
                String name;
                name = parser.getName();
                {
                    boolean var35E72E680A0A661B0D620A4895DD21BC_1803265115 = (!inflateTag(name, r, parser, attrs));
                    {
                        android.util.Log.w("drawable", "Unknown element: " + name +
                        " for ShapeDrawable " + this);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.655 -0400", hash_original_method = "A8D04337EAFF1E34F1C3CFBFD3AD3EF7", hash_generated_method = "0B144EEEEF820C0B7D001637CA588C6E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void updateShape() {
        {
            Rect r;
            r = getBounds();
            int w;
            w = r.width();
            int h;
            h = r.height();
            mShapeState.mShape.resize(w, h);
            {
                mShapeState.mPaint.setShader(mShapeState.mShaderFactory.resize(w, h));
            } //End block
        } //End block
        invalidateSelf();
        // ---------- Original Method ----------
        //if (mShapeState.mShape != null) {
            //final Rect r = getBounds();
            //final int w = r.width();
            //final int h = r.height();
            //mShapeState.mShape.resize(w, h);
            //if (mShapeState.mShaderFactory != null) {
                //mShapeState.mPaint.setShader(mShapeState.mShaderFactory.resize(w, h));
            //}
        //}
        //invalidateSelf();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.656 -0400", hash_original_method = "A9816EFD17AF344D0CD39D6855E6F73A", hash_generated_method = "8A4505AD81E2B5FADFF374581BFFA2B7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ConstantState getConstantState() {
        mShapeState.mChangingConfigurations = getChangingConfigurations();
        return (ConstantState)dsTaint.getTaint();
        // ---------- Original Method ----------
        //mShapeState.mChangingConfigurations = getChangingConfigurations();
        //return mShapeState;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.656 -0400", hash_original_method = "4A16C05F7F7E58EF657A6CA1B8182ABE", hash_generated_method = "0AF51B2919714FB47DA7333157D0554D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Drawable mutate() {
        {
            boolean varC94B19053599294E7944C8C841976773_755861341 = (!mMutated && super.mutate() == this);
            {
                mShapeState.mPaint = new Paint(mShapeState.mPaint);
                mShapeState.mPadding = new Rect(mShapeState.mPadding);
                try 
                {
                    mShapeState.mShape = mShapeState.mShape.clone();
                } //End block
                catch (CloneNotSupportedException e)
                { }
                mMutated = true;
            } //End block
        } //End collapsed parenthetic
        return (Drawable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (!mMutated && super.mutate() == this) {
            //mShapeState.mPaint = new Paint(mShapeState.mPaint);
            //mShapeState.mPadding = new Rect(mShapeState.mPadding);
            //try {
                //mShapeState.mShape = mShapeState.mShape.clone();
            //} catch (CloneNotSupportedException e) {
                //return null;
            //}
            //mMutated = true;
        //}
        //return this;
    }

    
    final static class ShapeState extends ConstantState {
        int mChangingConfigurations;
        Paint mPaint;
        Shape mShape;
        Rect mPadding;
        int mIntrinsicWidth;
        int mIntrinsicHeight;
        int mAlpha = 255;
        ShaderFactory mShaderFactory;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.657 -0400", hash_original_method = "EFBED6F0CFE384FE09150C9B37976B1A", hash_generated_method = "C7E5B387FFFD4CC8966FBCA57A043EC5")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         ShapeState(ShapeState orig) {
            dsTaint.addTaint(orig.dsTaint);
            {
                mPaint = orig.mPaint;
                mShape = orig.mShape;
                mPadding = orig.mPadding;
                mIntrinsicWidth = orig.mIntrinsicWidth;
                mIntrinsicHeight = orig.mIntrinsicHeight;
                mAlpha = orig.mAlpha;
                mShaderFactory = orig.mShaderFactory;
            } //End block
            {
                mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
            } //End block
            // ---------- Original Method ----------
            //if (orig != null) {
                //mPaint = orig.mPaint;
                //mShape = orig.mShape;
                //mPadding = orig.mPadding;
                //mIntrinsicWidth = orig.mIntrinsicWidth;
                //mIntrinsicHeight = orig.mIntrinsicHeight;
                //mAlpha = orig.mAlpha;
                //mShaderFactory = orig.mShaderFactory;
            //} else {
                //mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.657 -0400", hash_original_method = "712D1F78574D9DF109190A3CBF508567", hash_generated_method = "34A5E48473CEAE39DA4DA6AF9D7C4791")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Drawable newDrawable() {
            Drawable var737869E92406786153E1759F3AD9AD91_963490128 = (new ShapeDrawable(this));
            return (Drawable)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new ShapeDrawable(this);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.657 -0400", hash_original_method = "7ABD019570C442758FC9C41DDD5AE24E", hash_generated_method = "49FCC9CB48CF48134F769BC0F04EF10B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Drawable newDrawable(Resources res) {
            dsTaint.addTaint(res.dsTaint);
            Drawable var737869E92406786153E1759F3AD9AD91_1706533575 = (new ShapeDrawable(this));
            return (Drawable)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new ShapeDrawable(this);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.657 -0400", hash_original_method = "9E7D7C67EAC365FF19BD4971762612A5", hash_generated_method = "36011B0CFA5B1C48E438EB66BB35159E")
        @DSModeled(DSC.SAFE)
        @Override
        public int getChangingConfigurations() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return mChangingConfigurations;
        }

        
    }


    
    public static abstract class ShaderFactory {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.657 -0400", hash_original_method = "36E153B0B88619C2432265166362C8F7", hash_generated_method = "36E153B0B88619C2432265166362C8F7")
                public ShaderFactory ()
        {
        }


        public abstract Shader resize(int width, int height);

        
    }


    
}

