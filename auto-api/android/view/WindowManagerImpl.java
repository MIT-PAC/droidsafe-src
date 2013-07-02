package android.view;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.849 -0400", hash_original_method = "FBED2002249AD131D5B5A71E6D66FC21", hash_generated_method = "B428DBE2E7043E67065C3E1AC92F2B4B")
    public  WindowLeaked(String msg) {
        super(msg);
        addTaint(msg.getTaint());
        
    }

    
}

public class WindowManagerImpl implements WindowManager {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.849 -0400", hash_original_field = "F4A2381F0ED039C4005692ED45DE82D7", hash_generated_field = "1FE8B5AC02273EF00EC01B5EE801E265")

    private View[] mViews;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.849 -0400", hash_original_field = "C5109F9CE8A636F7BCE9D70BF3CB312D", hash_generated_field = "30F0340706746C5BEBF7EDA66601F6B0")

    private ViewRootImpl[] mRoots;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.849 -0400", hash_original_field = "18200E5D7C3839693F00E5A4D3DAD0B6", hash_generated_field = "CD18B20CABA4892D4B646B54A9A2A4C6")

    private WindowManager.LayoutParams[] mParams;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.849 -0400", hash_original_method = "3EABCF2A614A6DEC3CA7FC91E47982AB", hash_generated_method = "3EABCF2A614A6DEC3CA7FC91E47982AB")
    public WindowManagerImpl ()
    {
        
    }


    public static WindowManagerImpl getDefault() {
        return sWindowManager;
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    public static WindowManager getDefault(CompatibilityInfoHolder compatInfo) {
        return new CompatModeWrapper(sWindowManager, compatInfo);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.850 -0400", hash_original_method = "8E464E19F5A7F279FF3FC1B84D15C4F0", hash_generated_method = "CC9D2C7C6BB8ABB40E344098164EA10E")
    public boolean isHardwareAccelerated() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1746528618 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1746528618;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.850 -0400", hash_original_method = "3A47767500C080C4B7D3F95A5195D385", hash_generated_method = "FB36DAEAEF4BD4BF826A1D9BA1F1967F")
    public void addView(View view) {
        addView(view, new WindowManager.LayoutParams(
            WindowManager.LayoutParams.TYPE_APPLICATION, 0, PixelFormat.OPAQUE));
        addTaint(view.getTaint());
        
        
            
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.850 -0400", hash_original_method = "133D7EA484587CEAA64BDEB4AE9186C6", hash_generated_method = "6ABA7112A4C93E29505A413988B87F07")
    public void addView(View view, ViewGroup.LayoutParams params) {
        addView(view, params, null, false);
        addTaint(view.getTaint());
        addTaint(params.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.851 -0400", hash_original_method = "6E55E902889BC8630B8C2A4EBA8587B9", hash_generated_method = "1F723570A1FA0A7AA86EFF9BE1B343FE")
    public void addView(View view, ViewGroup.LayoutParams params, CompatibilityInfoHolder cih) {
        addView(view, params, cih, false);
        addTaint(view.getTaint());
        addTaint(params.getTaint());
        addTaint(cih.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.853 -0400", hash_original_method = "FC07162832A382775417964F34DC350F", hash_generated_method = "A0F23534CCD563B3DBE482ECBD8210F6")
    private void addView(View view, ViewGroup.LayoutParams params,
            CompatibilityInfoHolder cih, boolean nest) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                    "Params must be WindowManager.LayoutParams");
        } 
        final WindowManager.LayoutParams wparams = (WindowManager.LayoutParams)params;
        ViewRootImpl root;
        View panelParentView = null;
        {
            int index = findViewLocked(view, false);
            {
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("View " + view
                            + " has already been added to the window manager.");
                } 
                root = mRoots[index];
                view.setLayoutParams(wparams);
                root.setLayoutParams(wparams, true);
            } 
            {
                int count;
                count = mViews.length;
                count = 0;
                {
                    int i = 0;
                    {
                        {
                            boolean var1D105CECC30286641BD50965ABC9FB7E_530966152 = (mRoots[i].mWindow.asBinder() == wparams.token);
                            {
                                panelParentView = mViews[i];
                            } 
                        } 
                    } 
                } 
            } 
            root = new ViewRootImpl(view.getContext());
            root.mAddNesting = 1;
            {
                root.mCompatibilityInfo = new CompatibilityInfoHolder();
            } 
            {
                root.mCompatibilityInfo = cih;
            } 
            view.setLayoutParams(wparams);
            {
                index = 1;
                mViews = new View[1];
                mRoots = new ViewRootImpl[1];
                mParams = new WindowManager.LayoutParams[1];
            } 
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
            } 
            mViews[index] = view;
            mRoots[index] = root;
            mParams[index] = wparams;
        } 
        root.setView(view, wparams, panelParentView);
        addTaint(params.getTaint());
        addTaint(cih.getTaint());
        addTaint(nest);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.853 -0400", hash_original_method = "ED95BEACF52CBB6AE255A4987CA1BF10", hash_generated_method = "8FACFF199B2844B9CCAD33FFEBE16E6C")
    public void updateViewLayout(View view, ViewGroup.LayoutParams params) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Params must be WindowManager.LayoutParams");
        } 
        final WindowManager.LayoutParams wparams = (WindowManager.LayoutParams)params;
        view.setLayoutParams(wparams);
        {
            int index = findViewLocked(view, true);
            ViewRootImpl root = mRoots[index];
            mParams[index] = wparams;
            root.setLayoutParams(wparams, false);
        } 
        addTaint(view.getTaint());
        addTaint(params.getTaint());
        
        
            
        
        
                
        
        
            
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.854 -0400", hash_original_method = "6ED1D335390D20FBE30CC53F4D61DE9F", hash_generated_method = "B1EDC57DD3FDFEA758B63C7137E7D6BC")
    public void removeView(View view) {
        {
            int index = findViewLocked(view, true);
            View curView = removeViewLocked(index);
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Calling with view " + view
                    + " but the ViewAncestor is attached to " + curView);
        } 
        addTaint(view.getTaint());
        
        
            
            
            
                
            
            
                    
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.854 -0400", hash_original_method = "EE35B3CBE21A32408B24AA67A208567E", hash_generated_method = "CEB450CBC55C2C8F5AD40E50A6056C23")
    public void removeViewImmediate(View view) {
        {
            int index = findViewLocked(view, true);
            ViewRootImpl root = mRoots[index];
            View curView = root.getView();
            root.mAddNesting = 0;
            root.die(true);
            finishRemoveViewLocked(curView, index);
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Calling with view " + view
                    + " but the ViewAncestor is attached to " + curView);
        } 
        addTaint(view.getTaint());
        
        
            
            
            
            
            
            
            
                
            
            
                    
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.855 -0400", hash_original_method = "45C6626A33F0E52A8F561F8DE7007122", hash_generated_method = "726B5C6B11BE136B628B23278D1804DF")
     View removeViewLocked(int index) {
        View varB4EAC82CA7396A68D541C85D26508E83_1554160997 = null; 
        View varB4EAC82CA7396A68D541C85D26508E83_1174131886 = null; 
        ViewRootImpl root = mRoots[index];
        View view = root.getView();
        {
            varB4EAC82CA7396A68D541C85D26508E83_1554160997 = view;
        } 
        {
            InputMethodManager imm = InputMethodManager.getInstance(view.getContext());
            {
                imm.windowDismissed(mViews[index].getWindowToken());
            } 
        } 
        root.die(false);
        finishRemoveViewLocked(view, index);
        varB4EAC82CA7396A68D541C85D26508E83_1174131886 = view;
        addTaint(index);
        View varA7E53CE21691AB073D9660D615818899_785770338; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_785770338 = varB4EAC82CA7396A68D541C85D26508E83_1554160997;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_785770338 = varB4EAC82CA7396A68D541C85D26508E83_1174131886;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_785770338.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_785770338;
        
        
        
        
        
            
        
        
            
            
                
            
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.856 -0400", hash_original_method = "4A1C8F1E2D0E07B0DD1B6F93F46E614A", hash_generated_method = "A593F49C9E2F37FE307644C92C6AA540")
     void finishRemoveViewLocked(View view, int index) {
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
        {
            view.assignParent(null);
        } 
        addTaint(view.getTaint());
        addTaint(index);
        
        
        
        
        
        
        
        
        
                
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.857 -0400", hash_original_method = "235A702EEE225FF475D5967A0654B4AA", hash_generated_method = "CADD3A825958ABFDBC2021F66E32D2FC")
    public void closeAll(IBinder token, String who, String what) {
        {
            int count = mViews.length;
            {
                int i = 0;
                {
                    {
                        ViewRootImpl root = mRoots[i];
                        root.mAddNesting = 1;
                        {
                            WindowLeaked leak = new WindowLeaked(
                                what + " " + who + " has leaked window "
                                + root.getView() + " that was originally added here");
                            leak.setStackTrace(root.getLocation().getStackTrace());
                        } 
                        removeViewLocked(i);
                    } 
                } 
            } 
        } 
        addTaint(token.getTaint());
        addTaint(who.getTaint());
        addTaint(what.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.857 -0400", hash_original_method = "1760CCD9A30F61845B0A646D5EFB7F37", hash_generated_method = "AC4B9DDC6504CE3CC4921439ED946D4A")
    public void trimMemory(int level) {
        {
            boolean varC5B5975D48585E4D1B9A993F5AABAEDD_858206903 = (HardwareRenderer.isAvailable());
            {
                
                {
                    boolean var08753D6884B6AA0740247389AD694E8A_801035523 = (!ActivityManager.isHighEndGfx(getDefaultDisplay()));
                    {
                        HardwareRenderer.trimMemory(ComponentCallbacks2.TRIM_MEMORY_COMPLETE);
                        {
                            int count = mViews.length;
                            {
                                int i = 0;
                                {
                                    mRoots[i].terminateHardwareResources();
                                } 
                            } 
                        } 
                        ManagedEGLContext.doTerminate();
                    } 
                } 
                
                
                HardwareRenderer.trimMemory(level);
                
            } 
        } 
        addTaint(level);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.858 -0400", hash_original_method = "B85ACF4E2D1A27D42C4275E82179233A", hash_generated_method = "494BE0E5A83140510E707DE870149E0F")
    public void trimLocalMemory() {
        {
            int count = mViews.length;
            {
                int i = 0;
                {
                    mRoots[i].destroyHardwareLayers();
                } 
            } 
        } 
        
        
            
            
            
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.858 -0400", hash_original_method = "8E8B6C2ACDFF2687F40321E0E64E3BBE", hash_generated_method = "749DA15388C23D045CF572893E36C2B3")
    public void dumpGfxInfo(FileDescriptor fd) {
        FileOutputStream fout = new FileOutputStream(fd);
        PrintWriter pw = new PrintWriter(fout);
        try 
        {
            {
                {
                    pw.println("View hierarchy:");
                    final int count = mViews.length;
                    int viewsCount = 0;
                    int displayListsSize = 0;
                    int[] info = new int[2];
                    {
                        int i = 0;
                        {
                            ViewRootImpl root = mRoots[i];
                            root.dumpGfxInfo(pw, info);
                            String name = root.getClass().getName() + '@' +
                                Integer.toHexString(hashCode());
                            pw.printf("  %s: %d views, %.2f kB (display lists)\n",
                                name, info[0], info[1] / 1024.0f);
                            viewsCount += info[0];
                            displayListsSize += info[1];
                        } 
                    } 
                    pw.printf("\nTotal ViewRootImpl: %d\n", count);
                    pw.printf("Total Views:        %d\n", viewsCount);
                    pw.printf("Total DisplayList:  %.2f kB\n\n", displayListsSize / 1024.0f);
                } 
            } 
        } 
        finally 
        {
            pw.flush();
        } 
        addTaint(fd.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.859 -0400", hash_original_method = "32E6F8530311607C65FF5EAF5F0BD6AD", hash_generated_method = "6CF92D15E6A5CC2185F6954A5D715840")
    public void setStoppedState(IBinder token, boolean stopped) {
        {
            int count = mViews.length;
            {
                int i = 0;
                {
                    {
                        ViewRootImpl root = mRoots[i];
                        root.setStopped(stopped);
                    } 
                } 
            } 
        } 
        addTaint(token.getTaint());
        addTaint(stopped);
        
        
            
                
            
            
                
                    
                    
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.859 -0400", hash_original_method = "5FCDC552B8E05196F9C2F723B4C31106", hash_generated_method = "2C335A679A688DD1C55792C245024F58")
    public void reportNewConfiguration(Configuration config) {
        {
            int count = mViews.length;
            config = new Configuration(config);
            {
                int i = 0;
                {
                    ViewRootImpl root = mRoots[i];
                    root.requestUpdateConfiguration(config);
                } 
            } 
        } 
        addTaint(config.getTaint());
        
        
            
            
            
                
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.860 -0400", hash_original_method = "1CFBFD36B7BEFA0EB1A8D0118BDA1924", hash_generated_method = "18FCB80A34F022CC2F23F4470C94D9E2")
    public WindowManager.LayoutParams getRootViewLayoutParameter(View view) {
        WindowManager.LayoutParams varB4EAC82CA7396A68D541C85D26508E83_576972891 = null; 
        WindowManager.LayoutParams varB4EAC82CA7396A68D541C85D26508E83_1459241458 = null; 
        WindowManager.LayoutParams varB4EAC82CA7396A68D541C85D26508E83_1852321614 = null; 
        ViewParent vp = view.getParent();
        {
            vp = vp.getParent();
        } 
        varB4EAC82CA7396A68D541C85D26508E83_576972891 = null;
        ViewRootImpl vr = (ViewRootImpl)vp;
        int N = mRoots.length;
        {
            int i = 0;
            {
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1459241458 = mParams[i];
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1852321614 = null;
        addTaint(view.getTaint());
        WindowManager.LayoutParams varA7E53CE21691AB073D9660D615818899_1207657399; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1207657399 = varB4EAC82CA7396A68D541C85D26508E83_576972891;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1207657399 = varB4EAC82CA7396A68D541C85D26508E83_1459241458;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1207657399 = varB4EAC82CA7396A68D541C85D26508E83_1852321614;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1207657399.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1207657399;
        
        
        
            
        
        
        
        
        
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.860 -0400", hash_original_method = "2D5B77D42F80E7BB97C9217066ACC1E7", hash_generated_method = "910D676C81E32EF366F77F71D3376042")
    public void closeAll() {
        closeAll(null, null, null);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.861 -0400", hash_original_method = "6421FA4950C786DB3C3137628B8417F4", hash_generated_method = "FA3B663AFE320D07F0136FECAF9084F9")
    public Display getDefaultDisplay() {
        Display varB4EAC82CA7396A68D541C85D26508E83_1045634353 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1045634353 = new Display(Display.DEFAULT_DISPLAY, null);
        varB4EAC82CA7396A68D541C85D26508E83_1045634353.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1045634353;
        
        
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.862 -0400", hash_original_method = "D0BCCB21246B97649D4401D223B22EEE", hash_generated_method = "A9D447BCF6A400D460D39392159F70D3")
    private int findViewLocked(View view, boolean required) {
        {
            int count;
            count = mViews.length;
            count = 0;
            {
                int i = 0;
            } 
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                        "View not attached to window manager");
            } 
        } 
        addTaint(view.getTaint());
        addTaint(required);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1201620303 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1201620303;
        
        
            
            
                
                    
                
            
            
                
                        
            
            
        
    }

    
    static class CompatModeWrapper implements WindowManager {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.862 -0400", hash_original_field = "306519E50E3A91B9733D09F5D8EB985C", hash_generated_field = "FEEC7915B51FB12A1344576DA3BE0D25")

        private WindowManagerImpl mWindowManager;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.862 -0400", hash_original_field = "17753C02FDB97D79869D5B96341900F6", hash_generated_field = "C3E7910AA914C8E7E284BFD6C9B88D3E")

        private Display mDefaultDisplay;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.862 -0400", hash_original_field = "27C9B400936470E0D86B9AA2CDF3AED4", hash_generated_field = "01AEB6BE7A1CFB44C6B781D7301EC317")

        private CompatibilityInfoHolder mCompatibilityInfo;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.863 -0400", hash_original_method = "3FF7A4C8C61ABC650A78463DAC06ED7D", hash_generated_method = "CE7D289C63B7CDEFAF189B0FC00F7069")
          CompatModeWrapper(WindowManager wm, CompatibilityInfoHolder ci) {
            mWindowManager = wm instanceof CompatModeWrapper
                    ? ((CompatModeWrapper)wm).mWindowManager : (WindowManagerImpl)wm;
            {
                mDefaultDisplay = mWindowManager.getDefaultDisplay();
            } 
            {
                mDefaultDisplay = Display.createCompatibleDisplay(
                        mWindowManager.getDefaultDisplay().getDisplayId(), ci);
            } 
            mCompatibilityInfo = ci;
            
            
                    
            
                
            
                
                        
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.864 -0400", hash_original_method = "7609871ECBC27319C7927D8EEDE045EA", hash_generated_method = "6CF46C49A000BECDAD4F809B0B9ECA2F")
        @Override
        public void addView(View view, android.view.ViewGroup.LayoutParams params) {
            mWindowManager.addView(view, params, mCompatibilityInfo);
            addTaint(view.getTaint());
            addTaint(params.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.864 -0400", hash_original_method = "919C5545CD5BB1E858D85286FE5FCBED", hash_generated_method = "2FDA020E24C0BC05323CE49786639DBA")
        @Override
        public void updateViewLayout(View view, android.view.ViewGroup.LayoutParams params) {
            mWindowManager.updateViewLayout(view, params);
            addTaint(view.getTaint());
            addTaint(params.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.865 -0400", hash_original_method = "5F05EF082DAFF0E6020E51FDACFCFBF6", hash_generated_method = "F879B490955646FB1E78A7CBF5304684")
        @Override
        public void removeView(View view) {
            mWindowManager.removeView(view);
            addTaint(view.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.866 -0400", hash_original_method = "56BE5D6095195D262FD5BEEEDA100E7B", hash_generated_method = "ED76E5DCDD85DF65ABF6CE491EF4D915")
        @Override
        public Display getDefaultDisplay() {
            Display varB4EAC82CA7396A68D541C85D26508E83_784197259 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_784197259 = mDefaultDisplay;
            varB4EAC82CA7396A68D541C85D26508E83_784197259.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_784197259;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.866 -0400", hash_original_method = "4EE5EB2962C6A561F3596BAB39C4DB7E", hash_generated_method = "2F3DB644C585255B166E384D13DB6E30")
        @Override
        public void removeViewImmediate(View view) {
            mWindowManager.removeViewImmediate(view);
            addTaint(view.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.866 -0400", hash_original_method = "E8FDE829A6ED2289D510D94BC19E7A4F", hash_generated_method = "4498CD2B232F633F722AD51ED6611F37")
        @Override
        public boolean isHardwareAccelerated() {
            boolean var537FD339DB319870C25465E8732CD454_496148669 = (mWindowManager.isHardwareAccelerated());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1118970497 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1118970497;
            
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.866 -0400", hash_original_field = "096BF12F9EBCA28E49706C74E09FD905", hash_generated_field = "BEBDB0C4DE9800D9D6744BC8414EE1E3")

    public static final int RELAYOUT_RES_IN_TOUCH_MODE = 0x1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.866 -0400", hash_original_field = "1B20578EB71512F8EABE8E7F0F7FB607", hash_generated_field = "8F62C3BDE71832A2D68F514201B29E45")

    public static final int RELAYOUT_RES_FIRST_TIME = 0x2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.866 -0400", hash_original_field = "72C941E47F017B452573327573961320", hash_generated_field = "68A8891465BB14EE588048EAE11177B6")

    public static final int RELAYOUT_RES_SURFACE_CHANGED = 0x4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.866 -0400", hash_original_field = "604E01920957E315364B134C955C11F1", hash_generated_field = "3D5DD8B8FA44EAB5D12F636499EC9823")

    public static final int RELAYOUT_INSETS_PENDING = 0x1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.866 -0400", hash_original_field = "32D1EBFCBE50F75F286EA02D4C377D17", hash_generated_field = "174CC84AFA7FFC82F7BCA824DF5DBFB8")

    public static final int RELAYOUT_DEFER_SURFACE_DESTROY = 0x2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.867 -0400", hash_original_field = "FD57D39BAE14DD800BE94CD1FEC2F209", hash_generated_field = "B45631C5AC56ACFEA482DD61E10D666D")

    public static final int ADD_FLAG_APP_VISIBLE = 0x2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.867 -0400", hash_original_field = "1090FF8B24E420D2B55E68C183773C2F", hash_generated_field = "8A0B6E6C40A3B9E8AD1DB662FFBC63B1")

    public static final int ADD_FLAG_IN_TOUCH_MODE = RELAYOUT_RES_IN_TOUCH_MODE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.867 -0400", hash_original_field = "C1D359C476720A1A13CB6DD42DD9927D", hash_generated_field = "896EA10F4EEDBD22866D19F5C37C2883")

    public static final int ADD_OKAY = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.867 -0400", hash_original_field = "B8045D0803B176FA3C49EAD8DDCEE78D", hash_generated_field = "6250BE795ED30E4E71D089144220CBD2")

    public static final int ADD_BAD_APP_TOKEN = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.867 -0400", hash_original_field = "69BCE95D0619221231007FF0223CD5CA", hash_generated_field = "1E507DB8D29AA4E4EB75979C5B513862")

    public static final int ADD_BAD_SUBWINDOW_TOKEN = -2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.867 -0400", hash_original_field = "87D3BDC7125C9B7F3F0C5AAA3081CBEE", hash_generated_field = "CF74437B4ABA6A66CC5F33FAE0469A87")

    public static final int ADD_NOT_APP_TOKEN = -3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.867 -0400", hash_original_field = "83C33948AE1D352A3EB2C666F9FECDC6", hash_generated_field = "25698B4845820B88A430CDDB9E487015")

    public static final int ADD_APP_EXITING = -4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.867 -0400", hash_original_field = "164990C5E8C2ED546F72E8EBB28411DF", hash_generated_field = "3AF2CF38E39266B60A6668C9A516A055")

    public static final int ADD_DUPLICATE_ADD = -5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.867 -0400", hash_original_field = "54E79096188F641E1A287759CF9E265B", hash_generated_field = "D789E72C8CABCD14EC5B0824A2F2FC96")

    public static final int ADD_STARTING_NOT_NEEDED = -6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.867 -0400", hash_original_field = "FA9EC826AD38BA3AD63DC34123C61D1F", hash_generated_field = "EA6A54060B8C4D297CDC8FC5F3153ECE")

    public static final int ADD_MULTIPLE_SINGLETON = -7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.867 -0400", hash_original_field = "B6CCE3C35D140B35BBE6FDBA8B104F1A", hash_generated_field = "8036D9CCA49B1A5D7465CBB746CA2A36")

    public static final int ADD_PERMISSION_DENIED = -8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.867 -0400", hash_original_field = "6FBEC3E7BB69D1E09ECABF075E18871F", hash_generated_field = "E2243BE928463BEF85C2376ED862E621")

    private final static Object sLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.867 -0400", hash_original_field = "83DB86F24D6A373312BF12EDD9A412A6", hash_generated_field = "10062A1B5CD58B2F6E5CDFDBEAFBAC67")

    private final static WindowManagerImpl sWindowManager = new WindowManagerImpl();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.867 -0400", hash_original_field = "75C834DF5CDF76F1FB4C0DD3037986FA", hash_generated_field = "3734D40F2DD976B4882738308BA77A0A")

    private final static HashMap<CompatibilityInfo, WindowManager> sCompatWindowManagers = new HashMap<CompatibilityInfo, WindowManager>();
}

