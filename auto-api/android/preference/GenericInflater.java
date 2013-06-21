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
    private boolean DEBUG = false;
    protected Context mContext;
    private boolean mFactorySet;
    private Factory<T> mFactory;
    private Object[] mConstructorArgs = new Object[2];
    private String mDefaultPackage;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.558 -0400", hash_original_method = "A8AA332702376B454A767A9414B9F159", hash_generated_method = "34858EE356C8FBD996ECAC053246A935")
    @DSModeled(DSC.SAFE)
    protected GenericInflater(Context context) {
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
        //mContext = context;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.558 -0400", hash_original_method = "6B35BDBE0F984168A951D53A5AF8F867", hash_generated_method = "BFBF1EDE10060A97E16DA8CE067F0DA4")
    @DSModeled(DSC.SAFE)
    protected GenericInflater(GenericInflater<T,P> original, Context newContext) {
        dsTaint.addTaint(newContext.dsTaint);
        dsTaint.addTaint(original.dsTaint);
        mFactory = original.mFactory;
        // ---------- Original Method ----------
        //mContext = newContext;
        //mFactory = original.mFactory;
    }

    
    public abstract GenericInflater cloneInContext(Context newContext);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.558 -0400", hash_original_method = "601AA595429A3B000CED526A81A8472C", hash_generated_method = "E8BEDCD5BD59FA2B451940593AC9503B")
    @DSModeled(DSC.SAFE)
    public void setDefaultPackage(String defaultPackage) {
        dsTaint.addTaint(defaultPackage);
        // ---------- Original Method ----------
        //mDefaultPackage = defaultPackage;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.559 -0400", hash_original_method = "46E608B0485504B383BE067A0BD6622F", hash_generated_method = "B782C7AA24E689575A247359EAFBF343")
    @DSModeled(DSC.SAFE)
    public String getDefaultPackage() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mDefaultPackage;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.559 -0400", hash_original_method = "4F4EBC54D108D66F416C93B46580E117", hash_generated_method = "DFA42A6C39C27C217BA4B1F8A6817BD5")
    @DSModeled(DSC.SAFE)
    public Context getContext() {
        return (Context)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mContext;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.559 -0400", hash_original_method = "E145074F4BEE68EC84A4CE1558E8DDDD", hash_generated_method = "99FAAD384C5F3993FE5FD7AD2DC59156")
    @DSModeled(DSC.SAFE)
    public final Factory<T> getFactory() {
        return (Factory<T>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mFactory;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.559 -0400", hash_original_method = "F731ABA6658EE884292BF19729B20DA7", hash_generated_method = "4EAC1319E1992CA0DB2D33F642D3DD49")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setFactory(Factory<T> factory) {
        dsTaint.addTaint(factory.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("" +
            		"A factory has already been set on this inflater");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("Given factory can not be null");
        } //End block
        mFactorySet = true;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.560 -0400", hash_original_method = "0AF1546F925E79A6FCD8229E5389F782", hash_generated_method = "8BA76AA4AA86B717DD2C3A4433BD6679")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public T inflate(int resource, P root) {
        dsTaint.addTaint(root.dsTaint);
        dsTaint.addTaint(resource);
        T var031DD9EF175B5FBA685075E8A859A337_1250009152 = (inflate(resource, root, root != null));
        return (T)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return inflate(resource, root, root != null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.560 -0400", hash_original_method = "A09A6320AB1158C141A52528AA964FE1", hash_generated_method = "EF03BDA15A8ED5476D8A59980050C7BA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public T inflate(XmlPullParser parser, P root) {
        dsTaint.addTaint(root.dsTaint);
        dsTaint.addTaint(parser.dsTaint);
        T var96E73414297E9D05887A7B86A6E5B7D6_2895305 = (inflate(parser, root, root != null));
        return (T)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return inflate(parser, root, root != null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.560 -0400", hash_original_method = "C3BB64443334F9B40F1AFC79B102744E", hash_generated_method = "1382550BFE3273EA56D4A336B7D856E2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public T inflate(int resource, P root, boolean attachToRoot) {
        dsTaint.addTaint(attachToRoot);
        dsTaint.addTaint(root.dsTaint);
        dsTaint.addTaint(resource);
        System.out.println("INFLATING from resource: " + resource);
        XmlResourceParser parser;
        parser = getContext().getResources().getXml(resource);
        try 
        {
            T varD69941774B3894F6A25C989046D90FE4_935949942 = (inflate(parser, root, attachToRoot));
        } //End block
        finally 
        {
            parser.close();
        } //End block
        return (T)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (DEBUG) System.out.println("INFLATING from resource: " + resource);
        //XmlResourceParser parser = getContext().getResources().getXml(resource);
        //try {
            //return inflate(parser, root, attachToRoot);
        //} finally {
            //parser.close();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.561 -0400", hash_original_method = "93981E75696898B46E3B07FB71CA5701", hash_generated_method = "748CD092E09E7A24F5430473472AFC19")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public T inflate(XmlPullParser parser, P root,
            boolean attachToRoot) {
        dsTaint.addTaint(attachToRoot);
        dsTaint.addTaint(root.dsTaint);
        dsTaint.addTaint(parser.dsTaint);
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
                    boolean var41639DC9639CF1CFBBBC344008E02D90_1852388123 = ((type = parser.next()) != parser.START_TAG
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
        } //End block
        return (T)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.561 -0400", hash_original_method = "AB0D32CECCD43C7D0F0360210FD11363", hash_generated_method = "091DA9717CC81B56D7522240550ACF46")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final T createItem(String name, String prefix, AttributeSet attrs) throws ClassNotFoundException, InflateException {
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(prefix);
        dsTaint.addTaint(name);
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
            T var1BAA0204095B41898215F80564843730_674410042 = ((T) constructor.newInstance(args));
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
        return (T)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.562 -0400", hash_original_method = "4FBBE2487A51D08C4064228D927262EC", hash_generated_method = "44180CAC3D74CB87C7C621DE92A39620")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected T onCreateItem(String name, AttributeSet attrs) throws ClassNotFoundException {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(name);
        T varE311856C8A8CCFEA9FF4E72FD2C11CC3_233413435 = (createItem(name, mDefaultPackage, attrs));
        return (T)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return createItem(name, mDefaultPackage, attrs);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.562 -0400", hash_original_method = "8A20619C5B186F5C05E29B17BC664D21", hash_generated_method = "A85ED7C1496102D375ED660AA6D1187B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private final T createItemFromTag(XmlPullParser parser, String name, AttributeSet attrs) {
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(name);
        dsTaint.addTaint(parser.dsTaint);
        System.out.println("******** Creating item: " + name);
        try 
        {
            T item;
            item = null;
            item = mFactory.onCreateItem(name, mContext, attrs);
            {
                {
                    boolean var8670E3C6635B63F51E108DA3DA62F822_1463335857 = (-1 == name.indexOf('.'));
                    {
                        item = onCreateItem(name, attrs);
                    } //End block
                    {
                        item = createItem(name, null, attrs);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            System.out.println("Created item is: " + item);
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
        return (T)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.563 -0400", hash_original_method = "DD09A710ED93B5E593984A56AAF093F3", hash_generated_method = "0E7F84E1C80C0CD9FB46FB81A70E8373")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void rInflate(XmlPullParser parser, T parent, final AttributeSet attrs) throws XmlPullParserException, IOException {
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(parent.dsTaint);
        dsTaint.addTaint(parser.dsTaint);
        int depth;
        depth = parser.getDepth();
        int type;
        {
            boolean var012C358A24678B056366BFE377DE0D0B_1609504329 = (((type = parser.next()) != parser.END_TAG || 
                parser.getDepth() > depth) && type != parser.END_DOCUMENT);
            {
                {
                    boolean var4336BB9E2F3F5A169909027B9F509E99_626554674 = (onCreateCustomFromTag(parser, parent, attrs));
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.563 -0400", hash_original_method = "19860FA740DE510446609E99D1C237FB", hash_generated_method = "BDEA94BA9FD76EF4488A997A5602A956")
    @DSModeled(DSC.SAFE)
    protected boolean onCreateCustomFromTag(XmlPullParser parser, T parent,
            final AttributeSet attrs) throws XmlPullParserException {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(parent.dsTaint);
        dsTaint.addTaint(parser.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.563 -0400", hash_original_method = "5E31CC12237E180F4815989ECA3F6501", hash_generated_method = "9ADEF39D6339370656C96E37A6E71CB9")
    @DSModeled(DSC.SAFE)
    protected P onMergeRoots(P givenRoot, boolean attachToGivenRoot, P xmlRoot) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(givenRoot.dsTaint);
        dsTaint.addTaint(xmlRoot.dsTaint);
        dsTaint.addTaint(attachToGivenRoot);
        return (P)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return xmlRoot;
    }

    
    private static class FactoryMerger<T> implements Factory<T> {
        private Factory<T> mF1, mF2;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.563 -0400", hash_original_method = "8268493149B8E87B72D799F680E0E2F1", hash_generated_method = "E890E60ED8F620EFC87629086AC1B580")
        @DSModeled(DSC.SAFE)
         FactoryMerger(Factory<T> f1, Factory<T> f2) {
            dsTaint.addTaint(f1.dsTaint);
            dsTaint.addTaint(f2.dsTaint);
            // ---------- Original Method ----------
            //mF1 = f1;
            //mF2 = f2;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.564 -0400", hash_original_method = "361561DAAA3A2CCBFCF79A32350158C1", hash_generated_method = "524691DB525EFC283C275998A9EF9B6C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public T onCreateItem(String name, Context context, AttributeSet attrs) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(attrs.dsTaint);
            dsTaint.addTaint(name);
            dsTaint.addTaint(context.dsTaint);
            T v;
            v = mF1.onCreateItem(name, context, attrs);
            T var21620120FFB76A6804833A90D87C5120_769656053 = (mF2.onCreateItem(name, context, attrs));
            return (T)dsTaint.getTaint();
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
    
    private static final Class[] mConstructorSignature = new Class[] {
            Context.class, AttributeSet.class};
    private static final HashMap sConstructorMap = new HashMap();
}

