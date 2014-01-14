package android.app;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.util.HashMap;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.InputType;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.inputmethod.EditorInfo;

public final class SearchableInfo implements Parcelable {

    /**
     * Creates a context for another activity.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:19.659 -0500", hash_original_method = "AFE36656D81E6CEABC73EB58D0237E28", hash_generated_method = "9D5BF2DF6504F04DF11A5443CE90ED0E")
    
private static Context createActivityContext(Context context, ComponentName activity) {
        Context theirContext = null;
        try {
            theirContext = context.createPackageContext(activity.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            Log.e(LOG_TAG, "Package not found " + activity.getPackageName());
        } catch (java.lang.SecurityException e) {
            Log.e(LOG_TAG, "Can't make context for " + activity.getPackageName(), e);
        }
        
        return theirContext;
    }

    /**
     * Gets search information for the given activity.
     *
     * @param context Context to use for reading activity resources.
     * @param activityInfo Activity to get search information from.
     * @return Search information about the given activity, or {@code null} if
     *         the activity has no or invalid searchability meta-data.
     *
     * @hide For use by SearchManagerService.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:19.705 -0500", hash_original_method = "BF8102CA37E1CB3D4B8160FB4409953C", hash_generated_method = "C9087F66EF2ACABBB571A9E5CD09ECE8")
    
public static SearchableInfo getActivityMetaData(Context context, ActivityInfo activityInfo) {
        // for each component, try to find metadata
        XmlResourceParser xml = 
                activityInfo.loadXmlMetaData(context.getPackageManager(), MD_LABEL_SEARCHABLE);
        if (xml == null) {
            return null;
        }
        ComponentName cName = new ComponentName(activityInfo.packageName, activityInfo.name);
        
        SearchableInfo searchable = getActivityMetaData(context, xml, cName);
        xml.close();
        
        if (DBG) {
            if (searchable != null) {
                Log.d(LOG_TAG, "Checked " + activityInfo.name
                        + ",label=" + searchable.getLabelId()
                        + ",icon=" + searchable.getIconId()
                        + ",suggestAuthority=" + searchable.getSuggestAuthority()
                        + ",target=" + searchable.getSearchActivity().getClassName()
                        + ",global=" + searchable.shouldIncludeInGlobalSearch()
                        + ",settingsDescription=" + searchable.getSettingsDescriptionId()
                        + ",threshold=" + searchable.getSuggestThreshold());
            } else {
                Log.d(LOG_TAG, "Checked " + activityInfo.name + ", no searchable meta-data");
            }
        }
        return searchable;
    }

    /**
     * Get the metadata for a given activity
     * 
     * @param context runtime context
     * @param xml XML parser for reading attributes
     * @param cName The component name of the searchable activity
     * 
     * @result A completely constructed SearchableInfo, or null if insufficient XML data for it
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:19.709 -0500", hash_original_method = "C670177B59F22982DA695FCE4276ED9C", hash_generated_method = "EADD7D7018E653ED46004451CEECF391")
    
private static SearchableInfo getActivityMetaData(Context context, XmlPullParser xml,
            final ComponentName cName)  {
        SearchableInfo result = null;
        Context activityContext = createActivityContext(context, cName);
        if (activityContext == null) return null;

        // in order to use the attributes mechanism, we have to walk the parser
        // forward through the file until it's reading the tag of interest.
        try {
            int tagType = xml.next();
            while (tagType != XmlPullParser.END_DOCUMENT) {
                if (tagType == XmlPullParser.START_TAG) {
                    if (xml.getName().equals(MD_XML_ELEMENT_SEARCHABLE)) {
                        AttributeSet attr = Xml.asAttributeSet(xml);
                        if (attr != null) {
                            try {
                                result = new SearchableInfo(activityContext, attr, cName);
                            } catch (IllegalArgumentException ex) {
                                Log.w(LOG_TAG, "Invalid searchable metadata for " +
                                        cName.flattenToShortString() + ": " + ex.getMessage());
                                return null;
                            }
                        }
                    } else if (xml.getName().equals(MD_XML_ELEMENT_SEARCHABLE_ACTION_KEY)) {
                        if (result == null) {
                            // Can't process an embedded element if we haven't seen the enclosing
                            return null;
                        }
                        AttributeSet attr = Xml.asAttributeSet(xml);
                        if (attr != null) {
                            try {
                                result.addActionKey(new ActionKeyInfo(activityContext, attr));
                            } catch (IllegalArgumentException ex) {
                                Log.w(LOG_TAG, "Invalid action key for " +
                                        cName.flattenToShortString() + ": " + ex.getMessage());
                                return null;
                            }
                        }
                    }
                }
                tagType = xml.next();
            }
        } catch (XmlPullParserException e) {
            Log.w(LOG_TAG, "Reading searchable metadata for " + cName.flattenToShortString(), e);
            return null;
        } catch (IOException e) {
            Log.w(LOG_TAG, "Reading searchable metadata for " + cName.flattenToShortString(), e);
            return null;
        }
        
        return result;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:19.543 -0500", hash_original_field = "B2601CA7445F6BA19FA7884763D82281", hash_generated_field = "1A61763F9CABC9206BB5AE6E570AB8AE")

    private static final boolean DBG = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:19.545 -0500", hash_original_field = "AA0F6CDCCC34654106CEB0180129563C", hash_generated_field = "D203EEF0E4D64BCDB10C02861CF15E1D")

    private static final String LOG_TAG = "SearchableInfo";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:19.548 -0500", hash_original_field = "A4AC8C8A9996C71DA267E22B4BA280DA", hash_generated_field = "8DC8B8435AA10D9DA77441F4BEBF8FCA")

    // TODO how should these be documented for the developer, in a more structured way than 
    // the current long wordy javadoc in SearchManager.java ?
    private static final String MD_LABEL_SEARCHABLE = "android.app.searchable";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:19.551 -0500", hash_original_field = "6E995200E2D256B27DF036CA409650D3", hash_generated_field = "3869A799E84BF0AD918D019051C45943")

    private static final String MD_XML_ELEMENT_SEARCHABLE = "searchable";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:19.553 -0500", hash_original_field = "B1A04B66EC26F04444995310053F58F2", hash_generated_field = "0F40B5E21851701CBDEB2F9B3FA09668")

    private static final String MD_XML_ELEMENT_SEARCHABLE_ACTION_KEY = "actionkey";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:19.555 -0500", hash_original_field = "D4AE9F294538177FC1B4670918328B67", hash_generated_field = "D8C00A0A4A3874113B0ACE14567A0701")

    private static final int SEARCH_MODE_BADGE_LABEL = 0x04;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:19.558 -0500", hash_original_field = "D36A76F1A7947A9916CC17E3213B36ED", hash_generated_field = "2BE46E815786ECF3C252C237E8DD0388")

    private static final int SEARCH_MODE_BADGE_ICON = 0x08;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:19.561 -0500", hash_original_field = "20A1A12FBB3BE06E34832A7A4D592260", hash_generated_field = "EC9F9C22DFAA89E0C2358140824BB50B")

    private static final int SEARCH_MODE_QUERY_REWRITE_FROM_DATA = 0x10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:19.563 -0500", hash_original_field = "D328824CB65314C3ECF6BE009319FEE3", hash_generated_field = "C93683C3AF679B5C3A88B5416B498D23")

    private static final int SEARCH_MODE_QUERY_REWRITE_FROM_TEXT = 0x20;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:19.610 -0500", hash_original_field = "5770A609679FBE499FE677F483DBFCAE", hash_generated_field = "263F1C6CFA6203816856410C0EE21258")

    private static final int VOICE_SEARCH_SHOW_BUTTON = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:19.613 -0500", hash_original_field = "172A606108768FB3B0828DD43369BA96", hash_generated_field = "3E2C11E1F2558FB793D359EDBF9C6C40")

    private static final int VOICE_SEARCH_LAUNCH_WEB_SEARCH = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:19.615 -0500", hash_original_field = "DF3BD1A491F0DB3B43784BF4214C2DF0", hash_generated_field = "8EBDD5ED70EDE6E46658E039B7B2F56C")

    private static final int VOICE_SEARCH_LAUNCH_RECOGNIZER = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.107 -0400", hash_original_field = "203A5BF2CB131E14354D4E080CD68B6E", hash_generated_field = "F3AF64F39E7F85BFEBFD501C152359E7")

    public static final Parcelable.Creator<SearchableInfo> CREATOR
    = new Parcelable.Creator<SearchableInfo>() {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:19.747 -0500", hash_original_method = "C51AD4A0A61C2936B4CD4648DD0FC0FA", hash_generated_method = "78A1C36C4F1DBC9F0398C35E1EE2C239")
        
public SearchableInfo createFromParcel(Parcel in) {
            return new SearchableInfo(in);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:19.749 -0500", hash_original_method = "8B00E73BF156DD8853096E88D875AEBC", hash_generated_method = "8D617613F7E1F9B1525BFD0D26AECBD5")
        
public SearchableInfo[] newArray(int size) {
            return new SearchableInfo[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:19.565 -0500", hash_original_field = "FC8C58816151D3959FC0019C64101DE7", hash_generated_field = "D6FEAD9F73C8FE6EF0F3A12308DAC489")

    private  int mLabelId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:19.568 -0500", hash_original_field = "A2716CB941261EA41D7D9E85DF75018C", hash_generated_field = "E06ADC11A1AEA67BA6BBE28FB67CAB66")

    private  ComponentName mSearchActivity;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:19.570 -0500", hash_original_field = "23CB1316FDE3DA530C90278A97A2A2DC", hash_generated_field = "25DB23E4AD14EAEADA10E3B1B67B84E0")

    private  int mHintId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:19.572 -0500", hash_original_field = "1F8166359676AC7C3C6A12576DB086F2", hash_generated_field = "78FC51630A0764848864D2FF318ABDB8")

    private  int mSearchMode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:19.574 -0500", hash_original_field = "2F5581D491E24A89DF1B173B1206DC9E", hash_generated_field = "EF1ABACE4A55E5A864CC227FE8654387")

    private  int mIconId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:19.576 -0500", hash_original_field = "62145241B66E421E13B98D9BE4DD7AAD", hash_generated_field = "2856721A0AE1EEA9045A703245A329AA")

    private  int mSearchButtonText;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:19.579 -0500", hash_original_field = "BDFF2A548528D4EFDAE224A54157BC7E", hash_generated_field = "1684EE1596133B8BF20C20A9B99DB6B1")

    private  int mSearchInputType;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:19.581 -0500", hash_original_field = "DDEFE3B7E4EB2E8D5A8521B58E43BD8F", hash_generated_field = "9EA71DDC334F5E2B229494AAF349B8CB")

    private  int mSearchImeOptions;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:19.583 -0500", hash_original_field = "2C09B36FF577D61D90AF4738EE753BC2", hash_generated_field = "C0BBF1D6E1CE09EDF5AAB403A08D2B75")

    private  boolean mIncludeInGlobalSearch;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:19.585 -0500", hash_original_field = "48130E8DB875E17E265D47BF82759AF4", hash_generated_field = "D751F4BD314E1B6DDF8E9B3F844D860A")

    private  boolean mQueryAfterZeroResults;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:19.587 -0500", hash_original_field = "957FFA0F3CBD9CEE80BE21B81027AAC3", hash_generated_field = "0B1FDF9F0A272F0F48F41A49A4570B15")

    private  boolean mAutoUrlDetect;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:19.589 -0500", hash_original_field = "C937C2E7FC6331B78E1C30238D260B2D", hash_generated_field = "60CBA5980489FCAAEBAE1EB29ED4DD25")

    private  int mSettingsDescriptionId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:19.591 -0500", hash_original_field = "B652C855CFE50B3DBFA5819BD766E056", hash_generated_field = "C31BFA716E618C0AA35C3A46A49C74A2")

    private  String mSuggestAuthority;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:19.593 -0500", hash_original_field = "DD3119F91ABFD8B664CC652C7712A430", hash_generated_field = "AA401E1B32346E981E53058520319AE6")

    private  String mSuggestPath;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:19.596 -0500", hash_original_field = "45FAF5A123828BCF9061FA720044EC45", hash_generated_field = "CD47AC54D2D5A339E2907D35BBED1C65")

    private  String mSuggestSelection;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:19.599 -0500", hash_original_field = "CA3CF925DD225FB60F16E5EF1C339982", hash_generated_field = "AF16C60CE6AC5E3F7A49FB3100F51C80")

    private  String mSuggestIntentAction;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:19.601 -0500", hash_original_field = "3686ECAC8183DC94EC531F46D7180D64", hash_generated_field = "177360028843579AEBEC82687DC94948")

    private  String mSuggestIntentData;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:19.604 -0500", hash_original_field = "ECF9C2E589476BE2B23B0F6746FCCAF5", hash_generated_field = "79460A51BE9275FE6D19BC9F8F008D8F")

    private  int mSuggestThreshold;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:19.606 -0500", hash_original_field = "D78B104E00EF76219FB3295FC62BC596", hash_generated_field = "9F09B78FBEF5781DCBE1630171033958")

    // since keycodes for the hard keys are < 127. For such values, Integer.valueOf()
    // uses shared Integer objects.
    // This is not final, to allow lazy initialization.
    private HashMap<Integer,ActionKeyInfo> mActionKeys = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:19.608 -0500", hash_original_field = "4870B86CB30A60801F8FBDB92CFB97D0", hash_generated_field = "39020C0C71CE4563CBEEEE8C7CCBA6D7")

    private  String mSuggestProviderPackage;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:19.617 -0500", hash_original_field = "3E685DE82E0B158C890E556DF19A80E6", hash_generated_field = "C80188786C75AB634A90822CFB16E29B")

    private  int mVoiceSearchMode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:19.619 -0500", hash_original_field = "28AD570CD3B24BF1D8FF1E6903E99573", hash_generated_field = "C30E8A2FA03A7817BD9C2B3025108BE2")

    private  int mVoiceLanguageModeId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:19.622 -0500", hash_original_field = "F2024DB32870B824B33B2795A1F4422B", hash_generated_field = "4A40D3223FA01F35360A1936FDE75E64")

    private  int mVoicePromptTextId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:19.624 -0500", hash_original_field = "87E2EE2F737E566178665A147A955C92", hash_generated_field = "3B8852BE17F84107FC1B74FAB195C21B")

    private  int mVoiceLanguageId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:19.626 -0500", hash_original_field = "5A19E3CFDFDDFBC9E258616FE4CBE795", hash_generated_field = "4A5000E9F04A035A8E1D1F76655AE2AC")

    private  int mVoiceMaxResults;

    /**
     * Constructor
     * 
     * Given a ComponentName, get the searchability info
     * and build a local copy of it.  Use the factory, not this.
     * 
     * @param activityContext runtime context for the activity that the searchable info is about.
     * @param attr The attribute set we found in the XML file, contains the values that are used to
     * construct the object.
     * @param cName The component name of the searchable activity
     * @throws IllegalArgumentException if the searchability info is invalid or insufficient
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:19.666 -0500", hash_original_method = "633954995A30C027EA0DC2D487CA3CDA", hash_generated_method = "0D344D95C3F1E0DD281D4DEFB6EC524D")
    
private SearchableInfo(Context activityContext, AttributeSet attr, final ComponentName cName) {
        mSearchActivity = cName;
        
        TypedArray a = activityContext.obtainStyledAttributes(attr,
                com.android.internal.R.styleable.Searchable);
        mSearchMode = a.getInt(com.android.internal.R.styleable.Searchable_searchMode, 0);
        mLabelId = a.getResourceId(com.android.internal.R.styleable.Searchable_label, 0);
        mHintId = a.getResourceId(com.android.internal.R.styleable.Searchable_hint, 0);
        mIconId = a.getResourceId(com.android.internal.R.styleable.Searchable_icon, 0);
        mSearchButtonText = a.getResourceId(
                com.android.internal.R.styleable.Searchable_searchButtonText, 0);
        mSearchInputType = a.getInt(com.android.internal.R.styleable.Searchable_inputType, 
                InputType.TYPE_CLASS_TEXT |
                InputType.TYPE_TEXT_VARIATION_NORMAL);
        mSearchImeOptions = a.getInt(com.android.internal.R.styleable.Searchable_imeOptions, 
                EditorInfo.IME_ACTION_GO);
        mIncludeInGlobalSearch = a.getBoolean(
                com.android.internal.R.styleable.Searchable_includeInGlobalSearch, false);
        mQueryAfterZeroResults = a.getBoolean(
                com.android.internal.R.styleable.Searchable_queryAfterZeroResults, false);
        mAutoUrlDetect = a.getBoolean(
                com.android.internal.R.styleable.Searchable_autoUrlDetect, false);

        mSettingsDescriptionId = a.getResourceId(
                com.android.internal.R.styleable.Searchable_searchSettingsDescription, 0);
        mSuggestAuthority = a.getString(
                com.android.internal.R.styleable.Searchable_searchSuggestAuthority);
        mSuggestPath = a.getString(
                com.android.internal.R.styleable.Searchable_searchSuggestPath);
        mSuggestSelection = a.getString(
                com.android.internal.R.styleable.Searchable_searchSuggestSelection);
        mSuggestIntentAction = a.getString(
                com.android.internal.R.styleable.Searchable_searchSuggestIntentAction);
        mSuggestIntentData = a.getString(
                com.android.internal.R.styleable.Searchable_searchSuggestIntentData);
        mSuggestThreshold = a.getInt(
                com.android.internal.R.styleable.Searchable_searchSuggestThreshold, 0);

        mVoiceSearchMode = 
            a.getInt(com.android.internal.R.styleable.Searchable_voiceSearchMode, 0);
        // TODO this didn't work - came back zero from YouTube
        mVoiceLanguageModeId = 
            a.getResourceId(com.android.internal.R.styleable.Searchable_voiceLanguageModel, 0);
        mVoicePromptTextId = 
            a.getResourceId(com.android.internal.R.styleable.Searchable_voicePromptText, 0);
        mVoiceLanguageId = 
            a.getResourceId(com.android.internal.R.styleable.Searchable_voiceLanguage, 0);
        mVoiceMaxResults = 
            a.getInt(com.android.internal.R.styleable.Searchable_voiceMaxResults, 0);

        a.recycle();

        // get package info for suggestions provider (if any)
        String suggestProviderPackage = null;
        if (mSuggestAuthority != null) {
            PackageManager pm = activityContext.getPackageManager();
            ProviderInfo pi = pm.resolveContentProvider(mSuggestAuthority, 0);
            if (pi != null) {
                suggestProviderPackage = pi.packageName;
            }
        }
        mSuggestProviderPackage = suggestProviderPackage;

        // for now, implement some form of rules - minimal data
        if (mLabelId == 0) {
            throw new IllegalArgumentException("Search label must be a resource reference.");
        }
    }

    /**
     * Instantiates a new SearchableInfo from the data in a Parcel that was
     * previously written with {@link #writeToParcel(Parcel, int)}.
     *
     * @param in The Parcel containing the previously written SearchableInfo,
     * positioned at the location in the buffer where it was written.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:19.754 -0500", hash_original_method = "5317CE2CAB02C1DC0498B77BC3A6FE3A", hash_generated_method = "5317CE2CAB02C1DC0498B77BC3A6FE3A")
    
SearchableInfo(Parcel in) {
        mLabelId = in.readInt();
        mSearchActivity = ComponentName.readFromParcel(in);
        mHintId = in.readInt();
        mSearchMode = in.readInt();
        mIconId = in.readInt();
        mSearchButtonText = in.readInt();
        mSearchInputType = in.readInt();
        mSearchImeOptions = in.readInt();
        mIncludeInGlobalSearch = in.readInt() != 0;
        mQueryAfterZeroResults = in.readInt() != 0;
        mAutoUrlDetect = in.readInt() != 0;
        
        mSettingsDescriptionId = in.readInt();
        mSuggestAuthority = in.readString();
        mSuggestPath = in.readString();
        mSuggestSelection = in.readString();
        mSuggestIntentAction = in.readString();
        mSuggestIntentData = in.readString();
        mSuggestThreshold = in.readInt();

        for (int count = in.readInt(); count > 0; count--) {
            addActionKey(new ActionKeyInfo(in));
        }

        mSuggestProviderPackage = in.readString();
        
        mVoiceSearchMode = in.readInt();
        mVoiceLanguageModeId = in.readInt();
        mVoicePromptTextId = in.readInt();
        mVoiceLanguageId = in.readInt();
        mVoiceMaxResults = in.readInt();
    }           // voiceMaxResults

    /**
     * Gets the search suggestion content provider authority.
     *
     * @return The search suggestions authority, or {@code null} if not set.
     * @see android.R.styleable#Searchable_searchSuggestAuthority
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:19.628 -0500", hash_original_method = "9CC6B7578CF19F95DF8C884BF5987E46", hash_generated_method = "EC23893D732D283C3C3B0ED241B8FC79")
    
public String getSuggestAuthority() {
        return mSuggestAuthority;
    }

    /**
     * Gets the name of the package where the suggestion provider lives,
     * or {@code null}.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:19.630 -0500", hash_original_method = "BE8BEFD3C329420CF7D6C5DA35EA0FF0", hash_generated_method = "8733289C52BD9CF06204F737FA9CC71A")
    
public String getSuggestPackage() {
        return mSuggestProviderPackage;
    }

    /**
     * Gets the component name of the searchable activity.
     *
     * @return A component name, never {@code null}.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:19.632 -0500", hash_original_method = "F3041DF7A3866005E32579E92AEBEE6A", hash_generated_method = "565C255112EEEFB32D36280DE41BEFD1")
    
public ComponentName getSearchActivity() {
        return mSearchActivity;
    }

    /**
     * Checks whether the badge should be a text label.
     *
     * @see android.R.styleable#Searchable_searchMode
     *
     * @hide This feature is deprecated, no need to add it to the API.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:19.634 -0500", hash_original_method = "E8E1D8EA6D890D66AA7ADE8877B0250D", hash_generated_method = "DCB34860B0CD2AB315B0B71B66FB505C")
    
public boolean useBadgeLabel() {
        return 0 != (mSearchMode & SEARCH_MODE_BADGE_LABEL);
    }

    /**
     * Checks whether the badge should be an icon.
     *
     * @see android.R.styleable#Searchable_searchMode
     *
     * @hide This feature is deprecated, no need to add it to the API.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:19.636 -0500", hash_original_method = "FEE9D772AE5D3D19558CCEFFB0D8835C", hash_generated_method = "0C8169242869498E87B1B7CB9AD5D6CC")
    
public boolean useBadgeIcon() {
        return (0 != (mSearchMode & SEARCH_MODE_BADGE_ICON)) && (mIconId != 0);
    }

    /**
     * Checks whether the text in the query field should come from the suggestion intent data.
     *
     * @see android.R.styleable#Searchable_searchMode
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:19.638 -0500", hash_original_method = "B8AED61CE994D23FCE3A1E2344A9A897", hash_generated_method = "84E455895C890BB175A60E44375E3B7B")
    
public boolean shouldRewriteQueryFromData() {
        return 0 != (mSearchMode & SEARCH_MODE_QUERY_REWRITE_FROM_DATA);
    }

    /**
     * Checks whether the text in the query field should come from the suggestion title.
     *
     * @see android.R.styleable#Searchable_searchMode
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:19.641 -0500", hash_original_method = "5A9C6F4DB0BEA2BB31C909F5BB55A3E0", hash_generated_method = "01391EDFBAD2071E255DF8EBB2C3EB51")
    
public boolean shouldRewriteQueryFromText() {
        return 0 != (mSearchMode & SEARCH_MODE_QUERY_REWRITE_FROM_TEXT);
    }

    /**
     * Gets the resource id of the description string to use for this source in system search
     * settings, or {@code 0} if none has been specified.
     *
     * @see android.R.styleable#Searchable_searchSettingsDescription
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:19.643 -0500", hash_original_method = "19684FC2043C1BDB61A3E740D6C19B34", hash_generated_method = "9ABDC05FF9EB4AF11821135B86A7407E")
    
public int getSettingsDescriptionId() {
        return mSettingsDescriptionId;
    }

    /**
     * Gets the content provider path for obtaining search suggestions.
     * 
     * @return The suggestion path, or {@code null} if not set.
     * @see android.R.styleable#Searchable_searchSuggestPath
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:19.645 -0500", hash_original_method = "E8F19B2AFF47ACFE52244E7315CE6CBA", hash_generated_method = "694A77E95A67DA9C300CA8B4E342FCEB")
    
public String getSuggestPath() {
        return mSuggestPath;
    }

    /**
     * Gets the selection for obtaining search suggestions.
     *
     * @see android.R.styleable#Searchable_searchSuggestSelection
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:19.647 -0500", hash_original_method = "03B94AF5E978777AF0A4DF7C1D53B2F0", hash_generated_method = "8E8980105DE99008FBE975F1367C2247")
    
public String getSuggestSelection() {
        return mSuggestSelection;
    }

    /**
     * Gets the optional intent action for use with these suggestions. This is
     * useful if all intents will have the same action
     * (e.g. {@link android.content.Intent#ACTION_VIEW})
     *
     * This can be overriden in any given suggestion using the column
     * {@link SearchManager#SUGGEST_COLUMN_INTENT_ACTION}.
     *
     * @return The default intent action, or {@code null} if not set.
     * @see android.R.styleable#Searchable_searchSuggestIntentAction
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:19.650 -0500", hash_original_method = "41669F0953535FACC4B7926CFCBDA8A1", hash_generated_method = "E3DA79DD5A382F537A22382E0961CCBC")
    
public String getSuggestIntentAction() {
        return mSuggestIntentAction;
    }

    /**
     * Gets the optional intent data for use with these suggestions.  This is
     * useful if all intents will have similar data URIs,
     * but you'll likely need to provide a specific ID as well via the column
     * {@link SearchManager#SUGGEST_COLUMN_INTENT_DATA_ID}, which will be appended to the
     * intent data URI.
     * 
     * This can be overriden in any given suggestion using the column
     * {@link SearchManager#SUGGEST_COLUMN_INTENT_DATA}.
     * 
     * @return The default intent data, or {@code null} if not set.
     * @see android.R.styleable#Searchable_searchSuggestIntentData
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:19.652 -0500", hash_original_method = "E2551EFF005AD652F4CA5C2DEBD8F1C5", hash_generated_method = "B191A4542121F5FC83B78AED5A206150")
    
public String getSuggestIntentData() {
        return mSuggestIntentData;
    }

    /**
     * Gets the suggestion threshold.
     * 
     * @return The suggestion threshold, or {@code 0} if not set.
     * @see android.R.styleable#Searchable_searchSuggestThreshold
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:19.654 -0500", hash_original_method = "EC28F48C38E111E12DD92E58268AB4B1", hash_generated_method = "B8209BFF0FA95D93374D8728371F8723")
    
public int getSuggestThreshold() {
        return mSuggestThreshold;
    }

    /**
     * Get the context for the searchable activity.
     *
     * @param context You need to supply a context to start with
     * @return Returns a context related to the searchable activity
     * @hide
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:19.657 -0500", hash_original_method = "BBBE2BBFCBFB429E05BB475016E66C58", hash_generated_method = "0140257C35E2179720B258D22385764F")
    
public Context getActivityContext(Context context) {
        return createActivityContext(context, mSearchActivity);
    }

    /**
     * Get the context for the suggestions provider.
     *
     * @param context You need to supply a context to start with
     * @param activityContext If we can determine that the provider and the activity are the
     *        same, we'll just return this one.
     * @return Returns a context related to the suggestion provider
     * @hide
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:19.662 -0500", hash_original_method = "B0B7C6DE2D55DA45CA53022A0C4DE186", hash_generated_method = "49B3D33B3BF55A8DE11EE7CBBEAC6272")
    
public Context getProviderContext(Context context, Context activityContext) {
        Context theirContext = null;
        if (mSearchActivity.getPackageName().equals(mSuggestProviderPackage)) {
            return activityContext;
        }
        if (mSuggestProviderPackage != null) {
            try {
                theirContext = context.createPackageContext(mSuggestProviderPackage, 0);
            } catch (PackageManager.NameNotFoundException e) {
                // unexpected, but we deal with this by null-checking theirContext
            } catch (java.lang.SecurityException e) {
                // unexpected, but we deal with this by null-checking theirContext
            }
        }
        return theirContext;
    }

    /**
     * If any action keys were defined for this searchable activity, look up and return.
     * 
     * @param keyCode The key that was pressed
     * @return Returns the action key info, or {@code null} if none defined.
     *
     * @hide ActionKeyInfo is hidden
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:19.700 -0500", hash_original_method = "642EB13C162B9C3DDBE9F6D8F3F1EFAB", hash_generated_method = "4E952B3FA4C5693F9708F07FE257B46F")
    
public ActionKeyInfo findActionKey(int keyCode) {
        if (mActionKeys == null) {
            return null;
        }
        return mActionKeys.get(keyCode);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:19.703 -0500", hash_original_method = "0D70E2215A9C7B06033D45B8CD7DC306", hash_generated_method = "6B3FF0F55A399DBF9550F51580894C3B")
    
private void addActionKey(ActionKeyInfo keyInfo) {
        if (mActionKeys == null) {
            mActionKeys = new HashMap<Integer,ActionKeyInfo>();
        }
        mActionKeys.put(keyInfo.getKeyCode(), keyInfo);
    }

    /**
     * Gets the "label" (user-visible name) of this searchable context. This must be
     * read using the searchable Activity's resources.
     * 
     * @return A resource id, or {@code 0} if no label was specified.
     * @see android.R.styleable#Searchable_label
     *
     * @hide deprecated functionality
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:19.711 -0500", hash_original_method = "32CB8385CEC61194A5C52A7CECC7153B", hash_generated_method = "D95EDE4D6134068998ECAB898A9C455A")
    
public int getLabelId() {
        return mLabelId;
    }

    /**
     * Gets the resource id of the hint text. This must be
     * read using the searchable Activity's resources.
     * 
     * @return A resource id, or {@code 0} if no hint was specified.
     * @see android.R.styleable#Searchable_hint
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:19.713 -0500", hash_original_method = "DC9D54FA42277F7545187887A5854A7A", hash_generated_method = "151EFC8B2E023C83C7C982701028207B")
    
public int getHintId() {
        return mHintId;
    }

    /**
     * Gets the icon id specified by the Searchable_icon meta-data entry. This must be
     * read using the searchable Activity's resources.
     * 
     * @return A resource id, or {@code 0} if no icon was specified.
     * @see android.R.styleable#Searchable_icon
     *
     * @hide deprecated functionality
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:19.716 -0500", hash_original_method = "B3A2F353BC85020D961D66DA378099D0", hash_generated_method = "1D7E641750F98B9A192889E4F4C7198E")
    
public int getIconId() {
        return mIconId;
    }

    /**
     * Checks if the searchable activity wants the voice search button to be shown.
     *
     * @see android.R.styleable#Searchable_voiceSearchMode
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:19.718 -0500", hash_original_method = "BD4587B1756B2E1B29D5C797A6E8E884", hash_generated_method = "ED059A87FEB437C33E40B96F0E387EBD")
    
public boolean getVoiceSearchEnabled() {
        return 0 != (mVoiceSearchMode & VOICE_SEARCH_SHOW_BUTTON);
    }

    /**
     * Checks if voice search should start web search.
     *
     * @see android.R.styleable#Searchable_voiceSearchMode
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:19.720 -0500", hash_original_method = "AD4F5DA741FB0C864BEACDD753D4C8F3", hash_generated_method = "CD7F6120C24225F28D37505E9C101ACD")
    
public boolean getVoiceSearchLaunchWebSearch() {
        return 0 != (mVoiceSearchMode & VOICE_SEARCH_LAUNCH_WEB_SEARCH);
    }
    
    public static class ActionKeyInfo implements Parcelable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:19.669 -0500", hash_original_field = "775BFC50F46781234F24C3F19B2FA89F", hash_generated_field = "6029AC817F6EE7A2286BA05155E91FE2")

        private  int mKeyCode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:19.671 -0500", hash_original_field = "72B443606CC2E63F536A89200ACE59AE", hash_generated_field = "3B81F8E38011672647005EC28AB6705D")

        private  String mQueryActionMsg;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:19.673 -0500", hash_original_field = "06D6BF949378F5BDEEE508C687A7FD9A", hash_generated_field = "8B7684F3BA320FB4D5D226E291D79406")

        private  String mSuggestActionMsg;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:19.676 -0500", hash_original_field = "E701A34414F30E0D56EE9BA753D9FA30", hash_generated_field = "7C9EC47CD295C84807F022D848264755")

        private  String mSuggestActionMsgColumn;

        /**
         * Create one object using attributeset as input data.
         * @param activityContext runtime context of the activity that the action key information
         *        is about.
         * @param attr The attribute set we found in the XML file, contains the values that are used to
         * construct the object.
         * @throws IllegalArgumentException if the action key configuration is invalid
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:19.679 -0500", hash_original_method = "70C4080A4EB7D334155C1E669C19E162", hash_generated_method = "CD028F2229A77428D73114F09F56CCBE")
        
ActionKeyInfo(Context activityContext, AttributeSet attr) {
            TypedArray a = activityContext.obtainStyledAttributes(attr,
                    com.android.internal.R.styleable.SearchableActionKey);

            mKeyCode = a.getInt(
                    com.android.internal.R.styleable.SearchableActionKey_keycode, 0);
            mQueryActionMsg = a.getString(
                    com.android.internal.R.styleable.SearchableActionKey_queryActionMsg);
            mSuggestActionMsg = a.getString(
                    com.android.internal.R.styleable.SearchableActionKey_suggestActionMsg);
            mSuggestActionMsgColumn = a.getString(
                    com.android.internal.R.styleable.SearchableActionKey_suggestActionMsgColumn);
            a.recycle();

            // sanity check.
            if (mKeyCode == 0) {
                throw new IllegalArgumentException("No keycode.");
            } else if ((mQueryActionMsg == null) && 
                    (mSuggestActionMsg == null) && 
                    (mSuggestActionMsgColumn == null)) {
                throw new IllegalArgumentException("No message information.");
            }
        }

        /**
         * Instantiate a new ActionKeyInfo from the data in a Parcel that was
         * previously written with {@link #writeToParcel(Parcel, int)}.
         *
         * @param in The Parcel containing the previously written ActionKeyInfo,
         * positioned at the location in the buffer where it was written.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:19.682 -0500", hash_original_method = "F27ACAC54FD4E2AFDD49ECEAEB99C834", hash_generated_method = "26D3E59CB50F92E3B390B11A524A0412")
        
private ActionKeyInfo(Parcel in) {
            mKeyCode = in.readInt();
            mQueryActionMsg = in.readString();
            mSuggestActionMsg = in.readString();
            mSuggestActionMsgColumn = in.readString();
        }

        /**
         * Gets the key code that this action key info is for.
         * @see android.R.styleable#SearchableActionKey_keycode
         */
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:19.685 -0500", hash_original_method = "AA2A4756B9F9E3EBD53F7A185B310C03", hash_generated_method = "56A94946BD2AEB3B4D809B7B1A77DAEE")
        
public int getKeyCode() {
            return mKeyCode;
        }

        /**
         * Gets the action message to use for queries.
         * @see android.R.styleable#SearchableActionKey_queryActionMsg
         */
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:19.687 -0500", hash_original_method = "0A4F0AAE3D0D859714A4EE4638C2A280", hash_generated_method = "93772DDD5F444E7ECB24B24FB39B57D4")
        
public String getQueryActionMsg() {
            return mQueryActionMsg;
        }

        /**
         * Gets the action message to use for suggestions.
         * @see android.R.styleable#SearchableActionKey_suggestActionMsg
         */
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:19.689 -0500", hash_original_method = "EDCBBABEEE2D0A0DD8ABF8A81407A4FD", hash_generated_method = "6C260678E4CB8DDFDB73C6D0E4FFF40F")
        
public String getSuggestActionMsg() {
            return mSuggestActionMsg;
        }

        /**
         * Gets the name of the column to get the suggestion action message from.
         * @see android.R.styleable#SearchableActionKey_suggestActionMsgColumn
         */
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:19.691 -0500", hash_original_method = "94611E44E9C4989C8B71AAF260F46112", hash_generated_method = "E68876731F7EBF1BE300902B85FE5278")
        
public String getSuggestActionMsgColumn() {
            return mSuggestActionMsgColumn;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:19.694 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
        
public int describeContents() {
            return 0;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:19.696 -0500", hash_original_method = "285E938AE46ECF341AA39A5F914BC19D", hash_generated_method = "E99A3DC102BF0BB7079C1DC02DC5B768")
        
public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(mKeyCode);
            dest.writeString(mQueryActionMsg);
            dest.writeString(mSuggestActionMsg);
            dest.writeString(mSuggestActionMsgColumn);
        }
        
    }

    /**
     * Checks if voice search should start in-app search.
     *
     * @see android.R.styleable#Searchable_voiceSearchMode
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:19.722 -0500", hash_original_method = "8242FA220A8F4815DCA2E78C8BAC691A", hash_generated_method = "3E44592355CF85742965CE50A634775D")
    
public boolean getVoiceSearchLaunchRecognizer() {
        return 0 != (mVoiceSearchMode & VOICE_SEARCH_LAUNCH_RECOGNIZER);
    }

    /**
     * Gets the resource id of the voice search language model string.
     *
     * @return A resource id, or {@code 0} if no language model was specified.
     * @see android.R.styleable#Searchable_voiceLanguageModel
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:19.724 -0500", hash_original_method = "AE92C4DB1762FDEF1095AB548D604322", hash_generated_method = "B2ECBB9F354AE606EA6A7E6222E740CE")
    
public int getVoiceLanguageModeId() {
        return mVoiceLanguageModeId;
    }

    /**
     * Gets the resource id of the voice prompt text string.
     *
     * @return A resource id, or {@code 0} if no voice prompt text was specified.
     * @see android.R.styleable#Searchable_voicePromptText
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:19.726 -0500", hash_original_method = "22DBBDA410168ED4037FF766F7DE7742", hash_generated_method = "E92A73194AA1661CCAAA5221A15DA4FD")
    
public int getVoicePromptTextId() {
        return mVoicePromptTextId;
    }

    /**
     * Gets the resource id of the spoken language to recognize in voice search.
     *
     * @return A resource id, or {@code 0} if no language was specified.
     * @see android.R.styleable#Searchable_voiceLanguage
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:19.728 -0500", hash_original_method = "79CDC130EB87863FB2A36D85DFC36EA0", hash_generated_method = "F5B3093EE692CA0BDDF4E0D15FCA34D9")
    
public int getVoiceLanguageId() {
        return mVoiceLanguageId;
    }

    /**
     * The maximum number of voice recognition results to return.
     *
     * @return the max results count, if specified in the searchable
     *         activity's metadata, or {@code 0} if not specified.
     * @see android.R.styleable#Searchable_voiceMaxResults
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:19.730 -0500", hash_original_method = "77BBA2ED9E38231A613E9BF06CBFC2B7", hash_generated_method = "A1DF65056B987F37E85014C20D3AA519")
    
public int getVoiceMaxResults() {
        return mVoiceMaxResults;
    }

    /**
     * Gets the resource id of replacement text for the "Search" button.
     *
     * @return A resource id, or {@code 0} if no replacement text was specified.
     * @see android.R.styleable#Searchable_searchButtonText
     * @hide This feature is deprecated, no need to add it to the API.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:19.732 -0500", hash_original_method = "A9AA4A30E735A990543D5C1057AC451E", hash_generated_method = "349252A19B395FC5F4401AD7AF5825B8")
    
public int getSearchButtonText() {
        return mSearchButtonText;
    }

    /**
     * Gets the input type as specified in the searchable attributes. This will default to
     * {@link InputType#TYPE_CLASS_TEXT} if not specified (which is appropriate
     * for free text input).
     * 
     * @return the input type
     * @see android.R.styleable#Searchable_inputType
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:19.734 -0500", hash_original_method = "4835EFF052D409983E396160FFE84050", hash_generated_method = "E7AFB2F42BD48557E749F8D913AF0DFE")
    
public int getInputType() {
        return mSearchInputType;
    }

    /**
     * Gets the input method options specified in the searchable attributes.
     * This will default to {@link EditorInfo#IME_ACTION_GO} if not specified (which is
     * appropriate for a search box).
     * 
     * @return the input type
     * @see android.R.styleable#Searchable_imeOptions
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:19.736 -0500", hash_original_method = "1FE8811970C0953B1D5BA2B119F61221", hash_generated_method = "569F51AB84521F8E02418CDB78DB70EA")
    
public int getImeOptions() {
        return mSearchImeOptions;
    }

    /**
     * Checks whether the searchable should be included in global search.
     *
     * @return The value of the {@link android.R.styleable#Searchable_includeInGlobalSearch}
     *         attribute, or {@code false} if the attribute is not set.
     * @see android.R.styleable#Searchable_includeInGlobalSearch
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:19.739 -0500", hash_original_method = "B3CD0EA91E55821485199A61F4C775D4", hash_generated_method = "B6ED1071D2558B7B04C360A56B033244")
    
public boolean shouldIncludeInGlobalSearch() {
        return mIncludeInGlobalSearch;
    }

    /**
     * Checks whether this searchable activity should be queried for suggestions if a prefix
     * of the query has returned no results.
     *
     * @see android.R.styleable#Searchable_queryAfterZeroResults
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:19.741 -0500", hash_original_method = "942D4E1EA5C6469103A344EA38AACE8F", hash_generated_method = "052441FC657C7AFDE50D7B0A486E54D0")
    
public boolean queryAfterZeroResults() {
        return mQueryAfterZeroResults;
    }

    /**
     * Checks whether this searchable activity has auto URL detection turned on.
     *
     * @see android.R.styleable#Searchable_autoUrlDetect
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:19.744 -0500", hash_original_method = "43849E9B2F1DCB4A199E2A722DA4C20F", hash_generated_method = "6EFA064CF0CC9132072FA500D2048A5C")
    
public boolean autoUrlDetect() {
        return mAutoUrlDetect;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:19.756 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:19.759 -0500", hash_original_method = "72AC80AD69CAD17D9DB571EFE399D945", hash_generated_method = "73F0CEB5436EF5538F6DDFBF17FD1F30")
    
public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mLabelId);
        mSearchActivity.writeToParcel(dest, flags);
        dest.writeInt(mHintId);
        dest.writeInt(mSearchMode);
        dest.writeInt(mIconId);
        dest.writeInt(mSearchButtonText);
        dest.writeInt(mSearchInputType);
        dest.writeInt(mSearchImeOptions);
        dest.writeInt(mIncludeInGlobalSearch ? 1 : 0);
        dest.writeInt(mQueryAfterZeroResults ? 1 : 0);
        dest.writeInt(mAutoUrlDetect ? 1 : 0);
        
        dest.writeInt(mSettingsDescriptionId);
        dest.writeString(mSuggestAuthority);
        dest.writeString(mSuggestPath);
        dest.writeString(mSuggestSelection);
        dest.writeString(mSuggestIntentAction);
        dest.writeString(mSuggestIntentData);
        dest.writeInt(mSuggestThreshold);

        if (mActionKeys == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(mActionKeys.size());
            for (ActionKeyInfo actionKey : mActionKeys.values()) {
                actionKey.writeToParcel(dest, flags);
            }
        }

        dest.writeString(mSuggestProviderPackage);

        dest.writeInt(mVoiceSearchMode);
        dest.writeInt(mVoiceLanguageModeId);
        dest.writeInt(mVoicePromptTextId);
        dest.writeInt(mVoiceLanguageId);
        dest.writeInt(mVoiceMaxResults);
    }
    // orphaned legacy method
    public SearchableInfo createFromParcel(Parcel in) {
            return new SearchableInfo(in);
        }
    
    // orphaned legacy method
    public SearchableInfo[] newArray(int size) {
            return new SearchableInfo[size];
        }
    
}

