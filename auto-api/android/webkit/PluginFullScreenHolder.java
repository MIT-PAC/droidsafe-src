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
    private WebView mWebView;
    private int mNpp;
    private int mOrientation;
    private View mContentView;
    private final WebChromeClient.CustomViewCallback mCallback = new WebChromeClient.CustomViewCallback() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.627 -0400", hash_original_method = "7559615123D16B3285B6BD8B271A29E1", hash_generated_method = "BD33C753C20DB6DE78D6B94FE6CCA305")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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

        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.627 -0400", hash_original_method = "FC2D0FD113493C99F64E21CD8982E2A5", hash_generated_method = "733ED549B4DD0A506EDEBB6942036110")
    @DSModeled(DSC.SAFE)
     PluginFullScreenHolder(WebView webView, int orientation, int npp) {
        dsTaint.addTaint(orientation);
        dsTaint.addTaint(webView.dsTaint);
        dsTaint.addTaint(npp);
        // ---------- Original Method ----------
        //mWebView = webView;
        //mNpp = npp;
        //mOrientation = orientation;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.628 -0400", hash_original_method = "66123030FC4915555385B1DD2D68510F", hash_generated_method = "151F5CB0B2F47D4C8700EE2758FA1E87")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setContentView(View contentView) {
        dsTaint.addTaint(contentView.dsTaint);
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
                boolean varE2C4F2EB269067CF4E0B76F41CEE7559_810189700 = (sView.isFixedSize());
                {
                    sView.getHolder().setSizeFromLayout();
                } //End block
            } //End collapsed parenthetic
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.628 -0400", hash_original_method = "DD5335755EAD0F04B1B63E259CD22224", hash_generated_method = "DEAA8772D6ECA564038FD601A0CBCAC2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void show() {
        {
            boolean var8F9A4F4E45A150AF60443AFA0485F441_1534193069 = (mWebView.getViewManager() != null);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.628 -0400", hash_original_method = "AB5ED812B0D51EA9DC95D08A130CF1D1", hash_generated_method = "0B2FBB4B27C2F66749BAA27C7E3FF096")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void hide() {
        WebChromeClient client;
        client = mWebView.getWebChromeClient();
        client.onHideCustomView();
        // ---------- Original Method ----------
        //WebChromeClient client = mWebView.getWebChromeClient();
        //client.onHideCustomView();
    }

    
    private class CustomFrameLayout extends FrameLayout {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.628 -0400", hash_original_method = "EF4F8A70A495418F49B16A40E6FF9828", hash_generated_method = "FB949ED9C32B76AC5495C5D537903231")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         CustomFrameLayout(Context context) {
            super(context);
            dsTaint.addTaint(context.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.629 -0400", hash_original_method = "2FA80045A66041D881611423B2D72BE2", hash_generated_method = "05E52ACED4B368406ACBE8613AD8276F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean onKeyDown(int keyCode, KeyEvent event) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(keyCode);
            dsTaint.addTaint(event.dsTaint);
            {
                boolean var3584FC0EA6BD89B05E5C4D0F5C4BD973_1378381907 = (event.isSystem());
                {
                    boolean varABBF72580FD6F37810B0532CA15BD464_1369377395 = (super.onKeyDown(keyCode, event));
                } //End block
            } //End collapsed parenthetic
            mWebView.onKeyDown(keyCode, event);
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //if (event.isSystem()) {
                //return super.onKeyDown(keyCode, event);
            //}
            //mWebView.onKeyDown(keyCode, event);
            //return true;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.629 -0400", hash_original_method = "5F021E74A22E2DE8FA3FAB6B663A24D2", hash_generated_method = "F784C426C71FD1C5D00AA0E7974AD3A2")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean onKeyUp(int keyCode, KeyEvent event) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(keyCode);
            dsTaint.addTaint(event.dsTaint);
            {
                boolean var3584FC0EA6BD89B05E5C4D0F5C4BD973_1916973076 = (event.isSystem());
                {
                    boolean varFDF73E3D78BD161F73E44D257986774F_1374720656 = (super.onKeyUp(keyCode, event));
                } //End block
            } //End collapsed parenthetic
            mWebView.onKeyUp(keyCode, event);
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //if (event.isSystem()) {
                //return super.onKeyUp(keyCode, event);
            //}
            //mWebView.onKeyUp(keyCode, event);
            //return true;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.629 -0400", hash_original_method = "D87B32C51AD302A4F9341AA86337AE33", hash_generated_method = "CAC19770074E9335F5A0948E5AD2CEE9")
        @DSModeled(DSC.SAFE)
        @Override
        public boolean onTouchEvent(MotionEvent event) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(event.dsTaint);
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return true;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.630 -0400", hash_original_method = "B00867DA6E98462A97CBDDC40208DF51", hash_generated_method = "906CF9841E5F8934E3D580BD4DE33089")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean onTrackballEvent(MotionEvent event) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(event.dsTaint);
            mWebView.onTrackballEvent(event);
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //mWebView.onTrackballEvent(event);
            //return true;
        }

        
    }


    
    private static CustomFrameLayout mLayout;
}

