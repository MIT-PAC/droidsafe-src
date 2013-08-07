package com.android.internal.widget.multiwaveview;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.util.Log;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.ColorFilter;
import android.graphics.drawable.StateListDrawable;
import android.content.res.Resources;
public class TargetDrawable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.041 -0400", hash_original_field = "84EBB369B288C6D0249BEE8BD210B6CD", hash_generated_field = "2AFCF9FBF275B7CD99FE380672FCAD7D")

    private float mTranslationX = 0.0f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.041 -0400", hash_original_field = "F932061B0442A6FE403204386125C309", hash_generated_field = "BB1694683A4F76C68BA06EEF47CA070C")

    private float mTranslationY = 0.0f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.041 -0400", hash_original_field = "13856D8A755FB7F96283A0673DDA6900", hash_generated_field = "384BEA0D42AB64FA4F8EBDEE380C7444")

    private float mScaleX = 1.0f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.041 -0400", hash_original_field = "701DA022FEBE1A233C5E8C8E6CC8CD8C", hash_generated_field = "047AE590FA93629B16F3738468B61503")

    private float mScaleY = 1.0f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.042 -0400", hash_original_field = "DB0F1A416031E07B0F163FB6C08B748E", hash_generated_field = "ACF1F0C7CBA27952A21BCAA4B81CB336")

    private float mAlpha = 1.0f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.042 -0400", hash_original_field = "D548B27C6AC66A9D9B5D05ED35C2D844", hash_generated_field = "F17AF26B1AE93DE0DD2EED2442B6F076")

    private Drawable mDrawable;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.042 -0400", hash_original_method = "F912A6C08331453B52BDE21F1B474C4B", hash_generated_method = "1485E6F319E52A0672B87148D178F99E")
    public  TargetDrawable(Resources res, int resId) {
        this(res, resId == 0 ? null : res.getDrawable(resId));
        addTaint(resId);
        addTaint(res.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.043 -0400", hash_original_method = "70699358D0BDCB98F769637E9AD1C4D5", hash_generated_method = "972AF4962C78B731CCF69DC015762A91")
    public  TargetDrawable(Resources res, Drawable drawable) {
        addTaint(drawable.getTaint());
        addTaint(res.getTaint());
mDrawable=drawable!=null?drawable.mutate():drawable.mutate()resizeDrawables()setState(STATE_INACTIVE)
        // ---------- Original Method ----------
        //mDrawable = drawable != null ? drawable.mutate() : null;
        //resizeDrawables();
        //setState(STATE_INACTIVE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.044 -0400", hash_original_method = "F214D035B5DA7271F8E585B2D1038BED", hash_generated_method = "459E89AC77E53614E33C3C4D95F5DCE1")
    public void setState(int [] state) {
        addTaint(state[0].getTaint());
        if(mDrawable instanceof StateListDrawable)        
        {
            StateListDrawable d = (StateListDrawable) mDrawable;
d.setState(state)
        } //End block
        // ---------- Original Method ----------
        //if (mDrawable instanceof StateListDrawable) {
            //StateListDrawable d = (StateListDrawable) mDrawable;
            //d.setState(state);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.045 -0400", hash_original_method = "3448B7AEF4710E7C9C6D89843BDACBA3", hash_generated_method = "6CE57A177D5A493FD76FD2D75242514B")
    public boolean hasState(int [] state) {
        addTaint(state[0].getTaint());
        if(mDrawable instanceof StateListDrawable)        
        {
            StateListDrawable d = (StateListDrawable) mDrawable;
            boolean var28013B8C5B80C3970304CB564B0DB882_1689349507 = (d.getStateDrawableIndex(state)!=-1);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_496691365 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_496691365;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1143630722 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1472816699 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1472816699;
        // ---------- Original Method ----------
        //if (mDrawable instanceof StateListDrawable) {
            //StateListDrawable d = (StateListDrawable) mDrawable;
            //return d.getStateDrawableIndex(state) != -1;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.047 -0400", hash_original_method = "6451122F4CE5BAF6587559571F9B1C19", hash_generated_method = "0D2AD3CEAD016F7E8599975033227D86")
    public boolean isActive() {
        if(mDrawable instanceof StateListDrawable)        
        {
            StateListDrawable d = (StateListDrawable) mDrawable;
            int[] states = d.getState();
for(int i = 0;i<states.length;i)
            {
                if(states[i]==android.R.attr.state_focused)                
                {
                    boolean varB326B5062B2F0E69046810717534CB09_159766087 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1636377232 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1636377232;
                } //End block
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1871156146 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_355421728 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_355421728;
        // ---------- Original Method ----------
        //if (mDrawable instanceof StateListDrawable) {
            //StateListDrawable d = (StateListDrawable) mDrawable;
            //int[] states = d.getState();
            //for (int i = 0; i < states.length; i++) {
                //if (states[i] == android.R.attr.state_focused) {
                    //return true;
                //}
            //}
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.048 -0400", hash_original_method = "FEAE41047C29839321CF1B77DF80B5A4", hash_generated_method = "4AB84A18FC2B87E588FAA0FA66FA5394")
    public boolean isValid() {
        boolean var779409AFC85C9B77AEA3B3B374AFE15C_1132308459 = (mDrawable!=null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_836800782 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_836800782;
        // ---------- Original Method ----------
        //return mDrawable != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.049 -0400", hash_original_method = "7AD0DAEF613CCFBEF1D5D052D2A87EF7", hash_generated_method = "A1E2289140D877EE6D49C2AF18D5E096")
    private void resizeDrawables() {
        if(mDrawable instanceof StateListDrawable)        
        {
            StateListDrawable d = (StateListDrawable) mDrawable;
            int maxWidth = 0;
            int maxHeight = 0;
for(int i = 0;i<d.getStateCount();i)
            {
                Drawable childDrawable = d.getStateDrawable(i);
maxWidth=Math.max(maxWidth, childDrawable.getIntrinsicWidth())maxHeight=Math.max(maxHeight, childDrawable.getIntrinsicHeight())
            } //End block
            if(DEBUG){ }d.setBounds(0, 0, maxWidth, maxHeight)for(int i = 0;i<d.getStateCount();i)
            {
                Drawable childDrawable = d.getStateDrawable(i);
                if(DEBUG){ }childDrawable.setBounds(0, 0, maxWidth, maxHeight)
            } //End block
        } //End block
        else
        if(mDrawable!=null)        
        {
mDrawable.setBounds(0, 0, mDrawable.getIntrinsicWidth(), mDrawable.getIntrinsicHeight())
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.050 -0400", hash_original_method = "EC2A5990735BBF397E15A41D64FA2F53", hash_generated_method = "4ECF45D3E54A350AF70E0235FBDBFECE")
    public void setX(float x) {
        addTaint(x);
mTranslationX=x
        // ---------- Original Method ----------
        //mTranslationX = x;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.050 -0400", hash_original_method = "D96234E3F8F950CF30BAAF14105BEA03", hash_generated_method = "D96F5DA4D789116BBBFD825A5D4ADF68")
    public void setY(float y) {
        addTaint(y);
mTranslationY=y
        // ---------- Original Method ----------
        //mTranslationY = y;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.051 -0400", hash_original_method = "4821836CDCD33347028194DF87F1D189", hash_generated_method = "DF95DA6F405DD6248AD306FB8FD77F8F")
    public void setScaleX(float x) {
        addTaint(x);
mScaleX=x
        // ---------- Original Method ----------
        //mScaleX = x;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.052 -0400", hash_original_method = "6A6033F0AF6D3B3F86912DE4A5939F0D", hash_generated_method = "79A2509EF5E99A9B47ABBCFD9C02AC22")
    public void setScaleY(float y) {
        addTaint(y);
mScaleY=y
        // ---------- Original Method ----------
        //mScaleY = y;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.052 -0400", hash_original_method = "0C33009713633FC103F0B586FD422009", hash_generated_method = "EE9402B5A0724A8DDAEA4042EB153D5B")
    public void setAlpha(float alpha) {
        addTaint(alpha);
mAlpha=alpha
        // ---------- Original Method ----------
        //mAlpha = alpha;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.053 -0400", hash_original_method = "456A68D0434883A7DFC6442C332883CA", hash_generated_method = "3D71D1D11369A8ABC043BC0408EDB815")
    public float getX() {
        float var84DA840DFF8440409F4BD2104DD4DCB0_1274056998 = (mTranslationX);
                float var546ADE640B6EDFBC8A086EF31347E768_280600594 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_280600594;
        // ---------- Original Method ----------
        //return mTranslationX;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.054 -0400", hash_original_method = "C279ECA26A2E0B9A04991320FED34357", hash_generated_method = "5CD025ED2776FEAF7AD52F1821A06BE9")
    public float getY() {
        float var2FF36DE45B824D67B7F768A7BA5C409A_794645409 = (mTranslationY);
                float var546ADE640B6EDFBC8A086EF31347E768_1220690716 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1220690716;
        // ---------- Original Method ----------
        //return mTranslationY;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.054 -0400", hash_original_method = "77BF1FCCF84378618A90063FAB69ED38", hash_generated_method = "AF39427BF324ED5F61F0CE45364C3F79")
    public float getScaleX() {
        float varA451AE15D9C2A470AAFF3FC8FB4AAA38_864387837 = (mScaleX);
                float var546ADE640B6EDFBC8A086EF31347E768_900902855 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_900902855;
        // ---------- Original Method ----------
        //return mScaleX;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.055 -0400", hash_original_method = "F8DD4522C45935E8A1E94B5BA53FAF41", hash_generated_method = "1CC065E520BD8B7A134BA10FD21B1BF7")
    public float getScaleY() {
        float var1E27D36C99355A55A9FA2E5EAAA90A64_611603992 = (mScaleY);
                float var546ADE640B6EDFBC8A086EF31347E768_1582879283 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1582879283;
        // ---------- Original Method ----------
        //return mScaleY;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.055 -0400", hash_original_method = "84CA63CC358414A9CD87B6516C604402", hash_generated_method = "A217C50BBBC6ABB5E05FD4DA584B2971")
    public float getAlpha() {
        float var7574041472B9B2E76867A37482E74343_2137611989 = (mAlpha);
                float var546ADE640B6EDFBC8A086EF31347E768_1557661927 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1557661927;
        // ---------- Original Method ----------
        //return mAlpha;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.055 -0400", hash_original_method = "3E149D0230AC9807D20163F4E45E91A6", hash_generated_method = "776CF6588F27B30D4249E0DB5FFA7FAE")
    public int getWidth() {
        int varE3A72D766773903D92C7E9B8D502EC77_1448633685 = (mDrawable!=null?mDrawable.getIntrinsicWidth():mDrawable.getIntrinsicWidth());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1782070088 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1782070088;
        // ---------- Original Method ----------
        //return mDrawable != null ? mDrawable.getIntrinsicWidth() : 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.056 -0400", hash_original_method = "8EDE2657D4A8DCBCBEE6E7A20309104D", hash_generated_method = "DA62416AA4742813D0480B33A80D68E4")
    public int getHeight() {
        int varCBD2866B8B97441FB382D20932E0A135_1561078042 = (mDrawable!=null?mDrawable.getIntrinsicHeight():mDrawable.getIntrinsicHeight());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1356168953 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1356168953;
        // ---------- Original Method ----------
        //return mDrawable != null ? mDrawable.getIntrinsicHeight() : 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.056 -0400", hash_original_method = "924B723EBA578E1068B3EE3BB4501609", hash_generated_method = "E75382A582F64871A3110BA8A70BB06F")
    public void draw(Canvas canvas) {
        addTaint(canvas.getTaint());
        if(mDrawable==null)        
        {
            return;
        } //End block
canvas.save(Canvas.MATRIX_SAVE_FLAG)canvas.translate(mTranslationX, mTranslationY)canvas.scale(mScaleX, mScaleY)canvas.translate(-0.5f*getWidth(), -0.5f*getHeight())mDrawable.setAlpha((int) Math.round(mAlpha*255f))mDrawable.draw(canvas)canvas.restore()
        // ---------- Original Method ----------
        //if (mDrawable == null) {
            //return;
        //}
        //canvas.save(Canvas.MATRIX_SAVE_FLAG);
        //canvas.translate(mTranslationX, mTranslationY);
        //canvas.scale(mScaleX, mScaleY);
        //canvas.translate(-0.5f * getWidth(), -0.5f * getHeight());
        //mDrawable.setAlpha((int) Math.round(mAlpha * 255f));
        //mDrawable.draw(canvas);
        //canvas.restore();
    }

    
    static class DrawableWithAlpha extends Drawable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.057 -0400", hash_original_field = "DB0F1A416031E07B0F163FB6C08B748E", hash_generated_field = "ACF1F0C7CBA27952A21BCAA4B81CB336")

        private float mAlpha = 1.0f;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.057 -0400", hash_original_field = "4DC0629A384DEA241058B6C7BD5D6310", hash_generated_field = "18568F058DC7C3077454AAF158EB1899")

        private Drawable mRealDrawable;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.057 -0400", hash_original_method = "287F8018E5BBBF972F61373A208233B1", hash_generated_method = "B35B26FD69BF94F4B61DAF9D3B14C9FF")
        public  DrawableWithAlpha(Drawable realDrawable) {
            addTaint(realDrawable.getTaint());
mRealDrawable=realDrawable
            // ---------- Original Method ----------
            //mRealDrawable = realDrawable;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.057 -0400", hash_original_method = "0C33009713633FC103F0B586FD422009", hash_generated_method = "EE9402B5A0724A8DDAEA4042EB153D5B")
        public void setAlpha(float alpha) {
            addTaint(alpha);
mAlpha=alpha
            // ---------- Original Method ----------
            //mAlpha = alpha;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.058 -0400", hash_original_method = "84CA63CC358414A9CD87B6516C604402", hash_generated_method = "36164A8A2DC45A95742D25FB52A4AAC5")
        public float getAlpha() {
            float var7574041472B9B2E76867A37482E74343_734324298 = (mAlpha);
                        float var546ADE640B6EDFBC8A086EF31347E768_210788825 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_210788825;
            // ---------- Original Method ----------
            //return mAlpha;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.058 -0400", hash_original_method = "689836B909D85953C3BDBEA78BA001D9", hash_generated_method = "05592304A22792F7A93489D05989F35F")
        public void draw(Canvas canvas) {
            addTaint(canvas.getTaint());
mRealDrawable.setAlpha((int) Math.round(mAlpha*255f))mRealDrawable.draw(canvas)
            // ---------- Original Method ----------
            //mRealDrawable.setAlpha((int) Math.round(mAlpha * 255f));
            //mRealDrawable.draw(canvas);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.058 -0400", hash_original_method = "8D5E247D440902A5F423F5A4A396686E", hash_generated_method = "4F3C29C94B66571ABDC30D5ACA0896CE")
        @Override
        public void setAlpha(int alpha) {
            addTaint(alpha);
mRealDrawable.setAlpha(alpha)
            // ---------- Original Method ----------
            //mRealDrawable.setAlpha(alpha);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.059 -0400", hash_original_method = "15507BA635C06044F906BD2C08DD8AD9", hash_generated_method = "7E09A5BAD6F984E225EFD44693562CAE")
        @Override
        public void setColorFilter(ColorFilter cf) {
            addTaint(cf.getTaint());
mRealDrawable.setColorFilter(cf)
            // ---------- Original Method ----------
            //mRealDrawable.setColorFilter(cf);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.059 -0400", hash_original_method = "6CF6F01DEAF3C7650E0F647A67BA9942", hash_generated_method = "ACF05EE571E2E037B68E8BB3A4C280D3")
        @Override
        public int getOpacity() {
            int var4AD3D84F9520303AE33C18FBFEE2AD3C_1238371649 = (mRealDrawable.getOpacity());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_786813778 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_786813778;
            // ---------- Original Method ----------
            //return mRealDrawable.getOpacity();
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.059 -0400", hash_original_field = "1366CB6D32799DF93CE66D8307D2417C", hash_generated_field = "5267BEED2BAFD15AF546A4869D22845D")

    private static final String TAG = "TargetDrawable";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.059 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "58EDF43BA541A4D47EECFEC3901C7AED")

    private static final boolean DEBUG = false;

