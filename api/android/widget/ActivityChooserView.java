package android.widget;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.133 -0400", hash_original_field = "59E9F255F2F17EC006AE601269EA8540", hash_generated_field = "693752B4212B867133E03234F672DAB4")

    private ActivityChooserViewAdapter mAdapter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.133 -0400", hash_original_field = "8DA114DA2B33B0EF1622BD0EE0F06E2B", hash_generated_field = "56C5A3BFBAA3C4CF09CF9C52EF52DD5C")

    private Callbacks mCallbacks;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.133 -0400", hash_original_field = "3A69536EA31C68E25F67DFFEE1C9D802", hash_generated_field = "15A85E7B2533D5C1858324D4690F18CE")

    private LinearLayout mActivityChooserContent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.133 -0400", hash_original_field = "A9CA4B951FF3389FEF3B28EA7C067B20", hash_generated_field = "2CCC7C8CA771AD7217D2AFD6C98780B1")

    private Drawable mActivityChooserContentBackground;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.133 -0400", hash_original_field = "63F80721F41BFFB03287300AEFC9638A", hash_generated_field = "3CE55FDBD0D926D55E38007406C4DF14")

    private FrameLayout mExpandActivityOverflowButton;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.133 -0400", hash_original_field = "41D59DA363A972A70E89D7F097262996", hash_generated_field = "433B613895F9A9778E53C598D01BA2AB")

    private ImageView mExpandActivityOverflowButtonImage;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.133 -0400", hash_original_field = "DAD8AB330B8FE38CED27A92AB62A5E4D", hash_generated_field = "2804585A9E453E27976F3FDF1A270905")

    private FrameLayout mDefaultActivityButton;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.133 -0400", hash_original_field = "C2BD14F014164359D2DBF374E3941AF3", hash_generated_field = "A19ECBBBF75A40B339DC4A95C030E78B")

    private ImageView mDefaultActivityButtonImage;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.133 -0400", hash_original_field = "D19DDAF4856E35C2635D5FF15637EEE6", hash_generated_field = "6549412A83E8736AC71A3C4F42B2776F")

    private int mListPopupMaxWidth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.133 -0400", hash_original_field = "BD1D19BC6BC3803BE152A977D479AC49", hash_generated_field = "94389E96F8958E34938A4C66FB6778B1")

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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.133 -0400", hash_original_field = "D37E69872D15BB8AD43DD3C6E77034A5", hash_generated_field = "B18FE4D2C1F5F5724780B69F0C631713")

    private ListPopupWindow mListPopupWindow;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.133 -0400", hash_original_field = "B6794399ABC229B6F5098657922184B3", hash_generated_field = "5A4179E23C1E43233D6280AC184F1638")

    private PopupWindow.OnDismissListener mOnDismissListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.134 -0400", hash_original_field = "5302A99A8C1C0F6305F7A9ECB4B77A94", hash_generated_field = "FB5A63E1FFE964D7D3DF45A85F8B7265")

    private boolean mIsSelectingDefaultActivity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.134 -0400", hash_original_field = "50E4F4B3AA4ACDAC2444FD64183E5704", hash_generated_field = "04519B5943EE67A9C7EEE82652B59883")

    private int mInitialActivityCount = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_DEFAULT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.134 -0400", hash_original_field = "1F925504346EA79D2090BC0874ADA0DB", hash_generated_field = "A725E70F25078818B1BC03DF5AE609A6")

    private boolean mIsAttachedToWindow;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.134 -0400", hash_original_field = "5C855F3EB880070F54099C89CF873EEB", hash_generated_field = "2EB4D3D3AA67879C726AB0ABB6BA9C6A")

    private int mDefaultActionButtonContentDescription;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.134 -0400", hash_original_method = "B1417C53B7334442AE372C957DCB8F0C", hash_generated_method = "86B03DA005E6640F9AA460F2B84E2F8E")
    public  ActivityChooserView(Context context) {
        this(context, null);
        addTaint(context.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.134 -0400", hash_original_method = "5446B591236758FE1022AC56CCF4E7CA", hash_generated_method = "2CE96040CA3CBC93CA7E577D7E0AFD79")
    public  ActivityChooserView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.137 -0400", hash_original_method = "82640F6029B5DED0016360DF13353C92", hash_generated_method = "7AD5603CCAC9233EA0D8158881706303")
    public  ActivityChooserView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        addTaint(defStyle);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
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
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.136 -0400", hash_original_method = "77B1463ED818B52DA8559320D8129DE8", hash_generated_method = "4823B6C5288EB5E4410B6C2B7971F9E9")
        @Override
        public void onChanged() {
            
            super.onChanged();
            updateAppearance();
            
            
            
        }
});
        Resources resources = context.getResources();
        mListPopupMaxWidth = Math.max(resources.getDisplayMetrics().widthPixels / 2,
              resources.getDimensionPixelSize(com.android.internal.R.dimen.config_prefDialogWidth));
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.137 -0400", hash_original_method = "200277448D26D5459B7D9186C5FC6866", hash_generated_method = "3CD47E882EFB7A044D6C5A7906E118E7")
    public void setActivityChooserModel(ActivityChooserModel dataModel) {
        addTaint(dataModel.getTaint());
        mAdapter.setDataModel(dataModel);
    if(isShowingPopup())        
        {
            dismissPopup();
            showPopup();
        } 
        
        
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.138 -0400", hash_original_method = "40C8CFBBBEC7CE8C6DC800BBA1A8260F", hash_generated_method = "8071C44C0024823653A728AF47CD8DE3")
    public void setExpandActivityOverflowButtonDrawable(Drawable drawable) {
        addTaint(drawable.getTaint());
        mExpandActivityOverflowButtonImage.setImageDrawable(drawable);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.138 -0400", hash_original_method = "0A5827A88A56386A8A69EC0550F49C43", hash_generated_method = "F24FCD1C3BA793DFAEC1AD43E0E690BA")
    public void setExpandActivityOverflowButtonContentDescription(int resourceId) {
        addTaint(resourceId);
        CharSequence contentDescription = mContext.getString(resourceId);
        mExpandActivityOverflowButtonImage.setContentDescription(contentDescription);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.139 -0400", hash_original_method = "4EB99ACA5BA34A284707803087697EF8", hash_generated_method = "BB5F635A8854257C75F3E39227EB8F20")
    public void setProvider(ActionProvider provider) {
        mProvider = provider;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.139 -0400", hash_original_method = "D9F80F56BE7AEC83902DD1E82500AB90", hash_generated_method = "3C09FDDFA61083FF31AB8D7F7EFDB264")
    public boolean showPopup() {
    if(isShowingPopup() || !mIsAttachedToWindow)        
        {
            boolean var68934A3E9455FA72420237EB05902327_334035670 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_28037314 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_28037314;
        } 
        mIsSelectingDefaultActivity = false;
        showPopupUnchecked(mInitialActivityCount);
        boolean varB326B5062B2F0E69046810717534CB09_720068860 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1386688930 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1386688930;
        
        
            
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.140 -0400", hash_original_method = "3AECC6260DA21BAD7E8B15E74C7BA72C", hash_generated_method = "C9526396CA0FCF6D563357355707743E")
    private void showPopupUnchecked(int maxActivityCount) {
        addTaint(maxActivityCount);
    if(mAdapter.getDataModel() == null)        
        {
            IllegalStateException var381F80BF3C7DE0AAF04084C83CAA1E7B_164132418 = new IllegalStateException("No data model. Did you call #setDataModel?");
            var381F80BF3C7DE0AAF04084C83CAA1E7B_164132418.addTaint(taint);
            throw var381F80BF3C7DE0AAF04084C83CAA1E7B_164132418;
        } 
        getViewTreeObserver().addOnGlobalLayoutListener(mOnGlobalLayoutListener);
        final boolean defaultActivityButtonShown = mDefaultActivityButton.getVisibility() == VISIBLE;
        final int activityCount = mAdapter.getActivityCount();
        final int maxActivityCountOffset = defaultActivityButtonShown ? 1 : 0;
    if(maxActivityCount != ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED
                && activityCount > maxActivityCount + maxActivityCountOffset)        
        {
            mAdapter.setShowFooterView(true);
            mAdapter.setMaxActivityCount(maxActivityCount - 1);
        } 
        else
        {
            mAdapter.setShowFooterView(false);
            mAdapter.setMaxActivityCount(maxActivityCount);
        } 
        ListPopupWindow popupWindow = getListPopupWindow();
    if(!popupWindow.isShowing())        
        {
    if(mIsSelectingDefaultActivity || !defaultActivityButtonShown)            
            {
                mAdapter.setShowDefaultActivity(true, defaultActivityButtonShown);
            } 
            else
            {
                mAdapter.setShowDefaultActivity(false, false);
            } 
            final int contentWidth = Math.min(mAdapter.measureContentWidth(), mListPopupMaxWidth);
            popupWindow.setContentWidth(contentWidth);
            popupWindow.show();
    if(mProvider != null)            
            {
                mProvider.subUiVisibilityChanged(true);
            } 
            popupWindow.getListView().setContentDescription(mContext.getString(
                    R.string.activitychooserview_choose_application));
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.140 -0400", hash_original_method = "D685C2FA386E3559D94DAB46E30EF0B9", hash_generated_method = "4EB207BF818A02D4CBE903B63E3C776A")
    public boolean dismissPopup() {
    if(isShowingPopup())        
        {
            getListPopupWindow().dismiss();
            ViewTreeObserver viewTreeObserver = getViewTreeObserver();
    if(viewTreeObserver.isAlive())            
            {
                viewTreeObserver.removeGlobalOnLayoutListener(mOnGlobalLayoutListener);
            } 
        } 
        boolean varB326B5062B2F0E69046810717534CB09_1165132323 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1323508299 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1323508299;
        
        
            
            
            
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.141 -0400", hash_original_method = "E45D6D96430861522854D560F5CA6F0B", hash_generated_method = "A86A7220E09A2EB24CE0FF68C1EA81D8")
    public boolean isShowingPopup() {
        boolean varEC16F2AB0C513EEC2D6CFE9178BA04FC_1623340895 = (getListPopupWindow().isShowing());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1767071976 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1767071976;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.141 -0400", hash_original_method = "F599B3D6D046BF4212D64A5D6A7F3811", hash_generated_method = "80F844DCA2269B21B004557A74BA538B")
    @Override
    protected void onAttachedToWindow() {
        
        super.onAttachedToWindow();
        ActivityChooserModel dataModel = mAdapter.getDataModel();
    if(dataModel != null)        
        {
            dataModel.registerObserver(mModelDataSetOberver);
        } 
        mIsAttachedToWindow = true;
        
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.142 -0400", hash_original_method = "589218240FC22193C94953AC6574E4EA", hash_generated_method = "3375D32324F5A5C3AEFB3746012D7F22")
    @Override
    protected void onDetachedFromWindow() {
        
        super.onDetachedFromWindow();
        ActivityChooserModel dataModel = mAdapter.getDataModel();
    if(dataModel != null)        
        {
            dataModel.unregisterObserver(mModelDataSetOberver);
        } 
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
    if(viewTreeObserver.isAlive())        
        {
            viewTreeObserver.removeGlobalOnLayoutListener(mOnGlobalLayoutListener);
        } 
        mIsAttachedToWindow = false;
        
        
        
        
            
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.142 -0400", hash_original_method = "77C33EEC897BED8B2A12DF2072C37646", hash_generated_method = "ACB91396960FFA3FA31CF15FE3E56C41")
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        
        addTaint(heightMeasureSpec);
        addTaint(widthMeasureSpec);
        View child = mActivityChooserContent;
    if(mDefaultActivityButton.getVisibility() != VISIBLE)        
        {
            heightMeasureSpec = MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(heightMeasureSpec),
                    MeasureSpec.EXACTLY);
        } 
        measureChild(child, widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(child.getMeasuredWidth(), child.getMeasuredHeight());
        
        
        
            
                    
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.143 -0400", hash_original_method = "C5A31C6F2FD14D87574B0913D4F6A2F2", hash_generated_method = "AECFA23BC7705187D8C8991F47325290")
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        
        addTaint(bottom);
        addTaint(right);
        addTaint(top);
        addTaint(left);
        addTaint(changed);
        mActivityChooserContent.layout(0, 0, right - left, bottom - top);
    if(getListPopupWindow().isShowing())        
        {
            showPopupUnchecked(mAdapter.getMaxActivityCount());
        } 
        else
        {
            dismissPopup();
        } 
        
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.143 -0400", hash_original_method = "5EF19A4E1889AB1FC4A984C090B7713C", hash_generated_method = "16E2C51C27AA107682BD2A16AAB5B8D3")
    public ActivityChooserModel getDataModel() {
ActivityChooserModel var508A9B88A601E27CB548DFF712F7BB82_1313562084 =         mAdapter.getDataModel();
        var508A9B88A601E27CB548DFF712F7BB82_1313562084.addTaint(taint);
        return var508A9B88A601E27CB548DFF712F7BB82_1313562084;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.144 -0400", hash_original_method = "3D692CC2129791FB098BE485AC739689", hash_generated_method = "AFEDE7910A1B37993DCCD6535D2798FB")
    public void setOnDismissListener(PopupWindow.OnDismissListener listener) {
        mOnDismissListener = listener;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.144 -0400", hash_original_method = "861F24EC23ECA4CA4EF104A377B2D34D", hash_generated_method = "706332B7EEAD1AE51173D975872ABB45")
    public void setInitialActivityCount(int itemCount) {
        mInitialActivityCount = itemCount;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.144 -0400", hash_original_method = "A16FFC5DB1EC302B931A83E3D5524FB1", hash_generated_method = "3AA11D7A925E1612E7FB383801FF727D")
    public void setDefaultActionButtonContentDescription(int resourceId) {
        mDefaultActionButtonContentDescription = resourceId;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.145 -0400", hash_original_method = "A13663EF62899FD593D247A6177CE71D", hash_generated_method = "D8ED100E1E4D0063A928319ADCBD2FEF")
    private ListPopupWindow getListPopupWindow() {
    if(mListPopupWindow == null)        
        {
            mListPopupWindow = new ListPopupWindow(getContext());
            mListPopupWindow.setAdapter(mAdapter);
            mListPopupWindow.setAnchorView(ActivityChooserView.this);
            mListPopupWindow.setModal(true);
            mListPopupWindow.setOnItemClickListener(mCallbacks);
            mListPopupWindow.setOnDismissListener(mCallbacks);
        } 
ListPopupWindow varFECCF21D966B892F2BEC3B8FB195AB5E_591718605 =         mListPopupWindow;
        varFECCF21D966B892F2BEC3B8FB195AB5E_591718605.addTaint(taint);
        return varFECCF21D966B892F2BEC3B8FB195AB5E_591718605;
        
        
            
            
            
            
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.145 -0400", hash_original_method = "D65ED5C5B81BB78866247BEAE65AB728", hash_generated_method = "4371E5B44E35DCCD7BE0A666CA47154F")
    private void updateAppearance() {
    if(mAdapter.getCount() > 0)        
        {
            mExpandActivityOverflowButton.setEnabled(true);
        } 
        else
        {
            mExpandActivityOverflowButton.setEnabled(false);
        } 
        final int activityCount = mAdapter.getActivityCount();
        final int historySize = mAdapter.getHistorySize();
    if(activityCount > 0 && historySize > 0)        
        {
            mDefaultActivityButton.setVisibility(VISIBLE);
            ResolveInfo activity = mAdapter.getDefaultActivity();
            PackageManager packageManager = mContext.getPackageManager();
            mDefaultActivityButtonImage.setImageDrawable(activity.loadIcon(packageManager));
    if(mDefaultActionButtonContentDescription != 0)            
            {
                CharSequence label = activity.loadLabel(packageManager);
                String contentDescription = mContext.getString(
                        mDefaultActionButtonContentDescription, label);
                mDefaultActivityButton.setContentDescription(contentDescription);
            } 
        } 
        else
        {
            mDefaultActivityButton.setVisibility(View.GONE);
        } 
    if(mDefaultActivityButton.getVisibility() == VISIBLE)        
        {
            mActivityChooserContent.setBackgroundDrawable(mActivityChooserContentBackground);
        } 
        else
        {
            mActivityChooserContent.setBackgroundDrawable(null);
        } 
        
        
    }

    
    private class Callbacks implements AdapterView.OnItemClickListener, View.OnClickListener, View.OnLongClickListener, PopupWindow.OnDismissListener {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.146 -0400", hash_original_method = "BBA4719757F5E3331C7832D116B199C8", hash_generated_method = "BBA4719757F5E3331C7832D116B199C8")
        public Callbacks ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.147 -0400", hash_original_method = "674D57987B8C667CB3D7FFB12FCDD905", hash_generated_method = "92DCC20D3BE580980BADDB5C64C3477B")
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            
            addTaint(id);
            addTaint(position);
            addTaint(view.getTaint());
            addTaint(parent.getTaint());
            ActivityChooserViewAdapter adapter = (ActivityChooserViewAdapter) parent.getAdapter();
            final int itemViewType = adapter.getItemViewType(position);
switch(itemViewType){
            case ActivityChooserViewAdapter.ITEM_VIEW_TYPE_FOOTER:
            {
                showPopupUnchecked(ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            } 
            break;
            case ActivityChooserViewAdapter.ITEM_VIEW_TYPE_ACTIVITY:
            {
                dismissPopup();
    if(mIsSelectingDefaultActivity)                
                {
    if(position > 0)                    
                    {
                        mAdapter.getDataModel().setDefaultActivity(position);
                    } 
                } 
                else
                {
                    position = mAdapter.getShowDefaultActivity() ? position : position + 1;
                    Intent launchIntent = mAdapter.getDataModel().chooseActivity(position);
    if(launchIntent != null)                    
                    {
                        mContext.startActivity(launchIntent);
                    } 
                } 
            } 
            break;
            default:
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_655093352 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_655093352.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_655093352;
}
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.148 -0400", hash_original_method = "B05554F780928527AD52A76E48C9B5FF", hash_generated_method = "94AFF13AE33782313477A296949EC59F")
        public void onClick(View view) {
            
            addTaint(view.getTaint());
    if(view == mDefaultActivityButton)            
            {
                dismissPopup();
                ResolveInfo defaultActivity = mAdapter.getDefaultActivity();
                final int index = mAdapter.getDataModel().getActivityIndex(defaultActivity);
                Intent launchIntent = mAdapter.getDataModel().chooseActivity(index);
    if(launchIntent != null)                
                {
                    mContext.startActivity(launchIntent);
                } 
            } 
            else
    if(view == mExpandActivityOverflowButton)            
            {
                mIsSelectingDefaultActivity = false;
                showPopupUnchecked(mInitialActivityCount);
            } 
            else
            {
                IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_979173248 = new IllegalArgumentException();
                var5783EF97022AA508B74A1E3EA38534AF_979173248.addTaint(taint);
                throw var5783EF97022AA508B74A1E3EA38534AF_979173248;
            } 
            
            
                
                
                
                
                
                    
                
            
                
                
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.149 -0400", hash_original_method = "FB2F3C2103372446E9D5711FBCAD6598", hash_generated_method = "1AEB10D3FE86B0D0913893F3389CCDD7")
        @Override
        public boolean onLongClick(View view) {
            
            addTaint(view.getTaint());
    if(view == mDefaultActivityButton)            
            {
    if(mAdapter.getCount() > 0)                
                {
                    mIsSelectingDefaultActivity = true;
                    showPopupUnchecked(mInitialActivityCount);
                } 
            } 
            else
            {
                IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_1794604333 = new IllegalArgumentException();
                var5783EF97022AA508B74A1E3EA38534AF_1794604333.addTaint(taint);
                throw var5783EF97022AA508B74A1E3EA38534AF_1794604333;
            } 
            boolean varB326B5062B2F0E69046810717534CB09_1224681605 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1582930240 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1582930240;
            
            
                
                    
                    
                
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.150 -0400", hash_original_method = "D25064A646F02B95A775BA0461A79BFD", hash_generated_method = "46ED0B7F5EA113F94D2D7ED613CB2AF8")
        public void onDismiss() {
            
            notifyOnDismissListener();
    if(mProvider != null)            
            {
                mProvider.subUiVisibilityChanged(false);
            } 
            
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.150 -0400", hash_original_method = "5021FB127D2DB881B8B1C45B5E11E195", hash_generated_method = "01A110E249B10AF14130012612769273")
        private void notifyOnDismissListener() {
    if(mOnDismissListener != null)            
            {
                mOnDismissListener.onDismiss();
            } 
            
            
                
            
        }

        
    }


    
    private class ActivityChooserViewAdapter extends BaseAdapter {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.151 -0400", hash_original_field = "50A2FAD5E06F7194FA7769A1A3E62D87", hash_generated_field = "4B23A60A5EE2A01D93FA935950453A89")

        private ActivityChooserModel mDataModel;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.151 -0400", hash_original_field = "B987B83C5177B9AFB697E37A66BDA301", hash_generated_field = "7E27524CCC6935FAB8F88BAF1C6AE0A3")

        private int mMaxActivityCount = MAX_ACTIVITY_COUNT_DEFAULT;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.151 -0400", hash_original_field = "87ABBEC987619D585AA0E13F787A82A2", hash_generated_field = "E8EE97CA68AAFA64A18B7D487730ED89")

        private boolean mShowDefaultActivity;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.151 -0400", hash_original_field = "713E85B0BB0A9AB65769E7BDFA193547", hash_generated_field = "F496D5B1359B104FF475E03332F1A6A6")

        private boolean mHighlightDefaultActivity;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.151 -0400", hash_original_field = "5443D153EDC335581CB5CD2DE0645B49", hash_generated_field = "41BD5170A6AC3F68C312DE8FD93FC32C")

        private boolean mShowFooterView;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.151 -0400", hash_original_method = "BA43971C492C1B02A22C4BF340770F66", hash_generated_method = "BA43971C492C1B02A22C4BF340770F66")
        public ActivityChooserViewAdapter ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.152 -0400", hash_original_method = "ACCCD73AF35EBCB0E150696E3946651D", hash_generated_method = "1AA20D012B7194AE19EA1AD414821712")
        public void setDataModel(ActivityChooserModel dataModel) {
            ActivityChooserModel oldDataModel = mAdapter.getDataModel();
    if(oldDataModel != null && isShown())            
            {
                oldDataModel.unregisterObserver(mModelDataSetOberver);
            } 
            mDataModel = dataModel;
    if(dataModel != null && isShown())            
            {
                dataModel.registerObserver(mModelDataSetOberver);
            } 
            notifyDataSetChanged();
            
            
            
                
            
            
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.153 -0400", hash_original_method = "39EE4EFF86EDF87DA80E694DA09810EF", hash_generated_method = "034B33208D8FA1F69019F08601F12583")
        @Override
        public int getItemViewType(int position) {
            addTaint(position);
    if(mShowFooterView && position == getCount() - 1)            
            {
                int var090E59C041C1F1B726EAA49617ABA0B8_1877031943 = (ITEM_VIEW_TYPE_FOOTER);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_488682113 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_488682113;
            } 
            else
            {
                int var3F2F5514832ADFBE8F4A45A97002694A_331197765 = (ITEM_VIEW_TYPE_ACTIVITY);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_929310373 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_929310373;
            } 
            
            
                
            
                
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.153 -0400", hash_original_method = "A69A431394F21E5FD61198963B3D5202", hash_generated_method = "84982FCFB6CC7F15B19273AEE9F12DB6")
        @Override
        public int getViewTypeCount() {
            int var2EEB33B94A84BABEF12198758DB45587_707919680 = (ITEM_VIEW_TYPE_COUNT);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_625937171 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_625937171;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.154 -0400", hash_original_method = "1BE11BD9F55247D049566CF39D6E3C60", hash_generated_method = "A0B952A8A385040154F51D4BA706CE29")
        public int getCount() {
            int count = 0;
            int activityCount = mDataModel.getActivityCount();
    if(!mShowDefaultActivity && mDataModel.getDefaultActivity() != null)            
            {
                activityCount--;
            } 
            count = Math.min(activityCount, mMaxActivityCount);
    if(mShowFooterView)            
            {
                count++;
            } 
            int varE2942A04780E223B215EB8B663CF5353_747164030 = (count);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1039639685 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1039639685;
            
            
            
            
                
            
            
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.154 -0400", hash_original_method = "F3D4BDC985376DF5677372C13824236A", hash_generated_method = "0CF39E890D3A21C29CC5440EC600DCB4")
        public Object getItem(int position) {
            addTaint(position);
            final int itemViewType = getItemViewType(position);
switch(itemViewType){
            case ITEM_VIEW_TYPE_FOOTER:
Object var540C13E9E156B687226421B24F2DF178_574419902 =             null;
            var540C13E9E156B687226421B24F2DF178_574419902.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_574419902;
            case ITEM_VIEW_TYPE_ACTIVITY:
    if(!mShowDefaultActivity && mDataModel.getDefaultActivity() != null)            
            {
                position++;
            } 
Object varFD4721BD12B3F49C4BC4EEF9814EA0E3_884571731 =             mDataModel.getActivity(position);
            varFD4721BD12B3F49C4BC4EEF9814EA0E3_884571731.addTaint(taint);
            return varFD4721BD12B3F49C4BC4EEF9814EA0E3_884571731;
            default:
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_2001263591 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_2001263591.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_2001263591;
}
            
            
            
                
                    
                
                    
                        
                    
                    
                
                    
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.155 -0400", hash_original_method = "7144EF990F660E75AA61001CF21A1CD5", hash_generated_method = "EDFBFC884945B284C55340C20846FB4E")
        public long getItemId(int position) {
            addTaint(position);
            long var4757FE07FD492A8BE0EA6A760D683D6E_155299191 = (position);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_537880400 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_537880400;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.155 -0400", hash_original_method = "6D38E6A963432D636038206F8FE6305D", hash_generated_method = "64AE8F68E64CBB1531CE8D48E994CAA0")
        public View getView(int position, View convertView, ViewGroup parent) {
            addTaint(parent.getTaint());
            addTaint(convertView.getTaint());
            addTaint(position);
            final int itemViewType = getItemViewType(position);
switch(itemViewType){
            case ITEM_VIEW_TYPE_FOOTER:
    if(convertView == null || convertView.getId() != ITEM_VIEW_TYPE_FOOTER)            
            {
                convertView = LayoutInflater.from(getContext()).inflate(
                                R.layout.activity_chooser_view_list_item, parent, false);
                convertView.setId(ITEM_VIEW_TYPE_FOOTER);
                TextView titleView = (TextView) convertView.findViewById(R.id.title);
                titleView.setText(mContext.getString(
                                R.string.activity_chooser_view_see_all));
            } 
View var78FE9B874BBEC69B62B43EE963245978_1348564267 =             convertView;
            var78FE9B874BBEC69B62B43EE963245978_1348564267.addTaint(taint);
            return var78FE9B874BBEC69B62B43EE963245978_1348564267;
            case ITEM_VIEW_TYPE_ACTIVITY:
    if(convertView == null || convertView.getId() != R.id.list_item)            
            {
                convertView = LayoutInflater.from(getContext()).inflate(
                                R.layout.activity_chooser_view_list_item, parent, false);
            } 
            PackageManager packageManager = mContext.getPackageManager();
            ImageView iconView = (ImageView) convertView.findViewById(R.id.icon);
            ResolveInfo activity = (ResolveInfo) getItem(position);
            iconView.setImageDrawable(activity.loadIcon(packageManager));
            TextView titleView = (TextView) convertView.findViewById(R.id.title);
            titleView.setText(activity.loadLabel(packageManager));
    if(mShowDefaultActivity && position == 0 && mHighlightDefaultActivity)            
            {
                convertView.setActivated(true);
            } 
            else
            {
                convertView.setActivated(false);
            } 
View var78FE9B874BBEC69B62B43EE963245978_147665692 =             convertView;
            var78FE9B874BBEC69B62B43EE963245978_147665692.addTaint(taint);
            return var78FE9B874BBEC69B62B43EE963245978_147665692;
            default:
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_1466901008 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_1466901008.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_1466901008;
}
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.156 -0400", hash_original_method = "E7848C130F305A2BB53DDDF9782AAF0B", hash_generated_method = "8612BCBDB726078E53586AA784BBBE54")
        public int measureContentWidth() {
            final int oldMaxActivityCount = mMaxActivityCount;
            mMaxActivityCount = MAX_ACTIVITY_COUNT_UNLIMITED;
            int contentWidth = 0;
            View itemView = null;
            final int widthMeasureSpec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
            final int heightMeasureSpec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
            final int count = getCount();
for(int i = 0;i < count;i++)
            {
                itemView = getView(i, itemView, null);
                itemView.measure(widthMeasureSpec, heightMeasureSpec);
                contentWidth = Math.max(contentWidth, itemView.getMeasuredWidth());
            } 
            mMaxActivityCount = oldMaxActivityCount;
            int var1BF07926F6538F21E562505C076C042A_619559935 = (contentWidth);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1635226157 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1635226157;
            
            
            
            
            
            
            
            
            
                
                
                
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.157 -0400", hash_original_method = "EE079429AB45DD891FDFB8F4CAB39411", hash_generated_method = "5661324B3737CCB07AA3D77A4B4A5038")
        public void setMaxActivityCount(int maxActivityCount) {
    if(mMaxActivityCount != maxActivityCount)            
            {
                mMaxActivityCount = maxActivityCount;
                notifyDataSetChanged();
            } 
            
            
                
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.157 -0400", hash_original_method = "D919FDFCC3B420966F5D4C74A721F1BF", hash_generated_method = "FAC65E87B24C2E87B4D69EBA6A58198C")
        public ResolveInfo getDefaultActivity() {
ResolveInfo var3028A8C3A425EFE9B76ADB6DF57395EF_727005548 =             mDataModel.getDefaultActivity();
            var3028A8C3A425EFE9B76ADB6DF57395EF_727005548.addTaint(taint);
            return var3028A8C3A425EFE9B76ADB6DF57395EF_727005548;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.157 -0400", hash_original_method = "4D9F28247FB57368F2D0E306E2284064", hash_generated_method = "99656D0166AE37E2ADA1D4D1ECFF18F0")
        public void setShowFooterView(boolean showFooterView) {
    if(mShowFooterView != showFooterView)            
            {
                mShowFooterView = showFooterView;
                notifyDataSetChanged();
            } 
            
            
                
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.158 -0400", hash_original_method = "31736EA607A445202315EB7B50B5EA80", hash_generated_method = "F2867DA123E183F091E24E0F073BC54C")
        public int getActivityCount() {
            int var1FFE10EE2EA5D34DA20C4869D38B02A8_1991689947 = (mDataModel.getActivityCount());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_320494532 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_320494532;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.158 -0400", hash_original_method = "1D0D91D46AAECCD7C2767CF25FDA64BD", hash_generated_method = "0B65A9B7753B31ABD5347C34EC14FC05")
        public int getHistorySize() {
            int varFEC0E3CEAD274146B345CC3FB0E3750C_786244615 = (mDataModel.getHistorySize());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_280417369 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_280417369;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.158 -0400", hash_original_method = "3E4531A24528D01DAB939C9C71B2C3DE", hash_generated_method = "296D773E34282119D912C97C790CB5E5")
        public int getMaxActivityCount() {
            int varA17198F82E11562FD1D05379D0C79E84_1367355630 = (mMaxActivityCount);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_288445431 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_288445431;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.158 -0400", hash_original_method = "5525C6AC91C9709046E305FD9A15863B", hash_generated_method = "B55CA5DD592B43301B8A7C3DBA4FC9D8")
        public ActivityChooserModel getDataModel() {
ActivityChooserModel var782E6E6245C8EB180C46FAFCB220D82B_424804604 =             mDataModel;
            var782E6E6245C8EB180C46FAFCB220D82B_424804604.addTaint(taint);
            return var782E6E6245C8EB180C46FAFCB220D82B_424804604;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.159 -0400", hash_original_method = "A23AAFB309F0D7012150D94437C8B43A", hash_generated_method = "C95920DAE375E3D3B7042E87269B1DD2")
        public void setShowDefaultActivity(boolean showDefaultActivity,
                boolean highlightDefaultActivity) {
    if(mShowDefaultActivity != showDefaultActivity
                    || mHighlightDefaultActivity != highlightDefaultActivity)            
            {
                mShowDefaultActivity = showDefaultActivity;
                mHighlightDefaultActivity = highlightDefaultActivity;
                notifyDataSetChanged();
            } 
            
            
                    
                
                
                
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.159 -0400", hash_original_method = "1922E89BA39A7DE83F0D6E6EABDFE98E", hash_generated_method = "362F8775FCFFB476E1AFCC055F0795E1")
        public boolean getShowDefaultActivity() {
            boolean var87ABBEC987619D585AA0E13F787A82A2_200685495 = (mShowDefaultActivity);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_771547996 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_771547996;
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.159 -0400", hash_original_field = "3AB659CF2ABB2A30495C6541B674B4DA", hash_generated_field = "76769A97B1782495BC5DE9799BE9BD4F")

        public static final int MAX_ACTIVITY_COUNT_UNLIMITED = Integer.MAX_VALUE;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.159 -0400", hash_original_field = "9A948FBD83F151D7B6865F79C07B61CF", hash_generated_field = "A9C0946733D648F3335EA0A2B5A4F65D")

        public static final int MAX_ACTIVITY_COUNT_DEFAULT = 4;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.159 -0400", hash_original_field = "2D5337C89A2BBDBAB8089E3104D05A58", hash_generated_field = "383E306DC665688B3D7C808185F54821")

        private static final int ITEM_VIEW_TYPE_ACTIVITY = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.160 -0400", hash_original_field = "56FBBE17487B87761CABEC4D515AA0BC", hash_generated_field = "79F678647BCDD97164F6B347EC57B1D5")

        private static final int ITEM_VIEW_TYPE_FOOTER = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.160 -0400", hash_original_field = "F174C44C46468510CCD8705E3812E20F", hash_generated_field = "68D4CDA5BEF3FD9B9DF66A65A3536699")

        private static final int ITEM_VIEW_TYPE_COUNT = 3;
    }


    
}

