package android.preference;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import android.content.Context;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.ContextThemeWrapper;
import android.view.InflateException;
import android.view.LayoutInflater;

abstract class GenericInflater<T, P extends GenericInflater.Parent> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.871 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "40AF400BA8F86FA9C9E428F903D03FF5")

    private final boolean DEBUG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.871 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "B3359F86E29A965BC1436888E98C55A8")

    protected Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.871 -0400", hash_original_field = "92E068AC1DA6911449EC771C547D2553", hash_generated_field = "AED919A3A7191A7906DCEFFE6A0831DA")

    private boolean mFactorySet;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.871 -0400", hash_original_field = "06389DE86ED19AB1571A41645A1AFADC", hash_generated_field = "05BA2F2FD6F3066B67DC96510DE31D25")

    private Factory<T> mFactory;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.871 -0400", hash_original_field = "A4A4795AC0E32E86ABF7474DEAC57538", hash_generated_field = "BAC245513231B6A4CDBDF61862A69933")

    private final Object[] mConstructorArgs = new Object[2];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.871 -0400", hash_original_field = "16CD905047E4400746288B9C013DD010", hash_generated_field = "6581AC575AE1E4EEB60567A9B3808F54")

    private String mDefaultPackage;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.871 -0400", hash_original_method = "A8AA332702376B454A767A9414B9F159", hash_generated_method = "FB5B2F7669C654AD5EBC4C0486706ABC")
    protected  GenericInflater(Context context) {
        mContext = context;
        // ---------- Original Method ----------
        //mContext = context;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.871 -0400", hash_original_method = "6B35BDBE0F984168A951D53A5AF8F867", hash_generated_method = "5B3124184A7A1A83CB974DBE9483156C")
    protected  GenericInflater(GenericInflater<T,P> original, Context newContext) {
        mContext = newContext;
        mFactory = original.mFactory;
        // ---------- Original Method ----------
        //mContext = newContext;
        //mFactory = original.mFactory;
    }

    
    public abstract GenericInflater cloneInContext(Context newContext);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.872 -0400", hash_original_method = "601AA595429A3B000CED526A81A8472C", hash_generated_method = "7BC7A6A5CCACB62BC0C669BFFD05EDF1")
    public void setDefaultPackage(String defaultPackage) {
        mDefaultPackage = defaultPackage;
        // ---------- Original Method ----------
        //mDefaultPackage = defaultPackage;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.872 -0400", hash_original_method = "46E608B0485504B383BE067A0BD6622F", hash_generated_method = "834868E0B67CC4499DC882F397483218")
    public String getDefaultPackage() {
        String varB4EAC82CA7396A68D541C85D26508E83_1352290399 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1352290399 = mDefaultPackage;
        varB4EAC82CA7396A68D541C85D26508E83_1352290399.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1352290399;
        // ---------- Original Method ----------
        //return mDefaultPackage;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.873 -0400", hash_original_method = "4F4EBC54D108D66F416C93B46580E117", hash_generated_method = "8FE47BBA62FEBCCCA3402ABBFBF90E7C")
    public Context getContext() {
        Context varB4EAC82CA7396A68D541C85D26508E83_661608666 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_661608666 = mContext;
        varB4EAC82CA7396A68D541C85D26508E83_661608666.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_661608666;
        // ---------- Original Method ----------
        //return mContext;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.873 -0400", hash_original_method = "E145074F4BEE68EC84A4CE1558E8DDDD", hash_generated_method = "D583EEF7AD1811393B08E90C3D8AB001")
    public final Factory<T> getFactory() {
        Factory<T> varB4EAC82CA7396A68D541C85D26508E83_2115047350 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2115047350 = mFactory;
        varB4EAC82CA7396A68D541C85D26508E83_2115047350.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2115047350;
        // ---------- Original Method ----------
        //return mFactory;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.873 -0400", hash_original_method = "F731ABA6658EE884292BF19729B20DA7", hash_generated_method = "DC68B40FCCDE020A27DAA7E00D395DDD")
    public void setFactory(Factory<T> factory) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("" +
            		"A factory has already been set on this inflater");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("Given factory can not be null");
        } //End block
        mFactorySet = true;
        {
            mFactory = factory;
        } //End block
        {
            mFactory = new FactoryMerger<T>(factory, mFactory);
        } //End block
        // ---------- Original Method ----------
        //if (mFactorySet) {
            //throw new IllegalStateException("" +
            		//"A factory has already been set on this inflater");
        //}
        //if (factory == null) {
            //throw new NullPointerException("Given factory can not be null");
        //}
        //mFactorySet = true;
        //if (mFactory == null) {
            //mFactory = factory;
        //} else {
            //mFactory = new FactoryMerger<T>(factory, mFactory);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.874 -0400", hash_original_method = "0AF1546F925E79A6FCD8229E5389F782", hash_generated_method = "FAF61B85427B58AE5DE8EED9E83F6B40")
    public T inflate(int resource, P root) {
        T varB4EAC82CA7396A68D541C85D26508E83_448169076 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_448169076 = inflate(resource, root, root != null);
        addTaint(resource);
        addTaint(root.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_448169076.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_448169076;
        // ---------- Original Method ----------
        //return inflate(resource, root, root != null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.874 -0400", hash_original_method = "A09A6320AB1158C141A52528AA964FE1", hash_generated_method = "67E8D75FCD6946C1CDF78CE827BE61F4")
    public T inflate(XmlPullParser parser, P root) {
        T varB4EAC82CA7396A68D541C85D26508E83_1385398633 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1385398633 = inflate(parser, root, root != null);
        addTaint(parser.getTaint());
        addTaint(root.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1385398633.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1385398633;
        // ---------- Original Method ----------
        //return inflate(parser, root, root != null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.875 -0400", hash_original_method = "C3BB64443334F9B40F1AFC79B102744E", hash_generated_method = "2EC90A7364266928EFF5A6381C41EB23")
    public T inflate(int resource, P root, boolean attachToRoot) {
        T varB4EAC82CA7396A68D541C85D26508E83_120172163 = null; //Variable for return #1
        System.out.println("INFLATING from resource: " + resource);
        XmlResourceParser parser = getContext().getResources().getXml(resource);
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_120172163 = inflate(parser, root, attachToRoot);
        } //End block
        finally 
        {
            parser.close();
        } //End block
        addTaint(resource);
        addTaint(root.getTaint());
        addTaint(attachToRoot);
        varB4EAC82CA7396A68D541C85D26508E83_120172163.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_120172163;
        // ---------- Original Method ----------
        //if (DEBUG) System.out.println("INFLATING from resource: " + resource);
        //XmlResourceParser parser = getContext().getResources().getXml(resource);
        //try {
            //return inflate(parser, root, attachToRoot);
        //} finally {
            //parser.close();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.877 -0400", hash_original_method = "93981E75696898B46E3B07FB71CA5701", hash_generated_method = "A2ECDC7ADBD9D83EB973CA88F0010BA7")
    public T inflate(XmlPullParser parser, P root,
            boolean attachToRoot) {
        T varB4EAC82CA7396A68D541C85D26508E83_1147505249 = null; //Variable for return #1
        {
            final AttributeSet attrs = Xml.asAttributeSet(parser);
            mConstructorArgs[0] = mContext;
            T result = (T) root;
            try 
            {
                int type;
                {
                    boolean var41639DC9639CF1CFBBBC344008E02D90_613848072 = ((type = parser.next()) != parser.START_TAG
                        && type != parser.END_DOCUMENT);
                    {
                        ;
                    } //End block
                } //End collapsed parenthetic
                {
                    if (DroidSafeAndroidRuntime.control) throw new InflateException(parser.getPositionDescription()
                            + ": No start tag found!");
                } //End block
                {
                    System.out.println("**************************");
                    System.out.println("Creating root: "
                            + parser.getName());
                    System.out.println("**************************");
                } //End block
                T xmlRoot = createItemFromTag(parser, parser.getName(),
                        attrs);
                result = (T) onMergeRoots(root, attachToRoot, (P) xmlRoot);
                {
                    System.out.println("-----> start inflating children");
                } //End block
                rInflate(parser, result, attrs);
                {
                    System.out.println("-----> done inflating children");
                } //End block
            } //End block
            catch (InflateException e)
            {
                if (DroidSafeAndroidRuntime.control) throw e;
            } //End block
            catch (XmlPullParserException e)
            {
                InflateException ex = new InflateException(e.getMessage());
                ex.initCause(e);
                if (DroidSafeAndroidRuntime.control) throw ex;
            } //End block
            catch (IOException e)
            {
                InflateException ex = new InflateException(
                        parser.getPositionDescription()
                        + ": " + e.getMessage());
                ex.initCause(e);
                if (DroidSafeAndroidRuntime.control) throw ex;
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1147505249 = result;
        } //End block
        addTaint(parser.getTaint());
        addTaint(root.getTaint());
        addTaint(attachToRoot);
        varB4EAC82CA7396A68D541C85D26508E83_1147505249.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1147505249;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.879 -0400", hash_original_method = "AB0D32CECCD43C7D0F0360210FD11363", hash_generated_method = "03969F579A544CEA0B48633336947B7D")
    public final T createItem(String name, String prefix, AttributeSet attrs) throws ClassNotFoundException, InflateException {
        T varB4EAC82CA7396A68D541C85D26508E83_1608766271 = null; //Variable for return #1
        Constructor constructor = (Constructor) sConstructorMap.get(name);
        try 
        {
            {
                Class clazz = mContext.getClassLoader().loadClass(
                        prefix != null ? (prefix + name) : name);//DSFIXME:  CODE0008: Nested ternary operator in expression
                constructor = clazz.getConstructor(mConstructorSignature);
                sConstructorMap.put(name, constructor);
            } //End block
            Object[] args = mConstructorArgs;
            args[1] = attrs;
            varB4EAC82CA7396A68D541C85D26508E83_1608766271 = (T) constructor.newInstance(args);
        } //End block
        catch (NoSuchMethodException e)
        {
            InflateException ie = new InflateException(attrs
                    .getPositionDescription()
                    + ": Error inflating class "
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
            InflateException ie = new InflateException(attrs
                    .getPositionDescription()
                    + ": Error inflating class "
                    + constructor.getClass().getName());
            ie.initCause(e);
            if (DroidSafeAndroidRuntime.control) throw ie;
        } //End block
        addTaint(name.getTaint());
        addTaint(prefix.getTaint());
        addTaint(attrs.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1608766271.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1608766271;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.879 -0400", hash_original_method = "4FBBE2487A51D08C4064228D927262EC", hash_generated_method = "BEE752B233B3E4CDB338782BA2214A32")
    protected T onCreateItem(String name, AttributeSet attrs) throws ClassNotFoundException {
        //DSFIXME:  CODE0009: Possible callback target function detected
        T varB4EAC82CA7396A68D541C85D26508E83_2005559354 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2005559354 = createItem(name, mDefaultPackage, attrs);
        addTaint(name.getTaint());
        addTaint(attrs.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2005559354.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2005559354;
        // ---------- Original Method ----------
        //return createItem(name, mDefaultPackage, attrs);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.880 -0400", hash_original_method = "8A20619C5B186F5C05E29B17BC664D21", hash_generated_method = "603CE333C8F1F31D9C117F419E215AEE")
    private final T createItemFromTag(XmlPullParser parser, String name, AttributeSet attrs) {
        T varB4EAC82CA7396A68D541C85D26508E83_1203736378 = null; //Variable for return #1
        System.out.println("******** Creating item: " + name);
        try 
        {
            T item;
            item = null;
            item = mFactory.onCreateItem(name, mContext, attrs);
            {
                {
                    boolean var8670E3C6635B63F51E108DA3DA62F822_1454148716 = (-1 == name.indexOf('.'));
                    {
                        item = onCreateItem(name, attrs);
                    } //End block
                    {
                        item = createItem(name, null, attrs);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            System.out.println("Created item is: " + item);
            varB4EAC82CA7396A68D541C85D26508E83_1203736378 = item;
        } //End block
        catch (InflateException e)
        {
            if (DroidSafeAndroidRuntime.control) throw e;
        } //End block
        catch (ClassNotFoundException e)
        {
            InflateException ie = new InflateException(attrs
                    .getPositionDescription()
                    + ": Error inflating class " + name);
            ie.initCause(e);
            if (DroidSafeAndroidRuntime.control) throw ie;
        } //End block
        catch (Exception e)
        {
            InflateException ie = new InflateException(attrs
                    .getPositionDescription()
                    + ": Error inflating class " + name);
            ie.initCause(e);
            if (DroidSafeAndroidRuntime.control) throw ie;
        } //End block
        addTaint(parser.getTaint());
        addTaint(name.getTaint());
        addTaint(attrs.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1203736378.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1203736378;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.881 -0400", hash_original_method = "DD09A710ED93B5E593984A56AAF093F3", hash_generated_method = "413D60C9BA2545EBF6D0F886AD1C3D23")
    private void rInflate(XmlPullParser parser, T parent, final AttributeSet attrs) throws XmlPullParserException, IOException {
        final int depth = parser.getDepth();
        int type;
        {
            boolean var012C358A24678B056366BFE377DE0D0B_1587722857 = (((type = parser.next()) != parser.END_TAG || 
                parser.getDepth() > depth) && type != parser.END_DOCUMENT);
            {
                {
                    boolean var4336BB9E2F3F5A169909027B9F509E99_632309245 = (onCreateCustomFromTag(parser, parent, attrs));
                } //End collapsed parenthetic
                {
                    System.out.println("Now inflating tag: " + parser.getName());
                } //End block
                String name = parser.getName();
                T item = createItemFromTag(parser, name, attrs);
                {
                    System.out
                        .println("Creating params from parent: " + parent);
                } //End block
                ((P) parent).addItemFromInflater(item);
                {
                    System.out.println("-----> start inflating children");
                } //End block
                rInflate(parser, item, attrs);
                {
                    System.out.println("-----> done inflating children");
                } //End block
            } //End block
        } //End collapsed parenthetic
        addTaint(parser.getTaint());
        addTaint(parent.getTaint());
        addTaint(attrs.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.882 -0400", hash_original_method = "19860FA740DE510446609E99D1C237FB", hash_generated_method = "824A154C9E9251F22773CEBD3C45FB50")
    protected boolean onCreateCustomFromTag(XmlPullParser parser, T parent,
            final AttributeSet attrs) throws XmlPullParserException {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(parser.getTaint());
        addTaint(parent.getTaint());
        addTaint(attrs.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_237210899 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_237210899;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.883 -0400", hash_original_method = "5E31CC12237E180F4815989ECA3F6501", hash_generated_method = "9D8CB3ECEDA669CF66A996FA3D4CC523")
    protected P onMergeRoots(P givenRoot, boolean attachToGivenRoot, P xmlRoot) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        P varB4EAC82CA7396A68D541C85D26508E83_1858390464 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1858390464 = xmlRoot;
        addTaint(givenRoot.getTaint());
        addTaint(attachToGivenRoot);
        addTaint(xmlRoot.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1858390464.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1858390464;
        // ---------- Original Method ----------
        //return xmlRoot;
    }

    
    private static class FactoryMerger<T> implements Factory<T> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.884 -0400", hash_original_field = "B388ED792FF72DF72B1BCDB08C954A34", hash_generated_field = "C926E99D17BAF92FDF4D7BA2DC2DD9F0")

        private Factory<T> mF1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.884 -0400", hash_original_field = "D2F7236B8084EBD38FEB109B60093F59", hash_generated_field = "B5C59E0FE8A8E61FE994C8B9CBE70464")

        private Factory<T> mF2;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.885 -0400", hash_original_method = "8268493149B8E87B72D799F680E0E2F1", hash_generated_method = "FB850E006E1460B7A165BF692F36AEC9")
          FactoryMerger(Factory<T> f1, Factory<T> f2) {
            mF1 = f1;
            mF2 = f2;
            // ---------- Original Method ----------
            //mF1 = f1;
            //mF2 = f2;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.886 -0400", hash_original_method = "361561DAAA3A2CCBFCF79A32350158C1", hash_generated_method = "AD751F902CE883EEE6A6D63A1339B257")
        public T onCreateItem(String name, Context context, AttributeSet attrs) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            T varB4EAC82CA7396A68D541C85D26508E83_1267179783 = null; //Variable for return #1
            T varB4EAC82CA7396A68D541C85D26508E83_80393965 = null; //Variable for return #2
            T v = mF1.onCreateItem(name, context, attrs);
            varB4EAC82CA7396A68D541C85D26508E83_1267179783 = v;
            varB4EAC82CA7396A68D541C85D26508E83_80393965 = mF2.onCreateItem(name, context, attrs);
            addTaint(name.getTaint());
            addTaint(context.getTaint());
            addTaint(attrs.getTaint());
            T varA7E53CE21691AB073D9660D615818899_1488754464; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_1488754464 = varB4EAC82CA7396A68D541C85D26508E83_1267179783;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1488754464 = varB4EAC82CA7396A68D541C85D26508E83_80393965;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1488754464.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_1488754464;
            // ---------- Original Method ----------
            //T v = mF1.onCreateItem(name, context, attrs);
            //if (v != null) return v;
            //return mF2.onCreateItem(name, context, attrs);
        }

        
    }


    
    public interface Parent<T> {
        public void addItemFromInflater(T child);
    }
    
    public interface Factory<T> {
        
        public T onCreateItem(String name, Context context, AttributeSet attrs);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.886 -0400", hash_original_field = "1125430DAA7CF8795E7D402DB0D83E08", hash_generated_field = "DA025B3CEA9F6DF229E9360E35C80379")

    private static final Class[] mConstructorSignature = new Class[] {
            Context.class, AttributeSet.class};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.886 -0400", hash_original_field = "ED0AF6FEF41982C7629A46F07C222461", hash_generated_field = "61C67D80619B2C9C71EFD304BA972A02")

    private static final HashMap sConstructorMap = new HashMap();
}

