package android.graphics.drawable;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.Arrays;

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





public abstract class Drawable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.572 -0400", hash_original_field = "0C685B7B5DBE2FA698BB3FD957C188EC", hash_generated_field = "5E6D3F09C1210458D0C754595BB30DAC")

    private int[] mStateSet = StateSet.WILD_CARD;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.572 -0400", hash_original_field = "8D44C0A2CA7183B234B6C68F8099BDEB", hash_generated_field = "D66D669C7CB840BE2CC0AE88CB04AECF")

    private int mLevel = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.572 -0400", hash_original_field = "86B23CE72C8A42818E7EE79FD7E2AE4B", hash_generated_field = "D35ACD87C9C873D3BC15F23EE9468A4E")

    private int mChangingConfigurations = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.572 -0400", hash_original_field = "784242F59B753F521066A454CCC756BA", hash_generated_field = "294018A0A81D2A146053DB5D50BCF6B8")

    private Rect mBounds = ZERO_BOUNDS_RECT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.572 -0400", hash_original_field = "FB4EA1EB8D0E2C3D632A8208BE66A5E8", hash_generated_field = "9948EC0F011800FDF4A6CE610A87E55B")

    private WeakReference<Callback> mCallback = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.572 -0400", hash_original_field = "A6C9F3531043C8B637D2AF4F9D36CD07", hash_generated_field = "B5A582F9AADED234805D7CA1D8129D36")

    private boolean mVisible = true;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.573 -0400", hash_original_method = "31C0F11C44C8FA6382C02786623A036E", hash_generated_method = "31C0F11C44C8FA6382C02786623A036E")
    public Drawable ()
    {
        //Synthesized constructor
    }


    @DSModeled(DSC.SAFE)
    public abstract void draw(Canvas canvas);

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.574 -0400", hash_original_method = "16D67C97CF930C94423B2F0ABE9E2FB8", hash_generated_method = "3CF15C203C74C5AFC4C017F42C4C0B4B")
    public void setBounds(int left, int top, int right, int bottom) {
        addTaint(bottom);
        addTaint(right);
        addTaint(top);
        addTaint(left);
        Rect oldBounds = mBounds;
        if(oldBounds == ZERO_BOUNDS_RECT)        
        {
            oldBounds = mBounds = new Rect();
        } //End block
        if(oldBounds.left != left || oldBounds.top != top ||
                oldBounds.right != right || oldBounds.bottom != bottom)        
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.575 -0400", hash_original_method = "343A23DF727C21562F2BBDB7DAA5F811", hash_generated_method = "72ADD96AC8A50328A6185CFA5227C411")
    public void setBounds(Rect bounds) {
        addTaint(bounds.getTaint());
        setBounds(bounds.left, bounds.top, bounds.right, bounds.bottom);
        // ---------- Original Method ----------
        //setBounds(bounds.left, bounds.top, bounds.right, bounds.bottom);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.576 -0400", hash_original_method = "2860BC8F60A9356A6AA851AD0EDF9049", hash_generated_method = "95DA61BAF274EF47CF43C9B2491CED24")
    public final void copyBounds(Rect bounds) {
        addTaint(bounds.getTaint());
        bounds.set(mBounds);
        // ---------- Original Method ----------
        //bounds.set(mBounds);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.576 -0400", hash_original_method = "A623AF26CC98262C126F58F99B918C3F", hash_generated_method = "D459D8FFC8EAB99C5F08BA3B7C5F7FEB")
    public final Rect copyBounds() {
Rect var0110879CA9D488CC9507AE40C5F5AB46_1120600347 =         new Rect(mBounds);
        var0110879CA9D488CC9507AE40C5F5AB46_1120600347.addTaint(taint);
        return var0110879CA9D488CC9507AE40C5F5AB46_1120600347;
        // ---------- Original Method ----------
        //return new Rect(mBounds);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.577 -0400", hash_original_method = "F9C4E095C08A855B9547E5FC046C50BF", hash_generated_method = "C603556991299BFEED02457A66C5A4A5")
    public final Rect getBounds() {
        if(mBounds == ZERO_BOUNDS_RECT)        
        {
            mBounds = new Rect();
        } //End block
Rect var0C44887561B1EECCACD21E74409C43BB_568284881 =         mBounds;
        var0C44887561B1EECCACD21E74409C43BB_568284881.addTaint(taint);
        return var0C44887561B1EECCACD21E74409C43BB_568284881;
        // ---------- Original Method ----------
        //if (mBounds == ZERO_BOUNDS_RECT) {
            //mBounds = new Rect();
        //}
        //return mBounds;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.577 -0400", hash_original_method = "E7340D87AE9D08581CEC5A0FAA0552EE", hash_generated_method = "579750A184ACECD2EAA7D466EBD356DF")
    public void setChangingConfigurations(int configs) {
        mChangingConfigurations = configs;
        // ---------- Original Method ----------
        //mChangingConfigurations = configs;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.578 -0400", hash_original_method = "9E7D7C67EAC365FF19BD4971762612A5", hash_generated_method = "C72F94AD32BECA1584EDDBCD58379572")
    public int getChangingConfigurations() {
        int var276E0645C4E2084773D0EB8C5576428C_1982536952 = (mChangingConfigurations);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1835183645 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1835183645;
        // ---------- Original Method ----------
        //return mChangingConfigurations;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.578 -0400", hash_original_method = "A73E6D639014FDB13967AD6B494837C8", hash_generated_method = "4F5D1BE5F2EFBD95EEA7C718FF48A1E8")
    public void setDither(boolean dither) {
        addTaint(dither);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.578 -0400", hash_original_method = "D611F7535670B80ECD8BF210909C26D1", hash_generated_method = "2A918FAAC3C4C5F1DD17F974F87D0A35")
    public void setFilterBitmap(boolean filter) {
        addTaint(filter);
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.579 -0400", hash_original_method = "59192F5DE8ED3EA14FF77E774B104DE3", hash_generated_method = "5E55B460A30793DB0A8FC8DC0A3072A3")
    public final void setCallback(Callback cb) {
        mCallback = new WeakReference<Callback>(cb);
        // ---------- Original Method ----------
        //mCallback = new WeakReference<Callback>(cb);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.580 -0400", hash_original_method = "F8C083250821C64B63A1F88F9B7D8469", hash_generated_method = "55AA0550B0E605A37CA37FEF1BB7EABC")
    public Callback getCallback() {
        if(mCallback != null)        
        {
Callback var0D38433A1F7987775EAD658347614B1F_1919447015 =             mCallback.get();
            var0D38433A1F7987775EAD658347614B1F_1919447015.addTaint(taint);
            return var0D38433A1F7987775EAD658347614B1F_1919447015;
        } //End block
Callback var540C13E9E156B687226421B24F2DF178_1944825498 =         null;
        var540C13E9E156B687226421B24F2DF178_1944825498.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1944825498;
        // ---------- Original Method ----------
        //if (mCallback != null) {
            //return mCallback.get();
        //}
        //return null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.580 -0400", hash_original_method = "9D9FDBFF51AC2DBEF3B6FA3B8569CCD5", hash_generated_method = "9EA4568DF48ACF1FED84AAFFBBEE8298")
    public void invalidateSelf() {
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.581 -0400", hash_original_method = "4BA44AAA8396AA668795CA7F4E916174", hash_generated_method = "71E50E920252F49F7A0CC9F21B1955D6")
    public void scheduleSelf(Runnable what, long when) {
        addTaint(when);
        addTaint(what.getTaint());
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.581 -0400", hash_original_method = "40D05A483A091B37888582EA72925B1D", hash_generated_method = "BBF7526B5E42E9AFCE2ECE915BA2CBF4")
    public void unscheduleSelf(Runnable what) {
        addTaint(what.getTaint());
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.581 -0400", hash_original_method = "D8B32EDE038D6347583B50AC97BFE4A6", hash_generated_method = "FD9F445DF2968AC20B38B82B1915BF50")
    public int getResolvedLayoutDirectionSelf() {
        final Callback callback = getCallback();
        if(callback == null || !(callback instanceof Callback2))        
        {
            int var0022DEAFD3E04A6D20D4B94D2FF4C05B_1638400719 = (View.LAYOUT_DIRECTION_LTR);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_686872749 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_686872749;
        } //End block
        int var6B3F0A4008CE8725BD0E2561C9D8B37B_456931532 = (((Callback2) callback).getResolvedLayoutDirection(this));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1671965013 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1671965013;
        // ---------- Original Method ----------
        //final Callback callback = getCallback();
        //if (callback == null || !(callback instanceof Callback2)) {
            //return View.LAYOUT_DIRECTION_LTR;
        //}
        //return ((Callback2) callback).getResolvedLayoutDirection(this);
    }

    
    @DSModeled(DSC.SAFE)
    public abstract void setAlpha(int alpha);

    
    @DSModeled(DSC.SAFE)
    public abstract void setColorFilter(ColorFilter cf);

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.582 -0400", hash_original_method = "F0522F608E5F96C5D99BDA1CF055B16B", hash_generated_method = "82F2F9139C91606BA4049E282C3A6407")
    public void setColorFilter(int color, PorterDuff.Mode mode) {
        addTaint(mode.getTaint());
        addTaint(color);
        setColorFilter(new PorterDuffColorFilter(color, mode));
        // ---------- Original Method ----------
        //setColorFilter(new PorterDuffColorFilter(color, mode));
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.582 -0400", hash_original_method = "B358CFD4AAFD748C624F742F21F12081", hash_generated_method = "4583F0874D1CBB724BCBB622A001163D")
    public void clearColorFilter() {
        setColorFilter(null);
        // ---------- Original Method ----------
        //setColorFilter(null);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.583 -0400", hash_original_method = "5AE02876CD642F1B59606A09240D1BD0", hash_generated_method = "4B6529742CB92BB39702492D6F04D1F7")
    public boolean isStateful() {
        boolean var68934A3E9455FA72420237EB05902327_804096692 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_628184628 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_628184628;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.583 -0400", hash_original_method = "A73F586C823927F65CC09CAB74021FD5", hash_generated_method = "F0EBFA2AD81FE49033C5D85B23DCEC0C")
    public boolean setState(final int[] stateSet) {
        if(!Arrays.equals(mStateSet, stateSet))        
        {
            mStateSet = stateSet;
            boolean var43561160AA76887B81E5205BFE4B5BD0_2041507827 = (onStateChange(stateSet));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_938279307 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_938279307;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1156165272 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1362864272 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1362864272;
        // ---------- Original Method ----------
        //if (!Arrays.equals(mStateSet, stateSet)) {
            //mStateSet = stateSet;
            //return onStateChange(stateSet);
        //}
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.584 -0400", hash_original_method = "2C3685292135F2FEA5B926C5A0764B84", hash_generated_method = "8E7AA8C24A3C862474DAD10B01FA41D0")
    public int[] getState() {
        int[] varB62ED08B4FC39BA78C89759B6325D440_1230091581 = (mStateSet);
                int[] varB4CCCA26F9DB9189C32F33E82D425CFB_1856626889 = {getTaintInt()};
        return varB4CCCA26F9DB9189C32F33E82D425CFB_1856626889;
        // ---------- Original Method ----------
        //return mStateSet;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.584 -0400", hash_original_method = "1A9E62CA8A2399C6C2BEF07B26352781", hash_generated_method = "0131A8711CA5A4121C3000F639F15FB6")
    public void jumpToCurrentState() {
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.584 -0400", hash_original_method = "00D08FCE0657F40CBD93DF1CB810B766", hash_generated_method = "44B74FCF0BA91A1C403F7982122AB147")
    public Drawable getCurrent() {
Drawable var72A74007B2BE62B849F475C7BDA4658B_1525060685 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1525060685.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1525060685;
        // ---------- Original Method ----------
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.585 -0400", hash_original_method = "9037BFCAC5FB09B2A9E758C0533961C8", hash_generated_method = "0463CED238AC2646B1A472EB54A35B9D")
    public final boolean setLevel(int level) {
        if(mLevel != level)        
        {
            mLevel = level;
            boolean var76A495662E128251D692A5AE4EE3B709_1435614951 = (onLevelChange(level));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_383264398 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_383264398;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1465538982 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_633837044 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_633837044;
        // ---------- Original Method ----------
        //if (mLevel != level) {
            //mLevel = level;
            //return onLevelChange(level);
        //}
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.585 -0400", hash_original_method = "3688C6710C4CB9729612AA02E692BC0A", hash_generated_method = "776E761346ED14C6D9FC3D6EB2C894EA")
    public final int getLevel() {
        int varD3512852EA3D6B78A96B5192CDA7B029_2091710884 = (mLevel);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_257024382 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_257024382;
        // ---------- Original Method ----------
        //return mLevel;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.585 -0400", hash_original_method = "385D529E13116BE326F07B115E2B9363", hash_generated_method = "056863A46741312FC1BFB9B1A0A7373B")
    public boolean setVisible(boolean visible, boolean restart) {
        addTaint(restart);
        boolean changed = mVisible != visible;
        if(changed)        
        {
            mVisible = visible;
            invalidateSelf();
        } //End block
        boolean var8977DFAC2F8E04CB96E66882235F5ABA_1901650461 = (changed);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1589889036 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1589889036;
        // ---------- Original Method ----------
        //boolean changed = mVisible != visible;
        //if (changed) {
            //mVisible = visible;
            //invalidateSelf();
        //}
        //return changed;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.586 -0400", hash_original_method = "5E5A2EDE31F4C9B537E19F3E9904B493", hash_generated_method = "C11F55C1411829B5FBE8D266008ABE32")
    public final boolean isVisible() {
        boolean var807A18BD291896E7D3B58F90DB9F75FD_842332170 = (mVisible);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_937218354 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_937218354;
        // ---------- Original Method ----------
        //return mVisible;
    }

    
    @DSModeled(DSC.SAFE)
    public abstract int getOpacity();

    
    @DSModeled(DSC.SAFE)
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.587 -0400", hash_original_method = "6885EC41EEEA48BF379C9186E23112DE", hash_generated_method = "862AE0B93213783290D05E02A60CBFFB")
    public Region getTransparentRegion() {
Region var540C13E9E156B687226421B24F2DF178_1877404556 =         null;
        var540C13E9E156B687226421B24F2DF178_1877404556.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1877404556;
        // ---------- Original Method ----------
        //return null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.587 -0400", hash_original_method = "B7A8462AFC13A6E0F2F8BCB43385BD49", hash_generated_method = "65FFD15BBE50B2208A798F77DEC81DAD")
    protected boolean onStateChange(int[] state) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(state[0]);
        boolean var68934A3E9455FA72420237EB05902327_1155211779 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1797707246 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1797707246;
        // ---------- Original Method ----------
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.587 -0400", hash_original_method = "37D330857F7202D119AB7FE43B955D5E", hash_generated_method = "2807768C53A8E7A3A11074E41280E083")
    protected boolean onLevelChange(int level) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(level);
        boolean var68934A3E9455FA72420237EB05902327_1786889813 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_997961683 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_997961683;
        // ---------- Original Method ----------
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.588 -0400", hash_original_method = "F81B37D492B4B76F5CB4F03B5248220C", hash_generated_method = "7C8E1DAA609E686234CDB191EA8D6665")
    protected void onBoundsChange(Rect bounds) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(bounds.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.594 -0400", hash_original_method = "EB5466611B82CCCED48E9C76B5992F82", hash_generated_method = "AA91F08C2B1F242C8178ADC6D4D50D4B")
    public int getIntrinsicWidth() {
        int var6BB61E3B7BCE0931DA574D19D1D82C88_604639700 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_294723477 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_294723477;
        // ---------- Original Method ----------
        //return -1;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.594 -0400", hash_original_method = "4249F2736881F978DCEB3B683D79E5C9", hash_generated_method = "798CD351F2B184107D51AB1A24AA3309")
    public int getIntrinsicHeight() {
        int var6BB61E3B7BCE0931DA574D19D1D82C88_167730633 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1958837163 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1958837163;
        // ---------- Original Method ----------
        //return -1;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.595 -0400", hash_original_method = "5035EEEA88B512A7AC30F75048C2F85A", hash_generated_method = "A1758C29498E13C777F88C131CB00E38")
    public int getMinimumWidth() {
        final int intrinsicWidth = getIntrinsicWidth();
        int var23978333063B65F1597485B828B1C35F_1885700768 = (intrinsicWidth > 0 ? intrinsicWidth : 0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1602280689 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1602280689;
        // ---------- Original Method ----------
        //final int intrinsicWidth = getIntrinsicWidth();
        //return intrinsicWidth > 0 ? intrinsicWidth : 0;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.595 -0400", hash_original_method = "FB4CD88D7DE1F0713A1472841A364838", hash_generated_method = "13A2DB8840992C8CF9ED17EB90B40916")
    public int getMinimumHeight() {
        final int intrinsicHeight = getIntrinsicHeight();
        int var725C0E6EAF07A4AD02CE0158FD399541_660507863 = (intrinsicHeight > 0 ? intrinsicHeight : 0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1518511655 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1518511655;
        // ---------- Original Method ----------
        //final int intrinsicHeight = getIntrinsicHeight();
        //return intrinsicHeight > 0 ? intrinsicHeight : 0;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.596 -0400", hash_original_method = "3EEC3E25F33F4D98A0E1482CE3BAC48C", hash_generated_method = "A6010288791CA3A1F20F32357F6BE535")
    public boolean getPadding(Rect padding) {
        addTaint(padding.getTaint());
        padding.set(0, 0, 0, 0);
        boolean var68934A3E9455FA72420237EB05902327_733339572 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1485631926 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1485631926;
        // ---------- Original Method ----------
        //padding.set(0, 0, 0, 0);
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.596 -0400", hash_original_method = "4655CA169BE542FE87BF20A0D63A5DAC", hash_generated_method = "33489A8039ACE36126CE639952317392")
    public Drawable mutate() {
Drawable var72A74007B2BE62B849F475C7BDA4658B_370031308 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_370031308.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_370031308;
        // ---------- Original Method ----------
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    public static Drawable createFromStream(InputStream is, String srcName) {
        return createFromResourceStream(null, null, is, srcName, null);
    }

    
    @DSModeled(DSC.SAFE)
    public static Drawable createFromResourceStream(Resources res, TypedValue value,
            InputStream is, String srcName) {
        return createFromResourceStream(res, value, is, srcName, null);
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.600 -0400", hash_original_method = "A7AA835959A57BB8EBB74755836F5541", hash_generated_method = "07316ED934B2AF294C1098009C9AE884")
    public void inflate(Resources r, XmlPullParser parser, AttributeSet attrs) throws XmlPullParserException, IOException {
        addTaint(attrs.getTaint());
        addTaint(parser.getTaint());
        addTaint(r.getTaint());
        TypedArray a = r.obtainAttributes(attrs, com.android.internal.R.styleable.Drawable);
        inflateWithAttributes(r, parser, a, com.android.internal.R.styleable.Drawable_visible);
        a.recycle();
        // ---------- Original Method ----------
        //TypedArray a = r.obtainAttributes(attrs, com.android.internal.R.styleable.Drawable);
        //inflateWithAttributes(r, parser, a, com.android.internal.R.styleable.Drawable_visible);
        //a.recycle();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.601 -0400", hash_original_method = "9471DE214DF2BB650CFB53CA22D70654", hash_generated_method = "5B6F67A2C030E5AB7FDFC16A397CDC45")
     void inflateWithAttributes(Resources r, XmlPullParser parser,
            TypedArray attrs, int visibleAttr) throws XmlPullParserException, IOException {
        addTaint(parser.getTaint());
        addTaint(r.getTaint());
        mVisible = attrs.getBoolean(visibleAttr, mVisible);
        // ---------- Original Method ----------
        //mVisible = attrs.getBoolean(visibleAttr, mVisible);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.602 -0400", hash_original_method = "4B02BBF3CC1230B6CEECD73EA01A2039", hash_generated_method = "08CFF28A3974C4C65B96D845A2129E3C")
    public ConstantState getConstantState() {
ConstantState var540C13E9E156B687226421B24F2DF178_1421985647 =         null;
        var540C13E9E156B687226421B24F2DF178_1421985647.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1421985647;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSModeled(DSC.BAN)
    private static Drawable drawableFromBitmap(Resources res, Bitmap bm, byte[] np,
            Rect pad, String srcName) {
        if (np != null) {
            return new NinePatchDrawable(res, bm, np, pad, srcName);
        }
        return new BitmapDrawable(res, bm);
    }

    
    public static abstract class ConstantState {
        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.603 -0400", hash_original_method = "1DBA432D049F8FB288727BCBD6197568", hash_generated_method = "1DBA432D049F8FB288727BCBD6197568")
        public ConstantState ()
        {
            //Synthesized constructor
        }


        @DSModeled(DSC.SAFE)
        public abstract Drawable newDrawable();

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.604 -0400", hash_original_method = "5FCE46455F7833ADD9520B3BEB7232AE", hash_generated_method = "962C7B578FEBEA4BCF2E4F1C28EF5BB0")
        public Drawable newDrawable(Resources res) {
            addTaint(res.getTaint());
Drawable varB7C8EDA33AD2387A4E08E6A01D533089_1985116402 =             newDrawable();
            varB7C8EDA33AD2387A4E08E6A01D533089_1985116402.addTaint(taint);
            return varB7C8EDA33AD2387A4E08E6A01D533089_1985116402;
            // ---------- Original Method ----------
            //return newDrawable();
        }

        
        @DSModeled(DSC.SAFE)
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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.606 -0400", hash_original_field = "EE994C81FDCFE1430D43C52DAFF20E29", hash_generated_field = "CB60BBB38B09F6F2A3773B2329AD705D")

    private static final Rect ZERO_BOUNDS_RECT = new Rect();
}

