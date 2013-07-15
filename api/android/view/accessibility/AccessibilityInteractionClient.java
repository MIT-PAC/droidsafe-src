package android.view.accessibility;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.112 -0400", hash_original_field = "876C08859ADD60468823CCE8896C3049", hash_generated_field = "1B453B20F0C1F3432E8CE879D519121D")

    private final AtomicInteger mInteractionIdCounter = new AtomicInteger();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.112 -0400", hash_original_field = "4C000E064E4AAC53A002F734A3803AFE", hash_generated_field = "6392F8242B4A9D3DC6E2F079ACDCEA46")

    private final Object mInstanceLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.112 -0400", hash_original_field = "78E57951C775A50B7436255FDA3E2F00", hash_generated_field = "AE60776173DBC048CFBFFABBE4C7746A")

    private int mInteractionId = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.112 -0400", hash_original_field = "DBF170501ED14C76D94C024620EC0964", hash_generated_field = "A3D55D5A4D331347A5DC8437AFB890DE")

    private AccessibilityNodeInfo mFindAccessibilityNodeInfoResult;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.113 -0400", hash_original_field = "5A690144232F2C09A7728A08EE36623B", hash_generated_field = "3DCE295151A485FE086C2499765CB1E4")

    private List<AccessibilityNodeInfo> mFindAccessibilityNodeInfosResult;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.113 -0400", hash_original_field = "42B25754C595D6B826CDE88BF14D76C4", hash_generated_field = "1D4D87B32D7664CC278418585538879B")

    private boolean mPerformAccessibilityActionResult;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.113 -0400", hash_original_field = "DF57E2FC1D1BA984093D649925AA80CB", hash_generated_field = "F8EC948A5A458F05C0667906EB13AD52")

    private Message mSameThreadMessage;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.113 -0400", hash_original_field = "E3FB88F1170F920ECFA15D83AA99D025", hash_generated_field = "9DBB084DD0568D939B76BF72796B166A")

    private final Rect mTempBounds = new Rect();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.113 -0400", hash_original_method = "974B96BB2B096535DAB8082291151E7A", hash_generated_method = "974B96BB2B096535DAB8082291151E7A")
    public AccessibilityInteractionClient ()
    {
        //Synthesized constructor
    }


        public static AccessibilityInteractionClient getInstance() {
        synchronized (sStaticLock) {
            if (sInstance == null) {
                sInstance = new AccessibilityInteractionClient();
            }
            return sInstance;
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.114 -0400", hash_original_method = "552BFB14766A8DC73E6AAA7040599DCF", hash_generated_method = "02A7256EC703E89A60E003FE7E1C1DED")
    public void setSameThreadMessage(Message message) {
        synchronized
(mInstanceLock)        {
            mSameThreadMessage = message;
            mInstanceLock.notifyAll();
        } //End block
        // ---------- Original Method ----------
        //synchronized (mInstanceLock) {
            //mSameThreadMessage = message;
            //mInstanceLock.notifyAll();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.114 -0400", hash_original_method = "5C41BEE5A47D8A94E160F887E5B51CE0", hash_generated_method = "D9DE88FB6D72F93614D37030BFE0FE85")
    public AccessibilityNodeInfo findAccessibilityNodeInfoByAccessibilityId(int connectionId,
            int accessibilityWindowId, int accessibilityViewId) {
        addTaint(accessibilityViewId);
        addTaint(accessibilityWindowId);
        addTaint(connectionId);
        try 
        {
            IAccessibilityServiceConnection connection = getConnection(connectionId);
    if(connection != null)            
            {
                final int interactionId = mInteractionIdCounter.getAndIncrement();
                final float windowScale = connection.findAccessibilityNodeInfoByAccessibilityId(
                        accessibilityWindowId, accessibilityViewId, interactionId, this,
                        Thread.currentThread().getId());
    if(windowScale > 0)                
                {
                    AccessibilityNodeInfo info = getFindAccessibilityNodeInfoResultAndClear(
                            interactionId);
                    finalizeAccessibilityNodeInfo(info, connectionId, windowScale);
AccessibilityNodeInfo var43CF3338FDBA93597A9562D3166E9DC4_492983180 =                     info;
                    var43CF3338FDBA93597A9562D3166E9DC4_492983180.addTaint(taint);
                    return var43CF3338FDBA93597A9562D3166E9DC4_492983180;
                } //End block
            } //End block
            else
            {
    if(DEBUG)                
                {
                } //End block
            } //End block
        } //End block
        catch (RemoteException re)
        {
    if(DEBUG)            
            {
            } //End block
        } //End block
AccessibilityNodeInfo var540C13E9E156B687226421B24F2DF178_936259179 =         null;
        var540C13E9E156B687226421B24F2DF178_936259179.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_936259179;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.115 -0400", hash_original_method = "60BBE77BB0E3F47D3C9CB3C547527867", hash_generated_method = "FFCE637C7AA298B425DC28DEB5697776")
    public AccessibilityNodeInfo findAccessibilityNodeInfoByViewIdInActiveWindow(int connectionId,
            int viewId) {
        addTaint(viewId);
        addTaint(connectionId);
        try 
        {
            IAccessibilityServiceConnection connection = getConnection(connectionId);
    if(connection != null)            
            {
                final int interactionId = mInteractionIdCounter.getAndIncrement();
                final float windowScale = connection.findAccessibilityNodeInfoByViewIdInActiveWindow(viewId,
                            interactionId, this, Thread.currentThread().getId());
    if(windowScale > 0)                
                {
                    AccessibilityNodeInfo info = getFindAccessibilityNodeInfoResultAndClear(
                            interactionId);
                    finalizeAccessibilityNodeInfo(info, connectionId, windowScale);
AccessibilityNodeInfo var43CF3338FDBA93597A9562D3166E9DC4_605153264 =                     info;
                    var43CF3338FDBA93597A9562D3166E9DC4_605153264.addTaint(taint);
                    return var43CF3338FDBA93597A9562D3166E9DC4_605153264;
                } //End block
            } //End block
            else
            {
    if(DEBUG)                
                {
                } //End block
            } //End block
        } //End block
        catch (RemoteException re)
        {
    if(DEBUG)            
            {
            } //End block
        } //End block
AccessibilityNodeInfo var540C13E9E156B687226421B24F2DF178_374704672 =         null;
        var540C13E9E156B687226421B24F2DF178_374704672.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_374704672;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.116 -0400", hash_original_method = "672E254807B5370E478DCC44723B0294", hash_generated_method = "BFC2355B390168BE6021F64E5D5364AC")
    public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByViewTextInActiveWindow(
            int connectionId, String text) {
        addTaint(text.getTaint());
        addTaint(connectionId);
        try 
        {
            IAccessibilityServiceConnection connection = getConnection(connectionId);
    if(connection != null)            
            {
                final int interactionId = mInteractionIdCounter.getAndIncrement();
                final float windowScale = connection.findAccessibilityNodeInfosByViewTextInActiveWindow(text,
                            interactionId, this, Thread.currentThread().getId());
    if(windowScale > 0)                
                {
                    List<AccessibilityNodeInfo> infos = getFindAccessibilityNodeInfosResultAndClear(
                            interactionId);
                    finalizeAccessibilityNodeInfos(infos, connectionId, windowScale);
List<AccessibilityNodeInfo> var856335B33F20D10100490622F4E3620B_2052351277 =                     infos;
                    var856335B33F20D10100490622F4E3620B_2052351277.addTaint(taint);
                    return var856335B33F20D10100490622F4E3620B_2052351277;
                } //End block
            } //End block
            else
            {
    if(DEBUG)                
                {
                } //End block
            } //End block
        } //End block
        catch (RemoteException re)
        {
    if(DEBUG)            
            {
            } //End block
        } //End block
List<AccessibilityNodeInfo> var540C13E9E156B687226421B24F2DF178_139503798 =         null;
        var540C13E9E156B687226421B24F2DF178_139503798.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_139503798;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.117 -0400", hash_original_method = "AC3652D7BF4240B02C1C5545B023526D", hash_generated_method = "81B6B886824FD484A33F5871E1517F12")
    public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByViewText(int connectionId,
            String text, int accessibilityWindowId, int accessibilityViewId) {
        addTaint(accessibilityViewId);
        addTaint(accessibilityWindowId);
        addTaint(text.getTaint());
        addTaint(connectionId);
        try 
        {
            IAccessibilityServiceConnection connection = getConnection(connectionId);
    if(connection != null)            
            {
                final int interactionId = mInteractionIdCounter.getAndIncrement();
                final float windowScale = connection.findAccessibilityNodeInfosByViewText(text,
                        accessibilityWindowId, accessibilityViewId, interactionId, this,
                        Thread.currentThread().getId());
    if(windowScale > 0)                
                {
                    List<AccessibilityNodeInfo> infos = getFindAccessibilityNodeInfosResultAndClear(
                            interactionId);
                    finalizeAccessibilityNodeInfos(infos, connectionId, windowScale);
List<AccessibilityNodeInfo> var856335B33F20D10100490622F4E3620B_1806670474 =                     infos;
                    var856335B33F20D10100490622F4E3620B_1806670474.addTaint(taint);
                    return var856335B33F20D10100490622F4E3620B_1806670474;
                } //End block
            } //End block
            else
            {
    if(DEBUG)                
                {
                } //End block
            } //End block
        } //End block
        catch (RemoteException re)
        {
    if(DEBUG)            
            {
            } //End block
        } //End block
List<AccessibilityNodeInfo> varB803AB532741AA7D5C2F301CCDDD25F2_595587260 =         Collections.emptyList();
        varB803AB532741AA7D5C2F301CCDDD25F2_595587260.addTaint(taint);
        return varB803AB532741AA7D5C2F301CCDDD25F2_595587260;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.117 -0400", hash_original_method = "DACD676F99BB7BF8CCFB6D2A7B9FDEF9", hash_generated_method = "EAE7BED4F57DF9D629A85DCBAD9C3095")
    public boolean performAccessibilityAction(int connectionId, int accessibilityWindowId,
            int accessibilityViewId, int action) {
        addTaint(action);
        addTaint(accessibilityViewId);
        addTaint(accessibilityWindowId);
        addTaint(connectionId);
        try 
        {
            IAccessibilityServiceConnection connection = getConnection(connectionId);
    if(connection != null)            
            {
                final int interactionId = mInteractionIdCounter.getAndIncrement();
                final boolean success = connection.performAccessibilityAction(
                        accessibilityWindowId, accessibilityViewId, action, interactionId, this,
                        Thread.currentThread().getId());
    if(success)                
                {
                    boolean varC1E1ADF04C1563A5F6A95329CE3AC979_1227457821 = (getPerformAccessibilityActionResult(interactionId));
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_501192938 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_501192938;
                } //End block
            } //End block
            else
            {
    if(DEBUG)                
                {
                } //End block
            } //End block
        } //End block
        catch (RemoteException re)
        {
    if(DEBUG)            
            {
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1255443245 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_721118510 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_721118510;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.118 -0400", hash_original_method = "6C285733A381BDAF8984CA8B204B1B7E", hash_generated_method = "193C577807E502D543B27BFE4699E3EE")
    private AccessibilityNodeInfo getFindAccessibilityNodeInfoResultAndClear(int interactionId) {
        addTaint(interactionId);
        synchronized
(mInstanceLock)        {
            final boolean success = waitForResultTimedLocked(interactionId);
            AccessibilityNodeInfo result = success ? mFindAccessibilityNodeInfoResult : null;
            clearResultLocked();
AccessibilityNodeInfo varDC838461EE2FA0CA4C9BBB70A15456B0_1111532767 =             result;
            varDC838461EE2FA0CA4C9BBB70A15456B0_1111532767.addTaint(taint);
            return varDC838461EE2FA0CA4C9BBB70A15456B0_1111532767;
        } //End block
        // ---------- Original Method ----------
        //synchronized (mInstanceLock) {
            //final boolean success = waitForResultTimedLocked(interactionId);
            //AccessibilityNodeInfo result = success ? mFindAccessibilityNodeInfoResult : null;
            //clearResultLocked();
            //return result;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.118 -0400", hash_original_method = "5773A7995D438CAC0AFDE10E46EB704D", hash_generated_method = "8D43AE590E4AD767E8FD75B07CB7BF64")
    public void setFindAccessibilityNodeInfoResult(AccessibilityNodeInfo info,
                int interactionId) {
        synchronized
(mInstanceLock)        {
    if(interactionId > mInteractionId)            
            {
                mFindAccessibilityNodeInfoResult = info;
                mInteractionId = interactionId;
            } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.119 -0400", hash_original_method = "12169805BC03BC63B5C90B56149C0703", hash_generated_method = "4CECAE5BAFDF33066E86AF9B6E7E1A35")
    private List<AccessibilityNodeInfo> getFindAccessibilityNodeInfosResultAndClear(
                int interactionId) {
        addTaint(interactionId);
        synchronized
(mInstanceLock)        {
            final boolean success = waitForResultTimedLocked(interactionId);
            List<AccessibilityNodeInfo> result = success ? mFindAccessibilityNodeInfosResult : null;
            clearResultLocked();
List<AccessibilityNodeInfo> varDC838461EE2FA0CA4C9BBB70A15456B0_1645280189 =             result;
            varDC838461EE2FA0CA4C9BBB70A15456B0_1645280189.addTaint(taint);
            return varDC838461EE2FA0CA4C9BBB70A15456B0_1645280189;
        } //End block
        // ---------- Original Method ----------
        //synchronized (mInstanceLock) {
            //final boolean success = waitForResultTimedLocked(interactionId);
            //List<AccessibilityNodeInfo> result = success ? mFindAccessibilityNodeInfosResult : null;
            //clearResultLocked();
            //return result;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.119 -0400", hash_original_method = "6CF51605A938A0D2B20285F05873A357", hash_generated_method = "59A9FEB3DF5D77B26AABD4CB7DB5A567")
    public void setFindAccessibilityNodeInfosResult(List<AccessibilityNodeInfo> infos,
                int interactionId) {
        synchronized
(mInstanceLock)        {
    if(interactionId > mInteractionId)            
            {
                mFindAccessibilityNodeInfosResult = infos;
                mInteractionId = interactionId;
            } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.120 -0400", hash_original_method = "785F868CD3C42AFCCB7588732B0BC5FA", hash_generated_method = "D9CD20C7E933059A079E42056DAD0B0A")
    private boolean getPerformAccessibilityActionResult(int interactionId) {
        addTaint(interactionId);
        synchronized
(mInstanceLock)        {
            final boolean success = waitForResultTimedLocked(interactionId);
            final boolean result = success ? mPerformAccessibilityActionResult : false;
            clearResultLocked();
            boolean varB4A88417B3D0170D754C647C30B7216A_1214430894 = (result);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1298711954 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1298711954;
        } //End block
        // ---------- Original Method ----------
        //synchronized (mInstanceLock) {
            //final boolean success = waitForResultTimedLocked(interactionId);
            //final boolean result = success ? mPerformAccessibilityActionResult : false;
            //clearResultLocked();
            //return result;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.120 -0400", hash_original_method = "F5BCF8753FEED883A431A33F4CB0BF32", hash_generated_method = "390ADE276DEA0B1E04B8065ECB891A68")
    public void setPerformAccessibilityActionResult(boolean succeeded, int interactionId) {
        synchronized
(mInstanceLock)        {
    if(interactionId > mInteractionId)            
            {
                mPerformAccessibilityActionResult = succeeded;
                mInteractionId = interactionId;
            } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.121 -0400", hash_original_method = "903092ED2C38BF649D61CAF92AAF4DF4", hash_generated_method = "B091948D31507164528E2CB3A01B1509")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.122 -0400", hash_original_method = "28474D5684D129A1738A9E8F91D9820E", hash_generated_method = "099E9105C3D848C476FD0553C09DA793")
    private boolean waitForResultTimedLocked(int interactionId) {
        addTaint(interactionId);
        long waitTimeMillis = TIMEOUT_INTERACTION_MILLIS;
        final long startTimeMillis = SystemClock.uptimeMillis();
        while
(true)        
        {
            try 
            {
                Message sameProcessMessage = getSameProcessMessageAndClear();
    if(sameProcessMessage != null)                
                {
                    sameProcessMessage.getTarget().handleMessage(sameProcessMessage);
                } //End block
    if(mInteractionId == interactionId)                
                {
                    boolean varB326B5062B2F0E69046810717534CB09_521657450 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1350565486 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1350565486;
                } //End block
    if(mInteractionId > interactionId)                
                {
                    boolean var68934A3E9455FA72420237EB05902327_202452189 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2065143013 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_2065143013;
                } //End block
                final long elapsedTimeMillis = SystemClock.uptimeMillis() - startTimeMillis;
                waitTimeMillis = TIMEOUT_INTERACTION_MILLIS - elapsedTimeMillis;
    if(waitTimeMillis <= 0)                
                {
                    boolean var68934A3E9455FA72420237EB05902327_1389844569 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1912664861 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1912664861;
                } //End block
                mInstanceLock.wait(waitTimeMillis);
            } //End block
            catch (InterruptedException ie)
            {
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.123 -0400", hash_original_method = "061B568C08B51F012B887F4F0E2A3802", hash_generated_method = "37E669957131C80B267E7DC9350CF837")
    private void applyCompatibilityScaleIfNeeded(AccessibilityNodeInfo info, float scale) {
        addTaint(scale);
        addTaint(info.getTaint());
    if(scale == 1.0f)        
        {
            return;
        } //End block
        Rect bounds = mTempBounds;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.124 -0400", hash_original_method = "50C3A05545C97DCA046561890361C747", hash_generated_method = "D5669C8FA74B024E5A4C0CFC4C4B9352")
    private void finalizeAccessibilityNodeInfo(AccessibilityNodeInfo info, int connectionId,
            float windowScale) {
        addTaint(windowScale);
        addTaint(connectionId);
        addTaint(info.getTaint());
    if(info != null)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.124 -0400", hash_original_method = "C4CCA9503A1FCF65E2280A82ABED87CD", hash_generated_method = "112FE17DBDF340BC970BDACAE3B4CBEB")
    private void finalizeAccessibilityNodeInfos(List<AccessibilityNodeInfo> infos,
            int connectionId, float windowScale) {
        addTaint(windowScale);
        addTaint(connectionId);
        addTaint(infos.getTaint());
    if(infos != null)        
        {
            final int infosCount = infos.size();
for(int i = 0;i < infosCount;i++)
            {
                AccessibilityNodeInfo info = infos.get(i);
                finalizeAccessibilityNodeInfo(info, connectionId, windowScale);
            } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.125 -0400", hash_original_method = "44FB956257430D3824804A6F98AEDC24", hash_generated_method = "2CEFC81F4C56AE7493F0289BF89C7226")
    private Message getSameProcessMessageAndClear() {
        synchronized
(mInstanceLock)        {
            Message result = mSameThreadMessage;
            mSameThreadMessage = null;
Message varDC838461EE2FA0CA4C9BBB70A15456B0_1646958414 =             result;
            varDC838461EE2FA0CA4C9BBB70A15456B0_1646958414.addTaint(taint);
            return varDC838461EE2FA0CA4C9BBB70A15456B0_1646958414;
        } //End block
        // ---------- Original Method ----------
        //synchronized (mInstanceLock) {
            //Message result = mSameThreadMessage;
            //mSameThreadMessage = null;
            //return result;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.125 -0400", hash_original_method = "C30C93509C0684283448214BFA9D8225", hash_generated_method = "3D0544D9648F98D2C8B5163496DA3FC1")
    public IAccessibilityServiceConnection getConnection(int connectionId) {
        addTaint(connectionId);
        synchronized
(sConnectionCache)        {
IAccessibilityServiceConnection var98465E8A99225005A9A34F617F286736_774848334 =             sConnectionCache.get(connectionId);
            var98465E8A99225005A9A34F617F286736_774848334.addTaint(taint);
            return var98465E8A99225005A9A34F617F286736_774848334;
        } //End block
        // ---------- Original Method ----------
        //synchronized (sConnectionCache) {
            //return sConnectionCache.get(connectionId);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.126 -0400", hash_original_method = "7A0506F80A0A925F6D871EC270864AAB", hash_generated_method = "9BB2666AF6E21A666E121911D7C2BCE9")
    public void addConnection(int connectionId, IAccessibilityServiceConnection connection) {
        addTaint(connection.getTaint());
        addTaint(connectionId);
        synchronized
(sConnectionCache)        {
            sConnectionCache.put(connectionId, connection);
        } //End block
        // ---------- Original Method ----------
        //synchronized (sConnectionCache) {
            //sConnectionCache.put(connectionId, connection);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.126 -0400", hash_original_method = "A8D0295941AD6316CEC94ABF823C5DD4", hash_generated_method = "3A3683A65B52115BA1A14871F718EF7C")
    public void removeConnection(int connectionId) {
        addTaint(connectionId);
        synchronized
(sConnectionCache)        {
            sConnectionCache.remove(connectionId);
        } //End block
        // ---------- Original Method ----------
        //synchronized (sConnectionCache) {
            //sConnectionCache.remove(connectionId);
        //}
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.126 -0400", hash_original_field = "88123DE8DF5143F6086D0A4BB7B00CB8", hash_generated_field = "181E1190C48C3A15B723E1972525FFE6")

    public static final int NO_ID = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.126 -0400", hash_original_field = "0C7D9D7FBEAD804B937B1F8909595D53", hash_generated_field = "F39970B10B2A1B6AAAA3BAA95BD6C833")

    private static final String LOG_TAG = "AccessibilityInteractionClient";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.126 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "58EDF43BA541A4D47EECFEC3901C7AED")

    private static final boolean DEBUG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.126 -0400", hash_original_field = "B73554B3F2697BD58E344FA09EC215CB", hash_generated_field = "879CDE422299A8456AD3253132795354")

    private static final long TIMEOUT_INTERACTION_MILLIS = 5000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.126 -0400", hash_original_field = "6F01FC6BDB2E7BC12F6360B41E8B2316", hash_generated_field = "498BA8A796A917C092E570F2E37A3E7B")

    private static final Object sStaticLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.126 -0400", hash_original_field = "06E23A628CBDEAB09E91C69789BB1974", hash_generated_field = "429338DE764BD4ACB4DB8F09D348E465")

    private static AccessibilityInteractionClient sInstance;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.126 -0400", hash_original_field = "68D2F562B014FB326649FCB552B92CED", hash_generated_field = "82A9D097CD8F5394610FEB7829547E07")

    private static final SparseArray<IAccessibilityServiceConnection> sConnectionCache = new SparseArray<IAccessibilityServiceConnection>();
}

