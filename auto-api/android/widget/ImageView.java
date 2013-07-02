package android.widget;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.RemotableViewMethod;
import android.view.View;
import android.view.ViewDebug;
import android.view.accessibility.AccessibilityEvent;
import android.widget.RemoteViews.RemoteView;

public class ImageView extends View {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.760 -0400", hash_original_field = "5FBE3730DCFF234F97B15868D5CE649D", hash_generated_field = "04FA8EB5D9FB8AC4AAE6453BCF1BBF82")

    private Uri mUri;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.760 -0400", hash_original_field = "9687C18AF187DE568609D63BF0C95F6E", hash_generated_field = "A1149776195D9A81C2251417049A8983")

    private int mResource = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.760 -0400", hash_original_field = "9FEB0FB4D7668A1A69C2CCE86D8FE6AA", hash_generated_field = "19EDBF8F5E96D57B14276EDE6AD2F400")

    private Matrix mMatrix;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.760 -0400", hash_original_field = "0BFEC49F5128457BE902AB856ABE41D0", hash_generated_field = "D019EEE3A15FE9FAE26B5448B9F5829B")

    private ScaleType mScaleType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.760 -0400", hash_original_field = "0D8E6A9A6439BD0EDB0134B86DD0FF56", hash_generated_field = "A9F2FED4F49AAE6AC6AEAF755030819C")

    private boolean mHaveFrame = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.760 -0400", hash_original_field = "E48EA5F392E29C330AAD7777031257FE", hash_generated_field = "0CE29D9D9A45271B43F0AD7DE06F84E1")

    private boolean mAdjustViewBounds = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.760 -0400", hash_original_field = "9F06F72E481BAF7A136AD40FA3B01EB4", hash_generated_field = "63C7BFD9234113D05BBC54B620020077")

    private int mMaxWidth = Integer.MAX_VALUE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.760 -0400", hash_original_field = "720F6023E916A40B06BB7677E44DB85A", hash_generated_field = "3586D5CEDE91E2DE59FB9742E85FA3AD")

    private int mMaxHeight = Integer.MAX_VALUE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.760 -0400", hash_original_field = "8B2ED40D22A4C08C94CFC40B6DE589B8", hash_generated_field = "5D6D299C9DDEDCCB11EFFA1C147C3DF6")

    private ColorFilter mColorFilter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.760 -0400", hash_original_field = "1439C01AF326A337A2401436745247DA", hash_generated_field = "D85E4CEC9C06A2D96EB98C9ADB4E0FF6")

    private int mAlpha = 255;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.760 -0400", hash_original_field = "05C970399FAF71ED4C8AEFEE55D2E1C7", hash_generated_field = "7D8AB2121554DAB4C026523E1BE546D1")

    private int mViewAlphaScale = 256;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.760 -0400", hash_original_field = "424A8580F75B780B70CB9B4272F55C40", hash_generated_field = "F19CF311EA8DC507DE046A521B9697AE")

    private boolean mColorMod = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.760 -0400", hash_original_field = "C211E639ECC112D6CFE9EF35C7EE2BAD", hash_generated_field = "4203E503DD280EB595B89035662691AC")

    private Drawable mDrawable = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.760 -0400", hash_original_field = "1D598FE22B106935C0C063CC508FA455", hash_generated_field = "55E5EFD87E77F38783CE10C9BF766B2D")

    private int[] mState = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.760 -0400", hash_original_field = "7500A1D75540C8BABBEABE375200D820", hash_generated_field = "CD0E3EB62F2EEB3E7C6BC89E581F03D0")

    private boolean mMergeState = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.760 -0400", hash_original_field = "8D44C0A2CA7183B234B6C68F8099BDEB", hash_generated_field = "D66D669C7CB840BE2CC0AE88CB04AECF")

    private int mLevel = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.760 -0400", hash_original_field = "BDE4B5ECFEF5B3B5C89BD588E039EB7F", hash_generated_field = "A392E3876AEB7B9CD42C742144EAE0B2")

    private int mDrawableWidth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.760 -0400", hash_original_field = "81B997CC4D8DA3F276798F355396D6BC", hash_generated_field = "87D310E7F957167B4F609DB1F09D884D")

    private int mDrawableHeight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.760 -0400", hash_original_field = "38017DD8AAC924883B1956C1C08D2174", hash_generated_field = "90F6D022B92E991BB20BB870E8BC3FF7")

    private Matrix mDrawMatrix = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.760 -0400", hash_original_field = "027BE59B05D90854B1A288EAC269B061", hash_generated_field = "4822CDFF0200FBD929D8DC006BC82F04")

    private RectF mTempSrc = new RectF();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.760 -0400", hash_original_field = "83EED2DFF6690433B8CB303B48558A0E", hash_generated_field = "3F7FC79A12F840875E4DB52E36F649AD")

    private RectF mTempDst = new RectF();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.760 -0400", hash_original_field = "49185ED0BC5B6EEAFDC11117FFA7532C", hash_generated_field = "2A167B0395D5D689B5161FD76D7714AC")

    private boolean mCropToPadding;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.760 -0400", hash_original_field = "E9071209E3EB9AFCB8B5DD7C635F8293", hash_generated_field = "FEB7CA79CE658BB3A037CDF3395A66FC")

    private int mBaseline = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.760 -0400", hash_original_field = "B4AAF99C1540BC541F937E9B9CDB87FA", hash_generated_field = "43E60ED5A18EF5C89E67168564FB92E1")

    private boolean mBaselineAlignBottom = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.761 -0400", hash_original_method = "3103DD3B06C95633A5076C8A302A640B", hash_generated_method = "9F421F362FC0D50B336DDAA22AF2B5E7")
    public  ImageView(Context context) {
        super(context);
        initImageView();
        addTaint(context.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.761 -0400", hash_original_method = "67FF47760B585BF8195A474475D955DB", hash_generated_method = "B0770783780D65D12A52847EBE2867F1")
    public  ImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.762 -0400", hash_original_method = "8CC4CE610519C30A909B4E591A3E5936", hash_generated_method = "96C5861AD17FBB53D5FDC9E07B491707")
    public  ImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initImageView();
        TypedArray a = context.obtainStyledAttributes(attrs,
                com.android.internal.R.styleable.ImageView, defStyle, 0);
        Drawable d = a.getDrawable(com.android.internal.R.styleable.ImageView_src);
        {
            setImageDrawable(d);
        } 
        mBaselineAlignBottom = a.getBoolean(
                com.android.internal.R.styleable.ImageView_baselineAlignBottom, false);
        mBaseline = a.getDimensionPixelSize(
                com.android.internal.R.styleable.ImageView_baseline, -1);
        setAdjustViewBounds(
            a.getBoolean(com.android.internal.R.styleable.ImageView_adjustViewBounds,
            false));
        setMaxWidth(a.getDimensionPixelSize(
                com.android.internal.R.styleable.ImageView_maxWidth, Integer.MAX_VALUE));
        setMaxHeight(a.getDimensionPixelSize(
                com.android.internal.R.styleable.ImageView_maxHeight, Integer.MAX_VALUE));
        int index = a.getInt(com.android.internal.R.styleable.ImageView_scaleType, -1);
        {
            setScaleType(sScaleTypeArray[index]);
        } 
        int tint = a.getInt(com.android.internal.R.styleable.ImageView_tint, 0);
        {
            setColorFilter(tint);
        } 
        int alpha = a.getInt(com.android.internal.R.styleable.ImageView_drawableAlpha, 255);
        {
            setAlpha(alpha);
        } 
        mCropToPadding = a.getBoolean(
                com.android.internal.R.styleable.ImageView_cropToPadding, false);
        a.recycle();
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        addTaint(defStyle);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.762 -0400", hash_original_method = "1C158315B1207DD6F7DBD78E9AF6090A", hash_generated_method = "6C86BA293E0B26AF0AEC484FE877D701")
    private void initImageView() {
        mMatrix     = new Matrix();
        mScaleType  = ScaleType.FIT_CENTER;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.763 -0400", hash_original_method = "D798939B4195D6D5668E5F7C7E8DA2D2", hash_generated_method = "16F1CE7A61E919C00E17BC02A5746230")
    @Override
    protected boolean verifyDrawable(Drawable dr) {
        boolean var6F0BA58C8588BA95FEB13B8735D08D03_1363666068 = (mDrawable == dr || super.verifyDrawable(dr));
        addTaint(dr.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1219887797 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1219887797;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.763 -0400", hash_original_method = "EFC358D3732AB4D7E168E7965D2C4CA0", hash_generated_method = "647FF0158A8AD6165B9B2605A87B9B49")
    @Override
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        mDrawable.jumpToCurrentState();
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.764 -0400", hash_original_method = "EB3EC256D00C5FC794745B960350792B", hash_generated_method = "9FAD2A829CFD8C40096433413D3DA1FF")
    @Override
    public void invalidateDrawable(Drawable dr) {
        {
            invalidate();
        } 
        {
            super.invalidateDrawable(dr);
        } 
        addTaint(dr.getTaint());
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.765 -0400", hash_original_method = "792DD4F5E748125528D3BF6C27B77C70", hash_generated_method = "1473EF465D08DF2E0DFE7A2D2E4A5051")
    @Override
    public int getResolvedLayoutDirection(Drawable dr) {
        {
            Object varAFC6EB2C684D509A17B3A4EFF5D9CB9D_400955483 = (getResolvedLayoutDirection());
            Object varE1F279108E97B96264B9D15008FD7CD5_897046626 = (super.getResolvedLayoutDirection(dr));
        } 
        addTaint(dr.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_723258388 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_723258388;
        
        
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.765 -0400", hash_original_method = "000365A595FBC289F16F7AD48241010C", hash_generated_method = "01603B40CEF995474FDB22C2E3FC68ED")
    @Override
    protected boolean onSetAlpha(int alpha) {
        
        {
            boolean varF9737FBB3FA84CB9364E87D929DD087B_2123011227 = (getBackground() == null);
            {
                int scale = alpha + (alpha >> 7);
                {
                    mViewAlphaScale = scale;
                    mColorMod = true;
                    applyColorMod();
                } 
            } 
        } 
        addTaint(alpha);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1858948051 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1858948051;
        
        
            
            
                
                
                
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.765 -0400", hash_original_method = "9770981DD4DB73204B697C6119742B6F", hash_generated_method = "43718B128F2D80A34F4B219DE855305F")
    @Override
    public void onPopulateAccessibilityEvent(AccessibilityEvent event) {
        
        super.onPopulateAccessibilityEvent(event);
        CharSequence contentDescription = getContentDescription();
        {
            boolean var38FE545BF2449F0AB422311DB9C21872_1920085388 = (!TextUtils.isEmpty(contentDescription));
            {
                event.getText().add(contentDescription);
            } 
        } 
        addTaint(event.getTaint());
        
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.766 -0400", hash_original_method = "3F8BE319328C68420F5075492EAAB722", hash_generated_method = "E75A3752923BDB60E8353DD155C9F586")
    @android.view.RemotableViewMethod
    public void setAdjustViewBounds(boolean adjustViewBounds) {
        mAdjustViewBounds = adjustViewBounds;
        {
            setScaleType(ScaleType.FIT_CENTER);
        } 
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.766 -0400", hash_original_method = "EB73857FE18ECB168F084B0FAC346FEA", hash_generated_method = "79DFBF0CB12D07C0AEB4E082D13DCC35")
    @android.view.RemotableViewMethod
    public void setMaxWidth(int maxWidth) {
        mMaxWidth = maxWidth;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.766 -0400", hash_original_method = "9473C5CB1AE9899AEC7CB726EABA77F7", hash_generated_method = "0CD17647B54DD7BBE70494C14EEAE2F5")
    @android.view.RemotableViewMethod
    public void setMaxHeight(int maxHeight) {
        mMaxHeight = maxHeight;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.767 -0400", hash_original_method = "53D05784890C72350FD6879A6582F7F3", hash_generated_method = "C00360D6DF516BD58B06DD3F8D687318")
    public Drawable getDrawable() {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_114340792 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_114340792 = mDrawable;
        varB4EAC82CA7396A68D541C85D26508E83_114340792.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_114340792;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.767 -0400", hash_original_method = "FEA329647011282E5AA15854AC819C8B", hash_generated_method = "A3643FD5C96F12ABFF4A0FAEB1B47A0F")
    @android.view.RemotableViewMethod
    public void setImageResource(int resId) {
        {
            updateDrawable(null);
            mResource = resId;
            mUri = null;
            resolveUri();
            requestLayout();
            invalidate();
        } 
        
        
            
            
            
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.767 -0400", hash_original_method = "796039DEA15F6465B0D947F27F5B4F32", hash_generated_method = "258E0C7459D54E2162AF66AD559701B3")
    @android.view.RemotableViewMethod
    public void setImageURI(Uri uri) {
        {
            boolean var90AB53EB1D53155B41BCD7E227FE479A_244154239 = (mResource != 0 ||
                (mUri != uri &&
                 (uri == null || mUri == null || !uri.equals(mUri))));
            {
                updateDrawable(null);
                mResource = 0;
                mUri = uri;
                resolveUri();
                requestLayout();
                invalidate();
            } 
        } 
        
        
                
                 
            
            
            
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.768 -0400", hash_original_method = "5426F5FAF3C8635D29ADE0169269A6F9", hash_generated_method = "C65AD1A27849D0FCE5D39B8F3E51F959")
    public void setImageDrawable(Drawable drawable) {
        {
            mResource = 0;
            mUri = null;
            int oldWidth = mDrawableWidth;
            int oldHeight = mDrawableHeight;
            updateDrawable(drawable);
            {
                requestLayout();
            } 
            invalidate();
        } 
        addTaint(drawable.getTaint());
        
        
            
            
            
            
            
            
                
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.768 -0400", hash_original_method = "5EFFAF8EE29E35792B081E6E83A7DFE3", hash_generated_method = "1AA64D538B4A3D3BD41437317289C896")
    @android.view.RemotableViewMethod
    public void setImageBitmap(Bitmap bm) {
        setImageDrawable(new BitmapDrawable(mContext.getResources(), bm));
        addTaint(bm.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.768 -0400", hash_original_method = "B00DD17D168377A844733E90ECCFE75B", hash_generated_method = "AEB13EE0E78E1C7D679F434ABE923355")
    public void setImageState(int[] state, boolean merge) {
        mState = state;
        mMergeState = merge;
        {
            refreshDrawableState();
            resizeFromDrawable();
        } 
        
        
        
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.769 -0400", hash_original_method = "44CE6C01D324B2DC91AFD69B5F1BB742", hash_generated_method = "1D34BBDFEBADC19AD015A84C04CBD506")
    @Override
    public void setSelected(boolean selected) {
        super.setSelected(selected);
        resizeFromDrawable();
        addTaint(selected);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.769 -0400", hash_original_method = "0A74FF8303919E2F74751A8C668C95F0", hash_generated_method = "5BE8AF9B93F28852EC0CBFB41E400656")
    @android.view.RemotableViewMethod
    public void setImageLevel(int level) {
        mLevel = level;
        {
            mDrawable.setLevel(level);
            resizeFromDrawable();
        } 
        
        
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.769 -0400", hash_original_method = "63CC1440F0B24F3C6377C34C34E172F5", hash_generated_method = "081CB5FE252ADBD86052D5AC2152848B")
    public void setScaleType(ScaleType scaleType) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } 
        {
            mScaleType = scaleType;
            setWillNotCacheDrawing(mScaleType == ScaleType.CENTER);
            requestLayout();
            invalidate();
        } 
        
        
            
        
        
            
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.770 -0400", hash_original_method = "84B4F1338E9C8554FC089CA7254325E0", hash_generated_method = "030628C1AA87F6FB03C2D0E0A5567A25")
    public ScaleType getScaleType() {
        ScaleType varB4EAC82CA7396A68D541C85D26508E83_2091292108 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2091292108 = mScaleType;
        varB4EAC82CA7396A68D541C85D26508E83_2091292108.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2091292108;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.770 -0400", hash_original_method = "5B9FD9A0A164EA90D695E910523F6E96", hash_generated_method = "8333BF655D8C07413B668B1F81492388")
    public Matrix getImageMatrix() {
        Matrix varB4EAC82CA7396A68D541C85D26508E83_1576888473 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1576888473 = mMatrix;
        varB4EAC82CA7396A68D541C85D26508E83_1576888473.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1576888473;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.770 -0400", hash_original_method = "A32A82AEE544A388BA62C8178AC7E88C", hash_generated_method = "4278D7B0F8BBCAA0D22CB7695C89D7AE")
    public void setImageMatrix(Matrix matrix) {
        {
            boolean var43647054FCC5E2FEA67BA4DB2B5CFDEC_742092376 = (matrix != null && matrix.isIdentity());
            {
                matrix = null;
            } 
        } 
        {
            boolean var07BF5E6DF09B8E40E54FCB7189DEE131_2107317297 = (matrix == null && !mMatrix.isIdentity() ||
                matrix != null && !mMatrix.equals(matrix));
            {
                mMatrix.set(matrix);
                configureBounds();
                invalidate();
            } 
        } 
        addTaint(matrix.getTaint());
        
        
            
        
        
                
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.771 -0400", hash_original_method = "16B1589372902AF87B2F0F65CBDC5B57", hash_generated_method = "A9AACC5B8D6ADB788D5E7E21729CBE83")
    private void resolveUri() {
        Resources rsrc = getResources();
        Drawable d = null;
        {
            try 
            {
                d = rsrc.getDrawable(mResource);
            } 
            catch (Exception e)
            {
                mUri = null;
            } 
        } 
        {
            String scheme = mUri.getScheme();
            {
                boolean varF1920ADB7A324A214864F4BBBDD05F45_122882204 = (ContentResolver.SCHEME_ANDROID_RESOURCE.equals(scheme));
                {
                    try 
                    {
                        ContentResolver.OpenResourceIdResult r = mContext.getContentResolver().getResourceId(mUri);
                        d = r.r.getDrawable(r.id);
                    } 
                    catch (Exception e)
                    { }
                } 
                {
                    boolean varECE6BF2CA2A924F44A15A349FCEFEEC1_2073742395 = (ContentResolver.SCHEME_CONTENT.equals(scheme)
                    || ContentResolver.SCHEME_FILE.equals(scheme));
                    {
                        try 
                        {
                            d = Drawable.createFromStream(
                        mContext.getContentResolver().openInputStream(mUri),
                        null);
                        } 
                        catch (Exception e)
                        { }
                    } 
                    {
                        d = Drawable.createFromPath(mUri.toString());
                    } 
                } 
            } 
            {
                System.out.println("resolveUri failed on bad bitmap uri: "
                                   + mUri);
                mUri = null;
            } 
        } 
        updateDrawable(d);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.772 -0400", hash_original_method = "F00D7A8DB32B373F9AAF90A3CC19DF16", hash_generated_method = "57196D69DFF9C8BDC2386043E97508EB")
    @Override
    public int[] onCreateDrawableState(int extraSpace) {
        
        {
            int[] varEB7CD746CBB534A0BF67F4323334429E_24175966 = (super.onCreateDrawableState(extraSpace));
        } 
        {
            int[] varB6313CC42B6FF045E4878C3B3E985625_368799971 = (mergeDrawableStates(
                    super.onCreateDrawableState(extraSpace + mState.length), mState));
        } 
        addTaint(extraSpace);
        int[] varB4CCCA26F9DB9189C32F33E82D425CFB_2120887669 = {getTaintInt()};
        return varB4CCCA26F9DB9189C32F33E82D425CFB_2120887669;
        
        
            
        
            
        
            
                    
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.772 -0400", hash_original_method = "ADE7139D7C0A9B2AE00EA96739AFBDE5", hash_generated_method = "BA96715C2176AECAF9590FFB3FEE8FFC")
    private void updateDrawable(Drawable d) {
        {
            mDrawable.setCallback(null);
            unscheduleDrawable(mDrawable);
        } 
        mDrawable = d;
        {
            d.setCallback(this);
            {
                boolean var732D4E5C808363BC9BF454DD27943961_700087958 = (d.isStateful());
                {
                    d.setState(getDrawableState());
                } 
            } 
            d.setLevel(mLevel);
            mDrawableWidth = d.getIntrinsicWidth();
            mDrawableHeight = d.getIntrinsicHeight();
            applyColorMod();
            configureBounds();
        } 
        {
            mDrawableWidth = mDrawableHeight = -1;
        } 
        
        
            
            
        
        
        
            
            
                
            
            
            
            
            
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.773 -0400", hash_original_method = "E1DD34F979587974CF0EAF8DF3CFC3FF", hash_generated_method = "884660ED6EE19AFB34FDDACAE0EC5E99")
    private void resizeFromDrawable() {
        Drawable d = mDrawable;
        {
            int w = d.getIntrinsicWidth();
            w = mDrawableWidth;
            int h = d.getIntrinsicHeight();
            h = mDrawableHeight;
            {
                mDrawableWidth = w;
                mDrawableHeight = h;
                requestLayout();
            } 
        } 
        
        
        
            
            
            
            
            
                
                
                
            
        
    }

    
    private static Matrix.ScaleToFit scaleTypeToScaleToFit(ScaleType st) {
        return sS2FArray[st.nativeInt - 1];
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.775 -0400", hash_original_method = "5D5C8E0C5B3B131983F43D2E85F23CCE", hash_generated_method = "5171099EE283EC2D7DA58AF4F42A4B60")
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        
        resolveUri();
        int w;
        int h;
        float desiredAspect = 0.0f;
        boolean resizeWidth = false;
        boolean resizeHeight = false;
        final int widthSpecMode = MeasureSpec.getMode(widthMeasureSpec);
        final int heightSpecMode = MeasureSpec.getMode(heightMeasureSpec);
        {
            mDrawableWidth = -1;
            mDrawableHeight = -1;
            w = h = 0;
        } 
        {
            w = mDrawableWidth;
            h = mDrawableHeight;
            w = 1;
            h = 1;
            {
                resizeWidth = widthSpecMode != MeasureSpec.EXACTLY;
                resizeHeight = heightSpecMode != MeasureSpec.EXACTLY;
                desiredAspect = (float) w / (float) h;
            } 
        } 
        int pleft = mPaddingLeft;
        int pright = mPaddingRight;
        int ptop = mPaddingTop;
        int pbottom = mPaddingBottom;
        int widthSize;
        int heightSize;
        {
            widthSize = resolveAdjustedSize(w + pleft + pright, mMaxWidth, widthMeasureSpec);
            heightSize = resolveAdjustedSize(h + ptop + pbottom, mMaxHeight, heightMeasureSpec);
            {
                float actualAspect = (float)(widthSize - pleft - pright) /
                                        (heightSize - ptop - pbottom);
                {
                    boolean var659D7277B9251B22E516EA6035BDC5A3_410012910 = (Math.abs(actualAspect - desiredAspect) > 0.0000001);
                    {
                        boolean done = false;
                        {
                            int newWidth = (int)(desiredAspect * (heightSize - ptop - pbottom)) +
                                pleft + pright;
                            {
                                widthSize = newWidth;
                                done = true;
                            } 
                        } 
                        {
                            int newHeight = (int)((widthSize - pleft - pright) / desiredAspect) +
                                ptop + pbottom;
                            {
                                heightSize = newHeight;
                            } 
                        } 
                    } 
                } 
            } 
        } 
        {
            w += pleft + pright;
            h += ptop + pbottom;
            w = Math.max(w, getSuggestedMinimumWidth());
            h = Math.max(h, getSuggestedMinimumHeight());
            widthSize = resolveSizeAndState(w, widthMeasureSpec, 0);
            heightSize = resolveSizeAndState(h, heightMeasureSpec, 0);
        } 
        setMeasuredDimension(widthSize, heightSize);
        addTaint(widthMeasureSpec);
        addTaint(heightMeasureSpec);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.776 -0400", hash_original_method = "6790E6B3204D72187344DF3593244181", hash_generated_method = "D707244ADE7604EBDD003B0A3EA4A6FD")
    private int resolveAdjustedSize(int desiredSize, int maxSize,
                                   int measureSpec) {
        int result = desiredSize;
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);
        
        result = Math.min(desiredSize, maxSize);
        
        
        result = Math.min(Math.min(desiredSize, specSize), maxSize);
        
        
        result = specSize;
        
        addTaint(desiredSize);
        addTaint(maxSize);
        addTaint(measureSpec);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_584423431 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_584423431;
        
        
        
        
        
            
                
                
            
                
                
            
                
                
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.777 -0400", hash_original_method = "7ED99727E4B1435AFDB83292B92819BD", hash_generated_method = "6B60A3AA0E3145819BD7B6F828827A9E")
    @Override
    protected boolean setFrame(int l, int t, int r, int b) {
        boolean changed = super.setFrame(l, t, r, b);
        mHaveFrame = true;
        configureBounds();
        addTaint(l);
        addTaint(t);
        addTaint(r);
        addTaint(b);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_958311926 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_958311926;
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.778 -0400", hash_original_method = "3A8E22D575255E0F3266968983CC3C02", hash_generated_method = "F874886E8E0FD8261FB546BC96CDBC94")
    private void configureBounds() {
        int dwidth = mDrawableWidth;
        int dheight = mDrawableHeight;
        int vwidth = getWidth() - mPaddingLeft - mPaddingRight;
        int vheight = getHeight() - mPaddingTop - mPaddingBottom;
        boolean fits = (dwidth < 0 || vwidth == dwidth) &&
                       (dheight < 0 || vheight == dheight);
        {
            mDrawable.setBounds(0, 0, vwidth, vheight);
            mDrawMatrix = null;
        } 
        {
            mDrawable.setBounds(0, 0, dwidth, dheight);
            {
                {
                    boolean var807A3C6E5DF9AC9E8557F287A85C43B9_937269436 = (mMatrix.isIdentity());
                    {
                        mDrawMatrix = null;
                    } 
                    {
                        mDrawMatrix = mMatrix;
                    } 
                } 
            } 
            {
                mDrawMatrix = null;
            } 
            {
                mDrawMatrix = mMatrix;
                mDrawMatrix.setTranslate((int) ((vwidth - dwidth) * 0.5f + 0.5f),
                                         (int) ((vheight - dheight) * 0.5f + 0.5f));
            } 
            {
                mDrawMatrix = mMatrix;
                float scale;
                float dx = 0;
                float dy = 0;
                {
                    scale = (float) vheight / (float) dheight;
                    dx = (vwidth - dwidth * scale) * 0.5f;
                } 
                {
                    scale = (float) vwidth / (float) dwidth;
                    dy = (vheight - dheight * scale) * 0.5f;
                } 
                mDrawMatrix.setScale(scale, scale);
                mDrawMatrix.postTranslate((int) (dx + 0.5f), (int) (dy + 0.5f));
            } 
            {
                mDrawMatrix = mMatrix;
                float scale;
                float dx;
                float dy;
                {
                    scale = 1.0f;
                } 
                {
                    scale = Math.min((float) vwidth / (float) dwidth,
                            (float) vheight / (float) dheight);
                } 
                dx = (int) ((vwidth - dwidth * scale) * 0.5f + 0.5f);
                dy = (int) ((vheight - dheight * scale) * 0.5f + 0.5f);
                mDrawMatrix.setScale(scale, scale);
                mDrawMatrix.postTranslate(dx, dy);
            } 
            {
                mTempSrc.set(0, 0, dwidth, dheight);
                mTempDst.set(0, 0, vwidth, vheight);
                mDrawMatrix = mMatrix;
                mDrawMatrix.setRectToRect(mTempSrc, mTempDst, scaleTypeToScaleToFit(mScaleType));
            } 
        } 
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.778 -0400", hash_original_method = "D78E25577A68DABE40154D5E4D97E50D", hash_generated_method = "8F91584BDD382C437D1714CC28E4338A")
    @Override
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable d = mDrawable;
        {
            boolean var9E4512E9555DA1255DDDA9AE20837176_682973158 = (d != null && d.isStateful());
            {
                d.setState(getDrawableState());
            } 
        } 
        
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.779 -0400", hash_original_method = "355C7834E61DDE917A6F527556974749", hash_generated_method = "9110B6B7544B11FDE7DB7E324161AC95")
    @Override
    protected void onDraw(Canvas canvas) {
        
        super.onDraw(canvas);
        {
            mDrawable.draw(canvas);
        } 
        {
            int saveCount = canvas.getSaveCount();
            canvas.save();
            {
                final int scrollX = mScrollX;
                final int scrollY = mScrollY;
                canvas.clipRect(scrollX + mPaddingLeft, scrollY + mPaddingTop,
                        scrollX + mRight - mLeft - mPaddingRight,
                        scrollY + mBottom - mTop - mPaddingBottom);
            } 
            canvas.translate(mPaddingLeft, mPaddingTop);
            {
                canvas.concat(mDrawMatrix);
            } 
            mDrawable.draw(canvas);
            canvas.restoreToCount(saveCount);
        } 
        addTaint(canvas.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.779 -0400", hash_original_method = "697E0DCA3A40ADA0E60547E8AD02CB08", hash_generated_method = "7BA1179F580F8E9904EFC63F71C82E70")
    @Override
    @ViewDebug.ExportedProperty(category = "layout")
    public int getBaseline() {
        {
            int var0FD144A91B49367E40CB3EFF8BA82D53_1586461543 = (getMeasuredHeight());
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_782791814 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_782791814;
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.780 -0400", hash_original_method = "8108AC4FDDF644F63A2CB47972E74B33", hash_generated_method = "F52E4655157809D4D5DAB9BDFA329E08")
    public void setBaseline(int baseline) {
        {
            mBaseline = baseline;
            requestLayout();
        } 
        
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.780 -0400", hash_original_method = "ACC3D162C0B2FC40FF806607AF970BEE", hash_generated_method = "9F3EADD7128D9E893534C5087EBFBFE4")
    public void setBaselineAlignBottom(boolean aligned) {
        {
            mBaselineAlignBottom = aligned;
            requestLayout();
        } 
        
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.780 -0400", hash_original_method = "7D3365C5D6F47846F65EFD0480835D79", hash_generated_method = "609F97693CF5F67855BCBAF769FEED60")
    public boolean getBaselineAlignBottom() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_754053992 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_754053992;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.780 -0400", hash_original_method = "F0522F608E5F96C5D99BDA1CF055B16B", hash_generated_method = "10272503CBB37208DEF183989CB96CFA")
    public final void setColorFilter(int color, PorterDuff.Mode mode) {
        setColorFilter(new PorterDuffColorFilter(color, mode));
        addTaint(color);
        addTaint(mode.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.781 -0400", hash_original_method = "50A13570451A3C69931555EF0FE8C15D", hash_generated_method = "D6347BFDDC87510138AB2703865BEDE6")
    @RemotableViewMethod
    public final void setColorFilter(int color) {
        setColorFilter(color, PorterDuff.Mode.SRC_ATOP);
        addTaint(color);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.781 -0400", hash_original_method = "B358CFD4AAFD748C624F742F21F12081", hash_generated_method = "5C5D223E65BC6100D1D7D1061123E386")
    public final void clearColorFilter() {
        setColorFilter(null);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.781 -0400", hash_original_method = "0E997722FEDD3E607A6B49B3558418D6", hash_generated_method = "50A2DC2D3B3213E8C9E9E6B4664C560F")
    public void setColorFilter(ColorFilter cf) {
        {
            mColorFilter = cf;
            mColorMod = true;
            applyColorMod();
            invalidate();
        } 
        
        
            
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.782 -0400", hash_original_method = "F29539FC5DE82D33A1732D8CBDF1B3F0", hash_generated_method = "6D36D0C433F7BBF238B97B5A7EB7CF11")
    @RemotableViewMethod
    public void setAlpha(int alpha) {
        alpha &= 0xFF;
        {
            mAlpha = alpha;
            mColorMod = true;
            applyColorMod();
            invalidate();
        } 
        
        
        
            
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.782 -0400", hash_original_method = "91840135D820437FBAEF19E5465CA144", hash_generated_method = "D82B0E771B88C4DF60816FA3343812D8")
    private void applyColorMod() {
        {
            mDrawable = mDrawable.mutate();
            mDrawable.setColorFilter(mColorFilter);
            mDrawable.setAlpha(mAlpha * mViewAlphaScale >> 8);
        } 
        
        
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.782 -0400", hash_original_method = "C6B07741C64FD260DDE5C02AC0455E05", hash_generated_method = "095CF5C3DEBC96A747A3D510DE34B26B")
    @RemotableViewMethod
    @Override
    public void setVisibility(int visibility) {
        super.setVisibility(visibility);
        {
            mDrawable.setVisible(visibility == VISIBLE, false);
        } 
        addTaint(visibility);
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.782 -0400", hash_original_method = "3717E0990FC85EED7B1343A97507698D", hash_generated_method = "EC1E159C12789844B8825972D42E1432")
    @Override
    protected void onAttachedToWindow() {
        
        super.onAttachedToWindow();
        {
            mDrawable.setVisible(getVisibility() == VISIBLE, false);
        } 
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.783 -0400", hash_original_method = "66E6E711A91B2172E1C35BB591AC6445", hash_generated_method = "432FDA0B484BC398E47027374674B201")
    @Override
    protected void onDetachedFromWindow() {
        
        super.onDetachedFromWindow();
        {
            mDrawable.setVisible(false, false);
        } 
        
        
        
            
        
    }

    
    public enum ScaleType {
        MATRIX      (0),
        FIT_XY      (1),
        FIT_START   (2),
        FIT_CENTER  (3),
        FIT_END     (4),
        CENTER      (5),
        CENTER_CROP (6),
        CENTER_INSIDE (7);
        ScaleType(int ni) {
            nativeInt = ni;
        }
        final int nativeInt;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.783 -0400", hash_original_field = "7E568904C4012C80628F09B984FC27AC", hash_generated_field = "49F3AE1F9A33DAD969F75FE221C01603")

    private static final ScaleType[] sScaleTypeArray = {
        ScaleType.MATRIX,
        ScaleType.FIT_XY,
        ScaleType.FIT_START,
        ScaleType.FIT_CENTER,
        ScaleType.FIT_END,
        ScaleType.CENTER,
        ScaleType.CENTER_CROP,
        ScaleType.CENTER_INSIDE
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.783 -0400", hash_original_field = "BABD88A0FAF20FCB5EB18CA03EA603B0", hash_generated_field = "6A6FB41DF0BD10A3E546839DDC4FEEB8")

    private static final Matrix.ScaleToFit[] sS2FArray = {
        Matrix.ScaleToFit.FILL,
        Matrix.ScaleToFit.START,
        Matrix.ScaleToFit.CENTER,
        Matrix.ScaleToFit.END
    };
}

