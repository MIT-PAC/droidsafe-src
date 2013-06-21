package android.view.accessibility;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.accessibilityservice.IAccessibilityServiceConnection;
import android.graphics.Rect;
import android.os.Message;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import android.util.SparseArray;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public final class AccessibilityInteractionClient extends IAccessibilityInteractionConnectionCallback.Stub {
    private AtomicInteger mInteractionIdCounter = new AtomicInteger();
    private Object mInstanceLock = new Object();
    private int mInteractionId = -1;
    private AccessibilityNodeInfo mFindAccessibilityNodeInfoResult;
    private List<AccessibilityNodeInfo> mFindAccessibilityNodeInfosResult;
    private boolean mPerformAccessibilityActionResult;
    private Message mSameThreadMessage;
    private Rect mTempBounds = new Rect();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.807 -0400", hash_original_method = "AAB66CD8BF1197B9DB48F0548E0BA0CF", hash_generated_method = "AAB66CD8BF1197B9DB48F0548E0BA0CF")
        public AccessibilityInteractionClient ()
    {
    }


        public static AccessibilityInteractionClient getInstance() {
        synchronized (sStaticLock) {
            if (sInstance == null) {
                sInstance = new AccessibilityInteractionClient();
            }
            return sInstance;
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.808 -0400", hash_original_method = "552BFB14766A8DC73E6AAA7040599DCF", hash_generated_method = "9781BB4E1D1438F6F05ABAAD72E2076A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setSameThreadMessage(Message message) {
        dsTaint.addTaint(message.dsTaint);
        {
            mInstanceLock.notifyAll();
        } //End block
        // ---------- Original Method ----------
        //synchronized (mInstanceLock) {
            //mSameThreadMessage = message;
            //mInstanceLock.notifyAll();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.808 -0400", hash_original_method = "5C41BEE5A47D8A94E160F887E5B51CE0", hash_generated_method = "4EDDFA849625A77722A4F59D3A6A6E81")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AccessibilityNodeInfo findAccessibilityNodeInfoByAccessibilityId(int connectionId,
            int accessibilityWindowId, int accessibilityViewId) {
        dsTaint.addTaint(connectionId);
        dsTaint.addTaint(accessibilityViewId);
        dsTaint.addTaint(accessibilityWindowId);
        try 
        {
            IAccessibilityServiceConnection connection;
            connection = getConnection(connectionId);
            {
                int interactionId;
                interactionId = mInteractionIdCounter.getAndIncrement();
                float windowScale;
                windowScale = connection.findAccessibilityNodeInfoByAccessibilityId(
                        accessibilityWindowId, accessibilityViewId, interactionId, this,
                        Thread.currentThread().getId());
                {
                    AccessibilityNodeInfo info;
                    info = getFindAccessibilityNodeInfoResultAndClear(
                            interactionId);
                    finalizeAccessibilityNodeInfo(info, connectionId, windowScale);
                } //End block
            } //End block
        } //End block
        catch (RemoteException re)
        { }
        return (AccessibilityNodeInfo)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.808 -0400", hash_original_method = "60BBE77BB0E3F47D3C9CB3C547527867", hash_generated_method = "78DE9142CE1C62FEFF3EB1854668EE62")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AccessibilityNodeInfo findAccessibilityNodeInfoByViewIdInActiveWindow(int connectionId,
            int viewId) {
        dsTaint.addTaint(connectionId);
        dsTaint.addTaint(viewId);
        try 
        {
            IAccessibilityServiceConnection connection;
            connection = getConnection(connectionId);
            {
                int interactionId;
                interactionId = mInteractionIdCounter.getAndIncrement();
                float windowScale;
                windowScale = connection.findAccessibilityNodeInfoByViewIdInActiveWindow(viewId,
                            interactionId, this, Thread.currentThread().getId());
                {
                    AccessibilityNodeInfo info;
                    info = getFindAccessibilityNodeInfoResultAndClear(
                            interactionId);
                    finalizeAccessibilityNodeInfo(info, connectionId, windowScale);
                } //End block
            } //End block
        } //End block
        catch (RemoteException re)
        { }
        return (AccessibilityNodeInfo)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.809 -0400", hash_original_method = "672E254807B5370E478DCC44723B0294", hash_generated_method = "D626D0AC808B19D320B6BB12BECED655")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByViewTextInActiveWindow(
            int connectionId, String text) {
        dsTaint.addTaint(text);
        dsTaint.addTaint(connectionId);
        try 
        {
            IAccessibilityServiceConnection connection;
            connection = getConnection(connectionId);
            {
                int interactionId;
                interactionId = mInteractionIdCounter.getAndIncrement();
                float windowScale;
                windowScale = connection.findAccessibilityNodeInfosByViewTextInActiveWindow(text,
                            interactionId, this, Thread.currentThread().getId());
                {
                    List<AccessibilityNodeInfo> infos;
                    infos = getFindAccessibilityNodeInfosResultAndClear(
                            interactionId);
                    finalizeAccessibilityNodeInfos(infos, connectionId, windowScale);
                } //End block
            } //End block
        } //End block
        catch (RemoteException re)
        { }
        return (List<AccessibilityNodeInfo>)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.809 -0400", hash_original_method = "AC3652D7BF4240B02C1C5545B023526D", hash_generated_method = "45C5A2ECB83C85B8269D2003C0D45E6A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByViewText(int connectionId,
            String text, int accessibilityWindowId, int accessibilityViewId) {
        dsTaint.addTaint(text);
        dsTaint.addTaint(connectionId);
        dsTaint.addTaint(accessibilityViewId);
        dsTaint.addTaint(accessibilityWindowId);
        try 
        {
            IAccessibilityServiceConnection connection;
            connection = getConnection(connectionId);
            {
                int interactionId;
                interactionId = mInteractionIdCounter.getAndIncrement();
                float windowScale;
                windowScale = connection.findAccessibilityNodeInfosByViewText(text,
                        accessibilityWindowId, accessibilityViewId, interactionId, this,
                        Thread.currentThread().getId());
                {
                    List<AccessibilityNodeInfo> infos;
                    infos = getFindAccessibilityNodeInfosResultAndClear(
                            interactionId);
                    finalizeAccessibilityNodeInfos(infos, connectionId, windowScale);
                } //End block
            } //End block
        } //End block
        catch (RemoteException re)
        { }
        List<AccessibilityNodeInfo> varDA6BCEB8474C9FFEA13E4E44889D7138_1995035232 = (Collections.emptyList());
        return (List<AccessibilityNodeInfo>)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.809 -0400", hash_original_method = "DACD676F99BB7BF8CCFB6D2A7B9FDEF9", hash_generated_method = "6CD2AAFD161DD279DE00D85104C07301")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean performAccessibilityAction(int connectionId, int accessibilityWindowId,
            int accessibilityViewId, int action) {
        dsTaint.addTaint(connectionId);
        dsTaint.addTaint(action);
        dsTaint.addTaint(accessibilityViewId);
        dsTaint.addTaint(accessibilityWindowId);
        try 
        {
            IAccessibilityServiceConnection connection;
            connection = getConnection(connectionId);
            {
                int interactionId;
                interactionId = mInteractionIdCounter.getAndIncrement();
                boolean success;
                success = connection.performAccessibilityAction(
                        accessibilityWindowId, accessibilityViewId, action, interactionId, this,
                        Thread.currentThread().getId());
                {
                    boolean var0B4F88CEC11C94715435D9E907451D2F_1459550263 = (getPerformAccessibilityActionResult(interactionId));
                } //End block
            } //End block
        } //End block
        catch (RemoteException re)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.810 -0400", hash_original_method = "6C285733A381BDAF8984CA8B204B1B7E", hash_generated_method = "4B7B92E121F4626D37ED208751CA11F1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private AccessibilityNodeInfo getFindAccessibilityNodeInfoResultAndClear(int interactionId) {
        dsTaint.addTaint(interactionId);
        {
            boolean success;
            success = waitForResultTimedLocked(interactionId);
            AccessibilityNodeInfo result;
            result = mFindAccessibilityNodeInfoResult;
            result = null;
            clearResultLocked();
        } //End block
        return (AccessibilityNodeInfo)dsTaint.getTaint();
        // ---------- Original Method ----------
        //synchronized (mInstanceLock) {
            //final boolean success = waitForResultTimedLocked(interactionId);
            //AccessibilityNodeInfo result = success ? mFindAccessibilityNodeInfoResult : null;
            //clearResultLocked();
            //return result;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.810 -0400", hash_original_method = "5773A7995D438CAC0AFDE10E46EB704D", hash_generated_method = "01849B28DA0C8F7B874A59A9AA1F52EA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setFindAccessibilityNodeInfoResult(AccessibilityNodeInfo info,
                int interactionId) {
        dsTaint.addTaint(interactionId);
        dsTaint.addTaint(info.dsTaint);
        {
            mInstanceLock.notifyAll();
        } //End block
        // ---------- Original Method ----------
        //synchronized (mInstanceLock) {
            //if (interactionId > mInteractionId) {
                //mFindAccessibilityNodeInfoResult = info;
                //mInteractionId = interactionId;
            //}
            //mInstanceLock.notifyAll();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.810 -0400", hash_original_method = "12169805BC03BC63B5C90B56149C0703", hash_generated_method = "9A5CC4401EB688097512F83115182D8A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private List<AccessibilityNodeInfo> getFindAccessibilityNodeInfosResultAndClear(
                int interactionId) {
        dsTaint.addTaint(interactionId);
        {
            boolean success;
            success = waitForResultTimedLocked(interactionId);
            List<AccessibilityNodeInfo> result;
            result = mFindAccessibilityNodeInfosResult;
            result = null;
            clearResultLocked();
        } //End block
        return (List<AccessibilityNodeInfo>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //synchronized (mInstanceLock) {
            //final boolean success = waitForResultTimedLocked(interactionId);
            //List<AccessibilityNodeInfo> result = success ? mFindAccessibilityNodeInfosResult : null;
            //clearResultLocked();
            //return result;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.810 -0400", hash_original_method = "6CF51605A938A0D2B20285F05873A357", hash_generated_method = "2B39E3F9F6BF8A99701B79E34D05F85A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setFindAccessibilityNodeInfosResult(List<AccessibilityNodeInfo> infos,
                int interactionId) {
        dsTaint.addTaint(infos.dsTaint);
        dsTaint.addTaint(interactionId);
        {
            mInstanceLock.notifyAll();
        } //End block
        // ---------- Original Method ----------
        //synchronized (mInstanceLock) {
            //if (interactionId > mInteractionId) {
                //mFindAccessibilityNodeInfosResult = infos;
                //mInteractionId = interactionId;
            //}
            //mInstanceLock.notifyAll();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.811 -0400", hash_original_method = "785F868CD3C42AFCCB7588732B0BC5FA", hash_generated_method = "E446145E59D29A9B5C49C02100961FC8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean getPerformAccessibilityActionResult(int interactionId) {
        dsTaint.addTaint(interactionId);
        {
            boolean success;
            success = waitForResultTimedLocked(interactionId);
            boolean result;
            result = mPerformAccessibilityActionResult;
            result = false;
            clearResultLocked();
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //synchronized (mInstanceLock) {
            //final boolean success = waitForResultTimedLocked(interactionId);
            //final boolean result = success ? mPerformAccessibilityActionResult : false;
            //clearResultLocked();
            //return result;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.811 -0400", hash_original_method = "F5BCF8753FEED883A431A33F4CB0BF32", hash_generated_method = "9DFA66647BEDCC226B1EAB12BFF09D58")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setPerformAccessibilityActionResult(boolean succeeded, int interactionId) {
        dsTaint.addTaint(succeeded);
        dsTaint.addTaint(interactionId);
        {
            mInstanceLock.notifyAll();
        } //End block
        // ---------- Original Method ----------
        //synchronized (mInstanceLock) {
            //if (interactionId > mInteractionId) {
                //mPerformAccessibilityActionResult = succeeded;
                //mInteractionId = interactionId;
            //}
            //mInstanceLock.notifyAll();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.811 -0400", hash_original_method = "903092ED2C38BF649D61CAF92AAF4DF4", hash_generated_method = "B091948D31507164528E2CB3A01B1509")
    @DSModeled(DSC.SAFE)
    private void clearResultLocked() {
        mInteractionId = -1;
        mFindAccessibilityNodeInfoResult = null;
        mFindAccessibilityNodeInfosResult = null;
        mPerformAccessibilityActionResult = false;
        // ---------- Original Method ----------
        //mInteractionId = -1;
        //mFindAccessibilityNodeInfoResult = null;
        //mFindAccessibilityNodeInfosResult = null;
        //mPerformAccessibilityActionResult = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.811 -0400", hash_original_method = "28474D5684D129A1738A9E8F91D9820E", hash_generated_method = "6C4AB86EE47C7856717755F5ED1EE26B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean waitForResultTimedLocked(int interactionId) {
        dsTaint.addTaint(interactionId);
        long waitTimeMillis;
        waitTimeMillis = TIMEOUT_INTERACTION_MILLIS;
        long startTimeMillis;
        startTimeMillis = SystemClock.uptimeMillis();
        {
            try 
            {
                Message sameProcessMessage;
                sameProcessMessage = getSameProcessMessageAndClear();
                {
                    sameProcessMessage.getTarget().handleMessage(sameProcessMessage);
                } //End block
                long elapsedTimeMillis;
                elapsedTimeMillis = SystemClock.uptimeMillis() - startTimeMillis;
                waitTimeMillis = TIMEOUT_INTERACTION_MILLIS - elapsedTimeMillis;
                mInstanceLock.wait(waitTimeMillis);
            } //End block
            catch (InterruptedException ie)
            { }
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.811 -0400", hash_original_method = "061B568C08B51F012B887F4F0E2A3802", hash_generated_method = "237450D1615FF8CB293A52DF7B70F9D9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void applyCompatibilityScaleIfNeeded(AccessibilityNodeInfo info, float scale) {
        dsTaint.addTaint(scale);
        dsTaint.addTaint(info.dsTaint);
        Rect bounds;
        bounds = mTempBounds;
        info.getBoundsInParent(bounds);
        bounds.scale(scale);
        info.setBoundsInParent(bounds);
        info.getBoundsInScreen(bounds);
        bounds.scale(scale);
        info.setBoundsInScreen(bounds);
        // ---------- Original Method ----------
        //if (scale == 1.0f) {
            //return;
        //}
        //Rect bounds = mTempBounds;
        //info.getBoundsInParent(bounds);
        //bounds.scale(scale);
        //info.setBoundsInParent(bounds);
        //info.getBoundsInScreen(bounds);
        //bounds.scale(scale);
        //info.setBoundsInScreen(bounds);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.812 -0400", hash_original_method = "50C3A05545C97DCA046561890361C747", hash_generated_method = "B3A4B7341919E7573F7032ACC39F0DA8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void finalizeAccessibilityNodeInfo(AccessibilityNodeInfo info, int connectionId,
            float windowScale) {
        dsTaint.addTaint(connectionId);
        dsTaint.addTaint(windowScale);
        dsTaint.addTaint(info.dsTaint);
        {
            applyCompatibilityScaleIfNeeded(info, windowScale);
            info.setConnectionId(connectionId);
            info.setSealed(true);
        } //End block
        // ---------- Original Method ----------
        //if (info != null) {
            //applyCompatibilityScaleIfNeeded(info, windowScale);
            //info.setConnectionId(connectionId);
            //info.setSealed(true);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.812 -0400", hash_original_method = "C4CCA9503A1FCF65E2280A82ABED87CD", hash_generated_method = "98053CCA0B5C825EB1144C122C0A6303")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void finalizeAccessibilityNodeInfos(List<AccessibilityNodeInfo> infos,
            int connectionId, float windowScale) {
        dsTaint.addTaint(infos.dsTaint);
        dsTaint.addTaint(connectionId);
        dsTaint.addTaint(windowScale);
        {
            int infosCount;
            infosCount = infos.size();
            {
                int i;
                i = 0;
                {
                    AccessibilityNodeInfo info;
                    info = infos.get(i);
                    finalizeAccessibilityNodeInfo(info, connectionId, windowScale);
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //if (infos != null) {
            //final int infosCount = infos.size();
            //for (int i = 0; i < infosCount; i++) {
                //AccessibilityNodeInfo info = infos.get(i);
                //finalizeAccessibilityNodeInfo(info, connectionId, windowScale);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.812 -0400", hash_original_method = "44FB956257430D3824804A6F98AEDC24", hash_generated_method = "D0B7DCB796BE1FD1E0F61FF65D45E1E4")
    @DSModeled(DSC.SAFE)
    private Message getSameProcessMessageAndClear() {
        {
            Message result;
            result = mSameThreadMessage;
            mSameThreadMessage = null;
        } //End block
        return (Message)dsTaint.getTaint();
        // ---------- Original Method ----------
        //synchronized (mInstanceLock) {
            //Message result = mSameThreadMessage;
            //mSameThreadMessage = null;
            //return result;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.813 -0400", hash_original_method = "C30C93509C0684283448214BFA9D8225", hash_generated_method = "1F1896F3C07D5C0E7E115F6A30F5F610")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public IAccessibilityServiceConnection getConnection(int connectionId) {
        dsTaint.addTaint(connectionId);
        {
            IAccessibilityServiceConnection var509C164EDA4099B8A6B68661391EDAB7_1089731241 = (sConnectionCache.get(connectionId));
        } //End block
        return (IAccessibilityServiceConnection)dsTaint.getTaint();
        // ---------- Original Method ----------
        //synchronized (sConnectionCache) {
            //return sConnectionCache.get(connectionId);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.813 -0400", hash_original_method = "7A0506F80A0A925F6D871EC270864AAB", hash_generated_method = "B52DEF925E1B1C3FAC5075AB7BAF1DAF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void addConnection(int connectionId, IAccessibilityServiceConnection connection) {
        dsTaint.addTaint(connection.dsTaint);
        dsTaint.addTaint(connectionId);
        {
            sConnectionCache.put(connectionId, connection);
        } //End block
        // ---------- Original Method ----------
        //synchronized (sConnectionCache) {
            //sConnectionCache.put(connectionId, connection);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.813 -0400", hash_original_method = "A8D0295941AD6316CEC94ABF823C5DD4", hash_generated_method = "973C15264DB6B8D4ED93243AEDEB28CA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removeConnection(int connectionId) {
        dsTaint.addTaint(connectionId);
        {
            sConnectionCache.remove(connectionId);
        } //End block
        // ---------- Original Method ----------
        //synchronized (sConnectionCache) {
            //sConnectionCache.remove(connectionId);
        //}
    }

    
    public static final int NO_ID = -1;
    private static final String LOG_TAG = "AccessibilityInteractionClient";
    private static final boolean DEBUG = false;
    private static final long TIMEOUT_INTERACTION_MILLIS = 5000;
    private static final Object sStaticLock = new Object();
    private static AccessibilityInteractionClient sInstance;
    private static final SparseArray<IAccessibilityServiceConnection> sConnectionCache =
        new SparseArray<IAccessibilityServiceConnection>();
}

