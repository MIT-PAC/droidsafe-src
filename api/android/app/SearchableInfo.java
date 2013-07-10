package android.app;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.334 -0400", hash_original_field = "D057B2BB85264BE6A162A2050E03E209", hash_generated_field = "D6FEAD9F73C8FE6EF0F3A12308DAC489")

    private int mLabelId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.334 -0400", hash_original_field = "F30792FDD94B575151C8430D4E5DBF29", hash_generated_field = "E06ADC11A1AEA67BA6BBE28FB67CAB66")

    private ComponentName mSearchActivity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.334 -0400", hash_original_field = "F9B6782402E61448FE6CDDBE1079CDEE", hash_generated_field = "25DB23E4AD14EAEADA10E3B1B67B84E0")

    private int mHintId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.334 -0400", hash_original_field = "89070FC64F8E69B4F0C300A298DB823A", hash_generated_field = "78FC51630A0764848864D2FF318ABDB8")

    private int mSearchMode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.334 -0400", hash_original_field = "D7630CF52154C2427A7112C0FFA081B1", hash_generated_field = "EF1ABACE4A55E5A864CC227FE8654387")

    private int mIconId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.334 -0400", hash_original_field = "0826F96358F107FED726F6D2004E0424", hash_generated_field = "2856721A0AE1EEA9045A703245A329AA")

    private int mSearchButtonText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.334 -0400", hash_original_field = "E1AFE3AE8B9005A0BAB937E2BF25305C", hash_generated_field = "1684EE1596133B8BF20C20A9B99DB6B1")

    private int mSearchInputType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.334 -0400", hash_original_field = "220E297C1E16D14AA9F51E010AAA5BDD", hash_generated_field = "9EA71DDC334F5E2B229494AAF349B8CB")

    private int mSearchImeOptions;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.334 -0400", hash_original_field = "DBAA85CB46828DF39EBA185991B74924", hash_generated_field = "C0BBF1D6E1CE09EDF5AAB403A08D2B75")

    private boolean mIncludeInGlobalSearch;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.334 -0400", hash_original_field = "2AE4A58FAB921A667862F2E5E851BFC8", hash_generated_field = "D751F4BD314E1B6DDF8E9B3F844D860A")

    private boolean mQueryAfterZeroResults;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.334 -0400", hash_original_field = "B0F477017B3A20C523CB75C2CB2CCA61", hash_generated_field = "0B1FDF9F0A272F0F48F41A49A4570B15")

    private boolean mAutoUrlDetect;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.334 -0400", hash_original_field = "4C0CE3F626ABB04381EC5B6DA773593E", hash_generated_field = "60CBA5980489FCAAEBAE1EB29ED4DD25")

    private int mSettingsDescriptionId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.334 -0400", hash_original_field = "6CBCEE9BDAD542F0160B7269139095AC", hash_generated_field = "C31BFA716E618C0AA35C3A46A49C74A2")

    private String mSuggestAuthority;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.334 -0400", hash_original_field = "740A9F5C1D9A70BB5CC84DADAB562D5C", hash_generated_field = "AA401E1B32346E981E53058520319AE6")

    private String mSuggestPath;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.335 -0400", hash_original_field = "7630364755A9100D83BD3C726C010E2C", hash_generated_field = "CD47AC54D2D5A339E2907D35BBED1C65")

    private String mSuggestSelection;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.335 -0400", hash_original_field = "6B985FAE9A7932531A557F2B2581B20F", hash_generated_field = "AF16C60CE6AC5E3F7A49FB3100F51C80")

    private String mSuggestIntentAction;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.335 -0400", hash_original_field = "CD0DFD9D95BAC58FF7C23EA5C480FA1D", hash_generated_field = "177360028843579AEBEC82687DC94948")

    private String mSuggestIntentData;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.335 -0400", hash_original_field = "22B05A6765211453BABA6F8A79424691", hash_generated_field = "79460A51BE9275FE6D19BC9F8F008D8F")

    private int mSuggestThreshold;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.335 -0400", hash_original_field = "9500EA58BACD01CE281AD3DB271EE6E4", hash_generated_field = "C9D6635EBF55DCF3ADED92CBCFA44CB7")

    private HashMap<Integer,ActionKeyInfo> mActionKeys = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.335 -0400", hash_original_field = "CF58932A35DA62EEA6407052FA331D97", hash_generated_field = "39020C0C71CE4563CBEEEE8C7CCBA6D7")

    private String mSuggestProviderPackage;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.335 -0400", hash_original_field = "1825B0D843C0E16C6D3686963AC2A7F0", hash_generated_field = "C80188786C75AB634A90822CFB16E29B")

    private int mVoiceSearchMode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.335 -0400", hash_original_field = "03F77744C7D51598EA5C20BAD9A6FF8E", hash_generated_field = "C30E8A2FA03A7817BD9C2B3025108BE2")

    private int mVoiceLanguageModeId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.335 -0400", hash_original_field = "05F56573DEFC97C433D25F4CAEBE94CC", hash_generated_field = "4A40D3223FA01F35360A1936FDE75E64")

    private int mVoicePromptTextId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.335 -0400", hash_original_field = "E66DD97243D1B6526BF8E4264871DB77", hash_generated_field = "3B8852BE17F84107FC1B74FAB195C21B")

    private int mVoiceLanguageId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.335 -0400", hash_original_field = "46CC12A5AB44CBE81DA898323B8ABD6B", hash_generated_field = "4A5000E9F04A035A8E1D1F76655AE2AC")

    private int mVoiceMaxResults;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.338 -0400", hash_original_method = "633954995A30C027EA0DC2D487CA3CDA", hash_generated_method = "1976B2CBFDAEB9B30B6C93B9BDAA9C9D")
    private  SearchableInfo(Context activityContext, AttributeSet attr, final ComponentName cName) {
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
        mVoiceLanguageModeId = 
            a.getResourceId(com.android.internal.R.styleable.Searchable_voiceLanguageModel, 0);
        mVoicePromptTextId = 
            a.getResourceId(com.android.internal.R.styleable.Searchable_voicePromptText, 0);
        mVoiceLanguageId = 
            a.getResourceId(com.android.internal.R.styleable.Searchable_voiceLanguage, 0);
        mVoiceMaxResults = 
            a.getInt(com.android.internal.R.styleable.Searchable_voiceMaxResults, 0);
        a.recycle();
        String suggestProviderPackage = null;
        {
            PackageManager pm = activityContext.getPackageManager();
            ProviderInfo pi = pm.resolveContentProvider(mSuggestAuthority, 0);
            {
                suggestProviderPackage = pi.packageName;
            } 
        } 
        mSuggestProviderPackage = suggestProviderPackage;
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Search label must be a resource reference.");
        } 
        addTaint(activityContext.getTaint());
        addTaint(attr.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.339 -0400", hash_original_method = "5317CE2CAB02C1DC0498B77BC3A6FE3A", hash_generated_method = "34BB18DF9D5E4DA900278BDFFA3CC599")
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
            int count = in.readInt();
            {
                addActionKey(new ActionKeyInfo(in));
            } 
        } 
        mSuggestProviderPackage = in.readString();
        mVoiceSearchMode = in.readInt();
        mVoiceLanguageModeId = in.readInt();
        mVoicePromptTextId = in.readInt();
        mVoiceLanguageId = in.readInt();
        mVoiceMaxResults = in.readInt();
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.340 -0400", hash_original_method = "9CC6B7578CF19F95DF8C884BF5987E46", hash_generated_method = "145E075B397CDE9A9578D57AB1D9175B")
    public String getSuggestAuthority() {
        String varB4EAC82CA7396A68D541C85D26508E83_1273857462 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1273857462 = mSuggestAuthority;
        varB4EAC82CA7396A68D541C85D26508E83_1273857462.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1273857462;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.341 -0400", hash_original_method = "BE8BEFD3C329420CF7D6C5DA35EA0FF0", hash_generated_method = "37DF9BB531FC365F3C11C2C45C637313")
    public String getSuggestPackage() {
        String varB4EAC82CA7396A68D541C85D26508E83_434807813 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_434807813 = mSuggestProviderPackage;
        varB4EAC82CA7396A68D541C85D26508E83_434807813.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_434807813;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.342 -0400", hash_original_method = "F3041DF7A3866005E32579E92AEBEE6A", hash_generated_method = "97A19A7F98D7961CCB45BCE251ADC8C8")
    public ComponentName getSearchActivity() {
        ComponentName varB4EAC82CA7396A68D541C85D26508E83_1565265717 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1565265717 = mSearchActivity;
        varB4EAC82CA7396A68D541C85D26508E83_1565265717.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1565265717;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.342 -0400", hash_original_method = "E8E1D8EA6D890D66AA7ADE8877B0250D", hash_generated_method = "035A4E1A19EE4BFBE2F9B1E36C65D642")
    public boolean useBadgeLabel() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_575605875 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_575605875;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.343 -0400", hash_original_method = "FEE9D772AE5D3D19558CCEFFB0D8835C", hash_generated_method = "8F955A4BA40C071832522A96B08CE57C")
    public boolean useBadgeIcon() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1313486974 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1313486974;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.344 -0400", hash_original_method = "B8AED61CE994D23FCE3A1E2344A9A897", hash_generated_method = "CEF05B32EEEA7B431EAD3BE1B53B6EB6")
    public boolean shouldRewriteQueryFromData() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_940651581 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_940651581;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.344 -0400", hash_original_method = "5A9C6F4DB0BEA2BB31C909F5BB55A3E0", hash_generated_method = "846C6892765128FA65D289F4898E7184")
    public boolean shouldRewriteQueryFromText() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1119734029 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1119734029;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.345 -0400", hash_original_method = "19684FC2043C1BDB61A3E740D6C19B34", hash_generated_method = "FDD73676E2BA6A7F768D076D2DD074DD")
    public int getSettingsDescriptionId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_401549345 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_401549345;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.345 -0400", hash_original_method = "E8F19B2AFF47ACFE52244E7315CE6CBA", hash_generated_method = "8D4B90781218EA16C9F2FFB78D445ED1")
    public String getSuggestPath() {
        String varB4EAC82CA7396A68D541C85D26508E83_1608235765 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1608235765 = mSuggestPath;
        varB4EAC82CA7396A68D541C85D26508E83_1608235765.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1608235765;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.346 -0400", hash_original_method = "03B94AF5E978777AF0A4DF7C1D53B2F0", hash_generated_method = "D087447E0014545D373E7677D7148CC5")
    public String getSuggestSelection() {
        String varB4EAC82CA7396A68D541C85D26508E83_1511305598 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1511305598 = mSuggestSelection;
        varB4EAC82CA7396A68D541C85D26508E83_1511305598.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1511305598;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.346 -0400", hash_original_method = "41669F0953535FACC4B7926CFCBDA8A1", hash_generated_method = "6EC763408CFD2C0693460C2B9CA747E3")
    public String getSuggestIntentAction() {
        String varB4EAC82CA7396A68D541C85D26508E83_915914853 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_915914853 = mSuggestIntentAction;
        varB4EAC82CA7396A68D541C85D26508E83_915914853.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_915914853;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.347 -0400", hash_original_method = "E2551EFF005AD652F4CA5C2DEBD8F1C5", hash_generated_method = "DB0EE6EBA8B4D934B4F71A99DA33C75A")
    public String getSuggestIntentData() {
        String varB4EAC82CA7396A68D541C85D26508E83_2043246041 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2043246041 = mSuggestIntentData;
        varB4EAC82CA7396A68D541C85D26508E83_2043246041.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2043246041;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.347 -0400", hash_original_method = "EC28F48C38E111E12DD92E58268AB4B1", hash_generated_method = "68895A3D2A6A24CFC5761698016D434E")
    public int getSuggestThreshold() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1808277881 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1808277881;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.348 -0400", hash_original_method = "BBBE2BBFCBFB429E05BB475016E66C58", hash_generated_method = "342CF5C2733EC7EAD6581381645FAFA5")
    public Context getActivityContext(Context context) {
        Context varB4EAC82CA7396A68D541C85D26508E83_1838625243 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1838625243 = createActivityContext(context, mSearchActivity);
        addTaint(context.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1838625243.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1838625243;
        
        
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.350 -0400", hash_original_method = "B0B7C6DE2D55DA45CA53022A0C4DE186", hash_generated_method = "AA12DB7BC8A324407962257B02F0C886")
    public Context getProviderContext(Context context, Context activityContext) {
        Context varB4EAC82CA7396A68D541C85D26508E83_1188146310 = null; 
        Context varB4EAC82CA7396A68D541C85D26508E83_1353672480 = null; 
        Context theirContext = null;
        {
            boolean var662F2259AD79A168878A3D91EA7F3EAE_1172728414 = (mSearchActivity.getPackageName().equals(mSuggestProviderPackage));
            {
                varB4EAC82CA7396A68D541C85D26508E83_1188146310 = activityContext;
            } 
        } 
        {
            try 
            {
                theirContext = context.createPackageContext(mSuggestProviderPackage, 0);
            } 
            catch (PackageManager.NameNotFoundException e)
            { }
            catch (java.lang.SecurityException e)
            { }
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1353672480 = theirContext;
        addTaint(context.getTaint());
        addTaint(activityContext.getTaint());
        Context varA7E53CE21691AB073D9660D615818899_1019182417; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1019182417 = varB4EAC82CA7396A68D541C85D26508E83_1188146310;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1019182417 = varB4EAC82CA7396A68D541C85D26508E83_1353672480;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1019182417.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1019182417;
        
        
        
            
        
        
            
                
            
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.351 -0400", hash_original_method = "642EB13C162B9C3DDBE9F6D8F3F1EFAB", hash_generated_method = "1754DBA7078661E2CBC9A46F59A56F04")
    public ActionKeyInfo findActionKey(int keyCode) {
        ActionKeyInfo varB4EAC82CA7396A68D541C85D26508E83_1804398237 = null; 
        ActionKeyInfo varB4EAC82CA7396A68D541C85D26508E83_234810158 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1804398237 = null;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_234810158 = mActionKeys.get(keyCode);
        addTaint(keyCode);
        ActionKeyInfo varA7E53CE21691AB073D9660D615818899_825173180; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_825173180 = varB4EAC82CA7396A68D541C85D26508E83_1804398237;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_825173180 = varB4EAC82CA7396A68D541C85D26508E83_234810158;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_825173180.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_825173180;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.352 -0400", hash_original_method = "0D70E2215A9C7B06033D45B8CD7DC306", hash_generated_method = "8B3885ADD5612164351FBAA64868DEDA")
    private void addActionKey(ActionKeyInfo keyInfo) {
        {
            mActionKeys = new HashMap<Integer,ActionKeyInfo>();
        } 
        mActionKeys.put(keyInfo.getKeyCode(), keyInfo);
        addTaint(keyInfo.getTaint());
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.355 -0400", hash_original_method = "32CB8385CEC61194A5C52A7CECC7153B", hash_generated_method = "818E2AFCC901E478F547201C04962A03")
    public int getLabelId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_678762069 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_678762069;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.356 -0400", hash_original_method = "DC9D54FA42277F7545187887A5854A7A", hash_generated_method = "F1CEB06ED88CF2A68AD431C25A792848")
    public int getHintId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_335382418 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_335382418;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.357 -0400", hash_original_method = "B3A2F353BC85020D961D66DA378099D0", hash_generated_method = "945FC38F1439BB8E0C76D20333BEB31D")
    public int getIconId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1952383746 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1952383746;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.357 -0400", hash_original_method = "BD4587B1756B2E1B29D5C797A6E8E884", hash_generated_method = "04661D697997E70C9ACF9AEC41FC2F26")
    public boolean getVoiceSearchEnabled() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_305450102 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_305450102;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.358 -0400", hash_original_method = "AD4F5DA741FB0C864BEACDD753D4C8F3", hash_generated_method = "73D0C320057DDC692A4A610E3E9A7430")
    public boolean getVoiceSearchLaunchWebSearch() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_347791163 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_347791163;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.358 -0400", hash_original_method = "8242FA220A8F4815DCA2E78C8BAC691A", hash_generated_method = "B8C79B59C8D48D570003412400050FCE")
    public boolean getVoiceSearchLaunchRecognizer() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1279559710 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1279559710;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.359 -0400", hash_original_method = "AE92C4DB1762FDEF1095AB548D604322", hash_generated_method = "C53B7ACE97FA9B06494465F291079AB0")
    public int getVoiceLanguageModeId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1425458837 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1425458837;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.359 -0400", hash_original_method = "22DBBDA410168ED4037FF766F7DE7742", hash_generated_method = "631C23EF5D116FD9A07FFAC55788E1C3")
    public int getVoicePromptTextId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_727721551 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_727721551;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.360 -0400", hash_original_method = "79CDC130EB87863FB2A36D85DFC36EA0", hash_generated_method = "5FB79D0FD14C416FCF5AB2B36A0659D4")
    public int getVoiceLanguageId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_658300383 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_658300383;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.360 -0400", hash_original_method = "77BBA2ED9E38231A613E9BF06CBFC2B7", hash_generated_method = "35CD7A318EFA0A89E9EE3E5040124F3E")
    public int getVoiceMaxResults() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1279961772 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1279961772;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.360 -0400", hash_original_method = "A9AA4A30E735A990543D5C1057AC451E", hash_generated_method = "1814EF7D5B81AEE1570F52CE92DC16F3")
    public int getSearchButtonText() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_572594019 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_572594019;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.361 -0400", hash_original_method = "4835EFF052D409983E396160FFE84050", hash_generated_method = "FBA7623D12C466AE7F9C79D0C44061E1")
    public int getInputType() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1545919936 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1545919936;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.361 -0400", hash_original_method = "1FE8811970C0953B1D5BA2B119F61221", hash_generated_method = "78124D80313DE25BE6476909C9C1F764")
    public int getImeOptions() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_591156661 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_591156661;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.361 -0400", hash_original_method = "B3CD0EA91E55821485199A61F4C775D4", hash_generated_method = "BD92776A97818FBCF75BDE5C05B4DAF9")
    public boolean shouldIncludeInGlobalSearch() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1976860576 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1976860576;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.362 -0400", hash_original_method = "942D4E1EA5C6469103A344EA38AACE8F", hash_generated_method = "9E7B83DA59C51A6B3F6140A60BD02236")
    public boolean queryAfterZeroResults() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_480238730 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_480238730;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.363 -0400", hash_original_method = "43849E9B2F1DCB4A199E2A722DA4C20F", hash_generated_method = "CCDA556F415C0CAB5D78169D8A3F5939")
    public boolean autoUrlDetect() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1743069911 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1743069911;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.363 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "5657B96CEE9B4DFD2AD9B36B089056EF")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_403689373 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_403689373;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.386 -0400", hash_original_method = "72AC80AD69CAD17D9DB571EFE399D945", hash_generated_method = "68D3623F6B86A47770470255DB72EB27")
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
        } 
        {
            dest.writeInt(mActionKeys.size());
            {
                Iterator<ActionKeyInfo> var4354A710EE5726955FABE86B5D81C787_1090611088 = (mActionKeys.values()).iterator();
                var4354A710EE5726955FABE86B5D81C787_1090611088.hasNext();
                ActionKeyInfo actionKey = var4354A710EE5726955FABE86B5D81C787_1090611088.next();
                {
                    actionKey.writeToParcel(dest, flags);
                } 
            } 
        } 
        dest.writeString(mSuggestProviderPackage);
        dest.writeInt(mVoiceSearchMode);
        dest.writeInt(mVoiceLanguageModeId);
        dest.writeInt(mVoicePromptTextId);
        dest.writeInt(mVoiceLanguageId);
        dest.writeInt(mVoiceMaxResults);
        addTaint(dest.getTaint());
        addTaint(flags);
        
        
    }

    
    public static class ActionKeyInfo implements Parcelable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.386 -0400", hash_original_field = "EE855499B412893552B9F8058CF94D19", hash_generated_field = "6029AC817F6EE7A2286BA05155E91FE2")

        private int mKeyCode;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.386 -0400", hash_original_field = "5A34FA447B337D01F94955DEB924FC0E", hash_generated_field = "3B81F8E38011672647005EC28AB6705D")

        private String mQueryActionMsg;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.386 -0400", hash_original_field = "277E9AD3A9ADDD380D0265BF744B7917", hash_generated_field = "8B7684F3BA320FB4D5D226E291D79406")

        private String mSuggestActionMsg;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.387 -0400", hash_original_field = "A32AC381ED6E395D6C435DE2D59030BC", hash_generated_field = "7C9EC47CD295C84807F022D848264755")

        private String mSuggestActionMsgColumn;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.387 -0400", hash_original_method = "70C4080A4EB7D334155C1E669C19E162", hash_generated_method = "D40978659A8DAA6BAFE9DDD44F44A3B3")
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
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("No keycode.");
            } 
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("No message information.");
            } 
            addTaint(activityContext.getTaint());
            addTaint(attr.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.388 -0400", hash_original_method = "F27ACAC54FD4E2AFDD49ECEAEB99C834", hash_generated_method = "265E684231582EEA1B0AE30A9EA12397")
        private  ActionKeyInfo(Parcel in) {
            mKeyCode = in.readInt();
            mQueryActionMsg = in.readString();
            mSuggestActionMsg = in.readString();
            mSuggestActionMsgColumn = in.readString();
            
            
            
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.389 -0400", hash_original_method = "AA2A4756B9F9E3EBD53F7A185B310C03", hash_generated_method = "5CE09FCF6777DCF48C9F5A2134DFEAD6")
        public int getKeyCode() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_139449763 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_139449763;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.390 -0400", hash_original_method = "0A4F0AAE3D0D859714A4EE4638C2A280", hash_generated_method = "C551215E8D7B8B9B73AFD68688BB1F33")
        public String getQueryActionMsg() {
            String varB4EAC82CA7396A68D541C85D26508E83_276636291 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_276636291 = mQueryActionMsg;
            varB4EAC82CA7396A68D541C85D26508E83_276636291.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_276636291;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.391 -0400", hash_original_method = "EDCBBABEEE2D0A0DD8ABF8A81407A4FD", hash_generated_method = "6670A7914144B09969714F8563EFF3A5")
        public String getSuggestActionMsg() {
            String varB4EAC82CA7396A68D541C85D26508E83_1682874739 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1682874739 = mSuggestActionMsg;
            varB4EAC82CA7396A68D541C85D26508E83_1682874739.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1682874739;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.392 -0400", hash_original_method = "94611E44E9C4989C8B71AAF260F46112", hash_generated_method = "243359BC00BECA62A5F9B31B76257EEA")
        public String getSuggestActionMsgColumn() {
            String varB4EAC82CA7396A68D541C85D26508E83_1024335002 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1024335002 = mSuggestActionMsgColumn;
            varB4EAC82CA7396A68D541C85D26508E83_1024335002.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1024335002;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.392 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "9B32B4981187F2DFE0BDB96FB85E4CDB")
        public int describeContents() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_629062042 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_629062042;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.393 -0400", hash_original_method = "285E938AE46ECF341AA39A5F914BC19D", hash_generated_method = "050414CFE1712AB8894A83BAD50EBA53")
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(mKeyCode);
            dest.writeString(mQueryActionMsg);
            dest.writeString(mSuggestActionMsg);
            dest.writeString(mSuggestActionMsgColumn);
            addTaint(dest.getTaint());
            addTaint(flags);
            
            
            
            
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.393 -0400", hash_original_field = "0F6F0EB642B3F46DE2B2DF48DA4427EF", hash_generated_field = "1A61763F9CABC9206BB5AE6E570AB8AE")

    private static final boolean DBG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.393 -0400", hash_original_field = "682B7D113CD593B2674A420FDC0709A3", hash_generated_field = "D203EEF0E4D64BCDB10C02861CF15E1D")

    private static final String LOG_TAG = "SearchableInfo";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.393 -0400", hash_original_field = "FFD19F1393ABC167FA85C88A5C04E2CB", hash_generated_field = "76D330B9576B93848FB10401AE5FD5DB")

    private static final String MD_LABEL_SEARCHABLE = "android.app.searchable";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.393 -0400", hash_original_field = "7F07CDD5FE239F7BDD6F531EAC8C54F9", hash_generated_field = "3869A799E84BF0AD918D019051C45943")

    private static final String MD_XML_ELEMENT_SEARCHABLE = "searchable";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.393 -0400", hash_original_field = "77E84D3440CDCA042F8A4AE51346F2FD", hash_generated_field = "0F40B5E21851701CBDEB2F9B3FA09668")

    private static final String MD_XML_ELEMENT_SEARCHABLE_ACTION_KEY = "actionkey";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.393 -0400", hash_original_field = "4FA0B82DD68D7FDE25BAD0D6896AC80E", hash_generated_field = "D8C00A0A4A3874113B0ACE14567A0701")

    private static final int SEARCH_MODE_BADGE_LABEL = 0x04;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.393 -0400", hash_original_field = "B5C4039F128BD2526A3400DBA4983562", hash_generated_field = "2BE46E815786ECF3C252C237E8DD0388")

    private static final int SEARCH_MODE_BADGE_ICON = 0x08;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.394 -0400", hash_original_field = "3C419F70CA38A1C76D9788E80E87D2A7", hash_generated_field = "EC9F9C22DFAA89E0C2358140824BB50B")

    private static final int SEARCH_MODE_QUERY_REWRITE_FROM_DATA = 0x10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.394 -0400", hash_original_field = "69F438DF99AA2977699C5B1AB08691FF", hash_generated_field = "C93683C3AF679B5C3A88B5416B498D23")

    private static final int SEARCH_MODE_QUERY_REWRITE_FROM_TEXT = 0x20;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.394 -0400", hash_original_field = "FEBBE46C9FB61EA77F5C345D9AC79DC0", hash_generated_field = "263F1C6CFA6203816856410C0EE21258")

    private static final int VOICE_SEARCH_SHOW_BUTTON = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.394 -0400", hash_original_field = "FF2A01F415368C6A4B75468A7EF63C14", hash_generated_field = "3E2C11E1F2558FB793D359EDBF9C6C40")

    private static final int VOICE_SEARCH_LAUNCH_WEB_SEARCH = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.394 -0400", hash_original_field = "769DD161AAB33C0E04A8F309010799FC", hash_generated_field = "8EBDD5ED70EDE6E46658E039B7B2F56C")

    private static final int VOICE_SEARCH_LAUNCH_RECOGNIZER = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.394 -0400", hash_original_field = "203A5BF2CB131E14354D4E080CD68B6E", hash_generated_field = "F3AF64F39E7F85BFEBFD501C152359E7")

    public static final Parcelable.Creator<SearchableInfo> CREATOR
    = new Parcelable.Creator<SearchableInfo>() {
        public SearchableInfo createFromParcel(Parcel in) {
            return new SearchableInfo(in);
        }

        public SearchableInfo[] newArray(int size) {
            return new SearchableInfo[size];
        }
    };
    
    public SearchableInfo createFromParcel(Parcel in) {
            return new SearchableInfo(in);
        }
    
    
    public SearchableInfo[] newArray(int size) {
            return new SearchableInfo[size];
        }
    
}

