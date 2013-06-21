package android.graphics.drawable;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
import java.io.IOException;

public class LayerDrawable extends Drawable implements Drawable.Callback {
    LayerState mLayerState;
    private int mOpacityOverride = PixelFormat.UNKNOWN;
    private int[] mPaddingL;
    private int[] mPaddingT;
    private int[] mPaddingR;
    private int[] mPaddingB;
    private Rect mTmpRect = new Rect();
    private boolean mMutated;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.445 -0400", hash_original_method = "45431E38A045C0C983A2E1F24B9ACFC3", hash_generated_method = "912388DEEDDF3D16D96B6CC372A2F502")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public LayerDrawable(Drawable[] layers) {
        this(layers, null);
        dsTaint.addTaint(layers[0].dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.446 -0400", hash_original_method = "FF485081EB7D7D498FB9DCE337B88F15", hash_generated_method = "59FB897ED9EE3D9F1396757D2C687927")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     LayerDrawable(Drawable[] layers, LayerState state) {
        this(state, null);
        dsTaint.addTaint(layers[0].dsTaint);
        dsTaint.addTaint(state.dsTaint);
        int length;
        length = layers.length;
        ChildDrawable[] r;
        r = new ChildDrawable[length];
        {
            int i;
            i = 0;
            {
                r[i] = new ChildDrawable();
                r[i].mDrawable = layers[i];
                layers[i].setCallback(this);
                mLayerState.mChildrenChangingConfigurations |= layers[i].getChangingConfigurations();
            } //End block
        } //End collapsed parenthetic
        mLayerState.mNum = length;
        mLayerState.mChildren = r;
        ensurePadding();
        // ---------- Original Method ----------
        //int length = layers.length;
        //ChildDrawable[] r = new ChildDrawable[length];
        //for (int i = 0; i < length; i++) {
            //r[i] = new ChildDrawable();
            //r[i].mDrawable = layers[i];
            //layers[i].setCallback(this);
            //mLayerState.mChildrenChangingConfigurations |= layers[i].getChangingConfigurations();
        //}
        //mLayerState.mNum = length;
        //mLayerState.mChildren = r;
        //ensurePadding();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.446 -0400", hash_original_method = "E2A4F408D4F72AC6B7199B314E863E72", hash_generated_method = "E5E998CAAF8ED85BF887873B15A40A8F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     LayerDrawable() {
        this((LayerState) null, null);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.448 -0400", hash_original_method = "026CAD40EA728EE5D396C83F5E4D2B2B", hash_generated_method = "DFABD004CA8AF692B2F9E8521A988278")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     LayerDrawable(LayerState state, Resources res) {
        dsTaint.addTaint(res.dsTaint);
        dsTaint.addTaint(state.dsTaint);
        LayerState as;
        as = createConstantState(state, res);
        mLayerState = as;
        {
            ensurePadding();
        } //End block
        // ---------- Original Method ----------
        //LayerState as = createConstantState(state, res);
        //mLayerState = as;
        //if (as.mNum > 0) {
            //ensurePadding();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.448 -0400", hash_original_method = "7FB89ACAD944F734BBC3DF72F4EDEEB2", hash_generated_method = "2C6553CE5D15D6C8B6EB0168396E496E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     LayerState createConstantState(LayerState state, Resources res) {
        dsTaint.addTaint(res.dsTaint);
        dsTaint.addTaint(state.dsTaint);
        LayerState var1644D3AC445D742430CA40708E868025_1505412648 = (new LayerState(state, this, res));
        return (LayerState)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new LayerState(state, this, res);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.449 -0400", hash_original_method = "A154F132E6CF56E7598B71E5310AFACF", hash_generated_method = "E4FE84E62971D99757B4BDDE2F463033")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void inflate(Resources r, XmlPullParser parser, AttributeSet attrs) throws XmlPullParserException, IOException {
        dsTaint.addTaint(r.dsTaint);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(parser.dsTaint);
        super.inflate(r, parser, attrs);
        int type;
        TypedArray a;
        a = r.obtainAttributes(attrs, com.android.internal.R.styleable.LayerDrawable);
        mOpacityOverride = a.getInt(com.android.internal.R.styleable.LayerDrawable_opacity,
                PixelFormat.UNKNOWN);
        a.recycle();
        int innerDepth;
        innerDepth = parser.getDepth() + 1;
        int depth;
        {
            boolean var29882DFEED643D3ED9626B373247FA72_1311145686 = ((type = parser.next()) != XmlPullParser.END_DOCUMENT
                && ((depth = parser.getDepth()) >= innerDepth || type != XmlPullParser.END_TAG));
            {
                {
                    boolean var03C44ADC0346A0FD12ECFE38D2A0612F_938501811 = (depth > innerDepth || !parser.getName().equals("item"));
                } //End collapsed parenthetic
                a = r.obtainAttributes(attrs,
                    com.android.internal.R.styleable.LayerDrawableItem);
                int left;
                left = a.getDimensionPixelOffset(
                    com.android.internal.R.styleable.LayerDrawableItem_left, 0);
                int top;
                top = a.getDimensionPixelOffset(
                    com.android.internal.R.styleable.LayerDrawableItem_top, 0);
                int right;
                right = a.getDimensionPixelOffset(
                    com.android.internal.R.styleable.LayerDrawableItem_right, 0);
                int bottom;
                bottom = a.getDimensionPixelOffset(
                    com.android.internal.R.styleable.LayerDrawableItem_bottom, 0);
                int drawableRes;
                drawableRes = a.getResourceId(
                    com.android.internal.R.styleable.LayerDrawableItem_drawable, 0);
                int id;
                id = a.getResourceId(com.android.internal.R.styleable.LayerDrawableItem_id,
                    View.NO_ID);
                a.recycle();
                Drawable dr;
                {
                    dr = r.getDrawable(drawableRes);
                } //End block
                {
                    {
                        boolean var16E7483EB4C069010E58346DA2B7701B_700551394 = ((type = parser.next()) == XmlPullParser.TEXT);
                    } //End collapsed parenthetic
                    {
                        if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException(parser.getPositionDescription()
                            + ": <item> tag requires a 'drawable' attribute or "
                            + "child tag defining a drawable");
                    } //End block
                    dr = Drawable.createFromXmlInner(r, parser, attrs);
                } //End block
                addLayer(dr, id, left, top, right, bottom);
            } //End block
        } //End collapsed parenthetic
        ensurePadding();
        onStateChange(getState());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.450 -0400", hash_original_method = "F6995F9609496F6742CAB01EE3CD1860", hash_generated_method = "0DE7D7E3872EC881CC054FB00D8951CA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void addLayer(Drawable layer, int id, int left, int top, int right, int bottom) {
        dsTaint.addTaint(id);
        dsTaint.addTaint(bottom);
        dsTaint.addTaint(layer.dsTaint);
        dsTaint.addTaint(left);
        dsTaint.addTaint(right);
        dsTaint.addTaint(top);
        LayerState st;
        st = mLayerState;
        int N;
        N = st.mChildren.length;
        N = 0;
        int i;
        i = st.mNum;
        {
            ChildDrawable[] nu;
            nu = new ChildDrawable[N + 10];
            {
                System.arraycopy(st.mChildren, 0, nu, 0, i);
            } //End block
            st.mChildren = nu;
        } //End block
        mLayerState.mChildrenChangingConfigurations |= layer.getChangingConfigurations();
        ChildDrawable childDrawable;
        childDrawable = new ChildDrawable();
        st.mChildren[i] = childDrawable;
        childDrawable.mId = id;
        childDrawable.mDrawable = layer;
        childDrawable.mInsetL = left;
        childDrawable.mInsetT = top;
        childDrawable.mInsetR = right;
        childDrawable.mInsetB = bottom;
        layer.setCallback(this);
        // ---------- Original Method ----------
        //final LayerState st = mLayerState;
        //int N = st.mChildren != null ? st.mChildren.length : 0;
        //int i = st.mNum;
        //if (i >= N) {
            //ChildDrawable[] nu = new ChildDrawable[N + 10];
            //if (i > 0) {
                //System.arraycopy(st.mChildren, 0, nu, 0, i);
            //}
            //st.mChildren = nu;
        //}
        //mLayerState.mChildrenChangingConfigurations |= layer.getChangingConfigurations();
        //ChildDrawable childDrawable = new ChildDrawable();
        //st.mChildren[i] = childDrawable;
        //childDrawable.mId = id;
        //childDrawable.mDrawable = layer;
        //childDrawable.mInsetL = left;
        //childDrawable.mInsetT = top;
        //childDrawable.mInsetR = right;
        //childDrawable.mInsetB = bottom;
        //st.mNum++;
        //layer.setCallback(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.451 -0400", hash_original_method = "C91DA5E408896EB69ADE8640201298D6", hash_generated_method = "9D1871250189C7D25578EDDB05306B77")
    @DSModeled(DSC.SAFE)
    public Drawable findDrawableByLayerId(int id) {
        dsTaint.addTaint(id);
        ChildDrawable[] layers;
        layers = mLayerState.mChildren;
        {
            int i;
            i = mLayerState.mNum - 1;
        } //End collapsed parenthetic
        return (Drawable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //final ChildDrawable[] layers = mLayerState.mChildren;
        //for (int i = mLayerState.mNum - 1; i >= 0; i--) {
            //if (layers[i].mId == id) {
                //return layers[i].mDrawable;
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.451 -0400", hash_original_method = "BFB89C99582071313F846F1C811CB3F0", hash_generated_method = "2352C65D3148B178C129823B1E1CA4FA")
    @DSModeled(DSC.SAFE)
    public void setId(int index, int id) {
        dsTaint.addTaint(id);
        dsTaint.addTaint(index);
        mLayerState.mChildren[index].mId = id;
        // ---------- Original Method ----------
        //mLayerState.mChildren[index].mId = id;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.451 -0400", hash_original_method = "A86CD78FFBAB297497BF089506C91B59", hash_generated_method = "0E9B689FACBFE234414385A5267C4CF4")
    @DSModeled(DSC.SAFE)
    public int getNumberOfLayers() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mLayerState.mNum;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.452 -0400", hash_original_method = "34EED4495029B4FCBDB042C377184EB5", hash_generated_method = "9050139AD07F6E7835755FA8F3031413")
    @DSModeled(DSC.SAFE)
    public Drawable getDrawable(int index) {
        dsTaint.addTaint(index);
        return (Drawable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mLayerState.mChildren[index].mDrawable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.452 -0400", hash_original_method = "AA527FDBA3D8F60360C6FC80FEEC74D7", hash_generated_method = "7BB251EA1AC9AC0AE53C7768FF739761")
    @DSModeled(DSC.SAFE)
    public int getId(int index) {
        dsTaint.addTaint(index);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mLayerState.mChildren[index].mId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.453 -0400", hash_original_method = "6F9F1421DDD84B6DEFE7740341A590C2", hash_generated_method = "7D6EDCB94C9F51B18DE920445E41E87F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean setDrawableByLayerId(int id, Drawable drawable) {
        dsTaint.addTaint(id);
        dsTaint.addTaint(drawable.dsTaint);
        ChildDrawable[] layers;
        layers = mLayerState.mChildren;
        {
            int i;
            i = mLayerState.mNum - 1;
            {
                {
                    {
                        {
                            Rect bounds;
                            bounds = layers[i].mDrawable.getBounds();
                            drawable.setBounds(bounds);
                        } //End block
                        layers[i].mDrawable.setCallback(null);
                    } //End block
                    {
                        drawable.setCallback(this);
                    } //End block
                    layers[i].mDrawable = drawable;
                } //End block
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //final ChildDrawable[] layers = mLayerState.mChildren;
        //for (int i = mLayerState.mNum - 1; i >= 0; i--) {
            //if (layers[i].mId == id) {
                //if (layers[i].mDrawable != null) {
                    //if (drawable != null) {
                        //Rect bounds = layers[i].mDrawable.getBounds();
                        //drawable.setBounds(bounds);
                    //}
                    //layers[i].mDrawable.setCallback(null);
                //}
                //if (drawable != null) {
                    //drawable.setCallback(this);
                //}
                //layers[i].mDrawable = drawable;
                //return true;
            //}
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.453 -0400", hash_original_method = "F7297B48CD52F9107957E141DF7BCBF2", hash_generated_method = "1662A27BF2823C0AAD5C4A99AED11D26")
    @DSModeled(DSC.SAFE)
    public void setLayerInset(int index, int l, int t, int r, int b) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(t);
        dsTaint.addTaint(b);
        dsTaint.addTaint(r);
        dsTaint.addTaint(l);
        ChildDrawable childDrawable;
        childDrawable = mLayerState.mChildren[index];
        childDrawable.mInsetL = l;
        childDrawable.mInsetT = t;
        childDrawable.mInsetR = r;
        childDrawable.mInsetB = b;
        // ---------- Original Method ----------
        //ChildDrawable childDrawable = mLayerState.mChildren[index];
        //childDrawable.mInsetL = l;
        //childDrawable.mInsetT = t;
        //childDrawable.mInsetR = r;
        //childDrawable.mInsetB = b;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.454 -0400", hash_original_method = "289E4B14FC4BAEE8FBED5C03A1D9B634", hash_generated_method = "41CFE1796930DCF2EA1C09782362A302")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void invalidateDrawable(Drawable who) {
        dsTaint.addTaint(who.dsTaint);
        Callback callback;
        callback = getCallback();
        {
            callback.invalidateDrawable(this);
        } //End block
        // ---------- Original Method ----------
        //final Callback callback = getCallback();
        //if (callback != null) {
            //callback.invalidateDrawable(this);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.454 -0400", hash_original_method = "A01CAF97CFFAA14450A9600E14E88C8D", hash_generated_method = "5E91FE06A500769A5C043EEFE8B10766")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void scheduleDrawable(Drawable who, Runnable what, long when) {
        dsTaint.addTaint(what.dsTaint);
        dsTaint.addTaint(when);
        dsTaint.addTaint(who.dsTaint);
        Callback callback;
        callback = getCallback();
        {
            callback.scheduleDrawable(this, what, when);
        } //End block
        // ---------- Original Method ----------
        //final Callback callback = getCallback();
        //if (callback != null) {
            //callback.scheduleDrawable(this, what, when);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.454 -0400", hash_original_method = "CA144C86313E3C1A3DC044F014305D8E", hash_generated_method = "E7D6D2791C5354C92F65E1B2A3B561B5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unscheduleDrawable(Drawable who, Runnable what) {
        dsTaint.addTaint(what.dsTaint);
        dsTaint.addTaint(who.dsTaint);
        Callback callback;
        callback = getCallback();
        {
            callback.unscheduleDrawable(this, what);
        } //End block
        // ---------- Original Method ----------
        //final Callback callback = getCallback();
        //if (callback != null) {
            //callback.unscheduleDrawable(this, what);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.455 -0400", hash_original_method = "90444F7F92DF97CE38686D7CB679E4B0", hash_generated_method = "039D2334738CCD86BC617B8F1B3EFC60")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void draw(Canvas canvas) {
        dsTaint.addTaint(canvas.dsTaint);
        ChildDrawable[] array;
        array = mLayerState.mChildren;
        int N;
        N = mLayerState.mNum;
        {
            int i;
            i = 0;
            {
                array[i].mDrawable.draw(canvas);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //final ChildDrawable[] array = mLayerState.mChildren;
        //final int N = mLayerState.mNum;
        //for (int i=0; i<N; i++) {
            //array[i].mDrawable.draw(canvas);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.455 -0400", hash_original_method = "DA9EE8A6D973B1FAC6E24B2DB8F8E9C8", hash_generated_method = "BD3644686A31AEE138B20BFD49B32F06")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getChangingConfigurations() {
        int var94E997B7BABC89CBE991E62DD288B5E5_1175797498 = (super.getChangingConfigurations()
                | mLayerState.mChangingConfigurations
                | mLayerState.mChildrenChangingConfigurations);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return super.getChangingConfigurations()
                //| mLayerState.mChangingConfigurations
                //| mLayerState.mChildrenChangingConfigurations;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.455 -0400", hash_original_method = "3512A730E5F476B43F9CED59A7F53410", hash_generated_method = "28C6A1D4B20C9D8C4230854F7D555633")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean getPadding(Rect padding) {
        dsTaint.addTaint(padding.dsTaint);
        padding.left = 0;
        padding.top = 0;
        padding.right = 0;
        padding.bottom = 0;
        ChildDrawable[] array;
        array = mLayerState.mChildren;
        int N;
        N = mLayerState.mNum;
        {
            int i;
            i = 0;
            {
                reapplyPadding(i, array[i]);
                padding.left += mPaddingL[i];
                padding.top += mPaddingT[i];
                padding.right += mPaddingR[i];
                padding.bottom += mPaddingB[i];
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //padding.left = 0;
        //padding.top = 0;
        //padding.right = 0;
        //padding.bottom = 0;
        //final ChildDrawable[] array = mLayerState.mChildren;
        //final int N = mLayerState.mNum;
        //for (int i=0; i<N; i++) {
            //reapplyPadding(i, array[i]);
            //padding.left += mPaddingL[i];
            //padding.top += mPaddingT[i];
            //padding.right += mPaddingR[i];
            //padding.bottom += mPaddingB[i];
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.456 -0400", hash_original_method = "DD7D852A8B2359532D654CFF5E5A109F", hash_generated_method = "C1D7F2CAEFF894272A24B46980096E52")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean setVisible(boolean visible, boolean restart) {
        dsTaint.addTaint(restart);
        dsTaint.addTaint(visible);
        boolean changed;
        changed = super.setVisible(visible, restart);
        ChildDrawable[] array;
        array = mLayerState.mChildren;
        int N;
        N = mLayerState.mNum;
        {
            int i;
            i = 0;
            {
                array[i].mDrawable.setVisible(visible, restart);
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //boolean changed = super.setVisible(visible, restart);
        //final ChildDrawable[] array = mLayerState.mChildren;
        //final int N = mLayerState.mNum;
        //for (int i=0; i<N; i++) {
            //array[i].mDrawable.setVisible(visible, restart);
        //}
        //return changed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.456 -0400", hash_original_method = "8B5179F0E6CCC56A1CD26C355EB4BEE6", hash_generated_method = "17E8B9C503A7332C2ACD244F39D6CD68")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setDither(boolean dither) {
        dsTaint.addTaint(dither);
        ChildDrawable[] array;
        array = mLayerState.mChildren;
        int N;
        N = mLayerState.mNum;
        {
            int i;
            i = 0;
            {
                array[i].mDrawable.setDither(dither);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //final ChildDrawable[] array = mLayerState.mChildren;
        //final int N = mLayerState.mNum;
        //for (int i=0; i<N; i++) {
            //array[i].mDrawable.setDither(dither);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.456 -0400", hash_original_method = "A4F4B2E3C1F4B490E6EEA73C8E0E0B9C", hash_generated_method = "3C097E4E2C394946FB2ABA6A5066E1BE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setAlpha(int alpha) {
        dsTaint.addTaint(alpha);
        ChildDrawable[] array;
        array = mLayerState.mChildren;
        int N;
        N = mLayerState.mNum;
        {
            int i;
            i = 0;
            {
                array[i].mDrawable.setAlpha(alpha);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //final ChildDrawable[] array = mLayerState.mChildren;
        //final int N = mLayerState.mNum;
        //for (int i=0; i<N; i++) {
            //array[i].mDrawable.setAlpha(alpha);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.457 -0400", hash_original_method = "6285AEA72EA88CCBF849BD62BDD654E0", hash_generated_method = "8CBDB2C340424E4FC0B0F334347C484E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setColorFilter(ColorFilter cf) {
        dsTaint.addTaint(cf.dsTaint);
        ChildDrawable[] array;
        array = mLayerState.mChildren;
        int N;
        N = mLayerState.mNum;
        {
            int i;
            i = 0;
            {
                array[i].mDrawable.setColorFilter(cf);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //final ChildDrawable[] array = mLayerState.mChildren;
        //final int N = mLayerState.mNum;
        //for (int i=0; i<N; i++) {
            //array[i].mDrawable.setColorFilter(cf);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.457 -0400", hash_original_method = "3DEB6D6A50B9757568C5AA3089CD04F9", hash_generated_method = "CA54867E4E8BD070B20EAD411B722377")
    @DSModeled(DSC.SAFE)
    public void setOpacity(int opacity) {
        dsTaint.addTaint(opacity);
        // ---------- Original Method ----------
        //mOpacityOverride = opacity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.457 -0400", hash_original_method = "0508714C8593107EE12E4CBB1654E530", hash_generated_method = "4BBCBB97A996B38779D48D0CEA77CBF9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getOpacity() {
        int varD6827E07AD7762A3605B5A714D1400AE_731147907 = (mLayerState.getOpacity());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (mOpacityOverride != PixelFormat.UNKNOWN) {
            //return mOpacityOverride;
        //}
        //return mLayerState.getOpacity();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.458 -0400", hash_original_method = "A7862898530225600FCD0A08ADBB8B8E", hash_generated_method = "A975B26D80777F60C7AE20B1AFB87489")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean isStateful() {
        boolean var7FB81E6690C2D4B1B0588FD6EA772E2A_1386862593 = (mLayerState.isStateful());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mLayerState.isStateful();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.458 -0400", hash_original_method = "60327578E5414A54A8EE74C8FEF7053B", hash_generated_method = "92C03C43128B047B69197AA1141F0EF1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected boolean onStateChange(int[] state) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(state[0]);
        ChildDrawable[] array;
        array = mLayerState.mChildren;
        int N;
        N = mLayerState.mNum;
        boolean paddingChanged;
        paddingChanged = false;
        boolean changed;
        changed = false;
        {
            int i;
            i = 0;
            {
                ChildDrawable r;
                r = array[i];
                {
                    boolean var28C3FE43CBFFD13DBC487F1C9FC17892_1844088370 = (r.mDrawable.setState(state));
                    {
                        changed = true;
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean varE196B975D181BB501FFE1FB7B49F0254_2087040782 = (reapplyPadding(i, r));
                    {
                        paddingChanged = true;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            onBoundsChange(getBounds());
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //final ChildDrawable[] array = mLayerState.mChildren;
        //final int N = mLayerState.mNum;
        //boolean paddingChanged = false;
        //boolean changed = false;
        //for (int i=0; i<N; i++) {
            //final ChildDrawable r = array[i];
            //if (r.mDrawable.setState(state)) {
                //changed = true;
            //}
            //if (reapplyPadding(i, r)) {
                //paddingChanged = true;
            //}
        //}
        //if (paddingChanged) {
            //onBoundsChange(getBounds());
        //}
        //return changed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.458 -0400", hash_original_method = "195FB5A6CB4D5D3918E98BB126BE1FA4", hash_generated_method = "9616A959AC38666A9DC146EBFFAB302B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected boolean onLevelChange(int level) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(level);
        ChildDrawable[] array;
        array = mLayerState.mChildren;
        int N;
        N = mLayerState.mNum;
        boolean paddingChanged;
        paddingChanged = false;
        boolean changed;
        changed = false;
        {
            int i;
            i = 0;
            {
                ChildDrawable r;
                r = array[i];
                {
                    boolean varC494E60E0690DBADDE841F49E823D0E9_548368894 = (r.mDrawable.setLevel(level));
                    {
                        changed = true;
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean varE196B975D181BB501FFE1FB7B49F0254_878645828 = (reapplyPadding(i, r));
                    {
                        paddingChanged = true;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            onBoundsChange(getBounds());
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //final ChildDrawable[] array = mLayerState.mChildren;
        //final int N = mLayerState.mNum;
        //boolean paddingChanged = false;
        //boolean changed = false;
        //for (int i=0; i<N; i++) {
            //final ChildDrawable r = array[i];
            //if (r.mDrawable.setLevel(level)) {
                //changed = true;
            //}
            //if (reapplyPadding(i, r)) {
                //paddingChanged = true;
            //}
        //}
        //if (paddingChanged) {
            //onBoundsChange(getBounds());
        //}
        //return changed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.459 -0400", hash_original_method = "7AEE775ACF9989A4B743B4884BF6DFAF", hash_generated_method = "973199D5D56775B6E58310D843634533")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onBoundsChange(Rect bounds) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(bounds.dsTaint);
        ChildDrawable[] array;
        array = mLayerState.mChildren;
        int N;
        N = mLayerState.mNum;
        int padL, padT, padR, padB;
        padL = 0;
        padT = 0;
        padR = 0;
        padB = 0;
        {
            int i;
            i = 0;
            {
                ChildDrawable r;
                r = array[i];
                r.mDrawable.setBounds(bounds.left + r.mInsetL + padL,
                                  bounds.top + r.mInsetT + padT,
                                  bounds.right - r.mInsetR - padR,
                                  bounds.bottom - r.mInsetB - padB);
                padL += mPaddingL[i];
                padR += mPaddingR[i];
                padT += mPaddingT[i];
                padB += mPaddingB[i];
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //final ChildDrawable[] array = mLayerState.mChildren;
        //final int N = mLayerState.mNum;
        //int padL=0, padT=0, padR=0, padB=0;
        //for (int i=0; i<N; i++) {
            //final ChildDrawable r = array[i];
            //r.mDrawable.setBounds(bounds.left + r.mInsetL + padL,
                                  //bounds.top + r.mInsetT + padT,
                                  //bounds.right - r.mInsetR - padR,
                                  //bounds.bottom - r.mInsetB - padB);
            //padL += mPaddingL[i];
            //padR += mPaddingR[i];
            //padT += mPaddingT[i];
            //padB += mPaddingB[i];
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.459 -0400", hash_original_method = "3C77AAA6434E318933C50BFE3151E79D", hash_generated_method = "139BA785660EC40A3A9507C81DF40747")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getIntrinsicWidth() {
        int width;
        width = -1;
        ChildDrawable[] array;
        array = mLayerState.mChildren;
        int N;
        N = mLayerState.mNum;
        int padL, padR;
        padL = 0;
        padR = 0;
        {
            int i;
            i = 0;
            {
                ChildDrawable r;
                r = array[i];
                int w;
                w = r.mDrawable.getIntrinsicWidth()
                  + r.mInsetL + r.mInsetR + padL + padR;
                {
                    width = w;
                } //End block
                padL += mPaddingL[i];
                padR += mPaddingR[i];
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int width = -1;
        //final ChildDrawable[] array = mLayerState.mChildren;
        //final int N = mLayerState.mNum;
        //int padL=0, padR=0;
        //for (int i=0; i<N; i++) {
            //final ChildDrawable r = array[i];
            //int w = r.mDrawable.getIntrinsicWidth()
                  //+ r.mInsetL + r.mInsetR + padL + padR;
            //if (w > width) {
                //width = w;
            //}
            //padL += mPaddingL[i];
            //padR += mPaddingR[i];
        //}
        //return width;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.460 -0400", hash_original_method = "74944E4C19D1A88AACA0D7D60A83587A", hash_generated_method = "F3B2F6C2E02E3053970324DAD32C3BA9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getIntrinsicHeight() {
        int height;
        height = -1;
        ChildDrawable[] array;
        array = mLayerState.mChildren;
        int N;
        N = mLayerState.mNum;
        int padT, padB;
        padT = 0;
        padB = 0;
        {
            int i;
            i = 0;
            {
                ChildDrawable r;
                r = array[i];
                int h;
                h = r.mDrawable.getIntrinsicHeight() + r.mInsetT + r.mInsetB + + padT + padB;
                {
                    height = h;
                } //End block
                padT += mPaddingT[i];
                padB += mPaddingB[i];
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int height = -1;
        //final ChildDrawable[] array = mLayerState.mChildren;
        //final int N = mLayerState.mNum;
        //int padT=0, padB=0;
        //for (int i=0; i<N; i++) {
            //final ChildDrawable r = array[i];
            //int h = r.mDrawable.getIntrinsicHeight() + r.mInsetT + r.mInsetB + + padT + padB;
            //if (h > height) {
                //height = h;
            //}
            //padT += mPaddingT[i];
            //padB += mPaddingB[i];
        //}
        //return height;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.461 -0400", hash_original_method = "41F739441798A70C5E037E0F4FC43A10", hash_generated_method = "1FDD846DD582292FA4DBCD6A35D9A335")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean reapplyPadding(int i, ChildDrawable r) {
        dsTaint.addTaint(r.dsTaint);
        dsTaint.addTaint(i);
        Rect rect;
        rect = mTmpRect;
        r.mDrawable.getPadding(rect);
        {
            mPaddingL[i] = rect.left;
            mPaddingT[i] = rect.top;
            mPaddingR[i] = rect.right;
            mPaddingB[i] = rect.bottom;
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //final Rect rect = mTmpRect;
        //r.mDrawable.getPadding(rect);
        //if (rect.left != mPaddingL[i] || rect.top != mPaddingT[i] ||
                //rect.right != mPaddingR[i] || rect.bottom != mPaddingB[i]) {
            //mPaddingL[i] = rect.left;
            //mPaddingT[i] = rect.top;
            //mPaddingR[i] = rect.right;
            //mPaddingB[i] = rect.bottom;
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.461 -0400", hash_original_method = "6FB87F17A7189073B9E72073B203E52E", hash_generated_method = "7949B96519D51AC26DF51E28E78D63CA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void ensurePadding() {
        int N;
        N = mLayerState.mNum;
        mPaddingL = new int[N];
        mPaddingT = new int[N];
        mPaddingR = new int[N];
        mPaddingB = new int[N];
        // ---------- Original Method ----------
        //final int N = mLayerState.mNum;
        //if (mPaddingL != null && mPaddingL.length >= N) {
            //return;
        //}
        //mPaddingL = new int[N];
        //mPaddingT = new int[N];
        //mPaddingR = new int[N];
        //mPaddingB = new int[N];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.462 -0400", hash_original_method = "42E9B0CF062F666EDFF40D08B19E7027", hash_generated_method = "7950BE35C2D2F68EA56979B400C9633C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ConstantState getConstantState() {
        {
            boolean var1F0836AB1F03D8B5BBF83BA5D084A360_2002658475 = (mLayerState.canConstantState());
            {
                mLayerState.mChangingConfigurations = getChangingConfigurations();
            } //End block
        } //End collapsed parenthetic
        return (ConstantState)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mLayerState.canConstantState()) {
            //mLayerState.mChangingConfigurations = getChangingConfigurations();
            //return mLayerState;
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.462 -0400", hash_original_method = "B6649BA0234C5F68B98BE9A7636194EF", hash_generated_method = "F866FA498351AD56F2D4B73D95153496")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Drawable mutate() {
        {
            boolean varC94B19053599294E7944C8C841976773_460558366 = (!mMutated && super.mutate() == this);
            {
                ChildDrawable[] array;
                array = mLayerState.mChildren;
                int N;
                N = mLayerState.mNum;
                {
                    int i;
                    i = 0;
                    {
                        array[i].mDrawable.mutate();
                    } //End block
                } //End collapsed parenthetic
                mMutated = true;
            } //End block
        } //End collapsed parenthetic
        return (Drawable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (!mMutated && super.mutate() == this) {
            //final ChildDrawable[] array = mLayerState.mChildren;
            //final int N = mLayerState.mNum;
            //for (int i = 0; i < N; i++) {
                //array[i].mDrawable.mutate();
            //}
            //mMutated = true;
        //}
        //return this;
    }

    
    static class ChildDrawable {
        public Drawable mDrawable;
        public int mInsetL, mInsetT, mInsetR, mInsetB;
        public int mId;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.462 -0400", hash_original_method = "E88021C71B8AD221785711B8E4CCBBC8", hash_generated_method = "E88021C71B8AD221785711B8E4CCBBC8")
                public ChildDrawable ()
        {
        }


    }


    
    static class LayerState extends ConstantState {
        int mNum;
        ChildDrawable[] mChildren;
        int mChangingConfigurations;
        int mChildrenChangingConfigurations;
        private boolean mHaveOpacity = false;
        private int mOpacity;
        private boolean mHaveStateful = false;
        private boolean mStateful;
        private boolean mCheckedConstantState;
        private boolean mCanConstantState;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.463 -0400", hash_original_method = "BD826615A7A8424D072A11138F67C8D8", hash_generated_method = "0747D4AFE8062176959B2B6089D488AF")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         LayerState(LayerState orig, LayerDrawable owner, Resources res) {
            dsTaint.addTaint(res.dsTaint);
            dsTaint.addTaint(owner.dsTaint);
            dsTaint.addTaint(orig.dsTaint);
            {
                ChildDrawable[] origChildDrawable;
                origChildDrawable = orig.mChildren;
                int N;
                N = orig.mNum;
                mNum = N;
                mChildren = new ChildDrawable[N];
                mChangingConfigurations = orig.mChangingConfigurations;
                mChildrenChangingConfigurations = orig.mChildrenChangingConfigurations;
                {
                    int i;
                    i = 0;
                    {
                        ChildDrawable r;
                        r = mChildren[i] = new ChildDrawable();
                        ChildDrawable or;
                        or = origChildDrawable[i];
                        {
                            r.mDrawable = or.mDrawable.getConstantState().newDrawable(res);
                        } //End block
                        {
                            r.mDrawable = or.mDrawable.getConstantState().newDrawable();
                        } //End block
                        r.mDrawable.setCallback(owner);
                        r.mInsetL = or.mInsetL;
                        r.mInsetT = or.mInsetT;
                        r.mInsetR = or.mInsetR;
                        r.mInsetB = or.mInsetB;
                        r.mId = or.mId;
                    } //End block
                } //End collapsed parenthetic
                mHaveOpacity = orig.mHaveOpacity;
                mOpacity = orig.mOpacity;
                mHaveStateful = orig.mHaveStateful;
                mStateful = orig.mStateful;
                mCheckedConstantState = mCanConstantState = true;
            } //End block
            {
                mNum = 0;
                mChildren = null;
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.463 -0400", hash_original_method = "4F2E1E1D85BE3BBCABDE93BB1C6F5E02", hash_generated_method = "ED27ECAED97DFCED3FF9344795B8823F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Drawable newDrawable() {
            Drawable var02678EC48047C44BB3D7B139E6873CA3_1130726801 = (new LayerDrawable(this, null));
            return (Drawable)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new LayerDrawable(this, null);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.464 -0400", hash_original_method = "40E045186798A3567910482DC0B43DC7", hash_generated_method = "51B023696BCB48D490BFDEDD27BD9CC9")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Drawable newDrawable(Resources res) {
            dsTaint.addTaint(res.dsTaint);
            Drawable var9FCC0AD3445C551B26F74894CE3C68C9_520626782 = (new LayerDrawable(this, res));
            return (Drawable)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new LayerDrawable(this, res);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.464 -0400", hash_original_method = "9E7D7C67EAC365FF19BD4971762612A5", hash_generated_method = "36011B0CFA5B1C48E438EB66BB35159E")
        @DSModeled(DSC.SAFE)
        @Override
        public int getChangingConfigurations() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return mChangingConfigurations;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.464 -0400", hash_original_method = "C863EE1513D5FAC46B3A54079EE22BC7", hash_generated_method = "A8005ED759D0DADC3A84DE4696795673")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public final int getOpacity() {
            int N;
            N = mNum;
            int op;
            op = mChildren[0].mDrawable.getOpacity();
            op = PixelFormat.TRANSPARENT;
            {
                int i;
                i = 1;
                {
                    op = Drawable.resolveOpacity(op, mChildren[i].mDrawable.getOpacity());
                } //End block
            } //End collapsed parenthetic
            mOpacity = op;
            mHaveOpacity = true;
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //if (mHaveOpacity) {
                //return mOpacity;
            //}
            //final int N = mNum;
            //int op = N > 0 ? mChildren[0].mDrawable.getOpacity() : PixelFormat.TRANSPARENT;
            //for (int i = 1; i < N; i++) {
                //op = Drawable.resolveOpacity(op, mChildren[i].mDrawable.getOpacity());
            //}
            //mOpacity = op;
            //mHaveOpacity = true;
            //return op;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.465 -0400", hash_original_method = "302772CF3A9A555DFD32DC83A81CA17A", hash_generated_method = "9A60C4BDCAAC5F63697EBF3FB3DEE0F0")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public final boolean isStateful() {
            boolean stateful;
            stateful = false;
            int N;
            N = mNum;
            {
                int i;
                i = 0;
                {
                    {
                        boolean varCC50B7DB73A9F6C5D752EC13C92CDF20_1815583936 = (mChildren[i].mDrawable.isStateful());
                        {
                            stateful = true;
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            mStateful = stateful;
            mHaveStateful = true;
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //if (mHaveStateful) {
                //return mStateful;
            //}
            //boolean stateful = false;
            //final int N = mNum;
            //for (int i = 0; i < N; i++) {
                //if (mChildren[i].mDrawable.isStateful()) {
                    //stateful = true;
                    //break;
                //}
            //}
            //mStateful = stateful;
            //mHaveStateful = true;
            //return stateful;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.465 -0400", hash_original_method = "08014AA1073210728E3D3AA9FAF026EA", hash_generated_method = "900EB233ACE6F59669709FA7BC6B1FCF")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public synchronized boolean canConstantState() {
            {
                mCanConstantState = true;
                int N;
                N = mNum;
                {
                    int i;
                    i = 0;
                    {
                        {
                            boolean var72A78A7292B72B8D1D41A0BF5E2460B4_901895181 = (mChildren[i].mDrawable.getConstantState() == null);
                            {
                                mCanConstantState = false;
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
                mCheckedConstantState = true;
            } //End block
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //if (!mCheckedConstantState && mChildren != null) {
                //mCanConstantState = true;
                //final int N = mNum;
                //for (int i=0; i<N; i++) {
                    //if (mChildren[i].mDrawable.getConstantState() == null) {
                        //mCanConstantState = false;
                        //break;
                    //}
                //}
                //mCheckedConstantState = true;
            //}
            //return mCanConstantState;
        }

        
    }


    
}

