package android.graphics.drawable;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.os.SystemClock;

public class DrawableContainer extends Drawable implements Drawable.Callback {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:19.098 -0500", hash_original_field = "81DD852ECBE07BA98A61C8F3D0C85F01", hash_generated_field = "58EDF43BA541A4D47EECFEC3901C7AED")

    private static final boolean DEBUG = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:19.101 -0500", hash_original_field = "3AF6C3D308D5F909E9882F2337B6F098", hash_generated_field = "48C9B565D3BB13F89C4A690FEBD0B203")

    private static final String TAG = "DrawableContainer";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:19.104 -0500", hash_original_field = "338D1FBCBD429EAFEF0B800F32A31DDD", hash_generated_field = "17A3499D3AE1DB6784657D5E8AE3951F")

    private static final boolean DEFAULT_DITHER = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:19.106 -0500", hash_original_field = "7F8878CE726DC26819572F91F26F642B", hash_generated_field = "2DB19AB4F82F5273EE7E6529BBA72AE4")

    private DrawableContainerState mDrawableContainerState;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:19.108 -0500", hash_original_field = "4B4CD60CA8F4FD1BDB011696EEE08C29", hash_generated_field = "45111284A103854181686551CAB9ECE6")

    private Drawable mCurrDrawable;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:19.110 -0500", hash_original_field = "8A6F8C8F01D3E97C17A658DC10C92A1D", hash_generated_field = "3503E015FBD1508491B2F18FDC5DAF9F")

    private int mAlpha = 0xFF;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:19.112 -0500", hash_original_field = "FDF54A2FE886548299B21698A652A06E", hash_generated_field = "5D6D299C9DDEDCCB11EFFA1C147C3DF6")

    private ColorFilter mColorFilter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:19.114 -0500", hash_original_field = "4D798BF78CCD3B8BF49CA55B59BA5F14", hash_generated_field = "68BE4C2261D94A949F760C32A43779D9")

    private int mCurIndex = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:19.116 -0500", hash_original_field = "B15C308E96D0EEBD27CFE369FA349C15", hash_generated_field = "5CA5A1EF3CAA45117BCACBC34EF05952")

    private boolean mMutated;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:19.118 -0500", hash_original_field = "64609EA1BBC65E5D415FE1485B298073", hash_generated_field = "703FCA3A43FE2C0EE6947EDF58A21E0E")

    private Runnable mAnimationRunnable;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:19.120 -0500", hash_original_field = "C8A3BF813F0F656AED261537D284C9BE", hash_generated_field = "4B94C11DAC8E800C8F6926DD6BCC82A8")

    private long mEnterAnimationEnd;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:19.122 -0500", hash_original_field = "D7F81E423E0A2469DB4BACCB27CE42FE", hash_generated_field = "06C911F5C85391F52F5C0A8476C4502F")

    private long mExitAnimationEnd;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:19.124 -0500", hash_original_field = "37477408BC6E2F00DB558844EC4CCF82", hash_generated_field = "6FEFDE257A7DFEFF73429269253AF7F7")

    private Drawable mLastDrawable;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.691 -0400", hash_original_method = "094684F7E86BAEC8B113ECD0EF1A35E3", hash_generated_method = "094684F7E86BAEC8B113ECD0EF1A35E3")
    public DrawableContainer ()
    {
        //Synthesized constructor
    }

    // overrides from Drawable

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:19.127 -0500", hash_original_method = "4C0F5C22B9C7136183C2CC55D1B2C479", hash_generated_method = "1C90F3AD456947B775572223615C57E7")
    
@Override
    public void draw(Canvas canvas) {
        if (mCurrDrawable != null) {
            mCurrDrawable.draw(canvas);
        }
        if (mLastDrawable != null) {
            mLastDrawable.draw(canvas);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:19.129 -0500", hash_original_method = "91A12202891A2BC9DA6AA80DC6DB676A", hash_generated_method = "4566B9A48CC006709F4BC578A29D61F9")
    
@Override
    public int getChangingConfigurations() {
        return super.getChangingConfigurations()
                | mDrawableContainerState.mChangingConfigurations
                | mDrawableContainerState.mChildrenChangingConfigurations;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:19.132 -0500", hash_original_method = "8B17DDF51BCD655A61A83DE84247EF99", hash_generated_method = "D4A671DB24C35813D9B79CE7588372C0")
    
@Override
    public boolean getPadding(Rect padding) {
        final Rect r = mDrawableContainerState.getConstantPadding();
        if (r != null) {
            padding.set(r);
            return true;
        }
        if (mCurrDrawable != null) {
            return mCurrDrawable.getPadding(padding);
        } else {
            return super.getPadding(padding);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:19.134 -0500", hash_original_method = "33F48EB62D0DC564AE5544FE28781DA5", hash_generated_method = "D40D692DA658E707BEA31BCA54538687")
    
@Override
    public void setAlpha(int alpha) {
        if (mAlpha != alpha) {
            mAlpha = alpha;
            if (mCurrDrawable != null) {
                if (mEnterAnimationEnd == 0) {
                    mCurrDrawable.setAlpha(alpha);
                } else {
                    animate(false);
                }
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:19.136 -0500", hash_original_method = "9C07B593875E6134F95EF1337402CCE4", hash_generated_method = "B433834D0462CA271B67070BF862A22D")
    
@Override
    public void setDither(boolean dither) {
        if (mDrawableContainerState.mDither != dither) {
            mDrawableContainerState.mDither = dither;
            if (mCurrDrawable != null) {
                mCurrDrawable.setDither(mDrawableContainerState.mDither);
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:19.138 -0500", hash_original_method = "AE256967E0AC09F2540019B105CEB308", hash_generated_method = "92AA42E7080A1A87B6F1E8DFC66BA44F")
    
@Override
    public void setColorFilter(ColorFilter cf) {
        if (mColorFilter != cf) {
            mColorFilter = cf;
            if (mCurrDrawable != null) {
                mCurrDrawable.setColorFilter(cf);
            }
        }
    }
    
    /**
     * Change the global fade duration when a new drawable is entering
     * the scene.
     * @param ms The amount of time to fade in milliseconds.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:19.140 -0500", hash_original_method = "7519B8FEB07821EB54C84C24ACFADDFA", hash_generated_method = "9B7F04366A8D47F0FC55788A2F7465A8")
    
public void setEnterFadeDuration(int ms) {
        mDrawableContainerState.mEnterFadeDuration = ms;
    }
    
    /**
     * Change the global fade duration when a new drawable is leaving
     * the scene.
     * @param ms The amount of time to fade in milliseconds.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:19.142 -0500", hash_original_method = "037AE4EFE359E0A64F3D29E228D5C257", hash_generated_method = "8B635DD7949824F7AD368E06543E3A6F")
    
public void setExitFadeDuration(int ms) {
        mDrawableContainerState.mExitFadeDuration = ms;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:19.145 -0500", hash_original_method = "6D25AB5CD33FA39A7528151D77324281", hash_generated_method = "8804AE8346C2BB001823FFA5B2F4E7BE")
    
@Override
    protected void onBoundsChange(Rect bounds) {
        if (mLastDrawable != null) {
            mLastDrawable.setBounds(bounds);
        }
        if (mCurrDrawable != null) {
            mCurrDrawable.setBounds(bounds);
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:19.147 -0500", hash_original_method = "C66859AD1DDD72E10B118943143E6E81", hash_generated_method = "516771523E5481D9B03EBF2B0010A539")
    
@Override
    public boolean isStateful() {
        return mDrawableContainerState.isStateful();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:19.150 -0500", hash_original_method = "27D546A1CE7DA293AA4ECB359818692F", hash_generated_method = "49DC0597A85D11F4D97DAB9DB797BC1F")
    
@Override
    public void jumpToCurrentState() {
        boolean changed = false;
        if (mLastDrawable != null) {
            mLastDrawable.jumpToCurrentState();
            mLastDrawable = null;
            changed = true;
        }
        if (mCurrDrawable != null) {
            mCurrDrawable.jumpToCurrentState();
            mCurrDrawable.setAlpha(mAlpha);
        }
        if (mExitAnimationEnd != 0) {
            mExitAnimationEnd = 0;
            changed = true;
        }
        if (mEnterAnimationEnd != 0) {
            mEnterAnimationEnd = 0;
            changed = true;
        }
        if (changed) {
            invalidateSelf();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:19.152 -0500", hash_original_method = "19BC6D466BAAC5E8F9FD1F6AF6038AC5", hash_generated_method = "019321F5B63EC6C3BF4F8F583948C5C0")
    
@Override
    protected boolean onStateChange(int[] state) {
        if (mLastDrawable != null) {
            return mLastDrawable.setState(state);
        }
        if (mCurrDrawable != null) {
            return mCurrDrawable.setState(state);
        }
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:19.156 -0500", hash_original_method = "370D8F089D3CBC7A83FFF71A722725DE", hash_generated_method = "3AD6AE21D988ED732948A03576CB218D")
    
@Override
    protected boolean onLevelChange(int level) {
        if (mLastDrawable != null) {
            return mLastDrawable.setLevel(level);
        }
        if (mCurrDrawable != null) {
            return mCurrDrawable.setLevel(level);
        }
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:19.158 -0500", hash_original_method = "DE0AA10FF6502448C6D350B4086CE53A", hash_generated_method = "B156F18E6F1E5931B390C1C93F008391")
    
@Override
    public int getIntrinsicWidth() {
        if (mDrawableContainerState.isConstantSize()) {
            return mDrawableContainerState.getConstantWidth();
        }
        return mCurrDrawable != null ? mCurrDrawable.getIntrinsicWidth() : -1;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:19.160 -0500", hash_original_method = "FA2E61AFB9D6236C0B64D53932A9175C", hash_generated_method = "4C1235EC697D9AD248FCF617EDC4122E")
    
@Override
    public int getIntrinsicHeight() {
        if (mDrawableContainerState.isConstantSize()) {
            return mDrawableContainerState.getConstantHeight();
        }
        return mCurrDrawable != null ? mCurrDrawable.getIntrinsicHeight() : -1;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:19.162 -0500", hash_original_method = "758162C9EFC5A9F0A72A174E63E68436", hash_generated_method = "2324F511816189E9A57F602972DCFA6C")
    
@Override
    public int getMinimumWidth() {
        if (mDrawableContainerState.isConstantSize()) {
            return mDrawableContainerState.getConstantMinimumWidth();
        }
        return mCurrDrawable != null ? mCurrDrawable.getMinimumWidth() : 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:19.165 -0500", hash_original_method = "4272F469B4A869660F9BDAF1177E3127", hash_generated_method = "947E790C315A4B6E575DBB6F9FBD61C8")
    
@Override
    public int getMinimumHeight() {
        if (mDrawableContainerState.isConstantSize()) {
            return mDrawableContainerState.getConstantMinimumHeight();
        }
        return mCurrDrawable != null ? mCurrDrawable.getMinimumHeight() : 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:19.167 -0500", hash_original_method = "4797F0F1C7EC2DAE5A1D44FF8AA06A3E", hash_generated_method = "92D4064DBAC64D9CB00E5E0C898196BC")
    
public void invalidateDrawable(Drawable who) {
        if (who == mCurrDrawable && getCallback() != null) {
            getCallback().invalidateDrawable(this);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:19.169 -0500", hash_original_method = "D79EA559DF51F16BABDD5FAB2B1074A7", hash_generated_method = "F5D16893C70507810FA4EBCA0B77A697")
    
public void scheduleDrawable(Drawable who, Runnable what, long when) {
        if (who == mCurrDrawable && getCallback() != null) {
            getCallback().scheduleDrawable(this, what, when);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:19.171 -0500", hash_original_method = "BF197FFA306784FCC1A1C762AD43B7D1", hash_generated_method = "B39687A356B96194B2AAFC5591460709")
    
public void unscheduleDrawable(Drawable who, Runnable what) {
        if (who == mCurrDrawable && getCallback() != null) {
            getCallback().unscheduleDrawable(this, what);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:19.173 -0500", hash_original_method = "29A0A86F8B666C86609CA80FF461C32C", hash_generated_method = "F1CE08502485BF393003F5059D093A39")
    
@Override
    public boolean setVisible(boolean visible, boolean restart) {
        boolean changed = super.setVisible(visible, restart);
        if (mLastDrawable != null) {
            mLastDrawable.setVisible(visible, restart);
        }
        if (mCurrDrawable != null) {
            mCurrDrawable.setVisible(visible, restart);
        }
        return changed;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:19.176 -0500", hash_original_method = "1234F5DF929258DFDBB23F3D48CB2B3B", hash_generated_method = "DBAE457F7B48E7BCA3A150147A003E5C")
    
@Override
    public int getOpacity() {
        return mCurrDrawable == null || !mCurrDrawable.isVisible() ? PixelFormat.TRANSPARENT :
                mDrawableContainerState.getOpacity();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:19.182 -0500", hash_original_method = "DF0D8C256AB252B9122AE282C5336A53", hash_generated_method = "0C51E0E6443CBC88008AF05AC5F03EF3")
    
public boolean selectDrawable(int idx) {
        if (idx == mCurIndex) {
            return false;
        }

        final long now = SystemClock.uptimeMillis();

        if (DEBUG) android.util.Log.i(TAG, toString() + " from " + mCurIndex + " to " + idx
                + ": exit=" + mDrawableContainerState.mExitFadeDuration
                + " enter=" + mDrawableContainerState.mEnterFadeDuration);

        if (mDrawableContainerState.mExitFadeDuration > 0) {
            if (mLastDrawable != null) {
                mLastDrawable.setVisible(false, false);
            }
            if (mCurrDrawable != null) {
                mLastDrawable = mCurrDrawable;
                mExitAnimationEnd = now + mDrawableContainerState.mExitFadeDuration;
            } else {
                mLastDrawable = null;
                mExitAnimationEnd = 0;
            }
        } else if (mCurrDrawable != null) {
            mCurrDrawable.setVisible(false, false);
        }

        if (idx >= 0 && idx < mDrawableContainerState.mNumChildren) {
            Drawable d = mDrawableContainerState.mDrawables[idx];
            mCurrDrawable = d;
            mCurIndex = idx;
            if (d != null) {
                if (mDrawableContainerState.mEnterFadeDuration > 0) {
                    mEnterAnimationEnd = now + mDrawableContainerState.mEnterFadeDuration;
                } else {
                    d.setAlpha(mAlpha);
                }
                d.setVisible(isVisible(), true);
                d.setDither(mDrawableContainerState.mDither);
                d.setColorFilter(mColorFilter);
                d.setState(getState());
                d.setLevel(getLevel());
                d.setBounds(getBounds());
            }
        } else {
            mCurrDrawable = null;
            mCurIndex = -1;
        }

        if (mEnterAnimationEnd != 0 || mExitAnimationEnd != 0) {
            if (mAnimationRunnable == null) {
                mAnimationRunnable = new Runnable() {
                    @Override public void run() {
                        animate(true);
                        invalidateSelf();
                    }
                };
            } else {
                unscheduleSelf(mAnimationRunnable);
            }
            // Compute first frame and schedule next animation.
            animate(true);
        }

        invalidateSelf();

        return true;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:19.188 -0500", hash_original_method = "10A80C718FDF3E5D6299035E54551605", hash_generated_method = "10A80C718FDF3E5D6299035E54551605")
    
void animate(boolean schedule) {
        final long now = SystemClock.uptimeMillis();
        boolean animating = false;
        if (mCurrDrawable != null) {
            if (mEnterAnimationEnd != 0) {
                if (mEnterAnimationEnd <= now) {
                    mCurrDrawable.setAlpha(mAlpha);
                    mEnterAnimationEnd = 0;
                } else {
                    int animAlpha = (int)((mEnterAnimationEnd-now)*255)
                            / mDrawableContainerState.mEnterFadeDuration;
                    if (DEBUG) android.util.Log.i(TAG, toString() + " cur alpha " + animAlpha);
                    mCurrDrawable.setAlpha(((255-animAlpha)*mAlpha)/255);
                    animating = true;
                }
            }
        } else {
            mEnterAnimationEnd = 0;
        }
        if (mLastDrawable != null) {
            if (mExitAnimationEnd != 0) {
                if (mExitAnimationEnd <= now) {
                    mLastDrawable.setVisible(false, false);
                    mLastDrawable = null;
                    mExitAnimationEnd = 0;
                } else {
                    int animAlpha = (int)((mExitAnimationEnd-now)*255)
                            / mDrawableContainerState.mExitFadeDuration;
                    if (DEBUG) android.util.Log.i(TAG, toString() + " last alpha " + animAlpha);
                    mLastDrawable.setAlpha((animAlpha*mAlpha)/255);
                    animating = true;
                }
            }
        } else {
            mExitAnimationEnd = 0;
        }

        if (schedule && animating) {
            scheduleSelf(mAnimationRunnable, now + 1000/60);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:19.191 -0500", hash_original_method = "2271215EA07D061295E4A17A597D4C85", hash_generated_method = "126755277D71E0490A3F397762C59936")
    
@Override
    public Drawable getCurrent() {
        return mCurrDrawable;
    }
    
    public abstract static class DrawableContainerState extends ConstantState {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:19.200 -0500", hash_original_field = "69A4D31099BD07B55F0FC0556B45F074", hash_generated_field = "69A4D31099BD07B55F0FC0556B45F074")

         DrawableContainer mOwner;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:19.202 -0500", hash_original_field = "9BFAF00848476277D36D9BA586984BA7", hash_generated_field = "9BFAF00848476277D36D9BA586984BA7")

        int         mChangingConfigurations;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:19.204 -0500", hash_original_field = "E8F7332658D4B8911B8427F9E33AC9BD", hash_generated_field = "E8F7332658D4B8911B8427F9E33AC9BD")

        int         mChildrenChangingConfigurations;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:19.206 -0500", hash_original_field = "B3C5F926BAE6E9ED929417A165A9782D", hash_generated_field = "B3C5F926BAE6E9ED929417A165A9782D")
        
        Drawable[]  mDrawables;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:19.208 -0500", hash_original_field = "77E2F294FC2676328BFD127FCF506329", hash_generated_field = "77E2F294FC2676328BFD127FCF506329")

        int         mNumChildren;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:19.210 -0500", hash_original_field = "A174A0353A9684103C90D7CCC8701C2F", hash_generated_field = "A174A0353A9684103C90D7CCC8701C2F")

        boolean     mVariablePadding = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:19.212 -0500", hash_original_field = "C4240083AE1C6AD18CF7413499D117A4", hash_generated_field = "C4240083AE1C6AD18CF7413499D117A4")

        Rect        mConstantPadding = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:19.214 -0500", hash_original_field = "6BFEC2D16A3F7C5C15697878B6EF3BBE", hash_generated_field = "6BFEC2D16A3F7C5C15697878B6EF3BBE")

        boolean     mConstantSize = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:19.216 -0500", hash_original_field = "430C60111FB869A696B5B5437CADEC6A", hash_generated_field = "430C60111FB869A696B5B5437CADEC6A")

        boolean     mComputedConstantSize = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:19.218 -0500", hash_original_field = "4D42859CADFABA2E50BE968727F544D7", hash_generated_field = "4D42859CADFABA2E50BE968727F544D7")

        int         mConstantWidth;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:19.220 -0500", hash_original_field = "B4AC32864D468EB70183C5472B0F9A3B", hash_generated_field = "B4AC32864D468EB70183C5472B0F9A3B")

        int         mConstantHeight;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:19.222 -0500", hash_original_field = "65FF036F9AF5D3B1235D68E5F33E8546", hash_generated_field = "65FF036F9AF5D3B1235D68E5F33E8546")

        int         mConstantMinimumWidth;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:19.224 -0500", hash_original_field = "15038681586DC6317E5E8BDA3C11F3B1", hash_generated_field = "15038681586DC6317E5E8BDA3C11F3B1")

        int         mConstantMinimumHeight;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:19.227 -0500", hash_original_field = "0E129F2B3EAED33E8435CEB0AF66A927", hash_generated_field = "0E129F2B3EAED33E8435CEB0AF66A927")

        boolean     mHaveOpacity = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:19.229 -0500", hash_original_field = "F94EB6B55A1DFE34A922350D13706418", hash_generated_field = "F94EB6B55A1DFE34A922350D13706418")

        int         mOpacity;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:19.231 -0500", hash_original_field = "788B667F97461387E15CDD9C2D78DA89", hash_generated_field = "788B667F97461387E15CDD9C2D78DA89")

        boolean     mHaveStateful = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:19.233 -0500", hash_original_field = "6CBAA9F8E31FD09725242CB8EF367A38", hash_generated_field = "6CBAA9F8E31FD09725242CB8EF367A38")

        boolean     mStateful;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:19.235 -0500", hash_original_field = "04605894B57F7B3414AF620BF4AC040E", hash_generated_field = "04605894B57F7B3414AF620BF4AC040E")

        boolean     mCheckedConstantState;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:19.237 -0500", hash_original_field = "09212A3A30B7E6D48DEECC4F4639CCBC", hash_generated_field = "09212A3A30B7E6D48DEECC4F4639CCBC")

        boolean     mCanConstantState;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:19.239 -0500", hash_original_field = "F1842B9E642BB7380414BD0D8EACA9C1", hash_generated_field = "F1842B9E642BB7380414BD0D8EACA9C1")

        boolean     mPaddingChecked = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:19.241 -0500", hash_original_field = "ADD3447A81FDA5C4E55789938CB01CA9", hash_generated_field = "ADD3447A81FDA5C4E55789938CB01CA9")
        
        boolean     mDither = DEFAULT_DITHER;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:19.243 -0500", hash_original_field = "3A008F34A7ED7348F09E0D7AC5FD8046", hash_generated_field = "3A008F34A7ED7348F09E0D7AC5FD8046")

        int         mEnterFadeDuration;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:19.245 -0500", hash_original_field = "72291FB3AAE88AF4CCFC28A4C19C4F0A", hash_generated_field = "72291FB3AAE88AF4CCFC28A4C19C4F0A")

        int         mExitFadeDuration;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:19.249 -0500", hash_original_method = "BB71D442E5298FC9607AB33C7CE8B85B", hash_generated_method = "BB71D442E5298FC9607AB33C7CE8B85B")
        
DrawableContainerState(DrawableContainerState orig, DrawableContainer owner,
                Resources res) {
            mOwner = owner;

            if (orig != null) {
                mChangingConfigurations = orig.mChangingConfigurations;
                mChildrenChangingConfigurations = orig.mChildrenChangingConfigurations;
                
                final Drawable[] origDr = orig.mDrawables;

                mDrawables = new Drawable[origDr.length];
                mNumChildren = orig.mNumChildren;

                final int N = mNumChildren;
                for (int i=0; i<N; i++) {
                    if (res != null) {
                        mDrawables[i] = origDr[i].getConstantState().newDrawable(res);
                    } else {
                        mDrawables[i] = origDr[i].getConstantState().newDrawable();
                    }
                    mDrawables[i].setCallback(owner);
                }

                mCheckedConstantState = mCanConstantState = true;
                mVariablePadding = orig.mVariablePadding;
                if (orig.mConstantPadding != null) {
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

            } else {
                mDrawables = new Drawable[10];
                mNumChildren = 0;
                mCheckedConstantState = mCanConstantState = false;
            }
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:19.252 -0500", hash_original_method = "9E7D7C67EAC365FF19BD4971762612A5", hash_generated_method = "3AB30668ED270F2EDF2E0129C706FE4D")
        
@Override
        public int getChangingConfigurations() {
            return mChangingConfigurations;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:19.254 -0500", hash_original_method = "1DF96DB91DC15ED3AA2CD90CE63D5DEA", hash_generated_method = "1A1EE7BF4A755ADD7D306E56024DE1FF")
        
public final int addChild(Drawable dr) {
            final int pos = mNumChildren;

            if (pos >= mDrawables.length) {
                growArray(pos, pos+10);
            }

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

            return pos;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:19.256 -0500", hash_original_method = "58D23B7CD1BBD3B06877382B700017CE", hash_generated_method = "99346163EDEA0A590B3D1ECB64377912")
        
public final int getChildCount() {
            return mNumChildren;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:19.259 -0500", hash_original_method = "F5C2CB0FAF6BF41EBD2EF1D322F89AD5", hash_generated_method = "93B65BE9D4D86C2AD3DCDDFB60120D99")
        
public final Drawable[] getChildren() {
            return mDrawables;
        }

        /** A boolean value indicating whether to use the maximum padding value of 
          * all frames in the set (false), or to use the padding value of the frame 
          * being shown (true). Default value is false. 
          */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:19.261 -0500", hash_original_method = "291079EAD380D117FACCF8E598F58B57", hash_generated_method = "55ED20E554ADB2BA06995C388B0A8BD2")
        
public final void setVariablePadding(boolean variable) {
            mVariablePadding = variable;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:19.263 -0500", hash_original_method = "F49D2F39EC6FEC96BF9263C8B9281632", hash_generated_method = "6C737EF730426680299707B735E65EBB")
        
public final Rect getConstantPadding() {
            if (mVariablePadding) {
                return null;
            }
            if (mConstantPadding != null || mPaddingChecked) {
                return mConstantPadding;
            }

            Rect r = null;
            final Rect t = new Rect();
            final int N = getChildCount();
            final Drawable[] drawables = mDrawables;
            for (int i = 0; i < N; i++) {
                if (drawables[i].getPadding(t)) {
                    if (r == null) r = new Rect(0, 0, 0, 0);
                    if (t.left > r.left) r.left = t.left;
                    if (t.top > r.top) r.top = t.top;
                    if (t.right > r.right) r.right = t.right;
                    if (t.bottom > r.bottom) r.bottom = t.bottom;
                }
            }
            mPaddingChecked = true;
            return (mConstantPadding = r);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:19.267 -0500", hash_original_method = "1BEAC422BABD76426588E9F434C2D5CD", hash_generated_method = "196B6F78B0DCFC169048E37858928B6C")
        
public final void setConstantSize(boolean constant) {
            mConstantSize = constant;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:19.269 -0500", hash_original_method = "23D6FDB773CAAECCFEA4282EEDA0FF8B", hash_generated_method = "FD640C19AFBE150E1382FE8E72E9FB37")
        
public final boolean isConstantSize() {
            return mConstantSize;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:19.272 -0500", hash_original_method = "AEDD9F8F931AA0310C6AB599B9490E0C", hash_generated_method = "4F9C5A5D36C1931BA22C7946B3E8A54C")
        
public final int getConstantWidth() {
            if (!mComputedConstantSize) {
                computeConstantSize();
            }

            return mConstantWidth;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:19.274 -0500", hash_original_method = "A117A0F50DACA3E076E36F6E0FD5A697", hash_generated_method = "C19160CF0D0633BBBA192E60EE3D8F5D")
        
public final int getConstantHeight() {
            if (!mComputedConstantSize) {
                computeConstantSize();
            }

            return mConstantHeight;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:19.277 -0500", hash_original_method = "DA23CD9C0D969BCBC5A31F19CEBA2FA0", hash_generated_method = "32227548FEAB207CB2D1291A1B454A25")
        
public final int getConstantMinimumWidth() {
            if (!mComputedConstantSize) {
                computeConstantSize();
            }

            return mConstantMinimumWidth;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:19.279 -0500", hash_original_method = "9AAB9DC0F579B2E57159CF0852B151D2", hash_generated_method = "A95C6D5DE7716AB5B40A0985C3857467")
        
public final int getConstantMinimumHeight() {
            if (!mComputedConstantSize) {
                computeConstantSize();
            }

            return mConstantMinimumHeight;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:19.282 -0500", hash_original_method = "113DB032EAC82FBADFFAA0B97D39A18D", hash_generated_method = "CFC370ED73544732D6469541CD4F4F5E")
        
protected void computeConstantSize() {
            mComputedConstantSize = true;

            final int N = getChildCount();
            final Drawable[] drawables = mDrawables;
            mConstantWidth = mConstantHeight = -1;
            mConstantMinimumWidth = mConstantMinimumHeight = 0;
            for (int i = 0; i < N; i++) {
                Drawable dr = drawables[i];
                int s = dr.getIntrinsicWidth();
                if (s > mConstantWidth) mConstantWidth = s;
                s = dr.getIntrinsicHeight();
                if (s > mConstantHeight) mConstantHeight = s;
                s = dr.getMinimumWidth();
                if (s > mConstantMinimumWidth) mConstantMinimumWidth = s;
                s = dr.getMinimumHeight();
                if (s > mConstantMinimumHeight) mConstantMinimumHeight = s;
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:19.284 -0500", hash_original_method = "C7A92F60FC2D3E73CF200C7144A831FD", hash_generated_method = "8849823B3FD1BF20EF6EDE975E84558D")
        
public final void setEnterFadeDuration(int duration) {
            mEnterFadeDuration = duration;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:19.286 -0500", hash_original_method = "47A305314E1265D4F19BD4B53B739910", hash_generated_method = "D9B585838712E5DCFF8C8E558708551B")
        
public final int getEnterFadeDuration() {
            return mEnterFadeDuration;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:19.289 -0500", hash_original_method = "1ED7E9EB98364255825D9EFA32269162", hash_generated_method = "07BC8612453D1BCCA1C102D3B5AD5AA2")
        
public final void setExitFadeDuration(int duration) {
            mExitFadeDuration = duration;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:19.291 -0500", hash_original_method = "8AF957428721C92A0DFF9444CB2E7B41", hash_generated_method = "AFC680F591B1A978680A99B8219044D9")
        
public final int getExitFadeDuration() {
            return mExitFadeDuration;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:19.294 -0500", hash_original_method = "C3CEC4829800E9DBA4286BAEED120A24", hash_generated_method = "29E10069C41BCBEFC4CE0473D31C3D88")
        
public final int getOpacity() {
            if (mHaveOpacity) {
                return mOpacity;
            }

            final int N = getChildCount();
            final Drawable[] drawables = mDrawables;
            int op = N > 0 ? drawables[0].getOpacity() : PixelFormat.TRANSPARENT;
            for (int i = 1; i < N; i++) {
                op = Drawable.resolveOpacity(op, drawables[i].getOpacity());
            }
            mOpacity = op;
            mHaveOpacity = true;
            return op;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:19.297 -0500", hash_original_method = "CFE0AE04764A8B8DC9358FA475490068", hash_generated_method = "B661DC1F65DCF9EEBA881A94DA96ED14")
        
public final boolean isStateful() {
            if (mHaveStateful) {
                return mStateful;
            }
            
            boolean stateful = false;
            final int N = getChildCount();
            for (int i = 0; i < N; i++) {
                if (mDrawables[i].isStateful()) {
                    stateful = true;
                    break;
                }
            }
            
            mStateful = stateful;
            mHaveStateful = true;
            return stateful;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:19.299 -0500", hash_original_method = "A9E2F6299A2B0C0DB78600A3C23F092D", hash_generated_method = "E82C1B4651E1513CCA68B4E0A052C752")
        
public void growArray(int oldSize, int newSize) {
            Drawable[] newDrawables = new Drawable[newSize];
            System.arraycopy(mDrawables, 0, newDrawables, 0, oldSize);
            mDrawables = newDrawables;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:19.301 -0500", hash_original_method = "F91020706361DEC18BACE4525A4D4C39", hash_generated_method = "7C300E757EF29C94029FB1DC6C283F8B")
        
public synchronized boolean canConstantState() {
            if (!mCheckedConstantState) {
                mCanConstantState = true;
                final int N = mNumChildren;
                for (int i=0; i<N; i++) {
                    if (mDrawables[i].getConstantState() == null) {
                        mCanConstantState = false;
                        break;
                    }
                }
                mCheckedConstantState = true;
            }

            return mCanConstantState;
        }
        
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:19.194 -0500", hash_original_method = "7CCE0C3F432CC06D16574FAD35E80869", hash_generated_method = "BFD7E791B9533CDD0EE1A0E4FCAFC20E")
    
@Override
    public ConstantState getConstantState() {
        if (mDrawableContainerState.canConstantState()) {
            mDrawableContainerState.mChangingConfigurations = getChangingConfigurations();
            return mDrawableContainerState;
        }
        return null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:19.197 -0500", hash_original_method = "9CED290C930F72A121B65658EE47F79B", hash_generated_method = "D8512941E8BE0EA8EC5AABAED5ED3657")
    
@Override
    public Drawable mutate() {
        if (!mMutated && super.mutate() == this) {
            final int N = mDrawableContainerState.getChildCount();
            final Drawable[] drawables = mDrawableContainerState.getChildren();
            for (int i = 0; i < N; i++) {
                if (drawables[i] != null) drawables[i].mutate();
            }
            mMutated = true;
        }
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:19.307 -0500", hash_original_method = "8007C958EC09F138BD431BCAF111D646", hash_generated_method = "13A0872B5A0492F3E40FAC478F5066B0")
    
protected void setConstantState(DrawableContainerState state)
    {
        mDrawableContainerState = state;
    }
}

