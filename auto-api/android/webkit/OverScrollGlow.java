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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.326 -0400", hash_original_field = "B6E6A78A9ACB6C4FA6614BAFEDBC05E2", hash_generated_field = "1629930CD96E325649F3C70757D5A77E")

    private WebView mHostView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.326 -0400", hash_original_field = "89E135B7087DB76810F3F37EE0DAB560", hash_generated_field = "E572968A85247BF2ECB5635FFF539C2E")

    private EdgeEffect mEdgeGlowTop;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.326 -0400", hash_original_field = "289036755C83C8893D6004D3220BA45B", hash_generated_field = "D2A4A7BE91BF29EB90E114C9648825A6")

    private EdgeEffect mEdgeGlowBottom;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.326 -0400", hash_original_field = "ACEBD86C89C68033BA00F1E22D2FC23B", hash_generated_field = "CF32CFBB2A976E850EE8DDE803F384D7")

    private EdgeEffect mEdgeGlowLeft;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.326 -0400", hash_original_field = "876C7C33DE6802509886BB6ADFFE041C", hash_generated_field = "304A2CBEA7C331CEDE170973F40765C0")

    private EdgeEffect mEdgeGlowRight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.326 -0400", hash_original_field = "942A9DFE7D0618C3067B543B2C8329CE", hash_generated_field = "BEE327B00350EFBA85A5178322BF5A0D")

    private int mOverScrollDeltaX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.326 -0400", hash_original_field = "332F40191A3B7E3184426D99B2CEBEC3", hash_generated_field = "E1700EBF6A8242E4CC987AD366097B8C")

    private int mOverScrollDeltaY;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.326 -0400", hash_original_method = "C880ED290A9E3BE27C712EA7FDA57F5B", hash_generated_method = "35B02E8D7ADFDD13EA359CD99016AA70")
    public  OverScrollGlow(WebView host) {
        mHostView = host;
        Context context = host.getContext();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.327 -0400", hash_original_method = "951D1D5C70B11C07C923672F61940F77", hash_generated_method = "C016A6D1C157C3FB9DF778CD6737399B")
    public void pullGlow(int x, int y, int oldX, int oldY, int maxX, int maxY) {
        {
            boolean varF68DD10307297B92A02D609B34219301_229838271 = (oldX == mHostView.getScrollX() && oldY == mHostView.getScrollY());
            {
                {
                    final int pulledToX = oldX + mOverScrollDeltaX;
                    {
                        mEdgeGlowLeft.onPull((float) mOverScrollDeltaX / mHostView.getWidth());
                        {
                            boolean var3F17091DDB7792B5828D13564A2E2259_2118704287 = (!mEdgeGlowRight.isFinished());
                            {
                                mEdgeGlowRight.onRelease();
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                    {
                        mEdgeGlowRight.onPull((float) mOverScrollDeltaX / mHostView.getWidth());
                        {
                            boolean varF350524CC4E0B21CB0ADBA87431224A0_1906600965 = (!mEdgeGlowLeft.isFinished());
                            {
                                mEdgeGlowLeft.onRelease();
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                    mOverScrollDeltaX = 0;
                } //End block
                {
                    boolean varB5F7B4AEB9A84016B30E16CF2832D7F3_965922098 = (maxY > 0 || mHostView.getOverScrollMode() == View.OVER_SCROLL_ALWAYS);
                    {
                        final int pulledToY = oldY + mOverScrollDeltaY;
                        {
                            mEdgeGlowTop.onPull((float) mOverScrollDeltaY / mHostView.getHeight());
                            {
                                boolean var276ACB79DBE335E284B4ACF758CD152B_1787675418 = (!mEdgeGlowBottom.isFinished());
                                {
                                    mEdgeGlowBottom.onRelease();
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                        {
                            mEdgeGlowBottom.onPull((float) mOverScrollDeltaY / mHostView.getHeight());
                            {
                                boolean varE32E609A3E675042D0E7EBF450CA3CA9_171279406 = (!mEdgeGlowTop.isFinished());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.328 -0400", hash_original_method = "898E1992D368021CDA53745F0D37B2ED", hash_generated_method = "DB9138BBE530C1A27762C46B9EBC1FDA")
    public void setOverScrollDeltas(int deltaX, int deltaY) {
        mOverScrollDeltaX = deltaX;
        mOverScrollDeltaY = deltaY;
        // ---------- Original Method ----------
        //mOverScrollDeltaX = deltaX;
        //mOverScrollDeltaY = deltaY;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.328 -0400", hash_original_method = "559A3475151AFD9F125F7EFF6D7FC3A7", hash_generated_method = "500288C1AD9D5D0966B4AA445AADD370")
    public void absorbGlow(int x, int y, int oldX, int oldY, int rangeX, int rangeY) {
        {
            boolean varB2DFA8263EC57AB54C396B63C811BF20_1722718664 = (rangeY > 0 || mHostView.getOverScrollMode() == View.OVER_SCROLL_ALWAYS);
            {
                {
                    mEdgeGlowTop.onAbsorb((int) mHostView.mScroller.getCurrVelocity());
                    {
                        boolean varE6213428B20479BD32BF17B140F5ED52_573381 = (!mEdgeGlowBottom.isFinished());
                        {
                            mEdgeGlowBottom.onRelease();
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    mEdgeGlowBottom.onAbsorb((int) mHostView.mScroller.getCurrVelocity());
                    {
                        boolean var5D6A56784A8F83A042E55ED0998DBE18_916056981 = (!mEdgeGlowTop.isFinished());
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
                    boolean var4A8F0EC4B9753343944B27E4680F1D79_2073360501 = (!mEdgeGlowRight.isFinished());
                    {
                        mEdgeGlowRight.onRelease();
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                mEdgeGlowRight.onAbsorb((int) mHostView.mScroller.getCurrVelocity());
                {
                    boolean var039ECE236F2F8C15702C208D0DD4F509_961977049 = (!mEdgeGlowLeft.isFinished());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.330 -0400", hash_original_method = "3B1E2223EF9E382987FDA8605560E6C8", hash_generated_method = "F748AB1045CF6E7743E50EBBE3C7D675")
    public boolean drawEdgeGlows(Canvas canvas) {
        final int scrollX = mHostView.getScrollX();
        final int scrollY = mHostView.getScrollY();
        final int width = mHostView.getWidth();
        int height = mHostView.getHeight();
        boolean invalidateForGlow = false;
        {
            boolean var93A7452989D6AE338103A833EC394509_1562267334 = (!mEdgeGlowTop.isFinished());
            {
                final int restoreCount = canvas.save();
                canvas.translate(scrollX, mHostView.getVisibleTitleHeight() + Math.min(0, scrollY));
                mEdgeGlowTop.setSize(width, height);
                invalidateForGlow |= mEdgeGlowTop.draw(canvas);
                canvas.restoreToCount(restoreCount);
            } //End block
        } //End collapsed parenthetic
        {
            boolean var0DD641EA1E206ECE7798489D640F38E6_794526435 = (!mEdgeGlowBottom.isFinished());
            {
                final int restoreCount = canvas.save();
                canvas.translate(-width + scrollX, Math.max(mHostView.computeMaxScrollY(), scrollY)
                    + height);
                canvas.rotate(180, width, 0);
                mEdgeGlowBottom.setSize(width, height);
                invalidateForGlow |= mEdgeGlowBottom.draw(canvas);
                canvas.restoreToCount(restoreCount);
            } //End block
        } //End collapsed parenthetic
        {
            boolean varCD4447A22CEC6A447F77A0E97A2CAB04_990356187 = (!mEdgeGlowLeft.isFinished());
            {
                final int restoreCount = canvas.save();
                canvas.rotate(270);
                canvas.translate(-height - scrollY, Math.min(0, scrollX));
                mEdgeGlowLeft.setSize(height, width);
                invalidateForGlow |= mEdgeGlowLeft.draw(canvas);
                canvas.restoreToCount(restoreCount);
            } //End block
        } //End collapsed parenthetic
        {
            boolean var32F3613820E19780B8144F85DB57781E_1795623953 = (!mEdgeGlowRight.isFinished());
            {
                final int restoreCount = canvas.save();
                canvas.rotate(90);
                canvas.translate(scrollY,
                    -(Math.max(mHostView.computeMaxScrollX(), scrollX) + width));
                mEdgeGlowRight.setSize(height, width);
                invalidateForGlow |= mEdgeGlowRight.draw(canvas);
                canvas.restoreToCount(restoreCount);
            } //End block
        } //End collapsed parenthetic
        addTaint(canvas.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1412041268 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1412041268;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.330 -0400", hash_original_method = "991A6F9A141C4C9221BF71360DEAB6AF", hash_generated_method = "96BCB08E56D1825900096B9A99AF6278")
    public boolean isAnimating() {
        boolean varB61DAF46DE370F07E3CE29F31A7A7035_1212564153 = ((!mEdgeGlowTop.isFinished() || !mEdgeGlowBottom.isFinished() ||
                !mEdgeGlowLeft.isFinished() || !mEdgeGlowRight.isFinished()));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1342625839 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1342625839;
        // ---------- Original Method ----------
        //return (!mEdgeGlowTop.isFinished() || !mEdgeGlowBottom.isFinished() ||
                //!mEdgeGlowLeft.isFinished() || !mEdgeGlowRight.isFinished());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.330 -0400", hash_original_method = "F2C1801AA96B9D8F59B00F59054F0306", hash_generated_method = "0A16160F8629C218C4D8429A9B957BCF")
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

