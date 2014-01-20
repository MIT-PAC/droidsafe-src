package android.view.accessibility;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import android.accessibilityservice.IAccessibilityServiceConnection;
import android.graphics.Rect;
import android.os.Message;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.SparseArray;

public final class AccessibilityInteractionClient extends IAccessibilityInteractionConnectionCallback.Stub {

    /**
     * @return The singleton of this class.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:53.103 -0500", hash_original_method = "AC9C8E6AFA4BD19860E3B01D77CE7140", hash_generated_method = "0E252EFFE9F6AA2CE9503B245466CB85")
    
public static AccessibilityInteractionClient getInstance() {
        synchronized (sStaticLock) {
            if (sInstance == null) {
                sInstance = new AccessibilityInteractionClient();
            }
            return sInstance;
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:53.068 -0500", hash_original_field = "BEB3544BF456B23E5F1F5575F3E93334", hash_generated_field = "181E1190C48C3A15B723E1972525FFE6")

    public static final int NO_ID = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:53.071 -0500", hash_original_field = "1C7E3C83486F8FDC8ED0BBC3C543A3AF", hash_generated_field = "F39970B10B2A1B6AAAA3BAA95BD6C833")

    private static final String LOG_TAG = "AccessibilityInteractionClient";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:53.073 -0500", hash_original_field = "81DD852ECBE07BA98A61C8F3D0C85F01", hash_generated_field = "58EDF43BA541A4D47EECFEC3901C7AED")

    private static final boolean DEBUG = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:53.075 -0500", hash_original_field = "94B38A4B22D5809DB037D92DF56B9195", hash_generated_field = "879CDE422299A8456AD3253132795354")

    private static final long TIMEOUT_INTERACTION_MILLIS = 5000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:53.078 -0500", hash_original_field = "70A71BD16E05A887B72D59F04116381D", hash_generated_field = "498BA8A796A917C092E570F2E37A3E7B")

    private static final Object sStaticLock = new Object();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:53.080 -0500", hash_original_field = "A21380ABE40C483F2885923D119EE952", hash_generated_field = "429338DE764BD4ACB4DB8F09D348E465")

    private static AccessibilityInteractionClient sInstance;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:53.101 -0500", hash_original_field = "96BE1789EC19C804EF3574A35B59C987", hash_generated_field = "82A9D097CD8F5394610FEB7829547E07")

    private static final SparseArray<IAccessibilityServiceConnection> sConnectionCache =
        new SparseArray<IAccessibilityServiceConnection>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:53.083 -0500", hash_original_field = "D0C448D3D6C36E51CA704FA1F82BA03A", hash_generated_field = "1B453B20F0C1F3432E8CE879D519121D")

    private final AtomicInteger mInteractionIdCounter = new AtomicInteger();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:53.085 -0500", hash_original_field = "C1EC34416CA5919EC9DC169918854311", hash_generated_field = "6392F8242B4A9D3DC6E2F079ACDCEA46")

    private final Object mInstanceLock = new Object();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:53.087 -0500", hash_original_field = "6BA29085393712540B286281F44B67C6", hash_generated_field = "AE60776173DBC048CFBFFABBE4C7746A")

    private int mInteractionId = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:53.089 -0500", hash_original_field = "6542A5CB99BCCEB6F8596422F2884A9B", hash_generated_field = "A3D55D5A4D331347A5DC8437AFB890DE")

    private AccessibilityNodeInfo mFindAccessibilityNodeInfoResult;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:53.092 -0500", hash_original_field = "224394DD643E884C74EC7529304B0092", hash_generated_field = "3DCE295151A485FE086C2499765CB1E4")

    private List<AccessibilityNodeInfo> mFindAccessibilityNodeInfosResult;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:53.094 -0500", hash_original_field = "D54A5FBF491F128D5908B1902AE526F5", hash_generated_field = "1D4D87B32D7664CC278418585538879B")

    private boolean mPerformAccessibilityActionResult;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:53.096 -0500", hash_original_field = "9D92C6F514CC75ADEB1F6A052B886C92", hash_generated_field = "F8EC948A5A458F05C0667906EB13AD52")

    private Message mSameThreadMessage;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:53.098 -0500", hash_original_field = "18B323F06848CA309C3A1F305DBA0D21", hash_generated_field = "9DBB084DD0568D939B76BF72796B166A")

    private final Rect mTempBounds = new Rect();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.266 -0400", hash_original_method = "974B96BB2B096535DAB8082291151E7A", hash_generated_method = "974B96BB2B096535DAB8082291151E7A")
    public AccessibilityInteractionClient ()
    {
        //Synthesized constructor
    }

    /**
     * Sets the message to be processed if the interacted view hierarchy
     * and the interacting client are running in the same thread.
     *
     * @param message The message.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:53.106 -0500", hash_original_method = "552BFB14766A8DC73E6AAA7040599DCF", hash_generated_method = "B6C1CD57624A12EFB4DF719E9F2216C4")
    
public void setSameThreadMessage(Message message) {
        synchronized (mInstanceLock) {
            mSameThreadMessage = message;
            mInstanceLock.notifyAll();
        }
    }

    /**
     * Finds an {@link AccessibilityNodeInfo} by accessibility id.
     *
     * @param connectionId The id of a connection for interacting with the system.
     * @param accessibilityWindowId A unique window id.
     * @param accessibilityViewId A unique View accessibility id.
     * @return An {@link AccessibilityNodeInfo} if found, null otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:53.109 -0500", hash_original_method = "5C41BEE5A47D8A94E160F887E5B51CE0", hash_generated_method = "B30561569566E1CF2A5F6FBAFAF5A89B")
    
public AccessibilityNodeInfo findAccessibilityNodeInfoByAccessibilityId(int connectionId,
            int accessibilityWindowId, int accessibilityViewId) {
        try {
            IAccessibilityServiceConnection connection = getConnection(connectionId);
            if (connection != null) {
                final int interactionId = mInteractionIdCounter.getAndIncrement();
                final float windowScale = connection.findAccessibilityNodeInfoByAccessibilityId(
                        accessibilityWindowId, accessibilityViewId, interactionId, this,
                        Thread.currentThread().getId());
                // If the scale is zero the call has failed.
                if (windowScale > 0) {
                    AccessibilityNodeInfo info = getFindAccessibilityNodeInfoResultAndClear(
                            interactionId);
                    finalizeAccessibilityNodeInfo(info, connectionId, windowScale);
                    return info;
                }
            } else {
                if (DEBUG) {
                    Log.w(LOG_TAG, "No connection for connection id: " + connectionId);
                }
            }
        } catch (RemoteException re) {
            if (DEBUG) {
                Log.w(LOG_TAG, "Error while calling remote"
                        + " findAccessibilityNodeInfoByAccessibilityId", re);
            }
        }
        return null;
    }

    /**
     * Finds an {@link AccessibilityNodeInfo} by View id. The search is performed
     * in the currently active window and starts from the root View in the window.
     *
     * @param connectionId The id of a connection for interacting with the system.
     * @param viewId The id of the view.
     * @return An {@link AccessibilityNodeInfo} if found, null otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:53.112 -0500", hash_original_method = "60BBE77BB0E3F47D3C9CB3C547527867", hash_generated_method = "C02AA20D307DEBD3DA7877C87D9FD98D")
    
public AccessibilityNodeInfo findAccessibilityNodeInfoByViewIdInActiveWindow(int connectionId,
            int viewId) {
        try {
            IAccessibilityServiceConnection connection = getConnection(connectionId);
            if (connection != null) {
                final int interactionId = mInteractionIdCounter.getAndIncrement();
                final float windowScale =
                    connection.findAccessibilityNodeInfoByViewIdInActiveWindow(viewId,
                            interactionId, this, Thread.currentThread().getId());
                // If the scale is zero the call has failed.
                if (windowScale > 0) {
                    AccessibilityNodeInfo info = getFindAccessibilityNodeInfoResultAndClear(
                            interactionId);
                    finalizeAccessibilityNodeInfo(info, connectionId, windowScale);
                    return info;
                }
            } else {
                if (DEBUG) {
                    Log.w(LOG_TAG, "No connection for connection id: " + connectionId);
                }
            }
        } catch (RemoteException re) {
            if (DEBUG) {
                Log.w(LOG_TAG, "Error while calling remote"
                        + " findAccessibilityNodeInfoByViewIdInActiveWindow", re);
            }
        }
        return null;
    }

    /**
     * Finds {@link AccessibilityNodeInfo}s by View text. The match is case
     * insensitive containment. The search is performed in the currently
     * active window and starts from the root View in the window.
     *
     * @param connectionId The id of a connection for interacting with the system.
     * @param text The searched text.
     * @return A list of found {@link AccessibilityNodeInfo}s.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:53.115 -0500", hash_original_method = "672E254807B5370E478DCC44723B0294", hash_generated_method = "5740C9A9133E3FBB4F1A3E33B580D45B")
    
public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByViewTextInActiveWindow(
            int connectionId, String text) {
        try {
            IAccessibilityServiceConnection connection = getConnection(connectionId);
            if (connection != null) {
                final int interactionId = mInteractionIdCounter.getAndIncrement();
                final float windowScale =
                    connection.findAccessibilityNodeInfosByViewTextInActiveWindow(text,
                            interactionId, this, Thread.currentThread().getId());
                // If the scale is zero the call has failed.
                if (windowScale > 0) {
                    List<AccessibilityNodeInfo> infos = getFindAccessibilityNodeInfosResultAndClear(
                            interactionId);
                    finalizeAccessibilityNodeInfos(infos, connectionId, windowScale);
                    return infos;
                }
            } else {
                if (DEBUG) {
                    Log.w(LOG_TAG, "No connection for connection id: " + connectionId);
                }
            }
        } catch (RemoteException re) {
            if (DEBUG) {
                Log.w(LOG_TAG, "Error while calling remote"
                        + " findAccessibilityNodeInfosByViewTextInActiveWindow", re);
            }
        }
        return null;
    }

    /**
     * Finds {@link AccessibilityNodeInfo}s by View text. The match is case
     * insensitive containment. The search is performed in the window whose
     * id is specified and starts from the View whose accessibility id is
     * specified.
     *
     * @param connectionId The id of a connection for interacting with the system.
     * @param text The searched text.
     * @param accessibilityWindowId A unique window id.
     * @param accessibilityViewId A unique View accessibility id from where to start the search.
     *        Use {@link android.view.View#NO_ID} to start from the root.
     * @return A list of found {@link AccessibilityNodeInfo}s.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:53.118 -0500", hash_original_method = "AC3652D7BF4240B02C1C5545B023526D", hash_generated_method = "9326C6D867E1D6861EBBC92522E29B8C")
    
public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByViewText(int connectionId,
            String text, int accessibilityWindowId, int accessibilityViewId) {
        try {
            IAccessibilityServiceConnection connection = getConnection(connectionId);
            if (connection != null) {
                final int interactionId = mInteractionIdCounter.getAndIncrement();
                final float windowScale = connection.findAccessibilityNodeInfosByViewText(text,
                        accessibilityWindowId, accessibilityViewId, interactionId, this,
                        Thread.currentThread().getId());
                // If the scale is zero the call has failed.
                if (windowScale > 0) {
                    List<AccessibilityNodeInfo> infos = getFindAccessibilityNodeInfosResultAndClear(
                            interactionId);
                    finalizeAccessibilityNodeInfos(infos, connectionId, windowScale);
                    return infos;
                }
            } else {
                if (DEBUG) {
                    Log.w(LOG_TAG, "No connection for connection id: " + connectionId);
                }
            }
        } catch (RemoteException re) {
            if (DEBUG) {
                Log.w(LOG_TAG, "Error while calling remote"
                        + " findAccessibilityNodeInfosByViewText", re);
            }
        }
        return Collections.emptyList();
    }

    /**
     * Performs an accessibility action on an {@link AccessibilityNodeInfo}.
     *
     * @param connectionId The id of a connection for interacting with the system.
     * @param accessibilityWindowId The id of the window.
     * @param accessibilityViewId A unique View accessibility id.
     * @param action The action to perform.
     * @return Whether the action was performed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:53.121 -0500", hash_original_method = "DACD676F99BB7BF8CCFB6D2A7B9FDEF9", hash_generated_method = "22240DD78BC9A0D53B92DFDFE7C25C32")
    
public boolean performAccessibilityAction(int connectionId, int accessibilityWindowId,
            int accessibilityViewId, int action) {
        try {
            IAccessibilityServiceConnection connection = getConnection(connectionId);
            if (connection != null) {
                final int interactionId = mInteractionIdCounter.getAndIncrement();
                final boolean success = connection.performAccessibilityAction(
                        accessibilityWindowId, accessibilityViewId, action, interactionId, this,
                        Thread.currentThread().getId());
                if (success) {
                    return getPerformAccessibilityActionResult(interactionId);
                }
            } else {
                if (DEBUG) {
                    Log.w(LOG_TAG, "No connection for connection id: " + connectionId);
                }
            }
        } catch (RemoteException re) {
            if (DEBUG) {
                Log.w(LOG_TAG, "Error while calling remote performAccessibilityAction", re);
            }
        }
        return false;
    }

    /**
     * Gets the the result of an async request that returns an {@link AccessibilityNodeInfo}.
     *
     * @param interactionId The interaction id to match the result with the request.
     * @return The result {@link AccessibilityNodeInfo}.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:53.123 -0500", hash_original_method = "6C285733A381BDAF8984CA8B204B1B7E", hash_generated_method = "88D28EF136C98713E1E9610B4D92960E")
    
private AccessibilityNodeInfo getFindAccessibilityNodeInfoResultAndClear(int interactionId) {
        synchronized (mInstanceLock) {
            final boolean success = waitForResultTimedLocked(interactionId);
            AccessibilityNodeInfo result = success ? mFindAccessibilityNodeInfoResult : null;
            clearResultLocked();
            return result;
        }
    }

    /**
     * {@inheritDoc}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:53.126 -0500", hash_original_method = "5773A7995D438CAC0AFDE10E46EB704D", hash_generated_method = "FE888E3F0AED47C00785B3FAACA3BA33")
    
public void setFindAccessibilityNodeInfoResult(AccessibilityNodeInfo info,
                int interactionId) {
        synchronized (mInstanceLock) {
            if (interactionId > mInteractionId) {
                mFindAccessibilityNodeInfoResult = info;
                mInteractionId = interactionId;
            }
            mInstanceLock.notifyAll();
        }
    }

    /**
     * Gets the the result of an async request that returns {@link AccessibilityNodeInfo}s.
     *
     * @param interactionId The interaction id to match the result with the request.
     * @return The result {@link AccessibilityNodeInfo}s.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:53.128 -0500", hash_original_method = "12169805BC03BC63B5C90B56149C0703", hash_generated_method = "A490CAE54EA8F73489F4028FE7ED9F64")
    
private List<AccessibilityNodeInfo> getFindAccessibilityNodeInfosResultAndClear(
                int interactionId) {
        synchronized (mInstanceLock) {
            final boolean success = waitForResultTimedLocked(interactionId);
            List<AccessibilityNodeInfo> result = success ? mFindAccessibilityNodeInfosResult : null;
            clearResultLocked();
            return result;
        }
    }

    /**
     * {@inheritDoc}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:53.130 -0500", hash_original_method = "6CF51605A938A0D2B20285F05873A357", hash_generated_method = "39E180AACF07E274C9BAC7AD0CA018C1")
    
public void setFindAccessibilityNodeInfosResult(List<AccessibilityNodeInfo> infos,
                int interactionId) {
        synchronized (mInstanceLock) {
            if (interactionId > mInteractionId) {
                mFindAccessibilityNodeInfosResult = infos;
                mInteractionId = interactionId;
            }
            mInstanceLock.notifyAll();
        }
    }

    /**
     * Gets the result of a request to perform an accessibility action.
     *
     * @param interactionId The interaction id to match the result with the request.
     * @return Whether the action was performed.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:53.133 -0500", hash_original_method = "785F868CD3C42AFCCB7588732B0BC5FA", hash_generated_method = "17EC7C71CC86126937E7396E38CB5DA5")
    
private boolean getPerformAccessibilityActionResult(int interactionId) {
        synchronized (mInstanceLock) {
            final boolean success = waitForResultTimedLocked(interactionId);
            final boolean result = success ? mPerformAccessibilityActionResult : false;
            clearResultLocked();
            return result;
        }
    }

    /**
     * {@inheritDoc}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:53.135 -0500", hash_original_method = "F5BCF8753FEED883A431A33F4CB0BF32", hash_generated_method = "97F7F9070EFA6C6E7279902C88810DD5")
    
public void setPerformAccessibilityActionResult(boolean succeeded, int interactionId) {
        synchronized (mInstanceLock) {
            if (interactionId > mInteractionId) {
                mPerformAccessibilityActionResult = succeeded;
                mInteractionId = interactionId;
            }
            mInstanceLock.notifyAll();
        }
    }

    /**
     * Clears the result state.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:53.137 -0500", hash_original_method = "903092ED2C38BF649D61CAF92AAF4DF4", hash_generated_method = "E3D7390DD5E7DC8155A8D23ED2BD1064")
    
private void clearResultLocked() {
        mInteractionId = -1;
        mFindAccessibilityNodeInfoResult = null;
        mFindAccessibilityNodeInfosResult = null;
        mPerformAccessibilityActionResult = false;
    }

    /**
     * Waits up to a given bound for a result of a request and returns it.
     *
     * @param interactionId The interaction id to match the result with the request.
     * @return Whether the result was received.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:53.140 -0500", hash_original_method = "28474D5684D129A1738A9E8F91D9820E", hash_generated_method = "6CB882EFE8E50C92497DD07A19624409")
    
private boolean waitForResultTimedLocked(int interactionId) {
        long waitTimeMillis = TIMEOUT_INTERACTION_MILLIS;
        final long startTimeMillis = SystemClock.uptimeMillis();
        while (true) {
            try {
                Message sameProcessMessage = getSameProcessMessageAndClear();
                if (sameProcessMessage != null) {
                    sameProcessMessage.getTarget().handleMessage(sameProcessMessage);
                }

                if (mInteractionId == interactionId) {
                    return true;
                }
                if (mInteractionId > interactionId) {
                    return false;
                }
                final long elapsedTimeMillis = SystemClock.uptimeMillis() - startTimeMillis;
                waitTimeMillis = TIMEOUT_INTERACTION_MILLIS - elapsedTimeMillis;
                if (waitTimeMillis <= 0) {
                    return false;
                }
                mInstanceLock.wait(waitTimeMillis);
            } catch (InterruptedException ie) {
                /* ignore */
            }
        }
    }

    /**
     * Applies compatibility scale to the info bounds if it is not equal to one.
     *
     * @param info The info whose bounds to scale.
     * @param scale The scale to apply.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:53.142 -0500", hash_original_method = "061B568C08B51F012B887F4F0E2A3802", hash_generated_method = "127E2908C4A5EAD90780B79D3E4E8DA8")
    
private void applyCompatibilityScaleIfNeeded(AccessibilityNodeInfo info, float scale) {
        if (scale == 1.0f) {
            return;
        }
        Rect bounds = mTempBounds;
        info.getBoundsInParent(bounds);
        bounds.scale(scale);
        info.setBoundsInParent(bounds);

        info.getBoundsInScreen(bounds);
        bounds.scale(scale);
        info.setBoundsInScreen(bounds);
    }

    /**
     * Finalize an {@link AccessibilityNodeInfo} before passing it to the client.
     *
     * @param info The info.
     * @param connectionId The id of the connection to the system.
     * @param windowScale The source window compatibility scale.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:53.145 -0500", hash_original_method = "50C3A05545C97DCA046561890361C747", hash_generated_method = "5841F3C3F52249243991CA2FB6EB4161")
    
private void finalizeAccessibilityNodeInfo(AccessibilityNodeInfo info, int connectionId,
            float windowScale) {
        if (info != null) {
            applyCompatibilityScaleIfNeeded(info, windowScale);
            info.setConnectionId(connectionId);
            info.setSealed(true);
        }
    }

    /**
     * Finalize {@link AccessibilityNodeInfo}s before passing them to the client.
     *
     * @param infos The {@link AccessibilityNodeInfo}s.
     * @param connectionId The id of the connection to the system.
     * @param windowScale The source window compatibility scale.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:53.148 -0500", hash_original_method = "C4CCA9503A1FCF65E2280A82ABED87CD", hash_generated_method = "457DDE40635D93EE5B1F3F509AC6AD3F")
    
private void finalizeAccessibilityNodeInfos(List<AccessibilityNodeInfo> infos,
            int connectionId, float windowScale) {
        if (infos != null) {
            final int infosCount = infos.size();
            for (int i = 0; i < infosCount; i++) {
                AccessibilityNodeInfo info = infos.get(i);
                finalizeAccessibilityNodeInfo(info, connectionId, windowScale);
            }
        }
    }

    /**
     * Gets the message stored if the interacted and interacting
     * threads are the same.
     *
     * @return The message.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:53.150 -0500", hash_original_method = "44FB956257430D3824804A6F98AEDC24", hash_generated_method = "C0DBE962E82B0B615B0516544C7D7535")
    
private Message getSameProcessMessageAndClear() {
        synchronized (mInstanceLock) {
            Message result = mSameThreadMessage;
            mSameThreadMessage = null;
            return result;
        }
    }

    /**
     * Gets a cached accessibility service connection.
     *
     * @param connectionId The connection id.
     * @return The cached connection if such.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:53.152 -0500", hash_original_method = "C30C93509C0684283448214BFA9D8225", hash_generated_method = "DCD8487BB5A66A8CCEE4E4D160170CF8")
    
public IAccessibilityServiceConnection getConnection(int connectionId) {
        synchronized (sConnectionCache) {
            return sConnectionCache.get(connectionId);
        }
    }

    /**
     * Adds a cached accessibility service connection.
     *
     * @param connectionId The connection id.
     * @param connection The connection.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:53.155 -0500", hash_original_method = "7A0506F80A0A925F6D871EC270864AAB", hash_generated_method = "71E7462F24A8A3736FDA626CC2C92154")
    
public void addConnection(int connectionId, IAccessibilityServiceConnection connection) {
        synchronized (sConnectionCache) {
            sConnectionCache.put(connectionId, connection);
        }
    }

    /**
     * Removes a cached accessibility service connection.
     *
     * @param connectionId The connection id.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:53.157 -0500", hash_original_method = "A8D0295941AD6316CEC94ABF823C5DD4", hash_generated_method = "0D0A126060A4ABD17BDAE7D2B64AEA2E")
    
public void removeConnection(int connectionId) {
        synchronized (sConnectionCache) {
            sConnectionCache.remove(connectionId);
        }
    }
}

