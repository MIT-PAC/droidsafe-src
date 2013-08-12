package android.opengl;

// Droidsafe Imports
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.845 -0400", hash_original_field = "1FA6A9B761C252E825AC174008EF194A", hash_generated_field = "810B3620548D69A98EE24D94E671C714")

    private EGL10 mEgl10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.845 -0400", hash_original_field = "DBF54F78AEFB053436817860276B7F83", hash_generated_field = "C102688AB5147714BE034DF5762AF781")

    Writer mLog;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.845 -0400", hash_original_field = "42897FB5102C10159726278B084E4D00", hash_generated_field = "623EC830790FA928BAEA6FB3AEF1E4BD")

    boolean mLogArgumentNames;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.845 -0400", hash_original_field = "0A62057C5CEDB9A6C64FF2E17CCC4D50", hash_generated_field = "8BAF20A7CA64C101926E06DD40CFBFBF")

    boolean mCheckError;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.845 -0400", hash_original_field = "9FDC16DCB2EE57FF9BC6C05296BC9D85", hash_generated_field = "3D4AA24E99B2CD1AFB8EEE08DE93A4A1")

    private int mArgCount;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.846 -0400", hash_original_method = "0B69E6453D41FDE4430AE10DB8A1E0ED", hash_generated_method = "C867A51C7896368983E4E992ED6990C3")
    public  EGLLogWrapper(EGL egl, int configFlags, Writer log) {
        mEgl10 = (EGL10) egl;
        mLog = log;
        mLogArgumentNames =
            (GLDebugHelper.CONFIG_LOG_ARGUMENT_NAMES & configFlags) != 0;
        mCheckError =
            (GLDebugHelper.CONFIG_CHECK_GL_ERROR & configFlags) != 0;
        // ---------- Original Method ----------
        //mEgl10 = (EGL10) egl;
        //mLog = log;
        //mLogArgumentNames =
            //(GLDebugHelper.CONFIG_LOG_ARGUMENT_NAMES & configFlags) != 0;
        //mCheckError =
            //(GLDebugHelper.CONFIG_CHECK_GL_ERROR & configFlags) != 0;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.847 -0400", hash_original_method = "99E448EDD5FF02B27B17FAE0B57A580D", hash_generated_method = "13196B774BDB75420FFFE2EFE1580AF1")
    public boolean eglChooseConfig(EGLDisplay display, int[] attrib_list,
            EGLConfig[] configs, int config_size, int[] num_config) {
        addTaint(num_config[0]);
        addTaint(config_size);
        addTaint(configs[0].getTaint());
        addTaint(attrib_list[0]);
        addTaint(display.getTaint());
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
        boolean varB4A88417B3D0170D754C647C30B7216A_2119700759 = (result);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1863775974 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1863775974;
        // ---------- Original Method ----------
        //begin("eglChooseConfig");
        //arg("display", display);
        //arg("attrib_list", attrib_list);
        //arg("config_size", config_size);
        //end();
        //boolean result = mEgl10.eglChooseConfig(display, attrib_list, configs,
                //config_size, num_config);
        //arg("configs", configs);
        //arg("num_config", num_config);
        //returns(result);
        //checkError();
        //return result;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.847 -0400", hash_original_method = "6247B7AE810F729296017888684B59EB", hash_generated_method = "86635C44BF1F1709EB3C6B29B75BBBB2")
    public boolean eglCopyBuffers(EGLDisplay display, EGLSurface surface,
            Object native_pixmap) {
        addTaint(native_pixmap.getTaint());
        addTaint(surface.getTaint());
        addTaint(display.getTaint());
        begin("eglCopyBuffers");
        arg("display", display);
        arg("surface", surface);
        arg("native_pixmap", native_pixmap);
        end();
        boolean result = mEgl10.eglCopyBuffers(display, surface, native_pixmap);
        returns(result);
        checkError();
        boolean varB4A88417B3D0170D754C647C30B7216A_735846717 = (result);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_418772661 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_418772661;
        // ---------- Original Method ----------
        //begin("eglCopyBuffers");
        //arg("display", display);
        //arg("surface", surface);
        //arg("native_pixmap", native_pixmap);
        //end();
        //boolean result = mEgl10.eglCopyBuffers(display, surface, native_pixmap);
        //returns(result);
        //checkError();
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.848 -0400", hash_original_method = "4AB30C1D9749A5EE67477CF577F72B26", hash_generated_method = "65A4A61D31ABC19194BF4E635E5EB9BB")
    public EGLContext eglCreateContext(EGLDisplay display, EGLConfig config,
            EGLContext share_context, int[] attrib_list) {
        addTaint(attrib_list[0]);
        addTaint(share_context.getTaint());
        addTaint(config.getTaint());
        addTaint(display.getTaint());
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
EGLContext varDC838461EE2FA0CA4C9BBB70A15456B0_1839845456 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_1839845456.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_1839845456;
        // ---------- Original Method ----------
        //begin("eglCreateContext");
        //arg("display", display);
        //arg("config", config);
        //arg("share_context", share_context);
        //arg("attrib_list", attrib_list);
        //end();
        //EGLContext result = mEgl10.eglCreateContext(display, config,
                //share_context, attrib_list);
        //returns(result);
        //checkError();
        //return result;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.849 -0400", hash_original_method = "E582D9CBB0191E5220367BD0744C6983", hash_generated_method = "A13F8ED6B18AA8A4D44D455F134CD479")
    public EGLSurface eglCreatePbufferSurface(EGLDisplay display,
            EGLConfig config, int[] attrib_list) {
        addTaint(attrib_list[0]);
        addTaint(config.getTaint());
        addTaint(display.getTaint());
        begin("eglCreatePbufferSurface");
        arg("display", display);
        arg("config", config);
        arg("attrib_list", attrib_list);
        end();
        EGLSurface result = mEgl10.eglCreatePbufferSurface(display, config,
                attrib_list);
        returns(result);
        checkError();
EGLSurface varDC838461EE2FA0CA4C9BBB70A15456B0_1532419029 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_1532419029.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_1532419029;
        // ---------- Original Method ----------
        //begin("eglCreatePbufferSurface");
        //arg("display", display);
        //arg("config", config);
        //arg("attrib_list", attrib_list);
        //end();
        //EGLSurface result = mEgl10.eglCreatePbufferSurface(display, config,
                //attrib_list);
        //returns(result);
        //checkError();
        //return result;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.849 -0400", hash_original_method = "765CEBF62D7B9322979603163DA8F5D9", hash_generated_method = "91915AD10BAA10B3A2C80F8E59CC37E7")
    public EGLSurface eglCreatePixmapSurface(EGLDisplay display,
            EGLConfig config, Object native_pixmap, int[] attrib_list) {
        addTaint(attrib_list[0]);
        addTaint(native_pixmap.getTaint());
        addTaint(config.getTaint());
        addTaint(display.getTaint());
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
EGLSurface varDC838461EE2FA0CA4C9BBB70A15456B0_1436043992 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_1436043992.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_1436043992;
        // ---------- Original Method ----------
        //begin("eglCreatePixmapSurface");
        //arg("display", display);
        //arg("config", config);
        //arg("native_pixmap", native_pixmap);
        //arg("attrib_list", attrib_list);
        //end();
        //EGLSurface result = mEgl10.eglCreatePixmapSurface(display, config,
                //native_pixmap, attrib_list);
        //returns(result);
        //checkError();
        //return result;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.850 -0400", hash_original_method = "CDAC490304CF100FCC182FE43316F1FE", hash_generated_method = "F56C577DA94132CD8BD1D15446CC71EC")
    public EGLSurface eglCreateWindowSurface(EGLDisplay display,
            EGLConfig config, Object native_window, int[] attrib_list) {
        addTaint(attrib_list[0]);
        addTaint(native_window.getTaint());
        addTaint(config.getTaint());
        addTaint(display.getTaint());
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
EGLSurface varDC838461EE2FA0CA4C9BBB70A15456B0_318241861 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_318241861.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_318241861;
        // ---------- Original Method ----------
        //begin("eglCreateWindowSurface");
        //arg("display", display);
        //arg("config", config);
        //arg("native_window", native_window);
        //arg("attrib_list", attrib_list);
        //end();
        //EGLSurface result = mEgl10.eglCreateWindowSurface(display, config,
                //native_window, attrib_list);
        //returns(result);
        //checkError();
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.851 -0400", hash_original_method = "17B0F3E125DE2F7D60446CA9C4D63B31", hash_generated_method = "13B456EE8DA36DC8A9D51A50E0C4A4B9")
    public boolean eglDestroyContext(EGLDisplay display, EGLContext context) {
        addTaint(context.getTaint());
        addTaint(display.getTaint());
        begin("eglDestroyContext");
        arg("display", display);
        arg("context", context);
        end();
        boolean result = mEgl10.eglDestroyContext(display, context);
        returns(result);
        checkError();
        boolean varB4A88417B3D0170D754C647C30B7216A_1924710300 = (result);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_303000885 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_303000885;
        // ---------- Original Method ----------
        //begin("eglDestroyContext");
        //arg("display", display);
        //arg("context", context);
        //end();
        //boolean result = mEgl10.eglDestroyContext(display, context);
        //returns(result);
        //checkError();
        //return result;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.852 -0400", hash_original_method = "4F8B036EB2172C3CCE8A824D61EAB111", hash_generated_method = "0201C1EBF6609438B15A860E39A04FCF")
    public boolean eglDestroySurface(EGLDisplay display, EGLSurface surface) {
        addTaint(surface.getTaint());
        addTaint(display.getTaint());
        begin("eglDestroySurface");
        arg("display", display);
        arg("surface", surface);
        end();
        boolean result = mEgl10.eglDestroySurface(display, surface);
        returns(result);
        checkError();
        boolean varB4A88417B3D0170D754C647C30B7216A_470455501 = (result);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1592935486 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1592935486;
        // ---------- Original Method ----------
        //begin("eglDestroySurface");
        //arg("display", display);
        //arg("surface", surface);
        //end();
        //boolean result = mEgl10.eglDestroySurface(display, surface);
        //returns(result);
        //checkError();
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.853 -0400", hash_original_method = "FAC2963F9A093EAFAA19929320C953BC", hash_generated_method = "8EBADB77553366EF62CECCC06B75DB01")
    public boolean eglGetConfigAttrib(EGLDisplay display, EGLConfig config,
            int attribute, int[] value) {
        addTaint(value[0]);
        addTaint(attribute);
        addTaint(config.getTaint());
        addTaint(display.getTaint());
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
        boolean var68934A3E9455FA72420237EB05902327_654744 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_861477682 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_861477682;
        // ---------- Original Method ----------
        //begin("eglGetConfigAttrib");
        //arg("display", display);
        //arg("config", config);
        //arg("attribute", attribute);
        //end();
        //boolean result = mEgl10.eglGetConfigAttrib(display, config, attribute,
                //value);
        //arg("value", value);
        //returns(result);
        //checkError();
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.854 -0400", hash_original_method = "AD66F75E4122CC6834F792A1FE75B03A", hash_generated_method = "FAD814717B45B4F240D57AA6809B2765")
    public boolean eglGetConfigs(EGLDisplay display, EGLConfig[] configs,
            int config_size, int[] num_config) {
        addTaint(num_config[0]);
        addTaint(config_size);
        addTaint(configs[0].getTaint());
        addTaint(display.getTaint());
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
        boolean varB4A88417B3D0170D754C647C30B7216A_266593894 = (result);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_18688972 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_18688972;
        // ---------- Original Method ----------
        //begin("eglGetConfigs");
        //arg("display", display);
        //arg("config_size", config_size);
        //end();
        //boolean result = mEgl10.eglGetConfigs(display, configs, config_size,
                //num_config);
        //arg("configs", configs);
        //arg("num_config", num_config);
        //returns(result);
        //checkError();
        //return result;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.854 -0400", hash_original_method = "CD5215ACB5A884467FFDCDB902F66D96", hash_generated_method = "2573D214E4CEE75F243D732EE795F668")
    public EGLContext eglGetCurrentContext() {
        begin("eglGetCurrentContext");
        end();
        EGLContext result = mEgl10.eglGetCurrentContext();
        returns(result);
        checkError();
EGLContext varDC838461EE2FA0CA4C9BBB70A15456B0_278168152 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_278168152.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_278168152;
        // ---------- Original Method ----------
        //begin("eglGetCurrentContext");
        //end();
        //EGLContext result = mEgl10.eglGetCurrentContext();
        //returns(result);
        //checkError();
        //return result;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.855 -0400", hash_original_method = "F89CCAE1C686118EE987018C5EB511F3", hash_generated_method = "A18684395E6172DBA42C6802E8039085")
    public EGLDisplay eglGetCurrentDisplay() {
        begin("eglGetCurrentDisplay");
        end();
        EGLDisplay result = mEgl10.eglGetCurrentDisplay();
        returns(result);
        checkError();
EGLDisplay varDC838461EE2FA0CA4C9BBB70A15456B0_1386784042 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_1386784042.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_1386784042;
        // ---------- Original Method ----------
        //begin("eglGetCurrentDisplay");
        //end();
        //EGLDisplay result = mEgl10.eglGetCurrentDisplay();
        //returns(result);
        //checkError();
        //return result;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.856 -0400", hash_original_method = "97BC2264A7EAF9C13CA50824D785EB5C", hash_generated_method = "233B26E11927DEB3F4C17234430EFEAC")
    public EGLSurface eglGetCurrentSurface(int readdraw) {
        addTaint(readdraw);
        begin("eglGetCurrentSurface");
        arg("readdraw", readdraw);
        end();
        EGLSurface result = mEgl10.eglGetCurrentSurface(readdraw);
        returns(result);
        checkError();
EGLSurface varDC838461EE2FA0CA4C9BBB70A15456B0_540691905 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_540691905.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_540691905;
        // ---------- Original Method ----------
        //begin("eglGetCurrentSurface");
        //arg("readdraw", readdraw);
        //end();
        //EGLSurface result = mEgl10.eglGetCurrentSurface(readdraw);
        //returns(result);
        //checkError();
        //return result;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.856 -0400", hash_original_method = "D9FC0B2A3D1E4133A8157B766B2423D8", hash_generated_method = "A628C99D4BFF2206B6C4D062C07B9ECD")
    public EGLDisplay eglGetDisplay(Object native_display) {
        addTaint(native_display.getTaint());
        begin("eglGetDisplay");
        arg("native_display", native_display);
        end();
        EGLDisplay result = mEgl10.eglGetDisplay(native_display);
        returns(result);
        checkError();
EGLDisplay varDC838461EE2FA0CA4C9BBB70A15456B0_390971007 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_390971007.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_390971007;
        // ---------- Original Method ----------
        //begin("eglGetDisplay");
        //arg("native_display", native_display);
        //end();
        //EGLDisplay result = mEgl10.eglGetDisplay(native_display);
        //returns(result);
        //checkError();
        //return result;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.857 -0400", hash_original_method = "DE53FD647DB0A1FC971C6C4A91049D54", hash_generated_method = "0485268C8197FB613184720F88002494")
    public int eglGetError() {
        begin("eglGetError");
        end();
        int result = mEgl10.eglGetError();
        returns(getErrorString(result));
        int varB4A88417B3D0170D754C647C30B7216A_104633421 = (result);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1796499214 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1796499214;
        // ---------- Original Method ----------
        //begin("eglGetError");
        //end();
        //int result = mEgl10.eglGetError();
        //returns(getErrorString(result));
        //return result;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.857 -0400", hash_original_method = "E9B8DEB24A1F9C034A66CF10AF8096D2", hash_generated_method = "EC78DAF40641194BF25E4341ACAD758D")
    public boolean eglInitialize(EGLDisplay display, int[] major_minor) {
        addTaint(major_minor[0]);
        addTaint(display.getTaint());
        begin("eglInitialize");
        arg("display", display);
        end();
        boolean result = mEgl10.eglInitialize(display, major_minor);
        returns(result);
        arg("major_minor", major_minor);
        checkError();
        boolean varB4A88417B3D0170D754C647C30B7216A_487249073 = (result);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_636603144 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_636603144;
        // ---------- Original Method ----------
        //begin("eglInitialize");
        //arg("display", display);
        //end();
        //boolean result = mEgl10.eglInitialize(display, major_minor);
        //returns(result);
        //arg("major_minor", major_minor);
        //checkError();
        //return result;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.858 -0400", hash_original_method = "BB07DB3ECE14A6EF231877217C9BD366", hash_generated_method = "D2F3F2906468D912CF37A67F064DC450")
    public boolean eglMakeCurrent(EGLDisplay display, EGLSurface draw,
            EGLSurface read, EGLContext context) {
        addTaint(context.getTaint());
        addTaint(read.getTaint());
        addTaint(draw.getTaint());
        addTaint(display.getTaint());
        begin("eglMakeCurrent");
        arg("display", display);
        arg("draw", draw);
        arg("read", read);
        arg("context", context);
        end();
        boolean result = mEgl10.eglMakeCurrent(display, draw, read, context);
        returns(result);
        checkError();
        boolean varB4A88417B3D0170D754C647C30B7216A_495235210 = (result);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1486604389 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1486604389;
        // ---------- Original Method ----------
        //begin("eglMakeCurrent");
        //arg("display", display);
        //arg("draw", draw);
        //arg("read", read);
        //arg("context", context);
        //end();
        //boolean result = mEgl10.eglMakeCurrent(display, draw, read, context);
        //returns(result);
        //checkError();
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.858 -0400", hash_original_method = "91AE092511C911001E41B66448439E71", hash_generated_method = "80046C4E835EB7D21D64B24E75149133")
    public boolean eglQueryContext(EGLDisplay display, EGLContext context,
            int attribute, int[] value) {
        addTaint(value[0]);
        addTaint(attribute);
        addTaint(context.getTaint());
        addTaint(display.getTaint());
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
        boolean varB4A88417B3D0170D754C647C30B7216A_956708989 = (result);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1587914519 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1587914519;
        // ---------- Original Method ----------
        //begin("eglQueryContext");
        //arg("display", display);
        //arg("context", context);
        //arg("attribute", attribute);
        //end();
        //boolean result = mEgl10.eglQueryContext(display, context, attribute,
                //value);
        //returns(value[0]);
        //returns(result);
        //checkError();
        //return result;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.859 -0400", hash_original_method = "D3DE2BC248237F2B7CE3331164B605A6", hash_generated_method = "44B7EAB52D1D6C0AF1D3F34976192305")
    public String eglQueryString(EGLDisplay display, int name) {
        addTaint(name);
        addTaint(display.getTaint());
        begin("eglQueryString");
        arg("display", display);
        arg("name", name);
        end();
        String result = mEgl10.eglQueryString(display, name);
        returns(result);
        checkError();
String varDC838461EE2FA0CA4C9BBB70A15456B0_1501098941 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_1501098941.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_1501098941;
        // ---------- Original Method ----------
        //begin("eglQueryString");
        //arg("display", display);
        //arg("name", name);
        //end();
        //String result = mEgl10.eglQueryString(display, name);
        //returns(result);
        //checkError();
        //return result;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.859 -0400", hash_original_method = "67721B12322C2AC20F24CD37056CF118", hash_generated_method = "69F0C086E94D85ED4C59F1F42FEDC05F")
    public boolean eglQuerySurface(EGLDisplay display, EGLSurface surface,
            int attribute, int[] value) {
        addTaint(value[0]);
        addTaint(attribute);
        addTaint(surface.getTaint());
        addTaint(display.getTaint());
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
        boolean varB4A88417B3D0170D754C647C30B7216A_1662368165 = (result);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_613083834 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_613083834;
        // ---------- Original Method ----------
        //begin("eglQuerySurface");
        //arg("display", display);
        //arg("surface", surface);
        //arg("attribute", attribute);
        //end();
        //boolean result = mEgl10.eglQuerySurface(display, surface, attribute,
                //value);
        //returns(value[0]);
        //returns(result);
        //checkError();
        //return result;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.860 -0400", hash_original_method = "1B282CDB7FEAA67B60FE87995BF0D6A0", hash_generated_method = "D21B5B267C0CBBBB7252FCB07030567C")
    public boolean eglReleaseThread() {
        begin("eglReleaseThread");
        end();
        boolean result = mEgl10.eglReleaseThread();
        returns(result);
        checkError();
        boolean varB4A88417B3D0170D754C647C30B7216A_228146299 = (result);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1025785877 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1025785877;
        // ---------- Original Method ----------
        //begin("eglReleaseThread");
        //end();
        //boolean result = mEgl10.eglReleaseThread();
        //returns(result);
        //checkError();
        //return result;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.860 -0400", hash_original_method = "A5B6F2B2F6446A6BDCF86B87696C0E2D", hash_generated_method = "0398F93AFD9F68B86D5AAD09C2B27B92")
    public boolean eglSwapBuffers(EGLDisplay display, EGLSurface surface) {
        addTaint(surface.getTaint());
        addTaint(display.getTaint());
        begin("eglInitialize");
        arg("display", display);
        arg("surface", surface);
        end();
        boolean result = mEgl10.eglSwapBuffers(display, surface);
        returns(result);
        checkError();
        boolean varB4A88417B3D0170D754C647C30B7216A_700764239 = (result);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1107374535 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1107374535;
        // ---------- Original Method ----------
        //begin("eglInitialize");
        //arg("display", display);
        //arg("surface", surface);
        //end();
        //boolean result = mEgl10.eglSwapBuffers(display, surface);
        //returns(result);
        //checkError();
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.861 -0400", hash_original_method = "027722FADC1595F5ADEB9B83ABCF6D7A", hash_generated_method = "C47BBAEC53008B5EC5C7AE99F26DFDA6")
    public boolean eglTerminate(EGLDisplay display) {
        addTaint(display.getTaint());
        begin("eglTerminate");
        arg("display", display);
        end();
        boolean result = mEgl10.eglTerminate(display);
        returns(result);
        checkError();
        boolean varB4A88417B3D0170D754C647C30B7216A_1467446280 = (result);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1065646534 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1065646534;
        // ---------- Original Method ----------
        //begin("eglTerminate");
        //arg("display", display);
        //end();
        //boolean result = mEgl10.eglTerminate(display);
        //returns(result);
        //checkError();
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.861 -0400", hash_original_method = "31CF9143DBB991079519ECC4274884CE", hash_generated_method = "554FAD29291694FFB185B1603105DEBD")
    public boolean eglWaitGL() {
        begin("eglWaitGL");
        end();
        boolean result = mEgl10.eglWaitGL();
        returns(result);
        checkError();
        boolean varB4A88417B3D0170D754C647C30B7216A_1634357694 = (result);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_669054832 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_669054832;
        // ---------- Original Method ----------
        //begin("eglWaitGL");
        //end();
        //boolean result = mEgl10.eglWaitGL();
        //returns(result);
        //checkError();
        //return result;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.862 -0400", hash_original_method = "AE7A08A8F8EFC029A4F74729E48AAF48", hash_generated_method = "650F2F3E9CA9715F4DE67E5BB6B4BD1A")
    public boolean eglWaitNative(int engine, Object bindTarget) {
        addTaint(bindTarget.getTaint());
        addTaint(engine);
        begin("eglWaitNative");
        arg("engine", engine);
        arg("bindTarget", bindTarget);
        end();
        boolean result = mEgl10.eglWaitNative(engine, bindTarget);
        returns(result);
        checkError();
        boolean varB4A88417B3D0170D754C647C30B7216A_722997685 = (result);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1312563199 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1312563199;
        // ---------- Original Method ----------
        //begin("eglWaitNative");
        //arg("engine", engine);
        //arg("bindTarget", bindTarget);
        //end();
        //boolean result = mEgl10.eglWaitNative(engine, bindTarget);
        //returns(result);
        //checkError();
        //return result;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.862 -0400", hash_original_method = "788326C328235EE087DA54E094036343", hash_generated_method = "5B38A2AC76AEA3AF50589A3AE00AC558")
    private void checkError() {
        int eglError;
        if((eglError = mEgl10.eglGetError()) != EGL_SUCCESS)        
        {
            String errorMessage = "eglError: " + getErrorString(eglError);
            logLine(errorMessage);
            if(mCheckError)            
            {
                GLException var9F15425ECFD387370DF00B2A8FBDE5B5_407317726 = new GLException(eglError, errorMessage);
                var9F15425ECFD387370DF00B2A8FBDE5B5_407317726.addTaint(taint);
                throw var9F15425ECFD387370DF00B2A8FBDE5B5_407317726;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //int eglError;
        //if ((eglError = mEgl10.eglGetError()) != EGL_SUCCESS) {
            //String errorMessage = "eglError: " + getErrorString(eglError);
            //logLine(errorMessage);
            //if (mCheckError) {
                //throw new GLException(eglError, errorMessage);
            //}
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.863 -0400", hash_original_method = "B819F9C00E5D903C9B12858E84782EC6", hash_generated_method = "5F5D0216A34371FAE77555290CAD8A42")
    private void logLine(String message) {
        addTaint(message.getTaint());
        log(message + '\n');
        // ---------- Original Method ----------
        //log(message + '\n');
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.863 -0400", hash_original_method = "55C0C6DBDFA700D90D9FD20B92BCF082", hash_generated_method = "1FD69062587B8774F2FBFC9AB6BCAD1D")
    private void log(String message) {
        addTaint(message.getTaint());
        try 
        {
            mLog.write(message);
        } //End block
        catch (IOException e)
        {
        } //End block
        // ---------- Original Method ----------
        //try {
            //mLog.write(message);
        //} catch (IOException e) {
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.864 -0400", hash_original_method = "FB0C650254ED9FCE75BB6E7EB1636546", hash_generated_method = "802B50CA37688C411C9409CBBB0D3E0E")
    private void begin(String name) {
        addTaint(name.getTaint());
        log(name + '(');
        mArgCount = 0;
        // ---------- Original Method ----------
        //log(name + '(');
        //mArgCount = 0;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.864 -0400", hash_original_method = "54C70E45C8BA9C703732EB10FD7BBF7B", hash_generated_method = "DF33C133291E9F393FF306B9A4B6373D")
    private void arg(String name, String value) {
        addTaint(value.getTaint());
        addTaint(name.getTaint());
        if(mArgCount++ > 0)        
        {
            log(", ");
        } //End block
        if(mLogArgumentNames)        
        {
            log(name + "=");
        } //End block
        log(value);
        // ---------- Original Method ----------
        //if (mArgCount++ > 0) {
            //log(", ");
        //}
        //if (mLogArgumentNames) {
            //log(name + "=");
        //}
        //log(value);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.865 -0400", hash_original_method = "34DADD61F74380F23C382DA05A595428", hash_generated_method = "B9D1C3BCA829E316DC2B840473E126DE")
    private void end() {
        log(");\n");
        flush();
        // ---------- Original Method ----------
        //log(");\n");
        //flush();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.866 -0400", hash_original_method = "0CDA8C40EE3F1BEB19FC35DF0C9C3B14", hash_generated_method = "927A3CC15B210A38C80E3F1C30213844")
    private void flush() {
        try 
        {
            mLog.flush();
        } //End block
        catch (IOException e)
        {
            mLog = null;
        } //End block
        // ---------- Original Method ----------
        //try {
            //mLog.flush();
        //} catch (IOException e) {
            //mLog = null;
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.866 -0400", hash_original_method = "B92E6D1514E3DF39AF9DE02825B78605", hash_generated_method = "28D5EDBB11EB9542D1E4EDDD6466965E")
    private void arg(String name, int value) {
        addTaint(value);
        addTaint(name.getTaint());
        arg(name, Integer.toString(value));
        // ---------- Original Method ----------
        //arg(name, Integer.toString(value));
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.867 -0400", hash_original_method = "F32E9ED1A9AD790C0C3F824859AFFD50", hash_generated_method = "A44C78D54F83B42C98F5A87D7D592935")
    private void arg(String name, Object object) {
        addTaint(object.getTaint());
        addTaint(name.getTaint());
        arg(name, toString(object));
        // ---------- Original Method ----------
        //arg(name, toString(object));
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.867 -0400", hash_original_method = "01946A19C8705B92846E5FD249971514", hash_generated_method = "A3E0A404A5C22B6D9A5CBB341E7D5D8A")
    private void arg(String name, EGLDisplay object) {
        addTaint(object.getTaint());
        addTaint(name.getTaint());
        if(object == EGL10.EGL_DEFAULT_DISPLAY)        
        {
            arg(name, "EGL10.EGL_DEFAULT_DISPLAY");
        } //End block
        else
        if(object == EGL_NO_DISPLAY)        
        {
            arg(name, "EGL10.EGL_NO_DISPLAY");
        } //End block
        else
        {
            arg(name, toString(object));
        } //End block
        // ---------- Original Method ----------
        //if (object == EGL10.EGL_DEFAULT_DISPLAY) {
            //arg(name, "EGL10.EGL_DEFAULT_DISPLAY");
        //} else if (object == EGL_NO_DISPLAY) {
            //arg(name, "EGL10.EGL_NO_DISPLAY");
        //} else {
            //arg(name, toString(object));
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.868 -0400", hash_original_method = "01463BB924BE80515544A0A965E7A7B9", hash_generated_method = "2BD1B35FFCC0FA98B9ACD71B4D382F01")
    private void arg(String name, EGLContext object) {
        addTaint(object.getTaint());
        addTaint(name.getTaint());
        if(object == EGL10.EGL_NO_CONTEXT)        
        {
            arg(name, "EGL10.EGL_NO_CONTEXT");
        } //End block
        else
        {
            arg(name, toString(object));
        } //End block
        // ---------- Original Method ----------
        //if (object == EGL10.EGL_NO_CONTEXT) {
            //arg(name, "EGL10.EGL_NO_CONTEXT");
        //} else {
            //arg(name, toString(object));
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.868 -0400", hash_original_method = "29F033CFC0C7125F3850A082876BA169", hash_generated_method = "7C81A295FE5C876646AB0AA09D0EDD52")
    private void arg(String name, EGLSurface object) {
        addTaint(object.getTaint());
        addTaint(name.getTaint());
        if(object == EGL10.EGL_NO_SURFACE)        
        {
            arg(name, "EGL10.EGL_NO_SURFACE");
        } //End block
        else
        {
            arg(name, toString(object));
        } //End block
        // ---------- Original Method ----------
        //if (object == EGL10.EGL_NO_SURFACE) {
            //arg(name, "EGL10.EGL_NO_SURFACE");
        //} else {
            //arg(name, toString(object));
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.869 -0400", hash_original_method = "3FBBFC7C1FE2EDBEEE74392E2BA2D107", hash_generated_method = "9FA8054195C50DED8D4C1D1B38617FA0")
    private void returns(String result) {
        addTaint(result.getTaint());
        log(" returns " + result + ";\n");
        flush();
        // ---------- Original Method ----------
        //log(" returns " + result + ";\n");
        //flush();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.869 -0400", hash_original_method = "A943ABBAFE7E9588C2D5222F0375E708", hash_generated_method = "8FC8EA26A440313CE4C528916D1B6B45")
    private void returns(int result) {
        addTaint(result);
        returns(Integer.toString(result));
        // ---------- Original Method ----------
        //returns(Integer.toString(result));
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.869 -0400", hash_original_method = "F758ED771C34CA3F99E1517AB5DA84CC", hash_generated_method = "B27B28C66EF5EE19F9304D379FC76555")
    private void returns(boolean result) {
        addTaint(result);
        returns(Boolean.toString(result));
        // ---------- Original Method ----------
        //returns(Boolean.toString(result));
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.870 -0400", hash_original_method = "13511071C6DE4FFBB82F1BC04606E74C", hash_generated_method = "EA9B9C4262A1C12DB55A4D8784AC2A94")
    private void returns(Object result) {
        addTaint(result.getTaint());
        returns(toString(result));
        // ---------- Original Method ----------
        //returns(toString(result));
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.870 -0400", hash_original_method = "122D09D33E3C14E13BA1263367B842FD", hash_generated_method = "8D3364AFA11F51F645A220DBFEB1ECE8")
    private String toString(Object obj) {
        addTaint(obj.getTaint());
        if(obj == null)        
        {
String var1D801F10795A50869C3F1F514D9B9BF5_982033536 =             "null";
            var1D801F10795A50869C3F1F514D9B9BF5_982033536.addTaint(taint);
            return var1D801F10795A50869C3F1F514D9B9BF5_982033536;
        } //End block
        else
        {
String varCC7F0868C1207D03CC528BFE14315765_313194070 =             obj.toString();
            varCC7F0868C1207D03CC528BFE14315765_313194070.addTaint(taint);
            return varCC7F0868C1207D03CC528BFE14315765_313194070;
        } //End block
        // ---------- Original Method ----------
        //if (obj == null) {
            //return "null";
        //} else {
            //return obj.toString();
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.870 -0400", hash_original_method = "681A195715F2634EFD4F6574BD3918CD", hash_generated_method = "A863939EA707BA68479FF89CB6DDA064")
    private void arg(String name, int[] arr) {
        addTaint(arr[0]);
        addTaint(name.getTaint());
        if(arr == null)        
        {
            arg(name, "null");
        } //End block
        else
        {
            arg(name, toString(arr.length, arr, 0));
        } //End block
        // ---------- Original Method ----------
        //if (arr == null) {
            //arg(name, "null");
        //} else {
            //arg(name, toString(arr.length, arr, 0));
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.871 -0400", hash_original_method = "DD519F74DAF76C6EBE410B4846DBED4A", hash_generated_method = "DB296E2DE65B0F6C8FE099903B4A3485")
    private void arg(String name, Object[] arr) {
        addTaint(arr[0].getTaint());
        addTaint(name.getTaint());
        if(arr == null)        
        {
            arg(name, "null");
        } //End block
        else
        {
            arg(name, toString(arr.length, arr, 0));
        } //End block
        // ---------- Original Method ----------
        //if (arr == null) {
            //arg(name, "null");
        //} else {
            //arg(name, toString(arr.length, arr, 0));
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.871 -0400", hash_original_method = "83D3FA96B1354405A93359C25E36746A", hash_generated_method = "DAE4CDE871DD0CC5C887898C5429B7D1")
    private String toString(int n, int[] arr, int offset) {
        addTaint(offset);
        addTaint(arr[0]);
        addTaint(n);
        StringBuilder buf = new StringBuilder();
        buf.append("{\n");
        int arrLen = arr.length;
for(int i = 0;i < n;i++)
        {
            int index = offset + i;
            buf.append(" [" + index + "] = ");
            if(index < 0 || index >= arrLen)            
            {
                buf.append("out of bounds");
            } //End block
            else
            {
                buf.append(arr[index]);
            } //End block
            buf.append('\n');
        } //End block
        buf.append("}");
String var4FC680801218E6372BC708D6FA44AE60_169224365 =         buf.toString();
        var4FC680801218E6372BC708D6FA44AE60_169224365.addTaint(taint);
        return var4FC680801218E6372BC708D6FA44AE60_169224365;
        // ---------- Original Method ----------
        //StringBuilder buf = new StringBuilder();
        //buf.append("{\n");
        //int arrLen = arr.length;
        //for (int i = 0; i < n; i++) {
            //int index = offset + i;
            //buf.append(" [" + index + "] = ");
            //if (index < 0 || index >= arrLen) {
                //buf.append("out of bounds");
            //} else {
                //buf.append(arr[index]);
            //}
            //buf.append('\n');
        //}
        //buf.append("}");
        //return buf.toString();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.872 -0400", hash_original_method = "76307B205B17F18B9623C7717F9DB208", hash_generated_method = "FFBD794485CFE433654702BA0AEB1184")
    private String toString(int n, Object[] arr, int offset) {
        addTaint(offset);
        addTaint(arr[0].getTaint());
        addTaint(n);
        StringBuilder buf = new StringBuilder();
        buf.append("{\n");
        int arrLen = arr.length;
for(int i = 0;i < n;i++)
        {
            int index = offset + i;
            buf.append(" [" + index + "] = ");
            if(index < 0 || index >= arrLen)            
            {
                buf.append("out of bounds");
            } //End block
            else
            {
                buf.append(arr[index]);
            } //End block
            buf.append('\n');
        } //End block
        buf.append("}");
String var4FC680801218E6372BC708D6FA44AE60_1006769629 =         buf.toString();
        var4FC680801218E6372BC708D6FA44AE60_1006769629.addTaint(taint);
        return var4FC680801218E6372BC708D6FA44AE60_1006769629;
        // ---------- Original Method ----------
        //StringBuilder buf = new StringBuilder();
        //buf.append("{\n");
        //int arrLen = arr.length;
        //for (int i = 0; i < n; i++) {
            //int index = offset + i;
            //buf.append(" [" + index + "] = ");
            //if (index < 0 || index >= arrLen) {
                //buf.append("out of bounds");
            //} else {
                //buf.append(arr[index]);
            //}
            //buf.append('\n');
        //}
        //buf.append("}");
        //return buf.toString();
    }

    
    @DSModeled(DSC.BAN)
    private static String getHex(int value) {
        return "0x" + Integer.toHexString(value);
    }

    
    @DSModeled(DSC.SAFE)
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

    
}

