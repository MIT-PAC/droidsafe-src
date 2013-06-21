package android.app;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
import java.io.IOException;
import java.util.HashMap;

public final class SearchableInfo implements Parcelable {
    private int mLabelId;
    private ComponentName mSearchActivity;
    private int mHintId;
    private int mSearchMode;
    private int mIconId;
    private int mSearchButtonText;
    private int mSearchInputType;
    private int mSearchImeOptions;
    private boolean mIncludeInGlobalSearch;
    private boolean mQueryAfterZeroResults;
    private boolean mAutoUrlDetect;
    private int mSettingsDescriptionId;
    private String mSuggestAuthority;
    private String mSuggestPath;
    private String mSuggestSelection;
    private String mSuggestIntentAction;
    private String mSuggestIntentData;
    private int mSuggestThreshold;
    private HashMap<Integer,ActionKeyInfo> mActionKeys = null;
    private String mSuggestProviderPackage;
    private int mVoiceSearchMode;
    private int mVoiceLanguageModeId;
    private int mVoicePromptTextId;
    private int mVoiceLanguageId;
    private int mVoiceMaxResults;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.734 -0400", hash_original_method = "633954995A30C027EA0DC2D487CA3CDA", hash_generated_method = "809AF142D9DA93A987977CDBA15CEEB6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private SearchableInfo(Context activityContext, AttributeSet attr, final ComponentName cName) {
        dsTaint.addTaint(activityContext.dsTaint);
        dsTaint.addTaint(cName.dsTaint);
        dsTaint.addTaint(attr.dsTaint);
        TypedArray a;
        a = activityContext.obtainStyledAttributes(attr,
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
        mVoiceLanguageModeId = 
            a.getResourceId(com.android.internal.R.styleable.Searchable_voiceLanguageModel, 0);
        mVoicePromptTextId = 
            a.getResourceId(com.android.internal.R.styleable.Searchable_voicePromptText, 0);
        mVoiceLanguageId = 
            a.getResourceId(com.android.internal.R.styleable.Searchable_voiceLanguage, 0);
        mVoiceMaxResults = 
            a.getInt(com.android.internal.R.styleable.Searchable_voiceMaxResults, 0);
        a.recycle();
        String suggestProviderPackage;
        suggestProviderPackage = null;
        {
            PackageManager pm;
            pm = activityContext.getPackageManager();
            ProviderInfo pi;
            pi = pm.resolveContentProvider(mSuggestAuthority, 0);
            {
                suggestProviderPackage = pi.packageName;
            } //End block
        } //End block
        mSuggestProviderPackage = suggestProviderPackage;
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Search label must be a resource reference.");
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.741 -0400", hash_original_method = "5317CE2CAB02C1DC0498B77BC3A6FE3A", hash_generated_method = "9F203FB50B8A3E066A83A1777E2A158B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     SearchableInfo(Parcel in) {
        dsTaint.addTaint(in.dsTaint);
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
        {
            int count;
            count = in.readInt();
            {
                addActionKey(new ActionKeyInfo(in));
            } //End block
        } //End collapsed parenthetic
        mSuggestProviderPackage = in.readString();
        mVoiceSearchMode = in.readInt();
        mVoiceLanguageModeId = in.readInt();
        mVoicePromptTextId = in.readInt();
        mVoiceLanguageId = in.readInt();
        mVoiceMaxResults = in.readInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.745 -0400", hash_original_method = "9CC6B7578CF19F95DF8C884BF5987E46", hash_generated_method = "0704E9F93F8BD733E2BC1B15BCF7ED47")
    @DSModeled(DSC.SAFE)
    public String getSuggestAuthority() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mSuggestAuthority;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.745 -0400", hash_original_method = "BE8BEFD3C329420CF7D6C5DA35EA0FF0", hash_generated_method = "86C8C7F115E37967D3D73C4843D1B6E2")
    @DSModeled(DSC.SAFE)
    public String getSuggestPackage() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mSuggestProviderPackage;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.746 -0400", hash_original_method = "F3041DF7A3866005E32579E92AEBEE6A", hash_generated_method = "0A4EAD751D6AFD8E4D2D1989962DAAFA")
    @DSModeled(DSC.SAFE)
    public ComponentName getSearchActivity() {
        return (ComponentName)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mSearchActivity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.746 -0400", hash_original_method = "E8E1D8EA6D890D66AA7ADE8877B0250D", hash_generated_method = "7C292BBBE7C53748C214441EB0CD5D62")
    @DSModeled(DSC.SAFE)
    public boolean useBadgeLabel() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return 0 != (mSearchMode & SEARCH_MODE_BADGE_LABEL);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.746 -0400", hash_original_method = "FEE9D772AE5D3D19558CCEFFB0D8835C", hash_generated_method = "24240DA77D31D578928AE496DE95F560")
    @DSModeled(DSC.SAFE)
    public boolean useBadgeIcon() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (0 != (mSearchMode & SEARCH_MODE_BADGE_ICON)) && (mIconId != 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.747 -0400", hash_original_method = "B8AED61CE994D23FCE3A1E2344A9A897", hash_generated_method = "AF8D7DF889BE67611B6ABC5792A87EA0")
    @DSModeled(DSC.SAFE)
    public boolean shouldRewriteQueryFromData() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return 0 != (mSearchMode & SEARCH_MODE_QUERY_REWRITE_FROM_DATA);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.747 -0400", hash_original_method = "5A9C6F4DB0BEA2BB31C909F5BB55A3E0", hash_generated_method = "2E17C800BFBF8C5358B8131A7B2747B8")
    @DSModeled(DSC.SAFE)
    public boolean shouldRewriteQueryFromText() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return 0 != (mSearchMode & SEARCH_MODE_QUERY_REWRITE_FROM_TEXT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.747 -0400", hash_original_method = "19684FC2043C1BDB61A3E740D6C19B34", hash_generated_method = "1818816EFE4A1483B4E47323D322BC8A")
    @DSModeled(DSC.SAFE)
    public int getSettingsDescriptionId() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mSettingsDescriptionId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.747 -0400", hash_original_method = "E8F19B2AFF47ACFE52244E7315CE6CBA", hash_generated_method = "297E1173200432F16A1DFFF8F3ED39A8")
    @DSModeled(DSC.SAFE)
    public String getSuggestPath() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mSuggestPath;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.748 -0400", hash_original_method = "03B94AF5E978777AF0A4DF7C1D53B2F0", hash_generated_method = "D916E523BBD0916DFEE47ECB1D763AE6")
    @DSModeled(DSC.SAFE)
    public String getSuggestSelection() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mSuggestSelection;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.748 -0400", hash_original_method = "41669F0953535FACC4B7926CFCBDA8A1", hash_generated_method = "92C26F36500503DA1A14883FE834F38D")
    @DSModeled(DSC.SAFE)
    public String getSuggestIntentAction() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mSuggestIntentAction;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.748 -0400", hash_original_method = "E2551EFF005AD652F4CA5C2DEBD8F1C5", hash_generated_method = "1C87F0CE6FECC581ECBAAD857DF6EB30")
    @DSModeled(DSC.SAFE)
    public String getSuggestIntentData() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mSuggestIntentData;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.749 -0400", hash_original_method = "EC28F48C38E111E12DD92E58268AB4B1", hash_generated_method = "48D1EDFF0E87E1AA2F366A1F3ED4EA8D")
    @DSModeled(DSC.SAFE)
    public int getSuggestThreshold() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mSuggestThreshold;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.749 -0400", hash_original_method = "BBBE2BBFCBFB429E05BB475016E66C58", hash_generated_method = "AE8554125A9EBF892F5D386B90613B4E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Context getActivityContext(Context context) {
        dsTaint.addTaint(context.dsTaint);
        Context var0AC00466118C2FE48F22AAF277D37CDA_640238745 = (createActivityContext(context, mSearchActivity));
        return (Context)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return createActivityContext(context, mSearchActivity);
    }

    
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.751 -0400", hash_original_method = "B0B7C6DE2D55DA45CA53022A0C4DE186", hash_generated_method = "E459F5D773CF7C3D07E43D0B942AD025")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Context getProviderContext(Context context, Context activityContext) {
        dsTaint.addTaint(activityContext.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        Context theirContext;
        theirContext = null;
        {
            boolean var662F2259AD79A168878A3D91EA7F3EAE_1793774209 = (mSearchActivity.getPackageName().equals(mSuggestProviderPackage));
        } //End collapsed parenthetic
        {
            try 
            {
                theirContext = context.createPackageContext(mSuggestProviderPackage, 0);
            } //End block
            catch (PackageManager.NameNotFoundException e)
            { }
            catch (java.lang.SecurityException e)
            { }
        } //End block
        return (Context)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Context theirContext = null;
        //if (mSearchActivity.getPackageName().equals(mSuggestProviderPackage)) {
            //return activityContext;
        //}
        //if (mSuggestProviderPackage != null) {
            //try {
                //theirContext = context.createPackageContext(mSuggestProviderPackage, 0);
            //} catch (PackageManager.NameNotFoundException e) {
            //} catch (java.lang.SecurityException e) {
            //}
        //}
        //return theirContext;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.752 -0400", hash_original_method = "642EB13C162B9C3DDBE9F6D8F3F1EFAB", hash_generated_method = "E31EE17A9A55E31DBA5D4E64DDB48968")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ActionKeyInfo findActionKey(int keyCode) {
        dsTaint.addTaint(keyCode);
        ActionKeyInfo var69A6B7552B971863D74931D1035CD76F_1972826939 = (mActionKeys.get(keyCode));
        return (ActionKeyInfo)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mActionKeys == null) {
            //return null;
        //}
        //return mActionKeys.get(keyCode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.752 -0400", hash_original_method = "0D70E2215A9C7B06033D45B8CD7DC306", hash_generated_method = "3D4619ECC6978312D5953D5BAB34497D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void addActionKey(ActionKeyInfo keyInfo) {
        dsTaint.addTaint(keyInfo.dsTaint);
        {
            mActionKeys = new HashMap<Integer,ActionKeyInfo>();
        } //End block
        mActionKeys.put(keyInfo.getKeyCode(), keyInfo);
        // ---------- Original Method ----------
        //if (mActionKeys == null) {
            //mActionKeys = new HashMap<Integer,ActionKeyInfo>();
        //}
        //mActionKeys.put(keyInfo.getKeyCode(), keyInfo);
    }

    
        public static SearchableInfo getActivityMetaData(Context context, ActivityInfo activityInfo) {
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

    
        private static SearchableInfo getActivityMetaData(Context context, XmlPullParser xml,
            final ComponentName cName) {
        SearchableInfo result = null;
        Context activityContext = createActivityContext(context, cName);
        if (activityContext == null) return null;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.753 -0400", hash_original_method = "32CB8385CEC61194A5C52A7CECC7153B", hash_generated_method = "A2601A878E1CA31DF548CBB91015373A")
    @DSModeled(DSC.SAFE)
    public int getLabelId() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mLabelId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.753 -0400", hash_original_method = "DC9D54FA42277F7545187887A5854A7A", hash_generated_method = "CA5C4D26826652293334432C82056258")
    @DSModeled(DSC.SAFE)
    public int getHintId() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mHintId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.753 -0400", hash_original_method = "B3A2F353BC85020D961D66DA378099D0", hash_generated_method = "B6A862400A17508777D57B97B4AF4EE2")
    @DSModeled(DSC.SAFE)
    public int getIconId() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mIconId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.754 -0400", hash_original_method = "BD4587B1756B2E1B29D5C797A6E8E884", hash_generated_method = "5121B13542F671B82E4A2CD9E0B6E160")
    @DSModeled(DSC.SAFE)
    public boolean getVoiceSearchEnabled() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return 0 != (mVoiceSearchMode & VOICE_SEARCH_SHOW_BUTTON);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.754 -0400", hash_original_method = "AD4F5DA741FB0C864BEACDD753D4C8F3", hash_generated_method = "0A01FC42D05D3AEFC22EC35F7B53E40A")
    @DSModeled(DSC.SAFE)
    public boolean getVoiceSearchLaunchWebSearch() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return 0 != (mVoiceSearchMode & VOICE_SEARCH_LAUNCH_WEB_SEARCH);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.754 -0400", hash_original_method = "8242FA220A8F4815DCA2E78C8BAC691A", hash_generated_method = "B46EADAD83CEB0C6EF237FC8B506ECC1")
    @DSModeled(DSC.SAFE)
    public boolean getVoiceSearchLaunchRecognizer() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return 0 != (mVoiceSearchMode & VOICE_SEARCH_LAUNCH_RECOGNIZER);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.755 -0400", hash_original_method = "AE92C4DB1762FDEF1095AB548D604322", hash_generated_method = "D0BF587D0C433C2DC6C19BFB480F0CC7")
    @DSModeled(DSC.SAFE)
    public int getVoiceLanguageModeId() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mVoiceLanguageModeId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.755 -0400", hash_original_method = "22DBBDA410168ED4037FF766F7DE7742", hash_generated_method = "F7119F5D90DE3EB747326BC5A28D4409")
    @DSModeled(DSC.SAFE)
    public int getVoicePromptTextId() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mVoicePromptTextId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.755 -0400", hash_original_method = "79CDC130EB87863FB2A36D85DFC36EA0", hash_generated_method = "3C2D0E907929A309122A8C93D0E1D005")
    @DSModeled(DSC.SAFE)
    public int getVoiceLanguageId() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mVoiceLanguageId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.756 -0400", hash_original_method = "77BBA2ED9E38231A613E9BF06CBFC2B7", hash_generated_method = "594B50E33E8BCD62E83EDF2990C6CB83")
    @DSModeled(DSC.SAFE)
    public int getVoiceMaxResults() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mVoiceMaxResults;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.756 -0400", hash_original_method = "A9AA4A30E735A990543D5C1057AC451E", hash_generated_method = "F5E91E041E76DBA50947DEE1DBF1BF80")
    @DSModeled(DSC.SAFE)
    public int getSearchButtonText() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mSearchButtonText;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.756 -0400", hash_original_method = "4835EFF052D409983E396160FFE84050", hash_generated_method = "B00C143E078669F477613E5D15FFAA8B")
    @DSModeled(DSC.SAFE)
    public int getInputType() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mSearchInputType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.757 -0400", hash_original_method = "1FE8811970C0953B1D5BA2B119F61221", hash_generated_method = "AF6FF1A06B763A4E1992D6D8EB8383A6")
    @DSModeled(DSC.SAFE)
    public int getImeOptions() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mSearchImeOptions;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.757 -0400", hash_original_method = "B3CD0EA91E55821485199A61F4C775D4", hash_generated_method = "812FB7FCB60BC1DEC640A4BE33A00B0A")
    @DSModeled(DSC.SAFE)
    public boolean shouldIncludeInGlobalSearch() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mIncludeInGlobalSearch;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.757 -0400", hash_original_method = "942D4E1EA5C6469103A344EA38AACE8F", hash_generated_method = "BC67E2B1EEB071B1825272A2050D71EA")
    @DSModeled(DSC.SAFE)
    public boolean queryAfterZeroResults() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mQueryAfterZeroResults;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.758 -0400", hash_original_method = "43849E9B2F1DCB4A199E2A722DA4C20F", hash_generated_method = "C589F58A4F1E614A101222F35379E207")
    @DSModeled(DSC.SAFE)
    public boolean autoUrlDetect() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mAutoUrlDetect;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.758 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.805 -0400", hash_original_method = "72AC80AD69CAD17D9DB571EFE399D945", hash_generated_method = "C9B1E1E49B143A149FA8B7F846603839")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(dest.dsTaint);
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
        {
            dest.writeInt(0);
        } //End block
        {
            dest.writeInt(mActionKeys.size());
            {
                Iterator<ActionKeyInfo> var4354A710EE5726955FABE86B5D81C787_591672007 = (mActionKeys.values()).iterator();
                var4354A710EE5726955FABE86B5D81C787_591672007.hasNext();
                ActionKeyInfo actionKey = var4354A710EE5726955FABE86B5D81C787_591672007.next();
                {
                    actionKey.writeToParcel(dest, flags);
                } //End block
            } //End collapsed parenthetic
        } //End block
        dest.writeString(mSuggestProviderPackage);
        dest.writeInt(mVoiceSearchMode);
        dest.writeInt(mVoiceLanguageModeId);
        dest.writeInt(mVoicePromptTextId);
        dest.writeInt(mVoiceLanguageId);
        dest.writeInt(mVoiceMaxResults);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    public static class ActionKeyInfo implements Parcelable {
        private int mKeyCode;
        private String mQueryActionMsg;
        private String mSuggestActionMsg;
        private String mSuggestActionMsgColumn;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.813 -0400", hash_original_method = "70C4080A4EB7D334155C1E669C19E162", hash_generated_method = "DC06BF322147A50A0CC789D50D35888A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         ActionKeyInfo(Context activityContext, AttributeSet attr) {
            dsTaint.addTaint(activityContext.dsTaint);
            dsTaint.addTaint(attr.dsTaint);
            TypedArray a;
            a = activityContext.obtainStyledAttributes(attr,
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
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("No keycode.");
            } //End block
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("No message information.");
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.814 -0400", hash_original_method = "F27ACAC54FD4E2AFDD49ECEAEB99C834", hash_generated_method = "27ED1148D22BED59A1DDC2B890327F8A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private ActionKeyInfo(Parcel in) {
            dsTaint.addTaint(in.dsTaint);
            mKeyCode = in.readInt();
            mQueryActionMsg = in.readString();
            mSuggestActionMsg = in.readString();
            mSuggestActionMsgColumn = in.readString();
            // ---------- Original Method ----------
            //mKeyCode = in.readInt();
            //mQueryActionMsg = in.readString();
            //mSuggestActionMsg = in.readString();
            //mSuggestActionMsgColumn = in.readString();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.814 -0400", hash_original_method = "AA2A4756B9F9E3EBD53F7A185B310C03", hash_generated_method = "D0C12970A87AD8CCAE272627E4E9D8B1")
        @DSModeled(DSC.SAFE)
        public int getKeyCode() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return mKeyCode;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.815 -0400", hash_original_method = "0A4F0AAE3D0D859714A4EE4638C2A280", hash_generated_method = "F6E001574DDDBAC460CDCC59DC464FBD")
        @DSModeled(DSC.SAFE)
        public String getQueryActionMsg() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return mQueryActionMsg;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.816 -0400", hash_original_method = "EDCBBABEEE2D0A0DD8ABF8A81407A4FD", hash_generated_method = "F3036B7A417A46E844E2B5C362364359")
        @DSModeled(DSC.SAFE)
        public String getSuggestActionMsg() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return mSuggestActionMsg;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.817 -0400", hash_original_method = "94611E44E9C4989C8B71AAF260F46112", hash_generated_method = "E5E14BFF6CA9AE1B89DE537662E2ABD1")
        @DSModeled(DSC.SAFE)
        public String getSuggestActionMsgColumn() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return mSuggestActionMsgColumn;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.818 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
        @DSModeled(DSC.SAFE)
        public int describeContents() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.818 -0400", hash_original_method = "285E938AE46ECF341AA39A5F914BC19D", hash_generated_method = "AE0DAFD674AE001F8046A507E6614F6F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void writeToParcel(Parcel dest, int flags) {
            dsTaint.addTaint(flags);
            dsTaint.addTaint(dest.dsTaint);
            dest.writeInt(mKeyCode);
            dest.writeString(mQueryActionMsg);
            dest.writeString(mSuggestActionMsg);
            dest.writeString(mSuggestActionMsgColumn);
            // ---------- Original Method ----------
            //dest.writeInt(mKeyCode);
            //dest.writeString(mQueryActionMsg);
            //dest.writeString(mSuggestActionMsg);
            //dest.writeString(mSuggestActionMsgColumn);
        }

        
    }


    
    private static final boolean DBG = false;
    private static final String LOG_TAG = "SearchableInfo";
    private static final String MD_LABEL_SEARCHABLE = "android.app.searchable";
    private static final String MD_XML_ELEMENT_SEARCHABLE = "searchable";
    private static final String MD_XML_ELEMENT_SEARCHABLE_ACTION_KEY = "actionkey";
    private static final int SEARCH_MODE_BADGE_LABEL = 0x04;
    private static final int SEARCH_MODE_BADGE_ICON = 0x08;
    private static final int SEARCH_MODE_QUERY_REWRITE_FROM_DATA = 0x10;
    private static final int SEARCH_MODE_QUERY_REWRITE_FROM_TEXT = 0x20;
    private static final int VOICE_SEARCH_SHOW_BUTTON = 1;
    private static final int VOICE_SEARCH_LAUNCH_WEB_SEARCH = 2;
    private static final int VOICE_SEARCH_LAUNCH_RECOGNIZER = 4;
    public static final Parcelable.Creator<SearchableInfo> CREATOR = new Parcelable.Creator<SearchableInfo>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.819 -0400", hash_original_method = "C51AD4A0A61C2936B4CD4648DD0FC0FA", hash_generated_method = "CF60F73A8EA60C274F4B204F104C999C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public SearchableInfo createFromParcel(Parcel in) {
            dsTaint.addTaint(in.dsTaint);
            SearchableInfo varFEBA9B45B83A7A35E149BD42AD7A3B9F_1331800508 = (new SearchableInfo(in));
            return (SearchableInfo)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new SearchableInfo(in);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.819 -0400", hash_original_method = "8B00E73BF156DD8853096E88D875AEBC", hash_generated_method = "4824C57EBC8CEADE8C7BE575E2185636")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public SearchableInfo[] newArray(int size) {
            dsTaint.addTaint(size);
            SearchableInfo[] var8D82F53A7701F8F45277E3793754CDDC_1503117284 = (new SearchableInfo[size]);
            return (SearchableInfo[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new SearchableInfo[size];
        }

        
}; //Transformed anonymous class
}

