package android.graphics.drawable;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
    private GradientState mGradientState;
    private Paint mFillPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Rect mPadding;
    private Paint mStrokePaint;
    private ColorFilter mColorFilter;
    private int mAlpha = 0xFF;
    private boolean mDither;
    private Path mPath = new Path();
    private RectF mRect = new RectF();
    private Paint mLayerPaint;
    private boolean mRectIsDirty;
    private boolean mMutated;
    private Path mRingPath;
    private boolean mPathIsDirty = true;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.320 -0400", hash_original_method = "64287040FBFB7F81692AADB4245B0378", hash_generated_method = "78296307B8E83E1FC392EC6080C25EE7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public GradientDrawable() {
        this(new GradientState(Orientation.TOP_BOTTOM, null));
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.320 -0400", hash_original_method = "48FF7A4A9E39F0BE519CF2AE778248C7", hash_generated_method = "30E94B4DF9AE4A42FFF6AE55B8C90BDD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public GradientDrawable(Orientation orientation, int[] colors) {
        this(new GradientState(orientation, colors));
        dsTaint.addTaint(orientation.dsTaint);
        dsTaint.addTaint(colors[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.320 -0400", hash_original_method = "11AB49F3A166C4EC986EE8723C09CE3C", hash_generated_method = "17FB1E8E03D9D8888E0C2C676DDA8710")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private GradientDrawable(GradientState state) {
        dsTaint.addTaint(state.dsTaint);
        initializeWithState(state);
        mRectIsDirty = true;
        // ---------- Original Method ----------
        //mGradientState = state;
        //initializeWithState(state);
        //mRectIsDirty = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.321 -0400", hash_original_method = "0B8807A1903E03E118A45AC647AD9F24", hash_generated_method = "EF170CEA1CDF9ABC90517684B042BAD4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean getPadding(Rect padding) {
        dsTaint.addTaint(padding.dsTaint);
        {
            padding.set(mPadding);
        } //End block
        {
            boolean var26681595319194856AEB3747307B6E08_1927518956 = (super.getPadding(padding));
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mPadding != null) {
            //padding.set(mPadding);
            //return true;
        //} else {
            //return super.getPadding(padding);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.321 -0400", hash_original_method = "71F948CC6AEC5EB6067752059DA33574", hash_generated_method = "996D9AA9996C3116E18878B2987B9C7A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setCornerRadii(float[] radii) {
        dsTaint.addTaint(radii[0]);
        mGradientState.setCornerRadii(radii);
        mPathIsDirty = true;
        invalidateSelf();
        // ---------- Original Method ----------
        //mGradientState.setCornerRadii(radii);
        //mPathIsDirty = true;
        //invalidateSelf();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.321 -0400", hash_original_method = "AFB7C3E5AE7C3BBB28B141F7A3B472BE", hash_generated_method = "43767CB5CC58A30703769B6364F7A7CB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setCornerRadius(float radius) {
        dsTaint.addTaint(radius);
        mGradientState.setCornerRadius(radius);
        mPathIsDirty = true;
        invalidateSelf();
        // ---------- Original Method ----------
        //mGradientState.setCornerRadius(radius);
        //mPathIsDirty = true;
        //invalidateSelf();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.322 -0400", hash_original_method = "6A0F62EB2F02BD455327DA9DA2DD0568", hash_generated_method = "17906B2A0239ECB768D5540B48C956F8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setStroke(int width, int color) {
        dsTaint.addTaint(color);
        dsTaint.addTaint(width);
        setStroke(width, color, 0, 0);
        // ---------- Original Method ----------
        //setStroke(width, color, 0, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.322 -0400", hash_original_method = "F36B912577B048DA0236870F939930FC", hash_generated_method = "2428D0DEC3A2CB4A54E858D75D883B2C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setStroke(int width, int color, float dashWidth, float dashGap) {
        dsTaint.addTaint(color);
        dsTaint.addTaint(dashGap);
        dsTaint.addTaint(dashWidth);
        dsTaint.addTaint(width);
        mGradientState.setStroke(width, color, dashWidth, dashGap);
        {
            mStrokePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
            mStrokePaint.setStyle(Paint.Style.STROKE);
        } //End block
        mStrokePaint.setStrokeWidth(width);
        mStrokePaint.setColor(color);
        DashPathEffect e;
        e = null;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.323 -0400", hash_original_method = "DBF55AE12AFE7021A6EFA67946A43E31", hash_generated_method = "2D49269D3BC48D015E4FD139FBFE80B9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setSize(int width, int height) {
        dsTaint.addTaint(height);
        dsTaint.addTaint(width);
        mGradientState.setSize(width, height);
        mPathIsDirty = true;
        invalidateSelf();
        // ---------- Original Method ----------
        //mGradientState.setSize(width, height);
        //mPathIsDirty = true;
        //invalidateSelf();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.323 -0400", hash_original_method = "70A303A49D3D529F927A8B25154245C2", hash_generated_method = "47A393BBE022BAE9B3D35261F04E57D6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setShape(int shape) {
        dsTaint.addTaint(shape);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.323 -0400", hash_original_method = "18DB26B14B71A02370E6DE427E61924A", hash_generated_method = "8AC93C871A663B47DBC30F9006A54788")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setGradientType(int gradient) {
        dsTaint.addTaint(gradient);
        mGradientState.setGradientType(gradient);
        mRectIsDirty = true;
        invalidateSelf();
        // ---------- Original Method ----------
        //mGradientState.setGradientType(gradient);
        //mRectIsDirty = true;
        //invalidateSelf();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.323 -0400", hash_original_method = "45A2D9788BC882B134EC764255BF8E5D", hash_generated_method = "4A840B96DC976FB1944E763755C67B1E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setGradientCenter(float x, float y) {
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        mGradientState.setGradientCenter(x, y);
        mRectIsDirty = true;
        invalidateSelf();
        // ---------- Original Method ----------
        //mGradientState.setGradientCenter(x, y);
        //mRectIsDirty = true;
        //invalidateSelf();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.324 -0400", hash_original_method = "C7CA2F8177799FD0AFA978CBCB22DF14", hash_generated_method = "5C6D1E636E5FF660BCB2AAFD6B36137C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setGradientRadius(float gradientRadius) {
        dsTaint.addTaint(gradientRadius);
        mGradientState.setGradientRadius(gradientRadius);
        mRectIsDirty = true;
        invalidateSelf();
        // ---------- Original Method ----------
        //mGradientState.setGradientRadius(gradientRadius);
        //mRectIsDirty = true;
        //invalidateSelf();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.324 -0400", hash_original_method = "76C6B5A7FB76D454B2D8C7EAA5B46C4F", hash_generated_method = "31772AF55B15894FB5DC6280721D24D4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setUseLevel(boolean useLevel) {
        dsTaint.addTaint(useLevel);
        mGradientState.mUseLevel = useLevel;
        mRectIsDirty = true;
        invalidateSelf();
        // ---------- Original Method ----------
        //mGradientState.mUseLevel = useLevel;
        //mRectIsDirty = true;
        //invalidateSelf();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.324 -0400", hash_original_method = "0886E73CB45EE282B3AFC0BE37F5BE6C", hash_generated_method = "BEC4CD90B03396CD59CD22F5D42CDFCA")
    @DSModeled(DSC.SAFE)
    private int modulateAlpha(int alpha) {
        dsTaint.addTaint(alpha);
        int scale;
        scale = mAlpha + (mAlpha >> 7);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int scale = mAlpha + (mAlpha >> 7);
        //return alpha * scale >> 8;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.326 -0400", hash_original_method = "ACDDE907D9101C7CDDBBB954BA4F617E", hash_generated_method = "F6155539A9F786C9C544F66DDD8CC9D9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void draw(Canvas canvas) {
        dsTaint.addTaint(canvas.dsTaint);
        {
            boolean varBA9DE832C2A11F9FBBE974DC63DFFCC8_625636655 = (!ensureValidRect());
        } //End collapsed parenthetic
        int prevFillAlpha;
        prevFillAlpha = mFillPaint.getAlpha();
        int prevStrokeAlpha;
        prevStrokeAlpha = mStrokePaint.getAlpha();
        prevStrokeAlpha = 0;
        int currFillAlpha;
        currFillAlpha = modulateAlpha(prevFillAlpha);
        int currStrokeAlpha;
        currStrokeAlpha = modulateAlpha(prevStrokeAlpha);
        boolean haveStroke;
        haveStroke = currStrokeAlpha > 0 && mStrokePaint.getStrokeWidth() > 0;
        boolean haveFill;
        haveFill = currFillAlpha > 0;
        GradientState st;
        st = mGradientState;
        boolean useLayer;
        useLayer = haveStroke && haveFill && st.mShape != LINE &&
                 currStrokeAlpha < 255 && (mAlpha < 255 || mColorFilter != null);
        {
            {
                mLayerPaint = new Paint();
            } //End block
            mLayerPaint.setDither(mDither);
            mLayerPaint.setAlpha(mAlpha);
            mLayerPaint.setColorFilter(mColorFilter);
            float rad;
            rad = mStrokePaint.getStrokeWidth();
            canvas.saveLayer(mRect.left - rad, mRect.top - rad,
                             mRect.right + rad, mRect.bottom + rad,
                             mLayerPaint, Canvas.HAS_ALPHA_LAYER_SAVE_FLAG);
            mFillPaint.setColorFilter(null);
            mStrokePaint.setColorFilter(null);
        } //End block
        {
            mFillPaint.setAlpha(currFillAlpha);
            mFillPaint.setDither(mDither);
            mFillPaint.setColorFilter(mColorFilter);
            {
                mStrokePaint.setAlpha(currStrokeAlpha);
                mStrokePaint.setDither(mDither);
                mStrokePaint.setColorFilter(mColorFilter);
            } //End block
        } //End block
        //Begin case RECTANGLE 
        {
            {
                mPath.reset();
                mPath.addRoundRect(mRect, st.mRadiusArray, Path.Direction.CW);
                mPathIsDirty = mRectIsDirty = false;
            } //End block
            canvas.drawPath(mPath, mFillPaint);
            {
                canvas.drawPath(mPath, mStrokePaint);
            } //End block
        } //End block
        {
            float rad;
            rad = st.mRadius;
            float r;
            r = Math.min(mRect.width(), mRect.height()) * 0.5f;
            {
                rad = r;
            } //End block
            canvas.drawRoundRect(mRect, rad, rad, mFillPaint);
            {
                canvas.drawRoundRect(mRect, rad, rad, mStrokePaint);
            } //End block
        } //End block
        {
            canvas.drawRect(mRect, mFillPaint);
            {
                canvas.drawRect(mRect, mStrokePaint);
            } //End block
        } //End block
        //End case RECTANGLE 
        //Begin case OVAL 
        canvas.drawOval(mRect, mFillPaint);
        //End case OVAL 
        //Begin case OVAL 
        {
            canvas.drawOval(mRect, mStrokePaint);
        } //End block
        //End case OVAL 
        //Begin case LINE 
        {
            RectF r;
            r = mRect;
            float y;
            y = r.centerY();
            canvas.drawLine(r.left, y, r.right, y, mStrokePaint);
        } //End block
        //End case LINE 
        //Begin case RING 
        Path path;
        path = buildRing(st);
        //End case RING 
        //Begin case RING 
        canvas.drawPath(path, mFillPaint);
        //End case RING 
        //Begin case RING 
        {
            canvas.drawPath(path, mStrokePaint);
        } //End block
        //End case RING 
        {
            canvas.restore();
        } //End block
        {
            mFillPaint.setAlpha(prevFillAlpha);
            {
                mStrokePaint.setAlpha(prevStrokeAlpha);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.327 -0400", hash_original_method = "FA54FBF5F964BB48C4F923A57A9FF840", hash_generated_method = "0E06A68AC31BB429BFE4131599A1EF3D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Path buildRing(GradientState st) {
        dsTaint.addTaint(st.dsTaint);
        mPathIsDirty = false;
        float sweep;
        sweep = (360.0f * getLevel() / 10000.0f);
        sweep = 360f;
        RectF bounds;
        bounds = new RectF(mRect);
        float x;
        x = bounds.width() / 2.0f;
        float y;
        y = bounds.height() / 2.0f;
        float thickness;
        thickness = st.mThickness;
        thickness = bounds.width() / st.mThicknessRatio;
        float radius;
        radius = st.mInnerRadius;
        radius = bounds.width() / st.mInnerRadiusRatio;
        RectF innerBounds;
        innerBounds = new RectF(bounds);
        innerBounds.inset(x - radius, y - radius);
        bounds = new RectF(innerBounds);
        bounds.inset(-thickness, -thickness);
        {
            mRingPath = new Path();
        } //End block
        {
            mRingPath.reset();
        } //End block
        Path ringPath;
        ringPath = mRingPath;
        {
            ringPath.setFillType(Path.FillType.EVEN_ODD);
            ringPath.moveTo(x + radius, y);
            ringPath.lineTo(x + radius + thickness, y);
            ringPath.arcTo(bounds, 0.0f, sweep, false);
            ringPath.arcTo(innerBounds, sweep, -sweep, false);
            ringPath.close();
        } //End block
        {
            ringPath.addOval(bounds, Path.Direction.CW);
            ringPath.addOval(innerBounds, Path.Direction.CCW);
        } //End block
        return (Path)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.327 -0400", hash_original_method = "A6E3DC666A9DC913CF167BAEE3BA3755", hash_generated_method = "4DEE7FD8814C8DBFC342F744BE5533A8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setColor(int argb) {
        dsTaint.addTaint(argb);
        mGradientState.setSolidColor(argb);
        mFillPaint.setColor(argb);
        invalidateSelf();
        // ---------- Original Method ----------
        //mGradientState.setSolidColor(argb);
        //mFillPaint.setColor(argb);
        //invalidateSelf();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.327 -0400", hash_original_method = "3865DA4989774EEF9AAAD48E0098B1D2", hash_generated_method = "E787BAEB5231CA9C7767D6919D598B03")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getChangingConfigurations() {
        int var1B39BFEFC75CC9A4ED8324DAA238E57F_355620139 = (super.getChangingConfigurations()
                | mGradientState.mChangingConfigurations);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return super.getChangingConfigurations()
                //| mGradientState.mChangingConfigurations;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.328 -0400", hash_original_method = "5182E1ED546D38ED0370680C356A26EE", hash_generated_method = "307AB80D6D8E25CF130984F302B62686")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setAlpha(int alpha) {
        dsTaint.addTaint(alpha);
        {
            invalidateSelf();
        } //End block
        // ---------- Original Method ----------
        //if (alpha != mAlpha) {
            //mAlpha = alpha;
            //invalidateSelf();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.328 -0400", hash_original_method = "9DFE5D886E6229E65D3F438DE9F28624", hash_generated_method = "F9FD182C53109E365D35A920B113A01E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setDither(boolean dither) {
        dsTaint.addTaint(dither);
        {
            invalidateSelf();
        } //End block
        // ---------- Original Method ----------
        //if (dither != mDither) {
            //mDither = dither;
            //invalidateSelf();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.328 -0400", hash_original_method = "0D338CBBF9E8A18D18E6BF68648024B0", hash_generated_method = "3E87C369D0FF8F63CC695D513518D282")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setColorFilter(ColorFilter cf) {
        dsTaint.addTaint(cf.dsTaint);
        {
            invalidateSelf();
        } //End block
        // ---------- Original Method ----------
        //if (cf != mColorFilter) {
            //mColorFilter = cf;
            //invalidateSelf();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.328 -0400", hash_original_method = "AB3D570DA2A917C408AB4F7D8FCD7103", hash_generated_method = "ABA86D69E3485D7E8F9A1E6F7D7F161F")
    @DSModeled(DSC.SAFE)
    @Override
    public int getOpacity() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return PixelFormat.TRANSLUCENT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.329 -0400", hash_original_method = "8123137F2C4F03B6AAC99B13B8B696DA", hash_generated_method = "545CC7DF69CA7C1C6D248962D534FA03")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onBoundsChange(Rect r) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(r.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.329 -0400", hash_original_method = "394C06781A7C1BB568DD9A62F4177986", hash_generated_method = "FBC133FA5D2BE192EDCCFE382E30AD5F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected boolean onLevelChange(int level) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(level);
        super.onLevelChange(level);
        mRectIsDirty = true;
        mPathIsDirty = true;
        invalidateSelf();
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //super.onLevelChange(level);
        //mRectIsDirty = true;
        //mPathIsDirty = true;
        //invalidateSelf();
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.333 -0400", hash_original_method = "A926FB4015A038016094FA9870012FFA", hash_generated_method = "AAC5D5BC75D12A0CDD4470F4E359BF05")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean ensureValidRect() {
        {
            mRectIsDirty = false;
            Rect bounds;
            bounds = getBounds();
            float inset;
            inset = 0;
            {
                inset = mStrokePaint.getStrokeWidth() * 0.5f;
            } //End block
            GradientState st;
            st = mGradientState;
            mRect.set(bounds.left + inset, bounds.top + inset,
                      bounds.right - inset, bounds.bottom - inset);
            int[] colors;
            colors = st.mColors;
            {
                RectF r;
                r = mRect;
                float x0, x1, y0, y1;
                {
                    float level;
                    level = (float) getLevel() / 10000.0f;
                    level = 1.0f;
                    //Begin case TOP_BOTTOM 
                    x0 = r.left;
                    //End case TOP_BOTTOM 
                    //Begin case TOP_BOTTOM 
                    y0 = r.top;
                    //End case TOP_BOTTOM 
                    //Begin case TOP_BOTTOM 
                    x1 = x0;
                    //End case TOP_BOTTOM 
                    //Begin case TOP_BOTTOM 
                    y1 = level * r.bottom;
                    //End case TOP_BOTTOM 
                    //Begin case TR_BL 
                    x0 = r.right;
                    //End case TR_BL 
                    //Begin case TR_BL 
                    y0 = r.top;
                    //End case TR_BL 
                    //Begin case TR_BL 
                    x1 = level * r.left;
                    //End case TR_BL 
                    //Begin case TR_BL 
                    y1 = level * r.bottom;
                    //End case TR_BL 
                    //Begin case RIGHT_LEFT 
                    x0 = r.right;
                    //End case RIGHT_LEFT 
                    //Begin case RIGHT_LEFT 
                    y0 = r.top;
                    //End case RIGHT_LEFT 
                    //Begin case RIGHT_LEFT 
                    x1 = level * r.left;
                    //End case RIGHT_LEFT 
                    //Begin case RIGHT_LEFT 
                    y1 = y0;
                    //End case RIGHT_LEFT 
                    //Begin case BR_TL 
                    x0 = r.right;
                    //End case BR_TL 
                    //Begin case BR_TL 
                    y0 = r.bottom;
                    //End case BR_TL 
                    //Begin case BR_TL 
                    x1 = level * r.left;
                    //End case BR_TL 
                    //Begin case BR_TL 
                    y1 = level * r.top;
                    //End case BR_TL 
                    //Begin case BOTTOM_TOP 
                    x0 = r.left;
                    //End case BOTTOM_TOP 
                    //Begin case BOTTOM_TOP 
                    y0 = r.bottom;
                    //End case BOTTOM_TOP 
                    //Begin case BOTTOM_TOP 
                    x1 = x0;
                    //End case BOTTOM_TOP 
                    //Begin case BOTTOM_TOP 
                    y1 = level * r.top;
                    //End case BOTTOM_TOP 
                    //Begin case BL_TR 
                    x0 = r.left;
                    //End case BL_TR 
                    //Begin case BL_TR 
                    y0 = r.bottom;
                    //End case BL_TR 
                    //Begin case BL_TR 
                    x1 = level * r.right;
                    //End case BL_TR 
                    //Begin case BL_TR 
                    y1 = level * r.top;
                    //End case BL_TR 
                    //Begin case LEFT_RIGHT 
                    x0 = r.left;
                    //End case LEFT_RIGHT 
                    //Begin case LEFT_RIGHT 
                    y0 = r.top;
                    //End case LEFT_RIGHT 
                    //Begin case LEFT_RIGHT 
                    x1 = level * r.right;
                    //End case LEFT_RIGHT 
                    //Begin case LEFT_RIGHT 
                    y1 = y0;
                    //End case LEFT_RIGHT 
                    //Begin case default 
                    x0 = r.left;
                    //End case default 
                    //Begin case default 
                    y0 = r.top;
                    //End case default 
                    //Begin case default 
                    x1 = level * r.right;
                    //End case default 
                    //Begin case default 
                    y1 = level * r.bottom;
                    //End case default 
                    mFillPaint.setShader(new LinearGradient(x0, y0, x1, y1,
                            colors, st.mPositions, Shader.TileMode.CLAMP));
                } //End block
                {
                    x0 = r.left + (r.right - r.left) * st.mCenterX;
                    y0 = r.top + (r.bottom - r.top) * st.mCenterY;
                    float level;
                    level = (float) getLevel() / 10000.0f;
                    level = 1.0f;
                    mFillPaint.setShader(new RadialGradient(x0, y0,
                            level * st.mGradientRadius, colors, null,
                            Shader.TileMode.CLAMP));
                } //End block
                {
                    x0 = r.left + (r.right - r.left) * st.mCenterX;
                    y0 = r.top + (r.bottom - r.top) * st.mCenterY;
                    int[] tempColors;
                    tempColors = colors;
                    float[] tempPositions;
                    tempPositions = null;
                    {
                        tempColors = st.mTempColors;
                        int length;
                        length = colors.length;
                        {
                            tempColors = st.mTempColors = new int[length + 1];
                        } //End block
                        System.arraycopy(colors, 0, tempColors, 0, length);
                        tempColors[length] = colors[length - 1];
                        tempPositions = st.mTempPositions;
                        float fraction;
                        fraction = 1.0f / (float) (length - 1);
                        {
                            tempPositions = st.mTempPositions = new float[length + 1];
                        } //End block
                        float level;
                        level = (float) getLevel() / 10000.0f;
                        {
                            int i;
                            i = 0;
                            {
                                tempPositions[i] = i * fraction * level;
                            } //End block
                        } //End collapsed parenthetic
                        tempPositions[length] = 1.0f;
                    } //End block
                    mFillPaint.setShader(new SweepGradient(x0, y0, tempColors, tempPositions));
                } //End block
            } //End block
        } //End block
        boolean var30E025E3B836A2C788D549C3B113FC2D_14940037 = (!mRect.isEmpty());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.340 -0400", hash_original_method = "E432865D544D266B015263529D7B28D5", hash_generated_method = "F21137BB44A3A931912477569C6AF7E8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void inflate(Resources r, XmlPullParser parser,
            AttributeSet attrs) throws XmlPullParserException, IOException {
        dsTaint.addTaint(r.dsTaint);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(parser.dsTaint);
        GradientState st;
        st = mGradientState;
        TypedArray a;
        a = r.obtainAttributes(attrs,
                com.android.internal.R.styleable.GradientDrawable);
        super.inflateWithAttributes(r, parser, a,
                com.android.internal.R.styleable.GradientDrawable_visible);
        int shapeType;
        shapeType = a.getInt(
                com.android.internal.R.styleable.GradientDrawable_shape, RECTANGLE);
        boolean dither;
        dither = a.getBoolean(
                com.android.internal.R.styleable.GradientDrawable_dither, false);
        {
            st.mInnerRadius = a.getDimensionPixelSize(
                    com.android.internal.R.styleable.GradientDrawable_innerRadius, -1);
            {
                st.mInnerRadiusRatio = a.getFloat(
                        com.android.internal.R.styleable.GradientDrawable_innerRadiusRatio, 3.0f);
            } //End block
            st.mThickness = a.getDimensionPixelSize(
                    com.android.internal.R.styleable.GradientDrawable_thickness, -1);
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
        int innerDepth;
        innerDepth = parser.getDepth() + 1;
        int depth;
        {
            boolean varDA8A11B5A0155BE87587061A0D1D99DC_238748768 = ((type=parser.next()) != XmlPullParser.END_DOCUMENT
               && ((depth=parser.getDepth()) >= innerDepth
                       || type != XmlPullParser.END_TAG));
            {
                String name;
                name = parser.getName();
                {
                    boolean var3319812AA088443FD1D3A5BB020CC733_1574323088 = (name.equals("size"));
                    {
                        a = r.obtainAttributes(attrs,
                        com.android.internal.R.styleable.GradientDrawableSize);
                        int width;
                        width = a.getDimensionPixelSize(
                        com.android.internal.R.styleable.GradientDrawableSize_width, -1);
                        int height;
                        height = a.getDimensionPixelSize(
                        com.android.internal.R.styleable.GradientDrawableSize_height, -1);
                        a.recycle();
                        setSize(width, height);
                    } //End block
                    {
                        boolean var13D3F8D713AACA51C37FD91C445A32D1_1403231231 = (name.equals("gradient"));
                        {
                            a = r.obtainAttributes(attrs,
                        com.android.internal.R.styleable.GradientDrawableGradient);
                            int startColor;
                            startColor = a.getColor(
                        com.android.internal.R.styleable.GradientDrawableGradient_startColor, 0);
                            boolean hasCenterColor;
                            hasCenterColor = a
                        .hasValue(com.android.internal.R.styleable.GradientDrawableGradient_centerColor);
                            int centerColor;
                            centerColor = a.getColor(
                        com.android.internal.R.styleable.GradientDrawableGradient_centerColor, 0);
                            int endColor;
                            endColor = a.getColor(
                        com.android.internal.R.styleable.GradientDrawableGradient_endColor, 0);
                            int gradientType;
                            gradientType = a.getInt(
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
                            {
                                int angle;
                                angle = (int)a.getFloat(
                            com.android.internal.R.styleable.GradientDrawableGradient_angle, 0);
                                angle %= 360;
                                {
                                    if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException(a.getPositionDescription()
                                + "<gradient> tag requires 'angle' attribute to "
                                + "be a multiple of 45");
                                } //End block
                                //Begin case 0 
                                st.mOrientation = Orientation.LEFT_RIGHT;
                                //End case 0 
                                //Begin case 45 
                                st.mOrientation = Orientation.BL_TR;
                                //End case 45 
                                //Begin case 90 
                                st.mOrientation = Orientation.BOTTOM_TOP;
                                //End case 90 
                                //Begin case 135 
                                st.mOrientation = Orientation.BR_TL;
                                //End case 135 
                                //Begin case 180 
                                st.mOrientation = Orientation.RIGHT_LEFT;
                                //End case 180 
                                //Begin case 225 
                                st.mOrientation = Orientation.TR_BL;
                                //End case 225 
                                //Begin case 270 
                                st.mOrientation = Orientation.TOP_BOTTOM;
                                //End case 270 
                                //Begin case 315 
                                st.mOrientation = Orientation.TL_BR;
                                //End case 315 
                            } //End block
                            {
                                TypedValue tv;
                                tv = a.peekValue(
                            com.android.internal.R.styleable.GradientDrawableGradient_gradientRadius);
                                {
                                    boolean radiusRel;
                                    radiusRel = tv.type == TypedValue.TYPE_FRACTION;
                                    st.mGradientRadius = radiusRel ?
                                tv.getFraction(1.0f, 1.0f) : tv.getFloat();
                                } //End block
                                {
                                    if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException(
                                a.getPositionDescription()
                                + "<gradient> tag requires 'gradientRadius' "
                                + "attribute with radial type");
                                } //End block
                            } //End block
                            a.recycle();
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
                            {
                                st.mColors = new int[2];
                                st.mColors[0] = startColor;
                                st.mColors[1] = endColor;
                            } //End block
                        } //End block
                        {
                            boolean var77525D664C592F28B26A6CD8C67737E6_379736677 = (name.equals("solid"));
                            {
                                a = r.obtainAttributes(attrs,
                        com.android.internal.R.styleable.GradientDrawableSolid);
                                int argb;
                                argb = a.getColor(
                        com.android.internal.R.styleable.GradientDrawableSolid_color, 0);
                                a.recycle();
                                setColor(argb);
                            } //End block
                            {
                                boolean varC0495157E2DDB9B86006CF2755D3E0C5_1243298096 = (name.equals("stroke"));
                                {
                                    a = r.obtainAttributes(attrs,
                        com.android.internal.R.styleable.GradientDrawableStroke);
                                    int width;
                                    width = a.getDimensionPixelSize(
                        com.android.internal.R.styleable.GradientDrawableStroke_width, 0);
                                    int color;
                                    color = a.getColor(
                        com.android.internal.R.styleable.GradientDrawableStroke_color, 0);
                                    float dashWidth;
                                    dashWidth = a.getDimension(
                        com.android.internal.R.styleable.GradientDrawableStroke_dashWidth, 0);
                                    {
                                        float dashGap;
                                        dashGap = a.getDimension(
                            com.android.internal.R.styleable.GradientDrawableStroke_dashGap, 0);
                                        setStroke(width, color, dashWidth, dashGap);
                                    } //End block
                                    {
                                        setStroke(width, color);
                                    } //End block
                                    a.recycle();
                                } //End block
                                {
                                    boolean varC5E3FCBC94B952A08166FFFCCC10F540_467142556 = (name.equals("corners"));
                                    {
                                        a = r.obtainAttributes(attrs,
                        com.android.internal.R.styleable.DrawableCorners);
                                        int radius;
                                        radius = a.getDimensionPixelSize(
                        com.android.internal.R.styleable.DrawableCorners_radius, 0);
                                        setCornerRadius(radius);
                                        int topLeftRadius;
                                        topLeftRadius = a.getDimensionPixelSize(
                        com.android.internal.R.styleable.DrawableCorners_topLeftRadius, radius);
                                        int topRightRadius;
                                        topRightRadius = a.getDimensionPixelSize(
                        com.android.internal.R.styleable.DrawableCorners_topRightRadius, radius);
                                        int bottomLeftRadius;
                                        bottomLeftRadius = a.getDimensionPixelSize(
                        com.android.internal.R.styleable.DrawableCorners_bottomLeftRadius, radius);
                                        int bottomRightRadius;
                                        bottomRightRadius = a.getDimensionPixelSize(
                        com.android.internal.R.styleable.DrawableCorners_bottomRightRadius, radius);
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
                                    {
                                        boolean var73614EBC6E52B1FB538E626BACD291BD_378502398 = (name.equals("padding"));
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
                                    } //End collapsed parenthetic
                                } //End collapsed parenthetic
                            } //End collapsed parenthetic
                        } //End collapsed parenthetic
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.341 -0400", hash_original_method = "312782D78F9C32949C3B038C307C5C9C", hash_generated_method = "0BC26DCA935847321041FF634870B8DB")
    @DSModeled(DSC.SAFE)
    @Override
    public int getIntrinsicWidth() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mGradientState.mWidth;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.341 -0400", hash_original_method = "A19A1B01925414A773BB5AE9FBB4894A", hash_generated_method = "7E116AB6D07CEA7875F276B8AE8280E1")
    @DSModeled(DSC.SAFE)
    @Override
    public int getIntrinsicHeight() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mGradientState.mHeight;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.341 -0400", hash_original_method = "DD96D81CE576A9B12867099611327831", hash_generated_method = "3D24DC3E63D485C4CB942E50B02D2384")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ConstantState getConstantState() {
        mGradientState.mChangingConfigurations = getChangingConfigurations();
        return (ConstantState)dsTaint.getTaint();
        // ---------- Original Method ----------
        //mGradientState.mChangingConfigurations = getChangingConfigurations();
        //return mGradientState;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.342 -0400", hash_original_method = "D4EF431721248824E2CCEA5FA3C5FD74", hash_generated_method = "3FFF10952F4862DF0FB95BAFEE29537A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Drawable mutate() {
        {
            boolean varC94B19053599294E7944C8C841976773_64227982 = (!mMutated && super.mutate() == this);
            {
                mGradientState = new GradientState(mGradientState);
                initializeWithState(mGradientState);
                mMutated = true;
            } //End block
        } //End collapsed parenthetic
        return (Drawable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (!mMutated && super.mutate() == this) {
            //mGradientState = new GradientState(mGradientState);
            //initializeWithState(mGradientState);
            //mMutated = true;
        //}
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.342 -0400", hash_original_method = "7FA7686AE1E8AEF57BBE0E6293CFBCA1", hash_generated_method = "928B4C683C2774960602711954C4721D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void initializeWithState(GradientState state) {
        dsTaint.addTaint(state.dsTaint);
        {
            mFillPaint.setColor(state.mSolidColor);
        } //End block
        mPadding = state.mPadding;
        {
            mStrokePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
            mStrokePaint.setStyle(Paint.Style.STROKE);
            mStrokePaint.setStrokeWidth(state.mStrokeWidth);
            mStrokePaint.setColor(state.mStrokeColor);
            {
                DashPathEffect e;
                e = new DashPathEffect(
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
        public int mChangingConfigurations;
        public int mShape = RECTANGLE;
        public int mGradient = LINEAR_GRADIENT;
        public Orientation mOrientation;
        public int[] mColors;
        public int[] mTempColors;
        public float[] mTempPositions;
        public float[] mPositions;
        public boolean mHasSolidColor;
        public int mSolidColor;
        public int mStrokeWidth = -1;
        public int mStrokeColor;
        public float mStrokeDashWidth;
        public float mStrokeDashGap;
        public float mRadius;
        public float[] mRadiusArray;
        public Rect mPadding;
        public int mWidth = -1;
        public int mHeight = -1;
        public float mInnerRadiusRatio;
        public float mThicknessRatio;
        public int mInnerRadius;
        public int mThickness;
        private float mCenterX = 0.5f;
        private float mCenterY = 0.5f;
        private float mGradientRadius = 0.5f;
        private boolean mUseLevel;
        private boolean mUseLevelForShape;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.342 -0400", hash_original_method = "9C4B8156D5998AA4F070091BFAC51297", hash_generated_method = "36EA0AD2FEF9D7DF957604ED73351F6F")
        @DSModeled(DSC.SAFE)
         GradientState() {
            mOrientation = Orientation.TOP_BOTTOM;
            // ---------- Original Method ----------
            //mOrientation = Orientation.TOP_BOTTOM;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.343 -0400", hash_original_method = "D56C041244D40E3233BE0185764F984A", hash_generated_method = "14B5405AF90FD00854F0C9DAAC88B90F")
        @DSModeled(DSC.SAFE)
         GradientState(Orientation orientation, int[] colors) {
            dsTaint.addTaint(orientation.dsTaint);
            dsTaint.addTaint(colors[0]);
            // ---------- Original Method ----------
            //mOrientation = orientation;
            //mColors = colors;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.344 -0400", hash_original_method = "E9F630A8A3449D4E0942DD92A53A8789", hash_generated_method = "1BD8CACC5580193E6563E06DCC5D8686")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public GradientState(GradientState state) {
            dsTaint.addTaint(state.dsTaint);
            mChangingConfigurations = state.mChangingConfigurations;
            mShape = state.mShape;
            mGradient = state.mGradient;
            mOrientation = state.mOrientation;
            {
                mColors = state.mColors.clone();
            } //End block
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
            {
                mRadiusArray = state.mRadiusArray.clone();
            } //End block
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.344 -0400", hash_original_method = "995801C56CB4C9E6715A12BAA40CCB03", hash_generated_method = "375C6957B40A8B2BB54FE8F68AB10FAF")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Drawable newDrawable() {
            Drawable varF587ED15A3D687BB8713586B3822D8D1_549804291 = (new GradientDrawable(this));
            return (Drawable)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new GradientDrawable(this);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.344 -0400", hash_original_method = "C54DA0CD853A4A5864DFD734D15AF82F", hash_generated_method = "FC234BA1468E2432044E3F2173851DB5")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Drawable newDrawable(Resources res) {
            dsTaint.addTaint(res.dsTaint);
            Drawable varF587ED15A3D687BB8713586B3822D8D1_1114245372 = (new GradientDrawable(this));
            return (Drawable)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new GradientDrawable(this);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.344 -0400", hash_original_method = "9E7D7C67EAC365FF19BD4971762612A5", hash_generated_method = "36011B0CFA5B1C48E438EB66BB35159E")
        @DSModeled(DSC.SAFE)
        @Override
        public int getChangingConfigurations() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return mChangingConfigurations;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.345 -0400", hash_original_method = "0F10CA732F07DD9FE38CDA7CBCDABA95", hash_generated_method = "7B76E2273885F0DC6D3B0502E0FD65AB")
        @DSModeled(DSC.SAFE)
        public void setShape(int shape) {
            dsTaint.addTaint(shape);
            // ---------- Original Method ----------
            //mShape = shape;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.345 -0400", hash_original_method = "6060B2E1C6E57F715C4E87E13018C121", hash_generated_method = "3E98AE1B46522413D5465BCB56B828B8")
        @DSModeled(DSC.SAFE)
        public void setGradientType(int gradient) {
            dsTaint.addTaint(gradient);
            // ---------- Original Method ----------
            //mGradient = gradient;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.345 -0400", hash_original_method = "90316D628B1BD1AAC4CD928A74CE9FD1", hash_generated_method = "DE906B42F6B9F05C8C7D60C857D74C8F")
        @DSModeled(DSC.SAFE)
        public void setGradientCenter(float x, float y) {
            dsTaint.addTaint(y);
            dsTaint.addTaint(x);
            // ---------- Original Method ----------
            //mCenterX = x;
            //mCenterY = y;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.346 -0400", hash_original_method = "829DF5400D64CA55E626852A56B8E3B1", hash_generated_method = "CB31EA3A5196CD864ACCA87818050BD4")
        @DSModeled(DSC.SAFE)
        public void setSolidColor(int argb) {
            dsTaint.addTaint(argb);
            mHasSolidColor = true;
            mColors = null;
            // ---------- Original Method ----------
            //mHasSolidColor = true;
            //mSolidColor = argb;
            //mColors = null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.356 -0400", hash_original_method = "0625749E363A97E3FB7A01916551E363", hash_generated_method = "51C19D8757EEECC1F4E3C817DC330A32")
        @DSModeled(DSC.SAFE)
        public void setStroke(int width, int color) {
            dsTaint.addTaint(color);
            dsTaint.addTaint(width);
            // ---------- Original Method ----------
            //mStrokeWidth = width;
            //mStrokeColor = color;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.356 -0400", hash_original_method = "62694733BCC23283C4956406C2DF326D", hash_generated_method = "7E453BBBAD9E88A977BDE336F5BE84EF")
        @DSModeled(DSC.SAFE)
        public void setStroke(int width, int color, float dashWidth, float dashGap) {
            dsTaint.addTaint(color);
            dsTaint.addTaint(dashGap);
            dsTaint.addTaint(dashWidth);
            dsTaint.addTaint(width);
            // ---------- Original Method ----------
            //mStrokeWidth = width;
            //mStrokeColor = color;
            //mStrokeDashWidth = dashWidth;
            //mStrokeDashGap = dashGap;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.358 -0400", hash_original_method = "55392135B56F7FBDA5D3E3F94BBF1F23", hash_generated_method = "DD4910B58AA1110469EFF909D4C2A088")
        @DSModeled(DSC.SAFE)
        public void setCornerRadius(float radius) {
            dsTaint.addTaint(radius);
            {
                radius = 0;
            } //End block
            mRadiusArray = null;
            // ---------- Original Method ----------
            //if (radius < 0) {
                //radius = 0;
            //}
            //mRadius = radius;
            //mRadiusArray = null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.359 -0400", hash_original_method = "17EB6FE4DB8FF42541FF19B71843B23B", hash_generated_method = "4D5466CBB0FC1068965EB31940BB11CA")
        @DSModeled(DSC.SAFE)
        public void setCornerRadii(float[] radii) {
            dsTaint.addTaint(radii[0]);
            {
                mRadius = 0;
            } //End block
            // ---------- Original Method ----------
            //mRadiusArray = radii;
            //if (radii == null) {
                //mRadius = 0;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.359 -0400", hash_original_method = "2560E21D822EB58266D32B5FBCFCA888", hash_generated_method = "B8824A448B9B7B91DD29FEC2964E0A45")
        @DSModeled(DSC.SAFE)
        public void setSize(int width, int height) {
            dsTaint.addTaint(height);
            dsTaint.addTaint(width);
            // ---------- Original Method ----------
            //mWidth = width;
            //mHeight = height;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.360 -0400", hash_original_method = "2D6DAC1104AA515AA78A28549F71CF0A", hash_generated_method = "8E3DF5F276A3573AF9EAB37A7199A649")
        @DSModeled(DSC.SAFE)
        public void setGradientRadius(float gradientRadius) {
            dsTaint.addTaint(gradientRadius);
            // ---------- Original Method ----------
            //mGradientRadius = gradientRadius;
        }

        
    }


    
    public static final int RECTANGLE = 0;
    public static final int OVAL = 1;
    public static final int LINE = 2;
    public static final int RING = 3;
    public static final int LINEAR_GRADIENT = 0;
    public static final int RADIAL_GRADIENT = 1;
    public static final int SWEEP_GRADIENT  = 2;
}

