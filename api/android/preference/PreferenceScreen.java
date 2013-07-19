package android.preference;

// Droidsafe Imports
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public final class PreferenceScreen extends PreferenceGroup implements AdapterView.OnItemClickListener, DialogInterface.OnDismissListener {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.837 -0400", hash_original_field = "E6D527FD4A6C76D5C6A6EF8043635381", hash_generated_field = "4B36ACD05D99FE341A50201EADA8B6CA")

    private ListAdapter mRootAdapter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.837 -0400", hash_original_field = "58806F2D99FD4DF33CF42E0C232738D7", hash_generated_field = "D9FAD0C1386FC50E3C837906841C2A70")

    private Dialog mDialog;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.837 -0400", hash_original_field = "3F37B910066E368A8F9F00CF63E3318B", hash_generated_field = "7E41BBAA7AC45D61F96A7CC2A5AFF94F")

    private ListView mListView;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.837 -0400", hash_original_method = "B5AE397FE837A4F80688406C82668EB0", hash_generated_method = "56B7C8C1B773D61A49C2CCCD099A7C1B")
    public  PreferenceScreen(Context context, AttributeSet attrs) {
        super(context, attrs, com.android.internal.R.attr.preferenceScreenStyle);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.838 -0400", hash_original_method = "452CFBAB5DCB1913FE2E0341A07BD40C", hash_generated_method = "BCA931D58CA501592A7E834C4C343829")
    public ListAdapter getRootAdapter() {
        if(mRootAdapter == null)        
        {
            mRootAdapter = onCreateRootAdapter();
        } //End block
ListAdapter var69C649A5DFA7AE0E39B1A520D14F6450_1134340765 =         mRootAdapter;
        var69C649A5DFA7AE0E39B1A520D14F6450_1134340765.addTaint(taint);
        return var69C649A5DFA7AE0E39B1A520D14F6450_1134340765;
        // ---------- Original Method ----------
        //if (mRootAdapter == null) {
            //mRootAdapter = onCreateRootAdapter();
        //}
        //return mRootAdapter;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.838 -0400", hash_original_method = "BDEF03D241AC1847AD8585ACF20EF682", hash_generated_method = "066110A8AB9E0B8BA45D1DAF1E47162B")
    protected ListAdapter onCreateRootAdapter() {
        //DSFIXME:  CODE0009: Possible callback target function detected
ListAdapter var99AA28967D3A2946B59C82F1D9ABEEE0_71313853 =         new PreferenceGroupAdapter(this);
        var99AA28967D3A2946B59C82F1D9ABEEE0_71313853.addTaint(taint);
        return var99AA28967D3A2946B59C82F1D9ABEEE0_71313853;
        // ---------- Original Method ----------
        //return new PreferenceGroupAdapter(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.838 -0400", hash_original_method = "2DBB2B7A936806881684D64121944804", hash_generated_method = "2B3EE11B66BB4D7210F78EB82727788A")
    public void bind(ListView listView) {
        addTaint(listView.getTaint());
        listView.setOnItemClickListener(this);
        listView.setAdapter(getRootAdapter());
        onAttachedToActivity();
        // ---------- Original Method ----------
        //listView.setOnItemClickListener(this);
        //listView.setAdapter(getRootAdapter());
        //onAttachedToActivity();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.838 -0400", hash_original_method = "0BA40F9F4173A0900F716D516252D657", hash_generated_method = "242F2A2F7647A1BE298DACFF84B8AB6B")
    @Override
    protected void onClick() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        if(getIntent() != null || getFragment() != null || getPreferenceCount() == 0)        
        {
            return;
        } //End block
        showDialog(null);
        // ---------- Original Method ----------
        //if (getIntent() != null || getFragment() != null || getPreferenceCount() == 0) {
            //return;
        //}
        //showDialog(null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.839 -0400", hash_original_method = "D7F699A89F8BCF859CD843DF375163A1", hash_generated_method = "D5A04764D634B483F11D81A9799FE58F")
    private void showDialog(Bundle state) {
        addTaint(state.getTaint());
        Context context = getContext();
        if(mListView != null)        
        {
            mListView.setAdapter(null);
        } //End block
        mListView = new ListView(context);
        bind(mListView);
        final CharSequence title = getTitle();
        Dialog dialog = mDialog = new Dialog(context, context.getThemeResId());
        if(TextUtils.isEmpty(title))        
        {
            dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        } //End block
        else
        {
            dialog.setTitle(title);
        } //End block
        dialog.setContentView(mListView);
        dialog.setOnDismissListener(this);
        if(state != null)        
        {
            dialog.onRestoreInstanceState(state);
        } //End block
        getPreferenceManager().addPreferencesScreen(dialog);
        dialog.show();
        // ---------- Original Method ----------
        //Context context = getContext();
        //if (mListView != null) {
            //mListView.setAdapter(null);
        //}
        //mListView = new ListView(context);
        //bind(mListView);
        //final CharSequence title = getTitle();
        //Dialog dialog = mDialog = new Dialog(context, context.getThemeResId());
        //if (TextUtils.isEmpty(title)) {
            //dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        //} else {
            //dialog.setTitle(title);
        //}
        //dialog.setContentView(mListView);
        //dialog.setOnDismissListener(this);
        //if (state != null) {
            //dialog.onRestoreInstanceState(state);
        //}
        //getPreferenceManager().addPreferencesScreen(dialog);
        //dialog.show();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.839 -0400", hash_original_method = "1D545D21EF78185D798DBABDC99E4A1B", hash_generated_method = "E254BAF328A87547F1967737960675B6")
    public void onDismiss(DialogInterface dialog) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(dialog.getTaint());
        mDialog = null;
        getPreferenceManager().removePreferencesScreen(dialog);
        // ---------- Original Method ----------
        //mDialog = null;
        //getPreferenceManager().removePreferencesScreen(dialog);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.840 -0400", hash_original_method = "BFDF5D83CE787BE21817622D7064532F", hash_generated_method = "19B76CB83A1C0DCFD0759872830C53E1")
    public Dialog getDialog() {
Dialog var91E8306796CF70F787962B1CE02ED969_2016841557 =         mDialog;
        var91E8306796CF70F787962B1CE02ED969_2016841557.addTaint(taint);
        return var91E8306796CF70F787962B1CE02ED969_2016841557;
        // ---------- Original Method ----------
        //return mDialog;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.840 -0400", hash_original_method = "4B6165E1F2A74727BF4AF10C08319E83", hash_generated_method = "64F36298B719C88128318CFB0F1B2EB7")
    public void onItemClick(AdapterView parent, View view, int position, long id) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(id);
        addTaint(position);
        addTaint(view.getTaint());
        addTaint(parent.getTaint());
        if(parent instanceof ListView)        
        {
            position -= ((ListView) parent).getHeaderViewsCount();
        } //End block
        Object item = getRootAdapter().getItem(position);
        if(!(item instanceof Preference))        
        return;
        final Preference preference = (Preference) item;
        preference.performClick(this);
        // ---------- Original Method ----------
        //if (parent instanceof ListView) {
            //position -= ((ListView) parent).getHeaderViewsCount();
        //}
        //Object item = getRootAdapter().getItem(position);
        //if (!(item instanceof Preference)) return;
        //final Preference preference = (Preference) item;
        //preference.performClick(this);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.841 -0400", hash_original_method = "B68456EA6FB78586D0952577C0AE0058", hash_generated_method = "6EB082B698472A9BC968EF8458F26F3C")
    @Override
    protected boolean isOnSameScreenAsChildren() {
        boolean var68934A3E9455FA72420237EB05902327_330997715 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_911191147 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_911191147;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.841 -0400", hash_original_method = "2F4F23BF6B6CEAFD77846C461E2361F8", hash_generated_method = "EE42F56ED9526CD9285374064C0ABC4B")
    @Override
    protected Parcelable onSaveInstanceState() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        final Parcelable superState = super.onSaveInstanceState();
        final Dialog dialog = mDialog;
        if(dialog == null || !dialog.isShowing())        
        {
Parcelable varBA7A3E641095ABD11C9DBE16D47F122C_2033364067 =             superState;
            varBA7A3E641095ABD11C9DBE16D47F122C_2033364067.addTaint(taint);
            return varBA7A3E641095ABD11C9DBE16D47F122C_2033364067;
        } //End block
        final SavedState myState = new SavedState(superState);
        myState.isDialogShowing = true;
        myState.dialogBundle = dialog.onSaveInstanceState();
Parcelable varA730247CC64767D7A83D25979CFF71FB_407685372 =         myState;
        varA730247CC64767D7A83D25979CFF71FB_407685372.addTaint(taint);
        return varA730247CC64767D7A83D25979CFF71FB_407685372;
        // ---------- Original Method ----------
        //final Parcelable superState = super.onSaveInstanceState();
        //final Dialog dialog = mDialog;
        //if (dialog == null || !dialog.isShowing()) {
            //return superState;
        //}
        //final SavedState myState = new SavedState(superState);
        //myState.isDialogShowing = true;
        //myState.dialogBundle = dialog.onSaveInstanceState();
        //return myState;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.842 -0400", hash_original_method = "C506903F809F21792322FC067531E660", hash_generated_method = "8D1F140D5913A647832B8CB90D82789F")
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.842 -0400", hash_original_field = "C75608B67599FA6C902BFE4C625014D1", hash_generated_field = "C67FBD06D119E38CE3CCD57D66AB1C18")

        boolean isDialogShowing;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.842 -0400", hash_original_field = "3E858F45950CD4CFB6443ACE660B1208", hash_generated_field = "7FEB9968C654EBDB6E3D8BB294FB242A")

        Bundle dialogBundle;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.843 -0400", hash_original_method = "EF20CF8D7035837CBAB7B591A73E7119", hash_generated_method = "235A6412ECD5B38AB4470FD695A9633B")
        public  SavedState(Parcel source) {
            super(source);
            isDialogShowing = source.readInt() == 1;
            dialogBundle = source.readBundle();
            // ---------- Original Method ----------
            //isDialogShowing = source.readInt() == 1;
            //dialogBundle = source.readBundle();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.843 -0400", hash_original_method = "89EB4EC154F05BF905ECA8E02BBD14BC", hash_generated_method = "AB11810075E98F66089A29D0DD89C4B4")
        public  SavedState(Parcelable superState) {
            super(superState);
            addTaint(superState.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.843 -0400", hash_original_method = "85259FDDC0FCC1496FED09E1FEFE0DC2", hash_generated_method = "C502B78D5FDDE7BB7675DF37B837C744")
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.844 -0400", hash_original_field = "7DF6FB2587CB67E9544A859A8F6E8FF3", hash_generated_field = "263FCDD65C2156B1D1E1B4D9AE8D7FFA")

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

