package android.webkit;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsoluteLayout;
import java.util.ArrayList;

class ViewManager {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.687 -0400", hash_original_field = "72439B8F99EB438C3DA5D9CD798C6786", hash_generated_field = "99346B50377E115231263981E00655CA")

    private WebView mWebView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.687 -0400", hash_original_field = "43045D65246CA9EA1CD85C8ED95C81B9", hash_generated_field = "A23DCC2022137B3032C531881F046064")

    private final ArrayList<ChildView> mChildren = new ArrayList<ChildView>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.687 -0400", hash_original_field = "6E5D0646172E31357AC5264CFC6DCF7B", hash_generated_field = "3F147822327D2F3E101E54AA2BDEB694")

    private boolean mHidden;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.687 -0400", hash_original_field = "B9F5B669639E87CD8DBAB250FCF69B7E", hash_generated_field = "D4ED2FE7B592D39DCE852F60F1DDCF62")

    private boolean mReadyToDraw;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.687 -0400", hash_original_field = "A9A71EF9CAE6C95EE103CF9C30B71089", hash_generated_field = "E2D29020496E97D1FD814233F5B97E36")

    private boolean mZoomInProgress = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.687 -0400", hash_original_field = "8BC809A76EF6A9FF57A6D2B9C094DDEB", hash_generated_field = "8321EFE222E741830F977A0EDC376DEE")

    private int MAX_SURFACE_AREA;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.687 -0400", hash_original_method = "41D6739987EDABAA49AC971619E5EA69", hash_generated_method = "F5AC1D0F052B1AED1208A98AFCA451B7")
      ViewManager(WebView w) {
        mWebView = w;
        int pixelArea = w.getResources().getDisplayMetrics().widthPixels *
                        w.getResources().getDisplayMetrics().heightPixels;
        MAX_SURFACE_AREA = (int)(pixelArea * 2.75);
        
        
        
                        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.688 -0400", hash_original_method = "FA4B0F6C2AA9564529C02D0C8EC5ABBE", hash_generated_method = "C8595D54321DCA8FA0E150A59828074E")
     ChildView createView() {
        ChildView varB4EAC82CA7396A68D541C85D26508E83_656171385 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_656171385 = new ChildView();
        varB4EAC82CA7396A68D541C85D26508E83_656171385.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_656171385;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.690 -0400", hash_original_method = "2B29D777BD882375E9FE491E62B8E4F4", hash_generated_method = "D13479BA0A3A27B5759B6D7BDFBD96FB")
    private void requestLayout(ChildView v) {
        int width = mWebView.contentToViewDimension(v.width);
        int height = mWebView.contentToViewDimension(v.height);
        int x = mWebView.contentToViewX(v.x);
        int y = mWebView.contentToViewY(v.y);
        AbsoluteLayout.LayoutParams lp;
        ViewGroup.LayoutParams layoutParams = v.mView.getLayoutParams();
        {
            lp = (AbsoluteLayout.LayoutParams) layoutParams;
            lp.width = width;
            lp.height = height;
            lp.x = x;
            lp.y = y;
        } 
        {
            lp = new AbsoluteLayout.LayoutParams(width, height, x, y);
        } 
        v.mView.setLayoutParams(lp);
        {
            final SurfaceView sView = (SurfaceView) v.mView;
            {
                boolean var3E1D1B0939337281E331FBD6D29EDABE_169429178 = (sView.isFixedSize() && mZoomInProgress);
            } 
            int fixedW = width;
            int fixedH = height;
            {
                {
                    fixedW = MAX_SURFACE_DIMENSION;
                    fixedH = v.height * MAX_SURFACE_DIMENSION / v.width;
                } 
                {
                    fixedH = MAX_SURFACE_DIMENSION;
                    fixedW = v.width * MAX_SURFACE_DIMENSION / v.height;
                } 
            } 
            {
                float area = MAX_SURFACE_AREA;
                {
                    fixedW = (int)Math.sqrt(area * v.width / v.height);
                    fixedH = v.height * fixedW / v.width;
                } 
                {
                    fixedH = (int)Math.sqrt(area * v.height / v.width);
                    fixedW = v.width * fixedH / v.height;
                } 
            } 
            {
                sView.getHolder().setFixedSize(fixedW, fixedH);
            } 
            {
                boolean var659EC033A3AE435F1C433F73F1F80446_563594134 = (!sView.isFixedSize() && mZoomInProgress);
                {
                    sView.getHolder().setFixedSize(sView.getWidth(),
                                               sView.getHeight());
                } 
                {
                    boolean var21CE6BEEBB1C7C80D8C131F48E4BA5F0_1888494465 = (sView.isFixedSize() && !mZoomInProgress);
                    {
                        {
                            boolean varE29A4FF89AEBA8C8745667A111F00CB2_38006882 = (sView.getVisibility() == View.VISIBLE);
                            {
                                sView.setVisibility(View.INVISIBLE);
                                sView.getHolder().setSizeFromLayout();
                                mWebView.mPrivateHandler.post(new Runnable() {                                    
                                    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.689 -0400", hash_original_method = "FC4D9F6633FDA07933C38D9105D81F42", hash_generated_method = "CD4E9DF20EB12C15EED4A8BEC8E97002")
                                    public void run() {
                                        sView.setVisibility(View.VISIBLE);
                                        
                                        
                                    }
});
                            } 
                            {
                                sView.getHolder().setSizeFromLayout();
                            } 
                        } 
                    } 
                } 
            } 
        } 
        addTaint(v.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.693 -0400", hash_original_method = "4F661FC74F7E1A720FEE3022046A7DAD", hash_generated_method = "838A14E0ACABC4A73B35F8E3DAB24C2A")
     void startZoom() {
        mZoomInProgress = true;
        {
            Iterator<ChildView> var1EA0A404291742DF49F29AA36388DCC6_909612691 = (mChildren).iterator();
            var1EA0A404291742DF49F29AA36388DCC6_909612691.hasNext();
            ChildView v = var1EA0A404291742DF49F29AA36388DCC6_909612691.next();
            {
                requestLayout(v);
            } 
        } 
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.695 -0400", hash_original_method = "F0F47054709F050065D565E243DB8138", hash_generated_method = "D8144EA9FF668C141E7331F31AECF094")
     void endZoom() {
        mZoomInProgress = false;
        {
            Iterator<ChildView> var1EA0A404291742DF49F29AA36388DCC6_2062304031 = (mChildren).iterator();
            var1EA0A404291742DF49F29AA36388DCC6_2062304031.hasNext();
            ChildView v = var1EA0A404291742DF49F29AA36388DCC6_2062304031.next();
            {
                requestLayout(v);
            } 
        } 
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.698 -0400", hash_original_method = "C82C75EA2573C85D59C63AD0662E50B7", hash_generated_method = "6A145B9FEB907C9A9CA6D473E5CF57A8")
     void scaleAll() {
        {
            Iterator<ChildView> var1EA0A404291742DF49F29AA36388DCC6_432479965 = (mChildren).iterator();
            var1EA0A404291742DF49F29AA36388DCC6_432479965.hasNext();
            ChildView v = var1EA0A404291742DF49F29AA36388DCC6_432479965.next();
            {
                requestLayout(v);
            } 
        } 
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.701 -0400", hash_original_method = "4F028387E717D291F0C61AFA65DDC151", hash_generated_method = "A26E2DCFD238D2633AECD40905160AB3")
     void hideAll() {
        {
            Iterator<ChildView> var1EA0A404291742DF49F29AA36388DCC6_764634654 = (mChildren).iterator();
            var1EA0A404291742DF49F29AA36388DCC6_764634654.hasNext();
            ChildView v = var1EA0A404291742DF49F29AA36388DCC6_764634654.next();
            {
                v.mView.setVisibility(View.GONE);
            } 
        } 
        mHidden = true;
        
        
            
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.705 -0400", hash_original_method = "B75BBFE8728E55E21A97BD827A74F550", hash_generated_method = "E9AD1D8F784AAA31C682D05C17263478")
     void showAll() {
        {
            Iterator<ChildView> var1EA0A404291742DF49F29AA36388DCC6_121934149 = (mChildren).iterator();
            var1EA0A404291742DF49F29AA36388DCC6_121934149.hasNext();
            ChildView v = var1EA0A404291742DF49F29AA36388DCC6_121934149.next();
            {
                v.mView.setVisibility(View.VISIBLE);
            } 
        } 
        mHidden = false;
        
        
            
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.706 -0400", hash_original_method = "CA54479F86F4EE856736FA836E1EE2FC", hash_generated_method = "8A43EE6F30EBD7D1502641FBBFEFD927")
     void postResetStateAll() {
        mWebView.mPrivateHandler.post(new Runnable() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.706 -0400", hash_original_method = "F322BBB18B8C9804A44774BD272CE6E8", hash_generated_method = "37882F67833C95B3928A4473246B16DD")
            public void run() {
                mReadyToDraw = false;
                
                
            }
});
        
        
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.707 -0400", hash_original_method = "60132EA2B1596F91D6DE492E58F4C89D", hash_generated_method = "87A527CB223BEC637E46E002A282AFCE")
     void postReadyToDrawAll() {
        mWebView.mPrivateHandler.post(new Runnable() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.707 -0400", hash_original_method = "2C6BB02E5E23FA08F7366ED9683BEC00", hash_generated_method = "1031600C46A3276926B3BA93CC577EC0")
            public void run() {
                mReadyToDraw = true;
                {
                    Iterator<ChildView> var1EA0A404291742DF49F29AA36388DCC6_273676885 = (mChildren).iterator();
                    var1EA0A404291742DF49F29AA36388DCC6_273676885.hasNext();
                    ChildView v = var1EA0A404291742DF49F29AA36388DCC6_273676885.next();
                    {
                        v.mView.setVisibility(View.VISIBLE);
                    } 
                } 
                
                
                
                    
                
            }
});
        
        
            
                
                
                    
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.714 -0400", hash_original_method = "69EC682FAEAFF2A8235362C63F30F73F", hash_generated_method = "80F670A406FEC0E7D41E38C21E861288")
     ChildView hitTest(int contentX, int contentY) {
        ChildView varB4EAC82CA7396A68D541C85D26508E83_2063666340 = null; 
        ChildView varB4EAC82CA7396A68D541C85D26508E83_1998523228 = null; 
        ChildView varB4EAC82CA7396A68D541C85D26508E83_958912113 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_2063666340 = null;
        } 
        {
            Iterator<ChildView> var1EA0A404291742DF49F29AA36388DCC6_990513996 = (mChildren).iterator();
            var1EA0A404291742DF49F29AA36388DCC6_990513996.hasNext();
            ChildView v = var1EA0A404291742DF49F29AA36388DCC6_990513996.next();
            {
                {
                    boolean varC780B69AFBE5C1E0FDEB277167BE24EF_423854712 = (v.mView.getVisibility() == View.VISIBLE);
                    {
                        {
                            varB4EAC82CA7396A68D541C85D26508E83_1998523228 = v;
                        } 
                    } 
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_958912113 = null;
        addTaint(contentX);
        addTaint(contentY);
        ChildView varA7E53CE21691AB073D9660D615818899_1198798045; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1198798045 = varB4EAC82CA7396A68D541C85D26508E83_2063666340;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1198798045 = varB4EAC82CA7396A68D541C85D26508E83_1998523228;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1198798045 = varB4EAC82CA7396A68D541C85D26508E83_958912113;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1198798045.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1198798045;
        
        
            
        
        
            
                
                        
                    
                
            
        
        
    }

    
    class ChildView {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.714 -0400", hash_original_field = "9DD4E461268C8034F5C8564E155C67A6", hash_generated_field = "3ECDEC351FCE13CBA8A59E38409B3C9E")

        int x;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.714 -0400", hash_original_field = "415290769594460E2E485922904F345D", hash_generated_field = "93D19118DABD6AC5BACF335A34537CEB")

        int y;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.714 -0400", hash_original_field = "EAAE26A6FB20ED3EF54FB23BFA0B1FCC", hash_generated_field = "1589F848FE4FF192F7CCE1B9F9E85747")

        int width;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.714 -0400", hash_original_field = "B435E227D5DD201E1768B2BCB2E0AA81", hash_generated_field = "CE84F1587D182C1F0A32D7CD44443A18")

        int height;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.714 -0400", hash_original_field = "7D6C73188D7990FE5A4B99F8F090B9EA", hash_generated_field = "6F4F028D1DE9C463F753A80DD0991753")

        View mView;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.715 -0400", hash_original_method = "444F58071031B7B88B9F4BACE4B52E97", hash_generated_method = "410801DAAF0618526A8A1435EE4A6E2B")
          ChildView() {
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.715 -0400", hash_original_method = "49948859AFA14B35AAA713D3429ED265", hash_generated_method = "1647B31ED8A57F0659AE086FB95F7A06")
         void setBounds(int x, int y, int width, int height) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
            
            
            
            
            
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.716 -0400", hash_original_method = "C5CB26D6C1A4635E70554CC63D76B563", hash_generated_method = "5315B8D18A591B5EE51F2E6BF220F7BD")
         void attachView(int x, int y, int width, int height) {
            setBounds(x, y, width, height);
            mWebView.mPrivateHandler.post(new Runnable() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.716 -0400", hash_original_method = "117F704DE47DD7EBA32238E52F602D4F", hash_generated_method = "1A4642C7347096298AB4C6163094FF1E")
                public void run() {
                    requestLayout(ChildView.this);
                    {
                        boolean var018D659FCBF5505D67261F7D6D0D44D8_1343565793 = (mView.getParent() == null);
                        {
                            attachViewOnUIThread();
                        } 
                    } 
                    
                    
                    
                        
                    
                }
});
            addTaint(x);
            addTaint(y);
            addTaint(width);
            addTaint(height);
            
            
                
            
            
            
                
                    
                    
                        
                    
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.716 -0400", hash_original_method = "E19361570D109423E86E664B0AC4389A", hash_generated_method = "8A363701C371B308164AB72B13DE7D43")
        private void attachViewOnUIThread() {
            mWebView.addView(mView);
            mChildren.add(this);
            {
                mView.setVisibility(View.GONE);
            } 
            
            
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.717 -0400", hash_original_method = "82A15EE3F2ACFE39B2389F6444C4BAEB", hash_generated_method = "21E4F0626465D8F4F44692B9170CF5C1")
         void removeView() {
            mWebView.mPrivateHandler.post(new Runnable() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.717 -0400", hash_original_method = "FB4DFE3FA699C3363858A9F5BC93D3A8", hash_generated_method = "539B0E7B57B1BE3E5EDA6BDC15BC6A3C")
                public void run() {
                    removeViewOnUIThread();
                    
                    
                }
});
            
            
                
            
            
                
                    
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.717 -0400", hash_original_method = "2FC5BD33F15E4B580397FED329387FB1", hash_generated_method = "766AEA0F1F8FC4C35F207C999F4B4121")
        private void removeViewOnUIThread() {
            mWebView.removeView(mView);
            mChildren.remove(this);
            
            
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:05.717 -0400", hash_original_field = "5DBBC034EF39D44AEF389028B9BB96CC", hash_generated_field = "52CD7F2804541D9D147DA6137D506751")

    private static final int MAX_SURFACE_DIMENSION = 2048;
}

