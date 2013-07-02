package android.webkit;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;
import android.widget.ZoomButtonsController;

class ZoomControlEmbedded implements ZoomControlBase {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.062 -0400", hash_original_field = "61BC42C317CA14BCEFF4FD2F3EBC8E34", hash_generated_field = "9B99C2FE2EA0A3C0CAEC1D267CB6150C")

    private ZoomManager mZoomManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.062 -0400", hash_original_field = "72439B8F99EB438C3DA5D9CD798C6786", hash_generated_field = "99346B50377E115231263981E00655CA")

    private WebView mWebView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.062 -0400", hash_original_field = "BF7E3585F7DD6E770EB21D3F6C8B81A5", hash_generated_field = "A8A0DD9E8E1D109A248CAEBBC4A8688D")

    private ZoomButtonsController mZoomButtonsController;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.062 -0400", hash_original_method = "58B848602B04675A34284534D0242989", hash_generated_method = "1DA489FE3D377B93AABC14896EC5C4EF")
    public  ZoomControlEmbedded(ZoomManager zoomManager, WebView webView) {
        mZoomManager = zoomManager;
        mWebView = webView;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.063 -0400", hash_original_method = "AC6DDF8CBB501A63B7872C74FE4374B8", hash_generated_method = "E715051B178A4715B071D1B840FBEB2D")
    public void show() {
        {
            boolean var99BDE83FE337F71B4919876538F99DB9_1639061828 = (!getControls().isVisible() && !mZoomManager.isZoomScaleFixed());
            {
                mZoomButtonsController.setVisible(true);
                {
                    boolean var9402235A4158A997857D36B765252261_1663716251 = (mZoomManager.isDoubleTapEnabled());
                    {
                        WebSettings settings = mWebView.getSettings();
                        int count = settings.getDoubleTapToastCount();
                        {
                            boolean varE34F55A99EB1D386B61E32D5DFBEBB26_112925665 = (mZoomManager.isInZoomOverview() && count > 0);
                            {
                                settings.setDoubleTapToastCount(--count);
                                Toast.makeText(mWebView.getContext(),
                            com.android.internal.R.string.double_tap_toast,
                            Toast.LENGTH_LONG).show();
                            } 
                        } 
                    } 
                } 
            } 
        } 
        
        
            
            
                
                
                
                    
                    
                            
                            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.063 -0400", hash_original_method = "01D9936CB3AEEFE463F6049C6D59A6E4", hash_generated_method = "5C1E0742971E4BE0A2E033A253B341B8")
    public void hide() {
        {
            mZoomButtonsController.setVisible(false);
        } 
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.063 -0400", hash_original_method = "518B1D44CA5DDB1FC736D41ED30011CF", hash_generated_method = "998D02D8D89349B5C64086FBEF26FEC7")
    public boolean isVisible() {
        boolean var80F67F4A6DBC9CA7F3BDBA7D6D84682D_2039530049 = (mZoomButtonsController != null && mZoomButtonsController.isVisible());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_522940036 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_522940036;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.064 -0400", hash_original_method = "3EEB1B7639B141DBF4A839E2ACE958E1", hash_generated_method = "7213F988EF5CFAC6908ED873A58E0EEB")
    public void update() {
        boolean canZoomIn = mZoomManager.canZoomIn();
        boolean canZoomOut = mZoomManager.canZoomOut() && !mZoomManager.isInZoomOverview();
        {
            mZoomButtonsController.getZoomControls().setVisibility(View.GONE);
        } 
        {
            mZoomButtonsController.setZoomInEnabled(canZoomIn);
            mZoomButtonsController.setZoomOutEnabled(canZoomOut);
        } 
        
        
            
        
        
        
        
            
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.064 -0400", hash_original_method = "0263F8BCA60BCA372CF61DE8AB7A303B", hash_generated_method = "FF71FD7C021C55D1BA6D041B0E525BFB")
    private ZoomButtonsController getControls() {
        ZoomButtonsController varB4EAC82CA7396A68D541C85D26508E83_1577467644 = null; 
        {
            mZoomButtonsController = new ZoomButtonsController(mWebView);
            mZoomButtonsController.setOnZoomListener(new ZoomListener());
            View controls = mZoomButtonsController.getZoomControls();
            ViewGroup.LayoutParams params = controls.getLayoutParams();
            {
                ((FrameLayout.LayoutParams) params).gravity = Gravity.RIGHT;
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1577467644 = mZoomButtonsController;
        varB4EAC82CA7396A68D541C85D26508E83_1577467644.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1577467644;
        
        
            
            
            
            
            
                
            
        
        
    }

    
    private class ZoomListener implements ZoomButtonsController.OnZoomListener {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.064 -0400", hash_original_method = "97A31822F6766CF42618FF6D567EE294", hash_generated_method = "97A31822F6766CF42618FF6D567EE294")
        public ZoomListener ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.065 -0400", hash_original_method = "CAB57885F430D7392888CFD12B17B225", hash_generated_method = "8FF895FBB8D9E9C4EA66CF68F1381998")
        public void onVisibilityChanged(boolean visible) {
            
            {
                mWebView.switchOutDrawHistory();
                mZoomButtonsController.getZoomControls().setVisibility(View.VISIBLE);
                update();
            } 
            addTaint(visible);
            
            
                
                
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.065 -0400", hash_original_method = "A16881C1E119771D4FCCD4DE4DCAF173", hash_generated_method = "79B0793B5DE6B1A19DC4F8D568F665BB")
        public void onZoom(boolean zoomIn) {
            
            {
                mWebView.zoomIn();
            } 
            {
                mWebView.zoomOut();
            } 
            update();
            addTaint(zoomIn);
            
            
                
            
                
            
            
        }

        
    }


    
}

