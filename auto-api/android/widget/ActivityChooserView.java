package android.widget;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import com.android.internal.R;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionProvider;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.ActivityChooserModel.ActivityChooserModelClient;

public class ActivityChooserView extends ViewGroup implements ActivityChooserModelClient {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.554 -0400", hash_original_field = "59E9F255F2F17EC006AE601269EA8540", hash_generated_field = "693752B4212B867133E03234F672DAB4")

    private ActivityChooserViewAdapter mAdapter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.554 -0400", hash_original_field = "8DA114DA2B33B0EF1622BD0EE0F06E2B", hash_generated_field = "56C5A3BFBAA3C4CF09CF9C52EF52DD5C")

    private Callbacks mCallbacks;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.554 -0400", hash_original_field = "3A69536EA31C68E25F67DFFEE1C9D802", hash_generated_field = "15A85E7B2533D5C1858324D4690F18CE")

    private LinearLayout mActivityChooserContent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.554 -0400", hash_original_field = "A9CA4B951FF3389FEF3B28EA7C067B20", hash_generated_field = "2CCC7C8CA771AD7217D2AFD6C98780B1")

    private Drawable mActivityChooserContentBackground;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.554 -0400", hash_original_field = "63F80721F41BFFB03287300AEFC9638A", hash_generated_field = "3CE55FDBD0D926D55E38007406C4DF14")

    private FrameLayout mExpandActivityOverflowButton;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.554 -0400", hash_original_field = "41D59DA363A972A70E89D7F097262996", hash_generated_field = "433B613895F9A9778E53C598D01BA2AB")

    private ImageView mExpandActivityOverflowButtonImage;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.554 -0400", hash_original_field = "DAD8AB330B8FE38CED27A92AB62A5E4D", hash_generated_field = "2804585A9E453E27976F3FDF1A270905")

    private FrameLayout mDefaultActivityButton;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.554 -0400", hash_original_field = "C2BD14F014164359D2DBF374E3941AF3", hash_generated_field = "A19ECBBBF75A40B339DC4A95C030E78B")

    private ImageView mDefaultActivityButtonImage;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.554 -0400", hash_original_field = "D19DDAF4856E35C2635D5FF15637EEE6", hash_generated_field = "6549412A83E8736AC71A3C4F42B2776F")

    private int mListPopupMaxWidth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.554 -0400", hash_original_field = "BD1D19BC6BC3803BE152A977D479AC49", hash_generated_field = "94389E96F8958E34938A4C66FB6778B1")

    ActionProvider mProvider;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.555 -0400", hash_original_field = "E2DFFEE4700584126C30F533416180E4", hash_generated_field = "E3CC1E1FF392AFD93A20524A892FFE2D")

    private final DataSetObserver mModelDataSetOberver = new DataSetObserver() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.555 -0400", hash_original_method = "D32F752C027D2B93516AB0AF431CE07C", hash_generated_method = "D9FEC22D26AFC73436AFDEEE1426D33F")
        @Override
        public void onChanged() {
            
            super.onChanged();
            mAdapter.notifyDataSetChanged();
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.555 -0400", hash_original_method = "0D3B938F42D9BBAAA5442D3FB85ABED0", hash_generated_method = "339192657B2FC07CDF5B74397DFBCE1B")
        @Override
        public void onInvalidated() {
            
            super.onInvalidated();
            mAdapter.notifyDataSetInvalidated();
            
            
            
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.556 -0400", hash_original_field = "5EF451EC8A0E03D344AD0776D0D040B4", hash_generated_field = "6C78DAD49C1A9E04692D0D35D8767C86")

    private final OnGlobalLayoutListener mOnGlobalLayoutListener = new OnGlobalLayoutListener() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.556 -0400", hash_original_method = "B9295CF4AC3C2667F7355FBB8B3B9DC6", hash_generated_method = "A8DAFB1F81F49A42ED919BCD38D786B6")
        @Override
        public void onGlobalLayout() {
            
            {
                boolean var86D2C12CD473A200156C05DF07DBDDED_1247933307 = (isShowingPopup());
                {
                    {
                        boolean var87DC1C3C75E5DCFD494722F4CBC795CB_1948454925 = (!isShown());
                        {
                            getListPopupWindow().dismiss();
                        } 
                        {
                            getListPopupWindow().show();
                            {
                                mProvider.subUiVisibilityChanged(true);
                            } 
                        } 
                    } 
                } 
            } 
            
            
                
                    
                
                    
                    
                        
                    
                
            
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.556 -0400", hash_original_field = "D37E69872D15BB8AD43DD3C6E77034A5", hash_generated_field = "B18FE4D2C1F5F5724780B69F0C631713")

    private ListPopupWindow mListPopupWindow;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.556 -0400", hash_original_field = "B6794399ABC229B6F5098657922184B3", hash_generated_field = "5A4179E23C1E43233D6280AC184F1638")

    private PopupWindow.OnDismissListener mOnDismissListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.556 -0400", hash_original_field = "5302A99A8C1C0F6305F7A9ECB4B77A94", hash_generated_field = "FB5A63E1FFE964D7D3DF45A85F8B7265")

    private boolean mIsSelectingDefaultActivity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.556 -0400", hash_original_field = "50E4F4B3AA4ACDAC2444FD64183E5704", hash_generated_field = "04519B5943EE67A9C7EEE82652B59883")

    private int mInitialActivityCount = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_DEFAULT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.556 -0400", hash_original_field = "1F925504346EA79D2090BC0874ADA0DB", hash_generated_field = "A725E70F25078818B1BC03DF5AE609A6")

    private boolean mIsAttachedToWindow;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.556 -0400", hash_original_field = "5C855F3EB880070F54099C89CF873EEB", hash_generated_field = "2EB4D3D3AA67879C726AB0ABB6BA9C6A")

    private int mDefaultActionButtonContentDescription;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.556 -0400", hash_original_method = "B1417C53B7334442AE372C957DCB8F0C", hash_generated_method = "86B03DA005E6640F9AA460F2B84E2F8E")
    public  ActivityChooserView(Context context) {
        this(context, null);
        addTaint(context.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.556 -0400", hash_original_method = "5446B591236758FE1022AC56CCF4E7CA", hash_generated_method = "5B1DB93CEEE36B76CC66AE96F82716BF")
    public  ActivityChooserView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.558 -0400", hash_original_method = "82640F6029B5DED0016360DF13353C92", hash_generated_method = "7FDEEE4975D192F242E64F3EC85C4510")
    public  ActivityChooserView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        TypedArray attributesArray = context.obtainStyledAttributes(attrs,
                R.styleable.ActivityChooserView, defStyle, 0);
        mInitialActivityCount = attributesArray.getInt(
                R.styleable.ActivityChooserView_initialActivityCount,
                ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_DEFAULT);
        Drawable expandActivityOverflowButtonDrawable = attributesArray.getDrawable(
                R.styleable.ActivityChooserView_expandActivityOverflowButtonDrawable);
        attributesArray.recycle();
        LayoutInflater inflater = LayoutInflater.from(mContext);
        inflater.inflate(R.layout.activity_chooser_view, this, true);
        mCallbacks = new Callbacks();
        mActivityChooserContent = (LinearLayout) findViewById(R.id.activity_chooser_view_content);
        mActivityChooserContentBackground = mActivityChooserContent.getBackground();
        mDefaultActivityButton = (FrameLayout) findViewById(R.id.default_activity_button);
        mDefaultActivityButton.setOnClickListener(mCallbacks);
        mDefaultActivityButton.setOnLongClickListener(mCallbacks);
        mDefaultActivityButtonImage = (ImageView) mDefaultActivityButton.findViewById(R.id.image);
        mExpandActivityOverflowButton = (FrameLayout) findViewById(R.id.expand_activities_button);
        mExpandActivityOverflowButton.setOnClickListener(mCallbacks);
        mExpandActivityOverflowButtonImage =
            (ImageView) mExpandActivityOverflowButton.findViewById(R.id.image);
        mExpandActivityOverflowButtonImage.setImageDrawable(expandActivityOverflowButtonDrawable);
        mAdapter = new ActivityChooserViewAdapter();
        mAdapter.registerDataSetObserver(new DataSetObserver() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.558 -0400", hash_original_method = "77B1463ED818B52DA8559320D8129DE8", hash_generated_method = "4823B6C5288EB5E4410B6C2B7971F9E9")
            @Override
            public void onChanged() {
                
                super.onChanged();
                updateAppearance();
                
                
                
            }
});
        Resources resources = context.getResources();
        mListPopupMaxWidth = Math.max(resources.getDisplayMetrics().widthPixels / 2,
              resources.getDimensionPixelSize(com.android.internal.R.dimen.config_prefDialogWidth));
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        addTaint(defStyle);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.559 -0400", hash_original_method = "200277448D26D5459B7D9186C5FC6866", hash_generated_method = "9C93943325070949C921F53C5FB6E0E9")
    public void setActivityChooserModel(ActivityChooserModel dataModel) {
        mAdapter.setDataModel(dataModel);
        {
            boolean varA195EA33C31D5F7626FCB680335C6A1C_451836065 = (isShowingPopup());
            {
                dismissPopup();
                showPopup();
            } 
        } 
        addTaint(dataModel.getTaint());
        
        
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.559 -0400", hash_original_method = "40C8CFBBBEC7CE8C6DC800BBA1A8260F", hash_generated_method = "66F73E3D03229CB3BCB71BBEDE7323C7")
    public void setExpandActivityOverflowButtonDrawable(Drawable drawable) {
        mExpandActivityOverflowButtonImage.setImageDrawable(drawable);
        addTaint(drawable.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.559 -0400", hash_original_method = "0A5827A88A56386A8A69EC0550F49C43", hash_generated_method = "89D6F89E9CDC11B5ED8C60883F760679")
    public void setExpandActivityOverflowButtonContentDescription(int resourceId) {
        CharSequence contentDescription = mContext.getString(resourceId);
        mExpandActivityOverflowButtonImage.setContentDescription(contentDescription);
        addTaint(resourceId);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.559 -0400", hash_original_method = "4EB99ACA5BA34A284707803087697EF8", hash_generated_method = "BB5F635A8854257C75F3E39227EB8F20")
    public void setProvider(ActionProvider provider) {
        mProvider = provider;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.560 -0400", hash_original_method = "D9F80F56BE7AEC83902DD1E82500AB90", hash_generated_method = "CCE86C0438481AA309AE280837C883BF")
    public boolean showPopup() {
        {
            boolean varC70DA951A66294B5F2823A0381F01D29_439824536 = (isShowingPopup() || !mIsAttachedToWindow);
        } 
        mIsSelectingDefaultActivity = false;
        showPopupUnchecked(mInitialActivityCount);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1346090533 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1346090533;
        
        
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.560 -0400", hash_original_method = "3AECC6260DA21BAD7E8B15E74C7BA72C", hash_generated_method = "39150F358503BD0B7F49D54C361B1CEF")
    private void showPopupUnchecked(int maxActivityCount) {
        {
            boolean varD8A7F383AAD10EDB59F860F56C2DD1E1_462608229 = (mAdapter.getDataModel() == null);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("No data model. Did you call #setDataModel?");
            } 
        } 
        getViewTreeObserver().addOnGlobalLayoutListener(mOnGlobalLayoutListener);
        final boolean defaultActivityButtonShown = mDefaultActivityButton.getVisibility() == VISIBLE;
        final int activityCount = mAdapter.getActivityCount();
        int maxActivityCountOffset;
        maxActivityCountOffset = 1;
        maxActivityCountOffset = 0;
        {
            mAdapter.setShowFooterView(true);
            mAdapter.setMaxActivityCount(maxActivityCount - 1);
        } 
        {
            mAdapter.setShowFooterView(false);
            mAdapter.setMaxActivityCount(maxActivityCount);
        } 
        ListPopupWindow popupWindow = getListPopupWindow();
        {
            boolean varAAFF79C36ECCA2A466D0EE20078CA5AC_1490190013 = (!popupWindow.isShowing());
            {
                {
                    mAdapter.setShowDefaultActivity(true, defaultActivityButtonShown);
                } 
                {
                    mAdapter.setShowDefaultActivity(false, false);
                } 
                final int contentWidth = Math.min(mAdapter.measureContentWidth(), mListPopupMaxWidth);
                popupWindow.setContentWidth(contentWidth);
                popupWindow.show();
                {
                    mProvider.subUiVisibilityChanged(true);
                } 
                popupWindow.getListView().setContentDescription(mContext.getString(
                    R.string.activitychooserview_choose_application));
            } 
        } 
        addTaint(maxActivityCount);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.561 -0400", hash_original_method = "D685C2FA386E3559D94DAB46E30EF0B9", hash_generated_method = "FC035306010870B874F82D153E48C7B4")
    public boolean dismissPopup() {
        {
            boolean varA195EA33C31D5F7626FCB680335C6A1C_747245668 = (isShowingPopup());
            {
                getListPopupWindow().dismiss();
                ViewTreeObserver viewTreeObserver = getViewTreeObserver();
                {
                    boolean varDA870088D05313F0375DA9DC21C38FAD_352345865 = (viewTreeObserver.isAlive());
                    {
                        viewTreeObserver.removeGlobalOnLayoutListener(mOnGlobalLayoutListener);
                    } 
                } 
            } 
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_674397493 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_674397493;
        
        
            
            
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.561 -0400", hash_original_method = "E45D6D96430861522854D560F5CA6F0B", hash_generated_method = "0434FEFA200F70CC655C1858E01D0C6C")
    public boolean isShowingPopup() {
        boolean var2C1ED328370BD07F3FFCA303C77D80C8_338220515 = (getListPopupWindow().isShowing());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1544563096 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1544563096;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.561 -0400", hash_original_method = "F599B3D6D046BF4212D64A5D6A7F3811", hash_generated_method = "AFFF1FF17BF147248B4B60DA938C125B")
    @Override
    protected void onAttachedToWindow() {
        
        super.onAttachedToWindow();
        ActivityChooserModel dataModel = mAdapter.getDataModel();
        {
            dataModel.registerObserver(mModelDataSetOberver);
        } 
        mIsAttachedToWindow = true;
        
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.562 -0400", hash_original_method = "589218240FC22193C94953AC6574E4EA", hash_generated_method = "BA57323DC9585A8EDDF7C5A0AA7A20AD")
    @Override
    protected void onDetachedFromWindow() {
        
        super.onDetachedFromWindow();
        ActivityChooserModel dataModel = mAdapter.getDataModel();
        {
            dataModel.unregisterObserver(mModelDataSetOberver);
        } 
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        {
            boolean var857E944F9C56602391F5DE64EA1D02FD_220915365 = (viewTreeObserver.isAlive());
            {
                viewTreeObserver.removeGlobalOnLayoutListener(mOnGlobalLayoutListener);
            } 
        } 
        mIsAttachedToWindow = false;
        
        
        
        
            
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.562 -0400", hash_original_method = "77C33EEC897BED8B2A12DF2072C37646", hash_generated_method = "DBD54FD3D6D9FD1C2B80A859EF617166")
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        
        View child = mActivityChooserContent;
        {
            boolean varE1A734960699BCC84BF18F8452B15DCC_1121418500 = (mDefaultActivityButton.getVisibility() != VISIBLE);
            {
                heightMeasureSpec = MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(heightMeasureSpec),
                    MeasureSpec.EXACTLY);
            } 
        } 
        measureChild(child, widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(child.getMeasuredWidth(), child.getMeasuredHeight());
        addTaint(widthMeasureSpec);
        addTaint(heightMeasureSpec);
        
        
        
            
                    
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.562 -0400", hash_original_method = "C5A31C6F2FD14D87574B0913D4F6A2F2", hash_generated_method = "FFF720726447A7B9A352339D40182CDC")
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        
        mActivityChooserContent.layout(0, 0, right - left, bottom - top);
        {
            boolean var8A3CF4F8772E9C29621A3DC4C81C93B9_1085217168 = (getListPopupWindow().isShowing());
            {
                showPopupUnchecked(mAdapter.getMaxActivityCount());
            } 
            {
                dismissPopup();
            } 
        } 
        addTaint(changed);
        addTaint(left);
        addTaint(top);
        addTaint(right);
        addTaint(bottom);
        
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.563 -0400", hash_original_method = "5EF19A4E1889AB1FC4A984C090B7713C", hash_generated_method = "6C24B47941F757D06163665EE7EC8BF8")
    public ActivityChooserModel getDataModel() {
        ActivityChooserModel varB4EAC82CA7396A68D541C85D26508E83_506751118 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_506751118 = mAdapter.getDataModel();
        varB4EAC82CA7396A68D541C85D26508E83_506751118.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_506751118;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.563 -0400", hash_original_method = "3D692CC2129791FB098BE485AC739689", hash_generated_method = "AFEDE7910A1B37993DCCD6535D2798FB")
    public void setOnDismissListener(PopupWindow.OnDismissListener listener) {
        mOnDismissListener = listener;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.563 -0400", hash_original_method = "861F24EC23ECA4CA4EF104A377B2D34D", hash_generated_method = "706332B7EEAD1AE51173D975872ABB45")
    public void setInitialActivityCount(int itemCount) {
        mInitialActivityCount = itemCount;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.564 -0400", hash_original_method = "A16FFC5DB1EC302B931A83E3D5524FB1", hash_generated_method = "3AA11D7A925E1612E7FB383801FF727D")
    public void setDefaultActionButtonContentDescription(int resourceId) {
        mDefaultActionButtonContentDescription = resourceId;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.564 -0400", hash_original_method = "A13663EF62899FD593D247A6177CE71D", hash_generated_method = "202ABF400C60C945635751A9E436C37D")
    private ListPopupWindow getListPopupWindow() {
        ListPopupWindow varB4EAC82CA7396A68D541C85D26508E83_1137283526 = null; 
        {
            mListPopupWindow = new ListPopupWindow(getContext());
            mListPopupWindow.setAdapter(mAdapter);
            mListPopupWindow.setAnchorView(ActivityChooserView.this);
            mListPopupWindow.setModal(true);
            mListPopupWindow.setOnItemClickListener(mCallbacks);
            mListPopupWindow.setOnDismissListener(mCallbacks);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1137283526 = mListPopupWindow;
        varB4EAC82CA7396A68D541C85D26508E83_1137283526.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1137283526;
        
        
            
            
            
            
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.565 -0400", hash_original_method = "D65ED5C5B81BB78866247BEAE65AB728", hash_generated_method = "AB35437AF419FDC4CBD8F19CD57234D2")
    private void updateAppearance() {
        {
            boolean var4FF3551BFBD674C949BD8CC224028345_2118919402 = (mAdapter.getCount() > 0);
            {
                mExpandActivityOverflowButton.setEnabled(true);
            } 
            {
                mExpandActivityOverflowButton.setEnabled(false);
            } 
        } 
        final int activityCount = mAdapter.getActivityCount();
        final int historySize = mAdapter.getHistorySize();
        {
            mDefaultActivityButton.setVisibility(VISIBLE);
            ResolveInfo activity = mAdapter.getDefaultActivity();
            PackageManager packageManager = mContext.getPackageManager();
            mDefaultActivityButtonImage.setImageDrawable(activity.loadIcon(packageManager));
            {
                CharSequence label = activity.loadLabel(packageManager);
                String contentDescription = mContext.getString(
                        mDefaultActionButtonContentDescription, label);
                mDefaultActivityButton.setContentDescription(contentDescription);
            } 
        } 
        {
            mDefaultActivityButton.setVisibility(View.GONE);
        } 
        {
            boolean var001BAB457545B2C4C96637DE43FA9E70_635899233 = (mDefaultActivityButton.getVisibility() == VISIBLE);
            {
                mActivityChooserContent.setBackgroundDrawable(mActivityChooserContentBackground);
            } 
            {
                mActivityChooserContent.setBackgroundDrawable(null);
            } 
        } 
        
        
    }

    
    private class Callbacks implements AdapterView.OnItemClickListener, View.OnClickListener, View.OnLongClickListener, PopupWindow.OnDismissListener {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.565 -0400", hash_original_method = "BBA4719757F5E3331C7832D116B199C8", hash_generated_method = "BBA4719757F5E3331C7832D116B199C8")
        public Callbacks ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.565 -0400", hash_original_method = "674D57987B8C667CB3D7FFB12FCDD905", hash_generated_method = "CD73E2AC9C18B6E62B2EEEAF4BB93285")
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            
            ActivityChooserViewAdapter adapter = (ActivityChooserViewAdapter) parent.getAdapter();
            final int itemViewType = adapter.getItemViewType(position);
            
            {
                showPopupUnchecked(ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            } 
            
            
            {
                dismissPopup();
                {
                    {
                        mAdapter.getDataModel().setDefaultActivity(position);
                    } 
                } 
                {
                    position = mAdapter.getShowDefaultActivity() ? position : position + 1;
                    Intent launchIntent = mAdapter.getDataModel().chooseActivity(position);
                    {
                        mContext.startActivity(launchIntent);
                    } 
                } 
            } 
            
            
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
            
            addTaint(parent.getTaint());
            addTaint(view.getTaint());
            addTaint(position);
            addTaint(id);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.566 -0400", hash_original_method = "B05554F780928527AD52A76E48C9B5FF", hash_generated_method = "29CE79BE05DB28A57C76E30FBC25E153")
        public void onClick(View view) {
            
            {
                dismissPopup();
                ResolveInfo defaultActivity = mAdapter.getDefaultActivity();
                final int index = mAdapter.getDataModel().getActivityIndex(defaultActivity);
                Intent launchIntent = mAdapter.getDataModel().chooseActivity(index);
                {
                    mContext.startActivity(launchIntent);
                } 
            } 
            {
                mIsSelectingDefaultActivity = false;
                showPopupUnchecked(mInitialActivityCount);
            } 
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
            } 
            addTaint(view.getTaint());
            
            
                
                
                
                
                
                    
                
            
                
                
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.566 -0400", hash_original_method = "FB2F3C2103372446E9D5711FBCAD6598", hash_generated_method = "9D78DCF1D5CB9C9BE149670622D5E5A7")
        @Override
        public boolean onLongClick(View view) {
            
            {
                {
                    boolean varCB03AE2B5AD76B1EBB5A332DEE95D3A2_1451500023 = (mAdapter.getCount() > 0);
                    {
                        mIsSelectingDefaultActivity = true;
                        showPopupUnchecked(mInitialActivityCount);
                    } 
                } 
            } 
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
            } 
            addTaint(view.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1188303576 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1188303576;
            
            
                
                    
                    
                
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.566 -0400", hash_original_method = "D25064A646F02B95A775BA0461A79BFD", hash_generated_method = "BE9243D05A487682CD6DC7A8F0FEFA81")
        public void onDismiss() {
            
            notifyOnDismissListener();
            {
                mProvider.subUiVisibilityChanged(false);
            } 
            
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.567 -0400", hash_original_method = "5021FB127D2DB881B8B1C45B5E11E195", hash_generated_method = "430B7D86C4A6C26C67649C07E3329E29")
        private void notifyOnDismissListener() {
            {
                mOnDismissListener.onDismiss();
            } 
            
            
                
            
        }

        
    }


    
    private class ActivityChooserViewAdapter extends BaseAdapter {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.567 -0400", hash_original_field = "50A2FAD5E06F7194FA7769A1A3E62D87", hash_generated_field = "4B23A60A5EE2A01D93FA935950453A89")

        private ActivityChooserModel mDataModel;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.567 -0400", hash_original_field = "B987B83C5177B9AFB697E37A66BDA301", hash_generated_field = "7E27524CCC6935FAB8F88BAF1C6AE0A3")

        private int mMaxActivityCount = MAX_ACTIVITY_COUNT_DEFAULT;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.567 -0400", hash_original_field = "87ABBEC987619D585AA0E13F787A82A2", hash_generated_field = "E8EE97CA68AAFA64A18B7D487730ED89")

        private boolean mShowDefaultActivity;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.567 -0400", hash_original_field = "713E85B0BB0A9AB65769E7BDFA193547", hash_generated_field = "F496D5B1359B104FF475E03332F1A6A6")

        private boolean mHighlightDefaultActivity;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.567 -0400", hash_original_field = "5443D153EDC335581CB5CD2DE0645B49", hash_generated_field = "41BD5170A6AC3F68C312DE8FD93FC32C")

        private boolean mShowFooterView;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.567 -0400", hash_original_method = "BA43971C492C1B02A22C4BF340770F66", hash_generated_method = "BA43971C492C1B02A22C4BF340770F66")
        public ActivityChooserViewAdapter ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.568 -0400", hash_original_method = "ACCCD73AF35EBCB0E150696E3946651D", hash_generated_method = "ED243AA3F41707EEF51BF4C6F2FC22BA")
        public void setDataModel(ActivityChooserModel dataModel) {
            ActivityChooserModel oldDataModel = mAdapter.getDataModel();
            {
                boolean var202863922DDD2F04977721BC536BA503_1371370253 = (oldDataModel != null && isShown());
                {
                    oldDataModel.unregisterObserver(mModelDataSetOberver);
                } 
            } 
            mDataModel = dataModel;
            {
                boolean varCD1604D23D5ECAA0D5AF59F7BBDE1B9B_755152029 = (dataModel != null && isShown());
                {
                    dataModel.registerObserver(mModelDataSetOberver);
                } 
            } 
            notifyDataSetChanged();
            
            
            
                
            
            
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.568 -0400", hash_original_method = "39EE4EFF86EDF87DA80E694DA09810EF", hash_generated_method = "52C3312838EBC11460AAF8F170D8A67F")
        @Override
        public int getItemViewType(int position) {
            {
                boolean var981C79D919698375E2C4BE7F06692C65_844477816 = (mShowFooterView && position == getCount() - 1);
            } 
            addTaint(position);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_198885897 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_198885897;
            
            
                
            
                
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.569 -0400", hash_original_method = "A69A431394F21E5FD61198963B3D5202", hash_generated_method = "BF29C59B11D153405572E9B4D36D3397")
        @Override
        public int getViewTypeCount() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1677717320 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1677717320;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.569 -0400", hash_original_method = "1BE11BD9F55247D049566CF39D6E3C60", hash_generated_method = "12DECEB04A587BF7FAFA3F8279A8078F")
        public int getCount() {
            int count = 0;
            int activityCount = mDataModel.getActivityCount();
            {
                boolean varF814B9BEDBAA3CF9D359B9B0AECA89BE_291864183 = (!mShowDefaultActivity && mDataModel.getDefaultActivity() != null);
            } 
            count = Math.min(activityCount, mMaxActivityCount);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_285068155 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_285068155;
            
            
            
            
                
            
            
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.571 -0400", hash_original_method = "F3D4BDC985376DF5677372C13824236A", hash_generated_method = "1D92A096F38EFE2876346C6E086B977F")
        public Object getItem(int position) {
            Object varB4EAC82CA7396A68D541C85D26508E83_941068253 = null; 
            Object varB4EAC82CA7396A68D541C85D26508E83_1222719102 = null; 
            final int itemViewType = getItemViewType(position);
            
            varB4EAC82CA7396A68D541C85D26508E83_941068253 = null;
            
            
            {
                boolean varF814B9BEDBAA3CF9D359B9B0AECA89BE_1891774030 = (!mShowDefaultActivity && mDataModel.getDefaultActivity() != null);
            } 
            
            
            varB4EAC82CA7396A68D541C85D26508E83_1222719102 = mDataModel.getActivity(position);
            
            
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
            
            addTaint(position);
            Object varA7E53CE21691AB073D9660D615818899_1777096538; 
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: 
                    varA7E53CE21691AB073D9660D615818899_1777096538 = varB4EAC82CA7396A68D541C85D26508E83_941068253;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1777096538 = varB4EAC82CA7396A68D541C85D26508E83_1222719102;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1777096538.addTaint(getTaint()); 
            return varA7E53CE21691AB073D9660D615818899_1777096538;
            
            
            
                
                    
                
                    
                        
                    
                    
                
                    
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.571 -0400", hash_original_method = "7144EF990F660E75AA61001CF21A1CD5", hash_generated_method = "A9B1DFA56B78FF1CB1D516F53F30EB23")
        public long getItemId(int position) {
            addTaint(position);
            long var0F5264038205EDFB1AC05FBB0E8C5E94_1415386453 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1415386453;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.572 -0400", hash_original_method = "6D38E6A963432D636038206F8FE6305D", hash_generated_method = "A0FBBD76BFBE0543BD5A2280149585AD")
        public View getView(int position, View convertView, ViewGroup parent) {
            View varB4EAC82CA7396A68D541C85D26508E83_1113534116 = null; 
            View varB4EAC82CA7396A68D541C85D26508E83_1063034783 = null; 
            final int itemViewType = getItemViewType(position);
            
            {
                boolean var6FC33BA0650785760E5F5779267DB862_1700783236 = (convertView == null || convertView.getId() != ITEM_VIEW_TYPE_FOOTER);
                {
                    convertView = LayoutInflater.from(getContext()).inflate(
                                R.layout.activity_chooser_view_list_item, parent, false);
                    convertView.setId(ITEM_VIEW_TYPE_FOOTER);
                    TextView titleView = (TextView) convertView.findViewById(R.id.title);
                    titleView.setText(mContext.getString(
                                R.string.activity_chooser_view_see_all));
                } 
            } 
            
            
            varB4EAC82CA7396A68D541C85D26508E83_1113534116 = convertView;
            
            
            {
                boolean var942A79868098ABCA25E80E95C3590B75_1983425368 = (convertView == null || convertView.getId() != R.id.list_item);
                {
                    convertView = LayoutInflater.from(getContext()).inflate(
                                R.layout.activity_chooser_view_list_item, parent, false);
                } 
            } 
            
            
            PackageManager packageManager = mContext.getPackageManager();
            
            
            ImageView iconView = (ImageView) convertView.findViewById(R.id.icon);
            
            
            ResolveInfo activity = (ResolveInfo) getItem(position);
            
            
            iconView.setImageDrawable(activity.loadIcon(packageManager));
            
            
            TextView titleView = (TextView) convertView.findViewById(R.id.title);
            
            
            titleView.setText(activity.loadLabel(packageManager));
            
            
            {
                convertView.setActivated(true);
            } 
            {
                convertView.setActivated(false);
            } 
            
            
            varB4EAC82CA7396A68D541C85D26508E83_1063034783 = convertView;
            
            
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
            
            addTaint(position);
            addTaint(convertView.getTaint());
            addTaint(parent.getTaint());
            View varA7E53CE21691AB073D9660D615818899_1392318912; 
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: 
                    varA7E53CE21691AB073D9660D615818899_1392318912 = varB4EAC82CA7396A68D541C85D26508E83_1113534116;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1392318912 = varB4EAC82CA7396A68D541C85D26508E83_1063034783;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1392318912.addTaint(getTaint()); 
            return varA7E53CE21691AB073D9660D615818899_1392318912;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.573 -0400", hash_original_method = "E7848C130F305A2BB53DDDF9782AAF0B", hash_generated_method = "4826431B986AB1DB421C481FCA52E51C")
        public int measureContentWidth() {
            final int oldMaxActivityCount = mMaxActivityCount;
            mMaxActivityCount = MAX_ACTIVITY_COUNT_UNLIMITED;
            int contentWidth = 0;
            View itemView = null;
            final int widthMeasureSpec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
            final int heightMeasureSpec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
            final int count = getCount();
            {
                int i = 0;
                {
                    itemView = getView(i, itemView, null);
                    itemView.measure(widthMeasureSpec, heightMeasureSpec);
                    contentWidth = Math.max(contentWidth, itemView.getMeasuredWidth());
                } 
            } 
            mMaxActivityCount = oldMaxActivityCount;
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_755525965 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_755525965;
            
            
            
            
            
            
            
            
            
                
                
                
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.573 -0400", hash_original_method = "EE079429AB45DD891FDFB8F4CAB39411", hash_generated_method = "2BE62C7C87B43BA54EC6967E04C743C6")
        public void setMaxActivityCount(int maxActivityCount) {
            {
                mMaxActivityCount = maxActivityCount;
                notifyDataSetChanged();
            } 
            
            
                
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.574 -0400", hash_original_method = "D919FDFCC3B420966F5D4C74A721F1BF", hash_generated_method = "71C275375DA596C2D7514A8F22326A67")
        public ResolveInfo getDefaultActivity() {
            ResolveInfo varB4EAC82CA7396A68D541C85D26508E83_1654770467 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1654770467 = mDataModel.getDefaultActivity();
            varB4EAC82CA7396A68D541C85D26508E83_1654770467.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1654770467;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.574 -0400", hash_original_method = "4D9F28247FB57368F2D0E306E2284064", hash_generated_method = "5660AEF5BBE0DC5076DEE733A7C53808")
        public void setShowFooterView(boolean showFooterView) {
            {
                mShowFooterView = showFooterView;
                notifyDataSetChanged();
            } 
            
            
                
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.575 -0400", hash_original_method = "31736EA607A445202315EB7B50B5EA80", hash_generated_method = "2B4B7F4D80AC247050FA5D78DDD30F3F")
        public int getActivityCount() {
            int var6460B5DBA03A343DD887FC92C951DF49_1947512525 = (mDataModel.getActivityCount());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1266407837 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1266407837;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.575 -0400", hash_original_method = "1D0D91D46AAECCD7C2767CF25FDA64BD", hash_generated_method = "8C76C2C8504B0404B45C16F0B46934AF")
        public int getHistorySize() {
            int var5136F899EC720A1DABAB34435B7D0CB9_252923550 = (mDataModel.getHistorySize());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_289231556 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_289231556;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.575 -0400", hash_original_method = "3E4531A24528D01DAB939C9C71B2C3DE", hash_generated_method = "B5D9CAEF995F0ACF9C89E78E9E6307C5")
        public int getMaxActivityCount() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1498657453 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1498657453;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.576 -0400", hash_original_method = "5525C6AC91C9709046E305FD9A15863B", hash_generated_method = "E9FFBB0871DB8C063D386806AB689238")
        public ActivityChooserModel getDataModel() {
            ActivityChooserModel varB4EAC82CA7396A68D541C85D26508E83_2122073697 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_2122073697 = mDataModel;
            varB4EAC82CA7396A68D541C85D26508E83_2122073697.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_2122073697;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.576 -0400", hash_original_method = "A23AAFB309F0D7012150D94437C8B43A", hash_generated_method = "D1DC4082A4C9F45EA9989CD887CCE727")
        public void setShowDefaultActivity(boolean showDefaultActivity,
                boolean highlightDefaultActivity) {
            {
                mShowDefaultActivity = showDefaultActivity;
                mHighlightDefaultActivity = highlightDefaultActivity;
                notifyDataSetChanged();
            } 
            
            
                    
                
                
                
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.576 -0400", hash_original_method = "1922E89BA39A7DE83F0D6E6EABDFE98E", hash_generated_method = "E4D712316B84081765DFA877B7649CCD")
        public boolean getShowDefaultActivity() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1176040566 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1176040566;
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.576 -0400", hash_original_field = "3AB659CF2ABB2A30495C6541B674B4DA", hash_generated_field = "76769A97B1782495BC5DE9799BE9BD4F")

        public static final int MAX_ACTIVITY_COUNT_UNLIMITED = Integer.MAX_VALUE;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.576 -0400", hash_original_field = "9A948FBD83F151D7B6865F79C07B61CF", hash_generated_field = "A9C0946733D648F3335EA0A2B5A4F65D")

        public static final int MAX_ACTIVITY_COUNT_DEFAULT = 4;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.576 -0400", hash_original_field = "2D5337C89A2BBDBAB8089E3104D05A58", hash_generated_field = "383E306DC665688B3D7C808185F54821")

        private static final int ITEM_VIEW_TYPE_ACTIVITY = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.576 -0400", hash_original_field = "56FBBE17487B87761CABEC4D515AA0BC", hash_generated_field = "79F678647BCDD97164F6B347EC57B1D5")

        private static final int ITEM_VIEW_TYPE_FOOTER = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.576 -0400", hash_original_field = "F174C44C46468510CCD8705E3812E20F", hash_generated_field = "68D4CDA5BEF3FD9B9DF66A65A3536699")

        private static final int ITEM_VIEW_TYPE_COUNT = 3;
    }


    
}

