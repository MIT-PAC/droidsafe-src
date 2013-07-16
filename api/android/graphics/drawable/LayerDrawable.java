package android.graphics.drawable;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.391 -0400", hash_original_field = "FBD5C16B0695BD8A1AF4AF03C1997413", hash_generated_field = "053037057B7FC4B2D43393B0DA597B94")

    LayerState mLayerState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.391 -0400", hash_original_field = "64D0AA5B1A92A4FB50EC39F09F4A8C25", hash_generated_field = "DBD2988EAF133D76032F3EAD1CE10F00")

    private int mOpacityOverride = PixelFormat.UNKNOWN;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.391 -0400", hash_original_field = "BF28C32EB715E78C047B98E92C68020B", hash_generated_field = "7D03B5A878C9FF91EB46A7111D526D76")

    private int[] mPaddingL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.391 -0400", hash_original_field = "D31A5F208004A2B9A269CC61943D4147", hash_generated_field = "14F9B3A237223751479C6D3D809F2002")

    private int[] mPaddingT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.391 -0400", hash_original_field = "8DFC1DBDE04D51889801984C45C6BF2B", hash_generated_field = "9C76E5B4161411C12A357F3E6012EEB7")

    private int[] mPaddingR;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.391 -0400", hash_original_field = "E89E83B2ABB6BA176FA02FF51ED8A635", hash_generated_field = "9C3BE8A516D526DA1E4DFBF1EA68DB1D")

    private int[] mPaddingB;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.391 -0400", hash_original_field = "C16522492B0457D64CB22178541F3ACA", hash_generated_field = "570061BA9CB059462550E9BCCD2A0735")

    private final Rect mTmpRect = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.391 -0400", hash_original_field = "9FB80C30383848C8D006680B5F3BDAF9", hash_generated_field = "5CA5A1EF3CAA45117BCACBC34EF05952")

    private boolean mMutated;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.392 -0400", hash_original_method = "45431E38A045C0C983A2E1F24B9ACFC3", hash_generated_method = "4CE2708C4D9F71FB85D58CF9B25390F6")
    public  LayerDrawable(Drawable[] layers) {
        this(layers, null);
        addTaint(layers[0].getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.393 -0400", hash_original_method = "FF485081EB7D7D498FB9DCE337B88F15", hash_generated_method = "8CCEA8836EDA995C4FECEBC7ECD1B1C3")
      LayerDrawable(Drawable[] layers, LayerState state) {
        this(state, null);
        addTaint(state.getTaint());
        int length = layers.length;
        ChildDrawable[] r = new ChildDrawable[length];
for(int i = 0;i < length;i++)
        {
            r[i] = new ChildDrawable();
            r[i].mDrawable = layers[i];
            layers[i].setCallback(this);
            mLayerState.mChildrenChangingConfigurations |= layers[i].getChangingConfigurations();
        } //End block
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.393 -0400", hash_original_method = "E2A4F408D4F72AC6B7199B314E863E72", hash_generated_method = "E5E998CAAF8ED85BF887873B15A40A8F")
      LayerDrawable() {
        this((LayerState) null, null);
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.394 -0400", hash_original_method = "026CAD40EA728EE5D396C83F5E4D2B2B", hash_generated_method = "3AC485F18684D21301A60FDB017CEB1E")
      LayerDrawable(LayerState state, Resources res) {
        addTaint(res.getTaint());
        addTaint(state.getTaint());
        LayerState as = createConstantState(state, res);
        mLayerState = as;
    if(as.mNum > 0)        
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.394 -0400", hash_original_method = "7FB89ACAD944F734BBC3DF72F4EDEEB2", hash_generated_method = "1624A3FC8F50D0C0B4E868744059555D")
     LayerState createConstantState(LayerState state, Resources res) {
        addTaint(res.getTaint());
        addTaint(state.getTaint());
LayerState var48999977F4D50086962FDA584D65F4D3_704497505 =         new LayerState(state, this, res);
        var48999977F4D50086962FDA584D65F4D3_704497505.addTaint(taint);
        return var48999977F4D50086962FDA584D65F4D3_704497505;
        // ---------- Original Method ----------
        //return new LayerState(state, this, res);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.396 -0400", hash_original_method = "A154F132E6CF56E7598B71E5310AFACF", hash_generated_method = "142234C5D8EC106CE852ECFBF574253C")
    @Override
    public void inflate(Resources r, XmlPullParser parser, AttributeSet attrs) throws XmlPullParserException, IOException {
        addTaint(attrs.getTaint());
        addTaint(parser.getTaint());
        addTaint(r.getTaint());
        super.inflate(r, parser, attrs);
        int type;
        TypedArray a = r.obtainAttributes(attrs, com.android.internal.R.styleable.LayerDrawable);
        mOpacityOverride = a.getInt(com.android.internal.R.styleable.LayerDrawable_opacity,
                PixelFormat.UNKNOWN);
        a.recycle();
        final int innerDepth = parser.getDepth() + 1;
        int depth;
        while
((type = parser.next()) != XmlPullParser.END_DOCUMENT
                && ((depth = parser.getDepth()) >= innerDepth || type != XmlPullParser.END_TAG))        
        {
    if(type != XmlPullParser.START_TAG)            
            {
                continue;
            } //End block
    if(depth > innerDepth || !parser.getName().equals("item"))            
            {
                continue;
            } //End block
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
    if(drawableRes != 0)            
            {
                dr = r.getDrawable(drawableRes);
            } //End block
            else
            {
                while
((type = parser.next()) == XmlPullParser.TEXT)                
                {
                } //End block
    if(type != XmlPullParser.START_TAG)                
                {
                    XmlPullParserException var323689A2E36B2E80C03C4E544ECA8A7C_1133240321 = new XmlPullParserException(parser.getPositionDescription()
                            + ": <item> tag requires a 'drawable' attribute or "
                            + "child tag defining a drawable");
                    var323689A2E36B2E80C03C4E544ECA8A7C_1133240321.addTaint(taint);
                    throw var323689A2E36B2E80C03C4E544ECA8A7C_1133240321;
                } //End block
                dr = Drawable.createFromXmlInner(r, parser, attrs);
            } //End block
            addLayer(dr, id, left, top, right, bottom);
        } //End block
        ensurePadding();
        onStateChange(getState());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.397 -0400", hash_original_method = "F6995F9609496F6742CAB01EE3CD1860", hash_generated_method = "27A9582AD0F787BE2FBB54959446C43C")
    private void addLayer(Drawable layer, int id, int left, int top, int right, int bottom) {
        addTaint(bottom);
        addTaint(right);
        addTaint(top);
        addTaint(left);
        addTaint(id);
        final LayerState st = mLayerState;
        int N = st.mChildren != null ? st.mChildren.length : 0;
        int i = st.mNum;
    if(i >= N)        
        {
            ChildDrawable[] nu = new ChildDrawable[N + 10];
    if(i > 0)            
            {
                System.arraycopy(st.mChildren, 0, nu, 0, i);
            } //End block
            st.mChildren = nu;
        } //End block
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.398 -0400", hash_original_method = "C91DA5E408896EB69ADE8640201298D6", hash_generated_method = "FB09A8CB30B1A60993FDBB9FE000AEDF")
    public Drawable findDrawableByLayerId(int id) {
        addTaint(id);
        final ChildDrawable[] layers = mLayerState.mChildren;
for(int i = mLayerState.mNum - 1;i >= 0;i--)
        {
    if(layers[i].mId == id)            
            {
Drawable varE8267E1B846BD6D5147B179D83737606_623582695 =                 layers[i].mDrawable;
                varE8267E1B846BD6D5147B179D83737606_623582695.addTaint(taint);
                return varE8267E1B846BD6D5147B179D83737606_623582695;
            } //End block
        } //End block
Drawable var540C13E9E156B687226421B24F2DF178_1749667609 =         null;
        var540C13E9E156B687226421B24F2DF178_1749667609.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1749667609;
        // ---------- Original Method ----------
        //final ChildDrawable[] layers = mLayerState.mChildren;
        //for (int i = mLayerState.mNum - 1; i >= 0; i--) {
            //if (layers[i].mId == id) {
                //return layers[i].mDrawable;
            //}
        //}
        //return null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.398 -0400", hash_original_method = "BFB89C99582071313F846F1C811CB3F0", hash_generated_method = "1FC88131F9D499108AE970D8E9987726")
    public void setId(int index, int id) {
        mLayerState.mChildren[index].mId = id;
        // ---------- Original Method ----------
        //mLayerState.mChildren[index].mId = id;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.399 -0400", hash_original_method = "A86CD78FFBAB297497BF089506C91B59", hash_generated_method = "14C236D0977E32C955D62B9990BC0C9E")
    public int getNumberOfLayers() {
        int var77A96D0335C1B7B88F0C83CF3A1D2715_1661751265 = (mLayerState.mNum);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1657826755 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1657826755;
        // ---------- Original Method ----------
        //return mLayerState.mNum;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.399 -0400", hash_original_method = "34EED4495029B4FCBDB042C377184EB5", hash_generated_method = "9CDC39E4F47DF25917B84CD3A58E25FC")
    public Drawable getDrawable(int index) {
        addTaint(index);
Drawable var89CF1DD3F0480B4EDBE7A7538EEF91E6_1822365459 =         mLayerState.mChildren[index].mDrawable;
        var89CF1DD3F0480B4EDBE7A7538EEF91E6_1822365459.addTaint(taint);
        return var89CF1DD3F0480B4EDBE7A7538EEF91E6_1822365459;
        // ---------- Original Method ----------
        //return mLayerState.mChildren[index].mDrawable;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.399 -0400", hash_original_method = "AA527FDBA3D8F60360C6FC80FEEC74D7", hash_generated_method = "094FDAF57E83196D2EBEFAE266A1C2FF")
    public int getId(int index) {
        addTaint(index);
        int varD1121C401939322BC287451D81E1EBAC_1489162607 = (mLayerState.mChildren[index].mId);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1817934961 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1817934961;
        // ---------- Original Method ----------
        //return mLayerState.mChildren[index].mId;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.400 -0400", hash_original_method = "6F9F1421DDD84B6DEFE7740341A590C2", hash_generated_method = "E016AE50C8A0E30F5B47204642334F66")
    public boolean setDrawableByLayerId(int id, Drawable drawable) {
        addTaint(drawable.getTaint());
        addTaint(id);
        final ChildDrawable[] layers = mLayerState.mChildren;
for(int i = mLayerState.mNum - 1;i >= 0;i--)
        {
    if(layers[i].mId == id)            
            {
    if(layers[i].mDrawable != null)                
                {
    if(drawable != null)                    
                    {
                        Rect bounds = layers[i].mDrawable.getBounds();
                        drawable.setBounds(bounds);
                    } //End block
                    layers[i].mDrawable.setCallback(null);
                } //End block
    if(drawable != null)                
                {
                    drawable.setCallback(this);
                } //End block
                layers[i].mDrawable = drawable;
                boolean varB326B5062B2F0E69046810717534CB09_1454584540 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_914907349 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_914907349;
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_589688368 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1541553939 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1541553939;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.401 -0400", hash_original_method = "F7297B48CD52F9107957E141DF7BCBF2", hash_generated_method = "322DC82EEB7F1E7A4709C62B243365B9")
    public void setLayerInset(int index, int l, int t, int r, int b) {
        addTaint(b);
        addTaint(r);
        addTaint(t);
        addTaint(l);
        addTaint(index);
        ChildDrawable childDrawable = mLayerState.mChildren[index];
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.401 -0400", hash_original_method = "289E4B14FC4BAEE8FBED5C03A1D9B634", hash_generated_method = "41CEDEB5E33EFE6B1A6A0CCC10DBF093")
    public void invalidateDrawable(Drawable who) {
        addTaint(who.getTaint());
        final Callback callback = getCallback();
    if(callback != null)        
        {
            callback.invalidateDrawable(this);
        } //End block
        // ---------- Original Method ----------
        //final Callback callback = getCallback();
        //if (callback != null) {
            //callback.invalidateDrawable(this);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.402 -0400", hash_original_method = "A01CAF97CFFAA14450A9600E14E88C8D", hash_generated_method = "7093C805993ACF54047727682755EE99")
    public void scheduleDrawable(Drawable who, Runnable what, long when) {
        addTaint(when);
        addTaint(what.getTaint());
        addTaint(who.getTaint());
        final Callback callback = getCallback();
    if(callback != null)        
        {
            callback.scheduleDrawable(this, what, when);
        } //End block
        // ---------- Original Method ----------
        //final Callback callback = getCallback();
        //if (callback != null) {
            //callback.scheduleDrawable(this, what, when);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.402 -0400", hash_original_method = "CA144C86313E3C1A3DC044F014305D8E", hash_generated_method = "FFEE17E462526EA539C05FAA6C36C1E2")
    public void unscheduleDrawable(Drawable who, Runnable what) {
        addTaint(what.getTaint());
        addTaint(who.getTaint());
        final Callback callback = getCallback();
    if(callback != null)        
        {
            callback.unscheduleDrawable(this, what);
        } //End block
        // ---------- Original Method ----------
        //final Callback callback = getCallback();
        //if (callback != null) {
            //callback.unscheduleDrawable(this, what);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.403 -0400", hash_original_method = "90444F7F92DF97CE38686D7CB679E4B0", hash_generated_method = "4B4D1AD2468933E5356D8EB8617AE119")
    @Override
    public void draw(Canvas canvas) {
        addTaint(canvas.getTaint());
        final ChildDrawable[] array = mLayerState.mChildren;
        final int N = mLayerState.mNum;
for(int i=0;i<N;i++)
        {
            array[i].mDrawable.draw(canvas);
        } //End block
        // ---------- Original Method ----------
        //final ChildDrawable[] array = mLayerState.mChildren;
        //final int N = mLayerState.mNum;
        //for (int i=0; i<N; i++) {
            //array[i].mDrawable.draw(canvas);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.403 -0400", hash_original_method = "DA9EE8A6D973B1FAC6E24B2DB8F8E9C8", hash_generated_method = "7B210A7B5CCA0EA3965FD3C75DA7074B")
    @Override
    public int getChangingConfigurations() {
        int var688B2F77CC11CB29A2976C4AE981935D_590848009 = (super.getChangingConfigurations()
                | mLayerState.mChangingConfigurations
                | mLayerState.mChildrenChangingConfigurations);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_591569683 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_591569683;
        // ---------- Original Method ----------
        //return super.getChangingConfigurations()
                //| mLayerState.mChangingConfigurations
                //| mLayerState.mChildrenChangingConfigurations;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.405 -0400", hash_original_method = "3512A730E5F476B43F9CED59A7F53410", hash_generated_method = "9B463135655A545945246AD8E9F71D27")
    @Override
    public boolean getPadding(Rect padding) {
        addTaint(padding.getTaint());
        padding.left = 0;
        padding.top = 0;
        padding.right = 0;
        padding.bottom = 0;
        final ChildDrawable[] array = mLayerState.mChildren;
        final int N = mLayerState.mNum;
for(int i=0;i<N;i++)
        {
            reapplyPadding(i, array[i]);
            padding.left += mPaddingL[i];
            padding.top += mPaddingT[i];
            padding.right += mPaddingR[i];
            padding.bottom += mPaddingB[i];
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_1637593210 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_962521578 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_962521578;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.406 -0400", hash_original_method = "DD7D852A8B2359532D654CFF5E5A109F", hash_generated_method = "D1990311B0BFFE5BE17F3A584CC7ED9C")
    @Override
    public boolean setVisible(boolean visible, boolean restart) {
        addTaint(restart);
        addTaint(visible);
        boolean changed = super.setVisible(visible, restart);
        final ChildDrawable[] array = mLayerState.mChildren;
        final int N = mLayerState.mNum;
for(int i=0;i<N;i++)
        {
            array[i].mDrawable.setVisible(visible, restart);
        } //End block
        boolean var8977DFAC2F8E04CB96E66882235F5ABA_1161852268 = (changed);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1212502193 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1212502193;
        // ---------- Original Method ----------
        //boolean changed = super.setVisible(visible, restart);
        //final ChildDrawable[] array = mLayerState.mChildren;
        //final int N = mLayerState.mNum;
        //for (int i=0; i<N; i++) {
            //array[i].mDrawable.setVisible(visible, restart);
        //}
        //return changed;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.407 -0400", hash_original_method = "8B5179F0E6CCC56A1CD26C355EB4BEE6", hash_generated_method = "68FF03F235D08C3C5B9FF8083FF65C5A")
    @Override
    public void setDither(boolean dither) {
        addTaint(dither);
        final ChildDrawable[] array = mLayerState.mChildren;
        final int N = mLayerState.mNum;
for(int i=0;i<N;i++)
        {
            array[i].mDrawable.setDither(dither);
        } //End block
        // ---------- Original Method ----------
        //final ChildDrawable[] array = mLayerState.mChildren;
        //final int N = mLayerState.mNum;
        //for (int i=0; i<N; i++) {
            //array[i].mDrawable.setDither(dither);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.407 -0400", hash_original_method = "A4F4B2E3C1F4B490E6EEA73C8E0E0B9C", hash_generated_method = "4546A9394D3B135F0432240027C25908")
    @Override
    public void setAlpha(int alpha) {
        addTaint(alpha);
        final ChildDrawable[] array = mLayerState.mChildren;
        final int N = mLayerState.mNum;
for(int i=0;i<N;i++)
        {
            array[i].mDrawable.setAlpha(alpha);
        } //End block
        // ---------- Original Method ----------
        //final ChildDrawable[] array = mLayerState.mChildren;
        //final int N = mLayerState.mNum;
        //for (int i=0; i<N; i++) {
            //array[i].mDrawable.setAlpha(alpha);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.408 -0400", hash_original_method = "6285AEA72EA88CCBF849BD62BDD654E0", hash_generated_method = "F937F8D5D994A58088BE546B66EEA410")
    @Override
    public void setColorFilter(ColorFilter cf) {
        addTaint(cf.getTaint());
        final ChildDrawable[] array = mLayerState.mChildren;
        final int N = mLayerState.mNum;
for(int i=0;i<N;i++)
        {
            array[i].mDrawable.setColorFilter(cf);
        } //End block
        // ---------- Original Method ----------
        //final ChildDrawable[] array = mLayerState.mChildren;
        //final int N = mLayerState.mNum;
        //for (int i=0; i<N; i++) {
            //array[i].mDrawable.setColorFilter(cf);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.408 -0400", hash_original_method = "3DEB6D6A50B9757568C5AA3089CD04F9", hash_generated_method = "2F8A5119D378716275841296882C6D16")
    public void setOpacity(int opacity) {
        mOpacityOverride = opacity;
        // ---------- Original Method ----------
        //mOpacityOverride = opacity;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.408 -0400", hash_original_method = "0508714C8593107EE12E4CBB1654E530", hash_generated_method = "C87F7E454AB35F22B1CB99FA3E80A35D")
    @Override
    public int getOpacity() {
    if(mOpacityOverride != PixelFormat.UNKNOWN)        
        {
            int varAF9074F63F4C8A3A597D46DDC4A80671_858064750 = (mOpacityOverride);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_913965792 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_913965792;
        } //End block
        int var4711F5457E716ACCB4CB447DD031465B_1562821737 = (mLayerState.getOpacity());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1671309439 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1671309439;
        // ---------- Original Method ----------
        //if (mOpacityOverride != PixelFormat.UNKNOWN) {
            //return mOpacityOverride;
        //}
        //return mLayerState.getOpacity();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.409 -0400", hash_original_method = "A7862898530225600FCD0A08ADBB8B8E", hash_generated_method = "9CD728E1EA6CEBEF5E972F96E385E89A")
    @Override
    public boolean isStateful() {
        boolean var4DEBADF2F0E5C5F5922958ADDE8D457C_700652008 = (mLayerState.isStateful());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_768641907 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_768641907;
        // ---------- Original Method ----------
        //return mLayerState.isStateful();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.409 -0400", hash_original_method = "60327578E5414A54A8EE74C8FEF7053B", hash_generated_method = "EA347B5022AC86A28B6E56EC05C7A626")
    @Override
    protected boolean onStateChange(int[] state) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(state[0]);
        final ChildDrawable[] array = mLayerState.mChildren;
        final int N = mLayerState.mNum;
        boolean paddingChanged = false;
        boolean changed = false;
for(int i=0;i<N;i++)
        {
            final ChildDrawable r = array[i];
    if(r.mDrawable.setState(state))            
            {
                changed = true;
            } //End block
    if(reapplyPadding(i, r))            
            {
                paddingChanged = true;
            } //End block
        } //End block
    if(paddingChanged)        
        {
            onBoundsChange(getBounds());
        } //End block
        boolean var8977DFAC2F8E04CB96E66882235F5ABA_392700302 = (changed);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1214231380 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1214231380;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.410 -0400", hash_original_method = "195FB5A6CB4D5D3918E98BB126BE1FA4", hash_generated_method = "C50403AE79E9A342722E9CC96929BEFC")
    @Override
    protected boolean onLevelChange(int level) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(level);
        final ChildDrawable[] array = mLayerState.mChildren;
        final int N = mLayerState.mNum;
        boolean paddingChanged = false;
        boolean changed = false;
for(int i=0;i<N;i++)
        {
            final ChildDrawable r = array[i];
    if(r.mDrawable.setLevel(level))            
            {
                changed = true;
            } //End block
    if(reapplyPadding(i, r))            
            {
                paddingChanged = true;
            } //End block
        } //End block
    if(paddingChanged)        
        {
            onBoundsChange(getBounds());
        } //End block
        boolean var8977DFAC2F8E04CB96E66882235F5ABA_332336619 = (changed);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2117507025 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2117507025;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.411 -0400", hash_original_method = "7AEE775ACF9989A4B743B4884BF6DFAF", hash_generated_method = "45FF0BBB5FDD04FFCB87572EDE9D8733")
    @Override
    protected void onBoundsChange(Rect bounds) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(bounds.getTaint());
        final ChildDrawable[] array = mLayerState.mChildren;
        final int N = mLayerState.mNum;
        int padL = 0;
        int padT = 0;
        int padR = 0;
        int padB = 0;
for(int i=0;i<N;i++)
        {
            final ChildDrawable r = array[i];
            r.mDrawable.setBounds(bounds.left + r.mInsetL + padL,
                                  bounds.top + r.mInsetT + padT,
                                  bounds.right - r.mInsetR - padR,
                                  bounds.bottom - r.mInsetB - padB);
            padL += mPaddingL[i];
            padR += mPaddingR[i];
            padT += mPaddingT[i];
            padB += mPaddingB[i];
        } //End block
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.413 -0400", hash_original_method = "3C77AAA6434E318933C50BFE3151E79D", hash_generated_method = "FEBF0921BAC11193ABE4DAD476D439D9")
    @Override
    public int getIntrinsicWidth() {
        int width = -1;
        final ChildDrawable[] array = mLayerState.mChildren;
        final int N = mLayerState.mNum;
        int padL = 0;
        int padR = 0;
for(int i=0;i<N;i++)
        {
            final ChildDrawable r = array[i];
            int w = r.mDrawable.getIntrinsicWidth()
                  + r.mInsetL + r.mInsetR + padL + padR;
    if(w > width)            
            {
                width = w;
            } //End block
            padL += mPaddingL[i];
            padR += mPaddingR[i];
        } //End block
        int varEAAE26A6FB20ED3EF54FB23BFA0B1FCC_1322148916 = (width);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1314112436 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1314112436;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.414 -0400", hash_original_method = "74944E4C19D1A88AACA0D7D60A83587A", hash_generated_method = "A1C64474A0E95B4F549106AB282F7421")
    @Override
    public int getIntrinsicHeight() {
        int height = -1;
        final ChildDrawable[] array = mLayerState.mChildren;
        final int N = mLayerState.mNum;
        int padT = 0;
        int padB = 0;
for(int i=0;i<N;i++)
        {
            final ChildDrawable r = array[i];
            int h = r.mDrawable.getIntrinsicHeight() + r.mInsetT + r.mInsetB + + padT + padB;
    if(h > height)            
            {
                height = h;
            } //End block
            padT += mPaddingT[i];
            padB += mPaddingB[i];
        } //End block
        int varB435E227D5DD201E1768B2BCB2E0AA81_1052600599 = (height);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_123918096 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_123918096;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.415 -0400", hash_original_method = "41F739441798A70C5E037E0F4FC43A10", hash_generated_method = "70C39FA003A31EC28784294516F5CADA")
    private boolean reapplyPadding(int i, ChildDrawable r) {
        addTaint(r.getTaint());
        final Rect rect = mTmpRect;
        r.mDrawable.getPadding(rect);
    if(rect.left != mPaddingL[i] || rect.top != mPaddingT[i] ||
                rect.right != mPaddingR[i] || rect.bottom != mPaddingB[i])        
        {
            mPaddingL[i] = rect.left;
            mPaddingT[i] = rect.top;
            mPaddingR[i] = rect.right;
            mPaddingB[i] = rect.bottom;
            boolean varB326B5062B2F0E69046810717534CB09_1651408846 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2089212768 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2089212768;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1175909584 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1122486418 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1122486418;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.416 -0400", hash_original_method = "6FB87F17A7189073B9E72073B203E52E", hash_generated_method = "544A3317EF67F08BD7EA8CD1BDA0B95A")
    private void ensurePadding() {
        final int N = mLayerState.mNum;
    if(mPaddingL != null && mPaddingL.length >= N)        
        {
            return;
        } //End block
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.417 -0400", hash_original_method = "42E9B0CF062F666EDFF40D08B19E7027", hash_generated_method = "657C676B6175DB1A7D63929BD57268BC")
    @Override
    public ConstantState getConstantState() {
    if(mLayerState.canConstantState())        
        {
            mLayerState.mChangingConfigurations = getChangingConfigurations();
ConstantState var4F164EE473043112E30857FCE4A607D8_1142254908 =             mLayerState;
            var4F164EE473043112E30857FCE4A607D8_1142254908.addTaint(taint);
            return var4F164EE473043112E30857FCE4A607D8_1142254908;
        } //End block
ConstantState var540C13E9E156B687226421B24F2DF178_253220787 =         null;
        var540C13E9E156B687226421B24F2DF178_253220787.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_253220787;
        // ---------- Original Method ----------
        //if (mLayerState.canConstantState()) {
            //mLayerState.mChangingConfigurations = getChangingConfigurations();
            //return mLayerState;
        //}
        //return null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.417 -0400", hash_original_method = "B6649BA0234C5F68B98BE9A7636194EF", hash_generated_method = "F4A53627C8DF7CF93CF49BC1A70E235A")
    @Override
    public Drawable mutate() {
    if(!mMutated && super.mutate() == this)        
        {
            final ChildDrawable[] array = mLayerState.mChildren;
            final int N = mLayerState.mNum;
for(int i = 0;i < N;i++)
            {
                array[i].mDrawable.mutate();
            } //End block
            mMutated = true;
        } //End block
Drawable var72A74007B2BE62B849F475C7BDA4658B_445557219 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_445557219.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_445557219;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.418 -0400", hash_original_field = "D548B27C6AC66A9D9B5D05ED35C2D844", hash_generated_field = "36D39E5803890ED250A80FAD100C4ED7")

        public Drawable mDrawable;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.418 -0400", hash_original_field = "84CB0C1DC38731A850F792E2FDB6B39B", hash_generated_field = "41EDDF00F18395AB4E75D54F56DCEAD6")

        public int mInsetL;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.418 -0400", hash_original_field = "FE98DF02B3531CCEEC8254EA7A40D8C2", hash_generated_field = "B7AF8366A6A319CDAA60A9C0D750F631")

        public int mInsetT;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.419 -0400", hash_original_field = "98714B51BF834824DA4A4A1ACF3D4447", hash_generated_field = "EC3C187375874F66EE15413DF92F4E1E")

        public int mInsetR;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.419 -0400", hash_original_field = "10B9A7B0EF30FDBEDF74FE05E0046827", hash_generated_field = "29277012246F0EA1CDF311942F6EA725")

        public int mInsetB;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.419 -0400", hash_original_field = "6AC7F06B6413A1BE9C136DC7DF0D2B60", hash_generated_field = "47CDACD56606F02DFA218FC210EFC0FF")

        public int mId;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.419 -0400", hash_original_method = "6CD909B986D24A0F6BAFA410E280EBB3", hash_generated_method = "6CD909B986D24A0F6BAFA410E280EBB3")
        public ChildDrawable ()
        {
            //Synthesized constructor
        }


    }


    
    static class LayerState extends ConstantState {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.420 -0400", hash_original_field = "1B2924E0CDC894FEA7E3856870275E70", hash_generated_field = "95F99CF2E70DB79AD069A36B506646F2")

        int mNum;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.420 -0400", hash_original_field = "6699FE97ED54C04992AEDA784C483D4D", hash_generated_field = "5D63B0C69B8E94415B4820B44C747438")

        ChildDrawable[] mChildren;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.420 -0400", hash_original_field = "276E0645C4E2084773D0EB8C5576428C", hash_generated_field = "9BFAF00848476277D36D9BA586984BA7")

        int mChangingConfigurations;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.420 -0400", hash_original_field = "8755A6790E0FAEFCC765046FF423478D", hash_generated_field = "E8F7332658D4B8911B8427F9E33AC9BD")

        int mChildrenChangingConfigurations;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.420 -0400", hash_original_field = "B8FE7B1D7EF53BE4167C040A5FEB7CC7", hash_generated_field = "A98F79115AB3FA98F1F7245A604A5EC2")

        private boolean mHaveOpacity = false;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.420 -0400", hash_original_field = "9D334A125EE4B3831821AB1264C029B9", hash_generated_field = "05E7E4BE80B060037CF88AC66652FF58")

        private int mOpacity;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.420 -0400", hash_original_field = "0AB968E9E6651BF0E687DAF7846B214C", hash_generated_field = "C74F5EDB4E2A4B07698A864146958E40")

        private boolean mHaveStateful = false;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.420 -0400", hash_original_field = "1819E5C118FDB6B2BF917A4481AE2A7A", hash_generated_field = "6747C1011A591FA368B1D4C99D94E670")

        private boolean mStateful;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.420 -0400", hash_original_field = "2E319D4D352B34E33CF19129B7212FC6", hash_generated_field = "63D49323436A33301C0DA6EDF88627FF")

        private boolean mCheckedConstantState;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.420 -0400", hash_original_field = "7C8FD9809F31C20B8422D623B0EC0C4F", hash_generated_field = "F62F8D22C4EDE8B8E63C376677BD915C")

        private boolean mCanConstantState;
        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.423 -0400", hash_original_method = "BD826615A7A8424D072A11138F67C8D8", hash_generated_method = "5866F982317DF3E106921EEC25832ED4")
          LayerState(LayerState orig, LayerDrawable owner, Resources res) {
            addTaint(res.getTaint());
            addTaint(owner.getTaint());
    if(orig != null)            
            {
                final ChildDrawable[] origChildDrawable = orig.mChildren;
                final int N = orig.mNum;
                mNum = N;
                mChildren = new ChildDrawable[N];
                mChangingConfigurations = orig.mChangingConfigurations;
                mChildrenChangingConfigurations = orig.mChildrenChangingConfigurations;
for(int i = 0;i < N;i++)
                {
                    final ChildDrawable r = mChildren[i] = new ChildDrawable();
                    final ChildDrawable or = origChildDrawable[i];
    if(res != null)                    
                    {
                        r.mDrawable = or.mDrawable.getConstantState().newDrawable(res);
                    } //End block
                    else
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
                mHaveOpacity = orig.mHaveOpacity;
                mOpacity = orig.mOpacity;
                mHaveStateful = orig.mHaveStateful;
                mStateful = orig.mStateful;
                mCheckedConstantState = mCanConstantState = true;
            } //End block
            else
            {
                mNum = 0;
                mChildren = null;
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.423 -0400", hash_original_method = "4F2E1E1D85BE3BBCABDE93BB1C6F5E02", hash_generated_method = "538CDA84750879A82CBFD555A3A5809F")
        @Override
        public Drawable newDrawable() {
Drawable varA80F74B52EAC520FF21BF628D3F68BF6_933268297 =             new LayerDrawable(this, null);
            varA80F74B52EAC520FF21BF628D3F68BF6_933268297.addTaint(taint);
            return varA80F74B52EAC520FF21BF628D3F68BF6_933268297;
            // ---------- Original Method ----------
            //return new LayerDrawable(this, null);
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.424 -0400", hash_original_method = "40E045186798A3567910482DC0B43DC7", hash_generated_method = "A290B76951FD05EEB28DAEECE2D28EC8")
        @Override
        public Drawable newDrawable(Resources res) {
            addTaint(res.getTaint());
Drawable var7F5C6E283EA30BC97CCB22A157315149_931532683 =             new LayerDrawable(this, res);
            var7F5C6E283EA30BC97CCB22A157315149_931532683.addTaint(taint);
            return var7F5C6E283EA30BC97CCB22A157315149_931532683;
            // ---------- Original Method ----------
            //return new LayerDrawable(this, res);
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.424 -0400", hash_original_method = "9E7D7C67EAC365FF19BD4971762612A5", hash_generated_method = "B1838943056AD0E7CB2D74F95B3077D6")
        @Override
        public int getChangingConfigurations() {
            int var276E0645C4E2084773D0EB8C5576428C_1053449093 = (mChangingConfigurations);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1964215363 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1964215363;
            // ---------- Original Method ----------
            //return mChangingConfigurations;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.425 -0400", hash_original_method = "C863EE1513D5FAC46B3A54079EE22BC7", hash_generated_method = "CB8BA5099B6FCB022EC1C1A8B779D499")
        public final int getOpacity() {
    if(mHaveOpacity)            
            {
                int var9D334A125EE4B3831821AB1264C029B9_2050388537 = (mOpacity);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_632234028 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_632234028;
            } //End block
            final int N = mNum;
            int op = N > 0 ? mChildren[0].mDrawable.getOpacity() : PixelFormat.TRANSPARENT;
for(int i = 1;i < N;i++)
            {
                op = Drawable.resolveOpacity(op, mChildren[i].mDrawable.getOpacity());
            } //End block
            mOpacity = op;
            mHaveOpacity = true;
            int var11D8C28A64490A987612F2332502467F_210053808 = (op);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1938939380 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1938939380;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.425 -0400", hash_original_method = "302772CF3A9A555DFD32DC83A81CA17A", hash_generated_method = "189DD1C9EEFD864114A9B6CF04A32CA6")
        public final boolean isStateful() {
    if(mHaveStateful)            
            {
                boolean var1819E5C118FDB6B2BF917A4481AE2A7A_1846467784 = (mStateful);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_987718552 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_987718552;
            } //End block
            boolean stateful = false;
            final int N = mNum;
for(int i = 0;i < N;i++)
            {
    if(mChildren[i].mDrawable.isStateful())                
                {
                    stateful = true;
                    break;
                } //End block
            } //End block
            mStateful = stateful;
            mHaveStateful = true;
            boolean varBAB19DD93081FB031211C4ABF44EA695_886485206 = (stateful);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1111757516 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1111757516;
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

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.426 -0400", hash_original_method = "08014AA1073210728E3D3AA9FAF026EA", hash_generated_method = "2824B6ABA52F255E843B43D934ED16EC")
        public synchronized boolean canConstantState() {
    if(!mCheckedConstantState && mChildren != null)            
            {
                mCanConstantState = true;
                final int N = mNum;
for(int i=0;i<N;i++)
                {
    if(mChildren[i].mDrawable.getConstantState() == null)                    
                    {
                        mCanConstantState = false;
                        break;
                    } //End block
                } //End block
                mCheckedConstantState = true;
            } //End block
            boolean var7C8FD9809F31C20B8422D623B0EC0C4F_1641181198 = (mCanConstantState);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_657970408 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_657970408;
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

