package android.webkit;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;
import android.widget.ZoomButtonsController;

class ZoomControlEmbedded implements ZoomControlBase {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:01.123 -0400", hash_original_field = "61BC42C317CA14BCEFF4FD2F3EBC8E34", hash_generated_field = "9B99C2FE2EA0A3C0CAEC1D267CB6150C")

    private ZoomManager mZoomManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:01.123 -0400", hash_original_field = "72439B8F99EB438C3DA5D9CD798C6786", hash_generated_field = "99346B50377E115231263981E00655CA")

    private WebView mWebView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:01.123 -0400", hash_original_field = "BF7E3585F7DD6E770EB21D3F6C8B81A5", hash_generated_field = "A8A0DD9E8E1D109A248CAEBBC4A8688D")

    private ZoomButtonsController mZoomButtonsController;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:01.123 -0400", hash_original_method = "58B848602B04675A34284534D0242989", hash_generated_method = "1DA489FE3D377B93AABC14896EC5C4EF")
    public  ZoomControlEmbedded(ZoomManager zoomManager, WebView webView) {
        mZoomManager = zoomManager;
        mWebView = webView;
        // ---------- Original Method ----------
        //mZoomManager = zoomManager;
        //mWebView = webView;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:01.151 -0400", hash_original_method = "AC6DDF8CBB501A63B7872C74FE4374B8", hash_generated_method = "8B855E7CA487EB89F31D0B6AA05567E4")
    public void show() {
        {
            boolean var99BDE83FE337F71B4919876538F99DB9_1193609216 = (!getControls().isVisible() && !mZoomManager.isZoomScaleFixed());
            {
                mZoomButtonsController.setVisible(true);
                {
                    boolean var9402235A4158A997857D36B765252261_2025785952 = (mZoomManager.isDoubleTapEnabled());
                    {
                        WebSettings settings;
                        settings = mWebView.getSettings();
                        int count;
                        count = settings.getDoubleTapToastCount();
                        {
                            boolean varE34F55A99EB1D386B61E32D5DFBEBB26_991413682 = (mZoomManager.isInZoomOverview() && count > 0);
                            {
                                settings.setDoubleTapToastCount(--count);
                                Toast.makeText(mWebView.getContext(),
                            com.android.internal.R.string.double_tap_toast,
                            Toast.LENGTH_LONG).show();
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (!getControls().isVisible() && !mZoomManager.isZoomScaleFixed()) {
            //mZoomButtonsController.setVisible(true);
            //if (mZoomManager.isDoubleTapEnabled()) {
                //WebSettings settings = mWebView.getSettings();
                //int count = settings.getDoubleTapToastCount();
                //if (mZoomManager.isInZoomOverview() && count > 0) {
                    //settings.setDoubleTapToastCount(--count);
                    //Toast.makeText(mWebView.getContext(),
                            //com.android.internal.R.string.double_tap_toast,
                            //Toast.LENGTH_LONG).show();
                //}
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:01.152 -0400", hash_original_method = "01D9936CB3AEEFE463F6049C6D59A6E4", hash_generated_method = "5C1E0742971E4BE0A2E033A253B341B8")
    public void hide() {
        {
            mZoomButtonsController.setVisible(false);
        } //End block
        // ---------- Original Method ----------
        //if (mZoomButtonsController != null) {
            //mZoomButtonsController.setVisible(false);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:01.152 -0400", hash_original_method = "518B1D44CA5DDB1FC736D41ED30011CF", hash_generated_method = "095FC1F6DDF385474B438ED1A56FBA7F")
    public boolean isVisible() {
        boolean var80F67F4A6DBC9CA7F3BDBA7D6D84682D_845832730 = (mZoomButtonsController != null && mZoomButtonsController.isVisible());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1578195928 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1578195928;
        // ---------- Original Method ----------
        //return mZoomButtonsController != null && mZoomButtonsController.isVisible();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:01.156 -0400", hash_original_method = "3EEB1B7639B141DBF4A839E2ACE958E1", hash_generated_method = "4A5C4801AC3ED2C4517B0645D2B2C172")
    public void update() {
        boolean canZoomIn;
        canZoomIn = mZoomManager.canZoomIn();
        boolean canZoomOut;
        canZoomOut = mZoomManager.canZoomOut() && !mZoomManager.isInZoomOverview();
        {
            mZoomButtonsController.getZoomControls().setVisibility(View.GONE);
        } //End block
        {
            mZoomButtonsController.setZoomInEnabled(canZoomIn);
            mZoomButtonsController.setZoomOutEnabled(canZoomOut);
        } //End block
        // ---------- Original Method ----------
        //if (mZoomButtonsController == null) {
            //return;
        //}
        //boolean canZoomIn = mZoomManager.canZoomIn();
        //boolean canZoomOut = mZoomManager.canZoomOut() && !mZoomManager.isInZoomOverview();
        //if (!canZoomIn && !canZoomOut) {
            //mZoomButtonsController.getZoomControls().setVisibility(View.GONE);
        //} else {
            //mZoomButtonsController.setZoomInEnabled(canZoomIn);
            //mZoomButtonsController.setZoomOutEnabled(canZoomOut);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:01.157 -0400", hash_original_method = "0263F8BCA60BCA372CF61DE8AB7A303B", hash_generated_method = "6032AA9E029A95402ED88C246F57F540")
    private ZoomButtonsController getControls() {
        ZoomButtonsController varB4EAC82CA7396A68D541C85D26508E83_1534418326 = null; //Variable for return #1
        {
            mZoomButtonsController = new ZoomButtonsController(mWebView);
            mZoomButtonsController.setOnZoomListener(new ZoomListener());
            View controls;
            controls = mZoomButtonsController.getZoomControls();
            ViewGroup.LayoutParams params;
            params = controls.getLayoutParams();
            {
                ((FrameLayout.LayoutParams) params).gravity = Gravity.RIGHT;
            } //End block
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1534418326 = mZoomButtonsController;
        varB4EAC82CA7396A68D541C85D26508E83_1534418326.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1534418326;
        // ---------- Original Method ----------
        //if (mZoomButtonsController == null) {
            //mZoomButtonsController = new ZoomButtonsController(mWebView);
            //mZoomButtonsController.setOnZoomListener(new ZoomListener());
            //View controls = mZoomButtonsController.getZoomControls();
            //ViewGroup.LayoutParams params = controls.getLayoutParams();
            //if (params instanceof FrameLayout.LayoutParams) {
                //((FrameLayout.LayoutParams) params).gravity = Gravity.RIGHT;
            //}
        //}
        //return mZoomButtonsController;
    }

    
    private class ZoomListener implements ZoomButtonsController.OnZoomListener {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:01.157 -0400", hash_original_method = "97A31822F6766CF42618FF6D567EE294", hash_generated_method = "97A31822F6766CF42618FF6D567EE294")
        public ZoomListener ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:01.157 -0400", hash_original_method = "CAB57885F430D7392888CFD12B17B225", hash_generated_method = "8FF895FBB8D9E9C4EA66CF68F1381998")
        public void onVisibilityChanged(boolean visible) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            {
                mWebView.switchOutDrawHistory();
                mZoomButtonsController.getZoomControls().setVisibility(View.VISIBLE);
                update();
            } //End block
            addTaint(visible);
            // ---------- Original Method ----------
            //if (visible) {
                //mWebView.switchOutDrawHistory();
                //mZoomButtonsController.getZoomControls().setVisibility(View.VISIBLE);
                //update();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:01.170 -0400", hash_original_method = "A16881C1E119771D4FCCD4DE4DCAF173", hash_generated_method = "79B0793B5DE6B1A19DC4F8D568F665BB")
        public void onZoom(boolean zoomIn) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            {
                mWebView.zoomIn();
            } //End block
            {
                mWebView.zoomOut();
            } //End block
            update();
            addTaint(zoomIn);
            // ---------- Original Method ----------
            //if (zoomIn) {
                //mWebView.zoomIn();
            //} else {
                //mWebView.zoomOut();
            //}
            //update();
        }

        
    }


    
}

