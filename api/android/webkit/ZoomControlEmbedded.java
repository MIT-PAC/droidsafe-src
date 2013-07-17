package android.webkit;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;
import android.widget.ZoomButtonsController;

class ZoomControlEmbedded implements ZoomControlBase {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.580 -0400", hash_original_field = "61BC42C317CA14BCEFF4FD2F3EBC8E34", hash_generated_field = "9B99C2FE2EA0A3C0CAEC1D267CB6150C")

    private ZoomManager mZoomManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.580 -0400", hash_original_field = "72439B8F99EB438C3DA5D9CD798C6786", hash_generated_field = "99346B50377E115231263981E00655CA")

    private WebView mWebView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.581 -0400", hash_original_field = "BF7E3585F7DD6E770EB21D3F6C8B81A5", hash_generated_field = "A8A0DD9E8E1D109A248CAEBBC4A8688D")

    private ZoomButtonsController mZoomButtonsController;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.581 -0400", hash_original_method = "58B848602B04675A34284534D0242989", hash_generated_method = "1DA489FE3D377B93AABC14896EC5C4EF")
    public  ZoomControlEmbedded(ZoomManager zoomManager, WebView webView) {
        mZoomManager = zoomManager;
        mWebView = webView;
        // ---------- Original Method ----------
        //mZoomManager = zoomManager;
        //mWebView = webView;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.582 -0400", hash_original_method = "AC6DDF8CBB501A63B7872C74FE4374B8", hash_generated_method = "1A28E8477C555DB0AEDA75C30B6B794D")
    public void show() {
        if(!getControls().isVisible() && !mZoomManager.isZoomScaleFixed())        
        {
            mZoomButtonsController.setVisible(true);
            if(mZoomManager.isDoubleTapEnabled())            
            {
                WebSettings settings = mWebView.getSettings();
                int count = settings.getDoubleTapToastCount();
                if(mZoomManager.isInZoomOverview() && count > 0)                
                {
                    settings.setDoubleTapToastCount(--count);
                    Toast.makeText(mWebView.getContext(),
                            com.android.internal.R.string.double_tap_toast,
                            Toast.LENGTH_LONG).show();
                } //End block
            } //End block
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.582 -0400", hash_original_method = "01D9936CB3AEEFE463F6049C6D59A6E4", hash_generated_method = "912A6ED3B2CAD76F92BF6854B868239B")
    public void hide() {
        if(mZoomButtonsController != null)        
        {
            mZoomButtonsController.setVisible(false);
        } //End block
        // ---------- Original Method ----------
        //if (mZoomButtonsController != null) {
            //mZoomButtonsController.setVisible(false);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.582 -0400", hash_original_method = "518B1D44CA5DDB1FC736D41ED30011CF", hash_generated_method = "A74FDEBED925D34CD0B62EFDD07EBDD0")
    public boolean isVisible() {
        boolean var8C5CB663405B3296CE37A0A59A033D65_715325723 = (mZoomButtonsController != null && mZoomButtonsController.isVisible());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1669090212 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1669090212;
        // ---------- Original Method ----------
        //return mZoomButtonsController != null && mZoomButtonsController.isVisible();
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.583 -0400", hash_original_method = "3EEB1B7639B141DBF4A839E2ACE958E1", hash_generated_method = "94A1E6D0BA86E472CCB24703F0D38AC5")
    public void update() {
        if(mZoomButtonsController == null)        
        {
            return;
        } //End block
        boolean canZoomIn = mZoomManager.canZoomIn();
        boolean canZoomOut = mZoomManager.canZoomOut() && !mZoomManager.isInZoomOverview();
        if(!canZoomIn && !canZoomOut)        
        {
            mZoomButtonsController.getZoomControls().setVisibility(View.GONE);
        } //End block
        else
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.584 -0400", hash_original_method = "0263F8BCA60BCA372CF61DE8AB7A303B", hash_generated_method = "2806508593E16D71FD51D18EF2D23597")
    private ZoomButtonsController getControls() {
        if(mZoomButtonsController == null)        
        {
            mZoomButtonsController = new ZoomButtonsController(mWebView);
            mZoomButtonsController.setOnZoomListener(new ZoomListener());
            View controls = mZoomButtonsController.getZoomControls();
            ViewGroup.LayoutParams params = controls.getLayoutParams();
            if(params instanceof FrameLayout.LayoutParams)            
            {
                ((FrameLayout.LayoutParams) params).gravity = Gravity.RIGHT;
            } //End block
        } //End block
ZoomButtonsController var63565BB54144B4ECD496B8D8A0409C92_991097420 =         mZoomButtonsController;
        var63565BB54144B4ECD496B8D8A0409C92_991097420.addTaint(taint);
        return var63565BB54144B4ECD496B8D8A0409C92_991097420;
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.584 -0400", hash_original_method = "97A31822F6766CF42618FF6D567EE294", hash_generated_method = "97A31822F6766CF42618FF6D567EE294")
        public ZoomListener ()
        {
            //Synthesized constructor
        }


                @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.585 -0400", hash_original_method = "CAB57885F430D7392888CFD12B17B225", hash_generated_method = "D1B2D1C2CFDE0020D266B7E083F173E5")
        public void onVisibilityChanged(boolean visible) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(visible);
            if(visible)            
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

        
                @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.585 -0400", hash_original_method = "A16881C1E119771D4FCCD4DE4DCAF173", hash_generated_method = "2831C0F143F93F97D96A757365DD63F5")
        public void onZoom(boolean zoomIn) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(zoomIn);
            if(zoomIn)            
            {
                mWebView.zoomIn();
            } //End block
            else
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

