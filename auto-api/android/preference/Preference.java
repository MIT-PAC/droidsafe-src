package android.preference;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.002 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.002 -0400", hash_original_field = "D1487CA8252F4AA0A95324AB4DDD5316", hash_generated_field = "13262EB3751B753EEB3302EF75D8B1E5")

    private PreferenceManager mPreferenceManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.002 -0400", hash_original_field = "6AC7F06B6413A1BE9C136DC7DF0D2B60", hash_generated_field = "CF2A5FB7C7BB55BD451D113BD690151D")

    private long mId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.002 -0400", hash_original_field = "3213C247B4603DED047FFE75B63B4B6C", hash_generated_field = "B2CD75E86D570A2CCE7E2BC973BD4ACD")

    private OnPreferenceChangeListener mOnChangeListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.002 -0400", hash_original_field = "AA894545820F13D1E6598CEEF475CCC9", hash_generated_field = "03339AEC23A0F6C8C8113E6F7DC55FB5")

    private OnPreferenceClickListener mOnClickListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.002 -0400", hash_original_field = "759FE618587C2AB1184A3DF4077B5BD4", hash_generated_field = "4DBBABE4B5343924D877A673E4358521")

    private int mOrder = DEFAULT_ORDER;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.002 -0400", hash_original_field = "4B03BBB3AD21DBD17B2B689923FCF1F6", hash_generated_field = "ECAB18871B55104BACD4283C12B1074D")

    private CharSequence mTitle;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.002 -0400", hash_original_field = "B4A04CB1D37B3364DF264481CEA8B25E", hash_generated_field = "0BEE4780876F1B970FEA6B12663CC1C4")

    private int mTitleRes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.002 -0400", hash_original_field = "364E1929FED648A0A411C548B6A6CE28", hash_generated_field = "89C28E4357F1254876CE9020798E5A89")

    private CharSequence mSummary;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.002 -0400", hash_original_field = "0F522D56B85B081BF02F698ECADD7AFE", hash_generated_field = "7DAEA4581257F07E76CD939CD24A2FD7")

    private int mIconResId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.002 -0400", hash_original_field = "1A265556E59DF15CAEC4E55FB61E68C7", hash_generated_field = "FFB83F2A7C9A877B036AAEB7C21DDF6E")

    private Drawable mIcon;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.002 -0400", hash_original_field = "7E690C9CC141370A5EC6E7A98DC6FF62", hash_generated_field = "C36B21320914DA8259201FF07A2C068D")

    private String mKey;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.002 -0400", hash_original_field = "B1135DD88C82BCDD4DCD8391BCD99883", hash_generated_field = "5782C825DA3F61D408DF2DCA63E7F54A")

    private Intent mIntent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.002 -0400", hash_original_field = "3FD10A4D9B0E4F081E637AB2E170510C", hash_generated_field = "F74F34FFBA0EE92FA7BFBACA55B63FEF")

    private String mFragment;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.002 -0400", hash_original_field = "45F5DC4EA541ED660CFEDA0032CA356C", hash_generated_field = "5596C79D633F3A9F64294D3BD6D43156")

    private Bundle mExtras;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.002 -0400", hash_original_field = "71AB1146E1CEE92AB74D832DEFFE135F", hash_generated_field = "8BBE5745FA7C6470C8EA4F0513877CD6")

    private boolean mEnabled = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.002 -0400", hash_original_field = "D2831E7836D599A678D483B6294DDC44", hash_generated_field = "1A3F26BEC59143A828A7366C664C2B34")

    private boolean mSelectable = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.002 -0400", hash_original_field = "DF5D85B683298771811AC0DA28EAA613", hash_generated_field = "24780C50494002A4AF74BE6D462BE687")

    private boolean mRequiresKey;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.002 -0400", hash_original_field = "0250DF5C7FFD5EED92782A49F6405CFF", hash_generated_field = "27082D50DFDAA9191800D07F3AF15268")

    private boolean mPersistent = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.002 -0400", hash_original_field = "A397CDE94E1B6D2DEDC3A6F7D910612B", hash_generated_field = "B26344E1F3EABE836E6724009E62D614")

    private String mDependencyKey;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.002 -0400", hash_original_field = "3D9F826E2A85D6A96D8493A9F2E57CAC", hash_generated_field = "42900AC295F63E9B792D05C2A7334252")

    private Object mDefaultValue;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.002 -0400", hash_original_field = "212F572493A222F913C2F8AB8182CA71", hash_generated_field = "BEDE89D1CA2E56235E886F0A2A60132A")

    private boolean mDependencyMet = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.002 -0400", hash_original_field = "39B855F662D38B52B3F468037B6033C8", hash_generated_field = "76B9F6CF747E54F39C22CAC52291B4CD")

    private boolean mShouldDisableView = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.002 -0400", hash_original_field = "B5C7F1291490ADFCCBE98EF4AC5DC599", hash_generated_field = "2628AFC967B4980D202AAA14C9F08E6C")

    private int mLayoutResId = com.android.internal.R.layout.preference;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.002 -0400", hash_original_field = "68A3A909EA046E49435A797A37664E61", hash_generated_field = "03CE89F32EE4B5097448BE77263408B4")

    private int mWidgetLayoutResId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.002 -0400", hash_original_field = "42DF999BF001FDB041B1E1ECE0658C31", hash_generated_field = "37581EC71ABDA9DF6D14233378E40DCE")

    private boolean mHasSpecifiedLayout = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.002 -0400", hash_original_field = "9B3DD33B99719CE65C53FA6749E2AD69", hash_generated_field = "AC60A661DDD5C1ADBF7F01BD463F7E24")

    private OnPreferenceChangeInternalListener mListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.002 -0400", hash_original_field = "698EF7B44319FC69CFD2FC82A890F638", hash_generated_field = "B4077C41DC030C953102067792AA61E0")

    private List<Preference> mDependents;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.002 -0400", hash_original_field = "D87E96F5609D6847DCF3861262CE4BE7", hash_generated_field = "5E4C3692572C298E63D6463802841D4E")

    private boolean mBaseMethodCalled;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.004 -0400", hash_original_method = "9CEB9C34CAA8ECAB230B50A0542D61B3", hash_generated_method = "8B51C38FCE52A72A8E32195E2A2A788C")
    public  Preference(Context context, AttributeSet attrs, int defStyle) {
        mContext = context;
        TypedArray a = context.obtainStyledAttributes(attrs,
                com.android.internal.R.styleable.Preference, defStyle, 0);
        {
            int i = a.getIndexCount();
            {
                int attr = a.getIndex(i);
                //Begin case com.android.internal.R.styleable.Preference_icon 
                mIconResId = a.getResourceId(attr, 0);
                //End case com.android.internal.R.styleable.Preference_icon 
                //Begin case com.android.internal.R.styleable.Preference_key 
                mKey = a.getString(attr);
                //End case com.android.internal.R.styleable.Preference_key 
                //Begin case com.android.internal.R.styleable.Preference_title 
                mTitleRes = a.getResourceId(attr, 0);
                //End case com.android.internal.R.styleable.Preference_title 
                //Begin case com.android.internal.R.styleable.Preference_title 
                mTitle = a.getString(attr);
                //End case com.android.internal.R.styleable.Preference_title 
                //Begin case com.android.internal.R.styleable.Preference_summary 
                mSummary = a.getString(attr);
                //End case com.android.internal.R.styleable.Preference_summary 
                //Begin case com.android.internal.R.styleable.Preference_order 
                mOrder = a.getInt(attr, mOrder);
                //End case com.android.internal.R.styleable.Preference_order 
                //Begin case com.android.internal.R.styleable.Preference_fragment 
                mFragment = a.getString(attr);
                //End case com.android.internal.R.styleable.Preference_fragment 
                //Begin case com.android.internal.R.styleable.Preference_layout 
                mLayoutResId = a.getResourceId(attr, mLayoutResId);
                //End case com.android.internal.R.styleable.Preference_layout 
                //Begin case com.android.internal.R.styleable.Preference_widgetLayout 
                mWidgetLayoutResId = a.getResourceId(attr, mWidgetLayoutResId);
                //End case com.android.internal.R.styleable.Preference_widgetLayout 
                //Begin case com.android.internal.R.styleable.Preference_enabled 
                mEnabled = a.getBoolean(attr, true);
                //End case com.android.internal.R.styleable.Preference_enabled 
                //Begin case com.android.internal.R.styleable.Preference_selectable 
                mSelectable = a.getBoolean(attr, true);
                //End case com.android.internal.R.styleable.Preference_selectable 
                //Begin case com.android.internal.R.styleable.Preference_persistent 
                mPersistent = a.getBoolean(attr, mPersistent);
                //End case com.android.internal.R.styleable.Preference_persistent 
                //Begin case com.android.internal.R.styleable.Preference_dependency 
                mDependencyKey = a.getString(attr);
                //End case com.android.internal.R.styleable.Preference_dependency 
                //Begin case com.android.internal.R.styleable.Preference_defaultValue 
                mDefaultValue = onGetDefaultValue(a, attr);
                //End case com.android.internal.R.styleable.Preference_defaultValue 
                //Begin case com.android.internal.R.styleable.Preference_shouldDisableView 
                mShouldDisableView = a.getBoolean(attr, mShouldDisableView);
                //End case com.android.internal.R.styleable.Preference_shouldDisableView 
            } //End block
        } //End collapsed parenthetic
        a.recycle();
        {
            boolean var10BC812A3C0743D80A2FB7B328F2D5C8_605892450 = (!getClass().getName().startsWith("android.preference"));
            {
                mHasSpecifiedLayout = true;
            } //End block
        } //End collapsed parenthetic
        addTaint(attrs.getTaint());
        addTaint(defStyle);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.004 -0400", hash_original_method = "48043D3D24F48A6FD06B47A9624983D0", hash_generated_method = "F37A11A98E4DADBEB603ACD572AE0A02")
    public  Preference(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.preferenceStyle);
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.004 -0400", hash_original_method = "B50FF766B3A35A641C8DC6BF5214AE70", hash_generated_method = "946D92E4443D83AFE407CB73CBDDE443")
    public  Preference(Context context) {
        this(context, null);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.005 -0400", hash_original_method = "75C2469AD4E7F0A9F01D294D0E9B9A83", hash_generated_method = "89766C28CD21D4A42992F2B6B3A7589E")
    protected Object onGetDefaultValue(TypedArray a, int index) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        Object varB4EAC82CA7396A68D541C85D26508E83_2104419887 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2104419887 = null;
        addTaint(a.getTaint());
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_2104419887.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2104419887;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.006 -0400", hash_original_method = "BB18D5EDF68F7EDDF74E48FAF30F475E", hash_generated_method = "36AB7FE2A4C2C0EF3565BBD54597E3F4")
    public void setIntent(Intent intent) {
        mIntent = intent;
        // ---------- Original Method ----------
        //mIntent = intent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.007 -0400", hash_original_method = "AD027B7B58A4A2F151CC138FB7B23244", hash_generated_method = "7654FFA1E1BC6178B05F34F9ADC0AA27")
    public Intent getIntent() {
        Intent varB4EAC82CA7396A68D541C85D26508E83_24835660 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_24835660 = mIntent;
        varB4EAC82CA7396A68D541C85D26508E83_24835660.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_24835660;
        // ---------- Original Method ----------
        //return mIntent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.007 -0400", hash_original_method = "B84A292EE370DC034681ED1A5B514CE4", hash_generated_method = "918CDAB4381AA56F58F01C803B049B49")
    public void setFragment(String fragment) {
        mFragment = fragment;
        // ---------- Original Method ----------
        //mFragment = fragment;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.008 -0400", hash_original_method = "133D42C98C64EF6757CE3D375E2E1FA7", hash_generated_method = "64001BC08DBDA693C2C6AF3375946DB9")
    public String getFragment() {
        String varB4EAC82CA7396A68D541C85D26508E83_342793546 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_342793546 = mFragment;
        varB4EAC82CA7396A68D541C85D26508E83_342793546.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_342793546;
        // ---------- Original Method ----------
        //return mFragment;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.009 -0400", hash_original_method = "F77D5C181034415714B081995209DE64", hash_generated_method = "E049BD95B3C06008389C4D0CB2E9A25E")
    public Bundle getExtras() {
        Bundle varB4EAC82CA7396A68D541C85D26508E83_228641393 = null; //Variable for return #1
        {
            mExtras = new Bundle();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_228641393 = mExtras;
        varB4EAC82CA7396A68D541C85D26508E83_228641393.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_228641393;
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //return mExtras;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.009 -0400", hash_original_method = "06728B07006932C3BCF42D880B54A6CC", hash_generated_method = "11D608AF23A5B688EE81226E91682B35")
    public Bundle peekExtras() {
        Bundle varB4EAC82CA7396A68D541C85D26508E83_182702290 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_182702290 = mExtras;
        varB4EAC82CA7396A68D541C85D26508E83_182702290.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_182702290;
        // ---------- Original Method ----------
        //return mExtras;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.010 -0400", hash_original_method = "528C4C3ACF7780A9B6B960E406A0977A", hash_generated_method = "9BC9CDEF57BB8B884A923053E3224AFB")
    public void setLayoutResource(int layoutResId) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.010 -0400", hash_original_method = "A2555092F113429083F033F36B8E024F", hash_generated_method = "1374887C158A1E2BAD242BF72D5ACBC4")
    public int getLayoutResource() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_269272201 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_269272201;
        // ---------- Original Method ----------
        //return mLayoutResId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.011 -0400", hash_original_method = "2204831C4D4DE968C9A72D9D306DDD8C", hash_generated_method = "7D69EAF5A42E30772D9C3169D7AE6AD6")
    public void setWidgetLayoutResource(int widgetLayoutResId) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.011 -0400", hash_original_method = "6D000A2827FAFE2A1A87DD4A065ACF04", hash_generated_method = "294F20E3EDE7C6CE4FB4929957A1C4E7")
    public int getWidgetLayoutResource() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1268458156 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1268458156;
        // ---------- Original Method ----------
        //return mWidgetLayoutResId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.012 -0400", hash_original_method = "10F5B4A945AE227B9B33457223123B2A", hash_generated_method = "C784EE0CC6CE63DDAFCDBFD1474B7C70")
    public View getView(View convertView, ViewGroup parent) {
        View varB4EAC82CA7396A68D541C85D26508E83_1553945024 = null; //Variable for return #1
        {
            convertView = onCreateView(parent);
        } //End block
        onBindView(convertView);
        varB4EAC82CA7396A68D541C85D26508E83_1553945024 = convertView;
        addTaint(convertView.getTaint());
        addTaint(parent.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1553945024.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1553945024;
        // ---------- Original Method ----------
        //if (convertView == null) {
            //convertView = onCreateView(parent);
        //}
        //onBindView(convertView);
        //return convertView;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.013 -0400", hash_original_method = "DD0E6DF051F4F0779DD2D5F6BCD064A5", hash_generated_method = "62FB78F224CFA89A8EA8A53190322722")
    protected View onCreateView(ViewGroup parent) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        View varB4EAC82CA7396A68D541C85D26508E83_214269521 = null; //Variable for return #1
        final LayoutInflater layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View layout = layoutInflater.inflate(mLayoutResId, parent, false);
        final ViewGroup widgetFrame = (ViewGroup) layout
                .findViewById(com.android.internal.R.id.widget_frame);
        {
            {
                layoutInflater.inflate(mWidgetLayoutResId, widgetFrame);
            } //End block
            {
                widgetFrame.setVisibility(View.GONE);
            } //End block
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_214269521 = layout;
        addTaint(parent.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_214269521.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_214269521;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.014 -0400", hash_original_method = "D65593443BAE954E876A7311E3E1909A", hash_generated_method = "56C50AE26DA4E3ABA1E0395A91DEE929")
    protected void onBindView(View view) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        TextView textView = (TextView) view.findViewById(com.android.internal.R.id.title);
        {
            textView.setText(getTitle());
        } //End block
        textView = (TextView) view.findViewById(com.android.internal.R.id.summary);
        {
            final CharSequence summary = getSummary();
            {
                boolean var33886BAB7464784CE6FA21654C0C5CE0_166628479 = (!TextUtils.isEmpty(summary));
                {
                    {
                        boolean var130C18F3D215FC85E4C5C553CB359870_1543216871 = (textView.getVisibility() != View.VISIBLE);
                        {
                            textView.setVisibility(View.VISIBLE);
                        } //End block
                    } //End collapsed parenthetic
                    textView.setText(getSummary());
                } //End block
                {
                    {
                        boolean varB53302C499574F7ECA44F69707CCE618_55581835 = (textView.getVisibility() != View.GONE);
                        {
                            textView.setVisibility(View.GONE);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        ImageView imageView = (ImageView) view.findViewById(com.android.internal.R.id.icon);
        {
            {
                {
                    mIcon = getContext().getResources().getDrawable(mIconResId);
                } //End block
                {
                    imageView.setImageDrawable(mIcon);
                } //End block
            } //End block
            imageView.setVisibility(mIcon != null ? View.VISIBLE : View.GONE);
        } //End block
        {
            setEnabledStateOnViews(view, isEnabled());
        } //End block
        addTaint(view.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.014 -0400", hash_original_method = "4F80205B57D5838ADEC212DC6CB9E651", hash_generated_method = "2B5BDD2D941DA2B699C31850B16C5605")
    private void setEnabledStateOnViews(View v, boolean enabled) {
        v.setEnabled(enabled);
        {
            final ViewGroup vg = (ViewGroup) v;
            {
                int i = vg.getChildCount() - 1;
                {
                    setEnabledStateOnViews(vg.getChildAt(i), enabled);
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(v.getTaint());
        addTaint(enabled);
        // ---------- Original Method ----------
        //v.setEnabled(enabled);
        //if (v instanceof ViewGroup) {
            //final ViewGroup vg = (ViewGroup) v;
            //for (int i = vg.getChildCount() - 1; i >= 0; i--) {
                //setEnabledStateOnViews(vg.getChildAt(i), enabled);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.015 -0400", hash_original_method = "84974F9AFFF82527B4C714348BF0B3DB", hash_generated_method = "5EEE00E8C9F26A17E6D4AD865FB08B24")
    public void setOrder(int order) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.015 -0400", hash_original_method = "BE8C43C510B8AF8546FEBBAA3EF0F0B1", hash_generated_method = "243FC93BC79471971E84B67773099F63")
    public int getOrder() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1809315999 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1809315999;
        // ---------- Original Method ----------
        //return mOrder;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.016 -0400", hash_original_method = "B4BEC153E73D566AEC40ED844297CB0F", hash_generated_method = "42DEFE572C6E673D5FBDF06719CAA5F8")
    public void setTitle(CharSequence title) {
        {
            boolean var3E1E3FC34E7505C6E24DFDD86F4100EF_1958923109 = (title == null && mTitle != null || title != null && !title.equals(mTitle));
            {
                mTitleRes = 0;
                mTitle = title;
                notifyChanged();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (title == null && mTitle != null || title != null && !title.equals(mTitle)) {
            //mTitleRes = 0;
            //mTitle = title;
            //notifyChanged();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.017 -0400", hash_original_method = "4E4A93A9A53A92BE0779D6D57BF6863D", hash_generated_method = "6ACAB13F5CD19AE36D59ABBBF68726F7")
    public void setTitle(int titleResId) {
        setTitle(mContext.getString(titleResId));
        mTitleRes = titleResId;
        // ---------- Original Method ----------
        //setTitle(mContext.getString(titleResId));
        //mTitleRes = titleResId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.017 -0400", hash_original_method = "9778C1A15B3D4EC3FC935EB49323C011", hash_generated_method = "A619EE7116B0EAC0BA3BC52D0E824ABC")
    public int getTitleRes() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_254821303 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_254821303;
        // ---------- Original Method ----------
        //return mTitleRes;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.019 -0400", hash_original_method = "7D691BCB64236E7B5AF8F6CB0399C091", hash_generated_method = "E819048CD4157C836AF2B2E33481FDF2")
    public CharSequence getTitle() {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_702630722 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_702630722 = mTitle;
        varB4EAC82CA7396A68D541C85D26508E83_702630722.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_702630722;
        // ---------- Original Method ----------
        //return mTitle;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.020 -0400", hash_original_method = "3511105857431430BED74F970B043B64", hash_generated_method = "75E8F62CC11CE5BED48FFA284A36E7FA")
    public void setIcon(Drawable icon) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.021 -0400", hash_original_method = "42E5A2AC84ED127F39E187697447AF4F", hash_generated_method = "C5B24FFBB5B7217533EEE4D1981CFE30")
    public void setIcon(int iconResId) {
        mIconResId = iconResId;
        setIcon(mContext.getResources().getDrawable(iconResId));
        // ---------- Original Method ----------
        //mIconResId = iconResId;
        //setIcon(mContext.getResources().getDrawable(iconResId));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.022 -0400", hash_original_method = "ED78DC4ED6B2C6A65EDA3016CC1C1C4D", hash_generated_method = "2771F6F02DCBE625DA5CC3B77AA56832")
    public Drawable getIcon() {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_347575409 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_347575409 = mIcon;
        varB4EAC82CA7396A68D541C85D26508E83_347575409.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_347575409;
        // ---------- Original Method ----------
        //return mIcon;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.022 -0400", hash_original_method = "485EE2482F168D23B57BE8096AF663D1", hash_generated_method = "73138343FA80393BBDEEDEB44AEE1CF2")
    public CharSequence getSummary() {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_991952868 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_991952868 = mSummary;
        varB4EAC82CA7396A68D541C85D26508E83_991952868.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_991952868;
        // ---------- Original Method ----------
        //return mSummary;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.023 -0400", hash_original_method = "9397E34A85A0111B42F6FFB9A2837DEB", hash_generated_method = "3455FB95B325EFA85D18BE5B338A8615")
    public void setSummary(CharSequence summary) {
        {
            boolean var7D3C342C624946ABF94C19C1BF92A849_2100249078 = (summary == null && mSummary != null || summary != null && !summary.equals(mSummary));
            {
                mSummary = summary;
                notifyChanged();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (summary == null && mSummary != null || summary != null && !summary.equals(mSummary)) {
            //mSummary = summary;
            //notifyChanged();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.023 -0400", hash_original_method = "7AEFEE5A5E2C81392912FC13D133C130", hash_generated_method = "CB0CF4885B9BD07E42CF49DA6993E45D")
    public void setSummary(int summaryResId) {
        setSummary(mContext.getString(summaryResId));
        addTaint(summaryResId);
        // ---------- Original Method ----------
        //setSummary(mContext.getString(summaryResId));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.024 -0400", hash_original_method = "86021B1A0572E898D2D9C9D290D998FE", hash_generated_method = "08DBCAAFFE50444F5F8FBF6F912F18EC")
    public void setEnabled(boolean enabled) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.024 -0400", hash_original_method = "1BB77BECC2C1296C251576AD714A96C1", hash_generated_method = "CE659E1E003AF22192F0702629122E12")
    public boolean isEnabled() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1260045543 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1260045543;
        // ---------- Original Method ----------
        //return mEnabled && mDependencyMet;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.024 -0400", hash_original_method = "7EEA4953639C86CA9F36ABED9565FC6D", hash_generated_method = "1EF145B19EBB6C1A0AB385500F68BAAC")
    public void setSelectable(boolean selectable) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.025 -0400", hash_original_method = "A1A8E91E60B51F4951583D0866634B48", hash_generated_method = "AB84B570C86B9C9C2125F4879774B2E1")
    public boolean isSelectable() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1032533125 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1032533125;
        // ---------- Original Method ----------
        //return mSelectable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.025 -0400", hash_original_method = "97FCA568B4719676F3D4400812EA1F3A", hash_generated_method = "7F12B03326FA27759FCDAC4095D8D9F3")
    public void setShouldDisableView(boolean shouldDisableView) {
        mShouldDisableView = shouldDisableView;
        notifyChanged();
        // ---------- Original Method ----------
        //mShouldDisableView = shouldDisableView;
        //notifyChanged();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.026 -0400", hash_original_method = "465C9050F708FCF1A73506501FE4644E", hash_generated_method = "6FC8B0A96066C5FF4047F56144E40CA2")
    public boolean getShouldDisableView() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_624238009 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_624238009;
        // ---------- Original Method ----------
        //return mShouldDisableView;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.026 -0400", hash_original_method = "6AF16C815DE6FE4144432EF99CDC825B", hash_generated_method = "CEFAC21F24309927B031C4E61610E810")
     long getId() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1030078323 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1030078323;
        // ---------- Original Method ----------
        //return mId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.027 -0400", hash_original_method = "DE9BB9E40914727DA5D6E94159FAF3CB", hash_generated_method = "B12F9C4DD7EEB07FF06C6B7E88BC35E4")
    protected void onClick() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.027 -0400", hash_original_method = "46997BE6329912D9EC1174E4CE7CAB04", hash_generated_method = "37C5F2861FF7ED015A2416CDCDE1E08B")
    public void setKey(String key) {
        mKey = key;
        {
            boolean varD59801A1A66D3BBEFE5917383BD030C1_652809524 = (mRequiresKey && !hasKey());
            {
                requireKey();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //mKey = key;
        //if (mRequiresKey && !hasKey()) {
            //requireKey();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.028 -0400", hash_original_method = "E0CEA0C6ABDC55C32B991C1D155B5E3E", hash_generated_method = "0BF7FA14959736188A3F245F298AB2F4")
    public String getKey() {
        String varB4EAC82CA7396A68D541C85D26508E83_1272555477 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1272555477 = mKey;
        varB4EAC82CA7396A68D541C85D26508E83_1272555477.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1272555477;
        // ---------- Original Method ----------
        //return mKey;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.029 -0400", hash_original_method = "21702F9605A21EAEE85E66B458F985AA", hash_generated_method = "685CC251EA20D06F07307FAC300B84D6")
     void requireKey() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Preference does not have a key assigned.");
        } //End block
        mRequiresKey = true;
        // ---------- Original Method ----------
        //if (mKey == null) {
            //throw new IllegalStateException("Preference does not have a key assigned.");
        //}
        //mRequiresKey = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.029 -0400", hash_original_method = "3BC185E939D8CD84C5733E95D5330A61", hash_generated_method = "21756B5A2209E3B3CC42DAB097C2BFBE")
    public boolean hasKey() {
        boolean var5FDB348C3EC1AA79FB00873E989748AA_389406099 = (!TextUtils.isEmpty(mKey));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_465828295 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_465828295;
        // ---------- Original Method ----------
        //return !TextUtils.isEmpty(mKey);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.030 -0400", hash_original_method = "45C46AF35C2A296F9912D410933691CF", hash_generated_method = "923B5AA94C85D8DFE2CDAF35F383310B")
    public boolean isPersistent() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2104685363 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2104685363;
        // ---------- Original Method ----------
        //return mPersistent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.030 -0400", hash_original_method = "E7579FEE83F4F133055197D69D72F289", hash_generated_method = "8D087B476E7CE9DE925AF1A54A146375")
    protected boolean shouldPersist() {
        boolean var2B9F974DBFD553E7FDC0654C6EC87725_1645107129 = (mPreferenceManager != null && isPersistent() && hasKey());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1861711756 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1861711756;
        // ---------- Original Method ----------
        //return mPreferenceManager != null && isPersistent() && hasKey();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.031 -0400", hash_original_method = "9780EA334E29D2930E2D9A0F1CB4087F", hash_generated_method = "C4414A607836682C6B94DC1DA7BB4DF5")
    public void setPersistent(boolean persistent) {
        mPersistent = persistent;
        // ---------- Original Method ----------
        //mPersistent = persistent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.032 -0400", hash_original_method = "4367E5B2EAD1BB8898BD88F610DDAF7D", hash_generated_method = "7455BC2ABF43DDAB10AAF452E3901EB5")
    protected boolean callChangeListener(Object newValue) {
        {
            Object var840D0FFA474209A8E9E502A96959FE2F_1945354292 = (mOnChangeListener.onPreferenceChange(this, newValue));
        } //End flattened ternary
        addTaint(newValue.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_184461303 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_184461303;
        // ---------- Original Method ----------
        //return mOnChangeListener == null ? true : mOnChangeListener.onPreferenceChange(this, newValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.032 -0400", hash_original_method = "D46636D80B7557AC6195A05902CC638C", hash_generated_method = "7D40D426D5687A76C5D11598A2206435")
    public void setOnPreferenceChangeListener(OnPreferenceChangeListener onPreferenceChangeListener) {
        mOnChangeListener = onPreferenceChangeListener;
        // ---------- Original Method ----------
        //mOnChangeListener = onPreferenceChangeListener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.033 -0400", hash_original_method = "9CC8E5271070D42EF9628C47033D91A6", hash_generated_method = "90C024C86F977DB4C11EC02F8F16883E")
    public OnPreferenceChangeListener getOnPreferenceChangeListener() {
        OnPreferenceChangeListener varB4EAC82CA7396A68D541C85D26508E83_487560046 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_487560046 = mOnChangeListener;
        varB4EAC82CA7396A68D541C85D26508E83_487560046.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_487560046;
        // ---------- Original Method ----------
        //return mOnChangeListener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.034 -0400", hash_original_method = "E8A10745E179E2FA23FF715EAD4A5CB3", hash_generated_method = "1C194BF6887E87978417EF5A65E3F26D")
    public void setOnPreferenceClickListener(OnPreferenceClickListener onPreferenceClickListener) {
        mOnClickListener = onPreferenceClickListener;
        // ---------- Original Method ----------
        //mOnClickListener = onPreferenceClickListener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.034 -0400", hash_original_method = "55E2C6999F7D889141550F7A68D36827", hash_generated_method = "005F2C576AC7C68E8333374A9549BA55")
    public OnPreferenceClickListener getOnPreferenceClickListener() {
        OnPreferenceClickListener varB4EAC82CA7396A68D541C85D26508E83_1735507736 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1735507736 = mOnClickListener;
        varB4EAC82CA7396A68D541C85D26508E83_1735507736.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1735507736;
        // ---------- Original Method ----------
        //return mOnClickListener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.035 -0400", hash_original_method = "501E66F7BA58D6B4C7BCFDD2200CB13A", hash_generated_method = "72B27395127C3E13D68026ACCAFDC251")
     void performClick(PreferenceScreen preferenceScreen) {
        {
            boolean varC378F7D9F83769944CF2ACC662A4EAE3_876204663 = (!isEnabled());
        } //End collapsed parenthetic
        onClick();
        {
            boolean varACD6C4667640FA997CEF70414875FCB9_255321733 = (mOnClickListener != null && mOnClickListener.onPreferenceClick(this));
        } //End collapsed parenthetic
        PreferenceManager preferenceManager = getPreferenceManager();
        {
            PreferenceManager.OnPreferenceTreeClickListener listener = preferenceManager
                    .getOnPreferenceTreeClickListener();
            {
                boolean var6C0208A36FCEA21336C3A6F6854606AF_794375177 = (preferenceScreen != null && listener != null
                    && listener.onPreferenceTreeClick(preferenceScreen, this));
            } //End collapsed parenthetic
        } //End block
        {
            Context context = getContext();
            context.startActivity(mIntent);
        } //End block
        addTaint(preferenceScreen.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.036 -0400", hash_original_method = "089B06359A27CB6D952DCE596F00B787", hash_generated_method = "F603B80FD53CB82C4DC57CBBADAA3C0E")
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(v.getTaint());
        addTaint(keyCode);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_396142931 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_396142931;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.037 -0400", hash_original_method = "4F4EBC54D108D66F416C93B46580E117", hash_generated_method = "4453865193247E6FEFA9099B549A1D33")
    public Context getContext() {
        Context varB4EAC82CA7396A68D541C85D26508E83_343412816 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_343412816 = mContext;
        varB4EAC82CA7396A68D541C85D26508E83_343412816.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_343412816;
        // ---------- Original Method ----------
        //return mContext;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.038 -0400", hash_original_method = "8BF68140BB0364C46F5E3D57D69A6DB5", hash_generated_method = "26576BEE68DC5969437DA4E2AE354CDC")
    public SharedPreferences getSharedPreferences() {
        SharedPreferences varB4EAC82CA7396A68D541C85D26508E83_1392913805 = null; //Variable for return #1
        SharedPreferences varB4EAC82CA7396A68D541C85D26508E83_1285478697 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_1392913805 = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1285478697 = mPreferenceManager.getSharedPreferences();
        SharedPreferences varA7E53CE21691AB073D9660D615818899_868028309; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_868028309 = varB4EAC82CA7396A68D541C85D26508E83_1392913805;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_868028309 = varB4EAC82CA7396A68D541C85D26508E83_1285478697;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_868028309.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_868028309;
        // ---------- Original Method ----------
        //if (mPreferenceManager == null) {
            //return null;
        //}
        //return mPreferenceManager.getSharedPreferences();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.040 -0400", hash_original_method = "59D9CBF7E4B6683DDFDC1DAE57ABD5B7", hash_generated_method = "44A98C30249294527E5A663E2FCC3D9E")
    public SharedPreferences.Editor getEditor() {
        SharedPreferences.Editor varB4EAC82CA7396A68D541C85D26508E83_1383675138 = null; //Variable for return #1
        SharedPreferences.Editor varB4EAC82CA7396A68D541C85D26508E83_958632029 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_1383675138 = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_958632029 = mPreferenceManager.getEditor();
        SharedPreferences.Editor varA7E53CE21691AB073D9660D615818899_349786467; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_349786467 = varB4EAC82CA7396A68D541C85D26508E83_1383675138;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_349786467 = varB4EAC82CA7396A68D541C85D26508E83_958632029;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_349786467.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_349786467;
        // ---------- Original Method ----------
        //if (mPreferenceManager == null) {
            //return null;
        //}
        //return mPreferenceManager.getEditor();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.041 -0400", hash_original_method = "23B2B69F1B515A4430736566C100E20E", hash_generated_method = "4604E08E4B428ABDE099FBA904092A42")
    public boolean shouldCommit() {
        boolean varB6DAC15187C329558C72653F1654C862_196175967 = (mPreferenceManager.shouldCommit());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_158939777 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_158939777;
        // ---------- Original Method ----------
        //if (mPreferenceManager == null) {
            //return false;
        //}
        //return mPreferenceManager.shouldCommit();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.042 -0400", hash_original_method = "93B6E6EE30870726B108BD396B876DEB", hash_generated_method = "BEFBE0596FAB78AE429443109D59C69B")
    public int compareTo(Preference another) {
        {
            int var843ABEE7C36935B044756D876A54DA3D_421055313 = (CharSequences.compareToIgnoreCase(mTitle, another.mTitle));
        } //End block
        addTaint(another.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_264947675 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_264947675;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.042 -0400", hash_original_method = "6457E3944D02DD03B8855B0556ABBC63", hash_generated_method = "E2BE31D553581E6027B8A65C18170CE5")
    final void setOnPreferenceChangeInternalListener(OnPreferenceChangeInternalListener listener) {
        mListener = listener;
        // ---------- Original Method ----------
        //mListener = listener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.042 -0400", hash_original_method = "BC518684C2B31AF5801BA48B18DD0A6B", hash_generated_method = "3A319E676E5732DB111D341B5951950F")
    protected void notifyChanged() {
        {
            mListener.onPreferenceChange(this);
        } //End block
        // ---------- Original Method ----------
        //if (mListener != null) {
            //mListener.onPreferenceChange(this);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.043 -0400", hash_original_method = "B6CFA705B58CA125A61E30E547554AC9", hash_generated_method = "CDBBC3108FFB40C9AE40844C371092B9")
    protected void notifyHierarchyChanged() {
        {
            mListener.onPreferenceHierarchyChange(this);
        } //End block
        // ---------- Original Method ----------
        //if (mListener != null) {
            //mListener.onPreferenceHierarchyChange(this);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.044 -0400", hash_original_method = "002FC5CEE5BE5B5D1FE36CEDBC1DEB65", hash_generated_method = "7E487DBD1B914EC7BF8DF0AE1CE17305")
    public PreferenceManager getPreferenceManager() {
        PreferenceManager varB4EAC82CA7396A68D541C85D26508E83_901048495 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_901048495 = mPreferenceManager;
        varB4EAC82CA7396A68D541C85D26508E83_901048495.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_901048495;
        // ---------- Original Method ----------
        //return mPreferenceManager;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.044 -0400", hash_original_method = "664C21A1EBA456CB3BAFB18286851581", hash_generated_method = "E0785BE4D5230C52DEE75D865B3CCE59")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.044 -0400", hash_original_method = "ECA501E201E2D5472D2CB3C64A16D61F", hash_generated_method = "CEDF62541504E21C8B99E9FF9C6C284E")
    protected void onAttachedToActivity() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        registerDependency();
        // ---------- Original Method ----------
        //registerDependency();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.045 -0400", hash_original_method = "A499F7D8BECEFF58ECE377DCDDB4C87B", hash_generated_method = "B03154C6C6D98E54031A2CB0AEE2A42C")
    private void registerDependency() {
        {
            boolean varB1E8F75C3553AAFEDCF5483B863F116C_1550769818 = (TextUtils.isEmpty(mDependencyKey));
        } //End collapsed parenthetic
        Preference preference = findPreferenceInHierarchy(mDependencyKey);
        {
            preference.registerDependent(this);
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Dependency \"" + mDependencyKey
                    + "\" not found for preference \"" + mKey + "\" (title: \"" + mTitle + "\"");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.045 -0400", hash_original_method = "40F9072BE8C6932FEF31F09A7FFFCE04", hash_generated_method = "CCE1F3B675339DEBD79FDC77213ECD9F")
    private void unregisterDependency() {
        {
            final Preference oldDependency = findPreferenceInHierarchy(mDependencyKey);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.047 -0400", hash_original_method = "913C05EFD2CE9AD9CE3BED6394A14862", hash_generated_method = "DB539072FE1749C86D3978CE5E71F605")
    protected Preference findPreferenceInHierarchy(String key) {
        Preference varB4EAC82CA7396A68D541C85D26508E83_2098939420 = null; //Variable for return #1
        Preference varB4EAC82CA7396A68D541C85D26508E83_1672473267 = null; //Variable for return #2
        {
            boolean var14B185A6FDE26BEB2F1F14099406A9CC_354608789 = (TextUtils.isEmpty(key) || mPreferenceManager == null);
            {
                varB4EAC82CA7396A68D541C85D26508E83_2098939420 = null;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1672473267 = mPreferenceManager.findPreference(key);
        addTaint(key.getTaint());
        Preference varA7E53CE21691AB073D9660D615818899_1068381469; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1068381469 = varB4EAC82CA7396A68D541C85D26508E83_2098939420;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1068381469 = varB4EAC82CA7396A68D541C85D26508E83_1672473267;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1068381469.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1068381469;
        // ---------- Original Method ----------
        //if (TextUtils.isEmpty(key) || mPreferenceManager == null) {
            //return null;
        //}
        //return mPreferenceManager.findPreference(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.048 -0400", hash_original_method = "528DD85662997ACAED3BC519F97454B8", hash_generated_method = "36878ECA57480DE8FB6625B948113DA3")
    private void registerDependent(Preference dependent) {
        {
            mDependents = new ArrayList<Preference>();
        } //End block
        mDependents.add(dependent);
        dependent.onDependencyChanged(this, shouldDisableDependents());
        addTaint(dependent.getTaint());
        // ---------- Original Method ----------
        //if (mDependents == null) {
            //mDependents = new ArrayList<Preference>();
        //}
        //mDependents.add(dependent);
        //dependent.onDependencyChanged(this, shouldDisableDependents());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.049 -0400", hash_original_method = "9028FF718331F8BA1AAB10BD4FAE315E", hash_generated_method = "E332730C2EBA5A44EA95BEBE439B9FC3")
    private void unregisterDependent(Preference dependent) {
        {
            mDependents.remove(dependent);
        } //End block
        addTaint(dependent.getTaint());
        // ---------- Original Method ----------
        //if (mDependents != null) {
            //mDependents.remove(dependent);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.050 -0400", hash_original_method = "02C347ADE8272FB6E630575816981A99", hash_generated_method = "C00BD4960CE702A605918EB24516DFFF")
    public void notifyDependencyChange(boolean disableDependents) {
        final List<Preference> dependents = mDependents;
        final int dependentsCount = dependents.size();
        {
            int i = 0;
            {
                dependents.get(i).onDependencyChanged(this, disableDependents);
            } //End block
        } //End collapsed parenthetic
        addTaint(disableDependents);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.051 -0400", hash_original_method = "E3DDA7BA2220D3A5C80FED1DB4754CB9", hash_generated_method = "78DD02C042F5223692E65666BF8BB279")
    public void onDependencyChanged(Preference dependency, boolean disableDependent) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            mDependencyMet = !disableDependent;
            notifyDependencyChange(shouldDisableDependents());
            notifyChanged();
        } //End block
        addTaint(dependency.getTaint());
        // ---------- Original Method ----------
        //if (mDependencyMet == disableDependent) {
            //mDependencyMet = !disableDependent;
            //notifyDependencyChange(shouldDisableDependents());
            //notifyChanged();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.052 -0400", hash_original_method = "88055BCA041292961DE741A16807A2A3", hash_generated_method = "57C7EB5F4B911C61249ECA016723024B")
    public boolean shouldDisableDependents() {
        boolean var09FF3454BC8E65DB686A79A385F3030C_125447374 = (!isEnabled());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_785537672 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_785537672;
        // ---------- Original Method ----------
        //return !isEnabled();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.052 -0400", hash_original_method = "FBFB05D545147227A8E2F6FCFC356242", hash_generated_method = "AA29AA179C0235E458D9FB109B1C7DAA")
    public void setDependency(String dependencyKey) {
        unregisterDependency();
        mDependencyKey = dependencyKey;
        registerDependency();
        // ---------- Original Method ----------
        //unregisterDependency();
        //mDependencyKey = dependencyKey;
        //registerDependency();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.053 -0400", hash_original_method = "664EA11E01CF3C90DB639CBF1F232407", hash_generated_method = "DE956E044F21D78491A512A976C6502D")
    public String getDependency() {
        String varB4EAC82CA7396A68D541C85D26508E83_209015046 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_209015046 = mDependencyKey;
        varB4EAC82CA7396A68D541C85D26508E83_209015046.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_209015046;
        // ---------- Original Method ----------
        //return mDependencyKey;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.053 -0400", hash_original_method = "590B71B1265EC6EEA43053FD50985818", hash_generated_method = "14FE589E8685D8807F769025D0914FFE")
    protected void onPrepareForRemoval() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        unregisterDependency();
        // ---------- Original Method ----------
        //unregisterDependency();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.053 -0400", hash_original_method = "EC5991F73564EC767E73B865F0A17074", hash_generated_method = "2766AECCE7BBCD026046B542095917DF")
    public void setDefaultValue(Object defaultValue) {
        mDefaultValue = defaultValue;
        // ---------- Original Method ----------
        //mDefaultValue = defaultValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.054 -0400", hash_original_method = "0CC9C8053B2B40671F6785C5B066E9AB", hash_generated_method = "E98357D0F205B444C040C0135D45A521")
    private void dispatchSetInitialValue() {
        final boolean shouldPersist = shouldPersist();
        {
            boolean varE1E93872791DB34FDCFD35466E3B326E_1833444371 = (!shouldPersist || !getSharedPreferences().contains(mKey));
            {
                {
                    onSetInitialValue(false, mDefaultValue);
                } //End block
            } //End block
            {
                onSetInitialValue(true, null);
            } //End block
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.054 -0400", hash_original_method = "8C28678F9AE41A1BF1FA484A48C7C6F8", hash_generated_method = "82BFF194E4CB60779A58E0918F81627E")
    protected void onSetInitialValue(boolean restorePersistedValue, Object defaultValue) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(restorePersistedValue);
        addTaint(defaultValue.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.055 -0400", hash_original_method = "22CEE8BE8E503CA7A500DF872E2100EC", hash_generated_method = "EFD6192F1659D0D62D57DE9EBD0A1DC5")
    private void tryCommit(SharedPreferences.Editor editor) {
        {
            boolean varA868B554C77E962698C11A447AF0E264_298058886 = (mPreferenceManager.shouldCommit());
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
        } //End collapsed parenthetic
        addTaint(editor.getTaint());
        // ---------- Original Method ----------
        //if (mPreferenceManager.shouldCommit()) {
            //try {
                //editor.apply();
            //} catch (AbstractMethodError unused) {
                //editor.commit();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.055 -0400", hash_original_method = "386F50F42D6EB5DC2DA2887FAD5D9C7B", hash_generated_method = "427DD82168573CFA721885B150C48DB2")
    protected boolean persistString(String value) {
        {
            boolean var2ADBD6A37C43E8A998AE5217C3DE0D7C_1233233300 = (shouldPersist());
            {
                {
                    boolean varB83E9DE1E67EF06C183B09C0E0D44CCE_1645367535 = (value == getPersistedString(null));
                } //End collapsed parenthetic
                SharedPreferences.Editor editor = mPreferenceManager.getEditor();
                editor.putString(mKey, value);
                tryCommit(editor);
            } //End block
        } //End collapsed parenthetic
        addTaint(value.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1167479423 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1167479423;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.057 -0400", hash_original_method = "5E73C8E580A094A1DF5E2EFDD3570FC9", hash_generated_method = "A00A673B5E3C97D30EE9813E0B24F19B")
    protected String getPersistedString(String defaultReturnValue) {
        String varB4EAC82CA7396A68D541C85D26508E83_1312311436 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_139324075 = null; //Variable for return #2
        {
            boolean var55473E3F697E9E0994A85A68E07852AD_1138071667 = (!shouldPersist());
            {
                varB4EAC82CA7396A68D541C85D26508E83_1312311436 = defaultReturnValue;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_139324075 = mPreferenceManager.getSharedPreferences().getString(mKey, defaultReturnValue);
        addTaint(defaultReturnValue.getTaint());
        String varA7E53CE21691AB073D9660D615818899_939666150; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_939666150 = varB4EAC82CA7396A68D541C85D26508E83_1312311436;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_939666150 = varB4EAC82CA7396A68D541C85D26508E83_139324075;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_939666150.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_939666150;
        // ---------- Original Method ----------
        //if (!shouldPersist()) {
            //return defaultReturnValue;
        //}
        //return mPreferenceManager.getSharedPreferences().getString(mKey, defaultReturnValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.058 -0400", hash_original_method = "48F776762148447BA8C6A8C97BA6FE15", hash_generated_method = "B067A58F7DC8BFD8AD6CA00ECCE711B8")
    protected boolean persistStringSet(Set<String> values) {
        {
            boolean var2ADBD6A37C43E8A998AE5217C3DE0D7C_475011421 = (shouldPersist());
            {
                {
                    boolean var65F6840337FA6F30C7823EE44C85EAFD_1780779008 = (values.equals(getPersistedStringSet(null)));
                } //End collapsed parenthetic
                SharedPreferences.Editor editor = mPreferenceManager.getEditor();
                editor.putStringSet(mKey, values);
                tryCommit(editor);
            } //End block
        } //End collapsed parenthetic
        addTaint(values.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_170499579 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_170499579;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.060 -0400", hash_original_method = "D996103FD4641487F9C96461E983EA55", hash_generated_method = "DDCB5F494A8D81B518119C854DCA80E2")
    protected Set<String> getPersistedStringSet(Set<String> defaultReturnValue) {
        Set<String> varB4EAC82CA7396A68D541C85D26508E83_101606810 = null; //Variable for return #1
        Set<String> varB4EAC82CA7396A68D541C85D26508E83_487927871 = null; //Variable for return #2
        {
            boolean var55473E3F697E9E0994A85A68E07852AD_1044146153 = (!shouldPersist());
            {
                varB4EAC82CA7396A68D541C85D26508E83_101606810 = defaultReturnValue;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_487927871 = mPreferenceManager.getSharedPreferences().getStringSet(mKey, defaultReturnValue);
        addTaint(defaultReturnValue.getTaint());
        Set<String> varA7E53CE21691AB073D9660D615818899_11298292; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_11298292 = varB4EAC82CA7396A68D541C85D26508E83_101606810;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_11298292 = varB4EAC82CA7396A68D541C85D26508E83_487927871;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_11298292.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_11298292;
        // ---------- Original Method ----------
        //if (!shouldPersist()) {
            //return defaultReturnValue;
        //}
        //return mPreferenceManager.getSharedPreferences().getStringSet(mKey, defaultReturnValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.061 -0400", hash_original_method = "EDA708B947224EBF19ED1E56671C9A01", hash_generated_method = "7979DAD14ADC5C0A219E690050FD0A0B")
    protected boolean persistInt(int value) {
        {
            boolean var2ADBD6A37C43E8A998AE5217C3DE0D7C_306678481 = (shouldPersist());
            {
                {
                    boolean varEB0E728FD1FBEED4ABBE87C7B22789DA_1566628536 = (value == getPersistedInt(~value));
                } //End collapsed parenthetic
                SharedPreferences.Editor editor = mPreferenceManager.getEditor();
                editor.putInt(mKey, value);
                tryCommit(editor);
            } //End block
        } //End collapsed parenthetic
        addTaint(value);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_592820580 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_592820580;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.061 -0400", hash_original_method = "7BDEA34D831595E2EEF9485CF72F7029", hash_generated_method = "844E2768F4AF5B4B6C5E3CCD56AD51EE")
    protected int getPersistedInt(int defaultReturnValue) {
        {
            boolean var55473E3F697E9E0994A85A68E07852AD_1129032794 = (!shouldPersist());
        } //End collapsed parenthetic
        int varC34E9779AB3566FB4786F87E273A6847_901311963 = (mPreferenceManager.getSharedPreferences().getInt(mKey, defaultReturnValue));
        addTaint(defaultReturnValue);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1947433871 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1947433871;
        // ---------- Original Method ----------
        //if (!shouldPersist()) {
            //return defaultReturnValue;
        //}
        //return mPreferenceManager.getSharedPreferences().getInt(mKey, defaultReturnValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.062 -0400", hash_original_method = "554687CB7FDF3E22A2095D4942A8012F", hash_generated_method = "C04A7258AC5195A19F6A22635A777991")
    protected boolean persistFloat(float value) {
        {
            boolean var2ADBD6A37C43E8A998AE5217C3DE0D7C_824568701 = (shouldPersist());
            {
                {
                    boolean var5BA3946435CBD6AB81EDEDE75B77B581_540595297 = (value == getPersistedFloat(Float.NaN));
                } //End collapsed parenthetic
                SharedPreferences.Editor editor = mPreferenceManager.getEditor();
                editor.putFloat(mKey, value);
                tryCommit(editor);
            } //End block
        } //End collapsed parenthetic
        addTaint(value);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1630197673 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1630197673;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.062 -0400", hash_original_method = "AB28180DBEC7B1C710871982C247343B", hash_generated_method = "AC360DF5526817EB7D74C7F08A2972D2")
    protected float getPersistedFloat(float defaultReturnValue) {
        {
            boolean var55473E3F697E9E0994A85A68E07852AD_1504408141 = (!shouldPersist());
        } //End collapsed parenthetic
        float var3819A127749B4528B16EFCD41C31A62A_1524254096 = (mPreferenceManager.getSharedPreferences().getFloat(mKey, defaultReturnValue));
        addTaint(defaultReturnValue);
        float var546ADE640B6EDFBC8A086EF31347E768_2008658242 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_2008658242;
        // ---------- Original Method ----------
        //if (!shouldPersist()) {
            //return defaultReturnValue;
        //}
        //return mPreferenceManager.getSharedPreferences().getFloat(mKey, defaultReturnValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.063 -0400", hash_original_method = "C10CC879E3FA9306B83F34EDB87FCEA5", hash_generated_method = "0C975C3F7F7F9F1AC1117047B4306D48")
    protected boolean persistLong(long value) {
        {
            boolean var2ADBD6A37C43E8A998AE5217C3DE0D7C_1389663662 = (shouldPersist());
            {
                {
                    boolean varC2E3E3F618AD788AD311EBDC65EA0C3C_1680683106 = (value == getPersistedLong(~value));
                } //End collapsed parenthetic
                SharedPreferences.Editor editor = mPreferenceManager.getEditor();
                editor.putLong(mKey, value);
                tryCommit(editor);
            } //End block
        } //End collapsed parenthetic
        addTaint(value);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_408859304 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_408859304;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.063 -0400", hash_original_method = "88751F99C7941FFB817628D8E528076A", hash_generated_method = "3950FE9D1AAE20622B502499BE145351")
    protected long getPersistedLong(long defaultReturnValue) {
        {
            boolean var55473E3F697E9E0994A85A68E07852AD_1859122379 = (!shouldPersist());
        } //End collapsed parenthetic
        long var92DA105CE3001EF7BDE755DAFE24D62A_1580889793 = (mPreferenceManager.getSharedPreferences().getLong(mKey, defaultReturnValue));
        addTaint(defaultReturnValue);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_849540628 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_849540628;
        // ---------- Original Method ----------
        //if (!shouldPersist()) {
            //return defaultReturnValue;
        //}
        //return mPreferenceManager.getSharedPreferences().getLong(mKey, defaultReturnValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.064 -0400", hash_original_method = "D20BDAFE65F5D54A08F0A9EE0DEAC992", hash_generated_method = "7E950385FDFBD9511F0971868D5C4A12")
    protected boolean persistBoolean(boolean value) {
        {
            boolean var2ADBD6A37C43E8A998AE5217C3DE0D7C_1759349095 = (shouldPersist());
            {
                {
                    boolean varDA8CE2C0ADCE00323BB90806F37C4C6A_653789443 = (value == getPersistedBoolean(!value));
                } //End collapsed parenthetic
                SharedPreferences.Editor editor = mPreferenceManager.getEditor();
                editor.putBoolean(mKey, value);
                tryCommit(editor);
            } //End block
        } //End collapsed parenthetic
        addTaint(value);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1847585287 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1847585287;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.064 -0400", hash_original_method = "8F28A5D05D1E365FD2C0E61AA71BE94D", hash_generated_method = "D847EC8F2113E1ACAE1065DE5CB189D4")
    protected boolean getPersistedBoolean(boolean defaultReturnValue) {
        {
            boolean var55473E3F697E9E0994A85A68E07852AD_1722584196 = (!shouldPersist());
        } //End collapsed parenthetic
        boolean var1A496DFA26948F30715026809567A654_455973084 = (mPreferenceManager.getSharedPreferences().getBoolean(mKey, defaultReturnValue));
        addTaint(defaultReturnValue);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1140849169 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1140849169;
        // ---------- Original Method ----------
        //if (!shouldPersist()) {
            //return defaultReturnValue;
        //}
        //return mPreferenceManager.getSharedPreferences().getBoolean(mKey, defaultReturnValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.065 -0400", hash_original_method = "79DC631A87B79C35E44BC11E3C275CE7", hash_generated_method = "7728A1FD320787A5642AAD05AD5F321D")
     boolean hasSpecifiedLayout() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_566085355 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_566085355;
        // ---------- Original Method ----------
        //return mHasSpecifiedLayout;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.065 -0400", hash_original_method = "F82B18888AE588251FAAB1FF7696A001", hash_generated_method = "CEC3BE2A06FF1C4698F6C1F947DD8BB2")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_243698321 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_243698321 = getFilterableStringBuilder().toString();
        varB4EAC82CA7396A68D541C85D26508E83_243698321.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_243698321;
        // ---------- Original Method ----------
        //return getFilterableStringBuilder().toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.067 -0400", hash_original_method = "7FA40EC09188F6F1BEA3B1B94241EA4A", hash_generated_method = "C36FFB81E29E1511447289E7A056496F")
     StringBuilder getFilterableStringBuilder() {
        StringBuilder varB4EAC82CA7396A68D541C85D26508E83_100966702 = null; //Variable for return #1
        StringBuilder sb = new StringBuilder();
        CharSequence title = getTitle();
        {
            boolean var4315037A3FEAFB24D399CA884BFC6923_1551625064 = (!TextUtils.isEmpty(title));
            {
                sb.append(title).append(' ');
            } //End block
        } //End collapsed parenthetic
        CharSequence summary = getSummary();
        {
            boolean var7E93AF819D7D3BF2785B92F82525EC8F_1970861664 = (!TextUtils.isEmpty(summary));
            {
                sb.append(summary).append(' ');
            } //End block
        } //End collapsed parenthetic
        {
            boolean var0C7AF3C04C994C56893AB35D4EE77EAD_355774210 = (sb.length() > 0);
            {
                sb.setLength(sb.length() - 1);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_100966702 = sb;
        varB4EAC82CA7396A68D541C85D26508E83_100966702.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_100966702;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.068 -0400", hash_original_method = "363F8E8F58511FB925A751666AB900BD", hash_generated_method = "7455CF219436067B7A7A7067987A114F")
    public void saveHierarchyState(Bundle container) {
        dispatchSaveInstanceState(container);
        addTaint(container.getTaint());
        // ---------- Original Method ----------
        //dispatchSaveInstanceState(container);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.070 -0400", hash_original_method = "1B94F5D63E3EC8B47F4D750B8B09EC88", hash_generated_method = "19C4819F8F29429B38E498A29A008C5E")
     void dispatchSaveInstanceState(Bundle container) {
        {
            boolean var89872EF98F6C0EDCE9736F865AE6C3FC_1114242585 = (hasKey());
            {
                mBaseMethodCalled = false;
                Parcelable state = onSaveInstanceState();
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(
                        "Derived class did not call super.onSaveInstanceState()");
                } //End block
                {
                    container.putParcelable(mKey, state);
                } //End block
            } //End block
        } //End collapsed parenthetic
        addTaint(container.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.071 -0400", hash_original_method = "9DD945A60796B8A8FF01F94A77988BE6", hash_generated_method = "7EFDA5D7F6EE6E75327BB92D8C02A4B8")
    protected Parcelable onSaveInstanceState() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        Parcelable varB4EAC82CA7396A68D541C85D26508E83_854588851 = null; //Variable for return #1
        mBaseMethodCalled = true;
        varB4EAC82CA7396A68D541C85D26508E83_854588851 = BaseSavedState.EMPTY_STATE;
        varB4EAC82CA7396A68D541C85D26508E83_854588851.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_854588851;
        // ---------- Original Method ----------
        //mBaseMethodCalled = true;
        //return BaseSavedState.EMPTY_STATE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.071 -0400", hash_original_method = "D5A51A6B2B5A2D76F277782756F6ADE6", hash_generated_method = "078DFFA8AB69CDB75BA55FA2F4544E22")
    public void restoreHierarchyState(Bundle container) {
        dispatchRestoreInstanceState(container);
        addTaint(container.getTaint());
        // ---------- Original Method ----------
        //dispatchRestoreInstanceState(container);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.072 -0400", hash_original_method = "18F16B162844FF15C24BE293B1033BC4", hash_generated_method = "FC89A47C01C1E45C41ADA548D44114C0")
     void dispatchRestoreInstanceState(Bundle container) {
        {
            boolean var89872EF98F6C0EDCE9736F865AE6C3FC_565363288 = (hasKey());
            {
                Parcelable state = container.getParcelable(mKey);
                {
                    mBaseMethodCalled = false;
                    onRestoreInstanceState(state);
                    {
                        if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(
                            "Derived class did not call super.onRestoreInstanceState()");
                    } //End block
                } //End block
            } //End block
        } //End collapsed parenthetic
        addTaint(container.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.072 -0400", hash_original_method = "18B537C81357A7563BC62FF4E045FAEF", hash_generated_method = "8DE7060EAD75BF37A73AF8AE0F29D44F")
    protected void onRestoreInstanceState(Parcelable state) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mBaseMethodCalled = true;
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Wrong state class -- expecting Preference State");
        } //End block
        addTaint(state.getTaint());
        // ---------- Original Method ----------
        //mBaseMethodCalled = true;
        //if (state != BaseSavedState.EMPTY_STATE && state != null) {
            //throw new IllegalArgumentException("Wrong state class -- expecting Preference State");
        //}
    }

    
    public static class BaseSavedState extends AbsSavedState {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.073 -0400", hash_original_method = "0710B1BECA4AE2A64DE9C58BFD4A1161", hash_generated_method = "EE939DE64E4E13C6649033F638632686")
        public  BaseSavedState(Parcel source) {
            super(source);
            addTaint(source.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.073 -0400", hash_original_method = "C61013DFD638DC996F3EF4CC52F40C74", hash_generated_method = "E01D93B6DF9621DF15B2FA6FE9F6F642")
        public  BaseSavedState(Parcelable superState) {
            super(superState);
            addTaint(superState.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.073 -0400", hash_original_field = "F69D27D6C01716FC1482B26F47E53A23", hash_generated_field = "1603EC57FF7A24DE0B9CE75D44794F2A")

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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.073 -0400", hash_original_field = "FB0E8DE194A65EAF0D6B4D5E48723B17", hash_generated_field = "2E41574F494D78468755ADDE8E4C30A4")

    public static final int DEFAULT_ORDER = Integer.MAX_VALUE;
}

