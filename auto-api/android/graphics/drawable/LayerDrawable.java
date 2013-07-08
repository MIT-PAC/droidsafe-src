package android.graphics.drawable;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.252 -0400", hash_original_field = "FBD5C16B0695BD8A1AF4AF03C1997413", hash_generated_field = "053037057B7FC4B2D43393B0DA597B94")

    LayerState mLayerState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.252 -0400", hash_original_field = "64D0AA5B1A92A4FB50EC39F09F4A8C25", hash_generated_field = "DBD2988EAF133D76032F3EAD1CE10F00")

    private int mOpacityOverride = PixelFormat.UNKNOWN;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.252 -0400", hash_original_field = "BF28C32EB715E78C047B98E92C68020B", hash_generated_field = "7D03B5A878C9FF91EB46A7111D526D76")

    private int[] mPaddingL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.252 -0400", hash_original_field = "D31A5F208004A2B9A269CC61943D4147", hash_generated_field = "14F9B3A237223751479C6D3D809F2002")

    private int[] mPaddingT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.252 -0400", hash_original_field = "8DFC1DBDE04D51889801984C45C6BF2B", hash_generated_field = "9C76E5B4161411C12A357F3E6012EEB7")

    private int[] mPaddingR;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.252 -0400", hash_original_field = "E89E83B2ABB6BA176FA02FF51ED8A635", hash_generated_field = "9C3BE8A516D526DA1E4DFBF1EA68DB1D")

    private int[] mPaddingB;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.252 -0400", hash_original_field = "C16522492B0457D64CB22178541F3ACA", hash_generated_field = "570061BA9CB059462550E9BCCD2A0735")

    private final Rect mTmpRect = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.252 -0400", hash_original_field = "9FB80C30383848C8D006680B5F3BDAF9", hash_generated_field = "5CA5A1EF3CAA45117BCACBC34EF05952")

    private boolean mMutated;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.253 -0400", hash_original_method = "45431E38A045C0C983A2E1F24B9ACFC3", hash_generated_method = "4CE2708C4D9F71FB85D58CF9B25390F6")
    public  LayerDrawable(Drawable[] layers) {
        this(layers, null);
        addTaint(layers[0].getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.253 -0400", hash_original_method = "FF485081EB7D7D498FB9DCE337B88F15", hash_generated_method = "D8EE426A9B33DCD49B890D96E99BDF99")
      LayerDrawable(Drawable[] layers, LayerState state) {
        this(state, null);
        int length = layers.length;
        ChildDrawable[] r = new ChildDrawable[length];
        {
            int i = 0;
            {
                r[i] = new ChildDrawable();
                r[i].mDrawable = layers[i];
                layers[i].setCallback(this);
                mLayerState.mChildrenChangingConfigurations |= layers[i].getChangingConfigurations();
            } 
        } 
        mLayerState.mNum = length;
        mLayerState.mChildren = r;
        ensurePadding();
        addTaint(state.getTaint());
        
        
        
        
            
            
            
            
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.254 -0400", hash_original_method = "E2A4F408D4F72AC6B7199B314E863E72", hash_generated_method = "E5E998CAAF8ED85BF887873B15A40A8F")
      LayerDrawable() {
        this((LayerState) null, null);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.254 -0400", hash_original_method = "026CAD40EA728EE5D396C83F5E4D2B2B", hash_generated_method = "31BACC40DB9EED291D8355A4C404FB7E")
      LayerDrawable(LayerState state, Resources res) {
        LayerState as = createConstantState(state, res);
        mLayerState = as;
        {
            ensurePadding();
        } 
        addTaint(state.getTaint());
        addTaint(res.getTaint());
        
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.256 -0400", hash_original_method = "7FB89ACAD944F734BBC3DF72F4EDEEB2", hash_generated_method = "238FEE12D1AB1BDE90F5D3C10B298D96")
     LayerState createConstantState(LayerState state, Resources res) {
        LayerState varB4EAC82CA7396A68D541C85D26508E83_1650700660 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1650700660 = new LayerState(state, this, res);
        addTaint(state.getTaint());
        addTaint(res.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1650700660.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1650700660;
        
        
    }

    
    @DSModeled(DSC.SAFE)
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
        int depth = 0;
        {
            boolean var29882DFEED643D3ED9626B373247FA72_873526430 = ((type = parser.next()) != XmlPullParser.END_DOCUMENT
                && ((depth = parser.getDepth()) >= innerDepth || type != XmlPullParser.END_TAG));
            {
                {
                    boolean var03C44ADC0346A0FD12ECFE38D2A0612F_446763182 = (depth > innerDepth || !parser.getName().equals("item"));
                } 
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
                } 
                {
                    {
                        boolean var16E7483EB4C069010E58346DA2B7701B_1864878381 = ((type = parser.next()) == XmlPullParser.TEXT);
                    } 
                    {
                        if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException(parser.getPositionDescription()
                            + ": <item> tag requires a 'drawable' attribute or "
                            + "child tag defining a drawable");
                    } 
                    dr = Drawable.createFromXmlInner(r, parser, attrs);
                } 
                addLayer(dr, id, left, top, right, bottom);
            } 
        } 
        ensurePadding();
        onStateChange(getState());
        addTaint(r.getTaint());
        addTaint(parser.getTaint());
        addTaint(attrs.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.257 -0400", hash_original_method = "F6995F9609496F6742CAB01EE3CD1860", hash_generated_method = "DFE819F715CC01FCD1DD7063CB97F7E3")
    private void addLayer(Drawable layer, int id, int left, int top, int right, int bottom) {
        final LayerState st = mLayerState;
        int N;
        N = st.mChildren.length;
        N = 0;
        int i = st.mNum;
        {
            ChildDrawable[] nu = new ChildDrawable[N + 10];
            {
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
        layer.setCallback(this);
        addTaint(id);
        addTaint(left);
        addTaint(top);
        addTaint(right);
        addTaint(bottom);
        
        
        
        
        
            
            
                
            
            
        
        
        
        
        
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.258 -0400", hash_original_method = "C91DA5E408896EB69ADE8640201298D6", hash_generated_method = "C3DB05B207C9F30236079236FF1AF6E9")
    public Drawable findDrawableByLayerId(int id) {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_993300394 = null; 
        Drawable varB4EAC82CA7396A68D541C85D26508E83_935655588 = null; 
        final ChildDrawable[] layers = mLayerState.mChildren;
        {
            int i = mLayerState.mNum - 1;
            {
                {
                    varB4EAC82CA7396A68D541C85D26508E83_993300394 = layers[i].mDrawable;
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_935655588 = null;
        addTaint(id);
        Drawable varA7E53CE21691AB073D9660D615818899_590440299; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_590440299 = varB4EAC82CA7396A68D541C85D26508E83_993300394;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_590440299 = varB4EAC82CA7396A68D541C85D26508E83_935655588;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_590440299.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_590440299;
        
        
        
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.258 -0400", hash_original_method = "BFB89C99582071313F846F1C811CB3F0", hash_generated_method = "1FC88131F9D499108AE970D8E9987726")
    public void setId(int index, int id) {
        mLayerState.mChildren[index].mId = id;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.259 -0400", hash_original_method = "A86CD78FFBAB297497BF089506C91B59", hash_generated_method = "627E12044CC5E730C2859687E5A24EB1")
    public int getNumberOfLayers() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_317627001 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_317627001;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.265 -0400", hash_original_method = "34EED4495029B4FCBDB042C377184EB5", hash_generated_method = "3DD708997043D82B920385B4E394EBD6")
    public Drawable getDrawable(int index) {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_1873795906 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1873795906 = mLayerState.mChildren[index].mDrawable;
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_1873795906.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1873795906;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.270 -0400", hash_original_method = "AA527FDBA3D8F60360C6FC80FEEC74D7", hash_generated_method = "6BDD99A479059C9C0F5F6E0F1F49B059")
    public int getId(int index) {
        addTaint(index);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_919169879 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_919169879;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.271 -0400", hash_original_method = "6F9F1421DDD84B6DEFE7740341A590C2", hash_generated_method = "503A5088CF1C047FE7CB51D858CEE535")
    public boolean setDrawableByLayerId(int id, Drawable drawable) {
        final ChildDrawable[] layers = mLayerState.mChildren;
        {
            int i = mLayerState.mNum - 1;
            {
                {
                    {
                        {
                            Rect bounds = layers[i].mDrawable.getBounds();
                            drawable.setBounds(bounds);
                        } 
                        layers[i].mDrawable.setCallback(null);
                    } 
                    {
                        drawable.setCallback(this);
                    } 
                    layers[i].mDrawable = drawable;
                } 
            } 
        } 
        addTaint(id);
        addTaint(drawable.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_387069736 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_387069736;
        
        
        
            
                
                    
                        
                        
                    
                    
                
                
                    
                
                
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.271 -0400", hash_original_method = "F7297B48CD52F9107957E141DF7BCBF2", hash_generated_method = "BAFDFCDE73A0A595766EAB20E7D1334C")
    public void setLayerInset(int index, int l, int t, int r, int b) {
        ChildDrawable childDrawable = mLayerState.mChildren[index];
        childDrawable.mInsetL = l;
        childDrawable.mInsetT = t;
        childDrawable.mInsetR = r;
        childDrawable.mInsetB = b;
        addTaint(index);
        addTaint(l);
        addTaint(t);
        addTaint(r);
        addTaint(b);
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.272 -0400", hash_original_method = "289E4B14FC4BAEE8FBED5C03A1D9B634", hash_generated_method = "8ECAF0D2D820C2FF9A9BDD02B639272A")
    public void invalidateDrawable(Drawable who) {
        final Callback callback = getCallback();
        {
            callback.invalidateDrawable(this);
        } 
        addTaint(who.getTaint());
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.274 -0400", hash_original_method = "A01CAF97CFFAA14450A9600E14E88C8D", hash_generated_method = "261415614362F98B81BBEF59F2B1EFAD")
    public void scheduleDrawable(Drawable who, Runnable what, long when) {
        final Callback callback = getCallback();
        {
            callback.scheduleDrawable(this, what, when);
        } 
        addTaint(who.getTaint());
        addTaint(what.getTaint());
        addTaint(when);
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.274 -0400", hash_original_method = "CA144C86313E3C1A3DC044F014305D8E", hash_generated_method = "A952BE855FAD5CA31947C201D24F3FD9")
    public void unscheduleDrawable(Drawable who, Runnable what) {
        final Callback callback = getCallback();
        {
            callback.unscheduleDrawable(this, what);
        } 
        addTaint(who.getTaint());
        addTaint(what.getTaint());
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.275 -0400", hash_original_method = "90444F7F92DF97CE38686D7CB679E4B0", hash_generated_method = "161E05173074550F74BB82774E119642")
    @Override
    public void draw(Canvas canvas) {
        final ChildDrawable[] array = mLayerState.mChildren;
        final int N = mLayerState.mNum;
        {
            int i = 0;
            {
                array[i].mDrawable.draw(canvas);
            } 
        } 
        addTaint(canvas.getTaint());
        
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.275 -0400", hash_original_method = "DA9EE8A6D973B1FAC6E24B2DB8F8E9C8", hash_generated_method = "DF3166058B70E4F95D661AD3E08FF6F6")
    @Override
    public int getChangingConfigurations() {
        int var94E997B7BABC89CBE991E62DD288B5E5_431672408 = (super.getChangingConfigurations()
                | mLayerState.mChangingConfigurations
                | mLayerState.mChildrenChangingConfigurations);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1123869006 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1123869006;
        
        
                
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.276 -0400", hash_original_method = "3512A730E5F476B43F9CED59A7F53410", hash_generated_method = "CDD6875C8D9C80E30020F82A40413393")
    @Override
    public boolean getPadding(Rect padding) {
        padding.left = 0;
        padding.top = 0;
        padding.right = 0;
        padding.bottom = 0;
        final ChildDrawable[] array = mLayerState.mChildren;
        final int N = mLayerState.mNum;
        {
            int i = 0;
            {
                reapplyPadding(i, array[i]);
                padding.left += mPaddingL[i];
                padding.top += mPaddingT[i];
                padding.right += mPaddingR[i];
                padding.bottom += mPaddingB[i];
            } 
        } 
        addTaint(padding.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1423613019 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1423613019;
        
        
        
        
        
        
        
        
            
            
            
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.276 -0400", hash_original_method = "DD7D852A8B2359532D654CFF5E5A109F", hash_generated_method = "9286E57EC594989BA19F40D833A2DA86")
    @Override
    public boolean setVisible(boolean visible, boolean restart) {
        boolean changed = super.setVisible(visible, restart);
        final ChildDrawable[] array = mLayerState.mChildren;
        final int N = mLayerState.mNum;
        {
            int i = 0;
            {
                array[i].mDrawable.setVisible(visible, restart);
            } 
        } 
        addTaint(visible);
        addTaint(restart);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_332701856 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_332701856;
        
        
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.277 -0400", hash_original_method = "8B5179F0E6CCC56A1CD26C355EB4BEE6", hash_generated_method = "7E76E26148947FAC90B26C85166596B8")
    @Override
    public void setDither(boolean dither) {
        final ChildDrawable[] array = mLayerState.mChildren;
        final int N = mLayerState.mNum;
        {
            int i = 0;
            {
                array[i].mDrawable.setDither(dither);
            } 
        } 
        addTaint(dither);
        
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.278 -0400", hash_original_method = "A4F4B2E3C1F4B490E6EEA73C8E0E0B9C", hash_generated_method = "48EE8FE09848324B53DD06368EDAD5DF")
    @Override
    public void setAlpha(int alpha) {
        final ChildDrawable[] array = mLayerState.mChildren;
        final int N = mLayerState.mNum;
        {
            int i = 0;
            {
                array[i].mDrawable.setAlpha(alpha);
            } 
        } 
        addTaint(alpha);
        
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.278 -0400", hash_original_method = "6285AEA72EA88CCBF849BD62BDD654E0", hash_generated_method = "F0BF50C5B899A2EF391C309806FE7323")
    @Override
    public void setColorFilter(ColorFilter cf) {
        final ChildDrawable[] array = mLayerState.mChildren;
        final int N = mLayerState.mNum;
        {
            int i = 0;
            {
                array[i].mDrawable.setColorFilter(cf);
            } 
        } 
        addTaint(cf.getTaint());
        
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.279 -0400", hash_original_method = "3DEB6D6A50B9757568C5AA3089CD04F9", hash_generated_method = "2F8A5119D378716275841296882C6D16")
    public void setOpacity(int opacity) {
        mOpacityOverride = opacity;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.279 -0400", hash_original_method = "0508714C8593107EE12E4CBB1654E530", hash_generated_method = "E3E87A8455A8F0D1FC0832D0EFF5B606")
    @Override
    public int getOpacity() {
        int varD6827E07AD7762A3605B5A714D1400AE_411478539 = (mLayerState.getOpacity());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1735462133 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1735462133;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.281 -0400", hash_original_method = "A7862898530225600FCD0A08ADBB8B8E", hash_generated_method = "219BF8DB8F9B8D35C07489994E7C1E77")
    @Override
    public boolean isStateful() {
        boolean var7FB81E6690C2D4B1B0588FD6EA772E2A_2141849155 = (mLayerState.isStateful());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_58623493 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_58623493;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.282 -0400", hash_original_method = "60327578E5414A54A8EE74C8FEF7053B", hash_generated_method = "9FEB8C8D587FF32E56ACEE20F7BAB3CB")
    @Override
    protected boolean onStateChange(int[] state) {
        
        final ChildDrawable[] array = mLayerState.mChildren;
        final int N = mLayerState.mNum;
        boolean paddingChanged = false;
        boolean changed = false;
        {
            int i = 0;
            {
                final ChildDrawable r = array[i];
                {
                    boolean var28C3FE43CBFFD13DBC487F1C9FC17892_583487808 = (r.mDrawable.setState(state));
                    {
                        changed = true;
                    } 
                } 
                {
                    boolean varE196B975D181BB501FFE1FB7B49F0254_1173601430 = (reapplyPadding(i, r));
                    {
                        paddingChanged = true;
                    } 
                } 
            } 
        } 
        {
            onBoundsChange(getBounds());
        } 
        addTaint(state[0]);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_463901817 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_463901817;
        
        
        
        
        
        
            
            
                
            
            
                
            
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.282 -0400", hash_original_method = "195FB5A6CB4D5D3918E98BB126BE1FA4", hash_generated_method = "D8C699013E79339691114F4051005FE7")
    @Override
    protected boolean onLevelChange(int level) {
        
        final ChildDrawable[] array = mLayerState.mChildren;
        final int N = mLayerState.mNum;
        boolean paddingChanged = false;
        boolean changed = false;
        {
            int i = 0;
            {
                final ChildDrawable r = array[i];
                {
                    boolean varC494E60E0690DBADDE841F49E823D0E9_1158147829 = (r.mDrawable.setLevel(level));
                    {
                        changed = true;
                    } 
                } 
                {
                    boolean varE196B975D181BB501FFE1FB7B49F0254_734328483 = (reapplyPadding(i, r));
                    {
                        paddingChanged = true;
                    } 
                } 
            } 
        } 
        {
            onBoundsChange(getBounds());
        } 
        addTaint(level);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_415443756 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_415443756;
        
        
        
        
        
        
            
            
                
            
            
                
            
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.283 -0400", hash_original_method = "7AEE775ACF9989A4B743B4884BF6DFAF", hash_generated_method = "0CA2A082B93EBB0587FFBF17C5FD6C4F")
    @Override
    protected void onBoundsChange(Rect bounds) {
        
        final ChildDrawable[] array = mLayerState.mChildren;
        final int N = mLayerState.mNum;
        int padL = 0;
        int padT = 0;
        int padR = 0;
        int padB = 0;
        {
            int i = 0;
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
            } 
        } 
        addTaint(bounds.getTaint());
        
        
        
        
        
            
            
                                  
                                  
                                  
            
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.284 -0400", hash_original_method = "3C77AAA6434E318933C50BFE3151E79D", hash_generated_method = "0F22269BF82256947B355F484E6E49D5")
    @Override
    public int getIntrinsicWidth() {
        int width = -1;
        final ChildDrawable[] array = mLayerState.mChildren;
        final int N = mLayerState.mNum;
        int padL = 0;
        int padR = 0;
        {
            int i = 0;
            {
                final ChildDrawable r = array[i];
                int w = r.mDrawable.getIntrinsicWidth()
                  + r.mInsetL + r.mInsetR + padL + padR;
                {
                    width = w;
                } 
                padL += mPaddingL[i];
                padR += mPaddingR[i];
            } 
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1738469506 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1738469506;
        
        
        
        
        
        
            
            
                  
            
                
            
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.284 -0400", hash_original_method = "74944E4C19D1A88AACA0D7D60A83587A", hash_generated_method = "C11D2FBE7203190AB060A97BF3F5B073")
    @Override
    public int getIntrinsicHeight() {
        int height = -1;
        final ChildDrawable[] array = mLayerState.mChildren;
        final int N = mLayerState.mNum;
        int padT = 0;
        int padB = 0;
        {
            int i = 0;
            {
                final ChildDrawable r = array[i];
                int h = r.mDrawable.getIntrinsicHeight() + r.mInsetT + r.mInsetB + + padT + padB;
                {
                    height = h;
                } 
                padT += mPaddingT[i];
                padB += mPaddingB[i];
            } 
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1651736273 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1651736273;
        
        
        
        
        
        
            
            
            
                
            
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.285 -0400", hash_original_method = "41F739441798A70C5E037E0F4FC43A10", hash_generated_method = "1ECF69E7DB62D7F51DDDF65A80D089D1")
    private boolean reapplyPadding(int i, ChildDrawable r) {
        final Rect rect = mTmpRect;
        r.mDrawable.getPadding(rect);
        {
            mPaddingL[i] = rect.left;
            mPaddingT[i] = rect.top;
            mPaddingR[i] = rect.right;
            mPaddingB[i] = rect.bottom;
        } 
        addTaint(r.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_470592646 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_470592646;
        
        
        
        
                
            
            
            
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.285 -0400", hash_original_method = "6FB87F17A7189073B9E72073B203E52E", hash_generated_method = "59BBA7D2300D061C6F2456B32A326F99")
    private void ensurePadding() {
        final int N = mLayerState.mNum;
        mPaddingL = new int[N];
        mPaddingT = new int[N];
        mPaddingR = new int[N];
        mPaddingB = new int[N];
        
        
        
            
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.290 -0400", hash_original_method = "42E9B0CF062F666EDFF40D08B19E7027", hash_generated_method = "5187D602DAAF9980D55081B81ECF20EA")
    @Override
    public ConstantState getConstantState() {
        ConstantState varB4EAC82CA7396A68D541C85D26508E83_511969463 = null; 
        ConstantState varB4EAC82CA7396A68D541C85D26508E83_954523525 = null; 
        {
            boolean var1F0836AB1F03D8B5BBF83BA5D084A360_1504667021 = (mLayerState.canConstantState());
            {
                mLayerState.mChangingConfigurations = getChangingConfigurations();
                varB4EAC82CA7396A68D541C85D26508E83_511969463 = mLayerState;
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_954523525 = null;
        ConstantState varA7E53CE21691AB073D9660D615818899_399739344; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_399739344 = varB4EAC82CA7396A68D541C85D26508E83_511969463;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_399739344 = varB4EAC82CA7396A68D541C85D26508E83_954523525;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_399739344.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_399739344;
        
        
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.291 -0400", hash_original_method = "B6649BA0234C5F68B98BE9A7636194EF", hash_generated_method = "8312CDBD92D2F52549458E7221B5FA7C")
    @Override
    public Drawable mutate() {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_1719618541 = null; 
        {
            boolean varC94B19053599294E7944C8C841976773_134902797 = (!mMutated && super.mutate() == this);
            {
                final ChildDrawable[] array = mLayerState.mChildren;
                final int N = mLayerState.mNum;
                {
                    int i = 0;
                    {
                        array[i].mDrawable.mutate();
                    } 
                } 
                mMutated = true;
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1719618541 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1719618541.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1719618541;
        
        
            
            
            
                
            
            
        
        
    }

    
    static class ChildDrawable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.292 -0400", hash_original_field = "D548B27C6AC66A9D9B5D05ED35C2D844", hash_generated_field = "36D39E5803890ED250A80FAD100C4ED7")

        public Drawable mDrawable;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.292 -0400", hash_original_field = "84CB0C1DC38731A850F792E2FDB6B39B", hash_generated_field = "41EDDF00F18395AB4E75D54F56DCEAD6")

        public int mInsetL;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.292 -0400", hash_original_field = "FE98DF02B3531CCEEC8254EA7A40D8C2", hash_generated_field = "B7AF8366A6A319CDAA60A9C0D750F631")

        public int mInsetT;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.292 -0400", hash_original_field = "98714B51BF834824DA4A4A1ACF3D4447", hash_generated_field = "EC3C187375874F66EE15413DF92F4E1E")

        public int mInsetR;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.292 -0400", hash_original_field = "10B9A7B0EF30FDBEDF74FE05E0046827", hash_generated_field = "29277012246F0EA1CDF311942F6EA725")

        public int mInsetB;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.292 -0400", hash_original_field = "6AC7F06B6413A1BE9C136DC7DF0D2B60", hash_generated_field = "47CDACD56606F02DFA218FC210EFC0FF")

        public int mId;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.292 -0400", hash_original_method = "6CD909B986D24A0F6BAFA410E280EBB3", hash_generated_method = "6CD909B986D24A0F6BAFA410E280EBB3")
        public ChildDrawable ()
        {
            
        }


    }


    
    static class LayerState extends ConstantState {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.292 -0400", hash_original_field = "1B2924E0CDC894FEA7E3856870275E70", hash_generated_field = "95F99CF2E70DB79AD069A36B506646F2")

        int mNum;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.292 -0400", hash_original_field = "6699FE97ED54C04992AEDA784C483D4D", hash_generated_field = "5D63B0C69B8E94415B4820B44C747438")

        ChildDrawable[] mChildren;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.292 -0400", hash_original_field = "276E0645C4E2084773D0EB8C5576428C", hash_generated_field = "9BFAF00848476277D36D9BA586984BA7")

        int mChangingConfigurations;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.292 -0400", hash_original_field = "8755A6790E0FAEFCC765046FF423478D", hash_generated_field = "E8F7332658D4B8911B8427F9E33AC9BD")

        int mChildrenChangingConfigurations;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.292 -0400", hash_original_field = "B8FE7B1D7EF53BE4167C040A5FEB7CC7", hash_generated_field = "A98F79115AB3FA98F1F7245A604A5EC2")

        private boolean mHaveOpacity = false;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.292 -0400", hash_original_field = "9D334A125EE4B3831821AB1264C029B9", hash_generated_field = "05E7E4BE80B060037CF88AC66652FF58")

        private int mOpacity;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.292 -0400", hash_original_field = "0AB968E9E6651BF0E687DAF7846B214C", hash_generated_field = "C74F5EDB4E2A4B07698A864146958E40")

        private boolean mHaveStateful = false;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.292 -0400", hash_original_field = "1819E5C118FDB6B2BF917A4481AE2A7A", hash_generated_field = "6747C1011A591FA368B1D4C99D94E670")

        private boolean mStateful;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.292 -0400", hash_original_field = "2E319D4D352B34E33CF19129B7212FC6", hash_generated_field = "63D49323436A33301C0DA6EDF88627FF")

        private boolean mCheckedConstantState;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.293 -0400", hash_original_field = "7C8FD9809F31C20B8422D623B0EC0C4F", hash_generated_field = "F62F8D22C4EDE8B8E63C376677BD915C")

        private boolean mCanConstantState;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.293 -0400", hash_original_method = "BD826615A7A8424D072A11138F67C8D8", hash_generated_method = "AD07E7C94477B4379C1B48E871B1485A")
          LayerState(LayerState orig, LayerDrawable owner, Resources res) {
            {
                final ChildDrawable[] origChildDrawable = orig.mChildren;
                final int N = orig.mNum;
                mNum = N;
                mChildren = new ChildDrawable[N];
                mChangingConfigurations = orig.mChangingConfigurations;
                mChildrenChangingConfigurations = orig.mChildrenChangingConfigurations;
                {
                    int i = 0;
                    {
                        final ChildDrawable r = mChildren[i] = new ChildDrawable();
                        final ChildDrawable or = origChildDrawable[i];
                        {
                            r.mDrawable = or.mDrawable.getConstantState().newDrawable(res);
                        } 
                        {
                            r.mDrawable = or.mDrawable.getConstantState().newDrawable();
                        } 
                        r.mDrawable.setCallback(owner);
                        r.mInsetL = or.mInsetL;
                        r.mInsetT = or.mInsetT;
                        r.mInsetR = or.mInsetR;
                        r.mInsetB = or.mInsetB;
                        r.mId = or.mId;
                    } 
                } 
                mHaveOpacity = orig.mHaveOpacity;
                mOpacity = orig.mOpacity;
                mHaveStateful = orig.mHaveStateful;
                mStateful = orig.mStateful;
                mCheckedConstantState = mCanConstantState = true;
            } 
            {
                mNum = 0;
                mChildren = null;
            } 
            addTaint(owner.getTaint());
            addTaint(res.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.294 -0400", hash_original_method = "4F2E1E1D85BE3BBCABDE93BB1C6F5E02", hash_generated_method = "087280E00CDFFCB8B79453CE9B0A9671")
        @Override
        public Drawable newDrawable() {
            Drawable varB4EAC82CA7396A68D541C85D26508E83_8723370 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_8723370 = new LayerDrawable(this, null);
            varB4EAC82CA7396A68D541C85D26508E83_8723370.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_8723370;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.295 -0400", hash_original_method = "40E045186798A3567910482DC0B43DC7", hash_generated_method = "87375CDC27246CDE8651B5303B990626")
        @Override
        public Drawable newDrawable(Resources res) {
            Drawable varB4EAC82CA7396A68D541C85D26508E83_1729555692 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1729555692 = new LayerDrawable(this, res);
            addTaint(res.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1729555692.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1729555692;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.295 -0400", hash_original_method = "9E7D7C67EAC365FF19BD4971762612A5", hash_generated_method = "F67FFC1E818D3675FEF014767024AEA2")
        @Override
        public int getChangingConfigurations() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1327231650 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1327231650;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.295 -0400", hash_original_method = "C863EE1513D5FAC46B3A54079EE22BC7", hash_generated_method = "72A83985EA87B9DD9855C4325221A135")
        public final int getOpacity() {
            final int N = mNum;
            int op;
            op = mChildren[0].mDrawable.getOpacity();
            op = PixelFormat.TRANSPARENT;
            {
                int i = 1;
                {
                    op = Drawable.resolveOpacity(op, mChildren[i].mDrawable.getOpacity());
                } 
            } 
            mOpacity = op;
            mHaveOpacity = true;
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1466296307 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1466296307;
            
            
                
            
            
            
            
                
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.296 -0400", hash_original_method = "302772CF3A9A555DFD32DC83A81CA17A", hash_generated_method = "716BDC0A636FB5AF1E61A04AB1875FB4")
        public final boolean isStateful() {
            boolean stateful = false;
            final int N = mNum;
            {
                int i = 0;
                {
                    {
                        boolean varCC50B7DB73A9F6C5D752EC13C92CDF20_1047862589 = (mChildren[i].mDrawable.isStateful());
                        {
                            stateful = true;
                        } 
                    } 
                } 
            } 
            mStateful = stateful;
            mHaveStateful = true;
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_559512688 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_559512688;
            
            
                
            
            
            
            
                
                    
                    
                
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.297 -0400", hash_original_method = "08014AA1073210728E3D3AA9FAF026EA", hash_generated_method = "54C2BC6CCC7644EE292120812889649A")
        public synchronized boolean canConstantState() {
            {
                mCanConstantState = true;
                final int N = mNum;
                {
                    int i = 0;
                    {
                        {
                            boolean var72A78A7292B72B8D1D41A0BF5E2460B4_1626135795 = (mChildren[i].mDrawable.getConstantState() == null);
                            {
                                mCanConstantState = false;
                            } 
                        } 
                    } 
                } 
                mCheckedConstantState = true;
            } 
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1555477284 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1555477284;
            
            
                
                
                
                    
                        
                        
                    
                
                
            
            
        }

        
    }


    
}

