package android.graphics.drawable;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.graphics.*;
import android.graphics.drawable.shapes.Shape;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import java.io.IOException;

public class ShapeDrawable extends Drawable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.753 -0400", hash_original_field = "F650B6D51E8A0558B8CDC9DB09FD9330", hash_generated_field = "E775880DE66EC067EFB70E829A0DB9BA")

    private ShapeState mShapeState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.753 -0400", hash_original_field = "9FB80C30383848C8D006680B5F3BDAF9", hash_generated_field = "5CA5A1EF3CAA45117BCACBC34EF05952")

    private boolean mMutated;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.753 -0400", hash_original_method = "0D9B9D363D3461B1F66ABDB4BD10ADF4", hash_generated_method = "F8142F9CA4A2ED9C1A4C2A61C668E2C1")
    public  ShapeDrawable() {
        this((ShapeState) null);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.754 -0400", hash_original_method = "F897BE84D7E0CD5527DF62F0C124D538", hash_generated_method = "50727A759836F61C98F8262C81B37DE0")
    public  ShapeDrawable(Shape s) {
        this((ShapeState) null);
        mShapeState.mShape = s;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.754 -0400", hash_original_method = "1601A6C313758A231E2593A310142434", hash_generated_method = "BC1A7556F13C9F16471EEF9C585D7FC3")
    private  ShapeDrawable(ShapeState state) {
        mShapeState = new ShapeState(state);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.754 -0400", hash_original_method = "93DF953391DA58A2026A871408A81498", hash_generated_method = "24DE6E3F368A8CF219FA8F7033FE9618")
    public Shape getShape() {
Shape varB4C8C6EA3F6528C6F09F65D2033CC554_92471459 =         mShapeState.mShape;
        varB4C8C6EA3F6528C6F09F65D2033CC554_92471459.addTaint(taint);
        return varB4C8C6EA3F6528C6F09F65D2033CC554_92471459;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.755 -0400", hash_original_method = "91DE5C2C93AB9A1591999F92B24BB2F1", hash_generated_method = "333245D43C3894C20A8F2638360949CC")
    public void setShape(Shape s) {
        mShapeState.mShape = s;
        updateShape();
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.755 -0400", hash_original_method = "63480B19EB44379868D8321D7A96C7B7", hash_generated_method = "98C4B1E892C6B76796983BAC575AFE3D")
    public void setShaderFactory(ShaderFactory fact) {
        mShapeState.mShaderFactory = fact;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.756 -0400", hash_original_method = "E65D8AF971F17EDFF075456EB259C0A6", hash_generated_method = "16F8FA0219A3CDF2790BEF17EA73D71D")
    public ShaderFactory getShaderFactory() {
ShaderFactory varD1DBE3A07D52E789DC57C2239BB1AEF8_397893299 =         mShapeState.mShaderFactory;
        varD1DBE3A07D52E789DC57C2239BB1AEF8_397893299.addTaint(taint);
        return varD1DBE3A07D52E789DC57C2239BB1AEF8_397893299;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.757 -0400", hash_original_method = "F97BA42DC4507A8A136D2774D1D1BA0E", hash_generated_method = "75962CF46C1C7F6EBAF92CFCA9DF063F")
    public Paint getPaint() {
Paint var84E707B3D661C8604D8EBE952CA760C8_82777195 =         mShapeState.mPaint;
        var84E707B3D661C8604D8EBE952CA760C8_82777195.addTaint(taint);
        return var84E707B3D661C8604D8EBE952CA760C8_82777195;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.758 -0400", hash_original_method = "B421F82679CD23EB7F3D507B70942FAD", hash_generated_method = "5BFCBA4E0AA0FF8054034D3633B90213")
    public void setPadding(int left, int top, int right, int bottom) {
        addTaint(bottom);
        addTaint(right);
        addTaint(top);
        addTaint(left);
    if((left | top | right | bottom) == 0)        
        {
            mShapeState.mPadding = null;
        } 
        else
        {
    if(mShapeState.mPadding == null)            
            {
                mShapeState.mPadding = new Rect();
            } 
            mShapeState.mPadding.set(left, top, right, bottom);
        } 
        invalidateSelf();
        
        
            
        
            
                
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.759 -0400", hash_original_method = "416AA9F2AA0561BA0C5710C29E641860", hash_generated_method = "2E559BCFCB70602132A2EC5ADA3C0E23")
    public void setPadding(Rect padding) {
        addTaint(padding.getTaint());
    if(padding == null)        
        {
            mShapeState.mPadding = null;
        } 
        else
        {
    if(mShapeState.mPadding == null)            
            {
                mShapeState.mPadding = new Rect();
            } 
            mShapeState.mPadding.set(padding);
        } 
        invalidateSelf();
        
        
            
        
            
                
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.759 -0400", hash_original_method = "0038E10CC04EA446FBCFE7542F8A245A", hash_generated_method = "EF946B1AE5C472004D43406542B29B7C")
    public void setIntrinsicWidth(int width) {
        mShapeState.mIntrinsicWidth = width;
        invalidateSelf();
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.760 -0400", hash_original_method = "0D195260E9CE84B5EB7D22342052E56D", hash_generated_method = "E2059B6FDC44B6E7A4C61309E7061A2F")
    public void setIntrinsicHeight(int height) {
        mShapeState.mIntrinsicHeight = height;
        invalidateSelf();
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.760 -0400", hash_original_method = "2BA24D2DFEB102D9B9B4478CA4BDB4E4", hash_generated_method = "6AABE9E2C707FCCC287400A05E76BCBE")
    @Override
    public int getIntrinsicWidth() {
        int var1C0E55098D07A79D047913167C81E546_1910204539 = (mShapeState.mIntrinsicWidth);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_22652146 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_22652146;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.760 -0400", hash_original_method = "A17CBC5FDAD1E989314B42A85C195659", hash_generated_method = "71C6815C668E2BFBB049A7032CE7CA16")
    @Override
    public int getIntrinsicHeight() {
        int var1A2D21D52063C7CDA92BB7E0460F7F41_145017279 = (mShapeState.mIntrinsicHeight);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_230919529 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_230919529;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.761 -0400", hash_original_method = "57EA20106D2449A841F533A811E87EF0", hash_generated_method = "EDCD45710EE36717FF8FAD627B94F972")
    @Override
    public boolean getPadding(Rect padding) {
        addTaint(padding.getTaint());
    if(mShapeState.mPadding != null)        
        {
            padding.set(mShapeState.mPadding);
            boolean varB326B5062B2F0E69046810717534CB09_1796482133 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1258750842 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1258750842;
        } 
        else
        {
            boolean varBEE4EC8926815DF7C66351028FE91FD2_1857129027 = (super.getPadding(padding));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1154590150 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1154590150;
        } 
        
        
            
            
        
            
        
    }

    
        @DSModeled(DSC.SAFE)
    private static int modulateAlpha(int paintAlpha, int alpha) {
        int scale = alpha + (alpha >>> 7);
        return paintAlpha * scale >>> 8;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.762 -0400", hash_original_method = "94C805D8D565AE05BF02DE9855C838FE", hash_generated_method = "42CD3C66C441118E3BA4A2D4CB258AE6")
    protected void onDraw(Shape shape, Canvas canvas, Paint paint) {
        
        addTaint(paint.getTaint());
        addTaint(canvas.getTaint());
        addTaint(shape.getTaint());
        shape.draw(canvas, paint);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.762 -0400", hash_original_method = "2D289F2C5870F3B95565E05840E163B8", hash_generated_method = "A5D43E00008BFD98EEEFF2F8A8EBF694")
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
        } 
        else
        {
            canvas.drawRect(r, paint);
        } 
        paint.setAlpha(prevAlpha);
        
        
        
        
        
        
            
            
            
            
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.763 -0400", hash_original_method = "DB1A6AE8DEB59FB8C1923E504575EFF9", hash_generated_method = "1C4BA2CCDC7D2E98CD90A4D8CA0E0F6A")
    @Override
    public int getChangingConfigurations() {
        int var64986209AC5154099F39E129F1EE5652_1234917960 = (super.getChangingConfigurations()
                | mShapeState.mChangingConfigurations);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_537059899 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_537059899;
        
        
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.763 -0400", hash_original_method = "6237C1F5A576324C3E69C30154E7DEFA", hash_generated_method = "7C2A4ABB1BBCDA7A1D9BBEFF61A8CB16")
    @Override
    public void setAlpha(int alpha) {
        mShapeState.mAlpha = alpha;
        invalidateSelf();
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.764 -0400", hash_original_method = "DD3A0AA7864766F7FA9D12D24B53719B", hash_generated_method = "47FC6706D5537BDBAB1000D6712648C5")
    @Override
    public void setColorFilter(ColorFilter cf) {
        addTaint(cf.getTaint());
        mShapeState.mPaint.setColorFilter(cf);
        invalidateSelf();
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.764 -0400", hash_original_method = "056406D5393D0B46C202324FAF95659D", hash_generated_method = "B2994FE85DAA75E8399A01C4070E7A47")
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
                    int varBD6099BC0B51C182C215E6BE157DABC3_1232954439 = (PixelFormat.TRANSPARENT);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1450138254 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1450138254;
                } 
    if(alpha == 255)                
                {
                    int var159D51265084B78CCBC493D119AF4EAE_285283779 = (PixelFormat.OPAQUE);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1510571871 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1510571871;
                } 
            } 
        } 
        int var26C79996E92FCFBDC98A49C80BC91AD0_1785162111 = (PixelFormat.TRANSLUCENT);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_317210083 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_317210083;
        
        
            
            
                
                
                    
                
                
                    
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.765 -0400", hash_original_method = "3955BCB5252FAD61A7FDF156B0C32957", hash_generated_method = "9A8A10ADA1E500118A82436880F0B5D0")
    @Override
    public void setDither(boolean dither) {
        addTaint(dither);
        mShapeState.mPaint.setDither(dither);
        invalidateSelf();
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.766 -0400", hash_original_method = "E6B6299A3D5979543EAAC4DC6F8268D1", hash_generated_method = "F709DED70FFDAFB231104343A60798E3")
    @Override
    protected void onBoundsChange(Rect bounds) {
        
        addTaint(bounds.getTaint());
        super.onBoundsChange(bounds);
        updateShape();
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.767 -0400", hash_original_method = "FCE81D70334945C2A418AF4A55A47945", hash_generated_method = "2A4624935E69C3127338C4FD9CB088BC")
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
            boolean varB326B5062B2F0E69046810717534CB09_416139215 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1666255354 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1666255354;
        } 
        boolean var68934A3E9455FA72420237EB05902327_1282498515 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1731807484 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1731807484;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.768 -0400", hash_original_method = "5F3462BA297EEEB891A1F24F05317325", hash_generated_method = "55ACA34527C4F0E05DD1738200217529")
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
            } 
            final String name = parser.getName();
    if(!inflateTag(name, r, parser, attrs))            
            {
                android.util.Log.w("drawable", "Unknown element: " + name +
                        " for ShapeDrawable " + this);
            } 
        } 
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.769 -0400", hash_original_method = "A8D04337EAFF1E34F1C3CFBFD3AD3EF7", hash_generated_method = "833F1E4DB6399B6277C1891A22B18BC5")
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
            } 
        } 
        invalidateSelf();
        
        
            
            
            
            
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.770 -0400", hash_original_method = "A9816EFD17AF344D0CD39D6855E6F73A", hash_generated_method = "67C3E4CE2912B27B01FF17CAD5FD6BDB")
    @Override
    public ConstantState getConstantState() {
        mShapeState.mChangingConfigurations = getChangingConfigurations();
ConstantState var8F8B768EB5C4441F7970DBD662AC7E9B_571529817 =         mShapeState;
        var8F8B768EB5C4441F7970DBD662AC7E9B_571529817.addTaint(taint);
        return var8F8B768EB5C4441F7970DBD662AC7E9B_571529817;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.771 -0400", hash_original_method = "4A16C05F7F7E58EF657A6CA1B8182ABE", hash_generated_method = "0E7EDB52B03B06DF8188D401144EB63C")
    @Override
    public Drawable mutate() {
    if(!mMutated && super.mutate() == this)        
        {
            mShapeState.mPaint = new Paint(mShapeState.mPaint);
            mShapeState.mPadding = new Rect(mShapeState.mPadding);
            try 
            {
                mShapeState.mShape = mShapeState.mShape.clone();
            } 
            catch (CloneNotSupportedException e)
            {
Drawable var540C13E9E156B687226421B24F2DF178_262431778 =                 null;
                var540C13E9E156B687226421B24F2DF178_262431778.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_262431778;
            } 
            mMutated = true;
        } 
Drawable var72A74007B2BE62B849F475C7BDA4658B_1262699500 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1262699500.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1262699500;
        
        
            
            
            
                
            
                
            
            
        
        
    }

    
    final static class ShapeState extends ConstantState {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.771 -0400", hash_original_field = "276E0645C4E2084773D0EB8C5576428C", hash_generated_field = "9BFAF00848476277D36D9BA586984BA7")

        int mChangingConfigurations;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.771 -0400", hash_original_field = "78E27F80AC0100441F897783EFA42851", hash_generated_field = "0344A2D91EF1BCE652EE63EFC12EEAC9")

        Paint mPaint;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.771 -0400", hash_original_field = "2926CB901374ACDDA1AEEBF2747A26F6", hash_generated_field = "E7A888C0E804BDEECC7B681F4946AFDC")

        Shape mShape;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.771 -0400", hash_original_field = "9AC2544B5F9B8F60AA16656C94B57A8E", hash_generated_field = "A053A94BBF9972B52A80E2FC510022E8")

        Rect mPadding;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.772 -0400", hash_original_field = "119DCE670C90F7AC3E6B6C08968A4DC8", hash_generated_field = "AAE27B48F9D50812AABD238DAF78161A")

        int mIntrinsicWidth;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.772 -0400", hash_original_field = "DFB49FFA7CD229538212E74A896D2963", hash_generated_field = "72B37F3E39E1F9B80F01AF0004B418D7")

        int mIntrinsicHeight;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.772 -0400", hash_original_field = "1439C01AF326A337A2401436745247DA", hash_generated_field = "A6B19F1E237A801306F5C3BB6F56FD1D")

        int mAlpha = 255;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.772 -0400", hash_original_field = "3F1C269B8DC8918282E82E3CC5AEEA3C", hash_generated_field = "ADCB4599C69CB10A0B4150CAF65EDF82")

        ShaderFactory mShaderFactory;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.773 -0400", hash_original_method = "EFBED6F0CFE384FE09150C9B37976B1A", hash_generated_method = "1BB92F41BFDC684970D22C18D2519AD9")
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
            } 
            else
            {
                mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
            } 
            
            
                
                
                
                
                
                
                
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.773 -0400", hash_original_method = "712D1F78574D9DF109190A3CBF508567", hash_generated_method = "35DFE329A60E89D849AA45C53F53A202")
        @Override
        public Drawable newDrawable() {
Drawable var70B51CA0E2F73DDDAEA1517FCDBBB53D_1439641660 =             new ShapeDrawable(this);
            var70B51CA0E2F73DDDAEA1517FCDBBB53D_1439641660.addTaint(taint);
            return var70B51CA0E2F73DDDAEA1517FCDBBB53D_1439641660;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.774 -0400", hash_original_method = "7ABD019570C442758FC9C41DDD5AE24E", hash_generated_method = "1D31B01BD0853EF7D668E2112BD8C632")
        @Override
        public Drawable newDrawable(Resources res) {
            addTaint(res.getTaint());
Drawable var70B51CA0E2F73DDDAEA1517FCDBBB53D_275536742 =             new ShapeDrawable(this);
            var70B51CA0E2F73DDDAEA1517FCDBBB53D_275536742.addTaint(taint);
            return var70B51CA0E2F73DDDAEA1517FCDBBB53D_275536742;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.774 -0400", hash_original_method = "9E7D7C67EAC365FF19BD4971762612A5", hash_generated_method = "081AEFCBA062D88079FD2A240B45EFE2")
        @Override
        public int getChangingConfigurations() {
            int var276E0645C4E2084773D0EB8C5576428C_1561325171 = (mChangingConfigurations);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_564629033 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_564629033;
            
            
        }

        
    }


    
    public static abstract class ShaderFactory {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.774 -0400", hash_original_method = "3BAAD89D982163CC2C371B74D92AB9C1", hash_generated_method = "3BAAD89D982163CC2C371B74D92AB9C1")
        public ShaderFactory ()
        {
            
        }


        public abstract Shader resize(int width, int height);

        
    }


    
}

