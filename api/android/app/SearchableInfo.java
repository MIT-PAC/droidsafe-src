package android.app;

// Droidsafe Imports
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.058 -0400", hash_original_field = "D057B2BB85264BE6A162A2050E03E209", hash_generated_field = "D6FEAD9F73C8FE6EF0F3A12308DAC489")

    private int mLabelId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.058 -0400", hash_original_field = "F30792FDD94B575151C8430D4E5DBF29", hash_generated_field = "E06ADC11A1AEA67BA6BBE28FB67CAB66")

    private ComponentName mSearchActivity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.059 -0400", hash_original_field = "F9B6782402E61448FE6CDDBE1079CDEE", hash_generated_field = "25DB23E4AD14EAEADA10E3B1B67B84E0")

    private int mHintId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.059 -0400", hash_original_field = "89070FC64F8E69B4F0C300A298DB823A", hash_generated_field = "78FC51630A0764848864D2FF318ABDB8")

    private int mSearchMode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.059 -0400", hash_original_field = "D7630CF52154C2427A7112C0FFA081B1", hash_generated_field = "EF1ABACE4A55E5A864CC227FE8654387")

    private int mIconId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.059 -0400", hash_original_field = "0826F96358F107FED726F6D2004E0424", hash_generated_field = "2856721A0AE1EEA9045A703245A329AA")

    private int mSearchButtonText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.059 -0400", hash_original_field = "E1AFE3AE8B9005A0BAB937E2BF25305C", hash_generated_field = "1684EE1596133B8BF20C20A9B99DB6B1")

    private int mSearchInputType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.059 -0400", hash_original_field = "220E297C1E16D14AA9F51E010AAA5BDD", hash_generated_field = "9EA71DDC334F5E2B229494AAF349B8CB")

    private int mSearchImeOptions;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.059 -0400", hash_original_field = "DBAA85CB46828DF39EBA185991B74924", hash_generated_field = "C0BBF1D6E1CE09EDF5AAB403A08D2B75")

    private boolean mIncludeInGlobalSearch;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.059 -0400", hash_original_field = "2AE4A58FAB921A667862F2E5E851BFC8", hash_generated_field = "D751F4BD314E1B6DDF8E9B3F844D860A")

    private boolean mQueryAfterZeroResults;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.059 -0400", hash_original_field = "B0F477017B3A20C523CB75C2CB2CCA61", hash_generated_field = "0B1FDF9F0A272F0F48F41A49A4570B15")

    private boolean mAutoUrlDetect;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.060 -0400", hash_original_field = "4C0CE3F626ABB04381EC5B6DA773593E", hash_generated_field = "60CBA5980489FCAAEBAE1EB29ED4DD25")

    private int mSettingsDescriptionId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.060 -0400", hash_original_field = "6CBCEE9BDAD542F0160B7269139095AC", hash_generated_field = "C31BFA716E618C0AA35C3A46A49C74A2")

    private String mSuggestAuthority;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.060 -0400", hash_original_field = "740A9F5C1D9A70BB5CC84DADAB562D5C", hash_generated_field = "AA401E1B32346E981E53058520319AE6")

    private String mSuggestPath;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.060 -0400", hash_original_field = "7630364755A9100D83BD3C726C010E2C", hash_generated_field = "CD47AC54D2D5A339E2907D35BBED1C65")

    private String mSuggestSelection;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.060 -0400", hash_original_field = "6B985FAE9A7932531A557F2B2581B20F", hash_generated_field = "AF16C60CE6AC5E3F7A49FB3100F51C80")

    private String mSuggestIntentAction;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.060 -0400", hash_original_field = "CD0DFD9D95BAC58FF7C23EA5C480FA1D", hash_generated_field = "177360028843579AEBEC82687DC94948")

    private String mSuggestIntentData;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.060 -0400", hash_original_field = "22B05A6765211453BABA6F8A79424691", hash_generated_field = "79460A51BE9275FE6D19BC9F8F008D8F")

    private int mSuggestThreshold;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.060 -0400", hash_original_field = "9500EA58BACD01CE281AD3DB271EE6E4", hash_generated_field = "C9D6635EBF55DCF3ADED92CBCFA44CB7")

    private HashMap<Integer,ActionKeyInfo> mActionKeys = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.063 -0400", hash_original_field = "CF58932A35DA62EEA6407052FA331D97", hash_generated_field = "39020C0C71CE4563CBEEEE8C7CCBA6D7")

    private String mSuggestProviderPackage;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.064 -0400", hash_original_field = "1825B0D843C0E16C6D3686963AC2A7F0", hash_generated_field = "C80188786C75AB634A90822CFB16E29B")

    private int mVoiceSearchMode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.064 -0400", hash_original_field = "03F77744C7D51598EA5C20BAD9A6FF8E", hash_generated_field = "C30E8A2FA03A7817BD9C2B3025108BE2")

    private int mVoiceLanguageModeId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.064 -0400", hash_original_field = "05F56573DEFC97C433D25F4CAEBE94CC", hash_generated_field = "4A40D3223FA01F35360A1936FDE75E64")

    private int mVoicePromptTextId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.064 -0400", hash_original_field = "E66DD97243D1B6526BF8E4264871DB77", hash_generated_field = "3B8852BE17F84107FC1B74FAB195C21B")

    private int mVoiceLanguageId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.064 -0400", hash_original_field = "46CC12A5AB44CBE81DA898323B8ABD6B", hash_generated_field = "4A5000E9F04A035A8E1D1F76655AE2AC")

    private int mVoiceMaxResults;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.069 -0400", hash_original_method = "633954995A30C027EA0DC2D487CA3CDA", hash_generated_method = "4F65ED6E3FD969A24B5D83E170C2F537")
    private  SearchableInfo(Context activityContext, AttributeSet attr, final ComponentName cName) {
        addTaint(attr.getTaint());
        addTaint(activityContext.getTaint());
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
        if(mSuggestAuthority != null)        
        {
            PackageManager pm = activityContext.getPackageManager();
            ProviderInfo pi = pm.resolveContentProvider(mSuggestAuthority, 0);
            if(pi != null)            
            {
                suggestProviderPackage = pi.packageName;
            } //End block
        } //End block
        mSuggestProviderPackage = suggestProviderPackage;
        if(mLabelId == 0)        
        {
            IllegalArgumentException var52341081E7DE6AC59DBBF14D7F787333_1605570431 = new IllegalArgumentException("Search label must be a resource reference.");
            var52341081E7DE6AC59DBBF14D7F787333_1605570431.addTaint(taint);
            throw var52341081E7DE6AC59DBBF14D7F787333_1605570431;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.074 -0400", hash_original_method = "5317CE2CAB02C1DC0498B77BC3A6FE3A", hash_generated_method = "4B72E97686B9CF24D04BC2B9C7635528")
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
for(int count = in.readInt();count > 0;count--)
        {
            addActionKey(new ActionKeyInfo(in));
        } //End block
        mSuggestProviderPackage = in.readString();
        mVoiceSearchMode = in.readInt();
        mVoiceLanguageModeId = in.readInt();
        mVoicePromptTextId = in.readInt();
        mVoiceLanguageId = in.readInt();
        mVoiceMaxResults = in.readInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.075 -0400", hash_original_method = "9CC6B7578CF19F95DF8C884BF5987E46", hash_generated_method = "FC3BF05133AAC52E6D386CB05E5E1BB3")
    public String getSuggestAuthority() {
String var5DDEE5D2D729187F670A9F6EF6F4328C_1833480244 =         mSuggestAuthority;
        var5DDEE5D2D729187F670A9F6EF6F4328C_1833480244.addTaint(taint);
        return var5DDEE5D2D729187F670A9F6EF6F4328C_1833480244;
        // ---------- Original Method ----------
        //return mSuggestAuthority;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.075 -0400", hash_original_method = "BE8BEFD3C329420CF7D6C5DA35EA0FF0", hash_generated_method = "EB6AF7DB8028F9656B8B6706EF76FFAC")
    public String getSuggestPackage() {
String varA49D578DA4784C762837406ABC3BF42C_1048964688 =         mSuggestProviderPackage;
        varA49D578DA4784C762837406ABC3BF42C_1048964688.addTaint(taint);
        return varA49D578DA4784C762837406ABC3BF42C_1048964688;
        // ---------- Original Method ----------
        //return mSuggestProviderPackage;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.076 -0400", hash_original_method = "F3041DF7A3866005E32579E92AEBEE6A", hash_generated_method = "DC50B96D2D9EAE0750BCB3770A84F268")
    public ComponentName getSearchActivity() {
ComponentName varCF461DA42806DB5CBA344D9330283F60_1591791793 =         mSearchActivity;
        varCF461DA42806DB5CBA344D9330283F60_1591791793.addTaint(taint);
        return varCF461DA42806DB5CBA344D9330283F60_1591791793;
        // ---------- Original Method ----------
        //return mSearchActivity;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.076 -0400", hash_original_method = "E8E1D8EA6D890D66AA7ADE8877B0250D", hash_generated_method = "E4C78A898CF857181D79BC3F542C1D60")
    public boolean useBadgeLabel() {
        boolean var75FC1C8D52FF5DAD9AA79A236D8F402E_1069272438 = (0 != (mSearchMode & SEARCH_MODE_BADGE_LABEL));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1900335951 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1900335951;
        // ---------- Original Method ----------
        //return 0 != (mSearchMode & SEARCH_MODE_BADGE_LABEL);
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.077 -0400", hash_original_method = "FEE9D772AE5D3D19558CCEFFB0D8835C", hash_generated_method = "66389524814747F1A6386FDE5D958DEC")
    public boolean useBadgeIcon() {
        boolean var8A0531D2112EE78CF8C4C0743704EBD9_668598712 = ((0 != (mSearchMode & SEARCH_MODE_BADGE_ICON)) && (mIconId != 0));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_428517260 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_428517260;
        // ---------- Original Method ----------
        //return (0 != (mSearchMode & SEARCH_MODE_BADGE_ICON)) && (mIconId != 0);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.077 -0400", hash_original_method = "B8AED61CE994D23FCE3A1E2344A9A897", hash_generated_method = "67E29EF18EB8DD07866FD7A25512EDC3")
    public boolean shouldRewriteQueryFromData() {
        boolean var4B08929E130210A0239F1761A5ED5853_639224911 = (0 != (mSearchMode & SEARCH_MODE_QUERY_REWRITE_FROM_DATA));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_16674525 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_16674525;
        // ---------- Original Method ----------
        //return 0 != (mSearchMode & SEARCH_MODE_QUERY_REWRITE_FROM_DATA);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.077 -0400", hash_original_method = "5A9C6F4DB0BEA2BB31C909F5BB55A3E0", hash_generated_method = "F959D2348C13E3C718FF758C8E370123")
    public boolean shouldRewriteQueryFromText() {
        boolean varBD01716CE745297140D841911D0D68FF_18075438 = (0 != (mSearchMode & SEARCH_MODE_QUERY_REWRITE_FROM_TEXT));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2092744227 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2092744227;
        // ---------- Original Method ----------
        //return 0 != (mSearchMode & SEARCH_MODE_QUERY_REWRITE_FROM_TEXT);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.078 -0400", hash_original_method = "19684FC2043C1BDB61A3E740D6C19B34", hash_generated_method = "687A32E02F0DCFEDE9B66A96D6DE18A5")
    public int getSettingsDescriptionId() {
        int var4C0CE3F626ABB04381EC5B6DA773593E_45784224 = (mSettingsDescriptionId);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1368379066 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1368379066;
        // ---------- Original Method ----------
        //return mSettingsDescriptionId;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.078 -0400", hash_original_method = "E8F19B2AFF47ACFE52244E7315CE6CBA", hash_generated_method = "A7CAE0916291911D35D9852186BBF469")
    public String getSuggestPath() {
String var021946CCE7117A749632EB0598533437_835339096 =         mSuggestPath;
        var021946CCE7117A749632EB0598533437_835339096.addTaint(taint);
        return var021946CCE7117A749632EB0598533437_835339096;
        // ---------- Original Method ----------
        //return mSuggestPath;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.079 -0400", hash_original_method = "03B94AF5E978777AF0A4DF7C1D53B2F0", hash_generated_method = "8AD328CF684C3B210B5CC78A88BE89EC")
    public String getSuggestSelection() {
String varDF426E885D6B46948C60DF1BFB04717C_979867449 =         mSuggestSelection;
        varDF426E885D6B46948C60DF1BFB04717C_979867449.addTaint(taint);
        return varDF426E885D6B46948C60DF1BFB04717C_979867449;
        // ---------- Original Method ----------
        //return mSuggestSelection;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.079 -0400", hash_original_method = "41669F0953535FACC4B7926CFCBDA8A1", hash_generated_method = "61211644BFDFEADB4D5E96BF38B14B36")
    public String getSuggestIntentAction() {
String varD51E2368873E1D36367434CFA168E0B8_1898512702 =         mSuggestIntentAction;
        varD51E2368873E1D36367434CFA168E0B8_1898512702.addTaint(taint);
        return varD51E2368873E1D36367434CFA168E0B8_1898512702;
        // ---------- Original Method ----------
        //return mSuggestIntentAction;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.080 -0400", hash_original_method = "E2551EFF005AD652F4CA5C2DEBD8F1C5", hash_generated_method = "A2AE2826508936301DF1FEAB4F8B9207")
    public String getSuggestIntentData() {
String varF83231E5CCFF6B553FE201A622B94241_1229322237 =         mSuggestIntentData;
        varF83231E5CCFF6B553FE201A622B94241_1229322237.addTaint(taint);
        return varF83231E5CCFF6B553FE201A622B94241_1229322237;
        // ---------- Original Method ----------
        //return mSuggestIntentData;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.080 -0400", hash_original_method = "EC28F48C38E111E12DD92E58268AB4B1", hash_generated_method = "752326A8150EDF5C1E515919581E5885")
    public int getSuggestThreshold() {
        int var22B05A6765211453BABA6F8A79424691_1857154602 = (mSuggestThreshold);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1807495706 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1807495706;
        // ---------- Original Method ----------
        //return mSuggestThreshold;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.081 -0400", hash_original_method = "BBBE2BBFCBFB429E05BB475016E66C58", hash_generated_method = "E57338666115F47714DFA68AD2278A10")
    public Context getActivityContext(Context context) {
        addTaint(context.getTaint());
Context var1A4A3F2A709A718B2F904609658B5327_1538363680 =         createActivityContext(context, mSearchActivity);
        var1A4A3F2A709A718B2F904609658B5327_1538363680.addTaint(taint);
        return var1A4A3F2A709A718B2F904609658B5327_1538363680;
        // ---------- Original Method ----------
        //return createActivityContext(context, mSearchActivity);
    }

    
    @DSModeled(DSC.BAN)
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

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.082 -0400", hash_original_method = "B0B7C6DE2D55DA45CA53022A0C4DE186", hash_generated_method = "9A1104313D4F6CA80F71E61D502E7439")
    public Context getProviderContext(Context context, Context activityContext) {
        addTaint(activityContext.getTaint());
        addTaint(context.getTaint());
        Context theirContext = null;
        if(mSearchActivity.getPackageName().equals(mSuggestProviderPackage))        
        {
Context varF3A9A334555EAB129F516C001FF96B56_1278251924 =             activityContext;
            varF3A9A334555EAB129F516C001FF96B56_1278251924.addTaint(taint);
            return varF3A9A334555EAB129F516C001FF96B56_1278251924;
        } //End block
        if(mSuggestProviderPackage != null)        
        {
            try 
            {
                theirContext = context.createPackageContext(mSuggestProviderPackage, 0);
            } //End block
            catch (PackageManager.NameNotFoundException e)
            {
            } //End block
            catch (java.lang.SecurityException e)
            {
            } //End block
        } //End block
Context varAE9E4E2B51B60753D4D52AA89B2019F3_1399636344 =         theirContext;
        varAE9E4E2B51B60753D4D52AA89B2019F3_1399636344.addTaint(taint);
        return varAE9E4E2B51B60753D4D52AA89B2019F3_1399636344;
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.082 -0400", hash_original_method = "642EB13C162B9C3DDBE9F6D8F3F1EFAB", hash_generated_method = "7D8163A72E5F84BEFE237B7E28C26069")
    public ActionKeyInfo findActionKey(int keyCode) {
        addTaint(keyCode);
        if(mActionKeys == null)        
        {
ActionKeyInfo var540C13E9E156B687226421B24F2DF178_691295236 =             null;
            var540C13E9E156B687226421B24F2DF178_691295236.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_691295236;
        } //End block
ActionKeyInfo var84BB625C941C7D500DC00A075C71E98C_354147134 =         mActionKeys.get(keyCode);
        var84BB625C941C7D500DC00A075C71E98C_354147134.addTaint(taint);
        return var84BB625C941C7D500DC00A075C71E98C_354147134;
        // ---------- Original Method ----------
        //if (mActionKeys == null) {
            //return null;
        //}
        //return mActionKeys.get(keyCode);
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.083 -0400", hash_original_method = "0D70E2215A9C7B06033D45B8CD7DC306", hash_generated_method = "1BC1D87EFF2B8367D4515F9893003EEB")
    private void addActionKey(ActionKeyInfo keyInfo) {
        addTaint(keyInfo.getTaint());
        if(mActionKeys == null)        
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

    
    @DSModeled(DSC.BAN)
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

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.084 -0400", hash_original_method = "32CB8385CEC61194A5C52A7CECC7153B", hash_generated_method = "5DA986C51AC43FC50AC75F9E399AF846")
    public int getLabelId() {
        int varD057B2BB85264BE6A162A2050E03E209_1732463864 = (mLabelId);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1125943500 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1125943500;
        // ---------- Original Method ----------
        //return mLabelId;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.085 -0400", hash_original_method = "DC9D54FA42277F7545187887A5854A7A", hash_generated_method = "C07A6B7D8BC6DFAD4971B08FA5C61FC3")
    public int getHintId() {
        int varF9B6782402E61448FE6CDDBE1079CDEE_557871995 = (mHintId);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1792960279 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1792960279;
        // ---------- Original Method ----------
        //return mHintId;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.085 -0400", hash_original_method = "B3A2F353BC85020D961D66DA378099D0", hash_generated_method = "DD1A15EE37FD7E8B1AA9D0F77B3C7D93")
    public int getIconId() {
        int varD7630CF52154C2427A7112C0FFA081B1_499314013 = (mIconId);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1145269833 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1145269833;
        // ---------- Original Method ----------
        //return mIconId;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.085 -0400", hash_original_method = "BD4587B1756B2E1B29D5C797A6E8E884", hash_generated_method = "8698396948676B8B037391D9BD35939F")
    public boolean getVoiceSearchEnabled() {
        boolean var87FBE8EE1D6859216E716571AD8F9069_825358 = (0 != (mVoiceSearchMode & VOICE_SEARCH_SHOW_BUTTON));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_990295036 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_990295036;
        // ---------- Original Method ----------
        //return 0 != (mVoiceSearchMode & VOICE_SEARCH_SHOW_BUTTON);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.086 -0400", hash_original_method = "AD4F5DA741FB0C864BEACDD753D4C8F3", hash_generated_method = "0D4BF4F2B6D36EACED3B2F3BE575C589")
    public boolean getVoiceSearchLaunchWebSearch() {
        boolean varCE31412759ED6EF66B8948D7E5491705_1843602802 = (0 != (mVoiceSearchMode & VOICE_SEARCH_LAUNCH_WEB_SEARCH));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1127683600 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1127683600;
        // ---------- Original Method ----------
        //return 0 != (mVoiceSearchMode & VOICE_SEARCH_LAUNCH_WEB_SEARCH);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.086 -0400", hash_original_method = "8242FA220A8F4815DCA2E78C8BAC691A", hash_generated_method = "1C88682A72ABD16345A0F3F043CA667F")
    public boolean getVoiceSearchLaunchRecognizer() {
        boolean var7CFBC389ABDAE5527A6D6297255E04AB_1823933025 = (0 != (mVoiceSearchMode & VOICE_SEARCH_LAUNCH_RECOGNIZER));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1626274897 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1626274897;
        // ---------- Original Method ----------
        //return 0 != (mVoiceSearchMode & VOICE_SEARCH_LAUNCH_RECOGNIZER);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.087 -0400", hash_original_method = "AE92C4DB1762FDEF1095AB548D604322", hash_generated_method = "29EFB25FBF9E44E32BBF00C76208BFB4")
    public int getVoiceLanguageModeId() {
        int var03F77744C7D51598EA5C20BAD9A6FF8E_463970224 = (mVoiceLanguageModeId);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_385303777 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_385303777;
        // ---------- Original Method ----------
        //return mVoiceLanguageModeId;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.087 -0400", hash_original_method = "22DBBDA410168ED4037FF766F7DE7742", hash_generated_method = "7419C7C85AC74847B1ED33F0DFC03FA1")
    public int getVoicePromptTextId() {
        int var05F56573DEFC97C433D25F4CAEBE94CC_1855944252 = (mVoicePromptTextId);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_248856695 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_248856695;
        // ---------- Original Method ----------
        //return mVoicePromptTextId;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.088 -0400", hash_original_method = "79CDC130EB87863FB2A36D85DFC36EA0", hash_generated_method = "8C443F5FB4041118BF0D66ABDD558667")
    public int getVoiceLanguageId() {
        int varE66DD97243D1B6526BF8E4264871DB77_2007085931 = (mVoiceLanguageId);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_59621307 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_59621307;
        // ---------- Original Method ----------
        //return mVoiceLanguageId;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.088 -0400", hash_original_method = "77BBA2ED9E38231A613E9BF06CBFC2B7", hash_generated_method = "10E2A928E58DF83182A8834E7D552883")
    public int getVoiceMaxResults() {
        int var46CC12A5AB44CBE81DA898323B8ABD6B_1477525962 = (mVoiceMaxResults);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2047786401 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2047786401;
        // ---------- Original Method ----------
        //return mVoiceMaxResults;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.089 -0400", hash_original_method = "A9AA4A30E735A990543D5C1057AC451E", hash_generated_method = "BA6222FE8E6DCBB8AF1479B3CF26709C")
    public int getSearchButtonText() {
        int var0826F96358F107FED726F6D2004E0424_394071193 = (mSearchButtonText);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1358923866 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1358923866;
        // ---------- Original Method ----------
        //return mSearchButtonText;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.089 -0400", hash_original_method = "4835EFF052D409983E396160FFE84050", hash_generated_method = "951171A4D5845B53936ADE7E2E43AD31")
    public int getInputType() {
        int varE1AFE3AE8B9005A0BAB937E2BF25305C_79165688 = (mSearchInputType);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_310306080 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_310306080;
        // ---------- Original Method ----------
        //return mSearchInputType;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.091 -0400", hash_original_method = "1FE8811970C0953B1D5BA2B119F61221", hash_generated_method = "A27CDAE48715722F48C466548D5BB474")
    public int getImeOptions() {
        int var220E297C1E16D14AA9F51E010AAA5BDD_1170997182 = (mSearchImeOptions);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1341834446 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1341834446;
        // ---------- Original Method ----------
        //return mSearchImeOptions;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.091 -0400", hash_original_method = "B3CD0EA91E55821485199A61F4C775D4", hash_generated_method = "616152637A4D881826F83F8205F73433")
    public boolean shouldIncludeInGlobalSearch() {
        boolean varDBAA85CB46828DF39EBA185991B74924_854996914 = (mIncludeInGlobalSearch);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1772067948 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1772067948;
        // ---------- Original Method ----------
        //return mIncludeInGlobalSearch;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.092 -0400", hash_original_method = "942D4E1EA5C6469103A344EA38AACE8F", hash_generated_method = "E5082B469531807442DF57B11205D28F")
    public boolean queryAfterZeroResults() {
        boolean var2AE4A58FAB921A667862F2E5E851BFC8_1957454808 = (mQueryAfterZeroResults);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1837750865 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1837750865;
        // ---------- Original Method ----------
        //return mQueryAfterZeroResults;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.092 -0400", hash_original_method = "43849E9B2F1DCB4A199E2A722DA4C20F", hash_generated_method = "669B298837D0446741E037216FD626FF")
    public boolean autoUrlDetect() {
        boolean varB0F477017B3A20C523CB75C2CB2CCA61_1715219578 = (mAutoUrlDetect);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1800555232 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1800555232;
        // ---------- Original Method ----------
        //return mAutoUrlDetect;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.092 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "82CEB648C3B0A699C000FCC40F1F53B7")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_337494296 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1059376795 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1059376795;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.093 -0400", hash_original_method = "72AC80AD69CAD17D9DB571EFE399D945", hash_generated_method = "C25CCDA3E76C34C24760E3B388C1403A")
    public void writeToParcel(Parcel dest, int flags) {
        addTaint(flags);
        addTaint(dest.getTaint());
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
        if(mActionKeys == null)        
        {
            dest.writeInt(0);
        } //End block
        else
        {
            dest.writeInt(mActionKeys.size());
for(ActionKeyInfo actionKey : mActionKeys.values())
            {
                actionKey.writeToParcel(dest, flags);
            } //End block
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.094 -0400", hash_original_field = "EE855499B412893552B9F8058CF94D19", hash_generated_field = "6029AC817F6EE7A2286BA05155E91FE2")

        private int mKeyCode;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.094 -0400", hash_original_field = "5A34FA447B337D01F94955DEB924FC0E", hash_generated_field = "3B81F8E38011672647005EC28AB6705D")

        private String mQueryActionMsg;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.094 -0400", hash_original_field = "277E9AD3A9ADDD380D0265BF744B7917", hash_generated_field = "8B7684F3BA320FB4D5D226E291D79406")

        private String mSuggestActionMsg;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.094 -0400", hash_original_field = "A32AC381ED6E395D6C435DE2D59030BC", hash_generated_field = "7C9EC47CD295C84807F022D848264755")

        private String mSuggestActionMsgColumn;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.096 -0400", hash_original_method = "70C4080A4EB7D334155C1E669C19E162", hash_generated_method = "CDDF261B8F2E7F8C2B8E355A11711995")
          ActionKeyInfo(Context activityContext, AttributeSet attr) {
            addTaint(attr.getTaint());
            addTaint(activityContext.getTaint());
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
            if(mKeyCode == 0)            
            {
                IllegalArgumentException varC415E6C6DF4094B070C2D7BFABA6ADC7_890340551 = new IllegalArgumentException("No keycode.");
                varC415E6C6DF4094B070C2D7BFABA6ADC7_890340551.addTaint(taint);
                throw varC415E6C6DF4094B070C2D7BFABA6ADC7_890340551;
            } //End block
            else
            if((mQueryActionMsg == null) && 
                    (mSuggestActionMsg == null) && 
                    (mSuggestActionMsgColumn == null))            
            {
                IllegalArgumentException var32783AC67244368C6EA279261D37CFBD_1660513316 = new IllegalArgumentException("No message information.");
                var32783AC67244368C6EA279261D37CFBD_1660513316.addTaint(taint);
                throw var32783AC67244368C6EA279261D37CFBD_1660513316;
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.097 -0400", hash_original_method = "F27ACAC54FD4E2AFDD49ECEAEB99C834", hash_generated_method = "265E684231582EEA1B0AE30A9EA12397")
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

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.103 -0400", hash_original_method = "AA2A4756B9F9E3EBD53F7A185B310C03", hash_generated_method = "50A61F8540A879B31060255BBBC82927")
        public int getKeyCode() {
            int varEE855499B412893552B9F8058CF94D19_1414835447 = (mKeyCode);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_419359112 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_419359112;
            // ---------- Original Method ----------
            //return mKeyCode;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.104 -0400", hash_original_method = "0A4F0AAE3D0D859714A4EE4638C2A280", hash_generated_method = "4AFDC03D7ED82E586BA6B321C118F088")
        public String getQueryActionMsg() {
String varAB3F935DC461A4E900C74017586314CD_568637904 =             mQueryActionMsg;
            varAB3F935DC461A4E900C74017586314CD_568637904.addTaint(taint);
            return varAB3F935DC461A4E900C74017586314CD_568637904;
            // ---------- Original Method ----------
            //return mQueryActionMsg;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.104 -0400", hash_original_method = "EDCBBABEEE2D0A0DD8ABF8A81407A4FD", hash_generated_method = "6BA89958120CDCD762E38CF14FBE6912")
        public String getSuggestActionMsg() {
String varD065FBA8EED3DD928687A2AC715E009D_1377821873 =             mSuggestActionMsg;
            varD065FBA8EED3DD928687A2AC715E009D_1377821873.addTaint(taint);
            return varD065FBA8EED3DD928687A2AC715E009D_1377821873;
            // ---------- Original Method ----------
            //return mSuggestActionMsg;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.105 -0400", hash_original_method = "94611E44E9C4989C8B71AAF260F46112", hash_generated_method = "2CC00DAC870102B5F5270229F36568FC")
        public String getSuggestActionMsgColumn() {
String varFAE79A011350566B7695A9C4A2BF8223_578683508 =             mSuggestActionMsgColumn;
            varFAE79A011350566B7695A9C4A2BF8223_578683508.addTaint(taint);
            return varFAE79A011350566B7695A9C4A2BF8223_578683508;
            // ---------- Original Method ----------
            //return mSuggestActionMsgColumn;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.105 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "73E77F88796DFC2D2A3374DFBEC511B8")
        public int describeContents() {
            int varCFCD208495D565EF66E7DFF9F98764DA_1268418355 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2065500233 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2065500233;
            // ---------- Original Method ----------
            //return 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.105 -0400", hash_original_method = "285E938AE46ECF341AA39A5F914BC19D", hash_generated_method = "7F33A6BE1421B32A3351064A95A06DC2")
        public void writeToParcel(Parcel dest, int flags) {
            addTaint(flags);
            addTaint(dest.getTaint());
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


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.106 -0400", hash_original_field = "0F6F0EB642B3F46DE2B2DF48DA4427EF", hash_generated_field = "1A61763F9CABC9206BB5AE6E570AB8AE")

    private static final boolean DBG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.106 -0400", hash_original_field = "682B7D113CD593B2674A420FDC0709A3", hash_generated_field = "D203EEF0E4D64BCDB10C02861CF15E1D")

    private static final String LOG_TAG = "SearchableInfo";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.106 -0400", hash_original_field = "FFD19F1393ABC167FA85C88A5C04E2CB", hash_generated_field = "76D330B9576B93848FB10401AE5FD5DB")

    private static final String MD_LABEL_SEARCHABLE = "android.app.searchable";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.106 -0400", hash_original_field = "7F07CDD5FE239F7BDD6F531EAC8C54F9", hash_generated_field = "3869A799E84BF0AD918D019051C45943")

    private static final String MD_XML_ELEMENT_SEARCHABLE = "searchable";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.106 -0400", hash_original_field = "77E84D3440CDCA042F8A4AE51346F2FD", hash_generated_field = "0F40B5E21851701CBDEB2F9B3FA09668")

    private static final String MD_XML_ELEMENT_SEARCHABLE_ACTION_KEY = "actionkey";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.106 -0400", hash_original_field = "4FA0B82DD68D7FDE25BAD0D6896AC80E", hash_generated_field = "D8C00A0A4A3874113B0ACE14567A0701")

    private static final int SEARCH_MODE_BADGE_LABEL = 0x04;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.106 -0400", hash_original_field = "B5C4039F128BD2526A3400DBA4983562", hash_generated_field = "2BE46E815786ECF3C252C237E8DD0388")

    private static final int SEARCH_MODE_BADGE_ICON = 0x08;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.107 -0400", hash_original_field = "3C419F70CA38A1C76D9788E80E87D2A7", hash_generated_field = "EC9F9C22DFAA89E0C2358140824BB50B")

    private static final int SEARCH_MODE_QUERY_REWRITE_FROM_DATA = 0x10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.107 -0400", hash_original_field = "69F438DF99AA2977699C5B1AB08691FF", hash_generated_field = "C93683C3AF679B5C3A88B5416B498D23")

    private static final int SEARCH_MODE_QUERY_REWRITE_FROM_TEXT = 0x20;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.107 -0400", hash_original_field = "FEBBE46C9FB61EA77F5C345D9AC79DC0", hash_generated_field = "263F1C6CFA6203816856410C0EE21258")

    private static final int VOICE_SEARCH_SHOW_BUTTON = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.107 -0400", hash_original_field = "FF2A01F415368C6A4B75468A7EF63C14", hash_generated_field = "3E2C11E1F2558FB793D359EDBF9C6C40")

    private static final int VOICE_SEARCH_LAUNCH_WEB_SEARCH = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.107 -0400", hash_original_field = "769DD161AAB33C0E04A8F309010799FC", hash_generated_field = "8EBDD5ED70EDE6E46658E039B7B2F56C")

    private static final int VOICE_SEARCH_LAUNCH_RECOGNIZER = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.107 -0400", hash_original_field = "203A5BF2CB131E14354D4E080CD68B6E", hash_generated_field = "F3AF64F39E7F85BFEBFD501C152359E7")

    public static final Parcelable.Creator<SearchableInfo> CREATOR
    = new Parcelable.Creator<SearchableInfo>() {
    	@DSModeled(DSC.SAFE)
        public SearchableInfo createFromParcel(Parcel in) {
            return new SearchableInfo(in);
        }

        @DSModeled(DSC.SAFE)
        public SearchableInfo[] newArray(int size) {
            return new SearchableInfo[size];
        }
    };
    // orphaned legacy method
    public SearchableInfo createFromParcel(Parcel in) {
            return new SearchableInfo(in);
        }
    
    // orphaned legacy method
    public SearchableInfo[] newArray(int size) {
            return new SearchableInfo[size];
        }
    
}

