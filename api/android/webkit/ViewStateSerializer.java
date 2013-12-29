package android.webkit;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.graphics.Point;
import android.graphics.Region;
import android.webkit.WebViewCore.DrawData;




import droidsafe.helpers.DSUtils;

class ViewStateSerializer {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:22.488 -0500", hash_original_method = "1EF06B01DEFC03F0294E2EE5BC731C9C", hash_generated_method = "B43AF825380E83A00B9112FC5C7D13E6")
    static boolean serializeViewState(OutputStream stream, WebView web)
            throws IOException {
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:22.489 -0500", hash_original_method = "740591971B604C9B95CAEBB1564A3BD3", hash_generated_method = "654562A21ECB0146F219616D2189591A")
    static DrawData deserializeViewState(InputStream stream, WebView web)
            throws IOException {
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:22.486 -0500", hash_original_field = "93DB6FF890F60901303B2AEAD85141C3", hash_generated_field = "16A3D3E1F1A46232673D292E95776672")


    private static final int WORKING_STREAM_STORAGE = 16 * 1024;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:22.487 -0500", hash_original_field = "965BFA0136A42F88AEBCBAB90EBADD3A", hash_generated_field = "C4C590CA9F059E3E20E236FD779C6637")


    static final int VERSION = 1;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:22.492 -0500", hash_original_method = "49BFAAEC63FD743661F2FA5579ECB6BF", hash_generated_method = "DA8C7636A19B2A584C27A6067BDE4401")
    private ViewStateSerializer() {}
}

