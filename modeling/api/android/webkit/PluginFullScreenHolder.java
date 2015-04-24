/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 * 
 * 
 * This file incorporates work covered by the following copyright and
 * permission notice:
 *
 * Copyright 2009, The Android Open Source Project
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *  * Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *  * Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS ``AS IS'' AND ANY
 * EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY
 * OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package android.webkit;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.content.Context;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

class PluginFullScreenHolder {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:39.277 -0500", hash_original_field = "F97327940BAC1A9A686D2CDF9F9158DF", hash_generated_field = "EC81EA8D286B414AA1CD47542082E4E5")

    private static CustomFrameLayout mLayout;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:39.270 -0500", hash_original_field = "E044D69EE05B24F4B93E3A3B208F5343", hash_generated_field = "99346B50377E115231263981E00655CA")

    private  WebView mWebView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:39.272 -0500", hash_original_field = "F53BD2B3EC5E3962A4CCBC614C0496FA", hash_generated_field = "45011ACC14043CAE74E463FA1B23DC39")

    private  int mNpp;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:39.275 -0500", hash_original_field = "9D3FC5FADE012FDDFCCC496073866451", hash_generated_field = "0B174D00997B828633D7025DB5B13B50")

    private  int mOrientation;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:39.279 -0500", hash_original_field = "A280952DD6B837BA6E44884878875510", hash_generated_field = "9EE0242EB014EEED0CD7F44EEE7EA48F")

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

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:39.282 -0500", hash_original_method = "FC2D0FD113493C99F64E21CD8982E2A5", hash_generated_method = "FC2D0FD113493C99F64E21CD8982E2A5")
    
PluginFullScreenHolder(WebView webView, int orientation, int npp) {
        mWebView = webView;
        mNpp = npp;
        mOrientation = orientation;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:39.284 -0500", hash_original_method = "66123030FC4915555385B1DD2D68510F", hash_generated_method = "5E41D22F111E094706F5433426F8DD9E")
    
public void setContentView(View contentView) {

        // Create a FrameLayout that will contain the plugin's view
        mLayout = new CustomFrameLayout(mWebView.getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(
                            ViewGroup.LayoutParams.MATCH_PARENT,
                            ViewGroup.LayoutParams.MATCH_PARENT,
                            Gravity.CENTER);

        mLayout.addView(contentView, layoutParams);
        mLayout.setVisibility(View.VISIBLE);

        // fixed size is only used either during pinch zoom or surface is too
        // big. Make sure it is not fixed size before setting it to the full
        // screen content view. The SurfaceView will be set to the correct mode
        // by the ViewManager when it is re-attached to the WebView.
        if (contentView instanceof SurfaceView) {
            final SurfaceView sView = (SurfaceView) contentView;
            if (sView.isFixedSize()) {
                sView.getHolder().setSizeFromLayout();
            }
        }

        mContentView = contentView;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:39.287 -0500", hash_original_method = "DD5335755EAD0F04B1B63E259CD22224", hash_generated_method = "3D06E0557B09291320366CECD32E35A3")
    
public void show() {
        // Other plugins may attempt to draw so hide them while we're active.
        if (mWebView.getViewManager() != null)
            mWebView.getViewManager().hideAll();

        WebChromeClient client = mWebView.getWebChromeClient();
        client.onShowCustomView(mLayout, mOrientation, mCallback);
    }
    
    private class CustomFrameLayout extends FrameLayout {

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:39.292 -0500", hash_original_method = "EF4F8A70A495418F49B16A40E6FF9828", hash_generated_method = "EF4F8A70A495418F49B16A40E6FF9828")
        
CustomFrameLayout(Context context) {
            super(context);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:39.294 -0500", hash_original_method = "2FA80045A66041D881611423B2D72BE2", hash_generated_method = "DFF72945AD48259D9CD1212E29C36C3A")
        
@Override
        public boolean onKeyDown(int keyCode, KeyEvent event) {
            if (event.isSystem()) {
                return super.onKeyDown(keyCode, event);
            }
            mWebView.onKeyDown(keyCode, event);
            // always return true as we are the handler
            return true;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:39.296 -0500", hash_original_method = "5F021E74A22E2DE8FA3FAB6B663A24D2", hash_generated_method = "B6428797A4DFB0C132F965E73176FDFB")
        
@Override
        public boolean onKeyUp(int keyCode, KeyEvent event) {
            if (event.isSystem()) {
                return super.onKeyUp(keyCode, event);
            }
            mWebView.onKeyUp(keyCode, event);
            // always return true as we are the handler
            return true;
        }

        @DSSafe(DSCat.ANDROID_CALLBACK)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:39.299 -0500", hash_original_method = "D87B32C51AD302A4F9341AA86337AE33", hash_generated_method = "E1BFFD5904A19191D2571DCFB08E531F")
        
@Override
        public boolean onTouchEvent(MotionEvent event) {
            // always return true as we don't want the event to propagate any further
            return true;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:39.301 -0500", hash_original_method = "B00867DA6E98462A97CBDDC40208DF51", hash_generated_method = "158F7A5B4C8838CB1AA0C7F2B1BCDB5E")
        
@Override
        public boolean onTrackballEvent(MotionEvent event) {
            mWebView.onTrackballEvent(event);
            // always return true as we are the handler
            return true;
        }
        
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:39.289 -0500", hash_original_method = "AB5ED812B0D51EA9DC95D08A130CF1D1", hash_generated_method = "09E89F4327228FA78D1062055E39567A")
    
public void hide() {
        WebChromeClient client = mWebView.getWebChromeClient();
        client.onHideCustomView();
    }
}

