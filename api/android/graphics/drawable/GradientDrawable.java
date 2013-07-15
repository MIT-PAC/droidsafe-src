package android.graphics.drawable;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import java.io.IOException;

public class GradientDrawable extends Drawable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.139 -0400", hash_original_field = "7A93543FFB4741C41CAFDAC91FC3D12D", hash_generated_field = "F8FC523C37AC4F355E3A52C1D395B9CA")

    private GradientState mGradientState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.139 -0400", hash_original_field = "90FF0E236CECDE0BABB7F37F4CFBC91F", hash_generated_field = "20B811D11F80D9B524F2E016940568D0")

    private final Paint mFillPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.140 -0400", hash_original_field = "9AC2544B5F9B8F60AA16656C94B57A8E", hash_generated_field = "017017AA9AF1862D01EDDEC3A7AB7775")

    private Rect mPadding;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.140 -0400", hash_original_field = "6DCD2896FB1BA879F4BA417938FBF583", hash_generated_field = "9FB471477563645F319E80BA6D6ED905")

    private Paint mStrokePaint;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.140 -0400", hash_original_field = "8B2ED40D22A4C08C94CFC40B6DE589B8", hash_generated_field = "5D6D299C9DDEDCCB11EFFA1C147C3DF6")

    private ColorFilter mColorFilter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.140 -0400", hash_original_field = "964D4F44E49C213AB7292F7E0E37C642", hash_generated_field = "3503E015FBD1508491B2F18FDC5DAF9F")

    private int mAlpha = 0xFF;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.140 -0400", hash_original_field = "39F3EFC8FE0445AB43D96028DA65CB34", hash_generated_field = "B8E34DBCCD5A9935E92ED2F73AF5F8B7")

    private boolean mDither;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.140 -0400", hash_original_field = "DBC2DDFC3AA0B07663EC95BA4102B76C", hash_generated_field = "1C9B38C7F9B71799B7B8F281B135448B")

    private final Path mPath = new Path();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.140 -0400", hash_original_field = "995C0FB7B00A0A1E82DD4C30778697FC", hash_generated_field = "E70F5B350707014CDC8DCA8B7C0C28DD")

    private final RectF mRect = new RectF();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.140 -0400", hash_original_field = "5870A18F50D7C3B8DE43F07B2A8E2BC8", hash_generated_field = "A6ACFEE6A39EC6759FF9E6489D52AFB1")

    private Paint mLayerPaint;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.140 -0400", hash_original_field = "0AC65B89ECE55C9155BA940BC20ABBBA", hash_generated_field = "82A739DA370CC4D4C339BB7C440434C4")

    private boolean mRectIsDirty;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.140 -0400", hash_original_field = "9FB80C30383848C8D006680B5F3BDAF9", hash_generated_field = "5CA5A1EF3CAA45117BCACBC34EF05952")

    private boolean mMutated;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.140 -0400", hash_original_field = "9333534E7B66A8D431355B79E08642AE", hash_generated_field = "FB9692F405D4B8918DCE56B27CC81A6B")

    private Path mRingPath;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.141 -0400", hash_original_field = "9952E276AFE35FE0B1FB7B2BDEB787AA", hash_generated_field = "EAB2B54D4BC3106764331272E438AA0A")

    private boolean mPathIsDirty = true;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.141 -0400", hash_original_method = "64287040FBFB7F81692AADB4245B0378", hash_generated_method = "78296307B8E83E1FC392EC6080C25EE7")
    public  GradientDrawable() {
        this(new GradientState(Orientation.TOP_BOTTOM, null));
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.142 -0400", hash_original_method = "48FF7A4A9E39F0BE519CF2AE778248C7", hash_generated_method = "E4546EC665FA75F324F70D8F0B07D90F")
    public  GradientDrawable(Orientation orientation, int[] colors) {
        this(new GradientState(orientation, colors));
        addTaint(colors[0]);
        addTaint(orientation.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.143 -0400", hash_original_method = "11AB49F3A166C4EC986EE8723C09CE3C", hash_generated_method = "EB17AAEC21D5CB5883C8C3AB3D6841B1")
    private  GradientDrawable(GradientState state) {
        mGradientState = state;
        initializeWithState(state);
        mRectIsDirty = true;
        // ---------- Original Method ----------
        //mGradientState = state;
        //initializeWithState(state);
        //mRectIsDirty = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.144 -0400", hash_original_method = "0B8807A1903E03E118A45AC647AD9F24", hash_generated_method = "9BA77C43C5107BB27AEC0F8324A84CCA")
    @Override
    public boolean getPadding(Rect padding) {
        addTaint(padding.getTaint());
    if(mPadding != null)        
        {
            padding.set(mPadding);
            boolean varB326B5062B2F0E69046810717534CB09_866717571 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_368054275 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_368054275;
        } //End block
        else
        {
            boolean varBEE4EC8926815DF7C66351028FE91FD2_85676090 = (super.getPadding(padding));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1854822800 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1854822800;
        } //End block
        // ---------- Original Method ----------
        //if (mPadding != null) {
            //padding.set(mPadding);
            //return true;
        //} else {
            //return super.getPadding(padding);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.144 -0400", hash_original_method = "71F948CC6AEC5EB6067752059DA33574", hash_generated_method = "B7322C984C004B358FCF2F720D49B530")
    public void setCornerRadii(float[] radii) {
        addTaint(radii[0]);
        mGradientState.setCornerRadii(radii);
        mPathIsDirty = true;
        invalidateSelf();
        // ---------- Original Method ----------
        //mGradientState.setCornerRadii(radii);
        //mPathIsDirty = true;
        //invalidateSelf();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.145 -0400", hash_original_method = "AFB7C3E5AE7C3BBB28B141F7A3B472BE", hash_generated_method = "F0B3793A12ED190584B439AAAA84F715")
    public void setCornerRadius(float radius) {
        addTaint(radius);
        mGradientState.setCornerRadius(radius);
        mPathIsDirty = true;
        invalidateSelf();
        // ---------- Original Method ----------
        //mGradientState.setCornerRadius(radius);
        //mPathIsDirty = true;
        //invalidateSelf();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.145 -0400", hash_original_method = "6A0F62EB2F02BD455327DA9DA2DD0568", hash_generated_method = "6C3F63DCB3D7C19B7540FD90F8FBFB54")
    public void setStroke(int width, int color) {
        addTaint(color);
        addTaint(width);
        setStroke(width, color, 0, 0);
        // ---------- Original Method ----------
        //setStroke(width, color, 0, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.146 -0400", hash_original_method = "F36B912577B048DA0236870F939930FC", hash_generated_method = "7BB44D313951F2E52E0CB6B64A3AC02E")
    public void setStroke(int width, int color, float dashWidth, float dashGap) {
        addTaint(dashGap);
        addTaint(dashWidth);
        addTaint(color);
        addTaint(width);
        mGradientState.setStroke(width, color, dashWidth, dashGap);
    if(mStrokePaint == null)        
        {
            mStrokePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
            mStrokePaint.setStyle(Paint.Style.STROKE);
        } //End block
        mStrokePaint.setStrokeWidth(width);
        mStrokePaint.setColor(color);
        DashPathEffect e = null;
    if(dashWidth > 0)        
        {
            e = new DashPathEffect(new float[] { dashWidth, dashGap }, 0);
        } //End block
        mStrokePaint.setPathEffect(e);
        invalidateSelf();
        // ---------- Original Method ----------
        //mGradientState.setStroke(width, color, dashWidth, dashGap);
        //if (mStrokePaint == null)  {
            //mStrokePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
            //mStrokePaint.setStyle(Paint.Style.STROKE);
        //}
        //mStrokePaint.setStrokeWidth(width);
        //mStrokePaint.setColor(color);
        //DashPathEffect e = null;
        //if (dashWidth > 0) {
            //e = new DashPathEffect(new float[] { dashWidth, dashGap }, 0);
        //}
        //mStrokePaint.setPathEffect(e);
        //invalidateSelf();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.147 -0400", hash_original_method = "DBF55AE12AFE7021A6EFA67946A43E31", hash_generated_method = "399095E3DFE835BA193C2385DB1D0744")
    public void setSize(int width, int height) {
        addTaint(height);
        addTaint(width);
        mGradientState.setSize(width, height);
        mPathIsDirty = true;
        invalidateSelf();
        // ---------- Original Method ----------
        //mGradientState.setSize(width, height);
        //mPathIsDirty = true;
        //invalidateSelf();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.147 -0400", hash_original_method = "70A303A49D3D529F927A8B25154245C2", hash_generated_method = "4B23758D02FB3047FF58AD01FE0BA218")
    public void setShape(int shape) {
        addTaint(shape);
        mRingPath = null;
        mPathIsDirty = true;
        mGradientState.setShape(shape);
        invalidateSelf();
        // ---------- Original Method ----------
        //mRingPath = null;
        //mPathIsDirty = true;
        //mGradientState.setShape(shape);
        //invalidateSelf();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.148 -0400", hash_original_method = "18DB26B14B71A02370E6DE427E61924A", hash_generated_method = "2EF57A0E4BCD0D8F0577A4D8E6FBCC06")
    public void setGradientType(int gradient) {
        addTaint(gradient);
        mGradientState.setGradientType(gradient);
        mRectIsDirty = true;
        invalidateSelf();
        // ---------- Original Method ----------
        //mGradientState.setGradientType(gradient);
        //mRectIsDirty = true;
        //invalidateSelf();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.148 -0400", hash_original_method = "45A2D9788BC882B134EC764255BF8E5D", hash_generated_method = "D8F6D27082343236E3EB3087956A5B57")
    public void setGradientCenter(float x, float y) {
        addTaint(y);
        addTaint(x);
        mGradientState.setGradientCenter(x, y);
        mRectIsDirty = true;
        invalidateSelf();
        // ---------- Original Method ----------
        //mGradientState.setGradientCenter(x, y);
        //mRectIsDirty = true;
        //invalidateSelf();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.149 -0400", hash_original_method = "C7CA2F8177799FD0AFA978CBCB22DF14", hash_generated_method = "0518F0FAB19F07ACB4668A834486D389")
    public void setGradientRadius(float gradientRadius) {
        addTaint(gradientRadius);
        mGradientState.setGradientRadius(gradientRadius);
        mRectIsDirty = true;
        invalidateSelf();
        // ---------- Original Method ----------
        //mGradientState.setGradientRadius(gradientRadius);
        //mRectIsDirty = true;
        //invalidateSelf();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.149 -0400", hash_original_method = "76C6B5A7FB76D454B2D8C7EAA5B46C4F", hash_generated_method = "2E9C7352FC465108C4CB664D03418E5C")
    public void setUseLevel(boolean useLevel) {
        mGradientState.mUseLevel = useLevel;
        mRectIsDirty = true;
        invalidateSelf();
        // ---------- Original Method ----------
        //mGradientState.mUseLevel = useLevel;
        //mRectIsDirty = true;
        //invalidateSelf();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.150 -0400", hash_original_method = "0886E73CB45EE282B3AFC0BE37F5BE6C", hash_generated_method = "3CC21697F3F26219E4150B47AA14D8BA")
    private int modulateAlpha(int alpha) {
        addTaint(alpha);
        int scale = mAlpha + (mAlpha >> 7);
        int var1E86FBFC32D512365FB226FD2B13CE62_1221318793 = (alpha * scale >> 8);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1417433202 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1417433202;
        // ---------- Original Method ----------
        //int scale = mAlpha + (mAlpha >> 7);
        //return alpha * scale >> 8;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.151 -0400", hash_original_method = "ACDDE907D9101C7CDDBBB954BA4F617E", hash_generated_method = "9E2FABE439E2A55C9119ED8E8AB6E0A2")
    @Override
    public void draw(Canvas canvas) {
        addTaint(canvas.getTaint());
    if(!ensureValidRect())        
        {
            return;
        } //End block
        final int prevFillAlpha = mFillPaint.getAlpha();
        final int prevStrokeAlpha = mStrokePaint != null ? mStrokePaint.getAlpha() : 0;
        final int currFillAlpha = modulateAlpha(prevFillAlpha);
        final int currStrokeAlpha = modulateAlpha(prevStrokeAlpha);
        final boolean haveStroke = currStrokeAlpha > 0 && mStrokePaint.getStrokeWidth() > 0;
        final boolean haveFill = currFillAlpha > 0;
        final GradientState st = mGradientState;
        final boolean useLayer = haveStroke && haveFill && st.mShape != LINE &&
                 currStrokeAlpha < 255 && (mAlpha < 255 || mColorFilter != null);
    if(useLayer)        
        {
    if(mLayerPaint == null)            
            {
                mLayerPaint = new Paint();
            } //End block
            mLayerPaint.setDither(mDither);
            mLayerPaint.setAlpha(mAlpha);
            mLayerPaint.setColorFilter(mColorFilter);
            float rad = mStrokePaint.getStrokeWidth();
            canvas.saveLayer(mRect.left - rad, mRect.top - rad,
                             mRect.right + rad, mRect.bottom + rad,
                             mLayerPaint, Canvas.HAS_ALPHA_LAYER_SAVE_FLAG);
            mFillPaint.setColorFilter(null);
            mStrokePaint.setColorFilter(null);
        } //End block
        else
        {
            mFillPaint.setAlpha(currFillAlpha);
            mFillPaint.setDither(mDither);
            mFillPaint.setColorFilter(mColorFilter);
    if(haveStroke)            
            {
                mStrokePaint.setAlpha(currStrokeAlpha);
                mStrokePaint.setDither(mDither);
                mStrokePaint.setColorFilter(mColorFilter);
            } //End block
        } //End block
switch(st.mShape){
        case RECTANGLE:
    if(st.mRadiusArray != null)        
        {
    if(mPathIsDirty || mRectIsDirty)            
            {
                mPath.reset();
                mPath.addRoundRect(mRect, st.mRadiusArray, Path.Direction.CW);
                mPathIsDirty = mRectIsDirty = false;
            } //End block
            canvas.drawPath(mPath, mFillPaint);
    if(haveStroke)            
            {
                canvas.drawPath(mPath, mStrokePaint);
            } //End block
        } //End block
        else
    if(st.mRadius > 0.0f)        
        {
            float rad = st.mRadius;
            float r = Math.min(mRect.width(), mRect.height()) * 0.5f;
    if(rad > r)            
            {
                rad = r;
            } //End block
            canvas.drawRoundRect(mRect, rad, rad, mFillPaint);
    if(haveStroke)            
            {
                canvas.drawRoundRect(mRect, rad, rad, mStrokePaint);
            } //End block
        } //End block
        else
        {
            canvas.drawRect(mRect, mFillPaint);
    if(haveStroke)            
            {
                canvas.drawRect(mRect, mStrokePaint);
            } //End block
        } //End block
        break;
        case OVAL:
        canvas.drawOval(mRect, mFillPaint);
    if(haveStroke)        
        {
            canvas.drawOval(mRect, mStrokePaint);
        } //End block
        break;
        case LINE:
        {
            RectF r = mRect;
            float y = r.centerY();
            canvas.drawLine(r.left, y, r.right, y, mStrokePaint);
            break;
        } //End block
        case RING:
        Path path = buildRing(st);
        canvas.drawPath(path, mFillPaint);
    if(haveStroke)        
        {
            canvas.drawPath(path, mStrokePaint);
        } //End block
        break;
}    if(useLayer)        
        {
            canvas.restore();
        } //End block
        else
        {
            mFillPaint.setAlpha(prevFillAlpha);
    if(haveStroke)            
            {
                mStrokePaint.setAlpha(prevStrokeAlpha);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.156 -0400", hash_original_method = "FA54FBF5F964BB48C4F923A57A9FF840", hash_generated_method = "4FFB9CA559C9FEDE09449CC84DCD8740")
    private Path buildRing(GradientState st) {
        addTaint(st.getTaint());
    if(mRingPath != null && (!st.mUseLevelForShape || !mPathIsDirty))        
        {
Path var08758AED9D8B45A03A54A922394E355E_649548371 =         mRingPath;
        var08758AED9D8B45A03A54A922394E355E_649548371.addTaint(taint);
        return var08758AED9D8B45A03A54A922394E355E_649548371;
        }
        mPathIsDirty = false;
        float sweep = st.mUseLevelForShape ? (360.0f * getLevel() / 10000.0f) : 360f;
        RectF bounds = new RectF(mRect);
        float x = bounds.width() / 2.0f;
        float y = bounds.height() / 2.0f;
        float thickness = st.mThickness != -1 ?
                st.mThickness : bounds.width() / st.mThicknessRatio;
        float radius = st.mInnerRadius != -1 ?
                st.mInnerRadius : bounds.width() / st.mInnerRadiusRatio;
        RectF innerBounds = new RectF(bounds);
        innerBounds.inset(x - radius, y - radius);
        bounds = new RectF(innerBounds);
        bounds.inset(-thickness, -thickness);
    if(mRingPath == null)        
        {
            mRingPath = new Path();
        } //End block
        else
        {
            mRingPath.reset();
        } //End block
        final Path ringPath = mRingPath;
    if(sweep < 360 && sweep > -360)        
        {
            ringPath.setFillType(Path.FillType.EVEN_ODD);
            ringPath.moveTo(x + radius, y);
            ringPath.lineTo(x + radius + thickness, y);
            ringPath.arcTo(bounds, 0.0f, sweep, false);
            ringPath.arcTo(innerBounds, sweep, -sweep, false);
            ringPath.close();
        } //End block
        else
        {
            ringPath.addOval(bounds, Path.Direction.CW);
            ringPath.addOval(innerBounds, Path.Direction.CCW);
        } //End block
Path var519CAB76968E93D45E4C92AC8B95C0FE_1364931709 =         ringPath;
        var519CAB76968E93D45E4C92AC8B95C0FE_1364931709.addTaint(taint);
        return var519CAB76968E93D45E4C92AC8B95C0FE_1364931709;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.157 -0400", hash_original_method = "A6E3DC666A9DC913CF167BAEE3BA3755", hash_generated_method = "9C3413371FE183CF48F1C41DFE93AFFC")
    public void setColor(int argb) {
        addTaint(argb);
        mGradientState.setSolidColor(argb);
        mFillPaint.setColor(argb);
        invalidateSelf();
        // ---------- Original Method ----------
        //mGradientState.setSolidColor(argb);
        //mFillPaint.setColor(argb);
        //invalidateSelf();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.158 -0400", hash_original_method = "3865DA4989774EEF9AAAD48E0098B1D2", hash_generated_method = "1FF6B7BF066D6725D92075B73F580129")
    @Override
    public int getChangingConfigurations() {
        int var9893FD865C2F62C12FE4FC0D618C57AB_2087920391 = (super.getChangingConfigurations()
                | mGradientState.mChangingConfigurations);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1223689266 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1223689266;
        // ---------- Original Method ----------
        //return super.getChangingConfigurations()
                //| mGradientState.mChangingConfigurations;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.159 -0400", hash_original_method = "5182E1ED546D38ED0370680C356A26EE", hash_generated_method = "523387C2B947EA4484C8533EAD9B28BA")
    @Override
    public void setAlpha(int alpha) {
    if(alpha != mAlpha)        
        {
            mAlpha = alpha;
            invalidateSelf();
        } //End block
        // ---------- Original Method ----------
        //if (alpha != mAlpha) {
            //mAlpha = alpha;
            //invalidateSelf();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.160 -0400", hash_original_method = "9DFE5D886E6229E65D3F438DE9F28624", hash_generated_method = "46DD08C69B5465804445B04D085E83E2")
    @Override
    public void setDither(boolean dither) {
    if(dither != mDither)        
        {
            mDither = dither;
            invalidateSelf();
        } //End block
        // ---------- Original Method ----------
        //if (dither != mDither) {
            //mDither = dither;
            //invalidateSelf();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.161 -0400", hash_original_method = "0D338CBBF9E8A18D18E6BF68648024B0", hash_generated_method = "E8ED7A6FB7C27ADA4C90E53A829FBFD4")
    @Override
    public void setColorFilter(ColorFilter cf) {
    if(cf != mColorFilter)        
        {
            mColorFilter = cf;
            invalidateSelf();
        } //End block
        // ---------- Original Method ----------
        //if (cf != mColorFilter) {
            //mColorFilter = cf;
            //invalidateSelf();
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.162 -0400", hash_original_method = "AB3D570DA2A917C408AB4F7D8FCD7103", hash_generated_method = "B157425A7FC06C2FE7F337C141AA7EDD")
    @Override
    public int getOpacity() {
        int var26C79996E92FCFBDC98A49C80BC91AD0_1529958737 = (PixelFormat.TRANSLUCENT);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_387611992 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_387611992;
        // ---------- Original Method ----------
        //return PixelFormat.TRANSLUCENT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.163 -0400", hash_original_method = "8123137F2C4F03B6AAC99B13B8B696DA", hash_generated_method = "FC47C355C71E5444513F872D43554314")
    @Override
    protected void onBoundsChange(Rect r) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(r.getTaint());
        super.onBoundsChange(r);
        mRingPath = null;
        mPathIsDirty = true;
        mRectIsDirty = true;
        // ---------- Original Method ----------
        //super.onBoundsChange(r);
        //mRingPath = null;
        //mPathIsDirty = true;
        //mRectIsDirty = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.165 -0400", hash_original_method = "394C06781A7C1BB568DD9A62F4177986", hash_generated_method = "D31C4CE306E50AC2B8CC1FDB6033B6CD")
    @Override
    protected boolean onLevelChange(int level) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(level);
        super.onLevelChange(level);
        mRectIsDirty = true;
        mPathIsDirty = true;
        invalidateSelf();
        boolean varB326B5062B2F0E69046810717534CB09_1597137099 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1936160765 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1936160765;
        // ---------- Original Method ----------
        //super.onLevelChange(level);
        //mRectIsDirty = true;
        //mPathIsDirty = true;
        //invalidateSelf();
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.176 -0400", hash_original_method = "A926FB4015A038016094FA9870012FFA", hash_generated_method = "DC839A36DA290B4E1B0E2B1385B7E95F")
    private boolean ensureValidRect() {
    if(mRectIsDirty)        
        {
            mRectIsDirty = false;
            Rect bounds = getBounds();
            float inset = 0;
    if(mStrokePaint != null)            
            {
                inset = mStrokePaint.getStrokeWidth() * 0.5f;
            } //End block
            final GradientState st = mGradientState;
            mRect.set(bounds.left + inset, bounds.top + inset,
                      bounds.right - inset, bounds.bottom - inset);
            final int[] colors = st.mColors;
    if(colors != null)            
            {
                RectF r = mRect;
                float x0;
                float x1;
                float y0;
                float y1;
    if(st.mGradient == LINEAR_GRADIENT)                
                {
                    final float level = st.mUseLevel ? (float) getLevel() / 10000.0f : 1.0f;
switch(st.mOrientation){
                    case TOP_BOTTOM:
                    x0 = r.left;
                    y0 = r.top;
                    x1 = x0;
                    y1 = level * r.bottom;
                    break;
                    case TR_BL:
                    x0 = r.right;
                    y0 = r.top;
                    x1 = level * r.left;
                    y1 = level * r.bottom;
                    break;
                    case RIGHT_LEFT:
                    x0 = r.right;
                    y0 = r.top;
                    x1 = level * r.left;
                    y1 = y0;
                    break;
                    case BR_TL:
                    x0 = r.right;
                    y0 = r.bottom;
                    x1 = level * r.left;
                    y1 = level * r.top;
                    break;
                    case BOTTOM_TOP:
                    x0 = r.left;
                    y0 = r.bottom;
                    x1 = x0;
                    y1 = level * r.top;
                    break;
                    case BL_TR:
                    x0 = r.left;
                    y0 = r.bottom;
                    x1 = level * r.right;
                    y1 = level * r.top;
                    break;
                    case LEFT_RIGHT:
                    x0 = r.left;
                    y0 = r.top;
                    x1 = level * r.right;
                    y1 = y0;
                    break;
                    default:
                    x0 = r.left;
                    y0 = r.top;
                    x1 = level * r.right;
                    y1 = level * r.bottom;
                    break;
}                    mFillPaint.setShader(new LinearGradient(x0, y0, x1, y1,
                            colors, st.mPositions, Shader.TileMode.CLAMP));
                } //End block
                else
    if(st.mGradient == RADIAL_GRADIENT)                
                {
                    x0 = r.left + (r.right - r.left) * st.mCenterX;
                    y0 = r.top + (r.bottom - r.top) * st.mCenterY;
                    final float level = st.mUseLevel ? (float) getLevel() / 10000.0f : 1.0f;
                    mFillPaint.setShader(new RadialGradient(x0, y0,
                            level * st.mGradientRadius, colors, null,
                            Shader.TileMode.CLAMP));
                } //End block
                else
    if(st.mGradient == SWEEP_GRADIENT)                
                {
                    x0 = r.left + (r.right - r.left) * st.mCenterX;
                    y0 = r.top + (r.bottom - r.top) * st.mCenterY;
                    int[] tempColors = colors;
                    float[] tempPositions = null;
    if(st.mUseLevel)                    
                    {
                        tempColors = st.mTempColors;
                        final int length = colors.length;
    if(tempColors == null || tempColors.length != length + 1)                        
                        {
                            tempColors = st.mTempColors = new int[length + 1];
                        } //End block
                        System.arraycopy(colors, 0, tempColors, 0, length);
                        tempColors[length] = colors[length - 1];
                        tempPositions = st.mTempPositions;
                        final float fraction = 1.0f / (float) (length - 1);
    if(tempPositions == null || tempPositions.length != length + 1)                        
                        {
                            tempPositions = st.mTempPositions = new float[length + 1];
                        } //End block
                        final float level = (float) getLevel() / 10000.0f;
for(int i = 0;i < length;i++)
                        {
                            tempPositions[i] = i * fraction * level;
                        } //End block
                        tempPositions[length] = 1.0f;
                    } //End block
                    mFillPaint.setShader(new SweepGradient(x0, y0, tempColors, tempPositions));
                } //End block
            } //End block
        } //End block
        boolean var8286004AF800660B751E28695C24B502_1527861614 = (!mRect.isEmpty());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_507661077 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_507661077;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.193 -0400", hash_original_method = "E432865D544D266B015263529D7B28D5", hash_generated_method = "958B8AEB4F592394E88B530531681E0E")
    @Override
    public void inflate(Resources r, XmlPullParser parser,
            AttributeSet attrs) throws XmlPullParserException, IOException {
        addTaint(attrs.getTaint());
        addTaint(parser.getTaint());
        addTaint(r.getTaint());
        final GradientState st = mGradientState;
        TypedArray a = r.obtainAttributes(attrs,
                com.android.internal.R.styleable.GradientDrawable);
        super.inflateWithAttributes(r, parser, a,
                com.android.internal.R.styleable.GradientDrawable_visible);
        int shapeType = a.getInt(
                com.android.internal.R.styleable.GradientDrawable_shape, RECTANGLE);
        boolean dither = a.getBoolean(
                com.android.internal.R.styleable.GradientDrawable_dither, false);
    if(shapeType == RING)        
        {
            st.mInnerRadius = a.getDimensionPixelSize(
                    com.android.internal.R.styleable.GradientDrawable_innerRadius, -1);
    if(st.mInnerRadius == -1)            
            {
                st.mInnerRadiusRatio = a.getFloat(
                        com.android.internal.R.styleable.GradientDrawable_innerRadiusRatio, 3.0f);
            } //End block
            st.mThickness = a.getDimensionPixelSize(
                    com.android.internal.R.styleable.GradientDrawable_thickness, -1);
    if(st.mThickness == -1)            
            {
                st.mThicknessRatio = a.getFloat(
                        com.android.internal.R.styleable.GradientDrawable_thicknessRatio, 9.0f);
            } //End block
            st.mUseLevelForShape = a.getBoolean(
                    com.android.internal.R.styleable.GradientDrawable_useLevel, true);
        } //End block
        a.recycle();
        setShape(shapeType);
        setDither(dither);
        int type;
        final int innerDepth = parser.getDepth() + 1;
        int depth;
        while
((type=parser.next()) != XmlPullParser.END_DOCUMENT
               && ((depth=parser.getDepth()) >= innerDepth
                       || type != XmlPullParser.END_TAG))        
        {
    if(type != XmlPullParser.START_TAG)            
            {
                continue;
            } //End block
    if(depth > innerDepth)            
            {
                continue;
            } //End block
            String name = parser.getName();
    if(name.equals("size"))            
            {
                a = r.obtainAttributes(attrs,
                        com.android.internal.R.styleable.GradientDrawableSize);
                int width = a.getDimensionPixelSize(
                        com.android.internal.R.styleable.GradientDrawableSize_width, -1);
                int height = a.getDimensionPixelSize(
                        com.android.internal.R.styleable.GradientDrawableSize_height, -1);
                a.recycle();
                setSize(width, height);
            } //End block
            else
    if(name.equals("gradient"))            
            {
                a = r.obtainAttributes(attrs,
                        com.android.internal.R.styleable.GradientDrawableGradient);
                int startColor = a.getColor(
                        com.android.internal.R.styleable.GradientDrawableGradient_startColor, 0);
                boolean hasCenterColor = a
                        .hasValue(com.android.internal.R.styleable.GradientDrawableGradient_centerColor);
                int centerColor = a.getColor(
                        com.android.internal.R.styleable.GradientDrawableGradient_centerColor, 0);
                int endColor = a.getColor(
                        com.android.internal.R.styleable.GradientDrawableGradient_endColor, 0);
                int gradientType = a.getInt(
                        com.android.internal.R.styleable.GradientDrawableGradient_type,
                        LINEAR_GRADIENT);
                st.mCenterX = getFloatOrFraction(
                        a,
                        com.android.internal.R.styleable.GradientDrawableGradient_centerX,
                        0.5f);
                st.mCenterY = getFloatOrFraction(
                        a,
                        com.android.internal.R.styleable.GradientDrawableGradient_centerY,
                        0.5f);
                st.mUseLevel = a.getBoolean(
                        com.android.internal.R.styleable.GradientDrawableGradient_useLevel, false);
                st.mGradient = gradientType;
    if(gradientType == LINEAR_GRADIENT)                
                {
                    int angle = (int)a.getFloat(
                            com.android.internal.R.styleable.GradientDrawableGradient_angle, 0);
                    angle %= 360;
    if(angle % 45 != 0)                    
                    {
                        XmlPullParserException var6C0F065FCCE9376FFD5DF490D8604FCA_1947652761 = new XmlPullParserException(a.getPositionDescription()
                                + "<gradient> tag requires 'angle' attribute to "
                                + "be a multiple of 45");
                        var6C0F065FCCE9376FFD5DF490D8604FCA_1947652761.addTaint(taint);
                        throw var6C0F065FCCE9376FFD5DF490D8604FCA_1947652761;
                    } //End block
switch(angle){
                    case 0:
                    st.mOrientation = Orientation.LEFT_RIGHT;
                    break;
                    case 45:
                    st.mOrientation = Orientation.BL_TR;
                    break;
                    case 90:
                    st.mOrientation = Orientation.BOTTOM_TOP;
                    break;
                    case 135:
                    st.mOrientation = Orientation.BR_TL;
                    break;
                    case 180:
                    st.mOrientation = Orientation.RIGHT_LEFT;
                    break;
                    case 225:
                    st.mOrientation = Orientation.TR_BL;
                    break;
                    case 270:
                    st.mOrientation = Orientation.TOP_BOTTOM;
                    break;
                    case 315:
                    st.mOrientation = Orientation.TL_BR;
                    break;
}
                } //End block
                else
                {
                    TypedValue tv = a.peekValue(
                            com.android.internal.R.styleable.GradientDrawableGradient_gradientRadius);
    if(tv != null)                    
                    {
                        boolean radiusRel = tv.type == TypedValue.TYPE_FRACTION;
                        st.mGradientRadius = radiusRel ?
                                tv.getFraction(1.0f, 1.0f) : tv.getFloat();
                    } //End block
                    else
    if(gradientType == RADIAL_GRADIENT)                    
                    {
                        XmlPullParserException var97828630D4606D35B13139B5319854D0_698672508 = new XmlPullParserException(
                                a.getPositionDescription()
                                + "<gradient> tag requires 'gradientRadius' "
                                + "attribute with radial type");
                        var97828630D4606D35B13139B5319854D0_698672508.addTaint(taint);
                        throw var97828630D4606D35B13139B5319854D0_698672508;
                    } //End block
                } //End block
                a.recycle();
    if(hasCenterColor)                
                {
                    st.mColors = new int[3];
                    st.mColors[0] = startColor;
                    st.mColors[1] = centerColor;
                    st.mColors[2] = endColor;
                    st.mPositions = new float[3];
                    st.mPositions[0] = 0.0f;
                    st.mPositions[1] = st.mCenterX != 0.5f ? st.mCenterX : st.mCenterY;
                    st.mPositions[2] = 1f;
                } //End block
                else
                {
                    st.mColors = new int[2];
                    st.mColors[0] = startColor;
                    st.mColors[1] = endColor;
                } //End block
            } //End block
            else
    if(name.equals("solid"))            
            {
                a = r.obtainAttributes(attrs,
                        com.android.internal.R.styleable.GradientDrawableSolid);
                int argb = a.getColor(
                        com.android.internal.R.styleable.GradientDrawableSolid_color, 0);
                a.recycle();
                setColor(argb);
            } //End block
            else
    if(name.equals("stroke"))            
            {
                a = r.obtainAttributes(attrs,
                        com.android.internal.R.styleable.GradientDrawableStroke);
                int width = a.getDimensionPixelSize(
                        com.android.internal.R.styleable.GradientDrawableStroke_width, 0);
                int color = a.getColor(
                        com.android.internal.R.styleable.GradientDrawableStroke_color, 0);
                float dashWidth = a.getDimension(
                        com.android.internal.R.styleable.GradientDrawableStroke_dashWidth, 0);
    if(dashWidth != 0.0f)                
                {
                    float dashGap = a.getDimension(
                            com.android.internal.R.styleable.GradientDrawableStroke_dashGap, 0);
                    setStroke(width, color, dashWidth, dashGap);
                } //End block
                else
                {
                    setStroke(width, color);
                } //End block
                a.recycle();
            } //End block
            else
    if(name.equals("corners"))            
            {
                a = r.obtainAttributes(attrs,
                        com.android.internal.R.styleable.DrawableCorners);
                int radius = a.getDimensionPixelSize(
                        com.android.internal.R.styleable.DrawableCorners_radius, 0);
                setCornerRadius(radius);
                int topLeftRadius = a.getDimensionPixelSize(
                        com.android.internal.R.styleable.DrawableCorners_topLeftRadius, radius);
                int topRightRadius = a.getDimensionPixelSize(
                        com.android.internal.R.styleable.DrawableCorners_topRightRadius, radius);
                int bottomLeftRadius = a.getDimensionPixelSize(
                        com.android.internal.R.styleable.DrawableCorners_bottomLeftRadius, radius);
                int bottomRightRadius = a.getDimensionPixelSize(
                        com.android.internal.R.styleable.DrawableCorners_bottomRightRadius, radius);
    if(topLeftRadius != radius || topRightRadius != radius ||
                        bottomLeftRadius != radius || bottomRightRadius != radius)                
                {
                    setCornerRadii(new float[] {
                            topLeftRadius, topLeftRadius,
                            topRightRadius, topRightRadius,
                            bottomRightRadius, bottomRightRadius,
                            bottomLeftRadius, bottomLeftRadius
                    });
                } //End block
                a.recycle();
            } //End block
            else
    if(name.equals("padding"))            
            {
                a = r.obtainAttributes(attrs,
                        com.android.internal.R.styleable.GradientDrawablePadding);
                mPadding = new Rect(
                        a.getDimensionPixelOffset(
                                com.android.internal.R.styleable.GradientDrawablePadding_left, 0),
                        a.getDimensionPixelOffset(
                                com.android.internal.R.styleable.GradientDrawablePadding_top, 0),
                        a.getDimensionPixelOffset(
                                com.android.internal.R.styleable.GradientDrawablePadding_right, 0),
                        a.getDimensionPixelOffset(
                                com.android.internal.R.styleable.GradientDrawablePadding_bottom, 0));
                a.recycle();
                mGradientState.mPadding = mPadding;
            } //End block
            else
            {
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        private static float getFloatOrFraction(TypedArray a, int index, float defaultValue) {
        TypedValue tv = a.peekValue(index);
        float v = defaultValue;
        if (tv != null) {
            boolean vIsFraction = tv.type == TypedValue.TYPE_FRACTION;
            v = vIsFraction ? tv.getFraction(1.0f, 1.0f) : tv.getFloat();
        }
        return v;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.197 -0400", hash_original_method = "312782D78F9C32949C3B038C307C5C9C", hash_generated_method = "92AC43DEC18166FB1DC0EA65896D5BDE")
    @Override
    public int getIntrinsicWidth() {
        int var74AF5FCC2B4095ECF454EBE771815BD4_616036368 = (mGradientState.mWidth);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_292343891 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_292343891;
        // ---------- Original Method ----------
        //return mGradientState.mWidth;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.198 -0400", hash_original_method = "A19A1B01925414A773BB5AE9FBB4894A", hash_generated_method = "C4FDB4F3D30EF4FFCD835572BE9AE84B")
    @Override
    public int getIntrinsicHeight() {
        int varFD485037F00187CBBEA33D5A83F33FE2_1741429551 = (mGradientState.mHeight);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1919719670 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1919719670;
        // ---------- Original Method ----------
        //return mGradientState.mHeight;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.199 -0400", hash_original_method = "DD96D81CE576A9B12867099611327831", hash_generated_method = "A56A7CFA6D758C45BE3D33945C2EEE9B")
    @Override
    public ConstantState getConstantState() {
        mGradientState.mChangingConfigurations = getChangingConfigurations();
ConstantState varCEF9B18FE545E8BB329CFF6339343CED_2014490097 =         mGradientState;
        varCEF9B18FE545E8BB329CFF6339343CED_2014490097.addTaint(taint);
        return varCEF9B18FE545E8BB329CFF6339343CED_2014490097;
        // ---------- Original Method ----------
        //mGradientState.mChangingConfigurations = getChangingConfigurations();
        //return mGradientState;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.200 -0400", hash_original_method = "D4EF431721248824E2CCEA5FA3C5FD74", hash_generated_method = "A6DA5160E9F98A424730359437704D82")
    @Override
    public Drawable mutate() {
    if(!mMutated && super.mutate() == this)        
        {
            mGradientState = new GradientState(mGradientState);
            initializeWithState(mGradientState);
            mMutated = true;
        } //End block
Drawable var72A74007B2BE62B849F475C7BDA4658B_1171855264 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1171855264.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1171855264;
        // ---------- Original Method ----------
        //if (!mMutated && super.mutate() == this) {
            //mGradientState = new GradientState(mGradientState);
            //initializeWithState(mGradientState);
            //mMutated = true;
        //}
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.203 -0400", hash_original_method = "7FA7686AE1E8AEF57BBE0E6293CFBCA1", hash_generated_method = "6B6856A93466D0993964E963504AF22D")
    private void initializeWithState(GradientState state) {
    if(state.mHasSolidColor)        
        {
            mFillPaint.setColor(state.mSolidColor);
        } //End block
        mPadding = state.mPadding;
    if(state.mStrokeWidth >= 0)        
        {
            mStrokePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
            mStrokePaint.setStyle(Paint.Style.STROKE);
            mStrokePaint.setStrokeWidth(state.mStrokeWidth);
            mStrokePaint.setColor(state.mStrokeColor);
    if(state.mStrokeDashWidth != 0.0f)            
            {
                DashPathEffect e = new DashPathEffect(
                        new float[] { state.mStrokeDashWidth, state.mStrokeDashGap }, 0);
                mStrokePaint.setPathEffect(e);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (state.mHasSolidColor) {
            //mFillPaint.setColor(state.mSolidColor);
        //}
        //mPadding = state.mPadding;
        //if (state.mStrokeWidth >= 0) {
            //mStrokePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
            //mStrokePaint.setStyle(Paint.Style.STROKE);
            //mStrokePaint.setStrokeWidth(state.mStrokeWidth);
            //mStrokePaint.setColor(state.mStrokeColor);
            //if (state.mStrokeDashWidth != 0.0f) {
                //DashPathEffect e = new DashPathEffect(
                        //new float[] { state.mStrokeDashWidth, state.mStrokeDashGap }, 0);
                //mStrokePaint.setPathEffect(e);
            //}
        //}
    }

    
    public enum Orientation {
        TOP_BOTTOM,
        TR_BL,
        RIGHT_LEFT,
        BR_TL,
        BOTTOM_TOP,
        BL_TR,
        LEFT_RIGHT,
        TL_BR,
    }

    
    final static class GradientState extends ConstantState {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.205 -0400", hash_original_field = "276E0645C4E2084773D0EB8C5576428C", hash_generated_field = "0AA9CE94E21E2967183254C710B3C74D")

        public int mChangingConfigurations;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.205 -0400", hash_original_field = "C6B10B6E8FCFBBD6158DCF7BAF067E37", hash_generated_field = "30E32F1749CDDDAEE9911840601071DF")

        public int mShape = RECTANGLE;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.205 -0400", hash_original_field = "5676A2E63CEC3653FC9C82DADC4AF123", hash_generated_field = "56AB8E99AC45CB5CF4856C66FC6C47BB")

        public int mGradient = LINEAR_GRADIENT;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.206 -0400", hash_original_field = "7EA67827B94D10D1A4B368659EA63B71", hash_generated_field = "5AAEB1A21C682D9B78B733C0CAC81941")

        public Orientation mOrientation;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.206 -0400", hash_original_field = "F5B754067786840AA79148E1DA0BE95F", hash_generated_field = "3DBFAFBF2A210B2DCF4FE4AD0EE5F8A6")

        public int[] mColors;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.206 -0400", hash_original_field = "6CF1BB39416B1F09EF9D4E55A7941DD8", hash_generated_field = "173AA4B8B328A9892BF919E827149210")

        public int[] mTempColors;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.206 -0400", hash_original_field = "661C7BCF2E48C776BC9666E0EB9575F4", hash_generated_field = "43B2C9F377E90B066E4C6E0D502B88B5")

        public float[] mTempPositions;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.206 -0400", hash_original_field = "26068CDE4606F66C00056226111A3D61", hash_generated_field = "0691E3BE2D5AF1DE0154EF51BF6FCC3F")

        public float[] mPositions;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.206 -0400", hash_original_field = "0667246F9F18FDB890097AB34879167E", hash_generated_field = "17699B1A481FD58663277C59922F1CEC")

        public boolean mHasSolidColor;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.206 -0400", hash_original_field = "F761CF39D7B955BCB3910DD42D5B01E4", hash_generated_field = "6D0CD94C8238CE1C7956AFFDD29448AB")

        public int mSolidColor;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.207 -0400", hash_original_field = "F5273FFC49F0A2E75F684E1694B3B99D", hash_generated_field = "FBAAA34191259B10F232ADA2E3E6394F")

        public int mStrokeWidth = -1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.207 -0400", hash_original_field = "5795B8DC82C65556442F6200AD3A0EFC", hash_generated_field = "419129050F20C5FB9C65BFF93C429846")

        public int mStrokeColor;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.207 -0400", hash_original_field = "E3F49F22E23DB70A5F66B08B231C5462", hash_generated_field = "E26B465C065311CE0DE125D881B1D6E4")

        public float mStrokeDashWidth;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.207 -0400", hash_original_field = "A9F8F629DF69B895A0A45B9469988030", hash_generated_field = "B7852ABE2A09DB5F018447DAFA4BEEA9")

        public float mStrokeDashGap;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.207 -0400", hash_original_field = "B6EC135CB02066C1F33BA594902CBCC5", hash_generated_field = "17C7B79DFE9D3EEDD5E13C8AE4106B7D")

        public float mRadius;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.207 -0400", hash_original_field = "8140156D1EB5C39D070BB9A29E414C53", hash_generated_field = "0DA8B2C59E5420343AB30AE4DAA09601")

        public float[] mRadiusArray;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.207 -0400", hash_original_field = "9AC2544B5F9B8F60AA16656C94B57A8E", hash_generated_field = "8BBE9A045863D1F1F36EF813DE381D19")

        public Rect mPadding;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.207 -0400", hash_original_field = "A95631D81A2F2A7712CA1BACF8C3ED06", hash_generated_field = "1F9F6152246BD7DF79E6A284B49AF5F7")

        public int mWidth = -1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.208 -0400", hash_original_field = "B3AC750C72790F3A16FDCF47C86F48B7", hash_generated_field = "3A8CC26D109E69BFF346846D33EDE147")

        public int mHeight = -1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.208 -0400", hash_original_field = "1447A3152E9A5913C6245E29FDB204D1", hash_generated_field = "EB439DDC162B134FDA45E4F31A401D74")

        public float mInnerRadiusRatio;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.208 -0400", hash_original_field = "AD2C3563C09F6E98C0E761B5139A13A9", hash_generated_field = "39143D03DDE6F90F181E5B5DD3A18D8A")

        public float mThicknessRatio;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.208 -0400", hash_original_field = "731FB099D813D36E5B5100327955DDC0", hash_generated_field = "4DAAD7CE805773321F0C839951BF2F2D")

        public int mInnerRadius;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.208 -0400", hash_original_field = "504B9C20E398FD3A7D439D846A6CD818", hash_generated_field = "6358B57C3CC1F35B6E87ABD152B05898")

        public int mThickness;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.208 -0400", hash_original_field = "E23468CE053BA9207F87E59A2E6FAF8E", hash_generated_field = "5320CC7D83EC889F3C8D0197A0A7D909")

        private float mCenterX = 0.5f;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.208 -0400", hash_original_field = "E67B30AFFEB9530950B311F9AE35117B", hash_generated_field = "F307C555105E507E98EC0E358F605D84")

        private float mCenterY = 0.5f;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.208 -0400", hash_original_field = "CFEBBA7E330C7A3AC631943D5B123D20", hash_generated_field = "B9F1B6CC2ED8A4CB332BB75E0FD2137D")

        private float mGradientRadius = 0.5f;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.208 -0400", hash_original_field = "60A954EDC3ADF7263D111F1071671693", hash_generated_field = "5175CF60B12798080A42C69647993770")

        private boolean mUseLevel;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.209 -0400", hash_original_field = "C95C1388DC880DCBF9DACF9BC48190A8", hash_generated_field = "61E410A7B6997232E247B7717F217062")

        private boolean mUseLevelForShape;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.209 -0400", hash_original_method = "9C4B8156D5998AA4F070091BFAC51297", hash_generated_method = "36EA0AD2FEF9D7DF957604ED73351F6F")
          GradientState() {
            mOrientation = Orientation.TOP_BOTTOM;
            // ---------- Original Method ----------
            //mOrientation = Orientation.TOP_BOTTOM;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.209 -0400", hash_original_method = "D56C041244D40E3233BE0185764F984A", hash_generated_method = "DCD98CC869C46D3675D13FDE4D8B9C1F")
          GradientState(Orientation orientation, int[] colors) {
            mOrientation = orientation;
            mColors = colors;
            // ---------- Original Method ----------
            //mOrientation = orientation;
            //mColors = colors;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.215 -0400", hash_original_method = "E9F630A8A3449D4E0942DD92A53A8789", hash_generated_method = "54B11CD7D8A8D825E0378AFCF9BDBF78")
        public  GradientState(GradientState state) {
            mChangingConfigurations = state.mChangingConfigurations;
            mShape = state.mShape;
            mGradient = state.mGradient;
            mOrientation = state.mOrientation;
    if(state.mColors != null)            
            {
                mColors = state.mColors.clone();
            } //End block
    if(state.mPositions != null)            
            {
                mPositions = state.mPositions.clone();
            } //End block
            mHasSolidColor = state.mHasSolidColor;
            mSolidColor = state.mSolidColor;
            mStrokeWidth = state.mStrokeWidth;
            mStrokeColor = state.mStrokeColor;
            mStrokeDashWidth = state.mStrokeDashWidth;
            mStrokeDashGap = state.mStrokeDashGap;
            mRadius = state.mRadius;
    if(state.mRadiusArray != null)            
            {
                mRadiusArray = state.mRadiusArray.clone();
            } //End block
    if(state.mPadding != null)            
            {
                mPadding = new Rect(state.mPadding);
            } //End block
            mWidth = state.mWidth;
            mHeight = state.mHeight;
            mInnerRadiusRatio = state.mInnerRadiusRatio;
            mThicknessRatio = state.mThicknessRatio;
            mInnerRadius = state.mInnerRadius;
            mThickness = state.mThickness;
            mCenterX = state.mCenterX;
            mCenterY = state.mCenterY;
            mGradientRadius = state.mGradientRadius;
            mUseLevel = state.mUseLevel;
            mUseLevelForShape = state.mUseLevelForShape;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.215 -0400", hash_original_method = "995801C56CB4C9E6715A12BAA40CCB03", hash_generated_method = "970FDD5B2F64C60EA927D24694EBBB63")
        @Override
        public Drawable newDrawable() {
Drawable var3A2E8558FFCC994DB93A13AF4E9CDC52_1833467522 =             new GradientDrawable(this);
            var3A2E8558FFCC994DB93A13AF4E9CDC52_1833467522.addTaint(taint);
            return var3A2E8558FFCC994DB93A13AF4E9CDC52_1833467522;
            // ---------- Original Method ----------
            //return new GradientDrawable(this);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.215 -0400", hash_original_method = "C54DA0CD853A4A5864DFD734D15AF82F", hash_generated_method = "805558D04579AD2838AE020B776FC98C")
        @Override
        public Drawable newDrawable(Resources res) {
            addTaint(res.getTaint());
Drawable var3A2E8558FFCC994DB93A13AF4E9CDC52_1668304601 =             new GradientDrawable(this);
            var3A2E8558FFCC994DB93A13AF4E9CDC52_1668304601.addTaint(taint);
            return var3A2E8558FFCC994DB93A13AF4E9CDC52_1668304601;
            // ---------- Original Method ----------
            //return new GradientDrawable(this);
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.216 -0400", hash_original_method = "9E7D7C67EAC365FF19BD4971762612A5", hash_generated_method = "A559729D30BF9E28672CE278551F3E29")
        @Override
        public int getChangingConfigurations() {
            int var276E0645C4E2084773D0EB8C5576428C_1116626839 = (mChangingConfigurations);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_845269159 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_845269159;
            // ---------- Original Method ----------
            //return mChangingConfigurations;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.216 -0400", hash_original_method = "0F10CA732F07DD9FE38CDA7CBCDABA95", hash_generated_method = "A3BF6B156577AD7EA2864200A6B2814C")
        public void setShape(int shape) {
            mShape = shape;
            // ---------- Original Method ----------
            //mShape = shape;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.217 -0400", hash_original_method = "6060B2E1C6E57F715C4E87E13018C121", hash_generated_method = "3AF067B4A790D8213658929FBB0E68D9")
        public void setGradientType(int gradient) {
            mGradient = gradient;
            // ---------- Original Method ----------
            //mGradient = gradient;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.217 -0400", hash_original_method = "90316D628B1BD1AAC4CD928A74CE9FD1", hash_generated_method = "4D02E3166FD3347AE6D9D6E0C8FEC8F1")
        public void setGradientCenter(float x, float y) {
            mCenterX = x;
            mCenterY = y;
            // ---------- Original Method ----------
            //mCenterX = x;
            //mCenterY = y;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.218 -0400", hash_original_method = "829DF5400D64CA55E626852A56B8E3B1", hash_generated_method = "3317E7F80C009F128AAB1DCE552FD5F5")
        public void setSolidColor(int argb) {
            mHasSolidColor = true;
            mSolidColor = argb;
            mColors = null;
            // ---------- Original Method ----------
            //mHasSolidColor = true;
            //mSolidColor = argb;
            //mColors = null;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.219 -0400", hash_original_method = "0625749E363A97E3FB7A01916551E363", hash_generated_method = "C44E1F10EA13CAA1D96956245AF57DBD")
        public void setStroke(int width, int color) {
            mStrokeWidth = width;
            mStrokeColor = color;
            // ---------- Original Method ----------
            //mStrokeWidth = width;
            //mStrokeColor = color;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.220 -0400", hash_original_method = "62694733BCC23283C4956406C2DF326D", hash_generated_method = "215F441E5518AD68D917B36A2FBC122A")
        public void setStroke(int width, int color, float dashWidth, float dashGap) {
            mStrokeWidth = width;
            mStrokeColor = color;
            mStrokeDashWidth = dashWidth;
            mStrokeDashGap = dashGap;
            // ---------- Original Method ----------
            //mStrokeWidth = width;
            //mStrokeColor = color;
            //mStrokeDashWidth = dashWidth;
            //mStrokeDashGap = dashGap;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.220 -0400", hash_original_method = "55392135B56F7FBDA5D3E3F94BBF1F23", hash_generated_method = "6DD2CFD87AEC9286FB7AD8FE993F4EF8")
        public void setCornerRadius(float radius) {
    if(radius < 0)            
            {
                radius = 0;
            } //End block
            mRadius = radius;
            mRadiusArray = null;
            // ---------- Original Method ----------
            //if (radius < 0) {
                //radius = 0;
            //}
            //mRadius = radius;
            //mRadiusArray = null;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.221 -0400", hash_original_method = "17EB6FE4DB8FF42541FF19B71843B23B", hash_generated_method = "DBFBC3C26C02E8F16F6EBAC59B75984F")
        public void setCornerRadii(float[] radii) {
            mRadiusArray = radii;
    if(radii == null)            
            {
                mRadius = 0;
            } //End block
            // ---------- Original Method ----------
            //mRadiusArray = radii;
            //if (radii == null) {
                //mRadius = 0;
            //}
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.222 -0400", hash_original_method = "2560E21D822EB58266D32B5FBCFCA888", hash_generated_method = "937C2CF909C70F6CCE7A1CB2903577B5")
        public void setSize(int width, int height) {
            mWidth = width;
            mHeight = height;
            // ---------- Original Method ----------
            //mWidth = width;
            //mHeight = height;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.222 -0400", hash_original_method = "2D6DAC1104AA515AA78A28549F71CF0A", hash_generated_method = "47173080DDFD0B34A1D1F0DBFA24FE39")
        public void setGradientRadius(float gradientRadius) {
            mGradientRadius = gradientRadius;
            // ---------- Original Method ----------
            //mGradientRadius = gradientRadius;
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.222 -0400", hash_original_field = "6F6AD2BCE07B65CD47EF4D9E6AB86535", hash_generated_field = "46F776F4431B4AF5C3D3F15529915765")

    public static final int RECTANGLE = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.222 -0400", hash_original_field = "FA8319B0F3C7FFA99A9E2ED3934E43A6", hash_generated_field = "92F4ECF41E9A60B25A48F6BCF0A0A460")

    public static final int OVAL = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.223 -0400", hash_original_field = "D7BF7169F91A744DA6D893A0B94DE568", hash_generated_field = "8FA318F64C1EA44E4135E7B1C9F3F53D")

    public static final int LINE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.223 -0400", hash_original_field = "4E5E35B60A98BA38CA2EE85CA463EE6B", hash_generated_field = "49E47CDC93342C4EA5D171A90156D57F")

    public static final int RING = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.223 -0400", hash_original_field = "A46CDAED2F7CD310C857690734CA8898", hash_generated_field = "9F6612F723A63EEE72B0859940E37105")

    public static final int LINEAR_GRADIENT = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.223 -0400", hash_original_field = "E7C810F9A8263081A505D6276CA240DD", hash_generated_field = "262A5D2CC9AE6734365493D15224EC30")

    public static final int RADIAL_GRADIENT = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.223 -0400", hash_original_field = "F8EB4F09BE09B068FC74D809D5EDB13D", hash_generated_field = "6BE6B5DD9A6FF64825BE79B8763B5D70")

    public static final int SWEEP_GRADIENT  = 2;
}

