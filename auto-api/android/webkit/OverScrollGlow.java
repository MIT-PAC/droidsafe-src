package android.webkit;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import com.android.internal.R;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.EdgeEffect;

public class OverScrollGlow {
    private WebView mHostView;
    private EdgeEffect mEdgeGlowTop;
    private EdgeEffect mEdgeGlowBottom;
    private EdgeEffect mEdgeGlowLeft;
    private EdgeEffect mEdgeGlowRight;
    private int mOverScrollDeltaX;
    private int mOverScrollDeltaY;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.609 -0400", hash_original_method = "C880ED290A9E3BE27C712EA7FDA57F5B", hash_generated_method = "04CB0C5552CB35D5DA61E0ACA87BC980")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public OverScrollGlow(WebView host) {
        dsTaint.addTaint(host.dsTaint);
        Context context;
        context = host.getContext();
        mEdgeGlowTop = new EdgeEffect(context);
        mEdgeGlowBottom = new EdgeEffect(context);
        mEdgeGlowLeft = new EdgeEffect(context);
        mEdgeGlowRight = new EdgeEffect(context);
        // ---------- Original Method ----------
        //mHostView = host;
        //Context context = host.getContext();
        //mEdgeGlowTop = new EdgeEffect(context);
        //mEdgeGlowBottom = new EdgeEffect(context);
        //mEdgeGlowLeft = new EdgeEffect(context);
        //mEdgeGlowRight = new EdgeEffect(context);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.609 -0400", hash_original_method = "951D1D5C70B11C07C923672F61940F77", hash_generated_method = "EDE685A2E512F519B51648EBC386CDDF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void pullGlow(int x, int y, int oldX, int oldY, int maxX, int maxY) {
        dsTaint.addTaint(maxY);
        dsTaint.addTaint(maxX);
        dsTaint.addTaint(oldY);
        dsTaint.addTaint(oldX);
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        {
            boolean varF68DD10307297B92A02D609B34219301_1298276744 = (oldX == mHostView.getScrollX() && oldY == mHostView.getScrollY());
            {
                {
                    int pulledToX;
                    pulledToX = oldX + mOverScrollDeltaX;
                    {
                        mEdgeGlowLeft.onPull((float) mOverScrollDeltaX / mHostView.getWidth());
                        {
                            boolean var3F17091DDB7792B5828D13564A2E2259_750211247 = (!mEdgeGlowRight.isFinished());
                            {
                                mEdgeGlowRight.onRelease();
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                    {
                        mEdgeGlowRight.onPull((float) mOverScrollDeltaX / mHostView.getWidth());
                        {
                            boolean varF350524CC4E0B21CB0ADBA87431224A0_2101465103 = (!mEdgeGlowLeft.isFinished());
                            {
                                mEdgeGlowLeft.onRelease();
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                    mOverScrollDeltaX = 0;
                } //End block
                {
                    boolean varB5F7B4AEB9A84016B30E16CF2832D7F3_730047101 = (maxY > 0 || mHostView.getOverScrollMode() == View.OVER_SCROLL_ALWAYS);
                    {
                        int pulledToY;
                        pulledToY = oldY + mOverScrollDeltaY;
                        {
                            mEdgeGlowTop.onPull((float) mOverScrollDeltaY / mHostView.getHeight());
                            {
                                boolean var276ACB79DBE335E284B4ACF758CD152B_1253297501 = (!mEdgeGlowBottom.isFinished());
                                {
                                    mEdgeGlowBottom.onRelease();
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                        {
                            mEdgeGlowBottom.onPull((float) mOverScrollDeltaY / mHostView.getHeight());
                            {
                                boolean varE32E609A3E675042D0E7EBF450CA3CA9_1050612059 = (!mEdgeGlowTop.isFinished());
                                {
                                    mEdgeGlowTop.onRelease();
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                        mOverScrollDeltaY = 0;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.610 -0400", hash_original_method = "898E1992D368021CDA53745F0D37B2ED", hash_generated_method = "F1D3DB16957326A103A2C5BDC5C17F24")
    @DSModeled(DSC.SAFE)
    public void setOverScrollDeltas(int deltaX, int deltaY) {
        dsTaint.addTaint(deltaX);
        dsTaint.addTaint(deltaY);
        // ---------- Original Method ----------
        //mOverScrollDeltaX = deltaX;
        //mOverScrollDeltaY = deltaY;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.610 -0400", hash_original_method = "559A3475151AFD9F125F7EFF6D7FC3A7", hash_generated_method = "D79C92B39F3E7159ADE4E8ACB6E5C6E6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void absorbGlow(int x, int y, int oldX, int oldY, int rangeX, int rangeY) {
        dsTaint.addTaint(rangeX);
        dsTaint.addTaint(rangeY);
        dsTaint.addTaint(oldY);
        dsTaint.addTaint(oldX);
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        {
            boolean varB2DFA8263EC57AB54C396B63C811BF20_1795712802 = (rangeY > 0 || mHostView.getOverScrollMode() == View.OVER_SCROLL_ALWAYS);
            {
                {
                    mEdgeGlowTop.onAbsorb((int) mHostView.mScroller.getCurrVelocity());
                    {
                        boolean varE6213428B20479BD32BF17B140F5ED52_233979100 = (!mEdgeGlowBottom.isFinished());
                        {
                            mEdgeGlowBottom.onRelease();
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    mEdgeGlowBottom.onAbsorb((int) mHostView.mScroller.getCurrVelocity());
                    {
                        boolean var5D6A56784A8F83A042E55ED0998DBE18_1908808423 = (!mEdgeGlowTop.isFinished());
                        {
                            mEdgeGlowTop.onRelease();
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End block
        } //End collapsed parenthetic
        {
            {
                mEdgeGlowLeft.onAbsorb((int) mHostView.mScroller.getCurrVelocity());
                {
                    boolean var4A8F0EC4B9753343944B27E4680F1D79_612074784 = (!mEdgeGlowRight.isFinished());
                    {
                        mEdgeGlowRight.onRelease();
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                mEdgeGlowRight.onAbsorb((int) mHostView.mScroller.getCurrVelocity());
                {
                    boolean var039ECE236F2F8C15702C208D0DD4F509_2029382762 = (!mEdgeGlowLeft.isFinished());
                    {
                        mEdgeGlowLeft.onRelease();
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.611 -0400", hash_original_method = "3B1E2223EF9E382987FDA8605560E6C8", hash_generated_method = "0CC94A68A25CE597454760C952396C1E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean drawEdgeGlows(Canvas canvas) {
        dsTaint.addTaint(canvas.dsTaint);
        int scrollX;
        scrollX = mHostView.getScrollX();
        int scrollY;
        scrollY = mHostView.getScrollY();
        int width;
        width = mHostView.getWidth();
        int height;
        height = mHostView.getHeight();
        boolean invalidateForGlow;
        invalidateForGlow = false;
        {
            boolean var93A7452989D6AE338103A833EC394509_907671661 = (!mEdgeGlowTop.isFinished());
            {
                int restoreCount;
                restoreCount = canvas.save();
                canvas.translate(scrollX, mHostView.getVisibleTitleHeight() + Math.min(0, scrollY));
                mEdgeGlowTop.setSize(width, height);
                invalidateForGlow |= mEdgeGlowTop.draw(canvas);
                canvas.restoreToCount(restoreCount);
            } //End block
        } //End collapsed parenthetic
        {
            boolean var0DD641EA1E206ECE7798489D640F38E6_931289158 = (!mEdgeGlowBottom.isFinished());
            {
                int restoreCount;
                restoreCount = canvas.save();
                canvas.translate(-width + scrollX, Math.max(mHostView.computeMaxScrollY(), scrollY)
                    + height);
                canvas.rotate(180, width, 0);
                mEdgeGlowBottom.setSize(width, height);
                invalidateForGlow |= mEdgeGlowBottom.draw(canvas);
                canvas.restoreToCount(restoreCount);
            } //End block
        } //End collapsed parenthetic
        {
            boolean varCD4447A22CEC6A447F77A0E97A2CAB04_1524032741 = (!mEdgeGlowLeft.isFinished());
            {
                int restoreCount;
                restoreCount = canvas.save();
                canvas.rotate(270);
                canvas.translate(-height - scrollY, Math.min(0, scrollX));
                mEdgeGlowLeft.setSize(height, width);
                invalidateForGlow |= mEdgeGlowLeft.draw(canvas);
                canvas.restoreToCount(restoreCount);
            } //End block
        } //End collapsed parenthetic
        {
            boolean var32F3613820E19780B8144F85DB57781E_598869527 = (!mEdgeGlowRight.isFinished());
            {
                int restoreCount;
                restoreCount = canvas.save();
                canvas.rotate(90);
                canvas.translate(scrollY,
                    -(Math.max(mHostView.computeMaxScrollX(), scrollX) + width));
                mEdgeGlowRight.setSize(height, width);
                invalidateForGlow |= mEdgeGlowRight.draw(canvas);
                canvas.restoreToCount(restoreCount);
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.611 -0400", hash_original_method = "991A6F9A141C4C9221BF71360DEAB6AF", hash_generated_method = "F1E60B6ADFEC1EAE5746CF4FA75D014E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isAnimating() {
        boolean varB61DAF46DE370F07E3CE29F31A7A7035_1097249743 = ((!mEdgeGlowTop.isFinished() || !mEdgeGlowBottom.isFinished() ||
                !mEdgeGlowLeft.isFinished() || !mEdgeGlowRight.isFinished()));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (!mEdgeGlowTop.isFinished() || !mEdgeGlowBottom.isFinished() ||
                //!mEdgeGlowLeft.isFinished() || !mEdgeGlowRight.isFinished());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.612 -0400", hash_original_method = "F2C1801AA96B9D8F59B00F59054F0306", hash_generated_method = "0A16160F8629C218C4D8429A9B957BCF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void releaseAll() {
        mEdgeGlowTop.onRelease();
        mEdgeGlowBottom.onRelease();
        mEdgeGlowLeft.onRelease();
        mEdgeGlowRight.onRelease();
        // ---------- Original Method ----------
        //mEdgeGlowTop.onRelease();
        //mEdgeGlowBottom.onRelease();
        //mEdgeGlowLeft.onRelease();
        //mEdgeGlowRight.onRelease();
    }

    
}

