package android.support.v4.app;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class DialogFragment extends Fragment implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:35.575 -0500", hash_original_field = "B33617D119C9E65EA12B9D46B7D4B9F5", hash_generated_field = "2799E9EE0BE29351BF2343EFA521A888")

    public static final int STYLE_NORMAL = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:35.577 -0500", hash_original_field = "6D8979A028077F060188A8EF07A84FC3", hash_generated_field = "11CB838B0B80C53CBB3DE1A1CDB02BE9")

    public static final int STYLE_NO_TITLE = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:35.580 -0500", hash_original_field = "9A5547F54B964B4A7AA50040DCDB7834", hash_generated_field = "68C9068A63469E24D318F617F5D83168")

    public static final int STYLE_NO_FRAME = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:35.582 -0500", hash_original_field = "F40FA4E00D4E1BC73F6536C66AD1A4C7", hash_generated_field = "37C0C9DA86FDBC608BC720AB07FEA0DF")

    public static final int STYLE_NO_INPUT = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:35.585 -0500", hash_original_field = "7C2844D3DF7604C62F66EFED0CC6C3AD", hash_generated_field = "94C97F4A0413FA80F711F0AF0957903C")

    private static final String SAVED_DIALOG_STATE_TAG = "android:savedDialogState";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:35.588 -0500", hash_original_field = "E2492F7AF4DDC10729303DEE44331262", hash_generated_field = "32CF27987345FC568CD0673A0881B818")

    private static final String SAVED_STYLE = "android:style";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:35.590 -0500", hash_original_field = "D555F1957DEDBEF7515491ED49E1A35B", hash_generated_field = "2B4A79E71BCE71D18854AA312DB69394")

    private static final String SAVED_THEME = "android:theme";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:35.592 -0500", hash_original_field = "CD5E35D5D68CF75BC1CAF350714E485A", hash_generated_field = "05351F680E32E607C372E8D76BD924C2")

    private static final String SAVED_CANCELABLE = "android:cancelable";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:35.594 -0500", hash_original_field = "062F1796A0FD32090E24A065B684F8A4", hash_generated_field = "A6049DE77B2A3470E5B9E2A661D1E027")

    private static final String SAVED_SHOWS_DIALOG = "android:showsDialog";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:35.597 -0500", hash_original_field = "F6E95AF919670F04FA0DF6A23DAB5F8A", hash_generated_field = "E8BD2BE09F9DEF6BEC48E8E6748CC6BC")

    private static final String SAVED_BACK_STACK_ID = "android:backStackId";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:35.599 -0500", hash_original_field = "DBD7D865FD8EE56258485D2729E89222", hash_generated_field = "DBD7D865FD8EE56258485D2729E89222")

    int mStyle = STYLE_NORMAL;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:35.602 -0500", hash_original_field = "075FD7AAD50C5AD8803D9E3B208423A2", hash_generated_field = "075FD7AAD50C5AD8803D9E3B208423A2")

    int mTheme = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:35.604 -0500", hash_original_field = "5D88854104F09F0EBF08FB1F80A11401", hash_generated_field = "5D88854104F09F0EBF08FB1F80A11401")

    boolean mCancelable = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:35.607 -0500", hash_original_field = "D659735FD2C6B71AB6EABEB3172D7105", hash_generated_field = "D659735FD2C6B71AB6EABEB3172D7105")

    boolean mShowsDialog = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:35.609 -0500", hash_original_field = "12A4FC8D1F805602392E89610A3F85BE", hash_generated_field = "12A4FC8D1F805602392E89610A3F85BE")

    int mBackStackId = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:35.611 -0500", hash_original_field = "0C87BCBAF0D95855709E5BEE2BDBA46D", hash_generated_field = "0C87BCBAF0D95855709E5BEE2BDBA46D")

    Dialog mDialog;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:35.613 -0500", hash_original_field = "CEF7EBA8F9051BD4EB01CF3D59FD7DB3", hash_generated_field = "CEF7EBA8F9051BD4EB01CF3D59FD7DB3")

    boolean mViewDestroyed;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:35.615 -0500", hash_original_field = "6A18A060E129D1B2532BF1934F57C02F", hash_generated_field = "6A18A060E129D1B2532BF1934F57C02F")

    boolean mDismissed;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:35.617 -0500", hash_original_field = "0E39250F08259A9ECD97D7EAA8ACE897", hash_generated_field = "0E39250F08259A9ECD97D7EAA8ACE897")

    boolean mShownByMe;

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:35.620 -0500", hash_original_method = "0534DFBA1BDB91809702979D0F5FEACD", hash_generated_method = "CFA527E8B5A5174F7A9660414809174D")
    
public DialogFragment() {
    }

    /**
     * Call to customize the basic appearance and behavior of the
     * fragment's dialog.  This can be used for some common dialog behaviors,
     * taking care of selecting flags, theme, and other options for you.  The
     * same effect can be achieve by manually setting Dialog and Window
     * attributes yourself.  Calling this after the fragment's Dialog is
     * created will have no effect.
     *
     * @param style Selects a standard style: may be {@link #STYLE_NORMAL},
     * {@link #STYLE_NO_TITLE}, {@link #STYLE_NO_FRAME}, or
     * {@link #STYLE_NO_INPUT}.
     * @param theme Optional custom theme.  If 0, an appropriate theme (based
     * on the style) will be selected for you.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:35.622 -0500", hash_original_method = "40CEF93F7180D855BD9BCBC02D54626F", hash_generated_method = "8A164EE2E023B2144FDE0869AB8E7D9A")
    
public void setStyle(int style, int theme) {
        mStyle = style;
        if (mStyle == STYLE_NO_FRAME || mStyle == STYLE_NO_INPUT) {
            mTheme = android.R.style.Theme_Panel;
        }
        if (theme != 0) {
            mTheme = theme;
        }
    }

    /**
     * Display the dialog, adding the fragment to the given FragmentManager.  This
     * is a convenience for explicitly creating a transaction, adding the
     * fragment to it with the given tag, and committing it.  This does
     * <em>not</em> add the transaction to the back stack.  When the fragment
     * is dismissed, a new transaction will be executed to remove it from
     * the activity.
     * @param manager The FragmentManager this fragment will be added to.
     * @param tag The tag for this fragment, as per
     * {@link FragmentTransaction#add(Fragment, String) FragmentTransaction.add}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:35.624 -0500", hash_original_method = "8FAA759F9028DD0FC2323799369D6711", hash_generated_method = "5C6D90FF7F0EA4F4D76354EF83F7E041")
    
public void show(FragmentManager manager, String tag) {
        mDismissed = false;
        mShownByMe = true;
        FragmentTransaction ft = manager.beginTransaction();
        ft.add(this, tag);
        ft.commit();
    }

    /**
     * Display the dialog, adding the fragment using an existing transaction
     * and then committing the transaction.
     * @param transaction An existing transaction in which to add the fragment.
     * @param tag The tag for this fragment, as per
     * {@link FragmentTransaction#add(Fragment, String) FragmentTransaction.add}.
     * @return Returns the identifier of the committed transaction, as per
     * {@link FragmentTransaction#commit() FragmentTransaction.commit()}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:35.627 -0500", hash_original_method = "040104E30D8A876DF591293449491AA6", hash_generated_method = "09CF06890A0238BCB3134F67E4117897")
    
public int show(FragmentTransaction transaction, String tag) {
        mDismissed = false;
        mShownByMe = true;
        transaction.add(this, tag);
        mViewDestroyed = false;
        mBackStackId = transaction.commit();
        return mBackStackId;
    }

    /**
     * Dismiss the fragment and its dialog.  If the fragment was added to the
     * back stack, all back stack state up to and including this entry will
     * be popped.  Otherwise, a new transaction will be committed to remove
     * the fragment.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:35.629 -0500", hash_original_method = "DB04742794ECD07699F134042784BBAE", hash_generated_method = "995FB47B2ED1ADE79D1CFC3C7747B4D2")
    
public void dismiss() {
        dismissInternal(false);
    }

    /**
     * Version of {@link #dismiss()} that uses
     * {@link FragmentTransaction#commitAllowingStateLoss()
     * FragmentTransaction.commitAllowingStateLoss()}. See linked
     * documentation for further details.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:35.632 -0500", hash_original_method = "C37A06AA62DF1D8997FD4317E6F51B99", hash_generated_method = "8813BD79CF65D58DF9509C1975C63841")
    
public void dismissAllowingStateLoss() {
        dismissInternal(true);
    }

    @DSComment("Package priviledge")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:35.635 -0500", hash_original_method = "D69B3047ADB8F155BAC29C903FDECC6E", hash_generated_method = "D69B3047ADB8F155BAC29C903FDECC6E")
    
void dismissInternal(boolean allowStateLoss) {
        if (mDismissed) {
            return;
        }
        mDismissed = true;
        mShownByMe = false;
        if (mDialog != null) {
            mDialog.dismiss();
            mDialog = null;
        }
        mViewDestroyed = true;
        if (mBackStackId >= 0) {
            getFragmentManager().popBackStack(mBackStackId,
                    FragmentManager.POP_BACK_STACK_INCLUSIVE);
            mBackStackId = -1;
        } else {
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.remove(this);
            if (allowStateLoss) {
                ft.commitAllowingStateLoss();
            } else {
                ft.commit();
            }
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:35.637 -0500", hash_original_method = "BFDF5D83CE787BE21817622D7064532F", hash_generated_method = "C71E5AB7F1A8C6EFC64CAA7F76F42BA5")
    
public Dialog getDialog() {
        return mDialog;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:35.639 -0500", hash_original_method = "EDA2E352252479FB515DBD558139BFDA", hash_generated_method = "70C10CD453A270D9A3D6BB0351C256D5")
    
public int getTheme() {
        return mTheme;
    }

    /**
     * Control whether the shown Dialog is cancelable.  Use this instead of
     * directly calling {@link Dialog#setCancelable(boolean)
     * Dialog.setCancelable(boolean)}, because DialogFragment needs to change
     * its behavior based on this.
     *
     * @param cancelable If true, the dialog is cancelable.  The default
     * is true.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:35.641 -0500", hash_original_method = "50F98C3ABE4F899A123E50B89219D94B", hash_generated_method = "D3BF408FCDF10C9C2ABD9996B063EE73")
    
public void setCancelable(boolean cancelable) {
        mCancelable = cancelable;
        if (mDialog != null) mDialog.setCancelable(cancelable);
    }

    /**
     * Return the current value of {@link #setCancelable(boolean)}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:35.643 -0500", hash_original_method = "C5B21DACDF63560D5CBEBB813CF00A94", hash_generated_method = "1F76716A1F7F7E8655F10FBCCFB87A3F")
    
public boolean isCancelable() {
        return mCancelable;
    }

    /**
     * Controls whether this fragment should be shown in a dialog.  If not
     * set, no Dialog will be created in {@link #onActivityCreated(Bundle)},
     * and the fragment's view hierarchy will thus not be added to it.  This
     * allows you to instead use it as a normal fragment (embedded inside of
     * its activity).
     *
     * <p>This is normally set for you based on whether the fragment is
     * associated with a container view ID passed to
     * {@link FragmentTransaction#add(int, Fragment) FragmentTransaction.add(int, Fragment)}.
     * If the fragment was added with a container, setShowsDialog will be
     * initialized to false; otherwise, it will be true.
     *
     * @param showsDialog If true, the fragment will be displayed in a Dialog.
     * If false, no Dialog will be created and the fragment's view hierarchly
     * left undisturbed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:35.645 -0500", hash_original_method = "9B3CB0767DA345E448E7161B8A1612ED", hash_generated_method = "05D6EAAA4C55D200D3EAEDF548547767")
    
public void setShowsDialog(boolean showsDialog) {
        mShowsDialog = showsDialog;
    }

    /**
     * Return the current value of {@link #setShowsDialog(boolean)}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:35.648 -0500", hash_original_method = "A66E43B75AC73A59CB0304F6142C6A81", hash_generated_method = "B9101F7AA44C7E8C87EF62912DF1DDE6")
    
public boolean getShowsDialog() {
        return mShowsDialog;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:35.650 -0500", hash_original_method = "4F6E3ACB3030C4724A44B02F1B4FB1BA", hash_generated_method = "409F3CC8703F9FF26D31058EF49DCA85")
    
@Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (!mShownByMe) {
            // If not explicitly shown through our API, take this as an
            // indication that the dialog is no longer dismissed.
            mDismissed = false;
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:35.653 -0500", hash_original_method = "2C281285ACC0A61C67E7A68F54E6F98C", hash_generated_method = "F04C9D6168EC15DEF59998ACE39A6657")
    
@Override
    public void onDetach() {
        super.onDetach();
        if (!mShownByMe && !mDismissed) {
            // The fragment was not shown by a direct call here, it is not
            // dismissed, and now it is being detached...  well, okay, thou
            // art now dismissed.  Have fun.
            mDismissed = true;
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:35.656 -0500", hash_original_method = "B4FC504618F0AC1ACE07BF1B45E5B9CF", hash_generated_method = "9347B65955CA212EDA6B1AB62C4BBD9E")
    
@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mShowsDialog = mContainerId == 0;

        if (savedInstanceState != null) {
            mStyle = savedInstanceState.getInt(SAVED_STYLE, STYLE_NORMAL);
            mTheme = savedInstanceState.getInt(SAVED_THEME, 0);
            mCancelable = savedInstanceState.getBoolean(SAVED_CANCELABLE, true);
            mShowsDialog = savedInstanceState.getBoolean(SAVED_SHOWS_DIALOG, mShowsDialog);
            mBackStackId = savedInstanceState.getInt(SAVED_BACK_STACK_ID, -1);
        }
        
    }

    /** @hide */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:35.660 -0500", hash_original_method = "EC067D1F5D74A2844592729119AA0EAB", hash_generated_method = "E54FE9B80EB98CF6B0844591E9573EA1")
    
@Override
    public LayoutInflater getLayoutInflater(Bundle savedInstanceState) {
        if (!mShowsDialog) {
            return super.getLayoutInflater(savedInstanceState);
        }

        mDialog = onCreateDialog(savedInstanceState);
        switch (mStyle) {
            case STYLE_NO_INPUT:
                mDialog.getWindow().addFlags(
                        WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE |
                        WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                // fall through...
            case STYLE_NO_FRAME:
            case STYLE_NO_TITLE:
                mDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        }
        if (mDialog != null) {
            return (LayoutInflater) mDialog.getContext().getSystemService(
                    Context.LAYOUT_INFLATER_SERVICE);
        }
        return (LayoutInflater) mActivity.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
    }
    
    /**
     * Override to build your own custom Dialog container.  This is typically
     * used to show an AlertDialog instead of a generic Dialog; when doing so,
     * {@link #onCreateView(LayoutInflater, ViewGroup, Bundle)} does not need
     * to be implemented since the AlertDialog takes care of its own content.
     * 
     * <p>This method will be called after {@link #onCreate(Bundle)} and
     * before {@link #onCreateView(LayoutInflater, ViewGroup, Bundle)}.  The
     * default implementation simply instantiates and returns a {@link Dialog}
     * class.
     * 
     * <p><em>Note: DialogFragment own the {@link Dialog#setOnCancelListener
     * Dialog.setOnCancelListener} and {@link Dialog#setOnDismissListener
     * Dialog.setOnDismissListener} callbacks.  You must not set them yourself.</em>
     * To find out about these events, override {@link #onCancel(DialogInterface)}
     * and {@link #onDismiss(DialogInterface)}.</p>
     * 
     * @param savedInstanceState The last saved instance state of the Fragment,
     * or null if this is a freshly created Fragment.
     * 
     * @return Return a new Dialog instance to be displayed by the Fragment.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:35.662 -0500", hash_original_method = "94CB11021A94D8409376FA3A852A41E9", hash_generated_method = "8854F20A927D4731539FCCDAD7E493F4")
    
public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new Dialog(getActivity(), getTheme());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:35.664 -0500", hash_original_method = "355678003B9B3B1563024A6589368B65", hash_generated_method = "B5C1EB04A4254D80E0CBB4208CB0D39E")
    
public void onCancel(DialogInterface dialog) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:35.667 -0500", hash_original_method = "2F7D346350F9327D0059F752221072E9", hash_generated_method = "EE11F82F5AE7A4AE2FBC865D97EBAA77")
    
public void onDismiss(DialogInterface dialog) {
        if (!mViewDestroyed) {
            // Note: we need to use allowStateLoss, because the dialog
            // dispatches this asynchronously so we can receive the call
            // after the activity is paused.  Worst case, when the user comes
            // back to the activity they see the dialog again.
            dismissInternal(true);
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:35.669 -0500", hash_original_method = "3427E371293FB144BBDBE8066115235E", hash_generated_method = "0FFD022C4374DE4DC0DFA36DE9F7B604")
    
@Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (!mShowsDialog) {
            return;
        }

        View view = getView();
        if (view != null) {
            if (view.getParent() != null) {
                throw new IllegalStateException("DialogFragment can not be attached to a container view");
            }
            mDialog.setContentView(view);
        }
        mDialog.setOwnerActivity(getActivity());
        mDialog.setCancelable(mCancelable);
        mDialog.setOnCancelListener(this);
        mDialog.setOnDismissListener(this);
        if (savedInstanceState != null) {
            Bundle dialogState = savedInstanceState.getBundle(SAVED_DIALOG_STATE_TAG);
            if (dialogState != null) {
                mDialog.onRestoreInstanceState(dialogState);
            }
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:35.672 -0500", hash_original_method = "CFA39F554612E24A4614D286AB70C801", hash_generated_method = "F4CC27144B9864F5A13121D556F3D501")
    
@Override
    public void onStart() {
        super.onStart();
        if (mDialog != null) {
            mViewDestroyed = false;
            mDialog.show();
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:35.675 -0500", hash_original_method = "36AA220233F5FF78B8725588D009C1D9", hash_generated_method = "E01E9F7B4265B087304DB47188E5C0EA")
    
@Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (mDialog != null) {
            Bundle dialogState = mDialog.onSaveInstanceState();
            if (dialogState != null) {
                outState.putBundle(SAVED_DIALOG_STATE_TAG, dialogState);
            }
        }
        if (mStyle != STYLE_NORMAL) {
            outState.putInt(SAVED_STYLE, mStyle);
        }
        if (mTheme != 0) {
            outState.putInt(SAVED_THEME, mTheme);
        }
        if (!mCancelable) {
            outState.putBoolean(SAVED_CANCELABLE, mCancelable);
        }
        if (!mShowsDialog) {
            outState.putBoolean(SAVED_SHOWS_DIALOG, mShowsDialog);
        }
        if (mBackStackId != -1) {
            outState.putInt(SAVED_BACK_STACK_ID, mBackStackId);
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:35.678 -0500", hash_original_method = "17D046BD7350E945F7CAD60E8CDA42D0", hash_generated_method = "F4581EEBAF078137794FB0DF1603F402")
    
@Override
    public void onStop() {
        super.onStop();
        if (mDialog != null) {
            mDialog.hide();
        }
    }

    /**
     * Remove dialog.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:35.680 -0500", hash_original_method = "A28646D8654C968065CCEE80C360B171", hash_generated_method = "5BDF40E1FD876DCB9A201D9F7020DAE4")
    
@Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mDialog != null) {
            // Set removed here because this dismissal is just to hide
            // the dialog -- we don't want this to cause the fragment to
            // actually be removed.
            mViewDestroyed = true;
            mDialog.dismiss();
            mDialog = null;
        }
    }
}

