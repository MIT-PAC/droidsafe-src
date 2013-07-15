package com.google.android.gles_jni;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import javax.microedition.khronos.egl.*;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.SurfaceView;
import android.view.SurfaceHolder;

public class EGLImpl implements EGL10 {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.397 -0400", hash_original_field = "0F8898C409B0E41427A2E6AA6C67E1EC", hash_generated_field = "299BB99E9FA7B75F06D17EB158F11EC7")

    private EGLContextImpl mContext = new EGLContextImpl(-1);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.397 -0400", hash_original_field = "A8BAED30807DC75517DDAE7C4EFB1286", hash_generated_field = "66FCEFDB57492E5584274D8BC130FFAD")

    private EGLDisplayImpl mDisplay = new EGLDisplayImpl(-1);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.397 -0400", hash_original_field = "A3FE23ED2289FC865AF994EFF579711B", hash_generated_field = "A9E68FD08AADF48015530582ECAAFB47")

    private EGLSurfaceImpl mSurface = new EGLSurfaceImpl(-1);
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.397 -0400", hash_original_method = "1F432E8932AB5EEB87E85C95C31E8080", hash_generated_method = "1F432E8932AB5EEB87E85C95C31E8080")
    public EGLImpl ()
    {
        //Synthesized constructor
    }


    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.397 -0400", hash_original_method = "0FE9F08E24E0D2453B9577BF62363101", hash_generated_method = "71EB9409B8C4EDB1724425BAFC0AC819")
    public boolean eglInitialize(EGLDisplay display, int[] major_minor) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1778312590 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1778312590;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.398 -0400", hash_original_method = "F079BB68B5D124389F3B0A1B80EDA8E6", hash_generated_method = "B9DAD9EA0E386095442DD1960EB424A5")
    public boolean eglQueryContext(EGLDisplay display, EGLContext context, int attribute, int[] value) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1158195762 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1158195762;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.398 -0400", hash_original_method = "543FE727862E36E7BB38AE92834CF157", hash_generated_method = "4FB230409C26D73D5AA15EC3706F6B0E")
    public boolean eglQuerySurface(EGLDisplay display, EGLSurface surface, int attribute, int[] value) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_308368316 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_308368316;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.398 -0400", hash_original_method = "BAFD3BC777B3DA03D70496857F209CFE", hash_generated_method = "79B941E367573CF1B96C13E20D21DFE3")
    public boolean eglReleaseThread() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2017010711 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2017010711;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.399 -0400", hash_original_method = "597806537D1EB9D066DEDBB0F5CABF82", hash_generated_method = "2BDA0695B35AA66F64B8A9205AC74FC1")
    public boolean eglChooseConfig(EGLDisplay display, int[] attrib_list, EGLConfig[] configs, int config_size, int[] num_config) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1992968276 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1992968276;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.399 -0400", hash_original_method = "CE0C84B918062E5840E34AEA7F4A16CD", hash_generated_method = "79CFC38C03188EEAB86C91FD605088B9")
    public boolean eglGetConfigAttrib(EGLDisplay display, EGLConfig config, int attribute, int[] value) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1676187509 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1676187509;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.400 -0400", hash_original_method = "1FF43B35756785946FBC969447AE4429", hash_generated_method = "0D665ECB7F857D8177406207A0BB145B")
    public boolean eglGetConfigs(EGLDisplay display, EGLConfig[] configs, int config_size, int[] num_config) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_490041103 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_490041103;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.400 -0400", hash_original_method = "30167F0B844356CC78AEA2C709085F0A", hash_generated_method = "E31D3054B31D8BD31968BD6D5035B0AD")
    public int eglGetError() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1979390128 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1979390128;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.401 -0400", hash_original_method = "F2C45513A57BFF3B5C76E0152AB1D6FE", hash_generated_method = "21F2ECCF7EAC120663323A02ABC74F84")
    public boolean eglDestroyContext(EGLDisplay display, EGLContext context) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_709765808 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_709765808;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.401 -0400", hash_original_method = "F8BE74B02C97D5EFE0B64C835DE94243", hash_generated_method = "86EBBF6DB0E9EAA43337BA7E507BC726")
    public boolean eglDestroySurface(EGLDisplay display, EGLSurface surface) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_290814811 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_290814811;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.401 -0400", hash_original_method = "D0A5BC4F7F6AC39FDE4C2E9D6BB5947A", hash_generated_method = "429807090E3486607ABA18E3DC9E2D51")
    public boolean eglMakeCurrent(EGLDisplay display, EGLSurface draw, EGLSurface read, EGLContext context) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1740202846 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1740202846;
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.402 -0400", hash_original_method = "3CBB90A352CD62A4CE70C5B74A91066B", hash_generated_method = "F7BCE77BBAEE8073C9D147DF0D6FB4B1")
    public boolean eglSwapBuffers(EGLDisplay display, EGLSurface surface) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1396262508 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1396262508;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.402 -0400", hash_original_method = "76CDC4A068B49052D1DE694B54AD997D", hash_generated_method = "A7F901A9F9C226553FB38C7EBDA3C1CC")
    public boolean eglTerminate(EGLDisplay display) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1843799951 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1843799951;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.403 -0400", hash_original_method = "4BC9AB9F0FAFDEDE82B7BBC20123D960", hash_generated_method = "AF12778D454257F6C069719DE8FBACC2")
    public boolean eglCopyBuffers(EGLDisplay display, EGLSurface surface, Object native_pixmap) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_939494068 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_939494068;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.403 -0400", hash_original_method = "CC5C6C40253D90C1249B907D63B6D41E", hash_generated_method = "2E48DE47AF546FF31197D6FE327CAC91")
    public boolean eglWaitGL() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1853675808 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1853675808;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.403 -0400", hash_original_method = "65BB1CF445260F062394F987EBFCAA01", hash_generated_method = "D3ED6F9F53CADF27F817D95BD894BF73")
    public boolean eglWaitNative(int engine, Object bindTarget) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1734332777 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1734332777;
    }

    
    @DSModeled(DSC.SAFE)
    public static int getInitCount(EGLDisplay display) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1163271600 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1163271600;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.404 -0400", hash_original_method = "CAD561FB9C34D7001DB982C1B864CD0D", hash_generated_method = "2AFCBF0FB6ED16226BC4EE9720F82C85")
    public EGLContext eglCreateContext(EGLDisplay display, EGLConfig config, EGLContext share_context, int[] attrib_list) {
        addTaint(attrib_list[0]);
        addTaint(share_context.getTaint());
        addTaint(config.getTaint());
        addTaint(display.getTaint());
        int eglContextId = _eglCreateContext(display, config, share_context, attrib_list);
    if(eglContextId == 0)        
        {
EGLContext var8B12D0F59FFC1F329D044E613B64C886_1128181205 =             EGL10.EGL_NO_CONTEXT;
            var8B12D0F59FFC1F329D044E613B64C886_1128181205.addTaint(taint);
            return var8B12D0F59FFC1F329D044E613B64C886_1128181205;
        } //End block
EGLContext varA69F6A3543095187E8EFF7B289AE5DF0_1359379202 =         new EGLContextImpl( eglContextId );
        varA69F6A3543095187E8EFF7B289AE5DF0_1359379202.addTaint(taint);
        return varA69F6A3543095187E8EFF7B289AE5DF0_1359379202;
        // ---------- Original Method ----------
        //int eglContextId = _eglCreateContext(display, config, share_context, attrib_list);
        //if (eglContextId == 0) {
            //return EGL10.EGL_NO_CONTEXT;
        //}
        //return new EGLContextImpl( eglContextId );
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.404 -0400", hash_original_method = "E59A00AD2A74A21C0F4005F77A95ED7D", hash_generated_method = "CE2D29FFE38EC22689953EC0612A1B1E")
    public EGLSurface eglCreatePbufferSurface(EGLDisplay display, EGLConfig config, int[] attrib_list) {
        addTaint(attrib_list[0]);
        addTaint(config.getTaint());
        addTaint(display.getTaint());
        int eglSurfaceId = _eglCreatePbufferSurface(display, config, attrib_list);
    if(eglSurfaceId == 0)        
        {
EGLSurface var661D124B60BA28C4D2717F54068BA043_396811472 =             EGL10.EGL_NO_SURFACE;
            var661D124B60BA28C4D2717F54068BA043_396811472.addTaint(taint);
            return var661D124B60BA28C4D2717F54068BA043_396811472;
        } //End block
EGLSurface varA54243EB7A45A941A14A628971C01392_1921545407 =         new EGLSurfaceImpl( eglSurfaceId );
        varA54243EB7A45A941A14A628971C01392_1921545407.addTaint(taint);
        return varA54243EB7A45A941A14A628971C01392_1921545407;
        // ---------- Original Method ----------
        //int eglSurfaceId = _eglCreatePbufferSurface(display, config, attrib_list);
        //if (eglSurfaceId == 0) {
            //return EGL10.EGL_NO_SURFACE;
        //}
        //return new EGLSurfaceImpl( eglSurfaceId );
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.405 -0400", hash_original_method = "1913DE6E1812314106CFABA8D0690133", hash_generated_method = "9B1B357EF9155BA6641DBD52A9A3C9C2")
    public EGLSurface eglCreatePixmapSurface(EGLDisplay display, EGLConfig config, Object native_pixmap, int[] attrib_list) {
        addTaint(attrib_list[0]);
        addTaint(native_pixmap.getTaint());
        addTaint(config.getTaint());
        addTaint(display.getTaint());
        EGLSurfaceImpl sur = new EGLSurfaceImpl();
        _eglCreatePixmapSurface(sur, display, config, native_pixmap, attrib_list);
    if(sur.mEGLSurface == 0)        
        {
EGLSurface var661D124B60BA28C4D2717F54068BA043_1927762003 =             EGL10.EGL_NO_SURFACE;
            var661D124B60BA28C4D2717F54068BA043_1927762003.addTaint(taint);
            return var661D124B60BA28C4D2717F54068BA043_1927762003;
        } //End block
EGLSurface varE2F14575F3D48B3F2E6009886096BF0A_1839529442 =         sur;
        varE2F14575F3D48B3F2E6009886096BF0A_1839529442.addTaint(taint);
        return varE2F14575F3D48B3F2E6009886096BF0A_1839529442;
        // ---------- Original Method ----------
        //EGLSurfaceImpl sur = new EGLSurfaceImpl();
        //_eglCreatePixmapSurface(sur, display, config, native_pixmap, attrib_list);
        //if (sur.mEGLSurface == 0) {
            //return EGL10.EGL_NO_SURFACE;
        //}
        //return sur;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.406 -0400", hash_original_method = "A3C23A2D0F372302CCCB5BF8EDDCD71A", hash_generated_method = "8749FFC4C0ADBC7749F07A5FFCBA891F")
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
            java.lang.UnsupportedOperationException varEC76C1F9CF7F752DEE7F1B5E569D82B4_1520182036 = new java.lang.UnsupportedOperationException(
                "eglCreateWindowSurface() can only be called with an instance of " +
                "SurfaceView, SurfaceHolder or SurfaceTexture at the moment, " + 
                "this will be fixed later.");
            varEC76C1F9CF7F752DEE7F1B5E569D82B4_1520182036.addTaint(taint);
            throw varEC76C1F9CF7F752DEE7F1B5E569D82B4_1520182036;
        } //End block
    if(eglSurfaceId == 0)        
        {
EGLSurface var661D124B60BA28C4D2717F54068BA043_342914324 =             EGL10.EGL_NO_SURFACE;
            var661D124B60BA28C4D2717F54068BA043_342914324.addTaint(taint);
            return var661D124B60BA28C4D2717F54068BA043_342914324;
        } //End block
EGLSurface varA54243EB7A45A941A14A628971C01392_1637918546 =         new EGLSurfaceImpl( eglSurfaceId );
        varA54243EB7A45A941A14A628971C01392_1637918546.addTaint(taint);
        return varA54243EB7A45A941A14A628971C01392_1637918546;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.407 -0400", hash_original_method = "BEC2EA85C18256200276555D8D849688", hash_generated_method = "323CC2CF60916EDE5C4FBD55F14E1A1F")
    public synchronized EGLDisplay eglGetDisplay(Object native_display) {
        addTaint(native_display.getTaint());
        int value = _eglGetDisplay(native_display);
    if(value == 0)        
        {
EGLDisplay var5ABDA0E7FAF25206EB507E6EED49A34C_131499308 =             EGL10.EGL_NO_DISPLAY;
            var5ABDA0E7FAF25206EB507E6EED49A34C_131499308.addTaint(taint);
            return var5ABDA0E7FAF25206EB507E6EED49A34C_131499308;
        } //End block
    if(mDisplay.mEGLDisplay != value)        
        mDisplay = new EGLDisplayImpl(value);
EGLDisplay var36FB7BADF2724DB652908D0DF82CB492_5692287 =         mDisplay;
        var36FB7BADF2724DB652908D0DF82CB492_5692287.addTaint(taint);
        return var36FB7BADF2724DB652908D0DF82CB492_5692287;
        // ---------- Original Method ----------
        //int value = _eglGetDisplay(native_display);
        //if (value == 0) {
            //return EGL10.EGL_NO_DISPLAY;
        //}
        //if (mDisplay.mEGLDisplay != value)
            //mDisplay = new EGLDisplayImpl(value);
        //return mDisplay;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.407 -0400", hash_original_method = "36FE38451D664CBAEEF58B0CA2F2C184", hash_generated_method = "27B2DC8C2911B55126A2FB447287633E")
    public synchronized EGLContext eglGetCurrentContext() {
        int value = _eglGetCurrentContext();
    if(value == 0)        
        {
EGLContext var8B12D0F59FFC1F329D044E613B64C886_454733936 =             EGL10.EGL_NO_CONTEXT;
            var8B12D0F59FFC1F329D044E613B64C886_454733936.addTaint(taint);
            return var8B12D0F59FFC1F329D044E613B64C886_454733936;
        } //End block
    if(mContext.mEGLContext != value)        
        mContext = new EGLContextImpl(value);
EGLContext var178E2AD52D6FBBB503F908168856B574_327765864 =         mContext;
        var178E2AD52D6FBBB503F908168856B574_327765864.addTaint(taint);
        return var178E2AD52D6FBBB503F908168856B574_327765864;
        // ---------- Original Method ----------
        //int value = _eglGetCurrentContext();
        //if (value == 0) {
            //return EGL10.EGL_NO_CONTEXT;
        //}
        //if (mContext.mEGLContext != value)
            //mContext = new EGLContextImpl(value);
        //return mContext;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.408 -0400", hash_original_method = "2AD52C4EA481E23FFE9D610E551D647C", hash_generated_method = "253FE56562DD38A621E60FAA118C8FAB")
    public synchronized EGLDisplay eglGetCurrentDisplay() {
        int value = _eglGetCurrentDisplay();
    if(value == 0)        
        {
EGLDisplay var5ABDA0E7FAF25206EB507E6EED49A34C_1442892756 =             EGL10.EGL_NO_DISPLAY;
            var5ABDA0E7FAF25206EB507E6EED49A34C_1442892756.addTaint(taint);
            return var5ABDA0E7FAF25206EB507E6EED49A34C_1442892756;
        } //End block
    if(mDisplay.mEGLDisplay != value)        
        mDisplay = new EGLDisplayImpl(value);
EGLDisplay var36FB7BADF2724DB652908D0DF82CB492_1903944035 =         mDisplay;
        var36FB7BADF2724DB652908D0DF82CB492_1903944035.addTaint(taint);
        return var36FB7BADF2724DB652908D0DF82CB492_1903944035;
        // ---------- Original Method ----------
        //int value = _eglGetCurrentDisplay();
        //if (value == 0) {
            //return EGL10.EGL_NO_DISPLAY;
        //}
        //if (mDisplay.mEGLDisplay != value)
            //mDisplay = new EGLDisplayImpl(value);
        //return mDisplay;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.409 -0400", hash_original_method = "1056D87FF6AF8A6633AE7A0382D42E2B", hash_generated_method = "BE8E1F48FA7AD8FB9E8AC1B720E1419E")
    public synchronized EGLSurface eglGetCurrentSurface(int readdraw) {
        addTaint(readdraw);
        int value = _eglGetCurrentSurface(readdraw);
    if(value == 0)        
        {
EGLSurface var661D124B60BA28C4D2717F54068BA043_545449881 =             EGL10.EGL_NO_SURFACE;
            var661D124B60BA28C4D2717F54068BA043_545449881.addTaint(taint);
            return var661D124B60BA28C4D2717F54068BA043_545449881;
        } //End block
    if(mSurface.mEGLSurface != value)        
        mSurface = new EGLSurfaceImpl(value);
EGLSurface varB7C98568942B156EFD367CE054011CDA_679298237 =         mSurface;
        varB7C98568942B156EFD367CE054011CDA_679298237.addTaint(taint);
        return varB7C98568942B156EFD367CE054011CDA_679298237;
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.410 -0400", hash_original_method = "00A9769D3FCB2BCA752959A2156960BA", hash_generated_method = "CA76A9E795A2823569B0369373835266")
    private int _eglCreateContext(EGLDisplay display, EGLConfig config, EGLContext share_context, int[] attrib_list) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1896132354 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1896132354;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.410 -0400", hash_original_method = "9C66F8DAF2CF1DF35D1777997045841F", hash_generated_method = "AE67D5BEC1ED971E49A9D66B98CD8CB0")
    private int _eglCreatePbufferSurface(EGLDisplay display, EGLConfig config, int[] attrib_list) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_470973886 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_470973886;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.411 -0400", hash_original_method = "37A0D40F82301EFE54D93A3E184BD2AE", hash_generated_method = "67B71D5B2B8EA12F14EA13A7D4D22EC8")
    private void _eglCreatePixmapSurface(EGLSurface sur, EGLDisplay display, EGLConfig config, Object native_pixmap, int[] attrib_list) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.411 -0400", hash_original_method = "73053A5CE6D69977C0A5A55B454424E0", hash_generated_method = "1D40ACFC028F1E59050A1B04F7E4D51A")
    private int _eglCreateWindowSurface(EGLDisplay display, EGLConfig config, Object native_window, int[] attrib_list) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1413659294 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1413659294;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.412 -0400", hash_original_method = "C683AABBDC194C692A1DD6C73D5E2B96", hash_generated_method = "5ABA8708E15237B5CB34F6A684414E50")
    private int _eglCreateWindowSurfaceTexture(EGLDisplay display, EGLConfig config, Object native_window, int[] attrib_list) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_304987546 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_304987546;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.412 -0400", hash_original_method = "E8D546530FFFC5C2FC6E86FFB85AACEC", hash_generated_method = "FA7759B1C2A871E40748DCACF3F38FDE")
    private int _eglGetDisplay(Object native_display) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1234572478 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1234572478;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.413 -0400", hash_original_method = "37AAAAC75A3E4652292E435C97659047", hash_generated_method = "FFC535ECAE570A478D4728685C5004EF")
    private int _eglGetCurrentContext() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1257067435 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1257067435;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.413 -0400", hash_original_method = "AF8954095CE356BE495ED3F59D7027C3", hash_generated_method = "580A3EC1F5B42706B424A19A659430A0")
    private int _eglGetCurrentDisplay() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_161724 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_161724;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.413 -0400", hash_original_method = "9F7D143F548ED01AA850BEE267C7749A", hash_generated_method = "C123BDBD8E7D895996FCDEA1AEFE0598")
    private int _eglGetCurrentSurface(int readdraw) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_769700118 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_769700118;
    }

    
    @DSModeled(DSC.SAFE)
    private static void _nativeClassInit() {
    }

    
    static { _nativeClassInit(); }
    
}

