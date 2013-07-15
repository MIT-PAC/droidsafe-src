package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.ActionProvider;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import android.widget.ActivityChooserModel.OnChooseActivityListener;
import com.android.internal.R;

public class ShareActionProvider extends ActionProvider {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.490 -0400", hash_original_field = "E80075D82EAA0135CBEAE00EBB5C22F2", hash_generated_field = "B8F76B4F7281B5BE96A33CBC1F738330")

    private int mMaxShownActivityCount = DEFAULT_INITIAL_ACTIVITY_COUNT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.490 -0400", hash_original_field = "918E3BF7E8558F9A63E5E3E0CD2B5FC9", hash_generated_field = "3718A0AB49E217FA6EE98546A2005E61")

    private final ShareMenuItemOnMenuItemClickListener mOnMenuItemClickListener = new ShareMenuItemOnMenuItemClickListener();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.490 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.490 -0400", hash_original_field = "58F3DD0C912C2149B0A7DBE1281E3D36", hash_generated_field = "7409E28971D0B0DB16EF85249AF9A2B4")

    private String mShareHistoryFileName = DEFAULT_SHARE_HISTORY_FILE_NAME;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.491 -0400", hash_original_field = "A6B19BE7036BB46AD6B88DDC6E33E808", hash_generated_field = "8D0302721DF93B0058B1E99D4AC6931D")

    private OnShareTargetSelectedListener mOnShareTargetSelectedListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.491 -0400", hash_original_field = "8A455BA14A92DE6792CD41FFAC5E0D78", hash_generated_field = "A3948F7FA69A8ECB6B19574CCCA8D09F")

    private OnChooseActivityListener mOnChooseActivityListener;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.491 -0400", hash_original_method = "D37DD9362CC0C7C9F17F614AA422CDA5", hash_generated_method = "3B8A6FFB44CD73DC8EB7E48875E8744E")
    public  ShareActionProvider(Context context) {
        super(context);
        mContext = context;
        // ---------- Original Method ----------
        //mContext = context;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.491 -0400", hash_original_method = "AF132A5C7109C48F5C74FEA83B1BA0C7", hash_generated_method = "CCA39642DF748CC4F4D53F64BD382B2B")
    public void setOnShareTargetSelectedListener(OnShareTargetSelectedListener listener) {
        mOnShareTargetSelectedListener = listener;
        setActivityChooserPolicyIfNeeded();
        // ---------- Original Method ----------
        //mOnShareTargetSelectedListener = listener;
        //setActivityChooserPolicyIfNeeded();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.491 -0400", hash_original_method = "457E9B3A86A4C9D09DD81D115C288523", hash_generated_method = "49C3237A29F3DC21FCADB9D75E7EF62B")
    @Override
    public View onCreateActionView() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        ActivityChooserModel dataModel = ActivityChooserModel.get(mContext, mShareHistoryFileName);
        ActivityChooserView activityChooserView = new ActivityChooserView(mContext);
        activityChooserView.setActivityChooserModel(dataModel);
        TypedValue outTypedValue = new TypedValue();
        mContext.getTheme().resolveAttribute(R.attr.actionModeShareDrawable, outTypedValue, true);
        Drawable drawable = mContext.getResources().getDrawable(outTypedValue.resourceId);
        activityChooserView.setExpandActivityOverflowButtonDrawable(drawable);
        activityChooserView.setProvider(this);
        activityChooserView.setDefaultActionButtonContentDescription(
                R.string.shareactionprovider_share_with_application);
        activityChooserView.setExpandActivityOverflowButtonContentDescription(
                R.string.shareactionprovider_share_with);
View varF556D8F63673A371CE9EF1B174A0164C_505366429 =         activityChooserView;
        varF556D8F63673A371CE9EF1B174A0164C_505366429.addTaint(taint);
        return varF556D8F63673A371CE9EF1B174A0164C_505366429;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.491 -0400", hash_original_method = "35CF29CD4DCA84D0FC63AC1A69E282B0", hash_generated_method = "15EFACB60B97C39230109EEC0A71947C")
    @Override
    public boolean hasSubMenu() {
        boolean varB326B5062B2F0E69046810717534CB09_1987450259 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1653882905 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1653882905;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.492 -0400", hash_original_method = "780159D1510500332D77DB35C815CAE0", hash_generated_method = "555B8A7B22D1F7FBCE113D989B218C8F")
    @Override
    public void onPrepareSubMenu(SubMenu subMenu) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(subMenu.getTaint());
        subMenu.clear();
        ActivityChooserModel dataModel = ActivityChooserModel.get(mContext, mShareHistoryFileName);
        PackageManager packageManager = mContext.getPackageManager();
        final int expandedActivityCount = dataModel.getActivityCount();
        final int collapsedActivityCount = Math.min(expandedActivityCount, mMaxShownActivityCount);
for(int i = 0;i < collapsedActivityCount;i++)
        {
            ResolveInfo activity = dataModel.getActivity(i);
            subMenu.add(0, i, i, activity.loadLabel(packageManager))
                .setIcon(activity.loadIcon(packageManager))
                .setOnMenuItemClickListener(mOnMenuItemClickListener);
        } //End block
    if(collapsedActivityCount < expandedActivityCount)        
        {
            SubMenu expandedSubMenu = subMenu.addSubMenu(Menu.NONE, collapsedActivityCount,
                    collapsedActivityCount,
                    mContext.getString(R.string.activity_chooser_view_see_all));
for(int i = 0;i < expandedActivityCount;i++)
            {
                ResolveInfo activity = dataModel.getActivity(i);
                expandedSubMenu.add(0, i, i, activity.loadLabel(packageManager))
                    .setIcon(activity.loadIcon(packageManager))
                    .setOnMenuItemClickListener(mOnMenuItemClickListener);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.492 -0400", hash_original_method = "55B9AB4A16F0F7764FD2AA524BC9ED0A", hash_generated_method = "C123692B0FCCE5C2CFCA116B1DEE8740")
    public void setShareHistoryFileName(String shareHistoryFile) {
        mShareHistoryFileName = shareHistoryFile;
        setActivityChooserPolicyIfNeeded();
        // ---------- Original Method ----------
        //mShareHistoryFileName = shareHistoryFile;
        //setActivityChooserPolicyIfNeeded();
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.492 -0400", hash_original_method = "0DAF31F3B630D54C36D98C14F5BC8D8F", hash_generated_method = "DE3C33B3D27BB7832A9685A249945989")
    public void setShareIntent(Intent shareIntent) {
        addTaint(shareIntent.getTaint());
        ActivityChooserModel dataModel = ActivityChooserModel.get(mContext,
            mShareHistoryFileName);
        dataModel.setIntent(shareIntent);
        // ---------- Original Method ----------
        //ActivityChooserModel dataModel = ActivityChooserModel.get(mContext,
            //mShareHistoryFileName);
        //dataModel.setIntent(shareIntent);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.492 -0400", hash_original_method = "5CBD2FEC274C7972832B56342BCF52F4", hash_generated_method = "117A6882365FD9FE90D0F6412F83F156")
    private void setActivityChooserPolicyIfNeeded() {
    if(mOnShareTargetSelectedListener == null)        
        {
            return;
        } //End block
    if(mOnChooseActivityListener == null)        
        {
            mOnChooseActivityListener = new ShareAcitivityChooserModelPolicy();
        } //End block
        ActivityChooserModel dataModel = ActivityChooserModel.get(mContext, mShareHistoryFileName);
        dataModel.setOnChooseActivityListener(mOnChooseActivityListener);
        // ---------- Original Method ----------
        //if (mOnShareTargetSelectedListener == null) {
            //return;
        //}
        //if (mOnChooseActivityListener == null) {
            //mOnChooseActivityListener = new ShareAcitivityChooserModelPolicy();
        //}
        //ActivityChooserModel dataModel = ActivityChooserModel.get(mContext, mShareHistoryFileName);
        //dataModel.setOnChooseActivityListener(mOnChooseActivityListener);
    }

    
    private class ShareMenuItemOnMenuItemClickListener implements OnMenuItemClickListener {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.492 -0400", hash_original_method = "C6BD26BFC91AD355EDD4802746345224", hash_generated_method = "C6BD26BFC91AD355EDD4802746345224")
        public ShareMenuItemOnMenuItemClickListener ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.492 -0400", hash_original_method = "9C4E8B2E808FE0B52E60FC78C14CA469", hash_generated_method = "98480C81B15CF2598504D28E1EC61CFA")
        @Override
        public boolean onMenuItemClick(MenuItem item) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(item.getTaint());
            ActivityChooserModel dataModel = ActivityChooserModel.get(mContext,
                    mShareHistoryFileName);
            final int itemId = item.getItemId();
            Intent launchIntent = dataModel.chooseActivity(itemId);
    if(launchIntent != null)            
            {
                mContext.startActivity(launchIntent);
            } //End block
            boolean varB326B5062B2F0E69046810717534CB09_1471151784 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1627546765 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1627546765;
            // ---------- Original Method ----------
            //ActivityChooserModel dataModel = ActivityChooserModel.get(mContext,
                    //mShareHistoryFileName);
            //final int itemId = item.getItemId();
            //Intent launchIntent = dataModel.chooseActivity(itemId);
            //if (launchIntent != null) {
                //mContext.startActivity(launchIntent);
            //}
            //return true;
        }

        
    }


    
    private class ShareAcitivityChooserModelPolicy implements OnChooseActivityListener {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.493 -0400", hash_original_method = "89F1CDD786658ECF01B61D572BA79B4B", hash_generated_method = "89F1CDD786658ECF01B61D572BA79B4B")
        public ShareAcitivityChooserModelPolicy ()
        {
            //Synthesized constructor
        }


        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.493 -0400", hash_original_method = "5A8A50866214BBC9FA1FE4AEB29A128B", hash_generated_method = "4E9B355457F6EB7205C141605294D1B2")
        @Override
        public boolean onChooseActivity(ActivityChooserModel host, Intent intent) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(intent.getTaint());
            addTaint(host.getTaint());
    if(mOnShareTargetSelectedListener != null)            
            {
                boolean var7345B9C57E448381055B9FEB25B2B688_884257069 = (mOnShareTargetSelectedListener.onShareTargetSelected(
                        ShareActionProvider.this, intent));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_842356166 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_842356166;
            } //End block
            boolean var68934A3E9455FA72420237EB05902327_765668482 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_723236218 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_723236218;
            // ---------- Original Method ----------
            //if (mOnShareTargetSelectedListener != null) {
                //return mOnShareTargetSelectedListener.onShareTargetSelected(
                        //ShareActionProvider.this, intent);
            //}
            //return false;
        }

        
    }


    
    public interface OnShareTargetSelectedListener {

        
        public boolean onShareTargetSelected(ShareActionProvider source, Intent intent);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.493 -0400", hash_original_field = "DBA5E48AD58D13A8457146CDE0032469", hash_generated_field = "92B8F76AAEC7AF7155BC287F38FE45EA")

    private static final int DEFAULT_INITIAL_ACTIVITY_COUNT = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:10.493 -0400", hash_original_field = "E39117B05E81EA4927DC04320778DB31", hash_generated_field = "1CB003B559FB29C1D53091AA377E4BB2")

    public static final String DEFAULT_SHARE_HISTORY_FILE_NAME = "share_history.xml";
}

