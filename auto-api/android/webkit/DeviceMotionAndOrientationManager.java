package android.webkit;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public final class DeviceMotionAndOrientationManager {
    private WebViewCore mWebViewCore;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.120 -0400", hash_original_method = "4CABCA1B40F3E929EC370CEBD3D74690", hash_generated_method = "85C467EC382163EC58F5F7FD5D75BD4C")
    @DSModeled(DSC.SAFE)
    public DeviceMotionAndOrientationManager(WebViewCore webViewCore) {
        dsTaint.addTaint(webViewCore.dsTaint);
        // ---------- Original Method ----------
        //mWebViewCore = webViewCore;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.121 -0400", hash_original_method = "591CB7A3D11D3A931F472B1CBCBD3C6F", hash_generated_method = "1E9561F17704E8BECA6E2C74720BC0FF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void useMock() {
        nativeUseMock(mWebViewCore);
        // ---------- Original Method ----------
        //assert WebViewCore.THREAD_NAME.equals(Thread.currentThread().getName());
        //nativeUseMock(mWebViewCore);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.123 -0400", hash_original_method = "4286A0C5B7CC1E24AD50574E75188454", hash_generated_method = "ED279297B293E7F1F72118D7A0D0646C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setMockOrientation(boolean canProvideAlpha, double alpha, boolean canProvideBeta,
            double beta, boolean canProvideGamma, double gamma) {
        dsTaint.addTaint(gamma);
        dsTaint.addTaint(canProvideGamma);
        dsTaint.addTaint(canProvideBeta);
        dsTaint.addTaint(alpha);
        dsTaint.addTaint(beta);
        dsTaint.addTaint(canProvideAlpha);
        nativeSetMockOrientation(mWebViewCore, canProvideAlpha, alpha, canProvideBeta, beta,
                canProvideGamma, gamma);
        // ---------- Original Method ----------
        //assert WebViewCore.THREAD_NAME.equals(Thread.currentThread().getName());
        //nativeSetMockOrientation(mWebViewCore, canProvideAlpha, alpha, canProvideBeta, beta,
                //canProvideGamma, gamma);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.124 -0400", hash_original_method = "2AF261550854349B7D04FA666A22BAC6", hash_generated_method = "688DF1ABECFBF6831053D00D6BAFE94F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onMotionChange(Double x, Double y, Double z, double interval) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(interval);
        dsTaint.addTaint(z.dsTaint);
        dsTaint.addTaint(y.dsTaint);
        dsTaint.addTaint(x.dsTaint);
        nativeOnMotionChange(mWebViewCore,
                x != null, x != null ? x.doubleValue() : 0.0,
                y != null, y != null ? y.doubleValue() : 0.0,
                z != null, z != null ? z.doubleValue() : 0.0,
                interval);
        // ---------- Original Method ----------
        //nativeOnMotionChange(mWebViewCore,
                //x != null, x != null ? x.doubleValue() : 0.0,
                //y != null, y != null ? y.doubleValue() : 0.0,
                //z != null, z != null ? z.doubleValue() : 0.0,
                //interval);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.124 -0400", hash_original_method = "6B027F62004F2780826093ACE4A2C2BC", hash_generated_method = "6A35ED95905DD64E3F87233546FC2B18")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onOrientationChange(Double alpha, Double beta, Double gamma) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(gamma.dsTaint);
        dsTaint.addTaint(alpha.dsTaint);
        dsTaint.addTaint(beta.dsTaint);
        nativeOnOrientationChange(mWebViewCore,
                alpha != null, alpha != null ? alpha.doubleValue() : 0.0,
                beta != null, beta != null ? beta.doubleValue() : 0.0,
                gamma != null, gamma != null ? gamma.doubleValue() : 0.0);
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

