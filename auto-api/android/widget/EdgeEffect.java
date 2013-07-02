package android.widget;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import com.android.internal.R;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;

public class EdgeEffect {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.489 -0400", hash_original_field = "F314C72E2C97B21F27CA1E6DFA1CE41B", hash_generated_field = "05964103E2640D266736C21291ED963A")

    private Drawable mEdge;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.489 -0400", hash_original_field = "599946FADB580B95E89D1B4260E6DDAC", hash_generated_field = "D018733BFF00E669B84A6D8AFEEDCF48")

    private Drawable mGlow;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.489 -0400", hash_original_field = "A3DB1626A190732E588FD0D14FC8FB31", hash_generated_field = "380984B6D3BA888BD05804A5D24041AE")

    private int mWidth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.489 -0400", hash_original_field = "483542B05A951AA16D89C7F809C20811", hash_generated_field = "9A13F430E09A05B31C551CE62B9A37C1")

    private int mHeight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.489 -0400", hash_original_field = "9B8864B739126353FF8A444944BF5752", hash_generated_field = "CA4554880F5BBA33C228166752942684")

    private final int MIN_WIDTH = 300;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.489 -0400", hash_original_field = "2FB832D2671571BF4EC0C84F8DA6AA79", hash_generated_field = "ED0C6BF081117F2A257C521DB4125AB9")

    private int mMinWidth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.489 -0400", hash_original_field = "F2BC0E12EBF67FDB51551D4EDCA01216", hash_generated_field = "C9E57FA99AB49068A8F6E92401E4EDF8")

    private float mEdgeAlpha;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.489 -0400", hash_original_field = "AF357D960639268C4992345A01E8F3B2", hash_generated_field = "CC58105158D79453C497FDAC69A3CBDA")

    private float mEdgeScaleY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.489 -0400", hash_original_field = "44DA402D2B92CAC98198AC86EDA398B3", hash_generated_field = "DB067BCEF357200891D3577E65E9378E")

    private float mGlowAlpha;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.489 -0400", hash_original_field = "DB07B61B392C0FB56BE745915C02A52E", hash_generated_field = "9705800BBC7D1D409097697AD04EEC0A")

    private float mGlowScaleY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.489 -0400", hash_original_field = "7ADE81C3455046E88FA055EC34485262", hash_generated_field = "E42FD5C4BF05C06F1FE157CC7F60650B")

    private float mEdgeAlphaStart;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.489 -0400", hash_original_field = "6AD4AD9D9C6E7AE2AB1C38B85267C6DD", hash_generated_field = "C1F5208E06DFC4F14F94A109222A8734")

    private float mEdgeAlphaFinish;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.489 -0400", hash_original_field = "931A65D28B37D5469D45A2D5E151B3E2", hash_generated_field = "B1F8C79BFDAA0E6EB028DAC9F61BA8F3")

    private float mEdgeScaleYStart;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.489 -0400", hash_original_field = "E38DE88195DCD870CACDDD550CB2CFA7", hash_generated_field = "02463AD75A569C6736255765B3F5D721")

    private float mEdgeScaleYFinish;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.489 -0400", hash_original_field = "5444EB12986A0397AC6510B121AFD95C", hash_generated_field = "04753334CFB95BA993CA564E84E8DBBE")

    private float mGlowAlphaStart;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.489 -0400", hash_original_field = "2FFA7931BC442FFC84F0F24FFF44DE70", hash_generated_field = "6B5717F153A0936F85E0BE336A54E8EC")

    private float mGlowAlphaFinish;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.489 -0400", hash_original_field = "127B4C471DB430C1ED1BA1E85A18DCA2", hash_generated_field = "DCE1D0531C3FB7E23F3B6E495CCBDE48")

    private float mGlowScaleYStart;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.489 -0400", hash_original_field = "33749BAA8EF43B652CE12EEE5B0DADA5", hash_generated_field = "A8A7CF5496D086FD30B1B3B4160D004D")

    private float mGlowScaleYFinish;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.489 -0400", hash_original_field = "4FBE52F16DA5DC1AFB86B1520E59C2C0", hash_generated_field = "20EEDA67D8E4F20D3E4CA3D911CCA492")

    private long mStartTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.489 -0400", hash_original_field = "25395741BFE51A7D136A5C7109AAD2D8", hash_generated_field = "E74108ED786047D2751EA97FD8595181")

    private float mDuration;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.489 -0400", hash_original_field = "DA3E6FC5A778B3C344EE09B26563FD22", hash_generated_field = "67BF1E9EFEC019D28BF77934CF035B72")

    private Interpolator mInterpolator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.489 -0400", hash_original_field = "B1D3DF683580EF5A23151C822F7996CC", hash_generated_field = "445CA88308987469683043EF45117C11")

    private int mState = STATE_IDLE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.489 -0400", hash_original_field = "3587418C5580A6C130A4C5DC87351B28", hash_generated_field = "E175867FE0E063DCFFB7A99C55784D6E")

    private float mPullDistance;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.490 -0400", hash_original_method = "AC508E1EC1805645807F80E8793DDCA5", hash_generated_method = "3B4B99E31AF4407279A66B8210166A46")
    public  EdgeEffect(Context context) {
        final Resources res = context.getResources();
        mEdge = res.getDrawable(R.drawable.overscroll_edge);
        mGlow = res.getDrawable(R.drawable.overscroll_glow);
        mMinWidth = (int) (res.getDisplayMetrics().density * MIN_WIDTH + 0.5f);
        mInterpolator = new DecelerateInterpolator();
        addTaint(context.getTaint());
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.490 -0400", hash_original_method = "2560E21D822EB58266D32B5FBCFCA888", hash_generated_method = "937C2CF909C70F6CCE7A1CB2903577B5")
    public void setSize(int width, int height) {
        mWidth = width;
        mHeight = height;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.490 -0400", hash_original_method = "C5415C2330467D0B97062A48ADF90DEB", hash_generated_method = "A74D9300D1A41DBD1A17D1297244C03B")
    public boolean isFinished() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_135313931 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_135313931;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.491 -0400", hash_original_method = "27AC7ECC3801AAB2943059507B28FB49", hash_generated_method = "4A51E2781D945A7EDF99F072DEC552D1")
    public void finish() {
        mState = STATE_IDLE;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.491 -0400", hash_original_method = "0B34B4327835671A51286147399AA2A4", hash_generated_method = "0912D40F6BBC7278140035DAD6BE822E")
    public void onPull(float deltaDistance) {
        
        final long now = AnimationUtils.currentAnimationTimeMillis();
        {
            mGlowScaleY = PULL_GLOW_BEGIN;
        } 
        mState = STATE_PULL;
        mStartTime = now;
        mDuration = PULL_TIME;
        mPullDistance += deltaDistance;
        float distance = Math.abs(mPullDistance);
        mEdgeAlpha = mEdgeAlphaStart = Math.max(PULL_EDGE_BEGIN, Math.min(distance, MAX_ALPHA));
        mEdgeScaleY = mEdgeScaleYStart = Math.max(
                HELD_EDGE_SCALE_Y, Math.min(distance * PULL_DISTANCE_EDGE_FACTOR, 1.f));
        mGlowAlpha = mGlowAlphaStart = Math.min(MAX_ALPHA,
                mGlowAlpha +
                (Math.abs(deltaDistance) * PULL_DISTANCE_ALPHA_GLOW_FACTOR));
        float glowChange = Math.abs(deltaDistance);
        {
            glowChange = -glowChange;
        } 
        {
            mGlowScaleY = 0;
        } 
        mGlowScaleY = mGlowScaleYStart = Math.min(MAX_GLOW_HEIGHT, Math.max(
                0, mGlowScaleY + glowChange * PULL_DISTANCE_GLOW_FACTOR));
        mEdgeAlphaFinish = mEdgeAlpha;
        mEdgeScaleYFinish = mEdgeScaleY;
        mGlowAlphaFinish = mGlowAlpha;
        mGlowScaleYFinish = mGlowScaleY;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.492 -0400", hash_original_method = "130A4176B67F340D0300F29A870A39F7", hash_generated_method = "48EABD6C325B873D69ADA88ADC482D05")
    public void onRelease() {
        
        mPullDistance = 0;
        mState = STATE_RECEDE;
        mEdgeAlphaStart = mEdgeAlpha;
        mEdgeScaleYStart = mEdgeScaleY;
        mGlowAlphaStart = mGlowAlpha;
        mGlowScaleYStart = mGlowScaleY;
        mEdgeAlphaFinish = 0.f;
        mEdgeScaleYFinish = 0.f;
        mGlowAlphaFinish = 0.f;
        mGlowScaleYFinish = 0.f;
        mStartTime = AnimationUtils.currentAnimationTimeMillis();
        mDuration = RECEDE_TIME;
        
        
        
            
        
        
        
        
        
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.493 -0400", hash_original_method = "1D958DC13C828E6D4B8059ABA730E95F", hash_generated_method = "BA825A4857DBCA7D9EF40A9CF75A8279")
    public void onAbsorb(int velocity) {
        
        mState = STATE_ABSORB;
        velocity = Math.max(MIN_VELOCITY, Math.abs(velocity));
        mStartTime = AnimationUtils.currentAnimationTimeMillis();
        mDuration = 0.1f + (velocity * 0.03f);
        mEdgeAlphaStart = 0.f;
        mEdgeScaleY = mEdgeScaleYStart = 0.f;
        mGlowAlphaStart = 0.5f;
        mGlowScaleYStart = 0.f;
        mEdgeAlphaFinish = Math.max(0, Math.min(velocity * VELOCITY_EDGE_FACTOR, 1));
        mEdgeScaleYFinish = Math.max(
                HELD_EDGE_SCALE_Y, Math.min(velocity * VELOCITY_EDGE_FACTOR, 1.f));
        mGlowScaleYFinish = Math.min(0.025f + (velocity * (velocity / 100) * 0.00015f), 1.75f);
        mGlowAlphaFinish = Math.max(
                mGlowAlphaStart, Math.min(velocity * VELOCITY_GLOW_FACTOR * .00001f, MAX_ALPHA));
        
        
        
        
        
        
        
        
        
        
        
                
        
        
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.494 -0400", hash_original_method = "610B6E206A511890E944EC9E15AA39A0", hash_generated_method = "E1A24FED41BC1733AE6EC3EB214DC0EE")
    public boolean draw(Canvas canvas) {
        update();
        final int edgeHeight = mEdge.getIntrinsicHeight();
        final int edgeWidth = mEdge.getIntrinsicWidth();
        final int glowHeight = mGlow.getIntrinsicHeight();
        final int glowWidth = mGlow.getIntrinsicWidth();
        mGlow.setAlpha((int) (Math.max(0, Math.min(mGlowAlpha, 1)) * 255));
        int glowBottom = (int) Math.min(
                glowHeight * mGlowScaleY * glowHeight/ glowWidth * 0.6f,
                glowHeight * MAX_GLOW_HEIGHT);
        {
            int glowLeft = (mWidth - mMinWidth)/2;
            mGlow.setBounds(glowLeft, 0, mWidth - glowLeft, glowBottom);
        } 
        {
            mGlow.setBounds(0, 0, mWidth, glowBottom);
        } 
        mGlow.draw(canvas);
        mEdge.setAlpha((int) (Math.max(0, Math.min(mEdgeAlpha, 1)) * 255));
        int edgeBottom = (int) (edgeHeight * mEdgeScaleY);
        {
            int edgeLeft = (mWidth - mMinWidth)/2;
            mEdge.setBounds(edgeLeft, 0, mWidth - edgeLeft, edgeBottom);
        } 
        {
            mEdge.setBounds(0, 0, mWidth, edgeBottom);
        } 
        mEdge.draw(canvas);
        addTaint(canvas.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_465358880 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_465358880;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.495 -0400", hash_original_method = "217F98194ACCE474266C15D1EE978E29", hash_generated_method = "449F73A7F067312DFF505BD3A9DCF80F")
    private void update() {
        final long time = AnimationUtils.currentAnimationTimeMillis();
        final float t = Math.min((time - mStartTime) / mDuration, 1.f);
        final float interp = mInterpolator.getInterpolation(t);
        mEdgeAlpha = mEdgeAlphaStart + (mEdgeAlphaFinish - mEdgeAlphaStart) * interp;
        mEdgeScaleY = mEdgeScaleYStart + (mEdgeScaleYFinish - mEdgeScaleYStart) * interp;
        mGlowAlpha = mGlowAlphaStart + (mGlowAlphaFinish - mGlowAlphaStart) * interp;
        mGlowScaleY = mGlowScaleYStart + (mGlowScaleYFinish - mGlowScaleYStart) * interp;
        {
            
            mState = STATE_RECEDE;
            
            
            mStartTime = AnimationUtils.currentAnimationTimeMillis();
            
            
            mDuration = RECEDE_TIME;
            
            
            mEdgeAlphaStart = mEdgeAlpha;
            
            
            mEdgeScaleYStart = mEdgeScaleY;
            
            
            mGlowAlphaStart = mGlowAlpha;
            
            
            mGlowScaleYStart = mGlowScaleY;
            
            
            mEdgeAlphaFinish = 0.f;
            
            
            mEdgeScaleYFinish = 0.f;
            
            
            mGlowAlphaFinish = 0.f;
            
            
            mGlowScaleYFinish = 0.f;
            
            
            mState = STATE_PULL_DECAY;
            
            
            mStartTime = AnimationUtils.currentAnimationTimeMillis();
            
            
            mDuration = PULL_DECAY_TIME;
            
            
            mEdgeAlphaStart = mEdgeAlpha;
            
            
            mEdgeScaleYStart = mEdgeScaleY;
            
            
            mGlowAlphaStart = mGlowAlpha;
            
            
            mGlowScaleYStart = mGlowScaleY;
            
            
            mEdgeAlphaFinish = 0.f;
            
            
            mEdgeScaleYFinish = 0.f;
            
            
            mGlowAlphaFinish = 0.f;
            
            
            mGlowScaleYFinish = 0.f;
            
            
            float factor;
            factor = 1
                            / (mGlowScaleYFinish * mGlowScaleYFinish);
            factor = Float.MAX_VALUE;
            
            
            mEdgeScaleY = mEdgeScaleYStart +
                        (mEdgeScaleYFinish - mEdgeScaleYStart) *
                            interp * factor;
            
            
            mState = STATE_RECEDE;
            
            
            mState = STATE_IDLE;
            
        } 
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.495 -0400", hash_original_field = "9B550257CB6C51EC402E7251B17A5029", hash_generated_field = "8318DED0E83CE770D47711FAEB77E6C5")

    private static final String TAG = "EdgeEffect";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.495 -0400", hash_original_field = "F09B980981B713224E0DD661E72B450F", hash_generated_field = "95C02B4A0287FA86ED46A69803A79218")

    private static final int RECEDE_TIME = 1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.495 -0400", hash_original_field = "1ED4EA2FFBA4F561D224E590488AFC6F", hash_generated_field = "2C74B79C1183F7DEC78751B83468CF0D")

    private static final int PULL_TIME = 167;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.495 -0400", hash_original_field = "0BA9D330180F6EB9BECC8410B74EB05D", hash_generated_field = "81B49A12E85960788C5F8AE3D82C58C7")

    private static final int PULL_DECAY_TIME = 1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.495 -0400", hash_original_field = "6617779168B64C2B76869A72743968F0", hash_generated_field = "3C3930C5D92B8510AC36599132967614")

    private static final float MAX_ALPHA = 0.8f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.495 -0400", hash_original_field = "CAF74C9F2513872582BD4D95F8665573", hash_generated_field = "A5BCE2D319734849C17A12366D047EEB")

    private static final float HELD_EDGE_ALPHA = 0.7f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.495 -0400", hash_original_field = "863956899E84958D4552D48B1E72271E", hash_generated_field = "2BA8155A958133E13ED73727484A3B84")

    private static final float HELD_EDGE_SCALE_Y = 0.5f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.495 -0400", hash_original_field = "D263B04833695A8C71480DA5142FD631", hash_generated_field = "5C108BBD047E80601904156DEEC9474E")

    private static final float HELD_GLOW_ALPHA = 0.5f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.495 -0400", hash_original_field = "AF6DFC258A70FEC6130305B596257F1B", hash_generated_field = "DDDF9F3A6A2AC28769770EC81801836E")

    private static final float HELD_GLOW_SCALE_Y = 0.5f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.495 -0400", hash_original_field = "C5B5D4808D3567B8AD393DF5BF09D7F5", hash_generated_field = "1FC6FD4875548D3C97E25AB46C8876F8")

    private static final float MAX_GLOW_HEIGHT = 4.f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.495 -0400", hash_original_field = "55382C0750C12793A12645C1A47D1D6E", hash_generated_field = "1852B514A0F172C1A0C0CE468D21AE38")

    private static final float PULL_GLOW_BEGIN = 1.f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.495 -0400", hash_original_field = "91FEAB21011827BB72B61E9BA374109D", hash_generated_field = "E4D812693FB853EEE256AA78FA1B8DFD")

    private static final float PULL_EDGE_BEGIN = 0.6f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.495 -0400", hash_original_field = "302BD9FB2EB478F2F0FA2E385B85E7A8", hash_generated_field = "27AA9B07C11177BE51EB8E22C1C62F5F")

    private static final int MIN_VELOCITY = 100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.495 -0400", hash_original_field = "E7FFA16414F6CEDE27C1511B96981E06", hash_generated_field = "BFA53C88BB1CB77A0739A8F00482034F")

    private static final float EPSILON = 0.001f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.495 -0400", hash_original_field = "AEBCB16EA0142CCECDCE720235105004", hash_generated_field = "31A5ECBA709672BB7BAE010B1E1C3954")

    private static final int STATE_IDLE = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.495 -0400", hash_original_field = "37F00CB5CBB14E6D5E4B49884CC9A77F", hash_generated_field = "77FEF176BBE43E2F8960B9784C71E6B0")

    private static final int STATE_PULL = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.495 -0400", hash_original_field = "52F99F3CC662FE7EC58B89B0E2E101DE", hash_generated_field = "85CD668DE159DB3B274284B977F86D18")

    private static final int STATE_ABSORB = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.495 -0400", hash_original_field = "AADA7966F6CED14BD8082EE740475F33", hash_generated_field = "D1EC2E1A815D35A15D574DAE68E4CC43")

    private static final int STATE_RECEDE = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.495 -0400", hash_original_field = "8465A9FD1BA9F9ECD8481DA0A801B084", hash_generated_field = "375C652B2C4D3ADE1445E8DECCE71CB9")

    private static final int STATE_PULL_DECAY = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.495 -0400", hash_original_field = "B1DF700426464C3B58DC1F979233435C", hash_generated_field = "9DD9E1A84C23F0B05608086D373053E9")

    private static final int PULL_DISTANCE_EDGE_FACTOR = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.495 -0400", hash_original_field = "26C3D8A5204E965964DDB0CCE8B24E8A", hash_generated_field = "A31A3EA506CEBE6E3DFD4D503F579B4F")

    private static final int PULL_DISTANCE_GLOW_FACTOR = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.495 -0400", hash_original_field = "D68103FA073076D2F4F731136ABD120E", hash_generated_field = "CF0135F44D863650817E434094F22930")

    private static final float PULL_DISTANCE_ALPHA_GLOW_FACTOR = 1.1f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.495 -0400", hash_original_field = "30EB7DF6D593C200FA99C590E135C070", hash_generated_field = "A935EB5BD34095A1331297B18BCECC07")

    private static final int VELOCITY_EDGE_FACTOR = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.495 -0400", hash_original_field = "1F592D50E57FEA961A8D3F7D6A868FDD", hash_generated_field = "F5DD8A210B2F110796FE117CF4CEAC48")

    private static final int VELOCITY_GLOW_FACTOR = 16;
}

