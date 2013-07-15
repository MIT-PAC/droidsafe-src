package android.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:54.997 -0400", hash_original_method = "FBED2002249AD131D5B5A71E6D66FC21", hash_generated_method = "B428DBE2E7043E67065C3E1AC92F2B4B")
    public  WindowLeaked(String msg) {
        super(msg);
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
    }

    
}

public class WindowManagerImpl implements WindowManager {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:54.997 -0400", hash_original_field = "F4A2381F0ED039C4005692ED45DE82D7", hash_generated_field = "1FE8B5AC02273EF00EC01B5EE801E265")

    private View[] mViews;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:54.998 -0400", hash_original_field = "C5109F9CE8A636F7BCE9D70BF3CB312D", hash_generated_field = "30F0340706746C5BEBF7EDA66601F6B0")

    private ViewRootImpl[] mRoots;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:54.998 -0400", hash_original_field = "18200E5D7C3839693F00E5A4D3DAD0B6", hash_generated_field = "CD18B20CABA4892D4B646B54A9A2A4C6")

    private WindowManager.LayoutParams[] mParams;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:54.998 -0400", hash_original_method = "3EABCF2A614A6DEC3CA7FC91E47982AB", hash_generated_method = "3EABCF2A614A6DEC3CA7FC91E47982AB")
    public WindowManagerImpl ()
    {
        //Synthesized constructor
    }


        @DSModeled(DSC.SAFE)
    public static WindowManagerImpl getDefault() {
        return sWindowManager;
    }

    
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

    
        public static WindowManager getDefault(CompatibilityInfoHolder compatInfo) {
        return new CompatModeWrapper(sWindowManager, compatInfo);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:54.999 -0400", hash_original_method = "8E464E19F5A7F279FF3FC1B84D15C4F0", hash_generated_method = "AEECAF99CDD7AB94B75127315C7F18D3")
    public boolean isHardwareAccelerated() {
        boolean var68934A3E9455FA72420237EB05902327_807972442 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_898281800 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_898281800;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:54.999 -0400", hash_original_method = "3A47767500C080C4B7D3F95A5195D385", hash_generated_method = "600FF69966859A98C0DB15D9B7C8B7EE")
    public void addView(View view) {
        addTaint(view.getTaint());
        addView(view, new WindowManager.LayoutParams(
            WindowManager.LayoutParams.TYPE_APPLICATION, 0, PixelFormat.OPAQUE));
        // ---------- Original Method ----------
        //addView(view, new WindowManager.LayoutParams(
            //WindowManager.LayoutParams.TYPE_APPLICATION, 0, PixelFormat.OPAQUE));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:54.999 -0400", hash_original_method = "133D7EA484587CEAA64BDEB4AE9186C6", hash_generated_method = "9B68187C13CFAA210B13A10EAE911C61")
    public void addView(View view, ViewGroup.LayoutParams params) {
        addTaint(params.getTaint());
        addTaint(view.getTaint());
        addView(view, params, null, false);
        // ---------- Original Method ----------
        //addView(view, params, null, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.000 -0400", hash_original_method = "6E55E902889BC8630B8C2A4EBA8587B9", hash_generated_method = "C3FBB6E8F2E0FAECED94D821161F1F7A")
    public void addView(View view, ViewGroup.LayoutParams params, CompatibilityInfoHolder cih) {
        addTaint(cih.getTaint());
        addTaint(params.getTaint());
        addTaint(view.getTaint());
        addView(view, params, cih, false);
        // ---------- Original Method ----------
        //addView(view, params, cih, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.002 -0400", hash_original_method = "FC07162832A382775417964F34DC350F", hash_generated_method = "890348C40F76BE17A3A17B27F27D1DF9")
    private void addView(View view, ViewGroup.LayoutParams params,
            CompatibilityInfoHolder cih, boolean nest) {
        addTaint(nest);
        addTaint(cih.getTaint());
        addTaint(params.getTaint());
    if(false){ }    if(!(params instanceof WindowManager.LayoutParams))        
        {
            IllegalArgumentException varF9E7711EDF83EF8F3B912E6788442F8D_65160244 = new IllegalArgumentException(
                    "Params must be WindowManager.LayoutParams");
            varF9E7711EDF83EF8F3B912E6788442F8D_65160244.addTaint(taint);
            throw varF9E7711EDF83EF8F3B912E6788442F8D_65160244;
        } //End block
        final WindowManager.LayoutParams wparams = (WindowManager.LayoutParams)params;
        ViewRootImpl root;
        View panelParentView = null;
        synchronized
(this)        {
            int index = findViewLocked(view, false);
    if(index >= 0)            
            {
    if(!nest)                
                {
                    IllegalStateException var1071B68F9C0257160148C881A18C63B1_55183949 = new IllegalStateException("View " + view
                            + " has already been added to the window manager.");
                    var1071B68F9C0257160148C881A18C63B1_55183949.addTaint(taint);
                    throw var1071B68F9C0257160148C881A18C63B1_55183949;
                } //End block
                root = mRoots[index];
                root.mAddNesting++;
                view.setLayoutParams(wparams);
                root.setLayoutParams(wparams, true);
                return;
            } //End block
    if(wparams.type >= WindowManager.LayoutParams.FIRST_SUB_WINDOW &&
                    wparams.type <= WindowManager.LayoutParams.LAST_SUB_WINDOW)            
            {
                final int count = mViews != null ? mViews.length : 0;
for(int i=0;i<count;i++)
                {
    if(mRoots[i].mWindow.asBinder() == wparams.token)                    
                    {
                        panelParentView = mViews[i];
                    } //End block
                } //End block
            } //End block
            root = new ViewRootImpl(view.getContext());
            root.mAddNesting = 1;
    if(cih == null)            
            {
                root.mCompatibilityInfo = new CompatibilityInfoHolder();
            } //End block
            else
            {
                root.mCompatibilityInfo = cih;
            } //End block
            view.setLayoutParams(wparams);
    if(mViews == null)            
            {
                index = 1;
                mViews = new View[1];
                mRoots = new ViewRootImpl[1];
                mParams = new WindowManager.LayoutParams[1];
            } //End block
            else
            {
                index = mViews.length + 1;
                Object[] old = mViews;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.004 -0400", hash_original_method = "ED95BEACF52CBB6AE255A4987CA1BF10", hash_generated_method = "6B0FC4E59FA1368E194644C0D4EE38F0")
    public void updateViewLayout(View view, ViewGroup.LayoutParams params) {
        addTaint(params.getTaint());
        addTaint(view.getTaint());
    if(!(params instanceof WindowManager.LayoutParams))        
        {
            IllegalArgumentException varF9E7711EDF83EF8F3B912E6788442F8D_493010133 = new IllegalArgumentException("Params must be WindowManager.LayoutParams");
            varF9E7711EDF83EF8F3B912E6788442F8D_493010133.addTaint(taint);
            throw varF9E7711EDF83EF8F3B912E6788442F8D_493010133;
        } //End block
        final WindowManager.LayoutParams wparams = (WindowManager.LayoutParams)params;
        view.setLayoutParams(wparams);
        synchronized
(this)        {
            int index = findViewLocked(view, true);
            ViewRootImpl root = mRoots[index];
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.004 -0400", hash_original_method = "6ED1D335390D20FBE30CC53F4D61DE9F", hash_generated_method = "95D249629CDEDD2387AD9367242B489E")
    public void removeView(View view) {
        addTaint(view.getTaint());
        synchronized
(this)        {
            int index = findViewLocked(view, true);
            View curView = removeViewLocked(index);
    if(curView == view)            
            {
                return;
            } //End block
            IllegalStateException var374AC11D5C4C32FEE4B3575885C8355F_1821292955 = new IllegalStateException("Calling with view " + view
                    + " but the ViewAncestor is attached to " + curView);
            var374AC11D5C4C32FEE4B3575885C8355F_1821292955.addTaint(taint);
            throw var374AC11D5C4C32FEE4B3575885C8355F_1821292955;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.005 -0400", hash_original_method = "EE35B3CBE21A32408B24AA67A208567E", hash_generated_method = "38308B457F87043C0DB900142CC07732")
    public void removeViewImmediate(View view) {
        addTaint(view.getTaint());
        synchronized
(this)        {
            int index = findViewLocked(view, true);
            ViewRootImpl root = mRoots[index];
            View curView = root.getView();
            root.mAddNesting = 0;
            root.die(true);
            finishRemoveViewLocked(curView, index);
    if(curView == view)            
            {
                return;
            } //End block
            IllegalStateException var374AC11D5C4C32FEE4B3575885C8355F_2087578520 = new IllegalStateException("Calling with view " + view
                    + " but the ViewAncestor is attached to " + curView);
            var374AC11D5C4C32FEE4B3575885C8355F_2087578520.addTaint(taint);
            throw var374AC11D5C4C32FEE4B3575885C8355F_2087578520;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.006 -0400", hash_original_method = "45C6626A33F0E52A8F561F8DE7007122", hash_generated_method = "87EAE972A9089784A0A3D7810D1B438B")
     View removeViewLocked(int index) {
        addTaint(index);
        ViewRootImpl root = mRoots[index];
        View view = root.getView();
        root.mAddNesting--;
    if(root.mAddNesting > 0)        
        {
View var057D265746AE9672AFE5F9FF6338071D_25719011 =             view;
            var057D265746AE9672AFE5F9FF6338071D_25719011.addTaint(taint);
            return var057D265746AE9672AFE5F9FF6338071D_25719011;
        } //End block
    if(view != null)        
        {
            InputMethodManager imm = InputMethodManager.getInstance(view.getContext());
    if(imm != null)            
            {
                imm.windowDismissed(mViews[index].getWindowToken());
            } //End block
        } //End block
        root.die(false);
        finishRemoveViewLocked(view, index);
View var057D265746AE9672AFE5F9FF6338071D_1431724723 =         view;
        var057D265746AE9672AFE5F9FF6338071D_1431724723.addTaint(taint);
        return var057D265746AE9672AFE5F9FF6338071D_1431724723;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.008 -0400", hash_original_method = "4A1C8F1E2D0E07B0DD1B6F93F46E614A", hash_generated_method = "648F8B43D923FE9D544ACA88F468F6BB")
     void finishRemoveViewLocked(View view, int index) {
        addTaint(index);
        addTaint(view.getTaint());
        final int count = mViews.length;
        View[] tmpViews = new View[count-1];
        removeItem(tmpViews, mViews, index);
        mViews = tmpViews;
        ViewRootImpl[] tmpRoots = new ViewRootImpl[count-1];
        removeItem(tmpRoots, mRoots, index);
        mRoots = tmpRoots;
        WindowManager.LayoutParams[] tmpParams = new WindowManager.LayoutParams[count-1];
        removeItem(tmpParams, mParams, index);
        mParams = tmpParams;
    if(view != null)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.009 -0400", hash_original_method = "235A702EEE225FF475D5967A0654B4AA", hash_generated_method = "8D8B8F901F68C8841231CF905E031D4C")
    public void closeAll(IBinder token, String who, String what) {
        addTaint(what.getTaint());
        addTaint(who.getTaint());
        addTaint(token.getTaint());
        synchronized
(this)        {
    if(mViews == null)            
            return;
            int count = mViews.length;
for(int i=0;i<count;i++)
            {
    if(token == null || mParams[i].token == token)                
                {
                    ViewRootImpl root = mRoots[i];
                    root.mAddNesting = 1;
    if(who != null)                    
                    {
                        WindowLeaked leak = new WindowLeaked(
                                what + " " + who + " has leaked window "
                                + root.getView() + " that was originally added here");
                        leak.setStackTrace(root.getLocation().getStackTrace());
                    } //End block
                    removeViewLocked(i);
                    i--;
                    count--;
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.009 -0400", hash_original_method = "1760CCD9A30F61845B0A646D5EFB7F37", hash_generated_method = "C899BF8F6E94EE0F3184FDFACF09737E")
    public void trimMemory(int level) {
        addTaint(level);
    if(HardwareRenderer.isAvailable())        
        {
switch(level){
            case ComponentCallbacks2.TRIM_MEMORY_COMPLETE:
            case ComponentCallbacks2.TRIM_MEMORY_MODERATE:
    if(!ActivityManager.isHighEndGfx(getDefaultDisplay()))            
            {
                HardwareRenderer.trimMemory(ComponentCallbacks2.TRIM_MEMORY_COMPLETE);
                synchronized
(this)                {
    if(mViews == null)                    
                    return;
                    int count = mViews.length;
for(int i = 0;i < count;i++)
                    {
                        mRoots[i].terminateHardwareResources();
                    } //End block
                } //End block
                ManagedEGLContext.doTerminate();
                break;
            } //End block
            default:
            HardwareRenderer.trimMemory(level);
}
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.010 -0400", hash_original_method = "B85ACF4E2D1A27D42C4275E82179233A", hash_generated_method = "7C07F04EA59363CB3E57CF748C4D328B")
    public void trimLocalMemory() {
        synchronized
(this)        {
    if(mViews == null)            
            return;
            int count = mViews.length;
for(int i = 0;i < count;i++)
            {
                mRoots[i].destroyHardwareLayers();
            } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.011 -0400", hash_original_method = "8E8B6C2ACDFF2687F40321E0E64E3BBE", hash_generated_method = "CDC369AF972FD3235D2CFF9F4CC7FC41")
    public void dumpGfxInfo(FileDescriptor fd) {
        addTaint(fd.getTaint());
        FileOutputStream fout = new FileOutputStream(fd);
        PrintWriter pw = new PrintWriter(fout);
        try 
        {
            synchronized
(this)            {
    if(mViews != null)                
                {
                    pw.println("View hierarchy:");
                    final int count = mViews.length;
                    int viewsCount = 0;
                    int displayListsSize = 0;
                    int[] info = new int[2];
for(int i = 0;i < count;i++)
                    {
                        ViewRootImpl root = mRoots[i];
                        root.dumpGfxInfo(pw, info);
                        String name = root.getClass().getName() + '@' +
                                Integer.toHexString(hashCode());
                        pw.printf("  %s: %d views, %.2f kB (display lists)\n",
                                name, info[0], info[1] / 1024.0f);
                        viewsCount += info[0];
                        displayListsSize += info[1];
                    } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.011 -0400", hash_original_method = "32E6F8530311607C65FF5EAF5F0BD6AD", hash_generated_method = "D82EEFAE5B79DF60BC3641DB333FACBB")
    public void setStoppedState(IBinder token, boolean stopped) {
        addTaint(stopped);
        addTaint(token.getTaint());
        synchronized
(this)        {
    if(mViews == null)            
            return;
            int count = mViews.length;
for(int i=0;i<count;i++)
            {
    if(token == null || mParams[i].token == token)                
                {
                    ViewRootImpl root = mRoots[i];
                    root.setStopped(stopped);
                } //End block
            } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.012 -0400", hash_original_method = "5FCDC552B8E05196F9C2F723B4C31106", hash_generated_method = "0BF914CB92F4F452AC34ECF0E976F09D")
    public void reportNewConfiguration(Configuration config) {
        addTaint(config.getTaint());
        synchronized
(this)        {
            int count = mViews.length;
            config = new Configuration(config);
for(int i=0;i<count;i++)
            {
                ViewRootImpl root = mRoots[i];
                root.requestUpdateConfiguration(config);
            } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.012 -0400", hash_original_method = "1CFBFD36B7BEFA0EB1A8D0118BDA1924", hash_generated_method = "C1211A1D67F71EECA8586C53BE47C228")
    public WindowManager.LayoutParams getRootViewLayoutParameter(View view) {
        addTaint(view.getTaint());
        ViewParent vp = view.getParent();
        while
(vp != null && !(vp instanceof ViewRootImpl))        
        {
            vp = vp.getParent();
        } //End block
    if(vp == null)        
        {
WindowManager.LayoutParams var540C13E9E156B687226421B24F2DF178_1542344798 =         null;
        var540C13E9E156B687226421B24F2DF178_1542344798.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1542344798;
        }
        ViewRootImpl vr = (ViewRootImpl)vp;
        int N = mRoots.length;
for(int i = 0;i < N;++i)
        {
    if(mRoots[i] == vr)            
            {
WindowManager.LayoutParams var009AA4FD587C8BB71FBA5CC2EE281225_1764525314 =                 mParams[i];
                var009AA4FD587C8BB71FBA5CC2EE281225_1764525314.addTaint(taint);
                return var009AA4FD587C8BB71FBA5CC2EE281225_1764525314;
            } //End block
        } //End block
WindowManager.LayoutParams var540C13E9E156B687226421B24F2DF178_463639332 =         null;
        var540C13E9E156B687226421B24F2DF178_463639332.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_463639332;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.012 -0400", hash_original_method = "2D5B77D42F80E7BB97C9217066ACC1E7", hash_generated_method = "910D676C81E32EF366F77F71D3376042")
    public void closeAll() {
        closeAll(null, null, null);
        // ---------- Original Method ----------
        //closeAll(null, null, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.013 -0400", hash_original_method = "6421FA4950C786DB3C3137628B8417F4", hash_generated_method = "7FEBBABE3FA63D40A3F3621487035641")
    public Display getDefaultDisplay() {
Display var15DC8EFA0A5C9CE2FFEA5848868DAC8F_783504107 =         new Display(Display.DEFAULT_DISPLAY, null);
        var15DC8EFA0A5C9CE2FFEA5848868DAC8F_783504107.addTaint(taint);
        return var15DC8EFA0A5C9CE2FFEA5848868DAC8F_783504107;
        // ---------- Original Method ----------
        //return new Display(Display.DEFAULT_DISPLAY, null);
    }

    
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.013 -0400", hash_original_method = "D0BCCB21246B97649D4401D223B22EEE", hash_generated_method = "75BBD45A8A4839343F0BEBBDE62DD80B")
    private int findViewLocked(View view, boolean required) {
        addTaint(required);
        addTaint(view.getTaint());
        synchronized
(this)        {
            final int count = mViews != null ? mViews.length : 0;
for(int i=0;i<count;i++)
            {
    if(mViews[i] == view)                
                {
                    int var865C0C0B4AB0E063E5CAA3387C1A8741_1809738711 = (i);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1683322951 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1683322951;
                } //End block
            } //End block
    if(required)            
            {
                IllegalArgumentException varD9EC8A213C0D0D994D60CBA0E1DB270B_2064815277 = new IllegalArgumentException(
                        "View not attached to window manager");
                varD9EC8A213C0D0D994D60CBA0E1DB270B_2064815277.addTaint(taint);
                throw varD9EC8A213C0D0D994D60CBA0E1DB270B_2064815277;
            } //End block
            int var6BB61E3B7BCE0931DA574D19D1D82C88_922482006 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_557631342 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_557631342;
        } //End block
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.014 -0400", hash_original_field = "306519E50E3A91B9733D09F5D8EB985C", hash_generated_field = "FEEC7915B51FB12A1344576DA3BE0D25")

        private WindowManagerImpl mWindowManager;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.014 -0400", hash_original_field = "17753C02FDB97D79869D5B96341900F6", hash_generated_field = "C3E7910AA914C8E7E284BFD6C9B88D3E")

        private Display mDefaultDisplay;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.014 -0400", hash_original_field = "27C9B400936470E0D86B9AA2CDF3AED4", hash_generated_field = "01AEB6BE7A1CFB44C6B781D7301EC317")

        private CompatibilityInfoHolder mCompatibilityInfo;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.014 -0400", hash_original_method = "3FF7A4C8C61ABC650A78463DAC06ED7D", hash_generated_method = "9DC5F473B5C44E92E7428AD5BA04466A")
          CompatModeWrapper(WindowManager wm, CompatibilityInfoHolder ci) {
            mWindowManager = wm instanceof CompatModeWrapper
                    ? ((CompatModeWrapper)wm).mWindowManager : (WindowManagerImpl)wm;
    if(ci == null)            
            {
                mDefaultDisplay = mWindowManager.getDefaultDisplay();
            } //End block
            else
            {
                mDefaultDisplay = Display.createCompatibleDisplay(
                        mWindowManager.getDefaultDisplay().getDisplayId(), ci);
            } //End block
            mCompatibilityInfo = ci;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.015 -0400", hash_original_method = "7609871ECBC27319C7927D8EEDE045EA", hash_generated_method = "27F6C17A1E8668E3CE182069010203B4")
        @Override
        public void addView(View view, android.view.ViewGroup.LayoutParams params) {
            addTaint(params.getTaint());
            addTaint(view.getTaint());
            mWindowManager.addView(view, params, mCompatibilityInfo);
            // ---------- Original Method ----------
            //mWindowManager.addView(view, params, mCompatibilityInfo);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.015 -0400", hash_original_method = "919C5545CD5BB1E858D85286FE5FCBED", hash_generated_method = "56DB16618E2A003ED227B595CB7F0D04")
        @Override
        public void updateViewLayout(View view, android.view.ViewGroup.LayoutParams params) {
            addTaint(params.getTaint());
            addTaint(view.getTaint());
            mWindowManager.updateViewLayout(view, params);
            // ---------- Original Method ----------
            //mWindowManager.updateViewLayout(view, params);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.015 -0400", hash_original_method = "5F05EF082DAFF0E6020E51FDACFCFBF6", hash_generated_method = "220E9649562E39191092F8569472AB88")
        @Override
        public void removeView(View view) {
            addTaint(view.getTaint());
            mWindowManager.removeView(view);
            // ---------- Original Method ----------
            //mWindowManager.removeView(view);
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.015 -0400", hash_original_method = "56BE5D6095195D262FD5BEEEDA100E7B", hash_generated_method = "CA718A6BB13ECF605B88229575CDC3F4")
        @Override
        public Display getDefaultDisplay() {
Display varD12F9DF4287A14A2D53902174684A7C5_786177063 =             mDefaultDisplay;
            varD12F9DF4287A14A2D53902174684A7C5_786177063.addTaint(taint);
            return varD12F9DF4287A14A2D53902174684A7C5_786177063;
            // ---------- Original Method ----------
            //return mDefaultDisplay;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.016 -0400", hash_original_method = "4EE5EB2962C6A561F3596BAB39C4DB7E", hash_generated_method = "A3B47ED81A5575738D502ACC7E01285F")
        @Override
        public void removeViewImmediate(View view) {
            addTaint(view.getTaint());
            mWindowManager.removeViewImmediate(view);
            // ---------- Original Method ----------
            //mWindowManager.removeViewImmediate(view);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.016 -0400", hash_original_method = "E8FDE829A6ED2289D510D94BC19E7A4F", hash_generated_method = "C6941E4BF1C348B5950F8E7D22449773")
        @Override
        public boolean isHardwareAccelerated() {
            boolean varF3A74188EAA29CBA070E815BDBA82886_1658222943 = (mWindowManager.isHardwareAccelerated());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1745820494 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1745820494;
            // ---------- Original Method ----------
            //return mWindowManager.isHardwareAccelerated();
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.016 -0400", hash_original_field = "096BF12F9EBCA28E49706C74E09FD905", hash_generated_field = "BEBDB0C4DE9800D9D6744BC8414EE1E3")

    public static final int RELAYOUT_RES_IN_TOUCH_MODE = 0x1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.016 -0400", hash_original_field = "1B20578EB71512F8EABE8E7F0F7FB607", hash_generated_field = "8F62C3BDE71832A2D68F514201B29E45")

    public static final int RELAYOUT_RES_FIRST_TIME = 0x2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.016 -0400", hash_original_field = "72C941E47F017B452573327573961320", hash_generated_field = "68A8891465BB14EE588048EAE11177B6")

    public static final int RELAYOUT_RES_SURFACE_CHANGED = 0x4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.016 -0400", hash_original_field = "604E01920957E315364B134C955C11F1", hash_generated_field = "3D5DD8B8FA44EAB5D12F636499EC9823")

    public static final int RELAYOUT_INSETS_PENDING = 0x1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.016 -0400", hash_original_field = "32D1EBFCBE50F75F286EA02D4C377D17", hash_generated_field = "174CC84AFA7FFC82F7BCA824DF5DBFB8")

    public static final int RELAYOUT_DEFER_SURFACE_DESTROY = 0x2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.016 -0400", hash_original_field = "FD57D39BAE14DD800BE94CD1FEC2F209", hash_generated_field = "B45631C5AC56ACFEA482DD61E10D666D")

    public static final int ADD_FLAG_APP_VISIBLE = 0x2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.016 -0400", hash_original_field = "1090FF8B24E420D2B55E68C183773C2F", hash_generated_field = "8A0B6E6C40A3B9E8AD1DB662FFBC63B1")

    public static final int ADD_FLAG_IN_TOUCH_MODE = RELAYOUT_RES_IN_TOUCH_MODE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.017 -0400", hash_original_field = "C1D359C476720A1A13CB6DD42DD9927D", hash_generated_field = "896EA10F4EEDBD22866D19F5C37C2883")

    public static final int ADD_OKAY = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.017 -0400", hash_original_field = "B8045D0803B176FA3C49EAD8DDCEE78D", hash_generated_field = "6250BE795ED30E4E71D089144220CBD2")

    public static final int ADD_BAD_APP_TOKEN = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.017 -0400", hash_original_field = "69BCE95D0619221231007FF0223CD5CA", hash_generated_field = "1E507DB8D29AA4E4EB75979C5B513862")

    public static final int ADD_BAD_SUBWINDOW_TOKEN = -2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.017 -0400", hash_original_field = "87D3BDC7125C9B7F3F0C5AAA3081CBEE", hash_generated_field = "CF74437B4ABA6A66CC5F33FAE0469A87")

    public static final int ADD_NOT_APP_TOKEN = -3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.017 -0400", hash_original_field = "83C33948AE1D352A3EB2C666F9FECDC6", hash_generated_field = "25698B4845820B88A430CDDB9E487015")

    public static final int ADD_APP_EXITING = -4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.017 -0400", hash_original_field = "164990C5E8C2ED546F72E8EBB28411DF", hash_generated_field = "3AF2CF38E39266B60A6668C9A516A055")

    public static final int ADD_DUPLICATE_ADD = -5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.017 -0400", hash_original_field = "54E79096188F641E1A287759CF9E265B", hash_generated_field = "D789E72C8CABCD14EC5B0824A2F2FC96")

    public static final int ADD_STARTING_NOT_NEEDED = -6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.017 -0400", hash_original_field = "FA9EC826AD38BA3AD63DC34123C61D1F", hash_generated_field = "EA6A54060B8C4D297CDC8FC5F3153ECE")

    public static final int ADD_MULTIPLE_SINGLETON = -7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.017 -0400", hash_original_field = "B6CCE3C35D140B35BBE6FDBA8B104F1A", hash_generated_field = "8036D9CCA49B1A5D7465CBB746CA2A36")

    public static final int ADD_PERMISSION_DENIED = -8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.017 -0400", hash_original_field = "6FBEC3E7BB69D1E09ECABF075E18871F", hash_generated_field = "E2243BE928463BEF85C2376ED862E621")

    private final static Object sLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.017 -0400", hash_original_field = "83DB86F24D6A373312BF12EDD9A412A6", hash_generated_field = "10062A1B5CD58B2F6E5CDFDBEAFBAC67")

    private final static WindowManagerImpl sWindowManager = new WindowManagerImpl();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:55.017 -0400", hash_original_field = "75C834DF5CDF76F1FB4C0DD3037986FA", hash_generated_field = "3734D40F2DD976B4882738308BA77A0A")

    private final static HashMap<CompatibilityInfo, WindowManager> sCompatWindowManagers = new HashMap<CompatibilityInfo, WindowManager>();
}

