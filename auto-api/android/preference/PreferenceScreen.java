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
    private ListAdapter mRootAdapter;
    private Dialog mDialog;
    private ListView mListView;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.760 -0400", hash_original_method = "B5AE397FE837A4F80688406C82668EB0", hash_generated_method = "5E04A745D6C10CE712E9EC66D420C87B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PreferenceScreen(Context context, AttributeSet attrs) {
        super(context, attrs, com.android.internal.R.attr.preferenceScreenStyle);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.761 -0400", hash_original_method = "452CFBAB5DCB1913FE2E0341A07BD40C", hash_generated_method = "0ED7802B47814FE31799037CEEBEB7BF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ListAdapter getRootAdapter() {
        {
            mRootAdapter = onCreateRootAdapter();
        } //End block
        return (ListAdapter)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mRootAdapter == null) {
            //mRootAdapter = onCreateRootAdapter();
        //}
        //return mRootAdapter;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.762 -0400", hash_original_method = "BDEF03D241AC1847AD8585ACF20EF682", hash_generated_method = "BA548532AB94FCAEFA49A1E4D7AF6CA5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected ListAdapter onCreateRootAdapter() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        ListAdapter varA22CD512215C706A53C5D6FFB9139D1C_1394093507 = (new PreferenceGroupAdapter(this));
        return (ListAdapter)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new PreferenceGroupAdapter(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.763 -0400", hash_original_method = "2DBB2B7A936806881684D64121944804", hash_generated_method = "27ADE6046CBDCE10CF53BFB7F240411C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void bind(ListView listView) {
        dsTaint.addTaint(listView.dsTaint);
        listView.setOnItemClickListener(this);
        listView.setAdapter(getRootAdapter());
        onAttachedToActivity();
        // ---------- Original Method ----------
        //listView.setOnItemClickListener(this);
        //listView.setAdapter(getRootAdapter());
        //onAttachedToActivity();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.764 -0400", hash_original_method = "0BA40F9F4173A0900F716D516252D657", hash_generated_method = "E9EC5495E0A56A45FE434B7757353170")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onClick() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean var682FE98E997ABF8C9978C051E18E8FEC_1501284966 = (getIntent() != null || getFragment() != null || getPreferenceCount() == 0);
        } //End collapsed parenthetic
        showDialog(null);
        // ---------- Original Method ----------
        //if (getIntent() != null || getFragment() != null || getPreferenceCount() == 0) {
            //return;
        //}
        //showDialog(null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.764 -0400", hash_original_method = "D7F699A89F8BCF859CD843DF375163A1", hash_generated_method = "621073EDF1F733976D5649FB4C8F0208")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void showDialog(Bundle state) {
        dsTaint.addTaint(state.dsTaint);
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
            boolean var76F8CCDD9F3913E83E000BD89E277EF3_1576493104 = (TextUtils.isEmpty(title));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.764 -0400", hash_original_method = "1D545D21EF78185D798DBABDC99E4A1B", hash_generated_method = "80749067A1D0EF3FCC6F2C0B27B6091B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onDismiss(DialogInterface dialog) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(dialog.dsTaint);
        mDialog = null;
        getPreferenceManager().removePreferencesScreen(dialog);
        // ---------- Original Method ----------
        //mDialog = null;
        //getPreferenceManager().removePreferencesScreen(dialog);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.765 -0400", hash_original_method = "BFDF5D83CE787BE21817622D7064532F", hash_generated_method = "4F073E538789CB30D5A56AE8F87B31D1")
    @DSModeled(DSC.SAFE)
    public Dialog getDialog() {
        return (Dialog)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mDialog;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.765 -0400", hash_original_method = "4B6165E1F2A74727BF4AF10C08319E83", hash_generated_method = "6039DA150B6A849B7E83E1F596F1B0A1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onItemClick(AdapterView parent, View view, int position, long id) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(id);
        dsTaint.addTaint(position);
        dsTaint.addTaint(parent.dsTaint);
        dsTaint.addTaint(view.dsTaint);
        {
            position -= ((ListView) parent).getHeaderViewsCount();
        } //End block
        Object item;
        item = getRootAdapter().getItem(position);
        Preference preference;
        preference = (Preference) item;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.765 -0400", hash_original_method = "B68456EA6FB78586D0952577C0AE0058", hash_generated_method = "5BBC11AD8A71780A85054C8743749B25")
    @DSModeled(DSC.SAFE)
    @Override
    protected boolean isOnSameScreenAsChildren() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.766 -0400", hash_original_method = "2F4F23BF6B6CEAFD77846C461E2361F8", hash_generated_method = "A777C87E1DA5082DE69DCE260CA98FAB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected Parcelable onSaveInstanceState() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        Parcelable superState;
        superState = super.onSaveInstanceState();
        Dialog dialog;
        dialog = mDialog;
        {
            boolean varF0450B1D8A6B8E6C74D4FB0CACD843E2_1322640500 = (dialog == null || !dialog.isShowing());
        } //End collapsed parenthetic
        SavedState myState;
        myState = new SavedState(superState);
        myState.isDialogShowing = true;
        myState.dialogBundle = dialog.onSaveInstanceState();
        return (Parcelable)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.766 -0400", hash_original_method = "C506903F809F21792322FC067531E660", hash_generated_method = "BB2ACBB0733E50EA171F3278D105EFD2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(state.dsTaint);
        {
            boolean var9146082C23BCEB2285F1054C3B9F84EE_1056608602 = (state == null || !state.getClass().equals(SavedState.class));
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
        boolean isDialogShowing;
        Bundle dialogBundle;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.766 -0400", hash_original_method = "EF20CF8D7035837CBAB7B591A73E7119", hash_generated_method = "6FD044C2AE5C2782D1A9F59A4C492748")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public SavedState(Parcel source) {
            super(source);
            dsTaint.addTaint(source.dsTaint);
            isDialogShowing = source.readInt() == 1;
            dialogBundle = source.readBundle();
            // ---------- Original Method ----------
            //isDialogShowing = source.readInt() == 1;
            //dialogBundle = source.readBundle();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.767 -0400", hash_original_method = "89EB4EC154F05BF905ECA8E02BBD14BC", hash_generated_method = "EA147AD491217C80E82124E2B453B035")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public SavedState(Parcelable superState) {
            super(superState);
            dsTaint.addTaint(superState.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.767 -0400", hash_original_method = "85259FDDC0FCC1496FED09E1FEFE0DC2", hash_generated_method = "F64038D07393F936D7022503C01D0686")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dsTaint.addTaint(flags);
            dsTaint.addTaint(dest.dsTaint);
            super.writeToParcel(dest, flags);
            dest.writeInt(isDialogShowing ? 1 : 0);
            dest.writeBundle(dialogBundle);
            // ---------- Original Method ----------
            //super.writeToParcel(dest, flags);
            //dest.writeInt(isDialogShowing ? 1 : 0);
            //dest.writeBundle(dialogBundle);
        }

        
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.767 -0400", hash_original_method = "E26812089C072DDE1A14AECAA6CD6686", hash_generated_method = "036BDCD859F260B1ECC5E64788F2959E")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public SavedState createFromParcel(Parcel in) {
                dsTaint.addTaint(in.dsTaint);
                SavedState var41ED8F3548F5060881BBE51AB9112A3F_864479242 = (new SavedState(in));
                return (SavedState)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return new SavedState(in);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.767 -0400", hash_original_method = "2D31E9CBAAAE05B696D738324F87FF78", hash_generated_method = "4619F77B08E9877DF92E379FFD52D923")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public SavedState[] newArray(int size) {
                dsTaint.addTaint(size);
                SavedState[] varB5C72E5BBB181D4CA93D7BAA0B8B5E3D_826179296 = (new SavedState[size]);
                return (SavedState[])dsTaint.getTaint();
                // ---------- Original Method ----------
                //return new SavedState[size];
            }

            
}; //Transformed anonymous class
    }


    
}

