package android.preference;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.744 -0400", hash_original_field = "E6D527FD4A6C76D5C6A6EF8043635381", hash_generated_field = "4B36ACD05D99FE341A50201EADA8B6CA")

    private ListAdapter mRootAdapter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.744 -0400", hash_original_field = "58806F2D99FD4DF33CF42E0C232738D7", hash_generated_field = "D9FAD0C1386FC50E3C837906841C2A70")

    private Dialog mDialog;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.744 -0400", hash_original_field = "3F37B910066E368A8F9F00CF63E3318B", hash_generated_field = "7E41BBAA7AC45D61F96A7CC2A5AFF94F")

    private ListView mListView;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.745 -0400", hash_original_method = "B5AE397FE837A4F80688406C82668EB0", hash_generated_method = "56B7C8C1B773D61A49C2CCCD099A7C1B")
    public  PreferenceScreen(Context context, AttributeSet attrs) {
        super(context, attrs, com.android.internal.R.attr.preferenceScreenStyle);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.745 -0400", hash_original_method = "452CFBAB5DCB1913FE2E0341A07BD40C", hash_generated_method = "72C691C6524ED73A19001469618D8038")
    public ListAdapter getRootAdapter() {
    if(mRootAdapter == null)        
        {
            mRootAdapter = onCreateRootAdapter();
        } 
ListAdapter var69C649A5DFA7AE0E39B1A520D14F6450_1254740615 =         mRootAdapter;
        var69C649A5DFA7AE0E39B1A520D14F6450_1254740615.addTaint(taint);
        return var69C649A5DFA7AE0E39B1A520D14F6450_1254740615;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.746 -0400", hash_original_method = "BDEF03D241AC1847AD8585ACF20EF682", hash_generated_method = "A8E6E0DE674C947CCA2858D29A5375A6")
    protected ListAdapter onCreateRootAdapter() {
        
ListAdapter var99AA28967D3A2946B59C82F1D9ABEEE0_46204206 =         new PreferenceGroupAdapter(this);
        var99AA28967D3A2946B59C82F1D9ABEEE0_46204206.addTaint(taint);
        return var99AA28967D3A2946B59C82F1D9ABEEE0_46204206;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.746 -0400", hash_original_method = "2DBB2B7A936806881684D64121944804", hash_generated_method = "2B3EE11B66BB4D7210F78EB82727788A")
    public void bind(ListView listView) {
        addTaint(listView.getTaint());
        listView.setOnItemClickListener(this);
        listView.setAdapter(getRootAdapter());
        onAttachedToActivity();
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.746 -0400", hash_original_method = "0BA40F9F4173A0900F716D516252D657", hash_generated_method = "242F2A2F7647A1BE298DACFF84B8AB6B")
    @Override
    protected void onClick() {
        
    if(getIntent() != null || getFragment() != null || getPreferenceCount() == 0)        
        {
            return;
        } 
        showDialog(null);
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.747 -0400", hash_original_method = "D7F699A89F8BCF859CD843DF375163A1", hash_generated_method = "D5A04764D634B483F11D81A9799FE58F")
    private void showDialog(Bundle state) {
        addTaint(state.getTaint());
        Context context = getContext();
    if(mListView != null)        
        {
            mListView.setAdapter(null);
        } 
        mListView = new ListView(context);
        bind(mListView);
        final CharSequence title = getTitle();
        Dialog dialog = mDialog = new Dialog(context, context.getThemeResId());
    if(TextUtils.isEmpty(title))        
        {
            dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        } 
        else
        {
            dialog.setTitle(title);
        } 
        dialog.setContentView(mListView);
        dialog.setOnDismissListener(this);
    if(state != null)        
        {
            dialog.onRestoreInstanceState(state);
        } 
        getPreferenceManager().addPreferencesScreen(dialog);
        dialog.show();
        
        
        
            
        
        
        
        
        
        
            
        
            
        
        
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.748 -0400", hash_original_method = "1D545D21EF78185D798DBABDC99E4A1B", hash_generated_method = "E254BAF328A87547F1967737960675B6")
    public void onDismiss(DialogInterface dialog) {
        
        addTaint(dialog.getTaint());
        mDialog = null;
        getPreferenceManager().removePreferencesScreen(dialog);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.748 -0400", hash_original_method = "BFDF5D83CE787BE21817622D7064532F", hash_generated_method = "A698D0A15B2476EA8563F85C45922766")
    public Dialog getDialog() {
Dialog var91E8306796CF70F787962B1CE02ED969_279382381 =         mDialog;
        var91E8306796CF70F787962B1CE02ED969_279382381.addTaint(taint);
        return var91E8306796CF70F787962B1CE02ED969_279382381;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.750 -0400", hash_original_method = "4B6165E1F2A74727BF4AF10C08319E83", hash_generated_method = "64F36298B719C88128318CFB0F1B2EB7")
    public void onItemClick(AdapterView parent, View view, int position, long id) {
        
        addTaint(id);
        addTaint(position);
        addTaint(view.getTaint());
        addTaint(parent.getTaint());
    if(parent instanceof ListView)        
        {
            position -= ((ListView) parent).getHeaderViewsCount();
        } 
        Object item = getRootAdapter().getItem(position);
    if(!(item instanceof Preference))        
        return;
        final Preference preference = (Preference) item;
        preference.performClick(this);
        
        
            
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.750 -0400", hash_original_method = "B68456EA6FB78586D0952577C0AE0058", hash_generated_method = "CF25DB06059BA24153F2578D2989595D")
    @Override
    protected boolean isOnSameScreenAsChildren() {
        boolean var68934A3E9455FA72420237EB05902327_669988878 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_516142372 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_516142372;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.752 -0400", hash_original_method = "2F4F23BF6B6CEAFD77846C461E2361F8", hash_generated_method = "B891A900974E603DCD700DC5A4706038")
    @Override
    protected Parcelable onSaveInstanceState() {
        
        final Parcelable superState = super.onSaveInstanceState();
        final Dialog dialog = mDialog;
    if(dialog == null || !dialog.isShowing())        
        {
Parcelable varBA7A3E641095ABD11C9DBE16D47F122C_2124737846 =             superState;
            varBA7A3E641095ABD11C9DBE16D47F122C_2124737846.addTaint(taint);
            return varBA7A3E641095ABD11C9DBE16D47F122C_2124737846;
        } 
        final SavedState myState = new SavedState(superState);
        myState.isDialogShowing = true;
        myState.dialogBundle = dialog.onSaveInstanceState();
Parcelable varA730247CC64767D7A83D25979CFF71FB_1215760172 =         myState;
        varA730247CC64767D7A83D25979CFF71FB_1215760172.addTaint(taint);
        return varA730247CC64767D7A83D25979CFF71FB_1215760172;
        
        
        
        
            
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.752 -0400", hash_original_method = "C506903F809F21792322FC067531E660", hash_generated_method = "8D1F140D5913A647832B8CB90D82789F")
    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        
        addTaint(state.getTaint());
    if(state == null || !state.getClass().equals(SavedState.class))        
        {
            super.onRestoreInstanceState(state);
            return;
        } 
        SavedState myState = (SavedState) state;
        super.onRestoreInstanceState(myState.getSuperState());
    if(myState.isDialogShowing)        
        {
            showDialog(myState.dialogBundle);
        } 
        
        
            
            
        
        
        
        
            
        
    }

    
    private static class SavedState extends BaseSavedState {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.752 -0400", hash_original_field = "C75608B67599FA6C902BFE4C625014D1", hash_generated_field = "C67FBD06D119E38CE3CCD57D66AB1C18")

        boolean isDialogShowing;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.752 -0400", hash_original_field = "3E858F45950CD4CFB6443ACE660B1208", hash_generated_field = "7FEB9968C654EBDB6E3D8BB294FB242A")

        Bundle dialogBundle;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.753 -0400", hash_original_method = "EF20CF8D7035837CBAB7B591A73E7119", hash_generated_method = "235A6412ECD5B38AB4470FD695A9633B")
        public  SavedState(Parcel source) {
            super(source);
            isDialogShowing = source.readInt() == 1;
            dialogBundle = source.readBundle();
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.753 -0400", hash_original_method = "89EB4EC154F05BF905ECA8E02BBD14BC", hash_generated_method = "AB11810075E98F66089A29D0DD89C4B4")
        public  SavedState(Parcelable superState) {
            super(superState);
            addTaint(superState.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.754 -0400", hash_original_method = "85259FDDC0FCC1496FED09E1FEFE0DC2", hash_generated_method = "C502B78D5FDDE7BB7675DF37B837C744")
        @Override
        public void writeToParcel(Parcel dest, int flags) {
            addTaint(flags);
            addTaint(dest.getTaint());
            super.writeToParcel(dest, flags);
            dest.writeInt(isDialogShowing ? 1 : 0);
            dest.writeBundle(dialogBundle);
            
            
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.754 -0400", hash_original_field = "7DF6FB2587CB67E9544A859A8F6E8FF3", hash_generated_field = "263FCDD65C2156B1D1E1B4D9AE8D7FFA")

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

