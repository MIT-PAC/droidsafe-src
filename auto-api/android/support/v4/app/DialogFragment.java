package android.support.v4.app;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

public class DialogFragment extends Fragment implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:31.995 -0400", hash_original_field = "A05B420AAAF93A425F246692BECEE214", hash_generated_field = "DBD7D865FD8EE56258485D2729E89222")

    int mStyle = STYLE_NORMAL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:31.995 -0400", hash_original_field = "9C44372B6B78B59807C8DF03A1965EF9", hash_generated_field = "075FD7AAD50C5AD8803D9E3B208423A2")

    int mTheme = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:31.995 -0400", hash_original_field = "CBE9C1F82FCE1BB545B279BE8BBA93EE", hash_generated_field = "5D88854104F09F0EBF08FB1F80A11401")

    boolean mCancelable = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:31.995 -0400", hash_original_field = "259A58946A8982E4476B86202FD7C121", hash_generated_field = "D659735FD2C6B71AB6EABEB3172D7105")

    boolean mShowsDialog = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:31.995 -0400", hash_original_field = "2A265352A0F69145622F4C70F7F35D31", hash_generated_field = "12A4FC8D1F805602392E89610A3F85BE")

    int mBackStackId = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:31.995 -0400", hash_original_field = "58806F2D99FD4DF33CF42E0C232738D7", hash_generated_field = "0C87BCBAF0D95855709E5BEE2BDBA46D")

    Dialog mDialog;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:31.995 -0400", hash_original_field = "2D3E21753B38269D4674440F3CF8C6D5", hash_generated_field = "CEF7EBA8F9051BD4EB01CF3D59FD7DB3")

    boolean mViewDestroyed;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:31.995 -0400", hash_original_field = "0C0B2E8D09BD9B8C826D6F209B1CBE22", hash_generated_field = "6A18A060E129D1B2532BF1934F57C02F")

    boolean mDismissed;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:31.995 -0400", hash_original_field = "5FF7DE71D66CB2DBCFCF4D4DAB432478", hash_generated_field = "0E39250F08259A9ECD97D7EAA8ACE897")

    boolean mShownByMe;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:31.996 -0400", hash_original_method = "0534DFBA1BDB91809702979D0F5FEACD", hash_generated_method = "23496EAA8BA27F5B931F748485941DF8")
    public  DialogFragment() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:31.997 -0400", hash_original_method = "40CEF93F7180D855BD9BCBC02D54626F", hash_generated_method = "02F341786FAE9D120D594AC1851CDB6E")
    public void setStyle(int style, int theme) {
        mStyle = style;
        {
            mTheme = android.R.style.Theme_Panel;
        } //End block
        {
            mTheme = theme;
        } //End block
        // ---------- Original Method ----------
        //mStyle = style;
        //if (mStyle == STYLE_NO_FRAME || mStyle == STYLE_NO_INPUT) {
            //mTheme = android.R.style.Theme_Panel;
        //}
        //if (theme != 0) {
            //mTheme = theme;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:31.997 -0400", hash_original_method = "8FAA759F9028DD0FC2323799369D6711", hash_generated_method = "AA8FA3B083DDBB343F1A7AAB5AD5E41B")
    public void show(FragmentManager manager, String tag) {
        mDismissed = false;
        mShownByMe = true;
        FragmentTransaction ft;
        ft = manager.beginTransaction();
        ft.add(this, tag);
        ft.commit();
        addTaint(manager.getTaint());
        addTaint(tag.getTaint());
        // ---------- Original Method ----------
        //mDismissed = false;
        //mShownByMe = true;
        //FragmentTransaction ft = manager.beginTransaction();
        //ft.add(this, tag);
        //ft.commit();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.000 -0400", hash_original_method = "040104E30D8A876DF591293449491AA6", hash_generated_method = "DAD8A196D3AA2BAD2E7BF1B540B0EC2A")
    public int show(FragmentTransaction transaction, String tag) {
        mDismissed = false;
        mShownByMe = true;
        transaction.add(this, tag);
        mViewDestroyed = false;
        mBackStackId = transaction.commit();
        addTaint(tag.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_379843382 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_379843382;
        // ---------- Original Method ----------
        //mDismissed = false;
        //mShownByMe = true;
        //transaction.add(this, tag);
        //mViewDestroyed = false;
        //mBackStackId = transaction.commit();
        //return mBackStackId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.001 -0400", hash_original_method = "DB04742794ECD07699F134042784BBAE", hash_generated_method = "62668574154E1163FCB1B97491A8357D")
    public void dismiss() {
        dismissInternal(false);
        // ---------- Original Method ----------
        //dismissInternal(false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.001 -0400", hash_original_method = "C37A06AA62DF1D8997FD4317E6F51B99", hash_generated_method = "56682A4FD8FC4BFCF89A5113DBCA6CC0")
    public void dismissAllowingStateLoss() {
        dismissInternal(true);
        // ---------- Original Method ----------
        //dismissInternal(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.018 -0400", hash_original_method = "D69B3047ADB8F155BAC29C903FDECC6E", hash_generated_method = "7129D4069BE483742AA16A9D7451BBD2")
     void dismissInternal(boolean allowStateLoss) {
        mDismissed = true;
        mShownByMe = false;
        {
            mDialog.dismiss();
            mDialog = null;
        } //End block
        mViewDestroyed = true;
        {
            getFragmentManager().popBackStack(mBackStackId,
                    FragmentManager.POP_BACK_STACK_INCLUSIVE);
            mBackStackId = -1;
        } //End block
        {
            FragmentTransaction ft;
            ft = getFragmentManager().beginTransaction();
            ft.remove(this);
            {
                ft.commitAllowingStateLoss();
            } //End block
            {
                ft.commit();
            } //End block
        } //End block
        addTaint(allowStateLoss);
        // ---------- Original Method ----------
        //if (mDismissed) {
            //return;
        //}
        //mDismissed = true;
        //mShownByMe = false;
        //if (mDialog != null) {
            //mDialog.dismiss();
            //mDialog = null;
        //}
        //mViewDestroyed = true;
        //if (mBackStackId >= 0) {
            //getFragmentManager().popBackStack(mBackStackId,
                    //FragmentManager.POP_BACK_STACK_INCLUSIVE);
            //mBackStackId = -1;
        //} else {
            //FragmentTransaction ft = getFragmentManager().beginTransaction();
            //ft.remove(this);
            //if (allowStateLoss) {
                //ft.commitAllowingStateLoss();
            //} else {
                //ft.commit();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.019 -0400", hash_original_method = "BFDF5D83CE787BE21817622D7064532F", hash_generated_method = "1A368AFBE46372E4C07202E598A7F4B7")
    public Dialog getDialog() {
        Dialog varB4EAC82CA7396A68D541C85D26508E83_898027556 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_898027556 = mDialog;
        varB4EAC82CA7396A68D541C85D26508E83_898027556.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_898027556;
        // ---------- Original Method ----------
        //return mDialog;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.019 -0400", hash_original_method = "EDA2E352252479FB515DBD558139BFDA", hash_generated_method = "AD89D7EEC042F40E773D09C6F56F6436")
    public int getTheme() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1396163984 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1396163984;
        // ---------- Original Method ----------
        //return mTheme;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.037 -0400", hash_original_method = "50F98C3ABE4F899A123E50B89219D94B", hash_generated_method = "C7AE7726D0559E5B5FB4ED56F27B7C3A")
    public void setCancelable(boolean cancelable) {
        mCancelable = cancelable;
        mDialog.setCancelable(cancelable);
        // ---------- Original Method ----------
        //mCancelable = cancelable;
        //if (mDialog != null) mDialog.setCancelable(cancelable);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.037 -0400", hash_original_method = "C5B21DACDF63560D5CBEBB813CF00A94", hash_generated_method = "06EE609B9A48AD8700CF4AD8639E4BF4")
    public boolean isCancelable() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1870951257 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1870951257;
        // ---------- Original Method ----------
        //return mCancelable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.038 -0400", hash_original_method = "9B3CB0767DA345E448E7161B8A1612ED", hash_generated_method = "498BC809D2A3B6E137721CDFAE7E8200")
    public void setShowsDialog(boolean showsDialog) {
        mShowsDialog = showsDialog;
        // ---------- Original Method ----------
        //mShowsDialog = showsDialog;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.038 -0400", hash_original_method = "A66E43B75AC73A59CB0304F6142C6A81", hash_generated_method = "B79DBA0B7EE343817FCA5A3462A2251F")
    public boolean getShowsDialog() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2075042084 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2075042084;
        // ---------- Original Method ----------
        //return mShowsDialog;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.049 -0400", hash_original_method = "4F6E3ACB3030C4724A44B02F1B4FB1BA", hash_generated_method = "4F5BE70864530FB0D2A4A9A44C7DFDD9")
    @Override
    public void onAttach(Activity activity) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onAttach(activity);
        {
            mDismissed = false;
        } //End block
        addTaint(activity.getTaint());
        // ---------- Original Method ----------
        //super.onAttach(activity);
        //if (!mShownByMe) {
            //mDismissed = false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.050 -0400", hash_original_method = "2C281285ACC0A61C67E7A68F54E6F98C", hash_generated_method = "FE0B773667D3B39E5BBCF90FEC0C7AB0")
    @Override
    public void onDetach() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onDetach();
        {
            mDismissed = true;
        } //End block
        // ---------- Original Method ----------
        //super.onDetach();
        //if (!mShownByMe && !mDismissed) {
            //mDismissed = true;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.051 -0400", hash_original_method = "B4FC504618F0AC1ACE07BF1B45E5B9CF", hash_generated_method = "27A38205A8B7D3478834D4BB09FA38B9")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onCreate(savedInstanceState);
        mShowsDialog = mContainerId == 0;
        {
            mStyle = savedInstanceState.getInt(SAVED_STYLE, STYLE_NORMAL);
            mTheme = savedInstanceState.getInt(SAVED_THEME, 0);
            mCancelable = savedInstanceState.getBoolean(SAVED_CANCELABLE, true);
            mShowsDialog = savedInstanceState.getBoolean(SAVED_SHOWS_DIALOG, mShowsDialog);
            mBackStackId = savedInstanceState.getInt(SAVED_BACK_STACK_ID, -1);
        } //End block
        // ---------- Original Method ----------
        //super.onCreate(savedInstanceState);
        //mShowsDialog = mContainerId == 0;
        //if (savedInstanceState != null) {
            //mStyle = savedInstanceState.getInt(SAVED_STYLE, STYLE_NORMAL);
            //mTheme = savedInstanceState.getInt(SAVED_THEME, 0);
            //mCancelable = savedInstanceState.getBoolean(SAVED_CANCELABLE, true);
            //mShowsDialog = savedInstanceState.getBoolean(SAVED_SHOWS_DIALOG, mShowsDialog);
            //mBackStackId = savedInstanceState.getInt(SAVED_BACK_STACK_ID, -1);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.071 -0400", hash_original_method = "EC067D1F5D74A2844592729119AA0EAB", hash_generated_method = "45D7B1582C3BADBEADBB6F50A9725012")
    @Override
    public LayoutInflater getLayoutInflater(Bundle savedInstanceState) {
        LayoutInflater varB4EAC82CA7396A68D541C85D26508E83_454570385 = null; //Variable for return #1
        LayoutInflater varB4EAC82CA7396A68D541C85D26508E83_1540017308 = null; //Variable for return #2
        LayoutInflater varB4EAC82CA7396A68D541C85D26508E83_221712045 = null; //Variable for return #3
        {
            varB4EAC82CA7396A68D541C85D26508E83_454570385 = super.getLayoutInflater(savedInstanceState);
        } //End block
        mDialog = onCreateDialog(savedInstanceState);
        //Begin case STYLE_NO_INPUT 
        mDialog.getWindow().addFlags(
                        WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE |
                        WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
        //End case STYLE_NO_INPUT 
        //Begin case STYLE_NO_FRAME STYLE_NO_TITLE 
        mDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //End case STYLE_NO_FRAME STYLE_NO_TITLE 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1540017308 = (LayoutInflater) mDialog.getContext().getSystemService(
                    Context.LAYOUT_INFLATER_SERVICE);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_221712045 = (LayoutInflater) mActivity.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
        LayoutInflater varA7E53CE21691AB073D9660D615818899_932486833; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_932486833 = varB4EAC82CA7396A68D541C85D26508E83_454570385;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_932486833 = varB4EAC82CA7396A68D541C85D26508E83_1540017308;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_932486833 = varB4EAC82CA7396A68D541C85D26508E83_221712045;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_932486833.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_932486833;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.071 -0400", hash_original_method = "94CB11021A94D8409376FA3A852A41E9", hash_generated_method = "B5D9C88A414A428FDBA490416725FB73")
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        Dialog varB4EAC82CA7396A68D541C85D26508E83_1771949977 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1771949977 = new Dialog(getActivity(), getTheme());
        addTaint(savedInstanceState.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1771949977.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1771949977;
        // ---------- Original Method ----------
        //return new Dialog(getActivity(), getTheme());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.072 -0400", hash_original_method = "355678003B9B3B1563024A6589368B65", hash_generated_method = "ED2DA15A78724B9512FA1FE0573630C9")
    public void onCancel(DialogInterface dialog) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(dialog.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.072 -0400", hash_original_method = "2F7D346350F9327D0059F752221072E9", hash_generated_method = "F358699990E5EDD5CB6A7CA1DA002A0D")
    public void onDismiss(DialogInterface dialog) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            dismissInternal(true);
        } //End block
        addTaint(dialog.getTaint());
        // ---------- Original Method ----------
        //if (!mViewDestroyed) {
            //dismissInternal(true);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.073 -0400", hash_original_method = "3427E371293FB144BBDBE8066115235E", hash_generated_method = "F5492EDE4A20FEB6C52B6A330333797A")
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onActivityCreated(savedInstanceState);
        View view;
        view = getView();
        {
            {
                boolean varEC26E600C6CE3FC95DFAFB09E282756E_1223122315 = (view.getParent() != null);
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("DialogFragment can not be attached to a container view");
                } //End block
            } //End collapsed parenthetic
            mDialog.setContentView(view);
        } //End block
        mDialog.setOwnerActivity(getActivity());
        mDialog.setCancelable(mCancelable);
        mDialog.setOnCancelListener(this);
        mDialog.setOnDismissListener(this);
        {
            Bundle dialogState;
            dialogState = savedInstanceState.getBundle(SAVED_DIALOG_STATE_TAG);
            {
                mDialog.onRestoreInstanceState(dialogState);
            } //End block
        } //End block
        addTaint(savedInstanceState.getTaint());
        // ---------- Original Method ----------
        //super.onActivityCreated(savedInstanceState);
        //if (!mShowsDialog) {
            //return;
        //}
        //View view = getView();
        //if (view != null) {
            //if (view.getParent() != null) {
                //throw new IllegalStateException("DialogFragment can not be attached to a container view");
            //}
            //mDialog.setContentView(view);
        //}
        //mDialog.setOwnerActivity(getActivity());
        //mDialog.setCancelable(mCancelable);
        //mDialog.setOnCancelListener(this);
        //mDialog.setOnDismissListener(this);
        //if (savedInstanceState != null) {
            //Bundle dialogState = savedInstanceState.getBundle(SAVED_DIALOG_STATE_TAG);
            //if (dialogState != null) {
                //mDialog.onRestoreInstanceState(dialogState);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.099 -0400", hash_original_method = "CFA39F554612E24A4614D286AB70C801", hash_generated_method = "38AA069EBAABF515F9FA81854C09500A")
    @Override
    public void onStart() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onStart();
        {
            mViewDestroyed = false;
            mDialog.show();
        } //End block
        // ---------- Original Method ----------
        //super.onStart();
        //if (mDialog != null) {
            //mViewDestroyed = false;
            //mDialog.show();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.100 -0400", hash_original_method = "36AA220233F5FF78B8725588D009C1D9", hash_generated_method = "356D514260099CA3AE06D6D3F48A40D8")
    @Override
    public void onSaveInstanceState(Bundle outState) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onSaveInstanceState(outState);
        {
            Bundle dialogState;
            dialogState = mDialog.onSaveInstanceState();
            {
                outState.putBundle(SAVED_DIALOG_STATE_TAG, dialogState);
            } //End block
        } //End block
        {
            outState.putInt(SAVED_STYLE, mStyle);
        } //End block
        {
            outState.putInt(SAVED_THEME, mTheme);
        } //End block
        {
            outState.putBoolean(SAVED_CANCELABLE, mCancelable);
        } //End block
        {
            outState.putBoolean(SAVED_SHOWS_DIALOG, mShowsDialog);
        } //End block
        {
            outState.putInt(SAVED_BACK_STACK_ID, mBackStackId);
        } //End block
        addTaint(outState.getTaint());
        // ---------- Original Method ----------
        //super.onSaveInstanceState(outState);
        //if (mDialog != null) {
            //Bundle dialogState = mDialog.onSaveInstanceState();
            //if (dialogState != null) {
                //outState.putBundle(SAVED_DIALOG_STATE_TAG, dialogState);
            //}
        //}
        //if (mStyle != STYLE_NORMAL) {
            //outState.putInt(SAVED_STYLE, mStyle);
        //}
        //if (mTheme != 0) {
            //outState.putInt(SAVED_THEME, mTheme);
        //}
        //if (!mCancelable) {
            //outState.putBoolean(SAVED_CANCELABLE, mCancelable);
        //}
        //if (!mShowsDialog) {
            //outState.putBoolean(SAVED_SHOWS_DIALOG, mShowsDialog);
        //}
        //if (mBackStackId != -1) {
            //outState.putInt(SAVED_BACK_STACK_ID, mBackStackId);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.101 -0400", hash_original_method = "17D046BD7350E945F7CAD60E8CDA42D0", hash_generated_method = "A22DB62B128FE889D0F154B8BB6F73B7")
    @Override
    public void onStop() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onStop();
        {
            mDialog.hide();
        } //End block
        // ---------- Original Method ----------
        //super.onStop();
        //if (mDialog != null) {
            //mDialog.hide();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.102 -0400", hash_original_method = "A28646D8654C968065CCEE80C360B171", hash_generated_method = "8BE6AB257CB88F3032D918C6AA46A750")
    @Override
    public void onDestroyView() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onDestroyView();
        {
            mViewDestroyed = true;
            mDialog.dismiss();
            mDialog = null;
        } //End block
        // ---------- Original Method ----------
        //super.onDestroyView();
        //if (mDialog != null) {
            //mViewDestroyed = true;
            //mDialog.dismiss();
            //mDialog = null;
        //}
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.102 -0400", hash_original_field = "3353D36CD9BA1728F263F9EFCB2D82DA", hash_generated_field = "2799E9EE0BE29351BF2343EFA521A888")

    public static final int STYLE_NORMAL = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.102 -0400", hash_original_field = "14EE6497368AC36A29BAE72B3B1F58C4", hash_generated_field = "11CB838B0B80C53CBB3DE1A1CDB02BE9")

    public static final int STYLE_NO_TITLE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.102 -0400", hash_original_field = "8955AD96C140B8D481C455C071D2DE5F", hash_generated_field = "68C9068A63469E24D318F617F5D83168")

    public static final int STYLE_NO_FRAME = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.102 -0400", hash_original_field = "61F9A9E833865631586E5F865FE80A82", hash_generated_field = "37C0C9DA86FDBC608BC720AB07FEA0DF")

    public static final int STYLE_NO_INPUT = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.102 -0400", hash_original_field = "E256F366FC40AA8569B871EFE63540D1", hash_generated_field = "B854CC5F4DA930B7E2FEE4F87E056F2A")

    private static String SAVED_DIALOG_STATE_TAG = "android:savedDialogState";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.102 -0400", hash_original_field = "DCEDEDA21056998B4767736B84A32687", hash_generated_field = "24BC2020942EBBBADCBC366E652CB268")

    private static String SAVED_STYLE = "android:style";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.102 -0400", hash_original_field = "C0312515681804EF0A79976C8574D83E", hash_generated_field = "CACBA47A31ABC18AF7F59CC57432673F")

    private static String SAVED_THEME = "android:theme";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.102 -0400", hash_original_field = "9152837CB33765D8F7A72A1451393856", hash_generated_field = "0BC03B1E8F3B16D08FE093D639C861CB")

    private static String SAVED_CANCELABLE = "android:cancelable";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.102 -0400", hash_original_field = "1815F2FDD65BD65E6596AE0EB705B5EA", hash_generated_field = "137BD95F239C09A9C0BE15A88C41C47A")

    private static String SAVED_SHOWS_DIALOG = "android:showsDialog";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.103 -0400", hash_original_field = "6799157D96D3DA8FC22BD76E4EA265DA", hash_generated_field = "D6EF882674F134D9D19E9EB2ED2D3D19")

    private static String SAVED_BACK_STACK_ID = "android:backStackId";
}

