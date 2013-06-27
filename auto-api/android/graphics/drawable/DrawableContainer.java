package android.graphics.drawable;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.os.SystemClock;

public class DrawableContainer extends Drawable implements Drawable.Callback {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.899 -0400", hash_original_field = "6DB222960773F6967427BFC156C9AD7B", hash_generated_field = "2DB19AB4F82F5273EE7E6529BBA72AE4")

    private DrawableContainerState mDrawableContainerState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.899 -0400", hash_original_field = "B240482EE6277AAB0A9A6BA264B7D741", hash_generated_field = "45111284A103854181686551CAB9ECE6")

    private Drawable mCurrDrawable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.899 -0400", hash_original_field = "964D4F44E49C213AB7292F7E0E37C642", hash_generated_field = "3503E015FBD1508491B2F18FDC5DAF9F")

    private int mAlpha = 0xFF;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.899 -0400", hash_original_field = "8B2ED40D22A4C08C94CFC40B6DE589B8", hash_generated_field = "5D6D299C9DDEDCCB11EFFA1C147C3DF6")

    private ColorFilter mColorFilter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.899 -0400", hash_original_field = "87D94DD4DB47AE1293A4A6B2F3F1320A", hash_generated_field = "68BE4C2261D94A949F760C32A43779D9")

    private int mCurIndex = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.899 -0400", hash_original_field = "9FB80C30383848C8D006680B5F3BDAF9", hash_generated_field = "5CA5A1EF3CAA45117BCACBC34EF05952")

    private boolean mMutated;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.900 -0400", hash_original_field = "FE03A919E4DC41F1F154951DE4E81FB8", hash_generated_field = "703FCA3A43FE2C0EE6947EDF58A21E0E")

    private Runnable mAnimationRunnable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.900 -0400", hash_original_field = "EF143134718F0A7B6C5999AC0903EEFD", hash_generated_field = "4B94C11DAC8E800C8F6926DD6BCC82A8")

    private long mEnterAnimationEnd;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.900 -0400", hash_original_field = "9C4D4B2BC75FDD3F32F00F40201BB026", hash_generated_field = "06C911F5C85391F52F5C0A8476C4502F")

    private long mExitAnimationEnd;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.900 -0400", hash_original_field = "F6C429B950C530EFBF6200ED9DFBE3ED", hash_generated_field = "6FEFDE257A7DFEFF73429269253AF7F7")

    private Drawable mLastDrawable;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.900 -0400", hash_original_method = "094684F7E86BAEC8B113ECD0EF1A35E3", hash_generated_method = "094684F7E86BAEC8B113ECD0EF1A35E3")
    public DrawableContainer ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.901 -0400", hash_original_method = "4C0F5C22B9C7136183C2CC55D1B2C479", hash_generated_method = "3B933255E36ECAF022F256AF890A8CF1")
    @Override
    public void draw(Canvas canvas) {
        {
            mCurrDrawable.draw(canvas);
        } //End block
        {
            mLastDrawable.draw(canvas);
        } //End block
        addTaint(canvas.getTaint());
        // ---------- Original Method ----------
        //if (mCurrDrawable != null) {
            //mCurrDrawable.draw(canvas);
        //}
        //if (mLastDrawable != null) {
            //mLastDrawable.draw(canvas);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.904 -0400", hash_original_method = "91A12202891A2BC9DA6AA80DC6DB676A", hash_generated_method = "B4013A8427C05D034C32CD4B37E7EB07")
    @Override
    public int getChangingConfigurations() {
        int varE2A8A6B9AEA0FE1034028098D5421591_220807085 = (super.getChangingConfigurations()
                | mDrawableContainerState.mChangingConfigurations
                | mDrawableContainerState.mChildrenChangingConfigurations);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1112616689 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1112616689;
        // ---------- Original Method ----------
        //return super.getChangingConfigurations()
                //| mDrawableContainerState.mChangingConfigurations
                //| mDrawableContainerState.mChildrenChangingConfigurations;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.908 -0400", hash_original_method = "8B17DDF51BCD655A61A83DE84247EF99", hash_generated_method = "D82CB52E75290A1AE56A51EFFDFC698E")
    @Override
    public boolean getPadding(Rect padding) {
        Rect r;
        r = mDrawableContainerState.getConstantPadding();
        {
            padding.set(r);
        } //End block
        {
            boolean var9D17F75DD17A1079B3E7BB26332DA382_1517647702 = (mCurrDrawable.getPadding(padding));
        } //End block
        {
            boolean var26681595319194856AEB3747307B6E08_1775896624 = (super.getPadding(padding));
        } //End block
        addTaint(padding.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2116439387 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2116439387;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.915 -0400", hash_original_method = "33F48EB62D0DC564AE5544FE28781DA5", hash_generated_method = "DFEEACD8D90C281096E76DEDB5145E03")
    @Override
    public void setAlpha(int alpha) {
        {
            mAlpha = alpha;
            {
                {
                    mCurrDrawable.setAlpha(alpha);
                } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.930 -0400", hash_original_method = "9C07B593875E6134F95EF1337402CCE4", hash_generated_method = "C4810DE924EA062E5BE16527990391D2")
    @Override
    public void setDither(boolean dither) {
        {
            mDrawableContainerState.mDither = dither;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.938 -0400", hash_original_method = "AE256967E0AC09F2540019B105CEB308", hash_generated_method = "B5D4110B90A635D888D13ED6952D19CF")
    @Override
    public void setColorFilter(ColorFilter cf) {
        {
            mColorFilter = cf;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.939 -0400", hash_original_method = "7519B8FEB07821EB54C84C24ACFADDFA", hash_generated_method = "178B1F3F50B4632FA54670FF64888C5C")
    public void setEnterFadeDuration(int ms) {
        mDrawableContainerState.mEnterFadeDuration = ms;
        // ---------- Original Method ----------
        //mDrawableContainerState.mEnterFadeDuration = ms;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.939 -0400", hash_original_method = "037AE4EFE359E0A64F3D29E228D5C257", hash_generated_method = "BC4F4832E0DF7B103CB719B318AB9698")
    public void setExitFadeDuration(int ms) {
        mDrawableContainerState.mExitFadeDuration = ms;
        // ---------- Original Method ----------
        //mDrawableContainerState.mExitFadeDuration = ms;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.940 -0400", hash_original_method = "6D25AB5CD33FA39A7528151D77324281", hash_generated_method = "AB6518B50353017CCC67182BC014DBC2")
    @Override
    protected void onBoundsChange(Rect bounds) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            mLastDrawable.setBounds(bounds);
        } //End block
        {
            mCurrDrawable.setBounds(bounds);
        } //End block
        addTaint(bounds.getTaint());
        // ---------- Original Method ----------
        //if (mLastDrawable != null) {
            //mLastDrawable.setBounds(bounds);
        //}
        //if (mCurrDrawable != null) {
            //mCurrDrawable.setBounds(bounds);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.940 -0400", hash_original_method = "C66859AD1DDD72E10B118943143E6E81", hash_generated_method = "A72D64CF6A8F2EB88DFEE4D99730523D")
    @Override
    public boolean isStateful() {
        boolean varA0DBABDA86F80BDA76204D706B1453DD_962587147 = (mDrawableContainerState.isStateful());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1944646284 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1944646284;
        // ---------- Original Method ----------
        //return mDrawableContainerState.isStateful();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.966 -0400", hash_original_method = "27D546A1CE7DA293AA4ECB359818692F", hash_generated_method = "C1C3AF55ED9A50D180BE0D672AA71052")
    @Override
    public void jumpToCurrentState() {
        boolean changed;
        changed = false;
        {
            mLastDrawable.jumpToCurrentState();
            mLastDrawable = null;
            changed = true;
        } //End block
        {
            mCurrDrawable.jumpToCurrentState();
            mCurrDrawable.setAlpha(mAlpha);
        } //End block
        {
            mExitAnimationEnd = 0;
            changed = true;
        } //End block
        {
            mEnterAnimationEnd = 0;
            changed = true;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.981 -0400", hash_original_method = "19BC6D466BAAC5E8F9FD1F6AF6038AC5", hash_generated_method = "5D2E2E8CEDF621FFE6264C5771DF3F57")
    @Override
    protected boolean onStateChange(int[] state) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean var7D9D27628859DC760669C5E95CEC9347_1823863815 = (mLastDrawable.setState(state));
        } //End block
        {
            boolean var34BF092C138BEF3A5446BB229E4C4465_298019496 = (mCurrDrawable.setState(state));
        } //End block
        addTaint(state[0]);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1703363912 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1703363912;
        // ---------- Original Method ----------
        //if (mLastDrawable != null) {
            //return mLastDrawable.setState(state);
        //}
        //if (mCurrDrawable != null) {
            //return mCurrDrawable.setState(state);
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.982 -0400", hash_original_method = "370D8F089D3CBC7A83FFF71A722725DE", hash_generated_method = "BCBA671E185A4AE68C51A4A8D757499C")
    @Override
    protected boolean onLevelChange(int level) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean var805174EC0CB8E349AD8B0CFED368D4ED_392991672 = (mLastDrawable.setLevel(level));
        } //End block
        {
            boolean var9F2927B783DF9D88F186D5048323875C_1554231905 = (mCurrDrawable.setLevel(level));
        } //End block
        addTaint(level);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_795035813 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_795035813;
        // ---------- Original Method ----------
        //if (mLastDrawable != null) {
            //return mLastDrawable.setLevel(level);
        //}
        //if (mCurrDrawable != null) {
            //return mCurrDrawable.setLevel(level);
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.990 -0400", hash_original_method = "DE0AA10FF6502448C6D350B4086CE53A", hash_generated_method = "3A27C452D8405ADC3FB4F530EBF0B021")
    @Override
    public int getIntrinsicWidth() {
        {
            boolean var0B340EAF1309515EAF1CC7DA3839F9FB_757969387 = (mDrawableContainerState.isConstantSize());
            {
                int var0F0058AD5FC72A5A68BC291FFE8E2602_637427611 = (mDrawableContainerState.getConstantWidth());
            } //End block
        } //End collapsed parenthetic
        {
            Object var804AA1F51D4684C6DA855574F2183237_237422492 = (mCurrDrawable.getIntrinsicWidth());
        } //End flattened ternary
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_554130175 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_554130175;
        // ---------- Original Method ----------
        //if (mDrawableContainerState.isConstantSize()) {
            //return mDrawableContainerState.getConstantWidth();
        //}
        //return mCurrDrawable != null ? mCurrDrawable.getIntrinsicWidth() : -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.991 -0400", hash_original_method = "FA2E61AFB9D6236C0B64D53932A9175C", hash_generated_method = "CB787C668F45AC2B4A9292A6BE4439E1")
    @Override
    public int getIntrinsicHeight() {
        {
            boolean var0B340EAF1309515EAF1CC7DA3839F9FB_1215266504 = (mDrawableContainerState.isConstantSize());
            {
                int var7D93BD4EA71DF412B81C3919D19F8E98_1279307441 = (mDrawableContainerState.getConstantHeight());
            } //End block
        } //End collapsed parenthetic
        {
            Object var2AC8A5422442A65DE13D9D7D1E47A33C_4347246 = (mCurrDrawable.getIntrinsicHeight());
        } //End flattened ternary
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_192930692 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_192930692;
        // ---------- Original Method ----------
        //if (mDrawableContainerState.isConstantSize()) {
            //return mDrawableContainerState.getConstantHeight();
        //}
        //return mCurrDrawable != null ? mCurrDrawable.getIntrinsicHeight() : -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.992 -0400", hash_original_method = "758162C9EFC5A9F0A72A174E63E68436", hash_generated_method = "5A4EC5124D110BD1F256004C8FFCC320")
    @Override
    public int getMinimumWidth() {
        {
            boolean var0B340EAF1309515EAF1CC7DA3839F9FB_1977383220 = (mDrawableContainerState.isConstantSize());
            {
                int var794C9156EA4DDD9998CC96EDE4443CB4_1319517231 = (mDrawableContainerState.getConstantMinimumWidth());
            } //End block
        } //End collapsed parenthetic
        {
            Object var24E11FA644681FD383649322A0C3A058_1606388822 = (mCurrDrawable.getMinimumWidth());
        } //End flattened ternary
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_625050076 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_625050076;
        // ---------- Original Method ----------
        //if (mDrawableContainerState.isConstantSize()) {
            //return mDrawableContainerState.getConstantMinimumWidth();
        //}
        //return mCurrDrawable != null ? mCurrDrawable.getMinimumWidth() : 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:13.996 -0400", hash_original_method = "4272F469B4A869660F9BDAF1177E3127", hash_generated_method = "4ECF068E77F08592A4A357282A39BE85")
    @Override
    public int getMinimumHeight() {
        {
            boolean var0B340EAF1309515EAF1CC7DA3839F9FB_61880534 = (mDrawableContainerState.isConstantSize());
            {
                int varCA7D9B9EAB1185685A20A079B1E1CCCF_141310326 = (mDrawableContainerState.getConstantMinimumHeight());
            } //End block
        } //End collapsed parenthetic
        {
            Object var8E08C5272C558A8669F131FA4FB6EE24_458055694 = (mCurrDrawable.getMinimumHeight());
        } //End flattened ternary
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1803176315 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1803176315;
        // ---------- Original Method ----------
        //if (mDrawableContainerState.isConstantSize()) {
            //return mDrawableContainerState.getConstantMinimumHeight();
        //}
        //return mCurrDrawable != null ? mCurrDrawable.getMinimumHeight() : 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.015 -0400", hash_original_method = "4797F0F1C7EC2DAE5A1D44FF8AA06A3E", hash_generated_method = "15E52CE497CC0A06855107598E4D0487")
    public void invalidateDrawable(Drawable who) {
        {
            boolean var7C6FCB42D88C4A46B669C493EC47FC13_849014025 = (who == mCurrDrawable && getCallback() != null);
            {
                getCallback().invalidateDrawable(this);
            } //End block
        } //End collapsed parenthetic
        addTaint(who.getTaint());
        // ---------- Original Method ----------
        //if (who == mCurrDrawable && getCallback() != null) {
            //getCallback().invalidateDrawable(this);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.016 -0400", hash_original_method = "D79EA559DF51F16BABDD5FAB2B1074A7", hash_generated_method = "1C50E54B94736EAFBA9ADC2F87174273")
    public void scheduleDrawable(Drawable who, Runnable what, long when) {
        {
            boolean var7C6FCB42D88C4A46B669C493EC47FC13_1433747144 = (who == mCurrDrawable && getCallback() != null);
            {
                getCallback().scheduleDrawable(this, what, when);
            } //End block
        } //End collapsed parenthetic
        addTaint(who.getTaint());
        addTaint(what.getTaint());
        addTaint(when);
        // ---------- Original Method ----------
        //if (who == mCurrDrawable && getCallback() != null) {
            //getCallback().scheduleDrawable(this, what, when);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.017 -0400", hash_original_method = "BF197FFA306784FCC1A1C762AD43B7D1", hash_generated_method = "EFAA15FFB67CD5761E885D477AF6E52B")
    public void unscheduleDrawable(Drawable who, Runnable what) {
        {
            boolean var7C6FCB42D88C4A46B669C493EC47FC13_474329561 = (who == mCurrDrawable && getCallback() != null);
            {
                getCallback().unscheduleDrawable(this, what);
            } //End block
        } //End collapsed parenthetic
        addTaint(who.getTaint());
        addTaint(what.getTaint());
        // ---------- Original Method ----------
        //if (who == mCurrDrawable && getCallback() != null) {
            //getCallback().unscheduleDrawable(this, what);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.021 -0400", hash_original_method = "29A0A86F8B666C86609CA80FF461C32C", hash_generated_method = "5406B6D3526A25CDCF4FF516FD534F47")
    @Override
    public boolean setVisible(boolean visible, boolean restart) {
        boolean changed;
        changed = super.setVisible(visible, restart);
        {
            mLastDrawable.setVisible(visible, restart);
        } //End block
        {
            mCurrDrawable.setVisible(visible, restart);
        } //End block
        addTaint(visible);
        addTaint(restart);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2077606092 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2077606092;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.036 -0400", hash_original_method = "1234F5DF929258DFDBB23F3D48CB2B3B", hash_generated_method = "A12383C95C8B2B9186C9ED0D9FE1BD40")
    @Override
    public int getOpacity() {
        {
            boolean var43C2AE0F0A427F69D13410F1C256ECD1_531945929 = (mCurrDrawable == null || !mCurrDrawable.isVisible());
            Object varA261B893D3519856DD56BE7D2273C99F_877152127 = (mDrawableContainerState.getOpacity());
        } //End flattened ternary
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1646936104 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1646936104;
        // ---------- Original Method ----------
        //return mCurrDrawable == null || !mCurrDrawable.isVisible() ? PixelFormat.TRANSPARENT :
                //mDrawableContainerState.getOpacity();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.066 -0400", hash_original_method = "DF0D8C256AB252B9122AE282C5336A53", hash_generated_method = "570320D22D227C8FA750105161DD6ABB")
    public boolean selectDrawable(int idx) {
        long now;
        now = SystemClock.uptimeMillis();
        android.util.Log.i(TAG, toString() + " from " + mCurIndex + " to " + idx
                + ": exit=" + mDrawableContainerState.mExitFadeDuration
                + " enter=" + mDrawableContainerState.mEnterFadeDuration);
        {
            {
                mLastDrawable.setVisible(false, false);
            } //End block
            {
                mLastDrawable = mCurrDrawable;
                mExitAnimationEnd = now + mDrawableContainerState.mExitFadeDuration;
            } //End block
            {
                mLastDrawable = null;
                mExitAnimationEnd = 0;
            } //End block
        } //End block
        {
            mCurrDrawable.setVisible(false, false);
        } //End block
        {
            Drawable d;
            d = mDrawableContainerState.mDrawables[idx];
            mCurrDrawable = d;
            mCurIndex = idx;
            {
                {
                    mEnterAnimationEnd = now + mDrawableContainerState.mEnterFadeDuration;
                } //End block
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
        {
            mCurrDrawable = null;
            mCurIndex = -1;
        } //End block
        {
            {
                mAnimationRunnable = new Runnable() {                    
                    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.065 -0400", hash_original_method = "FF47FBE8389551C190770D50719F0AEF", hash_generated_method = "494EBE0F0E6AEB2E1F7413236FFA416A")
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
            {
                unscheduleSelf(mAnimationRunnable);
            } //End block
            animate(true);
        } //End block
        invalidateSelf();
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1361256794 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1361256794;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.080 -0400", hash_original_method = "10A80C718FDF3E5D6299035E54551605", hash_generated_method = "41FC1CB857A5032E63F97D0A26468F9E")
     void animate(boolean schedule) {
        long now;
        now = SystemClock.uptimeMillis();
        boolean animating;
        animating = false;
        {
            {
                {
                    mCurrDrawable.setAlpha(mAlpha);
                    mEnterAnimationEnd = 0;
                } //End block
                {
                    int animAlpha;
                    animAlpha = (int)((mEnterAnimationEnd-now)*255)
                            / mDrawableContainerState.mEnterFadeDuration;
                    android.util.Log.i(TAG, toString() + " cur alpha " + animAlpha);
                    mCurrDrawable.setAlpha(((255-animAlpha)*mAlpha)/255);
                    animating = true;
                } //End block
            } //End block
        } //End block
        {
            mEnterAnimationEnd = 0;
        } //End block
        {
            {
                {
                    mLastDrawable.setVisible(false, false);
                    mLastDrawable = null;
                    mExitAnimationEnd = 0;
                } //End block
                {
                    int animAlpha;
                    animAlpha = (int)((mExitAnimationEnd-now)*255)
                            / mDrawableContainerState.mExitFadeDuration;
                    android.util.Log.i(TAG, toString() + " last alpha " + animAlpha);
                    mLastDrawable.setAlpha((animAlpha*mAlpha)/255);
                    animating = true;
                } //End block
            } //End block
        } //End block
        {
            mExitAnimationEnd = 0;
        } //End block
        {
            scheduleSelf(mAnimationRunnable, now + 1000/60);
        } //End block
        addTaint(schedule);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.099 -0400", hash_original_method = "2271215EA07D061295E4A17A597D4C85", hash_generated_method = "7C15D4C79BE76B8A3DAABAE84AFF5C27")
    @Override
    public Drawable getCurrent() {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_818089577 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_818089577 = mCurrDrawable;
        varB4EAC82CA7396A68D541C85D26508E83_818089577.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_818089577;
        // ---------- Original Method ----------
        //return mCurrDrawable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.100 -0400", hash_original_method = "7CCE0C3F432CC06D16574FAD35E80869", hash_generated_method = "53EF0285CF6AB83FCA7716D82A4C0541")
    @Override
    public ConstantState getConstantState() {
        ConstantState varB4EAC82CA7396A68D541C85D26508E83_956180338 = null; //Variable for return #1
        ConstantState varB4EAC82CA7396A68D541C85D26508E83_1131930100 = null; //Variable for return #2
        {
            boolean varCF83176F78BEA6477EA3D34B3F17AD89_1020440162 = (mDrawableContainerState.canConstantState());
            {
                mDrawableContainerState.mChangingConfigurations = getChangingConfigurations();
                varB4EAC82CA7396A68D541C85D26508E83_956180338 = mDrawableContainerState;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1131930100 = null;
        ConstantState varA7E53CE21691AB073D9660D615818899_718372414; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_718372414 = varB4EAC82CA7396A68D541C85D26508E83_956180338;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_718372414 = varB4EAC82CA7396A68D541C85D26508E83_1131930100;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_718372414.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_718372414;
        // ---------- Original Method ----------
        //if (mDrawableContainerState.canConstantState()) {
            //mDrawableContainerState.mChangingConfigurations = getChangingConfigurations();
            //return mDrawableContainerState;
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.116 -0400", hash_original_method = "9CED290C930F72A121B65658EE47F79B", hash_generated_method = "505D0DFEF1ED3CA5281A170A8E0CD392")
    @Override
    public Drawable mutate() {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_17484003 = null; //Variable for return #1
        {
            boolean varC94B19053599294E7944C8C841976773_1442364450 = (!mMutated && super.mutate() == this);
            {
                int N;
                N = mDrawableContainerState.getChildCount();
                Drawable[] drawables;
                drawables = mDrawableContainerState.getChildren();
                {
                    int i;
                    i = 0;
                    {
                        drawables[i].mutate();
                    } //End block
                } //End collapsed parenthetic
                mMutated = true;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_17484003 = this;
        varB4EAC82CA7396A68D541C85D26508E83_17484003.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_17484003;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.117 -0400", hash_original_method = "8007C958EC09F138BD431BCAF111D646", hash_generated_method = "C420DDEC89C73B6C63F887832E2D9CA4")
    protected void setConstantState(DrawableContainerState state) {
        mDrawableContainerState = state;
        // ---------- Original Method ----------
        //mDrawableContainerState = state;
    }

    
    public abstract static class DrawableContainerState extends ConstantState {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.118 -0400", hash_original_field = "4AA3D5C224CE197897B9C6F17BF367CD", hash_generated_field = "69A4D31099BD07B55F0FC0556B45F074")

        DrawableContainer mOwner;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.118 -0400", hash_original_field = "276E0645C4E2084773D0EB8C5576428C", hash_generated_field = "9BFAF00848476277D36D9BA586984BA7")

        int mChangingConfigurations;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.118 -0400", hash_original_field = "8755A6790E0FAEFCC765046FF423478D", hash_generated_field = "E8F7332658D4B8911B8427F9E33AC9BD")

        int mChildrenChangingConfigurations;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.118 -0400", hash_original_field = "1891CBC78C734C6A7EBB0D921FFE84B0", hash_generated_field = "B3C5F926BAE6E9ED929417A165A9782D")

        Drawable[] mDrawables;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.118 -0400", hash_original_field = "B2A189B31612476BCCDDB62DFD55B139", hash_generated_field = "77E2F294FC2676328BFD127FCF506329")

        int mNumChildren;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.118 -0400", hash_original_field = "0C8A0F55137EA7C9D079883411C6F93F", hash_generated_field = "A174A0353A9684103C90D7CCC8701C2F")

        boolean mVariablePadding = false;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.118 -0400", hash_original_field = "C9952AF9D9005BC34C04F1E2CB4C3C47", hash_generated_field = "C4240083AE1C6AD18CF7413499D117A4")

        Rect mConstantPadding = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.118 -0400", hash_original_field = "5265BDCA75A610EFF809E61F883963F5", hash_generated_field = "6BFEC2D16A3F7C5C15697878B6EF3BBE")

        boolean mConstantSize = false;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.119 -0400", hash_original_field = "1F301A7547BD825E77BA27AAD0924AB6", hash_generated_field = "430C60111FB869A696B5B5437CADEC6A")

        boolean mComputedConstantSize = false;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.119 -0400", hash_original_field = "C3657F4EC6FDE8A4C5B25696644DA1FB", hash_generated_field = "4D42859CADFABA2E50BE968727F544D7")

        int mConstantWidth;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.119 -0400", hash_original_field = "D30B88E9D07E45516A5C783A50766F03", hash_generated_field = "B4AC32864D468EB70183C5472B0F9A3B")

        int mConstantHeight;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.119 -0400", hash_original_field = "73F34719DB2AE87BFF64DD04BBD99771", hash_generated_field = "65FF036F9AF5D3B1235D68E5F33E8546")

        int mConstantMinimumWidth;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.119 -0400", hash_original_field = "AB34B1FB48C56A86337A52EBD12BA9E1", hash_generated_field = "15038681586DC6317E5E8BDA3C11F3B1")

        int mConstantMinimumHeight;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.119 -0400", hash_original_field = "B8FE7B1D7EF53BE4167C040A5FEB7CC7", hash_generated_field = "0E129F2B3EAED33E8435CEB0AF66A927")

        boolean mHaveOpacity = false;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.119 -0400", hash_original_field = "9D334A125EE4B3831821AB1264C029B9", hash_generated_field = "F94EB6B55A1DFE34A922350D13706418")

        int mOpacity;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.119 -0400", hash_original_field = "0AB968E9E6651BF0E687DAF7846B214C", hash_generated_field = "788B667F97461387E15CDD9C2D78DA89")

        boolean mHaveStateful = false;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.120 -0400", hash_original_field = "1819E5C118FDB6B2BF917A4481AE2A7A", hash_generated_field = "6CBAA9F8E31FD09725242CB8EF367A38")

        boolean mStateful;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.120 -0400", hash_original_field = "2E319D4D352B34E33CF19129B7212FC6", hash_generated_field = "04605894B57F7B3414AF620BF4AC040E")

        boolean mCheckedConstantState;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.120 -0400", hash_original_field = "7C8FD9809F31C20B8422D623B0EC0C4F", hash_generated_field = "09212A3A30B7E6D48DEECC4F4639CCBC")

        boolean mCanConstantState;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.120 -0400", hash_original_field = "C325585054D3982E395745F18CBCD0A6", hash_generated_field = "F1842B9E642BB7380414BD0D8EACA9C1")

        boolean mPaddingChecked = false;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.120 -0400", hash_original_field = "66DCB50C0F72DE519AF3706206BAB5B4", hash_generated_field = "ADD3447A81FDA5C4E55789938CB01CA9")

        boolean mDither = DEFAULT_DITHER;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.120 -0400", hash_original_field = "7EF73DB740A09C72072F895C234DF078", hash_generated_field = "3A008F34A7ED7348F09E0D7AC5FD8046")

        int mEnterFadeDuration;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.120 -0400", hash_original_field = "35F39F9E1FFCE54C39871C49C674BB21", hash_generated_field = "72291FB3AAE88AF4CCFC28A4C19C4F0A")

        int mExitFadeDuration;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.163 -0400", hash_original_method = "BB71D442E5298FC9607AB33C7CE8B85B", hash_generated_method = "4D404A5CB0D5B9EF11C7ABF7D9C8E834")
          DrawableContainerState(DrawableContainerState orig, DrawableContainer owner,
                Resources res) {
            mOwner = owner;
            {
                mChangingConfigurations = orig.mChangingConfigurations;
                mChildrenChangingConfigurations = orig.mChildrenChangingConfigurations;
                Drawable[] origDr;
                origDr = orig.mDrawables;
                mDrawables = new Drawable[origDr.length];
                mNumChildren = orig.mNumChildren;
                int N;
                N = mNumChildren;
                {
                    int i;
                    i = 0;
                    {
                        {
                            mDrawables[i] = origDr[i].getConstantState().newDrawable(res);
                        } //End block
                        {
                            mDrawables[i] = origDr[i].getConstantState().newDrawable();
                        } //End block
                        mDrawables[i].setCallback(owner);
                    } //End block
                } //End collapsed parenthetic
                mCheckedConstantState = mCanConstantState = true;
                mVariablePadding = orig.mVariablePadding;
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
            {
                mDrawables = new Drawable[10];
                mNumChildren = 0;
                mCheckedConstantState = mCanConstantState = false;
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.175 -0400", hash_original_method = "9E7D7C67EAC365FF19BD4971762612A5", hash_generated_method = "FDF85147B39C32F8B34CAC4FAC7AC019")
        @Override
        public int getChangingConfigurations() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_266727979 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_266727979;
            // ---------- Original Method ----------
            //return mChangingConfigurations;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.177 -0400", hash_original_method = "1DF96DB91DC15ED3AA2CD90CE63D5DEA", hash_generated_method = "A18252C2127EC589C15B1772D156B689")
        public final int addChild(Drawable dr) {
            int pos;
            pos = mNumChildren;
            {
                growArray(pos, pos+10);
            } //End block
            dr.setVisible(false, true);
            dr.setCallback(mOwner);
            mDrawables[pos] = dr;
            mChildrenChangingConfigurations |= dr.getChangingConfigurations();
            mHaveOpacity = false;
            mHaveStateful = false;
            mConstantPadding = null;
            mPaddingChecked = false;
            mComputedConstantSize = false;
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_315290082 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_315290082;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.180 -0400", hash_original_method = "58D23B7CD1BBD3B06877382B700017CE", hash_generated_method = "6D203A866327C668E037A62DF093C452")
        public final int getChildCount() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1610232452 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1610232452;
            // ---------- Original Method ----------
            //return mNumChildren;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.202 -0400", hash_original_method = "F5C2CB0FAF6BF41EBD2EF1D322F89AD5", hash_generated_method = "24F49D1AACEB4A492FFE4F6CDC64E867")
        public final Drawable[] getChildren() {
            Drawable[] varB4EAC82CA7396A68D541C85D26508E83_1323058807 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1323058807 = mDrawables;
            varB4EAC82CA7396A68D541C85D26508E83_1323058807.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1323058807;
            // ---------- Original Method ----------
            //return mDrawables;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.203 -0400", hash_original_method = "291079EAD380D117FACCF8E598F58B57", hash_generated_method = "9E63340C83EEEB40E3F74E85F49DB546")
        public final void setVariablePadding(boolean variable) {
            mVariablePadding = variable;
            // ---------- Original Method ----------
            //mVariablePadding = variable;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.209 -0400", hash_original_method = "F49D2F39EC6FEC96BF9263C8B9281632", hash_generated_method = "D5DB6FB615E4BAAE12F5BB1BC7FEB938")
        public final Rect getConstantPadding() {
            Rect varB4EAC82CA7396A68D541C85D26508E83_2001597820 = null; //Variable for return #1
            Rect varB4EAC82CA7396A68D541C85D26508E83_435565357 = null; //Variable for return #2
            Rect varB4EAC82CA7396A68D541C85D26508E83_1904087768 = null; //Variable for return #3
            {
                varB4EAC82CA7396A68D541C85D26508E83_2001597820 = null;
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_435565357 = mConstantPadding;
            } //End block
            Rect r;
            r = null;
            Rect t;
            t = new Rect();
            int N;
            N = getChildCount();
            Drawable[] drawables;
            drawables = mDrawables;
            {
                int i;
                i = 0;
                {
                    {
                        boolean var76D1F57601B94A402DBCF57DF7D5D77A_299561846 = (drawables[i].getPadding(t));
                        {
                            r = new Rect(0, 0, 0, 0);
                            r.left = t.left;
                            r.top = t.top;
                            r.right = t.right;
                            r.bottom = t.bottom;
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            mPaddingChecked = true;
            varB4EAC82CA7396A68D541C85D26508E83_1904087768 = (mConstantPadding = r);
            Rect varA7E53CE21691AB073D9660D615818899_1590465099; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_1590465099 = varB4EAC82CA7396A68D541C85D26508E83_2001597820;
                    break;
                case 2: //Assign result for return ordinal #2
                    varA7E53CE21691AB073D9660D615818899_1590465099 = varB4EAC82CA7396A68D541C85D26508E83_435565357;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1590465099 = varB4EAC82CA7396A68D541C85D26508E83_1904087768;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1590465099.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_1590465099;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.215 -0400", hash_original_method = "1BEAC422BABD76426588E9F434C2D5CD", hash_generated_method = "0B85399E5ECA2518EC987CAE64EFA9F0")
        public final void setConstantSize(boolean constant) {
            mConstantSize = constant;
            // ---------- Original Method ----------
            //mConstantSize = constant;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.231 -0400", hash_original_method = "23D6FDB773CAAECCFEA4282EEDA0FF8B", hash_generated_method = "B882291F84B6B6C5502716B09724323F")
        public final boolean isConstantSize() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1704227116 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1704227116;
            // ---------- Original Method ----------
            //return mConstantSize;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.242 -0400", hash_original_method = "AEDD9F8F931AA0310C6AB599B9490E0C", hash_generated_method = "26D9CFAAD9235625E4054D2F3181F35B")
        public final int getConstantWidth() {
            {
                computeConstantSize();
            } //End block
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1102482976 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1102482976;
            // ---------- Original Method ----------
            //if (!mComputedConstantSize) {
                //computeConstantSize();
            //}
            //return mConstantWidth;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.243 -0400", hash_original_method = "A117A0F50DACA3E076E36F6E0FD5A697", hash_generated_method = "ABAB568678F8511D5E5C4C97497FCE1A")
        public final int getConstantHeight() {
            {
                computeConstantSize();
            } //End block
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_75106899 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_75106899;
            // ---------- Original Method ----------
            //if (!mComputedConstantSize) {
                //computeConstantSize();
            //}
            //return mConstantHeight;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.244 -0400", hash_original_method = "DA23CD9C0D969BCBC5A31F19CEBA2FA0", hash_generated_method = "72CA4A61DCA49BD15F1E4BA793A80CA0")
        public final int getConstantMinimumWidth() {
            {
                computeConstantSize();
            } //End block
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_140922055 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_140922055;
            // ---------- Original Method ----------
            //if (!mComputedConstantSize) {
                //computeConstantSize();
            //}
            //return mConstantMinimumWidth;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.244 -0400", hash_original_method = "9AAB9DC0F579B2E57159CF0852B151D2", hash_generated_method = "701C0E00791867E7448DF3F606D2A930")
        public final int getConstantMinimumHeight() {
            {
                computeConstantSize();
            } //End block
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1485494428 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1485494428;
            // ---------- Original Method ----------
            //if (!mComputedConstantSize) {
                //computeConstantSize();
            //}
            //return mConstantMinimumHeight;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.246 -0400", hash_original_method = "113DB032EAC82FBADFFAA0B97D39A18D", hash_generated_method = "4E9D16522B3A471A3276D7A639ACC20B")
        protected void computeConstantSize() {
            mComputedConstantSize = true;
            int N;
            N = getChildCount();
            Drawable[] drawables;
            drawables = mDrawables;
            mConstantWidth = mConstantHeight = -1;
            mConstantMinimumWidth = mConstantMinimumHeight = 0;
            {
                int i;
                i = 0;
                {
                    Drawable dr;
                    dr = drawables[i];
                    int s;
                    s = dr.getIntrinsicWidth();
                    mConstantWidth = s;
                    s = dr.getIntrinsicHeight();
                    mConstantHeight = s;
                    s = dr.getMinimumWidth();
                    mConstantMinimumWidth = s;
                    s = dr.getMinimumHeight();
                    mConstantMinimumHeight = s;
                } //End block
            } //End collapsed parenthetic
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.247 -0400", hash_original_method = "C7A92F60FC2D3E73CF200C7144A831FD", hash_generated_method = "31EA4832DE115AD3D1ED2D154F4F3A0E")
        public final void setEnterFadeDuration(int duration) {
            mEnterFadeDuration = duration;
            // ---------- Original Method ----------
            //mEnterFadeDuration = duration;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.263 -0400", hash_original_method = "47A305314E1265D4F19BD4B53B739910", hash_generated_method = "325187BCCE7C2ED265D59FF682DE22DB")
        public final int getEnterFadeDuration() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1680676250 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1680676250;
            // ---------- Original Method ----------
            //return mEnterFadeDuration;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.264 -0400", hash_original_method = "1ED7E9EB98364255825D9EFA32269162", hash_generated_method = "93C0A2E6B640F643574AA208A98DA016")
        public final void setExitFadeDuration(int duration) {
            mExitFadeDuration = duration;
            // ---------- Original Method ----------
            //mExitFadeDuration = duration;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.265 -0400", hash_original_method = "8AF957428721C92A0DFF9444CB2E7B41", hash_generated_method = "5E6BFACB06F48E0C097E02C7D3D6A35F")
        public final int getExitFadeDuration() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_93375545 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_93375545;
            // ---------- Original Method ----------
            //return mExitFadeDuration;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.276 -0400", hash_original_method = "C3CEC4829800E9DBA4286BAEED120A24", hash_generated_method = "5A5D05C209D8EB0A0745A5129D86F7EE")
        public final int getOpacity() {
            int N;
            N = getChildCount();
            Drawable[] drawables;
            drawables = mDrawables;
            int op;
            op = drawables[0].getOpacity();
            op = PixelFormat.TRANSPARENT;
            {
                int i;
                i = 1;
                {
                    op = Drawable.resolveOpacity(op, drawables[i].getOpacity());
                } //End block
            } //End collapsed parenthetic
            mOpacity = op;
            mHaveOpacity = true;
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1473330921 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1473330921;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.294 -0400", hash_original_method = "CFE0AE04764A8B8DC9358FA475490068", hash_generated_method = "B92C9EFF4F5926AC44D0931C58862FE6")
        public final boolean isStateful() {
            boolean stateful;
            stateful = false;
            int N;
            N = getChildCount();
            {
                int i;
                i = 0;
                {
                    {
                        boolean varFD66FD269DB3E977FED32CCF0B77624A_1133004774 = (mDrawables[i].isStateful());
                        {
                            stateful = true;
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            mStateful = stateful;
            mHaveStateful = true;
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1213904954 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1213904954;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.298 -0400", hash_original_method = "A9E2F6299A2B0C0DB78600A3C23F092D", hash_generated_method = "0E90CD89603DFCC6FEAF390B753118CD")
        public void growArray(int oldSize, int newSize) {
            Drawable[] newDrawables;
            newDrawables = new Drawable[newSize];
            System.arraycopy(mDrawables, 0, newDrawables, 0, oldSize);
            mDrawables = newDrawables;
            addTaint(oldSize);
            addTaint(newSize);
            // ---------- Original Method ----------
            //Drawable[] newDrawables = new Drawable[newSize];
            //System.arraycopy(mDrawables, 0, newDrawables, 0, oldSize);
            //mDrawables = newDrawables;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.330 -0400", hash_original_method = "F91020706361DEC18BACE4525A4D4C39", hash_generated_method = "67DED6252A65BDD01725E93B4D060B76")
        public synchronized boolean canConstantState() {
            {
                mCanConstantState = true;
                int N;
                N = mNumChildren;
                {
                    int i;
                    i = 0;
                    {
                        {
                            boolean var67C8694F6E7AAF6172CA9B1F09577060_1376539569 = (mDrawables[i].getConstantState() == null);
                            {
                                mCanConstantState = false;
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
                mCheckedConstantState = true;
            } //End block
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1591019947 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1591019947;
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


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.331 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "E83DF1E2E661A92B1AFDA8C473D190B2")

    private static boolean DEBUG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.331 -0400", hash_original_field = "487A87FC99B2160674C40DE470BDF1B0", hash_generated_field = "1A64F699C3B3985C7E1820CEC6C74F07")

    private static String TAG = "DrawableContainer";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:14.331 -0400", hash_original_field = "786AC07A1E16FDB1F134271AA028A7C1", hash_generated_field = "50E8831DF5E0728C9EF4B3F3FEDD2908")

    private static boolean DEFAULT_DITHER = true;
}

