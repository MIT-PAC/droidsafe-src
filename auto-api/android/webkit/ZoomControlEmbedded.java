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
    private ZoomManager mZoomManager;
    private WebView mWebView;
    private ZoomButtonsController mZoomButtonsController;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.379 -0400", hash_original_method = "58B848602B04675A34284534D0242989", hash_generated_method = "2E362A4A3F55C71A642B5620EE540DBE")
    @DSModeled(DSC.SAFE)
    public ZoomControlEmbedded(ZoomManager zoomManager, WebView webView) {
        dsTaint.addTaint(zoomManager.dsTaint);
        dsTaint.addTaint(webView.dsTaint);
        // ---------- Original Method ----------
        //mZoomManager = zoomManager;
        //mWebView = webView;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.379 -0400", hash_original_method = "AC6DDF8CBB501A63B7872C74FE4374B8", hash_generated_method = "F19B83A03197C09DD26B545A33C78F64")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void show() {
        {
            boolean var99BDE83FE337F71B4919876538F99DB9_1023488370 = (!getControls().isVisible() && !mZoomManager.isZoomScaleFixed());
            {
                mZoomButtonsController.setVisible(true);
                {
                    boolean var9402235A4158A997857D36B765252261_833394818 = (mZoomManager.isDoubleTapEnabled());
                    {
                        WebSettings settings;
                        settings = mWebView.getSettings();
                        int count;
                        count = settings.getDoubleTapToastCount();
                        {
                            boolean varE34F55A99EB1D386B61E32D5DFBEBB26_546861587 = (mZoomManager.isInZoomOverview() && count > 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.380 -0400", hash_original_method = "01D9936CB3AEEFE463F6049C6D59A6E4", hash_generated_method = "5C1E0742971E4BE0A2E033A253B341B8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void hide() {
        {
            mZoomButtonsController.setVisible(false);
        } //End block
        // ---------- Original Method ----------
        //if (mZoomButtonsController != null) {
            //mZoomButtonsController.setVisible(false);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.380 -0400", hash_original_method = "518B1D44CA5DDB1FC736D41ED30011CF", hash_generated_method = "450501D67283312C8C821306B98AE31D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isVisible() {
        boolean var80F67F4A6DBC9CA7F3BDBA7D6D84682D_1885101780 = (mZoomButtonsController != null && mZoomButtonsController.isVisible());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mZoomButtonsController != null && mZoomButtonsController.isVisible();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.380 -0400", hash_original_method = "3EEB1B7639B141DBF4A839E2ACE958E1", hash_generated_method = "4A5C4801AC3ED2C4517B0645D2B2C172")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.380 -0400", hash_original_method = "0263F8BCA60BCA372CF61DE8AB7A303B", hash_generated_method = "D07D052C16D67E89A949C1501043B5A3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private ZoomButtonsController getControls() {
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
        return (ZoomButtonsController)dsTaint.getTaint();
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.381 -0400", hash_original_method = "ED32378DF741CF08FEA4F1C06B62FDD3", hash_generated_method = "ED32378DF741CF08FEA4F1C06B62FDD3")
                public ZoomListener ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.381 -0400", hash_original_method = "CAB57885F430D7392888CFD12B17B225", hash_generated_method = "F7FC347C73408899CDE214635003DBF0")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void onVisibilityChanged(boolean visible) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(visible);
            {
                mWebView.switchOutDrawHistory();
                mZoomButtonsController.getZoomControls().setVisibility(View.VISIBLE);
                update();
            } //End block
            // ---------- Original Method ----------
            //if (visible) {
                //mWebView.switchOutDrawHistory();
                //mZoomButtonsController.getZoomControls().setVisibility(View.VISIBLE);
                //update();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.381 -0400", hash_original_method = "A16881C1E119771D4FCCD4DE4DCAF173", hash_generated_method = "904238ACAD1EF3E811E961DC2F7DB3D5")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void onZoom(boolean zoomIn) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(zoomIn);
            {
                mWebView.zoomIn();
            } //End block
            {
                mWebView.zoomOut();
            } //End block
            update();
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

