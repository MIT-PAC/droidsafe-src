package android.widget;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Handler;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.AbsListView.OnScrollListener;
import com.android.internal.R;

class FastScroller {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:11.918 -0500", hash_original_field = "283C69E5625D62D4702AD3B6908CCAF0", hash_generated_field = "56BFBE7F5C9D2F1EB4223BBBC231AA8C")

    private static final String TAG = "FastScroller";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:11.920 -0500", hash_original_field = "1073FAFD1A0CD60A3C950346E3FD3FB4", hash_generated_field = "2194CAD343A1944040469192DE6A0DCB")

    private static int MIN_PAGES = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:11.922 -0500", hash_original_field = "6B6D8B77C246C40D96CFA2ACC270A264", hash_generated_field = "19AD2C4D8B184CF34E7683F6281F4246")

    private static final int STATE_NONE = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:11.924 -0500", hash_original_field = "BA8124C2B9BA959991F0D07D14D4BC56", hash_generated_field = "752D525745E25E771418EB8BADF10009")

    private static final int STATE_ENTER = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:11.926 -0500", hash_original_field = "91C1A88F82F1C84059CD5E52C4D2526E", hash_generated_field = "11251698B408CDCABC32B511FF2CDCE2")

    private static final int STATE_VISIBLE = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:11.928 -0500", hash_original_field = "733C01FDAFAD8708C9F8EB9750790169", hash_generated_field = "C4B39784B1BF345438DBE74EBBCBB5E4")

    private static final int STATE_DRAGGING = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:11.931 -0500", hash_original_field = "DD9B418CFD1A274DBC5339D613E339C9", hash_generated_field = "4C8E31D34462D34A8DE02D78A3751D69")

    private static final int STATE_EXIT = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:11.933 -0500", hash_original_field = "1C7D51957586CA7CCA3D9248F72A9E66", hash_generated_field = "A4ED50417A9DBB08E9A7851FFF0DB179")

    private static final int[] PRESSED_STATES = new int[] {
        android.R.attr.state_pressed
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:11.936 -0500", hash_original_field = "0D3EDC5BC5356A0BED3AE2230AED5AE0", hash_generated_field = "1EE9C5A9B487C2093F1C1687A659D84D")

    private static final int[] DEFAULT_STATES = new int[0];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.698 -0400", hash_original_field = "72C442925745EFC5792F94523ABD1AB2", hash_generated_field = "84AAA12BA67F0A875D601387F39B9663")

    private static final int[] ATTRS = new int[] {
        R.attr.fastScrollTextColor,
        R.attr.fastScrollThumbDrawable,
        R.attr.fastScrollTrackDrawable,
        R.attr.fastScrollPreviewBackgroundLeft,
        R.attr.fastScrollPreviewBackgroundRight,
        R.attr.fastScrollOverlayPosition
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:11.940 -0500", hash_original_field = "8BA834CA86EB36F1A1C6110B0F27E3C7", hash_generated_field = "1FA0034D769E8804C911CA57C3894230")

    private static final int TEXT_COLOR = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:11.943 -0500", hash_original_field = "F796370E1CCCC596EF25D9C69154533B", hash_generated_field = "0239F9DADAC23BDBF7DAE9F4242945FC")

    private static final int THUMB_DRAWABLE = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:11.945 -0500", hash_original_field = "05715C284D9629AD13642671ED6FD5F4", hash_generated_field = "1BB3900B2A090E5FC1DFA188E16771D0")

    private static final int TRACK_DRAWABLE = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:11.947 -0500", hash_original_field = "55047C2B2B004B4B3B6598EBA0F7C280", hash_generated_field = "9BB6FFDAA693C68CBFE732BAD3AF248F")

    private static final int PREVIEW_BACKGROUND_LEFT = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:11.950 -0500", hash_original_field = "B6808EBEA0883C45D200204BB90EB81A", hash_generated_field = "20110F77E24ED7F2FA7ACAABEB159699")

    private static final int PREVIEW_BACKGROUND_RIGHT = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:11.952 -0500", hash_original_field = "7EEF187C714B10A2BF3EB499F6CFABC6", hash_generated_field = "04EE06B0140567237206BB05A55B6D82")

    private static final int OVERLAY_POSITION = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:11.955 -0500", hash_original_field = "EF4DC379A0810B76C20FA2B01FF8682E", hash_generated_field = "C7D64E758B6AB043EBEA3866A6D65988")

    private static final int OVERLAY_FLOATING = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:11.957 -0500", hash_original_field = "2BE942ECD39CE5C4B85A0478A7F7F68B", hash_generated_field = "C800788580620028E6672AF4A08A7118")

    private static final int OVERLAY_AT_THUMB = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:12.028 -0500", hash_original_field = "D59FB70289344DCBCB67FDCD42D89461", hash_generated_field = "34BA387044B3D0FAAB4EEB4796FFF3A1")

    private static final int FADE_TIMEOUT = 1500;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:12.030 -0500", hash_original_field = "84FB55330EA5C3AA3AA0B9D76D7EB267", hash_generated_field = "CF9EC8D9C1271C568A979F597BD18D32")

    private static final int PENDING_DRAG_DELAY = 180;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:11.959 -0500", hash_original_field = "CC35B65C4DF6EB37FFE598AD0E85776D", hash_generated_field = "723113CD58F6B081A7D304DE131200C0")
    
    private Drawable mThumbDrawable;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:11.962 -0500", hash_original_field = "EEF6172953B5FC6CF90C795CAE614F4E", hash_generated_field = "C4F6607BE177BD0C551FFF72CB52709D")

    private Drawable mOverlayDrawable;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:11.964 -0500", hash_original_field = "A90D7BED756182929175B8B430BA5712", hash_generated_field = "95BC711301E78A9ECDB61E242B32BBFC")

    private Drawable mTrackDrawable;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:11.966 -0500", hash_original_field = "23AEA43425EC366B0F0D979C5580BBB5", hash_generated_field = "3F431D8A9EEFA832E40733D030288C4E")

    private Drawable mOverlayDrawableLeft;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:11.967 -0500", hash_original_field = "7C92A688DB96482E993517EEAAA9DF82", hash_generated_field = "CBEF23D76FD5E642BD307BDCC6E254DC")

    private Drawable mOverlayDrawableRight;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:11.969 -0500", hash_original_field = "3D6BD301AD11E22B2417B343C44F938F", hash_generated_field = "3D6BD301AD11E22B2417B343C44F938F")

    int mThumbH;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:11.971 -0500", hash_original_field = "DCE6651DC2A97578BDBD4F73CA2A9123", hash_generated_field = "DCE6651DC2A97578BDBD4F73CA2A9123")

    int mThumbW;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:11.973 -0500", hash_original_field = "3E4FAF8454C2C912B7626021FE9AF353", hash_generated_field = "3E4FAF8454C2C912B7626021FE9AF353")

    int mThumbY;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:11.975 -0500", hash_original_field = "338C99E0D8E2EB4EC7257FC4ABC99760", hash_generated_field = "652CA9CCF5547E5517E87FEB493C682F")

    private RectF mOverlayPos;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:11.978 -0500", hash_original_field = "10075C47A0F7954AF394A0C06D3D4027", hash_generated_field = "CF4608DD9AF6C21FCFF4CAB07660E9AC")

    private int mOverlaySize;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:11.979 -0500", hash_original_field = "8DE3CD4C54B5C114BFFFAF8D6B3834ED", hash_generated_field = "8DE3CD4C54B5C114BFFFAF8D6B3834ED")

    AbsListView mList;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:11.981 -0500", hash_original_field = "F80BE66A40916AFE64128A97287351B5", hash_generated_field = "F80BE66A40916AFE64128A97287351B5")

    boolean mScrollCompleted;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:11.983 -0500", hash_original_field = "6EADEFAF18EF437A4704518083B600EA", hash_generated_field = "2B767EF4AB0ACDA9AD9957D0EE99C88B")

    private int mVisibleItem;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:11.985 -0500", hash_original_field = "0344A2D91EF1BCE652EE63EFC12EEAC9", hash_generated_field = "75BCEEBE83B26919B33E8EA8B289919E")

    private Paint mPaint;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:11.987 -0500", hash_original_field = "2351405ACFAACAAF716E0748C296C695", hash_generated_field = "74A1AC6BAAFB1602514EDA87DF3F165A")

    private int mListOffset;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:11.989 -0500", hash_original_field = "9D9421561982F63949A88E10D1784157", hash_generated_field = "7633D41B58955728937D8CC0DB2694BE")

    private int mItemCount = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:11.992 -0500", hash_original_field = "59CCE455416FB406276ED8D274E8BD7D", hash_generated_field = "74C6663E6FE3B64B12C20186C73689BE")

    private boolean mLongList;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:11.994 -0500", hash_original_field = "F589CA49F5F0FBB7B2AAA1D167B09C77", hash_generated_field = "E10BB9F3460B91FF78086EFA996A0114")
    
    private Object [] mSections;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:11.996 -0500", hash_original_field = "5DA5B72F319798902FC1F3C890FC3BB4", hash_generated_field = "8F91F071959F5E46C9D858D712A42531")

    private String mSectionText;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:11.999 -0500", hash_original_field = "8907C40B7F5C383340A93F9395FCBBD3", hash_generated_field = "66337501372B93428A3E0DCFBCAA8A4D")

    private boolean mDrawOverlay;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:12.001 -0500", hash_original_field = "5847F0D8CF817E89E31CC24C7CBA32B3", hash_generated_field = "C5CC7DBEDDDE3933C75D287B3954EC80")

    private ScrollFade mScrollFade;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:12.003 -0500", hash_original_field = "7BB479D2050B776CF48FB8B4E674911B", hash_generated_field = "19B55F2750B971E6310D64ADB9B2D0CF")
    
    private int mState;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:12.005 -0500", hash_original_field = "AD9C3D1E48D73BF1547D53C4C62401B2", hash_generated_field = "2E60E17486AAEB1A4E1F1878A0354061")
    
    private Handler mHandler = new Handler();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:12.007 -0500", hash_original_field = "33273F8B8EE0B442CE373E963CE812B8", hash_generated_field = "33273F8B8EE0B442CE373E963CE812B8")
    
    BaseAdapter mListAdapter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:12.009 -0500", hash_original_field = "2969AFB82210EC5F5E924DDA5639C435", hash_generated_field = "993A155558E830738166022FC5D1A65D")

    private SectionIndexer mSectionIndexer;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:12.011 -0500", hash_original_field = "4679CAE2B24A3D5F4A4C8AB361D657E0", hash_generated_field = "54BB6C7E624546A679D88F2CE6A36CC3")

    private boolean mChangedBounds;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:12.013 -0500", hash_original_field = "4EE731A4D843C99A130C2ED24E5FDDEA", hash_generated_field = "D614AE7D1AAE0276EA05A974DCBF0210")
    
    private int mPosition;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:12.015 -0500", hash_original_field = "33619D55BE69E2B8A733B3607B6451AA", hash_generated_field = "1013EB9EDD9A15A8ED84F490CA1C5ACA")

    private boolean mAlwaysShow;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:12.017 -0500", hash_original_field = "CD5C76EAA91CF34AEB137BEA7A5E4085", hash_generated_field = "818199C64E5FB571F9E3F2622DF96D7E")

    private int mOverlayPosition;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:12.019 -0500", hash_original_field = "14E789E41B34F824F9C54CE1DDCE3E13", hash_generated_field = "6A99D75E2A8444FF7C66E9499447E446")

    private boolean mMatchDragPosition;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:12.021 -0500", hash_original_field = "A2E2E464E467FCA571530A8485FFA938", hash_generated_field = "A2E2E464E467FCA571530A8485FFA938")

    float mInitialTouchY;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:12.023 -0500", hash_original_field = "A31D9AE99DECC41BA4A47D3E5C2BD2CA", hash_generated_field = "A31D9AE99DECC41BA4A47D3E5C2BD2CA")

    boolean mPendingDrag;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:12.025 -0500", hash_original_field = "BDDA105C43BD9D84A4C5E84D10C957AD", hash_generated_field = "A6018E4F8C21D3EE961380A6D74CC7E0")

    private int mScaledTouchSlop;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:12.032 -0500", hash_original_field = "C53D3ED3F7CBB30122A6D714A9203A7D", hash_generated_field = "570061BA9CB059462550E9BCCD2A0735")

    private final Rect mTmpRect = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.853 -0400", hash_original_field = "FDE3D253B193C180C3BB694BFE237899", hash_generated_field = "29B709708C4F13168EDC66CB4D662E67")

    private final Runnable mDeferStartDrag = new Runnable() {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.853 -0400", hash_original_method = "8A3021930710B16F81DE57976EDC3D0F", hash_generated_method = "121B411EE501440C0B88B56E21D1E2FA")
        public void run() {
            {
                beginDrag();
                final int viewHeight = mList.getHeight();
                int newThumbY = (int) mInitialTouchY - mThumbH + 10;
                {
                    newThumbY = 0;
                } 
                {
                    newThumbY = viewHeight - mThumbH;
                } 
                mThumbY = newThumbY;
                scrollTo((float) mThumbY / (viewHeight - mThumbH));
            } 
            mPendingDrag = false;
            
        }
        
};

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:12.040 -0500", hash_original_method = "A2A2A1F0C9639ECE9FE84AFC4D4D3A80", hash_generated_method = "35395BFD9AB88FB58107F86BEE7454D4")
    
public FastScroller(Context context, AbsListView listView) {
        mList = listView;
        init(context);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:12.042 -0500", hash_original_method = "39D93CA5552A2245B487796C83EA3A2C", hash_generated_method = "CF6CA7B4DF8857CDB1F733C67264E2BD")
    
public void setAlwaysShow(boolean alwaysShow) {
        mAlwaysShow = alwaysShow;
        if (alwaysShow) {
            mHandler.removeCallbacks(mScrollFade);
            setState(STATE_VISIBLE);
        } else if (mState == STATE_VISIBLE) {
            mHandler.postDelayed(mScrollFade, FADE_TIMEOUT);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:12.045 -0500", hash_original_method = "FE4F6BFF00D7A9534103DEC6DDA5B37C", hash_generated_method = "AF9A64118B175C9042B1F57118CD6EB6")
    
public boolean isAlwaysShowEnabled() {
        return mAlwaysShow;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:12.047 -0500", hash_original_method = "8A07D5E4DE8CD170DC3BFC9FE8A30504", hash_generated_method = "86F3FB9B203764A997DC05618B0F0611")
    
private void refreshDrawableState() {
        int[] state = mState == STATE_DRAGGING ? PRESSED_STATES : DEFAULT_STATES;

        if (mThumbDrawable != null && mThumbDrawable.isStateful()) {
            mThumbDrawable.setState(state);
        }
        if (mTrackDrawable != null && mTrackDrawable.isStateful()) {
            mTrackDrawable.setState(state);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:12.049 -0500", hash_original_method = "4A2BCFB2C4534D1665C92142AF186787", hash_generated_method = "2E2A17621ACF48774ED0EC230F3D443F")
    
public void setScrollbarPosition(int position) {
        mPosition = position;
        switch (position) {
            default:
            case View.SCROLLBAR_POSITION_DEFAULT:
            case View.SCROLLBAR_POSITION_RIGHT:
                mOverlayDrawable = mOverlayDrawableRight;
                break;
            case View.SCROLLBAR_POSITION_LEFT:
                mOverlayDrawable = mOverlayDrawableLeft;
                break;
        }
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:12.052 -0500", hash_original_method = "B47561E95C2F1E64B16085B75AB60280", hash_generated_method = "A5BE265953E237C34F68583E708A4BB3")
    
public int getWidth() {
        return mThumbW;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:12.054 -0500", hash_original_method = "FD0548A7869DD54F34FB4A98FCCC10E9", hash_generated_method = "EA2EAA513282582F0631B9656D846438")
    
public void setState(int state) {
        switch (state) {
            case STATE_NONE:
                mHandler.removeCallbacks(mScrollFade);
                mList.invalidate();
                break;
            case STATE_VISIBLE:
                if (mState != STATE_VISIBLE) { // Optimization
                    resetThumbPos();
                }
                // Fall through
            case STATE_DRAGGING:
                mHandler.removeCallbacks(mScrollFade);
                break;
            case STATE_EXIT:
                int viewWidth = mList.getWidth();
                mList.invalidate(viewWidth - mThumbW, mThumbY, viewWidth, mThumbY + mThumbH);
                break;
        }
        mState = state;
        refreshDrawableState();
    }
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:12.056 -0500", hash_original_method = "10E9373648D5DF4EE43B4904732E3886", hash_generated_method = "4C50D1866B5E804CF0B05EFBD6788B97")
    
public int getState() {
        return mState;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:12.058 -0500", hash_original_method = "C32E62B08B27A384339E1BC75CFE4552", hash_generated_method = "FEE3E182E4322D9F83A5474043DFECFC")
    
private void resetThumbPos() {
        final int viewWidth = mList.getWidth();
        // Bounds are always top right. Y coordinate get's translated during draw
        switch (mPosition) {
            case View.SCROLLBAR_POSITION_DEFAULT:
            case View.SCROLLBAR_POSITION_RIGHT:
                mThumbDrawable.setBounds(viewWidth - mThumbW, 0, viewWidth, mThumbH);
                break;
            case View.SCROLLBAR_POSITION_LEFT:
                mThumbDrawable.setBounds(0, 0, mThumbW, mThumbH);
                break;
        }
        mThumbDrawable.setAlpha(ScrollFade.ALPHA_MAX);
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:12.061 -0500", hash_original_method = "5C6D13F417D5AA8E0A1553C57F0CD3F0", hash_generated_method = "2A2127D26D1FB446FB15A5E389EE4E1B")
    
private void useThumbDrawable(Context context, Drawable drawable) {
        mThumbDrawable = drawable;
        if (drawable instanceof NinePatchDrawable) {
            mThumbW = context.getResources().getDimensionPixelSize(
                    com.android.internal.R.dimen.fastscroll_thumb_width);
            mThumbH = context.getResources().getDimensionPixelSize(
                    com.android.internal.R.dimen.fastscroll_thumb_height);
        } else {
            mThumbW = drawable.getIntrinsicWidth();
            mThumbH = drawable.getIntrinsicHeight();
        }
        mChangedBounds = true;
    }
    
    public class ScrollFade implements Runnable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:12.120 -0500", hash_original_field = "DFBD50F7D67BF1C8D0922836E7A670AC", hash_generated_field = "A7C45DFCF276811667648B1C1A572838")

        static final int ALPHA_MAX = 208;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:12.122 -0500", hash_original_field = "17FB70CA8E1DB955CC212BC53C3C7025", hash_generated_field = "EC8292497A345AD1DC32FC40B26ED215")

        static final long FADE_DURATION = 200;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:12.115 -0500", hash_original_field = "3C3A30DDD94D9D47CBB52C3848791CE7", hash_generated_field = "3C3A30DDD94D9D47CBB52C3848791CE7")
        
        long mStartTime;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:12.117 -0500", hash_original_field = "307FFDDA4C0E2DF961BB56499DC85520", hash_generated_field = "307FFDDA4C0E2DF961BB56499DC85520")

        long mFadeDuration;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.696 -0400", hash_original_method = "5D305A44C44DBEE04C6A110139796128", hash_generated_method = "5D305A44C44DBEE04C6A110139796128")
        public ScrollFade ()
        {
            //Synthesized constructor
        }
        
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:12.124 -0500", hash_original_method = "C2CB87B9E1EBFB96BF37E1CA2A1422A5", hash_generated_method = "C2CB87B9E1EBFB96BF37E1CA2A1422A5")
        
void startFade() {
            mFadeDuration = FADE_DURATION;
            mStartTime = SystemClock.uptimeMillis();
            setState(STATE_EXIT);
        }
        
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:12.126 -0500", hash_original_method = "AFB48DA784BE880095A4465F927D06A4", hash_generated_method = "AFB48DA784BE880095A4465F927D06A4")
        
int getAlpha() {
            if (getState() != STATE_EXIT) {
                return ALPHA_MAX;
            }
            int alpha;
            long now = SystemClock.uptimeMillis();
            if (now > mStartTime + mFadeDuration) {
                alpha = 0;
            } else {
                alpha = (int) (ALPHA_MAX - ((now - mStartTime) * ALPHA_MAX) / mFadeDuration); 
            }
            return alpha;
        }
        
        @DSSpec(DSCat.THREADING)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:12.129 -0500", hash_original_method = "3A2ADC6F19B17BA5C164F36207FFFC0C", hash_generated_method = "C6ECF2234803BACE456F86B71E499E99")
        
public void run() {
            if (getState() != STATE_EXIT) {
                startFade();
                return;
            }
            
            if (getAlpha() > 0) {
                mList.invalidate();
            } else {
                setState(STATE_NONE);
            }
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:12.064 -0500", hash_original_method = "0A57524C8928F6FDE971C9B9E9D3463C", hash_generated_method = "91314E9A301787B9AFA5E96712758CB4")
    
private void init(Context context) {
        // Get both the scrollbar states drawables
        TypedArray ta = context.getTheme().obtainStyledAttributes(ATTRS);
        useThumbDrawable(context, ta.getDrawable(THUMB_DRAWABLE));
        mTrackDrawable = ta.getDrawable(TRACK_DRAWABLE);
        
        mOverlayDrawableLeft = ta.getDrawable(PREVIEW_BACKGROUND_LEFT);
        mOverlayDrawableRight = ta.getDrawable(PREVIEW_BACKGROUND_RIGHT);
        mOverlayPosition = ta.getInt(OVERLAY_POSITION, OVERLAY_FLOATING);
        
        mScrollCompleted = true;

        getSectionsFromIndexer();

        mOverlaySize = context.getResources().getDimensionPixelSize(
                com.android.internal.R.dimen.fastscroll_overlay_size);
        mOverlayPos = new RectF();
        mScrollFade = new ScrollFade();
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setTextAlign(Paint.Align.CENTER);
        mPaint.setTextSize(mOverlaySize / 2);

        ColorStateList textColor = ta.getColorStateList(TEXT_COLOR);
        int textColorNormal = textColor.getDefaultColor();
        mPaint.setColor(textColorNormal);
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);

        // to show mOverlayDrawable properly
        if (mList.getWidth() > 0 && mList.getHeight() > 0) {
            onSizeChanged(mList.getWidth(), mList.getHeight(), 0, 0);
        }
        
        mState = STATE_NONE;
        refreshDrawableState();

        ta.recycle();

        mScaledTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();

        mMatchDragPosition = context.getApplicationInfo().targetSdkVersion >=
                android.os.Build.VERSION_CODES.HONEYCOMB;

        setScrollbarPosition(mList.getVerticalScrollbarPosition());
    }
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:12.066 -0500", hash_original_method = "056243A841F0EC691D28BA5422CDF65B", hash_generated_method = "056243A841F0EC691D28BA5422CDF65B")
    
void stop() {
        setState(STATE_NONE);
    }
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:12.068 -0500", hash_original_method = "DC69F15A6278F37206902D3451EB4A27", hash_generated_method = "DC69F15A6278F37206902D3451EB4A27")
    
boolean isVisible() {
        return !(mState == STATE_NONE);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:12.072 -0500", hash_original_method = "C51EC11284E4C57CA49569FFECEAA05A", hash_generated_method = "DE1C9A473F94B4CAEC2625218F6580ED")
    
public void draw(Canvas canvas) {
        
        if (mState == STATE_NONE) {
            // No need to draw anything
            return;
        }

        final int y = mThumbY;
        final int viewWidth = mList.getWidth();
        final FastScroller.ScrollFade scrollFade = mScrollFade;

        int alpha = -1;
        if (mState == STATE_EXIT) {
            alpha = scrollFade.getAlpha();
            if (alpha < ScrollFade.ALPHA_MAX / 2) {
                mThumbDrawable.setAlpha(alpha * 2);
            }
            int left = 0;
            switch (mPosition) {
                case View.SCROLLBAR_POSITION_DEFAULT:
                case View.SCROLLBAR_POSITION_RIGHT:
                    left = viewWidth - (mThumbW * alpha) / ScrollFade.ALPHA_MAX;
                    break;
                case View.SCROLLBAR_POSITION_LEFT:
                    left = -mThumbW + (mThumbW * alpha) / ScrollFade.ALPHA_MAX;
                    break;
            }
            mThumbDrawable.setBounds(left, 0, left + mThumbW, mThumbH);
            mChangedBounds = true;
        }

        if (mTrackDrawable != null) {
            final Rect thumbBounds = mThumbDrawable.getBounds();
            final int left = thumbBounds.left;
            final int halfThumbHeight = (thumbBounds.bottom - thumbBounds.top) / 2;
            final int trackWidth = mTrackDrawable.getIntrinsicWidth();
            final int trackLeft = (left + mThumbW / 2) - trackWidth / 2;
            mTrackDrawable.setBounds(trackLeft, halfThumbHeight,
                    trackLeft + trackWidth, mList.getHeight() - halfThumbHeight);
            mTrackDrawable.draw(canvas);
        }

        canvas.translate(0, y);
        mThumbDrawable.draw(canvas);
        canvas.translate(0, -y);

        // If user is dragging the scroll bar, draw the alphabet overlay
        if (mState == STATE_DRAGGING && mDrawOverlay) {
            if (mOverlayPosition == OVERLAY_AT_THUMB) {
                int left = 0;
                switch (mPosition) {
                    default:
                    case View.SCROLLBAR_POSITION_DEFAULT:
                    case View.SCROLLBAR_POSITION_RIGHT:
                        left = Math.max(0,
                                mThumbDrawable.getBounds().left - mThumbW - mOverlaySize);
                        break;
                    case View.SCROLLBAR_POSITION_LEFT:
                        left = Math.min(mThumbDrawable.getBounds().right + mThumbW,
                                mList.getWidth() - mOverlaySize);
                        break;
                }

                int top = Math.max(0,
                        Math.min(y + (mThumbH - mOverlaySize) / 2, mList.getHeight() - mOverlaySize));

                final RectF pos = mOverlayPos;
                pos.left = left;
                pos.right = pos.left + mOverlaySize;
                pos.top = top;
                pos.bottom = pos.top + mOverlaySize;
                if (mOverlayDrawable != null) {
                    mOverlayDrawable.setBounds((int) pos.left, (int) pos.top,
                            (int) pos.right, (int) pos.bottom);
                }
            }
            mOverlayDrawable.draw(canvas);
            final Paint paint = mPaint;
            float descent = paint.descent();
            final RectF rectF = mOverlayPos;
            final Rect tmpRect = mTmpRect;
            mOverlayDrawable.getPadding(tmpRect);
            final int hOff = (tmpRect.right - tmpRect.left) / 2;
            final int vOff = (tmpRect.bottom - tmpRect.top) / 2;
            canvas.drawText(mSectionText, (int) (rectF.left + rectF.right) / 2 - hOff,
                    (int) (rectF.bottom + rectF.top) / 2 + mOverlaySize / 4 - descent - vOff,
                    paint);
        } else if (mState == STATE_EXIT) {
            if (alpha == 0) { // Done with exit
                setState(STATE_NONE);
            } else if (mTrackDrawable != null) {
                mList.invalidate(viewWidth - mThumbW, 0, viewWidth, mList.getHeight());
            } else {
                mList.invalidate(viewWidth - mThumbW, y, viewWidth, y + mThumbH);
            }
        }
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:12.075 -0500", hash_original_method = "E295B7FC2E9560F481D5875AE2ECD038", hash_generated_method = "576F2331C6241716E364FCAEDA2631F1")
    
void onSizeChanged(int w, int h, int oldw, int oldh) {
        if (mThumbDrawable != null) {
            switch (mPosition) {
                default:
                case View.SCROLLBAR_POSITION_DEFAULT:
                case View.SCROLLBAR_POSITION_RIGHT:
                    mThumbDrawable.setBounds(w - mThumbW, 0, w, mThumbH);
                    break;
                case View.SCROLLBAR_POSITION_LEFT:
                    mThumbDrawable.setBounds(0, 0, mThumbW, mThumbH);
                    break;
            }
        }
        if (mOverlayPosition == OVERLAY_FLOATING) {
            final RectF pos = mOverlayPos;
            pos.left = (w - mOverlaySize) / 2;
            pos.right = pos.left + mOverlaySize;
            pos.top = h / 10; // 10% from top
            pos.bottom = pos.top + mOverlaySize;
            if (mOverlayDrawable != null) {
                mOverlayDrawable.setBounds((int) pos.left, (int) pos.top,
                        (int) pos.right, (int) pos.bottom);
            }
        }
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:12.077 -0500", hash_original_method = "33CBCEE809BB980D8FD69134B46323D0", hash_generated_method = "33CBCEE809BB980D8FD69134B46323D0")
    
void onItemCountChanged(int oldCount, int newCount) {
        if (mAlwaysShow) {
            mLongList = true;
        }
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:12.080 -0500", hash_original_method = "E5B6E6440A22D0800FAD70BDC783A6AE", hash_generated_method = "39C365730BE8FCA99E01104B5D926A74")
    
void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, 
            int totalItemCount) {
        // Are there enough pages to require fast scroll? Recompute only if total count changes
        if (mItemCount != totalItemCount && visibleItemCount > 0) {
            mItemCount = totalItemCount;
            mLongList = mItemCount / visibleItemCount >= MIN_PAGES;
        }
        if (mAlwaysShow) {
            mLongList = true;
        }
        if (!mLongList) {
            if (mState != STATE_NONE) {
                setState(STATE_NONE);
            }
            return;
        }
        if (totalItemCount - visibleItemCount > 0 && mState != STATE_DRAGGING) {
            mThumbY = getThumbPositionForListPosition(firstVisibleItem, visibleItemCount,
                    totalItemCount);
            if (mChangedBounds) {
                resetThumbPos();
                mChangedBounds = false;
            }
        }
        mScrollCompleted = true;
        if (firstVisibleItem == mVisibleItem) {
            return;
        }
        mVisibleItem = firstVisibleItem;
        if (mState != STATE_DRAGGING) {
            setState(STATE_VISIBLE);
            if (!mAlwaysShow) {
                mHandler.postDelayed(mScrollFade, FADE_TIMEOUT);
            }
        }
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:12.082 -0500", hash_original_method = "AD42D97439FFEC71F76D9E9B9EF1920A", hash_generated_method = "AD42D97439FFEC71F76D9E9B9EF1920A")
    
SectionIndexer getSectionIndexer() {
        return mSectionIndexer;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:12.084 -0500", hash_original_method = "0CD968054794DA4AF55762FEAC06E707", hash_generated_method = "0CD968054794DA4AF55762FEAC06E707")
    
Object[] getSections() {
        if (mListAdapter == null && mList != null) {
            getSectionsFromIndexer();
        }
        return mSections;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:12.086 -0500", hash_original_method = "800EB68723F3F3F4CE4E1BDE2BD8DC58", hash_generated_method = "800EB68723F3F3F4CE4E1BDE2BD8DC58")
    
void getSectionsFromIndexer() {
        Adapter adapter = mList.getAdapter();
        mSectionIndexer = null;
        if (adapter instanceof HeaderViewListAdapter) {
            mListOffset = ((HeaderViewListAdapter)adapter).getHeadersCount();
            adapter = ((HeaderViewListAdapter)adapter).getWrappedAdapter();
        }
        if (adapter instanceof ExpandableListConnector) {
            ExpandableListAdapter expAdapter = ((ExpandableListConnector)adapter).getAdapter();
            if (expAdapter instanceof SectionIndexer) {
                mSectionIndexer = (SectionIndexer) expAdapter;
                mListAdapter = (BaseAdapter) adapter;
                mSections = mSectionIndexer.getSections();
            }
        } else {
            if (adapter instanceof SectionIndexer) {
                mListAdapter = (BaseAdapter) adapter;
                mSectionIndexer = (SectionIndexer) adapter;
                mSections = mSectionIndexer.getSections();
                if (mSections == null) {
                    mSections = new String[] { " " };
                }
            } else {
                mListAdapter = (BaseAdapter) adapter;
                mSections = new String[] { " " };
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:12.088 -0500", hash_original_method = "B72F5DA2B803BA6E8807DBDDDB2D9463", hash_generated_method = "595D6901DC1311A7579ACF8443CF5DC8")
    
public void onSectionsChanged() {
        mListAdapter = null;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:12.092 -0500", hash_original_method = "5A8E212F57F70A160B41013FFA05181F", hash_generated_method = "1E02AA1B284B98C447E93C16E296F6EA")
    
void scrollTo(float position) {
        int count = mList.getCount();
        mScrollCompleted = false;
        float fThreshold = (1.0f / count) / 8;
        final Object[] sections = mSections;
        int sectionIndex;
        if (sections != null && sections.length > 1) {
            final int nSections = sections.length;
            int section = (int) (position * nSections);
            if (section >= nSections) {
                section = nSections - 1;
            }
            int exactSection = section;
            sectionIndex = section;
            int index = mSectionIndexer.getPositionForSection(section);
            // Given the expected section and index, the following code will
            // try to account for missing sections (no names starting with..)
            // It will compute the scroll space of surrounding empty sections
            // and interpolate the currently visible letter's range across the
            // available space, so that there is always some list movement while
            // the user moves the thumb.
            int nextIndex = count;
            int prevIndex = index;
            int prevSection = section;
            int nextSection = section + 1;
            // Assume the next section is unique
            if (section < nSections - 1) {
                nextIndex = mSectionIndexer.getPositionForSection(section + 1);
            }
            
            // Find the previous index if we're slicing the previous section
            if (nextIndex == index) {
                // Non-existent letter
                while (section > 0) {
                    section--;
                    prevIndex = mSectionIndexer.getPositionForSection(section);
                    if (prevIndex != index) {
                        prevSection = section;
                        sectionIndex = section;
                        break;
                    } else if (section == 0) {
                        // When section reaches 0 here, sectionIndex must follow it.
                        // Assuming mSectionIndexer.getPositionForSection(0) == 0.
                        sectionIndex = 0;
                        break;
                    }
                }
            }
            // Find the next index, in case the assumed next index is not
            // unique. For instance, if there is no P, then request for P's 
            // position actually returns Q's. So we need to look ahead to make
            // sure that there is really a Q at Q's position. If not, move 
            // further down...
            int nextNextSection = nextSection + 1;
            while (nextNextSection < nSections &&
                    mSectionIndexer.getPositionForSection(nextNextSection) == nextIndex) {
                nextNextSection++;
                nextSection++;
            }
            // Compute the beginning and ending scroll range percentage of the
            // currently visible letter. This could be equal to or greater than
            // (1 / nSections). 
            float fPrev = (float) prevSection / nSections;
            float fNext = (float) nextSection / nSections;
            if (prevSection == exactSection && position - fPrev < fThreshold) {
                index = prevIndex;
            } else {
                index = prevIndex + (int) ((nextIndex - prevIndex) * (position - fPrev) 
                    / (fNext - fPrev));
            }
            // Don't overflow
            if (index > count - 1) index = count - 1;
            
            if (mList instanceof ExpandableListView) {
                ExpandableListView expList = (ExpandableListView) mList;
                expList.setSelectionFromTop(expList.getFlatListPosition(
                        ExpandableListView.getPackedPositionForGroup(index + mListOffset)), 0);
            } else if (mList instanceof ListView) {
                ((ListView)mList).setSelectionFromTop(index + mListOffset, 0);
            } else {
                mList.setSelection(index + mListOffset);
            }
        } else {
            int index = (int) (position * count);
            // Don't overflow
            if (index > count - 1) index = count - 1;

            if (mList instanceof ExpandableListView) {
                ExpandableListView expList = (ExpandableListView) mList;
                expList.setSelectionFromTop(expList.getFlatListPosition(
                        ExpandableListView.getPackedPositionForGroup(index + mListOffset)), 0);
            } else if (mList instanceof ListView) {
                ((ListView)mList).setSelectionFromTop(index + mListOffset, 0);
            } else {
                mList.setSelection(index + mListOffset);
            }
            sectionIndex = -1;
        }

        if (sectionIndex >= 0) {
            String text = mSectionText = sections[sectionIndex].toString();
            mDrawOverlay = (text.length() != 1 || text.charAt(0) != ' ') &&
                    sectionIndex < sections.length;
        } else {
            mDrawOverlay = false;
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:12.096 -0500", hash_original_method = "5B13E30A0127E5E811D3308FC0C54801", hash_generated_method = "D1FB040BBCD182F6E6A0A22C0372428B")
    
private int getThumbPositionForListPosition(int firstVisibleItem, int visibleItemCount,
            int totalItemCount) {
        if (mSectionIndexer == null || mListAdapter == null) {
            getSectionsFromIndexer();
        }
        if (mSectionIndexer == null || !mMatchDragPosition) {
            return ((mList.getHeight() - mThumbH) * firstVisibleItem)
                    / (totalItemCount - visibleItemCount);
        }

        firstVisibleItem -= mListOffset;
        if (firstVisibleItem < 0) {
            return 0;
        }
        totalItemCount -= mListOffset;

        final int trackHeight = mList.getHeight() - mThumbH;

        final int section = mSectionIndexer.getSectionForPosition(firstVisibleItem);
        final int sectionPos = mSectionIndexer.getPositionForSection(section);
        final int nextSectionPos = mSectionIndexer.getPositionForSection(section + 1);
        final int sectionCount = mSections.length;
        final int positionsInSection = nextSectionPos - sectionPos;

        final View child = mList.getChildAt(0);
        final float incrementalPos = child == null ? 0 : firstVisibleItem +
                (float) (mList.getPaddingTop() - child.getTop()) / child.getHeight();
        final float posWithinSection = (incrementalPos - sectionPos) / positionsInSection;
        int result = (int) ((section + posWithinSection) / sectionCount * trackHeight);

        // Fake out the scrollbar for the last item. Since the section indexer won't
        // ever actually move the list in this end space, make scrolling across the last item
        // account for whatever space is remaining.
        if (firstVisibleItem > 0 && firstVisibleItem + visibleItemCount == totalItemCount) {
            final View lastChild = mList.getChildAt(visibleItemCount - 1);
            final float lastItemVisible = (float) (mList.getHeight() - mList.getPaddingBottom()
                    - lastChild.getTop()) / lastChild.getHeight();
            result += (trackHeight - result) * lastItemVisible;
        }

        return result;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:12.098 -0500", hash_original_method = "CEA01B9B754ED8848F89028F972B696F", hash_generated_method = "FBFE1AB1AC19D19D57533C34A68A2DF3")
    
private void cancelFling() {
        // Cancel the list fling
        MotionEvent cancelFling = MotionEvent.obtain(0, 0, MotionEvent.ACTION_CANCEL, 0, 0, 0);
        mList.onTouchEvent(cancelFling);
        cancelFling.recycle();
    }
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:12.100 -0500", hash_original_method = "1BBF9FC05240D406AB082B75B38F8E40", hash_generated_method = "1BBF9FC05240D406AB082B75B38F8E40")
    
void cancelPendingDrag() {
        mList.removeCallbacks(mDeferStartDrag);
        mPendingDrag = false;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:12.102 -0500", hash_original_method = "DD628BE0DD3562FCAA0807D28A9AC0F6", hash_generated_method = "DD628BE0DD3562FCAA0807D28A9AC0F6")
    
void startPendingDrag() {
        mPendingDrag = true;
        mList.postDelayed(mDeferStartDrag, PENDING_DRAG_DELAY);
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:12.104 -0500", hash_original_method = "12EF9C1930DF387CC333A7C9F1E54726", hash_generated_method = "12EF9C1930DF387CC333A7C9F1E54726")
    
void beginDrag() {
        setState(STATE_DRAGGING);
        if (mListAdapter == null && mList != null) {
            getSectionsFromIndexer();
        }
        if (mList != null) {
            mList.requestDisallowInterceptTouchEvent(true);
            mList.reportScrollStateChange(OnScrollListener.SCROLL_STATE_TOUCH_SCROLL);
        }

        cancelFling();
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:12.107 -0500", hash_original_method = "D950A8D9B3AA1D87B11E428662FC0A13", hash_generated_method = "D950A8D9B3AA1D87B11E428662FC0A13")
    
boolean onInterceptTouchEvent(MotionEvent ev) {
        switch (ev.getActionMasked()) {
            case MotionEvent.ACTION_DOWN:
                if (mState > STATE_NONE && isPointInside(ev.getX(), ev.getY())) {
                    if (!mList.isInScrollingContainer()) {
                        beginDrag();
                        return true;
                    }
                    mInitialTouchY = ev.getY();
                    startPendingDrag();
                }
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                cancelPendingDrag();
                break;
        }
        return false;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:12.110 -0500", hash_original_method = "891E4A8523ECAE5B8AA3233AF8AC2D21", hash_generated_method = "A5C647F904720FFCF79D89E467E68D99")
    
boolean onTouchEvent(MotionEvent me) {
        if (mState == STATE_NONE) {
            return false;
        }

        final int action = me.getAction();

        if (action == MotionEvent.ACTION_DOWN) {
            if (isPointInside(me.getX(), me.getY())) {
                if (!mList.isInScrollingContainer()) {
                    beginDrag();
                    return true;
                }
                mInitialTouchY = me.getY();
                startPendingDrag();
            }
        } else if (action == MotionEvent.ACTION_UP) { // don't add ACTION_CANCEL here
            if (mPendingDrag) {
                // Allow a tap to scroll.
                beginDrag();

                final int viewHeight = mList.getHeight();
                // Jitter
                int newThumbY = (int) me.getY() - mThumbH + 10;
                if (newThumbY < 0) {
                    newThumbY = 0;
                } else if (newThumbY + mThumbH > viewHeight) {
                    newThumbY = viewHeight - mThumbH;
                }
                mThumbY = newThumbY;
                scrollTo((float) mThumbY / (viewHeight - mThumbH));

                cancelPendingDrag();
                // Will hit the STATE_DRAGGING check below
            }
            if (mState == STATE_DRAGGING) {
                if (mList != null) {
                    // ViewGroup does the right thing already, but there might
                    // be other classes that don't properly reset on touch-up,
                    // so do this explicitly just in case.
                    mList.requestDisallowInterceptTouchEvent(false);
                    mList.reportScrollStateChange(OnScrollListener.SCROLL_STATE_IDLE);
                }
                setState(STATE_VISIBLE);
                final Handler handler = mHandler;
                handler.removeCallbacks(mScrollFade);
                if (!mAlwaysShow) {
                    handler.postDelayed(mScrollFade, 1000);
                }

                mList.invalidate();
                return true;
            }
        } else if (action == MotionEvent.ACTION_MOVE) {
            if (mPendingDrag) {
                final float y = me.getY();
                if (Math.abs(y - mInitialTouchY) > mScaledTouchSlop) {
                    setState(STATE_DRAGGING);
                    if (mListAdapter == null && mList != null) {
                        getSectionsFromIndexer();
                    }
                    if (mList != null) {
                        mList.requestDisallowInterceptTouchEvent(true);
                        mList.reportScrollStateChange(OnScrollListener.SCROLL_STATE_TOUCH_SCROLL);
                    }

                    cancelFling();
                    cancelPendingDrag();
                    // Will hit the STATE_DRAGGING check below
                }
            }
            if (mState == STATE_DRAGGING) {
                final int viewHeight = mList.getHeight();
                // Jitter
                int newThumbY = (int) me.getY() - mThumbH + 10;
                if (newThumbY < 0) {
                    newThumbY = 0;
                } else if (newThumbY + mThumbH > viewHeight) {
                    newThumbY = viewHeight - mThumbH;
                }
                if (Math.abs(mThumbY - newThumbY) < 2) {
                    return true;
                }
                mThumbY = newThumbY;
                // If the previous scrollTo is still pending
                if (mScrollCompleted) {
                    scrollTo((float) mThumbY / (viewHeight - mThumbH));
                }
                return true;
            }
        } else if (action == MotionEvent.ACTION_CANCEL) {
            cancelPendingDrag();
        }
        return false;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:12.112 -0500", hash_original_method = "4AFF55C64BD9939BD0E5A83378980FDE", hash_generated_method = "8405A15E6ED146794AFD2EA3E642BB0D")
    
boolean isPointInside(float x, float y) {
        boolean inTrack = false;
        switch (mPosition) {
            default:
            case View.SCROLLBAR_POSITION_DEFAULT:
            case View.SCROLLBAR_POSITION_RIGHT:
                inTrack = x > mList.getWidth() - mThumbW;
                break;
            case View.SCROLLBAR_POSITION_LEFT:
                inTrack = x < mThumbW;
                break;
        }

        // Allow taps in the track to start moving.
        return inTrack && (mTrackDrawable != null || y >= mThumbY && y <= mThumbY + mThumbH);
    }
}

