package android.webkit;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;





public final class DeviceMotionAndOrientationManager {

    
    @DSModeled(DSC.SAFE)
    private static void nativeUseMock(WebViewCore webViewCore) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void nativeSetMockOrientation(WebViewCore webViewCore,
            boolean canProvideAlpha, double alpha, boolean canProvideBeta, double beta,
            boolean canProvideGamma, double gamma) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void nativeOnMotionChange(WebViewCore webViewCore,
            boolean canProvideX, double x, boolean canProvideY, double y,
            boolean canProvideZ, double z, double interval) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void nativeOnOrientationChange(WebViewCore webViewCore,
            boolean canProvideAlpha, double alpha, boolean canProvideBeta, double beta,
            boolean canProvideGamma, double gamma) {
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:29.498 -0500", hash_original_field = "799AB033E7CD1CC92AF93A69917908BF", hash_generated_field = "73DACDCC92B5BF8822959B0368CF2255")

    private WebViewCore mWebViewCore;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:29.499 -0500", hash_original_method = "4CABCA1B40F3E929EC370CEBD3D74690", hash_generated_method = "E78147A0F2EF62F0D15CB5510C5EFE81")
    public DeviceMotionAndOrientationManager(WebViewCore webViewCore) {
        mWebViewCore = webViewCore;
    }

    /**
     * Sets whether the Page for this WebViewCore should use a mock DeviceOrientation
     * client.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:29.499 -0500", hash_original_method = "591CB7A3D11D3A931F472B1CBCBD3C6F", hash_generated_method = "063E3DA94D0B0304A0EC19A259741FF0")
    public void useMock() {
        assert WebViewCore.THREAD_NAME.equals(Thread.currentThread().getName());
        nativeUseMock(mWebViewCore);
    }

    /**
     * Set the position for the mock DeviceOrientation service for this WebViewCore.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:29.500 -0500", hash_original_method = "4286A0C5B7CC1E24AD50574E75188454", hash_generated_method = "7EB9E4EACD08F2A677CC0865562E8ED1")
    public void setMockOrientation(boolean canProvideAlpha, double alpha, boolean canProvideBeta,
            double beta, boolean canProvideGamma, double gamma) {
        assert WebViewCore.THREAD_NAME.equals(Thread.currentThread().getName());
        nativeSetMockOrientation(mWebViewCore, canProvideAlpha, alpha, canProvideBeta, beta,
                canProvideGamma, gamma);
    }

    // We only provide accelerationIncludingGravity.
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:29.501 -0500", hash_original_method = "2AF261550854349B7D04FA666A22BAC6", hash_generated_method = "83E01AF051BD0EA68BB9C5A619D91F1E")
    public void onMotionChange(Double x, Double y, Double z, double interval) {
        nativeOnMotionChange(mWebViewCore,
                x != null, x != null ? x.doubleValue() : 0.0,
                y != null, y != null ? y.doubleValue() : 0.0,
                z != null, z != null ? z.doubleValue() : 0.0,
                interval);
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:29.502 -0500", hash_original_method = "6B027F62004F2780826093ACE4A2C2BC", hash_generated_method = "DEE03E83349226B068B1F7D9665BB896")
    public void onOrientationChange(Double alpha, Double beta, Double gamma) {
        nativeOnOrientationChange(mWebViewCore,
                alpha != null, alpha != null ? alpha.doubleValue() : 0.0,
                beta != null, beta != null ? beta.doubleValue() : 0.0,
                gamma != null, gamma != null ? gamma.doubleValue() : 0.0);
    }

    
}

