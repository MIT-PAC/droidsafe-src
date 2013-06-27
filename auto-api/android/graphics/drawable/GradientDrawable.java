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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.117 -0400", hash_original_field = "7A93543FFB4741C41CAFDAC91FC3D12D", hash_generated_field = "F8FC523C37AC4F355E3A52C1D395B9CA")

    private GradientState mGradientState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.117 -0400", hash_original_field = "90FF0E236CECDE0BABB7F37F4CFBC91F", hash_generated_field = "8CCF9C9412E7832608B259DB16DC0EB2")

    private Paint mFillPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.117 -0400", hash_original_field = "9AC2544B5F9B8F60AA16656C94B57A8E", hash_generated_field = "017017AA9AF1862D01EDDEC3A7AB7775")

    private Rect mPadding;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.117 -0400", hash_original_field = "6DCD2896FB1BA879F4BA417938FBF583", hash_generated_field = "9FB471477563645F319E80BA6D6ED905")

    private Paint mStrokePaint;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.118 -0400", hash_original_field = "8B2ED40D22A4C08C94CFC40B6DE589B8", hash_generated_field = "5D6D299C9DDEDCCB11EFFA1C147C3DF6")

    private ColorFilter mColorFilter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.118 -0400", hash_original_field = "964D4F44E49C213AB7292F7E0E37C642", hash_generated_field = "3503E015FBD1508491B2F18FDC5DAF9F")

    private int mAlpha = 0xFF;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.118 -0400", hash_original_field = "39F3EFC8FE0445AB43D96028DA65CB34", hash_generated_field = "B8E34DBCCD5A9935E92ED2F73AF5F8B7")

    private boolean mDither;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.118 -0400", hash_original_field = "DBC2DDFC3AA0B07663EC95BA4102B76C", hash_generated_field = "7CD81E52C80B218AD927A0157374D5AD")

    private Path mPath = new Path();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.118 -0400", hash_original_field = "995C0FB7B00A0A1E82DD4C30778697FC", hash_generated_field = "E080B89EC7A364FFC5B71FB812B38393")

    private RectF mRect = new RectF();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.118 -0400", hash_original_field = "5870A18F50D7C3B8DE43F07B2A8E2BC8", hash_generated_field = "A6ACFEE6A39EC6759FF9E6489D52AFB1")

    private Paint mLayerPaint;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.118 -0400", hash_original_field = "0AC65B89ECE55C9155BA940BC20ABBBA", hash_generated_field = "82A739DA370CC4D4C339BB7C440434C4")

    private boolean mRectIsDirty;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.118 -0400", hash_original_field = "9FB80C30383848C8D006680B5F3BDAF9", hash_generated_field = "5CA5A1EF3CAA45117BCACBC34EF05952")

    private boolean mMutated;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.118 -0400", hash_original_field = "9333534E7B66A8D431355B79E08642AE", hash_generated_field = "FB9692F405D4B8918DCE56B27CC81A6B")

    private Path mRingPath;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.119 -0400", hash_original_field = "9952E276AFE35FE0B1FB7B2BDEB787AA", hash_generated_field = "EAB2B54D4BC3106764331272E438AA0A")

    private boolean mPathIsDirty = true;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.124 -0400", hash_original_method = "64287040FBFB7F81692AADB4245B0378", hash_generated_method = "78296307B8E83E1FC392EC6080C25EE7")
    public  GradientDrawable() {
        this(new GradientState(Orientation.TOP_BOTTOM, null));
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.125 -0400", hash_original_method = "48FF7A4A9E39F0BE519CF2AE778248C7", hash_generated_method = "9F2225174BB0A90F90F775B4D26A0910")
    public  GradientDrawable(Orientation orientation, int[] colors) {
        this(new GradientState(orientation, colors));
        addTaint(orientation.getTaint());
        addTaint(colors[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.126 -0400", hash_original_method = "11AB49F3A166C4EC986EE8723C09CE3C", hash_generated_method = "EB17AAEC21D5CB5883C8C3AB3D6841B1")
    private  GradientDrawable(GradientState state) {
        mGradientState = state;
        initializeWithState(state);
        mRectIsDirty = true;
        // ---------- Original Method ----------
        //mGradientState = state;
        //initializeWithState(state);
        //mRectIsDirty = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.128 -0400", hash_original_method = "0B8807A1903E03E118A45AC647AD9F24", hash_generated_method = "FFDED49EFA34E5BFD172FB1E15A864F0")
    @Override
    public boolean getPadding(Rect padding) {
        {
            padding.set(mPadding);
        } //End block
        {
            boolean var26681595319194856AEB3747307B6E08_1017193447 = (super.getPadding(padding));
        } //End block
        addTaint(padding.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_188214099 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_188214099;
        // ---------- Original Method ----------
        //if (mPadding != null) {
            //padding.set(mPadding);
            //return true;
        //} else {
            //return super.getPadding(padding);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.129 -0400", hash_original_method = "71F948CC6AEC5EB6067752059DA33574", hash_generated_method = "FCBE9193C12F25CC29BBDD2EEC566408")
    public void setCornerRadii(float[] radii) {
        mGradientState.setCornerRadii(radii);
        mPathIsDirty = true;
        invalidateSelf();
        addTaint(radii[0]);
        // ---------- Original Method ----------
        //mGradientState.setCornerRadii(radii);
        //mPathIsDirty = true;
        //invalidateSelf();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.144 -0400", hash_original_method = "AFB7C3E5AE7C3BBB28B141F7A3B472BE", hash_generated_method = "F22FBE70113DC36528EF20A07EA57260")
    public void setCornerRadius(float radius) {
        mGradientState.setCornerRadius(radius);
        mPathIsDirty = true;
        invalidateSelf();
        addTaint(radius);
        // ---------- Original Method ----------
        //mGradientState.setCornerRadius(radius);
        //mPathIsDirty = true;
        //invalidateSelf();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.145 -0400", hash_original_method = "6A0F62EB2F02BD455327DA9DA2DD0568", hash_generated_method = "B4F773A1BF847FFF8CF641E8B9C6EC52")
    public void setStroke(int width, int color) {
        setStroke(width, color, 0, 0);
        addTaint(width);
        addTaint(color);
        // ---------- Original Method ----------
        //setStroke(width, color, 0, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.147 -0400", hash_original_method = "F36B912577B048DA0236870F939930FC", hash_generated_method = "700EC90209283DF1CB02115D7B94A462")
    public void setStroke(int width, int color, float dashWidth, float dashGap) {
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
        addTaint(width);
        addTaint(color);
        addTaint(dashWidth);
        addTaint(dashGap);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.164 -0400", hash_original_method = "DBF55AE12AFE7021A6EFA67946A43E31", hash_generated_method = "5FA98507D9A924147867D5A9D89417D1")
    public void setSize(int width, int height) {
        mGradientState.setSize(width, height);
        mPathIsDirty = true;
        invalidateSelf();
        addTaint(width);
        addTaint(height);
        // ---------- Original Method ----------
        //mGradientState.setSize(width, height);
        //mPathIsDirty = true;
        //invalidateSelf();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.165 -0400", hash_original_method = "70A303A49D3D529F927A8B25154245C2", hash_generated_method = "D4D504E2107E4EA1E51D16F22F9DF437")
    public void setShape(int shape) {
        mRingPath = null;
        mPathIsDirty = true;
        mGradientState.setShape(shape);
        invalidateSelf();
        addTaint(shape);
        // ---------- Original Method ----------
        //mRingPath = null;
        //mPathIsDirty = true;
        //mGradientState.setShape(shape);
        //invalidateSelf();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.177 -0400", hash_original_method = "18DB26B14B71A02370E6DE427E61924A", hash_generated_method = "0D656E63F355DADB6011279EABB75D59")
    public void setGradientType(int gradient) {
        mGradientState.setGradientType(gradient);
        mRectIsDirty = true;
        invalidateSelf();
        addTaint(gradient);
        // ---------- Original Method ----------
        //mGradientState.setGradientType(gradient);
        //mRectIsDirty = true;
        //invalidateSelf();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.187 -0400", hash_original_method = "45A2D9788BC882B134EC764255BF8E5D", hash_generated_method = "022B292683128C415AAABCEE5B536C2C")
    public void setGradientCenter(float x, float y) {
        mGradientState.setGradientCenter(x, y);
        mRectIsDirty = true;
        invalidateSelf();
        addTaint(x);
        addTaint(y);
        // ---------- Original Method ----------
        //mGradientState.setGradientCenter(x, y);
        //mRectIsDirty = true;
        //invalidateSelf();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.203 -0400", hash_original_method = "C7CA2F8177799FD0AFA978CBCB22DF14", hash_generated_method = "20562707949A618B0A95C187F377DF41")
    public void setGradientRadius(float gradientRadius) {
        mGradientState.setGradientRadius(gradientRadius);
        mRectIsDirty = true;
        invalidateSelf();
        addTaint(gradientRadius);
        // ---------- Original Method ----------
        //mGradientState.setGradientRadius(gradientRadius);
        //mRectIsDirty = true;
        //invalidateSelf();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.204 -0400", hash_original_method = "76C6B5A7FB76D454B2D8C7EAA5B46C4F", hash_generated_method = "2E9C7352FC465108C4CB664D03418E5C")
    public void setUseLevel(boolean useLevel) {
        mGradientState.mUseLevel = useLevel;
        mRectIsDirty = true;
        invalidateSelf();
        // ---------- Original Method ----------
        //mGradientState.mUseLevel = useLevel;
        //mRectIsDirty = true;
        //invalidateSelf();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.205 -0400", hash_original_method = "0886E73CB45EE282B3AFC0BE37F5BE6C", hash_generated_method = "2871C29668E25A2DB5C60FDA736E5182")
    private int modulateAlpha(int alpha) {
        int scale;
        scale = mAlpha + (mAlpha >> 7);
        addTaint(alpha);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1015598755 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1015598755;
        // ---------- Original Method ----------
        //int scale = mAlpha + (mAlpha >> 7);
        //return alpha * scale >> 8;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.226 -0400", hash_original_method = "ACDDE907D9101C7CDDBBB954BA4F617E", hash_generated_method = "279B7EF075860DAC0FC5DB6A095D7BF4")
    @Override
    public void draw(Canvas canvas) {
        {
            boolean varBA9DE832C2A11F9FBBE974DC63DFFCC8_819257078 = (!ensureValidRect());
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
        addTaint(canvas.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.259 -0400", hash_original_method = "FA54FBF5F964BB48C4F923A57A9FF840", hash_generated_method = "0B159514A8F85592256FDF657136BCBA")
    private Path buildRing(GradientState st) {
        Path varB4EAC82CA7396A68D541C85D26508E83_885849514 = null; //Variable for return #1
        Path varB4EAC82CA7396A68D541C85D26508E83_794654869 = null; //Variable for return #2
        varB4EAC82CA7396A68D541C85D26508E83_885849514 = mRingPath;
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
        varB4EAC82CA7396A68D541C85D26508E83_794654869 = ringPath;
        addTaint(st.getTaint());
        Path varA7E53CE21691AB073D9660D615818899_2070939955; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2070939955 = varB4EAC82CA7396A68D541C85D26508E83_885849514;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2070939955 = varB4EAC82CA7396A68D541C85D26508E83_794654869;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2070939955.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2070939955;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.379 -0400", hash_original_method = "A6E3DC666A9DC913CF167BAEE3BA3755", hash_generated_method = "E2AFD499F4A73DF66FCF79C1BF8F2229")
    public void setColor(int argb) {
        mGradientState.setSolidColor(argb);
        mFillPaint.setColor(argb);
        invalidateSelf();
        addTaint(argb);
        // ---------- Original Method ----------
        //mGradientState.setSolidColor(argb);
        //mFillPaint.setColor(argb);
        //invalidateSelf();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.380 -0400", hash_original_method = "3865DA4989774EEF9AAAD48E0098B1D2", hash_generated_method = "2DEFBA567DBCAF784128B4CEFBBF1964")
    @Override
    public int getChangingConfigurations() {
        int var1B39BFEFC75CC9A4ED8324DAA238E57F_1790006962 = (super.getChangingConfigurations()
                | mGradientState.mChangingConfigurations);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1033849341 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1033849341;
        // ---------- Original Method ----------
        //return super.getChangingConfigurations()
                //| mGradientState.mChangingConfigurations;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.381 -0400", hash_original_method = "5182E1ED546D38ED0370680C356A26EE", hash_generated_method = "9B771BA6D3F8B2E7E865EBADFD3BB5CB")
    @Override
    public void setAlpha(int alpha) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.383 -0400", hash_original_method = "9DFE5D886E6229E65D3F438DE9F28624", hash_generated_method = "E96FC7737BDCFE119580C5267A1996E3")
    @Override
    public void setDither(boolean dither) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.385 -0400", hash_original_method = "0D338CBBF9E8A18D18E6BF68648024B0", hash_generated_method = "51C58ED617FC753572A6A9D0C9CB4655")
    @Override
    public void setColorFilter(ColorFilter cf) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.385 -0400", hash_original_method = "AB3D570DA2A917C408AB4F7D8FCD7103", hash_generated_method = "175C89B6E1D30F04F3224D18B3B54699")
    @Override
    public int getOpacity() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_746204093 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_746204093;
        // ---------- Original Method ----------
        //return PixelFormat.TRANSLUCENT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.387 -0400", hash_original_method = "8123137F2C4F03B6AAC99B13B8B696DA", hash_generated_method = "5580BDE6A3C74A2FE32C5823D03C8EB0")
    @Override
    protected void onBoundsChange(Rect r) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onBoundsChange(r);
        mRingPath = null;
        mPathIsDirty = true;
        mRectIsDirty = true;
        addTaint(r.getTaint());
        // ---------- Original Method ----------
        //super.onBoundsChange(r);
        //mRingPath = null;
        //mPathIsDirty = true;
        //mRectIsDirty = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.415 -0400", hash_original_method = "394C06781A7C1BB568DD9A62F4177986", hash_generated_method = "6F8DD33B9A08677D910EDE0CA078DAA7")
    @Override
    protected boolean onLevelChange(int level) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onLevelChange(level);
        mRectIsDirty = true;
        mPathIsDirty = true;
        invalidateSelf();
        addTaint(level);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1409489390 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1409489390;
        // ---------- Original Method ----------
        //super.onLevelChange(level);
        //mRectIsDirty = true;
        //mPathIsDirty = true;
        //invalidateSelf();
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.510 -0400", hash_original_method = "A926FB4015A038016094FA9870012FFA", hash_generated_method = "D388064685A498FE61FC7F141DC58126")
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
        boolean var30E025E3B836A2C788D549C3B113FC2D_1675226976 = (!mRect.isEmpty());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_114949990 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_114949990;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.604 -0400", hash_original_method = "E432865D544D266B015263529D7B28D5", hash_generated_method = "49DF446FE5681A14BC2209061740E637")
    @Override
    public void inflate(Resources r, XmlPullParser parser,
            AttributeSet attrs) throws XmlPullParserException, IOException {
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
            boolean varDA8A11B5A0155BE87587061A0D1D99DC_728176802 = ((type=parser.next()) != XmlPullParser.END_DOCUMENT
               && ((depth=parser.getDepth()) >= innerDepth
                       || type != XmlPullParser.END_TAG));
            {
                String name;
                name = parser.getName();
                {
                    boolean var3319812AA088443FD1D3A5BB020CC733_1326712329 = (name.equals("size"));
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
                        boolean var13D3F8D713AACA51C37FD91C445A32D1_1857595043 = (name.equals("gradient"));
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
                            boolean var77525D664C592F28B26A6CD8C67737E6_814346014 = (name.equals("solid"));
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
                                boolean varC0495157E2DDB9B86006CF2755D3E0C5_649656372 = (name.equals("stroke"));
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
                                    boolean varC5E3FCBC94B952A08166FFFCCC10F540_420574192 = (name.equals("corners"));
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
                                        boolean var73614EBC6E52B1FB538E626BACD291BD_843276612 = (name.equals("padding"));
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
        addTaint(r.getTaint());
        addTaint(parser.getTaint());
        addTaint(attrs.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.630 -0400", hash_original_method = "312782D78F9C32949C3B038C307C5C9C", hash_generated_method = "115EF5F230C6274678EA967C8D34B45A")
    @Override
    public int getIntrinsicWidth() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1843462797 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1843462797;
        // ---------- Original Method ----------
        //return mGradientState.mWidth;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.630 -0400", hash_original_method = "A19A1B01925414A773BB5AE9FBB4894A", hash_generated_method = "0F1CD33A486260A1EBB2F0BA79F91C27")
    @Override
    public int getIntrinsicHeight() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_894707525 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_894707525;
        // ---------- Original Method ----------
        //return mGradientState.mHeight;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.633 -0400", hash_original_method = "DD96D81CE576A9B12867099611327831", hash_generated_method = "646E79CA23F690154559CC87A2EACDAC")
    @Override
    public ConstantState getConstantState() {
        ConstantState varB4EAC82CA7396A68D541C85D26508E83_1012057895 = null; //Variable for return #1
        mGradientState.mChangingConfigurations = getChangingConfigurations();
        varB4EAC82CA7396A68D541C85D26508E83_1012057895 = mGradientState;
        varB4EAC82CA7396A68D541C85D26508E83_1012057895.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1012057895;
        // ---------- Original Method ----------
        //mGradientState.mChangingConfigurations = getChangingConfigurations();
        //return mGradientState;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.635 -0400", hash_original_method = "D4EF431721248824E2CCEA5FA3C5FD74", hash_generated_method = "0AF3593A4ECA05B25E841FC9E2EF4876")
    @Override
    public Drawable mutate() {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_1236574472 = null; //Variable for return #1
        {
            boolean varC94B19053599294E7944C8C841976773_78268020 = (!mMutated && super.mutate() == this);
            {
                mGradientState = new GradientState(mGradientState);
                initializeWithState(mGradientState);
                mMutated = true;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1236574472 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1236574472.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1236574472;
        // ---------- Original Method ----------
        //if (!mMutated && super.mutate() == this) {
            //mGradientState = new GradientState(mGradientState);
            //initializeWithState(mGradientState);
            //mMutated = true;
        //}
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.652 -0400", hash_original_method = "7FA7686AE1E8AEF57BBE0E6293CFBCA1", hash_generated_method = "77CA83EE5255EEBCC302622A15BBC8F0")
    private void initializeWithState(GradientState state) {
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.653 -0400", hash_original_field = "276E0645C4E2084773D0EB8C5576428C", hash_generated_field = "0AA9CE94E21E2967183254C710B3C74D")

        public int mChangingConfigurations;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.653 -0400", hash_original_field = "C6B10B6E8FCFBBD6158DCF7BAF067E37", hash_generated_field = "30E32F1749CDDDAEE9911840601071DF")

        public int mShape = RECTANGLE;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.653 -0400", hash_original_field = "5676A2E63CEC3653FC9C82DADC4AF123", hash_generated_field = "56AB8E99AC45CB5CF4856C66FC6C47BB")

        public int mGradient = LINEAR_GRADIENT;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.654 -0400", hash_original_field = "7EA67827B94D10D1A4B368659EA63B71", hash_generated_field = "5AAEB1A21C682D9B78B733C0CAC81941")

        public Orientation mOrientation;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.663 -0400", hash_original_field = "F5B754067786840AA79148E1DA0BE95F", hash_generated_field = "3DBFAFBF2A210B2DCF4FE4AD0EE5F8A6")

        public int[] mColors;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.663 -0400", hash_original_field = "6CF1BB39416B1F09EF9D4E55A7941DD8", hash_generated_field = "173AA4B8B328A9892BF919E827149210")

        public int[] mTempColors;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.663 -0400", hash_original_field = "661C7BCF2E48C776BC9666E0EB9575F4", hash_generated_field = "43B2C9F377E90B066E4C6E0D502B88B5")

        public float[] mTempPositions;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.663 -0400", hash_original_field = "26068CDE4606F66C00056226111A3D61", hash_generated_field = "0691E3BE2D5AF1DE0154EF51BF6FCC3F")

        public float[] mPositions;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.663 -0400", hash_original_field = "0667246F9F18FDB890097AB34879167E", hash_generated_field = "17699B1A481FD58663277C59922F1CEC")

        public boolean mHasSolidColor;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.663 -0400", hash_original_field = "F761CF39D7B955BCB3910DD42D5B01E4", hash_generated_field = "6D0CD94C8238CE1C7956AFFDD29448AB")

        public int mSolidColor;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.663 -0400", hash_original_field = "F5273FFC49F0A2E75F684E1694B3B99D", hash_generated_field = "FBAAA34191259B10F232ADA2E3E6394F")

        public int mStrokeWidth = -1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.664 -0400", hash_original_field = "5795B8DC82C65556442F6200AD3A0EFC", hash_generated_field = "419129050F20C5FB9C65BFF93C429846")

        public int mStrokeColor;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.664 -0400", hash_original_field = "E3F49F22E23DB70A5F66B08B231C5462", hash_generated_field = "E26B465C065311CE0DE125D881B1D6E4")

        public float mStrokeDashWidth;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.664 -0400", hash_original_field = "A9F8F629DF69B895A0A45B9469988030", hash_generated_field = "B7852ABE2A09DB5F018447DAFA4BEEA9")

        public float mStrokeDashGap;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.664 -0400", hash_original_field = "B6EC135CB02066C1F33BA594902CBCC5", hash_generated_field = "17C7B79DFE9D3EEDD5E13C8AE4106B7D")

        public float mRadius;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.664 -0400", hash_original_field = "8140156D1EB5C39D070BB9A29E414C53", hash_generated_field = "0DA8B2C59E5420343AB30AE4DAA09601")

        public float[] mRadiusArray;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.664 -0400", hash_original_field = "9AC2544B5F9B8F60AA16656C94B57A8E", hash_generated_field = "8BBE9A045863D1F1F36EF813DE381D19")

        public Rect mPadding;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.664 -0400", hash_original_field = "A95631D81A2F2A7712CA1BACF8C3ED06", hash_generated_field = "1F9F6152246BD7DF79E6A284B49AF5F7")

        public int mWidth = -1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.665 -0400", hash_original_field = "B3AC750C72790F3A16FDCF47C86F48B7", hash_generated_field = "3A8CC26D109E69BFF346846D33EDE147")

        public int mHeight = -1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.668 -0400", hash_original_field = "1447A3152E9A5913C6245E29FDB204D1", hash_generated_field = "EB439DDC162B134FDA45E4F31A401D74")

        public float mInnerRadiusRatio;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.668 -0400", hash_original_field = "AD2C3563C09F6E98C0E761B5139A13A9", hash_generated_field = "39143D03DDE6F90F181E5B5DD3A18D8A")

        public float mThicknessRatio;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.668 -0400", hash_original_field = "731FB099D813D36E5B5100327955DDC0", hash_generated_field = "4DAAD7CE805773321F0C839951BF2F2D")

        public int mInnerRadius;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.668 -0400", hash_original_field = "504B9C20E398FD3A7D439D846A6CD818", hash_generated_field = "6358B57C3CC1F35B6E87ABD152B05898")

        public int mThickness;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.669 -0400", hash_original_field = "E23468CE053BA9207F87E59A2E6FAF8E", hash_generated_field = "5320CC7D83EC889F3C8D0197A0A7D909")

        private float mCenterX = 0.5f;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.669 -0400", hash_original_field = "E67B30AFFEB9530950B311F9AE35117B", hash_generated_field = "F307C555105E507E98EC0E358F605D84")

        private float mCenterY = 0.5f;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.669 -0400", hash_original_field = "CFEBBA7E330C7A3AC631943D5B123D20", hash_generated_field = "B9F1B6CC2ED8A4CB332BB75E0FD2137D")

        private float mGradientRadius = 0.5f;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.669 -0400", hash_original_field = "60A954EDC3ADF7263D111F1071671693", hash_generated_field = "5175CF60B12798080A42C69647993770")

        private boolean mUseLevel;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.669 -0400", hash_original_field = "C95C1388DC880DCBF9DACF9BC48190A8", hash_generated_field = "61E410A7B6997232E247B7717F217062")

        private boolean mUseLevelForShape;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.673 -0400", hash_original_method = "9C4B8156D5998AA4F070091BFAC51297", hash_generated_method = "36EA0AD2FEF9D7DF957604ED73351F6F")
          GradientState() {
            mOrientation = Orientation.TOP_BOTTOM;
            // ---------- Original Method ----------
            //mOrientation = Orientation.TOP_BOTTOM;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.683 -0400", hash_original_method = "D56C041244D40E3233BE0185764F984A", hash_generated_method = "DCD98CC869C46D3675D13FDE4D8B9C1F")
          GradientState(Orientation orientation, int[] colors) {
            mOrientation = orientation;
            mColors = colors;
            // ---------- Original Method ----------
            //mOrientation = orientation;
            //mColors = colors;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.728 -0400", hash_original_method = "E9F630A8A3449D4E0942DD92A53A8789", hash_generated_method = "FA71A05B2C53DD8A42D023CCB0AA7AFA")
        public  GradientState(GradientState state) {
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.729 -0400", hash_original_method = "995801C56CB4C9E6715A12BAA40CCB03", hash_generated_method = "C4C24D94C79746B9B5B754B88BB2C178")
        @Override
        public Drawable newDrawable() {
            Drawable varB4EAC82CA7396A68D541C85D26508E83_1763918737 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1763918737 = new GradientDrawable(this);
            varB4EAC82CA7396A68D541C85D26508E83_1763918737.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1763918737;
            // ---------- Original Method ----------
            //return new GradientDrawable(this);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.732 -0400", hash_original_method = "C54DA0CD853A4A5864DFD734D15AF82F", hash_generated_method = "75F01C396A41640C743A5242D1EF08DA")
        @Override
        public Drawable newDrawable(Resources res) {
            Drawable varB4EAC82CA7396A68D541C85D26508E83_1808261003 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1808261003 = new GradientDrawable(this);
            addTaint(res.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1808261003.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1808261003;
            // ---------- Original Method ----------
            //return new GradientDrawable(this);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.745 -0400", hash_original_method = "9E7D7C67EAC365FF19BD4971762612A5", hash_generated_method = "9169FCEAA8EB37C517DB3A803484C0B3")
        @Override
        public int getChangingConfigurations() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1064513160 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1064513160;
            // ---------- Original Method ----------
            //return mChangingConfigurations;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.746 -0400", hash_original_method = "0F10CA732F07DD9FE38CDA7CBCDABA95", hash_generated_method = "A3BF6B156577AD7EA2864200A6B2814C")
        public void setShape(int shape) {
            mShape = shape;
            // ---------- Original Method ----------
            //mShape = shape;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.747 -0400", hash_original_method = "6060B2E1C6E57F715C4E87E13018C121", hash_generated_method = "3AF067B4A790D8213658929FBB0E68D9")
        public void setGradientType(int gradient) {
            mGradient = gradient;
            // ---------- Original Method ----------
            //mGradient = gradient;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.754 -0400", hash_original_method = "90316D628B1BD1AAC4CD928A74CE9FD1", hash_generated_method = "4D02E3166FD3347AE6D9D6E0C8FEC8F1")
        public void setGradientCenter(float x, float y) {
            mCenterX = x;
            mCenterY = y;
            // ---------- Original Method ----------
            //mCenterX = x;
            //mCenterY = y;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.757 -0400", hash_original_method = "829DF5400D64CA55E626852A56B8E3B1", hash_generated_method = "3317E7F80C009F128AAB1DCE552FD5F5")
        public void setSolidColor(int argb) {
            mHasSolidColor = true;
            mSolidColor = argb;
            mColors = null;
            // ---------- Original Method ----------
            //mHasSolidColor = true;
            //mSolidColor = argb;
            //mColors = null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.780 -0400", hash_original_method = "0625749E363A97E3FB7A01916551E363", hash_generated_method = "C44E1F10EA13CAA1D96956245AF57DBD")
        public void setStroke(int width, int color) {
            mStrokeWidth = width;
            mStrokeColor = color;
            // ---------- Original Method ----------
            //mStrokeWidth = width;
            //mStrokeColor = color;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.781 -0400", hash_original_method = "62694733BCC23283C4956406C2DF326D", hash_generated_method = "215F441E5518AD68D917B36A2FBC122A")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.795 -0400", hash_original_method = "55392135B56F7FBDA5D3E3F94BBF1F23", hash_generated_method = "7866DFFF2318BFDA7AF20B36B2345CD8")
        public void setCornerRadius(float radius) {
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.796 -0400", hash_original_method = "17EB6FE4DB8FF42541FF19B71843B23B", hash_generated_method = "9DECCCC75B85A859408DC363F59D2EA4")
        public void setCornerRadii(float[] radii) {
            mRadiusArray = radii;
            {
                mRadius = 0;
            } //End block
            // ---------- Original Method ----------
            //mRadiusArray = radii;
            //if (radii == null) {
                //mRadius = 0;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.797 -0400", hash_original_method = "2560E21D822EB58266D32B5FBCFCA888", hash_generated_method = "937C2CF909C70F6CCE7A1CB2903577B5")
        public void setSize(int width, int height) {
            mWidth = width;
            mHeight = height;
            // ---------- Original Method ----------
            //mWidth = width;
            //mHeight = height;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.797 -0400", hash_original_method = "2D6DAC1104AA515AA78A28549F71CF0A", hash_generated_method = "47173080DDFD0B34A1D1F0DBFA24FE39")
        public void setGradientRadius(float gradientRadius) {
            mGradientRadius = gradientRadius;
            // ---------- Original Method ----------
            //mGradientRadius = gradientRadius;
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.797 -0400", hash_original_field = "6F6AD2BCE07B65CD47EF4D9E6AB86535", hash_generated_field = "46F776F4431B4AF5C3D3F15529915765")

    public static final int RECTANGLE = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.797 -0400", hash_original_field = "FA8319B0F3C7FFA99A9E2ED3934E43A6", hash_generated_field = "92F4ECF41E9A60B25A48F6BCF0A0A460")

    public static final int OVAL = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.797 -0400", hash_original_field = "D7BF7169F91A744DA6D893A0B94DE568", hash_generated_field = "8FA318F64C1EA44E4135E7B1C9F3F53D")

    public static final int LINE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.798 -0400", hash_original_field = "4E5E35B60A98BA38CA2EE85CA463EE6B", hash_generated_field = "49E47CDC93342C4EA5D171A90156D57F")

    public static final int RING = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.798 -0400", hash_original_field = "A46CDAED2F7CD310C857690734CA8898", hash_generated_field = "9F6612F723A63EEE72B0859940E37105")

    public static final int LINEAR_GRADIENT = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.798 -0400", hash_original_field = "E7C810F9A8263081A505D6276CA240DD", hash_generated_field = "262A5D2CC9AE6734365493D15224EC30")

    public static final int RADIAL_GRADIENT = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.798 -0400", hash_original_field = "F8EB4F09BE09B068FC74D809D5EDB13D", hash_generated_field = "6BE6B5DD9A6FF64825BE79B8763B5D70")

    public static final int SWEEP_GRADIENT  = 2;
}

