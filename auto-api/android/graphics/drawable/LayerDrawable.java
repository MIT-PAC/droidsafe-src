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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.841 -0400", hash_original_field = "FBD5C16B0695BD8A1AF4AF03C1997413", hash_generated_field = "053037057B7FC4B2D43393B0DA597B94")

    LayerState mLayerState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.841 -0400", hash_original_field = "64D0AA5B1A92A4FB50EC39F09F4A8C25", hash_generated_field = "DBD2988EAF133D76032F3EAD1CE10F00")

    private int mOpacityOverride = PixelFormat.UNKNOWN;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.841 -0400", hash_original_field = "BF28C32EB715E78C047B98E92C68020B", hash_generated_field = "7D03B5A878C9FF91EB46A7111D526D76")

    private int[] mPaddingL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.841 -0400", hash_original_field = "D31A5F208004A2B9A269CC61943D4147", hash_generated_field = "14F9B3A237223751479C6D3D809F2002")

    private int[] mPaddingT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.841 -0400", hash_original_field = "8DFC1DBDE04D51889801984C45C6BF2B", hash_generated_field = "9C76E5B4161411C12A357F3E6012EEB7")

    private int[] mPaddingR;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.841 -0400", hash_original_field = "E89E83B2ABB6BA176FA02FF51ED8A635", hash_generated_field = "9C3BE8A516D526DA1E4DFBF1EA68DB1D")

    private int[] mPaddingB;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.841 -0400", hash_original_field = "C16522492B0457D64CB22178541F3ACA", hash_generated_field = "A9D5B7D1068DC6DDDEE02560E993CCF6")

    private Rect mTmpRect = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.842 -0400", hash_original_field = "9FB80C30383848C8D006680B5F3BDAF9", hash_generated_field = "5CA5A1EF3CAA45117BCACBC34EF05952")

    private boolean mMutated;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.861 -0400", hash_original_method = "45431E38A045C0C983A2E1F24B9ACFC3", hash_generated_method = "4CE2708C4D9F71FB85D58CF9B25390F6")
    public  LayerDrawable(Drawable[] layers) {
        this(layers, null);
        addTaint(layers[0].getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.883 -0400", hash_original_method = "FF485081EB7D7D498FB9DCE337B88F15", hash_generated_method = "F42786CA8839C7A8BE6558A74909E033")
      LayerDrawable(Drawable[] layers, LayerState state) {
        this(state, null);
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
        addTaint(state.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.884 -0400", hash_original_method = "E2A4F408D4F72AC6B7199B314E863E72", hash_generated_method = "E5E998CAAF8ED85BF887873B15A40A8F")
      LayerDrawable() {
        this((LayerState) null, null);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.886 -0400", hash_original_method = "026CAD40EA728EE5D396C83F5E4D2B2B", hash_generated_method = "425CE1AAE7AE5CDED01591B11A322EFD")
      LayerDrawable(LayerState state, Resources res) {
        LayerState as;
        as = createConstantState(state, res);
        mLayerState = as;
        {
            ensurePadding();
        } //End block
        addTaint(state.getTaint());
        addTaint(res.getTaint());
        // ---------- Original Method ----------
        //LayerState as = createConstantState(state, res);
        //mLayerState = as;
        //if (as.mNum > 0) {
            //ensurePadding();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.891 -0400", hash_original_method = "7FB89ACAD944F734BBC3DF72F4EDEEB2", hash_generated_method = "204CE93EBC704C113E8F3AD3FCFDF33F")
     LayerState createConstantState(LayerState state, Resources res) {
        LayerState varB4EAC82CA7396A68D541C85D26508E83_1179830245 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1179830245 = new LayerState(state, this, res);
        addTaint(state.getTaint());
        addTaint(res.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1179830245.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1179830245;
        // ---------- Original Method ----------
        //return new LayerState(state, this, res);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.921 -0400", hash_original_method = "A154F132E6CF56E7598B71E5310AFACF", hash_generated_method = "D7E19A2174DB9789824AD5EBCAF90290")
    @Override
    public void inflate(Resources r, XmlPullParser parser, AttributeSet attrs) throws XmlPullParserException, IOException {
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
            boolean var29882DFEED643D3ED9626B373247FA72_873526430 = ((type = parser.next()) != XmlPullParser.END_DOCUMENT
                && ((depth = parser.getDepth()) >= innerDepth || type != XmlPullParser.END_TAG));
            {
                {
                    boolean var03C44ADC0346A0FD12ECFE38D2A0612F_446763182 = (depth > innerDepth || !parser.getName().equals("item"));
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
                        boolean var16E7483EB4C069010E58346DA2B7701B_1864878381 = ((type = parser.next()) == XmlPullParser.TEXT);
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
        addTaint(r.getTaint());
        addTaint(parser.getTaint());
        addTaint(attrs.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.929 -0400", hash_original_method = "F6995F9609496F6742CAB01EE3CD1860", hash_generated_method = "5F066AC4F42BD9D170224CDFD09C5F75")
    private void addLayer(Drawable layer, int id, int left, int top, int right, int bottom) {
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
        addTaint(id);
        addTaint(left);
        addTaint(top);
        addTaint(right);
        addTaint(bottom);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.960 -0400", hash_original_method = "C91DA5E408896EB69ADE8640201298D6", hash_generated_method = "011BCFC31F3299E6C62C2B064CC3365C")
    public Drawable findDrawableByLayerId(int id) {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_442160474 = null; //Variable for return #1
        Drawable varB4EAC82CA7396A68D541C85D26508E83_947106503 = null; //Variable for return #2
        ChildDrawable[] layers;
        layers = mLayerState.mChildren;
        {
            int i;
            i = mLayerState.mNum - 1;
            {
                {
                    varB4EAC82CA7396A68D541C85D26508E83_442160474 = layers[i].mDrawable;
                } //End block
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_947106503 = null;
        addTaint(id);
        Drawable varA7E53CE21691AB073D9660D615818899_2143114143; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2143114143 = varB4EAC82CA7396A68D541C85D26508E83_442160474;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2143114143 = varB4EAC82CA7396A68D541C85D26508E83_947106503;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2143114143.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2143114143;
        // ---------- Original Method ----------
        //final ChildDrawable[] layers = mLayerState.mChildren;
        //for (int i = mLayerState.mNum - 1; i >= 0; i--) {
            //if (layers[i].mId == id) {
                //return layers[i].mDrawable;
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.962 -0400", hash_original_method = "BFB89C99582071313F846F1C811CB3F0", hash_generated_method = "1FC88131F9D499108AE970D8E9987726")
    public void setId(int index, int id) {
        mLayerState.mChildren[index].mId = id;
        // ---------- Original Method ----------
        //mLayerState.mChildren[index].mId = id;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.962 -0400", hash_original_method = "A86CD78FFBAB297497BF089506C91B59", hash_generated_method = "37B21B3E607C4E4FA1B336D456FE9A87")
    public int getNumberOfLayers() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2098492662 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2098492662;
        // ---------- Original Method ----------
        //return mLayerState.mNum;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.981 -0400", hash_original_method = "34EED4495029B4FCBDB042C377184EB5", hash_generated_method = "280CD6FDA6A30CC4025DD98328D17BC6")
    public Drawable getDrawable(int index) {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_113293520 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_113293520 = mLayerState.mChildren[index].mDrawable;
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_113293520.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_113293520;
        // ---------- Original Method ----------
        //return mLayerState.mChildren[index].mDrawable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.982 -0400", hash_original_method = "AA527FDBA3D8F60360C6FC80FEEC74D7", hash_generated_method = "1F795A13DB8A1F532E8A17F8EFA98739")
    public int getId(int index) {
        addTaint(index);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_915119968 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_915119968;
        // ---------- Original Method ----------
        //return mLayerState.mChildren[index].mId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:15.985 -0400", hash_original_method = "6F9F1421DDD84B6DEFE7740341A590C2", hash_generated_method = "D0B3EEE1F6BAF230AED86A165C5C5977")
    public boolean setDrawableByLayerId(int id, Drawable drawable) {
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
        addTaint(id);
        addTaint(drawable.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1486596845 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1486596845;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.007 -0400", hash_original_method = "F7297B48CD52F9107957E141DF7BCBF2", hash_generated_method = "7912535AD81179216494E76116DC27C1")
    public void setLayerInset(int index, int l, int t, int r, int b) {
        ChildDrawable childDrawable;
        childDrawable = mLayerState.mChildren[index];
        childDrawable.mInsetL = l;
        childDrawable.mInsetT = t;
        childDrawable.mInsetR = r;
        childDrawable.mInsetB = b;
        addTaint(index);
        addTaint(l);
        addTaint(t);
        addTaint(r);
        addTaint(b);
        // ---------- Original Method ----------
        //ChildDrawable childDrawable = mLayerState.mChildren[index];
        //childDrawable.mInsetL = l;
        //childDrawable.mInsetT = t;
        //childDrawable.mInsetR = r;
        //childDrawable.mInsetB = b;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.008 -0400", hash_original_method = "289E4B14FC4BAEE8FBED5C03A1D9B634", hash_generated_method = "8C74E1ED724AA0C6A0C97462CE6BFB75")
    public void invalidateDrawable(Drawable who) {
        Callback callback;
        callback = getCallback();
        {
            callback.invalidateDrawable(this);
        } //End block
        addTaint(who.getTaint());
        // ---------- Original Method ----------
        //final Callback callback = getCallback();
        //if (callback != null) {
            //callback.invalidateDrawable(this);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.028 -0400", hash_original_method = "A01CAF97CFFAA14450A9600E14E88C8D", hash_generated_method = "D0BA170008FFB5E5F5CAA53137A69B81")
    public void scheduleDrawable(Drawable who, Runnable what, long when) {
        Callback callback;
        callback = getCallback();
        {
            callback.scheduleDrawable(this, what, when);
        } //End block
        addTaint(who.getTaint());
        addTaint(what.getTaint());
        addTaint(when);
        // ---------- Original Method ----------
        //final Callback callback = getCallback();
        //if (callback != null) {
            //callback.scheduleDrawable(this, what, when);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.028 -0400", hash_original_method = "CA144C86313E3C1A3DC044F014305D8E", hash_generated_method = "F27A8BA34D960AEC80EA06B1020FC534")
    public void unscheduleDrawable(Drawable who, Runnable what) {
        Callback callback;
        callback = getCallback();
        {
            callback.unscheduleDrawable(this, what);
        } //End block
        addTaint(who.getTaint());
        addTaint(what.getTaint());
        // ---------- Original Method ----------
        //final Callback callback = getCallback();
        //if (callback != null) {
            //callback.unscheduleDrawable(this, what);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.029 -0400", hash_original_method = "90444F7F92DF97CE38686D7CB679E4B0", hash_generated_method = "A0F6427B1FC599C12C29C569B67A3FBF")
    @Override
    public void draw(Canvas canvas) {
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
        addTaint(canvas.getTaint());
        // ---------- Original Method ----------
        //final ChildDrawable[] array = mLayerState.mChildren;
        //final int N = mLayerState.mNum;
        //for (int i=0; i<N; i++) {
            //array[i].mDrawable.draw(canvas);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.030 -0400", hash_original_method = "DA9EE8A6D973B1FAC6E24B2DB8F8E9C8", hash_generated_method = "33CB612A0FDA43B9304A8A1424B8B8C8")
    @Override
    public int getChangingConfigurations() {
        int var94E997B7BABC89CBE991E62DD288B5E5_594027631 = (super.getChangingConfigurations()
                | mLayerState.mChangingConfigurations
                | mLayerState.mChildrenChangingConfigurations);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_971182359 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_971182359;
        // ---------- Original Method ----------
        //return super.getChangingConfigurations()
                //| mLayerState.mChangingConfigurations
                //| mLayerState.mChildrenChangingConfigurations;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.045 -0400", hash_original_method = "3512A730E5F476B43F9CED59A7F53410", hash_generated_method = "1DDD87521742521CB93E8664FD6C19E4")
    @Override
    public boolean getPadding(Rect padding) {
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
        addTaint(padding.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1695669492 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1695669492;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.058 -0400", hash_original_method = "DD7D852A8B2359532D654CFF5E5A109F", hash_generated_method = "272F0D7DD2B86107A2CCA975DE344739")
    @Override
    public boolean setVisible(boolean visible, boolean restart) {
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
        addTaint(visible);
        addTaint(restart);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1034111020 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1034111020;
        // ---------- Original Method ----------
        //boolean changed = super.setVisible(visible, restart);
        //final ChildDrawable[] array = mLayerState.mChildren;
        //final int N = mLayerState.mNum;
        //for (int i=0; i<N; i++) {
            //array[i].mDrawable.setVisible(visible, restart);
        //}
        //return changed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.060 -0400", hash_original_method = "8B5179F0E6CCC56A1CD26C355EB4BEE6", hash_generated_method = "87B066CF9D1E1A1B4344F9D234B417A3")
    @Override
    public void setDither(boolean dither) {
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
        addTaint(dither);
        // ---------- Original Method ----------
        //final ChildDrawable[] array = mLayerState.mChildren;
        //final int N = mLayerState.mNum;
        //for (int i=0; i<N; i++) {
            //array[i].mDrawable.setDither(dither);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.075 -0400", hash_original_method = "A4F4B2E3C1F4B490E6EEA73C8E0E0B9C", hash_generated_method = "E959DAF98330F482C0807608D6719875")
    @Override
    public void setAlpha(int alpha) {
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
        addTaint(alpha);
        // ---------- Original Method ----------
        //final ChildDrawable[] array = mLayerState.mChildren;
        //final int N = mLayerState.mNum;
        //for (int i=0; i<N; i++) {
            //array[i].mDrawable.setAlpha(alpha);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.077 -0400", hash_original_method = "6285AEA72EA88CCBF849BD62BDD654E0", hash_generated_method = "2F09697F3DE998596B5E89B5CFD124E6")
    @Override
    public void setColorFilter(ColorFilter cf) {
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
        addTaint(cf.getTaint());
        // ---------- Original Method ----------
        //final ChildDrawable[] array = mLayerState.mChildren;
        //final int N = mLayerState.mNum;
        //for (int i=0; i<N; i++) {
            //array[i].mDrawable.setColorFilter(cf);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.077 -0400", hash_original_method = "3DEB6D6A50B9757568C5AA3089CD04F9", hash_generated_method = "2F8A5119D378716275841296882C6D16")
    public void setOpacity(int opacity) {
        mOpacityOverride = opacity;
        // ---------- Original Method ----------
        //mOpacityOverride = opacity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.098 -0400", hash_original_method = "0508714C8593107EE12E4CBB1654E530", hash_generated_method = "468829994BA21E172CAABEA56AC0E264")
    @Override
    public int getOpacity() {
        int varD6827E07AD7762A3605B5A714D1400AE_570049060 = (mLayerState.getOpacity());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1599000716 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1599000716;
        // ---------- Original Method ----------
        //if (mOpacityOverride != PixelFormat.UNKNOWN) {
            //return mOpacityOverride;
        //}
        //return mLayerState.getOpacity();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.123 -0400", hash_original_method = "A7862898530225600FCD0A08ADBB8B8E", hash_generated_method = "2B265B309C59F3A6BB1F73550B018E10")
    @Override
    public boolean isStateful() {
        boolean var7FB81E6690C2D4B1B0588FD6EA772E2A_1115459390 = (mLayerState.isStateful());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1125629477 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1125629477;
        // ---------- Original Method ----------
        //return mLayerState.isStateful();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.134 -0400", hash_original_method = "60327578E5414A54A8EE74C8FEF7053B", hash_generated_method = "64EA5941921C307197DA565B294467D1")
    @Override
    protected boolean onStateChange(int[] state) {
        //DSFIXME:  CODE0009: Possible callback target function detected
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
                    boolean var28C3FE43CBFFD13DBC487F1C9FC17892_1445208449 = (r.mDrawable.setState(state));
                    {
                        changed = true;
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean varE196B975D181BB501FFE1FB7B49F0254_1626299277 = (reapplyPadding(i, r));
                    {
                        paddingChanged = true;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            onBoundsChange(getBounds());
        } //End block
        addTaint(state[0]);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_331063636 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_331063636;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.135 -0400", hash_original_method = "195FB5A6CB4D5D3918E98BB126BE1FA4", hash_generated_method = "6BF02AC8615902E532813BB2467E8EEB")
    @Override
    protected boolean onLevelChange(int level) {
        //DSFIXME:  CODE0009: Possible callback target function detected
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
                    boolean varC494E60E0690DBADDE841F49E823D0E9_1079281264 = (r.mDrawable.setLevel(level));
                    {
                        changed = true;
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean varE196B975D181BB501FFE1FB7B49F0254_719342422 = (reapplyPadding(i, r));
                    {
                        paddingChanged = true;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            onBoundsChange(getBounds());
        } //End block
        addTaint(level);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1323538159 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1323538159;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.140 -0400", hash_original_method = "7AEE775ACF9989A4B743B4884BF6DFAF", hash_generated_method = "110DAEED39A5D2BE8B1B062D044D399E")
    @Override
    protected void onBoundsChange(Rect bounds) {
        //DSFIXME:  CODE0009: Possible callback target function detected
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
        addTaint(bounds.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.155 -0400", hash_original_method = "3C77AAA6434E318933C50BFE3151E79D", hash_generated_method = "047C938128FA2B0112E6384D0A545910")
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
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_828462899 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_828462899;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.157 -0400", hash_original_method = "74944E4C19D1A88AACA0D7D60A83587A", hash_generated_method = "21429E43D539C20DE1A59BF856C24247")
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
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1180089799 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1180089799;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.185 -0400", hash_original_method = "41F739441798A70C5E037E0F4FC43A10", hash_generated_method = "F0BD58153A31D34488FBFCE6C313022B")
    private boolean reapplyPadding(int i, ChildDrawable r) {
        Rect rect;
        rect = mTmpRect;
        r.mDrawable.getPadding(rect);
        {
            mPaddingL[i] = rect.left;
            mPaddingT[i] = rect.top;
            mPaddingR[i] = rect.right;
            mPaddingB[i] = rect.bottom;
        } //End block
        addTaint(r.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_544700018 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_544700018;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.187 -0400", hash_original_method = "6FB87F17A7189073B9E72073B203E52E", hash_generated_method = "7949B96519D51AC26DF51E28E78D63CA")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.191 -0400", hash_original_method = "42E9B0CF062F666EDFF40D08B19E7027", hash_generated_method = "11E465C196F4C7B58CBB393BA7F4A397")
    @Override
    public ConstantState getConstantState() {
        ConstantState varB4EAC82CA7396A68D541C85D26508E83_185071452 = null; //Variable for return #1
        ConstantState varB4EAC82CA7396A68D541C85D26508E83_1488298834 = null; //Variable for return #2
        {
            boolean var1F0836AB1F03D8B5BBF83BA5D084A360_99749721 = (mLayerState.canConstantState());
            {
                mLayerState.mChangingConfigurations = getChangingConfigurations();
                varB4EAC82CA7396A68D541C85D26508E83_185071452 = mLayerState;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1488298834 = null;
        ConstantState varA7E53CE21691AB073D9660D615818899_553015073; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_553015073 = varB4EAC82CA7396A68D541C85D26508E83_185071452;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_553015073 = varB4EAC82CA7396A68D541C85D26508E83_1488298834;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_553015073.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_553015073;
        // ---------- Original Method ----------
        //if (mLayerState.canConstantState()) {
            //mLayerState.mChangingConfigurations = getChangingConfigurations();
            //return mLayerState;
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.212 -0400", hash_original_method = "B6649BA0234C5F68B98BE9A7636194EF", hash_generated_method = "0455D818A4F85B15B67EB7FDB8CDBC41")
    @Override
    public Drawable mutate() {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_898704648 = null; //Variable for return #1
        {
            boolean varC94B19053599294E7944C8C841976773_639484760 = (!mMutated && super.mutate() == this);
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
        varB4EAC82CA7396A68D541C85D26508E83_898704648 = this;
        varB4EAC82CA7396A68D541C85D26508E83_898704648.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_898704648;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.213 -0400", hash_original_field = "D548B27C6AC66A9D9B5D05ED35C2D844", hash_generated_field = "36D39E5803890ED250A80FAD100C4ED7")

        public Drawable mDrawable;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.213 -0400", hash_original_field = "84CB0C1DC38731A850F792E2FDB6B39B", hash_generated_field = "41EDDF00F18395AB4E75D54F56DCEAD6")

        public int mInsetL;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.213 -0400", hash_original_field = "FE98DF02B3531CCEEC8254EA7A40D8C2", hash_generated_field = "B7AF8366A6A319CDAA60A9C0D750F631")

        public int mInsetT;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.213 -0400", hash_original_field = "98714B51BF834824DA4A4A1ACF3D4447", hash_generated_field = "EC3C187375874F66EE15413DF92F4E1E")

        public int mInsetR;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.213 -0400", hash_original_field = "10B9A7B0EF30FDBEDF74FE05E0046827", hash_generated_field = "29277012246F0EA1CDF311942F6EA725")

        public int mInsetB;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.213 -0400", hash_original_field = "6AC7F06B6413A1BE9C136DC7DF0D2B60", hash_generated_field = "47CDACD56606F02DFA218FC210EFC0FF")

        public int mId;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.213 -0400", hash_original_method = "6CD909B986D24A0F6BAFA410E280EBB3", hash_generated_method = "6CD909B986D24A0F6BAFA410E280EBB3")
        public ChildDrawable ()
        {
            //Synthesized constructor
        }


    }


    
    static class LayerState extends ConstantState {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.213 -0400", hash_original_field = "1B2924E0CDC894FEA7E3856870275E70", hash_generated_field = "95F99CF2E70DB79AD069A36B506646F2")

        int mNum;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.214 -0400", hash_original_field = "6699FE97ED54C04992AEDA784C483D4D", hash_generated_field = "5D63B0C69B8E94415B4820B44C747438")

        ChildDrawable[] mChildren;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.214 -0400", hash_original_field = "276E0645C4E2084773D0EB8C5576428C", hash_generated_field = "9BFAF00848476277D36D9BA586984BA7")

        int mChangingConfigurations;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.214 -0400", hash_original_field = "8755A6790E0FAEFCC765046FF423478D", hash_generated_field = "E8F7332658D4B8911B8427F9E33AC9BD")

        int mChildrenChangingConfigurations;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.214 -0400", hash_original_field = "B8FE7B1D7EF53BE4167C040A5FEB7CC7", hash_generated_field = "A98F79115AB3FA98F1F7245A604A5EC2")

        private boolean mHaveOpacity = false;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.214 -0400", hash_original_field = "9D334A125EE4B3831821AB1264C029B9", hash_generated_field = "05E7E4BE80B060037CF88AC66652FF58")

        private int mOpacity;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.214 -0400", hash_original_field = "0AB968E9E6651BF0E687DAF7846B214C", hash_generated_field = "C74F5EDB4E2A4B07698A864146958E40")

        private boolean mHaveStateful = false;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.214 -0400", hash_original_field = "1819E5C118FDB6B2BF917A4481AE2A7A", hash_generated_field = "6747C1011A591FA368B1D4C99D94E670")

        private boolean mStateful;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.214 -0400", hash_original_field = "2E319D4D352B34E33CF19129B7212FC6", hash_generated_field = "63D49323436A33301C0DA6EDF88627FF")

        private boolean mCheckedConstantState;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.214 -0400", hash_original_field = "7C8FD9809F31C20B8422D623B0EC0C4F", hash_generated_field = "F62F8D22C4EDE8B8E63C376677BD915C")

        private boolean mCanConstantState;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.239 -0400", hash_original_method = "BD826615A7A8424D072A11138F67C8D8", hash_generated_method = "C6A147BA615312846DBE1D043FE8F947")
          LayerState(LayerState orig, LayerDrawable owner, Resources res) {
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
            addTaint(owner.getTaint());
            addTaint(res.getTaint());
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.240 -0400", hash_original_method = "4F2E1E1D85BE3BBCABDE93BB1C6F5E02", hash_generated_method = "52D6EEE3AD179686745E4D5A46490BAC")
        @Override
        public Drawable newDrawable() {
            Drawable varB4EAC82CA7396A68D541C85D26508E83_790188530 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_790188530 = new LayerDrawable(this, null);
            varB4EAC82CA7396A68D541C85D26508E83_790188530.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_790188530;
            // ---------- Original Method ----------
            //return new LayerDrawable(this, null);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.240 -0400", hash_original_method = "40E045186798A3567910482DC0B43DC7", hash_generated_method = "8AA82E94F40C0627C16D93D5667E8FD0")
        @Override
        public Drawable newDrawable(Resources res) {
            Drawable varB4EAC82CA7396A68D541C85D26508E83_1981742374 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1981742374 = new LayerDrawable(this, res);
            addTaint(res.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1981742374.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1981742374;
            // ---------- Original Method ----------
            //return new LayerDrawable(this, res);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.247 -0400", hash_original_method = "9E7D7C67EAC365FF19BD4971762612A5", hash_generated_method = "49EE254DDBAD35624F8A3BFEBC25B787")
        @Override
        public int getChangingConfigurations() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_879273242 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_879273242;
            // ---------- Original Method ----------
            //return mChangingConfigurations;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.250 -0400", hash_original_method = "C863EE1513D5FAC46B3A54079EE22BC7", hash_generated_method = "7FD5C5DC98D7A2A80B49D21FB81AAEEE")
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
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_721637816 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_721637816;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.373 -0400", hash_original_method = "302772CF3A9A555DFD32DC83A81CA17A", hash_generated_method = "7A5B2DAE537A92851E083DEDD9598B28")
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
                        boolean varCC50B7DB73A9F6C5D752EC13C92CDF20_1309940248 = (mChildren[i].mDrawable.isStateful());
                        {
                            stateful = true;
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            mStateful = stateful;
            mHaveStateful = true;
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_936001324 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_936001324;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.384 -0400", hash_original_method = "08014AA1073210728E3D3AA9FAF026EA", hash_generated_method = "F33D152AE78CED3E7DA1657F49BD8DFB")
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
                            boolean var72A78A7292B72B8D1D41A0BF5E2460B4_732125295 = (mChildren[i].mDrawable.getConstantState() == null);
                            {
                                mCanConstantState = false;
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
                mCheckedConstantState = true;
            } //End block
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1504251788 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1504251788;
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

