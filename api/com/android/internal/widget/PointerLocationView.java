package com.android.internal.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.ArrayList;
import android.view.ViewConfiguration;
import android.graphics.Paint.FontMetricsInt;
import android.util.Log;
import android.view.VelocityTracker;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;
import android.view.InputDevice;
import android.graphics.RectF;
import android.content.Context;
import android.graphics.Canvas;
import android.view.KeyEvent;
import android.view.MotionEvent.PointerCoords;
public class PointerLocationView extends View {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.230 -0400", hash_original_field = "92DBB775A7AD18CE5A3A0433DE0CA2C5", hash_generated_field = "7DB3C020B09363CCB46648C5C5BD8C79")

    private final int ESTIMATE_PAST_POINTS = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.230 -0400", hash_original_field = "50CC8B5ADEEF7CFA5DA5F065DF6ABE6E", hash_generated_field = "8694CC9059FA850479201B76EFD33E79")

    private final int ESTIMATE_FUTURE_POINTS = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.230 -0400", hash_original_field = "0495A9F8E207035CBA01581C5638BADA", hash_generated_field = "C4CA7F5F590D515ED9B6097163D9A605")

    private final float ESTIMATE_INTERVAL = 0.02f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.231 -0400", hash_original_field = "4F38E6C896AC00BD380A0B83B9FBF7C9", hash_generated_field = "7313E760CAF5E2E386C0F3C107D4A487")

    private ViewConfiguration mVC;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.231 -0400", hash_original_field = "A623C6B7D6CD75F8A26EF2CAD7479AA5", hash_generated_field = "0B099F4228A7203177F5497AB3FA3905")

    private Paint mTextPaint;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.231 -0400", hash_original_field = "A5C8AA7CE8E5BFAB6042DD5576340056", hash_generated_field = "CAA7AA025564BF575564677A5AF532F9")

    private Paint mTextBackgroundPaint;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.231 -0400", hash_original_field = "5A22A6DFBC182220A2D7C70C247FB1AC", hash_generated_field = "3DDF00CC5550E046DF1287D6A78547CF")

    private Paint mTextLevelPaint;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.231 -0400", hash_original_field = "78E27F80AC0100441F897783EFA42851", hash_generated_field = "75BCEEBE83B26919B33E8EA8B289919E")

    private Paint mPaint;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.231 -0400", hash_original_field = "96E9C1443F13A09F2840040669B196F3", hash_generated_field = "BC28BD21946E415A3ACB8CC5D5306AB1")

    private Paint mTargetPaint;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.231 -0400", hash_original_field = "8999150E76BDE93C537D071AA59B6072", hash_generated_field = "F2C72A5F755BC2054BD1A2D476CE3D61")

    private Paint mPathPaint;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.231 -0400", hash_original_field = "1525DD99B4C946E96DD281020858A8C5", hash_generated_field = "969AC2C6458095B67ADA61D068B16306")

    private final FontMetricsInt mTextMetrics = new FontMetricsInt();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.231 -0400", hash_original_field = "554DB261AACC867FD782AFDA0A261188", hash_generated_field = "EF502F21AF7CA10937D7979AB7A51B4C")

    private int mHeaderBottom;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.232 -0400", hash_original_field = "6FE4BD89CDB81F20D9023CB5D2215781", hash_generated_field = "111E7C7D3584A02FCC9BE75DA2E64E23")

    private boolean mCurDown;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.232 -0400", hash_original_field = "19F5E9CEA39909682554C18ED4554CFE", hash_generated_field = "43F5651578F83810F60D0383B80BF7F2")

    private int mCurNumPointers;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.232 -0400", hash_original_field = "A4DB1EE3F77098B39953F635F7E246AB", hash_generated_field = "4556BBA0EF5AC396F92E02E72B9C562D")

    private int mMaxNumPointers;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.232 -0400", hash_original_field = "1EDD19CBB3CDA8D0823EA859BEC0E87C", hash_generated_field = "689CCB8D246B97A97A5E38D7B2EFC497")

    private int mActivePointerId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.232 -0400", hash_original_field = "B65BD8292C395FEFD4F79F3A6F0F06ED", hash_generated_field = "3AF19DF5D70C002E17B9F7E6B7A43389")

    private final ArrayList<PointerState> mPointers = new ArrayList<PointerState>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.232 -0400", hash_original_field = "A25EB115C09AC308166DF4E1EFA44D02", hash_generated_field = "BF3B70D0D189E641A7D38E7003D11A8D")

    private final PointerCoords mTempCoords = new PointerCoords();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.232 -0400", hash_original_field = "437EB8FD5FAD507D203D1F22AFAD95FB", hash_generated_field = "39B9AFDE4BE0E853D66195C4E22388F0")

    private VelocityTracker mVelocity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.232 -0400", hash_original_field = "E8E419A19AC3296BDCBE617DB49D79CF", hash_generated_field = "CA871FB05654F07E14649B286E95B807")

    private final FasterStringBuilder mText = new FasterStringBuilder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.232 -0400", hash_original_field = "2873DDEB37FF544358675E6196C052B8", hash_generated_field = "CDD5A489D9D431C86BD1BB02E74E9FAC")

    private boolean mPrintCoords = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.232 -0400", hash_original_field = "17987F28108835B92F58997B0A528BC5", hash_generated_field = "0828713117433A9BFBADACCDAC7248D1")

    private RectF mReusableOvalRect = new RectF();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.233 -0400", hash_original_method = "18E412ADFAB0A6936A0E405915666083", hash_generated_method = "391F7C18B3E34F5BB9B1C063FBF17876")
    public  PointerLocationView(Context c) {
        super(c);
        addTaint(c.getTaint());
setFocusableInTouchMode(true)mVC=ViewConfiguration.get(c)mTextPaint=new Paint()mTextPaint.setAntiAlias(true)mTextPaint.setTextSize(10*getResources().getDisplayMetrics().density)mTextPaint.setARGB(255, 0, 0, 0)mTextBackgroundPaint=new Paint()mTextBackgroundPaint.setAntiAlias(false)mTextBackgroundPaint.setARGB(128, 255, 255, 255)mTextLevelPaint=new Paint()mTextLevelPaint.setAntiAlias(false)mTextLevelPaint.setARGB(192, 255, 0, 0)mPaint=new Paint()mPaint.setAntiAlias(true)mPaint.setARGB(255, 255, 255, 255)mPaint.setStyle(Paint.Style.STROKE)mPaint.setStrokeWidth(2)mTargetPaint=new Paint()mTargetPaint.setAntiAlias(false)mTargetPaint.setARGB(255, 0, 0, 192)mPathPaint=new Paint()mPathPaint.setAntiAlias(false)mPathPaint.setARGB(255, 0, 96, 255)mPaint.setStyle(Paint.Style.STROKE)mPaint.setStrokeWidth(1)        PointerState ps = new PointerState();
mPointers.add(ps)mActivePointerId=0mVelocity=VelocityTracker.obtain()logInputDeviceCapabilities()
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.234 -0400", hash_original_method = "0CB41446992415EBCB1DF151986C5F8D", hash_generated_method = "C2F5DD8C07BDFEE9CF4C60D595AECF32")
    private void logInputDeviceCapabilities() {
        int[] deviceIds = InputDevice.getDeviceIds();
for(int i = 0;i<deviceIds.length;i)
        {
            InputDevice device = InputDevice.getDevice(deviceIds[i]);
            if(device!=null)            
            {
            } //End block
        } //End block
        // ---------- Original Method ----------
        //int[] deviceIds = InputDevice.getDeviceIds();
        //for (int i = 0; i < deviceIds.length; i++) {
            //InputDevice device = InputDevice.getDevice(deviceIds[i]);
            //if (device != null) {
                //Log.i(TAG, device.toString());
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.234 -0400", hash_original_method = "F3B14E3A644464D777D28B2A50493BE4", hash_generated_method = "DBFCE69DD7D003EA13ADDF4CD10D621C")
    public void setPrintCoords(boolean state) {
        addTaint(state);
mPrintCoords=state
        // ---------- Original Method ----------
        //mPrintCoords = state;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.235 -0400", hash_original_method = "BDC4A8D96924B5BC12C9C66D5AFBF697", hash_generated_method = "7A47A4DC01A14C6B802D6A7B5356E46F")
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(heightMeasureSpec);
        addTaint(widthMeasureSpec);
super.onMeasure(widthMeasureSpec, heightMeasureSpec)mTextPaint.getFontMetricsInt(mTextMetrics)mHeaderBottom=-mTextMetrics.ascent+mTextMetrics.descent+2        if(false)        
        {
        } //End block
        // ---------- Original Method ----------
        //super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //mTextPaint.getFontMetricsInt(mTextMetrics);
        //mHeaderBottom = -mTextMetrics.ascent+mTextMetrics.descent+2;
        //if (false) {
            //Log.i("foo", "Metrics: ascent=" + mTextMetrics.ascent
                    //+ " descent=" + mTextMetrics.descent
                    //+ " leading=" + mTextMetrics.leading
                    //+ " top=" + mTextMetrics.top
                    //+ " bottom=" + mTextMetrics.bottom);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.236 -0400", hash_original_method = "745A408AC909965E2B5F0DB1B02810AE", hash_generated_method = "08F35922317E9627CC5DFDF6D7A74D49")
    private void drawOval(Canvas canvas, float x, float y, float major, float minor,
            float angle, Paint paint) {
        addTaint(paint.getTaint());
        addTaint(angle);
        addTaint(minor);
        addTaint(major);
        addTaint(y);
        addTaint(x);
        addTaint(canvas.getTaint());
canvas.save(Canvas.MATRIX_SAVE_FLAG)canvas.rotate((float) (angle*180/Math.PI), x, y)mReusableOvalRect.left=x-minor/2mReusableOvalRect.right=x+minor/2mReusableOvalRect.top=y-major/2mReusableOvalRect.bottom=y+major/2canvas.drawOval(mReusableOvalRect, paint)canvas.restore()
        // ---------- Original Method ----------
        //canvas.save(Canvas.MATRIX_SAVE_FLAG);
        //canvas.rotate((float) (angle * 180 / Math.PI), x, y);
        //mReusableOvalRect.left = x - minor / 2;
        //mReusableOvalRect.right = x + minor / 2;
        //mReusableOvalRect.top = y - major / 2;
        //mReusableOvalRect.bottom = y + major / 2;
        //canvas.drawOval(mReusableOvalRect, paint);
        //canvas.restore();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.239 -0400", hash_original_method = "CE1A91ACFFC5EB0AA670EBC251A61193", hash_generated_method = "61BAD9339AE8D2F0A9240B446BA16A74")
    @Override
    protected void onDraw(Canvas canvas) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(canvas.getTaint());
        synchronized
(mPointers)        {
            final int w = getWidth();
            final int itemW = w/7;
            final int base = -mTextMetrics.ascent+1;
            final int bottom = mHeaderBottom;
            final int NP = mPointers.size();
            if(mActivePointerId>=0)            
            {
                final PointerState ps = mPointers.get(mActivePointerId);
canvas.drawRect(0, 0, itemW-1, bottom, mTextBackgroundPaint)canvas.drawText(mText.clear().append("P: ").append(mCurNumPointers).append(" / ").append(mMaxNumPointers).toString(), 1, base, mTextPaint)                final int N = ps.mTraceCount;
                if((mCurDown&&ps.mCurDown)||N==0)                
                {
canvas.drawRect(itemW, 0, (itemW*2)-1, bottom, mTextBackgroundPaint)canvas.drawText(mText.clear().append("X: ").append(ps.mCoords.x, 1).toString(), 1+itemW, base, mTextPaint)canvas.drawRect(itemW*2, 0, (itemW*3)-1, bottom, mTextBackgroundPaint)canvas.drawText(mText.clear().append("Y: ").append(ps.mCoords.y, 1).toString(), 1+itemW*2, base, mTextPaint)
                } //End block
                else
                {
                    float dx = ps.mTraceX[N - 1] - ps.mTraceX[0];
                    float dy = ps.mTraceY[N - 1] - ps.mTraceY[0];
canvas.drawRect(itemW, 0, (itemW*2)-1, bottom, Math.abs(dx)<mVC.getScaledTouchSlop()?mTextBackgroundPaint:mTextBackgroundPaint)canvas.drawText(mText.clear().append("dX: ").append(dx, 1).toString(), 1+itemW, base, mTextPaint)canvas.drawRect(itemW*2, 0, (itemW*3)-1, bottom, Math.abs(dy)<mVC.getScaledTouchSlop()?mTextBackgroundPaint:mTextBackgroundPaint)canvas.drawText(mText.clear().append("dY: ").append(dy, 1).toString(), 1+itemW*2, base, mTextPaint)
                } //End block
canvas.drawRect(itemW*3, 0, (itemW*4)-1, bottom, mTextBackgroundPaint)canvas.drawText(mText.clear().append("Xv: ").append(ps.mXVelocity, 3).toString(), 1+itemW*3, base, mTextPaint)canvas.drawRect(itemW*4, 0, (itemW*5)-1, bottom, mTextBackgroundPaint)canvas.drawText(mText.clear().append("Yv: ").append(ps.mYVelocity, 3).toString(), 1+itemW*4, base, mTextPaint)canvas.drawRect(itemW*5, 0, (itemW*6)-1, bottom, mTextBackgroundPaint)canvas.drawRect(itemW*5, 0, (itemW*5)+(ps.mCoords.pressure*itemW)-1, bottom, mTextLevelPaint)canvas.drawText(mText.clear().append("Prs: ").append(ps.mCoords.pressure, 2).toString(), 1+itemW*5, base, mTextPaint)canvas.drawRect(itemW*6, 0, w, bottom, mTextBackgroundPaint)canvas.drawRect(itemW*6, 0, (itemW*6)+(ps.mCoords.size*itemW)-1, bottom, mTextLevelPaint)canvas.drawText(mText.clear().append("Size: ").append(ps.mCoords.size, 2).toString(), 1+itemW*6, base, mTextPaint)
            } //End block
for(int p = 0;p<NP;p)
            {
                final PointerState ps = mPointers.get(p);
                final int N = ps.mTraceCount;
                float lastX = 0;
                float lastY = 0;
                boolean haveLast = false;
                boolean drawn = false;
mPaint.setARGB(255, 128, 255, 255)for(int i=0;i<N;i)
                {
                    float x = ps.mTraceX[i];
                    float y = ps.mTraceY[i];
                    if(Float.isNaN(x))                    
                    {
haveLast=false                        continue;
                    } //End block
                    if(haveLast)                    
                    {
canvas.drawLine(lastX, lastY, x, y, mPathPaint)canvas.drawPoint(lastX, lastY, mPaint)drawn=true
                    } //End block
lastX=xlastY=yhaveLast=true
                } //End block
                if(drawn)                
                {
mPaint.setARGB(128, 128, 0, 128)                    float lx = ps.mEstimator.estimateX(-ESTIMATE_PAST_POINTS * ESTIMATE_INTERVAL);
                    float ly = ps.mEstimator.estimateY(-ESTIMATE_PAST_POINTS * ESTIMATE_INTERVAL);
for(int i = -ESTIMATE_PAST_POINTS + 1;i<=ESTIMATE_FUTURE_POINTS;i)
                    {
                        float x = ps.mEstimator.estimateX(i * ESTIMATE_INTERVAL);
                        float y = ps.mEstimator.estimateY(i * ESTIMATE_INTERVAL);
canvas.drawLine(lx, ly, x, y, mPaint)lx=xly=y
                    } //End block
mPaint.setARGB(255, 255, 64, 128)                    float xVel = ps.mXVelocity * (1000 / 60);
                    float yVel = ps.mYVelocity * (1000 / 60);
canvas.drawLine(lastX, lastY, lastX+xVel, lastY+yVel, mPaint)
                } //End block
                if(mCurDown&&ps.mCurDown)                
                {
canvas.drawLine(0, ps.mCoords.y, getWidth(), ps.mCoords.y, mTargetPaint)canvas.drawLine(ps.mCoords.x, 0, ps.mCoords.x, getHeight(), mTargetPaint)                    int pressureLevel = (int)(ps.mCoords.pressure * 255);
mPaint.setARGB(255, pressureLevel, 255, 255-pressureLevel)canvas.drawPoint(ps.mCoords.x, ps.mCoords.y, mPaint)mPaint.setARGB(255, pressureLevel, 255-pressureLevel, 128)drawOval(canvas, ps.mCoords.x, ps.mCoords.y, ps.mCoords.touchMajor, ps.mCoords.touchMinor, ps.mCoords.orientation, mPaint)mPaint.setARGB(255, pressureLevel, 128, 255-pressureLevel)drawOval(canvas, ps.mCoords.x, ps.mCoords.y, ps.mCoords.toolMajor, ps.mCoords.toolMinor, ps.mCoords.orientation, mPaint)                    float arrowSize = ps.mCoords.toolMajor * 0.7f;
                    if(arrowSize<20)                    
                    {
arrowSize=20
                    } //End block
mPaint.setARGB(255, pressureLevel, 255, 0)                    float orientationVectorX = (float) (Math.sin(ps.mCoords.orientation)
                            * arrowSize);
                    float orientationVectorY = (float) (-Math.cos(ps.mCoords.orientation)
                            * arrowSize);
                    if(ps.mToolType==MotionEvent.TOOL_TYPE_STYLUS||ps.mToolType==MotionEvent.TOOL_TYPE_ERASER)                    
                    {
canvas.drawLine(ps.mCoords.x, ps.mCoords.y, ps.mCoords.x+orientationVectorX, ps.mCoords.y+orientationVectorY, mPaint)
                    } //End block
                    else
                    {
canvas.drawLine(ps.mCoords.x-orientationVectorX, ps.mCoords.y-orientationVectorY, ps.mCoords.x+orientationVectorX, ps.mCoords.y+orientationVectorY, mPaint)
                    } //End block
                    float tiltScale = (float) Math.sin(
                            ps.mCoords.getAxisValue(MotionEvent.AXIS_TILT));
canvas.drawCircle(ps.mCoords.x+orientationVectorX*tiltScale, ps.mCoords.y+orientationVectorY*tiltScale, 3.0f, mPaint)
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.240 -0400", hash_original_method = "4C17DA94B899351F4B719953A6DF2292", hash_generated_method = "559928506D48A580C5DBFDC2F00A65D4")
    private void logMotionEvent(String type, MotionEvent event) {
        addTaint(event.getTaint());
        addTaint(type.getTaint());
        final int action = event.getAction();
        final int N = event.getHistorySize();
        final int NI = event.getPointerCount();
for(int historyPos = 0;historyPos<N;historyPos)
        {
for(int i = 0;i<NI;i)
            {
                final int id = event.getPointerId(i);
event.getHistoricalPointerCoords(i, historyPos, mTempCoords)logCoords(type, action, i, mTempCoords, id, event.getToolType(i), event.getButtonState())
            } //End block
        } //End block
for(int i = 0;i<NI;i)
        {
            final int id = event.getPointerId(i);
event.getPointerCoords(i, mTempCoords)logCoords(type, action, i, mTempCoords, id, event.getToolType(i), event.getButtonState())
        } //End block
        // ---------- Original Method ----------
        //final int action = event.getAction();
        //final int N = event.getHistorySize();
        //final int NI = event.getPointerCount();
        //for (int historyPos = 0; historyPos < N; historyPos++) {
            //for (int i = 0; i < NI; i++) {
                //final int id = event.getPointerId(i);
                //event.getHistoricalPointerCoords(i, historyPos, mTempCoords);
                //logCoords(type, action, i, mTempCoords, id,
                        //event.getToolType(i), event.getButtonState());
            //}
        //}
        //for (int i = 0; i < NI; i++) {
            //final int id = event.getPointerId(i);
            //event.getPointerCoords(i, mTempCoords);
            //logCoords(type, action, i, mTempCoords, id,
                    //event.getToolType(i), event.getButtonState());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.241 -0400", hash_original_method = "23EA44737B98189B40E58E092846EB16", hash_generated_method = "B803669F05FE4B43F07C587C39B554A7")
    private void logCoords(String type, int action, int index,
            MotionEvent.PointerCoords coords, int id, int toolType, int buttonState) {
        addTaint(buttonState);
        addTaint(toolType);
        addTaint(id);
        addTaint(coords.getTaint());
        addTaint(index);
        addTaint(action);
        addTaint(type.getTaint());
        String prefix;
        switch(action&MotionEvent.ACTION_MASK){
        case MotionEvent.ACTION_DOWN:
prefix="DOWN"        break;
        case MotionEvent.ACTION_UP:
prefix="UP"        break;
        case MotionEvent.ACTION_MOVE:
prefix="MOVE"        break;
        case MotionEvent.ACTION_CANCEL:
prefix="CANCEL"        break;
        case MotionEvent.ACTION_OUTSIDE:
prefix="OUTSIDE"        break;
        case MotionEvent.ACTION_POINTER_DOWN:
        if(index==((action&MotionEvent.ACTION_POINTER_INDEX_MASK)>>MotionEvent.ACTION_POINTER_INDEX_SHIFT))        
        {
prefix="DOWN"
        } //End block
        else
        {
prefix="MOVE"
        } //End block
        break;
        case MotionEvent.ACTION_POINTER_UP:
        if(index==((action&MotionEvent.ACTION_POINTER_INDEX_MASK)>>MotionEvent.ACTION_POINTER_INDEX_SHIFT))        
        {
prefix="UP"
        } //End block
        else
        {
prefix="MOVE"
        } //End block
        break;
        case MotionEvent.ACTION_HOVER_MOVE:
prefix="HOVER MOVE"        break;
        case MotionEvent.ACTION_HOVER_ENTER:
prefix="HOVER ENTER"        break;
        case MotionEvent.ACTION_HOVER_EXIT:
prefix="HOVER EXIT"        break;
        case MotionEvent.ACTION_SCROLL:
prefix="SCROLL"        break;
        default:
prefix=Integer.toString(action)        break;
}
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.243 -0400", hash_original_method = "6AB2F722F5D557571F02D9D257A0859E", hash_generated_method = "B872CE60A6E93BF5545EB29DC725CD7B")
    public void addPointerEvent(MotionEvent event) {
        addTaint(event.getTaint());
        synchronized
(mPointers)        {
            final int action = event.getAction();
            int NP = mPointers.size();
            if(action==MotionEvent.ACTION_DOWN||(action&MotionEvent.ACTION_MASK)==MotionEvent.ACTION_POINTER_DOWN)            
            {
                final int index = (action & MotionEvent.ACTION_POINTER_INDEX_MASK)
                        >> MotionEvent.ACTION_POINTER_INDEX_SHIFT;
                if(action==MotionEvent.ACTION_DOWN)                
                {
for(int p=0;p<NP;p)
                    {
                        final PointerState ps = mPointers.get(p);
ps.clearTrace()ps.mCurDown=false
                    } //End block
mCurDown=truemCurNumPointers=0mMaxNumPointers=0mVelocity.clear()
                } //End block
mCurNumPointers+=1                if(mMaxNumPointers<mCurNumPointers)                
                {
mMaxNumPointers=mCurNumPointers
                } //End block
                final int id = event.getPointerId(index);
                while
(NP<=id)                
                {
                    PointerState ps = new PointerState();
mPointers.add(ps)NP
                } //End block
                if(mActivePointerId<0||!mPointers.get(mActivePointerId).mCurDown)                
                {
mActivePointerId=id
                } //End block
                final PointerState ps = mPointers.get(id);
ps.mCurDown=true
            } //End block
            final int NI = event.getPointerCount();
mVelocity.addMovement(event)mVelocity.computeCurrentVelocity(1)            final int N = event.getHistorySize();
for(int historyPos = 0;historyPos<N;historyPos)
            {
for(int i = 0;i<NI;i)
                {
                    final int id = event.getPointerId(i);
                    final PointerState ps = mCurDown ? mPointers.get(id) : null;
                    final PointerCoords coords = ps != null ? ps.mCoords : mTempCoords;
event.getHistoricalPointerCoords(i, historyPos, coords)                    if(mPrintCoords)                    
                    {
logCoords("Pointer", action, i, coords, id, event.getToolType(i), event.getButtonState())
                    } //End block
                    if(ps!=null)                    
                    {
ps.addTrace(coords.x, coords.y)
                    } //End block
                } //End block
            } //End block
for(int i = 0;i<NI;i)
            {
                final int id = event.getPointerId(i);
                final PointerState ps = mCurDown ? mPointers.get(id) : null;
                final PointerCoords coords = ps != null ? ps.mCoords : mTempCoords;
event.getPointerCoords(i, coords)                if(mPrintCoords)                
                {
logCoords("Pointer", action, i, coords, id, event.getToolType(i), event.getButtonState())
                } //End block
                if(ps!=null)                
                {
ps.addTrace(coords.x, coords.y)ps.mXVelocity=mVelocity.getXVelocity(id)ps.mYVelocity=mVelocity.getYVelocity(id)mVelocity.getEstimator(id, -1, -1, ps.mEstimator)ps.mToolType=event.getToolType(i)
                } //End block
            } //End block
            if(action==MotionEvent.ACTION_UP||action==MotionEvent.ACTION_CANCEL||(action&MotionEvent.ACTION_MASK)==MotionEvent.ACTION_POINTER_UP)            
            {
                final int index = (action & MotionEvent.ACTION_POINTER_INDEX_MASK)
                        >> MotionEvent.ACTION_POINTER_INDEX_SHIFT;
                final int id = event.getPointerId(index);
                final PointerState ps = mPointers.get(id);
ps.mCurDown=false                if(action==MotionEvent.ACTION_UP||action==MotionEvent.ACTION_CANCEL)                
                {
mCurDown=falsemCurNumPointers=0
                } //End block
                else
                {
mCurNumPointers-=1                    if(mActivePointerId==id)                    
                    {
mActivePointerId=event.getPointerId(index==0?1:1)
                    } //End block
ps.addTrace(Float.NaN, Float.NaN)
                } //End block
            } //End block
postInvalidate()
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.245 -0400", hash_original_method = "763CA40452D6FB42E7B53375EEE238D6", hash_generated_method = "1808F76F384D1E44D1AAFA5E9D15B4EF")
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
addPointerEvent(event)        if(event.getAction()==MotionEvent.ACTION_DOWN&&!isFocused())        
        {
requestFocus()
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_586786589 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1711171070 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1711171070;
        // ---------- Original Method ----------
        //addPointerEvent(event);
        //if (event.getAction() == MotionEvent.ACTION_DOWN && !isFocused()) {
            //requestFocus();
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.246 -0400", hash_original_method = "9CC522A8F02B64FB67782CF03954C479", hash_generated_method = "4398DBC43734A04C9DBABDB4D04A5ECF")
    @Override
    public boolean onGenericMotionEvent(MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        final int source = event.getSource();
        if((source&InputDevice.SOURCE_CLASS_POINTER)!=0)        
        {
addPointerEvent(event)
        } //End block
        else
        if((source&InputDevice.SOURCE_CLASS_JOYSTICK)!=0)        
        {
logMotionEvent("Joystick", event)
        } //End block
        else
        if((source&InputDevice.SOURCE_CLASS_POSITION)!=0)        
        {
logMotionEvent("Position", event)
        } //End block
        else
        {
logMotionEvent("Generic", event)
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_2060058888 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1194188041 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1194188041;
        // ---------- Original Method ----------
        //final int source = event.getSource();
        //if ((source & InputDevice.SOURCE_CLASS_POINTER) != 0) {
            //addPointerEvent(event);
        //} else if ((source & InputDevice.SOURCE_CLASS_JOYSTICK) != 0) {
            //logMotionEvent("Joystick", event);
        //} else if ((source & InputDevice.SOURCE_CLASS_POSITION) != 0) {
            //logMotionEvent("Position", event);
        //} else {
            //logMotionEvent("Generic", event);
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.246 -0400", hash_original_method = "0AFC222DD571320DA93740AD5518E1FD", hash_generated_method = "C2F60CEC94B8D596C8E711BF67B53CA8")
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        addTaint(keyCode);
        if(shouldLogKey(keyCode))        
        {
            final int repeatCount = event.getRepeatCount();
            if(repeatCount==0)            
            {
            } //End block
            else
            {
            } //End block
            boolean varB326B5062B2F0E69046810717534CB09_642993759 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_614426206 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_614426206;
        } //End block
        boolean var947F0C250323B9F4475E02588E9A9740_701424067 = (super.onKeyDown(keyCode, event));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_302215932 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_302215932;
        // ---------- Original Method ----------
        //if (shouldLogKey(keyCode)) {
            //final int repeatCount = event.getRepeatCount();
            //if (repeatCount == 0) {
                //Log.i(TAG, "Key Down: " + event);
            //} else {
                //Log.i(TAG, "Key Repeat #" + repeatCount + ": " + event);
            //}
            //return true;
        //}
        //return super.onKeyDown(keyCode, event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.247 -0400", hash_original_method = "1E72AC0CA9E3F90865D2936357CC9258", hash_generated_method = "72A6F3038EE1255665DB79446AF0AF73")
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        addTaint(keyCode);
        if(shouldLogKey(keyCode))        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1672750345 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1734381671 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1734381671;
        } //End block
        boolean varAD33E8F21A74B923C1A24761EAF2F4A9_758600566 = (super.onKeyUp(keyCode, event));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1794812083 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1794812083;
        // ---------- Original Method ----------
        //if (shouldLogKey(keyCode)) {
            //Log.i(TAG, "Key Up: " + event);
            //return true;
        //}
        //return super.onKeyUp(keyCode, event);
    }

    
        private static boolean shouldLogKey(int keyCode) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_DPAD_UP:
            case KeyEvent.KEYCODE_DPAD_DOWN:
            case KeyEvent.KEYCODE_DPAD_LEFT:
            case KeyEvent.KEYCODE_DPAD_RIGHT:
            case KeyEvent.KEYCODE_DPAD_CENTER:
                return true;
            default:
                return KeyEvent.isGamepadButton(keyCode)
                    || KeyEvent.isModifierKey(keyCode);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.247 -0400", hash_original_method = "FB98FD289F7EA6687D61452936DA6C9A", hash_generated_method = "A5B466B12A64E3184B5303CDB75A36A3")
    @Override
    public boolean onTrackballEvent(MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
logMotionEvent("Trackball", event)        boolean varB326B5062B2F0E69046810717534CB09_1093637318 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1825275736 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1825275736;
        // ---------- Original Method ----------
        //logMotionEvent("Trackball", event);
        //return true;
    }

    
    public static class PointerState {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.248 -0400", hash_original_field = "FAA6844C1058FFC9B4777BE3B7D4923E", hash_generated_field = "DA221C8B6E533DC1E9A132B99E77B7FB")

        private float[] mTraceX = new float;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.248 -0400", hash_original_field = "192ABDB2D3692CEEC2FB1253B69D81F7", hash_generated_field = "A7B10CD2D01BB00E64B207CD7EE01586")

        private float[] mTraceY = new float;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.248 -0400", hash_original_field = "DFECB91857D64CD768035AD5EEEFA729", hash_generated_field = "0AC2A3D89CE9F7B8688F53FEF1D92540")

        private int mTraceCount;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.248 -0400", hash_original_field = "6FE4BD89CDB81F20D9023CB5D2215781", hash_generated_field = "111E7C7D3584A02FCC9BE75DA2E64E23")

        private boolean mCurDown;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.248 -0400", hash_original_field = "92752FEC918AF56A3185DB70E1A74C71", hash_generated_field = "AB9EE833E77411A8A7970387DB77E838")

        private PointerCoords mCoords = new PointerCoords();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.248 -0400", hash_original_field = "DB22BA0763029D34F60D82A333B1116C", hash_generated_field = "7A546CE58016A8DFE26108A7395C1577")

        private int mToolType;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.248 -0400", hash_original_field = "57D4948CA406D75DAFBA90C0882083E1", hash_generated_field = "F1EACC10BC7D00298CA3DFFAA06F5FEC")

        private float mXVelocity;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.248 -0400", hash_original_field = "BC25413923BE9DD3356C08F88CF628DC", hash_generated_field = "A0E599EB32A0227F8F81005CE1AE9A01")

        private float mYVelocity;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.249 -0400", hash_original_field = "98006E4AEAE3CFBC149E77B60ADDA7B0", hash_generated_field = "11BCB13A2C311644CA67548EE7DC7B97")

        private VelocityTracker.Estimator mEstimator = new VelocityTracker.Estimator();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.249 -0400", hash_original_method = "7FBB430F825BB90C32F94A75272902AC", hash_generated_method = "7FBB430F825BB90C32F94A75272902AC")
        public PointerState ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.249 -0400", hash_original_method = "27F3D985C355A2937383B3B07B56D8B3", hash_generated_method = "C80EA9E797604CF2C22FE9AE5607D3B8")
        public void clearTrace() {
mTraceCount=0
            // ---------- Original Method ----------
            //mTraceCount = 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.250 -0400", hash_original_method = "9E90D83CA3751D867B358BA82431E263", hash_generated_method = "98BB1F509FD2CFB517BF19C3784443D6")
        public void addTrace(float x, float y) {
            addTaint(y);
            addTaint(x);
            int traceCapacity = mTraceX.length;
            if(mTraceCount==traceCapacity)            
            {
traceCapacity*=2                float[] newTraceX = new float[traceCapacity];
System.arraycopy(mTraceX, 0, newTraceX, 0, mTraceCount)mTraceX=newTraceX                float[] newTraceY = new float[traceCapacity];
System.arraycopy(mTraceY, 0, newTraceY, 0, mTraceCount)mTraceY=newTraceY
            } //End block
mTraceX[mTraceCount]=xmTraceY[mTraceCount]=ymTraceCount+=1
            // ---------- Original Method ----------
            //int traceCapacity = mTraceX.length;
            //if (mTraceCount == traceCapacity) {
                //traceCapacity *= 2;
                //float[] newTraceX = new float[traceCapacity];
                //System.arraycopy(mTraceX, 0, newTraceX, 0, mTraceCount);
                //mTraceX = newTraceX;
                //float[] newTraceY = new float[traceCapacity];
                //System.arraycopy(mTraceY, 0, newTraceY, 0, mTraceCount);
                //mTraceY = newTraceY;
            //}
            //mTraceX[mTraceCount] = x;
            //mTraceY[mTraceCount] = y;
            //mTraceCount += 1;
        }

        
    }


    
    private static final class FasterStringBuilder {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.250 -0400", hash_original_field = "7C3722E3CD3CCC07C587A93513F1BB79", hash_generated_field = "20B8558AB5FD0F0B5A30B95221D68246")

        private char[] mChars;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.250 -0400", hash_original_field = "429F431E8CD8AC287AA27460675EAEFE", hash_generated_field = "E9E17726F18BEC3E5C2C142D209555FD")

        private int mLength;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.250 -0400", hash_original_method = "C6A463A71F56F02032F2D43BFA6758A7", hash_generated_method = "49B3A91D3F725ED7E8D3EC84D423F5D4")
        public  FasterStringBuilder() {
mChars=new char
            // ---------- Original Method ----------
            //mChars = new char[64];
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.251 -0400", hash_original_method = "5163F1078FF1F5F5199A8218055D0688", hash_generated_method = "DB9DF3D1AACFB02EE0E7291EDFC11E6B")
        public FasterStringBuilder clear() {
mLength=0FasterStringBuilder var72A74007B2BE62B849F475C7BDA4658B_176322832 = this            var72A74007B2BE62B849F475C7BDA4658B_176322832.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_176322832;
            // ---------- Original Method ----------
            //mLength = 0;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.251 -0400", hash_original_method = "846177021542D746EEE1DA4BD8E06ABD", hash_generated_method = "058C46C1C659214F2E09C467C784A36A")
        public FasterStringBuilder append(String value) {
            addTaint(value.getTaint());
            final int valueLength = value.length();
            final int index = reserve(valueLength);
value.getChars(0, valueLength, mChars, index)mLength+=valueLengthFasterStringBuilder var72A74007B2BE62B849F475C7BDA4658B_910121665 = this            var72A74007B2BE62B849F475C7BDA4658B_910121665.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_910121665;
            // ---------- Original Method ----------
            //final int valueLength = value.length();
            //final int index = reserve(valueLength);
            //value.getChars(0, valueLength, mChars, index);
            //mLength += valueLength;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.252 -0400", hash_original_method = "5B5CE117DC818490C7DB3E8E7B3AF676", hash_generated_method = "6D01132B583C8AD13665EE5CAD46723C")
        public FasterStringBuilder append(int value) {
            addTaint(value);
FasterStringBuilder var9AB1FCF58DE16CB7697F606818A3D914_1144219413 = append(value, 0)            var9AB1FCF58DE16CB7697F606818A3D914_1144219413.addTaint(taint);
            return var9AB1FCF58DE16CB7697F606818A3D914_1144219413;
            // ---------- Original Method ----------
            //return append(value, 0);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.253 -0400", hash_original_method = "2C7E50D8E8E39834463997CABA889589", hash_generated_method = "8DC640AC4DBA32287A50A9D69ABF3EBE")
        public FasterStringBuilder append(int value, int zeroPadWidth) {
            addTaint(zeroPadWidth);
            addTaint(value);
            final boolean negative = value < 0;
            if(negative)            
            {
value=-value                if(value<0)                
                {
append("-2147483648")FasterStringBuilder var72A74007B2BE62B849F475C7BDA4658B_1035532295 = this                    var72A74007B2BE62B849F475C7BDA4658B_1035532295.addTaint(taint);
                    return var72A74007B2BE62B849F475C7BDA4658B_1035532295;
                } //End block
            } //End block
            int index = reserve(11);
            final char[] chars = mChars;
            if(value==0)            
            {
chars[index++]='0'mLength+=1FasterStringBuilder var72A74007B2BE62B849F475C7BDA4658B_778481804 = this                var72A74007B2BE62B849F475C7BDA4658B_778481804.addTaint(taint);
                return var72A74007B2BE62B849F475C7BDA4658B_778481804;
            } //End block
            if(negative)            
            {
chars[index++]='-'
            } //End block
            int divisor = 1000000000;
            int numberWidth = 10;
            while
(value<divisor)            
            {
divisor/=10numberWidth-=1                if(numberWidth<zeroPadWidth)                
                {
chars[index++]='0'
                } //End block
            } //End block
            do {
                {
                    int digit = value / divisor;
value-=digit*divisordivisor/=10chars[index++]=(char) (digit+'0')
                } //End block
} while (divisor!=0);
mLength=indexFasterStringBuilder var72A74007B2BE62B849F475C7BDA4658B_1695492012 = this            var72A74007B2BE62B849F475C7BDA4658B_1695492012.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1695492012;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.253 -0400", hash_original_method = "03F6E980A78A16D5A8F02E65E2311932", hash_generated_method = "458C674F12D6230E9AE84CD9936E2709")
        public FasterStringBuilder append(float value, int precision) {
            addTaint(precision);
            addTaint(value);
            int scale = 1;
for(int i = 0;i<precision;i)
            {
scale*=10
            } //End block
value=(float) (Math.rint(value*scale)/scale)append((int) value)            if(precision!=0)            
            {
append(".")value=Math.abs(value)value-=Math.floor(value)append((int) (value*scale), precision)
            } //End block
FasterStringBuilder var72A74007B2BE62B849F475C7BDA4658B_1981032446 = this            var72A74007B2BE62B849F475C7BDA4658B_1981032446.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1981032446;
            // ---------- Original Method ----------
            //int scale = 1;
            //for (int i = 0; i < precision; i++) {
                //scale *= 10;
            //}
            //value = (float) (Math.rint(value * scale) / scale);
            //append((int) value);
            //if (precision != 0) {
                //append(".");
                //value = Math.abs(value);
                //value -= Math.floor(value);
                //append((int) (value * scale), precision);
            //}
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.254 -0400", hash_original_method = "E709100C3CD29394977C6BE516231DDB", hash_generated_method = "F75AFFDC63837DC79CB10A9D5E8065B0")
        @Override
        public String toString() {
String varEA80F4D0B7673D592E53FB10C148793E_1641426704 = new String(mChars, 0, mLength)            varEA80F4D0B7673D592E53FB10C148793E_1641426704.addTaint(taint);
            return varEA80F4D0B7673D592E53FB10C148793E_1641426704;
            // ---------- Original Method ----------
            //return new String(mChars, 0, mLength);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.254 -0400", hash_original_method = "9C7B6037AC40371ADAA69922E28E03D1", hash_generated_method = "BE82EF4345B59C3203F9D6BF371B1505")
        private int reserve(int length) {
            addTaint(length);
            final int oldLength = mLength;
            final int newLength = mLength + length;
            final char[] oldChars = mChars;
            final int oldCapacity = oldChars.length;
            if(newLength>oldCapacity)            
            {
                final int newCapacity = oldCapacity * 2;
                final char[] newChars = new char[newCapacity];
System.arraycopy(oldChars, 0, newChars, 0, oldLength)mChars=newChars
            } //End block
            int varA6A9E2E94D446D90736B58CEF30069F4_377057649 = (oldLength);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1596385716 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1596385716;
            // ---------- Original Method ----------
            //final int oldLength = mLength;
            //final int newLength = mLength + length;
            //final char[] oldChars = mChars;
            //final int oldCapacity = oldChars.length;
            //if (newLength > oldCapacity) {
                //final int newCapacity = oldCapacity * 2;
                //final char[] newChars = new char[newCapacity];
                //System.arraycopy(oldChars, 0, newChars, 0, oldLength);
                //mChars = newChars;
            //}
            //return oldLength;
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.255 -0400", hash_original_field = "389561FDF1C2F078F5BD6B986D9DBFB2", hash_generated_field = "3017311C500750B9BD5CF4D7D908515A")

    private static final String TAG = "Pointer";
}

