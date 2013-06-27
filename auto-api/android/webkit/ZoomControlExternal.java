package android.webkit;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:02.737 -0400", hash_original_field = "328324C4FD660040B497FF681C21CB4D", hash_generated_field = "2F37B0CB5883AB138CD26F172FE3C9FB")

    private ExtendedZoomControls mZoomControls;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:02.737 -0400", hash_original_field = "836B10DC5103C470D1A7AAC5A19392BE", hash_generated_field = "85E4E26922E29D7084F4C79BB9E29374")

    private Runnable mZoomControlRunnable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:02.737 -0400", hash_original_field = "5F29F5836F7CBF9A7037E015151A7B79", hash_generated_field = "59B39F77CA25C9731CBAEA8737D6F997")

    private Handler mPrivateHandler = new Handler();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:02.737 -0400", hash_original_field = "72439B8F99EB438C3DA5D9CD798C6786", hash_generated_field = "99346B50377E115231263981E00655CA")

    private WebView mWebView;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:02.751 -0400", hash_original_method = "703B91782EEFAD1D42516E3C0CEC522E", hash_generated_method = "D555F9AE790609D762783FBBEA058A92")
    public  ZoomControlExternal(WebView webView) {
        mWebView = webView;
        // ---------- Original Method ----------
        //mWebView = webView;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:02.751 -0400", hash_original_method = "9D13A62EAC4908646E1616576C006DF1", hash_generated_method = "829D2C1AEC6AD3CDF32AF222063FE976")
    public void show() {
        {
            mPrivateHandler.removeCallbacks(mZoomControlRunnable);
        } //End block
        getControls().show(true);
        mPrivateHandler.postDelayed(mZoomControlRunnable, ZOOM_CONTROLS_TIMEOUT);
        // ---------- Original Method ----------
        //if(mZoomControlRunnable != null) {
            //mPrivateHandler.removeCallbacks(mZoomControlRunnable);
        //}
        //getControls().show(true);
        //mPrivateHandler.postDelayed(mZoomControlRunnable, ZOOM_CONTROLS_TIMEOUT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:02.752 -0400", hash_original_method = "F9CBCC4DD32543F3FB45C3890BD1BDBE", hash_generated_method = "685A9EC70D9A005494859FC1E69118B6")
    public void hide() {
        {
            mPrivateHandler.removeCallbacks(mZoomControlRunnable);
        } //End block
        {
            mZoomControls.hide();
        } //End block
        // ---------- Original Method ----------
        //if (mZoomControlRunnable != null) {
            //mPrivateHandler.removeCallbacks(mZoomControlRunnable);
        //}
        //if (mZoomControls != null) {
            //mZoomControls.hide();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:02.752 -0400", hash_original_method = "A600F87081FF5BCBF1AA139788799BF8", hash_generated_method = "18FBDCC951A91012C473CE595B240632")
    public boolean isVisible() {
        boolean varF8D9AA533EE37505E9946BA96FD65AC0_116446496 = (mZoomControls != null && mZoomControls.isShown());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1719853507 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1719853507;
        // ---------- Original Method ----------
        //return mZoomControls != null && mZoomControls.isShown();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:02.752 -0400", hash_original_method = "DB08A4E4B606EDAC2519981C47E0CF53", hash_generated_method = "FB43C517C4395D2CF5B50D0CBB01D588")
    public void update() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:02.755 -0400", hash_original_method = "66298D37AA43B5FB63161B411BC0C63C", hash_generated_method = "ECF1E3D043DA7A81DB8D3F1E6EB7FA8F")
    public ExtendedZoomControls getControls() {
        ExtendedZoomControls varB4EAC82CA7396A68D541C85D26508E83_1785751994 = null; //Variable for return #1
        {
            mZoomControls = createZoomControls();
            mZoomControls.setVisibility(View.VISIBLE);
            mZoomControlRunnable = new Runnable() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:02.754 -0400", hash_original_method = "3BD527966F1D73DAF80F6248F2A62FF2", hash_generated_method = "5EB848276DB92965A47A604CF1DAA393")
                public void run() {
                    {
                        boolean varE152E1E7C0AEF664B8FEF946B65893CD_1236930081 = (!mZoomControls.hasFocus());
                        {
                            mZoomControls.hide();
                        } //End block
                        {
                            mPrivateHandler.removeCallbacks(mZoomControlRunnable);
                            mPrivateHandler.postDelayed(mZoomControlRunnable,
                                ZOOM_CONTROLS_TIMEOUT);
                        } //End block
                    } //End collapsed parenthetic
                    // ---------- Original Method ----------
                    //if (!mZoomControls.hasFocus()) {
                        //mZoomControls.hide();
                    //} else {
                        //mPrivateHandler.removeCallbacks(mZoomControlRunnable);
                        //mPrivateHandler.postDelayed(mZoomControlRunnable,
                                //ZOOM_CONTROLS_TIMEOUT);
                    //}
                }
};
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1785751994 = mZoomControls;
        varB4EAC82CA7396A68D541C85D26508E83_1785751994.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1785751994;
        // ---------- Original Method ----------
        //if (mZoomControls == null) {
            //mZoomControls = createZoomControls();
            //mZoomControls.setVisibility(View.VISIBLE);
            //mZoomControlRunnable = new Runnable() {
                //public void run() {
                    //if (!mZoomControls.hasFocus()) {
                        //mZoomControls.hide();
                    //} else {
                        //mPrivateHandler.removeCallbacks(mZoomControlRunnable);
                        //mPrivateHandler.postDelayed(mZoomControlRunnable,
                                //ZOOM_CONTROLS_TIMEOUT);
                    //}
                //}
            //};
        //}
        //return mZoomControls;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:02.772 -0400", hash_original_method = "3D12A1B47B98985E80612C99D260C6E1", hash_generated_method = "7D9E536C57C707C45A3597F9866AAA51")
    private ExtendedZoomControls createZoomControls() {
        ExtendedZoomControls varB4EAC82CA7396A68D541C85D26508E83_565908812 = null; //Variable for return #1
        ExtendedZoomControls zoomControls;
        zoomControls = new ExtendedZoomControls(mWebView.getContext());
        zoomControls.setOnZoomInClickListener(new OnClickListener() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:02.771 -0400", hash_original_method = "BFE988BAC78978665C545CEC23B4B60A", hash_generated_method = "2F812B860D54FDFD84C31FD0353AA619")
            public void onClick(View v) {
                //DSFIXME:  CODE0009: Possible callback target function detected
                mPrivateHandler.removeCallbacks(mZoomControlRunnable);
                mPrivateHandler.postDelayed(mZoomControlRunnable, ZOOM_CONTROLS_TIMEOUT);
                mWebView.zoomIn();
                addTaint(v.getTaint());
                // ---------- Original Method ----------
                //mPrivateHandler.removeCallbacks(mZoomControlRunnable);
                //mPrivateHandler.postDelayed(mZoomControlRunnable, ZOOM_CONTROLS_TIMEOUT);
                //mWebView.zoomIn();
            }
});
        zoomControls.setOnZoomOutClickListener(new OnClickListener() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:02.771 -0400", hash_original_method = "0743DD5386D9270B67669A328469CD71", hash_generated_method = "9700C3F15F65FA545E495A440263E6D7")
            public void onClick(View v) {
                //DSFIXME:  CODE0009: Possible callback target function detected
                mPrivateHandler.removeCallbacks(mZoomControlRunnable);
                mPrivateHandler.postDelayed(mZoomControlRunnable, ZOOM_CONTROLS_TIMEOUT);
                mWebView.zoomOut();
                addTaint(v.getTaint());
                // ---------- Original Method ----------
                //mPrivateHandler.removeCallbacks(mZoomControlRunnable);
                //mPrivateHandler.postDelayed(mZoomControlRunnable, ZOOM_CONTROLS_TIMEOUT);
                //mWebView.zoomOut();
            }
});
        varB4EAC82CA7396A68D541C85D26508E83_565908812 = zoomControls;
        varB4EAC82CA7396A68D541C85D26508E83_565908812.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_565908812;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    private static class ExtendedZoomControls extends FrameLayout {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:02.772 -0400", hash_original_field = "BB391A911A0C96B2F806CA7403F67BD3", hash_generated_field = "ED36E8FC67260592E9DD391B877393D2")

        private android.widget.ZoomControls mPlusMinusZoomControls;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:02.776 -0400", hash_original_method = "C8C43A8C9AE036629588704CF81CC911", hash_generated_method = "78CDD12A07420160A7E1264BC4EA9788")
        public  ExtendedZoomControls(Context context) {
            super(context, null);
            LayoutInflater inflater;
            inflater = (LayoutInflater)
                    context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            inflater.inflate(com.android.internal.R.layout.zoom_magnify, this, true);
            mPlusMinusZoomControls = (android.widget.ZoomControls) findViewById(
                    com.android.internal.R.id.zoomControls);
            findViewById(com.android.internal.R.id.zoomMagnify).setVisibility(
                    View.GONE);
            addTaint(context.getTaint());
            // ---------- Original Method ----------
            //LayoutInflater inflater = (LayoutInflater)
                    //context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            //inflater.inflate(com.android.internal.R.layout.zoom_magnify, this, true);
            //mPlusMinusZoomControls = (android.widget.ZoomControls) findViewById(
                    //com.android.internal.R.id.zoomControls);
            //findViewById(com.android.internal.R.id.zoomMagnify).setVisibility(
                    //View.GONE);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:02.777 -0400", hash_original_method = "30ACE5BE88DEDA244C3104B68E509E28", hash_generated_method = "7CB873145E4F7C0C781C8B2A9D23A66F")
        public void show(boolean showZoom) {
            mPlusMinusZoomControls.setVisibility(showZoom ? View.VISIBLE : View.GONE);
            fade(View.VISIBLE, 0.0f, 1.0f);
            addTaint(showZoom);
            // ---------- Original Method ----------
            //mPlusMinusZoomControls.setVisibility(showZoom ? View.VISIBLE : View.GONE);
            //fade(View.VISIBLE, 0.0f, 1.0f);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:02.777 -0400", hash_original_method = "E5A5304131EA7BA6BF2FB03B8454E0A2", hash_generated_method = "1763705770489D0C249161FFFC62FF0D")
        public void hide() {
            fade(View.GONE, 1.0f, 0.0f);
            // ---------- Original Method ----------
            //fade(View.GONE, 1.0f, 0.0f);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:02.778 -0400", hash_original_method = "9BED0A47A1FCF93930F77C8CDDC09D0D", hash_generated_method = "39AA330BFFC05ABDE74173F5893938C3")
        private void fade(int visibility, float startAlpha, float endAlpha) {
            AlphaAnimation anim;
            anim = new AlphaAnimation(startAlpha, endAlpha);
            anim.setDuration(500);
            startAnimation(anim);
            setVisibility(visibility);
            addTaint(visibility);
            addTaint(startAlpha);
            addTaint(endAlpha);
            // ---------- Original Method ----------
            //AlphaAnimation anim = new AlphaAnimation(startAlpha, endAlpha);
            //anim.setDuration(500);
            //startAnimation(anim);
            //setVisibility(visibility);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:02.778 -0400", hash_original_method = "686B76CDD5825DB5445B0AA599284809", hash_generated_method = "6A270FF0C03FA1C2F4660BB7A352D6DF")
        public boolean hasFocus() {
            boolean var51CC819E273B58FA5AA2310FF2130EA9_753816939 = (mPlusMinusZoomControls.hasFocus());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1073824522 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1073824522;
            // ---------- Original Method ----------
            //return mPlusMinusZoomControls.hasFocus();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:02.778 -0400", hash_original_method = "BA80E2ADFBC1D35C24B9AA9216D670A5", hash_generated_method = "89F81FF11BAB9F892E324BC01DC580B1")
        public void setOnZoomInClickListener(OnClickListener listener) {
            mPlusMinusZoomControls.setOnZoomInClickListener(listener);
            addTaint(listener.getTaint());
            // ---------- Original Method ----------
            //mPlusMinusZoomControls.setOnZoomInClickListener(listener);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:02.785 -0400", hash_original_method = "E61ACB01329E1401C1A0699266CEDE01", hash_generated_method = "F690AF0A0EC59D50A33DA516837AF6B4")
        public void setOnZoomOutClickListener(OnClickListener listener) {
            mPlusMinusZoomControls.setOnZoomOutClickListener(listener);
            addTaint(listener.getTaint());
            // ---------- Original Method ----------
            //mPlusMinusZoomControls.setOnZoomOutClickListener(listener);
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:02.785 -0400", hash_original_field = "2CE75D468D8046AE73E9F30DDA665B3C", hash_generated_field = "3E6A89D85A4B32CD0E39EC75D1338C86")

    private static long ZOOM_CONTROLS_TIMEOUT = ViewConfiguration.getZoomControlsTimeout();
}

