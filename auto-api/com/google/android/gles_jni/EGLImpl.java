package com.google.android.gles_jni;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import javax.microedition.khronos.egl.*;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.SurfaceView;
import android.view.SurfaceHolder;

public class EGLImpl implements EGL10 {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.141 -0400", hash_original_field = "0F8898C409B0E41427A2E6AA6C67E1EC", hash_generated_field = "299BB99E9FA7B75F06D17EB158F11EC7")

    private EGLContextImpl mContext = new EGLContextImpl(-1);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.141 -0400", hash_original_field = "A8BAED30807DC75517DDAE7C4EFB1286", hash_generated_field = "66FCEFDB57492E5584274D8BC130FFAD")

    private EGLDisplayImpl mDisplay = new EGLDisplayImpl(-1);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.141 -0400", hash_original_field = "A3FE23ED2289FC865AF994EFF579711B", hash_generated_field = "A9E68FD08AADF48015530582ECAAFB47")

    private EGLSurfaceImpl mSurface = new EGLSurfaceImpl(-1);
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.142 -0400", hash_original_method = "1F432E8932AB5EEB87E85C95C31E8080", hash_generated_method = "1F432E8932AB5EEB87E85C95C31E8080")
    public EGLImpl ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.142 -0400", hash_original_method = "0FE9F08E24E0D2453B9577BF62363101", hash_generated_method = "220DE8AA259E2636C7D4FFD164B27835")
    public boolean eglInitialize(EGLDisplay display, int[] major_minor) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_133464107 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_133464107;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.142 -0400", hash_original_method = "F079BB68B5D124389F3B0A1B80EDA8E6", hash_generated_method = "2BEAAAB01E84F04C142CDA009CD24289")
    public boolean eglQueryContext(EGLDisplay display, EGLContext context, int attribute, int[] value) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1151075039 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1151075039;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.143 -0400", hash_original_method = "543FE727862E36E7BB38AE92834CF157", hash_generated_method = "A6C14776598DA0567821ECCFF660F753")
    public boolean eglQuerySurface(EGLDisplay display, EGLSurface surface, int attribute, int[] value) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2031342203 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2031342203;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.143 -0400", hash_original_method = "BAFD3BC777B3DA03D70496857F209CFE", hash_generated_method = "2017DB19CEF4353F84DD8D5B8B4A09CE")
    public boolean eglReleaseThread() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1003400250 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1003400250;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.144 -0400", hash_original_method = "597806537D1EB9D066DEDBB0F5CABF82", hash_generated_method = "ECF40821075048D356744A10F92542ED")
    public boolean eglChooseConfig(EGLDisplay display, int[] attrib_list, EGLConfig[] configs, int config_size, int[] num_config) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_816748478 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_816748478;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.144 -0400", hash_original_method = "CE0C84B918062E5840E34AEA7F4A16CD", hash_generated_method = "99208C30F2B017898CF9288DDB58DC16")
    public boolean eglGetConfigAttrib(EGLDisplay display, EGLConfig config, int attribute, int[] value) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1308262515 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1308262515;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.144 -0400", hash_original_method = "1FF43B35756785946FBC969447AE4429", hash_generated_method = "701B7AA4EA216BE88A7326A1FC6897F9")
    public boolean eglGetConfigs(EGLDisplay display, EGLConfig[] configs, int config_size, int[] num_config) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_282795399 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_282795399;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.148 -0400", hash_original_method = "30167F0B844356CC78AEA2C709085F0A", hash_generated_method = "9468FF4537EC01DC4802C0EB640A4CDB")
    public int eglGetError() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_570499221 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_570499221;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.157 -0400", hash_original_method = "F2C45513A57BFF3B5C76E0152AB1D6FE", hash_generated_method = "01CF03F4E8B07860F5ECB55A54DC6F8C")
    public boolean eglDestroyContext(EGLDisplay display, EGLContext context) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1547952075 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1547952075;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.165 -0400", hash_original_method = "F8BE74B02C97D5EFE0B64C835DE94243", hash_generated_method = "1D1810C992D07292117944C744A3C03C")
    public boolean eglDestroySurface(EGLDisplay display, EGLSurface surface) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2062348233 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2062348233;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.166 -0400", hash_original_method = "D0A5BC4F7F6AC39FDE4C2E9D6BB5947A", hash_generated_method = "CAA3E2A34B16D48760DDE0287719EA3B")
    public boolean eglMakeCurrent(EGLDisplay display, EGLSurface draw, EGLSurface read, EGLContext context) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1699196056 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1699196056;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.166 -0400", hash_original_method = "7F0F6E22A72F3EFD03B53C72B8A334B5", hash_generated_method = "FD75A226178BC0A876B19864D0D93C7A")
    public String eglQueryString(EGLDisplay display, int name) {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.166 -0400", hash_original_method = "3CBB90A352CD62A4CE70C5B74A91066B", hash_generated_method = "C0105590E7EB09CCC05678DEEE388723")
    public boolean eglSwapBuffers(EGLDisplay display, EGLSurface surface) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_251791204 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_251791204;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.170 -0400", hash_original_method = "76CDC4A068B49052D1DE694B54AD997D", hash_generated_method = "8209A31953549DB259D239A9F133AB62")
    public boolean eglTerminate(EGLDisplay display) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_960311364 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_960311364;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.171 -0400", hash_original_method = "4BC9AB9F0FAFDEDE82B7BBC20123D960", hash_generated_method = "CA07ECCAC075C869799A83820E420F82")
    public boolean eglCopyBuffers(EGLDisplay display, EGLSurface surface, Object native_pixmap) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_245076639 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_245076639;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.171 -0400", hash_original_method = "CC5C6C40253D90C1249B907D63B6D41E", hash_generated_method = "E3E8431C924719D8F53B9AFC62132D32")
    public boolean eglWaitGL() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_18895054 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_18895054;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.171 -0400", hash_original_method = "65BB1CF445260F062394F987EBFCAA01", hash_generated_method = "12D741AD50BB321718A1710B5D59482C")
    public boolean eglWaitNative(int engine, Object bindTarget) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1057083201 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1057083201;
    }

    
        public static int getInitCount(EGLDisplay display) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.172 -0400", hash_original_method = "CAD561FB9C34D7001DB982C1B864CD0D", hash_generated_method = "B1D69BB068A3DF41BFB3382A376676DA")
    public EGLContext eglCreateContext(EGLDisplay display, EGLConfig config, EGLContext share_context, int[] attrib_list) {
        EGLContext varB4EAC82CA7396A68D541C85D26508E83_1331069035 = null; //Variable for return #1
        EGLContext varB4EAC82CA7396A68D541C85D26508E83_1551533624 = null; //Variable for return #2
        int eglContextId;
        eglContextId = _eglCreateContext(display, config, share_context, attrib_list);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1331069035 = EGL10.EGL_NO_CONTEXT;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1551533624 = new EGLContextImpl( eglContextId );
        addTaint(display.getTaint());
        addTaint(config.getTaint());
        addTaint(share_context.getTaint());
        addTaint(attrib_list[0]);
        EGLContext varA7E53CE21691AB073D9660D615818899_1013382712; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1013382712 = varB4EAC82CA7396A68D541C85D26508E83_1331069035;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1013382712 = varB4EAC82CA7396A68D541C85D26508E83_1551533624;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1013382712.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1013382712;
        // ---------- Original Method ----------
        //int eglContextId = _eglCreateContext(display, config, share_context, attrib_list);
        //if (eglContextId == 0) {
            //return EGL10.EGL_NO_CONTEXT;
        //}
        //return new EGLContextImpl( eglContextId );
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.173 -0400", hash_original_method = "E59A00AD2A74A21C0F4005F77A95ED7D", hash_generated_method = "76BF04354D3045493502F77BD7DA3493")
    public EGLSurface eglCreatePbufferSurface(EGLDisplay display, EGLConfig config, int[] attrib_list) {
        EGLSurface varB4EAC82CA7396A68D541C85D26508E83_1274561087 = null; //Variable for return #1
        EGLSurface varB4EAC82CA7396A68D541C85D26508E83_2001317942 = null; //Variable for return #2
        int eglSurfaceId;
        eglSurfaceId = _eglCreatePbufferSurface(display, config, attrib_list);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1274561087 = EGL10.EGL_NO_SURFACE;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_2001317942 = new EGLSurfaceImpl( eglSurfaceId );
        addTaint(display.getTaint());
        addTaint(config.getTaint());
        addTaint(attrib_list[0]);
        EGLSurface varA7E53CE21691AB073D9660D615818899_721867913; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_721867913 = varB4EAC82CA7396A68D541C85D26508E83_1274561087;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_721867913 = varB4EAC82CA7396A68D541C85D26508E83_2001317942;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_721867913.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_721867913;
        // ---------- Original Method ----------
        //int eglSurfaceId = _eglCreatePbufferSurface(display, config, attrib_list);
        //if (eglSurfaceId == 0) {
            //return EGL10.EGL_NO_SURFACE;
        //}
        //return new EGLSurfaceImpl( eglSurfaceId );
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.180 -0400", hash_original_method = "1913DE6E1812314106CFABA8D0690133", hash_generated_method = "0B53AD467D85C8CEFB94B30938EFD28C")
    public EGLSurface eglCreatePixmapSurface(EGLDisplay display, EGLConfig config, Object native_pixmap, int[] attrib_list) {
        EGLSurface varB4EAC82CA7396A68D541C85D26508E83_2071061163 = null; //Variable for return #1
        EGLSurface varB4EAC82CA7396A68D541C85D26508E83_1480859317 = null; //Variable for return #2
        EGLSurfaceImpl sur;
        sur = new EGLSurfaceImpl();
        _eglCreatePixmapSurface(sur, display, config, native_pixmap, attrib_list);
        {
            varB4EAC82CA7396A68D541C85D26508E83_2071061163 = EGL10.EGL_NO_SURFACE;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1480859317 = sur;
        addTaint(display.getTaint());
        addTaint(config.getTaint());
        addTaint(native_pixmap.getTaint());
        addTaint(attrib_list[0]);
        EGLSurface varA7E53CE21691AB073D9660D615818899_1009327543; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1009327543 = varB4EAC82CA7396A68D541C85D26508E83_2071061163;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1009327543 = varB4EAC82CA7396A68D541C85D26508E83_1480859317;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1009327543.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1009327543;
        // ---------- Original Method ----------
        //EGLSurfaceImpl sur = new EGLSurfaceImpl();
        //_eglCreatePixmapSurface(sur, display, config, native_pixmap, attrib_list);
        //if (sur.mEGLSurface == 0) {
            //return EGL10.EGL_NO_SURFACE;
        //}
        //return sur;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.181 -0400", hash_original_method = "A3C23A2D0F372302CCCB5BF8EDDCD71A", hash_generated_method = "D8437B206C7E08CDF5582BF4D3AE6B80")
    public EGLSurface eglCreateWindowSurface(EGLDisplay display, EGLConfig config, Object native_window, int[] attrib_list) {
        EGLSurface varB4EAC82CA7396A68D541C85D26508E83_1501910527 = null; //Variable for return #1
        EGLSurface varB4EAC82CA7396A68D541C85D26508E83_714275962 = null; //Variable for return #2
        Surface sur;
        sur = null;
        {
            SurfaceView surfaceView;
            surfaceView = (SurfaceView)native_window;
            sur = surfaceView.getHolder().getSurface();
        } //End block
        {
            SurfaceHolder holder;
            holder = (SurfaceHolder)native_window;
            sur = holder.getSurface();
        } //End block
        int eglSurfaceId;
        {
            eglSurfaceId = _eglCreateWindowSurface(display, config, sur, attrib_list);
        } //End block
        {
            eglSurfaceId = _eglCreateWindowSurfaceTexture(display, config,
                    native_window, attrib_list);
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new java.lang.UnsupportedOperationException(
                "eglCreateWindowSurface() can only be called with an instance of " +
                "SurfaceView, SurfaceHolder or SurfaceTexture at the moment, " + 
                "this will be fixed later.");
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1501910527 = EGL10.EGL_NO_SURFACE;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_714275962 = new EGLSurfaceImpl( eglSurfaceId );
        addTaint(display.getTaint());
        addTaint(config.getTaint());
        addTaint(native_window.getTaint());
        addTaint(attrib_list[0]);
        EGLSurface varA7E53CE21691AB073D9660D615818899_555693878; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_555693878 = varB4EAC82CA7396A68D541C85D26508E83_1501910527;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_555693878 = varB4EAC82CA7396A68D541C85D26508E83_714275962;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_555693878.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_555693878;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.182 -0400", hash_original_method = "BEC2EA85C18256200276555D8D849688", hash_generated_method = "E2830283E5881F4D4CA650B0AA41880A")
    public synchronized EGLDisplay eglGetDisplay(Object native_display) {
        EGLDisplay varB4EAC82CA7396A68D541C85D26508E83_379114035 = null; //Variable for return #1
        EGLDisplay varB4EAC82CA7396A68D541C85D26508E83_1002081394 = null; //Variable for return #2
        int value;
        value = _eglGetDisplay(native_display);
        {
            varB4EAC82CA7396A68D541C85D26508E83_379114035 = EGL10.EGL_NO_DISPLAY;
        } //End block
        mDisplay = new EGLDisplayImpl(value);
        varB4EAC82CA7396A68D541C85D26508E83_1002081394 = mDisplay;
        addTaint(native_display.getTaint());
        EGLDisplay varA7E53CE21691AB073D9660D615818899_388557704; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_388557704 = varB4EAC82CA7396A68D541C85D26508E83_379114035;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_388557704 = varB4EAC82CA7396A68D541C85D26508E83_1002081394;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_388557704.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_388557704;
        // ---------- Original Method ----------
        //int value = _eglGetDisplay(native_display);
        //if (value == 0) {
            //return EGL10.EGL_NO_DISPLAY;
        //}
        //if (mDisplay.mEGLDisplay != value)
            //mDisplay = new EGLDisplayImpl(value);
        //return mDisplay;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.195 -0400", hash_original_method = "36FE38451D664CBAEEF58B0CA2F2C184", hash_generated_method = "C24C9A948B7B3B19E1F80A3E5CC12050")
    public synchronized EGLContext eglGetCurrentContext() {
        EGLContext varB4EAC82CA7396A68D541C85D26508E83_38155001 = null; //Variable for return #1
        EGLContext varB4EAC82CA7396A68D541C85D26508E83_380725039 = null; //Variable for return #2
        int value;
        value = _eglGetCurrentContext();
        {
            varB4EAC82CA7396A68D541C85D26508E83_38155001 = EGL10.EGL_NO_CONTEXT;
        } //End block
        mContext = new EGLContextImpl(value);
        varB4EAC82CA7396A68D541C85D26508E83_380725039 = mContext;
        EGLContext varA7E53CE21691AB073D9660D615818899_298678106; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_298678106 = varB4EAC82CA7396A68D541C85D26508E83_38155001;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_298678106 = varB4EAC82CA7396A68D541C85D26508E83_380725039;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_298678106.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_298678106;
        // ---------- Original Method ----------
        //int value = _eglGetCurrentContext();
        //if (value == 0) {
            //return EGL10.EGL_NO_CONTEXT;
        //}
        //if (mContext.mEGLContext != value)
            //mContext = new EGLContextImpl(value);
        //return mContext;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.196 -0400", hash_original_method = "2AD52C4EA481E23FFE9D610E551D647C", hash_generated_method = "77F721B37D7D852004B6673246E094E7")
    public synchronized EGLDisplay eglGetCurrentDisplay() {
        EGLDisplay varB4EAC82CA7396A68D541C85D26508E83_352273452 = null; //Variable for return #1
        EGLDisplay varB4EAC82CA7396A68D541C85D26508E83_1222505795 = null; //Variable for return #2
        int value;
        value = _eglGetCurrentDisplay();
        {
            varB4EAC82CA7396A68D541C85D26508E83_352273452 = EGL10.EGL_NO_DISPLAY;
        } //End block
        mDisplay = new EGLDisplayImpl(value);
        varB4EAC82CA7396A68D541C85D26508E83_1222505795 = mDisplay;
        EGLDisplay varA7E53CE21691AB073D9660D615818899_829730835; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_829730835 = varB4EAC82CA7396A68D541C85D26508E83_352273452;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_829730835 = varB4EAC82CA7396A68D541C85D26508E83_1222505795;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_829730835.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_829730835;
        // ---------- Original Method ----------
        //int value = _eglGetCurrentDisplay();
        //if (value == 0) {
            //return EGL10.EGL_NO_DISPLAY;
        //}
        //if (mDisplay.mEGLDisplay != value)
            //mDisplay = new EGLDisplayImpl(value);
        //return mDisplay;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.197 -0400", hash_original_method = "1056D87FF6AF8A6633AE7A0382D42E2B", hash_generated_method = "DC36900FC728335F4A82AEAA8F329A85")
    public synchronized EGLSurface eglGetCurrentSurface(int readdraw) {
        EGLSurface varB4EAC82CA7396A68D541C85D26508E83_321792421 = null; //Variable for return #1
        EGLSurface varB4EAC82CA7396A68D541C85D26508E83_1994153405 = null; //Variable for return #2
        int value;
        value = _eglGetCurrentSurface(readdraw);
        {
            varB4EAC82CA7396A68D541C85D26508E83_321792421 = EGL10.EGL_NO_SURFACE;
        } //End block
        mSurface = new EGLSurfaceImpl(value);
        varB4EAC82CA7396A68D541C85D26508E83_1994153405 = mSurface;
        addTaint(readdraw);
        EGLSurface varA7E53CE21691AB073D9660D615818899_189480552; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_189480552 = varB4EAC82CA7396A68D541C85D26508E83_321792421;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_189480552 = varB4EAC82CA7396A68D541C85D26508E83_1994153405;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_189480552.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_189480552;
        // ---------- Original Method ----------
        //int value = _eglGetCurrentSurface(readdraw);
        //if (value == 0) {
            //return EGL10.EGL_NO_SURFACE;
        //}
        //if (mSurface.mEGLSurface != value)
            //mSurface = new EGLSurfaceImpl(value);
        //return mSurface;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.197 -0400", hash_original_method = "00A9769D3FCB2BCA752959A2156960BA", hash_generated_method = "244F90B41948CA1F495A88E482FD1FE8")
    private int _eglCreateContext(EGLDisplay display, EGLConfig config, EGLContext share_context, int[] attrib_list) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1026577504 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1026577504;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.197 -0400", hash_original_method = "9C66F8DAF2CF1DF35D1777997045841F", hash_generated_method = "81A7F373588266A91B8040D13775BFDD")
    private int _eglCreatePbufferSurface(EGLDisplay display, EGLConfig config, int[] attrib_list) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1695900167 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1695900167;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.197 -0400", hash_original_method = "37A0D40F82301EFE54D93A3E184BD2AE", hash_generated_method = "67B71D5B2B8EA12F14EA13A7D4D22EC8")
    private void _eglCreatePixmapSurface(EGLSurface sur, EGLDisplay display, EGLConfig config, Object native_pixmap, int[] attrib_list) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.197 -0400", hash_original_method = "73053A5CE6D69977C0A5A55B454424E0", hash_generated_method = "D3E3D55D3F573A4CBB62CFA4B0D31A34")
    private int _eglCreateWindowSurface(EGLDisplay display, EGLConfig config, Object native_window, int[] attrib_list) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_620531608 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_620531608;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.198 -0400", hash_original_method = "C683AABBDC194C692A1DD6C73D5E2B96", hash_generated_method = "9B6E319610AABFED0B68A2BF41E5E67A")
    private int _eglCreateWindowSurfaceTexture(EGLDisplay display, EGLConfig config, Object native_window, int[] attrib_list) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_695188353 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_695188353;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.198 -0400", hash_original_method = "E8D546530FFFC5C2FC6E86FFB85AACEC", hash_generated_method = "8730731485724C0853921599C5A350D6")
    private int _eglGetDisplay(Object native_display) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1724537452 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1724537452;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.198 -0400", hash_original_method = "37AAAAC75A3E4652292E435C97659047", hash_generated_method = "CB07ACA206C702AC71C6D52941DB7A88")
    private int _eglGetCurrentContext() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1050666198 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1050666198;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.198 -0400", hash_original_method = "AF8954095CE356BE495ED3F59D7027C3", hash_generated_method = "F85C2E1A3F7FD639694A7A733277BE6D")
    private int _eglGetCurrentDisplay() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1019517786 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1019517786;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.209 -0400", hash_original_method = "9F7D143F548ED01AA850BEE267C7749A", hash_generated_method = "7B2997522DBA48435FA6BDC08BEEA402")
    private int _eglGetCurrentSurface(int readdraw) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1644406770 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1644406770;
    }

    
        private static void _nativeClassInit() {
    }

    
    static { _nativeClassInit(); }
    
}

