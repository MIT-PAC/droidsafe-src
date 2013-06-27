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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.853 -0400", hash_original_field = "59E9F255F2F17EC006AE601269EA8540", hash_generated_field = "693752B4212B867133E03234F672DAB4")

    private ActivityChooserViewAdapter mAdapter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.853 -0400", hash_original_field = "8DA114DA2B33B0EF1622BD0EE0F06E2B", hash_generated_field = "56C5A3BFBAA3C4CF09CF9C52EF52DD5C")

    private Callbacks mCallbacks;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.853 -0400", hash_original_field = "3A69536EA31C68E25F67DFFEE1C9D802", hash_generated_field = "15A85E7B2533D5C1858324D4690F18CE")

    private LinearLayout mActivityChooserContent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.853 -0400", hash_original_field = "A9CA4B951FF3389FEF3B28EA7C067B20", hash_generated_field = "2CCC7C8CA771AD7217D2AFD6C98780B1")

    private Drawable mActivityChooserContentBackground;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.853 -0400", hash_original_field = "63F80721F41BFFB03287300AEFC9638A", hash_generated_field = "3CE55FDBD0D926D55E38007406C4DF14")

    private FrameLayout mExpandActivityOverflowButton;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.853 -0400", hash_original_field = "41D59DA363A972A70E89D7F097262996", hash_generated_field = "433B613895F9A9778E53C598D01BA2AB")

    private ImageView mExpandActivityOverflowButtonImage;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.853 -0400", hash_original_field = "DAD8AB330B8FE38CED27A92AB62A5E4D", hash_generated_field = "2804585A9E453E27976F3FDF1A270905")

    private FrameLayout mDefaultActivityButton;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.853 -0400", hash_original_field = "C2BD14F014164359D2DBF374E3941AF3", hash_generated_field = "A19ECBBBF75A40B339DC4A95C030E78B")

    private ImageView mDefaultActivityButtonImage;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.853 -0400", hash_original_field = "D19DDAF4856E35C2635D5FF15637EEE6", hash_generated_field = "6549412A83E8736AC71A3C4F42B2776F")

    private int mListPopupMaxWidth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.853 -0400", hash_original_field = "BD1D19BC6BC3803BE152A977D479AC49", hash_generated_field = "94389E96F8958E34938A4C66FB6778B1")

    ActionProvider mProvider;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.871 -0400", hash_original_field = "E2DFFEE4700584126C30F533416180E4", hash_generated_field = "301B5E254D3C0A8E5B25B8A880F9C31F")

    private DataSetObserver mModelDataSetOberver = new DataSetObserver() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.870 -0400", hash_original_method = "D32F752C027D2B93516AB0AF431CE07C", hash_generated_method = "D9FEC22D26AFC73436AFDEEE1426D33F")
        @Override
        public void onChanged() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            super.onChanged();
            mAdapter.notifyDataSetChanged();
            // ---------- Original Method ----------
            //super.onChanged();
            //mAdapter.notifyDataSetChanged();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.871 -0400", hash_original_method = "0D3B938F42D9BBAAA5442D3FB85ABED0", hash_generated_method = "339192657B2FC07CDF5B74397DFBCE1B")
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.871 -0400", hash_original_field = "5EF451EC8A0E03D344AD0776D0D040B4", hash_generated_field = "CE4902542A7135924DD2499381ED49B6")

    private OnGlobalLayoutListener mOnGlobalLayoutListener = new OnGlobalLayoutListener() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.871 -0400", hash_original_method = "B9295CF4AC3C2667F7355FBB8B3B9DC6", hash_generated_method = "9B6C555D559E92049EA4F0D1F744F035")
        @Override
        public void onGlobalLayout() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            {
                boolean var86D2C12CD473A200156C05DF07DBDDED_1735050667 = (isShowingPopup());
                {
                    {
                        boolean var87DC1C3C75E5DCFD494722F4CBC795CB_483508111 = (!isShown());
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.872 -0400", hash_original_field = "D37E69872D15BB8AD43DD3C6E77034A5", hash_generated_field = "B18FE4D2C1F5F5724780B69F0C631713")

    private ListPopupWindow mListPopupWindow;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.872 -0400", hash_original_field = "B6794399ABC229B6F5098657922184B3", hash_generated_field = "5A4179E23C1E43233D6280AC184F1638")

    private PopupWindow.OnDismissListener mOnDismissListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.872 -0400", hash_original_field = "5302A99A8C1C0F6305F7A9ECB4B77A94", hash_generated_field = "FB5A63E1FFE964D7D3DF45A85F8B7265")

    private boolean mIsSelectingDefaultActivity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.872 -0400", hash_original_field = "50E4F4B3AA4ACDAC2444FD64183E5704", hash_generated_field = "04519B5943EE67A9C7EEE82652B59883")

    private int mInitialActivityCount = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_DEFAULT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.872 -0400", hash_original_field = "1F925504346EA79D2090BC0874ADA0DB", hash_generated_field = "A725E70F25078818B1BC03DF5AE609A6")

    private boolean mIsAttachedToWindow;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.872 -0400", hash_original_field = "5C855F3EB880070F54099C89CF873EEB", hash_generated_field = "2EB4D3D3AA67879C726AB0ABB6BA9C6A")

    private int mDefaultActionButtonContentDescription;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.872 -0400", hash_original_method = "B1417C53B7334442AE372C957DCB8F0C", hash_generated_method = "86B03DA005E6640F9AA460F2B84E2F8E")
    public  ActivityChooserView(Context context) {
        this(context, null);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.872 -0400", hash_original_method = "5446B591236758FE1022AC56CCF4E7CA", hash_generated_method = "5B1DB93CEEE36B76CC66AE96F82716BF")
    public  ActivityChooserView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.891 -0400", hash_original_method = "82640F6029B5DED0016360DF13353C92", hash_generated_method = "99DC64978D8584F11A1921466E6907D9")
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
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.891 -0400", hash_original_method = "77B1463ED818B52DA8559320D8129DE8", hash_generated_method = "4823B6C5288EB5E4410B6C2B7971F9E9")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.895 -0400", hash_original_method = "200277448D26D5459B7D9186C5FC6866", hash_generated_method = "BEF3E95724D1B6AD6E1E585BB2BD5311")
    public void setActivityChooserModel(ActivityChooserModel dataModel) {
        mAdapter.setDataModel(dataModel);
        {
            boolean varA195EA33C31D5F7626FCB680335C6A1C_604975551 = (isShowingPopup());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.896 -0400", hash_original_method = "40C8CFBBBEC7CE8C6DC800BBA1A8260F", hash_generated_method = "66F73E3D03229CB3BCB71BBEDE7323C7")
    public void setExpandActivityOverflowButtonDrawable(Drawable drawable) {
        mExpandActivityOverflowButtonImage.setImageDrawable(drawable);
        addTaint(drawable.getTaint());
        // ---------- Original Method ----------
        //mExpandActivityOverflowButtonImage.setImageDrawable(drawable);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.896 -0400", hash_original_method = "0A5827A88A56386A8A69EC0550F49C43", hash_generated_method = "AEF9D39748DE2FF5D9C873FF05D5CFE7")
    public void setExpandActivityOverflowButtonContentDescription(int resourceId) {
        CharSequence contentDescription;
        contentDescription = mContext.getString(resourceId);
        mExpandActivityOverflowButtonImage.setContentDescription(contentDescription);
        addTaint(resourceId);
        // ---------- Original Method ----------
        //CharSequence contentDescription = mContext.getString(resourceId);
        //mExpandActivityOverflowButtonImage.setContentDescription(contentDescription);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.896 -0400", hash_original_method = "4EB99ACA5BA34A284707803087697EF8", hash_generated_method = "BB5F635A8854257C75F3E39227EB8F20")
    public void setProvider(ActionProvider provider) {
        mProvider = provider;
        // ---------- Original Method ----------
        //mProvider = provider;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.904 -0400", hash_original_method = "D9F80F56BE7AEC83902DD1E82500AB90", hash_generated_method = "38CB80F5CE0A8B584EDDFD3E073A2095")
    public boolean showPopup() {
        {
            boolean varC70DA951A66294B5F2823A0381F01D29_679173701 = (isShowingPopup() || !mIsAttachedToWindow);
        } //End collapsed parenthetic
        mIsSelectingDefaultActivity = false;
        showPopupUnchecked(mInitialActivityCount);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_222474696 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_222474696;
        // ---------- Original Method ----------
        //if (isShowingPopup() || !mIsAttachedToWindow) {
            //return false;
        //}
        //mIsSelectingDefaultActivity = false;
        //showPopupUnchecked(mInitialActivityCount);
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.928 -0400", hash_original_method = "3AECC6260DA21BAD7E8B15E74C7BA72C", hash_generated_method = "A47BA5E0DF2E2206762982923EFB2B9D")
    private void showPopupUnchecked(int maxActivityCount) {
        {
            boolean varD8A7F383AAD10EDB59F860F56C2DD1E1_588469726 = (mAdapter.getDataModel() == null);
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
            boolean varAAFF79C36ECCA2A466D0EE20078CA5AC_875052859 = (!popupWindow.isShowing());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.929 -0400", hash_original_method = "D685C2FA386E3559D94DAB46E30EF0B9", hash_generated_method = "8D20E17FA86B68D21FFA2129E11282C8")
    public boolean dismissPopup() {
        {
            boolean varA195EA33C31D5F7626FCB680335C6A1C_1936325208 = (isShowingPopup());
            {
                getListPopupWindow().dismiss();
                ViewTreeObserver viewTreeObserver;
                viewTreeObserver = getViewTreeObserver();
                {
                    boolean varDA870088D05313F0375DA9DC21C38FAD_283282506 = (viewTreeObserver.isAlive());
                    {
                        viewTreeObserver.removeGlobalOnLayoutListener(mOnGlobalLayoutListener);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1576168039 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1576168039;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.930 -0400", hash_original_method = "E45D6D96430861522854D560F5CA6F0B", hash_generated_method = "42CE973F0102E3093765EA8ABB446170")
    public boolean isShowingPopup() {
        boolean var2C1ED328370BD07F3FFCA303C77D80C8_1103063861 = (getListPopupWindow().isShowing());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1409819977 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1409819977;
        // ---------- Original Method ----------
        //return getListPopupWindow().isShowing();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.930 -0400", hash_original_method = "F599B3D6D046BF4212D64A5D6A7F3811", hash_generated_method = "33E5E8AF8644225FE310C58F9AE059E5")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.934 -0400", hash_original_method = "589218240FC22193C94953AC6574E4EA", hash_generated_method = "8CD65918DDF952A8CB0017B709505AA8")
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
            boolean var857E944F9C56602391F5DE64EA1D02FD_389671590 = (viewTreeObserver.isAlive());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.935 -0400", hash_original_method = "77C33EEC897BED8B2A12DF2072C37646", hash_generated_method = "ADFBA13B73B5ECCF58249BAFF3708DC0")
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        View child;
        child = mActivityChooserContent;
        {
            boolean varE1A734960699BCC84BF18F8452B15DCC_1612087635 = (mDefaultActivityButton.getVisibility() != VISIBLE);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.938 -0400", hash_original_method = "C5A31C6F2FD14D87574B0913D4F6A2F2", hash_generated_method = "C542A0847AF02B14A60FCE9CED7C4B42")
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mActivityChooserContent.layout(0, 0, right - left, bottom - top);
        {
            boolean var8A3CF4F8772E9C29621A3DC4C81C93B9_1638728567 = (getListPopupWindow().isShowing());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.939 -0400", hash_original_method = "5EF19A4E1889AB1FC4A984C090B7713C", hash_generated_method = "ECBA91C8FA3C48517B1823ABD9DBE05F")
    public ActivityChooserModel getDataModel() {
        ActivityChooserModel varB4EAC82CA7396A68D541C85D26508E83_3993650 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_3993650 = mAdapter.getDataModel();
        varB4EAC82CA7396A68D541C85D26508E83_3993650.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_3993650;
        // ---------- Original Method ----------
        //return mAdapter.getDataModel();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.939 -0400", hash_original_method = "3D692CC2129791FB098BE485AC739689", hash_generated_method = "AFEDE7910A1B37993DCCD6535D2798FB")
    public void setOnDismissListener(PopupWindow.OnDismissListener listener) {
        mOnDismissListener = listener;
        // ---------- Original Method ----------
        //mOnDismissListener = listener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.939 -0400", hash_original_method = "861F24EC23ECA4CA4EF104A377B2D34D", hash_generated_method = "706332B7EEAD1AE51173D975872ABB45")
    public void setInitialActivityCount(int itemCount) {
        mInitialActivityCount = itemCount;
        // ---------- Original Method ----------
        //mInitialActivityCount = itemCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.965 -0400", hash_original_method = "A16FFC5DB1EC302B931A83E3D5524FB1", hash_generated_method = "3AA11D7A925E1612E7FB383801FF727D")
    public void setDefaultActionButtonContentDescription(int resourceId) {
        mDefaultActionButtonContentDescription = resourceId;
        // ---------- Original Method ----------
        //mDefaultActionButtonContentDescription = resourceId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.965 -0400", hash_original_method = "A13663EF62899FD593D247A6177CE71D", hash_generated_method = "1732C12913520BD41F91E12B085580C9")
    private ListPopupWindow getListPopupWindow() {
        ListPopupWindow varB4EAC82CA7396A68D541C85D26508E83_1306530134 = null; //Variable for return #1
        {
            mListPopupWindow = new ListPopupWindow(getContext());
            mListPopupWindow.setAdapter(mAdapter);
            mListPopupWindow.setAnchorView(ActivityChooserView.this);
            mListPopupWindow.setModal(true);
            mListPopupWindow.setOnItemClickListener(mCallbacks);
            mListPopupWindow.setOnDismissListener(mCallbacks);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1306530134 = mListPopupWindow;
        varB4EAC82CA7396A68D541C85D26508E83_1306530134.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1306530134;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.966 -0400", hash_original_method = "D65ED5C5B81BB78866247BEAE65AB728", hash_generated_method = "428276EDE568FCFF45C1D35CC5EB3DCF")
    private void updateAppearance() {
        {
            boolean var4FF3551BFBD674C949BD8CC224028345_494144054 = (mAdapter.getCount() > 0);
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
            boolean var001BAB457545B2C4C96637DE43FA9E70_874960980 = (mDefaultActivityButton.getVisibility() == VISIBLE);
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.966 -0400", hash_original_method = "BBA4719757F5E3331C7832D116B199C8", hash_generated_method = "BBA4719757F5E3331C7832D116B199C8")
        public Callbacks ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.967 -0400", hash_original_method = "674D57987B8C667CB3D7FFB12FCDD905", hash_generated_method = "B9E4E3000AE02426A6FF6AA3BD967BE2")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.984 -0400", hash_original_method = "B05554F780928527AD52A76E48C9B5FF", hash_generated_method = "AEADF5F99E16DF64C1015662E020B20E")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.985 -0400", hash_original_method = "FB2F3C2103372446E9D5711FBCAD6598", hash_generated_method = "F35869FA5AAF88E1A87C6F42AB4DCE97")
        @Override
        public boolean onLongClick(View view) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            {
                {
                    boolean varCB03AE2B5AD76B1EBB5A332DEE95D3A2_1127760848 = (mAdapter.getCount() > 0);
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
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_419159506 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_419159506;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.985 -0400", hash_original_method = "D25064A646F02B95A775BA0461A79BFD", hash_generated_method = "BE9243D05A487682CD6DC7A8F0FEFA81")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.986 -0400", hash_original_method = "5021FB127D2DB881B8B1C45B5E11E195", hash_generated_method = "430B7D86C4A6C26C67649C07E3329E29")
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.986 -0400", hash_original_field = "50A2FAD5E06F7194FA7769A1A3E62D87", hash_generated_field = "4B23A60A5EE2A01D93FA935950453A89")

        private ActivityChooserModel mDataModel;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.986 -0400", hash_original_field = "B987B83C5177B9AFB697E37A66BDA301", hash_generated_field = "7E27524CCC6935FAB8F88BAF1C6AE0A3")

        private int mMaxActivityCount = MAX_ACTIVITY_COUNT_DEFAULT;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.986 -0400", hash_original_field = "87ABBEC987619D585AA0E13F787A82A2", hash_generated_field = "E8EE97CA68AAFA64A18B7D487730ED89")

        private boolean mShowDefaultActivity;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.986 -0400", hash_original_field = "713E85B0BB0A9AB65769E7BDFA193547", hash_generated_field = "F496D5B1359B104FF475E03332F1A6A6")

        private boolean mHighlightDefaultActivity;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.986 -0400", hash_original_field = "5443D153EDC335581CB5CD2DE0645B49", hash_generated_field = "41BD5170A6AC3F68C312DE8FD93FC32C")

        private boolean mShowFooterView;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.986 -0400", hash_original_method = "BA43971C492C1B02A22C4BF340770F66", hash_generated_method = "BA43971C492C1B02A22C4BF340770F66")
        public ActivityChooserViewAdapter ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.986 -0400", hash_original_method = "ACCCD73AF35EBCB0E150696E3946651D", hash_generated_method = "1AAFA323D5E69C42E22882C0DAB24358")
        public void setDataModel(ActivityChooserModel dataModel) {
            ActivityChooserModel oldDataModel;
            oldDataModel = mAdapter.getDataModel();
            {
                boolean var202863922DDD2F04977721BC536BA503_1499941620 = (oldDataModel != null && isShown());
                {
                    oldDataModel.unregisterObserver(mModelDataSetOberver);
                } //End block
            } //End collapsed parenthetic
            mDataModel = dataModel;
            {
                boolean varCD1604D23D5ECAA0D5AF59F7BBDE1B9B_1877924267 = (dataModel != null && isShown());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.987 -0400", hash_original_method = "39EE4EFF86EDF87DA80E694DA09810EF", hash_generated_method = "8B083B4D521934D8555865D8F71CE327")
        @Override
        public int getItemViewType(int position) {
            {
                boolean var981C79D919698375E2C4BE7F06692C65_334422409 = (mShowFooterView && position == getCount() - 1);
            } //End collapsed parenthetic
            addTaint(position);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1961984463 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1961984463;
            // ---------- Original Method ----------
            //if (mShowFooterView && position == getCount() - 1) {
                //return ITEM_VIEW_TYPE_FOOTER;
            //} else {
                //return ITEM_VIEW_TYPE_ACTIVITY;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.987 -0400", hash_original_method = "A69A431394F21E5FD61198963B3D5202", hash_generated_method = "515A5D22CE64C05FF20759A8E3ECFEE0")
        @Override
        public int getViewTypeCount() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1331728343 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1331728343;
            // ---------- Original Method ----------
            //return ITEM_VIEW_TYPE_COUNT;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.997 -0400", hash_original_method = "1BE11BD9F55247D049566CF39D6E3C60", hash_generated_method = "9009AD2106638FEC5FC2F91944FD7A5C")
        public int getCount() {
            int count;
            count = 0;
            int activityCount;
            activityCount = mDataModel.getActivityCount();
            {
                boolean varF814B9BEDBAA3CF9D359B9B0AECA89BE_467793520 = (!mShowDefaultActivity && mDataModel.getDefaultActivity() != null);
            } //End collapsed parenthetic
            count = Math.min(activityCount, mMaxActivityCount);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1263340054 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1263340054;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.998 -0400", hash_original_method = "F3D4BDC985376DF5677372C13824236A", hash_generated_method = "7893CD2FC26A71D8B25AEEC82BB97D4C")
        public Object getItem(int position) {
            Object varB4EAC82CA7396A68D541C85D26508E83_581581808 = null; //Variable for return #1
            Object varB4EAC82CA7396A68D541C85D26508E83_1818199475 = null; //Variable for return #2
            int itemViewType;
            itemViewType = getItemViewType(position);
            //Begin case ITEM_VIEW_TYPE_FOOTER 
            varB4EAC82CA7396A68D541C85D26508E83_581581808 = null;
            //End case ITEM_VIEW_TYPE_FOOTER 
            //Begin case ITEM_VIEW_TYPE_ACTIVITY 
            {
                boolean varF814B9BEDBAA3CF9D359B9B0AECA89BE_1150173250 = (!mShowDefaultActivity && mDataModel.getDefaultActivity() != null);
            } //End collapsed parenthetic
            //End case ITEM_VIEW_TYPE_ACTIVITY 
            //Begin case ITEM_VIEW_TYPE_ACTIVITY 
            varB4EAC82CA7396A68D541C85D26508E83_1818199475 = mDataModel.getActivity(position);
            //End case ITEM_VIEW_TYPE_ACTIVITY 
            //Begin case default 
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
            //End case default 
            addTaint(position);
            Object varA7E53CE21691AB073D9660D615818899_1118744628; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_1118744628 = varB4EAC82CA7396A68D541C85D26508E83_581581808;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1118744628 = varB4EAC82CA7396A68D541C85D26508E83_1818199475;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1118744628.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_1118744628;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:04.999 -0400", hash_original_method = "7144EF990F660E75AA61001CF21A1CD5", hash_generated_method = "F8578DC7CE35B6B30D9939DE506317FF")
        public long getItemId(int position) {
            addTaint(position);
            long var0F5264038205EDFB1AC05FBB0E8C5E94_255357124 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_255357124;
            // ---------- Original Method ----------
            //return position;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.020 -0400", hash_original_method = "6D38E6A963432D636038206F8FE6305D", hash_generated_method = "8B843A8A842E35EA734462365F5AB9F3")
        public View getView(int position, View convertView, ViewGroup parent) {
            View varB4EAC82CA7396A68D541C85D26508E83_625610833 = null; //Variable for return #1
            View varB4EAC82CA7396A68D541C85D26508E83_462965625 = null; //Variable for return #2
            int itemViewType;
            itemViewType = getItemViewType(position);
            //Begin case ITEM_VIEW_TYPE_FOOTER 
            {
                boolean var6FC33BA0650785760E5F5779267DB862_1083229260 = (convertView == null || convertView.getId() != ITEM_VIEW_TYPE_FOOTER);
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
            varB4EAC82CA7396A68D541C85D26508E83_625610833 = convertView;
            //End case ITEM_VIEW_TYPE_FOOTER 
            //Begin case ITEM_VIEW_TYPE_ACTIVITY 
            {
                boolean var942A79868098ABCA25E80E95C3590B75_486810619 = (convertView == null || convertView.getId() != R.id.list_item);
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
            varB4EAC82CA7396A68D541C85D26508E83_462965625 = convertView;
            //End case ITEM_VIEW_TYPE_ACTIVITY 
            //Begin case default 
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
            //End case default 
            addTaint(position);
            addTaint(convertView.getTaint());
            addTaint(parent.getTaint());
            View varA7E53CE21691AB073D9660D615818899_637500829; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_637500829 = varB4EAC82CA7396A68D541C85D26508E83_625610833;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_637500829 = varB4EAC82CA7396A68D541C85D26508E83_462965625;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_637500829.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_637500829;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.021 -0400", hash_original_method = "E7848C130F305A2BB53DDDF9782AAF0B", hash_generated_method = "78FC1C45E710CAE6F6EDA22FA5A2BDBB")
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
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1194369944 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1194369944;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.026 -0400", hash_original_method = "EE079429AB45DD891FDFB8F4CAB39411", hash_generated_method = "2BE62C7C87B43BA54EC6967E04C743C6")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.026 -0400", hash_original_method = "D919FDFCC3B420966F5D4C74A721F1BF", hash_generated_method = "8B240C6BB9DE3F73EAF7EC070C6D441B")
        public ResolveInfo getDefaultActivity() {
            ResolveInfo varB4EAC82CA7396A68D541C85D26508E83_18690250 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_18690250 = mDataModel.getDefaultActivity();
            varB4EAC82CA7396A68D541C85D26508E83_18690250.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_18690250;
            // ---------- Original Method ----------
            //return mDataModel.getDefaultActivity();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.027 -0400", hash_original_method = "4D9F28247FB57368F2D0E306E2284064", hash_generated_method = "5660AEF5BBE0DC5076DEE733A7C53808")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.027 -0400", hash_original_method = "31736EA607A445202315EB7B50B5EA80", hash_generated_method = "83CDF33C413C62C25BC568955698ADC9")
        public int getActivityCount() {
            int var6460B5DBA03A343DD887FC92C951DF49_1145988076 = (mDataModel.getActivityCount());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1727205742 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1727205742;
            // ---------- Original Method ----------
            //return mDataModel.getActivityCount();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.039 -0400", hash_original_method = "1D0D91D46AAECCD7C2767CF25FDA64BD", hash_generated_method = "6C790607E1A2A69D73421C55599E6104")
        public int getHistorySize() {
            int var5136F899EC720A1DABAB34435B7D0CB9_1857156165 = (mDataModel.getHistorySize());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1610440711 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1610440711;
            // ---------- Original Method ----------
            //return mDataModel.getHistorySize();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.039 -0400", hash_original_method = "3E4531A24528D01DAB939C9C71B2C3DE", hash_generated_method = "21A7B49A6ACB69ED0BCA59E90AEFAF05")
        public int getMaxActivityCount() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1679370040 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1679370040;
            // ---------- Original Method ----------
            //return mMaxActivityCount;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.040 -0400", hash_original_method = "5525C6AC91C9709046E305FD9A15863B", hash_generated_method = "B1280BBF93BB12C43E6CCB45117B1231")
        public ActivityChooserModel getDataModel() {
            ActivityChooserModel varB4EAC82CA7396A68D541C85D26508E83_2031714289 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_2031714289 = mDataModel;
            varB4EAC82CA7396A68D541C85D26508E83_2031714289.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2031714289;
            // ---------- Original Method ----------
            //return mDataModel;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.041 -0400", hash_original_method = "A23AAFB309F0D7012150D94437C8B43A", hash_generated_method = "D1DC4082A4C9F45EA9989CD887CCE727")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.041 -0400", hash_original_method = "1922E89BA39A7DE83F0D6E6EABDFE98E", hash_generated_method = "3323C102FAD37E2728A1DE407E12E7BD")
        public boolean getShowDefaultActivity() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_209137302 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_209137302;
            // ---------- Original Method ----------
            //return mShowDefaultActivity;
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.041 -0400", hash_original_field = "3AB659CF2ABB2A30495C6541B674B4DA", hash_generated_field = "76769A97B1782495BC5DE9799BE9BD4F")

        public static final int MAX_ACTIVITY_COUNT_UNLIMITED = Integer.MAX_VALUE;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.041 -0400", hash_original_field = "9A948FBD83F151D7B6865F79C07B61CF", hash_generated_field = "A9C0946733D648F3335EA0A2B5A4F65D")

        public static final int MAX_ACTIVITY_COUNT_DEFAULT = 4;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.041 -0400", hash_original_field = "2D5337C89A2BBDBAB8089E3104D05A58", hash_generated_field = "C459273FE71EE68B9A7AB28341A695D8")

        private static int ITEM_VIEW_TYPE_ACTIVITY = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.041 -0400", hash_original_field = "56FBBE17487B87761CABEC4D515AA0BC", hash_generated_field = "E344EABD7672DC0698ABB726BF1B4C14")

        private static int ITEM_VIEW_TYPE_FOOTER = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:05.041 -0400", hash_original_field = "F174C44C46468510CCD8705E3812E20F", hash_generated_field = "1DF5707411095889941B6F6BDA3C2DB9")

        private static int ITEM_VIEW_TYPE_COUNT = 3;
    }


    
}

