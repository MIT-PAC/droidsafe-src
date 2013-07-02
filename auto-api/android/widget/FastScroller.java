package android.widget;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.852 -0400", hash_original_field = "E4F0AC5F69FC7254EF772878E84BE9AD", hash_generated_field = "723113CD58F6B081A7D304DE131200C0")

    private Drawable mThumbDrawable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.852 -0400", hash_original_field = "FA8E2671094A1E8D3FF3671EC8F8C2EC", hash_generated_field = "C4F6607BE177BD0C551FFF72CB52709D")

    private Drawable mOverlayDrawable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.852 -0400", hash_original_field = "25A0A5DB31F18B827384634F1DF122D7", hash_generated_field = "95BC711301E78A9ECDB61E242B32BBFC")

    private Drawable mTrackDrawable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.852 -0400", hash_original_field = "56AD3C9E331C06765B4A3FAE13009CC1", hash_generated_field = "3F431D8A9EEFA832E40733D030288C4E")

    private Drawable mOverlayDrawableLeft;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.852 -0400", hash_original_field = "6F789E34E679B1AB90E2061F47AF7BFC", hash_generated_field = "CBEF23D76FD5E642BD307BDCC6E254DC")

    private Drawable mOverlayDrawableRight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.852 -0400", hash_original_field = "2D9918C395C4B2BA3612AD222BCC7CBE", hash_generated_field = "3D6BD301AD11E22B2417B343C44F938F")

    int mThumbH;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.852 -0400", hash_original_field = "EF5497FDB3AFB7DB29B7861C625072A7", hash_generated_field = "DCE6651DC2A97578BDBD4F73CA2A9123")

    int mThumbW;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.852 -0400", hash_original_field = "02B58672B21A07183055AAD51D46B0B3", hash_generated_field = "3E4FAF8454C2C912B7626021FE9AF353")

    int mThumbY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.852 -0400", hash_original_field = "D0A39E96B88B96626E240F88FAC8ACE2", hash_generated_field = "652CA9CCF5547E5517E87FEB493C682F")

    private RectF mOverlayPos;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.852 -0400", hash_original_field = "C6AC2A64803A7F25EDC241C13EA8E5BB", hash_generated_field = "CF4608DD9AF6C21FCFF4CAB07660E9AC")

    private int mOverlaySize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.852 -0400", hash_original_field = "F796A16BE866311501B24C73148D80F1", hash_generated_field = "8DE3CD4C54B5C114BFFFAF8D6B3834ED")

    AbsListView mList;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.852 -0400", hash_original_field = "E84622B86B2732A4CCC462C11B32EF8D", hash_generated_field = "F80BE66A40916AFE64128A97287351B5")

    boolean mScrollCompleted;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.852 -0400", hash_original_field = "3C2340F71EE076A080607C138E0B206C", hash_generated_field = "2B767EF4AB0ACDA9AD9957D0EE99C88B")

    private int mVisibleItem;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.852 -0400", hash_original_field = "78E27F80AC0100441F897783EFA42851", hash_generated_field = "75BCEEBE83B26919B33E8EA8B289919E")

    private Paint mPaint;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.852 -0400", hash_original_field = "AC3BBF4B2D74729446FCB47B162AE3ED", hash_generated_field = "74A1AC6BAAFB1602514EDA87DF3F165A")

    private int mListOffset;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.852 -0400", hash_original_field = "7AA3C8F5F81D9ECD18129B12222725EE", hash_generated_field = "7633D41B58955728937D8CC0DB2694BE")

    private int mItemCount = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.852 -0400", hash_original_field = "C957CDFB9EFF169FA6B098E5D3472F01", hash_generated_field = "74C6663E6FE3B64B12C20186C73689BE")

    private boolean mLongList;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.852 -0400", hash_original_field = "5499B299E8C9CF2E47AEAACF55FB80F8", hash_generated_field = "E10BB9F3460B91FF78086EFA996A0114")

    private Object [] mSections;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.852 -0400", hash_original_field = "F8807952632DA2BFEA5E1C98363B7657", hash_generated_field = "8F91F071959F5E46C9D858D712A42531")

    private String mSectionText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.852 -0400", hash_original_field = "BB8B2F4E60C278348EA370446EADF234", hash_generated_field = "66337501372B93428A3E0DCFBCAA8A4D")

    private boolean mDrawOverlay;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.852 -0400", hash_original_field = "BC14E51C6A4BF76998F27D1BA0D148A7", hash_generated_field = "C5CC7DBEDDDE3933C75D287B3954EC80")

    private ScrollFade mScrollFade;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.852 -0400", hash_original_field = "48A902C1D749B47EBC75C77370D5A1F0", hash_generated_field = "19B55F2750B971E6310D64ADB9B2D0CF")

    private int mState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.852 -0400", hash_original_field = "6781893E9FA50A9B7103FD3F674E566B", hash_generated_field = "2E60E17486AAEB1A4E1F1878A0354061")

    private Handler mHandler = new Handler();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.852 -0400", hash_original_field = "B8EAD9E776B81483E5E8A661601F6AA8", hash_generated_field = "33273F8B8EE0B442CE373E963CE812B8")

    BaseAdapter mListAdapter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.852 -0400", hash_original_field = "7F7BC677896D04A978C7A4DB016F6E9E", hash_generated_field = "993A155558E830738166022FC5D1A65D")

    private SectionIndexer mSectionIndexer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.852 -0400", hash_original_field = "2425089C9D38CD13382E0B0290A580FB", hash_generated_field = "54BB6C7E624546A679D88F2CE6A36CC3")

    private boolean mChangedBounds;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.852 -0400", hash_original_field = "2A02BDE12D932CD9DCA97106D487F8F5", hash_generated_field = "D614AE7D1AAE0276EA05A974DCBF0210")

    private int mPosition;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.852 -0400", hash_original_field = "D8301B9D37BE0AB158BABDD736CFE57D", hash_generated_field = "1013EB9EDD9A15A8ED84F490CA1C5ACA")

    private boolean mAlwaysShow;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.852 -0400", hash_original_field = "7FEB639EAB58078B983A7FDB8F55A63B", hash_generated_field = "818199C64E5FB571F9E3F2622DF96D7E")

    private int mOverlayPosition;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.852 -0400", hash_original_field = "92CD80C13C1AC935197D48655FE89951", hash_generated_field = "6A99D75E2A8444FF7C66E9499447E446")

    private boolean mMatchDragPosition;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.852 -0400", hash_original_field = "15F34BDDAE4312237D3D605D7D9FA68D", hash_generated_field = "A2E2E464E467FCA571530A8485FFA938")

    float mInitialTouchY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.852 -0400", hash_original_field = "484EC5A8F86FD2AD413186C1D2DBCBE9", hash_generated_field = "A31D9AE99DECC41BA4A47D3E5C2BD2CA")

    boolean mPendingDrag;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.852 -0400", hash_original_field = "007A72391FE679B54C8CDBD6A79A1E3F", hash_generated_field = "A6018E4F8C21D3EE961380A6D74CC7E0")

    private int mScaledTouchSlop;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.853 -0400", hash_original_field = "C16522492B0457D64CB22178541F3ACA", hash_generated_field = "570061BA9CB059462550E9BCCD2A0735")

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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.853 -0400", hash_original_method = "A2A2A1F0C9639ECE9FE84AFC4D4D3A80", hash_generated_method = "2E544D1E97215E1EE92E48CE527EFB33")
    public  FastScroller(Context context, AbsListView listView) {
        mList = listView;
        init(context);
        addTaint(context.getTaint());
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.854 -0400", hash_original_method = "39D93CA5552A2245B487796C83EA3A2C", hash_generated_method = "8514F207357119F1B336448F7E608BBF")
    public void setAlwaysShow(boolean alwaysShow) {
        mAlwaysShow = alwaysShow;
        {
            mHandler.removeCallbacks(mScrollFade);
            setState(STATE_VISIBLE);
        } 
        {
            mHandler.postDelayed(mScrollFade, FADE_TIMEOUT);
        } 
        
        
        
            
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.854 -0400", hash_original_method = "FE4F6BFF00D7A9534103DEC6DDA5B37C", hash_generated_method = "63171B427C1EC742CA8B6EAC354C5A1C")
    public boolean isAlwaysShowEnabled() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1942855534 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1942855534;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.854 -0400", hash_original_method = "8A07D5E4DE8CD170DC3BFC9FE8A30504", hash_generated_method = "C8B01E20FF9A04374BBE1228ED9BDCC5")
    private void refreshDrawableState() {
        int[] state;
        state = PRESSED_STATES;
        state = DEFAULT_STATES;
        {
            boolean varFFD0D4700603A30109E1419E6751DAC5_815689958 = (mThumbDrawable != null && mThumbDrawable.isStateful());
            {
                mThumbDrawable.setState(state);
            } 
        } 
        {
            boolean var186A66CF4AFBB431FA0AA3F444BEC0A2_1550180972 = (mTrackDrawable != null && mTrackDrawable.isStateful());
            {
                mTrackDrawable.setState(state);
            } 
        } 
        
        
        
            
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.855 -0400", hash_original_method = "4A2BCFB2C4534D1665C92142AF186787", hash_generated_method = "92B1C33A8159587A6DA748D5DA5E8540")
    public void setScrollbarPosition(int position) {
        mPosition = position;
        
        mOverlayDrawable = mOverlayDrawableRight;
        
        
        mOverlayDrawable = mOverlayDrawableLeft;
        
        
        
        
            
            
            
                
                
            
                
                
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.855 -0400", hash_original_method = "B47561E95C2F1E64B16085B75AB60280", hash_generated_method = "88E2E27840031F6F181A25BE2411B612")
    public int getWidth() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_131080781 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_131080781;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.855 -0400", hash_original_method = "FD0548A7869DD54F34FB4A98FCCC10E9", hash_generated_method = "2E1265B52C2BFFD31AEDF810662BF912")
    public void setState(int state) {
        
        mHandler.removeCallbacks(mScrollFade);
        
        
        mList.invalidate();
        
        
        {
            resetThumbPos();
        } 
        
        
        mHandler.removeCallbacks(mScrollFade);
        
        
        int viewWidth = mList.getWidth();
        
        
        mList.invalidate(viewWidth - mThumbW, mThumbY, viewWidth, mThumbY + mThumbH);
        
        mState = state;
        refreshDrawableState();
        
        
            
                
                
                
            
                
                    
                
            
                
                
            
                
                
                
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.856 -0400", hash_original_method = "10E9373648D5DF4EE43B4904732E3886", hash_generated_method = "FFF627CE8796638F7E59F341ED538F40")
    public int getState() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1486650382 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1486650382;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.856 -0400", hash_original_method = "C32E62B08B27A384339E1BC75CFE4552", hash_generated_method = "C22F2240903A802A5C457B10F026EE7C")
    private void resetThumbPos() {
        final int viewWidth = mList.getWidth();
        
        mThumbDrawable.setBounds(viewWidth - mThumbW, 0, viewWidth, mThumbH);
        
        
        mThumbDrawable.setBounds(0, 0, mThumbW, mThumbH);
        
        mThumbDrawable.setAlpha(ScrollFade.ALPHA_MAX);
        
        
        
            
            
                
                
            
                
                
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.857 -0400", hash_original_method = "5C6D13F417D5AA8E0A1553C57F0CD3F0", hash_generated_method = "D822EB46DED61EE27CAFB88FDA15052A")
    private void useThumbDrawable(Context context, Drawable drawable) {
        mThumbDrawable = drawable;
        {
            mThumbW = context.getResources().getDimensionPixelSize(
                    com.android.internal.R.dimen.fastscroll_thumb_width);
            mThumbH = context.getResources().getDimensionPixelSize(
                    com.android.internal.R.dimen.fastscroll_thumb_height);
        } 
        {
            mThumbW = drawable.getIntrinsicWidth();
            mThumbH = drawable.getIntrinsicHeight();
        } 
        mChangedBounds = true;
        
        
        
            
                    
            
                    
        
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.858 -0400", hash_original_method = "0A57524C8928F6FDE971C9B9E9D3463C", hash_generated_method = "1B53F22650C821028BB536B98806936D")
    private void init(Context context) {
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
        {
            boolean var0E9C0EBA61F05B4437A59B11FFE8A9DF_1196224574 = (mList.getWidth() > 0 && mList.getHeight() > 0);
            {
                onSizeChanged(mList.getWidth(), mList.getHeight(), 0, 0);
            } 
        } 
        mState = STATE_NONE;
        refreshDrawableState();
        ta.recycle();
        mScaledTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        mMatchDragPosition = context.getApplicationInfo().targetSdkVersion >=
                android.os.Build.VERSION_CODES.HONEYCOMB;
        setScrollbarPosition(mList.getVerticalScrollbarPosition());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.858 -0400", hash_original_method = "056243A841F0EC691D28BA5422CDF65B", hash_generated_method = "CFE1ED30A07D3814D31EDD1FE0EF553E")
     void stop() {
        setState(STATE_NONE);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.858 -0400", hash_original_method = "DC69F15A6278F37206902D3451EB4A27", hash_generated_method = "A574900C9092F1C3542AFD9F6D9CBD1B")
     boolean isVisible() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1107060791 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1107060791;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.860 -0400", hash_original_method = "C51EC11284E4C57CA49569FFECEAA05A", hash_generated_method = "F75DB694EE5477981613F4DA473B4B06")
    public void draw(Canvas canvas) {
        final int y = mThumbY;
        final int viewWidth = mList.getWidth();
        final FastScroller.ScrollFade scrollFade = mScrollFade;
        int alpha = -1;
        {
            alpha = scrollFade.getAlpha();
            {
                mThumbDrawable.setAlpha(alpha * 2);
            } 
            int left = 0;
            
            left = viewWidth - (mThumbW * alpha) / ScrollFade.ALPHA_MAX;
            
            
            left = -mThumbW + (mThumbW * alpha) / ScrollFade.ALPHA_MAX;
            
            mThumbDrawable.setBounds(left, 0, left + mThumbW, mThumbH);
            mChangedBounds = true;
        } 
        {
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
        {
            {
                int left = 0;
                
                left = Math.max(0,
                                mThumbDrawable.getBounds().left - mThumbW - mOverlaySize);
                
                
                left = Math.min(mThumbDrawable.getBounds().right + mThumbW,
                                mList.getWidth() - mOverlaySize);
                
                int top = Math.max(0,
                        Math.min(y + (mThumbH - mOverlaySize) / 2, mList.getHeight() - mOverlaySize));
                final RectF pos = mOverlayPos;
                pos.left = left;
                pos.right = pos.left + mOverlaySize;
                pos.top = top;
                pos.bottom = pos.top + mOverlaySize;
                {
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
        } 
        {
            {
                setState(STATE_NONE);
            } 
            {
                mList.invalidate(viewWidth - mThumbW, 0, viewWidth, mList.getHeight());
            } 
            {
                mList.invalidate(viewWidth - mThumbW, y, viewWidth, y + mThumbH);
            } 
        } 
        addTaint(canvas.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.860 -0400", hash_original_method = "E295B7FC2E9560F481D5875AE2ECD038", hash_generated_method = "A298A030D0E26B87AF6BE14DD07A104A")
     void onSizeChanged(int w, int h, int oldw, int oldh) {
        
        {
            
            mThumbDrawable.setBounds(w - mThumbW, 0, w, mThumbH);
            
            
            mThumbDrawable.setBounds(0, 0, mThumbW, mThumbH);
            
        } 
        {
            final RectF pos = mOverlayPos;
            pos.left = (w - mOverlaySize) / 2;
            pos.right = pos.left + mOverlaySize;
            pos.top = h / 10;
            pos.bottom = pos.top + mOverlaySize;
            {
                mOverlayDrawable.setBounds((int) pos.left, (int) pos.top,
                        (int) pos.right, (int) pos.bottom);
            } 
        } 
        addTaint(w);
        addTaint(h);
        addTaint(oldw);
        addTaint(oldh);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.861 -0400", hash_original_method = "33CBCEE809BB980D8FD69134B46323D0", hash_generated_method = "CBE8A31FA740CC2B251FBA33E3999D4C")
     void onItemCountChanged(int oldCount, int newCount) {
        
        {
            mLongList = true;
        } 
        addTaint(oldCount);
        addTaint(newCount);
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.861 -0400", hash_original_method = "E5B6E6440A22D0800FAD70BDC783A6AE", hash_generated_method = "39E39ECCE1EA581F12FF71D269997FFE")
     void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, 
            int totalItemCount) {
        
        {
            mItemCount = totalItemCount;
            mLongList = mItemCount / visibleItemCount >= MIN_PAGES;
        } 
        {
            mLongList = true;
        } 
        {
            {
                setState(STATE_NONE);
            } 
        } 
        {
            mThumbY = getThumbPositionForListPosition(firstVisibleItem, visibleItemCount,
                    totalItemCount);
            {
                resetThumbPos();
                mChangedBounds = false;
            } 
        } 
        mScrollCompleted = true;
        mVisibleItem = firstVisibleItem;
        {
            setState(STATE_VISIBLE);
            {
                mHandler.postDelayed(mScrollFade, FADE_TIMEOUT);
            } 
        } 
        addTaint(view.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.862 -0400", hash_original_method = "AD42D97439FFEC71F76D9E9B9EF1920A", hash_generated_method = "E9E14B4BBEEF117AB13ED18EACE25F35")
     SectionIndexer getSectionIndexer() {
        SectionIndexer varB4EAC82CA7396A68D541C85D26508E83_1575190949 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1575190949 = mSectionIndexer;
        varB4EAC82CA7396A68D541C85D26508E83_1575190949.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1575190949;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.862 -0400", hash_original_method = "0CD968054794DA4AF55762FEAC06E707", hash_generated_method = "F38D06BE2125436BA71EC36897ACB33F")
     Object[] getSections() {
        Object[] varB4EAC82CA7396A68D541C85D26508E83_1222439687 = null; 
        {
            getSectionsFromIndexer();
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1222439687 = mSections;
        varB4EAC82CA7396A68D541C85D26508E83_1222439687.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1222439687;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.863 -0400", hash_original_method = "800EB68723F3F3F4CE4E1BDE2BD8DC58", hash_generated_method = "B5F95F03320C9CAA8B815DC872257AC0")
     void getSectionsFromIndexer() {
        Adapter adapter = mList.getAdapter();
        mSectionIndexer = null;
        {
            mListOffset = ((HeaderViewListAdapter)adapter).getHeadersCount();
            adapter = ((HeaderViewListAdapter)adapter).getWrappedAdapter();
        } 
        {
            ExpandableListAdapter expAdapter = ((ExpandableListConnector)adapter).getAdapter();
            {
                mSectionIndexer = (SectionIndexer) expAdapter;
                mListAdapter = (BaseAdapter) adapter;
                mSections = mSectionIndexer.getSections();
            } 
        } 
        {
            {
                mListAdapter = (BaseAdapter) adapter;
                mSectionIndexer = (SectionIndexer) adapter;
                mSections = mSectionIndexer.getSections();
                {
                    mSections = new String[] { " " };
                } 
            } 
            {
                mListAdapter = (BaseAdapter) adapter;
                mSections = new String[] { " " };
            } 
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.863 -0400", hash_original_method = "B72F5DA2B803BA6E8807DBDDDB2D9463", hash_generated_method = "3DA083163E23080BFCF30DF5DB399931")
    public void onSectionsChanged() {
        
        mListAdapter = null;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.865 -0400", hash_original_method = "5A8E212F57F70A160B41013FFA05181F", hash_generated_method = "FFCDDA6F221BA2604D3964078074A9AB")
     void scrollTo(float position) {
        int count = mList.getCount();
        mScrollCompleted = false;
        float fThreshold = (1.0f / count) / 8;
        final Object[] sections = mSections;
        int sectionIndex;
        {
            final int nSections = sections.length;
            int section = (int) (position * nSections);
            {
                section = nSections - 1;
            } 
            int exactSection = section;
            sectionIndex = section;
            int index = mSectionIndexer.getPositionForSection(section);
            int nextIndex = count;
            int prevIndex = index;
            int prevSection = section;
            int nextSection = section + 1;
            {
                nextIndex = mSectionIndexer.getPositionForSection(section + 1);
            } 
            {
                {
                    prevIndex = mSectionIndexer.getPositionForSection(section);
                    {
                        prevSection = section;
                        sectionIndex = section;
                    } 
                    {
                        sectionIndex = 0;
                    } 
                } 
            } 
            int nextNextSection = nextSection + 1;
            {
                boolean varBB2D3FB3AE20EB293998F7828EEA8D6B_1773121861 = (nextNextSection < nSections &&
                    mSectionIndexer.getPositionForSection(nextNextSection) == nextIndex);
            } 
            float fPrev = (float) prevSection / nSections;
            float fNext = (float) nextSection / nSections;
            {
                index = prevIndex;
            } 
            {
                index = prevIndex + (int) ((nextIndex - prevIndex) * (position - fPrev) 
                    / (fNext - fPrev));
            } 
            index = count - 1;
            {
                ExpandableListView expList = (ExpandableListView) mList;
                expList.setSelectionFromTop(expList.getFlatListPosition(
                        ExpandableListView.getPackedPositionForGroup(index + mListOffset)), 0);
            } 
            {
                ((ListView)mList).setSelectionFromTop(index + mListOffset, 0);
            } 
            {
                mList.setSelection(index + mListOffset);
            } 
        } 
        {
            int index = (int) (position * count);
            index = count - 1;
            {
                ExpandableListView expList = (ExpandableListView) mList;
                expList.setSelectionFromTop(expList.getFlatListPosition(
                        ExpandableListView.getPackedPositionForGroup(index + mListOffset)), 0);
            } 
            {
                ((ListView)mList).setSelectionFromTop(index + mListOffset, 0);
            } 
            {
                mList.setSelection(index + mListOffset);
            } 
            sectionIndex = -1;
        } 
        {
            String text = mSectionText = sections[sectionIndex].toString();
            mDrawOverlay = (text.length() != 1 || text.charAt(0) != ' ') &&
                    sectionIndex < sections.length;
        } 
        {
            mDrawOverlay = false;
        } 
        addTaint(position);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.866 -0400", hash_original_method = "5B13E30A0127E5E811D3308FC0C54801", hash_generated_method = "1B3AAD88DBF5DC83E37E63A7CF898605")
    private int getThumbPositionForListPosition(int firstVisibleItem, int visibleItemCount,
            int totalItemCount) {
        {
            getSectionsFromIndexer();
        } 
        {
            int var9DBC44A6EBF4F17793F4C156235B003F_1536172957 = (((mList.getHeight() - mThumbH) * firstVisibleItem)
                    / (totalItemCount - visibleItemCount));
        } 
        firstVisibleItem -= mListOffset;
        totalItemCount -= mListOffset;
        final int trackHeight = mList.getHeight() - mThumbH;
        final int section = mSectionIndexer.getSectionForPosition(firstVisibleItem);
        final int sectionPos = mSectionIndexer.getPositionForSection(section);
        final int nextSectionPos = mSectionIndexer.getPositionForSection(section + 1);
        final int sectionCount = mSections.length;
        final int positionsInSection = nextSectionPos - sectionPos;
        final View child = mList.getChildAt(0);
        float incrementalPos;
        incrementalPos = 0;
        incrementalPos = firstVisibleItem +
                (float) (mList.getPaddingTop() - child.getTop()) / child.getHeight();
        final float posWithinSection = (incrementalPos - sectionPos) / positionsInSection;
        int result = (int) ((section + posWithinSection) / sectionCount * trackHeight);
        {
            final View lastChild = mList.getChildAt(visibleItemCount - 1);
            final float lastItemVisible = (float) (mList.getHeight() - mList.getPaddingBottom()
                    - lastChild.getTop()) / lastChild.getHeight();
            result += (trackHeight - result) * lastItemVisible;
        } 
        addTaint(firstVisibleItem);
        addTaint(visibleItemCount);
        addTaint(totalItemCount);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_612787445 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_612787445;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.866 -0400", hash_original_method = "CEA01B9B754ED8848F89028F972B696F", hash_generated_method = "EE3570EACFEF93FEA7F996E4F2C62C63")
    private void cancelFling() {
        MotionEvent cancelFling = MotionEvent.obtain(0, 0, MotionEvent.ACTION_CANCEL, 0, 0, 0);
        mList.onTouchEvent(cancelFling);
        cancelFling.recycle();
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.867 -0400", hash_original_method = "1BBF9FC05240D406AB082B75B38F8E40", hash_generated_method = "A17CF01D8897AFD0C2378D2D899955A1")
     void cancelPendingDrag() {
        mList.removeCallbacks(mDeferStartDrag);
        mPendingDrag = false;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.867 -0400", hash_original_method = "DD628BE0DD3562FCAA0807D28A9AC0F6", hash_generated_method = "43BA3AD6A490FA6251BAC1E2C528E5CF")
     void startPendingDrag() {
        mPendingDrag = true;
        mList.postDelayed(mDeferStartDrag, PENDING_DRAG_DELAY);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.868 -0400", hash_original_method = "12EF9C1930DF387CC333A7C9F1E54726", hash_generated_method = "35D4DE833C677581785D47E702F2E832")
     void beginDrag() {
        setState(STATE_DRAGGING);
        {
            getSectionsFromIndexer();
        } 
        {
            mList.requestDisallowInterceptTouchEvent(true);
            mList.reportScrollStateChange(OnScrollListener.SCROLL_STATE_TOUCH_SCROLL);
        } 
        cancelFling();
        
        
        
            
        
        
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.869 -0400", hash_original_method = "D950A8D9B3AA1D87B11E428662FC0A13", hash_generated_method = "E57EF4DD6D85E52BE7D1802973E646F7")
     boolean onInterceptTouchEvent(MotionEvent ev) {
        
        {
            Object var74F259241399C7FD6DED5A7AA3E7383D_1967944019 = (ev.getActionMasked());
            
            {
                boolean varA956E413CCC396DCDE8A419D3081CEBC_1631508220 = (mState > STATE_NONE && isPointInside(ev.getX(), ev.getY()));
                {
                    {
                        boolean var5F096BB9A8B8CA8FD2C7A33B3C25AF8F_1240504786 = (!mList.isInScrollingContainer());
                        {
                            beginDrag();
                        } 
                    } 
                    mInitialTouchY = ev.getY();
                    startPendingDrag();
                } 
            } 
            
            
            cancelPendingDrag();
            
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1311357597 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1311357597;
        
        
            
                
                    
                        
                        
                    
                    
                    
                
                
            
            
                
                
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.870 -0400", hash_original_method = "891E4A8523ECAE5B8AA3233AF8AC2D21", hash_generated_method = "E70B03A34092DDF9C1EC6D58D112DEB6")
     boolean onTouchEvent(MotionEvent me) {
        
        final int action = me.getAction();
        {
            {
                boolean var4CB4F6C2F788DDF9D1F357233A0B0645_1155430661 = (isPointInside(me.getX(), me.getY()));
                {
                    {
                        boolean var5F096BB9A8B8CA8FD2C7A33B3C25AF8F_1023230079 = (!mList.isInScrollingContainer());
                        {
                            beginDrag();
                        } 
                    } 
                    mInitialTouchY = me.getY();
                    startPendingDrag();
                } 
            } 
        } 
        {
            {
                beginDrag();
                final int viewHeight = mList.getHeight();
                int newThumbY = (int) me.getY() - mThumbH + 10;
                {
                    newThumbY = 0;
                } 
                {
                    newThumbY = viewHeight - mThumbH;
                } 
                mThumbY = newThumbY;
                scrollTo((float) mThumbY / (viewHeight - mThumbH));
                cancelPendingDrag();
            } 
            {
                {
                    mList.requestDisallowInterceptTouchEvent(false);
                    mList.reportScrollStateChange(OnScrollListener.SCROLL_STATE_IDLE);
                } 
                setState(STATE_VISIBLE);
                final Handler handler = mHandler;
                handler.removeCallbacks(mScrollFade);
                {
                    handler.postDelayed(mScrollFade, 1000);
                } 
                mList.invalidate();
            } 
        } 
        {
            {
                final float y = me.getY();
                {
                    boolean var57D155B745B41B70666C3C0DB25BDA45_430669976 = (Math.abs(y - mInitialTouchY) > mScaledTouchSlop);
                    {
                        setState(STATE_DRAGGING);
                        {
                            getSectionsFromIndexer();
                        } 
                        {
                            mList.requestDisallowInterceptTouchEvent(true);
                            mList.reportScrollStateChange(OnScrollListener.SCROLL_STATE_TOUCH_SCROLL);
                        } 
                        cancelFling();
                        cancelPendingDrag();
                    } 
                } 
            } 
            {
                final int viewHeight = mList.getHeight();
                int newThumbY = (int) me.getY() - mThumbH + 10;
                {
                    newThumbY = 0;
                } 
                {
                    newThumbY = viewHeight - mThumbH;
                } 
                {
                    boolean varF809D69832046C315D14C292FA46A81C_1148870631 = (Math.abs(mThumbY - newThumbY) < 2);
                } 
                mThumbY = newThumbY;
                {
                    scrollTo((float) mThumbY / (viewHeight - mThumbH));
                } 
            } 
        } 
        {
            cancelPendingDrag();
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1570329875 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1570329875;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.871 -0400", hash_original_method = "4AFF55C64BD9939BD0E5A83378980FDE", hash_generated_method = "661261C42CF0C5F1CF89F37BC1EB1992")
     boolean isPointInside(float x, float y) {
        boolean inTrack = false;
        
        inTrack = x > mList.getWidth() - mThumbW;
        
        
        inTrack = x < mThumbW;
        
        addTaint(x);
        addTaint(y);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1294259536 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1294259536;
        
        
        
            
            
            
                
                
            
                
                
        
        
    }

    
    public class ScrollFade implements Runnable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.871 -0400", hash_original_field = "4FBE52F16DA5DC1AFB86B1520E59C2C0", hash_generated_field = "3C3A30DDD94D9D47CBB52C3848791CE7")

        long mStartTime;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.871 -0400", hash_original_field = "0977CB9901C7FDBEBE15F5CF669E7868", hash_generated_field = "307FFDDA4C0E2DF961BB56499DC85520")

        long mFadeDuration;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.871 -0400", hash_original_method = "5D305A44C44DBEE04C6A110139796128", hash_generated_method = "5D305A44C44DBEE04C6A110139796128")
        public ScrollFade ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.871 -0400", hash_original_method = "C2CB87B9E1EBFB96BF37E1CA2A1422A5", hash_generated_method = "19230DB05151B9744467D8C099CFC776")
         void startFade() {
            mFadeDuration = FADE_DURATION;
            mStartTime = SystemClock.uptimeMillis();
            setState(STATE_EXIT);
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.871 -0400", hash_original_method = "AFB48DA784BE880095A4465F927D06A4", hash_generated_method = "CB9B7A54B11D98032617E6735A172AFD")
         int getAlpha() {
            {
                boolean var18C99A1467A5E28EFE0461A6C774AF80_1233278327 = (getState() != STATE_EXIT);
            } 
            int alpha;
            long now = SystemClock.uptimeMillis();
            {
                alpha = 0;
            } 
            {
                alpha = (int) (ALPHA_MAX - ((now - mStartTime) * ALPHA_MAX) / mFadeDuration);
            } 
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_140366432 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_140366432;
            
            
                
            
            
            
            
                
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.872 -0400", hash_original_method = "3A2ADC6F19B17BA5C164F36207FFFC0C", hash_generated_method = "131C075F9CD238CA9D5078200560339B")
        public void run() {
            {
                boolean var18C99A1467A5E28EFE0461A6C774AF80_497695215 = (getState() != STATE_EXIT);
                {
                    startFade();
                } 
            } 
            {
                boolean var6703FBB521765E4D7F8ABFF437383AC8_1043353750 = (getAlpha() > 0);
                {
                    mList.invalidate();
                } 
                {
                    setState(STATE_NONE);
                } 
            } 
            
            
                
                
            
            
                
            
                
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.872 -0400", hash_original_field = "0002AE9BD831451136433D593FBEF110", hash_generated_field = "A7C45DFCF276811667648B1C1A572838")

        static final int ALPHA_MAX = 208;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.872 -0400", hash_original_field = "5427C149FA3D3269A4036F1A93D514B4", hash_generated_field = "EC8292497A345AD1DC32FC40B26ED215")

        static final long FADE_DURATION = 200;
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.872 -0400", hash_original_field = "6EBA16D4C98F0B19A3CECDE33C2D26F4", hash_generated_field = "56BFBE7F5C9D2F1EB4223BBBC231AA8C")

    private static final String TAG = "FastScroller";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.872 -0400", hash_original_field = "B8457D6D61D7235FF81BF2C3B3C4C56F", hash_generated_field = "2194CAD343A1944040469192DE6A0DCB")

    private static int MIN_PAGES = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.872 -0400", hash_original_field = "E27A9C09B487354949B5B9D78B051E67", hash_generated_field = "19AD2C4D8B184CF34E7683F6281F4246")

    private static final int STATE_NONE = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.872 -0400", hash_original_field = "8C314C59EA3BAB88330FAD0167172B92", hash_generated_field = "752D525745E25E771418EB8BADF10009")

    private static final int STATE_ENTER = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.872 -0400", hash_original_field = "D6DA4032193ED5272EEAD0F9FE106A91", hash_generated_field = "11251698B408CDCABC32B511FF2CDCE2")

    private static final int STATE_VISIBLE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.872 -0400", hash_original_field = "DE0F929053552C903832AF3817135453", hash_generated_field = "C4B39784B1BF345438DBE74EBBCBB5E4")

    private static final int STATE_DRAGGING = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.872 -0400", hash_original_field = "1BF196AA5CA5C9151177E169696885DA", hash_generated_field = "4C8E31D34462D34A8DE02D78A3751D69")

    private static final int STATE_EXIT = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.872 -0400", hash_original_field = "57BA94A965001B589D71838C0B318B28", hash_generated_field = "A4ED50417A9DBB08E9A7851FFF0DB179")

    private static final int[] PRESSED_STATES = new int[] {
        android.R.attr.state_pressed
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.872 -0400", hash_original_field = "8A6F1AFD3C662EACD16AB85697E1F117", hash_generated_field = "1EE9C5A9B487C2093F1C1687A659D84D")

    private static final int[] DEFAULT_STATES = new int[0];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.872 -0400", hash_original_field = "72C442925745EFC5792F94523ABD1AB2", hash_generated_field = "84AAA12BA67F0A875D601387F39B9663")

    private static final int[] ATTRS = new int[] {
        android.R.attr.fastScrollTextColor,
        android.R.attr.fastScrollThumbDrawable,
        android.R.attr.fastScrollTrackDrawable,
        android.R.attr.fastScrollPreviewBackgroundLeft,
        android.R.attr.fastScrollPreviewBackgroundRight,
        android.R.attr.fastScrollOverlayPosition
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.872 -0400", hash_original_field = "CA4C0713CBE2C71C5C492833440E804E", hash_generated_field = "1FA0034D769E8804C911CA57C3894230")

    private static final int TEXT_COLOR = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.872 -0400", hash_original_field = "CF11DBD300F4A144C8DDC2642B04C398", hash_generated_field = "0239F9DADAC23BDBF7DAE9F4242945FC")

    private static final int THUMB_DRAWABLE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.872 -0400", hash_original_field = "141F08F999F6766770CB46EF0A74949B", hash_generated_field = "1BB3900B2A090E5FC1DFA188E16771D0")

    private static final int TRACK_DRAWABLE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.872 -0400", hash_original_field = "D37CF1E9A45D3A94963A4EABD45A651C", hash_generated_field = "9BB6FFDAA693C68CBFE732BAD3AF248F")

    private static final int PREVIEW_BACKGROUND_LEFT = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.872 -0400", hash_original_field = "6D2E3120428688CDC1966FE43544FD29", hash_generated_field = "20110F77E24ED7F2FA7ACAABEB159699")

    private static final int PREVIEW_BACKGROUND_RIGHT = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.872 -0400", hash_original_field = "24A8BF5F2A62B5AEB2FC7D05A00E67A0", hash_generated_field = "04EE06B0140567237206BB05A55B6D82")

    private static final int OVERLAY_POSITION = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.872 -0400", hash_original_field = "7F0D318487A3CBF95BDDF44FC50E1634", hash_generated_field = "C7D64E758B6AB043EBEA3866A6D65988")

    private static final int OVERLAY_FLOATING = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.872 -0400", hash_original_field = "96C00FF9468970A6B914DE0570C5AF9A", hash_generated_field = "C800788580620028E6672AF4A08A7118")

    private static final int OVERLAY_AT_THUMB = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.872 -0400", hash_original_field = "5B00A14F745BD76B5A30CD9C5D66BD81", hash_generated_field = "34BA387044B3D0FAAB4EEB4796FFF3A1")

    private static final int FADE_TIMEOUT = 1500;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.872 -0400", hash_original_field = "54B3E19B78CDC50A499DF91E4E7BB300", hash_generated_field = "CF9EC8D9C1271C568A979F597BD18D32")

    private static final int PENDING_DRAG_DELAY = 180;
}

