package com.google.android.gles_jni;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import javax.microedition.khronos.egl.*;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.SurfaceView;
import android.view.SurfaceHolder;

public class EGLImpl implements EGL10 {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.385 -0400", hash_original_field = "0F8898C409B0E41427A2E6AA6C67E1EC", hash_generated_field = "299BB99E9FA7B75F06D17EB158F11EC7")

    private EGLContextImpl mContext = new EGLContextImpl(-1);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.385 -0400", hash_original_field = "A8BAED30807DC75517DDAE7C4EFB1286", hash_generated_field = "66FCEFDB57492E5584274D8BC130FFAD")

    private EGLDisplayImpl mDisplay = new EGLDisplayImpl(-1);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.385 -0400", hash_original_field = "A3FE23ED2289FC865AF994EFF579711B", hash_generated_field = "A9E68FD08AADF48015530582ECAAFB47")

    private EGLSurfaceImpl mSurface = new EGLSurfaceImpl(-1);
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.385 -0400", hash_original_method = "1F432E8932AB5EEB87E85C95C31E8080", hash_generated_method = "1F432E8932AB5EEB87E85C95C31E8080")
    public EGLImpl ()
    {
        
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.385 -0400", hash_original_method = "0FE9F08E24E0D2453B9577BF62363101", hash_generated_method = "6E696855C61DA52195651501FC474974")
    public boolean eglInitialize(EGLDisplay display, int[] major_minor) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1638854290 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1638854290;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.386 -0400", hash_original_method = "F079BB68B5D124389F3B0A1B80EDA8E6", hash_generated_method = "3C4D8FCE56D23112076A5307A2BF5A39")
    public boolean eglQueryContext(EGLDisplay display, EGLContext context, int attribute, int[] value) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1722070311 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1722070311;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.386 -0400", hash_original_method = "543FE727862E36E7BB38AE92834CF157", hash_generated_method = "43DA74FD94EAC997ADAEB46238DE7C68")
    public boolean eglQuerySurface(EGLDisplay display, EGLSurface surface, int attribute, int[] value) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1789790392 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1789790392;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.386 -0400", hash_original_method = "BAFD3BC777B3DA03D70496857F209CFE", hash_generated_method = "289F15B88EA0B41E8E302F50FD360034")
    public boolean eglReleaseThread() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1399342504 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1399342504;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.387 -0400", hash_original_method = "597806537D1EB9D066DEDBB0F5CABF82", hash_generated_method = "CA8E60B9F9A0A9200CE8E32B7ACAB15A")
    public boolean eglChooseConfig(EGLDisplay display, int[] attrib_list, EGLConfig[] configs, int config_size, int[] num_config) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_950449160 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_950449160;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.387 -0400", hash_original_method = "CE0C84B918062E5840E34AEA7F4A16CD", hash_generated_method = "224491AA50D9B776DA77A6BABC5E6146")
    public boolean eglGetConfigAttrib(EGLDisplay display, EGLConfig config, int attribute, int[] value) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1105741969 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1105741969;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.387 -0400", hash_original_method = "1FF43B35756785946FBC969447AE4429", hash_generated_method = "65F2B89865BCFC3373119699769EBC32")
    public boolean eglGetConfigs(EGLDisplay display, EGLConfig[] configs, int config_size, int[] num_config) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_380875338 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_380875338;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.388 -0400", hash_original_method = "30167F0B844356CC78AEA2C709085F0A", hash_generated_method = "BB059EE6F2BD6CF44962E6F7A4368801")
    public int eglGetError() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1411198359 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1411198359;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.388 -0400", hash_original_method = "F2C45513A57BFF3B5C76E0152AB1D6FE", hash_generated_method = "B994F28195F5D730364640D4071ED1EF")
    public boolean eglDestroyContext(EGLDisplay display, EGLContext context) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_229939847 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_229939847;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.388 -0400", hash_original_method = "F8BE74B02C97D5EFE0B64C835DE94243", hash_generated_method = "68C03229CED5FFB6FFE103E44883537E")
    public boolean eglDestroySurface(EGLDisplay display, EGLSurface surface) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2072506081 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2072506081;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.388 -0400", hash_original_method = "D0A5BC4F7F6AC39FDE4C2E9D6BB5947A", hash_generated_method = "D5FCA466ACE9FF219DE3B6AB746DBAB7")
    public boolean eglMakeCurrent(EGLDisplay display, EGLSurface draw, EGLSurface read, EGLContext context) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1635027542 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1635027542;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.388 -0400", hash_original_method = "7F0F6E22A72F3EFD03B53C72B8A334B5", hash_generated_method = "FD75A226178BC0A876B19864D0D93C7A")
    public String eglQueryString(EGLDisplay display, int name) {
    	addTaint(display.getTaint());
    	addTaint(name);
    	String s = new String();
    	s.addTaint(taint);
    	return s;
    	
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.389 -0400", hash_original_method = "3CBB90A352CD62A4CE70C5B74A91066B", hash_generated_method = "8AD02DFF166F078243356BA79D8C89FC")
    public boolean eglSwapBuffers(EGLDisplay display, EGLSurface surface) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1695774213 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1695774213;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.389 -0400", hash_original_method = "76CDC4A068B49052D1DE694B54AD997D", hash_generated_method = "57043AC130FE20E9FF34DA6F8DCCCCAE")
    public boolean eglTerminate(EGLDisplay display) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1801888869 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1801888869;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.389 -0400", hash_original_method = "4BC9AB9F0FAFDEDE82B7BBC20123D960", hash_generated_method = "70D9E0851C486D0AD99AAC5926D7FB0F")
    public boolean eglCopyBuffers(EGLDisplay display, EGLSurface surface, Object native_pixmap) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1731790315 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1731790315;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.389 -0400", hash_original_method = "CC5C6C40253D90C1249B907D63B6D41E", hash_generated_method = "1B5BEDDC05C3786A9666985A04B776AC")
    public boolean eglWaitGL() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1811915031 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1811915031;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.389 -0400", hash_original_method = "65BB1CF445260F062394F987EBFCAA01", hash_generated_method = "CD4B0B5C872750A998A142257C3E527F")
    public boolean eglWaitNative(int engine, Object bindTarget) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1952974093 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1952974093;
    }

    
    public static int getInitCount(EGLDisplay display) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1163271600 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1163271600;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.390 -0400", hash_original_method = "CAD561FB9C34D7001DB982C1B864CD0D", hash_generated_method = "4642949BA7694EFB30720E0B52DED01D")
    public EGLContext eglCreateContext(EGLDisplay display, EGLConfig config, EGLContext share_context, int[] attrib_list) {
        EGLContext varB4EAC82CA7396A68D541C85D26508E83_2066146964 = null; 
        EGLContext varB4EAC82CA7396A68D541C85D26508E83_1518076539 = null; 
        int eglContextId = _eglCreateContext(display, config, share_context, attrib_list);
        {
            varB4EAC82CA7396A68D541C85D26508E83_2066146964 = EGL10.EGL_NO_CONTEXT;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1518076539 = new EGLContextImpl( eglContextId );
        addTaint(display.getTaint());
        addTaint(config.getTaint());
        addTaint(share_context.getTaint());
        addTaint(attrib_list[0]);
        EGLContext varA7E53CE21691AB073D9660D615818899_519194204; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_519194204 = varB4EAC82CA7396A68D541C85D26508E83_2066146964;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_519194204 = varB4EAC82CA7396A68D541C85D26508E83_1518076539;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_519194204.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_519194204;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.391 -0400", hash_original_method = "E59A00AD2A74A21C0F4005F77A95ED7D", hash_generated_method = "9C1AB63C58CD3A8C9ED15C9F6EFF6BC3")
    public EGLSurface eglCreatePbufferSurface(EGLDisplay display, EGLConfig config, int[] attrib_list) {
        EGLSurface varB4EAC82CA7396A68D541C85D26508E83_208735326 = null; 
        EGLSurface varB4EAC82CA7396A68D541C85D26508E83_740510547 = null; 
        int eglSurfaceId = _eglCreatePbufferSurface(display, config, attrib_list);
        {
            varB4EAC82CA7396A68D541C85D26508E83_208735326 = EGL10.EGL_NO_SURFACE;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_740510547 = new EGLSurfaceImpl( eglSurfaceId );
        addTaint(display.getTaint());
        addTaint(config.getTaint());
        addTaint(attrib_list[0]);
        EGLSurface varA7E53CE21691AB073D9660D615818899_1324474817; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1324474817 = varB4EAC82CA7396A68D541C85D26508E83_208735326;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1324474817 = varB4EAC82CA7396A68D541C85D26508E83_740510547;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1324474817.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1324474817;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.392 -0400", hash_original_method = "1913DE6E1812314106CFABA8D0690133", hash_generated_method = "340586A1878B3D10B04E55C0B46B540E")
    public EGLSurface eglCreatePixmapSurface(EGLDisplay display, EGLConfig config, Object native_pixmap, int[] attrib_list) {
        EGLSurface varB4EAC82CA7396A68D541C85D26508E83_1380947791 = null; 
        EGLSurface varB4EAC82CA7396A68D541C85D26508E83_1436403230 = null; 
        EGLSurfaceImpl sur = new EGLSurfaceImpl();
        _eglCreatePixmapSurface(sur, display, config, native_pixmap, attrib_list);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1380947791 = EGL10.EGL_NO_SURFACE;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1436403230 = sur;
        addTaint(display.getTaint());
        addTaint(config.getTaint());
        addTaint(native_pixmap.getTaint());
        addTaint(attrib_list[0]);
        EGLSurface varA7E53CE21691AB073D9660D615818899_924826853; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_924826853 = varB4EAC82CA7396A68D541C85D26508E83_1380947791;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_924826853 = varB4EAC82CA7396A68D541C85D26508E83_1436403230;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_924826853.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_924826853;
        
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.394 -0400", hash_original_method = "A3C23A2D0F372302CCCB5BF8EDDCD71A", hash_generated_method = "0AC3D8C0DD57B4B12D712AFAB11961BB")
    public EGLSurface eglCreateWindowSurface(EGLDisplay display, EGLConfig config, Object native_window, int[] attrib_list) {
        EGLSurface varB4EAC82CA7396A68D541C85D26508E83_1906463715 = null; 
        EGLSurface varB4EAC82CA7396A68D541C85D26508E83_1384160120 = null; 
        Surface sur = null;
        {
            SurfaceView surfaceView = (SurfaceView)native_window;
            sur = surfaceView.getHolder().getSurface();
        } 
        {
            SurfaceHolder holder = (SurfaceHolder)native_window;
            sur = holder.getSurface();
        } 
        int eglSurfaceId;
        {
            eglSurfaceId = _eglCreateWindowSurface(display, config, sur, attrib_list);
        } 
        {
            eglSurfaceId = _eglCreateWindowSurfaceTexture(display, config,
                    native_window, attrib_list);
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new java.lang.UnsupportedOperationException(
                "eglCreateWindowSurface() can only be called with an instance of " +
                "SurfaceView, SurfaceHolder or SurfaceTexture at the moment, " + 
                "this will be fixed later.");
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1906463715 = EGL10.EGL_NO_SURFACE;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1384160120 = new EGLSurfaceImpl( eglSurfaceId );
        addTaint(display.getTaint());
        addTaint(config.getTaint());
        addTaint(native_window.getTaint());
        addTaint(attrib_list[0]);
        EGLSurface varA7E53CE21691AB073D9660D615818899_1583245670; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1583245670 = varB4EAC82CA7396A68D541C85D26508E83_1906463715;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1583245670 = varB4EAC82CA7396A68D541C85D26508E83_1384160120;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1583245670.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1583245670;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.395 -0400", hash_original_method = "BEC2EA85C18256200276555D8D849688", hash_generated_method = "387EF7F0D5381FC08BD585F6E04796E4")
    public synchronized EGLDisplay eglGetDisplay(Object native_display) {
        EGLDisplay varB4EAC82CA7396A68D541C85D26508E83_1104650714 = null; 
        EGLDisplay varB4EAC82CA7396A68D541C85D26508E83_1107209266 = null; 
        int value = _eglGetDisplay(native_display);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1104650714 = EGL10.EGL_NO_DISPLAY;
        } 
        mDisplay = new EGLDisplayImpl(value);
        varB4EAC82CA7396A68D541C85D26508E83_1107209266 = mDisplay;
        addTaint(native_display.getTaint());
        EGLDisplay varA7E53CE21691AB073D9660D615818899_1884758373; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1884758373 = varB4EAC82CA7396A68D541C85D26508E83_1104650714;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1884758373 = varB4EAC82CA7396A68D541C85D26508E83_1107209266;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1884758373.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1884758373;
        
        
        
            
        
        
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.396 -0400", hash_original_method = "36FE38451D664CBAEEF58B0CA2F2C184", hash_generated_method = "AC3DDCC977925B14971A607286CC064A")
    public synchronized EGLContext eglGetCurrentContext() {
        EGLContext varB4EAC82CA7396A68D541C85D26508E83_663094778 = null; 
        EGLContext varB4EAC82CA7396A68D541C85D26508E83_1635427122 = null; 
        int value = _eglGetCurrentContext();
        {
            varB4EAC82CA7396A68D541C85D26508E83_663094778 = EGL10.EGL_NO_CONTEXT;
        } 
        mContext = new EGLContextImpl(value);
        varB4EAC82CA7396A68D541C85D26508E83_1635427122 = mContext;
        EGLContext varA7E53CE21691AB073D9660D615818899_1758890619; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1758890619 = varB4EAC82CA7396A68D541C85D26508E83_663094778;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1758890619 = varB4EAC82CA7396A68D541C85D26508E83_1635427122;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1758890619.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1758890619;
        
        
        
            
        
        
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.397 -0400", hash_original_method = "2AD52C4EA481E23FFE9D610E551D647C", hash_generated_method = "68208ED853F739A52DF1330CCFDB5C04")
    public synchronized EGLDisplay eglGetCurrentDisplay() {
        EGLDisplay varB4EAC82CA7396A68D541C85D26508E83_959751300 = null; 
        EGLDisplay varB4EAC82CA7396A68D541C85D26508E83_1357428348 = null; 
        int value = _eglGetCurrentDisplay();
        {
            varB4EAC82CA7396A68D541C85D26508E83_959751300 = EGL10.EGL_NO_DISPLAY;
        } 
        mDisplay = new EGLDisplayImpl(value);
        varB4EAC82CA7396A68D541C85D26508E83_1357428348 = mDisplay;
        EGLDisplay varA7E53CE21691AB073D9660D615818899_51644405; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_51644405 = varB4EAC82CA7396A68D541C85D26508E83_959751300;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_51644405 = varB4EAC82CA7396A68D541C85D26508E83_1357428348;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_51644405.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_51644405;
        
        
        
            
        
        
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.397 -0400", hash_original_method = "1056D87FF6AF8A6633AE7A0382D42E2B", hash_generated_method = "2FD5493BFD9AD25EA2B30B4B69ED0874")
    public synchronized EGLSurface eglGetCurrentSurface(int readdraw) {
        EGLSurface varB4EAC82CA7396A68D541C85D26508E83_1649067813 = null; 
        EGLSurface varB4EAC82CA7396A68D541C85D26508E83_345424726 = null; 
        int value = _eglGetCurrentSurface(readdraw);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1649067813 = EGL10.EGL_NO_SURFACE;
        } 
        mSurface = new EGLSurfaceImpl(value);
        varB4EAC82CA7396A68D541C85D26508E83_345424726 = mSurface;
        addTaint(readdraw);
        EGLSurface varA7E53CE21691AB073D9660D615818899_36656572; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_36656572 = varB4EAC82CA7396A68D541C85D26508E83_1649067813;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_36656572 = varB4EAC82CA7396A68D541C85D26508E83_345424726;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_36656572.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_36656572;
        
        
        
            
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.398 -0400", hash_original_method = "00A9769D3FCB2BCA752959A2156960BA", hash_generated_method = "05FBD9B00C27855220ED3588BDD28C98")
    private int _eglCreateContext(EGLDisplay display, EGLConfig config, EGLContext share_context, int[] attrib_list) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_885766922 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_885766922;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.398 -0400", hash_original_method = "9C66F8DAF2CF1DF35D1777997045841F", hash_generated_method = "48EA57098ED674FC9FD22E702DC6F910")
    private int _eglCreatePbufferSurface(EGLDisplay display, EGLConfig config, int[] attrib_list) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_480476591 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_480476591;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.398 -0400", hash_original_method = "37A0D40F82301EFE54D93A3E184BD2AE", hash_generated_method = "67B71D5B2B8EA12F14EA13A7D4D22EC8")
    private void _eglCreatePixmapSurface(EGLSurface sur, EGLDisplay display, EGLConfig config, Object native_pixmap, int[] attrib_list) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.399 -0400", hash_original_method = "73053A5CE6D69977C0A5A55B454424E0", hash_generated_method = "8476AF037716767B08B91BD3F4726D80")
    private int _eglCreateWindowSurface(EGLDisplay display, EGLConfig config, Object native_window, int[] attrib_list) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1851951462 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1851951462;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.399 -0400", hash_original_method = "C683AABBDC194C692A1DD6C73D5E2B96", hash_generated_method = "2A809D27404EE88110441E01C2A5B5B6")
    private int _eglCreateWindowSurfaceTexture(EGLDisplay display, EGLConfig config, Object native_window, int[] attrib_list) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_241517995 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_241517995;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.399 -0400", hash_original_method = "E8D546530FFFC5C2FC6E86FFB85AACEC", hash_generated_method = "A85227FF1019C42593EB3E398860336C")
    private int _eglGetDisplay(Object native_display) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1800272887 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1800272887;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.400 -0400", hash_original_method = "37AAAAC75A3E4652292E435C97659047", hash_generated_method = "FA44BCDADE6564FB8DCDFE1C7427C607")
    private int _eglGetCurrentContext() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1552301368 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1552301368;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.400 -0400", hash_original_method = "AF8954095CE356BE495ED3F59D7027C3", hash_generated_method = "2DEA0616F04F1CBAB2AFB6D28FDE10EA")
    private int _eglGetCurrentDisplay() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1619656359 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1619656359;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.400 -0400", hash_original_method = "9F7D143F548ED01AA850BEE267C7749A", hash_generated_method = "1302405BE8B110457193D0BFC295B5F0")
    private int _eglGetCurrentSurface(int readdraw) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_417553124 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_417553124;
    }

    
    private static void _nativeClassInit() {
    }

    
    static { _nativeClassInit(); }
    
}

