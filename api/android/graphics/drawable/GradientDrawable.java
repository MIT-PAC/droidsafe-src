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
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PixelFormat;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.util.TypedValue;

public class GradientDrawable extends Drawable {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:16.671 -0500", hash_original_method = "2A7FC3BC597ED3507106B83B5AF4DE4F", hash_generated_method = "F578B0CF8A2A8525C61A3D3133D5BF57")
    
private static float getFloatOrFraction(TypedArray a, int index, float defaultValue) {
        TypedValue tv = a.peekValue(index);
        float v = defaultValue;
        if (tv != null) {
            boolean vIsFraction = tv.type == TypedValue.TYPE_FRACTION;
            v = vIsFraction ? tv.getFraction(1.0f, 1.0f) : tv.getFloat();
        }
        return v;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:16.552 -0500", hash_original_field = "3BC2D48CC801C24D0FAD6E269FB48ACD", hash_generated_field = "46F776F4431B4AF5C3D3F15529915765")

    public static final int RECTANGLE = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:16.554 -0500", hash_original_field = "08679A999B20A31DEEF39C0B29B793F3", hash_generated_field = "92F4ECF41E9A60B25A48F6BCF0A0A460")

    public static final int OVAL = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:16.556 -0500", hash_original_field = "4A236D90318662862923A15D0C7BB4A2", hash_generated_field = "8FA318F64C1EA44E4135E7B1C9F3F53D")

    public static final int LINE = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:16.558 -0500", hash_original_field = "0B9912BEB0A4B0609E86634EEB9E02C8", hash_generated_field = "49E47CDC93342C4EA5D171A90156D57F")

    public static final int RING = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:16.561 -0500", hash_original_field = "19A495E39E33C25F49621B6728DB21A1", hash_generated_field = "9F6612F723A63EEE72B0859940E37105")

    public static final int LINEAR_GRADIENT = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:16.563 -0500", hash_original_field = "0425B45E8460F384316FA6DA434BA37B", hash_generated_field = "262A5D2CC9AE6734365493D15224EC30")

    public static final int RADIAL_GRADIENT = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:16.566 -0500", hash_original_field = "211685135F6AA4A1909E784CBF613CB2", hash_generated_field = "6BE6B5DD9A6FF64825BE79B8763B5D70")

    public static final int SWEEP_GRADIENT  = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:16.568 -0500", hash_original_field = "16EC54AB2DBF543816DE6E0CAC65429B", hash_generated_field = "F8FC523C37AC4F355E3A52C1D395B9CA")

    private GradientState mGradientState;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:16.570 -0500", hash_original_field = "C0FE052D74ED3D0BFF372BD75249E782", hash_generated_field = "20B811D11F80D9B524F2E016940568D0")
    
    private final Paint mFillPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:16.572 -0500", hash_original_field = "A053A94BBF9972B52A80E2FC510022E8", hash_generated_field = "017017AA9AF1862D01EDDEC3A7AB7775")

    private Rect mPadding;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:16.574 -0500", hash_original_field = "293271EDB8C83D67B31F871CC8DCD784", hash_generated_field = "9FB471477563645F319E80BA6D6ED905")

    private Paint mStrokePaint;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:16.576 -0500", hash_original_field = "FDF54A2FE886548299B21698A652A06E", hash_generated_field = "5D6D299C9DDEDCCB11EFFA1C147C3DF6")

    private ColorFilter mColorFilter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:16.578 -0500", hash_original_field = "8A6F8C8F01D3E97C17A658DC10C92A1D", hash_generated_field = "3503E015FBD1508491B2F18FDC5DAF9F")

    private int mAlpha = 0xFF;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:16.580 -0500", hash_original_field = "28ABDDC6F40109F392846C3ED0C6A12A", hash_generated_field = "B8E34DBCCD5A9935E92ED2F73AF5F8B7")

    private boolean mDither;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:16.583 -0500", hash_original_field = "9F8A427DBED06081C76DCB512FA4C1C6", hash_generated_field = "1C9B38C7F9B71799B7B8F281B135448B")

    private final Path mPath = new Path();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:16.585 -0500", hash_original_field = "499D59727FC656C05DFD3E86493F2A86", hash_generated_field = "E70F5B350707014CDC8DCA8B7C0C28DD")

    private final RectF mRect = new RectF();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:16.587 -0500", hash_original_field = "DF81DF3E7FE84B1D663D7E8ECAF0C794", hash_generated_field = "A6ACFEE6A39EC6759FF9E6489D52AFB1")
    
    private Paint mLayerPaint;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:16.589 -0500", hash_original_field = "F7DB3ABD3DAEEC465C84BDC747581B7E", hash_generated_field = "82A739DA370CC4D4C339BB7C440434C4")

    private boolean mRectIsDirty;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:16.591 -0500", hash_original_field = "B15C308E96D0EEBD27CFE369FA349C15", hash_generated_field = "5CA5A1EF3CAA45117BCACBC34EF05952")

    private boolean mMutated;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:16.593 -0500", hash_original_field = "5EDE4E634F4A7206B735BBA817B00550", hash_generated_field = "FB9692F405D4B8918DCE56B27CC81A6B")

    private Path mRingPath;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:16.596 -0500", hash_original_field = "261C0AD769EA712D66A962CE253C262D", hash_generated_field = "EAB2B54D4BC3106764331272E438AA0A")

    private boolean mPathIsDirty = true;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:16.600 -0500", hash_original_method = "64287040FBFB7F81692AADB4245B0378", hash_generated_method = "9E6BAE35B9008BC712C2A5F5E71F0CBF")
    
public GradientDrawable() {
        this(new GradientState(Orientation.TOP_BOTTOM, null));
    }
    
    /**
     * Create a new gradient drawable given an orientation and an array
     * of colors for the gradient.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:16.602 -0500", hash_original_method = "48FF7A4A9E39F0BE519CF2AE778248C7", hash_generated_method = "39F2C28974131F406B092D9E374533EF")
    
public GradientDrawable(Orientation orientation, int[] colors) {
        this(new GradientState(orientation, colors));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:16.788 -0500", hash_original_method = "11AB49F3A166C4EC986EE8723C09CE3C", hash_generated_method = "107B91260D64028FA069B28E9B874067")
    
private GradientDrawable(GradientState state) {
        mGradientState = state;
        initializeWithState(state);
        mRectIsDirty = true;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:16.604 -0500", hash_original_method = "0B8807A1903E03E118A45AC647AD9F24", hash_generated_method = "DDF82EEC11A9EB7B003C9AD88AFE7F5B")
    
@Override
    public boolean getPadding(Rect padding) {
        if (mPadding != null) {
            padding.set(mPadding);
            return true;
        } else {
            return super.getPadding(padding);
        }
    }

    /**
     * Specify radii for each of the 4 corners. For each corner, the array
     * contains 2 values, [X_radius, Y_radius]. The corners are ordered
     * top-left, top-right, bottom-right, bottom-left
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:16.607 -0500", hash_original_method = "71F948CC6AEC5EB6067752059DA33574", hash_generated_method = "55593BB00DDCCE34D3B140D4863D4755")
    
public void setCornerRadii(float[] radii) {
        mGradientState.setCornerRadii(radii);
        mPathIsDirty = true;
        invalidateSelf();
    }
    
    /**
     * Specify radius for the corners of the gradient. If this is > 0, then the
     * drawable is drawn in a round-rectangle, rather than a rectangle.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:16.609 -0500", hash_original_method = "AFB7C3E5AE7C3BBB28B141F7A3B472BE", hash_generated_method = "C25BA52FCE3048809120D9F850C4E143")
    
public void setCornerRadius(float radius) {
        mGradientState.setCornerRadius(radius);
        mPathIsDirty = true;
        invalidateSelf();
    }
    
    /**
     * Set the stroke width and color for the drawable. If width is zero,
     * then no stroke is drawn.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:16.611 -0500", hash_original_method = "6A0F62EB2F02BD455327DA9DA2DD0568", hash_generated_method = "5B8999B9C7DC5E8D9861803D23B6C2B3")
    
public void setStroke(int width, int color) {
        setStroke(width, color, 0, 0);
    }
    
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:16.613 -0500", hash_original_method = "F36B912577B048DA0236870F939930FC", hash_generated_method = "B9C0A6ACDEDAEEDBE1BC50425DB3D62A")
    
public void setStroke(int width, int color, float dashWidth, float dashGap) {
        mGradientState.setStroke(width, color, dashWidth, dashGap);

        if (mStrokePaint == null)  {
            mStrokePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
            mStrokePaint.setStyle(Paint.Style.STROKE);
        }
        mStrokePaint.setStrokeWidth(width);
        mStrokePaint.setColor(color);
        
        DashPathEffect e = null;
        if (dashWidth > 0) {
            e = new DashPathEffect(new float[] { dashWidth, dashGap }, 0);
        }
        mStrokePaint.setPathEffect(e);
        invalidateSelf();
    }
    
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:16.615 -0500", hash_original_method = "DBF55AE12AFE7021A6EFA67946A43E31", hash_generated_method = "BE1E4407B9A91F34977DE90BA22DDC6A")
    
public void setSize(int width, int height) {
        mGradientState.setSize(width, height);
        mPathIsDirty = true;
        invalidateSelf();
    }
    
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:16.618 -0500", hash_original_method = "70A303A49D3D529F927A8B25154245C2", hash_generated_method = "35656DC0149E7E7B0984EC11AF0ED466")
    
public void setShape(int shape) {
        mRingPath = null;
        mPathIsDirty = true;
        mGradientState.setShape(shape);
        invalidateSelf();
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:16.621 -0500", hash_original_method = "18DB26B14B71A02370E6DE427E61924A", hash_generated_method = "5567028F009957DA9198E3B556F3A189")
    
public void setGradientType(int gradient) {
        mGradientState.setGradientType(gradient);
        mRectIsDirty = true;
        invalidateSelf();
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:16.623 -0500", hash_original_method = "45A2D9788BC882B134EC764255BF8E5D", hash_generated_method = "8EFFCDF995AD8D9670AA5B4B3F6516CB")
    
public void setGradientCenter(float x, float y) {
        mGradientState.setGradientCenter(x, y);
        mRectIsDirty = true;
        invalidateSelf();
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:16.625 -0500", hash_original_method = "C7CA2F8177799FD0AFA978CBCB22DF14", hash_generated_method = "67B255173F4AC5FB61C41C032D36DA90")
    
public void setGradientRadius(float gradientRadius) {
        mGradientState.setGradientRadius(gradientRadius);
        mRectIsDirty = true;
        invalidateSelf();
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:16.627 -0500", hash_original_method = "76C6B5A7FB76D454B2D8C7EAA5B46C4F", hash_generated_method = "F2D37CC4AF0EA69E0A2E2166CB496BAA")
    
public void setUseLevel(boolean useLevel) {
        mGradientState.mUseLevel = useLevel;
        mRectIsDirty = true;
        invalidateSelf();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:16.630 -0500", hash_original_method = "0886E73CB45EE282B3AFC0BE37F5BE6C", hash_generated_method = "FBC4E6FBF66103FD9530D89C3176ECF4")
    
private int modulateAlpha(int alpha) {
        int scale = mAlpha + (mAlpha >> 7);
        return alpha * scale >> 8;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:16.634 -0500", hash_original_method = "ACDDE907D9101C7CDDBBB954BA4F617E", hash_generated_method = "FE341961AD289E1A38BF3FE578DB496D")
    
@Override
    public void draw(Canvas canvas) {
        if (!ensureValidRect()) {
            // nothing to draw
            return;
        }

        // remember the alpha values, in case we temporarily overwrite them
        // when we modulate them with mAlpha
        final int prevFillAlpha = mFillPaint.getAlpha();
        final int prevStrokeAlpha = mStrokePaint != null ? mStrokePaint.getAlpha() : 0;
        // compute the modulate alpha values
        final int currFillAlpha = modulateAlpha(prevFillAlpha);
        final int currStrokeAlpha = modulateAlpha(prevStrokeAlpha);

        final boolean haveStroke = currStrokeAlpha > 0 && mStrokePaint.getStrokeWidth() > 0;
        final boolean haveFill = currFillAlpha > 0;
        final GradientState st = mGradientState;
        /*  we need a layer iff we're drawing both a fill and stroke, and the
            stroke is non-opaque, and our shapetype actually supports
            fill+stroke. Otherwise we can just draw the stroke (if any) on top
            of the fill (if any) without worrying about blending artifacts.
         */
         final boolean useLayer = haveStroke && haveFill && st.mShape != LINE &&
                 currStrokeAlpha < 255 && (mAlpha < 255 || mColorFilter != null);

        /*  Drawing with a layer is slower than direct drawing, but it
            allows us to apply paint effects like alpha and colorfilter to
            the result of multiple separate draws. In our case, if the user
            asks for a non-opaque alpha value (via setAlpha), and we're
            stroking, then we need to apply the alpha AFTER we've drawn
            both the fill and the stroke.
        */
        if (useLayer) {
            if (mLayerPaint == null) {
                mLayerPaint = new Paint();
            }
            mLayerPaint.setDither(mDither);
            mLayerPaint.setAlpha(mAlpha);
            mLayerPaint.setColorFilter(mColorFilter);

            float rad = mStrokePaint.getStrokeWidth();
            canvas.saveLayer(mRect.left - rad, mRect.top - rad,
                             mRect.right + rad, mRect.bottom + rad,
                             mLayerPaint, Canvas.HAS_ALPHA_LAYER_SAVE_FLAG);

            // don't perform the filter in our individual paints
            // since the layer will do it for us
            mFillPaint.setColorFilter(null);
            mStrokePaint.setColorFilter(null);
        } else {
            /*  if we're not using a layer, apply the dither/filter to our
                individual paints
            */
            mFillPaint.setAlpha(currFillAlpha);
            mFillPaint.setDither(mDither);
            mFillPaint.setColorFilter(mColorFilter);
            if (haveStroke) {
                mStrokePaint.setAlpha(currStrokeAlpha);
                mStrokePaint.setDither(mDither);
                mStrokePaint.setColorFilter(mColorFilter);
            }
        }
        
        switch (st.mShape) {
            case RECTANGLE:
                if (st.mRadiusArray != null) {
                    if (mPathIsDirty || mRectIsDirty) {
                        mPath.reset();
                        mPath.addRoundRect(mRect, st.mRadiusArray, Path.Direction.CW);
                        mPathIsDirty = mRectIsDirty = false;
                    }
                    canvas.drawPath(mPath, mFillPaint);
                    if (haveStroke) {
                        canvas.drawPath(mPath, mStrokePaint);
                    }
                } else if (st.mRadius > 0.0f) {
                    // since the caller is only giving us 1 value, we will force
                    // it to be square if the rect is too small in one dimension
                    // to show it. If we did nothing, Skia would clamp the rad
                    // independently along each axis, giving us a thin ellipse
                    // if the rect were very wide but not very tall
                    float rad = st.mRadius;
                    float r = Math.min(mRect.width(), mRect.height()) * 0.5f;
                    if (rad > r) {
                        rad = r;
                    }
                    canvas.drawRoundRect(mRect, rad, rad, mFillPaint);
                    if (haveStroke) {
                        canvas.drawRoundRect(mRect, rad, rad, mStrokePaint);
                    }
                } else {
                    canvas.drawRect(mRect, mFillPaint);
                    if (haveStroke) {
                        canvas.drawRect(mRect, mStrokePaint);
                    }
                }
                break;
            case OVAL:
                canvas.drawOval(mRect, mFillPaint);
                if (haveStroke) {
                    canvas.drawOval(mRect, mStrokePaint);
                }
                break;
            case LINE: {
                RectF r = mRect;
                float y = r.centerY();
                canvas.drawLine(r.left, y, r.right, y, mStrokePaint);
                break;
            }
            case RING:
                Path path = buildRing(st);
                canvas.drawPath(path, mFillPaint);
                if (haveStroke) {
                    canvas.drawPath(path, mStrokePaint);
                }
                break;
        }
        
        if (useLayer) {
            canvas.restore();
        } else {
            mFillPaint.setAlpha(prevFillAlpha);
            if (haveStroke) {
                mStrokePaint.setAlpha(prevStrokeAlpha);
            }
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:16.637 -0500", hash_original_method = "FA54FBF5F964BB48C4F923A57A9FF840", hash_generated_method = "63F8AD16476857C4F153D341683EE9DA")
    
private Path buildRing(GradientState st) {
        if (mRingPath != null && (!st.mUseLevelForShape || !mPathIsDirty)) return mRingPath;
        mPathIsDirty = false;

        float sweep = st.mUseLevelForShape ? (360.0f * getLevel() / 10000.0f) : 360f;
        
        RectF bounds = new RectF(mRect);

        float x = bounds.width() / 2.0f;
        float y = bounds.height() / 2.0f;

        float thickness = st.mThickness != -1 ?
                st.mThickness : bounds.width() / st.mThicknessRatio;
        // inner radius
        float radius = st.mInnerRadius != -1 ?
                st.mInnerRadius : bounds.width() / st.mInnerRadiusRatio;

        RectF innerBounds = new RectF(bounds);
        innerBounds.inset(x - radius, y - radius);

        bounds = new RectF(innerBounds);
        bounds.inset(-thickness, -thickness);

        if (mRingPath == null) {
            mRingPath = new Path();
        } else {
            mRingPath.reset();            
        }

        final Path ringPath = mRingPath;
        // arcTo treats the sweep angle mod 360, so check for that, since we
        // think 360 means draw the entire oval
        if (sweep < 360 && sweep > -360) {
            ringPath.setFillType(Path.FillType.EVEN_ODD);
            // inner top
            ringPath.moveTo(x + radius, y);
            // outer top
            ringPath.lineTo(x + radius + thickness, y);
            // outer arc
            ringPath.arcTo(bounds, 0.0f, sweep, false);
            // inner arc
            ringPath.arcTo(innerBounds, sweep, -sweep, false);
            ringPath.close();
        } else {
            // add the entire ovals
            ringPath.addOval(bounds, Path.Direction.CW);
            ringPath.addOval(innerBounds, Path.Direction.CCW);
        }

        return ringPath;
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:16.640 -0500", hash_original_method = "A6E3DC666A9DC913CF167BAEE3BA3755", hash_generated_method = "20C1E70B42A2F5B1828F48BF2FA64845")
    
public void setColor(int argb) {
        mGradientState.setSolidColor(argb);
        mFillPaint.setColor(argb);
        invalidateSelf();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:16.642 -0500", hash_original_method = "3865DA4989774EEF9AAAD48E0098B1D2", hash_generated_method = "5B7992AAC4E5AF1260016B3CFFEBE3C4")
    
@Override
    public int getChangingConfigurations() {
        return super.getChangingConfigurations()
                | mGradientState.mChangingConfigurations;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:16.644 -0500", hash_original_method = "5182E1ED546D38ED0370680C356A26EE", hash_generated_method = "E73515240D0ADBE9EB02F05220B12199")
    
@Override
    public void setAlpha(int alpha) {
        if (alpha != mAlpha) {
            mAlpha = alpha;
            invalidateSelf();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:16.646 -0500", hash_original_method = "9DFE5D886E6229E65D3F438DE9F28624", hash_generated_method = "9F4759105C8703EDBF46840686784EBB")
    
@Override
    public void setDither(boolean dither) {
        if (dither != mDither) {
            mDither = dither;
            invalidateSelf();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:16.649 -0500", hash_original_method = "0D338CBBF9E8A18D18E6BF68648024B0", hash_generated_method = "24169731B0F467E7BBB3F25BEEECCFD8")
    
@Override
    public void setColorFilter(ColorFilter cf) {
        if (cf != mColorFilter) {
            mColorFilter = cf;
            invalidateSelf();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:16.651 -0500", hash_original_method = "AB3D570DA2A917C408AB4F7D8FCD7103", hash_generated_method = "10DE806C6642B5F0CD513CB0E3A17B5D")
    
@Override
    public int getOpacity() {
        // XXX need to figure out the actual opacity...
        return PixelFormat.TRANSLUCENT;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:16.653 -0500", hash_original_method = "8123137F2C4F03B6AAC99B13B8B696DA", hash_generated_method = "456084E2E024CA3A86AFF8AC7E271A08")
    
@Override
    protected void onBoundsChange(Rect r) {
        super.onBoundsChange(r);
        mRingPath = null;
        mPathIsDirty = true;
        mRectIsDirty = true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:16.656 -0500", hash_original_method = "394C06781A7C1BB568DD9A62F4177986", hash_generated_method = "0462C7C415E3DB753CDC1C88B200CD3B")
    
@Override
    protected boolean onLevelChange(int level) {
        super.onLevelChange(level);
        mRectIsDirty = true;
        mPathIsDirty = true;
        invalidateSelf();
        return true;
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:16.683 -0500", hash_original_field = "9BFAF00848476277D36D9BA586984BA7", hash_generated_field = "0AA9CE94E21E2967183254C710B3C74D")

        public int mChangingConfigurations;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:16.685 -0500", hash_original_field = "7A0110D42D9A0C4FEA2CE6C0D30E3BBC", hash_generated_field = "30E32F1749CDDDAEE9911840601071DF")

        public int mShape = RECTANGLE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:16.687 -0500", hash_original_field = "23827E199639535CC4F0FC66B5210CBF", hash_generated_field = "56AB8E99AC45CB5CF4856C66FC6C47BB")

        public int mGradient = LINEAR_GRADIENT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:16.689 -0500", hash_original_field = "4E07B33AB102347DCE1B070B756EC87E", hash_generated_field = "5AAEB1A21C682D9B78B733C0CAC81941")

        public Orientation mOrientation;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:16.692 -0500", hash_original_field = "8BCB86BAF7C31D49B3DD83C851FBAC85", hash_generated_field = "3DBFAFBF2A210B2DCF4FE4AD0EE5F8A6")

        public int[] mColors;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:16.694 -0500", hash_original_field = "B498F0AD78C9E75DB7D34B7B0197975C", hash_generated_field = "173AA4B8B328A9892BF919E827149210")

        public int[] mTempColors;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:16.696 -0500", hash_original_field = "E7205962C5A36D0F3A8A5C9FEC15BA1D", hash_generated_field = "43B2C9F377E90B066E4C6E0D502B88B5")

        public float[] mTempPositions;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:16.698 -0500", hash_original_field = "CAA8C68DCB1ECB1118391E9BEF33DE50", hash_generated_field = "0691E3BE2D5AF1DE0154EF51BF6FCC3F")

        public float[] mPositions;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:16.701 -0500", hash_original_field = "0847EBF02F007AC9924E84572A10AA9B", hash_generated_field = "17699B1A481FD58663277C59922F1CEC")

        public boolean mHasSolidColor;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:16.703 -0500", hash_original_field = "E26765170D65F5A03459947C85ABE151", hash_generated_field = "6D0CD94C8238CE1C7956AFFDD29448AB")

        public int mSolidColor;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:16.705 -0500", hash_original_field = "7BD3D743E42E55A9014686399554C1AB", hash_generated_field = "FBAAA34191259B10F232ADA2E3E6394F")

        public int mStrokeWidth = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:16.707 -0500", hash_original_field = "26829D2B323A4D001C650FDD882B3753", hash_generated_field = "419129050F20C5FB9C65BFF93C429846")

        public int mStrokeColor;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:16.710 -0500", hash_original_field = "228FADF0F8E0BFE990FC8A6927474455", hash_generated_field = "E26B465C065311CE0DE125D881B1D6E4")

        public float mStrokeDashWidth;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:16.712 -0500", hash_original_field = "AADD89E4909F1CF79D4E989790719F8B", hash_generated_field = "B7852ABE2A09DB5F018447DAFA4BEEA9")

        public float mStrokeDashGap;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:16.714 -0500", hash_original_field = "F857AD615F2F778CC53A73828D22C4D4", hash_generated_field = "17C7B79DFE9D3EEDD5E13C8AE4106B7D")

        public float mRadius;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:16.716 -0500", hash_original_field = "4C2772AACCDB126E79C68D547A1AC63D", hash_generated_field = "0DA8B2C59E5420343AB30AE4DAA09601")

        public float[] mRadiusArray;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:16.719 -0500", hash_original_field = "A053A94BBF9972B52A80E2FC510022E8", hash_generated_field = "8BBE9A045863D1F1F36EF813DE381D19")

        public Rect mPadding;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:16.721 -0500", hash_original_field = "2BA03B5BE1E097B9BC57B210061D879D", hash_generated_field = "1F9F6152246BD7DF79E6A284B49AF5F7")

        public int mWidth = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:16.723 -0500", hash_original_field = "3D81262840DA37820D58425FC486E30D", hash_generated_field = "3A8CC26D109E69BFF346846D33EDE147")

        public int mHeight = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:16.726 -0500", hash_original_field = "616FFB3EEB87C6BA8CBC2375B1E7EEAE", hash_generated_field = "EB439DDC162B134FDA45E4F31A401D74")

        public float mInnerRadiusRatio;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:16.728 -0500", hash_original_field = "2421FF852D21D176A961C147BE520654", hash_generated_field = "39143D03DDE6F90F181E5B5DD3A18D8A")

        public float mThicknessRatio;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:16.731 -0500", hash_original_field = "51DD6C70133D898A1A2F1D92E22BA80C", hash_generated_field = "4DAAD7CE805773321F0C839951BF2F2D")

        public int mInnerRadius;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:16.733 -0500", hash_original_field = "A3C7D72705AA350D944F885E6EE7937F", hash_generated_field = "6358B57C3CC1F35B6E87ABD152B05898")

        public int mThickness;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:16.735 -0500", hash_original_field = "24EA92764BFD23AA3099A070857BF208", hash_generated_field = "5320CC7D83EC889F3C8D0197A0A7D909")

        private float mCenterX = 0.5f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:16.737 -0500", hash_original_field = "EDE6D3A1F95D193B0C52ABF7BB2EA9D0", hash_generated_field = "F307C555105E507E98EC0E358F605D84")

        private float mCenterY = 0.5f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:16.739 -0500", hash_original_field = "EF87C22F34512B3A17FCF0DEE770E9BE", hash_generated_field = "B9F1B6CC2ED8A4CB332BB75E0FD2137D")

        private float mGradientRadius = 0.5f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:16.741 -0500", hash_original_field = "D0B7C7357CB0A954F3BDC7E371D2F45D", hash_generated_field = "5175CF60B12798080A42C69647993770")

        private boolean mUseLevel;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:16.743 -0500", hash_original_field = "D64F88A19F963A802A2C33B0BACA802F", hash_generated_field = "61E410A7B6997232E247B7717F217062")

        private boolean mUseLevelForShape;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:16.746 -0500", hash_original_method = "9C4B8156D5998AA4F070091BFAC51297", hash_generated_method = "9C4B8156D5998AA4F070091BFAC51297")
        
GradientState() {
            mOrientation = Orientation.TOP_BOTTOM;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:16.749 -0500", hash_original_method = "D56C041244D40E3233BE0185764F984A", hash_generated_method = "D56C041244D40E3233BE0185764F984A")
        
GradientState(Orientation orientation, int[] colors) {
            mOrientation = orientation;
            mColors = colors;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:16.752 -0500", hash_original_method = "E9F630A8A3449D4E0942DD92A53A8789", hash_generated_method = "B6623952A98DEE1D08624725C3739678")
        
public GradientState(GradientState state) {
            mChangingConfigurations = state.mChangingConfigurations;
            mShape = state.mShape;
            mGradient = state.mGradient;
            mOrientation = state.mOrientation;
            if (state.mColors != null) {
                mColors = state.mColors.clone();
            }
            if (state.mPositions != null) {
                mPositions = state.mPositions.clone();
            }
            mHasSolidColor = state.mHasSolidColor;
            mSolidColor = state.mSolidColor;
            mStrokeWidth = state.mStrokeWidth;
            mStrokeColor = state.mStrokeColor;
            mStrokeDashWidth = state.mStrokeDashWidth;
            mStrokeDashGap = state.mStrokeDashGap;
            mRadius = state.mRadius;
            if (state.mRadiusArray != null) {
                mRadiusArray = state.mRadiusArray.clone();
            }
            if (state.mPadding != null) {
                mPadding = new Rect(state.mPadding);
            }
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
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:16.755 -0500", hash_original_method = "995801C56CB4C9E6715A12BAA40CCB03", hash_generated_method = "A97C7C74298F43EFE33F7369581FC02E")
        
@Override
        public Drawable newDrawable() {
            return new GradientDrawable(this);
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:16.757 -0500", hash_original_method = "C54DA0CD853A4A5864DFD734D15AF82F", hash_generated_method = "68E4CB023758AD54FB8AD42A05F8FE26")
        
@Override
        public Drawable newDrawable(Resources res) {
            return new GradientDrawable(this);
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:16.760 -0500", hash_original_method = "9E7D7C67EAC365FF19BD4971762612A5", hash_generated_method = "3AB30668ED270F2EDF2E0129C706FE4D")
        
@Override
        public int getChangingConfigurations() {
            return mChangingConfigurations;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:16.762 -0500", hash_original_method = "0F10CA732F07DD9FE38CDA7CBCDABA95", hash_generated_method = "8A6D385D6822F15EEBDE032E99E5A242")
        
public void setShape(int shape) {
            mShape = shape;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:16.764 -0500", hash_original_method = "6060B2E1C6E57F715C4E87E13018C121", hash_generated_method = "54E62F84B4E0D4B52E3F2F0DD5B05300")
        
public void setGradientType(int gradient) {
            mGradient = gradient;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:16.766 -0500", hash_original_method = "90316D628B1BD1AAC4CD928A74CE9FD1", hash_generated_method = "85A7ABE6E47982A221C0CB81CBF27FBD")
        
public void setGradientCenter(float x, float y) {
            mCenterX = x;
            mCenterY = y;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:16.769 -0500", hash_original_method = "829DF5400D64CA55E626852A56B8E3B1", hash_generated_method = "B1DFE208CE7C7A93731F46EFFCAF2EE4")
        
public void setSolidColor(int argb) {
            mHasSolidColor = true;
            mSolidColor = argb;
            mColors = null;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:16.771 -0500", hash_original_method = "0625749E363A97E3FB7A01916551E363", hash_generated_method = "634B638B31C85109A8D0E8C75886BD27")
        
public void setStroke(int width, int color) {
            mStrokeWidth = width;
            mStrokeColor = color;
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:16.774 -0500", hash_original_method = "62694733BCC23283C4956406C2DF326D", hash_generated_method = "13C57D662CED2FCC98AA9C39B931B87C")
        
public void setStroke(int width, int color, float dashWidth, float dashGap) {
            mStrokeWidth = width;
            mStrokeColor = color;
            mStrokeDashWidth = dashWidth;
            mStrokeDashGap = dashGap;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:16.776 -0500", hash_original_method = "55392135B56F7FBDA5D3E3F94BBF1F23", hash_generated_method = "96C49E8D1351890B72836199B2073F51")
        
public void setCornerRadius(float radius) {
            if (radius < 0) {
                radius = 0;
            }
            mRadius = radius;
            mRadiusArray = null;
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:16.779 -0500", hash_original_method = "17EB6FE4DB8FF42541FF19B71843B23B", hash_generated_method = "EAB25C555495E296C80EB1BB0EE09FE8")
        
public void setCornerRadii(float[] radii) {
            mRadiusArray = radii;
            if (radii == null) {
                mRadius = 0;
            }
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:16.781 -0500", hash_original_method = "2560E21D822EB58266D32B5FBCFCA888", hash_generated_method = "BEDF188A0EC8BD748C2219CB14E1DFDF")
        
public void setSize(int width, int height) {
            mWidth = width;
            mHeight = height;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:16.783 -0500", hash_original_method = "2D6DAC1104AA515AA78A28549F71CF0A", hash_generated_method = "E4062BEDCDBBF6E7A7BE1043B70F7B44")
        
public void setGradientRadius(float gradientRadius) {
            mGradientRadius = gradientRadius;
        }
        
    }

    /**
     * This checks mRectIsDirty, and if it is true, recomputes both our drawing
     * rectangle (mRect) and the gradient itself, since it depends on our
     * rectangle too.
     * @return true if the resulting rectangle is not empty, false otherwise
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:16.660 -0500", hash_original_method = "A926FB4015A038016094FA9870012FFA", hash_generated_method = "02DABE826AC243D7038F9FF00D262515")
    
private boolean ensureValidRect() {
        if (mRectIsDirty) {
            mRectIsDirty = false;

            Rect bounds = getBounds();
            float inset = 0;
            
            if (mStrokePaint != null) {
                inset = mStrokePaint.getStrokeWidth() * 0.5f;
            }

            final GradientState st = mGradientState;

            mRect.set(bounds.left + inset, bounds.top + inset,
                      bounds.right - inset, bounds.bottom - inset);

            final int[] colors = st.mColors;
            if (colors != null) {
                RectF r = mRect;
                float x0, x1, y0, y1;

                if (st.mGradient == LINEAR_GRADIENT) {
                    final float level = st.mUseLevel ? (float) getLevel() / 10000.0f : 1.0f;                    
                    switch (st.mOrientation) {
                    case TOP_BOTTOM:
                        x0 = r.left;            y0 = r.top;
                        x1 = x0;                y1 = level * r.bottom;
                        break;
                    case TR_BL:
                        x0 = r.right;           y0 = r.top;
                        x1 = level * r.left;    y1 = level * r.bottom;
                        break;
                    case RIGHT_LEFT:
                        x0 = r.right;           y0 = r.top;
                        x1 = level * r.left;    y1 = y0;
                        break;
                    case BR_TL:
                        x0 = r.right;           y0 = r.bottom;
                        x1 = level * r.left;    y1 = level * r.top;
                        break;
                    case BOTTOM_TOP:
                        x0 = r.left;            y0 = r.bottom;
                        x1 = x0;                y1 = level * r.top;
                        break;
                    case BL_TR:
                        x0 = r.left;            y0 = r.bottom;
                        x1 = level * r.right;   y1 = level * r.top;
                        break;
                    case LEFT_RIGHT:
                        x0 = r.left;            y0 = r.top;
                        x1 = level * r.right;   y1 = y0;
                        break;
                    default:/* TL_BR */
                        x0 = r.left;            y0 = r.top;
                        x1 = level * r.right;   y1 = level * r.bottom;
                        break;
                    }

                    mFillPaint.setShader(new LinearGradient(x0, y0, x1, y1,
                            colors, st.mPositions, Shader.TileMode.CLAMP));
                } else if (st.mGradient == RADIAL_GRADIENT) {
                    x0 = r.left + (r.right - r.left) * st.mCenterX;
                    y0 = r.top + (r.bottom - r.top) * st.mCenterY;

                    final float level = st.mUseLevel ? (float) getLevel() / 10000.0f : 1.0f;

                    mFillPaint.setShader(new RadialGradient(x0, y0,
                            level * st.mGradientRadius, colors, null,
                            Shader.TileMode.CLAMP));
                } else if (st.mGradient == SWEEP_GRADIENT) {
                    x0 = r.left + (r.right - r.left) * st.mCenterX;
                    y0 = r.top + (r.bottom - r.top) * st.mCenterY;

                    int[] tempColors = colors;
                    float[] tempPositions = null;

                    if (st.mUseLevel) {
                        tempColors = st.mTempColors;
                        final int length = colors.length;
                        if (tempColors == null || tempColors.length != length + 1) {
                            tempColors = st.mTempColors = new int[length + 1];
                        }
                        System.arraycopy(colors, 0, tempColors, 0, length);
                        tempColors[length] = colors[length - 1];

                        tempPositions = st.mTempPositions;
                        final float fraction = 1.0f / (float) (length - 1);
                        if (tempPositions == null || tempPositions.length != length + 1) {
                            tempPositions = st.mTempPositions = new float[length + 1];
                        }

                        final float level = (float) getLevel() / 10000.0f;
                        for (int i = 0; i < length; i++) {
                            tempPositions[i] = i * fraction * level;
                        }
                        tempPositions[length] = 1.0f;

                    }
                    mFillPaint.setShader(new SweepGradient(x0, y0, tempColors, tempPositions));
                }
            }
        }
        return !mRect.isEmpty();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:16.668 -0500", hash_original_method = "E432865D544D266B015263529D7B28D5", hash_generated_method = "0319C73E0142076537D7C9A9B2F887B9")
    
@Override
    public void inflate(Resources r, XmlPullParser parser,
            AttributeSet attrs)
            throws XmlPullParserException, IOException {
        
        final GradientState st = mGradientState;
        
        TypedArray a = r.obtainAttributes(attrs,
                com.android.internal.R.styleable.GradientDrawable);

        super.inflateWithAttributes(r, parser, a,
                com.android.internal.R.styleable.GradientDrawable_visible);
        
        int shapeType = a.getInt(
                com.android.internal.R.styleable.GradientDrawable_shape, RECTANGLE);
        boolean dither = a.getBoolean(
                com.android.internal.R.styleable.GradientDrawable_dither, false);
        
        if (shapeType == RING) {
            st.mInnerRadius = a.getDimensionPixelSize(
                    com.android.internal.R.styleable.GradientDrawable_innerRadius, -1);
            if (st.mInnerRadius == -1) {
                st.mInnerRadiusRatio = a.getFloat(
                        com.android.internal.R.styleable.GradientDrawable_innerRadiusRatio, 3.0f);
            }
            st.mThickness = a.getDimensionPixelSize(
                    com.android.internal.R.styleable.GradientDrawable_thickness, -1);
            if (st.mThickness == -1) {
                st.mThicknessRatio = a.getFloat(
                        com.android.internal.R.styleable.GradientDrawable_thicknessRatio, 9.0f);
            }
            st.mUseLevelForShape = a.getBoolean(
                    com.android.internal.R.styleable.GradientDrawable_useLevel, true);
        }
        
        a.recycle();
        
        setShape(shapeType);
        setDither(dither);

        int type;

        final int innerDepth = parser.getDepth() + 1;
        int depth;
        while ((type=parser.next()) != XmlPullParser.END_DOCUMENT
               && ((depth=parser.getDepth()) >= innerDepth
                       || type != XmlPullParser.END_TAG)) {
            if (type != XmlPullParser.START_TAG) {
                continue;
            }

            if (depth > innerDepth) {
                continue;
            }
            
            String name = parser.getName();
            
            if (name.equals("size")) {
                a = r.obtainAttributes(attrs,
                        com.android.internal.R.styleable.GradientDrawableSize);
                int width = a.getDimensionPixelSize(
                        com.android.internal.R.styleable.GradientDrawableSize_width, -1);
                int height = a.getDimensionPixelSize(
                        com.android.internal.R.styleable.GradientDrawableSize_height, -1);
                a.recycle();
                setSize(width, height);
            } else if (name.equals("gradient")) {
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

                if (gradientType == LINEAR_GRADIENT) {
                    int angle = (int)a.getFloat(
                            com.android.internal.R.styleable.GradientDrawableGradient_angle, 0);
                    angle %= 360;
                    if (angle % 45 != 0) {
                        throw new XmlPullParserException(a.getPositionDescription()
                                + "<gradient> tag requires 'angle' attribute to "
                                + "be a multiple of 45");
                    }

                    switch (angle) {
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
                } else {
                    TypedValue tv = a.peekValue(
                            com.android.internal.R.styleable.GradientDrawableGradient_gradientRadius);
                    if (tv != null) {
                        boolean radiusRel = tv.type == TypedValue.TYPE_FRACTION;
                        st.mGradientRadius = radiusRel ?
                                tv.getFraction(1.0f, 1.0f) : tv.getFloat();
                    } else if (gradientType == RADIAL_GRADIENT) {
                        throw new XmlPullParserException(
                                a.getPositionDescription()
                                + "<gradient> tag requires 'gradientRadius' "
                                + "attribute with radial type");
                    }
                }

                a.recycle();

                if (hasCenterColor) {
                    st.mColors = new int[3];
                    st.mColors[0] = startColor;
                    st.mColors[1] = centerColor;
                    st.mColors[2] = endColor;
                    
                    st.mPositions = new float[3];
                    st.mPositions[0] = 0.0f;
                    // Since 0.5f is default value, try to take the one that isn't 0.5f
                    st.mPositions[1] = st.mCenterX != 0.5f ? st.mCenterX : st.mCenterY;
                    st.mPositions[2] = 1f;
                } else {
                    st.mColors = new int[2];
                    st.mColors[0] = startColor;
                    st.mColors[1] = endColor;
                }
                
            } else if (name.equals("solid")) {
                a = r.obtainAttributes(attrs,
                        com.android.internal.R.styleable.GradientDrawableSolid);
                int argb = a.getColor(
                        com.android.internal.R.styleable.GradientDrawableSolid_color, 0);
                a.recycle();
                setColor(argb);
            } else if (name.equals("stroke")) {
                a = r.obtainAttributes(attrs,
                        com.android.internal.R.styleable.GradientDrawableStroke);
                int width = a.getDimensionPixelSize(
                        com.android.internal.R.styleable.GradientDrawableStroke_width, 0);
                int color = a.getColor(
                        com.android.internal.R.styleable.GradientDrawableStroke_color, 0);
                float dashWidth = a.getDimension(
                        com.android.internal.R.styleable.GradientDrawableStroke_dashWidth, 0);
                if (dashWidth != 0.0f) {
                    float dashGap = a.getDimension(
                            com.android.internal.R.styleable.GradientDrawableStroke_dashGap, 0);
                    setStroke(width, color, dashWidth, dashGap);
                } else {
                    setStroke(width, color);
                }
                a.recycle();
            } else if (name.equals("corners")) {
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
                if (topLeftRadius != radius || topRightRadius != radius ||
                        bottomLeftRadius != radius || bottomRightRadius != radius) {
                    // The corner radii are specified in clockwise order (see Path.addRoundRect())
                    setCornerRadii(new float[] {
                            topLeftRadius, topLeftRadius,
                            topRightRadius, topRightRadius,
                            bottomRightRadius, bottomRightRadius,
                            bottomLeftRadius, bottomLeftRadius
                    });
                }
                a.recycle();
            } else if (name.equals("padding")) {
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
            } else {
                Log.w("drawable", "Bad element under <shape>: " + name);
            }
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:16.673 -0500", hash_original_method = "312782D78F9C32949C3B038C307C5C9C", hash_generated_method = "BF3E96399D536081C4FE7FF3F644DEBA")
    
@Override
    public int getIntrinsicWidth() {
        return mGradientState.mWidth;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:16.675 -0500", hash_original_method = "A19A1B01925414A773BB5AE9FBB4894A", hash_generated_method = "414190BA159EB48B9D4905B397A68CAB")
    
@Override
    public int getIntrinsicHeight() {
        return mGradientState.mHeight;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:16.677 -0500", hash_original_method = "DD96D81CE576A9B12867099611327831", hash_generated_method = "3D4690C3650C7ADE0B09533643749479")
    
@Override
    public ConstantState getConstantState() {
        mGradientState.mChangingConfigurations = getChangingConfigurations();
        return mGradientState;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:16.680 -0500", hash_original_method = "D4EF431721248824E2CCEA5FA3C5FD74", hash_generated_method = "EB30752D721AD486E48093CEBADB7EC3")
    
@Override
    public Drawable mutate() {
        if (!mMutated && super.mutate() == this) {
            mGradientState = new GradientState(mGradientState);
            initializeWithState(mGradientState);
            mMutated = true;
        }
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:16.791 -0500", hash_original_method = "7FA7686AE1E8AEF57BBE0E6293CFBCA1", hash_generated_method = "B7C718878678B18EB319A33B1A463C32")
    
private void initializeWithState(GradientState state) {
        if (state.mHasSolidColor) {
            mFillPaint.setColor(state.mSolidColor);
        }
        mPadding = state.mPadding;
        if (state.mStrokeWidth >= 0) {
            mStrokePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
            mStrokePaint.setStyle(Paint.Style.STROKE);
            mStrokePaint.setStrokeWidth(state.mStrokeWidth);
            mStrokePaint.setColor(state.mStrokeColor);

            if (state.mStrokeDashWidth != 0.0f) {
                DashPathEffect e = new DashPathEffect(
                        new float[] { state.mStrokeDashWidth, state.mStrokeDashGap }, 0);
                mStrokePaint.setPathEffect(e);
            }
        }
    }
}

