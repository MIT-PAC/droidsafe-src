package android.widget;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.shapes.RectShape;
import android.graphics.drawable.shapes.Shape;
import android.util.AttributeSet;
import com.android.internal.R;

public class RatingBar extends AbsSeekBar {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.642 -0400", hash_original_field = "363D0777077E57DB14FD78240A95F5D1", hash_generated_field = "41FB5B10B91C91607A37B16172D7BB7B")

    private int mNumStars = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.642 -0400", hash_original_field = "05022DE7C184DCE58C4731645B8098FF", hash_generated_field = "29069870A57CAD9CDBBA4A9B273494B8")

    private int mProgressOnStartTracking;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.642 -0400", hash_original_field = "7DEBD693AAB84E4B40F94DB43FDD63FB", hash_generated_field = "26FA5FE396DAB5C7A7F6142358E24340")

    private OnRatingBarChangeListener mOnRatingBarChangeListener;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.643 -0400", hash_original_method = "938147F53CB460240E2DF1224551ED40", hash_generated_method = "41FC9C135E57A0D3407CBEFFDBB2877F")
    public  RatingBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.RatingBar,
                defStyle, 0);
        final int numStars = a.getInt(R.styleable.RatingBar_numStars, mNumStars);
        setIsIndicator(a.getBoolean(R.styleable.RatingBar_isIndicator, !mIsUserSeekable));
        final float rating = a.getFloat(R.styleable.RatingBar_rating, -1);
        final float stepSize = a.getFloat(R.styleable.RatingBar_stepSize, -1);
        a.recycle();
        {
            setNumStars(numStars);
        } 
        {
            setStepSize(stepSize);
        } 
        {
            setStepSize(0.5f);
        } 
        {
            setRating(rating);
        } 
        mTouchProgressOffset = 1.1f;
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        addTaint(defStyle);
        
        
                
        
        
        
        
        
        
            
        
        
            
        
            
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.643 -0400", hash_original_method = "C497D2C446013A8A61B261C3CBB506B4", hash_generated_method = "DEAD15DC1FF5C2C1C379C015050F12E5")
    public  RatingBar(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.ratingBarStyle);
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.643 -0400", hash_original_method = "D42949600C8B60C6F46AA1F41FAE4EFB", hash_generated_method = "D2A1F8453254063501F518FB3CF6FD6C")
    public  RatingBar(Context context) {
        this(context, null);
        addTaint(context.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.643 -0400", hash_original_method = "CB44A4D2B638D14CC961BB9C350C60D5", hash_generated_method = "0C38E6D8F5DE50714CF4743825B12928")
    public void setOnRatingBarChangeListener(OnRatingBarChangeListener listener) {
        mOnRatingBarChangeListener = listener;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.644 -0400", hash_original_method = "695CB7B11E4FD58B096410402E370F4D", hash_generated_method = "95569276B15096362B5BFAFE74F77286")
    public OnRatingBarChangeListener getOnRatingBarChangeListener() {
        OnRatingBarChangeListener varB4EAC82CA7396A68D541C85D26508E83_1129683080 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1129683080 = mOnRatingBarChangeListener;
        varB4EAC82CA7396A68D541C85D26508E83_1129683080.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1129683080;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.644 -0400", hash_original_method = "3FF2593F21D7D3B2493BC4219B0E4596", hash_generated_method = "F2D587DFE3281D75BCEF80ED24345A2D")
    public void setIsIndicator(boolean isIndicator) {
        mIsUserSeekable = !isIndicator;
        setFocusable(!isIndicator);
        addTaint(isIndicator);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.644 -0400", hash_original_method = "874639FDA9C4F98AD3BF38D7B6BE89CD", hash_generated_method = "966D90745D045E9D9F44F7733093FFCF")
    public boolean isIndicator() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2103064940 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2103064940;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.645 -0400", hash_original_method = "AEDBB722302E662B30772E575795E285", hash_generated_method = "AEE2EDC3DF81545043626560E5B22850")
    public void setNumStars(final int numStars) {
        mNumStars = numStars;
        requestLayout();
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.645 -0400", hash_original_method = "D4C4902F9D646F6CD3B3EB2FB6EFDC13", hash_generated_method = "041B057376C402016D2DAFC213A87EA6")
    public int getNumStars() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_391591687 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_391591687;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.646 -0400", hash_original_method = "4B12106E3623F8927849B5EF91E272B5", hash_generated_method = "05BA17E7576F16BF1F27F791355FFA6B")
    public void setRating(float rating) {
        setProgress(Math.round(rating * getProgressPerStar()));
        addTaint(rating);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.646 -0400", hash_original_method = "EA1852BE7B44A888483D4F1C620CF769", hash_generated_method = "210A1EC8C368B106581A95F092643888")
    public float getRating() {
        float varC1551137A50504CB0487B61A80640C9D_837306306 = (getProgress() / getProgressPerStar());
        float var546ADE640B6EDFBC8A086EF31347E768_1329134179 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1329134179;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.647 -0400", hash_original_method = "A3E9B935F0D69FAE2374B5CF03A160E4", hash_generated_method = "B1A26190C789F2FDD2BB01D6A92DF027")
    public void setStepSize(float stepSize) {
        final float newMax = mNumStars / stepSize;
        final int newProgress = (int) (newMax / getMax() * getProgress());
        setMax((int) newMax);
        setProgress(newProgress);
        addTaint(stepSize);
        
        
            
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.647 -0400", hash_original_method = "2ABC51A03E553FCA3CBD93E8294B1CB6", hash_generated_method = "3B75792D4F1C426A9E53513AC6245819")
    public float getStepSize() {
        float var580C926BAB1A16EA2E9DB56BF568E6C8_1768269545 = ((float) getNumStars() / getMax());
        float var546ADE640B6EDFBC8A086EF31347E768_1788984891 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1788984891;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.647 -0400", hash_original_method = "3A53F1CA5B2034CF32272EC34B36C37A", hash_generated_method = "3CAF7302ADF32F39EA9371D78ECBED1D")
    private float getProgressPerStar() {
        {
            float varE5C947B8561C8E1317DE021C46A9B2D5_518366126 = (1f * getMax() / mNumStars);
        } 
        float var546ADE640B6EDFBC8A086EF31347E768_1170713645 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1170713645;
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.648 -0400", hash_original_method = "505263BDF0A0C38F11468B8B577065DB", hash_generated_method = "DC3C35B7205AC99D22B5C595B1F94EB0")
    @Override
     Shape getDrawableShape() {
        Shape varB4EAC82CA7396A68D541C85D26508E83_1304855699 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1304855699 = new RectShape();
        varB4EAC82CA7396A68D541C85D26508E83_1304855699.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1304855699;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.648 -0400", hash_original_method = "9369317EE923D808BCA8DA286976E63F", hash_generated_method = "0F13953CC31CCF22B3AD6E6FD1BD6C96")
    @Override
     void onProgressRefresh(float scale, boolean fromUser) {
        
        super.onProgressRefresh(scale, fromUser);
        updateSecondaryProgress(getProgress());
        {
            dispatchRatingChange(false);
        } 
        addTaint(scale);
        addTaint(fromUser);
        
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.649 -0400", hash_original_method = "8E49EEB31BBD9AD69349C4C139B0ADB3", hash_generated_method = "B44EA27C511B75070D3FCD6796DB048B")
    private void updateSecondaryProgress(int progress) {
        final float ratio = getProgressPerStar();
        {
            final float progressInStars = progress / ratio;
            final int secondaryProgress = (int) (Math.ceil(progressInStars) * ratio);
            setSecondaryProgress(secondaryProgress);
        } 
        addTaint(progress);
        
        
        
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.649 -0400", hash_original_method = "A52B21EAEA0ABEA842DCABF14BA9A11D", hash_generated_method = "87201983ED824CE6F7DA7E28226CB926")
    @Override
    protected synchronized void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        {
            final int width = mSampleTile.getWidth() * mNumStars;
            setMeasuredDimension(resolveSizeAndState(width, widthMeasureSpec, 0),
                    getMeasuredHeight());
        } 
        addTaint(widthMeasureSpec);
        addTaint(heightMeasureSpec);
        
        
        
            
            
                    
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.649 -0400", hash_original_method = "226C4EA3B37AD5190041539897D2C6DD", hash_generated_method = "D46B39EED2C3FCB544AE1F9ECD553F30")
    @Override
     void onStartTrackingTouch() {
        
        mProgressOnStartTracking = getProgress();
        super.onStartTrackingTouch();
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.650 -0400", hash_original_method = "6235EE5490022867BAEF4FF5BA6A4578", hash_generated_method = "B64C821E85AB5404BAA65133456C3C68")
    @Override
     void onStopTrackingTouch() {
        
        super.onStopTrackingTouch();
        {
            boolean varE06DC55B4557AFDCAD49579E6FE8D748_2017947779 = (getProgress() != mProgressOnStartTracking);
            {
                dispatchRatingChange(true);
            } 
        } 
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.650 -0400", hash_original_method = "90A55B8149F7E0DE715F35412D64649C", hash_generated_method = "7BA0FC9D64756D08AFC36F4673AD7D4C")
    @Override
     void onKeyChange() {
        
        super.onKeyChange();
        dispatchRatingChange(true);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.650 -0400", hash_original_method = "BACFB5351B8F09A10BE81590146F8D2A", hash_generated_method = "1D9AD8148A7425FC3834C3AAA1457F70")
     void dispatchRatingChange(boolean fromUser) {
        {
            mOnRatingBarChangeListener.onRatingChanged(this, getRating(),
                    fromUser);
        } 
        addTaint(fromUser);
        
        
            
                    
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:13.650 -0400", hash_original_method = "0784AE840DC17E48B7292220CB837BFB", hash_generated_method = "5A33CEA0949B5D022E897331C9C5ED5A")
    @Override
    public synchronized void setMax(int max) {
        super.setMax(max);
        addTaint(max);
        
        
            
        
        
    }

    
    public interface OnRatingBarChangeListener {
        
        
        void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser);

    }
    
}

