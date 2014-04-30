package com.google.android.gles_jni;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
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
    
    public static int getInitCount(EGLDisplay display) {
        return display.getTaintInt();
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void _nativeClassInit() {
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:16.339 -0500", hash_original_field = "5165D24D9AE870029D7EE629BD62CEFE", hash_generated_field = "299BB99E9FA7B75F06D17EB158F11EC7")

    private EGLContextImpl mContext = new EGLContextImpl(-1);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:16.342 -0500", hash_original_field = "A2C9810716DCFCA2FB1EAF251BE99C6D", hash_generated_field = "66FCEFDB57492E5584274D8BC130FFAD")

    private EGLDisplayImpl mDisplay = new EGLDisplayImpl(-1);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:16.344 -0500", hash_original_field = "480FD1083ADA07E31B6EC520C084DF12", hash_generated_field = "A9E68FD08AADF48015530582ECAAFB47")

    private EGLSurfaceImpl mSurface = new EGLSurfaceImpl(-1);
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.539 -0400", hash_original_method = "1F432E8932AB5EEB87E85C95C31E8080", hash_generated_method = "1F432E8932AB5EEB87E85C95C31E8080")
    public EGLImpl ()
    {
        //Synthesized constructor
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:16.348 -0500", hash_original_method = "0FE9F08E24E0D2453B9577BF62363101", hash_generated_method = "2DF7B7AD6E2DE93937DF846C98B61A13")
    
    public boolean     eglInitialize(EGLDisplay display, int[] major_minor){
    	//Formerly a native method
    	addTaint(display.getTaint());
    	addTaint(major_minor[0]);
    	return getTaintBoolean();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:16.353 -0500", hash_original_method = "F079BB68B5D124389F3B0A1B80EDA8E6", hash_generated_method = "93FEC887B93138DD2A9B628EE1074A03")
    
    public boolean     eglQueryContext(EGLDisplay display, EGLContext context, int attribute, int[] value){
    	//Formerly a native method
    	addTaint(display.getTaint());
    	addTaint(context.getTaint());
    	addTaint(attribute);
    	addTaint(value[0]);
    	return getTaintBoolean();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:16.357 -0500", hash_original_method = "543FE727862E36E7BB38AE92834CF157", hash_generated_method = "57BDD51EBAF6D631AB3C56F35C913AE0")
    
    public boolean     eglQuerySurface(EGLDisplay display, EGLSurface surface, int attribute, int[] value){
    	//Formerly a native method
    	addTaint(display.getTaint());
    	addTaint(surface.getTaint());
    	addTaint(attribute);
    	addTaint(value[0]);
    	return getTaintBoolean();
    }

    /** @hide **/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:16.360 -0500", hash_original_method = "BAFD3BC777B3DA03D70496857F209CFE", hash_generated_method = "83C3CE08C82C35139A22FB3998C1D64F")
    
    public boolean     eglReleaseThread(){
    	//Formerly a native method
    	return getTaintBoolean();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:16.364 -0500", hash_original_method = "597806537D1EB9D066DEDBB0F5CABF82", hash_generated_method = "F9B0B0EE8EEF022FEA46A5A148EC5EE1")
    
    public boolean     eglChooseConfig(EGLDisplay display, int[] attrib_list, EGLConfig[] configs, int config_size, int[] num_config){
    	//Formerly a native method
    	addTaint(display.getTaint());
    	addTaint(attrib_list[0]);
    	addTaint(configs[0].getTaint());
    	addTaint(config_size);
    	addTaint(num_config[0]);
    	return getTaintBoolean();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:16.368 -0500", hash_original_method = "CE0C84B918062E5840E34AEA7F4A16CD", hash_generated_method = "3449B299B0006576EBBA26DD085DFFEC")
    
    public boolean     eglGetConfigAttrib(EGLDisplay display, EGLConfig config, int attribute, int[] value){
    	//Formerly a native method
    	addTaint(display.getTaint());
    	addTaint(config.getTaint());
    	addTaint(attribute);
    	addTaint(value[0]);
    	return getTaintBoolean();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:16.372 -0500", hash_original_method = "1FF43B35756785946FBC969447AE4429", hash_generated_method = "C289FD7A9CAC81693FF15406E6B32690")
    
    public boolean     eglGetConfigs(EGLDisplay display, EGLConfig[] configs, int config_size, int[] num_config){
    	//Formerly a native method
    	addTaint(display.getTaint());
    	addTaint(configs[0].getTaint());
    	addTaint(config_size);
    	addTaint(num_config[0]);
    	return getTaintBoolean();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:16.376 -0500", hash_original_method = "30167F0B844356CC78AEA2C709085F0A", hash_generated_method = "97001DA94BF07311688B46B6470E11E5")
    
    public int         eglGetError(){
    	//Formerly a native method
    	return getTaintInt();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:16.380 -0500", hash_original_method = "F2C45513A57BFF3B5C76E0152AB1D6FE", hash_generated_method = "DD976DED76E20815A49CC0DC51F1BCDD")
    
    public boolean     eglDestroyContext(EGLDisplay display, EGLContext context){
    	//Formerly a native method
    	addTaint(display.getTaint());
    	addTaint(context.getTaint());
    	return getTaintBoolean();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:16.384 -0500", hash_original_method = "F8BE74B02C97D5EFE0B64C835DE94243", hash_generated_method = "7BB38243A056BAD7E31B25917FA5A161")
    
    public boolean     eglDestroySurface(EGLDisplay display, EGLSurface surface){
    	//Formerly a native method
    	addTaint(display.getTaint());
    	addTaint(surface.getTaint());
    	return getTaintBoolean();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:16.388 -0500", hash_original_method = "D0A5BC4F7F6AC39FDE4C2E9D6BB5947A", hash_generated_method = "67E24BB4C51F767EC1149075FE0D96C8")
    
    public boolean     eglMakeCurrent(EGLDisplay display, EGLSurface draw, EGLSurface read, EGLContext context){
    	//Formerly a native method
    	addTaint(display.getTaint());
    	addTaint(draw.getTaint());
    	addTaint(read.getTaint());
    	addTaint(context.getTaint());
    	return getTaintBoolean();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.388 -0400", hash_original_method = "7F0F6E22A72F3EFD03B53C72B8A334B5", hash_generated_method = "FD75A226178BC0A876B19864D0D93C7A")
    public String eglQueryString(EGLDisplay display, int name) {
    	addTaint(display.getTaint());
    	addTaint(name);
    	String s = new String();
    	s.addTaint(getTaint());
    	return s;
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:16.396 -0500", hash_original_method = "3CBB90A352CD62A4CE70C5B74A91066B", hash_generated_method = "1120ADA1C3ACB2D19833DADC9E26C64A")
    
    public boolean     eglSwapBuffers(EGLDisplay display, EGLSurface surface){
    	//Formerly a native method
    	addTaint(display.getTaint());
    	addTaint(surface.getTaint());
    	return getTaintBoolean();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:16.400 -0500", hash_original_method = "76CDC4A068B49052D1DE694B54AD997D", hash_generated_method = "8945904B6CDB57CFC6A015028FA7A638")
    
    public boolean     eglTerminate(EGLDisplay display){
    	//Formerly a native method
    	addTaint(display.getTaint());
    	return getTaintBoolean();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:16.404 -0500", hash_original_method = "4BC9AB9F0FAFDEDE82B7BBC20123D960", hash_generated_method = "3DBDB7C376D519DEE7688C4D9E9259E5")
    
    public boolean     eglCopyBuffers(EGLDisplay display, EGLSurface surface, Object native_pixmap){
    	//Formerly a native method
    	addTaint(display.getTaint());
    	addTaint(surface.getTaint());
    	addTaint(native_pixmap.getTaint());
    	return getTaintBoolean();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:16.407 -0500", hash_original_method = "CC5C6C40253D90C1249B907D63B6D41E", hash_generated_method = "54A78BAD8CCD73ADA3E17904BD5ECFE7")
    
    public boolean     eglWaitGL(){
    	//Formerly a native method
    	return getTaintBoolean();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:16.411 -0500", hash_original_method = "65BB1CF445260F062394F987EBFCAA01", hash_generated_method = "58420BB4FB31537F0E078987F9EE5C53")
    
    public boolean     eglWaitNative(int engine, Object bindTarget){
    	//Formerly a native method
    	addTaint(engine);
    	addTaint(bindTarget.getTaint());
    	return getTaintBoolean();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:16.419 -0500", hash_original_method = "CAD561FB9C34D7001DB982C1B864CD0D", hash_generated_method = "40CAA5A85A69A3E707B97DBF7CF008B6")
    
public EGLContext eglCreateContext(EGLDisplay display, EGLConfig config, EGLContext share_context, int[] attrib_list) {
        int eglContextId = _eglCreateContext(display, config, share_context, attrib_list);
        if (eglContextId == 0) {
            return EGL10.EGL_NO_CONTEXT;
        }
        return new EGLContextImpl( eglContextId );
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:16.422 -0500", hash_original_method = "E59A00AD2A74A21C0F4005F77A95ED7D", hash_generated_method = "15F20FB38DC23CBB9CFDAD083B025BE8")
    
public EGLSurface eglCreatePbufferSurface(EGLDisplay display, EGLConfig config, int[] attrib_list) {
        int eglSurfaceId = _eglCreatePbufferSurface(display, config, attrib_list);
        if (eglSurfaceId == 0) {
            return EGL10.EGL_NO_SURFACE;
        }
        return new EGLSurfaceImpl( eglSurfaceId );
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:16.424 -0500", hash_original_method = "1913DE6E1812314106CFABA8D0690133", hash_generated_method = "FE9C426E3E086ED3F58207B78D44A14D")
    
public EGLSurface eglCreatePixmapSurface(EGLDisplay display, EGLConfig config, Object native_pixmap, int[] attrib_list) {
        EGLSurfaceImpl sur = new EGLSurfaceImpl();
        _eglCreatePixmapSurface(sur, display, config, native_pixmap, attrib_list);
        if (sur.mEGLSurface == 0) {
            return EGL10.EGL_NO_SURFACE;
        }
        return sur;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:16.427 -0500", hash_original_method = "A3C23A2D0F372302CCCB5BF8EDDCD71A", hash_generated_method = "2D10854F118DC8778C21CEEFA1271F97")
    
public EGLSurface eglCreateWindowSurface(EGLDisplay display, EGLConfig config, Object native_window, int[] attrib_list) {
        Surface sur = null;
        if (native_window instanceof SurfaceView) {
            SurfaceView surfaceView = (SurfaceView)native_window;
            sur = surfaceView.getHolder().getSurface();
        } else if (native_window instanceof SurfaceHolder) {
            SurfaceHolder holder = (SurfaceHolder)native_window;
            sur = holder.getSurface();
        }

        int eglSurfaceId;
        if (sur != null) {
            eglSurfaceId = _eglCreateWindowSurface(display, config, sur, attrib_list);
        } else if (native_window instanceof SurfaceTexture) {
            eglSurfaceId = _eglCreateWindowSurfaceTexture(display, config,
                    native_window, attrib_list);
        } else {
            throw new java.lang.UnsupportedOperationException(
                "eglCreateWindowSurface() can only be called with an instance of " +
                "SurfaceView, SurfaceHolder or SurfaceTexture at the moment, " + 
                "this will be fixed later.");
        }

        if (eglSurfaceId == 0) {
            return EGL10.EGL_NO_SURFACE;
        }
        return new EGLSurfaceImpl( eglSurfaceId );
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:16.430 -0500", hash_original_method = "BEC2EA85C18256200276555D8D849688", hash_generated_method = "3FCC562214E68C5DCCB754FCB76DC7AE")
    
public synchronized EGLDisplay eglGetDisplay(Object native_display) {
        int value = _eglGetDisplay(native_display);
        if (value == 0) {
            return EGL10.EGL_NO_DISPLAY;
        }
        if (mDisplay.mEGLDisplay != value)
            mDisplay = new EGLDisplayImpl(value);
        return mDisplay;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:16.432 -0500", hash_original_method = "36FE38451D664CBAEEF58B0CA2F2C184", hash_generated_method = "9EE0761BF8BF4EC15EEA7972936FE961")
    
public synchronized EGLContext eglGetCurrentContext() {
        int value = _eglGetCurrentContext();
        if (value == 0) {
            return EGL10.EGL_NO_CONTEXT;
        }
        if (mContext.mEGLContext != value)
            mContext = new EGLContextImpl(value);
        return mContext;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:16.435 -0500", hash_original_method = "2AD52C4EA481E23FFE9D610E551D647C", hash_generated_method = "FE279BF5A0AB3180B3D72A534F2FB8A5")
    
public synchronized EGLDisplay eglGetCurrentDisplay() {
        int value = _eglGetCurrentDisplay();
        if (value == 0) {
            return EGL10.EGL_NO_DISPLAY;
        }
        if (mDisplay.mEGLDisplay != value)
            mDisplay = new EGLDisplayImpl(value);
        return mDisplay;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:16.438 -0500", hash_original_method = "1056D87FF6AF8A6633AE7A0382D42E2B", hash_generated_method = "65B1FC1FEB5511F5845A8192EA9F0A4F")
    
public synchronized EGLSurface eglGetCurrentSurface(int readdraw) {
        int value = _eglGetCurrentSurface(readdraw);
        if (value == 0) {
            return EGL10.EGL_NO_SURFACE;
        }
        if (mSurface.mEGLSurface != value)
            mSurface = new EGLSurfaceImpl(value);
        return mSurface;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:16.442 -0500", hash_original_method = "00A9769D3FCB2BCA752959A2156960BA", hash_generated_method = "123FF23E2FD831FD5E2A58B0E9D2D78B")
    
    private int _eglCreateContext(EGLDisplay display, EGLConfig config, EGLContext share_context, int[] attrib_list){
    	//Formerly a native method
    	addTaint(display.getTaint());
    	addTaint(config.getTaint());
    	addTaint(share_context.getTaint());
    	addTaint(attrib_list[0]);
    	return getTaintInt();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:16.446 -0500", hash_original_method = "9C66F8DAF2CF1DF35D1777997045841F", hash_generated_method = "304FFBB8322DF481D9B4DB907382C74F")
    
    private int _eglCreatePbufferSurface(EGLDisplay display, EGLConfig config, int[] attrib_list){
    	//Formerly a native method
    	addTaint(display.getTaint());
    	addTaint(config.getTaint());
    	addTaint(attrib_list[0]);
    	return getTaintInt();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:16.450 -0500", hash_original_method = "37A0D40F82301EFE54D93A3E184BD2AE", hash_generated_method = "2D549B823D2F4395A5965FD7E2C89934")
    
    private void _eglCreatePixmapSurface(EGLSurface sur, EGLDisplay display, EGLConfig config, Object native_pixmap, int[] attrib_list){
    	//Formerly a native method
    	addTaint(sur.getTaint());
    	addTaint(display.getTaint());
    	addTaint(config.getTaint());
    	addTaint(native_pixmap.getTaint());
    	addTaint(attrib_list[0]);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:16.453 -0500", hash_original_method = "73053A5CE6D69977C0A5A55B454424E0", hash_generated_method = "6B132B10DF019C1CD66329E9D1551E6C")
    
    private int _eglCreateWindowSurface(EGLDisplay display, EGLConfig config, Object native_window, int[] attrib_list){
    	//Formerly a native method
    	addTaint(display.getTaint());
    	addTaint(config.getTaint());
    	addTaint(native_window.getTaint());
    	addTaint(attrib_list[0]);
    	return getTaintInt();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:16.457 -0500", hash_original_method = "C683AABBDC194C692A1DD6C73D5E2B96", hash_generated_method = "034A3E5F20A85D7E705348D3C7653ED2")
    
    private int _eglCreateWindowSurfaceTexture(EGLDisplay display, EGLConfig config, Object native_window, int[] attrib_list){
    	//Formerly a native method
    	addTaint(display.getTaint());
    	addTaint(config.getTaint());
    	addTaint(native_window.getTaint());
    	addTaint(attrib_list[0]);
    	return getTaintInt();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:16.462 -0500", hash_original_method = "E8D546530FFFC5C2FC6E86FFB85AACEC", hash_generated_method = "8D9CE2FDC7E6CD726BBA9CB740736852")
    
    private int _eglGetDisplay(Object native_display){
    	//Formerly a native method
    	addTaint(native_display.getTaint());
    	return getTaintInt();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:16.466 -0500", hash_original_method = "37AAAAC75A3E4652292E435C97659047", hash_generated_method = "DF49315663E2606797D4BA6FB493CF14")
    
    private int _eglGetCurrentContext(){
    	//Formerly a native method
    	return getTaintInt();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:16.469 -0500", hash_original_method = "AF8954095CE356BE495ED3F59D7027C3", hash_generated_method = "8A9F04088767B77C663624B119E15A53")
    
    private int _eglGetCurrentDisplay(){
    	//Formerly a native method
    	return getTaintInt();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:16.473 -0500", hash_original_method = "9F7D143F548ED01AA850BEE267C7749A", hash_generated_method = "E85BF49E3DFC46CE31DBCAF92AE4181B")
    
    private int _eglGetCurrentSurface(int readdraw){
    	//Formerly a native method
    	addTaint(readdraw);
    	return getTaintInt();
    }
    
    static { _nativeClassInit(); }
    
}

