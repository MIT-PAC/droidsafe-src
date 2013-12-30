package android.graphics.drawable;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;





public class LayerDrawable extends Drawable implements Drawable.Callback {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:18.112 -0500", hash_original_field = "053037057B7FC4B2D43393B0DA597B94", hash_generated_field = "053037057B7FC4B2D43393B0DA597B94")

    LayerState mLayerState;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:18.114 -0500", hash_original_field = "01AD0D43DD2C09AE8BD7BD5731AC2A88", hash_generated_field = "DBD2988EAF133D76032F3EAD1CE10F00")


    private int mOpacityOverride = PixelFormat.UNKNOWN;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:18.116 -0500", hash_original_field = "C204BABD636FCC7C56D0C24D74A6DA64", hash_generated_field = "7D03B5A878C9FF91EB46A7111D526D76")

    private int[] mPaddingL;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:18.118 -0500", hash_original_field = "6B6C1DB65DA8B133EF23CBA863019657", hash_generated_field = "14F9B3A237223751479C6D3D809F2002")

    private int[] mPaddingT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:18.120 -0500", hash_original_field = "B0D1CD502B4443FBB3984F86F74C376C", hash_generated_field = "9C76E5B4161411C12A357F3E6012EEB7")

    private int[] mPaddingR;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:18.123 -0500", hash_original_field = "7001D27D0483E230D0A8A7BF282CA556", hash_generated_field = "9C3BE8A516D526DA1E4DFBF1EA68DB1D")

    private int[] mPaddingB;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:18.125 -0500", hash_original_field = "C53D3ED3F7CBB30122A6D714A9203A7D", hash_generated_field = "570061BA9CB059462550E9BCCD2A0735")


    private final Rect mTmpRect = new Rect();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:18.128 -0500", hash_original_field = "B15C308E96D0EEBD27CFE369FA349C15", hash_generated_field = "5CA5A1EF3CAA45117BCACBC34EF05952")

    private boolean mMutated;

    /**
     * Create a new layer drawable with the list of specified layers.
     *
     * @param layers A list of drawables to use as layers in this new drawable.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:18.130 -0500", hash_original_method = "45431E38A045C0C983A2E1F24B9ACFC3", hash_generated_method = "75FF6DCE1A5016BCF3AE6BCA9B4BE9D0")
    
public LayerDrawable(Drawable[] layers) {
        this(layers, null);
    }

    /**
     * Create a new layer drawable with the specified list of layers and the specified
     * constant state.
     *
     * @param layers The list of layers to add to this drawable.
     * @param state The constant drawable state.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:18.132 -0500", hash_original_method = "FF485081EB7D7D498FB9DCE337B88F15", hash_generated_method = "FF485081EB7D7D498FB9DCE337B88F15")
    
LayerDrawable(Drawable[] layers, LayerState state) {
        this(state, null);
        int length = layers.length;
        ChildDrawable[] r = new ChildDrawable[length];

        for (int i = 0; i < length; i++) {
            r[i] = new ChildDrawable();
            r[i].mDrawable = layers[i];
            layers[i].setCallback(this);
            mLayerState.mChildrenChangingConfigurations |= layers[i].getChangingConfigurations();
        }
        mLayerState.mNum = length;
        mLayerState.mChildren = r;

        ensurePadding();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:18.135 -0500", hash_original_method = "E2A4F408D4F72AC6B7199B314E863E72", hash_generated_method = "E2A4F408D4F72AC6B7199B314E863E72")
    
LayerDrawable() {
        this((LayerState) null, null);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:18.137 -0500", hash_original_method = "026CAD40EA728EE5D396C83F5E4D2B2B", hash_generated_method = "026CAD40EA728EE5D396C83F5E4D2B2B")
    
LayerDrawable(LayerState state, Resources res) {
        LayerState as = createConstantState(state, res);
        mLayerState = as;
        if (as.mNum > 0) {
            ensurePadding();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:18.139 -0500", hash_original_method = "7FB89ACAD944F734BBC3DF72F4EDEEB2", hash_generated_method = "7FB89ACAD944F734BBC3DF72F4EDEEB2")
    
LayerState createConstantState(LayerState state, Resources res) {
        return new LayerState(state, this, res);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:18.143 -0500", hash_original_method = "A154F132E6CF56E7598B71E5310AFACF", hash_generated_method = "9CF89ED2CB0D24DFC3D1CA6A7B0EB6DA")
    
@Override
    public void inflate(Resources r, XmlPullParser parser, AttributeSet attrs)
            throws XmlPullParserException, IOException {
        super.inflate(r, parser, attrs);

        int type;

        TypedArray a = r.obtainAttributes(attrs, com.android.internal.R.styleable.LayerDrawable);

        mOpacityOverride = a.getInt(com.android.internal.R.styleable.LayerDrawable_opacity,
                PixelFormat.UNKNOWN);

        a.recycle();

        final int innerDepth = parser.getDepth() + 1;
        int depth;
        while ((type = parser.next()) != XmlPullParser.END_DOCUMENT
                && ((depth = parser.getDepth()) >= innerDepth || type != XmlPullParser.END_TAG)) {
            if (type != XmlPullParser.START_TAG) {
                continue;
            }

            if (depth > innerDepth || !parser.getName().equals("item")) {
                continue;
            }

            a = r.obtainAttributes(attrs,
                    com.android.internal.R.styleable.LayerDrawableItem);

            int left = a.getDimensionPixelOffset(
                    com.android.internal.R.styleable.LayerDrawableItem_left, 0);
            int top = a.getDimensionPixelOffset(
                    com.android.internal.R.styleable.LayerDrawableItem_top, 0);
            int right = a.getDimensionPixelOffset(
                    com.android.internal.R.styleable.LayerDrawableItem_right, 0);
            int bottom = a.getDimensionPixelOffset(
                    com.android.internal.R.styleable.LayerDrawableItem_bottom, 0);
            int drawableRes = a.getResourceId(
                    com.android.internal.R.styleable.LayerDrawableItem_drawable, 0);
            int id = a.getResourceId(com.android.internal.R.styleable.LayerDrawableItem_id,
                    View.NO_ID);

            a.recycle();

            Drawable dr;
            if (drawableRes != 0) {
                dr = r.getDrawable(drawableRes);
            } else {
                while ((type = parser.next()) == XmlPullParser.TEXT) {
                }
                if (type != XmlPullParser.START_TAG) {
                    throw new XmlPullParserException(parser.getPositionDescription()
                            + ": <item> tag requires a 'drawable' attribute or "
                            + "child tag defining a drawable");
                }
                dr = Drawable.createFromXmlInner(r, parser, attrs);
            }

            addLayer(dr, id, left, top, right, bottom);
        }

        ensurePadding();
        onStateChange(getState());
    }

    /**
     * Add a new layer to this drawable. The new layer is identified by an id.
     *
     * @param layer The drawable to add as a layer.
     * @param id The id of the new layer.
     * @param left The left padding of the new layer.
     * @param top The top padding of the new layer.
     * @param right The right padding of the new layer.
     * @param bottom The bottom padding of the new layer.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:18.146 -0500", hash_original_method = "F6995F9609496F6742CAB01EE3CD1860", hash_generated_method = "8D3F77CA2CB67D6333121CEA01E9029F")
    
private void addLayer(Drawable layer, int id, int left, int top, int right, int bottom) {
        final LayerState st = mLayerState;
        int N = st.mChildren != null ? st.mChildren.length : 0;
        int i = st.mNum;
        if (i >= N) {
            ChildDrawable[] nu = new ChildDrawable[N + 10];
            if (i > 0) {
                System.arraycopy(st.mChildren, 0, nu, 0, i);
            }
            st.mChildren = nu;
        }

        mLayerState.mChildrenChangingConfigurations |= layer.getChangingConfigurations();
        
        ChildDrawable childDrawable = new ChildDrawable();
        st.mChildren[i] = childDrawable;
        childDrawable.mId = id;
        childDrawable.mDrawable = layer;
        childDrawable.mInsetL = left;
        childDrawable.mInsetT = top;
        childDrawable.mInsetR = right;
        childDrawable.mInsetB = bottom;
        st.mNum++;

        layer.setCallback(this);
    }

    /**
     * Look for a layer with the given id, and returns its {@link Drawable}.
     *
     * @param id The layer ID to search for.
     * @return The {@link Drawable} of the layer that has the given id in the hierarchy or null.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:18.148 -0500", hash_original_method = "C91DA5E408896EB69ADE8640201298D6", hash_generated_method = "F0AB868690D5FBC90D2305D8541BA51B")
    
public Drawable findDrawableByLayerId(int id) {
        final ChildDrawable[] layers = mLayerState.mChildren;
        
        for (int i = mLayerState.mNum - 1; i >= 0; i--) {
            if (layers[i].mId == id) {
                return layers[i].mDrawable;
            }
        }
        
        return null;
    }
    
    /**
     * Sets the ID of a layer.
     * 
     * @param index The index of the layer which will received the ID. 
     * @param id The ID to assign to the layer.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:18.150 -0500", hash_original_method = "BFB89C99582071313F846F1C811CB3F0", hash_generated_method = "5D5606E7F0997E214CF86524881F3A03")
    
public void setId(int index, int id) {
        mLayerState.mChildren[index].mId = id;
    }
    
    /**
     * Returns the number of layers contained within this.
     * @return The number of layers.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:18.152 -0500", hash_original_method = "A86CD78FFBAB297497BF089506C91B59", hash_generated_method = "6075AA902777F095317F3A14EA5716F3")
    
public int getNumberOfLayers() {
        return mLayerState.mNum;
    }

    /**
     * Returns the drawable at the specified layer index.
     *
     * @param index The layer index of the drawable to retrieve.
     *
     * @return The {@link android.graphics.drawable.Drawable} at the specified layer index.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:18.154 -0500", hash_original_method = "34EED4495029B4FCBDB042C377184EB5", hash_generated_method = "63F0399A05DCC998434F64635EAB029F")
    
public Drawable getDrawable(int index) {
        return mLayerState.mChildren[index].mDrawable;
    }

    /**
     * Returns the id of the specified layer.
     *
     * @param index The index of the layer.
     *
     * @return The id of the layer or {@link android.view.View#NO_ID} if the layer has no id. 
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:18.157 -0500", hash_original_method = "AA527FDBA3D8F60360C6FC80FEEC74D7", hash_generated_method = "AB61A0021DDDEA00578315114A44755B")
    
public int getId(int index) {
        return mLayerState.mChildren[index].mId;
    }
    
    /**
     * Sets (or replaces) the {@link Drawable} for the layer with the given id.
     * 
     * @param id The layer ID to search for.
     * @param drawable The replacement {@link Drawable}.
     * @return Whether the {@link Drawable} was replaced (could return false if
     *         the id was not found).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:18.160 -0500", hash_original_method = "6F9F1421DDD84B6DEFE7740341A590C2", hash_generated_method = "BED320522FE1FDE8CCB4215EDBE0A90A")
    
public boolean setDrawableByLayerId(int id, Drawable drawable) {
        final ChildDrawable[] layers = mLayerState.mChildren;
        
        for (int i = mLayerState.mNum - 1; i >= 0; i--) {
            if (layers[i].mId == id) {
                if (layers[i].mDrawable != null) {
                    if (drawable != null) {
                        Rect bounds = layers[i].mDrawable.getBounds();
                        drawable.setBounds(bounds);
                    }
                    layers[i].mDrawable.setCallback(null);
                }
                if (drawable != null) {
                    drawable.setCallback(this);
                }
                layers[i].mDrawable = drawable;
                return true;
            }
        }
        
        return false;
    }
    
    /** Specify modifiers to the bounds for the drawable[index].
        left += l
        top += t;
        right -= r;
        bottom -= b;
    */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:18.162 -0500", hash_original_method = "F7297B48CD52F9107957E141DF7BCBF2", hash_generated_method = "629125666B83D467EA5503D3811D552D")
    
public void setLayerInset(int index, int l, int t, int r, int b) {
        ChildDrawable childDrawable = mLayerState.mChildren[index];
        childDrawable.mInsetL = l;
        childDrawable.mInsetT = t;
        childDrawable.mInsetR = r;
        childDrawable.mInsetB = b;
    }

    // overrides from Drawable.Callback

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:18.164 -0500", hash_original_method = "289E4B14FC4BAEE8FBED5C03A1D9B634", hash_generated_method = "B516B8CE176B97B58ED719463429883C")
    
public void invalidateDrawable(Drawable who) {
        final Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:18.166 -0500", hash_original_method = "A01CAF97CFFAA14450A9600E14E88C8D", hash_generated_method = "D916965E7ED92878F703EBB8407A3435")
    
public void scheduleDrawable(Drawable who, Runnable what, long when) {
        final Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, what, when);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:18.169 -0500", hash_original_method = "CA144C86313E3C1A3DC044F014305D8E", hash_generated_method = "1F0141991B8511B6AE50284469FB44D8")
    
public void unscheduleDrawable(Drawable who, Runnable what) {
        final Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, what);
        }
    }

    // overrides from Drawable

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:18.171 -0500", hash_original_method = "90444F7F92DF97CE38686D7CB679E4B0", hash_generated_method = "6D59DB54A86CDD131CE3ECD34F13AE43")
    
@Override
    public void draw(Canvas canvas) {
        final ChildDrawable[] array = mLayerState.mChildren;
        final int N = mLayerState.mNum;
        for (int i=0; i<N; i++) {
            array[i].mDrawable.draw(canvas);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:18.173 -0500", hash_original_method = "DA9EE8A6D973B1FAC6E24B2DB8F8E9C8", hash_generated_method = "AB968D1D931439AC785AFD120BEC45F2")
    
@Override
    public int getChangingConfigurations() {
        return super.getChangingConfigurations()
                | mLayerState.mChangingConfigurations
                | mLayerState.mChildrenChangingConfigurations;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:18.176 -0500", hash_original_method = "3512A730E5F476B43F9CED59A7F53410", hash_generated_method = "B355A90F1DC2F2DAF00C4A0CF9E00F91")
    
@Override
    public boolean getPadding(Rect padding) {
        // Arbitrarily get the padding from the first image.
        // Technically we should maybe do something more intelligent,
        // like take the max padding of all the images.
        padding.left = 0;
        padding.top = 0;
        padding.right = 0;
        padding.bottom = 0;
        final ChildDrawable[] array = mLayerState.mChildren;
        final int N = mLayerState.mNum;
        for (int i=0; i<N; i++) {
            reapplyPadding(i, array[i]);
            padding.left += mPaddingL[i];
            padding.top += mPaddingT[i];
            padding.right += mPaddingR[i];
            padding.bottom += mPaddingB[i];
        }
        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:18.178 -0500", hash_original_method = "DD7D852A8B2359532D654CFF5E5A109F", hash_generated_method = "EF98C94492141DB8F0E1AA82D29618F2")
    
@Override
    public boolean setVisible(boolean visible, boolean restart) {
        boolean changed = super.setVisible(visible, restart);
        final ChildDrawable[] array = mLayerState.mChildren;
        final int N = mLayerState.mNum;
        for (int i=0; i<N; i++) {
            array[i].mDrawable.setVisible(visible, restart);
        }
        return changed;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:18.180 -0500", hash_original_method = "8B5179F0E6CCC56A1CD26C355EB4BEE6", hash_generated_method = "D71EE13E8525C4D8EBCE0262ED861040")
    
@Override
    public void setDither(boolean dither) {
        final ChildDrawable[] array = mLayerState.mChildren;
        final int N = mLayerState.mNum;
        for (int i=0; i<N; i++) {
            array[i].mDrawable.setDither(dither);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:18.182 -0500", hash_original_method = "A4F4B2E3C1F4B490E6EEA73C8E0E0B9C", hash_generated_method = "DE414C820E3FF847AA7572254924F770")
    
@Override
    public void setAlpha(int alpha) {
        final ChildDrawable[] array = mLayerState.mChildren;
        final int N = mLayerState.mNum;
        for (int i=0; i<N; i++) {
            array[i].mDrawable.setAlpha(alpha);
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:18.185 -0500", hash_original_method = "6285AEA72EA88CCBF849BD62BDD654E0", hash_generated_method = "45EDCCBE76A45D8343D86DD3B2A6885E")
    
@Override
    public void setColorFilter(ColorFilter cf) {
        final ChildDrawable[] array = mLayerState.mChildren;
        final int N = mLayerState.mNum;
        for (int i=0; i<N; i++) {
            array[i].mDrawable.setColorFilter(cf);
        }
    }

    /**
     * Sets the opacity of this drawable directly, instead of collecting the states from
     * the layers
     *
     * @param opacity The opacity to use, or {@link PixelFormat#UNKNOWN PixelFormat.UNKNOWN}
     * for the default behavior
     *
     * @see PixelFormat#UNKNOWN
     * @see PixelFormat#TRANSLUCENT
     * @see PixelFormat#TRANSPARENT
     * @see PixelFormat#OPAQUE
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:18.187 -0500", hash_original_method = "3DEB6D6A50B9757568C5AA3089CD04F9", hash_generated_method = "04BAF52D44539A76C205D088B7BC3EBC")
    
public void setOpacity(int opacity) {
        mOpacityOverride = opacity;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:18.190 -0500", hash_original_method = "0508714C8593107EE12E4CBB1654E530", hash_generated_method = "B07E04571C348AF9B4DB483345715476")
    
@Override
    public int getOpacity() {
        if (mOpacityOverride != PixelFormat.UNKNOWN) {
            return mOpacityOverride;
        }
        return mLayerState.getOpacity();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:18.193 -0500", hash_original_method = "A7862898530225600FCD0A08ADBB8B8E", hash_generated_method = "403D3908D5880403065F68ACB24DDE0D")
    
@Override
    public boolean isStateful() {
        return mLayerState.isStateful();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:18.195 -0500", hash_original_method = "60327578E5414A54A8EE74C8FEF7053B", hash_generated_method = "950F7584DA930176C0DCA911DBD17FAE")
    
@Override
    protected boolean onStateChange(int[] state) {
        final ChildDrawable[] array = mLayerState.mChildren;
        final int N = mLayerState.mNum;
        boolean paddingChanged = false;
        boolean changed = false;
        for (int i=0; i<N; i++) {
            final ChildDrawable r = array[i];
            if (r.mDrawable.setState(state)) {
                changed = true;
            }
            if (reapplyPadding(i, r)) {
                paddingChanged = true;
            }
        }
        if (paddingChanged) {
            onBoundsChange(getBounds());
        }
        return changed;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:18.198 -0500", hash_original_method = "195FB5A6CB4D5D3918E98BB126BE1FA4", hash_generated_method = "DC5531E05280D43D7BAFE1657C740163")
    
@Override
    protected boolean onLevelChange(int level) {
        final ChildDrawable[] array = mLayerState.mChildren;
        final int N = mLayerState.mNum;
        boolean paddingChanged = false;
        boolean changed = false;
        for (int i=0; i<N; i++) {
            final ChildDrawable r = array[i];
            if (r.mDrawable.setLevel(level)) {
                changed = true;
            }
            if (reapplyPadding(i, r)) {
                paddingChanged = true;
            }
        }
        if (paddingChanged) {
            onBoundsChange(getBounds());
        }
        return changed;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:18.200 -0500", hash_original_method = "7AEE775ACF9989A4B743B4884BF6DFAF", hash_generated_method = "B4B36DB0365A7F5A5A339B806C20A6D8")
    
@Override
    protected void onBoundsChange(Rect bounds) {
        final ChildDrawable[] array = mLayerState.mChildren;
        final int N = mLayerState.mNum;
        int padL=0, padT=0, padR=0, padB=0;
        for (int i=0; i<N; i++) {
            final ChildDrawable r = array[i];
            r.mDrawable.setBounds(bounds.left + r.mInsetL + padL,
                                  bounds.top + r.mInsetT + padT,
                                  bounds.right - r.mInsetR - padR,
                                  bounds.bottom - r.mInsetB - padB);
            padL += mPaddingL[i];
            padR += mPaddingR[i];
            padT += mPaddingT[i];
            padB += mPaddingB[i];
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:18.203 -0500", hash_original_method = "3C77AAA6434E318933C50BFE3151E79D", hash_generated_method = "259B620EE8AED33DFA3925B1BB46060E")
    
@Override
    public int getIntrinsicWidth() {
        int width = -1;
        final ChildDrawable[] array = mLayerState.mChildren;
        final int N = mLayerState.mNum;
        int padL=0, padR=0;
        for (int i=0; i<N; i++) {
            final ChildDrawable r = array[i];
            int w = r.mDrawable.getIntrinsicWidth()
                  + r.mInsetL + r.mInsetR + padL + padR;
            if (w > width) {
                width = w;
            }
            padL += mPaddingL[i];
            padR += mPaddingR[i];
        }
        return width;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:18.205 -0500", hash_original_method = "74944E4C19D1A88AACA0D7D60A83587A", hash_generated_method = "BE4B2C547B0406AC0266150D9096942D")
    
@Override
    public int getIntrinsicHeight() {
        int height = -1;
        final ChildDrawable[] array = mLayerState.mChildren;
        final int N = mLayerState.mNum;
        int padT=0, padB=0;
        for (int i=0; i<N; i++) {
            final ChildDrawable r = array[i];
            int h = r.mDrawable.getIntrinsicHeight() + r.mInsetT + r.mInsetB + + padT + padB;
            if (h > height) {
                height = h;
            }
            padT += mPaddingT[i];
            padB += mPaddingB[i];
        }
        return height;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:18.208 -0500", hash_original_method = "41F739441798A70C5E037E0F4FC43A10", hash_generated_method = "A50533F4C320A1259CBE693F67A3A88C")
    
private boolean reapplyPadding(int i, ChildDrawable r) {
        final Rect rect = mTmpRect;
        r.mDrawable.getPadding(rect);
        if (rect.left != mPaddingL[i] || rect.top != mPaddingT[i] ||
                rect.right != mPaddingR[i] || rect.bottom != mPaddingB[i]) {
            mPaddingL[i] = rect.left;
            mPaddingT[i] = rect.top;
            mPaddingR[i] = rect.right;
            mPaddingB[i] = rect.bottom;
            return true;
        }
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:18.210 -0500", hash_original_method = "6FB87F17A7189073B9E72073B203E52E", hash_generated_method = "9136F4D82C867E94BDEC47BFDDDF698F")
    
private void ensurePadding() {
        final int N = mLayerState.mNum;
        if (mPaddingL != null && mPaddingL.length >= N) {
            return;
        }
        mPaddingL = new int[N];
        mPaddingT = new int[N];
        mPaddingR = new int[N];
        mPaddingB = new int[N];
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:18.212 -0500", hash_original_method = "42E9B0CF062F666EDFF40D08B19E7027", hash_generated_method = "C22E6453005E30083BA552D85EBB08B8")
    
@Override
    public ConstantState getConstantState() {
        if (mLayerState.canConstantState()) {
            mLayerState.mChangingConfigurations = getChangingConfigurations();
            return mLayerState;
        }
        return null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:18.215 -0500", hash_original_method = "B6649BA0234C5F68B98BE9A7636194EF", hash_generated_method = "522ADA79AC181D272CA0D6B26EBF3F0B")
    
@Override
    public Drawable mutate() {
        if (!mMutated && super.mutate() == this) {
            final ChildDrawable[] array = mLayerState.mChildren;
            final int N = mLayerState.mNum;
            for (int i = 0; i < N; i++) {
                array[i].mDrawable.mutate();
            }
            mMutated = true;
        }
        return this;
    }

    
    static class ChildDrawable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:18.218 -0500", hash_original_field = "38BA53DD394F85639C99ED8E666FF8FB", hash_generated_field = "36D39E5803890ED250A80FAD100C4ED7")

        public Drawable mDrawable;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.214 -0400", hash_original_field = "84CB0C1DC38731A850F792E2FDB6B39B", hash_generated_field = "41EDDF00F18395AB4E75D54F56DCEAD6")

        public int mInsetL;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.214 -0400", hash_original_field = "FE98DF02B3531CCEEC8254EA7A40D8C2", hash_generated_field = "B7AF8366A6A319CDAA60A9C0D750F631")

        public int mInsetT;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.214 -0400", hash_original_field = "98714B51BF834824DA4A4A1ACF3D4447", hash_generated_field = "EC3C187375874F66EE15413DF92F4E1E")

        public int mInsetR;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.214 -0400", hash_original_field = "10B9A7B0EF30FDBEDF74FE05E0046827", hash_generated_field = "29277012246F0EA1CDF311942F6EA725")

        public int mInsetB;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:18.222 -0500", hash_original_field = "9F66E723E60E4F10157FDA7C23C67293", hash_generated_field = "47CDACD56606F02DFA218FC210EFC0FF")

        public int mId;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.214 -0400", hash_original_method = "6CD909B986D24A0F6BAFA410E280EBB3", hash_generated_method = "6CD909B986D24A0F6BAFA410E280EBB3")
        public ChildDrawable ()
        {
            //Synthesized constructor
        }


    }


    
    static class LayerState extends ConstantState {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:18.225 -0500", hash_original_field = "95F99CF2E70DB79AD069A36B506646F2", hash_generated_field = "95F99CF2E70DB79AD069A36B506646F2")

        int mNum;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:18.227 -0500", hash_original_field = "5D63B0C69B8E94415B4820B44C747438", hash_generated_field = "5D63B0C69B8E94415B4820B44C747438")

        ChildDrawable[] mChildren;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:18.230 -0500", hash_original_field = "9BFAF00848476277D36D9BA586984BA7", hash_generated_field = "9BFAF00848476277D36D9BA586984BA7")


        int mChangingConfigurations;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:18.232 -0500", hash_original_field = "E8F7332658D4B8911B8427F9E33AC9BD", hash_generated_field = "E8F7332658D4B8911B8427F9E33AC9BD")

        int mChildrenChangingConfigurations;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:18.234 -0500", hash_original_field = "0E129F2B3EAED33E8435CEB0AF66A927", hash_generated_field = "A98F79115AB3FA98F1F7245A604A5EC2")

        
        private boolean mHaveOpacity = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:18.236 -0500", hash_original_field = "F94EB6B55A1DFE34A922350D13706418", hash_generated_field = "05E7E4BE80B060037CF88AC66652FF58")

        private int mOpacity;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:18.239 -0500", hash_original_field = "788B667F97461387E15CDD9C2D78DA89", hash_generated_field = "C74F5EDB4E2A4B07698A864146958E40")


        private boolean mHaveStateful = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:18.241 -0500", hash_original_field = "6CBAA9F8E31FD09725242CB8EF367A38", hash_generated_field = "6747C1011A591FA368B1D4C99D94E670")

        private boolean mStateful;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:18.243 -0500", hash_original_field = "04605894B57F7B3414AF620BF4AC040E", hash_generated_field = "63D49323436A33301C0DA6EDF88627FF")


        private boolean mCheckedConstantState;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:18.245 -0500", hash_original_field = "09212A3A30B7E6D48DEECC4F4639CCBC", hash_generated_field = "F62F8D22C4EDE8B8E63C376677BD915C")

        private boolean mCanConstantState;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:18.249 -0500", hash_original_method = "BD826615A7A8424D072A11138F67C8D8", hash_generated_method = "BD826615A7A8424D072A11138F67C8D8")
        
LayerState(LayerState orig, LayerDrawable owner, Resources res) {
            if (orig != null) {
                final ChildDrawable[] origChildDrawable = orig.mChildren;
                final int N = orig.mNum;

                mNum = N;
                mChildren = new ChildDrawable[N];

                mChangingConfigurations = orig.mChangingConfigurations;
                mChildrenChangingConfigurations = orig.mChildrenChangingConfigurations;
                
                for (int i = 0; i < N; i++) {
                    final ChildDrawable r = mChildren[i] = new ChildDrawable();
                    final ChildDrawable or = origChildDrawable[i];
                    if (res != null) {
                        r.mDrawable = or.mDrawable.getConstantState().newDrawable(res);
                    } else {
                        r.mDrawable = or.mDrawable.getConstantState().newDrawable();
                    }
                    r.mDrawable.setCallback(owner);
                    r.mInsetL = or.mInsetL;
                    r.mInsetT = or.mInsetT;
                    r.mInsetR = or.mInsetR;
                    r.mInsetB = or.mInsetB;
                    r.mId = or.mId;
                }

                mHaveOpacity = orig.mHaveOpacity;
                mOpacity = orig.mOpacity;
                mHaveStateful = orig.mHaveStateful;
                mStateful = orig.mStateful;
                mCheckedConstantState = mCanConstantState = true;
            } else {
                mNum = 0;
                mChildren = null;
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:18.252 -0500", hash_original_method = "4F2E1E1D85BE3BBCABDE93BB1C6F5E02", hash_generated_method = "D1A9960FBBEFFD55F5C974C4CCAD850B")
        
@Override
        public Drawable newDrawable() {
            return new LayerDrawable(this, null);
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:18.255 -0500", hash_original_method = "40E045186798A3567910482DC0B43DC7", hash_generated_method = "117FD3BC1FFA15306504A22188383889")
        
@Override
        public Drawable newDrawable(Resources res) {
            return new LayerDrawable(this, res);
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:18.257 -0500", hash_original_method = "9E7D7C67EAC365FF19BD4971762612A5", hash_generated_method = "3AB30668ED270F2EDF2E0129C706FE4D")
        
@Override
        public int getChangingConfigurations() {
            return mChangingConfigurations;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:18.259 -0500", hash_original_method = "C863EE1513D5FAC46B3A54079EE22BC7", hash_generated_method = "37BB08599CE71D4B2EBD87DF45DB7F82")
        
public final int getOpacity() {
            if (mHaveOpacity) {
                return mOpacity;
            }

            final int N = mNum;
            int op = N > 0 ? mChildren[0].mDrawable.getOpacity() : PixelFormat.TRANSPARENT;
            for (int i = 1; i < N; i++) {
                op = Drawable.resolveOpacity(op, mChildren[i].mDrawable.getOpacity());
            }
            mOpacity = op;
            mHaveOpacity = true;
            return op;
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:18.262 -0500", hash_original_method = "302772CF3A9A555DFD32DC83A81CA17A", hash_generated_method = "9431995350C23811268CEB675B90FB58")
        
public final boolean isStateful() {
            if (mHaveStateful) {
                return mStateful;
            }
            
            boolean stateful = false;
            final int N = mNum;
            for (int i = 0; i < N; i++) {
                if (mChildren[i].mDrawable.isStateful()) {
                    stateful = true;
                    break;
                }
            }
            
            mStateful = stateful;
            mHaveStateful = true;
            return stateful;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:18.265 -0500", hash_original_method = "08014AA1073210728E3D3AA9FAF026EA", hash_generated_method = "815083CAC2DA6EB16F881C670B60542B")
        
public synchronized boolean canConstantState() {
            if (!mCheckedConstantState && mChildren != null) {
                mCanConstantState = true;
                final int N = mNum;
                for (int i=0; i<N; i++) {
                    if (mChildren[i].mDrawable.getConstantState() == null) {
                        mCanConstantState = false;
                        break;
                    }
                }
                mCheckedConstantState = true;
            }

            return mCanConstantState;
        }

        
    }


    
}

