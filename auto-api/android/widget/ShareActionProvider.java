package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.590 -0400", hash_original_field = "E80075D82EAA0135CBEAE00EBB5C22F2", hash_generated_field = "B8F76B4F7281B5BE96A33CBC1F738330")

    private int mMaxShownActivityCount = DEFAULT_INITIAL_ACTIVITY_COUNT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.590 -0400", hash_original_field = "918E3BF7E8558F9A63E5E3E0CD2B5FC9", hash_generated_field = "3BCC164682A6F9B750CD2C05E64D5875")

    private ShareMenuItemOnMenuItemClickListener mOnMenuItemClickListener = new ShareMenuItemOnMenuItemClickListener();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.590 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.590 -0400", hash_original_field = "58F3DD0C912C2149B0A7DBE1281E3D36", hash_generated_field = "7409E28971D0B0DB16EF85249AF9A2B4")

    private String mShareHistoryFileName = DEFAULT_SHARE_HISTORY_FILE_NAME;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.590 -0400", hash_original_field = "A6B19BE7036BB46AD6B88DDC6E33E808", hash_generated_field = "8D0302721DF93B0058B1E99D4AC6931D")

    private OnShareTargetSelectedListener mOnShareTargetSelectedListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.590 -0400", hash_original_field = "8A455BA14A92DE6792CD41FFAC5E0D78", hash_generated_field = "A3948F7FA69A8ECB6B19574CCCA8D09F")

    private OnChooseActivityListener mOnChooseActivityListener;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.602 -0400", hash_original_method = "D37DD9362CC0C7C9F17F614AA422CDA5", hash_generated_method = "3B8A6FFB44CD73DC8EB7E48875E8744E")
    public  ShareActionProvider(Context context) {
        super(context);
        mContext = context;
        // ---------- Original Method ----------
        //mContext = context;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.603 -0400", hash_original_method = "AF132A5C7109C48F5C74FEA83B1BA0C7", hash_generated_method = "CCA39642DF748CC4F4D53F64BD382B2B")
    public void setOnShareTargetSelectedListener(OnShareTargetSelectedListener listener) {
        mOnShareTargetSelectedListener = listener;
        setActivityChooserPolicyIfNeeded();
        // ---------- Original Method ----------
        //mOnShareTargetSelectedListener = listener;
        //setActivityChooserPolicyIfNeeded();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.604 -0400", hash_original_method = "457E9B3A86A4C9D09DD81D115C288523", hash_generated_method = "A184DBA83E17194DAF82F1DD49B6FF44")
    @Override
    public View onCreateActionView() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        View varB4EAC82CA7396A68D541C85D26508E83_274675574 = null; //Variable for return #1
        ActivityChooserModel dataModel;
        dataModel = ActivityChooserModel.get(mContext, mShareHistoryFileName);
        ActivityChooserView activityChooserView;
        activityChooserView = new ActivityChooserView(mContext);
        activityChooserView.setActivityChooserModel(dataModel);
        TypedValue outTypedValue;
        outTypedValue = new TypedValue();
        mContext.getTheme().resolveAttribute(R.attr.actionModeShareDrawable, outTypedValue, true);
        Drawable drawable;
        drawable = mContext.getResources().getDrawable(outTypedValue.resourceId);
        activityChooserView.setExpandActivityOverflowButtonDrawable(drawable);
        activityChooserView.setProvider(this);
        activityChooserView.setDefaultActionButtonContentDescription(
                R.string.shareactionprovider_share_with_application);
        activityChooserView.setExpandActivityOverflowButtonContentDescription(
                R.string.shareactionprovider_share_with);
        varB4EAC82CA7396A68D541C85D26508E83_274675574 = activityChooserView;
        varB4EAC82CA7396A68D541C85D26508E83_274675574.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_274675574;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.604 -0400", hash_original_method = "35CF29CD4DCA84D0FC63AC1A69E282B0", hash_generated_method = "47BBEADB555FAA4F2C2AFFA11FAA00D9")
    @Override
    public boolean hasSubMenu() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2038961450 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2038961450;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.605 -0400", hash_original_method = "780159D1510500332D77DB35C815CAE0", hash_generated_method = "E255BCA09E8C0D89B2FC6AC588F9E39A")
    @Override
    public void onPrepareSubMenu(SubMenu subMenu) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        subMenu.clear();
        ActivityChooserModel dataModel;
        dataModel = ActivityChooserModel.get(mContext, mShareHistoryFileName);
        PackageManager packageManager;
        packageManager = mContext.getPackageManager();
        int expandedActivityCount;
        expandedActivityCount = dataModel.getActivityCount();
        int collapsedActivityCount;
        collapsedActivityCount = Math.min(expandedActivityCount, mMaxShownActivityCount);
        {
            int i;
            i = 0;
            {
                ResolveInfo activity;
                activity = dataModel.getActivity(i);
                subMenu.add(0, i, i, activity.loadLabel(packageManager))
                .setIcon(activity.loadIcon(packageManager))
                .setOnMenuItemClickListener(mOnMenuItemClickListener);
            } //End block
        } //End collapsed parenthetic
        {
            SubMenu expandedSubMenu;
            expandedSubMenu = subMenu.addSubMenu(Menu.NONE, collapsedActivityCount,
                    collapsedActivityCount,
                    mContext.getString(R.string.activity_chooser_view_see_all));
            {
                int i;
                i = 0;
                {
                    ResolveInfo activity;
                    activity = dataModel.getActivity(i);
                    expandedSubMenu.add(0, i, i, activity.loadLabel(packageManager))
                    .setIcon(activity.loadIcon(packageManager))
                    .setOnMenuItemClickListener(mOnMenuItemClickListener);
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(subMenu.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.612 -0400", hash_original_method = "55B9AB4A16F0F7764FD2AA524BC9ED0A", hash_generated_method = "C123692B0FCCE5C2CFCA116B1DEE8740")
    public void setShareHistoryFileName(String shareHistoryFile) {
        mShareHistoryFileName = shareHistoryFile;
        setActivityChooserPolicyIfNeeded();
        // ---------- Original Method ----------
        //mShareHistoryFileName = shareHistoryFile;
        //setActivityChooserPolicyIfNeeded();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.612 -0400", hash_original_method = "0DAF31F3B630D54C36D98C14F5BC8D8F", hash_generated_method = "318C3781D5FB99D9871BE5BCAD4B5635")
    public void setShareIntent(Intent shareIntent) {
        ActivityChooserModel dataModel;
        dataModel = ActivityChooserModel.get(mContext,
            mShareHistoryFileName);
        dataModel.setIntent(shareIntent);
        addTaint(shareIntent.getTaint());
        // ---------- Original Method ----------
        //ActivityChooserModel dataModel = ActivityChooserModel.get(mContext,
            //mShareHistoryFileName);
        //dataModel.setIntent(shareIntent);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.613 -0400", hash_original_method = "5CBD2FEC274C7972832B56342BCF52F4", hash_generated_method = "E890A8F6C05D931C171EB2AB514E53EB")
    private void setActivityChooserPolicyIfNeeded() {
        {
            mOnChooseActivityListener = new ShareAcitivityChooserModelPolicy();
        } //End block
        ActivityChooserModel dataModel;
        dataModel = ActivityChooserModel.get(mContext, mShareHistoryFileName);
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.613 -0400", hash_original_method = "C6BD26BFC91AD355EDD4802746345224", hash_generated_method = "C6BD26BFC91AD355EDD4802746345224")
        public ShareMenuItemOnMenuItemClickListener ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.628 -0400", hash_original_method = "9C4E8B2E808FE0B52E60FC78C14CA469", hash_generated_method = "8A000F5F214FC32DCC93875F2E9C179E")
        @Override
        public boolean onMenuItemClick(MenuItem item) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            ActivityChooserModel dataModel;
            dataModel = ActivityChooserModel.get(mContext,
                    mShareHistoryFileName);
            int itemId;
            itemId = item.getItemId();
            Intent launchIntent;
            launchIntent = dataModel.chooseActivity(itemId);
            {
                mContext.startActivity(launchIntent);
            } //End block
            addTaint(item.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_923706950 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_923706950;
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.628 -0400", hash_original_method = "89F1CDD786658ECF01B61D572BA79B4B", hash_generated_method = "89F1CDD786658ECF01B61D572BA79B4B")
        public ShareAcitivityChooserModelPolicy ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.628 -0400", hash_original_method = "5A8A50866214BBC9FA1FE4AEB29A128B", hash_generated_method = "B5B6D3E2D1AC347E853DA4F923FE759D")
        @Override
        public boolean onChooseActivity(ActivityChooserModel host, Intent intent) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            {
                boolean varA017A0751FC8C1DCA427D1CE2F01B57B_108194967 = (mOnShareTargetSelectedListener.onShareTargetSelected(
                        ShareActionProvider.this, intent));
            } //End block
            addTaint(host.getTaint());
            addTaint(intent.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1365402440 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1365402440;
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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.629 -0400", hash_original_field = "DBA5E48AD58D13A8457146CDE0032469", hash_generated_field = "C9588461474EC8D3070C1A0615E961D8")

    private static int DEFAULT_INITIAL_ACTIVITY_COUNT = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:09.629 -0400", hash_original_field = "E39117B05E81EA4927DC04320778DB31", hash_generated_field = "1CB003B559FB29C1D53091AA377E4BB2")

    public static final String DEFAULT_SHARE_HISTORY_FILE_NAME = "share_history.xml";
}

