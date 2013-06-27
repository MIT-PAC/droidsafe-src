package android.preference;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
import android.widget.AbsListView;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

public final class PreferenceScreen extends PreferenceGroup implements AdapterView.OnItemClickListener, DialogInterface.OnDismissListener {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:30.374 -0400", hash_original_field = "E6D527FD4A6C76D5C6A6EF8043635381", hash_generated_field = "4B36ACD05D99FE341A50201EADA8B6CA")

    private ListAdapter mRootAdapter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:30.374 -0400", hash_original_field = "58806F2D99FD4DF33CF42E0C232738D7", hash_generated_field = "D9FAD0C1386FC50E3C837906841C2A70")

    private Dialog mDialog;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:30.374 -0400", hash_original_field = "3F37B910066E368A8F9F00CF63E3318B", hash_generated_field = "7E41BBAA7AC45D61F96A7CC2A5AFF94F")

    private ListView mListView;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:30.375 -0400", hash_original_method = "B5AE397FE837A4F80688406C82668EB0", hash_generated_method = "435A9A54409805D396B31C866AAB5D7B")
    public  PreferenceScreen(Context context, AttributeSet attrs) {
        super(context, attrs, com.android.internal.R.attr.preferenceScreenStyle);
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:30.376 -0400", hash_original_method = "452CFBAB5DCB1913FE2E0341A07BD40C", hash_generated_method = "4C546DF04AFDE86600EAFC9B2DE21F22")
    public ListAdapter getRootAdapter() {
        ListAdapter varB4EAC82CA7396A68D541C85D26508E83_1847930498 = null; //Variable for return #1
        {
            mRootAdapter = onCreateRootAdapter();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1847930498 = mRootAdapter;
        varB4EAC82CA7396A68D541C85D26508E83_1847930498.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1847930498;
        // ---------- Original Method ----------
        //if (mRootAdapter == null) {
            //mRootAdapter = onCreateRootAdapter();
        //}
        //return mRootAdapter;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:30.401 -0400", hash_original_method = "BDEF03D241AC1847AD8585ACF20EF682", hash_generated_method = "FCBB7FAFBABE9A422ED6A9D2B58CDCEA")
    protected ListAdapter onCreateRootAdapter() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        ListAdapter varB4EAC82CA7396A68D541C85D26508E83_1674155497 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1674155497 = new PreferenceGroupAdapter(this);
        varB4EAC82CA7396A68D541C85D26508E83_1674155497.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1674155497;
        // ---------- Original Method ----------
        //return new PreferenceGroupAdapter(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:30.402 -0400", hash_original_method = "2DBB2B7A936806881684D64121944804", hash_generated_method = "FA7105B05D2D1B3393298643466D2774")
    public void bind(ListView listView) {
        listView.setOnItemClickListener(this);
        listView.setAdapter(getRootAdapter());
        onAttachedToActivity();
        addTaint(listView.getTaint());
        // ---------- Original Method ----------
        //listView.setOnItemClickListener(this);
        //listView.setAdapter(getRootAdapter());
        //onAttachedToActivity();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:30.405 -0400", hash_original_method = "0BA40F9F4173A0900F716D516252D657", hash_generated_method = "C31014D46F8B43E88A6C2082DD3AC784")
    @Override
    protected void onClick() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean var682FE98E997ABF8C9978C051E18E8FEC_1977412733 = (getIntent() != null || getFragment() != null || getPreferenceCount() == 0);
        } //End collapsed parenthetic
        showDialog(null);
        // ---------- Original Method ----------
        //if (getIntent() != null || getFragment() != null || getPreferenceCount() == 0) {
            //return;
        //}
        //showDialog(null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:30.406 -0400", hash_original_method = "D7F699A89F8BCF859CD843DF375163A1", hash_generated_method = "DA7DF233F1EE8B22A83DFAA84A8E4E8A")
    private void showDialog(Bundle state) {
        Context context;
        context = getContext();
        {
            mListView.setAdapter(null);
        } //End block
        mListView = new ListView(context);
        bind(mListView);
        CharSequence title;
        title = getTitle();
        Dialog dialog;
        dialog = mDialog = new Dialog(context, context.getThemeResId());
        {
            boolean var76F8CCDD9F3913E83E000BD89E277EF3_1149680883 = (TextUtils.isEmpty(title));
            {
                dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
            } //End block
            {
                dialog.setTitle(title);
            } //End block
        } //End collapsed parenthetic
        dialog.setContentView(mListView);
        dialog.setOnDismissListener(this);
        {
            dialog.onRestoreInstanceState(state);
        } //End block
        getPreferenceManager().addPreferencesScreen(dialog);
        dialog.show();
        addTaint(state.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:30.406 -0400", hash_original_method = "1D545D21EF78185D798DBABDC99E4A1B", hash_generated_method = "809D5FF004CE13C71FFBBAD06CC7BE4C")
    public void onDismiss(DialogInterface dialog) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mDialog = null;
        getPreferenceManager().removePreferencesScreen(dialog);
        addTaint(dialog.getTaint());
        // ---------- Original Method ----------
        //mDialog = null;
        //getPreferenceManager().removePreferencesScreen(dialog);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:30.407 -0400", hash_original_method = "BFDF5D83CE787BE21817622D7064532F", hash_generated_method = "3EAFECC6FDBF3DF6A866FF4CD8B0D56F")
    public Dialog getDialog() {
        Dialog varB4EAC82CA7396A68D541C85D26508E83_813885628 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_813885628 = mDialog;
        varB4EAC82CA7396A68D541C85D26508E83_813885628.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_813885628;
        // ---------- Original Method ----------
        //return mDialog;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:30.419 -0400", hash_original_method = "4B6165E1F2A74727BF4AF10C08319E83", hash_generated_method = "C2847A468724999C04ED6ACD6AE724D0")
    public void onItemClick(AdapterView parent, View view, int position, long id) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            position -= ((ListView) parent).getHeaderViewsCount();
        } //End block
        Object item;
        item = getRootAdapter().getItem(position);
        Preference preference;
        preference = (Preference) item;
        preference.performClick(this);
        addTaint(parent.getTaint());
        addTaint(view.getTaint());
        addTaint(position);
        addTaint(id);
        // ---------- Original Method ----------
        //if (parent instanceof ListView) {
            //position -= ((ListView) parent).getHeaderViewsCount();
        //}
        //Object item = getRootAdapter().getItem(position);
        //if (!(item instanceof Preference)) return;
        //final Preference preference = (Preference) item;
        //preference.performClick(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:30.432 -0400", hash_original_method = "B68456EA6FB78586D0952577C0AE0058", hash_generated_method = "B6E624960BC710256A2EF13E60E3EA83")
    @Override
    protected boolean isOnSameScreenAsChildren() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_280704200 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_280704200;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:30.433 -0400", hash_original_method = "2F4F23BF6B6CEAFD77846C461E2361F8", hash_generated_method = "602E8B12157042F656C1CA2A50C6BA23")
    @Override
    protected Parcelable onSaveInstanceState() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        Parcelable varB4EAC82CA7396A68D541C85D26508E83_1693091931 = null; //Variable for return #1
        Parcelable varB4EAC82CA7396A68D541C85D26508E83_54604039 = null; //Variable for return #2
        Parcelable superState;
        superState = super.onSaveInstanceState();
        Dialog dialog;
        dialog = mDialog;
        {
            boolean varF0450B1D8A6B8E6C74D4FB0CACD843E2_1805607317 = (dialog == null || !dialog.isShowing());
            {
                varB4EAC82CA7396A68D541C85D26508E83_1693091931 = superState;
            } //End block
        } //End collapsed parenthetic
        SavedState myState;
        myState = new SavedState(superState);
        myState.isDialogShowing = true;
        myState.dialogBundle = dialog.onSaveInstanceState();
        varB4EAC82CA7396A68D541C85D26508E83_54604039 = myState;
        Parcelable varA7E53CE21691AB073D9660D615818899_942454259; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_942454259 = varB4EAC82CA7396A68D541C85D26508E83_1693091931;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_942454259 = varB4EAC82CA7396A68D541C85D26508E83_54604039;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_942454259.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_942454259;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:30.435 -0400", hash_original_method = "C506903F809F21792322FC067531E660", hash_generated_method = "01DF4C509153068BAEFC00B3ADAEBC2E")
    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean var9146082C23BCEB2285F1054C3B9F84EE_1854357447 = (state == null || !state.getClass().equals(SavedState.class));
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:30.435 -0400", hash_original_field = "C75608B67599FA6C902BFE4C625014D1", hash_generated_field = "C67FBD06D119E38CE3CCD57D66AB1C18")

        boolean isDialogShowing;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:30.435 -0400", hash_original_field = "3E858F45950CD4CFB6443ACE660B1208", hash_generated_field = "7FEB9968C654EBDB6E3D8BB294FB242A")

        Bundle dialogBundle;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:30.436 -0400", hash_original_method = "EF20CF8D7035837CBAB7B591A73E7119", hash_generated_method = "235A6412ECD5B38AB4470FD695A9633B")
        public  SavedState(Parcel source) {
            super(source);
            isDialogShowing = source.readInt() == 1;
            dialogBundle = source.readBundle();
            // ---------- Original Method ----------
            //isDialogShowing = source.readInt() == 1;
            //dialogBundle = source.readBundle();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:30.436 -0400", hash_original_method = "89EB4EC154F05BF905ECA8E02BBD14BC", hash_generated_method = "AB11810075E98F66089A29D0DD89C4B4")
        public  SavedState(Parcelable superState) {
            super(superState);
            addTaint(superState.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:30.447 -0400", hash_original_method = "85259FDDC0FCC1496FED09E1FEFE0DC2", hash_generated_method = "CDA661218377A8A5886E4CAE8BCD484D")
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:30.447 -0400", hash_original_field = "7DF6FB2587CB67E9544A859A8F6E8FF3", hash_generated_field = "263FCDD65C2156B1D1E1B4D9AE8D7FFA")

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

