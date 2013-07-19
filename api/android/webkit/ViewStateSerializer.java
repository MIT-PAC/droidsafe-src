package android.webkit;

// Droidsafe Imports
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.graphics.Point;
import android.graphics.Region;
import android.webkit.WebViewCore.DrawData;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;
import droidsafe.helpers.DSUtils;

class ViewStateSerializer {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.294 -0400", hash_original_method = "49BFAAEC63FD743661F2FA5579ECB6BF", hash_generated_method = "118ABB2718261FF45C39549C1EF9F141")
    private  ViewStateSerializer() {
        // ---------- Original Method ----------
    }

    
    static boolean serializeViewState(OutputStream stream, WebView web) throws IOException {
        int baseLayer = web.getBaseLayer();
        if (baseLayer == 0) {
            return false;
        }
        DataOutputStream dos = new DataOutputStream(stream);
        dos.writeInt(VERSION);
        dos.writeInt(web.getContentWidth());
        dos.writeInt(web.getContentHeight());
        return nativeSerializeViewState(baseLayer, dos,
                new byte[WORKING_STREAM_STORAGE]);
    }

    
    static DrawData deserializeViewState(InputStream stream, WebView web) throws IOException {
        DataInputStream dis = new DataInputStream(stream);
        int version = dis.readInt();
        if (version != VERSION) {
            throw new IOException("Unexpected version: " + version);
        }
        int contentWidth = dis.readInt();
        int contentHeight = dis.readInt();
        int baseLayer = nativeDeserializeViewState(dis,
                new byte[WORKING_STREAM_STORAGE]);
        final WebViewCore.DrawData draw = new WebViewCore.DrawData();
        draw.mViewState = new WebViewCore.ViewState();
        int viewWidth = web.getViewWidth();
        int viewHeight = web.getViewHeightWithTitle() - web.getTitleHeight();
        draw.mViewSize = new Point(viewWidth, viewHeight);
        draw.mContentSize = new Point(contentWidth, contentHeight);
        draw.mViewState.mDefaultScale = web.getDefaultZoomScale();
        draw.mBaseLayer = baseLayer;
        draw.mInvalRegion = new Region(0, 0, contentWidth, contentHeight);
        return draw;
    }

    
    @DSModeled(DSC.SAFE)
    private static boolean nativeSerializeViewState(int baseLayer,
            OutputStream stream, byte[] storage) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSModeled(DSC.SAFE)
    private static int nativeDeserializeViewState(
            InputStream stream, byte[] storage) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.296 -0400", hash_original_field = "324F32D1CC16C414475D1414D2041A3B", hash_generated_field = "16A3D3E1F1A46232673D292E95776672")

    private static final int WORKING_STREAM_STORAGE = 16 * 1024;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.297 -0400", hash_original_field = "B2D9386FD77395AEBE0B153BAD0CF478", hash_generated_field = "C4C590CA9F059E3E20E236FD779C6637")

    static final int VERSION = 1;
}

