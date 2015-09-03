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
 * Copyright (C) 2009 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package android.webkit;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.ArrayList;

import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsoluteLayout;

class ViewManager {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:11.355 -0500", hash_original_field = "BAFAAB07E3E16D198144C59EEA29BFF5", hash_generated_field = "52CD7F2804541D9D147DA6137D506751")

    private static final int MAX_SURFACE_DIMENSION = 2048;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:11.342 -0500", hash_original_field = "E044D69EE05B24F4B93E3A3B208F5343", hash_generated_field = "99346B50377E115231263981E00655CA")

    private  WebView mWebView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:11.344 -0500", hash_original_field = "512DDD6260448235A87A2D7DBCE78B3A", hash_generated_field = "A23DCC2022137B3032C531881F046064")

    private final ArrayList<ChildView> mChildren = new ArrayList<ChildView>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:11.347 -0500", hash_original_field = "DB81C7417E8D5BB2C252FB40F8D91CF8", hash_generated_field = "3F147822327D2F3E101E54AA2BDEB694")

    private boolean mHidden;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:11.349 -0500", hash_original_field = "DF2B831C5787CC09C8522AA5C6CB6818", hash_generated_field = "D4ED2FE7B592D39DCE852F60F1DDCF62")

    private boolean mReadyToDraw;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:11.351 -0500", hash_original_field = "B147F7AC28D8FB59201A86F235EF2A4D", hash_generated_field = "E2D29020496E97D1FD814233F5B97E36")

    private boolean mZoomInProgress = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:11.353 -0500", hash_original_field = "06315E20245EB78FD301784396B7BBB2", hash_generated_field = "8321EFE222E741830F977A0EDC376DEE")

    private  int MAX_SURFACE_AREA;

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:11.390 -0500", hash_original_method = "41D6739987EDABAA49AC971619E5EA69", hash_generated_method = "129E9A10B1F96A52757E0F16C329E5B4")
    
ViewManager(WebView w) {
        mWebView = w;

        int pixelArea = w.getResources().getDisplayMetrics().widthPixels *
                        w.getResources().getDisplayMetrics().heightPixels;
        /* set the threshold to be 275% larger than the screen size. The
           percentage is simply an estimation and is not based on anything but
           basic trial-and-error tests run on multiple devices.
         */
        MAX_SURFACE_AREA = (int)(pixelArea * 2.75);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:11.392 -0500", hash_original_method = "FA4B0F6C2AA9564529C02D0C8EC5ABBE", hash_generated_method = "FA4B0F6C2AA9564529C02D0C8EC5ABBE")
    
ChildView createView() {
        return new ChildView();
    }

    /**
     * This should only be called from the UI thread.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:11.400 -0500", hash_original_method = "2B29D777BD882375E9FE491E62B8E4F4", hash_generated_method = "5288B64B6675C9E90C864CABB0D62146")
    
private void requestLayout(ChildView v) {

        int width = mWebView.contentToViewDimension(v.width);
        int height = mWebView.contentToViewDimension(v.height);
        int x = mWebView.contentToViewX(v.x);
        int y = mWebView.contentToViewY(v.y);

        AbsoluteLayout.LayoutParams lp;
        ViewGroup.LayoutParams layoutParams = v.mView.getLayoutParams();

        if (layoutParams instanceof AbsoluteLayout.LayoutParams) {
            lp = (AbsoluteLayout.LayoutParams) layoutParams;
            lp.width = width;
            lp.height = height;
            lp.x = x;
            lp.y = y;
        } else {
            lp = new AbsoluteLayout.LayoutParams(width, height, x, y);
        }

        // apply the layout to the view
        v.mView.setLayoutParams(lp);

        if(v.mView instanceof SurfaceView) {

            final SurfaceView sView = (SurfaceView) v.mView;

            if (sView.isFixedSize() && mZoomInProgress) {
                /* If we're already fixed, and we're in a zoom, then do nothing
                   about the size. Just wait until we get called at the end of
                   the zoom session (with mZoomInProgress false) and we'll
                   fixup our size then.
                 */
                return;
            }

            /* Compute proportional fixed width/height if necessary.
             *
             * NOTE: plugins (e.g. Flash) must not explicitly fix the size of
             * their surface. The logic below will result in unexpected behavior
             * for the plugin if they attempt to fix the size of the surface.
             */
            int fixedW = width;
            int fixedH = height;
            if (fixedW > MAX_SURFACE_DIMENSION || fixedH > MAX_SURFACE_DIMENSION) {
                if (v.width > v.height) {
                    fixedW = MAX_SURFACE_DIMENSION;
                    fixedH = v.height * MAX_SURFACE_DIMENSION / v.width;
                } else {
                    fixedH = MAX_SURFACE_DIMENSION;
                    fixedW = v.width * MAX_SURFACE_DIMENSION / v.height;
                }
            }
            if (fixedW * fixedH > MAX_SURFACE_AREA) {
                float area = MAX_SURFACE_AREA;
                if (v.width > v.height) {
                    fixedW = (int)Math.sqrt(area * v.width / v.height);
                    fixedH = v.height * fixedW / v.width;
                } else {
                    fixedH = (int)Math.sqrt(area * v.height / v.width);
                    fixedW = v.width * fixedH / v.height;
                }
            }

            if (fixedW != width || fixedH != height) {
                // if we get here, either our dimensions or area (or both)
                // exeeded our max, so we had to compute fixedW and fixedH
                sView.getHolder().setFixedSize(fixedW, fixedH);
            } else if (!sView.isFixedSize() && mZoomInProgress) {
                // just freeze where we were (view size) until we're done with
                // the zoom progress
                sView.getHolder().setFixedSize(sView.getWidth(),
                                               sView.getHeight());
            } else if (sView.isFixedSize() && !mZoomInProgress) {
                /* The changing of visibility is a hack to get around a bug in
                 * the framework that causes the surface to revert to the size
                 * it was prior to being fixed before it redraws using the
                 * values currently in its layout.
                 *
                 * The surface is destroyed when it is set to invisible and then
                 * recreated at the new dimensions when it is made visible. The
                 * same destroy/create step occurs without the change in
                 * visibility, but then exhibits the behavior described in the
                 * previous paragraph.
                 */
                if (sView.getVisibility() == View.VISIBLE) {
                    sView.setVisibility(View.INVISIBLE);
                    sView.getHolder().setSizeFromLayout();
                    // setLayoutParams() only requests the layout. If we set it
                    // to VISIBLE now, it will use the old dimension to set the
                    // size. Post a message to ensure that it shows the new size.
                    mWebView.mPrivateHandler.post(new Runnable() {
                        @DSSafe(DSCat.SAFE_LIST)
        public void run() {
                            sView.setVisibility(View.VISIBLE);
                        }
                    });
                } else {
                    sView.getHolder().setSizeFromLayout();
                }
            }
        }
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:11.402 -0500", hash_original_method = "4F661FC74F7E1A720FEE3022046A7DAD", hash_generated_method = "4F661FC74F7E1A720FEE3022046A7DAD")
    
void startZoom() {
        mZoomInProgress = true;
        for (ChildView v : mChildren) {
            requestLayout(v);
        }
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:11.404 -0500", hash_original_method = "F0F47054709F050065D565E243DB8138", hash_generated_method = "F0F47054709F050065D565E243DB8138")
    
void endZoom() {
        mZoomInProgress = false;
        for (ChildView v : mChildren) {
            requestLayout(v);
        }
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:11.406 -0500", hash_original_method = "C82C75EA2573C85D59C63AD0662E50B7", hash_generated_method = "C82C75EA2573C85D59C63AD0662E50B7")
    
void scaleAll() {
        for (ChildView v : mChildren) {
            requestLayout(v);
        }
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:11.408 -0500", hash_original_method = "4F028387E717D291F0C61AFA65DDC151", hash_generated_method = "4F028387E717D291F0C61AFA65DDC151")
    
void hideAll() {
        if (mHidden) {
            return;
        }
        for (ChildView v : mChildren) {
            v.mView.setVisibility(View.GONE);
        }
        mHidden = true;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:11.410 -0500", hash_original_method = "B75BBFE8728E55E21A97BD827A74F550", hash_generated_method = "B75BBFE8728E55E21A97BD827A74F550")
    
void showAll() {
        if (!mHidden) {
            return;
        }
        for (ChildView v : mChildren) {
            v.mView.setVisibility(View.VISIBLE);
        }
        mHidden = false;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:11.414 -0500", hash_original_method = "CA54479F86F4EE856736FA836E1EE2FC", hash_generated_method = "CA54479F86F4EE856736FA836E1EE2FC")
    
void postResetStateAll() {
        mWebView.mPrivateHandler.post(new Runnable() {
            @DSSafe(DSCat.SAFE_LIST)
        public void run() {
                mReadyToDraw = false;
            }
        });
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:11.419 -0500", hash_original_method = "60132EA2B1596F91D6DE492E58F4C89D", hash_generated_method = "60132EA2B1596F91D6DE492E58F4C89D")
    
void postReadyToDrawAll() {
        mWebView.mPrivateHandler.post(new Runnable() {
            @DSSafe(DSCat.SAFE_LIST)
        public void run() {
                mReadyToDraw = true;
                for (ChildView v : mChildren) {
                    v.mView.setVisibility(View.VISIBLE);
                }
            }
        });
    }
    
    class ChildView {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:11.358 -0500", hash_original_field = "3ECDEC351FCE13CBA8A59E38409B3C9E", hash_generated_field = "3ECDEC351FCE13CBA8A59E38409B3C9E")

        int x;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:11.360 -0500", hash_original_field = "93D19118DABD6AC5BACF335A34537CEB", hash_generated_field = "93D19118DABD6AC5BACF335A34537CEB")

        int y;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:11.362 -0500", hash_original_field = "1589F848FE4FF192F7CCE1B9F9E85747", hash_generated_field = "1589F848FE4FF192F7CCE1B9F9E85747")

        int width;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:11.364 -0500", hash_original_field = "CE84F1587D182C1F0A32D7CD44443A18", hash_generated_field = "CE84F1587D182C1F0A32D7CD44443A18")

        int height;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:11.366 -0500", hash_original_field = "6F4F028D1DE9C463F753A80DD0991753", hash_generated_field = "6F4F028D1DE9C463F753A80DD0991753")

        View mView; // generic view to show

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:11.369 -0500", hash_original_method = "444F58071031B7B88B9F4BACE4B52E97", hash_generated_method = "444F58071031B7B88B9F4BACE4B52E97")
        
ChildView() {
        }

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:11.371 -0500", hash_original_method = "49948859AFA14B35AAA713D3429ED265", hash_generated_method = "49948859AFA14B35AAA713D3429ED265")
        
void setBounds(int x, int y, int width, int height) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
        }

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:11.376 -0500", hash_original_method = "C5CB26D6C1A4635E70554CC63D76B563", hash_generated_method = "3D46DAB228E58C931888FB6D80231ED0")
        
void attachView(int x, int y, int width, int height) {
            if (mView == null) {
                return;
            }
            setBounds(x, y, width, height);

            mWebView.mPrivateHandler.post(new Runnable() {
                @DSSafe(DSCat.SAFE_LIST)
            public void run() {
                    // This method may be called multiple times. If the view is
                    // already attached, just set the new LayoutParams,
                    // otherwise attach the view and add it to the list of
                    // children.
                    requestLayout(ChildView.this);

                    if (mView.getParent() == null) {
                        attachViewOnUIThread();
                    }
                }
            });
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:11.379 -0500", hash_original_method = "E19361570D109423E86E664B0AC4389A", hash_generated_method = "C90C39F16FFD9315E5FB7AA3A3CF4FC8")
        
private void attachViewOnUIThread() {
            mWebView.addView(mView);
            mChildren.add(this);
            if (!mReadyToDraw) {
                mView.setVisibility(View.GONE);
            }
        }

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:11.384 -0500", hash_original_method = "82A15EE3F2ACFE39B2389F6444C4BAEB", hash_generated_method = "82A15EE3F2ACFE39B2389F6444C4BAEB")
        
void removeView() {
            if (mView == null) {
                return;
            }
            mWebView.mPrivateHandler.post(new Runnable() {
                @DSSafe(DSCat.SAFE_LIST)
            public void run() {
                    removeViewOnUIThread();
                }
            });
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:11.386 -0500", hash_original_method = "2FC5BD33F15E4B580397FED329387FB1", hash_generated_method = "0FD1231D619BF4E62EDF563955299AA0")
        
private void removeViewOnUIThread() {
            mWebView.removeView(mView);
            mChildren.remove(this);
        }
        
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:11.422 -0500", hash_original_method = "69EC682FAEAFF2A8235362C63F30F73F", hash_generated_method = "69EC682FAEAFF2A8235362C63F30F73F")
    
ChildView hitTest(int contentX, int contentY) {
        if (mHidden) {
            return null;
        }
        for (ChildView v : mChildren) {
            if (v.mView.getVisibility() == View.VISIBLE) {
                if (contentX >= v.x && contentX < (v.x + v.width)
                        && contentY >= v.y && contentY < (v.y + v.height)) {
                    return v;
                }
            }
        }
        return null;
    }
}

