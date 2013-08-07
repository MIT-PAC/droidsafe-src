package com.android.internal.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.ArrayList;
import android.animation.ValueAnimator;
import android.view.animation.DecelerateInterpolator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.util.Log;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.Canvas;
import android.animation.Animator;
public class DrawableHolder implements AnimatorListener {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.509 -0400", hash_original_field = "BFAD9CD45BD296D050F78A555042FFC0", hash_generated_field = "75C6CD85FAABF7BCE6F0967D0C310966")

    private float mX = 0.0f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.509 -0400", hash_original_field = "ACB66E0CD8E84080C651B625DC825EA3", hash_generated_field = "1ACCE77C2DD20DD5C35D41FBAD5E654A")

    private float mY = 0.0f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.509 -0400", hash_original_field = "13856D8A755FB7F96283A0673DDA6900", hash_generated_field = "384BEA0D42AB64FA4F8EBDEE380C7444")

    private float mScaleX = 1.0f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.509 -0400", hash_original_field = "701DA022FEBE1A233C5E8C8E6CC8CD8C", hash_generated_field = "047AE590FA93629B16F3738468B61503")

    private float mScaleY = 1.0f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.509 -0400", hash_original_field = "D548B27C6AC66A9D9B5D05ED35C2D844", hash_generated_field = "D1CD4C1ECB596AE6941F4F9F09D4D60F")

    private BitmapDrawable mDrawable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.510 -0400", hash_original_field = "14E45EEE3993C8F9A0BE01602FD0F58C", hash_generated_field = "C1288CE26C010EC5C7224AF7E71615A3")

    private float mAlpha = 1f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.510 -0400", hash_original_field = "AE682010AF5F7F0EE6CCA0EF745B201D", hash_generated_field = "87433ADE46D867A2B595538699E32D08")

    private ArrayList<ObjectAnimator> mAnimators = new ArrayList<ObjectAnimator>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.510 -0400", hash_original_field = "EF95FD145DE832F693CB5D6AC238C8CE", hash_generated_field = "DA69782BAE96675DB4F37BB44528A634")

    private ArrayList<ObjectAnimator> mNeedToStart = new ArrayList<ObjectAnimator>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.510 -0400", hash_original_method = "D8506F5B637D20BBD2060AD51865B118", hash_generated_method = "556B2A2C821E62DE039D0A96C3A760FF")
    public  DrawableHolder(BitmapDrawable drawable) {
        this(drawable, 0.0f, 0.0f);
        addTaint(drawable.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.511 -0400", hash_original_method = "F52EE1505ECCA2FF2F7AE425FC087293", hash_generated_method = "6DCE08D8D6EEB309918B2838C0B06A80")
    public  DrawableHolder(BitmapDrawable drawable, float x, float y) {
        addTaint(y);
        addTaint(x);
        addTaint(drawable.getTaint());
mDrawable=drawablemX=xmY=ymDrawable.getPaint().setAntiAlias(true)mDrawable.setBounds(0, 0, mDrawable.getIntrinsicWidth(), mDrawable.getIntrinsicHeight())
        // ---------- Original Method ----------
        //mDrawable = drawable;
        //mX = x;
        //mY = y;
        //mDrawable.getPaint().setAntiAlias(true);
        //mDrawable.setBounds(0, 0, mDrawable.getIntrinsicWidth(), mDrawable.getIntrinsicHeight());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.511 -0400", hash_original_method = "710CFD05D3C2663D36E81A58A87D5788", hash_generated_method = "C69618CACC139CF408FD38C403FEE938")
    public ObjectAnimator addAnimTo(long duration, long delay,
            String property, float toValue, boolean replace) {
        addTaint(replace);
        addTaint(toValue);
        addTaint(property.getTaint());
        addTaint(delay);
        addTaint(duration);
        if(replace)        
removeAnimationFor(property)
        ObjectAnimator anim = ObjectAnimator.ofFloat(this, property, toValue);
anim.setDuration(duration)anim.setStartDelay(delay)anim.setInterpolator(EASE_OUT_INTERPOLATOR)this.addAnimation(anim, replace)        if(DBG){ }ObjectAnimator var6E2178F33F884BED37C5DEBCD18F9A96_1125005276 = anim        var6E2178F33F884BED37C5DEBCD18F9A96_1125005276.addTaint(taint);
        return var6E2178F33F884BED37C5DEBCD18F9A96_1125005276;
        // ---------- Original Method ----------
        //if (replace) removeAnimationFor(property);
        //ObjectAnimator anim = ObjectAnimator.ofFloat(this, property, toValue);
        //anim.setDuration(duration);
        //anim.setStartDelay(delay);
        //anim.setInterpolator(EASE_OUT_INTERPOLATOR);
        //this.addAnimation(anim, replace);
        //if (DBG) Log.v(TAG, "animationCount = " + mAnimators.size());
        //return anim;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.512 -0400", hash_original_method = "3513DFD92C93AE317BAED0089567A3C0", hash_generated_method = "A731E8C96DAFC1D419B3F0406D8D5176")
    public void removeAnimationFor(String property) {
        addTaint(property.getTaint());
        ArrayList<ObjectAnimator> removalList = (ArrayList<ObjectAnimator>)mAnimators.clone();
for(ObjectAnimator currentAnim : removalList)
        {
            if(property.equals(currentAnim.getPropertyName()))            
            {
currentAnim.cancel()
            } //End block
        } //End block
        // ---------- Original Method ----------
        //ArrayList<ObjectAnimator> removalList = (ArrayList<ObjectAnimator>)mAnimators.clone();
        //for (ObjectAnimator currentAnim : removalList) {
            //if (property.equals(currentAnim.getPropertyName())) {
                //currentAnim.cancel();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.513 -0400", hash_original_method = "9E1C8B18EEA9C74C2AF14EAAA6D64C2A", hash_generated_method = "E8AE8E86507AB212DF3C3D523A8E0483")
    public void clearAnimations() {
for(ObjectAnimator currentAnim : mAnimators)
        {
currentAnim.cancel()
        } //End block
mAnimators.clear()
        // ---------- Original Method ----------
        //for (ObjectAnimator currentAnim : mAnimators) {
            //currentAnim.cancel();
        //}
        //mAnimators.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.513 -0400", hash_original_method = "E0CFEF456F683F3D531DBAD02D40E1E0", hash_generated_method = "E2E91F0D49BD5024CB74F82EE01C9A69")
    private DrawableHolder addAnimation(ObjectAnimator anim, boolean overwrite) {
        addTaint(overwrite);
        addTaint(anim.getTaint());
        if(anim!=null)        
mAnimators.add(anim)
mNeedToStart.add(anim)DrawableHolder var72A74007B2BE62B849F475C7BDA4658B_2127813834 = this        var72A74007B2BE62B849F475C7BDA4658B_2127813834.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_2127813834;
        // ---------- Original Method ----------
        //if (anim != null)
            //mAnimators.add(anim);
        //mNeedToStart.add(anim);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.514 -0400", hash_original_method = "AC792D9C72F928E82B5F128A7EE340A3", hash_generated_method = "B4E7A7E82442F54F4F78E96A4FBD2471")
    public void draw(Canvas canvas) {
        addTaint(canvas.getTaint());
        final float threshold = 1.0f / 256.0f;
        if(mAlpha<=threshold)        
        return;
canvas.save(Canvas.MATRIX_SAVE_FLAG)canvas.translate(mX, mY)canvas.scale(mScaleX, mScaleY)canvas.translate(-0.5f*getWidth(), -0.5f*getHeight())mDrawable.setAlpha((int) Math.round(mAlpha*255f))mDrawable.draw(canvas)canvas.restore()
        // ---------- Original Method ----------
        //final float threshold = 1.0f / 256.0f;
        //if (mAlpha <= threshold) 
            //return;
        //canvas.save(Canvas.MATRIX_SAVE_FLAG);
        //canvas.translate(mX, mY);
        //canvas.scale(mScaleX, mScaleY);
        //canvas.translate(-0.5f*getWidth(), -0.5f*getHeight());
        //mDrawable.setAlpha((int) Math.round(mAlpha * 255f));
        //mDrawable.draw(canvas);
        //canvas.restore();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.514 -0400", hash_original_method = "3CCE0EA459BF9AE11710A79E514C3DB6", hash_generated_method = "23ED81B0CDE47E025A44724B76E7A70A")
    public void startAnimations(ValueAnimator.AnimatorUpdateListener listener) {
        addTaint(listener.getTaint());
for(int i = 0;i<mNeedToStart.size();i)
        {
            ObjectAnimator anim = mNeedToStart.get(i);
anim.addUpdateListener(listener)anim.addListener(this)anim.start()
        } //End block
mNeedToStart.clear()
        // ---------- Original Method ----------
        //for (int i = 0; i < mNeedToStart.size(); i++) {
            //ObjectAnimator anim = mNeedToStart.get(i);
            //anim.addUpdateListener(listener);
            //anim.addListener(this);
            //anim.start();
        //}
        //mNeedToStart.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.515 -0400", hash_original_method = "575ACE7F12B157CFD97F5EB7FB41B314", hash_generated_method = "F9AE901585768BE7BFB9DE5CED29EE0B")
    public void setX(float value) {
        addTaint(value);
mX=value
        // ---------- Original Method ----------
        //mX = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.515 -0400", hash_original_method = "982948D125D0D8D14B530FB1808BDDF7", hash_generated_method = "7A4D1DD61FE1246A8B444ECDD3561CFF")
    public void setY(float value) {
        addTaint(value);
mY=value
        // ---------- Original Method ----------
        //mY = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.515 -0400", hash_original_method = "CADC5B7CDB9DC481ED7EB301FEEFA623", hash_generated_method = "650D9CA103D7DCB427FA1C0934A2113C")
    public void setScaleX(float value) {
        addTaint(value);
mScaleX=value
        // ---------- Original Method ----------
        //mScaleX = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.516 -0400", hash_original_method = "A870F47024930A080687B476DF310485", hash_generated_method = "5BB47AF20C0BBA8902EECDB061ADA25E")
    public void setScaleY(float value) {
        addTaint(value);
mScaleY=value
        // ---------- Original Method ----------
        //mScaleY = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.516 -0400", hash_original_method = "0C33009713633FC103F0B586FD422009", hash_generated_method = "EE9402B5A0724A8DDAEA4042EB153D5B")
    public void setAlpha(float alpha) {
        addTaint(alpha);
mAlpha=alpha
        // ---------- Original Method ----------
        //mAlpha = alpha;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.516 -0400", hash_original_method = "331663EFF3E2EE62701FDAFEDB013F35", hash_generated_method = "30FBF3F8F1A89255CE4B96AD867E9C18")
    public float getX() {
        float varE47D03BC59EE2C8B3B45870BE85294FB_897915825 = (mX);
                float var546ADE640B6EDFBC8A086EF31347E768_1312109526 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1312109526;
        // ---------- Original Method ----------
        //return mX;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.517 -0400", hash_original_method = "ABC228174E672AD41349CE6D52652626", hash_generated_method = "269E76C965AD692F122DC0F9C78A0DBE")
    public float getY() {
        float var29DA5B2B864236A2CCB25B548E8F5F0A_843164153 = (mY);
                float var546ADE640B6EDFBC8A086EF31347E768_329096679 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_329096679;
        // ---------- Original Method ----------
        //return mY;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.517 -0400", hash_original_method = "77BF1FCCF84378618A90063FAB69ED38", hash_generated_method = "FC7A67EFD75DB87FE92C76ECF463D14B")
    public float getScaleX() {
        float varA451AE15D9C2A470AAFF3FC8FB4AAA38_1310960868 = (mScaleX);
                float var546ADE640B6EDFBC8A086EF31347E768_84412187 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_84412187;
        // ---------- Original Method ----------
        //return mScaleX;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.518 -0400", hash_original_method = "F8DD4522C45935E8A1E94B5BA53FAF41", hash_generated_method = "C8ED5C3B74E593B06D340B81A98AEDD4")
    public float getScaleY() {
        float var1E27D36C99355A55A9FA2E5EAAA90A64_1272846707 = (mScaleY);
                float var546ADE640B6EDFBC8A086EF31347E768_1543400603 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1543400603;
        // ---------- Original Method ----------
        //return mScaleY;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.518 -0400", hash_original_method = "84CA63CC358414A9CD87B6516C604402", hash_generated_method = "E88C390FCAD5B34BE9F1BCEF9F88881C")
    public float getAlpha() {
        float var7574041472B9B2E76867A37482E74343_268972774 = (mAlpha);
                float var546ADE640B6EDFBC8A086EF31347E768_1660341248 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1660341248;
        // ---------- Original Method ----------
        //return mAlpha;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.519 -0400", hash_original_method = "0ED793F76C2CCB3A993CF541676CF3E2", hash_generated_method = "5A8678524BBFB394D955FCE48FEC2B71")
    public BitmapDrawable getDrawable() {
BitmapDrawable var421F6744A8B50797FB9C4A96CE6DA02C_858742518 = mDrawable        var421F6744A8B50797FB9C4A96CE6DA02C_858742518.addTaint(taint);
        return var421F6744A8B50797FB9C4A96CE6DA02C_858742518;
        // ---------- Original Method ----------
        //return mDrawable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.519 -0400", hash_original_method = "9DBC0815FED6326D314FC44ED0285333", hash_generated_method = "1EDDB969F24B93C87370353908681360")
    public int getWidth() {
        int var8CD90C083BD258F5253FA97B053F6840_1841677881 = (mDrawable.getIntrinsicWidth());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1404389793 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1404389793;
        // ---------- Original Method ----------
        //return mDrawable.getIntrinsicWidth();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.519 -0400", hash_original_method = "0BFCD5715805F888F6E81173213EB1F1", hash_generated_method = "0780CDE9482077A7BDB10789A5E2217A")
    public int getHeight() {
        int varC647EB3B1EBD1B01AACE0918E9AFCA26_1819180147 = (mDrawable.getIntrinsicHeight());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2131331439 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2131331439;
        // ---------- Original Method ----------
        //return mDrawable.getIntrinsicHeight();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.520 -0400", hash_original_method = "16FF962612CA0CC38B4765F38064800C", hash_generated_method = "C2873E3A5F96230B9841E1221FD8122E")
    public void onAnimationCancel(Animator animation) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(animation.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.520 -0400", hash_original_method = "16EDDB758B57514EE6F16B3299669E6B", hash_generated_method = "B5FC25AA4139CAA1F8030B364623873D")
    public void onAnimationEnd(Animator animation) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(animation.getTaint());
mAnimators.remove(animation)
        // ---------- Original Method ----------
        //mAnimators.remove(animation);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.521 -0400", hash_original_method = "FA58700A4888ED9E658B43737D17A966", hash_generated_method = "2CC49AF6623F4CFFEDAE2EE5FA4412D5")
    public void onAnimationRepeat(Animator animation) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(animation.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.521 -0400", hash_original_method = "B990D1A680B01C8A5486D22741D7E96B", hash_generated_method = "4F1E500BA39728FB7A49E02540A0C5AA")
    public void onAnimationStart(Animator animation) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(animation.getTaint());
        // ---------- Original Method ----------
    }

    

