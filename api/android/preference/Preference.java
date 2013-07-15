package android.preference;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import com.android.internal.util.CharSequences;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.AbsSavedState;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Preference implements Comparable<Preference>, OnDependencyChangeListener {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.487 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.487 -0400", hash_original_field = "D1487CA8252F4AA0A95324AB4DDD5316", hash_generated_field = "13262EB3751B753EEB3302EF75D8B1E5")

    private PreferenceManager mPreferenceManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.487 -0400", hash_original_field = "6AC7F06B6413A1BE9C136DC7DF0D2B60", hash_generated_field = "CF2A5FB7C7BB55BD451D113BD690151D")

    private long mId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.487 -0400", hash_original_field = "3213C247B4603DED047FFE75B63B4B6C", hash_generated_field = "B2CD75E86D570A2CCE7E2BC973BD4ACD")

    private OnPreferenceChangeListener mOnChangeListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.487 -0400", hash_original_field = "AA894545820F13D1E6598CEEF475CCC9", hash_generated_field = "03339AEC23A0F6C8C8113E6F7DC55FB5")

    private OnPreferenceClickListener mOnClickListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.487 -0400", hash_original_field = "759FE618587C2AB1184A3DF4077B5BD4", hash_generated_field = "4DBBABE4B5343924D877A673E4358521")

    private int mOrder = DEFAULT_ORDER;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.487 -0400", hash_original_field = "4B03BBB3AD21DBD17B2B689923FCF1F6", hash_generated_field = "ECAB18871B55104BACD4283C12B1074D")

    private CharSequence mTitle;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.487 -0400", hash_original_field = "B4A04CB1D37B3364DF264481CEA8B25E", hash_generated_field = "0BEE4780876F1B970FEA6B12663CC1C4")

    private int mTitleRes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.488 -0400", hash_original_field = "364E1929FED648A0A411C548B6A6CE28", hash_generated_field = "89C28E4357F1254876CE9020798E5A89")

    private CharSequence mSummary;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.488 -0400", hash_original_field = "0F522D56B85B081BF02F698ECADD7AFE", hash_generated_field = "7DAEA4581257F07E76CD939CD24A2FD7")

    private int mIconResId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.488 -0400", hash_original_field = "1A265556E59DF15CAEC4E55FB61E68C7", hash_generated_field = "FFB83F2A7C9A877B036AAEB7C21DDF6E")

    private Drawable mIcon;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.488 -0400", hash_original_field = "7E690C9CC141370A5EC6E7A98DC6FF62", hash_generated_field = "C36B21320914DA8259201FF07A2C068D")

    private String mKey;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.488 -0400", hash_original_field = "B1135DD88C82BCDD4DCD8391BCD99883", hash_generated_field = "5782C825DA3F61D408DF2DCA63E7F54A")

    private Intent mIntent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.488 -0400", hash_original_field = "3FD10A4D9B0E4F081E637AB2E170510C", hash_generated_field = "F74F34FFBA0EE92FA7BFBACA55B63FEF")

    private String mFragment;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.488 -0400", hash_original_field = "45F5DC4EA541ED660CFEDA0032CA356C", hash_generated_field = "5596C79D633F3A9F64294D3BD6D43156")

    private Bundle mExtras;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.488 -0400", hash_original_field = "71AB1146E1CEE92AB74D832DEFFE135F", hash_generated_field = "8BBE5745FA7C6470C8EA4F0513877CD6")

    private boolean mEnabled = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.488 -0400", hash_original_field = "D2831E7836D599A678D483B6294DDC44", hash_generated_field = "1A3F26BEC59143A828A7366C664C2B34")

    private boolean mSelectable = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.488 -0400", hash_original_field = "DF5D85B683298771811AC0DA28EAA613", hash_generated_field = "24780C50494002A4AF74BE6D462BE687")

    private boolean mRequiresKey;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.488 -0400", hash_original_field = "0250DF5C7FFD5EED92782A49F6405CFF", hash_generated_field = "27082D50DFDAA9191800D07F3AF15268")

    private boolean mPersistent = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.488 -0400", hash_original_field = "A397CDE94E1B6D2DEDC3A6F7D910612B", hash_generated_field = "B26344E1F3EABE836E6724009E62D614")

    private String mDependencyKey;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.488 -0400", hash_original_field = "3D9F826E2A85D6A96D8493A9F2E57CAC", hash_generated_field = "42900AC295F63E9B792D05C2A7334252")

    private Object mDefaultValue;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.488 -0400", hash_original_field = "212F572493A222F913C2F8AB8182CA71", hash_generated_field = "BEDE89D1CA2E56235E886F0A2A60132A")

    private boolean mDependencyMet = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.489 -0400", hash_original_field = "39B855F662D38B52B3F468037B6033C8", hash_generated_field = "76B9F6CF747E54F39C22CAC52291B4CD")

    private boolean mShouldDisableView = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.489 -0400", hash_original_field = "B5C7F1291490ADFCCBE98EF4AC5DC599", hash_generated_field = "2628AFC967B4980D202AAA14C9F08E6C")

    private int mLayoutResId = com.android.internal.R.layout.preference;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.489 -0400", hash_original_field = "68A3A909EA046E49435A797A37664E61", hash_generated_field = "03CE89F32EE4B5097448BE77263408B4")

    private int mWidgetLayoutResId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.489 -0400", hash_original_field = "42DF999BF001FDB041B1E1ECE0658C31", hash_generated_field = "37581EC71ABDA9DF6D14233378E40DCE")

    private boolean mHasSpecifiedLayout = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.489 -0400", hash_original_field = "9B3DD33B99719CE65C53FA6749E2AD69", hash_generated_field = "AC60A661DDD5C1ADBF7F01BD463F7E24")

    private OnPreferenceChangeInternalListener mListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.489 -0400", hash_original_field = "698EF7B44319FC69CFD2FC82A890F638", hash_generated_field = "B4077C41DC030C953102067792AA61E0")

    private List<Preference> mDependents;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.489 -0400", hash_original_field = "D87E96F5609D6847DCF3861262CE4BE7", hash_generated_field = "5E4C3692572C298E63D6463802841D4E")

    private boolean mBaseMethodCalled;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.492 -0400", hash_original_method = "9CEB9C34CAA8ECAB230B50A0542D61B3", hash_generated_method = "74D1F627E9A957F43B8CE427BAE8AFEA")
    public  Preference(Context context, AttributeSet attrs, int defStyle) {
        addTaint(defStyle);
        addTaint(attrs.getTaint());
        mContext = context;
        TypedArray a = context.obtainStyledAttributes(attrs,
                com.android.internal.R.styleable.Preference, defStyle, 0);
for(int i = a.getIndexCount();i >= 0;i--)
        {
            int attr = a.getIndex(i);
switch(attr){
            case com.android.internal.R.styleable.Preference_icon:
            mIconResId = a.getResourceId(attr, 0);
            break;
            case com.android.internal.R.styleable.Preference_key:
            mKey = a.getString(attr);
            break;
            case com.android.internal.R.styleable.Preference_title:
            mTitleRes = a.getResourceId(attr, 0);
            mTitle = a.getString(attr);
            break;
            case com.android.internal.R.styleable.Preference_summary:
            mSummary = a.getString(attr);
            break;
            case com.android.internal.R.styleable.Preference_order:
            mOrder = a.getInt(attr, mOrder);
            break;
            case com.android.internal.R.styleable.Preference_fragment:
            mFragment = a.getString(attr);
            break;
            case com.android.internal.R.styleable.Preference_layout:
            mLayoutResId = a.getResourceId(attr, mLayoutResId);
            break;
            case com.android.internal.R.styleable.Preference_widgetLayout:
            mWidgetLayoutResId = a.getResourceId(attr, mWidgetLayoutResId);
            break;
            case com.android.internal.R.styleable.Preference_enabled:
            mEnabled = a.getBoolean(attr, true);
            break;
            case com.android.internal.R.styleable.Preference_selectable:
            mSelectable = a.getBoolean(attr, true);
            break;
            case com.android.internal.R.styleable.Preference_persistent:
            mPersistent = a.getBoolean(attr, mPersistent);
            break;
            case com.android.internal.R.styleable.Preference_dependency:
            mDependencyKey = a.getString(attr);
            break;
            case com.android.internal.R.styleable.Preference_defaultValue:
            mDefaultValue = onGetDefaultValue(a, attr);
            break;
            case com.android.internal.R.styleable.Preference_shouldDisableView:
            mShouldDisableView = a.getBoolean(attr, mShouldDisableView);
            break;
}
        } //End block
        a.recycle();
    if(!getClass().getName().startsWith("android.preference"))        
        {
            mHasSpecifiedLayout = true;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.492 -0400", hash_original_method = "48043D3D24F48A6FD06B47A9624983D0", hash_generated_method = "BF1985E86638FE5C9EDFA863C08F2728")
    public  Preference(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.preferenceStyle);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.492 -0400", hash_original_method = "B50FF766B3A35A641C8DC6BF5214AE70", hash_generated_method = "946D92E4443D83AFE407CB73CBDDE443")
    public  Preference(Context context) {
        this(context, null);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.493 -0400", hash_original_method = "75C2469AD4E7F0A9F01D294D0E9B9A83", hash_generated_method = "30179A0FE4AC0E5C8434527794E09FA5")
    protected Object onGetDefaultValue(TypedArray a, int index) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(index);
        addTaint(a.getTaint());
Object var540C13E9E156B687226421B24F2DF178_462793870 =         null;
        var540C13E9E156B687226421B24F2DF178_462793870.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_462793870;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.493 -0400", hash_original_method = "BB18D5EDF68F7EDDF74E48FAF30F475E", hash_generated_method = "36AB7FE2A4C2C0EF3565BBD54597E3F4")
    public void setIntent(Intent intent) {
        mIntent = intent;
        // ---------- Original Method ----------
        //mIntent = intent;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.493 -0400", hash_original_method = "AD027B7B58A4A2F151CC138FB7B23244", hash_generated_method = "760335B7D4F483445374DB2DDB06E021")
    public Intent getIntent() {
Intent var4DCF8E3D75AE0B94CDA94656DCE16BCE_844656517 =         mIntent;
        var4DCF8E3D75AE0B94CDA94656DCE16BCE_844656517.addTaint(taint);
        return var4DCF8E3D75AE0B94CDA94656DCE16BCE_844656517;
        // ---------- Original Method ----------
        //return mIntent;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.493 -0400", hash_original_method = "B84A292EE370DC034681ED1A5B514CE4", hash_generated_method = "918CDAB4381AA56F58F01C803B049B49")
    public void setFragment(String fragment) {
        mFragment = fragment;
        // ---------- Original Method ----------
        //mFragment = fragment;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.494 -0400", hash_original_method = "133D42C98C64EF6757CE3D375E2E1FA7", hash_generated_method = "39BA72A39BF5854F0566BBF9A7961A61")
    public String getFragment() {
String var5DA1096D62F21920EA3FC00E046E5678_121430820 =         mFragment;
        var5DA1096D62F21920EA3FC00E046E5678_121430820.addTaint(taint);
        return var5DA1096D62F21920EA3FC00E046E5678_121430820;
        // ---------- Original Method ----------
        //return mFragment;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.494 -0400", hash_original_method = "F77D5C181034415714B081995209DE64", hash_generated_method = "7794A6C71DA76282599FAEAEB3C15A2C")
    public Bundle getExtras() {
    if(mExtras == null)        
        {
            mExtras = new Bundle();
        } //End block
Bundle var5E49E1FEC958658F846C38CDDBF16A8B_547255440 =         mExtras;
        var5E49E1FEC958658F846C38CDDBF16A8B_547255440.addTaint(taint);
        return var5E49E1FEC958658F846C38CDDBF16A8B_547255440;
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //return mExtras;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.494 -0400", hash_original_method = "06728B07006932C3BCF42D880B54A6CC", hash_generated_method = "201F2B6A93E043F0B33580C13FEF936F")
    public Bundle peekExtras() {
Bundle var5E49E1FEC958658F846C38CDDBF16A8B_1645277274 =         mExtras;
        var5E49E1FEC958658F846C38CDDBF16A8B_1645277274.addTaint(taint);
        return var5E49E1FEC958658F846C38CDDBF16A8B_1645277274;
        // ---------- Original Method ----------
        //return mExtras;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.495 -0400", hash_original_method = "528C4C3ACF7780A9B6B960E406A0977A", hash_generated_method = "6AD8664649D6B13651F1D9C8F85F0FB7")
    public void setLayoutResource(int layoutResId) {
    if(layoutResId != mLayoutResId)        
        {
            mHasSpecifiedLayout = true;
        } //End block
        mLayoutResId = layoutResId;
        // ---------- Original Method ----------
        //if (layoutResId != mLayoutResId) {
            //mHasSpecifiedLayout = true;
        //}
        //mLayoutResId = layoutResId;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.495 -0400", hash_original_method = "A2555092F113429083F033F36B8E024F", hash_generated_method = "BDE9EB3CC2014E0B1F4B170942635FA8")
    public int getLayoutResource() {
        int varA9F6722A5294E529E32C28918E7CD8EA_1340930495 = (mLayoutResId);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1653735343 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1653735343;
        // ---------- Original Method ----------
        //return mLayoutResId;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.495 -0400", hash_original_method = "2204831C4D4DE968C9A72D9D306DDD8C", hash_generated_method = "E2DA80CE19E8A1FC7CFEFC8F33A14866")
    public void setWidgetLayoutResource(int widgetLayoutResId) {
    if(widgetLayoutResId != mWidgetLayoutResId)        
        {
            mHasSpecifiedLayout = true;
        } //End block
        mWidgetLayoutResId = widgetLayoutResId;
        // ---------- Original Method ----------
        //if (widgetLayoutResId != mWidgetLayoutResId) {
            //mHasSpecifiedLayout = true;
        //}
        //mWidgetLayoutResId = widgetLayoutResId;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.496 -0400", hash_original_method = "6D000A2827FAFE2A1A87DD4A065ACF04", hash_generated_method = "1F2988B746598313B70FD4DF3DBDEB5D")
    public int getWidgetLayoutResource() {
        int var68A3A909EA046E49435A797A37664E61_1759747523 = (mWidgetLayoutResId);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2111490419 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2111490419;
        // ---------- Original Method ----------
        //return mWidgetLayoutResId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.496 -0400", hash_original_method = "10F5B4A945AE227B9B33457223123B2A", hash_generated_method = "3EBC93B2875B7E6DDBA69B8EB86C80F6")
    public View getView(View convertView, ViewGroup parent) {
        addTaint(parent.getTaint());
        addTaint(convertView.getTaint());
    if(convertView == null)        
        {
            convertView = onCreateView(parent);
        } //End block
        onBindView(convertView);
View var78FE9B874BBEC69B62B43EE963245978_795017981 =         convertView;
        var78FE9B874BBEC69B62B43EE963245978_795017981.addTaint(taint);
        return var78FE9B874BBEC69B62B43EE963245978_795017981;
        // ---------- Original Method ----------
        //if (convertView == null) {
            //convertView = onCreateView(parent);
        //}
        //onBindView(convertView);
        //return convertView;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.496 -0400", hash_original_method = "DD0E6DF051F4F0779DD2D5F6BCD064A5", hash_generated_method = "D0AE44CF55A6DD33D26795FBB9C51027")
    protected View onCreateView(ViewGroup parent) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(parent.getTaint());
        final LayoutInflater layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View layout = layoutInflater.inflate(mLayoutResId, parent, false);
        final ViewGroup widgetFrame = (ViewGroup) layout
                .findViewById(com.android.internal.R.id.widget_frame);
    if(widgetFrame != null)        
        {
    if(mWidgetLayoutResId != 0)            
            {
                layoutInflater.inflate(mWidgetLayoutResId, widgetFrame);
            } //End block
            else
            {
                widgetFrame.setVisibility(View.GONE);
            } //End block
        } //End block
View var6BB281F92ECF603ABC908502047A266C_1379103858 =         layout;
        var6BB281F92ECF603ABC908502047A266C_1379103858.addTaint(taint);
        return var6BB281F92ECF603ABC908502047A266C_1379103858;
        // ---------- Original Method ----------
        //final LayoutInflater layoutInflater =
            //(LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //final View layout = layoutInflater.inflate(mLayoutResId, parent, false);
        //final ViewGroup widgetFrame = (ViewGroup) layout
                //.findViewById(com.android.internal.R.id.widget_frame);
        //if (widgetFrame != null) {
            //if (mWidgetLayoutResId != 0) {
                //layoutInflater.inflate(mWidgetLayoutResId, widgetFrame);
            //} else {
                //widgetFrame.setVisibility(View.GONE);
            //}
        //}
        //return layout;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.497 -0400", hash_original_method = "D65593443BAE954E876A7311E3E1909A", hash_generated_method = "61596633704456144D753DF3E528A31B")
    protected void onBindView(View view) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(view.getTaint());
        TextView textView = (TextView) view.findViewById(com.android.internal.R.id.title);
    if(textView != null)        
        {
            textView.setText(getTitle());
        } //End block
        textView = (TextView) view.findViewById(com.android.internal.R.id.summary);
    if(textView != null)        
        {
            final CharSequence summary = getSummary();
    if(!TextUtils.isEmpty(summary))            
            {
    if(textView.getVisibility() != View.VISIBLE)                
                {
                    textView.setVisibility(View.VISIBLE);
                } //End block
                textView.setText(getSummary());
            } //End block
            else
            {
    if(textView.getVisibility() != View.GONE)                
                {
                    textView.setVisibility(View.GONE);
                } //End block
            } //End block
        } //End block
        ImageView imageView = (ImageView) view.findViewById(com.android.internal.R.id.icon);
    if(imageView != null)        
        {
    if(mIconResId != 0 || mIcon != null)            
            {
    if(mIcon == null)                
                {
                    mIcon = getContext().getResources().getDrawable(mIconResId);
                } //End block
    if(mIcon != null)                
                {
                    imageView.setImageDrawable(mIcon);
                } //End block
            } //End block
            imageView.setVisibility(mIcon != null ? View.VISIBLE : View.GONE);
        } //End block
    if(mShouldDisableView)        
        {
            setEnabledStateOnViews(view, isEnabled());
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.498 -0400", hash_original_method = "4F80205B57D5838ADEC212DC6CB9E651", hash_generated_method = "F8D88C4E05E7307313CE459E152FFDCC")
    private void setEnabledStateOnViews(View v, boolean enabled) {
        addTaint(enabled);
        addTaint(v.getTaint());
        v.setEnabled(enabled);
    if(v instanceof ViewGroup)        
        {
            final ViewGroup vg = (ViewGroup) v;
for(int i = vg.getChildCount() - 1;i >= 0;i--)
            {
                setEnabledStateOnViews(vg.getChildAt(i), enabled);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //v.setEnabled(enabled);
        //if (v instanceof ViewGroup) {
            //final ViewGroup vg = (ViewGroup) v;
            //for (int i = vg.getChildCount() - 1; i >= 0; i--) {
                //setEnabledStateOnViews(vg.getChildAt(i), enabled);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.498 -0400", hash_original_method = "84974F9AFFF82527B4C714348BF0B3DB", hash_generated_method = "0D5DC52CA914DC21EA3E6383CFE98F8B")
    public void setOrder(int order) {
    if(order != mOrder)        
        {
            mOrder = order;
            notifyHierarchyChanged();
        } //End block
        // ---------- Original Method ----------
        //if (order != mOrder) {
            //mOrder = order;
            //notifyHierarchyChanged();
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.499 -0400", hash_original_method = "BE8C43C510B8AF8546FEBBAA3EF0F0B1", hash_generated_method = "1D089D25F7BB5B1CA19ED8FE3A4BFCBB")
    public int getOrder() {
        int var6D112D2229BB97D14E6F55D683775A63_1627446028 = (mOrder);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_419636837 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_419636837;
        // ---------- Original Method ----------
        //return mOrder;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.499 -0400", hash_original_method = "B4BEC153E73D566AEC40ED844297CB0F", hash_generated_method = "C65D180B3DC531E811671795356294F4")
    public void setTitle(CharSequence title) {
    if(title == null && mTitle != null || title != null && !title.equals(mTitle))        
        {
            mTitleRes = 0;
            mTitle = title;
            notifyChanged();
        } //End block
        // ---------- Original Method ----------
        //if (title == null && mTitle != null || title != null && !title.equals(mTitle)) {
            //mTitleRes = 0;
            //mTitle = title;
            //notifyChanged();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.500 -0400", hash_original_method = "4E4A93A9A53A92BE0779D6D57BF6863D", hash_generated_method = "6ACAB13F5CD19AE36D59ABBBF68726F7")
    public void setTitle(int titleResId) {
        setTitle(mContext.getString(titleResId));
        mTitleRes = titleResId;
        // ---------- Original Method ----------
        //setTitle(mContext.getString(titleResId));
        //mTitleRes = titleResId;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.500 -0400", hash_original_method = "9778C1A15B3D4EC3FC935EB49323C011", hash_generated_method = "CAD356289E4EB71DACD115A82FDC0559")
    public int getTitleRes() {
        int varB4A04CB1D37B3364DF264481CEA8B25E_2117575693 = (mTitleRes);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_856666307 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_856666307;
        // ---------- Original Method ----------
        //return mTitleRes;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.500 -0400", hash_original_method = "7D691BCB64236E7B5AF8F6CB0399C091", hash_generated_method = "DAFF026F709061180D4D6FC0482CD709")
    public CharSequence getTitle() {
CharSequence var4FE0D95ADE4B4BDFA36D55D8B62A6C49_567876754 =         mTitle;
        var4FE0D95ADE4B4BDFA36D55D8B62A6C49_567876754.addTaint(taint);
        return var4FE0D95ADE4B4BDFA36D55D8B62A6C49_567876754;
        // ---------- Original Method ----------
        //return mTitle;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.501 -0400", hash_original_method = "3511105857431430BED74F970B043B64", hash_generated_method = "7C9AE5CE5DD10893095F055BA231720B")
    public void setIcon(Drawable icon) {
    if((icon == null && mIcon != null) || (icon != null && mIcon != icon))        
        {
            mIcon = icon;
            notifyChanged();
        } //End block
        // ---------- Original Method ----------
        //if ((icon == null && mIcon != null) || (icon != null && mIcon != icon)) {
            //mIcon = icon;
            //notifyChanged();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.501 -0400", hash_original_method = "42E5A2AC84ED127F39E187697447AF4F", hash_generated_method = "C5B24FFBB5B7217533EEE4D1981CFE30")
    public void setIcon(int iconResId) {
        mIconResId = iconResId;
        setIcon(mContext.getResources().getDrawable(iconResId));
        // ---------- Original Method ----------
        //mIconResId = iconResId;
        //setIcon(mContext.getResources().getDrawable(iconResId));
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.501 -0400", hash_original_method = "ED78DC4ED6B2C6A65EDA3016CC1C1C4D", hash_generated_method = "BB661A1B0F3D280F08C5CD856729132C")
    public Drawable getIcon() {
Drawable var664A3A1F0DCFF82F0A8D0B798A32C3B0_1339972107 =         mIcon;
        var664A3A1F0DCFF82F0A8D0B798A32C3B0_1339972107.addTaint(taint);
        return var664A3A1F0DCFF82F0A8D0B798A32C3B0_1339972107;
        // ---------- Original Method ----------
        //return mIcon;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.502 -0400", hash_original_method = "485EE2482F168D23B57BE8096AF663D1", hash_generated_method = "E93E082F30E5C88591A8D6610F2CB704")
    public CharSequence getSummary() {
CharSequence var695653DA4AD97E07531185C51663AC04_1595130054 =         mSummary;
        var695653DA4AD97E07531185C51663AC04_1595130054.addTaint(taint);
        return var695653DA4AD97E07531185C51663AC04_1595130054;
        // ---------- Original Method ----------
        //return mSummary;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.502 -0400", hash_original_method = "9397E34A85A0111B42F6FFB9A2837DEB", hash_generated_method = "2A19F8C4BB770F91006551E47E0623F6")
    public void setSummary(CharSequence summary) {
    if(summary == null && mSummary != null || summary != null && !summary.equals(mSummary))        
        {
            mSummary = summary;
            notifyChanged();
        } //End block
        // ---------- Original Method ----------
        //if (summary == null && mSummary != null || summary != null && !summary.equals(mSummary)) {
            //mSummary = summary;
            //notifyChanged();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.502 -0400", hash_original_method = "7AEFEE5A5E2C81392912FC13D133C130", hash_generated_method = "A11E9B30E86B523A3DF49E93B23AF375")
    public void setSummary(int summaryResId) {
        addTaint(summaryResId);
        setSummary(mContext.getString(summaryResId));
        // ---------- Original Method ----------
        //setSummary(mContext.getString(summaryResId));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.503 -0400", hash_original_method = "86021B1A0572E898D2D9C9D290D998FE", hash_generated_method = "1C5D3AB7080347C2808798BBD16D6959")
    public void setEnabled(boolean enabled) {
    if(mEnabled != enabled)        
        {
            mEnabled = enabled;
            notifyDependencyChange(shouldDisableDependents());
            notifyChanged();
        } //End block
        // ---------- Original Method ----------
        //if (mEnabled != enabled) {
            //mEnabled = enabled;
            //notifyDependencyChange(shouldDisableDependents());
            //notifyChanged();
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.503 -0400", hash_original_method = "1BB77BECC2C1296C251576AD714A96C1", hash_generated_method = "E2837989527041D793BB897E6D2C4F08")
    public boolean isEnabled() {
        boolean varB0998570CEA6BAD6F2EF1169DF51823C_135014642 = (mEnabled && mDependencyMet);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_173633624 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_173633624;
        // ---------- Original Method ----------
        //return mEnabled && mDependencyMet;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.504 -0400", hash_original_method = "7EEA4953639C86CA9F36ABED9565FC6D", hash_generated_method = "083B2E06D41C235B51280B38C982EBB9")
    public void setSelectable(boolean selectable) {
    if(mSelectable != selectable)        
        {
            mSelectable = selectable;
            notifyChanged();
        } //End block
        // ---------- Original Method ----------
        //if (mSelectable != selectable) {
            //mSelectable = selectable;
            //notifyChanged();
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.505 -0400", hash_original_method = "A1A8E91E60B51F4951583D0866634B48", hash_generated_method = "CE52FF49C47E1B210029EA365EC49C3C")
    public boolean isSelectable() {
        boolean varE28FEF967AA6B38EBAD4E8DC579022AD_2001634504 = (mSelectable);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1719588030 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1719588030;
        // ---------- Original Method ----------
        //return mSelectable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.505 -0400", hash_original_method = "97FCA568B4719676F3D4400812EA1F3A", hash_generated_method = "7F12B03326FA27759FCDAC4095D8D9F3")
    public void setShouldDisableView(boolean shouldDisableView) {
        mShouldDisableView = shouldDisableView;
        notifyChanged();
        // ---------- Original Method ----------
        //mShouldDisableView = shouldDisableView;
        //notifyChanged();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.506 -0400", hash_original_method = "465C9050F708FCF1A73506501FE4644E", hash_generated_method = "1980171BE9C88285D1A20BBFB8A443F0")
    public boolean getShouldDisableView() {
        boolean varCCA1923E758DC6F889585D63E097A199_1930527662 = (mShouldDisableView);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1295384646 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1295384646;
        // ---------- Original Method ----------
        //return mShouldDisableView;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.506 -0400", hash_original_method = "6AF16C815DE6FE4144432EF99CDC825B", hash_generated_method = "BB756D9977BB6F777F4BE6A5354779A4")
     long getId() {
        long var6AC7F06B6413A1BE9C136DC7DF0D2B60_1529357187 = (mId);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_179219060 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_179219060;
        // ---------- Original Method ----------
        //return mId;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.507 -0400", hash_original_method = "DE9BB9E40914727DA5D6E94159FAF3CB", hash_generated_method = "B12F9C4DD7EEB07FF06C6B7E88BC35E4")
    protected void onClick() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.507 -0400", hash_original_method = "46997BE6329912D9EC1174E4CE7CAB04", hash_generated_method = "A0D999C711B71A98E8BAD75F5B963317")
    public void setKey(String key) {
        mKey = key;
    if(mRequiresKey && !hasKey())        
        {
            requireKey();
        } //End block
        // ---------- Original Method ----------
        //mKey = key;
        //if (mRequiresKey && !hasKey()) {
            //requireKey();
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.507 -0400", hash_original_method = "E0CEA0C6ABDC55C32B991C1D155B5E3E", hash_generated_method = "8E331F7401E11EB5839D7FB60A3D2EC9")
    public String getKey() {
String var79CD36FEA8F0B12D4023EF117F6A9A00_216185254 =         mKey;
        var79CD36FEA8F0B12D4023EF117F6A9A00_216185254.addTaint(taint);
        return var79CD36FEA8F0B12D4023EF117F6A9A00_216185254;
        // ---------- Original Method ----------
        //return mKey;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.508 -0400", hash_original_method = "21702F9605A21EAEE85E66B458F985AA", hash_generated_method = "E788708B0AC0C8CC58E6A2F9FBEB20E2")
     void requireKey() {
    if(mKey == null)        
        {
            IllegalStateException varD993F6B1774DF3DC92662F8B81178C3D_250414541 = new IllegalStateException("Preference does not have a key assigned.");
            varD993F6B1774DF3DC92662F8B81178C3D_250414541.addTaint(taint);
            throw varD993F6B1774DF3DC92662F8B81178C3D_250414541;
        } //End block
        mRequiresKey = true;
        // ---------- Original Method ----------
        //if (mKey == null) {
            //throw new IllegalStateException("Preference does not have a key assigned.");
        //}
        //mRequiresKey = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.508 -0400", hash_original_method = "3BC185E939D8CD84C5733E95D5330A61", hash_generated_method = "F6CCC8F85EC5D5733A4223A50A41EF38")
    public boolean hasKey() {
        boolean var8F79712C07771E732CAC515DA1A96F64_1762989824 = (!TextUtils.isEmpty(mKey));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1438071505 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1438071505;
        // ---------- Original Method ----------
        //return !TextUtils.isEmpty(mKey);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.508 -0400", hash_original_method = "45C46AF35C2A296F9912D410933691CF", hash_generated_method = "BD1AF0457FC3E5C625F845DFDC88D8B4")
    public boolean isPersistent() {
        boolean varEF7BF975B5B494F57B25EA1F790A52BC_1152119949 = (mPersistent);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_381337641 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_381337641;
        // ---------- Original Method ----------
        //return mPersistent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.508 -0400", hash_original_method = "E7579FEE83F4F133055197D69D72F289", hash_generated_method = "8EE68D0E0072E4E77457D91E32BA94C9")
    protected boolean shouldPersist() {
        boolean varB5A47C688AB00EC6B8B8B3CF3A479AE2_1978615796 = (mPreferenceManager != null && isPersistent() && hasKey());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1806262507 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1806262507;
        // ---------- Original Method ----------
        //return mPreferenceManager != null && isPersistent() && hasKey();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.508 -0400", hash_original_method = "9780EA334E29D2930E2D9A0F1CB4087F", hash_generated_method = "C4414A607836682C6B94DC1DA7BB4DF5")
    public void setPersistent(boolean persistent) {
        mPersistent = persistent;
        // ---------- Original Method ----------
        //mPersistent = persistent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.508 -0400", hash_original_method = "4367E5B2EAD1BB8898BD88F610DDAF7D", hash_generated_method = "13284544414DC9C636CDA88776F528E5")
    protected boolean callChangeListener(Object newValue) {
        addTaint(newValue.getTaint());
        boolean var892DA48709297D3551A88332C46C6F15_258011572 = (mOnChangeListener == null ? true : mOnChangeListener.onPreferenceChange(this, newValue));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1928963216 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1928963216;
        // ---------- Original Method ----------
        //return mOnChangeListener == null ? true : mOnChangeListener.onPreferenceChange(this, newValue);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.509 -0400", hash_original_method = "D46636D80B7557AC6195A05902CC638C", hash_generated_method = "7D40D426D5687A76C5D11598A2206435")
    public void setOnPreferenceChangeListener(OnPreferenceChangeListener onPreferenceChangeListener) {
        mOnChangeListener = onPreferenceChangeListener;
        // ---------- Original Method ----------
        //mOnChangeListener = onPreferenceChangeListener;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.509 -0400", hash_original_method = "9CC8E5271070D42EF9628C47033D91A6", hash_generated_method = "2DE9E8818E154D1527B7002AB540DF0B")
    public OnPreferenceChangeListener getOnPreferenceChangeListener() {
OnPreferenceChangeListener var0219E9A12561FA4B5F91801BE5101351_2009999833 =         mOnChangeListener;
        var0219E9A12561FA4B5F91801BE5101351_2009999833.addTaint(taint);
        return var0219E9A12561FA4B5F91801BE5101351_2009999833;
        // ---------- Original Method ----------
        //return mOnChangeListener;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.509 -0400", hash_original_method = "E8A10745E179E2FA23FF715EAD4A5CB3", hash_generated_method = "1C194BF6887E87978417EF5A65E3F26D")
    public void setOnPreferenceClickListener(OnPreferenceClickListener onPreferenceClickListener) {
        mOnClickListener = onPreferenceClickListener;
        // ---------- Original Method ----------
        //mOnClickListener = onPreferenceClickListener;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.509 -0400", hash_original_method = "55E2C6999F7D889141550F7A68D36827", hash_generated_method = "6EDC3186613FD9358E571A6B02E23162")
    public OnPreferenceClickListener getOnPreferenceClickListener() {
OnPreferenceClickListener var0CF64AAC8E1DF5109CBA8718B93BAC9D_560731971 =         mOnClickListener;
        var0CF64AAC8E1DF5109CBA8718B93BAC9D_560731971.addTaint(taint);
        return var0CF64AAC8E1DF5109CBA8718B93BAC9D_560731971;
        // ---------- Original Method ----------
        //return mOnClickListener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.509 -0400", hash_original_method = "501E66F7BA58D6B4C7BCFDD2200CB13A", hash_generated_method = "4A77AA00224A9F7CEEBB35F7F4238F6D")
     void performClick(PreferenceScreen preferenceScreen) {
        addTaint(preferenceScreen.getTaint());
    if(!isEnabled())        
        {
            return;
        } //End block
        onClick();
    if(mOnClickListener != null && mOnClickListener.onPreferenceClick(this))        
        {
            return;
        } //End block
        PreferenceManager preferenceManager = getPreferenceManager();
    if(preferenceManager != null)        
        {
            PreferenceManager.OnPreferenceTreeClickListener listener = preferenceManager
                    .getOnPreferenceTreeClickListener();
    if(preferenceScreen != null && listener != null
                    && listener.onPreferenceTreeClick(preferenceScreen, this))            
            {
                return;
            } //End block
        } //End block
    if(mIntent != null)        
        {
            Context context = getContext();
            context.startActivity(mIntent);
        } //End block
        // ---------- Original Method ----------
        //if (!isEnabled()) {
            //return;
        //}
        //onClick();
        //if (mOnClickListener != null && mOnClickListener.onPreferenceClick(this)) {
            //return;
        //}
        //PreferenceManager preferenceManager = getPreferenceManager();
        //if (preferenceManager != null) {
            //PreferenceManager.OnPreferenceTreeClickListener listener = preferenceManager
                    //.getOnPreferenceTreeClickListener();
            //if (preferenceScreen != null && listener != null
                    //&& listener.onPreferenceTreeClick(preferenceScreen, this)) {
                //return;
            //}
        //}
        //if (mIntent != null) {
            //Context context = getContext();
            //context.startActivity(mIntent);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.509 -0400", hash_original_method = "089B06359A27CB6D952DCE596F00B787", hash_generated_method = "02AAF674E2CDB10816B0C4C8EFA9DC2D")
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        addTaint(keyCode);
        addTaint(v.getTaint());
        boolean var68934A3E9455FA72420237EB05902327_1427215494 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_543179983 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_543179983;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.510 -0400", hash_original_method = "4F4EBC54D108D66F416C93B46580E117", hash_generated_method = "46078089232DC7D924A1CBA9386ACEB0")
    public Context getContext() {
Context var178E2AD52D6FBBB503F908168856B574_498664825 =         mContext;
        var178E2AD52D6FBBB503F908168856B574_498664825.addTaint(taint);
        return var178E2AD52D6FBBB503F908168856B574_498664825;
        // ---------- Original Method ----------
        //return mContext;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.510 -0400", hash_original_method = "8BF68140BB0364C46F5E3D57D69A6DB5", hash_generated_method = "F9AA96390DC0312DF4702DC0B4E8B525")
    public SharedPreferences getSharedPreferences() {
    if(mPreferenceManager == null)        
        {
SharedPreferences var540C13E9E156B687226421B24F2DF178_1307763141 =             null;
            var540C13E9E156B687226421B24F2DF178_1307763141.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1307763141;
        } //End block
SharedPreferences var6931FC1A5179E16ED14F6FDB69C610BC_318328550 =         mPreferenceManager.getSharedPreferences();
        var6931FC1A5179E16ED14F6FDB69C610BC_318328550.addTaint(taint);
        return var6931FC1A5179E16ED14F6FDB69C610BC_318328550;
        // ---------- Original Method ----------
        //if (mPreferenceManager == null) {
            //return null;
        //}
        //return mPreferenceManager.getSharedPreferences();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.522 -0400", hash_original_method = "59D9CBF7E4B6683DDFDC1DAE57ABD5B7", hash_generated_method = "E723CAB66C8193C7C1BEE0EF51F8FFF3")
    public SharedPreferences.Editor getEditor() {
    if(mPreferenceManager == null)        
        {
SharedPreferences.Editor var540C13E9E156B687226421B24F2DF178_1372375408 =             null;
            var540C13E9E156B687226421B24F2DF178_1372375408.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1372375408;
        } //End block
SharedPreferences.Editor varABFFF7131D023FF0D5B41102CA064E26_2018429283 =         mPreferenceManager.getEditor();
        varABFFF7131D023FF0D5B41102CA064E26_2018429283.addTaint(taint);
        return varABFFF7131D023FF0D5B41102CA064E26_2018429283;
        // ---------- Original Method ----------
        //if (mPreferenceManager == null) {
            //return null;
        //}
        //return mPreferenceManager.getEditor();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.522 -0400", hash_original_method = "23B2B69F1B515A4430736566C100E20E", hash_generated_method = "7DB5888B1280AFCB3A6518229EFCBAC1")
    public boolean shouldCommit() {
    if(mPreferenceManager == null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1021038312 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_322535407 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_322535407;
        } //End block
        boolean varEF1F133E2476D363D929168E90ADAD14_780976425 = (mPreferenceManager.shouldCommit());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1715912851 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1715912851;
        // ---------- Original Method ----------
        //if (mPreferenceManager == null) {
            //return false;
        //}
        //return mPreferenceManager.shouldCommit();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.522 -0400", hash_original_method = "93B6E6EE30870726B108BD396B876DEB", hash_generated_method = "301DB6D50A3573A18B198909821FA111")
    public int compareTo(Preference another) {
        addTaint(another.getTaint());
    if(mOrder != DEFAULT_ORDER
                || (mOrder == DEFAULT_ORDER && another.mOrder != DEFAULT_ORDER))        
        {
            int varE263F6634F0D192BE8ACB6EE6F59E21B_60453433 = (mOrder - another.mOrder);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1571107371 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1571107371;
        } //End block
        else
    if(mTitle == null)        
        {
            int varC4CA4238A0B923820DCC509A6F75849B_162961834 = (1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1608527457 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1608527457;
        } //End block
        else
    if(another.mTitle == null)        
        {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_1862534705 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1798412006 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1798412006;
        } //End block
        else
        {
            int var742A94F4C4AD9345542A35CDFC248CF6_1909489922 = (CharSequences.compareToIgnoreCase(mTitle, another.mTitle));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_452543802 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_452543802;
        } //End block
        // ---------- Original Method ----------
        //if (mOrder != DEFAULT_ORDER
                //|| (mOrder == DEFAULT_ORDER && another.mOrder != DEFAULT_ORDER)) {
            //return mOrder - another.mOrder; 
        //} else if (mTitle == null) {
            //return 1;
        //} else if (another.mTitle == null) {
            //return -1;
        //} else {
            //return CharSequences.compareToIgnoreCase(mTitle, another.mTitle);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.522 -0400", hash_original_method = "6457E3944D02DD03B8855B0556ABBC63", hash_generated_method = "E2BE31D553581E6027B8A65C18170CE5")
    final void setOnPreferenceChangeInternalListener(OnPreferenceChangeInternalListener listener) {
        mListener = listener;
        // ---------- Original Method ----------
        //mListener = listener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.523 -0400", hash_original_method = "BC518684C2B31AF5801BA48B18DD0A6B", hash_generated_method = "301E8A64A0F19F0F4326BD86F226E333")
    protected void notifyChanged() {
    if(mListener != null)        
        {
            mListener.onPreferenceChange(this);
        } //End block
        // ---------- Original Method ----------
        //if (mListener != null) {
            //mListener.onPreferenceChange(this);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.523 -0400", hash_original_method = "B6CFA705B58CA125A61E30E547554AC9", hash_generated_method = "4B8BA16405C938D396AB21B03652A303")
    protected void notifyHierarchyChanged() {
    if(mListener != null)        
        {
            mListener.onPreferenceHierarchyChange(this);
        } //End block
        // ---------- Original Method ----------
        //if (mListener != null) {
            //mListener.onPreferenceHierarchyChange(this);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.523 -0400", hash_original_method = "002FC5CEE5BE5B5D1FE36CEDBC1DEB65", hash_generated_method = "BB039C994EC2C598AAB03E7CC3C373DD")
    public PreferenceManager getPreferenceManager() {
PreferenceManager var00374A2A6A541F0EA9C609E6C6447EED_1756716778 =         mPreferenceManager;
        var00374A2A6A541F0EA9C609E6C6447EED_1756716778.addTaint(taint);
        return var00374A2A6A541F0EA9C609E6C6447EED_1756716778;
        // ---------- Original Method ----------
        //return mPreferenceManager;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.523 -0400", hash_original_method = "664C21A1EBA456CB3BAFB18286851581", hash_generated_method = "E0785BE4D5230C52DEE75D865B3CCE59")
    protected void onAttachedToHierarchy(PreferenceManager preferenceManager) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mPreferenceManager = preferenceManager;
        mId = preferenceManager.getNextId();
        dispatchSetInitialValue();
        // ---------- Original Method ----------
        //mPreferenceManager = preferenceManager;
        //mId = preferenceManager.getNextId();
        //dispatchSetInitialValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.523 -0400", hash_original_method = "ECA501E201E2D5472D2CB3C64A16D61F", hash_generated_method = "CEDF62541504E21C8B99E9FF9C6C284E")
    protected void onAttachedToActivity() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        registerDependency();
        // ---------- Original Method ----------
        //registerDependency();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.523 -0400", hash_original_method = "A499F7D8BECEFF58ECE377DCDDB4C87B", hash_generated_method = "6C66DE6826D2E596D56006E253A7F98A")
    private void registerDependency() {
    if(TextUtils.isEmpty(mDependencyKey))        
        return;
        Preference preference = findPreferenceInHierarchy(mDependencyKey);
    if(preference != null)        
        {
            preference.registerDependent(this);
        } //End block
        else
        {
            IllegalStateException varAA818F098B1257731F38F3C28247D3A0_1073176556 = new IllegalStateException("Dependency \"" + mDependencyKey
                    + "\" not found for preference \"" + mKey + "\" (title: \"" + mTitle + "\"");
            varAA818F098B1257731F38F3C28247D3A0_1073176556.addTaint(taint);
            throw varAA818F098B1257731F38F3C28247D3A0_1073176556;
        } //End block
        // ---------- Original Method ----------
        //if (TextUtils.isEmpty(mDependencyKey)) return;
        //Preference preference = findPreferenceInHierarchy(mDependencyKey);
        //if (preference != null) {
            //preference.registerDependent(this);
        //} else {
            //throw new IllegalStateException("Dependency \"" + mDependencyKey
                    //+ "\" not found for preference \"" + mKey + "\" (title: \"" + mTitle + "\"");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.523 -0400", hash_original_method = "40F9072BE8C6932FEF31F09A7FFFCE04", hash_generated_method = "E0CA9DEA4D60DF893A54187F3423CA69")
    private void unregisterDependency() {
    if(mDependencyKey != null)        
        {
            final Preference oldDependency = findPreferenceInHierarchy(mDependencyKey);
    if(oldDependency != null)            
            {
                oldDependency.unregisterDependent(this);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (mDependencyKey != null) {
            //final Preference oldDependency = findPreferenceInHierarchy(mDependencyKey);
            //if (oldDependency != null) {
                //oldDependency.unregisterDependent(this);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.523 -0400", hash_original_method = "913C05EFD2CE9AD9CE3BED6394A14862", hash_generated_method = "71DFC6D957EF50B07772F7B94B6551DC")
    protected Preference findPreferenceInHierarchy(String key) {
        addTaint(key.getTaint());
    if(TextUtils.isEmpty(key) || mPreferenceManager == null)        
        {
Preference var540C13E9E156B687226421B24F2DF178_195227353 =             null;
            var540C13E9E156B687226421B24F2DF178_195227353.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_195227353;
        } //End block
Preference var3F9904390C47A44ACE8B6D395680E8CD_1885635595 =         mPreferenceManager.findPreference(key);
        var3F9904390C47A44ACE8B6D395680E8CD_1885635595.addTaint(taint);
        return var3F9904390C47A44ACE8B6D395680E8CD_1885635595;
        // ---------- Original Method ----------
        //if (TextUtils.isEmpty(key) || mPreferenceManager == null) {
            //return null;
        //}
        //return mPreferenceManager.findPreference(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.524 -0400", hash_original_method = "528DD85662997ACAED3BC519F97454B8", hash_generated_method = "BE6AE736963F5DA69F515FFFAFA7C007")
    private void registerDependent(Preference dependent) {
        addTaint(dependent.getTaint());
    if(mDependents == null)        
        {
            mDependents = new ArrayList<Preference>();
        } //End block
        mDependents.add(dependent);
        dependent.onDependencyChanged(this, shouldDisableDependents());
        // ---------- Original Method ----------
        //if (mDependents == null) {
            //mDependents = new ArrayList<Preference>();
        //}
        //mDependents.add(dependent);
        //dependent.onDependencyChanged(this, shouldDisableDependents());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.524 -0400", hash_original_method = "9028FF718331F8BA1AAB10BD4FAE315E", hash_generated_method = "5378EC508EA2CBB41E2F17650C88EAA1")
    private void unregisterDependent(Preference dependent) {
        addTaint(dependent.getTaint());
    if(mDependents != null)        
        {
            mDependents.remove(dependent);
        } //End block
        // ---------- Original Method ----------
        //if (mDependents != null) {
            //mDependents.remove(dependent);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.524 -0400", hash_original_method = "02C347ADE8272FB6E630575816981A99", hash_generated_method = "9AAF9FC6DA760B0649DC29F2DD17AD04")
    public void notifyDependencyChange(boolean disableDependents) {
        addTaint(disableDependents);
        final List<Preference> dependents = mDependents;
    if(dependents == null)        
        {
            return;
        } //End block
        final int dependentsCount = dependents.size();
for(int i = 0;i < dependentsCount;i++)
        {
            dependents.get(i).onDependencyChanged(this, disableDependents);
        } //End block
        // ---------- Original Method ----------
        //final List<Preference> dependents = mDependents;
        //if (dependents == null) {
            //return;
        //}
        //final int dependentsCount = dependents.size();
        //for (int i = 0; i < dependentsCount; i++) {
            //dependents.get(i).onDependencyChanged(this, disableDependents);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.524 -0400", hash_original_method = "E3DDA7BA2220D3A5C80FED1DB4754CB9", hash_generated_method = "715B5013B5C8CC36761DF918194DF910")
    public void onDependencyChanged(Preference dependency, boolean disableDependent) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(dependency.getTaint());
    if(mDependencyMet == disableDependent)        
        {
            mDependencyMet = !disableDependent;
            notifyDependencyChange(shouldDisableDependents());
            notifyChanged();
        } //End block
        // ---------- Original Method ----------
        //if (mDependencyMet == disableDependent) {
            //mDependencyMet = !disableDependent;
            //notifyDependencyChange(shouldDisableDependents());
            //notifyChanged();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.524 -0400", hash_original_method = "88055BCA041292961DE741A16807A2A3", hash_generated_method = "1B14E1FCB7590C6F11294FA01BA3A994")
    public boolean shouldDisableDependents() {
        boolean var0DD7B2AE5E9D8B4B6F00EFC648BAA595_1680283033 = (!isEnabled());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_188500082 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_188500082;
        // ---------- Original Method ----------
        //return !isEnabled();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.524 -0400", hash_original_method = "FBFB05D545147227A8E2F6FCFC356242", hash_generated_method = "AA29AA179C0235E458D9FB109B1C7DAA")
    public void setDependency(String dependencyKey) {
        unregisterDependency();
        mDependencyKey = dependencyKey;
        registerDependency();
        // ---------- Original Method ----------
        //unregisterDependency();
        //mDependencyKey = dependencyKey;
        //registerDependency();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.524 -0400", hash_original_method = "664EA11E01CF3C90DB639CBF1F232407", hash_generated_method = "6ABAF2AEED1F995B38DD2A0029468DD0")
    public String getDependency() {
String varAA01AFCCA0F4C7780E180B3A36010E30_1522062358 =         mDependencyKey;
        varAA01AFCCA0F4C7780E180B3A36010E30_1522062358.addTaint(taint);
        return varAA01AFCCA0F4C7780E180B3A36010E30_1522062358;
        // ---------- Original Method ----------
        //return mDependencyKey;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.524 -0400", hash_original_method = "590B71B1265EC6EEA43053FD50985818", hash_generated_method = "14FE589E8685D8807F769025D0914FFE")
    protected void onPrepareForRemoval() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        unregisterDependency();
        // ---------- Original Method ----------
        //unregisterDependency();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.525 -0400", hash_original_method = "EC5991F73564EC767E73B865F0A17074", hash_generated_method = "2766AECCE7BBCD026046B542095917DF")
    public void setDefaultValue(Object defaultValue) {
        mDefaultValue = defaultValue;
        // ---------- Original Method ----------
        //mDefaultValue = defaultValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.525 -0400", hash_original_method = "0CC9C8053B2B40671F6785C5B066E9AB", hash_generated_method = "E53BC9B32D62F09EB903381F0FF0746E")
    private void dispatchSetInitialValue() {
        final boolean shouldPersist = shouldPersist();
    if(!shouldPersist || !getSharedPreferences().contains(mKey))        
        {
    if(mDefaultValue != null)            
            {
                onSetInitialValue(false, mDefaultValue);
            } //End block
        } //End block
        else
        {
            onSetInitialValue(true, null);
        } //End block
        // ---------- Original Method ----------
        //final boolean shouldPersist = shouldPersist();
        //if (!shouldPersist || !getSharedPreferences().contains(mKey)) {
            //if (mDefaultValue != null) {
                //onSetInitialValue(false, mDefaultValue);
            //}
        //} else {
            //onSetInitialValue(true, null);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.525 -0400", hash_original_method = "8C28678F9AE41A1BF1FA484A48C7C6F8", hash_generated_method = "67328919D55CB90D19CFCA360EB7C376")
    protected void onSetInitialValue(boolean restorePersistedValue, Object defaultValue) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(defaultValue.getTaint());
        addTaint(restorePersistedValue);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.525 -0400", hash_original_method = "22CEE8BE8E503CA7A500DF872E2100EC", hash_generated_method = "3A3824EEA217C0AF1BC1154CE1860920")
    private void tryCommit(SharedPreferences.Editor editor) {
        addTaint(editor.getTaint());
    if(mPreferenceManager.shouldCommit())        
        {
            try 
            {
                editor.apply();
            } //End block
            catch (AbstractMethodError unused)
            {
                editor.commit();
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (mPreferenceManager.shouldCommit()) {
            //try {
                //editor.apply();
            //} catch (AbstractMethodError unused) {
                //editor.commit();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.525 -0400", hash_original_method = "386F50F42D6EB5DC2DA2887FAD5D9C7B", hash_generated_method = "33FD07CC4387FA39736EEEA6479405A4")
    protected boolean persistString(String value) {
        addTaint(value.getTaint());
    if(shouldPersist())        
        {
    if(value == getPersistedString(null))            
            {
                boolean varB326B5062B2F0E69046810717534CB09_417992464 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2029891340 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_2029891340;
            } //End block
            SharedPreferences.Editor editor = mPreferenceManager.getEditor();
            editor.putString(mKey, value);
            tryCommit(editor);
            boolean varB326B5062B2F0E69046810717534CB09_1763545432 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1539823205 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1539823205;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1143406746 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1992293169 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1992293169;
        // ---------- Original Method ----------
        //if (shouldPersist()) {
            //if (value == getPersistedString(null)) {
                //return true;
            //}
            //SharedPreferences.Editor editor = mPreferenceManager.getEditor();
            //editor.putString(mKey, value);
            //tryCommit(editor);
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.525 -0400", hash_original_method = "5E73C8E580A094A1DF5E2EFDD3570FC9", hash_generated_method = "76FAC1B7DF3B0EE307198C22FB8CD2EC")
    protected String getPersistedString(String defaultReturnValue) {
        addTaint(defaultReturnValue.getTaint());
    if(!shouldPersist())        
        {
String var5093ACA8CA1D918F3B8A2692E41ABFFE_865041410 =             defaultReturnValue;
            var5093ACA8CA1D918F3B8A2692E41ABFFE_865041410.addTaint(taint);
            return var5093ACA8CA1D918F3B8A2692E41ABFFE_865041410;
        } //End block
String varF2C0EE3A8570C65E9C5BFFB94419E76D_332216709 =         mPreferenceManager.getSharedPreferences().getString(mKey, defaultReturnValue);
        varF2C0EE3A8570C65E9C5BFFB94419E76D_332216709.addTaint(taint);
        return varF2C0EE3A8570C65E9C5BFFB94419E76D_332216709;
        // ---------- Original Method ----------
        //if (!shouldPersist()) {
            //return defaultReturnValue;
        //}
        //return mPreferenceManager.getSharedPreferences().getString(mKey, defaultReturnValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.526 -0400", hash_original_method = "48F776762148447BA8C6A8C97BA6FE15", hash_generated_method = "053115116310FBA7136649A3B99E7C3F")
    protected boolean persistStringSet(Set<String> values) {
        addTaint(values.getTaint());
    if(shouldPersist())        
        {
    if(values.equals(getPersistedStringSet(null)))            
            {
                boolean varB326B5062B2F0E69046810717534CB09_1388307821 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1494069514 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1494069514;
            } //End block
            SharedPreferences.Editor editor = mPreferenceManager.getEditor();
            editor.putStringSet(mKey, values);
            tryCommit(editor);
            boolean varB326B5062B2F0E69046810717534CB09_1194798256 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1652032794 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1652032794;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1064237438 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1067661662 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1067661662;
        // ---------- Original Method ----------
        //if (shouldPersist()) {
            //if (values.equals(getPersistedStringSet(null))) {
                //return true;
            //}
            //SharedPreferences.Editor editor = mPreferenceManager.getEditor();
            //editor.putStringSet(mKey, values);
            //tryCommit(editor);
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.526 -0400", hash_original_method = "D996103FD4641487F9C96461E983EA55", hash_generated_method = "DE201070489EBE37469A539DB2A24985")
    protected Set<String> getPersistedStringSet(Set<String> defaultReturnValue) {
        addTaint(defaultReturnValue.getTaint());
    if(!shouldPersist())        
        {
Set<String> var5093ACA8CA1D918F3B8A2692E41ABFFE_27756259 =             defaultReturnValue;
            var5093ACA8CA1D918F3B8A2692E41ABFFE_27756259.addTaint(taint);
            return var5093ACA8CA1D918F3B8A2692E41ABFFE_27756259;
        } //End block
Set<String> var2F0249972689681F84E134FA46F16F2E_1591847485 =         mPreferenceManager.getSharedPreferences().getStringSet(mKey, defaultReturnValue);
        var2F0249972689681F84E134FA46F16F2E_1591847485.addTaint(taint);
        return var2F0249972689681F84E134FA46F16F2E_1591847485;
        // ---------- Original Method ----------
        //if (!shouldPersist()) {
            //return defaultReturnValue;
        //}
        //return mPreferenceManager.getSharedPreferences().getStringSet(mKey, defaultReturnValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.526 -0400", hash_original_method = "EDA708B947224EBF19ED1E56671C9A01", hash_generated_method = "D50CE3D3D3E434AC5E80F32E13B53E24")
    protected boolean persistInt(int value) {
        addTaint(value);
    if(shouldPersist())        
        {
    if(value == getPersistedInt(~value))            
            {
                boolean varB326B5062B2F0E69046810717534CB09_1064539731 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_569683763 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_569683763;
            } //End block
            SharedPreferences.Editor editor = mPreferenceManager.getEditor();
            editor.putInt(mKey, value);
            tryCommit(editor);
            boolean varB326B5062B2F0E69046810717534CB09_822445957 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1972251500 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1972251500;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_39905088 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2057442188 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2057442188;
        // ---------- Original Method ----------
        //if (shouldPersist()) {
            //if (value == getPersistedInt(~value)) {
                //return true;
            //}
            //SharedPreferences.Editor editor = mPreferenceManager.getEditor();
            //editor.putInt(mKey, value);
            //tryCommit(editor);
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.526 -0400", hash_original_method = "7BDEA34D831595E2EEF9485CF72F7029", hash_generated_method = "200DAECDCB7D6153D959F5796C52D296")
    protected int getPersistedInt(int defaultReturnValue) {
        addTaint(defaultReturnValue);
    if(!shouldPersist())        
        {
            int var8034FDFC49632927AA93303B21884306_1183172833 = (defaultReturnValue);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_789821216 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_789821216;
        } //End block
        int var27D64D2A4421ACCFD6EC8C8682C7A53A_207897036 = (mPreferenceManager.getSharedPreferences().getInt(mKey, defaultReturnValue));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2032380067 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2032380067;
        // ---------- Original Method ----------
        //if (!shouldPersist()) {
            //return defaultReturnValue;
        //}
        //return mPreferenceManager.getSharedPreferences().getInt(mKey, defaultReturnValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.526 -0400", hash_original_method = "554687CB7FDF3E22A2095D4942A8012F", hash_generated_method = "8F8321296C4BF49A93C5412787283C8C")
    protected boolean persistFloat(float value) {
        addTaint(value);
    if(shouldPersist())        
        {
    if(value == getPersistedFloat(Float.NaN))            
            {
                boolean varB326B5062B2F0E69046810717534CB09_415508228 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_890701663 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_890701663;
            } //End block
            SharedPreferences.Editor editor = mPreferenceManager.getEditor();
            editor.putFloat(mKey, value);
            tryCommit(editor);
            boolean varB326B5062B2F0E69046810717534CB09_815549807 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1701143505 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1701143505;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1283081683 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_633064187 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_633064187;
        // ---------- Original Method ----------
        //if (shouldPersist()) {
            //if (value == getPersistedFloat(Float.NaN)) {
                //return true;
            //}
            //SharedPreferences.Editor editor = mPreferenceManager.getEditor();
            //editor.putFloat(mKey, value);
            //tryCommit(editor);
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.527 -0400", hash_original_method = "AB28180DBEC7B1C710871982C247343B", hash_generated_method = "73F64D8295A664D75A7EA4B76A59322C")
    protected float getPersistedFloat(float defaultReturnValue) {
        addTaint(defaultReturnValue);
    if(!shouldPersist())        
        {
            float var8034FDFC49632927AA93303B21884306_1752678144 = (defaultReturnValue);
                        float var546ADE640B6EDFBC8A086EF31347E768_259948653 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_259948653;
        } //End block
        float var6D813BCB042C3ADDCAD3BB2C23BBBD47_355654889 = (mPreferenceManager.getSharedPreferences().getFloat(mKey, defaultReturnValue));
                float var546ADE640B6EDFBC8A086EF31347E768_1960091990 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1960091990;
        // ---------- Original Method ----------
        //if (!shouldPersist()) {
            //return defaultReturnValue;
        //}
        //return mPreferenceManager.getSharedPreferences().getFloat(mKey, defaultReturnValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.527 -0400", hash_original_method = "C10CC879E3FA9306B83F34EDB87FCEA5", hash_generated_method = "64AF39E00E4324BE5E2D0F28A50ACAE0")
    protected boolean persistLong(long value) {
        addTaint(value);
    if(shouldPersist())        
        {
    if(value == getPersistedLong(~value))            
            {
                boolean varB326B5062B2F0E69046810717534CB09_197954554 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1032714082 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1032714082;
            } //End block
            SharedPreferences.Editor editor = mPreferenceManager.getEditor();
            editor.putLong(mKey, value);
            tryCommit(editor);
            boolean varB326B5062B2F0E69046810717534CB09_668441294 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1614912204 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1614912204;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1253916066 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1323992940 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1323992940;
        // ---------- Original Method ----------
        //if (shouldPersist()) {
            //if (value == getPersistedLong(~value)) {
                //return true;
            //}
            //SharedPreferences.Editor editor = mPreferenceManager.getEditor();
            //editor.putLong(mKey, value);
            //tryCommit(editor);
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.527 -0400", hash_original_method = "88751F99C7941FFB817628D8E528076A", hash_generated_method = "42B22B805DAF2B92A127C8B98D9A86EE")
    protected long getPersistedLong(long defaultReturnValue) {
        addTaint(defaultReturnValue);
    if(!shouldPersist())        
        {
            long var8034FDFC49632927AA93303B21884306_95714232 = (defaultReturnValue);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1722725883 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1722725883;
        } //End block
        long var2E7852F2545EABBCC210F8693E5F7DEF_1964764738 = (mPreferenceManager.getSharedPreferences().getLong(mKey, defaultReturnValue));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_294187746 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_294187746;
        // ---------- Original Method ----------
        //if (!shouldPersist()) {
            //return defaultReturnValue;
        //}
        //return mPreferenceManager.getSharedPreferences().getLong(mKey, defaultReturnValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.527 -0400", hash_original_method = "D20BDAFE65F5D54A08F0A9EE0DEAC992", hash_generated_method = "CB0468D49E38BFA8F7E757F020E07C1D")
    protected boolean persistBoolean(boolean value) {
        addTaint(value);
    if(shouldPersist())        
        {
    if(value == getPersistedBoolean(!value))            
            {
                boolean varB326B5062B2F0E69046810717534CB09_676811153 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_119718885 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_119718885;
            } //End block
            SharedPreferences.Editor editor = mPreferenceManager.getEditor();
            editor.putBoolean(mKey, value);
            tryCommit(editor);
            boolean varB326B5062B2F0E69046810717534CB09_2054622847 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_319238225 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_319238225;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1969270507 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1354647890 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1354647890;
        // ---------- Original Method ----------
        //if (shouldPersist()) {
            //if (value == getPersistedBoolean(!value)) {
                //return true;
            //}
            //SharedPreferences.Editor editor = mPreferenceManager.getEditor();
            //editor.putBoolean(mKey, value);
            //tryCommit(editor);
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.528 -0400", hash_original_method = "8F28A5D05D1E365FD2C0E61AA71BE94D", hash_generated_method = "4126B6DC3AA3F3B4E5265B866E82A6CA")
    protected boolean getPersistedBoolean(boolean defaultReturnValue) {
        addTaint(defaultReturnValue);
    if(!shouldPersist())        
        {
            boolean var8034FDFC49632927AA93303B21884306_92805235 = (defaultReturnValue);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_832418168 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_832418168;
        } //End block
        boolean varC11C3A43132FBF95A484109FDF91C69B_128237600 = (mPreferenceManager.getSharedPreferences().getBoolean(mKey, defaultReturnValue));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_222103110 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_222103110;
        // ---------- Original Method ----------
        //if (!shouldPersist()) {
            //return defaultReturnValue;
        //}
        //return mPreferenceManager.getSharedPreferences().getBoolean(mKey, defaultReturnValue);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.528 -0400", hash_original_method = "79DC631A87B79C35E44BC11E3C275CE7", hash_generated_method = "AE67C28BB27517D8D45044080493770C")
     boolean hasSpecifiedLayout() {
        boolean varD86943AD76AEA15A81EB64F375E0E224_656575487 = (mHasSpecifiedLayout);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1445059470 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1445059470;
        // ---------- Original Method ----------
        //return mHasSpecifiedLayout;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.528 -0400", hash_original_method = "F82B18888AE588251FAAB1FF7696A001", hash_generated_method = "D6226E237A7481BD41CF14E13A84A731")
    @Override
    public String toString() {
String var01E383B071399C21051F6051B8C4F407_968978533 =         getFilterableStringBuilder().toString();
        var01E383B071399C21051F6051B8C4F407_968978533.addTaint(taint);
        return var01E383B071399C21051F6051B8C4F407_968978533;
        // ---------- Original Method ----------
        //return getFilterableStringBuilder().toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.528 -0400", hash_original_method = "7FA40EC09188F6F1BEA3B1B94241EA4A", hash_generated_method = "A7D7197232B53C79835260E80E045D9D")
     StringBuilder getFilterableStringBuilder() {
        StringBuilder sb = new StringBuilder();
        CharSequence title = getTitle();
    if(!TextUtils.isEmpty(title))        
        {
            sb.append(title).append(' ');
        } //End block
        CharSequence summary = getSummary();
    if(!TextUtils.isEmpty(summary))        
        {
            sb.append(summary).append(' ');
        } //End block
    if(sb.length() > 0)        
        {
            sb.setLength(sb.length() - 1);
        } //End block
StringBuilder var8C7F5CF7BA5191ABF78E376D65A0039D_1199204084 =         sb;
        var8C7F5CF7BA5191ABF78E376D65A0039D_1199204084.addTaint(taint);
        return var8C7F5CF7BA5191ABF78E376D65A0039D_1199204084;
        // ---------- Original Method ----------
        //StringBuilder sb = new StringBuilder();
        //CharSequence title = getTitle();
        //if (!TextUtils.isEmpty(title)) {
            //sb.append(title).append(' ');
        //}
        //CharSequence summary = getSummary();
        //if (!TextUtils.isEmpty(summary)) {
            //sb.append(summary).append(' ');
        //}
        //if (sb.length() > 0) {
            //sb.setLength(sb.length() - 1);
        //}
        //return sb;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.528 -0400", hash_original_method = "363F8E8F58511FB925A751666AB900BD", hash_generated_method = "8084A64D57F71EF7996781F33F8407A2")
    public void saveHierarchyState(Bundle container) {
        addTaint(container.getTaint());
        dispatchSaveInstanceState(container);
        // ---------- Original Method ----------
        //dispatchSaveInstanceState(container);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.528 -0400", hash_original_method = "1B94F5D63E3EC8B47F4D750B8B09EC88", hash_generated_method = "2F2AFA9ED5A6F78FA498BC42147F8205")
     void dispatchSaveInstanceState(Bundle container) {
        addTaint(container.getTaint());
    if(hasKey())        
        {
            mBaseMethodCalled = false;
            Parcelable state = onSaveInstanceState();
    if(!mBaseMethodCalled)            
            {
                IllegalStateException var3AC6518B2E70CB86B09E15593A1F4FC9_1263356964 = new IllegalStateException(
                        "Derived class did not call super.onSaveInstanceState()");
                var3AC6518B2E70CB86B09E15593A1F4FC9_1263356964.addTaint(taint);
                throw var3AC6518B2E70CB86B09E15593A1F4FC9_1263356964;
            } //End block
    if(state != null)            
            {
                container.putParcelable(mKey, state);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (hasKey()) {
            //mBaseMethodCalled = false;
            //Parcelable state = onSaveInstanceState();
            //if (!mBaseMethodCalled) {
                //throw new IllegalStateException(
                        //"Derived class did not call super.onSaveInstanceState()");
            //}
            //if (state != null) {
                //container.putParcelable(mKey, state);
            //}
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.528 -0400", hash_original_method = "9DD945A60796B8A8FF01F94A77988BE6", hash_generated_method = "91A3E3517FC211635DC049ADCE921F51")
    protected Parcelable onSaveInstanceState() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mBaseMethodCalled = true;
Parcelable var811282300C831A28E3AEFC5EE2A36FB6_592703953 =         BaseSavedState.EMPTY_STATE;
        var811282300C831A28E3AEFC5EE2A36FB6_592703953.addTaint(taint);
        return var811282300C831A28E3AEFC5EE2A36FB6_592703953;
        // ---------- Original Method ----------
        //mBaseMethodCalled = true;
        //return BaseSavedState.EMPTY_STATE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.529 -0400", hash_original_method = "D5A51A6B2B5A2D76F277782756F6ADE6", hash_generated_method = "681FC51259F01C6CB9B7A44A30005E3D")
    public void restoreHierarchyState(Bundle container) {
        addTaint(container.getTaint());
        dispatchRestoreInstanceState(container);
        // ---------- Original Method ----------
        //dispatchRestoreInstanceState(container);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.529 -0400", hash_original_method = "18F16B162844FF15C24BE293B1033BC4", hash_generated_method = "49B12E03EF96725478629634B405D847")
     void dispatchRestoreInstanceState(Bundle container) {
        addTaint(container.getTaint());
    if(hasKey())        
        {
            Parcelable state = container.getParcelable(mKey);
    if(state != null)            
            {
                mBaseMethodCalled = false;
                onRestoreInstanceState(state);
    if(!mBaseMethodCalled)                
                {
                    IllegalStateException var041490C7009C0A495ADBC57E4BE325FC_1945708586 = new IllegalStateException(
                            "Derived class did not call super.onRestoreInstanceState()");
                    var041490C7009C0A495ADBC57E4BE325FC_1945708586.addTaint(taint);
                    throw var041490C7009C0A495ADBC57E4BE325FC_1945708586;
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (hasKey()) {
            //Parcelable state = container.getParcelable(mKey);
            //if (state != null) {
                //mBaseMethodCalled = false;
                //onRestoreInstanceState(state);
                //if (!mBaseMethodCalled) {
                    //throw new IllegalStateException(
                            //"Derived class did not call super.onRestoreInstanceState()");
                //}
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.530 -0400", hash_original_method = "18B537C81357A7563BC62FF4E045FAEF", hash_generated_method = "9C285D144E7251EA618876B4AAB72BB1")
    protected void onRestoreInstanceState(Parcelable state) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(state.getTaint());
        mBaseMethodCalled = true;
    if(state != BaseSavedState.EMPTY_STATE && state != null)        
        {
            IllegalArgumentException var7899D4784B7026C3D7BBCAC5D53EFDE9_2147122496 = new IllegalArgumentException("Wrong state class -- expecting Preference State");
            var7899D4784B7026C3D7BBCAC5D53EFDE9_2147122496.addTaint(taint);
            throw var7899D4784B7026C3D7BBCAC5D53EFDE9_2147122496;
        } //End block
        // ---------- Original Method ----------
        //mBaseMethodCalled = true;
        //if (state != BaseSavedState.EMPTY_STATE && state != null) {
            //throw new IllegalArgumentException("Wrong state class -- expecting Preference State");
        //}
    }

    
    public static class BaseSavedState extends AbsSavedState {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.530 -0400", hash_original_method = "0710B1BECA4AE2A64DE9C58BFD4A1161", hash_generated_method = "EE939DE64E4E13C6649033F638632686")
        public  BaseSavedState(Parcel source) {
            super(source);
            addTaint(source.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.530 -0400", hash_original_method = "C61013DFD638DC996F3EF4CC52F40C74", hash_generated_method = "E01D93B6DF9621DF15B2FA6FE9F6F642")
        public  BaseSavedState(Parcelable superState) {
            super(superState);
            addTaint(superState.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.531 -0400", hash_original_field = "F69D27D6C01716FC1482B26F47E53A23", hash_generated_field = "1603EC57FF7A24DE0B9CE75D44794F2A")

        public static final Parcelable.Creator<BaseSavedState> CREATOR =
                new Parcelable.Creator<BaseSavedState>() {
            public BaseSavedState createFromParcel(Parcel in) {
                return new BaseSavedState(in);
            }

            public BaseSavedState[] newArray(int size) {
                return new BaseSavedState[size];
            }
        };
        // orphaned legacy method
        public BaseSavedState createFromParcel(Parcel in) {
                return new BaseSavedState(in);
            }
        
        // orphaned legacy method
        public BaseSavedState[] newArray(int size) {
                return new BaseSavedState[size];
            }
        
    }


    
    public interface OnPreferenceChangeListener {
        
        boolean onPreferenceChange(Preference preference, Object newValue);
    }
    
    public interface OnPreferenceClickListener {
        
        boolean onPreferenceClick(Preference preference);
    }
    
    interface OnPreferenceChangeInternalListener {
        
        void onPreferenceChange(Preference preference);
        
        
        void onPreferenceHierarchyChange(Preference preference);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.531 -0400", hash_original_field = "FB0E8DE194A65EAF0D6B4D5E48723B17", hash_generated_field = "2E41574F494D78468755ADDE8E4C30A4")

    public static final int DEFAULT_ORDER = Integer.MAX_VALUE;
}

