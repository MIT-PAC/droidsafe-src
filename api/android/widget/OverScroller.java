package android.widget;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import android.content.Context;
import android.hardware.SensorManager;
import android.util.FloatMath;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

public class OverScroller {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:43.481 -0500", hash_original_field = "582653CA594E9011AB41A4FCE5484EDB", hash_generated_field = "71A034DCC41856FE859BC1F065FC4DA6")

    private static final int DEFAULT_DURATION = 250;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:43.483 -0500", hash_original_field = "3D6FED5899F5F015C1131133F50D0489", hash_generated_field = "A767E7A0CD4C56577AF1FE7F420CA686")

    private static final int SCROLL_MODE = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:43.486 -0500", hash_original_field = "81563A2E06AEB00F58D11CE9DD9FB95A", hash_generated_field = "F3B8A415FA7A0B0422B61C4A171BBABD")

    private static final int FLING_MODE = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:43.470 -0500", hash_original_field = "556F09336B3BD1BEFE7C8BF0B32BAF35", hash_generated_field = "B9E13EBC2196F570555262A42E5818EF")

    private int mMode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:43.472 -0500", hash_original_field = "5B7884ABC551A98832C6BB808D3C0618", hash_generated_field = "9FFB811B26F4EA1D9264A27559A21A04")

    private  SplineOverScroller mScrollerX;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:43.475 -0500", hash_original_field = "3F3890F0379851679E99EC14AB8BC162", hash_generated_field = "2EB0A894343F6510CC074954C4F3CB9E")

    private  SplineOverScroller mScrollerY;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:43.477 -0500", hash_original_field = "A1326AE9004157E0812422F0F20CD6F9", hash_generated_field = "67BF1E9EFEC019D28BF77934CF035B72")

    private  Interpolator mInterpolator;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:43.479 -0500", hash_original_field = "3C6C48AF201FFC06BDC466551DBF9587", hash_generated_field = "DB496AACF49E477CC5F54743876A46FF")

    private  boolean mFlywheel;

    /**
     * Creates an OverScroller with a viscous fluid scroll interpolator and flywheel.
     * @param context
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:43.488 -0500", hash_original_method = "B9802AB7FB2D6944C0543E71DB189BC5", hash_generated_method = "DEEB77B2C68BB909DABA5292FF87F355")
    
public OverScroller(Context context) {
        this(context, null);
    }

    /**
     * Creates an OverScroller with flywheel enabled.
     * @param context The context of this application.
     * @param interpolator The scroll interpolator. If null, a default (viscous) interpolator will
     * be used.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:43.491 -0500", hash_original_method = "F6227ED49D62C3697D2AC005A8942714", hash_generated_method = "11F2C344198340390A40979F8BC30D32")
    
public OverScroller(Context context, Interpolator interpolator) {
        this(context, interpolator, true);
    }

    /**
     * Creates an OverScroller.
     * @param context The context of this application.
     * @param interpolator The scroll interpolator. If null, a default (viscous) interpolator will
     * be used.
     * @param flywheel If true, successive fling motions will keep on increasing scroll speed.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:43.493 -0500", hash_original_method = "8F06EBB42FF76B1717D428E4F6418D97", hash_generated_method = "E1898FD7C9E27045498EAA45738EDD9A")
    
public OverScroller(Context context, Interpolator interpolator, boolean flywheel) {
        mInterpolator = interpolator;
        mFlywheel = flywheel;
        mScrollerX = new SplineOverScroller();
        mScrollerY = new SplineOverScroller();

        SplineOverScroller.initFromContext(context);
    }

    /**
     * Creates an OverScroller with flywheel enabled.
     * @param context The context of this application.
     * @param interpolator The scroll interpolator. If null, a default (viscous) interpolator will
     * be used.
     * @param bounceCoefficientX A value between 0 and 1 that will determine the proportion of the
     * velocity which is preserved in the bounce when the horizontal edge is reached. A null value
     * means no bounce. This behavior is no longer supported and this coefficient has no effect.
     * @param bounceCoefficientY Same as bounceCoefficientX but for the vertical direction. This
     * behavior is no longer supported and this coefficient has no effect.
     * !deprecated Use {!link #OverScroller(Context, Interpolator, boolean)} instead.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:43.496 -0500", hash_original_method = "0CF9495AD70A3403C1A28AE06C2DFE6A", hash_generated_method = "3096F049D35F1B9D2027C112D9B826AC")
    
public OverScroller(Context context, Interpolator interpolator,
            float bounceCoefficientX, float bounceCoefficientY) {
        this(context, interpolator, true);
    }

    /**
     * Creates an OverScroller.
     * @param context The context of this application.
     * @param interpolator The scroll interpolator. If null, a default (viscous) interpolator will
     * be used.
     * @param bounceCoefficientX A value between 0 and 1 that will determine the proportion of the
     * velocity which is preserved in the bounce when the horizontal edge is reached. A null value
     * means no bounce. This behavior is no longer supported and this coefficient has no effect.
     * @param bounceCoefficientY Same as bounceCoefficientX but for the vertical direction. This
     * behavior is no longer supported and this coefficient has no effect.
     * @param flywheel If true, successive fling motions will keep on increasing scroll speed.
     * !deprecated Use {!link OverScroller(Context, Interpolator, boolean)} instead.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:43.499 -0500", hash_original_method = "229999978F856549CB121738FDE882C4", hash_generated_method = "FAC82D23424B0049B140FB11B266CA66")
    
public OverScroller(Context context, Interpolator interpolator,
            float bounceCoefficientX, float bounceCoefficientY, boolean flywheel) {
        this(context, interpolator, flywheel);
    }

    /**
     * The amount of friction applied to flings. The default value
     * is {@link ViewConfiguration#getScrollFriction}.
     *
     * @param friction A scalar dimension-less value representing the coefficient of
     *         friction.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:43.501 -0500", hash_original_method = "E258F8966760114615A66C59C43DDBF7", hash_generated_method = "3CFBAE51894E2D9511478844B8926820")
    
public final void setFriction(float friction) {
        mScrollerX.setFriction(friction);
        mScrollerY.setFriction(friction);
    }

    /**
     *
     * Returns whether the scroller has finished scrolling.
     *
     * @return True if the scroller has finished scrolling, false otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:43.505 -0500", hash_original_method = "C0D588953F48F0F49E401C0010BD067A", hash_generated_method = "FDD5257AB5E7A1CD3E9757215A6BF545")
    
public final boolean isFinished() {
        return mScrollerX.mFinished && mScrollerY.mFinished;
    }

    /**
     * Force the finished field to a particular value. Contrary to
     * {@link #abortAnimation()}, forcing the animation to finished
     * does NOT cause the scroller to move to the final x and y
     * position.
     *
     * @param finished The new finished value.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:43.507 -0500", hash_original_method = "530BF62F40D21F1D1C05E22ECA085B25", hash_generated_method = "AD26F6248E3E2D0DD178EFD0CA9EEEFC")
    
public final void forceFinished(boolean finished) {
        mScrollerX.mFinished = mScrollerY.mFinished = finished;
    }

    /**
     * Returns the current X offset in the scroll.
     *
     * @return The new X offset as an absolute distance from the origin.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:43.509 -0500", hash_original_method = "935C47FB8A3CB470F597BC28E107035C", hash_generated_method = "53B4A4CD497A9D5DB67229573C2C599A")
    
public final int getCurrX() {
        return mScrollerX.mCurrentPosition;
    }

    /**
     * Returns the current Y offset in the scroll.
     *
     * @return The new Y offset as an absolute distance from the origin.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:43.512 -0500", hash_original_method = "4ECEC07425ABC9DEFD7B203A5114566B", hash_generated_method = "E2A744CFD1190860F0D4BDB7448D0F72")
    
public final int getCurrY() {
        return mScrollerY.mCurrentPosition;
    }

    /**
     * Returns the absolute value of the current velocity.
     *
     * @return The original velocity less the deceleration, norm of the X and Y velocity vector.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:43.514 -0500", hash_original_method = "64BF41B2D89FD1AD797ACAED97E05500", hash_generated_method = "7C8FCD2CBE06F83A568B96C0E16D4F7E")
    
public float getCurrVelocity() {
        float squaredNorm = mScrollerX.mCurrVelocity * mScrollerX.mCurrVelocity;
        squaredNorm += mScrollerY.mCurrVelocity * mScrollerY.mCurrVelocity;
        return FloatMath.sqrt(squaredNorm);
    }

    /**
     * Returns the start X offset in the scroll.
     *
     * @return The start X offset as an absolute distance from the origin.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:43.516 -0500", hash_original_method = "99101D94CAA5BDB5F4107BC8C52E5814", hash_generated_method = "332F91A7484FEE7B58854E5BCFAEB004")
    
public final int getStartX() {
        return mScrollerX.mStart;
    }

    /**
     * Returns the start Y offset in the scroll.
     *
     * @return The start Y offset as an absolute distance from the origin.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:43.518 -0500", hash_original_method = "C3B7BC19CF57D40812EE2941701D8011", hash_generated_method = "9CE1460407DEAB48C6965AD7CD8115A7")
    
public final int getStartY() {
        return mScrollerY.mStart;
    }

    /**
     * Returns where the scroll will end. Valid only for "fling" scrolls.
     *
     * @return The final X offset as an absolute distance from the origin.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:43.521 -0500", hash_original_method = "B59ED352B9AEDA78AFFC00B7CFC03926", hash_generated_method = "5D94BA28B978E4A121B5EA36EF43E61C")
    
public final int getFinalX() {
        return mScrollerX.mFinal;
    }

    /**
     * Returns where the scroll will end. Valid only for "fling" scrolls.
     *
     * @return The final Y offset as an absolute distance from the origin.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:43.523 -0500", hash_original_method = "35D86359302D602175EC68518CA83146", hash_generated_method = "99FD42909C9877A51B345A36A5CEA1DE")
    
public final int getFinalY() {
        return mScrollerY.mFinal;
    }

    /**
     * Returns how long the scroll event will take, in milliseconds.
     *
     * @return The duration of the scroll in milliseconds.
     *
     * @hide Pending removal once nothing depends on it
     * @deprecated OverScrollers don't necessarily have a fixed duration.
     *             This function will lie to the best of its ability.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:43.525 -0500", hash_original_method = "9AE57030D7C8A0E7D6E4B9C3569B7863", hash_generated_method = "B7295492D0C5281B45EE7FCFDC2FEAC5")
    
@Deprecated
    public final int getDuration() {
        return Math.max(mScrollerX.mDuration, mScrollerY.mDuration);
    }

    /**
     * Extend the scroll animation. This allows a running animation to scroll
     * further and longer, when used with {@link #setFinalX(int)} or {@link #setFinalY(int)}.
     *
     * @param extend Additional time to scroll in milliseconds.
     * @see #setFinalX(int)
     * @see #setFinalY(int)
     *
     * @hide Pending removal once nothing depends on it
     * @deprecated OverScrollers don't necessarily have a fixed duration.
     *             Instead of setting a new final position and extending
     *             the duration of an existing scroll, use startScroll
     *             to begin a new animation.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:43.527 -0500", hash_original_method = "C8E559EF6FD22D868574182D9D2BCAF9", hash_generated_method = "5D7251154EE0876B8BDA426C121B29BD")
    
@Deprecated
    public void extendDuration(int extend) {
        mScrollerX.extendDuration(extend);
        mScrollerY.extendDuration(extend);
    }

    /**
     * Sets the final position (X) for this scroller.
     *
     * @param newX The new X offset as an absolute distance from the origin.
     * @see #extendDuration(int)
     * @see #setFinalY(int)
     *
     * @hide Pending removal once nothing depends on it
     * @deprecated OverScroller's final position may change during an animation.
     *             Instead of setting a new final position and extending
     *             the duration of an existing scroll, use startScroll
     *             to begin a new animation.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:43.530 -0500", hash_original_method = "21D9AD21BF731806972ABE02338AD0C0", hash_generated_method = "6C037DB2831E3C142E831FB0859472BC")
    
@Deprecated
    public void setFinalX(int newX) {
        mScrollerX.setFinalPosition(newX);
    }

    /**
     * Sets the final position (Y) for this scroller.
     *
     * @param newY The new Y offset as an absolute distance from the origin.
     * @see #extendDuration(int)
     * @see #setFinalX(int)
     *
     * @hide Pending removal once nothing depends on it
     * @deprecated OverScroller's final position may change during an animation.
     *             Instead of setting a new final position and extending
     *             the duration of an existing scroll, use startScroll
     *             to begin a new animation.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:43.532 -0500", hash_original_method = "300115417BC2D028444CA0676224C129", hash_generated_method = "C37EF6DCA29E32742DF32959251A87F2")
    
@Deprecated
    public void setFinalY(int newY) {
        mScrollerY.setFinalPosition(newY);
    }

    /**
     * Call this when you want to know the new location. If it returns true, the
     * animation is not yet finished.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:43.535 -0500", hash_original_method = "4391FF82C7FA76BDB2CDCD1D85612F8D", hash_generated_method = "F531D5EBDD0D953AA2BA79FD6C6C9618")
    
public boolean computeScrollOffset() {
        if (isFinished()) {
            return false;
        }

        switch (mMode) {
            case SCROLL_MODE:
                long time = AnimationUtils.currentAnimationTimeMillis();
                // Any scroller can be used for time, since they were started
                // together in scroll mode. We use X here.
                final long elapsedTime = time - mScrollerX.mStartTime;

                final int duration = mScrollerX.mDuration;
                if (elapsedTime < duration) {
                    float q = (float) (elapsedTime) / duration;

                    if (mInterpolator == null) {
                        q = Scroller.viscousFluid(q);
                    } else {
                        q = mInterpolator.getInterpolation(q);
                    }

                    mScrollerX.updateScroll(q);
                    mScrollerY.updateScroll(q);
                } else {
                    abortAnimation();
                }
                break;

            case FLING_MODE:
                if (!mScrollerX.mFinished) {
                    if (!mScrollerX.update()) {
                        if (!mScrollerX.continueWhenFinished()) {
                            mScrollerX.finish();
                        }
                    }
                }

                if (!mScrollerY.mFinished) {
                    if (!mScrollerY.update()) {
                        if (!mScrollerY.continueWhenFinished()) {
                            mScrollerY.finish();
                        }
                    }
                }

                break;
        }

        return true;
    }

    /**
     * Start scrolling by providing a starting point and the distance to travel.
     * The scroll will use the default value of 250 milliseconds for the
     * duration.
     *
     * @param startX Starting horizontal scroll offset in pixels. Positive
     *        numbers will scroll the content to the left.
     * @param startY Starting vertical scroll offset in pixels. Positive numbers
     *        will scroll the content up.
     * @param dx Horizontal distance to travel. Positive numbers will scroll the
     *        content to the left.
     * @param dy Vertical distance to travel. Positive numbers will scroll the
     *        content up.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:43.537 -0500", hash_original_method = "2558578E34A043045AE1AF32A3800D82", hash_generated_method = "F9CD515A4E2C5B16D0DE692CF1A61742")
    
public void startScroll(int startX, int startY, int dx, int dy) {
        startScroll(startX, startY, dx, dy, DEFAULT_DURATION);
    }

    /**
     * Start scrolling by providing a starting point and the distance to travel.
     *
     * @param startX Starting horizontal scroll offset in pixels. Positive
     *        numbers will scroll the content to the left.
     * @param startY Starting vertical scroll offset in pixels. Positive numbers
     *        will scroll the content up.
     * @param dx Horizontal distance to travel. Positive numbers will scroll the
     *        content to the left.
     * @param dy Vertical distance to travel. Positive numbers will scroll the
     *        content up.
     * @param duration Duration of the scroll in milliseconds.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:43.540 -0500", hash_original_method = "C7C9FE1639F9BA6211C746BC2E590EF8", hash_generated_method = "B751B33CC0BF2EE6E2C7273D514854B1")
    
public void startScroll(int startX, int startY, int dx, int dy, int duration) {
        mMode = SCROLL_MODE;
        mScrollerX.startScroll(startX, dx, duration);
        mScrollerY.startScroll(startY, dy, duration);
    }

    /**
     * Call this when you want to 'spring back' into a valid coordinate range.
     *
     * @param startX Starting X coordinate
     * @param startY Starting Y coordinate
     * @param minX Minimum valid X value
     * @param maxX Maximum valid X value
     * @param minY Minimum valid Y value
     * @param maxY Minimum valid Y value
     * @return true if a springback was initiated, false if startX and startY were
     *          already within the valid range.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:43.542 -0500", hash_original_method = "E8D7F5B96D38EF5E598258BCD9688B52", hash_generated_method = "E6B8BA025A696D8DEFC6217C49FE1210")
    
public boolean springBack(int startX, int startY, int minX, int maxX, int minY, int maxY) {
        mMode = FLING_MODE;

        // Make sure both methods are called.
        final boolean spingbackX = mScrollerX.springback(startX, minX, maxX);
        final boolean spingbackY = mScrollerY.springback(startY, minY, maxY);
        return spingbackX || spingbackY;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:43.544 -0500", hash_original_method = "DCC04315E1B3C3B4106F742F922D4431", hash_generated_method = "48C138347615BF113442A1E922FC8A4B")
    
public void fling(int startX, int startY, int velocityX, int velocityY,
            int minX, int maxX, int minY, int maxY) {
        fling(startX, startY, velocityX, velocityY, minX, maxX, minY, maxY, 0, 0);
    }

    /**
     * Start scrolling based on a fling gesture. The distance traveled will
     * depend on the initial velocity of the fling.
     *
     * @param startX Starting point of the scroll (X)
     * @param startY Starting point of the scroll (Y)
     * @param velocityX Initial velocity of the fling (X) measured in pixels per
     *            second.
     * @param velocityY Initial velocity of the fling (Y) measured in pixels per
     *            second
     * @param minX Minimum X value. The scroller will not scroll past this point
     *            unless overX > 0. If overfling is allowed, it will use minX as
     *            a springback boundary.
     * @param maxX Maximum X value. The scroller will not scroll past this point
     *            unless overX > 0. If overfling is allowed, it will use maxX as
     *            a springback boundary.
     * @param minY Minimum Y value. The scroller will not scroll past this point
     *            unless overY > 0. If overfling is allowed, it will use minY as
     *            a springback boundary.
     * @param maxY Maximum Y value. The scroller will not scroll past this point
     *            unless overY > 0. If overfling is allowed, it will use maxY as
     *            a springback boundary.
     * @param overX Overfling range. If > 0, horizontal overfling in either
     *            direction will be possible.
     * @param overY Overfling range. If > 0, vertical overfling in either
     *            direction will be possible.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:43.547 -0500", hash_original_method = "38A7A19069D4290FC9AB0139CD44ADE1", hash_generated_method = "7007E02A81768D652D66865EF7A7DE15")
    
public void fling(int startX, int startY, int velocityX, int velocityY,
            int minX, int maxX, int minY, int maxY, int overX, int overY) {
        // Continue a scroll or fling in progress
        if (mFlywheel && !isFinished()) {
            float oldVelocityX = mScrollerX.mCurrVelocity;
            float oldVelocityY = mScrollerY.mCurrVelocity;
            if (Math.signum(velocityX) == Math.signum(oldVelocityX) &&
                    Math.signum(velocityY) == Math.signum(oldVelocityY)) {
                velocityX += oldVelocityX;
                velocityY += oldVelocityY;
            }
        }

        mMode = FLING_MODE;
        mScrollerX.fling(startX, velocityX, minX, maxX, overX);
        mScrollerY.fling(startY, velocityY, minY, maxY, overY);
    }

    /**
     * Notify the scroller that we've reached a horizontal boundary.
     * Normally the information to handle this will already be known
     * when the animation is started, such as in a call to one of the
     * fling functions. However there are cases where this cannot be known
     * in advance. This function will transition the current motion and
     * animate from startX to finalX as appropriate.
     *
     * @param startX Starting/current X position
     * @param finalX Desired final X position
     * @param overX Magnitude of overscroll allowed. This should be the maximum
     *              desired distance from finalX. Absolute value - must be positive.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:43.549 -0500", hash_original_method = "B9132D3CC6E7407A65F178898D94F282", hash_generated_method = "6D02779E22897C5CCC1B61B4DC8471C5")
    
public void notifyHorizontalEdgeReached(int startX, int finalX, int overX) {
        mScrollerX.notifyEdgeReached(startX, finalX, overX);
    }

    /**
     * Notify the scroller that we've reached a vertical boundary.
     * Normally the information to handle this will already be known
     * when the animation is started, such as in a call to one of the
     * fling functions. However there are cases where this cannot be known
     * in advance. This function will animate a parabolic motion from
     * startY to finalY.
     *
     * @param startY Starting/current Y position
     * @param finalY Desired final Y position
     * @param overY Magnitude of overscroll allowed. This should be the maximum
     *              desired distance from finalY. Absolute value - must be positive.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:43.551 -0500", hash_original_method = "EAACB5866396964CA4004FBBF9350F29", hash_generated_method = "85C49A64CA88551D9AB324C5AED2C0C3")
    
public void notifyVerticalEdgeReached(int startY, int finalY, int overY) {
        mScrollerY.notifyEdgeReached(startY, finalY, overY);
    }

    /**
     * Returns whether the current Scroller is currently returning to a valid position.
     * Valid bounds were provided by the
     * {@link #fling(int, int, int, int, int, int, int, int, int, int)} method.
     *
     * One should check this value before calling
     * {@link #startScroll(int, int, int, int)} as the interpolation currently in progress
     * to restore a valid position will then be stopped. The caller has to take into account
     * the fact that the started scroll will start from an overscrolled position.
     *
     * @return true when the current position is overscrolled and in the process of
     *         interpolating back to a valid value.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:43.553 -0500", hash_original_method = "AE5D891ECDFB8C77EC70A4859A3A8CFD", hash_generated_method = "C45BAD324F84A226584CE60DFDCE088F")
    
public boolean isOverScrolled() {
        return ((!mScrollerX.mFinished &&
                mScrollerX.mState != SplineOverScroller.SPLINE) ||
                (!mScrollerY.mFinished &&
                        mScrollerY.mState != SplineOverScroller.SPLINE));
    }
    
    static class SplineOverScroller {

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:43.631 -0500", hash_original_method = "C5E6E7B4566BE5624EF408255FF00E2C", hash_generated_method = "DF406E9EDC331828AB4F6995E4A45DB1")
        
static void initFromContext(Context context) {
            final float ppi = context.getResources().getDisplayMetrics().density * 160.0f;
            PHYSICAL_COEF = SensorManager.GRAVITY_EARTH // g (m/s^2)
                    * 39.37f // inch/meter
                    * ppi
                    * 0.84f; // look and feel tuning
        }

        /*
         * Get a signed deceleration that will reduce the velocity.
         */
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:43.640 -0500", hash_original_method = "4EEF4AD88BADE833476CB83D5BE6FD85", hash_generated_method = "87EFC541E87F2305523397D7E92B08A7")
        
static private float getDeceleration(int velocity) {
            return velocity > 0 ? -GRAVITY : GRAVITY;
        }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:43.595 -0500", hash_original_field = "5CBED3473B121C23ADB6C6E99063BBEB", hash_generated_field = "D27F709E38E95ABA41086ACB25759594")

        private static final float GRAVITY = 2000.0f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:43.597 -0500", hash_original_field = "5CDF9D5887FD944E33A8C9A294788109", hash_generated_field = "7154ED1E434BAFBB8BDDE7F776B01524")

        private static float PHYSICAL_COEF;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:43.599 -0500", hash_original_field = "8F0E0EB5930111BEE5FFC6FA463D9E6B", hash_generated_field = "D7A6A768456D7CA540BA35C2F5F4CAF3")

        private static float DECELERATION_RATE = (float) (Math.log(0.78) / Math.log(0.9));
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:43.602 -0500", hash_original_field = "5DC89CFBA6CBEFC71D069F06CB7B8F6C", hash_generated_field = "F5AF9FD0335D28F24C02B98871C19D36")

        private static final float INFLEXION = 0.35f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:43.605 -0500", hash_original_field = "653B83F079B802968D9D4986FC38099D", hash_generated_field = "A93A505D9C6A8EC9F395D0DADBA4FB3A")

        private static final float START_TENSION = 0.5f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:43.607 -0500", hash_original_field = "53D698B5F3D938FF6A1B75175E546D4A", hash_generated_field = "E5BC907466FF72E47B72F7A5358BEBA3")

        private static final float END_TENSION = 1.0f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:43.610 -0500", hash_original_field = "3BC961A8110290C583D698CCAA161284", hash_generated_field = "07503A6558E00C157F6DAEB1FFF235FB")

        private static final float P1 = START_TENSION * INFLEXION;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:43.612 -0500", hash_original_field = "F14740CAE9C0CFFA20B887FD296003AD", hash_generated_field = "AED1851DFEA041A28688E66279A924B5")

        private static final float P2 = 1.0f - END_TENSION * (1.0f - INFLEXION);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:43.616 -0500", hash_original_field = "58559D9CC258992DAA0836486C11E2A8", hash_generated_field = "3B6A479A94E023469276FA3773CA8C8D")

        private static final int NB_SAMPLES = 100;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:43.618 -0500", hash_original_field = "CEF7546ED3EE941FD6A49F0FE374EEA9", hash_generated_field = "AFB1C8ECA979DA21163AB6B7EDBBE826")

        private static final float[] SPLINE_POSITION = new float[NB_SAMPLES + 1];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:43.620 -0500", hash_original_field = "0E8B3A58C26E3D298B0E5894AC62B3D2", hash_generated_field = "54A23A411E21AEAF5076D8B767D6B0BA")

        private static final float[] SPLINE_TIME = new float[NB_SAMPLES + 1];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:43.623 -0500", hash_original_field = "42AB573D0C776462DA61CB0E5CC70B9A", hash_generated_field = "AA9C489F36CD6D35B08E97A0F1D114BF")

        private static final int SPLINE = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:43.626 -0500", hash_original_field = "787F2A741668196101DEED5B4184D849", hash_generated_field = "C623FEAD42C4A32B51D627806375CF8A")

        private static final int CUBIC = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:43.628 -0500", hash_original_field = "C9F7F255B28C18E43C341F6A0AD41794", hash_generated_field = "DD51F66F60B0FB6BDDD97689538B82F5")

        private static final int BALLISTIC = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:43.563 -0500", hash_original_field = "83A19D93B82C07A79F54E265C2077EC6", hash_generated_field = "D233E3389CE5D79EE6040D6A855ED4FF")

        private int mStart;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:43.566 -0500", hash_original_field = "FDB983BF68B1AB3D59C99C7EAB19AB61", hash_generated_field = "FE13D76CBAD645EF7CF68CBEE24BE852")

        private int mCurrentPosition;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:43.568 -0500", hash_original_field = "F6AAB21300AEC7A83EDAD5BA2FCDE5C6", hash_generated_field = "11513992D0933717F94CBC19E723AC8C")

        private int mFinal;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:43.570 -0500", hash_original_field = "F2A2A685CAF2908766EAAE52DD58145A", hash_generated_field = "85E3A40D11424915EEDA19E22E0F1268")

        private int mVelocity;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:43.572 -0500", hash_original_field = "AF026B5A9A4E0398DE6E8F2FBAB49AF4", hash_generated_field = "3B97D5E15B121E7CEE691E293BAEE40C")

        private float mCurrVelocity;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:43.574 -0500", hash_original_field = "94A6EE72E23F9750788C83A9DEAFE695", hash_generated_field = "C2BDDF1F4D015B5A70949ADE337CCAA9")

        private float mDeceleration;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:43.576 -0500", hash_original_field = "3C3A30DDD94D9D47CBB52C3848791CE7", hash_generated_field = "20EEDA67D8E4F20D3E4CA3D911CCA492")

        private long mStartTime;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:43.578 -0500", hash_original_field = "BC345057CF9CBE8611DA24E477E3EC27", hash_generated_field = "A658ABE5235D82E385D992CF2A9ACD3B")

        private int mDuration;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:43.581 -0500", hash_original_field = "C67842630520E5E0FBC2D6F7106799EC", hash_generated_field = "721D132701D554EDB5BAB6B0C82BA2AD")

        private int mSplineDuration;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:43.583 -0500", hash_original_field = "FACC1F1B01E10FBCE00161E4E11313CC", hash_generated_field = "FB2527AAF2413392A894AD48A7665B3E")

        private int mSplineDistance;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:43.585 -0500", hash_original_field = "10598AB9B4F301B505526794EAE9EAF0", hash_generated_field = "0B1DE3EEB5BF08E36FD9B568D72D59CC")

        private boolean mFinished;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:43.588 -0500", hash_original_field = "7569127F59D815DB6C47B0B302179E90", hash_generated_field = "7BDE7217F050298D12691D81F08CF1E5")

        private int mOver;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:43.590 -0500", hash_original_field = "4B267A163ED4D047BC639F6537B06802", hash_generated_field = "EC2A2C9A1BD34813CE9F1C74E40F5693")

        private float mFlingFriction = ViewConfiguration.getScrollFriction();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:43.592 -0500", hash_original_field = "602BD56F01514B12A0DD80D2EF5997B9", hash_generated_field = "2497C3234CC32F88C528B3987263033C")

        private int mState = SPLINE;

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:43.636 -0500", hash_original_method = "D0177E162854BD0B51587B46D28F0B6A", hash_generated_method = "D0177E162854BD0B51587B46D28F0B6A")
        
SplineOverScroller() {
            mFinished = true;
        }

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:43.633 -0500", hash_original_method = "9532D02E94E4EAFA434C124BD0A8F760", hash_generated_method = "9532D02E94E4EAFA434C124BD0A8F760")
        
void setFriction(float friction) {
            mFlingFriction = friction;
        }

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:43.638 -0500", hash_original_method = "64F0298C66739A6C01CABFBC1A2B2075", hash_generated_method = "64F0298C66739A6C01CABFBC1A2B2075")
        
void updateScroll(float q) {
            mCurrentPosition = mStart + Math.round(q * (mFinal - mStart));
        }

        /*
         * Modifies mDuration to the duration it takes to get from start to newFinal using the
         * spline interpolation. The previous duration was needed to get to oldFinal.
         */
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:43.643 -0500", hash_original_method = "97FBA6B7752D67B719405DAE507B2D91", hash_generated_method = "BD91AD6668A141299A08D86F21BA5481")
        
private void adjustDuration(int start, int oldFinal, int newFinal) {
            final int oldDistance = oldFinal - start;
            final int newDistance = newFinal - start;
            final float x = Math.abs((float) newDistance / oldDistance);
            final int index = (int) (NB_SAMPLES * x);
            if (index < NB_SAMPLES) {
                final float x_inf = (float) index / NB_SAMPLES;
                final float x_sup = (float) (index + 1) / NB_SAMPLES;
                final float t_inf = SPLINE_TIME[index];
                final float t_sup = SPLINE_TIME[index + 1];
                final float timeCoef = t_inf + (x - x_inf) / (x_sup - x_inf) * (t_sup - t_inf);
                mDuration *= timeCoef;
            }
        }

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:43.645 -0500", hash_original_method = "171266C35C248ABBEE6A2AAA833A0F85", hash_generated_method = "4E4B7A93597B80B93714836891060964")
        
void startScroll(int start, int distance, int duration) {
            mFinished = false;

            mStart = start;
            mFinal = start + distance;

            mStartTime = AnimationUtils.currentAnimationTimeMillis();
            mDuration = duration;

            // Unused
            mDeceleration = 0.0f;
            mVelocity = 0;
        }

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:43.647 -0500", hash_original_method = "435B8A6291C462C3A88DC285D8A7A1BB", hash_generated_method = "499F02C42A63A57AFF143241293C7505")
        
void finish() {
            mCurrentPosition = mFinal;
            // Not reset since WebView relies on this value for fast fling.
            // TODO: restore when WebView uses the fast fling implemented in this class.
            // mCurrVelocity = 0.0f;
            mFinished = true;
        }

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:43.649 -0500", hash_original_method = "0F10BE4F5BE9DF7795DBE421341ADDA6", hash_generated_method = "0F10BE4F5BE9DF7795DBE421341ADDA6")
        
void setFinalPosition(int position) {
            mFinal = position;
            mFinished = false;
        }

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:43.652 -0500", hash_original_method = "7F220CB7E5E59F74D99C7454C47E42C7", hash_generated_method = "7F220CB7E5E59F74D99C7454C47E42C7")
        
void extendDuration(int extend) {
            final long time = AnimationUtils.currentAnimationTimeMillis();
            final int elapsedTime = (int) (time - mStartTime);
            mDuration = elapsedTime + extend;
            mFinished = false;
        }

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:43.654 -0500", hash_original_method = "D12AE2ECF55023F539A88C111AC438E6", hash_generated_method = "D12AE2ECF55023F539A88C111AC438E6")
        
boolean springback(int start, int min, int max) {
            mFinished = true;

            mStart = mFinal = start;
            mVelocity = 0;

            mStartTime = AnimationUtils.currentAnimationTimeMillis();
            mDuration = 0;

            if (start < min) {
                startSpringback(start, min, 0);
            } else if (start > max) {
                startSpringback(start, max, 0);
            }

            return !mFinished;
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:43.657 -0500", hash_original_method = "FE4DCB4600DDD23F75B042FA5167B4E7", hash_generated_method = "5EEB3647B9727A89DDE32121BD9073D5")
        
private void startSpringback(int start, int end, int velocity) {
            // mStartTime has been set
            mFinished = false;
            mState = CUBIC;
            mStart = start;
            mFinal = end;
            final int delta = start - end;
            mDeceleration = getDeceleration(delta);
            // TODO take velocity into account
            mVelocity = -delta; // only sign is used
            mOver = Math.abs(delta);
            mDuration = (int) (1000.0 * Math.sqrt(-2.0 * delta / mDeceleration));
        }

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:43.660 -0500", hash_original_method = "8B3E33053E001BDAB851E620AED14FC0", hash_generated_method = "9CCEC886A8C6829D12FB79BF6AB6B441")
        
void fling(int start, int velocity, int min, int max, int over) {
            mOver = over;
            mFinished = false;
            mCurrVelocity = mVelocity = velocity;
            mDuration = mSplineDuration = 0;
            mStartTime = AnimationUtils.currentAnimationTimeMillis();
            mCurrentPosition = mStart = start;

            if (start > max || start < min) {
                startAfterEdge(start, min, max, velocity);
                return;
            }

            mState = SPLINE;
            double totalDistance = 0.0;

            if (velocity != 0) {
                mDuration = mSplineDuration = getSplineFlingDuration(velocity);
                totalDistance = getSplineFlingDistance(velocity);
            }

            mSplineDistance = (int) (totalDistance * Math.signum(velocity));
            mFinal = start + mSplineDistance;

            // Clamp to a valid final position
            if (mFinal < min) {
                adjustDuration(mStart, mFinal, min);
                mFinal = min;
            }

            if (mFinal > max) {
                adjustDuration(mStart, mFinal, max);
                mFinal = max;
            }
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:43.662 -0500", hash_original_method = "55451D958AF332430844B13377F10B18", hash_generated_method = "8F7D539B42417DE076155EC24C6FEB96")
        
private double getSplineDeceleration(int velocity) {
            return Math.log(INFLEXION * Math.abs(velocity) / (mFlingFriction * PHYSICAL_COEF));
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:43.664 -0500", hash_original_method = "7888FBEE8D14061C2ED981410CC88AC0", hash_generated_method = "58476E0AC7D69B1F96009EE7DA8B01DF")
        
private double getSplineFlingDistance(int velocity) {
            final double l = getSplineDeceleration(velocity);
            final double decelMinusOne = DECELERATION_RATE - 1.0;
            return mFlingFriction * PHYSICAL_COEF * Math.exp(DECELERATION_RATE / decelMinusOne * l);
        }

        /* Returns the duration, expressed in milliseconds */
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:43.666 -0500", hash_original_method = "1F09855DFC7D15DA5ECD081A4B3F581B", hash_generated_method = "84F3E948F3C80429FD5AF0BE148C7FC7")
        
private int getSplineFlingDuration(int velocity) {
            final double l = getSplineDeceleration(velocity);
            final double decelMinusOne = DECELERATION_RATE - 1.0;
            return (int) (1000.0 * Math.exp(l / decelMinusOne));
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:43.669 -0500", hash_original_method = "C51353CD784B93D7179DA830597304C4", hash_generated_method = "E3E97A78EE38983A79AED34F0926A38C")
        
private void fitOnBounceCurve(int start, int end, int velocity) {
            // Simulate a bounce that started from edge
            final float durationToApex = - velocity / mDeceleration;
            final float distanceToApex = velocity * velocity / 2.0f / Math.abs(mDeceleration);
            final float distanceToEdge = Math.abs(end - start);
            final float totalDuration = (float) Math.sqrt(
                    2.0 * (distanceToApex + distanceToEdge) / Math.abs(mDeceleration));
            mStartTime -= (int) (1000.0f * (totalDuration - durationToApex));
            mStart = end;
            mVelocity = (int) (- mDeceleration * totalDuration);
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:43.672 -0500", hash_original_method = "5D48F28010F8FCB9211B58C3C36EC8CC", hash_generated_method = "9091647D3DB6B466F7894CBAA1999489")
        
private void startBounceAfterEdge(int start, int end, int velocity) {
            mDeceleration = getDeceleration(velocity == 0 ? start - end : velocity);
            fitOnBounceCurve(start, end, velocity);
            onEdgeReached();
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:43.675 -0500", hash_original_method = "E644EF955DC6FD722F53E2DD199A395E", hash_generated_method = "E87140B36220D303C5E00D408D9FF277")
        
private void startAfterEdge(int start, int min, int max, int velocity) {
            if (start > min && start < max) {
                Log.e("OverScroller", "startAfterEdge called from a valid position");
                mFinished = true;
                return;
            }
            final boolean positive = start > max;
            final int edge = positive ? max : min;
            final int overDistance = start - edge;
            boolean keepIncreasing = overDistance * velocity >= 0;
            if (keepIncreasing) {
                // Will result in a bounce or a to_boundary depending on velocity.
                startBounceAfterEdge(start, edge, velocity);
            } else {
                final double totalDistance = getSplineFlingDistance(velocity);
                if (totalDistance > Math.abs(overDistance)) {
                    fling(start, velocity, positive ? min : start, positive ? start : max, mOver);
                } else {
                    startSpringback(start, edge, velocity);
                }
            }
        }

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:43.677 -0500", hash_original_method = "D032297ACDC9C65A50161DCB548F10DC", hash_generated_method = "C5CBAA8CCD9CF5490686919E71322F50")
        
void notifyEdgeReached(int start, int end, int over) {
            // mState is used to detect successive notifications 
            if (mState == SPLINE) {
                mOver = over;
                mStartTime = AnimationUtils.currentAnimationTimeMillis();
                // We were in fling/scroll mode before: current velocity is such that distance to
                // edge is increasing. This ensures that startAfterEdge will not start a new fling.
                startAfterEdge(start, end, end, (int) mCurrVelocity);
            }
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:43.679 -0500", hash_original_method = "4D9D443F2B4C6EC9AAAB1FF452014EB4", hash_generated_method = "4B3F2A6A3ED4A6457D048014ADCBB284")
        
private void onEdgeReached() {
            // mStart, mVelocity and mStartTime were adjusted to their values when edge was reached.
            float distance = mVelocity * mVelocity / (2.0f * Math.abs(mDeceleration));
            final float sign = Math.signum(mVelocity);

            if (distance > mOver) {
                // Default deceleration is not sufficient to slow us down before boundary
                 mDeceleration = - sign * mVelocity * mVelocity / (2.0f * mOver);
                 distance = mOver;
            }

            mOver = (int) distance;
            mState = BALLISTIC;
            mFinal = mStart + (int) (mVelocity > 0 ? distance : -distance);
            mDuration = - (int) (1000.0f * mVelocity / mDeceleration);
        }

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:43.682 -0500", hash_original_method = "6FDA077121143820AC37360810DDE80A", hash_generated_method = "14215DCE62FD88A5E3D19141ACD42A8B")
        
boolean continueWhenFinished() {
            switch (mState) {
                case SPLINE:
                    // Duration from start to null velocity
                    if (mDuration < mSplineDuration) {
                        // If the animation was clamped, we reached the edge
                        mStart = mFinal;
                        // TODO Better compute speed when edge was reached
                        mVelocity = (int) mCurrVelocity;
                        mDeceleration = getDeceleration(mVelocity);
                        mStartTime += mDuration;
                        onEdgeReached();
                    } else {
                        // Normal stop, no need to continue
                        return false;
                    }
                    break;
                case BALLISTIC:
                    mStartTime += mDuration;
                    startSpringback(mFinal, mStart, 0);
                    break;
                case CUBIC:
                    return false;
            }

            update();
            return true;
        }

        /*
         * Update the current position and velocity for current time. Returns
         * true if update has been done and false if animation duration has been
         * reached.
         */
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:43.685 -0500", hash_original_method = "36FADD2423F4A31EF1611CA012E37B33", hash_generated_method = "36FADD2423F4A31EF1611CA012E37B33")
        
boolean update() {
            final long time = AnimationUtils.currentAnimationTimeMillis();
            final long currentTime = time - mStartTime;

            if (currentTime > mDuration) {
                return false;
            }

            double distance = 0.0;
            switch (mState) {
                case SPLINE: {
                    final float t = (float) currentTime / mSplineDuration;
                    final int index = (int) (NB_SAMPLES * t);
                    float distanceCoef = 1.f;
                    float velocityCoef = 0.f;
                    if (index < NB_SAMPLES) {
                        final float t_inf = (float) index / NB_SAMPLES;
                        final float t_sup = (float) (index + 1) / NB_SAMPLES;
                        final float d_inf = SPLINE_POSITION[index];
                        final float d_sup = SPLINE_POSITION[index + 1];
                        velocityCoef = (d_sup - d_inf) / (t_sup - t_inf);
                        distanceCoef = d_inf + (t - t_inf) * velocityCoef;
                    }

                    distance = distanceCoef * mSplineDistance;
                    mCurrVelocity = velocityCoef * mSplineDistance / mSplineDuration * 1000.0f;
                    break;
                }

                case BALLISTIC: {
                    final float t = currentTime / 1000.0f;
                    mCurrVelocity = mVelocity + mDeceleration * t;
                    distance = mVelocity * t + mDeceleration * t * t / 2.0f;
                    break;
                }

                case CUBIC: {
                    final float t = (float) (currentTime) / mDuration;
                    final float t2 = t * t;
                    final float sign = Math.signum(mVelocity);
                    distance = sign * mOver * (3.0f * t2 - 2.0f * t * t2); 
                    mCurrVelocity = sign * mOver * 6.0f * (- t + t2); 
                    break;
                }
            }

            mCurrentPosition = mStart + (int) Math.round(distance);

            return true;
        }
        static {
            float x_min = 0.0f;
            float y_min = 0.0f;
            for (int i = 0; i < NB_SAMPLES; i++) {
                final float alpha = (float) i / NB_SAMPLES;
                float x_max = 1.0f;
                float x, tx, coef;
                while (true) {
                    x = x_min + (x_max - x_min) / 2.0f;
                    coef = 3.0f * x * (1.0f - x);
                    tx = coef * ((1.0f - x) * P1 + x * P2) + x * x * x;
                    if (Math.abs(tx - alpha) < 1E-5) break;
                    if (tx > alpha) x_max = x;
                    else x_min = x;
                }
                SPLINE_POSITION[i] = coef * ((1.0f - x) * START_TENSION + x) + x * x * x;
                float y_max = 1.0f;
                float y, dy;
                while (true) {
                    y = y_min + (y_max - y_min) / 2.0f;
                    coef = 3.0f * y * (1.0f - y);
                    dy = coef * ((1.0f - y) * START_TENSION + y) + y * y * y;
                    if (Math.abs(dy - alpha) < 1E-5) break;
                    if (dy > alpha) y_max = y;
                    else y_min = y;
                }
                SPLINE_TIME[i] = coef * ((1.0f - y) * P1 + y * P2) + y * y * y;
            }
            SPLINE_POSITION[NB_SAMPLES] = SPLINE_TIME[NB_SAMPLES] = 1.0f;
        }
        
    }

    /**
     * Stops the animation. Contrary to {@link #forceFinished(boolean)},
     * aborting the animating causes the scroller to move to the final x and y
     * positions.
     *
     * @see #forceFinished(boolean)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:43.556 -0500", hash_original_method = "E56D99D09F46A8AEF8DD628D53F963A5", hash_generated_method = "DF9BAD7B315AA83FCD459BD28184D3D4")
    
public void abortAnimation() {
        mScrollerX.finish();
        mScrollerY.finish();
    }

    /**
     * Returns the time elapsed since the beginning of the scrolling.
     *
     * @return The elapsed time in milliseconds.
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:43.558 -0500", hash_original_method = "6776820FB8E88CBACCBB30EFABCCA565", hash_generated_method = "065503F9B989D3D0FA336BA1746F0CEC")
    
public int timePassed() {
        final long time = AnimationUtils.currentAnimationTimeMillis();
        final long startTime = Math.min(mScrollerX.mStartTime, mScrollerY.mStartTime);
        return (int) (time - startTime);
    }

    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:43.561 -0500", hash_original_method = "EC43B1555D38CD3A665472CFA4E77643", hash_generated_method = "5B9DB99DD313336FE85CC41015BDF260")
    
public boolean isScrollingInDirection(float xvel, float yvel) {
        final int dx = mScrollerX.mFinal - mScrollerX.mStart;
        final int dy = mScrollerY.mFinal - mScrollerY.mStart;
        return !isFinished() && Math.signum(xvel) == Math.signum(dx) &&
                Math.signum(yvel) == Math.signum(dy);
    }
}

