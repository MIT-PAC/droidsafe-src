package android.graphics.drawable;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.os.SystemClock;

public class TransitionDrawable extends LayerDrawable implements Drawable.Callback {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.447 -0400", hash_original_field = "A7B20EF19631195D4CD5E5E59BE8ED91", hash_generated_field = "D70F55987D084695053B74ED3F9477FE")

    private int mTransitionState = TRANSITION_NONE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.447 -0400", hash_original_field = "AB79369A0ECA69C81F7483142CAC41A8", hash_generated_field = "589AC6E67EEDC8ABFD20242996FB9ED2")

    private boolean mReverse;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.447 -0400", hash_original_field = "06C1DC6DB6A0E567DBC1AE1191EA3893", hash_generated_field = "B83C8955E1DA3FA0CE0799F8A1CE7B42")

    private long mStartTimeMillis;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.447 -0400", hash_original_field = "EDE7DB5B0C4E79BD52B42E685F59B951", hash_generated_field = "24B6498B57A4DDD67F7E9CE57E59205C")

    private int mFrom;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.448 -0400", hash_original_field = "6F69D0C4D879F039DD614BB6C1B21419", hash_generated_field = "E7DD6E411B4567693D5B14849913048F")

    private int mTo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.458 -0400", hash_original_field = "25395741BFE51A7D136A5C7109AAD2D8", hash_generated_field = "A658ABE5235D82E385D992CF2A9ACD3B")

    private int mDuration;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.458 -0400", hash_original_field = "4C263818ED1EE4BAECC2BAA9218DCD4C", hash_generated_field = "63DA7996CEEB5E2E849F56A3032ADA4C")

    private int mOriginalDuration;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.458 -0400", hash_original_field = "9CC0C3263C2F5A54D93804A95FB61F85", hash_generated_field = "F0AD14C6D1BAF0FD9600F81F877732D7")

    private int mAlpha = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.459 -0400", hash_original_field = "FE86BE5975CEB5DDCB3330F16B6C060D", hash_generated_field = "3D2C4B8BEF089824EBF65466777785F1")

    private boolean mCrossFade;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.459 -0400", hash_original_method = "C5B06968060DB82F171AE45EB2B5A112", hash_generated_method = "96BB954A38E0D98DFDF4DA5977B5DDA9")
    public  TransitionDrawable(Drawable[] layers) {
        this(new TransitionState(null, null, null), layers);
        addTaint(layers[0].getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.459 -0400", hash_original_method = "F9A92C9D3CD4AD3DBA18C1A12C406B85", hash_generated_method = "DD0146F709A79835F04688F1C0174458")
      TransitionDrawable() {
        this(new TransitionState(null, null, null), (Resources)null);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.460 -0400", hash_original_method = "EA80240A8BFE15F4A059DA8EDA5E6B2D", hash_generated_method = "CA9CD85A7D58D0528AF347A62E55241A")
    private  TransitionDrawable(TransitionState state, Resources res) {
        super(state, res);
        addTaint(state.getTaint());
        addTaint(res.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.464 -0400", hash_original_method = "63330FC0726BC441343F8A6C1CE8445A", hash_generated_method = "FF96CDC9011312215B49584D22277CEC")
    private  TransitionDrawable(TransitionState state, Drawable[] layers) {
        super(layers, state);
        addTaint(state.getTaint());
        addTaint(layers[0].getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.465 -0400", hash_original_method = "7DD647D65429090EAAF6E9E0252444A1", hash_generated_method = "EA86139AE0F6D659204AA767460E2CBD")
    @Override
     LayerState createConstantState(LayerState state, Resources res) {
        LayerState varB4EAC82CA7396A68D541C85D26508E83_1739522531 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1739522531 = new TransitionState((TransitionState) state, this, res);
        addTaint(state.getTaint());
        addTaint(res.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1739522531.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1739522531;
        // ---------- Original Method ----------
        //return new TransitionState((TransitionState) state, this, res);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.474 -0400", hash_original_method = "97CEB1054BCE489E9912047DDD2569CF", hash_generated_method = "F9D2E61B8448C0EE75387020F1EB758E")
    public void startTransition(int durationMillis) {
        mFrom = 0;
        mTo = 255;
        mAlpha = 0;
        mDuration = mOriginalDuration = durationMillis;
        mReverse = false;
        mTransitionState = TRANSITION_STARTING;
        invalidateSelf();
        // ---------- Original Method ----------
        //mFrom = 0;
        //mTo = 255;
        //mAlpha = 0;
        //mDuration = mOriginalDuration = durationMillis;
        //mReverse = false;
        //mTransitionState = TRANSITION_STARTING;
        //invalidateSelf();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.477 -0400", hash_original_method = "08F42BFD1EBF12CF3276DCDF0956FF23", hash_generated_method = "01E2910E8D9B446F13286E8FD4E61ED2")
    public void resetTransition() {
        mAlpha = 0;
        mTransitionState = TRANSITION_NONE;
        invalidateSelf();
        // ---------- Original Method ----------
        //mAlpha = 0;
        //mTransitionState = TRANSITION_NONE;
        //invalidateSelf();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.505 -0400", hash_original_method = "46AFBEEBA20F3F34CF5FEC703E9F1E57", hash_generated_method = "31CDC8B9ED6D27B31FAFC43FC34B936D")
    public void reverseTransition(int duration) {
        long time;
        time = SystemClock.uptimeMillis();
        {
            {
                mFrom = 0;
                mTo = 255;
                mAlpha = 0;
                mReverse = false;
            } //End block
            {
                mFrom = 255;
                mTo = 0;
                mAlpha = 255;
                mReverse = true;
            } //End block
            mDuration = mOriginalDuration = duration;
            mTransitionState = TRANSITION_STARTING;
            invalidateSelf();
        } //End block
        mReverse = !mReverse;
        mFrom = mAlpha;
        mTo = mReverse ? 0 : 255;
        mDuration = (int) (mReverse ? time - mStartTimeMillis :
                mOriginalDuration - (time - mStartTimeMillis));
        mTransitionState = TRANSITION_STARTING;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.544 -0400", hash_original_method = "1FBAB3689755625C733FF3C6D865C65F", hash_generated_method = "3347E172B5B4F2F854E6A47D3E016AD4")
    @Override
    public void draw(Canvas canvas) {
        boolean done;
        done = true;
        //Begin case TRANSITION_STARTING 
        mStartTimeMillis = SystemClock.uptimeMillis();
        //End case TRANSITION_STARTING 
        //Begin case TRANSITION_STARTING 
        done = false;
        //End case TRANSITION_STARTING 
        //Begin case TRANSITION_STARTING 
        mTransitionState = TRANSITION_RUNNING;
        //End case TRANSITION_STARTING 
        //Begin case TRANSITION_RUNNING 
        {
            float normalized;
            normalized = (float)
                            (SystemClock.uptimeMillis() - mStartTimeMillis) / mDuration;
            done = normalized >= 1.0f;
            normalized = Math.min(normalized, 1.0f);
            mAlpha = (int) (mFrom  + (mTo - mFrom) * normalized);
        } //End block
        //End case TRANSITION_RUNNING 
        int alpha;
        alpha = mAlpha;
        boolean crossFade;
        crossFade = mCrossFade;
        ChildDrawable[] array;
        array = mLayerState.mChildren;
        {
            {
                array[0].mDrawable.draw(canvas);
            } //End block
            {
                array[1].mDrawable.draw(canvas);
            } //End block
        } //End block
        Drawable d;
        d = array[0].mDrawable;
        {
            d.setAlpha(255 - alpha);
        } //End block
        d.draw(canvas);
        {
            d.setAlpha(0xFF);
        } //End block
        {
            d = array[1].mDrawable;
            d.setAlpha(alpha);
            d.draw(canvas);
            d.setAlpha(0xFF);
        } //End block
        {
            invalidateSelf();
        } //End block
        addTaint(canvas.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.545 -0400", hash_original_method = "2CD6D3E73358D8CBD280E6EE92F2D07C", hash_generated_method = "2A0623106A5089E5FAC47F6638E31C5E")
    public void setCrossFadeEnabled(boolean enabled) {
        mCrossFade = enabled;
        // ---------- Original Method ----------
        //mCrossFade = enabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.545 -0400", hash_original_method = "CD2EAE34D95290C8C0E6CBB8BD3A8C00", hash_generated_method = "293234CC21D9965B91B40BAE1EE255A6")
    public boolean isCrossFadeEnabled() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_154872498 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_154872498;
        // ---------- Original Method ----------
        //return mCrossFade;
    }

    
    static class TransitionState extends LayerState {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.557 -0400", hash_original_method = "F1D0B45B3E25602A3478E0025FE64518", hash_generated_method = "904AF51CC161E73E834B771DADA61296")
          TransitionState(TransitionState orig, TransitionDrawable owner,
                Resources res) {
            super(orig, owner, res);
            addTaint(orig.getTaint());
            addTaint(owner.getTaint());
            addTaint(res.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.557 -0400", hash_original_method = "74F5798AEA04A77B6E31B76C53519B4C", hash_generated_method = "6D8421B964C91378779D98DA67C4C8DC")
        @Override
        public Drawable newDrawable() {
            Drawable varB4EAC82CA7396A68D541C85D26508E83_1636219511 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1636219511 = new TransitionDrawable(this, (Resources)null);
            varB4EAC82CA7396A68D541C85D26508E83_1636219511.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1636219511;
            // ---------- Original Method ----------
            //return new TransitionDrawable(this, (Resources)null);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.558 -0400", hash_original_method = "2864DA5070788F66F2135B6D59FADE5D", hash_generated_method = "DAD5B7A3D07CB24B8E0F04554167DE68")
        @Override
        public Drawable newDrawable(Resources res) {
            Drawable varB4EAC82CA7396A68D541C85D26508E83_2132888930 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_2132888930 = new TransitionDrawable(this, res);
            addTaint(res.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_2132888930.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2132888930;
            // ---------- Original Method ----------
            //return new TransitionDrawable(this, res);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.559 -0400", hash_original_method = "9E7D7C67EAC365FF19BD4971762612A5", hash_generated_method = "30C6A78B5759238B13A070D7647F599B")
        @Override
        public int getChangingConfigurations() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2090980034 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2090980034;
            // ---------- Original Method ----------
            //return mChangingConfigurations;
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.560 -0400", hash_original_field = "99F4F884549DF7DED5FD87C6CD079884", hash_generated_field = "C1D2762B493649C52A72272052A5BCA8")

    private static int TRANSITION_STARTING = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.560 -0400", hash_original_field = "31A8D263187C21143B9D5E2F830DCCD2", hash_generated_field = "566055129435E7F09F5D886EE80603FB")

    private static int TRANSITION_RUNNING = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.560 -0400", hash_original_field = "14B56706A40CD3E949C9B658F0CEEAC4", hash_generated_field = "8B14772F8CEDF33A8FFC78CDF9CA6173")

    private static int TRANSITION_NONE = 2;
}

