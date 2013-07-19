package android.preference;

// Droidsafe Imports
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.media.RingtoneManager;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class RingtonePreference extends Preference implements PreferenceManager.OnActivityResultListener {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.874 -0400", hash_original_field = "429D9ED5263EDB27ACD4DEA6BD2ED8B4", hash_generated_field = "94A7358A6004BBA5ED4F762F8CB38E98")

    private int mRingtoneType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.874 -0400", hash_original_field = "514AD2406CE06E7C36514763A6C232EE", hash_generated_field = "130B43374579980A9579B58E0CD66AF8")

    private boolean mShowDefault;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.874 -0400", hash_original_field = "79773116418F632DB2912626C537E0DC", hash_generated_field = "8DA646E2063FB9AF7649770779C16018")

    private boolean mShowSilent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.874 -0400", hash_original_field = "86891437037662D667B835C6AB354174", hash_generated_field = "475686F1F8A4FC0EFBA10CFC5E693B3C")

    private int mRequestCode;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.875 -0400", hash_original_method = "29160518A38B8F608A0DA24D9951A92B", hash_generated_method = "B9154469A59A6714846C01B0D46E5096")
    public  RingtonePreference(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        addTaint(defStyle);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        TypedArray a = context.obtainStyledAttributes(attrs,
                com.android.internal.R.styleable.RingtonePreference, defStyle, 0);
        mRingtoneType = a.getInt(com.android.internal.R.styleable.RingtonePreference_ringtoneType,
                RingtoneManager.TYPE_RINGTONE);
        mShowDefault = a.getBoolean(com.android.internal.R.styleable.RingtonePreference_showDefault,
                true);
        mShowSilent = a.getBoolean(com.android.internal.R.styleable.RingtonePreference_showSilent,
                true);
        a.recycle();
        // ---------- Original Method ----------
        //TypedArray a = context.obtainStyledAttributes(attrs,
                //com.android.internal.R.styleable.RingtonePreference, defStyle, 0);
        //mRingtoneType = a.getInt(com.android.internal.R.styleable.RingtonePreference_ringtoneType,
                //RingtoneManager.TYPE_RINGTONE);
        //mShowDefault = a.getBoolean(com.android.internal.R.styleable.RingtonePreference_showDefault,
                //true);
        //mShowSilent = a.getBoolean(com.android.internal.R.styleable.RingtonePreference_showSilent,
                //true);
        //a.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.876 -0400", hash_original_method = "AC92DB267D2F88D8705E896D57E3E92B", hash_generated_method = "02FBA5F098A5FA178F5D075A0C2D3F91")
    public  RingtonePreference(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.ringtonePreferenceStyle);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.876 -0400", hash_original_method = "00710FDF3ABE24D79A48628D9B9EF606", hash_generated_method = "AFBECD0C3DEB7FF402914478B0D8900F")
    public  RingtonePreference(Context context) {
        this(context, null);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.877 -0400", hash_original_method = "1A2D4AB1416848B6CAAD7584C5AE9825", hash_generated_method = "66AEC3036799B67B6391146B2774DA78")
    public int getRingtoneType() {
        int var429D9ED5263EDB27ACD4DEA6BD2ED8B4_389140934 = (mRingtoneType);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_746441678 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_746441678;
        // ---------- Original Method ----------
        //return mRingtoneType;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.878 -0400", hash_original_method = "D7B05FA08D1473DF1FF0F577252B94E4", hash_generated_method = "925E3007BFB79B5DD997814CAF0A2A83")
    public void setRingtoneType(int type) {
        mRingtoneType = type;
        // ---------- Original Method ----------
        //mRingtoneType = type;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.878 -0400", hash_original_method = "1EDF917BBB16A2DD7FDEFF560CC91C95", hash_generated_method = "14F010AA15DEF58146379B00118BF32F")
    public boolean getShowDefault() {
        boolean var514AD2406CE06E7C36514763A6C232EE_398242792 = (mShowDefault);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_695106047 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_695106047;
        // ---------- Original Method ----------
        //return mShowDefault;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.879 -0400", hash_original_method = "14F174C1761E0E1021260A615E0701C9", hash_generated_method = "58C0CBC734FA51C993C87DFEF109783C")
    public void setShowDefault(boolean showDefault) {
        mShowDefault = showDefault;
        // ---------- Original Method ----------
        //mShowDefault = showDefault;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.879 -0400", hash_original_method = "78493F49FCDC7F2B17EDE4C6D3C9ED80", hash_generated_method = "F80D5B6A0A2CE2697F2F89FAEEA8DBB6")
    public boolean getShowSilent() {
        boolean var79773116418F632DB2912626C537E0DC_1199343729 = (mShowSilent);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1692673323 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1692673323;
        // ---------- Original Method ----------
        //return mShowSilent;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.880 -0400", hash_original_method = "96AD95F70E483549E08CF3AF9865FE34", hash_generated_method = "B26664B56E3CC7B2E9360E3FA7D3F7AA")
    public void setShowSilent(boolean showSilent) {
        mShowSilent = showSilent;
        // ---------- Original Method ----------
        //mShowSilent = showSilent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.880 -0400", hash_original_method = "086179E398C72E137D63A84E9C2B557A", hash_generated_method = "1C4B4D333FEFE4D5719A474FD684703A")
    @Override
    protected void onClick() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        Intent intent = new Intent(RingtoneManager.ACTION_RINGTONE_PICKER);
        onPrepareRingtonePickerIntent(intent);
        PreferenceFragment owningFragment = getPreferenceManager().getFragment();
        if(owningFragment != null)        
        {
            owningFragment.startActivityForResult(intent, mRequestCode);
        } //End block
        else
        {
            getPreferenceManager().getActivity().startActivityForResult(intent, mRequestCode);
        } //End block
        // ---------- Original Method ----------
        //Intent intent = new Intent(RingtoneManager.ACTION_RINGTONE_PICKER);
        //onPrepareRingtonePickerIntent(intent);
        //PreferenceFragment owningFragment = getPreferenceManager().getFragment();
        //if (owningFragment != null) {
            //owningFragment.startActivityForResult(intent, mRequestCode);
        //} else {
            //getPreferenceManager().getActivity().startActivityForResult(intent, mRequestCode);
        //}
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.881 -0400", hash_original_method = "3115FC99B9C3EE3EE3896CF41F72D355", hash_generated_method = "0921D75130DB11864792D26D2454F05C")
    protected void onPrepareRingtonePickerIntent(Intent ringtonePickerIntent) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(ringtonePickerIntent.getTaint());
        ringtonePickerIntent.putExtra(RingtoneManager.EXTRA_RINGTONE_EXISTING_URI,
                onRestoreRingtone());
        ringtonePickerIntent.putExtra(RingtoneManager.EXTRA_RINGTONE_SHOW_DEFAULT, mShowDefault);
        if(mShowDefault)        
        {
            ringtonePickerIntent.putExtra(RingtoneManager.EXTRA_RINGTONE_DEFAULT_URI,
                    RingtoneManager.getDefaultUri(getRingtoneType()));
        } //End block
        ringtonePickerIntent.putExtra(RingtoneManager.EXTRA_RINGTONE_SHOW_SILENT, mShowSilent);
        ringtonePickerIntent.putExtra(RingtoneManager.EXTRA_RINGTONE_TYPE, mRingtoneType);
        ringtonePickerIntent.putExtra(RingtoneManager.EXTRA_RINGTONE_TITLE, getTitle());
        // ---------- Original Method ----------
        //ringtonePickerIntent.putExtra(RingtoneManager.EXTRA_RINGTONE_EXISTING_URI,
                //onRestoreRingtone());
        //ringtonePickerIntent.putExtra(RingtoneManager.EXTRA_RINGTONE_SHOW_DEFAULT, mShowDefault);
        //if (mShowDefault) {
            //ringtonePickerIntent.putExtra(RingtoneManager.EXTRA_RINGTONE_DEFAULT_URI,
                    //RingtoneManager.getDefaultUri(getRingtoneType()));
        //}
        //ringtonePickerIntent.putExtra(RingtoneManager.EXTRA_RINGTONE_SHOW_SILENT, mShowSilent);
        //ringtonePickerIntent.putExtra(RingtoneManager.EXTRA_RINGTONE_TYPE, mRingtoneType);
        //ringtonePickerIntent.putExtra(RingtoneManager.EXTRA_RINGTONE_TITLE, getTitle());
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.881 -0400", hash_original_method = "61F749C53ECEF8AEA7C45AB0E864D889", hash_generated_method = "645D8CF6C8F6B76200310492D5D2805F")
    protected void onSaveRingtone(Uri ringtoneUri) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(ringtoneUri.getTaint());
        persistString(ringtoneUri != null ? ringtoneUri.toString() : "");
        // ---------- Original Method ----------
        //persistString(ringtoneUri != null ? ringtoneUri.toString() : "");
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.882 -0400", hash_original_method = "0D14EAB00EC2474BC71AEF293B196DEA", hash_generated_method = "F7B5439CE72B96C49C70C960033A3ED2")
    protected Uri onRestoreRingtone() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        final String uriString = getPersistedString(null);
Uri varB4C485D3C0F7F65526EF1FB88DF2A78B_1314475111 =         !TextUtils.isEmpty(uriString) ? Uri.parse(uriString) : null;
        varB4C485D3C0F7F65526EF1FB88DF2A78B_1314475111.addTaint(taint);
        return varB4C485D3C0F7F65526EF1FB88DF2A78B_1314475111;
        // ---------- Original Method ----------
        //final String uriString = getPersistedString(null);
        //return !TextUtils.isEmpty(uriString) ? Uri.parse(uriString) : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.882 -0400", hash_original_method = "617E38A3300A64CD810B1ADC15B8238E", hash_generated_method = "DD2B8483738202831600DAEF49FAF1B3")
    @Override
    protected Object onGetDefaultValue(TypedArray a, int index) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(index);
        addTaint(a.getTaint());
Object var0AC0FFFECD61C5D7F483CEEBDC224FAC_1417327749 =         a.getString(index);
        var0AC0FFFECD61C5D7F483CEEBDC224FAC_1417327749.addTaint(taint);
        return var0AC0FFFECD61C5D7F483CEEBDC224FAC_1417327749;
        // ---------- Original Method ----------
        //return a.getString(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.883 -0400", hash_original_method = "4538BE331A2E9864F7BFD6437D81EA48", hash_generated_method = "1327348D2E2BCF174494313F629F28D1")
    @Override
    protected void onSetInitialValue(boolean restorePersistedValue, Object defaultValueObj) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(defaultValueObj.getTaint());
        addTaint(restorePersistedValue);
        String defaultValue = (String) defaultValueObj;
        if(restorePersistedValue)        
        {
            return;
        } //End block
        if(!TextUtils.isEmpty(defaultValue))        
        {
            onSaveRingtone(Uri.parse(defaultValue));
        } //End block
        // ---------- Original Method ----------
        //String defaultValue = (String) defaultValueObj;
        //if (restorePersistedValue) {
            //return;
        //}
        //if (!TextUtils.isEmpty(defaultValue)) {
            //onSaveRingtone(Uri.parse(defaultValue));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.884 -0400", hash_original_method = "66AC871F7FDA479CD38955DE80C07AF7", hash_generated_method = "4955AE0E7341B05006E18BA6BB300EAC")
    @Override
    protected void onAttachedToHierarchy(PreferenceManager preferenceManager) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onAttachedToHierarchy(preferenceManager);
        preferenceManager.registerOnActivityResultListener(this);
        mRequestCode = preferenceManager.getNextRequestCode();
        // ---------- Original Method ----------
        //super.onAttachedToHierarchy(preferenceManager);
        //preferenceManager.registerOnActivityResultListener(this);
        //mRequestCode = preferenceManager.getNextRequestCode();
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.885 -0400", hash_original_method = "E8C8E72048A77FCD0D377098E6D641A4", hash_generated_method = "0588760F2F0E8EB1CB2EA9AAFB16847D")
    public boolean onActivityResult(int requestCode, int resultCode, Intent data) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(data.getTaint());
        addTaint(resultCode);
        addTaint(requestCode);
        if(requestCode == mRequestCode)        
        {
            if(data != null)            
            {
                Uri uri = data.getParcelableExtra(RingtoneManager.EXTRA_RINGTONE_PICKED_URI);
                if(callChangeListener(uri != null ? uri.toString() : ""))                
                {
                    onSaveRingtone(uri);
                } //End block
            } //End block
            boolean varB326B5062B2F0E69046810717534CB09_1628823828 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2035634052 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2035634052;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1718264318 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_143197744 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_143197744;
        // ---------- Original Method ----------
        //if (requestCode == mRequestCode) {
            //if (data != null) {
                //Uri uri = data.getParcelableExtra(RingtoneManager.EXTRA_RINGTONE_PICKED_URI);
                //if (callChangeListener(uri != null ? uri.toString() : "")) {
                    //onSaveRingtone(uri);
                //}
            //}
            //return true;
        //}
        //return false;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.886 -0400", hash_original_field = "048D7D525F021CD0B1D5BD6FCB72717B", hash_generated_field = "03561407E8406E5A39E47D0AFC27E984")

    private static final String TAG = "RingtonePreference";
}

