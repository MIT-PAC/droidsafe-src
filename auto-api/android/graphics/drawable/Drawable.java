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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.773 -0400", hash_original_field = "0C685B7B5DBE2FA698BB3FD957C188EC", hash_generated_field = "5E6D3F09C1210458D0C754595BB30DAC")

    private int[] mStateSet = StateSet.WILD_CARD;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.774 -0400", hash_original_field = "8D44C0A2CA7183B234B6C68F8099BDEB", hash_generated_field = "D66D669C7CB840BE2CC0AE88CB04AECF")

    private int mLevel = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.774 -0400", hash_original_field = "86B23CE72C8A42818E7EE79FD7E2AE4B", hash_generated_field = "D35ACD87C9C873D3BC15F23EE9468A4E")

    private int mChangingConfigurations = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.774 -0400", hash_original_field = "784242F59B753F521066A454CCC756BA", hash_generated_field = "294018A0A81D2A146053DB5D50BCF6B8")

    private Rect mBounds = ZERO_BOUNDS_RECT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.774 -0400", hash_original_field = "FB4EA1EB8D0E2C3D632A8208BE66A5E8", hash_generated_field = "9948EC0F011800FDF4A6CE610A87E55B")

    private WeakReference<Callback> mCallback = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.774 -0400", hash_original_field = "A6C9F3531043C8B637D2AF4F9D36CD07", hash_generated_field = "B5A582F9AADED234805D7CA1D8129D36")

    private boolean mVisible = true;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.774 -0400", hash_original_method = "31C0F11C44C8FA6382C02786623A036E", hash_generated_method = "31C0F11C44C8FA6382C02786623A036E")
    public Drawable ()
    {
        //Synthesized constructor
    }


    public abstract void draw(Canvas canvas);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.791 -0400", hash_original_method = "16D67C97CF930C94423B2F0ABE9E2FB8", hash_generated_method = "A9F821D01B5FBB29AD61662DE8263D93")
    public void setBounds(int left, int top, int right, int bottom) {
        Rect oldBounds;
        oldBounds = mBounds;
        {
            oldBounds = mBounds = new Rect();
        } //End block
        {
            mBounds.set(left, top, right, bottom);
            onBoundsChange(mBounds);
        } //End block
        addTaint(left);
        addTaint(top);
        addTaint(right);
        addTaint(bottom);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.792 -0400", hash_original_method = "343A23DF727C21562F2BBDB7DAA5F811", hash_generated_method = "B75082F091415330B057D05F7820B159")
    public void setBounds(Rect bounds) {
        setBounds(bounds.left, bounds.top, bounds.right, bounds.bottom);
        addTaint(bounds.getTaint());
        // ---------- Original Method ----------
        //setBounds(bounds.left, bounds.top, bounds.right, bounds.bottom);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.792 -0400", hash_original_method = "2860BC8F60A9356A6AA851AD0EDF9049", hash_generated_method = "7EFC8A7D42A6F8EA01FFEA6D2011CB75")
    public final void copyBounds(Rect bounds) {
        bounds.set(mBounds);
        addTaint(bounds.getTaint());
        // ---------- Original Method ----------
        //bounds.set(mBounds);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.794 -0400", hash_original_method = "A623AF26CC98262C126F58F99B918C3F", hash_generated_method = "25E3F42D072F5AB053BA9A966AD18381")
    public final Rect copyBounds() {
        Rect varB4EAC82CA7396A68D541C85D26508E83_350832955 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_350832955 = new Rect(mBounds);
        varB4EAC82CA7396A68D541C85D26508E83_350832955.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_350832955;
        // ---------- Original Method ----------
        //return new Rect(mBounds);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.809 -0400", hash_original_method = "F9C4E095C08A855B9547E5FC046C50BF", hash_generated_method = "505F288A5615EAF24D7DA3D8BC9DC3C3")
    public final Rect getBounds() {
        Rect varB4EAC82CA7396A68D541C85D26508E83_1561090772 = null; //Variable for return #1
        {
            mBounds = new Rect();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1561090772 = mBounds;
        varB4EAC82CA7396A68D541C85D26508E83_1561090772.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1561090772;
        // ---------- Original Method ----------
        //if (mBounds == ZERO_BOUNDS_RECT) {
            //mBounds = new Rect();
        //}
        //return mBounds;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.817 -0400", hash_original_method = "E7340D87AE9D08581CEC5A0FAA0552EE", hash_generated_method = "579750A184ACECD2EAA7D466EBD356DF")
    public void setChangingConfigurations(int configs) {
        mChangingConfigurations = configs;
        // ---------- Original Method ----------
        //mChangingConfigurations = configs;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.818 -0400", hash_original_method = "9E7D7C67EAC365FF19BD4971762612A5", hash_generated_method = "36DBBB7281E526F8D0B05E24521DC24C")
    public int getChangingConfigurations() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1153215113 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1153215113;
        // ---------- Original Method ----------
        //return mChangingConfigurations;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.838 -0400", hash_original_method = "A73E6D639014FDB13967AD6B494837C8", hash_generated_method = "4F5D1BE5F2EFBD95EEA7C718FF48A1E8")
    public void setDither(boolean dither) {
        addTaint(dither);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.839 -0400", hash_original_method = "D611F7535670B80ECD8BF210909C26D1", hash_generated_method = "2A918FAAC3C4C5F1DD17F974F87D0A35")
    public void setFilterBitmap(boolean filter) {
        addTaint(filter);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.839 -0400", hash_original_method = "59192F5DE8ED3EA14FF77E774B104DE3", hash_generated_method = "5E55B460A30793DB0A8FC8DC0A3072A3")
    public final void setCallback(Callback cb) {
        mCallback = new WeakReference<Callback>(cb);
        // ---------- Original Method ----------
        //mCallback = new WeakReference<Callback>(cb);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.859 -0400", hash_original_method = "F8C083250821C64B63A1F88F9B7D8469", hash_generated_method = "E589C211273C36074AFE7412E1304D23")
    public Callback getCallback() {
        Callback varB4EAC82CA7396A68D541C85D26508E83_255076916 = null; //Variable for return #1
        Callback varB4EAC82CA7396A68D541C85D26508E83_1285164819 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_255076916 = mCallback.get();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1285164819 = null;
        Callback varA7E53CE21691AB073D9660D615818899_955817433; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_955817433 = varB4EAC82CA7396A68D541C85D26508E83_255076916;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_955817433 = varB4EAC82CA7396A68D541C85D26508E83_1285164819;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_955817433.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_955817433;
        // ---------- Original Method ----------
        //if (mCallback != null) {
            //return mCallback.get();
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.865 -0400", hash_original_method = "9D9FDBFF51AC2DBEF3B6FA3B8569CCD5", hash_generated_method = "897D4E925665E675B18EA7C0DC0BCBB3")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.868 -0400", hash_original_method = "4BA44AAA8396AA668795CA7F4E916174", hash_generated_method = "C7A92E06F313F90988F365F1828CD4DD")
    public void scheduleSelf(Runnable what, long when) {
        Callback callback;
        callback = getCallback();
        {
            callback.scheduleDrawable(this, what, when);
        } //End block
        addTaint(what.getTaint());
        addTaint(when);
        // ---------- Original Method ----------
        //final Callback callback = getCallback();
        //if (callback != null) {
            //callback.scheduleDrawable(this, what, when);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.871 -0400", hash_original_method = "40D05A483A091B37888582EA72925B1D", hash_generated_method = "4C55D0359759EB30D64E1D9928CB24E1")
    public void unscheduleSelf(Runnable what) {
        Callback callback;
        callback = getCallback();
        {
            callback.unscheduleDrawable(this, what);
        } //End block
        addTaint(what.getTaint());
        // ---------- Original Method ----------
        //final Callback callback = getCallback();
        //if (callback != null) {
            //callback.unscheduleDrawable(this, what);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.872 -0400", hash_original_method = "D8B32EDE038D6347583B50AC97BFE4A6", hash_generated_method = "8038C817D3A66FE41E6AF518F09CCC9A")
    public int getResolvedLayoutDirectionSelf() {
        Callback callback;
        callback = getCallback();
        int var75736B757CD8B520406B8464AF443B02_667241869 = (((Callback2) callback).getResolvedLayoutDirection(this));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_526790270 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_526790270;
        // ---------- Original Method ----------
        //final Callback callback = getCallback();
        //if (callback == null || !(callback instanceof Callback2)) {
            //return View.LAYOUT_DIRECTION_LTR;
        //}
        //return ((Callback2) callback).getResolvedLayoutDirection(this);
    }

    
    public abstract void setAlpha(int alpha);

    
    public abstract void setColorFilter(ColorFilter cf);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.892 -0400", hash_original_method = "F0522F608E5F96C5D99BDA1CF055B16B", hash_generated_method = "C2926271377446C3A66DA12B7ECADC08")
    public void setColorFilter(int color, PorterDuff.Mode mode) {
        setColorFilter(new PorterDuffColorFilter(color, mode));
        addTaint(color);
        addTaint(mode.getTaint());
        // ---------- Original Method ----------
        //setColorFilter(new PorterDuffColorFilter(color, mode));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.892 -0400", hash_original_method = "B358CFD4AAFD748C624F742F21F12081", hash_generated_method = "4583F0874D1CBB724BCBB622A001163D")
    public void clearColorFilter() {
        setColorFilter(null);
        // ---------- Original Method ----------
        //setColorFilter(null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.893 -0400", hash_original_method = "5AE02876CD642F1B59606A09240D1BD0", hash_generated_method = "4206D6DA89C0F8788876B4A4C2A99C86")
    public boolean isStateful() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_78498713 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_78498713;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.897 -0400", hash_original_method = "A73F586C823927F65CC09CAB74021FD5", hash_generated_method = "CAB459D30D89FF4B62F6752458F7400B")
    public boolean setState(final int[] stateSet) {
        {
            boolean var5240CDA1CB2272B8BE70FE042E3A6089_1413222741 = (!Arrays.equals(mStateSet, stateSet));
            {
                mStateSet = stateSet;
                boolean var2E8C85253ED8EDDED71485E563D55CAD_2003575695 = (onStateChange(stateSet));
            } //End block
        } //End collapsed parenthetic
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2056928439 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2056928439;
        // ---------- Original Method ----------
        //if (!Arrays.equals(mStateSet, stateSet)) {
            //mStateSet = stateSet;
            //return onStateChange(stateSet);
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.898 -0400", hash_original_method = "2C3685292135F2FEA5B926C5A0764B84", hash_generated_method = "997CF60AFC384DDF85E30ADC42969B3D")
    public int[] getState() {
        int[] varB4CCCA26F9DB9189C32F33E82D425CFB_1622191151 = {getTaintInt()};
        return varB4CCCA26F9DB9189C32F33E82D425CFB_1622191151;
        // ---------- Original Method ----------
        //return mStateSet;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.917 -0400", hash_original_method = "1A9E62CA8A2399C6C2BEF07B26352781", hash_generated_method = "0131A8711CA5A4121C3000F639F15FB6")
    public void jumpToCurrentState() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.918 -0400", hash_original_method = "00D08FCE0657F40CBD93DF1CB810B766", hash_generated_method = "8078CD262FC03FE75D8673D207EA5837")
    public Drawable getCurrent() {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_227055416 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_227055416 = this;
        varB4EAC82CA7396A68D541C85D26508E83_227055416.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_227055416;
        // ---------- Original Method ----------
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.919 -0400", hash_original_method = "9037BFCAC5FB09B2A9E758C0533961C8", hash_generated_method = "E31A2A6FD5C4D751DF7E53181F29293C")
    public final boolean setLevel(int level) {
        {
            mLevel = level;
            boolean var9872BA4A333C94281EC3A1CE7EB34844_1487494633 = (onLevelChange(level));
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1287608383 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1287608383;
        // ---------- Original Method ----------
        //if (mLevel != level) {
            //mLevel = level;
            //return onLevelChange(level);
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.920 -0400", hash_original_method = "3688C6710C4CB9729612AA02E692BC0A", hash_generated_method = "42E61952F13F4F30BAB8805A08FF17CE")
    public final int getLevel() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1268029347 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1268029347;
        // ---------- Original Method ----------
        //return mLevel;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.943 -0400", hash_original_method = "385D529E13116BE326F07B115E2B9363", hash_generated_method = "4CD4A60C1339765CB50F1E618C2FA0E7")
    public boolean setVisible(boolean visible, boolean restart) {
        boolean changed;
        changed = mVisible != visible;
        {
            mVisible = visible;
            invalidateSelf();
        } //End block
        addTaint(restart);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1632135653 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1632135653;
        // ---------- Original Method ----------
        //boolean changed = mVisible != visible;
        //if (changed) {
            //mVisible = visible;
            //invalidateSelf();
        //}
        //return changed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.943 -0400", hash_original_method = "5E5A2EDE31F4C9B537E19F3E9904B493", hash_generated_method = "6F8D07396E6E774100537345F2AC8965")
    public final boolean isVisible() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_834234670 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_834234670;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.944 -0400", hash_original_method = "6885EC41EEEA48BF379C9186E23112DE", hash_generated_method = "A03F37289DC5AE9539117794D1AF10B6")
    public Region getTransparentRegion() {
        Region varB4EAC82CA7396A68D541C85D26508E83_1899985390 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1899985390 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1899985390.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1899985390;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.956 -0400", hash_original_method = "B7A8462AFC13A6E0F2F8BCB43385BD49", hash_generated_method = "2E8C7F29088E3D4B41C56FFF83E56F75")
    protected boolean onStateChange(int[] state) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(state[0]);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1919499047 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1919499047;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.956 -0400", hash_original_method = "37D330857F7202D119AB7FE43B955D5E", hash_generated_method = "26A7BC19002CE88DD6E567FCA7F43848")
    protected boolean onLevelChange(int level) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(level);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1317619990 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1317619990;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.957 -0400", hash_original_method = "F81B37D492B4B76F5CB4F03B5248220C", hash_generated_method = "7C8E1DAA609E686234CDB191EA8D6665")
    protected void onBoundsChange(Rect bounds) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(bounds.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.957 -0400", hash_original_method = "EB5466611B82CCCED48E9C76B5992F82", hash_generated_method = "A676FE2E5658835FF0C325D71D16543B")
    public int getIntrinsicWidth() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1819728416 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1819728416;
        // ---------- Original Method ----------
        //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.967 -0400", hash_original_method = "4249F2736881F978DCEB3B683D79E5C9", hash_generated_method = "F05FD97A96150BC3DD63FA5BDF64173B")
    public int getIntrinsicHeight() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_917445226 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_917445226;
        // ---------- Original Method ----------
        //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.967 -0400", hash_original_method = "5035EEEA88B512A7AC30F75048C2F85A", hash_generated_method = "71CBE86267B2CE52C7AF513DB6BB650D")
    public int getMinimumWidth() {
        int intrinsicWidth;
        intrinsicWidth = getIntrinsicWidth();
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1773326170 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1773326170;
        // ---------- Original Method ----------
        //final int intrinsicWidth = getIntrinsicWidth();
        //return intrinsicWidth > 0 ? intrinsicWidth : 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.968 -0400", hash_original_method = "FB4CD88D7DE1F0713A1472841A364838", hash_generated_method = "3ECA9CF189371289EBDE52F7133D26A0")
    public int getMinimumHeight() {
        int intrinsicHeight;
        intrinsicHeight = getIntrinsicHeight();
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_913430594 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_913430594;
        // ---------- Original Method ----------
        //final int intrinsicHeight = getIntrinsicHeight();
        //return intrinsicHeight > 0 ? intrinsicHeight : 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.968 -0400", hash_original_method = "3EEC3E25F33F4D98A0E1482CE3BAC48C", hash_generated_method = "5BCED6284606F6BF48EAA8A2951390D9")
    public boolean getPadding(Rect padding) {
        padding.set(0, 0, 0, 0);
        addTaint(padding.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_594975316 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_594975316;
        // ---------- Original Method ----------
        //padding.set(0, 0, 0, 0);
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.969 -0400", hash_original_method = "4655CA169BE542FE87BF20A0D63A5DAC", hash_generated_method = "70901F8E0E68506ACCFED47E81FAF6E9")
    public Drawable mutate() {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_873479305 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_873479305 = this;
        varB4EAC82CA7396A68D541C85D26508E83_873479305.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_873479305;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.988 -0400", hash_original_method = "A7AA835959A57BB8EBB74755836F5541", hash_generated_method = "5A889A525B7578E022A524EFCAB8F9A2")
    public void inflate(Resources r, XmlPullParser parser, AttributeSet attrs) throws XmlPullParserException, IOException {
        TypedArray a;
        a = r.obtainAttributes(attrs, com.android.internal.R.styleable.Drawable);
        inflateWithAttributes(r, parser, a, com.android.internal.R.styleable.Drawable_visible);
        a.recycle();
        addTaint(r.getTaint());
        addTaint(parser.getTaint());
        addTaint(attrs.getTaint());
        // ---------- Original Method ----------
        //TypedArray a = r.obtainAttributes(attrs, com.android.internal.R.styleable.Drawable);
        //inflateWithAttributes(r, parser, a, com.android.internal.R.styleable.Drawable_visible);
        //a.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.988 -0400", hash_original_method = "9471DE214DF2BB650CFB53CA22D70654", hash_generated_method = "08ADBA3045DE1758253A6BB72A5875ED")
     void inflateWithAttributes(Resources r, XmlPullParser parser,
            TypedArray attrs, int visibleAttr) throws XmlPullParserException, IOException {
        mVisible = attrs.getBoolean(visibleAttr, mVisible);
        addTaint(r.getTaint());
        addTaint(parser.getTaint());
        // ---------- Original Method ----------
        //mVisible = attrs.getBoolean(visibleAttr, mVisible);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.989 -0400", hash_original_method = "4B02BBF3CC1230B6CEECD73EA01A2039", hash_generated_method = "F30FB62DE7C6536F54285560C1EE422A")
    public ConstantState getConstantState() {
        ConstantState varB4EAC82CA7396A68D541C85D26508E83_818062600 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_818062600 = null;
        varB4EAC82CA7396A68D541C85D26508E83_818062600.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_818062600;
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.008 -0400", hash_original_method = "1DBA432D049F8FB288727BCBD6197568", hash_generated_method = "1DBA432D049F8FB288727BCBD6197568")
        public ConstantState ()
        {
            //Synthesized constructor
        }


        public abstract Drawable newDrawable();

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.009 -0400", hash_original_method = "5FCE46455F7833ADD9520B3BEB7232AE", hash_generated_method = "643EA9FB8FCEF04C0F1E6937839E74AD")
        public Drawable newDrawable(Resources res) {
            Drawable varB4EAC82CA7396A68D541C85D26508E83_976616414 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_976616414 = newDrawable();
            addTaint(res.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_976616414.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_976616414;
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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.010 -0400", hash_original_field = "EE994C81FDCFE1430D43C52DAFF20E29", hash_generated_field = "82C02C072E33B8A6797EFC5EE6126FA7")

    private static Rect ZERO_BOUNDS_RECT = new Rect();
}

