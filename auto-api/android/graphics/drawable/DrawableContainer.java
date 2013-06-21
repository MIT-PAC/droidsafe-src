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
    private DrawableContainerState mDrawableContainerState;
    private Drawable mCurrDrawable;
    private int mAlpha = 0xFF;
    private ColorFilter mColorFilter;
    private int mCurIndex = -1;
    private boolean mMutated;
    private Runnable mAnimationRunnable;
    private long mEnterAnimationEnd;
    private long mExitAnimationEnd;
    private Drawable mLastDrawable;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.164 -0400", hash_original_method = "0681CE3E2519BF1AE8997095921E3C8C", hash_generated_method = "0681CE3E2519BF1AE8997095921E3C8C")
        public DrawableContainer ()
    {
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.164 -0400", hash_original_method = "4C0F5C22B9C7136183C2CC55D1B2C479", hash_generated_method = "2070B46B5E8FA8EA26D220F86445F421")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void draw(Canvas canvas) {
        dsTaint.addTaint(canvas.dsTaint);
        {
            mCurrDrawable.draw(canvas);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.165 -0400", hash_original_method = "91A12202891A2BC9DA6AA80DC6DB676A", hash_generated_method = "6A47E5A919C9549FF1913C28581A7344")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getChangingConfigurations() {
        int varE2A8A6B9AEA0FE1034028098D5421591_1492170175 = (super.getChangingConfigurations()
                | mDrawableContainerState.mChangingConfigurations
                | mDrawableContainerState.mChildrenChangingConfigurations);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return super.getChangingConfigurations()
                //| mDrawableContainerState.mChangingConfigurations
                //| mDrawableContainerState.mChildrenChangingConfigurations;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.165 -0400", hash_original_method = "8B17DDF51BCD655A61A83DE84247EF99", hash_generated_method = "C803590F3F5DB90EF286D36BB52B8A83")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean getPadding(Rect padding) {
        dsTaint.addTaint(padding.dsTaint);
        Rect r;
        r = mDrawableContainerState.getConstantPadding();
        {
            padding.set(r);
        } //End block
        {
            boolean var9D17F75DD17A1079B3E7BB26332DA382_1660170719 = (mCurrDrawable.getPadding(padding));
        } //End block
        {
            boolean var26681595319194856AEB3747307B6E08_849230212 = (super.getPadding(padding));
        } //End block
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.166 -0400", hash_original_method = "33F48EB62D0DC564AE5544FE28781DA5", hash_generated_method = "59AF635833DA107DA22761E0704674C7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setAlpha(int alpha) {
        dsTaint.addTaint(alpha);
        {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.166 -0400", hash_original_method = "9C07B593875E6134F95EF1337402CCE4", hash_generated_method = "025104AA6F2F96844D75DC84ACAA0F99")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setDither(boolean dither) {
        dsTaint.addTaint(dither);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.166 -0400", hash_original_method = "AE256967E0AC09F2540019B105CEB308", hash_generated_method = "52B4CCD4B1C097C002E4B2DD9464A25A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setColorFilter(ColorFilter cf) {
        dsTaint.addTaint(cf.dsTaint);
        {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.173 -0400", hash_original_method = "7519B8FEB07821EB54C84C24ACFADDFA", hash_generated_method = "A573E1D6C1420EE492F33B5BF851476B")
    @DSModeled(DSC.SAFE)
    public void setEnterFadeDuration(int ms) {
        dsTaint.addTaint(ms);
        mDrawableContainerState.mEnterFadeDuration = ms;
        // ---------- Original Method ----------
        //mDrawableContainerState.mEnterFadeDuration = ms;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.174 -0400", hash_original_method = "037AE4EFE359E0A64F3D29E228D5C257", hash_generated_method = "89C3540440C7EA1091B232E70B9920AA")
    @DSModeled(DSC.SAFE)
    public void setExitFadeDuration(int ms) {
        dsTaint.addTaint(ms);
        mDrawableContainerState.mExitFadeDuration = ms;
        // ---------- Original Method ----------
        //mDrawableContainerState.mExitFadeDuration = ms;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.176 -0400", hash_original_method = "6D25AB5CD33FA39A7528151D77324281", hash_generated_method = "65F27BD0A591C47752728E0C096E72B3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onBoundsChange(Rect bounds) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(bounds.dsTaint);
        {
            mLastDrawable.setBounds(bounds);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.177 -0400", hash_original_method = "C66859AD1DDD72E10B118943143E6E81", hash_generated_method = "2DFC9EBC84FB656A954D0D54FEDADB35")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean isStateful() {
        boolean varA0DBABDA86F80BDA76204D706B1453DD_90405072 = (mDrawableContainerState.isStateful());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mDrawableContainerState.isStateful();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.179 -0400", hash_original_method = "27D546A1CE7DA293AA4ECB359818692F", hash_generated_method = "C1C3AF55ED9A50D180BE0D672AA71052")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.180 -0400", hash_original_method = "19BC6D466BAAC5E8F9FD1F6AF6038AC5", hash_generated_method = "769E2A9784A6EC566A03C51BF8AAD5A1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected boolean onStateChange(int[] state) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(state[0]);
        {
            boolean var7D9D27628859DC760669C5E95CEC9347_110442752 = (mLastDrawable.setState(state));
        } //End block
        {
            boolean var34BF092C138BEF3A5446BB229E4C4465_1401757086 = (mCurrDrawable.setState(state));
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mLastDrawable != null) {
            //return mLastDrawable.setState(state);
        //}
        //if (mCurrDrawable != null) {
            //return mCurrDrawable.setState(state);
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.180 -0400", hash_original_method = "370D8F089D3CBC7A83FFF71A722725DE", hash_generated_method = "EFD0114F63B6AAAD0079F31CBEC63EB6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected boolean onLevelChange(int level) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(level);
        {
            boolean var805174EC0CB8E349AD8B0CFED368D4ED_339020824 = (mLastDrawable.setLevel(level));
        } //End block
        {
            boolean var9F2927B783DF9D88F186D5048323875C_849048735 = (mCurrDrawable.setLevel(level));
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mLastDrawable != null) {
            //return mLastDrawable.setLevel(level);
        //}
        //if (mCurrDrawable != null) {
            //return mCurrDrawable.setLevel(level);
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.181 -0400", hash_original_method = "DE0AA10FF6502448C6D350B4086CE53A", hash_generated_method = "7CFE29B560C2B7EF126BCAFEECA20D8A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getIntrinsicWidth() {
        {
            boolean var0B340EAF1309515EAF1CC7DA3839F9FB_135172142 = (mDrawableContainerState.isConstantSize());
            {
                int var0F0058AD5FC72A5A68BC291FFE8E2602_684420414 = (mDrawableContainerState.getConstantWidth());
            } //End block
        } //End collapsed parenthetic
        {
            Object var804AA1F51D4684C6DA855574F2183237_618560136 = (mCurrDrawable.getIntrinsicWidth());
        } //End flattened ternary
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (mDrawableContainerState.isConstantSize()) {
            //return mDrawableContainerState.getConstantWidth();
        //}
        //return mCurrDrawable != null ? mCurrDrawable.getIntrinsicWidth() : -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.181 -0400", hash_original_method = "FA2E61AFB9D6236C0B64D53932A9175C", hash_generated_method = "33377F1DF3445D5F2F19E28C294F753E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getIntrinsicHeight() {
        {
            boolean var0B340EAF1309515EAF1CC7DA3839F9FB_1952229748 = (mDrawableContainerState.isConstantSize());
            {
                int var7D93BD4EA71DF412B81C3919D19F8E98_147742502 = (mDrawableContainerState.getConstantHeight());
            } //End block
        } //End collapsed parenthetic
        {
            Object var2AC8A5422442A65DE13D9D7D1E47A33C_1110386393 = (mCurrDrawable.getIntrinsicHeight());
        } //End flattened ternary
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (mDrawableContainerState.isConstantSize()) {
            //return mDrawableContainerState.getConstantHeight();
        //}
        //return mCurrDrawable != null ? mCurrDrawable.getIntrinsicHeight() : -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.182 -0400", hash_original_method = "758162C9EFC5A9F0A72A174E63E68436", hash_generated_method = "21C247F8F755F11A87102669EC1D4589")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getMinimumWidth() {
        {
            boolean var0B340EAF1309515EAF1CC7DA3839F9FB_108190413 = (mDrawableContainerState.isConstantSize());
            {
                int var794C9156EA4DDD9998CC96EDE4443CB4_1623008006 = (mDrawableContainerState.getConstantMinimumWidth());
            } //End block
        } //End collapsed parenthetic
        {
            Object var24E11FA644681FD383649322A0C3A058_705182739 = (mCurrDrawable.getMinimumWidth());
        } //End flattened ternary
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (mDrawableContainerState.isConstantSize()) {
            //return mDrawableContainerState.getConstantMinimumWidth();
        //}
        //return mCurrDrawable != null ? mCurrDrawable.getMinimumWidth() : 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.182 -0400", hash_original_method = "4272F469B4A869660F9BDAF1177E3127", hash_generated_method = "EB882C1AF9025C20309D1EA22051A865")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getMinimumHeight() {
        {
            boolean var0B340EAF1309515EAF1CC7DA3839F9FB_1919277254 = (mDrawableContainerState.isConstantSize());
            {
                int varCA7D9B9EAB1185685A20A079B1E1CCCF_551114882 = (mDrawableContainerState.getConstantMinimumHeight());
            } //End block
        } //End collapsed parenthetic
        {
            Object var8E08C5272C558A8669F131FA4FB6EE24_101491701 = (mCurrDrawable.getMinimumHeight());
        } //End flattened ternary
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (mDrawableContainerState.isConstantSize()) {
            //return mDrawableContainerState.getConstantMinimumHeight();
        //}
        //return mCurrDrawable != null ? mCurrDrawable.getMinimumHeight() : 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.183 -0400", hash_original_method = "4797F0F1C7EC2DAE5A1D44FF8AA06A3E", hash_generated_method = "4420CD4184E2269E50F16F69B108C0BD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void invalidateDrawable(Drawable who) {
        dsTaint.addTaint(who.dsTaint);
        {
            boolean var7C6FCB42D88C4A46B669C493EC47FC13_781590508 = (who == mCurrDrawable && getCallback() != null);
            {
                getCallback().invalidateDrawable(this);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (who == mCurrDrawable && getCallback() != null) {
            //getCallback().invalidateDrawable(this);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.183 -0400", hash_original_method = "D79EA559DF51F16BABDD5FAB2B1074A7", hash_generated_method = "4A9BF112452DD0ABAD26172A3722AA43")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void scheduleDrawable(Drawable who, Runnable what, long when) {
        dsTaint.addTaint(what.dsTaint);
        dsTaint.addTaint(when);
        dsTaint.addTaint(who.dsTaint);
        {
            boolean var7C6FCB42D88C4A46B669C493EC47FC13_1920513296 = (who == mCurrDrawable && getCallback() != null);
            {
                getCallback().scheduleDrawable(this, what, when);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (who == mCurrDrawable && getCallback() != null) {
            //getCallback().scheduleDrawable(this, what, when);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.183 -0400", hash_original_method = "BF197FFA306784FCC1A1C762AD43B7D1", hash_generated_method = "D3B348F5F8A73A359BC56D79B98E3C18")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unscheduleDrawable(Drawable who, Runnable what) {
        dsTaint.addTaint(what.dsTaint);
        dsTaint.addTaint(who.dsTaint);
        {
            boolean var7C6FCB42D88C4A46B669C493EC47FC13_1825743128 = (who == mCurrDrawable && getCallback() != null);
            {
                getCallback().unscheduleDrawable(this, what);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (who == mCurrDrawable && getCallback() != null) {
            //getCallback().unscheduleDrawable(this, what);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.184 -0400", hash_original_method = "29A0A86F8B666C86609CA80FF461C32C", hash_generated_method = "084F8006D6E8370D4FEB701F51AFFFB4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean setVisible(boolean visible, boolean restart) {
        dsTaint.addTaint(restart);
        dsTaint.addTaint(visible);
        boolean changed;
        changed = super.setVisible(visible, restart);
        {
            mLastDrawable.setVisible(visible, restart);
        } //End block
        {
            mCurrDrawable.setVisible(visible, restart);
        } //End block
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.186 -0400", hash_original_method = "1234F5DF929258DFDBB23F3D48CB2B3B", hash_generated_method = "817E1D2FA5530D5F43C8AF5785F24BFC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getOpacity() {
        {
            boolean var43C2AE0F0A427F69D13410F1C256ECD1_1312111383 = (mCurrDrawable == null || !mCurrDrawable.isVisible());
            Object varA261B893D3519856DD56BE7D2273C99F_577447103 = (mDrawableContainerState.getOpacity());
        } //End flattened ternary
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mCurrDrawable == null || !mCurrDrawable.isVisible() ? PixelFormat.TRANSPARENT :
                //mDrawableContainerState.getOpacity();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.190 -0400", hash_original_method = "DF0D8C256AB252B9122AE282C5336A53", hash_generated_method = "D69A3B44B681E6425AF5D7F6814DC09C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean selectDrawable(int idx) {
        dsTaint.addTaint(idx);
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
                    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.190 -0400", hash_original_method = "FF47FBE8389551C190770D50719F0AEF", hash_generated_method = "494EBE0F0E6AEB2E1F7413236FFA416A")
                    //DSFIXME:  CODE0002: Requires DSC value to be set
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
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.191 -0400", hash_original_method = "10A80C718FDF3E5D6299035E54551605", hash_generated_method = "AD0AF109328BE1B7D2FBB5195AC37D27")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void animate(boolean schedule) {
        dsTaint.addTaint(schedule);
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.192 -0400", hash_original_method = "2271215EA07D061295E4A17A597D4C85", hash_generated_method = "D2BDDF31F34A8511C08753D6C4FB40C6")
    @DSModeled(DSC.SAFE)
    @Override
    public Drawable getCurrent() {
        return (Drawable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mCurrDrawable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.192 -0400", hash_original_method = "7CCE0C3F432CC06D16574FAD35E80869", hash_generated_method = "94D42E6FBAE8EC2023F97E5D8F3803A5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ConstantState getConstantState() {
        {
            boolean varCF83176F78BEA6477EA3D34B3F17AD89_1065219557 = (mDrawableContainerState.canConstantState());
            {
                mDrawableContainerState.mChangingConfigurations = getChangingConfigurations();
            } //End block
        } //End collapsed parenthetic
        return (ConstantState)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mDrawableContainerState.canConstantState()) {
            //mDrawableContainerState.mChangingConfigurations = getChangingConfigurations();
            //return mDrawableContainerState;
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.193 -0400", hash_original_method = "9CED290C930F72A121B65658EE47F79B", hash_generated_method = "CAD3D2790D595B67FA132255FE0570A7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Drawable mutate() {
        {
            boolean varC94B19053599294E7944C8C841976773_1133633342 = (!mMutated && super.mutate() == this);
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
        return (Drawable)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.193 -0400", hash_original_method = "8007C958EC09F138BD431BCAF111D646", hash_generated_method = "F2AB338831C6216A40EEA45E4B837DA9")
    @DSModeled(DSC.SAFE)
    protected void setConstantState(DrawableContainerState state) {
        dsTaint.addTaint(state.dsTaint);
        // ---------- Original Method ----------
        //mDrawableContainerState = state;
    }

    
    public abstract static class DrawableContainerState extends ConstantState {
        DrawableContainer mOwner;
        int         mChangingConfigurations;
        int         mChildrenChangingConfigurations;
        Drawable[]  mDrawables;
        int         mNumChildren;
        boolean     mVariablePadding = false;
        Rect        mConstantPadding = null;
        boolean     mConstantSize = false;
        boolean     mComputedConstantSize = false;
        int         mConstantWidth;
        int         mConstantHeight;
        int         mConstantMinimumWidth;
        int         mConstantMinimumHeight;
        boolean     mHaveOpacity = false;
        int         mOpacity;
        boolean     mHaveStateful = false;
        boolean     mStateful;
        boolean     mCheckedConstantState;
        boolean     mCanConstantState;
        boolean     mPaddingChecked = false;
        boolean     mDither = DEFAULT_DITHER;
        int         mEnterFadeDuration;
        int         mExitFadeDuration;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.194 -0400", hash_original_method = "BB71D442E5298FC9607AB33C7CE8B85B", hash_generated_method = "9C64C993A364D530E9219F7B5F99B6FC")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         DrawableContainerState(DrawableContainerState orig, DrawableContainer owner,
                Resources res) {
            dsTaint.addTaint(res.dsTaint);
            dsTaint.addTaint(owner.dsTaint);
            dsTaint.addTaint(orig.dsTaint);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.194 -0400", hash_original_method = "9E7D7C67EAC365FF19BD4971762612A5", hash_generated_method = "36011B0CFA5B1C48E438EB66BB35159E")
        @DSModeled(DSC.SAFE)
        @Override
        public int getChangingConfigurations() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return mChangingConfigurations;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.195 -0400", hash_original_method = "1DF96DB91DC15ED3AA2CD90CE63D5DEA", hash_generated_method = "D900C600085866D958EDC14A5BDF15DC")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public final int addChild(Drawable dr) {
            dsTaint.addTaint(dr.dsTaint);
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
            return dsTaint.getTaintInt();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.195 -0400", hash_original_method = "58D23B7CD1BBD3B06877382B700017CE", hash_generated_method = "B43DEB5664D68BC65680E50B7DA37F14")
        @DSModeled(DSC.SAFE)
        public final int getChildCount() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return mNumChildren;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.195 -0400", hash_original_method = "F5C2CB0FAF6BF41EBD2EF1D322F89AD5", hash_generated_method = "619B86AC07309185AB29FD20B337E601")
        @DSModeled(DSC.SAFE)
        public final Drawable[] getChildren() {
            return (Drawable[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return mDrawables;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.196 -0400", hash_original_method = "291079EAD380D117FACCF8E598F58B57", hash_generated_method = "683AF778298690FD499316F8C1700C22")
        @DSModeled(DSC.SAFE)
        public final void setVariablePadding(boolean variable) {
            dsTaint.addTaint(variable);
            // ---------- Original Method ----------
            //mVariablePadding = variable;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.196 -0400", hash_original_method = "F49D2F39EC6FEC96BF9263C8B9281632", hash_generated_method = "5D5AB37CD127306FD0A87D600F3495EC")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public final Rect getConstantPadding() {
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
                        boolean var76D1F57601B94A402DBCF57DF7D5D77A_1674339956 = (drawables[i].getPadding(t));
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
            Rect varEF134F58FBD0E455D9D9591B505DF1FE_875785417 = ((mConstantPadding = r));
            return (Rect)dsTaint.getTaint();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.205 -0400", hash_original_method = "1BEAC422BABD76426588E9F434C2D5CD", hash_generated_method = "EECE0873B6A1A0ABFD23145F11692ABE")
        @DSModeled(DSC.SAFE)
        public final void setConstantSize(boolean constant) {
            dsTaint.addTaint(constant);
            // ---------- Original Method ----------
            //mConstantSize = constant;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.206 -0400", hash_original_method = "23D6FDB773CAAECCFEA4282EEDA0FF8B", hash_generated_method = "AC3570EEA2D176C371D644F7A51C58FF")
        @DSModeled(DSC.SAFE)
        public final boolean isConstantSize() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return mConstantSize;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.206 -0400", hash_original_method = "AEDD9F8F931AA0310C6AB599B9490E0C", hash_generated_method = "59598017E03481BCE8DFE535CEEBD2C6")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public final int getConstantWidth() {
            {
                computeConstantSize();
            } //End block
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //if (!mComputedConstantSize) {
                //computeConstantSize();
            //}
            //return mConstantWidth;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.208 -0400", hash_original_method = "A117A0F50DACA3E076E36F6E0FD5A697", hash_generated_method = "62FCD119F4F38F9154BBA658A57944C0")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public final int getConstantHeight() {
            {
                computeConstantSize();
            } //End block
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //if (!mComputedConstantSize) {
                //computeConstantSize();
            //}
            //return mConstantHeight;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.209 -0400", hash_original_method = "DA23CD9C0D969BCBC5A31F19CEBA2FA0", hash_generated_method = "EBA41E63A116CCA94F1C66697B4B13BA")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public final int getConstantMinimumWidth() {
            {
                computeConstantSize();
            } //End block
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //if (!mComputedConstantSize) {
                //computeConstantSize();
            //}
            //return mConstantMinimumWidth;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.209 -0400", hash_original_method = "9AAB9DC0F579B2E57159CF0852B151D2", hash_generated_method = "F60ACD9BBE719BEC309E998E7C42F5E7")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public final int getConstantMinimumHeight() {
            {
                computeConstantSize();
            } //End block
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //if (!mComputedConstantSize) {
                //computeConstantSize();
            //}
            //return mConstantMinimumHeight;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.210 -0400", hash_original_method = "113DB032EAC82FBADFFAA0B97D39A18D", hash_generated_method = "4E9D16522B3A471A3276D7A639ACC20B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.210 -0400", hash_original_method = "C7A92F60FC2D3E73CF200C7144A831FD", hash_generated_method = "F96062059980D88C0C1646883E2CB393")
        @DSModeled(DSC.SAFE)
        public final void setEnterFadeDuration(int duration) {
            dsTaint.addTaint(duration);
            // ---------- Original Method ----------
            //mEnterFadeDuration = duration;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.211 -0400", hash_original_method = "47A305314E1265D4F19BD4B53B739910", hash_generated_method = "ADB92B4C72015F5452BB992973FE0BFA")
        @DSModeled(DSC.SAFE)
        public final int getEnterFadeDuration() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return mEnterFadeDuration;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.213 -0400", hash_original_method = "1ED7E9EB98364255825D9EFA32269162", hash_generated_method = "B549F0581C055B75A138BB9483A29EFB")
        @DSModeled(DSC.SAFE)
        public final void setExitFadeDuration(int duration) {
            dsTaint.addTaint(duration);
            // ---------- Original Method ----------
            //mExitFadeDuration = duration;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.214 -0400", hash_original_method = "8AF957428721C92A0DFF9444CB2E7B41", hash_generated_method = "DDABB6BB611102533AE293B6AAE72751")
        @DSModeled(DSC.SAFE)
        public final int getExitFadeDuration() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return mExitFadeDuration;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.214 -0400", hash_original_method = "C3CEC4829800E9DBA4286BAEED120A24", hash_generated_method = "150E9A3EFB749ED4F8E6A0EA60B116A6")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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
            return dsTaint.getTaintInt();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.215 -0400", hash_original_method = "CFE0AE04764A8B8DC9358FA475490068", hash_generated_method = "7167719CBD2D9AF70AF2FB06E4222618")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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
                        boolean varFD66FD269DB3E977FED32CCF0B77624A_2140029171 = (mDrawables[i].isStateful());
                        {
                            stateful = true;
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            mStateful = stateful;
            mHaveStateful = true;
            return dsTaint.getTaintBoolean();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.215 -0400", hash_original_method = "A9E2F6299A2B0C0DB78600A3C23F092D", hash_generated_method = "C3762264127B724495361E4E313D50D6")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void growArray(int oldSize, int newSize) {
            dsTaint.addTaint(oldSize);
            dsTaint.addTaint(newSize);
            Drawable[] newDrawables;
            newDrawables = new Drawable[newSize];
            System.arraycopy(mDrawables, 0, newDrawables, 0, oldSize);
            mDrawables = newDrawables;
            // ---------- Original Method ----------
            //Drawable[] newDrawables = new Drawable[newSize];
            //System.arraycopy(mDrawables, 0, newDrawables, 0, oldSize);
            //mDrawables = newDrawables;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:48.216 -0400", hash_original_method = "F91020706361DEC18BACE4525A4D4C39", hash_generated_method = "4D02765CFBCE6ECCAD7F23FDC3942E13")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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
                            boolean var67C8694F6E7AAF6172CA9B1F09577060_252681919 = (mDrawables[i].getConstantState() == null);
                            {
                                mCanConstantState = false;
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
                mCheckedConstantState = true;
            } //End block
            return dsTaint.getTaintBoolean();
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


    
    private static final boolean DEBUG = false;
    private static final String TAG = "DrawableContainer";
    private static final boolean DEFAULT_DITHER = true;
}

