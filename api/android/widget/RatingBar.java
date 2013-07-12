package android.widget;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.shapes.RectShape;
import android.graphics.drawable.shapes.Shape;
import android.util.AttributeSet;
import com.android.internal.R;

public class RatingBar extends AbsSeekBar {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.193 -0400", hash_original_field = "363D0777077E57DB14FD78240A95F5D1", hash_generated_field = "41FB5B10B91C91607A37B16172D7BB7B")

    private int mNumStars = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.193 -0400", hash_original_field = "05022DE7C184DCE58C4731645B8098FF", hash_generated_field = "29069870A57CAD9CDBBA4A9B273494B8")

    private int mProgressOnStartTracking;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.193 -0400", hash_original_field = "7DEBD693AAB84E4B40F94DB43FDD63FB", hash_generated_field = "26FA5FE396DAB5C7A7F6142358E24340")

    private OnRatingBarChangeListener mOnRatingBarChangeListener;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.194 -0400", hash_original_method = "938147F53CB460240E2DF1224551ED40", hash_generated_method = "3D0FC0536E70EC6A46844EF0EADFBAF9")
    public  RatingBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        addTaint(defStyle);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.RatingBar,
                defStyle, 0);
        final int numStars = a.getInt(R.styleable.RatingBar_numStars, mNumStars);
        setIsIndicator(a.getBoolean(R.styleable.RatingBar_isIndicator, !mIsUserSeekable));
        final float rating = a.getFloat(R.styleable.RatingBar_rating, -1);
        final float stepSize = a.getFloat(R.styleable.RatingBar_stepSize, -1);
        a.recycle();
    if(numStars > 0 && numStars != mNumStars)        
        {
            setNumStars(numStars);
        } 
    if(stepSize >= 0)        
        {
            setStepSize(stepSize);
        } 
        else
        {
            setStepSize(0.5f);
        } 
    if(rating >= 0)        
        {
            setRating(rating);
        } 
        mTouchProgressOffset = 1.1f;
        
        
                
        
        
        
        
        
        
            
        
        
            
        
            
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.194 -0400", hash_original_method = "C497D2C446013A8A61B261C3CBB506B4", hash_generated_method = "0A2B05BBC4FC9CB95BAEBEF3F6E9F127")
    public  RatingBar(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.ratingBarStyle);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.195 -0400", hash_original_method = "D42949600C8B60C6F46AA1F41FAE4EFB", hash_generated_method = "D2A1F8453254063501F518FB3CF6FD6C")
    public  RatingBar(Context context) {
        this(context, null);
        addTaint(context.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.195 -0400", hash_original_method = "CB44A4D2B638D14CC961BB9C350C60D5", hash_generated_method = "0C38E6D8F5DE50714CF4743825B12928")
    public void setOnRatingBarChangeListener(OnRatingBarChangeListener listener) {
        mOnRatingBarChangeListener = listener;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.195 -0400", hash_original_method = "695CB7B11E4FD58B096410402E370F4D", hash_generated_method = "661F8BA377C7887CC6DD0D895AE8B5BD")
    public OnRatingBarChangeListener getOnRatingBarChangeListener() {
OnRatingBarChangeListener varFABA60AF3E094144B7F538EC93E33703_1414489260 =         mOnRatingBarChangeListener;
        varFABA60AF3E094144B7F538EC93E33703_1414489260.addTaint(taint);
        return varFABA60AF3E094144B7F538EC93E33703_1414489260;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.196 -0400", hash_original_method = "3FF2593F21D7D3B2493BC4219B0E4596", hash_generated_method = "6D0D1563E0ECA110419C5FE774815B77")
    public void setIsIndicator(boolean isIndicator) {
        addTaint(isIndicator);
        mIsUserSeekable = !isIndicator;
        setFocusable(!isIndicator);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.196 -0400", hash_original_method = "874639FDA9C4F98AD3BF38D7B6BE89CD", hash_generated_method = "7E2326106C273FEC87A9B6B66B907BC8")
    public boolean isIndicator() {
        boolean varC6A597318EF09C03CCEF65798B9CBD4E_1871615935 = (!mIsUserSeekable);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1293095689 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1293095689;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.197 -0400", hash_original_method = "AEDBB722302E662B30772E575795E285", hash_generated_method = "607A92C38F74CB697B0B699326171492")
    public void setNumStars(final int numStars) {
    if(numStars <= 0)        
        {
            return;
        } 
        mNumStars = numStars;
        requestLayout();
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.197 -0400", hash_original_method = "D4C4902F9D646F6CD3B3EB2FB6EFDC13", hash_generated_method = "33B13D36A6962A78623A84FCA19C8A9A")
    public int getNumStars() {
        int var040414DF8719A630C798855CE8016CFC_1161246750 = (mNumStars);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1333971914 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1333971914;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.197 -0400", hash_original_method = "4B12106E3623F8927849B5EF91E272B5", hash_generated_method = "08CE3BB407B0557DD948B55C8A4AD0F6")
    public void setRating(float rating) {
        addTaint(rating);
        setProgress(Math.round(rating * getProgressPerStar()));
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.198 -0400", hash_original_method = "EA1852BE7B44A888483D4F1C620CF769", hash_generated_method = "47645EC309E83CE9B097949DACCF3462")
    public float getRating() {
        float varEBD1E63F546D0DD2F475ED0F89839FB7_599889313 = (getProgress() / getProgressPerStar());
                float var546ADE640B6EDFBC8A086EF31347E768_1617625267 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1617625267;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.198 -0400", hash_original_method = "A3E9B935F0D69FAE2374B5CF03A160E4", hash_generated_method = "C8857E49FBB2F2E20A7320DB65AA9869")
    public void setStepSize(float stepSize) {
        addTaint(stepSize);
    if(stepSize <= 0)        
        {
            return;
        } 
        final float newMax = mNumStars / stepSize;
        final int newProgress = (int) (newMax / getMax() * getProgress());
        setMax((int) newMax);
        setProgress(newProgress);
        
        
            
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.199 -0400", hash_original_method = "2ABC51A03E553FCA3CBD93E8294B1CB6", hash_generated_method = "FD6A1B54E18E5C7B548468BB7C0F1182")
    public float getStepSize() {
        float var12A311619CA29E033C872452AE0D62E8_1823386985 = ((float) getNumStars() / getMax());
                float var546ADE640B6EDFBC8A086EF31347E768_1308812518 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1308812518;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.199 -0400", hash_original_method = "3A53F1CA5B2034CF32272EC34B36C37A", hash_generated_method = "A5B3C31A636E61245200164F33D5EB01")
    private float getProgressPerStar() {
    if(mNumStars > 0)        
        {
            float var90BBA35586B272EB97143C6DB36B5B39_1245693672 = (1f * getMax() / mNumStars);
                        float var546ADE640B6EDFBC8A086EF31347E768_403337325 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_403337325;
        } 
        else
        {
            float varC4CA4238A0B923820DCC509A6F75849B_1561466867 = (1);
                        float var546ADE640B6EDFBC8A086EF31347E768_153153948 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_153153948;
        } 
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.200 -0400", hash_original_method = "505263BDF0A0C38F11468B8B577065DB", hash_generated_method = "54ECF1B6C1BAD315F84A455FDE720506")
    @Override
     Shape getDrawableShape() {
Shape varFD572D5AD6370B39B60D854340119E95_2088619985 =         new RectShape();
        varFD572D5AD6370B39B60D854340119E95_2088619985.addTaint(taint);
        return varFD572D5AD6370B39B60D854340119E95_2088619985;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.201 -0400", hash_original_method = "9369317EE923D808BCA8DA286976E63F", hash_generated_method = "39BBDA924FDDE1F87615758333DFE2C9")
    @Override
     void onProgressRefresh(float scale, boolean fromUser) {
        
        addTaint(fromUser);
        addTaint(scale);
        super.onProgressRefresh(scale, fromUser);
        updateSecondaryProgress(getProgress());
    if(!fromUser)        
        {
            dispatchRatingChange(false);
        } 
        
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.202 -0400", hash_original_method = "8E49EEB31BBD9AD69349C4C139B0ADB3", hash_generated_method = "2DABF9E1533100A98DE68A36C815A320")
    private void updateSecondaryProgress(int progress) {
        addTaint(progress);
        final float ratio = getProgressPerStar();
    if(ratio > 0)        
        {
            final float progressInStars = progress / ratio;
            final int secondaryProgress = (int) (Math.ceil(progressInStars) * ratio);
            setSecondaryProgress(secondaryProgress);
        } 
        
        
        
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.202 -0400", hash_original_method = "A52B21EAEA0ABEA842DCABF14BA9A11D", hash_generated_method = "67DB17559D1E74C39015499BDC5A5A68")
    @Override
    protected synchronized void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        
        addTaint(heightMeasureSpec);
        addTaint(widthMeasureSpec);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    if(mSampleTile != null)        
        {
            final int width = mSampleTile.getWidth() * mNumStars;
            setMeasuredDimension(resolveSizeAndState(width, widthMeasureSpec, 0),
                    getMeasuredHeight());
        } 
        
        
        
            
            
                    
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.203 -0400", hash_original_method = "226C4EA3B37AD5190041539897D2C6DD", hash_generated_method = "D46B39EED2C3FCB544AE1F9ECD553F30")
    @Override
     void onStartTrackingTouch() {
        
        mProgressOnStartTracking = getProgress();
        super.onStartTrackingTouch();
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.203 -0400", hash_original_method = "6235EE5490022867BAEF4FF5BA6A4578", hash_generated_method = "D6C3487AA022ECAA17D432F9D9179C29")
    @Override
     void onStopTrackingTouch() {
        
        super.onStopTrackingTouch();
    if(getProgress() != mProgressOnStartTracking)        
        {
            dispatchRatingChange(true);
        } 
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.203 -0400", hash_original_method = "90A55B8149F7E0DE715F35412D64649C", hash_generated_method = "7BA0FC9D64756D08AFC36F4673AD7D4C")
    @Override
     void onKeyChange() {
        
        super.onKeyChange();
        dispatchRatingChange(true);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.203 -0400", hash_original_method = "BACFB5351B8F09A10BE81590146F8D2A", hash_generated_method = "4D4D00C28D48EC6EA5AFC71315DA16B5")
     void dispatchRatingChange(boolean fromUser) {
        addTaint(fromUser);
    if(mOnRatingBarChangeListener != null)        
        {
            mOnRatingBarChangeListener.onRatingChanged(this, getRating(),
                    fromUser);
        } 
        
        
            
                    
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.204 -0400", hash_original_method = "0784AE840DC17E48B7292220CB837BFB", hash_generated_method = "79D0EABF6C35426B5ADA6CE9FDBAEE39")
    @Override
    public synchronized void setMax(int max) {
        addTaint(max);
    if(max <= 0)        
        {
            return;
        } 
        super.setMax(max);
        
        
            
        
        
    }

    
    public interface OnRatingBarChangeListener {
        
        
        void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser);

    }
    
}

