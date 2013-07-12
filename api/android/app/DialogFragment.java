package android.app;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class DialogFragment extends Fragment implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.940 -0400", hash_original_field = "A05B420AAAF93A425F246692BECEE214", hash_generated_field = "DBD7D865FD8EE56258485D2729E89222")

    int mStyle = STYLE_NORMAL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.941 -0400", hash_original_field = "9C44372B6B78B59807C8DF03A1965EF9", hash_generated_field = "075FD7AAD50C5AD8803D9E3B208423A2")

    int mTheme = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.941 -0400", hash_original_field = "CBE9C1F82FCE1BB545B279BE8BBA93EE", hash_generated_field = "5D88854104F09F0EBF08FB1F80A11401")

    boolean mCancelable = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.941 -0400", hash_original_field = "259A58946A8982E4476B86202FD7C121", hash_generated_field = "D659735FD2C6B71AB6EABEB3172D7105")

    boolean mShowsDialog = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.941 -0400", hash_original_field = "2A265352A0F69145622F4C70F7F35D31", hash_generated_field = "12A4FC8D1F805602392E89610A3F85BE")

    int mBackStackId = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.941 -0400", hash_original_field = "58806F2D99FD4DF33CF42E0C232738D7", hash_generated_field = "0C87BCBAF0D95855709E5BEE2BDBA46D")

    Dialog mDialog;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.942 -0400", hash_original_field = "2D3E21753B38269D4674440F3CF8C6D5", hash_generated_field = "CEF7EBA8F9051BD4EB01CF3D59FD7DB3")

    boolean mViewDestroyed;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.942 -0400", hash_original_field = "0C0B2E8D09BD9B8C826D6F209B1CBE22", hash_generated_field = "6A18A060E129D1B2532BF1934F57C02F")

    boolean mDismissed;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.942 -0400", hash_original_field = "5FF7DE71D66CB2DBCFCF4D4DAB432478", hash_generated_field = "0E39250F08259A9ECD97D7EAA8ACE897")

    boolean mShownByMe;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.942 -0400", hash_original_method = "0534DFBA1BDB91809702979D0F5FEACD", hash_generated_method = "23496EAA8BA27F5B931F748485941DF8")
    public  DialogFragment() {
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.944 -0400", hash_original_method = "E2CE03FA6B4DC8948BADB09C58533480", hash_generated_method = "962D503C076A31A11A2FFB6D500830DE")
    public void setStyle(int style, int theme) {
        mStyle = style;
    if(mStyle == STYLE_NO_FRAME || mStyle == STYLE_NO_INPUT)        
        {
            mTheme = com.android.internal.R.style.Theme_DeviceDefault_Dialog_NoFrame;
        } 
    if(theme != 0)        
        {
            mTheme = theme;
        } 
        
        
        
            
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.946 -0400", hash_original_method = "8FAA759F9028DD0FC2323799369D6711", hash_generated_method = "FA79E5D18165E36B910431A2986A1913")
    public void show(FragmentManager manager, String tag) {
        addTaint(tag.getTaint());
        addTaint(manager.getTaint());
        mDismissed = false;
        mShownByMe = true;
        FragmentTransaction ft = manager.beginTransaction();
        ft.add(this, tag);
        ft.commit();
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.948 -0400", hash_original_method = "040104E30D8A876DF591293449491AA6", hash_generated_method = "76742D274C0F6932863CD2168A2E8FA2")
    public int show(FragmentTransaction transaction, String tag) {
        addTaint(tag.getTaint());
        mDismissed = false;
        mShownByMe = true;
        transaction.add(this, tag);
        mViewDestroyed = false;
        mBackStackId = transaction.commit();
        int varB954FF8BE7F5F0091FD83820D5EFD3AB_2087912579 = (mBackStackId);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_932957988 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_932957988;
        
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.950 -0400", hash_original_method = "DB04742794ECD07699F134042784BBAE", hash_generated_method = "62668574154E1163FCB1B97491A8357D")
    public void dismiss() {
        dismissInternal(false);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.951 -0400", hash_original_method = "C37A06AA62DF1D8997FD4317E6F51B99", hash_generated_method = "56682A4FD8FC4BFCF89A5113DBCA6CC0")
    public void dismissAllowingStateLoss() {
        dismissInternal(true);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.953 -0400", hash_original_method = "D69B3047ADB8F155BAC29C903FDECC6E", hash_generated_method = "A330ED04A9528CE983D5AEDC95A0EBF2")
     void dismissInternal(boolean allowStateLoss) {
        addTaint(allowStateLoss);
    if(mDismissed)        
        {
            return;
        } 
        mDismissed = true;
        mShownByMe = false;
    if(mDialog != null)        
        {
            mDialog.dismiss();
            mDialog = null;
        } 
        mViewDestroyed = true;
    if(mBackStackId >= 0)        
        {
            getFragmentManager().popBackStack(mBackStackId,
                    FragmentManager.POP_BACK_STACK_INCLUSIVE);
            mBackStackId = -1;
        } 
        else
        {
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.remove(this);
    if(allowStateLoss)            
            {
                ft.commitAllowingStateLoss();
            } 
            else
            {
                ft.commit();
            } 
        } 
        
        
            
        
        
        
        
            
            
        
        
        
            
                    
            
        
            
            
            
                
            
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.954 -0400", hash_original_method = "BFDF5D83CE787BE21817622D7064532F", hash_generated_method = "ABC55C629C71FD5E58E525CEF712E830")
    public Dialog getDialog() {
Dialog var91E8306796CF70F787962B1CE02ED969_389857909 =         mDialog;
        var91E8306796CF70F787962B1CE02ED969_389857909.addTaint(taint);
        return var91E8306796CF70F787962B1CE02ED969_389857909;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.954 -0400", hash_original_method = "EDA2E352252479FB515DBD558139BFDA", hash_generated_method = "9EE9EA85FF72145684CAE56698B835EB")
    public int getTheme() {
        int varF33340182B9891501636E62AEA88BE69_228648683 = (mTheme);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1072657193 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1072657193;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.956 -0400", hash_original_method = "50F98C3ABE4F899A123E50B89219D94B", hash_generated_method = "34A254203660D1358F8AA154F57BA9C5")
    public void setCancelable(boolean cancelable) {
        mCancelable = cancelable;
    if(mDialog != null)        
        mDialog.setCancelable(cancelable);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.957 -0400", hash_original_method = "C5B21DACDF63560D5CBEBB813CF00A94", hash_generated_method = "77133C2635D85D6EF1C4411F9C7EB603")
    public boolean isCancelable() {
        boolean var895157BE8E63EE5D1276B7D79E82D10B_357367223 = (mCancelable);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1200941212 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1200941212;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.958 -0400", hash_original_method = "9B3CB0767DA345E448E7161B8A1612ED", hash_generated_method = "498BC809D2A3B6E137721CDFAE7E8200")
    public void setShowsDialog(boolean showsDialog) {
        mShowsDialog = showsDialog;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.959 -0400", hash_original_method = "A66E43B75AC73A59CB0304F6142C6A81", hash_generated_method = "6544E66075B3146266BD27F427E54DB1")
    public boolean getShowsDialog() {
        boolean varBB3DF4294DE62C91BD8B047DF87E1F79_942691824 = (mShowsDialog);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_776433796 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_776433796;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.959 -0400", hash_original_method = "4F6E3ACB3030C4724A44B02F1B4FB1BA", hash_generated_method = "B04DEB10959885684E0C6FCF45E75BB3")
    @Override
    public void onAttach(Activity activity) {
        
        addTaint(activity.getTaint());
        super.onAttach(activity);
    if(!mShownByMe)        
        {
            mDismissed = false;
        } 
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.960 -0400", hash_original_method = "2C281285ACC0A61C67E7A68F54E6F98C", hash_generated_method = "BD19C885100836AD596001408F378257")
    @Override
    public void onDetach() {
        
        super.onDetach();
    if(!mShownByMe && !mDismissed)        
        {
            mDismissed = true;
        } 
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.961 -0400", hash_original_method = "B4FC504618F0AC1ACE07BF1B45E5B9CF", hash_generated_method = "FBA378C447185CF9B49F231C4D236EBF")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        
        super.onCreate(savedInstanceState);
        mShowsDialog = mContainerId == 0;
    if(savedInstanceState != null)        
        {
            mStyle = savedInstanceState.getInt(SAVED_STYLE, STYLE_NORMAL);
            mTheme = savedInstanceState.getInt(SAVED_THEME, 0);
            mCancelable = savedInstanceState.getBoolean(SAVED_CANCELABLE, true);
            mShowsDialog = savedInstanceState.getBoolean(SAVED_SHOWS_DIALOG, mShowsDialog);
            mBackStackId = savedInstanceState.getInt(SAVED_BACK_STACK_ID, -1);
        } 
        
        
        
        
            
            
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.962 -0400", hash_original_method = "EC067D1F5D74A2844592729119AA0EAB", hash_generated_method = "1E3959E74DB9594F8F7C7BF40A50D091")
    @Override
    public LayoutInflater getLayoutInflater(Bundle savedInstanceState) {
    if(!mShowsDialog)        
        {
LayoutInflater var3BD3BF49DA02C3B8A31EA4982EEE0B45_1205052540 =             super.getLayoutInflater(savedInstanceState);
            var3BD3BF49DA02C3B8A31EA4982EEE0B45_1205052540.addTaint(taint);
            return var3BD3BF49DA02C3B8A31EA4982EEE0B45_1205052540;
        } 
        mDialog = onCreateDialog(savedInstanceState);
switch(mStyle){
        case STYLE_NO_INPUT:
        mDialog.getWindow().addFlags(
                        WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE |
                        WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
        case STYLE_NO_FRAME:
        case STYLE_NO_TITLE:
        mDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
}    if(mDialog != null)        
        {
LayoutInflater var60A95D6CBF37F88B7073669F4585C1AA_255342550 =             (LayoutInflater)mDialog.getContext().getSystemService(
                    Context.LAYOUT_INFLATER_SERVICE);
            var60A95D6CBF37F88B7073669F4585C1AA_255342550.addTaint(taint);
            return var60A95D6CBF37F88B7073669F4585C1AA_255342550;
        } 
LayoutInflater varAAEF3E5344A533E1A8E0FBAA0822B7FC_609409581 =         (LayoutInflater)mActivity.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
        varAAEF3E5344A533E1A8E0FBAA0822B7FC_609409581.addTaint(taint);
        return varAAEF3E5344A533E1A8E0FBAA0822B7FC_609409581;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.964 -0400", hash_original_method = "94CB11021A94D8409376FA3A852A41E9", hash_generated_method = "380807519C4B9A80559A6A1494C9E53D")
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        
        addTaint(savedInstanceState.getTaint());
Dialog var5C7D6DC943C129796A12D487F3E52C87_1700016975 =         new Dialog(getActivity(), getTheme());
        var5C7D6DC943C129796A12D487F3E52C87_1700016975.addTaint(taint);
        return var5C7D6DC943C129796A12D487F3E52C87_1700016975;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.964 -0400", hash_original_method = "355678003B9B3B1563024A6589368B65", hash_generated_method = "ED2DA15A78724B9512FA1FE0573630C9")
    public void onCancel(DialogInterface dialog) {
        
        addTaint(dialog.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.965 -0400", hash_original_method = "2F7D346350F9327D0059F752221072E9", hash_generated_method = "109DE52D7C743EFFE3E54F26F86B9A08")
    public void onDismiss(DialogInterface dialog) {
        
        addTaint(dialog.getTaint());
    if(!mViewDestroyed)        
        {
            dismissInternal(true);
        } 
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.968 -0400", hash_original_method = "B958C5F8B85A3937B9102EC0291E48E7", hash_generated_method = "DE0D4F353BA981A63B79D829233AD202")
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        
        addTaint(savedInstanceState.getTaint());
        super.onActivityCreated(savedInstanceState);
    if(!mShowsDialog)        
        {
            return;
        } 
        View view = getView();
    if(view != null)        
        {
    if(view.getParent() != null)            
            {
                IllegalStateException var27ACD4F65CA3D405A1711472A3F088CB_1391388075 = new IllegalStateException("DialogFragment can not be attached to a container view");
                var27ACD4F65CA3D405A1711472A3F088CB_1391388075.addTaint(taint);
                throw var27ACD4F65CA3D405A1711472A3F088CB_1391388075;
            } 
            mDialog.setContentView(view);
        } 
        mDialog.setOwnerActivity(getActivity());
        mDialog.setCancelable(mCancelable);
    if(!mDialog.takeCancelAndDismissListeners("DialogFragment", this, this))        
        {
            IllegalStateException varE25F3CD4D728BFEA1ADFD86B8B0F9675_888454436 = new IllegalStateException(
                    "You can not set Dialog's OnCancelListener or OnDismissListener");
            varE25F3CD4D728BFEA1ADFD86B8B0F9675_888454436.addTaint(taint);
            throw varE25F3CD4D728BFEA1ADFD86B8B0F9675_888454436;
        } 
    if(savedInstanceState != null)        
        {
            Bundle dialogState = savedInstanceState.getBundle(SAVED_DIALOG_STATE_TAG);
    if(dialogState != null)            
            {
                mDialog.onRestoreInstanceState(dialogState);
            } 
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.969 -0400", hash_original_method = "CFA39F554612E24A4614D286AB70C801", hash_generated_method = "22A9B7D22C0088D4B61B9AC60055C91C")
    @Override
    public void onStart() {
        
        super.onStart();
    if(mDialog != null)        
        {
            mViewDestroyed = false;
            mDialog.show();
        } 
        
        
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.970 -0400", hash_original_method = "36AA220233F5FF78B8725588D009C1D9", hash_generated_method = "4B4E4835B7E819A352CB0F7EF051219E")
    @Override
    public void onSaveInstanceState(Bundle outState) {
        
        addTaint(outState.getTaint());
        super.onSaveInstanceState(outState);
    if(mDialog != null)        
        {
            Bundle dialogState = mDialog.onSaveInstanceState();
    if(dialogState != null)            
            {
                outState.putBundle(SAVED_DIALOG_STATE_TAG, dialogState);
            } 
        } 
    if(mStyle != STYLE_NORMAL)        
        {
            outState.putInt(SAVED_STYLE, mStyle);
        } 
    if(mTheme != 0)        
        {
            outState.putInt(SAVED_THEME, mTheme);
        } 
    if(!mCancelable)        
        {
            outState.putBoolean(SAVED_CANCELABLE, mCancelable);
        } 
    if(!mShowsDialog)        
        {
            outState.putBoolean(SAVED_SHOWS_DIALOG, mShowsDialog);
        } 
    if(mBackStackId != -1)        
        {
            outState.putInt(SAVED_BACK_STACK_ID, mBackStackId);
        } 
        
        
        
            
            
                
            
        
        
            
        
        
            
        
        
            
        
        
            
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.971 -0400", hash_original_method = "17D046BD7350E945F7CAD60E8CDA42D0", hash_generated_method = "836D801CCB9C0F6E04195A90ED6B1484")
    @Override
    public void onStop() {
        
        super.onStop();
    if(mDialog != null)        
        {
            mDialog.hide();
        } 
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.972 -0400", hash_original_method = "A28646D8654C968065CCEE80C360B171", hash_generated_method = "29C983C51EF581437D1846703B2E3A2A")
    @Override
    public void onDestroyView() {
        
        super.onDestroyView();
    if(mDialog != null)        
        {
            mViewDestroyed = true;
            mDialog.dismiss();
            mDialog = null;
        } 
        
        
        
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.973 -0400", hash_original_method = "8EE9E1D4B179CD60330B8D8143C75D0D", hash_generated_method = "5E6D1BD9974291D4EE4C1F4B7F0E0247")
    @Override
    public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        addTaint(args[0].getTaint());
        addTaint(writer.getTaint());
        addTaint(fd.getTaint());
        addTaint(prefix.getTaint());
        super.dump(prefix, fd, writer, args);
        writer.print(prefix);
        writer.println("DialogFragment:");
        writer.print(prefix);
        writer.print("  mStyle=");
        writer.print(mStyle);
        writer.print(" mTheme=0x");
        writer.println(Integer.toHexString(mTheme));
        writer.print(prefix);
        writer.print("  mCancelable=");
        writer.print(mCancelable);
        writer.print(" mShowsDialog=");
        writer.print(mShowsDialog);
        writer.print(" mBackStackId=");
        writer.println(mBackStackId);
        writer.print(prefix);
        writer.print("  mDialog=");
        writer.println(mDialog);
        writer.print(prefix);
        writer.print("  mViewDestroyed=");
        writer.print(mViewDestroyed);
        writer.print(" mDismissed=");
        writer.print(mDismissed);
        writer.print(" mShownByMe=");
        writer.println(mShownByMe);
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.974 -0400", hash_original_field = "3353D36CD9BA1728F263F9EFCB2D82DA", hash_generated_field = "2799E9EE0BE29351BF2343EFA521A888")

    public static final int STYLE_NORMAL = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.974 -0400", hash_original_field = "14EE6497368AC36A29BAE72B3B1F58C4", hash_generated_field = "11CB838B0B80C53CBB3DE1A1CDB02BE9")

    public static final int STYLE_NO_TITLE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.974 -0400", hash_original_field = "8955AD96C140B8D481C455C071D2DE5F", hash_generated_field = "68C9068A63469E24D318F617F5D83168")

    public static final int STYLE_NO_FRAME = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.975 -0400", hash_original_field = "61F9A9E833865631586E5F865FE80A82", hash_generated_field = "37C0C9DA86FDBC608BC720AB07FEA0DF")

    public static final int STYLE_NO_INPUT = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.975 -0400", hash_original_field = "E256F366FC40AA8569B871EFE63540D1", hash_generated_field = "94C97F4A0413FA80F711F0AF0957903C")

    private static final String SAVED_DIALOG_STATE_TAG = "android:savedDialogState";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.975 -0400", hash_original_field = "DCEDEDA21056998B4767736B84A32687", hash_generated_field = "32CF27987345FC568CD0673A0881B818")

    private static final String SAVED_STYLE = "android:style";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.975 -0400", hash_original_field = "C0312515681804EF0A79976C8574D83E", hash_generated_field = "2B4A79E71BCE71D18854AA312DB69394")

    private static final String SAVED_THEME = "android:theme";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.976 -0400", hash_original_field = "9152837CB33765D8F7A72A1451393856", hash_generated_field = "05351F680E32E607C372E8D76BD924C2")

    private static final String SAVED_CANCELABLE = "android:cancelable";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.976 -0400", hash_original_field = "1815F2FDD65BD65E6596AE0EB705B5EA", hash_generated_field = "A6049DE77B2A3470E5B9E2A661D1E027")

    private static final String SAVED_SHOWS_DIALOG = "android:showsDialog";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.976 -0400", hash_original_field = "6799157D96D3DA8FC22BD76E4EA265DA", hash_generated_field = "E8BD2BE09F9DEF6BEC48E8E6748CC6BC")

    private static final String SAVED_BACK_STACK_ID = "android:backStackId";
}

