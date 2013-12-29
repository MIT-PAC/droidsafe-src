package android.view;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.HashMap;

import android.app.ActivityManager;
import android.content.ComponentCallbacks2;
import android.content.res.CompatibilityInfo;
import android.content.res.Configuration;
import android.graphics.PixelFormat;
import android.opengl.ManagedEGLContext;
import android.os.IBinder;
import android.util.AndroidRuntimeException;
import android.view.inputmethod.InputMethodManager;





final class WindowLeaked extends AndroidRuntimeException {
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:11.168 -0500", hash_original_method = "FBED2002249AD131D5B5A71E6D66FC21", hash_generated_method = "830B11ED5FB821F5D9E7920CDFE106DD")
    public WindowLeaked(String msg) {
        super(msg);
    }

    
}

public class WindowManagerImpl implements WindowManager {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:11.199 -0500", hash_original_method = "6056338BA32AC2029F584B08E7B10209", hash_generated_method = "5C0A30247B54DE424037614F0028A70B")
    public static WindowManagerImpl getDefault() {
        return sWindowManager;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:11.200 -0500", hash_original_method = "70D6D45704A8FE98C4094D46BFDD6193", hash_generated_method = "5724AA55291B510EDA88BE9C80EE771A")
    public static WindowManager getDefault(CompatibilityInfo compatInfo) {
        CompatibilityInfoHolder cih = new CompatibilityInfoHolder();
        cih.set(compatInfo);
        if (cih.getIfNeeded() == null) {
            return sWindowManager;
        }

        synchronized (sLock) {
            // NOTE: It would be cleaner to move the implementation of
            // WindowManagerImpl into a static inner class, and have this
            // public impl just call into that.  Then we can make multiple
            // instances of WindowManagerImpl for compat mode rather than
            // having to make wrappers.
            WindowManager wm = sCompatWindowManagers.get(compatInfo);
            if (wm == null) {
                wm = new CompatModeWrapper(sWindowManager, cih);
                sCompatWindowManagers.put(compatInfo, wm);
            }
            return wm;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:11.201 -0500", hash_original_method = "74A7729D7227AC3DCFFF56714E741835", hash_generated_method = "8A1C0ADF5A068CED18A7AFDCCEF3258C")
    public static WindowManager getDefault(CompatibilityInfoHolder compatInfo) {
        return new CompatModeWrapper(sWindowManager, compatInfo);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:11.220 -0500", hash_original_method = "5920761E6519D7DF42289A49318C9DD3", hash_generated_method = "39BA323056CD4B7A0D72C53C01F90DC8")
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:11.170 -0500", hash_original_field = "4269894CE09B7EE2718F6ECC34C2899F", hash_generated_field = "BEBDB0C4DE9800D9D6744BC8414EE1E3")

    public static final int RELAYOUT_RES_IN_TOUCH_MODE = 0x1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:11.171 -0500", hash_original_field = "E45AF500FA3139EC2BE33A3A7B1DD347", hash_generated_field = "8F62C3BDE71832A2D68F514201B29E45")

    public static final int RELAYOUT_RES_FIRST_TIME = 0x2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:11.172 -0500", hash_original_field = "F8AA97960774D0E9F07D409D00CBC3E2", hash_generated_field = "68A8891465BB14EE588048EAE11177B6")

    public static final int RELAYOUT_RES_SURFACE_CHANGED = 0x4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:11.173 -0500", hash_original_field = "0495A148199C13B79DE2E50351E9AC35", hash_generated_field = "3D5DD8B8FA44EAB5D12F636499EC9823")

    public static final int RELAYOUT_INSETS_PENDING = 0x1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:11.174 -0500", hash_original_field = "69C0C5788E21A1D54FF36E05A0506C99", hash_generated_field = "174CC84AFA7FFC82F7BCA824DF5DBFB8")

    public static final int RELAYOUT_DEFER_SURFACE_DESTROY = 0x2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:11.175 -0500", hash_original_field = "0CFACF22970D191BCB21169100F5D15E", hash_generated_field = "B45631C5AC56ACFEA482DD61E10D666D")


    public static final int ADD_FLAG_APP_VISIBLE = 0x2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:11.176 -0500", hash_original_field = "8838A5EA7ED708E3F408AA6098D8F6B7", hash_generated_field = "8A0B6E6C40A3B9E8AD1DB662FFBC63B1")

    public static final int ADD_FLAG_IN_TOUCH_MODE = RELAYOUT_RES_IN_TOUCH_MODE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:11.176 -0500", hash_original_field = "F54BEAEA8693DF3096867F943C44D409", hash_generated_field = "896EA10F4EEDBD22866D19F5C37C2883")

    
    public static final int ADD_OKAY = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:11.177 -0500", hash_original_field = "C1A541FDB6D2723765EEAFA6363D7E92", hash_generated_field = "6250BE795ED30E4E71D089144220CBD2")

    public static final int ADD_BAD_APP_TOKEN = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:11.178 -0500", hash_original_field = "DE85EFC1B079855201B3C41C9353F518", hash_generated_field = "1E507DB8D29AA4E4EB75979C5B513862")

    public static final int ADD_BAD_SUBWINDOW_TOKEN = -2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:11.179 -0500", hash_original_field = "BFD00ACB6CA8F2241D313364A7BDF74C", hash_generated_field = "CF74437B4ABA6A66CC5F33FAE0469A87")

    public static final int ADD_NOT_APP_TOKEN = -3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:11.180 -0500", hash_original_field = "423C5D7328D934B7273EF8B2F56CA907", hash_generated_field = "25698B4845820B88A430CDDB9E487015")

    public static final int ADD_APP_EXITING = -4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:11.181 -0500", hash_original_field = "093BDFC201584B746B1ED5019DAE39EA", hash_generated_field = "3AF2CF38E39266B60A6668C9A516A055")

    public static final int ADD_DUPLICATE_ADD = -5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:11.181 -0500", hash_original_field = "CBCBC0ACA989196197FCEE842453FE64", hash_generated_field = "D789E72C8CABCD14EC5B0824A2F2FC96")

    public static final int ADD_STARTING_NOT_NEEDED = -6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:11.182 -0500", hash_original_field = "7A2B31833C2D4EF54FD8EED1A1626B8B", hash_generated_field = "EA6A54060B8C4D297CDC8FC5F3153ECE")

    public static final int ADD_MULTIPLE_SINGLETON = -7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:11.183 -0500", hash_original_field = "35C668061AD89A5C68BF3DB99037434F", hash_generated_field = "8036D9CCA49B1A5D7465CBB746CA2A36")

    public static final int ADD_PERMISSION_DENIED = -8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:11.186 -0500", hash_original_field = "3892ABA92B7F95295E8CFDAE8B79791E", hash_generated_field = "E2243BE928463BEF85C2376ED862E621")


    private final static Object sLock = new Object();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:11.187 -0500", hash_original_field = "F1B7BA8178E5CA21AB5A1E0258E9192B", hash_generated_field = "10062A1B5CD58B2F6E5CDFDBEAFBAC67")

    private final static WindowManagerImpl sWindowManager = new WindowManagerImpl();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:11.188 -0500", hash_original_field = "10D8D03F5EB9ED9A7DB4F5A0598ED527", hash_generated_field = "3734D40F2DD976B4882738308BA77A0A")

    private final static HashMap<CompatibilityInfo, WindowManager> sCompatWindowManagers
            = new HashMap<CompatibilityInfo, WindowManager>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:11.184 -0500", hash_original_field = "F653BEF3062CF973255D51C73BCC91D9", hash_generated_field = "1FE8B5AC02273EF00EC01B5EE801E265")


    private View[] mViews;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:11.185 -0500", hash_original_field = "94B18263C4967BF3B4379953F9F41DF0", hash_generated_field = "30F0340706746C5BEBF7EDA66601F6B0")

    private ViewRootImpl[] mRoots;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:11.185 -0500", hash_original_field = "F3BE1F808E115B84F32E210E2B76AD33", hash_generated_field = "CD18B20CABA4892D4B646B54A9A2A4C6")

    private WindowManager.LayoutParams[] mParams;
    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.125 -0400", hash_original_method = "3EABCF2A614A6DEC3CA7FC91E47982AB", hash_generated_method = "3EABCF2A614A6DEC3CA7FC91E47982AB")
    public WindowManagerImpl ()
    {
        //Synthesized constructor
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:11.202 -0500", hash_original_method = "8E464E19F5A7F279FF3FC1B84D15C4F0", hash_generated_method = "3C7366855ACB2D093DD423127CC059B2")
    public boolean isHardwareAccelerated() {
        return false;
    }

    
    static class CompatModeWrapper implements WindowManager {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:11.189 -0500", hash_original_field = "F54741003F12DD1175C61A4A42BE2E67", hash_generated_field = "FEEC7915B51FB12A1344576DA3BE0D25")

        private  WindowManagerImpl mWindowManager;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:11.190 -0500", hash_original_field = "5DE232E35FCEBF071BC0A93A0BEE258D", hash_generated_field = "C3E7910AA914C8E7E284BFD6C9B88D3E")

        private  Display mDefaultDisplay;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:11.191 -0500", hash_original_field = "5EAC126C193FC41ACB184C1D10F2C250", hash_generated_field = "01AEB6BE7A1CFB44C6B781D7301EC317")

        private  CompatibilityInfoHolder mCompatibilityInfo;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:11.192 -0500", hash_original_method = "3FF7A4C8C61ABC650A78463DAC06ED7D", hash_generated_method = "813B6529F336F81C5261E1486E6D12A4")
        CompatModeWrapper(WindowManager wm, CompatibilityInfoHolder ci) {
            mWindowManager = wm instanceof CompatModeWrapper
                    ? ((CompatModeWrapper)wm).mWindowManager : (WindowManagerImpl)wm;

            // Use the original display if there is no compatibility mode
            // to apply, or the underlying window manager is already a
            // compatibility mode wrapper.  (We assume that if it is a
            // wrapper, it is applying the same compatibility mode.)
            if (ci == null) {
                mDefaultDisplay = mWindowManager.getDefaultDisplay();
            } else {
                //mDefaultDisplay = mWindowManager.getDefaultDisplay();
                mDefaultDisplay = Display.createCompatibleDisplay(
                        mWindowManager.getDefaultDisplay().getDisplayId(), ci);
            }

            mCompatibilityInfo = ci;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:11.193 -0500", hash_original_method = "7609871ECBC27319C7927D8EEDE045EA", hash_generated_method = "59B7CCFC44E9F9537209D07193279B67")
        @Override
public void addView(View view, android.view.ViewGroup.LayoutParams params) {
            mWindowManager.addView(view, params, mCompatibilityInfo);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:11.194 -0500", hash_original_method = "919C5545CD5BB1E858D85286FE5FCBED", hash_generated_method = "337942A79A23E7E7E090DB8800F772ED")
        @Override
public void updateViewLayout(View view, android.view.ViewGroup.LayoutParams params) {
            mWindowManager.updateViewLayout(view, params);

        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:11.195 -0500", hash_original_method = "5F05EF082DAFF0E6020E51FDACFCFBF6", hash_generated_method = "17E49B7305C00113E27E42BB2607EBA3")
        @Override
public void removeView(View view) {
            mWindowManager.removeView(view);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:11.195 -0500", hash_original_method = "56BE5D6095195D262FD5BEEEDA100E7B", hash_generated_method = "13280130247B522F41388A5F19B5ED2A")
        @Override
public Display getDefaultDisplay() {
            return mDefaultDisplay;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:11.196 -0500", hash_original_method = "4EE5EB2962C6A561F3596BAB39C4DB7E", hash_generated_method = "1077F3DE929C28B0CF02337C9F9B8B4D")
        @Override
public void removeViewImmediate(View view) {
            mWindowManager.removeViewImmediate(view);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:11.197 -0500", hash_original_method = "E8FDE829A6ED2289D510D94BC19E7A4F", hash_generated_method = "90872E8CF7A0107EF31A3CCA8BDA6BEB")
        @Override
public boolean isHardwareAccelerated() {
            return mWindowManager.isHardwareAccelerated();
        }

        
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:11.203 -0500", hash_original_method = "3A47767500C080C4B7D3F95A5195D385", hash_generated_method = "F22E3DE9CC62087BE72CB136222C6BE6")
    public void addView(View view) {
        addView(view, new WindowManager.LayoutParams(
            WindowManager.LayoutParams.TYPE_APPLICATION, 0, PixelFormat.OPAQUE));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:11.203 -0500", hash_original_method = "133D7EA484587CEAA64BDEB4AE9186C6", hash_generated_method = "A62741000A341E18B97847A5EADB8D70")
    public void addView(View view, ViewGroup.LayoutParams params) {
        addView(view, params, null, false);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:11.204 -0500", hash_original_method = "6E55E902889BC8630B8C2A4EBA8587B9", hash_generated_method = "D83261CDC8E50232C364B0AA8880E61C")
    public void addView(View view, ViewGroup.LayoutParams params, CompatibilityInfoHolder cih) {
        addView(view, params, cih, false);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:11.205 -0500", hash_original_method = "FC07162832A382775417964F34DC350F", hash_generated_method = "E5462A6FDB7A4C6BA026203F5468746C")
    private void addView(View view, ViewGroup.LayoutParams params,
            CompatibilityInfoHolder cih, boolean nest) {
        if (false) Log.v("WindowManager", "addView view=" + view);

        if (!(params instanceof WindowManager.LayoutParams)) {
            throw new IllegalArgumentException(
                    "Params must be WindowManager.LayoutParams");
        }

        final WindowManager.LayoutParams wparams
                = (WindowManager.LayoutParams)params;
        
        ViewRootImpl root;
        View panelParentView = null;
        
        synchronized (this) {
            // Here's an odd/questionable case: if someone tries to add a
            // view multiple times, then we simply bump up a nesting count
            // and they need to remove the view the corresponding number of
            // times to have it actually removed from the window manager.
            // This is useful specifically for the notification manager,
            // which can continually add/remove the same view as a
            // notification gets updated.
            int index = findViewLocked(view, false);
            if (index >= 0) {
                if (!nest) {
                    throw new IllegalStateException("View " + view
                            + " has already been added to the window manager.");
                }
                root = mRoots[index];
                root.mAddNesting++;
                // Update layout parameters.
                view.setLayoutParams(wparams);
                root.setLayoutParams(wparams, true);
                return;
            }
            
            // If this is a panel window, then find the window it is being
            // attached to for future reference.
            if (wparams.type >= WindowManager.LayoutParams.FIRST_SUB_WINDOW &&
                    wparams.type <= WindowManager.LayoutParams.LAST_SUB_WINDOW) {
                final int count = mViews != null ? mViews.length : 0;
                for (int i=0; i<count; i++) {
                    if (mRoots[i].mWindow.asBinder() == wparams.token) {
                        panelParentView = mViews[i];
                    }
                }
            }
            
            root = new ViewRootImpl(view.getContext());
            root.mAddNesting = 1;
            if (cih == null) {
                root.mCompatibilityInfo = new CompatibilityInfoHolder();
            } else {
                root.mCompatibilityInfo = cih;
            }

            view.setLayoutParams(wparams);
            
            if (mViews == null) {
                index = 1;
                mViews = new View[1];
                mRoots = new ViewRootImpl[1];
                mParams = new WindowManager.LayoutParams[1];
            } else {
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
            index--;

            mViews[index] = view;
            mRoots[index] = root;
            mParams[index] = wparams;
        }
        // do this last because it fires off messages to start doing things
        root.setView(view, wparams, panelParentView);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:11.206 -0500", hash_original_method = "ED95BEACF52CBB6AE255A4987CA1BF10", hash_generated_method = "4F30676E8293DE94A18B4EB1861C0C85")
    public void updateViewLayout(View view, ViewGroup.LayoutParams params) {
        if (!(params instanceof WindowManager.LayoutParams)) {
            throw new IllegalArgumentException("Params must be WindowManager.LayoutParams");
        }

        final WindowManager.LayoutParams wparams
                = (WindowManager.LayoutParams)params;
        
        view.setLayoutParams(wparams);

        synchronized (this) {
            int index = findViewLocked(view, true);
            ViewRootImpl root = mRoots[index];
            mParams[index] = wparams;
            root.setLayoutParams(wparams, false);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:11.207 -0500", hash_original_method = "6ED1D335390D20FBE30CC53F4D61DE9F", hash_generated_method = "97555D333EA1C440F3216E288199576F")
    public void removeView(View view) {
        synchronized (this) {
            int index = findViewLocked(view, true);
            View curView = removeViewLocked(index);
            if (curView == view) {
                return;
            }
            
            throw new IllegalStateException("Calling with view " + view
                    + " but the ViewAncestor is attached to " + curView);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:11.208 -0500", hash_original_method = "EE35B3CBE21A32408B24AA67A208567E", hash_generated_method = "1B701F99C123B88F26A7AD9EF3F5188D")
    public void removeViewImmediate(View view) {
        synchronized (this) {
            int index = findViewLocked(view, true);
            ViewRootImpl root = mRoots[index];
            View curView = root.getView();
            
            root.mAddNesting = 0;
            root.die(true);
            finishRemoveViewLocked(curView, index);
            if (curView == view) {
                return;
            }
            
            throw new IllegalStateException("Calling with view " + view
                    + " but the ViewAncestor is attached to " + curView);
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:11.209 -0500", hash_original_method = "45C6626A33F0E52A8F561F8DE7007122", hash_generated_method = "A76FF12A2F6862507082FE1574ED057D")
    View removeViewLocked(int index) {
        ViewRootImpl root = mRoots[index];
        View view = root.getView();
        
        // Don't really remove until we have matched all calls to add().
        root.mAddNesting--;
        if (root.mAddNesting > 0) {
            return view;
        }

        if (view != null) {
            InputMethodManager imm = InputMethodManager.getInstance(view.getContext());
            if (imm != null) {
                imm.windowDismissed(mViews[index].getWindowToken());
            }
        }
        root.die(false);
        finishRemoveViewLocked(view, index);
        return view;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:11.210 -0500", hash_original_method = "4A1C8F1E2D0E07B0DD1B6F93F46E614A", hash_generated_method = "EF5E088EC9F28E823CDD2320368DAAD2")
    void finishRemoveViewLocked(View view, int index) {
        final int count = mViews.length;

        // remove it from the list
        View[] tmpViews = new View[count-1];
        removeItem(tmpViews, mViews, index);
        mViews = tmpViews;
        
        ViewRootImpl[] tmpRoots = new ViewRootImpl[count-1];
        removeItem(tmpRoots, mRoots, index);
        mRoots = tmpRoots;
        
        WindowManager.LayoutParams[] tmpParams
                = new WindowManager.LayoutParams[count-1];
        removeItem(tmpParams, mParams, index);
        mParams = tmpParams;

        if (view != null) {
            view.assignParent(null);
            // func doesn't allow null...  does it matter if we clear them?
            //view.setLayoutParams(null);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:11.211 -0500", hash_original_method = "235A702EEE225FF475D5967A0654B4AA", hash_generated_method = "458CF45C9E0769AFCD86661B2948915F")
    public void closeAll(IBinder token, String who, String what) {
        synchronized (this) {
            if (mViews == null)
                return;
            
            int count = mViews.length;
            //Log.i("foo", "Closing all windows of " + token);
            for (int i=0; i<count; i++) {
                //Log.i("foo", "@ " + i + " token " + mParams[i].token
                //        + " view " + mRoots[i].getView());
                if (token == null || mParams[i].token == token) {
                    ViewRootImpl root = mRoots[i];
                    root.mAddNesting = 1;
                    
                    //Log.i("foo", "Force closing " + root);
                    if (who != null) {
                        WindowLeaked leak = new WindowLeaked(
                                what + " " + who + " has leaked window "
                                + root.getView() + " that was originally added here");
                        leak.setStackTrace(root.getLocation().getStackTrace());
                        Log.e("WindowManager", leak.getMessage(), leak);
                    }

                    removeViewLocked(i);
                    i--;
                    count--;
                }
            }
        }
    }

    /**
     * @param level See {@link android.content.ComponentCallbacks}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:11.211 -0500", hash_original_method = "1760CCD9A30F61845B0A646D5EFB7F37", hash_generated_method = "ADDF4804D80457AB526C239C23C5AA6A")
    public void trimMemory(int level) {
        if (HardwareRenderer.isAvailable()) {
            switch (level) {
                case ComponentCallbacks2.TRIM_MEMORY_COMPLETE:
                case ComponentCallbacks2.TRIM_MEMORY_MODERATE:
                    // On low and medium end gfx devices
                    if (!ActivityManager.isHighEndGfx(getDefaultDisplay())) {
                        // Force a full memory flush
                        HardwareRenderer.trimMemory(ComponentCallbacks2.TRIM_MEMORY_COMPLETE);
                        // Destroy all hardware surfaces and resources associated to
                        // known windows
                        synchronized (this) {
                            if (mViews == null) return;
                            int count = mViews.length;
                            for (int i = 0; i < count; i++) {
                                mRoots[i].terminateHardwareResources();
                            }
                        }
                        // Terminate the hardware renderer to free all resources
                        ManagedEGLContext.doTerminate();
                        break;
                    }
                    // high end gfx devices fall through to next case
                default:
                    HardwareRenderer.trimMemory(level);
            }
        }
    }

    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:11.212 -0500", hash_original_method = "B85ACF4E2D1A27D42C4275E82179233A", hash_generated_method = "6E75823DA3ABA67B44F2D4CE14B5A285")
    public void trimLocalMemory() {
        synchronized (this) {
            if (mViews == null) return;
            int count = mViews.length;
            for (int i = 0; i < count; i++) {
                mRoots[i].destroyHardwareLayers();
            }
        }
    }

    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:11.214 -0500", hash_original_method = "8E8B6C2ACDFF2687F40321E0E64E3BBE", hash_generated_method = "6EAD06421A9EDAA77371BBD1BB5E27D6")
    public void dumpGfxInfo(FileDescriptor fd) {
        FileOutputStream fout = new FileOutputStream(fd);
        PrintWriter pw = new PrintWriter(fout);
        try {
            synchronized (this) {
                if (mViews != null) {
                    pw.println("View hierarchy:");

                    final int count = mViews.length;

                    int viewsCount = 0;
                    int displayListsSize = 0;
                    int[] info = new int[2];

                    for (int i = 0; i < count; i++) {
                        ViewRootImpl root = mRoots[i];
                        root.dumpGfxInfo(pw, info);

                        String name = root.getClass().getName() + '@' +
                                Integer.toHexString(hashCode());                        
                        pw.printf("  %s: %d views, %.2f kB (display lists)\n",
                                name, info[0], info[1] / 1024.0f);

                        viewsCount += info[0];
                        displayListsSize += info[1];
                    }

                    pw.printf("\nTotal ViewRootImpl: %d\n", count);
                    pw.printf("Total Views:        %d\n", viewsCount);                    
                    pw.printf("Total DisplayList:  %.2f kB\n\n", displayListsSize / 1024.0f);                    
                }
            }
        } finally {
            pw.flush();
        }        
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:11.215 -0500", hash_original_method = "32E6F8530311607C65FF5EAF5F0BD6AD", hash_generated_method = "8F8BCB60732BC87F86BB96E085092812")
    public void setStoppedState(IBinder token, boolean stopped) {
        synchronized (this) {
            if (mViews == null)
                return;
            int count = mViews.length;
            for (int i=0; i<count; i++) {
                if (token == null || mParams[i].token == token) {
                    ViewRootImpl root = mRoots[i];
                    root.setStopped(stopped);
                }
            }
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:11.216 -0500", hash_original_method = "5FCDC552B8E05196F9C2F723B4C31106", hash_generated_method = "76EC1C71097FC8D1F43A3DB8234D2D35")
    public void reportNewConfiguration(Configuration config) {
        synchronized (this) {
            int count = mViews.length;
            config = new Configuration(config);
            for (int i=0; i<count; i++) {
                ViewRootImpl root = mRoots[i];
                root.requestUpdateConfiguration(config);
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:11.217 -0500", hash_original_method = "1CFBFD36B7BEFA0EB1A8D0118BDA1924", hash_generated_method = "996BE53CB00F4995CDF902776B8DC9CD")
    public WindowManager.LayoutParams getRootViewLayoutParameter(View view) {
        ViewParent vp = view.getParent();
        while (vp != null && !(vp instanceof ViewRootImpl)) {
            vp = vp.getParent();
        }
        
        if (vp == null) return null;
        
        ViewRootImpl vr = (ViewRootImpl)vp;
        
        int N = mRoots.length;
        for (int i = 0; i < N; ++i) {
            if (mRoots[i] == vr) {
                return mParams[i];
            }
        }
        
        return null;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:11.218 -0500", hash_original_method = "2D5B77D42F80E7BB97C9217066ACC1E7", hash_generated_method = "02ED27E9DFB12DD60EF65D4F564F90BD")
    public void closeAll() {
        closeAll(null, null, null);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:11.219 -0500", hash_original_method = "6421FA4950C786DB3C3137628B8417F4", hash_generated_method = "E636F017B2EEA4737868391A38E0EB2C")
    public Display getDefaultDisplay() {
        return new Display(Display.DEFAULT_DISPLAY, null);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:11.221 -0500", hash_original_method = "D0BCCB21246B97649D4401D223B22EEE", hash_generated_method = "B64315874421085921C76F4D7DBD9FAF")
    private int findViewLocked(View view, boolean required) {
        synchronized (this) {
            final int count = mViews != null ? mViews.length : 0;
            for (int i=0; i<count; i++) {
                if (mViews[i] == view) {
                    return i;
                }
            }
            if (required) {
                throw new IllegalArgumentException(
                        "View not attached to window manager");
            }
            return -1;
        }
    }
}

