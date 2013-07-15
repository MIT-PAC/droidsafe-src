package android.preference;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.776 -0400", hash_original_field = "AB0228EB14569C0671EE8B2756FB9139", hash_generated_field = "42060B98383429459FECD4D4CDE8C54F")

    private AlertDialog.Builder mBuilder;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.776 -0400", hash_original_field = "AE0104648D77F28C33385D983BBEB3DF", hash_generated_field = "97697297384E83403579647D80580C36")

    private CharSequence mDialogTitle;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.776 -0400", hash_original_field = "4B1F495919E1D6621D275B43F70523A2", hash_generated_field = "613703FDAE1B8EC965EFFFE3F7B81D89")

    private CharSequence mDialogMessage;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.776 -0400", hash_original_field = "4E29CD354FF06BFB72BE15B427345580", hash_generated_field = "62F8B6A1225692AA3122E336B4C39371")

    private Drawable mDialogIcon;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.776 -0400", hash_original_field = "EF6BA7E2934EE938E1075151D930563A", hash_generated_field = "562EA9B33498318D41CCFBFB106A7B3C")

    private CharSequence mPositiveButtonText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.776 -0400", hash_original_field = "480C6129BEBC705E36C19ADB4B0F8B3C", hash_generated_field = "4083143E7FFA77B3CD0812A1312A7A80")

    private CharSequence mNegativeButtonText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.776 -0400", hash_original_field = "E217A30C43701DC625E41DA6F34EE4A0", hash_generated_field = "02541F76C3D2FBBAD006513FC4EED963")

    private int mDialogLayoutResId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.776 -0400", hash_original_field = "58806F2D99FD4DF33CF42E0C232738D7", hash_generated_field = "D9FAD0C1386FC50E3C837906841C2A70")

    private Dialog mDialog;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.776 -0400", hash_original_field = "6FE1386999760D87DB136D994EB480E5", hash_generated_field = "A305715F0BC591A0A9137CCA600B2C10")

    private int mWhichButtonClicked;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.777 -0400", hash_original_method = "0DCDE098692C34941ED8905F239ED21D", hash_generated_method = "7F1E9C9ADF4B0C4ACD01B67500CA0E7E")
    public  DialogPreference(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        TypedArray a = context.obtainStyledAttributes(attrs,
                com.android.internal.R.styleable.DialogPreference, defStyle, 0);
        mDialogTitle = a.getString(com.android.internal.R.styleable.DialogPreference_dialogTitle);
        {
            mDialogTitle = getTitle();
        } 
        mDialogMessage = a.getString(com.android.internal.R.styleable.DialogPreference_dialogMessage);
        mDialogIcon = a.getDrawable(com.android.internal.R.styleable.DialogPreference_dialogIcon);
        mPositiveButtonText = a.getString(com.android.internal.R.styleable.DialogPreference_positiveButtonText);
        mNegativeButtonText = a.getString(com.android.internal.R.styleable.DialogPreference_negativeButtonText);
        mDialogLayoutResId = a.getResourceId(com.android.internal.R.styleable.DialogPreference_dialogLayout,
                mDialogLayoutResId);
        a.recycle();
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        addTaint(defStyle);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.777 -0400", hash_original_method = "60E52A3616503A9CD82A6F28FDC1EC0D", hash_generated_method = "1963798F12E782A0A0505F5BEEC9C4A7")
    public  DialogPreference(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.dialogPreferenceStyle);
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.778 -0400", hash_original_method = "6BB18A84F76469D7C771F36F9E0BA9AF", hash_generated_method = "B45A5D7A1E3BCA4FD85953AD13DAF36B")
    public void setDialogTitle(CharSequence dialogTitle) {
        mDialogTitle = dialogTitle;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.778 -0400", hash_original_method = "8574D5B6827EC6804865DBFE054A884D", hash_generated_method = "1B092C76E8B13740E2EDC530BD936D72")
    public void setDialogTitle(int dialogTitleResId) {
        setDialogTitle(getContext().getString(dialogTitleResId));
        addTaint(dialogTitleResId);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.779 -0400", hash_original_method = "883D8EFBB9B8BAD9BC22F78B210BA75B", hash_generated_method = "7AA7993C77A81B3DDFD47C560C2F151E")
    public CharSequence getDialogTitle() {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1021678320 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1021678320 = mDialogTitle;
        varB4EAC82CA7396A68D541C85D26508E83_1021678320.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1021678320;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.780 -0400", hash_original_method = "C3473A1ED58058061356CFFBC848D9C9", hash_generated_method = "41887350F118ACBC0863E2AD4EC64C3B")
    public void setDialogMessage(CharSequence dialogMessage) {
        mDialogMessage = dialogMessage;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.780 -0400", hash_original_method = "15D4845E464A684E3158A3E73E2FE949", hash_generated_method = "53656562B8B8706448C0A547B4AD91A9")
    public void setDialogMessage(int dialogMessageResId) {
        setDialogMessage(getContext().getString(dialogMessageResId));
        addTaint(dialogMessageResId);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.781 -0400", hash_original_method = "1C9FE66F99F199ED8416C6E4CD3A4269", hash_generated_method = "93FDC31353500AFCB0E0BD0756BF5D58")
    public CharSequence getDialogMessage() {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_411669991 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_411669991 = mDialogMessage;
        varB4EAC82CA7396A68D541C85D26508E83_411669991.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_411669991;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.781 -0400", hash_original_method = "B73A337DDB013C24C0D62280ED30F9C6", hash_generated_method = "94B3A71D2448291EB1B536AD4A297F55")
    public void setDialogIcon(Drawable dialogIcon) {
        mDialogIcon = dialogIcon;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.781 -0400", hash_original_method = "224A37AA492D9AAF37391FD4564E4780", hash_generated_method = "1F53ABCC2160D94BA60BF25B6B4C958F")
    public void setDialogIcon(int dialogIconRes) {
        mDialogIcon = getContext().getResources().getDrawable(dialogIconRes);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.782 -0400", hash_original_method = "03DB966CB140533ECF1D4BDC15FA7B76", hash_generated_method = "6FB46E8567B337FD45FB9B260A0DDC14")
    public Drawable getDialogIcon() {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_830025985 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_830025985 = mDialogIcon;
        varB4EAC82CA7396A68D541C85D26508E83_830025985.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_830025985;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.782 -0400", hash_original_method = "6BE23B5D358DB766161BE60C1550EF9B", hash_generated_method = "15FCDB24219E94DB21B0A8028B4E9D51")
    public void setPositiveButtonText(CharSequence positiveButtonText) {
        mPositiveButtonText = positiveButtonText;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.783 -0400", hash_original_method = "B063A8AED375BD92CBE4E8D46785B0F8", hash_generated_method = "05A59BF24CA9B7568ED65B76744251E4")
    public void setPositiveButtonText(int positiveButtonTextResId) {
        setPositiveButtonText(getContext().getString(positiveButtonTextResId));
        addTaint(positiveButtonTextResId);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.783 -0400", hash_original_method = "82AFC23D5F7BC4989211310BE2784E8E", hash_generated_method = "F99163BEFD5A8F9B91D0079C0C7E819A")
    public CharSequence getPositiveButtonText() {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1181964201 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1181964201 = mPositiveButtonText;
        varB4EAC82CA7396A68D541C85D26508E83_1181964201.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1181964201;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.783 -0400", hash_original_method = "4C31EAF97C896EDBAD876498CF3B2FF0", hash_generated_method = "3FA9845BDDD93E5FC8996CE304918DDD")
    public void setNegativeButtonText(CharSequence negativeButtonText) {
        mNegativeButtonText = negativeButtonText;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.784 -0400", hash_original_method = "16BFB517EAB7183180ECF26DADA01F37", hash_generated_method = "604AD2A423F3B93C7F5B15D9E9C49861")
    public void setNegativeButtonText(int negativeButtonTextResId) {
        setNegativeButtonText(getContext().getString(negativeButtonTextResId));
        addTaint(negativeButtonTextResId);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.784 -0400", hash_original_method = "AAC926564B2F61079BFED9FEE51EB7E4", hash_generated_method = "A78A54A552CC44F0BF0C583BA00F7315")
    public CharSequence getNegativeButtonText() {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1001104361 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1001104361 = mNegativeButtonText;
        varB4EAC82CA7396A68D541C85D26508E83_1001104361.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1001104361;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.785 -0400", hash_original_method = "6047D08B9E02F6650B39EE0CB2356C47", hash_generated_method = "8C3214F68C80F820797B01AD29A03A7C")
    public void setDialogLayoutResource(int dialogLayoutResId) {
        mDialogLayoutResId = dialogLayoutResId;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.785 -0400", hash_original_method = "6161E3D2B6291A2C05BBD55D42C3AED0", hash_generated_method = "F2F2FF105B8731599F8F712E9B01B25E")
    public int getDialogLayoutResource() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1689513878 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1689513878;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.785 -0400", hash_original_method = "9A579D55B073C910524B0A138ED58992", hash_generated_method = "3FE15FCBE90C74B4FDE26391C79AD091")
    protected void onPrepareDialogBuilder(AlertDialog.Builder builder) {
        
        addTaint(builder.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.785 -0400", hash_original_method = "D63055C4B5449F36C1385D3F75BC6CB0", hash_generated_method = "C75941BEB55E860D99AA4A9B7CDBF789")
    @Override
    protected void onClick() {
        
        showDialog(null);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.786 -0400", hash_original_method = "F05F4238EDB347ACAD0B24F734C6EC9A", hash_generated_method = "37F68DBD3B8C7C88DC62F23F8ADBE5A3")
    protected void showDialog(Bundle state) {
        Context context = getContext();
        mWhichButtonClicked = DialogInterface.BUTTON_NEGATIVE;
        mBuilder = new AlertDialog.Builder(context)
            .setTitle(mDialogTitle)
            .setIcon(mDialogIcon)
            .setPositiveButton(mPositiveButtonText, this)
            .setNegativeButton(mNegativeButtonText, this);
        View contentView = onCreateDialogView();
        {
            onBindDialogView(contentView);
            mBuilder.setView(contentView);
        } 
        {
            mBuilder.setMessage(mDialogMessage);
        } 
        onPrepareDialogBuilder(mBuilder);
        getPreferenceManager().registerOnActivityDestroyListener(this);
        final Dialog dialog = mDialog = mBuilder.create();
        {
            dialog.onRestoreInstanceState(state);
        } 
        {
            boolean var80CAD4A61AC1D3C5BA1CD7F74E3BD7D0_916337834 = (needInputMethod());
            {
                requestInputMethod(dialog);
            } 
        } 
        dialog.setOnDismissListener(this);
        dialog.show();
        addTaint(state.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.786 -0400", hash_original_method = "E61813EC392C6A7361FD971C8A66C42E", hash_generated_method = "7DF1F824B9B3CFFBC531DFFF547BB767")
    protected boolean needInputMethod() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_125553877 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_125553877;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.787 -0400", hash_original_method = "3B69F31C6833A6156BA93E6BE7789317", hash_generated_method = "8E0612D4923C0CB29E3A31C50B3A8FC1")
    private void requestInputMethod(Dialog dialog) {
        Window window = dialog.getWindow();
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        addTaint(dialog.getTaint());
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.787 -0400", hash_original_method = "30915DC6B0C7508CE694D92B8515D200", hash_generated_method = "89F2E170FA3C0EE5BED4E4F62F3F9741")
    protected View onCreateDialogView() {
        
        View varB4EAC82CA7396A68D541C85D26508E83_198564984 = null; 
        View varB4EAC82CA7396A68D541C85D26508E83_153168340 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_198564984 = null;
        } 
        LayoutInflater inflater = LayoutInflater.from(mBuilder.getContext());
        varB4EAC82CA7396A68D541C85D26508E83_153168340 = inflater.inflate(mDialogLayoutResId, null);
        View varA7E53CE21691AB073D9660D615818899_455506576; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_455506576 = varB4EAC82CA7396A68D541C85D26508E83_198564984;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_455506576 = varB4EAC82CA7396A68D541C85D26508E83_153168340;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_455506576.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_455506576;
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.788 -0400", hash_original_method = "5B74FDBCA1C0676CAF2A41085AFE51F9", hash_generated_method = "08294273B59F8E5723B7B1A8317A2BF4")
    protected void onBindDialogView(View view) {
        
        View dialogMessageView = view.findViewById(com.android.internal.R.id.message);
        {
            final CharSequence message = getDialogMessage();
            int newVisibility = View.GONE;
            {
                boolean var358940EC1666A9802A3FB0CBD1923483_1291130546 = (!TextUtils.isEmpty(message));
                {
                    {
                        ((TextView) dialogMessageView).setText(message);
                    } 
                    newVisibility = View.VISIBLE;
                } 
            } 
            {
                boolean varA3947E274D511054F4D862B152D1B5BE_1532893398 = (dialogMessageView.getVisibility() != newVisibility);
                {
                    dialogMessageView.setVisibility(newVisibility);
                } 
            } 
        } 
        addTaint(view.getTaint());
        
        
        
            
            
            
                
                    
                
                
            
            
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.789 -0400", hash_original_method = "C7A96C6C4A9A6F7800567BF8395F95D4", hash_generated_method = "97AEC77CFC989B38A65EAAB93DA39550")
    public void onClick(DialogInterface dialog, int which) {
        
        mWhichButtonClicked = which;
        addTaint(dialog.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.789 -0400", hash_original_method = "4F73C1927BDEFF08475C0DA03B2F2CFE", hash_generated_method = "C0F50E80D9B705F3B489D62FFF988C18")
    public void onDismiss(DialogInterface dialog) {
        
        getPreferenceManager().unregisterOnActivityDestroyListener(this);
        mDialog = null;
        onDialogClosed(mWhichButtonClicked == DialogInterface.BUTTON_POSITIVE);
        addTaint(dialog.getTaint());
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.790 -0400", hash_original_method = "C2C4DECBB4816C085EA1FCA9996FF5B6", hash_generated_method = "F839090159E8D268DD09FFE754CE51F0")
    protected void onDialogClosed(boolean positiveResult) {
        
        addTaint(positiveResult);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.791 -0400", hash_original_method = "BFDF5D83CE787BE21817622D7064532F", hash_generated_method = "D4DFCE7551CD4D58AB597D5210E6E626")
    public Dialog getDialog() {
        Dialog varB4EAC82CA7396A68D541C85D26508E83_1438374305 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1438374305 = mDialog;
        varB4EAC82CA7396A68D541C85D26508E83_1438374305.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1438374305;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.792 -0400", hash_original_method = "FC837FC4F2E0A243643D6D2D742CA26C", hash_generated_method = "7250C6486A70CCDE26EDDB4DA04089D4")
    public void onActivityDestroy() {
        
        {
            boolean varF5698A1109E3A400AEBA99FA3B5D019E_116415313 = (mDialog == null || !mDialog.isShowing());
        } 
        mDialog.dismiss();
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.793 -0400", hash_original_method = "690D860013A43623DC1BE14E616673FB", hash_generated_method = "7BC83ACC6820EA76780810497AD4B245")
    @Override
    protected Parcelable onSaveInstanceState() {
        
        Parcelable varB4EAC82CA7396A68D541C85D26508E83_1783391274 = null; 
        Parcelable varB4EAC82CA7396A68D541C85D26508E83_588413730 = null; 
        final Parcelable superState = super.onSaveInstanceState();
        {
            boolean varF5698A1109E3A400AEBA99FA3B5D019E_1305120983 = (mDialog == null || !mDialog.isShowing());
            {
                varB4EAC82CA7396A68D541C85D26508E83_1783391274 = superState;
            } 
        } 
        final SavedState myState = new SavedState(superState);
        myState.isDialogShowing = true;
        myState.dialogBundle = mDialog.onSaveInstanceState();
        varB4EAC82CA7396A68D541C85D26508E83_588413730 = myState;
        Parcelable varA7E53CE21691AB073D9660D615818899_1896754613; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1896754613 = varB4EAC82CA7396A68D541C85D26508E83_1783391274;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1896754613 = varB4EAC82CA7396A68D541C85D26508E83_588413730;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1896754613.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1896754613;
        
        
        
            
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.793 -0400", hash_original_method = "C506903F809F21792322FC067531E660", hash_generated_method = "63D849619B108878F2DABAF775E62205")
    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        
        {
            boolean var9146082C23BCEB2285F1054C3B9F84EE_887219111 = (state == null || !state.getClass().equals(SavedState.class));
            {
                super.onRestoreInstanceState(state);
            } 
        } 
        SavedState myState = (SavedState) state;
        super.onRestoreInstanceState(myState.getSuperState());
        {
            showDialog(myState.dialogBundle);
        } 
        addTaint(state.getTaint());
        
        
            
            
        
        
        
        
            
        
    }

    
    private static class SavedState extends BaseSavedState {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.793 -0400", hash_original_field = "C75608B67599FA6C902BFE4C625014D1", hash_generated_field = "C67FBD06D119E38CE3CCD57D66AB1C18")

        boolean isDialogShowing;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.793 -0400", hash_original_field = "3E858F45950CD4CFB6443ACE660B1208", hash_generated_field = "7FEB9968C654EBDB6E3D8BB294FB242A")

        Bundle dialogBundle;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.794 -0400", hash_original_method = "EF20CF8D7035837CBAB7B591A73E7119", hash_generated_method = "235A6412ECD5B38AB4470FD695A9633B")
        public  SavedState(Parcel source) {
            super(source);
            isDialogShowing = source.readInt() == 1;
            dialogBundle = source.readBundle();
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.794 -0400", hash_original_method = "89EB4EC154F05BF905ECA8E02BBD14BC", hash_generated_method = "AB11810075E98F66089A29D0DD89C4B4")
        public  SavedState(Parcelable superState) {
            super(superState);
            addTaint(superState.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.795 -0400", hash_original_method = "85259FDDC0FCC1496FED09E1FEFE0DC2", hash_generated_method = "CDA661218377A8A5886E4CAE8BCD484D")
        @Override
        public void writeToParcel(Parcel dest, int flags) {
            super.writeToParcel(dest, flags);
            dest.writeInt(isDialogShowing ? 1 : 0);
            dest.writeBundle(dialogBundle);
            addTaint(dest.getTaint());
            addTaint(flags);
            
            
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.795 -0400", hash_original_field = "7DF6FB2587CB67E9544A859A8F6E8FF3", hash_generated_field = "263FCDD65C2156B1D1E1B4D9AE8D7FFA")

        public static final Parcelable.Creator<SavedState> CREATOR =
                new Parcelable.Creator<SavedState>() {
            public SavedState createFromParcel(Parcel in) {
                return new SavedState(in);
            }

            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        };
        
        public SavedState createFromParcel(Parcel in) {
                return new SavedState(in);
            }
        
        
        public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        
    }


    
}

