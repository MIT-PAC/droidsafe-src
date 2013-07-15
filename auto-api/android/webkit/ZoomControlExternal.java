package android.webkit;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;

class ZoomControlExternal implements ZoomControlBase {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.076 -0400", hash_original_field = "328324C4FD660040B497FF681C21CB4D", hash_generated_field = "2F37B0CB5883AB138CD26F172FE3C9FB")

    private ExtendedZoomControls mZoomControls;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.076 -0400", hash_original_field = "836B10DC5103C470D1A7AAC5A19392BE", hash_generated_field = "85E4E26922E29D7084F4C79BB9E29374")

    private Runnable mZoomControlRunnable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.076 -0400", hash_original_field = "5F29F5836F7CBF9A7037E015151A7B79", hash_generated_field = "DB9655D350EF0F7F7F47B82F02BFFFB5")

    private final Handler mPrivateHandler = new Handler();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.076 -0400", hash_original_field = "72439B8F99EB438C3DA5D9CD798C6786", hash_generated_field = "99346B50377E115231263981E00655CA")

    private WebView mWebView;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.077 -0400", hash_original_method = "703B91782EEFAD1D42516E3C0CEC522E", hash_generated_method = "D555F9AE790609D762783FBBEA058A92")
    public  ZoomControlExternal(WebView webView) {
        mWebView = webView;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.077 -0400", hash_original_method = "9D13A62EAC4908646E1616576C006DF1", hash_generated_method = "829D2C1AEC6AD3CDF32AF222063FE976")
    public void show() {
        {
            mPrivateHandler.removeCallbacks(mZoomControlRunnable);
        } 
        getControls().show(true);
        mPrivateHandler.postDelayed(mZoomControlRunnable, ZOOM_CONTROLS_TIMEOUT);
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.077 -0400", hash_original_method = "F9CBCC4DD32543F3FB45C3890BD1BDBE", hash_generated_method = "685A9EC70D9A005494859FC1E69118B6")
    public void hide() {
        {
            mPrivateHandler.removeCallbacks(mZoomControlRunnable);
        } 
        {
            mZoomControls.hide();
        } 
        
        
            
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.078 -0400", hash_original_method = "A600F87081FF5BCBF1AA139788799BF8", hash_generated_method = "166F1A7AF93ACC697D1677B8E176EFDF")
    public boolean isVisible() {
        boolean varF8D9AA533EE37505E9946BA96FD65AC0_761241656 = (mZoomControls != null && mZoomControls.isShown());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1153200097 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1153200097;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.078 -0400", hash_original_method = "DB08A4E4B606EDAC2519981C47E0CF53", hash_generated_method = "FB43C517C4395D2CF5B50D0CBB01D588")
    public void update() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.079 -0400", hash_original_method = "66298D37AA43B5FB63161B411BC0C63C", hash_generated_method = "A43683F0884F6DA3451B0C4E2DC76292")
    public ExtendedZoomControls getControls() {
        ExtendedZoomControls varB4EAC82CA7396A68D541C85D26508E83_788920075 = null; 
        {
            mZoomControls = createZoomControls();
            mZoomControls.setVisibility(View.VISIBLE);
            mZoomControlRunnable = new Runnable() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.079 -0400", hash_original_method = "3BD527966F1D73DAF80F6248F2A62FF2", hash_generated_method = "38C486661481823C68573B4E4AF10BD5")
                public void run() {
                    {
                        boolean varE152E1E7C0AEF664B8FEF946B65893CD_1238846912 = (!mZoomControls.hasFocus());
                        {
                            mZoomControls.hide();
                        } 
                        {
                            mPrivateHandler.removeCallbacks(mZoomControlRunnable);
                            mPrivateHandler.postDelayed(mZoomControlRunnable,
                                ZOOM_CONTROLS_TIMEOUT);
                        } 
                    } 
                    
                    
                        
                    
                        
                        
                                
                    
                }
};
        } 
        varB4EAC82CA7396A68D541C85D26508E83_788920075 = mZoomControls;
        varB4EAC82CA7396A68D541C85D26508E83_788920075.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_788920075;
        
        
            
            
            
                
                    
                        
                    
                        
                        
                                
                    
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.083 -0400", hash_original_method = "3D12A1B47B98985E80612C99D260C6E1", hash_generated_method = "07A017043ED5402B4753D2C27B1FF307")
    private ExtendedZoomControls createZoomControls() {
        ExtendedZoomControls varB4EAC82CA7396A68D541C85D26508E83_154806958 = null; 
        ExtendedZoomControls zoomControls = new ExtendedZoomControls(mWebView.getContext());
        zoomControls.setOnZoomInClickListener(new OnClickListener() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.081 -0400", hash_original_method = "BFE988BAC78978665C545CEC23B4B60A", hash_generated_method = "2F812B860D54FDFD84C31FD0353AA619")
            public void onClick(View v) {
                
                mPrivateHandler.removeCallbacks(mZoomControlRunnable);
                mPrivateHandler.postDelayed(mZoomControlRunnable, ZOOM_CONTROLS_TIMEOUT);
                mWebView.zoomIn();
                addTaint(v.getTaint());
                
                
                
                
            }
});
        zoomControls.setOnZoomOutClickListener(new OnClickListener() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.082 -0400", hash_original_method = "0743DD5386D9270B67669A328469CD71", hash_generated_method = "9700C3F15F65FA545E495A440263E6D7")
            public void onClick(View v) {
                
                mPrivateHandler.removeCallbacks(mZoomControlRunnable);
                mPrivateHandler.postDelayed(mZoomControlRunnable, ZOOM_CONTROLS_TIMEOUT);
                mWebView.zoomOut();
                addTaint(v.getTaint());
                
                
                
                
            }
});
        varB4EAC82CA7396A68D541C85D26508E83_154806958 = zoomControls;
        varB4EAC82CA7396A68D541C85D26508E83_154806958.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_154806958;
        
        
    }

    
    private static class ExtendedZoomControls extends FrameLayout {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.083 -0400", hash_original_field = "BB391A911A0C96B2F806CA7403F67BD3", hash_generated_field = "ED36E8FC67260592E9DD391B877393D2")

        private android.widget.ZoomControls mPlusMinusZoomControls;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.083 -0400", hash_original_method = "C8C43A8C9AE036629588704CF81CC911", hash_generated_method = "BD1D46DB288C0DCB4BF3C5D1D5D23E8F")
        public  ExtendedZoomControls(Context context) {
            super(context, null);
            LayoutInflater inflater = (LayoutInflater)
                    context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            inflater.inflate(com.android.internal.R.layout.zoom_magnify, this, true);
            mPlusMinusZoomControls = (android.widget.ZoomControls) findViewById(
                    com.android.internal.R.id.zoomControls);
            findViewById(com.android.internal.R.id.zoomMagnify).setVisibility(
                    View.GONE);
            addTaint(context.getTaint());
            
            
                    
            
            
                    
            
                    
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.084 -0400", hash_original_method = "30ACE5BE88DEDA244C3104B68E509E28", hash_generated_method = "7CB873145E4F7C0C781C8B2A9D23A66F")
        public void show(boolean showZoom) {
            mPlusMinusZoomControls.setVisibility(showZoom ? View.VISIBLE : View.GONE);
            fade(View.VISIBLE, 0.0f, 1.0f);
            addTaint(showZoom);
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.084 -0400", hash_original_method = "E5A5304131EA7BA6BF2FB03B8454E0A2", hash_generated_method = "1763705770489D0C249161FFFC62FF0D")
        public void hide() {
            fade(View.GONE, 1.0f, 0.0f);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.084 -0400", hash_original_method = "9BED0A47A1FCF93930F77C8CDDC09D0D", hash_generated_method = "C206DEB03BD22BD21BE1A0C5AB6FB3FE")
        private void fade(int visibility, float startAlpha, float endAlpha) {
            AlphaAnimation anim = new AlphaAnimation(startAlpha, endAlpha);
            anim.setDuration(500);
            startAnimation(anim);
            setVisibility(visibility);
            addTaint(visibility);
            addTaint(startAlpha);
            addTaint(endAlpha);
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.085 -0400", hash_original_method = "686B76CDD5825DB5445B0AA599284809", hash_generated_method = "A5D2DA1FA140CBE4261CAA395C2E5EB7")
        public boolean hasFocus() {
            boolean var51CC819E273B58FA5AA2310FF2130EA9_398236835 = (mPlusMinusZoomControls.hasFocus());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1845897838 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1845897838;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.085 -0400", hash_original_method = "BA80E2ADFBC1D35C24B9AA9216D670A5", hash_generated_method = "89F81FF11BAB9F892E324BC01DC580B1")
        public void setOnZoomInClickListener(OnClickListener listener) {
            mPlusMinusZoomControls.setOnZoomInClickListener(listener);
            addTaint(listener.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.085 -0400", hash_original_method = "E61ACB01329E1401C1A0699266CEDE01", hash_generated_method = "F690AF0A0EC59D50A33DA516837AF6B4")
        public void setOnZoomOutClickListener(OnClickListener listener) {
            mPlusMinusZoomControls.setOnZoomOutClickListener(listener);
            addTaint(listener.getTaint());
            
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.085 -0400", hash_original_field = "2CE75D468D8046AE73E9F30DDA665B3C", hash_generated_field = "4E2B5D96681EAE0558B94E904BDAC5D9")

    private static final long ZOOM_CONTROLS_TIMEOUT = ViewConfiguration.getZoomControlsTimeout();
}

