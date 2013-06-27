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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.816 -0400", hash_original_field = "D057B2BB85264BE6A162A2050E03E209", hash_generated_field = "D6FEAD9F73C8FE6EF0F3A12308DAC489")

    private int mLabelId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.817 -0400", hash_original_field = "F30792FDD94B575151C8430D4E5DBF29", hash_generated_field = "E06ADC11A1AEA67BA6BBE28FB67CAB66")

    private ComponentName mSearchActivity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.817 -0400", hash_original_field = "F9B6782402E61448FE6CDDBE1079CDEE", hash_generated_field = "25DB23E4AD14EAEADA10E3B1B67B84E0")

    private int mHintId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.834 -0400", hash_original_field = "89070FC64F8E69B4F0C300A298DB823A", hash_generated_field = "78FC51630A0764848864D2FF318ABDB8")

    private int mSearchMode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.834 -0400", hash_original_field = "D7630CF52154C2427A7112C0FFA081B1", hash_generated_field = "EF1ABACE4A55E5A864CC227FE8654387")

    private int mIconId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.835 -0400", hash_original_field = "0826F96358F107FED726F6D2004E0424", hash_generated_field = "2856721A0AE1EEA9045A703245A329AA")

    private int mSearchButtonText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.836 -0400", hash_original_field = "E1AFE3AE8B9005A0BAB937E2BF25305C", hash_generated_field = "1684EE1596133B8BF20C20A9B99DB6B1")

    private int mSearchInputType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.842 -0400", hash_original_field = "220E297C1E16D14AA9F51E010AAA5BDD", hash_generated_field = "9EA71DDC334F5E2B229494AAF349B8CB")

    private int mSearchImeOptions;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.843 -0400", hash_original_field = "DBAA85CB46828DF39EBA185991B74924", hash_generated_field = "C0BBF1D6E1CE09EDF5AAB403A08D2B75")

    private boolean mIncludeInGlobalSearch;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.843 -0400", hash_original_field = "2AE4A58FAB921A667862F2E5E851BFC8", hash_generated_field = "D751F4BD314E1B6DDF8E9B3F844D860A")

    private boolean mQueryAfterZeroResults;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.844 -0400", hash_original_field = "B0F477017B3A20C523CB75C2CB2CCA61", hash_generated_field = "0B1FDF9F0A272F0F48F41A49A4570B15")

    private boolean mAutoUrlDetect;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.844 -0400", hash_original_field = "4C0CE3F626ABB04381EC5B6DA773593E", hash_generated_field = "60CBA5980489FCAAEBAE1EB29ED4DD25")

    private int mSettingsDescriptionId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.845 -0400", hash_original_field = "6CBCEE9BDAD542F0160B7269139095AC", hash_generated_field = "C31BFA716E618C0AA35C3A46A49C74A2")

    private String mSuggestAuthority;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.860 -0400", hash_original_field = "740A9F5C1D9A70BB5CC84DADAB562D5C", hash_generated_field = "AA401E1B32346E981E53058520319AE6")

    private String mSuggestPath;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.860 -0400", hash_original_field = "7630364755A9100D83BD3C726C010E2C", hash_generated_field = "CD47AC54D2D5A339E2907D35BBED1C65")

    private String mSuggestSelection;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.861 -0400", hash_original_field = "6B985FAE9A7932531A557F2B2581B20F", hash_generated_field = "AF16C60CE6AC5E3F7A49FB3100F51C80")

    private String mSuggestIntentAction;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.861 -0400", hash_original_field = "CD0DFD9D95BAC58FF7C23EA5C480FA1D", hash_generated_field = "177360028843579AEBEC82687DC94948")

    private String mSuggestIntentData;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.862 -0400", hash_original_field = "22B05A6765211453BABA6F8A79424691", hash_generated_field = "79460A51BE9275FE6D19BC9F8F008D8F")

    private int mSuggestThreshold;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.874 -0400", hash_original_field = "9500EA58BACD01CE281AD3DB271EE6E4", hash_generated_field = "C9D6635EBF55DCF3ADED92CBCFA44CB7")

    private HashMap<Integer,ActionKeyInfo> mActionKeys = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.875 -0400", hash_original_field = "CF58932A35DA62EEA6407052FA331D97", hash_generated_field = "39020C0C71CE4563CBEEEE8C7CCBA6D7")

    private String mSuggestProviderPackage;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.875 -0400", hash_original_field = "1825B0D843C0E16C6D3686963AC2A7F0", hash_generated_field = "C80188786C75AB634A90822CFB16E29B")

    private int mVoiceSearchMode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.876 -0400", hash_original_field = "03F77744C7D51598EA5C20BAD9A6FF8E", hash_generated_field = "C30E8A2FA03A7817BD9C2B3025108BE2")

    private int mVoiceLanguageModeId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.026 -0400", hash_original_field = "05F56573DEFC97C433D25F4CAEBE94CC", hash_generated_field = "4A40D3223FA01F35360A1936FDE75E64")

    private int mVoicePromptTextId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.027 -0400", hash_original_field = "E66DD97243D1B6526BF8E4264871DB77", hash_generated_field = "3B8852BE17F84107FC1B74FAB195C21B")

    private int mVoiceLanguageId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.027 -0400", hash_original_field = "46CC12A5AB44CBE81DA898323B8ABD6B", hash_generated_field = "4A5000E9F04A035A8E1D1F76655AE2AC")

    private int mVoiceMaxResults;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.085 -0400", hash_original_method = "633954995A30C027EA0DC2D487CA3CDA", hash_generated_method = "E99F4CD5E973274697A6864325919C11")
    private  SearchableInfo(Context activityContext, AttributeSet attr, final ComponentName cName) {
        mSearchActivity = cName;
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
        addTaint(activityContext.getTaint());
        addTaint(attr.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.125 -0400", hash_original_method = "5317CE2CAB02C1DC0498B77BC3A6FE3A", hash_generated_method = "CFE3D2BF157F47BD1222BF735A048036")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.134 -0400", hash_original_method = "9CC6B7578CF19F95DF8C884BF5987E46", hash_generated_method = "4708688C64E3D29739B353CDDB625777")
    public String getSuggestAuthority() {
        String varB4EAC82CA7396A68D541C85D26508E83_1258898631 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1258898631 = mSuggestAuthority;
        varB4EAC82CA7396A68D541C85D26508E83_1258898631.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1258898631;
        // ---------- Original Method ----------
        //return mSuggestAuthority;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.154 -0400", hash_original_method = "BE8BEFD3C329420CF7D6C5DA35EA0FF0", hash_generated_method = "26493269356B2DEEFC8A7BE05F880B6E")
    public String getSuggestPackage() {
        String varB4EAC82CA7396A68D541C85D26508E83_790783955 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_790783955 = mSuggestProviderPackage;
        varB4EAC82CA7396A68D541C85D26508E83_790783955.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_790783955;
        // ---------- Original Method ----------
        //return mSuggestProviderPackage;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.159 -0400", hash_original_method = "F3041DF7A3866005E32579E92AEBEE6A", hash_generated_method = "D1F682736804378F405F62EF59D3A23C")
    public ComponentName getSearchActivity() {
        ComponentName varB4EAC82CA7396A68D541C85D26508E83_184930923 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_184930923 = mSearchActivity;
        varB4EAC82CA7396A68D541C85D26508E83_184930923.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_184930923;
        // ---------- Original Method ----------
        //return mSearchActivity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.183 -0400", hash_original_method = "E8E1D8EA6D890D66AA7ADE8877B0250D", hash_generated_method = "7D3C0544E7181B73BAEF3CE85508C11F")
    public boolean useBadgeLabel() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_462559889 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_462559889;
        // ---------- Original Method ----------
        //return 0 != (mSearchMode & SEARCH_MODE_BADGE_LABEL);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.184 -0400", hash_original_method = "FEE9D772AE5D3D19558CCEFFB0D8835C", hash_generated_method = "E8B85BF76012905A99DAFB4D3B661587")
    public boolean useBadgeIcon() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1987662948 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1987662948;
        // ---------- Original Method ----------
        //return (0 != (mSearchMode & SEARCH_MODE_BADGE_ICON)) && (mIconId != 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.202 -0400", hash_original_method = "B8AED61CE994D23FCE3A1E2344A9A897", hash_generated_method = "CB61179AFB3E24505EDDBF4FC336C122")
    public boolean shouldRewriteQueryFromData() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_167287094 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_167287094;
        // ---------- Original Method ----------
        //return 0 != (mSearchMode & SEARCH_MODE_QUERY_REWRITE_FROM_DATA);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.204 -0400", hash_original_method = "5A9C6F4DB0BEA2BB31C909F5BB55A3E0", hash_generated_method = "76606293D656E8FA0766AE2F1EFA228C")
    public boolean shouldRewriteQueryFromText() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_691385495 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_691385495;
        // ---------- Original Method ----------
        //return 0 != (mSearchMode & SEARCH_MODE_QUERY_REWRITE_FROM_TEXT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.205 -0400", hash_original_method = "19684FC2043C1BDB61A3E740D6C19B34", hash_generated_method = "E67A1C9BC5DD90FD419259D0D9D34214")
    public int getSettingsDescriptionId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1307889516 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1307889516;
        // ---------- Original Method ----------
        //return mSettingsDescriptionId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.226 -0400", hash_original_method = "E8F19B2AFF47ACFE52244E7315CE6CBA", hash_generated_method = "A85AE24A2B8105ED4B5360E862A1F350")
    public String getSuggestPath() {
        String varB4EAC82CA7396A68D541C85D26508E83_29769205 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_29769205 = mSuggestPath;
        varB4EAC82CA7396A68D541C85D26508E83_29769205.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_29769205;
        // ---------- Original Method ----------
        //return mSuggestPath;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.249 -0400", hash_original_method = "03B94AF5E978777AF0A4DF7C1D53B2F0", hash_generated_method = "4FD7334CD3FDD9B7D266C60B2328EEBC")
    public String getSuggestSelection() {
        String varB4EAC82CA7396A68D541C85D26508E83_881182713 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_881182713 = mSuggestSelection;
        varB4EAC82CA7396A68D541C85D26508E83_881182713.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_881182713;
        // ---------- Original Method ----------
        //return mSuggestSelection;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.252 -0400", hash_original_method = "41669F0953535FACC4B7926CFCBDA8A1", hash_generated_method = "289ACC0FB9F1BB5A0C79951AD902BF95")
    public String getSuggestIntentAction() {
        String varB4EAC82CA7396A68D541C85D26508E83_451697495 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_451697495 = mSuggestIntentAction;
        varB4EAC82CA7396A68D541C85D26508E83_451697495.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_451697495;
        // ---------- Original Method ----------
        //return mSuggestIntentAction;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.282 -0400", hash_original_method = "E2551EFF005AD652F4CA5C2DEBD8F1C5", hash_generated_method = "C955BA7A98D3FC20EA682EC66BD0AC1B")
    public String getSuggestIntentData() {
        String varB4EAC82CA7396A68D541C85D26508E83_1032673521 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1032673521 = mSuggestIntentData;
        varB4EAC82CA7396A68D541C85D26508E83_1032673521.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1032673521;
        // ---------- Original Method ----------
        //return mSuggestIntentData;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.284 -0400", hash_original_method = "EC28F48C38E111E12DD92E58268AB4B1", hash_generated_method = "749985D01EF8D91EB0B5D782348D76B2")
    public int getSuggestThreshold() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1797168450 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1797168450;
        // ---------- Original Method ----------
        //return mSuggestThreshold;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.286 -0400", hash_original_method = "BBBE2BBFCBFB429E05BB475016E66C58", hash_generated_method = "688D613D757DEA5C669F4AFD5899024B")
    public Context getActivityContext(Context context) {
        Context varB4EAC82CA7396A68D541C85D26508E83_411981004 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_411981004 = createActivityContext(context, mSearchActivity);
        addTaint(context.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_411981004.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_411981004;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.313 -0400", hash_original_method = "B0B7C6DE2D55DA45CA53022A0C4DE186", hash_generated_method = "98A9C8E540683A9631CE34190C0B7BCB")
    public Context getProviderContext(Context context, Context activityContext) {
        Context varB4EAC82CA7396A68D541C85D26508E83_2023634796 = null; //Variable for return #1
        Context varB4EAC82CA7396A68D541C85D26508E83_415140421 = null; //Variable for return #2
        Context theirContext;
        theirContext = null;
        {
            boolean var662F2259AD79A168878A3D91EA7F3EAE_705584264 = (mSearchActivity.getPackageName().equals(mSuggestProviderPackage));
            {
                varB4EAC82CA7396A68D541C85D26508E83_2023634796 = activityContext;
            } //End block
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
        varB4EAC82CA7396A68D541C85D26508E83_415140421 = theirContext;
        addTaint(context.getTaint());
        addTaint(activityContext.getTaint());
        Context varA7E53CE21691AB073D9660D615818899_1596203680; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1596203680 = varB4EAC82CA7396A68D541C85D26508E83_2023634796;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1596203680 = varB4EAC82CA7396A68D541C85D26508E83_415140421;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1596203680.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1596203680;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.330 -0400", hash_original_method = "642EB13C162B9C3DDBE9F6D8F3F1EFAB", hash_generated_method = "7BBC02749C4AFDF4911971D2088F9862")
    public ActionKeyInfo findActionKey(int keyCode) {
        ActionKeyInfo varB4EAC82CA7396A68D541C85D26508E83_1861519830 = null; //Variable for return #1
        ActionKeyInfo varB4EAC82CA7396A68D541C85D26508E83_1901425635 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_1861519830 = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1901425635 = mActionKeys.get(keyCode);
        addTaint(keyCode);
        ActionKeyInfo varA7E53CE21691AB073D9660D615818899_1055112994; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1055112994 = varB4EAC82CA7396A68D541C85D26508E83_1861519830;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1055112994 = varB4EAC82CA7396A68D541C85D26508E83_1901425635;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1055112994.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1055112994;
        // ---------- Original Method ----------
        //if (mActionKeys == null) {
            //return null;
        //}
        //return mActionKeys.get(keyCode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.331 -0400", hash_original_method = "0D70E2215A9C7B06033D45B8CD7DC306", hash_generated_method = "8B3885ADD5612164351FBAA64868DEDA")
    private void addActionKey(ActionKeyInfo keyInfo) {
        {
            mActionKeys = new HashMap<Integer,ActionKeyInfo>();
        } //End block
        mActionKeys.put(keyInfo.getKeyCode(), keyInfo);
        addTaint(keyInfo.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.353 -0400", hash_original_method = "32CB8385CEC61194A5C52A7CECC7153B", hash_generated_method = "6E3872E675A66E76D15A2B3C1D3E9780")
    public int getLabelId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_902550374 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_902550374;
        // ---------- Original Method ----------
        //return mLabelId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.374 -0400", hash_original_method = "DC9D54FA42277F7545187887A5854A7A", hash_generated_method = "F1227D235C0E61125302F68E294EFD9C")
    public int getHintId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1319037271 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1319037271;
        // ---------- Original Method ----------
        //return mHintId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.375 -0400", hash_original_method = "B3A2F353BC85020D961D66DA378099D0", hash_generated_method = "508C02A864A9D42D9E7156739A08E836")
    public int getIconId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1671108104 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1671108104;
        // ---------- Original Method ----------
        //return mIconId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.397 -0400", hash_original_method = "BD4587B1756B2E1B29D5C797A6E8E884", hash_generated_method = "0E5109D80BEDA7CA2E885C41D50D8A2A")
    public boolean getVoiceSearchEnabled() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_42994615 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_42994615;
        // ---------- Original Method ----------
        //return 0 != (mVoiceSearchMode & VOICE_SEARCH_SHOW_BUTTON);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.398 -0400", hash_original_method = "AD4F5DA741FB0C864BEACDD753D4C8F3", hash_generated_method = "B15B37889314BC40165A1964EAF56FF9")
    public boolean getVoiceSearchLaunchWebSearch() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2113281602 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2113281602;
        // ---------- Original Method ----------
        //return 0 != (mVoiceSearchMode & VOICE_SEARCH_LAUNCH_WEB_SEARCH);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.399 -0400", hash_original_method = "8242FA220A8F4815DCA2E78C8BAC691A", hash_generated_method = "10AC914D5F36B80A6B79B3BF05B036EA")
    public boolean getVoiceSearchLaunchRecognizer() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1258857534 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1258857534;
        // ---------- Original Method ----------
        //return 0 != (mVoiceSearchMode & VOICE_SEARCH_LAUNCH_RECOGNIZER);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.425 -0400", hash_original_method = "AE92C4DB1762FDEF1095AB548D604322", hash_generated_method = "A6F34D34EA804B131D9428CC0B112BBE")
    public int getVoiceLanguageModeId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1416918199 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1416918199;
        // ---------- Original Method ----------
        //return mVoiceLanguageModeId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.430 -0400", hash_original_method = "22DBBDA410168ED4037FF766F7DE7742", hash_generated_method = "96470203CF3907C018212A01D7DE29B6")
    public int getVoicePromptTextId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1017030902 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1017030902;
        // ---------- Original Method ----------
        //return mVoicePromptTextId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.449 -0400", hash_original_method = "79CDC130EB87863FB2A36D85DFC36EA0", hash_generated_method = "7DD53A83D6C8D197328BA0C1F98DB328")
    public int getVoiceLanguageId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1720254006 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1720254006;
        // ---------- Original Method ----------
        //return mVoiceLanguageId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.453 -0400", hash_original_method = "77BBA2ED9E38231A613E9BF06CBFC2B7", hash_generated_method = "3FC3D9EF32B1CE1DF804388E4AB7E670")
    public int getVoiceMaxResults() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1241442916 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1241442916;
        // ---------- Original Method ----------
        //return mVoiceMaxResults;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.472 -0400", hash_original_method = "A9AA4A30E735A990543D5C1057AC451E", hash_generated_method = "DFC55E26DF275203F1987E3EB2E499DF")
    public int getSearchButtonText() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1813358900 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1813358900;
        // ---------- Original Method ----------
        //return mSearchButtonText;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.477 -0400", hash_original_method = "4835EFF052D409983E396160FFE84050", hash_generated_method = "FBAAAFB02996238111EA2F8F36D21C0C")
    public int getInputType() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_581247980 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_581247980;
        // ---------- Original Method ----------
        //return mSearchInputType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.478 -0400", hash_original_method = "1FE8811970C0953B1D5BA2B119F61221", hash_generated_method = "790F786870477C8AF3AD4767AF3AA5C4")
    public int getImeOptions() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1510759112 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1510759112;
        // ---------- Original Method ----------
        //return mSearchImeOptions;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.505 -0400", hash_original_method = "B3CD0EA91E55821485199A61F4C775D4", hash_generated_method = "EBAC2462960E724A70482E4436F57BF6")
    public boolean shouldIncludeInGlobalSearch() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1413554576 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1413554576;
        // ---------- Original Method ----------
        //return mIncludeInGlobalSearch;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.507 -0400", hash_original_method = "942D4E1EA5C6469103A344EA38AACE8F", hash_generated_method = "43F0B71312D9A8EDBF638C21790DBD52")
    public boolean queryAfterZeroResults() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1666901119 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1666901119;
        // ---------- Original Method ----------
        //return mQueryAfterZeroResults;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.525 -0400", hash_original_method = "43849E9B2F1DCB4A199E2A722DA4C20F", hash_generated_method = "41EDC4CD88273378BC56EB31056A49BC")
    public boolean autoUrlDetect() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1547918112 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1547918112;
        // ---------- Original Method ----------
        //return mAutoUrlDetect;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.526 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "63E4E4AFEDE2F090C48A28C0A75F0243")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_153551903 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_153551903;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:55.170 -0400", hash_original_method = "72AC80AD69CAD17D9DB571EFE399D945", hash_generated_method = "D848453609EF38DD1BA45BE0DE29BA65")
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
        {
            dest.writeInt(0);
        } //End block
        {
            dest.writeInt(mActionKeys.size());
            {
                Iterator<ActionKeyInfo> var4354A710EE5726955FABE86B5D81C787_1349761629 = (mActionKeys.values()).iterator();
                var4354A710EE5726955FABE86B5D81C787_1349761629.hasNext();
                ActionKeyInfo actionKey = var4354A710EE5726955FABE86B5D81C787_1349761629.next();
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
        addTaint(dest.getTaint());
        addTaint(flags);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    public static class ActionKeyInfo implements Parcelable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:55.170 -0400", hash_original_field = "EE855499B412893552B9F8058CF94D19", hash_generated_field = "6029AC817F6EE7A2286BA05155E91FE2")

        private int mKeyCode;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:55.171 -0400", hash_original_field = "5A34FA447B337D01F94955DEB924FC0E", hash_generated_field = "3B81F8E38011672647005EC28AB6705D")

        private String mQueryActionMsg;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:55.171 -0400", hash_original_field = "277E9AD3A9ADDD380D0265BF744B7917", hash_generated_field = "8B7684F3BA320FB4D5D226E291D79406")

        private String mSuggestActionMsg;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:55.183 -0400", hash_original_field = "A32AC381ED6E395D6C435DE2D59030BC", hash_generated_field = "7C9EC47CD295C84807F022D848264755")

        private String mSuggestActionMsgColumn;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:55.186 -0400", hash_original_method = "70C4080A4EB7D334155C1E669C19E162", hash_generated_method = "640C2D06F3CB7C1E4A4B3F8F6736C60F")
          ActionKeyInfo(Context activityContext, AttributeSet attr) {
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
            addTaint(activityContext.getTaint());
            addTaint(attr.getTaint());
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:55.187 -0400", hash_original_method = "F27ACAC54FD4E2AFDD49ECEAEB99C834", hash_generated_method = "265E684231582EEA1B0AE30A9EA12397")
        private  ActionKeyInfo(Parcel in) {
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:55.195 -0400", hash_original_method = "AA2A4756B9F9E3EBD53F7A185B310C03", hash_generated_method = "78DCCE630F89DEC3AE5C0C71A41A3FD8")
        public int getKeyCode() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_826756269 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_826756269;
            // ---------- Original Method ----------
            //return mKeyCode;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:55.210 -0400", hash_original_method = "0A4F0AAE3D0D859714A4EE4638C2A280", hash_generated_method = "DD821975B372C943063A15D461F27787")
        public String getQueryActionMsg() {
            String varB4EAC82CA7396A68D541C85D26508E83_1627356788 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1627356788 = mQueryActionMsg;
            varB4EAC82CA7396A68D541C85D26508E83_1627356788.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1627356788;
            // ---------- Original Method ----------
            //return mQueryActionMsg;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:55.213 -0400", hash_original_method = "EDCBBABEEE2D0A0DD8ABF8A81407A4FD", hash_generated_method = "05D04E4F1770978833C77662B820A1F9")
        public String getSuggestActionMsg() {
            String varB4EAC82CA7396A68D541C85D26508E83_1641148238 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1641148238 = mSuggestActionMsg;
            varB4EAC82CA7396A68D541C85D26508E83_1641148238.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1641148238;
            // ---------- Original Method ----------
            //return mSuggestActionMsg;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:55.225 -0400", hash_original_method = "94611E44E9C4989C8B71AAF260F46112", hash_generated_method = "16E3B1B127F340DB9EAC2A145D82A215")
        public String getSuggestActionMsgColumn() {
            String varB4EAC82CA7396A68D541C85D26508E83_1574110096 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1574110096 = mSuggestActionMsgColumn;
            varB4EAC82CA7396A68D541C85D26508E83_1574110096.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1574110096;
            // ---------- Original Method ----------
            //return mSuggestActionMsgColumn;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:55.239 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "DBB1F1D679ADB2753F6F7CA8A534EE6D")
        public int describeContents() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1414459958 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1414459958;
            // ---------- Original Method ----------
            //return 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:55.241 -0400", hash_original_method = "285E938AE46ECF341AA39A5F914BC19D", hash_generated_method = "050414CFE1712AB8894A83BAD50EBA53")
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(mKeyCode);
            dest.writeString(mQueryActionMsg);
            dest.writeString(mSuggestActionMsg);
            dest.writeString(mSuggestActionMsgColumn);
            addTaint(dest.getTaint());
            addTaint(flags);
            // ---------- Original Method ----------
            //dest.writeInt(mKeyCode);
            //dest.writeString(mQueryActionMsg);
            //dest.writeString(mSuggestActionMsg);
            //dest.writeString(mSuggestActionMsgColumn);
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:55.242 -0400", hash_original_field = "0F6F0EB642B3F46DE2B2DF48DA4427EF", hash_generated_field = "B7C4E93D97D072890A37A56076D870F8")

    private static boolean DBG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:55.242 -0400", hash_original_field = "682B7D113CD593B2674A420FDC0709A3", hash_generated_field = "D7E0390EE73DBA4A497B322065B7B399")

    private static String LOG_TAG = "SearchableInfo";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:55.242 -0400", hash_original_field = "FFD19F1393ABC167FA85C88A5C04E2CB", hash_generated_field = "8699D4AF8FF7F05046236160BE35B02A")

    private static String MD_LABEL_SEARCHABLE = "android.app.searchable";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:55.243 -0400", hash_original_field = "7F07CDD5FE239F7BDD6F531EAC8C54F9", hash_generated_field = "D32DA2B5A50B13586D72C29182CA7C05")

    private static String MD_XML_ELEMENT_SEARCHABLE = "searchable";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:55.243 -0400", hash_original_field = "77E84D3440CDCA042F8A4AE51346F2FD", hash_generated_field = "83105440CD01A05ECA4D805D863A8CDF")

    private static String MD_XML_ELEMENT_SEARCHABLE_ACTION_KEY = "actionkey";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:55.259 -0400", hash_original_field = "4FA0B82DD68D7FDE25BAD0D6896AC80E", hash_generated_field = "DDEEED2B06EEE2F1FC4A58A742298437")

    private static int SEARCH_MODE_BADGE_LABEL = 0x04;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:55.259 -0400", hash_original_field = "B5C4039F128BD2526A3400DBA4983562", hash_generated_field = "B1FFC54EA30AF40CEA701AC7978DA93C")

    private static int SEARCH_MODE_BADGE_ICON = 0x08;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:55.260 -0400", hash_original_field = "3C419F70CA38A1C76D9788E80E87D2A7", hash_generated_field = "D7421837BB9AD4D3B3BD59273A49A997")

    private static int SEARCH_MODE_QUERY_REWRITE_FROM_DATA = 0x10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:55.260 -0400", hash_original_field = "69F438DF99AA2977699C5B1AB08691FF", hash_generated_field = "6AD84A33E8114D5B53EC238D5F26894C")

    private static int SEARCH_MODE_QUERY_REWRITE_FROM_TEXT = 0x20;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:55.261 -0400", hash_original_field = "FEBBE46C9FB61EA77F5C345D9AC79DC0", hash_generated_field = "B842CACF2CA95956DA93785CF393E3B7")

    private static int VOICE_SEARCH_SHOW_BUTTON = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:55.272 -0400", hash_original_field = "FF2A01F415368C6A4B75468A7EF63C14", hash_generated_field = "E922A12FD7902C522A7484387E74A780")

    private static int VOICE_SEARCH_LAUNCH_WEB_SEARCH = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:55.273 -0400", hash_original_field = "769DD161AAB33C0E04A8F309010799FC", hash_generated_field = "B9FC375F4B6D5DB8479AEC3731B67014")

    private static int VOICE_SEARCH_LAUNCH_RECOGNIZER = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:55.273 -0400", hash_original_field = "203A5BF2CB131E14354D4E080CD68B6E", hash_generated_field = "F3AF64F39E7F85BFEBFD501C152359E7")

    public static final Parcelable.Creator<SearchableInfo> CREATOR
    = new Parcelable.Creator<SearchableInfo>() {
        public SearchableInfo createFromParcel(Parcel in) {
            return new SearchableInfo(in);
        }

        public SearchableInfo[] newArray(int size) {
            return new SearchableInfo[size];
        }
    };
}

