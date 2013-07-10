package android.graphics.drawable;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.552 -0400", hash_original_field = "F650B6D51E8A0558B8CDC9DB09FD9330", hash_generated_field = "E775880DE66EC067EFB70E829A0DB9BA")

    private ShapeState mShapeState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.552 -0400", hash_original_field = "9FB80C30383848C8D006680B5F3BDAF9", hash_generated_field = "5CA5A1EF3CAA45117BCACBC34EF05952")

    private boolean mMutated;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.553 -0400", hash_original_method = "0D9B9D363D3461B1F66ABDB4BD10ADF4", hash_generated_method = "F8142F9CA4A2ED9C1A4C2A61C668E2C1")
    public  ShapeDrawable() {
        this((ShapeState) null);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.553 -0400", hash_original_method = "F897BE84D7E0CD5527DF62F0C124D538", hash_generated_method = "50727A759836F61C98F8262C81B37DE0")
    public  ShapeDrawable(Shape s) {
        this((ShapeState) null);
        mShapeState.mShape = s;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.554 -0400", hash_original_method = "1601A6C313758A231E2593A310142434", hash_generated_method = "BC1A7556F13C9F16471EEF9C585D7FC3")
    private  ShapeDrawable(ShapeState state) {
        mShapeState = new ShapeState(state);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.554 -0400", hash_original_method = "93DF953391DA58A2026A871408A81498", hash_generated_method = "D9BC212F88DC7B421A8B7C6ADE33B2CB")
    public Shape getShape() {
        Shape varB4EAC82CA7396A68D541C85D26508E83_1726086863 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1726086863 = mShapeState.mShape;
        varB4EAC82CA7396A68D541C85D26508E83_1726086863.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1726086863;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.555 -0400", hash_original_method = "91DE5C2C93AB9A1591999F92B24BB2F1", hash_generated_method = "333245D43C3894C20A8F2638360949CC")
    public void setShape(Shape s) {
        mShapeState.mShape = s;
        updateShape();
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.555 -0400", hash_original_method = "63480B19EB44379868D8321D7A96C7B7", hash_generated_method = "98C4B1E892C6B76796983BAC575AFE3D")
    public void setShaderFactory(ShaderFactory fact) {
        mShapeState.mShaderFactory = fact;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.556 -0400", hash_original_method = "E65D8AF971F17EDFF075456EB259C0A6", hash_generated_method = "7CE8641D65578730620679125656ECD4")
    public ShaderFactory getShaderFactory() {
        ShaderFactory varB4EAC82CA7396A68D541C85D26508E83_189757954 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_189757954 = mShapeState.mShaderFactory;
        varB4EAC82CA7396A68D541C85D26508E83_189757954.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_189757954;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.557 -0400", hash_original_method = "F97BA42DC4507A8A136D2774D1D1BA0E", hash_generated_method = "143EB0912F3E55330C55C3D7A9CF29D0")
    public Paint getPaint() {
        Paint varB4EAC82CA7396A68D541C85D26508E83_2138392153 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2138392153 = mShapeState.mPaint;
        varB4EAC82CA7396A68D541C85D26508E83_2138392153.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2138392153;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.557 -0400", hash_original_method = "B421F82679CD23EB7F3D507B70942FAD", hash_generated_method = "673EB58534CBA69C6F3917D50ED805DF")
    public void setPadding(int left, int top, int right, int bottom) {
        {
            mShapeState.mPadding = null;
        } 
        {
            {
                mShapeState.mPadding = new Rect();
            } 
            mShapeState.mPadding.set(left, top, right, bottom);
        } 
        invalidateSelf();
        addTaint(left);
        addTaint(top);
        addTaint(right);
        addTaint(bottom);
        
        
            
        
            
                
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.558 -0400", hash_original_method = "416AA9F2AA0561BA0C5710C29E641860", hash_generated_method = "5F90EDCBFDA44F20F575472FA9049086")
    public void setPadding(Rect padding) {
        {
            mShapeState.mPadding = null;
        } 
        {
            {
                mShapeState.mPadding = new Rect();
            } 
            mShapeState.mPadding.set(padding);
        } 
        invalidateSelf();
        addTaint(padding.getTaint());
        
        
            
        
            
                
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.558 -0400", hash_original_method = "0038E10CC04EA446FBCFE7542F8A245A", hash_generated_method = "EF946B1AE5C472004D43406542B29B7C")
    public void setIntrinsicWidth(int width) {
        mShapeState.mIntrinsicWidth = width;
        invalidateSelf();
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.559 -0400", hash_original_method = "0D195260E9CE84B5EB7D22342052E56D", hash_generated_method = "E2059B6FDC44B6E7A4C61309E7061A2F")
    public void setIntrinsicHeight(int height) {
        mShapeState.mIntrinsicHeight = height;
        invalidateSelf();
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.559 -0400", hash_original_method = "2BA24D2DFEB102D9B9B4478CA4BDB4E4", hash_generated_method = "944EDF05F1131469D2D8D45020C5E236")
    @Override
    public int getIntrinsicWidth() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1293100091 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1293100091;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.559 -0400", hash_original_method = "A17CBC5FDAD1E989314B42A85C195659", hash_generated_method = "1C2BCAB1ABBAA566E633C3FD57780AE1")
    @Override
    public int getIntrinsicHeight() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1495694277 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1495694277;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.560 -0400", hash_original_method = "57EA20106D2449A841F533A811E87EF0", hash_generated_method = "DAD92744B60942E772FF8A00E2E7C349")
    @Override
    public boolean getPadding(Rect padding) {
        {
            padding.set(mShapeState.mPadding);
        } 
        {
            boolean var26681595319194856AEB3747307B6E08_675180840 = (super.getPadding(padding));
        } 
        addTaint(padding.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_628920579 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_628920579;
        
        
            
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    private static int modulateAlpha(int paintAlpha, int alpha) {
        int scale = alpha + (alpha >>> 7);
        return paintAlpha * scale >>> 8;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.560 -0400", hash_original_method = "94C805D8D565AE05BF02DE9855C838FE", hash_generated_method = "05C171D75EAACE6FF0C2F9DEE2E65292")
    protected void onDraw(Shape shape, Canvas canvas, Paint paint) {
        
        shape.draw(canvas, paint);
        addTaint(shape.getTaint());
        addTaint(canvas.getTaint());
        addTaint(paint.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.561 -0400", hash_original_method = "2D289F2C5870F3B95565E05840E163B8", hash_generated_method = "639BEFDEF694F001A86B0EBDFD85E6A2")
    @Override
    public void draw(Canvas canvas) {
        Rect r = getBounds();
        Paint paint = mShapeState.mPaint;
        int prevAlpha = paint.getAlpha();
        paint.setAlpha(modulateAlpha(prevAlpha, mShapeState.mAlpha));
        {
            int count = canvas.save();
            canvas.translate(r.left, r.top);
            onDraw(mShapeState.mShape, canvas, paint);
            canvas.restoreToCount(count);
        } 
        {
            canvas.drawRect(r, paint);
        } 
        paint.setAlpha(prevAlpha);
        addTaint(canvas.getTaint());
        
        
        
        
        
        
            
            
            
            
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.561 -0400", hash_original_method = "DB1A6AE8DEB59FB8C1923E504575EFF9", hash_generated_method = "B14BC0FDFD67C84CEAAB0A5F51AD40A1")
    @Override
    public int getChangingConfigurations() {
        int var03C30E2DD78CE71D6B967BDA275B0525_587999308 = (super.getChangingConfigurations()
                | mShapeState.mChangingConfigurations);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1414207163 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1414207163;
        
        
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.562 -0400", hash_original_method = "6237C1F5A576324C3E69C30154E7DEFA", hash_generated_method = "7C2A4ABB1BBCDA7A1D9BBEFF61A8CB16")
    @Override
    public void setAlpha(int alpha) {
        mShapeState.mAlpha = alpha;
        invalidateSelf();
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.562 -0400", hash_original_method = "DD3A0AA7864766F7FA9D12D24B53719B", hash_generated_method = "79D81861C668BEC463C1AF201C74DAC7")
    @Override
    public void setColorFilter(ColorFilter cf) {
        mShapeState.mPaint.setColorFilter(cf);
        invalidateSelf();
        addTaint(cf.getTaint());
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.562 -0400", hash_original_method = "056406D5393D0B46C202324FAF95659D", hash_generated_method = "B146468FA5693ED00F8341FEDE9CEBCA")
    @Override
    public int getOpacity() {
        {
            final Paint p = mShapeState.mPaint;
            {
                boolean var9572989EFAB64708D1AB2CADA0B7F390_649833973 = (p.getXfermode() == null);
                {
                    final int alpha = p.getAlpha();
                } 
            } 
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1165718701 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1165718701;
        
        
            
            
                
                
                    
                
                
                    
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.563 -0400", hash_original_method = "3955BCB5252FAD61A7FDF156B0C32957", hash_generated_method = "B585A519E148E3637D1DFC6013F8AA52")
    @Override
    public void setDither(boolean dither) {
        mShapeState.mPaint.setDither(dither);
        invalidateSelf();
        addTaint(dither);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.563 -0400", hash_original_method = "E6B6299A3D5979543EAAC4DC6F8268D1", hash_generated_method = "2C59B04D180FD04CF0C98F1EC72068B9")
    @Override
    protected void onBoundsChange(Rect bounds) {
        
        super.onBoundsChange(bounds);
        updateShape();
        addTaint(bounds.getTaint());
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.564 -0400", hash_original_method = "FCE81D70334945C2A418AF4A55A47945", hash_generated_method = "605B5A759137069968C4970FCDF456CD")
    protected boolean inflateTag(String name, Resources r, XmlPullParser parser,
            AttributeSet attrs) {
        {
            boolean varC590E54E2D929B80732C65F42F4C39A6_687458542 = ("padding".equals(name));
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
            } 
        } 
        addTaint(name.getTaint());
        addTaint(r.getTaint());
        addTaint(parser.getTaint());
        addTaint(attrs.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_32955050 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_32955050;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.564 -0400", hash_original_method = "5F3462BA297EEEB891A1F24F05317325", hash_generated_method = "34AE27386087FF8A4C052D623D631F26")
    @Override
    public void inflate(Resources r, XmlPullParser parser, AttributeSet attrs) throws XmlPullParserException, IOException {
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
        {
            boolean var49BAE650CF2F44016B0E4A15ECAD0A92_575065001 = ((type=parser.next()) != XmlPullParser.END_DOCUMENT
               && (type != XmlPullParser.END_TAG || parser.getDepth() > outerDepth));
            {
                final String name = parser.getName();
                {
                    boolean var35E72E680A0A661B0D620A4895DD21BC_396164829 = (!inflateTag(name, r, parser, attrs));
                    {
                        android.util.Log.w("drawable", "Unknown element: " + name +
                        " for ShapeDrawable " + this);
                    } 
                } 
            } 
        } 
        addTaint(r.getTaint());
        addTaint(parser.getTaint());
        addTaint(attrs.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.565 -0400", hash_original_method = "A8D04337EAFF1E34F1C3CFBFD3AD3EF7", hash_generated_method = "FA390B86ACE96503717892B7EB79A082")
    private void updateShape() {
        {
            final Rect r = getBounds();
            final int w = r.width();
            final int h = r.height();
            mShapeState.mShape.resize(w, h);
            {
                mShapeState.mPaint.setShader(mShapeState.mShaderFactory.resize(w, h));
            } 
        } 
        invalidateSelf();
        
        
            
            
            
            
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.566 -0400", hash_original_method = "A9816EFD17AF344D0CD39D6855E6F73A", hash_generated_method = "114179012C33ED53A3478579AA004182")
    @Override
    public ConstantState getConstantState() {
        ConstantState varB4EAC82CA7396A68D541C85D26508E83_1945852907 = null; 
        mShapeState.mChangingConfigurations = getChangingConfigurations();
        varB4EAC82CA7396A68D541C85D26508E83_1945852907 = mShapeState;
        varB4EAC82CA7396A68D541C85D26508E83_1945852907.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1945852907;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.568 -0400", hash_original_method = "4A16C05F7F7E58EF657A6CA1B8182ABE", hash_generated_method = "FF8861673D4C7B6247F793908F0B8603")
    @Override
    public Drawable mutate() {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_905591239 = null; 
        Drawable varB4EAC82CA7396A68D541C85D26508E83_1484451232 = null; 
        {
            boolean varC94B19053599294E7944C8C841976773_1316641832 = (!mMutated && super.mutate() == this);
            {
                mShapeState.mPaint = new Paint(mShapeState.mPaint);
                mShapeState.mPadding = new Rect(mShapeState.mPadding);
                try 
                {
                    mShapeState.mShape = mShapeState.mShape.clone();
                } 
                catch (CloneNotSupportedException e)
                {
                    varB4EAC82CA7396A68D541C85D26508E83_905591239 = null;
                } 
                mMutated = true;
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1484451232 = this;
        Drawable varA7E53CE21691AB073D9660D615818899_568332361; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_568332361 = varB4EAC82CA7396A68D541C85D26508E83_905591239;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_568332361 = varB4EAC82CA7396A68D541C85D26508E83_1484451232;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_568332361.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_568332361;
        
        
            
            
            
                
            
                
            
            
        
        
    }

    
    final static class ShapeState extends ConstantState {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.569 -0400", hash_original_field = "276E0645C4E2084773D0EB8C5576428C", hash_generated_field = "9BFAF00848476277D36D9BA586984BA7")

        int mChangingConfigurations;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.569 -0400", hash_original_field = "78E27F80AC0100441F897783EFA42851", hash_generated_field = "0344A2D91EF1BCE652EE63EFC12EEAC9")

        Paint mPaint;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.569 -0400", hash_original_field = "2926CB901374ACDDA1AEEBF2747A26F6", hash_generated_field = "E7A888C0E804BDEECC7B681F4946AFDC")

        Shape mShape;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.569 -0400", hash_original_field = "9AC2544B5F9B8F60AA16656C94B57A8E", hash_generated_field = "A053A94BBF9972B52A80E2FC510022E8")

        Rect mPadding;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.569 -0400", hash_original_field = "119DCE670C90F7AC3E6B6C08968A4DC8", hash_generated_field = "AAE27B48F9D50812AABD238DAF78161A")

        int mIntrinsicWidth;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.569 -0400", hash_original_field = "DFB49FFA7CD229538212E74A896D2963", hash_generated_field = "72B37F3E39E1F9B80F01AF0004B418D7")

        int mIntrinsicHeight;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.569 -0400", hash_original_field = "1439C01AF326A337A2401436745247DA", hash_generated_field = "A6B19F1E237A801306F5C3BB6F56FD1D")

        int mAlpha = 255;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.569 -0400", hash_original_field = "3F1C269B8DC8918282E82E3CC5AEEA3C", hash_generated_field = "ADCB4599C69CB10A0B4150CAF65EDF82")

        ShaderFactory mShaderFactory;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.569 -0400", hash_original_method = "EFBED6F0CFE384FE09150C9B37976B1A", hash_generated_method = "E8794C12CA154EFB1B8CDA4AECE9144F")
          ShapeState(ShapeState orig) {
            {
                mPaint = orig.mPaint;
                mShape = orig.mShape;
                mPadding = orig.mPadding;
                mIntrinsicWidth = orig.mIntrinsicWidth;
                mIntrinsicHeight = orig.mIntrinsicHeight;
                mAlpha = orig.mAlpha;
                mShaderFactory = orig.mShaderFactory;
            } 
            {
                mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
            } 
            
            
                
                
                
                
                
                
                
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.570 -0400", hash_original_method = "712D1F78574D9DF109190A3CBF508567", hash_generated_method = "A47165B0D1F4CB02B5709E6E3B9B9642")
        @Override
        public Drawable newDrawable() {
            Drawable varB4EAC82CA7396A68D541C85D26508E83_1409925815 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1409925815 = new ShapeDrawable(this);
            varB4EAC82CA7396A68D541C85D26508E83_1409925815.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1409925815;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.571 -0400", hash_original_method = "7ABD019570C442758FC9C41DDD5AE24E", hash_generated_method = "9F670C9195E5BC0D85D18DFD25356AF3")
        @Override
        public Drawable newDrawable(Resources res) {
            Drawable varB4EAC82CA7396A68D541C85D26508E83_2049432783 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_2049432783 = new ShapeDrawable(this);
            addTaint(res.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_2049432783.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_2049432783;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.571 -0400", hash_original_method = "9E7D7C67EAC365FF19BD4971762612A5", hash_generated_method = "097B5E42B956106E04641D1048E652BF")
        @Override
        public int getChangingConfigurations() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1618943992 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1618943992;
            
            
        }

        
    }


    
    public static abstract class ShaderFactory {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.571 -0400", hash_original_method = "3BAAD89D982163CC2C371B74D92AB9C1", hash_generated_method = "3BAAD89D982163CC2C371B74D92AB9C1")
        public ShaderFactory ()
        {
            
        }


        public abstract Shader resize(int width, int height);

        
    }


    
}

