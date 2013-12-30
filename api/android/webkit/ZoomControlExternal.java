package android.webkit;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;





class ZoomControlExternal implements ZoomControlBase {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:46.297 -0500", hash_original_field = "AEDAEBF925ADC218E8CB884C12FDE1B4", hash_generated_field = "4E2B5D96681EAE0558B94E904BDAC5D9")

    private static final long ZOOM_CONTROLS_TIMEOUT =
            ViewConfiguration.getZoomControlsTimeout();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:46.299 -0500", hash_original_field = "35A1FCF89742ECEF5DA1636029AD5648", hash_generated_field = "2F37B0CB5883AB138CD26F172FE3C9FB")

    private ExtendedZoomControls mZoomControls;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:46.301 -0500", hash_original_field = "369DBCA660F27ED7DDEC3B423EC04B86", hash_generated_field = "85E4E26922E29D7084F4C79BB9E29374")

    private Runnable mZoomControlRunnable;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:46.303 -0500", hash_original_field = "474BE2A38D2899FD38D2D5C1F2EB5A5A", hash_generated_field = "DB9655D350EF0F7F7F47B82F02BFFFB5")

    private final Handler mPrivateHandler = new Handler();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:46.305 -0500", hash_original_field = "E044D69EE05B24F4B93E3A3B208F5343", hash_generated_field = "99346B50377E115231263981E00655CA")


    private  WebView mWebView;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:46.308 -0500", hash_original_method = "703B91782EEFAD1D42516E3C0CEC522E", hash_generated_method = "E221C724C2F1C273BD0B8536F0598CFF")
    
public ZoomControlExternal(WebView webView) {
        mWebView = webView;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:46.310 -0500", hash_original_method = "9D13A62EAC4908646E1616576C006DF1", hash_generated_method = "1922B18231F90E3E1B738E4C1D60B020")
    
public void show() {
        if(mZoomControlRunnable != null) {
            mPrivateHandler.removeCallbacks(mZoomControlRunnable);
        }
        getControls().show(true);
        mPrivateHandler.postDelayed(mZoomControlRunnable, ZOOM_CONTROLS_TIMEOUT);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:46.313 -0500", hash_original_method = "F9CBCC4DD32543F3FB45C3890BD1BDBE", hash_generated_method = "A0504F3A375C919DCE2D8F43040EFED1")
    
public void hide() {
        if (mZoomControlRunnable != null) {
            mPrivateHandler.removeCallbacks(mZoomControlRunnable);
        }
        if (mZoomControls != null) {
            mZoomControls.hide();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:46.315 -0500", hash_original_method = "A600F87081FF5BCBF1AA139788799BF8", hash_generated_method = "F58C67E4B96F7C8B4216A0447BC51756")
    
public boolean isVisible() {
        return mZoomControls != null && mZoomControls.isShown();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:46.317 -0500", hash_original_method = "DB08A4E4B606EDAC2519981C47E0CF53", hash_generated_method = "A583B619FC50D6710091B23398A8B553")
    
public void update() { }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:46.323 -0500", hash_original_method = "66298D37AA43B5FB63161B411BC0C63C", hash_generated_method = "F4AB22467694F84E3BE1D2C185B46FA9")
    
public ExtendedZoomControls getControls() {
        if (mZoomControls == null) {
            mZoomControls = createZoomControls();

            /*
             * need to be set to VISIBLE first so that getMeasuredHeight() in
             * {@link #onSizeChanged()} can return the measured value for proper
             * layout.
             */
            mZoomControls.setVisibility(View.VISIBLE);
            mZoomControlRunnable = new Runnable() {
                public void run() {
                    /* Don't dismiss the controls if the user has
                     * focus on them. Wait and check again later.
                     */
                    if (!mZoomControls.hasFocus()) {
                        mZoomControls.hide();
                    } else {
                        mPrivateHandler.removeCallbacks(mZoomControlRunnable);
                        mPrivateHandler.postDelayed(mZoomControlRunnable,
                                ZOOM_CONTROLS_TIMEOUT);
                    }
                }
            };
        }
        return mZoomControls;
    }

    
    private static class ExtendedZoomControls extends FrameLayout {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:46.334 -0500", hash_original_field = "AE6319379138C6582D5D75BCD3D59137", hash_generated_field = "ED36E8FC67260592E9DD391B877393D2")


        private android.widget.ZoomControls mPlusMinusZoomControls;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:46.337 -0500", hash_original_method = "C8C43A8C9AE036629588704CF81CC911", hash_generated_method = "2C8C1692A6408D4C6D42DB80627BA9FF")
        
public ExtendedZoomControls(Context context) {
            super(context, null);
            LayoutInflater inflater = (LayoutInflater)
                    context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            inflater.inflate(com.android.internal.R.layout.zoom_magnify, this, true);
            mPlusMinusZoomControls = (android.widget.ZoomControls) findViewById(
                    com.android.internal.R.id.zoomControls);
            findViewById(com.android.internal.R.id.zoomMagnify).setVisibility(
                    View.GONE);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:46.339 -0500", hash_original_method = "30ACE5BE88DEDA244C3104B68E509E28", hash_generated_method = "3FC9DC9058B7CF163F6C5C2BD2F9A5E1")
        
public void show(boolean showZoom) {
            mPlusMinusZoomControls.setVisibility(showZoom ? View.VISIBLE : View.GONE);
            fade(View.VISIBLE, 0.0f, 1.0f);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:46.342 -0500", hash_original_method = "E5A5304131EA7BA6BF2FB03B8454E0A2", hash_generated_method = "16FA1262CF10C46FD07E860BAAC2C55F")
        
public void hide() {
            fade(View.GONE, 1.0f, 0.0f);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:46.344 -0500", hash_original_method = "9BED0A47A1FCF93930F77C8CDDC09D0D", hash_generated_method = "5E0237000E83E41CCCE02FCD67078FC1")
        
private void fade(int visibility, float startAlpha, float endAlpha) {
            AlphaAnimation anim = new AlphaAnimation(startAlpha, endAlpha);
            anim.setDuration(500);
            startAnimation(anim);
            setVisibility(visibility);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:46.346 -0500", hash_original_method = "686B76CDD5825DB5445B0AA599284809", hash_generated_method = "5B65549ACDC8DC878C4C088798043BC2")
        
public boolean hasFocus() {
            return mPlusMinusZoomControls.hasFocus();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:46.348 -0500", hash_original_method = "BA80E2ADFBC1D35C24B9AA9216D670A5", hash_generated_method = "76162764A188F60AD776F8FAA5BEC737")
        
public void setOnZoomInClickListener(OnClickListener listener) {
            mPlusMinusZoomControls.setOnZoomInClickListener(listener);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:46.350 -0500", hash_original_method = "E61ACB01329E1401C1A0699266CEDE01", hash_generated_method = "4D2A0F73E4AF1D40B744CBF53CB0C5EE")
        
public void setOnZoomOutClickListener(OnClickListener listener) {
            mPlusMinusZoomControls.setOnZoomOutClickListener(listener);
        }

        
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:46.331 -0500", hash_original_method = "3D12A1B47B98985E80612C99D260C6E1", hash_generated_method = "BAED971634581C8BEF9139824C5F43C9")
    
private ExtendedZoomControls createZoomControls() {
        ExtendedZoomControls zoomControls = new ExtendedZoomControls(mWebView.getContext());
        zoomControls.setOnZoomInClickListener(new OnClickListener() {
            public void onClick(View v) {
                // reset time out
                mPrivateHandler.removeCallbacks(mZoomControlRunnable);
                mPrivateHandler.postDelayed(mZoomControlRunnable, ZOOM_CONTROLS_TIMEOUT);
                mWebView.zoomIn();
            }
        });
        zoomControls.setOnZoomOutClickListener(new OnClickListener() {
            public void onClick(View v) {
                // reset time out
                mPrivateHandler.removeCallbacks(mZoomControlRunnable);
                mPrivateHandler.postDelayed(mZoomControlRunnable, ZOOM_CONTROLS_TIMEOUT);
                mWebView.zoomOut();
            }
        });
        return zoomControls;
    }
}

