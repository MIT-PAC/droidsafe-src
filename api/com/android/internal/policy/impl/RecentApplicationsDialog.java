package com.android.internal.policy.impl;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.app.Dialog;
import android.content.pm.ResolveInfo;
import android.view.View.OnClickListener;
import java.util.List;
import android.util.Log;
import android.view.WindowManager;
import android.app.ActivityManager;
import android.view.View;
import android.graphics.drawable.Drawable;
import android.widget.TextView;
import android.app.StatusBarManager;
import android.os.Bundle;
import android.view.SoundEffectConstants;
import android.content.IntentFilter;
import android.content.BroadcastReceiver;
import android.content.pm.ActivityInfo;
import android.view.Window;
import android.content.Intent;
import android.content.Context;
import android.view.KeyEvent;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.content.ActivityNotFoundException;
public class RecentApplicationsDialog extends Dialog implements OnClickListener {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.159 -0400", hash_original_field = "FF560D30B382A51127465306693B9079", hash_generated_field = "6CB1D88527D79A9F04803F54CF20AA02")

    final TextView[] mIcons = new TextView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.159 -0400", hash_original_field = "7A6D8FFF7145AE68905DFAEE1FC420FB", hash_generated_field = "0815CA08654ADF6A31A6D549EA1CB52C")

    View mNoAppsText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.159 -0400", hash_original_field = "DC7339A2179E5580DEE85F505CB552C9", hash_generated_field = "F18E3FBE92AA3894DB52041E7C971ED5")

    IntentFilter mBroadcastIntentFilter = new IntentFilter(Intent.ACTION_CLOSE_SYSTEM_DIALOGS);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.159 -0400", hash_original_field = "6781893E9FA50A9B7103FD3F674E566B", hash_generated_field = "AD9C3D1E48D73BF1547D53C4C62401B2")

    Handler mHandler = new Handler();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.160 -0400", hash_original_field = "F6866C7DEC72F675E5B2AEF7369108A8", hash_generated_field = "5E34DB0EBB5E33DD9836C541F24D3A1F")

    Runnable mCleanup = new Runnable()    {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.160 -0400", hash_original_method = "EDC353C7528B2B0EDBB2B545C07C8A45", hash_generated_method = "A31E2C908E14A49F4A9893308FD3643C")
        public void run() {
for(TextView icon : mIcons)
            {
icon.setCompoundDrawables(null, null, null, null)icon.setTag(null)
            } //End block
            // ---------- Original Method ----------
            //for (TextView icon: mIcons) {
                //icon.setCompoundDrawables(null, null, null, null);
                //icon.setTag(null);
            //}
        }

        
    }
;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.161 -0400", hash_original_field = "56436E4C332A194D56A3326B16156C24", hash_generated_field = "840819455BBFCFE9CF93FCE21AFC64FD")

    private BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver()    {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.161 -0400", hash_original_method = "7208ABBF377A2C8971E05217D1FA91A6", hash_generated_method = "0EF6E04B54D59E35E01D6362A4E5D2CA")
        @Override
        public void onReceive(Context context, Intent intent) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(intent.getTaint());
            addTaint(context.getTaint());
            String action = intent.getAction();
            if(Intent.ACTION_CLOSE_SYSTEM_DIALOGS.equals(action))            
            {
                String reason = intent.getStringExtra(PhoneWindowManager.SYSTEM_DIALOG_REASON_KEY);
                if(!PhoneWindowManager.SYSTEM_DIALOG_REASON_RECENT_APPS.equals(reason))                
                {
dismiss()
                } //End block
            } //End block
            // ---------- Original Method ----------
            //String action = intent.getAction();
            //if (Intent.ACTION_CLOSE_SYSTEM_DIALOGS.equals(action)) {
                //String reason = intent.getStringExtra(PhoneWindowManager.SYSTEM_DIALOG_REASON_KEY);
                //if (! PhoneWindowManager.SYSTEM_DIALOG_REASON_RECENT_APPS.equals(reason)) {
                    //dismiss();
                //}
            //}
        }

        
    }
;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.162 -0400", hash_original_method = "E8513E3C39E6749C3662FB96F7D36DE1", hash_generated_method = "BC468655DDB577D71EAE177DCD7572CE")
    public  RecentApplicationsDialog(Context context) {
        super(context, com.android.internal.R.style.Theme_Dialog_RecentApplications);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.163 -0400", hash_original_method = "2B68FF9472CE52B4EA40165CDD03DBC9", hash_generated_method = "D9F101328A02BEE0F9B32248AAF9EE21")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(savedInstanceState.getTaint());
super.onCreate(savedInstanceState)        Context context = getContext();
        if(sStatusBar==null)        
        {
sStatusBar=(StatusBarManager) context.getSystemService(Context.STATUS_BAR_SERVICE)
        } //End block
        Window window = getWindow();
window.requestFeature(Window.FEATURE_NO_TITLE)window.setType(WindowManager.LayoutParams.TYPE_SYSTEM_DIALOG)window.setFlags(WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM, WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM)window.setTitle("Recents")setContentView(com.android.internal.R.layout.recent_apps_dialog)        final WindowManager.LayoutParams params = window.getAttributes();
params.width=WindowManager.LayoutParams.MATCH_PARENTparams.height=WindowManager.LayoutParams.MATCH_PARENTwindow.setAttributes(params)window.setFlags(0, WindowManager.LayoutParams.FLAG_DIM_BEHIND)mIcons[0]=(TextView) findViewById(com.android.internal.R.id.button0)mIcons[1]=(TextView) findViewById(com.android.internal.R.id.button1)mIcons[2]=(TextView) findViewById(com.android.internal.R.id.button2)mIcons[3]=(TextView) findViewById(com.android.internal.R.id.button3)mIcons[4]=(TextView) findViewById(com.android.internal.R.id.button4)mIcons[5]=(TextView) findViewById(com.android.internal.R.id.button5)mIcons[6]=(TextView) findViewById(com.android.internal.R.id.button6)mIcons[7]=(TextView) findViewById(com.android.internal.R.id.button7)mNoAppsText=findViewById(com.android.internal.R.id.no_applications_message)for(TextView b : mIcons)
        {
b.setOnClickListener(this)
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.164 -0400", hash_original_method = "EB93555C4AEA7BFFBCB5D804AD672EC1", hash_generated_method = "44310D362BE6383067FA7A55643CC4A0")
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        addTaint(keyCode);
        if(keyCode==KeyEvent.KEYCODE_TAB)        
        {
            final boolean backward = event.isShiftPressed();
            final int numIcons = mIcons.length;
            int numButtons = 0;
            while
(numButtons<numIcons&&mIcons[numButtons].getVisibility()==View.VISIBLE)            
            {
numButtons+=1
            } //End block
            if(numButtons!=0)            
            {
                int nextFocus = backward ? numButtons - 1 : 0;
for(int i = 0;i<numButtons;i)
                {
                    if(mIcons[i].hasFocus())                    
                    {
                        if(backward)                        
                        {
nextFocus=(i+numButtons-1)%numButtons
                        } //End block
                        else
                        {
nextFocus=(i+1)%numButtons
                        } //End block
                        break;
                    } //End block
                } //End block
                final int direction = backward ? View.FOCUS_BACKWARD : View.FOCUS_FORWARD;
                if(mIcons[nextFocus].requestFocus(direction))                
                {
mIcons[nextFocus].playSoundEffect(SoundEffectConstants.getContantForFocusDirection(direction))
                } //End block
            } //End block
            boolean varB326B5062B2F0E69046810717534CB09_1955946235 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1921042922 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1921042922;
        } //End block
        boolean var947F0C250323B9F4475E02588E9A9740_631494340 = (super.onKeyDown(keyCode, event));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1908291071 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1908291071;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.165 -0400", hash_original_method = "B941B77524ECC10D4963A679FD35DBD9", hash_generated_method = "3F050C303306D2365C337344346782AA")
    public void dismissAndSwitch() {
        final int numIcons = mIcons.length;
        RecentTag tag = null;
for(int i = 0;i<numIcons;i)
        {
            if(mIcons[i].getVisibility()!=View.VISIBLE)            
            {
                break;
            } //End block
            if(i==0||mIcons[i].hasFocus())            
            {
tag=(RecentTag) mIcons[i].getTag()                if(mIcons[i].hasFocus())                
                {
                    break;
                } //End block
            } //End block
        } //End block
        if(tag!=null)        
        {
switchTo(tag)
        } //End block
dismiss()
        // ---------- Original Method ----------
        //final int numIcons = mIcons.length;
        //RecentTag tag = null;
        //for (int i = 0; i < numIcons; i++) {
            //if (mIcons[i].getVisibility() != View.VISIBLE) {
                //break;
            //}
            //if (i == 0 || mIcons[i].hasFocus()) {
                //tag = (RecentTag) mIcons[i].getTag();
                //if (mIcons[i].hasFocus()) {
                    //break;
                //}
            //}
        //}
        //if (tag != null) {
            //switchTo(tag);
        //}
        //dismiss();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.166 -0400", hash_original_method = "1B991B805E1CF3DD9275E4EEB253837E", hash_generated_method = "5AB9B4E42D08A359ED4968ADF88CC0C3")
    public void onClick(View v) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(v.getTaint());
for(TextView b : mIcons)
        {
            if(b==v)            
            {
                RecentTag tag = (RecentTag)b.getTag();
switchTo(tag)                break;
            } //End block
        } //End block
dismiss()
        // ---------- Original Method ----------
        //for (TextView b: mIcons) {
            //if (b == v) {
                //RecentTag tag = (RecentTag)b.getTag();
                //switchTo(tag);
                //break;
            //}
        //}
        //dismiss();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.167 -0400", hash_original_method = "5EB68C7C8F8622CEAF0869D9A9557BF3", hash_generated_method = "FE95C93153331B4B9A12BF9EE9AA5D94")
    private void switchTo(RecentTag tag) {
        addTaint(tag.getTaint());
        if(tag.info.id>=0)        
        {
            final ActivityManager am = (ActivityManager)
                    getContext().getSystemService(Context.ACTIVITY_SERVICE);
am.moveTaskToFront(tag.info.id, ActivityManager.MOVE_TASK_WITH_HOME)
        } //End block
        else
        if(tag.intent!=null)        
        {
tag.intent.addFlags(Intent.FLAG_ACTIVITY_LAUNCHED_FROM_HISTORY|Intent.FLAG_ACTIVITY_TASK_ON_HOME)            try 
            {
getContext().startActivity(tag.intent)
            } //End block
            catch (ActivityNotFoundException e)
            {
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (tag.info.id >= 0) {
            //final ActivityManager am = (ActivityManager)
                    //getContext().getSystemService(Context.ACTIVITY_SERVICE);
            //am.moveTaskToFront(tag.info.id, ActivityManager.MOVE_TASK_WITH_HOME);
        //} else if (tag.intent != null) {
            //tag.intent.addFlags(Intent.FLAG_ACTIVITY_LAUNCHED_FROM_HISTORY
                    //| Intent.FLAG_ACTIVITY_TASK_ON_HOME);
            //try {
                //getContext().startActivity(tag.intent);
            //} catch (ActivityNotFoundException e) {
                //Log.w("Recent", "Unable to launch recent task", e);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.167 -0400", hash_original_method = "F0164715996B618128DAF3EAA141128B", hash_generated_method = "9B53AB347825E6EB2B22381E73697930")
    @Override
    public void onStart() {
        //DSFIXME:  CODE0009: Possible callback target function detected
super.onStart()reloadButtons()        if(sStatusBar!=null)        
        {
sStatusBar.disable(StatusBarManager.DISABLE_EXPAND)
        } //End block
getContext().registerReceiver(mBroadcastReceiver, mBroadcastIntentFilter)mHandler.removeCallbacks(mCleanup)
        // ---------- Original Method ----------
        //super.onStart();
        //reloadButtons();
        //if (sStatusBar != null) {
            //sStatusBar.disable(StatusBarManager.DISABLE_EXPAND);
        //}
        //getContext().registerReceiver(mBroadcastReceiver, mBroadcastIntentFilter);
        //mHandler.removeCallbacks(mCleanup);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.168 -0400", hash_original_method = "5B526611EAAC479A8F2025F9A83BBFCC", hash_generated_method = "4882C7823769E28639C4426927681AE8")
    @Override
    public void onStop() {
        //DSFIXME:  CODE0009: Possible callback target function detected
super.onStop()        if(sStatusBar!=null)        
        {
sStatusBar.disable(StatusBarManager.DISABLE_NONE)
        } //End block
getContext().unregisterReceiver(mBroadcastReceiver)mHandler.postDelayed(mCleanup, 100)
        // ---------- Original Method ----------
        //super.onStop();
        //if (sStatusBar != null) {
            //sStatusBar.disable(StatusBarManager.DISABLE_NONE);
        //}
        //getContext().unregisterReceiver(mBroadcastReceiver);
        //mHandler.postDelayed(mCleanup, 100);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.170 -0400", hash_original_method = "1883BC6BCBA28359DD35825796564E3B", hash_generated_method = "5FBB30C7A5324A208E01AE0202C6B21C")
    private void reloadButtons() {
        final Context context = getContext();
        final PackageManager pm = context.getPackageManager();
        final ActivityManager am = (ActivityManager)
                context.getSystemService(Context.ACTIVITY_SERVICE);
        final List<ActivityManager.RecentTaskInfo> recentTasks = am.getRecentTasks(MAX_RECENT_TASKS, ActivityManager.RECENT_IGNORE_UNAVAILABLE);
        ActivityInfo homeInfo = new Intent(Intent.ACTION_MAIN).addCategory(Intent.CATEGORY_HOME)
                    .resolveActivityInfo(pm, 0);
        IconUtilities iconUtilities = new IconUtilities(getContext());
        int index = 0;
        int numTasks = recentTasks.size();
for(int i = 0;i<numTasks&&(index<NUM_BUTTONS);++i)
        {
            final ActivityManager.RecentTaskInfo info = recentTasks.get(i);
            if(DBG_FORCE_EMPTY_LIST&&(i==0))            
            continue;
            Intent intent = new Intent(info.baseIntent);
            if(info.origActivity!=null)            
            {
intent.setComponent(info.origActivity)
            } //End block
            if(homeInfo!=null)            
            {
                if(homeInfo.packageName.equals(intent.getComponent().getPackageName())&&homeInfo.name.equals(intent.getComponent().getClassName()))                
                {
                    continue;
                } //End block
            } //End block
intent.setFlags((intent.getFlags()&~Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED)|Intent.FLAG_ACTIVITY_NEW_TASK)            final ResolveInfo resolveInfo = pm.resolveActivity(intent, 0);
            if(resolveInfo!=null)            
            {
                final ActivityInfo activityInfo = resolveInfo.activityInfo;
                final String title = activityInfo.loadLabel(pm).toString();
                Drawable icon = activityInfo.loadIcon(pm);
                if(title!=null&&title.length()>0&&icon!=null)                
                {
                    final TextView tv = mIcons[index];
tv.setText(title)icon=iconUtilities.createIconDrawable(icon)tv.setCompoundDrawables(null, icon, null, null)                    RecentTag tag = new RecentTag();
tag.info=infotag.intent=intenttv.setTag(tag)tv.setVisibility(View.VISIBLE)tv.setPressed(false)tv.clearFocus()++index
                } //End block
            } //End block
        } //End block
mNoAppsText.setVisibility((index==0)?View.VISIBLE:View.VISIBLE)for(;index<NUM_BUTTONS;++index)
        {
mIcons[index].setVisibility(View.GONE)
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    class RecentTag {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.171 -0400", hash_original_field = "CAF9B6B99962BF5C2264824231D7A40C", hash_generated_field = "81A735F56B3E99A280E5AEA293A1B224")

        ActivityManager.RecentTaskInfo info;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.171 -0400", hash_original_field = "FA48C7D544739BA0E46430E4BA366662", hash_generated_field = "170FCA7A98A65D8003A3D20D5B3C245D")

        Intent intent;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.172 -0400", hash_original_method = "D8F54614B17CC2FEED40E6BFA0E7FF94", hash_generated_method = "D8F54614B17CC2FEED40E6BFA0E7FF94")
        public RecentTag ()
        {
            //Synthesized constructor
        }


    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.172 -0400", hash_original_field = "65FC78E5B5A98F80450FB828E4159C30", hash_generated_field = "96D4C060BFBC582FC243255EC3333B67")

    private static final boolean DBG_FORCE_EMPTY_LIST = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.172 -0400", hash_original_field = "5AF09156654095EF481578D16FD0D500", hash_generated_field = "26282B0FEDC3E4F89520EA4932047F73")

    static private StatusBarManager sStatusBar;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.172 -0400", hash_original_field = "4D36AAE8649A815C5822455DE445F28A", hash_generated_field = "66B5E1AF2A86D78B8CB3047BEAC6B8BE")

    private static final int NUM_BUTTONS = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.172 -0400", hash_original_field = "9EA2FD43A4304CD8900BAC0A28F7CDEA", hash_generated_field = "B70A3A516D48760CAD3A1C9D8900C155")

    private static final int MAX_RECENT_TASKS = NUM_BUTTONS*2;
}

