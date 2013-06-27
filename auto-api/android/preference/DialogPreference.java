package android.preference;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.375 -0400", hash_original_field = "AB0228EB14569C0671EE8B2756FB9139", hash_generated_field = "42060B98383429459FECD4D4CDE8C54F")

    private AlertDialog.Builder mBuilder;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.375 -0400", hash_original_field = "AE0104648D77F28C33385D983BBEB3DF", hash_generated_field = "97697297384E83403579647D80580C36")

    private CharSequence mDialogTitle;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.375 -0400", hash_original_field = "4B1F495919E1D6621D275B43F70523A2", hash_generated_field = "613703FDAE1B8EC965EFFFE3F7B81D89")

    private CharSequence mDialogMessage;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.375 -0400", hash_original_field = "4E29CD354FF06BFB72BE15B427345580", hash_generated_field = "62F8B6A1225692AA3122E336B4C39371")

    private Drawable mDialogIcon;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.375 -0400", hash_original_field = "EF6BA7E2934EE938E1075151D930563A", hash_generated_field = "562EA9B33498318D41CCFBFB106A7B3C")

    private CharSequence mPositiveButtonText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.375 -0400", hash_original_field = "480C6129BEBC705E36C19ADB4B0F8B3C", hash_generated_field = "4083143E7FFA77B3CD0812A1312A7A80")

    private CharSequence mNegativeButtonText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.388 -0400", hash_original_field = "E217A30C43701DC625E41DA6F34EE4A0", hash_generated_field = "02541F76C3D2FBBAD006513FC4EED963")

    private int mDialogLayoutResId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.389 -0400", hash_original_field = "58806F2D99FD4DF33CF42E0C232738D7", hash_generated_field = "D9FAD0C1386FC50E3C837906841C2A70")

    private Dialog mDialog;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.389 -0400", hash_original_field = "6FE1386999760D87DB136D994EB480E5", hash_generated_field = "A305715F0BC591A0A9137CCA600B2C10")

    private int mWhichButtonClicked;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.390 -0400", hash_original_method = "0DCDE098692C34941ED8905F239ED21D", hash_generated_method = "6909D6A52E7B2351B554264530F2B680")
    public  DialogPreference(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        TypedArray a;
        a = context.obtainStyledAttributes(attrs,
                com.android.internal.R.styleable.DialogPreference, defStyle, 0);
        mDialogTitle = a.getString(com.android.internal.R.styleable.DialogPreference_dialogTitle);
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
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        addTaint(defStyle);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.390 -0400", hash_original_method = "60E52A3616503A9CD82A6F28FDC1EC0D", hash_generated_method = "1963798F12E782A0A0505F5BEEC9C4A7")
    public  DialogPreference(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.dialogPreferenceStyle);
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.391 -0400", hash_original_method = "6BB18A84F76469D7C771F36F9E0BA9AF", hash_generated_method = "B45A5D7A1E3BCA4FD85953AD13DAF36B")
    public void setDialogTitle(CharSequence dialogTitle) {
        mDialogTitle = dialogTitle;
        // ---------- Original Method ----------
        //mDialogTitle = dialogTitle;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.391 -0400", hash_original_method = "8574D5B6827EC6804865DBFE054A884D", hash_generated_method = "1B092C76E8B13740E2EDC530BD936D72")
    public void setDialogTitle(int dialogTitleResId) {
        setDialogTitle(getContext().getString(dialogTitleResId));
        addTaint(dialogTitleResId);
        // ---------- Original Method ----------
        //setDialogTitle(getContext().getString(dialogTitleResId));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.408 -0400", hash_original_method = "883D8EFBB9B8BAD9BC22F78B210BA75B", hash_generated_method = "DF49A492664B901904B2CDEC277A9FE0")
    public CharSequence getDialogTitle() {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1610320581 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1610320581 = mDialogTitle;
        varB4EAC82CA7396A68D541C85D26508E83_1610320581.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1610320581;
        // ---------- Original Method ----------
        //return mDialogTitle;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.409 -0400", hash_original_method = "C3473A1ED58058061356CFFBC848D9C9", hash_generated_method = "41887350F118ACBC0863E2AD4EC64C3B")
    public void setDialogMessage(CharSequence dialogMessage) {
        mDialogMessage = dialogMessage;
        // ---------- Original Method ----------
        //mDialogMessage = dialogMessage;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.410 -0400", hash_original_method = "15D4845E464A684E3158A3E73E2FE949", hash_generated_method = "53656562B8B8706448C0A547B4AD91A9")
    public void setDialogMessage(int dialogMessageResId) {
        setDialogMessage(getContext().getString(dialogMessageResId));
        addTaint(dialogMessageResId);
        // ---------- Original Method ----------
        //setDialogMessage(getContext().getString(dialogMessageResId));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.425 -0400", hash_original_method = "1C9FE66F99F199ED8416C6E4CD3A4269", hash_generated_method = "D3B742B8F98768523BBB3474B5C43C08")
    public CharSequence getDialogMessage() {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1885517790 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1885517790 = mDialogMessage;
        varB4EAC82CA7396A68D541C85D26508E83_1885517790.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1885517790;
        // ---------- Original Method ----------
        //return mDialogMessage;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.426 -0400", hash_original_method = "B73A337DDB013C24C0D62280ED30F9C6", hash_generated_method = "94B3A71D2448291EB1B536AD4A297F55")
    public void setDialogIcon(Drawable dialogIcon) {
        mDialogIcon = dialogIcon;
        // ---------- Original Method ----------
        //mDialogIcon = dialogIcon;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.427 -0400", hash_original_method = "224A37AA492D9AAF37391FD4564E4780", hash_generated_method = "1F53ABCC2160D94BA60BF25B6B4C958F")
    public void setDialogIcon(int dialogIconRes) {
        mDialogIcon = getContext().getResources().getDrawable(dialogIconRes);
        // ---------- Original Method ----------
        //mDialogIcon = getContext().getResources().getDrawable(dialogIconRes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.441 -0400", hash_original_method = "03DB966CB140533ECF1D4BDC15FA7B76", hash_generated_method = "70A25DD73706115CF11066A82C3D9525")
    public Drawable getDialogIcon() {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_4557886 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_4557886 = mDialogIcon;
        varB4EAC82CA7396A68D541C85D26508E83_4557886.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_4557886;
        // ---------- Original Method ----------
        //return mDialogIcon;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.441 -0400", hash_original_method = "6BE23B5D358DB766161BE60C1550EF9B", hash_generated_method = "15FCDB24219E94DB21B0A8028B4E9D51")
    public void setPositiveButtonText(CharSequence positiveButtonText) {
        mPositiveButtonText = positiveButtonText;
        // ---------- Original Method ----------
        //mPositiveButtonText = positiveButtonText;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.442 -0400", hash_original_method = "B063A8AED375BD92CBE4E8D46785B0F8", hash_generated_method = "05A59BF24CA9B7568ED65B76744251E4")
    public void setPositiveButtonText(int positiveButtonTextResId) {
        setPositiveButtonText(getContext().getString(positiveButtonTextResId));
        addTaint(positiveButtonTextResId);
        // ---------- Original Method ----------
        //setPositiveButtonText(getContext().getString(positiveButtonTextResId));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.443 -0400", hash_original_method = "82AFC23D5F7BC4989211310BE2784E8E", hash_generated_method = "2317E26827032CEE51D91E7E9D70FF33")
    public CharSequence getPositiveButtonText() {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_541645978 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_541645978 = mPositiveButtonText;
        varB4EAC82CA7396A68D541C85D26508E83_541645978.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_541645978;
        // ---------- Original Method ----------
        //return mPositiveButtonText;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.443 -0400", hash_original_method = "4C31EAF97C896EDBAD876498CF3B2FF0", hash_generated_method = "3FA9845BDDD93E5FC8996CE304918DDD")
    public void setNegativeButtonText(CharSequence negativeButtonText) {
        mNegativeButtonText = negativeButtonText;
        // ---------- Original Method ----------
        //mNegativeButtonText = negativeButtonText;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.456 -0400", hash_original_method = "16BFB517EAB7183180ECF26DADA01F37", hash_generated_method = "604AD2A423F3B93C7F5B15D9E9C49861")
    public void setNegativeButtonText(int negativeButtonTextResId) {
        setNegativeButtonText(getContext().getString(negativeButtonTextResId));
        addTaint(negativeButtonTextResId);
        // ---------- Original Method ----------
        //setNegativeButtonText(getContext().getString(negativeButtonTextResId));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.456 -0400", hash_original_method = "AAC926564B2F61079BFED9FEE51EB7E4", hash_generated_method = "CAB01F55AE99CF0896A789CCCAC6D4D3")
    public CharSequence getNegativeButtonText() {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_439770399 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_439770399 = mNegativeButtonText;
        varB4EAC82CA7396A68D541C85D26508E83_439770399.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_439770399;
        // ---------- Original Method ----------
        //return mNegativeButtonText;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.457 -0400", hash_original_method = "6047D08B9E02F6650B39EE0CB2356C47", hash_generated_method = "8C3214F68C80F820797B01AD29A03A7C")
    public void setDialogLayoutResource(int dialogLayoutResId) {
        mDialogLayoutResId = dialogLayoutResId;
        // ---------- Original Method ----------
        //mDialogLayoutResId = dialogLayoutResId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.457 -0400", hash_original_method = "6161E3D2B6291A2C05BBD55D42C3AED0", hash_generated_method = "20BC1D9523A9518A48BBA1213C60C4A3")
    public int getDialogLayoutResource() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1834883220 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1834883220;
        // ---------- Original Method ----------
        //return mDialogLayoutResId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.458 -0400", hash_original_method = "9A579D55B073C910524B0A138ED58992", hash_generated_method = "3FE15FCBE90C74B4FDE26391C79AD091")
    protected void onPrepareDialogBuilder(AlertDialog.Builder builder) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(builder.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.458 -0400", hash_original_method = "D63055C4B5449F36C1385D3F75BC6CB0", hash_generated_method = "C75941BEB55E860D99AA4A9B7CDBF789")
    @Override
    protected void onClick() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        showDialog(null);
        // ---------- Original Method ----------
        //showDialog(null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.461 -0400", hash_original_method = "F05F4238EDB347ACAD0B24F734C6EC9A", hash_generated_method = "EAE270E583D75BA56BEE17FDD4D7E672")
    protected void showDialog(Bundle state) {
        Context context;
        context = getContext();
        mWhichButtonClicked = DialogInterface.BUTTON_NEGATIVE;
        mBuilder = new AlertDialog.Builder(context)
            .setTitle(mDialogTitle)
            .setIcon(mDialogIcon)
            .setPositiveButton(mPositiveButtonText, this)
            .setNegativeButton(mNegativeButtonText, this);
        View contentView;
        contentView = onCreateDialogView();
        {
            onBindDialogView(contentView);
            mBuilder.setView(contentView);
        } //End block
        {
            mBuilder.setMessage(mDialogMessage);
        } //End block
        onPrepareDialogBuilder(mBuilder);
        getPreferenceManager().registerOnActivityDestroyListener(this);
        Dialog dialog;
        dialog = mDialog = mBuilder.create();
        {
            dialog.onRestoreInstanceState(state);
        } //End block
        {
            boolean var80CAD4A61AC1D3C5BA1CD7F74E3BD7D0_60315442 = (needInputMethod());
            {
                requestInputMethod(dialog);
            } //End block
        } //End collapsed parenthetic
        dialog.setOnDismissListener(this);
        dialog.show();
        addTaint(state.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.462 -0400", hash_original_method = "E61813EC392C6A7361FD971C8A66C42E", hash_generated_method = "F5C9644CE88877F55778B21AAADA281B")
    protected boolean needInputMethod() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_63359069 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_63359069;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.462 -0400", hash_original_method = "3B69F31C6833A6156BA93E6BE7789317", hash_generated_method = "A3FD66C194492D111B77AF84A8F6DC6E")
    private void requestInputMethod(Dialog dialog) {
        Window window;
        window = dialog.getWindow();
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        addTaint(dialog.getTaint());
        // ---------- Original Method ----------
        //Window window = dialog.getWindow();
        //window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.463 -0400", hash_original_method = "30915DC6B0C7508CE694D92B8515D200", hash_generated_method = "F4F04C31BDBB7027D7AFAB8F12A60455")
    protected View onCreateDialogView() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        View varB4EAC82CA7396A68D541C85D26508E83_1525669762 = null; //Variable for return #1
        View varB4EAC82CA7396A68D541C85D26508E83_1266438623 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_1525669762 = null;
        } //End block
        LayoutInflater inflater;
        inflater = LayoutInflater.from(mBuilder.getContext());
        varB4EAC82CA7396A68D541C85D26508E83_1266438623 = inflater.inflate(mDialogLayoutResId, null);
        View varA7E53CE21691AB073D9660D615818899_466425861; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_466425861 = varB4EAC82CA7396A68D541C85D26508E83_1525669762;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_466425861 = varB4EAC82CA7396A68D541C85D26508E83_1266438623;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_466425861.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_466425861;
        // ---------- Original Method ----------
        //if (mDialogLayoutResId == 0) {
            //return null;
        //}
        //LayoutInflater inflater = LayoutInflater.from(mBuilder.getContext());
        //return inflater.inflate(mDialogLayoutResId, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.488 -0400", hash_original_method = "5B74FDBCA1C0676CAF2A41085AFE51F9", hash_generated_method = "35AA4075ABCFECDBAB8CAF3481CFFA38")
    protected void onBindDialogView(View view) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        View dialogMessageView;
        dialogMessageView = view.findViewById(com.android.internal.R.id.message);
        {
            CharSequence message;
            message = getDialogMessage();
            int newVisibility;
            newVisibility = View.GONE;
            {
                boolean var358940EC1666A9802A3FB0CBD1923483_1168124105 = (!TextUtils.isEmpty(message));
                {
                    {
                        ((TextView) dialogMessageView).setText(message);
                    } //End block
                    newVisibility = View.VISIBLE;
                } //End block
            } //End collapsed parenthetic
            {
                boolean varA3947E274D511054F4D862B152D1B5BE_243230080 = (dialogMessageView.getVisibility() != newVisibility);
                {
                    dialogMessageView.setVisibility(newVisibility);
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(view.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.488 -0400", hash_original_method = "C7A96C6C4A9A6F7800567BF8395F95D4", hash_generated_method = "97AEC77CFC989B38A65EAAB93DA39550")
    public void onClick(DialogInterface dialog, int which) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mWhichButtonClicked = which;
        addTaint(dialog.getTaint());
        // ---------- Original Method ----------
        //mWhichButtonClicked = which;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.489 -0400", hash_original_method = "4F73C1927BDEFF08475C0DA03B2F2CFE", hash_generated_method = "C0F50E80D9B705F3B489D62FFF988C18")
    public void onDismiss(DialogInterface dialog) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        getPreferenceManager().unregisterOnActivityDestroyListener(this);
        mDialog = null;
        onDialogClosed(mWhichButtonClicked == DialogInterface.BUTTON_POSITIVE);
        addTaint(dialog.getTaint());
        // ---------- Original Method ----------
        //getPreferenceManager().unregisterOnActivityDestroyListener(this);
        //mDialog = null;
        //onDialogClosed(mWhichButtonClicked == DialogInterface.BUTTON_POSITIVE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.489 -0400", hash_original_method = "C2C4DECBB4816C085EA1FCA9996FF5B6", hash_generated_method = "F839090159E8D268DD09FFE754CE51F0")
    protected void onDialogClosed(boolean positiveResult) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(positiveResult);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.490 -0400", hash_original_method = "BFDF5D83CE787BE21817622D7064532F", hash_generated_method = "F7F0356FC70560018822033030E8927C")
    public Dialog getDialog() {
        Dialog varB4EAC82CA7396A68D541C85D26508E83_260810016 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_260810016 = mDialog;
        varB4EAC82CA7396A68D541C85D26508E83_260810016.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_260810016;
        // ---------- Original Method ----------
        //return mDialog;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.490 -0400", hash_original_method = "FC837FC4F2E0A243643D6D2D742CA26C", hash_generated_method = "82A4B6D5165DCF37366BD1BBBA7249E1")
    public void onActivityDestroy() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean varF5698A1109E3A400AEBA99FA3B5D019E_971966029 = (mDialog == null || !mDialog.isShowing());
        } //End collapsed parenthetic
        mDialog.dismiss();
        // ---------- Original Method ----------
        //if (mDialog == null || !mDialog.isShowing()) {
            //return;
        //}
        //mDialog.dismiss();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.508 -0400", hash_original_method = "690D860013A43623DC1BE14E616673FB", hash_generated_method = "F4793E6312D85EF557A4C66AEF7CF35C")
    @Override
    protected Parcelable onSaveInstanceState() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        Parcelable varB4EAC82CA7396A68D541C85D26508E83_740917198 = null; //Variable for return #1
        Parcelable varB4EAC82CA7396A68D541C85D26508E83_1457169317 = null; //Variable for return #2
        Parcelable superState;
        superState = super.onSaveInstanceState();
        {
            boolean varF5698A1109E3A400AEBA99FA3B5D019E_955986889 = (mDialog == null || !mDialog.isShowing());
            {
                varB4EAC82CA7396A68D541C85D26508E83_740917198 = superState;
            } //End block
        } //End collapsed parenthetic
        SavedState myState;
        myState = new SavedState(superState);
        myState.isDialogShowing = true;
        myState.dialogBundle = mDialog.onSaveInstanceState();
        varB4EAC82CA7396A68D541C85D26508E83_1457169317 = myState;
        Parcelable varA7E53CE21691AB073D9660D615818899_1493146351; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1493146351 = varB4EAC82CA7396A68D541C85D26508E83_740917198;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1493146351 = varB4EAC82CA7396A68D541C85D26508E83_1457169317;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1493146351.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1493146351;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.508 -0400", hash_original_method = "C506903F809F21792322FC067531E660", hash_generated_method = "153516CD2289F0F47C572B51AA264B7A")
    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean var9146082C23BCEB2285F1054C3B9F84EE_1012398274 = (state == null || !state.getClass().equals(SavedState.class));
            {
                super.onRestoreInstanceState(state);
            } //End block
        } //End collapsed parenthetic
        SavedState myState;
        myState = (SavedState) state;
        super.onRestoreInstanceState(myState.getSuperState());
        {
            showDialog(myState.dialogBundle);
        } //End block
        addTaint(state.getTaint());
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.509 -0400", hash_original_field = "C75608B67599FA6C902BFE4C625014D1", hash_generated_field = "C67FBD06D119E38CE3CCD57D66AB1C18")

        boolean isDialogShowing;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.509 -0400", hash_original_field = "3E858F45950CD4CFB6443ACE660B1208", hash_generated_field = "7FEB9968C654EBDB6E3D8BB294FB242A")

        Bundle dialogBundle;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.509 -0400", hash_original_method = "EF20CF8D7035837CBAB7B591A73E7119", hash_generated_method = "235A6412ECD5B38AB4470FD695A9633B")
        public  SavedState(Parcel source) {
            super(source);
            isDialogShowing = source.readInt() == 1;
            dialogBundle = source.readBundle();
            // ---------- Original Method ----------
            //isDialogShowing = source.readInt() == 1;
            //dialogBundle = source.readBundle();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.509 -0400", hash_original_method = "89EB4EC154F05BF905ECA8E02BBD14BC", hash_generated_method = "AB11810075E98F66089A29D0DD89C4B4")
        public  SavedState(Parcelable superState) {
            super(superState);
            addTaint(superState.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.510 -0400", hash_original_method = "85259FDDC0FCC1496FED09E1FEFE0DC2", hash_generated_method = "CDA661218377A8A5886E4CAE8BCD484D")
        @Override
        public void writeToParcel(Parcel dest, int flags) {
            super.writeToParcel(dest, flags);
            dest.writeInt(isDialogShowing ? 1 : 0);
            dest.writeBundle(dialogBundle);
            addTaint(dest.getTaint());
            addTaint(flags);
            // ---------- Original Method ----------
            //super.writeToParcel(dest, flags);
            //dest.writeInt(isDialogShowing ? 1 : 0);
            //dest.writeBundle(dialogBundle);
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.510 -0400", hash_original_field = "7DF6FB2587CB67E9544A859A8F6E8FF3", hash_generated_field = "263FCDD65C2156B1D1E1B4D9AE8D7FFA")

        public static final Parcelable.Creator<SavedState> CREATOR =
                new Parcelable.Creator<SavedState>() {
            public SavedState createFromParcel(Parcel in) {
                return new SavedState(in);
            }

            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        };
    }


    
}

