package android.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.graphics.Canvas;
import android.os.Handler;
import android.os.Message;
import android.widget.FrameLayout;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Xml;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.HashMap;

public abstract class LayoutInflater {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.580 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "70EF0A62E0C07C973FB61A1B1A6F999D")

    private boolean DEBUG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.581 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "B3359F86E29A965BC1436888E98C55A8")

    protected Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.581 -0400", hash_original_field = "92E068AC1DA6911449EC771C547D2553", hash_generated_field = "AED919A3A7191A7906DCEFFE6A0831DA")

    private boolean mFactorySet;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.581 -0400", hash_original_field = "06389DE86ED19AB1571A41645A1AFADC", hash_generated_field = "BF67D382843E913B81807CA170E68BEC")

    private Factory mFactory;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.581 -0400", hash_original_field = "E5CABF68FB335FA237AE4D7C7F579B2E", hash_generated_field = "DDA453B5760FDE700FAD36F64FD01268")

    private Factory2 mFactory2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.581 -0400", hash_original_field = "69B57BE67F61B50D5B598BC00B0D995C", hash_generated_field = "91C09704D064CA0F12ECD6E6EFEC80CF")

    private Factory2 mPrivateFactory;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.581 -0400", hash_original_field = "C781ED17A87FBE09F8079C6EC63D1F26", hash_generated_field = "A13F7A33CB1B9B8C8BC52C7A25894515")

    private Filter mFilter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.581 -0400", hash_original_field = "A4A4795AC0E32E86ABF7474DEAC57538", hash_generated_field = "D62709ECD69C2FFB452C5E25B014B17D")

    Object[] mConstructorArgs = new Object[2];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.581 -0400", hash_original_field = "B716D3BF18675199220673D5170091C2", hash_generated_field = "208DFBA685342B06C1A3F18B71A9291E")

    private HashMap<String, Boolean> mFilterMap;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.584 -0400", hash_original_method = "E7207BFA97B4D4DD74A98816C77C472E", hash_generated_method = "E7012C3F049DB497107558CB08563437")
    protected  LayoutInflater(Context context) {
        mContext = context;
        // ---------- Original Method ----------
        //mContext = context;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.587 -0400", hash_original_method = "5CC0837D3FE56B24A71C58B4CCAA4F88", hash_generated_method = "73B9412CB86D13A699FB0B44C161827A")
    protected  LayoutInflater(LayoutInflater original, Context newContext) {
        mContext = newContext;
        mFactory = original.mFactory;
        mFactory2 = original.mFactory2;
        mPrivateFactory = original.mPrivateFactory;
        mFilter = original.mFilter;
        // ---------- Original Method ----------
        //mContext = newContext;
        //mFactory = original.mFactory;
        //mFactory2 = original.mFactory2;
        //mPrivateFactory = original.mPrivateFactory;
        //mFilter = original.mFilter;
    }

    
        public static LayoutInflater from(Context context) {
        LayoutInflater LayoutInflater =
                (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (LayoutInflater == null) {
            throw new AssertionError("LayoutInflater not found.");
        }
        return LayoutInflater;
    }

    
    public abstract LayoutInflater cloneInContext(Context newContext);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.589 -0400", hash_original_method = "4F4EBC54D108D66F416C93B46580E117", hash_generated_method = "A77D0E880750C9CFE805ABE1BFD75B2C")
    public Context getContext() {
        Context varB4EAC82CA7396A68D541C85D26508E83_544381418 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_544381418 = mContext;
        varB4EAC82CA7396A68D541C85D26508E83_544381418.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_544381418;
        // ---------- Original Method ----------
        //return mContext;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.590 -0400", hash_original_method = "7FDD2E2114CEC4DBC75B459E7197DB00", hash_generated_method = "7F25D67ACD4CC982D3DF122A10A1EF72")
    public final Factory getFactory() {
        Factory varB4EAC82CA7396A68D541C85D26508E83_1536807689 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1536807689 = mFactory;
        varB4EAC82CA7396A68D541C85D26508E83_1536807689.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1536807689;
        // ---------- Original Method ----------
        //return mFactory;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.600 -0400", hash_original_method = "1401AE51BF0559687CED2D99A883164D", hash_generated_method = "772C0081A34B12B514656A197A19A82D")
    public final Factory2 getFactory2() {
        Factory2 varB4EAC82CA7396A68D541C85D26508E83_989068418 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_989068418 = mFactory2;
        varB4EAC82CA7396A68D541C85D26508E83_989068418.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_989068418;
        // ---------- Original Method ----------
        //return mFactory2;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.602 -0400", hash_original_method = "711BCDCCD1A0460B88DDB4B05554E6F0", hash_generated_method = "DCC21CFF8BB627F6C7696EA7E5CF5BDB")
    public void setFactory(Factory factory) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("A factory has already been set on this LayoutInflater");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("Given factory can not be null");
        } //End block
        mFactorySet = true;
        {
            mFactory = factory;
        } //End block
        {
            mFactory = new FactoryMerger(factory, null, mFactory, mFactory2);
        } //End block
        // ---------- Original Method ----------
        //if (mFactorySet) {
            //throw new IllegalStateException("A factory has already been set on this LayoutInflater");
        //}
        //if (factory == null) {
            //throw new NullPointerException("Given factory can not be null");
        //}
        //mFactorySet = true;
        //if (mFactory == null) {
            //mFactory = factory;
        //} else {
            //mFactory = new FactoryMerger(factory, null, mFactory, mFactory2);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.604 -0400", hash_original_method = "206E93CE21BFEFA64CD336FC01E3DC86", hash_generated_method = "B1C2F5D12C287F0E352EE24FA323E436")
    public void setFactory2(Factory2 factory) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("A factory has already been set on this LayoutInflater");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("Given factory can not be null");
        } //End block
        mFactorySet = true;
        {
            mFactory = mFactory2 = factory;
        } //End block
        {
            mFactory = new FactoryMerger(factory, factory, mFactory, mFactory2);
        } //End block
        // ---------- Original Method ----------
        //if (mFactorySet) {
            //throw new IllegalStateException("A factory has already been set on this LayoutInflater");
        //}
        //if (factory == null) {
            //throw new NullPointerException("Given factory can not be null");
        //}
        //mFactorySet = true;
        //if (mFactory == null) {
            //mFactory = mFactory2 = factory;
        //} else {
            //mFactory = new FactoryMerger(factory, factory, mFactory, mFactory2);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.613 -0400", hash_original_method = "140FDA0509CDD22FFA77677DC0A919DF", hash_generated_method = "7B48C17DCCFC347FF964BDAD9D35BB77")
    public void setPrivateFactory(Factory2 factory) {
        mPrivateFactory = factory;
        // ---------- Original Method ----------
        //mPrivateFactory = factory;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.614 -0400", hash_original_method = "A182F1708C145D57F0135D6BE7F61F0B", hash_generated_method = "4CB20F3710D2C78FAE98241F8E73FFBB")
    public Filter getFilter() {
        Filter varB4EAC82CA7396A68D541C85D26508E83_1800506679 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1800506679 = mFilter;
        varB4EAC82CA7396A68D541C85D26508E83_1800506679.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1800506679;
        // ---------- Original Method ----------
        //return mFilter;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.616 -0400", hash_original_method = "E7980136733C7B2EC13AC2733EC56104", hash_generated_method = "CC6E8B33A6496ED5B6BA3EE1509DBFD6")
    public void setFilter(Filter filter) {
        mFilter = filter;
        {
            mFilterMap = new HashMap<String, Boolean>();
        } //End block
        // ---------- Original Method ----------
        //mFilter = filter;
        //if (filter != null) {
            //mFilterMap = new HashMap<String, Boolean>();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.616 -0400", hash_original_method = "33D0E6277D03283945C33D82FE1E07F8", hash_generated_method = "23C7C95D6F14BB06CC4A7EA9CBC7B13F")
    public View inflate(int resource, ViewGroup root) {
        View varB4EAC82CA7396A68D541C85D26508E83_1241966458 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1241966458 = inflate(resource, root, root != null);
        addTaint(resource);
        addTaint(root.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1241966458.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1241966458;
        // ---------- Original Method ----------
        //return inflate(resource, root, root != null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.641 -0400", hash_original_method = "2C6130928BF5FC4257D730B98F9E332E", hash_generated_method = "CB7D89B349CC7A07ED22A05D19EB8C01")
    public View inflate(XmlPullParser parser, ViewGroup root) {
        View varB4EAC82CA7396A68D541C85D26508E83_307555893 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_307555893 = inflate(parser, root, root != null);
        addTaint(parser.getTaint());
        addTaint(root.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_307555893.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_307555893;
        // ---------- Original Method ----------
        //return inflate(parser, root, root != null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.642 -0400", hash_original_method = "73105F6C94DACD9E83BB5CE96738BE14", hash_generated_method = "6E897EE3D2DD5ED20C06DB0EDCC5FC57")
    public View inflate(int resource, ViewGroup root, boolean attachToRoot) {
        View varB4EAC82CA7396A68D541C85D26508E83_1076227815 = null; //Variable for return #1
        System.out.println("INFLATING from resource: " + resource);
        XmlResourceParser parser;
        parser = getContext().getResources().getLayout(resource);
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1076227815 = inflate(parser, root, attachToRoot);
        } //End block
        finally 
        {
            parser.close();
        } //End block
        addTaint(resource);
        addTaint(root.getTaint());
        addTaint(attachToRoot);
        varB4EAC82CA7396A68D541C85D26508E83_1076227815.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1076227815;
        // ---------- Original Method ----------
        //if (DEBUG) System.out.println("INFLATING from resource: " + resource);
        //XmlResourceParser parser = getContext().getResources().getLayout(resource);
        //try {
            //return inflate(parser, root, attachToRoot);
        //} finally {
            //parser.close();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.659 -0400", hash_original_method = "9DFC9AE5F080C22C20FBC66EE3D8715B", hash_generated_method = "950F1E19242310A3D97B6D0C004A9BC0")
    public View inflate(XmlPullParser parser, ViewGroup root, boolean attachToRoot) {
        View varB4EAC82CA7396A68D541C85D26508E83_33755456 = null; //Variable for return #1
        {
            AttributeSet attrs;
            attrs = Xml.asAttributeSet(parser);
            Context lastContext;
            lastContext = (Context)mConstructorArgs[0];
            mConstructorArgs[0] = mContext;
            View result;
            result = root;
            try 
            {
                int type;
                {
                    boolean varE58D9BEEA9A8E881BB4855D510C76E16_2134571117 = ((type = parser.next()) != XmlPullParser.START_TAG &&
                        type != XmlPullParser.END_DOCUMENT);
                } //End collapsed parenthetic
                {
                    if (DroidSafeAndroidRuntime.control) throw new InflateException(parser.getPositionDescription()
                            + ": No start tag found!");
                } //End block
                String name;
                name = parser.getName();
                {
                    System.out.println("**************************");
                    System.out.println("Creating root view: "
                            + name);
                    System.out.println("**************************");
                } //End block
                {
                    boolean varFDE52F8163E69EE326159C2642CAEC68_452236702 = (TAG_MERGE.equals(name));
                    {
                        {
                            if (DroidSafeAndroidRuntime.control) throw new InflateException("<merge /> can be used only with a valid "
                                + "ViewGroup root and attachToRoot=true");
                        } //End block
                        rInflate(parser, root, attrs, false);
                    } //End block
                    {
                        View temp;
                        {
                            boolean varCE5DAB92F3FE827A985DB892C11A30CF_1775740215 = (TAG_1995.equals(name));
                            {
                                temp = new BlinkLayout(mContext, attrs);
                            } //End block
                            {
                                temp = createViewFromTag(root, name, attrs);
                            } //End block
                        } //End collapsed parenthetic
                        ViewGroup.LayoutParams params;
                        params = null;
                        {
                            {
                                System.out.println("Creating params from root: " +
                                    root);
                            } //End block
                            params = root.generateLayoutParams(attrs);
                            {
                                temp.setLayoutParams(params);
                            } //End block
                        } //End block
                        {
                            System.out.println("-----> start inflating children");
                        } //End block
                        rInflate(parser, temp, attrs, true);
                        {
                            System.out.println("-----> done inflating children");
                        } //End block
                        {
                            root.addView(temp, params);
                        } //End block
                        {
                            result = temp;
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
            catch (XmlPullParserException e)
            {
                InflateException ex;
                ex = new InflateException(e.getMessage());
                ex.initCause(e);
                if (DroidSafeAndroidRuntime.control) throw ex;
            } //End block
            catch (IOException e)
            {
                InflateException ex;
                ex = new InflateException(
                        parser.getPositionDescription()
                        + ": " + e.getMessage());
                ex.initCause(e);
                if (DroidSafeAndroidRuntime.control) throw ex;
            } //End block
            finally 
            {
                mConstructorArgs[0] = lastContext;
                mConstructorArgs[1] = null;
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_33755456 = result;
        } //End block
        addTaint(parser.getTaint());
        addTaint(root.getTaint());
        addTaint(attachToRoot);
        varB4EAC82CA7396A68D541C85D26508E83_33755456.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_33755456;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.660 -0400", hash_original_method = "9249249C6DEB7757C8882D406CD78B4B", hash_generated_method = "5CB672DE6E7695F9027C4DEA81E6C110")
    public final View createView(String name, String prefix, AttributeSet attrs) throws ClassNotFoundException, InflateException {
        View varB4EAC82CA7396A68D541C85D26508E83_1107193078 = null; //Variable for return #1
        Constructor<? extends View> constructor;
        constructor = sConstructorMap.get(name);
        Class<? extends View> clazz;
        clazz = null;
        try 
        {
            {
                clazz = mContext.getClassLoader().loadClass(
                        prefix != null ? (prefix + name) : name).asSubclass(View.class);
                {
                    boolean allowed;
                    allowed = mFilter.onLoadClass(clazz);
                    {
                        failNotAllowed(name, prefix, attrs);
                    } //End block
                } //End block
                constructor = clazz.getConstructor(mConstructorSignature);
                sConstructorMap.put(name, constructor);
            } //End block
            {
                {
                    Boolean allowedState;
                    allowedState = mFilterMap.get(name);
                    {
                        clazz = mContext.getClassLoader().loadClass(
                                prefix != null ? (prefix + name) : name).asSubclass(View.class);
                        boolean allowed;
                        allowed = clazz != null && mFilter.onLoadClass(clazz);
                        mFilterMap.put(name, allowed);
                        {
                            failNotAllowed(name, prefix, attrs);
                        } //End block
                    } //End block
                    {
                        boolean var5283AA69DC1B5B630A4798CB7C4AEC9B_1208336320 = (allowedState.equals(Boolean.FALSE));
                        {
                            failNotAllowed(name, prefix, attrs);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End block
            Object[] args;
            args = mConstructorArgs;
            args[1] = attrs;
            varB4EAC82CA7396A68D541C85D26508E83_1107193078 = constructor.newInstance(args);
        } //End block
        catch (NoSuchMethodException e)
        {
            InflateException ie;
            ie = new InflateException(attrs.getPositionDescription()
                    + ": Error inflating class "
                    + (prefix != null ? (prefix + name) : name));//DSFIXME:  CODE0008: Nested ternary operator in expression
            ie.initCause(e);
            if (DroidSafeAndroidRuntime.control) throw ie;
        } //End block
        catch (ClassCastException e)
        {
            InflateException ie;
            ie = new InflateException(attrs.getPositionDescription()
                    + ": Class is not a View "
                    + (prefix != null ? (prefix + name) : name));//DSFIXME:  CODE0008: Nested ternary operator in expression
            ie.initCause(e);
            if (DroidSafeAndroidRuntime.control) throw ie;
        } //End block
        catch (ClassNotFoundException e)
        {
            if (DroidSafeAndroidRuntime.control) throw e;
        } //End block
        catch (Exception e)
        {
            InflateException ie;
            ie = new InflateException(attrs.getPositionDescription()
                    + ": Error inflating class "
                    + (clazz == null ? "<unknown>" : clazz.getName()));//DSFIXME:  CODE0008: Nested ternary operator in expression
            ie.initCause(e);
            if (DroidSafeAndroidRuntime.control) throw ie;
        } //End block
        addTaint(name.getTaint());
        addTaint(prefix.getTaint());
        addTaint(attrs.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1107193078.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1107193078;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.661 -0400", hash_original_method = "0971FA0124FB7B31B88F61FC842AABEB", hash_generated_method = "828B17EED119371332A086461FFFFA26")
    private void failNotAllowed(String name, String prefix, AttributeSet attrs) {
        if (DroidSafeAndroidRuntime.control) throw new InflateException(attrs.getPositionDescription()
                + ": Class not allowed to be inflated "
                + (prefix != null ? (prefix + name) : name));
        addTaint(name.getTaint());
        addTaint(prefix.getTaint());
        addTaint(attrs.getTaint());
        // ---------- Original Method ----------
        //throw new InflateException(attrs.getPositionDescription()
                //+ ": Class not allowed to be inflated "
                //+ (prefix != null ? (prefix + name) : name));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.665 -0400", hash_original_method = "9A9783E7AF685525083052EAFC6937D8", hash_generated_method = "F23134BA41EC70B1F1C34DF5B81EB07B")
    protected View onCreateView(String name, AttributeSet attrs) throws ClassNotFoundException {
        //DSFIXME:  CODE0009: Possible callback target function detected
        View varB4EAC82CA7396A68D541C85D26508E83_1606142828 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1606142828 = createView(name, "android.view.", attrs);
        addTaint(name.getTaint());
        addTaint(attrs.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1606142828.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1606142828;
        // ---------- Original Method ----------
        //return createView(name, "android.view.", attrs);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.685 -0400", hash_original_method = "EEF2BD4B979EFD4F0FBDCDB52C08D7B2", hash_generated_method = "ECB5E2D4102538644EDBA8BF05674C23")
    protected View onCreateView(View parent, String name, AttributeSet attrs) throws ClassNotFoundException {
        //DSFIXME:  CODE0009: Possible callback target function detected
        View varB4EAC82CA7396A68D541C85D26508E83_2118549118 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2118549118 = onCreateView(name, attrs);
        addTaint(parent.getTaint());
        addTaint(name.getTaint());
        addTaint(attrs.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2118549118.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2118549118;
        // ---------- Original Method ----------
        //return onCreateView(name, attrs);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.687 -0400", hash_original_method = "42E00CE52BE01D0BF7040FF60139A865", hash_generated_method = "EA06517421817408AF68B71C8E5F417C")
     View createViewFromTag(View parent, String name, AttributeSet attrs) {
        View varB4EAC82CA7396A68D541C85D26508E83_1364961701 = null; //Variable for return #1
        {
            boolean var8FFDB426A97735EAEA80E33D0B5E59B2_1101992956 = (name.equals("view"));
            {
                name = attrs.getAttributeValue(null, "class");
            } //End block
        } //End collapsed parenthetic
        System.out.println("******** Creating view: " + name);
        try 
        {
            View view;
            view = mFactory2.onCreateView(parent, name, mContext, attrs);
            view = mFactory.onCreateView(name, mContext, attrs);
            view = null;
            {
                view = mPrivateFactory.onCreateView(parent, name, mContext, attrs);
            } //End block
            {
                {
                    boolean var8670E3C6635B63F51E108DA3DA62F822_1723523089 = (-1 == name.indexOf('.'));
                    {
                        view = onCreateView(parent, name, attrs);
                    } //End block
                    {
                        view = createView(name, null, attrs);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            System.out.println("Created view is: " + view);
            varB4EAC82CA7396A68D541C85D26508E83_1364961701 = view;
        } //End block
        catch (InflateException e)
        {
            if (DroidSafeAndroidRuntime.control) throw e;
        } //End block
        catch (ClassNotFoundException e)
        {
            InflateException ie;
            ie = new InflateException(attrs.getPositionDescription()
                    + ": Error inflating class " + name);
            ie.initCause(e);
            if (DroidSafeAndroidRuntime.control) throw ie;
        } //End block
        catch (Exception e)
        {
            InflateException ie;
            ie = new InflateException(attrs.getPositionDescription()
                    + ": Error inflating class " + name);
            ie.initCause(e);
            if (DroidSafeAndroidRuntime.control) throw ie;
        } //End block
        addTaint(parent.getTaint());
        addTaint(name.getTaint());
        addTaint(attrs.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1364961701.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1364961701;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.692 -0400", hash_original_method = "3A61628D6ED69C72EF61CAE501BAE992", hash_generated_method = "4BF6A7910D200E2C5B02FD09EBCC2B8C")
     void rInflate(XmlPullParser parser, View parent, final AttributeSet attrs,
            boolean finishInflate) throws XmlPullParserException, IOException {
        int depth;
        depth = parser.getDepth();
        int type;
        {
            boolean var823E94E9B6300A88398882F66A824AFC_1728396750 = (((type = parser.next()) != XmlPullParser.END_TAG ||
                parser.getDepth() > depth) && type != XmlPullParser.END_DOCUMENT);
            {
                String name;
                name = parser.getName();
                {
                    boolean var9E864073812E74645886E00F3C1FA42E_1744892104 = (TAG_REQUEST_FOCUS.equals(name));
                    {
                        parseRequestFocus(parser, parent);
                    } //End block
                    {
                        boolean var3A72FDB7DEFA1B4376ED852227EE7220_808883104 = (TAG_INCLUDE.equals(name));
                        {
                            {
                                boolean varF9E7792F5EE78FD8E2EF7727515E4EC9_1314030924 = (parser.getDepth() == 0);
                                {
                                    if (DroidSafeAndroidRuntime.control) throw new InflateException("<include /> cannot be the root element");
                                } //End block
                            } //End collapsed parenthetic
                            parseInclude(parser, parent, attrs);
                        } //End block
                        {
                            boolean var6E0AFF7B2B3D2BD63E19797766EAC38B_2073776481 = (TAG_MERGE.equals(name));
                            {
                                if (DroidSafeAndroidRuntime.control) throw new InflateException("<merge /> must be the root element");
                            } //End block
                            {
                                boolean varA10A7F5947ED2B40D379831A43F34249_735631028 = (TAG_1995.equals(name));
                                {
                                    View view;
                                    view = new BlinkLayout(mContext, attrs);
                                    ViewGroup viewGroup;
                                    viewGroup = (ViewGroup) parent;
                                    ViewGroup.LayoutParams params;
                                    params = viewGroup.generateLayoutParams(attrs);
                                    rInflate(parser, view, attrs, true);
                                    viewGroup.addView(view, params);
                                } //End block
                                {
                                    View view;
                                    view = createViewFromTag(parent, name, attrs);
                                    ViewGroup viewGroup;
                                    viewGroup = (ViewGroup) parent;
                                    ViewGroup.LayoutParams params;
                                    params = viewGroup.generateLayoutParams(attrs);
                                    rInflate(parser, view, attrs, true);
                                    viewGroup.addView(view, params);
                                } //End block
                            } //End collapsed parenthetic
                        } //End collapsed parenthetic
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        parent.onFinishInflate();
        addTaint(parser.getTaint());
        addTaint(parent.getTaint());
        addTaint(attrs.getTaint());
        addTaint(finishInflate);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.693 -0400", hash_original_method = "D305B9D132FFD898328C34D4AEEA8981", hash_generated_method = "F12044490F1653F89C005AF87EF61205")
    private void parseRequestFocus(XmlPullParser parser, View parent) throws XmlPullParserException, IOException {
        int type;
        parent.requestFocus();
        int currentDepth;
        currentDepth = parser.getDepth();
        {
            boolean var0A9D2815252DF1D1527DC7B6C5EBCE25_346313546 = (((type = parser.next()) != XmlPullParser.END_TAG ||
                parser.getDepth() > currentDepth) && type != XmlPullParser.END_DOCUMENT);
        } //End collapsed parenthetic
        addTaint(parser.getTaint());
        addTaint(parent.getTaint());
        // ---------- Original Method ----------
        //int type;
        //parent.requestFocus();
        //final int currentDepth = parser.getDepth();
        //while (((type = parser.next()) != XmlPullParser.END_TAG ||
                //parser.getDepth() > currentDepth) && type != XmlPullParser.END_DOCUMENT) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.715 -0400", hash_original_method = "3903965D4D2522F244AF5345C6CDB188", hash_generated_method = "F3A89AB45464C3D5F0377F366A9C379F")
    private void parseInclude(XmlPullParser parser, View parent, AttributeSet attrs) throws XmlPullParserException, IOException {
        int type;
        {
            int layout;
            layout = attrs.getAttributeResourceValue(null, "layout", 0);
            {
                String value;
                value = attrs.getAttributeValue(null, "layout");
                {
                    if (DroidSafeAndroidRuntime.control) throw new InflateException("You must specifiy a layout in the"
                            + " include tag: <include layout=\"@layout/layoutID\" />");
                } //End block
                {
                    if (DroidSafeAndroidRuntime.control) throw new InflateException("You must specifiy a valid layout "
                            + "reference. The layout ID " + value + " is not valid.");
                } //End block
            } //End block
            {
                XmlResourceParser childParser;
                childParser = getContext().getResources().getLayout(layout);
                try 
                {
                    AttributeSet childAttrs;
                    childAttrs = Xml.asAttributeSet(childParser);
                    {
                        boolean var85BD6F6EF64876B51C9884A0DAC7FEDE_2095857405 = ((type = childParser.next()) != XmlPullParser.START_TAG &&
                            type != XmlPullParser.END_DOCUMENT);
                    } //End collapsed parenthetic
                    {
                        if (DroidSafeAndroidRuntime.control) throw new InflateException(childParser.getPositionDescription() +
                                ": No start tag found!");
                    } //End block
                    String childName;
                    childName = childParser.getName();
                    {
                        boolean var5E823F928FF3B68CA0565BBB723D4C0E_1398001125 = (TAG_MERGE.equals(childName));
                        {
                            rInflate(childParser, parent, childAttrs, false);
                        } //End block
                        {
                            View view;
                            view = createViewFromTag(parent, childName, childAttrs);
                            ViewGroup group;
                            group = (ViewGroup) parent;
                            ViewGroup.LayoutParams params;
                            params = null;
                            try 
                            {
                                params = group.generateLayoutParams(attrs);
                            } //End block
                            catch (RuntimeException e)
                            {
                                params = group.generateLayoutParams(childAttrs);
                            } //End block
                            finally 
                            {
                                {
                                    view.setLayoutParams(params);
                                } //End block
                            } //End block
                            rInflate(childParser, view, childAttrs, true);
                            TypedArray a;
                            a = mContext.obtainStyledAttributes(attrs,
                            com.android.internal.R.styleable.View, 0, 0);
                            int id;
                            id = a.getResourceId(com.android.internal.R.styleable.View_id, View.NO_ID);
                            int visibility;
                            visibility = a.getInt(com.android.internal.R.styleable.View_visibility, -1);
                            a.recycle();
                            {
                                view.setId(id);
                            } //End block
                            //Begin case 0 
                            view.setVisibility(View.VISIBLE);
                            //End case 0 
                            //Begin case 1 
                            view.setVisibility(View.INVISIBLE);
                            //End case 1 
                            //Begin case 2 
                            view.setVisibility(View.GONE);
                            //End case 2 
                            group.addView(view);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                finally 
                {
                    childParser.close();
                } //End block
            } //End block
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new InflateException("<include /> can only be used inside of a ViewGroup");
        } //End block
        int currentDepth;
        currentDepth = parser.getDepth();
        {
            boolean var0A9D2815252DF1D1527DC7B6C5EBCE25_556742755 = (((type = parser.next()) != XmlPullParser.END_TAG ||
                parser.getDepth() > currentDepth) && type != XmlPullParser.END_DOCUMENT);
        } //End collapsed parenthetic
        addTaint(parser.getTaint());
        addTaint(parent.getTaint());
        addTaint(attrs.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    private static class FactoryMerger implements Factory2 {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.716 -0400", hash_original_field = "B388ED792FF72DF72B1BCDB08C954A34", hash_generated_field = "5597E72774649F58EAFC93193B0F56F5")

        private Factory mF1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.716 -0400", hash_original_field = "D2F7236B8084EBD38FEB109B60093F59", hash_generated_field = "980C2131F1904820A671FBE786E0A976")

        private Factory mF2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.716 -0400", hash_original_field = "EFB292FB0A8C321793AF25ADBD699004", hash_generated_field = "F581D9BC63EDDF42FCA0DB75903DA713")

        private Factory2 mF12;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.716 -0400", hash_original_field = "F95B8BEDDD7E63CA0369D2E0B75E60F0", hash_generated_field = "279141595E6D3718BC3E6B02DB3437E1")

        private Factory2 mF22;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.717 -0400", hash_original_method = "E5AD3FF1F375743BB365B35578675E98", hash_generated_method = "2C2C626FEF544A6A4B4A2A329D6C4155")
          FactoryMerger(Factory f1, Factory2 f12, Factory f2, Factory2 f22) {
            mF1 = f1;
            mF2 = f2;
            mF12 = f12;
            mF22 = f22;
            // ---------- Original Method ----------
            //mF1 = f1;
            //mF2 = f2;
            //mF12 = f12;
            //mF22 = f22;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.717 -0400", hash_original_method = "912C6EE593A6921C8E87D5E0641D7CDD", hash_generated_method = "887FF80482C51305094580ECE2DEE7DE")
        public View onCreateView(String name, Context context, AttributeSet attrs) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            View varB4EAC82CA7396A68D541C85D26508E83_420265688 = null; //Variable for return #1
            View varB4EAC82CA7396A68D541C85D26508E83_458254378 = null; //Variable for return #2
            View v;
            v = mF1.onCreateView(name, context, attrs);
            varB4EAC82CA7396A68D541C85D26508E83_420265688 = v;
            varB4EAC82CA7396A68D541C85D26508E83_458254378 = mF2.onCreateView(name, context, attrs);
            addTaint(name.getTaint());
            addTaint(context.getTaint());
            addTaint(attrs.getTaint());
            View varA7E53CE21691AB073D9660D615818899_788128770; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_788128770 = varB4EAC82CA7396A68D541C85D26508E83_420265688;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_788128770 = varB4EAC82CA7396A68D541C85D26508E83_458254378;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_788128770.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_788128770;
            // ---------- Original Method ----------
            //View v = mF1.onCreateView(name, context, attrs);
            //if (v != null) return v;
            //return mF2.onCreateView(name, context, attrs);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.719 -0400", hash_original_method = "F1957EAE5145EA0F0129265F270794D6", hash_generated_method = "E983953EB917E646E183E0BE6E1DAA14")
        public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            View varB4EAC82CA7396A68D541C85D26508E83_1751170391 = null; //Variable for return #1
            View varB4EAC82CA7396A68D541C85D26508E83_151730602 = null; //Variable for return #2
            View v;
            v = mF12.onCreateView(parent, name, context, attrs);
            v = mF1.onCreateView(name, context, attrs);
            varB4EAC82CA7396A68D541C85D26508E83_1751170391 = v;
            varB4EAC82CA7396A68D541C85D26508E83_151730602 = mF22 != null ? mF22.onCreateView(parent, name, context, attrs)
                    : mF2.onCreateView(name, context, attrs);
            addTaint(parent.getTaint());
            addTaint(name.getTaint());
            addTaint(context.getTaint());
            addTaint(attrs.getTaint());
            View varA7E53CE21691AB073D9660D615818899_1015104949; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_1015104949 = varB4EAC82CA7396A68D541C85D26508E83_1751170391;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1015104949 = varB4EAC82CA7396A68D541C85D26508E83_151730602;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1015104949.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_1015104949;
            // ---------- Original Method ----------
            //View v = mF12 != null ? mF12.onCreateView(parent, name, context, attrs)
                    //: mF1.onCreateView(name, context, attrs);
            //if (v != null) return v;
            //return mF22 != null ? mF22.onCreateView(parent, name, context, attrs)
                    //: mF2.onCreateView(name, context, attrs);
        }

        
    }


    
    private static class BlinkLayout extends FrameLayout {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.719 -0400", hash_original_field = "57ABA66DF5CCF392086380D760C5BF59", hash_generated_field = "9F94E2291878F4B79ED3B6B67A1ED0C7")

        private boolean mBlink;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.719 -0400", hash_original_field = "84A61AEDD18A7D6ECA3FB13967806C7E", hash_generated_field = "57E34B9F322B663DA6033C74FD1E64C4")

        private boolean mBlinkState;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.719 -0400", hash_original_field = "C78BEDFC523DB73DF63EFB071AF1C35B", hash_generated_field = "03E47BA0CE42772601F0A13D178B12B5")

        private Handler mHandler;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.739 -0400", hash_original_method = "3DD68C66D41BE889B84232F33376A99A", hash_generated_method = "6F0D9C9FDA7CD66B80278AB9FD150C26")
        public  BlinkLayout(Context context, AttributeSet attrs) {
            super(context, attrs);
            mHandler = new Handler(new Handler.Callback() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.734 -0400", hash_original_method = "3CDE63BB1E6E2FE4ACBB53B93DE4CB6C", hash_generated_method = "BB55F80E01B58055327585C2D224A5CF")
                @Override
                public boolean handleMessage(Message msg) {
                    {
                        {
                            mBlinkState = !mBlinkState;
                            makeBlink();
                        } //End block
                        invalidate();
                    } //End block
                    addTaint(msg.getTaint());
                    boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1280611520 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1280611520;
                    // ---------- Original Method ----------
                    //if (msg.what == MESSAGE_BLINK) {
                        //if (mBlink) {
                            //mBlinkState = !mBlinkState;
                            //makeBlink();
                        //}
                        //invalidate();
                        //return true;
                    //}
                    //return false;
                }
});
            addTaint(context.getTaint());
            addTaint(attrs.getTaint());
            // ---------- Original Method ----------
            //mHandler = new Handler(new Handler.Callback() {
                //@Override
                //public boolean handleMessage(Message msg) {
                    //if (msg.what == MESSAGE_BLINK) {
                        //if (mBlink) {
                            //mBlinkState = !mBlinkState;
                            //makeBlink();
                        //}
                        //invalidate();
                        //return true;
                    //}
                    //return false;
                //}
            //});
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.739 -0400", hash_original_method = "553FA2CA85816FF11073226F48838667", hash_generated_method = "270C074C6E7784515BFD5F9497C40081")
        private void makeBlink() {
            Message message;
            message = mHandler.obtainMessage(MESSAGE_BLINK);
            mHandler.sendMessageDelayed(message, BLINK_DELAY);
            // ---------- Original Method ----------
            //Message message = mHandler.obtainMessage(MESSAGE_BLINK);
            //mHandler.sendMessageDelayed(message, BLINK_DELAY);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.740 -0400", hash_original_method = "F84801EA6DE017B4DF3D928CA8059755", hash_generated_method = "5442A9264ED4F4E31C0BA66C5931886A")
        @Override
        protected void onAttachedToWindow() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            super.onAttachedToWindow();
            mBlink = true;
            mBlinkState = true;
            makeBlink();
            // ---------- Original Method ----------
            //super.onAttachedToWindow();
            //mBlink = true;
            //mBlinkState = true;
            //makeBlink();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.740 -0400", hash_original_method = "68779D94DBD6ED32D8C444331B18EB29", hash_generated_method = "A65982EADCE2056B98837C8AE9E7BCE2")
        @Override
        protected void onDetachedFromWindow() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            super.onDetachedFromWindow();
            mBlink = false;
            mBlinkState = true;
            mHandler.removeMessages(MESSAGE_BLINK);
            // ---------- Original Method ----------
            //super.onDetachedFromWindow();
            //mBlink = false;
            //mBlinkState = true;
            //mHandler.removeMessages(MESSAGE_BLINK);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.741 -0400", hash_original_method = "B2A7E99D93A7E570FADBB759CB038122", hash_generated_method = "DC76C125C06C4E0D5A7C567BB0DDA97F")
        @Override
        protected void dispatchDraw(Canvas canvas) {
            {
                super.dispatchDraw(canvas);
            } //End block
            addTaint(canvas.getTaint());
            // ---------- Original Method ----------
            //if (mBlinkState) {
                //super.dispatchDraw(canvas);
            //}
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.741 -0400", hash_original_field = "FCC4B1B643B64678EC5C05DB4601EBF9", hash_generated_field = "3C3B6FB39FDD98D867573B1653264E16")

        private static int MESSAGE_BLINK = 0x42;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.741 -0400", hash_original_field = "C0C33B4F311995BA1D316E6C41B33B82", hash_generated_field = "5B55704345734A18C4EED4DC073E4133")

        private static int BLINK_DELAY = 500;
    }


    
    public interface Filter {
        
        @SuppressWarnings("unchecked")
        boolean onLoadClass(Class clazz);
    }
    
    public interface Factory {
        
        public View onCreateView(String name, Context context, AttributeSet attrs);
    }
    
    public interface Factory2 extends Factory {
        
        public View onCreateView(View parent, String name, Context context, AttributeSet attrs);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.741 -0400", hash_original_field = "1125430DAA7CF8795E7D402DB0D83E08", hash_generated_field = "AE31D7A9526578879DCDBB25F412DAAF")

    static Class<?>[] mConstructorSignature = new Class[] {
            Context.class, AttributeSet.class};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.741 -0400", hash_original_field = "176CD41BE1EF5E4979EA824C2AEDF2B1", hash_generated_field = "0E1E49C67AF8C637878A594ABF3DBE98")

    private static HashMap<String, Constructor<? extends View>> sConstructorMap = new HashMap<String, Constructor<? extends View>>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.741 -0400", hash_original_field = "EED9DF1080CAF39D9C37A9B5067943FA", hash_generated_field = "04F78A42F232CAE80BE5D5495BE1B610")

    private static String TAG_MERGE = "merge";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.741 -0400", hash_original_field = "932E55CE33B67AAED6E42C38C17410C7", hash_generated_field = "676FFC88C6EAF79A110569DD3EF93058")

    private static String TAG_INCLUDE = "include";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.741 -0400", hash_original_field = "EB60FFD74626EBCFC26C23DBDF32C98B", hash_generated_field = "569F9FA0FB9FC3EAFB1112426573588C")

    private static String TAG_1995 = "blink";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:50.741 -0400", hash_original_field = "10D3EBD501FBA20B3D43BF08D4F12183", hash_generated_field = "7BEE23A54325621ECDE366DA44C5BDB1")

    private static String TAG_REQUEST_FOCUS = "requestFocus";
}

