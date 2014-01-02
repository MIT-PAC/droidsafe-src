package android.view;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Xml;

import com.android.internal.view.menu.MenuItemImpl;






public class MenuInflater {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:13.620 -0500", hash_original_field = "2E94B53EF613A693B0996353437BBC3B", hash_generated_field = "D20A60ABCBBC55D65DAE10150B450C42")

    private static final String LOG_TAG = "MenuInflater";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:13.623 -0500", hash_original_field = "E8571A1D1D35A75FA974D66944CD7F20", hash_generated_field = "E31E26254373C198064DD9A1A92086C6")

    private static final String XML_MENU = "menu";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:13.626 -0500", hash_original_field = "2B3BD04992C664DFBB50E960088EBF17", hash_generated_field = "741934D10DDA27952BC09F06E8B134F1")

    private static final String XML_GROUP = "group";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:13.628 -0500", hash_original_field = "7AE15B08CFBB6EABBC3957062F9FBBC0", hash_generated_field = "E6B1030CD1EE1C83F812536C256CA27C")

    private static final String XML_ITEM = "item";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:13.631 -0500", hash_original_field = "7268E03A5340DB38AA6685B8AA605B67", hash_generated_field = "E013106922B0138DD6AA1961763950FB")


    private static final int NO_ID = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:13.633 -0500", hash_original_field = "D4148E18C49BEF6E1A417002BD55A8B1", hash_generated_field = "106DC72A08073671C77A7D24FBF7A3A9")

    
    private static final Class<?>[] ACTION_VIEW_CONSTRUCTOR_SIGNATURE = new Class[] {Context.class};

    
    private static class InflatedOnMenuItemClickListener implements MenuItem.OnMenuItemClickListener {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:13.656 -0500", hash_original_field = "567A69EE4C29AF43AB1D9BF04D5D198A", hash_generated_field = "4E7C1F29221D5B4F692E0E4123556FA9")

        private static final Class<?>[] PARAM_TYPES = new Class[] { MenuItem.class };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:13.658 -0500", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

        
        private Context mContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:13.660 -0500", hash_original_field = "1AE782A3C6D55F3EEA9985EDCF6719E3", hash_generated_field = "B855DD63C0CF0451E81317C9109F465D")

        private Method mMethod;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:13.663 -0500", hash_original_method = "71989E75CB41D046D01EA62CF0B3F6AF", hash_generated_method = "EF515AC8F4090B19FD667993E6B70BD5")
        
public InflatedOnMenuItemClickListener(Context context, String methodName) {
            mContext = context;
            Class<?> c = context.getClass();
            try {
                mMethod = c.getMethod(methodName, PARAM_TYPES);
            } catch (Exception e) {
                InflateException ex = new InflateException(
                        "Couldn't resolve menu item onClick handler " + methodName +
                        " in class " + c.getName());
                ex.initCause(e);
                throw ex;
            }
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:13.666 -0500", hash_original_method = "73DDD6FE1A9FD43CC9793E596C7A60B9", hash_generated_method = "B3FF1FC79AE9949CFEC0CD4E6EF6FF65")
        
public boolean onMenuItemClick(MenuItem item) {
            try {
                if (mMethod.getReturnType() == Boolean.TYPE) {
                    return (Boolean) mMethod.invoke(mContext, item);
                } else {
                    mMethod.invoke(mContext, item);
                    return true;
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }


    
    private class MenuState {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:13.745 -0500", hash_original_field = "EFA4C4257EBC0424D12E4CA3BD548035", hash_generated_field = "9B0EAA24CB9224A5FE3BD9693FBF1290")


        private static final int defaultGroupId = NO_ID;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:13.748 -0500", hash_original_field = "0AC1A69E6C36BE0C0D1D684445FEB923", hash_generated_field = "B1A5636EE8810E13399D9A82AEDDE266")

        private static final int defaultItemId = NO_ID;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:13.750 -0500", hash_original_field = "853728314F98D76992B6DAB10140291D", hash_generated_field = "E557B462E112C16C557769E30462DB8E")

        private static final int defaultItemCategory = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:13.753 -0500", hash_original_field = "07AC3D3DB14F8595937D19F7463013DA", hash_generated_field = "152C9E502C21ADC75747E2BF857E3CE3")

        private static final int defaultItemOrder = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:13.755 -0500", hash_original_field = "2DE3C890C247D95E36827B542B36D0CC", hash_generated_field = "BC4B72460E275E09F07002E077B83F00")

        private static final int defaultItemCheckable = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:13.758 -0500", hash_original_field = "0C70AECB50ACC3231B9CE8AD1851A53E", hash_generated_field = "5501360C826E8D093BCA0962DDC25D61")

        private static final boolean defaultItemChecked = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:13.761 -0500", hash_original_field = "5F9BC518863BDC919DA9AA78524922C8", hash_generated_field = "0F4E84529E0007C03A0C834BAA011961")

        private static final boolean defaultItemVisible = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:13.764 -0500", hash_original_field = "526B68851E5479EC194323E0DF413C38", hash_generated_field = "6E2F2A9249EFDFBFB590C339E8D30C46")

        private static final boolean defaultItemEnabled = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:13.670 -0500", hash_original_field = "1E865D4E4C30F48353BEC7E352A88836", hash_generated_field = "EBFD741431E8DE9C083EBC58DFDB2182")

        private Menu menu;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:13.672 -0500", hash_original_field = "A79CA6625B5C8E597041E2AFC1103EAF", hash_generated_field = "3155320D6BE7D95B85750DFFC9E5995D")

        private int groupId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:13.675 -0500", hash_original_field = "B7BA19118675B57E5F7AEE660AAF3820", hash_generated_field = "1A6D7DC41F757CD5668984751FD3C6E2")

        private int groupCategory;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:13.677 -0500", hash_original_field = "9B64ED526AC375E4A6D60FB01375D0DE", hash_generated_field = "9EF2C3892F70AD6A35371ABD9F471781")

        private int groupOrder;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:13.680 -0500", hash_original_field = "A9AF97A6E790BD76084498E5E95C87C0", hash_generated_field = "77EE17F78AAC54A36F4164FA10968348")

        private int groupCheckable;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:13.682 -0500", hash_original_field = "BC570F1709278A7FA68C3815F99EFA39", hash_generated_field = "D1FD88AFEC99265E4CDA6BCB5BCD43CC")

        private boolean groupVisible;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:13.686 -0500", hash_original_field = "6749E32AF495F1676512AB105A397C42", hash_generated_field = "8958686EBC65BD208970E858023B9ACF")

        private boolean groupEnabled;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:13.688 -0500", hash_original_field = "A0BACE7E59AB4582BA54B215045A013B", hash_generated_field = "2DDEE577B276C7F743A05F54FF208655")


        private boolean itemAdded;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:13.691 -0500", hash_original_field = "41218F715048053EA7B7DEA2DC1E4E88", hash_generated_field = "045BA405BBFDE1B40EE9E7B189E29F11")

        private int itemId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:13.695 -0500", hash_original_field = "06150BECF04DE5FD8E6001FDDF084AB4", hash_generated_field = "0669523630C2C53A717BD2EC0123C065")

        private int itemCategoryOrder;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:13.699 -0500", hash_original_field = "9A87FDF4DFBCB1DFDA00157779803B5E", hash_generated_field = "FE49FE8D3E1447C23568F3309357DFAD")

        private CharSequence itemTitle;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:13.705 -0500", hash_original_field = "FB5FBEBD4AB44C07790F0166539BB0F6", hash_generated_field = "8E6B9AE69A0A2C5DDBBCE17A79DCA0BD")

        private CharSequence itemTitleCondensed;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:13.709 -0500", hash_original_field = "533F9CAA3D9EFC22D16CA0864410E423", hash_generated_field = "C149FC28C7B4B83A4026499AD670C3E5")

        private int itemIconResId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:13.712 -0500", hash_original_field = "F5746223334F3419D171578EB407DF16", hash_generated_field = "E99483E8E36A19083D27AFBB86F65981")

        private char itemAlphabeticShortcut;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:13.717 -0500", hash_original_field = "5BB94A9DC0FDA5EE685296D58A2A1F2B", hash_generated_field = "28840B4ABBD449A480B1C4DE816C8B8A")

        private char itemNumericShortcut;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:13.719 -0500", hash_original_field = "CAA8BC4E34BFD313818D6F4E5C569134", hash_generated_field = "D3FA3517285F6CE85E526859F91452D2")

        private int itemCheckable;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:13.722 -0500", hash_original_field = "C4E37B644BD2074DC22BE5CFAACA1862", hash_generated_field = "710C3729AD3B78CC1C3A826A33BD9393")

        private boolean itemChecked;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:13.724 -0500", hash_original_field = "C352667903D9B38397A75EE8F45A3302", hash_generated_field = "9A80737C3B64273618B9BD81D7E0648C")

        private boolean itemVisible;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:13.727 -0500", hash_original_field = "93EE89827B3E49EAF435DCD7466EF13E", hash_generated_field = "E0A166B1C34BC3227E1342312BE23A2A")

        private boolean itemEnabled;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:13.729 -0500", hash_original_field = "04B914B54537C223B77EFF4EF1D81C96", hash_generated_field = "741832C0FDD3BBFA6ECD7AFC82592C65")

        private int itemShowAsAction;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:13.731 -0500", hash_original_field = "943DAF9E2911B8F5E67176DCC11C345B", hash_generated_field = "0C49E3693E6055829937C3C14EE98F30")


        private int itemActionViewLayout;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:13.735 -0500", hash_original_field = "3F0037EF5B0A04FB135A7D2F8740915E", hash_generated_field = "541C41A12EF0F2C226F6A51D065BFB05")

        private String itemActionViewClassName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:13.737 -0500", hash_original_field = "8DB93D3C9951F80E5DA066DC69842668", hash_generated_field = "81F611F6A6054E1B692C03FD31C979EC")

        private String itemActionProviderClassName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:13.740 -0500", hash_original_field = "9A1AED9E5EA23E6F3CD948C71CD78CDA", hash_generated_field = "9C1AB4FCB1E8B2C66FCDA272A8DBFF10")


        private String itemListenerMethodName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:13.742 -0500", hash_original_field = "D2E439CDBFBC4C391F160243777AEABD", hash_generated_field = "8A253EC0B6326CC8B14EFB449591E768")

        
        private ActionProvider itemActionProvider;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:13.766 -0500", hash_original_method = "D92FD84364574F36A2E6DED89015926B", hash_generated_method = "F4E12B635D9183A95E5E6F53C3C6132D")
        
public MenuState(final Menu menu) {
            this.menu = menu;
            
            resetGroup();
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:13.769 -0500", hash_original_method = "72B0BA7C11D7E690CFEDBC790E5F02DB", hash_generated_method = "370BB8506FDDC25EE7981F11BC15B3E6")
        
public void resetGroup() {
            groupId = defaultGroupId;
            groupCategory = defaultItemCategory;
            groupOrder = defaultItemOrder;
            groupCheckable = defaultItemCheckable;
            groupVisible = defaultItemVisible;
            groupEnabled = defaultItemEnabled;
        }

        /**
         * Called when the parser is pointing to a group tag.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:13.773 -0500", hash_original_method = "D2A59B8CE3FF522E41AA18E3F41E01E5", hash_generated_method = "6B5ED31DF18619E66F79A277BC7678C1")
        
public void readGroup(AttributeSet attrs) {
            TypedArray a = mContext.obtainStyledAttributes(attrs,
                    com.android.internal.R.styleable.MenuGroup);
            
            groupId = a.getResourceId(com.android.internal.R.styleable.MenuGroup_id, defaultGroupId);
            groupCategory = a.getInt(com.android.internal.R.styleable.MenuGroup_menuCategory, defaultItemCategory);
            groupOrder = a.getInt(com.android.internal.R.styleable.MenuGroup_orderInCategory, defaultItemOrder);
            groupCheckable = a.getInt(com.android.internal.R.styleable.MenuGroup_checkableBehavior, defaultItemCheckable);
            groupVisible = a.getBoolean(com.android.internal.R.styleable.MenuGroup_visible, defaultItemVisible);
            groupEnabled = a.getBoolean(com.android.internal.R.styleable.MenuGroup_enabled, defaultItemEnabled);

            a.recycle();
        }
        
        /**
         * Called when the parser is pointing to an item tag.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:13.777 -0500", hash_original_method = "040ADD8FC534832950800B9A55359142", hash_generated_method = "CEC3304389D4D8294AFF65C72E1F8D09")
        
public void readItem(AttributeSet attrs) {
            TypedArray a = mContext.obtainStyledAttributes(attrs,
                    com.android.internal.R.styleable.MenuItem);

            // Inherit attributes from the group as default value
            itemId = a.getResourceId(com.android.internal.R.styleable.MenuItem_id, defaultItemId);
            final int category = a.getInt(com.android.internal.R.styleable.MenuItem_menuCategory, groupCategory);
            final int order = a.getInt(com.android.internal.R.styleable.MenuItem_orderInCategory, groupOrder);
            itemCategoryOrder = (category & Menu.CATEGORY_MASK) | (order & Menu.USER_MASK);
            itemTitle = a.getText(com.android.internal.R.styleable.MenuItem_title);
            itemTitleCondensed = a.getText(com.android.internal.R.styleable.MenuItem_titleCondensed);
            itemIconResId = a.getResourceId(com.android.internal.R.styleable.MenuItem_icon, 0);
            itemAlphabeticShortcut =
                    getShortcut(a.getString(com.android.internal.R.styleable.MenuItem_alphabeticShortcut));
            itemNumericShortcut =
                    getShortcut(a.getString(com.android.internal.R.styleable.MenuItem_numericShortcut));
            if (a.hasValue(com.android.internal.R.styleable.MenuItem_checkable)) {
                // Item has attribute checkable, use it
                itemCheckable = a.getBoolean(com.android.internal.R.styleable.MenuItem_checkable, false) ? 1 : 0;
            } else {
                // Item does not have attribute, use the group's (group can have one more state
                // for checkable that represents the exclusive checkable)
                itemCheckable = groupCheckable;
            }
            itemChecked = a.getBoolean(com.android.internal.R.styleable.MenuItem_checked, defaultItemChecked);
            itemVisible = a.getBoolean(com.android.internal.R.styleable.MenuItem_visible, groupVisible);
            itemEnabled = a.getBoolean(com.android.internal.R.styleable.MenuItem_enabled, groupEnabled);
            itemShowAsAction = a.getInt(com.android.internal.R.styleable.MenuItem_showAsAction, -1);
            itemListenerMethodName = a.getString(com.android.internal.R.styleable.MenuItem_onClick);
            itemActionViewLayout = a.getResourceId(com.android.internal.R.styleable.MenuItem_actionLayout, 0);
            itemActionViewClassName = a.getString(com.android.internal.R.styleable.MenuItem_actionViewClass);
            itemActionProviderClassName = a.getString(com.android.internal.R.styleable.MenuItem_actionProviderClass);

            final boolean hasActionProvider = itemActionProviderClassName != null;
            if (hasActionProvider && itemActionViewLayout == 0 && itemActionViewClassName == null) {
                itemActionProvider = newInstance(itemActionProviderClassName,
                            ACTION_PROVIDER_CONSTRUCTOR_SIGNATURE,
                            mActionProviderConstructorArguments);
            } else {
                if (hasActionProvider) {
                    Log.w(LOG_TAG, "Ignoring attribute 'actionProviderClass'."
                            + " Action view already specified.");
                }
                itemActionProvider = null;
            }

            a.recycle();

            itemAdded = false;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:13.779 -0500", hash_original_method = "68CBADC6295F8D47EFE8794BDB31E4A9", hash_generated_method = "1EFCA66997A7EB5634D42DB053B48835")
        
private char getShortcut(String shortcutString) {
            if (shortcutString == null) {
                return 0;
            } else {
                return shortcutString.charAt(0);
            }
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:13.782 -0500", hash_original_method = "AD827357C34932CC0921A74B0CE8A3EF", hash_generated_method = "554FBA37346CD68476200A331125138F")
        
private void setItem(MenuItem item) {
            item.setChecked(itemChecked)
                .setVisible(itemVisible)
                .setEnabled(itemEnabled)
                .setCheckable(itemCheckable >= 1)
                .setTitleCondensed(itemTitleCondensed)
                .setIcon(itemIconResId)
                .setAlphabeticShortcut(itemAlphabeticShortcut)
                .setNumericShortcut(itemNumericShortcut);
            
            if (itemShowAsAction >= 0) {
                item.setShowAsAction(itemShowAsAction);
            }
            
            if (itemListenerMethodName != null) {
                if (mContext.isRestricted()) {
                    throw new IllegalStateException("The android:onClick attribute cannot "
                            + "be used within a restricted context");
                }
                item.setOnMenuItemClickListener(
                        new InflatedOnMenuItemClickListener(mContext, itemListenerMethodName));
            }

            if (item instanceof MenuItemImpl) {
                MenuItemImpl impl = (MenuItemImpl) item;
                if (itemCheckable >= 2) {
                    impl.setExclusiveCheckable(true);
                }
            }

            boolean actionViewSpecified = false;
            if (itemActionViewClassName != null) {
                View actionView = (View) newInstance(itemActionViewClassName,
                        ACTION_VIEW_CONSTRUCTOR_SIGNATURE, mActionViewConstructorArguments);
                item.setActionView(actionView);
                actionViewSpecified = true;
            }
            if (itemActionViewLayout > 0) {
                if (!actionViewSpecified) {
                    item.setActionView(itemActionViewLayout);
                    actionViewSpecified = true;
                } else {
                    Log.w(LOG_TAG, "Ignoring attribute 'itemActionViewLayout'."
                            + " Action view already specified.");
                }
            }
            if (itemActionProvider != null) {
                item.setActionProvider(itemActionProvider);
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:13.785 -0500", hash_original_method = "A5F782FF20BD7C7C25F84F91CFB5DEC5", hash_generated_method = "6448ED163FEB7E242BAC8A7ACC8F0A7F")
        
public void addItem() {
            itemAdded = true;
            setItem(menu.add(groupId, itemId, itemCategoryOrder, itemTitle));
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:13.787 -0500", hash_original_method = "68ADA6E6B9635F44A93B8212F1D6D8E0", hash_generated_method = "A440BF85B200B59942ECCFC21D08EA73")
        
public SubMenu addSubMenuItem() {
            itemAdded = true;
            SubMenu subMenu = menu.addSubMenu(groupId, itemId, itemCategoryOrder, itemTitle);
            setItem(subMenu.getItem());
            return subMenu;
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:13.790 -0500", hash_original_method = "EEE8EEEED979875FD25E1447BB361BB0", hash_generated_method = "B4DE8F8A0CB3577859250ADF71D4ECAA")
        
public boolean hasAddedItem() {
            return itemAdded;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.617 -0400", hash_original_method = "20DE6E19862FEEC3F61B05674F46168C", hash_generated_method = "84DCB8177A79929D4BE13F6A57C95E12")
        @SuppressWarnings("unchecked")
        private <T> T newInstance(String className, Class<?>[] constructorSignature,
                Object[] arguments) {
            addTaint(arguments[0].getTaint());
            addTaint(constructorSignature[0].getTaint());
            addTaint(className.getTaint());
            try 
            {
                Class<?> clazz = mContext.getClassLoader().loadClass(className);
                Constructor<?> constructor = clazz.getConstructor(constructorSignature);
T var1B6EA7B4D87788B4A4FAC443448837E5_698570623 =                 (T) constructor.newInstance(arguments);
                var1B6EA7B4D87788B4A4FAC443448837E5_698570623.addTaint(taint);
                return var1B6EA7B4D87788B4A4FAC443448837E5_698570623;
            } //End block
            catch (Exception e)
            {
            } //End block
T var540C13E9E156B687226421B24F2DF178_1858135280 =             null;
            var540C13E9E156B687226421B24F2DF178_1858135280.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1858135280;
            // ---------- Original Method ----------
            //try {
                //Class<?> clazz = mContext.getClassLoader().loadClass(className);
                //Constructor<?> constructor = clazz.getConstructor(constructorSignature);
                //return (T) constructor.newInstance(arguments);
            //} catch (Exception e) {
                //Log.w(LOG_TAG, "Cannot instantiate class: " + className, e);
            //}
            //return null;
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:13.636 -0500", hash_original_field = "4F684130B0122F446A598AD4585A3D11", hash_generated_field = "C7B470A3C7B9F2492DB764AD9D747D63")


    private static final Class<?>[] ACTION_PROVIDER_CONSTRUCTOR_SIGNATURE = ACTION_VIEW_CONSTRUCTOR_SIGNATURE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:13.638 -0500", hash_original_field = "B67C5B388E9FA2DA18ED6D2A1AEFE8AC", hash_generated_field = "2E5F86E900916EB9BA1688830F2A5AD2")


    private  Object[] mActionViewConstructorArguments;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:13.640 -0500", hash_original_field = "9A27EFFBDE324A6C3E883862F710B33A", hash_generated_field = "EF0AF7D7071FC85FAD372A0098884F5B")


    private  Object[] mActionProviderConstructorArguments;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:13.643 -0500", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "C458E619396054F78BC926FB81B4386D")


    private Context mContext;

    /**
     * Constructs a menu inflater.
     * 
     * @see Activity#getMenuInflater()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:13.645 -0500", hash_original_method = "DAFF641201C63E19412016666CD58FB3", hash_generated_method = "65FD16580DDB789B6A6181E83124E0D7")
    
public MenuInflater(Context context) {
        mContext = context;
        mActionViewConstructorArguments = new Object[] {context};
        mActionProviderConstructorArguments = mActionViewConstructorArguments;
    }

    /**
     * Inflate a menu hierarchy from the specified XML resource. Throws
     * {@link InflateException} if there is an error.
     * 
     * @param menuRes Resource ID for an XML layout resource to load (e.g.,
     *            <code>R.menu.main_activity</code>)
     * @param menu The Menu to inflate into. The items and submenus will be
     *            added to this Menu.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:13.649 -0500", hash_original_method = "7D92BCA17E1F22EC74058A02DB16DD4F", hash_generated_method = "8AC21FD0DA7ADD2076DB467059A78ACF")
    
public void inflate(int menuRes, Menu menu) {
        XmlResourceParser parser = null;
        try {
            parser = mContext.getResources().getLayout(menuRes);
            AttributeSet attrs = Xml.asAttributeSet(parser);
            
            parseMenu(parser, attrs, menu);
        } catch (XmlPullParserException e) {
            throw new InflateException("Error inflating menu XML", e);
        } catch (IOException e) {
            throw new InflateException("Error inflating menu XML", e);
        } finally {
            if (parser != null) parser.close();
        }
    }

    /**
     * Called internally to fill the given menu. If a sub menu is seen, it will
     * call this recursively.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:13.652 -0500", hash_original_method = "9930459085CDC2417094A7A8585D74E6", hash_generated_method = "5A33FCD11FD7601B075450C8B2424E13")
    
private void parseMenu(XmlPullParser parser, AttributeSet attrs, Menu menu)
            throws XmlPullParserException, IOException {
        MenuState menuState = new MenuState(menu);

        int eventType = parser.getEventType();
        String tagName;
        boolean lookingForEndOfUnknownTag = false;
        String unknownTagName = null;

        // This loop will skip to the menu start tag
        do {
            if (eventType == XmlPullParser.START_TAG) {
                tagName = parser.getName();
                if (tagName.equals(XML_MENU)) {
                    // Go to next tag
                    eventType = parser.next();
                    break;
                }
                
                throw new RuntimeException("Expecting menu, got " + tagName);
            }
            eventType = parser.next();
        } while (eventType != XmlPullParser.END_DOCUMENT);
        
        boolean reachedEndOfMenu = false;
        while (!reachedEndOfMenu) {
            switch (eventType) {
                case XmlPullParser.START_TAG:
                    if (lookingForEndOfUnknownTag) {
                        break;
                    }
                    
                    tagName = parser.getName();
                    if (tagName.equals(XML_GROUP)) {
                        menuState.readGroup(attrs);
                    } else if (tagName.equals(XML_ITEM)) {
                        menuState.readItem(attrs);
                    } else if (tagName.equals(XML_MENU)) {
                        // A menu start tag denotes a submenu for an item
                        SubMenu subMenu = menuState.addSubMenuItem();

                        // Parse the submenu into returned SubMenu
                        parseMenu(parser, attrs, subMenu);
                    } else {
                        lookingForEndOfUnknownTag = true;
                        unknownTagName = tagName;
                    }
                    break;
                    
                case XmlPullParser.END_TAG:
                    tagName = parser.getName();
                    if (lookingForEndOfUnknownTag && tagName.equals(unknownTagName)) {
                        lookingForEndOfUnknownTag = false;
                        unknownTagName = null;
                    } else if (tagName.equals(XML_GROUP)) {
                        menuState.resetGroup();
                    } else if (tagName.equals(XML_ITEM)) {
                        // Add the item if it hasn't been added (if the item was
                        // a submenu, it would have been added already)
                        if (!menuState.hasAddedItem()) {
                            if (menuState.itemActionProvider != null &&
                                    menuState.itemActionProvider.hasSubMenu()) {
                                menuState.addSubMenuItem();
                            } else {
                                menuState.addItem();
                            }
                        }
                    } else if (tagName.equals(XML_MENU)) {
                        reachedEndOfMenu = true;
                    }
                    break;
                    
                case XmlPullParser.END_DOCUMENT:
                    throw new RuntimeException("Unexpected end of document");
            }
            
            eventType = parser.next();
        }
    }
}

