package android.preference;

// Droidsafe Imports
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
import android.widget.TextView;

import com.android.internal.util.CharSequences;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class Preference implements Comparable<Preference>, OnDependencyChangeListener {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.485 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.485 -0400", hash_original_field = "D1487CA8252F4AA0A95324AB4DDD5316", hash_generated_field = "13262EB3751B753EEB3302EF75D8B1E5")

    private PreferenceManager mPreferenceManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.485 -0400", hash_original_field = "6AC7F06B6413A1BE9C136DC7DF0D2B60", hash_generated_field = "CF2A5FB7C7BB55BD451D113BD690151D")

    private long mId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.485 -0400", hash_original_field = "3213C247B4603DED047FFE75B63B4B6C", hash_generated_field = "B2CD75E86D570A2CCE7E2BC973BD4ACD")

    private OnPreferenceChangeListener mOnChangeListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.485 -0400", hash_original_field = "AA894545820F13D1E6598CEEF475CCC9", hash_generated_field = "03339AEC23A0F6C8C8113E6F7DC55FB5")

    private OnPreferenceClickListener mOnClickListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.485 -0400", hash_original_field = "759FE618587C2AB1184A3DF4077B5BD4", hash_generated_field = "4DBBABE4B5343924D877A673E4358521")

    private int mOrder = DEFAULT_ORDER;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.485 -0400", hash_original_field = "4B03BBB3AD21DBD17B2B689923FCF1F6", hash_generated_field = "ECAB18871B55104BACD4283C12B1074D")

    private CharSequence mTitle;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.485 -0400", hash_original_field = "B4A04CB1D37B3364DF264481CEA8B25E", hash_generated_field = "0BEE4780876F1B970FEA6B12663CC1C4")

    private int mTitleRes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.485 -0400", hash_original_field = "364E1929FED648A0A411C548B6A6CE28", hash_generated_field = "89C28E4357F1254876CE9020798E5A89")

    private CharSequence mSummary;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.485 -0400", hash_original_field = "0F522D56B85B081BF02F698ECADD7AFE", hash_generated_field = "7DAEA4581257F07E76CD939CD24A2FD7")

    private int mIconResId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.485 -0400", hash_original_field = "1A265556E59DF15CAEC4E55FB61E68C7", hash_generated_field = "FFB83F2A7C9A877B036AAEB7C21DDF6E")

    private Drawable mIcon;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.485 -0400", hash_original_field = "7E690C9CC141370A5EC6E7A98DC6FF62", hash_generated_field = "C36B21320914DA8259201FF07A2C068D")

    private String mKey;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.485 -0400", hash_original_field = "B1135DD88C82BCDD4DCD8391BCD99883", hash_generated_field = "5782C825DA3F61D408DF2DCA63E7F54A")

    private Intent mIntent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.485 -0400", hash_original_field = "3FD10A4D9B0E4F081E637AB2E170510C", hash_generated_field = "F74F34FFBA0EE92FA7BFBACA55B63FEF")

    private String mFragment;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.486 -0400", hash_original_field = "45F5DC4EA541ED660CFEDA0032CA356C", hash_generated_field = "5596C79D633F3A9F64294D3BD6D43156")

    private Bundle mExtras;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.486 -0400", hash_original_field = "71AB1146E1CEE92AB74D832DEFFE135F", hash_generated_field = "8BBE5745FA7C6470C8EA4F0513877CD6")

    private boolean mEnabled = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.486 -0400", hash_original_field = "D2831E7836D599A678D483B6294DDC44", hash_generated_field = "1A3F26BEC59143A828A7366C664C2B34")

    private boolean mSelectable = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.486 -0400", hash_original_field = "DF5D85B683298771811AC0DA28EAA613", hash_generated_field = "24780C50494002A4AF74BE6D462BE687")

    private boolean mRequiresKey;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.486 -0400", hash_original_field = "0250DF5C7FFD5EED92782A49F6405CFF", hash_generated_field = "27082D50DFDAA9191800D07F3AF15268")

    private boolean mPersistent = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.486 -0400", hash_original_field = "A397CDE94E1B6D2DEDC3A6F7D910612B", hash_generated_field = "B26344E1F3EABE836E6724009E62D614")

    private String mDependencyKey;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.486 -0400", hash_original_field = "3D9F826E2A85D6A96D8493A9F2E57CAC", hash_generated_field = "42900AC295F63E9B792D05C2A7334252")

    private Object mDefaultValue;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.486 -0400", hash_original_field = "212F572493A222F913C2F8AB8182CA71", hash_generated_field = "BEDE89D1CA2E56235E886F0A2A60132A")

    private boolean mDependencyMet = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.486 -0400", hash_original_field = "39B855F662D38B52B3F468037B6033C8", hash_generated_field = "76B9F6CF747E54F39C22CAC52291B4CD")

    private boolean mShouldDisableView = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.486 -0400", hash_original_field = "B5C7F1291490ADFCCBE98EF4AC5DC599", hash_generated_field = "2628AFC967B4980D202AAA14C9F08E6C")

    private int mLayoutResId = com.android.internal.R.layout.preference;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.486 -0400", hash_original_field = "68A3A909EA046E49435A797A37664E61", hash_generated_field = "03CE89F32EE4B5097448BE77263408B4")

    private int mWidgetLayoutResId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.486 -0400", hash_original_field = "42DF999BF001FDB041B1E1ECE0658C31", hash_generated_field = "37581EC71ABDA9DF6D14233378E40DCE")

    private boolean mHasSpecifiedLayout = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.486 -0400", hash_original_field = "9B3DD33B99719CE65C53FA6749E2AD69", hash_generated_field = "AC60A661DDD5C1ADBF7F01BD463F7E24")

    private OnPreferenceChangeInternalListener mListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.486 -0400", hash_original_field = "698EF7B44319FC69CFD2FC82A890F638", hash_generated_field = "B4077C41DC030C953102067792AA61E0")

    private List<Preference> mDependents;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.486 -0400", hash_original_field = "D87E96F5609D6847DCF3861262CE4BE7", hash_generated_field = "5E4C3692572C298E63D6463802841D4E")

    private boolean mBaseMethodCalled;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.490 -0400", hash_original_method = "9CEB9C34CAA8ECAB230B50A0542D61B3", hash_generated_method = "74D1F627E9A957F43B8CE427BAE8AFEA")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.491 -0400", hash_original_method = "48043D3D24F48A6FD06B47A9624983D0", hash_generated_method = "BF1985E86638FE5C9EDFA863C08F2728")
    public  Preference(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.preferenceStyle);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.491 -0400", hash_original_method = "B50FF766B3A35A641C8DC6BF5214AE70", hash_generated_method = "946D92E4443D83AFE407CB73CBDDE443")
    public  Preference(Context context) {
        this(context, null);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.491 -0400", hash_original_method = "75C2469AD4E7F0A9F01D294D0E9B9A83", hash_generated_method = "C5205954021C861C31E49B1F8FBE8977")
    protected Object onGetDefaultValue(TypedArray a, int index) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(index);
        addTaint(a.getTaint());
Object var540C13E9E156B687226421B24F2DF178_826707421 =         null;
        var540C13E9E156B687226421B24F2DF178_826707421.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_826707421;
        // ---------- Original Method ----------
        //return null;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.492 -0400", hash_original_method = "BB18D5EDF68F7EDDF74E48FAF30F475E", hash_generated_method = "36AB7FE2A4C2C0EF3565BBD54597E3F4")
    public void setIntent(Intent intent) {
        mIntent = intent;
        // ---------- Original Method ----------
        //mIntent = intent;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.492 -0400", hash_original_method = "AD027B7B58A4A2F151CC138FB7B23244", hash_generated_method = "92674AA3C236DCDADAB0183DF3D5533F")
    public Intent getIntent() {
Intent var4DCF8E3D75AE0B94CDA94656DCE16BCE_1626468597 =         mIntent;
        var4DCF8E3D75AE0B94CDA94656DCE16BCE_1626468597.addTaint(taint);
        return var4DCF8E3D75AE0B94CDA94656DCE16BCE_1626468597;
        // ---------- Original Method ----------
        //return mIntent;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.492 -0400", hash_original_method = "B84A292EE370DC034681ED1A5B514CE4", hash_generated_method = "918CDAB4381AA56F58F01C803B049B49")
    public void setFragment(String fragment) {
        mFragment = fragment;
        // ---------- Original Method ----------
        //mFragment = fragment;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.492 -0400", hash_original_method = "133D42C98C64EF6757CE3D375E2E1FA7", hash_generated_method = "DE31AE722C5DA0CA9110AEE7F90A6664")
    public String getFragment() {
String var5DA1096D62F21920EA3FC00E046E5678_644652488 =         mFragment;
        var5DA1096D62F21920EA3FC00E046E5678_644652488.addTaint(taint);
        return var5DA1096D62F21920EA3FC00E046E5678_644652488;
        // ---------- Original Method ----------
        //return mFragment;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.493 -0400", hash_original_method = "F77D5C181034415714B081995209DE64", hash_generated_method = "6C4A11CBBAB468826A7086AFA1D14E5A")
    public Bundle getExtras() {
        if(mExtras == null)        
        {
            mExtras = new Bundle();
        } //End block
Bundle var5E49E1FEC958658F846C38CDDBF16A8B_65077723 =         mExtras;
        var5E49E1FEC958658F846C38CDDBF16A8B_65077723.addTaint(taint);
        return var5E49E1FEC958658F846C38CDDBF16A8B_65077723;
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //return mExtras;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.493 -0400", hash_original_method = "06728B07006932C3BCF42D880B54A6CC", hash_generated_method = "5CF0F72D5B3D721BBB66089A82F934F3")
    public Bundle peekExtras() {
Bundle var5E49E1FEC958658F846C38CDDBF16A8B_1924737887 =         mExtras;
        var5E49E1FEC958658F846C38CDDBF16A8B_1924737887.addTaint(taint);
        return var5E49E1FEC958658F846C38CDDBF16A8B_1924737887;
        // ---------- Original Method ----------
        //return mExtras;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.493 -0400", hash_original_method = "528C4C3ACF7780A9B6B960E406A0977A", hash_generated_method = "6AD8664649D6B13651F1D9C8F85F0FB7")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.494 -0400", hash_original_method = "A2555092F113429083F033F36B8E024F", hash_generated_method = "CAA12EA623F1D19E2AF7C8EEADD4DCE5")
    public int getLayoutResource() {
        int varA9F6722A5294E529E32C28918E7CD8EA_100473744 = (mLayoutResId);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1566859590 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1566859590;
        // ---------- Original Method ----------
        //return mLayoutResId;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.494 -0400", hash_original_method = "2204831C4D4DE968C9A72D9D306DDD8C", hash_generated_method = "E2DA80CE19E8A1FC7CFEFC8F33A14866")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.495 -0400", hash_original_method = "6D000A2827FAFE2A1A87DD4A065ACF04", hash_generated_method = "FBF1D4E9D1F60FD8C50F52E7DF6CF8C6")
    public int getWidgetLayoutResource() {
        int var68A3A909EA046E49435A797A37664E61_1780262774 = (mWidgetLayoutResId);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2113292119 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2113292119;
        // ---------- Original Method ----------
        //return mWidgetLayoutResId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.495 -0400", hash_original_method = "10F5B4A945AE227B9B33457223123B2A", hash_generated_method = "9C08DD51D300347A91B7454D6610E96A")
    public View getView(View convertView, ViewGroup parent) {
        addTaint(parent.getTaint());
        addTaint(convertView.getTaint());
        if(convertView == null)        
        {
            convertView = onCreateView(parent);
        } //End block
        onBindView(convertView);
View var78FE9B874BBEC69B62B43EE963245978_1293547976 =         convertView;
        var78FE9B874BBEC69B62B43EE963245978_1293547976.addTaint(taint);
        return var78FE9B874BBEC69B62B43EE963245978_1293547976;
        // ---------- Original Method ----------
        //if (convertView == null) {
            //convertView = onCreateView(parent);
        //}
        //onBindView(convertView);
        //return convertView;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.496 -0400", hash_original_method = "DD0E6DF051F4F0779DD2D5F6BCD064A5", hash_generated_method = "B12DBD354FDB5A554DE78CACCB3F453C")
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
View var6BB281F92ECF603ABC908502047A266C_2056737467 =         layout;
        var6BB281F92ECF603ABC908502047A266C_2056737467.addTaint(taint);
        return var6BB281F92ECF603ABC908502047A266C_2056737467;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.496 -0400", hash_original_method = "D65593443BAE954E876A7311E3E1909A", hash_generated_method = "61596633704456144D753DF3E528A31B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.497 -0400", hash_original_method = "4F80205B57D5838ADEC212DC6CB9E651", hash_generated_method = "F8D88C4E05E7307313CE459E152FFDCC")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.497 -0400", hash_original_method = "84974F9AFFF82527B4C714348BF0B3DB", hash_generated_method = "0D5DC52CA914DC21EA3E6383CFE98F8B")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.498 -0400", hash_original_method = "BE8C43C510B8AF8546FEBBAA3EF0F0B1", hash_generated_method = "3E62D00357BA3448A38097887B4AA6B1")
    public int getOrder() {
        int var6D112D2229BB97D14E6F55D683775A63_209238019 = (mOrder);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1953391417 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1953391417;
        // ---------- Original Method ----------
        //return mOrder;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.498 -0400", hash_original_method = "B4BEC153E73D566AEC40ED844297CB0F", hash_generated_method = "C65D180B3DC531E811671795356294F4")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.499 -0400", hash_original_method = "4E4A93A9A53A92BE0779D6D57BF6863D", hash_generated_method = "6ACAB13F5CD19AE36D59ABBBF68726F7")
    public void setTitle(int titleResId) {
        setTitle(mContext.getString(titleResId));
        mTitleRes = titleResId;
        // ---------- Original Method ----------
        //setTitle(mContext.getString(titleResId));
        //mTitleRes = titleResId;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.499 -0400", hash_original_method = "9778C1A15B3D4EC3FC935EB49323C011", hash_generated_method = "51C24D765128AF5D3D78A022FDCFFDA3")
    public int getTitleRes() {
        int varB4A04CB1D37B3364DF264481CEA8B25E_2087540201 = (mTitleRes);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_110212855 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_110212855;
        // ---------- Original Method ----------
        //return mTitleRes;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.499 -0400", hash_original_method = "7D691BCB64236E7B5AF8F6CB0399C091", hash_generated_method = "DE623AA9ADA4CD942A49FC9C39FF046C")
    public CharSequence getTitle() {
CharSequence var4FE0D95ADE4B4BDFA36D55D8B62A6C49_1366790236 =         mTitle;
        var4FE0D95ADE4B4BDFA36D55D8B62A6C49_1366790236.addTaint(taint);
        return var4FE0D95ADE4B4BDFA36D55D8B62A6C49_1366790236;
        // ---------- Original Method ----------
        //return mTitle;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.500 -0400", hash_original_method = "3511105857431430BED74F970B043B64", hash_generated_method = "7C9AE5CE5DD10893095F055BA231720B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.500 -0400", hash_original_method = "42E5A2AC84ED127F39E187697447AF4F", hash_generated_method = "C5B24FFBB5B7217533EEE4D1981CFE30")
    public void setIcon(int iconResId) {
        mIconResId = iconResId;
        setIcon(mContext.getResources().getDrawable(iconResId));
        // ---------- Original Method ----------
        //mIconResId = iconResId;
        //setIcon(mContext.getResources().getDrawable(iconResId));
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.500 -0400", hash_original_method = "ED78DC4ED6B2C6A65EDA3016CC1C1C4D", hash_generated_method = "24265C311DB8CCC732680288B592CFFC")
    public Drawable getIcon() {
Drawable var664A3A1F0DCFF82F0A8D0B798A32C3B0_949344498 =         mIcon;
        var664A3A1F0DCFF82F0A8D0B798A32C3B0_949344498.addTaint(taint);
        return var664A3A1F0DCFF82F0A8D0B798A32C3B0_949344498;
        // ---------- Original Method ----------
        //return mIcon;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.501 -0400", hash_original_method = "485EE2482F168D23B57BE8096AF663D1", hash_generated_method = "0CBE6CF56DE22914DBEFF703EDDE2D60")
    public CharSequence getSummary() {
CharSequence var695653DA4AD97E07531185C51663AC04_1484381120 =         mSummary;
        var695653DA4AD97E07531185C51663AC04_1484381120.addTaint(taint);
        return var695653DA4AD97E07531185C51663AC04_1484381120;
        // ---------- Original Method ----------
        //return mSummary;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.501 -0400", hash_original_method = "9397E34A85A0111B42F6FFB9A2837DEB", hash_generated_method = "2A19F8C4BB770F91006551E47E0623F6")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.502 -0400", hash_original_method = "7AEFEE5A5E2C81392912FC13D133C130", hash_generated_method = "A11E9B30E86B523A3DF49E93B23AF375")
    public void setSummary(int summaryResId) {
        addTaint(summaryResId);
        setSummary(mContext.getString(summaryResId));
        // ---------- Original Method ----------
        //setSummary(mContext.getString(summaryResId));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.502 -0400", hash_original_method = "86021B1A0572E898D2D9C9D290D998FE", hash_generated_method = "1C5D3AB7080347C2808798BBD16D6959")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.502 -0400", hash_original_method = "1BB77BECC2C1296C251576AD714A96C1", hash_generated_method = "DE1DD6B48918CE1B9285BC3FCFB289B0")
    public boolean isEnabled() {
        boolean varB0998570CEA6BAD6F2EF1169DF51823C_2031094684 = (mEnabled && mDependencyMet);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1741814372 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1741814372;
        // ---------- Original Method ----------
        //return mEnabled && mDependencyMet;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.503 -0400", hash_original_method = "7EEA4953639C86CA9F36ABED9565FC6D", hash_generated_method = "083B2E06D41C235B51280B38C982EBB9")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.503 -0400", hash_original_method = "A1A8E91E60B51F4951583D0866634B48", hash_generated_method = "C00A36AB38E30B02C61788D49FACD08E")
    public boolean isSelectable() {
        boolean varE28FEF967AA6B38EBAD4E8DC579022AD_1464572003 = (mSelectable);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1399198459 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1399198459;
        // ---------- Original Method ----------
        //return mSelectable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.503 -0400", hash_original_method = "97FCA568B4719676F3D4400812EA1F3A", hash_generated_method = "7F12B03326FA27759FCDAC4095D8D9F3")
    public void setShouldDisableView(boolean shouldDisableView) {
        mShouldDisableView = shouldDisableView;
        notifyChanged();
        // ---------- Original Method ----------
        //mShouldDisableView = shouldDisableView;
        //notifyChanged();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.504 -0400", hash_original_method = "465C9050F708FCF1A73506501FE4644E", hash_generated_method = "9E58C410012B87BF2CF836BBCD386ED0")
    public boolean getShouldDisableView() {
        boolean varCCA1923E758DC6F889585D63E097A199_616880515 = (mShouldDisableView);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1704805421 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1704805421;
        // ---------- Original Method ----------
        //return mShouldDisableView;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.504 -0400", hash_original_method = "6AF16C815DE6FE4144432EF99CDC825B", hash_generated_method = "D5B8A7754E7E1B88ED2B1017BC17E331")
     long getId() {
        long var6AC7F06B6413A1BE9C136DC7DF0D2B60_1516612647 = (mId);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_14534933 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_14534933;
        // ---------- Original Method ----------
        //return mId;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.504 -0400", hash_original_method = "DE9BB9E40914727DA5D6E94159FAF3CB", hash_generated_method = "B12F9C4DD7EEB07FF06C6B7E88BC35E4")
    protected void onClick() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.504 -0400", hash_original_method = "46997BE6329912D9EC1174E4CE7CAB04", hash_generated_method = "A0D999C711B71A98E8BAD75F5B963317")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.504 -0400", hash_original_method = "E0CEA0C6ABDC55C32B991C1D155B5E3E", hash_generated_method = "5AB33C86DF0004F92F3AD0576E0F8E31")
    public String getKey() {
String var79CD36FEA8F0B12D4023EF117F6A9A00_1403835241 =         mKey;
        var79CD36FEA8F0B12D4023EF117F6A9A00_1403835241.addTaint(taint);
        return var79CD36FEA8F0B12D4023EF117F6A9A00_1403835241;
        // ---------- Original Method ----------
        //return mKey;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.505 -0400", hash_original_method = "21702F9605A21EAEE85E66B458F985AA", hash_generated_method = "E9D03C2C41A2DB607314B1B22074D176")
     void requireKey() {
        if(mKey == null)        
        {
            IllegalStateException varD993F6B1774DF3DC92662F8B81178C3D_682741761 = new IllegalStateException("Preference does not have a key assigned.");
            varD993F6B1774DF3DC92662F8B81178C3D_682741761.addTaint(taint);
            throw varD993F6B1774DF3DC92662F8B81178C3D_682741761;
        } //End block
        mRequiresKey = true;
        // ---------- Original Method ----------
        //if (mKey == null) {
            //throw new IllegalStateException("Preference does not have a key assigned.");
        //}
        //mRequiresKey = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.505 -0400", hash_original_method = "3BC185E939D8CD84C5733E95D5330A61", hash_generated_method = "01FA7BF5ED93422B25C68B85503CEFDC")
    public boolean hasKey() {
        boolean var8F79712C07771E732CAC515DA1A96F64_1137937172 = (!TextUtils.isEmpty(mKey));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1653081117 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1653081117;
        // ---------- Original Method ----------
        //return !TextUtils.isEmpty(mKey);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.505 -0400", hash_original_method = "45C46AF35C2A296F9912D410933691CF", hash_generated_method = "E32F22D755B3E27BBDF9A8E9AC39535A")
    public boolean isPersistent() {
        boolean varEF7BF975B5B494F57B25EA1F790A52BC_1688559177 = (mPersistent);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_738043269 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_738043269;
        // ---------- Original Method ----------
        //return mPersistent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.505 -0400", hash_original_method = "E7579FEE83F4F133055197D69D72F289", hash_generated_method = "4898C78BF3FA205743BCFEE6B2A8589F")
    protected boolean shouldPersist() {
        boolean varB5A47C688AB00EC6B8B8B3CF3A479AE2_6814665 = (mPreferenceManager != null && isPersistent() && hasKey());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2146613200 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2146613200;
        // ---------- Original Method ----------
        //return mPreferenceManager != null && isPersistent() && hasKey();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.505 -0400", hash_original_method = "9780EA334E29D2930E2D9A0F1CB4087F", hash_generated_method = "C4414A607836682C6B94DC1DA7BB4DF5")
    public void setPersistent(boolean persistent) {
        mPersistent = persistent;
        // ---------- Original Method ----------
        //mPersistent = persistent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.506 -0400", hash_original_method = "4367E5B2EAD1BB8898BD88F610DDAF7D", hash_generated_method = "2D349038CBD104BD2520750145F0CEF2")
    protected boolean callChangeListener(Object newValue) {
        addTaint(newValue.getTaint());
        boolean var892DA48709297D3551A88332C46C6F15_1398136068 = (mOnChangeListener == null ? true : mOnChangeListener.onPreferenceChange(this, newValue));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_347673810 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_347673810;
        // ---------- Original Method ----------
        //return mOnChangeListener == null ? true : mOnChangeListener.onPreferenceChange(this, newValue);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.506 -0400", hash_original_method = "D46636D80B7557AC6195A05902CC638C", hash_generated_method = "7D40D426D5687A76C5D11598A2206435")
    public void setOnPreferenceChangeListener(OnPreferenceChangeListener onPreferenceChangeListener) {
        mOnChangeListener = onPreferenceChangeListener;
        // ---------- Original Method ----------
        //mOnChangeListener = onPreferenceChangeListener;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.506 -0400", hash_original_method = "9CC8E5271070D42EF9628C47033D91A6", hash_generated_method = "A8B000559C98698E56EB796D2FFC0211")
    public OnPreferenceChangeListener getOnPreferenceChangeListener() {
OnPreferenceChangeListener var0219E9A12561FA4B5F91801BE5101351_1142716169 =         mOnChangeListener;
        var0219E9A12561FA4B5F91801BE5101351_1142716169.addTaint(taint);
        return var0219E9A12561FA4B5F91801BE5101351_1142716169;
        // ---------- Original Method ----------
        //return mOnChangeListener;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.507 -0400", hash_original_method = "E8A10745E179E2FA23FF715EAD4A5CB3", hash_generated_method = "1C194BF6887E87978417EF5A65E3F26D")
    public void setOnPreferenceClickListener(OnPreferenceClickListener onPreferenceClickListener) {
        mOnClickListener = onPreferenceClickListener;
        // ---------- Original Method ----------
        //mOnClickListener = onPreferenceClickListener;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.507 -0400", hash_original_method = "55E2C6999F7D889141550F7A68D36827", hash_generated_method = "55760806DAA0EC317399F258E9610450")
    public OnPreferenceClickListener getOnPreferenceClickListener() {
OnPreferenceClickListener var0CF64AAC8E1DF5109CBA8718B93BAC9D_1159954182 =         mOnClickListener;
        var0CF64AAC8E1DF5109CBA8718B93BAC9D_1159954182.addTaint(taint);
        return var0CF64AAC8E1DF5109CBA8718B93BAC9D_1159954182;
        // ---------- Original Method ----------
        //return mOnClickListener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.507 -0400", hash_original_method = "501E66F7BA58D6B4C7BCFDD2200CB13A", hash_generated_method = "4A77AA00224A9F7CEEBB35F7F4238F6D")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.508 -0400", hash_original_method = "089B06359A27CB6D952DCE596F00B787", hash_generated_method = "ED621266BB22F9E32979BCBDEBBB47D8")
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        addTaint(keyCode);
        addTaint(v.getTaint());
        boolean var68934A3E9455FA72420237EB05902327_2042642701 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1541544142 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1541544142;
        // ---------- Original Method ----------
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.508 -0400", hash_original_method = "4F4EBC54D108D66F416C93B46580E117", hash_generated_method = "79CA73892C506BB89B5F7CBD255798E4")
    public Context getContext() {
Context var178E2AD52D6FBBB503F908168856B574_2092674023 =         mContext;
        var178E2AD52D6FBBB503F908168856B574_2092674023.addTaint(taint);
        return var178E2AD52D6FBBB503F908168856B574_2092674023;
        // ---------- Original Method ----------
        //return mContext;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.508 -0400", hash_original_method = "8BF68140BB0364C46F5E3D57D69A6DB5", hash_generated_method = "67F7065C806315AF6413E0BF58958F85")
    public SharedPreferences getSharedPreferences() {
        if(mPreferenceManager == null)        
        {
SharedPreferences var540C13E9E156B687226421B24F2DF178_603584975 =             null;
            var540C13E9E156B687226421B24F2DF178_603584975.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_603584975;
        } //End block
SharedPreferences var6931FC1A5179E16ED14F6FDB69C610BC_964673397 =         mPreferenceManager.getSharedPreferences();
        var6931FC1A5179E16ED14F6FDB69C610BC_964673397.addTaint(taint);
        return var6931FC1A5179E16ED14F6FDB69C610BC_964673397;
        // ---------- Original Method ----------
        //if (mPreferenceManager == null) {
            //return null;
        //}
        //return mPreferenceManager.getSharedPreferences();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.509 -0400", hash_original_method = "59D9CBF7E4B6683DDFDC1DAE57ABD5B7", hash_generated_method = "440D9878249565833FBA810E705EFA42")
    public SharedPreferences.Editor getEditor() {
        if(mPreferenceManager == null)        
        {
SharedPreferences.Editor var540C13E9E156B687226421B24F2DF178_38601563 =             null;
            var540C13E9E156B687226421B24F2DF178_38601563.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_38601563;
        } //End block
SharedPreferences.Editor varABFFF7131D023FF0D5B41102CA064E26_347965212 =         mPreferenceManager.getEditor();
        varABFFF7131D023FF0D5B41102CA064E26_347965212.addTaint(taint);
        return varABFFF7131D023FF0D5B41102CA064E26_347965212;
        // ---------- Original Method ----------
        //if (mPreferenceManager == null) {
            //return null;
        //}
        //return mPreferenceManager.getEditor();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.509 -0400", hash_original_method = "23B2B69F1B515A4430736566C100E20E", hash_generated_method = "FDBF964542C524A22B4B9D915D6BC8F9")
    public boolean shouldCommit() {
        if(mPreferenceManager == null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1803671728 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_142045229 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_142045229;
        } //End block
        boolean varEF1F133E2476D363D929168E90ADAD14_875031847 = (mPreferenceManager.shouldCommit());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_270814278 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_270814278;
        // ---------- Original Method ----------
        //if (mPreferenceManager == null) {
            //return false;
        //}
        //return mPreferenceManager.shouldCommit();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.511 -0400", hash_original_method = "93B6E6EE30870726B108BD396B876DEB", hash_generated_method = "81193FF9D7AC03B535DDB529A7ADF566")
    public int compareTo(Preference another) {
        addTaint(another.getTaint());
        if(mOrder != DEFAULT_ORDER
                || (mOrder == DEFAULT_ORDER && another.mOrder != DEFAULT_ORDER))        
        {
            int varE263F6634F0D192BE8ACB6EE6F59E21B_1942911338 = (mOrder - another.mOrder);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2110451929 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2110451929;
        } //End block
        else
        if(mTitle == null)        
        {
            int varC4CA4238A0B923820DCC509A6F75849B_1788786275 = (1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_275591153 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_275591153;
        } //End block
        else
        if(another.mTitle == null)        
        {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_55707620 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_36087881 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_36087881;
        } //End block
        else
        {
            int var742A94F4C4AD9345542A35CDFC248CF6_28823453 = (CharSequences.compareToIgnoreCase(mTitle, another.mTitle));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_958695226 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_958695226;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.511 -0400", hash_original_method = "6457E3944D02DD03B8855B0556ABBC63", hash_generated_method = "E2BE31D553581E6027B8A65C18170CE5")
    final void setOnPreferenceChangeInternalListener(OnPreferenceChangeInternalListener listener) {
        mListener = listener;
        // ---------- Original Method ----------
        //mListener = listener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.511 -0400", hash_original_method = "BC518684C2B31AF5801BA48B18DD0A6B", hash_generated_method = "301E8A64A0F19F0F4326BD86F226E333")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.512 -0400", hash_original_method = "B6CFA705B58CA125A61E30E547554AC9", hash_generated_method = "4B8BA16405C938D396AB21B03652A303")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.512 -0400", hash_original_method = "002FC5CEE5BE5B5D1FE36CEDBC1DEB65", hash_generated_method = "1CF8DEBFDF058120311E77683436CDEF")
    public PreferenceManager getPreferenceManager() {
PreferenceManager var00374A2A6A541F0EA9C609E6C6447EED_167095326 =         mPreferenceManager;
        var00374A2A6A541F0EA9C609E6C6447EED_167095326.addTaint(taint);
        return var00374A2A6A541F0EA9C609E6C6447EED_167095326;
        // ---------- Original Method ----------
        //return mPreferenceManager;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.512 -0400", hash_original_method = "664C21A1EBA456CB3BAFB18286851581", hash_generated_method = "E0785BE4D5230C52DEE75D865B3CCE59")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.512 -0400", hash_original_method = "ECA501E201E2D5472D2CB3C64A16D61F", hash_generated_method = "CEDF62541504E21C8B99E9FF9C6C284E")
    protected void onAttachedToActivity() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        registerDependency();
        // ---------- Original Method ----------
        //registerDependency();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.512 -0400", hash_original_method = "A499F7D8BECEFF58ECE377DCDDB4C87B", hash_generated_method = "E848D78F1FD0E779F3E9512A7F9A438E")
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
            IllegalStateException varAA818F098B1257731F38F3C28247D3A0_1967672895 = new IllegalStateException("Dependency \"" + mDependencyKey
                    + "\" not found for preference \"" + mKey + "\" (title: \"" + mTitle + "\"");
            varAA818F098B1257731F38F3C28247D3A0_1967672895.addTaint(taint);
            throw varAA818F098B1257731F38F3C28247D3A0_1967672895;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.512 -0400", hash_original_method = "40F9072BE8C6932FEF31F09A7FFFCE04", hash_generated_method = "E0CA9DEA4D60DF893A54187F3423CA69")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.513 -0400", hash_original_method = "913C05EFD2CE9AD9CE3BED6394A14862", hash_generated_method = "8A6873DA92BF2867E3A3A9CD394154F1")
    protected Preference findPreferenceInHierarchy(String key) {
        addTaint(key.getTaint());
        if(TextUtils.isEmpty(key) || mPreferenceManager == null)        
        {
Preference var540C13E9E156B687226421B24F2DF178_1289241267 =             null;
            var540C13E9E156B687226421B24F2DF178_1289241267.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1289241267;
        } //End block
Preference var3F9904390C47A44ACE8B6D395680E8CD_2064155410 =         mPreferenceManager.findPreference(key);
        var3F9904390C47A44ACE8B6D395680E8CD_2064155410.addTaint(taint);
        return var3F9904390C47A44ACE8B6D395680E8CD_2064155410;
        // ---------- Original Method ----------
        //if (TextUtils.isEmpty(key) || mPreferenceManager == null) {
            //return null;
        //}
        //return mPreferenceManager.findPreference(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.513 -0400", hash_original_method = "528DD85662997ACAED3BC519F97454B8", hash_generated_method = "BE6AE736963F5DA69F515FFFAFA7C007")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.513 -0400", hash_original_method = "9028FF718331F8BA1AAB10BD4FAE315E", hash_generated_method = "5378EC508EA2CBB41E2F17650C88EAA1")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.513 -0400", hash_original_method = "02C347ADE8272FB6E630575816981A99", hash_generated_method = "9AAF9FC6DA760B0649DC29F2DD17AD04")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.513 -0400", hash_original_method = "E3DDA7BA2220D3A5C80FED1DB4754CB9", hash_generated_method = "715B5013B5C8CC36761DF918194DF910")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.514 -0400", hash_original_method = "88055BCA041292961DE741A16807A2A3", hash_generated_method = "43F03D74D82A5AB9FF0918E8DD006712")
    public boolean shouldDisableDependents() {
        boolean var0DD7B2AE5E9D8B4B6F00EFC648BAA595_1740625509 = (!isEnabled());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1658151857 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1658151857;
        // ---------- Original Method ----------
        //return !isEnabled();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.514 -0400", hash_original_method = "FBFB05D545147227A8E2F6FCFC356242", hash_generated_method = "AA29AA179C0235E458D9FB109B1C7DAA")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.514 -0400", hash_original_method = "664EA11E01CF3C90DB639CBF1F232407", hash_generated_method = "6C99700FAA86AC9A96B0E6D49597AFB2")
    public String getDependency() {
String varAA01AFCCA0F4C7780E180B3A36010E30_701533246 =         mDependencyKey;
        varAA01AFCCA0F4C7780E180B3A36010E30_701533246.addTaint(taint);
        return varAA01AFCCA0F4C7780E180B3A36010E30_701533246;
        // ---------- Original Method ----------
        //return mDependencyKey;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.514 -0400", hash_original_method = "590B71B1265EC6EEA43053FD50985818", hash_generated_method = "14FE589E8685D8807F769025D0914FFE")
    protected void onPrepareForRemoval() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        unregisterDependency();
        // ---------- Original Method ----------
        //unregisterDependency();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.514 -0400", hash_original_method = "EC5991F73564EC767E73B865F0A17074", hash_generated_method = "2766AECCE7BBCD026046B542095917DF")
    public void setDefaultValue(Object defaultValue) {
        mDefaultValue = defaultValue;
        // ---------- Original Method ----------
        //mDefaultValue = defaultValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.514 -0400", hash_original_method = "0CC9C8053B2B40671F6785C5B066E9AB", hash_generated_method = "E53BC9B32D62F09EB903381F0FF0746E")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.515 -0400", hash_original_method = "8C28678F9AE41A1BF1FA484A48C7C6F8", hash_generated_method = "67328919D55CB90D19CFCA360EB7C376")
    protected void onSetInitialValue(boolean restorePersistedValue, Object defaultValue) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(defaultValue.getTaint());
        addTaint(restorePersistedValue);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.515 -0400", hash_original_method = "22CEE8BE8E503CA7A500DF872E2100EC", hash_generated_method = "3A3824EEA217C0AF1BC1154CE1860920")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.515 -0400", hash_original_method = "386F50F42D6EB5DC2DA2887FAD5D9C7B", hash_generated_method = "4E9CF3A8A11607436CBC264F6988AC1B")
    protected boolean persistString(String value) {
        addTaint(value.getTaint());
        if(shouldPersist())        
        {
            if(value == getPersistedString(null))            
            {
                boolean varB326B5062B2F0E69046810717534CB09_307345930 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1773848020 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1773848020;
            } //End block
            SharedPreferences.Editor editor = mPreferenceManager.getEditor();
            editor.putString(mKey, value);
            tryCommit(editor);
            boolean varB326B5062B2F0E69046810717534CB09_639125788 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1576204851 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1576204851;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1102259176 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_348604040 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_348604040;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.515 -0400", hash_original_method = "5E73C8E580A094A1DF5E2EFDD3570FC9", hash_generated_method = "4A3D92F3E27F344C050638B825FBD214")
    protected String getPersistedString(String defaultReturnValue) {
        addTaint(defaultReturnValue.getTaint());
        if(!shouldPersist())        
        {
String var5093ACA8CA1D918F3B8A2692E41ABFFE_58094481 =             defaultReturnValue;
            var5093ACA8CA1D918F3B8A2692E41ABFFE_58094481.addTaint(taint);
            return var5093ACA8CA1D918F3B8A2692E41ABFFE_58094481;
        } //End block
String varF2C0EE3A8570C65E9C5BFFB94419E76D_1641615920 =         mPreferenceManager.getSharedPreferences().getString(mKey, defaultReturnValue);
        varF2C0EE3A8570C65E9C5BFFB94419E76D_1641615920.addTaint(taint);
        return varF2C0EE3A8570C65E9C5BFFB94419E76D_1641615920;
        // ---------- Original Method ----------
        //if (!shouldPersist()) {
            //return defaultReturnValue;
        //}
        //return mPreferenceManager.getSharedPreferences().getString(mKey, defaultReturnValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.516 -0400", hash_original_method = "48F776762148447BA8C6A8C97BA6FE15", hash_generated_method = "A09F7AAF43DF273F0B9452415729CF64")
    protected boolean persistStringSet(Set<String> values) {
        addTaint(values.getTaint());
        if(shouldPersist())        
        {
            if(values.equals(getPersistedStringSet(null)))            
            {
                boolean varB326B5062B2F0E69046810717534CB09_2118370175 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_724266963 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_724266963;
            } //End block
            SharedPreferences.Editor editor = mPreferenceManager.getEditor();
            editor.putStringSet(mKey, values);
            tryCommit(editor);
            boolean varB326B5062B2F0E69046810717534CB09_995948133 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_342236101 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_342236101;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_143996504 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1141273002 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1141273002;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.516 -0400", hash_original_method = "D996103FD4641487F9C96461E983EA55", hash_generated_method = "E2991FBC34F6D1F15188DC9EF5D22F1D")
    protected Set<String> getPersistedStringSet(Set<String> defaultReturnValue) {
        addTaint(defaultReturnValue.getTaint());
        if(!shouldPersist())        
        {
Set<String> var5093ACA8CA1D918F3B8A2692E41ABFFE_1168413093 =             defaultReturnValue;
            var5093ACA8CA1D918F3B8A2692E41ABFFE_1168413093.addTaint(taint);
            return var5093ACA8CA1D918F3B8A2692E41ABFFE_1168413093;
        } //End block
Set<String> var2F0249972689681F84E134FA46F16F2E_2023901073 =         mPreferenceManager.getSharedPreferences().getStringSet(mKey, defaultReturnValue);
        var2F0249972689681F84E134FA46F16F2E_2023901073.addTaint(taint);
        return var2F0249972689681F84E134FA46F16F2E_2023901073;
        // ---------- Original Method ----------
        //if (!shouldPersist()) {
            //return defaultReturnValue;
        //}
        //return mPreferenceManager.getSharedPreferences().getStringSet(mKey, defaultReturnValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.516 -0400", hash_original_method = "EDA708B947224EBF19ED1E56671C9A01", hash_generated_method = "63ED0295C19CACA367F37BCAE7F5D771")
    protected boolean persistInt(int value) {
        addTaint(value);
        if(shouldPersist())        
        {
            if(value == getPersistedInt(~value))            
            {
                boolean varB326B5062B2F0E69046810717534CB09_1307808158 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_395699985 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_395699985;
            } //End block
            SharedPreferences.Editor editor = mPreferenceManager.getEditor();
            editor.putInt(mKey, value);
            tryCommit(editor);
            boolean varB326B5062B2F0E69046810717534CB09_555190171 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1121303871 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1121303871;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_524366028 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1043323733 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1043323733;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.516 -0400", hash_original_method = "7BDEA34D831595E2EEF9485CF72F7029", hash_generated_method = "B90E45237B2C30410296BF410BE42B57")
    protected int getPersistedInt(int defaultReturnValue) {
        addTaint(defaultReturnValue);
        if(!shouldPersist())        
        {
            int var8034FDFC49632927AA93303B21884306_1561095956 = (defaultReturnValue);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_403015057 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_403015057;
        } //End block
        int var27D64D2A4421ACCFD6EC8C8682C7A53A_2063525080 = (mPreferenceManager.getSharedPreferences().getInt(mKey, defaultReturnValue));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_960093098 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_960093098;
        // ---------- Original Method ----------
        //if (!shouldPersist()) {
            //return defaultReturnValue;
        //}
        //return mPreferenceManager.getSharedPreferences().getInt(mKey, defaultReturnValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.516 -0400", hash_original_method = "554687CB7FDF3E22A2095D4942A8012F", hash_generated_method = "D78BCD0E773743F38F52C835D97C9773")
    protected boolean persistFloat(float value) {
        addTaint(value);
        if(shouldPersist())        
        {
            if(value == getPersistedFloat(Float.NaN))            
            {
                boolean varB326B5062B2F0E69046810717534CB09_1393846428 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_873938808 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_873938808;
            } //End block
            SharedPreferences.Editor editor = mPreferenceManager.getEditor();
            editor.putFloat(mKey, value);
            tryCommit(editor);
            boolean varB326B5062B2F0E69046810717534CB09_896671051 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_309094119 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_309094119;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1533139817 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1483058159 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1483058159;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.516 -0400", hash_original_method = "AB28180DBEC7B1C710871982C247343B", hash_generated_method = "EFE10D9CC0CD6C0FFAC37EA0ACE06C40")
    protected float getPersistedFloat(float defaultReturnValue) {
        addTaint(defaultReturnValue);
        if(!shouldPersist())        
        {
            float var8034FDFC49632927AA93303B21884306_1459438877 = (defaultReturnValue);
                        float var546ADE640B6EDFBC8A086EF31347E768_709446151 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_709446151;
        } //End block
        float var6D813BCB042C3ADDCAD3BB2C23BBBD47_584953633 = (mPreferenceManager.getSharedPreferences().getFloat(mKey, defaultReturnValue));
                float var546ADE640B6EDFBC8A086EF31347E768_669527728 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_669527728;
        // ---------- Original Method ----------
        //if (!shouldPersist()) {
            //return defaultReturnValue;
        //}
        //return mPreferenceManager.getSharedPreferences().getFloat(mKey, defaultReturnValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.517 -0400", hash_original_method = "C10CC879E3FA9306B83F34EDB87FCEA5", hash_generated_method = "FC6A6DA26A0756CCC16A1CA8276D41B2")
    protected boolean persistLong(long value) {
        addTaint(value);
        if(shouldPersist())        
        {
            if(value == getPersistedLong(~value))            
            {
                boolean varB326B5062B2F0E69046810717534CB09_1556815893 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_866287693 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_866287693;
            } //End block
            SharedPreferences.Editor editor = mPreferenceManager.getEditor();
            editor.putLong(mKey, value);
            tryCommit(editor);
            boolean varB326B5062B2F0E69046810717534CB09_2019058265 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_558187875 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_558187875;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_2037713576 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_145839330 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_145839330;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.517 -0400", hash_original_method = "88751F99C7941FFB817628D8E528076A", hash_generated_method = "BB802952D5AE2A0CCE994C2FD53CF66D")
    protected long getPersistedLong(long defaultReturnValue) {
        addTaint(defaultReturnValue);
        if(!shouldPersist())        
        {
            long var8034FDFC49632927AA93303B21884306_1824258626 = (defaultReturnValue);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1284514855 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1284514855;
        } //End block
        long var2E7852F2545EABBCC210F8693E5F7DEF_1673212365 = (mPreferenceManager.getSharedPreferences().getLong(mKey, defaultReturnValue));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1479680382 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1479680382;
        // ---------- Original Method ----------
        //if (!shouldPersist()) {
            //return defaultReturnValue;
        //}
        //return mPreferenceManager.getSharedPreferences().getLong(mKey, defaultReturnValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.517 -0400", hash_original_method = "D20BDAFE65F5D54A08F0A9EE0DEAC992", hash_generated_method = "8EE96C74FC78727F6F5D8EE7EF844847")
    protected boolean persistBoolean(boolean value) {
        addTaint(value);
        if(shouldPersist())        
        {
            if(value == getPersistedBoolean(!value))            
            {
                boolean varB326B5062B2F0E69046810717534CB09_1125709609 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_960438709 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_960438709;
            } //End block
            SharedPreferences.Editor editor = mPreferenceManager.getEditor();
            editor.putBoolean(mKey, value);
            tryCommit(editor);
            boolean varB326B5062B2F0E69046810717534CB09_596715792 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1816699173 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1816699173;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1159971311 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_759938993 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_759938993;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.517 -0400", hash_original_method = "8F28A5D05D1E365FD2C0E61AA71BE94D", hash_generated_method = "1B9CC9514E51971AF7DAC959C09E0580")
    protected boolean getPersistedBoolean(boolean defaultReturnValue) {
        addTaint(defaultReturnValue);
        if(!shouldPersist())        
        {
            boolean var8034FDFC49632927AA93303B21884306_1940764645 = (defaultReturnValue);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1679558652 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1679558652;
        } //End block
        boolean varC11C3A43132FBF95A484109FDF91C69B_2058510506 = (mPreferenceManager.getSharedPreferences().getBoolean(mKey, defaultReturnValue));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1545968573 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1545968573;
        // ---------- Original Method ----------
        //if (!shouldPersist()) {
            //return defaultReturnValue;
        //}
        //return mPreferenceManager.getSharedPreferences().getBoolean(mKey, defaultReturnValue);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.517 -0400", hash_original_method = "79DC631A87B79C35E44BC11E3C275CE7", hash_generated_method = "2E4035F3B10690FB4B956FAD3DA90062")
     boolean hasSpecifiedLayout() {
        boolean varD86943AD76AEA15A81EB64F375E0E224_2092352185 = (mHasSpecifiedLayout);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1664708201 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1664708201;
        // ---------- Original Method ----------
        //return mHasSpecifiedLayout;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.518 -0400", hash_original_method = "F82B18888AE588251FAAB1FF7696A001", hash_generated_method = "1D6AF1BD360755E874F2A1926E5C490F")
    @Override
    public String toString() {
String var01E383B071399C21051F6051B8C4F407_900535926 =         getFilterableStringBuilder().toString();
        var01E383B071399C21051F6051B8C4F407_900535926.addTaint(taint);
        return var01E383B071399C21051F6051B8C4F407_900535926;
        // ---------- Original Method ----------
        //return getFilterableStringBuilder().toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.518 -0400", hash_original_method = "7FA40EC09188F6F1BEA3B1B94241EA4A", hash_generated_method = "7E85EBD2EB45F8E03EE8611FDF909EB7")
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
StringBuilder var8C7F5CF7BA5191ABF78E376D65A0039D_1515480858 =         sb;
        var8C7F5CF7BA5191ABF78E376D65A0039D_1515480858.addTaint(taint);
        return var8C7F5CF7BA5191ABF78E376D65A0039D_1515480858;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.518 -0400", hash_original_method = "363F8E8F58511FB925A751666AB900BD", hash_generated_method = "8084A64D57F71EF7996781F33F8407A2")
    public void saveHierarchyState(Bundle container) {
        addTaint(container.getTaint());
        dispatchSaveInstanceState(container);
        // ---------- Original Method ----------
        //dispatchSaveInstanceState(container);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.518 -0400", hash_original_method = "1B94F5D63E3EC8B47F4D750B8B09EC88", hash_generated_method = "8A23B170A3C34DD367BF29CC0F416F6C")
     void dispatchSaveInstanceState(Bundle container) {
        addTaint(container.getTaint());
        if(hasKey())        
        {
            mBaseMethodCalled = false;
            Parcelable state = onSaveInstanceState();
            if(!mBaseMethodCalled)            
            {
                IllegalStateException var3AC6518B2E70CB86B09E15593A1F4FC9_297938149 = new IllegalStateException(
                        "Derived class did not call super.onSaveInstanceState()");
                var3AC6518B2E70CB86B09E15593A1F4FC9_297938149.addTaint(taint);
                throw var3AC6518B2E70CB86B09E15593A1F4FC9_297938149;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.518 -0400", hash_original_method = "9DD945A60796B8A8FF01F94A77988BE6", hash_generated_method = "326751989E05B009ABA7C7A53B650F16")
    protected Parcelable onSaveInstanceState() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mBaseMethodCalled = true;
Parcelable var811282300C831A28E3AEFC5EE2A36FB6_768219737 =         BaseSavedState.EMPTY_STATE;
        var811282300C831A28E3AEFC5EE2A36FB6_768219737.addTaint(taint);
        return var811282300C831A28E3AEFC5EE2A36FB6_768219737;
        // ---------- Original Method ----------
        //mBaseMethodCalled = true;
        //return BaseSavedState.EMPTY_STATE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.518 -0400", hash_original_method = "D5A51A6B2B5A2D76F277782756F6ADE6", hash_generated_method = "681FC51259F01C6CB9B7A44A30005E3D")
    public void restoreHierarchyState(Bundle container) {
        addTaint(container.getTaint());
        dispatchRestoreInstanceState(container);
        // ---------- Original Method ----------
        //dispatchRestoreInstanceState(container);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.519 -0400", hash_original_method = "18F16B162844FF15C24BE293B1033BC4", hash_generated_method = "8CEC418FDCE386B3ADD430E223F0AF2C")
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
                    IllegalStateException var041490C7009C0A495ADBC57E4BE325FC_310631538 = new IllegalStateException(
                            "Derived class did not call super.onRestoreInstanceState()");
                    var041490C7009C0A495ADBC57E4BE325FC_310631538.addTaint(taint);
                    throw var041490C7009C0A495ADBC57E4BE325FC_310631538;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.519 -0400", hash_original_method = "18B537C81357A7563BC62FF4E045FAEF", hash_generated_method = "2CC06D78348B214A75F0154D12C72BC7")
    protected void onRestoreInstanceState(Parcelable state) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(state.getTaint());
        mBaseMethodCalled = true;
        if(state != BaseSavedState.EMPTY_STATE && state != null)        
        {
            IllegalArgumentException var7899D4784B7026C3D7BBCAC5D53EFDE9_123855487 = new IllegalArgumentException("Wrong state class -- expecting Preference State");
            var7899D4784B7026C3D7BBCAC5D53EFDE9_123855487.addTaint(taint);
            throw var7899D4784B7026C3D7BBCAC5D53EFDE9_123855487;
        } //End block
        // ---------- Original Method ----------
        //mBaseMethodCalled = true;
        //if (state != BaseSavedState.EMPTY_STATE && state != null) {
            //throw new IllegalArgumentException("Wrong state class -- expecting Preference State");
        //}
    }

    
    public static class BaseSavedState extends AbsSavedState {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.519 -0400", hash_original_method = "0710B1BECA4AE2A64DE9C58BFD4A1161", hash_generated_method = "EE939DE64E4E13C6649033F638632686")
        public  BaseSavedState(Parcel source) {
            super(source);
            addTaint(source.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.519 -0400", hash_original_method = "C61013DFD638DC996F3EF4CC52F40C74", hash_generated_method = "E01D93B6DF9621DF15B2FA6FE9F6F642")
        public  BaseSavedState(Parcelable superState) {
            super(superState);
            addTaint(superState.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.519 -0400", hash_original_field = "F69D27D6C01716FC1482B26F47E53A23", hash_generated_field = "1603EC57FF7A24DE0B9CE75D44794F2A")

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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.533 -0400", hash_original_field = "FB0E8DE194A65EAF0D6B4D5E48723B17", hash_generated_field = "2E41574F494D78468755ADDE8E4C30A4")

    public static final int DEFAULT_ORDER = Integer.MAX_VALUE;
}

