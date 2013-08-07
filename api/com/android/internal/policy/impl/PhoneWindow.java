package com.android.internal.policy.impl;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import com.android.internal.widget.ActionBarContextView;
import com.android.internal.widget.ActionBarView;
import android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN;
import android.view.WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN;
import android.os.Parcelable;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.WindowManager.LayoutParams.FLAG_SPLIT_TOUCH;
import android.view.View.MeasureSpec.AT_MOST;
import android.view.ViewStub;
import android.view.accessibility.AccessibilityManager;
import android.view.Gravity;
import android.view.View.MeasureSpec.EXACTLY;
import android.os.RemoteException;
import android.os.ServiceManager;
import com.android.internal.view.menu.MenuView;
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT;
import android.view.KeyEvent;
import android.os.Parcel;
import com.android.internal.view.menu.MenuPresenter;
import android.util.DisplayMetrics;
import android.content.res.TypedArray;
import android.view.MenuItem;
import android.view.Menu;
import android.view.animation.Animation;
import android.app.KeyguardManager;
import android.util.TypedValue;
import android.view.MotionEvent;
import com.android.internal.view.menu.MenuDialogHelper;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Window;
import android.content.Context;
import android.graphics.PixelFormat;
import android.view.ViewGroup;
import android.view.IRotationWatcher;
import com.android.internal.view.menu.ListMenuPresenter;
import android.net.Uri;
import com.android.internal.view.menu.ContextMenuBuilder;
import android.graphics.Rect;
import android.media.AudioManager;
import android.util.Log;
import android.view.WindowManager;
import android.view.InputQueue;
import android.widget.PopupWindow;
import android.view.ViewGroup.LayoutParams.MATCH_PARENT;
import android.util.SparseArray;
import android.util.EventLog;
import com.android.internal.view.RootViewSurfaceTaker;
import android.widget.FrameLayout;
import android.view.WindowManager.LayoutParams.FLAG_SHOW_WALLPAPER;
import android.util.AndroidRuntimeException;
import android.view.accessibility.AccessibilityEvent;
import com.android.internal.view.menu.MenuBuilder;
import android.graphics.Canvas;
import android.widget.ImageView;
import android.view.View.MeasureSpec.getMode;
import android.os.Handler;
import android.view.LayoutInflater;
import android.content.res.Configuration;
import android.content.res.Resources;
import java.util.ArrayList;
import android.view.animation.AnimationUtils;
import com.android.internal.view.StandaloneActionMode;
import com.android.internal.widget.ActionBarContainer;
import android.view.ViewManager;
import android.widget.TextView;
import android.content.pm.ActivityInfo;
import java.lang.ref.WeakReference;
import android.view.IWindowManager;
import android.view.SurfaceHolder;
import android.view.WindowManager.LayoutParams.FLAG_LAYOUT_INSET_DECOR;
import android.widget.ProgressBar;
import android.view.KeyCharacterMap;
import com.android.internal.view.menu.IconMenuPresenter;
import android.view.ActionMode;
public class PhoneWindow extends Window implements MenuBuilder.Callback {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:45.584 -0400", hash_original_field = "F5320B1A19E93D38F19B6CFC8676F9A4", hash_generated_field = "95ACC55B530A29CAA54F430C9B86448C")

    final DialogMenuCallback mContextMenuCallback = new DialogMenuCallback(FEATURE_CONTEXT_MENU);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:45.584 -0400", hash_original_field = "5072BC4DD39523B104F3E0C1CACD5B5A", hash_generated_field = "47D43D28019915F57C3413B81393DBF1")

    final TypedValue mMinWidthMajor = new TypedValue();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:45.584 -0400", hash_original_field = "C77829581BA0F7A4EBE80BC4448D174F", hash_generated_field = "F17BAB622E64DF408A2C9BE3F98A96A6")

    final TypedValue mMinWidthMinor = new TypedValue();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:45.585 -0400", hash_original_field = "90456FC221E7A82F02F5F0D86665E9D8", hash_generated_field = "8428AC7F5A866D0A7048C930FB73BCCC")

    private DecorView mDecor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:45.585 -0400", hash_original_field = "839897D0F362B0E8BB44606ED75B363A", hash_generated_field = "8E0340F878B04810E56739FFD75B84A9")

    private ViewGroup mContentParent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:45.595 -0400", hash_original_field = "ACEA65879222CA6C632465524CDAD790", hash_generated_field = "BD3B0DA92EAB99B1B027697EA78E9D1E")

    SurfaceHolder.Callback2 mTakeSurfaceCallback;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:45.596 -0400", hash_original_field = "66D524B49721428D703CB48A07ED8139", hash_generated_field = "5BAA76D4E4E0DE78798B238AA6F3425E")

    InputQueue.Callback mTakeInputQueueCallback;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:45.597 -0400", hash_original_field = "01BC969D21E145437301B40A04D8E2B4", hash_generated_field = "8231BCDE48FC9E61DC4E5F5FA148DBE8")

    private boolean mIsFloating;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:45.597 -0400", hash_original_field = "C443A03F92046D0F01F0B3A84FC6B50F", hash_generated_field = "6C3DDC70E78FA863A6FCDBA124DEDF31")

    private LayoutInflater mLayoutInflater;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:45.597 -0400", hash_original_field = "5F3FDB05EE6E2581CC95AB22CADCE47B", hash_generated_field = "3B26FAD098CFEC3A217F2BF71097A83E")

    private TextView mTitleView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:45.610 -0400", hash_original_field = "6468B2E0460CFBFD40C03C7A36A45FDF", hash_generated_field = "902F52CE91F4F0B35FAF776BA1B8EFBF")

    private ActionBarView mActionBar;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:45.611 -0400", hash_original_field = "C76A8983378B9978F30181EDAD86139A", hash_generated_field = "2D63799DC87067EBF115EE1210E59821")

    private ActionMenuPresenterCallback mActionMenuPresenterCallback;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:45.611 -0400", hash_original_field = "C66B9289D0939612023584286EBE09C4", hash_generated_field = "ACA75F567C7599A1CFA24FAE34638A0D")

    private PanelMenuPresenterCallback mPanelMenuPresenterCallback;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:45.611 -0400", hash_original_field = "1891CBC78C734C6A7EBB0D921FFE84B0", hash_generated_field = "767FDBB8F872222BECFED3A99B57C740")

    private DrawableFeatureState[] mDrawables;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:45.611 -0400", hash_original_field = "8AE166B2BDF30F64F993F960DBAAF8A0", hash_generated_field = "EE5AF03FBF9E047E8E994E78514B0528")

    private PanelFeatureState[] mPanels;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:45.612 -0400", hash_original_field = "87C55D9CAB09579C49BB4E141E691299", hash_generated_field = "86A3F6C78EC7E204AF3E60249618252B")

    private PanelFeatureState mPreparedPanel;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:45.612 -0400", hash_original_field = "DED0ADDA2C48A62558D6BC06F569AF1A", hash_generated_field = "2BE2FDDAF1146BEABAB6A459B990D35F")

    private int mPanelChordingKey;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:45.612 -0400", hash_original_field = "E801DCBFACBFACFB8F32799D8DCEDCD5", hash_generated_field = "A13A116F2F3503CE06F7EF5C126B6D43")

    private ImageView mLeftIconView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:45.612 -0400", hash_original_field = "3D422984F3E4790439C6131DAF934694", hash_generated_field = "1CFD6FF6010793A881CE41E06B778541")

    private ImageView mRightIconView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:45.613 -0400", hash_original_field = "9B62545C54CD46B48886C7E53C82F27B", hash_generated_field = "B585840B149E3D3ED1514C88B79B4CD2")

    private ProgressBar mCircularProgressBar;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:45.613 -0400", hash_original_field = "61624C793689763BFE87B03200993387", hash_generated_field = "97052469653B51C5358BCF34CBA00ADE")

    private ProgressBar mHorizontalProgressBar;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:45.613 -0400", hash_original_field = "11CE0D8863C04B24F7B47010509D8FDB", hash_generated_field = "ADE98F830F2570B0726600702A86B4A0")

    private int mBackgroundResource = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:45.613 -0400", hash_original_field = "7733B616688B77E3DCA013E96F73F288", hash_generated_field = "410516AED6FBBCDA2128BBEB5CAB7924")

    private Drawable mBackgroundDrawable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:45.613 -0400", hash_original_field = "71EA0EE14C7DFCFACBC5276DB88D71D1", hash_generated_field = "A0A3D2BDF5E15A96ADA6BFFABDF62EB4")

    private int mFrameResource = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:45.613 -0400", hash_original_field = "00FEA2C1795CA1EEEECD400157C49185", hash_generated_field = "6AAE4CB5B8A35B59E33DE63C6CFA5B3E")

    private int mTextColor = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:45.614 -0400", hash_original_field = "279271D164803BEF79B4469B6560FC74", hash_generated_field = "6B14AE954E5B45D9142DA646D7007C94")

    private CharSequence mTitle = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:45.614 -0400", hash_original_field = "31044357223C0CBA3321867ECA01F93C", hash_generated_field = "CF4E9C052F96C3E80581AE8AF634872B")

    private int mTitleColor = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:45.614 -0400", hash_original_field = "88D7ADC29C60EE90F1C974BED7ECB6D2", hash_generated_field = "D321CB5523B4605950975E9A696D7CD1")

    private boolean mAlwaysReadCloseOnTouchAttr = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:45.614 -0400", hash_original_field = "71F686FF5606BDA467F7994D036BFB05", hash_generated_field = "483B35BEA0217F453451A69182B9554E")

    private ContextMenuBuilder mContextMenu;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:45.615 -0400", hash_original_field = "2CE6C0A3060DAB915E103D7584DFD951", hash_generated_field = "009FFF17BCA6134592290D72A4DCEB1D")

    private MenuDialogHelper mContextMenuHelper;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:45.615 -0400", hash_original_field = "715C3749F2C4C7770EEAB78E81F35651", hash_generated_field = "D763D4438E91D226CD56332061BC057B")

    private boolean mClosingActionMenu;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:45.616 -0400", hash_original_field = "4C400581E9047DCBA820ED925BDB72E1", hash_generated_field = "5F947CC49222A84F06DD46264AD2E4EC")

    private int mVolumeControlStreamType = AudioManager.USE_DEFAULT_STREAM_TYPE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:45.616 -0400", hash_original_field = "DC563AE6C758BE979A84432D84FFAC40", hash_generated_field = "B52B11818937F27E927A20CDEBA27654")

    private AudioManager mAudioManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:45.616 -0400", hash_original_field = "03DC26B6F602DABD31F61BB30520DF30", hash_generated_field = "6DF009E5698AB0F7720EA01C775FA0A6")

    private KeyguardManager mKeyguardManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:45.616 -0400", hash_original_field = "253674F74E1B294E4A9200975956FEB4", hash_generated_field = "743DBA3E4653CBFA4300A9A4D9F7A838")

    private int mUiOptions = 0;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:45.617 -0400", hash_original_method = "8D015B335D96416A89D854B2C2996453", hash_generated_method = "B5B23CF52BFEF416BA047D881EE22449")
    public  PhoneWindow(Context context) {
        super(context);
        addTaint(context.getTaint());
mLayoutInflater=LayoutInflater.from(context)
        // ---------- Original Method ----------
        //mLayoutInflater = LayoutInflater.from(context);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:45.618 -0400", hash_original_method = "851B210FC6F7A92B3BF0982F14E70AC6", hash_generated_method = "F2BD600114E81836E045FF177387B56E")
    @Override
    public final void setContainer(Window container) {
        addTaint(container.getTaint());
super.setContainer(container)
        // ---------- Original Method ----------
        //super.setContainer(container);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:45.621 -0400", hash_original_method = "EE4FBA1D4F5AC21CEFE87D4F7BC09473", hash_generated_method = "D08C4F6B9CFDAAAE08E98F1E7E6359D4")
    @Override
    public boolean requestFeature(int featureId) {
        addTaint(featureId);
        if(mContentParent!=null)        
        {
            AndroidRuntimeException var20EB353F575471EB6F4FE0E01365E683_568210002 = new AndroidRuntimeException("requestFeature() must be called before adding content");
            var20EB353F575471EB6F4FE0E01365E683_568210002.addTaint(taint);
            throw var20EB353F575471EB6F4FE0E01365E683_568210002;
        } //End block
        final int features = getFeatures();
        if((features!=DEFAULT_FEATURES)&&(featureId==FEATURE_CUSTOM_TITLE))        
        {
            AndroidRuntimeException var6F4F8FEA885C7EBBD2C36AFB9F5CF4AD_1039933281 = new AndroidRuntimeException("You cannot combine custom titles with other title features");
            var6F4F8FEA885C7EBBD2C36AFB9F5CF4AD_1039933281.addTaint(taint);
            throw var6F4F8FEA885C7EBBD2C36AFB9F5CF4AD_1039933281;
        } //End block
        if(((features&(1<<FEATURE_CUSTOM_TITLE))!=0)&&(featureId!=FEATURE_CUSTOM_TITLE)&&(featureId!=FEATURE_ACTION_MODE_OVERLAY))        
        {
            AndroidRuntimeException var6F4F8FEA885C7EBBD2C36AFB9F5CF4AD_942725356 = new AndroidRuntimeException("You cannot combine custom titles with other title features");
            var6F4F8FEA885C7EBBD2C36AFB9F5CF4AD_942725356.addTaint(taint);
            throw var6F4F8FEA885C7EBBD2C36AFB9F5CF4AD_942725356;
        } //End block
        if((features&(1<<FEATURE_NO_TITLE))!=0&&featureId==FEATURE_ACTION_BAR)        
        {
            boolean var68934A3E9455FA72420237EB05902327_2105947395 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_565522877 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_565522877;
        } //End block
        if((features&(1<<FEATURE_ACTION_BAR))!=0&&featureId==FEATURE_NO_TITLE)        
        {
removeFeature(FEATURE_ACTION_BAR)
        } //End block
        boolean var2F4A2B938BE673A3FEA85B294B923146_1787577903 = (super.requestFeature(featureId));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1898633651 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1898633651;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:45.623 -0400", hash_original_method = "B203457BCC16CD76923B8F805F30138A", hash_generated_method = "D304A94A186E49452518563A09EA4BFD")
    @Override
    public void setUiOptions(int uiOptions) {
        addTaint(uiOptions);
mUiOptions=uiOptions
        // ---------- Original Method ----------
        //mUiOptions = uiOptions;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:45.624 -0400", hash_original_method = "54EFDFAF719B363A685EDF103191E3E2", hash_generated_method = "01F42A780FEB487D9B2C92C5ABA7EE38")
    @Override
    public void setUiOptions(int uiOptions, int mask) {
        addTaint(mask);
        addTaint(uiOptions);
mUiOptions=(mUiOptions&~mask)|(uiOptions&mask)
        // ---------- Original Method ----------
        //mUiOptions = (mUiOptions & ~mask) | (uiOptions & mask);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:45.625 -0400", hash_original_method = "D75D5EA17C4CF41722BD45DFD91B1173", hash_generated_method = "68D1414D320F7E7CC124204BA847C153")
    @Override
    public void setContentView(int layoutResID) {
        addTaint(layoutResID);
        if(mContentParent==null)        
        {
installDecor()
        } //End block
        else
        {
mContentParent.removeAllViews()
        } //End block
mLayoutInflater.inflate(layoutResID, mContentParent)        final Callback cb = getCallback();
        if(cb!=null&&!isDestroyed())        
        {
cb.onContentChanged()
        } //End block
        // ---------- Original Method ----------
        //if (mContentParent == null) {
            //installDecor();
        //} else {
            //mContentParent.removeAllViews();
        //}
        //mLayoutInflater.inflate(layoutResID, mContentParent);
        //final Callback cb = getCallback();
        //if (cb != null && !isDestroyed()) {
            //cb.onContentChanged();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:45.627 -0400", hash_original_method = "2F80C268B0DCCBF11BC0C0E751D2E338", hash_generated_method = "17C16DCAD05D9304C105A91052479733")
    @Override
    public void setContentView(View view) {
        addTaint(view.getTaint());
setContentView(view, new ViewGroup.LayoutParams(MATCH_PARENT, MATCH_PARENT))
        // ---------- Original Method ----------
        //setContentView(view, new ViewGroup.LayoutParams(MATCH_PARENT, MATCH_PARENT));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:45.637 -0400", hash_original_method = "207A7F91B77B9181D3D64AFFE26C03D3", hash_generated_method = "5A86591241C72DC5C75C7F96318AC4CB")
    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        addTaint(params.getTaint());
        addTaint(view.getTaint());
        if(mContentParent==null)        
        {
installDecor()
        } //End block
        else
        {
mContentParent.removeAllViews()
        } //End block
mContentParent.addView(view, params)        final Callback cb = getCallback();
        if(cb!=null&&!isDestroyed())        
        {
cb.onContentChanged()
        } //End block
        // ---------- Original Method ----------
        //if (mContentParent == null) {
            //installDecor();
        //} else {
            //mContentParent.removeAllViews();
        //}
        //mContentParent.addView(view, params);
        //final Callback cb = getCallback();
        //if (cb != null && !isDestroyed()) {
            //cb.onContentChanged();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:45.640 -0400", hash_original_method = "F954C0DD45FFB279B49A4358DA7DC97E", hash_generated_method = "1E62A82C059505C06792E3DABCE86E86")
    @Override
    public void addContentView(View view, ViewGroup.LayoutParams params) {
        addTaint(params.getTaint());
        addTaint(view.getTaint());
        if(mContentParent==null)        
        {
installDecor()
        } //End block
mContentParent.addView(view, params)        final Callback cb = getCallback();
        if(cb!=null&&!isDestroyed())        
        {
cb.onContentChanged()
        } //End block
        // ---------- Original Method ----------
        //if (mContentParent == null) {
            //installDecor();
        //}
        //mContentParent.addView(view, params);
        //final Callback cb = getCallback();
        //if (cb != null && !isDestroyed()) {
            //cb.onContentChanged();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:45.642 -0400", hash_original_method = "A6FBD3A9B959EC01BED03282CA772E2B", hash_generated_method = "2323CC33CF84E4AB701079744BD028CD")
    @Override
    public View getCurrentFocus() {
View var7666A841414A502172ABF30E8FBABE38_968994438 = mDecor!=null?mDecor.findFocus():mDecor.findFocus()        var7666A841414A502172ABF30E8FBABE38_968994438.addTaint(taint);
        return var7666A841414A502172ABF30E8FBABE38_968994438;
        // ---------- Original Method ----------
        //return mDecor != null ? mDecor.findFocus() : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:45.643 -0400", hash_original_method = "5D4C35C77652E46982D1880090805505", hash_generated_method = "313BEC973C2E559988330F58217D71E5")
    @Override
    public void takeSurface(SurfaceHolder.Callback2 callback) {
        addTaint(callback.getTaint());
mTakeSurfaceCallback=callback
        // ---------- Original Method ----------
        //mTakeSurfaceCallback = callback;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:45.644 -0400", hash_original_method = "FDA8F1229F58AC2E44EE2B3BC79C4746", hash_generated_method = "C8312EBD4BAD160C4AFBE5F4FB6CA997")
    public void takeInputQueue(InputQueue.Callback callback) {
        addTaint(callback.getTaint());
mTakeInputQueueCallback=callback
        // ---------- Original Method ----------
        //mTakeInputQueueCallback = callback;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:45.645 -0400", hash_original_method = "6868B0AF77FC71D97D7D4EE9C91BE876", hash_generated_method = "943D89DB73263EF8C3B1B9FA7D254805")
    @Override
    public boolean isFloating() {
        boolean var01BC969D21E145437301B40A04D8E2B4_861186004 = (mIsFloating);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_907965333 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_907965333;
        // ---------- Original Method ----------
        //return mIsFloating;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:45.647 -0400", hash_original_method = "0C8C5CD677120BAE8CAB98F1DD1D8AD1", hash_generated_method = "7D9B31DFC79176A3099D1F2322C28DE8")
    @Override
    public LayoutInflater getLayoutInflater() {
LayoutInflater varF8FA937665041E2C08F6CE2DFA3013F4_1247684458 = mLayoutInflater        varF8FA937665041E2C08F6CE2DFA3013F4_1247684458.addTaint(taint);
        return varF8FA937665041E2C08F6CE2DFA3013F4_1247684458;
        // ---------- Original Method ----------
        //return mLayoutInflater;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:45.648 -0400", hash_original_method = "0A0D9F08BD3D916B98BABE3C885D178C", hash_generated_method = "627AC4D364A68365B5D3E0F934135400")
    @Override
    public void setTitle(CharSequence title) {
        addTaint(title.getTaint());
        if(mTitleView!=null)        
        {
mTitleView.setText(title)
        } //End block
        else
        if(mActionBar!=null)        
        {
mActionBar.setWindowTitle(title)
        } //End block
mTitle=title
        // ---------- Original Method ----------
        //if (mTitleView != null) {
            //mTitleView.setText(title);
        //} else if (mActionBar != null) {
            //mActionBar.setWindowTitle(title);
        //}
        //mTitle = title;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:45.657 -0400", hash_original_method = "828B48DB7587369576933F660D0F4BFE", hash_generated_method = "46D337C8E9AFF8865B5B9D543BAF8868")
    @Override
    public void setTitleColor(int textColor) {
        addTaint(textColor);
        if(mTitleView!=null)        
        {
mTitleView.setTextColor(textColor)
        } //End block
mTitleColor=textColor
        // ---------- Original Method ----------
        //if (mTitleView != null) {
            //mTitleView.setTextColor(textColor);
        //}
        //mTitleColor = textColor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:45.680 -0400", hash_original_method = "EE0C77D92FC36A756898ADBED7752567", hash_generated_method = "6A117E696BBD267CCA6313549D06905A")
    public final boolean preparePanel(PanelFeatureState st, KeyEvent event) {
        addTaint(event.getTaint());
        addTaint(st.getTaint());
        if(isDestroyed())        
        {
            boolean var68934A3E9455FA72420237EB05902327_801846493 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1130739195 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1130739195;
        } //End block
        if(st.isPrepared)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1485038543 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_969204876 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_969204876;
        } //End block
        if((mPreparedPanel!=null)&&(mPreparedPanel!=st))        
        {
closePanel(mPreparedPanel, false)
        } //End block
        final Callback cb = getCallback();
        if(cb!=null)        
        {
st.createdPanelView=cb.onCreatePanelView(st.featureId)
        } //End block
        if(st.createdPanelView==null)        
        {
            if(st.menu==null||st.refreshMenuContent)            
            {
                if(st.menu==null)                
                {
                    if(!initializePanelMenu(st)||(st.menu==null))                    
                    {
                        boolean var68934A3E9455FA72420237EB05902327_1958497316 = (false);
                                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_20963860 = getTaintBoolean();
                        return var84E2C64F38F78BA3EA5C905AB5A2DA27_20963860;
                    } //End block
                } //End block
                if(mActionBar!=null)                
                {
                    if(mActionMenuPresenterCallback==null)                    
                    {
mActionMenuPresenterCallback=new ActionMenuPresenterCallback()
                    } //End block
mActionBar.setMenu(st.menu, mActionMenuPresenterCallback)
                } //End block
st.menu.stopDispatchingItemsChanged()                if((cb==null)||!cb.onCreatePanelMenu(st.featureId, st.menu))                
                {
st.setMenu(null)                    if(mActionBar!=null)                    
                    {
mActionBar.setMenu(null, mActionMenuPresenterCallback)
                    } //End block
                    boolean var68934A3E9455FA72420237EB05902327_1969660908 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1504551395 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1504551395;
                } //End block
st.refreshMenuContent=false
            } //End block
st.menu.stopDispatchingItemsChanged()            if(st.frozenActionViewState!=null)            
            {
st.menu.restoreActionViewStates(st.frozenActionViewState)st.frozenActionViewState=null
            } //End block
            if(!cb.onPreparePanel(st.featureId, st.createdPanelView, st.menu))            
            {
                if(mActionBar!=null)                
                {
mActionBar.setMenu(null, mActionMenuPresenterCallback)
                } //End block
st.menu.startDispatchingItemsChanged()                boolean var68934A3E9455FA72420237EB05902327_112293093 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_861288070 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_861288070;
            } //End block
            KeyCharacterMap kmap = KeyCharacterMap.load(
                    event != null ? event.getDeviceId() : KeyCharacterMap.VIRTUAL_KEYBOARD);
st.qwertyMode=kmap.getKeyboardType()!=KeyCharacterMap.NUMERICst.menu.setQwertyMode(st.qwertyMode)st.menu.startDispatchingItemsChanged()
        } //End block
st.isPrepared=truest.isHandled=falsemPreparedPanel=st        boolean varB326B5062B2F0E69046810717534CB09_473617020 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_155139890 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_155139890;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:45.685 -0400", hash_original_method = "80D331C1266BA038CF9AB2B6B43E6A74", hash_generated_method = "6466EB3E38DF268A14E0A55BDA9058D7")
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(newConfig.getTaint());
        if(mActionBar==null)        
        {
            PanelFeatureState st = getPanelState(FEATURE_OPTIONS_PANEL, false);
            if((st!=null)&&(st.menu!=null))            
            {
                if(st.isOpen)                
                {
                    final Bundle state = new Bundle();
                    if(st.iconMenuPresenter!=null)                    
                    {
st.iconMenuPresenter.saveHierarchyState(state)
                    } //End block
                    if(st.listMenuPresenter!=null)                    
                    {
st.listMenuPresenter.saveHierarchyState(state)
                    } //End block
clearMenuViews(st)reopenMenu(false)                    if(st.iconMenuPresenter!=null)                    
                    {
st.iconMenuPresenter.restoreHierarchyState(state)
                    } //End block
                    if(st.listMenuPresenter!=null)                    
                    {
st.listMenuPresenter.restoreHierarchyState(state)
                    } //End block
                } //End block
                else
                {
clearMenuViews(st)
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        private static void clearMenuViews(PanelFeatureState st) {
        st.createdPanelView = null;
        st.refreshDecorView = true;
        st.clearMenuPresenters();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:45.691 -0400", hash_original_method = "7590CB6F1E92AC687F4A9CA3519DEECE", hash_generated_method = "A0C2298488DD584FE98573ACDE83BB73")
    @Override
    public final void openPanel(int featureId, KeyEvent event) {
        addTaint(event.getTaint());
        addTaint(featureId);
        if(featureId==FEATURE_OPTIONS_PANEL&&mActionBar!=null&&mActionBar.isOverflowReserved())        
        {
            if(mActionBar.getVisibility()==View.VISIBLE)            
            {
mActionBar.showOverflowMenu()
            } //End block
        } //End block
        else
        {
openPanel(getPanelState(featureId, true), event)
        } //End block
        // ---------- Original Method ----------
        //if (featureId == FEATURE_OPTIONS_PANEL && mActionBar != null &&
                //mActionBar.isOverflowReserved()) {
            //if (mActionBar.getVisibility() == View.VISIBLE) {
                //mActionBar.showOverflowMenu();
            //}
        //} else {
            //openPanel(getPanelState(featureId, true), event);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:45.697 -0400", hash_original_method = "A4D6E4CEEE049F3ED74F3C2305867C87", hash_generated_method = "C6A643DDD23F545D8EF00E16EBE4125F")
    private void openPanel(PanelFeatureState st, KeyEvent event) {
        addTaint(event.getTaint());
        addTaint(st.getTaint());
        if(st.isOpen||isDestroyed())        
        {
            return;
        } //End block
        if(st.featureId==FEATURE_OPTIONS_PANEL)        
        {
            Context context = getContext();
            Configuration config = context.getResources().getConfiguration();
            boolean isXLarge = (config.screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) ==
                    Configuration.SCREENLAYOUT_SIZE_XLARGE;
            boolean isHoneycombApp = context.getApplicationInfo().targetSdkVersion >=
                    android.os.Build.VERSION_CODES.HONEYCOMB;
            if(isXLarge&&isHoneycombApp)            
            {
                return;
            } //End block
        } //End block
        Callback cb = getCallback();
        if((cb!=null)&&(!cb.onMenuOpened(st.featureId, st.menu)))        
        {
closePanel(st, true)            return;
        } //End block
        final WindowManager wm = getWindowManager();
        if(wm==null)        
        {
            return;
        } //End block
        if(!preparePanel(st, event))        
        {
            return;
        } //End block
        int width = WRAP_CONTENT;
        if(st.decorView==null||st.refreshDecorView)        
        {
            if(st.decorView==null)            
            {
                if(!initializePanelDecor(st)||(st.decorView==null))                
                return;
            } //End block
            else
            if(st.refreshDecorView&&(st.decorView.getChildCount()>0))            
            {
st.decorView.removeAllViews()
            } //End block
            if(!initializePanelContent(st)||!st.hasPanelItems())            
            {
                return;
            } //End block
            ViewGroup.LayoutParams lp = st.shownPanelView.getLayoutParams();
            if(lp==null)            
            {
lp=new ViewGroup.LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
            } //End block
            int backgroundResId;
            if(lp.width==ViewGroup.LayoutParams.MATCH_PARENT)            
            {
backgroundResId=st.fullBackgroundwidth=MATCH_PARENT
            } //End block
            else
            {
backgroundResId=st.background
            } //End block
st.decorView.setWindowBackground(getContext().getResources().getDrawable(backgroundResId))st.decorView.addView(st.shownPanelView, lp)            if(!st.shownPanelView.hasFocus())            
            {
st.shownPanelView.requestFocus()
            } //End block
        } //End block
        else
        if(!st.isInListMode())        
        {
width=MATCH_PARENT
        } //End block
        else
        if(st.createdPanelView!=null)        
        {
            ViewGroup.LayoutParams lp = st.createdPanelView.getLayoutParams();
            if(lp!=null&&lp.width==ViewGroup.LayoutParams.MATCH_PARENT)            
            {
width=MATCH_PARENT
            } //End block
        } //End block
st.isOpen=truest.isHandled=false        WindowManager.LayoutParams lp = new WindowManager.LayoutParams(
                width, WRAP_CONTENT,
                st.x, st.y, WindowManager.LayoutParams.TYPE_APPLICATION_ATTACHED_DIALOG,
                WindowManager.LayoutParams.FLAG_DITHER
                | WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM
                | WindowManager.LayoutParams.FLAG_SPLIT_TOUCH,
                st.decorView.mDefaultOpacity);
        if(st.isCompact)        
        {
lp.gravity=getOptionsPanelGravity()sRotationWatcher.addWindow(this)
        } //End block
        else
        {
lp.gravity=st.gravity
        } //End block
lp.windowAnimations=st.windowAnimationswm.addView(st.decorView, lp)
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:45.700 -0400", hash_original_method = "5B4B2FF0FFD6B7646227ABB15F082798", hash_generated_method = "9AE160BDB7E73FA86824774F061863AC")
    @Override
    public final void closePanel(int featureId) {
        addTaint(featureId);
        if(featureId==FEATURE_OPTIONS_PANEL&&mActionBar!=null&&mActionBar.isOverflowReserved())        
        {
mActionBar.hideOverflowMenu()
        } //End block
        else
        if(featureId==FEATURE_CONTEXT_MENU)        
        {
closeContextMenu()
        } //End block
        else
        {
closePanel(getPanelState(featureId, true), true)
        } //End block
        // ---------- Original Method ----------
        //if (featureId == FEATURE_OPTIONS_PANEL && mActionBar != null &&
                //mActionBar.isOverflowReserved()) {
            //mActionBar.hideOverflowMenu();
        //} else if (featureId == FEATURE_CONTEXT_MENU) {
            //closeContextMenu();
        //} else {
            //closePanel(getPanelState(featureId, true), true);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:45.710 -0400", hash_original_method = "CC65437B5759A271E45D132221EC0C37", hash_generated_method = "BBD34EFB95BAF085C8230142E81D8736")
    public final void closePanel(PanelFeatureState st, boolean doCallback) {
        addTaint(doCallback);
        addTaint(st.getTaint());
        if(doCallback&&st.featureId==FEATURE_OPTIONS_PANEL&&mActionBar!=null&&mActionBar.isOverflowMenuShowing())        
        {
checkCloseActionMenu(st.menu)            return;
        } //End block
        final ViewManager wm = getWindowManager();
        if((wm!=null)&&st.isOpen)        
        {
            if(st.decorView!=null)            
            {
wm.removeView(st.decorView)                if(st.isCompact)                
                {
sRotationWatcher.removeWindow(this)
                } //End block
            } //End block
            if(doCallback)            
            {
callOnPanelClosed(st.featureId, st, null)
            } //End block
        } //End block
st.isPrepared=falsest.isHandled=falsest.isOpen=falsest.shownPanelView=null        if(st.isInExpandedMode)        
        {
st.refreshDecorView=truest.isInExpandedMode=false
        } //End block
        if(mPreparedPanel==st)        
        {
mPreparedPanel=nullmPanelChordingKey=0
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:45.722 -0400", hash_original_method = "46251BDBE81F95BDECDEF8EF0416CD66", hash_generated_method = "A9764D2DF5E4A8E8000DA4B08EBF4802")
     void checkCloseActionMenu(Menu menu) {
        addTaint(menu.getTaint());
        if(mClosingActionMenu)        
        {
            return;
        } //End block
mClosingActionMenu=truemActionBar.dismissPopupMenus()        Callback cb = getCallback();
        if(cb!=null&&!isDestroyed())        
        {
cb.onPanelClosed(FEATURE_ACTION_BAR, menu)
        } //End block
mClosingActionMenu=false
        // ---------- Original Method ----------
        //if (mClosingActionMenu) {
            //return;
        //}
        //mClosingActionMenu = true;
        //mActionBar.dismissPopupMenus();
        //Callback cb = getCallback();
        //if (cb != null && !isDestroyed()) {
            //cb.onPanelClosed(FEATURE_ACTION_BAR, menu);
        //}
        //mClosingActionMenu = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:45.724 -0400", hash_original_method = "E0D995CC12A9492682F8B37B27652DD2", hash_generated_method = "25E01B1D041ADCD5C5FF76336A4741D2")
    @Override
    public final void togglePanel(int featureId, KeyEvent event) {
        addTaint(event.getTaint());
        addTaint(featureId);
        PanelFeatureState st = getPanelState(featureId, true);
        if(st.isOpen)        
        {
closePanel(st, true)
        } //End block
        else
        {
openPanel(st, event)
        } //End block
        // ---------- Original Method ----------
        //PanelFeatureState st = getPanelState(featureId, true);
        //if (st.isOpen) {
            //closePanel(st, true);
        //} else {
            //openPanel(st, event);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:45.727 -0400", hash_original_method = "52F4DDA17F2088D4569191AD045A1C73", hash_generated_method = "E8B7E5E54D3ECB0919D8512814B6BFC9")
    @Override
    public void invalidatePanelMenu(int featureId) {
        addTaint(featureId);
        PanelFeatureState st = getPanelState(featureId, true);
        Bundle savedActionViewStates = null;
        if(st.menu!=null)        
        {
savedActionViewStates=new Bundle()st.menu.saveActionViewStates(savedActionViewStates)            if(savedActionViewStates.size()>0)            
            {
st.frozenActionViewState=savedActionViewStates
            } //End block
st.menu.stopDispatchingItemsChanged()st.menu.clear()
        } //End block
st.refreshMenuContent=truest.refreshDecorView=true        if((featureId==FEATURE_ACTION_BAR||featureId==FEATURE_OPTIONS_PANEL)&&mActionBar!=null)        
        {
st=getPanelState(Window.FEATURE_OPTIONS_PANEL, false)            if(st!=null)            
            {
st.isPrepared=falsepreparePanel(st, null)
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:45.738 -0400", hash_original_method = "252408DD6BBC7D6C0D224210EF657776", hash_generated_method = "5E32D5C451EFB355320B7BFAB089912D")
    public final boolean onKeyDownPanel(int featureId, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        addTaint(featureId);
        final int keyCode = event.getKeyCode();
        if(event.getRepeatCount()==0)        
        {
mPanelChordingKey=keyCode            PanelFeatureState st = getPanelState(featureId, true);
            if(!st.isOpen)            
            {
                boolean var87F86F7BB59ED17DB3F5C8B04EFDEF4B_2025245594 = (preparePanel(st, event));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1228414629 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1228414629;
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_312186924 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_561945030 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_561945030;
        // ---------- Original Method ----------
        //final int keyCode = event.getKeyCode();
        //if (event.getRepeatCount() == 0) {
            //mPanelChordingKey = keyCode;
            //PanelFeatureState st = getPanelState(featureId, true);
            //if (!st.isOpen) {
                //return preparePanel(st, event);
            //}
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:45.753 -0400", hash_original_method = "349F84160DC9D4AB12A5C16AECD003BA", hash_generated_method = "C46AFCE571154AE654B3D8EF51B059E7")
    public final void onKeyUpPanel(int featureId, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        addTaint(featureId);
        if(mPanelChordingKey!=0)        
        {
mPanelChordingKey=0            if(event.isCanceled()||(mDecor!=null&&mDecor.mActionMode!=null))            
            {
                return;
            } //End block
            boolean playSoundEffect = false;
            final PanelFeatureState st = getPanelState(featureId, true);
            if(featureId==FEATURE_OPTIONS_PANEL&&mActionBar!=null&&mActionBar.isOverflowReserved())            
            {
                if(mActionBar.getVisibility()==View.VISIBLE)                
                {
                    if(!mActionBar.isOverflowMenuShowing())                    
                    {
                        if(!isDestroyed()&&preparePanel(st, event))                        
                        {
playSoundEffect=mActionBar.showOverflowMenu()
                        } //End block
                    } //End block
                    else
                    {
playSoundEffect=mActionBar.hideOverflowMenu()
                    } //End block
                } //End block
            } //End block
            else
            {
                if(st.isOpen||st.isHandled)                
                {
playSoundEffect=st.isOpenclosePanel(st, true)
                } //End block
                else
                if(st.isPrepared)                
                {
                    boolean show = true;
                    if(st.refreshMenuContent)                    
                    {
st.isPrepared=falseshow=preparePanel(st, event)
                    } //End block
                    if(show)                    
                    {
EventLog.writeEvent(50001, 0)openPanel(st, event)playSoundEffect=true
                    } //End block
                } //End block
            } //End block
            if(playSoundEffect)            
            {
                AudioManager audioManager = (AudioManager) getContext().getSystemService(
                        Context.AUDIO_SERVICE);
                if(audioManager!=null)                
                {
audioManager.playSoundEffect(AudioManager.FX_KEY_CLICK)
                } //End block
                else
                {
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:45.756 -0400", hash_original_method = "D047AC54156EF9D0EDB3E78AF9C28DBC", hash_generated_method = "910FEB052A5CA127DDF80E675CDEA854")
    @Override
    public final void closeAllPanels() {
        final ViewManager wm = getWindowManager();
        if(wm==null)        
        {
            return;
        } //End block
        final PanelFeatureState[] panels = mPanels;
        final int N = panels != null ? panels.length : 0;
for(int i = 0;i<N;i)
        {
            final PanelFeatureState panel = panels[i];
            if(panel!=null)            
            {
closePanel(panel, true)
            } //End block
        } //End block
closeContextMenu()
        // ---------- Original Method ----------
        //final ViewManager wm = getWindowManager();
        //if (wm == null) {
            //return;
        //}
        //final PanelFeatureState[] panels = mPanels;
        //final int N = panels != null ? panels.length : 0;
        //for (int i = 0; i < N; i++) {
            //final PanelFeatureState panel = panels[i];
            //if (panel != null) {
                //closePanel(panel, true);
            //}
        //}
        //closeContextMenu();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:45.758 -0400", hash_original_method = "C477892EB4D54847BE399BB644F86306", hash_generated_method = "5F1B7DF2291999A1AC8729F80EBDFF62")
    private synchronized void closeContextMenu() {
        if(mContextMenu!=null)        
        {
mContextMenu.close()dismissContextMenu()
        } //End block
        // ---------- Original Method ----------
        //if (mContextMenu != null) {
            //mContextMenu.close();
            //dismissContextMenu();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:45.759 -0400", hash_original_method = "5C29B59017940973B31BA786981981CA", hash_generated_method = "2590CC1A76CA6DD1CAB0ADCC452BE1B4")
    private synchronized void dismissContextMenu() {
mContextMenu=null        if(mContextMenuHelper!=null)        
        {
mContextMenuHelper.dismiss()mContextMenuHelper=null
        } //End block
        // ---------- Original Method ----------
        //mContextMenu = null;
        //if (mContextMenuHelper != null) {
            //mContextMenuHelper.dismiss();
            //mContextMenuHelper = null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:45.760 -0400", hash_original_method = "51BCA396C69A405D33594324C4BD43F9", hash_generated_method = "746960657C4D488A54B8F20CDAA3EA3E")
    @Override
    public boolean performPanelShortcut(int featureId, int keyCode, KeyEvent event, int flags) {
        addTaint(flags);
        addTaint(event.getTaint());
        addTaint(keyCode);
        addTaint(featureId);
        boolean var4DE08F909BDFC9B293E0D46B84B107FE_650743999 = (performPanelShortcut(getPanelState(featureId, true), keyCode, event, flags));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2024551176 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2024551176;
        // ---------- Original Method ----------
        //return performPanelShortcut(getPanelState(featureId, true), keyCode, event, flags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:45.768 -0400", hash_original_method = "E1B7642B287ED34A43ED1C2679C922A0", hash_generated_method = "AC97B6414B8D868F1FE6B379CEC597FF")
    private boolean performPanelShortcut(PanelFeatureState st, int keyCode, KeyEvent event,
            int flags) {
        addTaint(flags);
        addTaint(event.getTaint());
        addTaint(keyCode);
        addTaint(st.getTaint());
        if(event.isSystem()||(st==null))        
        {
            boolean var68934A3E9455FA72420237EB05902327_1754314853 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_496520217 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_496520217;
        } //End block
        boolean handled = false;
        if((st.isPrepared||preparePanel(st, event))&&st.menu!=null)        
        {
handled=st.menu.performShortcut(keyCode, event, flags)
        } //End block
        if(handled)        
        {
st.isHandled=true            if((flags&Menu.FLAG_PERFORM_NO_CLOSE)==0&&mActionBar==null)            
            {
closePanel(st, true)
            } //End block
        } //End block
        boolean var98F0599AF776A1FE4101C199A40EEB8F_406250999 = (handled);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1015484402 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1015484402;
        // ---------- Original Method ----------
        //if (event.isSystem() || (st == null)) {
            //return false;
        //}
        //boolean handled = false;
        //if ((st.isPrepared || preparePanel(st, event)) && st.menu != null) {
            //handled = st.menu.performShortcut(keyCode, event, flags);
        //}
        //if (handled) {
            //st.isHandled = true;
            //if ((flags & Menu.FLAG_PERFORM_NO_CLOSE) == 0 && mActionBar == null) {
                //closePanel(st, true);
            //}
        //}
        //return handled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:45.786 -0400", hash_original_method = "44A157AC60E3244A8B60F83ED5A36DBA", hash_generated_method = "D7F823BF8BE6BD66D1C84563E1F6FD0E")
    @Override
    public boolean performPanelIdentifierAction(int featureId, int id, int flags) {
        addTaint(flags);
        addTaint(id);
        addTaint(featureId);
        PanelFeatureState st = getPanelState(featureId, true);
        if(!preparePanel(st, new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_MENU)))        
        {
            boolean var68934A3E9455FA72420237EB05902327_64504026 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_963037245 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_963037245;
        } //End block
        if(st.menu==null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1089724022 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_411047755 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_411047755;
        } //End block
        boolean res = st.menu.performIdentifierAction(id, flags);
        if(mActionBar==null)        
        {
closePanel(st, true)
        } //End block
        boolean var9B207167E5381C47682C6B4F58A623FB_1485543413 = (res);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_382920961 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_382920961;
        // ---------- Original Method ----------
        //PanelFeatureState st = getPanelState(featureId, true);
        //if (!preparePanel(st, new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_MENU))) {
            //return false;
        //}
        //if (st.menu == null) {
            //return false;
        //}
        //boolean res = st.menu.performIdentifierAction(id, flags);
        //if (mActionBar == null) {
            //closePanel(st, true);
        //}
        //return res;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:45.789 -0400", hash_original_method = "867C8FFC7255FE2F4B332DD6C1E24B8C", hash_generated_method = "5297388134FF223A7ED7400FA4A506C3")
    public PanelFeatureState findMenuPanel(Menu menu) {
        addTaint(menu.getTaint());
        final PanelFeatureState[] panels = mPanels;
        final int N = panels != null ? panels.length : 0;
for(int i = 0;i<N;i)
        {
            final PanelFeatureState panel = panels[i];
            if(panel!=null&&panel.menu==menu)            
            {
PanelFeatureState var9DEC315723F7AD968D2193C120B1E8FF_1468433651 = panel                var9DEC315723F7AD968D2193C120B1E8FF_1468433651.addTaint(taint);
                return var9DEC315723F7AD968D2193C120B1E8FF_1468433651;
            } //End block
        } //End block
PanelFeatureState var540C13E9E156B687226421B24F2DF178_2020004340 = null        var540C13E9E156B687226421B24F2DF178_2020004340.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_2020004340;
        // ---------- Original Method ----------
        //final PanelFeatureState[] panels = mPanels;
        //final int N = panels != null ? panels.length : 0;
        //for (int i = 0; i < N; i++) {
            //final PanelFeatureState panel = panels[i];
            //if (panel != null && panel.menu == menu) {
                //return panel;
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:45.793 -0400", hash_original_method = "763512CE9A5EEB00449751A552BD96FD", hash_generated_method = "54B239D516A55888E974DA030B543724")
    public boolean onMenuItemSelected(MenuBuilder menu, MenuItem item) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(item.getTaint());
        addTaint(menu.getTaint());
        final Callback cb = getCallback();
        if(cb!=null&&!isDestroyed())        
        {
            final PanelFeatureState panel = findMenuPanel(menu.getRootMenu());
            if(panel!=null)            
            {
                boolean var1410AB6B2204151FD14ED77980F66FDD_6300199 = (cb.onMenuItemSelected(panel.featureId, item));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_300506329 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_300506329;
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1825214113 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_727663505 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_727663505;
        // ---------- Original Method ----------
        //final Callback cb = getCallback();
        //if (cb != null && !isDestroyed()) {
            //final PanelFeatureState panel = findMenuPanel(menu.getRootMenu());
            //if (panel != null) {
                //return cb.onMenuItemSelected(panel.featureId, item);
            //}
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:45.795 -0400", hash_original_method = "EFE2FDC7FD3375DB0A4D3559284FDB73", hash_generated_method = "0F010FF6F386FF3B9C89B635453C1A48")
    public void onMenuModeChange(MenuBuilder menu) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(menu.getTaint());
reopenMenu(true)
        // ---------- Original Method ----------
        //reopenMenu(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:45.798 -0400", hash_original_method = "C4E95D3E989489102F4A74B423CB4A14", hash_generated_method = "43D5F682897D47B1C602440ECD0550CF")
    private void reopenMenu(boolean toggleMenuMode) {
        addTaint(toggleMenuMode);
        if(mActionBar!=null&&mActionBar.isOverflowReserved())        
        {
            final Callback cb = getCallback();
            if(!mActionBar.isOverflowMenuShowing()||!toggleMenuMode)            
            {
                if(cb!=null&&!isDestroyed()&&mActionBar.getVisibility()==View.VISIBLE)                
                {
                    final PanelFeatureState st = getPanelState(FEATURE_OPTIONS_PANEL, true);
                    if(cb.onPreparePanel(FEATURE_OPTIONS_PANEL, st.createdPanelView, st.menu))                    
                    {
cb.onMenuOpened(FEATURE_ACTION_BAR, st.menu)mActionBar.showOverflowMenu()
                    } //End block
                } //End block
            } //End block
            else
            {
mActionBar.hideOverflowMenu()                if(cb!=null&&!isDestroyed())                
                {
                    final PanelFeatureState st = getPanelState(FEATURE_OPTIONS_PANEL, true);
cb.onPanelClosed(FEATURE_ACTION_BAR, st.menu)
                } //End block
            } //End block
            return;
        } //End block
        PanelFeatureState st = getPanelState(FEATURE_OPTIONS_PANEL, true);
        boolean newExpandedMode = toggleMenuMode ? !st.isInExpandedMode : st.isInExpandedMode;
st.refreshDecorView=trueclosePanel(st, false)st.isInExpandedMode=newExpandedModeopenPanel(st, null)
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:45.801 -0400", hash_original_method = "0CB7B5297FAE75526C2E361375C32252", hash_generated_method = "A07AE13FC81ED63D74562A12C01FE91B")
    protected boolean initializePanelMenu(final PanelFeatureState st) {
        addTaint(st.getTaint());
        Context context = getContext();
        if((st.featureId==FEATURE_OPTIONS_PANEL||st.featureId==FEATURE_ACTION_BAR)&&mActionBar!=null)        
        {
            TypedValue outValue = new TypedValue();
            Resources.Theme currentTheme = context.getTheme();
currentTheme.resolveAttribute(com.android.internal.R.attr.actionBarWidgetTheme, outValue, true)            final int targetThemeRes = outValue.resourceId;
            if(targetThemeRes!=0&&context.getThemeResId()!=targetThemeRes)            
            {
context=new ContextThemeWrapper(context, targetThemeRes)
            } //End block
        } //End block
        final MenuBuilder menu = new MenuBuilder(context);
menu.setCallback(this)st.setMenu(menu)        boolean varB326B5062B2F0E69046810717534CB09_1054794481 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_271935746 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_271935746;
        // ---------- Original Method ----------
        //Context context = getContext();
        //if ((st.featureId == FEATURE_OPTIONS_PANEL || st.featureId == FEATURE_ACTION_BAR) &&
                //mActionBar != null) {
            //TypedValue outValue = new TypedValue();
            //Resources.Theme currentTheme = context.getTheme();
            //currentTheme.resolveAttribute(com.android.internal.R.attr.actionBarWidgetTheme,
                    //outValue, true);
            //final int targetThemeRes = outValue.resourceId;
            //if (targetThemeRes != 0 && context.getThemeResId() != targetThemeRes) {
                //context = new ContextThemeWrapper(context, targetThemeRes);
            //}
        //}
        //final MenuBuilder menu = new MenuBuilder(context);
        //menu.setCallback(this);
        //st.setMenu(menu);
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:45.807 -0400", hash_original_method = "8609DA0899A9D091E61F7C0EB3FE466E", hash_generated_method = "20FC458F1A2E32679C671FDE6D1DA7E2")
    protected boolean initializePanelDecor(PanelFeatureState st) {
        addTaint(st.getTaint());
st.decorView=new DecorView(getContext(), st.featureId)st.gravity=Gravity.CENTER|Gravity.BOTTOMst.setStyle(getContext())        boolean varB326B5062B2F0E69046810717534CB09_1874798068 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_65803248 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_65803248;
        // ---------- Original Method ----------
        //st.decorView = new DecorView(getContext(), st.featureId);
        //st.gravity = Gravity.CENTER | Gravity.BOTTOM;
        //st.setStyle(getContext());
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:45.808 -0400", hash_original_method = "AF20B8639DD6B7D06BA58A8F9FA47244", hash_generated_method = "4755E5357B033D65BEE0E8AB58AE322E")
    private int getOptionsPanelGravity() {
        try 
        {
            int varA9E1D0DF9646B230955B42A14A81F4E2_557942781 = (WindowManagerHolder.sWindowManager.getPreferredOptionsPanelGravity());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1197581539 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1197581539;
        } //End block
        catch (RemoteException ex)
        {
            int var2C9254A453D2CDFD99C94C8A3F8DA136_932454103 = (Gravity.CENTER|Gravity.BOTTOM);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2147361884 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2147361884;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return WindowManagerHolder.sWindowManager.getPreferredOptionsPanelGravity();
        //} catch (RemoteException ex) {
            //Log.e(TAG, "Couldn't getOptionsPanelGravity; using default", ex);
            //return Gravity.CENTER | Gravity.BOTTOM;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:45.809 -0400", hash_original_method = "04D270FDAA8AA1F0C2D0DD6D65131315", hash_generated_method = "6AC6BE818C505D3A6F9F128B0B959E5B")
     void onOptionsPanelRotationChanged() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        final PanelFeatureState st = getPanelState(FEATURE_OPTIONS_PANEL, false);
        if(st==null)        
        return;
        final WindowManager.LayoutParams lp = st.decorView != null ?
                (WindowManager.LayoutParams) st.decorView.getLayoutParams() : null;
        if(lp!=null)        
        {
lp.gravity=getOptionsPanelGravity()            final ViewManager wm = getWindowManager();
            if(wm!=null)            
            {
wm.updateViewLayout(st.decorView, lp)
            } //End block
        } //End block
        // ---------- Original Method ----------
        //final PanelFeatureState st = getPanelState(FEATURE_OPTIONS_PANEL, false);
        //if (st == null) return;
        //final WindowManager.LayoutParams lp = st.decorView != null ?
                //(WindowManager.LayoutParams) st.decorView.getLayoutParams() : null;
        //if (lp != null) {
            //lp.gravity = getOptionsPanelGravity();
            //final ViewManager wm = getWindowManager();
            //if (wm != null) {
                //wm.updateViewLayout(st.decorView, lp);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:45.812 -0400", hash_original_method = "44FF06DA313F41C565FAAED46743AB02", hash_generated_method = "98C8D3BB5AF63FE0CE3D2EDE62BDD57F")
    protected boolean initializePanelContent(PanelFeatureState st) {
        addTaint(st.getTaint());
        if(st.createdPanelView!=null)        
        {
st.shownPanelView=st.createdPanelView            boolean varB326B5062B2F0E69046810717534CB09_1878029829 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_261431820 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_261431820;
        } //End block
        if(st.menu==null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1676075399 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1394336783 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1394336783;
        } //End block
        if(mPanelMenuPresenterCallback==null)        
        {
mPanelMenuPresenterCallback=new PanelMenuPresenterCallback()
        } //End block
        MenuView menuView = st.isInListMode()
                ? st.getListMenuView(getContext(), mPanelMenuPresenterCallback)
                : st.getIconMenuView(getContext(), mPanelMenuPresenterCallback);
st.shownPanelView=(View) menuView        if(st.shownPanelView!=null)        
        {
            final int defaultAnimations = menuView.getWindowAnimations();
            if(defaultAnimations!=0)            
            {
st.windowAnimations=defaultAnimations
            } //End block
            boolean varB326B5062B2F0E69046810717534CB09_1282474180 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1998032563 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1998032563;
        } //End block
        else
        {
            boolean var68934A3E9455FA72420237EB05902327_1069068420 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1689978908 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1689978908;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:45.814 -0400", hash_original_method = "CA7B7457AA35CB160404639CFF676774", hash_generated_method = "D5EA46FECBF0DE0151FFE53C8F6C0A41")
    @Override
    public boolean performContextMenuIdentifierAction(int id, int flags) {
        addTaint(flags);
        addTaint(id);
        boolean var320C8A9C3D2F3EF9DCFC01F556B22AF2_876248081 = ((mContextMenu!=null)?mContextMenu.performIdentifierAction(id, flags):mContextMenu.performIdentifierAction(id, flags));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_596042628 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_596042628;
        // ---------- Original Method ----------
        //return (mContextMenu != null) ? mContextMenu.performIdentifierAction(id, flags) : false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:45.815 -0400", hash_original_method = "ACED576C43ABBD9B0E5164F05949E28B", hash_generated_method = "5AB0FE8EAA94D82A30ED83C68A6F9E58")
    @Override
    public final void setBackgroundDrawable(Drawable drawable) {
        addTaint(drawable.getTaint());
        if(drawable!=mBackgroundDrawable||mBackgroundResource!=0)        
        {
mBackgroundResource=0mBackgroundDrawable=drawable            if(mDecor!=null)            
            {
mDecor.setWindowBackground(drawable)
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (drawable != mBackgroundDrawable || mBackgroundResource != 0) {
            //mBackgroundResource = 0;
            //mBackgroundDrawable = drawable;
            //if (mDecor != null) {
                //mDecor.setWindowBackground(drawable);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:45.818 -0400", hash_original_method = "45B844CC596EBBDDD0CB4F8B5C68B49E", hash_generated_method = "CB1884DBC0C7230706F00E164D61335B")
    @Override
    public final void setFeatureDrawableResource(int featureId, int resId) {
        addTaint(resId);
        addTaint(featureId);
        if(resId!=0)        
        {
            DrawableFeatureState st = getDrawableState(featureId, true);
            if(st.resid!=resId)            
            {
st.resid=resIdst.uri=nullst.local=getContext().getResources().getDrawable(resId)updateDrawable(featureId, st, false)
            } //End block
        } //End block
        else
        {
setFeatureDrawable(featureId, null)
        } //End block
        // ---------- Original Method ----------
        //if (resId != 0) {
            //DrawableFeatureState st = getDrawableState(featureId, true);
            //if (st.resid != resId) {
                //st.resid = resId;
                //st.uri = null;
                //st.local = getContext().getResources().getDrawable(resId);
                //updateDrawable(featureId, st, false);
            //}
        //} else {
            //setFeatureDrawable(featureId, null);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:45.820 -0400", hash_original_method = "131D1A266BA336CE14BA6908BBFF1290", hash_generated_method = "E453342F03A2DDAF671DFDD64998E3CE")
    @Override
    public final void setFeatureDrawableUri(int featureId, Uri uri) {
        addTaint(uri.getTaint());
        addTaint(featureId);
        if(uri!=null)        
        {
            DrawableFeatureState st = getDrawableState(featureId, true);
            if(st.uri==null||!st.uri.equals(uri))            
            {
st.resid=0st.uri=urist.local=loadImageURI(uri)updateDrawable(featureId, st, false)
            } //End block
        } //End block
        else
        {
setFeatureDrawable(featureId, null)
        } //End block
        // ---------- Original Method ----------
        //if (uri != null) {
            //DrawableFeatureState st = getDrawableState(featureId, true);
            //if (st.uri == null || !st.uri.equals(uri)) {
                //st.resid = 0;
                //st.uri = uri;
                //st.local = loadImageURI(uri);
                //updateDrawable(featureId, st, false);
            //}
        //} else {
            //setFeatureDrawable(featureId, null);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:45.839 -0400", hash_original_method = "A697C873FEE64901841BB3B0E099D335", hash_generated_method = "F7F62EF5C036793A056470D32FEFE09E")
    @Override
    public final void setFeatureDrawable(int featureId, Drawable drawable) {
        addTaint(drawable.getTaint());
        addTaint(featureId);
        DrawableFeatureState st = getDrawableState(featureId, true);
st.resid=0st.uri=null        if(st.local!=drawable)        
        {
st.local=drawableupdateDrawable(featureId, st, false)
        } //End block
        // ---------- Original Method ----------
        //DrawableFeatureState st = getDrawableState(featureId, true);
        //st.resid = 0;
        //st.uri = null;
        //if (st.local != drawable) {
            //st.local = drawable;
            //updateDrawable(featureId, st, false);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:45.849 -0400", hash_original_method = "2D7BECACD29349D1B7BF498797F7E564", hash_generated_method = "87FCE93FEDFD9A79D4BF79905688B15D")
    @Override
    public void setFeatureDrawableAlpha(int featureId, int alpha) {
        addTaint(alpha);
        addTaint(featureId);
        DrawableFeatureState st = getDrawableState(featureId, true);
        if(st.alpha!=alpha)        
        {
st.alpha=alphaupdateDrawable(featureId, st, false)
        } //End block
        // ---------- Original Method ----------
        //DrawableFeatureState st = getDrawableState(featureId, true);
        //if (st.alpha != alpha) {
            //st.alpha = alpha;
            //updateDrawable(featureId, st, false);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:45.851 -0400", hash_original_method = "3E3DA5003875B6F982B7C3E65791DE26", hash_generated_method = "D28D0A5566CB93F40145B00B5A00BAEF")
    protected final void setFeatureDefaultDrawable(int featureId, Drawable drawable) {
        addTaint(drawable.getTaint());
        addTaint(featureId);
        DrawableFeatureState st = getDrawableState(featureId, true);
        if(st.def!=drawable)        
        {
st.def=drawableupdateDrawable(featureId, st, false)
        } //End block
        // ---------- Original Method ----------
        //DrawableFeatureState st = getDrawableState(featureId, true);
        //if (st.def != drawable) {
            //st.def = drawable;
            //updateDrawable(featureId, st, false);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:45.853 -0400", hash_original_method = "C02BA92F82165C5B0B79B1E338CA185F", hash_generated_method = "9F6AC6DBDDC00412F54324DDA04E9AA8")
    @Override
    public final void setFeatureInt(int featureId, int value) {
        addTaint(value);
        addTaint(featureId);
updateInt(featureId, value, false)
        // ---------- Original Method ----------
        //updateInt(featureId, value, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:45.855 -0400", hash_original_method = "49B9340B6B3FFB63712B4C1E49877CE1", hash_generated_method = "D967B81720CD5C5354D13502ED35C1BE")
    protected final void updateDrawable(int featureId, boolean fromActive) {
        addTaint(fromActive);
        addTaint(featureId);
        final DrawableFeatureState st = getDrawableState(featureId, false);
        if(st!=null)        
        {
updateDrawable(featureId, st, fromActive)
        } //End block
        // ---------- Original Method ----------
        //final DrawableFeatureState st = getDrawableState(featureId, false);
        //if (st != null) {
            //updateDrawable(featureId, st, fromActive);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:45.867 -0400", hash_original_method = "B29F9697304FA6972DBBAF5400AEB8E6", hash_generated_method = "359FE2B6FC2FA548DBB9C371410A85F3")
    protected void onDrawableChanged(int featureId, Drawable drawable, int alpha) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(alpha);
        addTaint(drawable.getTaint());
        addTaint(featureId);
        ImageView view;
        if(featureId==FEATURE_LEFT_ICON)        
        {
view=getLeftIconView()
        } //End block
        else
        if(featureId==FEATURE_RIGHT_ICON)        
        {
view=getRightIconView()
        } //End block
        else
        {
            return;
        } //End block
        if(drawable!=null)        
        {
drawable.setAlpha(alpha)view.setImageDrawable(drawable)view.setVisibility(View.VISIBLE)
        } //End block
        else
        {
view.setVisibility(View.GONE)
        } //End block
        // ---------- Original Method ----------
        //ImageView view;
        //if (featureId == FEATURE_LEFT_ICON) {
            //view = getLeftIconView();
        //} else if (featureId == FEATURE_RIGHT_ICON) {
            //view = getRightIconView();
        //} else {
            //return;
        //}
        //if (drawable != null) {
            //drawable.setAlpha(alpha);
            //view.setImageDrawable(drawable);
            //view.setVisibility(View.VISIBLE);
        //} else {
            //view.setVisibility(View.GONE);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:45.870 -0400", hash_original_method = "99805555129C6E4A610F0B1D50B71419", hash_generated_method = "AEBB385271B74E32D1E2855E98AF2B46")
    protected void onIntChanged(int featureId, int value) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(value);
        addTaint(featureId);
        if(featureId==FEATURE_PROGRESS||featureId==FEATURE_INDETERMINATE_PROGRESS)        
        {
updateProgressBars(value)
        } //End block
        else
        if(featureId==FEATURE_CUSTOM_TITLE)        
        {
            FrameLayout titleContainer = (FrameLayout) findViewById(com.android.internal.R.id.title_container);
            if(titleContainer!=null)            
            {
mLayoutInflater.inflate(value, titleContainer)
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (featureId == FEATURE_PROGRESS || featureId == FEATURE_INDETERMINATE_PROGRESS) {
            //updateProgressBars(value);
        //} else if (featureId == FEATURE_CUSTOM_TITLE) {
            //FrameLayout titleContainer = (FrameLayout) findViewById(com.android.internal.R.id.title_container);
            //if (titleContainer != null) {
                //mLayoutInflater.inflate(value, titleContainer);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:45.872 -0400", hash_original_method = "8EA6D47BD0E2812569551FD757F7ABA6", hash_generated_method = "B7BA992CFED5E97079372D22F60B9BCC")
    private void updateProgressBars(int value) {
        addTaint(value);
        ProgressBar circularProgressBar = getCircularProgressBar(true);
        ProgressBar horizontalProgressBar = getHorizontalProgressBar(true);
        final int features = getLocalFeatures();
        if(value==PROGRESS_VISIBILITY_ON)        
        {
            if((features&(1<<FEATURE_PROGRESS))!=0)            
            {
                int level = horizontalProgressBar.getProgress();
                int visibility = (horizontalProgressBar.isIndeterminate() || level < 10000) ?
                        View.VISIBLE : View.INVISIBLE;
horizontalProgressBar.setVisibility(visibility)
            } //End block
            if((features&(1<<FEATURE_INDETERMINATE_PROGRESS))!=0)            
            {
circularProgressBar.setVisibility(View.VISIBLE)
            } //End block
        } //End block
        else
        if(value==PROGRESS_VISIBILITY_OFF)        
        {
            if((features&(1<<FEATURE_PROGRESS))!=0)            
            {
horizontalProgressBar.setVisibility(View.GONE)
            } //End block
            if((features&(1<<FEATURE_INDETERMINATE_PROGRESS))!=0)            
            {
circularProgressBar.setVisibility(View.GONE)
            } //End block
        } //End block
        else
        if(value==PROGRESS_INDETERMINATE_ON)        
        {
horizontalProgressBar.setIndeterminate(true)
        } //End block
        else
        if(value==PROGRESS_INDETERMINATE_OFF)        
        {
horizontalProgressBar.setIndeterminate(false)
        } //End block
        else
        if(PROGRESS_START<=value&&value<=PROGRESS_END)        
        {
horizontalProgressBar.setProgress(value-PROGRESS_START)            if(value<PROGRESS_END)            
            {
showProgressBars(horizontalProgressBar, circularProgressBar)
            } //End block
            else
            {
hideProgressBars(horizontalProgressBar, circularProgressBar)
            } //End block
        } //End block
        else
        if(PROGRESS_SECONDARY_START<=value&&value<=PROGRESS_SECONDARY_END)        
        {
horizontalProgressBar.setSecondaryProgress(value-PROGRESS_SECONDARY_START)showProgressBars(horizontalProgressBar, circularProgressBar)
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:45.893 -0400", hash_original_method = "7C5ECB935A7CA600D0CE04715CE08C62", hash_generated_method = "4FFB7A3D4BAAAABCD8D95FF15A013064")
    private void showProgressBars(ProgressBar horizontalProgressBar, ProgressBar spinnyProgressBar) {
        addTaint(spinnyProgressBar.getTaint());
        addTaint(horizontalProgressBar.getTaint());
        final int features = getLocalFeatures();
        if((features&(1<<FEATURE_INDETERMINATE_PROGRESS))!=0&&spinnyProgressBar.getVisibility()==View.INVISIBLE)        
        {
spinnyProgressBar.setVisibility(View.VISIBLE)
        } //End block
        if((features&(1<<FEATURE_PROGRESS))!=0&&horizontalProgressBar.getProgress()<10000)        
        {
horizontalProgressBar.setVisibility(View.VISIBLE)
        } //End block
        // ---------- Original Method ----------
        //final int features = getLocalFeatures();
        //if ((features & (1 << FEATURE_INDETERMINATE_PROGRESS)) != 0 &&
                //spinnyProgressBar.getVisibility() == View.INVISIBLE) {
            //spinnyProgressBar.setVisibility(View.VISIBLE);
        //}
        //if ((features & (1 << FEATURE_PROGRESS)) != 0 &&
                //horizontalProgressBar.getProgress() < 10000) {
            //horizontalProgressBar.setVisibility(View.VISIBLE);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:45.898 -0400", hash_original_method = "243E6A2EA5DDE61B3B15FA6CFDB61B23", hash_generated_method = "97FA382330945F00B6877B462E5DB7ED")
    private void hideProgressBars(ProgressBar horizontalProgressBar, ProgressBar spinnyProgressBar) {
        addTaint(spinnyProgressBar.getTaint());
        addTaint(horizontalProgressBar.getTaint());
        final int features = getLocalFeatures();
        Animation anim = AnimationUtils.loadAnimation(getContext(), com.android.internal.R.anim.fade_out);
anim.setDuration(1000)        if((features&(1<<FEATURE_INDETERMINATE_PROGRESS))!=0&&spinnyProgressBar.getVisibility()==View.VISIBLE)        
        {
spinnyProgressBar.startAnimation(anim)spinnyProgressBar.setVisibility(View.INVISIBLE)
        } //End block
        if((features&(1<<FEATURE_PROGRESS))!=0&&horizontalProgressBar.getVisibility()==View.VISIBLE)        
        {
horizontalProgressBar.startAnimation(anim)horizontalProgressBar.setVisibility(View.INVISIBLE)
        } //End block
        // ---------- Original Method ----------
        //final int features = getLocalFeatures();
        //Animation anim = AnimationUtils.loadAnimation(getContext(), com.android.internal.R.anim.fade_out);
        //anim.setDuration(1000);
        //if ((features & (1 << FEATURE_INDETERMINATE_PROGRESS)) != 0 &&
                //spinnyProgressBar.getVisibility() == View.VISIBLE) {
            //spinnyProgressBar.startAnimation(anim);
            //spinnyProgressBar.setVisibility(View.INVISIBLE);
        //}
        //if ((features & (1 << FEATURE_PROGRESS)) != 0 &&
                //horizontalProgressBar.getVisibility() == View.VISIBLE) {
            //horizontalProgressBar.startAnimation(anim);
            //horizontalProgressBar.setVisibility(View.INVISIBLE);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:45.907 -0400", hash_original_method = "7FE31E9E602D3AB764A1CD46CF4C6783", hash_generated_method = "E7F7BD9FB44D5E0DF5B73DD734032633")
    @Override
    public void takeKeyEvents(boolean get) {
        addTaint(get);
mDecor.setFocusable(get)
        // ---------- Original Method ----------
        //mDecor.setFocusable(get);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:45.908 -0400", hash_original_method = "2EFDEC646A6717A04C0E76B26969B9BE", hash_generated_method = "AEC327CA8F1BB5B09D8E143861A0AACC")
    @Override
    public boolean superDispatchKeyEvent(KeyEvent event) {
        addTaint(event.getTaint());
        boolean varADB079E6D391018F880307BC22172914_252230885 = (mDecor.superDispatchKeyEvent(event));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1581001040 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1581001040;
        // ---------- Original Method ----------
        //return mDecor.superDispatchKeyEvent(event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:45.910 -0400", hash_original_method = "EA564678B2CB11DBE13B643148902671", hash_generated_method = "94FF00B02083E979C7DC2D042FA4D225")
    @Override
    public boolean superDispatchKeyShortcutEvent(KeyEvent event) {
        addTaint(event.getTaint());
        boolean varF9542BD71B4B6678CCBF4C967C50D90F_1800987423 = (mDecor.superDispatchKeyShortcutEvent(event));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1995147161 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1995147161;
        // ---------- Original Method ----------
        //return mDecor.superDispatchKeyShortcutEvent(event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:45.912 -0400", hash_original_method = "0522B2C78909B697F460C1F5C5247058", hash_generated_method = "8376B9F8F962C17843D3143F50AB55BB")
    @Override
    public boolean superDispatchTouchEvent(MotionEvent event) {
        addTaint(event.getTaint());
        boolean var7420DE3EB6F9ECE21CB7EA687C8A9D75_557062260 = (mDecor.superDispatchTouchEvent(event));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_921907053 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_921907053;
        // ---------- Original Method ----------
        //return mDecor.superDispatchTouchEvent(event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:45.914 -0400", hash_original_method = "BEFE6F658A5FFF19FF4246F19328E02A", hash_generated_method = "713F74A82327C54B7094232F89A57451")
    @Override
    public boolean superDispatchTrackballEvent(MotionEvent event) {
        addTaint(event.getTaint());
        boolean varF61B0B242991DF211A6FB58C61F89C3B_1213961741 = (mDecor.superDispatchTrackballEvent(event));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1268571288 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1268571288;
        // ---------- Original Method ----------
        //return mDecor.superDispatchTrackballEvent(event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:45.915 -0400", hash_original_method = "D38B85120614ABBF864CAD8F305497E5", hash_generated_method = "D89F57F498821131DB827DD9D3D6628E")
    @Override
    public boolean superDispatchGenericMotionEvent(MotionEvent event) {
        addTaint(event.getTaint());
        boolean varFFD3B777CAA398304B5B2175BD092AD0_1274896398 = (mDecor.superDispatchGenericMotionEvent(event));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1463823914 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1463823914;
        // ---------- Original Method ----------
        //return mDecor.superDispatchGenericMotionEvent(event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:45.917 -0400", hash_original_method = "6C634C70BEE08EA59ADD53E45D289930", hash_generated_method = "1DA0FEF1AAC012C7AA142CA9BFA68125")
    protected boolean onKeyDown(int featureId, int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        addTaint(keyCode);
        addTaint(featureId);
        final KeyEvent.DispatcherState dispatcher = mDecor != null ? mDecor.getKeyDispatcherState() : null;
        switch(keyCode){
        case KeyEvent.KEYCODE_VOLUME_UP:
        case KeyEvent.KEYCODE_VOLUME_DOWN:
        case KeyEvent.KEYCODE_VOLUME_MUTE:
        {
getAudioManager().handleKeyDown(keyCode, mVolumeControlStreamType)            boolean varB326B5062B2F0E69046810717534CB09_80405892 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_78053410 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_78053410;
        } //End block
        case KeyEvent.KEYCODE_MENU:
        {
onKeyDownPanel((featureId<0)?FEATURE_OPTIONS_PANEL:FEATURE_OPTIONS_PANEL, event)            boolean varB326B5062B2F0E69046810717534CB09_1129523123 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2054527097 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2054527097;
        } //End block
        case KeyEvent.KEYCODE_BACK:
        {
            if(event.getRepeatCount()>0)            
            break;
            if(featureId<0)            
            break;
            if(dispatcher!=null)            
            {
dispatcher.startTracking(event, this)
            } //End block
            boolean varB326B5062B2F0E69046810717534CB09_884146724 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_850214422 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_850214422;
        } //End block
}        boolean var68934A3E9455FA72420237EB05902327_1495867347 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_67233021 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_67233021;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:45.921 -0400", hash_original_method = "143948B62B26F527B5CF5806D00596FD", hash_generated_method = "7AF95857094F739978016FF66915CDDF")
    private KeyguardManager getKeyguardManager() {
        if(mKeyguardManager==null)        
        {
mKeyguardManager=(KeyguardManager) getContext().getSystemService(Context.KEYGUARD_SERVICE)
        } //End block
KeyguardManager varAF68817604FA8ED12D2DFB26A7AD71A1_1404459817 = mKeyguardManager        varAF68817604FA8ED12D2DFB26A7AD71A1_1404459817.addTaint(taint);
        return varAF68817604FA8ED12D2DFB26A7AD71A1_1404459817;
        // ---------- Original Method ----------
        //if (mKeyguardManager == null) {
            //mKeyguardManager = (KeyguardManager) getContext().getSystemService(
                    //Context.KEYGUARD_SERVICE);
        //}
        //return mKeyguardManager;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:45.923 -0400", hash_original_method = "C5DEAB5511951B6611278FD26C0E5F9B", hash_generated_method = "DD8223E0AC5F2770C7323A9DBE2B0C4D")
     AudioManager getAudioManager() {
        if(mAudioManager==null)        
        {
mAudioManager=(AudioManager) getContext().getSystemService(Context.AUDIO_SERVICE)
        } //End block
AudioManager var226F0E2B00577D32190D246C077B27CF_139952964 = mAudioManager        var226F0E2B00577D32190D246C077B27CF_139952964.addTaint(taint);
        return var226F0E2B00577D32190D246C077B27CF_139952964;
        // ---------- Original Method ----------
        //if (mAudioManager == null) {
            //mAudioManager = (AudioManager)getContext().getSystemService(Context.AUDIO_SERVICE);
        //}
        //return mAudioManager;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:45.928 -0400", hash_original_method = "BA65B8DFC7A9E6CC6621F7DFF8EFF34E", hash_generated_method = "B601C028AE191B725BDE7AD61918AAA1")
    protected boolean onKeyUp(int featureId, int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        addTaint(keyCode);
        addTaint(featureId);
        final KeyEvent.DispatcherState dispatcher = mDecor != null ? mDecor.getKeyDispatcherState() : null;
        if(dispatcher!=null)        
        {
dispatcher.handleUpEvent(event)
        } //End block
        switch(keyCode){
        case KeyEvent.KEYCODE_VOLUME_UP:
        case KeyEvent.KEYCODE_VOLUME_DOWN:
        case KeyEvent.KEYCODE_VOLUME_MUTE:
        {
getAudioManager().handleKeyUp(keyCode, mVolumeControlStreamType)            boolean varB326B5062B2F0E69046810717534CB09_1534791225 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1498464019 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1498464019;
        } //End block
        case KeyEvent.KEYCODE_MENU:
        {
onKeyUpPanel(featureId<0?FEATURE_OPTIONS_PANEL:FEATURE_OPTIONS_PANEL, event)            boolean varB326B5062B2F0E69046810717534CB09_744028310 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1267298073 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1267298073;
        } //End block
        case KeyEvent.KEYCODE_BACK:
        {
            if(featureId<0)            
            break;
            if(event.isTracking()&&!event.isCanceled())            
            {
                if(featureId==FEATURE_OPTIONS_PANEL)                
                {
                    PanelFeatureState st = getPanelState(featureId, false);
                    if(st!=null&&st.isInExpandedMode)                    
                    {
reopenMenu(true)                        boolean varB326B5062B2F0E69046810717534CB09_864969590 = (true);
                                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1700183879 = getTaintBoolean();
                        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1700183879;
                    } //End block
                } //End block
closePanel(featureId)                boolean varB326B5062B2F0E69046810717534CB09_645936428 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_626514569 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_626514569;
            } //End block
            break;
        } //End block
        case KeyEvent.KEYCODE_SEARCH:
        {
            if(getKeyguardManager().inKeyguardRestrictedInputMode())            
            {
                break;
            } //End block
            if(event.isTracking()&&!event.isCanceled())            
            {
launchDefaultSearch()
            } //End block
            boolean varB326B5062B2F0E69046810717534CB09_1512431564 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_720005826 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_720005826;
        } //End block
}        boolean var68934A3E9455FA72420237EB05902327_843073867 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_182148454 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_182148454;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:45.930 -0400", hash_original_method = "F4763DF42E3D5FE71D9819EC4A894742", hash_generated_method = "FE7294EA55F105520226F6CAEF9D5C93")
    @Override
    protected void onActive() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:45.932 -0400", hash_original_method = "206E0D0A0C2F62DB72AB52E9CD917E0B", hash_generated_method = "1175B57F61B679F02170972A7581573F")
    @Override
    public final View getDecorView() {
        if(mDecor==null)        
        {
installDecor()
        } //End block
View varFAD50FAF5DDB5B35398C01891605E0F0_160503816 = mDecor        varFAD50FAF5DDB5B35398C01891605E0F0_160503816.addTaint(taint);
        return varFAD50FAF5DDB5B35398C01891605E0F0_160503816;
        // ---------- Original Method ----------
        //if (mDecor == null) {
            //installDecor();
        //}
        //return mDecor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:45.933 -0400", hash_original_method = "77A0E6CBFE17072817FFFCDE51F5F6CD", hash_generated_method = "DE9E6B163EFB378BC0E2876607311AD7")
    @Override
    public final View peekDecorView() {
View varFAD50FAF5DDB5B35398C01891605E0F0_564448483 = mDecor        varFAD50FAF5DDB5B35398C01891605E0F0_564448483.addTaint(taint);
        return varFAD50FAF5DDB5B35398C01891605E0F0_564448483;
        // ---------- Original Method ----------
        //return mDecor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:45.935 -0400", hash_original_method = "5EF52D3B91DD2ACEBED198D6549E25ED", hash_generated_method = "168BA618C7D78EE45663621E00EB4C76")
    @Override
    public Bundle saveHierarchyState() {
        Bundle outState = new Bundle();
        if(mContentParent==null)        
        {
Bundle var503179788E53C882E869C0113BEB2581_1336522477 = outState            var503179788E53C882E869C0113BEB2581_1336522477.addTaint(taint);
            return var503179788E53C882E869C0113BEB2581_1336522477;
        } //End block
        SparseArray<Parcelable> states = new SparseArray<Parcelable>();
mContentParent.saveHierarchyState(states)outState.putSparseParcelableArray(VIEWS_TAG, states)        View focusedView = mContentParent.findFocus();
        if(focusedView!=null)        
        {
            if(focusedView.getId()!=View.NO_ID)            
            {
outState.putInt(FOCUSED_ID_TAG, focusedView.getId())
            } //End block
            else
            {
                if(false)                
                {
Log.d(TAG, "couldn't save which view has focus because the focused view "+focusedView+" has no id.")
                } //End block
            } //End block
        } //End block
        SparseArray<Parcelable> panelStates = new SparseArray<Parcelable>();
savePanelState(panelStates)        if(panelStates.size()>0)        
        {
outState.putSparseParcelableArray(PANELS_TAG, panelStates)
        } //End block
        if(mActionBar!=null)        
        {
            SparseArray<Parcelable> actionBarStates = new SparseArray<Parcelable>();
mActionBar.saveHierarchyState(actionBarStates)outState.putSparseParcelableArray(ACTION_BAR_TAG, actionBarStates)
        } //End block
Bundle var503179788E53C882E869C0113BEB2581_1638282113 = outState        var503179788E53C882E869C0113BEB2581_1638282113.addTaint(taint);
        return var503179788E53C882E869C0113BEB2581_1638282113;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:45.937 -0400", hash_original_method = "87A88C193E84809291C15B5930B2094D", hash_generated_method = "5C0375F5774FA1E76E37B4D0E3E05257")
    @Override
    public void restoreHierarchyState(Bundle savedInstanceState) {
        addTaint(savedInstanceState.getTaint());
        if(mContentParent==null)        
        {
            return;
        } //End block
        SparseArray<Parcelable> savedStates = savedInstanceState.getSparseParcelableArray(VIEWS_TAG);
        if(savedStates!=null)        
        {
mContentParent.restoreHierarchyState(savedStates)
        } //End block
        int focusedViewId = savedInstanceState.getInt(FOCUSED_ID_TAG, View.NO_ID);
        if(focusedViewId!=View.NO_ID)        
        {
            View needsFocus = mContentParent.findViewById(focusedViewId);
            if(needsFocus!=null)            
            {
needsFocus.requestFocus()
            } //End block
            else
            {
            } //End block
        } //End block
        SparseArray<Parcelable> panelStates = savedInstanceState.getSparseParcelableArray(PANELS_TAG);
        if(panelStates!=null)        
        {
restorePanelState(panelStates)
        } //End block
        if(mActionBar!=null)        
        {
            SparseArray<Parcelable> actionBarStates = savedInstanceState.getSparseParcelableArray(ACTION_BAR_TAG);
mActionBar.restoreHierarchyState(actionBarStates)
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:45.962 -0400", hash_original_method = "C4638F0E1CD4006F61C027E3CF1EBF1C", hash_generated_method = "452A2543B46ADE4AEDE09B9DFFA728E3")
    private void savePanelState(SparseArray<Parcelable> icicles) {
        addTaint(icicles.getTaint());
        PanelFeatureState[] panels = mPanels;
        if(panels==null)        
        {
            return;
        } //End block
for(int curFeatureId = panels.length - 1;curFeatureId>=0;curFeatureId)
        {
            if(panels[curFeatureId]!=null)            
            {
icicles.put(curFeatureId, panels[curFeatureId].onSaveInstanceState())
            } //End block
        } //End block
        // ---------- Original Method ----------
        //PanelFeatureState[] panels = mPanels;
        //if (panels == null) {
            //return;
        //}
        //for (int curFeatureId = panels.length - 1; curFeatureId >= 0; curFeatureId--) {
            //if (panels[curFeatureId] != null) {
                //icicles.put(curFeatureId, panels[curFeatureId].onSaveInstanceState());
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:45.977 -0400", hash_original_method = "9AF0AECB0B0E1AF8F1164235B09E7625", hash_generated_method = "CA2AE1BEB928128B29777493D7175907")
    private void restorePanelState(SparseArray<Parcelable> icicles) {
        addTaint(icicles.getTaint());
        PanelFeatureState st;
for(int curFeatureId = icicles.size() - 1;curFeatureId>=0;curFeatureId)
        {
st=getPanelState(curFeatureId, false)            if(st==null)            
            {
                continue;
            } //End block
st.onRestoreInstanceState(icicles.get(curFeatureId))invalidatePanelMenu(curFeatureId)
        } //End block
        // ---------- Original Method ----------
        //PanelFeatureState st;
        //for (int curFeatureId = icicles.size() - 1; curFeatureId >= 0; curFeatureId--) {
            //st = getPanelState(curFeatureId, false );
            //if (st == null) {
                //continue;
            //}
            //st.onRestoreInstanceState(icicles.get(curFeatureId));
            //invalidatePanelMenu(curFeatureId);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:45.979 -0400", hash_original_method = "E6DF0D6E3FB721BEC2587806D9A798C3", hash_generated_method = "EE78C7238EDFA122C4593FEA58ECC17B")
    private void openPanelsAfterRestore() {
        PanelFeatureState[] panels = mPanels;
        if(panels==null)        
        {
            return;
        } //End block
        PanelFeatureState st;
for(int i = panels.length - 1;i>=0;i)
        {
st=panels[i]            if(st!=null)            
            {
st.applyFrozenState()                if(!st.isOpen&&st.wasLastOpen)                
                {
st.isInExpandedMode=st.wasLastExpandedopenPanel(st, null)
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        //PanelFeatureState[] panels = mPanels;
        //if (panels == null) {
            //return;
        //}
        //PanelFeatureState st;
        //for (int i = panels.length - 1; i >= 0; i--) {
            //st = panels[i];
            //if (st != null) {
                //st.applyFrozenState();
                //if (!st.isOpen && st.wasLastOpen) {
                    //st.isInExpandedMode = st.wasLastExpanded;
                    //openPanel(st, null);
                //}
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:45.981 -0400", hash_original_method = "E47771B35C825AF94D14ABC07A12E729", hash_generated_method = "C5A429AC79EF7C8A5519EE018726C497")
    protected DecorView generateDecor() {
DecorView var128570CD61FBAC6E30A1AF7058410251_322226695 = new DecorView(getContext(), -1)        var128570CD61FBAC6E30A1AF7058410251_322226695.addTaint(taint);
        return var128570CD61FBAC6E30A1AF7058410251_322226695;
        // ---------- Original Method ----------
        //return new DecorView(getContext(), -1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:45.983 -0400", hash_original_method = "148F0D2186A6AFD20EC0F78EFDBA8FE2", hash_generated_method = "02E964D179335F74F802B4473F86DC1F")
    protected void setFeatureFromAttrs(int featureId, TypedArray attrs,
            int drawableAttr, int alphaAttr) {
        addTaint(alphaAttr);
        addTaint(drawableAttr);
        addTaint(attrs.getTaint());
        addTaint(featureId);
        Drawable d = attrs.getDrawable(drawableAttr);
        if(d!=null)        
        {
requestFeature(featureId)setFeatureDefaultDrawable(featureId, d)
        } //End block
        if((getFeatures()&(1<<featureId))!=0)        
        {
            int alpha = attrs.getInt(alphaAttr, -1);
            if(alpha>=0)            
            {
setFeatureDrawableAlpha(featureId, alpha)
            } //End block
        } //End block
        // ---------- Original Method ----------
        //Drawable d = attrs.getDrawable(drawableAttr);
        //if (d != null) {
            //requestFeature(featureId);
            //setFeatureDefaultDrawable(featureId, d);
        //}
        //if ((getFeatures() & (1 << featureId)) != 0) {
            //int alpha = attrs.getInt(alphaAttr, -1);
            //if (alpha >= 0) {
                //setFeatureDrawableAlpha(featureId, alpha);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.022 -0400", hash_original_method = "5AFC58044E870600C0941A5807A2A5D4", hash_generated_method = "A28ED1B38AF1A17670AAFA7AC91B7959")
    protected ViewGroup generateLayout(DecorView decor) {
        addTaint(decor.getTaint());
        TypedArray a = getWindowStyle();
        if(false)        
        {
System.out.println("From style:")            String s = "Attrs:";
for(int i = 0;i<com.android.internal.R.styleable.Window.length;i)
            {
s=s+" "+Integer.toHexString(com.android.internal.R.styleable.Window[i])+"="+a.getString(i)
            } //End block
System.out.println(s)
        } //End block
mIsFloating=a.getBoolean(com.android.internal.R.styleable.Window_windowIsFloating, false)        int flagsToUpdate = (FLAG_LAYOUT_IN_SCREEN|FLAG_LAYOUT_INSET_DECOR)
                & (~getForcedWindowFlags());
        if(mIsFloating)        
        {
setLayout(WRAP_CONTENT, WRAP_CONTENT)setFlags(0, flagsToUpdate)
        } //End block
        else
        {
setFlags(FLAG_LAYOUT_IN_SCREEN|FLAG_LAYOUT_INSET_DECOR, flagsToUpdate)
        } //End block
        if(a.getBoolean(com.android.internal.R.styleable.Window_windowNoTitle, false))        
        {
requestFeature(FEATURE_NO_TITLE)
        } //End block
        else
        if(a.getBoolean(com.android.internal.R.styleable.Window_windowActionBar, false))        
        {
requestFeature(FEATURE_ACTION_BAR)
        } //End block
        if(a.getBoolean(com.android.internal.R.styleable.Window_windowActionBarOverlay, false))        
        {
requestFeature(FEATURE_ACTION_BAR_OVERLAY)
        } //End block
        if(a.getBoolean(com.android.internal.R.styleable.Window_windowActionModeOverlay, false))        
        {
requestFeature(FEATURE_ACTION_MODE_OVERLAY)
        } //End block
        if(a.getBoolean(com.android.internal.R.styleable.Window_windowFullscreen, false))        
        {
setFlags(FLAG_FULLSCREEN, FLAG_FULLSCREEN&(~getForcedWindowFlags()))
        } //End block
        if(a.getBoolean(com.android.internal.R.styleable.Window_windowShowWallpaper, false))        
        {
setFlags(FLAG_SHOW_WALLPAPER, FLAG_SHOW_WALLPAPER&(~getForcedWindowFlags()))
        } //End block
        if(a.getBoolean(com.android.internal.R.styleable.Window_windowEnableSplitTouch, getContext().getApplicationInfo().targetSdkVersion>=android.os.Build.VERSION_CODES.HONEYCOMB))        
        {
setFlags(FLAG_SPLIT_TOUCH, FLAG_SPLIT_TOUCH&(~getForcedWindowFlags()))
        } //End block
a.getValue(com.android.internal.R.styleable.Window_windowMinWidthMajor, mMinWidthMajor)a.getValue(com.android.internal.R.styleable.Window_windowMinWidthMinor, mMinWidthMinor)        final Context context = getContext();
        final int targetSdk = context.getApplicationInfo().targetSdkVersion;
        final boolean targetPreHoneycomb = targetSdk < android.os.Build.VERSION_CODES.HONEYCOMB;
        final boolean targetPreIcs = targetSdk < android.os.Build.VERSION_CODES.ICE_CREAM_SANDWICH;
        final boolean targetHcNeedsOptions = context.getResources().getBoolean(
                com.android.internal.R.bool.target_honeycomb_needs_options_menu);
        final boolean noActionBar = !hasFeature(FEATURE_ACTION_BAR) || hasFeature(FEATURE_NO_TITLE);
        if(targetPreHoneycomb||(targetPreIcs&&targetHcNeedsOptions&&noActionBar))        
        {
addFlags(WindowManager.LayoutParams.FLAG_NEEDS_MENU_KEY)
        } //End block
        else
        {
clearFlags(WindowManager.LayoutParams.FLAG_NEEDS_MENU_KEY)
        } //End block
        if(mAlwaysReadCloseOnTouchAttr||getContext().getApplicationInfo().targetSdkVersion>=android.os.Build.VERSION_CODES.HONEYCOMB)        
        {
            if(a.getBoolean(com.android.internal.R.styleable.Window_windowCloseOnTouchOutside, false))            
            {
setCloseOnTouchOutsideIfNotSet(true)
            } //End block
        } //End block
        WindowManager.LayoutParams params = getAttributes();
        if(!hasSoftInputMode())        
        {
params.softInputMode=a.getInt(com.android.internal.R.styleable.Window_windowSoftInputMode, params.softInputMode)
        } //End block
        if(a.getBoolean(com.android.internal.R.styleable.Window_backgroundDimEnabled, mIsFloating))        
        {
            if((getForcedWindowFlags()&WindowManager.LayoutParams.FLAG_DIM_BEHIND)==0)            
            {
params.flags|=WindowManager.LayoutParams.FLAG_DIM_BEHIND
            } //End block
            if(!haveDimAmount())            
            {
params.dimAmount=a.getFloat(android.R.styleable.Window_backgroundDimAmount, 0.5f)
            } //End block
        } //End block
        if(params.windowAnimations==0)        
        {
params.windowAnimations=a.getResourceId(com.android.internal.R.styleable.Window_windowAnimationStyle, 0)
        } //End block
        if(getContainer()==null)        
        {
            if(mBackgroundDrawable==null)            
            {
                if(mBackgroundResource==0)                
                {
mBackgroundResource=a.getResourceId(com.android.internal.R.styleable.Window_windowBackground, 0)
                } //End block
                if(mFrameResource==0)                
                {
mFrameResource=a.getResourceId(com.android.internal.R.styleable.Window_windowFrame, 0)
                } //End block
                if(false)                
                {
System.out.println("Background: "+Integer.toHexString(mBackgroundResource)+" Frame: "+Integer.toHexString(mFrameResource))
                } //End block
            } //End block
mTextColor=a.getColor(com.android.internal.R.styleable.Window_textColor, 0xFF000000)
        } //End block
        int layoutResource;
        int features = getLocalFeatures();
        if((features&((1<<FEATURE_LEFT_ICON)|(1<<FEATURE_RIGHT_ICON)))!=0)        
        {
            if(mIsFloating)            
            {
                TypedValue res = new TypedValue();
getContext().getTheme().resolveAttribute(com.android.internal.R.attr.dialogTitleIconsDecorLayout, res, true)layoutResource=res.resourceId
            } //End block
            else
            {
layoutResource=com.android.internal.R.layout.screen_title_icons
            } //End block
removeFeature(FEATURE_ACTION_BAR)
        } //End block
        else
        if((features&((1<<FEATURE_PROGRESS)|(1<<FEATURE_INDETERMINATE_PROGRESS)))!=0&&(features&(1<<FEATURE_ACTION_BAR))==0)        
        {
layoutResource=com.android.internal.R.layout.screen_progress
        } //End block
        else
        if((features&(1<<FEATURE_CUSTOM_TITLE))!=0)        
        {
            if(mIsFloating)            
            {
                TypedValue res = new TypedValue();
getContext().getTheme().resolveAttribute(com.android.internal.R.attr.dialogCustomTitleDecorLayout, res, true)layoutResource=res.resourceId
            } //End block
            else
            {
layoutResource=com.android.internal.R.layout.screen_custom_title
            } //End block
removeFeature(FEATURE_ACTION_BAR)
        } //End block
        else
        if((features&(1<<FEATURE_NO_TITLE))==0)        
        {
            if(mIsFloating)            
            {
                TypedValue res = new TypedValue();
getContext().getTheme().resolveAttribute(com.android.internal.R.attr.dialogTitleDecorLayout, res, true)layoutResource=res.resourceId
            } //End block
            else
            if((features&(1<<FEATURE_ACTION_BAR))!=0)            
            {
                if((features&(1<<FEATURE_ACTION_BAR_OVERLAY))!=0)                
                {
layoutResource=com.android.internal.R.layout.screen_action_bar_overlay
                } //End block
                else
                {
layoutResource=com.android.internal.R.layout.screen_action_bar
                } //End block
            } //End block
            else
            {
layoutResource=com.android.internal.R.layout.screen_title
            } //End block
        } //End block
        else
        if((features&(1<<FEATURE_ACTION_MODE_OVERLAY))!=0)        
        {
layoutResource=com.android.internal.R.layout.screen_simple_overlay_action_mode
        } //End block
        else
        {
layoutResource=com.android.internal.R.layout.screen_simple
        } //End block
mDecor.startChanging()        View in = mLayoutInflater.inflate(layoutResource, null);
decor.addView(in, new ViewGroup.LayoutParams(MATCH_PARENT, MATCH_PARENT))        ViewGroup contentParent = (ViewGroup)findViewById(ID_ANDROID_CONTENT);
        if(contentParent==null)        
        {
            RuntimeException varD79F2FC05D4FEDF68D6CE498EFBB6E2E_362915394 = new RuntimeException("Window couldn't find content container view");
            varD79F2FC05D4FEDF68D6CE498EFBB6E2E_362915394.addTaint(taint);
            throw varD79F2FC05D4FEDF68D6CE498EFBB6E2E_362915394;
        } //End block
        if((features&(1<<FEATURE_INDETERMINATE_PROGRESS))!=0)        
        {
            ProgressBar progress = getCircularProgressBar(false);
            if(progress!=null)            
            {
progress.setIndeterminate(true)
            } //End block
        } //End block
        if(getContainer()==null)        
        {
            Drawable drawable = mBackgroundDrawable;
            if(mBackgroundResource!=0)            
            {
drawable=getContext().getResources().getDrawable(mBackgroundResource)
            } //End block
mDecor.setWindowBackground(drawable)drawable=null            if(mFrameResource!=0)            
            {
drawable=getContext().getResources().getDrawable(mFrameResource)
            } //End block
mDecor.setWindowFrame(drawable)            if(mTitleColor==0)            
            {
mTitleColor=mTextColor
            } //End block
            if(mTitle!=null)            
            {
setTitle(mTitle)
            } //End block
setTitleColor(mTitleColor)
        } //End block
mDecor.finishChanging()ViewGroup var6F2872A6D2C27B576BCBB32A6DB450AC_958297873 = contentParent        var6F2872A6D2C27B576BCBB32A6DB450AC_958297873.addTaint(taint);
        return var6F2872A6D2C27B576BCBB32A6DB450AC_958297873;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.042 -0400", hash_original_method = "80121B1116E6BF302407D713496FA1AE", hash_generated_method = "757274AD74053536F8828ED0237A4834")
    public void alwaysReadCloseOnTouchAttr() {
mAlwaysReadCloseOnTouchAttr=true
        // ---------- Original Method ----------
        //mAlwaysReadCloseOnTouchAttr = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.072 -0400", hash_original_method = "A777DDF843F45D5E21F3672CFBBC64A7", hash_generated_method = "D2D2A5DDEA66083BA96529413206EB6B")
    private void installDecor() {
        if(mDecor==null)        
        {
mDecor=generateDecor()mDecor.setDescendantFocusability(ViewGroup.FOCUS_AFTER_DESCENDANTS)mDecor.setIsRootNamespace(true)
        } //End block
        if(mContentParent==null)        
        {
mContentParent=generateLayout(mDecor)mTitleView=(TextView) findViewById(com.android.internal.R.id.title)            if(mTitleView!=null)            
            {
                if((getLocalFeatures()&(1<<FEATURE_NO_TITLE))!=0)                
                {
                    View titleContainer = findViewById(com.android.internal.R.id.title_container);
                    if(titleContainer!=null)                    
                    {
titleContainer.setVisibility(View.GONE)
                    } //End block
                    else
                    {
mTitleView.setVisibility(View.GONE)
                    } //End block
                    if(mContentParent instanceof FrameLayout)                    
                    {
((FrameLayout) mContentParent).setForeground(null)
                    } //End block
                } //End block
                else
                {
mTitleView.setText(mTitle)
                } //End block
            } //End block
            else
            {
mActionBar=(ActionBarView) findViewById(com.android.internal.R.id.action_bar)                if(mActionBar!=null)                
                {
mActionBar.setWindowCallback(getCallback())                    if(mActionBar.getTitle()==null)                    
                    {
mActionBar.setWindowTitle(mTitle)
                    } //End block
                    final int localFeatures = getLocalFeatures();
                    if((localFeatures&(1<<FEATURE_PROGRESS))!=0)                    
                    {
mActionBar.initProgress()
                    } //End block
                    if((localFeatures&(1<<FEATURE_INDETERMINATE_PROGRESS))!=0)                    
                    {
mActionBar.initIndeterminateProgress()
                    } //End block
                    boolean splitActionBar = false;
                    final boolean splitWhenNarrow = (mUiOptions & ActivityInfo.UIOPTION_SPLIT_ACTION_BAR_WHEN_NARROW) != 0;
                    if(splitWhenNarrow)                    
                    {
splitActionBar=getContext().getResources().getBoolean(com.android.internal.R.bool.split_action_bar_is_narrow)
                    } //End block
                    else
                    {
splitActionBar=getWindowStyle().getBoolean(com.android.internal.R.styleable.Window_windowSplitActionBar, false)
                    } //End block
                    final ActionBarContainer splitView = (ActionBarContainer) findViewById(
                            com.android.internal.R.id.split_action_bar);
                    if(splitView!=null)                    
                    {
mActionBar.setSplitView(splitView)mActionBar.setSplitActionBar(splitActionBar)mActionBar.setSplitWhenNarrow(splitWhenNarrow)                        final ActionBarContextView cab = (ActionBarContextView) findViewById(
                                com.android.internal.R.id.action_context_bar);
cab.setSplitView(splitView)cab.setSplitActionBar(splitActionBar)cab.setSplitWhenNarrow(splitWhenNarrow)
                    } //End block
                    else
                    if(splitActionBar)                    
                    {
                    } //End block
mDecor.post(new Runnable()                    {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.065 -0400", hash_original_method = "9163A3D739BCFFC112271504CA423B78", hash_generated_method = "6ABC638A62DEB302F3D0E8BABAB91278")
        public void run() {
            PanelFeatureState st = getPanelState(FEATURE_OPTIONS_PANEL, false);
            if(!isDestroyed()&&(st==null||st.menu==null))            
            {
invalidatePanelMenu(FEATURE_ACTION_BAR)
            } //End block
            // ---------- Original Method ----------
            //PanelFeatureState st = getPanelState(FEATURE_OPTIONS_PANEL, false);
            //if (!isDestroyed() && (st == null || st.menu == null)) {
                                //invalidatePanelMenu(FEATURE_ACTION_BAR);
                            //}
        }
                    }
)
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.086 -0400", hash_original_method = "536E8DBD59C5DB3B5FB21DF69A35C36A", hash_generated_method = "112887C0029258124A18BEA172FEA029")
    private Drawable loadImageURI(Uri uri) {
        addTaint(uri.getTaint());
        try 
        {
Drawable var2CE261E0862FBC60C7B6E09A110F01E8_1549117723 = Drawable.createFromStream(getContext().getContentResolver().openInputStream(uri), null)            var2CE261E0862FBC60C7B6E09A110F01E8_1549117723.addTaint(taint);
            return var2CE261E0862FBC60C7B6E09A110F01E8_1549117723;
        } //End block
        catch (Exception e)
        {
        } //End block
Drawable var540C13E9E156B687226421B24F2DF178_2019199620 = null        var540C13E9E156B687226421B24F2DF178_2019199620.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_2019199620;
        // ---------- Original Method ----------
        //try {
            //return Drawable.createFromStream(
                    //getContext().getContentResolver().openInputStream(uri), null);
        //} catch (Exception e) {
            //Log.w(TAG, "Unable to open content: " + uri);
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.090 -0400", hash_original_method = "CB62E0457E1D52A5E67B6440C87F0603", hash_generated_method = "4C2744EB25311F1B934A192874BFCCF6")
    private DrawableFeatureState getDrawableState(int featureId, boolean required) {
        addTaint(required);
        addTaint(featureId);
        if((getFeatures()&(1<<featureId))==0)        
        {
            if(!required)            
            {
DrawableFeatureState var540C13E9E156B687226421B24F2DF178_1464487052 = null                var540C13E9E156B687226421B24F2DF178_1464487052.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_1464487052;
            } //End block
            RuntimeException varB2B3451FAE0AF23B15DA7507FB1C6491_197150684 = new RuntimeException("The feature has not been requested");
            varB2B3451FAE0AF23B15DA7507FB1C6491_197150684.addTaint(taint);
            throw varB2B3451FAE0AF23B15DA7507FB1C6491_197150684;
        } //End block
        DrawableFeatureState[] ar;
        if((ar=mDrawables)==null||ar.length<=featureId)        
        {
            DrawableFeatureState[] nar = new DrawableFeatureState[featureId + 1];
            if(ar!=null)            
            {
System.arraycopy(ar, 0, nar, 0, ar.length)
            } //End block
mDrawables=ar=nar
        } //End block
        DrawableFeatureState st = ar[featureId];
        if(st==null)        
        {
ar[featureId]=st=new DrawableFeatureState(featureId)
        } //End block
DrawableFeatureState varAA0158446C9008DEF446ADFDF1B056A8_176049291 = st        varAA0158446C9008DEF446ADFDF1B056A8_176049291.addTaint(taint);
        return varAA0158446C9008DEF446ADFDF1B056A8_176049291;
        // ---------- Original Method ----------
        //if ((getFeatures() & (1 << featureId)) == 0) {
            //if (!required) {
                //return null;
            //}
            //throw new RuntimeException("The feature has not been requested");
        //}
        //DrawableFeatureState[] ar;
        //if ((ar = mDrawables) == null || ar.length <= featureId) {
            //DrawableFeatureState[] nar = new DrawableFeatureState[featureId + 1];
            //if (ar != null) {
                //System.arraycopy(ar, 0, nar, 0, ar.length);
            //}
            //mDrawables = ar = nar;
        //}
        //DrawableFeatureState st = ar[featureId];
        //if (st == null) {
            //ar[featureId] = st = new DrawableFeatureState(featureId);
        //}
        //return st;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.103 -0400", hash_original_method = "360FD9593F979765F5A4B16424552F64", hash_generated_method = "4C1D1A7003E74D46E3DB8338BE78A918")
    private PanelFeatureState getPanelState(int featureId, boolean required) {
        addTaint(required);
        addTaint(featureId);
PanelFeatureState varD3BE70E34988806EF9EE7843335EA19D_483146993 = getPanelState(featureId, required, null)        varD3BE70E34988806EF9EE7843335EA19D_483146993.addTaint(taint);
        return varD3BE70E34988806EF9EE7843335EA19D_483146993;
        // ---------- Original Method ----------
        //return getPanelState(featureId, required, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.107 -0400", hash_original_method = "DEBCEA0D0885896CCDE7F118498C0C79", hash_generated_method = "1E4C69C7849BEDCAC46D284A83AB5CF0")
    private PanelFeatureState getPanelState(int featureId, boolean required,
            PanelFeatureState convertPanelState) {
        addTaint(convertPanelState.getTaint());
        addTaint(required);
        addTaint(featureId);
        if((getFeatures()&(1<<featureId))==0)        
        {
            if(!required)            
            {
PanelFeatureState var540C13E9E156B687226421B24F2DF178_462864142 = null                var540C13E9E156B687226421B24F2DF178_462864142.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_462864142;
            } //End block
            RuntimeException varB2B3451FAE0AF23B15DA7507FB1C6491_1250126691 = new RuntimeException("The feature has not been requested");
            varB2B3451FAE0AF23B15DA7507FB1C6491_1250126691.addTaint(taint);
            throw varB2B3451FAE0AF23B15DA7507FB1C6491_1250126691;
        } //End block
        PanelFeatureState[] ar;
        if((ar=mPanels)==null||ar.length<=featureId)        
        {
            PanelFeatureState[] nar = new PanelFeatureState[featureId + 1];
            if(ar!=null)            
            {
System.arraycopy(ar, 0, nar, 0, ar.length)
            } //End block
mPanels=ar=nar
        } //End block
        PanelFeatureState st = ar[featureId];
        if(st==null)        
        {
ar[featureId]=st=(convertPanelState!=null)?convertPanelState:convertPanelState
        } //End block
PanelFeatureState varAA0158446C9008DEF446ADFDF1B056A8_1921717224 = st        varAA0158446C9008DEF446ADFDF1B056A8_1921717224.addTaint(taint);
        return varAA0158446C9008DEF446ADFDF1B056A8_1921717224;
        // ---------- Original Method ----------
        //if ((getFeatures() & (1 << featureId)) == 0) {
            //if (!required) {
                //return null;
            //}
            //throw new RuntimeException("The feature has not been requested");
        //}
        //PanelFeatureState[] ar;
        //if ((ar = mPanels) == null || ar.length <= featureId) {
            //PanelFeatureState[] nar = new PanelFeatureState[featureId + 1];
            //if (ar != null) {
                //System.arraycopy(ar, 0, nar, 0, ar.length);
            //}
            //mPanels = ar = nar;
        //}
        //PanelFeatureState st = ar[featureId];
        //if (st == null) {
            //ar[featureId] = st = (convertPanelState != null)
                    //? convertPanelState
                    //: new PanelFeatureState(featureId);
        //}
        //return st;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.109 -0400", hash_original_method = "C553B6B37BA8BDA5DA04F3FAB06E8C94", hash_generated_method = "A3EDA07902782882A571A8AD5A2C78A1")
    @Override
    public final void setChildDrawable(int featureId, Drawable drawable) {
        addTaint(drawable.getTaint());
        addTaint(featureId);
        DrawableFeatureState st = getDrawableState(featureId, true);
st.child=drawableupdateDrawable(featureId, st, false)
        // ---------- Original Method ----------
        //DrawableFeatureState st = getDrawableState(featureId, true);
        //st.child = drawable;
        //updateDrawable(featureId, st, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.111 -0400", hash_original_method = "28FF266379CEDA072CD34C4F40AA55F8", hash_generated_method = "7AF800010C3C6E683192595F0DAA82A8")
    @Override
    public final void setChildInt(int featureId, int value) {
        addTaint(value);
        addTaint(featureId);
updateInt(featureId, value, false)
        // ---------- Original Method ----------
        //updateInt(featureId, value, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.116 -0400", hash_original_method = "F1898705D86CC9D5C6009F0485955E98", hash_generated_method = "68A93E39148025C33E0817675BD1786E")
    @Override
    public boolean isShortcutKey(int keyCode, KeyEvent event) {
        addTaint(event.getTaint());
        addTaint(keyCode);
        PanelFeatureState st = getPanelState(FEATURE_OPTIONS_PANEL, true);
        boolean varCDD275E3178BF56FB11BB5FBB8A2A79F_780817163 = (st.menu!=null&&st.menu.isShortcutKey(keyCode, event));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_350710517 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_350710517;
        // ---------- Original Method ----------
        //PanelFeatureState st = getPanelState(FEATURE_OPTIONS_PANEL, true);
        //return st.menu != null && st.menu.isShortcutKey(keyCode, event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.120 -0400", hash_original_method = "3CCEE94FE5E37BA455FCAEC84D077B38", hash_generated_method = "C1CFC6564F465EE3704DE945667F1651")
    private void updateDrawable(int featureId, DrawableFeatureState st, boolean fromResume) {
        addTaint(fromResume);
        addTaint(st.getTaint());
        addTaint(featureId);
        if(mContentParent==null)        
        {
            return;
        } //End block
        final int featureMask = 1 << featureId;
        if((getFeatures()&featureMask)==0&&!fromResume)        
        {
            return;
        } //End block
        Drawable drawable = null;
        if(st!=null)        
        {
drawable=st.child            if(drawable==null)            
drawable=st.local
            if(drawable==null)            
drawable=st.def
        } //End block
        if((getLocalFeatures()&featureMask)==0)        
        {
            if(getContainer()!=null)            
            {
                if(isActive()||fromResume)                
                {
getContainer().setChildDrawable(featureId, drawable)
                } //End block
            } //End block
        } //End block
        else
        if(st!=null&&(st.cur!=drawable||st.curAlpha!=st.alpha))        
        {
st.cur=drawablest.curAlpha=st.alphaonDrawableChanged(featureId, drawable, st.alpha)
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.124 -0400", hash_original_method = "7B5036CEBB31B4EA6BC929F85341E2CA", hash_generated_method = "9F486ADA9D06DBD4B3A7C1149FB2F053")
    private void updateInt(int featureId, int value, boolean fromResume) {
        addTaint(fromResume);
        addTaint(value);
        addTaint(featureId);
        if(mContentParent==null)        
        {
            return;
        } //End block
        final int featureMask = 1 << featureId;
        if((getFeatures()&featureMask)==0&&!fromResume)        
        {
            return;
        } //End block
        if((getLocalFeatures()&featureMask)==0)        
        {
            if(getContainer()!=null)            
            {
getContainer().setChildInt(featureId, value)
            } //End block
        } //End block
        else
        {
onIntChanged(featureId, value)
        } //End block
        // ---------- Original Method ----------
        //if (mContentParent == null) {
            //return;
        //}
        //final int featureMask = 1 << featureId;
        //if ((getFeatures() & featureMask) == 0 && !fromResume) {
            //return;
        //}
        //if ((getLocalFeatures() & featureMask) == 0) {
            //if (getContainer() != null) {
                //getContainer().setChildInt(featureId, value);
            //}
        //} else {
            //onIntChanged(featureId, value);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.127 -0400", hash_original_method = "F2298F4CDF5D51517965C78DC9E51257", hash_generated_method = "D927B52C4EF463A6C7C889E589FBE0F9")
    private ImageView getLeftIconView() {
        if(mLeftIconView!=null)        
        {
ImageView varFC67E11ED47D8D102F053F91C107D26F_1516751859 = mLeftIconView            varFC67E11ED47D8D102F053F91C107D26F_1516751859.addTaint(taint);
            return varFC67E11ED47D8D102F053F91C107D26F_1516751859;
        } //End block
        if(mContentParent==null)        
        {
installDecor()
        } //End block
ImageView var357219E5EDCF2217607EEDE6C3381ACE_1472136920 = (mLeftIconView=(ImageView) findViewById(com.android.internal.R.id.left_icon))        var357219E5EDCF2217607EEDE6C3381ACE_1472136920.addTaint(taint);
        return var357219E5EDCF2217607EEDE6C3381ACE_1472136920;
        // ---------- Original Method ----------
        //if (mLeftIconView != null) {
            //return mLeftIconView;
        //}
        //if (mContentParent == null) {
            //installDecor();
        //}
        //return (mLeftIconView = (ImageView)findViewById(com.android.internal.R.id.left_icon));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.130 -0400", hash_original_method = "5341D43C117308F1EA5834974A02D3B0", hash_generated_method = "B80B4A99318A6B2513003667D1F49BC9")
    private ProgressBar getCircularProgressBar(boolean shouldInstallDecor) {
        addTaint(shouldInstallDecor);
        if(mCircularProgressBar!=null)        
        {
ProgressBar varF63C10A2CDC0835FFF99AF177D6A3D62_758155247 = mCircularProgressBar            varF63C10A2CDC0835FFF99AF177D6A3D62_758155247.addTaint(taint);
            return varF63C10A2CDC0835FFF99AF177D6A3D62_758155247;
        } //End block
        if(mContentParent==null&&shouldInstallDecor)        
        {
installDecor()
        } //End block
mCircularProgressBar=(ProgressBar) findViewById(com.android.internal.R.id.progress_circular)        if(mCircularProgressBar!=null)        
        {
mCircularProgressBar.setVisibility(View.INVISIBLE)
        } //End block
ProgressBar varF63C10A2CDC0835FFF99AF177D6A3D62_1307942853 = mCircularProgressBar        varF63C10A2CDC0835FFF99AF177D6A3D62_1307942853.addTaint(taint);
        return varF63C10A2CDC0835FFF99AF177D6A3D62_1307942853;
        // ---------- Original Method ----------
        //if (mCircularProgressBar != null) {
            //return mCircularProgressBar;
        //}
        //if (mContentParent == null && shouldInstallDecor) {
            //installDecor();
        //}
        //mCircularProgressBar = (ProgressBar) findViewById(com.android.internal.R.id.progress_circular);
        //if (mCircularProgressBar != null) {
            //mCircularProgressBar.setVisibility(View.INVISIBLE);
        //}
        //return mCircularProgressBar;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.141 -0400", hash_original_method = "2F43D710F2C88CD3C87F96C2EEE81295", hash_generated_method = "772FF92AFAB241B4F84D99A2B97FBE97")
    private ProgressBar getHorizontalProgressBar(boolean shouldInstallDecor) {
        addTaint(shouldInstallDecor);
        if(mHorizontalProgressBar!=null)        
        {
ProgressBar varF68E18ADBD8C38807B2FDAC4030732C6_1747797055 = mHorizontalProgressBar            varF68E18ADBD8C38807B2FDAC4030732C6_1747797055.addTaint(taint);
            return varF68E18ADBD8C38807B2FDAC4030732C6_1747797055;
        } //End block
        if(mContentParent==null&&shouldInstallDecor)        
        {
installDecor()
        } //End block
mHorizontalProgressBar=(ProgressBar) findViewById(com.android.internal.R.id.progress_horizontal)        if(mHorizontalProgressBar!=null)        
        {
mHorizontalProgressBar.setVisibility(View.INVISIBLE)
        } //End block
ProgressBar varF68E18ADBD8C38807B2FDAC4030732C6_1590725287 = mHorizontalProgressBar        varF68E18ADBD8C38807B2FDAC4030732C6_1590725287.addTaint(taint);
        return varF68E18ADBD8C38807B2FDAC4030732C6_1590725287;
        // ---------- Original Method ----------
        //if (mHorizontalProgressBar != null) {
            //return mHorizontalProgressBar;
        //}
        //if (mContentParent == null && shouldInstallDecor) {
            //installDecor();
        //}
        //mHorizontalProgressBar = (ProgressBar) findViewById(com.android.internal.R.id.progress_horizontal);
        //if (mHorizontalProgressBar != null) {
            //mHorizontalProgressBar.setVisibility(View.INVISIBLE);
        //}
        //return mHorizontalProgressBar;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.144 -0400", hash_original_method = "C11128126CDA6A423C9D7D9C32D08A3F", hash_generated_method = "DB1F135CBFC83B810B007AE8BE974A91")
    private ImageView getRightIconView() {
        if(mRightIconView!=null)        
        {
ImageView varD67C15144475D0ADF02CAED9B89133F7_1985760174 = mRightIconView            varD67C15144475D0ADF02CAED9B89133F7_1985760174.addTaint(taint);
            return varD67C15144475D0ADF02CAED9B89133F7_1985760174;
        } //End block
        if(mContentParent==null)        
        {
installDecor()
        } //End block
ImageView var0EAA1260C6C1BE68DE4710234F59EB14_1067283789 = (mRightIconView=(ImageView) findViewById(com.android.internal.R.id.right_icon))        var0EAA1260C6C1BE68DE4710234F59EB14_1067283789.addTaint(taint);
        return var0EAA1260C6C1BE68DE4710234F59EB14_1067283789;
        // ---------- Original Method ----------
        //if (mRightIconView != null) {
            //return mRightIconView;
        //}
        //if (mContentParent == null) {
            //installDecor();
        //}
        //return (mRightIconView = (ImageView)findViewById(com.android.internal.R.id.right_icon));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.149 -0400", hash_original_method = "961DDD6D19774ACA5D660F9A48E4B6C6", hash_generated_method = "D5328A28645318320736E9C4011EB8D4")
    private void callOnPanelClosed(int featureId, PanelFeatureState panel, Menu menu) {
        addTaint(menu.getTaint());
        addTaint(panel.getTaint());
        addTaint(featureId);
        final Callback cb = getCallback();
        if(cb==null)        
        return;
        if(menu==null)        
        {
            if(panel==null)            
            {
                if((featureId>=0)&&(featureId<mPanels.length))                
                {
panel=mPanels[featureId]
                } //End block
            } //End block
            if(panel!=null)            
            {
menu=panel.menu
            } //End block
        } //End block
        if((panel!=null)&&(!panel.isOpen))        
        return;
        if(!isDestroyed())        
        {
cb.onPanelClosed(featureId, menu)
        } //End block
        // ---------- Original Method ----------
        //final Callback cb = getCallback();
        //if (cb == null)
            //return;
        //if (menu == null) {
            //if (panel == null) {
                //if ((featureId >= 0) && (featureId < mPanels.length)) {
                    //panel = mPanels[featureId];
                //}
            //}
            //if (panel != null) {
                //menu = panel.menu;
            //}
        //}
        //if ((panel != null) && (!panel.isOpen))
            //return;
        //if (!isDestroyed()) {
            //cb.onPanelClosed(featureId, menu);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.152 -0400", hash_original_method = "00FC7E2CCDD77B49CCDD3550C6576810", hash_generated_method = "811034D0A7EC01AABCC89204FEA32723")
    private boolean launchDefaultSearch() {
        final Callback cb = getCallback();
        if(cb==null||isDestroyed())        
        {
            boolean var68934A3E9455FA72420237EB05902327_1873580571 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1091376542 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1091376542;
        } //End block
        else
        {
sendCloseSystemWindows("search")            boolean var4428BBB9436340272115C7474DEA7661_1951303946 = (cb.onSearchRequested());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1316114883 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1316114883;
        } //End block
        // ---------- Original Method ----------
        //final Callback cb = getCallback();
        //if (cb == null || isDestroyed()) {
            //return false;
        //} else {
            //sendCloseSystemWindows("search");
            //return cb.onSearchRequested();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.154 -0400", hash_original_method = "D1ABA7852AA73E1585CFB9E1D62E7257", hash_generated_method = "6DD94ECA1F090CA01A28CA3FD848B15F")
    @Override
    public void setVolumeControlStream(int streamType) {
        addTaint(streamType);
mVolumeControlStreamType=streamType
        // ---------- Original Method ----------
        //mVolumeControlStreamType = streamType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.155 -0400", hash_original_method = "558996E7046767D2040AA4E9351B5744", hash_generated_method = "8C833B85A9C713BA9B12C9C3330C0CF2")
    @Override
    public int getVolumeControlStream() {
        int var42FD630D7E9B1EEFC055D2B241C4FA2D_1633437685 = (mVolumeControlStreamType);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1136941531 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1136941531;
        // ---------- Original Method ----------
        //return mVolumeControlStreamType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.155 -0400", hash_original_method = "7FA30AD894052EF5BA44E76B84EF7F5D", hash_generated_method = "0DAD593EC0773C8D6AC6D8E0FEEB6BB7")
     void sendCloseSystemWindows() {
PhoneWindowManager.sendCloseSystemWindows(getContext(), null)
        // ---------- Original Method ----------
        //PhoneWindowManager.sendCloseSystemWindows(getContext(), null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.156 -0400", hash_original_method = "897E05BE7D0F70B115BA68B6BAA212E4", hash_generated_method = "9D7958621A884A7BEC9189F38A90A97E")
     void sendCloseSystemWindows(String reason) {
        addTaint(reason.getTaint());
PhoneWindowManager.sendCloseSystemWindows(getContext(), reason)
        // ---------- Original Method ----------
        //PhoneWindowManager.sendCloseSystemWindows(getContext(), reason);
    }

    
    static class WindowManagerHolder {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.162 -0400", hash_original_method = "17C830805B96FF4DBD8528B7318813A3", hash_generated_method = "17C830805B96FF4DBD8528B7318813A3")
        public WindowManagerHolder ()
        {
            //Synthesized constructor
        }


        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.163 -0400", hash_original_field = "BC7100B4BE56CB1AE5D2E2BC6018DDC7", hash_generated_field = "D87993E990891A41DB37BF8DE4D078A1")

        static final IWindowManager sWindowManager = IWindowManager.Stub.asInterface(ServiceManager.getService("window"));
    }


    
    private class PanelMenuPresenterCallback implements MenuPresenter.Callback {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.169 -0400", hash_original_method = "FBE9BBB49C6B2F0E10B2A6B26B5BD1BD", hash_generated_method = "FBE9BBB49C6B2F0E10B2A6B26B5BD1BD")
        public PanelMenuPresenterCallback ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.182 -0400", hash_original_method = "89AA23A948EE7EED3D8E5326BE1708BB", hash_generated_method = "1090A472FBFE58664E7D3D9DFB5A5A36")
        @Override
        public void onCloseMenu(MenuBuilder menu, boolean allMenusAreClosing) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(allMenusAreClosing);
            addTaint(menu.getTaint());
            final Menu parentMenu = menu.getRootMenu();
            final boolean isSubMenu = parentMenu != menu;
            final PanelFeatureState panel = findMenuPanel(isSubMenu ? parentMenu : menu);
            if(panel!=null)            
            {
                if(isSubMenu)                
                {
callOnPanelClosed(panel.featureId, panel, parentMenu)closePanel(panel, true)
                } //End block
                else
                {
closePanel(panel, allMenusAreClosing)
                } //End block
            } //End block
            // ---------- Original Method ----------
            //final Menu parentMenu = menu.getRootMenu();
            //final boolean isSubMenu = parentMenu != menu;
            //final PanelFeatureState panel = findMenuPanel(isSubMenu ? parentMenu : menu);
            //if (panel != null) {
                //if (isSubMenu) {
                    //callOnPanelClosed(panel.featureId, panel, parentMenu);
                    //closePanel(panel, true);
                //} else {
                    //closePanel(panel, allMenusAreClosing);
                //}
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.203 -0400", hash_original_method = "AD09D2FB54FB26DB9CABD44C88CE63B1", hash_generated_method = "136BBC3C2A2218A88C1CA6DA9C1C949C")
        @Override
        public boolean onOpenSubMenu(MenuBuilder subMenu) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(subMenu.getTaint());
            if(subMenu==null&&hasFeature(FEATURE_ACTION_BAR))            
            {
                Callback cb = getCallback();
                if(cb!=null&&!isDestroyed())                
                {
cb.onMenuOpened(FEATURE_ACTION_BAR, subMenu)
                } //End block
            } //End block
            boolean varB326B5062B2F0E69046810717534CB09_29822298 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1767130339 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1767130339;
            // ---------- Original Method ----------
            //if (subMenu == null && hasFeature(FEATURE_ACTION_BAR)) {
                //Callback cb = getCallback();
                //if (cb != null && !isDestroyed()) {
                    //cb.onMenuOpened(FEATURE_ACTION_BAR, subMenu);
                //}
            //}
            //return true;
        }

        
    }


    
    private final class ActionMenuPresenterCallback implements MenuPresenter.Callback {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.204 -0400", hash_original_method = "56F790A381A24AE3E8556C7F3DF93271", hash_generated_method = "56F790A381A24AE3E8556C7F3DF93271")
        public ActionMenuPresenterCallback ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.206 -0400", hash_original_method = "AD31AEB043182D4996702648ACC14F0F", hash_generated_method = "71164FE8037EA44081C5597CF0507867")
        @Override
        public boolean onOpenSubMenu(MenuBuilder subMenu) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(subMenu.getTaint());
            Callback cb = getCallback();
            if(cb!=null)            
            {
cb.onMenuOpened(FEATURE_ACTION_BAR, subMenu)                boolean varB326B5062B2F0E69046810717534CB09_788541047 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_833564580 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_833564580;
            } //End block
            boolean var68934A3E9455FA72420237EB05902327_658051665 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1161791359 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1161791359;
            // ---------- Original Method ----------
            //Callback cb = getCallback();
            //if (cb != null) {
                //cb.onMenuOpened(FEATURE_ACTION_BAR, subMenu);
                //return true;
            //}
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.209 -0400", hash_original_method = "D483ED2D3D9CDAED4469F3D02B258D9E", hash_generated_method = "D6C34B6E693FE137B53FDC2639C54C53")
        @Override
        public void onCloseMenu(MenuBuilder menu, boolean allMenusAreClosing) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(allMenusAreClosing);
            addTaint(menu.getTaint());
checkCloseActionMenu(menu)
            // ---------- Original Method ----------
            //checkCloseActionMenu(menu);
        }

        
    }


    
    private final class DecorView extends FrameLayout implements RootViewSurfaceTaker {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.209 -0400", hash_original_field = "FB00D143B3F186D96D277191DFCDBE03", hash_generated_field = "53CC17511E6B6C718C65EE49831F290D")

        int mDefaultOpacity = PixelFormat.OPAQUE;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.210 -0400", hash_original_field = "F6788959D9AAA549D70D40F26B681311", hash_generated_field = "4B3C60F220A5F7E6DC366F9AC3591532")

        private int mFeatureId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.210 -0400", hash_original_field = "F9498940AA91C07C53017EB8022FD5CB", hash_generated_field = "B381AA27848E3D972BFDF7963CF807F1")

        private final Rect mDrawingBounds = new Rect();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.211 -0400", hash_original_field = "BE4ABA73311CB3209081B42FCEE06D08", hash_generated_field = "71F2ED2A264E36D95EA256439F2DD246")

        private final Rect mBackgroundPadding = new Rect();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.211 -0400", hash_original_field = "77A27A1A87F271054820A4D969D7ED8B", hash_generated_field = "82AF895385C25088A82EDD2B386EC2EA")

        private final Rect mFramePadding = new Rect();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.211 -0400", hash_original_field = "14632CE8413477773E9E9CFBB7E26CDB", hash_generated_field = "CA809735521146E6BD8562E268E5F29A")

        private final Rect mFrameOffsets = new Rect();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.211 -0400", hash_original_field = "0A97B6915CF1C8A4CDCA950627E2AC13", hash_generated_field = "08B71613E0A1B931B1A7B3EB53780771")

        private boolean mChanging;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.212 -0400", hash_original_field = "A2114312A93D0C1DE9535DCA49818616", hash_generated_field = "EB3D874DDC7974BAAE3C959599E9304D")

        private Drawable mMenuBackground;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.212 -0400", hash_original_field = "84E208B2295DD9A36BF48076622C3CC5", hash_generated_field = "8E815DB3DFBEAD7E86FF2D68A1CD6B2D")

        private boolean mWatchingForMenu;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.213 -0400", hash_original_field = "F76302106A0527E8C66B0B19DEEA75C1", hash_generated_field = "68D6639E786752972812E7BE2665B22B")

        private int mDownY;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.213 -0400", hash_original_field = "3B382D379664B509F22D0EB5D96F2BA8", hash_generated_field = "941205D807AC4DF9704A65BDAF4756EC")

        private ActionMode mActionMode;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.213 -0400", hash_original_field = "A9894BDACBD84958450B280A9639A04E", hash_generated_field = "6AF8CE4114D821183495B3FE63EF4711")

        private ActionBarContextView mActionModeView;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.213 -0400", hash_original_field = "E2E2147541BF124E0E1C8F37523901EE", hash_generated_field = "6EA81650104BE66B567812003EDC8220")

        private PopupWindow mActionModePopup;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.214 -0400", hash_original_field = "7752CF816E59903260A364D9639CC0DD", hash_generated_field = "8853191433702ACCD7DBA967DDEEAD69")

        private Runnable mShowActionModePopup;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.214 -0400", hash_original_method = "B73BC23532497707D66D7C14D94C85CA", hash_generated_method = "7ACA61AC47D11D97B17CBED28A151A50")
        public  DecorView(Context context, int featureId) {
            super(context);
            addTaint(featureId);
            addTaint(context.getTaint());
mFeatureId=featureId
            // ---------- Original Method ----------
            //mFeatureId = featureId;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.233 -0400", hash_original_method = "AA7B939797BF77C2F9A71D9407157C2D", hash_generated_method = "F1CDAC37B686F43C5152D9422884F564")
        @Override
        public boolean dispatchKeyEvent(KeyEvent event) {
            addTaint(event.getTaint());
            final int keyCode = event.getKeyCode();
            final int action = event.getAction();
            final boolean isDown = action == KeyEvent.ACTION_DOWN;
            if(isDown&&(event.getRepeatCount()==0))            
            {
                if((mPanelChordingKey>0)&&(mPanelChordingKey!=keyCode))                
                {
                    boolean handled = dispatchKeyShortcutEvent(event);
                    if(handled)                    
                    {
                        boolean varB326B5062B2F0E69046810717534CB09_482092550 = (true);
                                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2074343858 = getTaintBoolean();
                        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2074343858;
                    } //End block
                } //End block
                if((mPreparedPanel!=null)&&mPreparedPanel.isOpen)                
                {
                    if(performPanelShortcut(mPreparedPanel, keyCode, event, 0))                    
                    {
                        boolean varB326B5062B2F0E69046810717534CB09_610539509 = (true);
                                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1115036795 = getTaintBoolean();
                        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1115036795;
                    } //End block
                } //End block
            } //End block
            if(!isDestroyed())            
            {
                final Callback cb = getCallback();
                final boolean handled = cb != null && mFeatureId < 0 ? cb.dispatchKeyEvent(event)
                        : super.dispatchKeyEvent(event);
                if(handled)                
                {
                    boolean varB326B5062B2F0E69046810717534CB09_348532864 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_699506230 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_699506230;
                } //End block
            } //End block
            boolean varAB57A44A610F8E55089D041A9A35EC1F_1154788013 = (isDown?PhoneWindow.this.onKeyDown(mFeatureId, event.getKeyCode(), event):PhoneWindow.this.onKeyDown(mFeatureId, event.getKeyCode(), event));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_574818128 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_574818128;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.254 -0400", hash_original_method = "4A715057CDC04CC88647969FE78DBBA4", hash_generated_method = "338672C38F765937BEA806B99AEC25C2")
        @Override
        public boolean dispatchKeyShortcutEvent(KeyEvent ev) {
            addTaint(ev.getTaint());
            boolean handled;
            if(mPreparedPanel!=null)            
            {
handled=performPanelShortcut(mPreparedPanel, ev.getKeyCode(), ev, Menu.FLAG_PERFORM_NO_CLOSE)                if(handled)                
                {
                    if(mPreparedPanel!=null)                    
                    {
mPreparedPanel.isHandled=true
                    } //End block
                    boolean varB326B5062B2F0E69046810717534CB09_1673026397 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1160484976 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1160484976;
                } //End block
            } //End block
            final Callback cb = getCallback();
handled=cb!=null&&!isDestroyed()&&mFeatureId<0?cb.dispatchKeyShortcutEvent(ev):cb.dispatchKeyShortcutEvent(ev)            if(handled)            
            {
                boolean varB326B5062B2F0E69046810717534CB09_790699234 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1302041747 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1302041747;
            } //End block
            if(mPreparedPanel==null)            
            {
                PanelFeatureState st = getPanelState(FEATURE_OPTIONS_PANEL, true);
preparePanel(st, ev)handled=performPanelShortcut(st, ev.getKeyCode(), ev, Menu.FLAG_PERFORM_NO_CLOSE)st.isPrepared=false                if(handled)                
                {
                    boolean varB326B5062B2F0E69046810717534CB09_811789001 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1785797239 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1785797239;
                } //End block
            } //End block
            boolean var68934A3E9455FA72420237EB05902327_109774971 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_792264549 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_792264549;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.256 -0400", hash_original_method = "9BD2CA6E8373B343CA92825BA31C7C7F", hash_generated_method = "65330BE0D7FB0B2965E72A4A1CF75009")
        @Override
        public boolean dispatchTouchEvent(MotionEvent ev) {
            addTaint(ev.getTaint());
            final Callback cb = getCallback();
            boolean var20D81E4042EB0B3CD3F167E7A13444F2_1735920647 = (cb!=null&&!isDestroyed()&&mFeatureId<0?cb.dispatchTouchEvent(ev):cb.dispatchTouchEvent(ev));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1157129467 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1157129467;
            // ---------- Original Method ----------
            //final Callback cb = getCallback();
            //return cb != null && !isDestroyed() && mFeatureId < 0 ? cb.dispatchTouchEvent(ev)
                    //: super.dispatchTouchEvent(ev);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.257 -0400", hash_original_method = "DD4489500FF8D9BA0936C05EFE16D103", hash_generated_method = "29BBD7CCA6CF5967CC86C7FB06B8B2A8")
        @Override
        public boolean dispatchTrackballEvent(MotionEvent ev) {
            addTaint(ev.getTaint());
            final Callback cb = getCallback();
            boolean varD7626F4C81F1480399CFE207F37E215C_1118984313 = (cb!=null&&!isDestroyed()&&mFeatureId<0?cb.dispatchTrackballEvent(ev):cb.dispatchTrackballEvent(ev));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1961571953 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1961571953;
            // ---------- Original Method ----------
            //final Callback cb = getCallback();
            //return cb != null && !isDestroyed() && mFeatureId < 0 ? cb.dispatchTrackballEvent(ev)
                    //: super.dispatchTrackballEvent(ev);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.260 -0400", hash_original_method = "44E77336AAA991480B13307F35480E3C", hash_generated_method = "E3835595BC5498A334C89129B90167D5")
        @Override
        public boolean dispatchGenericMotionEvent(MotionEvent ev) {
            addTaint(ev.getTaint());
            final Callback cb = getCallback();
            boolean varDF6C21142D32FDC8F7D964D91AF56156_1802618239 = (cb!=null&&!isDestroyed()&&mFeatureId<0?cb.dispatchGenericMotionEvent(ev):cb.dispatchGenericMotionEvent(ev));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1789638207 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1789638207;
            // ---------- Original Method ----------
            //final Callback cb = getCallback();
            //return cb != null && !isDestroyed() && mFeatureId < 0 ? cb.dispatchGenericMotionEvent(ev)
                    //: super.dispatchGenericMotionEvent(ev);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.282 -0400", hash_original_method = "9DB11FD06E14F37DE535D16FD3F9BED3", hash_generated_method = "E64978BD549D6DE30EF457E20B8423B7")
        public boolean superDispatchKeyEvent(KeyEvent event) {
            addTaint(event.getTaint());
            if(super.dispatchKeyEvent(event))            
            {
                boolean varB326B5062B2F0E69046810717534CB09_1130655683 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_927622646 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_927622646;
            } //End block
            if(event.getKeyCode()==KeyEvent.KEYCODE_BACK)            
            {
                final int action = event.getAction();
                if(mActionMode!=null)                
                {
                    if(action==KeyEvent.ACTION_UP)                    
                    {
mActionMode.finish()
                    } //End block
                    boolean varB326B5062B2F0E69046810717534CB09_917093450 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1177260453 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1177260453;
                } //End block
                if(mActionBar!=null&&mActionBar.hasExpandedActionView())                
                {
                    if(action==KeyEvent.ACTION_UP)                    
                    {
mActionBar.collapseActionView()
                    } //End block
                    boolean varB326B5062B2F0E69046810717534CB09_1120891895 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1257464568 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1257464568;
                } //End block
            } //End block
            boolean var68934A3E9455FA72420237EB05902327_1855471882 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_902794984 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_902794984;
            // ---------- Original Method ----------
            //if (super.dispatchKeyEvent(event)) {
                //return true;
            //}
            //if (event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
                //final int action = event.getAction();
                //if (mActionMode != null) {
                    //if (action == KeyEvent.ACTION_UP) {
                        //mActionMode.finish();
                    //}
                    //return true;
                //}
                //if (mActionBar != null && mActionBar.hasExpandedActionView()) {
                    //if (action == KeyEvent.ACTION_UP) {
                        //mActionBar.collapseActionView();
                    //}
                    //return true;
                //}
            //}
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.299 -0400", hash_original_method = "4643DD11552B2B57CD1B68445F0B0205", hash_generated_method = "22D2149F1B6FECA203F72FE29782D94F")
        public boolean superDispatchKeyShortcutEvent(KeyEvent event) {
            addTaint(event.getTaint());
            boolean var45F6457C378081163B5FC74C9DEC97F3_1116880460 = (super.dispatchKeyShortcutEvent(event));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_261727368 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_261727368;
            // ---------- Original Method ----------
            //return super.dispatchKeyShortcutEvent(event);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.302 -0400", hash_original_method = "A193E1C7C6B0ABAADAFD4962B5D0F660", hash_generated_method = "18CAF64663D21507495214E32E24D2DF")
        public boolean superDispatchTouchEvent(MotionEvent event) {
            addTaint(event.getTaint());
            boolean var041E6F53DFDAFFD9826FB441AB720FF1_888260161 = (super.dispatchTouchEvent(event));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1984479035 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1984479035;
            // ---------- Original Method ----------
            //return super.dispatchTouchEvent(event);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.303 -0400", hash_original_method = "561E742EDB393F8B791278FD0E356EE9", hash_generated_method = "02182BD6397A3AB64B1C11EE537CED36")
        public boolean superDispatchTrackballEvent(MotionEvent event) {
            addTaint(event.getTaint());
            boolean varBB41FA8540C179CC2F1F874F79E6CC5C_892102564 = (super.dispatchTrackballEvent(event));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_710240282 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_710240282;
            // ---------- Original Method ----------
            //return super.dispatchTrackballEvent(event);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.304 -0400", hash_original_method = "6C1F905B902495B460AE989EB8489EF4", hash_generated_method = "BFAEC3E0A09FBB4AAB30A912B1CF3E82")
        public boolean superDispatchGenericMotionEvent(MotionEvent event) {
            addTaint(event.getTaint());
            boolean var4D0A83BE3C2C73FAF1ACE52850FFA945_1158316303 = (super.dispatchGenericMotionEvent(event));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1132458627 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1132458627;
            // ---------- Original Method ----------
            //return super.dispatchGenericMotionEvent(event);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.305 -0400", hash_original_method = "50D331DEC294A6E7AB262A25ECCE40C1", hash_generated_method = "FAAC59E781E6EC882CD1D6D9DDF2A6B7")
        @Override
        public boolean onTouchEvent(MotionEvent event) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(event.getTaint());
            boolean var53B200502AAE63B96F2B0CB44FA0082B_1009827389 = (onInterceptTouchEvent(event));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1032081037 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1032081037;
            // ---------- Original Method ----------
            //return onInterceptTouchEvent(event);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.319 -0400", hash_original_method = "B9DEB471C4DF403CCB350C90492E9DF5", hash_generated_method = "5000490EE202D18313C5747692E78F10")
        private boolean isOutOfBounds(int x, int y) {
            addTaint(y);
            addTaint(x);
            boolean var25F4F4CF3BB76096B83410ABA87666C3_1321832414 = (x<-5||y<-5||x>(getWidth()+5)||y>(getHeight()+5));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_298369913 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_298369913;
            // ---------- Original Method ----------
            //return x < -5 || y < -5 || x > (getWidth() + 5)
                    //|| y > (getHeight() + 5);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.336 -0400", hash_original_method = "6B7B5F819D328CF87352E2A0E7EF3B4A", hash_generated_method = "0BD5B82C3359E9A1DF91B8DCB1BD5433")
        @Override
        public boolean onInterceptTouchEvent(MotionEvent event) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(event.getTaint());
            int action = event.getAction();
            if(mFeatureId>=0)            
            {
                if(action==MotionEvent.ACTION_DOWN)                
                {
                    int x = (int)event.getX();
                    int y = (int)event.getY();
                    if(isOutOfBounds(x, y))                    
                    {
closePanel(mFeatureId)                        boolean varB326B5062B2F0E69046810717534CB09_1145839266 = (true);
                                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1426487316 = getTaintBoolean();
                        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1426487316;
                    } //End block
                } //End block
            } //End block
            if(!SWEEP_OPEN_MENU)            
            {
                boolean var68934A3E9455FA72420237EB05902327_1457648945 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_924520218 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_924520218;
            } //End block
            if(mFeatureId>=0)            
            {
                if(action==MotionEvent.ACTION_DOWN)                
                {
mWatchingForMenu=truemDownY=(int) event.getY()                    boolean var68934A3E9455FA72420237EB05902327_1003475651 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_894390205 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_894390205;
                } //End block
                if(!mWatchingForMenu)                
                {
                    boolean var68934A3E9455FA72420237EB05902327_1476536054 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2068012700 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_2068012700;
                } //End block
                int y = (int)event.getY();
                if(action==MotionEvent.ACTION_MOVE)                
                {
                    if(y>(mDownY+30))                    
                    {
closePanel(mFeatureId)mWatchingForMenu=false                        boolean varB326B5062B2F0E69046810717534CB09_2069302302 = (true);
                                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1400591153 = getTaintBoolean();
                        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1400591153;
                    } //End block
                } //End block
                else
                if(action==MotionEvent.ACTION_UP)                
                {
mWatchingForMenu=false
                } //End block
                boolean var68934A3E9455FA72420237EB05902327_1436741335 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_962934157 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_962934157;
            } //End block
            if(action==MotionEvent.ACTION_DOWN)            
            {
                int y = (int)event.getY();
                if(y>=(getHeight()-5)&&!hasChildren())                
                {
mWatchingForMenu=true
                } //End block
                boolean var68934A3E9455FA72420237EB05902327_388376827 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1650957362 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1650957362;
            } //End block
            if(!mWatchingForMenu)            
            {
                boolean var68934A3E9455FA72420237EB05902327_1236837887 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2035379554 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_2035379554;
            } //End block
            int y = (int)event.getY();
            if(action==MotionEvent.ACTION_MOVE)            
            {
                if(y<(getHeight()-30))                
                {
openPanel(FEATURE_OPTIONS_PANEL, new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_MENU))mWatchingForMenu=false                    boolean varB326B5062B2F0E69046810717534CB09_1499555703 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1257357398 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1257357398;
                } //End block
            } //End block
            else
            if(action==MotionEvent.ACTION_UP)            
            {
mWatchingForMenu=false
            } //End block
            boolean var68934A3E9455FA72420237EB05902327_1158103069 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_40214683 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_40214683;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.353 -0400", hash_original_method = "74CBFF91822CE8BE57A0378B7887CF0E", hash_generated_method = "136D56E3EF8A17AC20DDABD6B6248DBC")
        @Override
        public void sendAccessibilityEvent(int eventType) {
            addTaint(eventType);
            if(!AccessibilityManager.getInstance(mContext).isEnabled())            
            {
                return;
            } //End block
            if((mFeatureId==FEATURE_OPTIONS_PANEL||mFeatureId==FEATURE_CONTEXT_MENU||mFeatureId==FEATURE_PROGRESS||mFeatureId==FEATURE_INDETERMINATE_PROGRESS)&&getChildCount()==1)            
            {
getChildAt(0).sendAccessibilityEvent(eventType)
            } //End block
            else
            {
super.sendAccessibilityEvent(eventType)
            } //End block
            // ---------- Original Method ----------
            //if (!AccessibilityManager.getInstance(mContext).isEnabled()) {
                //return;
            //}
            //if ((mFeatureId == FEATURE_OPTIONS_PANEL ||
                    //mFeatureId == FEATURE_CONTEXT_MENU ||
                    //mFeatureId == FEATURE_PROGRESS ||
                    //mFeatureId == FEATURE_INDETERMINATE_PROGRESS)
                    //&& getChildCount() == 1) {
                //getChildAt(0).sendAccessibilityEvent(eventType);
            //} else {
                //super.sendAccessibilityEvent(eventType);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.356 -0400", hash_original_method = "489722EF96E0C5D7118E72EBE8E36F46", hash_generated_method = "0C87EBE448D8F2147C391660A2D06842")
        @Override
        public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
            addTaint(event.getTaint());
            final Callback cb = getCallback();
            if(cb!=null&&!isDestroyed())            
            {
                if(cb.dispatchPopulateAccessibilityEvent(event))                
                {
                    boolean varB326B5062B2F0E69046810717534CB09_1110453159 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_340420785 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_340420785;
                } //End block
            } //End block
            boolean var3EC953B7A3B572DFB915BE2774298435_1328606553 = (super.dispatchPopulateAccessibilityEvent(event));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_900617707 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_900617707;
            // ---------- Original Method ----------
            //final Callback cb = getCallback();
            //if (cb != null && !isDestroyed()) {
                //if (cb.dispatchPopulateAccessibilityEvent(event)) {
                    //return true;
                //}
            //}
            //return super.dispatchPopulateAccessibilityEvent(event);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.360 -0400", hash_original_method = "A95DFD974E20A53AE7E12439E9B8FEF2", hash_generated_method = "5FE1542B7D8873793B0C65865AAAF5A4")
        @Override
        protected boolean setFrame(int l, int t, int r, int b) {
            addTaint(b);
            addTaint(r);
            addTaint(t);
            addTaint(l);
            boolean changed = super.setFrame(l, t, r, b);
            if(changed)            
            {
                final Rect drawingBounds = mDrawingBounds;
getDrawingRect(drawingBounds)                Drawable fg = getForeground();
                if(fg!=null)                
                {
                    final Rect frameOffsets = mFrameOffsets;
drawingBounds.left+=frameOffsets.leftdrawingBounds.top+=frameOffsets.topdrawingBounds.right-=frameOffsets.rightdrawingBounds.bottom-=frameOffsets.bottomfg.setBounds(drawingBounds)                    final Rect framePadding = mFramePadding;
drawingBounds.left+=framePadding.left-frameOffsets.leftdrawingBounds.top+=framePadding.top-frameOffsets.topdrawingBounds.right-=framePadding.right-frameOffsets.rightdrawingBounds.bottom-=framePadding.bottom-frameOffsets.bottom
                } //End block
                Drawable bg = getBackground();
                if(bg!=null)                
                {
bg.setBounds(drawingBounds)
                } //End block
                if(SWEEP_OPEN_MENU)                
                {
                    if(mMenuBackground==null&&mFeatureId<0&&getAttributes().height==WindowManager.LayoutParams.MATCH_PARENT)                    
                    {
mMenuBackground=getContext().getResources().getDrawable(com.android.internal.R.drawable.menu_background)
                    } //End block
                    if(mMenuBackground!=null)                    
                    {
mMenuBackground.setBounds(drawingBounds.left, drawingBounds.bottom-6, drawingBounds.right, drawingBounds.bottom+20)
                    } //End block
                } //End block
            } //End block
            boolean var8977DFAC2F8E04CB96E66882235F5ABA_469104431 = (changed);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1589589921 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1589589921;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.364 -0400", hash_original_method = "9376D64C16025DDB50791EE4065F0014", hash_generated_method = "2714A920C6619DF4E8150907A1399FB2")
        @Override
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(heightMeasureSpec);
            addTaint(widthMeasureSpec);
            final DisplayMetrics metrics = getContext().getResources().getDisplayMetrics();
            final boolean isPortrait = metrics.widthPixels < metrics.heightPixels;
            final int widthMode = getMode(widthMeasureSpec);
super.onMeasure(widthMeasureSpec, heightMeasureSpec)            int width = getMeasuredWidth();
            boolean measure = false;
widthMeasureSpec=MeasureSpec.makeMeasureSpec(width, EXACTLY)            final TypedValue tv = isPortrait ? mMinWidthMinor : mMinWidthMajor;
            if(widthMode==AT_MOST&&tv.type!=TypedValue.TYPE_NULL)            
            {
                int min;
                if(tv.type==TypedValue.TYPE_DIMENSION)                
                {
min=(int) tv.getDimension(metrics)
                } //End block
                else
                if(tv.type==TypedValue.TYPE_FRACTION)                
                {
min=(int) tv.getFraction(metrics.widthPixels, metrics.widthPixels)
                } //End block
                else
                {
min=0
                } //End block
                if(width<min)                
                {
widthMeasureSpec=MeasureSpec.makeMeasureSpec(min, EXACTLY)measure=true
                } //End block
            } //End block
            if(measure)            
            {
super.onMeasure(widthMeasureSpec, heightMeasureSpec)
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.368 -0400", hash_original_method = "5FFCD4674BE63FA0703F4BEC9782C96F", hash_generated_method = "26CD14B9DB9BCF2209EBEA06D44DA47B")
        @Override
        public void draw(Canvas canvas) {
            addTaint(canvas.getTaint());
super.draw(canvas)            if(mMenuBackground!=null)            
            {
mMenuBackground.draw(canvas)
            } //End block
            // ---------- Original Method ----------
            //super.draw(canvas);
            //if (mMenuBackground != null) {
                //mMenuBackground.draw(canvas);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.371 -0400", hash_original_method = "5DABF6090A3067C1CE5652E80BE34E19", hash_generated_method = "485321CDC1CAF302DA5EA18D8A0DADFB")
        @Override
        public boolean showContextMenuForChild(View originalView) {
            addTaint(originalView.getTaint());
            if(mContextMenu==null)            
            {
mContextMenu=new ContextMenuBuilder(getContext())mContextMenu.setCallback(mContextMenuCallback)
            } //End block
            else
            {
mContextMenu.clearAll()
            } //End block
            final MenuDialogHelper helper = mContextMenu.show(originalView,
                    originalView.getWindowToken());
            if(helper!=null)            
            {
helper.setPresenterCallback(mContextMenuCallback)
            } //End block
mContextMenuHelper=helper            boolean var693CE4E397DB0343ABF4A4C9794F8388_1764001718 = (helper!=null);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1998240356 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1998240356;
            // ---------- Original Method ----------
            //if (mContextMenu == null) {
                //mContextMenu = new ContextMenuBuilder(getContext());
                //mContextMenu.setCallback(mContextMenuCallback);
            //} else {
                //mContextMenu.clearAll();
            //}
            //final MenuDialogHelper helper = mContextMenu.show(originalView,
                    //originalView.getWindowToken());
            //if (helper != null) {
                //helper.setPresenterCallback(mContextMenuCallback);
            //}
            //mContextMenuHelper = helper;
            //return helper != null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.373 -0400", hash_original_method = "78A5985EBD07B57A0CFCD4C0CF2C6DAE", hash_generated_method = "F4996495242FF8CFC36271EC562C9A5D")
        @Override
        public ActionMode startActionModeForChild(View originalView,
                ActionMode.Callback callback) {
            addTaint(callback.getTaint());
            addTaint(originalView.getTaint());
ActionMode varE38C2498AC6942FFFF90088761876091_1895372918 = startActionMode(callback)            varE38C2498AC6942FFFF90088761876091_1895372918.addTaint(taint);
            return varE38C2498AC6942FFFF90088761876091_1895372918;
            // ---------- Original Method ----------
            //return startActionMode(callback);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.382 -0400", hash_original_method = "98FD12FD40CE2A65943A60F8E263858C", hash_generated_method = "94B7C22EF5D8122A2FF087088CD48FAC")
        @Override
        public ActionMode startActionMode(ActionMode.Callback callback) {
            addTaint(callback.getTaint());
            if(mActionMode!=null)            
            {
mActionMode.finish()
            } //End block
            final ActionMode.Callback wrappedCallback = new ActionModeCallbackWrapper(callback);
            ActionMode mode = null;
            if(getCallback()!=null&&!isDestroyed())            
            {
                try 
                {
mode=getCallback().onWindowStartingActionMode(wrappedCallback)
                } //End block
                catch (AbstractMethodError ame)
                {
                } //End block
            } //End block
            if(mode!=null)            
            {
mActionMode=mode
            } //End block
            else
            {
                if(mActionModeView==null)                
                {
                    if(isFloating())                    
                    {
mActionModeView=new ActionBarContextView(mContext)mActionModePopup=new PopupWindow(mContext, null, com.android.internal.R.attr.actionModePopupWindowStyle)mActionModePopup.setLayoutInScreenEnabled(true)mActionModePopup.setLayoutInsetDecor(true)mActionModePopup.setWindowLayoutType(WindowManager.LayoutParams.TYPE_APPLICATION)mActionModePopup.setContentView(mActionModeView)mActionModePopup.setWidth(MATCH_PARENT)                        TypedValue heightValue = new TypedValue();
mContext.getTheme().resolveAttribute(com.android.internal.R.attr.actionBarSize, heightValue, true)                        final int height = TypedValue.complexToDimensionPixelSize(heightValue.data,
                                mContext.getResources().getDisplayMetrics());
mActionModeView.setContentHeight(height)mActionModePopup.setHeight(WRAP_CONTENT)mShowActionModePopup=new Runnable()                        {
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.378 -0400", hash_original_method = "188370E6E04809F6CAB39788CACACBF0", hash_generated_method = "1122537C9D8D4C6999922D4757D49C84")
            public void run() {
mActionModePopup.showAtLocation(mActionModeView.getApplicationWindowToken(), Gravity.TOP|Gravity.FILL_HORIZONTAL, 0, 0)
                // ---------- Original Method ----------
                //mActionModePopup.showAtLocation(
                                        //mActionModeView.getApplicationWindowToken(),
                                        //Gravity.TOP | Gravity.FILL_HORIZONTAL, 0, 0);
            }
                        }
                    } //End block
                    else
                    {
                        ViewStub stub = (ViewStub) findViewById(
                                com.android.internal.R.id.action_mode_bar_stub);
                        if(stub!=null)                        
                        {
mActionModeView=(ActionBarContextView) stub.inflate()
                        } //End block
                    } //End block
                } //End block
                if(mActionModeView!=null)                
                {
mActionModeView.killMode()mode=new StandaloneActionMode(getContext(), mActionModeView, wrappedCallback, mActionModePopup==null)                    if(callback.onCreateActionMode(mode, mode.getMenu()))                    
                    {
mode.invalidate()mActionModeView.initForMode(mode)mActionModeView.setVisibility(View.VISIBLE)mActionMode=mode                        if(mActionModePopup!=null)                        
                        {
post(mShowActionModePopup)
                        } //End block
mActionModeView.sendAccessibilityEvent(AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED)
                    } //End block
                    else
                    {
mActionMode=null
                    } //End block
                } //End block
            } //End block
            if(mActionMode!=null&&getCallback()!=null&&!isDestroyed())            
            {
                try 
                {
getCallback().onActionModeStarted(mActionMode)
                } //End block
                catch (AbstractMethodError ame)
                {
                } //End block
            } //End block
ActionMode var08B9D4DC76EE4852D5A863923B227BE6_1715790496 = mActionMode            var08B9D4DC76EE4852D5A863923B227BE6_1715790496.addTaint(taint);
            return var08B9D4DC76EE4852D5A863923B227BE6_1715790496;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.384 -0400", hash_original_method = "1CC27DBD9B962B376197C727A3C5B35B", hash_generated_method = "6C9A97E304F494531968DF1F54705FA4")
        public void startChanging() {
mChanging=true
            // ---------- Original Method ----------
            //mChanging = true;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.385 -0400", hash_original_method = "301BB4842AE1A67ACA0B1300672E0524", hash_generated_method = "AD917B3184037873FA03AA7A9724E475")
        public void finishChanging() {
mChanging=falsedrawableChanged()
            // ---------- Original Method ----------
            //mChanging = false;
            //drawableChanged();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.387 -0400", hash_original_method = "5E87C2056675B3632E8618C70009CCAD", hash_generated_method = "26562B2F2F61D7DBAD5B24F0FB6718FA")
        public void setWindowBackground(Drawable drawable) {
            addTaint(drawable.getTaint());
            if(getBackground()!=drawable)            
            {
setBackgroundDrawable(drawable)                if(drawable!=null)                
                {
drawable.getPadding(mBackgroundPadding)
                } //End block
                else
                {
mBackgroundPadding.setEmpty()
                } //End block
drawableChanged()
            } //End block
            // ---------- Original Method ----------
            //if (getBackground() != drawable) {
                //setBackgroundDrawable(drawable);
                //if (drawable != null) {
                    //drawable.getPadding(mBackgroundPadding);
                //} else {
                    //mBackgroundPadding.setEmpty();
                //}
                //drawableChanged();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.389 -0400", hash_original_method = "8B6EFDEFD9899948A537E22704DC8724", hash_generated_method = "5D3E54B01E98527433A9E30AFE0FA1AF")
        @Override
        public void setBackgroundDrawable(Drawable d) {
            addTaint(d.getTaint());
super.setBackgroundDrawable(d)            if(getWindowToken()!=null)            
            {
updateWindowResizeState()
            } //End block
            // ---------- Original Method ----------
            //super.setBackgroundDrawable(d);
            //if (getWindowToken() != null) {
                //updateWindowResizeState();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.390 -0400", hash_original_method = "CAB45728C6C3DE917AFED5A264E3294D", hash_generated_method = "206D9115928AD53770116552440F6799")
        public void setWindowFrame(Drawable drawable) {
            addTaint(drawable.getTaint());
            if(getForeground()!=drawable)            
            {
setForeground(drawable)                if(drawable!=null)                
                {
drawable.getPadding(mFramePadding)
                } //End block
                else
                {
mFramePadding.setEmpty()
                } //End block
drawableChanged()
            } //End block
            // ---------- Original Method ----------
            //if (getForeground() != drawable) {
                //setForeground(drawable);
                //if (drawable != null) {
                    //drawable.getPadding(mFramePadding);
                //} else {
                    //mFramePadding.setEmpty();
                //}
                //drawableChanged();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.402 -0400", hash_original_method = "D0CFAEC33A74A2290AB574DC0B0C5A35", hash_generated_method = "0DAA0B00DAE19406ADC523EB3A96E265")
        @Override
        protected boolean fitSystemWindows(Rect insets) {
            addTaint(insets.getTaint());
mFrameOffsets.set(insets)            if(getForeground()!=null)            
            {
drawableChanged()
            } //End block
            boolean var42C508A8B02200352A77661187FD4AEA_1811715316 = (super.fitSystemWindows(insets));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1019127236 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1019127236;
            // ---------- Original Method ----------
            //mFrameOffsets.set(insets);
            //if (getForeground() != null) {
                //drawableChanged();
            //}
            //return super.fitSystemWindows(insets);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.413 -0400", hash_original_method = "8268E6569E3A3D77B24FCC1614A1394C", hash_generated_method = "D0694007E9860D272756DD1DB2970B6B")
        private void drawableChanged() {
            if(mChanging)            
            {
                return;
            } //End block
setPadding(mFramePadding.left+mBackgroundPadding.left, mFramePadding.top+mBackgroundPadding.top, mFramePadding.right+mBackgroundPadding.right, mFramePadding.bottom+mBackgroundPadding.bottom)requestLayout()invalidate()            int opacity = PixelFormat.OPAQUE;
            Drawable bg = getBackground();
            Drawable fg = getForeground();
            if(bg!=null)            
            {
                if(fg==null)                
                {
opacity=bg.getOpacity()
                } //End block
                else
                if(mFramePadding.left<=0&&mFramePadding.top<=0&&mFramePadding.right<=0&&mFramePadding.bottom<=0)                
                {
                    int fop = fg.getOpacity();
                    int bop = bg.getOpacity();
                    if(false){ }                    if(fop==PixelFormat.OPAQUE||bop==PixelFormat.OPAQUE)                    
                    {
opacity=PixelFormat.OPAQUE
                    } //End block
                    else
                    if(fop==PixelFormat.UNKNOWN)                    
                    {
opacity=bop
                    } //End block
                    else
                    if(bop==PixelFormat.UNKNOWN)                    
                    {
opacity=fop
                    } //End block
                    else
                    {
opacity=Drawable.resolveOpacity(fop, bop)
                    } //End block
                } //End block
                else
                {
                    if(false){ }opacity=PixelFormat.TRANSLUCENT
                } //End block
            } //End block
            if(false){ }            if(false){ }mDefaultOpacity=opacity            if(mFeatureId<0)            
            {
setDefaultWindowFormat(opacity)
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.416 -0400", hash_original_method = "E386CE98CC7C5210AEA13C89F9A9D67F", hash_generated_method = "D31D2E15E14D4789ADF7329C70BACDE3")
        @Override
        public void onWindowFocusChanged(boolean hasWindowFocus) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(hasWindowFocus);
super.onWindowFocusChanged(hasWindowFocus)            if(!hasWindowFocus&&mPanelChordingKey!=0)            
            {
closePanel(FEATURE_OPTIONS_PANEL)
            } //End block
            final Callback cb = getCallback();
            if(cb!=null&&!isDestroyed()&&mFeatureId<0)            
            {
cb.onWindowFocusChanged(hasWindowFocus)
            } //End block
            // ---------- Original Method ----------
            //super.onWindowFocusChanged(hasWindowFocus);
            //if (!hasWindowFocus && mPanelChordingKey != 0) {
                //closePanel(FEATURE_OPTIONS_PANEL);
            //}
            //final Callback cb = getCallback();
            //if (cb != null && !isDestroyed() && mFeatureId < 0) {
                //cb.onWindowFocusChanged(hasWindowFocus);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.417 -0400", hash_original_method = "C808741D71B7DD96CEE7BAE7AE1E777E", hash_generated_method = "A1934ADEB1144D3DD2FA09339D3A1694")
         void updateWindowResizeState() {
            Drawable bg = getBackground();
hackTurnOffWindowResizeAnim(bg==null||bg.getOpacity()!=PixelFormat.OPAQUE)
            // ---------- Original Method ----------
            //Drawable bg = getBackground();
            //hackTurnOffWindowResizeAnim(bg == null || bg.getOpacity()
                    //!= PixelFormat.OPAQUE);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.419 -0400", hash_original_method = "F0E054CF2FD7715692FB03B818095B49", hash_generated_method = "CC2973B5D3190659BC47B7FB50EB60A2")
        @Override
        protected void onAttachedToWindow() {
            //DSFIXME:  CODE0009: Possible callback target function detected
super.onAttachedToWindow()updateWindowResizeState()            final Callback cb = getCallback();
            if(cb!=null&&!isDestroyed()&&mFeatureId<0)            
            {
cb.onAttachedToWindow()
            } //End block
            if(mFeatureId==-1)            
            {
openPanelsAfterRestore()
            } //End block
            // ---------- Original Method ----------
            //super.onAttachedToWindow();
            //updateWindowResizeState();
            //final Callback cb = getCallback();
            //if (cb != null && !isDestroyed() && mFeatureId < 0) {
                //cb.onAttachedToWindow();
            //}
            //if (mFeatureId == -1) {
                //openPanelsAfterRestore();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.423 -0400", hash_original_method = "F334EC75E531C8E94B5106CE57C0BF37", hash_generated_method = "307C928976780896B6A2B25C5F75125B")
        @Override
        protected void onDetachedFromWindow() {
            //DSFIXME:  CODE0009: Possible callback target function detected
super.onDetachedFromWindow()            final Callback cb = getCallback();
            if(cb!=null&&mFeatureId<0)            
            {
cb.onDetachedFromWindow()
            } //End block
            if(mActionBar!=null)            
            {
mActionBar.dismissPopupMenus()
            } //End block
            if(mActionModePopup!=null)            
            {
removeCallbacks(mShowActionModePopup)                if(mActionModePopup.isShowing())                
                {
mActionModePopup.dismiss()
                } //End block
mActionModePopup=null
            } //End block
            PanelFeatureState st = getPanelState(FEATURE_OPTIONS_PANEL, false);
            if(st!=null&&st.menu!=null&&mFeatureId<0)            
            {
st.menu.close()
            } //End block
            // ---------- Original Method ----------
            //super.onDetachedFromWindow();
            //final Callback cb = getCallback();
            //if (cb != null && mFeatureId < 0) {
                //cb.onDetachedFromWindow();
            //}
            //if (mActionBar != null) {
                //mActionBar.dismissPopupMenus();
            //}
            //if (mActionModePopup != null) {
                //removeCallbacks(mShowActionModePopup);
                //if (mActionModePopup.isShowing()) {
                    //mActionModePopup.dismiss();
                //}
                //mActionModePopup = null;
            //}
            //PanelFeatureState st = getPanelState(FEATURE_OPTIONS_PANEL, false);
            //if (st != null && st.menu != null && mFeatureId < 0) {
                //st.menu.close();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.424 -0400", hash_original_method = "A2FC993F3F5DAC3D5362C2A891973C1F", hash_generated_method = "28FDE49830064ECF9BD2F487C7D973A6")
        @Override
        public void onCloseSystemDialogs(String reason) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(reason.getTaint());
            if(mFeatureId>=0)            
            {
closeAllPanels()
            } //End block
            // ---------- Original Method ----------
            //if (mFeatureId >= 0) {
                //closeAllPanels();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.425 -0400", hash_original_method = "7D4199C4B838317B0F8F1610F2C0EE89", hash_generated_method = "71DF3A0B8DE27F87443916FC6821B071")
        public android.view.SurfaceHolder.Callback2 willYouTakeTheSurface() {
android.view.SurfaceHolder.Callback2 varDCE4A77B1C60F51F5585319D79D3CE58_1963180654 = mFeatureId<0?mTakeSurfaceCallback:mTakeSurfaceCallback            varDCE4A77B1C60F51F5585319D79D3CE58_1963180654.addTaint(taint);
            return varDCE4A77B1C60F51F5585319D79D3CE58_1963180654;
            // ---------- Original Method ----------
            //return mFeatureId < 0 ? mTakeSurfaceCallback : null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.428 -0400", hash_original_method = "4B9CF805E4383DBFF8B812A0028D68EE", hash_generated_method = "22C5B0A0489434E43F663721285B62CE")
        public InputQueue.Callback willYouTakeTheInputQueue() {
InputQueue.Callback var3F9B0005738B7F3F9E36130ABAC63066_1950490478 = mFeatureId<0?mTakeInputQueueCallback:mTakeInputQueueCallback            var3F9B0005738B7F3F9E36130ABAC63066_1950490478.addTaint(taint);
            return var3F9B0005738B7F3F9E36130ABAC63066_1950490478;
            // ---------- Original Method ----------
            //return mFeatureId < 0 ? mTakeInputQueueCallback : null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.429 -0400", hash_original_method = "D6D2EC50157BCD1890197F0921E93037", hash_generated_method = "5D95217D8D0D207B63C7B9E923FD0469")
        public void setSurfaceType(int type) {
            addTaint(type);
PhoneWindow.this.setType(type)
            // ---------- Original Method ----------
            //PhoneWindow.this.setType(type);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.430 -0400", hash_original_method = "596567D43F25B6C00CC2484BC059A8DD", hash_generated_method = "82E8E73E27EFC9D59A241B0E015A5EF3")
        public void setSurfaceFormat(int format) {
            addTaint(format);
PhoneWindow.this.setFormat(format)
            // ---------- Original Method ----------
            //PhoneWindow.this.setFormat(format);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.437 -0400", hash_original_method = "DC2481DF7332B2572093B0B1CFCA9FBA", hash_generated_method = "4A5F364D51E97F3D8C505AB3088A1D95")
        public void setSurfaceKeepScreenOn(boolean keepOn) {
            addTaint(keepOn);
            if(keepOn)            
PhoneWindow.this.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
            else
PhoneWindow.this.clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
            // ---------- Original Method ----------
            //if (keepOn) PhoneWindow.this.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
            //else PhoneWindow.this.clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        }

        
        private class ActionModeCallbackWrapper implements ActionMode.Callback {
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.438 -0400", hash_original_field = "B7CE96B7646AE9C0D4A917FBF1A25931", hash_generated_field = "B18751E38212E9D6FB1D8651B6B8B271")

            private ActionMode.Callback mWrapped;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.443 -0400", hash_original_method = "B392F17C878846A4410FC6D5A124BD9C", hash_generated_method = "5DEC3C30B0AE31598C4413C086D3017A")
            public  ActionModeCallbackWrapper(ActionMode.Callback wrapped) {
                addTaint(wrapped.getTaint());
mWrapped=wrapped
                // ---------- Original Method ----------
                //mWrapped = wrapped;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.446 -0400", hash_original_method = "9456C99F24047D005B3DC05AA584FB3A", hash_generated_method = "1C599C334CFD20CC91F8F889A58E467E")
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                //DSFIXME:  CODE0009: Possible callback target function detected
                addTaint(menu.getTaint());
                addTaint(mode.getTaint());
                boolean varD97FD2DDB41A871C9ECFB20DB60BFC35_506048128 = (mWrapped.onCreateActionMode(mode, menu));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_283906808 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_283906808;
                // ---------- Original Method ----------
                //return mWrapped.onCreateActionMode(mode, menu);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.448 -0400", hash_original_method = "605F5D923BF72CFC73E9AAB7E02967CC", hash_generated_method = "B81EB6135AEDBF724683CBC42913CABC")
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                //DSFIXME:  CODE0009: Possible callback target function detected
                addTaint(menu.getTaint());
                addTaint(mode.getTaint());
                boolean var55A4B186F0A789314BD40982435B2F2D_1026807841 = (mWrapped.onPrepareActionMode(mode, menu));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_269275309 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_269275309;
                // ---------- Original Method ----------
                //return mWrapped.onPrepareActionMode(mode, menu);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.449 -0400", hash_original_method = "033C72B6C9A09D3E8E7805BD6C059806", hash_generated_method = "0B35502D38D47B4AA43C3DA2B0BDB691")
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                //DSFIXME:  CODE0009: Possible callback target function detected
                addTaint(item.getTaint());
                addTaint(mode.getTaint());
                boolean varA67BC1BFCCEC726462A8C31B6FE3D86A_1597280277 = (mWrapped.onActionItemClicked(mode, item));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_975169491 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_975169491;
                // ---------- Original Method ----------
                //return mWrapped.onActionItemClicked(mode, item);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.451 -0400", hash_original_method = "7E706FA5F4C713AF1BA39DCB4D242BAF", hash_generated_method = "EA7C5D1C86703947BFF7ED2155E0A032")
            public void onDestroyActionMode(ActionMode mode) {
                //DSFIXME:  CODE0009: Possible callback target function detected
                addTaint(mode.getTaint());
mWrapped.onDestroyActionMode(mode)                if(mActionModePopup!=null)                
                {
removeCallbacks(mShowActionModePopup)mActionModePopup.dismiss()
                } //End block
                else
                if(mActionModeView!=null)                
                {
mActionModeView.setVisibility(GONE)
                } //End block
                if(mActionModeView!=null)                
                {
mActionModeView.removeAllViews()
                } //End block
                if(getCallback()!=null&&!isDestroyed())                
                {
                    try 
                    {
getCallback().onActionModeFinished(mActionMode)
                    } //End block
                    catch (AbstractMethodError ame)
                    {
                    } //End block
                } //End block
mActionMode=null
                // ---------- Original Method ----------
                //mWrapped.onDestroyActionMode(mode);
                //if (mActionModePopup != null) {
                    //removeCallbacks(mShowActionModePopup);
                    //mActionModePopup.dismiss();
                //} else if (mActionModeView != null) {
                    //mActionModeView.setVisibility(GONE);
                //}
                //if (mActionModeView != null) {
                    //mActionModeView.removeAllViews();
                //}
                //if (getCallback() != null && !isDestroyed()) {
                    //try {
                        //getCallback().onActionModeFinished(mActionMode);
                    //} catch (AbstractMethodError ame) {
                    //}
                //}
                //mActionMode = null;
            }

            
        }


        
    }


    
    private static final class DrawableFeatureState {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.455 -0400", hash_original_field = "0EB465EA5E6DAFCB9D24D8EDF9A01664", hash_generated_field = "54DCEE629FD65EE5862FAA3F84445BB0")

        int featureId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.455 -0400", hash_original_field = "9C5DC71F9C3AB4FEBAA17E7B42553A5B", hash_generated_field = "563C1841FDB2E2FEB51EE56264EB9DBE")

        int resid;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.455 -0400", hash_original_field = "9305B73D359BD06734FEE0B3638079E1", hash_generated_field = "F30A3503738FDB118E2076C7F22FF172")

        Uri uri;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.456 -0400", hash_original_field = "F5DDAF0CA7929578B408C909429F68F2", hash_generated_field = "88E2CFFB3DC97DDE79065245715C4B14")

        Drawable local;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.456 -0400", hash_original_field = "1B7D5726533AB525A8760351E9B5E415", hash_generated_field = "D46CD69C3377921C78FD9C7A8E117ADE")

        Drawable child;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.466 -0400", hash_original_field = "4ED9407630EB1000C0F6B63842DEFA7D", hash_generated_field = "3BE4BC4DE5FCFB3D17A5284464C44E9B")

        Drawable def;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.466 -0400", hash_original_field = "B5FDDF1EF601E74DB01C1425561A38CB", hash_generated_field = "725B326B69886953E1A3C273DA88F1F5")

        Drawable cur;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.466 -0400", hash_original_field = "C85021DB7A05A7297888201306891326", hash_generated_field = "160E4BE7D518FA72017CB815DE25A26E")

        int alpha = 255;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.466 -0400", hash_original_field = "AD11F84666FAE39EB47AF0FC95C4C53B", hash_generated_field = "7AEB538D27C635FEBD4199EF313EBC33")

        int curAlpha = 255;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.467 -0400", hash_original_method = "580B203A0278E73C54AF0657789C66B1", hash_generated_method = "E3E28F376AEA493885EC32C985FF0D17")
          DrawableFeatureState(int _featureId) {
            addTaint(_featureId);
featureId=_featureId
            // ---------- Original Method ----------
            //featureId = _featureId;
        }

        
    }


    
    private static final class PanelFeatureState {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.468 -0400", hash_original_field = "0EB465EA5E6DAFCB9D24D8EDF9A01664", hash_generated_field = "54DCEE629FD65EE5862FAA3F84445BB0")

        int featureId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.468 -0400", hash_original_field = "D229BBF31EAEEBC7C88897732D8B932D", hash_generated_field = "863E11A4573162726505A8632187E41C")

        int background;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.468 -0400", hash_original_field = "49FCF961C5EFF2EC6886659CD58C43F6", hash_generated_field = "33C7E8CFACB2786FD875EB3C15DC7E6E")

        int fullBackground;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.468 -0400", hash_original_field = "67F2A835697E7C9C2C5146C76ECA6038", hash_generated_field = "E7FDA06D45817A851F4CCBCEDBBF1171")

        int gravity;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.469 -0400", hash_original_field = "9DD4E461268C8034F5C8564E155C67A6", hash_generated_field = "3ECDEC351FCE13CBA8A59E38409B3C9E")

        int x;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.469 -0400", hash_original_field = "415290769594460E2E485922904F345D", hash_generated_field = "93D19118DABD6AC5BACF335A34537CEB")

        int y;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.469 -0400", hash_original_field = "ACB0DB2D8ABD5816B423ADFAC464D34E", hash_generated_field = "2B808634C0F256930087E4700EAB48ED")

        int windowAnimations;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.469 -0400", hash_original_field = "92ED9E731980EB0D452CE7560BA94443", hash_generated_field = "8723B20D95DD16CE602DF336816D71F0")

        DecorView decorView;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.469 -0400", hash_original_field = "1C779B39CE39BB2F086C3F84B88BE0D1", hash_generated_field = "79955C143EBCD7E70D70A9902D00F323")

        View createdPanelView;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.470 -0400", hash_original_field = "82FB08B949686569240BE3B56F75D568", hash_generated_field = "F274D6371C9A5268E000B0B09F01A776")

        View shownPanelView;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.470 -0400", hash_original_field = "8D6AB84CA2AF9FCCD4E4048694176EBF", hash_generated_field = "00AF121AAF8F4555836A4C1AC6CF7B8B")

        MenuBuilder menu;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.470 -0400", hash_original_field = "9C92031ACBAF71B04B8E80EC76326D14", hash_generated_field = "FB5D35A4C6329D79BE93B99855DC1A41")

        IconMenuPresenter iconMenuPresenter;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.470 -0400", hash_original_field = "E34F1DB96AAB95A81280ADCE1D3B0CFD", hash_generated_field = "C4C4B2BD2D1CAA8FA4183B7A455E185B")

        ListMenuPresenter listMenuPresenter;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.470 -0400", hash_original_field = "9D0EF5B3E3F8D4F2C7FF243133F3C225", hash_generated_field = "AF88E81927E480F4569D43255EAC24BE")

        boolean isCompact;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.470 -0400", hash_original_field = "4789315984FF6F3C34082FDF1E6478C4", hash_generated_field = "B93AE788D1E401246A027DDD2E89918F")

        int listPresenterTheme;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.485 -0400", hash_original_field = "8E326FC0824179F6708448D98B7A1B06", hash_generated_field = "63D08C7242253E1E7053B52339CE3416")

        boolean isPrepared;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.486 -0400", hash_original_field = "AC92646372DCFCDCC1DFA56EA3DD66CE", hash_generated_field = "D5023E8BBCA4626736FA2DFA7E0ADE3F")

        boolean isHandled;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.487 -0400", hash_original_field = "5E7466A3BA0D44490BD6A64287013D0C", hash_generated_field = "92B8B14C3535219BF6BD132B36A9FC28")

        boolean isOpen;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.499 -0400", hash_original_field = "EE1ACF7874D8B577AB716995C9305422", hash_generated_field = "895ABC8713A2DAAFB927EB6F86026183")

        boolean isInExpandedMode;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.524 -0400", hash_original_field = "22CE88C5E63355501541A0C66967D1B7", hash_generated_field = "B85D06A068DF850D0DF221131D1A67CD")

        public boolean qwertyMode;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.525 -0400", hash_original_field = "8080646C28BB2D8FD58D6F8E3B6D45A5", hash_generated_field = "6EC5B81546A238D0FC24B751D40AADA9")

        boolean refreshDecorView;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.525 -0400", hash_original_field = "85A35B8C3E8A9A5E1D1C4572A857EEA2", hash_generated_field = "A8FDE47103523AFC359FD79A0D8462C3")

        boolean refreshMenuContent;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.526 -0400", hash_original_field = "53C57E863CE50AB76AEB171A379CC424", hash_generated_field = "837F7577D21F201A2BFBBF020C9FEBA3")

        boolean wasLastOpen;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.526 -0400", hash_original_field = "369ADD7E3F8EECF751D72E2030B6E73B", hash_generated_field = "34E8CC6114E78BEF6C7BADA540443E3E")

        boolean wasLastExpanded;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.526 -0400", hash_original_field = "37BA61576E41D43A783176EC8B5F90EF", hash_generated_field = "DDDDBD59CFDE5D58EC8B26DD38D5BA53")

        Bundle frozenMenuState;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.526 -0400", hash_original_field = "D3DCC2AB2BB7BB33A05A509E7DABADC1", hash_generated_field = "7BB6BEB74B0ED8CDFABA84484EF12B17")

        Bundle frozenActionViewState;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.527 -0400", hash_original_method = "0C1C900D89FD93C48968E45D22E6DA2A", hash_generated_method = "0A7AAD60F31CCE6F01C887B3B6DC3260")
          PanelFeatureState(int featureId) {
            addTaint(featureId);
this.featureId=featureIdrefreshDecorView=false
            // ---------- Original Method ----------
            //this.featureId = featureId;
            //refreshDecorView = false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.528 -0400", hash_original_method = "1DF5C32A6A8DFBD1C7799FFF6CA1EC6F", hash_generated_method = "D82AB768A4618EF6847883F4F4C30AE3")
        public boolean isInListMode() {
            boolean varBED87BD0FF26054DFE8023F5804714D4_1428663525 = (isInExpandedMode||isCompact);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1881502989 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1881502989;
            // ---------- Original Method ----------
            //return isInExpandedMode || isCompact;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.530 -0400", hash_original_method = "74D407ABFAD016849BFDA78D326655CD", hash_generated_method = "ACFC0783FB63CB58EB2EE70D4AA996BF")
        public boolean hasPanelItems() {
            if(shownPanelView==null)            
            {
            boolean var68934A3E9455FA72420237EB05902327_1684671381 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1547140782 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1547140782;
            }
            if(createdPanelView!=null)            
            {
            boolean varB326B5062B2F0E69046810717534CB09_857539942 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_106050898 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_106050898;
            }
            if(isCompact||isInExpandedMode)            
            {
                boolean var430B038CCBB7EB2FA599302C34500F49_1858723549 = (listMenuPresenter.getAdapter().getCount()>0);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_70589319 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_70589319;
            } //End block
            else
            {
                boolean varB867989C6127C13A552B61C418BB2DEA_228570054 = (((ViewGroup) shownPanelView).getChildCount()>0);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_630563618 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_630563618;
            } //End block
            // ---------- Original Method ----------
            //if (shownPanelView == null) return false;
            //if (createdPanelView != null) return true;
            //if (isCompact || isInExpandedMode) {
                //return listMenuPresenter.getAdapter().getCount() > 0;
            //} else {
                //return ((ViewGroup) shownPanelView).getChildCount() > 0;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.532 -0400", hash_original_method = "4AB8EC9BB631F81871DC78BE39D577A4", hash_generated_method = "75D9EE0251A0F744D0CBE3D3391E2B6E")
        public void clearMenuPresenters() {
            if(menu!=null)            
            {
menu.removeMenuPresenter(iconMenuPresenter)menu.removeMenuPresenter(listMenuPresenter)
            } //End block
iconMenuPresenter=nulllistMenuPresenter=null
            // ---------- Original Method ----------
            //if (menu != null) {
                //menu.removeMenuPresenter(iconMenuPresenter);
                //menu.removeMenuPresenter(listMenuPresenter);
            //}
            //iconMenuPresenter = null;
            //listMenuPresenter = null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.534 -0400", hash_original_method = "A943DC8408B1E6138DDCD990D9784722", hash_generated_method = "0CCBB026C2579A73743DA82C2DD76FEB")
         void setStyle(Context context) {
            addTaint(context.getTaint());
            TypedArray a = context.obtainStyledAttributes(com.android.internal.R.styleable.Theme);
background=a.getResourceId(com.android.internal.R.styleable.Theme_panelBackground, 0)fullBackground=a.getResourceId(com.android.internal.R.styleable.Theme_panelFullBackground, 0)windowAnimations=a.getResourceId(com.android.internal.R.styleable.Theme_windowAnimationStyle, 0)isCompact=a.getBoolean(com.android.internal.R.styleable.Theme_panelMenuIsCompact, false)listPresenterTheme=a.getResourceId(com.android.internal.R.styleable.Theme_panelMenuListTheme, com.android.internal.R.style.Theme_ExpandedMenu)a.recycle()
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.555 -0400", hash_original_method = "08DAEF0E6ED1BEAD66B349898A20F8A6", hash_generated_method = "609DA9DA510524D2206863DCCA1921C9")
         void setMenu(MenuBuilder menu) {
            addTaint(menu.getTaint());
            if(menu==this.menu)            
            return;
            if(this.menu!=null)            
            {
this.menu.removeMenuPresenter(iconMenuPresenter)this.menu.removeMenuPresenter(listMenuPresenter)
            } //End block
this.menu=menu            if(menu!=null)            
            {
                if(iconMenuPresenter!=null)                
menu.addMenuPresenter(iconMenuPresenter)
                if(listMenuPresenter!=null)                
menu.addMenuPresenter(listMenuPresenter)
            } //End block
            // ---------- Original Method ----------
            //if (menu == this.menu) return;
            //if (this.menu != null) {
                //this.menu.removeMenuPresenter(iconMenuPresenter);
                //this.menu.removeMenuPresenter(listMenuPresenter);
            //}
            //this.menu = menu;
            //if (menu != null) {
                //if (iconMenuPresenter != null) menu.addMenuPresenter(iconMenuPresenter);
                //if (listMenuPresenter != null) menu.addMenuPresenter(listMenuPresenter);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.558 -0400", hash_original_method = "54C49764F03536A0BA5BB124316D2293", hash_generated_method = "468BF65DFE45FBE470DDC65516A44F07")
         MenuView getListMenuView(Context context, MenuPresenter.Callback cb) {
            addTaint(cb.getTaint());
            addTaint(context.getTaint());
            if(menu==null)            
            {
MenuView var540C13E9E156B687226421B24F2DF178_1931172683 = null            var540C13E9E156B687226421B24F2DF178_1931172683.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1931172683;
            }
            if(!isCompact)            
            {
getIconMenuView(context, cb)
            } //End block
            if(listMenuPresenter==null)            
            {
listMenuPresenter=new ListMenuPresenter(com.android.internal.R.layout.list_menu_item_layout, listPresenterTheme)listMenuPresenter.setCallback(cb)listMenuPresenter.setId(com.android.internal.R.id.list_menu_presenter)menu.addMenuPresenter(listMenuPresenter)
            } //End block
            if(iconMenuPresenter!=null)            
            {
listMenuPresenter.setItemIndexOffset(iconMenuPresenter.getNumActualItemsShown())
            } //End block
            MenuView result = listMenuPresenter.getMenuView(decorView);
MenuView varDC838461EE2FA0CA4C9BBB70A15456B0_1534827314 = result            varDC838461EE2FA0CA4C9BBB70A15456B0_1534827314.addTaint(taint);
            return varDC838461EE2FA0CA4C9BBB70A15456B0_1534827314;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.561 -0400", hash_original_method = "AEDD5CBA27323E4DDF07A0733763B278", hash_generated_method = "2110B86EB5E53FEE767D33724D29F504")
         MenuView getIconMenuView(Context context, MenuPresenter.Callback cb) {
            addTaint(cb.getTaint());
            addTaint(context.getTaint());
            if(menu==null)            
            {
MenuView var540C13E9E156B687226421B24F2DF178_556422778 = null            var540C13E9E156B687226421B24F2DF178_556422778.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_556422778;
            }
            if(iconMenuPresenter==null)            
            {
iconMenuPresenter=new IconMenuPresenter(context)iconMenuPresenter.setCallback(cb)iconMenuPresenter.setId(com.android.internal.R.id.icon_menu_presenter)menu.addMenuPresenter(iconMenuPresenter)
            } //End block
            MenuView result = iconMenuPresenter.getMenuView(decorView);
MenuView varDC838461EE2FA0CA4C9BBB70A15456B0_2107615277 = result            varDC838461EE2FA0CA4C9BBB70A15456B0_2107615277.addTaint(taint);
            return varDC838461EE2FA0CA4C9BBB70A15456B0_2107615277;
            // ---------- Original Method ----------
            //if (menu == null) return null;
            //if (iconMenuPresenter == null) {
                //iconMenuPresenter = new IconMenuPresenter(context);
                //iconMenuPresenter.setCallback(cb);
                //iconMenuPresenter.setId(com.android.internal.R.id.icon_menu_presenter);
                //menu.addMenuPresenter(iconMenuPresenter);
            //}
            //MenuView result = iconMenuPresenter.getMenuView(decorView);
            //return result;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.562 -0400", hash_original_method = "CD41A177EA638807A12F51F3761CAF3B", hash_generated_method = "8D01C2AA810548B0121939B20EC09875")
         Parcelable onSaveInstanceState() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            SavedState savedState = new SavedState();
savedState.featureId=featureIdsavedState.isOpen=isOpensavedState.isInExpandedMode=isInExpandedMode            if(menu!=null)            
            {
savedState.menuState=new Bundle()menu.savePresenterStates(savedState.menuState)
            } //End block
Parcelable varA363ACBF83ED5148C571C320EDB052EA_1584277439 = savedState            varA363ACBF83ED5148C571C320EDB052EA_1584277439.addTaint(taint);
            return varA363ACBF83ED5148C571C320EDB052EA_1584277439;
            // ---------- Original Method ----------
            //SavedState savedState = new SavedState();
            //savedState.featureId = featureId;
            //savedState.isOpen = isOpen;
            //savedState.isInExpandedMode = isInExpandedMode;
            //if (menu != null) {
                //savedState.menuState = new Bundle();
                //menu.savePresenterStates(savedState.menuState);
            //}
            //return savedState;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.563 -0400", hash_original_method = "6DDD1F53623FBFFDEA557E1B4827987B", hash_generated_method = "227DC8743416CCCE2307A3DAD4F811E6")
         void onRestoreInstanceState(Parcelable state) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(state.getTaint());
            SavedState savedState = (SavedState) state;
featureId=savedState.featureIdwasLastOpen=savedState.isOpenwasLastExpanded=savedState.isInExpandedModefrozenMenuState=savedState.menuStatecreatedPanelView=nullshownPanelView=nulldecorView=null
            // ---------- Original Method ----------
            //SavedState savedState = (SavedState) state;
            //featureId = savedState.featureId;
            //wasLastOpen = savedState.isOpen;
            //wasLastExpanded = savedState.isInExpandedMode;
            //frozenMenuState = savedState.menuState;
            //createdPanelView = null;
            //shownPanelView = null;
            //decorView = null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.573 -0400", hash_original_method = "44CC0C0BA77B9513F1F204DDE54EA8B7", hash_generated_method = "986172F4FE969585629C0BE831F2C739")
         void applyFrozenState() {
            if(menu!=null&&frozenMenuState!=null)            
            {
menu.restorePresenterStates(frozenMenuState)frozenMenuState=null
            } //End block
            // ---------- Original Method ----------
            //if (menu != null && frozenMenuState != null) {
                //menu.restorePresenterStates(frozenMenuState);
                //frozenMenuState = null;
            //}
        }

        
        private static class SavedState implements Parcelable {
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.574 -0400", hash_original_field = "0EB465EA5E6DAFCB9D24D8EDF9A01664", hash_generated_field = "54DCEE629FD65EE5862FAA3F84445BB0")

            int featureId;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.575 -0400", hash_original_field = "5E7466A3BA0D44490BD6A64287013D0C", hash_generated_field = "92B8B14C3535219BF6BD132B36A9FC28")

            boolean isOpen;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.576 -0400", hash_original_field = "EE1ACF7874D8B577AB716995C9305422", hash_generated_field = "895ABC8713A2DAAFB927EB6F86026183")

            boolean isInExpandedMode;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.576 -0400", hash_original_field = "2388420678A84C54940AE89F5D4542E6", hash_generated_field = "2AA6898EDFD89FBDBC5F0FD94FA6645F")

            Bundle menuState;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.577 -0400", hash_original_method = "9FCFF8876386EB50932C6909978FCB2E", hash_generated_method = "9FCFF8876386EB50932C6909978FCB2E")
            public SavedState ()
            {
                //Synthesized constructor
            }


            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.591 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "54B3DB8D0A73F4CF055D181D6D1DC860")
            public int describeContents() {
                int varCFCD208495D565EF66E7DFF9F98764DA_1365001027 = (0);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_811099076 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_811099076;
                // ---------- Original Method ----------
                //return 0;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.594 -0400", hash_original_method = "E3E11A89542616E2FF4EB74E1145B668", hash_generated_method = "3E3BD620BEA4FF2A101EAA2B219398E7")
            public void writeToParcel(Parcel dest, int flags) {
                addTaint(flags);
                addTaint(dest.getTaint());
dest.writeInt(featureId)dest.writeInt(isOpen?1:1)dest.writeInt(isInExpandedMode?1:1)                if(isOpen)                
                {
dest.writeBundle(menuState)
                } //End block
                // ---------- Original Method ----------
                //dest.writeInt(featureId);
                //dest.writeInt(isOpen ? 1 : 0);
                //dest.writeInt(isInExpandedMode ? 1 : 0);
                //if (isOpen) {
                    //dest.writeBundle(menuState);
                //}
            }

            
                        private static SavedState readFromParcel(Parcel source) {
                SavedState savedState = new SavedState();
                savedState.featureId = source.readInt();
                savedState.isOpen = source.readInt() == 1;
                savedState.isInExpandedMode = source.readInt() == 1;
                if (savedState.isOpen) {
                    savedState.menuState = source.readBundle();
                }
                return savedState;
            }

            


        
    }


    
    static class RotationWatcher extends IRotationWatcher.Stub {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.598 -0400", hash_original_field = "C78BEDFC523DB73DF63EFB071AF1C35B", hash_generated_field = "03E47BA0CE42772601F0A13D178B12B5")

        private Handler mHandler;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.599 -0400", hash_original_field = "66E720EB0976284986D0C6C4BD608FF1", hash_generated_field = "774E4A12193FD597807D23FA89A6E97D")

        private final Runnable mRotationChanged = new Runnable()        {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.598 -0400", hash_original_method = "4E2F973341364DF4AE3F53A10AADC694", hash_generated_method = "3EABA95C8F8FA4E5E05DEC8B8C52D9CA")
            public void run() {
dispatchRotationChanged()
                // ---------- Original Method ----------
                //dispatchRotationChanged();
            }

            
        }
;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.600 -0400", hash_original_field = "5368324BFBDECB159EE5B8C321CD583F", hash_generated_field = "02CDA8E27E0E1C40FE3D5FCED208F778")

        private boolean mIsWatching;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.601 -0400", hash_original_method = "ECDE06E5268CFDFCE9E3923FD94A1FE1", hash_generated_method = "ECDE06E5268CFDFCE9E3923FD94A1FE1")
        public RotationWatcher ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.613 -0400", hash_original_method = "0468AC3E0BBDE6F14811E1D5404B28D9", hash_generated_method = "0128C45A4FD13CAFAFA323FD6163CB52")
        @Override
        public void onRotationChanged(int rotation) throws RemoteException {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(rotation);
mHandler.post(mRotationChanged)
            // ---------- Original Method ----------
            //mHandler.post(mRotationChanged);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.618 -0400", hash_original_method = "48B9D866802F8AA2D3A38EAE8BB910A0", hash_generated_method = "621272ED87D534BE673B66040B6B8CB6")
        public void addWindow(PhoneWindow phoneWindow) {
            addTaint(phoneWindow.getTaint());
            synchronized
(mWindows)            {
                if(!mIsWatching)                
                {
                    try 
                    {
WindowManagerHolder.sWindowManager.watchRotation(this)mHandler=new Handler()mIsWatching=true
                    } //End block
                    catch (RemoteException ex)
                    {
                    } //End block
                } //End block
mWindows.add(new WeakReference<PhoneWindow>(phoneWindow))
            } //End block
            // ---------- Original Method ----------
            //synchronized (mWindows) {
                //if (!mIsWatching) {
                    //try {
                        //WindowManagerHolder.sWindowManager.watchRotation(this);
                        //mHandler = new Handler();
                        //mIsWatching = true;
                    //} catch (RemoteException ex) {
                        //Log.e(TAG, "Couldn't start watching for device rotation", ex);
                    //}
                //}
                //mWindows.add(new WeakReference<PhoneWindow>(phoneWindow));
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.620 -0400", hash_original_method = "12B6B65796C4DB495E3BC530306959C4", hash_generated_method = "9E1035AD2BB6F0EDE6990782D4021032")
        public void removeWindow(PhoneWindow phoneWindow) {
            addTaint(phoneWindow.getTaint());
            synchronized
(mWindows)            {
                int i = 0;
                while
(i<mWindows.size())                
                {
                    final WeakReference<PhoneWindow> ref = mWindows.get(i);
                    final PhoneWindow win = ref.get();
                    if(win==null||win==phoneWindow)                    
                    {
mWindows.remove(i)
                    } //End block
                    else
                    {
i
                    } //End block
                } //End block
            } //End block
            // ---------- Original Method ----------
            //synchronized (mWindows) {
                //int i = 0;
                //while (i < mWindows.size()) {
                    //final WeakReference<PhoneWindow> ref = mWindows.get(i);
                    //final PhoneWindow win = ref.get();
                    //if (win == null || win == phoneWindow) {
                        //mWindows.remove(i);
                    //} else {
                        //i++;
                    //}
                //}
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.624 -0400", hash_original_method = "9AC8EEB3941C4278FF6276658A770146", hash_generated_method = "E168940971F1BE827CBD2779557D2912")
         void dispatchRotationChanged() {
            synchronized
(mWindows)            {
                int i = 0;
                while
(i<mWindows.size())                
                {
                    final WeakReference<PhoneWindow> ref = mWindows.get(i);
                    final PhoneWindow win = ref.get();
                    if(win!=null)                    
                    {
win.onOptionsPanelRotationChanged()i
                    } //End block
                    else
                    {
mWindows.remove(i)
                    } //End block
                } //End block
            } //End block
            // ---------- Original Method ----------
            //synchronized (mWindows) {
                //int i = 0;
                //while (i < mWindows.size()) {
                    //final WeakReference<PhoneWindow> ref = mWindows.get(i);
                    //final PhoneWindow win = ref.get();
                    //if (win != null) {
                        //win.onOptionsPanelRotationChanged();
                        //i++;
                    //} else {
                        //mWindows.remove(i);
                    //}
                //}
            //}
        }

        
    }


    
    private final class DialogMenuCallback implements MenuBuilder.Callback, MenuPresenter.Callback {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.625 -0400", hash_original_field = "F6788959D9AAA549D70D40F26B681311", hash_generated_field = "4B3C60F220A5F7E6DC366F9AC3591532")

        private int mFeatureId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.625 -0400", hash_original_field = "DB7B51D1BA8996A734F5C88A3F316332", hash_generated_field = "DBE78604A9F6A84F864325798381CF73")

        private MenuDialogHelper mSubMenuHelper;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.626 -0400", hash_original_method = "D51A5F67DCD207F8B6AF0163316E57AB", hash_generated_method = "B655D9FA1FBC85B0F61A74AA5FECBDFF")
        public  DialogMenuCallback(int featureId) {
            addTaint(featureId);
mFeatureId=featureId
            // ---------- Original Method ----------
            //mFeatureId = featureId;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.629 -0400", hash_original_method = "9D1C4B8C1E17DB506EA656DDB59E0C78", hash_generated_method = "53B8D1907BE4F2EB67B3B94853551101")
        public void onCloseMenu(MenuBuilder menu, boolean allMenusAreClosing) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(allMenusAreClosing);
            addTaint(menu.getTaint());
            if(menu.getRootMenu()!=menu)            
            {
onCloseSubMenu(menu)
            } //End block
            if(allMenusAreClosing)            
            {
                Callback callback = getCallback();
                if(callback!=null&&!isDestroyed())                
                {
callback.onPanelClosed(mFeatureId, menu)
                } //End block
                if(menu==mContextMenu)                
                {
dismissContextMenu()
                } //End block
                if(mSubMenuHelper!=null)                
                {
mSubMenuHelper.dismiss()mSubMenuHelper=null
                } //End block
            } //End block
            // ---------- Original Method ----------
            //if (menu.getRootMenu() != menu) {
                //onCloseSubMenu(menu);
            //}
            //if (allMenusAreClosing) {
                //Callback callback = getCallback();
                //if (callback != null && !isDestroyed()) {
                    //callback.onPanelClosed(mFeatureId, menu);
                //}
                //if (menu == mContextMenu) {
                    //dismissContextMenu();
                //}
                //if (mSubMenuHelper != null) {
                    //mSubMenuHelper.dismiss();
                    //mSubMenuHelper = null;
                //}
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.630 -0400", hash_original_method = "0211BF882D5CAD72143933E1CF363916", hash_generated_method = "668D11AA4FE68AFDE2636B34CB7DFB87")
        public void onCloseSubMenu(MenuBuilder menu) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(menu.getTaint());
            Callback callback = getCallback();
            if(callback!=null&&!isDestroyed())            
            {
callback.onPanelClosed(mFeatureId, menu.getRootMenu())
            } //End block
            // ---------- Original Method ----------
            //Callback callback = getCallback();
            //if (callback != null && !isDestroyed()) {
                //callback.onPanelClosed(mFeatureId, menu.getRootMenu());
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.635 -0400", hash_original_method = "5C2B12450F3759540DE155D277505F5A", hash_generated_method = "0EB40CDD524D8B4F4761A855E73AA3AE")
        public boolean onMenuItemSelected(MenuBuilder menu, MenuItem item) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(item.getTaint());
            addTaint(menu.getTaint());
            Callback callback = getCallback();
            boolean var4E8E10A73F560471B3233953F9183477_288670860 = ((callback!=null&&!isDestroyed())&&callback.onMenuItemSelected(mFeatureId, item));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_11042984 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_11042984;
            // ---------- Original Method ----------
            //Callback callback = getCallback();
            //return (callback != null && !isDestroyed())
                    //&& callback.onMenuItemSelected(mFeatureId, item);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.637 -0400", hash_original_method = "BD3281B75359F57929C0B7D8E3BC0065", hash_generated_method = "00C3370B4338E9D0BE3E67D205B0AEAE")
        public void onMenuModeChange(MenuBuilder menu) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(menu.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.639 -0400", hash_original_method = "707CC87C22EBF35D51C7195C5ED835C8", hash_generated_method = "9DBDD35BEA0DDFDD01ACCACAB6B013E2")
        public boolean onOpenSubMenu(MenuBuilder subMenu) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(subMenu.getTaint());
            if(subMenu==null)            
            {
            boolean var68934A3E9455FA72420237EB05902327_1757820415 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1633089338 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1633089338;
            }
subMenu.setCallback(this)mSubMenuHelper=new MenuDialogHelper(subMenu)mSubMenuHelper.show(null)            boolean varB326B5062B2F0E69046810717534CB09_1029409793 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_914214948 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_914214948;
            // ---------- Original Method ----------
            //if (subMenu == null) return false;
            //subMenu.setCallback(this);
            //mSubMenuHelper = new MenuDialogHelper(subMenu);
            //mSubMenuHelper.show(null);
            //return true;
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.640 -0400", hash_original_field = "745DA4189863D2669FB61A845FD513AE", hash_generated_field = "A09AD00745E2EF8C58018093D175B513")

    private final static String TAG = "PhoneWindow";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.640 -0400", hash_original_field = "EBD84E50C97C6D77E598F9BADC0917A9", hash_generated_field = "0EC323C3CD159E86E567EC03C8F959F5")

    private final static boolean SWEEP_OPEN_MENU = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.640 -0400", hash_original_field = "DA0AF90054A556C0F3CD31F6BEDDA5A9", hash_generated_field = "EF04DFED66F71330A1599EF3B9AECE9F")

    static final RotationWatcher sRotationWatcher = new RotationWatcher();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.640 -0400", hash_original_field = "B895141BCE0FE01F6B8A062A19FCF6F0", hash_generated_field = "CC55C9D7A0B25CA323C9CCC3200F2E6B")

    static private final String FOCUSED_ID_TAG = "android:focusedViewId";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.641 -0400", hash_original_field = "237B5DC3F4BA22C3758B5F882551D818", hash_generated_field = "CB5E0A153823A28920E8D06D6ADCC41E")

    static private final String VIEWS_TAG = "android:views";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.641 -0400", hash_original_field = "7E6A9E318D8E44F787E8DB23D5197435", hash_generated_field = "6A71A0C84258040370D760855FA50C5D")

    static private final String PANELS_TAG = "android:Panels";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:46.641 -0400", hash_original_field = "12F7982FA283314FD3DB5919DFD3F219", hash_generated_field = "FEB0E559234CB3CB85E5B9466F3978D3")

    static private final String ACTION_BAR_TAG = "android:ActionBar";
}

