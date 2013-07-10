package android.graphics.drawable;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.os.SystemClock;

public class TransitionDrawable extends LayerDrawable implements Drawable.Callback {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.652 -0400", hash_original_field = "A7B20EF19631195D4CD5E5E59BE8ED91", hash_generated_field = "D70F55987D084695053B74ED3F9477FE")

    private int mTransitionState = TRANSITION_NONE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.652 -0400", hash_original_field = "AB79369A0ECA69C81F7483142CAC41A8", hash_generated_field = "589AC6E67EEDC8ABFD20242996FB9ED2")

    private boolean mReverse;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.652 -0400", hash_original_field = "06C1DC6DB6A0E567DBC1AE1191EA3893", hash_generated_field = "B83C8955E1DA3FA0CE0799F8A1CE7B42")

    private long mStartTimeMillis;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.652 -0400", hash_original_field = "EDE7DB5B0C4E79BD52B42E685F59B951", hash_generated_field = "24B6498B57A4DDD67F7E9CE57E59205C")

    private int mFrom;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.653 -0400", hash_original_field = "6F69D0C4D879F039DD614BB6C1B21419", hash_generated_field = "E7DD6E411B4567693D5B14849913048F")

    private int mTo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.654 -0400", hash_original_field = "25395741BFE51A7D136A5C7109AAD2D8", hash_generated_field = "A658ABE5235D82E385D992CF2A9ACD3B")

    private int mDuration;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.654 -0400", hash_original_field = "4C263818ED1EE4BAECC2BAA9218DCD4C", hash_generated_field = "63DA7996CEEB5E2E849F56A3032ADA4C")

    private int mOriginalDuration;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.654 -0400", hash_original_field = "9CC0C3263C2F5A54D93804A95FB61F85", hash_generated_field = "F0AD14C6D1BAF0FD9600F81F877732D7")

    private int mAlpha = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.654 -0400", hash_original_field = "FE86BE5975CEB5DDCB3330F16B6C060D", hash_generated_field = "3D2C4B8BEF089824EBF65466777785F1")

    private boolean mCrossFade;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.654 -0400", hash_original_method = "C5B06968060DB82F171AE45EB2B5A112", hash_generated_method = "96BB954A38E0D98DFDF4DA5977B5DDA9")
    public  TransitionDrawable(Drawable[] layers) {
        this(new TransitionState(null, null, null), layers);
        addTaint(layers[0].getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.655 -0400", hash_original_method = "F9A92C9D3CD4AD3DBA18C1A12C406B85", hash_generated_method = "DD0146F709A79835F04688F1C0174458")
      TransitionDrawable() {
        this(new TransitionState(null, null, null), (Resources)null);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.655 -0400", hash_original_method = "EA80240A8BFE15F4A059DA8EDA5E6B2D", hash_generated_method = "CA9CD85A7D58D0528AF347A62E55241A")
    private  TransitionDrawable(TransitionState state, Resources res) {
        super(state, res);
        addTaint(state.getTaint());
        addTaint(res.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.656 -0400", hash_original_method = "63330FC0726BC441343F8A6C1CE8445A", hash_generated_method = "FF96CDC9011312215B49584D22277CEC")
    private  TransitionDrawable(TransitionState state, Drawable[] layers) {
        super(layers, state);
        addTaint(state.getTaint());
        addTaint(layers[0].getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.656 -0400", hash_original_method = "7DD647D65429090EAAF6E9E0252444A1", hash_generated_method = "799231BF8E25D2CEF7381417135D0014")
    @Override
     LayerState createConstantState(LayerState state, Resources res) {
        LayerState varB4EAC82CA7396A68D541C85D26508E83_499332179 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_499332179 = new TransitionState((TransitionState) state, this, res);
        addTaint(state.getTaint());
        addTaint(res.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_499332179.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_499332179;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.657 -0400", hash_original_method = "97CEB1054BCE489E9912047DDD2569CF", hash_generated_method = "F9D2E61B8448C0EE75387020F1EB758E")
    public void startTransition(int durationMillis) {
        mFrom = 0;
        mTo = 255;
        mAlpha = 0;
        mDuration = mOriginalDuration = durationMillis;
        mReverse = false;
        mTransitionState = TRANSITION_STARTING;
        invalidateSelf();
        
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.657 -0400", hash_original_method = "08F42BFD1EBF12CF3276DCDF0956FF23", hash_generated_method = "01E2910E8D9B446F13286E8FD4E61ED2")
    public void resetTransition() {
        mAlpha = 0;
        mTransitionState = TRANSITION_NONE;
        invalidateSelf();
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.658 -0400", hash_original_method = "46AFBEEBA20F3F34CF5FEC703E9F1E57", hash_generated_method = "957D1BEA3D9731AFBA31F220B9001617")
    public void reverseTransition(int duration) {
        final long time = SystemClock.uptimeMillis();
        {
            {
                mFrom = 0;
                mTo = 255;
                mAlpha = 0;
                mReverse = false;
            } 
            {
                mFrom = 255;
                mTo = 0;
                mAlpha = 255;
                mReverse = true;
            } 
            mDuration = mOriginalDuration = duration;
            mTransitionState = TRANSITION_STARTING;
            invalidateSelf();
        } 
        mReverse = !mReverse;
        mFrom = mAlpha;
        mTo = mReverse ? 0 : 255;
        mDuration = (int) (mReverse ? time - mStartTimeMillis :
                mOriginalDuration - (time - mStartTimeMillis));
        mTransitionState = TRANSITION_STARTING;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.659 -0400", hash_original_method = "1FBAB3689755625C733FF3C6D865C65F", hash_generated_method = "858AFE4FDB0715E567B88174960E78B1")
    @Override
    public void draw(Canvas canvas) {
        boolean done = true;
        
        mStartTimeMillis = SystemClock.uptimeMillis();
        
        
        done = false;
        
        
        mTransitionState = TRANSITION_RUNNING;
        
        
        {
            float normalized = (float)
                            (SystemClock.uptimeMillis() - mStartTimeMillis) / mDuration;
            done = normalized >= 1.0f;
            normalized = Math.min(normalized, 1.0f);
            mAlpha = (int) (mFrom  + (mTo - mFrom) * normalized);
        } 
        
        final int alpha = mAlpha;
        final boolean crossFade = mCrossFade;
        final ChildDrawable[] array = mLayerState.mChildren;
        {
            {
                array[0].mDrawable.draw(canvas);
            } 
            {
                array[1].mDrawable.draw(canvas);
            } 
        } 
        Drawable d;
        d = array[0].mDrawable;
        {
            d.setAlpha(255 - alpha);
        } 
        d.draw(canvas);
        {
            d.setAlpha(0xFF);
        } 
        {
            d = array[1].mDrawable;
            d.setAlpha(alpha);
            d.draw(canvas);
            d.setAlpha(0xFF);
        } 
        {
            invalidateSelf();
        } 
        addTaint(canvas.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.660 -0400", hash_original_method = "2CD6D3E73358D8CBD280E6EE92F2D07C", hash_generated_method = "2A0623106A5089E5FAC47F6638E31C5E")
    public void setCrossFadeEnabled(boolean enabled) {
        mCrossFade = enabled;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.660 -0400", hash_original_method = "CD2EAE34D95290C8C0E6CBB8BD3A8C00", hash_generated_method = "3E0913A7DB5C388DBBD0858387DFFDE2")
    public boolean isCrossFadeEnabled() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_50661179 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_50661179;
        
        
    }

    
    static class TransitionState extends LayerState {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.660 -0400", hash_original_method = "F1D0B45B3E25602A3478E0025FE64518", hash_generated_method = "904AF51CC161E73E834B771DADA61296")
          TransitionState(TransitionState orig, TransitionDrawable owner,
                Resources res) {
            super(orig, owner, res);
            addTaint(orig.getTaint());
            addTaint(owner.getTaint());
            addTaint(res.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.661 -0400", hash_original_method = "74F5798AEA04A77B6E31B76C53519B4C", hash_generated_method = "C4CC5FF8C1E7FB99C3F7A4D854135421")
        @Override
        public Drawable newDrawable() {
            Drawable varB4EAC82CA7396A68D541C85D26508E83_532230157 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_532230157 = new TransitionDrawable(this, (Resources)null);
            varB4EAC82CA7396A68D541C85D26508E83_532230157.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_532230157;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.662 -0400", hash_original_method = "2864DA5070788F66F2135B6D59FADE5D", hash_generated_method = "8C952E0AF1D04164F8FC45E8789DF5E4")
        @Override
        public Drawable newDrawable(Resources res) {
            Drawable varB4EAC82CA7396A68D541C85D26508E83_1163146591 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1163146591 = new TransitionDrawable(this, res);
            addTaint(res.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1163146591.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1163146591;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.662 -0400", hash_original_method = "9E7D7C67EAC365FF19BD4971762612A5", hash_generated_method = "344B5C7BC0C074F7041CE9AB53DA2F3E")
        @Override
        public int getChangingConfigurations() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_581507943 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_581507943;
            
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.662 -0400", hash_original_field = "99F4F884549DF7DED5FD87C6CD079884", hash_generated_field = "1A633D536EE3F439C073F10EBA919A97")

    private static final int TRANSITION_STARTING = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.662 -0400", hash_original_field = "31A8D263187C21143B9D5E2F830DCCD2", hash_generated_field = "D6BAF07E7FDE629B17C0001BE3132290")

    private static final int TRANSITION_RUNNING = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:33.662 -0400", hash_original_field = "14B56706A40CD3E949C9B658F0CEEAC4", hash_generated_field = "0E71F11924CBF54A46E740E3338A6F34")

    private static final int TRANSITION_NONE = 2;
}

