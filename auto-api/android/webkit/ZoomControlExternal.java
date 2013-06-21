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
    private ExtendedZoomControls mZoomControls;
    private Runnable mZoomControlRunnable;
    private Handler mPrivateHandler = new Handler();
    private WebView mWebView;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.388 -0400", hash_original_method = "703B91782EEFAD1D42516E3C0CEC522E", hash_generated_method = "792AFE31794C29CEE04B04E1DA757E4E")
    @DSModeled(DSC.SAFE)
    public ZoomControlExternal(WebView webView) {
        dsTaint.addTaint(webView.dsTaint);
        // ---------- Original Method ----------
        //mWebView = webView;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.389 -0400", hash_original_method = "9D13A62EAC4908646E1616576C006DF1", hash_generated_method = "829D2C1AEC6AD3CDF32AF222063FE976")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.390 -0400", hash_original_method = "F9CBCC4DD32543F3FB45C3890BD1BDBE", hash_generated_method = "685A9EC70D9A005494859FC1E69118B6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.391 -0400", hash_original_method = "A600F87081FF5BCBF1AA139788799BF8", hash_generated_method = "653FDC584186777487C0D49D1E6FF2CF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isVisible() {
        boolean varF8D9AA533EE37505E9946BA96FD65AC0_1729886440 = (mZoomControls != null && mZoomControls.isShown());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mZoomControls != null && mZoomControls.isShown();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.391 -0400", hash_original_method = "DB08A4E4B606EDAC2519981C47E0CF53", hash_generated_method = "FB43C517C4395D2CF5B50D0CBB01D588")
    @DSModeled(DSC.SAFE)
    public void update() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.391 -0400", hash_original_method = "66298D37AA43B5FB63161B411BC0C63C", hash_generated_method = "6FD13B48C313D8A7C7B5595FABBA9253")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ExtendedZoomControls getControls() {
        {
            mZoomControls = createZoomControls();
            mZoomControls.setVisibility(View.VISIBLE);
            mZoomControlRunnable = new Runnable() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.391 -0400", hash_original_method = "3BD527966F1D73DAF80F6248F2A62FF2", hash_generated_method = "CDA8D015856B01F0F51FF626B5F0D375")
                //DSFIXME:  CODE0002: Requires DSC value to be set
                public void run() {
                    {
                        boolean varE152E1E7C0AEF664B8FEF946B65893CD_1740875282 = (!mZoomControls.hasFocus());
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
        return (ExtendedZoomControls)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.392 -0400", hash_original_method = "3D12A1B47B98985E80612C99D260C6E1", hash_generated_method = "E03605F435AD41D2A37CC41218D3DBE5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private ExtendedZoomControls createZoomControls() {
        ExtendedZoomControls zoomControls;
        zoomControls = new ExtendedZoomControls(mWebView.getContext());
        zoomControls.setOnZoomInClickListener(new OnClickListener() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.392 -0400", hash_original_method = "BFE988BAC78978665C545CEC23B4B60A", hash_generated_method = "9956081FCA8E2A6B9CCA93BF6E6E65A1")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public void onClick(View v) {
                //DSFIXME:  CODE0009: Possible callback target function detected
                dsTaint.addTaint(v.dsTaint);
                mPrivateHandler.removeCallbacks(mZoomControlRunnable);
                mPrivateHandler.postDelayed(mZoomControlRunnable, ZOOM_CONTROLS_TIMEOUT);
                mWebView.zoomIn();
                // ---------- Original Method ----------
                //mPrivateHandler.removeCallbacks(mZoomControlRunnable);
                //mPrivateHandler.postDelayed(mZoomControlRunnable, ZOOM_CONTROLS_TIMEOUT);
                //mWebView.zoomIn();
            }
});
        zoomControls.setOnZoomOutClickListener(new OnClickListener() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.392 -0400", hash_original_method = "0743DD5386D9270B67669A328469CD71", hash_generated_method = "85BF954E434D3D53270152F183D4CAB6")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public void onClick(View v) {
                //DSFIXME:  CODE0009: Possible callback target function detected
                dsTaint.addTaint(v.dsTaint);
                mPrivateHandler.removeCallbacks(mZoomControlRunnable);
                mPrivateHandler.postDelayed(mZoomControlRunnable, ZOOM_CONTROLS_TIMEOUT);
                mWebView.zoomOut();
                // ---------- Original Method ----------
                //mPrivateHandler.removeCallbacks(mZoomControlRunnable);
                //mPrivateHandler.postDelayed(mZoomControlRunnable, ZOOM_CONTROLS_TIMEOUT);
                //mWebView.zoomOut();
            }
});
        return (ExtendedZoomControls)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    private static class ExtendedZoomControls extends FrameLayout {
        private android.widget.ZoomControls mPlusMinusZoomControls;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.393 -0400", hash_original_method = "C8C43A8C9AE036629588704CF81CC911", hash_generated_method = "CF1BFBF5DE487BFA2E0CA81BA508BCC0")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public ExtendedZoomControls(Context context) {
            super(context, null);
            dsTaint.addTaint(context.dsTaint);
            LayoutInflater inflater;
            inflater = (LayoutInflater)
                    context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            inflater.inflate(com.android.internal.R.layout.zoom_magnify, this, true);
            mPlusMinusZoomControls = (android.widget.ZoomControls) findViewById(
                    com.android.internal.R.id.zoomControls);
            findViewById(com.android.internal.R.id.zoomMagnify).setVisibility(
                    View.GONE);
            // ---------- Original Method ----------
            //LayoutInflater inflater = (LayoutInflater)
                    //context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            //inflater.inflate(com.android.internal.R.layout.zoom_magnify, this, true);
            //mPlusMinusZoomControls = (android.widget.ZoomControls) findViewById(
                    //com.android.internal.R.id.zoomControls);
            //findViewById(com.android.internal.R.id.zoomMagnify).setVisibility(
                    //View.GONE);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.393 -0400", hash_original_method = "30ACE5BE88DEDA244C3104B68E509E28", hash_generated_method = "8A3527C4F2A7FC9D3FA846962D5134DF")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void show(boolean showZoom) {
            dsTaint.addTaint(showZoom);
            mPlusMinusZoomControls.setVisibility(showZoom ? View.VISIBLE : View.GONE);
            fade(View.VISIBLE, 0.0f, 1.0f);
            // ---------- Original Method ----------
            //mPlusMinusZoomControls.setVisibility(showZoom ? View.VISIBLE : View.GONE);
            //fade(View.VISIBLE, 0.0f, 1.0f);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.393 -0400", hash_original_method = "E5A5304131EA7BA6BF2FB03B8454E0A2", hash_generated_method = "1763705770489D0C249161FFFC62FF0D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void hide() {
            fade(View.GONE, 1.0f, 0.0f);
            // ---------- Original Method ----------
            //fade(View.GONE, 1.0f, 0.0f);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.393 -0400", hash_original_method = "9BED0A47A1FCF93930F77C8CDDC09D0D", hash_generated_method = "1EF211ADC65E80CD053CBF3AE74DDA44")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void fade(int visibility, float startAlpha, float endAlpha) {
            dsTaint.addTaint(startAlpha);
            dsTaint.addTaint(visibility);
            dsTaint.addTaint(endAlpha);
            AlphaAnimation anim;
            anim = new AlphaAnimation(startAlpha, endAlpha);
            anim.setDuration(500);
            startAnimation(anim);
            setVisibility(visibility);
            // ---------- Original Method ----------
            //AlphaAnimation anim = new AlphaAnimation(startAlpha, endAlpha);
            //anim.setDuration(500);
            //startAnimation(anim);
            //setVisibility(visibility);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.393 -0400", hash_original_method = "686B76CDD5825DB5445B0AA599284809", hash_generated_method = "A878FD096DE27C0ACE6A1A8A92157BF8")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean hasFocus() {
            boolean var51CC819E273B58FA5AA2310FF2130EA9_6831155 = (mPlusMinusZoomControls.hasFocus());
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return mPlusMinusZoomControls.hasFocus();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.393 -0400", hash_original_method = "BA80E2ADFBC1D35C24B9AA9216D670A5", hash_generated_method = "A96EC348F7E24D7C537D67A9D8C37D97")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void setOnZoomInClickListener(OnClickListener listener) {
            dsTaint.addTaint(listener.dsTaint);
            mPlusMinusZoomControls.setOnZoomInClickListener(listener);
            // ---------- Original Method ----------
            //mPlusMinusZoomControls.setOnZoomInClickListener(listener);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.394 -0400", hash_original_method = "E61ACB01329E1401C1A0699266CEDE01", hash_generated_method = "94D5C253FA867EC7E499115D68CE7492")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void setOnZoomOutClickListener(OnClickListener listener) {
            dsTaint.addTaint(listener.dsTaint);
            mPlusMinusZoomControls.setOnZoomOutClickListener(listener);
            // ---------- Original Method ----------
            //mPlusMinusZoomControls.setOnZoomOutClickListener(listener);
        }

        
    }


    
    private static final long ZOOM_CONTROLS_TIMEOUT =
            ViewConfiguration.getZoomControlsTimeout();
}

