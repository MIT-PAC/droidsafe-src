package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.958 -0400", hash_original_field = "59E9F255F2F17EC006AE601269EA8540", hash_generated_field = "693752B4212B867133E03234F672DAB4")

    private ActivityChooserViewAdapter mAdapter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.958 -0400", hash_original_field = "8DA114DA2B33B0EF1622BD0EE0F06E2B", hash_generated_field = "56C5A3BFBAA3C4CF09CF9C52EF52DD5C")

    private Callbacks mCallbacks;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.958 -0400", hash_original_field = "3A69536EA31C68E25F67DFFEE1C9D802", hash_generated_field = "15A85E7B2533D5C1858324D4690F18CE")

    private LinearLayout mActivityChooserContent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.959 -0400", hash_original_field = "A9CA4B951FF3389FEF3B28EA7C067B20", hash_generated_field = "2CCC7C8CA771AD7217D2AFD6C98780B1")

    private Drawable mActivityChooserContentBackground;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.959 -0400", hash_original_field = "63F80721F41BFFB03287300AEFC9638A", hash_generated_field = "3CE55FDBD0D926D55E38007406C4DF14")

    private FrameLayout mExpandActivityOverflowButton;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.959 -0400", hash_original_field = "41D59DA363A972A70E89D7F097262996", hash_generated_field = "433B613895F9A9778E53C598D01BA2AB")

    private ImageView mExpandActivityOverflowButtonImage;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.959 -0400", hash_original_field = "DAD8AB330B8FE38CED27A92AB62A5E4D", hash_generated_field = "2804585A9E453E27976F3FDF1A270905")

    private FrameLayout mDefaultActivityButton;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.959 -0400", hash_original_field = "C2BD14F014164359D2DBF374E3941AF3", hash_generated_field = "A19ECBBBF75A40B339DC4A95C030E78B")

    private ImageView mDefaultActivityButtonImage;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.959 -0400", hash_original_field = "D19DDAF4856E35C2635D5FF15637EEE6", hash_generated_field = "6549412A83E8736AC71A3C4F42B2776F")

    private int mListPopupMaxWidth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.959 -0400", hash_original_field = "BD1D19BC6BC3803BE152A977D479AC49", hash_generated_field = "94389E96F8958E34938A4C66FB6778B1")

    ActionProvider mProvider;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.965 -0400", hash_original_field = "E2DFFEE4700584126C30F533416180E4", hash_generated_field = "12253AABB70CE07CF09065DCD4C7B666")

    private DataSetObserver mModelDataSetOberver = new DataSetObserver() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.959 -0400", hash_original_method = "D32F752C027D2B93516AB0AF431CE07C", hash_generated_method = "D9FEC22D26AFC73436AFDEEE1426D33F")
        @Override
        public void onChanged() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            super.onChanged();
            mAdapter.notifyDataSetChanged();
            // ---------- Original Method ----------
            //super.onChanged();
            //mAdapter.notifyDataSetChanged();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.964 -0400", hash_original_method = "0D3B938F42D9BBAAA5442D3FB85ABED0", hash_generated_method = "339192657B2FC07CDF5B74397DFBCE1B")
        @Override
        public void onInvalidated() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            super.onInvalidated();
            mAdapter.notifyDataSetInvalidated();
            // ---------- Original Method ----------
            //super.onInvalidated();
            //mAdapter.notifyDataSetInvalidated();
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.965 -0400", hash_original_field = "5EF451EC8A0E03D344AD0776D0D040B4", hash_generated_field = "9E3EAA948E3FBDF5A4A4311B29D3C933")

    private OnGlobalLayoutListener mOnGlobalLayoutListener = new OnGlobalLayoutListener() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.965 -0400", hash_original_method = "B9295CF4AC3C2667F7355FBB8B3B9DC6", hash_generated_method = "9863E89BA5B464DBFE5D1D794DB5C9C3")
        @Override
        public void onGlobalLayout() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            {
                boolean var86D2C12CD473A200156C05DF07DBDDED_170439126 = (isShowingPopup());
                {
                    {
                        boolean var87DC1C3C75E5DCFD494722F4CBC795CB_1842995605 = (!isShown());
                        {
                            getListPopupWindow().dismiss();
                        } //End block
                        {
                            getListPopupWindow().show();
                            {
                                mProvider.subUiVisibilityChanged(true);
                            } //End block
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //if (isShowingPopup()) {
                //if (!isShown()) {
                    //getListPopupWindow().dismiss();
                //} else {
                    //getListPopupWindow().show();
                    //if (mProvider != null) {
                        //mProvider.subUiVisibilityChanged(true);
                    //}
                //}
            //}
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.965 -0400", hash_original_field = "D37E69872D15BB8AD43DD3C6E77034A5", hash_generated_field = "B18FE4D2C1F5F5724780B69F0C631713")

    private ListPopupWindow mListPopupWindow;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.965 -0400", hash_original_field = "B6794399ABC229B6F5098657922184B3", hash_generated_field = "5A4179E23C1E43233D6280AC184F1638")

    private PopupWindow.OnDismissListener mOnDismissListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.965 -0400", hash_original_field = "5302A99A8C1C0F6305F7A9ECB4B77A94", hash_generated_field = "FB5A63E1FFE964D7D3DF45A85F8B7265")

    private boolean mIsSelectingDefaultActivity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.965 -0400", hash_original_field = "50E4F4B3AA4ACDAC2444FD64183E5704", hash_generated_field = "04519B5943EE67A9C7EEE82652B59883")

    private int mInitialActivityCount = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_DEFAULT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.965 -0400", hash_original_field = "1F925504346EA79D2090BC0874ADA0DB", hash_generated_field = "A725E70F25078818B1BC03DF5AE609A6")

    private boolean mIsAttachedToWindow;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.965 -0400", hash_original_field = "5C855F3EB880070F54099C89CF873EEB", hash_generated_field = "2EB4D3D3AA67879C726AB0ABB6BA9C6A")

    private int mDefaultActionButtonContentDescription;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.966 -0400", hash_original_method = "B1417C53B7334442AE372C957DCB8F0C", hash_generated_method = "86B03DA005E6640F9AA460F2B84E2F8E")
    public  ActivityChooserView(Context context) {
        this(context, null);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.966 -0400", hash_original_method = "5446B591236758FE1022AC56CCF4E7CA", hash_generated_method = "5B1DB93CEEE36B76CC66AE96F82716BF")
    public  ActivityChooserView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.973 -0400", hash_original_method = "82640F6029B5DED0016360DF13353C92", hash_generated_method = "7A40C3409132266549B6B7052ADB0094")
    public  ActivityChooserView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        TypedArray attributesArray;
        attributesArray = context.obtainStyledAttributes(attrs,
                R.styleable.ActivityChooserView, defStyle, 0);
        mInitialActivityCount = attributesArray.getInt(
                R.styleable.ActivityChooserView_initialActivityCount,
                ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_DEFAULT);
        Drawable expandActivityOverflowButtonDrawable;
        expandActivityOverflowButtonDrawable = attributesArray.getDrawable(
                R.styleable.ActivityChooserView_expandActivityOverflowButtonDrawable);
        attributesArray.recycle();
        LayoutInflater inflater;
        inflater = LayoutInflater.from(mContext);
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
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.972 -0400", hash_original_method = "77B1463ED818B52DA8559320D8129DE8", hash_generated_method = "4823B6C5288EB5E4410B6C2B7971F9E9")
            @Override
            public void onChanged() {
                //DSFIXME:  CODE0009: Possible callback target function detected
                super.onChanged();
                updateAppearance();
                // ---------- Original Method ----------
                //super.onChanged();
                //updateAppearance();
            }
});
        Resources resources;
        resources = context.getResources();
        mListPopupMaxWidth = Math.max(resources.getDisplayMetrics().widthPixels / 2,
              resources.getDimensionPixelSize(com.android.internal.R.dimen.config_prefDialogWidth));
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        addTaint(defStyle);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.973 -0400", hash_original_method = "200277448D26D5459B7D9186C5FC6866", hash_generated_method = "9AB76F884033F17149842FE169212E8D")
    public void setActivityChooserModel(ActivityChooserModel dataModel) {
        mAdapter.setDataModel(dataModel);
        {
            boolean varA195EA33C31D5F7626FCB680335C6A1C_1051572319 = (isShowingPopup());
            {
                dismissPopup();
                showPopup();
            } //End block
        } //End collapsed parenthetic
        addTaint(dataModel.getTaint());
        // ---------- Original Method ----------
        //mAdapter.setDataModel(dataModel);
        //if (isShowingPopup()) {
            //dismissPopup();
            //showPopup();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.973 -0400", hash_original_method = "40C8CFBBBEC7CE8C6DC800BBA1A8260F", hash_generated_method = "66F73E3D03229CB3BCB71BBEDE7323C7")
    public void setExpandActivityOverflowButtonDrawable(Drawable drawable) {
        mExpandActivityOverflowButtonImage.setImageDrawable(drawable);
        addTaint(drawable.getTaint());
        // ---------- Original Method ----------
        //mExpandActivityOverflowButtonImage.setImageDrawable(drawable);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.981 -0400", hash_original_method = "0A5827A88A56386A8A69EC0550F49C43", hash_generated_method = "AEF9D39748DE2FF5D9C873FF05D5CFE7")
    public void setExpandActivityOverflowButtonContentDescription(int resourceId) {
        CharSequence contentDescription;
        contentDescription = mContext.getString(resourceId);
        mExpandActivityOverflowButtonImage.setContentDescription(contentDescription);
        addTaint(resourceId);
        // ---------- Original Method ----------
        //CharSequence contentDescription = mContext.getString(resourceId);
        //mExpandActivityOverflowButtonImage.setContentDescription(contentDescription);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.981 -0400", hash_original_method = "4EB99ACA5BA34A284707803087697EF8", hash_generated_method = "BB5F635A8854257C75F3E39227EB8F20")
    public void setProvider(ActionProvider provider) {
        mProvider = provider;
        // ---------- Original Method ----------
        //mProvider = provider;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.982 -0400", hash_original_method = "D9F80F56BE7AEC83902DD1E82500AB90", hash_generated_method = "36161FF62408EAD9D7E9CB5FDF9C8830")
    public boolean showPopup() {
        {
            boolean varC70DA951A66294B5F2823A0381F01D29_1035360828 = (isShowingPopup() || !mIsAttachedToWindow);
        } //End collapsed parenthetic
        mIsSelectingDefaultActivity = false;
        showPopupUnchecked(mInitialActivityCount);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1884367599 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1884367599;
        // ---------- Original Method ----------
        //if (isShowingPopup() || !mIsAttachedToWindow) {
            //return false;
        //}
        //mIsSelectingDefaultActivity = false;
        //showPopupUnchecked(mInitialActivityCount);
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.983 -0400", hash_original_method = "3AECC6260DA21BAD7E8B15E74C7BA72C", hash_generated_method = "5A42212D3B89310670E48095BD2EDF47")
    private void showPopupUnchecked(int maxActivityCount) {
        {
            boolean varD8A7F383AAD10EDB59F860F56C2DD1E1_324997844 = (mAdapter.getDataModel() == null);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("No data model. Did you call #setDataModel?");
            } //End block
        } //End collapsed parenthetic
        getViewTreeObserver().addOnGlobalLayoutListener(mOnGlobalLayoutListener);
        boolean defaultActivityButtonShown;
        defaultActivityButtonShown = mDefaultActivityButton.getVisibility() == VISIBLE;
        int activityCount;
        activityCount = mAdapter.getActivityCount();
        int maxActivityCountOffset;
        maxActivityCountOffset = 1;
        maxActivityCountOffset = 0;
        {
            mAdapter.setShowFooterView(true);
            mAdapter.setMaxActivityCount(maxActivityCount - 1);
        } //End block
        {
            mAdapter.setShowFooterView(false);
            mAdapter.setMaxActivityCount(maxActivityCount);
        } //End block
        ListPopupWindow popupWindow;
        popupWindow = getListPopupWindow();
        {
            boolean varAAFF79C36ECCA2A466D0EE20078CA5AC_881939409 = (!popupWindow.isShowing());
            {
                {
                    mAdapter.setShowDefaultActivity(true, defaultActivityButtonShown);
                } //End block
                {
                    mAdapter.setShowDefaultActivity(false, false);
                } //End block
                int contentWidth;
                contentWidth = Math.min(mAdapter.measureContentWidth(), mListPopupMaxWidth);
                popupWindow.setContentWidth(contentWidth);
                popupWindow.show();
                {
                    mProvider.subUiVisibilityChanged(true);
                } //End block
                popupWindow.getListView().setContentDescription(mContext.getString(
                    R.string.activitychooserview_choose_application));
            } //End block
        } //End collapsed parenthetic
        addTaint(maxActivityCount);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.993 -0400", hash_original_method = "D685C2FA386E3559D94DAB46E30EF0B9", hash_generated_method = "3633F2087DCE6BEC9A771BD9A01CA363")
    public boolean dismissPopup() {
        {
            boolean varA195EA33C31D5F7626FCB680335C6A1C_1225752619 = (isShowingPopup());
            {
                getListPopupWindow().dismiss();
                ViewTreeObserver viewTreeObserver;
                viewTreeObserver = getViewTreeObserver();
                {
                    boolean varDA870088D05313F0375DA9DC21C38FAD_1169911923 = (viewTreeObserver.isAlive());
                    {
                        viewTreeObserver.removeGlobalOnLayoutListener(mOnGlobalLayoutListener);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1409557975 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1409557975;
        // ---------- Original Method ----------
        //if (isShowingPopup()) {
            //getListPopupWindow().dismiss();
            //ViewTreeObserver viewTreeObserver = getViewTreeObserver();
            //if (viewTreeObserver.isAlive()) {
                //viewTreeObserver.removeGlobalOnLayoutListener(mOnGlobalLayoutListener);
            //}
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.993 -0400", hash_original_method = "E45D6D96430861522854D560F5CA6F0B", hash_generated_method = "9E93746185500FCE87C37F5C3EA600B2")
    public boolean isShowingPopup() {
        boolean var2C1ED328370BD07F3FFCA303C77D80C8_655294082 = (getListPopupWindow().isShowing());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1709227179 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1709227179;
        // ---------- Original Method ----------
        //return getListPopupWindow().isShowing();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.994 -0400", hash_original_method = "F599B3D6D046BF4212D64A5D6A7F3811", hash_generated_method = "33E5E8AF8644225FE310C58F9AE059E5")
    @Override
    protected void onAttachedToWindow() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onAttachedToWindow();
        ActivityChooserModel dataModel;
        dataModel = mAdapter.getDataModel();
        {
            dataModel.registerObserver(mModelDataSetOberver);
        } //End block
        mIsAttachedToWindow = true;
        // ---------- Original Method ----------
        //super.onAttachedToWindow();
        //ActivityChooserModel dataModel = mAdapter.getDataModel();
        //if (dataModel != null) {
            //dataModel.registerObserver(mModelDataSetOberver);
        //}
        //mIsAttachedToWindow = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.994 -0400", hash_original_method = "589218240FC22193C94953AC6574E4EA", hash_generated_method = "32B4EB98FB05231907F0A7920D0DB5DC")
    @Override
    protected void onDetachedFromWindow() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onDetachedFromWindow();
        ActivityChooserModel dataModel;
        dataModel = mAdapter.getDataModel();
        {
            dataModel.unregisterObserver(mModelDataSetOberver);
        } //End block
        ViewTreeObserver viewTreeObserver;
        viewTreeObserver = getViewTreeObserver();
        {
            boolean var857E944F9C56602391F5DE64EA1D02FD_1772696577 = (viewTreeObserver.isAlive());
            {
                viewTreeObserver.removeGlobalOnLayoutListener(mOnGlobalLayoutListener);
            } //End block
        } //End collapsed parenthetic
        mIsAttachedToWindow = false;
        // ---------- Original Method ----------
        //super.onDetachedFromWindow();
        //ActivityChooserModel dataModel = mAdapter.getDataModel();
        //if (dataModel != null) {
            //dataModel.unregisterObserver(mModelDataSetOberver);
        //}
        //ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        //if (viewTreeObserver.isAlive()) {
            //viewTreeObserver.removeGlobalOnLayoutListener(mOnGlobalLayoutListener);
        //}
        //mIsAttachedToWindow = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:02.995 -0400", hash_original_method = "77C33EEC897BED8B2A12DF2072C37646", hash_generated_method = "147E6BFBF1CD133E435BEC56EC2C7BBF")
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        View child;
        child = mActivityChooserContent;
        {
            boolean varE1A734960699BCC84BF18F8452B15DCC_1219190909 = (mDefaultActivityButton.getVisibility() != VISIBLE);
            {
                heightMeasureSpec = MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(heightMeasureSpec),
                    MeasureSpec.EXACTLY);
            } //End block
        } //End collapsed parenthetic
        measureChild(child, widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(child.getMeasuredWidth(), child.getMeasuredHeight());
        addTaint(widthMeasureSpec);
        addTaint(heightMeasureSpec);
        // ---------- Original Method ----------
        //View child = mActivityChooserContent;
        //if (mDefaultActivityButton.getVisibility() != VISIBLE) {
            //heightMeasureSpec = MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(heightMeasureSpec),
                    //MeasureSpec.EXACTLY);
        //}
        //measureChild(child, widthMeasureSpec, heightMeasureSpec);
        //setMeasuredDimension(child.getMeasuredWidth(), child.getMeasuredHeight());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:03.006 -0400", hash_original_method = "C5A31C6F2FD14D87574B0913D4F6A2F2", hash_generated_method = "464CD770B21A529D0E6C8BCA6E926BBB")
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mActivityChooserContent.layout(0, 0, right - left, bottom - top);
        {
            boolean var8A3CF4F8772E9C29621A3DC4C81C93B9_188652259 = (getListPopupWindow().isShowing());
            {
                showPopupUnchecked(mAdapter.getMaxActivityCount());
            } //End block
            {
                dismissPopup();
            } //End block
        } //End collapsed parenthetic
        addTaint(changed);
        addTaint(left);
        addTaint(top);
        addTaint(right);
        addTaint(bottom);
        // ---------- Original Method ----------
        //mActivityChooserContent.layout(0, 0, right - left, bottom - top);
        //if (getListPopupWindow().isShowing()) {
            //showPopupUnchecked(mAdapter.getMaxActivityCount());
        //} else {
            //dismissPopup();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:03.006 -0400", hash_original_method = "5EF19A4E1889AB1FC4A984C090B7713C", hash_generated_method = "DF2B61585CD5DC7D0727C291B7A47552")
    public ActivityChooserModel getDataModel() {
        ActivityChooserModel varB4EAC82CA7396A68D541C85D26508E83_577648326 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_577648326 = mAdapter.getDataModel();
        varB4EAC82CA7396A68D541C85D26508E83_577648326.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_577648326;
        // ---------- Original Method ----------
        //return mAdapter.getDataModel();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:03.007 -0400", hash_original_method = "3D692CC2129791FB098BE485AC739689", hash_generated_method = "AFEDE7910A1B37993DCCD6535D2798FB")
    public void setOnDismissListener(PopupWindow.OnDismissListener listener) {
        mOnDismissListener = listener;
        // ---------- Original Method ----------
        //mOnDismissListener = listener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:03.007 -0400", hash_original_method = "861F24EC23ECA4CA4EF104A377B2D34D", hash_generated_method = "706332B7EEAD1AE51173D975872ABB45")
    public void setInitialActivityCount(int itemCount) {
        mInitialActivityCount = itemCount;
        // ---------- Original Method ----------
        //mInitialActivityCount = itemCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:03.007 -0400", hash_original_method = "A16FFC5DB1EC302B931A83E3D5524FB1", hash_generated_method = "3AA11D7A925E1612E7FB383801FF727D")
    public void setDefaultActionButtonContentDescription(int resourceId) {
        mDefaultActionButtonContentDescription = resourceId;
        // ---------- Original Method ----------
        //mDefaultActionButtonContentDescription = resourceId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:03.013 -0400", hash_original_method = "A13663EF62899FD593D247A6177CE71D", hash_generated_method = "E31DB53101245C41937A2E5C4E478680")
    private ListPopupWindow getListPopupWindow() {
        ListPopupWindow varB4EAC82CA7396A68D541C85D26508E83_872527148 = null; //Variable for return #1
        {
            mListPopupWindow = new ListPopupWindow(getContext());
            mListPopupWindow.setAdapter(mAdapter);
            mListPopupWindow.setAnchorView(ActivityChooserView.this);
            mListPopupWindow.setModal(true);
            mListPopupWindow.setOnItemClickListener(mCallbacks);
            mListPopupWindow.setOnDismissListener(mCallbacks);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_872527148 = mListPopupWindow;
        varB4EAC82CA7396A68D541C85D26508E83_872527148.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_872527148;
        // ---------- Original Method ----------
        //if (mListPopupWindow == null) {
            //mListPopupWindow = new ListPopupWindow(getContext());
            //mListPopupWindow.setAdapter(mAdapter);
            //mListPopupWindow.setAnchorView(ActivityChooserView.this);
            //mListPopupWindow.setModal(true);
            //mListPopupWindow.setOnItemClickListener(mCallbacks);
            //mListPopupWindow.setOnDismissListener(mCallbacks);
        //}
        //return mListPopupWindow;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:03.025 -0400", hash_original_method = "D65ED5C5B81BB78866247BEAE65AB728", hash_generated_method = "EDEC8D028735E1A2BFD70DF90B2C22D7")
    private void updateAppearance() {
        {
            boolean var4FF3551BFBD674C949BD8CC224028345_2045164873 = (mAdapter.getCount() > 0);
            {
                mExpandActivityOverflowButton.setEnabled(true);
            } //End block
            {
                mExpandActivityOverflowButton.setEnabled(false);
            } //End block
        } //End collapsed parenthetic
        int activityCount;
        activityCount = mAdapter.getActivityCount();
        int historySize;
        historySize = mAdapter.getHistorySize();
        {
            mDefaultActivityButton.setVisibility(VISIBLE);
            ResolveInfo activity;
            activity = mAdapter.getDefaultActivity();
            PackageManager packageManager;
            packageManager = mContext.getPackageManager();
            mDefaultActivityButtonImage.setImageDrawable(activity.loadIcon(packageManager));
            {
                CharSequence label;
                label = activity.loadLabel(packageManager);
                String contentDescription;
                contentDescription = mContext.getString(
                        mDefaultActionButtonContentDescription, label);
                mDefaultActivityButton.setContentDescription(contentDescription);
            } //End block
        } //End block
        {
            mDefaultActivityButton.setVisibility(View.GONE);
        } //End block
        {
            boolean var001BAB457545B2C4C96637DE43FA9E70_160683736 = (mDefaultActivityButton.getVisibility() == VISIBLE);
            {
                mActivityChooserContent.setBackgroundDrawable(mActivityChooserContentBackground);
            } //End block
            {
                mActivityChooserContent.setBackgroundDrawable(null);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    private class Callbacks implements AdapterView.OnItemClickListener, View.OnClickListener, View.OnLongClickListener, PopupWindow.OnDismissListener {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:03.025 -0400", hash_original_method = "BBA4719757F5E3331C7832D116B199C8", hash_generated_method = "BBA4719757F5E3331C7832D116B199C8")
        public Callbacks ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:03.026 -0400", hash_original_method = "674D57987B8C667CB3D7FFB12FCDD905", hash_generated_method = "B9E4E3000AE02426A6FF6AA3BD967BE2")
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            ActivityChooserViewAdapter adapter;
            adapter = (ActivityChooserViewAdapter) parent.getAdapter();
            int itemViewType;
            itemViewType = adapter.getItemViewType(position);
            //Begin case ActivityChooserViewAdapter.ITEM_VIEW_TYPE_FOOTER 
            {
                showPopupUnchecked(ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            } //End block
            //End case ActivityChooserViewAdapter.ITEM_VIEW_TYPE_FOOTER 
            //Begin case ActivityChooserViewAdapter.ITEM_VIEW_TYPE_ACTIVITY 
            {
                dismissPopup();
                {
                    {
                        mAdapter.getDataModel().setDefaultActivity(position);
                    } //End block
                } //End block
                {
                    position = mAdapter.getShowDefaultActivity() ? position : position + 1;
                    Intent launchIntent;
                    launchIntent = mAdapter.getDataModel().chooseActivity(position);
                    {
                        mContext.startActivity(launchIntent);
                    } //End block
                } //End block
            } //End block
            //End case ActivityChooserViewAdapter.ITEM_VIEW_TYPE_ACTIVITY 
            //Begin case default 
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
            //End case default 
            addTaint(parent.getTaint());
            addTaint(view.getTaint());
            addTaint(position);
            addTaint(id);
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:03.027 -0400", hash_original_method = "B05554F780928527AD52A76E48C9B5FF", hash_generated_method = "AEADF5F99E16DF64C1015662E020B20E")
        public void onClick(View view) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            {
                dismissPopup();
                ResolveInfo defaultActivity;
                defaultActivity = mAdapter.getDefaultActivity();
                int index;
                index = mAdapter.getDataModel().getActivityIndex(defaultActivity);
                Intent launchIntent;
                launchIntent = mAdapter.getDataModel().chooseActivity(index);
                {
                    mContext.startActivity(launchIntent);
                } //End block
            } //End block
            {
                mIsSelectingDefaultActivity = false;
                showPopupUnchecked(mInitialActivityCount);
            } //End block
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
            } //End block
            addTaint(view.getTaint());
            // ---------- Original Method ----------
            //if (view == mDefaultActivityButton) {
                //dismissPopup();
                //ResolveInfo defaultActivity = mAdapter.getDefaultActivity();
                //final int index = mAdapter.getDataModel().getActivityIndex(defaultActivity);
                //Intent launchIntent = mAdapter.getDataModel().chooseActivity(index);
                //if (launchIntent != null) {
                    //mContext.startActivity(launchIntent);
                //}
            //} else if (view == mExpandActivityOverflowButton) {
                //mIsSelectingDefaultActivity = false;
                //showPopupUnchecked(mInitialActivityCount);
            //} else {
                //throw new IllegalArgumentException();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:03.028 -0400", hash_original_method = "FB2F3C2103372446E9D5711FBCAD6598", hash_generated_method = "48B0F099C7F2D4188BA4B880748621C5")
        @Override
        public boolean onLongClick(View view) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            {
                {
                    boolean varCB03AE2B5AD76B1EBB5A332DEE95D3A2_1553513272 = (mAdapter.getCount() > 0);
                    {
                        mIsSelectingDefaultActivity = true;
                        showPopupUnchecked(mInitialActivityCount);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
            } //End block
            addTaint(view.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_213176027 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_213176027;
            // ---------- Original Method ----------
            //if (view == mDefaultActivityButton) {
                //if (mAdapter.getCount() > 0) {
                    //mIsSelectingDefaultActivity = true;
                    //showPopupUnchecked(mInitialActivityCount);
                //}
            //} else {
                //throw new IllegalArgumentException();
            //}
            //return true;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:03.044 -0400", hash_original_method = "D25064A646F02B95A775BA0461A79BFD", hash_generated_method = "BE9243D05A487682CD6DC7A8F0FEFA81")
        public void onDismiss() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            notifyOnDismissListener();
            {
                mProvider.subUiVisibilityChanged(false);
            } //End block
            // ---------- Original Method ----------
            //notifyOnDismissListener();
            //if (mProvider != null) {
                //mProvider.subUiVisibilityChanged(false);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:03.044 -0400", hash_original_method = "5021FB127D2DB881B8B1C45B5E11E195", hash_generated_method = "430B7D86C4A6C26C67649C07E3329E29")
        private void notifyOnDismissListener() {
            {
                mOnDismissListener.onDismiss();
            } //End block
            // ---------- Original Method ----------
            //if (mOnDismissListener != null) {
                //mOnDismissListener.onDismiss();
            //}
        }

        
    }


    
    private class ActivityChooserViewAdapter extends BaseAdapter {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:03.045 -0400", hash_original_field = "50A2FAD5E06F7194FA7769A1A3E62D87", hash_generated_field = "4B23A60A5EE2A01D93FA935950453A89")

        private ActivityChooserModel mDataModel;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:03.045 -0400", hash_original_field = "B987B83C5177B9AFB697E37A66BDA301", hash_generated_field = "7E27524CCC6935FAB8F88BAF1C6AE0A3")

        private int mMaxActivityCount = MAX_ACTIVITY_COUNT_DEFAULT;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:03.144 -0400", hash_original_field = "87ABBEC987619D585AA0E13F787A82A2", hash_generated_field = "E8EE97CA68AAFA64A18B7D487730ED89")

        private boolean mShowDefaultActivity;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:03.144 -0400", hash_original_field = "713E85B0BB0A9AB65769E7BDFA193547", hash_generated_field = "F496D5B1359B104FF475E03332F1A6A6")

        private boolean mHighlightDefaultActivity;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:03.144 -0400", hash_original_field = "5443D153EDC335581CB5CD2DE0645B49", hash_generated_field = "41BD5170A6AC3F68C312DE8FD93FC32C")

        private boolean mShowFooterView;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:03.144 -0400", hash_original_method = "BA43971C492C1B02A22C4BF340770F66", hash_generated_method = "BA43971C492C1B02A22C4BF340770F66")
        public ActivityChooserViewAdapter ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:03.145 -0400", hash_original_method = "ACCCD73AF35EBCB0E150696E3946651D", hash_generated_method = "1884DE7FA4EBB0198D1C5BF8A34A6E3F")
        public void setDataModel(ActivityChooserModel dataModel) {
            ActivityChooserModel oldDataModel;
            oldDataModel = mAdapter.getDataModel();
            {
                boolean var202863922DDD2F04977721BC536BA503_198489488 = (oldDataModel != null && isShown());
                {
                    oldDataModel.unregisterObserver(mModelDataSetOberver);
                } //End block
            } //End collapsed parenthetic
            mDataModel = dataModel;
            {
                boolean varCD1604D23D5ECAA0D5AF59F7BBDE1B9B_1097610822 = (dataModel != null && isShown());
                {
                    dataModel.registerObserver(mModelDataSetOberver);
                } //End block
            } //End collapsed parenthetic
            notifyDataSetChanged();
            // ---------- Original Method ----------
            //ActivityChooserModel oldDataModel = mAdapter.getDataModel();
            //if (oldDataModel != null && isShown()) {
                //oldDataModel.unregisterObserver(mModelDataSetOberver);
            //}
            //mDataModel = dataModel;
            //if (dataModel != null && isShown()) {
                //dataModel.registerObserver(mModelDataSetOberver);
            //}
            //notifyDataSetChanged();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:03.145 -0400", hash_original_method = "39EE4EFF86EDF87DA80E694DA09810EF", hash_generated_method = "29A9ED5316B6611EE4320CB3CC992E8B")
        @Override
        public int getItemViewType(int position) {
            {
                boolean var981C79D919698375E2C4BE7F06692C65_645231149 = (mShowFooterView && position == getCount() - 1);
            } //End collapsed parenthetic
            addTaint(position);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_964749491 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_964749491;
            // ---------- Original Method ----------
            //if (mShowFooterView && position == getCount() - 1) {
                //return ITEM_VIEW_TYPE_FOOTER;
            //} else {
                //return ITEM_VIEW_TYPE_ACTIVITY;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:03.146 -0400", hash_original_method = "A69A431394F21E5FD61198963B3D5202", hash_generated_method = "9F7DF6C89DC1FE4E10C30B5EE5BEF3C1")
        @Override
        public int getViewTypeCount() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1416642700 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1416642700;
            // ---------- Original Method ----------
            //return ITEM_VIEW_TYPE_COUNT;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:03.146 -0400", hash_original_method = "1BE11BD9F55247D049566CF39D6E3C60", hash_generated_method = "12324A1B6113D6F2A81FCC873035ABA3")
        public int getCount() {
            int count;
            count = 0;
            int activityCount;
            activityCount = mDataModel.getActivityCount();
            {
                boolean varF814B9BEDBAA3CF9D359B9B0AECA89BE_1601682017 = (!mShowDefaultActivity && mDataModel.getDefaultActivity() != null);
            } //End collapsed parenthetic
            count = Math.min(activityCount, mMaxActivityCount);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_816907196 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_816907196;
            // ---------- Original Method ----------
            //int count = 0;
            //int activityCount = mDataModel.getActivityCount();
            //if (!mShowDefaultActivity && mDataModel.getDefaultActivity() != null) {
                //activityCount--;
            //}
            //count = Math.min(activityCount, mMaxActivityCount);
            //if (mShowFooterView) {
                //count++;
            //}
            //return count;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:03.147 -0400", hash_original_method = "F3D4BDC985376DF5677372C13824236A", hash_generated_method = "85A8FABBCAD7B988A13AB746C615AE1E")
        public Object getItem(int position) {
            Object varB4EAC82CA7396A68D541C85D26508E83_1458277621 = null; //Variable for return #1
            Object varB4EAC82CA7396A68D541C85D26508E83_947753195 = null; //Variable for return #2
            int itemViewType;
            itemViewType = getItemViewType(position);
            //Begin case ITEM_VIEW_TYPE_FOOTER 
            varB4EAC82CA7396A68D541C85D26508E83_1458277621 = null;
            //End case ITEM_VIEW_TYPE_FOOTER 
            //Begin case ITEM_VIEW_TYPE_ACTIVITY 
            {
                boolean varF814B9BEDBAA3CF9D359B9B0AECA89BE_2049887822 = (!mShowDefaultActivity && mDataModel.getDefaultActivity() != null);
            } //End collapsed parenthetic
            //End case ITEM_VIEW_TYPE_ACTIVITY 
            //Begin case ITEM_VIEW_TYPE_ACTIVITY 
            varB4EAC82CA7396A68D541C85D26508E83_947753195 = mDataModel.getActivity(position);
            //End case ITEM_VIEW_TYPE_ACTIVITY 
            //Begin case default 
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
            //End case default 
            addTaint(position);
            Object varA7E53CE21691AB073D9660D615818899_899549937; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_899549937 = varB4EAC82CA7396A68D541C85D26508E83_1458277621;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_899549937 = varB4EAC82CA7396A68D541C85D26508E83_947753195;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_899549937.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_899549937;
            // ---------- Original Method ----------
            //final int itemViewType = getItemViewType(position);
            //switch (itemViewType) {
                //case ITEM_VIEW_TYPE_FOOTER:
                    //return null;
                //case ITEM_VIEW_TYPE_ACTIVITY:
                    //if (!mShowDefaultActivity && mDataModel.getDefaultActivity() != null) {
                        //position++;
                    //}
                    //return mDataModel.getActivity(position);
                //default:
                    //throw new IllegalArgumentException();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:03.147 -0400", hash_original_method = "7144EF990F660E75AA61001CF21A1CD5", hash_generated_method = "DAE8310C9ABB33D74A153A1CF9918F77")
        public long getItemId(int position) {
            addTaint(position);
            long var0F5264038205EDFB1AC05FBB0E8C5E94_647586082 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_647586082;
            // ---------- Original Method ----------
            //return position;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:03.173 -0400", hash_original_method = "6D38E6A963432D636038206F8FE6305D", hash_generated_method = "9CE4C3EE27DC4C3CD8F638F8DAC3F2D5")
        public View getView(int position, View convertView, ViewGroup parent) {
            View varB4EAC82CA7396A68D541C85D26508E83_1000059182 = null; //Variable for return #1
            View varB4EAC82CA7396A68D541C85D26508E83_291503339 = null; //Variable for return #2
            int itemViewType;
            itemViewType = getItemViewType(position);
            //Begin case ITEM_VIEW_TYPE_FOOTER 
            {
                boolean var6FC33BA0650785760E5F5779267DB862_391393389 = (convertView == null || convertView.getId() != ITEM_VIEW_TYPE_FOOTER);
                {
                    convertView = LayoutInflater.from(getContext()).inflate(
                                R.layout.activity_chooser_view_list_item, parent, false);
                    convertView.setId(ITEM_VIEW_TYPE_FOOTER);
                    TextView titleView;
                    titleView = (TextView) convertView.findViewById(R.id.title);
                    titleView.setText(mContext.getString(
                                R.string.activity_chooser_view_see_all));
                } //End block
            } //End collapsed parenthetic
            //End case ITEM_VIEW_TYPE_FOOTER 
            //Begin case ITEM_VIEW_TYPE_FOOTER 
            varB4EAC82CA7396A68D541C85D26508E83_1000059182 = convertView;
            //End case ITEM_VIEW_TYPE_FOOTER 
            //Begin case ITEM_VIEW_TYPE_ACTIVITY 
            {
                boolean var942A79868098ABCA25E80E95C3590B75_714369867 = (convertView == null || convertView.getId() != R.id.list_item);
                {
                    convertView = LayoutInflater.from(getContext()).inflate(
                                R.layout.activity_chooser_view_list_item, parent, false);
                } //End block
            } //End collapsed parenthetic
            //End case ITEM_VIEW_TYPE_ACTIVITY 
            //Begin case ITEM_VIEW_TYPE_ACTIVITY 
            PackageManager packageManager;
            packageManager = mContext.getPackageManager();
            //End case ITEM_VIEW_TYPE_ACTIVITY 
            //Begin case ITEM_VIEW_TYPE_ACTIVITY 
            ImageView iconView;
            iconView = (ImageView) convertView.findViewById(R.id.icon);
            //End case ITEM_VIEW_TYPE_ACTIVITY 
            //Begin case ITEM_VIEW_TYPE_ACTIVITY 
            ResolveInfo activity;
            activity = (ResolveInfo) getItem(position);
            //End case ITEM_VIEW_TYPE_ACTIVITY 
            //Begin case ITEM_VIEW_TYPE_ACTIVITY 
            iconView.setImageDrawable(activity.loadIcon(packageManager));
            //End case ITEM_VIEW_TYPE_ACTIVITY 
            //Begin case ITEM_VIEW_TYPE_ACTIVITY 
            TextView titleView;
            titleView = (TextView) convertView.findViewById(R.id.title);
            //End case ITEM_VIEW_TYPE_ACTIVITY 
            //Begin case ITEM_VIEW_TYPE_ACTIVITY 
            titleView.setText(activity.loadLabel(packageManager));
            //End case ITEM_VIEW_TYPE_ACTIVITY 
            //Begin case ITEM_VIEW_TYPE_ACTIVITY 
            {
                convertView.setActivated(true);
            } //End block
            {
                convertView.setActivated(false);
            } //End block
            //End case ITEM_VIEW_TYPE_ACTIVITY 
            //Begin case ITEM_VIEW_TYPE_ACTIVITY 
            varB4EAC82CA7396A68D541C85D26508E83_291503339 = convertView;
            //End case ITEM_VIEW_TYPE_ACTIVITY 
            //Begin case default 
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
            //End case default 
            addTaint(position);
            addTaint(convertView.getTaint());
            addTaint(parent.getTaint());
            View varA7E53CE21691AB073D9660D615818899_676154150; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_676154150 = varB4EAC82CA7396A68D541C85D26508E83_1000059182;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_676154150 = varB4EAC82CA7396A68D541C85D26508E83_291503339;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_676154150.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_676154150;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:03.174 -0400", hash_original_method = "E7848C130F305A2BB53DDDF9782AAF0B", hash_generated_method = "DF7C95BE3753FE2C8FCD9914BEF60205")
        public int measureContentWidth() {
            int oldMaxActivityCount;
            oldMaxActivityCount = mMaxActivityCount;
            mMaxActivityCount = MAX_ACTIVITY_COUNT_UNLIMITED;
            int contentWidth;
            contentWidth = 0;
            View itemView;
            itemView = null;
            int widthMeasureSpec;
            widthMeasureSpec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
            int heightMeasureSpec;
            heightMeasureSpec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
            int count;
            count = getCount();
            {
                int i;
                i = 0;
                {
                    itemView = getView(i, itemView, null);
                    itemView.measure(widthMeasureSpec, heightMeasureSpec);
                    contentWidth = Math.max(contentWidth, itemView.getMeasuredWidth());
                } //End block
            } //End collapsed parenthetic
            mMaxActivityCount = oldMaxActivityCount;
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1536306070 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1536306070;
            // ---------- Original Method ----------
            //final int oldMaxActivityCount = mMaxActivityCount;
            //mMaxActivityCount = MAX_ACTIVITY_COUNT_UNLIMITED;
            //int contentWidth = 0;
            //View itemView = null;
            //final int widthMeasureSpec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
            //final int heightMeasureSpec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
            //final int count = getCount();
            //for (int i = 0; i < count; i++) {
                //itemView = getView(i, itemView, null);
                //itemView.measure(widthMeasureSpec, heightMeasureSpec);
                //contentWidth = Math.max(contentWidth, itemView.getMeasuredWidth());
            //}
            //mMaxActivityCount = oldMaxActivityCount;
            //return contentWidth;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:03.196 -0400", hash_original_method = "EE079429AB45DD891FDFB8F4CAB39411", hash_generated_method = "2BE62C7C87B43BA54EC6967E04C743C6")
        public void setMaxActivityCount(int maxActivityCount) {
            {
                mMaxActivityCount = maxActivityCount;
                notifyDataSetChanged();
            } //End block
            // ---------- Original Method ----------
            //if (mMaxActivityCount != maxActivityCount) {
                //mMaxActivityCount = maxActivityCount;
                //notifyDataSetChanged();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:03.197 -0400", hash_original_method = "D919FDFCC3B420966F5D4C74A721F1BF", hash_generated_method = "88E7A78EE85C73B434F7A03226C3AB35")
        public ResolveInfo getDefaultActivity() {
            ResolveInfo varB4EAC82CA7396A68D541C85D26508E83_223191174 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_223191174 = mDataModel.getDefaultActivity();
            varB4EAC82CA7396A68D541C85D26508E83_223191174.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_223191174;
            // ---------- Original Method ----------
            //return mDataModel.getDefaultActivity();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:03.197 -0400", hash_original_method = "4D9F28247FB57368F2D0E306E2284064", hash_generated_method = "5660AEF5BBE0DC5076DEE733A7C53808")
        public void setShowFooterView(boolean showFooterView) {
            {
                mShowFooterView = showFooterView;
                notifyDataSetChanged();
            } //End block
            // ---------- Original Method ----------
            //if (mShowFooterView != showFooterView) {
                //mShowFooterView = showFooterView;
                //notifyDataSetChanged();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:03.198 -0400", hash_original_method = "31736EA607A445202315EB7B50B5EA80", hash_generated_method = "DF736D203A3A0EA578C1E0DEC909D618")
        public int getActivityCount() {
            int var6460B5DBA03A343DD887FC92C951DF49_1525780610 = (mDataModel.getActivityCount());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1113054331 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1113054331;
            // ---------- Original Method ----------
            //return mDataModel.getActivityCount();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:03.198 -0400", hash_original_method = "1D0D91D46AAECCD7C2767CF25FDA64BD", hash_generated_method = "2351DD5032AB221A869650C67723D1C2")
        public int getHistorySize() {
            int var5136F899EC720A1DABAB34435B7D0CB9_1995954831 = (mDataModel.getHistorySize());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_116063798 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_116063798;
            // ---------- Original Method ----------
            //return mDataModel.getHistorySize();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:03.202 -0400", hash_original_method = "3E4531A24528D01DAB939C9C71B2C3DE", hash_generated_method = "C8AD612CE4CE25371A35C01282881415")
        public int getMaxActivityCount() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1907880444 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1907880444;
            // ---------- Original Method ----------
            //return mMaxActivityCount;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:03.215 -0400", hash_original_method = "5525C6AC91C9709046E305FD9A15863B", hash_generated_method = "4C8316561603FD4BB3CC761194B6A842")
        public ActivityChooserModel getDataModel() {
            ActivityChooserModel varB4EAC82CA7396A68D541C85D26508E83_1098811925 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1098811925 = mDataModel;
            varB4EAC82CA7396A68D541C85D26508E83_1098811925.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1098811925;
            // ---------- Original Method ----------
            //return mDataModel;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:03.216 -0400", hash_original_method = "A23AAFB309F0D7012150D94437C8B43A", hash_generated_method = "D1DC4082A4C9F45EA9989CD887CCE727")
        public void setShowDefaultActivity(boolean showDefaultActivity,
                boolean highlightDefaultActivity) {
            {
                mShowDefaultActivity = showDefaultActivity;
                mHighlightDefaultActivity = highlightDefaultActivity;
                notifyDataSetChanged();
            } //End block
            // ---------- Original Method ----------
            //if (mShowDefaultActivity != showDefaultActivity
                    //|| mHighlightDefaultActivity != highlightDefaultActivity) {
                //mShowDefaultActivity = showDefaultActivity;
                //mHighlightDefaultActivity = highlightDefaultActivity;
                //notifyDataSetChanged();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:03.216 -0400", hash_original_method = "1922E89BA39A7DE83F0D6E6EABDFE98E", hash_generated_method = "DEDC73DAB4DDF0CB85C5B64675898E3D")
        public boolean getShowDefaultActivity() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_988481214 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_988481214;
            // ---------- Original Method ----------
            //return mShowDefaultActivity;
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:03.216 -0400", hash_original_field = "3AB659CF2ABB2A30495C6541B674B4DA", hash_generated_field = "76769A97B1782495BC5DE9799BE9BD4F")

        public static final int MAX_ACTIVITY_COUNT_UNLIMITED = Integer.MAX_VALUE;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:03.216 -0400", hash_original_field = "9A948FBD83F151D7B6865F79C07B61CF", hash_generated_field = "A9C0946733D648F3335EA0A2B5A4F65D")

        public static final int MAX_ACTIVITY_COUNT_DEFAULT = 4;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:03.216 -0400", hash_original_field = "2D5337C89A2BBDBAB8089E3104D05A58", hash_generated_field = "C459273FE71EE68B9A7AB28341A695D8")

        private static int ITEM_VIEW_TYPE_ACTIVITY = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:03.216 -0400", hash_original_field = "56FBBE17487B87761CABEC4D515AA0BC", hash_generated_field = "E344EABD7672DC0698ABB726BF1B4C14")

        private static int ITEM_VIEW_TYPE_FOOTER = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:03.216 -0400", hash_original_field = "F174C44C46468510CCD8705E3812E20F", hash_generated_field = "1DF5707411095889941B6F6BDA3C2DB9")

        private static int ITEM_VIEW_TYPE_COUNT = 3;
    }


    
}

