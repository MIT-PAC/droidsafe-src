package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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

class FastScroller {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.822 -0400", hash_original_field = "E4F0AC5F69FC7254EF772878E84BE9AD", hash_generated_field = "723113CD58F6B081A7D304DE131200C0")

    private Drawable mThumbDrawable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.822 -0400", hash_original_field = "FA8E2671094A1E8D3FF3671EC8F8C2EC", hash_generated_field = "C4F6607BE177BD0C551FFF72CB52709D")

    private Drawable mOverlayDrawable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.822 -0400", hash_original_field = "25A0A5DB31F18B827384634F1DF122D7", hash_generated_field = "95BC711301E78A9ECDB61E242B32BBFC")

    private Drawable mTrackDrawable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.822 -0400", hash_original_field = "56AD3C9E331C06765B4A3FAE13009CC1", hash_generated_field = "3F431D8A9EEFA832E40733D030288C4E")

    private Drawable mOverlayDrawableLeft;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.822 -0400", hash_original_field = "6F789E34E679B1AB90E2061F47AF7BFC", hash_generated_field = "CBEF23D76FD5E642BD307BDCC6E254DC")

    private Drawable mOverlayDrawableRight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.822 -0400", hash_original_field = "2D9918C395C4B2BA3612AD222BCC7CBE", hash_generated_field = "3D6BD301AD11E22B2417B343C44F938F")

    int mThumbH;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.822 -0400", hash_original_field = "EF5497FDB3AFB7DB29B7861C625072A7", hash_generated_field = "DCE6651DC2A97578BDBD4F73CA2A9123")

    int mThumbW;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.822 -0400", hash_original_field = "02B58672B21A07183055AAD51D46B0B3", hash_generated_field = "3E4FAF8454C2C912B7626021FE9AF353")

    int mThumbY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.822 -0400", hash_original_field = "D0A39E96B88B96626E240F88FAC8ACE2", hash_generated_field = "652CA9CCF5547E5517E87FEB493C682F")

    private RectF mOverlayPos;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.822 -0400", hash_original_field = "C6AC2A64803A7F25EDC241C13EA8E5BB", hash_generated_field = "CF4608DD9AF6C21FCFF4CAB07660E9AC")

    private int mOverlaySize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.822 -0400", hash_original_field = "F796A16BE866311501B24C73148D80F1", hash_generated_field = "8DE3CD4C54B5C114BFFFAF8D6B3834ED")

    AbsListView mList;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.822 -0400", hash_original_field = "E84622B86B2732A4CCC462C11B32EF8D", hash_generated_field = "F80BE66A40916AFE64128A97287351B5")

    boolean mScrollCompleted;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.822 -0400", hash_original_field = "3C2340F71EE076A080607C138E0B206C", hash_generated_field = "2B767EF4AB0ACDA9AD9957D0EE99C88B")

    private int mVisibleItem;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.822 -0400", hash_original_field = "78E27F80AC0100441F897783EFA42851", hash_generated_field = "75BCEEBE83B26919B33E8EA8B289919E")

    private Paint mPaint;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.822 -0400", hash_original_field = "AC3BBF4B2D74729446FCB47B162AE3ED", hash_generated_field = "74A1AC6BAAFB1602514EDA87DF3F165A")

    private int mListOffset;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.822 -0400", hash_original_field = "7AA3C8F5F81D9ECD18129B12222725EE", hash_generated_field = "7633D41B58955728937D8CC0DB2694BE")

    private int mItemCount = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.822 -0400", hash_original_field = "C957CDFB9EFF169FA6B098E5D3472F01", hash_generated_field = "74C6663E6FE3B64B12C20186C73689BE")

    private boolean mLongList;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.822 -0400", hash_original_field = "5499B299E8C9CF2E47AEAACF55FB80F8", hash_generated_field = "E10BB9F3460B91FF78086EFA996A0114")

    private Object [] mSections;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.822 -0400", hash_original_field = "F8807952632DA2BFEA5E1C98363B7657", hash_generated_field = "8F91F071959F5E46C9D858D712A42531")

    private String mSectionText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.822 -0400", hash_original_field = "BB8B2F4E60C278348EA370446EADF234", hash_generated_field = "66337501372B93428A3E0DCFBCAA8A4D")

    private boolean mDrawOverlay;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.822 -0400", hash_original_field = "BC14E51C6A4BF76998F27D1BA0D148A7", hash_generated_field = "C5CC7DBEDDDE3933C75D287B3954EC80")

    private ScrollFade mScrollFade;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.822 -0400", hash_original_field = "48A902C1D749B47EBC75C77370D5A1F0", hash_generated_field = "19B55F2750B971E6310D64ADB9B2D0CF")

    private int mState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.822 -0400", hash_original_field = "6781893E9FA50A9B7103FD3F674E566B", hash_generated_field = "2E60E17486AAEB1A4E1F1878A0354061")

    private Handler mHandler = new Handler();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.822 -0400", hash_original_field = "B8EAD9E776B81483E5E8A661601F6AA8", hash_generated_field = "33273F8B8EE0B442CE373E963CE812B8")

    BaseAdapter mListAdapter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.822 -0400", hash_original_field = "7F7BC677896D04A978C7A4DB016F6E9E", hash_generated_field = "993A155558E830738166022FC5D1A65D")

    private SectionIndexer mSectionIndexer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.822 -0400", hash_original_field = "2425089C9D38CD13382E0B0290A580FB", hash_generated_field = "54BB6C7E624546A679D88F2CE6A36CC3")

    private boolean mChangedBounds;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.822 -0400", hash_original_field = "2A02BDE12D932CD9DCA97106D487F8F5", hash_generated_field = "D614AE7D1AAE0276EA05A974DCBF0210")

    private int mPosition;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.822 -0400", hash_original_field = "D8301B9D37BE0AB158BABDD736CFE57D", hash_generated_field = "1013EB9EDD9A15A8ED84F490CA1C5ACA")

    private boolean mAlwaysShow;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.822 -0400", hash_original_field = "7FEB639EAB58078B983A7FDB8F55A63B", hash_generated_field = "818199C64E5FB571F9E3F2622DF96D7E")

    private int mOverlayPosition;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.822 -0400", hash_original_field = "92CD80C13C1AC935197D48655FE89951", hash_generated_field = "6A99D75E2A8444FF7C66E9499447E446")

    private boolean mMatchDragPosition;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.822 -0400", hash_original_field = "15F34BDDAE4312237D3D605D7D9FA68D", hash_generated_field = "A2E2E464E467FCA571530A8485FFA938")

    float mInitialTouchY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.823 -0400", hash_original_field = "484EC5A8F86FD2AD413186C1D2DBCBE9", hash_generated_field = "A31D9AE99DECC41BA4A47D3E5C2BD2CA")

    boolean mPendingDrag;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.823 -0400", hash_original_field = "007A72391FE679B54C8CDBD6A79A1E3F", hash_generated_field = "A6018E4F8C21D3EE961380A6D74CC7E0")

    private int mScaledTouchSlop;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.823 -0400", hash_original_field = "C16522492B0457D64CB22178541F3ACA", hash_generated_field = "A9D5B7D1068DC6DDDEE02560E993CCF6")

    private Rect mTmpRect = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.824 -0400", hash_original_field = "FDE3D253B193C180C3BB694BFE237899", hash_generated_field = "6C5D9B1BAA0C99DB08DD88DE94081CA3")

    private Runnable mDeferStartDrag = new Runnable() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.823 -0400", hash_original_method = "8A3021930710B16F81DE57976EDC3D0F", hash_generated_method = "A54B8140DCAB37601071A13B219175E4")
        public void run() {
            {
                beginDrag();
                int viewHeight;
                viewHeight = mList.getHeight();
                int newThumbY;
                newThumbY = (int) mInitialTouchY - mThumbH + 10;
                {
                    newThumbY = 0;
                } //End block
                {
                    newThumbY = viewHeight - mThumbH;
                } //End block
                mThumbY = newThumbY;
                scrollTo((float) mThumbY / (viewHeight - mThumbH));
            } //End block
            mPendingDrag = false;
            // ---------- Original Method ----------
            //if (mList.mIsAttached) {
                //beginDrag();
                //final int viewHeight = mList.getHeight();
                //int newThumbY = (int) mInitialTouchY - mThumbH + 10;
                //if (newThumbY < 0) {
                    //newThumbY = 0;
                //} else if (newThumbY + mThumbH > viewHeight) {
                    //newThumbY = viewHeight - mThumbH;
                //}
                //mThumbY = newThumbY;
                //scrollTo((float) mThumbY / (viewHeight - mThumbH));
            //}
            //mPendingDrag = false;
        }

        
};
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.824 -0400", hash_original_method = "A2A2A1F0C9639ECE9FE84AFC4D4D3A80", hash_generated_method = "2E544D1E97215E1EE92E48CE527EFB33")
    public  FastScroller(Context context, AbsListView listView) {
        mList = listView;
        init(context);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
        //mList = listView;
        //init(context);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.825 -0400", hash_original_method = "39D93CA5552A2245B487796C83EA3A2C", hash_generated_method = "8514F207357119F1B336448F7E608BBF")
    public void setAlwaysShow(boolean alwaysShow) {
        mAlwaysShow = alwaysShow;
        {
            mHandler.removeCallbacks(mScrollFade);
            setState(STATE_VISIBLE);
        } //End block
        {
            mHandler.postDelayed(mScrollFade, FADE_TIMEOUT);
        } //End block
        // ---------- Original Method ----------
        //mAlwaysShow = alwaysShow;
        //if (alwaysShow) {
            //mHandler.removeCallbacks(mScrollFade);
            //setState(STATE_VISIBLE);
        //} else if (mState == STATE_VISIBLE) {
            //mHandler.postDelayed(mScrollFade, FADE_TIMEOUT);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.825 -0400", hash_original_method = "FE4F6BFF00D7A9534103DEC6DDA5B37C", hash_generated_method = "018572F615AB0A69C480AABFBAD22F3C")
    public boolean isAlwaysShowEnabled() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_213146177 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_213146177;
        // ---------- Original Method ----------
        //return mAlwaysShow;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.825 -0400", hash_original_method = "8A07D5E4DE8CD170DC3BFC9FE8A30504", hash_generated_method = "08C8BB9BFEEFBDD8331B7FBA3D351A79")
    private void refreshDrawableState() {
        int[] state;
        state = PRESSED_STATES;
        state = DEFAULT_STATES;
        {
            boolean varFFD0D4700603A30109E1419E6751DAC5_147517938 = (mThumbDrawable != null && mThumbDrawable.isStateful());
            {
                mThumbDrawable.setState(state);
            } //End block
        } //End collapsed parenthetic
        {
            boolean var186A66CF4AFBB431FA0AA3F444BEC0A2_498509678 = (mTrackDrawable != null && mTrackDrawable.isStateful());
            {
                mTrackDrawable.setState(state);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //int[] state = mState == STATE_DRAGGING ? PRESSED_STATES : DEFAULT_STATES;
        //if (mThumbDrawable != null && mThumbDrawable.isStateful()) {
            //mThumbDrawable.setState(state);
        //}
        //if (mTrackDrawable != null && mTrackDrawable.isStateful()) {
            //mTrackDrawable.setState(state);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.826 -0400", hash_original_method = "4A2BCFB2C4534D1665C92142AF186787", hash_generated_method = "92B1C33A8159587A6DA748D5DA5E8540")
    public void setScrollbarPosition(int position) {
        mPosition = position;
        //Begin case default View.SCROLLBAR_POSITION_DEFAULT View.SCROLLBAR_POSITION_RIGHT 
        mOverlayDrawable = mOverlayDrawableRight;
        //End case default View.SCROLLBAR_POSITION_DEFAULT View.SCROLLBAR_POSITION_RIGHT 
        //Begin case View.SCROLLBAR_POSITION_LEFT 
        mOverlayDrawable = mOverlayDrawableLeft;
        //End case View.SCROLLBAR_POSITION_LEFT 
        // ---------- Original Method ----------
        //mPosition = position;
        //switch (position) {
            //default:
            //case View.SCROLLBAR_POSITION_DEFAULT:
            //case View.SCROLLBAR_POSITION_RIGHT:
                //mOverlayDrawable = mOverlayDrawableRight;
                //break;
            //case View.SCROLLBAR_POSITION_LEFT:
                //mOverlayDrawable = mOverlayDrawableLeft;
                //break;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.826 -0400", hash_original_method = "B47561E95C2F1E64B16085B75AB60280", hash_generated_method = "43E25AE0AE570408854FAC6D99864625")
    public int getWidth() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_738964006 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_738964006;
        // ---------- Original Method ----------
        //return mThumbW;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.828 -0400", hash_original_method = "FD0548A7869DD54F34FB4A98FCCC10E9", hash_generated_method = "DD0CE89D827CE04102C588E27CC271B2")
    public void setState(int state) {
        //Begin case STATE_NONE 
        mHandler.removeCallbacks(mScrollFade);
        //End case STATE_NONE 
        //Begin case STATE_NONE 
        mList.invalidate();
        //End case STATE_NONE 
        //Begin case STATE_VISIBLE 
        {
            resetThumbPos();
        } //End block
        //End case STATE_VISIBLE 
        //Begin case STATE_DRAGGING 
        mHandler.removeCallbacks(mScrollFade);
        //End case STATE_DRAGGING 
        //Begin case STATE_EXIT 
        int viewWidth;
        viewWidth = mList.getWidth();
        //End case STATE_EXIT 
        //Begin case STATE_EXIT 
        mList.invalidate(viewWidth - mThumbW, mThumbY, viewWidth, mThumbY + mThumbH);
        //End case STATE_EXIT 
        mState = state;
        refreshDrawableState();
        // ---------- Original Method ----------
        //switch (state) {
            //case STATE_NONE:
                //mHandler.removeCallbacks(mScrollFade);
                //mList.invalidate();
                //break;
            //case STATE_VISIBLE:
                //if (mState != STATE_VISIBLE) { 
                    //resetThumbPos();
                //}
            //case STATE_DRAGGING:
                //mHandler.removeCallbacks(mScrollFade);
                //break;
            //case STATE_EXIT:
                //int viewWidth = mList.getWidth();
                //mList.invalidate(viewWidth - mThumbW, mThumbY, viewWidth, mThumbY + mThumbH);
                //break;
        //}
        //mState = state;
        //refreshDrawableState();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.828 -0400", hash_original_method = "10E9373648D5DF4EE43B4904732E3886", hash_generated_method = "E444E975CCB215AA3B13498C3DCE3B15")
    public int getState() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1433705242 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1433705242;
        // ---------- Original Method ----------
        //return mState;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.847 -0400", hash_original_method = "C32E62B08B27A384339E1BC75CFE4552", hash_generated_method = "4C891B7316A12CA786E90BF79A4EEC23")
    private void resetThumbPos() {
        int viewWidth;
        viewWidth = mList.getWidth();
        //Begin case View.SCROLLBAR_POSITION_DEFAULT View.SCROLLBAR_POSITION_RIGHT 
        mThumbDrawable.setBounds(viewWidth - mThumbW, 0, viewWidth, mThumbH);
        //End case View.SCROLLBAR_POSITION_DEFAULT View.SCROLLBAR_POSITION_RIGHT 
        //Begin case View.SCROLLBAR_POSITION_LEFT 
        mThumbDrawable.setBounds(0, 0, mThumbW, mThumbH);
        //End case View.SCROLLBAR_POSITION_LEFT 
        mThumbDrawable.setAlpha(ScrollFade.ALPHA_MAX);
        // ---------- Original Method ----------
        //final int viewWidth = mList.getWidth();
        //switch (mPosition) {
            //case View.SCROLLBAR_POSITION_DEFAULT:
            //case View.SCROLLBAR_POSITION_RIGHT:
                //mThumbDrawable.setBounds(viewWidth - mThumbW, 0, viewWidth, mThumbH);
                //break;
            //case View.SCROLLBAR_POSITION_LEFT:
                //mThumbDrawable.setBounds(0, 0, mThumbW, mThumbH);
                //break;
        //}
        //mThumbDrawable.setAlpha(ScrollFade.ALPHA_MAX);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.848 -0400", hash_original_method = "5C6D13F417D5AA8E0A1553C57F0CD3F0", hash_generated_method = "D822EB46DED61EE27CAFB88FDA15052A")
    private void useThumbDrawable(Context context, Drawable drawable) {
        mThumbDrawable = drawable;
        {
            mThumbW = context.getResources().getDimensionPixelSize(
                    com.android.internal.R.dimen.fastscroll_thumb_width);
            mThumbH = context.getResources().getDimensionPixelSize(
                    com.android.internal.R.dimen.fastscroll_thumb_height);
        } //End block
        {
            mThumbW = drawable.getIntrinsicWidth();
            mThumbH = drawable.getIntrinsicHeight();
        } //End block
        mChangedBounds = true;
        // ---------- Original Method ----------
        //mThumbDrawable = drawable;
        //if (drawable instanceof NinePatchDrawable) {
            //mThumbW = context.getResources().getDimensionPixelSize(
                    //com.android.internal.R.dimen.fastscroll_thumb_width);
            //mThumbH = context.getResources().getDimensionPixelSize(
                    //com.android.internal.R.dimen.fastscroll_thumb_height);
        //} else {
            //mThumbW = drawable.getIntrinsicWidth();
            //mThumbH = drawable.getIntrinsicHeight();
        //}
        //mChangedBounds = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.853 -0400", hash_original_method = "0A57524C8928F6FDE971C9B9E9D3463C", hash_generated_method = "97DC8A54BFD4E47E81105DFE32825EB6")
    private void init(Context context) {
        TypedArray ta;
        ta = context.getTheme().obtainStyledAttributes(ATTRS);
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
        ColorStateList textColor;
        textColor = ta.getColorStateList(TEXT_COLOR);
        int textColorNormal;
        textColorNormal = textColor.getDefaultColor();
        mPaint.setColor(textColorNormal);
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        {
            boolean var0E9C0EBA61F05B4437A59B11FFE8A9DF_1956664731 = (mList.getWidth() > 0 && mList.getHeight() > 0);
            {
                onSizeChanged(mList.getWidth(), mList.getHeight(), 0, 0);
            } //End block
        } //End collapsed parenthetic
        mState = STATE_NONE;
        refreshDrawableState();
        ta.recycle();
        mScaledTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        mMatchDragPosition = context.getApplicationInfo().targetSdkVersion >=
                android.os.Build.VERSION_CODES.HONEYCOMB;
        setScrollbarPosition(mList.getVerticalScrollbarPosition());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.854 -0400", hash_original_method = "056243A841F0EC691D28BA5422CDF65B", hash_generated_method = "CFE1ED30A07D3814D31EDD1FE0EF553E")
     void stop() {
        setState(STATE_NONE);
        // ---------- Original Method ----------
        //setState(STATE_NONE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.854 -0400", hash_original_method = "DC69F15A6278F37206902D3451EB4A27", hash_generated_method = "46248A599502EAA25FED5D27D2F37106")
     boolean isVisible() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_473330284 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_473330284;
        // ---------- Original Method ----------
        //return !(mState == STATE_NONE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.872 -0400", hash_original_method = "C51EC11284E4C57CA49569FFECEAA05A", hash_generated_method = "827D41DE805541EBF233FFA43FA70B7E")
    public void draw(Canvas canvas) {
        int y;
        y = mThumbY;
        int viewWidth;
        viewWidth = mList.getWidth();
        FastScroller.ScrollFade scrollFade;
        scrollFade = mScrollFade;
        int alpha;
        alpha = -1;
        {
            alpha = scrollFade.getAlpha();
            {
                mThumbDrawable.setAlpha(alpha * 2);
            } //End block
            int left;
            left = 0;
            //Begin case View.SCROLLBAR_POSITION_DEFAULT View.SCROLLBAR_POSITION_RIGHT 
            left = viewWidth - (mThumbW * alpha) / ScrollFade.ALPHA_MAX;
            //End case View.SCROLLBAR_POSITION_DEFAULT View.SCROLLBAR_POSITION_RIGHT 
            //Begin case View.SCROLLBAR_POSITION_LEFT 
            left = -mThumbW + (mThumbW * alpha) / ScrollFade.ALPHA_MAX;
            //End case View.SCROLLBAR_POSITION_LEFT 
            mThumbDrawable.setBounds(left, 0, left + mThumbW, mThumbH);
            mChangedBounds = true;
        } //End block
        {
            Rect thumbBounds;
            thumbBounds = mThumbDrawable.getBounds();
            int left;
            left = thumbBounds.left;
            int halfThumbHeight;
            halfThumbHeight = (thumbBounds.bottom - thumbBounds.top) / 2;
            int trackWidth;
            trackWidth = mTrackDrawable.getIntrinsicWidth();
            int trackLeft;
            trackLeft = (left + mThumbW / 2) - trackWidth / 2;
            mTrackDrawable.setBounds(trackLeft, halfThumbHeight,
                    trackLeft + trackWidth, mList.getHeight() - halfThumbHeight);
            mTrackDrawable.draw(canvas);
        } //End block
        canvas.translate(0, y);
        mThumbDrawable.draw(canvas);
        canvas.translate(0, -y);
        {
            {
                int left;
                left = 0;
                //Begin case default View.SCROLLBAR_POSITION_DEFAULT View.SCROLLBAR_POSITION_RIGHT 
                left = Math.max(0,
                                mThumbDrawable.getBounds().left - mThumbW - mOverlaySize);
                //End case default View.SCROLLBAR_POSITION_DEFAULT View.SCROLLBAR_POSITION_RIGHT 
                //Begin case View.SCROLLBAR_POSITION_LEFT 
                left = Math.min(mThumbDrawable.getBounds().right + mThumbW,
                                mList.getWidth() - mOverlaySize);
                //End case View.SCROLLBAR_POSITION_LEFT 
                int top;
                top = Math.max(0,
                        Math.min(y + (mThumbH - mOverlaySize) / 2, mList.getHeight() - mOverlaySize));
                RectF pos;
                pos = mOverlayPos;
                pos.left = left;
                pos.right = pos.left + mOverlaySize;
                pos.top = top;
                pos.bottom = pos.top + mOverlaySize;
                {
                    mOverlayDrawable.setBounds((int) pos.left, (int) pos.top,
                            (int) pos.right, (int) pos.bottom);
                } //End block
            } //End block
            mOverlayDrawable.draw(canvas);
            Paint paint;
            paint = mPaint;
            float descent;
            descent = paint.descent();
            RectF rectF;
            rectF = mOverlayPos;
            Rect tmpRect;
            tmpRect = mTmpRect;
            mOverlayDrawable.getPadding(tmpRect);
            int hOff;
            hOff = (tmpRect.right - tmpRect.left) / 2;
            int vOff;
            vOff = (tmpRect.bottom - tmpRect.top) / 2;
            canvas.drawText(mSectionText, (int) (rectF.left + rectF.right) / 2 - hOff,
                    (int) (rectF.bottom + rectF.top) / 2 + mOverlaySize / 4 - descent - vOff,
                    paint);
        } //End block
        {
            {
                setState(STATE_NONE);
            } //End block
            {
                mList.invalidate(viewWidth - mThumbW, 0, viewWidth, mList.getHeight());
            } //End block
            {
                mList.invalidate(viewWidth - mThumbW, y, viewWidth, y + mThumbH);
            } //End block
        } //End block
        addTaint(canvas.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.892 -0400", hash_original_method = "E295B7FC2E9560F481D5875AE2ECD038", hash_generated_method = "841E3CA95DDD7B4CCB13EB614864CEB6")
     void onSizeChanged(int w, int h, int oldw, int oldh) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            //Begin case default View.SCROLLBAR_POSITION_DEFAULT View.SCROLLBAR_POSITION_RIGHT 
            mThumbDrawable.setBounds(w - mThumbW, 0, w, mThumbH);
            //End case default View.SCROLLBAR_POSITION_DEFAULT View.SCROLLBAR_POSITION_RIGHT 
            //Begin case View.SCROLLBAR_POSITION_LEFT 
            mThumbDrawable.setBounds(0, 0, mThumbW, mThumbH);
            //End case View.SCROLLBAR_POSITION_LEFT 
        } //End block
        {
            RectF pos;
            pos = mOverlayPos;
            pos.left = (w - mOverlaySize) / 2;
            pos.right = pos.left + mOverlaySize;
            pos.top = h / 10;
            pos.bottom = pos.top + mOverlaySize;
            {
                mOverlayDrawable.setBounds((int) pos.left, (int) pos.top,
                        (int) pos.right, (int) pos.bottom);
            } //End block
        } //End block
        addTaint(w);
        addTaint(h);
        addTaint(oldw);
        addTaint(oldh);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.900 -0400", hash_original_method = "33CBCEE809BB980D8FD69134B46323D0", hash_generated_method = "CBE8A31FA740CC2B251FBA33E3999D4C")
     void onItemCountChanged(int oldCount, int newCount) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            mLongList = true;
        } //End block
        addTaint(oldCount);
        addTaint(newCount);
        // ---------- Original Method ----------
        //if (mAlwaysShow) {
            //mLongList = true;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.902 -0400", hash_original_method = "E5B6E6440A22D0800FAD70BDC783A6AE", hash_generated_method = "39E39ECCE1EA581F12FF71D269997FFE")
     void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, 
            int totalItemCount) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            mItemCount = totalItemCount;
            mLongList = mItemCount / visibleItemCount >= MIN_PAGES;
        } //End block
        {
            mLongList = true;
        } //End block
        {
            {
                setState(STATE_NONE);
            } //End block
        } //End block
        {
            mThumbY = getThumbPositionForListPosition(firstVisibleItem, visibleItemCount,
                    totalItemCount);
            {
                resetThumbPos();
                mChangedBounds = false;
            } //End block
        } //End block
        mScrollCompleted = true;
        mVisibleItem = firstVisibleItem;
        {
            setState(STATE_VISIBLE);
            {
                mHandler.postDelayed(mScrollFade, FADE_TIMEOUT);
            } //End block
        } //End block
        addTaint(view.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.903 -0400", hash_original_method = "AD42D97439FFEC71F76D9E9B9EF1920A", hash_generated_method = "055ADDCDBEFD5CB857E7E124B4C1077B")
     SectionIndexer getSectionIndexer() {
        SectionIndexer varB4EAC82CA7396A68D541C85D26508E83_413756066 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_413756066 = mSectionIndexer;
        varB4EAC82CA7396A68D541C85D26508E83_413756066.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_413756066;
        // ---------- Original Method ----------
        //return mSectionIndexer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.904 -0400", hash_original_method = "0CD968054794DA4AF55762FEAC06E707", hash_generated_method = "89BC020376574400F31FF26888022B19")
     Object[] getSections() {
        Object[] varB4EAC82CA7396A68D541C85D26508E83_1216434106 = null; //Variable for return #1
        {
            getSectionsFromIndexer();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1216434106 = mSections;
        varB4EAC82CA7396A68D541C85D26508E83_1216434106.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1216434106;
        // ---------- Original Method ----------
        //if (mListAdapter == null && mList != null) {
            //getSectionsFromIndexer();
        //}
        //return mSections;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.912 -0400", hash_original_method = "800EB68723F3F3F4CE4E1BDE2BD8DC58", hash_generated_method = "9F4C51120EC6D22CCDC7EA269C0AC4D9")
     void getSectionsFromIndexer() {
        Adapter adapter;
        adapter = mList.getAdapter();
        mSectionIndexer = null;
        {
            mListOffset = ((HeaderViewListAdapter)adapter).getHeadersCount();
            adapter = ((HeaderViewListAdapter)adapter).getWrappedAdapter();
        } //End block
        {
            ExpandableListAdapter expAdapter;
            expAdapter = ((ExpandableListConnector)adapter).getAdapter();
            {
                mSectionIndexer = (SectionIndexer) expAdapter;
                mListAdapter = (BaseAdapter) adapter;
                mSections = mSectionIndexer.getSections();
            } //End block
        } //End block
        {
            {
                mListAdapter = (BaseAdapter) adapter;
                mSectionIndexer = (SectionIndexer) adapter;
                mSections = mSectionIndexer.getSections();
                {
                    mSections = new String[] { " " };
                } //End block
            } //End block
            {
                mListAdapter = (BaseAdapter) adapter;
                mSections = new String[] { " " };
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.913 -0400", hash_original_method = "B72F5DA2B803BA6E8807DBDDDB2D9463", hash_generated_method = "3DA083163E23080BFCF30DF5DB399931")
    public void onSectionsChanged() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mListAdapter = null;
        // ---------- Original Method ----------
        //mListAdapter = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.915 -0400", hash_original_method = "5A8E212F57F70A160B41013FFA05181F", hash_generated_method = "A273D71BDB9B71EF340CBB6D2FAD3697")
     void scrollTo(float position) {
        int count;
        count = mList.getCount();
        mScrollCompleted = false;
        float fThreshold;
        fThreshold = (1.0f / count) / 8;
        Object[] sections;
        sections = mSections;
        int sectionIndex;
        {
            int nSections;
            nSections = sections.length;
            int section;
            section = (int) (position * nSections);
            {
                section = nSections - 1;
            } //End block
            int exactSection;
            exactSection = section;
            sectionIndex = section;
            int index;
            index = mSectionIndexer.getPositionForSection(section);
            int nextIndex;
            nextIndex = count;
            int prevIndex;
            prevIndex = index;
            int prevSection;
            prevSection = section;
            int nextSection;
            nextSection = section + 1;
            {
                nextIndex = mSectionIndexer.getPositionForSection(section + 1);
            } //End block
            {
                {
                    prevIndex = mSectionIndexer.getPositionForSection(section);
                    {
                        prevSection = section;
                        sectionIndex = section;
                    } //End block
                    {
                        sectionIndex = 0;
                    } //End block
                } //End block
            } //End block
            int nextNextSection;
            nextNextSection = nextSection + 1;
            {
                boolean varBB2D3FB3AE20EB293998F7828EEA8D6B_750569170 = (nextNextSection < nSections &&
                    mSectionIndexer.getPositionForSection(nextNextSection) == nextIndex);
            } //End collapsed parenthetic
            float fPrev;
            fPrev = (float) prevSection / nSections;
            float fNext;
            fNext = (float) nextSection / nSections;
            {
                index = prevIndex;
            } //End block
            {
                index = prevIndex + (int) ((nextIndex - prevIndex) * (position - fPrev) 
                    / (fNext - fPrev));
            } //End block
            index = count - 1;
            {
                ExpandableListView expList;
                expList = (ExpandableListView) mList;
                expList.setSelectionFromTop(expList.getFlatListPosition(
                        ExpandableListView.getPackedPositionForGroup(index + mListOffset)), 0);
            } //End block
            {
                ((ListView)mList).setSelectionFromTop(index + mListOffset, 0);
            } //End block
            {
                mList.setSelection(index + mListOffset);
            } //End block
        } //End block
        {
            int index;
            index = (int) (position * count);
            index = count - 1;
            {
                ExpandableListView expList;
                expList = (ExpandableListView) mList;
                expList.setSelectionFromTop(expList.getFlatListPosition(
                        ExpandableListView.getPackedPositionForGroup(index + mListOffset)), 0);
            } //End block
            {
                ((ListView)mList).setSelectionFromTop(index + mListOffset, 0);
            } //End block
            {
                mList.setSelection(index + mListOffset);
            } //End block
            sectionIndex = -1;
        } //End block
        {
            String text;
            text = mSectionText = sections[sectionIndex].toString();
            mDrawOverlay = (text.length() != 1 || text.charAt(0) != ' ') &&
                    sectionIndex < sections.length;
        } //End block
        {
            mDrawOverlay = false;
        } //End block
        addTaint(position);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.934 -0400", hash_original_method = "5B13E30A0127E5E811D3308FC0C54801", hash_generated_method = "4197D4007A0565BF4BBFCBB11690C6EB")
    private int getThumbPositionForListPosition(int firstVisibleItem, int visibleItemCount,
            int totalItemCount) {
        {
            getSectionsFromIndexer();
        } //End block
        {
            int var9DBC44A6EBF4F17793F4C156235B003F_1222807220 = (((mList.getHeight() - mThumbH) * firstVisibleItem)
                    / (totalItemCount - visibleItemCount));
        } //End block
        firstVisibleItem -= mListOffset;
        totalItemCount -= mListOffset;
        int trackHeight;
        trackHeight = mList.getHeight() - mThumbH;
        int section;
        section = mSectionIndexer.getSectionForPosition(firstVisibleItem);
        int sectionPos;
        sectionPos = mSectionIndexer.getPositionForSection(section);
        int nextSectionPos;
        nextSectionPos = mSectionIndexer.getPositionForSection(section + 1);
        int sectionCount;
        sectionCount = mSections.length;
        int positionsInSection;
        positionsInSection = nextSectionPos - sectionPos;
        View child;
        child = mList.getChildAt(0);
        float incrementalPos;
        incrementalPos = 0;
        incrementalPos = firstVisibleItem +
                (float) (mList.getPaddingTop() - child.getTop()) / child.getHeight();
        float posWithinSection;
        posWithinSection = (incrementalPos - sectionPos) / positionsInSection;
        int result;
        result = (int) ((section + posWithinSection) / sectionCount * trackHeight);
        {
            View lastChild;
            lastChild = mList.getChildAt(visibleItemCount - 1);
            float lastItemVisible;
            lastItemVisible = (float) (mList.getHeight() - mList.getPaddingBottom()
                    - lastChild.getTop()) / lastChild.getHeight();
            result += (trackHeight - result) * lastItemVisible;
        } //End block
        addTaint(firstVisibleItem);
        addTaint(visibleItemCount);
        addTaint(totalItemCount);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_923505082 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_923505082;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.935 -0400", hash_original_method = "CEA01B9B754ED8848F89028F972B696F", hash_generated_method = "62A7CA02F03EB50FF40E5A304006CFEC")
    private void cancelFling() {
        MotionEvent cancelFling;
        cancelFling = MotionEvent.obtain(0, 0, MotionEvent.ACTION_CANCEL, 0, 0, 0);
        mList.onTouchEvent(cancelFling);
        cancelFling.recycle();
        // ---------- Original Method ----------
        //MotionEvent cancelFling = MotionEvent.obtain(0, 0, MotionEvent.ACTION_CANCEL, 0, 0, 0);
        //mList.onTouchEvent(cancelFling);
        //cancelFling.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.936 -0400", hash_original_method = "1BBF9FC05240D406AB082B75B38F8E40", hash_generated_method = "A17CF01D8897AFD0C2378D2D899955A1")
     void cancelPendingDrag() {
        mList.removeCallbacks(mDeferStartDrag);
        mPendingDrag = false;
        // ---------- Original Method ----------
        //mList.removeCallbacks(mDeferStartDrag);
        //mPendingDrag = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.936 -0400", hash_original_method = "DD628BE0DD3562FCAA0807D28A9AC0F6", hash_generated_method = "43BA3AD6A490FA6251BAC1E2C528E5CF")
     void startPendingDrag() {
        mPendingDrag = true;
        mList.postDelayed(mDeferStartDrag, PENDING_DRAG_DELAY);
        // ---------- Original Method ----------
        //mPendingDrag = true;
        //mList.postDelayed(mDeferStartDrag, PENDING_DRAG_DELAY);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.936 -0400", hash_original_method = "12EF9C1930DF387CC333A7C9F1E54726", hash_generated_method = "35D4DE833C677581785D47E702F2E832")
     void beginDrag() {
        setState(STATE_DRAGGING);
        {
            getSectionsFromIndexer();
        } //End block
        {
            mList.requestDisallowInterceptTouchEvent(true);
            mList.reportScrollStateChange(OnScrollListener.SCROLL_STATE_TOUCH_SCROLL);
        } //End block
        cancelFling();
        // ---------- Original Method ----------
        //setState(STATE_DRAGGING);
        //if (mListAdapter == null && mList != null) {
            //getSectionsFromIndexer();
        //}
        //if (mList != null) {
            //mList.requestDisallowInterceptTouchEvent(true);
            //mList.reportScrollStateChange(OnScrollListener.SCROLL_STATE_TOUCH_SCROLL);
        //}
        //cancelFling();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.937 -0400", hash_original_method = "D950A8D9B3AA1D87B11E428662FC0A13", hash_generated_method = "930F265BB42B80FEB5B56309B8A2AC4E")
     boolean onInterceptTouchEvent(MotionEvent ev) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            Object var74F259241399C7FD6DED5A7AA3E7383D_1514837763 = (ev.getActionMasked());
            //Begin case MotionEvent.ACTION_DOWN 
            {
                boolean varA956E413CCC396DCDE8A419D3081CEBC_564365323 = (mState > STATE_NONE && isPointInside(ev.getX(), ev.getY()));
                {
                    {
                        boolean var5F096BB9A8B8CA8FD2C7A33B3C25AF8F_1221825483 = (!mList.isInScrollingContainer());
                        {
                            beginDrag();
                        } //End block
                    } //End collapsed parenthetic
                    mInitialTouchY = ev.getY();
                    startPendingDrag();
                } //End block
            } //End collapsed parenthetic
            //End case MotionEvent.ACTION_DOWN 
            //Begin case MotionEvent.ACTION_UP MotionEvent.ACTION_CANCEL 
            cancelPendingDrag();
            //End case MotionEvent.ACTION_UP MotionEvent.ACTION_CANCEL 
        } //End collapsed parenthetic
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1669600323 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1669600323;
        // ---------- Original Method ----------
        //switch (ev.getActionMasked()) {
            //case MotionEvent.ACTION_DOWN:
                //if (mState > STATE_NONE && isPointInside(ev.getX(), ev.getY())) {
                    //if (!mList.isInScrollingContainer()) {
                        //beginDrag();
                        //return true;
                    //}
                    //mInitialTouchY = ev.getY();
                    //startPendingDrag();
                //}
                //break;
            //case MotionEvent.ACTION_UP:
            //case MotionEvent.ACTION_CANCEL:
                //cancelPendingDrag();
                //break;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.950 -0400", hash_original_method = "891E4A8523ECAE5B8AA3233AF8AC2D21", hash_generated_method = "A013E36385804342A09B1A6310082235")
     boolean onTouchEvent(MotionEvent me) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        int action;
        action = me.getAction();
        {
            {
                boolean var4CB4F6C2F788DDF9D1F357233A0B0645_766354036 = (isPointInside(me.getX(), me.getY()));
                {
                    {
                        boolean var5F096BB9A8B8CA8FD2C7A33B3C25AF8F_1442397072 = (!mList.isInScrollingContainer());
                        {
                            beginDrag();
                        } //End block
                    } //End collapsed parenthetic
                    mInitialTouchY = me.getY();
                    startPendingDrag();
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                beginDrag();
                int viewHeight;
                viewHeight = mList.getHeight();
                int newThumbY;
                newThumbY = (int) me.getY() - mThumbH + 10;
                {
                    newThumbY = 0;
                } //End block
                {
                    newThumbY = viewHeight - mThumbH;
                } //End block
                mThumbY = newThumbY;
                scrollTo((float) mThumbY / (viewHeight - mThumbH));
                cancelPendingDrag();
            } //End block
            {
                {
                    mList.requestDisallowInterceptTouchEvent(false);
                    mList.reportScrollStateChange(OnScrollListener.SCROLL_STATE_IDLE);
                } //End block
                setState(STATE_VISIBLE);
                Handler handler;
                handler = mHandler;
                handler.removeCallbacks(mScrollFade);
                {
                    handler.postDelayed(mScrollFade, 1000);
                } //End block
                mList.invalidate();
            } //End block
        } //End block
        {
            {
                float y;
                y = me.getY();
                {
                    boolean var57D155B745B41B70666C3C0DB25BDA45_1810386923 = (Math.abs(y - mInitialTouchY) > mScaledTouchSlop);
                    {
                        setState(STATE_DRAGGING);
                        {
                            getSectionsFromIndexer();
                        } //End block
                        {
                            mList.requestDisallowInterceptTouchEvent(true);
                            mList.reportScrollStateChange(OnScrollListener.SCROLL_STATE_TOUCH_SCROLL);
                        } //End block
                        cancelFling();
                        cancelPendingDrag();
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                int viewHeight;
                viewHeight = mList.getHeight();
                int newThumbY;
                newThumbY = (int) me.getY() - mThumbH + 10;
                {
                    newThumbY = 0;
                } //End block
                {
                    newThumbY = viewHeight - mThumbH;
                } //End block
                {
                    boolean varF809D69832046C315D14C292FA46A81C_1241918626 = (Math.abs(mThumbY - newThumbY) < 2);
                } //End collapsed parenthetic
                mThumbY = newThumbY;
                {
                    scrollTo((float) mThumbY / (viewHeight - mThumbH));
                } //End block
            } //End block
        } //End block
        {
            cancelPendingDrag();
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2147344608 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2147344608;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.951 -0400", hash_original_method = "4AFF55C64BD9939BD0E5A83378980FDE", hash_generated_method = "AF90D189DAC668D998F5C8D8D4AFFFE1")
     boolean isPointInside(float x, float y) {
        boolean inTrack;
        inTrack = false;
        //Begin case default View.SCROLLBAR_POSITION_DEFAULT View.SCROLLBAR_POSITION_RIGHT 
        inTrack = x > mList.getWidth() - mThumbW;
        //End case default View.SCROLLBAR_POSITION_DEFAULT View.SCROLLBAR_POSITION_RIGHT 
        //Begin case View.SCROLLBAR_POSITION_LEFT 
        inTrack = x < mThumbW;
        //End case View.SCROLLBAR_POSITION_LEFT 
        addTaint(x);
        addTaint(y);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_563595123 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_563595123;
        // ---------- Original Method ----------
        //boolean inTrack = false;
        //switch (mPosition) {
            //default:
            //case View.SCROLLBAR_POSITION_DEFAULT:
            //case View.SCROLLBAR_POSITION_RIGHT:
                //inTrack = x > mList.getWidth() - mThumbW;
                //break;
            //case View.SCROLLBAR_POSITION_LEFT:
                //inTrack = x < mThumbW;
                //break;
        //}
        //return inTrack && (mTrackDrawable != null || y >= mThumbY && y <= mThumbY + mThumbH);
    }

    
    public class ScrollFade implements Runnable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.951 -0400", hash_original_field = "4FBE52F16DA5DC1AFB86B1520E59C2C0", hash_generated_field = "3C3A30DDD94D9D47CBB52C3848791CE7")

        long mStartTime;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.951 -0400", hash_original_field = "0977CB9901C7FDBEBE15F5CF669E7868", hash_generated_field = "307FFDDA4C0E2DF961BB56499DC85520")

        long mFadeDuration;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.951 -0400", hash_original_method = "5D305A44C44DBEE04C6A110139796128", hash_generated_method = "5D305A44C44DBEE04C6A110139796128")
        public ScrollFade ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.964 -0400", hash_original_method = "C2CB87B9E1EBFB96BF37E1CA2A1422A5", hash_generated_method = "19230DB05151B9744467D8C099CFC776")
         void startFade() {
            mFadeDuration = FADE_DURATION;
            mStartTime = SystemClock.uptimeMillis();
            setState(STATE_EXIT);
            // ---------- Original Method ----------
            //mFadeDuration = FADE_DURATION;
            //mStartTime = SystemClock.uptimeMillis();
            //setState(STATE_EXIT);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.965 -0400", hash_original_method = "AFB48DA784BE880095A4465F927D06A4", hash_generated_method = "61A2E6E4E2FEFDF06B0599E4877F20B2")
         int getAlpha() {
            {
                boolean var18C99A1467A5E28EFE0461A6C774AF80_1367895331 = (getState() != STATE_EXIT);
            } //End collapsed parenthetic
            int alpha;
            long now;
            now = SystemClock.uptimeMillis();
            {
                alpha = 0;
            } //End block
            {
                alpha = (int) (ALPHA_MAX - ((now - mStartTime) * ALPHA_MAX) / mFadeDuration);
            } //End block
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_380664622 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_380664622;
            // ---------- Original Method ----------
            //if (getState() != STATE_EXIT) {
                //return ALPHA_MAX;
            //}
            //int alpha;
            //long now = SystemClock.uptimeMillis();
            //if (now > mStartTime + mFadeDuration) {
                //alpha = 0;
            //} else {
                //alpha = (int) (ALPHA_MAX - ((now - mStartTime) * ALPHA_MAX) / mFadeDuration); 
            //}
            //return alpha;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.965 -0400", hash_original_method = "3A2ADC6F19B17BA5C164F36207FFFC0C", hash_generated_method = "0F678205D2E7C5345937B8288338295F")
        public void run() {
            {
                boolean var18C99A1467A5E28EFE0461A6C774AF80_60538003 = (getState() != STATE_EXIT);
                {
                    startFade();
                } //End block
            } //End collapsed parenthetic
            {
                boolean var6703FBB521765E4D7F8ABFF437383AC8_139868799 = (getAlpha() > 0);
                {
                    mList.invalidate();
                } //End block
                {
                    setState(STATE_NONE);
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //if (getState() != STATE_EXIT) {
                //startFade();
                //return;
            //}
            //if (getAlpha() > 0) {
                //mList.invalidate();
            //} else {
                //setState(STATE_NONE);
            //}
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.965 -0400", hash_original_field = "0002AE9BD831451136433D593FBEF110", hash_generated_field = "3151A8A77F1440624D4112475BE39DB0")

        static int ALPHA_MAX = 208;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.965 -0400", hash_original_field = "5427C149FA3D3269A4036F1A93D514B4", hash_generated_field = "73FB2AFBF783B6E31F6E0853764716C7")

        static long FADE_DURATION = 200;
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.965 -0400", hash_original_field = "6EBA16D4C98F0B19A3CECDE33C2D26F4", hash_generated_field = "037EECB8BEBB6DC683240D6072472716")

    private static String TAG = "FastScroller";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.965 -0400", hash_original_field = "B8457D6D61D7235FF81BF2C3B3C4C56F", hash_generated_field = "2194CAD343A1944040469192DE6A0DCB")

    private static int MIN_PAGES = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.966 -0400", hash_original_field = "E27A9C09B487354949B5B9D78B051E67", hash_generated_field = "EB441105CABE2E3BCE12C7AB439C18A4")

    private static int STATE_NONE = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.966 -0400", hash_original_field = "8C314C59EA3BAB88330FAD0167172B92", hash_generated_field = "7E71B0BEF45CD0132C523884E8D99FFA")

    private static int STATE_ENTER = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.966 -0400", hash_original_field = "D6DA4032193ED5272EEAD0F9FE106A91", hash_generated_field = "9453F3F942CB4667BDCC8565C5A8F665")

    private static int STATE_VISIBLE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.966 -0400", hash_original_field = "DE0F929053552C903832AF3817135453", hash_generated_field = "B6554DA93A3AF2F493806577E8B201E2")

    private static int STATE_DRAGGING = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.966 -0400", hash_original_field = "1BF196AA5CA5C9151177E169696885DA", hash_generated_field = "DDFADA5EC37961E151B27113777D0C5F")

    private static int STATE_EXIT = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.966 -0400", hash_original_field = "57BA94A965001B589D71838C0B318B28", hash_generated_field = "AB10ADA1549362D04EB89CCE3D3C0CC5")

    private static int[] PRESSED_STATES = new int[] {
        android.R.attr.state_pressed
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.966 -0400", hash_original_field = "8A6F1AFD3C662EACD16AB85697E1F117", hash_generated_field = "23233E504C3B0A657917DE4FA1E2691B")

    private static int[] DEFAULT_STATES = new int[0];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.966 -0400", hash_original_field = "72C442925745EFC5792F94523ABD1AB2", hash_generated_field = "382368BEAA639FC3B0FE7B83AD68DAD7")

    private static int[] ATTRS = new int[] {
        android.R.attr.fastScrollTextColor,
        android.R.attr.fastScrollThumbDrawable,
        android.R.attr.fastScrollTrackDrawable,
        android.R.attr.fastScrollPreviewBackgroundLeft,
        android.R.attr.fastScrollPreviewBackgroundRight,
        android.R.attr.fastScrollOverlayPosition
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.966 -0400", hash_original_field = "CA4C0713CBE2C71C5C492833440E804E", hash_generated_field = "3DE7028EA68B4D985CB99D0B7F108C5A")

    private static int TEXT_COLOR = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.966 -0400", hash_original_field = "CF11DBD300F4A144C8DDC2642B04C398", hash_generated_field = "1F986FAB08BC2B7D473722354D8F5352")

    private static int THUMB_DRAWABLE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.966 -0400", hash_original_field = "141F08F999F6766770CB46EF0A74949B", hash_generated_field = "F72F65F564BD84300E6446B8CBC6E007")

    private static int TRACK_DRAWABLE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.966 -0400", hash_original_field = "D37CF1E9A45D3A94963A4EABD45A651C", hash_generated_field = "A8FAD5DC35003889EA03A7249ACE9D5E")

    private static int PREVIEW_BACKGROUND_LEFT = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.966 -0400", hash_original_field = "6D2E3120428688CDC1966FE43544FD29", hash_generated_field = "2990D434D4436E9B77205ABB3BF066E3")

    private static int PREVIEW_BACKGROUND_RIGHT = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.966 -0400", hash_original_field = "24A8BF5F2A62B5AEB2FC7D05A00E67A0", hash_generated_field = "C0044D0DFAA6D0AE91738C76C5C60509")

    private static int OVERLAY_POSITION = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.966 -0400", hash_original_field = "7F0D318487A3CBF95BDDF44FC50E1634", hash_generated_field = "43064283CFC50F58FE578305EC07C29F")

    private static int OVERLAY_FLOATING = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.966 -0400", hash_original_field = "96C00FF9468970A6B914DE0570C5AF9A", hash_generated_field = "DA50CE1C6B14D47B844B87048EBE6026")

    private static int OVERLAY_AT_THUMB = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.966 -0400", hash_original_field = "5B00A14F745BD76B5A30CD9C5D66BD81", hash_generated_field = "444B56F88F6B91A961D376A066D3E29E")

    private static int FADE_TIMEOUT = 1500;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.966 -0400", hash_original_field = "54B3E19B78CDC50A499DF91E4E7BB300", hash_generated_field = "01146273A55CD3497FCC7E155667905A")

    private static int PENDING_DRAG_DELAY = 180;
}

