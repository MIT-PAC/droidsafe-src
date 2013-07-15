package android.webkit;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsoluteLayout;
import java.util.ArrayList;

class ViewManager {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.353 -0400", hash_original_field = "72439B8F99EB438C3DA5D9CD798C6786", hash_generated_field = "99346B50377E115231263981E00655CA")

    private WebView mWebView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.353 -0400", hash_original_field = "43045D65246CA9EA1CD85C8ED95C81B9", hash_generated_field = "A23DCC2022137B3032C531881F046064")

    private final ArrayList<ChildView> mChildren = new ArrayList<ChildView>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.353 -0400", hash_original_field = "6E5D0646172E31357AC5264CFC6DCF7B", hash_generated_field = "3F147822327D2F3E101E54AA2BDEB694")

    private boolean mHidden;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.353 -0400", hash_original_field = "B9F5B669639E87CD8DBAB250FCF69B7E", hash_generated_field = "D4ED2FE7B592D39DCE852F60F1DDCF62")

    private boolean mReadyToDraw;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.353 -0400", hash_original_field = "A9A71EF9CAE6C95EE103CF9C30B71089", hash_generated_field = "E2D29020496E97D1FD814233F5B97E36")

    private boolean mZoomInProgress = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.353 -0400", hash_original_field = "8BC809A76EF6A9FF57A6D2B9C094DDEB", hash_generated_field = "8321EFE222E741830F977A0EDC376DEE")

    private int MAX_SURFACE_AREA;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.354 -0400", hash_original_method = "41D6739987EDABAA49AC971619E5EA69", hash_generated_method = "F5AC1D0F052B1AED1208A98AFCA451B7")
      ViewManager(WebView w) {
        mWebView = w;
        int pixelArea = w.getResources().getDisplayMetrics().widthPixels *
                        w.getResources().getDisplayMetrics().heightPixels;
        MAX_SURFACE_AREA = (int)(pixelArea * 2.75);
        // ---------- Original Method ----------
        //mWebView = w;
        //int pixelArea = w.getResources().getDisplayMetrics().widthPixels *
                        //w.getResources().getDisplayMetrics().heightPixels;
        //MAX_SURFACE_AREA = (int)(pixelArea * 2.75);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.354 -0400", hash_original_method = "FA4B0F6C2AA9564529C02D0C8EC5ABBE", hash_generated_method = "E729C489380F7AB4A1C7883241235F46")
     ChildView createView() {
ChildView var8A3190BB88EBE69DB41074FCFE3B369D_1403357910 =         new ChildView();
        var8A3190BB88EBE69DB41074FCFE3B369D_1403357910.addTaint(taint);
        return var8A3190BB88EBE69DB41074FCFE3B369D_1403357910;
        // ---------- Original Method ----------
        //return new ChildView();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.357 -0400", hash_original_method = "2B29D777BD882375E9FE491E62B8E4F4", hash_generated_method = "328305B226EDD7D9F01320BBAD402C3F")
    private void requestLayout(ChildView v) {
        addTaint(v.getTaint());
        int width = mWebView.contentToViewDimension(v.width);
        int height = mWebView.contentToViewDimension(v.height);
        int x = mWebView.contentToViewX(v.x);
        int y = mWebView.contentToViewY(v.y);
        AbsoluteLayout.LayoutParams lp;
        ViewGroup.LayoutParams layoutParams = v.mView.getLayoutParams();
    if(layoutParams instanceof AbsoluteLayout.LayoutParams)        
        {
            lp = (AbsoluteLayout.LayoutParams) layoutParams;
            lp.width = width;
            lp.height = height;
            lp.x = x;
            lp.y = y;
        } //End block
        else
        {
            lp = new AbsoluteLayout.LayoutParams(width, height, x, y);
        } //End block
        v.mView.setLayoutParams(lp);
    if(v.mView instanceof SurfaceView)        
        {
            final SurfaceView sView = (SurfaceView) v.mView;
    if(sView.isFixedSize() && mZoomInProgress)            
            {
                return;
            } //End block
            int fixedW = width;
            int fixedH = height;
    if(fixedW > MAX_SURFACE_DIMENSION || fixedH > MAX_SURFACE_DIMENSION)            
            {
    if(v.width > v.height)                
                {
                    fixedW = MAX_SURFACE_DIMENSION;
                    fixedH = v.height * MAX_SURFACE_DIMENSION / v.width;
                } //End block
                else
                {
                    fixedH = MAX_SURFACE_DIMENSION;
                    fixedW = v.width * MAX_SURFACE_DIMENSION / v.height;
                } //End block
            } //End block
    if(fixedW * fixedH > MAX_SURFACE_AREA)            
            {
                float area = MAX_SURFACE_AREA;
    if(v.width > v.height)                
                {
                    fixedW = (int)Math.sqrt(area * v.width / v.height);
                    fixedH = v.height * fixedW / v.width;
                } //End block
                else
                {
                    fixedH = (int)Math.sqrt(area * v.height / v.width);
                    fixedW = v.width * fixedH / v.height;
                } //End block
            } //End block
    if(fixedW != width || fixedH != height)            
            {
                sView.getHolder().setFixedSize(fixedW, fixedH);
            } //End block
            else
    if(!sView.isFixedSize() && mZoomInProgress)            
            {
                sView.getHolder().setFixedSize(sView.getWidth(),
                                               sView.getHeight());
            } //End block
            else
    if(sView.isFixedSize() && !mZoomInProgress)            
            {
    if(sView.getVisibility() == View.VISIBLE)                
                {
                    sView.setVisibility(View.INVISIBLE);
                    sView.getHolder().setSizeFromLayout();
                    mWebView.mPrivateHandler.post(new Runnable() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.357 -0400", hash_original_method = "FC4D9F6633FDA07933C38D9105D81F42", hash_generated_method = "CD4E9DF20EB12C15EED4A8BEC8E97002")
        public void run() {
            sView.setVisibility(View.VISIBLE);
            // ---------- Original Method ----------
            //sView.setVisibility(View.VISIBLE);
        }
});
                } //End block
                else
                {
                    sView.getHolder().setSizeFromLayout();
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.358 -0400", hash_original_method = "4F661FC74F7E1A720FEE3022046A7DAD", hash_generated_method = "A1669D7EFC5E91A1C2431496C0B82E56")
     void startZoom() {
        mZoomInProgress = true;
for(ChildView v : mChildren)
        {
            requestLayout(v);
        } //End block
        // ---------- Original Method ----------
        //mZoomInProgress = true;
        //for (ChildView v : mChildren) {
            //requestLayout(v);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.359 -0400", hash_original_method = "F0F47054709F050065D565E243DB8138", hash_generated_method = "2F391B4B259977D73AFFFA42D3682276")
     void endZoom() {
        mZoomInProgress = false;
for(ChildView v : mChildren)
        {
            requestLayout(v);
        } //End block
        // ---------- Original Method ----------
        //mZoomInProgress = false;
        //for (ChildView v : mChildren) {
            //requestLayout(v);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.359 -0400", hash_original_method = "C82C75EA2573C85D59C63AD0662E50B7", hash_generated_method = "5110AFD9926B9EDC2F5CDEE0E17B367F")
     void scaleAll() {
for(ChildView v : mChildren)
        {
            requestLayout(v);
        } //End block
        // ---------- Original Method ----------
        //for (ChildView v : mChildren) {
            //requestLayout(v);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.359 -0400", hash_original_method = "4F028387E717D291F0C61AFA65DDC151", hash_generated_method = "899EEA859992131FDE618D4D2A6C7D40")
     void hideAll() {
    if(mHidden)        
        {
            return;
        } //End block
for(ChildView v : mChildren)
        {
            v.mView.setVisibility(View.GONE);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.360 -0400", hash_original_method = "B75BBFE8728E55E21A97BD827A74F550", hash_generated_method = "B8376291755508591E874DDA1C30F9ED")
     void showAll() {
    if(!mHidden)        
        {
            return;
        } //End block
for(ChildView v : mChildren)
        {
            v.mView.setVisibility(View.VISIBLE);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.360 -0400", hash_original_method = "CA54479F86F4EE856736FA836E1EE2FC", hash_generated_method = "060028AFA1978E4E1755F030EE08FDC6")
     void postResetStateAll() {
        mWebView.mPrivateHandler.post(new Runnable() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.360 -0400", hash_original_method = "F322BBB18B8C9804A44774BD272CE6E8", hash_generated_method = "37882F67833C95B3928A4473246B16DD")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.361 -0400", hash_original_method = "60132EA2B1596F91D6DE492E58F4C89D", hash_generated_method = "EF8E8D42BE3DFFAE8FA4A06B34C74A78")
     void postReadyToDrawAll() {
        mWebView.mPrivateHandler.post(new Runnable() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.361 -0400", hash_original_method = "2C6BB02E5E23FA08F7366ED9683BEC00", hash_generated_method = "004BD4EAD0FD03899A7C3AE7605CEB3E")
        public void run() {
            mReadyToDraw = true;
for(ChildView v : mChildren)
            {
                v.mView.setVisibility(View.VISIBLE);
            } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.361 -0400", hash_original_method = "69EC682FAEAFF2A8235362C63F30F73F", hash_generated_method = "146D0F3F890A9C5AC9AA49814C83FE90")
     ChildView hitTest(int contentX, int contentY) {
        addTaint(contentY);
        addTaint(contentX);
    if(mHidden)        
        {
ChildView var540C13E9E156B687226421B24F2DF178_1677927424 =             null;
            var540C13E9E156B687226421B24F2DF178_1677927424.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1677927424;
        } //End block
for(ChildView v : mChildren)
        {
    if(v.mView.getVisibility() == View.VISIBLE)            
            {
    if(contentX >= v.x && contentX < (v.x + v.width)
                        && contentY >= v.y && contentY < (v.y + v.height))                
                {
ChildView var6DC76BC51820DD65E8396280E884AA78_161462758 =                     v;
                    var6DC76BC51820DD65E8396280E884AA78_161462758.addTaint(taint);
                    return var6DC76BC51820DD65E8396280E884AA78_161462758;
                } //End block
            } //End block
        } //End block
ChildView var540C13E9E156B687226421B24F2DF178_206987639 =         null;
        var540C13E9E156B687226421B24F2DF178_206987639.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_206987639;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.362 -0400", hash_original_field = "9DD4E461268C8034F5C8564E155C67A6", hash_generated_field = "3ECDEC351FCE13CBA8A59E38409B3C9E")

        int x;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.362 -0400", hash_original_field = "415290769594460E2E485922904F345D", hash_generated_field = "93D19118DABD6AC5BACF335A34537CEB")

        int y;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.362 -0400", hash_original_field = "EAAE26A6FB20ED3EF54FB23BFA0B1FCC", hash_generated_field = "1589F848FE4FF192F7CCE1B9F9E85747")

        int width;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.362 -0400", hash_original_field = "B435E227D5DD201E1768B2BCB2E0AA81", hash_generated_field = "CE84F1587D182C1F0A32D7CD44443A18")

        int height;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.362 -0400", hash_original_field = "7D6C73188D7990FE5A4B99F8F090B9EA", hash_generated_field = "6F4F028D1DE9C463F753A80DD0991753")

        View mView;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.362 -0400", hash_original_method = "444F58071031B7B88B9F4BACE4B52E97", hash_generated_method = "410801DAAF0618526A8A1435EE4A6E2B")
          ChildView() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.363 -0400", hash_original_method = "49948859AFA14B35AAA713D3429ED265", hash_generated_method = "1647B31ED8A57F0659AE086FB95F7A06")
         void setBounds(int x, int y, int width, int height) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
            // ---------- Original Method ----------
            //this.x = x;
            //this.y = y;
            //this.width = width;
            //this.height = height;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.363 -0400", hash_original_method = "C5CB26D6C1A4635E70554CC63D76B563", hash_generated_method = "F8766B19830C35308C2A2B68B33543F5")
         void attachView(int x, int y, int width, int height) {
            addTaint(height);
            addTaint(width);
            addTaint(y);
            addTaint(x);
    if(mView == null)            
            {
                return;
            } //End block
            setBounds(x, y, width, height);
            mWebView.mPrivateHandler.post(new Runnable() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.363 -0400", hash_original_method = "117F704DE47DD7EBA32238E52F602D4F", hash_generated_method = "5B1844C55739E8BDD92198BB8013169B")
            public void run() {
                requestLayout(ChildView.this);
    if(mView.getParent() == null)                
                {
                    attachViewOnUIThread();
                } //End block
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.364 -0400", hash_original_method = "E19361570D109423E86E664B0AC4389A", hash_generated_method = "81F1B9CCE09D41FA95747D6546C055C7")
        private void attachViewOnUIThread() {
            mWebView.addView(mView);
            mChildren.add(this);
    if(!mReadyToDraw)            
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.364 -0400", hash_original_method = "82A15EE3F2ACFE39B2389F6444C4BAEB", hash_generated_method = "32A1EA6F755637D4674CD98818EDD7F8")
         void removeView() {
    if(mView == null)            
            {
                return;
            } //End block
            mWebView.mPrivateHandler.post(new Runnable() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.364 -0400", hash_original_method = "FB4DFE3FA699C3363858A9F5BC93D3A8", hash_generated_method = "539B0E7B57B1BE3E5EDA6BDC15BC6A3C")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.365 -0400", hash_original_method = "2FC5BD33F15E4B580397FED329387FB1", hash_generated_method = "766AEA0F1F8FC4C35F207C999F4B4121")
        private void removeViewOnUIThread() {
            mWebView.removeView(mView);
            mChildren.remove(this);
            // ---------- Original Method ----------
            //mWebView.removeView(mView);
            //mChildren.remove(this);
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:59.365 -0400", hash_original_field = "5DBBC034EF39D44AEF389028B9BB96CC", hash_generated_field = "52CD7F2804541D9D147DA6137D506751")

    private static final int MAX_SURFACE_DIMENSION = 2048;
}

