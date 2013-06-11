package android.graphics.drawable;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.157 -0400", hash_original_method = "0D9B9D363D3461B1F66ABDB4BD10ADF4", hash_generated_method = "D4B830059384906A43FBF24F05F36CE7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ShapeDrawable() {
        this((ShapeState) null);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.157 -0400", hash_original_method = "F897BE84D7E0CD5527DF62F0C124D538", hash_generated_method = "E2B43C5C6339852C3A2F47D1AF031537")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ShapeDrawable(Shape s) {
        this((ShapeState) null);
        dsTaint.addTaint(s.dsTaint);
        mShapeState.mShape = s;
        // ---------- Original Method ----------
        //mShapeState.mShape = s;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.157 -0400", hash_original_method = "1601A6C313758A231E2593A310142434", hash_generated_method = "29973110939CA43DCA085FECEAC7BBCE")
    @DSModeled(DSC.SAFE)
    private ShapeDrawable(ShapeState state) {
        dsTaint.addTaint(state.dsTaint);
        mShapeState = new ShapeState(state);
        // ---------- Original Method ----------
        //mShapeState = new ShapeState(state);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.158 -0400", hash_original_method = "93DF953391DA58A2026A871408A81498", hash_generated_method = "0BF59E9CF25C2D917D930A1DF9F1DE1B")
    @DSModeled(DSC.SAFE)
    public Shape getShape() {
        return (Shape)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mShapeState.mShape;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.158 -0400", hash_original_method = "91DE5C2C93AB9A1591999F92B24BB2F1", hash_generated_method = "E9B25041E19E9FE6EE87E1D9C033620D")
    @DSModeled(DSC.SAFE)
    public void setShape(Shape s) {
        dsTaint.addTaint(s.dsTaint);
        mShapeState.mShape = s;
        updateShape();
        // ---------- Original Method ----------
        //mShapeState.mShape = s;
        //updateShape();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.158 -0400", hash_original_method = "63480B19EB44379868D8321D7A96C7B7", hash_generated_method = "1485A9187464C3A7ECF165A366612B27")
    @DSModeled(DSC.SAFE)
    public void setShaderFactory(ShaderFactory fact) {
        dsTaint.addTaint(fact.dsTaint);
        mShapeState.mShaderFactory = fact;
        // ---------- Original Method ----------
        //mShapeState.mShaderFactory = fact;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.158 -0400", hash_original_method = "E65D8AF971F17EDFF075456EB259C0A6", hash_generated_method = "6F3F5B5B8488457C3144CAA9CDED317A")
    @DSModeled(DSC.SAFE)
    public ShaderFactory getShaderFactory() {
        return (ShaderFactory)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mShapeState.mShaderFactory;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.158 -0400", hash_original_method = "F97BA42DC4507A8A136D2774D1D1BA0E", hash_generated_method = "5740716FC51B06E6796CD0B24263C97B")
    @DSModeled(DSC.SAFE)
    public Paint getPaint() {
        return (Paint)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mShapeState.mPaint;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.158 -0400", hash_original_method = "B421F82679CD23EB7F3D507B70942FAD", hash_generated_method = "A0968AC287E88D7BD9C76129823D9E77")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.158 -0400", hash_original_method = "416AA9F2AA0561BA0C5710C29E641860", hash_generated_method = "A7E3BB2E11FD588A954620E899D636D0")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.158 -0400", hash_original_method = "0038E10CC04EA446FBCFE7542F8A245A", hash_generated_method = "4231F6A52EC0954549EDE4A8F6CDB79A")
    @DSModeled(DSC.SAFE)
    public void setIntrinsicWidth(int width) {
        dsTaint.addTaint(width);
        mShapeState.mIntrinsicWidth = width;
        invalidateSelf();
        // ---------- Original Method ----------
        //mShapeState.mIntrinsicWidth = width;
        //invalidateSelf();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.159 -0400", hash_original_method = "0D195260E9CE84B5EB7D22342052E56D", hash_generated_method = "6F2ECA305C76D26AF88A014A95F1B562")
    @DSModeled(DSC.SAFE)
    public void setIntrinsicHeight(int height) {
        dsTaint.addTaint(height);
        mShapeState.mIntrinsicHeight = height;
        invalidateSelf();
        // ---------- Original Method ----------
        //mShapeState.mIntrinsicHeight = height;
        //invalidateSelf();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.159 -0400", hash_original_method = "2BA24D2DFEB102D9B9B4478CA4BDB4E4", hash_generated_method = "D6F541E4A6B9E06EF44ADE2835C96595")
    @DSModeled(DSC.SAFE)
    @Override
    public int getIntrinsicWidth() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mShapeState.mIntrinsicWidth;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.159 -0400", hash_original_method = "A17CBC5FDAD1E989314B42A85C195659", hash_generated_method = "BCFE4B8A6EEF2BEC6EAEF83249EE3D46")
    @DSModeled(DSC.SAFE)
    @Override
    public int getIntrinsicHeight() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mShapeState.mIntrinsicHeight;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.159 -0400", hash_original_method = "57EA20106D2449A841F533A811E87EF0", hash_generated_method = "091B6D669F5E4958AC3471CB1A676FB2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean getPadding(Rect padding) {
        dsTaint.addTaint(padding.dsTaint);
        {
            padding.set(mShapeState.mPadding);
        } //End block
        {
            boolean var26681595319194856AEB3747307B6E08_1354592710 = (super.getPadding(padding));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.159 -0400", hash_original_method = "E383078E6D302FDDE500ADE293E90381", hash_generated_method = "74629D941D3AC7278175462048E573D1")
    private static int modulateAlpha(int paintAlpha, int alpha) {
        int scale = alpha + (alpha >>> 7);
        return paintAlpha * scale >>> 8;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.159 -0400", hash_original_method = "94C805D8D565AE05BF02DE9855C838FE", hash_generated_method = "46F0AD583813B6A6B22E8236B82ABA43")
    @DSModeled(DSC.SAFE)
    protected void onDraw(Shape shape, Canvas canvas, Paint paint) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(canvas.dsTaint);
        dsTaint.addTaint(paint.dsTaint);
        dsTaint.addTaint(shape.dsTaint);
        shape.draw(canvas, paint);
        // ---------- Original Method ----------
        //shape.draw(canvas, paint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.159 -0400", hash_original_method = "2D289F2C5870F3B95565E05840E163B8", hash_generated_method = "41B1EE8A6281812EBF580B17E7A146E8")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.160 -0400", hash_original_method = "DB1A6AE8DEB59FB8C1923E504575EFF9", hash_generated_method = "2AD86096165B8329F958EEDB13F2092E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getChangingConfigurations() {
        int var03C30E2DD78CE71D6B967BDA275B0525_1776483879 = (super.getChangingConfigurations()
                | mShapeState.mChangingConfigurations);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return super.getChangingConfigurations()
                //| mShapeState.mChangingConfigurations;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.160 -0400", hash_original_method = "6237C1F5A576324C3E69C30154E7DEFA", hash_generated_method = "CB95B8C2B87AA39B0975935348655E09")
    @DSModeled(DSC.SAFE)
    @Override
    public void setAlpha(int alpha) {
        dsTaint.addTaint(alpha);
        mShapeState.mAlpha = alpha;
        invalidateSelf();
        // ---------- Original Method ----------
        //mShapeState.mAlpha = alpha;
        //invalidateSelf();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.160 -0400", hash_original_method = "DD3A0AA7864766F7FA9D12D24B53719B", hash_generated_method = "E4A4ECC52C2FF05F655BB9627B184B8C")
    @DSModeled(DSC.SAFE)
    @Override
    public void setColorFilter(ColorFilter cf) {
        dsTaint.addTaint(cf.dsTaint);
        mShapeState.mPaint.setColorFilter(cf);
        invalidateSelf();
        // ---------- Original Method ----------
        //mShapeState.mPaint.setColorFilter(cf);
        //invalidateSelf();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.160 -0400", hash_original_method = "056406D5393D0B46C202324FAF95659D", hash_generated_method = "6790061D8571493A9B26FD99798B80A9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getOpacity() {
        {
            final Paint p;
            p = mShapeState.mPaint;
            {
                boolean var9572989EFAB64708D1AB2CADA0B7F390_1886181506 = (p.getXfermode() == null);
                {
                    final int alpha;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.160 -0400", hash_original_method = "3955BCB5252FAD61A7FDF156B0C32957", hash_generated_method = "DE601A66E069CC8505546C4461BFA6A9")
    @DSModeled(DSC.SAFE)
    @Override
    public void setDither(boolean dither) {
        dsTaint.addTaint(dither);
        mShapeState.mPaint.setDither(dither);
        invalidateSelf();
        // ---------- Original Method ----------
        //mShapeState.mPaint.setDither(dither);
        //invalidateSelf();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.160 -0400", hash_original_method = "E6B6299A3D5979543EAAC4DC6F8268D1", hash_generated_method = "F5DCFD5D0340C69783A26CF50E2A2418")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.161 -0400", hash_original_method = "FCE81D70334945C2A418AF4A55A47945", hash_generated_method = "26528A9919653FC8A600AD26E5023BBF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected boolean inflateTag(String name, Resources r, XmlPullParser parser,
            AttributeSet attrs) {
        dsTaint.addTaint(r.dsTaint);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(name);
        dsTaint.addTaint(parser.dsTaint);
        {
            boolean varC590E54E2D929B80732C65F42F4C39A6_927092525 = ("padding".equals(name));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.161 -0400", hash_original_method = "5F3462BA297EEEB891A1F24F05317325", hash_generated_method = "646FAFB8A1C5DD2702F39A07AD71E8B8")
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
        final int outerDepth;
        outerDepth = parser.getDepth();
        {
            boolean var49BAE650CF2F44016B0E4A15ECAD0A92_658597743 = ((type=parser.next()) != XmlPullParser.END_DOCUMENT
               && (type != XmlPullParser.END_TAG || parser.getDepth() > outerDepth));
            {
                final String name;
                name = parser.getName();
                {
                    boolean var35E72E680A0A661B0D620A4895DD21BC_2100375858 = (!inflateTag(name, r, parser, attrs));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.161 -0400", hash_original_method = "A8D04337EAFF1E34F1C3CFBFD3AD3EF7", hash_generated_method = "0D5945A9B72082C28E90E34A92309E2E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void updateShape() {
        {
            final Rect r;
            r = getBounds();
            final int w;
            w = r.width();
            final int h;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.161 -0400", hash_original_method = "A9816EFD17AF344D0CD39D6855E6F73A", hash_generated_method = "8D859A423468F7A4CC3142FCCFA44B43")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ConstantState getConstantState() {
        mShapeState.mChangingConfigurations = getChangingConfigurations();
        return (ConstantState)dsTaint.getTaint();
        // ---------- Original Method ----------
        //mShapeState.mChangingConfigurations = getChangingConfigurations();
        //return mShapeState;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.162 -0400", hash_original_method = "4A16C05F7F7E58EF657A6CA1B8182ABE", hash_generated_method = "FB272C55E3B2345DBD94FA7A852C1BB3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Drawable mutate() {
        {
            boolean varC94B19053599294E7944C8C841976773_956143923 = (!mMutated && super.mutate() == this);
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.162 -0400", hash_original_method = "EFBED6F0CFE384FE09150C9B37976B1A", hash_generated_method = "1C596FAB185BE3505AAD23B2ECB1888D")
        @DSModeled(DSC.SAFE)
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.162 -0400", hash_original_method = "712D1F78574D9DF109190A3CBF508567", hash_generated_method = "40A1C4FD7ED93101169D4CF11719B296")
        @DSModeled(DSC.SAFE)
        @Override
        public Drawable newDrawable() {
            return (Drawable)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new ShapeDrawable(this);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.162 -0400", hash_original_method = "7ABD019570C442758FC9C41DDD5AE24E", hash_generated_method = "F596434C121DB7823480F569044A40E9")
        @DSModeled(DSC.SAFE)
        @Override
        public Drawable newDrawable(Resources res) {
            dsTaint.addTaint(res.dsTaint);
            return (Drawable)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new ShapeDrawable(this);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.162 -0400", hash_original_method = "9E7D7C67EAC365FF19BD4971762612A5", hash_generated_method = "2D59F41488F7278F18877F131EF0D371")
        @DSModeled(DSC.SAFE)
        @Override
        public int getChangingConfigurations() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return mChangingConfigurations;
        }

        
    }


    
    public static abstract class ShaderFactory {
        
        public abstract Shader resize(int width, int height);

        
    }


    
}


