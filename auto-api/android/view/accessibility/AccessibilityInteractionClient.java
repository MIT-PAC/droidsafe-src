package android.view.accessibility;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.129 -0400", hash_original_field = "876C08859ADD60468823CCE8896C3049", hash_generated_field = "1B453B20F0C1F3432E8CE879D519121D")

    private final AtomicInteger mInteractionIdCounter = new AtomicInteger();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.129 -0400", hash_original_field = "4C000E064E4AAC53A002F734A3803AFE", hash_generated_field = "6392F8242B4A9D3DC6E2F079ACDCEA46")

    private final Object mInstanceLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.129 -0400", hash_original_field = "78E57951C775A50B7436255FDA3E2F00", hash_generated_field = "AE60776173DBC048CFBFFABBE4C7746A")

    private int mInteractionId = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.129 -0400", hash_original_field = "DBF170501ED14C76D94C024620EC0964", hash_generated_field = "A3D55D5A4D331347A5DC8437AFB890DE")

    private AccessibilityNodeInfo mFindAccessibilityNodeInfoResult;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.129 -0400", hash_original_field = "5A690144232F2C09A7728A08EE36623B", hash_generated_field = "3DCE295151A485FE086C2499765CB1E4")

    private List<AccessibilityNodeInfo> mFindAccessibilityNodeInfosResult;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.129 -0400", hash_original_field = "42B25754C595D6B826CDE88BF14D76C4", hash_generated_field = "1D4D87B32D7664CC278418585538879B")

    private boolean mPerformAccessibilityActionResult;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.129 -0400", hash_original_field = "DF57E2FC1D1BA984093D649925AA80CB", hash_generated_field = "F8EC948A5A458F05C0667906EB13AD52")

    private Message mSameThreadMessage;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.129 -0400", hash_original_field = "E3FB88F1170F920ECFA15D83AA99D025", hash_generated_field = "9DBB084DD0568D939B76BF72796B166A")

    private final Rect mTempBounds = new Rect();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.129 -0400", hash_original_method = "974B96BB2B096535DAB8082291151E7A", hash_generated_method = "974B96BB2B096535DAB8082291151E7A")
    public AccessibilityInteractionClient ()
    {
        
    }


    @DSModeled(DSC.SAFE)
    public static AccessibilityInteractionClient getInstance() {
        synchronized (sStaticLock) {
            if (sInstance == null) {
                sInstance = new AccessibilityInteractionClient();
            }
            return sInstance;
        }
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.130 -0400", hash_original_method = "552BFB14766A8DC73E6AAA7040599DCF", hash_generated_method = "579E0A715D3754EF98AD6ACB21E52591")
    public void setSameThreadMessage(Message message) {
        {
            mSameThreadMessage = message;
            mInstanceLock.notifyAll();
        } 
        
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.131 -0400", hash_original_method = "5C41BEE5A47D8A94E160F887E5B51CE0", hash_generated_method = "1AC03663B1F5B548328E095C38E7CF51")
    public AccessibilityNodeInfo findAccessibilityNodeInfoByAccessibilityId(int connectionId,
            int accessibilityWindowId, int accessibilityViewId) {
        AccessibilityNodeInfo varB4EAC82CA7396A68D541C85D26508E83_1312466029 = null; 
        AccessibilityNodeInfo varB4EAC82CA7396A68D541C85D26508E83_2118455996 = null; 
        try 
        {
            IAccessibilityServiceConnection connection = getConnection(connectionId);
            {
                final int interactionId = mInteractionIdCounter.getAndIncrement();
                final float windowScale = connection.findAccessibilityNodeInfoByAccessibilityId(
                        accessibilityWindowId, accessibilityViewId, interactionId, this,
                        Thread.currentThread().getId());
                {
                    AccessibilityNodeInfo info = getFindAccessibilityNodeInfoResultAndClear(
                            interactionId);
                    finalizeAccessibilityNodeInfo(info, connectionId, windowScale);
                    varB4EAC82CA7396A68D541C85D26508E83_1312466029 = info;
                } 
            } 
        } 
        catch (RemoteException re)
        { }
        varB4EAC82CA7396A68D541C85D26508E83_2118455996 = null;
        addTaint(connectionId);
        addTaint(accessibilityWindowId);
        addTaint(accessibilityViewId);
        AccessibilityNodeInfo varA7E53CE21691AB073D9660D615818899_688292156; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_688292156 = varB4EAC82CA7396A68D541C85D26508E83_1312466029;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_688292156 = varB4EAC82CA7396A68D541C85D26508E83_2118455996;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_688292156.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_688292156;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.132 -0400", hash_original_method = "60BBE77BB0E3F47D3C9CB3C547527867", hash_generated_method = "A949CFBDC7E6519BFA4624A389D8DACB")
    public AccessibilityNodeInfo findAccessibilityNodeInfoByViewIdInActiveWindow(int connectionId,
            int viewId) {
        AccessibilityNodeInfo varB4EAC82CA7396A68D541C85D26508E83_827497508 = null; 
        AccessibilityNodeInfo varB4EAC82CA7396A68D541C85D26508E83_550690510 = null; 
        try 
        {
            IAccessibilityServiceConnection connection = getConnection(connectionId);
            {
                final int interactionId = mInteractionIdCounter.getAndIncrement();
                final float windowScale = connection.findAccessibilityNodeInfoByViewIdInActiveWindow(viewId,
                            interactionId, this, Thread.currentThread().getId());
                {
                    AccessibilityNodeInfo info = getFindAccessibilityNodeInfoResultAndClear(
                            interactionId);
                    finalizeAccessibilityNodeInfo(info, connectionId, windowScale);
                    varB4EAC82CA7396A68D541C85D26508E83_827497508 = info;
                } 
            } 
        } 
        catch (RemoteException re)
        { }
        varB4EAC82CA7396A68D541C85D26508E83_550690510 = null;
        addTaint(connectionId);
        addTaint(viewId);
        AccessibilityNodeInfo varA7E53CE21691AB073D9660D615818899_977249372; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_977249372 = varB4EAC82CA7396A68D541C85D26508E83_827497508;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_977249372 = varB4EAC82CA7396A68D541C85D26508E83_550690510;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_977249372.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_977249372;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.133 -0400", hash_original_method = "672E254807B5370E478DCC44723B0294", hash_generated_method = "74DBE76536778A0517A1AB6218AF7D90")
    public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByViewTextInActiveWindow(
            int connectionId, String text) {
        List<AccessibilityNodeInfo> varB4EAC82CA7396A68D541C85D26508E83_2123033821 = null; 
        List<AccessibilityNodeInfo> varB4EAC82CA7396A68D541C85D26508E83_1072408732 = null; 
        try 
        {
            IAccessibilityServiceConnection connection = getConnection(connectionId);
            {
                final int interactionId = mInteractionIdCounter.getAndIncrement();
                final float windowScale = connection.findAccessibilityNodeInfosByViewTextInActiveWindow(text,
                            interactionId, this, Thread.currentThread().getId());
                {
                    List<AccessibilityNodeInfo> infos = getFindAccessibilityNodeInfosResultAndClear(
                            interactionId);
                    finalizeAccessibilityNodeInfos(infos, connectionId, windowScale);
                    varB4EAC82CA7396A68D541C85D26508E83_2123033821 = infos;
                } 
            } 
        } 
        catch (RemoteException re)
        { }
        varB4EAC82CA7396A68D541C85D26508E83_1072408732 = null;
        addTaint(connectionId);
        addTaint(text.getTaint());
        List<AccessibilityNodeInfo> varA7E53CE21691AB073D9660D615818899_494164132; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_494164132 = varB4EAC82CA7396A68D541C85D26508E83_2123033821;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_494164132 = varB4EAC82CA7396A68D541C85D26508E83_1072408732;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_494164132.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_494164132;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.148 -0400", hash_original_method = "AC3652D7BF4240B02C1C5545B023526D", hash_generated_method = "930E8210516DF6639B195D177D93A906")
    public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByViewText(int connectionId,
            String text, int accessibilityWindowId, int accessibilityViewId) {
        List<AccessibilityNodeInfo> varB4EAC82CA7396A68D541C85D26508E83_2046210820 = null; 
        List<AccessibilityNodeInfo> varB4EAC82CA7396A68D541C85D26508E83_2094127105 = null; 
        try 
        {
            IAccessibilityServiceConnection connection = getConnection(connectionId);
            {
                final int interactionId = mInteractionIdCounter.getAndIncrement();
                final float windowScale = connection.findAccessibilityNodeInfosByViewText(text,
                        accessibilityWindowId, accessibilityViewId, interactionId, this,
                        Thread.currentThread().getId());
                {
                    List<AccessibilityNodeInfo> infos = getFindAccessibilityNodeInfosResultAndClear(
                            interactionId);
                    finalizeAccessibilityNodeInfos(infos, connectionId, windowScale);
                    varB4EAC82CA7396A68D541C85D26508E83_2046210820 = infos;
                } 
            } 
        } 
        catch (RemoteException re)
        { }
        varB4EAC82CA7396A68D541C85D26508E83_2094127105 = Collections.emptyList();
        addTaint(connectionId);
        addTaint(text.getTaint());
        addTaint(accessibilityWindowId);
        addTaint(accessibilityViewId);
        List<AccessibilityNodeInfo> varA7E53CE21691AB073D9660D615818899_1523654327; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1523654327 = varB4EAC82CA7396A68D541C85D26508E83_2046210820;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1523654327 = varB4EAC82CA7396A68D541C85D26508E83_2094127105;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1523654327.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1523654327;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.149 -0400", hash_original_method = "DACD676F99BB7BF8CCFB6D2A7B9FDEF9", hash_generated_method = "D6A864A3200A9C3CD288D18D5AF4A0E4")
    public boolean performAccessibilityAction(int connectionId, int accessibilityWindowId,
            int accessibilityViewId, int action) {
        try 
        {
            IAccessibilityServiceConnection connection = getConnection(connectionId);
            {
                final int interactionId = mInteractionIdCounter.getAndIncrement();
                final boolean success = connection.performAccessibilityAction(
                        accessibilityWindowId, accessibilityViewId, action, interactionId, this,
                        Thread.currentThread().getId());
                {
                    boolean var0B4F88CEC11C94715435D9E907451D2F_1485229699 = (getPerformAccessibilityActionResult(interactionId));
                } 
            } 
        } 
        catch (RemoteException re)
        { }
        addTaint(connectionId);
        addTaint(accessibilityWindowId);
        addTaint(accessibilityViewId);
        addTaint(action);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_783813223 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_783813223;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.149 -0400", hash_original_method = "6C285733A381BDAF8984CA8B204B1B7E", hash_generated_method = "CEF9832A39D5F4098B8EDC723858C22C")
    private AccessibilityNodeInfo getFindAccessibilityNodeInfoResultAndClear(int interactionId) {
        AccessibilityNodeInfo varB4EAC82CA7396A68D541C85D26508E83_1599156665 = null; 
        {
            final boolean success = waitForResultTimedLocked(interactionId);
            AccessibilityNodeInfo result;
            result = mFindAccessibilityNodeInfoResult;
            result = null;
            clearResultLocked();
            varB4EAC82CA7396A68D541C85D26508E83_1599156665 = result;
        } 
        addTaint(interactionId);
        varB4EAC82CA7396A68D541C85D26508E83_1599156665.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1599156665;
        
        
            
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.150 -0400", hash_original_method = "5773A7995D438CAC0AFDE10E46EB704D", hash_generated_method = "7D88DD0C18519375C345C5B3681ED9CE")
    public void setFindAccessibilityNodeInfoResult(AccessibilityNodeInfo info,
                int interactionId) {
        {
            {
                mFindAccessibilityNodeInfoResult = info;
                mInteractionId = interactionId;
            } 
            mInstanceLock.notifyAll();
        } 
        
        
            
                
                
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.151 -0400", hash_original_method = "12169805BC03BC63B5C90B56149C0703", hash_generated_method = "D29E4842214BF6BC7B9C43199977E08B")
    private List<AccessibilityNodeInfo> getFindAccessibilityNodeInfosResultAndClear(
                int interactionId) {
        List<AccessibilityNodeInfo> varB4EAC82CA7396A68D541C85D26508E83_1999239593 = null; 
        {
            final boolean success = waitForResultTimedLocked(interactionId);
            List<AccessibilityNodeInfo> result;
            result = mFindAccessibilityNodeInfosResult;
            result = null;
            clearResultLocked();
            varB4EAC82CA7396A68D541C85D26508E83_1999239593 = result;
        } 
        addTaint(interactionId);
        varB4EAC82CA7396A68D541C85D26508E83_1999239593.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1999239593;
        
        
            
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.151 -0400", hash_original_method = "6CF51605A938A0D2B20285F05873A357", hash_generated_method = "EB5CF6DD53BC22797B9F61EB7E4EA39F")
    public void setFindAccessibilityNodeInfosResult(List<AccessibilityNodeInfo> infos,
                int interactionId) {
        {
            {
                mFindAccessibilityNodeInfosResult = infos;
                mInteractionId = interactionId;
            } 
            mInstanceLock.notifyAll();
        } 
        
        
            
                
                
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.152 -0400", hash_original_method = "785F868CD3C42AFCCB7588732B0BC5FA", hash_generated_method = "8BA5F3D04A3654EC9AB553DDAA924B4B")
    private boolean getPerformAccessibilityActionResult(int interactionId) {
        {
            final boolean success = waitForResultTimedLocked(interactionId);
            boolean result;
            result = mPerformAccessibilityActionResult;
            result = false;
            clearResultLocked();
        } 
        addTaint(interactionId);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1764203938 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1764203938;
        
        
            
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.152 -0400", hash_original_method = "F5BCF8753FEED883A431A33F4CB0BF32", hash_generated_method = "F4A1E7135DB8778B392ED64157765892")
    public void setPerformAccessibilityActionResult(boolean succeeded, int interactionId) {
        {
            {
                mPerformAccessibilityActionResult = succeeded;
                mInteractionId = interactionId;
            } 
            mInstanceLock.notifyAll();
        } 
        
        
            
                
                
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.153 -0400", hash_original_method = "903092ED2C38BF649D61CAF92AAF4DF4", hash_generated_method = "B091948D31507164528E2CB3A01B1509")
    private void clearResultLocked() {
        mInteractionId = -1;
        mFindAccessibilityNodeInfoResult = null;
        mFindAccessibilityNodeInfosResult = null;
        mPerformAccessibilityActionResult = false;
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.153 -0400", hash_original_method = "28474D5684D129A1738A9E8F91D9820E", hash_generated_method = "D917477D177AECEDA186ADFB34B2DD5C")
    private boolean waitForResultTimedLocked(int interactionId) {
        long waitTimeMillis = TIMEOUT_INTERACTION_MILLIS;
        final long startTimeMillis = SystemClock.uptimeMillis();
        {
            try 
            {
                Message sameProcessMessage = getSameProcessMessageAndClear();
                {
                    sameProcessMessage.getTarget().handleMessage(sameProcessMessage);
                } 
                final long elapsedTimeMillis = SystemClock.uptimeMillis() - startTimeMillis;
                waitTimeMillis = TIMEOUT_INTERACTION_MILLIS - elapsedTimeMillis;
                mInstanceLock.wait(waitTimeMillis);
            } 
            catch (InterruptedException ie)
            { }
        } 
        addTaint(interactionId);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1024312736 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1024312736;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.153 -0400", hash_original_method = "061B568C08B51F012B887F4F0E2A3802", hash_generated_method = "6CCB93AF644FDAF60E2A0B146A2EE1AE")
    private void applyCompatibilityScaleIfNeeded(AccessibilityNodeInfo info, float scale) {
        Rect bounds = mTempBounds;
        info.getBoundsInParent(bounds);
        bounds.scale(scale);
        info.setBoundsInParent(bounds);
        info.getBoundsInScreen(bounds);
        bounds.scale(scale);
        info.setBoundsInScreen(bounds);
        addTaint(info.getTaint());
        addTaint(scale);
        
        
            
        
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.154 -0400", hash_original_method = "50C3A05545C97DCA046561890361C747", hash_generated_method = "42B0AA647E9E9910B1053F128E796CF5")
    private void finalizeAccessibilityNodeInfo(AccessibilityNodeInfo info, int connectionId,
            float windowScale) {
        {
            applyCompatibilityScaleIfNeeded(info, windowScale);
            info.setConnectionId(connectionId);
            info.setSealed(true);
        } 
        addTaint(info.getTaint());
        addTaint(connectionId);
        addTaint(windowScale);
        
        
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.154 -0400", hash_original_method = "C4CCA9503A1FCF65E2280A82ABED87CD", hash_generated_method = "390F0D0802203B92004071ABBD6C955E")
    private void finalizeAccessibilityNodeInfos(List<AccessibilityNodeInfo> infos,
            int connectionId, float windowScale) {
        {
            final int infosCount = infos.size();
            {
                int i = 0;
                {
                    AccessibilityNodeInfo info = infos.get(i);
                    finalizeAccessibilityNodeInfo(info, connectionId, windowScale);
                } 
            } 
        } 
        addTaint(infos.getTaint());
        addTaint(connectionId);
        addTaint(windowScale);
        
        
            
            
                
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.155 -0400", hash_original_method = "44FB956257430D3824804A6F98AEDC24", hash_generated_method = "CF385794A6FEBBED71EA0FE4482B850C")
    private Message getSameProcessMessageAndClear() {
        Message varB4EAC82CA7396A68D541C85D26508E83_889402407 = null; 
        {
            Message result = mSameThreadMessage;
            mSameThreadMessage = null;
            varB4EAC82CA7396A68D541C85D26508E83_889402407 = result;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_889402407.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_889402407;
        
        
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.156 -0400", hash_original_method = "C30C93509C0684283448214BFA9D8225", hash_generated_method = "F2BE9BAF69290D00591B528C905296A8")
    public IAccessibilityServiceConnection getConnection(int connectionId) {
        IAccessibilityServiceConnection varB4EAC82CA7396A68D541C85D26508E83_1533053702 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1533053702 = sConnectionCache.get(connectionId);
        } 
        addTaint(connectionId);
        varB4EAC82CA7396A68D541C85D26508E83_1533053702.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1533053702;
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.156 -0400", hash_original_method = "7A0506F80A0A925F6D871EC270864AAB", hash_generated_method = "EE2601DB4B7EF65F1305E2220836CCD2")
    public void addConnection(int connectionId, IAccessibilityServiceConnection connection) {
        {
            sConnectionCache.put(connectionId, connection);
        } 
        addTaint(connectionId);
        addTaint(connection.getTaint());
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.157 -0400", hash_original_method = "A8D0295941AD6316CEC94ABF823C5DD4", hash_generated_method = "9A7D88102F007A72F10CC21D04678DBC")
    public void removeConnection(int connectionId) {
        {
            sConnectionCache.remove(connectionId);
        } 
        addTaint(connectionId);
        
        
            
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.157 -0400", hash_original_field = "88123DE8DF5143F6086D0A4BB7B00CB8", hash_generated_field = "181E1190C48C3A15B723E1972525FFE6")

    public static final int NO_ID = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.157 -0400", hash_original_field = "0C7D9D7FBEAD804B937B1F8909595D53", hash_generated_field = "F39970B10B2A1B6AAAA3BAA95BD6C833")

    private static final String LOG_TAG = "AccessibilityInteractionClient";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.157 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "58EDF43BA541A4D47EECFEC3901C7AED")

    private static final boolean DEBUG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.157 -0400", hash_original_field = "B73554B3F2697BD58E344FA09EC215CB", hash_generated_field = "879CDE422299A8456AD3253132795354")

    private static final long TIMEOUT_INTERACTION_MILLIS = 5000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.157 -0400", hash_original_field = "6F01FC6BDB2E7BC12F6360B41E8B2316", hash_generated_field = "498BA8A796A917C092E570F2E37A3E7B")

    private static final Object sStaticLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.157 -0400", hash_original_field = "06E23A628CBDEAB09E91C69789BB1974", hash_generated_field = "429338DE764BD4ACB4DB8F09D348E465")

    private static AccessibilityInteractionClient sInstance;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:01.157 -0400", hash_original_field = "68D2F562B014FB326649FCB552B92CED", hash_generated_field = "82A9D097CD8F5394610FEB7829547E07")

    private static final SparseArray<IAccessibilityServiceConnection> sConnectionCache = new SparseArray<IAccessibilityServiceConnection>();
}

