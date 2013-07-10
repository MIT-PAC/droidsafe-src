package android.support.v4.view;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

public class PagerTabStrip extends PagerTitleStrip {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.665 -0400", hash_original_field = "C855DDAC285F048831B3ECE67D9AC80E", hash_generated_field = "409FE0E5CDF8B52318C1C752E426E71E")

    private int mIndicatorColor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.665 -0400", hash_original_field = "B968000EF60FDAF7AABA460F870A954A", hash_generated_field = "83098245E64EBFACE72B4215FEFBC24C")

    private int mIndicatorHeight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.666 -0400", hash_original_field = "8F10CED87CD6B383F0D0D281422CEC31", hash_generated_field = "D329705655BA0249AA981002B2E08FFB")

    private int mMinPaddingBottom;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.666 -0400", hash_original_field = "FA28734BC206702FFF68BF397826E79B", hash_generated_field = "2E19480DB23CD1A94AC53319EE8298A4")

    private int mMinTextSpacing;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.667 -0400", hash_original_field = "3960CAE9868F834EF98140EEA61067F0", hash_generated_field = "598E6014FAF0ACAD0C354AF2310FFAE5")

    private int mMinStripHeight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.667 -0400", hash_original_field = "B80039BA17D18CEC3CC18610BC035B7C", hash_generated_field = "B4A7B09278766EFD4D68D9CA85E7B4F2")

    private int mTabPadding;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.668 -0400", hash_original_field = "7084F83DF9DE905C21FC9A442CF53ED2", hash_generated_field = "E8B1B360D2FDC03D7C871AFEEE323841")

    private final Paint mTabPaint = new Paint();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.668 -0400", hash_original_field = "DF43B278CEE8933271AB3D9F9E312F86", hash_generated_field = "A498F2A4744F31D22F9C4ABEBB254F2F")

    private final Rect mTempRect = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.669 -0400", hash_original_field = "D9BF88FDE0D51BE5DBE1031B9E67136C", hash_generated_field = "F19DF385984B4F1145AF1A81FF31F095")

    private int mTabAlpha = 0xFF;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.669 -0400", hash_original_field = "B1D0C5E1C50D40226C28BD387A06EEF4", hash_generated_field = "3F79DD2994E6DB89CED3A3680B088E83")

    private boolean mDrawFullUnderline = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.669 -0400", hash_original_field = "FA4C408F31E285438F32963D266E99F5", hash_generated_field = "935435EF24FB211036CB9B2B592AACFC")

    private boolean mDrawFullUnderlineSet = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.670 -0400", hash_original_field = "008CB7D9F7C0E6AB497DE80E04FD3682", hash_generated_field = "CB7E41F64EF564EEADD9F24B71DE1884")

    private int mFullUnderlineHeight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.670 -0400", hash_original_field = "A32190EDD21B6AAA5461125706E41688", hash_generated_field = "1B7951305AF6C2C0E6775E9A5145CC72")

    private boolean mIgnoreTap;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.671 -0400", hash_original_field = "5777AFD9F80796909E38C49F4EB26657", hash_generated_field = "E8D995D721D911B655A8BA1B8E85A671")

    private float mInitialMotionX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.671 -0400", hash_original_field = "E2BDA9E2AD22EF73AF9B4C95E9A4FC1A", hash_generated_field = "123A2D63D23BC6C888D43FC39BEED8A4")

    private float mInitialMotionY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.672 -0400", hash_original_field = "3DFFFAD10926598D18EEC50D61DE79CA", hash_generated_field = "3B323323DD6A6BF972666D993592C670")

    private int mTouchSlop;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.673 -0400", hash_original_method = "AEED43FFC18977D21094349BF84C20B4", hash_generated_method = "49F2E47DD474F30D9B7E6DF5A6ECC682")
    public  PagerTabStrip(Context context) {
        this(context, null);
        addTaint(context.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.686 -0400", hash_original_method = "ACA07B5CE6E6B13EE40202110EB75BD3", hash_generated_method = "410D3C40A09D1658789E2EFA9C9FB954")
    public  PagerTabStrip(Context context, AttributeSet attrs) {
        super(context, attrs);
        mIndicatorColor = mTextColor;
        mTabPaint.setColor(mIndicatorColor);
        final float density = context.getResources().getDisplayMetrics().density;
        mIndicatorHeight = (int) (INDICATOR_HEIGHT * density + 0.5f);
        mMinPaddingBottom = (int) (MIN_PADDING_BOTTOM * density + 0.5f);
        mMinTextSpacing = (int) (MIN_TEXT_SPACING * density);
        mTabPadding = (int) (TAB_PADDING * density + 0.5f);
        mFullUnderlineHeight = (int) (FULL_UNDERLINE_HEIGHT * density + 0.5f);
        mMinStripHeight = (int) (MIN_STRIP_HEIGHT * density + 0.5f);
        mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        setTextSpacing(getTextSpacing());
        setWillNotDraw(false);
        mPrevText.setFocusable(true);
        mPrevText.setOnClickListener(new OnClickListener() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.682 -0400", hash_original_method = "91A02AD3B25B1F5EE15DA116FF083943", hash_generated_method = "21DA5E987155EF2714C07D5188B5FA0A")
            @Override
            public void onClick(View v) {
                
                mPager.setCurrentItem(mPager.getCurrentItem() - 1);
                addTaint(v.getTaint());
                
                
            }
});
        mNextText.setFocusable(true);
        mNextText.setOnClickListener(new OnClickListener() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.684 -0400", hash_original_method = "1076F28AA463C7302B98279A7C9CC4FD", hash_generated_method = "2DFCA2237CB9015C7B4996917F3FE24E")
            @Override
            public void onClick(View v) {
                
                mPager.setCurrentItem(mPager.getCurrentItem() + 1);
                addTaint(v.getTaint());
                
                
            }
});
        {
            boolean varF9737FBB3FA84CB9364E87D929DD087B_820159749 = (getBackground() == null);
            {
                mDrawFullUnderline = true;
            } 
        } 
        addTaint(attrs.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.688 -0400", hash_original_method = "416E053D9953A7DFD58ABDC9A59B40AE", hash_generated_method = "E762FAB0C214B35E9EF7049B9ABC2789")
    public void setTabIndicatorColor(int color) {
        mIndicatorColor = color;
        mTabPaint.setColor(mIndicatorColor);
        invalidate();
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.689 -0400", hash_original_method = "E9D022FF51B83B7CA06819055EF3F1EA", hash_generated_method = "4D2753591BD3793889C754B35B6A3736")
    public void setTabIndicatorColorResource(int resId) {
        setTabIndicatorColor(getContext().getResources().getColor(resId));
        addTaint(resId);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.690 -0400", hash_original_method = "5395C6CBC695BBA3012BD836AEACC5FF", hash_generated_method = "1D07377A9A206193360F8D87C2005759")
    public int getTabIndicatorColor() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1711409337 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1711409337;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.692 -0400", hash_original_method = "476E6AAD455240BE6ECAEEC8CCE45F2E", hash_generated_method = "0D14C2105DE6D834E989AC0CBF8C861F")
    @Override
    public void setPadding(int left, int top, int right, int bottom) {
        {
            bottom = mMinPaddingBottom;
        } 
        super.setPadding(left, top, right, bottom);
        addTaint(left);
        addTaint(top);
        addTaint(right);
        addTaint(bottom);
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.694 -0400", hash_original_method = "9E708A5002235F54A6E83D6CAB6E0AE5", hash_generated_method = "1823AA243F914A450D8DCF0DF97C0351")
    @Override
    public void setTextSpacing(int textSpacing) {
        {
            textSpacing = mMinTextSpacing;
        } 
        super.setTextSpacing(textSpacing);
        addTaint(textSpacing);
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.696 -0400", hash_original_method = "3092862974FBD462F013027A320B043F", hash_generated_method = "53060C41391D639DD360E53208C3CDED")
    @Override
    public void setBackgroundDrawable(Drawable d) {
        super.setBackgroundDrawable(d);
        {
            mDrawFullUnderline = d == null;
        } 
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.697 -0400", hash_original_method = "4DB107C989DD8831950A5E6FC781B7EA", hash_generated_method = "065F1461B769028B58B7F40FFAEA723B")
    @Override
    public void setBackgroundColor(int color) {
        super.setBackgroundColor(color);
        {
            mDrawFullUnderline = (color & 0xFF000000) == 0;
        } 
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.699 -0400", hash_original_method = "3C72ECA005B1B81D90186B2BF9D062C7", hash_generated_method = "992DB01B3ABEAB5A2DADEF80D67760C2")
    @Override
    public void setBackgroundResource(int resId) {
        super.setBackgroundResource(resId);
        {
            mDrawFullUnderline = resId == 0;
        } 
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.701 -0400", hash_original_method = "45921BB4543CC1DCECCEDCA990B66B64", hash_generated_method = "C8EB7D703FB9B947ED540B473AA41C9B")
    public void setDrawFullUnderline(boolean drawFull) {
        mDrawFullUnderline = drawFull;
        mDrawFullUnderlineSet = true;
        invalidate();
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.702 -0400", hash_original_method = "6FF569EBD79F00CD08226507D1584B29", hash_generated_method = "40AF53F9575BAC58798343213DC55BA6")
    public boolean getDrawFullUnderline() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1707815715 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1707815715;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.703 -0400", hash_original_method = "277E06AC1F137E5CAC62EBE97DB0158F", hash_generated_method = "CC6427FD8848D97C6052DCB91A8AFF07")
    @Override
     int getMinHeight() {
        int var1E21010155EF11871092BB741E668620_1880563353 = (Math.max(super.getMinHeight(), mMinStripHeight));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1086483661 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1086483661;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.709 -0400", hash_original_method = "111ACB958C21102733D4E9303B8F60D8", hash_generated_method = "07CF5E8032AC4E45F5AABF38B4BEDD76")
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        
        final int action = ev.getAction();
        final float x = ev.getX();
        final float y = ev.getY();
        
        mInitialMotionX = x;
        
        
        mInitialMotionY = y;
        
        
        mIgnoreTap = false;
        
        
        {
            boolean varF8F51B50BD241264D83941AEC98C7C41_348660545 = (Math.abs(x - mInitialMotionX) > mTouchSlop ||
                        Math.abs(y - mInitialMotionY) > mTouchSlop);
            {
                mIgnoreTap = true;
            } 
        } 
        
        
        {
            boolean var51EFC17C97713A2111A1674913EE739D_1932792815 = (x < mCurrText.getLeft() - mTabPadding);
            {
                mPager.setCurrentItem(mPager.getCurrentItem() - 1);
            } 
            {
                boolean var1F7DE6C1D8C4498ADD06C5F59FDC7BC0_1087699328 = (x > mCurrText.getRight() + mTabPadding);
                {
                    mPager.setCurrentItem(mPager.getCurrentItem() + 1);
                } 
            } 
        } 
        
        addTaint(ev.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1629629422 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1629629422;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.713 -0400", hash_original_method = "1ECCB5A2A13672387CA93C5777A80514", hash_generated_method = "7E91066B7444FD50C253D4C89381E7D6")
    @Override
    protected void onDraw(Canvas canvas) {
        
        super.onDraw(canvas);
        final int height = getHeight();
        final int bottom = height;
        final int left = mCurrText.getLeft() - mTabPadding;
        final int right = mCurrText.getRight() + mTabPadding;
        final int top = bottom - mIndicatorHeight;
        mTabPaint.setColor(mTabAlpha << 24 | (mIndicatorColor & 0xFFFFFF));
        canvas.drawRect(left, top, right, bottom, mTabPaint);
        {
            mTabPaint.setColor(0xFF << 24 | (mIndicatorColor & 0xFFFFFF));
            canvas.drawRect(getPaddingLeft(), height - mFullUnderlineHeight,
                    getWidth() - getPaddingRight(), height, mTabPaint);
        } 
        addTaint(canvas.getTaint());
        
        
        
        
        
        
        
        
        
        
            
            
                    
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.716 -0400", hash_original_method = "218291EE6C0B81B0F0486DC4B2750F49", hash_generated_method = "857BFC1C626524A48E46A500EAC37C2C")
    @Override
     void updateTextPositions(int position, float positionOffset, boolean force) {
        final Rect r = mTempRect;
        int bottom = getHeight();
        int left = mCurrText.getLeft() - mTabPadding;
        int right = mCurrText.getRight() + mTabPadding;
        int top = bottom - mIndicatorHeight;
        r.set(left, top, right, bottom);
        super.updateTextPositions(position, positionOffset, force);
        mTabAlpha = (int) (Math.abs(positionOffset - 0.5f) * 2 * 0xFF);
        left = mCurrText.getLeft() - mTabPadding;
        right = mCurrText.getRight() + mTabPadding;
        r.union(left, top, right, bottom);
        invalidate(r);
        addTaint(position);
        addTaint(force);
        
        
        
        
        
        
        
        
        
        
        
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.717 -0400", hash_original_field = "27738A69B802F0EB56905FB779BA1308", hash_generated_field = "64B0B411288CFE20B0EA9C8A85989E2F")

    private static final String TAG = "PagerTabStrip";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.718 -0400", hash_original_field = "6CBDA4E0BD65D88BA624647C52FFF9EC", hash_generated_field = "F815EAE3F4892EA46E413D40A4CACECA")

    private static final int INDICATOR_HEIGHT = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.718 -0400", hash_original_field = "C1BBF8DCB9C89640A01DB1BDC2D115BE", hash_generated_field = "FE15022AF2224D927BC779D4428D97DB")

    private static final int MIN_PADDING_BOTTOM = INDICATOR_HEIGHT + 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.719 -0400", hash_original_field = "453D04ADA9D6BA2EE259A4AF404E3DD7", hash_generated_field = "3599EAA4B05FBD75BEE3591AF23B7880")

    private static final int TAB_PADDING = 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.719 -0400", hash_original_field = "6DC4FB672D940FF99D3A9DE8E78FFBD1", hash_generated_field = "ECDB9805019F16D73B6F61501C2408CB")

    private static final int TAB_SPACING = 32;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.719 -0400", hash_original_field = "ED6CDAA93D0B2750F986220BD8093422", hash_generated_field = "F766C8CB662DF4560C5FBDFCA362ED3F")

    private static final int MIN_TEXT_SPACING = TAB_SPACING + TAB_PADDING * 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.720 -0400", hash_original_field = "CEBD16C09C76722818FF4E80813F01D1", hash_generated_field = "93A9F7E8A14957597A2F40091011D859")

    private static final int FULL_UNDERLINE_HEIGHT = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.720 -0400", hash_original_field = "72B05DD21A24AAAC6A92563FBFC4669A", hash_generated_field = "AC9054A2B2E2C126AD018B67C8B1189C")

    private static final int MIN_STRIP_HEIGHT = 32;
}

