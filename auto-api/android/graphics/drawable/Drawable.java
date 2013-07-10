package android.graphics.drawable;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.759 -0400", hash_original_field = "0C685B7B5DBE2FA698BB3FD957C188EC", hash_generated_field = "5E6D3F09C1210458D0C754595BB30DAC")

    private int[] mStateSet = StateSet.WILD_CARD;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.759 -0400", hash_original_field = "8D44C0A2CA7183B234B6C68F8099BDEB", hash_generated_field = "D66D669C7CB840BE2CC0AE88CB04AECF")

    private int mLevel = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.759 -0400", hash_original_field = "86B23CE72C8A42818E7EE79FD7E2AE4B", hash_generated_field = "D35ACD87C9C873D3BC15F23EE9468A4E")

    private int mChangingConfigurations = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.759 -0400", hash_original_field = "784242F59B753F521066A454CCC756BA", hash_generated_field = "294018A0A81D2A146053DB5D50BCF6B8")

    private Rect mBounds = ZERO_BOUNDS_RECT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.759 -0400", hash_original_field = "FB4EA1EB8D0E2C3D632A8208BE66A5E8", hash_generated_field = "9948EC0F011800FDF4A6CE610A87E55B")

    private WeakReference<Callback> mCallback = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.759 -0400", hash_original_field = "A6C9F3531043C8B637D2AF4F9D36CD07", hash_generated_field = "B5A582F9AADED234805D7CA1D8129D36")

    private boolean mVisible = true;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.759 -0400", hash_original_method = "31C0F11C44C8FA6382C02786623A036E", hash_generated_method = "31C0F11C44C8FA6382C02786623A036E")
    public Drawable ()
    {
        
    }


    public abstract void draw(Canvas canvas);

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.760 -0400", hash_original_method = "16D67C97CF930C94423B2F0ABE9E2FB8", hash_generated_method = "2C3A046CC5D232DBBA5C4604FB21E1F8")
    public void setBounds(int left, int top, int right, int bottom) {
        Rect oldBounds = mBounds;
        {
            oldBounds = mBounds = new Rect();
        } 
        {
            mBounds.set(left, top, right, bottom);
            onBoundsChange(mBounds);
        } 
        addTaint(left);
        addTaint(top);
        addTaint(right);
        addTaint(bottom);
        
        
        
            
        
        
                
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.760 -0400", hash_original_method = "343A23DF727C21562F2BBDB7DAA5F811", hash_generated_method = "B75082F091415330B057D05F7820B159")
    public void setBounds(Rect bounds) {
        setBounds(bounds.left, bounds.top, bounds.right, bounds.bottom);
        addTaint(bounds.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.761 -0400", hash_original_method = "2860BC8F60A9356A6AA851AD0EDF9049", hash_generated_method = "7EFC8A7D42A6F8EA01FFEA6D2011CB75")
    public final void copyBounds(Rect bounds) {
        bounds.set(mBounds);
        addTaint(bounds.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.761 -0400", hash_original_method = "A623AF26CC98262C126F58F99B918C3F", hash_generated_method = "3593D2CCB327ADE18C4265BD4B61F4A7")
    public final Rect copyBounds() {
        Rect varB4EAC82CA7396A68D541C85D26508E83_315296405 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_315296405 = new Rect(mBounds);
        varB4EAC82CA7396A68D541C85D26508E83_315296405.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_315296405;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.763 -0400", hash_original_method = "F9C4E095C08A855B9547E5FC046C50BF", hash_generated_method = "E5DA9D2A8C937C00F4089BA50DE46C4B")
    public final Rect getBounds() {
        Rect varB4EAC82CA7396A68D541C85D26508E83_1600931217 = null; 
        {
            mBounds = new Rect();
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1600931217 = mBounds;
        varB4EAC82CA7396A68D541C85D26508E83_1600931217.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1600931217;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.763 -0400", hash_original_method = "E7340D87AE9D08581CEC5A0FAA0552EE", hash_generated_method = "579750A184ACECD2EAA7D466EBD356DF")
    public void setChangingConfigurations(int configs) {
        mChangingConfigurations = configs;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.763 -0400", hash_original_method = "9E7D7C67EAC365FF19BD4971762612A5", hash_generated_method = "452CF669B7ED89391376E48E8C2623FE")
    public int getChangingConfigurations() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_281842287 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_281842287;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.764 -0400", hash_original_method = "A73E6D639014FDB13967AD6B494837C8", hash_generated_method = "4F5D1BE5F2EFBD95EEA7C718FF48A1E8")
    public void setDither(boolean dither) {
        addTaint(dither);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.764 -0400", hash_original_method = "D611F7535670B80ECD8BF210909C26D1", hash_generated_method = "2A918FAAC3C4C5F1DD17F974F87D0A35")
    public void setFilterBitmap(boolean filter) {
        addTaint(filter);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.765 -0400", hash_original_method = "59192F5DE8ED3EA14FF77E774B104DE3", hash_generated_method = "5E55B460A30793DB0A8FC8DC0A3072A3")
    public final void setCallback(Callback cb) {
        mCallback = new WeakReference<Callback>(cb);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.766 -0400", hash_original_method = "F8C083250821C64B63A1F88F9B7D8469", hash_generated_method = "7D6E5BF0C00594CDE4802DF590C490D3")
    public Callback getCallback() {
        Callback varB4EAC82CA7396A68D541C85D26508E83_1870110631 = null; 
        Callback varB4EAC82CA7396A68D541C85D26508E83_689502292 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1870110631 = mCallback.get();
        } 
        varB4EAC82CA7396A68D541C85D26508E83_689502292 = null;
        Callback varA7E53CE21691AB073D9660D615818899_987970292; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_987970292 = varB4EAC82CA7396A68D541C85D26508E83_1870110631;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_987970292 = varB4EAC82CA7396A68D541C85D26508E83_689502292;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_987970292.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_987970292;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.766 -0400", hash_original_method = "9D9FDBFF51AC2DBEF3B6FA3B8569CCD5", hash_generated_method = "13A4DF538C7B56FF960FE4ED2281E0C6")
    public void invalidateSelf() {
        final Callback callback = getCallback();
        {
            callback.invalidateDrawable(this);
        } 
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.767 -0400", hash_original_method = "4BA44AAA8396AA668795CA7F4E916174", hash_generated_method = "A4921FDCFD31786AF4C03EE8AB145680")
    public void scheduleSelf(Runnable what, long when) {
        final Callback callback = getCallback();
        {
            callback.scheduleDrawable(this, what, when);
        } 
        addTaint(what.getTaint());
        addTaint(when);
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.767 -0400", hash_original_method = "40D05A483A091B37888582EA72925B1D", hash_generated_method = "FF5DE0985B90D7AE9A6B59E7A4E89CED")
    public void unscheduleSelf(Runnable what) {
        final Callback callback = getCallback();
        {
            callback.unscheduleDrawable(this, what);
        } 
        addTaint(what.getTaint());
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.768 -0400", hash_original_method = "D8B32EDE038D6347583B50AC97BFE4A6", hash_generated_method = "6434DC928955982AE3FFCAC6109A7454")
    public int getResolvedLayoutDirectionSelf() {
        final Callback callback = getCallback();
        int var75736B757CD8B520406B8464AF443B02_1942621602 = (((Callback2) callback).getResolvedLayoutDirection(this));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1897668078 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1897668078;
        
        
        
            
        
        
    }

    
    public abstract void setAlpha(int alpha);

    
    public abstract void setColorFilter(ColorFilter cf);

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.769 -0400", hash_original_method = "F0522F608E5F96C5D99BDA1CF055B16B", hash_generated_method = "C2926271377446C3A66DA12B7ECADC08")
    public void setColorFilter(int color, PorterDuff.Mode mode) {
        setColorFilter(new PorterDuffColorFilter(color, mode));
        addTaint(color);
        addTaint(mode.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.769 -0400", hash_original_method = "B358CFD4AAFD748C624F742F21F12081", hash_generated_method = "4583F0874D1CBB724BCBB622A001163D")
    public void clearColorFilter() {
        setColorFilter(null);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.769 -0400", hash_original_method = "5AE02876CD642F1B59606A09240D1BD0", hash_generated_method = "94396CA5A9ECABB8044DC7D96EFA1008")
    public boolean isStateful() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1686453911 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1686453911;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.770 -0400", hash_original_method = "A73F586C823927F65CC09CAB74021FD5", hash_generated_method = "04BD85677701497A8E0ABF1D54135B44")
    public boolean setState(final int[] stateSet) {
        {
            boolean var5240CDA1CB2272B8BE70FE042E3A6089_1608497646 = (!Arrays.equals(mStateSet, stateSet));
            {
                mStateSet = stateSet;
                boolean var2E8C85253ED8EDDED71485E563D55CAD_844228322 = (onStateChange(stateSet));
            } 
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_983764206 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_983764206;
        
        
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.770 -0400", hash_original_method = "2C3685292135F2FEA5B926C5A0764B84", hash_generated_method = "F404D3CBF3C4A4BE3F4C2AE56D093BAE")
    public int[] getState() {
        int[] varB4CCCA26F9DB9189C32F33E82D425CFB_1486691985 = {getTaintInt()};
        return varB4CCCA26F9DB9189C32F33E82D425CFB_1486691985;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.770 -0400", hash_original_method = "1A9E62CA8A2399C6C2BEF07B26352781", hash_generated_method = "0131A8711CA5A4121C3000F639F15FB6")
    public void jumpToCurrentState() {
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.771 -0400", hash_original_method = "00D08FCE0657F40CBD93DF1CB810B766", hash_generated_method = "3F888C8336BB3120741B33358C60A615")
    public Drawable getCurrent() {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_75679362 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_75679362 = this;
        varB4EAC82CA7396A68D541C85D26508E83_75679362.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_75679362;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.772 -0400", hash_original_method = "9037BFCAC5FB09B2A9E758C0533961C8", hash_generated_method = "888917705402269B1A48AB8752B70465")
    public final boolean setLevel(int level) {
        {
            mLevel = level;
            boolean var9872BA4A333C94281EC3A1CE7EB34844_529247623 = (onLevelChange(level));
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1386910744 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1386910744;
        
        
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.772 -0400", hash_original_method = "3688C6710C4CB9729612AA02E692BC0A", hash_generated_method = "60FD2D9781AE4052895B834049BEF055")
    public final int getLevel() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1417678766 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1417678766;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.773 -0400", hash_original_method = "385D529E13116BE326F07B115E2B9363", hash_generated_method = "3A4E2D12D3B7395EA8B5C8D793EAA980")
    public boolean setVisible(boolean visible, boolean restart) {
        boolean changed = mVisible != visible;
        {
            mVisible = visible;
            invalidateSelf();
        } 
        addTaint(restart);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_685484423 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_685484423;
        
        
        
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.774 -0400", hash_original_method = "5E5A2EDE31F4C9B537E19F3E9904B493", hash_generated_method = "FE8C8D641E4AFF5597B5130186150FE9")
    public final boolean isVisible() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_288349819 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_288349819;
        
        
    }

    
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.776 -0400", hash_original_method = "6885EC41EEEA48BF379C9186E23112DE", hash_generated_method = "4FB8B4D5DC46F6070F6C37DC756B7AFC")
    public Region getTransparentRegion() {
        Region varB4EAC82CA7396A68D541C85D26508E83_1986835661 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1986835661 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1986835661.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1986835661;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.776 -0400", hash_original_method = "B7A8462AFC13A6E0F2F8BCB43385BD49", hash_generated_method = "6E08BA527F1735A87CB5E84B8A98B552")
    protected boolean onStateChange(int[] state) {
        
        addTaint(state[0]);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1530003786 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1530003786;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.776 -0400", hash_original_method = "37D330857F7202D119AB7FE43B955D5E", hash_generated_method = "4C962380068DB79AB8436CEDABC0B24D")
    protected boolean onLevelChange(int level) {
        
        addTaint(level);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1395690734 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1395690734;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.777 -0400", hash_original_method = "F81B37D492B4B76F5CB4F03B5248220C", hash_generated_method = "7C8E1DAA609E686234CDB191EA8D6665")
    protected void onBoundsChange(Rect bounds) {
        
        addTaint(bounds.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.777 -0400", hash_original_method = "EB5466611B82CCCED48E9C76B5992F82", hash_generated_method = "3C2B218A2F9483001955873B29D46F05")
    public int getIntrinsicWidth() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_539091646 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_539091646;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.778 -0400", hash_original_method = "4249F2736881F978DCEB3B683D79E5C9", hash_generated_method = "50414C243CF212DF6A04835C9BC85515")
    public int getIntrinsicHeight() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1180467211 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1180467211;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.778 -0400", hash_original_method = "5035EEEA88B512A7AC30F75048C2F85A", hash_generated_method = "16C983E46E1B1E5791E93859D3643B45")
    public int getMinimumWidth() {
        final int intrinsicWidth = getIntrinsicWidth();
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_769389967 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_769389967;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.778 -0400", hash_original_method = "FB4CD88D7DE1F0713A1472841A364838", hash_generated_method = "F1D46F5E5F3E33E3EAF40B1E9B536429")
    public int getMinimumHeight() {
        final int intrinsicHeight = getIntrinsicHeight();
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1282324388 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1282324388;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.779 -0400", hash_original_method = "3EEC3E25F33F4D98A0E1482CE3BAC48C", hash_generated_method = "D3AA21B1057671AD659B0F932C702852")
    public boolean getPadding(Rect padding) {
        padding.set(0, 0, 0, 0);
        addTaint(padding.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_746548521 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_746548521;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.779 -0400", hash_original_method = "4655CA169BE542FE87BF20A0D63A5DAC", hash_generated_method = "47DB3BE6B34DCB5EF5DA6D7ABADD5CCC")
    public Drawable mutate() {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_1428190328 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1428190328 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1428190328.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1428190328;
        
        
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.781 -0400", hash_original_method = "A7AA835959A57BB8EBB74755836F5541", hash_generated_method = "322D6AD741270D4F67E8B8AF9F1423E9")
    public void inflate(Resources r, XmlPullParser parser, AttributeSet attrs) throws XmlPullParserException, IOException {
        TypedArray a = r.obtainAttributes(attrs, com.android.internal.R.styleable.Drawable);
        inflateWithAttributes(r, parser, a, com.android.internal.R.styleable.Drawable_visible);
        a.recycle();
        addTaint(r.getTaint());
        addTaint(parser.getTaint());
        addTaint(attrs.getTaint());
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.782 -0400", hash_original_method = "9471DE214DF2BB650CFB53CA22D70654", hash_generated_method = "08ADBA3045DE1758253A6BB72A5875ED")
     void inflateWithAttributes(Resources r, XmlPullParser parser,
            TypedArray attrs, int visibleAttr) throws XmlPullParserException, IOException {
        mVisible = attrs.getBoolean(visibleAttr, mVisible);
        addTaint(r.getTaint());
        addTaint(parser.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.783 -0400", hash_original_method = "4B02BBF3CC1230B6CEECD73EA01A2039", hash_generated_method = "4CC50822DD94DB1AB9C6924F0C239473")
    public ConstantState getConstantState() {
        ConstantState varB4EAC82CA7396A68D541C85D26508E83_1785392083 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1785392083 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1785392083.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1785392083;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    private static Drawable drawableFromBitmap(Resources res, Bitmap bm, byte[] np,
            Rect pad, String srcName) {
        if (np != null) {
            return new NinePatchDrawable(res, bm, np, pad, srcName);
        }
        return new BitmapDrawable(res, bm);
    }

    
    public static abstract class ConstantState {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.784 -0400", hash_original_method = "1DBA432D049F8FB288727BCBD6197568", hash_generated_method = "1DBA432D049F8FB288727BCBD6197568")
        public ConstantState ()
        {
            
        }


        public abstract Drawable newDrawable();

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.786 -0400", hash_original_method = "5FCE46455F7833ADD9520B3BEB7232AE", hash_generated_method = "74080BA37AC37300A5E6EAC06D2CA412")
        public Drawable newDrawable(Resources res) {
            Drawable varB4EAC82CA7396A68D541C85D26508E83_711619604 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_711619604 = newDrawable();
            addTaint(res.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_711619604.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_711619604;
            
            
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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.786 -0400", hash_original_field = "EE994C81FDCFE1430D43C52DAFF20E29", hash_generated_field = "CB60BBB38B09F6F2A3773B2329AD705D")

    private static final Rect ZERO_BOUNDS_RECT = new Rect();
}

