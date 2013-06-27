package android.webkit;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public final class DeviceMotionAndOrientationManager {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:57.999 -0400", hash_original_field = "9371E2004CE9EC2E60E3F0EBE8ED2E84", hash_generated_field = "73DACDCC92B5BF8822959B0368CF2255")

    private WebViewCore mWebViewCore;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.000 -0400", hash_original_method = "4CABCA1B40F3E929EC370CEBD3D74690", hash_generated_method = "B530AA45CFBA2E928BEAE49927EDFD96")
    public  DeviceMotionAndOrientationManager(WebViewCore webViewCore) {
        mWebViewCore = webViewCore;
        // ---------- Original Method ----------
        //mWebViewCore = webViewCore;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.000 -0400", hash_original_method = "591CB7A3D11D3A931F472B1CBCBD3C6F", hash_generated_method = "1E9561F17704E8BECA6E2C74720BC0FF")
    public void useMock() {
        nativeUseMock(mWebViewCore);
        // ---------- Original Method ----------
        //assert WebViewCore.THREAD_NAME.equals(Thread.currentThread().getName());
        //nativeUseMock(mWebViewCore);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.000 -0400", hash_original_method = "4286A0C5B7CC1E24AD50574E75188454", hash_generated_method = "D7288A489EC9FECB89B59CAF60F58264")
    public void setMockOrientation(boolean canProvideAlpha, double alpha, boolean canProvideBeta,
            double beta, boolean canProvideGamma, double gamma) {
        nativeSetMockOrientation(mWebViewCore, canProvideAlpha, alpha, canProvideBeta, beta,
                canProvideGamma, gamma);
        addTaint(canProvideAlpha);
        addTaint(alpha);
        addTaint(canProvideBeta);
        addTaint(beta);
        addTaint(canProvideGamma);
        addTaint(gamma);
        // ---------- Original Method ----------
        //assert WebViewCore.THREAD_NAME.equals(Thread.currentThread().getName());
        //nativeSetMockOrientation(mWebViewCore, canProvideAlpha, alpha, canProvideBeta, beta,
                //canProvideGamma, gamma);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.008 -0400", hash_original_method = "2AF261550854349B7D04FA666A22BAC6", hash_generated_method = "FD5626665B0D96680FEEEA922120292A")
    public void onMotionChange(Double x, Double y, Double z, double interval) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        nativeOnMotionChange(mWebViewCore,
                x != null, x != null ? x.doubleValue() : 0.0,
                y != null, y != null ? y.doubleValue() : 0.0,
                z != null, z != null ? z.doubleValue() : 0.0,
                interval);
        addTaint(x.getTaint());
        addTaint(y.getTaint());
        addTaint(z.getTaint());
        addTaint(interval);
        // ---------- Original Method ----------
        //nativeOnMotionChange(mWebViewCore,
                //x != null, x != null ? x.doubleValue() : 0.0,
                //y != null, y != null ? y.doubleValue() : 0.0,
                //z != null, z != null ? z.doubleValue() : 0.0,
                //interval);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.009 -0400", hash_original_method = "6B027F62004F2780826093ACE4A2C2BC", hash_generated_method = "9679D731641386CBA3B5FBE88F15D60C")
    public void onOrientationChange(Double alpha, Double beta, Double gamma) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        nativeOnOrientationChange(mWebViewCore,
                alpha != null, alpha != null ? alpha.doubleValue() : 0.0,
                beta != null, beta != null ? beta.doubleValue() : 0.0,
                gamma != null, gamma != null ? gamma.doubleValue() : 0.0);
        addTaint(alpha.getTaint());
        addTaint(beta.getTaint());
        addTaint(gamma.getTaint());
        // ---------- Original Method ----------
        //nativeOnOrientationChange(mWebViewCore,
                //alpha != null, alpha != null ? alpha.doubleValue() : 0.0,
                //beta != null, beta != null ? beta.doubleValue() : 0.0,
                //gamma != null, gamma != null ? gamma.doubleValue() : 0.0);
    }

    
        private static void nativeUseMock(WebViewCore webViewCore) {
    }

    
        private static void nativeSetMockOrientation(WebViewCore webViewCore,
            boolean canProvideAlpha, double alpha, boolean canProvideBeta, double beta,
            boolean canProvideGamma, double gamma) {
    }

    
        private static void nativeOnMotionChange(WebViewCore webViewCore,
            boolean canProvideX, double x, boolean canProvideY, double y,
            boolean canProvideZ, double z, double interval) {
    }

    
        private static void nativeOnOrientationChange(WebViewCore webViewCore,
            boolean canProvideAlpha, double alpha, boolean canProvideBeta, double beta,
            boolean canProvideGamma, double gamma) {
    }

    
}

