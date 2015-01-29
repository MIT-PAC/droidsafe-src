package android.webkit;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.widget.EdgeEffect;

public class OverScrollGlow {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.052 -0500", hash_original_field = "A259E25B56B1E2C249B25928B3EAB4CE", hash_generated_field = "1629930CD96E325649F3C70757D5A77E")

    private WebView mHostView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.054 -0500", hash_original_field = "EBA81B43EFC8B93C48CA8AD590604F1F", hash_generated_field = "E572968A85247BF2ECB5635FFF539C2E")

    private EdgeEffect mEdgeGlowTop;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.056 -0500", hash_original_field = "726BFD4CA9E773D9EEEE503CF0DA68EC", hash_generated_field = "D2A4A7BE91BF29EB90E114C9648825A6")

    private EdgeEffect mEdgeGlowBottom;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.058 -0500", hash_original_field = "AB466C21A8C0EFB1258BE5B8AEDC0AEE", hash_generated_field = "CF32CFBB2A976E850EE8DDE803F384D7")

    private EdgeEffect mEdgeGlowLeft;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.060 -0500", hash_original_field = "D72EE1527B1D097DEA57A6FAE9C1FBB8", hash_generated_field = "304A2CBEA7C331CEDE170973F40765C0")

    private EdgeEffect mEdgeGlowRight;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.062 -0500", hash_original_field = "E38814A3396356DC25699ED6493A8FE8", hash_generated_field = "BEE327B00350EFBA85A5178322BF5A0D")

    private int mOverScrollDeltaX;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.064 -0500", hash_original_field = "1BFC9036B4E52C707EC789B14D85613F", hash_generated_field = "E1700EBF6A8242E4CC987AD366097B8C")

    private int mOverScrollDeltaY;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.067 -0500", hash_original_method = "C880ED290A9E3BE27C712EA7FDA57F5B", hash_generated_method = "0E972441ECFF500943544A8F36AF7BA5")
    
public OverScrollGlow(WebView host) {
        mHostView = host;
        Context context = host.getContext();
        mEdgeGlowTop = new EdgeEffect(context);
        mEdgeGlowBottom = new EdgeEffect(context);
        mEdgeGlowLeft = new EdgeEffect(context);
        mEdgeGlowRight = new EdgeEffect(context);
    }

    /**
     * Pull leftover touch scroll distance into one of the edge glows as appropriate.
     *
     * @param x Current X scroll offset
     * @param y Current Y scroll offset
     * @param oldX Old X scroll offset
     * @param oldY Old Y scroll offset
     * @param maxX Maximum range for horizontal scrolling
     * @param maxY Maximum range for vertical scrolling
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.070 -0500", hash_original_method = "951D1D5C70B11C07C923672F61940F77", hash_generated_method = "BE0BAB7464A6094DAA845AD88E774BE9")
    
public void pullGlow(int x, int y, int oldX, int oldY, int maxX, int maxY) {
        // Only show overscroll bars if there was no movement in any direction
        // as a result of scrolling.
        if (oldX == mHostView.getScrollX() && oldY == mHostView.getScrollY()) {
            // Don't show left/right glows if we fit the whole content.
            // Also don't show if there was vertical movement.
            if (maxX > 0) {
                final int pulledToX = oldX + mOverScrollDeltaX;
                if (pulledToX < 0) {
                    mEdgeGlowLeft.onPull((float) mOverScrollDeltaX / mHostView.getWidth());
                    if (!mEdgeGlowRight.isFinished()) {
                        mEdgeGlowRight.onRelease();
                    }
                } else if (pulledToX > maxX) {
                    mEdgeGlowRight.onPull((float) mOverScrollDeltaX / mHostView.getWidth());
                    if (!mEdgeGlowLeft.isFinished()) {
                        mEdgeGlowLeft.onRelease();
                    }
                }
                mOverScrollDeltaX = 0;
            }

            if (maxY > 0 || mHostView.getOverScrollMode() == View.OVER_SCROLL_ALWAYS) {
                final int pulledToY = oldY + mOverScrollDeltaY;
                if (pulledToY < 0) {
                    mEdgeGlowTop.onPull((float) mOverScrollDeltaY / mHostView.getHeight());
                    if (!mEdgeGlowBottom.isFinished()) {
                        mEdgeGlowBottom.onRelease();
                    }
                } else if (pulledToY > maxY) {
                    mEdgeGlowBottom.onPull((float) mOverScrollDeltaY / mHostView.getHeight());
                    if (!mEdgeGlowTop.isFinished()) {
                        mEdgeGlowTop.onRelease();
                    }
                }
                mOverScrollDeltaY = 0;
            }
        }
    }

    /**
     * Set touch delta values indicating the current amount of overscroll.
     *
     * @param deltaX
     * @param deltaY
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.072 -0500", hash_original_method = "898E1992D368021CDA53745F0D37B2ED", hash_generated_method = "7E9DF41DF751C9755D47BC5EDCA453DB")
    
public void setOverScrollDeltas(int deltaX, int deltaY) {
        mOverScrollDeltaX = deltaX;
        mOverScrollDeltaY = deltaY;
    }

    /**
     * Absorb leftover fling velocity into one of the edge glows as appropriate.
     *
     * @param x Current X scroll offset
     * @param y Current Y scroll offset
     * @param oldX Old X scroll offset
     * @param oldY Old Y scroll offset
     * @param rangeX Maximum range for horizontal scrolling
     * @param rangeY Maximum range for vertical scrolling
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.075 -0500", hash_original_method = "559A3475151AFD9F125F7EFF6D7FC3A7", hash_generated_method = "05BCDD7C20C6D87D800888A86047830C")
    
public void absorbGlow(int x, int y, int oldX, int oldY, int rangeX, int rangeY) {
        if (rangeY > 0 || mHostView.getOverScrollMode() == View.OVER_SCROLL_ALWAYS) {
            if (y < 0 && oldY >= 0) {
                mEdgeGlowTop.onAbsorb((int) mHostView.mScroller.getCurrVelocity());
                if (!mEdgeGlowBottom.isFinished()) {
                    mEdgeGlowBottom.onRelease();
                }
            } else if (y > rangeY && oldY <= rangeY) {
                mEdgeGlowBottom.onAbsorb((int) mHostView.mScroller.getCurrVelocity());
                if (!mEdgeGlowTop.isFinished()) {
                    mEdgeGlowTop.onRelease();
                }
            }
        }

        if (rangeX > 0) {
            if (x < 0 && oldX >= 0) {
                mEdgeGlowLeft.onAbsorb((int) mHostView.mScroller.getCurrVelocity());
                if (!mEdgeGlowRight.isFinished()) {
                    mEdgeGlowRight.onRelease();
                }
            } else if (x > rangeX && oldX <= rangeX) {
                mEdgeGlowRight.onAbsorb((int) mHostView.mScroller.getCurrVelocity());
                if (!mEdgeGlowLeft.isFinished()) {
                    mEdgeGlowLeft.onRelease();
                }
            }
        }
    }

    /**
     * Draw the glow effect along the sides of the widget. mEdgeGlow* must be non-null.
     *
     * @param canvas Canvas to draw into, transformed into view coordinates.
     * @return true if glow effects are still animating and the view should invalidate again.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.078 -0500", hash_original_method = "3B1E2223EF9E382987FDA8605560E6C8", hash_generated_method = "D66AB9153BDBC7F8146A05E91D86891E")
    
public boolean drawEdgeGlows(Canvas canvas) {
        final int scrollX = mHostView.getScrollX();
        final int scrollY = mHostView.getScrollY();
        final int width = mHostView.getWidth();
        int height = mHostView.getHeight();

        boolean invalidateForGlow = false;
        if (!mEdgeGlowTop.isFinished()) {
            final int restoreCount = canvas.save();

            canvas.translate(scrollX, mHostView.getVisibleTitleHeight() + Math.min(0, scrollY));
            mEdgeGlowTop.setSize(width, height);
            invalidateForGlow |= mEdgeGlowTop.draw(canvas);
            canvas.restoreToCount(restoreCount);
        }
        if (!mEdgeGlowBottom.isFinished()) {
            final int restoreCount = canvas.save();

            canvas.translate(-width + scrollX, Math.max(mHostView.computeMaxScrollY(), scrollY)
                    + height);
            canvas.rotate(180, width, 0);
            mEdgeGlowBottom.setSize(width, height);
            invalidateForGlow |= mEdgeGlowBottom.draw(canvas);
            canvas.restoreToCount(restoreCount);
        }
        if (!mEdgeGlowLeft.isFinished()) {
            final int restoreCount = canvas.save();

            canvas.rotate(270);
            canvas.translate(-height - scrollY, Math.min(0, scrollX));
            mEdgeGlowLeft.setSize(height, width);
            invalidateForGlow |= mEdgeGlowLeft.draw(canvas);
            canvas.restoreToCount(restoreCount);
        }
        if (!mEdgeGlowRight.isFinished()) {
            final int restoreCount = canvas.save();

            canvas.rotate(90);
            canvas.translate(scrollY,
                    -(Math.max(mHostView.computeMaxScrollX(), scrollX) + width));
            mEdgeGlowRight.setSize(height, width);
            invalidateForGlow |= mEdgeGlowRight.draw(canvas);
            canvas.restoreToCount(restoreCount);
        }
        return invalidateForGlow;
    }

    /**
     * @return True if any glow is still animating
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.080 -0500", hash_original_method = "991A6F9A141C4C9221BF71360DEAB6AF", hash_generated_method = "B1BC2304773E9D442ACACBA1CEE32A31")
    
public boolean isAnimating() {
        return (!mEdgeGlowTop.isFinished() || !mEdgeGlowBottom.isFinished() ||
                !mEdgeGlowLeft.isFinished() || !mEdgeGlowRight.isFinished());
    }

    /**
     * Release all glows from any touch pulls in progress.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:41.082 -0500", hash_original_method = "F2C1801AA96B9D8F59B00F59054F0306", hash_generated_method = "F79F23C32867CAB3FEB10F1A45A86897")
    
public void releaseAll() {
        mEdgeGlowTop.onRelease();
        mEdgeGlowBottom.onRelease();
        mEdgeGlowLeft.onRelease();
        mEdgeGlowRight.onRelease();
    }
    
}

