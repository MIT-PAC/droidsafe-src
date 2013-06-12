package android.graphics.drawable;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.NinePatch;
import android.graphics.PixelFormat;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.StateSet;
import android.util.TypedValue;
import android.util.Xml;
import android.view.View;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.Arrays;

public abstract class Drawable {
    private static final Rect ZERO_BOUNDS_RECT = new Rect();
    private int[] mStateSet = StateSet.WILD_CARD;
    private int mLevel = 0;
    private int mChangingConfigurations = 0;
    private Rect mBounds = ZERO_BOUNDS_RECT;
    private WeakReference<Callback> mCallback = null;
    private boolean mVisible = true;
    
    public abstract void draw(Canvas canvas);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.094 -0400", hash_original_method = "16D67C97CF930C94423B2F0ABE9E2FB8", hash_generated_method = "72A71D9328382525E36175E576BE15BD")
    @DSModeled(DSC.SAFE)
    public void setBounds(int left, int top, int right, int bottom) {
        dsTaint.addTaint(bottom);
        dsTaint.addTaint(left);
        dsTaint.addTaint(right);
        dsTaint.addTaint(top);
        Rect oldBounds;
        oldBounds = mBounds;
        {
            oldBounds = mBounds = new Rect();
        } //End block
        {
            mBounds.set(left, top, right, bottom);
            onBoundsChange(mBounds);
        } //End block
        // ---------- Original Method ----------
        //Rect oldBounds = mBounds;
        //if (oldBounds == ZERO_BOUNDS_RECT) {
            //oldBounds = mBounds = new Rect();
        //}
        //if (oldBounds.left != left || oldBounds.top != top ||
                //oldBounds.right != right || oldBounds.bottom != bottom) {
            //mBounds.set(left, top, right, bottom);
            //onBoundsChange(mBounds);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.094 -0400", hash_original_method = "343A23DF727C21562F2BBDB7DAA5F811", hash_generated_method = "C8DA1D40915F47C8468AB392DD660FEB")
    @DSModeled(DSC.SAFE)
    public void setBounds(Rect bounds) {
        dsTaint.addTaint(bounds.dsTaint);
        setBounds(bounds.left, bounds.top, bounds.right, bounds.bottom);
        // ---------- Original Method ----------
        //setBounds(bounds.left, bounds.top, bounds.right, bounds.bottom);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.094 -0400", hash_original_method = "2860BC8F60A9356A6AA851AD0EDF9049", hash_generated_method = "B6454E731C24418C33981CEEB6B52E15")
    @DSModeled(DSC.SAFE)
    public final void copyBounds(Rect bounds) {
        dsTaint.addTaint(bounds.dsTaint);
        bounds.set(mBounds);
        // ---------- Original Method ----------
        //bounds.set(mBounds);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.095 -0400", hash_original_method = "A623AF26CC98262C126F58F99B918C3F", hash_generated_method = "0F20E520B166CD4C4B315B64EC0487FD")
    @DSModeled(DSC.SAFE)
    public final Rect copyBounds() {
        return (Rect)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new Rect(mBounds);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.095 -0400", hash_original_method = "F9C4E095C08A855B9547E5FC046C50BF", hash_generated_method = "B8E3B675D2E51410CE03FC7D056E782D")
    @DSModeled(DSC.SAFE)
    public final Rect getBounds() {
        {
            mBounds = new Rect();
        } //End block
        return (Rect)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mBounds == ZERO_BOUNDS_RECT) {
            //mBounds = new Rect();
        //}
        //return mBounds;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.095 -0400", hash_original_method = "E7340D87AE9D08581CEC5A0FAA0552EE", hash_generated_method = "1C4AFBD10A96FDE70DEC6748C9568A9C")
    @DSModeled(DSC.SAFE)
    public void setChangingConfigurations(int configs) {
        dsTaint.addTaint(configs);
        // ---------- Original Method ----------
        //mChangingConfigurations = configs;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.095 -0400", hash_original_method = "9E7D7C67EAC365FF19BD4971762612A5", hash_generated_method = "9A5756C7B078DE22C6F454D689CC0101")
    @DSModeled(DSC.SAFE)
    public int getChangingConfigurations() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mChangingConfigurations;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.095 -0400", hash_original_method = "A73E6D639014FDB13967AD6B494837C8", hash_generated_method = "701C6133489662807163D99140538BB1")
    @DSModeled(DSC.SAFE)
    public void setDither(boolean dither) {
        dsTaint.addTaint(dither);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.096 -0400", hash_original_method = "D611F7535670B80ECD8BF210909C26D1", hash_generated_method = "4A16534F05568295F12637654D74BDC7")
    @DSModeled(DSC.SAFE)
    public void setFilterBitmap(boolean filter) {
        dsTaint.addTaint(filter);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.096 -0400", hash_original_method = "59192F5DE8ED3EA14FF77E774B104DE3", hash_generated_method = "8DC01ED9729E5104576AC7AEADC1FDD6")
    @DSModeled(DSC.SAFE)
    public final void setCallback(Callback cb) {
        dsTaint.addTaint(cb.dsTaint);
        mCallback = new WeakReference<Callback>(cb);
        // ---------- Original Method ----------
        //mCallback = new WeakReference<Callback>(cb);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.096 -0400", hash_original_method = "F8C083250821C64B63A1F88F9B7D8469", hash_generated_method = "19368F51F245A8FF5EA7FFC9969039A5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Callback getCallback() {
        {
            Callback var3626D2E1D3D30655842C49FBF7623E4B_1567460223 = (mCallback.get());
        } //End block
        return (Callback)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mCallback != null) {
            //return mCallback.get();
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.096 -0400", hash_original_method = "9D9FDBFF51AC2DBEF3B6FA3B8569CCD5", hash_generated_method = "9E495F9CF7CEC3D8AC8B3D3EA636CC7E")
    @DSModeled(DSC.SAFE)
    public void invalidateSelf() {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.096 -0400", hash_original_method = "4BA44AAA8396AA668795CA7F4E916174", hash_generated_method = "4BD615894FE8DD30CF864FBA797DE2AC")
    @DSModeled(DSC.SAFE)
    public void scheduleSelf(Runnable what, long when) {
        dsTaint.addTaint(what.dsTaint);
        dsTaint.addTaint(when);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.096 -0400", hash_original_method = "40D05A483A091B37888582EA72925B1D", hash_generated_method = "5335A80009AEE5C57BCF881BED950E59")
    @DSModeled(DSC.SAFE)
    public void unscheduleSelf(Runnable what) {
        dsTaint.addTaint(what.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.096 -0400", hash_original_method = "D8B32EDE038D6347583B50AC97BFE4A6", hash_generated_method = "5C10E4E717999276B6CE20F1449EEC11")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getResolvedLayoutDirectionSelf() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        final Callback callback;
        callback = getCallback();
        int var75736B757CD8B520406B8464AF443B02_358913909 = (((Callback2) callback).getResolvedLayoutDirection(this));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //final Callback callback = getCallback();
        //if (callback == null || !(callback instanceof Callback2)) {
            //return View.LAYOUT_DIRECTION_LTR;
        //}
        //return ((Callback2) callback).getResolvedLayoutDirection(this);
    }

    
    public abstract void setAlpha(int alpha);

    
    public abstract void setColorFilter(ColorFilter cf);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.097 -0400", hash_original_method = "F0522F608E5F96C5D99BDA1CF055B16B", hash_generated_method = "70BA567F12A1DC196874EC18347AE85A")
    @DSModeled(DSC.SAFE)
    public void setColorFilter(int color, PorterDuff.Mode mode) {
        dsTaint.addTaint(color);
        dsTaint.addTaint(mode.dsTaint);
        setColorFilter(new PorterDuffColorFilter(color, mode));
        // ---------- Original Method ----------
        //setColorFilter(new PorterDuffColorFilter(color, mode));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.097 -0400", hash_original_method = "B358CFD4AAFD748C624F742F21F12081", hash_generated_method = "6455E6F25DB7F71321DA552FC4B1A43A")
    @DSModeled(DSC.SAFE)
    public void clearColorFilter() {
        setColorFilter(null);
        // ---------- Original Method ----------
        //setColorFilter(null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.097 -0400", hash_original_method = "5AE02876CD642F1B59606A09240D1BD0", hash_generated_method = "FC8EF7D94872BF748811CB678C0022E5")
    @DSModeled(DSC.SAFE)
    public boolean isStateful() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.097 -0400", hash_original_method = "A73F586C823927F65CC09CAB74021FD5", hash_generated_method = "A0D6735A3040D22CFEA7AF7F8D134A92")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean setState(final int[] stateSet) {
        dsTaint.addTaint(stateSet);
        {
            boolean var5240CDA1CB2272B8BE70FE042E3A6089_642433226 = (!Arrays.equals(mStateSet, stateSet));
            {
                boolean var2E8C85253ED8EDDED71485E563D55CAD_1557591529 = (onStateChange(stateSet));
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (!Arrays.equals(mStateSet, stateSet)) {
            //mStateSet = stateSet;
            //return onStateChange(stateSet);
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.097 -0400", hash_original_method = "2C3685292135F2FEA5B926C5A0764B84", hash_generated_method = "09C05CEFACD2A40545F3AF3109B9DC07")
    @DSModeled(DSC.SAFE)
    public int[] getState() {
        int[] retVal = new int[1];
        retVal[0] = dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //return mStateSet;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.097 -0400", hash_original_method = "1A9E62CA8A2399C6C2BEF07B26352781", hash_generated_method = "2378B015F3956DF7C55CD09EAAB999BC")
    @DSModeled(DSC.SAFE)
    public void jumpToCurrentState() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.097 -0400", hash_original_method = "00D08FCE0657F40CBD93DF1CB810B766", hash_generated_method = "757D69A4A5ED312141E64B45133F3211")
    @DSModeled(DSC.SAFE)
    public Drawable getCurrent() {
        return (Drawable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.097 -0400", hash_original_method = "9037BFCAC5FB09B2A9E758C0533961C8", hash_generated_method = "BAAD13F9C529817AD7DE41F724436A11")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean setLevel(int level) {
        dsTaint.addTaint(level);
        {
            boolean var9872BA4A333C94281EC3A1CE7EB34844_129352738 = (onLevelChange(level));
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mLevel != level) {
            //mLevel = level;
            //return onLevelChange(level);
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.098 -0400", hash_original_method = "3688C6710C4CB9729612AA02E692BC0A", hash_generated_method = "9DD2993B5A0FAA8AD032D9466AE70D9D")
    @DSModeled(DSC.SAFE)
    public final int getLevel() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mLevel;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.098 -0400", hash_original_method = "385D529E13116BE326F07B115E2B9363", hash_generated_method = "11EA8EF2A02C8229834E9983A25A83D3")
    @DSModeled(DSC.SAFE)
    public boolean setVisible(boolean visible, boolean restart) {
        dsTaint.addTaint(restart);
        dsTaint.addTaint(visible);
        boolean changed;
        changed = mVisible != visible;
        {
            invalidateSelf();
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //boolean changed = mVisible != visible;
        //if (changed) {
            //mVisible = visible;
            //invalidateSelf();
        //}
        //return changed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.098 -0400", hash_original_method = "5E5A2EDE31F4C9B537E19F3E9904B493", hash_generated_method = "65ED1417FB8ACFBF03E24BC773DB14E8")
    @DSModeled(DSC.SAFE)
    public final boolean isVisible() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mVisible;
    }

    
    public abstract int getOpacity();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.098 -0400", hash_original_method = "916D14DF9AF3A81E437ADC0DC2203CFE", hash_generated_method = "BC2213D8D42D8210AD9C5ABE45796385")
    public static int resolveOpacity(int op1, int op2) {
        if (op1 == op2) {
            return op1;
        }
        if (op1 == PixelFormat.UNKNOWN || op2 == PixelFormat.UNKNOWN) {
            return PixelFormat.UNKNOWN;
        }
        if (op1 == PixelFormat.TRANSLUCENT || op2 == PixelFormat.TRANSLUCENT) {
            return PixelFormat.TRANSLUCENT;
        }
        if (op1 == PixelFormat.TRANSPARENT || op2 == PixelFormat.TRANSPARENT) {
            return PixelFormat.TRANSPARENT;
        }
        return PixelFormat.OPAQUE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.098 -0400", hash_original_method = "6885EC41EEEA48BF379C9186E23112DE", hash_generated_method = "CBEA8AE4D12494AC730A6535B337B700")
    @DSModeled(DSC.SAFE)
    public Region getTransparentRegion() {
        return (Region)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.098 -0400", hash_original_method = "B7A8462AFC13A6E0F2F8BCB43385BD49", hash_generated_method = "25FCD0C710547CE78C673D98DBFE80CC")
    @DSModeled(DSC.SAFE)
    protected boolean onStateChange(int[] state) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(state);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.098 -0400", hash_original_method = "37D330857F7202D119AB7FE43B955D5E", hash_generated_method = "4F299255E79E7AA2E4B1C1A6CB3B83B9")
    @DSModeled(DSC.SAFE)
    protected boolean onLevelChange(int level) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(level);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.098 -0400", hash_original_method = "F81B37D492B4B76F5CB4F03B5248220C", hash_generated_method = "3FAD59CF91D777A598A9ACA5DF801D0C")
    @DSModeled(DSC.SAFE)
    protected void onBoundsChange(Rect bounds) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(bounds.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.098 -0400", hash_original_method = "EB5466611B82CCCED48E9C76B5992F82", hash_generated_method = "6A52A49B62768810785C025A37F4A018")
    @DSModeled(DSC.SAFE)
    public int getIntrinsicWidth() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.099 -0400", hash_original_method = "4249F2736881F978DCEB3B683D79E5C9", hash_generated_method = "5F6F85544B857E613F1EF77C6CAC9171")
    @DSModeled(DSC.SAFE)
    public int getIntrinsicHeight() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.099 -0400", hash_original_method = "5035EEEA88B512A7AC30F75048C2F85A", hash_generated_method = "C6D31F70ECACBD11A0CEE098C9BD2FC6")
    @DSModeled(DSC.SAFE)
    public int getMinimumWidth() {
        final int intrinsicWidth;
        intrinsicWidth = getIntrinsicWidth();
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //final int intrinsicWidth = getIntrinsicWidth();
        //return intrinsicWidth > 0 ? intrinsicWidth : 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.099 -0400", hash_original_method = "FB4CD88D7DE1F0713A1472841A364838", hash_generated_method = "C1AFD6325D1270B9D2BE664DF2D6F369")
    @DSModeled(DSC.SAFE)
    public int getMinimumHeight() {
        final int intrinsicHeight;
        intrinsicHeight = getIntrinsicHeight();
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //final int intrinsicHeight = getIntrinsicHeight();
        //return intrinsicHeight > 0 ? intrinsicHeight : 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.099 -0400", hash_original_method = "3EEC3E25F33F4D98A0E1482CE3BAC48C", hash_generated_method = "92869775A70EA9EB746000E76E1AEF39")
    @DSModeled(DSC.SAFE)
    public boolean getPadding(Rect padding) {
        dsTaint.addTaint(padding.dsTaint);
        padding.set(0, 0, 0, 0);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //padding.set(0, 0, 0, 0);
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.099 -0400", hash_original_method = "4655CA169BE542FE87BF20A0D63A5DAC", hash_generated_method = "ED9BAE052B6F251B7C53A1F4B72FE608")
    @DSModeled(DSC.SAFE)
    public Drawable mutate() {
        return (Drawable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.099 -0400", hash_original_method = "F698992CDA7CE4CFA6270F08869E33EB", hash_generated_method = "EA31CB41043D98187A4334DCA5BDDCB4")
    public static Drawable createFromStream(InputStream is, String srcName) {
        return createFromResourceStream(null, null, is, srcName, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.099 -0400", hash_original_method = "6539199B7E5EF78E3B150794D858A2C9", hash_generated_method = "D8B91DF7BE5D083150AB363B8A4B7E47")
    public static Drawable createFromResourceStream(Resources res, TypedValue value,
            InputStream is, String srcName) {
        return createFromResourceStream(res, value, is, srcName, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.099 -0400", hash_original_method = "686309EFC5AB81BA579C045870002714", hash_generated_method = "80D802C6C36835BBE0E400814ACF0445")
    public static Drawable createFromResourceStream(Resources res, TypedValue value,
            InputStream is, String srcName, BitmapFactory.Options opts) {
        if (is == null) {
            return null;
        }
        Rect pad = new Rect();
        if (opts == null) opts = new BitmapFactory.Options();
        opts.inScreenDensity = DisplayMetrics.DENSITY_DEVICE;
        Bitmap  bm = BitmapFactory.decodeResourceStream(res, value, is, pad, opts);
        if (bm != null) {
            byte[] np = bm.getNinePatchChunk();
            if (np == null || !NinePatch.isNinePatchChunk(np)) {
                np = null;
                pad = null;
            }
            return drawableFromBitmap(res, bm, np, pad, srcName);
        }
        return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.100 -0400", hash_original_method = "86675DFFF0A0A811727E3034212032EE", hash_generated_method = "48FF57E965BD51CA2E3FEB22A02D487C")
    public static Drawable createFromXml(Resources r, XmlPullParser parser) throws XmlPullParserException, IOException {
        AttributeSet attrs = Xml.asAttributeSet(parser);
        int type;
        while ((type=parser.next()) != XmlPullParser.START_TAG &&
                type != XmlPullParser.END_DOCUMENT) {
        }
        if (type != XmlPullParser.START_TAG) {
            throw new XmlPullParserException("No start tag found");
        }
        Drawable drawable = createFromXmlInner(r, parser, attrs);
        if (drawable == null) {
            throw new RuntimeException("Unknown initial tag: " + parser.getName());
        }
        return drawable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.100 -0400", hash_original_method = "C057D9F248A8C0B51C535F2391A8C186", hash_generated_method = "E8E3063E036DA05EA0059CBC6226AD61")
    public static Drawable createFromXmlInner(Resources r, XmlPullParser parser, AttributeSet attrs) throws XmlPullParserException, IOException {
        Drawable drawable;
        final String name = parser.getName();
        if (name.equals("selector")) {
            drawable = new StateListDrawable();
        } else if (name.equals("level-list")) {
            drawable = new LevelListDrawable();
        } else if (name.equals("layer-list")) {
            drawable = new LayerDrawable();
        } else if (name.equals("transition")) {
            drawable = new TransitionDrawable();
        } else if (name.equals("color")) {
            drawable = new ColorDrawable();
        } else if (name.equals("shape")) {
            drawable = new GradientDrawable();
        } else if (name.equals("scale")) {
            drawable = new ScaleDrawable();
        } else if (name.equals("clip")) {
            drawable = new ClipDrawable();
        } else if (name.equals("rotate")) {
            drawable = new RotateDrawable();
        } else if (name.equals("animated-rotate")) {
            drawable = new AnimatedRotateDrawable();            
        } else if (name.equals("animation-list")) {
            drawable = new AnimationDrawable();
        } else if (name.equals("inset")) {
            drawable = new InsetDrawable();
        } else if (name.equals("bitmap")) {
            drawable = new BitmapDrawable(r);
            if (r != null) {
               ((BitmapDrawable) drawable).setTargetDensity(r.getDisplayMetrics());
            }
        } else if (name.equals("nine-patch")) {
            drawable = new NinePatchDrawable();
            if (r != null) {
                ((NinePatchDrawable) drawable).setTargetDensity(r.getDisplayMetrics());
             }
        } else {
            throw new XmlPullParserException(parser.getPositionDescription() +
                    ": invalid drawable tag " + name);
        }
        drawable.inflate(r, parser, attrs);
        return drawable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.100 -0400", hash_original_method = "BFC9B5CBB4F35E84FED6A1D240D75B82", hash_generated_method = "0731BFA5FCCFB319677220F34322AFEB")
    public static Drawable createFromPath(String pathName) {
        if (pathName == null) {
            return null;
        }
        Bitmap bm = BitmapFactory.decodeFile(pathName);
        if (bm != null) {
            return drawableFromBitmap(null, bm, null, null, pathName);
        }
        return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.100 -0400", hash_original_method = "A7AA835959A57BB8EBB74755836F5541", hash_generated_method = "BB13D03F1A716ADD79C08DF8F445AF8B")
    @DSModeled(DSC.SAFE)
    public void inflate(Resources r, XmlPullParser parser, AttributeSet attrs) throws XmlPullParserException, IOException {
        dsTaint.addTaint(r.dsTaint);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(parser.dsTaint);
        TypedArray a;
        a = r.obtainAttributes(attrs, com.android.internal.R.styleable.Drawable);
        inflateWithAttributes(r, parser, a, com.android.internal.R.styleable.Drawable_visible);
        a.recycle();
        // ---------- Original Method ----------
        //TypedArray a = r.obtainAttributes(attrs, com.android.internal.R.styleable.Drawable);
        //inflateWithAttributes(r, parser, a, com.android.internal.R.styleable.Drawable_visible);
        //a.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.100 -0400", hash_original_method = "9471DE214DF2BB650CFB53CA22D70654", hash_generated_method = "0FA1EFE3E9DD79DC386962FEFB9FD4F0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void inflateWithAttributes(Resources r, XmlPullParser parser,
            TypedArray attrs, int visibleAttr) throws XmlPullParserException, IOException {
        dsTaint.addTaint(r.dsTaint);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(parser.dsTaint);
        dsTaint.addTaint(visibleAttr);
        mVisible = attrs.getBoolean(visibleAttr, mVisible);
        // ---------- Original Method ----------
        //mVisible = attrs.getBoolean(visibleAttr, mVisible);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.100 -0400", hash_original_method = "4B02BBF3CC1230B6CEECD73EA01A2039", hash_generated_method = "715287ED699E04DF1E5FF30C825FD9BA")
    @DSModeled(DSC.SAFE)
    public ConstantState getConstantState() {
        return (ConstantState)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.100 -0400", hash_original_method = "1F43455DFCC8536E753114D2CECC415D", hash_generated_method = "23FBC035CFAA577048942BA8AA2CFFE6")
    private static Drawable drawableFromBitmap(Resources res, Bitmap bm, byte[] np,
            Rect pad, String srcName) {
        if (np != null) {
            return new NinePatchDrawable(res, bm, np, pad, srcName);
        }
        return new BitmapDrawable(res, bm);
    }

    
    public static abstract class ConstantState {
        
        public abstract Drawable newDrawable();

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.101 -0400", hash_original_method = "5FCE46455F7833ADD9520B3BEB7232AE", hash_generated_method = "FD16AF65BF7ED05BCE13CD1045CEE7A9")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Drawable newDrawable(Resources res) {
            dsTaint.addTaint(res.dsTaint);
            Drawable var0AE25E94F876B224628195348967C0EC_1859054948 = (newDrawable());
            return (Drawable)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return newDrawable();
        }

        
        public abstract int getChangingConfigurations();

        
    }


    
    public static interface Callback {
        
        public void invalidateDrawable(Drawable who);

        
        public void scheduleDrawable(Drawable who, Runnable what, long when);

        
        public void unscheduleDrawable(Drawable who, Runnable what);
    }
    
    public static interface Callback2 extends Callback {
        
        public int getResolvedLayoutDirection(Drawable who);
    }
    
}


