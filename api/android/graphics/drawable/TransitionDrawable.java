package android.graphics.drawable;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.os.SystemClock;

public class TransitionDrawable extends LayerDrawable implements Drawable.Callback {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.851 -0400", hash_original_field = "A7B20EF19631195D4CD5E5E59BE8ED91", hash_generated_field = "D70F55987D084695053B74ED3F9477FE")

    private int mTransitionState = TRANSITION_NONE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.851 -0400", hash_original_field = "AB79369A0ECA69C81F7483142CAC41A8", hash_generated_field = "589AC6E67EEDC8ABFD20242996FB9ED2")

    private boolean mReverse;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.851 -0400", hash_original_field = "06C1DC6DB6A0E567DBC1AE1191EA3893", hash_generated_field = "B83C8955E1DA3FA0CE0799F8A1CE7B42")

    private long mStartTimeMillis;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.851 -0400", hash_original_field = "EDE7DB5B0C4E79BD52B42E685F59B951", hash_generated_field = "24B6498B57A4DDD67F7E9CE57E59205C")

    private int mFrom;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.852 -0400", hash_original_field = "6F69D0C4D879F039DD614BB6C1B21419", hash_generated_field = "E7DD6E411B4567693D5B14849913048F")

    private int mTo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.852 -0400", hash_original_field = "25395741BFE51A7D136A5C7109AAD2D8", hash_generated_field = "A658ABE5235D82E385D992CF2A9ACD3B")

    private int mDuration;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.852 -0400", hash_original_field = "4C263818ED1EE4BAECC2BAA9218DCD4C", hash_generated_field = "63DA7996CEEB5E2E849F56A3032ADA4C")

    private int mOriginalDuration;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.852 -0400", hash_original_field = "9CC0C3263C2F5A54D93804A95FB61F85", hash_generated_field = "F0AD14C6D1BAF0FD9600F81F877732D7")

    private int mAlpha = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.852 -0400", hash_original_field = "FE86BE5975CEB5DDCB3330F16B6C060D", hash_generated_field = "3D2C4B8BEF089824EBF65466777785F1")

    private boolean mCrossFade;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.853 -0400", hash_original_method = "C5B06968060DB82F171AE45EB2B5A112", hash_generated_method = "96BB954A38E0D98DFDF4DA5977B5DDA9")
    public  TransitionDrawable(Drawable[] layers) {
        this(new TransitionState(null, null, null), layers);
        addTaint(layers[0].getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.853 -0400", hash_original_method = "F9A92C9D3CD4AD3DBA18C1A12C406B85", hash_generated_method = "DD0146F709A79835F04688F1C0174458")
      TransitionDrawable() {
        this(new TransitionState(null, null, null), (Resources)null);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.854 -0400", hash_original_method = "EA80240A8BFE15F4A059DA8EDA5E6B2D", hash_generated_method = "783646D46B8A867D755590D4F91771E7")
    private  TransitionDrawable(TransitionState state, Resources res) {
        super(state, res);
        addTaint(res.getTaint());
        addTaint(state.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.854 -0400", hash_original_method = "63330FC0726BC441343F8A6C1CE8445A", hash_generated_method = "420E6B132C9C9B47A613EB096B3CB9C3")
    private  TransitionDrawable(TransitionState state, Drawable[] layers) {
        super(layers, state);
        addTaint(layers[0].getTaint());
        addTaint(state.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.854 -0400", hash_original_method = "7DD647D65429090EAAF6E9E0252444A1", hash_generated_method = "0E54E39C51CE246207F04421FABC92D5")
    @Override
     LayerState createConstantState(LayerState state, Resources res) {
        addTaint(res.getTaint());
        addTaint(state.getTaint());
LayerState varFFA472989BFBC8AFAFFFC0942052C9D3_887684586 =         new TransitionState((TransitionState) state, this, res);
        varFFA472989BFBC8AFAFFFC0942052C9D3_887684586.addTaint(taint);
        return varFFA472989BFBC8AFAFFFC0942052C9D3_887684586;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.855 -0400", hash_original_method = "97CEB1054BCE489E9912047DDD2569CF", hash_generated_method = "F9D2E61B8448C0EE75387020F1EB758E")
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.856 -0400", hash_original_method = "08F42BFD1EBF12CF3276DCDF0956FF23", hash_generated_method = "01E2910E8D9B446F13286E8FD4E61ED2")
    public void resetTransition() {
        mAlpha = 0;
        mTransitionState = TRANSITION_NONE;
        invalidateSelf();
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.857 -0400", hash_original_method = "46AFBEEBA20F3F34CF5FEC703E9F1E57", hash_generated_method = "20C9EC76B5FC8287A5A5E6DFDF51AF6B")
    public void reverseTransition(int duration) {
        final long time = SystemClock.uptimeMillis();
    if(time - mStartTimeMillis > mDuration)        
        {
    if(mTo == 0)            
            {
                mFrom = 0;
                mTo = 255;
                mAlpha = 0;
                mReverse = false;
            } 
            else
            {
                mFrom = 255;
                mTo = 0;
                mAlpha = 255;
                mReverse = true;
            } 
            mDuration = mOriginalDuration = duration;
            mTransitionState = TRANSITION_STARTING;
            invalidateSelf();
            return;
        } 
        mReverse = !mReverse;
        mFrom = mAlpha;
        mTo = mReverse ? 0 : 255;
        mDuration = (int) (mReverse ? time - mStartTimeMillis :
                mOriginalDuration - (time - mStartTimeMillis));
        mTransitionState = TRANSITION_STARTING;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.859 -0400", hash_original_method = "1FBAB3689755625C733FF3C6D865C65F", hash_generated_method = "437D900A71B2C5DEBF93B2342ED6AF4C")
    @Override
    public void draw(Canvas canvas) {
        addTaint(canvas.getTaint());
        boolean done = true;
switch(mTransitionState){
        case TRANSITION_STARTING:
        mStartTimeMillis = SystemClock.uptimeMillis();
        done = false;
        mTransitionState = TRANSITION_RUNNING;
        break;
        case TRANSITION_RUNNING:
    if(mStartTimeMillis >= 0)        
        {
            float normalized = (float)
                            (SystemClock.uptimeMillis() - mStartTimeMillis) / mDuration;
            done = normalized >= 1.0f;
            normalized = Math.min(normalized, 1.0f);
            mAlpha = (int) (mFrom  + (mTo - mFrom) * normalized);
        } 
        break;
}        final int alpha = mAlpha;
        final boolean crossFade = mCrossFade;
        final ChildDrawable[] array = mLayerState.mChildren;
    if(done)        
        {
    if(!crossFade || alpha == 0)            
            {
                array[0].mDrawable.draw(canvas);
            } 
    if(alpha == 0xFF)            
            {
                array[1].mDrawable.draw(canvas);
            } 
            return;
        } 
        Drawable d;
        d = array[0].mDrawable;
    if(crossFade)        
        {
            d.setAlpha(255 - alpha);
        } 
        d.draw(canvas);
    if(crossFade)        
        {
            d.setAlpha(0xFF);
        } 
    if(alpha > 0)        
        {
            d = array[1].mDrawable;
            d.setAlpha(alpha);
            d.draw(canvas);
            d.setAlpha(0xFF);
        } 
    if(!done)        
        {
            invalidateSelf();
        } 
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.860 -0400", hash_original_method = "2CD6D3E73358D8CBD280E6EE92F2D07C", hash_generated_method = "2A0623106A5089E5FAC47F6638E31C5E")
    public void setCrossFadeEnabled(boolean enabled) {
        mCrossFade = enabled;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.860 -0400", hash_original_method = "CD2EAE34D95290C8C0E6CBB8BD3A8C00", hash_generated_method = "562DD29BA0DFB8CD3B2245AF831050F6")
    public boolean isCrossFadeEnabled() {
        boolean varFE86BE5975CEB5DDCB3330F16B6C060D_457303077 = (mCrossFade);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1535328437 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1535328437;
        
        
    }

    
    static class TransitionState extends LayerState {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.861 -0400", hash_original_method = "F1D0B45B3E25602A3478E0025FE64518", hash_generated_method = "4C0EC10F321A055E513D635268A6AFC3")
          TransitionState(TransitionState orig, TransitionDrawable owner,
                Resources res) {
            super(orig, owner, res);
            addTaint(res.getTaint());
            addTaint(owner.getTaint());
            addTaint(orig.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.862 -0400", hash_original_method = "74F5798AEA04A77B6E31B76C53519B4C", hash_generated_method = "DEB35AAA9765A476D90A63B71BD47560")
        @Override
        public Drawable newDrawable() {
Drawable varF0BC0AD4EF24A0E6AA445EF832DC562E_365660618 =             new TransitionDrawable(this, (Resources)null);
            varF0BC0AD4EF24A0E6AA445EF832DC562E_365660618.addTaint(taint);
            return varF0BC0AD4EF24A0E6AA445EF832DC562E_365660618;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.862 -0400", hash_original_method = "2864DA5070788F66F2135B6D59FADE5D", hash_generated_method = "42F8AFD12ABDCA5AA62BD4FA213D1415")
        @Override
        public Drawable newDrawable(Resources res) {
            addTaint(res.getTaint());
Drawable var48E8606C81CF3892E5F36CD4FED5C949_1521783010 =             new TransitionDrawable(this, res);
            var48E8606C81CF3892E5F36CD4FED5C949_1521783010.addTaint(taint);
            return var48E8606C81CF3892E5F36CD4FED5C949_1521783010;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.863 -0400", hash_original_method = "9E7D7C67EAC365FF19BD4971762612A5", hash_generated_method = "D5DE744BA1697487978A4A0072003B5F")
        @Override
        public int getChangingConfigurations() {
            int var276E0645C4E2084773D0EB8C5576428C_2114397542 = (mChangingConfigurations);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1779585037 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1779585037;
            
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.864 -0400", hash_original_field = "99F4F884549DF7DED5FD87C6CD079884", hash_generated_field = "1A633D536EE3F439C073F10EBA919A97")

    private static final int TRANSITION_STARTING = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.864 -0400", hash_original_field = "31A8D263187C21143B9D5E2F830DCCD2", hash_generated_field = "D6BAF07E7FDE629B17C0001BE3132290")

    private static final int TRANSITION_RUNNING = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.864 -0400", hash_original_field = "14B56706A40CD3E949C9B658F0CEEAC4", hash_generated_field = "0E71F11924CBF54A46E740E3338A6F34")

    private static final int TRANSITION_NONE = 2;
}

