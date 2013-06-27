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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.755 -0400", hash_original_field = "0F8898C409B0E41427A2E6AA6C67E1EC", hash_generated_field = "299BB99E9FA7B75F06D17EB158F11EC7")

    private EGLContextImpl mContext = new EGLContextImpl(-1);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.756 -0400", hash_original_field = "A8BAED30807DC75517DDAE7C4EFB1286", hash_generated_field = "66FCEFDB57492E5584274D8BC130FFAD")

    private EGLDisplayImpl mDisplay = new EGLDisplayImpl(-1);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.756 -0400", hash_original_field = "A3FE23ED2289FC865AF994EFF579711B", hash_generated_field = "A9E68FD08AADF48015530582ECAAFB47")

    private EGLSurfaceImpl mSurface = new EGLSurfaceImpl(-1);
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.756 -0400", hash_original_method = "1F432E8932AB5EEB87E85C95C31E8080", hash_generated_method = "1F432E8932AB5EEB87E85C95C31E8080")
    public EGLImpl ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.756 -0400", hash_original_method = "0FE9F08E24E0D2453B9577BF62363101", hash_generated_method = "538663A4E6C1B87474A7CE63EC20B8FF")
    public boolean eglInitialize(EGLDisplay display, int[] major_minor) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2059847102 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2059847102;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.756 -0400", hash_original_method = "F079BB68B5D124389F3B0A1B80EDA8E6", hash_generated_method = "E0E3E6BC6475E5BD77A902053938FB77")
    public boolean eglQueryContext(EGLDisplay display, EGLContext context, int attribute, int[] value) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2117699185 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2117699185;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.757 -0400", hash_original_method = "543FE727862E36E7BB38AE92834CF157", hash_generated_method = "7A6571B6F5EDAB4AE7704173EFD22A1E")
    public boolean eglQuerySurface(EGLDisplay display, EGLSurface surface, int attribute, int[] value) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_965223905 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_965223905;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.757 -0400", hash_original_method = "BAFD3BC777B3DA03D70496857F209CFE", hash_generated_method = "85B53246ACB0D2039EE28485159CE44C")
    public boolean eglReleaseThread() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_718476124 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_718476124;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.757 -0400", hash_original_method = "597806537D1EB9D066DEDBB0F5CABF82", hash_generated_method = "25B81A3BDAC3E4823BC3797BDC6AD7B2")
    public boolean eglChooseConfig(EGLDisplay display, int[] attrib_list, EGLConfig[] configs, int config_size, int[] num_config) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_470644053 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_470644053;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.757 -0400", hash_original_method = "CE0C84B918062E5840E34AEA7F4A16CD", hash_generated_method = "080DCE9D846335A8D3FBF54987317842")
    public boolean eglGetConfigAttrib(EGLDisplay display, EGLConfig config, int attribute, int[] value) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2135055764 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2135055764;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.771 -0400", hash_original_method = "1FF43B35756785946FBC969447AE4429", hash_generated_method = "D1532BD7E1BF199A4EE0EDEEF3B6DD28")
    public boolean eglGetConfigs(EGLDisplay display, EGLConfig[] configs, int config_size, int[] num_config) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1115364218 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1115364218;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.771 -0400", hash_original_method = "30167F0B844356CC78AEA2C709085F0A", hash_generated_method = "DD31C818BA91D311B8F11CDC734F2971")
    public int eglGetError() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1049865098 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1049865098;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.771 -0400", hash_original_method = "F2C45513A57BFF3B5C76E0152AB1D6FE", hash_generated_method = "C02B1E814E9C908D15E628DD0E681EF1")
    public boolean eglDestroyContext(EGLDisplay display, EGLContext context) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_177193044 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_177193044;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.772 -0400", hash_original_method = "F8BE74B02C97D5EFE0B64C835DE94243", hash_generated_method = "D56EFAC955D233BDC382DD4AFAEF63D6")
    public boolean eglDestroySurface(EGLDisplay display, EGLSurface surface) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1916434041 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1916434041;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.773 -0400", hash_original_method = "D0A5BC4F7F6AC39FDE4C2E9D6BB5947A", hash_generated_method = "F48488131E828D7F70E5FD1BDC0D954C")
    public boolean eglMakeCurrent(EGLDisplay display, EGLSurface draw, EGLSurface read, EGLContext context) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1523347898 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1523347898;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.773 -0400", hash_original_method = "7F0F6E22A72F3EFD03B53C72B8A334B5", hash_generated_method = "FD75A226178BC0A876B19864D0D93C7A")
    public String eglQueryString(EGLDisplay display, int name) {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.773 -0400", hash_original_method = "3CBB90A352CD62A4CE70C5B74A91066B", hash_generated_method = "955036E403974925897F80682A75310A")
    public boolean eglSwapBuffers(EGLDisplay display, EGLSurface surface) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1622488613 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1622488613;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.779 -0400", hash_original_method = "76CDC4A068B49052D1DE694B54AD997D", hash_generated_method = "28EAA5994074F4593401B63D865B1146")
    public boolean eglTerminate(EGLDisplay display) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1606303428 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1606303428;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.779 -0400", hash_original_method = "4BC9AB9F0FAFDEDE82B7BBC20123D960", hash_generated_method = "DD6A34374AAF53865EA18899FD5A0054")
    public boolean eglCopyBuffers(EGLDisplay display, EGLSurface surface, Object native_pixmap) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1584786271 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1584786271;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.780 -0400", hash_original_method = "CC5C6C40253D90C1249B907D63B6D41E", hash_generated_method = "46E782E33FEEC74675DEECDAD12E621E")
    public boolean eglWaitGL() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1337187687 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1337187687;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.780 -0400", hash_original_method = "65BB1CF445260F062394F987EBFCAA01", hash_generated_method = "D5417EC201E28E86BCCFE69AFFC91A05")
    public boolean eglWaitNative(int engine, Object bindTarget) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_811875541 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_811875541;
    }

    
        public static int getInitCount(EGLDisplay display) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.784 -0400", hash_original_method = "CAD561FB9C34D7001DB982C1B864CD0D", hash_generated_method = "8E0B76E66D0012DAB600534AA27C2A25")
    public EGLContext eglCreateContext(EGLDisplay display, EGLConfig config, EGLContext share_context, int[] attrib_list) {
        EGLContext varB4EAC82CA7396A68D541C85D26508E83_703290734 = null; //Variable for return #1
        EGLContext varB4EAC82CA7396A68D541C85D26508E83_988763777 = null; //Variable for return #2
        int eglContextId;
        eglContextId = _eglCreateContext(display, config, share_context, attrib_list);
        {
            varB4EAC82CA7396A68D541C85D26508E83_703290734 = EGL10.EGL_NO_CONTEXT;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_988763777 = new EGLContextImpl( eglContextId );
        addTaint(display.getTaint());
        addTaint(config.getTaint());
        addTaint(share_context.getTaint());
        addTaint(attrib_list[0]);
        EGLContext varA7E53CE21691AB073D9660D615818899_2021757784; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2021757784 = varB4EAC82CA7396A68D541C85D26508E83_703290734;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2021757784 = varB4EAC82CA7396A68D541C85D26508E83_988763777;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2021757784.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2021757784;
        // ---------- Original Method ----------
        //int eglContextId = _eglCreateContext(display, config, share_context, attrib_list);
        //if (eglContextId == 0) {
            //return EGL10.EGL_NO_CONTEXT;
        //}
        //return new EGLContextImpl( eglContextId );
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.790 -0400", hash_original_method = "E59A00AD2A74A21C0F4005F77A95ED7D", hash_generated_method = "F3C354C0862764FD837F8D4BB6A8EAA2")
    public EGLSurface eglCreatePbufferSurface(EGLDisplay display, EGLConfig config, int[] attrib_list) {
        EGLSurface varB4EAC82CA7396A68D541C85D26508E83_691823854 = null; //Variable for return #1
        EGLSurface varB4EAC82CA7396A68D541C85D26508E83_1552294505 = null; //Variable for return #2
        int eglSurfaceId;
        eglSurfaceId = _eglCreatePbufferSurface(display, config, attrib_list);
        {
            varB4EAC82CA7396A68D541C85D26508E83_691823854 = EGL10.EGL_NO_SURFACE;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1552294505 = new EGLSurfaceImpl( eglSurfaceId );
        addTaint(display.getTaint());
        addTaint(config.getTaint());
        addTaint(attrib_list[0]);
        EGLSurface varA7E53CE21691AB073D9660D615818899_891433176; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_891433176 = varB4EAC82CA7396A68D541C85D26508E83_691823854;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_891433176 = varB4EAC82CA7396A68D541C85D26508E83_1552294505;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_891433176.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_891433176;
        // ---------- Original Method ----------
        //int eglSurfaceId = _eglCreatePbufferSurface(display, config, attrib_list);
        //if (eglSurfaceId == 0) {
            //return EGL10.EGL_NO_SURFACE;
        //}
        //return new EGLSurfaceImpl( eglSurfaceId );
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.795 -0400", hash_original_method = "1913DE6E1812314106CFABA8D0690133", hash_generated_method = "C10BDCE86A17B7F2B7281B7EFD22FFAC")
    public EGLSurface eglCreatePixmapSurface(EGLDisplay display, EGLConfig config, Object native_pixmap, int[] attrib_list) {
        EGLSurface varB4EAC82CA7396A68D541C85D26508E83_591840882 = null; //Variable for return #1
        EGLSurface varB4EAC82CA7396A68D541C85D26508E83_1949793846 = null; //Variable for return #2
        EGLSurfaceImpl sur;
        sur = new EGLSurfaceImpl();
        _eglCreatePixmapSurface(sur, display, config, native_pixmap, attrib_list);
        {
            varB4EAC82CA7396A68D541C85D26508E83_591840882 = EGL10.EGL_NO_SURFACE;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1949793846 = sur;
        addTaint(display.getTaint());
        addTaint(config.getTaint());
        addTaint(native_pixmap.getTaint());
        addTaint(attrib_list[0]);
        EGLSurface varA7E53CE21691AB073D9660D615818899_54258717; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_54258717 = varB4EAC82CA7396A68D541C85D26508E83_591840882;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_54258717 = varB4EAC82CA7396A68D541C85D26508E83_1949793846;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_54258717.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_54258717;
        // ---------- Original Method ----------
        //EGLSurfaceImpl sur = new EGLSurfaceImpl();
        //_eglCreatePixmapSurface(sur, display, config, native_pixmap, attrib_list);
        //if (sur.mEGLSurface == 0) {
            //return EGL10.EGL_NO_SURFACE;
        //}
        //return sur;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.805 -0400", hash_original_method = "A3C23A2D0F372302CCCB5BF8EDDCD71A", hash_generated_method = "EB240D5E0A61CCCABD04FD7144D50441")
    public EGLSurface eglCreateWindowSurface(EGLDisplay display, EGLConfig config, Object native_window, int[] attrib_list) {
        EGLSurface varB4EAC82CA7396A68D541C85D26508E83_929606495 = null; //Variable for return #1
        EGLSurface varB4EAC82CA7396A68D541C85D26508E83_899889800 = null; //Variable for return #2
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
            varB4EAC82CA7396A68D541C85D26508E83_929606495 = EGL10.EGL_NO_SURFACE;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_899889800 = new EGLSurfaceImpl( eglSurfaceId );
        addTaint(display.getTaint());
        addTaint(config.getTaint());
        addTaint(native_window.getTaint());
        addTaint(attrib_list[0]);
        EGLSurface varA7E53CE21691AB073D9660D615818899_133696761; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_133696761 = varB4EAC82CA7396A68D541C85D26508E83_929606495;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_133696761 = varB4EAC82CA7396A68D541C85D26508E83_899889800;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_133696761.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_133696761;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.810 -0400", hash_original_method = "BEC2EA85C18256200276555D8D849688", hash_generated_method = "A39C720AF2A4287396E6078AEE392CBC")
    public synchronized EGLDisplay eglGetDisplay(Object native_display) {
        EGLDisplay varB4EAC82CA7396A68D541C85D26508E83_1141087080 = null; //Variable for return #1
        EGLDisplay varB4EAC82CA7396A68D541C85D26508E83_111790355 = null; //Variable for return #2
        int value;
        value = _eglGetDisplay(native_display);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1141087080 = EGL10.EGL_NO_DISPLAY;
        } //End block
        mDisplay = new EGLDisplayImpl(value);
        varB4EAC82CA7396A68D541C85D26508E83_111790355 = mDisplay;
        addTaint(native_display.getTaint());
        EGLDisplay varA7E53CE21691AB073D9660D615818899_1134178297; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1134178297 = varB4EAC82CA7396A68D541C85D26508E83_1141087080;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1134178297 = varB4EAC82CA7396A68D541C85D26508E83_111790355;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1134178297.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1134178297;
        // ---------- Original Method ----------
        //int value = _eglGetDisplay(native_display);
        //if (value == 0) {
            //return EGL10.EGL_NO_DISPLAY;
        //}
        //if (mDisplay.mEGLDisplay != value)
            //mDisplay = new EGLDisplayImpl(value);
        //return mDisplay;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.811 -0400", hash_original_method = "36FE38451D664CBAEEF58B0CA2F2C184", hash_generated_method = "D40732F8F1B519EDBCF888DB3B2BD454")
    public synchronized EGLContext eglGetCurrentContext() {
        EGLContext varB4EAC82CA7396A68D541C85D26508E83_1615129212 = null; //Variable for return #1
        EGLContext varB4EAC82CA7396A68D541C85D26508E83_434106941 = null; //Variable for return #2
        int value;
        value = _eglGetCurrentContext();
        {
            varB4EAC82CA7396A68D541C85D26508E83_1615129212 = EGL10.EGL_NO_CONTEXT;
        } //End block
        mContext = new EGLContextImpl(value);
        varB4EAC82CA7396A68D541C85D26508E83_434106941 = mContext;
        EGLContext varA7E53CE21691AB073D9660D615818899_1376292701; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1376292701 = varB4EAC82CA7396A68D541C85D26508E83_1615129212;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1376292701 = varB4EAC82CA7396A68D541C85D26508E83_434106941;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1376292701.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1376292701;
        // ---------- Original Method ----------
        //int value = _eglGetCurrentContext();
        //if (value == 0) {
            //return EGL10.EGL_NO_CONTEXT;
        //}
        //if (mContext.mEGLContext != value)
            //mContext = new EGLContextImpl(value);
        //return mContext;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.820 -0400", hash_original_method = "2AD52C4EA481E23FFE9D610E551D647C", hash_generated_method = "2BFE1273149DAA6AC8AA61021E3F6DF1")
    public synchronized EGLDisplay eglGetCurrentDisplay() {
        EGLDisplay varB4EAC82CA7396A68D541C85D26508E83_1895372792 = null; //Variable for return #1
        EGLDisplay varB4EAC82CA7396A68D541C85D26508E83_445962050 = null; //Variable for return #2
        int value;
        value = _eglGetCurrentDisplay();
        {
            varB4EAC82CA7396A68D541C85D26508E83_1895372792 = EGL10.EGL_NO_DISPLAY;
        } //End block
        mDisplay = new EGLDisplayImpl(value);
        varB4EAC82CA7396A68D541C85D26508E83_445962050 = mDisplay;
        EGLDisplay varA7E53CE21691AB073D9660D615818899_1801562415; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1801562415 = varB4EAC82CA7396A68D541C85D26508E83_1895372792;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1801562415 = varB4EAC82CA7396A68D541C85D26508E83_445962050;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1801562415.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1801562415;
        // ---------- Original Method ----------
        //int value = _eglGetCurrentDisplay();
        //if (value == 0) {
            //return EGL10.EGL_NO_DISPLAY;
        //}
        //if (mDisplay.mEGLDisplay != value)
            //mDisplay = new EGLDisplayImpl(value);
        //return mDisplay;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.821 -0400", hash_original_method = "1056D87FF6AF8A6633AE7A0382D42E2B", hash_generated_method = "40C53799D29792BF135C557B33B40B4D")
    public synchronized EGLSurface eglGetCurrentSurface(int readdraw) {
        EGLSurface varB4EAC82CA7396A68D541C85D26508E83_1746420351 = null; //Variable for return #1
        EGLSurface varB4EAC82CA7396A68D541C85D26508E83_826557084 = null; //Variable for return #2
        int value;
        value = _eglGetCurrentSurface(readdraw);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1746420351 = EGL10.EGL_NO_SURFACE;
        } //End block
        mSurface = new EGLSurfaceImpl(value);
        varB4EAC82CA7396A68D541C85D26508E83_826557084 = mSurface;
        addTaint(readdraw);
        EGLSurface varA7E53CE21691AB073D9660D615818899_1766500534; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1766500534 = varB4EAC82CA7396A68D541C85D26508E83_1746420351;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1766500534 = varB4EAC82CA7396A68D541C85D26508E83_826557084;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1766500534.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1766500534;
        // ---------- Original Method ----------
        //int value = _eglGetCurrentSurface(readdraw);
        //if (value == 0) {
            //return EGL10.EGL_NO_SURFACE;
        //}
        //if (mSurface.mEGLSurface != value)
            //mSurface = new EGLSurfaceImpl(value);
        //return mSurface;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.822 -0400", hash_original_method = "00A9769D3FCB2BCA752959A2156960BA", hash_generated_method = "9669DF38B35E87D68713956B1DF91E03")
    private int _eglCreateContext(EGLDisplay display, EGLConfig config, EGLContext share_context, int[] attrib_list) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1909006540 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1909006540;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.822 -0400", hash_original_method = "9C66F8DAF2CF1DF35D1777997045841F", hash_generated_method = "7A44BDA773B3BEBEA1EAB52A704EB9C9")
    private int _eglCreatePbufferSurface(EGLDisplay display, EGLConfig config, int[] attrib_list) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1423535636 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1423535636;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.822 -0400", hash_original_method = "37A0D40F82301EFE54D93A3E184BD2AE", hash_generated_method = "67B71D5B2B8EA12F14EA13A7D4D22EC8")
    private void _eglCreatePixmapSurface(EGLSurface sur, EGLDisplay display, EGLConfig config, Object native_pixmap, int[] attrib_list) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.823 -0400", hash_original_method = "73053A5CE6D69977C0A5A55B454424E0", hash_generated_method = "800BD723BCCCC3C543FE42977C2311FC")
    private int _eglCreateWindowSurface(EGLDisplay display, EGLConfig config, Object native_window, int[] attrib_list) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_620594777 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_620594777;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.836 -0400", hash_original_method = "C683AABBDC194C692A1DD6C73D5E2B96", hash_generated_method = "B5ABF3A68085D350275716D5935C29E5")
    private int _eglCreateWindowSurfaceTexture(EGLDisplay display, EGLConfig config, Object native_window, int[] attrib_list) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_672735523 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_672735523;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.836 -0400", hash_original_method = "E8D546530FFFC5C2FC6E86FFB85AACEC", hash_generated_method = "BC30F6EB0325E71709551308D3D75800")
    private int _eglGetDisplay(Object native_display) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_959511651 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_959511651;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.837 -0400", hash_original_method = "37AAAAC75A3E4652292E435C97659047", hash_generated_method = "105B250F1121667B69DDCFA363EFCD36")
    private int _eglGetCurrentContext() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_24412266 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_24412266;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.837 -0400", hash_original_method = "AF8954095CE356BE495ED3F59D7027C3", hash_generated_method = "E2624156202111D4FA3D7B160C55C2E7")
    private int _eglGetCurrentDisplay() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_725495648 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_725495648;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:28.837 -0400", hash_original_method = "9F7D143F548ED01AA850BEE267C7749A", hash_generated_method = "C4EC83959A8086F883FFE8E5112B5579")
    private int _eglGetCurrentSurface(int readdraw) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2012571961 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2012571961;
    }

    
        private static void _nativeClassInit() {
    }

    
    static { _nativeClassInit(); }
    
}

