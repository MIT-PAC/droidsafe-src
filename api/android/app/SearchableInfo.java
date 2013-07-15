package android.app;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.899 -0400", hash_original_field = "D057B2BB85264BE6A162A2050E03E209", hash_generated_field = "D6FEAD9F73C8FE6EF0F3A12308DAC489")

    private int mLabelId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.899 -0400", hash_original_field = "F30792FDD94B575151C8430D4E5DBF29", hash_generated_field = "E06ADC11A1AEA67BA6BBE28FB67CAB66")

    private ComponentName mSearchActivity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.900 -0400", hash_original_field = "F9B6782402E61448FE6CDDBE1079CDEE", hash_generated_field = "25DB23E4AD14EAEADA10E3B1B67B84E0")

    private int mHintId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.900 -0400", hash_original_field = "89070FC64F8E69B4F0C300A298DB823A", hash_generated_field = "78FC51630A0764848864D2FF318ABDB8")

    private int mSearchMode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.900 -0400", hash_original_field = "D7630CF52154C2427A7112C0FFA081B1", hash_generated_field = "EF1ABACE4A55E5A864CC227FE8654387")

    private int mIconId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.900 -0400", hash_original_field = "0826F96358F107FED726F6D2004E0424", hash_generated_field = "2856721A0AE1EEA9045A703245A329AA")

    private int mSearchButtonText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.900 -0400", hash_original_field = "E1AFE3AE8B9005A0BAB937E2BF25305C", hash_generated_field = "1684EE1596133B8BF20C20A9B99DB6B1")

    private int mSearchInputType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.900 -0400", hash_original_field = "220E297C1E16D14AA9F51E010AAA5BDD", hash_generated_field = "9EA71DDC334F5E2B229494AAF349B8CB")

    private int mSearchImeOptions;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.900 -0400", hash_original_field = "DBAA85CB46828DF39EBA185991B74924", hash_generated_field = "C0BBF1D6E1CE09EDF5AAB403A08D2B75")

    private boolean mIncludeInGlobalSearch;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.900 -0400", hash_original_field = "2AE4A58FAB921A667862F2E5E851BFC8", hash_generated_field = "D751F4BD314E1B6DDF8E9B3F844D860A")

    private boolean mQueryAfterZeroResults;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.900 -0400", hash_original_field = "B0F477017B3A20C523CB75C2CB2CCA61", hash_generated_field = "0B1FDF9F0A272F0F48F41A49A4570B15")

    private boolean mAutoUrlDetect;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.901 -0400", hash_original_field = "4C0CE3F626ABB04381EC5B6DA773593E", hash_generated_field = "60CBA5980489FCAAEBAE1EB29ED4DD25")

    private int mSettingsDescriptionId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.901 -0400", hash_original_field = "6CBCEE9BDAD542F0160B7269139095AC", hash_generated_field = "C31BFA716E618C0AA35C3A46A49C74A2")

    private String mSuggestAuthority;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.901 -0400", hash_original_field = "740A9F5C1D9A70BB5CC84DADAB562D5C", hash_generated_field = "AA401E1B32346E981E53058520319AE6")

    private String mSuggestPath;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.901 -0400", hash_original_field = "7630364755A9100D83BD3C726C010E2C", hash_generated_field = "CD47AC54D2D5A339E2907D35BBED1C65")

    private String mSuggestSelection;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.901 -0400", hash_original_field = "6B985FAE9A7932531A557F2B2581B20F", hash_generated_field = "AF16C60CE6AC5E3F7A49FB3100F51C80")

    private String mSuggestIntentAction;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.901 -0400", hash_original_field = "CD0DFD9D95BAC58FF7C23EA5C480FA1D", hash_generated_field = "177360028843579AEBEC82687DC94948")

    private String mSuggestIntentData;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.901 -0400", hash_original_field = "22B05A6765211453BABA6F8A79424691", hash_generated_field = "79460A51BE9275FE6D19BC9F8F008D8F")

    private int mSuggestThreshold;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.901 -0400", hash_original_field = "9500EA58BACD01CE281AD3DB271EE6E4", hash_generated_field = "C9D6635EBF55DCF3ADED92CBCFA44CB7")

    private HashMap<Integer,ActionKeyInfo> mActionKeys = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.901 -0400", hash_original_field = "CF58932A35DA62EEA6407052FA331D97", hash_generated_field = "39020C0C71CE4563CBEEEE8C7CCBA6D7")

    private String mSuggestProviderPackage;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.902 -0400", hash_original_field = "1825B0D843C0E16C6D3686963AC2A7F0", hash_generated_field = "C80188786C75AB634A90822CFB16E29B")

    private int mVoiceSearchMode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.902 -0400", hash_original_field = "03F77744C7D51598EA5C20BAD9A6FF8E", hash_generated_field = "C30E8A2FA03A7817BD9C2B3025108BE2")

    private int mVoiceLanguageModeId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.902 -0400", hash_original_field = "05F56573DEFC97C433D25F4CAEBE94CC", hash_generated_field = "4A40D3223FA01F35360A1936FDE75E64")

    private int mVoicePromptTextId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.913 -0400", hash_original_field = "E66DD97243D1B6526BF8E4264871DB77", hash_generated_field = "3B8852BE17F84107FC1B74FAB195C21B")

    private int mVoiceLanguageId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.913 -0400", hash_original_field = "46CC12A5AB44CBE81DA898323B8ABD6B", hash_generated_field = "4A5000E9F04A035A8E1D1F76655AE2AC")

    private int mVoiceMaxResults;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.921 -0400", hash_original_method = "633954995A30C027EA0DC2D487CA3CDA", hash_generated_method = "45F50B4F40D6CAA1DDE3A96D487E3B79")
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
            IllegalArgumentException var52341081E7DE6AC59DBBF14D7F787333_167595191 = new IllegalArgumentException("Search label must be a resource reference.");
            var52341081E7DE6AC59DBBF14D7F787333_167595191.addTaint(taint);
            throw var52341081E7DE6AC59DBBF14D7F787333_167595191;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.926 -0400", hash_original_method = "5317CE2CAB02C1DC0498B77BC3A6FE3A", hash_generated_method = "4B72E97686B9CF24D04BC2B9C7635528")
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.926 -0400", hash_original_method = "9CC6B7578CF19F95DF8C884BF5987E46", hash_generated_method = "BEEA12115679E08098EE9C4C594F3C16")
    public String getSuggestAuthority() {
String var5DDEE5D2D729187F670A9F6EF6F4328C_1684239112 =         mSuggestAuthority;
        var5DDEE5D2D729187F670A9F6EF6F4328C_1684239112.addTaint(taint);
        return var5DDEE5D2D729187F670A9F6EF6F4328C_1684239112;
        // ---------- Original Method ----------
        //return mSuggestAuthority;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.927 -0400", hash_original_method = "BE8BEFD3C329420CF7D6C5DA35EA0FF0", hash_generated_method = "770F7FE00E71FE775E518B045AE71A01")
    public String getSuggestPackage() {
String varA49D578DA4784C762837406ABC3BF42C_1945478803 =         mSuggestProviderPackage;
        varA49D578DA4784C762837406ABC3BF42C_1945478803.addTaint(taint);
        return varA49D578DA4784C762837406ABC3BF42C_1945478803;
        // ---------- Original Method ----------
        //return mSuggestProviderPackage;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.927 -0400", hash_original_method = "F3041DF7A3866005E32579E92AEBEE6A", hash_generated_method = "C1961DFCED73976F15539E7675B49938")
    public ComponentName getSearchActivity() {
ComponentName varCF461DA42806DB5CBA344D9330283F60_1268816223 =         mSearchActivity;
        varCF461DA42806DB5CBA344D9330283F60_1268816223.addTaint(taint);
        return varCF461DA42806DB5CBA344D9330283F60_1268816223;
        // ---------- Original Method ----------
        //return mSearchActivity;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.928 -0400", hash_original_method = "E8E1D8EA6D890D66AA7ADE8877B0250D", hash_generated_method = "793830256E06C2632158DB995B5F3495")
    public boolean useBadgeLabel() {
        boolean var75FC1C8D52FF5DAD9AA79A236D8F402E_9936783 = (0 != (mSearchMode & SEARCH_MODE_BADGE_LABEL));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_141429874 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_141429874;
        // ---------- Original Method ----------
        //return 0 != (mSearchMode & SEARCH_MODE_BADGE_LABEL);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.930 -0400", hash_original_method = "FEE9D772AE5D3D19558CCEFFB0D8835C", hash_generated_method = "6F82816824916D9857A1338C40AEF65A")
    public boolean useBadgeIcon() {
        boolean var8A0531D2112EE78CF8C4C0743704EBD9_1182869747 = ((0 != (mSearchMode & SEARCH_MODE_BADGE_ICON)) && (mIconId != 0));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1115399766 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1115399766;
        // ---------- Original Method ----------
        //return (0 != (mSearchMode & SEARCH_MODE_BADGE_ICON)) && (mIconId != 0);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.931 -0400", hash_original_method = "B8AED61CE994D23FCE3A1E2344A9A897", hash_generated_method = "78A8119DBF0D10BED470D6EA9883A2C7")
    public boolean shouldRewriteQueryFromData() {
        boolean var4B08929E130210A0239F1761A5ED5853_1445081058 = (0 != (mSearchMode & SEARCH_MODE_QUERY_REWRITE_FROM_DATA));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_553792738 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_553792738;
        // ---------- Original Method ----------
        //return 0 != (mSearchMode & SEARCH_MODE_QUERY_REWRITE_FROM_DATA);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.932 -0400", hash_original_method = "5A9C6F4DB0BEA2BB31C909F5BB55A3E0", hash_generated_method = "1572086ED953AAA838166BF0621BD314")
    public boolean shouldRewriteQueryFromText() {
        boolean varBD01716CE745297140D841911D0D68FF_1880736226 = (0 != (mSearchMode & SEARCH_MODE_QUERY_REWRITE_FROM_TEXT));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1020875048 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1020875048;
        // ---------- Original Method ----------
        //return 0 != (mSearchMode & SEARCH_MODE_QUERY_REWRITE_FROM_TEXT);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.932 -0400", hash_original_method = "19684FC2043C1BDB61A3E740D6C19B34", hash_generated_method = "C093CE01100C596350DC884D6283241E")
    public int getSettingsDescriptionId() {
        int var4C0CE3F626ABB04381EC5B6DA773593E_346130052 = (mSettingsDescriptionId);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1840007883 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1840007883;
        // ---------- Original Method ----------
        //return mSettingsDescriptionId;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.932 -0400", hash_original_method = "E8F19B2AFF47ACFE52244E7315CE6CBA", hash_generated_method = "55EC69F229B025BC904E019AD9F3EFA4")
    public String getSuggestPath() {
String var021946CCE7117A749632EB0598533437_295889386 =         mSuggestPath;
        var021946CCE7117A749632EB0598533437_295889386.addTaint(taint);
        return var021946CCE7117A749632EB0598533437_295889386;
        // ---------- Original Method ----------
        //return mSuggestPath;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.933 -0400", hash_original_method = "03B94AF5E978777AF0A4DF7C1D53B2F0", hash_generated_method = "7C3305E7CB027ED953C9911777B1390B")
    public String getSuggestSelection() {
String varDF426E885D6B46948C60DF1BFB04717C_432395180 =         mSuggestSelection;
        varDF426E885D6B46948C60DF1BFB04717C_432395180.addTaint(taint);
        return varDF426E885D6B46948C60DF1BFB04717C_432395180;
        // ---------- Original Method ----------
        //return mSuggestSelection;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.933 -0400", hash_original_method = "41669F0953535FACC4B7926CFCBDA8A1", hash_generated_method = "86F179FDF66C55D01E5DC07D2F8A7F4F")
    public String getSuggestIntentAction() {
String varD51E2368873E1D36367434CFA168E0B8_643553552 =         mSuggestIntentAction;
        varD51E2368873E1D36367434CFA168E0B8_643553552.addTaint(taint);
        return varD51E2368873E1D36367434CFA168E0B8_643553552;
        // ---------- Original Method ----------
        //return mSuggestIntentAction;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.934 -0400", hash_original_method = "E2551EFF005AD652F4CA5C2DEBD8F1C5", hash_generated_method = "1ECC5EFE22DB3BE1C49B6847051ED8C6")
    public String getSuggestIntentData() {
String varF83231E5CCFF6B553FE201A622B94241_1437548137 =         mSuggestIntentData;
        varF83231E5CCFF6B553FE201A622B94241_1437548137.addTaint(taint);
        return varF83231E5CCFF6B553FE201A622B94241_1437548137;
        // ---------- Original Method ----------
        //return mSuggestIntentData;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.935 -0400", hash_original_method = "EC28F48C38E111E12DD92E58268AB4B1", hash_generated_method = "6D7BC3366EFCDBF23964D10990D1E1C5")
    public int getSuggestThreshold() {
        int var22B05A6765211453BABA6F8A79424691_1397466009 = (mSuggestThreshold);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2090172195 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2090172195;
        // ---------- Original Method ----------
        //return mSuggestThreshold;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.935 -0400", hash_original_method = "BBBE2BBFCBFB429E05BB475016E66C58", hash_generated_method = "D0AFA00D74F3D2889223AA080B7BCDFF")
    public Context getActivityContext(Context context) {
        addTaint(context.getTaint());
Context var1A4A3F2A709A718B2F904609658B5327_539089263 =         createActivityContext(context, mSearchActivity);
        var1A4A3F2A709A718B2F904609658B5327_539089263.addTaint(taint);
        return var1A4A3F2A709A718B2F904609658B5327_539089263;
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.944 -0400", hash_original_method = "B0B7C6DE2D55DA45CA53022A0C4DE186", hash_generated_method = "92661624915EDF23317FAE0ACE7AD94F")
    public Context getProviderContext(Context context, Context activityContext) {
        addTaint(activityContext.getTaint());
        addTaint(context.getTaint());
        Context theirContext = null;
    if(mSearchActivity.getPackageName().equals(mSuggestProviderPackage))        
        {
Context varF3A9A334555EAB129F516C001FF96B56_692746986 =             activityContext;
            varF3A9A334555EAB129F516C001FF96B56_692746986.addTaint(taint);
            return varF3A9A334555EAB129F516C001FF96B56_692746986;
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
Context varAE9E4E2B51B60753D4D52AA89B2019F3_237630183 =         theirContext;
        varAE9E4E2B51B60753D4D52AA89B2019F3_237630183.addTaint(taint);
        return varAE9E4E2B51B60753D4D52AA89B2019F3_237630183;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.946 -0400", hash_original_method = "642EB13C162B9C3DDBE9F6D8F3F1EFAB", hash_generated_method = "7C17CDFF35818767BEFC68D41B828A96")
    public ActionKeyInfo findActionKey(int keyCode) {
        addTaint(keyCode);
    if(mActionKeys == null)        
        {
ActionKeyInfo var540C13E9E156B687226421B24F2DF178_1584191088 =             null;
            var540C13E9E156B687226421B24F2DF178_1584191088.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1584191088;
        } //End block
ActionKeyInfo var84BB625C941C7D500DC00A075C71E98C_1966699050 =         mActionKeys.get(keyCode);
        var84BB625C941C7D500DC00A075C71E98C_1966699050.addTaint(taint);
        return var84BB625C941C7D500DC00A075C71E98C_1966699050;
        // ---------- Original Method ----------
        //if (mActionKeys == null) {
            //return null;
        //}
        //return mActionKeys.get(keyCode);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.946 -0400", hash_original_method = "0D70E2215A9C7B06033D45B8CD7DC306", hash_generated_method = "1BC1D87EFF2B8367D4515F9893003EEB")
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

    
        @DSModeled(DSC.SPEC)
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.948 -0400", hash_original_method = "32CB8385CEC61194A5C52A7CECC7153B", hash_generated_method = "10B9501C428C5BBE430720DE4BA0E500")
    public int getLabelId() {
        int varD057B2BB85264BE6A162A2050E03E209_111322351 = (mLabelId);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1627344138 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1627344138;
        // ---------- Original Method ----------
        //return mLabelId;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.949 -0400", hash_original_method = "DC9D54FA42277F7545187887A5854A7A", hash_generated_method = "88D02D064DEBEF6CA551857DFCD8CD0B")
    public int getHintId() {
        int varF9B6782402E61448FE6CDDBE1079CDEE_1121832242 = (mHintId);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1226540175 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1226540175;
        // ---------- Original Method ----------
        //return mHintId;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.950 -0400", hash_original_method = "B3A2F353BC85020D961D66DA378099D0", hash_generated_method = "4F8963EED209F64F4880F573BAA8632E")
    public int getIconId() {
        int varD7630CF52154C2427A7112C0FFA081B1_1317054793 = (mIconId);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_565145499 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_565145499;
        // ---------- Original Method ----------
        //return mIconId;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.952 -0400", hash_original_method = "BD4587B1756B2E1B29D5C797A6E8E884", hash_generated_method = "ADCB0937D53F114C3F7B0388B16C4051")
    public boolean getVoiceSearchEnabled() {
        boolean var87FBE8EE1D6859216E716571AD8F9069_149834235 = (0 != (mVoiceSearchMode & VOICE_SEARCH_SHOW_BUTTON));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2073179367 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2073179367;
        // ---------- Original Method ----------
        //return 0 != (mVoiceSearchMode & VOICE_SEARCH_SHOW_BUTTON);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.953 -0400", hash_original_method = "AD4F5DA741FB0C864BEACDD753D4C8F3", hash_generated_method = "BF4DC6D1741E534DE658FCED8949D6A2")
    public boolean getVoiceSearchLaunchWebSearch() {
        boolean varCE31412759ED6EF66B8948D7E5491705_1173053946 = (0 != (mVoiceSearchMode & VOICE_SEARCH_LAUNCH_WEB_SEARCH));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2101378906 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2101378906;
        // ---------- Original Method ----------
        //return 0 != (mVoiceSearchMode & VOICE_SEARCH_LAUNCH_WEB_SEARCH);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.953 -0400", hash_original_method = "8242FA220A8F4815DCA2E78C8BAC691A", hash_generated_method = "291FD87F19BDFFCD3AB97FEC45993F66")
    public boolean getVoiceSearchLaunchRecognizer() {
        boolean var7CFBC389ABDAE5527A6D6297255E04AB_533714665 = (0 != (mVoiceSearchMode & VOICE_SEARCH_LAUNCH_RECOGNIZER));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_664072140 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_664072140;
        // ---------- Original Method ----------
        //return 0 != (mVoiceSearchMode & VOICE_SEARCH_LAUNCH_RECOGNIZER);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.954 -0400", hash_original_method = "AE92C4DB1762FDEF1095AB548D604322", hash_generated_method = "2E52CE7D75B53E2C2DE1AA5A99661A5A")
    public int getVoiceLanguageModeId() {
        int var03F77744C7D51598EA5C20BAD9A6FF8E_1536071541 = (mVoiceLanguageModeId);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_977146022 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_977146022;
        // ---------- Original Method ----------
        //return mVoiceLanguageModeId;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.954 -0400", hash_original_method = "22DBBDA410168ED4037FF766F7DE7742", hash_generated_method = "EF804CEE2EC0222778D6ADC292B18117")
    public int getVoicePromptTextId() {
        int var05F56573DEFC97C433D25F4CAEBE94CC_322230602 = (mVoicePromptTextId);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_936581192 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_936581192;
        // ---------- Original Method ----------
        //return mVoicePromptTextId;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.955 -0400", hash_original_method = "79CDC130EB87863FB2A36D85DFC36EA0", hash_generated_method = "095944C946A6414E288ABE83F91F2081")
    public int getVoiceLanguageId() {
        int varE66DD97243D1B6526BF8E4264871DB77_313822645 = (mVoiceLanguageId);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_596994088 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_596994088;
        // ---------- Original Method ----------
        //return mVoiceLanguageId;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.955 -0400", hash_original_method = "77BBA2ED9E38231A613E9BF06CBFC2B7", hash_generated_method = "90FF0277A421D45A2E569F9D3BBA3BB0")
    public int getVoiceMaxResults() {
        int var46CC12A5AB44CBE81DA898323B8ABD6B_1632379668 = (mVoiceMaxResults);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_293077359 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_293077359;
        // ---------- Original Method ----------
        //return mVoiceMaxResults;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.956 -0400", hash_original_method = "A9AA4A30E735A990543D5C1057AC451E", hash_generated_method = "3D12DF497E927EB74AB58B5B9F908A37")
    public int getSearchButtonText() {
        int var0826F96358F107FED726F6D2004E0424_522910723 = (mSearchButtonText);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_597980720 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_597980720;
        // ---------- Original Method ----------
        //return mSearchButtonText;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.956 -0400", hash_original_method = "4835EFF052D409983E396160FFE84050", hash_generated_method = "B1F3DCD23A5C778B1FD5D7C1BCD6B478")
    public int getInputType() {
        int varE1AFE3AE8B9005A0BAB937E2BF25305C_1680760777 = (mSearchInputType);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1320899047 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1320899047;
        // ---------- Original Method ----------
        //return mSearchInputType;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.957 -0400", hash_original_method = "1FE8811970C0953B1D5BA2B119F61221", hash_generated_method = "39FAA3FF6A9C08D0A15D0823E1BBF830")
    public int getImeOptions() {
        int var220E297C1E16D14AA9F51E010AAA5BDD_1115353236 = (mSearchImeOptions);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1702324609 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1702324609;
        // ---------- Original Method ----------
        //return mSearchImeOptions;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.958 -0400", hash_original_method = "B3CD0EA91E55821485199A61F4C775D4", hash_generated_method = "3BB5AE67724BBDCD3631E32653B425A7")
    public boolean shouldIncludeInGlobalSearch() {
        boolean varDBAA85CB46828DF39EBA185991B74924_1101289610 = (mIncludeInGlobalSearch);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1927591015 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1927591015;
        // ---------- Original Method ----------
        //return mIncludeInGlobalSearch;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.958 -0400", hash_original_method = "942D4E1EA5C6469103A344EA38AACE8F", hash_generated_method = "3D4EC9125ED37BAF8AD84D91D60A3DF0")
    public boolean queryAfterZeroResults() {
        boolean var2AE4A58FAB921A667862F2E5E851BFC8_476804703 = (mQueryAfterZeroResults);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1647981924 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1647981924;
        // ---------- Original Method ----------
        //return mQueryAfterZeroResults;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.959 -0400", hash_original_method = "43849E9B2F1DCB4A199E2A722DA4C20F", hash_generated_method = "4B7EB1F6187EF0B55AD3EC78A913C344")
    public boolean autoUrlDetect() {
        boolean varB0F477017B3A20C523CB75C2CB2CCA61_1794723682 = (mAutoUrlDetect);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1944113035 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1944113035;
        // ---------- Original Method ----------
        //return mAutoUrlDetect;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.960 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "1B9EE8AF6762B795C21EC42D6F216763")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_1704254996 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1186973310 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1186973310;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.962 -0400", hash_original_method = "72AC80AD69CAD17D9DB571EFE399D945", hash_generated_method = "C25CCDA3E76C34C24760E3B388C1403A")
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.964 -0400", hash_original_field = "EE855499B412893552B9F8058CF94D19", hash_generated_field = "6029AC817F6EE7A2286BA05155E91FE2")

        private int mKeyCode;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.965 -0400", hash_original_field = "5A34FA447B337D01F94955DEB924FC0E", hash_generated_field = "3B81F8E38011672647005EC28AB6705D")

        private String mQueryActionMsg;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.965 -0400", hash_original_field = "277E9AD3A9ADDD380D0265BF744B7917", hash_generated_field = "8B7684F3BA320FB4D5D226E291D79406")

        private String mSuggestActionMsg;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.965 -0400", hash_original_field = "A32AC381ED6E395D6C435DE2D59030BC", hash_generated_field = "7C9EC47CD295C84807F022D848264755")

        private String mSuggestActionMsgColumn;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.968 -0400", hash_original_method = "70C4080A4EB7D334155C1E669C19E162", hash_generated_method = "6BABE2656DDA6C53D0DE18403636094C")
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
                IllegalArgumentException varC415E6C6DF4094B070C2D7BFABA6ADC7_834374455 = new IllegalArgumentException("No keycode.");
                varC415E6C6DF4094B070C2D7BFABA6ADC7_834374455.addTaint(taint);
                throw varC415E6C6DF4094B070C2D7BFABA6ADC7_834374455;
            } //End block
            else
    if((mQueryActionMsg == null) && 
                    (mSuggestActionMsg == null) && 
                    (mSuggestActionMsgColumn == null))            
            {
                IllegalArgumentException var32783AC67244368C6EA279261D37CFBD_1443303574 = new IllegalArgumentException("No message information.");
                var32783AC67244368C6EA279261D37CFBD_1443303574.addTaint(taint);
                throw var32783AC67244368C6EA279261D37CFBD_1443303574;
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.970 -0400", hash_original_method = "F27ACAC54FD4E2AFDD49ECEAEB99C834", hash_generated_method = "265E684231582EEA1B0AE30A9EA12397")
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
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.971 -0400", hash_original_method = "AA2A4756B9F9E3EBD53F7A185B310C03", hash_generated_method = "5AA58E9DADAE7275E3B7E6562E1D2DB8")
        public int getKeyCode() {
            int varEE855499B412893552B9F8058CF94D19_1143647887 = (mKeyCode);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1240105416 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1240105416;
            // ---------- Original Method ----------
            //return mKeyCode;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.972 -0400", hash_original_method = "0A4F0AAE3D0D859714A4EE4638C2A280", hash_generated_method = "BCA0F84237486963527DD64310D59A1C")
        public String getQueryActionMsg() {
String varAB3F935DC461A4E900C74017586314CD_776359649 =             mQueryActionMsg;
            varAB3F935DC461A4E900C74017586314CD_776359649.addTaint(taint);
            return varAB3F935DC461A4E900C74017586314CD_776359649;
            // ---------- Original Method ----------
            //return mQueryActionMsg;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.972 -0400", hash_original_method = "EDCBBABEEE2D0A0DD8ABF8A81407A4FD", hash_generated_method = "29D0C8A1455850C361A320FFAE967037")
        public String getSuggestActionMsg() {
String varD065FBA8EED3DD928687A2AC715E009D_134397760 =             mSuggestActionMsg;
            varD065FBA8EED3DD928687A2AC715E009D_134397760.addTaint(taint);
            return varD065FBA8EED3DD928687A2AC715E009D_134397760;
            // ---------- Original Method ----------
            //return mSuggestActionMsg;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.973 -0400", hash_original_method = "94611E44E9C4989C8B71AAF260F46112", hash_generated_method = "DD0D5D9273E22C2637AE213C35769A50")
        public String getSuggestActionMsgColumn() {
String varFAE79A011350566B7695A9C4A2BF8223_430321472 =             mSuggestActionMsgColumn;
            varFAE79A011350566B7695A9C4A2BF8223_430321472.addTaint(taint);
            return varFAE79A011350566B7695A9C4A2BF8223_430321472;
            // ---------- Original Method ----------
            //return mSuggestActionMsgColumn;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.973 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "5921C12F8CE5A63AFFF90C229F4B4B61")
        public int describeContents() {
            int varCFCD208495D565EF66E7DFF9F98764DA_397654434 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1703845987 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1703845987;
            // ---------- Original Method ----------
            //return 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.974 -0400", hash_original_method = "285E938AE46ECF341AA39A5F914BC19D", hash_generated_method = "7F33A6BE1421B32A3351064A95A06DC2")
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


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.974 -0400", hash_original_field = "0F6F0EB642B3F46DE2B2DF48DA4427EF", hash_generated_field = "1A61763F9CABC9206BB5AE6E570AB8AE")

    private static final boolean DBG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.974 -0400", hash_original_field = "682B7D113CD593B2674A420FDC0709A3", hash_generated_field = "D203EEF0E4D64BCDB10C02861CF15E1D")

    private static final String LOG_TAG = "SearchableInfo";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.975 -0400", hash_original_field = "FFD19F1393ABC167FA85C88A5C04E2CB", hash_generated_field = "76D330B9576B93848FB10401AE5FD5DB")

    private static final String MD_LABEL_SEARCHABLE = "android.app.searchable";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.975 -0400", hash_original_field = "7F07CDD5FE239F7BDD6F531EAC8C54F9", hash_generated_field = "3869A799E84BF0AD918D019051C45943")

    private static final String MD_XML_ELEMENT_SEARCHABLE = "searchable";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.975 -0400", hash_original_field = "77E84D3440CDCA042F8A4AE51346F2FD", hash_generated_field = "0F40B5E21851701CBDEB2F9B3FA09668")

    private static final String MD_XML_ELEMENT_SEARCHABLE_ACTION_KEY = "actionkey";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.975 -0400", hash_original_field = "4FA0B82DD68D7FDE25BAD0D6896AC80E", hash_generated_field = "D8C00A0A4A3874113B0ACE14567A0701")

    private static final int SEARCH_MODE_BADGE_LABEL = 0x04;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.975 -0400", hash_original_field = "B5C4039F128BD2526A3400DBA4983562", hash_generated_field = "2BE46E815786ECF3C252C237E8DD0388")

    private static final int SEARCH_MODE_BADGE_ICON = 0x08;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.975 -0400", hash_original_field = "3C419F70CA38A1C76D9788E80E87D2A7", hash_generated_field = "EC9F9C22DFAA89E0C2358140824BB50B")

    private static final int SEARCH_MODE_QUERY_REWRITE_FROM_DATA = 0x10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.976 -0400", hash_original_field = "69F438DF99AA2977699C5B1AB08691FF", hash_generated_field = "C93683C3AF679B5C3A88B5416B498D23")

    private static final int SEARCH_MODE_QUERY_REWRITE_FROM_TEXT = 0x20;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.976 -0400", hash_original_field = "FEBBE46C9FB61EA77F5C345D9AC79DC0", hash_generated_field = "263F1C6CFA6203816856410C0EE21258")

    private static final int VOICE_SEARCH_SHOW_BUTTON = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.976 -0400", hash_original_field = "FF2A01F415368C6A4B75468A7EF63C14", hash_generated_field = "3E2C11E1F2558FB793D359EDBF9C6C40")

    private static final int VOICE_SEARCH_LAUNCH_WEB_SEARCH = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.976 -0400", hash_original_field = "769DD161AAB33C0E04A8F309010799FC", hash_generated_field = "8EBDD5ED70EDE6E46658E039B7B2F56C")

    private static final int VOICE_SEARCH_LAUNCH_RECOGNIZER = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.976 -0400", hash_original_field = "203A5BF2CB131E14354D4E080CD68B6E", hash_generated_field = "F3AF64F39E7F85BFEBFD501C152359E7")

    public static final Parcelable.Creator<SearchableInfo> CREATOR
    = new Parcelable.Creator<SearchableInfo>() {
        public SearchableInfo createFromParcel(Parcel in) {
            return new SearchableInfo(in);
        }

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

