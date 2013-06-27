package android.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import com.android.internal.view.menu.MenuItemImpl;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class MenuInflater {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.733 -0400", hash_original_field = "0D3A100F87E3688952831AE1B022A084", hash_generated_field = "2E5F86E900916EB9BA1688830F2A5AD2")

    private Object[] mActionViewConstructorArguments;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.733 -0400", hash_original_field = "5DC95856845E2B1CDBDCD4FC6C51DBB5", hash_generated_field = "EF0AF7D7071FC85FAD372A0098884F5B")

    private Object[] mActionProviderConstructorArguments;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.734 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.734 -0400", hash_original_method = "DAFF641201C63E19412016666CD58FB3", hash_generated_method = "D66A694F9921860E9CB1AE3F5CE55449")
    public  MenuInflater(Context context) {
        mContext = context;
        mActionViewConstructorArguments = new Object[] {context};
        mActionProviderConstructorArguments = mActionViewConstructorArguments;
        // ---------- Original Method ----------
        //mContext = context;
        //mActionViewConstructorArguments = new Object[] {context};
        //mActionProviderConstructorArguments = mActionViewConstructorArguments;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.735 -0400", hash_original_method = "7D92BCA17E1F22EC74058A02DB16DD4F", hash_generated_method = "9FE5CAA52FD3D4A653246DCBB9CA6997")
    public void inflate(int menuRes, Menu menu) {
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
            if (DroidSafeAndroidRuntime.control) throw new InflateException("Error inflating menu XML", e);
        } //End block
        catch (IOException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new InflateException("Error inflating menu XML", e);
        } //End block
        finally 
        {
            parser.close();
        } //End block
        addTaint(menuRes);
        addTaint(menu.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.737 -0400", hash_original_method = "9930459085CDC2417094A7A8585D74E6", hash_generated_method = "6B183F2087A46B6F340C468BCFE35EA1")
    private void parseMenu(XmlPullParser parser, AttributeSet attrs, Menu menu) throws XmlPullParserException, IOException {
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
                    boolean var9CCB7BAC13C969AD362B259014E951BF_264198278 = (tagName.equals(XML_MENU));
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
                boolean var06735938CC742DA237A5AA956C6C42C5_638989601 = (tagName.equals(XML_GROUP));
                {
                    menuState.readGroup(attrs);
                } //End block
                {
                    boolean var17BF2DF7C65C8DAF0549CD525A38CEE3_1216285653 = (tagName.equals(XML_ITEM));
                    {
                        menuState.readItem(attrs);
                    } //End block
                    {
                        boolean var2AD187A82C9BC290A155265942EB19F2_329763450 = (tagName.equals(XML_MENU));
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
                boolean var24B02B07F0CCFAF88AE9E1B3596AB473_411439282 = (lookingForEndOfUnknownTag && tagName.equals(unknownTagName));
                {
                    lookingForEndOfUnknownTag = false;
                    unknownTagName = null;
                } //End block
                {
                    boolean var5128EA2C37383EFE109673AABCB41757_1205030718 = (tagName.equals(XML_GROUP));
                    {
                        menuState.resetGroup();
                    } //End block
                    {
                        boolean varAC2816D664C6A3E40FDF427ED6713CCB_447600145 = (tagName.equals(XML_ITEM));
                        {
                            {
                                boolean varC95D3D4788F89F1A516ABEDD78453836_1019737816 = (!menuState.hasAddedItem());
                                {
                                    {
                                        boolean var109D657CC5D8C957FC8FE2485E1298F5_763556078 = (menuState.itemActionProvider != null &&
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
                            boolean var7BD40C7DE57A7C30CB915C9680E5EDD6_314014475 = (tagName.equals(XML_MENU));
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
        addTaint(parser.getTaint());
        addTaint(attrs.getTaint());
        addTaint(menu.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    private static class InflatedOnMenuItemClickListener implements MenuItem.OnMenuItemClickListener {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.737 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

        private Context mContext;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.737 -0400", hash_original_field = "411D2DFDB93368C46AFADBEC76A54162", hash_generated_field = "B855DD63C0CF0451E81317C9109F465D")

        private Method mMethod;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.738 -0400", hash_original_method = "71989E75CB41D046D01EA62CF0B3F6AF", hash_generated_method = "1F65A683D1331EA79A8C995534C14481")
        public  InflatedOnMenuItemClickListener(Context context, String methodName) {
            mContext = context;
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
                if (DroidSafeAndroidRuntime.control) throw ex;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.750 -0400", hash_original_method = "73DDD6FE1A9FD43CC9793E596C7A60B9", hash_generated_method = "BE44DBCDD1074681FEFB5BC396B0CEA2")
        public boolean onMenuItemClick(MenuItem item) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            try 
            {
                {
                    boolean varD1E827A28BBA387F0A15B2DD410BC945_1741146603 = (mMethod.getReturnType() == Boolean.TYPE);
                    {
                        boolean var823BC65078D4D4799D67201B185472A5_725904670 = ((Boolean) mMethod.invoke(mContext, item));
                    } //End block
                    {
                        mMethod.invoke(mContext, item);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            catch (Exception e)
            {
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException(e);
            } //End block
            addTaint(item.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_79234167 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_79234167;
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.750 -0400", hash_original_field = "99100698C623DB826296B976D2ADF5AE", hash_generated_field = "312FDD84FC3F36680D9E37A89B794EFB")

        private static Class<?>[] PARAM_TYPES = new Class[] { MenuItem.class };
    }


    
    private class MenuState {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.750 -0400", hash_original_field = "8D6AB84CA2AF9FCCD4E4048694176EBF", hash_generated_field = "EBFD741431E8DE9C083EBC58DFDB2182")

        private Menu menu;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.750 -0400", hash_original_field = "47DB2588331BBE530C80DD001FC60AED", hash_generated_field = "3155320D6BE7D95B85750DFFC9E5995D")

        private int groupId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.750 -0400", hash_original_field = "8A0C8F23BE7DA26FCF5656EA238C160C", hash_generated_field = "1A6D7DC41F757CD5668984751FD3C6E2")

        private int groupCategory;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.750 -0400", hash_original_field = "813980B2C4B9E51206C585395B16321A", hash_generated_field = "9EF2C3892F70AD6A35371ABD9F471781")

        private int groupOrder;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.750 -0400", hash_original_field = "D6124618670FF99DC0E4DD7870110BA0", hash_generated_field = "77EE17F78AAC54A36F4164FA10968348")

        private int groupCheckable;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.751 -0400", hash_original_field = "6195FFC141760BFDB3A7FF8F20F0917B", hash_generated_field = "D1FD88AFEC99265E4CDA6BCB5BCD43CC")

        private boolean groupVisible;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.751 -0400", hash_original_field = "DE33649E943AA7539920CB42423B5B5A", hash_generated_field = "8958686EBC65BD208970E858023B9ACF")

        private boolean groupEnabled;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.751 -0400", hash_original_field = "D151196352EED1C008F77891EF564455", hash_generated_field = "2DDEE577B276C7F743A05F54FF208655")

        private boolean itemAdded;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.751 -0400", hash_original_field = "59A814AA020A1B32C4674A5887A35022", hash_generated_field = "045BA405BBFDE1B40EE9E7B189E29F11")

        private int itemId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.751 -0400", hash_original_field = "A76704F1E049B0DDFEB1E74E831D8DFA", hash_generated_field = "0669523630C2C53A717BD2EC0123C065")

        private int itemCategoryOrder;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.751 -0400", hash_original_field = "E3E9863B9A779A8F5B5858CE7D553A32", hash_generated_field = "FE49FE8D3E1447C23568F3309357DFAD")

        private CharSequence itemTitle;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.751 -0400", hash_original_field = "038700287C75F4D34F21C15AA43486F5", hash_generated_field = "8E6B9AE69A0A2C5DDBBCE17A79DCA0BD")

        private CharSequence itemTitleCondensed;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.751 -0400", hash_original_field = "2AA1FDE67D33625DFE2C11D411F05786", hash_generated_field = "C149FC28C7B4B83A4026499AD670C3E5")

        private int itemIconResId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.751 -0400", hash_original_field = "A5CFAB791FA49C8A66A3B92D2439E6A4", hash_generated_field = "E99483E8E36A19083D27AFBB86F65981")

        private char itemAlphabeticShortcut;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.751 -0400", hash_original_field = "D3114DCA8EA5D51015461972FAB7F5DC", hash_generated_field = "28840B4ABBD449A480B1C4DE816C8B8A")

        private char itemNumericShortcut;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.751 -0400", hash_original_field = "EA262FC3F4EAF0C5BADBB45BC10CA77F", hash_generated_field = "D3FA3517285F6CE85E526859F91452D2")

        private int itemCheckable;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.751 -0400", hash_original_field = "9498316030632096360DE61E99BF31F6", hash_generated_field = "710C3729AD3B78CC1C3A826A33BD9393")

        private boolean itemChecked;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.751 -0400", hash_original_field = "B7254B58E64BA10BEE73D2BB3E532CB3", hash_generated_field = "9A80737C3B64273618B9BD81D7E0648C")

        private boolean itemVisible;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.751 -0400", hash_original_field = "FEC85B88BAFC4E1BE44967AA726E3A76", hash_generated_field = "E0A166B1C34BC3227E1342312BE23A2A")

        private boolean itemEnabled;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.751 -0400", hash_original_field = "4A22865C14EF54F4211362792BED87D3", hash_generated_field = "741832C0FDD3BBFA6ECD7AFC82592C65")

        private int itemShowAsAction;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.756 -0400", hash_original_field = "F647F57FE175416309660A740D5B7284", hash_generated_field = "0C49E3693E6055829937C3C14EE98F30")

        private int itemActionViewLayout;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.756 -0400", hash_original_field = "BA74AC23982C9D6C5BD24F46B5337B18", hash_generated_field = "541C41A12EF0F2C226F6A51D065BFB05")

        private String itemActionViewClassName;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.756 -0400", hash_original_field = "033A05897B135735BE1B28B0F450E4FA", hash_generated_field = "81F611F6A6054E1B692C03FD31C979EC")

        private String itemActionProviderClassName;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.756 -0400", hash_original_field = "61F89D712E9E075BF67BC31BC59A491D", hash_generated_field = "9C1AB4FCB1E8B2C66FCDA272A8DBFF10")

        private String itemListenerMethodName;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.757 -0400", hash_original_field = "B873CB7918E5E1AAF6EB4E599F4A115D", hash_generated_field = "8A253EC0B6326CC8B14EFB449591E768")

        private ActionProvider itemActionProvider;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.757 -0400", hash_original_method = "D92FD84364574F36A2E6DED89015926B", hash_generated_method = "0CCDB88A494929C5A6239EA497C25103")
        public  MenuState(final Menu menu) {
            this.menu = menu;
            resetGroup();
            // ---------- Original Method ----------
            //this.menu = menu;
            //resetGroup();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.758 -0400", hash_original_method = "72B0BA7C11D7E690CFEDBC790E5F02DB", hash_generated_method = "52EC9BD2B64C18BC1661223C54B55626")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.776 -0400", hash_original_method = "D2A59B8CE3FF522E41AA18E3F41E01E5", hash_generated_method = "6760F9CD9B640BA11898A9DA8CFA7268")
        public void readGroup(AttributeSet attrs) {
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
            addTaint(attrs.getTaint());
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.791 -0400", hash_original_method = "040ADD8FC534832950800B9A55359142", hash_generated_method = "E786E7B12BB926CBC7720A3C650BD0C2")
        public void readItem(AttributeSet attrs) {
            TypedArray a;
            a = mContext.obtainStyledAttributes(attrs,
                    com.android.internal.R.styleable.MenuItem);
            itemId = a.getResourceId(com.android.internal.R.styleable.MenuItem_id, defaultItemId);
            int category;
            category = a.getInt(com.android.internal.R.styleable.MenuItem_menuCategory, groupCategory);
            int order;
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
                boolean var8B68EBF2C32DFF7A57B9A2EFC06FDA44_126898565 = (a.hasValue(com.android.internal.R.styleable.MenuItem_checkable));
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
            boolean hasActionProvider;
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
            addTaint(attrs.getTaint());
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.792 -0400", hash_original_method = "68CBADC6295F8D47EFE8794BDB31E4A9", hash_generated_method = "067223BEC2A23C6516D89686EEBCA24A")
        private char getShortcut(String shortcutString) {
            {
                char var94DDD9FE6ADE092287A1BAC249BEBC0A_759468252 = (shortcutString.charAt(0));
            } //End block
            addTaint(shortcutString.getTaint());
            char varA87DEB01C5F539E6BDA34829C8EF2368_82146672 = getTaintChar();
            return varA87DEB01C5F539E6BDA34829C8EF2368_82146672;
            // ---------- Original Method ----------
            //if (shortcutString == null) {
                //return 0;
            //} else {
                //return shortcutString.charAt(0);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.793 -0400", hash_original_method = "AD827357C34932CC0921A74B0CE8A3EF", hash_generated_method = "FCB096D0C5F1338086D02799411B4F19")
        private void setItem(MenuItem item) {
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
                    boolean varEB9F229BDF825669A5F4C4A08D921F80_2064522627 = (mContext.isRestricted());
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
            addTaint(item.getTaint());
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.801 -0400", hash_original_method = "A5F782FF20BD7C7C25F84F91CFB5DEC5", hash_generated_method = "E439761FFBB5453CAC5A01C16AC7F887")
        public void addItem() {
            itemAdded = true;
            setItem(menu.add(groupId, itemId, itemCategoryOrder, itemTitle));
            // ---------- Original Method ----------
            //itemAdded = true;
            //setItem(menu.add(groupId, itemId, itemCategoryOrder, itemTitle));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.801 -0400", hash_original_method = "68ADA6E6B9635F44A93B8212F1D6D8E0", hash_generated_method = "7253F976994355A10036A4412FAE4E6F")
        public SubMenu addSubMenuItem() {
            SubMenu varB4EAC82CA7396A68D541C85D26508E83_1487947553 = null; //Variable for return #1
            itemAdded = true;
            SubMenu subMenu;
            subMenu = menu.addSubMenu(groupId, itemId, itemCategoryOrder, itemTitle);
            setItem(subMenu.getItem());
            varB4EAC82CA7396A68D541C85D26508E83_1487947553 = subMenu;
            varB4EAC82CA7396A68D541C85D26508E83_1487947553.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1487947553;
            // ---------- Original Method ----------
            //itemAdded = true;
            //SubMenu subMenu = menu.addSubMenu(groupId, itemId, itemCategoryOrder, itemTitle);
            //setItem(subMenu.getItem());
            //return subMenu;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.802 -0400", hash_original_method = "EEE8EEEED979875FD25E1447BB361BB0", hash_generated_method = "42ABE8174C741E69AF9FB5BDAD087E1B")
        public boolean hasAddedItem() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1548548466 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1548548466;
            // ---------- Original Method ----------
            //return itemAdded;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.803 -0400", hash_original_method = "20DE6E19862FEEC3F61B05674F46168C", hash_generated_method = "129D57704A7ED5C9D773270D6BAC99D3")
        @SuppressWarnings("unchecked")
        private <T> T newInstance(String className, Class<?>[] constructorSignature,
                Object[] arguments) {
            T varB4EAC82CA7396A68D541C85D26508E83_575461288 = null; //Variable for return #1
            T varB4EAC82CA7396A68D541C85D26508E83_114487726 = null; //Variable for return #2
            try 
            {
                Class<?> clazz;
                clazz = mContext.getClassLoader().loadClass(className);
                Constructor<?> constructor;
                constructor = clazz.getConstructor(constructorSignature);
                varB4EAC82CA7396A68D541C85D26508E83_575461288 = (T) constructor.newInstance(arguments);
            } //End block
            catch (Exception e)
            { }
            varB4EAC82CA7396A68D541C85D26508E83_114487726 = null;
            addTaint(className.getTaint());
            addTaint(constructorSignature[0].getTaint());
            addTaint(arguments[0].getTaint());
            T varA7E53CE21691AB073D9660D615818899_1869916702; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_1869916702 = varB4EAC82CA7396A68D541C85D26508E83_575461288;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1869916702 = varB4EAC82CA7396A68D541C85D26508E83_114487726;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1869916702.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_1869916702;
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.803 -0400", hash_original_field = "0C96C18DE788F3C3662F091BE8C319A2", hash_generated_field = "B2C44B0D931E04752ABA40C2DBC9ECD3")

        private static int defaultGroupId = NO_ID;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.803 -0400", hash_original_field = "B1B22300C13F33FD5E8E54A45D11ACC9", hash_generated_field = "E7F683E1F22CD96FCFFFF4FB355265AF")

        private static int defaultItemId = NO_ID;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.803 -0400", hash_original_field = "D49E92A3DAD2D00E7B2165ECA7792CD1", hash_generated_field = "E477237F4265005AF942DA66E2E0EFFA")

        private static int defaultItemCategory = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.803 -0400", hash_original_field = "08E3AC21E8F8F37B1A598CCC98AC3AFE", hash_generated_field = "DDC20109E7B0B7FA42D343636AB97051")

        private static int defaultItemOrder = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.803 -0400", hash_original_field = "2A1818783D2382EEB1B588D3B6945E55", hash_generated_field = "87F60E8E0F455742BF619D36C926D44E")

        private static int defaultItemCheckable = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.803 -0400", hash_original_field = "8BBDB45AABD4FB0A6C09F886A34F14AA", hash_generated_field = "F83DAB227C6F0DC17D969CCD63C2A438")

        private static boolean defaultItemChecked = false;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.803 -0400", hash_original_field = "66B318485ADC0E99347187E3A65C17D3", hash_generated_field = "CAC9AD15D0A3F2638649769A5DD54726")

        private static boolean defaultItemVisible = true;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.803 -0400", hash_original_field = "A3B0DF83B80C2F5902456F36487EF43A", hash_generated_field = "D707CA391D9E242BBC7607A7D52F0898")

        private static boolean defaultItemEnabled = true;
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.804 -0400", hash_original_field = "9EE53BAAD915CA9B1466121FBFB04487", hash_generated_field = "3FAA429B417BD823140CB63C8CA53933")

    private static String LOG_TAG = "MenuInflater";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.804 -0400", hash_original_field = "39AA5D2A33D21D7B84A4319CFDCE0987", hash_generated_field = "C7B2174172136D965ABF102310C56262")

    private static String XML_MENU = "menu";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.804 -0400", hash_original_field = "74A6567484F487327715A2317C78C127", hash_generated_field = "3CD89D8E4CEB545C45E759A7BA6D45D1")

    private static String XML_GROUP = "group";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.804 -0400", hash_original_field = "425AFF497EEB44645A90479C263073FC", hash_generated_field = "D58F1AFFA1F40BD22E275AAE9B69C69B")

    private static String XML_ITEM = "item";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.804 -0400", hash_original_field = "6F4829B5C8C58584E9265424DAC2A080", hash_generated_field = "F6DD30479CD5B0CA2493F090FB1DF594")

    private static int NO_ID = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.804 -0400", hash_original_field = "A4368B9CEC7C5864F1446D617FBFF20A", hash_generated_field = "B07CF8296D43B3D95DB59BA994AB6D42")

    private static Class<?>[] ACTION_VIEW_CONSTRUCTOR_SIGNATURE = new Class[] {Context.class};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.804 -0400", hash_original_field = "A6D76F2B01600FE4280D46B967C3C064", hash_generated_field = "015B5784BCA0910B207C8EA44C9DA756")

    private static Class<?>[] ACTION_PROVIDER_CONSTRUCTOR_SIGNATURE = ACTION_VIEW_CONSTRUCTOR_SIGNATURE;
}

