package android.view;

// Droidsafe Imports
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

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;
import droidsafe.runtime.DroidSafeAndroidRuntime;
// import Iterator to deal with enhanced for loop translation

public class MenuInflater {
    private static final String LOG_TAG = "MenuInflater";
    private static final String XML_MENU = "menu";
    private static final String XML_GROUP = "group";
    private static final String XML_ITEM = "item";
    private static final int NO_ID = 0;
    private static final Class<?>[] ACTION_VIEW_CONSTRUCTOR_SIGNATURE = new Class[] {Context.class};
    private static final Class<?>[] ACTION_PROVIDER_CONSTRUCTOR_SIGNATURE = ACTION_VIEW_CONSTRUCTOR_SIGNATURE;
    private final Object[] mActionViewConstructorArguments;
    private final Object[] mActionProviderConstructorArguments;
    private Context mContext;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.424 -0400", hash_original_method = "DAFF641201C63E19412016666CD58FB3", hash_generated_method = "EE8026DF7A4AEF3789D2546668F10565")
    @DSModeled(DSC.SAFE)
    public MenuInflater(Context context) {
        dsTaint.addTaint(context.dsTaint);
        mActionViewConstructorArguments = new Object[] {context};
        mActionProviderConstructorArguments = mActionViewConstructorArguments;
        // ---------- Original Method ----------
        //mContext = context;
        //mActionViewConstructorArguments = new Object[] {context};
        //mActionProviderConstructorArguments = mActionViewConstructorArguments;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.424 -0400", hash_original_method = "7D92BCA17E1F22EC74058A02DB16DD4F", hash_generated_method = "1FBB0B54AD2C6AC9EFA6DFAFE28C28F9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void inflate(int menuRes, Menu menu) {
        dsTaint.addTaint(menu.dsTaint);
        dsTaint.addTaint(menuRes);
        XmlResourceParser parser;
        parser = null;
        try 
        {
            parser = mContext.getResources().getLayout(menuRes);
            AttributeSet attrs;
            attrs = Xml.asAttributeSet(parser);
            parseMenu(parser, attrs, menu);
        } //End block
        catch (XmlPullParserException e)
        {
            throw new InflateException("Error inflating menu XML", e);
        } //End block
        catch (IOException e)
        {
            throw new InflateException("Error inflating menu XML", e);
        } //End block
        finally 
        {
            parser.close();
        } //End block
        // ---------- Original Method ----------
        //XmlResourceParser parser = null;
        //try {
            //parser = mContext.getResources().getLayout(menuRes);
            //AttributeSet attrs = Xml.asAttributeSet(parser);
            //parseMenu(parser, attrs, menu);
        //} catch (XmlPullParserException e) {
            //throw new InflateException("Error inflating menu XML", e);
        //} catch (IOException e) {
            //throw new InflateException("Error inflating menu XML", e);
        //} finally {
            //if (parser != null) parser.close();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.424 -0400", hash_original_method = "9930459085CDC2417094A7A8585D74E6", hash_generated_method = "C084CBFA9AD6A82AF110E8905FA2C4C5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void parseMenu(XmlPullParser parser, AttributeSet attrs, Menu menu) throws XmlPullParserException, IOException {
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(menu.dsTaint);
        dsTaint.addTaint(parser.dsTaint);
        MenuState menuState;
        menuState = new MenuState(menu);
        int eventType;
        eventType = parser.getEventType();
        String tagName;
        boolean lookingForEndOfUnknownTag;
        lookingForEndOfUnknownTag = false;
        String unknownTagName;
        unknownTagName = null;
        {
            {
                tagName = parser.getName();
                {
                    boolean var9CCB7BAC13C969AD362B259014E951BF_1828805572 = (tagName.equals(XML_MENU));
                    {
                        eventType = parser.next();
                    } //End block
                } //End collapsed parenthetic
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Expecting menu, got " + tagName);
            } //End block
            eventType = parser.next();
        } //End block
        boolean reachedEndOfMenu;
        reachedEndOfMenu = false;
        {
            //Begin case XmlPullParser.START_TAG 
            tagName = parser.getName();
            //End case XmlPullParser.START_TAG 
            //Begin case XmlPullParser.START_TAG 
            {
                boolean var06735938CC742DA237A5AA956C6C42C5_906672458 = (tagName.equals(XML_GROUP));
                {
                    menuState.readGroup(attrs);
                } //End block
                {
                    boolean var17BF2DF7C65C8DAF0549CD525A38CEE3_1066678811 = (tagName.equals(XML_ITEM));
                    {
                        menuState.readItem(attrs);
                    } //End block
                    {
                        boolean var2AD187A82C9BC290A155265942EB19F2_1423790818 = (tagName.equals(XML_MENU));
                        {
                            SubMenu subMenu;
                            subMenu = menuState.addSubMenuItem();
                            parseMenu(parser, attrs, subMenu);
                        } //End block
                        {
                            lookingForEndOfUnknownTag = true;
                            unknownTagName = tagName;
                        } //End block
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End collapsed parenthetic
            //End case XmlPullParser.START_TAG 
            //Begin case XmlPullParser.END_TAG 
            tagName = parser.getName();
            //End case XmlPullParser.END_TAG 
            //Begin case XmlPullParser.END_TAG 
            {
                boolean var24B02B07F0CCFAF88AE9E1B3596AB473_1387229482 = (lookingForEndOfUnknownTag && tagName.equals(unknownTagName));
                {
                    lookingForEndOfUnknownTag = false;
                    unknownTagName = null;
                } //End block
                {
                    boolean var5128EA2C37383EFE109673AABCB41757_596326269 = (tagName.equals(XML_GROUP));
                    {
                        menuState.resetGroup();
                    } //End block
                    {
                        boolean varAC2816D664C6A3E40FDF427ED6713CCB_571457201 = (tagName.equals(XML_ITEM));
                        {
                            {
                                boolean varC95D3D4788F89F1A516ABEDD78453836_349910745 = (!menuState.hasAddedItem());
                                {
                                    {
                                        boolean var109D657CC5D8C957FC8FE2485E1298F5_920727981 = (menuState.itemActionProvider != null &&
                                    menuState.itemActionProvider.hasSubMenu());
                                        {
                                            menuState.addSubMenuItem();
                                        } //End block
                                        {
                                            menuState.addItem();
                                        } //End block
                                    } //End collapsed parenthetic
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                        {
                            boolean var7BD40C7DE57A7C30CB915C9680E5EDD6_437682359 = (tagName.equals(XML_MENU));
                            {
                                reachedEndOfMenu = true;
                            } //End block
                        } //End collapsed parenthetic
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End collapsed parenthetic
            //End case XmlPullParser.END_TAG 
            //Begin case XmlPullParser.END_DOCUMENT 
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Unexpected end of document");
            //End case XmlPullParser.END_DOCUMENT 
            eventType = parser.next();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    private static class InflatedOnMenuItemClickListener implements MenuItem.OnMenuItemClickListener {
        private static final Class<?>[] PARAM_TYPES = new Class[] { MenuItem.class };
        private Context mContext;
        private Method mMethod;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.425 -0400", hash_original_method = "71989E75CB41D046D01EA62CF0B3F6AF", hash_generated_method = "1F0C2E45C730D269DFFD90E26600D31B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public InflatedOnMenuItemClickListener(Context context, String methodName) {
            dsTaint.addTaint(context.dsTaint);
            dsTaint.addTaint(methodName);
            Class<?> c;
            c = context.getClass();
            try 
            {
                mMethod = c.getMethod(methodName, PARAM_TYPES);
            } //End block
            catch (Exception e)
            {
                InflateException ex;
                ex = new InflateException(
                        "Couldn't resolve menu item onClick handler " + methodName +
                        " in class " + c.getName());
                ex.initCause(e);
                throw ex;
            } //End block
            // ---------- Original Method ----------
            //mContext = context;
            //Class<?> c = context.getClass();
            //try {
                //mMethod = c.getMethod(methodName, PARAM_TYPES);
            //} catch (Exception e) {
                //InflateException ex = new InflateException(
                        //"Couldn't resolve menu item onClick handler " + methodName +
                        //" in class " + c.getName());
                //ex.initCause(e);
                //throw ex;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.425 -0400", hash_original_method = "73DDD6FE1A9FD43CC9793E596C7A60B9", hash_generated_method = "C1DCC5E3C0304C129BECDF91ED747FB8")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean onMenuItemClick(MenuItem item) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(item.dsTaint);
            try 
            {
                {
                    boolean varD1E827A28BBA387F0A15B2DD410BC945_1586189361 = (mMethod.getReturnType() == Boolean.TYPE);
                    {
                        boolean var823BC65078D4D4799D67201B185472A5_408725170 = ((Boolean) mMethod.invoke(mContext, item));
                    } //End block
                    {
                        mMethod.invoke(mContext, item);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            catch (Exception e)
            {
                throw new RuntimeException(e);
            } //End block
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //try {
                //if (mMethod.getReturnType() == Boolean.TYPE) {
                    //return (Boolean) mMethod.invoke(mContext, item);
                //} else {
                    //mMethod.invoke(mContext, item);
                    //return true;
                //}
            //} catch (Exception e) {
                //throw new RuntimeException(e);
            //}
        }

        
    }


    
    private class MenuState {
        private Menu menu;
        private int groupId;
        private int groupCategory;
        private int groupOrder;
        private int groupCheckable;
        private boolean groupVisible;
        private boolean groupEnabled;
        private boolean itemAdded;
        private int itemId;
        private int itemCategoryOrder;
        private CharSequence itemTitle;
        private CharSequence itemTitleCondensed;
        private int itemIconResId;
        private char itemAlphabeticShortcut;
        private char itemNumericShortcut;
        private int itemCheckable;
        private boolean itemChecked;
        private boolean itemVisible;
        private boolean itemEnabled;
        private int itemShowAsAction;
        private int itemActionViewLayout;
        private String itemActionViewClassName;
        private String itemActionProviderClassName;
        private String itemListenerMethodName;
        private ActionProvider itemActionProvider;
        private static final int defaultGroupId = NO_ID;
        private static final int defaultItemId = NO_ID;
        private static final int defaultItemCategory = 0;
        private static final int defaultItemOrder = 0;
        private static final int defaultItemCheckable = 0;
        private static final boolean defaultItemChecked = false;
        private static final boolean defaultItemVisible = true;
        private static final boolean defaultItemEnabled = true;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.425 -0400", hash_original_method = "D92FD84364574F36A2E6DED89015926B", hash_generated_method = "7B0AB15347C034D27FF050263D435DD5")
        @DSModeled(DSC.SAFE)
        public MenuState(final Menu menu) {
            dsTaint.addTaint(menu.dsTaint);
            resetGroup();
            // ---------- Original Method ----------
            //this.menu = menu;
            //resetGroup();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.425 -0400", hash_original_method = "72B0BA7C11D7E690CFEDBC790E5F02DB", hash_generated_method = "6F09AAE2801A125C0F809D90268774E2")
        @DSModeled(DSC.SAFE)
        public void resetGroup() {
            groupId = defaultGroupId;
            groupCategory = defaultItemCategory;
            groupOrder = defaultItemOrder;
            groupCheckable = defaultItemCheckable;
            groupVisible = defaultItemVisible;
            groupEnabled = defaultItemEnabled;
            // ---------- Original Method ----------
            //groupId = defaultGroupId;
            //groupCategory = defaultItemCategory;
            //groupOrder = defaultItemOrder;
            //groupCheckable = defaultItemCheckable;
            //groupVisible = defaultItemVisible;
            //groupEnabled = defaultItemEnabled;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.426 -0400", hash_original_method = "D2A59B8CE3FF522E41AA18E3F41E01E5", hash_generated_method = "7E385F8373E6A9D962F7A2C953BCD410")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void readGroup(AttributeSet attrs) {
            dsTaint.addTaint(attrs.dsTaint);
            TypedArray a;
            a = mContext.obtainStyledAttributes(attrs,
                    com.android.internal.R.styleable.MenuGroup);
            groupId = a.getResourceId(com.android.internal.R.styleable.MenuGroup_id, defaultGroupId);
            groupCategory = a.getInt(com.android.internal.R.styleable.MenuGroup_menuCategory, defaultItemCategory);
            groupOrder = a.getInt(com.android.internal.R.styleable.MenuGroup_orderInCategory, defaultItemOrder);
            groupCheckable = a.getInt(com.android.internal.R.styleable.MenuGroup_checkableBehavior, defaultItemCheckable);
            groupVisible = a.getBoolean(com.android.internal.R.styleable.MenuGroup_visible, defaultItemVisible);
            groupEnabled = a.getBoolean(com.android.internal.R.styleable.MenuGroup_enabled, defaultItemEnabled);
            a.recycle();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.426 -0400", hash_original_method = "040ADD8FC534832950800B9A55359142", hash_generated_method = "A1891D7AD0D49BF67985C02B6FAED4C9")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void readItem(AttributeSet attrs) {
            dsTaint.addTaint(attrs.dsTaint);
            TypedArray a;
            a = mContext.obtainStyledAttributes(attrs,
                    com.android.internal.R.styleable.MenuItem);
            itemId = a.getResourceId(com.android.internal.R.styleable.MenuItem_id, defaultItemId);
            final int category;
            category = a.getInt(com.android.internal.R.styleable.MenuItem_menuCategory, groupCategory);
            final int order;
            order = a.getInt(com.android.internal.R.styleable.MenuItem_orderInCategory, groupOrder);
            itemCategoryOrder = (category & Menu.CATEGORY_MASK) | (order & Menu.USER_MASK);
            itemTitle = a.getText(com.android.internal.R.styleable.MenuItem_title);
            itemTitleCondensed = a.getText(com.android.internal.R.styleable.MenuItem_titleCondensed);
            itemIconResId = a.getResourceId(com.android.internal.R.styleable.MenuItem_icon, 0);
            itemAlphabeticShortcut =
                    getShortcut(a.getString(com.android.internal.R.styleable.MenuItem_alphabeticShortcut));
            itemNumericShortcut =
                    getShortcut(a.getString(com.android.internal.R.styleable.MenuItem_numericShortcut));
            {
                boolean var8B68EBF2C32DFF7A57B9A2EFC06FDA44_507034470 = (a.hasValue(com.android.internal.R.styleable.MenuItem_checkable));
                {
                    itemCheckable = a.getBoolean(com.android.internal.R.styleable.MenuItem_checkable, false) ? 1 : 0;
                } //End block
                {
                    itemCheckable = groupCheckable;
                } //End block
            } //End collapsed parenthetic
            itemChecked = a.getBoolean(com.android.internal.R.styleable.MenuItem_checked, defaultItemChecked);
            itemVisible = a.getBoolean(com.android.internal.R.styleable.MenuItem_visible, groupVisible);
            itemEnabled = a.getBoolean(com.android.internal.R.styleable.MenuItem_enabled, groupEnabled);
            itemShowAsAction = a.getInt(com.android.internal.R.styleable.MenuItem_showAsAction, -1);
            itemListenerMethodName = a.getString(com.android.internal.R.styleable.MenuItem_onClick);
            itemActionViewLayout = a.getResourceId(com.android.internal.R.styleable.MenuItem_actionLayout, 0);
            itemActionViewClassName = a.getString(com.android.internal.R.styleable.MenuItem_actionViewClass);
            itemActionProviderClassName = a.getString(com.android.internal.R.styleable.MenuItem_actionProviderClass);
            final boolean hasActionProvider;
            hasActionProvider = itemActionProviderClassName != null;
            {
                itemActionProvider = newInstance(itemActionProviderClassName,
                            ACTION_PROVIDER_CONSTRUCTOR_SIGNATURE,
                            mActionProviderConstructorArguments);
            } //End block
            {
                itemActionProvider = null;
            } //End block
            a.recycle();
            itemAdded = false;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.426 -0400", hash_original_method = "68CBADC6295F8D47EFE8794BDB31E4A9", hash_generated_method = "4A4A3EF3B1380B49395577800C4BFD7E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private char getShortcut(String shortcutString) {
            dsTaint.addTaint(shortcutString);
            {
                char var94DDD9FE6ADE092287A1BAC249BEBC0A_63653906 = (shortcutString.charAt(0));
            } //End block
            return dsTaint.getTaintChar();
            // ---------- Original Method ----------
            //if (shortcutString == null) {
                //return 0;
            //} else {
                //return shortcutString.charAt(0);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.427 -0400", hash_original_method = "AD827357C34932CC0921A74B0CE8A3EF", hash_generated_method = "ADC2E46973DBE558DB7B10DE87F52AB5")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void setItem(MenuItem item) {
            dsTaint.addTaint(item.dsTaint);
            item.setChecked(itemChecked)
                .setVisible(itemVisible)
                .setEnabled(itemEnabled)
                .setCheckable(itemCheckable >= 1)
                .setTitleCondensed(itemTitleCondensed)
                .setIcon(itemIconResId)
                .setAlphabeticShortcut(itemAlphabeticShortcut)
                .setNumericShortcut(itemNumericShortcut);
            {
                item.setShowAsAction(itemShowAsAction);
            } //End block
            {
                {
                    boolean varEB9F229BDF825669A5F4C4A08D921F80_1963011502 = (mContext.isRestricted());
                    {
                        if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("The android:onClick attribute cannot "
                            + "be used within a restricted context");
                    } //End block
                } //End collapsed parenthetic
                item.setOnMenuItemClickListener(
                        new InflatedOnMenuItemClickListener(mContext, itemListenerMethodName));
            } //End block
            {
                MenuItemImpl impl;
                impl = (MenuItemImpl) item;
                {
                    impl.setExclusiveCheckable(true);
                } //End block
            } //End block
            boolean actionViewSpecified;
            actionViewSpecified = false;
            {
                View actionView;
                actionView = (View) newInstance(itemActionViewClassName,
                        ACTION_VIEW_CONSTRUCTOR_SIGNATURE, mActionViewConstructorArguments);
                item.setActionView(actionView);
                actionViewSpecified = true;
            } //End block
            {
                {
                    item.setActionView(itemActionViewLayout);
                    actionViewSpecified = true;
                } //End block
            } //End block
            {
                item.setActionProvider(itemActionProvider);
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.427 -0400", hash_original_method = "A5F782FF20BD7C7C25F84F91CFB5DEC5", hash_generated_method = "E4565D179B8DBA7C891954FC2687B620")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void addItem() {
            itemAdded = true;
            setItem(menu.add(groupId, itemId, itemCategoryOrder, itemTitle));
            // ---------- Original Method ----------
            //itemAdded = true;
            //setItem(menu.add(groupId, itemId, itemCategoryOrder, itemTitle));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.427 -0400", hash_original_method = "68ADA6E6B9635F44A93B8212F1D6D8E0", hash_generated_method = "B0DFF6E9792B56BC6914F9B9299A9F7F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public SubMenu addSubMenuItem() {
            itemAdded = true;
            SubMenu subMenu;
            subMenu = menu.addSubMenu(groupId, itemId, itemCategoryOrder, itemTitle);
            setItem(subMenu.getItem());
            return (SubMenu)dsTaint.getTaint();
            // ---------- Original Method ----------
            //itemAdded = true;
            //SubMenu subMenu = menu.addSubMenu(groupId, itemId, itemCategoryOrder, itemTitle);
            //setItem(subMenu.getItem());
            //return subMenu;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.427 -0400", hash_original_method = "EEE8EEEED979875FD25E1447BB361BB0", hash_generated_method = "2F52AD5E46DABB13911FCD3207833B80")
        @DSModeled(DSC.SAFE)
        public boolean hasAddedItem() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return itemAdded;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.427 -0400", hash_original_method = "20DE6E19862FEEC3F61B05674F46168C", hash_generated_method = "CCD59C398BA799B150FAE50E66AB023F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @SuppressWarnings("unchecked")
        private <T> T newInstance(String className, Class<?>[] constructorSignature,
                Object[] arguments) {
            dsTaint.addTaint(constructorSignature[0].dsTaint);
            dsTaint.addTaint(arguments[0].dsTaint);
            dsTaint.addTaint(className);
            try 
            {
                Class<?> clazz;
                clazz = mContext.getClassLoader().loadClass(className);
                Constructor<?> constructor;
                constructor = clazz.getConstructor(constructorSignature);
                T var78D669D70149CC5115760FDB92FEDF5F_1683712261 = ((T) constructor.newInstance(arguments));
            } //End block
            catch (Exception e)
            { }
            return (T)dsTaint.getTaint();
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


    
}


