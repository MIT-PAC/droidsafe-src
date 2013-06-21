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
    private EGLContextImpl mContext = new EGLContextImpl(-1);
    private EGLDisplayImpl mDisplay = new EGLDisplayImpl(-1);
    private EGLSurfaceImpl mSurface = new EGLSurfaceImpl(-1);
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.147 -0400", hash_original_method = "730E3AC92026B1D0D5A931D82442DD59", hash_generated_method = "730E3AC92026B1D0D5A931D82442DD59")
        public EGLImpl ()
    {
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.147 -0400", hash_original_method = "0FE9F08E24E0D2453B9577BF62363101", hash_generated_method = "7CB147AAD6FC3B9EF76725C679F8DA26")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean eglInitialize(EGLDisplay display, int[] major_minor) {
        dsTaint.addTaint(major_minor[0]);
        dsTaint.addTaint(display.dsTaint);
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.148 -0400", hash_original_method = "F079BB68B5D124389F3B0A1B80EDA8E6", hash_generated_method = "A474857211BB79F60D1EB1762E12C5DE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean eglQueryContext(EGLDisplay display, EGLContext context, int attribute, int[] value) {
        dsTaint.addTaint(value[0]);
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(attribute);
        dsTaint.addTaint(display.dsTaint);
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.148 -0400", hash_original_method = "543FE727862E36E7BB38AE92834CF157", hash_generated_method = "2C0A9C2CB3BF3C32B65F90B883340256")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean eglQuerySurface(EGLDisplay display, EGLSurface surface, int attribute, int[] value) {
        dsTaint.addTaint(surface.dsTaint);
        dsTaint.addTaint(value[0]);
        dsTaint.addTaint(attribute);
        dsTaint.addTaint(display.dsTaint);
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.148 -0400", hash_original_method = "BAFD3BC777B3DA03D70496857F209CFE", hash_generated_method = "8F78C3C860ED7FAF34546FCDB7E785E5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean eglReleaseThread() {
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.148 -0400", hash_original_method = "597806537D1EB9D066DEDBB0F5CABF82", hash_generated_method = "48C72E6871191D6E9F49FAB17E99D444")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean eglChooseConfig(EGLDisplay display, int[] attrib_list, EGLConfig[] configs, int config_size, int[] num_config) {
        dsTaint.addTaint(configs[0].dsTaint);
        dsTaint.addTaint(num_config[0]);
        dsTaint.addTaint(attrib_list[0]);
        dsTaint.addTaint(config_size);
        dsTaint.addTaint(display.dsTaint);
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.148 -0400", hash_original_method = "CE0C84B918062E5840E34AEA7F4A16CD", hash_generated_method = "2F7E0BC2D51FFBEFA103D4BCC24F760A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean eglGetConfigAttrib(EGLDisplay display, EGLConfig config, int attribute, int[] value) {
        dsTaint.addTaint(value[0]);
        dsTaint.addTaint(attribute);
        dsTaint.addTaint(config.dsTaint);
        dsTaint.addTaint(display.dsTaint);
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.148 -0400", hash_original_method = "1FF43B35756785946FBC969447AE4429", hash_generated_method = "F5788403C1E1B57C305659998C842C8F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean eglGetConfigs(EGLDisplay display, EGLConfig[] configs, int config_size, int[] num_config) {
        dsTaint.addTaint(configs[0].dsTaint);
        dsTaint.addTaint(num_config[0]);
        dsTaint.addTaint(config_size);
        dsTaint.addTaint(display.dsTaint);
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.148 -0400", hash_original_method = "30167F0B844356CC78AEA2C709085F0A", hash_generated_method = "16E7D325F24C7A2F61520A4FFD901082")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int eglGetError() {
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.149 -0400", hash_original_method = "F2C45513A57BFF3B5C76E0152AB1D6FE", hash_generated_method = "8DD74FF2D20C28718B28C31349EED3FF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean eglDestroyContext(EGLDisplay display, EGLContext context) {
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(display.dsTaint);
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.149 -0400", hash_original_method = "F8BE74B02C97D5EFE0B64C835DE94243", hash_generated_method = "91B4A207DE975F0A4F2A76895C47B9A7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean eglDestroySurface(EGLDisplay display, EGLSurface surface) {
        dsTaint.addTaint(surface.dsTaint);
        dsTaint.addTaint(display.dsTaint);
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.149 -0400", hash_original_method = "D0A5BC4F7F6AC39FDE4C2E9D6BB5947A", hash_generated_method = "2AB6B986B56C1A607C43D34E1D79CFF1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean eglMakeCurrent(EGLDisplay display, EGLSurface draw, EGLSurface read, EGLContext context) {
        dsTaint.addTaint(draw.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(read.dsTaint);
        dsTaint.addTaint(display.dsTaint);
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.149 -0400", hash_original_method = "7F0F6E22A72F3EFD03B53C72B8A334B5", hash_generated_method = "E4B5FA0DD1EFD10DFF8FF500C6DA8B8D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String eglQueryString(EGLDisplay display, int name) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(display.dsTaint);
        return dsTaint.getTaintString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.149 -0400", hash_original_method = "3CBB90A352CD62A4CE70C5B74A91066B", hash_generated_method = "878449309BB88D4435FA87B362773A75")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean eglSwapBuffers(EGLDisplay display, EGLSurface surface) {
        dsTaint.addTaint(surface.dsTaint);
        dsTaint.addTaint(display.dsTaint);
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.149 -0400", hash_original_method = "76CDC4A068B49052D1DE694B54AD997D", hash_generated_method = "080521DB60211AF7ED73CE319B3A0DDB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean eglTerminate(EGLDisplay display) {
        dsTaint.addTaint(display.dsTaint);
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.149 -0400", hash_original_method = "4BC9AB9F0FAFDEDE82B7BBC20123D960", hash_generated_method = "D932BF95E056701820FD13B9CE89858E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean eglCopyBuffers(EGLDisplay display, EGLSurface surface, Object native_pixmap) {
        dsTaint.addTaint(surface.dsTaint);
        dsTaint.addTaint(native_pixmap.dsTaint);
        dsTaint.addTaint(display.dsTaint);
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.149 -0400", hash_original_method = "CC5C6C40253D90C1249B907D63B6D41E", hash_generated_method = "91D19B541C75AE4822D308F22B1FB53E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean eglWaitGL() {
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.150 -0400", hash_original_method = "65BB1CF445260F062394F987EBFCAA01", hash_generated_method = "19BE38BC40086736706C8DF3649AF8B1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean eglWaitNative(int engine, Object bindTarget) {
        dsTaint.addTaint(bindTarget.dsTaint);
        dsTaint.addTaint(engine);
        return dsTaint.getTaintBoolean();
    }

    
        public static int getInitCount(EGLDisplay display) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.150 -0400", hash_original_method = "CAD561FB9C34D7001DB982C1B864CD0D", hash_generated_method = "E674A7179AFC01D7BA3628A98463F293")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public EGLContext eglCreateContext(EGLDisplay display, EGLConfig config, EGLContext share_context, int[] attrib_list) {
        dsTaint.addTaint(share_context.dsTaint);
        dsTaint.addTaint(attrib_list[0]);
        dsTaint.addTaint(config.dsTaint);
        dsTaint.addTaint(display.dsTaint);
        int eglContextId;
        eglContextId = _eglCreateContext(display, config, share_context, attrib_list);
        EGLContext varC6AE7C86F5DEC294AD384012C38608D4_570710146 = (new EGLContextImpl( eglContextId ));
        return (EGLContext)dsTaint.getTaint();
        // ---------- Original Method ----------
        //int eglContextId = _eglCreateContext(display, config, share_context, attrib_list);
        //if (eglContextId == 0) {
            //return EGL10.EGL_NO_CONTEXT;
        //}
        //return new EGLContextImpl( eglContextId );
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.150 -0400", hash_original_method = "E59A00AD2A74A21C0F4005F77A95ED7D", hash_generated_method = "A6065A0D52BBAA4385EDCA29841D26E3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public EGLSurface eglCreatePbufferSurface(EGLDisplay display, EGLConfig config, int[] attrib_list) {
        dsTaint.addTaint(attrib_list[0]);
        dsTaint.addTaint(config.dsTaint);
        dsTaint.addTaint(display.dsTaint);
        int eglSurfaceId;
        eglSurfaceId = _eglCreatePbufferSurface(display, config, attrib_list);
        EGLSurface var87F973EC09E793BBC461A51B5BB49F2B_659517027 = (new EGLSurfaceImpl( eglSurfaceId ));
        return (EGLSurface)dsTaint.getTaint();
        // ---------- Original Method ----------
        //int eglSurfaceId = _eglCreatePbufferSurface(display, config, attrib_list);
        //if (eglSurfaceId == 0) {
            //return EGL10.EGL_NO_SURFACE;
        //}
        //return new EGLSurfaceImpl( eglSurfaceId );
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.151 -0400", hash_original_method = "1913DE6E1812314106CFABA8D0690133", hash_generated_method = "593F4242F71D392B744E9908B401A4B9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public EGLSurface eglCreatePixmapSurface(EGLDisplay display, EGLConfig config, Object native_pixmap, int[] attrib_list) {
        dsTaint.addTaint(attrib_list[0]);
        dsTaint.addTaint(config.dsTaint);
        dsTaint.addTaint(native_pixmap.dsTaint);
        dsTaint.addTaint(display.dsTaint);
        EGLSurfaceImpl sur;
        sur = new EGLSurfaceImpl();
        _eglCreatePixmapSurface(sur, display, config, native_pixmap, attrib_list);
        return (EGLSurface)dsTaint.getTaint();
        // ---------- Original Method ----------
        //EGLSurfaceImpl sur = new EGLSurfaceImpl();
        //_eglCreatePixmapSurface(sur, display, config, native_pixmap, attrib_list);
        //if (sur.mEGLSurface == 0) {
            //return EGL10.EGL_NO_SURFACE;
        //}
        //return sur;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.151 -0400", hash_original_method = "A3C23A2D0F372302CCCB5BF8EDDCD71A", hash_generated_method = "84EB4EFBD3367C1556D0F1D4163F4746")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public EGLSurface eglCreateWindowSurface(EGLDisplay display, EGLConfig config, Object native_window, int[] attrib_list) {
        dsTaint.addTaint(native_window.dsTaint);
        dsTaint.addTaint(attrib_list[0]);
        dsTaint.addTaint(config.dsTaint);
        dsTaint.addTaint(display.dsTaint);
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
        EGLSurface var87F973EC09E793BBC461A51B5BB49F2B_436086559 = (new EGLSurfaceImpl( eglSurfaceId ));
        return (EGLSurface)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.151 -0400", hash_original_method = "BEC2EA85C18256200276555D8D849688", hash_generated_method = "23A40D00FA6DB2CFF42C6C2D8081A0A1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized EGLDisplay eglGetDisplay(Object native_display) {
        dsTaint.addTaint(native_display.dsTaint);
        int value;
        value = _eglGetDisplay(native_display);
        mDisplay = new EGLDisplayImpl(value);
        return (EGLDisplay)dsTaint.getTaint();
        // ---------- Original Method ----------
        //int value = _eglGetDisplay(native_display);
        //if (value == 0) {
            //return EGL10.EGL_NO_DISPLAY;
        //}
        //if (mDisplay.mEGLDisplay != value)
            //mDisplay = new EGLDisplayImpl(value);
        //return mDisplay;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.152 -0400", hash_original_method = "36FE38451D664CBAEEF58B0CA2F2C184", hash_generated_method = "ABC0FE87676D18727D2AE8CEE10E6E5B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized EGLContext eglGetCurrentContext() {
        int value;
        value = _eglGetCurrentContext();
        mContext = new EGLContextImpl(value);
        return (EGLContext)dsTaint.getTaint();
        // ---------- Original Method ----------
        //int value = _eglGetCurrentContext();
        //if (value == 0) {
            //return EGL10.EGL_NO_CONTEXT;
        //}
        //if (mContext.mEGLContext != value)
            //mContext = new EGLContextImpl(value);
        //return mContext;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.152 -0400", hash_original_method = "2AD52C4EA481E23FFE9D610E551D647C", hash_generated_method = "5C0D662B551C37433A979CCB8D6395B8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized EGLDisplay eglGetCurrentDisplay() {
        int value;
        value = _eglGetCurrentDisplay();
        mDisplay = new EGLDisplayImpl(value);
        return (EGLDisplay)dsTaint.getTaint();
        // ---------- Original Method ----------
        //int value = _eglGetCurrentDisplay();
        //if (value == 0) {
            //return EGL10.EGL_NO_DISPLAY;
        //}
        //if (mDisplay.mEGLDisplay != value)
            //mDisplay = new EGLDisplayImpl(value);
        //return mDisplay;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.152 -0400", hash_original_method = "1056D87FF6AF8A6633AE7A0382D42E2B", hash_generated_method = "1B811A96D4BA44C8614484CFC67F6FB0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized EGLSurface eglGetCurrentSurface(int readdraw) {
        dsTaint.addTaint(readdraw);
        int value;
        value = _eglGetCurrentSurface(readdraw);
        mSurface = new EGLSurfaceImpl(value);
        return (EGLSurface)dsTaint.getTaint();
        // ---------- Original Method ----------
        //int value = _eglGetCurrentSurface(readdraw);
        //if (value == 0) {
            //return EGL10.EGL_NO_SURFACE;
        //}
        //if (mSurface.mEGLSurface != value)
            //mSurface = new EGLSurfaceImpl(value);
        //return mSurface;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.152 -0400", hash_original_method = "00A9769D3FCB2BCA752959A2156960BA", hash_generated_method = "516FCC7113D8FD7E2049B54493443B97")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int _eglCreateContext(EGLDisplay display, EGLConfig config, EGLContext share_context, int[] attrib_list) {
        dsTaint.addTaint(share_context.dsTaint);
        dsTaint.addTaint(attrib_list[0]);
        dsTaint.addTaint(config.dsTaint);
        dsTaint.addTaint(display.dsTaint);
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.152 -0400", hash_original_method = "9C66F8DAF2CF1DF35D1777997045841F", hash_generated_method = "001354EA895682678438C77AA02D0519")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int _eglCreatePbufferSurface(EGLDisplay display, EGLConfig config, int[] attrib_list) {
        dsTaint.addTaint(attrib_list[0]);
        dsTaint.addTaint(config.dsTaint);
        dsTaint.addTaint(display.dsTaint);
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.152 -0400", hash_original_method = "37A0D40F82301EFE54D93A3E184BD2AE", hash_generated_method = "FF74D5A8B218DC0D03DAFF57EB5BDFF1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void _eglCreatePixmapSurface(EGLSurface sur, EGLDisplay display, EGLConfig config, Object native_pixmap, int[] attrib_list) {
        dsTaint.addTaint(attrib_list[0]);
        dsTaint.addTaint(sur.dsTaint);
        dsTaint.addTaint(config.dsTaint);
        dsTaint.addTaint(native_pixmap.dsTaint);
        dsTaint.addTaint(display.dsTaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.153 -0400", hash_original_method = "73053A5CE6D69977C0A5A55B454424E0", hash_generated_method = "0F6C8495A9332F20E54E001DDB8E5CBE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int _eglCreateWindowSurface(EGLDisplay display, EGLConfig config, Object native_window, int[] attrib_list) {
        dsTaint.addTaint(native_window.dsTaint);
        dsTaint.addTaint(attrib_list[0]);
        dsTaint.addTaint(config.dsTaint);
        dsTaint.addTaint(display.dsTaint);
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.153 -0400", hash_original_method = "C683AABBDC194C692A1DD6C73D5E2B96", hash_generated_method = "01B7AFA9CF92619330C823A0BCA17755")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int _eglCreateWindowSurfaceTexture(EGLDisplay display, EGLConfig config, Object native_window, int[] attrib_list) {
        dsTaint.addTaint(native_window.dsTaint);
        dsTaint.addTaint(attrib_list[0]);
        dsTaint.addTaint(config.dsTaint);
        dsTaint.addTaint(display.dsTaint);
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.153 -0400", hash_original_method = "E8D546530FFFC5C2FC6E86FFB85AACEC", hash_generated_method = "24214C16E2653FC83F8C714EC2FD843F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int _eglGetDisplay(Object native_display) {
        dsTaint.addTaint(native_display.dsTaint);
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.153 -0400", hash_original_method = "37AAAAC75A3E4652292E435C97659047", hash_generated_method = "AACC1078C0DA163A49D9609F75F9F9FE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int _eglGetCurrentContext() {
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.153 -0400", hash_original_method = "AF8954095CE356BE495ED3F59D7027C3", hash_generated_method = "C8921039FDC5BED92E4D2F95368C9D40")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int _eglGetCurrentDisplay() {
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.153 -0400", hash_original_method = "9F7D143F548ED01AA850BEE267C7749A", hash_generated_method = "D09731F0C2349B725888BFDABD706AA3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int _eglGetCurrentSurface(int readdraw) {
        dsTaint.addTaint(readdraw);
        return dsTaint.getTaintInt();
    }

    
        private static void _nativeClassInit() {
    }

    
    static { _nativeClassInit(); }
    
}

