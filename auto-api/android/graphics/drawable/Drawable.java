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
    private int[] mStateSet = StateSet.WILD_CARD;
    private int mLevel = 0;
    private int mChangingConfigurations = 0;
    private Rect mBounds = ZERO_BOUNDS_RECT;
    private WeakReference<Callback> mCallback = null;
    private boolean mVisible = true;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.057 -0400", hash_original_method = "9EEE6EBE09A293CAD3653F6ED58171BE", hash_generated_method = "9EEE6EBE09A293CAD3653F6ED58171BE")
        public Drawable ()
    {
    }


    public abstract void draw(Canvas canvas);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.070 -0400", hash_original_method = "16D67C97CF930C94423B2F0ABE9E2FB8", hash_generated_method = "C2545812F820E2C2AC8B72E8C325672D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.070 -0400", hash_original_method = "343A23DF727C21562F2BBDB7DAA5F811", hash_generated_method = "DCE6124BB18C89B9649CC82B20D2D6D0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setBounds(Rect bounds) {
        dsTaint.addTaint(bounds.dsTaint);
        setBounds(bounds.left, bounds.top, bounds.right, bounds.bottom);
        // ---------- Original Method ----------
        //setBounds(bounds.left, bounds.top, bounds.right, bounds.bottom);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.071 -0400", hash_original_method = "2860BC8F60A9356A6AA851AD0EDF9049", hash_generated_method = "837C20AB82FEDABEFE5AD02479F298AC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void copyBounds(Rect bounds) {
        dsTaint.addTaint(bounds.dsTaint);
        bounds.set(mBounds);
        // ---------- Original Method ----------
        //bounds.set(mBounds);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.071 -0400", hash_original_method = "A623AF26CC98262C126F58F99B918C3F", hash_generated_method = "21979DE34860044CCD46CFEB30A3BC04")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final Rect copyBounds() {
        Rect var22DB1C54D460CA19476EB22287D37E91_908225144 = (new Rect(mBounds));
        return (Rect)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new Rect(mBounds);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.071 -0400", hash_original_method = "F9C4E095C08A855B9547E5FC046C50BF", hash_generated_method = "9227DE6AD284BEF6022853F2B8FDF3A0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.072 -0400", hash_original_method = "E7340D87AE9D08581CEC5A0FAA0552EE", hash_generated_method = "6CB09C6969D1A6B50C410A7E87208586")
    @DSModeled(DSC.SAFE)
    public void setChangingConfigurations(int configs) {
        dsTaint.addTaint(configs);
        // ---------- Original Method ----------
        //mChangingConfigurations = configs;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.072 -0400", hash_original_method = "9E7D7C67EAC365FF19BD4971762612A5", hash_generated_method = "AF612692370300236093D0381A5A9FAF")
    @DSModeled(DSC.SAFE)
    public int getChangingConfigurations() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mChangingConfigurations;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.072 -0400", hash_original_method = "A73E6D639014FDB13967AD6B494837C8", hash_generated_method = "9FF5C6B789C5149EE26F70A1929F9256")
    @DSModeled(DSC.SAFE)
    public void setDither(boolean dither) {
        dsTaint.addTaint(dither);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.072 -0400", hash_original_method = "D611F7535670B80ECD8BF210909C26D1", hash_generated_method = "47685E1E6D3E1077C0A8F2A7F25FF689")
    @DSModeled(DSC.SAFE)
    public void setFilterBitmap(boolean filter) {
        dsTaint.addTaint(filter);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.073 -0400", hash_original_method = "59192F5DE8ED3EA14FF77E774B104DE3", hash_generated_method = "9715023BEC681B22ECBE0C0F8C165436")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void setCallback(Callback cb) {
        dsTaint.addTaint(cb.dsTaint);
        mCallback = new WeakReference<Callback>(cb);
        // ---------- Original Method ----------
        //mCallback = new WeakReference<Callback>(cb);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.073 -0400", hash_original_method = "F8C083250821C64B63A1F88F9B7D8469", hash_generated_method = "78D974DCA1B9AA23871EB8DDF9535EC3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Callback getCallback() {
        {
            Callback var3626D2E1D3D30655842C49FBF7623E4B_688548866 = (mCallback.get());
        } //End block
        return (Callback)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mCallback != null) {
            //return mCallback.get();
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.073 -0400", hash_original_method = "9D9FDBFF51AC2DBEF3B6FA3B8569CCD5", hash_generated_method = "897D4E925665E675B18EA7C0DC0BCBB3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void invalidateSelf() {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.073 -0400", hash_original_method = "4BA44AAA8396AA668795CA7F4E916174", hash_generated_method = "6634435FC3F7654DBCF1D6230430F05E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void scheduleSelf(Runnable what, long when) {
        dsTaint.addTaint(what.dsTaint);
        dsTaint.addTaint(when);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.074 -0400", hash_original_method = "40D05A483A091B37888582EA72925B1D", hash_generated_method = "59D827EF81A5FF70A6F220DBA54EB4D8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unscheduleSelf(Runnable what) {
        dsTaint.addTaint(what.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.074 -0400", hash_original_method = "D8B32EDE038D6347583B50AC97BFE4A6", hash_generated_method = "49BF00356B2BB7F9F721C3D368DA899D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getResolvedLayoutDirectionSelf() {
        Callback callback;
        callback = getCallback();
        int var75736B757CD8B520406B8464AF443B02_755574841 = (((Callback2) callback).getResolvedLayoutDirection(this));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.075 -0400", hash_original_method = "F0522F608E5F96C5D99BDA1CF055B16B", hash_generated_method = "C8C93972445DBDE08AC03317E756D659")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setColorFilter(int color, PorterDuff.Mode mode) {
        dsTaint.addTaint(color);
        dsTaint.addTaint(mode.dsTaint);
        setColorFilter(new PorterDuffColorFilter(color, mode));
        // ---------- Original Method ----------
        //setColorFilter(new PorterDuffColorFilter(color, mode));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.075 -0400", hash_original_method = "B358CFD4AAFD748C624F742F21F12081", hash_generated_method = "4583F0874D1CBB724BCBB622A001163D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void clearColorFilter() {
        setColorFilter(null);
        // ---------- Original Method ----------
        //setColorFilter(null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.075 -0400", hash_original_method = "5AE02876CD642F1B59606A09240D1BD0", hash_generated_method = "15CB72D28A41725DC85F5E6478C8CCD5")
    @DSModeled(DSC.SAFE)
    public boolean isStateful() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.084 -0400", hash_original_method = "A73F586C823927F65CC09CAB74021FD5", hash_generated_method = "5C979A937B475FAB95A8A2731FBFE333")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean setState(final int[] stateSet) {
        dsTaint.addTaint(stateSet[0]);
        {
            boolean var5240CDA1CB2272B8BE70FE042E3A6089_1414978408 = (!Arrays.equals(mStateSet, stateSet));
            {
                boolean var2E8C85253ED8EDDED71485E563D55CAD_2025694201 = (onStateChange(stateSet));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.085 -0400", hash_original_method = "2C3685292135F2FEA5B926C5A0764B84", hash_generated_method = "13F716A6BB9C9BDF1DD3875BB4846130")
    @DSModeled(DSC.SAFE)
    public int[] getState() {
        int[] retVal = new int[1];
        retVal[0] = dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //return mStateSet;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.086 -0400", hash_original_method = "1A9E62CA8A2399C6C2BEF07B26352781", hash_generated_method = "0131A8711CA5A4121C3000F639F15FB6")
    @DSModeled(DSC.SAFE)
    public void jumpToCurrentState() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.093 -0400", hash_original_method = "00D08FCE0657F40CBD93DF1CB810B766", hash_generated_method = "B350DB5FD059390E203CA84F0F53BA16")
    @DSModeled(DSC.SAFE)
    public Drawable getCurrent() {
        return (Drawable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.094 -0400", hash_original_method = "9037BFCAC5FB09B2A9E758C0533961C8", hash_generated_method = "CCDE45D7412F50E8E281AF6E0C1B21D8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean setLevel(int level) {
        dsTaint.addTaint(level);
        {
            boolean var9872BA4A333C94281EC3A1CE7EB34844_1153489776 = (onLevelChange(level));
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mLevel != level) {
            //mLevel = level;
            //return onLevelChange(level);
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.094 -0400", hash_original_method = "3688C6710C4CB9729612AA02E692BC0A", hash_generated_method = "02F193D43708060EBEE0FBC954D7B14C")
    @DSModeled(DSC.SAFE)
    public final int getLevel() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mLevel;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.098 -0400", hash_original_method = "385D529E13116BE326F07B115E2B9363", hash_generated_method = "C3C5BBF9DB64A13C82C5681D2B602F22")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.099 -0400", hash_original_method = "5E5A2EDE31F4C9B537E19F3E9904B493", hash_generated_method = "F21D95A29CE7325C8AA0F23D874257AD")
    @DSModeled(DSC.SAFE)
    public final boolean isVisible() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mVisible;
    }

    
    public abstract int getOpacity();

    
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.100 -0400", hash_original_method = "6885EC41EEEA48BF379C9186E23112DE", hash_generated_method = "130F86BF1981EC73406B7C4DB34F4B1D")
    @DSModeled(DSC.SAFE)
    public Region getTransparentRegion() {
        return (Region)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.102 -0400", hash_original_method = "B7A8462AFC13A6E0F2F8BCB43385BD49", hash_generated_method = "CF72FF68C82B61E269BD3CC6ECCD977D")
    @DSModeled(DSC.SAFE)
    protected boolean onStateChange(int[] state) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(state[0]);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.103 -0400", hash_original_method = "37D330857F7202D119AB7FE43B955D5E", hash_generated_method = "D234B3669778C9BF373CC4A98076889E")
    @DSModeled(DSC.SAFE)
    protected boolean onLevelChange(int level) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(level);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.103 -0400", hash_original_method = "F81B37D492B4B76F5CB4F03B5248220C", hash_generated_method = "A4B0F2D1518775BC9525E23E9270B576")
    @DSModeled(DSC.SAFE)
    protected void onBoundsChange(Rect bounds) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(bounds.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.103 -0400", hash_original_method = "EB5466611B82CCCED48E9C76B5992F82", hash_generated_method = "FFE08A9EDF9F00A370193A854410DA67")
    @DSModeled(DSC.SAFE)
    public int getIntrinsicWidth() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.103 -0400", hash_original_method = "4249F2736881F978DCEB3B683D79E5C9", hash_generated_method = "C77B9DCB27B20114E3756FCFD6804632")
    @DSModeled(DSC.SAFE)
    public int getIntrinsicHeight() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.104 -0400", hash_original_method = "5035EEEA88B512A7AC30F75048C2F85A", hash_generated_method = "232B1CD8A023AAE94FC47778C777814E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getMinimumWidth() {
        int intrinsicWidth;
        intrinsicWidth = getIntrinsicWidth();
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //final int intrinsicWidth = getIntrinsicWidth();
        //return intrinsicWidth > 0 ? intrinsicWidth : 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.104 -0400", hash_original_method = "FB4CD88D7DE1F0713A1472841A364838", hash_generated_method = "B6139E9D7A5C8794190BBCBF1AA29109")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getMinimumHeight() {
        int intrinsicHeight;
        intrinsicHeight = getIntrinsicHeight();
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //final int intrinsicHeight = getIntrinsicHeight();
        //return intrinsicHeight > 0 ? intrinsicHeight : 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.104 -0400", hash_original_method = "3EEC3E25F33F4D98A0E1482CE3BAC48C", hash_generated_method = "AA24AB5833CB575B04410A4CB6F998C3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean getPadding(Rect padding) {
        dsTaint.addTaint(padding.dsTaint);
        padding.set(0, 0, 0, 0);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //padding.set(0, 0, 0, 0);
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.105 -0400", hash_original_method = "4655CA169BE542FE87BF20A0D63A5DAC", hash_generated_method = "F40828F4825D464B016DCA6B22F90484")
    @DSModeled(DSC.SAFE)
    public Drawable mutate() {
        return (Drawable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this;
    }

    
        public static Drawable createFromStream(InputStream is, String srcName) {
        return createFromResourceStream(null, null, is, srcName, null);
    }

    
        public static Drawable createFromResourceStream(Resources res, TypedValue value,
            InputStream is, String srcName) {
        return createFromResourceStream(res, value, is, srcName, null);
    }

    
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.121 -0400", hash_original_method = "A7AA835959A57BB8EBB74755836F5541", hash_generated_method = "B2E004CF83079DD3BF9E8E385B6FC257")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.122 -0400", hash_original_method = "9471DE214DF2BB650CFB53CA22D70654", hash_generated_method = "32C6E4FE18B0289AEA0240F453951055")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.123 -0400", hash_original_method = "4B02BBF3CC1230B6CEECD73EA01A2039", hash_generated_method = "1E0830896FBED114B2CA1FBF250B90D9")
    @DSModeled(DSC.SAFE)
    public ConstantState getConstantState() {
        return (ConstantState)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
        private static Drawable drawableFromBitmap(Resources res, Bitmap bm, byte[] np,
            Rect pad, String srcName) {
        if (np != null) {
            return new NinePatchDrawable(res, bm, np, pad, srcName);
        }
        return new BitmapDrawable(res, bm);
    }

    
    public static abstract class ConstantState {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.125 -0400", hash_original_method = "6C2C84933649A39B17C98905BDF1D27C", hash_generated_method = "6C2C84933649A39B17C98905BDF1D27C")
                public ConstantState ()
        {
        }


        public abstract Drawable newDrawable();

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.126 -0400", hash_original_method = "5FCE46455F7833ADD9520B3BEB7232AE", hash_generated_method = "4C9C900AA65ECCCA1AF66AD21B02F79A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Drawable newDrawable(Resources res) {
            dsTaint.addTaint(res.dsTaint);
            Drawable var0AE25E94F876B224628195348967C0EC_6418308 = (newDrawable());
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
    
    private static final Rect ZERO_BOUNDS_RECT = new Rect();
}

