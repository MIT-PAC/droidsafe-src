package android.webkit;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;

class ZoomControlExternal implements ZoomControlBase {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:02.453 -0400", hash_original_field = "328324C4FD660040B497FF681C21CB4D", hash_generated_field = "2F37B0CB5883AB138CD26F172FE3C9FB")

    private ExtendedZoomControls mZoomControls;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:02.453 -0400", hash_original_field = "836B10DC5103C470D1A7AAC5A19392BE", hash_generated_field = "85E4E26922E29D7084F4C79BB9E29374")

    private Runnable mZoomControlRunnable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:02.453 -0400", hash_original_field = "5F29F5836F7CBF9A7037E015151A7B79", hash_generated_field = "DB9655D350EF0F7F7F47B82F02BFFFB5")

    private final Handler mPrivateHandler = new Handler();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:02.453 -0400", hash_original_field = "72439B8F99EB438C3DA5D9CD798C6786", hash_generated_field = "99346B50377E115231263981E00655CA")

    private WebView mWebView;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:02.453 -0400", hash_original_method = "703B91782EEFAD1D42516E3C0CEC522E", hash_generated_method = "D555F9AE790609D762783FBBEA058A92")
    public  ZoomControlExternal(WebView webView) {
        mWebView = webView;
        // ---------- Original Method ----------
        //mWebView = webView;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:02.454 -0400", hash_original_method = "9D13A62EAC4908646E1616576C006DF1", hash_generated_method = "491EEBDC9DC87D6A0891139054DB4E8E")
    public void show() {
    if(mZoomControlRunnable != null)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:02.454 -0400", hash_original_method = "F9CBCC4DD32543F3FB45C3890BD1BDBE", hash_generated_method = "DF51627C05CC004DB6AB45E2BB87C837")
    public void hide() {
    if(mZoomControlRunnable != null)        
        {
            mPrivateHandler.removeCallbacks(mZoomControlRunnable);
        } //End block
    if(mZoomControls != null)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:02.454 -0400", hash_original_method = "A600F87081FF5BCBF1AA139788799BF8", hash_generated_method = "CF6BF38E0B2F7BD92BC5862279810354")
    public boolean isVisible() {
        boolean varEAF73EA866E63D08864C5A42586A17C2_491325567 = (mZoomControls != null && mZoomControls.isShown());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1416507178 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1416507178;
        // ---------- Original Method ----------
        //return mZoomControls != null && mZoomControls.isShown();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:02.455 -0400", hash_original_method = "DB08A4E4B606EDAC2519981C47E0CF53", hash_generated_method = "FB43C517C4395D2CF5B50D0CBB01D588")
    public void update() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:02.456 -0400", hash_original_method = "66298D37AA43B5FB63161B411BC0C63C", hash_generated_method = "76DFE00FD8B558ACF30946981BFB5722")
    public ExtendedZoomControls getControls() {
    if(mZoomControls == null)        
        {
            mZoomControls = createZoomControls();
            mZoomControls.setVisibility(View.VISIBLE);
            mZoomControlRunnable = new Runnable() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:02.455 -0400", hash_original_method = "3BD527966F1D73DAF80F6248F2A62FF2", hash_generated_method = "5F5A037E9AD14D3F8F33AA7344058BA8")
        public void run() {
    if(!mZoomControls.hasFocus())            
            {
                mZoomControls.hide();
            } //End block
            else
            {
                mPrivateHandler.removeCallbacks(mZoomControlRunnable);
                mPrivateHandler.postDelayed(mZoomControlRunnable,
                                ZOOM_CONTROLS_TIMEOUT);
            } //End block
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
ExtendedZoomControls var81227494FA945C379941C3696371DB2A_1825216330 =         mZoomControls;
        var81227494FA945C379941C3696371DB2A_1825216330.addTaint(taint);
        return var81227494FA945C379941C3696371DB2A_1825216330;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:02.458 -0400", hash_original_method = "3D12A1B47B98985E80612C99D260C6E1", hash_generated_method = "944D9F3D397B2276A3B5F2B7BD8C9302")
    private ExtendedZoomControls createZoomControls() {
        ExtendedZoomControls zoomControls = new ExtendedZoomControls(mWebView.getContext());
        zoomControls.setOnZoomInClickListener(new OnClickListener() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:02.457 -0400", hash_original_method = "BFE988BAC78978665C545CEC23B4B60A", hash_generated_method = "5544F6C434117676D6F1E63A7E1BCF42")
        public void onClick(View v) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(v.getTaint());
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
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:02.458 -0400", hash_original_method = "0743DD5386D9270B67669A328469CD71", hash_generated_method = "E2A9A6E3F40E156FEE1A525CC60FBA0E")
        public void onClick(View v) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(v.getTaint());
            mPrivateHandler.removeCallbacks(mZoomControlRunnable);
            mPrivateHandler.postDelayed(mZoomControlRunnable, ZOOM_CONTROLS_TIMEOUT);
            mWebView.zoomOut();
            // ---------- Original Method ----------
            //mPrivateHandler.removeCallbacks(mZoomControlRunnable);
            //mPrivateHandler.postDelayed(mZoomControlRunnable, ZOOM_CONTROLS_TIMEOUT);
            //mWebView.zoomOut();
        }
});
ExtendedZoomControls var15711BF4EB3B131E4CFE980AA922F862_1061593747 =         zoomControls;
        var15711BF4EB3B131E4CFE980AA922F862_1061593747.addTaint(taint);
        return var15711BF4EB3B131E4CFE980AA922F862_1061593747;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    private static class ExtendedZoomControls extends FrameLayout {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:02.458 -0400", hash_original_field = "BB391A911A0C96B2F806CA7403F67BD3", hash_generated_field = "ED36E8FC67260592E9DD391B877393D2")

        private android.widget.ZoomControls mPlusMinusZoomControls;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:02.459 -0400", hash_original_method = "C8C43A8C9AE036629588704CF81CC911", hash_generated_method = "D253D1E26ADAFB7E34B1A3FA4B0B2474")
        public  ExtendedZoomControls(Context context) {
            super(context, null);
            addTaint(context.getTaint());
            LayoutInflater inflater = (LayoutInflater)
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:02.459 -0400", hash_original_method = "30ACE5BE88DEDA244C3104B68E509E28", hash_generated_method = "0B33913D3027AA5B07DDAEB31514ACA5")
        public void show(boolean showZoom) {
            addTaint(showZoom);
            mPlusMinusZoomControls.setVisibility(showZoom ? View.VISIBLE : View.GONE);
            fade(View.VISIBLE, 0.0f, 1.0f);
            // ---------- Original Method ----------
            //mPlusMinusZoomControls.setVisibility(showZoom ? View.VISIBLE : View.GONE);
            //fade(View.VISIBLE, 0.0f, 1.0f);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:02.459 -0400", hash_original_method = "E5A5304131EA7BA6BF2FB03B8454E0A2", hash_generated_method = "1763705770489D0C249161FFFC62FF0D")
        public void hide() {
            fade(View.GONE, 1.0f, 0.0f);
            // ---------- Original Method ----------
            //fade(View.GONE, 1.0f, 0.0f);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:02.460 -0400", hash_original_method = "9BED0A47A1FCF93930F77C8CDDC09D0D", hash_generated_method = "1E5CB067E3CEB98E43F612AE3706CF55")
        private void fade(int visibility, float startAlpha, float endAlpha) {
            addTaint(endAlpha);
            addTaint(startAlpha);
            addTaint(visibility);
            AlphaAnimation anim = new AlphaAnimation(startAlpha, endAlpha);
            anim.setDuration(500);
            startAnimation(anim);
            setVisibility(visibility);
            // ---------- Original Method ----------
            //AlphaAnimation anim = new AlphaAnimation(startAlpha, endAlpha);
            //anim.setDuration(500);
            //startAnimation(anim);
            //setVisibility(visibility);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:02.460 -0400", hash_original_method = "686B76CDD5825DB5445B0AA599284809", hash_generated_method = "591D0F956BDB33BA13263C4DC1C05B01")
        public boolean hasFocus() {
            boolean varE89B3807F85677B1CDB6B89D1A414C86_2132268595 = (mPlusMinusZoomControls.hasFocus());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_997504012 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_997504012;
            // ---------- Original Method ----------
            //return mPlusMinusZoomControls.hasFocus();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:02.460 -0400", hash_original_method = "BA80E2ADFBC1D35C24B9AA9216D670A5", hash_generated_method = "1854C645B6E56BECA6F3D400BD117CDD")
        public void setOnZoomInClickListener(OnClickListener listener) {
            addTaint(listener.getTaint());
            mPlusMinusZoomControls.setOnZoomInClickListener(listener);
            // ---------- Original Method ----------
            //mPlusMinusZoomControls.setOnZoomInClickListener(listener);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:02.461 -0400", hash_original_method = "E61ACB01329E1401C1A0699266CEDE01", hash_generated_method = "843C7E9462607F5092F1B6944A201D3F")
        public void setOnZoomOutClickListener(OnClickListener listener) {
            addTaint(listener.getTaint());
            mPlusMinusZoomControls.setOnZoomOutClickListener(listener);
            // ---------- Original Method ----------
            //mPlusMinusZoomControls.setOnZoomOutClickListener(listener);
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:02.461 -0400", hash_original_field = "2CE75D468D8046AE73E9F30DDA665B3C", hash_generated_field = "4E2B5D96681EAE0558B94E904BDAC5D9")

    private static final long ZOOM_CONTROLS_TIMEOUT = ViewConfiguration.getZoomControlsTimeout();
}

