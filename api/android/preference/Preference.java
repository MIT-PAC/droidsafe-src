package android.preference;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
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
import android.app.ContextImpl;

import com.android.internal.util.CharSequences;

public class Preference implements Comparable<Preference>, OnDependencyChangeListener {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.720 -0500", hash_original_field = "4E4404212112BADDA1CC62CB0E3D8ABF", hash_generated_field = "2E41574F494D78468755ADDE8E4C30A4")

    public static final int DEFAULT_ORDER = Integer.MAX_VALUE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.722 -0500", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.724 -0500", hash_original_field = "F44A9B2F698C7B96C36DE45B8F61794D", hash_generated_field = "13262EB3751B753EEB3302EF75D8B1E5")

    private PreferenceManager mPreferenceManager;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.726 -0500", hash_original_field = "52AFBBC2CD3BAB47936915EE533B9C32", hash_generated_field = "CF2A5FB7C7BB55BD451D113BD690151D")

    private long mId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.728 -0500", hash_original_field = "109327E014DA9E51667A6D43C3A98441", hash_generated_field = "B2CD75E86D570A2CCE7E2BC973BD4ACD")
    
    private OnPreferenceChangeListener mOnChangeListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.730 -0500", hash_original_field = "F4FC708BB66F0FF2E3CCB64DA416E3AE", hash_generated_field = "03339AEC23A0F6C8C8113E6F7DC55FB5")

    private OnPreferenceClickListener mOnClickListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.732 -0500", hash_original_field = "97665F9B90D8994894F926AD6A1AFAE9", hash_generated_field = "4DBBABE4B5343924D877A673E4358521")

    private int mOrder = DEFAULT_ORDER;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.734 -0500", hash_original_field = "8C445459F9A68BF8713F87AC9D695E47", hash_generated_field = "ECAB18871B55104BACD4283C12B1074D")

    private CharSequence mTitle;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.736 -0500", hash_original_field = "4D87313B2FBFDE7BBC10EEAFEA1B5715", hash_generated_field = "0BEE4780876F1B970FEA6B12663CC1C4")

    private int mTitleRes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.739 -0500", hash_original_field = "E53F2EE9A679B2409D0B47A0C2A283BA", hash_generated_field = "89C28E4357F1254876CE9020798E5A89")

    private CharSequence mSummary;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.741 -0500", hash_original_field = "9A6F2574D388B43CFE01999204187C31", hash_generated_field = "7DAEA4581257F07E76CD939CD24A2FD7")

    private int mIconResId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.743 -0500", hash_original_field = "D2DFC3A60DC024AFBB674A2D69ECB436", hash_generated_field = "FFB83F2A7C9A877B036AAEB7C21DDF6E")

    private Drawable mIcon;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.745 -0500", hash_original_field = "4666685C3669B68C1BDAE5D25D295D9D", hash_generated_field = "C36B21320914DA8259201FF07A2C068D")

    private String mKey;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.747 -0500", hash_original_field = "1811495D939DB843870F6315E04555CC", hash_generated_field = "5782C825DA3F61D408DF2DCA63E7F54A")

    private Intent mIntent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.749 -0500", hash_original_field = "DC41162A95551FFF3BEAE4E4BC8152ED", hash_generated_field = "F74F34FFBA0EE92FA7BFBACA55B63FEF")

    private String mFragment;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.751 -0500", hash_original_field = "8E33C9E28D87B1286C4160446ABF7B5C", hash_generated_field = "5596C79D633F3A9F64294D3BD6D43156")

    private Bundle mExtras;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.753 -0500", hash_original_field = "35AD8B69CCAB99ED75EF706EA5E75D7E", hash_generated_field = "8BBE5745FA7C6470C8EA4F0513877CD6")

    private boolean mEnabled = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.756 -0500", hash_original_field = "63B089730CCBB0244C1A83FC1343744B", hash_generated_field = "1A3F26BEC59143A828A7366C664C2B34")

    private boolean mSelectable = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.758 -0500", hash_original_field = "3F12A203168CC0F530E7B478DF34E03F", hash_generated_field = "24780C50494002A4AF74BE6D462BE687")

    private boolean mRequiresKey;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.760 -0500", hash_original_field = "8D3C973D6D660E3C76CFE628A28A1AC1", hash_generated_field = "27082D50DFDAA9191800D07F3AF15268")

    private boolean mPersistent = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.762 -0500", hash_original_field = "5F85BF803E1A8DF2225D5046C0F2A793", hash_generated_field = "B26344E1F3EABE836E6724009E62D614")

    private String mDependencyKey;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.764 -0500", hash_original_field = "766D0FBDF263CD004A630EA0AE6671C7", hash_generated_field = "42900AC295F63E9B792D05C2A7334252")

    private Object mDefaultValue;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.766 -0500", hash_original_field = "32EF4C66E3A70C5AB0D44EBE07B9DFBD", hash_generated_field = "BEDE89D1CA2E56235E886F0A2A60132A")

    private boolean mDependencyMet = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.768 -0500", hash_original_field = "9DCFA82C04B798A76956CB4C371E533F", hash_generated_field = "76B9F6CF747E54F39C22CAC52291B4CD")

    private boolean mShouldDisableView = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.770 -0500", hash_original_field = "E4558ED1225E38531819A9EC48B8C136", hash_generated_field = "2628AFC967B4980D202AAA14C9F08E6C")
    
    private int mLayoutResId = com.android.internal.R.layout.preference;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.772 -0500", hash_original_field = "4AC3CA97CE19C44928B883B97A51E139", hash_generated_field = "03CE89F32EE4B5097448BE77263408B4")

    private int mWidgetLayoutResId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.774 -0500", hash_original_field = "E593D6E36D3F9E06DB865C7FBBCDCDE7", hash_generated_field = "37581EC71ABDA9DF6D14233378E40DCE")

    private boolean mHasSpecifiedLayout = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.776 -0500", hash_original_field = "211CC0C05C9CD7BEB76E30B2F3EE9682", hash_generated_field = "AC60A661DDD5C1ADBF7F01BD463F7E24")
    
    private OnPreferenceChangeInternalListener mListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.778 -0500", hash_original_field = "C5F654B79522D99E090B49A6FA824C31", hash_generated_field = "B4077C41DC030C953102067792AA61E0")
    
    private List<Preference> mDependents;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.780 -0500", hash_original_field = "9D46E1ABF6612B5F9CED8668A15F4930", hash_generated_field = "5E4C3692572C298E63D6463802841D4E")
    
    private boolean mBaseMethodCalled;

    /**
     * Perform inflation from XML and apply a class-specific base style. This
     * constructor of Preference allows subclasses to use their own base
     * style when they are inflating. For example, a {@link CheckBoxPreference}
     * constructor calls this version of the super class constructor and
     * supplies {@code android.R.attr.checkBoxPreferenceStyle} for <var>defStyle</var>.
     * This allows the theme's checkbox preference style to modify all of the base
     * preference attributes as well as the {@link CheckBoxPreference} class's
     * attributes.
     * 
     * @param context The Context this is associated with, through which it can
     *            access the current theme, resources, {@link SharedPreferences},
     *            etc.
     * @param attrs The attributes of the XML tag that is inflating the preference.
     * @param defStyle The default style to apply to this preference. If 0, no style
     *            will be applied (beyond what is included in the theme). This
     *            may either be an attribute resource, whose value will be
     *            retrieved from the current theme, or an explicit style
     *            resource.
     * @see #Preference(Context, AttributeSet)
     */
    @DSComment("data structure only")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.791 -0500", hash_original_method = "9CEB9C34CAA8ECAB230B50A0542D61B3", hash_generated_method = "000D059B42087389D9BE4CD3D6DCF262")
    
public Preference(Context context, AttributeSet attrs, int defStyle) {
        mContext = context;

        TypedArray a = context.obtainStyledAttributes(attrs,
                com.android.internal.R.styleable.Preference, defStyle, 0);
        for (int i = a.getIndexCount(); i >= 0; i--) {
            int attr = a.getIndex(i); 
            switch (attr) {
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
        }
        a.recycle();

        if (!getClass().getName().startsWith("android.preference")) {
            // For subclasses not in this package, assume the worst and don't cache views
            mHasSpecifiedLayout = true;
        }
    }
    
    /**
     * Constructor that is called when inflating a Preference from XML. This is
     * called when a Preference is being constructed from an XML file, supplying
     * attributes that were specified in the XML file. This version uses a
     * default style of 0, so the only attribute values applied are those in the
     * Context's Theme and the given AttributeSet.
     * 
     * @param context The Context this is associated with, through which it can
     *            access the current theme, resources, {@link SharedPreferences},
     *            etc.
     * @param attrs The attributes of the XML tag that is inflating the
     *            preference.
     * @see #Preference(Context, AttributeSet, int)
     */
    @DSComment("data structure only")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.794 -0500", hash_original_method = "48043D3D24F48A6FD06B47A9624983D0", hash_generated_method = "23860A147BB626AC23BB2A2C8C09CC36")
    
public Preference(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.preferenceStyle);
    }

    /**
     * Constructor to create a Preference.
     * 
     * @param context The Context in which to store Preference values.
     */
    @DSComment("data structure only")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.796 -0500", hash_original_method = "B50FF766B3A35A641C8DC6BF5214AE70", hash_generated_method = "18004333E93059D421AF667C5C189CC7")
    
public Preference(Context context) {
        this(context, null);
    }

    /**
     * Called when a Preference is being inflated and the default value
     * attribute needs to be read. Since different Preference types have
     * different value types, the subclass should get and return the default
     * value which will be its value type.
     * <p>
     * For example, if the value type is String, the body of the method would
     * proxy to {@link TypedArray#getString(int)}.
     * 
     * @param a The set of attributes.
     * @param index The index of the default value attribute.
     * @return The default value of this preference type.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.798 -0500", hash_original_method = "75C2469AD4E7F0A9F01D294D0E9B9A83", hash_generated_method = "5FAF95615287C19A61F13B87DB38C656")
    @DSVerified("callback modeled")
    @DSSafe(DSCat.ANDROID_CALLBACK)
protected Object onGetDefaultValue(TypedArray a, int index) {
        return null;
    }
    
    /**
     * Sets an {@link Intent} to be used for
     * {@link Context#startActivity(Intent)} when this Preference is clicked.
     * 
     * @param intent The intent associated with this Preference.
     */
    @DSComment("Potential intent to trigger other processing")
    @DSSpec(DSCat.INTENT_EXCHANGE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.800 -0500", hash_original_method = "BB18D5EDF68F7EDDF74E48FAF30F475E", hash_generated_method = "E43DA065A725F698C123B5D95D83823C")
    
public void setIntent(Intent intent) {
        mIntent = intent;
    }
    
    /**
     * Return the {@link Intent} associated with this Preference.
     * 
     * @return The {@link Intent} last set via {@link #setIntent(Intent)} or XML. 
     */
    @DSComment("Potential intent to trigger other processing")
    @DSSpec(DSCat.INTENT_EXCHANGE)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.802 -0500", hash_original_method = "AD027B7B58A4A2F151CC138FB7B23244", hash_generated_method = "7CE6D2E5920E17BB1B744A5090D635BC")
    
public Intent getIntent() {
        return mIntent;
    }

    /**
     * Sets the class name of a fragment to be shown when this Preference is clicked.
     *
     * @param fragment The class name of the fragment associated with this Preference.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.805 -0500", hash_original_method = "B84A292EE370DC034681ED1A5B514CE4", hash_generated_method = "C105CC88961CED674DD5AFD11BC30F3C")
    
public void setFragment(String fragment) {
        mFragment = fragment;
    }

    /**
     * Return the fragment class name associated with this Preference.
     *
     * @return The fragment class name last set via {@link #setFragment} or XML.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.807 -0500", hash_original_method = "133D42C98C64EF6757CE3D375E2E1FA7", hash_generated_method = "48BD9FA22DC9C706CFE51067C173AE37")
    
public String getFragment() {
        return mFragment;
    }

    /**
     * Return the extras Bundle object associated with this preference, creating
     * a new Bundle if there currently isn't one.  You can use this to get and
     * set individual extra key/value pairs.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.809 -0500", hash_original_method = "F77D5C181034415714B081995209DE64", hash_generated_method = "AD974921E74D2D2EF84D10B8C4570AB3")
    
public Bundle getExtras() {
        if (mExtras == null) {
            mExtras = new Bundle();
        }
        return mExtras;
    }

    /**
     * Return the extras Bundle object associated with this preference,
     * returning null if there is not currently one.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.811 -0500", hash_original_method = "06728B07006932C3BCF42D880B54A6CC", hash_generated_method = "EBEDD00EEA1B6D14E4379FB3A1775458")
    
public Bundle peekExtras() {
        return mExtras;
    }

    /**
     * Sets the layout resource that is inflated as the {@link View} to be shown
     * for this Preference. In most cases, the default layout is sufficient for
     * custom Preference objects and only the widget layout needs to be changed.
     * <p>
     * This layout should contain a {@link ViewGroup} with ID
     * {@link android.R.id#widget_frame} to be the parent of the specific widget
     * for this Preference. It should similarly contain
     * {@link android.R.id#title} and {@link android.R.id#summary}.
     * 
     * @param layoutResId The layout resource ID to be inflated and returned as
     *            a {@link View}.
     * @see #setWidgetLayoutResource(int)
     */
    @DSComment("data structure only")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.813 -0500", hash_original_method = "528C4C3ACF7780A9B6B960E406A0977A", hash_generated_method = "0B264C8E20F4ED3ABF3FD5A4D24DF0F1")
    
public void setLayoutResource(int layoutResId) {
        if (layoutResId != mLayoutResId) {
            // Layout changed
            mHasSpecifiedLayout = true;
        }

        mLayoutResId = layoutResId;
    }
    
    /**
     * Gets the layout resource that will be shown as the {@link View} for this Preference.
     * 
     * @return The layout resource ID.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.816 -0500", hash_original_method = "A2555092F113429083F033F36B8E024F", hash_generated_method = "FDE313E76D9F921BBA81E10B3B11308E")
    
public int getLayoutResource() {
        return mLayoutResId;
    }
    
    /**
     * Sets The layout for the controllable widget portion of this Preference. This
     * is inflated into the main layout. For example, a {@link CheckBoxPreference}
     * would specify a custom layout (consisting of just the CheckBox) here,
     * instead of creating its own main layout.
     * 
     * @param widgetLayoutResId The layout resource ID to be inflated into the
     *            main layout.
     * @see #setLayoutResource(int)
     */
    @DSComment("data structure only")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.818 -0500", hash_original_method = "2204831C4D4DE968C9A72D9D306DDD8C", hash_generated_method = "1C5CAF5977AB804A1CDBD707DF56BB5B")
    
public void setWidgetLayoutResource(int widgetLayoutResId) {
        if (widgetLayoutResId != mWidgetLayoutResId) {
            // Layout changed
            mHasSpecifiedLayout = true;
        }
        mWidgetLayoutResId = widgetLayoutResId;
    }

    /**
     * Gets the layout resource for the controllable widget portion of this Preference.
     * 
     * @return The layout resource ID.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.820 -0500", hash_original_method = "6D000A2827FAFE2A1A87DD4A065ACF04", hash_generated_method = "EB11702AE005F39C88EDA3AA29841887")
    
public int getWidgetLayoutResource() {
        return mWidgetLayoutResId;
    }
    
    /**
     * Gets the View that will be shown in the {@link PreferenceActivity}.
     * 
     * @param convertView The old View to reuse, if possible. Note: You should
     *            check that this View is non-null and of an appropriate type
     *            before using. If it is not possible to convert this View to
     *            display the correct data, this method can create a new View.
     * @param parent The parent that this View will eventually be attached to.
     * @return Returns the same Preference object, for chaining multiple calls
     *         into a single statement.
     * @see #onCreateView(ViewGroup)
     * @see #onBindView(View)
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.822 -0500", hash_original_method = "10F5B4A945AE227B9B33457223123B2A", hash_generated_method = "DAA4ED66700C6E6E567467C24C079A20")
    @DSSpec(DSCat.SPEC_OTHERS)
    @DSComment("view inflatiion may have info gap")
    @DSVerified
public View getView(View convertView, ViewGroup parent) {
        // this is the beginning of alll callback
        if (convertView == null) {
            convertView = onCreateView(parent);
        }
        onBindView(convertView);

        TypedArray t = new TypedArray(DSOnlyType.NOT_USED);
        onGetDefaultValue(t, DSUtils.FAKE_INT);
        
        onClick();
        onAttachedToActivity();
        onAttachedToHierarchy(mPreferenceManager);
        onKey(convertView,  DSUtils.FAKE_INT, new KeyEvent());

        onDependencyChanged(mDependents.get(0), DSUtils.UNKNOWN_BOOLEAN);
        Parcelable state = onSaveInstanceState();
        if (state != null)
            onRestoreInstanceState(state);

        // call perform click

        return convertView;
    }
    
    /**
     * Creates the View to be shown for this Preference in the
     * {@link PreferenceActivity}. The default behavior is to inflate the main
     * layout of this Preference (see {@link #setLayoutResource(int)}. If
     * changing this behavior, please specify a {@link ViewGroup} with ID
     * {@link android.R.id#widget_frame}.
     * <p>
     * Make sure to call through to the superclass's implementation.
     * 
     * @param parent The parent that this View will eventually be attached to.
     * @return The View that displays this Preference.
     * @see #onBindView(View)
     */
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.825 -0500", hash_original_method = "DD0E6DF051F4F0779DD2D5F6BCD064A5", hash_generated_method = "C02ED4A6CFE31824138A3968323BAB68")
    
protected View onCreateView(ViewGroup parent) {
        final LayoutInflater layoutInflater =
            (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        
        final View layout = layoutInflater.inflate(mLayoutResId, parent, false);
        
        final ViewGroup widgetFrame = (ViewGroup) layout
                .findViewById(com.android.internal.R.id.widget_frame);
        if (widgetFrame != null) {
            if (mWidgetLayoutResId != 0) {
                layoutInflater.inflate(mWidgetLayoutResId, widgetFrame);
            } else {
                widgetFrame.setVisibility(View.GONE);
            }
        }
        return layout;
    }
    
    /**
     * Binds the created View to the data for this Preference.
     * <p>
     * This is a good place to grab references to custom Views in the layout and
     * set properties on them.
     * <p>
     * Make sure to call through to the superclass's implementation.
     * 
     * @param view The View that shows this Preference.
     * @see #onCreateView(ViewGroup)
     */
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.828 -0500", hash_original_method = "D65593443BAE954E876A7311E3E1909A", hash_generated_method = "2049DCCD9868B9DF313E0ACA1A095BF8")
    
protected void onBindView(View view) {
        TextView textView = (TextView) view.findViewById(com.android.internal.R.id.title); 
        if (textView != null) {
            textView.setText(getTitle());
        }
        
        textView = (TextView) view.findViewById(com.android.internal.R.id.summary);
        if (textView != null) {
            final CharSequence summary = getSummary();
            if (!TextUtils.isEmpty(summary)) {
                if (textView.getVisibility() != View.VISIBLE) {
                    textView.setVisibility(View.VISIBLE);
                }
                
                textView.setText(getSummary());
            } else {
                if (textView.getVisibility() != View.GONE) {
                    textView.setVisibility(View.GONE);
                }
            }
        }
        
        ImageView imageView = (ImageView) view.findViewById(com.android.internal.R.id.icon);
        if (imageView != null) {
            if (mIconResId != 0 || mIcon != null) {
                if (mIcon == null) {
                    mIcon = getContext().getResources().getDrawable(mIconResId);
                }
                if (mIcon != null) {
                    imageView.setImageDrawable(mIcon);
                }
            }
            imageView.setVisibility(mIcon != null ? View.VISIBLE : View.GONE);
        }

        if (mShouldDisableView) {
            setEnabledStateOnViews(view, isEnabled());
        }
    }

    /**
     * Makes sure the view (and any children) get the enabled state changed.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.831 -0500", hash_original_method = "4F80205B57D5838ADEC212DC6CB9E651", hash_generated_method = "927C7F20453A790234AEE493780B3522")
    
private void setEnabledStateOnViews(View v, boolean enabled) {
        v.setEnabled(enabled);
        
        if (v instanceof ViewGroup) {
            final ViewGroup vg = (ViewGroup) v;
            for (int i = vg.getChildCount() - 1; i >= 0; i--) {
                setEnabledStateOnViews(vg.getChildAt(i), enabled);
            }
        }
    }
    
    /**
     * Sets the order of this Preference with respect to other
     * Preference objects on the same level. If this is not specified, the
     * default behavior is to sort alphabetically. The
     * {@link PreferenceGroup#setOrderingAsAdded(boolean)} can be used to order
     * Preference objects based on the order they appear in the XML.
     * 
     * @param order The order for this Preference. A lower value will be shown
     *            first. Use {@link #DEFAULT_ORDER} to sort alphabetically or
     *            allow ordering from XML.
     * @see PreferenceGroup#setOrderingAsAdded(boolean)
     * @see #DEFAULT_ORDER
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.833 -0500", hash_original_method = "84974F9AFFF82527B4C714348BF0B3DB", hash_generated_method = "313052F087D27970DCF19B4D042C9FC3")
    
public void setOrder(int order) {
        if (order != mOrder) {
            mOrder = order;

            // Reorder the list 
            notifyHierarchyChanged();
        }
    }
    
    /**
     * Gets the order of this Preference with respect to other Preference objects
     * on the same level.
     * 
     * @return The order of this Preference.
     * @see #setOrder(int)
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.835 -0500", hash_original_method = "BE8C43C510B8AF8546FEBBAA3EF0F0B1", hash_generated_method = "1910514B82CFF79E9C692B005D1B90F5")
    
public int getOrder() {
        return mOrder;
    }

    /**
     * Sets the title for this Preference with a CharSequence. 
     * This title will be placed into the ID
     * {@link android.R.id#title} within the View created by
     * {@link #onCreateView(ViewGroup)}.
     * 
     * @param title The title for this Preference.
     */
    @DSComment("data structure only")
    @DSSpec(DSCat.SPEC_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.837 -0500", hash_original_method = "B4BEC153E73D566AEC40ED844297CB0F", hash_generated_method = "284FCF2293D68D214B8F1E0343747F63")
    
public void setTitle(CharSequence title) {
        if (title == null && mTitle != null || title != null && !title.equals(mTitle)) {
            mTitleRes = 0;
            mTitle = title;
            notifyChanged();
        }
    }
    
    /**
     * Sets the title for this Preference with a resource ID. 
     * 
     * @see #setTitle(CharSequence)
     * @param titleResId The title as a resource ID.
     */
    @DSComment("data structure only")
    @DSSpec(DSCat.SPEC_OTHERS)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.839 -0500", hash_original_method = "4E4A93A9A53A92BE0779D6D57BF6863D", hash_generated_method = "33703268DB5598045A51C7BA745C2ABE")
    
public void setTitle(int titleResId) {
        setTitle(mContext.getString(titleResId));
        mTitleRes = titleResId;
    }
    
    /**
     * Returns the title resource ID of this Preference.  If the title did
     * not come from a resource, 0 is returned.
     *
     * @return The title resource.
     * @see #setTitle(int)
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.841 -0500", hash_original_method = "9778C1A15B3D4EC3FC935EB49323C011", hash_generated_method = "B69AF063920EC97F42893C35BA0013BF")
    
public int getTitleRes() {
        return mTitleRes;
    }

    /**
     * Returns the title of this Preference.
     * 
     * @return The title.
     * @see #setTitle(CharSequence)
     */
    @DSComment("data structure only")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.843 -0500", hash_original_method = "7D691BCB64236E7B5AF8F6CB0399C091", hash_generated_method = "E948C46F1704FC1F24545ED5A725BEE6")
    
public CharSequence getTitle() {
        return mTitle;
    }

    /**
     * Sets the icon for this Preference with a Drawable. 
     * This icon will be placed into the ID
     * {@link android.R.id#icon} within the View created by
     * {@link #onCreateView(ViewGroup)}.
     * 
     * @param icon The optional icon for this Preference.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.846 -0500", hash_original_method = "3511105857431430BED74F970B043B64", hash_generated_method = "F41D3884CDBAE6E0DBED1052D6A5FA79")
    
public void setIcon(Drawable icon) {
        if ((icon == null && mIcon != null) || (icon != null && mIcon != icon)) {
            mIcon = icon;

            notifyChanged();
        }
    }

    /**
     * Sets the icon for this Preference with a resource ID. 
     * 
     * @see #setIcon(Drawable)
     * @param iconResId The icon as a resource ID.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.848 -0500", hash_original_method = "42E5A2AC84ED127F39E187697447AF4F", hash_generated_method = "DD8E40B070FB5944B3E9BB9C98CD66E7")
    
public void setIcon(int iconResId) {
        mIconResId = iconResId;
        setIcon(mContext.getResources().getDrawable(iconResId));
    }

    /**
     * Returns the icon of this Preference.
     * 
     * @return The icon.
     * @see #setIcon(Drawable)
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.850 -0500", hash_original_method = "ED78DC4ED6B2C6A65EDA3016CC1C1C4D", hash_generated_method = "6C812A8AFFF88933D7DE0B3F72902750")
    
public Drawable getIcon() {
        return mIcon;
    }

    /**
     * Returns the summary of this Preference.
     * 
     * @return The summary.
     * @see #setSummary(CharSequence)
     */
    @DSComment("data structure only")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.852 -0500", hash_original_method = "485EE2482F168D23B57BE8096AF663D1", hash_generated_method = "677F753FFE8DC3E647B643F7E060A784")
    
public CharSequence getSummary() {
        return mSummary;
    }

    /**
     * Sets the summary for this Preference with a CharSequence. 
     * 
     * @param summary The summary for the preference.
     */
    @DSComment("data structure only")
    @DSSpec(DSCat.SPEC_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.854 -0500", hash_original_method = "9397E34A85A0111B42F6FFB9A2837DEB", hash_generated_method = "473E4AE991A26B165213F8390D5E8AF8")
    @DSVerified
public void setSummary(CharSequence summary) {
        if (summary == null && mSummary != null || summary != null && !summary.equals(mSummary)) {
            mSummary = summary;
            notifyChanged();
        }
    }

    /**
     * Sets the summary for this Preference with a resource ID. 
     * 
     * @see #setSummary(CharSequence)
     * @param summaryResId The summary as a resource.
     */
    @DSComment("data structure only")
    @DSSpec(DSCat.SPEC_OTHERS)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.856 -0500", hash_original_method = "7AEFEE5A5E2C81392912FC13D133C130", hash_generated_method = "5E42DB8EFDCE67E38657239ACF0C48B4")
    
public void setSummary(int summaryResId) {
        setSummary(mContext.getString(summaryResId));
    }
    
    /**
     * Sets whether this Preference is enabled. If disabled, it will
     * not handle clicks.
     * 
     * @param enabled Set true to enable it.
     */
    @DSComment("data structure only")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.858 -0500", hash_original_method = "86021B1A0572E898D2D9C9D290D998FE", hash_generated_method = "FA9F63693562FFB49973E403F14AB0DB")
    
public void setEnabled(boolean enabled) {
        if (mEnabled != enabled) {
            mEnabled = enabled;

            // Enabled state can change dependent preferences' states, so notify
            notifyDependencyChange(shouldDisableDependents());

            notifyChanged();
        }
    }
    
    /**
     * Checks whether this Preference should be enabled in the list.
     * 
     * @return True if this Preference is enabled, false otherwise.
     */
    @DSComment("data structure only")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.860 -0500", hash_original_method = "1BB77BECC2C1296C251576AD714A96C1", hash_generated_method = "018EE9CBA359FF017D55A2A512F7D1DB")
    
public boolean isEnabled() {
        return mEnabled && mDependencyMet;
    }

    /**
     * Sets whether this Preference is selectable.
     * 
     * @param selectable Set true to make it selectable.
     */
    @DSComment("data structure only")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.862 -0500", hash_original_method = "7EEA4953639C86CA9F36ABED9565FC6D", hash_generated_method = "4990506D4E6F7CDBADB4A361C356D63C")
    
public void setSelectable(boolean selectable) {
        if (mSelectable != selectable) {
            mSelectable = selectable;
            notifyChanged();
        }
    }
    
    /**
     * Checks whether this Preference should be selectable in the list.
     * 
     * @return True if it is selectable, false otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.864 -0500", hash_original_method = "A1A8E91E60B51F4951583D0866634B48", hash_generated_method = "E711BEA2EEFDE3CD202F1BC33D402B11")
    
public boolean isSelectable() {
        return mSelectable;
    }

    /**
     * Sets whether this Preference should disable its view when it gets
     * disabled.
     * <p>
     * For example, set this and {@link #setEnabled(boolean)} to false for
     * preferences that are only displaying information and 1) should not be
     * clickable 2) should not have the view set to the disabled state.
     * 
     * @param shouldDisableView Set true if this preference should disable its view
     *            when the preference is disabled.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.867 -0500", hash_original_method = "97FCA568B4719676F3D4400812EA1F3A", hash_generated_method = "D8C76B41C653DBDA1D26FB8CE5214925")
    
public void setShouldDisableView(boolean shouldDisableView) {
        mShouldDisableView = shouldDisableView;
        notifyChanged();
    }
    
    /**
     * Checks whether this Preference should disable its view when it's action is disabled.
     * @see #setShouldDisableView(boolean)
     * @return True if it should disable the view. 
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.869 -0500", hash_original_method = "465C9050F708FCF1A73506501FE4644E", hash_generated_method = "74900F9D9BB1276C31D10EF468A92710")
    
public boolean getShouldDisableView() {
        return mShouldDisableView;
    }

    /**
     * Returns a unique ID for this Preference.  This ID should be unique across all
     * Preference objects in a hierarchy.
     * 
     * @return A unique ID for this Preference.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.871 -0500", hash_original_method = "6AF16C815DE6FE4144432EF99CDC825B", hash_generated_method = "6AF16C815DE6FE4144432EF99CDC825B")
    
long getId() {
        return mId;
    }
    
    /**
     * Processes a click on the preference. This includes saving the value to
     * the {@link SharedPreferences}. However, the overridden method should
     * call {@link #callChangeListener(Object)} to make sure the client wants to
     * update the preference's state with the new value.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.873 -0500", hash_original_method = "DE9BB9E40914727DA5D6E94159FAF3CB", hash_generated_method = "D330D7CED94953FD8C389AF42A43D4B3")
    @DSVerified("Calling callbacks ")
    @DSSafe(DSCat.ANDROID_CALLBACK)

protected void onClick() {
    }
    
    /**
     * Sets the key for this Preference, which is used as a key to the
     * {@link SharedPreferences}. This should be unique for the package.
     * 
     * @param key The key for the preference.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.876 -0500", hash_original_method = "46997BE6329912D9EC1174E4CE7CAB04", hash_generated_method = "4B3FBA1AB27D89A2788833692B73D61C")
    
public void setKey(String key) {
        mKey = key;
        
        if (mRequiresKey && !hasKey()) {
            requireKey();
        }
    }
    
    /**
     * Gets the key for this Preference, which is also the key used for storing
     * values into SharedPreferences.
     * 
     * @return The key.
     */
    @DSComment("data structure only")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.877 -0500", hash_original_method = "E0CEA0C6ABDC55C32B991C1D155B5E3E", hash_generated_method = "514BD3D6C2A52F2979AA1634D452B51C")
    
public String getKey() {
        return mKey;
    }
    
    /**
     * Checks whether the key is present, and if it isn't throws an
     * exception. This should be called by subclasses that store preferences in
     * the {@link SharedPreferences}.
     * 
     * @throws IllegalStateException If there is no key assigned.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.879 -0500", hash_original_method = "21702F9605A21EAEE85E66B458F985AA", hash_generated_method = "21702F9605A21EAEE85E66B458F985AA")
    
void requireKey() {
        if (mKey == null) {
            throw new IllegalStateException("Preference does not have a key assigned.");
        }
        
        mRequiresKey = true;
    }
    
    /**
     * Checks whether this Preference has a valid key.
     * 
     * @return True if the key exists and is not a blank string, false otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.881 -0500", hash_original_method = "3BC185E939D8CD84C5733E95D5330A61", hash_generated_method = "F5EB84AAEF6092AAF913E8893C679060")
    
public boolean hasKey() {
        return !TextUtils.isEmpty(mKey);
    }
    
    /**
     * Checks whether this Preference is persistent. If it is, it stores its value(s) into
     * the persistent {@link SharedPreferences} storage.
     * 
     * @return True if it is persistent.
     */
    @DSComment("data structure only")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.883 -0500", hash_original_method = "45C46AF35C2A296F9912D410933691CF", hash_generated_method = "7D1AC7F421553CAEC34BD93E0A58BCF7")
    
public boolean isPersistent() {
        return mPersistent;
    }
    
    /**
     * Checks whether, at the given time this method is called,
     * this Preference should store/restore its value(s) into the
     * {@link SharedPreferences}. This, at minimum, checks whether this
     * Preference is persistent and it currently has a key. Before you
     * save/restore from the {@link SharedPreferences}, check this first.
     * 
     * @return True if it should persist the value.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.885 -0500", hash_original_method = "E7579FEE83F4F133055197D69D72F289", hash_generated_method = "73F2DB172A59ED038CA8FA1EDAC629EE")
    
protected boolean shouldPersist() {
        return mPreferenceManager != null && isPersistent() && hasKey();
    }
    
    /**
     * Sets whether this Preference is persistent. When persistent,
     * it stores its value(s) into the persistent {@link SharedPreferences}
     * storage.
     * 
     * @param persistent Set true if it should store its value(s) into the {@link SharedPreferences}.
     */
    @DSComment("data structure only")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.887 -0500", hash_original_method = "9780EA334E29D2930E2D9A0F1CB4087F", hash_generated_method = "1BADDA72E3D941D0CD81C8195DF48043")
    
public void setPersistent(boolean persistent) {
        mPersistent = persistent;
    }
    
    /**
     * Call this method after the user changes the preference, but before the
     * internal state is set. This allows the client to ignore the user value.
     * 
     * @param newValue The new value of this Preference.
     * @return True if the user value should be set as the preference
     *         value (and persisted).
     */
    
    @DSVerified("Calling callbacks ")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.890 -0500", hash_original_method = "4367E5B2EAD1BB8898BD88F610DDAF7D", hash_generated_method = "1CFD0B3B4276F8625AC51F1A7A0055E7")
protected boolean callChangeListener(Object newValue) {
        if (mOnChangeListener != null)
            mOnChangeListener.onPreferenceChange(this, newValue);
        return mOnChangeListener == null ? true : mOnChangeListener.onPreferenceChange(this, newValue);
    }
    
    /**
     * Sets the callback to be invoked when this Preference is changed by the
     * user (but before the internal state has been updated).
     * 
     * @param onPreferenceChangeListener The callback to be invoked.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.892 -0500", hash_original_method = "D46636D80B7557AC6195A05902CC638C", hash_generated_method = "BA06CE8EF7CF6B97C6958AB95DB1DBCD")
    @DSVerified("Calling callbacks ")
    @DSSafe(DSCat.ANDROID_CALLBACK)
public void setOnPreferenceChangeListener(OnPreferenceChangeListener onPreferenceChangeListener) {
        mOnChangeListener = onPreferenceChangeListener;
        callChangeListener(new Object());
    }

    /**
     * Returns the callback to be invoked when this Preference is changed by the
     * user (but before the internal state has been updated).
     * 
     * @return The callback to be invoked.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.895 -0500", hash_original_method = "9CC8E5271070D42EF9628C47033D91A6", hash_generated_method = "ACB22011903346D3776D266A05EB6E61")
    
public OnPreferenceChangeListener getOnPreferenceChangeListener() {
        return mOnChangeListener;
    }

    /**
     * Sets the callback to be invoked when this Preference is clicked.
     * 
     * @param onPreferenceClickListener The callback to be invoked.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.897 -0500", hash_original_method = "E8A10745E179E2FA23FF715EAD4A5CB3", hash_generated_method = "F6CB66294636498CFCF630891808C4BE")
    @DSVerified("Calling callbacks ")
    @DSSafe(DSCat.ANDROID_CALLBACK)
public void setOnPreferenceClickListener(OnPreferenceClickListener onPreferenceClickListener) {
        mOnClickListener = onPreferenceClickListener;
        if (mOnClickListener != null) {
            mOnClickListener.onPreferenceClick(this);
        }
    }

    /**
     * Returns the callback to be invoked when this Preference is clicked.
     * 
     * @return The callback to be invoked.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.899 -0500", hash_original_method = "55E2C6999F7D889141550F7A68D36827", hash_generated_method = "3B8811B9DA0C5C217A65BEDF592D5CD9")
    
public OnPreferenceClickListener getOnPreferenceClickListener() {
        return mOnClickListener;
    }

    /**
     * Called when a click should be performed.
     * 
     * @param preferenceScreen A {@link PreferenceScreen} whose hierarchy click
     *            listener should be called in the proper order (between other
     *            processing). May be null.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.901 -0500", hash_original_method = "501E66F7BA58D6B4C7BCFDD2200CB13A", hash_generated_method = "501E66F7BA58D6B4C7BCFDD2200CB13A")
    @DSVerified 
void performClick(PreferenceScreen preferenceScreen) {
        
        if (!isEnabled()) {
            return;
        }
        
        onClick();
        
        if (mOnClickListener != null && mOnClickListener.onPreferenceClick(this)) {
            return;
        }
        
        PreferenceManager preferenceManager = getPreferenceManager();
        if (preferenceManager != null) {
            PreferenceManager.OnPreferenceTreeClickListener listener = preferenceManager
                    .getOnPreferenceTreeClickListener();
            if (preferenceScreen != null && listener != null
                    && listener.onPreferenceTreeClick(preferenceScreen, this)) {
                return;
            }
        }
        
        if (mIntent != null) {
            Context context = getContext();
            context.startActivity(mIntent);
        }
    }

    /**
     * Allows a Preference to intercept key events without having focus.
     * For example, SeekBarPreference uses this to intercept +/- to adjust
     * the progress.
     * @return True if the Preference handled the key. Returns false by default.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.903 -0500", hash_original_method = "089B06359A27CB6D952DCE596F00B787", hash_generated_method = "68EB02B4356EE3D596975C183984944E")
    
public boolean onKey(View v, int keyCode, KeyEvent event) {
        return false;
    }
    
    /**
     * Returns the {@link android.content.Context} of this Preference. 
     * Each Preference in a Preference hierarchy can be
     * from different Context (for example, if multiple activities provide preferences into a single
     * {@link PreferenceActivity}). This Context will be used to save the Preference values.
     * 
     * @return The Context of this Preference.
     */
    @DSComment("data structure only")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.905 -0500", hash_original_method = "4F4EBC54D108D66F416C93B46580E117", hash_generated_method = "BA026F6873AF9B17E96AB49AFB6CEE03")
    
public Context getContext() {
        return mContext;
    }
    
    /**
     * Returns the {@link SharedPreferences} where this Preference can read its
     * value(s). Usually, it's easier to use one of the helper read methods:
     * {@link #getPersistedBoolean(boolean)}, {@link #getPersistedFloat(float)},
     * {@link #getPersistedInt(int)}, {@link #getPersistedLong(long)},
     * {@link #getPersistedString(String)}. To save values, see
     * {@link #getEditor()}.
     * <p>
     * In some cases, writes to the {@link #getEditor()} will not be committed
     * right away and hence not show up in the returned
     * {@link SharedPreferences}, this is intended behavior to improve
     * performance.
     * 
     * @return The {@link SharedPreferences} where this Preference reads its
     *         value(s), or null if it isn't attached to a Preference hierarchy.
     * @see #getEditor()
     */
    @DSComment("data structure only")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.908 -0500", hash_original_method = "8BF68140BB0364C46F5E3D57D69A6DB5", hash_generated_method = "F09B3CE58B6C7368086BB1A9CBCCC878")
public SharedPreferences getSharedPreferences() {        
        return ContextImpl.getSharedPreferencesDS();
    }
    
    /**
     * Returns an {@link SharedPreferences.Editor} where this Preference can
     * save its value(s). Usually it's easier to use one of the helper save
     * methods: {@link #persistBoolean(boolean)}, {@link #persistFloat(float)},
     * {@link #persistInt(int)}, {@link #persistLong(long)},
     * {@link #persistString(String)}. To read values, see
     * {@link #getSharedPreferences()}. If {@link #shouldCommit()} returns
     * true, it is this Preference's responsibility to commit.
     * <p>
     * In some cases, writes to this will not be committed right away and hence
     * not show up in the SharedPreferences, this is intended behavior to
     * improve performance.
     * 
     * @return A {@link SharedPreferences.Editor} where this preference saves
     *         its value(s), or null if it isn't attached to a Preference
     *         hierarchy.
     * @see #shouldCommit()
     * @see #getSharedPreferences()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.910 -0500", hash_original_method = "59D9CBF7E4B6683DDFDC1DAE57ABD5B7", hash_generated_method = "214257F3F4D44AF988EC466FB21E85D7")
    
public SharedPreferences.Editor getEditor() {
        if (mPreferenceManager == null) {
            return null;
        }
        
        return mPreferenceManager.getEditor();
    }
    
    /**
     * Returns whether the {@link Preference} should commit its saved value(s) in
     * {@link #getEditor()}. This may return false in situations where batch
     * committing is being done (by the manager) to improve performance.
     * 
     * @return Whether the Preference should commit its saved value(s).
     * @see #getEditor()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.913 -0500", hash_original_method = "23B2B69F1B515A4430736566C100E20E", hash_generated_method = "FD2043780CE3E8BD5C3C2A600C0301EB")
    
public boolean shouldCommit() {
        if (mPreferenceManager == null) {
            return false;
        }
        
        return mPreferenceManager.shouldCommit();
    }
    
    /**
     * Compares Preference objects based on order (if set), otherwise alphabetically on the titles.
     * 
     * @param another The Preference to compare to this one.
     * @return 0 if the same; less than 0 if this Preference sorts ahead of <var>another</var>;
     *          greater than 0 if this Preference sorts after <var>another</var>.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.915 -0500", hash_original_method = "93B6E6EE30870726B108BD396B876DEB", hash_generated_method = "4693F5F7F58E9AEA61FD6671B80CFAC9")

    @DSVerified
    @DSSafe(DSCat.SAFE_OTHERS)
public int compareTo(Preference another) {
        if (mOrder != DEFAULT_ORDER
                || (mOrder == DEFAULT_ORDER && another.mOrder != DEFAULT_ORDER)) {
            // Do order comparison
            return mOrder - another.mOrder; 
        } else if (mTitle == null) {
            return 1;
        } else if (another.mTitle == null) {
            return -1;
        } else {
            // Do name comparison
            return CharSequences.compareToIgnoreCase(mTitle, another.mTitle);
        }
    }
    
    /**
     * Sets the internal change listener.
     * 
     * @param listener The listener.
     * @see #notifyChanged()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.918 -0500", hash_original_method = "6457E3944D02DD03B8855B0556ABBC63", hash_generated_method = "5BD7F1A6B80729281F6940D4EC369B4E")
    
final void setOnPreferenceChangeInternalListener(OnPreferenceChangeInternalListener listener) {
        mListener = listener;
    }

    /**
     * Should be called when the data of this {@link Preference} has changed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.920 -0500", hash_original_method = "BC518684C2B31AF5801BA48B18DD0A6B", hash_generated_method = "39739166712BA92309AB848E15A28EFD")
    
protected void notifyChanged() {
        if (mListener != null) {
            mListener.onPreferenceChange(this);
        }
    }
    
    /**
     * Should be called when a Preference has been
     * added/removed from this group, or the ordering should be
     * re-evaluated.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.922 -0500", hash_original_method = "B6CFA705B58CA125A61E30E547554AC9", hash_generated_method = "D3F60C66449DC8D09B5A7B8B447602C7")
    
protected void notifyHierarchyChanged() {
        if (mListener != null) {
            mListener.onPreferenceHierarchyChange(this);
        }
    }

    /**
     * Gets the {@link PreferenceManager} that manages this Preference object's tree.
     * 
     * @return The {@link PreferenceManager}.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.924 -0500", hash_original_method = "002FC5CEE5BE5B5D1FE36CEDBC1DEB65", hash_generated_method = "382F54BC2EA5B48270515EF5C19C4292")
    
public PreferenceManager getPreferenceManager() {
        return mPreferenceManager;
    }
    
    /**
     * Called when this Preference has been attached to a Preference hierarchy.
     * Make sure to call the super implementation.
     * 
     * @param preferenceManager The PreferenceManager of the hierarchy.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.926 -0500", hash_original_method = "664C21A1EBA456CB3BAFB18286851581", hash_generated_method = "12030FB157E824B47BF058F266AD832A")
    
protected void onAttachedToHierarchy(PreferenceManager preferenceManager) {
        mPreferenceManager = preferenceManager;
        
        mId = preferenceManager.getNextId();
        
        dispatchSetInitialValue();
    }
    
    /**
     * Called when the Preference hierarchy has been attached to the
     * {@link PreferenceActivity}. This can also be called when this
     * Preference has been attached to a group that was already attached
     * to the {@link PreferenceActivity}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.928 -0500", hash_original_method = "ECA501E201E2D5472D2CB3C64A16D61F", hash_generated_method = "9C4360C45FC8EE6262F66BA74D5BA02A")
    
protected void onAttachedToActivity() {
        // At this point, the hierarchy that this preference is in is connected
        // with all other preferences.
        registerDependency();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.931 -0500", hash_original_method = "A499F7D8BECEFF58ECE377DCDDB4C87B", hash_generated_method = "6A4AAE59A5BCE6D1D1581BA2E746C277")
    
private void registerDependency() {
        
        if (TextUtils.isEmpty(mDependencyKey)) return;
        
        Preference preference = findPreferenceInHierarchy(mDependencyKey);
        if (preference != null) {
            preference.registerDependent(this);
        } else {
            throw new IllegalStateException("Dependency \"" + mDependencyKey
                    + "\" not found for preference \"" + mKey + "\" (title: \"" + mTitle + "\"");
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.933 -0500", hash_original_method = "40F9072BE8C6932FEF31F09A7FFFCE04", hash_generated_method = "014DD8EE6C42FFC2AE2A8AC85D35A73F")
    
private void unregisterDependency() {
        if (mDependencyKey != null) {
            final Preference oldDependency = findPreferenceInHierarchy(mDependencyKey);
            if (oldDependency != null) {
                oldDependency.unregisterDependent(this);
            }
        }
    }
    
    /**
     * Finds a Preference in this hierarchy (the whole thing,
     * even above/below your {@link PreferenceScreen} screen break) with the given
     * key.
     * <p>
     * This only functions after we have been attached to a hierarchy.
     * 
     * @param key The key of the Preference to find.
     * @return The Preference that uses the given key.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.935 -0500", hash_original_method = "913C05EFD2CE9AD9CE3BED6394A14862", hash_generated_method = "A965F69A422EDFB5C0114CF1B9E6705C")
    
protected Preference findPreferenceInHierarchy(String key) {
        if (TextUtils.isEmpty(key) || mPreferenceManager == null) {
            return null;
        }
        
        return mPreferenceManager.findPreference(key);
    }
    
    /**
     * Adds a dependent Preference on this Preference so we can notify it.
     * Usually, the dependent Preference registers itself (it's good for it to
     * know it depends on something), so please use
     * {@link Preference#setDependency(String)} on the dependent Preference.
     * 
     * @param dependent The dependent Preference that will be enabled/disabled
     *            according to the state of this Preference.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.938 -0500", hash_original_method = "528DD85662997ACAED3BC519F97454B8", hash_generated_method = "CAB8415C08EBD2996AB8068BEAA482DB")
    
private void registerDependent(Preference dependent) {
        if (mDependents == null) {
            mDependents = new ArrayList<Preference>();
        }
        
        mDependents.add(dependent);
        
        dependent.onDependencyChanged(this, shouldDisableDependents());
    }
    
    /**
     * Removes a dependent Preference on this Preference.
     * 
     * @param dependent The dependent Preference that will be enabled/disabled
     *            according to the state of this Preference.
     * @return Returns the same Preference object, for chaining multiple calls
     *         into a single statement.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.940 -0500", hash_original_method = "9028FF718331F8BA1AAB10BD4FAE315E", hash_generated_method = "FBD9977817BB64523E2D3C725C556C6E")
    
private void unregisterDependent(Preference dependent) {
        if (mDependents != null) {
            mDependents.remove(dependent);
        }
    }
    
    /**
     * Notifies any listening dependents of a change that affects the
     * dependency.
     * 
     * @param disableDependents Whether this Preference should disable
     *            its dependents.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.942 -0500", hash_original_method = "02C347ADE8272FB6E630575816981A99", hash_generated_method = "3CD58C0767C66BB2C78AE785B9A4A21B")
    
public void notifyDependencyChange(boolean disableDependents) {
        final List<Preference> dependents = mDependents;
        
        if (dependents == null) {
            return;
        }
        
        final int dependentsCount = dependents.size();
        for (int i = 0; i < dependentsCount; i++) {
            dependents.get(i).onDependencyChanged(this, disableDependents);
        }
    }

    /**
     * Called when the dependency changes.
     * 
     * @param dependency The Preference that this Preference depends on.
     * @param disableDependent Set true to disable this Preference.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.944 -0500", hash_original_method = "E3DDA7BA2220D3A5C80FED1DB4754CB9", hash_generated_method = "FD07FC045E8BA421A929994C7B115562")
    
public void onDependencyChanged(Preference dependency, boolean disableDependent) {
        if (mDependencyMet == disableDependent) {
            mDependencyMet = !disableDependent;

            // Enabled state can change dependent preferences' states, so notify
            notifyDependencyChange(shouldDisableDependents());

            notifyChanged();
        }
    }
    
    /**
     * Checks whether this preference's dependents should currently be
     * disabled.
     * 
     * @return True if the dependents should be disabled, otherwise false.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.947 -0500", hash_original_method = "88055BCA041292961DE741A16807A2A3", hash_generated_method = "BD87AB889527078E03AAACD74D0E0C60")
    
public boolean shouldDisableDependents() {
        return !isEnabled();
    }
    
    /**
     * Sets the key of a Preference that this Preference will depend on. If that
     * Preference is not set or is off, this Preference will be disabled.
     * 
     * @param dependencyKey The key of the Preference that this depends on.
     */
    @DSComment("data structure only")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.949 -0500", hash_original_method = "FBFB05D545147227A8E2F6FCFC356242", hash_generated_method = "EB89BD73E9FDB2DD6ECAD76363778369")
    
public void setDependency(String dependencyKey) {
        // Unregister the old dependency, if we had one
        unregisterDependency();
        
        // Register the new
        mDependencyKey = dependencyKey;
        registerDependency();
    }
    
    /**
     * Returns the key of the dependency on this Preference.
     * 
     * @return The key of the dependency.
     * @see #setDependency(String)
     */
    @DSComment("data structure only")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.951 -0500", hash_original_method = "664EA11E01CF3C90DB639CBF1F232407", hash_generated_method = "0A8A561C4DC78501D4E9364ECA5686F1")
    
public String getDependency() {
        return mDependencyKey;
    }
    
    /**
     * Called when this Preference is being removed from the hierarchy. You
     * should remove any references to this Preference that you know about. Make
     * sure to call through to the superclass implementation.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.953 -0500", hash_original_method = "590B71B1265EC6EEA43053FD50985818", hash_generated_method = "03747D58F70575C6C99809DC29CDC973")
    
protected void onPrepareForRemoval() {
        unregisterDependency();
    }
    
    /**
     * Sets the default value for this Preference, which will be set either if
     * persistence is off or persistence is on and the preference is not found
     * in the persistent storage.
     * 
     * @param defaultValue The default value.
     */
    @DSComment("data structure only")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.955 -0500", hash_original_method = "EC5991F73564EC767E73B865F0A17074", hash_generated_method = "32F2679AD66EFBC2B9E7D62D9292FDAA")
    
public void setDefaultValue(Object defaultValue) {
        mDefaultValue = defaultValue;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.957 -0500", hash_original_method = "0CC9C8053B2B40671F6785C5B066E9AB", hash_generated_method = "C405D37DC7D423BFB814F9AFC5337F82")
    @DSVerified 
private void dispatchSetInitialValue() {
        // By now, we know if we are persistent.
        final boolean shouldPersist = shouldPersist();
        if (!shouldPersist || !getSharedPreferences().contains(mKey)) {
            if (mDefaultValue != null) {
                onSetInitialValue(false, mDefaultValue);
            }
        } else {
            onSetInitialValue(true, null);
        }
    }
    
    /**
     * Implement this to set the initial value of the Preference. 
     * <p>
     * If <var>restorePersistedValue</var> is true, you should restore the 
     * Preference value from the {@link android.content.SharedPreferences}. If 
     * <var>restorePersistedValue</var> is false, you should set the Preference 
     * value to defaultValue that is given (and possibly store to SharedPreferences 
     * if {@link #shouldPersist()} is true).
     * <p>
     * This may not always be called. One example is if it should not persist
     * but there is no default value given.
     * 
     * @param restorePersistedValue True to restore the persisted value;
     *            false to use the given <var>defaultValue</var>.
     * @param defaultValue The default value for this Preference. Only use this
     *            if <var>restorePersistedValue</var> is false.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.959 -0500", hash_original_method = "8C28678F9AE41A1BF1FA484A48C7C6F8", hash_generated_method = "CDAA1182649AE7EF752DA4B292F88D59")
    
protected void onSetInitialValue(boolean restorePersistedValue, Object defaultValue) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.961 -0500", hash_original_method = "22CEE8BE8E503CA7A500DF872E2100EC", hash_generated_method = "9370D9A683F4FD45B9CCED83CF629165")
    
private void tryCommit(SharedPreferences.Editor editor) {
        if (mPreferenceManager.shouldCommit()) {
            try {
                editor.apply();
            } catch (AbstractMethodError unused) {
                // The app injected its own pre-Gingerbread
                // SharedPreferences.Editor implementation without
                // an apply method.
                editor.commit();
            }
        }
    }
    
    /**
     * Attempts to persist a String to the {@link android.content.SharedPreferences}.
     * <p>
     * This will check if this Preference is persistent, get an editor from
     * the {@link PreferenceManager}, put in the string, and check if we should commit (and
     * commit if so).
     * 
     * @param value The value to persist.
     * @return True if the Preference is persistent. (This is not whether the
     *         value was persisted, since we may not necessarily commit if there
     *         will be a batch commit later.)
     * @see #getPersistedString(String)
     */
    @DSComment("store string")
    @DSSpec(DSCat.SPEC_OTHERS)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.964 -0500", hash_original_method = "386F50F42D6EB5DC2DA2887FAD5D9C7B", hash_generated_method = "9B5C087D3CC87E17EBE1A4FFD846B271")
    @DSVerified
protected boolean persistString(String value) {
        if (shouldPersist()) {
            // Shouldn't store null
            if (value == getPersistedString(null)) {
                // It's already there, so the same as persisting
                return true;
            }
            
            SharedPreferences.Editor editor = mPreferenceManager.getEditor();
            editor.putString(mKey, value);
            tryCommit(editor);
            return true;
        }
        return false;
    }
    
    /**
     * Attempts to get a persisted String from the {@link android.content.SharedPreferences}.
     * <p>
     * This will check if this Preference is persistent, get the SharedPreferences
     * from the {@link PreferenceManager}, and get the value.
     * 
     * @param defaultReturnValue The default value to return if either the
     *            Preference is not persistent or the Preference is not in the
     *            shared preferences.
     * @return The value from the SharedPreferences or the default return
     *         value.
     * @see #persistString(String)
     */
    @DSComment("Get some persisted string")
    @DSSpec(DSCat.SPEC_OTHERS)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.967 -0500", hash_original_method = "5E73C8E580A094A1DF5E2EFDD3570FC9", hash_generated_method = "E35762D31C01EBAE27AC52B743D4B6E5")
    @DSVerified
protected String getPersistedString(String defaultReturnValue) {
        if (!shouldPersist()) {
            return defaultReturnValue;
        }
        
        return mPreferenceManager.getSharedPreferences().getString(mKey, defaultReturnValue);
    }
    
    /**
     * Attempts to persist a set of Strings to the {@link android.content.SharedPreferences}.
     * <p>
     * This will check if this Preference is persistent, get an editor from
     * the {@link PreferenceManager}, put in the strings, and check if we should commit (and
     * commit if so).
     * 
     * @param values The values to persist.
     * @return True if the Preference is persistent. (This is not whether the
     *         value was persisted, since we may not necessarily commit if there
     *         will be a batch commit later.)
     * @see #getPersistedString(Set)
     * 
     * @hide Pending API approval
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.969 -0500", hash_original_method = "48F776762148447BA8C6A8C97BA6FE15", hash_generated_method = "746171C716452CF495F875DD15A025AB")
    
protected boolean persistStringSet(Set<String> values) {
        if (shouldPersist()) {
            // Shouldn't store null
            if (values.equals(getPersistedStringSet(null))) {
                // It's already there, so the same as persisting
                return true;
            }
            
            SharedPreferences.Editor editor = mPreferenceManager.getEditor();
            editor.putStringSet(mKey, values);
            tryCommit(editor);
            return true;
        }
        return false;
    }

    /**
     * Attempts to get a persisted set of Strings from the
     * {@link android.content.SharedPreferences}.
     * <p>
     * This will check if this Preference is persistent, get the SharedPreferences
     * from the {@link PreferenceManager}, and get the value.
     * 
     * @param defaultReturnValue The default value to return if either the
     *            Preference is not persistent or the Preference is not in the
     *            shared preferences.
     * @return The value from the SharedPreferences or the default return
     *         value.
     * @see #persistStringSet(Set)
     * 
     * @hide Pending API approval
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.971 -0500", hash_original_method = "D996103FD4641487F9C96461E983EA55", hash_generated_method = "9D17569A567BB978CC9AF1A28894AB12")
    
protected Set<String> getPersistedStringSet(Set<String> defaultReturnValue) {
        if (!shouldPersist()) {
            return defaultReturnValue;
        }
        
        return mPreferenceManager.getSharedPreferences().getStringSet(mKey, defaultReturnValue);
    }
    
    /**
     * Attempts to persist an int to the {@link android.content.SharedPreferences}.
     * 
     * @param value The value to persist.
     * @return True if the Preference is persistent. (This is not whether the
     *         value was persisted, since we may not necessarily commit if there
     *         will be a batch commit later.)
     * @see #persistString(String)
     * @see #getPersistedInt(int)
     */
    @DSComment("data structure only")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.974 -0500", hash_original_method = "EDA708B947224EBF19ED1E56671C9A01", hash_generated_method = "C6CF3BE0CD44CFED540A3FE2F6F1B49E")
    
protected boolean persistInt(int value) {
        if (shouldPersist()) {
            if (value == getPersistedInt(~value)) {
                // It's already there, so the same as persisting
                return true;
            }
            
            SharedPreferences.Editor editor = mPreferenceManager.getEditor();
            editor.putInt(mKey, value);
            tryCommit(editor);
            return true;
        }
        return false;
    }
    
    /**
     * Attempts to get a persisted int from the {@link android.content.SharedPreferences}.
     * 
     * @param defaultReturnValue The default value to return if either this
     *            Preference is not persistent or this Preference is not in the
     *            SharedPreferences.
     * @return The value from the SharedPreferences or the default return
     *         value.
     * @see #getPersistedString(String)
     * @see #persistInt(int)
     */
    @DSComment("data structure only")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.976 -0500", hash_original_method = "7BDEA34D831595E2EEF9485CF72F7029", hash_generated_method = "ED812736F4232F4563D76E0A11BFF95D")
    
protected int getPersistedInt(int defaultReturnValue) {
        if (!shouldPersist()) {
            return defaultReturnValue;
        }
        
        return mPreferenceManager.getSharedPreferences().getInt(mKey, defaultReturnValue);
    }
    
    /**
     * Attempts to persist a float to the {@link android.content.SharedPreferences}.
     * 
     * @param value The value to persist.
     * @return True if this Preference is persistent. (This is not whether the
     *         value was persisted, since we may not necessarily commit if there
     *         will be a batch commit later.)
     * @see #persistString(String)
     * @see #getPersistedFloat(float)
     */
    @DSComment("data structure only")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.978 -0500", hash_original_method = "554687CB7FDF3E22A2095D4942A8012F", hash_generated_method = "8D8B99361E8FBA88C3FBCC687A73E535")
    
protected boolean persistFloat(float value) {
        if (shouldPersist()) {
            if (value == getPersistedFloat(Float.NaN)) {
                // It's already there, so the same as persisting
                return true;
            }

            SharedPreferences.Editor editor = mPreferenceManager.getEditor();
            editor.putFloat(mKey, value);
            tryCommit(editor);
            return true;
        }
        return false;
    }
    
    /**
     * Attempts to get a persisted float from the {@link android.content.SharedPreferences}.
     * 
     * @param defaultReturnValue The default value to return if either this
     *            Preference is not persistent or this Preference is not in the
     *            SharedPreferences.
     * @return The value from the SharedPreferences or the default return
     *         value.
     * @see #getPersistedString(String)
     * @see #persistFloat(float)
     */
    @DSComment("data structure only")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.980 -0500", hash_original_method = "AB28180DBEC7B1C710871982C247343B", hash_generated_method = "C14C4F30708100AD8A65453B873E4A92")
    
protected float getPersistedFloat(float defaultReturnValue) {
        if (!shouldPersist()) {
            return defaultReturnValue;
        }
        
        return mPreferenceManager.getSharedPreferences().getFloat(mKey, defaultReturnValue);
    }
    
    /**
     * Attempts to persist a long to the {@link android.content.SharedPreferences}.
     * 
     * @param value The value to persist.
     * @return True if this Preference is persistent. (This is not whether the
     *         value was persisted, since we may not necessarily commit if there
     *         will be a batch commit later.)
     * @see #persistString(String)
     * @see #getPersistedLong(long)
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.982 -0500", hash_original_method = "C10CC879E3FA9306B83F34EDB87FCEA5", hash_generated_method = "066C0693A0144A1C9EA7DFD81EDA5690")
    
protected boolean persistLong(long value) {
        if (shouldPersist()) {
            if (value == getPersistedLong(~value)) {
                // It's already there, so the same as persisting
                return true;
            }
            
            SharedPreferences.Editor editor = mPreferenceManager.getEditor();
            editor.putLong(mKey, value);
            tryCommit(editor);
            return true;
        }
        return false;
    }
    
    /**
     * Attempts to get a persisted long from the {@link android.content.SharedPreferences}.
     * 
     * @param defaultReturnValue The default value to return if either this
     *            Preference is not persistent or this Preference is not in the
     *            SharedPreferences.
     * @return The value from the SharedPreferences or the default return
     *         value.
     * @see #getPersistedString(String)
     * @see #persistLong(long)
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.985 -0500", hash_original_method = "88751F99C7941FFB817628D8E528076A", hash_generated_method = "6FD11895B9D9D7E45E61BC3B2E9939B4")
    
protected long getPersistedLong(long defaultReturnValue) {
        if (!shouldPersist()) {
            return defaultReturnValue;
        }
        
        return mPreferenceManager.getSharedPreferences().getLong(mKey, defaultReturnValue);
    }
    
    /**
     * Attempts to persist a boolean to the {@link android.content.SharedPreferences}.
     * 
     * @param value The value to persist.
     * @return True if this Preference is persistent. (This is not whether the
     *         value was persisted, since we may not necessarily commit if there
     *         will be a batch commit later.)
     * @see #persistString(String)
     * @see #getPersistedBoolean(boolean)
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.987 -0500", hash_original_method = "D20BDAFE65F5D54A08F0A9EE0DEAC992", hash_generated_method = "2B56D21A4DDF4A28AB2E22C2FCE4645A")
    
protected boolean persistBoolean(boolean value) {
        if (shouldPersist()) {
            if (value == getPersistedBoolean(!value)) {
                // It's already there, so the same as persisting
                return true;
            }
            
            SharedPreferences.Editor editor = mPreferenceManager.getEditor();
            editor.putBoolean(mKey, value);
            tryCommit(editor);
            return true;
        }
        return false;
    }
    
    /**
     * Attempts to get a persisted boolean from the {@link android.content.SharedPreferences}.
     * 
     * @param defaultReturnValue The default value to return if either this
     *            Preference is not persistent or this Preference is not in the
     *            SharedPreferences.
     * @return The value from the SharedPreferences or the default return
     *         value.
     * @see #getPersistedString(String)
     * @see #persistBoolean(boolean)
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.994 -0500", hash_original_method = "8F28A5D05D1E365FD2C0E61AA71BE94D", hash_generated_method = "A69AD180BCA808EE251BD0CFB76FB46D")
    
protected boolean getPersistedBoolean(boolean defaultReturnValue) {
        if (!shouldPersist()) {
            return defaultReturnValue;
        }
        
        return mPreferenceManager.getSharedPreferences().getBoolean(mKey, defaultReturnValue);
    }
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.997 -0500", hash_original_method = "79DC631A87B79C35E44BC11E3C275CE7", hash_generated_method = "79DC631A87B79C35E44BC11E3C275CE7")
    
boolean hasSpecifiedLayout() {
        return mHasSpecifiedLayout;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:27.999 -0500", hash_original_method = "F82B18888AE588251FAAB1FF7696A001", hash_generated_method = "64B833627D2151EBFB71E47976D5878F")
    
@Override
    public String toString() {
        return getFilterableStringBuilder().toString();
    }
        
    /**
     * Returns the text that will be used to filter this Preference depending on
     * user input.
     * <p>
     * If overridding and calling through to the superclass, make sure to prepend
     * your additions with a space.
     * 
     * @return Text as a {@link StringBuilder} that will be used to filter this
     *         preference. By default, this is the title and summary
     *         (concatenated with a space).
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:28.001 -0500", hash_original_method = "7FA40EC09188F6F1BEA3B1B94241EA4A", hash_generated_method = "947B58C801820171EA581B26A56F9CCF")
    
StringBuilder getFilterableStringBuilder() {
        StringBuilder sb = new StringBuilder();
        CharSequence title = getTitle();
        if (!TextUtils.isEmpty(title)) {
            sb.append(title).append(' ');
        }
        CharSequence summary = getSummary();
        if (!TextUtils.isEmpty(summary)) {
            sb.append(summary).append(' ');
        }
        if (sb.length() > 0) {
            // Drop the last space
            sb.setLength(sb.length() - 1);
        }
        return sb;
    }

    /**
     * Store this Preference hierarchy's frozen state into the given container.
     * 
     * @param container The Bundle in which to save the instance of this Preference.
     * 
     * @see #restoreHierarchyState
     * @see #onSaveInstanceState
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:28.003 -0500", hash_original_method = "363F8E8F58511FB925A751666AB900BD", hash_generated_method = "F0EF01EE9A89DEFC92242C083A995234")
    
public void saveHierarchyState(Bundle container) {
        dispatchSaveInstanceState(container);
    }

    /**
     * Called by {@link #saveHierarchyState} to store the instance for this Preference and its children.
     * May be overridden to modify how the save happens for children. For example, some
     * Preference objects may want to not store an instance for their children.
     * 
     * @param container The Bundle in which to save the instance of this Preference.
     * 
     * @see #saveHierarchyState
     * @see #onSaveInstanceState
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:28.005 -0500", hash_original_method = "1B94F5D63E3EC8B47F4D750B8B09EC88", hash_generated_method = "1B94F5D63E3EC8B47F4D750B8B09EC88")
    
void dispatchSaveInstanceState(Bundle container) {
        if (hasKey()) {
            mBaseMethodCalled = false;
            Parcelable state = onSaveInstanceState();
            if (!mBaseMethodCalled) {
                throw new IllegalStateException(
                        "Derived class did not call super.onSaveInstanceState()");
            }
            if (state != null) {
                container.putParcelable(mKey, state);
            }
        }
    }

    /**
     * Hook allowing a Preference to generate a representation of its internal
     * state that can later be used to create a new instance with that same
     * state. This state should only contain information that is not persistent
     * or can be reconstructed later.
     * 
     * @return A Parcelable object containing the current dynamic state of
     *         this Preference, or null if there is nothing interesting to save.
     *         The default implementation returns null.
     * @see #onRestoreInstanceState
     * @see #saveHierarchyState
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:28.007 -0500", hash_original_method = "9DD945A60796B8A8FF01F94A77988BE6", hash_generated_method = "96525F3248EC8E48BE1EC2EB30D8E02C")
    
protected Parcelable onSaveInstanceState() {
        mBaseMethodCalled = true;
        return BaseSavedState.EMPTY_STATE;
    }

    /**
     * Restore this Preference hierarchy's previously saved state from the given container.
     * 
     * @param container The Bundle that holds the previously saved state.
     * 
     * @see #saveHierarchyState
     * @see #onRestoreInstanceState
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:28.009 -0500", hash_original_method = "D5A51A6B2B5A2D76F277782756F6ADE6", hash_generated_method = "1115BB6ECE6F7B6BA8131466C0ED950B")
    
public void restoreHierarchyState(Bundle container) {
        dispatchRestoreInstanceState(container);
    }

    /**
     * Called by {@link #restoreHierarchyState} to retrieve the saved state for this
     * Preference and its children. May be overridden to modify how restoring
     * happens to the children of a Preference. For example, some Preference objects may
     * not want to save state for their children.
     * 
     * @param container The Bundle that holds the previously saved state.
     * @see #restoreHierarchyState
     * @see #onRestoreInstanceState
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:28.012 -0500", hash_original_method = "18F16B162844FF15C24BE293B1033BC4", hash_generated_method = "18F16B162844FF15C24BE293B1033BC4")
    
void dispatchRestoreInstanceState(Bundle container) {
        if (hasKey()) {
            Parcelable state = container.getParcelable(mKey);
            if (state != null) {
                mBaseMethodCalled = false;
                onRestoreInstanceState(state);
                if (!mBaseMethodCalled) {
                    throw new IllegalStateException(
                            "Derived class did not call super.onRestoreInstanceState()");
                }
            }
        }
    }
    
    public static class BaseSavedState extends AbsSavedState {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:28.029 -0500", hash_original_field = "36945CEB7F71B305AA42039BECC3DF22", hash_generated_field = "1603EC57FF7A24DE0B9CE75D44794F2A")
        
        public static final Parcelable.Creator<BaseSavedState> CREATOR =
                new Parcelable.Creator<BaseSavedState>() {
            public BaseSavedState createFromParcel(Parcel in) {
                return new BaseSavedState(in);
            }

            public BaseSavedState[] newArray(int size) {
                return new BaseSavedState[size];
            }
        };
        @DSComment("Data serialization/deserialization")
        @DSSpec(DSCat.SERIALIZATION)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:28.017 -0500", hash_original_method = "0710B1BECA4AE2A64DE9C58BFD4A1161", hash_generated_method = "A170B20D980951FCD7B625137DF8A752")
        
public BaseSavedState(Parcel source) {
            super(source);
        }

        @DSComment("Data serialization/deserialization")
        @DSSpec(DSCat.SERIALIZATION)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:28.020 -0500", hash_original_method = "C61013DFD638DC996F3EF4CC52F40C74", hash_generated_method = "47DE192996C36408BDAA9BA55ED90871")
        
public BaseSavedState(Parcelable superState) {
            super(superState);
        }
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
        
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        @DSVerified
        boolean onPreferenceChange(Preference preference, Object newValue);
    }
    
    public interface OnPreferenceClickListener {
        
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        @DSVerified
        boolean onPreferenceClick(Preference preference);
    }
    
    interface OnPreferenceChangeInternalListener {
        
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        void onPreferenceChange(Preference preference);
        
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        void onPreferenceHierarchyChange(Preference preference);
    }

    /**
     * Hook allowing a Preference to re-apply a representation of its internal
     * state that had previously been generated by {@link #onSaveInstanceState}.
     * This function will never be called with a null state.
     * 
     * @param state The saved state that had previously been returned by
     *            {@link #onSaveInstanceState}.
     * @see #onSaveInstanceState
     * @see #restoreHierarchyState
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:28.014 -0500", hash_original_method = "18B537C81357A7563BC62FF4E045FAEF", hash_generated_method = "8646015F89F4ECCBB546FE1F49AF048B")
    
protected void onRestoreInstanceState(Parcelable state) {
        mBaseMethodCalled = true;
        if (state != BaseSavedState.EMPTY_STATE && state != null) {
            throw new IllegalArgumentException("Wrong state class -- expecting Preference State");
        }
    }
}

