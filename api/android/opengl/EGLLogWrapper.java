package android.opengl;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.Writer;

import javax.microedition.khronos.egl.EGL;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGL11;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;






class EGLLogWrapper implements EGL11 {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:15.389 -0500", hash_original_method = "1FA182FB3F670562E4832FF4C2B7A9B2", hash_generated_method = "2B68B6DC957DD24336BF67343B92A433")
    
private static String getHex(int value) {
        return "0x" + Integer.toHexString(value);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:15.392 -0500", hash_original_method = "6FF96C265784B388B5A58A296B34ADB3", hash_generated_method = "62CA0759BF5695C95A9FAB2181044BA5")
    
public static String getErrorString(int error) {
        switch (error) {
        case EGL_SUCCESS:
            return "EGL_SUCCESS";
        case EGL_NOT_INITIALIZED:
            return "EGL_NOT_INITIALIZED";
        case EGL_BAD_ACCESS:
            return "EGL_BAD_ACCESS";
        case EGL_BAD_ALLOC:
            return "EGL_BAD_ALLOC";
        case EGL_BAD_ATTRIBUTE:
            return "EGL_BAD_ATTRIBUTE";
        case EGL_BAD_CONFIG:
            return "EGL_BAD_CONFIG";
        case EGL_BAD_CONTEXT:
            return "EGL_BAD_CONTEXT";
        case EGL_BAD_CURRENT_SURFACE:
            return "EGL_BAD_CURRENT_SURFACE";
        case EGL_BAD_DISPLAY:
            return "EGL_BAD_DISPLAY";
        case EGL_BAD_MATCH:
            return "EGL_BAD_MATCH";
        case EGL_BAD_NATIVE_PIXMAP:
            return "EGL_BAD_NATIVE_PIXMAP";
        case EGL_BAD_NATIVE_WINDOW:
            return "EGL_BAD_NATIVE_WINDOW";
        case EGL_BAD_PARAMETER:
            return "EGL_BAD_PARAMETER";
        case EGL_BAD_SURFACE:
            return "EGL_BAD_SURFACE";
        case EGL11.EGL_CONTEXT_LOST:
            return "EGL_CONTEXT_LOST";
        default:
            return getHex(error);
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:15.264 -0500", hash_original_field = "D19D54AD36A1A39095774A765AE2AE1F", hash_generated_field = "810B3620548D69A98EE24D94E671C714")

    private EGL10 mEgl10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:15.266 -0500", hash_original_field = "C102688AB5147714BE034DF5762AF781", hash_generated_field = "C102688AB5147714BE034DF5762AF781")

    Writer mLog;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:15.268 -0500", hash_original_field = "623EC830790FA928BAEA6FB3AEF1E4BD", hash_generated_field = "623EC830790FA928BAEA6FB3AEF1E4BD")

    boolean mLogArgumentNames;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:15.270 -0500", hash_original_field = "8BAF20A7CA64C101926E06DD40CFBFBF", hash_generated_field = "8BAF20A7CA64C101926E06DD40CFBFBF")

    boolean mCheckError;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:15.272 -0500", hash_original_field = "B7F88A0F484E30B2A2C4E9BD38D9ED63", hash_generated_field = "3D4AA24E99B2CD1AFB8EEE08DE93A4A1")

    private int mArgCount;


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:15.275 -0500", hash_original_method = "0B69E6453D41FDE4430AE10DB8A1E0ED", hash_generated_method = "3783CC5D1147AD194007ACB4DCE53A64")
    
public EGLLogWrapper(EGL egl, int configFlags, Writer log) {
        mEgl10 = (EGL10) egl;
        mLog = log;
        mLogArgumentNames =
            (GLDebugHelper.CONFIG_LOG_ARGUMENT_NAMES & configFlags) != 0;
        mCheckError =
            (GLDebugHelper.CONFIG_CHECK_GL_ERROR & configFlags) != 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:15.278 -0500", hash_original_method = "99E448EDD5FF02B27B17FAE0B57A580D", hash_generated_method = "1630780B96FAD1A547EE7B10CF425353")
    
public boolean eglChooseConfig(EGLDisplay display, int[] attrib_list,
            EGLConfig[] configs, int config_size, int[] num_config) {
        begin("eglChooseConfig");
        arg("display", display);
        arg("attrib_list", attrib_list);
        arg("config_size", config_size);
        end();

        boolean result = mEgl10.eglChooseConfig(display, attrib_list, configs,
                config_size, num_config);
        arg("configs", configs);
        arg("num_config", num_config);
        returns(result);
        checkError();
        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:15.280 -0500", hash_original_method = "6247B7AE810F729296017888684B59EB", hash_generated_method = "D3A60C034F495932C1DB55033A975178")
    
public boolean eglCopyBuffers(EGLDisplay display, EGLSurface surface,
            Object native_pixmap) {
        begin("eglCopyBuffers");
        arg("display", display);
        arg("surface", surface);
        arg("native_pixmap", native_pixmap);
        end();

        boolean result = mEgl10.eglCopyBuffers(display, surface, native_pixmap);
        returns(result);
        checkError();
        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:15.283 -0500", hash_original_method = "4AB30C1D9749A5EE67477CF577F72B26", hash_generated_method = "C36A6576D324D791F4AD722C8B7341BE")
    
public EGLContext eglCreateContext(EGLDisplay display, EGLConfig config,
            EGLContext share_context, int[] attrib_list) {
        begin("eglCreateContext");
        arg("display", display);
        arg("config", config);
        arg("share_context", share_context);
        arg("attrib_list", attrib_list);
        end();

        EGLContext result = mEgl10.eglCreateContext(display, config,
                share_context, attrib_list);
        returns(result);
        checkError();
        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:15.285 -0500", hash_original_method = "E582D9CBB0191E5220367BD0744C6983", hash_generated_method = "0B6D8833156E8D9084F69D2ADC7BEF8D")
    
public EGLSurface eglCreatePbufferSurface(EGLDisplay display,
            EGLConfig config, int[] attrib_list) {
        begin("eglCreatePbufferSurface");
        arg("display", display);
        arg("config", config);
        arg("attrib_list", attrib_list);
        end();

        EGLSurface result = mEgl10.eglCreatePbufferSurface(display, config,
                attrib_list);
        returns(result);
        checkError();
        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:15.287 -0500", hash_original_method = "765CEBF62D7B9322979603163DA8F5D9", hash_generated_method = "A35262B7DCE36909E442404571EE2A51")
    
public EGLSurface eglCreatePixmapSurface(EGLDisplay display,
            EGLConfig config, Object native_pixmap, int[] attrib_list) {
        begin("eglCreatePixmapSurface");
        arg("display", display);
        arg("config", config);
        arg("native_pixmap", native_pixmap);
        arg("attrib_list", attrib_list);
        end();

        EGLSurface result = mEgl10.eglCreatePixmapSurface(display, config,
                native_pixmap, attrib_list);
        returns(result);
        checkError();
        return result;
        }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:15.290 -0500", hash_original_method = "CDAC490304CF100FCC182FE43316F1FE", hash_generated_method = "930A0E5195109E633B6D67C39E43D5A5")
    
public EGLSurface eglCreateWindowSurface(EGLDisplay display,
            EGLConfig config, Object native_window, int[] attrib_list) {
        begin("eglCreateWindowSurface");
        arg("display", display);
        arg("config", config);
        arg("native_window", native_window);
        arg("attrib_list", attrib_list);
        end();

        EGLSurface result = mEgl10.eglCreateWindowSurface(display, config,
                native_window, attrib_list);
        returns(result);
        checkError();
        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:15.293 -0500", hash_original_method = "17B0F3E125DE2F7D60446CA9C4D63B31", hash_generated_method = "2EEC985555AD2730DD921B7A5F94FE01")
    
public boolean eglDestroyContext(EGLDisplay display, EGLContext context) {
        begin("eglDestroyContext");
        arg("display", display);
        arg("context", context);
        end();

        boolean result = mEgl10.eglDestroyContext(display, context);
        returns(result);
        checkError();
        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:15.295 -0500", hash_original_method = "4F8B036EB2172C3CCE8A824D61EAB111", hash_generated_method = "3AA9D11904B1B374F246589A1A29B3C3")
    
public boolean eglDestroySurface(EGLDisplay display, EGLSurface surface) {
        begin("eglDestroySurface");
        arg("display", display);
        arg("surface", surface);
        end();

        boolean result = mEgl10.eglDestroySurface(display, surface);
        returns(result);
        checkError();
        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:15.297 -0500", hash_original_method = "FAC2963F9A093EAFAA19929320C953BC", hash_generated_method = "1BAA20B47DE8E6E7DD17F63988720CC8")
    
public boolean eglGetConfigAttrib(EGLDisplay display, EGLConfig config,
            int attribute, int[] value) {
        begin("eglGetConfigAttrib");
        arg("display", display);
        arg("config", config);
        arg("attribute", attribute);
        end();
        boolean result = mEgl10.eglGetConfigAttrib(display, config, attribute,
                value);
        arg("value", value);
        returns(result);
        checkError();
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:15.301 -0500", hash_original_method = "AD66F75E4122CC6834F792A1FE75B03A", hash_generated_method = "6D441552DA1203DB58A21E6951BCE417")
    
public boolean eglGetConfigs(EGLDisplay display, EGLConfig[] configs,
            int config_size, int[] num_config) {
        begin("eglGetConfigs");
        arg("display", display);
        arg("config_size", config_size);
        end();

        boolean result = mEgl10.eglGetConfigs(display, configs, config_size,
                num_config);
        arg("configs", configs);
        arg("num_config", num_config);
        returns(result);
        checkError();
        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:15.303 -0500", hash_original_method = "CD5215ACB5A884467FFDCDB902F66D96", hash_generated_method = "DB19E4060A20A0627E99C0D71C70522B")
    
public EGLContext eglGetCurrentContext() {
        begin("eglGetCurrentContext");
        end();

        EGLContext result = mEgl10.eglGetCurrentContext();
        returns(result);

        checkError();
        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:15.305 -0500", hash_original_method = "F89CCAE1C686118EE987018C5EB511F3", hash_generated_method = "EF6C9F2DC2B768B9530D211CE8009F28")
    
public EGLDisplay eglGetCurrentDisplay() {
        begin("eglGetCurrentDisplay");
        end();

        EGLDisplay result = mEgl10.eglGetCurrentDisplay();
        returns(result);

        checkError();
        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:15.308 -0500", hash_original_method = "97BC2264A7EAF9C13CA50824D785EB5C", hash_generated_method = "52FDC70FEF06439FB8AD5B72B0BBC475")
    
public EGLSurface eglGetCurrentSurface(int readdraw) {
        begin("eglGetCurrentSurface");
        arg("readdraw", readdraw);
        end();

        EGLSurface result = mEgl10.eglGetCurrentSurface(readdraw);
        returns(result);

        checkError();
        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:15.310 -0500", hash_original_method = "D9FC0B2A3D1E4133A8157B766B2423D8", hash_generated_method = "12D755318956F7B6B22597EF936EB85B")
    
public EGLDisplay eglGetDisplay(Object native_display) {
        begin("eglGetDisplay");
        arg("native_display", native_display);
        end();

        EGLDisplay result = mEgl10.eglGetDisplay(native_display);
        returns(result);

        checkError();
        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:15.312 -0500", hash_original_method = "DE53FD647DB0A1FC971C6C4A91049D54", hash_generated_method = "A374886886F5DDB71D13B6233020FB4C")
    
public int eglGetError() {
        begin("eglGetError");
        end();

        int result = mEgl10.eglGetError();
        returns(getErrorString(result));

        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:15.315 -0500", hash_original_method = "E9B8DEB24A1F9C034A66CF10AF8096D2", hash_generated_method = "53C07C1187F2943BE60B85EA22372E05")
    
public boolean eglInitialize(EGLDisplay display, int[] major_minor) {
        begin("eglInitialize");
        arg("display", display);
        end();
        boolean result = mEgl10.eglInitialize(display, major_minor);
        returns(result);
        arg("major_minor", major_minor);
        checkError();
        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:15.317 -0500", hash_original_method = "BB07DB3ECE14A6EF231877217C9BD366", hash_generated_method = "C9B9CE802BFACDFCCB2C364079A32D6A")
    
public boolean eglMakeCurrent(EGLDisplay display, EGLSurface draw,
            EGLSurface read, EGLContext context) {
        begin("eglMakeCurrent");
        arg("display", display);
        arg("draw", draw);
        arg("read", read);
        arg("context", context);
        end();
        boolean result = mEgl10.eglMakeCurrent(display, draw, read, context);
        returns(result);
        checkError();
        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:15.320 -0500", hash_original_method = "91AE092511C911001E41B66448439E71", hash_generated_method = "899C4E548EBA2C2375203227585C7805")
    
public boolean eglQueryContext(EGLDisplay display, EGLContext context,
            int attribute, int[] value) {
        begin("eglQueryContext");
        arg("display", display);
        arg("context", context);
        arg("attribute", attribute);
        end();
        boolean result = mEgl10.eglQueryContext(display, context, attribute,
                value);
        returns(value[0]);
        returns(result);
        checkError();
        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:15.322 -0500", hash_original_method = "D3DE2BC248237F2B7CE3331164B605A6", hash_generated_method = "4E225FD33BA22C31BB5977051CDC9A35")
    
public String eglQueryString(EGLDisplay display, int name) {
        begin("eglQueryString");
        arg("display", display);
        arg("name", name);
        end();
        String result = mEgl10.eglQueryString(display, name);
        returns(result);
        checkError();
        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:15.325 -0500", hash_original_method = "67721B12322C2AC20F24CD37056CF118", hash_generated_method = "347868F2006AA916115403E74B354C2B")
    
public boolean eglQuerySurface(EGLDisplay display, EGLSurface surface,
            int attribute, int[] value) {
        begin("eglQuerySurface");
        arg("display", display);
        arg("surface", surface);
        arg("attribute", attribute);
        end();
        boolean result = mEgl10.eglQuerySurface(display, surface, attribute,
                value);
        returns(value[0]);
        returns(result);
        checkError();
        return result;
    }
    
    /** @hide **/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:15.327 -0500", hash_original_method = "1B282CDB7FEAA67B60FE87995BF0D6A0", hash_generated_method = "4BAF687EF6FDDAF68A1E36DBDE53DBB6")
    
public boolean eglReleaseThread() {
        begin("eglReleaseThread");
        end();
        boolean result = mEgl10.eglReleaseThread();
        returns(result);
        checkError();
        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:15.329 -0500", hash_original_method = "A5B6F2B2F6446A6BDCF86B87696C0E2D", hash_generated_method = "EE640828704E48A8EE26CCFCF3606B55")
    
public boolean eglSwapBuffers(EGLDisplay display, EGLSurface surface) {
        begin("eglInitialize");
        arg("display", display);
        arg("surface", surface);
        end();
        boolean result = mEgl10.eglSwapBuffers(display, surface);
        returns(result);
        checkError();
        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:15.332 -0500", hash_original_method = "027722FADC1595F5ADEB9B83ABCF6D7A", hash_generated_method = "013E7A44013562B14BDCFD509D01E2B4")
    
public boolean eglTerminate(EGLDisplay display) {
        begin("eglTerminate");
        arg("display", display);
        end();
        boolean result = mEgl10.eglTerminate(display);
        returns(result);
        checkError();
        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:15.334 -0500", hash_original_method = "31CF9143DBB991079519ECC4274884CE", hash_generated_method = "804B1D94A8BB8A36A8AF526F44814CB3")
    
public boolean eglWaitGL() {
        begin("eglWaitGL");
        end();
        boolean result = mEgl10.eglWaitGL();
        returns(result);
        checkError();
        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:15.337 -0500", hash_original_method = "AE7A08A8F8EFC029A4F74729E48AAF48", hash_generated_method = "F6D2C888B4B4045C8F6EC03CD987086E")
    
public boolean eglWaitNative(int engine, Object bindTarget) {
        begin("eglWaitNative");
        arg("engine", engine);
        arg("bindTarget", bindTarget);
        end();
        boolean result = mEgl10.eglWaitNative(engine, bindTarget);
        returns(result);
        checkError();
        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:15.340 -0500", hash_original_method = "788326C328235EE087DA54E094036343", hash_generated_method = "FA963DBF46A7097B6BB51498480FA780")
    
private void checkError() {
        int eglError;
        if ((eglError = mEgl10.eglGetError()) != EGL_SUCCESS) {
            String errorMessage = "eglError: " + getErrorString(eglError);
            logLine(errorMessage);
            if (mCheckError) {
                throw new GLException(eglError, errorMessage);
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:15.342 -0500", hash_original_method = "B819F9C00E5D903C9B12858E84782EC6", hash_generated_method = "F9CC18CF76615C08196345248052B481")
    
private void logLine(String message) {
        log(message + '\n');
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:15.344 -0500", hash_original_method = "55C0C6DBDFA700D90D9FD20B92BCF082", hash_generated_method = "5C448D5FAA0F5584277595ADE0F6F4C6")
    
private void log(String message) {
        try {
            mLog.write(message);
        } catch (IOException e) {
            // Ignore exception, keep on trying
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:15.346 -0500", hash_original_method = "FB0C650254ED9FCE75BB6E7EB1636546", hash_generated_method = "369891CBA246B14C38B39EEBD6E95768")
    
private void begin(String name) {
        log(name + '(');
        mArgCount = 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:15.349 -0500", hash_original_method = "54C70E45C8BA9C703732EB10FD7BBF7B", hash_generated_method = "7B27682116508D3E48B9DC7643F1052D")
    
private void arg(String name, String value) {
        if (mArgCount++ > 0) {
            log(", ");
        }
        if (mLogArgumentNames) {
            log(name + "=");
        }
        log(value);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:15.351 -0500", hash_original_method = "34DADD61F74380F23C382DA05A595428", hash_generated_method = "12E3F242E36BA034A6CED88502BAD847")
    
private void end() {
        log(");\n");
        flush();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:15.353 -0500", hash_original_method = "0CDA8C40EE3F1BEB19FC35DF0C9C3B14", hash_generated_method = "2E2434FEE94D9406D742CF413A2C192F")
    
private void flush() {
        try {
            mLog.flush();
        } catch (IOException e) {
            mLog = null;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:15.356 -0500", hash_original_method = "B92E6D1514E3DF39AF9DE02825B78605", hash_generated_method = "5FEFCA48109687D1811D66434F67790C")
    
private void arg(String name, int value) {
        arg(name, Integer.toString(value));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:15.358 -0500", hash_original_method = "F32E9ED1A9AD790C0C3F824859AFFD50", hash_generated_method = "55449E3FE9CFDBA27DF437657A14E1CC")
    
private void arg(String name, Object object) {
        arg(name, toString(object));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:15.360 -0500", hash_original_method = "01946A19C8705B92846E5FD249971514", hash_generated_method = "B0344298157D4732C4388127D3BB25C1")
    
private void arg(String name, EGLDisplay object) {
        if (object == EGL10.EGL_DEFAULT_DISPLAY) {
            arg(name, "EGL10.EGL_DEFAULT_DISPLAY");
        } else if (object == EGL_NO_DISPLAY) {
            arg(name, "EGL10.EGL_NO_DISPLAY");
        } else {
            arg(name, toString(object));
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:15.363 -0500", hash_original_method = "01463BB924BE80515544A0A965E7A7B9", hash_generated_method = "7A0AD28168151D03BA17D294B99F2A6E")
    
private void arg(String name, EGLContext object) {
        if (object == EGL10.EGL_NO_CONTEXT) {
            arg(name, "EGL10.EGL_NO_CONTEXT");
        } else {
            arg(name, toString(object));
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:15.365 -0500", hash_original_method = "29F033CFC0C7125F3850A082876BA169", hash_generated_method = "8DC870110357B011150E33036CE9AA90")
    
private void arg(String name, EGLSurface object) {
        if (object == EGL10.EGL_NO_SURFACE) {
            arg(name, "EGL10.EGL_NO_SURFACE");
        } else {
            arg(name, toString(object));
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:15.367 -0500", hash_original_method = "3FBBFC7C1FE2EDBEEE74392E2BA2D107", hash_generated_method = "C5DE735309A52E52693CD2A7C075BB6B")
    
private void returns(String result) {
        log(" returns " + result + ";\n");
        flush();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:15.370 -0500", hash_original_method = "A943ABBAFE7E9588C2D5222F0375E708", hash_generated_method = "801A10A157319D17C47CD712F1054C74")
    
private void returns(int result) {
        returns(Integer.toString(result));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:15.372 -0500", hash_original_method = "F758ED771C34CA3F99E1517AB5DA84CC", hash_generated_method = "2D2FF7A08A8E5AB05280650DCBD223E5")
    
private void returns(boolean result) {
        returns(Boolean.toString(result));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:15.374 -0500", hash_original_method = "13511071C6DE4FFBB82F1BC04606E74C", hash_generated_method = "BC463BD401581B8609F1C279B1D16F55")
    
private void returns(Object result) {
        returns(toString(result));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:15.376 -0500", hash_original_method = "122D09D33E3C14E13BA1263367B842FD", hash_generated_method = "364630407A11F9DC78D532C5CBA9554A")
    
private String toString(Object obj) {
        if (obj == null) {
            return "null";
        } else {
            return obj.toString();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:15.378 -0500", hash_original_method = "681A195715F2634EFD4F6574BD3918CD", hash_generated_method = "69DEF8F03F13A816E001365578F5EEA5")
    
private void arg(String name, int[] arr) {
        if (arr == null) {
            arg(name, "null");
        } else {
            arg(name, toString(arr.length, arr, 0));
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:15.381 -0500", hash_original_method = "DD519F74DAF76C6EBE410B4846DBED4A", hash_generated_method = "A6F351E07B7BCB448FC8B6F653FB61A3")
    
private void arg(String name, Object[] arr) {
        if (arr == null) {
            arg(name, "null");
        } else {
            arg(name, toString(arr.length, arr, 0));
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:15.384 -0500", hash_original_method = "83D3FA96B1354405A93359C25E36746A", hash_generated_method = "FF6A3602DFF20DDF44FBDFA213412638")
    
private String toString(int n, int[] arr, int offset) {
        StringBuilder buf = new StringBuilder();
        buf.append("{\n");
        int arrLen = arr.length;
        for (int i = 0; i < n; i++) {
            int index = offset + i;
            buf.append(" [" + index + "] = ");
            if (index < 0 || index >= arrLen) {
                buf.append("out of bounds");
            } else {
                buf.append(arr[index]);
            }
            buf.append('\n');
        }
        buf.append("}");
        return buf.toString();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:15.387 -0500", hash_original_method = "76307B205B17F18B9623C7717F9DB208", hash_generated_method = "84F1356B017386F3D652CD82E379F1BA")
    
private String toString(int n, Object[] arr, int offset) {
        StringBuilder buf = new StringBuilder();
        buf.append("{\n");
        int arrLen = arr.length;
        for (int i = 0; i < n; i++) {
            int index = offset + i;
            buf.append(" [" + index + "] = ");
            if (index < 0 || index >= arrLen) {
                buf.append("out of bounds");
            } else {
                buf.append(arr[index]);
            }
            buf.append('\n');
        }
        buf.append("}");
        return buf.toString();
    }

    
}

