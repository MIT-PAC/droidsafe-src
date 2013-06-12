package android.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.app.ActivityManager;
import android.content.ComponentCallbacks2;
import android.content.res.CompatibilityInfo;
import android.content.res.Configuration;
import android.graphics.PixelFormat;
import android.opengl.ManagedEGLContext;
import android.os.IBinder;
import android.util.AndroidRuntimeException;
import android.util.Log;
import android.view.inputmethod.InputMethodManager;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.HashMap;

final class WindowLeaked extends AndroidRuntimeException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.891 -0400", hash_original_method = "FBED2002249AD131D5B5A71E6D66FC21", hash_generated_method = "71686E53713AC064A34696B821941667")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public WindowLeaked(String msg) {
        super(msg);
        dsTaint.addTaint(msg);
        // ---------- Original Method ----------
    }

    
}

public class WindowManagerImpl implements WindowManager {
    public static final int RELAYOUT_RES_IN_TOUCH_MODE = 0x1;
    public static final int RELAYOUT_RES_FIRST_TIME = 0x2;
    public static final int RELAYOUT_RES_SURFACE_CHANGED = 0x4;
    public static final int RELAYOUT_INSETS_PENDING = 0x1;
    public static final int RELAYOUT_DEFER_SURFACE_DESTROY = 0x2;
    public static final int ADD_FLAG_APP_VISIBLE = 0x2;
    public static final int ADD_FLAG_IN_TOUCH_MODE = RELAYOUT_RES_IN_TOUCH_MODE;
    public static final int ADD_OKAY = 0;
    public static final int ADD_BAD_APP_TOKEN = -1;
    public static final int ADD_BAD_SUBWINDOW_TOKEN = -2;
    public static final int ADD_NOT_APP_TOKEN = -3;
    public static final int ADD_APP_EXITING = -4;
    public static final int ADD_DUPLICATE_ADD = -5;
    public static final int ADD_STARTING_NOT_NEEDED = -6;
    public static final int ADD_MULTIPLE_SINGLETON = -7;
    public static final int ADD_PERMISSION_DENIED = -8;
    private View[] mViews;
    private ViewRootImpl[] mRoots;
    private WindowManager.LayoutParams[] mParams;
    private final static Object sLock = new Object();
    private final static WindowManagerImpl sWindowManager = new WindowManagerImpl();
    private final static HashMap<CompatibilityInfo, WindowManager> sCompatWindowManagers
            = new HashMap<CompatibilityInfo, WindowManager>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.891 -0400", hash_original_method = "6056338BA32AC2029F584B08E7B10209", hash_generated_method = "5C0A30247B54DE424037614F0028A70B")
    public static WindowManagerImpl getDefault() {
        return sWindowManager;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.891 -0400", hash_original_method = "70D6D45704A8FE98C4094D46BFDD6193", hash_generated_method = "8FE45C0C971845252EA7B22E9A40CE8B")
    public static WindowManager getDefault(CompatibilityInfo compatInfo) {
        CompatibilityInfoHolder cih = new CompatibilityInfoHolder();
        cih.set(compatInfo);
        if (cih.getIfNeeded() == null) {
            return sWindowManager;
        }
        synchronized (sLock) {
            WindowManager wm = sCompatWindowManagers.get(compatInfo);
            if (wm == null) {
                wm = new CompatModeWrapper(sWindowManager, cih);
                sCompatWindowManagers.put(compatInfo, wm);
            }
            return wm;
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.891 -0400", hash_original_method = "74A7729D7227AC3DCFFF56714E741835", hash_generated_method = "8A1C0ADF5A068CED18A7AFDCCEF3258C")
    public static WindowManager getDefault(CompatibilityInfoHolder compatInfo) {
        return new CompatModeWrapper(sWindowManager, compatInfo);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.891 -0400", hash_original_method = "8E464E19F5A7F279FF3FC1B84D15C4F0", hash_generated_method = "C9004BC47678C06851981C6431709EC5")
    @DSModeled(DSC.SAFE)
    public boolean isHardwareAccelerated() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.891 -0400", hash_original_method = "3A47767500C080C4B7D3F95A5195D385", hash_generated_method = "44395466D19967D80870AAC1445A004E")
    @DSModeled(DSC.SAFE)
    public void addView(View view) {
        dsTaint.addTaint(view.dsTaint);
        addView(view, new WindowManager.LayoutParams(
            WindowManager.LayoutParams.TYPE_APPLICATION, 0, PixelFormat.OPAQUE));
        // ---------- Original Method ----------
        //addView(view, new WindowManager.LayoutParams(
            //WindowManager.LayoutParams.TYPE_APPLICATION, 0, PixelFormat.OPAQUE));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.891 -0400", hash_original_method = "133D7EA484587CEAA64BDEB4AE9186C6", hash_generated_method = "A0649905459F5E11BA1315746239C993")
    @DSModeled(DSC.SAFE)
    public void addView(View view, ViewGroup.LayoutParams params) {
        dsTaint.addTaint(view.dsTaint);
        dsTaint.addTaint(params.dsTaint);
        addView(view, params, null, false);
        // ---------- Original Method ----------
        //addView(view, params, null, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.891 -0400", hash_original_method = "6E55E902889BC8630B8C2A4EBA8587B9", hash_generated_method = "00FC0437268788FF24D7C5F263067AF7")
    @DSModeled(DSC.SAFE)
    public void addView(View view, ViewGroup.LayoutParams params, CompatibilityInfoHolder cih) {
        dsTaint.addTaint(cih.dsTaint);
        dsTaint.addTaint(view.dsTaint);
        dsTaint.addTaint(params.dsTaint);
        addView(view, params, cih, false);
        // ---------- Original Method ----------
        //addView(view, params, cih, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.892 -0400", hash_original_method = "FC07162832A382775417964F34DC350F", hash_generated_method = "A6B373DD05B2E164E8C6EFF344E75475")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void addView(View view, ViewGroup.LayoutParams params,
            CompatibilityInfoHolder cih, boolean nest) {
        dsTaint.addTaint(cih.dsTaint);
        dsTaint.addTaint(nest);
        dsTaint.addTaint(view.dsTaint);
        dsTaint.addTaint(params.dsTaint);
        {
            throw new IllegalArgumentException(
                    "Params must be WindowManager.LayoutParams");
        } //End block
        final WindowManager.LayoutParams wparams;
        wparams = (WindowManager.LayoutParams)params;
        ViewRootImpl root;
        View panelParentView;
        panelParentView = null;
        {
            int index;
            index = findViewLocked(view, false);
            {
                {
                    throw new IllegalStateException("View " + view
                            + " has already been added to the window manager.");
                } //End block
                root = mRoots[index];
                root.mAddNesting++;
                view.setLayoutParams(wparams);
                root.setLayoutParams(wparams, true);
            } //End block
            {
                final int count;
                count = mViews.length;
                count = 0;
                {
                    int i;
                    i = 0;
                    {
                        {
                            boolean var1D105CECC30286641BD50965ABC9FB7E_2023621589 = (mRoots[i].mWindow.asBinder() == wparams.token);
                            {
                                panelParentView = mViews[i];
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
            root = new ViewRootImpl(view.getContext());
            root.mAddNesting = 1;
            {
                root.mCompatibilityInfo = new CompatibilityInfoHolder();
            } //End block
            {
                root.mCompatibilityInfo = cih;
            } //End block
            view.setLayoutParams(wparams);
            {
                index = 1;
                mViews = new View[1];
                mRoots = new ViewRootImpl[1];
                mParams = new WindowManager.LayoutParams[1];
            } //End block
            {
                index = mViews.length + 1;
                Object[] old;
                old = mViews;
                mViews = new View[index];
                System.arraycopy(old, 0, mViews, 0, index-1);
                old = mRoots;
                mRoots = new ViewRootImpl[index];
                System.arraycopy(old, 0, mRoots, 0, index-1);
                old = mParams;
                mParams = new WindowManager.LayoutParams[index];
                System.arraycopy(old, 0, mParams, 0, index-1);
            } //End block
            index--;
            mViews[index] = view;
            mRoots[index] = root;
            mParams[index] = wparams;
        } //End block
        root.setView(view, wparams, panelParentView);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.892 -0400", hash_original_method = "ED95BEACF52CBB6AE255A4987CA1BF10", hash_generated_method = "A9826E83953C8BFF3BAFDFB89655E41D")
    @DSModeled(DSC.SAFE)
    public void updateViewLayout(View view, ViewGroup.LayoutParams params) {
        dsTaint.addTaint(view.dsTaint);
        dsTaint.addTaint(params.dsTaint);
        {
            throw new IllegalArgumentException("Params must be WindowManager.LayoutParams");
        } //End block
        final WindowManager.LayoutParams wparams;
        wparams = (WindowManager.LayoutParams)params;
        view.setLayoutParams(wparams);
        {
            int index;
            index = findViewLocked(view, true);
            ViewRootImpl root;
            root = mRoots[index];
            mParams[index] = wparams;
            root.setLayoutParams(wparams, false);
        } //End block
        // ---------- Original Method ----------
        //if (!(params instanceof WindowManager.LayoutParams)) {
            //throw new IllegalArgumentException("Params must be WindowManager.LayoutParams");
        //}
        //final WindowManager.LayoutParams wparams
                //= (WindowManager.LayoutParams)params;
        //view.setLayoutParams(wparams);
        //synchronized (this) {
            //int index = findViewLocked(view, true);
            //ViewRootImpl root = mRoots[index];
            //mParams[index] = wparams;
            //root.setLayoutParams(wparams, false);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.892 -0400", hash_original_method = "6ED1D335390D20FBE30CC53F4D61DE9F", hash_generated_method = "8176E7D9731723E9DC57EFB102A11DC0")
    @DSModeled(DSC.SAFE)
    public void removeView(View view) {
        dsTaint.addTaint(view.dsTaint);
        {
            int index;
            index = findViewLocked(view, true);
            View curView;
            curView = removeViewLocked(index);
            throw new IllegalStateException("Calling with view " + view
                    + " but the ViewAncestor is attached to " + curView);
        } //End block
        // ---------- Original Method ----------
        //synchronized (this) {
            //int index = findViewLocked(view, true);
            //View curView = removeViewLocked(index);
            //if (curView == view) {
                //return;
            //}
            //throw new IllegalStateException("Calling with view " + view
                    //+ " but the ViewAncestor is attached to " + curView);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.892 -0400", hash_original_method = "EE35B3CBE21A32408B24AA67A208567E", hash_generated_method = "62E99C9B809AD5481CE40F71D3A4A598")
    @DSModeled(DSC.SAFE)
    public void removeViewImmediate(View view) {
        dsTaint.addTaint(view.dsTaint);
        {
            int index;
            index = findViewLocked(view, true);
            ViewRootImpl root;
            root = mRoots[index];
            View curView;
            curView = root.getView();
            root.mAddNesting = 0;
            root.die(true);
            finishRemoveViewLocked(curView, index);
            throw new IllegalStateException("Calling with view " + view
                    + " but the ViewAncestor is attached to " + curView);
        } //End block
        // ---------- Original Method ----------
        //synchronized (this) {
            //int index = findViewLocked(view, true);
            //ViewRootImpl root = mRoots[index];
            //View curView = root.getView();
            //root.mAddNesting = 0;
            //root.die(true);
            //finishRemoveViewLocked(curView, index);
            //if (curView == view) {
                //return;
            //}
            //throw new IllegalStateException("Calling with view " + view
                    //+ " but the ViewAncestor is attached to " + curView);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.893 -0400", hash_original_method = "45C6626A33F0E52A8F561F8DE7007122", hash_generated_method = "C4759A77466DC0255268702DF9890843")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     View removeViewLocked(int index) {
        dsTaint.addTaint(index);
        ViewRootImpl root;
        root = mRoots[index];
        View view;
        view = root.getView();
        root.mAddNesting--;
        {
            InputMethodManager imm;
            imm = InputMethodManager.getInstance(view.getContext());
            {
                imm.windowDismissed(mViews[index].getWindowToken());
            } //End block
        } //End block
        root.die(false);
        finishRemoveViewLocked(view, index);
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        //ViewRootImpl root = mRoots[index];
        //View view = root.getView();
        //root.mAddNesting--;
        //if (root.mAddNesting > 0) {
            //return view;
        //}
        //if (view != null) {
            //InputMethodManager imm = InputMethodManager.getInstance(view.getContext());
            //if (imm != null) {
                //imm.windowDismissed(mViews[index].getWindowToken());
            //}
        //}
        //root.die(false);
        //finishRemoveViewLocked(view, index);
        //return view;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.893 -0400", hash_original_method = "4A1C8F1E2D0E07B0DD1B6F93F46E614A", hash_generated_method = "8C09AA1AA449E657C022CF1AD3F441AA")
    @DSModeled(DSC.SAFE)
     void finishRemoveViewLocked(View view, int index) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(view.dsTaint);
        final int count;
        count = mViews.length;
        View[] tmpViews;
        tmpViews = new View[count-1];
        removeItem(tmpViews, mViews, index);
        mViews = tmpViews;
        ViewRootImpl[] tmpRoots;
        tmpRoots = new ViewRootImpl[count-1];
        removeItem(tmpRoots, mRoots, index);
        mRoots = tmpRoots;
        WindowManager.LayoutParams[] tmpParams;
        tmpParams = new WindowManager.LayoutParams[count-1];
        removeItem(tmpParams, mParams, index);
        mParams = tmpParams;
        {
            view.assignParent(null);
        } //End block
        // ---------- Original Method ----------
        //final int count = mViews.length;
        //View[] tmpViews = new View[count-1];
        //removeItem(tmpViews, mViews, index);
        //mViews = tmpViews;
        //ViewRootImpl[] tmpRoots = new ViewRootImpl[count-1];
        //removeItem(tmpRoots, mRoots, index);
        //mRoots = tmpRoots;
        //WindowManager.LayoutParams[] tmpParams
                //= new WindowManager.LayoutParams[count-1];
        //removeItem(tmpParams, mParams, index);
        //mParams = tmpParams;
        //if (view != null) {
            //view.assignParent(null);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.893 -0400", hash_original_method = "235A702EEE225FF475D5967A0654B4AA", hash_generated_method = "3D581BD14F7A145A8813B39DD3C4E467")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void closeAll(IBinder token, String who, String what) {
        dsTaint.addTaint(token.dsTaint);
        dsTaint.addTaint(what);
        dsTaint.addTaint(who);
        {
            int count;
            count = mViews.length;
            {
                int i;
                i = 0;
                {
                    {
                        ViewRootImpl root;
                        root = mRoots[i];
                        root.mAddNesting = 1;
                        {
                            WindowLeaked leak;
                            leak = new WindowLeaked(
                                what + " " + who + " has leaked window "
                                + root.getView() + " that was originally added here");
                            leak.setStackTrace(root.getLocation().getStackTrace());
                        } //End block
                        removeViewLocked(i);
                        i--;
                        count--;
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.893 -0400", hash_original_method = "1760CCD9A30F61845B0A646D5EFB7F37", hash_generated_method = "5A1F903149403506EFE53994234BD94D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void trimMemory(int level) {
        dsTaint.addTaint(level);
        {
            boolean varC5B5975D48585E4D1B9A993F5AABAEDD_2028214598 = (HardwareRenderer.isAvailable());
            {
                //Begin case ComponentCallbacks2.TRIM_MEMORY_COMPLETE ComponentCallbacks2.TRIM_MEMORY_MODERATE 
                {
                    boolean var08753D6884B6AA0740247389AD694E8A_2125908300 = (!ActivityManager.isHighEndGfx(getDefaultDisplay()));
                    {
                        HardwareRenderer.trimMemory(ComponentCallbacks2.TRIM_MEMORY_COMPLETE);
                        {
                            int count;
                            count = mViews.length;
                            {
                                int i;
                                i = 0;
                                {
                                    mRoots[i].terminateHardwareResources();
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                        ManagedEGLContext.doTerminate();
                    } //End block
                } //End collapsed parenthetic
                //End case ComponentCallbacks2.TRIM_MEMORY_COMPLETE ComponentCallbacks2.TRIM_MEMORY_MODERATE 
                //Begin case default 
                HardwareRenderer.trimMemory(level);
                //End case default 
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.893 -0400", hash_original_method = "B85ACF4E2D1A27D42C4275E82179233A", hash_generated_method = "4C55E629BD35C3FC0AB2DD4A2DBBB8B7")
    @DSModeled(DSC.SAFE)
    public void trimLocalMemory() {
        {
            int count;
            count = mViews.length;
            {
                int i;
                i = 0;
                {
                    mRoots[i].destroyHardwareLayers();
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //synchronized (this) {
            //if (mViews == null) return;
            //int count = mViews.length;
            //for (int i = 0; i < count; i++) {
                //mRoots[i].destroyHardwareLayers();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.894 -0400", hash_original_method = "8E8B6C2ACDFF2687F40321E0E64E3BBE", hash_generated_method = "1145C747DD62C3643DDD9DD011C751A7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void dumpGfxInfo(FileDescriptor fd) {
        dsTaint.addTaint(fd.dsTaint);
        FileOutputStream fout;
        fout = new FileOutputStream(fd);
        PrintWriter pw;
        pw = new PrintWriter(fout);
        try 
        {
            {
                {
                    pw.println("View hierarchy:");
                    final int count;
                    count = mViews.length;
                    int viewsCount;
                    viewsCount = 0;
                    int displayListsSize;
                    displayListsSize = 0;
                    int[] info;
                    info = new int[2];
                    {
                        int i;
                        i = 0;
                        {
                            ViewRootImpl root;
                            root = mRoots[i];
                            root.dumpGfxInfo(pw, info);
                            String name;
                            name = root.getClass().getName() + '@' +
                                Integer.toHexString(hashCode());
                            pw.printf("  %s: %d views, %.2f kB (display lists)\n",
                                name, info[0], info[1] / 1024.0f);
                            viewsCount += info[0];
                            displayListsSize += info[1];
                        } //End block
                    } //End collapsed parenthetic
                    pw.printf("\nTotal ViewRootImpl: %d\n", count);
                    pw.printf("Total Views:        %d\n", viewsCount);
                    pw.printf("Total DisplayList:  %.2f kB\n\n", displayListsSize / 1024.0f);
                } //End block
            } //End block
        } //End block
        finally 
        {
            pw.flush();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.894 -0400", hash_original_method = "32E6F8530311607C65FF5EAF5F0BD6AD", hash_generated_method = "CBD22E4328EA4C79B859B8B3EEEC9531")
    @DSModeled(DSC.SAFE)
    public void setStoppedState(IBinder token, boolean stopped) {
        dsTaint.addTaint(token.dsTaint);
        dsTaint.addTaint(stopped);
        {
            int count;
            count = mViews.length;
            {
                int i;
                i = 0;
                {
                    {
                        ViewRootImpl root;
                        root = mRoots[i];
                        root.setStopped(stopped);
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //synchronized (this) {
            //if (mViews == null)
                //return;
            //int count = mViews.length;
            //for (int i=0; i<count; i++) {
                //if (token == null || mParams[i].token == token) {
                    //ViewRootImpl root = mRoots[i];
                    //root.setStopped(stopped);
                //}
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.894 -0400", hash_original_method = "5FCDC552B8E05196F9C2F723B4C31106", hash_generated_method = "4D792908D49F603C5D293CB9DDD308EB")
    @DSModeled(DSC.SAFE)
    public void reportNewConfiguration(Configuration config) {
        dsTaint.addTaint(config.dsTaint);
        {
            int count;
            count = mViews.length;
            config = new Configuration(config);
            {
                int i;
                i = 0;
                {
                    ViewRootImpl root;
                    root = mRoots[i];
                    root.requestUpdateConfiguration(config);
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //synchronized (this) {
            //int count = mViews.length;
            //config = new Configuration(config);
            //for (int i=0; i<count; i++) {
                //ViewRootImpl root = mRoots[i];
                //root.requestUpdateConfiguration(config);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.894 -0400", hash_original_method = "1CFBFD36B7BEFA0EB1A8D0118BDA1924", hash_generated_method = "580BB08A5238F7B9C0E671D9C1DEFE59")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public WindowManager.LayoutParams getRootViewLayoutParameter(View view) {
        dsTaint.addTaint(view.dsTaint);
        ViewParent vp;
        vp = view.getParent();
        {
            vp = vp.getParent();
        } //End block
        ViewRootImpl vr;
        vr = (ViewRootImpl)vp;
        int N;
        N = mRoots.length;
        {
            int i;
            i = 0;
        } //End collapsed parenthetic
        return (WindowManager.LayoutParams)dsTaint.getTaint();
        // ---------- Original Method ----------
        //ViewParent vp = view.getParent();
        //while (vp != null && !(vp instanceof ViewRootImpl)) {
            //vp = vp.getParent();
        //}
        //if (vp == null) return null;
        //ViewRootImpl vr = (ViewRootImpl)vp;
        //int N = mRoots.length;
        //for (int i = 0; i < N; ++i) {
            //if (mRoots[i] == vr) {
                //return mParams[i];
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.894 -0400", hash_original_method = "2D5B77D42F80E7BB97C9217066ACC1E7", hash_generated_method = "8BAF3185136833E0F4EFC06D180C2408")
    @DSModeled(DSC.SAFE)
    public void closeAll() {
        closeAll(null, null, null);
        // ---------- Original Method ----------
        //closeAll(null, null, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.894 -0400", hash_original_method = "6421FA4950C786DB3C3137628B8417F4", hash_generated_method = "99882B313A9261C25A7040C1DAF6EEAB")
    @DSModeled(DSC.SAFE)
    public Display getDefaultDisplay() {
        return (Display)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new Display(Display.DEFAULT_DISPLAY, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.894 -0400", hash_original_method = "5920761E6519D7DF42289A49318C9DD3", hash_generated_method = "39BA323056CD4B7A0D72C53C01F90DC8")
    private static void removeItem(Object[] dst, Object[] src, int index) {
        if (dst.length > 0) {
            if (index > 0) {
                System.arraycopy(src, 0, dst, 0, index);
            }
            if (index < dst.length) {
                System.arraycopy(src, index+1, dst, index, src.length-index-1);
            }
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.894 -0400", hash_original_method = "D0BCCB21246B97649D4401D223B22EEE", hash_generated_method = "093BFFBFAF4CF02C1294DDB4A50BADA8")
    @DSModeled(DSC.SAFE)
    private int findViewLocked(View view, boolean required) {
        dsTaint.addTaint(view.dsTaint);
        dsTaint.addTaint(required);
        {
            final int count;
            count = mViews.length;
            count = 0;
            {
                int i;
                i = 0;
            } //End collapsed parenthetic
            {
                throw new IllegalArgumentException(
                        "View not attached to window manager");
            } //End block
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //synchronized (this) {
            //final int count = mViews != null ? mViews.length : 0;
            //for (int i=0; i<count; i++) {
                //if (mViews[i] == view) {
                    //return i;
                //}
            //}
            //if (required) {
                //throw new IllegalArgumentException(
                        //"View not attached to window manager");
            //}
            //return -1;
        //}
    }

    
    static class CompatModeWrapper implements WindowManager {
        private final WindowManagerImpl mWindowManager;
        private final Display mDefaultDisplay;
        private final CompatibilityInfoHolder mCompatibilityInfo;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.895 -0400", hash_original_method = "3FF7A4C8C61ABC650A78463DAC06ED7D", hash_generated_method = "F5AD8708A9C93A160D91D1CB2295414D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         CompatModeWrapper(WindowManager wm, CompatibilityInfoHolder ci) {
            dsTaint.addTaint(wm.dsTaint);
            dsTaint.addTaint(ci.dsTaint);
            mWindowManager = wm instanceof CompatModeWrapper
                    ? ((CompatModeWrapper)wm).mWindowManager : (WindowManagerImpl)wm;
            {
                mDefaultDisplay = mWindowManager.getDefaultDisplay();
            } //End block
            {
                mDefaultDisplay = Display.createCompatibleDisplay(
                        mWindowManager.getDefaultDisplay().getDisplayId(), ci);
            } //End block
            // ---------- Original Method ----------
            //mWindowManager = wm instanceof CompatModeWrapper
                    //? ((CompatModeWrapper)wm).mWindowManager : (WindowManagerImpl)wm;
            //if (ci == null) {
                //mDefaultDisplay = mWindowManager.getDefaultDisplay();
            //} else {
                //mDefaultDisplay = Display.createCompatibleDisplay(
                        //mWindowManager.getDefaultDisplay().getDisplayId(), ci);
            //}
            //mCompatibilityInfo = ci;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.895 -0400", hash_original_method = "7609871ECBC27319C7927D8EEDE045EA", hash_generated_method = "59995C5A4422B1FD9EEB3B1ADCE2B91F")
        @DSModeled(DSC.SAFE)
        @Override
        public void addView(View view, android.view.ViewGroup.LayoutParams params) {
            dsTaint.addTaint(view.dsTaint);
            dsTaint.addTaint(params.dsTaint);
            mWindowManager.addView(view, params, mCompatibilityInfo);
            // ---------- Original Method ----------
            //mWindowManager.addView(view, params, mCompatibilityInfo);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.895 -0400", hash_original_method = "919C5545CD5BB1E858D85286FE5FCBED", hash_generated_method = "720520E9F9A4D25C7AD69BF2700DC44E")
        @DSModeled(DSC.SAFE)
        @Override
        public void updateViewLayout(View view, android.view.ViewGroup.LayoutParams params) {
            dsTaint.addTaint(view.dsTaint);
            dsTaint.addTaint(params.dsTaint);
            mWindowManager.updateViewLayout(view, params);
            // ---------- Original Method ----------
            //mWindowManager.updateViewLayout(view, params);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.895 -0400", hash_original_method = "5F05EF082DAFF0E6020E51FDACFCFBF6", hash_generated_method = "5EAEC80B02E51044800751CC4318A692")
        @DSModeled(DSC.SAFE)
        @Override
        public void removeView(View view) {
            dsTaint.addTaint(view.dsTaint);
            mWindowManager.removeView(view);
            // ---------- Original Method ----------
            //mWindowManager.removeView(view);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.895 -0400", hash_original_method = "56BE5D6095195D262FD5BEEEDA100E7B", hash_generated_method = "9FF350944B2A92CBE85AC4C9B621CF61")
        @DSModeled(DSC.SAFE)
        @Override
        public Display getDefaultDisplay() {
            return (Display)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return mDefaultDisplay;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.895 -0400", hash_original_method = "4EE5EB2962C6A561F3596BAB39C4DB7E", hash_generated_method = "7F9668663F1EAF369E3E37D84FE6C2BC")
        @DSModeled(DSC.SAFE)
        @Override
        public void removeViewImmediate(View view) {
            dsTaint.addTaint(view.dsTaint);
            mWindowManager.removeViewImmediate(view);
            // ---------- Original Method ----------
            //mWindowManager.removeViewImmediate(view);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.895 -0400", hash_original_method = "E8FDE829A6ED2289D510D94BC19E7A4F", hash_generated_method = "19537A76CE9E0A98C3BB6B296691B64B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean isHardwareAccelerated() {
            boolean var537FD339DB319870C25465E8732CD454_1058434640 = (mWindowManager.isHardwareAccelerated());
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return mWindowManager.isHardwareAccelerated();
        }

        
    }


    
}


