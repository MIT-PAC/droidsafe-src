package android.webkit;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.content.Context;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

class PluginFullScreenHolder {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.361 -0400", hash_original_field = "72439B8F99EB438C3DA5D9CD798C6786", hash_generated_field = "99346B50377E115231263981E00655CA")

    private WebView mWebView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.361 -0400", hash_original_field = "9AAC54AC2E039B851A0FF2BC75F06049", hash_generated_field = "45011ACC14043CAE74E463FA1B23DC39")

    private int mNpp;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.361 -0400", hash_original_field = "7EA67827B94D10D1A4B368659EA63B71", hash_generated_field = "0B174D00997B828633D7025DB5B13B50")

    private int mOrientation;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.361 -0400", hash_original_field = "9E8FE4D07A56D54AEE159583A4429FE8", hash_generated_field = "9EE0242EB014EEED0CD7F44EEE7EA48F")

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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.362 -0400", hash_original_method = "FC2D0FD113493C99F64E21CD8982E2A5", hash_generated_method = "54CB840EF19E1E2B12D841C46E8D92C3")
      PluginFullScreenHolder(WebView webView, int orientation, int npp) {
        mWebView = webView;
        mNpp = npp;
        mOrientation = orientation;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.363 -0400", hash_original_method = "66123030FC4915555385B1DD2D68510F", hash_generated_method = "2550F2BD1E1CC497ECEE312B36A3CB78")
    public void setContentView(View contentView) {
        mLayout = new CustomFrameLayout(mWebView.getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(
                            ViewGroup.LayoutParams.MATCH_PARENT,
                            ViewGroup.LayoutParams.MATCH_PARENT,
                            Gravity.CENTER);
        mLayout.addView(contentView, layoutParams);
        mLayout.setVisibility(View.VISIBLE);
        {
            final SurfaceView sView = (SurfaceView) contentView;
            {
                boolean varE2C4F2EB269067CF4E0B76F41CEE7559_1725093553 = (sView.isFixedSize());
                {
                    sView.getHolder().setSizeFromLayout();
                } 
            } 
        } 
        mContentView = contentView;
        
        
        
                            
                            
                            
        
        
        
            
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.363 -0400", hash_original_method = "DD5335755EAD0F04B1B63E259CD22224", hash_generated_method = "BEC743EBE7EA0AB0FBAFB18C564B296A")
    public void show() {
        {
            boolean var8F9A4F4E45A150AF60443AFA0485F441_739267057 = (mWebView.getViewManager() != null);
            mWebView.getViewManager().hideAll();
        } 
        WebChromeClient client = mWebView.getWebChromeClient();
        client.onShowCustomView(mLayout, mOrientation, mCallback);
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.363 -0400", hash_original_method = "AB5ED812B0D51EA9DC95D08A130CF1D1", hash_generated_method = "A618316A6F188F354FA11FDA59D5DF4D")
    public void hide() {
        WebChromeClient client = mWebView.getWebChromeClient();
        client.onHideCustomView();
        
        
        
    }

    
    private class CustomFrameLayout extends FrameLayout {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.364 -0400", hash_original_method = "EF4F8A70A495418F49B16A40E6FF9828", hash_generated_method = "C55ECF0D4C453AD2A56D45788035F08E")
          CustomFrameLayout(Context context) {
            super(context);
            addTaint(context.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.364 -0400", hash_original_method = "2FA80045A66041D881611423B2D72BE2", hash_generated_method = "A70DB35D5B54B451BEF0FE135FAAF726")
        @Override
        public boolean onKeyDown(int keyCode, KeyEvent event) {
            
            {
                boolean var3584FC0EA6BD89B05E5C4D0F5C4BD973_573600854 = (event.isSystem());
                {
                    boolean varABBF72580FD6F37810B0532CA15BD464_1075938581 = (super.onKeyDown(keyCode, event));
                } 
            } 
            mWebView.onKeyDown(keyCode, event);
            addTaint(keyCode);
            addTaint(event.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_965174583 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_965174583;
            
            
                
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.365 -0400", hash_original_method = "5F021E74A22E2DE8FA3FAB6B663A24D2", hash_generated_method = "8AFE3547B82160624095F72043893520")
        @Override
        public boolean onKeyUp(int keyCode, KeyEvent event) {
            
            {
                boolean var3584FC0EA6BD89B05E5C4D0F5C4BD973_2089908116 = (event.isSystem());
                {
                    boolean varFDF73E3D78BD161F73E44D257986774F_2026763741 = (super.onKeyUp(keyCode, event));
                } 
            } 
            mWebView.onKeyUp(keyCode, event);
            addTaint(keyCode);
            addTaint(event.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_6545909 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_6545909;
            
            
                
            
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.365 -0400", hash_original_method = "D87B32C51AD302A4F9341AA86337AE33", hash_generated_method = "9D8D7437BC0FCB38C4F6F3A613D11AE6")
        @Override
        public boolean onTouchEvent(MotionEvent event) {
            
            addTaint(event.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_54364446 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_54364446;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.365 -0400", hash_original_method = "B00867DA6E98462A97CBDDC40208DF51", hash_generated_method = "CE96A19E86806C8974874D5BD9830D82")
        @Override
        public boolean onTrackballEvent(MotionEvent event) {
            
            mWebView.onTrackballEvent(event);
            addTaint(event.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_526542471 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_526542471;
            
            
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.365 -0400", hash_original_field = "AF58F50E47532278404C3D8470630FC4", hash_generated_field = "EC81EA8D286B414AA1CD47542082E4E5")

    private static CustomFrameLayout mLayout;
}

