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
    private final Rect mTmpRect = new Rect();
    private boolean mMutated;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:47:18.346 -0400", hash_original_method = "45431E38A045C0C983A2E1F24B9ACFC3", hash_generated_method = "E8F10C4EC1CBB1BFF108420509CB6A02")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public LayerDrawable(Drawable[] layers) {
        this(layers, null);
        dsTaint.addTaint(layers[0].dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:47:18.395 -0400", hash_original_method = "FF485081EB7D7D498FB9DCE337B88F15", hash_generated_method = "E5516303BAB5D872823C724925A1570C")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:47:18.403 -0400", hash_original_method = "E2A4F408D4F72AC6B7199B314E863E72", hash_generated_method = "3DAB0F6547C47AFFA3DE95E509FE5B6B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     LayerDrawable() {
        this((LayerState) null, null);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:47:18.428 -0400", hash_original_method = "026CAD40EA728EE5D396C83F5E4D2B2B", hash_generated_method = "349E8DA9E0975E9C31B25763C9E08DC0")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:47:18.485 -0400", hash_original_method = "7FB89ACAD944F734BBC3DF72F4EDEEB2", hash_generated_method = "8A03B05ADC1C0B7268DFA27AE1DE5769")
    @DSModeled(DSC.SAFE)
     LayerState createConstantState(LayerState state, Resources res) {
        dsTaint.addTaint(res.dsTaint);
        dsTaint.addTaint(state.dsTaint);
        return (LayerState)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new LayerState(state, this, res);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:47:18.523 -0400", hash_original_method = "A154F132E6CF56E7598B71E5310AFACF", hash_generated_method = "A58A2939A5AF6973DDE2BB7349A85137")
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
        final int innerDepth;
        innerDepth = parser.getDepth() + 1;
        int depth = 0;
        {
            boolean var29882DFEED643D3ED9626B373247FA72_581835162 = ((type = parser.next()) != XmlPullParser.END_DOCUMENT
                && ((depth = parser.getDepth()) >= innerDepth || type != XmlPullParser.END_TAG));
            {
                {
                    boolean var03C44ADC0346A0FD12ECFE38D2A0612F_941610898 = (depth > innerDepth || !parser.getName().equals("item"));
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
                        boolean var16E7483EB4C069010E58346DA2B7701B_1141060905 = ((type = parser.next()) == XmlPullParser.TEXT);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:47:18.570 -0400", hash_original_method = "F6995F9609496F6742CAB01EE3CD1860", hash_generated_method = "B6015E65A44210A8ADAF377A79D281FD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void addLayer(Drawable layer, int id, int left, int top, int right, int bottom) {
        dsTaint.addTaint(id);
        dsTaint.addTaint(layer.dsTaint);
        dsTaint.addTaint(bottom);
        dsTaint.addTaint(left);
        dsTaint.addTaint(right);
        dsTaint.addTaint(top);
        final LayerState st;
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
        st.mNum++;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:47:18.597 -0400", hash_original_method = "C91DA5E408896EB69ADE8640201298D6", hash_generated_method = "220E7AA2F5C54808126ED973FD99C669")
    @DSModeled(DSC.SAFE)
    public Drawable findDrawableByLayerId(int id) {
        dsTaint.addTaint(id);
        final ChildDrawable[] layers;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:47:18.623 -0400", hash_original_method = "BFB89C99582071313F846F1C811CB3F0", hash_generated_method = "14B943ED499B804021BD70D24C46407A")
    @DSModeled(DSC.SAFE)
    public void setId(int index, int id) {
        dsTaint.addTaint(id);
        dsTaint.addTaint(index);
        mLayerState.mChildren[index].mId = id;
        // ---------- Original Method ----------
        //mLayerState.mChildren[index].mId = id;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:47:18.666 -0400", hash_original_method = "A86CD78FFBAB297497BF089506C91B59", hash_generated_method = "7D361B726526644B3819C7F727BE9A56")
    @DSModeled(DSC.SAFE)
    public int getNumberOfLayers() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mLayerState.mNum;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:47:18.681 -0400", hash_original_method = "34EED4495029B4FCBDB042C377184EB5", hash_generated_method = "DCF050CE6814F1260E3527935B47F353")
    @DSModeled(DSC.SAFE)
    public Drawable getDrawable(int index) {
        dsTaint.addTaint(index);
        return (Drawable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mLayerState.mChildren[index].mDrawable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:47:18.700 -0400", hash_original_method = "AA527FDBA3D8F60360C6FC80FEEC74D7", hash_generated_method = "88FD6F69ECDFCA31B5348D88A4BAD0D2")
    @DSModeled(DSC.SAFE)
    public int getId(int index) {
        dsTaint.addTaint(index);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mLayerState.mChildren[index].mId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:47:18.758 -0400", hash_original_method = "6F9F1421DDD84B6DEFE7740341A590C2", hash_generated_method = "8CED130E3E1ADC864E31BB6C854EB7EC")
    @DSModeled(DSC.SAFE)
    public boolean setDrawableByLayerId(int id, Drawable drawable) {
        dsTaint.addTaint(id);
        dsTaint.addTaint(drawable.dsTaint);
        final ChildDrawable[] layers;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:47:18.813 -0400", hash_original_method = "F7297B48CD52F9107957E141DF7BCBF2", hash_generated_method = "393342FA57D8B1028C45E97F8206F62C")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:47:18.836 -0400", hash_original_method = "289E4B14FC4BAEE8FBED5C03A1D9B634", hash_generated_method = "D7A125D884399668326B167A1A20D259")
    @DSModeled(DSC.SAFE)
    public void invalidateDrawable(Drawable who) {
        dsTaint.addTaint(who.dsTaint);
        final Callback callback;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:47:18.857 -0400", hash_original_method = "A01CAF97CFFAA14450A9600E14E88C8D", hash_generated_method = "4140553D1B4A660A5BFE5C63C152BF16")
    @DSModeled(DSC.SAFE)
    public void scheduleDrawable(Drawable who, Runnable what, long when) {
        dsTaint.addTaint(what.dsTaint);
        dsTaint.addTaint(when);
        dsTaint.addTaint(who.dsTaint);
        final Callback callback;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:47:18.876 -0400", hash_original_method = "CA144C86313E3C1A3DC044F014305D8E", hash_generated_method = "EEC35E08D6CEB726288E36993E6C764A")
    @DSModeled(DSC.SAFE)
    public void unscheduleDrawable(Drawable who, Runnable what) {
        dsTaint.addTaint(what.dsTaint);
        dsTaint.addTaint(who.dsTaint);
        final Callback callback;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:47:18.892 -0400", hash_original_method = "90444F7F92DF97CE38686D7CB679E4B0", hash_generated_method = "64D30F8F31879AB2C5DE4A78C844BE0C")
    @DSModeled(DSC.SAFE)
    @Override
    public void draw(Canvas canvas) {
        dsTaint.addTaint(canvas.dsTaint);
        final ChildDrawable[] array;
        array = mLayerState.mChildren;
        final int N;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:47:18.896 -0400", hash_original_method = "DA9EE8A6D973B1FAC6E24B2DB8F8E9C8", hash_generated_method = "67D93E581B93792B5748F0D9BBE63343")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getChangingConfigurations() {
        int var94E997B7BABC89CBE991E62DD288B5E5_1116637244 = (super.getChangingConfigurations()
                | mLayerState.mChangingConfigurations
                | mLayerState.mChildrenChangingConfigurations);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return super.getChangingConfigurations()
                //| mLayerState.mChangingConfigurations
                //| mLayerState.mChildrenChangingConfigurations;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:47:18.930 -0400", hash_original_method = "3512A730E5F476B43F9CED59A7F53410", hash_generated_method = "EF2B2D599052794A07FA9F605A5977AC")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean getPadding(Rect padding) {
        dsTaint.addTaint(padding.dsTaint);
        padding.left = 0;
        padding.top = 0;
        padding.right = 0;
        padding.bottom = 0;
        final ChildDrawable[] array;
        array = mLayerState.mChildren;
        final int N;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:47:18.959 -0400", hash_original_method = "DD7D852A8B2359532D654CFF5E5A109F", hash_generated_method = "C6051C0FF15BDCDAFFBB758C7128089C")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean setVisible(boolean visible, boolean restart) {
        dsTaint.addTaint(restart);
        dsTaint.addTaint(visible);
        boolean changed;
        changed = super.setVisible(visible, restart);
        final ChildDrawable[] array;
        array = mLayerState.mChildren;
        final int N;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:47:18.979 -0400", hash_original_method = "8B5179F0E6CCC56A1CD26C355EB4BEE6", hash_generated_method = "5C3D9EFF5558FB67D8A49F69CC41F1A0")
    @DSModeled(DSC.SAFE)
    @Override
    public void setDither(boolean dither) {
        dsTaint.addTaint(dither);
        final ChildDrawable[] array;
        array = mLayerState.mChildren;
        final int N;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:47:18.996 -0400", hash_original_method = "A4F4B2E3C1F4B490E6EEA73C8E0E0B9C", hash_generated_method = "7C0BAC4A92B35B707EBFE02C766666AC")
    @DSModeled(DSC.SAFE)
    @Override
    public void setAlpha(int alpha) {
        dsTaint.addTaint(alpha);
        final ChildDrawable[] array;
        array = mLayerState.mChildren;
        final int N;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:47:19.006 -0400", hash_original_method = "6285AEA72EA88CCBF849BD62BDD654E0", hash_generated_method = "1DDF69C3FB69311B60B1775868D17FBE")
    @DSModeled(DSC.SAFE)
    @Override
    public void setColorFilter(ColorFilter cf) {
        dsTaint.addTaint(cf.dsTaint);
        final ChildDrawable[] array;
        array = mLayerState.mChildren;
        final int N;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:47:19.012 -0400", hash_original_method = "3DEB6D6A50B9757568C5AA3089CD04F9", hash_generated_method = "BAB6139F4CAFF6FB43A6D41894075D7E")
    @DSModeled(DSC.SAFE)
    public void setOpacity(int opacity) {
        dsTaint.addTaint(opacity);
        // ---------- Original Method ----------
        //mOpacityOverride = opacity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:47:19.020 -0400", hash_original_method = "0508714C8593107EE12E4CBB1654E530", hash_generated_method = "9CD1E77F638863B6AF931F807998C363")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getOpacity() {
        int varD6827E07AD7762A3605B5A714D1400AE_1583002273 = (mLayerState.getOpacity());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (mOpacityOverride != PixelFormat.UNKNOWN) {
            //return mOpacityOverride;
        //}
        //return mLayerState.getOpacity();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:47:19.024 -0400", hash_original_method = "A7862898530225600FCD0A08ADBB8B8E", hash_generated_method = "6B0DB340310A89A68055E1D727C01CA8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean isStateful() {
        boolean var7FB81E6690C2D4B1B0588FD6EA772E2A_992725774 = (mLayerState.isStateful());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mLayerState.isStateful();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:47:19.052 -0400", hash_original_method = "60327578E5414A54A8EE74C8FEF7053B", hash_generated_method = "2D660FAFF07CAC4576D37EF7E1646A53")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected boolean onStateChange(int[] state) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(state);
        final ChildDrawable[] array;
        array = mLayerState.mChildren;
        final int N;
        N = mLayerState.mNum;
        boolean paddingChanged;
        paddingChanged = false;
        boolean changed;
        changed = false;
        {
            int i;
            i = 0;
            {
                final ChildDrawable r;
                r = array[i];
                {
                    boolean var28C3FE43CBFFD13DBC487F1C9FC17892_1743120855 = (r.mDrawable.setState(state));
                    {
                        changed = true;
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean varE196B975D181BB501FFE1FB7B49F0254_716592449 = (reapplyPadding(i, r));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:47:19.093 -0400", hash_original_method = "195FB5A6CB4D5D3918E98BB126BE1FA4", hash_generated_method = "94506696E3E32BAC9D2E30E49826EB58")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected boolean onLevelChange(int level) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(level);
        final ChildDrawable[] array;
        array = mLayerState.mChildren;
        final int N;
        N = mLayerState.mNum;
        boolean paddingChanged;
        paddingChanged = false;
        boolean changed;
        changed = false;
        {
            int i;
            i = 0;
            {
                final ChildDrawable r;
                r = array[i];
                {
                    boolean varC494E60E0690DBADDE841F49E823D0E9_2039702043 = (r.mDrawable.setLevel(level));
                    {
                        changed = true;
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean varE196B975D181BB501FFE1FB7B49F0254_1939962346 = (reapplyPadding(i, r));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:47:19.150 -0400", hash_original_method = "7AEE775ACF9989A4B743B4884BF6DFAF", hash_generated_method = "02F04928CDA07F5B6E5E8980EB89476A")
    @DSModeled(DSC.SAFE)
    @Override
    protected void onBoundsChange(Rect bounds) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(bounds.dsTaint);
        final ChildDrawable[] array;
        array = mLayerState.mChildren;
        final int N;
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
                final ChildDrawable r;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:47:19.200 -0400", hash_original_method = "3C77AAA6434E318933C50BFE3151E79D", hash_generated_method = "AAD3B467DC421DB2CC8BB62DA4EA3CCD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getIntrinsicWidth() {
        int width;
        width = -1;
        final ChildDrawable[] array;
        array = mLayerState.mChildren;
        final int N;
        N = mLayerState.mNum;
        int padL, padR;
        padL = 0;
        padR = 0;
        {
            int i;
            i = 0;
            {
                final ChildDrawable r;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:47:19.255 -0400", hash_original_method = "74944E4C19D1A88AACA0D7D60A83587A", hash_generated_method = "410D13C64EF53F7D7DD604663DD850FD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getIntrinsicHeight() {
        int height;
        height = -1;
        final ChildDrawable[] array;
        array = mLayerState.mChildren;
        final int N;
        N = mLayerState.mNum;
        int padT, padB;
        padT = 0;
        padB = 0;
        {
            int i;
            i = 0;
            {
                final ChildDrawable r;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:47:19.370 -0400", hash_original_method = "41F739441798A70C5E037E0F4FC43A10", hash_generated_method = "FD178D19876DCAC7C205D71EE2BCF116")
    @DSModeled(DSC.SAFE)
    private boolean reapplyPadding(int i, ChildDrawable r) {
        dsTaint.addTaint(r.dsTaint);
        dsTaint.addTaint(i);
        final Rect rect;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:47:19.383 -0400", hash_original_method = "6FB87F17A7189073B9E72073B203E52E", hash_generated_method = "759C3357141E0D8F556583C47619720C")
    @DSModeled(DSC.SAFE)
    private void ensurePadding() {
        final int N;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:47:19.413 -0400", hash_original_method = "42E9B0CF062F666EDFF40D08B19E7027", hash_generated_method = "60E052F0DE72145726D16FB44F2604E9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ConstantState getConstantState() {
        {
            boolean var1F0836AB1F03D8B5BBF83BA5D084A360_1473083545 = (mLayerState.canConstantState());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:47:19.425 -0400", hash_original_method = "B6649BA0234C5F68B98BE9A7636194EF", hash_generated_method = "BA8656FB99052F237977036510FB0AD6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Drawable mutate() {
        {
            boolean varC94B19053599294E7944C8C841976773_1548949617 = (!mMutated && super.mutate() == this);
            {
                final ChildDrawable[] array;
                array = mLayerState.mChildren;
                final int N;
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:47:19.454 -0400", hash_original_method = "BD826615A7A8424D072A11138F67C8D8", hash_generated_method = "C7A7362649032E362EEA2D09318AFB46")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         LayerState(LayerState orig, LayerDrawable owner, Resources res) {
            dsTaint.addTaint(res.dsTaint);
            dsTaint.addTaint(owner.dsTaint);
            dsTaint.addTaint(orig.dsTaint);
            {
                final ChildDrawable[] origChildDrawable;
                origChildDrawable = orig.mChildren;
                final int N;
                N = orig.mNum;
                mNum = N;
                mChildren = new ChildDrawable[N];
                mChangingConfigurations = orig.mChangingConfigurations;
                mChildrenChangingConfigurations = orig.mChildrenChangingConfigurations;
                {
                    int i;
                    i = 0;
                    {
                        final ChildDrawable r;
                        r = mChildren[i] = new ChildDrawable();
                        final ChildDrawable or;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:47:19.473 -0400", hash_original_method = "4F2E1E1D85BE3BBCABDE93BB1C6F5E02", hash_generated_method = "F9D019E2D3F3930948AE4B51B98050CC")
        @DSModeled(DSC.SAFE)
        @Override
        public Drawable newDrawable() {
            return (Drawable)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new LayerDrawable(this, null);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:47:19.491 -0400", hash_original_method = "40E045186798A3567910482DC0B43DC7", hash_generated_method = "B481FACD3833604FA21237C0E72D9FDB")
        @DSModeled(DSC.SAFE)
        @Override
        public Drawable newDrawable(Resources res) {
            dsTaint.addTaint(res.dsTaint);
            return (Drawable)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new LayerDrawable(this, res);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:47:19.523 -0400", hash_original_method = "9E7D7C67EAC365FF19BD4971762612A5", hash_generated_method = "2D59F41488F7278F18877F131EF0D371")
        @DSModeled(DSC.SAFE)
        @Override
        public int getChangingConfigurations() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return mChangingConfigurations;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:47:19.596 -0400", hash_original_method = "C863EE1513D5FAC46B3A54079EE22BC7", hash_generated_method = "2A629285F457A55EE330C447B5B51DDE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public final int getOpacity() {
            final int N;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:47:19.611 -0400", hash_original_method = "302772CF3A9A555DFD32DC83A81CA17A", hash_generated_method = "3DF5C80FAC065696BADB67FE5F5E9D07")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public final boolean isStateful() {
            boolean stateful;
            stateful = false;
            final int N;
            N = mNum;
            {
                int i;
                i = 0;
                {
                    {
                        boolean varCC50B7DB73A9F6C5D752EC13C92CDF20_1799933883 = (mChildren[i].mDrawable.isStateful());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:47:19.623 -0400", hash_original_method = "08014AA1073210728E3D3AA9FAF026EA", hash_generated_method = "B38239EA873B1925CC02A7B36A28A1AC")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public synchronized boolean canConstantState() {
            {
                mCanConstantState = true;
                final int N;
                N = mNum;
                {
                    int i;
                    i = 0;
                    {
                        {
                            boolean var72A78A7292B72B8D1D41A0BF5E2460B4_1525023122 = (mChildren[i].mDrawable.getConstantState() == null);
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


