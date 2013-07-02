package android.graphics.drawable;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.os.SystemClock;

public class DrawableContainer extends Drawable implements Drawable.Callback {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.851 -0400", hash_original_field = "6DB222960773F6967427BFC156C9AD7B", hash_generated_field = "2DB19AB4F82F5273EE7E6529BBA72AE4")

    private DrawableContainerState mDrawableContainerState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.851 -0400", hash_original_field = "B240482EE6277AAB0A9A6BA264B7D741", hash_generated_field = "45111284A103854181686551CAB9ECE6")

    private Drawable mCurrDrawable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.852 -0400", hash_original_field = "964D4F44E49C213AB7292F7E0E37C642", hash_generated_field = "3503E015FBD1508491B2F18FDC5DAF9F")

    private int mAlpha = 0xFF;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.852 -0400", hash_original_field = "8B2ED40D22A4C08C94CFC40B6DE589B8", hash_generated_field = "5D6D299C9DDEDCCB11EFFA1C147C3DF6")

    private ColorFilter mColorFilter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.852 -0400", hash_original_field = "87D94DD4DB47AE1293A4A6B2F3F1320A", hash_generated_field = "68BE4C2261D94A949F760C32A43779D9")

    private int mCurIndex = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.852 -0400", hash_original_field = "9FB80C30383848C8D006680B5F3BDAF9", hash_generated_field = "5CA5A1EF3CAA45117BCACBC34EF05952")

    private boolean mMutated;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.852 -0400", hash_original_field = "FE03A919E4DC41F1F154951DE4E81FB8", hash_generated_field = "703FCA3A43FE2C0EE6947EDF58A21E0E")

    private Runnable mAnimationRunnable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.852 -0400", hash_original_field = "EF143134718F0A7B6C5999AC0903EEFD", hash_generated_field = "4B94C11DAC8E800C8F6926DD6BCC82A8")

    private long mEnterAnimationEnd;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.852 -0400", hash_original_field = "9C4D4B2BC75FDD3F32F00F40201BB026", hash_generated_field = "06C911F5C85391F52F5C0A8476C4502F")

    private long mExitAnimationEnd;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.852 -0400", hash_original_field = "F6C429B950C530EFBF6200ED9DFBE3ED", hash_generated_field = "6FEFDE257A7DFEFF73429269253AF7F7")

    private Drawable mLastDrawable;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.852 -0400", hash_original_method = "094684F7E86BAEC8B113ECD0EF1A35E3", hash_generated_method = "094684F7E86BAEC8B113ECD0EF1A35E3")
    public DrawableContainer ()
    {
        
    }


    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.853 -0400", hash_original_method = "4C0F5C22B9C7136183C2CC55D1B2C479", hash_generated_method = "3B933255E36ECAF022F256AF890A8CF1")
    @Override
    public void draw(Canvas canvas) {
        {
            mCurrDrawable.draw(canvas);
        } 
        {
            mLastDrawable.draw(canvas);
        } 
        addTaint(canvas.getTaint());
        
        
            
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.853 -0400", hash_original_method = "91A12202891A2BC9DA6AA80DC6DB676A", hash_generated_method = "D42E09C69321F3048F9F6B1F32C8C075")
    @Override
    public int getChangingConfigurations() {
        int varE2A8A6B9AEA0FE1034028098D5421591_1526345265 = (super.getChangingConfigurations()
                | mDrawableContainerState.mChangingConfigurations
                | mDrawableContainerState.mChildrenChangingConfigurations);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_284507621 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_284507621;
        
        
                
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.853 -0400", hash_original_method = "8B17DDF51BCD655A61A83DE84247EF99", hash_generated_method = "6B0B7A9A611289C2F4D9B4D01EB3B7B4")
    @Override
    public boolean getPadding(Rect padding) {
        final Rect r = mDrawableContainerState.getConstantPadding();
        {
            padding.set(r);
        } 
        {
            boolean var9D17F75DD17A1079B3E7BB26332DA382_586886016 = (mCurrDrawable.getPadding(padding));
        } 
        {
            boolean var26681595319194856AEB3747307B6E08_1123796027 = (super.getPadding(padding));
        } 
        addTaint(padding.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_745089441 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_745089441;
        
        
        
            
            
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.854 -0400", hash_original_method = "33F48EB62D0DC564AE5544FE28781DA5", hash_generated_method = "DFEEACD8D90C281096E76DEDB5145E03")
    @Override
    public void setAlpha(int alpha) {
        {
            mAlpha = alpha;
            {
                {
                    mCurrDrawable.setAlpha(alpha);
                } 
                {
                    animate(false);
                } 
            } 
        } 
        
        
            
            
                
                    
                
                    
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.854 -0400", hash_original_method = "9C07B593875E6134F95EF1337402CCE4", hash_generated_method = "C4810DE924EA062E5BE16527990391D2")
    @Override
    public void setDither(boolean dither) {
        {
            mDrawableContainerState.mDither = dither;
            {
                mCurrDrawable.setDither(mDrawableContainerState.mDither);
            } 
        } 
        
        
            
            
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.855 -0400", hash_original_method = "AE256967E0AC09F2540019B105CEB308", hash_generated_method = "B5D4110B90A635D888D13ED6952D19CF")
    @Override
    public void setColorFilter(ColorFilter cf) {
        {
            mColorFilter = cf;
            {
                mCurrDrawable.setColorFilter(cf);
            } 
        } 
        
        
            
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.856 -0400", hash_original_method = "7519B8FEB07821EB54C84C24ACFADDFA", hash_generated_method = "178B1F3F50B4632FA54670FF64888C5C")
    public void setEnterFadeDuration(int ms) {
        mDrawableContainerState.mEnterFadeDuration = ms;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.856 -0400", hash_original_method = "037AE4EFE359E0A64F3D29E228D5C257", hash_generated_method = "BC4F4832E0DF7B103CB719B318AB9698")
    public void setExitFadeDuration(int ms) {
        mDrawableContainerState.mExitFadeDuration = ms;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.857 -0400", hash_original_method = "6D25AB5CD33FA39A7528151D77324281", hash_generated_method = "AB6518B50353017CCC67182BC014DBC2")
    @Override
    protected void onBoundsChange(Rect bounds) {
        
        {
            mLastDrawable.setBounds(bounds);
        } 
        {
            mCurrDrawable.setBounds(bounds);
        } 
        addTaint(bounds.getTaint());
        
        
            
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.857 -0400", hash_original_method = "C66859AD1DDD72E10B118943143E6E81", hash_generated_method = "10AA92B83E163B46D8FBF44B6D325447")
    @Override
    public boolean isStateful() {
        boolean varA0DBABDA86F80BDA76204D706B1453DD_880137693 = (mDrawableContainerState.isStateful());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_201008624 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_201008624;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.858 -0400", hash_original_method = "27D546A1CE7DA293AA4ECB359818692F", hash_generated_method = "AD9773C43619E7AC269F9CFD060232E0")
    @Override
    public void jumpToCurrentState() {
        boolean changed = false;
        {
            mLastDrawable.jumpToCurrentState();
            mLastDrawable = null;
            changed = true;
        } 
        {
            mCurrDrawable.jumpToCurrentState();
            mCurrDrawable.setAlpha(mAlpha);
        } 
        {
            mExitAnimationEnd = 0;
            changed = true;
        } 
        {
            mEnterAnimationEnd = 0;
            changed = true;
        } 
        {
            invalidateSelf();
        } 
        
        
        
            
            
            
        
        
            
            
        
        
            
            
        
        
            
            
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.858 -0400", hash_original_method = "19BC6D466BAAC5E8F9FD1F6AF6038AC5", hash_generated_method = "27F983195532E29A8BBF6D59CF5BD4B2")
    @Override
    protected boolean onStateChange(int[] state) {
        
        {
            boolean var7D9D27628859DC760669C5E95CEC9347_1671485537 = (mLastDrawable.setState(state));
        } 
        {
            boolean var34BF092C138BEF3A5446BB229E4C4465_1447374745 = (mCurrDrawable.setState(state));
        } 
        addTaint(state[0]);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_484519510 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_484519510;
        
        
            
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.859 -0400", hash_original_method = "370D8F089D3CBC7A83FFF71A722725DE", hash_generated_method = "6BF64F5307CF2AB7276E0C213979E77C")
    @Override
    protected boolean onLevelChange(int level) {
        
        {
            boolean var805174EC0CB8E349AD8B0CFED368D4ED_1061668197 = (mLastDrawable.setLevel(level));
        } 
        {
            boolean var9F2927B783DF9D88F186D5048323875C_541873514 = (mCurrDrawable.setLevel(level));
        } 
        addTaint(level);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_58367528 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_58367528;
        
        
            
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.859 -0400", hash_original_method = "DE0AA10FF6502448C6D350B4086CE53A", hash_generated_method = "12C84BA424F4539C0C5E12BCD1665131")
    @Override
    public int getIntrinsicWidth() {
        {
            boolean var0B340EAF1309515EAF1CC7DA3839F9FB_874296937 = (mDrawableContainerState.isConstantSize());
            {
                int var0F0058AD5FC72A5A68BC291FFE8E2602_1377032241 = (mDrawableContainerState.getConstantWidth());
            } 
        } 
        {
            Object var804AA1F51D4684C6DA855574F2183237_1412756544 = (mCurrDrawable.getIntrinsicWidth());
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_496481987 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_496481987;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.860 -0400", hash_original_method = "FA2E61AFB9D6236C0B64D53932A9175C", hash_generated_method = "9096D423DFBB84FC9DF7602810E5B268")
    @Override
    public int getIntrinsicHeight() {
        {
            boolean var0B340EAF1309515EAF1CC7DA3839F9FB_524133058 = (mDrawableContainerState.isConstantSize());
            {
                int var7D93BD4EA71DF412B81C3919D19F8E98_1907469536 = (mDrawableContainerState.getConstantHeight());
            } 
        } 
        {
            Object var2AC8A5422442A65DE13D9D7D1E47A33C_435597567 = (mCurrDrawable.getIntrinsicHeight());
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1434075018 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1434075018;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.861 -0400", hash_original_method = "758162C9EFC5A9F0A72A174E63E68436", hash_generated_method = "69F4783D099E034D2F9D6DCA14CEBE36")
    @Override
    public int getMinimumWidth() {
        {
            boolean var0B340EAF1309515EAF1CC7DA3839F9FB_227914415 = (mDrawableContainerState.isConstantSize());
            {
                int var794C9156EA4DDD9998CC96EDE4443CB4_632055824 = (mDrawableContainerState.getConstantMinimumWidth());
            } 
        } 
        {
            Object var24E11FA644681FD383649322A0C3A058_1972045923 = (mCurrDrawable.getMinimumWidth());
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1945252203 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1945252203;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.861 -0400", hash_original_method = "4272F469B4A869660F9BDAF1177E3127", hash_generated_method = "37FA8A8F0A0455E4DD53BF07E280C80D")
    @Override
    public int getMinimumHeight() {
        {
            boolean var0B340EAF1309515EAF1CC7DA3839F9FB_973130698 = (mDrawableContainerState.isConstantSize());
            {
                int varCA7D9B9EAB1185685A20A079B1E1CCCF_1054533359 = (mDrawableContainerState.getConstantMinimumHeight());
            } 
        } 
        {
            Object var8E08C5272C558A8669F131FA4FB6EE24_1943905778 = (mCurrDrawable.getMinimumHeight());
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2039086262 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2039086262;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.862 -0400", hash_original_method = "4797F0F1C7EC2DAE5A1D44FF8AA06A3E", hash_generated_method = "D921D207D2A51997815359741034686B")
    public void invalidateDrawable(Drawable who) {
        {
            boolean var7C6FCB42D88C4A46B669C493EC47FC13_1247714736 = (who == mCurrDrawable && getCallback() != null);
            {
                getCallback().invalidateDrawable(this);
            } 
        } 
        addTaint(who.getTaint());
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.863 -0400", hash_original_method = "D79EA559DF51F16BABDD5FAB2B1074A7", hash_generated_method = "04D155E43E5A3899771DB71F5775E366")
    public void scheduleDrawable(Drawable who, Runnable what, long when) {
        {
            boolean var7C6FCB42D88C4A46B669C493EC47FC13_1974196720 = (who == mCurrDrawable && getCallback() != null);
            {
                getCallback().scheduleDrawable(this, what, when);
            } 
        } 
        addTaint(who.getTaint());
        addTaint(what.getTaint());
        addTaint(when);
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.863 -0400", hash_original_method = "BF197FFA306784FCC1A1C762AD43B7D1", hash_generated_method = "4F7CC71D29FB2EFA8349A3AF37692C95")
    public void unscheduleDrawable(Drawable who, Runnable what) {
        {
            boolean var7C6FCB42D88C4A46B669C493EC47FC13_1794164631 = (who == mCurrDrawable && getCallback() != null);
            {
                getCallback().unscheduleDrawable(this, what);
            } 
        } 
        addTaint(who.getTaint());
        addTaint(what.getTaint());
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.864 -0400", hash_original_method = "29A0A86F8B666C86609CA80FF461C32C", hash_generated_method = "04BCC2B276D4334FF4A975CF61A61D62")
    @Override
    public boolean setVisible(boolean visible, boolean restart) {
        boolean changed = super.setVisible(visible, restart);
        {
            mLastDrawable.setVisible(visible, restart);
        } 
        {
            mCurrDrawable.setVisible(visible, restart);
        } 
        addTaint(visible);
        addTaint(restart);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_192418060 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_192418060;
        
        
        
            
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.864 -0400", hash_original_method = "1234F5DF929258DFDBB23F3D48CB2B3B", hash_generated_method = "AC3DAC930DC187F7CC795EE4254ADB11")
    @Override
    public int getOpacity() {
        {
            boolean var43C2AE0F0A427F69D13410F1C256ECD1_830145272 = (mCurrDrawable == null || !mCurrDrawable.isVisible());
            Object varA261B893D3519856DD56BE7D2273C99F_1304564464 = (mDrawableContainerState.getOpacity());
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_95418904 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_95418904;
        
        
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.867 -0400", hash_original_method = "DF0D8C256AB252B9122AE282C5336A53", hash_generated_method = "CB5D1455D14A493049CF89EC8C8109B9")
    public boolean selectDrawable(int idx) {
        final long now = SystemClock.uptimeMillis();
        android.util.Log.i(TAG, toString() + " from " + mCurIndex + " to " + idx
                + ": exit=" + mDrawableContainerState.mExitFadeDuration
                + " enter=" + mDrawableContainerState.mEnterFadeDuration);
        {
            {
                mLastDrawable.setVisible(false, false);
            } 
            {
                mLastDrawable = mCurrDrawable;
                mExitAnimationEnd = now + mDrawableContainerState.mExitFadeDuration;
            } 
            {
                mLastDrawable = null;
                mExitAnimationEnd = 0;
            } 
        } 
        {
            mCurrDrawable.setVisible(false, false);
        } 
        {
            Drawable d = mDrawableContainerState.mDrawables[idx];
            mCurrDrawable = d;
            mCurIndex = idx;
            {
                {
                    mEnterAnimationEnd = now + mDrawableContainerState.mEnterFadeDuration;
                } 
                {
                    d.setAlpha(mAlpha);
                } 
                d.setVisible(isVisible(), true);
                d.setDither(mDrawableContainerState.mDither);
                d.setColorFilter(mColorFilter);
                d.setState(getState());
                d.setLevel(getLevel());
                d.setBounds(getBounds());
            } 
        } 
        {
            mCurrDrawable = null;
            mCurIndex = -1;
        } 
        {
            {
                mAnimationRunnable = new Runnable() {                    
                    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.866 -0400", hash_original_method = "FF47FBE8389551C190770D50719F0AEF", hash_generated_method = "494EBE0F0E6AEB2E1F7413236FFA416A")
                    @Override
                    public void run() {
                        animate(true);
                        invalidateSelf();
                        
                        
                        
                    }
};
            } 
            {
                unscheduleSelf(mAnimationRunnable);
            } 
            animate(true);
        } 
        invalidateSelf();
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_335337440 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_335337440;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.869 -0400", hash_original_method = "10A80C718FDF3E5D6299035E54551605", hash_generated_method = "E923F3841E06CACF45B0A2A5DF07EDAA")
     void animate(boolean schedule) {
        final long now = SystemClock.uptimeMillis();
        boolean animating = false;
        {
            {
                {
                    mCurrDrawable.setAlpha(mAlpha);
                    mEnterAnimationEnd = 0;
                } 
                {
                    int animAlpha = (int)((mEnterAnimationEnd-now)*255)
                            / mDrawableContainerState.mEnterFadeDuration;
                    android.util.Log.i(TAG, toString() + " cur alpha " + animAlpha);
                    mCurrDrawable.setAlpha(((255-animAlpha)*mAlpha)/255);
                    animating = true;
                } 
            } 
        } 
        {
            mEnterAnimationEnd = 0;
        } 
        {
            {
                {
                    mLastDrawable.setVisible(false, false);
                    mLastDrawable = null;
                    mExitAnimationEnd = 0;
                } 
                {
                    int animAlpha = (int)((mExitAnimationEnd-now)*255)
                            / mDrawableContainerState.mExitFadeDuration;
                    android.util.Log.i(TAG, toString() + " last alpha " + animAlpha);
                    mLastDrawable.setAlpha((animAlpha*mAlpha)/255);
                    animating = true;
                } 
            } 
        } 
        {
            mExitAnimationEnd = 0;
        } 
        {
            scheduleSelf(mAnimationRunnable, now + 1000/60);
        } 
        addTaint(schedule);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.869 -0400", hash_original_method = "2271215EA07D061295E4A17A597D4C85", hash_generated_method = "36DD56DB95A366C4F366BBE30EE092E0")
    @Override
    public Drawable getCurrent() {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_1038626166 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1038626166 = mCurrDrawable;
        varB4EAC82CA7396A68D541C85D26508E83_1038626166.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1038626166;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.870 -0400", hash_original_method = "7CCE0C3F432CC06D16574FAD35E80869", hash_generated_method = "A6D33A161552E59DD8BAFCB7561D6947")
    @Override
    public ConstantState getConstantState() {
        ConstantState varB4EAC82CA7396A68D541C85D26508E83_177057753 = null; 
        ConstantState varB4EAC82CA7396A68D541C85D26508E83_1816135516 = null; 
        {
            boolean varCF83176F78BEA6477EA3D34B3F17AD89_523967058 = (mDrawableContainerState.canConstantState());
            {
                mDrawableContainerState.mChangingConfigurations = getChangingConfigurations();
                varB4EAC82CA7396A68D541C85D26508E83_177057753 = mDrawableContainerState;
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1816135516 = null;
        ConstantState varA7E53CE21691AB073D9660D615818899_510145587; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_510145587 = varB4EAC82CA7396A68D541C85D26508E83_177057753;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_510145587 = varB4EAC82CA7396A68D541C85D26508E83_1816135516;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_510145587.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_510145587;
        
        
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.871 -0400", hash_original_method = "9CED290C930F72A121B65658EE47F79B", hash_generated_method = "8B234DD851AF3143EB3BEB9ED5DEC3BB")
    @Override
    public Drawable mutate() {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_1619372843 = null; 
        {
            boolean varC94B19053599294E7944C8C841976773_1544408752 = (!mMutated && super.mutate() == this);
            {
                final int N = mDrawableContainerState.getChildCount();
                final Drawable[] drawables = mDrawableContainerState.getChildren();
                {
                    int i = 0;
                    {
                        drawables[i].mutate();
                    } 
                } 
                mMutated = true;
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1619372843 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1619372843.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1619372843;
        
        
            
            
            
                
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.872 -0400", hash_original_method = "8007C958EC09F138BD431BCAF111D646", hash_generated_method = "C420DDEC89C73B6C63F887832E2D9CA4")
    protected void setConstantState(DrawableContainerState state) {
        mDrawableContainerState = state;
        
        
    }

    
    public abstract static class DrawableContainerState extends ConstantState {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.872 -0400", hash_original_field = "4AA3D5C224CE197897B9C6F17BF367CD", hash_generated_field = "69A4D31099BD07B55F0FC0556B45F074")

        DrawableContainer mOwner;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.872 -0400", hash_original_field = "276E0645C4E2084773D0EB8C5576428C", hash_generated_field = "9BFAF00848476277D36D9BA586984BA7")

        int mChangingConfigurations;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.872 -0400", hash_original_field = "8755A6790E0FAEFCC765046FF423478D", hash_generated_field = "E8F7332658D4B8911B8427F9E33AC9BD")

        int mChildrenChangingConfigurations;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.872 -0400", hash_original_field = "1891CBC78C734C6A7EBB0D921FFE84B0", hash_generated_field = "B3C5F926BAE6E9ED929417A165A9782D")

        Drawable[] mDrawables;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.872 -0400", hash_original_field = "B2A189B31612476BCCDDB62DFD55B139", hash_generated_field = "77E2F294FC2676328BFD127FCF506329")

        int mNumChildren;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.872 -0400", hash_original_field = "0C8A0F55137EA7C9D079883411C6F93F", hash_generated_field = "A174A0353A9684103C90D7CCC8701C2F")

        boolean mVariablePadding = false;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.872 -0400", hash_original_field = "C9952AF9D9005BC34C04F1E2CB4C3C47", hash_generated_field = "C4240083AE1C6AD18CF7413499D117A4")

        Rect mConstantPadding = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.872 -0400", hash_original_field = "5265BDCA75A610EFF809E61F883963F5", hash_generated_field = "6BFEC2D16A3F7C5C15697878B6EF3BBE")

        boolean mConstantSize = false;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.872 -0400", hash_original_field = "1F301A7547BD825E77BA27AAD0924AB6", hash_generated_field = "430C60111FB869A696B5B5437CADEC6A")

        boolean mComputedConstantSize = false;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.872 -0400", hash_original_field = "C3657F4EC6FDE8A4C5B25696644DA1FB", hash_generated_field = "4D42859CADFABA2E50BE968727F544D7")

        int mConstantWidth;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.872 -0400", hash_original_field = "D30B88E9D07E45516A5C783A50766F03", hash_generated_field = "B4AC32864D468EB70183C5472B0F9A3B")

        int mConstantHeight;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.872 -0400", hash_original_field = "73F34719DB2AE87BFF64DD04BBD99771", hash_generated_field = "65FF036F9AF5D3B1235D68E5F33E8546")

        int mConstantMinimumWidth;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.872 -0400", hash_original_field = "AB34B1FB48C56A86337A52EBD12BA9E1", hash_generated_field = "15038681586DC6317E5E8BDA3C11F3B1")

        int mConstantMinimumHeight;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.872 -0400", hash_original_field = "B8FE7B1D7EF53BE4167C040A5FEB7CC7", hash_generated_field = "0E129F2B3EAED33E8435CEB0AF66A927")

        boolean mHaveOpacity = false;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.872 -0400", hash_original_field = "9D334A125EE4B3831821AB1264C029B9", hash_generated_field = "F94EB6B55A1DFE34A922350D13706418")

        int mOpacity;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.872 -0400", hash_original_field = "0AB968E9E6651BF0E687DAF7846B214C", hash_generated_field = "788B667F97461387E15CDD9C2D78DA89")

        boolean mHaveStateful = false;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.872 -0400", hash_original_field = "1819E5C118FDB6B2BF917A4481AE2A7A", hash_generated_field = "6CBAA9F8E31FD09725242CB8EF367A38")

        boolean mStateful;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.872 -0400", hash_original_field = "2E319D4D352B34E33CF19129B7212FC6", hash_generated_field = "04605894B57F7B3414AF620BF4AC040E")

        boolean mCheckedConstantState;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.873 -0400", hash_original_field = "7C8FD9809F31C20B8422D623B0EC0C4F", hash_generated_field = "09212A3A30B7E6D48DEECC4F4639CCBC")

        boolean mCanConstantState;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.873 -0400", hash_original_field = "C325585054D3982E395745F18CBCD0A6", hash_generated_field = "F1842B9E642BB7380414BD0D8EACA9C1")

        boolean mPaddingChecked = false;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.873 -0400", hash_original_field = "66DCB50C0F72DE519AF3706206BAB5B4", hash_generated_field = "ADD3447A81FDA5C4E55789938CB01CA9")

        boolean mDither = DEFAULT_DITHER;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.873 -0400", hash_original_field = "7EF73DB740A09C72072F895C234DF078", hash_generated_field = "3A008F34A7ED7348F09E0D7AC5FD8046")

        int mEnterFadeDuration;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.873 -0400", hash_original_field = "35F39F9E1FFCE54C39871C49C674BB21", hash_generated_field = "72291FB3AAE88AF4CCFC28A4C19C4F0A")

        int mExitFadeDuration;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.874 -0400", hash_original_method = "BB71D442E5298FC9607AB33C7CE8B85B", hash_generated_method = "F84E21DCDB781BEC0BB3F938B722A844")
          DrawableContainerState(DrawableContainerState orig, DrawableContainer owner,
                Resources res) {
            mOwner = owner;
            {
                mChangingConfigurations = orig.mChangingConfigurations;
                mChildrenChangingConfigurations = orig.mChildrenChangingConfigurations;
                final Drawable[] origDr = orig.mDrawables;
                mDrawables = new Drawable[origDr.length];
                mNumChildren = orig.mNumChildren;
                final int N = mNumChildren;
                {
                    int i = 0;
                    {
                        {
                            mDrawables[i] = origDr[i].getConstantState().newDrawable(res);
                        } 
                        {
                            mDrawables[i] = origDr[i].getConstantState().newDrawable();
                        } 
                        mDrawables[i].setCallback(owner);
                    } 
                } 
                mCheckedConstantState = mCanConstantState = true;
                mVariablePadding = orig.mVariablePadding;
                {
                    mConstantPadding = new Rect(orig.mConstantPadding);
                } 
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
            } 
            {
                mDrawables = new Drawable[10];
                mNumChildren = 0;
                mCheckedConstantState = mCanConstantState = false;
            } 
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.874 -0400", hash_original_method = "9E7D7C67EAC365FF19BD4971762612A5", hash_generated_method = "47D8882B24099FD8C8F5927688D2B9B9")
        @Override
        public int getChangingConfigurations() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_935655886 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_935655886;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.875 -0400", hash_original_method = "1DF96DB91DC15ED3AA2CD90CE63D5DEA", hash_generated_method = "F43EC80FBF3DA2ABF004E4D64B3650D0")
        public final int addChild(Drawable dr) {
            final int pos = mNumChildren;
            {
                growArray(pos, pos+10);
            } 
            dr.setVisible(false, true);
            dr.setCallback(mOwner);
            mDrawables[pos] = dr;
            mChildrenChangingConfigurations |= dr.getChangingConfigurations();
            mHaveOpacity = false;
            mHaveStateful = false;
            mConstantPadding = null;
            mPaddingChecked = false;
            mComputedConstantSize = false;
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2068360615 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2068360615;
            
            
            
                
            
            
            
            
            
            
            
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.875 -0400", hash_original_method = "58D23B7CD1BBD3B06877382B700017CE", hash_generated_method = "FF1A4A3F8F699393E6DDD879C1E214C7")
        public final int getChildCount() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_233469817 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_233469817;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.876 -0400", hash_original_method = "F5C2CB0FAF6BF41EBD2EF1D322F89AD5", hash_generated_method = "430BE889FE8B9AC4D82929504B1D7963")
        public final Drawable[] getChildren() {
            Drawable[] varB4EAC82CA7396A68D541C85D26508E83_1904092083 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1904092083 = mDrawables;
            varB4EAC82CA7396A68D541C85D26508E83_1904092083.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1904092083;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.877 -0400", hash_original_method = "291079EAD380D117FACCF8E598F58B57", hash_generated_method = "9E63340C83EEEB40E3F74E85F49DB546")
        public final void setVariablePadding(boolean variable) {
            mVariablePadding = variable;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.879 -0400", hash_original_method = "F49D2F39EC6FEC96BF9263C8B9281632", hash_generated_method = "B9F0CF1EF405C8BB85C97608D22861D0")
        public final Rect getConstantPadding() {
            Rect varB4EAC82CA7396A68D541C85D26508E83_1738542351 = null; 
            Rect varB4EAC82CA7396A68D541C85D26508E83_1186157720 = null; 
            Rect varB4EAC82CA7396A68D541C85D26508E83_1547986448 = null; 
            {
                varB4EAC82CA7396A68D541C85D26508E83_1738542351 = null;
            } 
            {
                varB4EAC82CA7396A68D541C85D26508E83_1186157720 = mConstantPadding;
            } 
            Rect r = null;
            final Rect t = new Rect();
            final int N = getChildCount();
            final Drawable[] drawables = mDrawables;
            {
                int i = 0;
                {
                    {
                        boolean var76D1F57601B94A402DBCF57DF7D5D77A_2033779655 = (drawables[i].getPadding(t));
                        {
                            r = new Rect(0, 0, 0, 0);
                            r.left = t.left;
                            r.top = t.top;
                            r.right = t.right;
                            r.bottom = t.bottom;
                        } 
                    } 
                } 
            } 
            mPaddingChecked = true;
            varB4EAC82CA7396A68D541C85D26508E83_1547986448 = (mConstantPadding = r);
            Rect varA7E53CE21691AB073D9660D615818899_1833547660; 
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: 
                    varA7E53CE21691AB073D9660D615818899_1833547660 = varB4EAC82CA7396A68D541C85D26508E83_1738542351;
                    break;
                case 2: 
                    varA7E53CE21691AB073D9660D615818899_1833547660 = varB4EAC82CA7396A68D541C85D26508E83_1186157720;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1833547660 = varB4EAC82CA7396A68D541C85D26508E83_1547986448;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1833547660.addTaint(getTaint()); 
            return varA7E53CE21691AB073D9660D615818899_1833547660;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.880 -0400", hash_original_method = "1BEAC422BABD76426588E9F434C2D5CD", hash_generated_method = "0B85399E5ECA2518EC987CAE64EFA9F0")
        public final void setConstantSize(boolean constant) {
            mConstantSize = constant;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.880 -0400", hash_original_method = "23D6FDB773CAAECCFEA4282EEDA0FF8B", hash_generated_method = "AE89A9A12493E1D371FC7BCDD9E2C7EC")
        public final boolean isConstantSize() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1907811653 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1907811653;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.881 -0400", hash_original_method = "AEDD9F8F931AA0310C6AB599B9490E0C", hash_generated_method = "F07D48B69BE26C365D1C49D1B7D1769A")
        public final int getConstantWidth() {
            {
                computeConstantSize();
            } 
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_469175422 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_469175422;
            
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.881 -0400", hash_original_method = "A117A0F50DACA3E076E36F6E0FD5A697", hash_generated_method = "A061D2237A0DC847FBE4246960EE57EE")
        public final int getConstantHeight() {
            {
                computeConstantSize();
            } 
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1336446897 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1336446897;
            
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.882 -0400", hash_original_method = "DA23CD9C0D969BCBC5A31F19CEBA2FA0", hash_generated_method = "9B05D56205B45D82913DC7D609F168D1")
        public final int getConstantMinimumWidth() {
            {
                computeConstantSize();
            } 
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1579653659 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1579653659;
            
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.882 -0400", hash_original_method = "9AAB9DC0F579B2E57159CF0852B151D2", hash_generated_method = "B06E6F36E8DC77E613EBC85B1322F6D4")
        public final int getConstantMinimumHeight() {
            {
                computeConstantSize();
            } 
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_381647887 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_381647887;
            
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.883 -0400", hash_original_method = "113DB032EAC82FBADFFAA0B97D39A18D", hash_generated_method = "3196D8C191C1590AB5CFE0477B30AC1B")
        protected void computeConstantSize() {
            mComputedConstantSize = true;
            final int N = getChildCount();
            final Drawable[] drawables = mDrawables;
            mConstantWidth = mConstantHeight = -1;
            mConstantMinimumWidth = mConstantMinimumHeight = 0;
            {
                int i = 0;
                {
                    Drawable dr = drawables[i];
                    int s = dr.getIntrinsicWidth();
                    mConstantWidth = s;
                    s = dr.getIntrinsicHeight();
                    mConstantHeight = s;
                    s = dr.getMinimumWidth();
                    mConstantMinimumWidth = s;
                    s = dr.getMinimumHeight();
                    mConstantMinimumHeight = s;
                } 
            } 
            
            
            
            
            
            
            
                
                
                
                
                
                
                
                
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.883 -0400", hash_original_method = "C7A92F60FC2D3E73CF200C7144A831FD", hash_generated_method = "31EA4832DE115AD3D1ED2D154F4F3A0E")
        public final void setEnterFadeDuration(int duration) {
            mEnterFadeDuration = duration;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.884 -0400", hash_original_method = "47A305314E1265D4F19BD4B53B739910", hash_generated_method = "A1DA9D6EFD3B6F579550057AC69C7C02")
        public final int getEnterFadeDuration() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_625237455 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_625237455;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.884 -0400", hash_original_method = "1ED7E9EB98364255825D9EFA32269162", hash_generated_method = "93C0A2E6B640F643574AA208A98DA016")
        public final void setExitFadeDuration(int duration) {
            mExitFadeDuration = duration;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.884 -0400", hash_original_method = "8AF957428721C92A0DFF9444CB2E7B41", hash_generated_method = "28932D33C271CCFF924E344BA0E9500A")
        public final int getExitFadeDuration() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_385365974 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_385365974;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.885 -0400", hash_original_method = "C3CEC4829800E9DBA4286BAEED120A24", hash_generated_method = "DCD995EF33BE3CB495A90C5FDB185B61")
        public final int getOpacity() {
            final int N = getChildCount();
            final Drawable[] drawables = mDrawables;
            int op;
            op = drawables[0].getOpacity();
            op = PixelFormat.TRANSPARENT;
            {
                int i = 1;
                {
                    op = Drawable.resolveOpacity(op, drawables[i].getOpacity());
                } 
            } 
            mOpacity = op;
            mHaveOpacity = true;
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_588699288 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_588699288;
            
            
                
            
            
            
            
            
                
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.886 -0400", hash_original_method = "CFE0AE04764A8B8DC9358FA475490068", hash_generated_method = "03F21A2E975F8BF1B36F248228C75BA2")
        public final boolean isStateful() {
            boolean stateful = false;
            final int N = getChildCount();
            {
                int i = 0;
                {
                    {
                        boolean varFD66FD269DB3E977FED32CCF0B77624A_466501997 = (mDrawables[i].isStateful());
                        {
                            stateful = true;
                        } 
                    } 
                } 
            } 
            mStateful = stateful;
            mHaveStateful = true;
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1051792477 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1051792477;
            
            
                
            
            
            
            
                
                    
                    
                
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.886 -0400", hash_original_method = "A9E2F6299A2B0C0DB78600A3C23F092D", hash_generated_method = "E11619AE34CF6BE91C412151455E81D1")
        public void growArray(int oldSize, int newSize) {
            Drawable[] newDrawables = new Drawable[newSize];
            System.arraycopy(mDrawables, 0, newDrawables, 0, oldSize);
            mDrawables = newDrawables;
            addTaint(oldSize);
            addTaint(newSize);
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.887 -0400", hash_original_method = "F91020706361DEC18BACE4525A4D4C39", hash_generated_method = "5FBB97C40C3863232906A8E50420FC5B")
        public synchronized boolean canConstantState() {
            {
                mCanConstantState = true;
                final int N = mNumChildren;
                {
                    int i = 0;
                    {
                        {
                            boolean var67C8694F6E7AAF6172CA9B1F09577060_710452735 = (mDrawables[i].getConstantState() == null);
                            {
                                mCanConstantState = false;
                            } 
                        } 
                    } 
                } 
                mCheckedConstantState = true;
            } 
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_442023668 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_442023668;
            
            
                
                
                
                    
                        
                        
                    
                
                
            
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.887 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "58EDF43BA541A4D47EECFEC3901C7AED")

    private static final boolean DEBUG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.888 -0400", hash_original_field = "487A87FC99B2160674C40DE470BDF1B0", hash_generated_field = "48C9B565D3BB13F89C4A690FEBD0B203")

    private static final String TAG = "DrawableContainer";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:32.888 -0400", hash_original_field = "786AC07A1E16FDB1F134271AA028A7C1", hash_generated_field = "17A3499D3AE1DB6784657D5E8AE3951F")

    private static final boolean DEFAULT_DITHER = true;
}

