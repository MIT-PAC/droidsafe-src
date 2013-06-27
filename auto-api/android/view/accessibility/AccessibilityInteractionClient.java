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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.136 -0400", hash_original_field = "876C08859ADD60468823CCE8896C3049", hash_generated_field = "15C9027E8B1539F3127E7C0262DFF564")

    private AtomicInteger mInteractionIdCounter = new AtomicInteger();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.136 -0400", hash_original_field = "4C000E064E4AAC53A002F734A3803AFE", hash_generated_field = "57CA5461546F8A6E4F119E4442D8A0BC")

    private Object mInstanceLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.136 -0400", hash_original_field = "78E57951C775A50B7436255FDA3E2F00", hash_generated_field = "AE60776173DBC048CFBFFABBE4C7746A")

    private int mInteractionId = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.136 -0400", hash_original_field = "DBF170501ED14C76D94C024620EC0964", hash_generated_field = "A3D55D5A4D331347A5DC8437AFB890DE")

    private AccessibilityNodeInfo mFindAccessibilityNodeInfoResult;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.136 -0400", hash_original_field = "5A690144232F2C09A7728A08EE36623B", hash_generated_field = "3DCE295151A485FE086C2499765CB1E4")

    private List<AccessibilityNodeInfo> mFindAccessibilityNodeInfosResult;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.136 -0400", hash_original_field = "42B25754C595D6B826CDE88BF14D76C4", hash_generated_field = "1D4D87B32D7664CC278418585538879B")

    private boolean mPerformAccessibilityActionResult;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.136 -0400", hash_original_field = "DF57E2FC1D1BA984093D649925AA80CB", hash_generated_field = "F8EC948A5A458F05C0667906EB13AD52")

    private Message mSameThreadMessage;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.136 -0400", hash_original_field = "E3FB88F1170F920ECFA15D83AA99D025", hash_generated_field = "90840C3329620D54595BFC88FE5EAEC1")

    private Rect mTempBounds = new Rect();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.136 -0400", hash_original_method = "974B96BB2B096535DAB8082291151E7A", hash_generated_method = "974B96BB2B096535DAB8082291151E7A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.144 -0400", hash_original_method = "552BFB14766A8DC73E6AAA7040599DCF", hash_generated_method = "579E0A715D3754EF98AD6ACB21E52591")
    public void setSameThreadMessage(Message message) {
        {
            mSameThreadMessage = message;
            mInstanceLock.notifyAll();
        } //End block
        // ---------- Original Method ----------
        //synchronized (mInstanceLock) {
            //mSameThreadMessage = message;
            //mInstanceLock.notifyAll();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.144 -0400", hash_original_method = "5C41BEE5A47D8A94E160F887E5B51CE0", hash_generated_method = "9894EC2F3279AF78926D7808C437438E")
    public AccessibilityNodeInfo findAccessibilityNodeInfoByAccessibilityId(int connectionId,
            int accessibilityWindowId, int accessibilityViewId) {
        AccessibilityNodeInfo varB4EAC82CA7396A68D541C85D26508E83_1033288677 = null; //Variable for return #1
        AccessibilityNodeInfo varB4EAC82CA7396A68D541C85D26508E83_548694860 = null; //Variable for return #2
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
                    varB4EAC82CA7396A68D541C85D26508E83_1033288677 = info;
                } //End block
            } //End block
        } //End block
        catch (RemoteException re)
        { }
        varB4EAC82CA7396A68D541C85D26508E83_548694860 = null;
        addTaint(connectionId);
        addTaint(accessibilityWindowId);
        addTaint(accessibilityViewId);
        AccessibilityNodeInfo varA7E53CE21691AB073D9660D615818899_1416419582; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1416419582 = varB4EAC82CA7396A68D541C85D26508E83_1033288677;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1416419582 = varB4EAC82CA7396A68D541C85D26508E83_548694860;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1416419582.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1416419582;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.145 -0400", hash_original_method = "60BBE77BB0E3F47D3C9CB3C547527867", hash_generated_method = "CED2915B3DC5EDEF856DBB494AB7866F")
    public AccessibilityNodeInfo findAccessibilityNodeInfoByViewIdInActiveWindow(int connectionId,
            int viewId) {
        AccessibilityNodeInfo varB4EAC82CA7396A68D541C85D26508E83_1131670695 = null; //Variable for return #1
        AccessibilityNodeInfo varB4EAC82CA7396A68D541C85D26508E83_703147012 = null; //Variable for return #2
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
                    varB4EAC82CA7396A68D541C85D26508E83_1131670695 = info;
                } //End block
            } //End block
        } //End block
        catch (RemoteException re)
        { }
        varB4EAC82CA7396A68D541C85D26508E83_703147012 = null;
        addTaint(connectionId);
        addTaint(viewId);
        AccessibilityNodeInfo varA7E53CE21691AB073D9660D615818899_338700438; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_338700438 = varB4EAC82CA7396A68D541C85D26508E83_1131670695;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_338700438 = varB4EAC82CA7396A68D541C85D26508E83_703147012;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_338700438.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_338700438;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.154 -0400", hash_original_method = "672E254807B5370E478DCC44723B0294", hash_generated_method = "0D3845A33885BBB1A8D1EC2C65D174AD")
    public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByViewTextInActiveWindow(
            int connectionId, String text) {
        List<AccessibilityNodeInfo> varB4EAC82CA7396A68D541C85D26508E83_749467408 = null; //Variable for return #1
        List<AccessibilityNodeInfo> varB4EAC82CA7396A68D541C85D26508E83_1676903966 = null; //Variable for return #2
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
                    varB4EAC82CA7396A68D541C85D26508E83_749467408 = infos;
                } //End block
            } //End block
        } //End block
        catch (RemoteException re)
        { }
        varB4EAC82CA7396A68D541C85D26508E83_1676903966 = null;
        addTaint(connectionId);
        addTaint(text.getTaint());
        List<AccessibilityNodeInfo> varA7E53CE21691AB073D9660D615818899_237556512; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_237556512 = varB4EAC82CA7396A68D541C85D26508E83_749467408;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_237556512 = varB4EAC82CA7396A68D541C85D26508E83_1676903966;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_237556512.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_237556512;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.158 -0400", hash_original_method = "AC3652D7BF4240B02C1C5545B023526D", hash_generated_method = "3F4C7CC125E66A9D904ED1614B0074E5")
    public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByViewText(int connectionId,
            String text, int accessibilityWindowId, int accessibilityViewId) {
        List<AccessibilityNodeInfo> varB4EAC82CA7396A68D541C85D26508E83_345680820 = null; //Variable for return #1
        List<AccessibilityNodeInfo> varB4EAC82CA7396A68D541C85D26508E83_726719001 = null; //Variable for return #2
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
                    varB4EAC82CA7396A68D541C85D26508E83_345680820 = infos;
                } //End block
            } //End block
        } //End block
        catch (RemoteException re)
        { }
        varB4EAC82CA7396A68D541C85D26508E83_726719001 = Collections.emptyList();
        addTaint(connectionId);
        addTaint(text.getTaint());
        addTaint(accessibilityWindowId);
        addTaint(accessibilityViewId);
        List<AccessibilityNodeInfo> varA7E53CE21691AB073D9660D615818899_1880090164; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1880090164 = varB4EAC82CA7396A68D541C85D26508E83_345680820;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1880090164 = varB4EAC82CA7396A68D541C85D26508E83_726719001;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1880090164.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1880090164;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.164 -0400", hash_original_method = "DACD676F99BB7BF8CCFB6D2A7B9FDEF9", hash_generated_method = "F7E48F31C71681C9CC35FE3B2B993699")
    public boolean performAccessibilityAction(int connectionId, int accessibilityWindowId,
            int accessibilityViewId, int action) {
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
                    boolean var0B4F88CEC11C94715435D9E907451D2F_1801053848 = (getPerformAccessibilityActionResult(interactionId));
                } //End block
            } //End block
        } //End block
        catch (RemoteException re)
        { }
        addTaint(connectionId);
        addTaint(accessibilityWindowId);
        addTaint(accessibilityViewId);
        addTaint(action);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1734935074 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1734935074;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.256 -0400", hash_original_method = "6C285733A381BDAF8984CA8B204B1B7E", hash_generated_method = "BA7C6EA458D7A261A7319560F601F230")
    private AccessibilityNodeInfo getFindAccessibilityNodeInfoResultAndClear(int interactionId) {
        AccessibilityNodeInfo varB4EAC82CA7396A68D541C85D26508E83_850057321 = null; //Variable for return #1
        {
            boolean success;
            success = waitForResultTimedLocked(interactionId);
            AccessibilityNodeInfo result;
            result = mFindAccessibilityNodeInfoResult;
            result = null;
            clearResultLocked();
            varB4EAC82CA7396A68D541C85D26508E83_850057321 = result;
        } //End block
        addTaint(interactionId);
        varB4EAC82CA7396A68D541C85D26508E83_850057321.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_850057321;
        // ---------- Original Method ----------
        //synchronized (mInstanceLock) {
            //final boolean success = waitForResultTimedLocked(interactionId);
            //AccessibilityNodeInfo result = success ? mFindAccessibilityNodeInfoResult : null;
            //clearResultLocked();
            //return result;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.257 -0400", hash_original_method = "5773A7995D438CAC0AFDE10E46EB704D", hash_generated_method = "7D88DD0C18519375C345C5B3681ED9CE")
    public void setFindAccessibilityNodeInfoResult(AccessibilityNodeInfo info,
                int interactionId) {
        {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.257 -0400", hash_original_method = "12169805BC03BC63B5C90B56149C0703", hash_generated_method = "EE068F21FA2664E4A13A21F65C6D1B5E")
    private List<AccessibilityNodeInfo> getFindAccessibilityNodeInfosResultAndClear(
                int interactionId) {
        List<AccessibilityNodeInfo> varB4EAC82CA7396A68D541C85D26508E83_680209807 = null; //Variable for return #1
        {
            boolean success;
            success = waitForResultTimedLocked(interactionId);
            List<AccessibilityNodeInfo> result;
            result = mFindAccessibilityNodeInfosResult;
            result = null;
            clearResultLocked();
            varB4EAC82CA7396A68D541C85D26508E83_680209807 = result;
        } //End block
        addTaint(interactionId);
        varB4EAC82CA7396A68D541C85D26508E83_680209807.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_680209807;
        // ---------- Original Method ----------
        //synchronized (mInstanceLock) {
            //final boolean success = waitForResultTimedLocked(interactionId);
            //List<AccessibilityNodeInfo> result = success ? mFindAccessibilityNodeInfosResult : null;
            //clearResultLocked();
            //return result;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.258 -0400", hash_original_method = "6CF51605A938A0D2B20285F05873A357", hash_generated_method = "EB5CF6DD53BC22797B9F61EB7E4EA39F")
    public void setFindAccessibilityNodeInfosResult(List<AccessibilityNodeInfo> infos,
                int interactionId) {
        {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.258 -0400", hash_original_method = "785F868CD3C42AFCCB7588732B0BC5FA", hash_generated_method = "EF10D0FAC9FA11877B51356F7ED25B3C")
    private boolean getPerformAccessibilityActionResult(int interactionId) {
        {
            boolean success;
            success = waitForResultTimedLocked(interactionId);
            boolean result;
            result = mPerformAccessibilityActionResult;
            result = false;
            clearResultLocked();
        } //End block
        addTaint(interactionId);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1296942013 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1296942013;
        // ---------- Original Method ----------
        //synchronized (mInstanceLock) {
            //final boolean success = waitForResultTimedLocked(interactionId);
            //final boolean result = success ? mPerformAccessibilityActionResult : false;
            //clearResultLocked();
            //return result;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.258 -0400", hash_original_method = "F5BCF8753FEED883A431A33F4CB0BF32", hash_generated_method = "F4A1E7135DB8778B392ED64157765892")
    public void setPerformAccessibilityActionResult(boolean succeeded, int interactionId) {
        {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.259 -0400", hash_original_method = "903092ED2C38BF649D61CAF92AAF4DF4", hash_generated_method = "B091948D31507164528E2CB3A01B1509")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.259 -0400", hash_original_method = "28474D5684D129A1738A9E8F91D9820E", hash_generated_method = "ADF755735C6B50878E960DE067F7D7F7")
    private boolean waitForResultTimedLocked(int interactionId) {
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
        addTaint(interactionId);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1858190293 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1858190293;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.260 -0400", hash_original_method = "061B568C08B51F012B887F4F0E2A3802", hash_generated_method = "3BD9B333F009D988DDCBCDEFDC7B1D4A")
    private void applyCompatibilityScaleIfNeeded(AccessibilityNodeInfo info, float scale) {
        Rect bounds;
        bounds = mTempBounds;
        info.getBoundsInParent(bounds);
        bounds.scale(scale);
        info.setBoundsInParent(bounds);
        info.getBoundsInScreen(bounds);
        bounds.scale(scale);
        info.setBoundsInScreen(bounds);
        addTaint(info.getTaint());
        addTaint(scale);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.260 -0400", hash_original_method = "50C3A05545C97DCA046561890361C747", hash_generated_method = "42B0AA647E9E9910B1053F128E796CF5")
    private void finalizeAccessibilityNodeInfo(AccessibilityNodeInfo info, int connectionId,
            float windowScale) {
        {
            applyCompatibilityScaleIfNeeded(info, windowScale);
            info.setConnectionId(connectionId);
            info.setSealed(true);
        } //End block
        addTaint(info.getTaint());
        addTaint(connectionId);
        addTaint(windowScale);
        // ---------- Original Method ----------
        //if (info != null) {
            //applyCompatibilityScaleIfNeeded(info, windowScale);
            //info.setConnectionId(connectionId);
            //info.setSealed(true);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.260 -0400", hash_original_method = "C4CCA9503A1FCF65E2280A82ABED87CD", hash_generated_method = "277E86815A876A8BF01C0C4100F3197C")
    private void finalizeAccessibilityNodeInfos(List<AccessibilityNodeInfo> infos,
            int connectionId, float windowScale) {
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
        addTaint(infos.getTaint());
        addTaint(connectionId);
        addTaint(windowScale);
        // ---------- Original Method ----------
        //if (infos != null) {
            //final int infosCount = infos.size();
            //for (int i = 0; i < infosCount; i++) {
                //AccessibilityNodeInfo info = infos.get(i);
                //finalizeAccessibilityNodeInfo(info, connectionId, windowScale);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.289 -0400", hash_original_method = "44FB956257430D3824804A6F98AEDC24", hash_generated_method = "4D4880E46BB3B3B845F01956EF151B86")
    private Message getSameProcessMessageAndClear() {
        Message varB4EAC82CA7396A68D541C85D26508E83_847928344 = null; //Variable for return #1
        {
            Message result;
            result = mSameThreadMessage;
            mSameThreadMessage = null;
            varB4EAC82CA7396A68D541C85D26508E83_847928344 = result;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_847928344.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_847928344;
        // ---------- Original Method ----------
        //synchronized (mInstanceLock) {
            //Message result = mSameThreadMessage;
            //mSameThreadMessage = null;
            //return result;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.290 -0400", hash_original_method = "C30C93509C0684283448214BFA9D8225", hash_generated_method = "E512B9520170F19900419B4389A7B60C")
    public IAccessibilityServiceConnection getConnection(int connectionId) {
        IAccessibilityServiceConnection varB4EAC82CA7396A68D541C85D26508E83_1738784121 = null; //Variable for return #1
        {
            varB4EAC82CA7396A68D541C85D26508E83_1738784121 = sConnectionCache.get(connectionId);
        } //End block
        addTaint(connectionId);
        varB4EAC82CA7396A68D541C85D26508E83_1738784121.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1738784121;
        // ---------- Original Method ----------
        //synchronized (sConnectionCache) {
            //return sConnectionCache.get(connectionId);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.290 -0400", hash_original_method = "7A0506F80A0A925F6D871EC270864AAB", hash_generated_method = "EE2601DB4B7EF65F1305E2220836CCD2")
    public void addConnection(int connectionId, IAccessibilityServiceConnection connection) {
        {
            sConnectionCache.put(connectionId, connection);
        } //End block
        addTaint(connectionId);
        addTaint(connection.getTaint());
        // ---------- Original Method ----------
        //synchronized (sConnectionCache) {
            //sConnectionCache.put(connectionId, connection);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.290 -0400", hash_original_method = "A8D0295941AD6316CEC94ABF823C5DD4", hash_generated_method = "9A7D88102F007A72F10CC21D04678DBC")
    public void removeConnection(int connectionId) {
        {
            sConnectionCache.remove(connectionId);
        } //End block
        addTaint(connectionId);
        // ---------- Original Method ----------
        //synchronized (sConnectionCache) {
            //sConnectionCache.remove(connectionId);
        //}
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.290 -0400", hash_original_field = "88123DE8DF5143F6086D0A4BB7B00CB8", hash_generated_field = "181E1190C48C3A15B723E1972525FFE6")

    public static final int NO_ID = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.291 -0400", hash_original_field = "0C7D9D7FBEAD804B937B1F8909595D53", hash_generated_field = "285B2A013EB922A8D15438C6B4F8EF20")

    private static String LOG_TAG = "AccessibilityInteractionClient";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.291 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "E83DF1E2E661A92B1AFDA8C473D190B2")

    private static boolean DEBUG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.291 -0400", hash_original_field = "B73554B3F2697BD58E344FA09EC215CB", hash_generated_field = "3D690D8D420CBD40A1E6C154373F837F")

    private static long TIMEOUT_INTERACTION_MILLIS = 5000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.291 -0400", hash_original_field = "6F01FC6BDB2E7BC12F6360B41E8B2316", hash_generated_field = "B2F80621A6DDB41CF5B09DFD74B499E3")

    private static Object sStaticLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.291 -0400", hash_original_field = "06E23A628CBDEAB09E91C69789BB1974", hash_generated_field = "429338DE764BD4ACB4DB8F09D348E465")

    private static AccessibilityInteractionClient sInstance;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.291 -0400", hash_original_field = "68D2F562B014FB326649FCB552B92CED", hash_generated_field = "12C67B014169865A5B43254D6BA779FB")

    private static SparseArray<IAccessibilityServiceConnection> sConnectionCache = new SparseArray<IAccessibilityServiceConnection>();
}

