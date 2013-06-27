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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:01.595 -0400", hash_original_field = "72439B8F99EB438C3DA5D9CD798C6786", hash_generated_field = "99346B50377E115231263981E00655CA")

    private WebView mWebView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:01.595 -0400", hash_original_field = "43045D65246CA9EA1CD85C8ED95C81B9", hash_generated_field = "994F27D6D594C069B0E135C32C0D1D02")

    private ArrayList<ChildView> mChildren = new ArrayList<ChildView>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:01.595 -0400", hash_original_field = "6E5D0646172E31357AC5264CFC6DCF7B", hash_generated_field = "3F147822327D2F3E101E54AA2BDEB694")

    private boolean mHidden;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:01.595 -0400", hash_original_field = "B9F5B669639E87CD8DBAB250FCF69B7E", hash_generated_field = "D4ED2FE7B592D39DCE852F60F1DDCF62")

    private boolean mReadyToDraw;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:01.595 -0400", hash_original_field = "A9A71EF9CAE6C95EE103CF9C30B71089", hash_generated_field = "E2D29020496E97D1FD814233F5B97E36")

    private boolean mZoomInProgress = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:01.595 -0400", hash_original_field = "8BC809A76EF6A9FF57A6D2B9C094DDEB", hash_generated_field = "8321EFE222E741830F977A0EDC376DEE")

    private int MAX_SURFACE_AREA;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:01.596 -0400", hash_original_method = "41D6739987EDABAA49AC971619E5EA69", hash_generated_method = "1C5035B2EF643596F778463A8D8034E9")
      ViewManager(WebView w) {
        mWebView = w;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:01.596 -0400", hash_original_method = "FA4B0F6C2AA9564529C02D0C8EC5ABBE", hash_generated_method = "71DF8DDEF7E8F05D31DB03625B26ABB4")
     ChildView createView() {
        ChildView varB4EAC82CA7396A68D541C85D26508E83_1811309946 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1811309946 = new ChildView();
        varB4EAC82CA7396A68D541C85D26508E83_1811309946.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1811309946;
        // ---------- Original Method ----------
        //return new ChildView();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:01.599 -0400", hash_original_method = "2B29D777BD882375E9FE491E62B8E4F4", hash_generated_method = "B9FED11C3DECC0DB3336AFA2FD4946AC")
    private void requestLayout(ChildView v) {
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
                boolean var3E1D1B0939337281E331FBD6D29EDABE_1339668845 = (sView.isFixedSize() && mZoomInProgress);
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
                boolean var659EC033A3AE435F1C433F73F1F80446_889458068 = (!sView.isFixedSize() && mZoomInProgress);
                {
                    sView.getHolder().setFixedSize(sView.getWidth(),
                                               sView.getHeight());
                } //End block
                {
                    boolean var21CE6BEEBB1C7C80D8C131F48E4BA5F0_254986345 = (sView.isFixedSize() && !mZoomInProgress);
                    {
                        {
                            boolean varE29A4FF89AEBA8C8745667A111F00CB2_1216705642 = (sView.getVisibility() == View.VISIBLE);
                            {
                                sView.setVisibility(View.INVISIBLE);
                                sView.getHolder().setSizeFromLayout();
                                mWebView.mPrivateHandler.post(new Runnable() {                                    
                                    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:01.599 -0400", hash_original_method = "FC4D9F6633FDA07933C38D9105D81F42", hash_generated_method = "CD4E9DF20EB12C15EED4A8BEC8E97002")
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
        addTaint(v.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:01.633 -0400", hash_original_method = "4F661FC74F7E1A720FEE3022046A7DAD", hash_generated_method = "D340E40D19A0FD690D29FA9AA109CFE2")
     void startZoom() {
        mZoomInProgress = true;
        {
            Iterator<ChildView> var1EA0A404291742DF49F29AA36388DCC6_1704525277 = (mChildren).iterator();
            var1EA0A404291742DF49F29AA36388DCC6_1704525277.hasNext();
            ChildView v = var1EA0A404291742DF49F29AA36388DCC6_1704525277.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:01.654 -0400", hash_original_method = "F0F47054709F050065D565E243DB8138", hash_generated_method = "2C555983935F382CD614E5A667867E87")
     void endZoom() {
        mZoomInProgress = false;
        {
            Iterator<ChildView> var1EA0A404291742DF49F29AA36388DCC6_2028519694 = (mChildren).iterator();
            var1EA0A404291742DF49F29AA36388DCC6_2028519694.hasNext();
            ChildView v = var1EA0A404291742DF49F29AA36388DCC6_2028519694.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:01.677 -0400", hash_original_method = "C82C75EA2573C85D59C63AD0662E50B7", hash_generated_method = "E3B6A8737D0D55B2D9BD4176F87B9CD1")
     void scaleAll() {
        {
            Iterator<ChildView> var1EA0A404291742DF49F29AA36388DCC6_1809408386 = (mChildren).iterator();
            var1EA0A404291742DF49F29AA36388DCC6_1809408386.hasNext();
            ChildView v = var1EA0A404291742DF49F29AA36388DCC6_1809408386.next();
            {
                requestLayout(v);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //for (ChildView v : mChildren) {
            //requestLayout(v);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:01.691 -0400", hash_original_method = "4F028387E717D291F0C61AFA65DDC151", hash_generated_method = "37E1672BAA87F3C45E9B3A052F1BAA36")
     void hideAll() {
        {
            Iterator<ChildView> var1EA0A404291742DF49F29AA36388DCC6_1784491598 = (mChildren).iterator();
            var1EA0A404291742DF49F29AA36388DCC6_1784491598.hasNext();
            ChildView v = var1EA0A404291742DF49F29AA36388DCC6_1784491598.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:01.752 -0400", hash_original_method = "B75BBFE8728E55E21A97BD827A74F550", hash_generated_method = "71463408BEAC49974FB03DA39CD4A545")
     void showAll() {
        {
            Iterator<ChildView> var1EA0A404291742DF49F29AA36388DCC6_835299534 = (mChildren).iterator();
            var1EA0A404291742DF49F29AA36388DCC6_835299534.hasNext();
            ChildView v = var1EA0A404291742DF49F29AA36388DCC6_835299534.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:01.753 -0400", hash_original_method = "CA54479F86F4EE856736FA836E1EE2FC", hash_generated_method = "D08F60B7BDFC17C0319BD0C973376642")
     void postResetStateAll() {
        mWebView.mPrivateHandler.post(new Runnable() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:01.753 -0400", hash_original_method = "F322BBB18B8C9804A44774BD272CE6E8", hash_generated_method = "37882F67833C95B3928A4473246B16DD")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:01.771 -0400", hash_original_method = "60132EA2B1596F91D6DE492E58F4C89D", hash_generated_method = "D4489A88143FFD3C010597544F2A143A")
     void postReadyToDrawAll() {
        mWebView.mPrivateHandler.post(new Runnable() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:01.770 -0400", hash_original_method = "2C6BB02E5E23FA08F7366ED9683BEC00", hash_generated_method = "AFEC25E7FE025DC06B275EB1DB44355D")
            public void run() {
                mReadyToDraw = true;
                {
                    Iterator<ChildView> var1EA0A404291742DF49F29AA36388DCC6_1119975602 = (mChildren).iterator();
                    var1EA0A404291742DF49F29AA36388DCC6_1119975602.hasNext();
                    ChildView v = var1EA0A404291742DF49F29AA36388DCC6_1119975602.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:01.809 -0400", hash_original_method = "69EC682FAEAFF2A8235362C63F30F73F", hash_generated_method = "94B49106EBB1F17E21385FA7854B7393")
     ChildView hitTest(int contentX, int contentY) {
        ChildView varB4EAC82CA7396A68D541C85D26508E83_956908584 = null; //Variable for return #1
        ChildView varB4EAC82CA7396A68D541C85D26508E83_1386880125 = null; //Variable for return #2
        ChildView varB4EAC82CA7396A68D541C85D26508E83_107834579 = null; //Variable for return #3
        {
            varB4EAC82CA7396A68D541C85D26508E83_956908584 = null;
        } //End block
        {
            Iterator<ChildView> var1EA0A404291742DF49F29AA36388DCC6_1872082936 = (mChildren).iterator();
            var1EA0A404291742DF49F29AA36388DCC6_1872082936.hasNext();
            ChildView v = var1EA0A404291742DF49F29AA36388DCC6_1872082936.next();
            {
                {
                    boolean varC780B69AFBE5C1E0FDEB277167BE24EF_714855509 = (v.mView.getVisibility() == View.VISIBLE);
                    {
                        {
                            varB4EAC82CA7396A68D541C85D26508E83_1386880125 = v;
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_107834579 = null;
        addTaint(contentX);
        addTaint(contentY);
        ChildView varA7E53CE21691AB073D9660D615818899_598144863; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_598144863 = varB4EAC82CA7396A68D541C85D26508E83_956908584;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_598144863 = varB4EAC82CA7396A68D541C85D26508E83_1386880125;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_598144863 = varB4EAC82CA7396A68D541C85D26508E83_107834579;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_598144863.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_598144863;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:01.809 -0400", hash_original_field = "9DD4E461268C8034F5C8564E155C67A6", hash_generated_field = "3ECDEC351FCE13CBA8A59E38409B3C9E")

        int x;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:01.809 -0400", hash_original_field = "415290769594460E2E485922904F345D", hash_generated_field = "93D19118DABD6AC5BACF335A34537CEB")

        int y;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:01.809 -0400", hash_original_field = "EAAE26A6FB20ED3EF54FB23BFA0B1FCC", hash_generated_field = "1589F848FE4FF192F7CCE1B9F9E85747")

        int width;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:01.809 -0400", hash_original_field = "B435E227D5DD201E1768B2BCB2E0AA81", hash_generated_field = "CE84F1587D182C1F0A32D7CD44443A18")

        int height;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:01.809 -0400", hash_original_field = "7D6C73188D7990FE5A4B99F8F090B9EA", hash_generated_field = "6F4F028D1DE9C463F753A80DD0991753")

        View mView;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:01.810 -0400", hash_original_method = "444F58071031B7B88B9F4BACE4B52E97", hash_generated_method = "410801DAAF0618526A8A1435EE4A6E2B")
          ChildView() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:01.811 -0400", hash_original_method = "49948859AFA14B35AAA713D3429ED265", hash_generated_method = "1647B31ED8A57F0659AE086FB95F7A06")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:01.819 -0400", hash_original_method = "C5CB26D6C1A4635E70554CC63D76B563", hash_generated_method = "017922C1FDF8CEFB02ABDBBC829AED3D")
         void attachView(int x, int y, int width, int height) {
            setBounds(x, y, width, height);
            mWebView.mPrivateHandler.post(new Runnable() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:01.819 -0400", hash_original_method = "117F704DE47DD7EBA32238E52F602D4F", hash_generated_method = "78A32C72E9F002DBC9CD5DE920263926")
                public void run() {
                    requestLayout(ChildView.this);
                    {
                        boolean var018D659FCBF5505D67261F7D6D0D44D8_1960612609 = (mView.getParent() == null);
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
            addTaint(x);
            addTaint(y);
            addTaint(width);
            addTaint(height);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:01.823 -0400", hash_original_method = "E19361570D109423E86E664B0AC4389A", hash_generated_method = "8A363701C371B308164AB72B13DE7D43")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:01.824 -0400", hash_original_method = "82A15EE3F2ACFE39B2389F6444C4BAEB", hash_generated_method = "C4F4359E7DACB5E0F0A12227370AF068")
         void removeView() {
            mWebView.mPrivateHandler.post(new Runnable() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:01.824 -0400", hash_original_method = "FB4DFE3FA699C3363858A9F5BC93D3A8", hash_generated_method = "539B0E7B57B1BE3E5EDA6BDC15BC6A3C")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:01.835 -0400", hash_original_method = "2FC5BD33F15E4B580397FED329387FB1", hash_generated_method = "766AEA0F1F8FC4C35F207C999F4B4121")
        private void removeViewOnUIThread() {
            mWebView.removeView(mView);
            mChildren.remove(this);
            // ---------- Original Method ----------
            //mWebView.removeView(mView);
            //mChildren.remove(this);
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:01.835 -0400", hash_original_field = "5DBBC034EF39D44AEF389028B9BB96CC", hash_generated_field = "39B49CA7EC11CFEB2FE87380301F3416")

    private static int MAX_SURFACE_DIMENSION = 2048;
}

