package android.preference;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:25.503 -0500", hash_original_field = "8230423D0C18E260F04D32D3976828DB", hash_generated_field = "42060B98383429459FECD4D4CDE8C54F")

    private AlertDialog.Builder mBuilder;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:25.505 -0500", hash_original_field = "72A15FBD3873FBDA3D83751971F82EDC", hash_generated_field = "97697297384E83403579647D80580C36")
    
    private CharSequence mDialogTitle;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:25.507 -0500", hash_original_field = "9FA66D5F15EAEFF1978682271355387D", hash_generated_field = "613703FDAE1B8EC965EFFFE3F7B81D89")

    private CharSequence mDialogMessage;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:25.509 -0500", hash_original_field = "92ECB0D3A7FEED2C9F9FCC6869985C99", hash_generated_field = "62F8B6A1225692AA3122E336B4C39371")

    private Drawable mDialogIcon;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:25.511 -0500", hash_original_field = "C455BA97656CBA9FD4747BFBD43F169E", hash_generated_field = "562EA9B33498318D41CCFBFB106A7B3C")

    private CharSequence mPositiveButtonText;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:25.513 -0500", hash_original_field = "F3614752E21AFBE21C5C8D2CE5A72EA1", hash_generated_field = "4083143E7FFA77B3CD0812A1312A7A80")

    private CharSequence mNegativeButtonText;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:25.516 -0500", hash_original_field = "57E9B44E4AD66B7B1C4509D2920CA87C", hash_generated_field = "02541F76C3D2FBBAD006513FC4EED963")

    private int mDialogLayoutResId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:25.518 -0500", hash_original_field = "0C87BCBAF0D95855709E5BEE2BDBA46D", hash_generated_field = "D9FAD0C1386FC50E3C837906841C2A70")

    private Dialog mDialog;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:25.521 -0500", hash_original_field = "C9ABBF25312140ECB34E7C96A3E92A05", hash_generated_field = "A305715F0BC591A0A9137CCA600B2C10")

    private int mWhichButtonClicked;
    
    @DSComment("Perference UI, only change preference is spec")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:25.524 -0500", hash_original_method = "0DCDE098692C34941ED8905F239ED21D", hash_generated_method = "9FB519AAD49C293A40F4A896BC0DE3D2")
    @DSVerified
public DialogPreference(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        
        TypedArray a = context.obtainStyledAttributes(attrs,
                com.android.internal.R.styleable.DialogPreference, defStyle, 0);
        mDialogTitle = a.getString(com.android.internal.R.styleable.DialogPreference_dialogTitle);
        if (mDialogTitle == null) {
            // Fallback on the regular title of the preference
            // (the one that is seen in the list)
            mDialogTitle = getTitle();
        }
        mDialogMessage = a.getString(com.android.internal.R.styleable.DialogPreference_dialogMessage);
        mDialogIcon = a.getDrawable(com.android.internal.R.styleable.DialogPreference_dialogIcon);
        mPositiveButtonText = a.getString(com.android.internal.R.styleable.DialogPreference_positiveButtonText);
        mNegativeButtonText = a.getString(com.android.internal.R.styleable.DialogPreference_negativeButtonText);
        mDialogLayoutResId = a.getResourceId(com.android.internal.R.styleable.DialogPreference_dialogLayout,
                mDialogLayoutResId);
        droidsafeModelCallbacks();
        a.recycle();
        
    }

    @DSVerified
    @DSBan(DSCat.DROIDSAFE_INTERNAL)
    private void droidsafeModelCallbacks() {
        onPrepareDialogBuilder(mBuilder);
        View view = onCreateDialogView();
        onBindDialogView(view);

        Parcelable p = onSaveInstanceState();
        onRestoreInstanceState(p);

        onClick();
        onClick(mDialog, DSUtils.FAKE_INT);

        onDismiss(mDialog);
        onDialogClosed(DSUtils.UNKNOWN_BOOLEAN);
    }

    @DSComment("Perference UI, only change preference is spec")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:25.526 -0500", hash_original_method = "60E52A3616503A9CD82A6F28FDC1EC0D", hash_generated_method = "1AE72C2BF0442FB74BBDF9A012285B7C")
    
public DialogPreference(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.dialogPreferenceStyle);
    }
    
    /**
     * Sets the title of the dialog. This will be shown on subsequent dialogs.
     * 
     * @param dialogTitle The title.
     */
    @DSComment("Perference UI, only change preference is spec")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:25.528 -0500", hash_original_method = "6BB18A84F76469D7C771F36F9E0BA9AF", hash_generated_method = "4499718073750295EF21C14D591A3166")
    
public void setDialogTitle(CharSequence dialogTitle) {
        mDialogTitle = dialogTitle;
    }

    /**
     * @see #setDialogTitle(CharSequence)
     * @param dialogTitleResId The dialog title as a resource.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:25.530 -0500", hash_original_method = "8574D5B6827EC6804865DBFE054A884D", hash_generated_method = "4E8E79E215EC0FE5D90C433D70740216")
    
public void setDialogTitle(int dialogTitleResId) {
        setDialogTitle(getContext().getString(dialogTitleResId));
    }
    
    /**
     * Returns the title to be shown on subsequent dialogs.
     * @return The title.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:25.533 -0500", hash_original_method = "883D8EFBB9B8BAD9BC22F78B210BA75B", hash_generated_method = "789B2BB66A051D6AFD7B079CFAFACE50")
    
public CharSequence getDialogTitle() {
        return mDialogTitle;
    }
    
    /**
     * Sets the message of the dialog. This will be shown on subsequent dialogs.
     * <p>
     * This message forms the content View of the dialog and conflicts with
     * list-based dialogs, for example. If setting a custom View on a dialog via
     * {@link #setDialogLayoutResource(int)}, include a text View with ID
     * {@link android.R.id#message} and it will be populated with this message.
     * 
     * @param dialogMessage The message.
     */
    @DSComment("Perference UI, only change preference is spec")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:25.535 -0500", hash_original_method = "C3473A1ED58058061356CFFBC848D9C9", hash_generated_method = "866171AC4067BF1163FB7CAFF4397B93")
    
public void setDialogMessage(CharSequence dialogMessage) {
        mDialogMessage = dialogMessage;
    }

    /**
     * @see #setDialogMessage(CharSequence)
     * @param dialogMessageResId The dialog message as a resource.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:25.537 -0500", hash_original_method = "15D4845E464A684E3158A3E73E2FE949", hash_generated_method = "BECB971DB7AFE351A8835449841A42ED")
    
public void setDialogMessage(int dialogMessageResId) {
        setDialogMessage(getContext().getString(dialogMessageResId));
    }
    
    /**
     * Returns the message to be shown on subsequent dialogs.
     * @return The message.
     */
    @DSComment("Perference UI, only change preference is spec")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:25.539 -0500", hash_original_method = "1C9FE66F99F199ED8416C6E4CD3A4269", hash_generated_method = "7C0298DBAC939CDE7DE164ADCA75E342")
    
public CharSequence getDialogMessage() {
        return mDialogMessage;
    }
    
    /**
     * Sets the icon of the dialog. This will be shown on subsequent dialogs.
     * 
     * @param dialogIcon The icon, as a {@link Drawable}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:25.541 -0500", hash_original_method = "B73A337DDB013C24C0D62280ED30F9C6", hash_generated_method = "0E016C7EB3505669E0FF7B91CC4B74EB")
    
public void setDialogIcon(Drawable dialogIcon) {
        mDialogIcon = dialogIcon;
    }
    
    /**
     * Sets the icon (resource ID) of the dialog. This will be shown on
     * subsequent dialogs.
     * 
     * @param dialogIconRes The icon, as a resource ID.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:25.543 -0500", hash_original_method = "224A37AA492D9AAF37391FD4564E4780", hash_generated_method = "0ED369DE1047C065B81306A31F78F35B")
    
public void setDialogIcon(int dialogIconRes) {
        mDialogIcon = getContext().getResources().getDrawable(dialogIconRes);
    }
    
    /**
     * Returns the icon to be shown on subsequent dialogs.
     * @return The icon, as a {@link Drawable}.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:25.545 -0500", hash_original_method = "03DB966CB140533ECF1D4BDC15FA7B76", hash_generated_method = "A831F8DF920DAF30CD778C9659DD617D")
    
public Drawable getDialogIcon() {
        return mDialogIcon;
    }
    
    /**
     * Sets the text of the positive button of the dialog. This will be shown on
     * subsequent dialogs.
     * 
     * @param positiveButtonText The text of the positive button.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:25.547 -0500", hash_original_method = "6BE23B5D358DB766161BE60C1550EF9B", hash_generated_method = "B4FC015126D7194BC80DF8FEDD638A56")
    
public void setPositiveButtonText(CharSequence positiveButtonText) {
        mPositiveButtonText = positiveButtonText;
    }

    /**
     * @see #setPositiveButtonText(CharSequence)
     * @param positiveButtonTextResId The positive button text as a resource.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:25.549 -0500", hash_original_method = "B063A8AED375BD92CBE4E8D46785B0F8", hash_generated_method = "D23122B4456B0CF504FA6CEEC481A26B")
    
public void setPositiveButtonText(int positiveButtonTextResId) {
        setPositiveButtonText(getContext().getString(positiveButtonTextResId));
    }
    
    /**
     * Returns the text of the positive button to be shown on subsequent
     * dialogs.
     * 
     * @return The text of the positive button.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:25.552 -0500", hash_original_method = "82AFC23D5F7BC4989211310BE2784E8E", hash_generated_method = "9570F08916148C6D1E6AA2B557AAA692")
    
public CharSequence getPositiveButtonText() {
        return mPositiveButtonText;
    }
    
    /**
     * Sets the text of the negative button of the dialog. This will be shown on
     * subsequent dialogs.
     * 
     * @param negativeButtonText The text of the negative button.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:25.554 -0500", hash_original_method = "4C31EAF97C896EDBAD876498CF3B2FF0", hash_generated_method = "3ACBDD5120B08D6B2C1CABA6F11F3CFE")
    
public void setNegativeButtonText(CharSequence negativeButtonText) {
        mNegativeButtonText = negativeButtonText;
    }
    
    /**
     * @see #setNegativeButtonText(CharSequence)
     * @param negativeButtonTextResId The negative button text as a resource.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:25.556 -0500", hash_original_method = "16BFB517EAB7183180ECF26DADA01F37", hash_generated_method = "DDB6230286F645E3F8E1F4373484F02E")
    
public void setNegativeButtonText(int negativeButtonTextResId) {
        setNegativeButtonText(getContext().getString(negativeButtonTextResId));
    }
    
    /**
     * Returns the text of the negative button to be shown on subsequent
     * dialogs.
     * 
     * @return The text of the negative button.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:25.558 -0500", hash_original_method = "AAC926564B2F61079BFED9FEE51EB7E4", hash_generated_method = "E912C00F40FCBB5603CDEF2B9B7448FD")
    
public CharSequence getNegativeButtonText() {
        return mNegativeButtonText;
    }
    
    /**
     * Sets the layout resource that is inflated as the {@link View} to be shown
     * as the content View of subsequent dialogs.
     * 
     * @param dialogLayoutResId The layout resource ID to be inflated.
     * @see #setDialogMessage(CharSequence)
     */
    @DSComment("Perference UI, only change preference is spec")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:25.560 -0500", hash_original_method = "6047D08B9E02F6650B39EE0CB2356C47", hash_generated_method = "677AEA0A04801B6C9A935B9A0B115BF5")
    
public void setDialogLayoutResource(int dialogLayoutResId) {
        mDialogLayoutResId = dialogLayoutResId;
    }
    
    /**
     * Returns the layout resource that is used as the content View for
     * subsequent dialogs.
     * 
     * @return The layout resource.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:25.562 -0500", hash_original_method = "6161E3D2B6291A2C05BBD55D42C3AED0", hash_generated_method = "80628F2AAEC739610AA687F4E15FD287")
    
public int getDialogLayoutResource() {
        return mDialogLayoutResId;
    }
    
    /**
     * Prepares the dialog builder to be shown when the preference is clicked.
     * Use this to set custom properties on the dialog.
     * <p>
     * Do not {@link AlertDialog.Builder#create()} or
     * {@link AlertDialog.Builder#show()}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:25.564 -0500", hash_original_method = "9A579D55B073C910524B0A138ED58992", hash_generated_method = "F66DEA8C21E7895B642AD2BA231BFC21")
    @DSVerified
    @DSSafe(DSCat.ANDROID_CALLBACK)
protected void onPrepareDialogBuilder(AlertDialog.Builder builder) {
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:25.567 -0500", hash_original_method = "D63055C4B5449F36C1385D3F75BC6CB0", hash_generated_method = "76B88A69FB69198AD35CD58129928D92")
    
@Override
    protected void onClick() {
        showDialog(null);
    }

    /**
     * Shows the dialog associated with this Preference. This is normally initiated
     * automatically on clicking on the preference. Call this method if you need to
     * show the dialog on some other event.
     * 
     * @param state Optional instance state to restore on the dialog
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:25.569 -0500", hash_original_method = "F05F4238EDB347ACAD0B24F734C6EC9A", hash_generated_method = "29C53E3687E9449EF990569C7679DD39")
    @DSVerified
    @DSSafe(DSCat.GUI)
protected void showDialog(Bundle state) {
        Context context = getContext();

        mWhichButtonClicked = DialogInterface.BUTTON_NEGATIVE;
        
        mBuilder = new AlertDialog.Builder(context)
            .setTitle(mDialogTitle)
            .setIcon(mDialogIcon)
            .setPositiveButton(mPositiveButtonText, this)
            .setNegativeButton(mNegativeButtonText, this);

        View contentView = onCreateDialogView();
        if (contentView != null) {
            onBindDialogView(contentView);
            mBuilder.setView(contentView);
        } else {
            mBuilder.setMessage(mDialogMessage);
        }
        
        onPrepareDialogBuilder(mBuilder);
        
        getPreferenceManager().registerOnActivityDestroyListener(this);
        
        // Create the dialog
        final Dialog dialog = mDialog = mBuilder.create();

        //Preference callback
        onDismiss(dialog);
        Parcelable otherState = onSaveInstanceState();

        if (otherState != null)
            onRestoreInstanceState(otherState);

        //dialog spsefic callback
        if (state != null) {
            dialog.onRestoreInstanceState(state);
        }
        if (needInputMethod()) {
            requestInputMethod(dialog);
        }
        dialog.setOnDismissListener(this);
        dialog.show();
    }

    /**
     * Returns whether the preference needs to display a soft input method when the dialog
     * is displayed. Default is false. Subclasses should override this method if they need
     * the soft input method brought up automatically.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:25.571 -0500", hash_original_method = "E61813EC392C6A7361FD971C8A66C42E", hash_generated_method = "0F4771F13DEA30E5D44ACE549A7606E7")
    
protected boolean needInputMethod() {
        return false;
    }

    /**
     * Sets the required flags on the dialog window to enable input method window to show up.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:25.574 -0500", hash_original_method = "3B69F31C6833A6156BA93E6BE7789317", hash_generated_method = "D190D5E44E8FFDDBB130D33475DEE964")
    
private void requestInputMethod(Dialog dialog) {
        Window window = dialog.getWindow();
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
    }

    /**
     * Creates the content view for the dialog (if a custom content view is
     * required). By default, it inflates the dialog layout resource if it is
     * set.
     * 
     * @return The content View for the dialog.
     * @see #setLayoutResource(int)
     */
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:25.576 -0500", hash_original_method = "30915DC6B0C7508CE694D92B8515D200", hash_generated_method = "4BBF0EB04B922814511B8C574D43549F")
    
protected View onCreateDialogView() {
        if (mDialogLayoutResId == 0) {
            return null;
        }
        
        LayoutInflater inflater = LayoutInflater.from(mBuilder.getContext());
        return inflater.inflate(mDialogLayoutResId, null);
    }
    
    /**
     * Binds views in the content View of the dialog to data.
     * <p>
     * Make sure to call through to the superclass implementation.
     * 
     * @param view The content View of the dialog, if it is custom.
     */
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:25.578 -0500", hash_original_method = "5B74FDBCA1C0676CAF2A41085AFE51F9", hash_generated_method = "F9F79A99BEC07821AA52E5285769563E")
    @DSVerified
    
protected void onBindDialogView(View view) {
        View dialogMessageView = view.findViewById(com.android.internal.R.id.message);
        
        if (dialogMessageView != null) {
            final CharSequence message = getDialogMessage();
            int newVisibility = View.GONE;
            
            if (!TextUtils.isEmpty(message)) {
                if (dialogMessageView instanceof TextView) {
                    ((TextView) dialogMessageView).setText(message);
                }
                
                newVisibility = View.VISIBLE;
            }
            
            if (dialogMessageView.getVisibility() != newVisibility) {
                dialogMessageView.setVisibility(newVisibility);
            }
        }
    }
    
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:25.581 -0500", hash_original_method = "C7A96C6C4A9A6F7800567BF8395F95D4", hash_generated_method = "379F22A6A28C69498EDA226AE55127CF")
    
public void onClick(DialogInterface dialog, int which) {
        mWhichButtonClicked = which;
    }
    
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:25.584 -0500", hash_original_method = "4F73C1927BDEFF08475C0DA03B2F2CFE", hash_generated_method = "58617F782952416B4E8F5CA68C72810B")
    @DSVerified
public void onDismiss(DialogInterface dialog) {
        
        getPreferenceManager().unregisterOnActivityDestroyListener(this);
        
        mDialog = null;
        onDialogClosed(mWhichButtonClicked == DialogInterface.BUTTON_POSITIVE);
    }

    /**
     * Called when the dialog is dismissed and should be used to save data to
     * the {@link SharedPreferences}.
     * 
     * @param positiveResult Whether the positive button was clicked (true), or
     *            the negative button was clicked or the dialog was canceled (false).
     */
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:25.588 -0500", hash_original_method = "C2C4DECBB4816C085EA1FCA9996FF5B6", hash_generated_method = "EC8CB229192FDACB0A06D72365E9B447")
    
protected void onDialogClosed(boolean positiveResult) {
    }

    /**
     * Gets the dialog that is shown by this preference.
     * 
     * @return The dialog, or null if a dialog is not being shown.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:25.591 -0500", hash_original_method = "BFDF5D83CE787BE21817622D7064532F", hash_generated_method = "C71E5AB7F1A8C6EFC64CAA7F76F42BA5")
    
public Dialog getDialog() {
        return mDialog;
    }

    /**
     * {@inheritDoc}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:25.593 -0500", hash_original_method = "FC837FC4F2E0A243643D6D2D742CA26C", hash_generated_method = "5A3D94ACC94FA814BD85C1422817C077")
    
public void onActivityDestroy() {
        
        if (mDialog == null || !mDialog.isShowing()) {
            return;
        }
        
        mDialog.dismiss();
    }

    @DSComment("Data serialization/deserialization")
    @DSSpec(DSCat.SERIALIZATION)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:25.596 -0500", hash_original_method = "690D860013A43623DC1BE14E616673FB", hash_generated_method = "A36474BF7EB3EF505FDD40FD5D98B014")
    @DSVerified
@Override
    protected Parcelable onSaveInstanceState() {
        final Parcelable superState = super.onSaveInstanceState();
        if (mDialog == null || !mDialog.isShowing()) {
            return superState;
        }

        final SavedState myState = new SavedState(superState);
        myState.isDialogShowing = true;
        myState.dialogBundle = mDialog.onSaveInstanceState();
        return myState;
    }

    @DSComment("Data serialization/deserialization")
    @DSSpec(DSCat.SERIALIZATION)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:25.599 -0500", hash_original_method = "C506903F809F21792322FC067531E660", hash_generated_method = "235316BF207EBD7B35336C9EA423C5B4")
    @DSVerified
@Override
    protected void onRestoreInstanceState(Parcelable state) {
        if (state == null || !state.getClass().equals(SavedState.class)) {
            // Didn't save state for us in onSaveInstanceState
            super.onRestoreInstanceState(state);
            return;
        }

        SavedState myState = (SavedState) state;
        super.onRestoreInstanceState(myState.getSuperState());
        if (myState.isDialogShowing) {
            showDialog(myState.dialogBundle);
        }
    }
    
    private static class SavedState extends BaseSavedState {
        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.207 -0400", hash_original_field = "7DF6FB2587CB67E9544A859A8F6E8FF3", hash_generated_field = "263FCDD65C2156B1D1E1B4D9AE8D7FFA")

        public static final Parcelable.Creator<SavedState> CREATOR =
                new Parcelable.Creator<SavedState>() {
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:25.614 -0500", hash_original_method = "E26812089C072DDE1A14AECAA6CD6686", hash_generated_method = "C97AA17CB243756458D0FB7A2D786EA0")
            
public SavedState createFromParcel(Parcel in) {
                return new SavedState(in);
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:25.616 -0500", hash_original_method = "2D31E9CBAAAE05B696D738324F87FF78", hash_generated_method = "020465B62F970B98C266AF229149E391")
            
public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:25.601 -0500", hash_original_field = "C67FBD06D119E38CE3CCD57D66AB1C18", hash_generated_field = "C67FBD06D119E38CE3CCD57D66AB1C18")

        boolean isDialogShowing;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:25.603 -0500", hash_original_field = "7FEB9968C654EBDB6E3D8BB294FB242A", hash_generated_field = "7FEB9968C654EBDB6E3D8BB294FB242A")

        Bundle dialogBundle;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:25.605 -0500", hash_original_method = "EF20CF8D7035837CBAB7B591A73E7119", hash_generated_method = "1EFBD7A62AA2DED900499AED5AF6CE76")
        
public SavedState(Parcel source) {
            super(source);
            isDialogShowing = source.readInt() == 1;
            dialogBundle = source.readBundle();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:25.611 -0500", hash_original_method = "89EB4EC154F05BF905ECA8E02BBD14BC", hash_generated_method = "E32D4593A5A22DE64D4F3221E06324D4")
        
public SavedState(Parcelable superState) {
            super(superState);
        }

        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:25.608 -0500", hash_original_method = "85259FDDC0FCC1496FED09E1FEFE0DC2", hash_generated_method = "380749B2211E5B849DBB04E0D2BF9D8D")
        
@Override
        public void writeToParcel(Parcel dest, int flags) {
            super.writeToParcel(dest, flags);
            dest.writeInt(isDialogShowing ? 1 : 0);
            dest.writeBundle(dialogBundle);
        }
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

