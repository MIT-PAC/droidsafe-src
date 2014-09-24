package android.widget;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:13.233 -0500", hash_original_field = "34EE3314F9DB54E68585F253DD85D08C", hash_generated_field = "92B8F76AAEC7AF7155BC287F38FE45EA")

    private static final int DEFAULT_INITIAL_ACTIVITY_COUNT = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:13.240 -0500", hash_original_field = "94E9563AA87AAABA6812D665689E77D3", hash_generated_field = "1CB003B559FB29C1D53091AA377E4BB2")

    public static final String DEFAULT_SHARE_HISTORY_FILE_NAME = "share_history.xml";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:13.236 -0500", hash_original_field = "B2541B73A076DEB3E51A9B0DC3991BB2", hash_generated_field = "B8F76B4F7281B5BE96A33CBC1F738330")

    private int mMaxShownActivityCount = DEFAULT_INITIAL_ACTIVITY_COUNT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:13.238 -0500", hash_original_field = "1E88B09EA16A8C1A1465168EEFD351DC", hash_generated_field = "3718A0AB49E217FA6EE98546A2005E61")

    private final ShareMenuItemOnMenuItemClickListener mOnMenuItemClickListener =
        new ShareMenuItemOnMenuItemClickListener();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:13.242 -0500", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private  Context mContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:13.245 -0500", hash_original_field = "B0DDE9C45BE36EE89075DF033570DAE9", hash_generated_field = "7409E28971D0B0DB16EF85249AF9A2B4")

    private String mShareHistoryFileName = DEFAULT_SHARE_HISTORY_FILE_NAME;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:13.247 -0500", hash_original_field = "14ABF3424D70483DB072A6166D335E25", hash_generated_field = "8D0302721DF93B0058B1E99D4AC6931D")

    private OnShareTargetSelectedListener mOnShareTargetSelectedListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:13.249 -0500", hash_original_field = "4E6DF115C423E32576A5D1CB98B81F8F", hash_generated_field = "A3948F7FA69A8ECB6B19574CCCA8D09F")

    private OnChooseActivityListener mOnChooseActivityListener;

    /**
     * Creates a new instance.
     *
     * @param context Context for accessing resources.
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:13.252 -0500", hash_original_method = "D37DD9362CC0C7C9F17F614AA422CDA5", hash_generated_method = "EB12F0C179FF5049530FB71B65E2D7EF")
    
public ShareActionProvider(Context context) {
        super(context);
        mContext = context;
    }

    /**
     * Sets a listener to be notified when a share target has been selected.
     * The listener can optionally decide to handle the selection and
     * not rely on the default behavior which is to launch the activity.
     * <p>
     * <strong>Note:</strong> If you choose the backing share history file
     *     you will still be notified in this callback.
     * </p>
     * @param listener The listener.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:13.254 -0500", hash_original_method = "AF132A5C7109C48F5C74FEA83B1BA0C7", hash_generated_method = "B8FE842239AA363CF03B3737C8FA23CD")
    
public void setOnShareTargetSelectedListener(OnShareTargetSelectedListener listener) {
        mOnShareTargetSelectedListener = listener;
        setActivityChooserPolicyIfNeeded();
    }

    /**
     * {@inheritDoc}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:13.257 -0500", hash_original_method = "457E9B3A86A4C9D09DD81D115C288523", hash_generated_method = "E07572EF0BC7910C642FC568B6409FD7")
    
@Override
    public View onCreateActionView() {
        // Create the view and set its data model.
        ActivityChooserModel dataModel = ActivityChooserModel.get(mContext, mShareHistoryFileName);
        ActivityChooserView activityChooserView = new ActivityChooserView(mContext);
        activityChooserView.setActivityChooserModel(dataModel);

        // Lookup and set the expand action icon.
        TypedValue outTypedValue = new TypedValue();
        mContext.getTheme().resolveAttribute(R.attr.actionModeShareDrawable, outTypedValue, true);
        Drawable drawable = mContext.getResources().getDrawable(outTypedValue.resourceId);
        activityChooserView.setExpandActivityOverflowButtonDrawable(drawable);
        activityChooserView.setProvider(this);

        // Set content description.
        activityChooserView.setDefaultActionButtonContentDescription(
                R.string.shareactionprovider_share_with_application);
        activityChooserView.setExpandActivityOverflowButtonContentDescription(
                R.string.shareactionprovider_share_with);

        return activityChooserView;
    }

    /**
     * {@inheritDoc}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:13.259 -0500", hash_original_method = "35CF29CD4DCA84D0FC63AC1A69E282B0", hash_generated_method = "CF1645D2E26EE80D0A742936B16D492A")
    
@Override
    public boolean hasSubMenu() {
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:13.262 -0500", hash_original_method = "780159D1510500332D77DB35C815CAE0", hash_generated_method = "0FAFC374C81773C7F1EB75B321D82417")
    
@Override
    public void onPrepareSubMenu(SubMenu subMenu) {
        // Clear since the order of items may change.
        subMenu.clear();

        ActivityChooserModel dataModel = ActivityChooserModel.get(mContext, mShareHistoryFileName);
        PackageManager packageManager = mContext.getPackageManager();

        final int expandedActivityCount = dataModel.getActivityCount();
        final int collapsedActivityCount = Math.min(expandedActivityCount, mMaxShownActivityCount);

        // Populate the sub-menu with a sub set of the activities.
        for (int i = 0; i < collapsedActivityCount; i++) {
            ResolveInfo activity = dataModel.getActivity(i);
            subMenu.add(0, i, i, activity.loadLabel(packageManager))
                .setIcon(activity.loadIcon(packageManager))
                .setOnMenuItemClickListener(mOnMenuItemClickListener);
        }

        if (collapsedActivityCount < expandedActivityCount) {
            // Add a sub-menu for showing all activities as a list item.
            SubMenu expandedSubMenu = subMenu.addSubMenu(Menu.NONE, collapsedActivityCount,
                    collapsedActivityCount,
                    mContext.getString(R.string.activity_chooser_view_see_all));
            for (int i = 0; i < expandedActivityCount; i++) {
                ResolveInfo activity = dataModel.getActivity(i);
                expandedSubMenu.add(0, i, i, activity.loadLabel(packageManager))
                    .setIcon(activity.loadIcon(packageManager))
                    .setOnMenuItemClickListener(mOnMenuItemClickListener);
            }
        }
    }

    /**
     * Sets the file name of a file for persisting the share history which
     * history will be used for ordering share targets. This file will be used
     * for all view created by {@link #onCreateActionView()}. Defaults to
     * {@link #DEFAULT_SHARE_HISTORY_FILE_NAME}. Set to <code>null</code>
     * if share history should not be persisted between sessions.
     * <p>
     * <strong>Note:</strong> The history file name can be set any time, however
     * only the action views created by {@link #onCreateActionView()} after setting
     * the file name will be backed by the provided file.
     * <p>
     *
     * @param shareHistoryFile The share history file name.
     */
    @DSComment("Sharing request")
    @DSSpec(DSCat.SHARING)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:13.264 -0500", hash_original_method = "55B9AB4A16F0F7764FD2AA524BC9ED0A", hash_generated_method = "03E0DA1D52ECA62A54D2669894C69150")
    
public void setShareHistoryFileName(String shareHistoryFile) {
        mShareHistoryFileName = shareHistoryFile;
        setActivityChooserPolicyIfNeeded();
    }
    
    private class ShareMenuItemOnMenuItemClickListener implements OnMenuItemClickListener {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.940 -0400", hash_original_method = "C6BD26BFC91AD355EDD4802746345224", hash_generated_method = "C6BD26BFC91AD355EDD4802746345224")
        public ShareMenuItemOnMenuItemClickListener ()
        {
            //Synthesized constructor
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:13.269 -0500", hash_original_method = "9C4E8B2E808FE0B52E60FC78C14CA469", hash_generated_method = "BCEB5A74B50F4C8F134CC96CC477B833")
        
@Override
        public boolean onMenuItemClick(MenuItem item) {
            ActivityChooserModel dataModel = ActivityChooserModel.get(mContext,
                    mShareHistoryFileName);
            final int itemId = item.getItemId();
            Intent launchIntent = dataModel.chooseActivity(itemId);
            if (launchIntent != null) {
                mContext.startActivity(launchIntent);
            }
            return true;
        }
        
    }
    
    private class ShareAcitivityChooserModelPolicy implements OnChooseActivityListener {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.940 -0400", hash_original_method = "89F1CDD786658ECF01B61D572BA79B4B", hash_generated_method = "89F1CDD786658ECF01B61D572BA79B4B")
        public ShareAcitivityChooserModelPolicy ()
        {
            //Synthesized constructor
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:13.276 -0500", hash_original_method = "5A8A50866214BBC9FA1FE4AEB29A128B", hash_generated_method = "28A7A415C8C8EBAB11FB98C6B1217E60")
        
@Override
        public boolean onChooseActivity(ActivityChooserModel host, Intent intent) {
            if (mOnShareTargetSelectedListener != null) {
                return mOnShareTargetSelectedListener.onShareTargetSelected(
                        ShareActionProvider.this, intent);
            }
            return false;
        }
        
    }
    
    public interface OnShareTargetSelectedListener {
        
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public boolean onShareTargetSelected(ShareActionProvider source, Intent intent);
    }

    /**
     * Sets an intent with information about the share action. Here is a
     * sample for constructing a share intent:
     * <p>
     * <pre>
     * <code>
     *  Intent shareIntent = new Intent(Intent.ACTION_SEND);
     *  shareIntent.setType("image/*");
     *  Uri uri = Uri.fromFile(new File(getFilesDir(), "foo.jpg"));
     *  shareIntent.putExtra(Intent.EXTRA_STREAM, uri.toString());
     * </pre>
     * </code>
     * </p>
     *
     * @param shareIntent The share intent.
     *
     * @see Intent#ACTION_SEND
     * @see Intent#ACTION_SEND_MULTIPLE
     */
    @DSComment("Potential intent to trigger other processing")
    @DSSpec(DSCat.INTENT_EXCHANGE)
    @DSSink({DSSinkKind.IPC})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:13.267 -0500", hash_original_method = "0DAF31F3B630D54C36D98C14F5BC8D8F", hash_generated_method = "CC784081647578CB91B85D7C5DF7179C")
    
public void setShareIntent(Intent shareIntent) {
        shareIntent.getAction();
        shareIntent.getBooleanArrayExtra("");
        shareIntent.getBooleanExtra("", false);
        shareIntent.getBundleExtra("");

        shareIntent.getFloatArrayExtra("");
        shareIntent.getFloatExtra("", 0.0f);

        shareIntent.getIntArrayExtra("");
        shareIntent.getIntExtra("", 0);

        shareIntent.getIntegerArrayListExtra("");
        shareIntent.getExtras();

        shareIntent.getLongArrayExtra("");
        shareIntent.getLongExtra("", 0);

        shareIntent.getParcelableArrayListExtra("");
        shareIntent.getParcelableArrayExtra("");
        shareIntent.getParcelableExtra("");

        shareIntent.getShortArrayExtra("");
        shareIntent.getShortExtra("", (short)0);

        shareIntent.getStringExtra("");
        shareIntent.getStringArrayExtra("");
        shareIntent.getStringArrayListExtra("");      

        shareIntent.getCharExtra("", 'a');
        shareIntent.getCharArrayExtra("");
        
        shareIntent.getCharSequenceArrayExtra("");
        shareIntent.getCharSequenceArrayListExtra("");
        shareIntent.getCharSequenceExtra("");              

        shareIntent.getData();
        shareIntent.getFlags();
        shareIntent.getType();
        shareIntent.getScheme();

        ActivityChooserModel dataModel = ActivityChooserModel.get(mContext,
            mShareHistoryFileName);
        dataModel.setIntent(shareIntent);
    }

    /**
     * Set the activity chooser policy of the model backed by the current
     * share history file if needed which is if there is a registered callback.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:13.273 -0500", hash_original_method = "5CBD2FEC274C7972832B56342BCF52F4", hash_generated_method = "C4C90C5DAE2924F19930082702F6F18A")
    
private void setActivityChooserPolicyIfNeeded() {
        if (mOnShareTargetSelectedListener == null) {
            return;
        }
        if (mOnChooseActivityListener == null) {
            mOnChooseActivityListener = new ShareAcitivityChooserModelPolicy();
        }
        ActivityChooserModel dataModel = ActivityChooserModel.get(mContext, mShareHistoryFileName);
        dataModel.setOnChooseActivityListener(mOnChooseActivityListener);
    }
}

