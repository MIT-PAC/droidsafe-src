package android.webkit;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:01.065 -0400", hash_original_field = "72439B8F99EB438C3DA5D9CD798C6786", hash_generated_field = "99346B50377E115231263981E00655CA")

    private WebView mWebView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:01.065 -0400", hash_original_field = "9AAC54AC2E039B851A0FF2BC75F06049", hash_generated_field = "45011ACC14043CAE74E463FA1B23DC39")

    private int mNpp;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:01.065 -0400", hash_original_field = "7EA67827B94D10D1A4B368659EA63B71", hash_generated_field = "0B174D00997B828633D7025DB5B13B50")

    private int mOrientation;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:01.065 -0400", hash_original_field = "9E8FE4D07A56D54AEE159583A4429FE8", hash_generated_field = "9EE0242EB014EEED0CD7F44EEE7EA48F")

    private View mContentView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:01.067 -0400", hash_original_field = "C38F623FA144FAC5E071C48A78CE544C", hash_generated_field = "AC5DAD735C51DBAA34F04DBDC51D4930")

    private WebChromeClient.CustomViewCallback mCallback = new WebChromeClient.CustomViewCallback() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:01.066 -0400", hash_original_method = "7559615123D16B3285B6BD8B271A29E1", hash_generated_method = "BD33C753C20DB6DE78D6B94FE6CCA305")
        public void onCustomViewHidden() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            mWebView.mPrivateHandler.obtainMessage(WebView.HIDE_FULLSCREEN)
                    .sendToTarget();
            mWebView.getWebViewCore().sendMessage(
                        WebViewCore.EventHub.HIDE_FULLSCREEN, mNpp, 0);
            mLayout.removeView(mContentView);
            mLayout = null;
            mWebView.getViewManager().showAll();
            // ---------- Original Method ----------
            //mWebView.mPrivateHandler.obtainMessage(WebView.HIDE_FULLSCREEN)
                    //.sendToTarget();
            //mWebView.getWebViewCore().sendMessage(
                        //WebViewCore.EventHub.HIDE_FULLSCREEN, mNpp, 0);
            //mLayout.removeView(mContentView);
            //mLayout = null;
            //mWebView.getViewManager().showAll();
        }

        
};
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:01.067 -0400", hash_original_method = "FC2D0FD113493C99F64E21CD8982E2A5", hash_generated_method = "54CB840EF19E1E2B12D841C46E8D92C3")
      PluginFullScreenHolder(WebView webView, int orientation, int npp) {
        mWebView = webView;
        mNpp = npp;
        mOrientation = orientation;
        // ---------- Original Method ----------
        //mWebView = webView;
        //mNpp = npp;
        //mOrientation = orientation;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:01.080 -0400", hash_original_method = "66123030FC4915555385B1DD2D68510F", hash_generated_method = "241C08E57FDF66D3D838E6984F2FD04D")
    public void setContentView(View contentView) {
        mLayout = new CustomFrameLayout(mWebView.getContext());
        FrameLayout.LayoutParams layoutParams;
        layoutParams = new FrameLayout.LayoutParams(
                            ViewGroup.LayoutParams.MATCH_PARENT,
                            ViewGroup.LayoutParams.MATCH_PARENT,
                            Gravity.CENTER);
        mLayout.addView(contentView, layoutParams);
        mLayout.setVisibility(View.VISIBLE);
        {
            SurfaceView sView;
            sView = (SurfaceView) contentView;
            {
                boolean varE2C4F2EB269067CF4E0B76F41CEE7559_1910959373 = (sView.isFixedSize());
                {
                    sView.getHolder().setSizeFromLayout();
                } //End block
            } //End collapsed parenthetic
        } //End block
        mContentView = contentView;
        // ---------- Original Method ----------
        //mLayout = new CustomFrameLayout(mWebView.getContext());
        //FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(
                            //ViewGroup.LayoutParams.MATCH_PARENT,
                            //ViewGroup.LayoutParams.MATCH_PARENT,
                            //Gravity.CENTER);
        //mLayout.addView(contentView, layoutParams);
        //mLayout.setVisibility(View.VISIBLE);
        //if (contentView instanceof SurfaceView) {
            //final SurfaceView sView = (SurfaceView) contentView;
            //if (sView.isFixedSize()) {
                //sView.getHolder().setSizeFromLayout();
            //}
        //}
        //mContentView = contentView;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:01.081 -0400", hash_original_method = "DD5335755EAD0F04B1B63E259CD22224", hash_generated_method = "1E7323F9D1A7823F375F300B66FFB2B8")
    public void show() {
        {
            boolean var8F9A4F4E45A150AF60443AFA0485F441_1166050149 = (mWebView.getViewManager() != null);
            mWebView.getViewManager().hideAll();
        } //End collapsed parenthetic
        WebChromeClient client;
        client = mWebView.getWebChromeClient();
        client.onShowCustomView(mLayout, mOrientation, mCallback);
        // ---------- Original Method ----------
        //if (mWebView.getViewManager() != null)
            //mWebView.getViewManager().hideAll();
        //WebChromeClient client = mWebView.getWebChromeClient();
        //client.onShowCustomView(mLayout, mOrientation, mCallback);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:01.081 -0400", hash_original_method = "AB5ED812B0D51EA9DC95D08A130CF1D1", hash_generated_method = "0B2FBB4B27C2F66749BAA27C7E3FF096")
    public void hide() {
        WebChromeClient client;
        client = mWebView.getWebChromeClient();
        client.onHideCustomView();
        // ---------- Original Method ----------
        //WebChromeClient client = mWebView.getWebChromeClient();
        //client.onHideCustomView();
    }

    
    private class CustomFrameLayout extends FrameLayout {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:01.082 -0400", hash_original_method = "EF4F8A70A495418F49B16A40E6FF9828", hash_generated_method = "C55ECF0D4C453AD2A56D45788035F08E")
          CustomFrameLayout(Context context) {
            super(context);
            addTaint(context.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:01.082 -0400", hash_original_method = "2FA80045A66041D881611423B2D72BE2", hash_generated_method = "479233AC0F891BF3A9EA4103263846B2")
        @Override
        public boolean onKeyDown(int keyCode, KeyEvent event) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            {
                boolean var3584FC0EA6BD89B05E5C4D0F5C4BD973_2008829831 = (event.isSystem());
                {
                    boolean varABBF72580FD6F37810B0532CA15BD464_1954864859 = (super.onKeyDown(keyCode, event));
                } //End block
            } //End collapsed parenthetic
            mWebView.onKeyDown(keyCode, event);
            addTaint(keyCode);
            addTaint(event.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_564093353 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_564093353;
            // ---------- Original Method ----------
            //if (event.isSystem()) {
                //return super.onKeyDown(keyCode, event);
            //}
            //mWebView.onKeyDown(keyCode, event);
            //return true;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:01.093 -0400", hash_original_method = "5F021E74A22E2DE8FA3FAB6B663A24D2", hash_generated_method = "92CBF1CB2DCD5AB623E910C0C3D95DB9")
        @Override
        public boolean onKeyUp(int keyCode, KeyEvent event) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            {
                boolean var3584FC0EA6BD89B05E5C4D0F5C4BD973_302743819 = (event.isSystem());
                {
                    boolean varFDF73E3D78BD161F73E44D257986774F_1589188677 = (super.onKeyUp(keyCode, event));
                } //End block
            } //End collapsed parenthetic
            mWebView.onKeyUp(keyCode, event);
            addTaint(keyCode);
            addTaint(event.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2077948461 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2077948461;
            // ---------- Original Method ----------
            //if (event.isSystem()) {
                //return super.onKeyUp(keyCode, event);
            //}
            //mWebView.onKeyUp(keyCode, event);
            //return true;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:01.094 -0400", hash_original_method = "D87B32C51AD302A4F9341AA86337AE33", hash_generated_method = "A4C69ED3D901A1941D151967BAE09E68")
        @Override
        public boolean onTouchEvent(MotionEvent event) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(event.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_233797765 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_233797765;
            // ---------- Original Method ----------
            //return true;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:01.094 -0400", hash_original_method = "B00867DA6E98462A97CBDDC40208DF51", hash_generated_method = "79A9B957BAC32C206A1B085369C7EB6A")
        @Override
        public boolean onTrackballEvent(MotionEvent event) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            mWebView.onTrackballEvent(event);
            addTaint(event.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1960560327 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1960560327;
            // ---------- Original Method ----------
            //mWebView.onTrackballEvent(event);
            //return true;
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:01.094 -0400", hash_original_field = "AF58F50E47532278404C3D8470630FC4", hash_generated_field = "EC81EA8D286B414AA1CD47542082E4E5")

    private static CustomFrameLayout mLayout;
}

