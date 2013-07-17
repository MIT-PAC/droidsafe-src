package android.webkit;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import com.android.internal.R;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.EdgeEffect;

public class OverScrollGlow {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.702 -0400", hash_original_field = "B6E6A78A9ACB6C4FA6614BAFEDBC05E2", hash_generated_field = "1629930CD96E325649F3C70757D5A77E")

    private WebView mHostView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.702 -0400", hash_original_field = "89E135B7087DB76810F3F37EE0DAB560", hash_generated_field = "E572968A85247BF2ECB5635FFF539C2E")

    private EdgeEffect mEdgeGlowTop;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.703 -0400", hash_original_field = "289036755C83C8893D6004D3220BA45B", hash_generated_field = "D2A4A7BE91BF29EB90E114C9648825A6")

    private EdgeEffect mEdgeGlowBottom;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.703 -0400", hash_original_field = "ACEBD86C89C68033BA00F1E22D2FC23B", hash_generated_field = "CF32CFBB2A976E850EE8DDE803F384D7")

    private EdgeEffect mEdgeGlowLeft;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.703 -0400", hash_original_field = "876C7C33DE6802509886BB6ADFFE041C", hash_generated_field = "304A2CBEA7C331CEDE170973F40765C0")

    private EdgeEffect mEdgeGlowRight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.703 -0400", hash_original_field = "942A9DFE7D0618C3067B543B2C8329CE", hash_generated_field = "BEE327B00350EFBA85A5178322BF5A0D")

    private int mOverScrollDeltaX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.703 -0400", hash_original_field = "332F40191A3B7E3184426D99B2CEBEC3", hash_generated_field = "E1700EBF6A8242E4CC987AD366097B8C")

    private int mOverScrollDeltaY;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.704 -0400", hash_original_method = "C880ED290A9E3BE27C712EA7FDA57F5B", hash_generated_method = "35B02E8D7ADFDD13EA359CD99016AA70")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.705 -0400", hash_original_method = "951D1D5C70B11C07C923672F61940F77", hash_generated_method = "5A5812C4BA4F0DB1B7B214C7B391607E")
    public void pullGlow(int x, int y, int oldX, int oldY, int maxX, int maxY) {
        addTaint(maxY);
        addTaint(maxX);
        addTaint(oldY);
        addTaint(oldX);
        addTaint(y);
        addTaint(x);
        if(oldX == mHostView.getScrollX() && oldY == mHostView.getScrollY())        
        {
            if(maxX > 0)            
            {
                final int pulledToX = oldX + mOverScrollDeltaX;
                if(pulledToX < 0)                
                {
                    mEdgeGlowLeft.onPull((float) mOverScrollDeltaX / mHostView.getWidth());
                    if(!mEdgeGlowRight.isFinished())                    
                    {
                        mEdgeGlowRight.onRelease();
                    } //End block
                } //End block
                else
                if(pulledToX > maxX)                
                {
                    mEdgeGlowRight.onPull((float) mOverScrollDeltaX / mHostView.getWidth());
                    if(!mEdgeGlowLeft.isFinished())                    
                    {
                        mEdgeGlowLeft.onRelease();
                    } //End block
                } //End block
                mOverScrollDeltaX = 0;
            } //End block
            if(maxY > 0 || mHostView.getOverScrollMode() == View.OVER_SCROLL_ALWAYS)            
            {
                final int pulledToY = oldY + mOverScrollDeltaY;
                if(pulledToY < 0)                
                {
                    mEdgeGlowTop.onPull((float) mOverScrollDeltaY / mHostView.getHeight());
                    if(!mEdgeGlowBottom.isFinished())                    
                    {
                        mEdgeGlowBottom.onRelease();
                    } //End block
                } //End block
                else
                if(pulledToY > maxY)                
                {
                    mEdgeGlowBottom.onPull((float) mOverScrollDeltaY / mHostView.getHeight());
                    if(!mEdgeGlowTop.isFinished())                    
                    {
                        mEdgeGlowTop.onRelease();
                    } //End block
                } //End block
                mOverScrollDeltaY = 0;
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.706 -0400", hash_original_method = "898E1992D368021CDA53745F0D37B2ED", hash_generated_method = "DB9138BBE530C1A27762C46B9EBC1FDA")
    public void setOverScrollDeltas(int deltaX, int deltaY) {
        mOverScrollDeltaX = deltaX;
        mOverScrollDeltaY = deltaY;
        // ---------- Original Method ----------
        //mOverScrollDeltaX = deltaX;
        //mOverScrollDeltaY = deltaY;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.707 -0400", hash_original_method = "559A3475151AFD9F125F7EFF6D7FC3A7", hash_generated_method = "DAA874F0300B4D4471C75703418C8C83")
    public void absorbGlow(int x, int y, int oldX, int oldY, int rangeX, int rangeY) {
        addTaint(rangeY);
        addTaint(rangeX);
        addTaint(oldY);
        addTaint(oldX);
        addTaint(y);
        addTaint(x);
        if(rangeY > 0 || mHostView.getOverScrollMode() == View.OVER_SCROLL_ALWAYS)        
        {
            if(y < 0 && oldY >= 0)            
            {
                mEdgeGlowTop.onAbsorb((int) mHostView.mScroller.getCurrVelocity());
                if(!mEdgeGlowBottom.isFinished())                
                {
                    mEdgeGlowBottom.onRelease();
                } //End block
            } //End block
            else
            if(y > rangeY && oldY <= rangeY)            
            {
                mEdgeGlowBottom.onAbsorb((int) mHostView.mScroller.getCurrVelocity());
                if(!mEdgeGlowTop.isFinished())                
                {
                    mEdgeGlowTop.onRelease();
                } //End block
            } //End block
        } //End block
        if(rangeX > 0)        
        {
            if(x < 0 && oldX >= 0)            
            {
                mEdgeGlowLeft.onAbsorb((int) mHostView.mScroller.getCurrVelocity());
                if(!mEdgeGlowRight.isFinished())                
                {
                    mEdgeGlowRight.onRelease();
                } //End block
            } //End block
            else
            if(x > rangeX && oldX <= rangeX)            
            {
                mEdgeGlowRight.onAbsorb((int) mHostView.mScroller.getCurrVelocity());
                if(!mEdgeGlowLeft.isFinished())                
                {
                    mEdgeGlowLeft.onRelease();
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.721 -0400", hash_original_method = "3B1E2223EF9E382987FDA8605560E6C8", hash_generated_method = "D0B769BE9F83A86467B612F593AE4D30")
    public boolean drawEdgeGlows(Canvas canvas) {
        addTaint(canvas.getTaint());
        final int scrollX = mHostView.getScrollX();
        final int scrollY = mHostView.getScrollY();
        final int width = mHostView.getWidth();
        int height = mHostView.getHeight();
        boolean invalidateForGlow = false;
        if(!mEdgeGlowTop.isFinished())        
        {
            final int restoreCount = canvas.save();
            canvas.translate(scrollX, mHostView.getVisibleTitleHeight() + Math.min(0, scrollY));
            mEdgeGlowTop.setSize(width, height);
            invalidateForGlow |= mEdgeGlowTop.draw(canvas);
            canvas.restoreToCount(restoreCount);
        } //End block
        if(!mEdgeGlowBottom.isFinished())        
        {
            final int restoreCount = canvas.save();
            canvas.translate(-width + scrollX, Math.max(mHostView.computeMaxScrollY(), scrollY)
                    + height);
            canvas.rotate(180, width, 0);
            mEdgeGlowBottom.setSize(width, height);
            invalidateForGlow |= mEdgeGlowBottom.draw(canvas);
            canvas.restoreToCount(restoreCount);
        } //End block
        if(!mEdgeGlowLeft.isFinished())        
        {
            final int restoreCount = canvas.save();
            canvas.rotate(270);
            canvas.translate(-height - scrollY, Math.min(0, scrollX));
            mEdgeGlowLeft.setSize(height, width);
            invalidateForGlow |= mEdgeGlowLeft.draw(canvas);
            canvas.restoreToCount(restoreCount);
        } //End block
        if(!mEdgeGlowRight.isFinished())        
        {
            final int restoreCount = canvas.save();
            canvas.rotate(90);
            canvas.translate(scrollY,
                    -(Math.max(mHostView.computeMaxScrollX(), scrollX) + width));
            mEdgeGlowRight.setSize(height, width);
            invalidateForGlow |= mEdgeGlowRight.draw(canvas);
            canvas.restoreToCount(restoreCount);
        } //End block
        boolean varE554BD5478EF6DBBFE9C3BC23BF29BA7_1133700502 = (invalidateForGlow);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_421275959 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_421275959;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.721 -0400", hash_original_method = "991A6F9A141C4C9221BF71360DEAB6AF", hash_generated_method = "0A9D726395F20E6455961A23E8B0326E")
    public boolean isAnimating() {
        boolean var421F71E7C1C4D53313F50EFB45C4EEAF_282284492 = ((!mEdgeGlowTop.isFinished() || !mEdgeGlowBottom.isFinished() ||
                !mEdgeGlowLeft.isFinished() || !mEdgeGlowRight.isFinished()));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_940229054 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_940229054;
        // ---------- Original Method ----------
        //return (!mEdgeGlowTop.isFinished() || !mEdgeGlowBottom.isFinished() ||
                //!mEdgeGlowLeft.isFinished() || !mEdgeGlowRight.isFinished());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.721 -0400", hash_original_method = "F2C1801AA96B9D8F59B00F59054F0306", hash_generated_method = "0A16160F8629C218C4D8429A9B957BCF")
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

