package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.shapes.RectShape;
import android.graphics.drawable.shapes.Shape;
import android.util.AttributeSet;
import com.android.internal.R;

public class RatingBar extends AbsSeekBar {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.423 -0400", hash_original_field = "363D0777077E57DB14FD78240A95F5D1", hash_generated_field = "41FB5B10B91C91607A37B16172D7BB7B")

    private int mNumStars = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.423 -0400", hash_original_field = "05022DE7C184DCE58C4731645B8098FF", hash_generated_field = "29069870A57CAD9CDBBA4A9B273494B8")

    private int mProgressOnStartTracking;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.423 -0400", hash_original_field = "7DEBD693AAB84E4B40F94DB43FDD63FB", hash_generated_field = "26FA5FE396DAB5C7A7F6142358E24340")

    private OnRatingBarChangeListener mOnRatingBarChangeListener;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.429 -0400", hash_original_method = "938147F53CB460240E2DF1224551ED40", hash_generated_method = "87957BBFE72EC6C3E19285E154C82E4D")
    public  RatingBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        TypedArray a;
        a = context.obtainStyledAttributes(attrs, R.styleable.RatingBar,
                defStyle, 0);
        int numStars;
        numStars = a.getInt(R.styleable.RatingBar_numStars, mNumStars);
        setIsIndicator(a.getBoolean(R.styleable.RatingBar_isIndicator, !mIsUserSeekable));
        float rating;
        rating = a.getFloat(R.styleable.RatingBar_rating, -1);
        float stepSize;
        stepSize = a.getFloat(R.styleable.RatingBar_stepSize, -1);
        a.recycle();
        {
            setNumStars(numStars);
        } //End block
        {
            setStepSize(stepSize);
        } //End block
        {
            setStepSize(0.5f);
        } //End block
        {
            setRating(rating);
        } //End block
        mTouchProgressOffset = 1.1f;
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        addTaint(defStyle);
        // ---------- Original Method ----------
        //TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.RatingBar,
                //defStyle, 0);
        //final int numStars = a.getInt(R.styleable.RatingBar_numStars, mNumStars);
        //setIsIndicator(a.getBoolean(R.styleable.RatingBar_isIndicator, !mIsUserSeekable));
        //final float rating = a.getFloat(R.styleable.RatingBar_rating, -1);
        //final float stepSize = a.getFloat(R.styleable.RatingBar_stepSize, -1);
        //a.recycle();
        //if (numStars > 0 && numStars != mNumStars) {
            //setNumStars(numStars);            
        //}
        //if (stepSize >= 0) {
            //setStepSize(stepSize);
        //} else {
            //setStepSize(0.5f);
        //}
        //if (rating >= 0) {
            //setRating(rating);
        //}
        //mTouchProgressOffset = 1.1f;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.430 -0400", hash_original_method = "C497D2C446013A8A61B261C3CBB506B4", hash_generated_method = "DEAD15DC1FF5C2C1C379C015050F12E5")
    public  RatingBar(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.ratingBarStyle);
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.430 -0400", hash_original_method = "D42949600C8B60C6F46AA1F41FAE4EFB", hash_generated_method = "D2A1F8453254063501F518FB3CF6FD6C")
    public  RatingBar(Context context) {
        this(context, null);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.431 -0400", hash_original_method = "CB44A4D2B638D14CC961BB9C350C60D5", hash_generated_method = "0C38E6D8F5DE50714CF4743825B12928")
    public void setOnRatingBarChangeListener(OnRatingBarChangeListener listener) {
        mOnRatingBarChangeListener = listener;
        // ---------- Original Method ----------
        //mOnRatingBarChangeListener = listener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.431 -0400", hash_original_method = "695CB7B11E4FD58B096410402E370F4D", hash_generated_method = "04E014544A4AF3A01854ECA45B7E1AD5")
    public OnRatingBarChangeListener getOnRatingBarChangeListener() {
        OnRatingBarChangeListener varB4EAC82CA7396A68D541C85D26508E83_374785692 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_374785692 = mOnRatingBarChangeListener;
        varB4EAC82CA7396A68D541C85D26508E83_374785692.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_374785692;
        // ---------- Original Method ----------
        //return mOnRatingBarChangeListener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.432 -0400", hash_original_method = "3FF2593F21D7D3B2493BC4219B0E4596", hash_generated_method = "F2D587DFE3281D75BCEF80ED24345A2D")
    public void setIsIndicator(boolean isIndicator) {
        mIsUserSeekable = !isIndicator;
        setFocusable(!isIndicator);
        addTaint(isIndicator);
        // ---------- Original Method ----------
        //mIsUserSeekable = !isIndicator;
        //setFocusable(!isIndicator);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.449 -0400", hash_original_method = "874639FDA9C4F98AD3BF38D7B6BE89CD", hash_generated_method = "01323151CA842DCE653706030C5EA59F")
    public boolean isIndicator() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_272868555 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_272868555;
        // ---------- Original Method ----------
        //return !mIsUserSeekable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.450 -0400", hash_original_method = "AEDBB722302E662B30772E575795E285", hash_generated_method = "AEE2EDC3DF81545043626560E5B22850")
    public void setNumStars(final int numStars) {
        mNumStars = numStars;
        requestLayout();
        // ---------- Original Method ----------
        //if (numStars <= 0) {
            //return;
        //}
        //mNumStars = numStars;
        //requestLayout();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.450 -0400", hash_original_method = "D4C4902F9D646F6CD3B3EB2FB6EFDC13", hash_generated_method = "5E72BFEE3C3A01D68392463B85521188")
    public int getNumStars() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_639965160 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_639965160;
        // ---------- Original Method ----------
        //return mNumStars;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.451 -0400", hash_original_method = "4B12106E3623F8927849B5EF91E272B5", hash_generated_method = "05BA17E7576F16BF1F27F791355FFA6B")
    public void setRating(float rating) {
        setProgress(Math.round(rating * getProgressPerStar()));
        addTaint(rating);
        // ---------- Original Method ----------
        //setProgress(Math.round(rating * getProgressPerStar()));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.451 -0400", hash_original_method = "EA1852BE7B44A888483D4F1C620CF769", hash_generated_method = "B8E0B0EE02EBFCD1E259CA8641FD3B3D")
    public float getRating() {
        float varC1551137A50504CB0487B61A80640C9D_749756616 = (getProgress() / getProgressPerStar());
        float var546ADE640B6EDFBC8A086EF31347E768_1759594468 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1759594468;
        // ---------- Original Method ----------
        //return getProgress() / getProgressPerStar();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.451 -0400", hash_original_method = "A3E9B935F0D69FAE2374B5CF03A160E4", hash_generated_method = "918DFEC3AF4FE791EEFC8DF0C9DF5CD6")
    public void setStepSize(float stepSize) {
        float newMax;
        newMax = mNumStars / stepSize;
        int newProgress;
        newProgress = (int) (newMax / getMax() * getProgress());
        setMax((int) newMax);
        setProgress(newProgress);
        addTaint(stepSize);
        // ---------- Original Method ----------
        //if (stepSize <= 0) {
            //return;
        //}
        //final float newMax = mNumStars / stepSize;
        //final int newProgress = (int) (newMax / getMax() * getProgress());
        //setMax((int) newMax);
        //setProgress(newProgress);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.452 -0400", hash_original_method = "2ABC51A03E553FCA3CBD93E8294B1CB6", hash_generated_method = "88055936E8421A4266094057DD5C9BA1")
    public float getStepSize() {
        float var580C926BAB1A16EA2E9DB56BF568E6C8_1151778383 = ((float) getNumStars() / getMax());
        float var546ADE640B6EDFBC8A086EF31347E768_1021303777 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1021303777;
        // ---------- Original Method ----------
        //return (float) getNumStars() / getMax();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.452 -0400", hash_original_method = "3A53F1CA5B2034CF32272EC34B36C37A", hash_generated_method = "46270FF80B922C6DCED4FEE6456E3FED")
    private float getProgressPerStar() {
        {
            float varE5C947B8561C8E1317DE021C46A9B2D5_534572988 = (1f * getMax() / mNumStars);
        } //End block
        float var546ADE640B6EDFBC8A086EF31347E768_746515581 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_746515581;
        // ---------- Original Method ----------
        //if (mNumStars > 0) {
            //return 1f * getMax() / mNumStars;
        //} else {
            //return 1;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.452 -0400", hash_original_method = "505263BDF0A0C38F11468B8B577065DB", hash_generated_method = "9B29F2C87F622C1F022B6792B634C5A5")
    @Override
     Shape getDrawableShape() {
        Shape varB4EAC82CA7396A68D541C85D26508E83_1320346252 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1320346252 = new RectShape();
        varB4EAC82CA7396A68D541C85D26508E83_1320346252.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1320346252;
        // ---------- Original Method ----------
        //return new RectShape();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.456 -0400", hash_original_method = "9369317EE923D808BCA8DA286976E63F", hash_generated_method = "0F13953CC31CCF22B3AD6E6FD1BD6C96")
    @Override
     void onProgressRefresh(float scale, boolean fromUser) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onProgressRefresh(scale, fromUser);
        updateSecondaryProgress(getProgress());
        {
            dispatchRatingChange(false);
        } //End block
        addTaint(scale);
        addTaint(fromUser);
        // ---------- Original Method ----------
        //super.onProgressRefresh(scale, fromUser);
        //updateSecondaryProgress(getProgress());
        //if (!fromUser) {
            //dispatchRatingChange(false);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.457 -0400", hash_original_method = "8E49EEB31BBD9AD69349C4C139B0ADB3", hash_generated_method = "0C9A32489C5572CD92141EA70909910C")
    private void updateSecondaryProgress(int progress) {
        float ratio;
        ratio = getProgressPerStar();
        {
            float progressInStars;
            progressInStars = progress / ratio;
            int secondaryProgress;
            secondaryProgress = (int) (Math.ceil(progressInStars) * ratio);
            setSecondaryProgress(secondaryProgress);
        } //End block
        addTaint(progress);
        // ---------- Original Method ----------
        //final float ratio = getProgressPerStar();
        //if (ratio > 0) {
            //final float progressInStars = progress / ratio;
            //final int secondaryProgress = (int) (Math.ceil(progressInStars) * ratio);
            //setSecondaryProgress(secondaryProgress);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.458 -0400", hash_original_method = "A52B21EAEA0ABEA842DCABF14BA9A11D", hash_generated_method = "DA783102A445C47D9F68377F98C0BBA7")
    @Override
    protected synchronized void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        {
            int width;
            width = mSampleTile.getWidth() * mNumStars;
            setMeasuredDimension(resolveSizeAndState(width, widthMeasureSpec, 0),
                    getMeasuredHeight());
        } //End block
        addTaint(widthMeasureSpec);
        addTaint(heightMeasureSpec);
        // ---------- Original Method ----------
        //super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //if (mSampleTile != null) {
            //final int width = mSampleTile.getWidth() * mNumStars;
            //setMeasuredDimension(resolveSizeAndState(width, widthMeasureSpec, 0),
                    //getMeasuredHeight());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.474 -0400", hash_original_method = "226C4EA3B37AD5190041539897D2C6DD", hash_generated_method = "D46B39EED2C3FCB544AE1F9ECD553F30")
    @Override
     void onStartTrackingTouch() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mProgressOnStartTracking = getProgress();
        super.onStartTrackingTouch();
        // ---------- Original Method ----------
        //mProgressOnStartTracking = getProgress();
        //super.onStartTrackingTouch();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.474 -0400", hash_original_method = "6235EE5490022867BAEF4FF5BA6A4578", hash_generated_method = "9520BC9433947437AAD34F0F95B76DDB")
    @Override
     void onStopTrackingTouch() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onStopTrackingTouch();
        {
            boolean varE06DC55B4557AFDCAD49579E6FE8D748_1698320919 = (getProgress() != mProgressOnStartTracking);
            {
                dispatchRatingChange(true);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //super.onStopTrackingTouch();
        //if (getProgress() != mProgressOnStartTracking) {
            //dispatchRatingChange(true);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.475 -0400", hash_original_method = "90A55B8149F7E0DE715F35412D64649C", hash_generated_method = "7BA0FC9D64756D08AFC36F4673AD7D4C")
    @Override
     void onKeyChange() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onKeyChange();
        dispatchRatingChange(true);
        // ---------- Original Method ----------
        //super.onKeyChange();
        //dispatchRatingChange(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.475 -0400", hash_original_method = "BACFB5351B8F09A10BE81590146F8D2A", hash_generated_method = "1D9AD8148A7425FC3834C3AAA1457F70")
     void dispatchRatingChange(boolean fromUser) {
        {
            mOnRatingBarChangeListener.onRatingChanged(this, getRating(),
                    fromUser);
        } //End block
        addTaint(fromUser);
        // ---------- Original Method ----------
        //if (mOnRatingBarChangeListener != null) {
            //mOnRatingBarChangeListener.onRatingChanged(this, getRating(),
                    //fromUser);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:08.475 -0400", hash_original_method = "0784AE840DC17E48B7292220CB837BFB", hash_generated_method = "5A33CEA0949B5D022E897331C9C5ED5A")
    @Override
    public synchronized void setMax(int max) {
        super.setMax(max);
        addTaint(max);
        // ---------- Original Method ----------
        //if (max <= 0) {
            //return;
        //}
        //super.setMax(max);
    }

    
    public interface OnRatingBarChangeListener {
        
        
        void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser);

    }
    
}

