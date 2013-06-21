package android.webkit;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsoluteLayout;
import java.util.ArrayList;

class ViewManager {
    private WebView mWebView;
    private ArrayList<ChildView> mChildren = new ArrayList<ChildView>();
    private boolean mHidden;
    private boolean mReadyToDraw;
    private boolean mZoomInProgress = false;
    private int MAX_SURFACE_AREA;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.833 -0400", hash_original_method = "41D6739987EDABAA49AC971619E5EA69", hash_generated_method = "05EC5FAFCA95BCA9C7959573FDDCAE51")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     ViewManager(WebView w) {
        dsTaint.addTaint(w.dsTaint);
        int pixelArea;
        pixelArea = w.getResources().getDisplayMetrics().widthPixels *
                        w.getResources().getDisplayMetrics().heightPixels;
        MAX_SURFACE_AREA = (int)(pixelArea * 2.75);
        // ---------- Original Method ----------
        //mWebView = w;
        //int pixelArea = w.getResources().getDisplayMetrics().widthPixels *
                        //w.getResources().getDisplayMetrics().heightPixels;
        //MAX_SURFACE_AREA = (int)(pixelArea * 2.75);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.833 -0400", hash_original_method = "FA4B0F6C2AA9564529C02D0C8EC5ABBE", hash_generated_method = "27F9FA29C1E8D7FFE597B4DB26C68AFB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     ChildView createView() {
        ChildView var4B20F20A851672D1151724C72AB2C672_1143584696 = (new ChildView());
        return (ChildView)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new ChildView();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.834 -0400", hash_original_method = "2B29D777BD882375E9FE491E62B8E4F4", hash_generated_method = "7B961DFCB329F1629F6145C079404C15")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void requestLayout(ChildView v) {
        dsTaint.addTaint(v.dsTaint);
        int width;
        width = mWebView.contentToViewDimension(v.width);
        int height;
        height = mWebView.contentToViewDimension(v.height);
        int x;
        x = mWebView.contentToViewX(v.x);
        int y;
        y = mWebView.contentToViewY(v.y);
        AbsoluteLayout.LayoutParams lp;
        ViewGroup.LayoutParams layoutParams;
        layoutParams = v.mView.getLayoutParams();
        {
            lp = (AbsoluteLayout.LayoutParams) layoutParams;
            lp.width = width;
            lp.height = height;
            lp.x = x;
            lp.y = y;
        } //End block
        {
            lp = new AbsoluteLayout.LayoutParams(width, height, x, y);
        } //End block
        v.mView.setLayoutParams(lp);
        {
            SurfaceView sView;
            sView = (SurfaceView) v.mView;
            {
                boolean var3E1D1B0939337281E331FBD6D29EDABE_451615239 = (sView.isFixedSize() && mZoomInProgress);
            } //End collapsed parenthetic
            int fixedW;
            fixedW = width;
            int fixedH;
            fixedH = height;
            {
                {
                    fixedW = MAX_SURFACE_DIMENSION;
                    fixedH = v.height * MAX_SURFACE_DIMENSION / v.width;
                } //End block
                {
                    fixedH = MAX_SURFACE_DIMENSION;
                    fixedW = v.width * MAX_SURFACE_DIMENSION / v.height;
                } //End block
            } //End block
            {
                float area;
                area = MAX_SURFACE_AREA;
                {
                    fixedW = (int)Math.sqrt(area * v.width / v.height);
                    fixedH = v.height * fixedW / v.width;
                } //End block
                {
                    fixedH = (int)Math.sqrt(area * v.height / v.width);
                    fixedW = v.width * fixedH / v.height;
                } //End block
            } //End block
            {
                sView.getHolder().setFixedSize(fixedW, fixedH);
            } //End block
            {
                boolean var659EC033A3AE435F1C433F73F1F80446_979777717 = (!sView.isFixedSize() && mZoomInProgress);
                {
                    sView.getHolder().setFixedSize(sView.getWidth(),
                                               sView.getHeight());
                } //End block
                {
                    boolean var21CE6BEEBB1C7C80D8C131F48E4BA5F0_295592523 = (sView.isFixedSize() && !mZoomInProgress);
                    {
                        {
                            boolean varE29A4FF89AEBA8C8745667A111F00CB2_1146595440 = (sView.getVisibility() == View.VISIBLE);
                            {
                                sView.setVisibility(View.INVISIBLE);
                                sView.getHolder().setSizeFromLayout();
                                mWebView.mPrivateHandler.post(new Runnable() {                                    
                                    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.834 -0400", hash_original_method = "FC4D9F6633FDA07933C38D9105D81F42", hash_generated_method = "CD4E9DF20EB12C15EED4A8BEC8E97002")
                                    //DSFIXME:  CODE0002: Requires DSC value to be set
                                    public void run() {
                                        sView.setVisibility(View.VISIBLE);
                                        // ---------- Original Method ----------
                                        //sView.setVisibility(View.VISIBLE);
                                    }
});
                            } //End block
                            {
                                sView.getHolder().setSizeFromLayout();
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.846 -0400", hash_original_method = "4F661FC74F7E1A720FEE3022046A7DAD", hash_generated_method = "312BD3CAB6C35D5C95B18E28518C8100")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void startZoom() {
        mZoomInProgress = true;
        {
            Iterator<ChildView> var1EA0A404291742DF49F29AA36388DCC6_2029077664 = (mChildren).iterator();
            var1EA0A404291742DF49F29AA36388DCC6_2029077664.hasNext();
            ChildView v = var1EA0A404291742DF49F29AA36388DCC6_2029077664.next();
            {
                requestLayout(v);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //mZoomInProgress = true;
        //for (ChildView v : mChildren) {
            //requestLayout(v);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.849 -0400", hash_original_method = "F0F47054709F050065D565E243DB8138", hash_generated_method = "C430ACBCBFEA5739A057FCD055A92306")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void endZoom() {
        mZoomInProgress = false;
        {
            Iterator<ChildView> var1EA0A404291742DF49F29AA36388DCC6_1318842753 = (mChildren).iterator();
            var1EA0A404291742DF49F29AA36388DCC6_1318842753.hasNext();
            ChildView v = var1EA0A404291742DF49F29AA36388DCC6_1318842753.next();
            {
                requestLayout(v);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //mZoomInProgress = false;
        //for (ChildView v : mChildren) {
            //requestLayout(v);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.860 -0400", hash_original_method = "C82C75EA2573C85D59C63AD0662E50B7", hash_generated_method = "F3ABFC8CBE10025ED226BFB844A44F16")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void scaleAll() {
        {
            Iterator<ChildView> var1EA0A404291742DF49F29AA36388DCC6_706449294 = (mChildren).iterator();
            var1EA0A404291742DF49F29AA36388DCC6_706449294.hasNext();
            ChildView v = var1EA0A404291742DF49F29AA36388DCC6_706449294.next();
            {
                requestLayout(v);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //for (ChildView v : mChildren) {
            //requestLayout(v);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.862 -0400", hash_original_method = "4F028387E717D291F0C61AFA65DDC151", hash_generated_method = "0C2A099A6AAAA8E442135BFCEAFAEE5D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void hideAll() {
        {
            Iterator<ChildView> var1EA0A404291742DF49F29AA36388DCC6_1589021904 = (mChildren).iterator();
            var1EA0A404291742DF49F29AA36388DCC6_1589021904.hasNext();
            ChildView v = var1EA0A404291742DF49F29AA36388DCC6_1589021904.next();
            {
                v.mView.setVisibility(View.GONE);
            } //End block
        } //End collapsed parenthetic
        mHidden = true;
        // ---------- Original Method ----------
        //if (mHidden) {
            //return;
        //}
        //for (ChildView v : mChildren) {
            //v.mView.setVisibility(View.GONE);
        //}
        //mHidden = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.865 -0400", hash_original_method = "B75BBFE8728E55E21A97BD827A74F550", hash_generated_method = "F064865AE5C68D89E6D3DA087D171D09")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void showAll() {
        {
            Iterator<ChildView> var1EA0A404291742DF49F29AA36388DCC6_1027515705 = (mChildren).iterator();
            var1EA0A404291742DF49F29AA36388DCC6_1027515705.hasNext();
            ChildView v = var1EA0A404291742DF49F29AA36388DCC6_1027515705.next();
            {
                v.mView.setVisibility(View.VISIBLE);
            } //End block
        } //End collapsed parenthetic
        mHidden = false;
        // ---------- Original Method ----------
        //if (!mHidden) {
            //return;
        //}
        //for (ChildView v : mChildren) {
            //v.mView.setVisibility(View.VISIBLE);
        //}
        //mHidden = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.868 -0400", hash_original_method = "CA54479F86F4EE856736FA836E1EE2FC", hash_generated_method = "4C4CE3D3D7928A564B1E1FD5E7C98082")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void postResetStateAll() {
        mWebView.mPrivateHandler.post(new Runnable() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.868 -0400", hash_original_method = "F322BBB18B8C9804A44774BD272CE6E8", hash_generated_method = "37882F67833C95B3928A4473246B16DD")
            @DSModeled(DSC.SAFE)
            public void run() {
                mReadyToDraw = false;
                // ---------- Original Method ----------
                //mReadyToDraw = false;
            }
});
        // ---------- Original Method ----------
        //mWebView.mPrivateHandler.post(new Runnable() {
            //public void run() {
                //mReadyToDraw = false;
            //}
        //});
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.869 -0400", hash_original_method = "60132EA2B1596F91D6DE492E58F4C89D", hash_generated_method = "249E67993B68B83D61C84D3BDCEFFE95")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void postReadyToDrawAll() {
        mWebView.mPrivateHandler.post(new Runnable() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.869 -0400", hash_original_method = "2C6BB02E5E23FA08F7366ED9683BEC00", hash_generated_method = "F562C2D4E5F0F7B686FD6E462EC8AC6C")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public void run() {
                mReadyToDraw = true;
                {
                    Iterator<ChildView> var1EA0A404291742DF49F29AA36388DCC6_1726240546 = (mChildren).iterator();
                    var1EA0A404291742DF49F29AA36388DCC6_1726240546.hasNext();
                    ChildView v = var1EA0A404291742DF49F29AA36388DCC6_1726240546.next();
                    {
                        v.mView.setVisibility(View.VISIBLE);
                    } //End block
                } //End collapsed parenthetic
                // ---------- Original Method ----------
                //mReadyToDraw = true;
                //for (ChildView v : mChildren) {
                    //v.mView.setVisibility(View.VISIBLE);
                //}
            }
});
        // ---------- Original Method ----------
        //mWebView.mPrivateHandler.post(new Runnable() {
            //public void run() {
                //mReadyToDraw = true;
                //for (ChildView v : mChildren) {
                    //v.mView.setVisibility(View.VISIBLE);
                //}
            //}
        //});
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.872 -0400", hash_original_method = "69EC682FAEAFF2A8235362C63F30F73F", hash_generated_method = "713113807EE57C2A026D4E2175F6FA8C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     ChildView hitTest(int contentX, int contentY) {
        dsTaint.addTaint(contentX);
        dsTaint.addTaint(contentY);
        {
            Iterator<ChildView> var1EA0A404291742DF49F29AA36388DCC6_1949163179 = (mChildren).iterator();
            var1EA0A404291742DF49F29AA36388DCC6_1949163179.hasNext();
            ChildView v = var1EA0A404291742DF49F29AA36388DCC6_1949163179.next();
            {
                {
                    boolean varC780B69AFBE5C1E0FDEB277167BE24EF_782797758 = (v.mView.getVisibility() == View.VISIBLE);
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return (ChildView)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mHidden) {
            //return null;
        //}
        //for (ChildView v : mChildren) {
            //if (v.mView.getVisibility() == View.VISIBLE) {
                //if (contentX >= v.x && contentX < (v.x + v.width)
                        //&& contentY >= v.y && contentY < (v.y + v.height)) {
                    //return v;
                //}
            //}
        //}
        //return null;
    }

    
    class ChildView {
        int x;
        int y;
        int width;
        int height;
        View mView;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.882 -0400", hash_original_method = "444F58071031B7B88B9F4BACE4B52E97", hash_generated_method = "410801DAAF0618526A8A1435EE4A6E2B")
        @DSModeled(DSC.SAFE)
         ChildView() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.882 -0400", hash_original_method = "49948859AFA14B35AAA713D3429ED265", hash_generated_method = "F21B3DC44935981434AE8C71453E7110")
        @DSModeled(DSC.SAFE)
         void setBounds(int x, int y, int width, int height) {
            dsTaint.addTaint(height);
            dsTaint.addTaint(width);
            dsTaint.addTaint(y);
            dsTaint.addTaint(x);
            // ---------- Original Method ----------
            //this.x = x;
            //this.y = y;
            //this.width = width;
            //this.height = height;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.883 -0400", hash_original_method = "C5CB26D6C1A4635E70554CC63D76B563", hash_generated_method = "7B5FC30F01252E493D888AC177726EE9")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         void attachView(int x, int y, int width, int height) {
            dsTaint.addTaint(height);
            dsTaint.addTaint(width);
            dsTaint.addTaint(y);
            dsTaint.addTaint(x);
            setBounds(x, y, width, height);
            mWebView.mPrivateHandler.post(new Runnable() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.883 -0400", hash_original_method = "117F704DE47DD7EBA32238E52F602D4F", hash_generated_method = "6F62D8D05372DF5BDF6E5407811A58B7")
                //DSFIXME:  CODE0002: Requires DSC value to be set
                public void run() {
                    requestLayout(ChildView.this);
                    {
                        boolean var018D659FCBF5505D67261F7D6D0D44D8_808029102 = (mView.getParent() == null);
                        {
                            attachViewOnUIThread();
                        } //End block
                    } //End collapsed parenthetic
                    // ---------- Original Method ----------
                    //requestLayout(ChildView.this);
                    //if (mView.getParent() == null) {
                        //attachViewOnUIThread();
                    //}
                }
});
            // ---------- Original Method ----------
            //if (mView == null) {
                //return;
            //}
            //setBounds(x, y, width, height);
            //mWebView.mPrivateHandler.post(new Runnable() {
                //public void run() {
                    //requestLayout(ChildView.this);
                    //if (mView.getParent() == null) {
                        //attachViewOnUIThread();
                    //}
                //}
            //});
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.883 -0400", hash_original_method = "E19361570D109423E86E664B0AC4389A", hash_generated_method = "8A363701C371B308164AB72B13DE7D43")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void attachViewOnUIThread() {
            mWebView.addView(mView);
            mChildren.add(this);
            {
                mView.setVisibility(View.GONE);
            } //End block
            // ---------- Original Method ----------
            //mWebView.addView(mView);
            //mChildren.add(this);
            //if (!mReadyToDraw) {
                //mView.setVisibility(View.GONE);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.884 -0400", hash_original_method = "82A15EE3F2ACFE39B2389F6444C4BAEB", hash_generated_method = "E4B50FFD491AEBAA93D18D4ED63058D8")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         void removeView() {
            mWebView.mPrivateHandler.post(new Runnable() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.884 -0400", hash_original_method = "FB4DFE3FA699C3363858A9F5BC93D3A8", hash_generated_method = "539B0E7B57B1BE3E5EDA6BDC15BC6A3C")
                //DSFIXME:  CODE0002: Requires DSC value to be set
                public void run() {
                    removeViewOnUIThread();
                    // ---------- Original Method ----------
                    //removeViewOnUIThread();
                }
});
            // ---------- Original Method ----------
            //if (mView == null) {
                //return;
            //}
            //mWebView.mPrivateHandler.post(new Runnable() {
                //public void run() {
                    //removeViewOnUIThread();
                //}
            //});
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.884 -0400", hash_original_method = "2FC5BD33F15E4B580397FED329387FB1", hash_generated_method = "766AEA0F1F8FC4C35F207C999F4B4121")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void removeViewOnUIThread() {
            mWebView.removeView(mView);
            mChildren.remove(this);
            // ---------- Original Method ----------
            //mWebView.removeView(mView);
            //mChildren.remove(this);
        }

        
    }


    
    private static final int MAX_SURFACE_DIMENSION = 2048;
}

