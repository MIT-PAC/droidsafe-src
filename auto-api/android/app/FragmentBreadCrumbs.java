package android.app;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.animation.LayoutTransition;
import android.app.FragmentManager.BackStackEntry;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class FragmentBreadCrumbs extends ViewGroup implements FragmentManager.OnBackStackChangedListener {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.773 -0400", hash_original_field = "C145D87741EB407D6B1FF715AD484119", hash_generated_field = "3895D7E6DB5042DA7856DC78E391C7B9")

    Activity mActivity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.774 -0400", hash_original_field = "D03597FDEDE23F3823480E0520822BB2", hash_generated_field = "B03B4DAE3F576B7166425BEE37B96C5E")

    LayoutInflater mInflater;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.797 -0400", hash_original_field = "C64165C1B15EB68FDC5E7135FFE5DF5B", hash_generated_field = "9E6D10A453EA70FEA679FD6996EC6EE2")

    LinearLayout mContainer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.798 -0400", hash_original_field = "91929C6194D497D84E6667724127E5D3", hash_generated_field = "45982CE6F3A74DA323DCD9D702CE99E4")

    int mMaxVisible = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.799 -0400", hash_original_field = "A72D59443563A208033827C369D05D4F", hash_generated_field = "44C6893263D81EE27E690ADD5B8AF5EF")

    BackStackRecord mTopEntry;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.799 -0400", hash_original_field = "6817DD89083E64429112988EA2C9E6B3", hash_generated_field = "6D2F27A15AB0AAD879B33D53F5B6B069")

    BackStackRecord mParentEntry;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.800 -0400", hash_original_field = "253E7D4088B52C7B8584FD46ECD8C10A", hash_generated_field = "2A3C7A75AFBDB618C725B73099DDF099")

    private OnClickListener mParentClickListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.801 -0400", hash_original_field = "32D1DAA8DAC787DA037631576879A663", hash_generated_field = "69C03C2ED2E1B77C192E66A442A610B9")

    private OnBreadCrumbClickListener mOnBreadCrumbClickListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.845 -0400", hash_original_field = "1E4D37A0330A3E780D6C7BEB4952864B", hash_generated_field = "32FCCA270314E1209FA96571AB5A6B96")

    private OnClickListener mOnClickListener = new OnClickListener() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.822 -0400", hash_original_method = "EAECB23237EE3153081334DE62E2D4D2", hash_generated_method = "1B5FA8C8FB385FF8EEBB3AEA46CA7077")
        public void onClick(View v) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            {
                boolean varE4A1F40585B065B640BAA48725C67E73_1452531156 = (v.getTag() instanceof BackStackEntry);
                {
                    BackStackEntry bse;
                    bse = (BackStackEntry) v.getTag();
                    {
                        {
                            mParentClickListener.onClick(v);
                        } //End block
                    } //End block
                    {
                        {
                            {
                                boolean varDC9EADFAD769EB2BF5EC7B29105E5747_1809588865 = (mOnBreadCrumbClickListener.onBreadCrumbClick(
                                bse == mTopEntry ? null : bse, 0)); //DSFIXME:  CODE0008: Nested ternary operator in expression
                            } //End collapsed parenthetic
                        } //End block
                        {
                            mActivity.getFragmentManager().popBackStack();
                        } //End block
                        {
                            mActivity.getFragmentManager().popBackStack(bse.getId(), 0);
                        } //End block
                    } //End block
                } //End block
            } //End collapsed parenthetic
            addTaint(v.getTaint());
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
};
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.846 -0400", hash_original_method = "F31D6C14970B45E299330BA4917FEA6F", hash_generated_method = "08B5F6D3421163D074374BE3AE9960C8")
    public  FragmentBreadCrumbs(Context context) {
        this(context, null);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.847 -0400", hash_original_method = "5C34FBFF77B455DC003E3973298C6C2F", hash_generated_method = "059F78E593E2B03A13DA76F2B82C04F2")
    public  FragmentBreadCrumbs(Context context, AttributeSet attrs) {
        this(context, attrs, android.R.style.Widget_FragmentBreadCrumbs);
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.849 -0400", hash_original_method = "882101D40DFCD492AAC18C6E55A9C587", hash_generated_method = "39BAF9DDD384E08B19F9C260AA69C89D")
    public  FragmentBreadCrumbs(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        addTaint(defStyle);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.880 -0400", hash_original_method = "D116B18FCF7DD3335EB7CD9778309038", hash_generated_method = "5E184C3FB51B89C3778AA6CB0F4831AE")
    public void setActivity(Activity a) {
        mActivity = a;
        mInflater = (LayoutInflater)a.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mContainer = (LinearLayout)mInflater.inflate(
                com.android.internal.R.layout.fragment_bread_crumbs,
                this, false);
        addView(mContainer);
        a.getFragmentManager().addOnBackStackChangedListener(this);
        updateCrumbs();
        setLayoutTransition(new LayoutTransition());
        // ---------- Original Method ----------
        //mActivity = a;
        //mInflater = (LayoutInflater)a.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //mContainer = (LinearLayout)mInflater.inflate(
                //com.android.internal.R.layout.fragment_bread_crumbs,
                //this, false);
        //addView(mContainer);
        //a.getFragmentManager().addOnBackStackChangedListener(this);
        //updateCrumbs();
        //setLayoutTransition(new LayoutTransition());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.884 -0400", hash_original_method = "4BFEBF6B94C32F37C904F94529D790EA", hash_generated_method = "70F518C50A7AA33A727B22C7D6465C0F")
    public void setMaxVisible(int visibleCrumbs) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("visibleCrumbs must be greater than zero");
        } //End block
        mMaxVisible = visibleCrumbs;
        // ---------- Original Method ----------
        //if (visibleCrumbs < 1) {
            //throw new IllegalArgumentException("visibleCrumbs must be greater than zero");
        //}
        //mMaxVisible = visibleCrumbs;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.912 -0400", hash_original_method = "8B9B076BA783F3864F7766638C88B28A", hash_generated_method = "A3D6B60C7B8CF8FEA6AD13B21BBCBB94")
    public void setParentTitle(CharSequence title, CharSequence shortTitle,
            OnClickListener listener) {
        mParentEntry = createBackStackEntry(title, shortTitle);
        mParentClickListener = listener;
        updateCrumbs();
        // ---------- Original Method ----------
        //mParentEntry = createBackStackEntry(title, shortTitle);
        //mParentClickListener = listener;
        //updateCrumbs();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.917 -0400", hash_original_method = "2512D126AA76678C0FD3EA5EF92C167A", hash_generated_method = "86CEEB80EAE109905A6293EE27933D7C")
    public void setOnBreadCrumbClickListener(OnBreadCrumbClickListener listener) {
        mOnBreadCrumbClickListener = listener;
        // ---------- Original Method ----------
        //mOnBreadCrumbClickListener = listener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.940 -0400", hash_original_method = "2DFBE29D707A4E78CDFA68237F5B82AC", hash_generated_method = "1E5658BEBDDC7A57BD6B7939CDE40698")
    private BackStackRecord createBackStackEntry(CharSequence title, CharSequence shortTitle) {
        BackStackRecord varB4EAC82CA7396A68D541C85D26508E83_244970529 = null; //Variable for return #1
        BackStackRecord varB4EAC82CA7396A68D541C85D26508E83_1709937828 = null; //Variable for return #2
        varB4EAC82CA7396A68D541C85D26508E83_244970529 = null;
        BackStackRecord entry;
        entry = new BackStackRecord(
                (FragmentManagerImpl) mActivity.getFragmentManager());
        entry.setBreadCrumbTitle(title);
        entry.setBreadCrumbShortTitle(shortTitle);
        varB4EAC82CA7396A68D541C85D26508E83_1709937828 = entry;
        addTaint(title.getTaint());
        addTaint(shortTitle.getTaint());
        BackStackRecord varA7E53CE21691AB073D9660D615818899_1658760759; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1658760759 = varB4EAC82CA7396A68D541C85D26508E83_244970529;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1658760759 = varB4EAC82CA7396A68D541C85D26508E83_1709937828;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1658760759.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1658760759;
        // ---------- Original Method ----------
        //if (title == null) return null;
        //final BackStackRecord entry = new BackStackRecord(
                //(FragmentManagerImpl) mActivity.getFragmentManager());
        //entry.setBreadCrumbTitle(title);
        //entry.setBreadCrumbShortTitle(shortTitle);
        //return entry;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.942 -0400", hash_original_method = "1306B82E4142284FF7749CACC8A21251", hash_generated_method = "ACC6FC3FEDF3D51C4466086B1F47D5EE")
    public void setTitle(CharSequence title, CharSequence shortTitle) {
        mTopEntry = createBackStackEntry(title, shortTitle);
        updateCrumbs();
        // ---------- Original Method ----------
        //mTopEntry = createBackStackEntry(title, shortTitle);
        //updateCrumbs();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.958 -0400", hash_original_method = "0BB4F9B64E73CA7A8C38A4967E9CC22C", hash_generated_method = "10FE82D32032EA6336B2D856DAF8FC91")
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        int childCount;
        childCount = getChildCount();
        {
            int i;
            i = 0;
            {
                View child;
                child = getChildAt(i);
                int childRight;
                childRight = mPaddingLeft + child.getMeasuredWidth() - mPaddingRight;
                int childBottom;
                childBottom = mPaddingTop + child.getMeasuredHeight() - mPaddingBottom;
                child.layout(mPaddingLeft, mPaddingTop, childRight, childBottom);
            } //End block
        } //End collapsed parenthetic
        addTaint(changed);
        addTaint(l);
        addTaint(t);
        addTaint(r);
        addTaint(b);
        // ---------- Original Method ----------
        //final int childCount = getChildCount();
        //for (int i = 0; i < childCount; i++) {
            //final View child = getChildAt(i);
            //int childRight = mPaddingLeft + child.getMeasuredWidth() - mPaddingRight;
            //int childBottom = mPaddingTop + child.getMeasuredHeight() - mPaddingBottom;
            //child.layout(mPaddingLeft, mPaddingTop, childRight, childBottom);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.980 -0400", hash_original_method = "6660D304081A4852C20DD013035B63D1", hash_generated_method = "6ECC560DCF809C3339F171B3F1A99BE8")
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        int count;
        count = getChildCount();
        int maxHeight;
        maxHeight = 0;
        int maxWidth;
        maxWidth = 0;
        int measuredChildState;
        measuredChildState = 0;
        {
            int i;
            i = 0;
            {
                View child;
                child = getChildAt(i);
                {
                    boolean var6B4F6D9B07C374A63E00C1591AF2C9D6_2108170034 = (child.getVisibility() != GONE);
                    {
                        measureChild(child, widthMeasureSpec, heightMeasureSpec);
                        maxWidth = Math.max(maxWidth, child.getMeasuredWidth());
                        maxHeight = Math.max(maxHeight, child.getMeasuredHeight());
                        measuredChildState = combineMeasuredStates(measuredChildState,
                        child.getMeasuredState());
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        maxWidth += mPaddingLeft + mPaddingRight;
        maxHeight += mPaddingTop + mPaddingBottom;
        maxHeight = Math.max(maxHeight, getSuggestedMinimumHeight());
        maxWidth = Math.max(maxWidth, getSuggestedMinimumWidth());
        setMeasuredDimension(resolveSizeAndState(maxWidth, widthMeasureSpec, measuredChildState),
                resolveSizeAndState(maxHeight, heightMeasureSpec,
                        measuredChildState<<MEASURED_HEIGHT_STATE_SHIFT));
        addTaint(widthMeasureSpec);
        addTaint(heightMeasureSpec);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.987 -0400", hash_original_method = "2DCC9D501B82BF951374A63720FD5438", hash_generated_method = "5C65DFD1D77C80E48E1238CADCC22076")
    @Override
    public void onBackStackChanged() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        updateCrumbs();
        // ---------- Original Method ----------
        //updateCrumbs();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.988 -0400", hash_original_method = "2B539BE1FB77B26F9FE87488F97A1875", hash_generated_method = "7217DDE31B9A00903FF7B4EA4EBB998F")
    private int getPreEntryCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1099728083 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1099728083;
        // ---------- Original Method ----------
        //return (mTopEntry != null ? 1 : 0) + (mParentEntry != null ? 1 : 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:48.017 -0400", hash_original_method = "A88BBDCBE11FD6391FA665272F0534CD", hash_generated_method = "A029DEABB0964F06C266E13D8D2EAFE0")
    private BackStackEntry getPreEntry(int index) {
        BackStackEntry varB4EAC82CA7396A68D541C85D26508E83_315450238 = null; //Variable for return #1
        BackStackEntry varB4EAC82CA7396A68D541C85D26508E83_1796509429 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_315450238 = index == 0 ? mParentEntry : mTopEntry;
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1796509429 = mTopEntry;
        } //End block
        addTaint(index);
        BackStackEntry varA7E53CE21691AB073D9660D615818899_1530661229; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1530661229 = varB4EAC82CA7396A68D541C85D26508E83_315450238;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1530661229 = varB4EAC82CA7396A68D541C85D26508E83_1796509429;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1530661229.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1530661229;
        // ---------- Original Method ----------
        //if (mParentEntry != null) {
            //return index == 0 ? mParentEntry : mTopEntry;
        //} else {
            //return mTopEntry;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:48.063 -0400", hash_original_method = "A14DB46BECCE064DBECB4292853B7E2A", hash_generated_method = "998E493E94B929AE048C1B37D339221F")
     void updateCrumbs() {
        FragmentManager fm;
        fm = mActivity.getFragmentManager();
        int numEntries;
        numEntries = fm.getBackStackEntryCount();
        int numPreEntries;
        numPreEntries = getPreEntryCount();
        int numViews;
        numViews = mContainer.getChildCount();
        {
            int i;
            i = 0;
            {
                BackStackEntry bse;
                bse = getPreEntry(i);
                bse = fm.getBackStackEntryAt(i - numPreEntries);
                {
                    View v;
                    v = mContainer.getChildAt(i);
                    Object tag;
                    tag = v.getTag();
                    {
                        {
                            int j;
                            j = i;
                            {
                                mContainer.removeViewAt(i);
                            } //End block
                        } //End collapsed parenthetic
                        numViews = i;
                    } //End block
                } //End block
                {
                    View item;
                    item = mInflater.inflate(
                        com.android.internal.R.layout.fragment_bread_crumb_item,
                        this, false);
                    TextView text;
                    text = (TextView) item.findViewById(com.android.internal.R.id.title);
                    text.setText(bse.getBreadCrumbTitle());
                    text.setTag(bse);
                    {
                        item.findViewById(com.android.internal.R.id.left_icon).setVisibility(View.GONE);
                    } //End block
                    mContainer.addView(item);
                    text.setOnClickListener(mOnClickListener);
                } //End block
            } //End block
        } //End collapsed parenthetic
        int viewI;
        viewI = numEntries + numPreEntries;
        numViews = mContainer.getChildCount();
        {
            mContainer.removeViewAt(numViews - 1);
        } //End block
        {
            int i;
            i = 0;
            {
                View child;
                child = mContainer.getChildAt(i);
                child.findViewById(com.android.internal.R.id.title).setEnabled(i < numViews - 1);
                {
                    child.setVisibility(i < numViews - mMaxVisible ? View.GONE : View.VISIBLE);
                    View leftIcon;
                    leftIcon = child.findViewById(com.android.internal.R.id.left_icon);
                    leftIcon.setVisibility(i > numViews - mMaxVisible && i != 0 ? View.VISIBLE
                        : View.GONE);
                } //End block
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    public interface OnBreadCrumbClickListener {
        
        public boolean onBreadCrumbClick(BackStackEntry backStack, int flags);
    }
    
}

