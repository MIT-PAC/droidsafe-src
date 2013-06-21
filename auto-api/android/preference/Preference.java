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
    private Context mContext;
    private PreferenceManager mPreferenceManager;
    private long mId;
    private OnPreferenceChangeListener mOnChangeListener;
    private OnPreferenceClickListener mOnClickListener;
    private int mOrder = DEFAULT_ORDER;
    private CharSequence mTitle;
    private int mTitleRes;
    private CharSequence mSummary;
    private int mIconResId;
    private Drawable mIcon;
    private String mKey;
    private Intent mIntent;
    private String mFragment;
    private Bundle mExtras;
    private boolean mEnabled = true;
    private boolean mSelectable = true;
    private boolean mRequiresKey;
    private boolean mPersistent = true;
    private String mDependencyKey;
    private Object mDefaultValue;
    private boolean mDependencyMet = true;
    private boolean mShouldDisableView = true;
    private int mLayoutResId = com.android.internal.R.layout.preference;
    private int mWidgetLayoutResId;
    private boolean mHasSpecifiedLayout = false;
    private OnPreferenceChangeInternalListener mListener;
    private List<Preference> mDependents;
    private boolean mBaseMethodCalled;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.617 -0400", hash_original_method = "9CEB9C34CAA8ECAB230B50A0542D61B3", hash_generated_method = "D304AE7954667213A64010E40DB3E3CA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Preference(Context context, AttributeSet attrs, int defStyle) {
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(defStyle);
        dsTaint.addTaint(context.dsTaint);
        TypedArray a;
        a = context.obtainStyledAttributes(attrs,
                com.android.internal.R.styleable.Preference, defStyle, 0);
        {
            int i;
            i = a.getIndexCount();
            {
                int attr;
                attr = a.getIndex(i);
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
            boolean var10BC812A3C0743D80A2FB7B328F2D5C8_328656155 = (!getClass().getName().startsWith("android.preference"));
            {
                mHasSpecifiedLayout = true;
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.618 -0400", hash_original_method = "48043D3D24F48A6FD06B47A9624983D0", hash_generated_method = "0C858A5C7867BE0F5A56DC1F948E17B0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Preference(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.preferenceStyle);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.618 -0400", hash_original_method = "B50FF766B3A35A641C8DC6BF5214AE70", hash_generated_method = "4B059B6CB2C03B4531BC2F7ED4B8FB8F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Preference(Context context) {
        this(context, null);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.619 -0400", hash_original_method = "75C2469AD4E7F0A9F01D294D0E9B9A83", hash_generated_method = "AF8C2334ADDE9141FF379D4E1F2D220F")
    @DSModeled(DSC.SAFE)
    protected Object onGetDefaultValue(TypedArray a, int index) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(index);
        dsTaint.addTaint(a.dsTaint);
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.619 -0400", hash_original_method = "BB18D5EDF68F7EDDF74E48FAF30F475E", hash_generated_method = "18FE77DFB4D37926EC48E8D3CA52FF25")
    @DSModeled(DSC.SPEC)
    public void setIntent(Intent intent) {
        dsTaint.addTaint(intent.dsTaint);
        // ---------- Original Method ----------
        //mIntent = intent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.619 -0400", hash_original_method = "AD027B7B58A4A2F151CC138FB7B23244", hash_generated_method = "22770DE3BF38836C28544CA3834587CE")
    @DSModeled(DSC.SPEC)
    public Intent getIntent() {
        return (Intent)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mIntent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.619 -0400", hash_original_method = "B84A292EE370DC034681ED1A5B514CE4", hash_generated_method = "1BDE80A84BFAA7CB8406A8846D6F85CA")
    @DSModeled(DSC.SAFE)
    public void setFragment(String fragment) {
        dsTaint.addTaint(fragment);
        // ---------- Original Method ----------
        //mFragment = fragment;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.619 -0400", hash_original_method = "133D42C98C64EF6757CE3D375E2E1FA7", hash_generated_method = "60AB54DF08A817DC436FFE69F51AF6A2")
    @DSModeled(DSC.SAFE)
    public String getFragment() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mFragment;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.620 -0400", hash_original_method = "F77D5C181034415714B081995209DE64", hash_generated_method = "26BBAE56E556A8B65CDCBBEC2AA7D3C9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Bundle getExtras() {
        {
            mExtras = new Bundle();
        } //End block
        return (Bundle)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mExtras == null) {
            //mExtras = new Bundle();
        //}
        //return mExtras;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.620 -0400", hash_original_method = "06728B07006932C3BCF42D880B54A6CC", hash_generated_method = "C20098D25074AEF324AD4B633672C722")
    @DSModeled(DSC.SAFE)
    public Bundle peekExtras() {
        return (Bundle)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mExtras;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.620 -0400", hash_original_method = "528C4C3ACF7780A9B6B960E406A0977A", hash_generated_method = "0E3DDC4485A6F6A849B200E960A90D5B")
    @DSModeled(DSC.SAFE)
    public void setLayoutResource(int layoutResId) {
        dsTaint.addTaint(layoutResId);
        {
            mHasSpecifiedLayout = true;
        } //End block
        // ---------- Original Method ----------
        //if (layoutResId != mLayoutResId) {
            //mHasSpecifiedLayout = true;
        //}
        //mLayoutResId = layoutResId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.621 -0400", hash_original_method = "A2555092F113429083F033F36B8E024F", hash_generated_method = "1FE4DC80EFA2987572864321716C7EF1")
    @DSModeled(DSC.SAFE)
    public int getLayoutResource() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mLayoutResId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.621 -0400", hash_original_method = "2204831C4D4DE968C9A72D9D306DDD8C", hash_generated_method = "A6D95271B25335E33D59C3D021AEA317")
    @DSModeled(DSC.SAFE)
    public void setWidgetLayoutResource(int widgetLayoutResId) {
        dsTaint.addTaint(widgetLayoutResId);
        {
            mHasSpecifiedLayout = true;
        } //End block
        // ---------- Original Method ----------
        //if (widgetLayoutResId != mWidgetLayoutResId) {
            //mHasSpecifiedLayout = true;
        //}
        //mWidgetLayoutResId = widgetLayoutResId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.621 -0400", hash_original_method = "6D000A2827FAFE2A1A87DD4A065ACF04", hash_generated_method = "81ADA0FA38EE202267FA4399877AC9D0")
    @DSModeled(DSC.SAFE)
    public int getWidgetLayoutResource() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mWidgetLayoutResId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.621 -0400", hash_original_method = "10F5B4A945AE227B9B33457223123B2A", hash_generated_method = "6E5D832EC03E12E5E4BF156B0A84E937")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public View getView(View convertView, ViewGroup parent) {
        dsTaint.addTaint(parent.dsTaint);
        dsTaint.addTaint(convertView.dsTaint);
        {
            convertView = onCreateView(parent);
        } //End block
        onBindView(convertView);
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (convertView == null) {
            //convertView = onCreateView(parent);
        //}
        //onBindView(convertView);
        //return convertView;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.622 -0400", hash_original_method = "DD0E6DF051F4F0779DD2D5F6BCD064A5", hash_generated_method = "0A9058CF7C436831BF7A6BD1A79E8BB4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected View onCreateView(ViewGroup parent) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(parent.dsTaint);
        LayoutInflater layoutInflater;
        layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout;
        layout = layoutInflater.inflate(mLayoutResId, parent, false);
        ViewGroup widgetFrame;
        widgetFrame = (ViewGroup) layout
                .findViewById(com.android.internal.R.id.widget_frame);
        {
            {
                layoutInflater.inflate(mWidgetLayoutResId, widgetFrame);
            } //End block
            {
                widgetFrame.setVisibility(View.GONE);
            } //End block
        } //End block
        return (View)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.622 -0400", hash_original_method = "D65593443BAE954E876A7311E3E1909A", hash_generated_method = "0D9B6D6376FD2BA87F498ACD74E9157D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void onBindView(View view) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(view.dsTaint);
        TextView textView;
        textView = (TextView) view.findViewById(com.android.internal.R.id.title);
        {
            textView.setText(getTitle());
        } //End block
        textView = (TextView) view.findViewById(com.android.internal.R.id.summary);
        {
            CharSequence summary;
            summary = getSummary();
            {
                boolean var33886BAB7464784CE6FA21654C0C5CE0_325524882 = (!TextUtils.isEmpty(summary));
                {
                    {
                        boolean var130C18F3D215FC85E4C5C553CB359870_343030453 = (textView.getVisibility() != View.VISIBLE);
                        {
                            textView.setVisibility(View.VISIBLE);
                        } //End block
                    } //End collapsed parenthetic
                    textView.setText(getSummary());
                } //End block
                {
                    {
                        boolean varB53302C499574F7ECA44F69707CCE618_1518408434 = (textView.getVisibility() != View.GONE);
                        {
                            textView.setVisibility(View.GONE);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        ImageView imageView;
        imageView = (ImageView) view.findViewById(com.android.internal.R.id.icon);
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.623 -0400", hash_original_method = "4F80205B57D5838ADEC212DC6CB9E651", hash_generated_method = "EC8F6179557B9FA6CB6990CB0BFF6F00")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setEnabledStateOnViews(View v, boolean enabled) {
        dsTaint.addTaint(enabled);
        dsTaint.addTaint(v.dsTaint);
        v.setEnabled(enabled);
        {
            ViewGroup vg;
            vg = (ViewGroup) v;
            {
                int i;
                i = vg.getChildCount() - 1;
                {
                    setEnabledStateOnViews(vg.getChildAt(i), enabled);
                } //End block
            } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.623 -0400", hash_original_method = "84974F9AFFF82527B4C714348BF0B3DB", hash_generated_method = "EF5F0F7085399D14748E18BD22CEBE86")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setOrder(int order) {
        dsTaint.addTaint(order);
        {
            notifyHierarchyChanged();
        } //End block
        // ---------- Original Method ----------
        //if (order != mOrder) {
            //mOrder = order;
            //notifyHierarchyChanged();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.623 -0400", hash_original_method = "BE8C43C510B8AF8546FEBBAA3EF0F0B1", hash_generated_method = "76479DEE3C3B466A0078F5144E9D0D88")
    @DSModeled(DSC.SAFE)
    public int getOrder() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mOrder;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.624 -0400", hash_original_method = "B4BEC153E73D566AEC40ED844297CB0F", hash_generated_method = "F584412A0E904FA2E9B76E095F98972C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setTitle(CharSequence title) {
        dsTaint.addTaint(title);
        {
            boolean var3E1E3FC34E7505C6E24DFDD86F4100EF_1491003252 = (title == null && mTitle != null || title != null && !title.equals(mTitle));
            {
                mTitleRes = 0;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.624 -0400", hash_original_method = "4E4A93A9A53A92BE0779D6D57BF6863D", hash_generated_method = "016CDAB4476EF0F89B7602D633DB20FB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setTitle(int titleResId) {
        dsTaint.addTaint(titleResId);
        setTitle(mContext.getString(titleResId));
        // ---------- Original Method ----------
        //setTitle(mContext.getString(titleResId));
        //mTitleRes = titleResId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.624 -0400", hash_original_method = "9778C1A15B3D4EC3FC935EB49323C011", hash_generated_method = "69286333F901B1664F5949986FC9658A")
    @DSModeled(DSC.SAFE)
    public int getTitleRes() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mTitleRes;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.624 -0400", hash_original_method = "7D691BCB64236E7B5AF8F6CB0399C091", hash_generated_method = "7A540A7B0E4496A8FAF388C1F1064A47")
    @DSModeled(DSC.SAFE)
    public CharSequence getTitle() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mTitle;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.624 -0400", hash_original_method = "3511105857431430BED74F970B043B64", hash_generated_method = "DC12F05E5E803B0F08F052C2308BC31D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setIcon(Drawable icon) {
        dsTaint.addTaint(icon.dsTaint);
        {
            notifyChanged();
        } //End block
        // ---------- Original Method ----------
        //if ((icon == null && mIcon != null) || (icon != null && mIcon != icon)) {
            //mIcon = icon;
            //notifyChanged();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.625 -0400", hash_original_method = "42E5A2AC84ED127F39E187697447AF4F", hash_generated_method = "833F653929130512C2AD2A752A5F0F4C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setIcon(int iconResId) {
        dsTaint.addTaint(iconResId);
        setIcon(mContext.getResources().getDrawable(iconResId));
        // ---------- Original Method ----------
        //mIconResId = iconResId;
        //setIcon(mContext.getResources().getDrawable(iconResId));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.625 -0400", hash_original_method = "ED78DC4ED6B2C6A65EDA3016CC1C1C4D", hash_generated_method = "87A163AD5431C2EF9ADEEC765D62E5A3")
    @DSModeled(DSC.SAFE)
    public Drawable getIcon() {
        return (Drawable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mIcon;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.625 -0400", hash_original_method = "485EE2482F168D23B57BE8096AF663D1", hash_generated_method = "1C1F6BB26D10B725516CA5E1E213AC64")
    @DSModeled(DSC.SAFE)
    public CharSequence getSummary() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mSummary;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.625 -0400", hash_original_method = "9397E34A85A0111B42F6FFB9A2837DEB", hash_generated_method = "51B4F9B5DD0E21F8DAB8EA7FFB2149C8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setSummary(CharSequence summary) {
        dsTaint.addTaint(summary);
        {
            boolean var7D3C342C624946ABF94C19C1BF92A849_273559097 = (summary == null && mSummary != null || summary != null && !summary.equals(mSummary));
            {
                notifyChanged();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (summary == null && mSummary != null || summary != null && !summary.equals(mSummary)) {
            //mSummary = summary;
            //notifyChanged();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.626 -0400", hash_original_method = "7AEFEE5A5E2C81392912FC13D133C130", hash_generated_method = "A09101ABE1B717BE7B3591AB96E8A8FD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setSummary(int summaryResId) {
        dsTaint.addTaint(summaryResId);
        setSummary(mContext.getString(summaryResId));
        // ---------- Original Method ----------
        //setSummary(mContext.getString(summaryResId));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.626 -0400", hash_original_method = "86021B1A0572E898D2D9C9D290D998FE", hash_generated_method = "3B4712EEA288FA3F30129F90C74133BC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setEnabled(boolean enabled) {
        dsTaint.addTaint(enabled);
        {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.626 -0400", hash_original_method = "1BB77BECC2C1296C251576AD714A96C1", hash_generated_method = "EBE36AC07A8F70875A7CA2AC58593B62")
    @DSModeled(DSC.SAFE)
    public boolean isEnabled() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mEnabled && mDependencyMet;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.626 -0400", hash_original_method = "7EEA4953639C86CA9F36ABED9565FC6D", hash_generated_method = "BFB897FE2ABC203181C0047327218B80")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setSelectable(boolean selectable) {
        dsTaint.addTaint(selectable);
        {
            notifyChanged();
        } //End block
        // ---------- Original Method ----------
        //if (mSelectable != selectable) {
            //mSelectable = selectable;
            //notifyChanged();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.626 -0400", hash_original_method = "A1A8E91E60B51F4951583D0866634B48", hash_generated_method = "1B195CA3A2F9A085A893694AF9A3B726")
    @DSModeled(DSC.SAFE)
    public boolean isSelectable() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mSelectable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.627 -0400", hash_original_method = "97FCA568B4719676F3D4400812EA1F3A", hash_generated_method = "A0EF930705638B5AEA6C7093603D5296")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setShouldDisableView(boolean shouldDisableView) {
        dsTaint.addTaint(shouldDisableView);
        notifyChanged();
        // ---------- Original Method ----------
        //mShouldDisableView = shouldDisableView;
        //notifyChanged();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.627 -0400", hash_original_method = "465C9050F708FCF1A73506501FE4644E", hash_generated_method = "377786B9B9A3D91905B717DE4E89493E")
    @DSModeled(DSC.SAFE)
    public boolean getShouldDisableView() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mShouldDisableView;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.627 -0400", hash_original_method = "6AF16C815DE6FE4144432EF99CDC825B", hash_generated_method = "000D9071C3C5789D768F8413E7045644")
    @DSModeled(DSC.SAFE)
     long getId() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return mId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.627 -0400", hash_original_method = "DE9BB9E40914727DA5D6E94159FAF3CB", hash_generated_method = "B12F9C4DD7EEB07FF06C6B7E88BC35E4")
    @DSModeled(DSC.SAFE)
    protected void onClick() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.628 -0400", hash_original_method = "46997BE6329912D9EC1174E4CE7CAB04", hash_generated_method = "56CA2D5F8A2F04492B39B4C469C34075")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setKey(String key) {
        dsTaint.addTaint(key);
        {
            boolean varD59801A1A66D3BBEFE5917383BD030C1_1683605746 = (mRequiresKey && !hasKey());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.628 -0400", hash_original_method = "E0CEA0C6ABDC55C32B991C1D155B5E3E", hash_generated_method = "8C4749A4D45BDEA86424E2138EE82723")
    @DSModeled(DSC.SAFE)
    public String getKey() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mKey;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.628 -0400", hash_original_method = "21702F9605A21EAEE85E66B458F985AA", hash_generated_method = "685CC251EA20D06F07307FAC300B84D6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.628 -0400", hash_original_method = "3BC185E939D8CD84C5733E95D5330A61", hash_generated_method = "57CDB049884EF8039E1163FE57F625AF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean hasKey() {
        boolean var5FDB348C3EC1AA79FB00873E989748AA_1097925396 = (!TextUtils.isEmpty(mKey));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return !TextUtils.isEmpty(mKey);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.629 -0400", hash_original_method = "45C46AF35C2A296F9912D410933691CF", hash_generated_method = "008F73A72A97E023C14FCF64D53E4E1B")
    @DSModeled(DSC.SAFE)
    public boolean isPersistent() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mPersistent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.629 -0400", hash_original_method = "E7579FEE83F4F133055197D69D72F289", hash_generated_method = "3B13C8A2B0CB2CB51B6D050A3011D1E7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected boolean shouldPersist() {
        boolean var2B9F974DBFD553E7FDC0654C6EC87725_648459042 = (mPreferenceManager != null && isPersistent() && hasKey());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mPreferenceManager != null && isPersistent() && hasKey();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.629 -0400", hash_original_method = "9780EA334E29D2930E2D9A0F1CB4087F", hash_generated_method = "2F0D6622B64B623FBAC0D500A50B58E7")
    @DSModeled(DSC.SAFE)
    public void setPersistent(boolean persistent) {
        dsTaint.addTaint(persistent);
        // ---------- Original Method ----------
        //mPersistent = persistent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.629 -0400", hash_original_method = "4367E5B2EAD1BB8898BD88F610DDAF7D", hash_generated_method = "7F1AE9406EB0F618F834ED11D420E87D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected boolean callChangeListener(Object newValue) {
        dsTaint.addTaint(newValue.dsTaint);
        {
            Object var840D0FFA474209A8E9E502A96959FE2F_1092070205 = (mOnChangeListener.onPreferenceChange(this, newValue));
        } //End flattened ternary
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mOnChangeListener == null ? true : mOnChangeListener.onPreferenceChange(this, newValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.630 -0400", hash_original_method = "D46636D80B7557AC6195A05902CC638C", hash_generated_method = "4D640B1957C68448290366650AA98264")
    @DSModeled(DSC.SAFE)
    public void setOnPreferenceChangeListener(OnPreferenceChangeListener onPreferenceChangeListener) {
        dsTaint.addTaint(onPreferenceChangeListener.dsTaint);
        // ---------- Original Method ----------
        //mOnChangeListener = onPreferenceChangeListener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.630 -0400", hash_original_method = "9CC8E5271070D42EF9628C47033D91A6", hash_generated_method = "850B9BB3C9173229742951489B03C71A")
    @DSModeled(DSC.SAFE)
    public OnPreferenceChangeListener getOnPreferenceChangeListener() {
        return (OnPreferenceChangeListener)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mOnChangeListener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.630 -0400", hash_original_method = "E8A10745E179E2FA23FF715EAD4A5CB3", hash_generated_method = "0F47B4690A4479A65CA9834292887655")
    @DSModeled(DSC.SAFE)
    public void setOnPreferenceClickListener(OnPreferenceClickListener onPreferenceClickListener) {
        dsTaint.addTaint(onPreferenceClickListener.dsTaint);
        // ---------- Original Method ----------
        //mOnClickListener = onPreferenceClickListener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.630 -0400", hash_original_method = "55E2C6999F7D889141550F7A68D36827", hash_generated_method = "0C4BC6389CF39FEC0931800CB6614309")
    @DSModeled(DSC.SAFE)
    public OnPreferenceClickListener getOnPreferenceClickListener() {
        return (OnPreferenceClickListener)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mOnClickListener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.631 -0400", hash_original_method = "501E66F7BA58D6B4C7BCFDD2200CB13A", hash_generated_method = "632B397B374402982F7F53A18A3B568C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void performClick(PreferenceScreen preferenceScreen) {
        dsTaint.addTaint(preferenceScreen.dsTaint);
        {
            boolean varC378F7D9F83769944CF2ACC662A4EAE3_1124389464 = (!isEnabled());
        } //End collapsed parenthetic
        onClick();
        {
            boolean varACD6C4667640FA997CEF70414875FCB9_1751358529 = (mOnClickListener != null && mOnClickListener.onPreferenceClick(this));
        } //End collapsed parenthetic
        PreferenceManager preferenceManager;
        preferenceManager = getPreferenceManager();
        {
            PreferenceManager.OnPreferenceTreeClickListener listener;
            listener = preferenceManager
                    .getOnPreferenceTreeClickListener();
            {
                boolean var6C0208A36FCEA21336C3A6F6854606AF_773620789 = (preferenceScreen != null && listener != null
                    && listener.onPreferenceTreeClick(preferenceScreen, this));
            } //End collapsed parenthetic
        } //End block
        {
            Context context;
            context = getContext();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.631 -0400", hash_original_method = "089B06359A27CB6D952DCE596F00B787", hash_generated_method = "91EFFA3AB88654ED9D1A8367CC17AF79")
    @DSModeled(DSC.SAFE)
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(keyCode);
        dsTaint.addTaint(v.dsTaint);
        dsTaint.addTaint(event.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.631 -0400", hash_original_method = "4F4EBC54D108D66F416C93B46580E117", hash_generated_method = "DFA42A6C39C27C217BA4B1F8A6817BD5")
    @DSModeled(DSC.SAFE)
    public Context getContext() {
        return (Context)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mContext;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.631 -0400", hash_original_method = "8BF68140BB0364C46F5E3D57D69A6DB5", hash_generated_method = "705275AF1DFB6F046DA256B76EF26766")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SharedPreferences getSharedPreferences() {
        SharedPreferences varA9F7B724CA68855681FB9C91AE4DBCE9_1486369063 = (mPreferenceManager.getSharedPreferences());
        return (SharedPreferences)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mPreferenceManager == null) {
            //return null;
        //}
        //return mPreferenceManager.getSharedPreferences();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.632 -0400", hash_original_method = "59D9CBF7E4B6683DDFDC1DAE57ABD5B7", hash_generated_method = "C60853BEAAFCA9C403054A53B185D19B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SharedPreferences.Editor getEditor() {
        SharedPreferences.Editor var3B5641024B25D62A4230631FB30F4E09_410982689 = (mPreferenceManager.getEditor());
        return (SharedPreferences.Editor)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mPreferenceManager == null) {
            //return null;
        //}
        //return mPreferenceManager.getEditor();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.632 -0400", hash_original_method = "23B2B69F1B515A4430736566C100E20E", hash_generated_method = "0B9A562665290BB33F98246B7C85E391")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean shouldCommit() {
        boolean varB6DAC15187C329558C72653F1654C862_1791121015 = (mPreferenceManager.shouldCommit());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mPreferenceManager == null) {
            //return false;
        //}
        //return mPreferenceManager.shouldCommit();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.632 -0400", hash_original_method = "93B6E6EE30870726B108BD396B876DEB", hash_generated_method = "B4E41FF4E7E0452D6C33ED60F394D996")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int compareTo(Preference another) {
        dsTaint.addTaint(another.dsTaint);
        {
            int var843ABEE7C36935B044756D876A54DA3D_1933567017 = (CharSequences.compareToIgnoreCase(mTitle, another.mTitle));
        } //End block
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.632 -0400", hash_original_method = "6457E3944D02DD03B8855B0556ABBC63", hash_generated_method = "F1B50B9EE60AD593F97CAD0FD694C3E4")
    @DSModeled(DSC.SAFE)
    final void setOnPreferenceChangeInternalListener(OnPreferenceChangeInternalListener listener) {
        dsTaint.addTaint(listener.dsTaint);
        // ---------- Original Method ----------
        //mListener = listener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.633 -0400", hash_original_method = "BC518684C2B31AF5801BA48B18DD0A6B", hash_generated_method = "3A319E676E5732DB111D341B5951950F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void notifyChanged() {
        {
            mListener.onPreferenceChange(this);
        } //End block
        // ---------- Original Method ----------
        //if (mListener != null) {
            //mListener.onPreferenceChange(this);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.633 -0400", hash_original_method = "B6CFA705B58CA125A61E30E547554AC9", hash_generated_method = "CDBBC3108FFB40C9AE40844C371092B9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void notifyHierarchyChanged() {
        {
            mListener.onPreferenceHierarchyChange(this);
        } //End block
        // ---------- Original Method ----------
        //if (mListener != null) {
            //mListener.onPreferenceHierarchyChange(this);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.633 -0400", hash_original_method = "002FC5CEE5BE5B5D1FE36CEDBC1DEB65", hash_generated_method = "32E455CEB4991CF99EC7605071CCF3D6")
    @DSModeled(DSC.SAFE)
    public PreferenceManager getPreferenceManager() {
        return (PreferenceManager)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mPreferenceManager;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.634 -0400", hash_original_method = "664C21A1EBA456CB3BAFB18286851581", hash_generated_method = "4E88B16002B33A48A6391CD1F9CD0B9C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void onAttachedToHierarchy(PreferenceManager preferenceManager) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(preferenceManager.dsTaint);
        mId = preferenceManager.getNextId();
        dispatchSetInitialValue();
        // ---------- Original Method ----------
        //mPreferenceManager = preferenceManager;
        //mId = preferenceManager.getNextId();
        //dispatchSetInitialValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.634 -0400", hash_original_method = "ECA501E201E2D5472D2CB3C64A16D61F", hash_generated_method = "CEDF62541504E21C8B99E9FF9C6C284E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void onAttachedToActivity() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        registerDependency();
        // ---------- Original Method ----------
        //registerDependency();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.634 -0400", hash_original_method = "A499F7D8BECEFF58ECE377DCDDB4C87B", hash_generated_method = "EB6ED2BF3B813152BA0FB24D5D6C74AC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void registerDependency() {
        {
            boolean varB1E8F75C3553AAFEDCF5483B863F116C_815771790 = (TextUtils.isEmpty(mDependencyKey));
        } //End collapsed parenthetic
        Preference preference;
        preference = findPreferenceInHierarchy(mDependencyKey);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.635 -0400", hash_original_method = "40F9072BE8C6932FEF31F09A7FFFCE04", hash_generated_method = "C1AE51589D1A0829AE6060ACF1D44025")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void unregisterDependency() {
        {
            Preference oldDependency;
            oldDependency = findPreferenceInHierarchy(mDependencyKey);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.635 -0400", hash_original_method = "913C05EFD2CE9AD9CE3BED6394A14862", hash_generated_method = "7C19D7DE92B1E601A2EC6C95C8422E5E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected Preference findPreferenceInHierarchy(String key) {
        dsTaint.addTaint(key);
        {
            boolean var14B185A6FDE26BEB2F1F14099406A9CC_68327983 = (TextUtils.isEmpty(key) || mPreferenceManager == null);
        } //End collapsed parenthetic
        Preference var4AAB6BA44E4DB7D600DB90F9DADD1020_1348250539 = (mPreferenceManager.findPreference(key));
        return (Preference)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (TextUtils.isEmpty(key) || mPreferenceManager == null) {
            //return null;
        //}
        //return mPreferenceManager.findPreference(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.635 -0400", hash_original_method = "528DD85662997ACAED3BC519F97454B8", hash_generated_method = "B4AA325F4081E5A6D0E1A91F84C7DEA9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void registerDependent(Preference dependent) {
        dsTaint.addTaint(dependent.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.636 -0400", hash_original_method = "9028FF718331F8BA1AAB10BD4FAE315E", hash_generated_method = "E17C838DDD8E8DFCDA13B31473511991")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void unregisterDependent(Preference dependent) {
        dsTaint.addTaint(dependent.dsTaint);
        {
            mDependents.remove(dependent);
        } //End block
        // ---------- Original Method ----------
        //if (mDependents != null) {
            //mDependents.remove(dependent);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.637 -0400", hash_original_method = "02C347ADE8272FB6E630575816981A99", hash_generated_method = "2C732B429F309A31A58EC7F9E7BAE2BD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void notifyDependencyChange(boolean disableDependents) {
        dsTaint.addTaint(disableDependents);
        List<Preference> dependents;
        dependents = mDependents;
        int dependentsCount;
        dependentsCount = dependents.size();
        {
            int i;
            i = 0;
            {
                dependents.get(i).onDependencyChanged(this, disableDependents);
            } //End block
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.638 -0400", hash_original_method = "E3DDA7BA2220D3A5C80FED1DB4754CB9", hash_generated_method = "10DF3F3571021485014F8430830DD0B5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onDependencyChanged(Preference dependency, boolean disableDependent) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(dependency.dsTaint);
        dsTaint.addTaint(disableDependent);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.638 -0400", hash_original_method = "88055BCA041292961DE741A16807A2A3", hash_generated_method = "00D7FAB6FDA46761049FEA8247C40900")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean shouldDisableDependents() {
        boolean var09FF3454BC8E65DB686A79A385F3030C_1437168095 = (!isEnabled());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return !isEnabled();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.638 -0400", hash_original_method = "FBFB05D545147227A8E2F6FCFC356242", hash_generated_method = "34C0A942662EDCFE1275D32061C69C86")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setDependency(String dependencyKey) {
        dsTaint.addTaint(dependencyKey);
        unregisterDependency();
        registerDependency();
        // ---------- Original Method ----------
        //unregisterDependency();
        //mDependencyKey = dependencyKey;
        //registerDependency();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.638 -0400", hash_original_method = "664EA11E01CF3C90DB639CBF1F232407", hash_generated_method = "C4D4D728E9BF828C93D6C54EFAACB9AD")
    @DSModeled(DSC.SAFE)
    public String getDependency() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mDependencyKey;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.638 -0400", hash_original_method = "590B71B1265EC6EEA43053FD50985818", hash_generated_method = "14FE589E8685D8807F769025D0914FFE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void onPrepareForRemoval() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        unregisterDependency();
        // ---------- Original Method ----------
        //unregisterDependency();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.639 -0400", hash_original_method = "EC5991F73564EC767E73B865F0A17074", hash_generated_method = "DCD638AF6662230DC1B8409867F34CF2")
    @DSModeled(DSC.SAFE)
    public void setDefaultValue(Object defaultValue) {
        dsTaint.addTaint(defaultValue.dsTaint);
        // ---------- Original Method ----------
        //mDefaultValue = defaultValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.639 -0400", hash_original_method = "0CC9C8053B2B40671F6785C5B066E9AB", hash_generated_method = "3778E8C95B2C547CE47F711ECD563B0A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void dispatchSetInitialValue() {
        boolean shouldPersist;
        shouldPersist = shouldPersist();
        {
            boolean varE1E93872791DB34FDCFD35466E3B326E_652730673 = (!shouldPersist || !getSharedPreferences().contains(mKey));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.639 -0400", hash_original_method = "8C28678F9AE41A1BF1FA484A48C7C6F8", hash_generated_method = "53927015CF4978FF82D743480B1669AE")
    @DSModeled(DSC.SAFE)
    protected void onSetInitialValue(boolean restorePersistedValue, Object defaultValue) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(restorePersistedValue);
        dsTaint.addTaint(defaultValue.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.639 -0400", hash_original_method = "22CEE8BE8E503CA7A500DF872E2100EC", hash_generated_method = "972760A6CF621D1311D9C14316DF651E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void tryCommit(SharedPreferences.Editor editor) {
        dsTaint.addTaint(editor.dsTaint);
        {
            boolean varA868B554C77E962698C11A447AF0E264_100715459 = (mPreferenceManager.shouldCommit());
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
        // ---------- Original Method ----------
        //if (mPreferenceManager.shouldCommit()) {
            //try {
                //editor.apply();
            //} catch (AbstractMethodError unused) {
                //editor.commit();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.640 -0400", hash_original_method = "386F50F42D6EB5DC2DA2887FAD5D9C7B", hash_generated_method = "2308496925BF850B2E534593E4CB85B0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected boolean persistString(String value) {
        dsTaint.addTaint(value);
        {
            boolean var2ADBD6A37C43E8A998AE5217C3DE0D7C_834872632 = (shouldPersist());
            {
                {
                    boolean varB83E9DE1E67EF06C183B09C0E0D44CCE_532040850 = (value == getPersistedString(null));
                } //End collapsed parenthetic
                SharedPreferences.Editor editor;
                editor = mPreferenceManager.getEditor();
                editor.putString(mKey, value);
                tryCommit(editor);
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.640 -0400", hash_original_method = "5E73C8E580A094A1DF5E2EFDD3570FC9", hash_generated_method = "B7FB01B4C7C6BA120151D8623E046B72")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected String getPersistedString(String defaultReturnValue) {
        dsTaint.addTaint(defaultReturnValue);
        {
            boolean var55473E3F697E9E0994A85A68E07852AD_1626934027 = (!shouldPersist());
        } //End collapsed parenthetic
        String var6876FA9E1BB3A20E2BCB2899113186A1_421773511 = (mPreferenceManager.getSharedPreferences().getString(mKey, defaultReturnValue));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (!shouldPersist()) {
            //return defaultReturnValue;
        //}
        //return mPreferenceManager.getSharedPreferences().getString(mKey, defaultReturnValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.640 -0400", hash_original_method = "48F776762148447BA8C6A8C97BA6FE15", hash_generated_method = "A2591D08934965E3900029D68E0C84E1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected boolean persistStringSet(Set<String> values) {
        dsTaint.addTaint(values.dsTaint);
        {
            boolean var2ADBD6A37C43E8A998AE5217C3DE0D7C_371763464 = (shouldPersist());
            {
                {
                    boolean var65F6840337FA6F30C7823EE44C85EAFD_1833078290 = (values.equals(getPersistedStringSet(null)));
                } //End collapsed parenthetic
                SharedPreferences.Editor editor;
                editor = mPreferenceManager.getEditor();
                editor.putStringSet(mKey, values);
                tryCommit(editor);
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.640 -0400", hash_original_method = "D996103FD4641487F9C96461E983EA55", hash_generated_method = "C59556E4465EBE154F294DB8BED12681")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected Set<String> getPersistedStringSet(Set<String> defaultReturnValue) {
        dsTaint.addTaint(defaultReturnValue.dsTaint);
        {
            boolean var55473E3F697E9E0994A85A68E07852AD_1170217772 = (!shouldPersist());
        } //End collapsed parenthetic
        Set<String> var3CEBD6E92810C23D6057038E8056E83B_1743823532 = (mPreferenceManager.getSharedPreferences().getStringSet(mKey, defaultReturnValue));
        return (Set<String>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (!shouldPersist()) {
            //return defaultReturnValue;
        //}
        //return mPreferenceManager.getSharedPreferences().getStringSet(mKey, defaultReturnValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.641 -0400", hash_original_method = "EDA708B947224EBF19ED1E56671C9A01", hash_generated_method = "95ACB20CAAB337822CECAD0A3BE0361A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected boolean persistInt(int value) {
        dsTaint.addTaint(value);
        {
            boolean var2ADBD6A37C43E8A998AE5217C3DE0D7C_623601441 = (shouldPersist());
            {
                {
                    boolean varEB0E728FD1FBEED4ABBE87C7B22789DA_1154206052 = (value == getPersistedInt(~value));
                } //End collapsed parenthetic
                SharedPreferences.Editor editor;
                editor = mPreferenceManager.getEditor();
                editor.putInt(mKey, value);
                tryCommit(editor);
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.641 -0400", hash_original_method = "7BDEA34D831595E2EEF9485CF72F7029", hash_generated_method = "73F0510469D4084E52C24CB3C578636E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected int getPersistedInt(int defaultReturnValue) {
        dsTaint.addTaint(defaultReturnValue);
        {
            boolean var55473E3F697E9E0994A85A68E07852AD_1279804389 = (!shouldPersist());
        } //End collapsed parenthetic
        int varC34E9779AB3566FB4786F87E273A6847_1483952630 = (mPreferenceManager.getSharedPreferences().getInt(mKey, defaultReturnValue));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (!shouldPersist()) {
            //return defaultReturnValue;
        //}
        //return mPreferenceManager.getSharedPreferences().getInt(mKey, defaultReturnValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.641 -0400", hash_original_method = "554687CB7FDF3E22A2095D4942A8012F", hash_generated_method = "E21EBED198DD426AE36195C5F372D3D0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected boolean persistFloat(float value) {
        dsTaint.addTaint(value);
        {
            boolean var2ADBD6A37C43E8A998AE5217C3DE0D7C_1322236337 = (shouldPersist());
            {
                {
                    boolean var5BA3946435CBD6AB81EDEDE75B77B581_1342172725 = (value == getPersistedFloat(Float.NaN));
                } //End collapsed parenthetic
                SharedPreferences.Editor editor;
                editor = mPreferenceManager.getEditor();
                editor.putFloat(mKey, value);
                tryCommit(editor);
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.641 -0400", hash_original_method = "AB28180DBEC7B1C710871982C247343B", hash_generated_method = "6FCCF235E146EE855021DDFD26DB80E2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected float getPersistedFloat(float defaultReturnValue) {
        dsTaint.addTaint(defaultReturnValue);
        {
            boolean var55473E3F697E9E0994A85A68E07852AD_1407764453 = (!shouldPersist());
        } //End collapsed parenthetic
        float var3819A127749B4528B16EFCD41C31A62A_1866948021 = (mPreferenceManager.getSharedPreferences().getFloat(mKey, defaultReturnValue));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //if (!shouldPersist()) {
            //return defaultReturnValue;
        //}
        //return mPreferenceManager.getSharedPreferences().getFloat(mKey, defaultReturnValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.642 -0400", hash_original_method = "C10CC879E3FA9306B83F34EDB87FCEA5", hash_generated_method = "66381611376EF0F6979531E954D851DC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected boolean persistLong(long value) {
        dsTaint.addTaint(value);
        {
            boolean var2ADBD6A37C43E8A998AE5217C3DE0D7C_2135814302 = (shouldPersist());
            {
                {
                    boolean varC2E3E3F618AD788AD311EBDC65EA0C3C_1538052558 = (value == getPersistedLong(~value));
                } //End collapsed parenthetic
                SharedPreferences.Editor editor;
                editor = mPreferenceManager.getEditor();
                editor.putLong(mKey, value);
                tryCommit(editor);
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.642 -0400", hash_original_method = "88751F99C7941FFB817628D8E528076A", hash_generated_method = "71BCB424E484370EE7A097244D926363")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected long getPersistedLong(long defaultReturnValue) {
        dsTaint.addTaint(defaultReturnValue);
        {
            boolean var55473E3F697E9E0994A85A68E07852AD_576130772 = (!shouldPersist());
        } //End collapsed parenthetic
        long var92DA105CE3001EF7BDE755DAFE24D62A_1950990522 = (mPreferenceManager.getSharedPreferences().getLong(mKey, defaultReturnValue));
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //if (!shouldPersist()) {
            //return defaultReturnValue;
        //}
        //return mPreferenceManager.getSharedPreferences().getLong(mKey, defaultReturnValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.642 -0400", hash_original_method = "D20BDAFE65F5D54A08F0A9EE0DEAC992", hash_generated_method = "4FEE957F0980843BC3D3A0FD2B9E5E8C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected boolean persistBoolean(boolean value) {
        dsTaint.addTaint(value);
        {
            boolean var2ADBD6A37C43E8A998AE5217C3DE0D7C_774084184 = (shouldPersist());
            {
                {
                    boolean varDA8CE2C0ADCE00323BB90806F37C4C6A_347513605 = (value == getPersistedBoolean(!value));
                } //End collapsed parenthetic
                SharedPreferences.Editor editor;
                editor = mPreferenceManager.getEditor();
                editor.putBoolean(mKey, value);
                tryCommit(editor);
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.643 -0400", hash_original_method = "8F28A5D05D1E365FD2C0E61AA71BE94D", hash_generated_method = "9B26BD25E32ED59944EA367B996A5C13")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected boolean getPersistedBoolean(boolean defaultReturnValue) {
        dsTaint.addTaint(defaultReturnValue);
        {
            boolean var55473E3F697E9E0994A85A68E07852AD_340344525 = (!shouldPersist());
        } //End collapsed parenthetic
        boolean var1A496DFA26948F30715026809567A654_398920948 = (mPreferenceManager.getSharedPreferences().getBoolean(mKey, defaultReturnValue));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (!shouldPersist()) {
            //return defaultReturnValue;
        //}
        //return mPreferenceManager.getSharedPreferences().getBoolean(mKey, defaultReturnValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.643 -0400", hash_original_method = "79DC631A87B79C35E44BC11E3C275CE7", hash_generated_method = "3FFD5B7114F19EDF8D23D0FFC4857B6D")
    @DSModeled(DSC.SAFE)
     boolean hasSpecifiedLayout() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mHasSpecifiedLayout;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.643 -0400", hash_original_method = "F82B18888AE588251FAAB1FF7696A001", hash_generated_method = "2D2FD2793B84F6EB2C09730551E025DB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        String var4DB3928C8A84E10382AE57AEDC02C923_1581922591 = (getFilterableStringBuilder().toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return getFilterableStringBuilder().toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.643 -0400", hash_original_method = "7FA40EC09188F6F1BEA3B1B94241EA4A", hash_generated_method = "B1DD90B297AB1999CD33CD0B31F1486D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     StringBuilder getFilterableStringBuilder() {
        StringBuilder sb;
        sb = new StringBuilder();
        CharSequence title;
        title = getTitle();
        {
            boolean var4315037A3FEAFB24D399CA884BFC6923_923995186 = (!TextUtils.isEmpty(title));
            {
                sb.append(title).append(' ');
            } //End block
        } //End collapsed parenthetic
        CharSequence summary;
        summary = getSummary();
        {
            boolean var7E93AF819D7D3BF2785B92F82525EC8F_1425602445 = (!TextUtils.isEmpty(summary));
            {
                sb.append(summary).append(' ');
            } //End block
        } //End collapsed parenthetic
        {
            boolean var0C7AF3C04C994C56893AB35D4EE77EAD_197959501 = (sb.length() > 0);
            {
                sb.setLength(sb.length() - 1);
            } //End block
        } //End collapsed parenthetic
        return (StringBuilder)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.643 -0400", hash_original_method = "363F8E8F58511FB925A751666AB900BD", hash_generated_method = "ED560FC37F1C26FC6556269015FB7F65")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void saveHierarchyState(Bundle container) {
        dsTaint.addTaint(container.dsTaint);
        dispatchSaveInstanceState(container);
        // ---------- Original Method ----------
        //dispatchSaveInstanceState(container);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.644 -0400", hash_original_method = "1B94F5D63E3EC8B47F4D750B8B09EC88", hash_generated_method = "14E4B15A47E909F21217637F2EA0E9C2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void dispatchSaveInstanceState(Bundle container) {
        dsTaint.addTaint(container.dsTaint);
        {
            boolean var89872EF98F6C0EDCE9736F865AE6C3FC_347997330 = (hasKey());
            {
                mBaseMethodCalled = false;
                Parcelable state;
                state = onSaveInstanceState();
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(
                        "Derived class did not call super.onSaveInstanceState()");
                } //End block
                {
                    container.putParcelable(mKey, state);
                } //End block
            } //End block
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.644 -0400", hash_original_method = "9DD945A60796B8A8FF01F94A77988BE6", hash_generated_method = "20AA04417E7F1F0A9A4AEBDE4D43322B")
    @DSModeled(DSC.SAFE)
    protected Parcelable onSaveInstanceState() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mBaseMethodCalled = true;
        return (Parcelable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //mBaseMethodCalled = true;
        //return BaseSavedState.EMPTY_STATE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.644 -0400", hash_original_method = "D5A51A6B2B5A2D76F277782756F6ADE6", hash_generated_method = "55C93770822FCD36271481C6EDC3F548")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void restoreHierarchyState(Bundle container) {
        dsTaint.addTaint(container.dsTaint);
        dispatchRestoreInstanceState(container);
        // ---------- Original Method ----------
        //dispatchRestoreInstanceState(container);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.645 -0400", hash_original_method = "18F16B162844FF15C24BE293B1033BC4", hash_generated_method = "522A699F00EB6062D6B09B47894A1B14")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void dispatchRestoreInstanceState(Bundle container) {
        dsTaint.addTaint(container.dsTaint);
        {
            boolean var89872EF98F6C0EDCE9736F865AE6C3FC_523198725 = (hasKey());
            {
                Parcelable state;
                state = container.getParcelable(mKey);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.645 -0400", hash_original_method = "18B537C81357A7563BC62FF4E045FAEF", hash_generated_method = "44574B330182588BDFBE34232FC9DCF5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void onRestoreInstanceState(Parcelable state) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(state.dsTaint);
        mBaseMethodCalled = true;
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Wrong state class -- expecting Preference State");
        } //End block
        // ---------- Original Method ----------
        //mBaseMethodCalled = true;
        //if (state != BaseSavedState.EMPTY_STATE && state != null) {
            //throw new IllegalArgumentException("Wrong state class -- expecting Preference State");
        //}
    }

    
    public static class BaseSavedState extends AbsSavedState {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.645 -0400", hash_original_method = "0710B1BECA4AE2A64DE9C58BFD4A1161", hash_generated_method = "4ACD3512EDAF0CD436A59D7D43996808")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public BaseSavedState(Parcel source) {
            super(source);
            dsTaint.addTaint(source.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.645 -0400", hash_original_method = "C61013DFD638DC996F3EF4CC52F40C74", hash_generated_method = "2B77CAA5F5D8683ABCBEA23D85C3C576")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public BaseSavedState(Parcelable superState) {
            super(superState);
            dsTaint.addTaint(superState.dsTaint);
            // ---------- Original Method ----------
        }

        
        public static final Parcelable.Creator<BaseSavedState> CREATOR = new Parcelable.Creator<BaseSavedState>() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.645 -0400", hash_original_method = "35821D2EA4DFAF558F55A1E0F95556F9", hash_generated_method = "9D856AD5336D45020E0CC83A18B7A1F6")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public BaseSavedState createFromParcel(Parcel in) {
                dsTaint.addTaint(in.dsTaint);
                BaseSavedState varB73976D4028B8584E1B119E4444E1DA9_809068042 = (new BaseSavedState(in));
                return (BaseSavedState)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return new BaseSavedState(in);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.646 -0400", hash_original_method = "6AB34CCCCE700DF19CB6D0E0E8A5F161", hash_generated_method = "A64C4390CC6701AA71CA619AF2F368F2")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public BaseSavedState[] newArray(int size) {
                dsTaint.addTaint(size);
                BaseSavedState[] var7EF7841C2B7A5BA6B50A897F1043D76A_1695450484 = (new BaseSavedState[size]);
                return (BaseSavedState[])dsTaint.getTaint();
                // ---------- Original Method ----------
                //return new BaseSavedState[size];
            }

            
}; //Transformed anonymous class
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
    
    public static final int DEFAULT_ORDER = Integer.MAX_VALUE;
}

