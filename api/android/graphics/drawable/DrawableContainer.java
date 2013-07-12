package android.graphics.drawable;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.os.SystemClock;

public class DrawableContainer extends Drawable implements Drawable.Callback {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.896 -0400", hash_original_field = "6DB222960773F6967427BFC156C9AD7B", hash_generated_field = "2DB19AB4F82F5273EE7E6529BBA72AE4")

    private DrawableContainerState mDrawableContainerState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.896 -0400", hash_original_field = "B240482EE6277AAB0A9A6BA264B7D741", hash_generated_field = "45111284A103854181686551CAB9ECE6")

    private Drawable mCurrDrawable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.896 -0400", hash_original_field = "964D4F44E49C213AB7292F7E0E37C642", hash_generated_field = "3503E015FBD1508491B2F18FDC5DAF9F")

    private int mAlpha = 0xFF;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.896 -0400", hash_original_field = "8B2ED40D22A4C08C94CFC40B6DE589B8", hash_generated_field = "5D6D299C9DDEDCCB11EFFA1C147C3DF6")

    private ColorFilter mColorFilter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.896 -0400", hash_original_field = "87D94DD4DB47AE1293A4A6B2F3F1320A", hash_generated_field = "68BE4C2261D94A949F760C32A43779D9")

    private int mCurIndex = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.896 -0400", hash_original_field = "9FB80C30383848C8D006680B5F3BDAF9", hash_generated_field = "5CA5A1EF3CAA45117BCACBC34EF05952")

    private boolean mMutated;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.897 -0400", hash_original_field = "FE03A919E4DC41F1F154951DE4E81FB8", hash_generated_field = "703FCA3A43FE2C0EE6947EDF58A21E0E")

    private Runnable mAnimationRunnable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.897 -0400", hash_original_field = "EF143134718F0A7B6C5999AC0903EEFD", hash_generated_field = "4B94C11DAC8E800C8F6926DD6BCC82A8")

    private long mEnterAnimationEnd;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.897 -0400", hash_original_field = "9C4D4B2BC75FDD3F32F00F40201BB026", hash_generated_field = "06C911F5C85391F52F5C0A8476C4502F")

    private long mExitAnimationEnd;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.897 -0400", hash_original_field = "F6C429B950C530EFBF6200ED9DFBE3ED", hash_generated_field = "6FEFDE257A7DFEFF73429269253AF7F7")

    private Drawable mLastDrawable;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.897 -0400", hash_original_method = "094684F7E86BAEC8B113ECD0EF1A35E3", hash_generated_method = "094684F7E86BAEC8B113ECD0EF1A35E3")
    public DrawableContainer ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.898 -0400", hash_original_method = "4C0F5C22B9C7136183C2CC55D1B2C479", hash_generated_method = "430C09AB8F3A7C314939EED31114350A")
    @Override
    public void draw(Canvas canvas) {
        addTaint(canvas.getTaint());
    if(mCurrDrawable != null)        
        {
            mCurrDrawable.draw(canvas);
        } //End block
    if(mLastDrawable != null)        
        {
            mLastDrawable.draw(canvas);
        } //End block
        // ---------- Original Method ----------
        //if (mCurrDrawable != null) {
            //mCurrDrawable.draw(canvas);
        //}
        //if (mLastDrawable != null) {
            //mLastDrawable.draw(canvas);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.899 -0400", hash_original_method = "91A12202891A2BC9DA6AA80DC6DB676A", hash_generated_method = "9500DD6FEA3950F576E0BF7E9744BE61")
    @Override
    public int getChangingConfigurations() {
        int var1D844E53E1E7C20F98C455C913D0E8B6_130536027 = (super.getChangingConfigurations()
                | mDrawableContainerState.mChangingConfigurations
                | mDrawableContainerState.mChildrenChangingConfigurations);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_404034332 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_404034332;
        // ---------- Original Method ----------
        //return super.getChangingConfigurations()
                //| mDrawableContainerState.mChangingConfigurations
                //| mDrawableContainerState.mChildrenChangingConfigurations;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.900 -0400", hash_original_method = "8B17DDF51BCD655A61A83DE84247EF99", hash_generated_method = "79896542C73D8EF775D25280000AF6E4")
    @Override
    public boolean getPadding(Rect padding) {
        addTaint(padding.getTaint());
        final Rect r = mDrawableContainerState.getConstantPadding();
    if(r != null)        
        {
            padding.set(r);
            boolean varB326B5062B2F0E69046810717534CB09_1806568862 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2015292171 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2015292171;
        } //End block
    if(mCurrDrawable != null)        
        {
            boolean var85BF3EAA15DBAEF2E2B62643627A427F_1484906484 = (mCurrDrawable.getPadding(padding));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_394363012 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_394363012;
        } //End block
        else
        {
            boolean varBEE4EC8926815DF7C66351028FE91FD2_1063810620 = (super.getPadding(padding));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_88549348 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_88549348;
        } //End block
        // ---------- Original Method ----------
        //final Rect r = mDrawableContainerState.getConstantPadding();
        //if (r != null) {
            //padding.set(r);
            //return true;
        //}
        //if (mCurrDrawable != null) {
            //return mCurrDrawable.getPadding(padding);
        //} else {
            //return super.getPadding(padding);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.900 -0400", hash_original_method = "33F48EB62D0DC564AE5544FE28781DA5", hash_generated_method = "E4DCCE661106A8425DF86C33291025A0")
    @Override
    public void setAlpha(int alpha) {
    if(mAlpha != alpha)        
        {
            mAlpha = alpha;
    if(mCurrDrawable != null)            
            {
    if(mEnterAnimationEnd == 0)                
                {
                    mCurrDrawable.setAlpha(alpha);
                } //End block
                else
                {
                    animate(false);
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (mAlpha != alpha) {
            //mAlpha = alpha;
            //if (mCurrDrawable != null) {
                //if (mEnterAnimationEnd == 0) {
                    //mCurrDrawable.setAlpha(alpha);
                //} else {
                    //animate(false);
                //}
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.901 -0400", hash_original_method = "9C07B593875E6134F95EF1337402CCE4", hash_generated_method = "AC16EC9847A6071D71F1B2F3F96A1631")
    @Override
    public void setDither(boolean dither) {
    if(mDrawableContainerState.mDither != dither)        
        {
            mDrawableContainerState.mDither = dither;
    if(mCurrDrawable != null)            
            {
                mCurrDrawable.setDither(mDrawableContainerState.mDither);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (mDrawableContainerState.mDither != dither) {
            //mDrawableContainerState.mDither = dither;
            //if (mCurrDrawable != null) {
                //mCurrDrawable.setDither(mDrawableContainerState.mDither);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.902 -0400", hash_original_method = "AE256967E0AC09F2540019B105CEB308", hash_generated_method = "754515CFD33164E308358BEF7C9B6123")
    @Override
    public void setColorFilter(ColorFilter cf) {
    if(mColorFilter != cf)        
        {
            mColorFilter = cf;
    if(mCurrDrawable != null)            
            {
                mCurrDrawable.setColorFilter(cf);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (mColorFilter != cf) {
            //mColorFilter = cf;
            //if (mCurrDrawable != null) {
                //mCurrDrawable.setColorFilter(cf);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.903 -0400", hash_original_method = "7519B8FEB07821EB54C84C24ACFADDFA", hash_generated_method = "178B1F3F50B4632FA54670FF64888C5C")
    public void setEnterFadeDuration(int ms) {
        mDrawableContainerState.mEnterFadeDuration = ms;
        // ---------- Original Method ----------
        //mDrawableContainerState.mEnterFadeDuration = ms;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.903 -0400", hash_original_method = "037AE4EFE359E0A64F3D29E228D5C257", hash_generated_method = "BC4F4832E0DF7B103CB719B318AB9698")
    public void setExitFadeDuration(int ms) {
        mDrawableContainerState.mExitFadeDuration = ms;
        // ---------- Original Method ----------
        //mDrawableContainerState.mExitFadeDuration = ms;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.903 -0400", hash_original_method = "6D25AB5CD33FA39A7528151D77324281", hash_generated_method = "F57CAEFC2455B2B23F22BCA1C05FA5E4")
    @Override
    protected void onBoundsChange(Rect bounds) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(bounds.getTaint());
    if(mLastDrawable != null)        
        {
            mLastDrawable.setBounds(bounds);
        } //End block
    if(mCurrDrawable != null)        
        {
            mCurrDrawable.setBounds(bounds);
        } //End block
        // ---------- Original Method ----------
        //if (mLastDrawable != null) {
            //mLastDrawable.setBounds(bounds);
        //}
        //if (mCurrDrawable != null) {
            //mCurrDrawable.setBounds(bounds);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.904 -0400", hash_original_method = "C66859AD1DDD72E10B118943143E6E81", hash_generated_method = "26B86BE8E1CE082FA6BF93FAE2460843")
    @Override
    public boolean isStateful() {
        boolean var0021DB22C483F688E0F302B58CF9CBBC_1311866897 = (mDrawableContainerState.isStateful());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1053796143 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1053796143;
        // ---------- Original Method ----------
        //return mDrawableContainerState.isStateful();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.905 -0400", hash_original_method = "27D546A1CE7DA293AA4ECB359818692F", hash_generated_method = "A812B7E78D70FFC69739B435C000A904")
    @Override
    public void jumpToCurrentState() {
        boolean changed = false;
    if(mLastDrawable != null)        
        {
            mLastDrawable.jumpToCurrentState();
            mLastDrawable = null;
            changed = true;
        } //End block
    if(mCurrDrawable != null)        
        {
            mCurrDrawable.jumpToCurrentState();
            mCurrDrawable.setAlpha(mAlpha);
        } //End block
    if(mExitAnimationEnd != 0)        
        {
            mExitAnimationEnd = 0;
            changed = true;
        } //End block
    if(mEnterAnimationEnd != 0)        
        {
            mEnterAnimationEnd = 0;
            changed = true;
        } //End block
    if(changed)        
        {
            invalidateSelf();
        } //End block
        // ---------- Original Method ----------
        //boolean changed = false;
        //if (mLastDrawable != null) {
            //mLastDrawable.jumpToCurrentState();
            //mLastDrawable = null;
            //changed = true;
        //}
        //if (mCurrDrawable != null) {
            //mCurrDrawable.jumpToCurrentState();
            //mCurrDrawable.setAlpha(mAlpha);
        //}
        //if (mExitAnimationEnd != 0) {
            //mExitAnimationEnd = 0;
            //changed = true;
        //}
        //if (mEnterAnimationEnd != 0) {
            //mEnterAnimationEnd = 0;
            //changed = true;
        //}
        //if (changed) {
            //invalidateSelf();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.906 -0400", hash_original_method = "19BC6D466BAAC5E8F9FD1F6AF6038AC5", hash_generated_method = "C48EE71E40FBBECF3017980A18FF0F9D")
    @Override
    protected boolean onStateChange(int[] state) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(state[0]);
    if(mLastDrawable != null)        
        {
            boolean var7956859B4EBDA4A14E6C3A2E59242587_1825924076 = (mLastDrawable.setState(state));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1438821504 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1438821504;
        } //End block
    if(mCurrDrawable != null)        
        {
            boolean var1568E91E8B6453FDE3B8A671DAEF78BD_2040522953 = (mCurrDrawable.setState(state));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_355070993 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_355070993;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_819246320 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1109910524 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1109910524;
        // ---------- Original Method ----------
        //if (mLastDrawable != null) {
            //return mLastDrawable.setState(state);
        //}
        //if (mCurrDrawable != null) {
            //return mCurrDrawable.setState(state);
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.907 -0400", hash_original_method = "370D8F089D3CBC7A83FFF71A722725DE", hash_generated_method = "5B3A946145BC15485ABB750A818EFFF3")
    @Override
    protected boolean onLevelChange(int level) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(level);
    if(mLastDrawable != null)        
        {
            boolean varDB76A7FB1F7A1D0AA1A257CD60A3CAF9_2141991119 = (mLastDrawable.setLevel(level));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1162512855 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1162512855;
        } //End block
    if(mCurrDrawable != null)        
        {
            boolean var177147F41FD8B368131D7E14DE73BCC1_1711201376 = (mCurrDrawable.setLevel(level));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1425046403 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1425046403;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1193171234 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_131583768 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_131583768;
        // ---------- Original Method ----------
        //if (mLastDrawable != null) {
            //return mLastDrawable.setLevel(level);
        //}
        //if (mCurrDrawable != null) {
            //return mCurrDrawable.setLevel(level);
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.908 -0400", hash_original_method = "DE0AA10FF6502448C6D350B4086CE53A", hash_generated_method = "C78606B745CC73F1A9925E00F149009F")
    @Override
    public int getIntrinsicWidth() {
    if(mDrawableContainerState.isConstantSize())        
        {
            int var81F4D53DC657CE25067E5C3504EB6474_1134127766 = (mDrawableContainerState.getConstantWidth());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1194952347 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1194952347;
        } //End block
        int var88519982331A4A5CB4011E9150D5A6DD_757659470 = (mCurrDrawable != null ? mCurrDrawable.getIntrinsicWidth() : -1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1396536851 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1396536851;
        // ---------- Original Method ----------
        //if (mDrawableContainerState.isConstantSize()) {
            //return mDrawableContainerState.getConstantWidth();
        //}
        //return mCurrDrawable != null ? mCurrDrawable.getIntrinsicWidth() : -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.908 -0400", hash_original_method = "FA2E61AFB9D6236C0B64D53932A9175C", hash_generated_method = "591E0FF2C9D29BC13A2FE6965450CC12")
    @Override
    public int getIntrinsicHeight() {
    if(mDrawableContainerState.isConstantSize())        
        {
            int var96AB0192B89C4C4C02A618345D0C1335_127020096 = (mDrawableContainerState.getConstantHeight());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_863171752 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_863171752;
        } //End block
        int var3C65439FABAF701115AB43CFB55CA91A_594205960 = (mCurrDrawable != null ? mCurrDrawable.getIntrinsicHeight() : -1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1847473253 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1847473253;
        // ---------- Original Method ----------
        //if (mDrawableContainerState.isConstantSize()) {
            //return mDrawableContainerState.getConstantHeight();
        //}
        //return mCurrDrawable != null ? mCurrDrawable.getIntrinsicHeight() : -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.909 -0400", hash_original_method = "758162C9EFC5A9F0A72A174E63E68436", hash_generated_method = "B903B207398AD22EF28EA12D9AB32632")
    @Override
    public int getMinimumWidth() {
    if(mDrawableContainerState.isConstantSize())        
        {
            int var366A216CC324ECE438E6C6A1D0FA6FD6_1247368489 = (mDrawableContainerState.getConstantMinimumWidth());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_353779904 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_353779904;
        } //End block
        int var4FBC69BD057D9C2F43A0980C359DCB01_1825618806 = (mCurrDrawable != null ? mCurrDrawable.getMinimumWidth() : 0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2115206834 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2115206834;
        // ---------- Original Method ----------
        //if (mDrawableContainerState.isConstantSize()) {
            //return mDrawableContainerState.getConstantMinimumWidth();
        //}
        //return mCurrDrawable != null ? mCurrDrawable.getMinimumWidth() : 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.910 -0400", hash_original_method = "4272F469B4A869660F9BDAF1177E3127", hash_generated_method = "A847CE5C5F8D973C44B2B4933DBC939D")
    @Override
    public int getMinimumHeight() {
    if(mDrawableContainerState.isConstantSize())        
        {
            int var955D6B78A34D6669912C41140297A74F_1718137905 = (mDrawableContainerState.getConstantMinimumHeight());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_181669889 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_181669889;
        } //End block
        int var855C9C6B92168BD50D76B72E7835DA39_1372504216 = (mCurrDrawable != null ? mCurrDrawable.getMinimumHeight() : 0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1015847155 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1015847155;
        // ---------- Original Method ----------
        //if (mDrawableContainerState.isConstantSize()) {
            //return mDrawableContainerState.getConstantMinimumHeight();
        //}
        //return mCurrDrawable != null ? mCurrDrawable.getMinimumHeight() : 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.911 -0400", hash_original_method = "4797F0F1C7EC2DAE5A1D44FF8AA06A3E", hash_generated_method = "0B0C72E8B9B729EAB7B6A5BF82B7DE63")
    public void invalidateDrawable(Drawable who) {
        addTaint(who.getTaint());
    if(who == mCurrDrawable && getCallback() != null)        
        {
            getCallback().invalidateDrawable(this);
        } //End block
        // ---------- Original Method ----------
        //if (who == mCurrDrawable && getCallback() != null) {
            //getCallback().invalidateDrawable(this);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.912 -0400", hash_original_method = "D79EA559DF51F16BABDD5FAB2B1074A7", hash_generated_method = "71024848C0A34314F52B74A9B584661F")
    public void scheduleDrawable(Drawable who, Runnable what, long when) {
        addTaint(when);
        addTaint(what.getTaint());
        addTaint(who.getTaint());
    if(who == mCurrDrawable && getCallback() != null)        
        {
            getCallback().scheduleDrawable(this, what, when);
        } //End block
        // ---------- Original Method ----------
        //if (who == mCurrDrawable && getCallback() != null) {
            //getCallback().scheduleDrawable(this, what, when);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.914 -0400", hash_original_method = "BF197FFA306784FCC1A1C762AD43B7D1", hash_generated_method = "AE3BCFAF25A419929EC3B809950099F5")
    public void unscheduleDrawable(Drawable who, Runnable what) {
        addTaint(what.getTaint());
        addTaint(who.getTaint());
    if(who == mCurrDrawable && getCallback() != null)        
        {
            getCallback().unscheduleDrawable(this, what);
        } //End block
        // ---------- Original Method ----------
        //if (who == mCurrDrawable && getCallback() != null) {
            //getCallback().unscheduleDrawable(this, what);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.915 -0400", hash_original_method = "29A0A86F8B666C86609CA80FF461C32C", hash_generated_method = "756AE4508A6E3DC20013A74E8BC395CA")
    @Override
    public boolean setVisible(boolean visible, boolean restart) {
        addTaint(restart);
        addTaint(visible);
        boolean changed = super.setVisible(visible, restart);
    if(mLastDrawable != null)        
        {
            mLastDrawable.setVisible(visible, restart);
        } //End block
    if(mCurrDrawable != null)        
        {
            mCurrDrawable.setVisible(visible, restart);
        } //End block
        boolean var8977DFAC2F8E04CB96E66882235F5ABA_1704313410 = (changed);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_868250923 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_868250923;
        // ---------- Original Method ----------
        //boolean changed = super.setVisible(visible, restart);
        //if (mLastDrawable != null) {
            //mLastDrawable.setVisible(visible, restart);
        //}
        //if (mCurrDrawable != null) {
            //mCurrDrawable.setVisible(visible, restart);
        //}
        //return changed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.916 -0400", hash_original_method = "1234F5DF929258DFDBB23F3D48CB2B3B", hash_generated_method = "FEC051009C78FF8EB6C6BA5F703B6281")
    @Override
    public int getOpacity() {
        int varCFD04A0305D24EC416CDFEC944EAD07B_2083529290 = (mCurrDrawable == null || !mCurrDrawable.isVisible() ? PixelFormat.TRANSPARENT :
                mDrawableContainerState.getOpacity());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1372272729 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1372272729;
        // ---------- Original Method ----------
        //return mCurrDrawable == null || !mCurrDrawable.isVisible() ? PixelFormat.TRANSPARENT :
                //mDrawableContainerState.getOpacity();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.920 -0400", hash_original_method = "DF0D8C256AB252B9122AE282C5336A53", hash_generated_method = "E3725672B678B117B38D7ABE1C85F869")
    public boolean selectDrawable(int idx) {
    if(idx == mCurIndex)        
        {
            boolean var68934A3E9455FA72420237EB05902327_61638017 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1040200015 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1040200015;
        } //End block
        final long now = SystemClock.uptimeMillis();
    if(DEBUG)        
        android.util.Log.i(TAG, toString() + " from " + mCurIndex + " to " + idx
                + ": exit=" + mDrawableContainerState.mExitFadeDuration
                + " enter=" + mDrawableContainerState.mEnterFadeDuration);
    if(mDrawableContainerState.mExitFadeDuration > 0)        
        {
    if(mLastDrawable != null)            
            {
                mLastDrawable.setVisible(false, false);
            } //End block
    if(mCurrDrawable != null)            
            {
                mLastDrawable = mCurrDrawable;
                mExitAnimationEnd = now + mDrawableContainerState.mExitFadeDuration;
            } //End block
            else
            {
                mLastDrawable = null;
                mExitAnimationEnd = 0;
            } //End block
        } //End block
        else
    if(mCurrDrawable != null)        
        {
            mCurrDrawable.setVisible(false, false);
        } //End block
    if(idx >= 0 && idx < mDrawableContainerState.mNumChildren)        
        {
            Drawable d = mDrawableContainerState.mDrawables[idx];
            mCurrDrawable = d;
            mCurIndex = idx;
    if(d != null)            
            {
    if(mDrawableContainerState.mEnterFadeDuration > 0)                
                {
                    mEnterAnimationEnd = now + mDrawableContainerState.mEnterFadeDuration;
                } //End block
                else
                {
                    d.setAlpha(mAlpha);
                } //End block
                d.setVisible(isVisible(), true);
                d.setDither(mDrawableContainerState.mDither);
                d.setColorFilter(mColorFilter);
                d.setState(getState());
                d.setLevel(getLevel());
                d.setBounds(getBounds());
            } //End block
        } //End block
        else
        {
            mCurrDrawable = null;
            mCurIndex = -1;
        } //End block
    if(mEnterAnimationEnd != 0 || mExitAnimationEnd != 0)        
        {
    if(mAnimationRunnable == null)            
            {
                mAnimationRunnable = new Runnable() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.919 -0400", hash_original_method = "FF47FBE8389551C190770D50719F0AEF", hash_generated_method = "494EBE0F0E6AEB2E1F7413236FFA416A")
        @Override
        public void run() {
            animate(true);
            invalidateSelf();
            // ---------- Original Method ----------
            //animate(true);
            //invalidateSelf();
        }
};
            } //End block
            else
            {
                unscheduleSelf(mAnimationRunnable);
            } //End block
            animate(true);
        } //End block
        invalidateSelf();
        boolean varB326B5062B2F0E69046810717534CB09_1799087541 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1179540695 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1179540695;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.924 -0400", hash_original_method = "10A80C718FDF3E5D6299035E54551605", hash_generated_method = "AC527BDB33A8A1FF4B3203ABED25AD68")
     void animate(boolean schedule) {
        addTaint(schedule);
        final long now = SystemClock.uptimeMillis();
        boolean animating = false;
    if(mCurrDrawable != null)        
        {
    if(mEnterAnimationEnd != 0)            
            {
    if(mEnterAnimationEnd <= now)                
                {
                    mCurrDrawable.setAlpha(mAlpha);
                    mEnterAnimationEnd = 0;
                } //End block
                else
                {
                    int animAlpha = (int)((mEnterAnimationEnd-now)*255)
                            / mDrawableContainerState.mEnterFadeDuration;
    if(DEBUG)                    
                    android.util.Log.i(TAG, toString() + " cur alpha " + animAlpha);
                    mCurrDrawable.setAlpha(((255-animAlpha)*mAlpha)/255);
                    animating = true;
                } //End block
            } //End block
        } //End block
        else
        {
            mEnterAnimationEnd = 0;
        } //End block
    if(mLastDrawable != null)        
        {
    if(mExitAnimationEnd != 0)            
            {
    if(mExitAnimationEnd <= now)                
                {
                    mLastDrawable.setVisible(false, false);
                    mLastDrawable = null;
                    mExitAnimationEnd = 0;
                } //End block
                else
                {
                    int animAlpha = (int)((mExitAnimationEnd-now)*255)
                            / mDrawableContainerState.mExitFadeDuration;
    if(DEBUG)                    
                    android.util.Log.i(TAG, toString() + " last alpha " + animAlpha);
                    mLastDrawable.setAlpha((animAlpha*mAlpha)/255);
                    animating = true;
                } //End block
            } //End block
        } //End block
        else
        {
            mExitAnimationEnd = 0;
        } //End block
    if(schedule && animating)        
        {
            scheduleSelf(mAnimationRunnable, now + 1000/60);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.925 -0400", hash_original_method = "2271215EA07D061295E4A17A597D4C85", hash_generated_method = "D79FC190D814D9EF407CD379EDEB7829")
    @Override
    public Drawable getCurrent() {
Drawable var1BD305A3FD24BFE343C1CCFA06406DBC_1606523245 =         mCurrDrawable;
        var1BD305A3FD24BFE343C1CCFA06406DBC_1606523245.addTaint(taint);
        return var1BD305A3FD24BFE343C1CCFA06406DBC_1606523245;
        // ---------- Original Method ----------
        //return mCurrDrawable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.926 -0400", hash_original_method = "7CCE0C3F432CC06D16574FAD35E80869", hash_generated_method = "9830919D4E23217F5E76CCA99AE287B0")
    @Override
    public ConstantState getConstantState() {
    if(mDrawableContainerState.canConstantState())        
        {
            mDrawableContainerState.mChangingConfigurations = getChangingConfigurations();
ConstantState varC9E8A5C3327B8A067CCD2EB2E99241E6_508103376 =             mDrawableContainerState;
            varC9E8A5C3327B8A067CCD2EB2E99241E6_508103376.addTaint(taint);
            return varC9E8A5C3327B8A067CCD2EB2E99241E6_508103376;
        } //End block
ConstantState var540C13E9E156B687226421B24F2DF178_2005237101 =         null;
        var540C13E9E156B687226421B24F2DF178_2005237101.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_2005237101;
        // ---------- Original Method ----------
        //if (mDrawableContainerState.canConstantState()) {
            //mDrawableContainerState.mChangingConfigurations = getChangingConfigurations();
            //return mDrawableContainerState;
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.927 -0400", hash_original_method = "9CED290C930F72A121B65658EE47F79B", hash_generated_method = "41C342D33DAAAD4C133F8C747D61E991")
    @Override
    public Drawable mutate() {
    if(!mMutated && super.mutate() == this)        
        {
            final int N = mDrawableContainerState.getChildCount();
            final Drawable[] drawables = mDrawableContainerState.getChildren();
for(int i = 0;i < N;i++)
            {
    if(drawables[i] != null)                
                drawables[i].mutate();
            } //End block
            mMutated = true;
        } //End block
Drawable var72A74007B2BE62B849F475C7BDA4658B_1160049040 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1160049040.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1160049040;
        // ---------- Original Method ----------
        //if (!mMutated && super.mutate() == this) {
            //final int N = mDrawableContainerState.getChildCount();
            //final Drawable[] drawables = mDrawableContainerState.getChildren();
            //for (int i = 0; i < N; i++) {
                //if (drawables[i] != null) drawables[i].mutate();
            //}
            //mMutated = true;
        //}
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.928 -0400", hash_original_method = "8007C958EC09F138BD431BCAF111D646", hash_generated_method = "C420DDEC89C73B6C63F887832E2D9CA4")
    protected void setConstantState(DrawableContainerState state) {
        mDrawableContainerState = state;
        // ---------- Original Method ----------
        //mDrawableContainerState = state;
    }

    
    public abstract static class DrawableContainerState extends ConstantState {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.929 -0400", hash_original_field = "4AA3D5C224CE197897B9C6F17BF367CD", hash_generated_field = "69A4D31099BD07B55F0FC0556B45F074")

        DrawableContainer mOwner;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.930 -0400", hash_original_field = "276E0645C4E2084773D0EB8C5576428C", hash_generated_field = "9BFAF00848476277D36D9BA586984BA7")

        int mChangingConfigurations;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.930 -0400", hash_original_field = "8755A6790E0FAEFCC765046FF423478D", hash_generated_field = "E8F7332658D4B8911B8427F9E33AC9BD")

        int mChildrenChangingConfigurations;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.931 -0400", hash_original_field = "1891CBC78C734C6A7EBB0D921FFE84B0", hash_generated_field = "B3C5F926BAE6E9ED929417A165A9782D")

        Drawable[] mDrawables;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.931 -0400", hash_original_field = "B2A189B31612476BCCDDB62DFD55B139", hash_generated_field = "77E2F294FC2676328BFD127FCF506329")

        int mNumChildren;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.931 -0400", hash_original_field = "0C8A0F55137EA7C9D079883411C6F93F", hash_generated_field = "A174A0353A9684103C90D7CCC8701C2F")

        boolean mVariablePadding = false;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.932 -0400", hash_original_field = "C9952AF9D9005BC34C04F1E2CB4C3C47", hash_generated_field = "C4240083AE1C6AD18CF7413499D117A4")

        Rect mConstantPadding = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.932 -0400", hash_original_field = "5265BDCA75A610EFF809E61F883963F5", hash_generated_field = "6BFEC2D16A3F7C5C15697878B6EF3BBE")

        boolean mConstantSize = false;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.932 -0400", hash_original_field = "1F301A7547BD825E77BA27AAD0924AB6", hash_generated_field = "430C60111FB869A696B5B5437CADEC6A")

        boolean mComputedConstantSize = false;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.932 -0400", hash_original_field = "C3657F4EC6FDE8A4C5B25696644DA1FB", hash_generated_field = "4D42859CADFABA2E50BE968727F544D7")

        int mConstantWidth;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.932 -0400", hash_original_field = "D30B88E9D07E45516A5C783A50766F03", hash_generated_field = "B4AC32864D468EB70183C5472B0F9A3B")

        int mConstantHeight;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.933 -0400", hash_original_field = "73F34719DB2AE87BFF64DD04BBD99771", hash_generated_field = "65FF036F9AF5D3B1235D68E5F33E8546")

        int mConstantMinimumWidth;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.933 -0400", hash_original_field = "AB34B1FB48C56A86337A52EBD12BA9E1", hash_generated_field = "15038681586DC6317E5E8BDA3C11F3B1")

        int mConstantMinimumHeight;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.933 -0400", hash_original_field = "B8FE7B1D7EF53BE4167C040A5FEB7CC7", hash_generated_field = "0E129F2B3EAED33E8435CEB0AF66A927")

        boolean mHaveOpacity = false;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.933 -0400", hash_original_field = "9D334A125EE4B3831821AB1264C029B9", hash_generated_field = "F94EB6B55A1DFE34A922350D13706418")

        int mOpacity;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.933 -0400", hash_original_field = "0AB968E9E6651BF0E687DAF7846B214C", hash_generated_field = "788B667F97461387E15CDD9C2D78DA89")

        boolean mHaveStateful = false;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.933 -0400", hash_original_field = "1819E5C118FDB6B2BF917A4481AE2A7A", hash_generated_field = "6CBAA9F8E31FD09725242CB8EF367A38")

        boolean mStateful;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.934 -0400", hash_original_field = "2E319D4D352B34E33CF19129B7212FC6", hash_generated_field = "04605894B57F7B3414AF620BF4AC040E")

        boolean mCheckedConstantState;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.934 -0400", hash_original_field = "7C8FD9809F31C20B8422D623B0EC0C4F", hash_generated_field = "09212A3A30B7E6D48DEECC4F4639CCBC")

        boolean mCanConstantState;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.934 -0400", hash_original_field = "C325585054D3982E395745F18CBCD0A6", hash_generated_field = "F1842B9E642BB7380414BD0D8EACA9C1")

        boolean mPaddingChecked = false;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.934 -0400", hash_original_field = "66DCB50C0F72DE519AF3706206BAB5B4", hash_generated_field = "ADD3447A81FDA5C4E55789938CB01CA9")

        boolean mDither = DEFAULT_DITHER;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.934 -0400", hash_original_field = "7EF73DB740A09C72072F895C234DF078", hash_generated_field = "3A008F34A7ED7348F09E0D7AC5FD8046")

        int mEnterFadeDuration;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.934 -0400", hash_original_field = "35F39F9E1FFCE54C39871C49C674BB21", hash_generated_field = "72291FB3AAE88AF4CCFC28A4C19C4F0A")

        int mExitFadeDuration;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.941 -0400", hash_original_method = "BB71D442E5298FC9607AB33C7CE8B85B", hash_generated_method = "46E064BC52ED8FF773216D8A59CA3090")
          DrawableContainerState(DrawableContainerState orig, DrawableContainer owner,
                Resources res) {
            mOwner = owner;
    if(orig != null)            
            {
                mChangingConfigurations = orig.mChangingConfigurations;
                mChildrenChangingConfigurations = orig.mChildrenChangingConfigurations;
                final Drawable[] origDr = orig.mDrawables;
                mDrawables = new Drawable[origDr.length];
                mNumChildren = orig.mNumChildren;
                final int N = mNumChildren;
for(int i=0;i<N;i++)
                {
    if(res != null)                    
                    {
                        mDrawables[i] = origDr[i].getConstantState().newDrawable(res);
                    } //End block
                    else
                    {
                        mDrawables[i] = origDr[i].getConstantState().newDrawable();
                    } //End block
                    mDrawables[i].setCallback(owner);
                } //End block
                mCheckedConstantState = mCanConstantState = true;
                mVariablePadding = orig.mVariablePadding;
    if(orig.mConstantPadding != null)                
                {
                    mConstantPadding = new Rect(orig.mConstantPadding);
                } //End block
                mConstantSize = orig.mConstantSize;
                mComputedConstantSize = orig.mComputedConstantSize;
                mConstantWidth = orig.mConstantWidth;
                mConstantHeight = orig.mConstantHeight;
                mHaveOpacity = orig.mHaveOpacity;
                mOpacity = orig.mOpacity;
                mHaveStateful = orig.mHaveStateful;
                mStateful = orig.mStateful;
                mDither = orig.mDither;
                mEnterFadeDuration = orig.mEnterFadeDuration;
                mExitFadeDuration = orig.mExitFadeDuration;
            } //End block
            else
            {
                mDrawables = new Drawable[10];
                mNumChildren = 0;
                mCheckedConstantState = mCanConstantState = false;
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.941 -0400", hash_original_method = "9E7D7C67EAC365FF19BD4971762612A5", hash_generated_method = "0415581591EC1795923E4ED33DAF761E")
        @Override
        public int getChangingConfigurations() {
            int var276E0645C4E2084773D0EB8C5576428C_1070995816 = (mChangingConfigurations);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_673848898 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_673848898;
            // ---------- Original Method ----------
            //return mChangingConfigurations;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.943 -0400", hash_original_method = "1DF96DB91DC15ED3AA2CD90CE63D5DEA", hash_generated_method = "64D80A2649D0B3D3300AB27701245339")
        public final int addChild(Drawable dr) {
            final int pos = mNumChildren;
    if(pos >= mDrawables.length)            
            {
                growArray(pos, pos+10);
            } //End block
            dr.setVisible(false, true);
            dr.setCallback(mOwner);
            mDrawables[pos] = dr;
            mNumChildren++;
            mChildrenChangingConfigurations |= dr.getChangingConfigurations();
            mHaveOpacity = false;
            mHaveStateful = false;
            mConstantPadding = null;
            mPaddingChecked = false;
            mComputedConstantSize = false;
            int var5E0BDCBDDCCCA4D66D74BA8C1CEE1A68_557797963 = (pos);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1632694486 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1632694486;
            // ---------- Original Method ----------
            //final int pos = mNumChildren;
            //if (pos >= mDrawables.length) {
                //growArray(pos, pos+10);
            //}
            //dr.setVisible(false, true);
            //dr.setCallback(mOwner);
            //mDrawables[pos] = dr;
            //mNumChildren++;
            //mChildrenChangingConfigurations |= dr.getChangingConfigurations();
            //mHaveOpacity = false;
            //mHaveStateful = false;
            //mConstantPadding = null;
            //mPaddingChecked = false;
            //mComputedConstantSize = false;
            //return pos;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.943 -0400", hash_original_method = "58D23B7CD1BBD3B06877382B700017CE", hash_generated_method = "483D070B9D12216B96AA3C513A5D373D")
        public final int getChildCount() {
            int varB2A189B31612476BCCDDB62DFD55B139_445949294 = (mNumChildren);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_666662252 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_666662252;
            // ---------- Original Method ----------
            //return mNumChildren;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.944 -0400", hash_original_method = "F5C2CB0FAF6BF41EBD2EF1D322F89AD5", hash_generated_method = "3793931F868018CD65F31E4F76D93648")
        public final Drawable[] getChildren() {
Drawable[] var35D22BAB465DA49F0AADC06B9FD0EF41_1426619248 =             mDrawables;
            var35D22BAB465DA49F0AADC06B9FD0EF41_1426619248.addTaint(taint);
            return var35D22BAB465DA49F0AADC06B9FD0EF41_1426619248;
            // ---------- Original Method ----------
            //return mDrawables;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.944 -0400", hash_original_method = "291079EAD380D117FACCF8E598F58B57", hash_generated_method = "9E63340C83EEEB40E3F74E85F49DB546")
        public final void setVariablePadding(boolean variable) {
            mVariablePadding = variable;
            // ---------- Original Method ----------
            //mVariablePadding = variable;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.945 -0400", hash_original_method = "F49D2F39EC6FEC96BF9263C8B9281632", hash_generated_method = "56D34DB2F8140F5C0FFF1EDDF0E28AE7")
        public final Rect getConstantPadding() {
    if(mVariablePadding)            
            {
Rect var540C13E9E156B687226421B24F2DF178_266586448 =                 null;
                var540C13E9E156B687226421B24F2DF178_266586448.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_266586448;
            } //End block
    if(mConstantPadding != null || mPaddingChecked)            
            {
Rect var08D14EDC969EBEEAEEE6F07B5ABDC6B0_1994341389 =                 mConstantPadding;
                var08D14EDC969EBEEAEEE6F07B5ABDC6B0_1994341389.addTaint(taint);
                return var08D14EDC969EBEEAEEE6F07B5ABDC6B0_1994341389;
            } //End block
            Rect r = null;
            final Rect t = new Rect();
            final int N = getChildCount();
            final Drawable[] drawables = mDrawables;
for(int i = 0;i < N;i++)
            {
    if(drawables[i].getPadding(t))                
                {
    if(r == null)                    
                    r = new Rect(0, 0, 0, 0);
    if(t.left > r.left)                    
                    r.left = t.left;
    if(t.top > r.top)                    
                    r.top = t.top;
    if(t.right > r.right)                    
                    r.right = t.right;
    if(t.bottom > r.bottom)                    
                    r.bottom = t.bottom;
                } //End block
            } //End block
            mPaddingChecked = true;
Rect varC03C031612CF744A6ECEF348B89D22D9_815034559 =             (mConstantPadding = r);
            varC03C031612CF744A6ECEF348B89D22D9_815034559.addTaint(taint);
            return varC03C031612CF744A6ECEF348B89D22D9_815034559;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.946 -0400", hash_original_method = "1BEAC422BABD76426588E9F434C2D5CD", hash_generated_method = "0B85399E5ECA2518EC987CAE64EFA9F0")
        public final void setConstantSize(boolean constant) {
            mConstantSize = constant;
            // ---------- Original Method ----------
            //mConstantSize = constant;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.947 -0400", hash_original_method = "23D6FDB773CAAECCFEA4282EEDA0FF8B", hash_generated_method = "974353992ECC36DB2629997B0D40AD02")
        public final boolean isConstantSize() {
            boolean var8B731A337FAE0FFD46E10065F5C3D468_779128183 = (mConstantSize);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_428542427 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_428542427;
            // ---------- Original Method ----------
            //return mConstantSize;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.947 -0400", hash_original_method = "AEDD9F8F931AA0310C6AB599B9490E0C", hash_generated_method = "E5FA05978D5D3A1B93D946AAE042AF8F")
        public final int getConstantWidth() {
    if(!mComputedConstantSize)            
            {
                computeConstantSize();
            } //End block
            int varC3657F4EC6FDE8A4C5B25696644DA1FB_1872738242 = (mConstantWidth);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1096845008 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1096845008;
            // ---------- Original Method ----------
            //if (!mComputedConstantSize) {
                //computeConstantSize();
            //}
            //return mConstantWidth;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.947 -0400", hash_original_method = "A117A0F50DACA3E076E36F6E0FD5A697", hash_generated_method = "D34496663E76C7BAFC28EEB6FB1E753D")
        public final int getConstantHeight() {
    if(!mComputedConstantSize)            
            {
                computeConstantSize();
            } //End block
            int varD30B88E9D07E45516A5C783A50766F03_537573292 = (mConstantHeight);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_283738017 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_283738017;
            // ---------- Original Method ----------
            //if (!mComputedConstantSize) {
                //computeConstantSize();
            //}
            //return mConstantHeight;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.948 -0400", hash_original_method = "DA23CD9C0D969BCBC5A31F19CEBA2FA0", hash_generated_method = "307AB611E65CA15AA749B99EC1DF20C4")
        public final int getConstantMinimumWidth() {
    if(!mComputedConstantSize)            
            {
                computeConstantSize();
            } //End block
            int var73F34719DB2AE87BFF64DD04BBD99771_549819028 = (mConstantMinimumWidth);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1957196582 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1957196582;
            // ---------- Original Method ----------
            //if (!mComputedConstantSize) {
                //computeConstantSize();
            //}
            //return mConstantMinimumWidth;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.948 -0400", hash_original_method = "9AAB9DC0F579B2E57159CF0852B151D2", hash_generated_method = "85268AE686C260C618D1A678C2FF43FA")
        public final int getConstantMinimumHeight() {
    if(!mComputedConstantSize)            
            {
                computeConstantSize();
            } //End block
            int varAB34B1FB48C56A86337A52EBD12BA9E1_980345502 = (mConstantMinimumHeight);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_437511126 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_437511126;
            // ---------- Original Method ----------
            //if (!mComputedConstantSize) {
                //computeConstantSize();
            //}
            //return mConstantMinimumHeight;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.950 -0400", hash_original_method = "113DB032EAC82FBADFFAA0B97D39A18D", hash_generated_method = "5B623043663748E760382B9B2C5DE05E")
        protected void computeConstantSize() {
            mComputedConstantSize = true;
            final int N = getChildCount();
            final Drawable[] drawables = mDrawables;
            mConstantWidth = mConstantHeight = -1;
            mConstantMinimumWidth = mConstantMinimumHeight = 0;
for(int i = 0;i < N;i++)
            {
                Drawable dr = drawables[i];
                int s = dr.getIntrinsicWidth();
    if(s > mConstantWidth)                
                mConstantWidth = s;
                s = dr.getIntrinsicHeight();
    if(s > mConstantHeight)                
                mConstantHeight = s;
                s = dr.getMinimumWidth();
    if(s > mConstantMinimumWidth)                
                mConstantMinimumWidth = s;
                s = dr.getMinimumHeight();
    if(s > mConstantMinimumHeight)                
                mConstantMinimumHeight = s;
            } //End block
            // ---------- Original Method ----------
            //mComputedConstantSize = true;
            //final int N = getChildCount();
            //final Drawable[] drawables = mDrawables;
            //mConstantWidth = mConstantHeight = -1;
            //mConstantMinimumWidth = mConstantMinimumHeight = 0;
            //for (int i = 0; i < N; i++) {
                //Drawable dr = drawables[i];
                //int s = dr.getIntrinsicWidth();
                //if (s > mConstantWidth) mConstantWidth = s;
                //s = dr.getIntrinsicHeight();
                //if (s > mConstantHeight) mConstantHeight = s;
                //s = dr.getMinimumWidth();
                //if (s > mConstantMinimumWidth) mConstantMinimumWidth = s;
                //s = dr.getMinimumHeight();
                //if (s > mConstantMinimumHeight) mConstantMinimumHeight = s;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.951 -0400", hash_original_method = "C7A92F60FC2D3E73CF200C7144A831FD", hash_generated_method = "31EA4832DE115AD3D1ED2D154F4F3A0E")
        public final void setEnterFadeDuration(int duration) {
            mEnterFadeDuration = duration;
            // ---------- Original Method ----------
            //mEnterFadeDuration = duration;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.952 -0400", hash_original_method = "47A305314E1265D4F19BD4B53B739910", hash_generated_method = "804B4180E543557D85A7B49F869A80A8")
        public final int getEnterFadeDuration() {
            int var7EF73DB740A09C72072F895C234DF078_1764992523 = (mEnterFadeDuration);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1748147556 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1748147556;
            // ---------- Original Method ----------
            //return mEnterFadeDuration;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.953 -0400", hash_original_method = "1ED7E9EB98364255825D9EFA32269162", hash_generated_method = "93C0A2E6B640F643574AA208A98DA016")
        public final void setExitFadeDuration(int duration) {
            mExitFadeDuration = duration;
            // ---------- Original Method ----------
            //mExitFadeDuration = duration;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.954 -0400", hash_original_method = "8AF957428721C92A0DFF9444CB2E7B41", hash_generated_method = "CAE38BA15AD54FA997B67D46F751B8A3")
        public final int getExitFadeDuration() {
            int var35F39F9E1FFCE54C39871C49C674BB21_1184111843 = (mExitFadeDuration);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1585800910 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1585800910;
            // ---------- Original Method ----------
            //return mExitFadeDuration;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.955 -0400", hash_original_method = "C3CEC4829800E9DBA4286BAEED120A24", hash_generated_method = "B376447C9F469726A6539167A113EF97")
        public final int getOpacity() {
    if(mHaveOpacity)            
            {
                int var9D334A125EE4B3831821AB1264C029B9_1348384392 = (mOpacity);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_247527284 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_247527284;
            } //End block
            final int N = getChildCount();
            final Drawable[] drawables = mDrawables;
            int op = N > 0 ? drawables[0].getOpacity() : PixelFormat.TRANSPARENT;
for(int i = 1;i < N;i++)
            {
                op = Drawable.resolveOpacity(op, drawables[i].getOpacity());
            } //End block
            mOpacity = op;
            mHaveOpacity = true;
            int var11D8C28A64490A987612F2332502467F_650684684 = (op);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1104405500 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1104405500;
            // ---------- Original Method ----------
            //if (mHaveOpacity) {
                //return mOpacity;
            //}
            //final int N = getChildCount();
            //final Drawable[] drawables = mDrawables;
            //int op = N > 0 ? drawables[0].getOpacity() : PixelFormat.TRANSPARENT;
            //for (int i = 1; i < N; i++) {
                //op = Drawable.resolveOpacity(op, drawables[i].getOpacity());
            //}
            //mOpacity = op;
            //mHaveOpacity = true;
            //return op;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.957 -0400", hash_original_method = "CFE0AE04764A8B8DC9358FA475490068", hash_generated_method = "166CA7969A53FB2C67A779B382E500DF")
        public final boolean isStateful() {
    if(mHaveStateful)            
            {
                boolean var1819E5C118FDB6B2BF917A4481AE2A7A_1530739448 = (mStateful);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1502421663 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1502421663;
            } //End block
            boolean stateful = false;
            final int N = getChildCount();
for(int i = 0;i < N;i++)
            {
    if(mDrawables[i].isStateful())                
                {
                    stateful = true;
                    break;
                } //End block
            } //End block
            mStateful = stateful;
            mHaveStateful = true;
            boolean varBAB19DD93081FB031211C4ABF44EA695_1869743531 = (stateful);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_434141563 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_434141563;
            // ---------- Original Method ----------
            //if (mHaveStateful) {
                //return mStateful;
            //}
            //boolean stateful = false;
            //final int N = getChildCount();
            //for (int i = 0; i < N; i++) {
                //if (mDrawables[i].isStateful()) {
                    //stateful = true;
                    //break;
                //}
            //}
            //mStateful = stateful;
            //mHaveStateful = true;
            //return stateful;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.958 -0400", hash_original_method = "A9E2F6299A2B0C0DB78600A3C23F092D", hash_generated_method = "CEE9F040A4E3C53CA51490BC64A9F1F4")
        public void growArray(int oldSize, int newSize) {
            addTaint(newSize);
            addTaint(oldSize);
            Drawable[] newDrawables = new Drawable[newSize];
            System.arraycopy(mDrawables, 0, newDrawables, 0, oldSize);
            mDrawables = newDrawables;
            // ---------- Original Method ----------
            //Drawable[] newDrawables = new Drawable[newSize];
            //System.arraycopy(mDrawables, 0, newDrawables, 0, oldSize);
            //mDrawables = newDrawables;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.960 -0400", hash_original_method = "F91020706361DEC18BACE4525A4D4C39", hash_generated_method = "CE0E744339ACC6F9D01DBFB8D582F99F")
        public synchronized boolean canConstantState() {
    if(!mCheckedConstantState)            
            {
                mCanConstantState = true;
                final int N = mNumChildren;
for(int i=0;i<N;i++)
                {
    if(mDrawables[i].getConstantState() == null)                    
                    {
                        mCanConstantState = false;
                        break;
                    } //End block
                } //End block
                mCheckedConstantState = true;
            } //End block
            boolean var7C8FD9809F31C20B8422D623B0EC0C4F_154704231 = (mCanConstantState);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_274992410 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_274992410;
            // ---------- Original Method ----------
            //if (!mCheckedConstantState) {
                //mCanConstantState = true;
                //final int N = mNumChildren;
                //for (int i=0; i<N; i++) {
                    //if (mDrawables[i].getConstantState() == null) {
                        //mCanConstantState = false;
                        //break;
                    //}
                //}
                //mCheckedConstantState = true;
            //}
            //return mCanConstantState;
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.961 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "58EDF43BA541A4D47EECFEC3901C7AED")

    private static final boolean DEBUG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.961 -0400", hash_original_field = "487A87FC99B2160674C40DE470BDF1B0", hash_generated_field = "48C9B565D3BB13F89C4A690FEBD0B203")

    private static final String TAG = "DrawableContainer";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.962 -0400", hash_original_field = "786AC07A1E16FDB1F134271AA028A7C1", hash_generated_field = "17A3499D3AE1DB6784657D5E8AE3951F")

    private static final boolean DEFAULT_DITHER = true;
}

