package com.google.android.gles_jni;

// Droidsafe Imports
import droidsafe.annotations.*;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;




import droidsafe.helpers.DSUtils;

public class EGLImpl implements EGL10 {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.539 -0400", hash_original_field = "0F8898C409B0E41427A2E6AA6C67E1EC", hash_generated_field = "299BB99E9FA7B75F06D17EB158F11EC7")

    private EGLContextImpl mContext = new EGLContextImpl(-1);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.539 -0400", hash_original_field = "A8BAED30807DC75517DDAE7C4EFB1286", hash_generated_field = "66FCEFDB57492E5584274D8BC130FFAD")

    private EGLDisplayImpl mDisplay = new EGLDisplayImpl(-1);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.539 -0400", hash_original_field = "A3FE23ED2289FC865AF994EFF579711B", hash_generated_field = "A9E68FD08AADF48015530582ECAAFB47")

    private EGLSurfaceImpl mSurface = new EGLSurfaceImpl(-1);
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.539 -0400", hash_original_method = "1F432E8932AB5EEB87E85C95C31E8080", hash_generated_method = "1F432E8932AB5EEB87E85C95C31E8080")
    public EGLImpl ()
    {
        //Synthesized constructor
    }


        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.539 -0400", hash_original_method = "0FE9F08E24E0D2453B9577BF62363101", hash_generated_method = "DC88DAA152623980BA0B9B4A28FC1D10")
    public boolean eglInitialize(EGLDisplay display, int[] major_minor) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_596572519 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_596572519;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.540 -0400", hash_original_method = "F079BB68B5D124389F3B0A1B80EDA8E6", hash_generated_method = "8709A69FEF52DE16788611CC56986A89")
    public boolean eglQueryContext(EGLDisplay display, EGLContext context, int attribute, int[] value) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1378734488 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1378734488;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.540 -0400", hash_original_method = "543FE727862E36E7BB38AE92834CF157", hash_generated_method = "9477122C0D578D8A71ED89B974CC7C2A")
    public boolean eglQuerySurface(EGLDisplay display, EGLSurface surface, int attribute, int[] value) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_304198183 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_304198183;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.540 -0400", hash_original_method = "BAFD3BC777B3DA03D70496857F209CFE", hash_generated_method = "0EC4A728353ACC415870E02A1CCB0356")
    public boolean eglReleaseThread() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1992229922 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1992229922;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.541 -0400", hash_original_method = "597806537D1EB9D066DEDBB0F5CABF82", hash_generated_method = "D70B3027C6B014177567E9F56E4ECFA4")
    public boolean eglChooseConfig(EGLDisplay display, int[] attrib_list, EGLConfig[] configs, int config_size, int[] num_config) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1939353405 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1939353405;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.541 -0400", hash_original_method = "CE0C84B918062E5840E34AEA7F4A16CD", hash_generated_method = "5F7CD8069FAF47052DDE1BB7637D86A6")
    public boolean eglGetConfigAttrib(EGLDisplay display, EGLConfig config, int attribute, int[] value) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_592821589 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_592821589;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.541 -0400", hash_original_method = "1FF43B35756785946FBC969447AE4429", hash_generated_method = "3DFE675301A6D24D0D23DEA429FFA2AC")
    public boolean eglGetConfigs(EGLDisplay display, EGLConfig[] configs, int config_size, int[] num_config) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1614626881 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1614626881;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.542 -0400", hash_original_method = "30167F0B844356CC78AEA2C709085F0A", hash_generated_method = "D15E3ED1AA9A52B73A09E95A522E3A35")
    public int eglGetError() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1073910231 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1073910231;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.542 -0400", hash_original_method = "F2C45513A57BFF3B5C76E0152AB1D6FE", hash_generated_method = "273C95BEDDFF24E4946D548E09CDB7A7")
    public boolean eglDestroyContext(EGLDisplay display, EGLContext context) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_643163652 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_643163652;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.542 -0400", hash_original_method = "F8BE74B02C97D5EFE0B64C835DE94243", hash_generated_method = "113C0ABEE6DE898B9C44CAF0657A9B39")
    public boolean eglDestroySurface(EGLDisplay display, EGLSurface surface) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_675526934 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_675526934;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.542 -0400", hash_original_method = "D0A5BC4F7F6AC39FDE4C2E9D6BB5947A", hash_generated_method = "14FB7B6D63ACC3FEA92168551DE8BCE9")
    public boolean eglMakeCurrent(EGLDisplay display, EGLSurface draw, EGLSurface read, EGLContext context) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_632651070 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_632651070;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.388 -0400", hash_original_method = "7F0F6E22A72F3EFD03B53C72B8A334B5", hash_generated_method = "FD75A226178BC0A876B19864D0D93C7A")
    public String eglQueryString(EGLDisplay display, int name) {
    	addTaint(display.getTaint());
    	addTaint(name);
    	String s = new String();
    	s.addTaint(taint);
    	return s;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.543 -0400", hash_original_method = "3CBB90A352CD62A4CE70C5B74A91066B", hash_generated_method = "3D3E101FF6B2780EF9212CCE1CE85160")
    public boolean eglSwapBuffers(EGLDisplay display, EGLSurface surface) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1147753778 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1147753778;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.543 -0400", hash_original_method = "76CDC4A068B49052D1DE694B54AD997D", hash_generated_method = "81DD82917F075E4A6A07968E4DB4388A")
    public boolean eglTerminate(EGLDisplay display) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1449558902 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1449558902;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.543 -0400", hash_original_method = "4BC9AB9F0FAFDEDE82B7BBC20123D960", hash_generated_method = "0256FB6112EEB44808D5C1F72EFFC3D9")
    public boolean eglCopyBuffers(EGLDisplay display, EGLSurface surface, Object native_pixmap) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_806698555 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_806698555;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.544 -0400", hash_original_method = "CC5C6C40253D90C1249B907D63B6D41E", hash_generated_method = "F28B3B7BA9DB872DF78A6DC65847AA61")
    public boolean eglWaitGL() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_422086679 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_422086679;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.544 -0400", hash_original_method = "65BB1CF445260F062394F987EBFCAA01", hash_generated_method = "DC74F3710313A9BCA079E7717D67F4AB")
    public boolean eglWaitNative(int engine, Object bindTarget) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1392677315 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1392677315;
    }

    
    @DSModeled(DSC.SAFE)
    public static int getInitCount(EGLDisplay display) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1163271600 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1163271600;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.545 -0400", hash_original_method = "CAD561FB9C34D7001DB982C1B864CD0D", hash_generated_method = "EADE1173FD1483EBCFC7163F4D51059B")
    public EGLContext eglCreateContext(EGLDisplay display, EGLConfig config, EGLContext share_context, int[] attrib_list) {
        addTaint(attrib_list[0]);
        addTaint(share_context.getTaint());
        addTaint(config.getTaint());
        addTaint(display.getTaint());
        int eglContextId = _eglCreateContext(display, config, share_context, attrib_list);
        if(eglContextId == 0)        
        {
EGLContext var8B12D0F59FFC1F329D044E613B64C886_1518386691 =             EGL10.EGL_NO_CONTEXT;
            var8B12D0F59FFC1F329D044E613B64C886_1518386691.addTaint(taint);
            return var8B12D0F59FFC1F329D044E613B64C886_1518386691;
        } //End block
EGLContext varA69F6A3543095187E8EFF7B289AE5DF0_822119437 =         new EGLContextImpl( eglContextId );
        varA69F6A3543095187E8EFF7B289AE5DF0_822119437.addTaint(taint);
        return varA69F6A3543095187E8EFF7B289AE5DF0_822119437;
        // ---------- Original Method ----------
        //int eglContextId = _eglCreateContext(display, config, share_context, attrib_list);
        //if (eglContextId == 0) {
            //return EGL10.EGL_NO_CONTEXT;
        //}
        //return new EGLContextImpl( eglContextId );
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.545 -0400", hash_original_method = "E59A00AD2A74A21C0F4005F77A95ED7D", hash_generated_method = "579CE2453971529DF0DC8AB75D369B19")
    public EGLSurface eglCreatePbufferSurface(EGLDisplay display, EGLConfig config, int[] attrib_list) {
        addTaint(attrib_list[0]);
        addTaint(config.getTaint());
        addTaint(display.getTaint());
        int eglSurfaceId = _eglCreatePbufferSurface(display, config, attrib_list);
        if(eglSurfaceId == 0)        
        {
EGLSurface var661D124B60BA28C4D2717F54068BA043_310757863 =             EGL10.EGL_NO_SURFACE;
            var661D124B60BA28C4D2717F54068BA043_310757863.addTaint(taint);
            return var661D124B60BA28C4D2717F54068BA043_310757863;
        } //End block
EGLSurface varA54243EB7A45A941A14A628971C01392_1622931390 =         new EGLSurfaceImpl( eglSurfaceId );
        varA54243EB7A45A941A14A628971C01392_1622931390.addTaint(taint);
        return varA54243EB7A45A941A14A628971C01392_1622931390;
        // ---------- Original Method ----------
        //int eglSurfaceId = _eglCreatePbufferSurface(display, config, attrib_list);
        //if (eglSurfaceId == 0) {
            //return EGL10.EGL_NO_SURFACE;
        //}
        //return new EGLSurfaceImpl( eglSurfaceId );
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.546 -0400", hash_original_method = "1913DE6E1812314106CFABA8D0690133", hash_generated_method = "F36E4F4BAE1BF93BFBE82C47C78B27E5")
    public EGLSurface eglCreatePixmapSurface(EGLDisplay display, EGLConfig config, Object native_pixmap, int[] attrib_list) {
        addTaint(attrib_list[0]);
        addTaint(native_pixmap.getTaint());
        addTaint(config.getTaint());
        addTaint(display.getTaint());
        EGLSurfaceImpl sur = new EGLSurfaceImpl();
        _eglCreatePixmapSurface(sur, display, config, native_pixmap, attrib_list);
        if(sur.mEGLSurface == 0)        
        {
EGLSurface var661D124B60BA28C4D2717F54068BA043_2031758053 =             EGL10.EGL_NO_SURFACE;
            var661D124B60BA28C4D2717F54068BA043_2031758053.addTaint(taint);
            return var661D124B60BA28C4D2717F54068BA043_2031758053;
        } //End block
EGLSurface varE2F14575F3D48B3F2E6009886096BF0A_933453191 =         sur;
        varE2F14575F3D48B3F2E6009886096BF0A_933453191.addTaint(taint);
        return varE2F14575F3D48B3F2E6009886096BF0A_933453191;
        // ---------- Original Method ----------
        //EGLSurfaceImpl sur = new EGLSurfaceImpl();
        //_eglCreatePixmapSurface(sur, display, config, native_pixmap, attrib_list);
        //if (sur.mEGLSurface == 0) {
            //return EGL10.EGL_NO_SURFACE;
        //}
        //return sur;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.547 -0400", hash_original_method = "A3C23A2D0F372302CCCB5BF8EDDCD71A", hash_generated_method = "64B53BC3BCB702066BCC21515B17E24F")
    public EGLSurface eglCreateWindowSurface(EGLDisplay display, EGLConfig config, Object native_window, int[] attrib_list) {
        addTaint(attrib_list[0]);
        addTaint(native_window.getTaint());
        addTaint(config.getTaint());
        addTaint(display.getTaint());
        Surface sur = null;
        if(native_window instanceof SurfaceView)        
        {
            SurfaceView surfaceView = (SurfaceView)native_window;
            sur = surfaceView.getHolder().getSurface();
        } //End block
        else
        if(native_window instanceof SurfaceHolder)        
        {
            SurfaceHolder holder = (SurfaceHolder)native_window;
            sur = holder.getSurface();
        } //End block
        int eglSurfaceId;
        if(sur != null)        
        {
            eglSurfaceId = _eglCreateWindowSurface(display, config, sur, attrib_list);
        } //End block
        else
        if(native_window instanceof SurfaceTexture)        
        {
            eglSurfaceId = _eglCreateWindowSurfaceTexture(display, config,
                    native_window, attrib_list);
        } //End block
        else
        {
            java.lang.UnsupportedOperationException varEC76C1F9CF7F752DEE7F1B5E569D82B4_983245639 = new java.lang.UnsupportedOperationException(
                "eglCreateWindowSurface() can only be called with an instance of " +
                "SurfaceView, SurfaceHolder or SurfaceTexture at the moment, " + 
                "this will be fixed later.");
            varEC76C1F9CF7F752DEE7F1B5E569D82B4_983245639.addTaint(taint);
            throw varEC76C1F9CF7F752DEE7F1B5E569D82B4_983245639;
        } //End block
        if(eglSurfaceId == 0)        
        {
EGLSurface var661D124B60BA28C4D2717F54068BA043_1981488518 =             EGL10.EGL_NO_SURFACE;
            var661D124B60BA28C4D2717F54068BA043_1981488518.addTaint(taint);
            return var661D124B60BA28C4D2717F54068BA043_1981488518;
        } //End block
EGLSurface varA54243EB7A45A941A14A628971C01392_1323766675 =         new EGLSurfaceImpl( eglSurfaceId );
        varA54243EB7A45A941A14A628971C01392_1323766675.addTaint(taint);
        return varA54243EB7A45A941A14A628971C01392_1323766675;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.547 -0400", hash_original_method = "BEC2EA85C18256200276555D8D849688", hash_generated_method = "C45BBA32C347BA202D34EF9853B28EDB")
    public synchronized EGLDisplay eglGetDisplay(Object native_display) {
        addTaint(native_display.getTaint());
        int value = _eglGetDisplay(native_display);
        if(value == 0)        
        {
EGLDisplay var5ABDA0E7FAF25206EB507E6EED49A34C_1115556138 =             EGL10.EGL_NO_DISPLAY;
            var5ABDA0E7FAF25206EB507E6EED49A34C_1115556138.addTaint(taint);
            return var5ABDA0E7FAF25206EB507E6EED49A34C_1115556138;
        } //End block
        if(mDisplay.mEGLDisplay != value)        
        mDisplay = new EGLDisplayImpl(value);
EGLDisplay var36FB7BADF2724DB652908D0DF82CB492_172410695 =         mDisplay;
        var36FB7BADF2724DB652908D0DF82CB492_172410695.addTaint(taint);
        return var36FB7BADF2724DB652908D0DF82CB492_172410695;
        // ---------- Original Method ----------
        //int value = _eglGetDisplay(native_display);
        //if (value == 0) {
            //return EGL10.EGL_NO_DISPLAY;
        //}
        //if (mDisplay.mEGLDisplay != value)
            //mDisplay = new EGLDisplayImpl(value);
        //return mDisplay;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.547 -0400", hash_original_method = "36FE38451D664CBAEEF58B0CA2F2C184", hash_generated_method = "F299E629CB341321234E5E891C966E9F")
    public synchronized EGLContext eglGetCurrentContext() {
        int value = _eglGetCurrentContext();
        if(value == 0)        
        {
EGLContext var8B12D0F59FFC1F329D044E613B64C886_1739846192 =             EGL10.EGL_NO_CONTEXT;
            var8B12D0F59FFC1F329D044E613B64C886_1739846192.addTaint(taint);
            return var8B12D0F59FFC1F329D044E613B64C886_1739846192;
        } //End block
        if(mContext.mEGLContext != value)        
        mContext = new EGLContextImpl(value);
EGLContext var178E2AD52D6FBBB503F908168856B574_1773261353 =         mContext;
        var178E2AD52D6FBBB503F908168856B574_1773261353.addTaint(taint);
        return var178E2AD52D6FBBB503F908168856B574_1773261353;
        // ---------- Original Method ----------
        //int value = _eglGetCurrentContext();
        //if (value == 0) {
            //return EGL10.EGL_NO_CONTEXT;
        //}
        //if (mContext.mEGLContext != value)
            //mContext = new EGLContextImpl(value);
        //return mContext;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.548 -0400", hash_original_method = "2AD52C4EA481E23FFE9D610E551D647C", hash_generated_method = "DAAE6D19AAF74F8A24B55FA400DF01E8")
    public synchronized EGLDisplay eglGetCurrentDisplay() {
        int value = _eglGetCurrentDisplay();
        if(value == 0)        
        {
EGLDisplay var5ABDA0E7FAF25206EB507E6EED49A34C_711217779 =             EGL10.EGL_NO_DISPLAY;
            var5ABDA0E7FAF25206EB507E6EED49A34C_711217779.addTaint(taint);
            return var5ABDA0E7FAF25206EB507E6EED49A34C_711217779;
        } //End block
        if(mDisplay.mEGLDisplay != value)        
        mDisplay = new EGLDisplayImpl(value);
EGLDisplay var36FB7BADF2724DB652908D0DF82CB492_523767008 =         mDisplay;
        var36FB7BADF2724DB652908D0DF82CB492_523767008.addTaint(taint);
        return var36FB7BADF2724DB652908D0DF82CB492_523767008;
        // ---------- Original Method ----------
        //int value = _eglGetCurrentDisplay();
        //if (value == 0) {
            //return EGL10.EGL_NO_DISPLAY;
        //}
        //if (mDisplay.mEGLDisplay != value)
            //mDisplay = new EGLDisplayImpl(value);
        //return mDisplay;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.548 -0400", hash_original_method = "1056D87FF6AF8A6633AE7A0382D42E2B", hash_generated_method = "7FF2C0A86DE47A627F287A8BB04231E9")
    public synchronized EGLSurface eglGetCurrentSurface(int readdraw) {
        addTaint(readdraw);
        int value = _eglGetCurrentSurface(readdraw);
        if(value == 0)        
        {
EGLSurface var661D124B60BA28C4D2717F54068BA043_749708546 =             EGL10.EGL_NO_SURFACE;
            var661D124B60BA28C4D2717F54068BA043_749708546.addTaint(taint);
            return var661D124B60BA28C4D2717F54068BA043_749708546;
        } //End block
        if(mSurface.mEGLSurface != value)        
        mSurface = new EGLSurfaceImpl(value);
EGLSurface varB7C98568942B156EFD367CE054011CDA_1972958599 =         mSurface;
        varB7C98568942B156EFD367CE054011CDA_1972958599.addTaint(taint);
        return varB7C98568942B156EFD367CE054011CDA_1972958599;
        // ---------- Original Method ----------
        //int value = _eglGetCurrentSurface(readdraw);
        //if (value == 0) {
            //return EGL10.EGL_NO_SURFACE;
        //}
        //if (mSurface.mEGLSurface != value)
            //mSurface = new EGLSurfaceImpl(value);
        //return mSurface;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.548 -0400", hash_original_method = "00A9769D3FCB2BCA752959A2156960BA", hash_generated_method = "62DB3E7EB1D40911521A9F099FB537AF")
    private int _eglCreateContext(EGLDisplay display, EGLConfig config, EGLContext share_context, int[] attrib_list) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1940036351 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1940036351;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.548 -0400", hash_original_method = "9C66F8DAF2CF1DF35D1777997045841F", hash_generated_method = "5E6E18928FD0A82AF9ED9CECB01BEF21")
    private int _eglCreatePbufferSurface(EGLDisplay display, EGLConfig config, int[] attrib_list) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1738283973 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1738283973;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.548 -0400", hash_original_method = "37A0D40F82301EFE54D93A3E184BD2AE", hash_generated_method = "67B71D5B2B8EA12F14EA13A7D4D22EC8")
    private void _eglCreatePixmapSurface(EGLSurface sur, EGLDisplay display, EGLConfig config, Object native_pixmap, int[] attrib_list) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.548 -0400", hash_original_method = "73053A5CE6D69977C0A5A55B454424E0", hash_generated_method = "B1D0A15C8D61760A2BC99E890B98EF41")
    private int _eglCreateWindowSurface(EGLDisplay display, EGLConfig config, Object native_window, int[] attrib_list) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2105038139 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2105038139;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.548 -0400", hash_original_method = "C683AABBDC194C692A1DD6C73D5E2B96", hash_generated_method = "A43F1D106FEDBB1E0BC52F32213CF01A")
    private int _eglCreateWindowSurfaceTexture(EGLDisplay display, EGLConfig config, Object native_window, int[] attrib_list) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1008675136 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1008675136;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.549 -0400", hash_original_method = "E8D546530FFFC5C2FC6E86FFB85AACEC", hash_generated_method = "EF2C0AEA63D0390479FB38513B170D6A")
    private int _eglGetDisplay(Object native_display) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1012161852 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1012161852;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.549 -0400", hash_original_method = "37AAAAC75A3E4652292E435C97659047", hash_generated_method = "3CFF029235C39A90B5C81775694BD20A")
    private int _eglGetCurrentContext() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1291526126 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1291526126;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.549 -0400", hash_original_method = "AF8954095CE356BE495ED3F59D7027C3", hash_generated_method = "0B974F9961190DD8824DA6A62E8B1686")
    private int _eglGetCurrentDisplay() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_108204541 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_108204541;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.549 -0400", hash_original_method = "9F7D143F548ED01AA850BEE267C7749A", hash_generated_method = "8C4138C4C4DF8571351700EBD2DA27A8")
    private int _eglGetCurrentSurface(int readdraw) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1238912648 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1238912648;
    }

    
    @DSModeled(DSC.SAFE)
    private static void _nativeClassInit() {
    }

    
    static { _nativeClassInit(); }
    
}

