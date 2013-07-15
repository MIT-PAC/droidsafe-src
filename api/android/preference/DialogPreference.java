package android.preference;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public abstract class DialogPreference extends Preference implements DialogInterface.OnClickListener, DialogInterface.OnDismissListener, PreferenceManager.OnActivityDestroyListener {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.211 -0400", hash_original_field = "AB0228EB14569C0671EE8B2756FB9139", hash_generated_field = "42060B98383429459FECD4D4CDE8C54F")

    private AlertDialog.Builder mBuilder;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.211 -0400", hash_original_field = "AE0104648D77F28C33385D983BBEB3DF", hash_generated_field = "97697297384E83403579647D80580C36")

    private CharSequence mDialogTitle;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.211 -0400", hash_original_field = "4B1F495919E1D6621D275B43F70523A2", hash_generated_field = "613703FDAE1B8EC965EFFFE3F7B81D89")

    private CharSequence mDialogMessage;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.211 -0400", hash_original_field = "4E29CD354FF06BFB72BE15B427345580", hash_generated_field = "62F8B6A1225692AA3122E336B4C39371")

    private Drawable mDialogIcon;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.211 -0400", hash_original_field = "EF6BA7E2934EE938E1075151D930563A", hash_generated_field = "562EA9B33498318D41CCFBFB106A7B3C")

    private CharSequence mPositiveButtonText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.212 -0400", hash_original_field = "480C6129BEBC705E36C19ADB4B0F8B3C", hash_generated_field = "4083143E7FFA77B3CD0812A1312A7A80")

    private CharSequence mNegativeButtonText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.212 -0400", hash_original_field = "E217A30C43701DC625E41DA6F34EE4A0", hash_generated_field = "02541F76C3D2FBBAD006513FC4EED963")

    private int mDialogLayoutResId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.212 -0400", hash_original_field = "58806F2D99FD4DF33CF42E0C232738D7", hash_generated_field = "D9FAD0C1386FC50E3C837906841C2A70")

    private Dialog mDialog;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.212 -0400", hash_original_field = "6FE1386999760D87DB136D994EB480E5", hash_generated_field = "A305715F0BC591A0A9137CCA600B2C10")

    private int mWhichButtonClicked;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.213 -0400", hash_original_method = "0DCDE098692C34941ED8905F239ED21D", hash_generated_method = "21A5B39DAB4A2944283BD71EBA2D9B9E")
    public  DialogPreference(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        addTaint(defStyle);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        TypedArray a = context.obtainStyledAttributes(attrs,
                com.android.internal.R.styleable.DialogPreference, defStyle, 0);
        mDialogTitle = a.getString(com.android.internal.R.styleable.DialogPreference_dialogTitle);
    if(mDialogTitle == null)        
        {
            mDialogTitle = getTitle();
        } //End block
        mDialogMessage = a.getString(com.android.internal.R.styleable.DialogPreference_dialogMessage);
        mDialogIcon = a.getDrawable(com.android.internal.R.styleable.DialogPreference_dialogIcon);
        mPositiveButtonText = a.getString(com.android.internal.R.styleable.DialogPreference_positiveButtonText);
        mNegativeButtonText = a.getString(com.android.internal.R.styleable.DialogPreference_negativeButtonText);
        mDialogLayoutResId = a.getResourceId(com.android.internal.R.styleable.DialogPreference_dialogLayout,
                mDialogLayoutResId);
        a.recycle();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.214 -0400", hash_original_method = "60E52A3616503A9CD82A6F28FDC1EC0D", hash_generated_method = "7DC0B69FCCF790DB4973948C42EBBACE")
    public  DialogPreference(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.dialogPreferenceStyle);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.214 -0400", hash_original_method = "6BB18A84F76469D7C771F36F9E0BA9AF", hash_generated_method = "B45A5D7A1E3BCA4FD85953AD13DAF36B")
    public void setDialogTitle(CharSequence dialogTitle) {
        mDialogTitle = dialogTitle;
        // ---------- Original Method ----------
        //mDialogTitle = dialogTitle;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.214 -0400", hash_original_method = "8574D5B6827EC6804865DBFE054A884D", hash_generated_method = "921AF374EE02731466ED31538473BDD6")
    public void setDialogTitle(int dialogTitleResId) {
        addTaint(dialogTitleResId);
        setDialogTitle(getContext().getString(dialogTitleResId));
        // ---------- Original Method ----------
        //setDialogTitle(getContext().getString(dialogTitleResId));
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.215 -0400", hash_original_method = "883D8EFBB9B8BAD9BC22F78B210BA75B", hash_generated_method = "4ED7114F347ED709EDB056594AEAC942")
    public CharSequence getDialogTitle() {
CharSequence var8A283C630C420D29DA612FDBD4AF8034_1274371834 =         mDialogTitle;
        var8A283C630C420D29DA612FDBD4AF8034_1274371834.addTaint(taint);
        return var8A283C630C420D29DA612FDBD4AF8034_1274371834;
        // ---------- Original Method ----------
        //return mDialogTitle;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.215 -0400", hash_original_method = "C3473A1ED58058061356CFFBC848D9C9", hash_generated_method = "41887350F118ACBC0863E2AD4EC64C3B")
    public void setDialogMessage(CharSequence dialogMessage) {
        mDialogMessage = dialogMessage;
        // ---------- Original Method ----------
        //mDialogMessage = dialogMessage;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.215 -0400", hash_original_method = "15D4845E464A684E3158A3E73E2FE949", hash_generated_method = "5A1723810D2ECEB1D15DCB328B269301")
    public void setDialogMessage(int dialogMessageResId) {
        addTaint(dialogMessageResId);
        setDialogMessage(getContext().getString(dialogMessageResId));
        // ---------- Original Method ----------
        //setDialogMessage(getContext().getString(dialogMessageResId));
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.215 -0400", hash_original_method = "1C9FE66F99F199ED8416C6E4CD3A4269", hash_generated_method = "8E6A688870049561EA57EE7AD4284A50")
    public CharSequence getDialogMessage() {
CharSequence varAB9C41555832BFB23A354B68F953D4FB_1757340943 =         mDialogMessage;
        varAB9C41555832BFB23A354B68F953D4FB_1757340943.addTaint(taint);
        return varAB9C41555832BFB23A354B68F953D4FB_1757340943;
        // ---------- Original Method ----------
        //return mDialogMessage;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.216 -0400", hash_original_method = "B73A337DDB013C24C0D62280ED30F9C6", hash_generated_method = "94B3A71D2448291EB1B536AD4A297F55")
    public void setDialogIcon(Drawable dialogIcon) {
        mDialogIcon = dialogIcon;
        // ---------- Original Method ----------
        //mDialogIcon = dialogIcon;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.216 -0400", hash_original_method = "224A37AA492D9AAF37391FD4564E4780", hash_generated_method = "1F53ABCC2160D94BA60BF25B6B4C958F")
    public void setDialogIcon(int dialogIconRes) {
        mDialogIcon = getContext().getResources().getDrawable(dialogIconRes);
        // ---------- Original Method ----------
        //mDialogIcon = getContext().getResources().getDrawable(dialogIconRes);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.216 -0400", hash_original_method = "03DB966CB140533ECF1D4BDC15FA7B76", hash_generated_method = "96A817A9B80CB10A1C3C1BC917C18316")
    public Drawable getDialogIcon() {
Drawable var5FD070880F0D4515E94900111CD7523A_340278633 =         mDialogIcon;
        var5FD070880F0D4515E94900111CD7523A_340278633.addTaint(taint);
        return var5FD070880F0D4515E94900111CD7523A_340278633;
        // ---------- Original Method ----------
        //return mDialogIcon;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.216 -0400", hash_original_method = "6BE23B5D358DB766161BE60C1550EF9B", hash_generated_method = "15FCDB24219E94DB21B0A8028B4E9D51")
    public void setPositiveButtonText(CharSequence positiveButtonText) {
        mPositiveButtonText = positiveButtonText;
        // ---------- Original Method ----------
        //mPositiveButtonText = positiveButtonText;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.217 -0400", hash_original_method = "B063A8AED375BD92CBE4E8D46785B0F8", hash_generated_method = "C84D8ABBD12F840AD901C8AE0F8708B8")
    public void setPositiveButtonText(int positiveButtonTextResId) {
        addTaint(positiveButtonTextResId);
        setPositiveButtonText(getContext().getString(positiveButtonTextResId));
        // ---------- Original Method ----------
        //setPositiveButtonText(getContext().getString(positiveButtonTextResId));
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.217 -0400", hash_original_method = "82AFC23D5F7BC4989211310BE2784E8E", hash_generated_method = "07EE9F5C074A07AA3617A77FF045BBC5")
    public CharSequence getPositiveButtonText() {
CharSequence var9E414663F7FFDDEF3ACDFE53EB7D0FC4_1248655030 =         mPositiveButtonText;
        var9E414663F7FFDDEF3ACDFE53EB7D0FC4_1248655030.addTaint(taint);
        return var9E414663F7FFDDEF3ACDFE53EB7D0FC4_1248655030;
        // ---------- Original Method ----------
        //return mPositiveButtonText;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.217 -0400", hash_original_method = "4C31EAF97C896EDBAD876498CF3B2FF0", hash_generated_method = "3FA9845BDDD93E5FC8996CE304918DDD")
    public void setNegativeButtonText(CharSequence negativeButtonText) {
        mNegativeButtonText = negativeButtonText;
        // ---------- Original Method ----------
        //mNegativeButtonText = negativeButtonText;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.217 -0400", hash_original_method = "16BFB517EAB7183180ECF26DADA01F37", hash_generated_method = "BFDFECC79FF737543966030074D03A27")
    public void setNegativeButtonText(int negativeButtonTextResId) {
        addTaint(negativeButtonTextResId);
        setNegativeButtonText(getContext().getString(negativeButtonTextResId));
        // ---------- Original Method ----------
        //setNegativeButtonText(getContext().getString(negativeButtonTextResId));
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.218 -0400", hash_original_method = "AAC926564B2F61079BFED9FEE51EB7E4", hash_generated_method = "6A24C67C79E7D6AD3153C8B25F6E396A")
    public CharSequence getNegativeButtonText() {
CharSequence varE3CDB17A793C79B2095F0AE56CF77E73_481638680 =         mNegativeButtonText;
        varE3CDB17A793C79B2095F0AE56CF77E73_481638680.addTaint(taint);
        return varE3CDB17A793C79B2095F0AE56CF77E73_481638680;
        // ---------- Original Method ----------
        //return mNegativeButtonText;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.218 -0400", hash_original_method = "6047D08B9E02F6650B39EE0CB2356C47", hash_generated_method = "8C3214F68C80F820797B01AD29A03A7C")
    public void setDialogLayoutResource(int dialogLayoutResId) {
        mDialogLayoutResId = dialogLayoutResId;
        // ---------- Original Method ----------
        //mDialogLayoutResId = dialogLayoutResId;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.218 -0400", hash_original_method = "6161E3D2B6291A2C05BBD55D42C3AED0", hash_generated_method = "0EEDBD0ECA6866AC6F78568E9CE0F9E0")
    public int getDialogLayoutResource() {
        int varE217A30C43701DC625E41DA6F34EE4A0_37895948 = (mDialogLayoutResId);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1556555180 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1556555180;
        // ---------- Original Method ----------
        //return mDialogLayoutResId;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.218 -0400", hash_original_method = "9A579D55B073C910524B0A138ED58992", hash_generated_method = "3FE15FCBE90C74B4FDE26391C79AD091")
    protected void onPrepareDialogBuilder(AlertDialog.Builder builder) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(builder.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.219 -0400", hash_original_method = "D63055C4B5449F36C1385D3F75BC6CB0", hash_generated_method = "C75941BEB55E860D99AA4A9B7CDBF789")
    @Override
    protected void onClick() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        showDialog(null);
        // ---------- Original Method ----------
        //showDialog(null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.219 -0400", hash_original_method = "F05F4238EDB347ACAD0B24F734C6EC9A", hash_generated_method = "02A1920FB990FBB5D54343298041861E")
    protected void showDialog(Bundle state) {
        addTaint(state.getTaint());
        Context context = getContext();
        mWhichButtonClicked = DialogInterface.BUTTON_NEGATIVE;
        mBuilder = new AlertDialog.Builder(context)
            .setTitle(mDialogTitle)
            .setIcon(mDialogIcon)
            .setPositiveButton(mPositiveButtonText, this)
            .setNegativeButton(mNegativeButtonText, this);
        View contentView = onCreateDialogView();
    if(contentView != null)        
        {
            onBindDialogView(contentView);
            mBuilder.setView(contentView);
        } //End block
        else
        {
            mBuilder.setMessage(mDialogMessage);
        } //End block
        onPrepareDialogBuilder(mBuilder);
        getPreferenceManager().registerOnActivityDestroyListener(this);
        final Dialog dialog = mDialog = mBuilder.create();
    if(state != null)        
        {
            dialog.onRestoreInstanceState(state);
        } //End block
    if(needInputMethod())        
        {
            requestInputMethod(dialog);
        } //End block
        dialog.setOnDismissListener(this);
        dialog.show();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.220 -0400", hash_original_method = "E61813EC392C6A7361FD971C8A66C42E", hash_generated_method = "6201B30D0577093FA3E68E41FAAFA5AA")
    protected boolean needInputMethod() {
        boolean var68934A3E9455FA72420237EB05902327_311343428 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1687843719 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1687843719;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.220 -0400", hash_original_method = "3B69F31C6833A6156BA93E6BE7789317", hash_generated_method = "B3F792BA298537DB8052E460A8DB5496")
    private void requestInputMethod(Dialog dialog) {
        addTaint(dialog.getTaint());
        Window window = dialog.getWindow();
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        // ---------- Original Method ----------
        //Window window = dialog.getWindow();
        //window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.220 -0400", hash_original_method = "30915DC6B0C7508CE694D92B8515D200", hash_generated_method = "BC912AE4AA7BDEA863E7AFF6287B0EB3")
    protected View onCreateDialogView() {
        //DSFIXME:  CODE0009: Possible callback target function detected
    if(mDialogLayoutResId == 0)        
        {
View var540C13E9E156B687226421B24F2DF178_1085018689 =             null;
            var540C13E9E156B687226421B24F2DF178_1085018689.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1085018689;
        } //End block
        LayoutInflater inflater = LayoutInflater.from(mBuilder.getContext());
View var10DFF701F8E6B3A87243F69F93A3F708_618140305 =         inflater.inflate(mDialogLayoutResId, null);
        var10DFF701F8E6B3A87243F69F93A3F708_618140305.addTaint(taint);
        return var10DFF701F8E6B3A87243F69F93A3F708_618140305;
        // ---------- Original Method ----------
        //if (mDialogLayoutResId == 0) {
            //return null;
        //}
        //LayoutInflater inflater = LayoutInflater.from(mBuilder.getContext());
        //return inflater.inflate(mDialogLayoutResId, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.221 -0400", hash_original_method = "5B74FDBCA1C0676CAF2A41085AFE51F9", hash_generated_method = "4F26C4E3FB86C9D15AA546A69680DB42")
    protected void onBindDialogView(View view) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(view.getTaint());
        View dialogMessageView = view.findViewById(com.android.internal.R.id.message);
    if(dialogMessageView != null)        
        {
            final CharSequence message = getDialogMessage();
            int newVisibility = View.GONE;
    if(!TextUtils.isEmpty(message))            
            {
    if(dialogMessageView instanceof TextView)                
                {
                    ((TextView) dialogMessageView).setText(message);
                } //End block
                newVisibility = View.VISIBLE;
            } //End block
    if(dialogMessageView.getVisibility() != newVisibility)            
            {
                dialogMessageView.setVisibility(newVisibility);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //View dialogMessageView = view.findViewById(com.android.internal.R.id.message);
        //if (dialogMessageView != null) {
            //final CharSequence message = getDialogMessage();
            //int newVisibility = View.GONE;
            //if (!TextUtils.isEmpty(message)) {
                //if (dialogMessageView instanceof TextView) {
                    //((TextView) dialogMessageView).setText(message);
                //}
                //newVisibility = View.VISIBLE;
            //}
            //if (dialogMessageView.getVisibility() != newVisibility) {
                //dialogMessageView.setVisibility(newVisibility);
            //}
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.221 -0400", hash_original_method = "C7A96C6C4A9A6F7800567BF8395F95D4", hash_generated_method = "FEDD0E6C73168D668F53DC5F0672C0CD")
    public void onClick(DialogInterface dialog, int which) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(dialog.getTaint());
        mWhichButtonClicked = which;
        // ---------- Original Method ----------
        //mWhichButtonClicked = which;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.222 -0400", hash_original_method = "4F73C1927BDEFF08475C0DA03B2F2CFE", hash_generated_method = "218083DB667C8DADC0E85D167572D0F3")
    public void onDismiss(DialogInterface dialog) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(dialog.getTaint());
        getPreferenceManager().unregisterOnActivityDestroyListener(this);
        mDialog = null;
        onDialogClosed(mWhichButtonClicked == DialogInterface.BUTTON_POSITIVE);
        // ---------- Original Method ----------
        //getPreferenceManager().unregisterOnActivityDestroyListener(this);
        //mDialog = null;
        //onDialogClosed(mWhichButtonClicked == DialogInterface.BUTTON_POSITIVE);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.222 -0400", hash_original_method = "C2C4DECBB4816C085EA1FCA9996FF5B6", hash_generated_method = "F839090159E8D268DD09FFE754CE51F0")
    protected void onDialogClosed(boolean positiveResult) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(positiveResult);
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.222 -0400", hash_original_method = "BFDF5D83CE787BE21817622D7064532F", hash_generated_method = "08987C1814454894A968321FC47E67AB")
    public Dialog getDialog() {
Dialog var91E8306796CF70F787962B1CE02ED969_668551769 =         mDialog;
        var91E8306796CF70F787962B1CE02ED969_668551769.addTaint(taint);
        return var91E8306796CF70F787962B1CE02ED969_668551769;
        // ---------- Original Method ----------
        //return mDialog;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.223 -0400", hash_original_method = "FC837FC4F2E0A243643D6D2D742CA26C", hash_generated_method = "FFC26E6ED7D2BF19C3BB95C214DBE2F2")
    public void onActivityDestroy() {
        //DSFIXME:  CODE0009: Possible callback target function detected
    if(mDialog == null || !mDialog.isShowing())        
        {
            return;
        } //End block
        mDialog.dismiss();
        // ---------- Original Method ----------
        //if (mDialog == null || !mDialog.isShowing()) {
            //return;
        //}
        //mDialog.dismiss();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.223 -0400", hash_original_method = "690D860013A43623DC1BE14E616673FB", hash_generated_method = "860401912A877788DDA38D9E9067E861")
    @Override
    protected Parcelable onSaveInstanceState() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        final Parcelable superState = super.onSaveInstanceState();
    if(mDialog == null || !mDialog.isShowing())        
        {
Parcelable varBA7A3E641095ABD11C9DBE16D47F122C_12081178 =             superState;
            varBA7A3E641095ABD11C9DBE16D47F122C_12081178.addTaint(taint);
            return varBA7A3E641095ABD11C9DBE16D47F122C_12081178;
        } //End block
        final SavedState myState = new SavedState(superState);
        myState.isDialogShowing = true;
        myState.dialogBundle = mDialog.onSaveInstanceState();
Parcelable varA730247CC64767D7A83D25979CFF71FB_1735215911 =         myState;
        varA730247CC64767D7A83D25979CFF71FB_1735215911.addTaint(taint);
        return varA730247CC64767D7A83D25979CFF71FB_1735215911;
        // ---------- Original Method ----------
        //final Parcelable superState = super.onSaveInstanceState();
        //if (mDialog == null || !mDialog.isShowing()) {
            //return superState;
        //}
        //final SavedState myState = new SavedState(superState);
        //myState.isDialogShowing = true;
        //myState.dialogBundle = mDialog.onSaveInstanceState();
        //return myState;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.223 -0400", hash_original_method = "C506903F809F21792322FC067531E660", hash_generated_method = "8D1F140D5913A647832B8CB90D82789F")
    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(state.getTaint());
    if(state == null || !state.getClass().equals(SavedState.class))        
        {
            super.onRestoreInstanceState(state);
            return;
        } //End block
        SavedState myState = (SavedState) state;
        super.onRestoreInstanceState(myState.getSuperState());
    if(myState.isDialogShowing)        
        {
            showDialog(myState.dialogBundle);
        } //End block
        // ---------- Original Method ----------
        //if (state == null || !state.getClass().equals(SavedState.class)) {
            //super.onRestoreInstanceState(state);
            //return;
        //}
        //SavedState myState = (SavedState) state;
        //super.onRestoreInstanceState(myState.getSuperState());
        //if (myState.isDialogShowing) {
            //showDialog(myState.dialogBundle);
        //}
    }

    
    private static class SavedState extends BaseSavedState {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.224 -0400", hash_original_field = "C75608B67599FA6C902BFE4C625014D1", hash_generated_field = "C67FBD06D119E38CE3CCD57D66AB1C18")

        boolean isDialogShowing;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.224 -0400", hash_original_field = "3E858F45950CD4CFB6443ACE660B1208", hash_generated_field = "7FEB9968C654EBDB6E3D8BB294FB242A")

        Bundle dialogBundle;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.224 -0400", hash_original_method = "EF20CF8D7035837CBAB7B591A73E7119", hash_generated_method = "235A6412ECD5B38AB4470FD695A9633B")
        public  SavedState(Parcel source) {
            super(source);
            isDialogShowing = source.readInt() == 1;
            dialogBundle = source.readBundle();
            // ---------- Original Method ----------
            //isDialogShowing = source.readInt() == 1;
            //dialogBundle = source.readBundle();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.224 -0400", hash_original_method = "89EB4EC154F05BF905ECA8E02BBD14BC", hash_generated_method = "AB11810075E98F66089A29D0DD89C4B4")
        public  SavedState(Parcelable superState) {
            super(superState);
            addTaint(superState.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.225 -0400", hash_original_method = "85259FDDC0FCC1496FED09E1FEFE0DC2", hash_generated_method = "C502B78D5FDDE7BB7675DF37B837C744")
        @Override
        public void writeToParcel(Parcel dest, int flags) {
            addTaint(flags);
            addTaint(dest.getTaint());
            super.writeToParcel(dest, flags);
            dest.writeInt(isDialogShowing ? 1 : 0);
            dest.writeBundle(dialogBundle);
            // ---------- Original Method ----------
            //super.writeToParcel(dest, flags);
            //dest.writeInt(isDialogShowing ? 1 : 0);
            //dest.writeBundle(dialogBundle);
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.225 -0400", hash_original_field = "7DF6FB2587CB67E9544A859A8F6E8FF3", hash_generated_field = "263FCDD65C2156B1D1E1B4D9AE8D7FFA")

        public static final Parcelable.Creator<SavedState> CREATOR =
                new Parcelable.Creator<SavedState>() {
            public SavedState createFromParcel(Parcel in) {
                return new SavedState(in);
            }

            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        };
        // orphaned legacy method
        public SavedState createFromParcel(Parcel in) {
                return new SavedState(in);
            }
        
        // orphaned legacy method
        public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        
    }


    
}

