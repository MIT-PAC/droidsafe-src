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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.485 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "70EF0A62E0C07C973FB61A1B1A6F999D")

    private boolean DEBUG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.485 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "B3359F86E29A965BC1436888E98C55A8")

    protected Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.485 -0400", hash_original_field = "92E068AC1DA6911449EC771C547D2553", hash_generated_field = "AED919A3A7191A7906DCEFFE6A0831DA")

    private boolean mFactorySet;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.485 -0400", hash_original_field = "06389DE86ED19AB1571A41645A1AFADC", hash_generated_field = "05BA2F2FD6F3066B67DC96510DE31D25")

    private Factory<T> mFactory;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.485 -0400", hash_original_field = "A4A4795AC0E32E86ABF7474DEAC57538", hash_generated_field = "95A2C7F69D528A1C890AE4DADCEA0BFE")

    private Object[] mConstructorArgs = new Object[2];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.485 -0400", hash_original_field = "16CD905047E4400746288B9C013DD010", hash_generated_field = "6581AC575AE1E4EEB60567A9B3808F54")

    private String mDefaultPackage;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.486 -0400", hash_original_method = "A8AA332702376B454A767A9414B9F159", hash_generated_method = "FB5B2F7669C654AD5EBC4C0486706ABC")
    protected  GenericInflater(Context context) {
        mContext = context;
        // ---------- Original Method ----------
        //mContext = context;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.486 -0400", hash_original_method = "6B35BDBE0F984168A951D53A5AF8F867", hash_generated_method = "5B3124184A7A1A83CB974DBE9483156C")
    protected  GenericInflater(GenericInflater<T,P> original, Context newContext) {
        mContext = newContext;
        mFactory = original.mFactory;
        // ---------- Original Method ----------
        //mContext = newContext;
        //mFactory = original.mFactory;
    }

    
    public abstract GenericInflater cloneInContext(Context newContext);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.495 -0400", hash_original_method = "601AA595429A3B000CED526A81A8472C", hash_generated_method = "7BC7A6A5CCACB62BC0C669BFFD05EDF1")
    public void setDefaultPackage(String defaultPackage) {
        mDefaultPackage = defaultPackage;
        // ---------- Original Method ----------
        //mDefaultPackage = defaultPackage;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.496 -0400", hash_original_method = "46E608B0485504B383BE067A0BD6622F", hash_generated_method = "35AADE47C9AA6BA70A2BEB974E1D9418")
    public String getDefaultPackage() {
        String varB4EAC82CA7396A68D541C85D26508E83_461568902 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_461568902 = mDefaultPackage;
        varB4EAC82CA7396A68D541C85D26508E83_461568902.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_461568902;
        // ---------- Original Method ----------
        //return mDefaultPackage;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.497 -0400", hash_original_method = "4F4EBC54D108D66F416C93B46580E117", hash_generated_method = "1FD9A07B3A318F6942FBF37C678265C3")
    public Context getContext() {
        Context varB4EAC82CA7396A68D541C85D26508E83_721023489 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_721023489 = mContext;
        varB4EAC82CA7396A68D541C85D26508E83_721023489.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_721023489;
        // ---------- Original Method ----------
        //return mContext;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.497 -0400", hash_original_method = "E145074F4BEE68EC84A4CE1558E8DDDD", hash_generated_method = "D990807268AE058BD169494480EEB737")
    public final Factory<T> getFactory() {
        Factory<T> varB4EAC82CA7396A68D541C85D26508E83_1400945272 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1400945272 = mFactory;
        varB4EAC82CA7396A68D541C85D26508E83_1400945272.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1400945272;
        // ---------- Original Method ----------
        //return mFactory;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.502 -0400", hash_original_method = "F731ABA6658EE884292BF19729B20DA7", hash_generated_method = "DC68B40FCCDE020A27DAA7E00D395DDD")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.520 -0400", hash_original_method = "0AF1546F925E79A6FCD8229E5389F782", hash_generated_method = "7BF32651704F578D6417F57B036B64FA")
    public T inflate(int resource, P root) {
        T varB4EAC82CA7396A68D541C85D26508E83_1604258886 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1604258886 = inflate(resource, root, root != null);
        addTaint(resource);
        addTaint(root.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1604258886.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1604258886;
        // ---------- Original Method ----------
        //return inflate(resource, root, root != null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.521 -0400", hash_original_method = "A09A6320AB1158C141A52528AA964FE1", hash_generated_method = "5627200C98EEEF3F011A49ADE69E3DC2")
    public T inflate(XmlPullParser parser, P root) {
        T varB4EAC82CA7396A68D541C85D26508E83_1175802780 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1175802780 = inflate(parser, root, root != null);
        addTaint(parser.getTaint());
        addTaint(root.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1175802780.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1175802780;
        // ---------- Original Method ----------
        //return inflate(parser, root, root != null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.522 -0400", hash_original_method = "C3BB64443334F9B40F1AFC79B102744E", hash_generated_method = "07C8B488CA2FBB0BD35EF7297AEFB468")
    public T inflate(int resource, P root, boolean attachToRoot) {
        T varB4EAC82CA7396A68D541C85D26508E83_2047546449 = null; //Variable for return #1
        System.out.println("INFLATING from resource: " + resource);
        XmlResourceParser parser;
        parser = getContext().getResources().getXml(resource);
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_2047546449 = inflate(parser, root, attachToRoot);
        } //End block
        finally 
        {
            parser.close();
        } //End block
        addTaint(resource);
        addTaint(root.getTaint());
        addTaint(attachToRoot);
        varB4EAC82CA7396A68D541C85D26508E83_2047546449.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2047546449;
        // ---------- Original Method ----------
        //if (DEBUG) System.out.println("INFLATING from resource: " + resource);
        //XmlResourceParser parser = getContext().getResources().getXml(resource);
        //try {
            //return inflate(parser, root, attachToRoot);
        //} finally {
            //parser.close();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.523 -0400", hash_original_method = "93981E75696898B46E3B07FB71CA5701", hash_generated_method = "AED62287C02DAC2AF61C450AC99D7621")
    public T inflate(XmlPullParser parser, P root,
            boolean attachToRoot) {
        T varB4EAC82CA7396A68D541C85D26508E83_122105555 = null; //Variable for return #1
        {
            AttributeSet attrs;
            attrs = Xml.asAttributeSet(parser);
            mConstructorArgs[0] = mContext;
            T result;
            result = (T) root;
            try 
            {
                int type;
                {
                    boolean var41639DC9639CF1CFBBBC344008E02D90_1833913807 = ((type = parser.next()) != parser.START_TAG
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
                T xmlRoot;
                xmlRoot = createItemFromTag(parser, parser.getName(),
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
            varB4EAC82CA7396A68D541C85D26508E83_122105555 = result;
        } //End block
        addTaint(parser.getTaint());
        addTaint(root.getTaint());
        addTaint(attachToRoot);
        varB4EAC82CA7396A68D541C85D26508E83_122105555.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_122105555;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.537 -0400", hash_original_method = "AB0D32CECCD43C7D0F0360210FD11363", hash_generated_method = "F34F753BD119F6A00772753F012DEBD2")
    public final T createItem(String name, String prefix, AttributeSet attrs) throws ClassNotFoundException, InflateException {
        T varB4EAC82CA7396A68D541C85D26508E83_1334096128 = null; //Variable for return #1
        Constructor constructor;
        constructor = (Constructor) sConstructorMap.get(name);
        try 
        {
            {
                Class clazz;
                clazz = mContext.getClassLoader().loadClass(
                        prefix != null ? (prefix + name) : name);//DSFIXME:  CODE0008: Nested ternary operator in expression
                constructor = clazz.getConstructor(mConstructorSignature);
                sConstructorMap.put(name, constructor);
            } //End block
            Object[] args;
            args = mConstructorArgs;
            args[1] = attrs;
            varB4EAC82CA7396A68D541C85D26508E83_1334096128 = (T) constructor.newInstance(args);
        } //End block
        catch (NoSuchMethodException e)
        {
            InflateException ie;
            ie = new InflateException(attrs
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
            InflateException ie;
            ie = new InflateException(attrs
                    .getPositionDescription()
                    + ": Error inflating class "
                    + constructor.getClass().getName());
            ie.initCause(e);
            if (DroidSafeAndroidRuntime.control) throw ie;
        } //End block
        addTaint(name.getTaint());
        addTaint(prefix.getTaint());
        addTaint(attrs.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1334096128.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1334096128;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.545 -0400", hash_original_method = "4FBBE2487A51D08C4064228D927262EC", hash_generated_method = "9309A2E7F0021F3716B5176F5B9552F7")
    protected T onCreateItem(String name, AttributeSet attrs) throws ClassNotFoundException {
        //DSFIXME:  CODE0009: Possible callback target function detected
        T varB4EAC82CA7396A68D541C85D26508E83_947723203 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_947723203 = createItem(name, mDefaultPackage, attrs);
        addTaint(name.getTaint());
        addTaint(attrs.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_947723203.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_947723203;
        // ---------- Original Method ----------
        //return createItem(name, mDefaultPackage, attrs);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.565 -0400", hash_original_method = "8A20619C5B186F5C05E29B17BC664D21", hash_generated_method = "1D12D70F5678A568E6FCB570D5DDBF68")
    private final T createItemFromTag(XmlPullParser parser, String name, AttributeSet attrs) {
        T varB4EAC82CA7396A68D541C85D26508E83_1189661079 = null; //Variable for return #1
        System.out.println("******** Creating item: " + name);
        try 
        {
            T item;
            item = null;
            item = mFactory.onCreateItem(name, mContext, attrs);
            {
                {
                    boolean var8670E3C6635B63F51E108DA3DA62F822_1135704115 = (-1 == name.indexOf('.'));
                    {
                        item = onCreateItem(name, attrs);
                    } //End block
                    {
                        item = createItem(name, null, attrs);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            System.out.println("Created item is: " + item);
            varB4EAC82CA7396A68D541C85D26508E83_1189661079 = item;
        } //End block
        catch (InflateException e)
        {
            if (DroidSafeAndroidRuntime.control) throw e;
        } //End block
        catch (ClassNotFoundException e)
        {
            InflateException ie;
            ie = new InflateException(attrs
                    .getPositionDescription()
                    + ": Error inflating class " + name);
            ie.initCause(e);
            if (DroidSafeAndroidRuntime.control) throw ie;
        } //End block
        catch (Exception e)
        {
            InflateException ie;
            ie = new InflateException(attrs
                    .getPositionDescription()
                    + ": Error inflating class " + name);
            ie.initCause(e);
            if (DroidSafeAndroidRuntime.control) throw ie;
        } //End block
        addTaint(parser.getTaint());
        addTaint(name.getTaint());
        addTaint(attrs.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1189661079.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1189661079;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.566 -0400", hash_original_method = "DD09A710ED93B5E593984A56AAF093F3", hash_generated_method = "4A80B857200E07E398A6FF2C80FF17CD")
    private void rInflate(XmlPullParser parser, T parent, final AttributeSet attrs) throws XmlPullParserException, IOException {
        int depth;
        depth = parser.getDepth();
        int type;
        {
            boolean var012C358A24678B056366BFE377DE0D0B_1142599346 = (((type = parser.next()) != parser.END_TAG || 
                parser.getDepth() > depth) && type != parser.END_DOCUMENT);
            {
                {
                    boolean var4336BB9E2F3F5A169909027B9F509E99_488595122 = (onCreateCustomFromTag(parser, parent, attrs));
                } //End collapsed parenthetic
                {
                    System.out.println("Now inflating tag: " + parser.getName());
                } //End block
                String name;
                name = parser.getName();
                T item;
                item = createItemFromTag(parser, name, attrs);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.570 -0400", hash_original_method = "19860FA740DE510446609E99D1C237FB", hash_generated_method = "BB71EDF906D877CBF0641F269BA34B24")
    protected boolean onCreateCustomFromTag(XmlPullParser parser, T parent,
            final AttributeSet attrs) throws XmlPullParserException {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(parser.getTaint());
        addTaint(parent.getTaint());
        addTaint(attrs.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_76496355 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_76496355;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.589 -0400", hash_original_method = "5E31CC12237E180F4815989ECA3F6501", hash_generated_method = "5E27E0ECB422312580791FB006F81F38")
    protected P onMergeRoots(P givenRoot, boolean attachToGivenRoot, P xmlRoot) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        P varB4EAC82CA7396A68D541C85D26508E83_2066765943 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2066765943 = xmlRoot;
        addTaint(givenRoot.getTaint());
        addTaint(attachToGivenRoot);
        addTaint(xmlRoot.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2066765943.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2066765943;
        // ---------- Original Method ----------
        //return xmlRoot;
    }

    
    private static class FactoryMerger<T> implements Factory<T> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.589 -0400", hash_original_field = "B388ED792FF72DF72B1BCDB08C954A34", hash_generated_field = "C926E99D17BAF92FDF4D7BA2DC2DD9F0")

        private Factory<T> mF1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.589 -0400", hash_original_field = "D2F7236B8084EBD38FEB109B60093F59", hash_generated_field = "B5C59E0FE8A8E61FE994C8B9CBE70464")

        private Factory<T> mF2;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.590 -0400", hash_original_method = "8268493149B8E87B72D799F680E0E2F1", hash_generated_method = "FB850E006E1460B7A165BF692F36AEC9")
          FactoryMerger(Factory<T> f1, Factory<T> f2) {
            mF1 = f1;
            mF2 = f2;
            // ---------- Original Method ----------
            //mF1 = f1;
            //mF2 = f2;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.591 -0400", hash_original_method = "361561DAAA3A2CCBFCF79A32350158C1", hash_generated_method = "7834542C8CD581ED86171C45AB0542B0")
        public T onCreateItem(String name, Context context, AttributeSet attrs) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            T varB4EAC82CA7396A68D541C85D26508E83_2067780850 = null; //Variable for return #1
            T varB4EAC82CA7396A68D541C85D26508E83_700752960 = null; //Variable for return #2
            T v;
            v = mF1.onCreateItem(name, context, attrs);
            varB4EAC82CA7396A68D541C85D26508E83_2067780850 = v;
            varB4EAC82CA7396A68D541C85D26508E83_700752960 = mF2.onCreateItem(name, context, attrs);
            addTaint(name.getTaint());
            addTaint(context.getTaint());
            addTaint(attrs.getTaint());
            T varA7E53CE21691AB073D9660D615818899_1871566170; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_1871566170 = varB4EAC82CA7396A68D541C85D26508E83_2067780850;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1871566170 = varB4EAC82CA7396A68D541C85D26508E83_700752960;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1871566170.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_1871566170;
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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.591 -0400", hash_original_field = "1125430DAA7CF8795E7D402DB0D83E08", hash_generated_field = "0BCE1CA1D2E11FADF49B0812907266C6")

    private static Class[] mConstructorSignature = new Class[] {
            Context.class, AttributeSet.class};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.594 -0400", hash_original_field = "ED0AF6FEF41982C7629A46F07C222461", hash_generated_field = "8D14A6DD11C8EE167D03D35B8EA548B8")

    private static HashMap sConstructorMap = new HashMap();
}

