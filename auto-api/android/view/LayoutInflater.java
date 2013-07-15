package android.view;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.404 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "40AF400BA8F86FA9C9E428F903D03FF5")

    private final boolean DEBUG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.404 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "B3359F86E29A965BC1436888E98C55A8")

    protected Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.404 -0400", hash_original_field = "92E068AC1DA6911449EC771C547D2553", hash_generated_field = "AED919A3A7191A7906DCEFFE6A0831DA")

    private boolean mFactorySet;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.404 -0400", hash_original_field = "06389DE86ED19AB1571A41645A1AFADC", hash_generated_field = "BF67D382843E913B81807CA170E68BEC")

    private Factory mFactory;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.404 -0400", hash_original_field = "E5CABF68FB335FA237AE4D7C7F579B2E", hash_generated_field = "DDA453B5760FDE700FAD36F64FD01268")

    private Factory2 mFactory2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.404 -0400", hash_original_field = "69B57BE67F61B50D5B598BC00B0D995C", hash_generated_field = "91C09704D064CA0F12ECD6E6EFEC80CF")

    private Factory2 mPrivateFactory;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.404 -0400", hash_original_field = "C781ED17A87FBE09F8079C6EC63D1F26", hash_generated_field = "A13F7A33CB1B9B8C8BC52C7A25894515")

    private Filter mFilter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.404 -0400", hash_original_field = "A4A4795AC0E32E86ABF7474DEAC57538", hash_generated_field = "B7AB5DA0883F2685164B5F2691D42F0F")

    final Object[] mConstructorArgs = new Object[2];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.404 -0400", hash_original_field = "B716D3BF18675199220673D5170091C2", hash_generated_field = "208DFBA685342B06C1A3F18B71A9291E")

    private HashMap<String, Boolean> mFilterMap;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.405 -0400", hash_original_method = "E7207BFA97B4D4DD74A98816C77C472E", hash_generated_method = "E7012C3F049DB497107558CB08563437")
    protected  LayoutInflater(Context context) {
        mContext = context;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.405 -0400", hash_original_method = "5CC0837D3FE56B24A71C58B4CCAA4F88", hash_generated_method = "73B9412CB86D13A699FB0B44C161827A")
    protected  LayoutInflater(LayoutInflater original, Context newContext) {
        mContext = newContext;
        mFactory = original.mFactory;
        mFactory2 = original.mFactory2;
        mPrivateFactory = original.mPrivateFactory;
        mFilter = original.mFilter;
        
        
        
        
        
        
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.406 -0400", hash_original_method = "4F4EBC54D108D66F416C93B46580E117", hash_generated_method = "1B57671A732C6B2A1D90902B16C08485")
    public Context getContext() {
        Context varB4EAC82CA7396A68D541C85D26508E83_170921122 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_170921122 = mContext;
        varB4EAC82CA7396A68D541C85D26508E83_170921122.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_170921122;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.406 -0400", hash_original_method = "7FDD2E2114CEC4DBC75B459E7197DB00", hash_generated_method = "D19E1EB8B1E302F9E232EE9C5667A469")
    public final Factory getFactory() {
        Factory varB4EAC82CA7396A68D541C85D26508E83_1613385705 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1613385705 = mFactory;
        varB4EAC82CA7396A68D541C85D26508E83_1613385705.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1613385705;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.407 -0400", hash_original_method = "1401AE51BF0559687CED2D99A883164D", hash_generated_method = "A60F2722D06183C93060A10C8EDB17EB")
    public final Factory2 getFactory2() {
        Factory2 varB4EAC82CA7396A68D541C85D26508E83_1970744722 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1970744722 = mFactory2;
        varB4EAC82CA7396A68D541C85D26508E83_1970744722.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1970744722;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.407 -0400", hash_original_method = "711BCDCCD1A0460B88DDB4B05554E6F0", hash_generated_method = "DCC21CFF8BB627F6C7696EA7E5CF5BDB")
    public void setFactory(Factory factory) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("A factory has already been set on this LayoutInflater");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("Given factory can not be null");
        } 
        mFactorySet = true;
        {
            mFactory = factory;
        } 
        {
            mFactory = new FactoryMerger(factory, null, mFactory, mFactory2);
        } 
        
        
            
        
        
            
        
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.408 -0400", hash_original_method = "206E93CE21BFEFA64CD336FC01E3DC86", hash_generated_method = "B1C2F5D12C287F0E352EE24FA323E436")
    public void setFactory2(Factory2 factory) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("A factory has already been set on this LayoutInflater");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("Given factory can not be null");
        } 
        mFactorySet = true;
        {
            mFactory = mFactory2 = factory;
        } 
        {
            mFactory = new FactoryMerger(factory, factory, mFactory, mFactory2);
        } 
        
        
            
        
        
            
        
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.408 -0400", hash_original_method = "140FDA0509CDD22FFA77677DC0A919DF", hash_generated_method = "7B48C17DCCFC347FF964BDAD9D35BB77")
    public void setPrivateFactory(Factory2 factory) {
        mPrivateFactory = factory;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.409 -0400", hash_original_method = "A182F1708C145D57F0135D6BE7F61F0B", hash_generated_method = "82B6C42FE2352825E172F11C9B2EDF88")
    public Filter getFilter() {
        Filter varB4EAC82CA7396A68D541C85D26508E83_1217110622 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1217110622 = mFilter;
        varB4EAC82CA7396A68D541C85D26508E83_1217110622.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1217110622;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.409 -0400", hash_original_method = "E7980136733C7B2EC13AC2733EC56104", hash_generated_method = "CC6E8B33A6496ED5B6BA3EE1509DBFD6")
    public void setFilter(Filter filter) {
        mFilter = filter;
        {
            mFilterMap = new HashMap<String, Boolean>();
        } 
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.410 -0400", hash_original_method = "33D0E6277D03283945C33D82FE1E07F8", hash_generated_method = "F0135948FE58A90976AED8FEA5CD0D9A")
    public View inflate(int resource, ViewGroup root) {
        View varB4EAC82CA7396A68D541C85D26508E83_842156107 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_842156107 = inflate(resource, root, root != null);
        addTaint(resource);
        addTaint(root.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_842156107.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_842156107;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.410 -0400", hash_original_method = "2C6130928BF5FC4257D730B98F9E332E", hash_generated_method = "2A2A719D34466C4CEFEFF97AC1D029DB")
    public View inflate(XmlPullParser parser, ViewGroup root) {
        View varB4EAC82CA7396A68D541C85D26508E83_1310625221 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1310625221 = inflate(parser, root, root != null);
        addTaint(parser.getTaint());
        addTaint(root.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1310625221.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1310625221;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.411 -0400", hash_original_method = "73105F6C94DACD9E83BB5CE96738BE14", hash_generated_method = "B34127E1566144A7E5BAC384DF94DAAB")
    public View inflate(int resource, ViewGroup root, boolean attachToRoot) {
        View varB4EAC82CA7396A68D541C85D26508E83_1390104899 = null; 
        System.out.println("INFLATING from resource: " + resource);
        XmlResourceParser parser = getContext().getResources().getLayout(resource);
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1390104899 = inflate(parser, root, attachToRoot);
        } 
        finally 
        {
            parser.close();
        } 
        addTaint(resource);
        addTaint(root.getTaint());
        addTaint(attachToRoot);
        varB4EAC82CA7396A68D541C85D26508E83_1390104899.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1390104899;
        
        
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.412 -0400", hash_original_method = "9DFC9AE5F080C22C20FBC66EE3D8715B", hash_generated_method = "8AA6AA053634540F86A7EE8F3A75D991")
    public View inflate(XmlPullParser parser, ViewGroup root, boolean attachToRoot) {
        View varB4EAC82CA7396A68D541C85D26508E83_1364834005 = null; 
        {
            final AttributeSet attrs = Xml.asAttributeSet(parser);
            Context lastContext = (Context)mConstructorArgs[0];
            mConstructorArgs[0] = mContext;
            View result = root;
            try 
            {
                int type;
                {
                    boolean varE58D9BEEA9A8E881BB4855D510C76E16_484829693 = ((type = parser.next()) != XmlPullParser.START_TAG &&
                        type != XmlPullParser.END_DOCUMENT);
                } 
                {
                    if (DroidSafeAndroidRuntime.control) throw new InflateException(parser.getPositionDescription()
                            + ": No start tag found!");
                } 
                final String name = parser.getName();
                {
                    System.out.println("**************************");
                    System.out.println("Creating root view: "
                            + name);
                    System.out.println("**************************");
                } 
                {
                    boolean varFDE52F8163E69EE326159C2642CAEC68_1759825982 = (TAG_MERGE.equals(name));
                    {
                        {
                            if (DroidSafeAndroidRuntime.control) throw new InflateException("<merge /> can be used only with a valid "
                                + "ViewGroup root and attachToRoot=true");
                        } 
                        rInflate(parser, root, attrs, false);
                    } 
                    {
                        View temp;
                        {
                            boolean varCE5DAB92F3FE827A985DB892C11A30CF_1195415402 = (TAG_1995.equals(name));
                            {
                                temp = new BlinkLayout(mContext, attrs);
                            } 
                            {
                                temp = createViewFromTag(root, name, attrs);
                            } 
                        } 
                        ViewGroup.LayoutParams params = null;
                        {
                            {
                                System.out.println("Creating params from root: " +
                                    root);
                            } 
                            params = root.generateLayoutParams(attrs);
                            {
                                temp.setLayoutParams(params);
                            } 
                        } 
                        {
                            System.out.println("-----> start inflating children");
                        } 
                        rInflate(parser, temp, attrs, true);
                        {
                            System.out.println("-----> done inflating children");
                        } 
                        {
                            root.addView(temp, params);
                        } 
                        {
                            result = temp;
                        } 
                    } 
                } 
            } 
            catch (XmlPullParserException e)
            {
                InflateException ex = new InflateException(e.getMessage());
                ex.initCause(e);
                if (DroidSafeAndroidRuntime.control) throw ex;
            } 
            catch (IOException e)
            {
                InflateException ex = new InflateException(
                        parser.getPositionDescription()
                        + ": " + e.getMessage());
                ex.initCause(e);
                if (DroidSafeAndroidRuntime.control) throw ex;
            } 
            finally 
            {
                mConstructorArgs[0] = lastContext;
                mConstructorArgs[1] = null;
            } 
            varB4EAC82CA7396A68D541C85D26508E83_1364834005 = result;
        } 
        addTaint(parser.getTaint());
        addTaint(root.getTaint());
        addTaint(attachToRoot);
        varB4EAC82CA7396A68D541C85D26508E83_1364834005.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1364834005;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.414 -0400", hash_original_method = "9249249C6DEB7757C8882D406CD78B4B", hash_generated_method = "307CC1D335DBF11EA80B9846AD1EF9DD")
    public final View createView(String name, String prefix, AttributeSet attrs) throws ClassNotFoundException, InflateException {
        View varB4EAC82CA7396A68D541C85D26508E83_470281609 = null; 
        Constructor<? extends View> constructor = sConstructorMap.get(name);
        Class<? extends View> clazz = null;
        try 
        {
            {
                clazz = mContext.getClassLoader().loadClass(
                        prefix != null ? (prefix + name) : name).asSubclass(View.class);
                {
                    boolean allowed = mFilter.onLoadClass(clazz);
                    {
                        failNotAllowed(name, prefix, attrs);
                    } 
                } 
                constructor = clazz.getConstructor(mConstructorSignature);
                sConstructorMap.put(name, constructor);
            } 
            {
                {
                    Boolean allowedState = mFilterMap.get(name);
                    {
                        clazz = mContext.getClassLoader().loadClass(
                                prefix != null ? (prefix + name) : name).asSubclass(View.class);
                        boolean allowed = clazz != null && mFilter.onLoadClass(clazz);
                        mFilterMap.put(name, allowed);
                        {
                            failNotAllowed(name, prefix, attrs);
                        } 
                    } 
                    {
                        boolean var5283AA69DC1B5B630A4798CB7C4AEC9B_614007008 = (allowedState.equals(Boolean.FALSE));
                        {
                            failNotAllowed(name, prefix, attrs);
                        } 
                    } 
                } 
            } 
            Object[] args = mConstructorArgs;
            args[1] = attrs;
            varB4EAC82CA7396A68D541C85D26508E83_470281609 = constructor.newInstance(args);
        } 
        catch (NoSuchMethodException e)
        {
            InflateException ie = new InflateException(attrs.getPositionDescription()
                    + ": Error inflating class "
                    + (prefix != null ? (prefix + name) : name));
            ie.initCause(e);
            if (DroidSafeAndroidRuntime.control) throw ie;
        } 
        catch (ClassCastException e)
        {
            InflateException ie = new InflateException(attrs.getPositionDescription()
                    + ": Class is not a View "
                    + (prefix != null ? (prefix + name) : name));
            ie.initCause(e);
            if (DroidSafeAndroidRuntime.control) throw ie;
        } 
        catch (ClassNotFoundException e)
        {
            if (DroidSafeAndroidRuntime.control) throw e;
        } 
        catch (Exception e)
        {
            InflateException ie = new InflateException(attrs.getPositionDescription()
                    + ": Error inflating class "
                    + (clazz == null ? "<unknown>" : clazz.getName()));
            ie.initCause(e);
            if (DroidSafeAndroidRuntime.control) throw ie;
        } 
        addTaint(name.getTaint());
        addTaint(prefix.getTaint());
        addTaint(attrs.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_470281609.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_470281609;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.414 -0400", hash_original_method = "0971FA0124FB7B31B88F61FC842AABEB", hash_generated_method = "828B17EED119371332A086461FFFFA26")
    private void failNotAllowed(String name, String prefix, AttributeSet attrs) {
        if (DroidSafeAndroidRuntime.control) throw new InflateException(attrs.getPositionDescription()
                + ": Class not allowed to be inflated "
                + (prefix != null ? (prefix + name) : name));
        addTaint(name.getTaint());
        addTaint(prefix.getTaint());
        addTaint(attrs.getTaint());
        
        
                
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.415 -0400", hash_original_method = "9A9783E7AF685525083052EAFC6937D8", hash_generated_method = "1E207BB40C5C716F41AA58EEB373A9D2")
    protected View onCreateView(String name, AttributeSet attrs) throws ClassNotFoundException {
        
        View varB4EAC82CA7396A68D541C85D26508E83_1262618433 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1262618433 = createView(name, "android.view.", attrs);
        addTaint(name.getTaint());
        addTaint(attrs.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1262618433.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1262618433;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.416 -0400", hash_original_method = "EEF2BD4B979EFD4F0FBDCDB52C08D7B2", hash_generated_method = "6ADC2F89920DA0D233464389C1CD9360")
    protected View onCreateView(View parent, String name, AttributeSet attrs) throws ClassNotFoundException {
        
        View varB4EAC82CA7396A68D541C85D26508E83_1968368285 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1968368285 = onCreateView(name, attrs);
        addTaint(parent.getTaint());
        addTaint(name.getTaint());
        addTaint(attrs.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1968368285.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1968368285;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.417 -0400", hash_original_method = "42E00CE52BE01D0BF7040FF60139A865", hash_generated_method = "EEE2937B8CA47B5A8769498B9D2C7717")
     View createViewFromTag(View parent, String name, AttributeSet attrs) {
        View varB4EAC82CA7396A68D541C85D26508E83_1397332095 = null; 
        {
            boolean var8FFDB426A97735EAEA80E33D0B5E59B2_64134003 = (name.equals("view"));
            {
                name = attrs.getAttributeValue(null, "class");
            } 
        } 
        System.out.println("******** Creating view: " + name);
        try 
        {
            View view;
            view = mFactory2.onCreateView(parent, name, mContext, attrs);
            view = mFactory.onCreateView(name, mContext, attrs);
            view = null;
            {
                view = mPrivateFactory.onCreateView(parent, name, mContext, attrs);
            } 
            {
                {
                    boolean var8670E3C6635B63F51E108DA3DA62F822_1045414216 = (-1 == name.indexOf('.'));
                    {
                        view = onCreateView(parent, name, attrs);
                    } 
                    {
                        view = createView(name, null, attrs);
                    } 
                } 
            } 
            System.out.println("Created view is: " + view);
            varB4EAC82CA7396A68D541C85D26508E83_1397332095 = view;
        } 
        catch (InflateException e)
        {
            if (DroidSafeAndroidRuntime.control) throw e;
        } 
        catch (ClassNotFoundException e)
        {
            InflateException ie = new InflateException(attrs.getPositionDescription()
                    + ": Error inflating class " + name);
            ie.initCause(e);
            if (DroidSafeAndroidRuntime.control) throw ie;
        } 
        catch (Exception e)
        {
            InflateException ie = new InflateException(attrs.getPositionDescription()
                    + ": Error inflating class " + name);
            ie.initCause(e);
            if (DroidSafeAndroidRuntime.control) throw ie;
        } 
        addTaint(parent.getTaint());
        addTaint(name.getTaint());
        addTaint(attrs.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1397332095.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1397332095;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.418 -0400", hash_original_method = "3A61628D6ED69C72EF61CAE501BAE992", hash_generated_method = "EDBADE0DA051EA00243157904A3E42CC")
     void rInflate(XmlPullParser parser, View parent, final AttributeSet attrs,
            boolean finishInflate) throws XmlPullParserException, IOException {
        final int depth = parser.getDepth();
        int type;
        {
            boolean var823E94E9B6300A88398882F66A824AFC_1534746009 = (((type = parser.next()) != XmlPullParser.END_TAG ||
                parser.getDepth() > depth) && type != XmlPullParser.END_DOCUMENT);
            {
                final String name = parser.getName();
                {
                    boolean var9E864073812E74645886E00F3C1FA42E_1878109500 = (TAG_REQUEST_FOCUS.equals(name));
                    {
                        parseRequestFocus(parser, parent);
                    } 
                    {
                        boolean var3A72FDB7DEFA1B4376ED852227EE7220_2021008674 = (TAG_INCLUDE.equals(name));
                        {
                            {
                                boolean varF9E7792F5EE78FD8E2EF7727515E4EC9_1679852382 = (parser.getDepth() == 0);
                                {
                                    if (DroidSafeAndroidRuntime.control) throw new InflateException("<include /> cannot be the root element");
                                } 
                            } 
                            parseInclude(parser, parent, attrs);
                        } 
                        {
                            boolean var6E0AFF7B2B3D2BD63E19797766EAC38B_1269499589 = (TAG_MERGE.equals(name));
                            {
                                if (DroidSafeAndroidRuntime.control) throw new InflateException("<merge /> must be the root element");
                            } 
                            {
                                boolean varA10A7F5947ED2B40D379831A43F34249_1942789961 = (TAG_1995.equals(name));
                                {
                                    final View view = new BlinkLayout(mContext, attrs);
                                    final ViewGroup viewGroup = (ViewGroup) parent;
                                    final ViewGroup.LayoutParams params = viewGroup.generateLayoutParams(attrs);
                                    rInflate(parser, view, attrs, true);
                                    viewGroup.addView(view, params);
                                } 
                                {
                                    final View view = createViewFromTag(parent, name, attrs);
                                    final ViewGroup viewGroup = (ViewGroup) parent;
                                    final ViewGroup.LayoutParams params = viewGroup.generateLayoutParams(attrs);
                                    rInflate(parser, view, attrs, true);
                                    viewGroup.addView(view, params);
                                } 
                            } 
                        } 
                    } 
                } 
            } 
        } 
        parent.onFinishInflate();
        addTaint(parser.getTaint());
        addTaint(parent.getTaint());
        addTaint(attrs.getTaint());
        addTaint(finishInflate);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.419 -0400", hash_original_method = "D305B9D132FFD898328C34D4AEEA8981", hash_generated_method = "5DB9C88BF20E8A44C0D4DABCA4109308")
    private void parseRequestFocus(XmlPullParser parser, View parent) throws XmlPullParserException, IOException {
        int type;
        parent.requestFocus();
        final int currentDepth = parser.getDepth();
        {
            boolean var0A9D2815252DF1D1527DC7B6C5EBCE25_743442109 = (((type = parser.next()) != XmlPullParser.END_TAG ||
                parser.getDepth() > currentDepth) && type != XmlPullParser.END_DOCUMENT);
        } 
        addTaint(parser.getTaint());
        addTaint(parent.getTaint());
        
        
        
        
        
                
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.421 -0400", hash_original_method = "3903965D4D2522F244AF5345C6CDB188", hash_generated_method = "CB5072409CC3F1BF01DC3AC63721096E")
    private void parseInclude(XmlPullParser parser, View parent, AttributeSet attrs) throws XmlPullParserException, IOException {
        int type;
        {
            final int layout = attrs.getAttributeResourceValue(null, "layout", 0);
            {
                final String value = attrs.getAttributeValue(null, "layout");
                {
                    if (DroidSafeAndroidRuntime.control) throw new InflateException("You must specifiy a layout in the"
                            + " include tag: <include layout=\"@layout/layoutID\" />");
                } 
                {
                    if (DroidSafeAndroidRuntime.control) throw new InflateException("You must specifiy a valid layout "
                            + "reference. The layout ID " + value + " is not valid.");
                } 
            } 
            {
                final XmlResourceParser childParser = getContext().getResources().getLayout(layout);
                try 
                {
                    final AttributeSet childAttrs = Xml.asAttributeSet(childParser);
                    {
                        boolean var85BD6F6EF64876B51C9884A0DAC7FEDE_651627869 = ((type = childParser.next()) != XmlPullParser.START_TAG &&
                            type != XmlPullParser.END_DOCUMENT);
                    } 
                    {
                        if (DroidSafeAndroidRuntime.control) throw new InflateException(childParser.getPositionDescription() +
                                ": No start tag found!");
                    } 
                    final String childName = childParser.getName();
                    {
                        boolean var5E823F928FF3B68CA0565BBB723D4C0E_951236305 = (TAG_MERGE.equals(childName));
                        {
                            rInflate(childParser, parent, childAttrs, false);
                        } 
                        {
                            final View view = createViewFromTag(parent, childName, childAttrs);
                            final ViewGroup group = (ViewGroup) parent;
                            ViewGroup.LayoutParams params = null;
                            try 
                            {
                                params = group.generateLayoutParams(attrs);
                            } 
                            catch (RuntimeException e)
                            {
                                params = group.generateLayoutParams(childAttrs);
                            } 
                            finally 
                            {
                                {
                                    view.setLayoutParams(params);
                                } 
                            } 
                            rInflate(childParser, view, childAttrs, true);
                            TypedArray a = mContext.obtainStyledAttributes(attrs,
                            com.android.internal.R.styleable.View, 0, 0);
                            int id = a.getResourceId(com.android.internal.R.styleable.View_id, View.NO_ID);
                            int visibility = a.getInt(com.android.internal.R.styleable.View_visibility, -1);
                            a.recycle();
                            {
                                view.setId(id);
                            } 
                            
                            view.setVisibility(View.VISIBLE);
                            
                            
                            view.setVisibility(View.INVISIBLE);
                            
                            
                            view.setVisibility(View.GONE);
                            
                            group.addView(view);
                        } 
                    } 
                } 
                finally 
                {
                    childParser.close();
                } 
            } 
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new InflateException("<include /> can only be used inside of a ViewGroup");
        } 
        final int currentDepth = parser.getDepth();
        {
            boolean var0A9D2815252DF1D1527DC7B6C5EBCE25_394839609 = (((type = parser.next()) != XmlPullParser.END_TAG ||
                parser.getDepth() > currentDepth) && type != XmlPullParser.END_DOCUMENT);
        } 
        addTaint(parser.getTaint());
        addTaint(parent.getTaint());
        addTaint(attrs.getTaint());
        
        
    }

    
    private static class FactoryMerger implements Factory2 {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.421 -0400", hash_original_field = "B388ED792FF72DF72B1BCDB08C954A34", hash_generated_field = "5597E72774649F58EAFC93193B0F56F5")

        private Factory mF1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.421 -0400", hash_original_field = "D2F7236B8084EBD38FEB109B60093F59", hash_generated_field = "980C2131F1904820A671FBE786E0A976")

        private Factory mF2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.421 -0400", hash_original_field = "EFB292FB0A8C321793AF25ADBD699004", hash_generated_field = "F581D9BC63EDDF42FCA0DB75903DA713")

        private Factory2 mF12;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.421 -0400", hash_original_field = "F95B8BEDDD7E63CA0369D2E0B75E60F0", hash_generated_field = "279141595E6D3718BC3E6B02DB3437E1")

        private Factory2 mF22;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.422 -0400", hash_original_method = "E5AD3FF1F375743BB365B35578675E98", hash_generated_method = "2C2C626FEF544A6A4B4A2A329D6C4155")
          FactoryMerger(Factory f1, Factory2 f12, Factory f2, Factory2 f22) {
            mF1 = f1;
            mF2 = f2;
            mF12 = f12;
            mF22 = f22;
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.422 -0400", hash_original_method = "912C6EE593A6921C8E87D5E0641D7CDD", hash_generated_method = "2806E78D0A1445F57B41E3956E5DAF0A")
        public View onCreateView(String name, Context context, AttributeSet attrs) {
            
            View varB4EAC82CA7396A68D541C85D26508E83_1830028905 = null; 
            View varB4EAC82CA7396A68D541C85D26508E83_1410350257 = null; 
            View v = mF1.onCreateView(name, context, attrs);
            varB4EAC82CA7396A68D541C85D26508E83_1830028905 = v;
            varB4EAC82CA7396A68D541C85D26508E83_1410350257 = mF2.onCreateView(name, context, attrs);
            addTaint(name.getTaint());
            addTaint(context.getTaint());
            addTaint(attrs.getTaint());
            View varA7E53CE21691AB073D9660D615818899_2090794426; 
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: 
                    varA7E53CE21691AB073D9660D615818899_2090794426 = varB4EAC82CA7396A68D541C85D26508E83_1830028905;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_2090794426 = varB4EAC82CA7396A68D541C85D26508E83_1410350257;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_2090794426.addTaint(getTaint()); 
            return varA7E53CE21691AB073D9660D615818899_2090794426;
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.423 -0400", hash_original_method = "F1957EAE5145EA0F0129265F270794D6", hash_generated_method = "8962627D3CF87031350393A76FEAEE7E")
        public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
            
            View varB4EAC82CA7396A68D541C85D26508E83_1604362624 = null; 
            View varB4EAC82CA7396A68D541C85D26508E83_459321774 = null; 
            View v;
            v = mF12.onCreateView(parent, name, context, attrs);
            v = mF1.onCreateView(name, context, attrs);
            varB4EAC82CA7396A68D541C85D26508E83_1604362624 = v;
            varB4EAC82CA7396A68D541C85D26508E83_459321774 = mF22 != null ? mF22.onCreateView(parent, name, context, attrs)
                    : mF2.onCreateView(name, context, attrs);
            addTaint(parent.getTaint());
            addTaint(name.getTaint());
            addTaint(context.getTaint());
            addTaint(attrs.getTaint());
            View varA7E53CE21691AB073D9660D615818899_1477024124; 
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: 
                    varA7E53CE21691AB073D9660D615818899_1477024124 = varB4EAC82CA7396A68D541C85D26508E83_1604362624;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1477024124 = varB4EAC82CA7396A68D541C85D26508E83_459321774;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1477024124.addTaint(getTaint()); 
            return varA7E53CE21691AB073D9660D615818899_1477024124;
            
            
                    
            
            
                    
        }

        
    }


    
    private static class BlinkLayout extends FrameLayout {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.423 -0400", hash_original_field = "57ABA66DF5CCF392086380D760C5BF59", hash_generated_field = "9F94E2291878F4B79ED3B6B67A1ED0C7")

        private boolean mBlink;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.423 -0400", hash_original_field = "84A61AEDD18A7D6ECA3FB13967806C7E", hash_generated_field = "57E34B9F322B663DA6033C74FD1E64C4")

        private boolean mBlinkState;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.423 -0400", hash_original_field = "C78BEDFC523DB73DF63EFB071AF1C35B", hash_generated_field = "03E47BA0CE42772601F0A13D178B12B5")

        private Handler mHandler;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.425 -0400", hash_original_method = "3DD68C66D41BE889B84232F33376A99A", hash_generated_method = "E6442AB00DFEC8388A6A02C9BAC5D069")
        public  BlinkLayout(Context context, AttributeSet attrs) {
            super(context, attrs);
            mHandler = new Handler(new Handler.Callback() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.425 -0400", hash_original_method = "3CDE63BB1E6E2FE4ACBB53B93DE4CB6C", hash_generated_method = "7D2741FBF3BC77D435FA5EBC3DF28835")
                @Override
                public boolean handleMessage(Message msg) {
                    {
                        {
                            mBlinkState = !mBlinkState;
                            makeBlink();
                        } 
                        invalidate();
                    } 
                    addTaint(msg.getTaint());
                    boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_56379214 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_56379214;
                    
                    
                        
                            
                            
                        
                        
                        
                    
                    
                }
});
            addTaint(context.getTaint());
            addTaint(attrs.getTaint());
            
            
                
                
                    
                        
                            
                            
                        
                        
                        
                    
                    
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.425 -0400", hash_original_method = "553FA2CA85816FF11073226F48838667", hash_generated_method = "00C0A90E7BA24936A24ED91BF6920ACE")
        private void makeBlink() {
            Message message = mHandler.obtainMessage(MESSAGE_BLINK);
            mHandler.sendMessageDelayed(message, BLINK_DELAY);
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.426 -0400", hash_original_method = "F84801EA6DE017B4DF3D928CA8059755", hash_generated_method = "5442A9264ED4F4E31C0BA66C5931886A")
        @Override
        protected void onAttachedToWindow() {
            
            super.onAttachedToWindow();
            mBlink = true;
            mBlinkState = true;
            makeBlink();
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.426 -0400", hash_original_method = "68779D94DBD6ED32D8C444331B18EB29", hash_generated_method = "A65982EADCE2056B98837C8AE9E7BCE2")
        @Override
        protected void onDetachedFromWindow() {
            
            super.onDetachedFromWindow();
            mBlink = false;
            mBlinkState = true;
            mHandler.removeMessages(MESSAGE_BLINK);
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.426 -0400", hash_original_method = "B2A7E99D93A7E570FADBB759CB038122", hash_generated_method = "DC76C125C06C4E0D5A7C567BB0DDA97F")
        @Override
        protected void dispatchDraw(Canvas canvas) {
            {
                super.dispatchDraw(canvas);
            } 
            addTaint(canvas.getTaint());
            
            
                
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.426 -0400", hash_original_field = "FCC4B1B643B64678EC5C05DB4601EBF9", hash_generated_field = "4A3D47FA8808A8239672ED34E6BFB3B1")

        private static final int MESSAGE_BLINK = 0x42;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.426 -0400", hash_original_field = "C0C33B4F311995BA1D316E6C41B33B82", hash_generated_field = "D5B9EC9F6E148AEB7231E8904BDB2F8F")

        private static final int BLINK_DELAY = 500;
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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.427 -0400", hash_original_field = "1125430DAA7CF8795E7D402DB0D83E08", hash_generated_field = "63DF1F110DEB7B86F6BD18817F9A4731")

    static final Class<?>[] mConstructorSignature = new Class[] {
            Context.class, AttributeSet.class};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.427 -0400", hash_original_field = "176CD41BE1EF5E4979EA824C2AEDF2B1", hash_generated_field = "C38DE3F776CAFB12B475430CF0EEAA23")

    private static final HashMap<String, Constructor<? extends View>> sConstructorMap = new HashMap<String, Constructor<? extends View>>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.427 -0400", hash_original_field = "EED9DF1080CAF39D9C37A9B5067943FA", hash_generated_field = "36C7BA0C809B7EB42A272F2829D1F77B")

    private static final String TAG_MERGE = "merge";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.427 -0400", hash_original_field = "932E55CE33B67AAED6E42C38C17410C7", hash_generated_field = "E44225DBBDDDD64E37F1DAB51EE83BFC")

    private static final String TAG_INCLUDE = "include";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.427 -0400", hash_original_field = "EB60FFD74626EBCFC26C23DBDF32C98B", hash_generated_field = "D5A8197B8C970976D34EB44455934252")

    private static final String TAG_1995 = "blink";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.427 -0400", hash_original_field = "10D3EBD501FBA20B3D43BF08D4F12183", hash_generated_field = "245DD97419AEA5026E042D1B40675C79")

    private static final String TAG_REQUEST_FOCUS = "requestFocus";
}

