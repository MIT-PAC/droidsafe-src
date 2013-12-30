package android.widget;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.shapes.RectShape;
import android.graphics.drawable.shapes.Shape;
import android.util.AttributeSet;

import com.android.internal.R;






public class RatingBar extends AbsSeekBar {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:13.720 -0500", hash_original_field = "98990ECA5DE415A342C4AAC988F69A23", hash_generated_field = "41FB5B10B91C91607A37B16172D7BB7B")


    private int mNumStars = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:13.722 -0500", hash_original_field = "7C9AD9C4B85F464A927A2733F560E125", hash_generated_field = "29069870A57CAD9CDBBA4A9B273494B8")


    private int mProgressOnStartTracking;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:13.724 -0500", hash_original_field = "EA9CFC534B50738A7373357858CB39CF", hash_generated_field = "26FA5FE396DAB5C7A7F6142358E24340")

    
    private OnRatingBarChangeListener mOnRatingBarChangeListener;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:13.727 -0500", hash_original_method = "938147F53CB460240E2DF1224551ED40", hash_generated_method = "E1CAA32CA5D4A2CA00CB0DCF155F6C90")
    
public RatingBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.RatingBar,
                defStyle, 0);
        final int numStars = a.getInt(R.styleable.RatingBar_numStars, mNumStars);
        setIsIndicator(a.getBoolean(R.styleable.RatingBar_isIndicator, !mIsUserSeekable));
        final float rating = a.getFloat(R.styleable.RatingBar_rating, -1);
        final float stepSize = a.getFloat(R.styleable.RatingBar_stepSize, -1);
        a.recycle();

        if (numStars > 0 && numStars != mNumStars) {
            setNumStars(numStars);            
        }
        
        if (stepSize >= 0) {
            setStepSize(stepSize);
        } else {
            setStepSize(0.5f);
        }
        
        if (rating >= 0) {
            setRating(rating);
        }
        
        // A touch inside a star fill up to that fractional area (slightly more
        // than 1 so boundaries round up).
        mTouchProgressOffset = 1.1f;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:13.730 -0500", hash_original_method = "C497D2C446013A8A61B261C3CBB506B4", hash_generated_method = "51F527CA15CA20A377AAA7F486443DB0")
    
public RatingBar(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.ratingBarStyle);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:13.732 -0500", hash_original_method = "D42949600C8B60C6F46AA1F41FAE4EFB", hash_generated_method = "EAC85E9403699D559CDAA3872A132ABB")
    
public RatingBar(Context context) {
        this(context, null);
    }
    
    /**
     * Sets the listener to be called when the rating changes.
     * 
     * @param listener The listener.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:13.734 -0500", hash_original_method = "CB44A4D2B638D14CC961BB9C350C60D5", hash_generated_method = "EC3E173484ED252D622A0CA73172F600")
    
public void setOnRatingBarChangeListener(OnRatingBarChangeListener listener) {
        mOnRatingBarChangeListener = listener;
    }
    
    /**
     * @return The listener (may be null) that is listening for rating change
     *         events.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:13.736 -0500", hash_original_method = "695CB7B11E4FD58B096410402E370F4D", hash_generated_method = "7E70990342D6A64BEF3E10CAC76A2B8F")
    
public OnRatingBarChangeListener getOnRatingBarChangeListener() {
        return mOnRatingBarChangeListener;
    }

    /**
     * Whether this rating bar should only be an indicator (thus non-changeable
     * by the user).
     * 
     * @param isIndicator Whether it should be an indicator.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:13.739 -0500", hash_original_method = "3FF2593F21D7D3B2493BC4219B0E4596", hash_generated_method = "970865B3F54D25C6E930094219BB3CA6")
    
public void setIsIndicator(boolean isIndicator) {
        mIsUserSeekable = !isIndicator;
        setFocusable(!isIndicator);
    }
    
    /**
     * @return Whether this rating bar is only an indicator.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:13.741 -0500", hash_original_method = "874639FDA9C4F98AD3BF38D7B6BE89CD", hash_generated_method = "197A0DEA887E8DB21C5EF27B9AE88FCB")
    
public boolean isIndicator() {
        return !mIsUserSeekable;
    }
    
    /**
     * Sets the number of stars to show. In order for these to be shown
     * properly, it is recommended the layout width of this widget be wrap
     * content.
     * 
     * @param numStars The number of stars.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:13.743 -0500", hash_original_method = "AEDBB722302E662B30772E575795E285", hash_generated_method = "683FC3FF1D679B681BFEB0E226C6BA8B")
    
public void setNumStars(final int numStars) {
        if (numStars <= 0) {
            return;
        }
        
        mNumStars = numStars;
        
        // This causes the width to change, so re-layout
        requestLayout();
    }

    /**
     * Returns the number of stars shown.
     * @return The number of stars shown.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:13.745 -0500", hash_original_method = "D4C4902F9D646F6CD3B3EB2FB6EFDC13", hash_generated_method = "ABE49F5AB3B900B0747FE1B942049659")
    
public int getNumStars() {
        return mNumStars;
    }
    
    /**
     * Sets the rating (the number of stars filled).
     * 
     * @param rating The rating to set.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:13.747 -0500", hash_original_method = "4B12106E3623F8927849B5EF91E272B5", hash_generated_method = "37105B61119354CE2D6DB311C355FF52")
    
public void setRating(float rating) {
        setProgress(Math.round(rating * getProgressPerStar()));
    }

    /**
     * Gets the current rating (number of stars filled).
     * 
     * @return The current rating.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:13.749 -0500", hash_original_method = "EA1852BE7B44A888483D4F1C620CF769", hash_generated_method = "E20332C1700ADFACCF141565B520D4F9")
    
public float getRating() {
        return getProgress() / getProgressPerStar();        
    }

    /**
     * Sets the step size (granularity) of this rating bar.
     * 
     * @param stepSize The step size of this rating bar. For example, if
     *            half-star granularity is wanted, this would be 0.5.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:13.751 -0500", hash_original_method = "A3E9B935F0D69FAE2374B5CF03A160E4", hash_generated_method = "F5EF9CFCE0AE1DE2D444AC962C47574C")
    
public void setStepSize(float stepSize) {
        if (stepSize <= 0) {
            return;
        }
        
        final float newMax = mNumStars / stepSize;
        final int newProgress = (int) (newMax / getMax() * getProgress());
        setMax((int) newMax);
        setProgress(newProgress);
    }

    /**
     * Gets the step size of this rating bar.
     * 
     * @return The step size.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:13.753 -0500", hash_original_method = "2ABC51A03E553FCA3CBD93E8294B1CB6", hash_generated_method = "068DBF112606248182AC4CBEC8F84E7D")
    
public float getStepSize() {
        return (float) getNumStars() / getMax();
    }
    
    /**
     * @return The amount of progress that fits into a star
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:13.755 -0500", hash_original_method = "3A53F1CA5B2034CF32272EC34B36C37A", hash_generated_method = "BC6D485251836CBC040AABE53D339EAF")
    
private float getProgressPerStar() {
        if (mNumStars > 0) {
            return 1f * getMax() / mNumStars;
        } else {
            return 1;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:13.757 -0500", hash_original_method = "505263BDF0A0C38F11468B8B577065DB", hash_generated_method = "C5242A4E35C0EDDDEB552A620E08706A")
    
@Override
    Shape getDrawableShape() {
        // TODO: Once ProgressBar's TODOs are fixed, this won't be needed
        return new RectShape();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:13.761 -0500", hash_original_method = "9369317EE923D808BCA8DA286976E63F", hash_generated_method = "7F152030CC2E68B235E3E831874926C8")
    
@Override
    void onProgressRefresh(float scale, boolean fromUser) {
        super.onProgressRefresh(scale, fromUser);

        // Keep secondary progress in sync with primary
        updateSecondaryProgress(getProgress());
        
        if (!fromUser) {
            // Callback for non-user rating changes
            dispatchRatingChange(false);
        }
    }

    /**
     * The secondary progress is used to differentiate the background of a
     * partially filled star. This method keeps the secondary progress in sync
     * with the progress.
     * 
     * @param progress The primary progress level.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:13.763 -0500", hash_original_method = "8E49EEB31BBD9AD69349C4C139B0ADB3", hash_generated_method = "B09349C5965709603561C5E3C7C88D07")
    
private void updateSecondaryProgress(int progress) {
        final float ratio = getProgressPerStar();
        if (ratio > 0) {
            final float progressInStars = progress / ratio;
            final int secondaryProgress = (int) (Math.ceil(progressInStars) * ratio);
            setSecondaryProgress(secondaryProgress);
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:13.766 -0500", hash_original_method = "A52B21EAEA0ABEA842DCABF14BA9A11D", hash_generated_method = "6071BB8740D35C1223FB37DFA800DA6A")
    
@Override
    protected synchronized void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        
        if (mSampleTile != null) {
            // TODO: Once ProgressBar's TODOs are gone, this can be done more
            // cleanly than mSampleTile
            final int width = mSampleTile.getWidth() * mNumStars;
            setMeasuredDimension(resolveSizeAndState(width, widthMeasureSpec, 0),
                    getMeasuredHeight());
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:13.768 -0500", hash_original_method = "226C4EA3B37AD5190041539897D2C6DD", hash_generated_method = "AFA61F16D6F90EFDCA07FBF3EC964EFF")
    
@Override
    void onStartTrackingTouch() {
        mProgressOnStartTracking = getProgress();
        
        super.onStartTrackingTouch();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:13.770 -0500", hash_original_method = "6235EE5490022867BAEF4FF5BA6A4578", hash_generated_method = "0969D0898BB8EAEC031F3543B3C33FC8")
    
@Override
    void onStopTrackingTouch() {
        super.onStopTrackingTouch();

        if (getProgress() != mProgressOnStartTracking) {
            dispatchRatingChange(true);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:13.772 -0500", hash_original_method = "90A55B8149F7E0DE715F35412D64649C", hash_generated_method = "4E7720682C308FBE34C16F2C77CAE14F")
    
@Override
    void onKeyChange() {
        super.onKeyChange();
        dispatchRatingChange(true);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:13.774 -0500", hash_original_method = "BACFB5351B8F09A10BE81590146F8D2A", hash_generated_method = "BACFB5351B8F09A10BE81590146F8D2A")
    
void dispatchRatingChange(boolean fromUser) {
        if (mOnRatingBarChangeListener != null) {
            mOnRatingBarChangeListener.onRatingChanged(this, getRating(),
                    fromUser);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:13.777 -0500", hash_original_method = "0784AE840DC17E48B7292220CB837BFB", hash_generated_method = "07DCFCC4B6FB8C937AF6493A10A9D9CF")
    
@Override
    public synchronized void setMax(int max) {
        // Disallow max progress = 0
        if (max <= 0) {
            return;
        }
        
        super.setMax(max);
    }

    
    public interface OnRatingBarChangeListener {
        
        
        void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser);

    }
    
}

