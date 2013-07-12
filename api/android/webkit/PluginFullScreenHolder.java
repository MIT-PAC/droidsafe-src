package android.webkit;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.content.Context;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

class PluginFullScreenHolder {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.903 -0400", hash_original_field = "72439B8F99EB438C3DA5D9CD798C6786", hash_generated_field = "99346B50377E115231263981E00655CA")

    private WebView mWebView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.904 -0400", hash_original_field = "9AAC54AC2E039B851A0FF2BC75F06049", hash_generated_field = "45011ACC14043CAE74E463FA1B23DC39")

    private int mNpp;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.904 -0400", hash_original_field = "7EA67827B94D10D1A4B368659EA63B71", hash_generated_field = "0B174D00997B828633D7025DB5B13B50")

    private int mOrientation;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.904 -0400", hash_original_field = "9E8FE4D07A56D54AEE159583A4429FE8", hash_generated_field = "9EE0242EB014EEED0CD7F44EEE7EA48F")

    private View mContentView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.362 -0400", hash_original_field = "C38F623FA144FAC5E071C48A78CE544C", hash_generated_field = "284DEB13BE43A32C1123FC3056C8BC7C")

    private final WebChromeClient.CustomViewCallback mCallback = new WebChromeClient.CustomViewCallback() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.362 -0400", hash_original_method = "7559615123D16B3285B6BD8B271A29E1", hash_generated_method = "BD33C753C20DB6DE78D6B94FE6CCA305")
        public void onCustomViewHidden() {
            
            mWebView.mPrivateHandler.obtainMessage(WebView.HIDE_FULLSCREEN)
                    .sendToTarget();
            mWebView.getWebViewCore().sendMessage(
                        WebViewCore.EventHub.HIDE_FULLSCREEN, mNpp, 0);
            mLayout.removeView(mContentView);
            mLayout = null;
            mWebView.getViewManager().showAll();
            
            
                    
            
                        
            
            
            
        }

        
};
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.905 -0400", hash_original_method = "FC2D0FD113493C99F64E21CD8982E2A5", hash_generated_method = "54CB840EF19E1E2B12D841C46E8D92C3")
      PluginFullScreenHolder(WebView webView, int orientation, int npp) {
        mWebView = webView;
        mNpp = npp;
        mOrientation = orientation;
        
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.905 -0400", hash_original_method = "66123030FC4915555385B1DD2D68510F", hash_generated_method = "6502952572BE9906FB5F54E12D5F4DDD")
    public void setContentView(View contentView) {
        mLayout = new CustomFrameLayout(mWebView.getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(
                            ViewGroup.LayoutParams.MATCH_PARENT,
                            ViewGroup.LayoutParams.MATCH_PARENT,
                            Gravity.CENTER);
        mLayout.addView(contentView, layoutParams);
        mLayout.setVisibility(View.VISIBLE);
    if(contentView instanceof SurfaceView)        
        {
            final SurfaceView sView = (SurfaceView) contentView;
    if(sView.isFixedSize())            
            {
                sView.getHolder().setSizeFromLayout();
            } 
        } 
        mContentView = contentView;
        
        
        
                            
                            
                            
        
        
        
            
            
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.905 -0400", hash_original_method = "DD5335755EAD0F04B1B63E259CD22224", hash_generated_method = "F1CC204936B18406E5F95BDAFF3A0E26")
    public void show() {
    if(mWebView.getViewManager() != null)        
        mWebView.getViewManager().hideAll();
        WebChromeClient client = mWebView.getWebChromeClient();
        client.onShowCustomView(mLayout, mOrientation, mCallback);
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.906 -0400", hash_original_method = "AB5ED812B0D51EA9DC95D08A130CF1D1", hash_generated_method = "A618316A6F188F354FA11FDA59D5DF4D")
    public void hide() {
        WebChromeClient client = mWebView.getWebChromeClient();
        client.onHideCustomView();
        
        
        
    }

    
    private class CustomFrameLayout extends FrameLayout {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.906 -0400", hash_original_method = "EF4F8A70A495418F49B16A40E6FF9828", hash_generated_method = "C55ECF0D4C453AD2A56D45788035F08E")
          CustomFrameLayout(Context context) {
            super(context);
            addTaint(context.getTaint());
            
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.907 -0400", hash_original_method = "2FA80045A66041D881611423B2D72BE2", hash_generated_method = "3D3D8EC0388C161EE68F77BB61AF804A")
        @Override
        public boolean onKeyDown(int keyCode, KeyEvent event) {
            
            addTaint(event.getTaint());
            addTaint(keyCode);
    if(event.isSystem())            
            {
                boolean var947F0C250323B9F4475E02588E9A9740_2016187443 = (super.onKeyDown(keyCode, event));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2120865155 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_2120865155;
            } 
            mWebView.onKeyDown(keyCode, event);
            boolean varB326B5062B2F0E69046810717534CB09_84199027 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_401361744 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_401361744;
            
            
                
            
            
            
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.907 -0400", hash_original_method = "5F021E74A22E2DE8FA3FAB6B663A24D2", hash_generated_method = "3DA0B1EE52E88C98E6A1227B00A6492D")
        @Override
        public boolean onKeyUp(int keyCode, KeyEvent event) {
            
            addTaint(event.getTaint());
            addTaint(keyCode);
    if(event.isSystem())            
            {
                boolean varAD33E8F21A74B923C1A24761EAF2F4A9_1653149713 = (super.onKeyUp(keyCode, event));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1817070265 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1817070265;
            } 
            mWebView.onKeyUp(keyCode, event);
            boolean varB326B5062B2F0E69046810717534CB09_1716474485 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1964143931 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1964143931;
            
            
                
            
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.907 -0400", hash_original_method = "D87B32C51AD302A4F9341AA86337AE33", hash_generated_method = "B92E182E534CB7249C5C10C8B103710E")
        @Override
        public boolean onTouchEvent(MotionEvent event) {
            
            addTaint(event.getTaint());
            boolean varB326B5062B2F0E69046810717534CB09_1781826558 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_788964956 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_788964956;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.908 -0400", hash_original_method = "B00867DA6E98462A97CBDDC40208DF51", hash_generated_method = "1B26B9907B0A86F26BB878105C2C26BC")
        @Override
        public boolean onTrackballEvent(MotionEvent event) {
            
            addTaint(event.getTaint());
            mWebView.onTrackballEvent(event);
            boolean varB326B5062B2F0E69046810717534CB09_1757796120 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_729289547 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_729289547;
            
            
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.908 -0400", hash_original_field = "AF58F50E47532278404C3D8470630FC4", hash_generated_field = "EC81EA8D286B414AA1CD47542082E4E5")

    private static CustomFrameLayout mLayout;
}

