package android.graphics.drawable;

// Droidsafe Imports
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
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class ShapeDrawable extends Drawable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.617 -0400", hash_original_field = "F650B6D51E8A0558B8CDC9DB09FD9330", hash_generated_field = "E775880DE66EC067EFB70E829A0DB9BA")

    private ShapeState mShapeState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.618 -0400", hash_original_field = "9FB80C30383848C8D006680B5F3BDAF9", hash_generated_field = "5CA5A1EF3CAA45117BCACBC34EF05952")

    private boolean mMutated;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.618 -0400", hash_original_method = "0D9B9D363D3461B1F66ABDB4BD10ADF4", hash_generated_method = "F8142F9CA4A2ED9C1A4C2A61C668E2C1")
    public  ShapeDrawable() {
        this((ShapeState) null);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.618 -0400", hash_original_method = "F897BE84D7E0CD5527DF62F0C124D538", hash_generated_method = "50727A759836F61C98F8262C81B37DE0")
    public  ShapeDrawable(Shape s) {
        this((ShapeState) null);
        mShapeState.mShape = s;
        // ---------- Original Method ----------
        //mShapeState.mShape = s;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.619 -0400", hash_original_method = "1601A6C313758A231E2593A310142434", hash_generated_method = "BC1A7556F13C9F16471EEF9C585D7FC3")
    private  ShapeDrawable(ShapeState state) {
        mShapeState = new ShapeState(state);
        // ---------- Original Method ----------
        //mShapeState = new ShapeState(state);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.619 -0400", hash_original_method = "93DF953391DA58A2026A871408A81498", hash_generated_method = "4B4BD78D99AF54F1EEABBCBC0FF5AA0B")
    public Shape getShape() {
Shape varB4C8C6EA3F6528C6F09F65D2033CC554_437299654 =         mShapeState.mShape;
        varB4C8C6EA3F6528C6F09F65D2033CC554_437299654.addTaint(taint);
        return varB4C8C6EA3F6528C6F09F65D2033CC554_437299654;
        // ---------- Original Method ----------
        //return mShapeState.mShape;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.620 -0400", hash_original_method = "91DE5C2C93AB9A1591999F92B24BB2F1", hash_generated_method = "333245D43C3894C20A8F2638360949CC")
    public void setShape(Shape s) {
        mShapeState.mShape = s;
        updateShape();
        // ---------- Original Method ----------
        //mShapeState.mShape = s;
        //updateShape();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.621 -0400", hash_original_method = "63480B19EB44379868D8321D7A96C7B7", hash_generated_method = "98C4B1E892C6B76796983BAC575AFE3D")
    public void setShaderFactory(ShaderFactory fact) {
        mShapeState.mShaderFactory = fact;
        // ---------- Original Method ----------
        //mShapeState.mShaderFactory = fact;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.622 -0400", hash_original_method = "E65D8AF971F17EDFF075456EB259C0A6", hash_generated_method = "E24D1BF24DA4083F438A00FD46150B0B")
    public ShaderFactory getShaderFactory() {
ShaderFactory varD1DBE3A07D52E789DC57C2239BB1AEF8_1477647975 =         mShapeState.mShaderFactory;
        varD1DBE3A07D52E789DC57C2239BB1AEF8_1477647975.addTaint(taint);
        return varD1DBE3A07D52E789DC57C2239BB1AEF8_1477647975;
        // ---------- Original Method ----------
        //return mShapeState.mShaderFactory;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.623 -0400", hash_original_method = "F97BA42DC4507A8A136D2774D1D1BA0E", hash_generated_method = "832919B5E8D54792160E3C7163D6B2DA")
    public Paint getPaint() {
Paint var84E707B3D661C8604D8EBE952CA760C8_203697972 =         mShapeState.mPaint;
        var84E707B3D661C8604D8EBE952CA760C8_203697972.addTaint(taint);
        return var84E707B3D661C8604D8EBE952CA760C8_203697972;
        // ---------- Original Method ----------
        //return mShapeState.mPaint;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.624 -0400", hash_original_method = "B421F82679CD23EB7F3D507B70942FAD", hash_generated_method = "5BFCBA4E0AA0FF8054034D3633B90213")
    public void setPadding(int left, int top, int right, int bottom) {
        addTaint(bottom);
        addTaint(right);
        addTaint(top);
        addTaint(left);
        if((left | top | right | bottom) == 0)        
        {
            mShapeState.mPadding = null;
        } //End block
        else
        {
            if(mShapeState.mPadding == null)            
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.625 -0400", hash_original_method = "416AA9F2AA0561BA0C5710C29E641860", hash_generated_method = "2E559BCFCB70602132A2EC5ADA3C0E23")
    public void setPadding(Rect padding) {
        addTaint(padding.getTaint());
        if(padding == null)        
        {
            mShapeState.mPadding = null;
        } //End block
        else
        {
            if(mShapeState.mPadding == null)            
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.627 -0400", hash_original_method = "0038E10CC04EA446FBCFE7542F8A245A", hash_generated_method = "EF946B1AE5C472004D43406542B29B7C")
    public void setIntrinsicWidth(int width) {
        mShapeState.mIntrinsicWidth = width;
        invalidateSelf();
        // ---------- Original Method ----------
        //mShapeState.mIntrinsicWidth = width;
        //invalidateSelf();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.628 -0400", hash_original_method = "0D195260E9CE84B5EB7D22342052E56D", hash_generated_method = "E2059B6FDC44B6E7A4C61309E7061A2F")
    public void setIntrinsicHeight(int height) {
        mShapeState.mIntrinsicHeight = height;
        invalidateSelf();
        // ---------- Original Method ----------
        //mShapeState.mIntrinsicHeight = height;
        //invalidateSelf();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.629 -0400", hash_original_method = "2BA24D2DFEB102D9B9B4478CA4BDB4E4", hash_generated_method = "13B67015123E177056C9096B9E4D94A2")
    @Override
    public int getIntrinsicWidth() {
        int var1C0E55098D07A79D047913167C81E546_1876441143 = (mShapeState.mIntrinsicWidth);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_878556251 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_878556251;
        // ---------- Original Method ----------
        //return mShapeState.mIntrinsicWidth;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.629 -0400", hash_original_method = "A17CBC5FDAD1E989314B42A85C195659", hash_generated_method = "440DDA67202A44F4698FC5A6CD232259")
    @Override
    public int getIntrinsicHeight() {
        int var1A2D21D52063C7CDA92BB7E0460F7F41_211021072 = (mShapeState.mIntrinsicHeight);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_332930333 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_332930333;
        // ---------- Original Method ----------
        //return mShapeState.mIntrinsicHeight;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.631 -0400", hash_original_method = "57EA20106D2449A841F533A811E87EF0", hash_generated_method = "0AD4E8010E13EC011E9F4D6F01484F5C")
    @Override
    public boolean getPadding(Rect padding) {
        addTaint(padding.getTaint());
        if(mShapeState.mPadding != null)        
        {
            padding.set(mShapeState.mPadding);
            boolean varB326B5062B2F0E69046810717534CB09_995766917 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1217658850 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1217658850;
        } //End block
        else
        {
            boolean varBEE4EC8926815DF7C66351028FE91FD2_1646160993 = (super.getPadding(padding));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1653981848 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1653981848;
        } //End block
        // ---------- Original Method ----------
        //if (mShapeState.mPadding != null) {
            //padding.set(mShapeState.mPadding);
            //return true;
        //} else {
            //return super.getPadding(padding);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    private static int modulateAlpha(int paintAlpha, int alpha) {
        int scale = alpha + (alpha >>> 7);
        return paintAlpha * scale >>> 8;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.633 -0400", hash_original_method = "94C805D8D565AE05BF02DE9855C838FE", hash_generated_method = "42CD3C66C441118E3BA4A2D4CB258AE6")
    protected void onDraw(Shape shape, Canvas canvas, Paint paint) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(paint.getTaint());
        addTaint(canvas.getTaint());
        addTaint(shape.getTaint());
        shape.draw(canvas, paint);
        // ---------- Original Method ----------
        //shape.draw(canvas, paint);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.634 -0400", hash_original_method = "2D289F2C5870F3B95565E05840E163B8", hash_generated_method = "A5D43E00008BFD98EEEFF2F8A8EBF694")
    @Override
    public void draw(Canvas canvas) {
        addTaint(canvas.getTaint());
        Rect r = getBounds();
        Paint paint = mShapeState.mPaint;
        int prevAlpha = paint.getAlpha();
        paint.setAlpha(modulateAlpha(prevAlpha, mShapeState.mAlpha));
        if(mShapeState.mShape != null)        
        {
            int count = canvas.save();
            canvas.translate(r.left, r.top);
            onDraw(mShapeState.mShape, canvas, paint);
            canvas.restoreToCount(count);
        } //End block
        else
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.635 -0400", hash_original_method = "DB1A6AE8DEB59FB8C1923E504575EFF9", hash_generated_method = "0E48EDD158D74442C3EFD5B5C96C0882")
    @Override
    public int getChangingConfigurations() {
        int var64986209AC5154099F39E129F1EE5652_1968337473 = (super.getChangingConfigurations()
                | mShapeState.mChangingConfigurations);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_720330346 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_720330346;
        // ---------- Original Method ----------
        //return super.getChangingConfigurations()
                //| mShapeState.mChangingConfigurations;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.636 -0400", hash_original_method = "6237C1F5A576324C3E69C30154E7DEFA", hash_generated_method = "7C2A4ABB1BBCDA7A1D9BBEFF61A8CB16")
    @Override
    public void setAlpha(int alpha) {
        mShapeState.mAlpha = alpha;
        invalidateSelf();
        // ---------- Original Method ----------
        //mShapeState.mAlpha = alpha;
        //invalidateSelf();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.637 -0400", hash_original_method = "DD3A0AA7864766F7FA9D12D24B53719B", hash_generated_method = "47FC6706D5537BDBAB1000D6712648C5")
    @Override
    public void setColorFilter(ColorFilter cf) {
        addTaint(cf.getTaint());
        mShapeState.mPaint.setColorFilter(cf);
        invalidateSelf();
        // ---------- Original Method ----------
        //mShapeState.mPaint.setColorFilter(cf);
        //invalidateSelf();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.638 -0400", hash_original_method = "056406D5393D0B46C202324FAF95659D", hash_generated_method = "975DB600ACAF468B1AD1CC13799A8F44")
    @Override
    public int getOpacity() {
        if(mShapeState.mShape == null)        
        {
            final Paint p = mShapeState.mPaint;
            if(p.getXfermode() == null)            
            {
                final int alpha = p.getAlpha();
                if(alpha == 0)                
                {
                    int varBD6099BC0B51C182C215E6BE157DABC3_1782772501 = (PixelFormat.TRANSPARENT);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1812962165 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1812962165;
                } //End block
                if(alpha == 255)                
                {
                    int var159D51265084B78CCBC493D119AF4EAE_1814147412 = (PixelFormat.OPAQUE);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_941938444 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_941938444;
                } //End block
            } //End block
        } //End block
        int var26C79996E92FCFBDC98A49C80BC91AD0_647563634 = (PixelFormat.TRANSLUCENT);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1951237863 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1951237863;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.639 -0400", hash_original_method = "3955BCB5252FAD61A7FDF156B0C32957", hash_generated_method = "9A8A10ADA1E500118A82436880F0B5D0")
    @Override
    public void setDither(boolean dither) {
        addTaint(dither);
        mShapeState.mPaint.setDither(dither);
        invalidateSelf();
        // ---------- Original Method ----------
        //mShapeState.mPaint.setDither(dither);
        //invalidateSelf();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.640 -0400", hash_original_method = "E6B6299A3D5979543EAAC4DC6F8268D1", hash_generated_method = "F709DED70FFDAFB231104343A60798E3")
    @Override
    protected void onBoundsChange(Rect bounds) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(bounds.getTaint());
        super.onBoundsChange(bounds);
        updateShape();
        // ---------- Original Method ----------
        //super.onBoundsChange(bounds);
        //updateShape();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.641 -0400", hash_original_method = "FCE81D70334945C2A418AF4A55A47945", hash_generated_method = "14D1CA13ECF45009594A89E310648F5C")
    protected boolean inflateTag(String name, Resources r, XmlPullParser parser,
            AttributeSet attrs) {
        addTaint(attrs.getTaint());
        addTaint(parser.getTaint());
        addTaint(r.getTaint());
        addTaint(name.getTaint());
        if("padding".equals(name))        
        {
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
            boolean varB326B5062B2F0E69046810717534CB09_1280268527 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1304762739 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1304762739;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_910465542 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1974923657 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1974923657;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.642 -0400", hash_original_method = "5F3462BA297EEEB891A1F24F05317325", hash_generated_method = "55ACA34527C4F0E05DD1738200217529")
    @Override
    public void inflate(Resources r, XmlPullParser parser, AttributeSet attrs) throws XmlPullParserException, IOException {
        addTaint(attrs.getTaint());
        addTaint(parser.getTaint());
        addTaint(r.getTaint());
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
        while
((type=parser.next()) != XmlPullParser.END_DOCUMENT
               && (type != XmlPullParser.END_TAG || parser.getDepth() > outerDepth))        
        {
            if(type != XmlPullParser.START_TAG)            
            {
                continue;
            } //End block
            final String name = parser.getName();
            if(!inflateTag(name, r, parser, attrs))            
            {
                android.util.Log.w("drawable", "Unknown element: " + name +
                        " for ShapeDrawable " + this);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.643 -0400", hash_original_method = "A8D04337EAFF1E34F1C3CFBFD3AD3EF7", hash_generated_method = "833F1E4DB6399B6277C1891A22B18BC5")
    private void updateShape() {
        if(mShapeState.mShape != null)        
        {
            final Rect r = getBounds();
            final int w = r.width();
            final int h = r.height();
            mShapeState.mShape.resize(w, h);
            if(mShapeState.mShaderFactory != null)            
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.644 -0400", hash_original_method = "A9816EFD17AF344D0CD39D6855E6F73A", hash_generated_method = "39EB3C25B22FD35EE2E118D0B84E193D")
    @Override
    public ConstantState getConstantState() {
        mShapeState.mChangingConfigurations = getChangingConfigurations();
ConstantState var8F8B768EB5C4441F7970DBD662AC7E9B_735361585 =         mShapeState;
        var8F8B768EB5C4441F7970DBD662AC7E9B_735361585.addTaint(taint);
        return var8F8B768EB5C4441F7970DBD662AC7E9B_735361585;
        // ---------- Original Method ----------
        //mShapeState.mChangingConfigurations = getChangingConfigurations();
        //return mShapeState;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.645 -0400", hash_original_method = "4A16C05F7F7E58EF657A6CA1B8182ABE", hash_generated_method = "50EA8267969D4F52A6CE7934AA6804AC")
    @Override
    public Drawable mutate() {
        if(!mMutated && super.mutate() == this)        
        {
            mShapeState.mPaint = new Paint(mShapeState.mPaint);
            mShapeState.mPadding = new Rect(mShapeState.mPadding);
            try 
            {
                mShapeState.mShape = mShapeState.mShape.clone();
            } //End block
            catch (CloneNotSupportedException e)
            {
Drawable var540C13E9E156B687226421B24F2DF178_580135616 =                 null;
                var540C13E9E156B687226421B24F2DF178_580135616.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_580135616;
            } //End block
            mMutated = true;
        } //End block
Drawable var72A74007B2BE62B849F475C7BDA4658B_606832908 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_606832908.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_606832908;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.647 -0400", hash_original_field = "276E0645C4E2084773D0EB8C5576428C", hash_generated_field = "9BFAF00848476277D36D9BA586984BA7")

        int mChangingConfigurations;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.647 -0400", hash_original_field = "78E27F80AC0100441F897783EFA42851", hash_generated_field = "0344A2D91EF1BCE652EE63EFC12EEAC9")

        Paint mPaint;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.647 -0400", hash_original_field = "2926CB901374ACDDA1AEEBF2747A26F6", hash_generated_field = "E7A888C0E804BDEECC7B681F4946AFDC")

        Shape mShape;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.647 -0400", hash_original_field = "9AC2544B5F9B8F60AA16656C94B57A8E", hash_generated_field = "A053A94BBF9972B52A80E2FC510022E8")

        Rect mPadding;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.647 -0400", hash_original_field = "119DCE670C90F7AC3E6B6C08968A4DC8", hash_generated_field = "AAE27B48F9D50812AABD238DAF78161A")

        int mIntrinsicWidth;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.647 -0400", hash_original_field = "DFB49FFA7CD229538212E74A896D2963", hash_generated_field = "72B37F3E39E1F9B80F01AF0004B418D7")

        int mIntrinsicHeight;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.647 -0400", hash_original_field = "1439C01AF326A337A2401436745247DA", hash_generated_field = "A6B19F1E237A801306F5C3BB6F56FD1D")

        int mAlpha = 255;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.647 -0400", hash_original_field = "3F1C269B8DC8918282E82E3CC5AEEA3C", hash_generated_field = "ADCB4599C69CB10A0B4150CAF65EDF82")

        ShaderFactory mShaderFactory;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.649 -0400", hash_original_method = "EFBED6F0CFE384FE09150C9B37976B1A", hash_generated_method = "1BB92F41BFDC684970D22C18D2519AD9")
          ShapeState(ShapeState orig) {
            if(orig != null)            
            {
                mPaint = orig.mPaint;
                mShape = orig.mShape;
                mPadding = orig.mPadding;
                mIntrinsicWidth = orig.mIntrinsicWidth;
                mIntrinsicHeight = orig.mIntrinsicHeight;
                mAlpha = orig.mAlpha;
                mShaderFactory = orig.mShaderFactory;
            } //End block
            else
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.649 -0400", hash_original_method = "712D1F78574D9DF109190A3CBF508567", hash_generated_method = "E0106487BBA593011B2D426C1C02FCC0")
        @Override
        public Drawable newDrawable() {
Drawable var70B51CA0E2F73DDDAEA1517FCDBBB53D_470995972 =             new ShapeDrawable(this);
            var70B51CA0E2F73DDDAEA1517FCDBBB53D_470995972.addTaint(taint);
            return var70B51CA0E2F73DDDAEA1517FCDBBB53D_470995972;
            // ---------- Original Method ----------
            //return new ShapeDrawable(this);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.650 -0400", hash_original_method = "7ABD019570C442758FC9C41DDD5AE24E", hash_generated_method = "845AB95E27F0069A4F8428B8F22A6338")
        @Override
        public Drawable newDrawable(Resources res) {
            addTaint(res.getTaint());
Drawable var70B51CA0E2F73DDDAEA1517FCDBBB53D_1592718143 =             new ShapeDrawable(this);
            var70B51CA0E2F73DDDAEA1517FCDBBB53D_1592718143.addTaint(taint);
            return var70B51CA0E2F73DDDAEA1517FCDBBB53D_1592718143;
            // ---------- Original Method ----------
            //return new ShapeDrawable(this);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.650 -0400", hash_original_method = "9E7D7C67EAC365FF19BD4971762612A5", hash_generated_method = "2EA23576EA7264B7E76222FD8BF74587")
        @Override
        public int getChangingConfigurations() {
            int var276E0645C4E2084773D0EB8C5576428C_2015032076 = (mChangingConfigurations);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1227213781 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1227213781;
            // ---------- Original Method ----------
            //return mChangingConfigurations;
        }

        
    }


    
    public static abstract class ShaderFactory {
        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.650 -0400", hash_original_method = "3BAAD89D982163CC2C371B74D92AB9C1", hash_generated_method = "3BAAD89D982163CC2C371B74D92AB9C1")
        public ShaderFactory ()
        {
            //Synthesized constructor
        }


        @DSModeled(DSC.SAFE)
        public abstract Shader resize(int width, int height);

        
    }


    
}

