/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 * 
 * 
 * This file incorporates work covered by the following copyright and
 * permission notice:
 *
 * Copyright (C) 2006 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package android.view;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Slog;
import droidsafe.annotations.*;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import android.Manifest;
import android.animation.LayoutTransition;
import android.app.ActivityManagerNative;
import android.content.ClipDescription;
import android.content.ComponentCallbacks;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.CompatibilityInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.media.AudioManager;
import android.os.Binder;
import android.os.Bundle;
import android.os.Debug;
import android.os.Handler;
import android.os.LatencyTimer;
import android.os.Looper;
import android.os.Message;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.os.RemoteException;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.util.AndroidRuntimeException;
import android.util.DisplayMetrics;
import android.util.EventLog;
import android.util.Log;
import android.util.Pool;
import android.util.Poolable;
import android.util.PoolableManager;
import android.util.Pools;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.View.AttachInfo.InvalidateInfo;
import android.view.View.MeasureSpec;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityInteractionClient;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.IAccessibilityInteractionConnection;
import android.view.accessibility.IAccessibilityInteractionConnectionCallback;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.Scroller;

import com.android.internal.policy.PolicyManager;
import com.android.internal.view.BaseSurfaceHolder;
import com.android.internal.view.IInputMethodCallback;
import com.android.internal.view.IInputMethodSession;
import com.android.internal.view.RootViewSurfaceTaker;

public final class ViewRootImpl extends Handler implements ViewParent, View.AttachInfo.Callbacks, HardwareRenderer.HardwareDrawCallbacks {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.930 -0500", hash_original_method = "6204018B0410883FB8966B71E80E7FF6", hash_generated_method = "559F65FDCB3510E740B6FB09ECC8C64F")
    
public static IWindowSession getWindowSession(Looper mainLooper) {
        synchronized (mStaticInit) {
            if (!mInitialized) {
                try {
                    InputMethodManager imm = InputMethodManager.getInstance(mainLooper);
                    sWindowSession = Display.getWindowManager().openSession(
                            imm.getClient(), imm.getInputContext());
                    mInitialized = true;
                } catch (RemoteException e) {
                }
            }
            return sWindowSession;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.947 -0500", hash_original_method = "FAC0EC3E77B4781B224707645FD3A4FF", hash_generated_method = "116B0A8AEFC670E5FAF3025171FE97B7")
    
public static void addFirstDrawHandler(Runnable callback) {
        synchronized (sFirstDrawHandlers) {
            if (!sFirstDrawComplete) {
                sFirstDrawHandlers.add(callback);
            }
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.949 -0500", hash_original_method = "834621F626C96E3AD42E0A4200072657", hash_generated_method = "C3464632656664054F7604F4AA724841")
    
public static void addConfigCallback(ComponentCallbacks callback) {
        synchronized (sConfigCallbacks) {
            sConfigCallbacks.add(callback);
        }
    }

    /**
     * Indicates whether we are in touch mode. Calling this method triggers an IPC
     * call and should be avoided whenever possible.
     *
     * @return True, if the device is in touch mode, false otherwise.
     *
     * @hide
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.956 -0500", hash_original_method = "056827AB9E74AF6C4B57ABEC8FCA9A3C", hash_generated_method = "67071346A9218C2191AEF8CE4E4334B3")
    
static boolean isInTouchMode() {
        if (mInitialized) {
            try {
                return sWindowSession.getInTouchMode();
            } catch (RemoteException e) {
            }
        }
        return false;
    }
    
    /**
     * Return true if child is an ancestor of parent, (or equal to the parent).
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.100 -0500", hash_original_method = "25276A1ACE97D138BB17C9052B223D37", hash_generated_method = "418459F41ADF951A5077179957FC2600")
    
private static boolean isViewDescendantOf(View child, View parent) {
        if (child == parent) {
            return true;
        }

        final ViewParent theParent = child.getParent();
        return (theParent instanceof ViewGroup) && isViewDescendantOf((View) theParent, parent);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.103 -0500", hash_original_method = "4A21A3C59CED96F8D51A1FA9FDD7BAE0", hash_generated_method = "486947955DF3791BB348E635C624758E")
    
private static void forceLayout(View view) {
        view.forceLayout();
        if (view instanceof ViewGroup) {
            ViewGroup group = (ViewGroup) view;
            final int count = group.getChildCount();
            for (int i = 0; i < count; i++) {
                forceLayout(group.getChildAt(i));
            }
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.229 -0500", hash_original_method = "822C159A63B62845A16568D718169DEC", hash_generated_method = "0D9A3ACE204C7A37F242AB353E0C3216")
    
private static int joystickAxisValueToDirection(float value) {
        if (value >= 0.5f) {
            return 1;
        } else if (value <= -0.5f) {
            return -1;
        } else {
            return 0;
        }
    }

    /**
     * Returns true if the key is used for keyboard navigation.
     * @param keyEvent The key event.
     * @return True if the key is used for keyboard navigation.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.231 -0500", hash_original_method = "7C2143BAA8152610397375F7B6D253AB", hash_generated_method = "73231264E9616A58A51CB5AF770D3937")
    
private static boolean isNavigationKey(KeyEvent keyEvent) {
        switch (keyEvent.getKeyCode()) {
        case KeyEvent.KEYCODE_DPAD_LEFT:
        case KeyEvent.KEYCODE_DPAD_RIGHT:
        case KeyEvent.KEYCODE_DPAD_UP:
        case KeyEvent.KEYCODE_DPAD_DOWN:
        case KeyEvent.KEYCODE_DPAD_CENTER:
        case KeyEvent.KEYCODE_PAGE_UP:
        case KeyEvent.KEYCODE_PAGE_DOWN:
        case KeyEvent.KEYCODE_MOVE_HOME:
        case KeyEvent.KEYCODE_MOVE_END:
        case KeyEvent.KEYCODE_TAB:
        case KeyEvent.KEYCODE_SPACE:
        case KeyEvent.KEYCODE_ENTER:
            return true;
        }
        return false;
    }

    /**
     * Returns true if the key is used for typing.
     * @param keyEvent The key event.
     * @return True if the key is used for typing.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.233 -0500", hash_original_method = "553A2E860A4F6148EE15CCC8CC3C5F34", hash_generated_method = "E371B19500089A404A3F7B6A779D7ED9")
    
private static boolean isTypingKey(KeyEvent keyEvent) {
        return keyEvent.getUnicodeChar() > 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.561 -0500", hash_original_method = "0956BAC4E651A6EA7D6D5241504B2332", hash_generated_method = "83B934B4D7332837C02CA90AC2A39A1E")
    
static RunQueue getRunQueue() {
        RunQueue rq = sRunQueues.get();
        if (rq != null) {
            return rq;
        }
        rq = new RunQueue();
        sRunQueues.set(rq);
        return rq;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.643 -0500", hash_original_field = "654D217E3415618B07444C823C61536B", hash_generated_field = "20A0B237EA7FED0897D15F2C9A434731")

    private static final String TAG = "ViewRootImpl";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.646 -0500", hash_original_field = "B2601CA7445F6BA19FA7884763D82281", hash_generated_field = "1A61763F9CABC9206BB5AE6E570AB8AE")

    private static final boolean DBG = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.649 -0500", hash_original_field = "745FE27F6621B49CB7F0165D799C0855", hash_generated_field = "626038DAE6BB26944A3CF12B5D6F74EE")

    private static final boolean LOCAL_LOGV = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.651 -0500", hash_original_field = "CFF82DFF93D0F51F41A3F14A1BF1FF38", hash_generated_field = "971AF06B9A1B36F9E637DA19FBC7C8E8")

    private static final boolean DEBUG_DRAW = false || LOCAL_LOGV;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.654 -0500", hash_original_field = "DE0109A33B4F1326AD3640D46344A143", hash_generated_field = "CB8EB2CBBD50573AA52874C3C657F261")

    private static final boolean DEBUG_LAYOUT = false || LOCAL_LOGV;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.656 -0500", hash_original_field = "204567BF0BBFEF5E89B085E3334666AF", hash_generated_field = "8EA22DB3A605D961CEA3CCDA576DF97D")

    private static final boolean DEBUG_DIALOG = false || LOCAL_LOGV;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.659 -0500", hash_original_field = "64F6DBE93AA62CCF0D3C4869EFBDBDE7", hash_generated_field = "A5F9DE67F8CD98CB6CDB329B70C684A4")

    private static final boolean DEBUG_INPUT_RESIZE = false || LOCAL_LOGV;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.661 -0500", hash_original_field = "792FB8078048AD4C3567921FA5F32052", hash_generated_field = "23E83E11FDABB85CB4C188C31B75DA5C")

    private static final boolean DEBUG_ORIENTATION = false || LOCAL_LOGV;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.663 -0500", hash_original_field = "306BCFE56EB98E1B29D8129063F443B8", hash_generated_field = "77EE0AA06B23769B780A309B393E32FA")

    private static final boolean DEBUG_TRACKBALL = false || LOCAL_LOGV;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.665 -0500", hash_original_field = "E2BFB7F354219393BC3C871EC85A9A0A", hash_generated_field = "7B7C0ECBA08420BBFAB103815EABD246")

    private static final boolean DEBUG_IMF = false || LOCAL_LOGV;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.668 -0500", hash_original_field = "A2E496893B98D1BF2838FA551C047A0C", hash_generated_field = "E7DDC8C264C9F86DB032DBB6CABC2709")

    private static final boolean DEBUG_CONFIGURATION = false || LOCAL_LOGV;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.671 -0500", hash_original_field = "4448D2B0937D8A99B17EAFF42169F7DC", hash_generated_field = "A0CF8EE94CFC62F1428857DCF5542F88")

    private static final boolean DEBUG_FPS = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.674 -0500", hash_original_field = "453BB0A9CE1C58E9747858A43E551565", hash_generated_field = "5FA7473017ED5A2E46DB49A8BFC34BE9")

    private static final boolean WATCH_POINTER = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.676 -0500", hash_original_field = "A832C46A3DFC6FBF210CBAAB4457696C", hash_generated_field = "3A883DE2B0B67773D8F82B7654B7D004")

    private static final String PROPERTY_PROFILE_RENDERING = "viewancestor.profile_rendering";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.679 -0500", hash_original_field = "35CA87112098D6BE37E3F9B4C11506DC", hash_generated_field = "E5342F079514828E15AB01F9FA97BF6C")
    
    private static final boolean MEASURE_LATENCY = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.681 -0500", hash_original_field = "8EB22E526FB1BA616C8A564A7CD1E92B", hash_generated_field = "4C70E88FDA504CF3924879E0993C2C35")

    private static LatencyTimer lt;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.684 -0500", hash_original_field = "3FAE798898347C79712401A795F186EE", hash_generated_field = "B0C223721AEEA6A8D58BAE0775580384")

    static final int MAX_TRACKBALL_DELAY = 250;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.686 -0500", hash_original_field = "3646CDC8A0F4ABA91184151AB781CE21", hash_generated_field = "CE60587CF2EE3A6FA7BC23F1967EFA78")

    static IWindowSession sWindowSession;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.688 -0500", hash_original_field = "C68E4B016BCA6DA44EAB66E68E44F858", hash_generated_field = "906814A8DD92904364CC348726E82FDF")

    static final Object mStaticInit = new Object();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.690 -0500", hash_original_field = "D7228C282593CDC77734D668B23541D3", hash_generated_field = "536734E2DD91AB5EDF1F3B60AFB40B7C")

    static boolean mInitialized = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.693 -0500", hash_original_field = "EB74D664B6F34E96581A3014C0D2DD2E", hash_generated_field = "B17B98FA673511F1A0E4D0FB5118C35F")

    static final ThreadLocal<RunQueue> sRunQueues = new ThreadLocal<RunQueue>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.695 -0500", hash_original_field = "5B886CFD8B1F84A5BCAEA0BF6DBF9E58", hash_generated_field = "B99793B7C0D11503969031E3D368FFEC")

    static final ArrayList<Runnable> sFirstDrawHandlers = new ArrayList<Runnable>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.697 -0500", hash_original_field = "D1427451CF3CC911FF7398FBDDF056DC", hash_generated_field = "63BD0028405F2577A6800DED464B8A3B")

    static boolean sFirstDrawComplete = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.699 -0500", hash_original_field = "CF2D77B0C20F9FED69CB3AF200586529", hash_generated_field = "7E01A30DB4DBEA8BAA84FC6A8EA8B318")
    
    static final ArrayList<ComponentCallbacks> sConfigCallbacks
            = new ArrayList<ComponentCallbacks>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.882 -0500", hash_original_field = "A31565454F1648D43E6A46C72EA98444", hash_generated_field = "347C4ECD6969CCE8F943EAB38DB0079A")

    static final Interpolator mResizeInterpolator = new AccelerateDecelerateInterpolator();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.106 -0500", hash_original_field = "D8F1561FDEA4B83DA0EEAE255A6A064D", hash_generated_field = "3EB90E2F993B9CB287747FD7EEEF5D90")

    public final static int DO_TRAVERSAL = 1000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.108 -0500", hash_original_field = "6F750DD5D40451E60181CD4E6BE2A893", hash_generated_field = "F0BCA4B075D24D0FF66A6916CC127271")

    public final static int DIE = 1001;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.111 -0500", hash_original_field = "F9A286312ABC3E6192344770B4FB8DF5", hash_generated_field = "EA01F9146001F93DF12B6DD8FF81CC53")

    public final static int RESIZED = 1002;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.113 -0500", hash_original_field = "90F45F171E10B37F1A2A1FA0A496F215", hash_generated_field = "AB61E328C1E2634C736F13E407311D18")

    public final static int RESIZED_REPORT = 1003;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.116 -0500", hash_original_field = "B9A45C84D9161B5B31E83C2DFF9D7F2C", hash_generated_field = "2FD8D787B807B4EE2C688EC81CAD354C")

    public final static int WINDOW_FOCUS_CHANGED = 1004;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.118 -0500", hash_original_field = "BCA8462744B17FCE6738A2521951CDDD", hash_generated_field = "46BC1AB0B59868BC1AC272F074AD853B")

    public final static int DISPATCH_KEY = 1005;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.120 -0500", hash_original_field = "3EAE89DE518EC293DA8AC8B10B3F29F4", hash_generated_field = "CFCFDFB572BC4BDCA1471B291D10B9FE")

    public final static int DISPATCH_POINTER = 1006;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.123 -0500", hash_original_field = "8BE9344016B4D84DA8B3022D6E779471", hash_generated_field = "D9F532C1428B70D44A71437836C78C0B")

    public final static int DISPATCH_TRACKBALL = 1007;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.125 -0500", hash_original_field = "C3B05E9BDE09BF7BC3C0ADD9A671CC62", hash_generated_field = "FA67D6D19432E9CAFFF018FDFFC4D8E2")

    public final static int DISPATCH_APP_VISIBILITY = 1008;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.129 -0500", hash_original_field = "94A780A6A9ACD5C942BA9A0216F15BC0", hash_generated_field = "1CD05315E6CF2B4F64EBB262782DA709")

    public final static int DISPATCH_GET_NEW_SURFACE = 1009;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.131 -0500", hash_original_field = "C411F21030BB0F9414BE5FD89A162CAB", hash_generated_field = "A872A4B58863DDD392F65C30D22E6818")

    public final static int FINISHED_EVENT = 1010;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.134 -0500", hash_original_field = "043881981FC7CA5A5179EB67C8065D1E", hash_generated_field = "8F58AD3EA7EA7BCABB230C363AF6864D")

    public final static int DISPATCH_KEY_FROM_IME = 1011;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.136 -0500", hash_original_field = "38F11D797AFDBEA78EE89D070D8A9CA2", hash_generated_field = "0E2AE4E9BC35AB1C012C9D523F2DB54F")

    public final static int FINISH_INPUT_CONNECTION = 1012;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.139 -0500", hash_original_field = "801D8F90088F9542BD78B6A88DA1EBD7", hash_generated_field = "89F79CCE1AF9647DEE46375D53A1C760")

    public final static int CHECK_FOCUS = 1013;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.141 -0500", hash_original_field = "0C51E25AE589657B467612D79B9284C5", hash_generated_field = "222999CFB72FB7D242E23460229012C5")

    public final static int CLOSE_SYSTEM_DIALOGS = 1014;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.143 -0500", hash_original_field = "C041E84936341EBED204C09AB70F6560", hash_generated_field = "4B576476AE6F6AA4611FDC7AEC60C475")

    public final static int DISPATCH_DRAG_EVENT = 1015;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.145 -0500", hash_original_field = "94C9C9A8E94A746CBD1A6DB9D78A5C1F", hash_generated_field = "B771249D49FABB56D119E90358FD2BFB")

    public final static int DISPATCH_DRAG_LOCATION_EVENT = 1016;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.148 -0500", hash_original_field = "61F6412E526C9D9BF05095D3BFC78ECE", hash_generated_field = "63FAB3F2B47509EA62E2799705C2C615")

    public final static int DISPATCH_SYSTEM_UI_VISIBILITY = 1017;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.150 -0500", hash_original_field = "58C0AB1FCCE31B2C17976A27AE579878", hash_generated_field = "E0183864301CE37CAD6F15B696A751C5")

    public final static int DISPATCH_GENERIC_MOTION = 1018;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.153 -0500", hash_original_field = "4CDFE573B88BC3E1789526400EAEB706", hash_generated_field = "90DC4C76E6F79F810FC476C28E742912")

    public final static int UPDATE_CONFIGURATION = 1019;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.155 -0500", hash_original_field = "33684AC6F1AB5519DC593325F71FEA11", hash_generated_field = "A5F752869EC9ED93776BAA0EEBD6A03B")

    public final static int DO_PERFORM_ACCESSIBILITY_ACTION = 1020;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.158 -0500", hash_original_field = "26D2660DE9D19F2A93AF320193BC2D48", hash_generated_field = "4D02D16C0FBA008C4C6CA5ABF6F0455F")

    public final static int DO_FIND_ACCESSIBLITY_NODE_INFO_BY_ACCESSIBILITY_ID = 1021;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.161 -0500", hash_original_field = "5947ED2CDCFE9E7D624B674C6C25ACF4", hash_generated_field = "29168F52297DC460BEBF7B0492E61AB6")

    public final static int DO_FIND_ACCESSIBLITY_NODE_INFO_BY_VIEW_ID = 1022;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.164 -0500", hash_original_field = "16A48FB6EB33E00FA34A8638E9EEF8EC", hash_generated_field = "3D3A76CBE28044195F427274AA43966C")

    public final static int DO_FIND_ACCESSIBLITY_NODE_INFO_BY_VIEW_TEXT = 1023;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.166 -0500", hash_original_field = "8518DF5C88D5304EE95767C5E5D90CE5", hash_generated_field = "70877CF2932D34884120E6D77E84ADE5")

    public final static int PROCESS_INPUT_EVENTS = 1024;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.702 -0500", hash_original_field = "843FBE1A9F9CBF827094CA7CF070DBDE", hash_generated_field = "843FBE1A9F9CBF827094CA7CF070DBDE")

    long mLastTrackballTime = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.704 -0500", hash_original_field = "4975D6254B2DF93656DFB71CA7D5B2B5", hash_generated_field = "8405ACA924158429D7DAF509E106E80E")

    final TrackballAxis mTrackballAxisX = new TrackballAxis();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.706 -0500", hash_original_field = "FD51AE65F4BF85C92A08F8F47B043C0F", hash_generated_field = "E58AB91B5ACFBE3D4FB913472293F77A")

    final TrackballAxis mTrackballAxisY = new TrackballAxis();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.708 -0500", hash_original_field = "1F6F035B05518F799CC4A631830DEA24", hash_generated_field = "1F6F035B05518F799CC4A631830DEA24")

    int mLastJoystickXDirection;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.710 -0500", hash_original_field = "FAD79A20871B99E6C09DCA8C579054AF", hash_generated_field = "FAD79A20871B99E6C09DCA8C579054AF")

    int mLastJoystickYDirection;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.712 -0500", hash_original_field = "008A164762C8272B4BD8A8FAE6C0E3A7", hash_generated_field = "008A164762C8272B4BD8A8FAE6C0E3A7")

    int mLastJoystickXKeyCode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.714 -0500", hash_original_field = "70296AF28AFADF018D48568A1EC7CDC1", hash_generated_field = "70296AF28AFADF018D48568A1EC7CDC1")

    int mLastJoystickYKeyCode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.717 -0500", hash_original_field = "18ECE134BF0FC41944D7DF74E92F279C", hash_generated_field = "192CBA0F154C36DD2A24DDE2AD97DD40")

    final int[] mTmpLocation = new int[2];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.719 -0500", hash_original_field = "3E9DE2CC62973C980770A1C51776F761", hash_generated_field = "F4896FA60EAF46F89D1B23DB39A94469")

    final TypedValue mTmpValue = new TypedValue();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.722 -0500", hash_original_field = "B902B282F1853C48591AA333FC5C6930", hash_generated_field = "B902B282F1853C48591AA333FC5C6930")
    
     InputMethodCallback mInputMethodCallback;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.724 -0500", hash_original_field = "31E1A5605EFB6D554CCADEAB55CCF516", hash_generated_field = "598B68B7DF6E876D9AF774185C389FF7")

    final SparseArray<Object> mPendingEvents = new SparseArray<Object>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.726 -0500", hash_original_field = "8504A7AA7F77E97847E07EE0E13DD89E", hash_generated_field = "8504A7AA7F77E97847E07EE0E13DD89E")

    int mPendingEventSeq = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.728 -0500", hash_original_field = "8CE20653889294789C714060A391C40F", hash_generated_field = "8CE20653889294789C714060A391C40F")

     Thread mThread;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.730 -0500", hash_original_field = "F0FFEA60326B2D639F57F2EAC1D83F2E", hash_generated_field = "F0FFEA60326B2D639F57F2EAC1D83F2E")

     WindowLeaked mLocation;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.732 -0500", hash_original_field = "D292E6945091564B50F91497CC02D2E3", hash_generated_field = "FBA586EC47BBF8235BA69538A45A084C")

    final WindowManager.LayoutParams mWindowAttributes = new WindowManager.LayoutParams();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.735 -0500", hash_original_field = "17DBBC35D1D58356620B06871EA80682", hash_generated_field = "17DBBC35D1D58356620B06871EA80682")

     W mWindow;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.737 -0500", hash_original_field = "B8EEE6865DFA2D11E19D316E427BCF57", hash_generated_field = "B8EEE6865DFA2D11E19D316E427BCF57")

     int mTargetSdkVersion;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.739 -0500", hash_original_field = "8913F44A11D4302ED7B203F0CF0BA11B", hash_generated_field = "8913F44A11D4302ED7B203F0CF0BA11B")

    int mSeq;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.741 -0500", hash_original_field = "6F4F028D1DE9C463F753A80DD0991753", hash_generated_field = "6F4F028D1DE9C463F753A80DD0991753")

    View mView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.743 -0500", hash_original_field = "A476C52E6AE87C5E9FAFA76F8149063E", hash_generated_field = "A476C52E6AE87C5E9FAFA76F8149063E")

    View mFocusedView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.745 -0500", hash_original_field = "3DC22EE5DBB3E6E14C770C4103F10EB9", hash_generated_field = "3DC22EE5DBB3E6E14C770C4103F10EB9")

    View mRealFocusedView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.747 -0500", hash_original_field = "6F90E9BEC145DE5BCF5865F1869A8817", hash_generated_field = "6F90E9BEC145DE5BCF5865F1869A8817")

    int mViewVisibility;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.749 -0500", hash_original_field = "CBD2E44BCC5B5ECBFE52241EEB9711C5", hash_generated_field = "CBD2E44BCC5B5ECBFE52241EEB9711C5")

    boolean mAppVisible = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.751 -0500", hash_original_field = "0AEB888D275C51C81ED076AFA9DC9522", hash_generated_field = "0AEB888D275C51C81ED076AFA9DC9522")

    int mOrigWindowType = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.753 -0500", hash_original_field = "80618C8C8672F89E380C28D4E4CF2CB6", hash_generated_field = "D06C3955EA0F182C66A41FDF5FC1E404")

    // so the window should no longer be active.
    boolean mStopped = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.756 -0500", hash_original_field = "23B6B29357EB27D126E7D0E5137E40A2", hash_generated_field = "23B6B29357EB27D126E7D0E5137E40A2")
    
    boolean mLastInCompatMode = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.758 -0500", hash_original_field = "D3FE6DB201CFE61D34745A493F584192", hash_generated_field = "D3FE6DB201CFE61D34745A493F584192")

    SurfaceHolder.Callback2 mSurfaceHolderCallback;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.760 -0500", hash_original_field = "F864CA3F05AD6C8A628535B131A61BBF", hash_generated_field = "F864CA3F05AD6C8A628535B131A61BBF")

    BaseSurfaceHolder mSurfaceHolder;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.762 -0500", hash_original_field = "8F301FBCF4999017F75CC0B716F2517E", hash_generated_field = "8F301FBCF4999017F75CC0B716F2517E")

    boolean mIsCreating;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.764 -0500", hash_original_field = "31E39D3D4E66A5056EAD95BE27A3903C", hash_generated_field = "31E39D3D4E66A5056EAD95BE27A3903C")

    boolean mDrawingAllowed;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.766 -0500", hash_original_field = "C0C52C8769544E33D239458B4880FB79", hash_generated_field = "C0C52C8769544E33D239458B4880FB79")
    
     Region mTransparentRegion;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.769 -0500", hash_original_field = "6DD5B69EF744EC321638C5B663EA67C0", hash_generated_field = "6DD5B69EF744EC321638C5B663EA67C0")

     Region mPreviousTransparentRegion;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.771 -0500", hash_original_field = "AF6410B200BC05DCA2CF0BE65165448A", hash_generated_field = "AF6410B200BC05DCA2CF0BE65165448A")

    int mWidth;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.773 -0500", hash_original_field = "7DDAE255893B528E7BEBEC203BC2D9F3", hash_generated_field = "7DDAE255893B528E7BEBEC203BC2D9F3")

    int mHeight;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.775 -0500", hash_original_field = "E76116A4E1D56F9ACB236AA480F07D5C", hash_generated_field = "E76116A4E1D56F9ACB236AA480F07D5C")

    Rect mDirty;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.777 -0500", hash_original_field = "9522716F11853273BCC9B726CF0A5A84", hash_generated_field = "7D059A3482DA1107B4225C068EC3B96C")

    final Rect mCurrentDirty = new Rect();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.779 -0500", hash_original_field = "B6305C165E8C8997FF59C39D6EA49CB8", hash_generated_field = "27F620C09DF5AF3A58C0B01A44A71C88")

    final Rect mPreviousDirty = new Rect();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.781 -0500", hash_original_field = "97BCAC515A131331E06C789507755EE7", hash_generated_field = "97BCAC515A131331E06C789507755EE7")

    boolean mIsAnimating;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.783 -0500", hash_original_field = "A237DD2C3AA1799B8037D96788707A83", hash_generated_field = "A237DD2C3AA1799B8037D96788707A83")

    CompatibilityInfo.Translator mTranslator;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.785 -0500", hash_original_field = "86473EE91D5723F9F75E2A56F39C84CF", hash_generated_field = "86473EE91D5723F9F75E2A56F39C84CF")

     View.AttachInfo mAttachInfo;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.788 -0500", hash_original_field = "19DDA5FF34DEE6F036F3E0F6D18E8BCF", hash_generated_field = "19DDA5FF34DEE6F036F3E0F6D18E8BCF")

    InputChannel mInputChannel;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.790 -0500", hash_original_field = "BF4123EFADD525416DF2ECCC683CF87D", hash_generated_field = "BF4123EFADD525416DF2ECCC683CF87D")

    InputQueue.Callback mInputQueueCallback;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.792 -0500", hash_original_field = "214B662EBB0919E92BC2DA7797C68593", hash_generated_field = "214B662EBB0919E92BC2DA7797C68593")

    InputQueue mInputQueue;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.794 -0500", hash_original_field = "45AD45F5DD34AE4545398CF3CECF17C4", hash_generated_field = "45AD45F5DD34AE4545398CF3CECF17C4")

    FallbackEventHandler mFallbackEventHandler;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.796 -0500", hash_original_field = "9F1BD97088B2257F3EF12D8B258FBB69", hash_generated_field = "9F1BD97088B2257F3EF12D8B258FBB69")
    
     Rect mTempRect;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.798 -0500", hash_original_field = "75DE7B8E36E8E0070CF83B97AE3C5ADD", hash_generated_field = "75DE7B8E36E8E0070CF83B97AE3C5ADD")

     Rect mVisRect;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.800 -0500", hash_original_field = "5CAC89A6B43ECD32B0872A407087A6F4", hash_generated_field = "5CAC89A6B43ECD32B0872A407087A6F4")

    boolean mTraversalScheduled;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.802 -0500", hash_original_field = "EB355C7A896FD8B8387186109992F2B8", hash_generated_field = "EB355C7A896FD8B8387186109992F2B8")

    long mLastTraversalFinishedTimeNanos;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.804 -0500", hash_original_field = "C8304D699838C82BC498F4723E240C1F", hash_generated_field = "C8304D699838C82BC498F4723E240C1F")

    long mLastDrawDurationNanos;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.807 -0500", hash_original_field = "345D78977A28AFF99B79AE805D352734", hash_generated_field = "345D78977A28AFF99B79AE805D352734")

    boolean mWillDrawSoon;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.809 -0500", hash_original_field = "48AB4660010DD29E688C29E9BF84B71B", hash_generated_field = "48AB4660010DD29E688C29E9BF84B71B")

    boolean mLayoutRequested;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.811 -0500", hash_original_field = "562F659A65CBB4A1A6DBAAFE4E932885", hash_generated_field = "562F659A65CBB4A1A6DBAAFE4E932885")

    boolean mFirst;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.813 -0500", hash_original_field = "2977B3A45EA900C6A3042BD62F95188E", hash_generated_field = "2977B3A45EA900C6A3042BD62F95188E")

    boolean mReportNextDraw;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.815 -0500", hash_original_field = "DAF006AD70DDF288E744168F840824B7", hash_generated_field = "DAF006AD70DDF288E744168F840824B7")

    boolean mFullRedrawNeeded;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.817 -0500", hash_original_field = "F4C0F083E90A29856957BA6D1DDAED83", hash_generated_field = "F4C0F083E90A29856957BA6D1DDAED83")

    boolean mNewSurfaceNeeded;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.819 -0500", hash_original_field = "5F83D526A3FA8B2F4898EDD5EF0E2A3A", hash_generated_field = "5F83D526A3FA8B2F4898EDD5EF0E2A3A")

    boolean mHasHadWindowFocus;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.821 -0500", hash_original_field = "2ABCD72F1C5FD8723FE1304A4714716F", hash_generated_field = "2ABCD72F1C5FD8723FE1304A4714716F")

    boolean mLastWasImTarget;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.823 -0500", hash_original_field = "F8F7FAB20882F1D392651D5DEC2E7327", hash_generated_field = "F8F7FAB20882F1D392651D5DEC2E7327")

    InputEventMessage mPendingInputEvents = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.825 -0500", hash_original_field = "06BBA4AD1FBDA3B0B33CE36EFE1027EA", hash_generated_field = "06BBA4AD1FBDA3B0B33CE36EFE1027EA")

    boolean mWindowAttributesChanged = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.827 -0500", hash_original_field = "546953AC84915AC28C8B7DAF9502F5E5", hash_generated_field = "546953AC84915AC28C8B7DAF9502F5E5")

    int mWindowAttributesChangesFlag = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.830 -0500", hash_original_field = "1124ED61F6BA8AE3DABDAA886BC252C4", hash_generated_field = "1D78B50396D1CE00D0BB13A25C3093CF")

    // Surface can never be reassigned or cleared (use Surface.clear()).
    private final Surface mSurface = new Surface();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.832 -0500", hash_original_field = "CE47E8E592EB95BEB04FBBE625E99A8D", hash_generated_field = "CE47E8E592EB95BEB04FBBE625E99A8D")

    boolean mAdded;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.834 -0500", hash_original_field = "3272EA4F55AF2134E76D819B48B053D5", hash_generated_field = "3272EA4F55AF2134E76D819B48B053D5")

    boolean mAddedTouchMode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.836 -0500", hash_original_field = "5EAC126C193FC41ACB184C1D10F2C250", hash_generated_field = "5EAC126C193FC41ACB184C1D10F2C250")

    CompatibilityInfoHolder mCompatibilityInfo;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.838 -0500", hash_original_field = "4FAA064DF54D7CC2DBADC1DAB51471A6", hash_generated_field = "4FAA064DF54D7CC2DBADC1DAB51471A6")
 int mAddNesting;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.840 -0500", hash_original_field = "79F142AE0DEC957F939DD6F49191F7DA", hash_generated_field = "79F142AE0DEC957F939DD6F49191F7DA")

     Rect mWinFrame;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.842 -0500", hash_original_field = "3A62E2465C42A041582A8F996B30D0C5", hash_generated_field = "D7BF56D7D1AA140BE857C621B183EA1F")

    final Rect mPendingVisibleInsets = new Rect();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.844 -0500", hash_original_field = "2DBB5B29E06A200A500EA494E8B10F6A", hash_generated_field = "1B6C360B3EA1E6006390DB0BE53A7892")

    final Rect mPendingContentInsets = new Rect();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.847 -0500", hash_original_field = "AEB9E5CCDE583A987BAD8A8214146814", hash_generated_field = "3ECCDFE4A47C5AABC0FEC62DB447749A")

    final ViewTreeObserver.InternalInsetsInfo mLastGivenInsets
            = new ViewTreeObserver.InternalInsetsInfo();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.849 -0500", hash_original_field = "0AE764505D70C71201355F8E003EA193", hash_generated_field = "34376B54378B9B3D43FDDE460CA57C87")

    final Configuration mLastConfiguration = new Configuration();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.852 -0500", hash_original_field = "AF2F98385216AA3B630DCA8E7C84587C", hash_generated_field = "8DF7E1052933D1F73177C1BFC385AA74")

    final Configuration mPendingConfiguration = new Configuration();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.862 -0500", hash_original_field = "F73A2E8B0FBF1242431CC31A3DD9702B", hash_generated_field = "F73A2E8B0FBF1242431CC31A3DD9702B")
    
    boolean mScrollMayChange;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.864 -0500", hash_original_field = "CF8B89DFEF5F4625A0C19FC1D32C3421", hash_generated_field = "CF8B89DFEF5F4625A0C19FC1D32C3421")

    int mSoftInputMode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.867 -0500", hash_original_field = "7D8A0E0CD7FFB1F73E763DA6C4667A4E", hash_generated_field = "7D8A0E0CD7FFB1F73E763DA6C4667A4E")

    View mLastScrolledFocus;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.869 -0500", hash_original_field = "EC6AD52CC705AA3985B25CDB13E68426", hash_generated_field = "EC6AD52CC705AA3985B25CDB13E68426")

    int mScrollY;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.871 -0500", hash_original_field = "565D20E48244C9362550DBB0B49B53BB", hash_generated_field = "565D20E48244C9362550DBB0B49B53BB")

    int mCurScrollY;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.873 -0500", hash_original_field = "16226695B3E75E1B75AD8C16FE7698DB", hash_generated_field = "16226695B3E75E1B75AD8C16FE7698DB")

    Scroller mScroller;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.875 -0500", hash_original_field = "F55691E21802586D78CD6F9FD51B171A", hash_generated_field = "F55691E21802586D78CD6F9FD51B171A")

    HardwareLayer mResizeBuffer;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.877 -0500", hash_original_field = "69E5E6DEA9BA26DB325DFF8EBCCC1A06", hash_generated_field = "69E5E6DEA9BA26DB325DFF8EBCCC1A06")

    long mResizeBufferStartTime;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.880 -0500", hash_original_field = "43B2C18D48C325F81780B31D87D0EC3F", hash_generated_field = "43B2C18D48C325F81780B31D87D0EC3F")

    int mResizeBufferDuration;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.884 -0500", hash_original_field = "F28749532FB2FA1C787866B59F57C5C8", hash_generated_field = "A493757D2D083CF70CF0156B7D650811")

    private ArrayList<LayoutTransition> mPendingTransitions;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.886 -0500", hash_original_field = "ABA78699C698034369F90645C9496674", hash_generated_field = "ABA78699C698034369F90645C9496674")

     ViewConfiguration mViewConfiguration;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.888 -0500", hash_original_field = "CC0FC278B71622219C45AD52C9FB53C8", hash_generated_field = "CC0FC278B71622219C45AD52C9FB53C8")

    ClipDescription mDragDescription;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.890 -0500", hash_original_field = "025092BC7B1A6638564A2FBB4D620E8D", hash_generated_field = "025092BC7B1A6638564A2FBB4D620E8D")

    View mCurrentDragView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.892 -0500", hash_original_field = "A0264D5C92A2A074824776AC45E01A80", hash_generated_field = "7D186346EFCB228BBC632C710813F06A")

    volatile Object mLocalDragState;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.895 -0500", hash_original_field = "A731FDD16B76F50B70110466F38276DB", hash_generated_field = "C40BD10C38FBF577696C33E32B5A5F15")

    final PointF mDragPoint = new PointF();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.897 -0500", hash_original_field = "82F4924DE0C33D5B200F7117206EA362", hash_generated_field = "CEA70AEA2380B8689249771FEECDD683")

    final PointF mLastTouchPoint = new PointF();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.900 -0500", hash_original_field = "DCA9C1CEBF044A84AF8953B73A6A1ADA", hash_generated_field = "2A75F6FAF247C6A563147144451919B0")
    
    private boolean mProfileRendering;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.902 -0500", hash_original_field = "EC4E206DABCE7F859A73029FA578044C", hash_generated_field = "2967540D832074C93AFE31D56D615C87")
    
    private Thread mRenderProfiler;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.905 -0500", hash_original_field = "B65B367A80C968EC8B8D3AF2F3F22393", hash_generated_field = "F1ABF1663FFD4FAD46EB136874019F65")

    private volatile boolean mRenderProfilingEnabled;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.907 -0500", hash_original_field = "E575CF9A540284A8461A9B2C669A492A", hash_generated_field = "AE62D52D470E5307BF23FF4D57A005B1")

    private long mFpsStartTime = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.909 -0500", hash_original_field = "A94532188EDF599B33CF3D3A7D49642F", hash_generated_field = "4B09966683DBC242A92E84CFC3759305")

    private long mFpsPrevTime = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.911 -0500", hash_original_field = "4FDA731BE2B8CA90BCD4AFFB84F46DF3", hash_generated_field = "500CC8C8BBFEA70158BD5B319AA9473F")

    private int mFpsNumFrames;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.913 -0500", hash_original_field = "81931559493F052ED78BA000FD1BC717", hash_generated_field = "81931559493F052ED78BA000FD1BC717")

    AudioManager mAudioManager;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.916 -0500", hash_original_field = "2467CDF4E5E89FDAF3ABD83B3362838B", hash_generated_field = "2467CDF4E5E89FDAF3ABD83B3362838B")

     AccessibilityManager mAccessibilityManager;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.918 -0500", hash_original_field = "326964F84FEA789C7EA69B5AD84D099B", hash_generated_field = "326964F84FEA789C7EA69B5AD84D099B")

    AccessibilityInteractionController mAccessibilityInteractionController;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.920 -0500", hash_original_field = "1EE07D7B37AEA69E13942B821067B159", hash_generated_field = "1EE07D7B37AEA69E13942B821067B159")

    AccessibilityInteractionConnectionManager mAccessibilityInteractionConnectionManager;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.922 -0500", hash_original_field = "ED6865A95E9BDB4B92489EC925B4337E", hash_generated_field = "ED6865A95E9BDB4B92489EC925B4337E")

    SendWindowContentChangedAccessibilityEvent mSendWindowContentChangedAccessibilityEvent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.925 -0500", hash_original_field = "1BC8B61E3A2F357D4B64E56AC3996805", hash_generated_field = "CB41FCB74021FD4BA0B8B886D751AB3B")

    private  int mDensity;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.927 -0500", hash_original_field = "91D8782EBDEF9C65BF9D8D5A67EE9546", hash_generated_field = "FBF46F0211B74BEC9C47C5EFFAF36A72")

    protected final InputEventConsistencyVerifier mInputEventConsistencyVerifier =
            InputEventConsistencyVerifier.isInstrumentationEnabled() ?
                    new InputEventConsistencyVerifier(this, 0) : null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.952 -0500", hash_original_field = "10088B2CBC2B251A040B12029F04A028", hash_generated_field = "93DCF807A0C07D048164002C3BB5DC84")

    private boolean mProfile = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.047 -0500", hash_original_field = "771F3E0240CB2201808586E811799152", hash_generated_field = "771F3E0240CB2201808586E811799152")

    int mHardwareYOffset;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.049 -0500", hash_original_field = "43FB9582B41438DE11C8033508791B9A", hash_generated_field = "43FB9582B41438DE11C8033508791B9A")

    int mResizeAlpha;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.051 -0500", hash_original_field = "E336AEE20C2FB053B31728E9A0373FEA", hash_generated_field = "7840CC47EC1E67F4E118E7172F117D39")

    final Paint mResizePaint = new Paint();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.308 -0500", hash_original_field = "AF2FFCD79E691AE8D5AA2A68A21816E0", hash_generated_field = "7265E6F2381DF6B2AD9FD72699DAD27A")

    private long mInputEventReceiveTimeNanos;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.311 -0500", hash_original_field = "3B87B2AB0EA6015126DB8BAD718103A2", hash_generated_field = "B12640E94E9B6FC4860989B653C215E6")

    private long mInputEventDeliverTimeNanos;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.313 -0500", hash_original_field = "CE849E84FAAB68D9FEEDF4DE5DE33ED4", hash_generated_field = "F589D3B75D0D824F988415EE16A4D910")

    private long mInputEventDeliverPostImeTimeNanos;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.316 -0500", hash_original_field = "F0693BAEB4E7B4B06466ABA19AF80A8B", hash_generated_field = "FA48E12ED3D38101FA265C33F8B4EB33")

    private InputQueue.FinishedCallback mFinishedCallback;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.016 -0400", hash_original_field = "18C98C39E8D3C77B924AFC1D76DB38D1", hash_generated_field = "10425C1D99C9B3E146C1BBB81040F9EF")

    private final InputHandler mInputHandler = new InputHandler() {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.016 -0400", hash_original_method = "DA8B85C0B97B283164189BFC107A0C51", hash_generated_method = "FF89E1B449B2A3760D958F63C22C8E1D")
        public void handleKey(KeyEvent event, InputQueue.FinishedCallback finishedCallback) {
            startInputEvent(finishedCallback);
            dispatchKey(event, true);
            addTaint(event.getTaint());
            addTaint(finishedCallback.getTaint());
            
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.016 -0400", hash_original_method = "BA251C4BE7EEF8348B6DA839AE6C5F99", hash_generated_method = "6D32680B0C65B263C80F930005E38CDC")
        public void handleMotion(MotionEvent event, InputQueue.FinishedCallback finishedCallback) {
            startInputEvent(finishedCallback);
            dispatchMotion(event, true);
            addTaint(event.getTaint());
            addTaint(finishedCallback.getTaint());
            
        }
        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.021 -0400", hash_original_field = "09A95A1FC3FF30F6E7CF942F1FC6A265", hash_generated_field = "99F32DA5E56A393932E6EDF801E99038")

    private SurfaceHolder mHolder = new SurfaceHolder() {        
        @DSSafe(DSCat.SAFE_LIST)
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.017 -0400", hash_original_method = "FB03EEF08A419E6F5E4B7D4C32AA13C8", hash_generated_method = "13BADEA14E6A49BCC17141EB1CC9ABAB")
        public Surface getSurface() {
            Surface varB4EAC82CA7396A68D541C85D26508E83_1564047814 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1564047814 = mSurface;
            varB4EAC82CA7396A68D541C85D26508E83_1564047814.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1564047814;
            
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.017 -0400", hash_original_method = "111414E0BC27432A58777D8D7A8A5313", hash_generated_method = "404CE96BADDBDD106E676659F86D0C86")
        public boolean isCreating() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_116664615 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_116664615;
            
        }
        
        @DSSafe(DSCat.SAFE_LIST)
        @DSVerified
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.017 -0400", hash_original_method = "1534EBA7EE38BC120F6309F5A1B3FF9E", hash_generated_method = "1D39A8EC720482719F771CC26E2A5136")
        public void addCallback(Callback callback) {
            callback.surfaceCreated(mHolder);
                callback.surfaceChanged(mHolder, 0, 0, 0);
                callback.surfaceDestroyed(mHolder);
                
            addTaint(callback.getTaint());
            
        }
        
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.017 -0400", hash_original_method = "1D7F6566A3906AFA0AB54EE06949ABBB", hash_generated_method = "4529A5CE4ECB0918530466545BD7FADC")
        public void removeCallback(Callback callback) {
            addTaint(callback.getTaint());
            
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.018 -0400", hash_original_method = "0FF9F7AB4B875AE8A0C5A8C3535F85C8", hash_generated_method = "D84D02E4950B7C76C7CC605634C9A5E7")
        public void setFixedSize(int width, int height) {
            addTaint(width);
            addTaint(height);
            
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.018 -0400", hash_original_method = "0794758F1C90C59C5D7A2C0BDE8FAA38", hash_generated_method = "2283705EABC76CCAA7D98B4015CCD0EC")
        public void setSizeFromLayout() {
            
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.018 -0400", hash_original_method = "CF1EA2FC05AD6DEBDFA26DEE8FD9DB43", hash_generated_method = "7A8B1BC0D08BE1C3FCDE74335C415748")
        public void setFormat(int format) {
            addTaint(format);
            
        }
        
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.018 -0400", hash_original_method = "B37A48D0CAD6F4AF8C78DA1B2A495A29", hash_generated_method = "F16672983FBE594CFFF27796E8300DE9")
        public void setType(int type) {
            addTaint(type);
            
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.019 -0400", hash_original_method = "46E48CC06FE228B4151C3D83F1499F0C", hash_generated_method = "2B4B08250D222564E5F449F984CD77F8")
        public void setKeepScreenOn(boolean screenOn) {
            addTaint(screenOn);
            
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.020 -0400", hash_original_method = "3082759B8090FD86F4392C9CC2C4FBD0", hash_generated_method = "42B586D14B6CE5A0CCC956C7A302F059")
        public Canvas lockCanvas() {
            Canvas varB4EAC82CA7396A68D541C85D26508E83_949446256 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_949446256 = null;
            varB4EAC82CA7396A68D541C85D26508E83_949446256.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_949446256;
            
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.021 -0400", hash_original_method = "3E84C9B445B974E90BE60751B0E8F5B3", hash_generated_method = "E3CA96D4EA0FD882850C6F6D5D588F7B")
        public Canvas lockCanvas(Rect dirty) {
            Canvas varB4EAC82CA7396A68D541C85D26508E83_1552549708 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1552549708 = null;
            addTaint(dirty.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1552549708.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1552549708;
            
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.021 -0400", hash_original_method = "398534786B4B68CC68F8CE8B2E298404", hash_generated_method = "069FC062D6BD12CF8E4DC29D8D01209E")
        public void unlockCanvasAndPost(Canvas canvas) {
            addTaint(canvas.getTaint());
            
        }
        
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.021 -0400", hash_original_method = "0458ACEC2C801E19AE11DF373ED70BEE", hash_generated_method = "C1182B7EEE68E099E2C5404841EDF4EE")
        public Rect getSurfaceFrame() {
            Rect varB4EAC82CA7396A68D541C85D26508E83_1346833247 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1346833247 = null;
            varB4EAC82CA7396A68D541C85D26508E83_1346833247.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1346833247;
            
        }
        
};
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.944 -0500", hash_original_method = "30AB3DC3CF45F6460C1B2C84DB6BEEC3", hash_generated_method = "E4757BAE0D71567EA982A690C178797B")
    
public ViewRootImpl(Context context) {
        super();

        if (MEASURE_LATENCY) {
            if (lt == null) {
                lt = new LatencyTimer(100, 1000);
            }
        }

        // Initialize the statics when this class is first instantiated. This is
        // done here instead of in the static block because Zygote does not
        // allow the spawning of threads.
        getWindowSession(context.getMainLooper());

        mThread = Thread.currentThread();
        mLocation = new WindowLeaked(null);
        mLocation.fillInStackTrace();
        mWidth = -1;
        mHeight = -1;
        mDirty = new Rect();
        mTempRect = new Rect();
        mVisRect = new Rect();
        mWinFrame = new Rect();
        mWindow = new W(this);
        mTargetSdkVersion = context.getApplicationInfo().targetSdkVersion;
        mInputMethodCallback = new InputMethodCallback(this);
        mViewVisibility = View.GONE;
        mTransparentRegion = new Region();
        mPreviousTransparentRegion = new Region();
        mFirst = true; // true for the first time the view is added
        mAdded = false;
        mAccessibilityManager = AccessibilityManager.getInstance(context);
        mAccessibilityInteractionConnectionManager =
            new AccessibilityInteractionConnectionManager();
        mAccessibilityManager.addAccessibilityStateChangeListener(
                mAccessibilityInteractionConnectionManager);
        mAttachInfo = new View.AttachInfo(sWindowSession, mWindow, this, this);
        mViewConfiguration = ViewConfiguration.get(context);
        mDensity = context.getResources().getDisplayMetrics().densityDpi;
        mFallbackEventHandler = PolicyManager.makeNewFallbackEventHandler(context);
        mProfileRendering = Boolean.parseBoolean(
                SystemProperties.get(PROPERTY_PROFILE_RENDERING, "false"));
    }

    /**
     * Call this to profile the next traversal call.
     * FIXME for perf testing only. Remove eventually
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.954 -0500", hash_original_method = "CC8B7F3C56C4BD3E79E20E40E6BC7183", hash_generated_method = "B9572DAF8F0CC12781E7DB4F0509BD24")
    
public void profile() {
        mProfile = true;
    }

    /**
     * We have one child
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.961 -0500", hash_original_method = "41A7A71F10D2AEAE23E30A793138BBB4", hash_generated_method = "BDE45701ED596B3B081A281E4EAA4CBA")
    
public void setView(View view, WindowManager.LayoutParams attrs, View panelParentView) {
        synchronized (this) {
            if (mView == null) {
                mView = view;
                mFallbackEventHandler.setView(view);
                mWindowAttributes.copyFrom(attrs);
                attrs = mWindowAttributes;
                
                if (view instanceof RootViewSurfaceTaker) {
                    mSurfaceHolderCallback =
                            ((RootViewSurfaceTaker)view).willYouTakeTheSurface();
                    if (mSurfaceHolderCallback != null) {
                        mSurfaceHolder = new TakenSurfaceHolder();
                        mSurfaceHolder.setFormat(PixelFormat.UNKNOWN);
                    }
                }

                CompatibilityInfo compatibilityInfo = mCompatibilityInfo.get();
                mTranslator = compatibilityInfo.getTranslator();

                // If the application owns the surface, don't enable hardware acceleration
                if (mSurfaceHolder == null) {
                    enableHardwareAcceleration(attrs);
                }

                boolean restore = false;
                if (mTranslator != null) {
                    mSurface.setCompatibilityTranslator(mTranslator);
                    restore = true;
                    attrs.backup();
                    mTranslator.translateWindowLayout(attrs);
                }
                if (DEBUG_LAYOUT) Log.d(TAG, "WindowLayout in setView:" + attrs);

                if (!compatibilityInfo.supportsScreen()) {
                    attrs.flags |= WindowManager.LayoutParams.FLAG_COMPATIBLE_WINDOW;
                    mLastInCompatMode = true;
                }

                mSoftInputMode = attrs.softInputMode;
                mWindowAttributesChanged = true;
                mWindowAttributesChangesFlag = WindowManager.LayoutParams.EVERYTHING_CHANGED;
                mAttachInfo.mRootView = view;
                mAttachInfo.mScalingRequired = mTranslator != null;
                mAttachInfo.mApplicationScale =
                        mTranslator == null ? 1.0f : mTranslator.applicationScale;
                if (panelParentView != null) {
                    mAttachInfo.mPanelParentWindowToken
                            = panelParentView.getApplicationWindowToken();
                }
                mAdded = true;
                int res; /* = WindowManagerImpl.ADD_OKAY; */

                // Schedule the first layout -before- adding to the window
                // manager, to make sure we do the relayout before receiving
                // any other events from the system.
                requestLayout();
                if ((mWindowAttributes.inputFeatures
                        & WindowManager.LayoutParams.INPUT_FEATURE_NO_INPUT_CHANNEL) == 0) {
                    mInputChannel = new InputChannel();
                }
                try {
                    mOrigWindowType = mWindowAttributes.type;
                    res = sWindowSession.add(mWindow, mSeq, mWindowAttributes,
                            getHostVisibility(), mAttachInfo.mContentInsets,
                            mInputChannel);
                } catch (RemoteException e) {
                    mAdded = false;
                    mView = null;
                    mAttachInfo.mRootView = null;
                    mInputChannel = null;
                    mFallbackEventHandler.setView(null);
                    unscheduleTraversals();
                    throw new RuntimeException("Adding window failed", e);
                } finally {
                    if (restore) {
                        attrs.restore();
                    }
                }
                
                if (mTranslator != null) {
                    mTranslator.translateRectInScreenToAppWindow(mAttachInfo.mContentInsets);
                }
                mPendingContentInsets.set(mAttachInfo.mContentInsets);
                mPendingVisibleInsets.set(0, 0, 0, 0);
                if (DEBUG_LAYOUT) Log.v(TAG, "Added window " + mWindow);
                if (res < WindowManagerImpl.ADD_OKAY) {
                    mView = null;
                    mAttachInfo.mRootView = null;
                    mAdded = false;
                    mFallbackEventHandler.setView(null);
                    unscheduleTraversals();
                    switch (res) {
                        case WindowManagerImpl.ADD_BAD_APP_TOKEN:
                        case WindowManagerImpl.ADD_BAD_SUBWINDOW_TOKEN:
                            throw new WindowManagerImpl.BadTokenException(
                                "Unable to add window -- token " + attrs.token
                                + " is not valid; is your activity running?");
                        case WindowManagerImpl.ADD_NOT_APP_TOKEN:
                            throw new WindowManagerImpl.BadTokenException(
                                "Unable to add window -- token " + attrs.token
                                + " is not for an application");
                        case WindowManagerImpl.ADD_APP_EXITING:
                            throw new WindowManagerImpl.BadTokenException(
                                "Unable to add window -- app for token " + attrs.token
                                + " is exiting");
                        case WindowManagerImpl.ADD_DUPLICATE_ADD:
                            throw new WindowManagerImpl.BadTokenException(
                                "Unable to add window -- window " + mWindow
                                + " has already been added");
                        case WindowManagerImpl.ADD_STARTING_NOT_NEEDED:
                            // Silently ignore -- we would have just removed it
                            // right away, anyway.
                            return;
                        case WindowManagerImpl.ADD_MULTIPLE_SINGLETON:
                            throw new WindowManagerImpl.BadTokenException(
                                "Unable to add window " + mWindow +
                                " -- another window of this type already exists");
                        case WindowManagerImpl.ADD_PERMISSION_DENIED:
                            throw new WindowManagerImpl.BadTokenException(
                                "Unable to add window " + mWindow +
                                " -- permission denied for this window type");
                    }
                    throw new RuntimeException(
                        "Unable to add window -- unknown error code " + res);
                }

                if (view instanceof RootViewSurfaceTaker) {
                    mInputQueueCallback =
                        ((RootViewSurfaceTaker)view).willYouTakeTheInputQueue();
                }
                if (mInputChannel != null) {
                    if (mInputQueueCallback != null) {
                        mInputQueue = new InputQueue(mInputChannel);
                        mInputQueueCallback.onInputQueueCreated(mInputQueue);
                    } else {
                        InputQueue.registerInputChannel(mInputChannel, mInputHandler,
                                Looper.myQueue());
                    }
                }

                view.assignParent(this);
                mAddedTouchMode = (res&WindowManagerImpl.ADD_FLAG_IN_TOUCH_MODE) != 0;
                mAppVisible = (res&WindowManagerImpl.ADD_FLAG_APP_VISIBLE) != 0;

                if (mAccessibilityManager.isEnabled()) {
                    mAccessibilityInteractionConnectionManager.ensureConnection();
                }
            }
        }
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.964 -0500", hash_original_method = "CB86722DA8E467DDCEDA5A630CA3194B", hash_generated_method = "CB86722DA8E467DDCEDA5A630CA3194B")
    
void destroyHardwareResources() {
        if (mAttachInfo.mHardwareRenderer != null) {
            if (mAttachInfo.mHardwareRenderer.isEnabled()) {
                mAttachInfo.mHardwareRenderer.destroyLayers(mView);
            }
            mAttachInfo.mHardwareRenderer.destroy(false);
        }
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.966 -0500", hash_original_method = "E3F9E04A5716D71423EBE08431EEB223", hash_generated_method = "E3F9E04A5716D71423EBE08431EEB223")
    
void terminateHardwareResources() {
        if (mAttachInfo.mHardwareRenderer != null) {
            mAttachInfo.mHardwareRenderer.destroyHardwareResources(mView);
            mAttachInfo.mHardwareRenderer.destroy(false);
        }
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.968 -0500", hash_original_method = "E840B8B43E5ABE6BE2D8F4EA2D3CA2C1", hash_generated_method = "E840B8B43E5ABE6BE2D8F4EA2D3CA2C1")
    
void destroyHardwareLayers() {
        if (mThread != Thread.currentThread()) {
            if (mAttachInfo.mHardwareRenderer != null &&
                    mAttachInfo.mHardwareRenderer.isEnabled()) {
                HardwareRenderer.trimMemory(ComponentCallbacks2.TRIM_MEMORY_MODERATE);
            }
        } else {
            if (mAttachInfo.mHardwareRenderer != null &&
                    mAttachInfo.mHardwareRenderer.isEnabled()) {
                mAttachInfo.mHardwareRenderer.destroyLayers(mView);
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.973 -0500", hash_original_method = "645D4C027059B67B04B5E1D1CDD7444E", hash_generated_method = "9EEEE8BC0912E2A29089D5303E244C15")
    
private void enableHardwareAcceleration(WindowManager.LayoutParams attrs) {
        mAttachInfo.mHardwareAccelerated = false;
        mAttachInfo.mHardwareAccelerationRequested = false;

        // Don't enable hardware acceleration when the application is in compatibility mode
        if (mTranslator != null) return;

        // Try to enable hardware acceleration if requested
        final boolean hardwareAccelerated = 
                (attrs.flags & WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED) != 0;

        if (hardwareAccelerated) {
            if (!HardwareRenderer.isAvailable()) {
                return;
            }

            // Persistent processes (including the system) should not do
            // accelerated rendering on low-end devices.  In that case,
            // sRendererDisabled will be set.  In addition, the system process
            // itself should never do accelerated rendering.  In that case, both
            // sRendererDisabled and sSystemRendererDisabled are set.  When
            // sSystemRendererDisabled is set, PRIVATE_FLAG_FORCE_HARDWARE_ACCELERATED
            // can be used by code on the system process to escape that and enable
            // HW accelerated drawing.  (This is basically for the lock screen.)

            final boolean fakeHwAccelerated = (attrs.privateFlags &
                    WindowManager.LayoutParams.PRIVATE_FLAG_FAKE_HARDWARE_ACCELERATED) != 0;
            final boolean forceHwAccelerated = (attrs.privateFlags &
                    WindowManager.LayoutParams.PRIVATE_FLAG_FORCE_HARDWARE_ACCELERATED) != 0;

            if (!HardwareRenderer.sRendererDisabled || (HardwareRenderer.sSystemRendererDisabled
                    && forceHwAccelerated)) {
                // Don't enable hardware acceleration when we're not on the main thread
                if (!HardwareRenderer.sSystemRendererDisabled
                        && Looper.getMainLooper() != Looper.myLooper()) {
                    Log.w(HardwareRenderer.LOG_TAG, "Attempting to initialize hardware "
                            + "acceleration outside of the main thread, aborting");
                    return;
                }

                final boolean translucent = attrs.format != PixelFormat.OPAQUE;
                if (mAttachInfo.mHardwareRenderer != null) {
                    mAttachInfo.mHardwareRenderer.destroy(true);
                }                
                mAttachInfo.mHardwareRenderer = HardwareRenderer.createGlRenderer(2, translucent);
                mAttachInfo.mHardwareAccelerated = mAttachInfo.mHardwareAccelerationRequested
                        = mAttachInfo.mHardwareRenderer != null;
            } else if (fakeHwAccelerated) {
                // The window had wanted to use hardware acceleration, but this
                // is not allowed in its process.  By setting this flag, it can
                // still render as if it was accelerated.  This is basically for
                // the preview windows the window manager shows for launching
                // applications, so they will look more like the app being launched.
                mAttachInfo.mHardwareAccelerationRequested = true;
            }
        }
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.975 -0500", hash_original_method = "23562CAF30DEA91689886E5D0DFB3D0F", hash_generated_method = "08E70AA8D2F1647EC2EEAF8AC8218386")
    
public View getView() {
        return mView;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.977 -0500", hash_original_method = "6C3085A5B27688C16B5F48D71E61D048", hash_generated_method = "4D88FED1FAE2FE688EFF93CB94610127")
    
final WindowLeaked getLocation() {
        return mLocation;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.979 -0500", hash_original_method = "344B8CEF50FED73B6C66A984FDFE543C", hash_generated_method = "E9F3C9F201DB80BF91EC11E0A4BCA35B")
    
void setLayoutParams(WindowManager.LayoutParams attrs, boolean newView) {
        synchronized (this) {
            int oldSoftInputMode = mWindowAttributes.softInputMode;
            // preserve compatible window flag if exists.
            int compatibleWindowFlag =
                mWindowAttributes.flags & WindowManager.LayoutParams.FLAG_COMPATIBLE_WINDOW;
            mWindowAttributesChangesFlag = mWindowAttributes.copyFrom(attrs);
            mWindowAttributes.flags |= compatibleWindowFlag;
            
            if (newView) {
                mSoftInputMode = attrs.softInputMode;
                requestLayout();
            }
            // Don't lose the mode we last auto-computed.
            if ((attrs.softInputMode&WindowManager.LayoutParams.SOFT_INPUT_MASK_ADJUST)
                    == WindowManager.LayoutParams.SOFT_INPUT_ADJUST_UNSPECIFIED) {
                mWindowAttributes.softInputMode = (mWindowAttributes.softInputMode
                        & ~WindowManager.LayoutParams.SOFT_INPUT_MASK_ADJUST)
                        | (oldSoftInputMode
                                & WindowManager.LayoutParams.SOFT_INPUT_MASK_ADJUST);
            }
            mWindowAttributesChanged = true;
            scheduleTraversals();
        }
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.981 -0500", hash_original_method = "F0FE5EE4E253DD8DC552809A1CA2533F", hash_generated_method = "F0FE5EE4E253DD8DC552809A1CA2533F")
    
void handleAppVisibility(boolean visible) {
        if (mAppVisible != visible) {
            mAppVisible = visible;
            scheduleTraversals();
        }
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.983 -0500", hash_original_method = "18299B4078E7C7C61849ACAFD8526C89", hash_generated_method = "18299B4078E7C7C61849ACAFD8526C89")
    
void handleGetNewSurface() {
        mNewSurfaceNeeded = true;
        mFullRedrawNeeded = true;
        scheduleTraversals();
    }

    /**
     * {@inheritDoc}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.986 -0500", hash_original_method = "A2905530B195FBB19B3C3F0AC663BF20", hash_generated_method = "CD4E51320EE3CCF161B8F00ED648373E")
    
public void requestLayout() {
        checkThread();
        mLayoutRequested = true;
        scheduleTraversals();
    }

    /**
     * {@inheritDoc}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.989 -0500", hash_original_method = "13F945759D2C310C5D0BB68B6FB1E2B8", hash_generated_method = "5A353148C751BB169393605E36F6111B")
    
public boolean isLayoutRequested() {
        return mLayoutRequested;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.991 -0500", hash_original_method = "1BB28848D4C8EEFEA34E8E46FE6AC5D5", hash_generated_method = "8EE82813938E793D33C86AE362840C0D")
    
public void invalidateChild(View child, Rect dirty) {
        checkThread();
        if (DEBUG_DRAW) Log.v(TAG, "Invalidate child: " + dirty);
        if (dirty == null) {
            // Fast invalidation for GL-enabled applications; GL must redraw everything
            invalidate();
            return;
        }
        if (mCurScrollY != 0 || mTranslator != null) {
            mTempRect.set(dirty);
            dirty = mTempRect;
            if (mCurScrollY != 0) {
               dirty.offset(0, -mCurScrollY);
            }
            if (mTranslator != null) {
                mTranslator.translateRectInAppWindowToScreen(dirty);
            }
            if (mAttachInfo.mScalingRequired) {
                dirty.inset(-1, -1);
            }
        }
        if (!mDirty.isEmpty() && !mDirty.contains(dirty)) {
            mAttachInfo.mSetIgnoreDirtyState = true;
            mAttachInfo.mIgnoreDirtyState = true;
        }
        mDirty.union(dirty);
        if (!mWillDrawSoon) {
            scheduleTraversals();
        }
    }
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.994 -0500", hash_original_method = "813AAD1E42CFCCC731AB301BBB74FC18", hash_generated_method = "813AAD1E42CFCCC731AB301BBB74FC18")
    
void invalidate() {
        mDirty.set(0, 0, mWidth, mHeight);
        scheduleTraversals();
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.996 -0500", hash_original_method = "081DD37813B858E5AB3FA0820EF5D835", hash_generated_method = "081DD37813B858E5AB3FA0820EF5D835")
    
void setStopped(boolean stopped) {
        if (mStopped != stopped) {
            mStopped = stopped;
            if (!stopped) {
                scheduleTraversals();
            }
        }
    }
    
    @DSSafe(DSCat.GUI)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.998 -0500", hash_original_method = "DCC308262D5800610A000228CF8970A4", hash_generated_method = "B63E6487D1CD4BEC29A92A9071D59DCB")
    
public ViewParent getParent() {
        return null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.000 -0500", hash_original_method = "67B0199062309B0E78F2F88E3E2AD59A", hash_generated_method = "022A7B8E71B5CC5F5FF6A87B995D9293")
    
public ViewParent invalidateChildInParent(final int[] location, final Rect dirty) {
        invalidateChild(null, dirty);
        return null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.003 -0500", hash_original_method = "FB92C76BB083D5DC37740C978F02B71C", hash_generated_method = "33C22C73C4FB3E56F033E5E3E7561BC5")
    
public boolean getChildVisibleRect(View child, Rect r, android.graphics.Point offset) {
        if (child != mView) {
            throw new RuntimeException("child is not mine, honest!");
        }
        // Note: don't apply scroll offset, because we want to know its
        // visibility in the virtual canvas being given to the view hierarchy.
        return r.intersect(0, 0, mWidth, mHeight);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.005 -0500", hash_original_method = "57451ED91AC07EA69FA21499971D2B45", hash_generated_method = "09FDD2814C6B223622B21B20375DADFD")
    
public void bringChildToFront(View child) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.008 -0500", hash_original_method = "0E9A2AD60F5B60B1A096C27CF046877D", hash_generated_method = "6B1DBEAB0B883495A8FBE68DCD7B7D01")
    
public void scheduleTraversals() {
        if (!mTraversalScheduled) {
            mTraversalScheduled = true;

            //noinspection ConstantConditions
            if (ViewDebug.DEBUG_LATENCY && mLastTraversalFinishedTimeNanos != 0) {
                final long now = System.nanoTime();
                Log.d(TAG, "Latency: Scheduled traversal, it has been "
                        + ((now - mLastTraversalFinishedTimeNanos) * 0.000001f)
                        + "ms since the last traversal finished.");
            }

            sendEmptyMessage(DO_TRAVERSAL);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.011 -0500", hash_original_method = "0B26D78664F51D8793A6008ECDA459E7", hash_generated_method = "FB0AC3AC73486009F3E7E85671BFAB88")
    
public void unscheduleTraversals() {
        if (mTraversalScheduled) {
            mTraversalScheduled = false;
            removeMessages(DO_TRAVERSAL);
        }
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.013 -0500", hash_original_method = "27A276950AD49DC3B2BCAC57214867E1", hash_generated_method = "27A276950AD49DC3B2BCAC57214867E1")
    
int getHostVisibility() {
        return mAppVisible ? mView.getVisibility() : View.GONE;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.015 -0500", hash_original_method = "4A37F94A433BB0C51ABAD4CD2013B711", hash_generated_method = "4A37F94A433BB0C51ABAD4CD2013B711")
    
void disposeResizeBuffer() {
        if (mResizeBuffer != null) {
            mResizeBuffer.destroy();
            mResizeBuffer = null;
        }
    }

    /**
     * Add LayoutTransition to the list of transitions to be started in the next traversal.
     * This list will be cleared after the transitions on the list are start()'ed. These
     * transitionsa re added by LayoutTransition itself when it sets up animations. The setup
     * happens during the layout phase of traversal, which we want to complete before any of the
     * animations are started (because those animations may side-effect properties that layout
     * depends upon, like the bounding rectangles of the affected views). So we add the transition
     * to the list and it is started just prior to starting the drawing phase of traversal.
     *
     * @param transition The LayoutTransition to be started on the next traversal.
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.018 -0500", hash_original_method = "9CCD20C4D5BE58E51524A629AA69C9DE", hash_generated_method = "3C668B4D56050A6BE5D8C9DE29FE2933")
    
public void requestTransitionStart(LayoutTransition transition) {
        if (mPendingTransitions == null || !mPendingTransitions.contains(transition)) {
            if (mPendingTransitions == null) {
                 mPendingTransitions = new ArrayList<LayoutTransition>();
            }
            mPendingTransitions.add(transition);
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.020 -0500", hash_original_method = "E06FBD8158D133D090EB34C23F0C9FD1", hash_generated_method = "08E9B8B3415110106B705E697BCF4915")
    
private void processInputEvents(boolean outOfOrder) {
        while (mPendingInputEvents != null) {
            handleMessage(mPendingInputEvents.mMessage);
            InputEventMessage tmpMessage = mPendingInputEvents;
            mPendingInputEvents = mPendingInputEvents.mNext;
            tmpMessage.recycle();
            if (outOfOrder) {
                removeMessages(PROCESS_INPUT_EVENTS);
            }
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.037 -0500", hash_original_method = "DF10FEADFB061504FA9A2B620C341C55", hash_generated_method = "0AB5384548735373AC67A439506317F7")
    
private void performTraversals() {
        // cache mView since it is used so much below...
        final View host = mView;

        processInputEvents(true);

        if (DBG) {
            System.out.println("======================================");
            System.out.println("performTraversals");
            host.debug();
        }

        if (host == null || !mAdded)
            return;

        mTraversalScheduled = false;
        mWillDrawSoon = true;
        boolean windowSizeMayChange = false;
        boolean fullRedrawNeeded = mFullRedrawNeeded;
        boolean newSurface = false;
        boolean surfaceChanged = false;
        WindowManager.LayoutParams lp = mWindowAttributes;

        int desiredWindowWidth;
        int desiredWindowHeight;
        int childWidthMeasureSpec;
        int childHeightMeasureSpec;

        final View.AttachInfo attachInfo = mAttachInfo;

        final int viewVisibility = getHostVisibility();
        boolean viewVisibilityChanged = mViewVisibility != viewVisibility
                || mNewSurfaceNeeded;

        WindowManager.LayoutParams params = null;
        if (mWindowAttributesChanged) {
            mWindowAttributesChanged = false;
            surfaceChanged = true;
            params = lp;
        }
        CompatibilityInfo compatibilityInfo = mCompatibilityInfo.get();
        if (compatibilityInfo.supportsScreen() == mLastInCompatMode) {
            params = lp;
            fullRedrawNeeded = true;
            mLayoutRequested = true;
            if (mLastInCompatMode) {
                params.flags &= ~WindowManager.LayoutParams.FLAG_COMPATIBLE_WINDOW;
                mLastInCompatMode = false;
            } else {
                params.flags |= WindowManager.LayoutParams.FLAG_COMPATIBLE_WINDOW;
                mLastInCompatMode = true;
            }
        }
        
        mWindowAttributesChangesFlag = 0;
        
        Rect frame = mWinFrame;
        if (mFirst) {
            fullRedrawNeeded = true;
            mLayoutRequested = true;

            if (lp.type == WindowManager.LayoutParams.TYPE_STATUS_BAR_PANEL) {
                // NOTE -- system code, won't try to do compat mode.
                Display disp = WindowManagerImpl.getDefault().getDefaultDisplay();
                Point size = new Point();
                disp.getRealSize(size);
                desiredWindowWidth = size.x;
                desiredWindowHeight = size.y;
            } else {
                DisplayMetrics packageMetrics =
                    mView.getContext().getResources().getDisplayMetrics();
                desiredWindowWidth = packageMetrics.widthPixels;
                desiredWindowHeight = packageMetrics.heightPixels;
            }

            // For the very first time, tell the view hierarchy that it
            // is attached to the window.  Note that at this point the surface
            // object is not initialized to its backing store, but soon it
            // will be (assuming the window is visible).
            attachInfo.mSurface = mSurface;
            // We used to use the following condition to choose 32 bits drawing caches:
            // PixelFormat.hasAlpha(lp.format) || lp.format == PixelFormat.RGBX_8888
            // However, windows are now always 32 bits by default, so choose 32 bits
            attachInfo.mUse32BitDrawingCache = true;
            attachInfo.mHasWindowFocus = false;
            attachInfo.mWindowVisibility = viewVisibility;
            attachInfo.mRecomputeGlobalAttributes = false;
            attachInfo.mKeepScreenOn = false;
            attachInfo.mSystemUiVisibility = 0;
            viewVisibilityChanged = false;
            mLastConfiguration.setTo(host.getResources().getConfiguration());
            host.dispatchAttachedToWindow(attachInfo, 0);
            //Log.i(TAG, "Screen on initialized: " + attachInfo.mKeepScreenOn);

            host.fitSystemWindows(mAttachInfo.mContentInsets);

        } else {
            desiredWindowWidth = frame.width();
            desiredWindowHeight = frame.height();
            if (desiredWindowWidth != mWidth || desiredWindowHeight != mHeight) {
                if (DEBUG_ORIENTATION) Log.v(TAG,
                        "View " + host + " resized to: " + frame);
                fullRedrawNeeded = true;
                mLayoutRequested = true;
                windowSizeMayChange = true;
            }
        }

        if (viewVisibilityChanged) {
            attachInfo.mWindowVisibility = viewVisibility;
            host.dispatchWindowVisibilityChanged(viewVisibility);
            if (viewVisibility != View.VISIBLE || mNewSurfaceNeeded) {
                destroyHardwareResources();
            }
            if (viewVisibility == View.GONE) {
                // After making a window gone, we will count it as being
                // shown for the first time the next time it gets focus.
                mHasHadWindowFocus = false;
            }
        }

        boolean insetsChanged = false;

        if (mLayoutRequested && !mStopped) {
            // Execute enqueued actions on every layout in case a view that was detached
            // enqueued an action after being detached
            getRunQueue().executeActions(attachInfo.mHandler);

            final Resources res = mView.getContext().getResources();

            if (mFirst) {
                // make sure touch mode code executes by setting cached value
                // to opposite of the added touch mode.
                mAttachInfo.mInTouchMode = !mAddedTouchMode;
                ensureTouchModeLocally(mAddedTouchMode);
            } else {
                if (!mPendingContentInsets.equals(mAttachInfo.mContentInsets)) {
                    insetsChanged = true;
                }
                if (!mPendingVisibleInsets.equals(mAttachInfo.mVisibleInsets)) {
                    mAttachInfo.mVisibleInsets.set(mPendingVisibleInsets);
                    if (DEBUG_LAYOUT) Log.v(TAG, "Visible insets changing to: "
                            + mAttachInfo.mVisibleInsets);
                }
                if (lp.width == ViewGroup.LayoutParams.WRAP_CONTENT
                        || lp.height == ViewGroup.LayoutParams.WRAP_CONTENT) {
                    windowSizeMayChange = true;

                    if (lp.type == WindowManager.LayoutParams.TYPE_STATUS_BAR_PANEL) {
                        // NOTE -- system code, won't try to do compat mode.
                        Display disp = WindowManagerImpl.getDefault().getDefaultDisplay();
                        Point size = new Point();
                        disp.getRealSize(size);
                        desiredWindowWidth = size.x;
                        desiredWindowHeight = size.y;
                    } else {
                        DisplayMetrics packageMetrics = res.getDisplayMetrics();
                        desiredWindowWidth = packageMetrics.widthPixels;
                        desiredWindowHeight = packageMetrics.heightPixels;
                    }
                }
            }

            // Ask host how big it wants to be
            if (DEBUG_ORIENTATION || DEBUG_LAYOUT) Log.v(TAG,
                    "Measuring " + host + " in display " + desiredWindowWidth
                    + "x" + desiredWindowHeight + "...");

            boolean goodMeasure = false;
            if (lp.width == ViewGroup.LayoutParams.WRAP_CONTENT) {
                // On large screens, we don't want to allow dialogs to just
                // stretch to fill the entire width of the screen to display
                // one line of text.  First try doing the layout at a smaller
                // size to see if it will fit.
                final DisplayMetrics packageMetrics = res.getDisplayMetrics();
                res.getValue(com.android.internal.R.dimen.config_prefDialogWidth, mTmpValue, true);
                int baseSize = 0;
                if (mTmpValue.type == TypedValue.TYPE_DIMENSION) {
                    baseSize = (int)mTmpValue.getDimension(packageMetrics);
                }
                if (DEBUG_DIALOG) Log.v(TAG, "Window " + mView + ": baseSize=" + baseSize);
                if (baseSize != 0 && desiredWindowWidth > baseSize) {
                    childWidthMeasureSpec = getRootMeasureSpec(baseSize, lp.width);
                    childHeightMeasureSpec = getRootMeasureSpec(desiredWindowHeight, lp.height);
                    host.measure(childWidthMeasureSpec, childHeightMeasureSpec);
                    if (DEBUG_DIALOG) Log.v(TAG, "Window " + mView + ": measured ("
                            + host.getMeasuredWidth() + "," + host.getMeasuredHeight() + ")");
                    if ((host.getMeasuredWidthAndState()&View.MEASURED_STATE_TOO_SMALL) == 0) {
                        goodMeasure = true;
                    } else {
                        // Didn't fit in that size... try expanding a bit.
                        baseSize = (baseSize+desiredWindowWidth)/2;
                        if (DEBUG_DIALOG) Log.v(TAG, "Window " + mView + ": next baseSize="
                                + baseSize);
                        childWidthMeasureSpec = getRootMeasureSpec(baseSize, lp.width);
                        host.measure(childWidthMeasureSpec, childHeightMeasureSpec);
                        if (DEBUG_DIALOG) Log.v(TAG, "Window " + mView + ": measured ("
                                + host.getMeasuredWidth() + "," + host.getMeasuredHeight() + ")");
                        if ((host.getMeasuredWidthAndState()&View.MEASURED_STATE_TOO_SMALL) == 0) {
                            if (DEBUG_DIALOG) Log.v(TAG, "Good!");
                            goodMeasure = true;
                        }
                    }
                }
            }

            if (!goodMeasure) {
                childWidthMeasureSpec = getRootMeasureSpec(desiredWindowWidth, lp.width);
                childHeightMeasureSpec = getRootMeasureSpec(desiredWindowHeight, lp.height);
                host.measure(childWidthMeasureSpec, childHeightMeasureSpec);
                if (mWidth != host.getMeasuredWidth() || mHeight != host.getMeasuredHeight()) {
                    windowSizeMayChange = true;
                }
            }

            if (DBG) {
                System.out.println("======================================");
                System.out.println("performTraversals -- after measure");
                host.debug();
            }
        }

        if (attachInfo.mRecomputeGlobalAttributes && host.mAttachInfo != null) {
            //Log.i(TAG, "Computing view hierarchy attributes!");
            attachInfo.mRecomputeGlobalAttributes = false;
            boolean oldScreenOn = attachInfo.mKeepScreenOn;
            int oldVis = attachInfo.mSystemUiVisibility;
            boolean oldHasSystemUiListeners = attachInfo.mHasSystemUiListeners;
            attachInfo.mKeepScreenOn = false;
            attachInfo.mSystemUiVisibility = 0;
            attachInfo.mHasSystemUiListeners = false;
            host.dispatchCollectViewAttributes(0);
            if (attachInfo.mKeepScreenOn != oldScreenOn
                    || attachInfo.mSystemUiVisibility != oldVis
                    || attachInfo.mHasSystemUiListeners != oldHasSystemUiListeners) {
                params = lp;
            }
        }
        if (attachInfo.mForceReportNewAttributes) {
            attachInfo.mForceReportNewAttributes = false;
            params = lp;
        }

        if (mFirst || attachInfo.mViewVisibilityChanged) {
            attachInfo.mViewVisibilityChanged = false;
            int resizeMode = mSoftInputMode &
                    WindowManager.LayoutParams.SOFT_INPUT_MASK_ADJUST;
            // If we are in auto resize mode, then we need to determine
            // what mode to use now.
            if (resizeMode == WindowManager.LayoutParams.SOFT_INPUT_ADJUST_UNSPECIFIED) {
                final int N = attachInfo.mScrollContainers.size();
                for (int i=0; i<N; i++) {
                    if (attachInfo.mScrollContainers.get(i).isShown()) {
                        resizeMode = WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE;
                    }
                }
                if (resizeMode == 0) {
                    resizeMode = WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN;
                }
                if ((lp.softInputMode &
                        WindowManager.LayoutParams.SOFT_INPUT_MASK_ADJUST) != resizeMode) {
                    lp.softInputMode = (lp.softInputMode &
                            ~WindowManager.LayoutParams.SOFT_INPUT_MASK_ADJUST) |
                            resizeMode;
                    params = lp;
                }
            }
        }

        if (params != null && (host.mPrivateFlags & View.REQUEST_TRANSPARENT_REGIONS) != 0) {
            if (!PixelFormat.formatHasAlpha(params.format)) {
                params.format = PixelFormat.TRANSLUCENT;
            }
        }

        boolean windowShouldResize = mLayoutRequested && windowSizeMayChange
            && ((mWidth != host.getMeasuredWidth() || mHeight != host.getMeasuredHeight())
                || (lp.width == ViewGroup.LayoutParams.WRAP_CONTENT &&
                        frame.width() < desiredWindowWidth && frame.width() != mWidth)
                || (lp.height == ViewGroup.LayoutParams.WRAP_CONTENT &&
                        frame.height() < desiredWindowHeight && frame.height() != mHeight));

        final boolean computesInternalInsets =
                attachInfo.mTreeObserver.hasComputeInternalInsetsListeners();

        boolean insetsPending = false;
        int relayoutResult = 0;

        if (mFirst || windowShouldResize || insetsChanged ||
                viewVisibilityChanged || params != null) {

            if (viewVisibility == View.VISIBLE) {
                // If this window is giving internal insets to the window
                // manager, and it is being added or changing its visibility,
                // then we want to first give the window manager "fake"
                // insets to cause it to effectively ignore the content of
                // the window during layout.  This avoids it briefly causing
                // other windows to resize/move based on the raw frame of the
                // window, waiting until we can finish laying out this window
                // and get back to the window manager with the ultimately
                // computed insets.
                insetsPending = computesInternalInsets && (mFirst || viewVisibilityChanged);
            }

            if (mSurfaceHolder != null) {
                mSurfaceHolder.mSurfaceLock.lock();
                mDrawingAllowed = true;
            }

            boolean hwInitialized = false;
            boolean contentInsetsChanged = false;
            boolean visibleInsetsChanged;
            boolean hadSurface = mSurface.isValid();

            try {
                int fl = 0;
                if (params != null) {
                    fl = params.flags;
                    if (attachInfo.mKeepScreenOn) {
                        params.flags |= WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON;
                    }
                    params.subtreeSystemUiVisibility = attachInfo.mSystemUiVisibility;
                    params.hasSystemUiListeners = attachInfo.mHasSystemUiListeners;
                }
                if (DEBUG_LAYOUT) {
                    Log.i(TAG, "host=w:" + host.getMeasuredWidth() + ", h:" +
                            host.getMeasuredHeight() + ", params=" + params);
                }

                final int surfaceGenerationId = mSurface.getGenerationId();
                relayoutResult = relayoutWindow(params, viewVisibility, insetsPending);

                if (params != null) {
                    params.flags = fl;
                }

                if (DEBUG_LAYOUT) Log.v(TAG, "relayout: frame=" + frame.toShortString()
                        + " content=" + mPendingContentInsets.toShortString()
                        + " visible=" + mPendingVisibleInsets.toShortString()
                        + " surface=" + mSurface);

                if (mPendingConfiguration.seq != 0) {
                    if (DEBUG_CONFIGURATION) Log.v(TAG, "Visible with new config: "
                            + mPendingConfiguration);
                    updateConfiguration(mPendingConfiguration, !mFirst);
                    mPendingConfiguration.seq = 0;
                }
                
                contentInsetsChanged = !mPendingContentInsets.equals(
                        mAttachInfo.mContentInsets);
                visibleInsetsChanged = !mPendingVisibleInsets.equals(
                        mAttachInfo.mVisibleInsets);
                if (contentInsetsChanged) {
                    if (mWidth > 0 && mHeight > 0 &&
                            mSurface != null && mSurface.isValid() &&
                            !mAttachInfo.mTurnOffWindowResizeAnim &&
                            mAttachInfo.mHardwareRenderer != null &&
                            mAttachInfo.mHardwareRenderer.isEnabled() &&
                            mAttachInfo.mHardwareRenderer.validate() &&
                            lp != null && !PixelFormat.formatHasAlpha(lp.format)) {

                        disposeResizeBuffer();

                        boolean completed = false;
                        HardwareCanvas hwRendererCanvas = mAttachInfo.mHardwareRenderer.getCanvas();
                        HardwareCanvas layerCanvas = null;
                        try {
                            if (mResizeBuffer == null) {
                                mResizeBuffer = mAttachInfo.mHardwareRenderer.createHardwareLayer(
                                        mWidth, mHeight, false);
                            } else if (mResizeBuffer.getWidth() != mWidth ||
                                    mResizeBuffer.getHeight() != mHeight) {
                                mResizeBuffer.resize(mWidth, mHeight);
                            }
                            layerCanvas = mResizeBuffer.start(hwRendererCanvas);
                            layerCanvas.setViewport(mWidth, mHeight);
                            layerCanvas.onPreDraw(null);
                            final int restoreCount = layerCanvas.save();
                            
                            layerCanvas.drawColor(0xff000000, PorterDuff.Mode.SRC);

                            int yoff;
                            final boolean scrolling = mScroller != null
                                    && mScroller.computeScrollOffset();
                            if (scrolling) {
                                yoff = mScroller.getCurrY();
                                mScroller.abortAnimation();
                            } else {
                                yoff = mScrollY;
                            }

                            layerCanvas.translate(0, -yoff);
                            if (mTranslator != null) {
                                mTranslator.translateCanvas(layerCanvas);
                            }

                            mView.draw(layerCanvas);

                            mResizeBufferStartTime = SystemClock.uptimeMillis();
                            mResizeBufferDuration = mView.getResources().getInteger(
                                    com.android.internal.R.integer.config_mediumAnimTime);
                            completed = true;

                            layerCanvas.restoreToCount(restoreCount);
                        } catch (OutOfMemoryError e) {
                            Log.w(TAG, "Not enough memory for content change anim buffer", e);
                        } finally {
                            if (layerCanvas != null) {
                                layerCanvas.onPostDraw();
                            }
                            if (mResizeBuffer != null) {
                                mResizeBuffer.end(hwRendererCanvas);
                                if (!completed) {
                                    mResizeBuffer.destroy();
                                    mResizeBuffer = null;
                                }
                            }
                        }
                    }
                    mAttachInfo.mContentInsets.set(mPendingContentInsets);
                    host.fitSystemWindows(mAttachInfo.mContentInsets);
                    if (DEBUG_LAYOUT) Log.v(TAG, "Content insets changing to: "
                            + mAttachInfo.mContentInsets);
                }
                if (visibleInsetsChanged) {
                    mAttachInfo.mVisibleInsets.set(mPendingVisibleInsets);
                    if (DEBUG_LAYOUT) Log.v(TAG, "Visible insets changing to: "
                            + mAttachInfo.mVisibleInsets);
                }

                if (!hadSurface) {
                    if (mSurface.isValid()) {
                        // If we are creating a new surface, then we need to
                        // completely redraw it.  Also, when we get to the
                        // point of drawing it we will hold off and schedule
                        // a new traversal instead.  This is so we can tell the
                        // window manager about all of the windows being displayed
                        // before actually drawing them, so it can display then
                        // all at once.
                        newSurface = true;
                        fullRedrawNeeded = true;
                        mPreviousTransparentRegion.setEmpty();

                        if (mAttachInfo.mHardwareRenderer != null) {
                            try {
                                hwInitialized = mAttachInfo.mHardwareRenderer.initialize(mHolder);
                            } catch (Surface.OutOfResourcesException e) {
                                Log.e(TAG, "OutOfResourcesException initializing HW surface", e);
                                try {
                                    if (!sWindowSession.outOfMemory(mWindow)) {
                                        Slog.w(TAG, "No processes killed for memory; killing self");
                                        Process.killProcess(Process.myPid());
                                    }
                                } catch (RemoteException ex) {
                                }
                                mLayoutRequested = true;    // ask wm for a new surface next time.
                                return;
                            }
                        }
                    }
                } else if (!mSurface.isValid()) {
                    // If the surface has been removed, then reset the scroll
                    // positions.
                    mLastScrolledFocus = null;
                    mScrollY = mCurScrollY = 0;
                    if (mScroller != null) {
                        mScroller.abortAnimation();
                    }
                    disposeResizeBuffer();
                    // Our surface is gone
                    if (mAttachInfo.mHardwareRenderer != null &&
                            mAttachInfo.mHardwareRenderer.isEnabled()) {
                        mAttachInfo.mHardwareRenderer.destroy(true);
                    }
                } else if (surfaceGenerationId != mSurface.getGenerationId() &&
                        mSurfaceHolder == null && mAttachInfo.mHardwareRenderer != null) {
                    fullRedrawNeeded = true;
                    try {
                        mAttachInfo.mHardwareRenderer.updateSurface(mHolder);
                    } catch (Surface.OutOfResourcesException e) {
                        Log.e(TAG, "OutOfResourcesException updating HW surface", e);
                        try {
                            if (!sWindowSession.outOfMemory(mWindow)) {
                                Slog.w(TAG, "No processes killed for memory; killing self");
                                Process.killProcess(Process.myPid());
                            }
                        } catch (RemoteException ex) {
                        }
                        mLayoutRequested = true;    // ask wm for a new surface next time.
                        return;
                    }
                }
            } catch (RemoteException e) {
            }

            if (DEBUG_ORIENTATION) Log.v(
                    TAG, "Relayout returned: frame=" + frame + ", surface=" + mSurface);

            attachInfo.mWindowLeft = frame.left;
            attachInfo.mWindowTop = frame.top;

            // !!FIXME!! This next section handles the case where we did not get the
            // window size we asked for. We should avoid this by getting a maximum size from
            // the window session beforehand.
            mWidth = frame.width();
            mHeight = frame.height();

            if (mSurfaceHolder != null) {
                // The app owns the surface; tell it about what is going on.
                if (mSurface.isValid()) {
                    // XXX .copyFrom() doesn't work!
                    //mSurfaceHolder.mSurface.copyFrom(mSurface);
                    mSurfaceHolder.mSurface = mSurface;
                }
                mSurfaceHolder.setSurfaceFrameSize(mWidth, mHeight);
                mSurfaceHolder.mSurfaceLock.unlock();
                if (mSurface.isValid()) {
                    if (!hadSurface) {
                        mSurfaceHolder.ungetCallbacks();

                        mIsCreating = true;
                        mSurfaceHolderCallback.surfaceCreated(mSurfaceHolder);
                        SurfaceHolder.Callback callbacks[] = mSurfaceHolder.getCallbacks();
                        if (callbacks != null) {
                            for (SurfaceHolder.Callback c : callbacks) {
                                c.surfaceCreated(mSurfaceHolder);
                            }
                        }
                        surfaceChanged = true;
                    }
                    if (surfaceChanged) {
                        mSurfaceHolderCallback.surfaceChanged(mSurfaceHolder,
                                lp.format, mWidth, mHeight);
                        SurfaceHolder.Callback callbacks[] = mSurfaceHolder.getCallbacks();
                        if (callbacks != null) {
                            for (SurfaceHolder.Callback c : callbacks) {
                                c.surfaceChanged(mSurfaceHolder, lp.format,
                                        mWidth, mHeight);
                            }
                        }
                    }
                    mIsCreating = false;
                } else if (hadSurface) {
                    mSurfaceHolder.ungetCallbacks();
                    SurfaceHolder.Callback callbacks[] = mSurfaceHolder.getCallbacks();
                    mSurfaceHolderCallback.surfaceDestroyed(mSurfaceHolder);
                    if (callbacks != null) {
                        for (SurfaceHolder.Callback c : callbacks) {
                            c.surfaceDestroyed(mSurfaceHolder);
                        }
                    }
                    mSurfaceHolder.mSurfaceLock.lock();
                    try {
                        mSurfaceHolder.mSurface = new Surface();
                    } finally {
                        mSurfaceHolder.mSurfaceLock.unlock();
                    }
                }
            }

            if (mAttachInfo.mHardwareRenderer != null &&
                    mAttachInfo.mHardwareRenderer.isEnabled()) {
                if (hwInitialized || windowShouldResize ||
                        mWidth != mAttachInfo.mHardwareRenderer.getWidth() ||
                        mHeight != mAttachInfo.mHardwareRenderer.getHeight()) {
                    mAttachInfo.mHardwareRenderer.setup(mWidth, mHeight);
                    if (!hwInitialized) {
                        mAttachInfo.mHardwareRenderer.invalidate(mHolder);
                    }
                }
            }

            if (!mStopped) {
                boolean focusChangedDueToTouchMode = ensureTouchModeLocally(
                        (relayoutResult&WindowManagerImpl.RELAYOUT_RES_IN_TOUCH_MODE) != 0);
                if (focusChangedDueToTouchMode || mWidth != host.getMeasuredWidth()
                        || mHeight != host.getMeasuredHeight() || contentInsetsChanged) {
                    childWidthMeasureSpec = getRootMeasureSpec(mWidth, lp.width);
                    childHeightMeasureSpec = getRootMeasureSpec(mHeight, lp.height);
    
                    if (DEBUG_LAYOUT) Log.v(TAG, "Ooops, something changed!  mWidth="
                            + mWidth + " measuredWidth=" + host.getMeasuredWidth()
                            + " mHeight=" + mHeight
                            + " measuredHeight=" + host.getMeasuredHeight()
                            + " coveredInsetsChanged=" + contentInsetsChanged);
    
                     // Ask host how big it wants to be
                    host.measure(childWidthMeasureSpec, childHeightMeasureSpec);
    
                    // Implementation of weights from WindowManager.LayoutParams
                    // We just grow the dimensions as needed and re-measure if
                    // needs be
                    int width = host.getMeasuredWidth();
                    int height = host.getMeasuredHeight();
                    boolean measureAgain = false;
    
                    if (lp.horizontalWeight > 0.0f) {
                        width += (int) ((mWidth - width) * lp.horizontalWeight);
                        childWidthMeasureSpec = MeasureSpec.makeMeasureSpec(width,
                                MeasureSpec.EXACTLY);
                        measureAgain = true;
                    }
                    if (lp.verticalWeight > 0.0f) {
                        height += (int) ((mHeight - height) * lp.verticalWeight);
                        childHeightMeasureSpec = MeasureSpec.makeMeasureSpec(height,
                                MeasureSpec.EXACTLY);
                        measureAgain = true;
                    }
    
                    if (measureAgain) {
                        if (DEBUG_LAYOUT) Log.v(TAG,
                                "And hey let's measure once more: width=" + width
                                + " height=" + height);
                        host.measure(childWidthMeasureSpec, childHeightMeasureSpec);
                    }
    
                    mLayoutRequested = true;
                }
            }
        }

        final boolean didLayout = mLayoutRequested && !mStopped;
        boolean triggerGlobalLayoutListener = didLayout
                || attachInfo.mRecomputeGlobalAttributes;
        if (didLayout) {
            mLayoutRequested = false;
            mScrollMayChange = true;
            if (DEBUG_ORIENTATION || DEBUG_LAYOUT) Log.v(
                TAG, "Laying out " + host + " to (" +
                host.getMeasuredWidth() + ", " + host.getMeasuredHeight() + ")");
            long startTime = 0L;
            if (ViewDebug.DEBUG_PROFILE_LAYOUT) {
                startTime = SystemClock.elapsedRealtime();
            }
            host.layout(0, 0, host.getMeasuredWidth(), host.getMeasuredHeight());

            if (false && ViewDebug.consistencyCheckEnabled) {
                if (!host.dispatchConsistencyCheck(ViewDebug.CONSISTENCY_LAYOUT)) {
                    throw new IllegalStateException("The view hierarchy is an inconsistent state,"
                            + "please refer to the logs with the tag "
                            + ViewDebug.CONSISTENCY_LOG_TAG + " for more infomation.");
                }
            }

            if (ViewDebug.DEBUG_PROFILE_LAYOUT) {
                EventLog.writeEvent(60001, SystemClock.elapsedRealtime() - startTime);
            }

            // By this point all views have been sized and positionned
            // We can compute the transparent area

            if ((host.mPrivateFlags & View.REQUEST_TRANSPARENT_REGIONS) != 0) {
                // start out transparent
                // TODO: AVOID THAT CALL BY CACHING THE RESULT?
                host.getLocationInWindow(mTmpLocation);
                mTransparentRegion.set(mTmpLocation[0], mTmpLocation[1],
                        mTmpLocation[0] + host.mRight - host.mLeft,
                        mTmpLocation[1] + host.mBottom - host.mTop);

                host.gatherTransparentRegion(mTransparentRegion);
                if (mTranslator != null) {
                    mTranslator.translateRegionInWindowToScreen(mTransparentRegion);
                }

                if (!mTransparentRegion.equals(mPreviousTransparentRegion)) {
                    mPreviousTransparentRegion.set(mTransparentRegion);
                    // reconfigure window manager
                    try {
                        sWindowSession.setTransparentRegion(mWindow, mTransparentRegion);
                    } catch (RemoteException e) {
                    }
                }
            }

            if (DBG) {
                System.out.println("======================================");
                System.out.println("performTraversals -- after setFrame");
                host.debug();
            }
        }

        if (triggerGlobalLayoutListener) {
            attachInfo.mRecomputeGlobalAttributes = false;
            attachInfo.mTreeObserver.dispatchOnGlobalLayout();

            if (AccessibilityManager.getInstance(host.mContext).isEnabled()) {
                postSendWindowContentChangedCallback();
            }
        }

        if (computesInternalInsets) {
            // Clear the original insets.
            final ViewTreeObserver.InternalInsetsInfo insets = attachInfo.mGivenInternalInsets;
            insets.reset();

            // Compute new insets in place.
            attachInfo.mTreeObserver.dispatchOnComputeInternalInsets(insets);

            // Tell the window manager.
            if (insetsPending || !mLastGivenInsets.equals(insets)) {
                mLastGivenInsets.set(insets);

                // Translate insets to screen coordinates if needed.
                final Rect contentInsets;
                final Rect visibleInsets;
                final Region touchableRegion;
                if (mTranslator != null) {
                    contentInsets = mTranslator.getTranslatedContentInsets(insets.contentInsets);
                    visibleInsets = mTranslator.getTranslatedVisibleInsets(insets.visibleInsets);
                    touchableRegion = mTranslator.getTranslatedTouchableArea(insets.touchableRegion);
                } else {
                    contentInsets = insets.contentInsets;
                    visibleInsets = insets.visibleInsets;
                    touchableRegion = insets.touchableRegion;
                }

                try {
                    sWindowSession.setInsets(mWindow, insets.mTouchableInsets,
                            contentInsets, visibleInsets, touchableRegion);
                } catch (RemoteException e) {
                }
            }
        }

        if (mFirst) {
            // handle first focus request
            if (DEBUG_INPUT_RESIZE) Log.v(TAG, "First: mView.hasFocus()="
                    + mView.hasFocus());
            if (mView != null) {
                if (!mView.hasFocus()) {
                    mView.requestFocus(View.FOCUS_FORWARD);
                    mFocusedView = mRealFocusedView = mView.findFocus();
                    if (DEBUG_INPUT_RESIZE) Log.v(TAG, "First: requested focused view="
                            + mFocusedView);
                } else {
                    mRealFocusedView = mView.findFocus();
                    if (DEBUG_INPUT_RESIZE) Log.v(TAG, "First: existing focused view="
                            + mRealFocusedView);
                }
            }
        }

        mFirst = false;
        mWillDrawSoon = false;
        mNewSurfaceNeeded = false;
        mViewVisibility = viewVisibility;

        if (mAttachInfo.mHasWindowFocus) {
            final boolean imTarget = WindowManager.LayoutParams
                    .mayUseInputMethod(mWindowAttributes.flags);
            if (imTarget != mLastWasImTarget) {
                mLastWasImTarget = imTarget;
                InputMethodManager imm = InputMethodManager.peekInstance();
                if (imm != null && imTarget) {
                    imm.startGettingWindowFocus(mView);
                    imm.onWindowFocus(mView, mView.findFocus(),
                            mWindowAttributes.softInputMode,
                            !mHasHadWindowFocus, mWindowAttributes.flags);
                }
            }
        }

        boolean cancelDraw = attachInfo.mTreeObserver.dispatchOnPreDraw() ||
                viewVisibility != View.VISIBLE;

        if (!cancelDraw && !newSurface) {
            if (mPendingTransitions != null && mPendingTransitions.size() > 0) {
                for (int i = 0; i < mPendingTransitions.size(); ++i) {
                    mPendingTransitions.get(i).startChangingAnimations();
                }
                mPendingTransitions.clear();
            }
            mFullRedrawNeeded = false;

            final long drawStartTime;
            if (ViewDebug.DEBUG_LATENCY) {
                drawStartTime = System.nanoTime();
            }

            draw(fullRedrawNeeded);

            if (ViewDebug.DEBUG_LATENCY) {
                mLastDrawDurationNanos = System.nanoTime() - drawStartTime;
            }

            if ((relayoutResult&WindowManagerImpl.RELAYOUT_RES_FIRST_TIME) != 0
                    || mReportNextDraw) {
                if (LOCAL_LOGV) {
                    Log.v(TAG, "FINISHED DRAWING: " + mWindowAttributes.getTitle());
                }
                mReportNextDraw = false;
                if (mSurfaceHolder != null && mSurface.isValid()) {
                    mSurfaceHolderCallback.surfaceRedrawNeeded(mSurfaceHolder);
                    SurfaceHolder.Callback callbacks[] = mSurfaceHolder.getCallbacks();
                    if (callbacks != null) {
                        for (SurfaceHolder.Callback c : callbacks) {
                            if (c instanceof SurfaceHolder.Callback2) {
                                ((SurfaceHolder.Callback2)c).surfaceRedrawNeeded(
                                        mSurfaceHolder);
                            }
                        }
                    }
                }
                try {
                    sWindowSession.finishDrawing(mWindow);
                } catch (RemoteException e) {
                }
            }
        } else {
            // End any pending transitions on this non-visible window
            if (mPendingTransitions != null && mPendingTransitions.size() > 0) {
                for (int i = 0; i < mPendingTransitions.size(); ++i) {
                    mPendingTransitions.get(i).endChangingAnimations();
                }
                mPendingTransitions.clear();
            }
            // We were supposed to report when we are done drawing. Since we canceled the
            // draw, remember it here.
            if ((relayoutResult&WindowManagerImpl.RELAYOUT_RES_FIRST_TIME) != 0) {
                mReportNextDraw = true;
            }
            if (fullRedrawNeeded) {
                mFullRedrawNeeded = true;
            }

            if (viewVisibility == View.VISIBLE) {
                // Try again
                scheduleTraversals();
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.042 -0500", hash_original_method = "365202E212CCFCA6F73CFA951F572330", hash_generated_method = "B23F5774E6451B1F6A0AC3519FD33FE8")
    
public void requestTransparentRegion(View child) {
        // the test below should not fail unless someone is messing with us
        checkThread();
        if (mView == child) {
            mView.mPrivateFlags |= View.REQUEST_TRANSPARENT_REGIONS;
            // Need to make sure we re-evaluate the window attributes next
            // time around, to ensure the window has the correct format.
            mWindowAttributesChanged = true;
            mWindowAttributesChangesFlag = 0;
            requestLayout();
        }
    }

    /**
     * Figures out the measure spec for the root view in a window based on it's
     * layout params.
     *
     * @param windowSize
     *            The available width or height of the window
     *
     * @param rootDimension
     *            The layout params for one dimension (width or height) of the
     *            window.
     *
     * @return The measure spec to use to measure the root view.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.044 -0500", hash_original_method = "66EB141D637AEB4DAD3BF6AA91407C70", hash_generated_method = "D6543F7D393E54F4CFF14593B86C113C")
    
private int getRootMeasureSpec(int windowSize, int rootDimension) {
        int measureSpec;
        switch (rootDimension) {

        case ViewGroup.LayoutParams.MATCH_PARENT:
            // Window can't resize. Force root view to be windowSize.
            measureSpec = MeasureSpec.makeMeasureSpec(windowSize, MeasureSpec.EXACTLY);
            break;
        case ViewGroup.LayoutParams.WRAP_CONTENT:
            // Window can resize. Set max size for root view.
            measureSpec = MeasureSpec.makeMeasureSpec(windowSize, MeasureSpec.AT_MOST);
            break;
        default:
            // Window wants to be an exact size. Force root view to be that size.
            measureSpec = MeasureSpec.makeMeasureSpec(rootDimension, MeasureSpec.EXACTLY);
            break;
        }
        return measureSpec;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.053 -0500", hash_original_method = "40FADC477E8B2549BFFAC38F5B19946C", hash_generated_method = "8BABE01C4DC14A2BF19F7E7746F1FF88")
    
public void onHardwarePreDraw(HardwareCanvas canvas) {
        canvas.translate(0, -mHardwareYOffset);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.055 -0500", hash_original_method = "0640B89EE45E5EFA4DD1A520BD523415", hash_generated_method = "6E3929E49F584327FD19DA1E35EE1FF5")
    
public void onHardwarePostDraw(HardwareCanvas canvas) {
        if (mResizeBuffer != null) {
            mResizePaint.setAlpha(mResizeAlpha);
            canvas.drawHardwareLayer(mResizeBuffer, 0.0f, mHardwareYOffset, mResizePaint);
        }
    }

    /**
     * @hide
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.057 -0500", hash_original_method = "6ED7CE075B975161CAA5CFD7B073E953", hash_generated_method = "6ED7CE075B975161CAA5CFD7B073E953")
    
void outputDisplayList(View view) {
        if (mAttachInfo != null && mAttachInfo.mHardwareCanvas != null) {
            DisplayList displayList = view.getDisplayList();
            if (displayList != null) {
                mAttachInfo.mHardwareCanvas.outputDisplayList(displayList);
            }
        }
    }

    /**
     * @see #PROPERTY_PROFILE_RENDERING
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.068 -0500", hash_original_method = "910E3893A962467411DC222791137B30", hash_generated_method = "C1DCEA02E9ED4E520FD2D5B3376FD43D")
    
private void profileRendering(boolean enabled) {
        if (mProfileRendering) {
            mRenderProfilingEnabled = enabled;
            if (mRenderProfiler == null) {
                mRenderProfiler = new Thread(new Runnable() {
                    @DSSafe(DSCat.SAFE_LIST)
        @Override
                    public void run() {
                        Log.d(TAG, "Starting profiling thread");
                        while (mRenderProfilingEnabled) {
                            mAttachInfo.mHandler.post(new Runnable() {
                                @DSSafe(DSCat.SAFE_LIST)
            @Override
                                public void run() {
                                    mDirty.set(0, 0, mWidth, mHeight);
                                    scheduleTraversals();
                                }
                            });
                            try {
                                // TODO: This should use vsync when we get an API
                                Thread.sleep(15);
                            } catch (InterruptedException e) {
                                Log.d(TAG, "Exiting profiling thread");
                            }                            
                        }
                    }
                }, "Rendering Profiler");
                mRenderProfiler.start();
            } else {
                mRenderProfiler.interrupt();
                mRenderProfiler = null;
            }
        }
    }

    /**
     * Called from draw() when DEBUG_FPS is enabled
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.072 -0500", hash_original_method = "1AA1A4B748D7601F4F3826735499E6F6", hash_generated_method = "6ADFA33411FC3091951FBDF6F40D4CB6")
    
private void trackFPS() {
        // Tracks frames per second drawn. First value in a series of draws may be bogus
        // because it down not account for the intervening idle time
        long nowTime = System.currentTimeMillis();
        if (mFpsStartTime < 0) {
            mFpsStartTime = mFpsPrevTime = nowTime;
            mFpsNumFrames = 0;
        } else {
            ++mFpsNumFrames;
            String thisHash = Integer.toHexString(System.identityHashCode(this));
            long frameTime = nowTime - mFpsPrevTime;
            long totalTime = nowTime - mFpsStartTime;
            Log.v(TAG, "0x" + thisHash + "\tFrame time:\t" + frameTime);
            mFpsPrevTime = nowTime;
            if (totalTime > 1000) {
                float fps = (float) mFpsNumFrames * 1000 / totalTime;
                Log.v(TAG, "0x" + thisHash + "\tFPS:\t" + fps);
                mFpsStartTime = nowTime;
                mFpsNumFrames = 0;
            }
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.077 -0500", hash_original_method = "E37EF3DCFB26F629DB3873EE57113F2D", hash_generated_method = "360FF056EDCE8FC6A5A70BB5D66411AF")
    
private void draw(boolean fullRedrawNeeded) {
        Surface surface = mSurface;
        if (surface == null || !surface.isValid()) {
            return;
        }

        if (DEBUG_FPS) {
            trackFPS();
        }

        if (!sFirstDrawComplete) {
            synchronized (sFirstDrawHandlers) {
                sFirstDrawComplete = true;
                final int count = sFirstDrawHandlers.size();
                for (int i = 0; i< count; i++) {
                    post(sFirstDrawHandlers.get(i));
                }
            }
        }

        scrollToRectOrFocus(null, false);

        if (mAttachInfo.mViewScrollChanged) {
            mAttachInfo.mViewScrollChanged = false;
            mAttachInfo.mTreeObserver.dispatchOnScrollChanged();
        }

        int yoff;
        boolean animating = mScroller != null && mScroller.computeScrollOffset();
        if (animating) {
            yoff = mScroller.getCurrY();
        } else {
            yoff = mScrollY;
        }
        if (mCurScrollY != yoff) {
            mCurScrollY = yoff;
            fullRedrawNeeded = true;
        }
        float appScale = mAttachInfo.mApplicationScale;
        boolean scalingRequired = mAttachInfo.mScalingRequired;

        int resizeAlpha = 0;
        if (mResizeBuffer != null) {
            long deltaTime = SystemClock.uptimeMillis() - mResizeBufferStartTime;
            if (deltaTime < mResizeBufferDuration) {
                float amt = deltaTime/(float) mResizeBufferDuration;
                amt = mResizeInterpolator.getInterpolation(amt);
                animating = true;
                resizeAlpha = 255 - (int)(amt*255);
            } else {
                disposeResizeBuffer();
            }
        }

        Rect dirty = mDirty;
        if (mSurfaceHolder != null) {
            // The app owns the surface, we won't draw.
            dirty.setEmpty();
            if (animating) {
                if (mScroller != null) {
                    mScroller.abortAnimation();
                }
                disposeResizeBuffer();
            }
            return;
        }

        if (fullRedrawNeeded) {
            mAttachInfo.mIgnoreDirtyState = true;
            dirty.set(0, 0, (int) (mWidth * appScale + 0.5f), (int) (mHeight * appScale + 0.5f));
        }

        if (mAttachInfo.mHardwareRenderer != null && mAttachInfo.mHardwareRenderer.isEnabled()) {
            if (!dirty.isEmpty() || mIsAnimating) {
                mIsAnimating = false;
                mHardwareYOffset = yoff;
                mResizeAlpha = resizeAlpha;

                mCurrentDirty.set(dirty);
                mCurrentDirty.union(mPreviousDirty);
                mPreviousDirty.set(dirty);
                dirty.setEmpty();

                Rect currentDirty = mCurrentDirty;
                if (animating) {
                    currentDirty = null;
                }

                if (mAttachInfo.mHardwareRenderer.draw(mView, mAttachInfo, this, currentDirty)) {
                    mPreviousDirty.set(0, 0, mWidth, mHeight);
                }
            }

            if (animating) {
                mFullRedrawNeeded = true;
                scheduleTraversals();
            }

            return;
        }

        if (DEBUG_ORIENTATION || DEBUG_DRAW) {
            Log.v(TAG, "Draw " + mView + "/"
                    + mWindowAttributes.getTitle()
                    + ": dirty={" + dirty.left + "," + dirty.top
                    + "," + dirty.right + "," + dirty.bottom + "} surface="
                    + surface + " surface.isValid()=" + surface.isValid() + ", appScale:" +
                    appScale + ", width=" + mWidth + ", height=" + mHeight);
        }

        if (!dirty.isEmpty() || mIsAnimating) {
            Canvas canvas;
            try {
                int left = dirty.left;
                int top = dirty.top;
                int right = dirty.right;
                int bottom = dirty.bottom;

                final long lockCanvasStartTime;
                if (ViewDebug.DEBUG_LATENCY) {
                    lockCanvasStartTime = System.nanoTime();
                }

                canvas = surface.lockCanvas(dirty);

                if (ViewDebug.DEBUG_LATENCY) {
                    long now = System.nanoTime();
                    Log.d(TAG, "Latency: Spent "
                            + ((now - lockCanvasStartTime) * 0.000001f)
                            + "ms waiting for surface.lockCanvas()");
                }

                if (left != dirty.left || top != dirty.top || right != dirty.right ||
                        bottom != dirty.bottom) {
                    mAttachInfo.mIgnoreDirtyState = true;
                }

                // TODO: Do this in native
                canvas.setDensity(mDensity);
            } catch (Surface.OutOfResourcesException e) {
                Log.e(TAG, "OutOfResourcesException locking surface", e);
                try {
                    if (!sWindowSession.outOfMemory(mWindow)) {
                        Slog.w(TAG, "No processes killed for memory; killing self");
                        Process.killProcess(Process.myPid());
                    }
                } catch (RemoteException ex) {
                }
                mLayoutRequested = true;    // ask wm for a new surface next time.
                return;
            } catch (IllegalArgumentException e) {
                Log.e(TAG, "IllegalArgumentException locking surface", e);
                // Don't assume this is due to out of memory, it could be
                // something else, and if it is something else then we could
                // kill stuff (or ourself) for no reason.
                mLayoutRequested = true;    // ask wm for a new surface next time.
                return;
            }

            try {
                if (!dirty.isEmpty() || mIsAnimating) {
                    long startTime = 0L;

                    if (DEBUG_ORIENTATION || DEBUG_DRAW) {
                        Log.v(TAG, "Surface " + surface + " drawing to bitmap w="
                                + canvas.getWidth() + ", h=" + canvas.getHeight());
                        //canvas.drawARGB(255, 255, 0, 0);
                    }

                    if (ViewDebug.DEBUG_PROFILE_DRAWING) {
                        startTime = SystemClock.elapsedRealtime();
                    }

                    // If this bitmap's format includes an alpha channel, we
                    // need to clear it before drawing so that the child will
                    // properly re-composite its drawing on a transparent
                    // background. This automatically respects the clip/dirty region
                    // or
                    // If we are applying an offset, we need to clear the area
                    // where the offset doesn't appear to avoid having garbage
                    // left in the blank areas.
                    if (!canvas.isOpaque() || yoff != 0) {
                        canvas.drawColor(0, PorterDuff.Mode.CLEAR);
                    }

                    dirty.setEmpty();
                    mIsAnimating = false;
                    mAttachInfo.mDrawingTime = SystemClock.uptimeMillis();
                    mView.mPrivateFlags |= View.DRAWN;

                    if (DEBUG_DRAW) {
                        Context cxt = mView.getContext();
                        Log.i(TAG, "Drawing: package:" + cxt.getPackageName() +
                                ", metrics=" + cxt.getResources().getDisplayMetrics() +
                                ", compatibilityInfo=" + cxt.getResources().getCompatibilityInfo());
                    }
                    try {
                        canvas.translate(0, -yoff);
                        if (mTranslator != null) {
                            mTranslator.translateCanvas(canvas);
                        }
                        canvas.setScreenDensity(scalingRequired
                                ? DisplayMetrics.DENSITY_DEVICE : 0);
                        mAttachInfo.mSetIgnoreDirtyState = false;
                        mView.draw(canvas);
                    } finally {
                        if (!mAttachInfo.mSetIgnoreDirtyState) {
                            // Only clear the flag if it was not set during the mView.draw() call
                            mAttachInfo.mIgnoreDirtyState = false;
                        }
                    }

                    if (false && ViewDebug.consistencyCheckEnabled) {
                        mView.dispatchConsistencyCheck(ViewDebug.CONSISTENCY_DRAWING);
                    }

                    if (ViewDebug.DEBUG_PROFILE_DRAWING) {
                        EventLog.writeEvent(60000, SystemClock.elapsedRealtime() - startTime);
                    }
                }

            } finally {
                surface.unlockCanvasAndPost(canvas);
            }
        }

        if (LOCAL_LOGV) {
            Log.v(TAG, "Surface " + surface + " unlockCanvasAndPost");
        }

        if (animating) {
            mFullRedrawNeeded = true;
            scheduleTraversals();
        }
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.082 -0500", hash_original_method = "FAD7953F436A3C038802D5DE07F19E9E", hash_generated_method = "BE1F513AFB04F50D7ECE103EA32EEE2A")
    
boolean scrollToRectOrFocus(Rect rectangle, boolean immediate) {
        final View.AttachInfo attachInfo = mAttachInfo;
        final Rect ci = attachInfo.mContentInsets;
        final Rect vi = attachInfo.mVisibleInsets;
        int scrollY = 0;
        boolean handled = false;

        if (vi.left > ci.left || vi.top > ci.top
                || vi.right > ci.right || vi.bottom > ci.bottom) {
            // We'll assume that we aren't going to change the scroll
            // offset, since we want to avoid that unless it is actually
            // going to make the focus visible...  otherwise we scroll
            // all over the place.
            scrollY = mScrollY;
            // We can be called for two different situations: during a draw,
            // to update the scroll position if the focus has changed (in which
            // case 'rectangle' is null), or in response to a
            // requestChildRectangleOnScreen() call (in which case 'rectangle'
            // is non-null and we just want to scroll to whatever that
            // rectangle is).
            View focus = mRealFocusedView;

            // When in touch mode, focus points to the previously focused view,
            // which may have been removed from the view hierarchy. The following
            // line checks whether the view is still in our hierarchy.
            if (focus == null || focus.mAttachInfo != mAttachInfo) {
                mRealFocusedView = null;
                return false;
            }

            if (focus != mLastScrolledFocus) {
                // If the focus has changed, then ignore any requests to scroll
                // to a rectangle; first we want to make sure the entire focus
                // view is visible.
                rectangle = null;
            }
            if (DEBUG_INPUT_RESIZE) Log.v(TAG, "Eval scroll: focus=" + focus
                    + " rectangle=" + rectangle + " ci=" + ci
                    + " vi=" + vi);
            if (focus == mLastScrolledFocus && !mScrollMayChange
                    && rectangle == null) {
                // Optimization: if the focus hasn't changed since last
                // time, and no layout has happened, then just leave things
                // as they are.
                if (DEBUG_INPUT_RESIZE) Log.v(TAG, "Keeping scroll y="
                        + mScrollY + " vi=" + vi.toShortString());
            } else if (focus != null) {
                // We need to determine if the currently focused view is
                // within the visible part of the window and, if not, apply
                // a pan so it can be seen.
                mLastScrolledFocus = focus;
                mScrollMayChange = false;
                if (DEBUG_INPUT_RESIZE) Log.v(TAG, "Need to scroll?");
                // Try to find the rectangle from the focus view.
                if (focus.getGlobalVisibleRect(mVisRect, null)) {
                    if (DEBUG_INPUT_RESIZE) Log.v(TAG, "Root w="
                            + mView.getWidth() + " h=" + mView.getHeight()
                            + " ci=" + ci.toShortString()
                            + " vi=" + vi.toShortString());
                    if (rectangle == null) {
                        focus.getFocusedRect(mTempRect);
                        if (DEBUG_INPUT_RESIZE) Log.v(TAG, "Focus " + focus
                                + ": focusRect=" + mTempRect.toShortString());
                        if (mView instanceof ViewGroup) {
                            ((ViewGroup) mView).offsetDescendantRectToMyCoords(
                                    focus, mTempRect);
                        }
                        if (DEBUG_INPUT_RESIZE) Log.v(TAG,
                                "Focus in window: focusRect="
                                + mTempRect.toShortString()
                                + " visRect=" + mVisRect.toShortString());
                    } else {
                        mTempRect.set(rectangle);
                        if (DEBUG_INPUT_RESIZE) Log.v(TAG,
                                "Request scroll to rect: "
                                + mTempRect.toShortString()
                                + " visRect=" + mVisRect.toShortString());
                    }
                    if (mTempRect.intersect(mVisRect)) {
                        if (DEBUG_INPUT_RESIZE) Log.v(TAG,
                                "Focus window visible rect: "
                                + mTempRect.toShortString());
                        if (mTempRect.height() >
                                (mView.getHeight()-vi.top-vi.bottom)) {
                            // If the focus simply is not going to fit, then
                            // best is probably just to leave things as-is.
                            if (DEBUG_INPUT_RESIZE) Log.v(TAG,
                                    "Too tall; leaving scrollY=" + scrollY);
                        } else if ((mTempRect.top-scrollY) < vi.top) {
                            scrollY -= vi.top - (mTempRect.top-scrollY);
                            if (DEBUG_INPUT_RESIZE) Log.v(TAG,
                                    "Top covered; scrollY=" + scrollY);
                        } else if ((mTempRect.bottom-scrollY)
                                > (mView.getHeight()-vi.bottom)) {
                            scrollY += (mTempRect.bottom-scrollY)
                                    - (mView.getHeight()-vi.bottom);
                            if (DEBUG_INPUT_RESIZE) Log.v(TAG,
                                    "Bottom covered; scrollY=" + scrollY);
                        }
                        handled = true;
                    }
                }
            }
        }

        if (scrollY != mScrollY) {
            if (DEBUG_INPUT_RESIZE) Log.v(TAG, "Pan scroll changed: old="
                    + mScrollY + " , new=" + scrollY);
            if (!immediate && mResizeBuffer == null) {
                if (mScroller == null) {
                    mScroller = new Scroller(mView.getContext());
                }
                mScroller.startScroll(0, mScrollY, 0, scrollY-mScrollY);
            } else if (mScroller != null) {
                mScroller.abortAnimation();
            }
            mScrollY = scrollY;
        }

        return handled;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.085 -0500", hash_original_method = "9E09AEB1258054D8E474B794DDE3DA53", hash_generated_method = "98C3C0392433B89A7718918D20D89E5D")
    
public void requestChildFocus(View child, View focused) {
        checkThread();
        if (mFocusedView != focused) {
            mAttachInfo.mTreeObserver.dispatchOnGlobalFocusChange(mFocusedView, focused);
            scheduleTraversals();
        }
        mFocusedView = mRealFocusedView = focused;
        if (DEBUG_INPUT_RESIZE) Log.v(TAG, "Request child focus: focus now "
                + mFocusedView);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.088 -0500", hash_original_method = "D78AE43D1295D32838328E11498E7092", hash_generated_method = "6DFCF32C8ADCB07CFA69A86DA19E8DA3")
    
public void clearChildFocus(View child) {
        checkThread();

        View oldFocus = mFocusedView;

        if (DEBUG_INPUT_RESIZE) Log.v(TAG, "Clearing child focus");
        mFocusedView = mRealFocusedView = null;
        if (mView != null && !mView.hasFocus()) {
            // If a view gets the focus, the listener will be invoked from requestChildFocus()
            if (!mView.requestFocus(View.FOCUS_FORWARD)) {
                mAttachInfo.mTreeObserver.dispatchOnGlobalFocusChange(oldFocus, null);
            }
        } else if (oldFocus != null) {
            mAttachInfo.mTreeObserver.dispatchOnGlobalFocusChange(oldFocus, null);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.090 -0500", hash_original_method = "8AB5F5420D903C559791A9BF9B9BF8FD", hash_generated_method = "02B28F50617ED08F3B19BEA4BD084AD1")
    
public void focusableViewAvailable(View v) {
        checkThread();

        if (mView != null) {
            if (!mView.hasFocus()) {
                v.requestFocus();
            } else {
                // the one case where will transfer focus away from the current one
                // is if the current view is a view group that prefers to give focus
                // to its children first AND the view is a descendant of it.
                mFocusedView = mView.findFocus();
                boolean descendantsHaveDibsOnFocus =
                        (mFocusedView instanceof ViewGroup) &&
                            (((ViewGroup) mFocusedView).getDescendantFocusability() ==
                                    ViewGroup.FOCUS_AFTER_DESCENDANTS);
                if (descendantsHaveDibsOnFocus && isViewDescendantOf(v, mFocusedView)) {
                    // If a view gets the focus, the listener will be invoked from requestChildFocus()
                    v.requestFocus();
                }
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.093 -0500", hash_original_method = "66451BF0E175BE00AB35036422B65D7E", hash_generated_method = "64D4D44265EAEE7716A7A098DC470E35")
    
public void recomputeViewAttributes(View child) {
        checkThread();
        if (mView == child) {
            mAttachInfo.mRecomputeGlobalAttributes = true;
            if (!mWillDrawSoon) {
                scheduleTraversals();
            }
        }
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.095 -0500", hash_original_method = "59E93FB376BDE71F69616A2B01BFF0AF", hash_generated_method = "CA49963B7D3409228AEEF4116086808B")
    
void dispatchDetachedFromWindow() {
        if (mView != null && mView.mAttachInfo != null) {
            if (mAttachInfo.mHardwareRenderer != null &&
                    mAttachInfo.mHardwareRenderer.isEnabled()) {
                mAttachInfo.mHardwareRenderer.validate();
            }
            mView.dispatchDetachedFromWindow();
        }

        mAccessibilityInteractionConnectionManager.ensureNoConnection();
        mAccessibilityManager.removeAccessibilityStateChangeListener(
                mAccessibilityInteractionConnectionManager);
        removeSendWindowContentChangedCallback();

        mView = null;
        mAttachInfo.mRootView = null;
        mAttachInfo.mSurface = null;

        destroyHardwareRenderer();

        mSurface.release();

        if (mInputQueueCallback != null && mInputQueue != null) {
            mInputQueueCallback.onInputQueueDestroyed(mInputQueue);
            mInputQueueCallback = null;
            mInputQueue = null;
        } else if (mInputChannel != null) {
            InputQueue.unregisterInputChannel(mInputChannel);
        }
        try {
            sWindowSession.remove(mWindow);
        } catch (RemoteException e) {
        }
        
        // Dispose the input channel after removing the window so the Window Manager
        // doesn't interpret the input channel being closed as an abnormal termination.
        if (mInputChannel != null) {
            mInputChannel.dispose();
            mInputChannel = null;
        }
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.098 -0500", hash_original_method = "095941099FB476714878603F2FD5257D", hash_generated_method = "F715C493D00D2B4CB97E33221439FE95")
    
void updateConfiguration(Configuration config, boolean force) {
        if (DEBUG_CONFIGURATION) Log.v(TAG,
                "Applying new config to window "
                + mWindowAttributes.getTitle()
                + ": " + config);

        CompatibilityInfo ci = mCompatibilityInfo.getIfNeeded();
        if (ci != null) {
            config = new Configuration(config);
            ci.applyToConfiguration(config);
        }

        synchronized (sConfigCallbacks) {
            for (int i=sConfigCallbacks.size()-1; i>=0; i--) {
                sConfigCallbacks.get(i).onConfigurationChanged(config);
            }
        }
        if (mView != null) {
            // At this point the resources have been updated to
            // have the most recent config, whatever that is.  Use
            // the on in them which may be newer.
            config = mView.getResources().getConfiguration();
            if (force || mLastConfiguration.diff(config) != 0) {
                mLastConfiguration.setTo(config);
                mView.dispatchConfigurationChanged(config);
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.169 -0500", hash_original_method = "95F12947A9B342E5A748CE842344783A", hash_generated_method = "EF5720D7A06AE1DCC49D8005CB34FF91")
    
@Override
    public String getMessageName(Message message) {
        switch (message.what) {
            case DO_TRAVERSAL:
                return "DO_TRAVERSAL";
            case DIE:
                return "DIE";
            case RESIZED:
                return "RESIZED";
            case RESIZED_REPORT:
                return "RESIZED_REPORT";
            case WINDOW_FOCUS_CHANGED:
                return "WINDOW_FOCUS_CHANGED";
            case DISPATCH_KEY:
                return "DISPATCH_KEY";
            case DISPATCH_POINTER:
                return "DISPATCH_POINTER";
            case DISPATCH_TRACKBALL:
                return "DISPATCH_TRACKBALL";
            case DISPATCH_APP_VISIBILITY:
                return "DISPATCH_APP_VISIBILITY";
            case DISPATCH_GET_NEW_SURFACE:
                return "DISPATCH_GET_NEW_SURFACE";
            case FINISHED_EVENT:
                return "FINISHED_EVENT";
            case DISPATCH_KEY_FROM_IME:
                return "DISPATCH_KEY_FROM_IME";
            case FINISH_INPUT_CONNECTION:
                return "FINISH_INPUT_CONNECTION";
            case CHECK_FOCUS:
                return "CHECK_FOCUS";
            case CLOSE_SYSTEM_DIALOGS:
                return "CLOSE_SYSTEM_DIALOGS";
            case DISPATCH_DRAG_EVENT:
                return "DISPATCH_DRAG_EVENT";
            case DISPATCH_DRAG_LOCATION_EVENT:
                return "DISPATCH_DRAG_LOCATION_EVENT";
            case DISPATCH_SYSTEM_UI_VISIBILITY:
                return "DISPATCH_SYSTEM_UI_VISIBILITY";
            case DISPATCH_GENERIC_MOTION:
                return "DISPATCH_GENERIC_MOTION";
            case UPDATE_CONFIGURATION:
                return "UPDATE_CONFIGURATION";
            case DO_PERFORM_ACCESSIBILITY_ACTION:
                return "DO_PERFORM_ACCESSIBILITY_ACTION";
            case DO_FIND_ACCESSIBLITY_NODE_INFO_BY_ACCESSIBILITY_ID:
                return "DO_FIND_ACCESSIBLITY_NODE_INFO_BY_ACCESSIBILITY_ID";
            case DO_FIND_ACCESSIBLITY_NODE_INFO_BY_VIEW_ID:
                return "DO_FIND_ACCESSIBLITY_NODE_INFO_BY_VIEW_ID";
            case DO_FIND_ACCESSIBLITY_NODE_INFO_BY_VIEW_TEXT:
                return "DO_FIND_ACCESSIBLITY_NODE_INFO_BY_VIEW_TEXT";
            case PROCESS_INPUT_EVENTS:
                return "PROCESS_INPUT_EVENTS";

        }
        return super.getMessageName(message);
    }

    @DSSafe(DSCat.IPC_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.176 -0500", hash_original_method = "0C83FFF474CF8ADB1C57E65037847991", hash_generated_method = "1C66F19E0251DC0F4C166BC01DD8CB53")
    
@Override
    public void handleMessage(Message msg) {
        switch (msg.what) {
        case View.AttachInfo.INVALIDATE_MSG:
            ((View) msg.obj).invalidate();
            break;
        case View.AttachInfo.INVALIDATE_RECT_MSG:
            final View.AttachInfo.InvalidateInfo info = (View.AttachInfo.InvalidateInfo) msg.obj;
            info.target.invalidate(info.left, info.top, info.right, info.bottom);
            info.release();
            break;
        case DO_TRAVERSAL:
            if (mProfile) {
                Debug.startMethodTracing("ViewAncestor");
            }

            final long traversalStartTime;
            if (ViewDebug.DEBUG_LATENCY) {
                traversalStartTime = System.nanoTime();
                mLastDrawDurationNanos = 0;
            }

            performTraversals();

            if (ViewDebug.DEBUG_LATENCY) {
                long now = System.nanoTime();
                Log.d(TAG, "Latency: Spent "
                        + ((now - traversalStartTime) * 0.000001f)
                        + "ms in performTraversals(), with "
                        + (mLastDrawDurationNanos * 0.000001f)
                        + "ms of that time in draw()");
                mLastTraversalFinishedTimeNanos = now;
            }

            if (mProfile) {
                Debug.stopMethodTracing();
                mProfile = false;
            }
            break;
        case FINISHED_EVENT:
            handleFinishedEvent(msg.arg1, msg.arg2 != 0);
            break;
        case DISPATCH_KEY:
            deliverKeyEvent((KeyEvent)msg.obj, msg.arg1 != 0);
            break;
        case DISPATCH_POINTER:
            deliverPointerEvent((MotionEvent) msg.obj, msg.arg1 != 0);
            break;
        case DISPATCH_TRACKBALL:
            deliverTrackballEvent((MotionEvent) msg.obj, msg.arg1 != 0);
            break;
        case DISPATCH_GENERIC_MOTION:
            deliverGenericMotionEvent((MotionEvent) msg.obj, msg.arg1 != 0);
            break;
        case PROCESS_INPUT_EVENTS:
            processInputEvents(false);
            break;
        case DISPATCH_APP_VISIBILITY:
            handleAppVisibility(msg.arg1 != 0);
            break;
        case DISPATCH_GET_NEW_SURFACE:
            handleGetNewSurface();
            break;
        case RESIZED:
            ResizedInfo ri = (ResizedInfo)msg.obj;

            if (mWinFrame.width() == msg.arg1 && mWinFrame.height() == msg.arg2
                    && mPendingContentInsets.equals(ri.coveredInsets)
                    && mPendingVisibleInsets.equals(ri.visibleInsets)
                    && ((ResizedInfo)msg.obj).newConfig == null) {
                break;
            }
            // fall through...
        case RESIZED_REPORT:
            if (mAdded) {
                Configuration config = ((ResizedInfo)msg.obj).newConfig;
                if (config != null) {
                    updateConfiguration(config, false);
                }
                mWinFrame.addTaint(getTaintInt() + msg.getTaintInt()); 
                mPendingContentInsets.set(((ResizedInfo)msg.obj).coveredInsets);
                mPendingVisibleInsets.set(((ResizedInfo)msg.obj).visibleInsets);
                if (msg.what == RESIZED_REPORT) {
                    mReportNextDraw = true;
                }

                if (mView != null) {
                    forceLayout(mView);
                }
                requestLayout();
            }
            break;
        case WINDOW_FOCUS_CHANGED: {
            if (mAdded) {
                boolean hasWindowFocus = msg.arg1 != 0;
                mAttachInfo.mHasWindowFocus = hasWindowFocus;
                
                profileRendering(hasWindowFocus);

                if (hasWindowFocus) {
                    boolean inTouchMode = msg.arg2 != 0;
                    ensureTouchModeLocally(inTouchMode);

                    if (mAttachInfo.mHardwareRenderer != null &&
                            mSurface != null && mSurface.isValid()) {
                        mFullRedrawNeeded = true;
                        try {
                            mAttachInfo.mHardwareRenderer.initializeIfNeeded(mWidth, mHeight,
                                    mAttachInfo, mHolder);
                        } catch (Surface.OutOfResourcesException e) {
                            Log.e(TAG, "OutOfResourcesException locking surface", e);
                            try {
                                if (!sWindowSession.outOfMemory(mWindow)) {
                                    Slog.w(TAG, "No processes killed for memory; killing self");
                                    Process.killProcess(Process.myPid());
                                }
                            } catch (RemoteException ex) {
                            }
                            // Retry in a bit.
                            sendMessageDelayed(obtainMessage(msg.what, msg.arg1, msg.arg2), 500);
                            return;
                        }
                    }
                }

                mLastWasImTarget = WindowManager.LayoutParams
                        .mayUseInputMethod(mWindowAttributes.flags);

                InputMethodManager imm = InputMethodManager.peekInstance();
                if (mView != null) {
                    if (hasWindowFocus && imm != null && mLastWasImTarget) {
                        imm.startGettingWindowFocus(mView);
                    }
                    mAttachInfo.mKeyDispatchState.reset();
                    mView.dispatchWindowFocusChanged(hasWindowFocus);
                }

                // Note: must be done after the focus change callbacks,
                // so all of the view state is set up correctly.
                if (hasWindowFocus) {
                    if (imm != null && mLastWasImTarget) {
                        imm.onWindowFocus(mView, mView.findFocus(),
                                mWindowAttributes.softInputMode,
                                !mHasHadWindowFocus, mWindowAttributes.flags);
                    }
                    // Clear the forward bit.  We can just do this directly, since
                    // the window manager doesn't care about it.
                    mWindowAttributes.softInputMode &=
                            ~WindowManager.LayoutParams.SOFT_INPUT_IS_FORWARD_NAVIGATION;
                    ((WindowManager.LayoutParams)mView.getLayoutParams())
                            .softInputMode &=
                                ~WindowManager.LayoutParams.SOFT_INPUT_IS_FORWARD_NAVIGATION;
                    mHasHadWindowFocus = true;
                }

                if (hasWindowFocus && mView != null) {
                    sendAccessibilityEvents();
                }
            }
        } break;
        case DIE:
            doDie();
            break;
        case DISPATCH_KEY_FROM_IME: {
            if (LOCAL_LOGV) Log.v(
                TAG, "Dispatching key "
                + msg.obj + " from IME to " + mView);
            KeyEvent event = (KeyEvent)msg.obj;
            if ((event.getFlags()&KeyEvent.FLAG_FROM_SYSTEM) != 0) {
                // The IME is trying to say this event is from the
                // system!  Bad bad bad!
                //noinspection UnusedAssignment
                event = KeyEvent.changeFlags(event, event.getFlags() & ~KeyEvent.FLAG_FROM_SYSTEM);
            }
            deliverKeyEventPostIme((KeyEvent)msg.obj, false);
        } break;
        case FINISH_INPUT_CONNECTION: {
            InputMethodManager imm = InputMethodManager.peekInstance();
            if (imm != null) {
                imm.reportFinishInputConnection((InputConnection)msg.obj);
            }
        } break;
        case CHECK_FOCUS: {
            InputMethodManager imm = InputMethodManager.peekInstance();
            if (imm != null) {
                imm.checkFocus();
            }
        } break;
        case CLOSE_SYSTEM_DIALOGS: {
            if (mView != null) {
                mView.onCloseSystemDialogs((String)msg.obj);
            }
        } break;
        case DISPATCH_DRAG_EVENT:
        case DISPATCH_DRAG_LOCATION_EVENT: {
            DragEvent event = (DragEvent)msg.obj;
            event.mLocalState = mLocalDragState;    // only present when this app called startDrag()
            handleDragEvent(event);
        } break;
        case DISPATCH_SYSTEM_UI_VISIBILITY: {
            handleDispatchSystemUiVisibilityChanged((SystemUiVisibilityInfo)msg.obj);
        } break;
        case UPDATE_CONFIGURATION: {
            Configuration config = (Configuration)msg.obj;
            if (config.isOtherSeqNewer(mLastConfiguration)) {
                config = mLastConfiguration;
            }
            updateConfiguration(config, false);
        } break;
        case DO_FIND_ACCESSIBLITY_NODE_INFO_BY_ACCESSIBILITY_ID: {
            if (mView != null) {
                getAccessibilityInteractionController()
                    .findAccessibilityNodeInfoByAccessibilityIdUiThread(msg);
            }
        } break;
        case DO_PERFORM_ACCESSIBILITY_ACTION: {
            if (mView != null) {
                getAccessibilityInteractionController()
                    .perfromAccessibilityActionUiThread(msg);
            }
        } break;
        case DO_FIND_ACCESSIBLITY_NODE_INFO_BY_VIEW_ID: {
            if (mView != null) {
                getAccessibilityInteractionController()
                    .findAccessibilityNodeInfoByViewIdUiThread(msg);
            }
        } break;
        case DO_FIND_ACCESSIBLITY_NODE_INFO_BY_VIEW_TEXT: {
            if (mView != null) {
                getAccessibilityInteractionController()
                    .findAccessibilityNodeInfosByViewTextUiThread(msg);
            }
        } break;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.179 -0500", hash_original_method = "0B0FC84CA02F82927D98059C965571E0", hash_generated_method = "AA056CBF143FD5CD7663D0B721A5A3CB")
    
private void startInputEvent(InputQueue.FinishedCallback finishedCallback) {
        if (mFinishedCallback != null) {
            Slog.w(TAG, "Received a new input event from the input queue but there is "
                    + "already an unfinished input event in progress.");
        }

        if (ViewDebug.DEBUG_LATENCY) {
            mInputEventReceiveTimeNanos = System.nanoTime();
            mInputEventDeliverTimeNanos = 0;
            mInputEventDeliverPostImeTimeNanos = 0;
        }

        mFinishedCallback = finishedCallback;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.183 -0500", hash_original_method = "06AEBC75FF0DC9B70A4E2BB2CC6850C1", hash_generated_method = "529A6DE8C751E212D4B5309C67447ECD")
    
private void finishInputEvent(InputEvent event, boolean handled) {
        if (LOCAL_LOGV) Log.v(TAG, "Telling window manager input event is finished");

        if (mFinishedCallback == null) {
            Slog.w(TAG, "Attempted to tell the input queue that the current input event "
                    + "is finished but there is no input event actually in progress.");
            return;
        }

        if (ViewDebug.DEBUG_LATENCY) {
            final long now = System.nanoTime();
            final long eventTime = event.getEventTimeNano();
            final StringBuilder msg = new StringBuilder();
            msg.append("Latency: Spent ");
            msg.append((now - mInputEventReceiveTimeNanos) * 0.000001f);
            msg.append("ms processing ");
            if (event instanceof KeyEvent) {
                final KeyEvent  keyEvent = (KeyEvent)event;
                msg.append("key event, action=");
                msg.append(KeyEvent.actionToString(keyEvent.getAction()));
            } else {
                final MotionEvent motionEvent = (MotionEvent)event;
                msg.append("motion event, action=");
                msg.append(MotionEvent.actionToString(motionEvent.getAction()));
                msg.append(", historySize=");
                msg.append(motionEvent.getHistorySize());
            }
            msg.append(", handled=");
            msg.append(handled);
            msg.append(", received at +");
            msg.append((mInputEventReceiveTimeNanos - eventTime) * 0.000001f);
            if (mInputEventDeliverTimeNanos != 0) {
                msg.append("ms, delivered at +");
                msg.append((mInputEventDeliverTimeNanos - eventTime) * 0.000001f);
            }
            if (mInputEventDeliverPostImeTimeNanos != 0) {
                msg.append("ms, delivered post IME at +");
                msg.append((mInputEventDeliverPostImeTimeNanos - eventTime) * 0.000001f);
            }
            msg.append("ms, finished at +");
            msg.append((now - eventTime) * 0.000001f);
            msg.append("ms.");
            Log.d(TAG, msg.toString());
        }

        mFinishedCallback.finished(handled);
        mFinishedCallback = null;
    }
    
    /**
     * Something in the current window tells us we need to change the touch mode.  For
     * example, we are not in touch mode, and the user touches the screen.
     *
     * If the touch mode has changed, tell the window manager, and handle it locally.
     *
     * @param inTouchMode Whether we want to be in touch mode.
     * @return True if the touch mode changed and focus changed was changed as a result
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.185 -0500", hash_original_method = "A6640F15C2D0A406B73F798DB9EA077C", hash_generated_method = "9E0C1B812348DAA23D6CEA8D73128E42")
    
boolean ensureTouchMode(boolean inTouchMode) {
        if (DBG) Log.d("touchmode", "ensureTouchMode(" + inTouchMode + "), current "
                + "touch mode is " + mAttachInfo.mInTouchMode);
        if (mAttachInfo.mInTouchMode == inTouchMode) return false;

        // tell the window manager
        try {
            sWindowSession.setInTouchMode(inTouchMode);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }

        // handle the change
        return ensureTouchModeLocally(inTouchMode);
    }

    /**
     * Ensure that the touch mode for this window is set, and if it is changing,
     * take the appropriate action.
     * @param inTouchMode Whether we want to be in touch mode.
     * @return True if the touch mode changed and focus changed was changed as a result
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.200 -0500", hash_original_method = "A817FB22551D2F047707EAAC44367E27", hash_generated_method = "A88C42586BD6041A191DF78F545394C3")
    
private boolean ensureTouchModeLocally(boolean inTouchMode) {
        if (DBG) Log.d("touchmode", "ensureTouchModeLocally(" + inTouchMode + "), current "
                + "touch mode is " + mAttachInfo.mInTouchMode);

        if (mAttachInfo.mInTouchMode == inTouchMode) return false;

        mAttachInfo.mInTouchMode = inTouchMode;
        mAttachInfo.mTreeObserver.dispatchOnTouchModeChanged(inTouchMode);

        return (inTouchMode) ? enterTouchMode() : leaveTouchMode();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.203 -0500", hash_original_method = "4D22F5F97C319901FE80DD8DAA6DBF2B", hash_generated_method = "3D93AE55E9EFD8F8DFDDB9EA73A858EF")
    
private boolean enterTouchMode() {
        if (mView != null) {
            if (mView.hasFocus()) {
                // note: not relying on mFocusedView here because this could
                // be when the window is first being added, and mFocused isn't
                // set yet.
                final View focused = mView.findFocus();
                if (focused != null && !focused.isFocusableInTouchMode()) {

                    final ViewGroup ancestorToTakeFocus =
                            findAncestorToTakeFocusInTouchMode(focused);
                    if (ancestorToTakeFocus != null) {
                        // there is an ancestor that wants focus after its descendants that
                        // is focusable in touch mode.. give it focus
                        return ancestorToTakeFocus.requestFocus();
                    } else {
                        // nothing appropriate to have focus in touch mode, clear it out
                        mView.unFocus();
                        mAttachInfo.mTreeObserver.dispatchOnGlobalFocusChange(focused, null);
                        mFocusedView = null;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Find an ancestor of focused that wants focus after its descendants and is
     * focusable in touch mode.
     * @param focused The currently focused view.
     * @return An appropriate view, or null if no such view exists.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.205 -0500", hash_original_method = "A2FE4CBD06D42BF7C573F07F56417767", hash_generated_method = "F9C37D583DB880496BE6412519F55930")
    
private ViewGroup findAncestorToTakeFocusInTouchMode(View focused) {
        ViewParent parent = focused.getParent();
        while (parent instanceof ViewGroup) {
            final ViewGroup vgParent = (ViewGroup) parent;
            if (vgParent.getDescendantFocusability() == ViewGroup.FOCUS_AFTER_DESCENDANTS
                    && vgParent.isFocusableInTouchMode()) {
                return vgParent;
            }
            if (vgParent.isRootNamespace()) {
                return null;
            } else {
                parent = vgParent.getParent();
            }
        }
        return null;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.208 -0500", hash_original_method = "6D4A7A06FF255705F6FF85A0D8D1E147", hash_generated_method = "EC63AA6B5F1103C3DEDFDCB1A8D46F11")
    
private boolean leaveTouchMode() {
        if (mView != null) {
            if (mView.hasFocus()) {
                // i learned the hard way to not trust mFocusedView :)
                mFocusedView = mView.findFocus();
                if (!(mFocusedView instanceof ViewGroup)) {
                    // some view has focus, let it keep it
                    return false;
                } else if (((ViewGroup)mFocusedView).getDescendantFocusability() !=
                        ViewGroup.FOCUS_AFTER_DESCENDANTS) {
                    // some view group has focus, and doesn't prefer its children
                    // over itself for focus, so let them keep it.
                    return false;
                }
            }

            // find the best view to give focus to in this brave new non-touch-mode
            // world
            final View focused = focusSearch(null, View.FOCUS_DOWN);
            if (focused != null) {
                return focused.requestFocus(View.FOCUS_DOWN);
            }
        }
        return false;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.212 -0500", hash_original_method = "8F847D145475DB0C2BA683E62F600908", hash_generated_method = "155D2FAA600744563F9A47884F92E61F")
    
private void deliverPointerEvent(MotionEvent event, boolean sendDone) {
        if (ViewDebug.DEBUG_LATENCY) {
            mInputEventDeliverTimeNanos = System.nanoTime();
        }

        final boolean isTouchEvent = event.isTouchEvent();
        if (mInputEventConsistencyVerifier != null) {
            if (isTouchEvent) {
                mInputEventConsistencyVerifier.onTouchEvent(event, 0);
            } else {
                mInputEventConsistencyVerifier.onGenericMotionEvent(event, 0);
            }
        }

        // If there is no view, then the event will not be handled.
        if (mView == null || !mAdded) {
            finishMotionEvent(event, sendDone, false);
            return;
        }

        // Translate the pointer event for compatibility, if needed.
        if (mTranslator != null) {
            mTranslator.translateEventInScreenToAppWindow(event);
        }

        // Enter touch mode on down or scroll.
        final int action = event.getAction();
        if (action == MotionEvent.ACTION_DOWN || action == MotionEvent.ACTION_SCROLL) {
            ensureTouchMode(true);
        }

        // Offset the scroll position.
        if (mCurScrollY != 0) {
            event.offsetLocation(0, mCurScrollY);
        }
        if (MEASURE_LATENCY) {
            lt.sample("A Dispatching PointerEvents", System.nanoTime() - event.getEventTimeNano());
        }

        // Remember the touch position for possible drag-initiation.
        if (isTouchEvent) {
            mLastTouchPoint.x = event.getRawX();
            mLastTouchPoint.y = event.getRawY();
        }

        // Dispatch touch to view hierarchy.
        boolean handled = mView.dispatchPointerEvent(event);
        if (MEASURE_LATENCY) {
            lt.sample("B Dispatched PointerEvents ", System.nanoTime() - event.getEventTimeNano());
        }
        if (handled) {
            finishMotionEvent(event, sendDone, true);
            return;
        }

        // Pointer event was unhandled.
        finishMotionEvent(event, sendDone, false);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.214 -0500", hash_original_method = "DF90914307EFCD2CA23CDB09D8C7F95D", hash_generated_method = "E6DB291E379636EBCDBDC3EA87426617")
    
private void finishMotionEvent(MotionEvent event, boolean sendDone, boolean handled) {
        event.recycle();
        if (sendDone) {
            finishInputEvent(event, handled);
        }
        //noinspection ConstantConditions
        if (LOCAL_LOGV || WATCH_POINTER) {
            if ((event.getSource() & InputDevice.SOURCE_CLASS_POINTER) != 0) {
                Log.i(TAG, "Done dispatching!");
            }
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.219 -0500", hash_original_method = "B306A4DB67A1B71DDAAA3D4C50CD59B0", hash_generated_method = "EC20132318249F623211B06EC00B1C09")
    
private void deliverTrackballEvent(MotionEvent event, boolean sendDone) {
        if (ViewDebug.DEBUG_LATENCY) {
            mInputEventDeliverTimeNanos = System.nanoTime();
        }

        if (DEBUG_TRACKBALL) Log.v(TAG, "Motion event:" + event);

        if (mInputEventConsistencyVerifier != null) {
            mInputEventConsistencyVerifier.onTrackballEvent(event, 0);
        }

        // If there is no view, then the event will not be handled.
        if (mView == null || !mAdded) {
            finishMotionEvent(event, sendDone, false);
            return;
        }

        // Deliver the trackball event to the view.
        if (mView.dispatchTrackballEvent(event)) {
            // If we reach this, we delivered a trackball event to mView and
            // mView consumed it. Because we will not translate the trackball
            // event into a key event, touch mode will not exit, so we exit
            // touch mode here.
            ensureTouchMode(false);

            finishMotionEvent(event, sendDone, true);
            mLastTrackballTime = Integer.MIN_VALUE;
            return;
        }

        // Translate the trackball event into DPAD keys and try to deliver those.
        final TrackballAxis x = mTrackballAxisX;
        final TrackballAxis y = mTrackballAxisY;

        long curTime = SystemClock.uptimeMillis();
        if ((mLastTrackballTime + MAX_TRACKBALL_DELAY) < curTime) {
            // It has been too long since the last movement,
            // so restart at the beginning.
            x.reset(0);
            y.reset(0);
            mLastTrackballTime = curTime;
        }

        final int action = event.getAction();
        final int metaState = event.getMetaState();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                x.reset(2);
                y.reset(2);
                deliverKeyEvent(new KeyEvent(curTime, curTime,
                        KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_DPAD_CENTER, 0, metaState,
                        KeyCharacterMap.VIRTUAL_KEYBOARD, 0, KeyEvent.FLAG_FALLBACK,
                        InputDevice.SOURCE_KEYBOARD), false);
                break;
            case MotionEvent.ACTION_UP:
                x.reset(2);
                y.reset(2);
                deliverKeyEvent(new KeyEvent(curTime, curTime,
                        KeyEvent.ACTION_UP, KeyEvent.KEYCODE_DPAD_CENTER, 0, metaState,
                        KeyCharacterMap.VIRTUAL_KEYBOARD, 0, KeyEvent.FLAG_FALLBACK,
                        InputDevice.SOURCE_KEYBOARD), false);
                break;
        }

        if (DEBUG_TRACKBALL) Log.v(TAG, "TB X=" + x.position + " step="
                + x.step + " dir=" + x.dir + " acc=" + x.acceleration
                + " move=" + event.getX()
                + " / Y=" + y.position + " step="
                + y.step + " dir=" + y.dir + " acc=" + y.acceleration
                + " move=" + event.getY());
        final float xOff = x.collect(event.getX(), event.getEventTime(), "X");
        final float yOff = y.collect(event.getY(), event.getEventTime(), "Y");

        // Generate DPAD events based on the trackball movement.
        // We pick the axis that has moved the most as the direction of
        // the DPAD.  When we generate DPAD events for one axis, then the
        // other axis is reset -- we don't want to perform DPAD jumps due
        // to slight movements in the trackball when making major movements
        // along the other axis.
        int keycode = 0;
        int movement = 0;
        float accel = 1;
        if (xOff > yOff) {
            movement = x.generate((2/event.getXPrecision()));
            if (movement != 0) {
                keycode = movement > 0 ? KeyEvent.KEYCODE_DPAD_RIGHT
                        : KeyEvent.KEYCODE_DPAD_LEFT;
                accel = x.acceleration;
                y.reset(2);
            }
        } else if (yOff > 0) {
            movement = y.generate((2/event.getYPrecision()));
            if (movement != 0) {
                keycode = movement > 0 ? KeyEvent.KEYCODE_DPAD_DOWN
                        : KeyEvent.KEYCODE_DPAD_UP;
                accel = y.acceleration;
                x.reset(2);
            }
        }

        if (keycode != 0) {
            if (movement < 0) movement = -movement;
            int accelMovement = (int)(movement * accel);
            if (DEBUG_TRACKBALL) Log.v(TAG, "Move: movement=" + movement
                    + " accelMovement=" + accelMovement
                    + " accel=" + accel);
            if (accelMovement > movement) {
                if (DEBUG_TRACKBALL) Log.v("foo", "Delivering fake DPAD: "
                        + keycode);
                movement--;
                int repeatCount = accelMovement - movement;
                deliverKeyEvent(new KeyEvent(curTime, curTime,
                        KeyEvent.ACTION_MULTIPLE, keycode, repeatCount, metaState,
                        KeyCharacterMap.VIRTUAL_KEYBOARD, 0, KeyEvent.FLAG_FALLBACK,
                        InputDevice.SOURCE_KEYBOARD), false);
            }
            while (movement > 0) {
                if (DEBUG_TRACKBALL) Log.v("foo", "Delivering fake DPAD: "
                        + keycode);
                movement--;
                curTime = SystemClock.uptimeMillis();
                deliverKeyEvent(new KeyEvent(curTime, curTime,
                        KeyEvent.ACTION_DOWN, keycode, 0, metaState,
                        KeyCharacterMap.VIRTUAL_KEYBOARD, 0, KeyEvent.FLAG_FALLBACK,
                        InputDevice.SOURCE_KEYBOARD), false);
                deliverKeyEvent(new KeyEvent(curTime, curTime,
                        KeyEvent.ACTION_UP, keycode, 0, metaState,
                        KeyCharacterMap.VIRTUAL_KEYBOARD, 0, KeyEvent.FLAG_FALLBACK,
                        InputDevice.SOURCE_KEYBOARD), false);
                }
            mLastTrackballTime = curTime;
        }

        // Unfortunately we can't tell whether the application consumed the keys, so
        // we always consider the trackball event handled.
        finishMotionEvent(event, sendDone, true);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.222 -0500", hash_original_method = "D79206E9EE4BD2FB4F0103FA8C72904A", hash_generated_method = "FB8701CEDD28BDA40F1D4C383AC6CA95")
    
private void deliverGenericMotionEvent(MotionEvent event, boolean sendDone) {
        if (ViewDebug.DEBUG_LATENCY) {
            mInputEventDeliverTimeNanos = System.nanoTime();
        }

        if (mInputEventConsistencyVerifier != null) {
            mInputEventConsistencyVerifier.onGenericMotionEvent(event, 0);
        }

        final int source = event.getSource();
        final boolean isJoystick = (source & InputDevice.SOURCE_CLASS_JOYSTICK) != 0;

        // If there is no view, then the event will not be handled.
        if (mView == null || !mAdded) {
            if (isJoystick) {
                updateJoystickDirection(event, false);
            }
            finishMotionEvent(event, sendDone, false);
            return;
        }

        // Deliver the event to the view.
        if (mView.dispatchGenericMotionEvent(event)) {
            if (isJoystick) {
                updateJoystickDirection(event, false);
            }
            finishMotionEvent(event, sendDone, true);
            return;
        }

        if (isJoystick) {
            // Translate the joystick event into DPAD keys and try to deliver those.
            updateJoystickDirection(event, true);
            finishMotionEvent(event, sendDone, true);
        } else {
            finishMotionEvent(event, sendDone, false);
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.226 -0500", hash_original_method = "3F24F6EAAF68F5E1EBCC50D38D5B0024", hash_generated_method = "BFCCACE4AAE763B20CB95D6AE653B8F7")
    
private void updateJoystickDirection(MotionEvent event, boolean synthesizeNewKeys) {
        final long time = event.getEventTime();
        final int metaState = event.getMetaState();
        final int deviceId = event.getDeviceId();
        final int source = event.getSource();

        int xDirection = joystickAxisValueToDirection(event.getAxisValue(MotionEvent.AXIS_HAT_X));
        if (xDirection == 0) {
            xDirection = joystickAxisValueToDirection(event.getX());
        }

        int yDirection = joystickAxisValueToDirection(event.getAxisValue(MotionEvent.AXIS_HAT_Y));
        if (yDirection == 0) {
            yDirection = joystickAxisValueToDirection(event.getY());
        }

        if (xDirection != mLastJoystickXDirection) {
            if (mLastJoystickXKeyCode != 0) {
                deliverKeyEvent(new KeyEvent(time, time,
                        KeyEvent.ACTION_UP, mLastJoystickXKeyCode, 0, metaState,
                        deviceId, 0, KeyEvent.FLAG_FALLBACK, source), false);
                mLastJoystickXKeyCode = 0;
            }

            mLastJoystickXDirection = xDirection;

            if (xDirection != 0 && synthesizeNewKeys) {
                mLastJoystickXKeyCode = xDirection > 0
                        ? KeyEvent.KEYCODE_DPAD_RIGHT : KeyEvent.KEYCODE_DPAD_LEFT;
                deliverKeyEvent(new KeyEvent(time, time,
                        KeyEvent.ACTION_DOWN, mLastJoystickXKeyCode, 0, metaState,
                        deviceId, 0, KeyEvent.FLAG_FALLBACK, source), false);
            }
        }

        if (yDirection != mLastJoystickYDirection) {
            if (mLastJoystickYKeyCode != 0) {
                deliverKeyEvent(new KeyEvent(time, time,
                        KeyEvent.ACTION_UP, mLastJoystickYKeyCode, 0, metaState,
                        deviceId, 0, KeyEvent.FLAG_FALLBACK, source), false);
                mLastJoystickYKeyCode = 0;
            }

            mLastJoystickYDirection = yDirection;

            if (yDirection != 0 && synthesizeNewKeys) {
                mLastJoystickYKeyCode = yDirection > 0
                        ? KeyEvent.KEYCODE_DPAD_DOWN : KeyEvent.KEYCODE_DPAD_UP;
                deliverKeyEvent(new KeyEvent(time, time,
                        KeyEvent.ACTION_DOWN, mLastJoystickYKeyCode, 0, metaState,
                        deviceId, 0, KeyEvent.FLAG_FALLBACK, source), false);
            }
        }
    }

    /**
     * See if the key event means we should leave touch mode (and leave touch mode if so).
     * @param event The key event.
     * @return Whether this key event should be consumed (meaning the act of
     *   leaving touch mode alone is considered the event).
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.236 -0500", hash_original_method = "4A4EC0979E3C48040C37CBDD240E0778", hash_generated_method = "72AE707283996347832E3A05278E2AFD")
    
private boolean checkForLeavingTouchModeAndConsume(KeyEvent event) {
        // Only relevant in touch mode.
        if (!mAttachInfo.mInTouchMode) {
            return false;
        }

        // Only consider leaving touch mode on DOWN or MULTIPLE actions, never on UP.
        final int action = event.getAction();
        if (action != KeyEvent.ACTION_DOWN && action != KeyEvent.ACTION_MULTIPLE) {
            return false;
        }

        // Don't leave touch mode if the IME told us not to.
        if ((event.getFlags() & KeyEvent.FLAG_KEEP_TOUCH_MODE) != 0) {
            return false;
        }

        // If the key can be used for keyboard navigation then leave touch mode
        // and select a focused view if needed (in ensureTouchMode).
        // When a new focused view is selected, we consume the navigation key because
        // navigation doesn't make much sense unless a view already has focus so
        // the key's purpose is to set focus.
        if (isNavigationKey(event)) {
            return ensureTouchMode(false);
        }

        // If the key can be used for typing then leave touch mode
        // and select a focused view if needed (in ensureTouchMode).
        // Always allow the view to process the typing key.
        if (isTypingKey(event)) {
            ensureTouchMode(false);
            return false;
        }

        return false;
    }
    
    class ResizedInfo {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.854 -0500", hash_original_field = "47DADDCDE2ABE98E0EA742CE6D950BCA", hash_generated_field = "47DADDCDE2ABE98E0EA742CE6D950BCA")

        Rect coveredInsets;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.856 -0500", hash_original_field = "0B179B80C8AEF7EE8B7A9887F27D40FA", hash_generated_field = "0B179B80C8AEF7EE8B7A9887F27D40FA")

        Rect visibleInsets;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.859 -0500", hash_original_field = "DD2677A28540A2EE77D6F7429A2F8892", hash_generated_field = "DD2677A28540A2EE77D6F7429A2F8892")

        Configuration newConfig;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.755 -0400", hash_original_method = "50B840B7E2FD8E0275C71397DAD0B09A", hash_generated_method = "50B840B7E2FD8E0275C71397DAD0B09A")
        public ResizedInfo ()
        {
            //Synthesized constructor
        }

    }
    
    static final class SystemUiVisibilityInfo {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.932 -0500", hash_original_field = "C4ECE7ED8A0F11C4F90796D05BE13ED7", hash_generated_field = "C4ECE7ED8A0F11C4F90796D05BE13ED7")

        int seq;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.934 -0500", hash_original_field = "29F921E441BDF940DE75A15B6BF90A8A", hash_generated_field = "29F921E441BDF940DE75A15B6BF90A8A")

        int globalVisibility;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.936 -0500", hash_original_field = "1D88C8081D2F96806DB5C538B6E7C0F8", hash_generated_field = "1D88C8081D2F96806DB5C538B6E7C0F8")

        int localValue;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:31.938 -0500", hash_original_field = "824A34BA64EB40D64E4FA95CF88B8DD6", hash_generated_field = "824A34BA64EB40D64E4FA95CF88B8DD6")

        int localChanges;
        
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.755 -0400", hash_original_method = "A01B0E4A631704C3007E2CC2ECBBD6C3", hash_generated_method = "A01B0E4A631704C3007E2CC2ECBBD6C3")
        public SystemUiVisibilityInfo ()
        {
            //Synthesized constructor
        }

    }
    
    static class InputEventMessage {

        /**
         * Return a new Message instance from the global pool. Allows us to
         * avoid allocating new objects in many cases.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.345 -0500", hash_original_method = "00E59ACDF972C6E7146BB1869D625C11", hash_generated_method = "AECBD11D2AF29C6DBB0AB5F019CE58D8")
        
public static InputEventMessage obtain(Message msg) {
            synchronized (sPoolSync) {
                if (sPool != null) {
                    InputEventMessage m = sPool;
                    sPool = m.mNext;
                    m.mNext = null;
                    sPoolSize--;
                    m.mMessage = msg;
                    return m;
                }
            }
            return new InputEventMessage(msg);
        }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.332 -0500", hash_original_field = "FF70C662CB92BB1987F6CF4637424D6E", hash_generated_field = "D5B99AC4B86CE940DBBD3CF3FA1D542C")

        private static final Object sPoolSync = new Object();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.334 -0500", hash_original_field = "2190A130115C70EB39DEF863014CD391", hash_generated_field = "3276E3FE464DBE4BDC4F9753A4DD418D")

        private static InputEventMessage sPool;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.337 -0500", hash_original_field = "58C64529682BFD4E11D662842F129355", hash_generated_field = "A60993B78066ACEFAC0F4A6F4AB10BB4")

        private static int sPoolSize = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.339 -0500", hash_original_field = "3257F81BBFE679E3360141AA5EA9D518", hash_generated_field = "FB8E412EAB46029C42E8E38ED918C6D9")

        private static final int MAX_POOL_SIZE = 10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.326 -0500", hash_original_field = "2D41D548AF5E6C9BAD3BF2AC7B0EDE61", hash_generated_field = "2D41D548AF5E6C9BAD3BF2AC7B0EDE61")

        Message mMessage;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.328 -0500", hash_original_field = "BB8AFFB0007C8D035A06590D15408355", hash_generated_field = "BB8AFFB0007C8D035A06590D15408355")

        InputEventMessage mNext;

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.342 -0500", hash_original_method = "B714885B0648B0EB69373E467D5A2ACF", hash_generated_method = "1BC0FC7EDB9C18099C57699D0F93DF75")
        
private InputEventMessage(Message m) {
            mMessage = m;
            mNext = null;
        }

        /**
         * Return the message to the pool.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.347 -0500", hash_original_method = "9F2D00AD0B3B7E97E6983E3E4DE01E8D", hash_generated_method = "56906FD291BF502C1DD05AC4C1CC4DDF")
        
public void recycle() {
            mMessage.recycle();
            synchronized (sPoolSync) {
                if (sPoolSize < MAX_POOL_SIZE) {
                    mNext = sPool;
                    sPool = this;
                    sPoolSize++;
                }
            }

        }
    }
    
    class TakenSurfaceHolder extends BaseSurfaceHolder {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.755 -0400", hash_original_method = "C250C7CF3696759C39C0C66232FB4E2F", hash_generated_method = "C250C7CF3696759C39C0C66232FB4E2F")
        public TakenSurfaceHolder ()
        {
            //Synthesized constructor
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.410 -0500", hash_original_method = "93900AD5EB4A5A0D65615E175C2FC0CA", hash_generated_method = "641270011D37C87455B47BE6DABB1668")
        
@Override
        public boolean onAllowLockCanvas() {
            return mDrawingAllowed;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.413 -0500", hash_original_method = "CAFD67152D224915C2628F6ACAAF5E06", hash_generated_method = "9218087207E10D82C6858D7FE0212E04")
        
@Override
        public void onRelayoutContainer() {
            // Not currently interesting -- from changing between fixed and layout size.
        }

        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.415 -0500", hash_original_method = "E07C2927AF02C0614ECCFDEAF72047C2", hash_generated_method = "6D23CB0D78B1D93FF14D1303BE528EE1")
        
public void setFormat(int format) {
            ((RootViewSurfaceTaker)mView).setSurfaceFormat(format);
        }

        @DSSafe(DSCat.SAFE_LIST)
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.417 -0500", hash_original_method = "EE34E0B82BE2B114D60991753727E9A6", hash_generated_method = "5D83BAA8B38B494ACB639C1B18C6C59C")
        
public void setType(int type) {
            ((RootViewSurfaceTaker)mView).setSurfaceType(type);
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.420 -0500", hash_original_method = "65C8D4CF87AA6164C88CB73B7231A722", hash_generated_method = "EB3ABEF4255BA86BD116DA73D1C2814A")
        
@Override
        public void onUpdateSurface() {
            // We take care of format and type changes on our own.
            throw new IllegalStateException("Shouldn't be here");
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.423 -0500", hash_original_method = "FBEC596A43003FDD0C674BF719352967", hash_generated_method = "73A0AFFD54660C8FDA50E4F3EAE62434")
        
public boolean isCreating() {
            return mIsCreating;
        }

        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.425 -0500", hash_original_method = "DFAAE278D74727ACF1AA5508094F804D", hash_generated_method = "84AB21DCAB4D19CE1C040E40DEDE3BD0")
        
@Override
        public void setFixedSize(int width, int height) {
            throw new UnsupportedOperationException(
                    "Currently only support sizing from layout");
        }
        
        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.428 -0500", hash_original_method = "21F6CF6D8B53BD856057ED05ABC33177", hash_generated_method = "85AFB2D0337BC8298CA8AFC8C1EB3A0D")
        
public void setKeepScreenOn(boolean screenOn) {
            ((RootViewSurfaceTaker)mView).setSurfaceKeepScreenOn(screenOn);
        }
        
    }
    
    static class InputMethodCallback extends IInputMethodCallback.Stub {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.433 -0500", hash_original_field = "05FBD81E4992DDDFF83F422E6000AD3C", hash_generated_field = "E7FFD6E9BC298C91066F7F076BB25FC3")

        private WeakReference<ViewRootImpl> mViewAncestor;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.436 -0500", hash_original_method = "54191F901FEF749694D67ED7BF80E958", hash_generated_method = "DF20FBE55CFC61435212910EDF6386C9")
        
public InputMethodCallback(ViewRootImpl viewAncestor) {
            mViewAncestor = new WeakReference<ViewRootImpl>(viewAncestor);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.439 -0500", hash_original_method = "BE17249E230FCA094C5B0C5E3A1F0AA4", hash_generated_method = "6DFC46DFB3FE4978F6652BE27F89E190")
        
public void finishedEvent(int seq, boolean handled) {
            final ViewRootImpl viewAncestor = mViewAncestor.get();
            if (viewAncestor != null) {
                viewAncestor.dispatchFinishedEvent(seq, handled);
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.441 -0500", hash_original_method = "93549AC7AA704598E881A2A0D800AB4C", hash_generated_method = "F5D57C835D03A77F1257D7C981E2D1A3")
        
public void sessionCreated(IInputMethodSession session) {
            // Stub -- not for use in the client.
        }
        
    }
    
    static class W extends IWindow.Stub {

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.460 -0500", hash_original_method = "0F834A9D69D3D9A8D8102CFC29F0EF8E", hash_generated_method = "07BF2095C8AB8714CC7FFC034E0187CF")
        
private static int checkCallingPermission(String permission) {
            try {
                return ActivityManagerNative.getDefault().checkPermission(
                        permission, Binder.getCallingPid(), Binder.getCallingUid());
            } catch (RemoteException e) {
                return PackageManager.PERMISSION_DENIED;
            }
        }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.446 -0500", hash_original_field = "05FBD81E4992DDDFF83F422E6000AD3C", hash_generated_field = "E7FFD6E9BC298C91066F7F076BB25FC3")

        private  WeakReference<ViewRootImpl> mViewAncestor;

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.448 -0500", hash_original_method = "D1CF0E60435976F2AA38BD5BC7DA8E27", hash_generated_method = "D1CF0E60435976F2AA38BD5BC7DA8E27")
        
W(ViewRootImpl viewAncestor) {
            mViewAncestor = new WeakReference<ViewRootImpl>(viewAncestor);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.451 -0500", hash_original_method = "A648B76CE506B7CD274906DE238C17D8", hash_generated_method = "5756516D537D0064222A7278B2752DE6")
        
public void resized(int w, int h, Rect coveredInsets, Rect visibleInsets,
                boolean reportDraw, Configuration newConfig) {
            final ViewRootImpl viewAncestor = mViewAncestor.get();
            if (viewAncestor != null) {
                viewAncestor.dispatchResized(w, h, coveredInsets, visibleInsets, reportDraw,
                        newConfig);
            }
        }

        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.453 -0500", hash_original_method = "EB98E21C67C8D9A44F58CD671F491CDA", hash_generated_method = "1AA5B0E3B90059952EB2E33BF602E2DD")
        
public void dispatchAppVisibility(boolean visible) {
            final ViewRootImpl viewAncestor = mViewAncestor.get();
            if (viewAncestor != null) {
                viewAncestor.dispatchAppVisibility(visible);
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.456 -0500", hash_original_method = "5CE742A9FFA814199F790759E49D980E", hash_generated_method = "A098B1B5B7A6BEC83EC9298144733CD3")
        
public void dispatchGetNewSurface() {
            final ViewRootImpl viewAncestor = mViewAncestor.get();
            if (viewAncestor != null) {
                viewAncestor.dispatchGetNewSurface();
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.458 -0500", hash_original_method = "294D771D49852BEC83940B0D8623D316", hash_generated_method = "29AA99C3ADFCAFF286AB9A0603ACE86A")
        
public void windowFocusChanged(boolean hasFocus, boolean inTouchMode) {
            final ViewRootImpl viewAncestor = mViewAncestor.get();
            if (viewAncestor != null) {
                viewAncestor.windowFocusChanged(hasFocus, inTouchMode);
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.463 -0500", hash_original_method = "BAC64B61AF453BEA5AB28D214B8FF7C5", hash_generated_method = "B7310DCB3C54FF6545F41A9A88782EBD")
        
public void executeCommand(String command, String parameters, ParcelFileDescriptor out) {
            final ViewRootImpl viewAncestor = mViewAncestor.get();
            if (viewAncestor != null) {
                final View view = viewAncestor.mView;
                if (view != null) {
                    if (checkCallingPermission(Manifest.permission.DUMP) !=
                            PackageManager.PERMISSION_GRANTED) {
                        throw new SecurityException("Insufficient permissions to invoke"
                                + " executeCommand() from pid=" + Binder.getCallingPid()
                                + ", uid=" + Binder.getCallingUid());
                    }

                    OutputStream clientStream = null;
                    try {
                        clientStream = new ParcelFileDescriptor.AutoCloseOutputStream(out);
                        ViewDebug.dispatchCommand(view, command, parameters, clientStream);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        if (clientStream != null) {
                            try {
                                clientStream.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.467 -0500", hash_original_method = "0341134904B032AC1241DC2205E79E01", hash_generated_method = "1520A2AB5E02DEC6A2864CEFDB96A8C7")
        
public void closeSystemDialogs(String reason) {
            final ViewRootImpl viewAncestor = mViewAncestor.get();
            if (viewAncestor != null) {
                viewAncestor.dispatchCloseSystemDialogs(reason);
            }
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.470 -0500", hash_original_method = "0D1309853D34ED0E4A19A33B54F85778", hash_generated_method = "0E92EF4723CF8D342FB06849384E7A1C")
        
public void dispatchWallpaperOffsets(float x, float y, float xStep, float yStep,
                boolean sync) {
            if (sync) {
                try {
                    sWindowSession.wallpaperOffsetsComplete(asBinder());
                } catch (RemoteException e) {
                }
            }
        }

        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.472 -0500", hash_original_method = "084CB00632E8F4F79253F4CBB0703969", hash_generated_method = "92756D8FB0326E7357CC798315ACE1D5")
        
public void dispatchWallpaperCommand(String action, int x, int y,
                int z, Bundle extras, boolean sync) {
            if (sync) {
                try {
                    sWindowSession.wallpaperCommandComplete(asBinder(), null);
                } catch (RemoteException e) {
                }
            }
        }

        /* Drag/drop */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.474 -0500", hash_original_method = "AE33DC8C57E72B3B1EEF7B37E6DC4CB6", hash_generated_method = "315ED7A778F2010B6DADE72CB513AF76")
        
public void dispatchDragEvent(DragEvent event) {
            final ViewRootImpl viewAncestor = mViewAncestor.get();
            if (viewAncestor != null) {
                viewAncestor.dispatchDragEvent(event);
            }
        }

        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.477 -0500", hash_original_method = "0BC30404A661769E03F23017D2DE8196", hash_generated_method = "236E1F5FB1F72E71A81D18D8C086CDA0")
        
public void dispatchSystemUiVisibilityChanged(int seq, int globalVisibility,
                int localValue, int localChanges) {
            final ViewRootImpl viewAncestor = mViewAncestor.get();
            if (viewAncestor != null) {
                viewAncestor.dispatchSystemUiVisibilityChanged(seq, globalVisibility,
                        localValue, localChanges);
            }
        }
        
    }
    
    static final class TrackballAxis {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.483 -0500", hash_original_field = "00B8383B31D675C12A672A6EA615A40E", hash_generated_field = "973768C090750F2E47DF477502675CB2")

        static final float MAX_ACCELERATION = 20;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.485 -0500", hash_original_field = "4CE0AEE8EF6348FC4EC2CF6BB7423123", hash_generated_field = "107EAA5D46224CB4A8CF941F26CA7ECA")

        static final long FAST_MOVE_TIME = 150;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.488 -0500", hash_original_field = "35A7367B8CD4B08D7F29205796531DE9", hash_generated_field = "F2C6BC14D2039A7C27D6C313A91A0FF8")

        static final float ACCEL_MOVE_SCALING_FACTOR = (1.0f/40);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.490 -0500", hash_original_field = "722609B4032E08961786F0112C7E37CB", hash_generated_field = "722609B4032E08961786F0112C7E37CB")

        float position;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.492 -0500", hash_original_field = "2BC82C89B8860ABF3FA89A1E7B3206F3", hash_generated_field = "2BC82C89B8860ABF3FA89A1E7B3206F3")

        float absPosition;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.494 -0500", hash_original_field = "F2035D00830CD97606C06BFD7F9DAD98", hash_generated_field = "F2035D00830CD97606C06BFD7F9DAD98")

        float acceleration = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.497 -0500", hash_original_field = "629DD7870B747F7AC2FDA49880D52BD5", hash_generated_field = "629DD7870B747F7AC2FDA49880D52BD5")

        long lastMoveTime = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.499 -0500", hash_original_field = "4351D9E8E936913B3754B1B6ADCCBF7A", hash_generated_field = "4351D9E8E936913B3754B1B6ADCCBF7A")

        int step;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.501 -0500", hash_original_field = "32FF19239F28E132D49E8333CE74D2D7", hash_generated_field = "32FF19239F28E132D49E8333CE74D2D7")

        int dir;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.503 -0500", hash_original_field = "887ADC84C7F0FC3F8C0B95BBC171A673", hash_generated_field = "887ADC84C7F0FC3F8C0B95BBC171A673")

        int nonAccelMovement;
        
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.763 -0400", hash_original_method = "D5D0F3DD2FCFEEF1D3847F5A318F142A", hash_generated_method = "D5D0F3DD2FCFEEF1D3847F5A318F142A")
        public TrackballAxis ()
        {
            //Synthesized constructor
        }

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.506 -0500", hash_original_method = "A6304CADA1EF057D91BA6FF70064FCCC", hash_generated_method = "A6304CADA1EF057D91BA6FF70064FCCC")
        
void reset(int _step) {
            position = 0;
            acceleration = 1;
            lastMoveTime = 0;
            step = _step;
            dir = 0;
        }

        /**
         * Add trackball movement into the state.  If the direction of movement
         * has been reversed, the state is reset before adding the
         * movement (so that you don't have to compensate for any previously
         * collected movement before see the result of the movement in the
         * new direction).
         *
         * @return Returns the absolute value of the amount of movement
         * collected so far.
         */
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.510 -0500", hash_original_method = "7BE12B55CFE54AFD4A89AB866136213C", hash_generated_method = "A4791E68B3620EA3E9FF0ACD146CF78D")
        
float collect(float off, long time, String axis) {
            long normTime;
            if (off > 0) {
                normTime = (long)(off * FAST_MOVE_TIME);
                if (dir < 0) {
                    if (DEBUG_TRACKBALL) Log.v(TAG, axis + " reversed to positive!");
                    position = 0;
                    step = 0;
                    acceleration = 1;
                    lastMoveTime = 0;
                }
                dir = 1;
            } else if (off < 0) {
                normTime = (long)((-off) * FAST_MOVE_TIME);
                if (dir > 0) {
                    if (DEBUG_TRACKBALL) Log.v(TAG, axis + " reversed to negative!");
                    position = 0;
                    step = 0;
                    acceleration = 1;
                    lastMoveTime = 0;
                }
                dir = -1;
            } else {
                normTime = 0;
            }

            // The number of milliseconds between each movement that is
            // considered "normal" and will not result in any acceleration
            // or deceleration, scaled by the offset we have here.
            if (normTime > 0) {
                long delta = time - lastMoveTime;
                lastMoveTime = time;
                float acc = acceleration;
                if (delta < normTime) {
                    // The user is scrolling rapidly, so increase acceleration.
                    float scale = (normTime-delta) * ACCEL_MOVE_SCALING_FACTOR;
                    if (scale > 1) acc *= scale;
                    if (DEBUG_TRACKBALL) Log.v(TAG, axis + " accelerate: off="
                            + off + " normTime=" + normTime + " delta=" + delta
                            + " scale=" + scale + " acc=" + acc);
                    acceleration = acc < MAX_ACCELERATION ? acc : MAX_ACCELERATION;
                } else {
                    // The user is scrolling slowly, so decrease acceleration.
                    float scale = (delta-normTime) * ACCEL_MOVE_SCALING_FACTOR;
                    if (scale > 1) acc /= scale;
                    if (DEBUG_TRACKBALL) Log.v(TAG, axis + " deccelerate: off="
                            + off + " normTime=" + normTime + " delta=" + delta
                            + " scale=" + scale + " acc=" + acc);
                    acceleration = acc > 1 ? acc : 1;
                }
            }
            position += off;
            return (absPosition = Math.abs(position));
        }

        /**
         * Generate the number of discrete movement events appropriate for
         * the currently collected trackball movement.
         *
         * @param precision The minimum movement required to generate the
         * first discrete movement.
         *
         * @return Returns the number of discrete movements, either positive
         * or negative, or 0 if there is not enough trackball movement yet
         * for a discrete movement.
         */
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.513 -0500", hash_original_method = "94A3484B43A305FA2D2533E09119590B", hash_generated_method = "7EF47E4FA708A04D233927A5180BBD87")
        
int generate(float precision) {
            int movement = 0;
            nonAccelMovement = 0;
            do {
                final int dir = position >= 0 ? 1 : -1;
                switch (step) {
                    // If we are going to execute the first step, then we want
                    // to do this as soon as possible instead of waiting for
                    // a full movement, in order to make things look responsive.
                    case 0:
                        if (absPosition < precision) {
                            return movement;
                        }
                        movement += dir;
                        nonAccelMovement += dir;
                        step = 1;
                        break;
                    // If we have generated the first movement, then we need
                    // to wait for the second complete trackball motion before
                    // generating the second discrete movement.
                    case 1:
                        if (absPosition < 2) {
                            return movement;
                        }
                        movement += dir;
                        nonAccelMovement += dir;
                        position += dir > 0 ? -2 : 2;
                        absPosition = Math.abs(position);
                        step = 2;
                        break;
                    // After the first two, we generate discrete movements
                    // consistently with the trackball, applying an acceleration
                    // if the trackball is moving quickly.  This is a simple
                    // acceleration on top of what we already compute based
                    // on how quickly the wheel is being turned, to apply
                    // a longer increasing acceleration to continuous movement
                    // in one direction.
                    default:
                        if (absPosition < 1) {
                            return movement;
                        }
                        movement += dir;
                        position += dir >= 0 ? -1 : 1;
                        absPosition = Math.abs(position);
                        float acc = acceleration;
                        acc *= 1.1f;
                        acceleration = acc < MAX_ACCELERATION ? acc : acceleration;
                        break;
                }
            } while (true);
        }
    }
    
    public static final class CalledFromWrongThreadException extends AndroidRuntimeException {
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.520 -0500", hash_original_method = "D704015D17B148E0274888D3BE6B5A1B", hash_generated_method = "F83B8D5A7B44F0573183674A6D02059D")
        
public CalledFromWrongThreadException(String msg) {
            super(msg);
        }
        
    }
    
    static final class RunQueue {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.564 -0500", hash_original_field = "C81BE78E8F41CF30B45F189A5C4E6E4A", hash_generated_field = "F821D9D70BB932D42D3D9D491D5A29A1")

        private final ArrayList<HandlerAction> mActions = new ArrayList<HandlerAction>();
        
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.767 -0400", hash_original_method = "9D853D73EE638AB90ACD5CD9573763A9", hash_generated_method = "9D853D73EE638AB90ACD5CD9573763A9")
        public RunQueue ()
        {
            //Synthesized constructor
        }

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.567 -0500", hash_original_method = "D30AD5886AAB6A1562A9D91A9C03E0DF", hash_generated_method = "D30AD5886AAB6A1562A9D91A9C03E0DF")
        
void post(Runnable action) {
            postDelayed(action, 0);
        }

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.569 -0500", hash_original_method = "37D90AC712BBF73BCC19C8079034F8F1", hash_generated_method = "37D90AC712BBF73BCC19C8079034F8F1")
        
void postDelayed(Runnable action, long delayMillis) {
            HandlerAction handlerAction = new HandlerAction();
            handlerAction.action = action;
            handlerAction.delay = delayMillis;

            synchronized (mActions) {
                mActions.add(handlerAction);
            }
        }

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.572 -0500", hash_original_method = "5BA3715297222A78241D425B9BCC6DE7", hash_generated_method = "A571AB3380815F9EF94D2E88926E2615")
        
void removeCallbacks(Runnable action) {
            final HandlerAction handlerAction = new HandlerAction();
            handlerAction.action = action;

            synchronized (mActions) {
                final ArrayList<HandlerAction> actions = mActions;

                while (actions.remove(handlerAction)) {
                    // Keep going
                }
            }
        }

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.574 -0500", hash_original_method = "3626F7B757A14315643B29FE9818088B", hash_generated_method = "3626F7B757A14315643B29FE9818088B")
        
void executeActions(Handler handler) {
            synchronized (mActions) {
                final ArrayList<HandlerAction> actions = mActions;
                final int count = actions.size();

                for (int i = 0; i < count; i++) {
                    final HandlerAction handlerAction = actions.get(i);
                    handler.postDelayed(handlerAction.action, handlerAction.delay);
                }

                actions.clear();
            }
        }
        
        private static class HandlerAction {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.577 -0500", hash_original_field = "6E604B84976ABCF0C30A63D2F996D309", hash_generated_field = "6E604B84976ABCF0C30A63D2F996D309")

            Runnable action;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.579 -0500", hash_original_field = "D26E4607AC64CA745B70892C422A8C3F", hash_generated_field = "D26E4607AC64CA745B70892C422A8C3F")

            long delay;
            
            @DSComment("Private Method")
            @DSBan(DSCat.PRIVATE_METHOD)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.769 -0400", hash_original_method = "30472C53850B994B9A76B3EFD24AA1BA", hash_generated_method = "30472C53850B994B9A76B3EFD24AA1BA")
            public HandlerAction ()
            {
                //Synthesized constructor
            }

            @DSSafe(DSCat.SAFE_LIST)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.582 -0500", hash_original_method = "EC304D8CC82834BC90F0FBE66AB5A5B9", hash_generated_method = "C938ED2AF18512D30AC7B0FC7C115596")
            
@Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;

                HandlerAction that = (HandlerAction) o;
                return !(action != null ? !action.equals(that.action) : that.action != null);

            }

            @DSSafe(DSCat.SAFE_LIST)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.584 -0500", hash_original_method = "09AD30FBB7C8AE284E2A2DAD39966BF7", hash_generated_method = "4CB5C9186A3BFC50BEF59419A91AF26D")
            
@Override
            public int hashCode() {
                int result = action != null ? action.hashCode() : 0;
                result = 31 * result + (int) (delay ^ (delay >>> 32));
                return result;
            }
            
        }
        
    }
    
    final class AccessibilityInteractionConnectionManager implements AccessibilityStateChangeListener {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.770 -0400", hash_original_method = "B130C22D2DF300A6E0FC543B73826678", hash_generated_method = "B130C22D2DF300A6E0FC543B73826678")
        public AccessibilityInteractionConnectionManager ()
        {
            //Synthesized constructor
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.592 -0500", hash_original_method = "8A20E0BF76F2FE3CB2E135C12DE9692E", hash_generated_method = "7B279F50435FA8255EAB79B91BDE1E3F")
        
public void onAccessibilityStateChanged(boolean enabled) {
            if (enabled) {
                ensureConnection();
            } else {
                ensureNoConnection();
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.595 -0500", hash_original_method = "92A9A6CA8F5EA055DBA3D736397E37E0", hash_generated_method = "1ACFFF86B09C9A33479524FFD8542EB3")
        
public void ensureConnection() {
            final boolean registered = mAttachInfo.mAccessibilityWindowId != View.NO_ID;
            if (!registered) {
                mAttachInfo.mAccessibilityWindowId =
                    mAccessibilityManager.addAccessibilityInteractionConnection(mWindow,
                            new AccessibilityInteractionConnection(ViewRootImpl.this));
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.597 -0500", hash_original_method = "C22E99B1A3881672FEB45F6BE843B278", hash_generated_method = "38C6266529C6DF162FF2C2ECD9FF0E71")
        
public void ensureNoConnection() {
            final boolean registered = mAttachInfo.mAccessibilityWindowId != View.NO_ID;
            if (registered) {
                mAttachInfo.mAccessibilityWindowId = View.NO_ID;
                mAccessibilityManager.removeAccessibilityInteractionConnection(mWindow);
            }
        }
        
    }
    
    static final class AccessibilityInteractionConnection extends IAccessibilityInteractionConnection.Stub {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.603 -0500", hash_original_field = "38FE20C8D892B3E40E6344420E266A42", hash_generated_field = "53CC87D794214F8DCA645D22E8A949F9")

        private  WeakReference<ViewRootImpl> mRootImpl;

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.606 -0500", hash_original_method = "D539A7CCB822AF3CDF20BB7941121D94", hash_generated_method = "D539A7CCB822AF3CDF20BB7941121D94")
        
AccessibilityInteractionConnection(ViewRootImpl viewAncestor) {
            mRootImpl = new WeakReference<ViewRootImpl>(viewAncestor);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.608 -0500", hash_original_method = "EE5D719A51240BF55D02CDA16E5D3A9D", hash_generated_method = "FE8513CAD9EF20681DFE356E81C983FA")
        
public void findAccessibilityNodeInfoByAccessibilityId(int accessibilityId,
                int interactionId, IAccessibilityInteractionConnectionCallback callback,
                int interrogatingPid, long interrogatingTid) {
            ViewRootImpl viewRootImpl = mRootImpl.get();
            if (viewRootImpl != null) {
                viewRootImpl.getAccessibilityInteractionController()
                    .findAccessibilityNodeInfoByAccessibilityIdClientThread(accessibilityId,
                        interactionId, callback, interrogatingPid, interrogatingTid);
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.611 -0500", hash_original_method = "150D2C0671760B2C49B4A2BEA648BFF0", hash_generated_method = "F5E457DE3FB8EC4D1936A860581FD8EA")
        
public void performAccessibilityAction(int accessibilityId, int action,
                int interactionId, IAccessibilityInteractionConnectionCallback callback,
                int interogatingPid, long interrogatingTid) {
            ViewRootImpl viewRootImpl = mRootImpl.get();
            if (viewRootImpl != null) {
                viewRootImpl.getAccessibilityInteractionController()
                    .performAccessibilityActionClientThread(accessibilityId, action, interactionId,
                            callback, interogatingPid, interrogatingTid);
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.613 -0500", hash_original_method = "480C93EC256597CABC1B248D841B9A3E", hash_generated_method = "F56E630BCCFBF2C90F8C668E9085C419")
        
public void findAccessibilityNodeInfoByViewId(int viewId,
                int interactionId, IAccessibilityInteractionConnectionCallback callback,
                int interrogatingPid, long interrogatingTid) {
            ViewRootImpl viewRootImpl = mRootImpl.get();
            if (viewRootImpl != null) {
                viewRootImpl.getAccessibilityInteractionController()
                    .findAccessibilityNodeInfoByViewIdClientThread(viewId, interactionId, callback,
                            interrogatingPid, interrogatingTid);
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.616 -0500", hash_original_method = "9891EE3B36B5E5E829B36E62164827F4", hash_generated_method = "430470221EF7078B623FADEB66A05EFE")
        
public void findAccessibilityNodeInfosByViewText(String text, int accessibilityId,
                int interactionId, IAccessibilityInteractionConnectionCallback callback,
                int interrogatingPid, long interrogatingTid) {
            ViewRootImpl viewRootImpl = mRootImpl.get();
            if (viewRootImpl != null) {
                viewRootImpl.getAccessibilityInteractionController()
                    .findAccessibilityNodeInfosByViewTextClientThread(text, accessibilityId,
                            interactionId, callback, interrogatingPid, interrogatingTid);
            }
        }
        
    }
    
    final class AccessibilityInteractionController {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.621 -0500", hash_original_field = "C19CA3CBA263B3369E1B280768D70DF1", hash_generated_field = "9C5EE85F599ECE1BA2255910141DCB18")

        private static final int POOL_SIZE = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.623 -0500", hash_original_field = "9F66DF5D60BD13D318D252FC7D95B048", hash_generated_field = "2FD14E145489DD00A8E7926145DAD829")

        private ArrayList<AccessibilityNodeInfo> mTempAccessibilityNodeInfoList =
            new ArrayList<AccessibilityNodeInfo>();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.772 -0400", hash_original_field = "87ED3D57DB6E520DDD2EDF337ED05257", hash_generated_field = "38B485AE2AFC301A08861106EB06C4F1")

        private final Pool<SomeArgs> mPool = Pools.synchronizedPool(Pools.finitePool(
                new PoolableManager<SomeArgs>() {
                    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.626 -0500", hash_original_method = "DD2C708022132542F699B26FF7437A78", hash_generated_method = "CC4221934B32164BC8BF5B8033D190C1")
            
public SomeArgs newInstance() {
                        return new SomeArgs();
                    }

                    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.629 -0500", hash_original_method = "B9A035640901F22D9CBE7B52C3D9C219", hash_generated_method = "8A1D060FCB212FF98474C6EC827B8534")
            
public void onAcquired(SomeArgs info) {
                        /* do nothing */
                    }

                    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.632 -0500", hash_original_method = "E37733728C8C4AE8D2D45E6FCC799DD8", hash_generated_method = "A69DC2A4B67CD845B8037671662C19BB")
            
public void onReleased(SomeArgs info) {
                        info.clear();
                    }
                }, POOL_SIZE)
        );
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.772 -0400", hash_original_method = "AB87C85D23FC0F804AE52922F865B9CD", hash_generated_method = "AB87C85D23FC0F804AE52922F865B9CD")
        public AccessibilityInteractionController ()
        {
            //Synthesized constructor
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.670 -0500", hash_original_method = "2F6D3BCB232629523E59C738D4AD3A95", hash_generated_method = "6B789979A032D5DB32D01DE131AD5F1F")
        
public void findAccessibilityNodeInfoByAccessibilityIdClientThread(int accessibilityId,
                int interactionId, IAccessibilityInteractionConnectionCallback callback,
                int interrogatingPid, long interrogatingTid) {
            Message message = Message.obtain();
            message.what = DO_FIND_ACCESSIBLITY_NODE_INFO_BY_ACCESSIBILITY_ID;
            message.arg1 = accessibilityId;
            message.arg2 = interactionId;
            message.obj = callback;
            // If the interrogation is performed by the same thread as the main UI
            // thread in this process, set the message as a static reference so
            // after this call completes the same thread but in the interrogating
            // client can handle the message to generate the result.
            if (interrogatingPid == Process.myPid()
                    && interrogatingTid == Looper.getMainLooper().getThread().getId()) {
                message.setTarget(ViewRootImpl.this);
                AccessibilityInteractionClient.getInstance().setSameThreadMessage(message);
            } else {
                sendMessage(message);
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.673 -0500", hash_original_method = "145D07D178B3372CAAF2CB93D024125F", hash_generated_method = "A0102C9C3E9D8241FDD2AC8B06DFB35B")
        
public void findAccessibilityNodeInfoByAccessibilityIdUiThread(Message message) {
            final int accessibilityId = message.arg1;
            final int interactionId = message.arg2;
            final IAccessibilityInteractionConnectionCallback callback =
                (IAccessibilityInteractionConnectionCallback) message.obj;

            AccessibilityNodeInfo info = null;
            try {
                View target = findViewByAccessibilityId(accessibilityId);
                if (target != null) {
                    info = target.createAccessibilityNodeInfo();
                }
            } finally {
                try {
                    callback.setFindAccessibilityNodeInfoResult(info, interactionId);
                } catch (RemoteException re) {
                    /* ignore - the other side will time out */
                }
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.677 -0500", hash_original_method = "ADA0B35A4DB3EC9F459DCBB8D66C434D", hash_generated_method = "B55FE3BE21A3A5D76EAB6D4D0873EA0A")
        
public void findAccessibilityNodeInfoByViewIdClientThread(int viewId, int interactionId,
                IAccessibilityInteractionConnectionCallback callback, int interrogatingPid,
                long interrogatingTid) {
            Message message = Message.obtain();
            message.what = DO_FIND_ACCESSIBLITY_NODE_INFO_BY_VIEW_ID;
            message.arg1 = viewId;
            message.arg2 = interactionId;
            message.obj = callback;
            // If the interrogation is performed by the same thread as the main UI
            // thread in this process, set the message as a static reference so
            // after this call completes the same thread but in the interrogating
            // client can handle the message to generate the result.
            if (interrogatingPid == Process.myPid()
                    && interrogatingTid == Looper.getMainLooper().getThread().getId()) {
                message.setTarget(ViewRootImpl.this);
                AccessibilityInteractionClient.getInstance().setSameThreadMessage(message);
            } else {
                sendMessage(message);
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.680 -0500", hash_original_method = "6B2A3077FB5BC3E815A1727E6C950B5E", hash_generated_method = "0AE1A63C0B893CFAE58D0EE2B0A581A0")
        
public void findAccessibilityNodeInfoByViewIdUiThread(Message message) {
            final int viewId = message.arg1;
            final int interactionId = message.arg2;
            final IAccessibilityInteractionConnectionCallback callback =
                (IAccessibilityInteractionConnectionCallback) message.obj;

            AccessibilityNodeInfo info = null;
            try {
                View root = ViewRootImpl.this.mView;
                View target = root.findViewById(viewId);
                if (target != null && target.getVisibility() == View.VISIBLE) {
                    info = target.createAccessibilityNodeInfo();
                }
            } finally {
                try {
                    callback.setFindAccessibilityNodeInfoResult(info, interactionId);
                } catch (RemoteException re) {
                    /* ignore - the other side will time out */
                }
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.683 -0500", hash_original_method = "74A990105163D5D10216C3B475062D28", hash_generated_method = "4BFF586F03A442F492F62C1B5776FD91")
        
public void findAccessibilityNodeInfosByViewTextClientThread(String text,
                int accessibilityViewId, int interactionId,
                IAccessibilityInteractionConnectionCallback callback, int interrogatingPid,
                long interrogatingTid) {
            Message message = Message.obtain();
            message.what = DO_FIND_ACCESSIBLITY_NODE_INFO_BY_VIEW_TEXT;
            SomeArgs args = mPool.acquire();
            args.arg1 = text;
            args.argi1 = accessibilityViewId;
            args.argi2 = interactionId;
            args.arg2 = callback;
            message.obj = args;
            // If the interrogation is performed by the same thread as the main UI
            // thread in this process, set the message as a static reference so
            // after this call completes the same thread but in the interrogating
            // client can handle the message to generate the result.
            if (interrogatingPid == Process.myPid()
                    && interrogatingTid == Looper.getMainLooper().getThread().getId()) {
                message.setTarget(ViewRootImpl.this);
                AccessibilityInteractionClient.getInstance().setSameThreadMessage(message);
            } else {
                sendMessage(message);
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.686 -0500", hash_original_method = "51BC2DACC971DA52CB7F7912294499A7", hash_generated_method = "67441495CD432B57EC1A299255D4C92F")
        
public void findAccessibilityNodeInfosByViewTextUiThread(Message message) {
            SomeArgs args = (SomeArgs) message.obj;
            final String text = (String) args.arg1;
            final int accessibilityViewId = args.argi1;
            final int interactionId = args.argi2;
            final IAccessibilityInteractionConnectionCallback callback =
                (IAccessibilityInteractionConnectionCallback) args.arg2;
            mPool.release(args);

            List<AccessibilityNodeInfo> infos = null;
            try {
                ArrayList<View> foundViews = mAttachInfo.mFocusablesTempList;
                foundViews.clear();

                View root = null;
                if (accessibilityViewId != View.NO_ID) {
                    root = findViewByAccessibilityId(accessibilityViewId);
                } else {
                    root = ViewRootImpl.this.mView;
                }

                if (root == null || root.getVisibility() != View.VISIBLE) {
                    return;
                }

                root.findViewsWithText(foundViews, text, View.FIND_VIEWS_WITH_TEXT
                        | View.FIND_VIEWS_WITH_CONTENT_DESCRIPTION);
                if (foundViews.isEmpty()) {
                    return;
                }

                infos = mTempAccessibilityNodeInfoList;
                infos.clear();

                final int viewCount = foundViews.size();
                for (int i = 0; i < viewCount; i++) {
                    View foundView = foundViews.get(i);
                    if (foundView.getVisibility() == View.VISIBLE) {
                        infos.add(foundView.createAccessibilityNodeInfo());
                    }
                 }
            } finally {
                try {
                    callback.setFindAccessibilityNodeInfosResult(infos, interactionId);
                } catch (RemoteException re) {
                    /* ignore - the other side will time out */
                }
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.689 -0500", hash_original_method = "10A09FD4DC34F1BE42EB309D47EC9715", hash_generated_method = "52C258258D1C135B1BA3A1AC9CEC1D02")
        
public void performAccessibilityActionClientThread(int accessibilityId, int action,
                int interactionId, IAccessibilityInteractionConnectionCallback callback,
                int interogatingPid, long interrogatingTid) {
            Message message = Message.obtain();
            message.what = DO_PERFORM_ACCESSIBILITY_ACTION;
            SomeArgs args = mPool.acquire();
            args.argi1 = accessibilityId;
            args.argi2 = action;
            args.argi3 = interactionId;
            args.arg1 = callback;
            message.obj = args;
            // If the interrogation is performed by the same thread as the main UI
            // thread in this process, set the message as a static reference so
            // after this call completes the same thread but in the interrogating
            // client can handle the message to generate the result.
            if (interogatingPid == Process.myPid()
                    && interrogatingTid == Looper.getMainLooper().getThread().getId()) {
                message.setTarget(ViewRootImpl.this);
                AccessibilityInteractionClient.getInstance().setSameThreadMessage(message);
            } else {
                sendMessage(message);
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.692 -0500", hash_original_method = "B5557005BEFFE1DA9F706439FD376D18", hash_generated_method = "05F7AC0826CD87BEE11ACB2A78B1C7F2")
        
public void perfromAccessibilityActionUiThread(Message message) {
            SomeArgs args = (SomeArgs) message.obj;
            final int accessibilityId = args.argi1;
            final int action = args.argi2;
            final int interactionId = args.argi3;
            final IAccessibilityInteractionConnectionCallback callback =
                (IAccessibilityInteractionConnectionCallback) args.arg1;
            mPool.release(args);

            boolean succeeded = false;
            try {
                switch (action) {
                    case AccessibilityNodeInfo.ACTION_FOCUS: {
                        succeeded = performActionFocus(accessibilityId);
                    } break;
                    case AccessibilityNodeInfo.ACTION_CLEAR_FOCUS: {
                        succeeded = performActionClearFocus(accessibilityId);
                    } break;
                    case AccessibilityNodeInfo.ACTION_SELECT: {
                        succeeded = performActionSelect(accessibilityId);
                    } break;
                    case AccessibilityNodeInfo.ACTION_CLEAR_SELECTION: {
                        succeeded = performActionClearSelection(accessibilityId);
                    } break;
                }
            } finally {
                try {
                    callback.setPerformAccessibilityActionResult(succeeded, interactionId);
                } catch (RemoteException re) {
                    /* ignore - the other side will time out */
                }
            }
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.694 -0500", hash_original_method = "0DF709A77C91001270CD6D5BCBC66D0E", hash_generated_method = "462756238992C98537390F5031EA6981")
        
private boolean performActionFocus(int accessibilityId) {
            View target = findViewByAccessibilityId(accessibilityId);
            if (target == null || target.getVisibility() != View.VISIBLE) {
                return false;
            }
            // Get out of touch mode since accessibility wants to move focus around.
            ensureTouchMode(false);
            return target.requestFocus();
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.697 -0500", hash_original_method = "7E9614B48F5F4EC29BCF64D3A075976C", hash_generated_method = "53B94B2271AB10756AB09C8AFF9D2383")
        
private boolean performActionClearFocus(int accessibilityId) {
            View target = findViewByAccessibilityId(accessibilityId);
            if (target == null || target.getVisibility() != View.VISIBLE) {
                return false;
            }
            if (!target.isFocused()) {
                return false;
            }
            target.clearFocus();
            return !target.isFocused();
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.699 -0500", hash_original_method = "AB7AA9516F9E78D5A5AD4BBEB80A41A0", hash_generated_method = "11C9F62B2AFC7EC92CFF3008A9051D8B")
        
private boolean performActionSelect(int accessibilityId) {
            View target = findViewByAccessibilityId(accessibilityId);
            if (target == null || target.getVisibility() != View.VISIBLE) {
                return false;
            }
            if (target.isSelected()) {
                return false;
            }
            target.setSelected(true);
            return target.isSelected();
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.703 -0500", hash_original_method = "E102B39F5DF94C3320BE2ED1E2D3B323", hash_generated_method = "21DAC75A42B4DCA04EED08419CC8DC3E")
        
private boolean performActionClearSelection(int accessibilityId) {
            View target = findViewByAccessibilityId(accessibilityId);
            if (target == null || target.getVisibility() != View.VISIBLE) {
                return false;
            }
            if (!target.isSelected()) {
                return false;
            }
            target.setSelected(false);
            return !target.isSelected();
        }
        
        public class SomeArgs implements Poolable<SomeArgs> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.638 -0500", hash_original_field = "10DB3D8812253573640BF0D1F91398D4", hash_generated_field = "DA4F0B9DBC6F4431600CE5D0AA462E29")

            private SomeArgs mNext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.640 -0500", hash_original_field = "016073DCFA93DD0305C42C8759ED2078", hash_generated_field = "BD952C5DD2D86B34B4D5F4AFE196E837")

            private boolean mIsPooled;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.644 -0500", hash_original_field = "524E284308787C3B27AB4CD560A816CF", hash_generated_field = "F8BED0DABC2D7EE357C5667A5634389E")

            public Object arg1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.646 -0500", hash_original_field = "2CC0C93F38D97721E695C73C9F8BA144", hash_generated_field = "1AFBA2F52DF215183028C3B28AF50E99")

            public Object arg2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.648 -0500", hash_original_field = "7F0B67CAA7215F665771089342F3DFC5", hash_generated_field = "FE0C48289B39F618BBE80AECCEF49180")

            public int argi1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.651 -0500", hash_original_field = "F1422FA73E9868B70AA2963A9422273F", hash_generated_field = "719DADFF01419F95FA55604041F222BD")

            public int argi2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.653 -0500", hash_original_field = "187B483800D059E986583827D0AD5CD5", hash_generated_field = "52D274C1AF69DED7FCB42CCCFE797C8A")

            public int argi3;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.786 -0400", hash_original_method = "C08D0E88500332C6E0DD16EFE525CF46", hash_generated_method = "C08D0E88500332C6E0DD16EFE525CF46")
            public SomeArgs ()
            {
                //Synthesized constructor
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.656 -0500", hash_original_method = "BEE0522D727ED0DB1FBC81A3E3B176C5", hash_generated_method = "1CE217A9F0F766D95C8B8926B2915168")
            
public SomeArgs getNextPoolable() {
                return mNext;
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.658 -0500", hash_original_method = "4CB4F04617162A1F2BEBBAC63163A5FB", hash_generated_method = "B6A97050680DD62F0E280740D1E9FA7B")
            
public boolean isPooled() {
                return mIsPooled;
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.661 -0500", hash_original_method = "B595989EA0DDF2662B95D2584CF9AF77", hash_generated_method = "77E1C829AE4B35561FC71D805A40A8AC")
            
public void setNextPoolable(SomeArgs args) {
                mNext = args;
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.663 -0500", hash_original_method = "CCE0492C3FBB65D8A1644633FE9AA3DF", hash_generated_method = "B03D6BD405969AD6559FEB8A8380BDD8")
            
public void setPooled(boolean isPooled) {
                mIsPooled = isPooled;
            }

            @DSComment("Private Method")
            @DSBan(DSCat.PRIVATE_METHOD)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.666 -0500", hash_original_method = "95D0476EAE9CBD3221945617281C6DDB", hash_generated_method = "8DDF8C8281A3551056B1780CB53659FF")
            
private void clear() {
                arg1 = null;
                arg2 = null;
                argi1 = 0;
                argi2 = 0;
                argi3 = 0;
            }
            
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.705 -0500", hash_original_method = "B9D971669B3F873AC0D1B0C38F7811F4", hash_generated_method = "3D104623F0B27F58121F649A0E7358DB")
        
private View findViewByAccessibilityId(int accessibilityId) {
            View root = ViewRootImpl.this.mView;
            if (root == null) {
                return null;
            }
            View foundView = root.findViewByAccessibilityId(accessibilityId);
            if (foundView != null && foundView.getVisibility() != View.VISIBLE) {
                return null;
            }
            return foundView;
        }
    }
    
    private class SendWindowContentChangedAccessibilityEvent implements Runnable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.714 -0500", hash_original_field = "FED94FB1EAA0AA5EA7631CA7B3A3B650", hash_generated_field = "8E5087238AE27D181E6487D7D8E8CADB")

        public volatile boolean mIsPending;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.786 -0400", hash_original_method = "22B280316CE346FC3EE6EA7A3C31108C", hash_generated_method = "22B280316CE346FC3EE6EA7A3C31108C")
        public SendWindowContentChangedAccessibilityEvent ()
        {
            //Synthesized constructor
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.716 -0500", hash_original_method = "3411919DDECDF923DB080425515AE494", hash_generated_method = "284E8A2C924C6821DE0394CBF655FA00")
        
public void run() {
            if (mView != null) {
                mView.sendAccessibilityEvent(AccessibilityEvent.TYPE_WINDOW_CONTENT_CHANGED);
                mIsPending = false;
            }
        }
        
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.238 -0500", hash_original_method = "DD7540FF4FE8EF5C7F3D3C1B535F6D84", hash_generated_method = "DD7540FF4FE8EF5C7F3D3C1B535F6D84")
    
int enqueuePendingEvent(Object event, boolean sendDone) {
        int seq = mPendingEventSeq+1;
        if (seq < 0) seq = 0;
        mPendingEventSeq = seq;
        mPendingEvents.put(seq, event);
        return sendDone ? seq : -seq;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.241 -0500", hash_original_method = "D1881A2DE4A478B1C2476E8789D90C4F", hash_generated_method = "D1881A2DE4A478B1C2476E8789D90C4F")
    
Object retrievePendingEvent(int seq) {
        if (seq < 0) seq = -seq;
        Object event = mPendingEvents.get(seq);
        if (event != null) {
            mPendingEvents.remove(seq);
        }
        return event;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.244 -0500", hash_original_method = "7BC82D96B9DB6F7A084DA2256A5743DA", hash_generated_method = "70D22BCAFFD80E5018219194AE4FA7D5")
    
private void deliverKeyEvent(KeyEvent event, boolean sendDone) {
        if (ViewDebug.DEBUG_LATENCY) {
            mInputEventDeliverTimeNanos = System.nanoTime();
        }

        if (mInputEventConsistencyVerifier != null) {
            mInputEventConsistencyVerifier.onKeyEvent(event, 0);
        }

        // If there is no view, then the event will not be handled.
        if (mView == null || !mAdded) {
            finishKeyEvent(event, sendDone, false);
            return;
        }

        if (LOCAL_LOGV) Log.v(TAG, "Dispatching key " + event + " to " + mView);

        // Perform predispatching before the IME.
        if (mView.dispatchKeyEventPreIme(event)) {
            finishKeyEvent(event, sendDone, true);
            return;
        }

        // Dispatch to the IME before propagating down the view hierarchy.
        // The IME will eventually call back into handleFinishedEvent.
        if (mLastWasImTarget) {
            InputMethodManager imm = InputMethodManager.peekInstance();
            if (imm != null) {
                int seq = enqueuePendingEvent(event, sendDone);
                if (DEBUG_IMF) Log.v(TAG, "Sending key event to IME: seq="
                        + seq + " event=" + event);
                imm.dispatchKeyEvent(mView.getContext(), seq, event, mInputMethodCallback);
                return;
            }
        }

        // Not dispatching to IME, continue with post IME actions.
        deliverKeyEventPostIme(event, sendDone);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.247 -0500", hash_original_method = "1D388C4C66D020B7A8C536C50B24E128", hash_generated_method = "C63842EE0A4F92FED0FBCC7E4A4A7DE9")
    
private void handleFinishedEvent(int seq, boolean handled) {
        final KeyEvent event = (KeyEvent)retrievePendingEvent(seq);
        if (DEBUG_IMF) Log.v(TAG, "IME finished event: seq=" + seq
                + " handled=" + handled + " event=" + event);
        if (event != null) {
            final boolean sendDone = seq >= 0;
            if (handled) {
                finishKeyEvent(event, sendDone, true);
            } else {
                deliverKeyEventPostIme(event, sendDone);
            }
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.250 -0500", hash_original_method = "3773604D66AC7B7214885F4E3DA58090", hash_generated_method = "AA1C9E985DE69DC27C6134569434E7D2")
    
private void deliverKeyEventPostIme(KeyEvent event, boolean sendDone) {
        if (ViewDebug.DEBUG_LATENCY) {
            mInputEventDeliverPostImeTimeNanos = System.nanoTime();
        }

        // If the view went away, then the event will not be handled.
        if (mView == null || !mAdded) {
            finishKeyEvent(event, sendDone, false);
            return;
        }

        // If the key's purpose is to exit touch mode then we consume it and consider it handled.
        if (checkForLeavingTouchModeAndConsume(event)) {
            finishKeyEvent(event, sendDone, true);
            return;
        }

        // Make sure the fallback event policy sees all keys that will be delivered to the
        // view hierarchy.
        mFallbackEventHandler.preDispatchKeyEvent(event);

        // Deliver the key to the view hierarchy.
        if (mView.dispatchKeyEvent(event)) {
            finishKeyEvent(event, sendDone, true);
            return;
        }

        // If the Control modifier is held, try to interpret the key as a shortcut.
        if (event.getAction() == KeyEvent.ACTION_DOWN
                && event.isCtrlPressed()
                && event.getRepeatCount() == 0
                && !KeyEvent.isModifierKey(event.getKeyCode())) {
            if (mView.dispatchKeyShortcutEvent(event)) {
                finishKeyEvent(event, sendDone, true);
                return;
            }
        }

        // Apply the fallback event policy.
        if (mFallbackEventHandler.dispatchKeyEvent(event)) {
            finishKeyEvent(event, sendDone, true);
            return;
        }

        // Handle automatic focus changes.
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            int direction = 0;
            switch (event.getKeyCode()) {
            case KeyEvent.KEYCODE_DPAD_LEFT:
                if (event.hasNoModifiers()) {
                    direction = View.FOCUS_LEFT;
                }
                break;
            case KeyEvent.KEYCODE_DPAD_RIGHT:
                if (event.hasNoModifiers()) {
                    direction = View.FOCUS_RIGHT;
                }
                break;
            case KeyEvent.KEYCODE_DPAD_UP:
                if (event.hasNoModifiers()) {
                    direction = View.FOCUS_UP;
                }
                break;
            case KeyEvent.KEYCODE_DPAD_DOWN:
                if (event.hasNoModifiers()) {
                    direction = View.FOCUS_DOWN;
                }
                break;
            case KeyEvent.KEYCODE_TAB:
                if (event.hasNoModifiers()) {
                    direction = View.FOCUS_FORWARD;
                } else if (event.hasModifiers(KeyEvent.META_SHIFT_ON)) {
                    direction = View.FOCUS_BACKWARD;
                }
                break;
            }

            if (direction != 0) {
                View focused = mView != null ? mView.findFocus() : null;
                if (focused != null) {
                    View v = focused.focusSearch(direction);
                    if (v != null && v != focused) {
                        // do the math the get the interesting rect
                        // of previous focused into the coord system of
                        // newly focused view
                        focused.getFocusedRect(mTempRect);
                        if (mView instanceof ViewGroup) {
                            ((ViewGroup) mView).offsetDescendantRectToMyCoords(
                                    focused, mTempRect);
                            ((ViewGroup) mView).offsetRectIntoDescendantCoords(
                                    v, mTempRect);
                        }
                        if (v.requestFocus(direction, mTempRect)) {
                            playSoundEffect(
                                    SoundEffectConstants.getContantForFocusDirection(direction));
                            finishKeyEvent(event, sendDone, true);
                            return;
                        }
                    }

                    // Give the focused view a last chance to handle the dpad key.
                    if (mView.dispatchUnhandledMove(focused, direction)) {
                        finishKeyEvent(event, sendDone, true);
                        return;
                    }
                }
            }
        }

        // Key was unhandled.
        finishKeyEvent(event, sendDone, false);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.253 -0500", hash_original_method = "2621255CFED260FE88FD0E0DE76ACADD", hash_generated_method = "0FBF3E7EB489C8FBA0AE76DECEACEA49")
    
private void finishKeyEvent(KeyEvent event, boolean sendDone, boolean handled) {
        if (sendDone) {
            finishInputEvent(event, handled);
        }
    }

    /* drag/drop */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.255 -0500", hash_original_method = "0FF9C383AA2E451EDBB7C2A5CA6E3F80", hash_generated_method = "0FF9C383AA2E451EDBB7C2A5CA6E3F80")
    
void setLocalDragState(Object obj) {
        mLocalDragState = obj;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.259 -0500", hash_original_method = "977584242F0720CC5E20503FC56D761D", hash_generated_method = "6A3E4DD6C55C641CF2F3BF5DC215D4F5")
    
private void handleDragEvent(DragEvent event) {
        // From the root, only drag start/end/location are dispatched.  entered/exited
        // are determined and dispatched by the viewgroup hierarchy, who then report
        // that back here for ultimate reporting back to the framework.
        if (mView != null && mAdded) {
            final int what = event.mAction;

            if (what == DragEvent.ACTION_DRAG_EXITED) {
                // A direct EXITED event means that the window manager knows we've just crossed
                // a window boundary, so the current drag target within this one must have
                // just been exited.  Send it the usual notifications and then we're done
                // for now.
                mView.dispatchDragEvent(event);
            } else {
                // Cache the drag description when the operation starts, then fill it in
                // on subsequent calls as a convenience
                if (what == DragEvent.ACTION_DRAG_STARTED) {
                    mCurrentDragView = null;    // Start the current-recipient tracking
                    mDragDescription = event.mClipDescription;
                } else {
                    event.mClipDescription = mDragDescription;
                }

                // For events with a [screen] location, translate into window coordinates
                if ((what == DragEvent.ACTION_DRAG_LOCATION) || (what == DragEvent.ACTION_DROP)) {
                    mDragPoint.set(event.mX, event.mY);
                    if (mTranslator != null) {
                        mTranslator.translatePointInScreenToAppWindow(mDragPoint);
                    }

                    if (mCurScrollY != 0) {
                        mDragPoint.offset(0, mCurScrollY);
                    }

                    event.mX = mDragPoint.x;
                    event.mY = mDragPoint.y;
                }

                // Remember who the current drag target is pre-dispatch
                final View prevDragView = mCurrentDragView;

                // Now dispatch the drag/drop event
                boolean result = mView.dispatchDragEvent(event);

                // If we changed apparent drag target, tell the OS about it
                if (prevDragView != mCurrentDragView) {
                    try {
                        if (prevDragView != null) {
                            sWindowSession.dragRecipientExited(mWindow);
                        }
                        if (mCurrentDragView != null) {
                            sWindowSession.dragRecipientEntered(mWindow);
                        }
                    } catch (RemoteException e) {
                        Slog.e(TAG, "Unable to note drag target change");
                    }
                }

                // Report the drop result when we're done
                if (what == DragEvent.ACTION_DROP) {
                    mDragDescription = null;
                    try {
                        Log.i(TAG, "Reporting drop result: " + result);
                        sWindowSession.reportDropResult(mWindow, result);
                    } catch (RemoteException e) {
                        Log.e(TAG, "Unable to report drop result");
                    }
                }

                // When the drag operation ends, release any local state object
                // that may have been in use
                if (what == DragEvent.ACTION_DRAG_ENDED) {
                    setLocalDragState(null);
                }
            }
        }
        event.recycle();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.263 -0500", hash_original_method = "504EE99E4FC1047B3EE4816C6C3CF55E", hash_generated_method = "1FCF5211CFE1A91D70FB921352CAD8C8")
    
public void handleDispatchSystemUiVisibilityChanged(SystemUiVisibilityInfo args) {
        if (mSeq != args.seq) {
            // The sequence has changed, so we need to update our value and make
            // sure to do a traversal afterward so the window manager is given our
            // most recent data.
            mSeq = args.seq;
            mAttachInfo.mForceReportNewAttributes = true;
            scheduleTraversals();            
        }
        if (mView == null) return;
        if (args.localChanges != 0) {
            if (mAttachInfo != null) {
                mAttachInfo.mSystemUiVisibility =
                        (mAttachInfo.mSystemUiVisibility&~args.localChanges)
                        | (args.localValue&args.localChanges);
            }
            mView.updateLocalSystemUiVisibility(args.localValue, args.localChanges);
            mAttachInfo.mRecomputeGlobalAttributes = true;
            scheduleTraversals();            
        }
        mView.dispatchSystemUiVisibilityChanged(args.globalVisibility);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.265 -0500", hash_original_method = "45F97324DFA9B47BC7B47DB7731173BB", hash_generated_method = "20EA98E53FDAAD9C079C04E8EE650416")
    
public void getLastTouchPoint(Point outLocation) {
        outLocation.x = (int) mLastTouchPoint.x;
        outLocation.y = (int) mLastTouchPoint.y;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.267 -0500", hash_original_method = "D8987F1AD41DCFCEC13505B3421C8BB0", hash_generated_method = "3C9624C7AE6E7E69FE0FB968A98F7832")
    
public void setDragFocus(View newDragTarget) {
        if (mCurrentDragView != newDragTarget) {
            mCurrentDragView = newDragTarget;
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.270 -0500", hash_original_method = "63BA605FA957D5097ED6886D9988BC53", hash_generated_method = "6833C9DFE0A8DA85677C409C8897EBAF")
    
private AudioManager getAudioManager() {
        if (mView == null) {
            throw new IllegalStateException("getAudioManager called when there is no mView");
        }
        if (mAudioManager == null) {
            mAudioManager = (AudioManager) mView.getContext().getSystemService(Context.AUDIO_SERVICE);
        }
        return mAudioManager;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.272 -0500", hash_original_method = "C22EE439EF1C63381F42BE80F34ED0C5", hash_generated_method = "B893A28442E5CDB7E26D9A570432816A")
    
public AccessibilityInteractionController getAccessibilityInteractionController() {
        if (mView == null) {
            throw new IllegalStateException("getAccessibilityInteractionController"
                    + " called when there is no mView");
        }
        if (mAccessibilityInteractionController == null) {
            mAccessibilityInteractionController = new AccessibilityInteractionController();
        }
        return mAccessibilityInteractionController;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.275 -0500", hash_original_method = "0B2FE2E2B393762D66EC0169ABC2799A", hash_generated_method = "92FA9D8CB8B5C1F1CF7E4E0BFC91D1DC")
    
private int relayoutWindow(WindowManager.LayoutParams params, int viewVisibility,
            boolean insetsPending) throws RemoteException {

        float appScale = mAttachInfo.mApplicationScale;
        boolean restore = false;
        if (params != null && mTranslator != null) {
            restore = true;
            params.backup();
            mTranslator.translateWindowLayout(params);
        }
        if (params != null) {
            if (DBG) Log.d(TAG, "WindowLayout in layoutWindow:" + params);
        }
        mPendingConfiguration.seq = 0;
        //Log.d(TAG, ">>>>>> CALLING relayout");
        if (params != null && mOrigWindowType != params.type) {
            // For compatibility with old apps, don't crash here.
            if (mTargetSdkVersion < android.os.Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
                Slog.w(TAG, "Window type can not be changed after "
                        + "the window is added; ignoring change of " + mView);
                params.type = mOrigWindowType;
            }
        }
        int relayoutResult = sWindowSession.relayout(
                mWindow, mSeq, params,
                (int) (mView.getMeasuredWidth() * appScale + 0.5f),
                (int) (mView.getMeasuredHeight() * appScale + 0.5f),
                viewVisibility, insetsPending ? WindowManagerImpl.RELAYOUT_INSETS_PENDING : 0,
                mWinFrame, mPendingContentInsets, mPendingVisibleInsets,
                mPendingConfiguration, mSurface);
        //Log.d(TAG, "<<<<<< BACK FROM relayout");
        if (restore) {
            params.restore();
        }
        
        if (mTranslator != null) {
            mTranslator.translateRectInScreenToAppWinFrame(mWinFrame);
            mTranslator.translateRectInScreenToAppWindow(mPendingContentInsets);
            mTranslator.translateRectInScreenToAppWindow(mPendingVisibleInsets);
        }
        return relayoutResult;
    }

    /**
     * {@inheritDoc}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.278 -0500", hash_original_method = "15B8C68C65C02C1955DF774990289073", hash_generated_method = "61ED4CC498DD0207BEAC34921098AFAB")
    
public void playSoundEffect(int effectId) {
        checkThread();

        try {
            final AudioManager audioManager = getAudioManager();

            switch (effectId) {
                case SoundEffectConstants.CLICK:
                    audioManager.playSoundEffect(AudioManager.FX_KEY_CLICK);
                    return;
                case SoundEffectConstants.NAVIGATION_DOWN:
                    audioManager.playSoundEffect(AudioManager.FX_FOCUS_NAVIGATION_DOWN);
                    return;
                case SoundEffectConstants.NAVIGATION_LEFT:
                    audioManager.playSoundEffect(AudioManager.FX_FOCUS_NAVIGATION_LEFT);
                    return;
                case SoundEffectConstants.NAVIGATION_RIGHT:
                    audioManager.playSoundEffect(AudioManager.FX_FOCUS_NAVIGATION_RIGHT);
                    return;
                case SoundEffectConstants.NAVIGATION_UP:
                    audioManager.playSoundEffect(AudioManager.FX_FOCUS_NAVIGATION_UP);
                    return;
                default:
                    throw new IllegalArgumentException("unknown effect id " + effectId +
                            " not defined in " + SoundEffectConstants.class.getCanonicalName());
            }
        } catch (IllegalStateException e) {
            // Exception thrown by getAudioManager() when mView is null
            Log.e(TAG, "FATAL EXCEPTION when attempting to play sound effect: " + e);
            e.printStackTrace();
        }
    }

    /**
     * {@inheritDoc}
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.280 -0500", hash_original_method = "B8D922B767BD06C4283BB3EF0BFA3172", hash_generated_method = "FAF2F69C5B351D77F913414E28CD64E0")
    
public boolean performHapticFeedback(int effectId, boolean always) {
        try {
            return sWindowSession.performHapticFeedback(mWindow, effectId, always);
        } catch (RemoteException e) {
            return false;
        }
    }

    /**
     * {@inheritDoc}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.282 -0500", hash_original_method = "220A5158C443CFE1D4535C372C690545", hash_generated_method = "62F3656E20817A1C2003712CCCBABC9E")
    
public View focusSearch(View focused, int direction) {
        checkThread();
        if (!(mView instanceof ViewGroup)) {
            return null;
        }
        return FocusFinder.getInstance().findNextFocus((ViewGroup) mView, focused, direction);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.284 -0500", hash_original_method = "5C67D040EE10672AA68B296434D2F63D", hash_generated_method = "3333267839AA2CA31D35D5E240B41D5D")
    
public void debug() {
        mView.debug();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.287 -0500", hash_original_method = "818AD1A70B8E095131DC73E371E19514", hash_generated_method = "7819B14061247729253C74BF4E45445B")
    
public void dumpGfxInfo(PrintWriter pw, int[] info) {
        if (mView != null) {
            getGfxInfo(mView, info);
        } else {
            info[0] = info[1] = 0;
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.290 -0500", hash_original_method = "CD86B0B9CE453C77251859969963B0E8", hash_generated_method = "3097004A47D4FAACA7FD43FAA374B300")
    
private void getGfxInfo(View view, int[] info) {
        DisplayList displayList = view.mDisplayList;
        info[0]++;
        if (displayList != null) {
            info[1] += displayList.getSize();
        }

        if (view instanceof ViewGroup) {
            ViewGroup group = (ViewGroup) view;

            int count = group.getChildCount();
            for (int i = 0; i < count; i++) {
                getGfxInfo(group.getChildAt(i), info);
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.293 -0500", hash_original_method = "F971131E8183B74AE14F7AE1993EB770", hash_generated_method = "D8CD2D2B1EA546550DA56797B862637A")
    
public void die(boolean immediate) {
        if (immediate) {
            doDie();
        } else {
            sendEmptyMessage(DIE);
        }
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.295 -0500", hash_original_method = "8D1DF41E880ED97CD9EA450CBF8DEBA9", hash_generated_method = "FF6F886078429C46002F42F3CFD93E57")
    
void doDie() {
        checkThread();
        if (LOCAL_LOGV) Log.v(TAG, "DIE in " + this + " of " + mSurface);
        synchronized (this) {
            if (mAdded) {
                mAdded = false;
                dispatchDetachedFromWindow();
            }

            if (mAdded && !mFirst) {
                destroyHardwareRenderer();

                int viewVisibility = mView.getVisibility();
                boolean viewVisibilityChanged = mViewVisibility != viewVisibility;
                if (mWindowAttributesChanged || viewVisibilityChanged) {
                    // If layout params have been changed, first give them
                    // to the window manager to make sure it has the correct
                    // animation info.
                    try {
                        if ((relayoutWindow(mWindowAttributes, viewVisibility, false)
                                & WindowManagerImpl.RELAYOUT_RES_FIRST_TIME) != 0) {
                            sWindowSession.finishDrawing(mWindow);
                        }
                    } catch (RemoteException e) {
                    }
                }

                mSurface.release();
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.297 -0500", hash_original_method = "C21E5BD1C0448C03922FA84C1B8F3673", hash_generated_method = "7CF4117F49826E4A083F52DBA45CC879")
    
public void requestUpdateConfiguration(Configuration config) {
        Message msg = obtainMessage(UPDATE_CONFIGURATION, config);
        sendMessage(msg);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.300 -0500", hash_original_method = "83B5F7EEB6D7B3078A7769D15E86950B", hash_generated_method = "A77A4F1E37F9154DE647FCD8A746251F")
    
private void destroyHardwareRenderer() {
        if (mAttachInfo.mHardwareRenderer != null) {
            mAttachInfo.mHardwareRenderer.destroy(true);
            mAttachInfo.mHardwareRenderer = null;
            mAttachInfo.mHardwareAccelerated = false;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.303 -0500", hash_original_method = "459EFA224EE61797FCF735DB24F377FF", hash_generated_method = "C746223EAB4A4652956DE6C35D726CCB")
    
public void dispatchFinishedEvent(int seq, boolean handled) {
        Message msg = obtainMessage(FINISHED_EVENT);
        msg.arg1 = seq;
        msg.arg2 = handled ? 1 : 0;
        sendMessage(msg);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.306 -0500", hash_original_method = "176F47B7EDC9D70A69736114EF5A25ED", hash_generated_method = "8088696DC93FC757412BCF7B3FD9B19F")
    
public void dispatchResized(int w, int h, Rect coveredInsets,
            Rect visibleInsets, boolean reportDraw, Configuration newConfig) {
        if (DEBUG_LAYOUT) Log.v(TAG, "Resizing " + this + ": w=" + w
                + " h=" + h + " coveredInsets=" + coveredInsets.toShortString()
                + " visibleInsets=" + visibleInsets.toShortString()
                + " reportDraw=" + reportDraw);
        Message msg = obtainMessage(reportDraw ? RESIZED_REPORT :RESIZED);
        if (mTranslator != null) {
            mTranslator.translateRectInScreenToAppWindow(coveredInsets);
            mTranslator.translateRectInScreenToAppWindow(visibleInsets);
            w *= mTranslator.applicationInvertedScale;
            h *= mTranslator.applicationInvertedScale;
        }
        msg.arg1 = w;
        msg.arg2 = h;
        ResizedInfo ri = new ResizedInfo();
        ri.coveredInsets = new Rect(coveredInsets);
        ri.visibleInsets = new Rect(visibleInsets);
        ri.newConfig = newConfig;
        msg.obj = ri;
        sendMessage(msg);
    }

    /**
     * Place the input event message at the end of the current pending list
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.352 -0500", hash_original_method = "42F15B8B44D9B8805537AB8032035046", hash_generated_method = "406165FEC400D5ECDB795C083EF7D87D")
    
private void enqueueInputEvent(Message msg, long when) {
        InputEventMessage inputMessage = InputEventMessage.obtain(msg);
        if (mPendingInputEvents == null) {
            mPendingInputEvents = inputMessage;
        } else {
            InputEventMessage currMessage = mPendingInputEvents;
            while (currMessage.mNext != null) {
                currMessage = currMessage.mNext;
            }
            currMessage.mNext = inputMessage;
        }
        sendEmptyMessageAtTime(PROCESS_INPUT_EVENTS, when);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.354 -0500", hash_original_method = "CF232D7D6B258A687467B35A15A72FA0", hash_generated_method = "17E528EBE442E0C66CA27EAFABF2F122")
    
public void dispatchKey(KeyEvent event) {
        dispatchKey(event, false);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.356 -0500", hash_original_method = "40FF3F3DF013E72EC5E96E0A49136BE3", hash_generated_method = "4006AE160FB33305A8A86E26059575B4")
    
private void dispatchKey(KeyEvent event, boolean sendDone) {
        //noinspection ConstantConditions
        if (false && event.getAction() == KeyEvent.ACTION_DOWN) {
            if (event.getKeyCode() == KeyEvent.KEYCODE_CAMERA) {
                if (DBG) Log.d("keydisp", "===================================================");
                if (DBG) Log.d("keydisp", "Focused view Hierarchy is:");

                debug();

                if (DBG) Log.d("keydisp", "===================================================");
            }
        }

        Message msg = obtainMessage(DISPATCH_KEY);
        msg.obj = event;
        msg.arg1 = sendDone ? 1 : 0;

        if (LOCAL_LOGV) Log.v(
            TAG, "sending key " + event + " to " + mView);

        enqueueInputEvent(msg, event.getEventTime());
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.359 -0500", hash_original_method = "F90A161CC4BD8998AC3B193B63EB7E53", hash_generated_method = "465C8FD080A647498A0319A403D66EC5")
    
private void dispatchMotion(MotionEvent event, boolean sendDone) {
        int source = event.getSource();
        if ((source & InputDevice.SOURCE_CLASS_POINTER) != 0) {
            dispatchPointer(event, sendDone);
        } else if ((source & InputDevice.SOURCE_CLASS_TRACKBALL) != 0) {
            dispatchTrackball(event, sendDone);
        } else {
            dispatchGenericMotion(event, sendDone);
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.361 -0500", hash_original_method = "DD56557FEAC8CACD87B056C5C0C702D1", hash_generated_method = "419945085985C0279C8394B5F816B97F")
    
private void dispatchPointer(MotionEvent event, boolean sendDone) {
        Message msg = obtainMessage(DISPATCH_POINTER);
        msg.obj = event;
        msg.arg1 = sendDone ? 1 : 0;
        enqueueInputEvent(msg, event.getEventTime());
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.364 -0500", hash_original_method = "CA2BFA17163311E1AAAA771C667E27EE", hash_generated_method = "B6A6D0270A5FD6F28ABF98128ECB118D")
    
private void dispatchTrackball(MotionEvent event, boolean sendDone) {
        Message msg = obtainMessage(DISPATCH_TRACKBALL);
        msg.obj = event;
        msg.arg1 = sendDone ? 1 : 0;
        enqueueInputEvent(msg, event.getEventTime());
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.366 -0500", hash_original_method = "BF71C2E204EC82729A1EA0969E06871A", hash_generated_method = "2526D476327C2E78CBF0E22595AE35B1")
    
private void dispatchGenericMotion(MotionEvent event, boolean sendDone) {
        Message msg = obtainMessage(DISPATCH_GENERIC_MOTION);
        msg.obj = event;
        msg.arg1 = sendDone ? 1 : 0;
        enqueueInputEvent(msg, event.getEventTime());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.369 -0500", hash_original_method = "609DE6F7AC6918A6ED5E47157E290835", hash_generated_method = "B070D90CD630B60CE476CF6FFD755DAD")
    
public void dispatchAppVisibility(boolean visible) {
        Message msg = obtainMessage(DISPATCH_APP_VISIBILITY);
        msg.arg1 = visible ? 1 : 0;
        sendMessage(msg);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.371 -0500", hash_original_method = "4D3A3DC5DC743660725FA6A11A372A07", hash_generated_method = "49988C34C07E8516F9A43EB0F71BC4AB")
    
public void dispatchGetNewSurface() {
        Message msg = obtainMessage(DISPATCH_GET_NEW_SURFACE);
        sendMessage(msg);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.373 -0500", hash_original_method = "0CD487AEEAC72879653D2DB3DCCCEB86", hash_generated_method = "12F2177DF2A78EC14D15003FF2A140DC")
    
public void windowFocusChanged(boolean hasFocus, boolean inTouchMode) {
        Message msg = Message.obtain();
        msg.what = WINDOW_FOCUS_CHANGED;
        msg.arg1 = hasFocus ? 1 : 0;
        msg.arg2 = inTouchMode ? 1 : 0;
        sendMessage(msg);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.376 -0500", hash_original_method = "DCE84E54CF89AABF2B838105364C2821", hash_generated_method = "50BB90A86CDC20742D20A3B1E77CFC25")
    
public void dispatchCloseSystemDialogs(String reason) {
        Message msg = Message.obtain();
        msg.what = CLOSE_SYSTEM_DIALOGS;
        msg.obj = reason;
        sendMessage(msg);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.378 -0500", hash_original_method = "786F6A89EC1BE66218A42841DB30F7AC", hash_generated_method = "CCBF2CCE558A17FD19769E8F06AA0285")
    
public void dispatchDragEvent(DragEvent event) {
        final int what;
        if (event.getAction() == DragEvent.ACTION_DRAG_LOCATION) {
            what = DISPATCH_DRAG_LOCATION_EVENT;
            removeMessages(what);
        } else {
            what = DISPATCH_DRAG_EVENT;
        }
        Message msg = obtainMessage(what, event);
        sendMessage(msg);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.381 -0500", hash_original_method = "95F6C6AC5462FA09198431CBF084B2BE", hash_generated_method = "2246D9D779F7762E926F1232B5C05C2C")
    
public void dispatchSystemUiVisibilityChanged(int seq, int globalVisibility,
            int localValue, int localChanges) {
        SystemUiVisibilityInfo args = new SystemUiVisibilityInfo();
        args.seq = seq;
        args.globalVisibility = globalVisibility;
        args.localValue = localValue;
        args.localChanges = localChanges;
        sendMessage(obtainMessage(DISPATCH_SYSTEM_UI_VISIBILITY, args));
    }

    /**
     * The window is getting focus so if there is anything focused/selected
     * send an {@link AccessibilityEvent} to announce that.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.383 -0500", hash_original_method = "DE2DA8F2C91C4BAC5E71DE180C591B82", hash_generated_method = "15E4462FED18669ABC30EAD9EB1805BD")
    
private void sendAccessibilityEvents() {
        if (!mAccessibilityManager.isEnabled()) {
            return;
        }
        mView.sendAccessibilityEvent(AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED);
        View focusedView = mView.findFocus();
        if (focusedView != null && focusedView != mView) {
            focusedView.sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_FOCUSED);
        }
    }

    /**
     * Post a callback to send a
     * {@link AccessibilityEvent#TYPE_WINDOW_CONTENT_CHANGED} event.
     * This event is send at most once every
     * {@link ViewConfiguration#getSendRecurringAccessibilityEventsInterval()}.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.386 -0500", hash_original_method = "3EBD42CE7AD44788B8B5975E509C0AD4", hash_generated_method = "52C5566DB6F058B16F297F26291A7ED1")
    
private void postSendWindowContentChangedCallback() {
        if (mSendWindowContentChangedAccessibilityEvent == null) {
            mSendWindowContentChangedAccessibilityEvent =
                new SendWindowContentChangedAccessibilityEvent();
        }
        if (!mSendWindowContentChangedAccessibilityEvent.mIsPending) {
            mSendWindowContentChangedAccessibilityEvent.mIsPending = true;
            postDelayed(mSendWindowContentChangedAccessibilityEvent,
                    ViewConfiguration.getSendRecurringAccessibilityEventsInterval());
        }
    }

    /**
     * Remove a posted callback to send a
     * {@link AccessibilityEvent#TYPE_WINDOW_CONTENT_CHANGED} event.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.388 -0500", hash_original_method = "B38BF7B18A0D0C0D14C2E79D97568CE9", hash_generated_method = "28DF4CA9BBEB22347BED538E9FC5650C")
    
private void removeSendWindowContentChangedCallback() {
        if (mSendWindowContentChangedAccessibilityEvent != null) {
            removeCallbacks(mSendWindowContentChangedAccessibilityEvent);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.390 -0500", hash_original_method = "3A017950A97502A630256434B0EBF7E8", hash_generated_method = "A086298682AD3353212793B607FA3FB5")
    
public boolean showContextMenuForChild(View originalView) {
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.393 -0500", hash_original_method = "492AE6A9C9C6F2F7E659E19901E3E487", hash_generated_method = "5F0E377BCE8180A4CF8500A97CF28149")
    
public ActionMode startActionModeForChild(View originalView, ActionMode.Callback callback) {
        return null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.395 -0500", hash_original_method = "FB735C9133B887C07751FC797F168B65", hash_generated_method = "505CC9C33B189450A992357BCF04F40D")
    
public void createContextMenu(ContextMenu menu) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.397 -0500", hash_original_method = "C40FC95C25B6655ACCA9227D471DC892", hash_generated_method = "44E531FA3B2D2EE962CA45BC993C6984")
    
public void childDrawableStateChanged(View child) {
    }

    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.400 -0500", hash_original_method = "975E17A58706A43B9CF06D84428C706E", hash_generated_method = "345829A822BD9A49FC53CC2C92D894F7")
    
public boolean requestSendAccessibilityEvent(View child, AccessibilityEvent event) {
        if (mView == null) {
            return false;
        }
        mAccessibilityManager.sendAccessibilityEvent(event);
        return true;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.402 -0500", hash_original_method = "C963D9A99CD7BE986B275021EA99CB95", hash_generated_method = "C963D9A99CD7BE986B275021EA99CB95")
    
void checkThread() {
        if (mThread != Thread.currentThread()) {
            throw new CalledFromWrongThreadException(
                    "Only the original thread that created a view hierarchy can touch its views.");
        }
    }

    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.405 -0500", hash_original_method = "F9834E22E1AF22274F19B27CD50E21E5", hash_generated_method = "F75D2CCB2F8E265CC0225DD86A137DA0")
    
public void requestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        // ViewAncestor never intercepts touch event, so this can be a no-op
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:32.407 -0500", hash_original_method = "176476ED7A31EA7594378C530DAA6036", hash_generated_method = "5F83B51833ECD539B00EA5319103EC3F")
    
public boolean requestChildRectangleOnScreen(View child, Rect rectangle,
            boolean immediate) {
        return scrollToRectOrFocus(rectangle, immediate);
    }

    @Override
    @DSSafe(DSCat.SAFE_OTHERS)
    public void childHasTransientStateChanged(View view,
            boolean hasTransientState) {
        // TODO Auto-generated method stub
        
    }

    public void dispatchInvalidateRectOnAnimation(InvalidateInfo info) {
        // TODO Auto-generated method stub
        
    }

    public void dispatchInvalidateOnAnimation(View view) {
        // TODO Auto-generated method stub
        
    }
}

