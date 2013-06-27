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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.276 -0400", hash_original_field = "B6E6A78A9ACB6C4FA6614BAFEDBC05E2", hash_generated_field = "1629930CD96E325649F3C70757D5A77E")

    private WebView mHostView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.276 -0400", hash_original_field = "89E135B7087DB76810F3F37EE0DAB560", hash_generated_field = "E572968A85247BF2ECB5635FFF539C2E")

    private EdgeEffect mEdgeGlowTop;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.276 -0400", hash_original_field = "289036755C83C8893D6004D3220BA45B", hash_generated_field = "D2A4A7BE91BF29EB90E114C9648825A6")

    private EdgeEffect mEdgeGlowBottom;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.276 -0400", hash_original_field = "ACEBD86C89C68033BA00F1E22D2FC23B", hash_generated_field = "CF32CFBB2A976E850EE8DDE803F384D7")

    private EdgeEffect mEdgeGlowLeft;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.276 -0400", hash_original_field = "876C7C33DE6802509886BB6ADFFE041C", hash_generated_field = "304A2CBEA7C331CEDE170973F40765C0")

    private EdgeEffect mEdgeGlowRight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.276 -0400", hash_original_field = "942A9DFE7D0618C3067B543B2C8329CE", hash_generated_field = "BEE327B00350EFBA85A5178322BF5A0D")

    private int mOverScrollDeltaX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.276 -0400", hash_original_field = "332F40191A3B7E3184426D99B2CEBEC3", hash_generated_field = "E1700EBF6A8242E4CC987AD366097B8C")

    private int mOverScrollDeltaY;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.278 -0400", hash_original_method = "C880ED290A9E3BE27C712EA7FDA57F5B", hash_generated_method = "E72FCD1D9D361B60F2438249D4458140")
    public  OverScrollGlow(WebView host) {
        mHostView = host;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.282 -0400", hash_original_method = "951D1D5C70B11C07C923672F61940F77", hash_generated_method = "ACF4B05E933FA8762A683E9187F68ED2")
    public void pullGlow(int x, int y, int oldX, int oldY, int maxX, int maxY) {
        {
            boolean varF68DD10307297B92A02D609B34219301_233206832 = (oldX == mHostView.getScrollX() && oldY == mHostView.getScrollY());
            {
                {
                    int pulledToX;
                    pulledToX = oldX + mOverScrollDeltaX;
                    {
                        mEdgeGlowLeft.onPull((float) mOverScrollDeltaX / mHostView.getWidth());
                        {
                            boolean var3F17091DDB7792B5828D13564A2E2259_1453429849 = (!mEdgeGlowRight.isFinished());
                            {
                                mEdgeGlowRight.onRelease();
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                    {
                        mEdgeGlowRight.onPull((float) mOverScrollDeltaX / mHostView.getWidth());
                        {
                            boolean varF350524CC4E0B21CB0ADBA87431224A0_1186788765 = (!mEdgeGlowLeft.isFinished());
                            {
                                mEdgeGlowLeft.onRelease();
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                    mOverScrollDeltaX = 0;
                } //End block
                {
                    boolean varB5F7B4AEB9A84016B30E16CF2832D7F3_936936414 = (maxY > 0 || mHostView.getOverScrollMode() == View.OVER_SCROLL_ALWAYS);
                    {
                        int pulledToY;
                        pulledToY = oldY + mOverScrollDeltaY;
                        {
                            mEdgeGlowTop.onPull((float) mOverScrollDeltaY / mHostView.getHeight());
                            {
                                boolean var276ACB79DBE335E284B4ACF758CD152B_251990800 = (!mEdgeGlowBottom.isFinished());
                                {
                                    mEdgeGlowBottom.onRelease();
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                        {
                            mEdgeGlowBottom.onPull((float) mOverScrollDeltaY / mHostView.getHeight());
                            {
                                boolean varE32E609A3E675042D0E7EBF450CA3CA9_1855584176 = (!mEdgeGlowTop.isFinished());
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
        addTaint(x);
        addTaint(y);
        addTaint(oldX);
        addTaint(oldY);
        addTaint(maxX);
        addTaint(maxY);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.284 -0400", hash_original_method = "898E1992D368021CDA53745F0D37B2ED", hash_generated_method = "DB9138BBE530C1A27762C46B9EBC1FDA")
    public void setOverScrollDeltas(int deltaX, int deltaY) {
        mOverScrollDeltaX = deltaX;
        mOverScrollDeltaY = deltaY;
        // ---------- Original Method ----------
        //mOverScrollDeltaX = deltaX;
        //mOverScrollDeltaY = deltaY;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.298 -0400", hash_original_method = "559A3475151AFD9F125F7EFF6D7FC3A7", hash_generated_method = "F79C937976B8AA9E59FC27E66B9A6D91")
    public void absorbGlow(int x, int y, int oldX, int oldY, int rangeX, int rangeY) {
        {
            boolean varB2DFA8263EC57AB54C396B63C811BF20_485914928 = (rangeY > 0 || mHostView.getOverScrollMode() == View.OVER_SCROLL_ALWAYS);
            {
                {
                    mEdgeGlowTop.onAbsorb((int) mHostView.mScroller.getCurrVelocity());
                    {
                        boolean varE6213428B20479BD32BF17B140F5ED52_33949722 = (!mEdgeGlowBottom.isFinished());
                        {
                            mEdgeGlowBottom.onRelease();
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    mEdgeGlowBottom.onAbsorb((int) mHostView.mScroller.getCurrVelocity());
                    {
                        boolean var5D6A56784A8F83A042E55ED0998DBE18_472021437 = (!mEdgeGlowTop.isFinished());
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
                    boolean var4A8F0EC4B9753343944B27E4680F1D79_526945669 = (!mEdgeGlowRight.isFinished());
                    {
                        mEdgeGlowRight.onRelease();
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                mEdgeGlowRight.onAbsorb((int) mHostView.mScroller.getCurrVelocity());
                {
                    boolean var039ECE236F2F8C15702C208D0DD4F509_1767256454 = (!mEdgeGlowLeft.isFinished());
                    {
                        mEdgeGlowLeft.onRelease();
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        addTaint(x);
        addTaint(y);
        addTaint(oldX);
        addTaint(oldY);
        addTaint(rangeX);
        addTaint(rangeY);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.300 -0400", hash_original_method = "3B1E2223EF9E382987FDA8605560E6C8", hash_generated_method = "9CDDC2C85810A0873151605983EEE835")
    public boolean drawEdgeGlows(Canvas canvas) {
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
            boolean var93A7452989D6AE338103A833EC394509_120734076 = (!mEdgeGlowTop.isFinished());
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
            boolean var0DD641EA1E206ECE7798489D640F38E6_1837495643 = (!mEdgeGlowBottom.isFinished());
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
            boolean varCD4447A22CEC6A447F77A0E97A2CAB04_1938271429 = (!mEdgeGlowLeft.isFinished());
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
            boolean var32F3613820E19780B8144F85DB57781E_186683499 = (!mEdgeGlowRight.isFinished());
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
        addTaint(canvas.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_777369973 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_777369973;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.315 -0400", hash_original_method = "991A6F9A141C4C9221BF71360DEAB6AF", hash_generated_method = "88DA12DD01A95210E3C73C21DEB0EA88")
    public boolean isAnimating() {
        boolean varB61DAF46DE370F07E3CE29F31A7A7035_518401220 = ((!mEdgeGlowTop.isFinished() || !mEdgeGlowBottom.isFinished() ||
                !mEdgeGlowLeft.isFinished() || !mEdgeGlowRight.isFinished()));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_623964343 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_623964343;
        // ---------- Original Method ----------
        //return (!mEdgeGlowTop.isFinished() || !mEdgeGlowBottom.isFinished() ||
                //!mEdgeGlowLeft.isFinished() || !mEdgeGlowRight.isFinished());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.315 -0400", hash_original_method = "F2C1801AA96B9D8F59B00F59054F0306", hash_generated_method = "0A16160F8629C218C4D8429A9B957BCF")
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

